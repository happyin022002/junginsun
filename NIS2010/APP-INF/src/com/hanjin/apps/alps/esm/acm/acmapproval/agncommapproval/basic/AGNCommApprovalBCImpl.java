/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalBCImpl.java
*@FileTitle : AGNCommApprovalBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.09 김영오
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.10.19 김봉균 [] Approval Request 시 History 저장
* 2013.01.23 김봉균 [] Returned CSR Reprocess IC 업데이트 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration.AGNCommApprovalDBDAO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration.AGNCommApprovalEAIDAO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalRequestVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommAsaNoVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommVendorVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.basic.FFCmpnApprovalBC;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.basic.FFCmpnApprovalBCImpl;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgentActualINFtoAPCheckVO;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

 
/**
 * ALPS-ACMApproval Business Logic Command Interface<br>
 * - ALPS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM YOUNG-OH
 * @see Esm_Acm_0009Event,AGNCommApprovalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGNCommApprovalBCImpl extends BasicCommandSupport implements AGNCommApprovalBC {

	// Database Access Object
	private transient AGNCommApprovalDBDAO dbDao = null;
	
	// EAI Interface Object
	private transient AGNCommApprovalEAIDAO eaiDao = null;

	/**
	 * AGNCommApprovalBCImpl 객체 생성<br>
	 * AGNCommApprovalDBDAO를 생성한다.<br>
	 */
	public AGNCommApprovalBCImpl() {
		dbDao = new AGNCommApprovalDBDAO();
		eaiDao = new AGNCommApprovalEAIDAO();
	}

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation 목록을 조회<br>
	 *
	 * @param AGNCommApprovalMasterVO agnCommApprovalMasterVO
	 * @return List<AGNCommApprovalMasterVO>
	 * @exception EventException
	 */
	public List<AGNCommApprovalMasterVO> searchAGNCommApprovalMaster(AGNCommApprovalMasterVO agnCommApprovalMasterVO) throws EventException {
		try {
			return dbDao.searchAGNCommApprovalMaster(agnCommApprovalMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation 하단 Detail 조회<br>
	 *
	 * @param AGNCommApprovalDetailVO angCommApprovalDetailVO
	 * @return List<AGNCommApprovalDetailVO>
	 * @exception EventException
	 */
	public List<AGNCommApprovalDetailVO> searchAGNCommApprovalDetail(AGNCommApprovalDetailVO angCommApprovalDetailVO) throws EventException {
		try {
			return dbDao.searchAGNCommApprovalDatail(angCommApprovalDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request
	 * Agent Commission CSR Creation 목록을 Interface 한다.
	 * true 10만불이하 > Alps에서 결재라인 처리 / false GW에서 결재라인 처리
	 * @param agnCommApprovalMasterVOs
	 * @param agnCommApprovalMasterVO
	 * @param account
	 * @throws EventException
	 */
	public void approvalAGNCommApproval(AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs, AGNCommApprovalMasterVO agnCommApprovalMasterVO, SignOnUserAccount account) throws EventException{
		AGNCommApprovalRequestVO paraVO1 = null;
		AGNCommApprovalRequestVO paraVO2 = null;
		AGNCommApprovalRequestVO paraVO3 = null;
		StringBuffer strAudNo = null;
		String bkgStsCd = "";
		
		//@@@@@@@@@@@@@@@@@@@@@@10만불 이하 Approval 로직여부 S!!@@@@@@@@@@@@@@@@@@@@@@//
		/*중요!!! : approvedYN가 true인 경우, 화면단에서 approStep이 생략되기때문에 
		 *ComAproRqstRoutVO[] route = approval.convertApprovalRoute(agnCommApprovalMasterVO.getAproStep()); 
		 *이 부분에서 에러가난다 WEB단에서 차후 관련로직이 추가될 경우 java & query는 모두 수정하였으나 
		 *WEB쪽에 approStep을 넣어야 할지 파악해야하는 프리체킹하는 로직같은것을 추가할 수 있겠다 */
		//String approvedYNStr = approvedYN(agnCommApprovalMasterVO, account);	//실시간체크
		
		String approvedYNStr = agnCommApprovalMasterVO.getApproYN();	//결재시스템은 계정에따라 분류된다 512691 512692 512693 는 GW Approval System
		
		Boolean approvedYN = false;
		//true 10만불이하 > Alps에서 결재라인 처리 / false GW에서 결재라인 처리 => (변경사항)계정에 따른 결재구분
		if("Y".equals(approvedYNStr)){
			approvedYN = true;
		}else{
			approvedYN = false;
		}
		//@@@@@@@@@@@@@@@@@@@@@@10만불 이하 Approval 로직여부 E!!@@@@@@@@@@@@@@@@@@@@@@//
		try {
			paraVO1 = new AGNCommApprovalRequestVO();
			paraVO2 = new AGNCommApprovalRequestVO();
			if(approvedYN){
				paraVO3 = new AGNCommApprovalRequestVO();
			}
			log.debug("\n agnCommApprovalMasterVOs.length="+agnCommApprovalMasterVOs.length);
			strAudNo = new StringBuffer();
			for(int i=0; i<agnCommApprovalMasterVOs.length; i++) {
				agnCommApprovalMasterVOs[i].setAcStsCd(agnCommApprovalMasterVO.getAcStsCd()); //Commission Status

				bkgStsCd = dbDao.getBKGStsCdInfo(agnCommApprovalMasterVOs[i]);
				log.debug("bkgStsCd = "+bkgStsCd);
				if("X".equals(bkgStsCd)) {
					//There is(are) canceled booking(s) in Audit No ['$s']. Please exclude canceled booking(s).
					throw new DAOException((new ErrorHandler("ACM00040", new String[]{agnCommApprovalMasterVOs[i].getAudNo()})).getMessage());
				} else if("A".equals(bkgStsCd)) {
					//There is(are) ‘$s’ status booking(s). Please exclude ‘$s’ status booking(s).
					throw new DAOException((new ErrorHandler("ACM00041", new String[]{"A","A"})).getMessage());
				}
				if ( i > 0 ) {
//					arrAudNo = arrAudNo + ",";
					strAudNo.append(",");
				}
				strAudNo.append("'" + agnCommApprovalMasterVOs[i].getAudNo() + "'");
			}
			log.debug("\n strAudNo = "+strAudNo);
			log.debug("\n agnCommApprovalMasterVO.toString() = "+agnCommApprovalMasterVO.toString());
			paraVO1.setAsaNo(agnCommApprovalMasterVO.getAsaNo());
			paraVO1.setInvDt(agnCommApprovalMasterVO.getInvDt());
//			paraVO1.setArOfcCd(agnCommApprovalMasterVO.getArOfcCd());
			paraVO1.setArOfcCd(dbDao.getMdmArOfcCd(agnCommApprovalMasterVO.getAgnCd(), agnCommApprovalMasterVO.getArOfcCd()));
			paraVO1.setAgnCd(agnCommApprovalMasterVO.getAgnCd());
			paraVO1.setInvTaxRt(agnCommApprovalMasterVO.getInvTaxRt());
			paraVO1.setWhldTaxRt(agnCommApprovalMasterVO.getWhldTaxRt());
			paraVO1.setUpdUsrId(account.getUsr_id());
			paraVO1.setCreUsrId(account.getUsr_id());
			paraVO1.setUsrNm(account.getUsr_nm());
			paraVO1.setUsrEml(account.getUsr_eml());
			paraVO1.setAudNo(strAudNo.toString());

			dbDao.modifyAcmCommBkgInfoRevVVD(paraVO1);
			log.error("getWhldTaxRt : "+paraVO1.getWhldTaxRt()+"///");
			paraVO2 = dbDao.getAcmCsrCondInfo(paraVO1);
			paraVO2.setUsrNm(account.getUsr_nm());
			paraVO2.setUsrEml(account.getUsr_eml());
			paraVO2.setSRevChg(agnCommApprovalMasterVO.getSRevChg());
			if(approvedYN){	//Alps에서 결재라인 처리
				paraVO2.setApprovedYN("Y");
			}else{ //GW에서 결재라인 처리 
				paraVO2.setApprovedYN("N");
			}

            ////0.CHECK ASA CURR_CD vs INVOICE CURR_CD, EFF_DT vs ASA_FROM_TO_DT 
        	if(agnCommApprovalMasterVO.getAsaNo().length() > 1) {
	        	//ASA_CURR_CD vs INVOICE_CURR_CD Check
				for(int i=0; i<agnCommApprovalMasterVOs.length; i++) {
	        		if(!agnCommApprovalMasterVOs[i].getCurrCd().equals(paraVO2.getAsaCurrCd())) {
		            	//ASA Currency Code vs Invoice Currency Code does not match! Please check up ASA Info!
	        			throw new DAOException((new ErrorHandler("ACM00042", new String[]{"ASA Currency Code vs Invoice Currency Code","ASA Info"})).getMessage());
		            }
	        	}
	        	//EFF_DT vs ASA_FROM_TO_DT Check
	        	if("0".equals(paraVO2.getAsaCnt())) {
	            	//ASA From~To Date vs Effective Date does not match! Please check up ASA Info!
	        		throw new DAOException((new ErrorHandler("ACM00042", new String[]{"ASA From~To Date vs Effective Date","ASA Info"})).getMessage());
	        	}
	        	//인터페이스시 ASA NO 변경(OFC + YMM + SEQU ==> OFC + SEQU + YMM)
	            //asaNo  = asaNo.substring(0,3) + asaNo.substring(6) + asaNo.substring(3,6);
	        	paraVO2.setAsaNo(paraVO2.getAsaNo().substring(0,3) + paraVO2.getAsaNo().substring(6) + paraVO2.getAsaNo().substring(3,6));
            }
        	log.debug("paraVO2.getLocalDt() => "+paraVO2.getLocalDt());
        	if(paraVO2.getLocalDt() != null && paraVO2.getLocalDt().length() < 6) {
            	//[$s] does not exist!, Please check up Again!
            	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"LOCAL DATE"})).getMessage());
            }
			if(paraVO2.getErrBkgCreDt() != null && paraVO2.getErrBkgCreDt() != ""){
				//[$s] does not exist!, Please check up Again!
            	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"[" + paraVO2.getErrBkgNo() + "]Booking creation date is earlier than 2007-05-07 or "})).getMessage());
			}
		    //CHECK
		    if(paraVO2.getFincRgnCd() == null || "".equals(paraVO2.getFincRgnCd())){
		    	//[Region Code] does not exist!, Please check up Again!
		    	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"Region Code"})).getMessage());
		    }
		    //CHECK
		    if(paraVO2.getCoaIntrCmpyCd() == null || "".equals(paraVO2.getCoaIntrCmpyCd())){
		    	//[Center Code] does not exist!, Please check up Again!
		    	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"Center Code"})).getMessage());
		    }
		    
            if(paraVO2.getErrVvdBkgNo() != null && !"".equals(paraVO2.getErrVvdBkgNo())) {
            	if(paraVO2.getErrVvd() == null || "".equals(paraVO2.getErrVvd())){	
            		paraVO2.setErrVvd("does not exist!");
            	}
            	//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$s]!
				throw new DAOException((new ErrorHandler("ACM00012", new String[]{ paraVO2.getErrVvd() + ", BKG_NO : "+paraVO2.getErrVvdBkgNo()})).getMessage());
            }
            paraVO2.setAudNo(strAudNo.toString());
			dbDao.addCsrHeaderApCsrNo(paraVO2);

			AGNCommApprovalRequestVO tempParaVO = null;
			for (int i=0; i<agnCommApprovalMasterVOs.length; i++) {
				tempParaVO = new AGNCommApprovalRequestVO();
				
				String glDtStr = paraVO2.getGlDt();
				if("".equals(glDtStr) || glDtStr == null){
					glDtStr = paraVO2.getInvDt(); //glDt가 null 일경우 공통csr 결재라인정할수 없음
					paraVO2.setGlDt(glDtStr);
				}
				
				tempParaVO.setCsrAmt(paraVO2.getCsrAmt());
				tempParaVO.setLocalDt(paraVO2.getLocalDt());
				tempParaVO.setApOfcCd(paraVO2.getApOfcCd());
				tempParaVO.setPayMzdLuCd(paraVO2.getPayMzdLuCd());
				tempParaVO.setPayGrpLuCd(paraVO2.getPayGrpLuCd());
				tempParaVO.setFincRgnCd(paraVO2.getFincRgnCd());
				tempParaVO.setApCtrCd(paraVO2.getApCtrCd());
				tempParaVO.setArHdQtrOfcCd(paraVO2.getArHdQtrOfcCd());
				tempParaVO.setErrBkgNo(paraVO2.getErrBkgNo());
				tempParaVO.setErrBkgCreDt(paraVO2.getErrBkgCreDt());
				tempParaVO.setCsrNo(paraVO2.getCsrNo());
				tempParaVO.setVndrSeq(paraVO2.getVndrSeq());
				tempParaVO.setVndrNo(paraVO2.getVndrNo());
				tempParaVO.setInvDesc(paraVO2.getInvDesc());
				tempParaVO.setCoaIntrCmpyCd(paraVO2.getCoaIntrCmpyCd());
				tempParaVO.setCurrCd(paraVO2.getCurrCd());
				tempParaVO.setAsaNo(paraVO2.getAsaNo());
				tempParaVO.setAsaCurrCd(paraVO2.getAsaCurrCd());
				tempParaVO.setAsaCnt(paraVO2.getAsaCnt());
				tempParaVO.setGlDt(paraVO2.getGlDt());
				tempParaVO.setErrVvdBkgNo(paraVO2.getErrVvdBkgNo());
				tempParaVO.setErrVvd(paraVO2.getErrVvd());
				tempParaVO.setInvTaxRt(paraVO2.getInvTaxRt());
				tempParaVO.setWhldTaxRt(paraVO2.getWhldTaxRt());
				tempParaVO.setInvDt(paraVO2.getInvDt());
				tempParaVO.setAgnCd(paraVO2.getAgnCd());
				tempParaVO.setArOfcCd(paraVO2.getArOfcCd());
				tempParaVO.setUpdUsrId(paraVO2.getUpdUsrId());
				tempParaVO.setCreUsrId(paraVO2.getCreUsrId());
				tempParaVO.setAudNo(agnCommApprovalMasterVOs[i].getAudNo());    //***** 주의 *****

				if (dbDao.getAudNoFromAcmAgmComm(tempParaVO).size() > 0) {
					dbDao.modifyCsrHeaderAcmAgnComm(tempParaVO);
					dbDao.modifyCsrHeaderAcmAgnCommDtl(tempParaVO);
				} else {
					dbDao.modifyCsrHeaderAcmAgnOtrComm(tempParaVO);
				}
			}

			/*
			 * [CHM-201433178] Split 04-GW에서 ERP로 계약서 첨부 FLAG 송부
			 * - 10만불 관련 계약서 여부 저장 Flag 지정(AgmtDocCfmCd)
			 * - 'ALPS Approval System'일 경우, 'Y' set. 'GW Approval System'일 경우, 'N' set
			 */
			if (approvedYN) {
				paraVO2.setAgmtDocCfmCd("Y");
				paraVO2.setCsrAproTpCd("AL");

				/* 
				 * '512694' Code의 경우 일반 관리비로 분류되므로 첨부 자료 없이 결재 가능
				 * '512694' Code의 청구는 다른 코드와 같이 CSR 처리 할 수 없도록 화면에서 검증로직 적용.
				 */
				if ("512694".equals(agnCommApprovalMasterVOs[0].getCommStndCostCd())) {
					paraVO2.setCsrGenExpnAcctFlg("Y");
				} else {
					paraVO2.setCsrGenExpnAcctFlg("N");
				}
			} else {
				paraVO2.setAgmtDocCfmCd("N");
				paraVO2.setCsrAproTpCd("GW");
			}
			paraVO2.setGwAgmtDocCfmCd("");
			paraVO2.setAgmtFileCfmCd("");
			paraVO2.setAgmtEvidCfmFnlCd("");

			dbDao.addCsrHeaderApInvHdr(paraVO2);
			dbDao.addCsrHeaderApInvDtrb(paraVO2);
			dbDao.modifyCsrHeaderApInvDtrb(paraVO2);

			if(approvedYN){
				paraVO3 = dbDao.getCsrHeaderApInvHdrInfo(paraVO2);

				// 결재선 등록
				// COM_APRO_RQST_HDR
				ComAproRqstHdrVO header = new ComAproRqstHdrVO();
				ApprovalUtil approval =  new ApprovalUtil();
				header.setSubSysCd("ACM");
				header.setAproKndCd("CSR");		
				header.setRqstOfcCd(account.getOfc_cd());
				header.setRqstOfcNm(account.getOfc_eng_nm());
				header.setRqstUsrJbTitNm("");
				header.setRqstUsrId(account.getUsr_id());
				header.setRqstUsrNm(account.getUsr_nm());
				header.setCreUsrId(paraVO3.getCreUsrId());

				// COM_APRO_RQST_ROUT
				log.debug("agnCommApprovalMasterVO.getAproStep()=> "+agnCommApprovalMasterVO.getAproStep());
//				ComAproRqstRoutVO[] route = approval.convertApprovalRoute("2/9500384/Oh-Chul KWON/SINWAG/Coord - 1/7346389/Sally SIM/SINWA/Part Leader");
				ComAproRqstRoutVO[] route = approval.convertApprovalRoute(agnCommApprovalMasterVO.getAproStep());
				log.info("\n route = "+route.toString());

				// COM_APRO_CSR_DTL
				ComAproCsrDtlVO csr = new ComAproCsrDtlVO();
				csr.setCsrNo(paraVO3.getCsrNo());
				csr.setCostOfcCd(paraVO3.getTjOfcCd());
				csr.setInvKnt(paraVO3.getDtrbCnt());
				csr.setVndrSeq(paraVO3.getVndrNo());
				csr.setPayDueDt(paraVO3.getInvTermDt());
				csr.setCurrCd(paraVO3.getCsrCurrCd());
				csr.setAproTtlAmt(paraVO3.getCsrAmt());
				csr.setCreUsrId(paraVO3.getCreUsrId());
				log.info("\n csr = "+csr);

				// 결재 등록
				approval.saveCsrApro(header, route, csr);
			}
			
			dbDao.modifyCsrHeaderAcmAgnComm2(paraVO2);
			dbDao.modifyCsrHeaderAcmAgnOtrComm2(paraVO2);
			dbDao.modifyCsrHeaderApInvHdr(paraVO2);

			// History 저장
			paraVO2.setCalcNo(dbDao.getCalcNo());
/*          [CHM-201533942] ACM Approval 관련 지연시간 단축 위한 히스토리 삭제 요청
 *            - CSR NO. 생성 정보 외에 다른 정보 저장 하지 않도록 수정
			dbDao.addAcmAgnCommChgHis(paraVO2);
			dbDao.addAcmAgnCommTrspHis(paraVO2);
			dbDao.addAcmAgnCommDtlHis(paraVO2);
*/
			dbDao.addAcmAgnCommHis(paraVO2);

			/*
			 * [CHM-201433178] Split 04-GW에서 ERP로 계약서 첨부 FLAG 송부
			 * - 295번 라인에서 approvedYN 값에 따라서 하드 코딩
			 * - 'ALPS Approval System'일 경우, 'Y' set. 'GW Approval System'일 경우, 'N' set
			 */
			if(!approvedYN){	//GW일때만 실행한다
				//CSR생성 후 Approval Request 하기 위한 단계로 업데이트
				ApprovalUtil aproUtil = new ApprovalUtil();
				aproUtil.updateAproGwFlg(paraVO2.getCsrNo(), paraVO2.getApOfcCd());
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 화면에 대한 보고서 출력(Master)<br>
	 *
	 * @param AGNCommInfoPrintMasterVO acmCommInfoPrintMasterVO
	 * @return List<AGNCommInfoPrintMasterVO>
	 * @exception EventException
	 */
	public List<AGNCommInfoPrintMasterVO> searchACMCommInfoPrintMaster(AGNCommInfoPrintMasterVO acmCommInfoPrintMasterVO) throws EventException {
		try {
			return dbDao.searchACMCommInfoPrintMaster(acmCommInfoPrintMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 화면에 대한 보고서 출력(Detail)<br>
	 *
	 * @param AGNCommInfoPrintDetailVO acmCommInfoPrintDetailVO
	 * @return List<AGNCommInfoPrintDetailVO>
	 * @exception EventException
	 */
	public List<AGNCommInfoPrintDetailVO> searchACMCommInfoPrintDetail(AGNCommInfoPrintDetailVO acmCommInfoPrintDetailVO) throws EventException {
		try {
			return dbDao.searchACMCommInfoPrintDetail(acmCommInfoPrintDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 화면 조회조건 ASA No 조회<br>
	 *
	 * @param AGNCommAsaNoVO agnCommAsaNoVO
	 * @return List<AGNCommAsaNoVO>
	 * @exception EventException
	 */
	public List<AGNCommAsaNoVO> getAsaNoList(AGNCommAsaNoVO agnCommAsaNoVO) throws EventException {
		try {
			return dbDao.getAsaNoList(agnCommAsaNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 화면 조회조건 Vendor 조회<br>
	 *
	 * @param AGNCommVendorVO angCommVendorVO
	 * @return List<AGNCommVendorVO>
	 * @exception EventException
	 */
	public List<AGNCommVendorVO> getVendorInfo(AGNCommVendorVO angCommVendorVO) throws EventException {
		try {
			return dbDao.getVendorInfo(angCommVendorVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0013] Retrieve<br>
	 * Returned CSR Master 목록을 조회<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @return List<ReturnCSRMasterVO>
	 * @exception EventException
	 */
	public List<ReturnCSRMasterVO> searchReturnCSRMaster(ReturnCSRMasterVO returnCSRMasterVO) throws EventException {
		try {
			return dbDao.searchReturnCSRMaster(returnCSRMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0013] Retrieve<br>
	 * Returned CSR Detail 목록을 조회<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @return List<ReturnCSRDetailVO>
	 * @exception EventException
	 */
	public List<ReturnCSRDetailVO> searchReturnCSRDetail(ReturnCSRMasterVO returnCSRMasterVO) throws EventException {
		try {
			return dbDao.searchReturnCSRDetail(returnCSRMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0013] Reprocess to Audit Confirm<br>
	 * Returned CSR의 재처리<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @param SignOnUserAccount account
	 * @return List<ReturnCSRDetailVO>
	 * @exception EventException
	 */
	public List<ReturnCSRDetailVO> reprocessReturnCSRAuditConfirm(ReturnCSRMasterVO returnCSRMasterVO, SignOnUserAccount account) throws EventException {
		try {
			//1. aud no 생성
			String audNo = dbDao.getAudNo(returnCSRMasterVO.getCsrNo());
			if(returnCSRMasterVO != null) {
				returnCSRMasterVO.setAudNo(audNo);
				returnCSRMasterVO.setUsrId(account.getUsr_id());
			}
			//2. aud no 등의 데이터 업데이트(UPDATE ACM_AGN_COMM)
			dbDao.modifyReturnCSRAuditConfirm(returnCSRMasterVO);
			dbDao.modifyReturnCSRAuditConfirm2(returnCSRMasterVO);
			//3. aud no 로 조회
			return dbDao.searchReturnCSRAuditConfirm(returnCSRMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0013] CSR Cancel<br>
	 * Interface Cancel 처리<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAGNCommCSRCancel(ReturnCSRMasterVO returnCSRMasterVO, SignOnUserAccount account) throws EventException {
		try {
			AGNCommApprovalRequestVO approvalRequestVO = new AGNCommApprovalRequestVO();
			approvalRequestVO.setCalcNo(dbDao.getCalcNo());
			approvalRequestVO.setCsrNo(returnCSRMasterVO.getCsrNo());
			approvalRequestVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addAcmAgnCommCSRCancelHis(approvalRequestVO); //History 저장
			dbDao.manageAGNCommCSRCancel(approvalRequestVO); //'IC'로 UPDATE
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * Agent Commission CSR Creation화면의 Audit Reject기능을 수행한다.<br>
	 *
	 * @param AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approvalAGNCommAuditReject(AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs, SignOnUserAccount account) throws EventException {
		try {
			List<AGNCommApprovalMasterVO> updateVoList = new ArrayList<AGNCommApprovalMasterVO>();

			for (int i=0; i<agnCommApprovalMasterVOs.length; i++) {
				agnCommApprovalMasterVOs[i].setUsrId(account.getUsr_id());

				if (agnCommApprovalMasterVOs[i].getChk() != "" && agnCommApprovalMasterVOs[i].getChk().equals("1")) {
					updateVoList.add(agnCommApprovalMasterVOs[i]);
				}
				
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyAGNCommAuditReject(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F<br>
     * 
     * @param String result
     * @param String csrNo
     * @param ComAproRqstRoutVO model
     * @return FNS0080003Document[] 
     * @throws EventException
     */
	public FNS0080003Document[] transferAgentActualINFtoAP1(String result, String csrNo, ComAproRqstRoutVO model) throws EventException{
    	DBRowSet rowSet = null;		//데이터 전송을 위해 DB ResultSet을 구현한 객체		
		
		String aproNm = "";
		String module = "";
		AgentActualINFtoAPCheckVO aPApproVO = new AgentActualINFtoAPCheckVO();
		
		// 2007.06.04 추가
		FNS0080003Document[] docReq		= null;
		
		try {
			
			aproNm = model.getAproUsrId();	//최종결재자명
			if(aproNm == null) aproNm = " ";	//최종결재자명 공백처리
			if(result == null) result = "C";		//flag값이 NULL인 경우, 승인한것으로 간주한다.
			
			
			////업무구분(AGT/BRKG/FAC)을 위한 CSR정보 조회
			aPApproVO.setCsrNo(csrNo);
			
			aPApproVO = dbDao.searchACMCSRInfo(aPApproVO);	
			module = aPApproVO.getSrcCtnt();
			log.info("\n ....... aPApproVO >>>>> [" + aPApproVO.toString()+ "]");
			
			log.error(".......");
			log.error("....... flag   >>>>> [" + result + "]");
			log.error("....... csrNo  >>>>> [" + csrNo  + "]");
			log.error("....... Name   >>>>> [" + aproNm + "]");
			log.error("....... module >>>>> [" + module + "]");
			log.error(".......");
			
			log.info(".......");
			log.info("....... flag   >>>>> [" + result + "]");
			log.info("....... csrNo  >>>>> [" + csrNo  + "]");
			log.info("....... Name   >>>>> [" + aproNm + "]");
			log.info("\n ....... module >>>>> [" + module + "]");
			log.info(".......");
			
			
			////업무구분별 분기처리
			
			if(module.equals("COMMISSION")){
				
				if(result.equals("R")){	
					//반려시
					dbDao.modifyACMApprovalRequesttoEP(aPApproVO);				
					dbDao.modifyACMOtherApprovalRequesttoEP(aPApproVO);	
				}else{						
					////5.AP 인터페이스 실행하기
					log.info("\n transferAgentActualINFtoAP1 Start");
					rowSet = dbDao.searchAgentActualINFtoAP(aPApproVO);
					log.info("\n rowSet="+rowSet.toString());
//					log.info("\n csrNo="+csrNo+",/n rowSet="+rowSet.toString()+",/n model="+model);
//					log.info("\n HDR_COA_INTER_CO_CD==="+rowSet.getString("HDR_COA_INTER_CO_CD"));
					docReq = eaiDao.transferAtOnceACMToEAIByWS(csrNo, rowSet, model); //2007.05.31 modify
					log.info("\n docReq="+docReq.toString());
				}//if(result.equals("R")){	
				
			}else{
				
				FFCmpnApprovalBC ffCommand = new FFCmpnApprovalBCImpl();
				docReq = ffCommand.transferFFActualINFtoAP1(result, csrNo, model);
				
			}//if(commFlag.equals("COMMISSION")){
				
			return docReq;
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F 승인건에 대한 처리<br>
     * 
     * @param  String result
     * @param  String csrNo
     * @param  ComAproRqstRoutVO model
     * @return String
     * @throws EventException
     */
	public String transferAgentActualINFtoAP2(String result, String csrNo, ComAproRqstRoutVO model) throws EventException{

		String approStep = "";
		String usr_jb_tit_nm = "";
		String usr_nm = "";
		AgentActualINFtoAPCheckVO aPApproVO = new AgentActualINFtoAPCheckVO();

		try {
			
			////업무구분(AGT/BRKG/FAC)을 위한 CSR정보 조회
			aPApproVO.setCsrNo(csrNo);
			aPApproVO = dbDao.searchACMCSRInfo(aPApproVO);
			////업무구분별 분기처리
			if(aPApproVO.getSrcCtnt().equals("COMMISSION")){
				if(!result.equals("R")){
					
					//승인시
					////AP_INV_IF에 최종사용자 UPDATE
					if(model.getAproUsrJbTitNm() == null){
						usr_jb_tit_nm = "";
					}else{
						usr_jb_tit_nm = model.getAproUsrJbTitNm();
					}
					
					if(model.getAproUsrNm() == null){
						usr_nm = "";
					}else{
						usr_nm = model.getAproUsrNm();
					}
					approStep = usr_jb_tit_nm + "/" + usr_nm;
					
					aPApproVO.setAproStep(approStep);
					
					dbDao.modifyApprovalStep(aPApproVO);
					
					////AP 인터페이스 실행결과를 AGT_AGN_COMM에 UPDATE하기
					dbDao.modifyAGTCommInfo(aPApproVO);
					dbDao.modifyAGTOtherCommInfo(aPApproVO);
					
				}//if(result.equals("R")){	
				
			}else{
				
				FFCmpnApprovalBC ffCommand = new FFCmpnApprovalBCImpl();
				ffCommand.transferFFActualINFtoAP2(result, csrNo, model);
				
			}//if(commFlag.equals("COMMISSION")){
				
			return "";
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation Audit의 합계금액(CSR_USD_AMT)에 의한 GW&Approval 분기로직<br>
	 * 10만불 이상일때 GW결재창을 사용(approvedYN = 'N') & 10만불 미만일때 기존 Approve 결재창을 사용(approvedYN = 'Y')
	 * @param AGNCommApprovalMasterVO agnCommApprovalMasterVO
	 * @param SignOnUserAccount account
	 * @return List<AGNCommApprovalDetailVO>
	 * @exception EventException
	 */
	public String approvedYN(AGNCommApprovalMasterVO agnCommApprovalMasterVO, SignOnUserAccount account) throws EventException{	//AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs, 
		AGNCommApprovalRequestVO paraVO1 = null;
		AGNCommApprovalRequestVO paraVO2 = null; 
		String strAudNo = "";
		
		AGNCommApprovalRequestVO approvedYN = new AGNCommApprovalRequestVO();
		
		try {
			paraVO1 = new AGNCommApprovalRequestVO();
			paraVO2 = new AGNCommApprovalRequestVO();
			
			strAudNo = agnCommApprovalMasterVO.getAudNos(); 
			
			log.debug("\n agnCommApprovalMasterVO.toString() = "+agnCommApprovalMasterVO.toString());
			paraVO1.setAsaNo(agnCommApprovalMasterVO.getAsaNo());
			paraVO1.setInvDt(agnCommApprovalMasterVO.getInvDt());
//			paraVO1.setArOfcCd(agnCommApprovalMasterVO.getArOfcCd());
			paraVO1.setArOfcCd(dbDao.getMdmArOfcCd(agnCommApprovalMasterVO.getAgnCd(), agnCommApprovalMasterVO.getArOfcCd()));
			paraVO1.setAgnCd(agnCommApprovalMasterVO.getAgnCd());
			paraVO1.setInvTaxRt(agnCommApprovalMasterVO.getInvTaxRt());
			paraVO1.setWhldTaxRt(agnCommApprovalMasterVO.getWhldTaxRt());
			paraVO1.setUpdUsrId(account.getUsr_id());
			paraVO1.setCreUsrId(account.getUsr_id());
			paraVO1.setUsrNm(account.getUsr_nm());
			paraVO1.setUsrEml(account.getUsr_eml());
			paraVO1.setAudNo(strAudNo);	//체크한 audNo 를 이와같은 형태로 웹에서 넘겨준다

			////dbDao.modifyAcmCommBkgInfoRevVVD(paraVO1);
			log.error("getWhldTaxRt : "+paraVO1.getWhldTaxRt()+"///");
			paraVO2 = dbDao.getAcmCsrCondInfo(paraVO1);
			paraVO2.setUsrNm(account.getUsr_nm());
			paraVO2.setUsrEml(account.getUsr_eml());
			paraVO2.setSRevChg(agnCommApprovalMasterVO.getSRevChg());
			
			//GW&Approval 분기로직
			approvedYN = dbDao.getApprovedYN(paraVO2);
			
			return approvedYN.getApprovedYN();
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 GW 전송용 전표(Master)<br>
	 *
	 * @param AGNCommInfoPrintMasterVO acmCommInfoPrintMasterVO
	 * @return List<AGNCommInfoPrintMasterVO>
	 * @exception EventException
	 */
	public List<AGNCommInfoPrintMasterVO> searchGWACMCommInfoPrintMaster(AGNCommInfoPrintMasterVO acmCommInfoPrintMasterVO) throws EventException {
		try {
			return dbDao.searchGWACMCommInfoPrintMaster(acmCommInfoPrintMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 GW 전송용 전표(Detail)<br>
	 *
	 * @param AGNCommInfoPrintDetailVO acmCommInfoPrintDetailVO
	 * @return List<AGNCommInfoPrintDetailVO>
	 * @exception EventException
	 */
	public List<AGNCommInfoPrintDetailVO> searchGWACMCommInfoPrintDetail(AGNCommInfoPrintDetailVO acmCommInfoPrintDetailVO) throws EventException {
		try {
			return dbDao.searchGWACMCommInfoPrintDetail(acmCommInfoPrintDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * GW창에서 기안<br>
	 * 기안(P)시 AL의 상태값을 PS로 업데이트한다<br>
	 *
	 * @param AGNCommApprovalRequestVO paraVO
	 * @exception EventException
	 */
	public void manageAcmAgnOtrComm3(AGNCommApprovalRequestVO paraVO) throws EventException {
		try {
			dbDao.modifyCsrHeaderAcmAgnOtrComm3(paraVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}