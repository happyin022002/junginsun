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
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration.AGNCommApprovalDBDAO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration.AGNCommApprovalEAIDAO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration.AGNCommApprovalEAIDAOB;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalRequestVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommAsaNoVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommVendorVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRMasterVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgentActualINFtoAPCheckVO;
import com.clt.bizcommon.approval.util.ApprovalUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.syscommon.common.table.ComAproCsrDtlVO;
import com.clt.syscommon.common.table.ComAproRqstHdrVO;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;


/**
 * OPUS-ACMApproval Business Logic Command Interface<br>
 * - OPUS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
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
//	private transient AGNCommApprovalEAIDAOB eaiDaob = null;

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
	 * [ESM_ACM_0009] Approval Request<br>
	 * Agent Commission CSR Creation 목록을 Interface 한다.<br>
	 *
	 * @param AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs
	 * @param AGNCommApprovalMasterVO agnCommApprovalMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approvalAGNCommApproval(AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs, AGNCommApprovalMasterVO agnCommApprovalMasterVO, SignOnUserAccount account) throws EventException{
		AGNCommApprovalRequestVO paraVO1 = null;
		AGNCommApprovalRequestVO paraVO2 = null;
		AGNCommApprovalRequestVO paraVO3 = null;
		StringBuffer strAudNo = null;
		String bkgStsCd = "";
		try {
			paraVO1 = new AGNCommApprovalRequestVO();
			paraVO2 = new AGNCommApprovalRequestVO();
			paraVO3 = new AGNCommApprovalRequestVO();
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
			paraVO1.setUpdUsrId(account.getUsr_id());
			paraVO1.setCreUsrId(account.getUsr_id());
			paraVO1.setUsrNm(account.getUsr_nm());
			paraVO1.setUsrEml(account.getUsr_eml());
			paraVO1.setAudNo(strAudNo.toString());

			dbDao.modifyAcmCommBkgInfoRevVVD(paraVO1);

			paraVO2 = dbDao.getAcmCsrCondInfo(paraVO1);
			paraVO2.setUsrNm(account.getUsr_nm());
			paraVO2.setUsrEml(account.getUsr_eml());
			paraVO2.setSRevChg(agnCommApprovalMasterVO.getSRevChg());

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
//	        	paraVO2.setAsaNo(paraVO2.getAsaNo().substring(0,3) + paraVO2.getAsaNo().substring(6) + paraVO2.getAsaNo().substring(3,6));
	        	paraVO2.setAsaNo(paraVO2.getAsaNo());
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
		    //CHECK
            if(paraVO2.getErrVvdBkgNo() != null && !"".equals(paraVO2.getErrVvdBkgNo())) {
            	if(paraVO2.getErrVvd() == null || "".equals(paraVO2.getErrVvd())){
            		paraVO2.setErrVvd("does not exist!");
            	}
            	//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$s]!
				throw new DAOException((new ErrorHandler("ACM00012", new String[]{ paraVO2.getErrVvd() + ", BKG_NO : "+paraVO2.getErrVvdBkgNo()})).getMessage());
            }
            //CHECK ERR_VVD_LVL_BKG_NO ERR_VVD_LVL_FLG_BKG_NO
            if(paraVO2.getErrVvdLvlBkgNo() != null && paraVO2.getErrVvdLvlBkgNo().length() != 0) {
            	log.debug("ErrVvdLvlBkgNo ==> "+paraVO2.getErrVvdLvlBkgNo());
            	//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$s]!
				throw new DAOException((new ErrorHandler("ACM00012", new String[]{ paraVO2.getErrVvdLvlVvdCd() + ", BKG_NO : "+paraVO2.getErrVvdLvlBkgNo()})).getMessage());
            }
            //CHECK ERR_VVD_LVL_FLG_BKG_NO
            if(paraVO2.getErrVvdLvlFlgBkgNo() != null && paraVO2.getErrVvdLvlFlgBkgNo().length() != 0) {
            	//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$s]!
				throw new DAOException((new ErrorHandler("ACM00012", new String[]{ paraVO2.getErrVvdLvlFlgVvdCd() + ", BKG_NO : "+paraVO2.getErrVvdLvlFlgBkgNo()})).getMessage());
            }            
            paraVO2.setAudNo(strAudNo.toString());
			dbDao.addCsrHeaderApCsrNo(paraVO2);

			AGNCommApprovalRequestVO tempParaVO = null;
			for (int i=0; i<agnCommApprovalMasterVOs.length; i++) {
				tempParaVO = new AGNCommApprovalRequestVO();
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

			dbDao.addCsrHeaderApInvHdr(paraVO2);
			dbDao.addCsrHeaderApInvDtrb(paraVO2);
			dbDao.modifyCsrHeaderApInvDtrb(paraVO2);

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
//			log.debug("agnCommApprovalMasterVO.getAproStep()=> "+agnCommApprovalMasterVO.getAproStep());
//			ComAproRqstRoutVO[] route = approval.convertApprovalRoute("2/9500384/Oh-Chul KWON/SINWAG/Coord - 1/7346389/Sally SIM/SINWA/Part Leader");
//			ComAproRqstRoutVO[] route = approval.convertApprovalRoute(agnCommApprovalMasterVO.getAproStep());
//			log.info("\n route = "+route.toString());
			//OFC 단위 결재로 변경. APRO_STEP 세팅할 필요 없음 (OFC 만 세팅)
			ComAproRqstRoutVO route = new ComAproRqstRoutVO();
			route.setAproOfcCd(paraVO2.getHAprlOfcCd());
			route.setAproOfcNm(paraVO2.getHAprlOfcNm());
			
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
			dbDao.modifyCsrHeaderAcmAgnComm2(paraVO2);
			dbDao.modifyCsrHeaderAcmAgnOtrComm2(paraVO2);
			//AP_INV_HDR IF_DT, IF_ERR_RSN 업데이트 로직 제거
			//dbDao.modifyCsrHeaderApInvHdr(paraVO2); 

			// History 저장
			paraVO2.setCalcNo(dbDao.getCalcNo());
			dbDao.addAcmAgnCommChgHis(paraVO2);
			dbDao.addAcmAgnCommTrspHis(paraVO2);
			dbDao.addAcmAgnCommDtlHis(paraVO2);
			dbDao.addAcmAgnCommHis(paraVO2);

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

			//2. aud no 등의 데이터 업데이트(UPDATE ACM_AGN_COMM)
			returnCSRMasterVO.setAudNo(audNo);
			returnCSRMasterVO.setUsrId(account.getUsr_id());
			
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
     * @param String flag
     * @param String csrNo
	 * @exception EventException
     */
	public void acmUpdateCSRSTSFlag(String flag, String csrNo) throws EventException{
		String module = "";
		AgentActualINFtoAPCheckVO aPApproVO = new AgentActualINFtoAPCheckVO();


		try {
			
			////업무구분(AGT/BRKG/FAC)을 위한 CSR정보 조회
			aPApproVO.setCsrNo(csrNo);

			aPApproVO = dbDao.searchACMCSRInfo(aPApproVO);
			module = aPApproVO.getSrcCtnt();
			
			/** APPROVAL CONFIRM	*/
			if ( flag.equals("C") ){
				////업무구분별 분기처리
				if(aPApproVO.getSrcCtnt().equals("COMMISSION")){
					//dbDao.modifyApprovalStep(aPApproVO);
					////AP 인터페이스 실행결과를 AGT_AGN_COMM에 UPDATE하기
					dbDao.modifyAGTCommInfo(aPApproVO);
					dbDao.modifyAGTOtherCommInfo(aPApproVO);
				}else{
					boolean isSuccess = true;	//Real:true, Test:false

					dbDao.modifyAGNCommApInvHdr(csrNo);
					////6.AP 인터페이스 실행결과를 AGT_BROG_COMM에 UPDATE하기
					dbDao.modifyFFInfo(isSuccess, csrNo);
				}
				
			/** APPROVAL REJECT	*/
		    } else if ( flag.equals("R") ){
				////업무구분별 분기처리
				if(module.equals("COMMISSION")){
					dbDao.modifyACMApprovalRequesttoEP(aPApproVO);
					dbDao.modifyACMOtherApprovalRequesttoEP(aPApproVO);
				}else{
					dbDao.modifyFFApprovalRequesttoEP(csrNo);
				}
			}

		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

}