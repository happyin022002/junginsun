/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationBackEndJob.java
*@FileTitle : Joint Operation CSR Approval BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationEAIDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArMnChgVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvDtrbVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvHdrVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-JointOperationConsultation Long Transaction Business Logic <br>
 *
 * @author
 * @see fns_joo_0023EventResponse
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
	public String doStart() throws Exception {
		
		String ifNo = "";
		
		try{
			
	        dbDao  = new JointOperationConsultationDBDAO();
	        
	        csrVO.setUpdUsrId(signOnUserAccount.getUsr_id());

			dbDao.modifyComAproRqstRout(csrVO);
			dbDao.modifyComAproRqstHdr (csrVO);

			if (!"Y".equals(csrVO.getCxlFlg()) && !"Y".equals(csrVO.getLstAproFlg())){
				return ifNo;
			}
			
			dbDao.modifyCsr(csrVO);

			String csrNo = csrVO.getCsrNo();
			
			if ("Y".equals(csrVO.getAproFlg())){
		        eaiDao = new JointOperationConsultationEAIDAO();	        
				if ("18".equals(csrNo.substring(0,2))) {
					
					AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
					
					List<OutstandingInterfaceVO> vosList = new ArrayList<OutstandingInterfaceVO>();
					
					List<ArMnChgVO> list = dbDao.searchArInfoForApproval(csrVO);
					
					Iterator iterator = list.iterator();
					
					ArMnChgVO arMnChgVO = null;
					
					int seq = 0;
					String arIfNo = "";
					
					boolean isFirst = true;
					StringBuffer sb = new StringBuffer();
					while (iterator.hasNext()) {
						arMnChgVO = (ArMnChgVO)iterator.next();
						arMnChgVO.setUsrId(signOnUserAccount.getUsr_id());
						
						if (isFirst){
							seq = Integer.parseInt(arMnChgVO.getArIfNo());
							isFirst = false;
						}
						
						seq++;
						arIfNo = "JOO"+JSPUtil.getLPAD(seq+"", 7, "0");
						arMnChgVO.setArIfNo(arIfNo);
						
						dbDao.addJooArMn(arMnChgVO);
						
						dbDao.addJooArChg(arMnChgVO);
						
						vosList.add(setSarOtsIf(arMnChgVO));
						
						sb.append(arIfNo);
						sb.append(arMnChgVO.getArIfSerNo());
						sb.append("||");
						//ifNo += arIfNo + arMnChgVO.getArIfSerNo() + "||";
					}
					ifNo = sb.toString();
					command.addOutstandingInterface(vosList);
					//eaiDao.sendSlipApprovalToAR(csrNo, list);
				} else {
					List<InvHdrVO>  list  = dbDao.searchApHeaderInfoForApproval(csrVO);
					//TODO NYK GAP 아래 DB 조회시 목록을 가져오는 방안으로 처리.
					//NYK Modify 2014.10.13
					//AP_INV_DTRB.ATTR_CTNT2 : CSR Date(FMS), Issue Date(JOO)
					//AP_INV_DTRB.ATTR_CTNT3 : Requested By(FMS), Issue Team(JOO)
					//AP_INV_DTRB.ATTR_CTNT14 : 아래 테이블 VVD연결하여 존재하는 경우만 추출하여 Interface
					List<InvDtrbVO> list1 = dbDao.searchApDetailInfoForApproval(csrVO);
					
					InvHdrVO invHdrVO = list.get(0);
					invHdrVO.setCreUsrId(signOnUserAccount.getUsr_id());
					
					dbDao.addApInvHdr(invHdrVO);
					
					InvDtrbVO invDtrbVO = null;
					//InvIfVO invIfVO = null;
					//int totCnt = list1.size();

					for (int i=0; i < list1.size(); i++){
						invDtrbVO = list1.get(i);

						invDtrbVO.setCreUsrId(signOnUserAccount.getUsr_id());
						
						//TODO : 2015.04.28 CSR 에서 제공되는 AR_MST_REV_VVD.SLAN_CD  한번더 조회 하도록 한다.
						//2015.04.28 Add vsl_slan_cd : CNT 추가.
						if(StringUtils.isEmpty(invDtrbVO.getAttrCtnt14())){
							invDtrbVO.setAttrCtnt14(JooConstants.DEFAULT_VSL_SLAN_CD);
						}
						//AP_INV_DTRB에 INSERT
						dbDao.addApInvDtrb(invDtrbVO);
					}
					//eaiDao.sendSlipApprovalToAP(csrNo, list, list1);
				}
			}
			
			if ("Y".equals(csrVO.getCxlFlg())){
				dbDao.removeSlipByCsr          (csrVO);
				dbDao.removeTaxByCsr           (csrVO);
				dbDao.removeTaxDtlByCsr        (csrVO);
				dbDao.modifyJooStlCmbClearCsrNo(csrVO);
			}
	        
        }catch(Exception e){
        	super.log.error(e.getMessage());
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR AP Creation", ""}).getMessage(), e);
        }
        return ifNo;
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
	 * @param InvIfVO invIfVO
	 * @param InvHdrVO invHdrVO
	 * @param InvDtrbVO invDtrbVO
	 * @param int totCnt
	 * @param int inx
	 * @throws EventException
	 */
	/*private void setInvIfVO(InvIfVO invIfVO, InvHdrVO invHdrVO, InvDtrbVO invDtrbVO, int totCnt, int inx) throws EventException{
		try{
			invIfVO.setApPgmNo          ("ESDJOOXXXYYYYMMDD");
			invIfVO.setInvSeq           ("1");
			invIfVO.setTtlRowKnt        (totCnt+"");
			invIfVO.setRowKnt           (inx+"");
			invIfVO.setHdrCsrNo         (invHdrVO .getCsrNo            ());
			invIfVO.setHdrCsrTpCd       (invHdrVO .getCsrTpCd          ());
			invIfVO.setHdrInvDt         (invHdrVO .getInvDt            ());
			invIfVO.setHdrInvTermDt     (invHdrVO .getInvTermDt        ());
			invIfVO.setHdrGlDt          (invHdrVO .getGlDt             ());
			invIfVO.setHdrVndrNo        (invHdrVO .getVndrNo           ());
			invIfVO.setHdrCsrAmt        (invHdrVO .getCsrAmt           ());
			invIfVO.setHdrPayAmt        (invHdrVO .getPayAmt           ());
			invIfVO.setHdrPayDt         (invHdrVO .getPayDt            ());
			invIfVO.setHdrCsrCurrCd     (invHdrVO .getCsrCurrCd        ());
			invIfVO.setHdrVndrTermNm    (invHdrVO .getVndrTermNm       ());
			invIfVO.setHdrInvDesc       (invHdrVO .getInvDesc          ());
			invIfVO.setHdrAttrCateNm    (invHdrVO .getAttrCateNm       ());
			invIfVO.setHdrAttrCtnt1     (invHdrVO .getAttrCtnt1        ());
			invIfVO.setHdrAttrCtnt2     (invHdrVO .getAttrCtnt2        ());
			invIfVO.setHdrAttrCtnt3     (invHdrVO .getAttrCtnt3        ());
			invIfVO.setHdrAttrCtnt4     (invHdrVO .getAttrCtnt4        ());
			invIfVO.setHdrAttrCtnt5     (invHdrVO .getAttrCtnt5        ());
			invIfVO.setHdrAttrCtnt6     (invHdrVO .getAttrCtnt6        ());
			invIfVO.setHdrAttrCtnt7     (invHdrVO .getAttrCtnt7        ());
			invIfVO.setHdrAttrCtnt8     (invHdrVO .getAttrCtnt8        ());
			invIfVO.setHdrAttrCtnt9     (invHdrVO .getAttrCtnt9        ());
			invIfVO.setHdrAttrCtnt10    (invHdrVO .getAttrCtnt10       ());
			invIfVO.setHdrAttrCtnt11    (invHdrVO .getAttrCtnt11       ());
			invIfVO.setHdrAttrCtnt12    (invHdrVO .getAttrCtnt12       ());
			invIfVO.setHdrAttrCtnt13    (invHdrVO .getAttrCtnt13       ());
			invIfVO.setHdrAttrCtnt14    (invHdrVO .getAttrCtnt14       ());
			invIfVO.setHdrAttrCtnt15    (invHdrVO .getAttrCtnt15       ());
			invIfVO.setHdrGloAttrCtnt1  (invHdrVO .getGloAttrCtnt1     ());
			invIfVO.setHdrGloAttrCtnt2  (invHdrVO .getGloAttrCtnt2     ());
			invIfVO.setHdrGloAttrCtnt3  (invHdrVO .getGloAttrCtnt3     ());
			invIfVO.setHdrGloAttrCtnt4  (invHdrVO .getGloAttrCtnt4     ());
			invIfVO.setHdrGloAttrCtnt5  (invHdrVO .getGloAttrCtnt5     ());
			invIfVO.setHdrGloAttrCtnt6  (invHdrVO .getGloAttrCtnt6     ());
			invIfVO.setHdrGloAttrCtnt7  (invHdrVO .getGloAttrCtnt7     ());
			invIfVO.setHdrGloAttrCtnt8  (invHdrVO .getGloAttrCtnt8     ());
			invIfVO.setHdrGloAttrCtnt9  (invHdrVO .getGloAttrCtnt9     ());
			invIfVO.setHdrGloAttrCtnt10 (invHdrVO .getGloAttrCtnt10    ());
			invIfVO.setHdrGloAttrCtnt11 (invHdrVO .getGloAttrCtnt11    ());
			invIfVO.setHdrGloAttrCtnt12 (invHdrVO .getGloAttrCtnt12    ());
			invIfVO.setHdrGloAttrCtnt13 (invHdrVO .getGloAttrCtnt13    ());
			invIfVO.setHdrGloAttrCtnt14 (invHdrVO .getGloAttrCtnt14    ());
			invIfVO.setHdrGloAttrCtnt15 (invHdrVO .getGloAttrCtnt15    ());
			invIfVO.setHdrGloAttrCtnt16 (invHdrVO .getGloAttrCtnt16    ());
			invIfVO.setHdrGloAttrCtnt17 (invHdrVO .getGloAttrCtnt17    ());
			invIfVO.setHdrGloAttrCtnt18 (invHdrVO .getGloAttrCtnt18    ());
			invIfVO.setHdrSrcCtnt       (invHdrVO .getSrcCtnt          ());
			invIfVO.setHdrPayMzdLuCd    (invHdrVO .getPayMzdLuCd       ());
			invIfVO.setHdrPayGrpLuCd    (invHdrVO .getPayGrpLuCd       ());
			invIfVO.setHdrCoaCoCd       (invHdrVO .getCoaCoCd          ());
			invIfVO.setHdrCoaRgnCd      (invHdrVO .getCoaRgnCd         ());
			invIfVO.setHdrCoaCtrCd      (invHdrVO .getCoaCtrCd         ());
			invIfVO.setHdrCoaAcctCd     (invHdrVO .getCoaAcctCd        ());
			invIfVO.setHdrCoaVvdCd      (invHdrVO .getCoaVvdCd         ());
			invIfVO.setHdrCoaInterCoCd  (invHdrVO .getCoaInterCoCd     ());
			invIfVO.setHdrCoaFtuN1stCd  (invHdrVO .getCoaFtuN1stCd     ());
			invIfVO.setHdrCoaFtuN2ndCd  (invHdrVO .getCoaFtuN2ndCd     ());
			invIfVO.setHdrPpdNo         (invHdrVO .getPpdNo            ());
			invIfVO.setHdrPpdDtrbNo     (invHdrVO .getPpdDtrbNo        ());
			invIfVO.setHdrPpdAplyAmt    (invHdrVO .getPpdAplyAmt       ());
			invIfVO.setHdrPpdGlDt       (invHdrVO .getPpdGlDt          ());
			invIfVO.setHdrAproFlg       (invHdrVO .getAproFlg          ());
			invIfVO.setHdrTaxDeclFlg    (invHdrVO .getTaxDeclFlg       ());
			invIfVO.setHdrErrCsrNo      (invHdrVO .getErrCsrNo         ());
			invIfVO.setHdrIfFlg         (invHdrVO .getIfFlg            ());
			invIfVO.setHdrIfDt          (invHdrVO .getIfDt             ());
			invIfVO.setHdrIfErrRsn      (invHdrVO .getIfErrRsn         ());
			invIfVO.setHdrPpayAplyFlg   (invHdrVO .getPpayAplyFlg      ());
			invIfVO.setHdrTjOfcCd       (invHdrVO .getTjOfcCd          ());
			invIfVO.setHdrActXchRt      (invHdrVO .getActXchRt         ());
			invIfVO.setHdrImpErrFlg     (invHdrVO .getImpErrFlg        ());
			invIfVO.setHdrRcvErrFlg     (invHdrVO .getRcvErrFlg        ());
			invIfVO.setHdrTaxCurrXchFlg (invHdrVO .getTaxCurrXchFlg    ());
			invIfVO.setHdrUsrEml        (invHdrVO .getUsrEml           ());
			invIfVO.setHdrImpErrRsn     (invHdrVO .getImpErrRsn        ());
			invIfVO.setHdrRcvErrRsn     (invHdrVO .getRcvErrRsn        ());
			invIfVO.setHdrFtuUseCtnt1   (invHdrVO .getFtuUseCtnt1      ());
			invIfVO.setHdrFtuUseCtnt2   (invHdrVO .getFtuUseCtnt2      ());
			invIfVO.setHdrFtuUseCtnt3   (invHdrVO .getFtuUseCtnt3      ());
			invIfVO.setHdrFtuUseCtnt4   (invHdrVO .getFtuUseCtnt4      ());
			invIfVO.setHdrFtuUseCtnt5   (invHdrVO .getFtuUseCtnt5      ());
			invIfVO.setCsrNo            (invDtrbVO.getCsrNo            ());
			invIfVO.setLineSeq          (invDtrbVO.getLineSeq          ());
			invIfVO.setLineNo           (invDtrbVO.getLineNo           ());
			invIfVO.setLineTpLuCd       (invDtrbVO.getLineTpLuCd       ());
			invIfVO.setInvAmt           (invDtrbVO.getInvAmt           ());
			invIfVO.setInvDesc          (invDtrbVO.getInvDesc          ());
			invIfVO.setInvTaxCd         (invDtrbVO.getInvTaxCd         ());
			invIfVO.setDtrbCoaCoCd      (invDtrbVO.getDtrbCoaCoCd      ());
			invIfVO.setDtrbCoaRgnCd     (invDtrbVO.getDtrbCoaRgnCd     ());
			invIfVO.setDtrbCoaCtrCd     (invDtrbVO.getDtrbCoaCtrCd     ());
			invIfVO.setDtrbCoaAcctCd    (invDtrbVO.getDtrbCoaAcctCd    ());
			invIfVO.setDtrbCoaVvdCd     (invDtrbVO.getDtrbCoaVvdCd     ());
			invIfVO.setDtrbCoaInterCoCd (invDtrbVO.getDtrbCoaInterCoCd ());
			invIfVO.setDtrbCoaFtuN1stCd (invDtrbVO.getDtrbCoaFtuN1stCd ());
			invIfVO.setDtrbCoaFtuN2ndCd (invDtrbVO.getDtrbCoaFtuN2ndCd ());
			invIfVO.setAttrCateNm       (invDtrbVO.getAttrCateNm       ());
			invIfVO.setAttrCtnt1        (invDtrbVO.getAttrCtnt1        ());
			invIfVO.setAttrCtnt2        (invDtrbVO.getAttrCtnt2        ());
			invIfVO.setAttrCtnt3        (invDtrbVO.getAttrCtnt3        ());
			invIfVO.setAttrCtnt4        (invDtrbVO.getAttrCtnt4        ());
			invIfVO.setAttrCtnt5        (invDtrbVO.getAttrCtnt5        ());
			invIfVO.setAttrCtnt6        (invDtrbVO.getAttrCtnt6        ());
			invIfVO.setAttrCtnt7        (invDtrbVO.getAttrCtnt7        ());
			invIfVO.setAttrCtnt8        (invDtrbVO.getAttrCtnt8        ());
			invIfVO.setAttrCtnt9        (invDtrbVO.getAttrCtnt9        ());
			invIfVO.setAttrCtnt10       (invDtrbVO.getAttrCtnt10       ());
			invIfVO.setAttrCtnt11       (invDtrbVO.getAttrCtnt11       ());
			invIfVO.setAttrCtnt12       (invDtrbVO.getAttrCtnt12       ());
			invIfVO.setAttrCtnt13       (invDtrbVO.getAttrCtnt13       ());
			invIfVO.setAttrCtnt14       (invDtrbVO.getAttrCtnt14       ());
			invIfVO.setAttrCtnt15       (invDtrbVO.getAttrCtnt15       ());
			invIfVO.setBkgNo            (invDtrbVO.getBkgNo            ());
			invIfVO.setCntrTpszCd       (invDtrbVO.getCntrTpszCd       ());
			invIfVO.setActVvdCd         (invDtrbVO.getActVvdCd         ());
			invIfVO.setPlnSctrDivCd     (invDtrbVO.getPlnSctrDivCd     ());
			invIfVO.setSoCrrCd          (invDtrbVO.getSoCrrCd          ());
			invIfVO.setYdCd             (invDtrbVO.getYdCd             ());
			invIfVO.setFtuUseCtnt1      (invDtrbVO.getFtuUseCtnt1      ());
			invIfVO.setFtuUseCtnt2      (invDtrbVO.getFtuUseCtnt2      ());
			invIfVO.setFtuUseCtnt3      (invDtrbVO.getFtuUseCtnt3      ());
			invIfVO.setFtuUseCtnt4      (invDtrbVO.getFtuUseCtnt4      ());
			invIfVO.setFtuUseCtnt5      (invDtrbVO.getFtuUseCtnt5      ());
			invIfVO.setSndFlg           ("");
			invIfVO.setCreDt            ("");
			invIfVO.setCreUsrId         (invDtrbVO.getCreUsrId         ());
			invIfVO.setEaiEvntDt        ("");
			invIfVO.setEstmErrRsn       ("");
			invIfVO.setTrspSoTpCd       ("");
			invIfVO.setSoOfcCtyCd       ("");
			invIfVO.setSoSeq            ("");
			invIfVO.setCgoTpCd          ("");			                                          
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"VO Transfer", "SET"}).getMessage(), ex);
		}
	}*/
	
	private OutstandingInterfaceVO setSarOtsIf(ArMnChgVO arMnChgVO) throws EventException{
		try {
			
			OutstandingInterfaceVO outVo = new OutstandingInterfaceVO();
			
			outVo.setIfNo             (arMnChgVO.getArIfNo() + arMnChgVO.getArIfSerNo());
			outVo.setRhqCd            (arMnChgVO.getRhqCd());
			outVo.setArOfcCd          (arMnChgVO.getArOfcCd());
			outVo.setBlNo             (arMnChgVO.getJoBlNo());
			outVo.setInvNo            (arMnChgVO.getInvNo());
			//[2015.03.24] Modify AS-IS: JOO_CSR.CSR_LOCL_CURR_CD TO-BE:MDM_ORGANIZATION.AR_CURR_CD
			outVo.setOfcCurrCd        (arMnChgVO.getArCurrCd()); 
			outVo.setOtsSrcCd         ("JOO");
			outVo.setBilToCustCntCd   (arMnChgVO.getActCustCntCd());
			outVo.setBilToCustSeq     (arMnChgVO.getActCustSeq());
			outVo.setShpToCustCntCd   (arMnChgVO.getInvCustCntCd());
			outVo.setShpToCustSeq     (arMnChgVO.getInvCustSeq());
			outVo.setBkgNo            ("");
			outVo.setBkgNoSplit       ("");
			outVo.setVslCd            (arMnChgVO.getVslCd());
			outVo.setSkdVoyNo         (arMnChgVO.getSkdVoyNo());
			outVo.setDirCd            (arMnChgVO.getSkdDirCd());
			outVo.setTrnkVvdCd        (arMnChgVO.getTrnkVslCd() + arMnChgVO.getTrnkSkdVoyNo() + arMnChgVO.getTrnkSkdDirCd());
			outVo.setSvcScpCd         ("OTH"); //2016.02.23 Add
			outVo.setLaneCd           (arMnChgVO.getRlaneCd().substring(0, 3));
			outVo.setSailArrDt        (arMnChgVO.getSailArrDt());
			outVo.setBkgIoBndCd       (arMnChgVO.getIoBndCd());
			outVo.setPorCd            (arMnChgVO.getPorCd());
			outVo.setPolCd            (arMnChgVO.getPolCd());
			outVo.setPodCd            (arMnChgVO.getPodCd());
			outVo.setDelCd            (arMnChgVO.getDelCd());
			outVo.setCustSrepCd       ("");
			outVo.setDueDt            (arMnChgVO.getDueDt());
			outVo.setStlFlg           ("");
			outVo.setBkgRefNo         ("");
			//[2015.03.24] Modify AS-IS : JOO_CSR.CSR_OFFST_NO TO-BE: JOO_SLIP.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO : CSR_NO
			outVo.setApArOffstNo      (arMnChgVO.getSlpNo()); 
			//outVo.setApArOffstNo      (arMnChgVO.getCsrOffstNo());
			outVo.setCrMkFlg          ("");
			outVo.setXchRtTpCd        (arMnChgVO.getXchRtTpCd());
			outVo.setLstInvNo         ("");
			outVo.setOtsGrpTpCd       ("");
			outVo.setOtsTpCd          ("");
			outVo.setOtsRmk           (arMnChgVO.getInvRmk());
			outVo.setIfDt             ("");
			outVo.setInvDt            ("");
			outVo.setCltOfcCd         (arMnChgVO.getArOfcCd());
			outVo.setOtsRtFlg         ("Y");
			outVo.setScNo             ("");
			outVo.setCreUsrId         (arMnChgVO.getUsrId());
			//outVo.setCreDt            (db sysdate)
			outVo.setUpdUsrId         (arMnChgVO.getUsrId());
			//outVo.setUpdDt            (db sysdate)
			outVo.setTjSrcNm          ("SALAR");
			//outVo.setChgTpCd          (arMnChgVO.getJoRevTpCd());
			outVo.setChgTpCd          (arMnChgVO.getChgCd());//2015.02.24 Modify
			outVo.setGlDt             (arMnChgVO.getGlDt());
			outVo.setBlCurrCd         (arMnChgVO.getCurrCd());
			outVo.setOtsAmt           (arMnChgVO.getChgAmt());
			outVo.setOtsIfFlg         ("");
			outVo.setRevTpSrcCd       (arMnChgVO.getJoRevTpCd());
			outVo.setXchRtN3rdTpCd    ("");
			
			return outVo;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"VO Transfer", "SET"}).getMessage(), ex);
		}
	}
}
