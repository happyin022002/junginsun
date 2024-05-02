/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalBCImpl.java
*@FileTitle : FFCmpnApprovalBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.03 김영오
* 1.0 Creation
* 
* History
* 2015.12.28 박다은 [#9182] Change Biz Common Approval Office to Invoice Office
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.basic;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration.FFCmpnApprovalDBDAO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration.FFCmpnApprovalEAIDAO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration.FFCmpnApprovalEAIDAOB;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRHeaderVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRINFtoAPVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRValidCheckVO;
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
 * @see Esm_Acm_0030Event,FFCmpnApprovalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FFCmpnApprovalBCImpl extends BasicCommandSupport implements FFCmpnApprovalBC {

	// Database Access Object
	private transient FFCmpnApprovalDBDAO dbDao = null;
	private transient FFCmpnApprovalEAIDAO eaiDao = null;
	private transient FFCmpnApprovalEAIDAOB eaiDaob = null;

	/**
	 * FFCmpnApprovalBCImpl 객체 생성<br>
	 * FFCmpnApprovalDBDAO를 생성한다.<br>
	 */
	public FFCmpnApprovalBCImpl() {
		dbDao = new FFCmpnApprovalDBDAO();
		eaiDao = new FFCmpnApprovalEAIDAO();
		eaiDaob = new FFCmpnApprovalEAIDAOB();
	}


	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation 목록을 조회<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @return List<FFCmpnApprovalMasterVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalMasterVO> searchFFCmpnApprovalMaster(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) throws EventException {
		try {
			String apOfcCdTmp = ffCmpnApprovalMasterVO.getFApOfcCd();
			if(apOfcCdTmp != null && !apOfcCdTmp.equals("")){
				apOfcCdTmp = "'"+apOfcCdTmp.replaceAll(",", "','") + "'";
				ffCmpnApprovalMasterVO.setFApOfcCd(apOfcCdTmp);
			}
			return dbDao.searchFFCmpnApprovalMaster(ffCmpnApprovalMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation 목록을 조회<br>
	 *
	 * @param FFCmpnApprovalDetailVO ffCmpnApprovalDetailVO
	 * @return List<FFCmpnApprovalDetailVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalDetailVO> searchFFCmpnApprovalDetail(FFCmpnApprovalDetailVO ffCmpnApprovalDetailVO) throws EventException {
		try {
			return dbDao.searchFFCmpnApprovalDetail(ffCmpnApprovalDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approvalFFCmpnApproval(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO, SignOnUserAccount account) throws EventException {
		try {
			ApprovalUtil approval = new ApprovalUtil();
			FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO = new FFCmpnCSRHeaderVO();
			List<FFCmpnCSRDetailVO> ffCmpnCSRDetailVOs = null;
			// COM_APRO_RQST_HDR
			ComAproRqstHdrVO headerInfo = new ComAproRqstHdrVO();
			// COM_APRO_CSR_DTL
			ComAproCsrDtlVO csrInfo = new ComAproCsrDtlVO();
			boolean isEPRequest = true; //Real:true, Test:false
			ComAproRqstRoutVO routeInfo = new ComAproRqstRoutVO();

			//dbDao.searchFFCmpnApprovalRequestList(ffCmpnApprovalMasterVO);
			ffCmpnApprovalMasterVO.setUsrNm(account.getUsr_nm());
			ffCmpnApprovalMasterVO.setUsrEm(account.getUsr_eml());
			ffCmpnApprovalMasterVO.setUsrId(account.getUsr_id());
			//log.debug("\n ffCmpnApprovalMasterVO.getDateDiv(==>"+ffCmpnApprovalMasterVO.getDateDiv());

			//SELECT BKG_CRE_DT for Validation Check
			List<FFCmpnCSRValidCheckVO> ffCmpnCSRValidCheckVOs = dbDao.searchFFCmpnCSRValidCheck(ffCmpnApprovalMasterVO);
			log.debug("ffCmpnCSRValidCheckVOs =>"+ffCmpnCSRValidCheckVOs.toString());
			for(int i = 0; i < ffCmpnCSRValidCheckVOs.size() ; i++) {
				if(ffCmpnCSRValidCheckVOs.get(i).getBkgCreDt() == null || Integer.parseInt(ffCmpnCSRValidCheckVOs.get(i).getBkgCreDt()) < 20070507){
					//[$s] does not exist!, Please check up Again!
					throw new DAOException((new ErrorHandler("ACM00009", new String[]{"[BKG:" + ffCmpnCSRValidCheckVOs.get(i).getBkgNo() + "]Booking creation date(" + ffCmpnCSRValidCheckVOs.get(i).getBkgCreDt() + ") does less than 2007-05-07 or "})).getMessage());
				}
				if("X".equals(ffCmpnCSRValidCheckVOs.get(i).getBkgStsCd()) || "A".equals(ffCmpnCSRValidCheckVOs.get(i).getBkgStsCd())){
					//There is(are) ‘$s’ status booking(s). Please exclude ‘$s’ status booking(s).
					throw new DAOException((new ErrorHandler("ACM00041", new String[]{ffCmpnCSRValidCheckVOs.get(i).getBkgNo()+":"+ffCmpnCSRValidCheckVOs.get(i).getBkgStsCd(),ffCmpnCSRValidCheckVOs.get(i).getBkgStsCd()})).getMessage());
				}
			}
			log.debug("ffCmpnApprovalMasterVO===>"+ffCmpnApprovalMasterVO.toString());
			//SELECT CSR Header
			ffCmpnCSRHeaderVO = dbDao.searchFFCmpnCSRHeader(ffCmpnApprovalMasterVO);
			//CHECK ASA CURR_CD vs INVOICE CURR_CD, EFF_DT vs ASA_FROM_TO_DT
			if(ffCmpnCSRHeaderVO.getAsaNo().length() > 1){
				//ASA_CURR_CD vs INVOICE_CURR_CD Check
				if(!ffCmpnCSRHeaderVO.getCsrCurrCd().equals(ffCmpnCSRHeaderVO.getAsaCurrCd())){
	            	//ASA Currency Code vs Invoice Currency Code does not match! Please check up ASA Info!
        			throw new DAOException((new ErrorHandler("ACM00042", new String[]{"ASA Currency Code vs Invoice Currency Code","ASA Info"})).getMessage());
				}
				//EFF_DT vs ASA_FROM_TO_DT Check
				if("0".equals(ffCmpnCSRHeaderVO.getAsaCnt())){
	            	//ASA From~To Date vs Effective Date does not match! Please check up ASA Info!
	        		throw new DAOException((new ErrorHandler("ACM00042", new String[]{"ASA From~To Date vs Effective Date","ASA Info"})).getMessage());
				}

			}			
			//BL No setting
			ffCmpnCSRHeaderVO.setBlNo(ffCmpnApprovalMasterVO.getBlNo());
			//SELECT GL_DT
			String nGlDt = dbDao.searchFFCmpnCSRGLDT(ffCmpnCSRHeaderVO);
			if(nGlDt == null){
				ffCmpnCSRHeaderVO.setGlDt("01");
			}else{
				ffCmpnCSRHeaderVO.setGlDt(nGlDt);
			}
			
			//INSERT INTO AP_CSR_NO
			dbDao.addFFCmpnCSRAPCSRNO(ffCmpnCSRHeaderVO);
			//UPDATE REV VVD
			dbDao.modifyFFCmpnCSRRevVVD(ffCmpnCSRHeaderVO);
			//UPDATE ACM_SPCL_CMPN
			dbDao.modifyFFCmpnCSRMasterCSRNO(ffCmpnCSRHeaderVO);
			//INSERT INTO AP_INV_HDR
			dbDao.addFFCmpnCSRHeader(ffCmpnCSRHeaderVO);

			//=============================================================================

			ffCmpnCSRDetailVOs = dbDao.searchFFCmpnCSRDetail(ffCmpnCSRHeaderVO);
			log.debug("ffCmpnCSRDetailVOs.size()=>"+ffCmpnCSRDetailVOs.size());
			int detailVoSize = ffCmpnCSRDetailVOs.size();
			for(int i = 0 ; i < detailVoSize ; i++) {
				if(!"".equals(ffCmpnCSRDetailVOs.get(i).getInvDesc()) && !"LEGACY SYSTEM CLEARING".equals(ffCmpnCSRDetailVOs.get(i).getInvDesc())){
				
			    //CHECK(1)
			    if(ffCmpnCSRDetailVOs.get(i).getDtrbCoaRgnCd() == null || ffCmpnCSRDetailVOs.get(i).getDtrbCoaRgnCd().length() < 1) {
			    	//[Region Code] does not exist!, Please check up Again!
			    	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"Region Code"})).getMessage());
			    }

			    //CHECK(2)
			    if(ffCmpnCSRDetailVOs.get(i).getDtrbCoaCtrCd() == null || ffCmpnCSRDetailVOs.get(i).getDtrbCoaCtrCd().length() < 1) {
			    	//[Center Code] does not exist!, Please check up Again!
			    	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"Center Code"})).getMessage());
			    }

			    //CHECK(3)
			    if(ffCmpnCSRDetailVOs.get(i).getBlNo() == null || ffCmpnCSRDetailVOs.get(i).getBlNo().length() < 1) {
			    	//[BL No] does not exist!, Please check up Again!
			    	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"[vendor : " + ffCmpnCSRHeaderVO.getVndrSeq() + "]BL No"})).getMessage());
			    }

			    //CHECK(4)
			    if(ffCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd() == null || ffCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd().length() < 1) {
					//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
					throw new DAOException((new ErrorHandler("ACM00012", new String[]{ffCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd()})).getMessage());
	            }

			    // CHECK(5)
			    String vvdCnt = dbDao.searchFFCmpnCSRDetailVVDCNTCheck(ffCmpnCSRDetailVOs.get(i));
			    log.debug("vvdCnt=>"+vvdCnt);
			    log.debug("ffCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd().substring(0,4)=>"+ffCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd().substring(0,4));
				if (!"CNTC".equals(ffCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd().substring(0,4))) {
					String vvdCd = ffCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd();
					String accountCd = ffCmpnCSRDetailVOs.get(i).getDtrbCoaAcctCd();

					//GET VVD
					if (Integer.parseInt(vvdCnt) < 1) {
						vvdCd = dbDao.searchFFCmpnCSRDetailVVDCDCheck(ffCmpnCSRDetailVOs.get(i));
					}//if(vvdCnt < 1){

					//GET VVD_LEVEL_FLAG
					String vvdLevel = dbDao.searchFFCmpnCSRDetailVVDCOMLVLCheck(vvdCd);
					log.debug("vvdLevel=>"+vvdLevel);
					//CHECK
					if(vvdLevel == null || vvdLevel.length() < 1) {
						//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
						throw new DAOException((new ErrorHandler("ACM00012", new String[]{vvdCd})).getMessage());
					}

					//GET VVD_LVL_FLG
					String vvdFlag = dbDao.searchFFCmpnCSRDetailVVDLVLFLGCheck(vvdLevel, (accountCd == null?"":accountCd));
					log.debug("vvdFlag=>"+vvdFlag);
					//CHECK
					if(!vvdFlag.equals("Y")) {
						//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
						throw new DAOException((new ErrorHandler("ACM00012", new String[]{vvdCd})).getMessage());
					}
				}//if(!vvdCd.substring(1,4).equals("CNTN")){
			  }
			}
			//INSERT INTO ap_inv_dtrb
			dbDao.addFFCmpnCSRDetail(ffCmpnCSRDetailVOs);
			//UPDATE ap_inv_dtrb(SET INV_AMT)
//			dbDao.modifyFFCmpnCSRDetail(ffCmpnCSRDetailVOs);
			dbDao.modifyFFCmpnCSRDetail(ffCmpnCSRHeaderVO);//(Using ffCmpnCSRHeaderVO)
			//UPDATE ACM_AGN_BKG_INFO(SET REV_VVD_CD)
//			dbDao.modifyFFCmpnCSRACMBkgInfo(ffCmpnCSRDetailVOs);//마지막 VO만 업데이트.
			if(detailVoSize > 0) {
				dbDao.modifyFFCmpnCSRACMBkgInfo(ffCmpnCSRDetailVOs.get(detailVoSize-1));//마지막 VO로 1회만 업데이트.
			}
			//UPDATE AP_INV_HDR
			dbDao.modifyFFCmpnCSRHeader(ffCmpnCSRHeaderVO);

			//===========================================================================
		    //3.EP결제 송신하기
			if(isEPRequest) {
				headerInfo.setSubSysCd("ACM");
				//log.debug("\n headerInfo.getSubSysCd())===>"+headerInfo.getSubSysCd());
				headerInfo.setAproKndCd("CSR");
				headerInfo.setRqstOfcCd(account.getOfc_cd());
				headerInfo.setRqstOfcNm(account.getOfc_eng_nm());
				headerInfo.setRqstUsrJbTitNm("");
				headerInfo.setRqstUsrId(account.getUsr_id());
				headerInfo.setRqstUsrNm(account.getUsr_nm());
				headerInfo.setCreUsrId(account.getUsr_id());

				// COM_APRO_RQST_ROUT
				//OFC 단위 결재로 변경. APRO_STEP 세팅할 필요 없음 (OFC 만 세팅)
				ComAproRqstRoutVO route = new ComAproRqstRoutVO();
				//2015.12.28 [#9182] Change Biz Common Approval Office to Invoice Office
				route.setAproOfcCd(ffCmpnCSRHeaderVO.getApOfcCd());
				route.setAproOfcNm(ffCmpnCSRHeaderVO.getAproOfcNm());
				
				//SELECT CSR INFORMATION
				csrInfo = dbDao.searchFFCmpnCSRInfo(ffCmpnCSRHeaderVO);

				// 결재 등록
				approval.saveCsrApro(headerInfo, route, csrInfo);
				//UPDATE ACM_SPCL_CMPN
				dbDao.modifyFFCmpnCSRACMMaster(ffCmpnCSRHeaderVO);
				//UPDATE AP_INV_HDR
				//dbDao.modifyFFCmpnCSRHeader2(ffCmpnCSRHeaderVO);
			} else {
			//===========================================================================

				routeInfo.setAproUsrNm("BRKG_TEST");
				transferFFINFtoAP(ffCmpnCSRHeaderVO, routeInfo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation 엑셀다운 목록을 조회(Excel)<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @return List<FFCmpnApprovalMasterVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalMasterVO> searchFFCmpnApprovalExcelDown(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) throws EventException {
		try {
			return dbDao.searchFFCmpnApprovalExcelDown(ffCmpnApprovalMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation RD프린트 목록을 조회(Master)<br>
	 *
	 * @param FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO
	 * @return List<FFCmpnApprovalPrintMasterVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalPrintMasterVO> searchFFCmpnApprovalPrint(FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO) throws EventException{
		try {
			return dbDao.searchFFCmpnApprovalPrint(ffCmpnApprovalPrintMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation CSR_RD프린트 목록을 조회(Master)<br>
	 *
	 * @param FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO
	 * @return List<FFCmpnApprovalPrintMasterVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalPrintMasterVO> searchFFCmpnApprovalPrintMaster(FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO) throws EventException{
		try {
			return dbDao.searchFFCmpnApprovalPrintMaster(ffCmpnApprovalPrintMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation CSR_RD프린트 목록을 조회(Detail)<br>
	 *
	 * @param FFCmpnApprovalPrintDetailVO ffCmpnApprovalPrintDetailVO
	 * @return List<FFCmpnApprovalPrintDetailVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalPrintDetailVO> searchFFCmpnApprovalPrintDetail(FFCmpnApprovalPrintDetailVO ffCmpnApprovalPrintDetailVO) throws EventException{
		try {
			return dbDao.searchFFCmpnApprovalPrintDetail(ffCmpnApprovalPrintDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
     * @param  FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO
     * @param  ComAproRqstRoutVO routeInfo
     * @return FNS0080003Document[]
     * @throws EventException
     */
	public FNS0080003Document[] transferFFINFtoAP(FFCmpnCSRHeaderVO ffCmpnCSRHeaderVO, ComAproRqstRoutVO routeInfo) throws EventException {
		boolean isSuccess = true;	//Real:true, Test:false
		FNS0080003Document docReq[]	= null;
		try {
			//AP 인터페이스 실행하기
			if(isSuccess){
				List<FFCmpnCSRINFtoAPVO> ffCmpnCSRINFtoAPVOs = dbDao.searchFFINFtoAP(ffCmpnCSRHeaderVO);
				docReq = eaiDaob.transferAtOnceACMToEAIByWS(ffCmpnCSRHeaderVO.getCsrNo(), routeInfo, ffCmpnCSRINFtoAPVOs);
			}
			log.info("\n docReq = "+docReq);
			return docReq;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
     * ESM_AGT_018 화면에 대한 인터페이스 이벤트 처리(2) : EP결재 수신 + CSR I/F<br>
     *
     * @param  String result
     * @param  String csrNo
     * @param  ComAproRqstRoutVO model
     * @return FNS0080003Document[]
     * @throws EventException
     */
	public FNS0080003Document[] transferFFActualINFtoAP1(String result,
			String csrNo, ComAproRqstRoutVO model) throws EventException {
		DBRowSet rowSet = null;						//데이터 전송을 위해 DB ResultSet을 구현한 객체
		//String aproNm = "";
		boolean isSuccess = true;	//Real:true, Test:false
		// 2007.06.04 추가
		FNS0080003Document docReq[]		= null;

		try {
			//aproNm = model.getAproUsrNm();	//최종결재자명
			//if(aproNm == null) aproNm = " ";	//최종결재자명 공백처리
			//if(result == null) result = "C";		//flag값이 NULL인 경우, 승인한것으로 간주한다

			if(result.equals("R")){
				//반려시
				dbDao.modifyFFApprovalRequesttoEP(csrNo);

			}else{

				////5.AP 인터페이스 실행하기
				log.info("\n isSuccess = "+isSuccess);
				if(isSuccess){
					//REAL
					rowSet = dbDao.searchFFActualINFtoAP(csrNo);
					docReq = eaiDao.transferAtOnceFFToEAIByWS(csrNo, rowSet, model); //2007.05.31 modify
				}
				log.info("\n docReq = "+docReq);
			}//if(result.equals("R")){

			return docReq;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
     * ESM_AGT_018 화면에 대한 인터페이스 이벤트 처리(2) : EP결재 수신 + CSR I/F<br>
     *
     * @param  String result
     * @param  String csrNo
     * @param  ComAproRqstRoutVO model
     * @return String
     * @throws EventException
     */
	public String transferFFActualINFtoAP2(String result, String csrNo,
			ComAproRqstRoutVO model)
			throws EventException {
//	public String transferBRKGActualINFtoAP2(String result, String csrNo,
//				COM_APRO_RQST_ROUT model, String pgmNo)
//				throws EventException {
		//String aproNm = "";
		HashMap eaiHash = new HashMap();
		String title_name = "";
		String usr_jb_tit_nm = "";
		String usr_nm = "";
		boolean isSuccess = true;	//Real:true, Test:false

		try {
//			if( doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray().length > 0 )
//			{
//				hdr_gl_dt = doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray()[0].getHGLDATE();
//			}

			//aproNm = model.getAproUsrNm();	//최종결재자명
			//if(aproNm == null) aproNm = " ";	//최종결재자명 공백처리
			//if(result == null) result = "C";		//flag값이 NULL인 경우, 승인한것으로 간주한다

			if(!result.equals("R")){
				//승인시
				////4.AP_INV_IF에 INSERT하기
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

				title_name = usr_jb_tit_nm + "/" + usr_nm;
//				dbDao.modifyApprovalStep(title_name, csrNo, hdr_gl_dt);
				dbDao.modifyApprovalStep(title_name, csrNo);

				eaiHash.put("isSuccess", "Y");

				dbDao.modifyFFCmpnApInvHdr(csrNo);

				////6.AP 인터페이스 실행결과를 AGT_BROG_COMM에 UPDATE하기
//2011.07.07 이정수 R4J				isSuccess = ((String)eaiHash.get("isSuccess") == "Y"?true:false);
				isSuccess = ("Y".equals((String)eaiHash.get("isSuccess")) ?true:false);
				dbDao.modifyFFInfo(isSuccess, csrNo);
			}//if(result.equals("R")){

			return "";
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

}