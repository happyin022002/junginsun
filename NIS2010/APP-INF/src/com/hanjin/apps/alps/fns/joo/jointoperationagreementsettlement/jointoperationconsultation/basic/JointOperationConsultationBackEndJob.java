/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationBackEndJob.java
*@FileTitle : 공동운항 CSR Approval BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.16 박희동
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2011.04.07 이준범[CHM-201110018-01] CSR Approval 승인 취소시에 기능 보완
*            JOO_TAX_DTL 삭제 후에 JOO_TAX 삭제 하도록 변경
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic;

import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationEAIDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArMnChgVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvDtrbVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvHdrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ALPS-JointOperationConsultation Long Transaction Business Logic <br>
 * - ALPS-JointOperationConsultation에 대한 Long Transaction 비지니스 로직<br>
 *
 * @author Park Hee Dong
 * @see fns_joo_0023EventResponse 참조
 * @since J2EE 1.6
 */
public class JointOperationConsultationBackEndJob extends BackEndCommandSupport {

	private JointOperationConsultationDBDAO dbDao;
	private JointOperationConsultationEAIDAO eaiDao;

	private CsrVO csrVO = null;
	private SignOnUserAccount signOnUserAccount = null;
	private String jobFlg = null;	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8147235726645301281L;
	
	/**
	 * Main Start
	 * @return List<CsrVO>
	 * @throws Exception
	 */
	public List<CsrVO> doStart() throws Exception {
		//2011-12-06 [소스품질 조치사항]사용하지 않는 지역 변수를 점검한다.
		//List<CsrVO> listRtn = null;		
		String chkLoclAmt = "";		
		
        try{
	        dbDao  = new JointOperationConsultationDBDAO();

	        csrVO.setUpdUsrId(signOnUserAccount.getUsr_id());

			dbDao.modifyComAproRqstRout(csrVO);
			dbDao.modifyComAproRqstHdr (csrVO);			
			dbDao.manageGW(csrVO);			// GW update
									
			// 중간 결재가 취소 일때 Cancel 처리
			if("Y".equals(csrVO.getCxlFlg())){
				dbDao.modifyCsr(csrVO);				
			}			
			log.debug("csrVO.getCxlFlg() = "+csrVO.getCxlFlg());
			log.debug("csrVO.getLstAproFlg() = "+csrVO.getLstAproFlg());			
						
			//반려 이면 최종결재권자 여부 상관없이 cancel처리하고 (2010.01.29 박효숙 차장)  승인인경우 최종 결재권자가 아니면 approval step process 만 처리한다.
//			if (	!"Y".equals(csrVO.getCxlFlg()) &&
//					!"Y".equals(csrVO.getLstAproFlg())
//				){
//					//return listRtn;	2011-11-18 [소스품질 조치사항]객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
//					return null;
//			}
						
			if (!"Y".equals(csrVO.getCxlFlg())){				// 취소가 아니고
				if(!"Y".equals(csrVO.getLstAproFlg())){	// 최종결재자가 아니고
					return null;
				}
        	}
									
			dbDao.modifyCsr(csrVO);
			
			String csrNo = csrVO.getCsrNo();
			
			//승인된 건이면 EAI를 통해 처리한다.
			//최종승인된 건이면 EAI를 통해 처리한다.(2015.05.12)
			if ("Y".equals(csrVO.getAproFlg()) && "Y".equals(csrVO.getLstAproFlg())){
		        eaiDao = new JointOperationConsultationEAIDAO();	        
				//AR인 경우
				if ("18".equals(csrNo.substring(0,2))){
			        log.debug("doStart-5-AR");				
					List<ArMnChgVO> list = dbDao.searchArInfoForApproval(csrVO);
					
					Iterator iterator = list.iterator();
					
					ArMnChgVO arMnChgVO = null;
					
					int seq = 0;
					String arIfNo = "";
					
					boolean isFirst = true;
					while(iterator.hasNext()){
						arMnChgVO = (ArMnChgVO)iterator.next();
						arMnChgVO.setUsrId(signOnUserAccount.getUsr_id());
						
						if (isFirst){
							seq = Integer.parseInt(arMnChgVO.getArIfNo());
							isFirst = false;
						}
						
						seq++;
						arIfNo = "JOO"+JSPUtil.getLPAD(seq+"", 7, "0");
						arMnChgVO.setArIfNo(arIfNo);
						//JOO_AR_MN 테이블에 INSERT한다.
						dbDao.addJooArMn(arMnChgVO);
						
						//JOO_AR_CHG 테이블에 INSERT한다.
						dbDao.addJooArChg(arMnChgVO);
					}
					//==========================================
					// ERP로 전송한다.
					//==========================================
					
					//검증추가 : 이중 결재 여부 조사
					chkLoclAmt = dbDao.chkLoclAmt(csrNo);
					if("Y".equals(chkLoclAmt)){						
						throw new EventException(new ErrorHandler("COM12225", new String[]{"Double payment"}).getMessage());
					}else{
						if("Y".equals(csrVO.getLstAproFlg())){			// 최종 결재자만 ERP전송	
							eaiDao.sendSlipApprovalToAR(csrNo, list);
						}
					}
				//AP인 경우
				}else{
			        log.debug("doStart-6-AP");					
					List<InvHdrVO>  list  = dbDao.searchApHeaderInfoForApproval(csrVO);
					List<InvDtrbVO> list1 = dbDao.searchApDetailInfoForApproval(csrVO);
					
					InvHdrVO invHdrVO = list.get(0);
					invHdrVO.setCreUsrId(signOnUserAccount.getUsr_id());
					
					//AP_INV_HDR에 INSERT
					dbDao.addApInvHdr(invHdrVO);
					

					InvDtrbVO invDtrbVO = null;
					//InvIfVO invIfVO = null;
					//int totCnt = list1.size();

					for (int i=0; i < list1.size(); i++){
						invDtrbVO = list1.get(i);

						invDtrbVO.setCreUsrId(signOnUserAccount.getUsr_id());
						//AP_INV_DTRB에 INSERT
						dbDao.addApInvDtrb(invDtrbVO);
//2010.03.16 AP_INV_IF 테이블이 없어졌다?????						
//						invIfVO = new InvIfVO();
//						setInvIfVO(invIfVO, invHdrVO, invDtrbVO, totCnt, i+1);
//						//AP_INV_IF에 INSERT
//						dbDao.addApInvIf(invIfVO);
					}
					
					//==========================================
					// ERP로 전송한다.
					//==========================================
//					chkLoclAmt = dbDao.chkLoclAmt(csrNo);
//					log.debug("chkLoclAmt = "+chkLoclAmt);
//					if("Y".equals(chkLoclAmt)){
//						log.debug("chkLoclAmt = "+chkLoclAmt);						
//						throw new EventException(new ErrorHandler("COM12225", new String[]{"Double payment"}).getMessage());
//					}else{					
						//Agreement 존재여부 Flag 추가 2014.12.09 민정호
					
						// AP는 중복에러가 발생되므로, 이중결재가 되지 않음 20150518
						String agmtCntYn = dbDao.searchAgmtCfmCd(csrNo);		
						if("Y".equals(csrVO.getLstAproFlg())){			// 최종 결재자만 ERP전송
							eaiDao.sendSlipApprovalToAP(csrNo, list, list1, agmtCntYn);
						}
//					}
				}
			}
			
	        log.debug("doStart-7");			
			//cancel 된 건이면 CSR No로 slip, tax master, tax detail을 모두 삭제한다.
			//2011.04.07 이준범[CHM-201110018-01] dbDao.removeTaxByCsr, removeTaxDtlByCsr 호출 순서 변경
			if ("Y".equals(csrVO.getCxlFlg())){
				log.debug("Cancel-2");
				dbDao.removeSlipByCsr          (csrVO);
				dbDao.removeTaxDtlByCsr        (csrVO);
				dbDao.removeTaxByCsr           (csrVO);				
				dbDao.modifyJooStlCmbClearCsrNo(csrVO);
			}
	        
        }catch(Exception e){
        	super.log.error(e.getMessage());
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR AP Creation", ""}).getMessage(), e);
        }
        //return listRtn;		2011-11-30 [소스품질 조치사항]객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
		return null;
	}

	/**
	 * SignOnUserAccount setting
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setSignOnUserAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}

	/**
	 * JOB FLAG setting
	 * @param String jobFlg
	 */
	public void setJobFlg(String jobFlg){
		this.jobFlg = jobFlg;
	}

	/**
	 * CsrVO setting
	 * @param CsrVO csrVO
	 */
	public void setCsrVO(CsrVO csrVO){
		this.csrVO = csrVO;
	}


	/**
	 * InvHdrVO, InvDtrbVO로 InvIfVO를 생성한다.
	 * @param InvIfVO invIfVO
	 * @param InvHdrVO invHdrVO
	 * @param InvDtrbVO invDtrbVO
	 * @param int totCnt
	 * @param int inx
	 * @throws EventException
	 */
//	private void setInvIfVO(InvIfVO invIfVO, InvHdrVO invHdrVO, InvDtrbVO invDtrbVO, int totCnt, int inx) throws EventException{
//		try{
//			invIfVO.setApPgmNo          ("ESDJOOXXXYYYYMMDD");
//			invIfVO.setInvSeq           ("1");
//			invIfVO.setTtlRowKnt        (totCnt+"");
//			invIfVO.setRowKnt           (inx+"");
//			invIfVO.setHdrCsrNo         (invHdrVO .getCsrNo            ());
//			invIfVO.setHdrCsrTpCd       (invHdrVO .getCsrTpCd          ());
//			invIfVO.setHdrInvDt         (invHdrVO .getInvDt            ());
//			invIfVO.setHdrInvTermDt     (invHdrVO .getInvTermDt        ());
//			invIfVO.setHdrGlDt          (invHdrVO .getGlDt             ());
//			invIfVO.setHdrVndrNo        (invHdrVO .getVndrNo           ());
//			invIfVO.setHdrCsrAmt        (invHdrVO .getCsrAmt           ());
//			invIfVO.setHdrPayAmt        (invHdrVO .getPayAmt           ());
//			invIfVO.setHdrPayDt         (invHdrVO .getPayDt            ());
//			invIfVO.setHdrCsrCurrCd     (invHdrVO .getCsrCurrCd        ());
//			invIfVO.setHdrVndrTermNm    (invHdrVO .getVndrTermNm       ());
//			invIfVO.setHdrInvDesc       (invHdrVO .getInvDesc          ());
//			invIfVO.setHdrAttrCateNm    (invHdrVO .getAttrCateNm       ());
//			invIfVO.setHdrAttrCtnt1     (invHdrVO .getAttrCtnt1        ());
//			invIfVO.setHdrAttrCtnt2     (invHdrVO .getAttrCtnt2        ());
//			invIfVO.setHdrAttrCtnt3     (invHdrVO .getAttrCtnt3        ());
//			invIfVO.setHdrAttrCtnt4     (invHdrVO .getAttrCtnt4        ());
//			invIfVO.setHdrAttrCtnt5     (invHdrVO .getAttrCtnt5        ());
//			invIfVO.setHdrAttrCtnt6     (invHdrVO .getAttrCtnt6        ());
//			invIfVO.setHdrAttrCtnt7     (invHdrVO .getAttrCtnt7        ());
//			invIfVO.setHdrAttrCtnt8     (invHdrVO .getAttrCtnt8        ());
//			invIfVO.setHdrAttrCtnt9     (invHdrVO .getAttrCtnt9        ());
//			invIfVO.setHdrAttrCtnt10    (invHdrVO .getAttrCtnt10       ());
//			invIfVO.setHdrAttrCtnt11    (invHdrVO .getAttrCtnt11       ());
//			invIfVO.setHdrAttrCtnt12    (invHdrVO .getAttrCtnt12       ());
//			invIfVO.setHdrAttrCtnt13    (invHdrVO .getAttrCtnt13       ());
//			invIfVO.setHdrAttrCtnt14    (invHdrVO .getAttrCtnt14       ());
//			invIfVO.setHdrAttrCtnt15    (invHdrVO .getAttrCtnt15       ());
//			invIfVO.setHdrGloAttrCtnt1  (invHdrVO .getGloAttrCtnt1     ());
//			invIfVO.setHdrGloAttrCtnt2  (invHdrVO .getGloAttrCtnt2     ());
//			invIfVO.setHdrGloAttrCtnt3  (invHdrVO .getGloAttrCtnt3     ());
//			invIfVO.setHdrGloAttrCtnt4  (invHdrVO .getGloAttrCtnt4     ());
//			invIfVO.setHdrGloAttrCtnt5  (invHdrVO .getGloAttrCtnt5     ());
//			invIfVO.setHdrGloAttrCtnt6  (invHdrVO .getGloAttrCtnt6     ());
//			invIfVO.setHdrGloAttrCtnt7  (invHdrVO .getGloAttrCtnt7     ());
//			invIfVO.setHdrGloAttrCtnt8  (invHdrVO .getGloAttrCtnt8     ());
//			invIfVO.setHdrGloAttrCtnt9  (invHdrVO .getGloAttrCtnt9     ());
//			invIfVO.setHdrGloAttrCtnt10 (invHdrVO .getGloAttrCtnt10    ());
//			invIfVO.setHdrGloAttrCtnt11 (invHdrVO .getGloAttrCtnt11    ());
//			invIfVO.setHdrGloAttrCtnt12 (invHdrVO .getGloAttrCtnt12    ());
//			invIfVO.setHdrGloAttrCtnt13 (invHdrVO .getGloAttrCtnt13    ());
//			invIfVO.setHdrGloAttrCtnt14 (invHdrVO .getGloAttrCtnt14    ());
//			invIfVO.setHdrGloAttrCtnt15 (invHdrVO .getGloAttrCtnt15    ());
//			invIfVO.setHdrGloAttrCtnt16 (invHdrVO .getGloAttrCtnt16    ());
//			invIfVO.setHdrGloAttrCtnt17 (invHdrVO .getGloAttrCtnt17    ());
//			invIfVO.setHdrGloAttrCtnt18 (invHdrVO .getGloAttrCtnt18    ());
//			invIfVO.setHdrSrcCtnt       (invHdrVO .getSrcCtnt          ());
//			invIfVO.setHdrPayMzdLuCd    (invHdrVO .getPayMzdLuCd       ());
//			invIfVO.setHdrPayGrpLuCd    (invHdrVO .getPayGrpLuCd       ());
//			invIfVO.setHdrCoaCoCd       (invHdrVO .getCoaCoCd          ());
//			invIfVO.setHdrCoaRgnCd      (invHdrVO .getCoaRgnCd         ());
//			invIfVO.setHdrCoaCtrCd      (invHdrVO .getCoaCtrCd         ());
//			invIfVO.setHdrCoaAcctCd     (invHdrVO .getCoaAcctCd        ());
//			invIfVO.setHdrCoaVvdCd      (invHdrVO .getCoaVvdCd         ());
//			invIfVO.setHdrCoaInterCoCd  (invHdrVO .getCoaInterCoCd     ());
//			invIfVO.setHdrCoaFtuN1stCd  (invHdrVO .getCoaFtuN1stCd     ());
//			invIfVO.setHdrCoaFtuN2ndCd  (invHdrVO .getCoaFtuN2ndCd     ());
//			invIfVO.setHdrPpdNo         (invHdrVO .getPpdNo            ());
//			invIfVO.setHdrPpdDtrbNo     (invHdrVO .getPpdDtrbNo        ());
//			invIfVO.setHdrPpdAplyAmt    (invHdrVO .getPpdAplyAmt       ());
//			invIfVO.setHdrPpdGlDt       (invHdrVO .getPpdGlDt          ());
//			invIfVO.setHdrAproFlg       (invHdrVO .getAproFlg          ());
//			invIfVO.setHdrTaxDeclFlg    (invHdrVO .getTaxDeclFlg       ());
//			invIfVO.setHdrErrCsrNo      (invHdrVO .getErrCsrNo         ());
//			invIfVO.setHdrIfFlg         (invHdrVO .getIfFlg            ());
//			invIfVO.setHdrIfDt          (invHdrVO .getIfDt             ());
//			invIfVO.setHdrIfErrRsn      (invHdrVO .getIfErrRsn         ());
//			invIfVO.setHdrPpayAplyFlg   (invHdrVO .getPpayAplyFlg      ());
//			invIfVO.setHdrTjOfcCd       (invHdrVO .getTjOfcCd          ());
//			invIfVO.setHdrActXchRt      (invHdrVO .getActXchRt         ());
//			invIfVO.setHdrImpErrFlg     (invHdrVO .getImpErrFlg        ());
//			invIfVO.setHdrRcvErrFlg     (invHdrVO .getRcvErrFlg        ());
//			invIfVO.setHdrTaxCurrXchFlg (invHdrVO .getTaxCurrXchFlg    ());
//			invIfVO.setHdrUsrEml        (invHdrVO .getUsrEml           ());
//			invIfVO.setHdrImpErrRsn     (invHdrVO .getImpErrRsn        ());
//			invIfVO.setHdrRcvErrRsn     (invHdrVO .getRcvErrRsn        ());
//			invIfVO.setHdrFtuUseCtnt1   (invHdrVO .getFtuUseCtnt1      ());
//			invIfVO.setHdrFtuUseCtnt2   (invHdrVO .getFtuUseCtnt2      ());
//			invIfVO.setHdrFtuUseCtnt3   (invHdrVO .getFtuUseCtnt3      ());
//			invIfVO.setHdrFtuUseCtnt4   (invHdrVO .getFtuUseCtnt4      ());
//			invIfVO.setHdrFtuUseCtnt5   (invHdrVO .getFtuUseCtnt5      ());
//			invIfVO.setCsrNo            (invDtrbVO.getCsrNo            ());
//			invIfVO.setLineSeq          (invDtrbVO.getLineSeq          ());
//			invIfVO.setLineNo           (invDtrbVO.getLineNo           ());
//			invIfVO.setLineTpLuCd       (invDtrbVO.getLineTpLuCd       ());
//			invIfVO.setInvAmt           (invDtrbVO.getInvAmt           ());
//			invIfVO.setInvDesc          (invDtrbVO.getInvDesc          ());
//			invIfVO.setInvTaxCd         (invDtrbVO.getInvTaxCd         ());
//			invIfVO.setDtrbCoaCoCd      (invDtrbVO.getDtrbCoaCoCd      ());
//			invIfVO.setDtrbCoaRgnCd     (invDtrbVO.getDtrbCoaRgnCd     ());
//			invIfVO.setDtrbCoaCtrCd     (invDtrbVO.getDtrbCoaCtrCd     ());
//			invIfVO.setDtrbCoaAcctCd    (invDtrbVO.getDtrbCoaAcctCd    ());
//			invIfVO.setDtrbCoaVvdCd     (invDtrbVO.getDtrbCoaVvdCd     ());
//			invIfVO.setDtrbCoaInterCoCd (invDtrbVO.getDtrbCoaInterCoCd ());
//			invIfVO.setDtrbCoaFtuN1stCd (invDtrbVO.getDtrbCoaFtuN1stCd ());
//			invIfVO.setDtrbCoaFtuN2ndCd (invDtrbVO.getDtrbCoaFtuN2ndCd ());
//			invIfVO.setAttrCateNm       (invDtrbVO.getAttrCateNm       ());
//			invIfVO.setAttrCtnt1        (invDtrbVO.getAttrCtnt1        ());
//			invIfVO.setAttrCtnt2        (invDtrbVO.getAttrCtnt2        ());
//			invIfVO.setAttrCtnt3        (invDtrbVO.getAttrCtnt3        ());
//			invIfVO.setAttrCtnt4        (invDtrbVO.getAttrCtnt4        ());
//			invIfVO.setAttrCtnt5        (invDtrbVO.getAttrCtnt5        ());
//			invIfVO.setAttrCtnt6        (invDtrbVO.getAttrCtnt6        ());
//			invIfVO.setAttrCtnt7        (invDtrbVO.getAttrCtnt7        ());
//			invIfVO.setAttrCtnt8        (invDtrbVO.getAttrCtnt8        ());
//			invIfVO.setAttrCtnt9        (invDtrbVO.getAttrCtnt9        ());
//			invIfVO.setAttrCtnt10       (invDtrbVO.getAttrCtnt10       ());
//			invIfVO.setAttrCtnt11       (invDtrbVO.getAttrCtnt11       ());
//			invIfVO.setAttrCtnt12       (invDtrbVO.getAttrCtnt12       ());
//			invIfVO.setAttrCtnt13       (invDtrbVO.getAttrCtnt13       ());
//			invIfVO.setAttrCtnt14       (invDtrbVO.getAttrCtnt14       ());
//			invIfVO.setAttrCtnt15       (invDtrbVO.getAttrCtnt15       ());
//			invIfVO.setBkgNo            (invDtrbVO.getBkgNo            ());
//			invIfVO.setCntrTpszCd       (invDtrbVO.getCntrTpszCd       ());
//			invIfVO.setActVvdCd         (invDtrbVO.getActVvdCd         ());
//			invIfVO.setPlnSctrDivCd     (invDtrbVO.getPlnSctrDivCd     ());
//			invIfVO.setSoCrrCd          (invDtrbVO.getSoCrrCd          ());
//			invIfVO.setYdCd             (invDtrbVO.getYdCd             ());
//			invIfVO.setFtuUseCtnt1      (invDtrbVO.getFtuUseCtnt1      ());
//			invIfVO.setFtuUseCtnt2      (invDtrbVO.getFtuUseCtnt2      ());
//			invIfVO.setFtuUseCtnt3      (invDtrbVO.getFtuUseCtnt3      ());
//			invIfVO.setFtuUseCtnt4      (invDtrbVO.getFtuUseCtnt4      ());
//			invIfVO.setFtuUseCtnt5      (invDtrbVO.getFtuUseCtnt5      ());
//			invIfVO.setSndFlg           ("");
//			invIfVO.setCreDt            ("");
//			invIfVO.setCreUsrId         (invDtrbVO.getCreUsrId         ());
//			invIfVO.setEaiEvntDt        ("");
//			invIfVO.setEstmErrRsn       ("");
//			invIfVO.setTrspSoTpCd       ("");
//			invIfVO.setSoOfcCtyCd       ("");
//			invIfVO.setSoSeq            ("");
//			invIfVO.setCgoTpCd          ("");			                                          
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"VO Transfer", "SET"}).getMessage(), ex);
//		}
//	}
}
