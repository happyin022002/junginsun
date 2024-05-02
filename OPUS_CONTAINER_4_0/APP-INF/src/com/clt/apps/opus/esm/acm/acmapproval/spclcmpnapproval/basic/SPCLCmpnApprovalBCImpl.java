/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalBCImpl.java
*@FileTitle : SPCLCmpnApprovalBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.03 김영오
* 1.0 Creation
* 
* History
* 2016.01.04 박다은 [#9182] Change Biz Common Approval Office to Invoice Office
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration.SPCLCmpnApprovalDBDAO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration.SPCLCmpnApprovalEAIDAO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRHeaderVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRINFtoAPVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRValidCheckVO;
import com.clt.bizcommon.approval.util.ApprovalUtil;
import com.clt.framework.component.message.ErrorHandler;
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
 * @see Esm_Acm_0031Event,SPCLCmpnApprovalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SPCLCmpnApprovalBCImpl extends BasicCommandSupport implements SPCLCmpnApprovalBC {

	// Database Access Object
	private transient SPCLCmpnApprovalDBDAO dbDao = null;
	private transient SPCLCmpnApprovalEAIDAO eaiDao = null;

	/**
	 * SPCLCmpnApprovalBCImpl 객체 생성<br>
	 * SPCLCmpnApprovalDBDAO를 생성한다.<br>
	 */
	public SPCLCmpnApprovalBCImpl() {
		dbDao = new SPCLCmpnApprovalDBDAO();
		eaiDao = new SPCLCmpnApprovalEAIDAO();
	}

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation 목록을 조회<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @return List<SPCLCmpnApprovalMasterVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalMasterVO> searchSPCLCmpnApprovalMaster(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO) throws EventException {
		try {
			return dbDao.searchSPCLCmpnApprovalMaster(spCLCmpnApprovalMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation 목록을 조회<br>
	 *
	 * @param SPCLCmpnApprovalDetailVO spCLCmpnApprovalDetailVO
	 * @return List<SPCLCmpnApprovalDetailVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalDetailVO> searchSPCLCmpnApprovalDetail(SPCLCmpnApprovalDetailVO spCLCmpnApprovalDetailVO) throws EventException {
		try {
			return dbDao.searchSPCLCmpnApprovalDetail(spCLCmpnApprovalDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approvalSPCLCmpnApproval(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO, SignOnUserAccount account) throws EventException{
		try {
			ApprovalUtil approval = new ApprovalUtil();
			SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO = new SPCLCmpnCSRHeaderVO();
			List<SPCLCmpnCSRDetailVO> spCLCmpnCSRDetailVOs = null;
			// COM_APRO_RQST_HDR
			ComAproRqstHdrVO headerInfo = new ComAproRqstHdrVO();
			// COM_APRO_CSR_DTL
			ComAproCsrDtlVO csrInfo = new ComAproCsrDtlVO();
			boolean isEPRequest = true; //Real:true, Test:false
			ComAproRqstRoutVO routeInfo = new ComAproRqstRoutVO();

			//dbDao.searchSPCLCmpnApprovalRequestList(spCLCmpnApprovalMasterVO);
			spCLCmpnApprovalMasterVO.setUsrNm(account.getUsr_nm());
			spCLCmpnApprovalMasterVO.setUsrEml(account.getUsr_eml());
			spCLCmpnApprovalMasterVO.setUsrId(account.getUsr_id());
			//log.debug("\n spCLCmpnApprovalMasterVO.getDateDiv(==>"+spCLCmpnApprovalMasterVO.getDateDiv());

			//1.SELECT BKG_CRE_DT, BKG_STS_CD for Validation Check
			List<SPCLCmpnCSRValidCheckVO> spCLCmpnCSRValidCheckVOs = dbDao.searchSPCLCmpnCSRValidCheck(spCLCmpnApprovalMasterVO);
			log.debug("ffCmpnCSRValidCheckVOs =>"+spCLCmpnCSRValidCheckVOs.toString());
			for(int i = 0; i < spCLCmpnCSRValidCheckVOs.size() ; i++){
				if(spCLCmpnCSRValidCheckVOs.get(i).getBkgCreDt() == null || Integer.parseInt(spCLCmpnCSRValidCheckVOs.get(i).getBkgCreDt()) < 20070507){
					//[$s] does not exist!, Please check up Again!
					throw new DAOException((new ErrorHandler("ACM00009", new String[]{"[BKG:" + spCLCmpnCSRValidCheckVOs.get(i).getBkgNo() + "]Booking creation date(" + spCLCmpnCSRValidCheckVOs.get(i).getBkgCreDt() + ") does less than 2007-05-07 or "})).getMessage());
				}
				if("X".equals(spCLCmpnCSRValidCheckVOs.get(i).getBkgStsCd()) || "A".equals(spCLCmpnCSRValidCheckVOs.get(i).getBkgStsCd())){
					//There is(are) ‘$s’ status booking(s). Please exclude ‘$s’ status booking(s).
					throw new DAOException((new ErrorHandler("ACM00041", new String[]{spCLCmpnCSRValidCheckVOs.get(i).getBkgStsCd(),spCLCmpnCSRValidCheckVOs.get(i).getBkgStsCd()})).getMessage());
				}
			}
			//2.SELECT CSR Header
			log.debug("spCLCmpnApprovalMasterVO===>"+spCLCmpnApprovalMasterVO.toString());
			spCLCmpnCSRHeaderVO = dbDao.searchSPCLCmpnCSRHeader(spCLCmpnApprovalMasterVO);
			//2-1.CHECK ASA CURR_CD vs INVOICE CURR_CD, EFF_DT vs ASA_FROM_TO_DT
			if(spCLCmpnApprovalMasterVO.getAsaNo().length() > 1){
				//ASA_CURR_CD vs INVOICE_CURR_CD Check
				if(!spCLCmpnCSRHeaderVO.getCsrCurrCd().equals(spCLCmpnCSRHeaderVO.getAsaCurrCd())){
	            	//ASA Currency Code vs Invoice Currency Code does not match! Please check up ASA Info!
        			throw new DAOException((new ErrorHandler("ACM00042", new String[]{"ASA Currency Code vs Invoice Currency Code","ASA Info"})).getMessage());
				}
				//EFF_DT vs ASA_FROM_TO_DT Check
				if("0".equals(spCLCmpnCSRHeaderVO.getAsaCnt())){
	            	//ASA From~To Date vs Effective Date does not match! Please check up ASA Info!
	        		throw new DAOException((new ErrorHandler("ACM00042", new String[]{"ASA From~To Date vs Effective Date","ASA Info"})).getMessage());
				}

			}
			//3.SELECT GL_DT
			String nGlDt = dbDao.searchSPCLCmpnCSRGLDT(spCLCmpnCSRHeaderVO);
			if(nGlDt == null){
				spCLCmpnCSRHeaderVO.setGlDt("01");
			}else{
				spCLCmpnCSRHeaderVO.setGlDt(nGlDt);
			}
			
//			spCLCmpnCSRHeaderVO.setGlDt(dbDao.searchSPCLCmpnCSRGLDT(spCLCmpnCSRHeaderVO));
			log.debug("spCLCmpnCSRHeaderVO===>"+spCLCmpnCSRHeaderVO.toString());
			//4.INSERT INTO AP_CSR_NO
			dbDao.addSPCLCmpnCSRAPCSRNO(spCLCmpnCSRHeaderVO);
			//5.UPDATE REV VVD
			dbDao.modifySPCLCmpnCSRRevVVD(spCLCmpnCSRHeaderVO);//하단에 dbDao.modifySPCLCmpnCSRACMBkgInfo(spCLCmpnCSRDetailVOs)와의 관계는??
			//6.UPDATE ACM_SPCL_CMPN
			dbDao.modifySPCLCmpnCSRMasterCSRNO(spCLCmpnCSRHeaderVO);
			//7.INSERT INTO AP_INV_HDR
			dbDao.addSPCLCmpnCSRHeader(spCLCmpnCSRHeaderVO);

			//=============================================================================

			//조회
			spCLCmpnCSRDetailVOs = dbDao.searchSPCLCmpnCSRDetail(spCLCmpnCSRHeaderVO);//<<<<<<<<< 02
			log.debug("spCLCmpnCSRDetailVOs.size()=>"+spCLCmpnCSRDetailVOs.size());
			int detailVoSize = spCLCmpnCSRDetailVOs.size();
			for(int i = 0 ; i < detailVoSize ; i++) {

				if(!"V.A.T".equals(spCLCmpnCSRDetailVOs.get(i).getInvDesc()) && !"".equals(spCLCmpnCSRDetailVOs.get(i).getInvDesc()) && !"LEGACY SYSTEM CLEARING".equals(spCLCmpnCSRDetailVOs.get(i).getInvDesc())){

				    //CHECK(1)
				    if(spCLCmpnCSRDetailVOs.get(i).getDtrbCoaRgnCd() == null || spCLCmpnCSRDetailVOs.get(i).getDtrbCoaRgnCd().length() < 1){
				    	//[Region Code] does not exist!, Please check up Again!
				    	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"Region Code"})).getMessage());
				    }

				    //CHECK(2)
				    if(spCLCmpnCSRDetailVOs.get(i).getDtrbCoaCtrCd() == null || spCLCmpnCSRDetailVOs.get(i).getDtrbCoaCtrCd().length() < 1){
				    	//[Center Code] does not exist!, Please check up Again!
				    	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"Center Code"})).getMessage());
				    }

				    //CHECK(3)
				    if(spCLCmpnCSRDetailVOs.get(i).getBlNo() == null || spCLCmpnCSRDetailVOs.get(i).getBlNo().length() < 1){
				    	//[BL No] does not exist!, Please check up Again!
				    	throw new DAOException((new ErrorHandler("ACM00009", new String[]{"[vendor : " + spCLCmpnCSRHeaderVO.getVndrSeq() + "]BL No"})).getMessage());
				    }

				    //CHECK(4)
				    if(spCLCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd() == null || spCLCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd().length() < 1) {
						//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
						throw new DAOException((new ErrorHandler("ACM00012", new String[]{spCLCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd()})).getMessage());
		            }

				    // CHECK(5)
				    String vvdCnt = dbDao.searchSPCLCmpnCSRDetailVVDCNTCheck(spCLCmpnCSRDetailVOs.get(i));//<<<<<<<<< 02
				    log.debug("vvdCnt=>"+vvdCnt);
				    log.debug("spCLCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd().substring(0,4)=>"+spCLCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd().substring(0,4));
					if (!"CNTC".equals(spCLCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd().substring(0,4))) {
						String vvdCd = spCLCmpnCSRDetailVOs.get(i).getDtrbCoaVvdCd();
						String accountCd = spCLCmpnCSRDetailVOs.get(i).getDtrbCoaAcctCd();

						//GET VVD
						if (Integer.parseInt(vvdCnt) < 1) {
							vvdCd = dbDao.searchSPCLCmpnCSRDetailVVDCDCheck(spCLCmpnCSRDetailVOs.get(i));//<<<<<<<<< 02
						}

						//GET VVD_LEVEL_FLAG
						String vvdLevel = dbDao.searchSPCLCmpnCSRDetailVVDCOMLVLCheck(vvdCd);//<<<<<<<<< 02
						log.debug("vvdLevel=>"+vvdLevel);
						//CHECK
						if(vvdLevel == null || vvdLevel.length() < 1) {
							//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
							throw new DAOException((new ErrorHandler("ACM00012", new String[]{vvdCd})).getMessage());
						}

						//GET VVD_LVL_FLG
						String vvdFlag = dbDao.searchSPCLCmpnCSRDetailVVDLVLFLGCheck(vvdLevel, (accountCd == null?"":accountCd));//<<<<<<<<<완료 02
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
			dbDao.addSPCLCmpnCSRDetail(spCLCmpnCSRDetailVOs);//<<<<<<<<< 02
			//UPDATE ap_inv_dtrb(SET INV_AMT)
//			dbDao.modifySPCLCmpnCSRDetail(spCLCmpnCSRDetailVOs);//<<<<<<<<< 02
			dbDao.modifySPCLCmpnCSRDetail(spCLCmpnCSRHeaderVO);//Using spCLCmpnCSRHeaderVO<<<<<<<<< 02
			//UPDATE ACM_AGN_BKG_INFO(SET REV_VVD_CD)
//			dbDao.modifySPCLCmpnCSRACMBkgInfo(spCLCmpnCSRDetailVOs);//<<<<<<<<< 02
			if(detailVoSize > 0) {
				dbDao.modifySPCLCmpnCSRACMBkgInfo(spCLCmpnCSRDetailVOs.get(detailVoSize-1));//<<<<<<<<< 02
			}
			//UPDATE AP_INV_HDR
			dbDao.modifySPCLCmpnCSRHeader(spCLCmpnCSRHeaderVO);//<<<<<<<<< 03

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
				//2016.01.04 [#9182] Change Biz Common Approval Office to Invoice Office
				route.setAproOfcCd(spCLCmpnCSRHeaderVO.getApOfcCd());
				route.setAproOfcNm(spCLCmpnCSRHeaderVO.getAproOfcNm());
				
				//SELECT CSR INFORMATION
				csrInfo = dbDao.searchSPCLCmpnCSRInfo(spCLCmpnCSRHeaderVO);//<<<<<<<<< 04

				// 결재 등록
				approval.saveCsrApro(headerInfo, route, csrInfo);
				//UPDATE ACM_SPCL_CMPN
				dbDao.modifySPCLCmpnCSRACMMaster(spCLCmpnCSRHeaderVO);//<<<<<<<<< 04
				//UPDATE AP_INV_HDR
				//dbDao.modifySPCLCmpnCSRHeader2(spCLCmpnCSRHeaderVO);//<<<<<<<<< 04
			} else {
			//===========================================================================

				routeInfo.setAproUsrNm("SPCL_TEST");
				transferSPCLINFtoAP(spCLCmpnCSRHeaderVO, routeInfo);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0031] Ex.Rate Input<br>
	 * Special Compensation CSR Creation Ex.Rate Input<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO[] spCLCmpnApprovalMasterVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSPCLCmpnApproval(SPCLCmpnApprovalMasterVO[] spCLCmpnApprovalMasterVOs,SignOnUserAccount account) throws EventException {
		try {
			
			List<SPCLCmpnApprovalMasterVO> updateVoList = new ArrayList<SPCLCmpnApprovalMasterVO>();;
			
			for (int i=0; i<spCLCmpnApprovalMasterVOs.length; i++) {
				spCLCmpnApprovalMasterVOs[i].setUsrId(account.getUsr_id());
				spCLCmpnApprovalMasterVOs[i].setPayXchRt(spCLCmpnApprovalMasterVOs[i].getPayXchRt());
				updateVoList = dbDao.searchRateInputTarget(spCLCmpnApprovalMasterVOs[i]);
			}
			if (updateVoList.size() > 0) { 
				dbDao.manageSPCLCmpnApproval(updateVoList); //update ACM_SPCL_CMPN 
				dbDao.manageSPCLCmpnApprovalDtl(updateVoList); //update ACM_SPCL_CMPN_DTL
			}
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
     * @param  SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO
     * @param  ComAproRqstRoutVO routeInfo
     * @return FNS0080003Document[]
     * @throws EventException
     */
	public FNS0080003Document[] transferSPCLINFtoAP(SPCLCmpnCSRHeaderVO spCLCmpnCSRHeaderVO, ComAproRqstRoutVO routeInfo) throws EventException {
		boolean isSuccess = true;	//Real:true, Test:false
		FNS0080003Document docReq[]	= null;
		try {
			//AP 인터페이스 실행하기
			if(isSuccess){
				List<SPCLCmpnCSRINFtoAPVO> ffCmpnCSRINFtoAPVOs = dbDao.searchSPCLINFtoAP(spCLCmpnCSRHeaderVO);
				docReq = eaiDao.transferAtOnceACMToEAIByWS(spCLCmpnCSRHeaderVO.getCsrNo(), routeInfo, ffCmpnCSRINFtoAPVOs);
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
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation 엑셀다운 목록을 조회(Excel)<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @return List<SPCLCmpnApprovalMasterVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalMasterVO> searchSPCLCmpnApprovalExcelDown(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO) throws EventException {
		try {
			return dbDao.searchSPCLCmpnApprovalExcelDown(spCLCmpnApprovalMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation RD프린트 목록을 조회(Master)<br>
	 *
	 * @param SPCLCmpnApprovalPrintMasterVO spCLCmpnApprovalPrintMasterVO
	 * @return List<SPCLCmpnApprovalPrintMasterVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalPrintMasterVO> searchSPCLCmpnApprovalPrintMaster(SPCLCmpnApprovalPrintMasterVO spCLCmpnApprovalPrintMasterVO) throws EventException{
		try {
			return dbDao.searchSPCLCmpnApprovalPrintMaster(spCLCmpnApprovalPrintMasterVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation RD프린트 목록을 조회(Detail)<br>
	 *
	 * @param SPCLCmpnApprovalPrintDetailVO spCLCmpnApprovalPrintDetailVO
	 * @return List<SPCLCmpnApprovalPrintDetailVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalPrintDetailVO> searchSPCLCmpnApprovalPrintDetail(SPCLCmpnApprovalPrintDetailVO spCLCmpnApprovalPrintDetailVO) throws EventException{
		try {
			return dbDao.searchSPCLCmpnApprovalPrintDetail(spCLCmpnApprovalPrintDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}