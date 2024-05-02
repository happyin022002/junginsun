/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AdjustmentManageBCImpl.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration.AdjustmentManageDBDAO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteWriteOffRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchROCToOfficeListVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -AdjustmentManage Business Logic Basic Command implementation<br>
 * - -AdjustmentManage business logic processing.<br>
 *
 * @author 
 * @see ESD_TPB_0105EventResponse,AdjustmentManageBC DAO class reference
 * @since J2EE 1.6
 */
public class AdjustmentManageBCImpl extends BasicCommandSupport implements AdjustmentManageBC {

	// Database Access Object
	private transient AdjustmentManageDBDAO dbDao = null;

	/**
	 * AdjustmentManageBCImpl object creation<br>
	 * AdjustmentManageDBDAO creation<br>
	 */
	public AdjustmentManageBCImpl() {
		dbDao = new AdjustmentManageDBDAO();
	}
	
	/**
	 * <br>
	 * 
	 * @param SearchROCToOfficeListVO searchROCToOfficeListVO
	 * @return List<SearchROCToOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchROCToOfficeListVO> searchROCToOfficeList(SearchROCToOfficeListVO searchROCToOfficeListVO) throws EventException {
		try {
			return dbDao.searchROCToOfficeList(searchROCToOfficeListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * <br>
	 * 
	 * @param SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO
	 * @return List<SearchResponsibleOfficeChangeVO>
	 * @exception EventException
	 */
	public List<SearchResponsibleOfficeChangeVO> searchResponsibleOfficeChange(SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO) throws EventException {
//		SearchResponsibleOfficeChangeVO sRoVO = searchResponsibleOfficeChangeVO;	
//		String s_vndr_cust_div_cd = sRoVO.getSVndrCustDivCd();
//		log.debug("s_vndr_cust_div_cd =============>["+s_vndr_cust_div_cd+"]");
		try {
			return dbDao.searchResponsibleOfficeChange(searchResponsibleOfficeChangeVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO
	 * @return List<SearchResponsibleOfficeChangeInquiryVO>
	 * @exception EventException
	 */
	public List<SearchResponsibleOfficeChangeInquiryVO> searchResponsibleOfficeChangeInquiry(SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO) throws EventException {
//		SearchResponsibleOfficeChangeInquiryVO sRoVO = searchResponsibleOfficeChangeInquiryVO;	
//		String s_vndr_cust_div_cd = sRoVO.getSVndrCustDivCd();
//		log.debug("s_vndr_cust_div_cd =============>["+s_vndr_cust_div_cd+"]");
		try {
			return dbDao.searchResponsibleOfficeChangeInquiry(searchResponsibleOfficeChangeInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchWriteOffVO searchWriteOffVO
	 * @return List<SearchWriteOffVO>
	 * @exception EventException
	 */
	public List<SearchWriteOffVO> searchWriteOff(SearchWriteOffVO searchWriteOffVO) throws EventException {
//		SearchWriteOffVO sWoVO = searchWriteOffVO;	
//		String s_vndr_cust_div_cd = sWoVO.getSVndrCustDivCd();
//		log.debug("s_vndr_cust_div_cd =============>["+s_vndr_cust_div_cd+"]");
		try {
			return dbDao.searchWriteOff(searchWriteOffVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param SearchWriteOffInquiryVO searchWriteOffInquiryVO
	 * @return List<SearchWriteOffInquiryVO>
	 * @exception EventException
	 */
	public List<SearchWriteOffInquiryVO> searchWriteOffInquiry(SearchWriteOffInquiryVO searchWriteOffInquiryVO) throws EventException {
//		SearchWriteOffInquiryVO sWoIVO = searchWriteOffInquiryVO;	
//		String s_vndr_cust_div_cd = sWoIVO.getSVndrCustDivCd();
//		log.debug("s_vndr_cust_div_cd =============>["+s_vndr_cust_div_cd+"]");
		try {
			return dbDao.searchWriteOffInquiry(searchWriteOffInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createResponsibleOfficeChangeRequest(CreateResponsibleOfficeChangeRequestVO[] createResponsibleOfficeChangeRequestVO, SignOnUserAccount account) throws EventException{
//		CreateResponsibleOfficeChangeRequestVO cRocRVO = createResponsibleOfficeChangeRequestVO[0];
//		String s_user_cd = cRocRVO.getSUserId();
//		log.debug("s_user_cd==>"+s_user_cd);
		try {			
			List<CreateResponsibleOfficeChangeRequestVO> insertVoList = new ArrayList<CreateResponsibleOfficeChangeRequestVO>();
			for ( int i=0; i<createResponsibleOfficeChangeRequestVO .length; i++ ) {
//				CreateResponsibleOfficeChangeRequestVO cRocRVO = createResponsibleOfficeChangeRequestVO[i];
				
				if ( createResponsibleOfficeChangeRequestVO[i].getIbflag().equals("U")){
					createResponsibleOfficeChangeRequestVO[i].setSUserOfcCd(account.getOfc_cd());
					createResponsibleOfficeChangeRequestVO[i].setSFileNo(createResponsibleOfficeChangeRequestVO[0].getSFileNo());
					createResponsibleOfficeChangeRequestVO[i].setSRaRmk1(createResponsibleOfficeChangeRequestVO[0].getSRaRmk1());
//					createResponsibleOfficeChangeRequestVO[i].setSRaRmk2(createResponsibleOfficeChangeRequestVO[0].getSRaRmk2());
					createResponsibleOfficeChangeRequestVO[i].setSUserId(account.getUsr_id());
					insertVoList.add(createResponsibleOfficeChangeRequestVO[i]);
				}
				
				//checking two or more browsers
				String validYn = dbDao.searchStatusCheck(createResponsibleOfficeChangeRequestVO[i]);
				
				if ( !validYn.equals("Y")){
					log.info(" ROC Request Status Check / validYn : " + validYn );
					throw new EventException(new ErrorHandler("TPB00033").getMessage());
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addResponsibleOfficeChangeRequest(insertVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createResponsibleOfficeChangeApprove(CreateResponsibleOfficeChangeApproveVO[] createResponsibleOfficeChangeApproveVO, SignOnUserAccount account) throws EventException{
		CreateResponsibleOfficeChangeApproveVO cRocAVO = createResponsibleOfficeChangeApproveVO[0];
		//List<CreateResponsibleOfficeChangeApproveVO> sRvwSts = new ArrayList<CreateResponsibleOfficeChangeApproveVO>();
		
//		String s_adj = "";
		String s_chk = "";
		String s_chk_app = cRocAVO.getChkApp();
		String s_chk_rej = cRocAVO.getChkRej();
		
		if(s_chk_app.equals("1") && s_chk_rej.equals("0")){
//			updateCs.setString(i++,"E"); // Adjustment-Approve
			s_chk = "E"; // Adjustment-Approve
//			s_adj = "E(approve)";
		}else if(s_chk_app.equals("0") && s_chk_rej.equals("1")){
//			updateCs.setString(i++,"J"); // Adjustment-Reject
			s_chk = "J"; // Adjustment-Reject
//			s_adj = "J(reject)";
		}

		try {
			List<CreateResponsibleOfficeChangeApproveVO> updateVoList = new ArrayList<CreateResponsibleOfficeChangeApproveVO>();
			for ( int i=0; i<createResponsibleOfficeChangeApproveVO .length; i++ ) {
				if ( createResponsibleOfficeChangeApproveVO[i].getIbflag().equals("U")){
					createResponsibleOfficeChangeApproveVO[i].setSChk(s_chk);
					createResponsibleOfficeChangeApproveVO[i].setSUserId(account.getUsr_id());
					updateVoList.add(createResponsibleOfficeChangeApproveVO[i]);
					
					//checking two or more browsers
					String validYn = dbDao.searchDuplicationCheck(createResponsibleOfficeChangeApproveVO[i]);

					if ( !validYn.equals("Y") && !createResponsibleOfficeChangeApproveVO[i].getN2ndRvwChk().equals("Y")){
						log.info(" ROC Office Duplication Check / validYn : " + validYn );
						throw new EventException(new ErrorHandler("TPB00033").getMessage());
					}
				}
			}

			if ( updateVoList.size() > 0 ) {
				//processing Current Adjustment
				dbDao.addResponsibleOfficeChangeApprove(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * <br>
	 * 
	 * @param DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeResponsibleOfficeChangeRequest(DeleteResponsibleOfficeChangeRequestVO[] deleteResponsibleOfficeChangeRequestVO, SignOnUserAccount account) throws EventException{
		try {
			List<DeleteResponsibleOfficeChangeRequestVO> deleteVoList = new ArrayList<DeleteResponsibleOfficeChangeRequestVO>();
			for ( int i=0; i<deleteResponsibleOfficeChangeRequestVO .length; i++ ) {
				DeleteResponsibleOfficeChangeRequestVO rRocRVO = deleteResponsibleOfficeChangeRequestVO[i];	
//				log.debug("rRocVO.getN3ptyNo()=======>"+rRocRVO.getN3ptyNo());
//				log.debug("rRocVO.getSN3ptyNo()=======>"+rRocRVO.getSN3ptyNo());
//				log.debug("rRocVO.getSUserOfcCd()=======>"+rRocRVO.getSUserOfcCd());
//				log.debug("account.getUsr_id()=======>"+account.getUsr_id());
//				log.debug("deleteResponsibleOfficeChangeRequestVO[i].getIbflag()=======>"+deleteResponsibleOfficeChangeRequestVO[i].getIbflag());
				deleteResponsibleOfficeChangeRequestVO[i].setN3ptyNo(rRocRVO.getN3ptyNo());	
				deleteResponsibleOfficeChangeRequestVO[i].setSN3ptyNo(rRocRVO.getSN3ptyNo());
//				deleteResponsibleOfficeChangeRequestVO[i].setSUserOfcCd(rRocRVO.getSUserOfcCd());
				
//				String n3pty_no = dRocRVO.getN3ptyNo();
//				String s_n3pty_no = dRocRVO.getSN3ptyNo();
//				String s_user_ofc_cd = dRocRVO.getSUserOfcCd();
//				String s_user_id = account.getUsr_id();
//				log.debug("s_n3pty_no =============>["+s_n3pty_no+"]");
//				log.debug("n3pty_no =============>["+n3pty_no+"]");
//				log.debug("s_user_ofc_cd =============>["+s_user_ofc_cd+"]");
//				log.debug("s_user_id =============>["+s_user_id+"]");
//				
				if ( deleteResponsibleOfficeChangeRequestVO[i].getIbflag().equals("D")){
					deleteResponsibleOfficeChangeRequestVO[i].setSUserOfcCd(account.getOfc_cd());
					deleteResponsibleOfficeChangeRequestVO[i].setSUserId(account.getUsr_id());
					deleteVoList.add(deleteResponsibleOfficeChangeRequestVO[i]);
				}
			}
//			log.debug("deleteVoList=============>"+deleteVoList);
//			log.debug("deleteVoList.size()=============>"+deleteVoList.size());
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeResponsibleOfficeChangeRequest(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param CreateWriteOffRequestVO[] CreateWriteOffRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createWriteOffRequest(CreateWriteOffRequestVO[] createWriteOffRequestVO, SignOnUserAccount account) throws EventException{
//		CreateWriteOffRequestVO cWORVO = createWriteOffRequestVO[0];
//		String s_user_cd = cWORVO.getSUserId();
//		log.debug("s_user_cd==>"+s_user_cd);
		try {			
			List<CreateWriteOffRequestVO> insertVoList = new ArrayList<CreateWriteOffRequestVO>();
			for ( int i=0; i<createWriteOffRequestVO .length; i++ ) {
				if ( createWriteOffRequestVO[i].getIbflag().equals("U")){
					createWriteOffRequestVO[i].setSFileNo(createWriteOffRequestVO[0].getSFileNo());
					createWriteOffRequestVO[i].setSRaRmk1(createWriteOffRequestVO[0].getSRaRmk1());
					createWriteOffRequestVO[i].setSRaRmk2(createWriteOffRequestVO[0].getSRaRmk2());
					createWriteOffRequestVO[i].setSUserOfcCd(account.getOfc_cd());
					createWriteOffRequestVO[i].setSUserId(account.getUsr_id());
					insertVoList.add(createWriteOffRequestVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addWriteOffRequest(insertVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param CreateWriteOffApproveVO[] createWriteOffApproveVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createWriteOffApprove(CreateWriteOffApproveVO[] createWriteOffApproveVO, SignOnUserAccount account) throws EventException{
		CreateWriteOffApproveVO cWoAVO = createWriteOffApproveVO[0];
		
//		String s_adj = "";
		String s_chk = "";
		String s_chk_app = cWoAVO.getChkApp();
		String s_chk_rej = cWoAVO.getChkRej();
		
		if(s_chk_app.equals("1") && s_chk_rej.equals("0")){
//			updateCs.setString(i++,"E"); // Adjustment-Approve
			s_chk = "E"; // Adjustment-Approve
//			s_adj = "E(approve)";
		}else if(s_chk_app.equals("0") && s_chk_rej.equals("1")){
//			updateCs.setString(i++,"J"); // Adjustment-Reject
			s_chk = "J"; // Adjustment-Reject
//			s_adj = "J(reject)";
		}
		
//		String s_user_cd = cWoAVO.getSUserId();
//		String s_user_ofc_cd = cWoAVO.getSUserOfcCd();
//		String review_step = cWoAVO.getReviewStep();
//		String stl_clt_ofc_cng_amt = cWoAVO.getStlCltOfcCngAmt();
//		String s_ra_rmk1 = cWoAVO.getSRaRmk1();
//		String n3ptyNo = cWoAVO.getN3ptyNo();
//		log.debug("s_chk==>"+s_chk);
//		log.debug("s_adj==>"+s_adj);
//		log.debug("s_user_cd==>"+s_user_cd);
//		log.debug("s_user_ofc_cd==>"+s_user_ofc_cd);
//		log.debug("review_step==>"+review_step);
//		log.debug("stl_clt_ofc_cng_amt==>"+stl_clt_ofc_cng_amt);
//		log.debug("s_ra_rmk1==>"+s_ra_rmk1);
//		log.debug("n3ptyNo==>"+n3ptyNo);
		try {
			List<CreateWriteOffApproveVO> updateVoList = new ArrayList<CreateWriteOffApproveVO>();
			for ( int i=0; i<createWriteOffApproveVO .length; i++ ) {
				if ( createWriteOffApproveVO[i].getIbflag().equals("U")){
					createWriteOffApproveVO[i].setSChk(s_chk);
					createWriteOffApproveVO[i].setSUserId(account.getUsr_id());
					updateVoList.add(createWriteOffApproveVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.addWriteOffApprove(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param DeleteWriteOffRequestVO[] deleteWriteOffRequestVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeWriteOffRequest(DeleteWriteOffRequestVO[] deleteWriteOffRequestVO, SignOnUserAccount account) throws EventException{
		try {
			List<DeleteWriteOffRequestVO> deleteVoList = new ArrayList<DeleteWriteOffRequestVO>();
			for ( int i=0; i<deleteWriteOffRequestVO .length; i++ ) {
				DeleteWriteOffRequestVO rWoRVO = deleteWriteOffRequestVO[i];	
//				log.debug("rRocVO.getN3ptyNo()=======>"+rWoRVO.getN3ptyNo());
//				log.debug("rRocVO.getSN3ptyNo()=======>"+rWoRVO.getSN3ptyNo());
//				log.debug("rRocVO.getSUserOfcCd()=======>"+rWoRVO.getSUserOfcCd());
//				log.debug("account.getUsr_id()=======>"+account.getUsr_id());
//				log.debug("deleteWriteOffRequestVO[i].getIbflag()=======>"+deleteWriteOffRequestVO[i].getIbflag());
				deleteWriteOffRequestVO[i].setN3ptyNo(rWoRVO.getN3ptyNo());	
				deleteWriteOffRequestVO[i].setSN3ptyNo(rWoRVO.getSN3ptyNo());
				//deleteWriteOffRequestVO[i].setSUserOfcCd(rWoRVO.getSUserOfcCd());

				
//				String n3pty_no = rWoRVO.getN3ptyNo();
//				String s_n3pty_no = rWoRVO.getSN3ptyNo();
//				String s_user_ofc_cd = rWoRVO.getSUserOfcCd();
//				String s_user_id = account.getUsr_id();
//				log.debug("s_n3pty_no =============>["+s_n3pty_no+"]");
//				log.debug("n3pty_no =============>["+n3pty_no+"]");
//				log.debug("s_user_ofc_cd =============>["+s_user_ofc_cd+"]");
//				log.debug("s_user_id =============>["+s_user_id+"]");
				
				if ( deleteWriteOffRequestVO[i].getIbflag().equals("D")){
					deleteWriteOffRequestVO[i].setSUserOfcCd(account.getOfc_cd());
					deleteWriteOffRequestVO[i].setSUserId(account.getUsr_id());
					deleteVoList.add(deleteWriteOffRequestVO[i]);
				}
			}
//			log.debug("deleteVoList=============>"+deleteVoList);
//			log.debug("deleteVoList.size()=============>"+deleteVoList.size());
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeWriteOffRequest(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}