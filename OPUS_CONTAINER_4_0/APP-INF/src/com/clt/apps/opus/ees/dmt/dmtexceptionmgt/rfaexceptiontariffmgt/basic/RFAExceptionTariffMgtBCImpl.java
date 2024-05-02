/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtBCImp.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration.RFAExceptionTariffMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionDeleteVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVersionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionGRPVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 *
 * @author
 * @see reference DAO class of EES_DMT_2003EventResponse,RFAExceptionTariffMgtBC
 * @since J2EE 1.6
 */
public class RFAExceptionTariffMgtBCImpl extends BasicCommandSupport implements
		RFAExceptionTariffMgtBC {
	
	// Database Access Object
	private transient RFAExceptionTariffMgtDBDAO dbDao = null;

	/**
	 * RFAExceptionTariffMgtBCImpl Create object<br>
	 * Create RFAExceptionTariffMgtDBDAO.<br>
	 */
	public RFAExceptionTariffMgtBCImpl() {
		dbDao = new RFAExceptionTariffMgtDBDAO();
	}
	
	
	/**
	 * Search DAR No of Before Booking Proposal No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeDARList(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchBeforeDARList(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Search Version Before Booking DAR No.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeVERList(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchBeforeVERList(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Search Before Booking Exception. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<BeforeExceptionVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionVO> searchBeforeExceptionList(RFAProgressVO rFAProgressVO) throws EventException {
		List<BeforeExceptionVO> beforeExceptionVOs = null;
		try {
			beforeExceptionVOs = dbDao.searchBeforeExceptionList(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return beforeExceptionVOs;		
	}
	
	
	/**
	 * Search Actual Customer. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */	
	public List<RFAExceptionCustomerVO> searchCustomerListByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		
		List<RFAExceptionCustomerVO> list = null;
		try {
			list = dbDao.searchCustomerListByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * Search  Affiliate of Proposal No.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */	
	public List<RFAExceptionCustomerVO> searchAffiliateListByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		
		List<RFAExceptionCustomerVO> list = null;
		try {
			list = dbDao.searchAffiliateListByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * Search Proposal No of DAR No. or Approval No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */	
	public List<RFAProgressVO> searchPropNoByDARApprovalNo(RFAProgressVO rFAProgressVO) throws EventException {
		
		List<RFAProgressVO> list = null;
		try {
			list = dbDao.searchPropNoByDARApprovalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 *  Search DAR No. for Creation. <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String bkgTpCd
	 * @return String
	 * @exception EventException
	 */	
	public String searchNewDAR(SignOnUserAccount account, String bkgTpCd) throws EventException {
		try {
			return dbDao.searchNewDAR(account, bkgTpCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	
	/**
	 * Search Comment History of Version. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchCommentHistory(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	
	/**
	 * Create, Modify and Delete Before Booking Exception.<br>
	 * 
	 * @param RFAExceptionGRPVO rFAExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return RFAProgressVO
	 * @exception EventException
	 */
	public RFAProgressVO modifyBeforeException(RFAExceptionGRPVO rFAExceptionGRPVO, SignOnUserAccount account) throws EventException {

		//Create object for result.
		RFAProgressVO	rFAProgressVO 	= new RFAProgressVO();
		
		try {
			//Before Booking Request Tariff 의 Version ==================================================================================
			BeforeExceptionVersionVO 		beforeExceptionVersionVO 	= rFAExceptionGRPVO.getBeforeExceptionVersionVO();
			
			beforeExceptionVersionVO.setCreUsrId(		account.getUsr_id()		);
			beforeExceptionVersionVO.setCreOfcCd(		account.getOfc_cd()		);
			beforeExceptionVersionVO.setUpdUsrId(		account.getUsr_id()		);
			beforeExceptionVersionVO.setUpdOfcCd(		account.getOfc_cd()		);	
			beforeExceptionVersionVO.setRqstUsrId(		account.getUsr_id()		);
			beforeExceptionVersionVO.setRqstOfcCd(		account.getOfc_cd()		);
			//==========================================================================================================================

			// Detail information of Before Booking Request ======================================================================================
			BeforeExceptionVO				beforeExceptionVO			= null;
			List<BeforeExceptionVO>	 		beforeExceptionVOs 			= rFAExceptionGRPVO.getBeforeExceptionVOS();
			
			//[2016.01.04] NYK Add
			rFAProgressVO												= rFAExceptionGRPVO.getRFAProgressVO();

			if (beforeExceptionVOs != null) {
				beforeExceptionVO = beforeExceptionVOs.get(0);
				
				beforeExceptionVO.setCreUsrId(account.getUsr_id());
				beforeExceptionVO.setCreOfcCd(account.getOfc_cd());
				
				//case in Create DAR No.============================================================================================
				if ("I".equals(beforeExceptionVO.getIbflag()) && beforeExceptionVO.getRfaExptDarNo().length() == 0) {
					//Create DAR No.
					rFAProgressVO.setRfaExptDarNo(dbDao.searchNewDAR(account, "B"));
					
					//Set Before Exception Request Version
					beforeExceptionVersionVO.setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
					//Set Before Exception Request Detail
					beforeExceptionVO.setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
				}
				//======================================================================================================================
				
				//BKG DEL(I) or POR(O)
				if ("US".equals(beforeExceptionVO.getFnlDestCntCd()) || "CA".equals(beforeExceptionVO.getFnlDestCntCd())) {
					beforeExceptionVO.setFnlDestSteCd(beforeExceptionVO.getFnlDestRgnCd());
					beforeExceptionVO.setFnlDestRgnCd("");
				}

				//Search  Version information of Before Booking Request.
				if (!dbDao.existBeforeExceptionVersion(beforeExceptionVersionVO)) {
					//if there is no Version information,  Create.
					dbDao.addBeforeExceptionVersion(beforeExceptionVersionVO);
				}
				else {
					//if there is Version information, status of Version change to 'Temp.Saved'.
					dbDao.modifyVersionSTS(beforeExceptionVersionVO);
				}
				
				// create Temp history at Version Prog table.
				// if previous version' status is 'Temp.Saved' , then modify else create.
				if (dbDao.isTempSavedStatusOfLastVersionProg(beforeExceptionVersionVO)) {
					dbDao.modifyLastVersionProg(beforeExceptionVersionVO);
				}
				else {
					dbDao.addBeforeExceptionVersionProg(beforeExceptionVersionVO);
				}

				if ("I".equals(beforeExceptionVO.getIbflag())) {
					//Search Detail Seq. information.
					rFAProgressVO.setRfaRqstDtlSeq(dbDao.searchBeforeExceptionDetailSeq(beforeExceptionVO));
					if (rFAProgressVO.getRfaRqstDtlSeq() == null) {
						throw new EventException("DMT00003");
					}
					
					//Create Before Booking Request information.
					beforeExceptionVO.setRfaRqstDtlSeq(rFAProgressVO.getRfaRqstDtlSeq());
					dbDao.addBeforeExceptionDetail(beforeExceptionVO);
				}
				else if ("U".equals(beforeExceptionVO.getIbflag())) {
					beforeExceptionVO.setUpdUsrId(account.getUsr_id());
					beforeExceptionVO.setUpdOfcCd(account.getOfc_cd());
					
					//Modify Before Booking Request information.	
					dbDao.modifyBeforeExceptionDetail(beforeExceptionVO);
				}
				

				//[2016.01.04] NYK Add
				rFAProgressVO.setRfaExptDarNo(beforeExceptionVO.getRfaExptDarNo());
				rFAProgressVO.setRfaExptMapgSeq(beforeExceptionVO.getRfaExptMapgSeq());
				rFAProgressVO.setRfaExptVerSeq(beforeExceptionVO.getRfaExptVerSeq());
				rFAProgressVO.setRfaRqstDtlSeq(beforeExceptionVO.getRfaRqstDtlSeq());
				rFAProgressVO.setCvrgCmbSeq(beforeExceptionVO.getCvrgCmbSeq());
			}
			
			log.debug(
					"\n========================================================="+
					"\nAfter getRfaExptDarNo ["+rFAProgressVO.getRfaExptDarNo()+"]"+
					"\nAfter getRfaExptMapgSeq ["+rFAProgressVO.getRfaExptMapgSeq()+"]"+
					"\nAfter getRfaExptVerSeq ["+rFAProgressVO.getRfaExptVerSeq()+"]"+
					"\nAfter getRfaRqstDtlSeq ["+rFAProgressVO.getRfaRqstDtlSeq()+"]"+
					"\nAfter getCvrgCmbSeq ["+rFAProgressVO.getCvrgCmbSeq()+"]"+
					"\n=========================================================");
			
			//=========================================================================================================================
			
			
			// Detail Seq.of Before Booking Request is  Multi Origin or Dest. ====================================================
			List<RFAExceptionCoverageVO>	rFAExceptionCoverageVOs			= rFAExceptionGRPVO.getRFAExceptionCoverageVOS();
			List<RFAExceptionCoverageVO> 	insRFAExceptionCoverageVOs 		= new ArrayList<RFAExceptionCoverageVO>();
			List<RFAExceptionCoverageVO> 	updRFAExceptionCoverageVOs 		= new ArrayList<RFAExceptionCoverageVO>();
			List<RFAExceptionCoverageVO> 	delRFAExceptionCoverageVOs 		= new ArrayList<RFAExceptionCoverageVO>();
			
			if (rFAExceptionCoverageVOs != null) {
				for (int i = 0 ; i < rFAExceptionCoverageVOs.size(); i++) {

					//Coverage
					if ("US".equals(rFAExceptionCoverageVOs.get(i).getCvrgCntCd()) || "CA".equals(rFAExceptionCoverageVOs.get(i).getCvrgCntCd())) {
						rFAExceptionCoverageVOs.get(i).setCvrgSteCd(rFAExceptionCoverageVOs.get(i).getCvrgRgnCd());
						rFAExceptionCoverageVOs.get(i).setCvrgRgnCd("");
					}
					
					//Multi Origin or Destination
					if ("US".equals(rFAExceptionCoverageVOs.get(i).getOrgDestCntCd()) || "CA".equals(rFAExceptionCoverageVOs.get(i).getOrgDestCntCd())) {
						rFAExceptionCoverageVOs.get(i).setOrgDestSteCd(rFAExceptionCoverageVOs.get(i).getOrgDestRgnCd());
						rFAExceptionCoverageVOs.get(i).setOrgDestRgnCd("");
					}
					
					//Create
					if (rFAExceptionCoverageVOs.get(i).getIbflag().equals("I")) {
						rFAExceptionCoverageVOs.get(i).setCreUsrId(account.getUsr_id());
						rFAExceptionCoverageVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//if create Before Exception Request Tariff ,then create Dar No.and Detail Seq.
						if (rFAExceptionCoverageVOs.get(i).getRfaExptDarNo().length() == 0) {
							rFAExceptionCoverageVOs.get(i).setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
						}
						if (rFAExceptionCoverageVOs.get(i).getRfaRqstDtlSeq().length() == 0) {
							rFAExceptionCoverageVOs.get(i).setRfaRqstDtlSeq(rFAProgressVO.getRfaRqstDtlSeq());
						}
						
						insRFAExceptionCoverageVOs.add(rFAExceptionCoverageVOs.get(i));
					}
					//Modify
					else if (rFAExceptionCoverageVOs.get(i).getIbflag().equals("U")) {
						rFAExceptionCoverageVOs.get(i).setUpdUsrId(account.getUsr_id());
						rFAExceptionCoverageVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updRFAExceptionCoverageVOs.add(rFAExceptionCoverageVOs.get(i));
					}
					//Delete
					else if (rFAExceptionCoverageVOs.get(i).getIbflag().equals("D")) {
						delRFAExceptionCoverageVOs.add(rFAExceptionCoverageVOs.get(i));
					}					
				}
			}			
			//=========================================================================================================================
			
			// Detail Seq. Rate Adjustment of Before Booking Request=========================================================
			List<RFAExceptionRateAdjustVO> 	rFAExceptionRateAdjustVOs		= rFAExceptionGRPVO.getRFAExceptionRateAdjustVOS();
			List<RFAExceptionRateAdjustVO> 	insRFAExceptionRateAdjustVOs 	= new ArrayList<RFAExceptionRateAdjustVO>();
			List<RFAExceptionRateAdjustVO> 	updRFAExceptionRateAdjustVOs 	= new ArrayList<RFAExceptionRateAdjustVO>();
			List<RFAExceptionRateAdjustVO> 	delRFAExceptionRateAdjustVOs 	= new ArrayList<RFAExceptionRateAdjustVO>();
			
			if (rFAExceptionRateAdjustVOs != null) {
				for (int i = 0 ; i < rFAExceptionRateAdjustVOs.size(); i++) {
					//Create
					if (rFAExceptionRateAdjustVOs.get(i).getIbflag().equals("I")) {
						rFAExceptionRateAdjustVOs.get(i).setCreUsrId(account.getUsr_id());
						rFAExceptionRateAdjustVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//if create Before Exception Request Tariff , then create Dar No.and Detail Seq.
						if (rFAExceptionRateAdjustVOs.get(i).getRfaExptDarNo().length() == 0) {
							rFAExceptionRateAdjustVOs.get(i).setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
						}						
						if (rFAExceptionRateAdjustVOs.get(i).getRfaRqstDtlSeq().length() == 0) {
							rFAExceptionRateAdjustVOs.get(i).setRfaRqstDtlSeq(rFAProgressVO.getRfaRqstDtlSeq());
						}
						
						insRFAExceptionRateAdjustVOs.add(rFAExceptionRateAdjustVOs.get(i));
					}
					//Modify
					else if (rFAExceptionRateAdjustVOs.get(i).getIbflag().equals("U")) {
						rFAExceptionRateAdjustVOs.get(i).setUpdUsrId(account.getUsr_id());
						rFAExceptionRateAdjustVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updRFAExceptionRateAdjustVOs.add(rFAExceptionRateAdjustVOs.get(i));
					}
					//Delete
					else if (rFAExceptionRateAdjustVOs.get(i).getIbflag().equals("D")) {
						delRFAExceptionRateAdjustVOs.add(rFAExceptionRateAdjustVOs.get(i));
					}
				}
			}
			//=========================================================================================================================
			
			//Tiered Free Time of RFA Exception Tariff ============================================================
			List<RFAExceptionFreeTimeVO> 	rFAExceptionFreeTimeVOs 		= rFAExceptionGRPVO.getRFAExceptionFreeTimeVOS();
			List<RFAExceptionFreeTimeVO> 	insRFAExceptionFreeTimeVOs 	= new ArrayList<RFAExceptionFreeTimeVO>();
			List<RFAExceptionFreeTimeVO> 	updRFAExceptionFreeTimeVOs 	= new ArrayList<RFAExceptionFreeTimeVO>();
			List<RFAExceptionFreeTimeVO> 	delRFAExceptionFreeTimeVOs 	= new ArrayList<RFAExceptionFreeTimeVO>();
			
			if (rFAExceptionFreeTimeVOs != null) {
				for (int i = 0 ; i < rFAExceptionFreeTimeVOs.size(); i++) {
					//Create
					if (rFAExceptionFreeTimeVOs.get(i).getIbflag().equals("I")) {
						rFAExceptionFreeTimeVOs.get(i).setCreUsrId(account.getUsr_id());
						rFAExceptionFreeTimeVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						// Create Group Seq.
						if (StringUtils.isEmpty(rFAExceptionFreeTimeVOs.get(i).getRfaExptDarNo())) {
							rFAExceptionFreeTimeVOs.get(i).setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
						}
						if (StringUtils.isEmpty(rFAExceptionFreeTimeVOs.get(i).getRfaRqstDtlSeq())) {
							rFAExceptionFreeTimeVOs.get(i).setRfaRqstDtlSeq(rFAProgressVO.getRfaRqstDtlSeq());
						}
						if (StringUtils.isEmpty(rFAExceptionFreeTimeVOs.get(i).getRfaExptVerSeq())) {
							rFAExceptionFreeTimeVOs.get(i).setRfaExptVerSeq(rFAProgressVO.getRfaExptVerSeq());
						}
						if (StringUtils.isEmpty(rFAExceptionFreeTimeVOs.get(i).getRfaExptMapgSeq())) {
							rFAExceptionFreeTimeVOs.get(i).setRfaExptMapgSeq(rFAProgressVO.getRfaExptMapgSeq());
						}
						if (StringUtils.isEmpty(rFAExceptionFreeTimeVOs.get(i).getCvrgCmbSeq())) {
							rFAExceptionFreeTimeVOs.get(i).setCvrgCmbSeq(rFAProgressVO.getCvrgCmbSeq());
						}
						
						insRFAExceptionFreeTimeVOs.add(rFAExceptionFreeTimeVOs.get(i));
					}
					//Modify
					else if (rFAExceptionFreeTimeVOs.get(i).getIbflag().equals("U")) {
						rFAExceptionFreeTimeVOs.get(i).setUpdUsrId(account.getUsr_id());
						rFAExceptionFreeTimeVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updRFAExceptionFreeTimeVOs.add(rFAExceptionFreeTimeVOs.get(i));
					}
					//Delete
					else if (rFAExceptionFreeTimeVOs.get(i).getIbflag().equals("D")) {
						delRFAExceptionFreeTimeVOs.add(rFAExceptionFreeTimeVOs.get(i));
					}
				}
			}
			//=========================================================================================================================
			// Commodity ===================================================================
			List<RFAExceptionCommodityVO> 	rFaxceptionCommodityVOs 	= rFAExceptionGRPVO.getRFAExceptionCommodityVOS();
			List<RFAExceptionCommodityVO> 	insRFAExceptionCommodityVOs 	= new ArrayList<RFAExceptionCommodityVO>();
			
			if (rFaxceptionCommodityVOs != null) {
				for (int i = 0 ; i < rFaxceptionCommodityVOs.size(); i++) {
					log.debug("[ibflag]***********["+i+"]"+rFaxceptionCommodityVOs.get(i).getIbflag());
					//Create
					if (rFaxceptionCommodityVOs.get(i).getIbflag().equals("I")
							||rFaxceptionCommodityVOs.get(i).getIbflag().equals("U")
							||rFaxceptionCommodityVOs.get(i).getIbflag().equals("R")) {
						rFaxceptionCommodityVOs.get(i).setCreUsrId(account.getUsr_id());
						rFaxceptionCommodityVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//Create Group Seq.
						if (StringUtils.isEmpty(rFaxceptionCommodityVOs.get(i).getRfaExptDarNo())) {
							rFaxceptionCommodityVOs.get(i).setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
						}
						if (StringUtils.isEmpty(rFaxceptionCommodityVOs.get(i).getRfaRqstDtlSeq())) {
							rFaxceptionCommodityVOs.get(i).setRfaRqstDtlSeq(rFAProgressVO.getRfaRqstDtlSeq());
						}
						if (StringUtils.isEmpty(rFaxceptionCommodityVOs.get(i).getRfaExptVerSeq())) {
							rFaxceptionCommodityVOs.get(i).setRfaExptVerSeq(rFAProgressVO.getRfaExptVerSeq());
						}
						if (StringUtils.isEmpty(rFaxceptionCommodityVOs.get(i).getRfaExptMapgSeq())) {
							rFaxceptionCommodityVOs.get(i).setRfaExptMapgSeq(rFAProgressVO.getRfaExptMapgSeq());
						}
						if (StringUtils.isEmpty(rFaxceptionCommodityVOs.get(i).getCvrgCmbSeq())) {
							rFaxceptionCommodityVOs.get(i).setCvrgCmbSeq(rFAProgressVO.getCvrgCmbSeq());
						}
						
						insRFAExceptionCommodityVOs.add(rFaxceptionCommodityVOs.get(i));
					}
					//Modify
//								else if (sCExceptionCommodityVOs.get(i).getIbflag().equals("U") || sCExceptionCommodityVOs.get(i).getIbflag().equals("R")) {
//									sCExceptionCommodityVOs.get(i).setCreUsrId(account.getUsr_id());
//									sCExceptionCommodityVOs.get(i).setCreOfcCd(account.getOfc_cd());
//									
//									updSCExceptionCommodityVOs.add(sCExceptionCommodityVOs.get(i));
//								}
					//Delete
					//else if (sCExceptionCommodityVOs.get(i).getIbflag().equals("D")) {
					//	delSCExceptionCommodityVOs.add(sCExceptionCommodityVOs.get(i));
					//}					
				}
			}
			//=========================================================================================================================
			
			
			int delCoverageSize	= 0;
			int insCoverageSize = 0;
			
			//1.[preceding Delete Action]
			//1-1.Multi Origin(I) or Destination(O)
			if (delRFAExceptionCoverageVOs.size() > 0) {
				dbDao.removeBeforeExceptionCoverage(delRFAExceptionCoverageVOs);
				
				// add CVRG_CMB_SEQ to DMT_RFA_EXPT_TRF_DTL table
				//if it delete Coverage information, then delete same CVRG_CMB_SEQ information.
				//division Delete.
				delCoverageSize = delRFAExceptionCoverageVOs.size();
			}
			//1-2.Rate Adjustment
			if (delRFAExceptionRateAdjustVOs.size() > 0) {
				dbDao.removeBeforeExceptionRate(delRFAExceptionRateAdjustVOs);
			}
			
			//1-3.Tiered Free Time [2016.01.04] NYK Add
			if (delRFAExceptionFreeTimeVOs.size() > 0) {
				dbDao.removeRFAExceptionTieredFreeTimes(delRFAExceptionFreeTimeVOs);
			}
			//1-4.Delete all Commodity-GRP. [2016.01.04] NYK Add
			if (rFaxceptionCommodityVOs != null && rFaxceptionCommodityVOs.size() > 0) {
				log.debug("--------------------------2------------------");
				dbDao.removeRFAExceptionCommodityAll(rFAProgressVO);
			}

			//2.[Insert Action]
			//2-1.Multi Origin or Destination
			if (insRFAExceptionCoverageVOs.size() > 0) {
				
				insCoverageSize = insRFAExceptionCoverageVOs.size();
				
				//before create Coverage , check Coverage Seq.of parents table, if not exist, then create.
				//if new Coverage count over deleted count, then add Before Exception Request.
				//case in  Multi change to Single.
				if (insCoverageSize - delCoverageSize > 0) {
					for (int i = 0 ; i < insCoverageSize ; i++) {
						dbDao.addBeforeExceptionTariffByCVRG(insRFAExceptionCoverageVOs.get(i));
					}
				}
				
				dbDao.addBeforeExceptionCoverage(insRFAExceptionCoverageVOs);
			}
			//2-2.Rate Adjustment
			if (insRFAExceptionRateAdjustVOs.size() > 0) {
				dbDao.addBeforeExceptionRate(insRFAExceptionRateAdjustVOs);
			}			

			//2-3.Tiered Free Time [2016.01.04] NYK Add
			if (insRFAExceptionFreeTimeVOs.size() > 0) {
				dbDao.addRFAExceptionTieredFreeTimes(insRFAExceptionFreeTimeVOs);
			}
			//2-4.Commodity [2016.01.04] NYK Add
			if (insRFAExceptionCommodityVOs!=null && insRFAExceptionCommodityVOs.size() > 0) {
				log.debug("--------------------------4------------------");
				dbDao.addRFAExceptionCommodities(insRFAExceptionCommodityVOs);
			}
			
			//3.[Update Action]
			//3-1.Multi Origin or Destination
			if (updRFAExceptionCoverageVOs.size() > 0) {
				dbDao.modifyBeforeExceptionCoverage(updRFAExceptionCoverageVOs);
			}
			
			//3-2.Rate Adjustment
			if (updRFAExceptionRateAdjustVOs.size() > 0) {
				dbDao.modifyBeforeExceptionRate(updRFAExceptionRateAdjustVOs);
			}

			//3-3.Tiered Free Time [2016.01.04] NYK Add
			if (updRFAExceptionFreeTimeVOs.size() > 0) {
				dbDao.modifyRFAExceptionTieredFreeTimes(updRFAExceptionFreeTimeVOs);
			}
			
			//4.if Deleted Coverage information exist, then Delete Coverage Seq.of Before Booking Request information.
			if (delCoverageSize > 0) {
				dbDao.removeBeforeExceptionTariffByCVRG(beforeExceptionVersionVO);
			}
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		return rFAProgressVO;
	}
	
	
	/**
	 * Search  Approval No. of DAR No.and Ver No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */		
	public String searchPrevApprovalNo(RFAProgressVO rFAProgressVO) throws EventException {
		String approvalNo = null;
		try {
			//Search previous approval no.
			approvalNo = dbDao.searchPrevApprovalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return approvalNo;
	}
	
	
	/**
	 * Create new Approval No. <br>
	 * 
	 * @param String usrId
	 * @param String rhqOfcCd
	 * @param String bkgTpCd
	 * @return String
	 * @exception EventException
	 */		
	public String searchNewApprovalNo(String usrId, String rhqOfcCd, String bkgTpCd) throws EventException {
		String approvalNo = null;
		try {
			//new ApprovalNo
			approvalNo = dbDao.searchNewApprovalNo(usrId, rhqOfcCd, bkgTpCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return approvalNo;
	}
	
	
	/**
	 * Change status of Before Booking Exception Version to 'Approved'<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void approvalBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			//1.change status  to 'Approved'.
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			
			//2.request approval Comment.
			dbDao.addCommentHistory(rFAProgressVO);
			
			//3. if it approval the last version, add Cancelled log in previous approvaled version 's Comment History .
		
			dbDao.addCancelCommentHistory(rFAProgressVO);
			
			//4.if Created Version' Status change to Approved , 
			//  then another same DAR no  Approved version Status change to Canceled
			//  delete approval no
			dbDao.modifyBeforeExceptionOtherTariffStatus(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Change status of Before Booking Exception Version to 'Request'<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void requestBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			dbDao.addCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Change status of Before Booking Exception Version to 'Cancel'<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void cancelBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			dbDao.addCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Change status of Before Booking Exception Version to 'Counter Offer'.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void counterofferBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			dbDao.addCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 *  Change status of Before Booking Exception Version to 'Reject'.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void rejectBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			dbDao.addCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Search  Approval No. of DAR No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeAPROList(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchBeforeAPROList(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Search  Customer of Proposal No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchCustomerByProp(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchCustomerByProp(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 *  Search  RFA No. of Proposal No.  <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchRFAByProp(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchRFAByProp(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Search all Multi Origin or Destination of DAR No.and Version No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCoverageVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCoverageVO> searchMultiCoverageByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchMultiCoverageByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 *  Search Rate Adjustment of DAR No.and Version No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionRateAdjustVO>
	 * @exception EventException
	 */
	public List<RFAExceptionRateAdjustVO> searchRateAdjustmentByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchRateAdjustmentByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Search RFA No. and Customer of Proposal No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCustomerVO> searchRFANoCustomerByProposalNo(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchRFANoCustomerByProposalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Search Version of Approval No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchVERByApprovalNo(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchVERByApprovalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 *  Search Approval Office of DAR No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchApprovalOfcByDAR(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchApprovalOfcByDAR(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 *  Search After Booking of S/C, Before Booking. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @exception EventException
	 */
	public List<BeforeAfterStatusVO> searchBeforeAfterStatusList(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws EventException {
		List<BeforeAfterStatusVO> list = null;
		try {
			// only "DMT03"
			if ("AB".equals(beforeAfterStatusInputVO.getType()) 
					&& "DATE".equals(beforeAfterStatusInputVO.getCondTp()) 
					&& "RCV".equals(beforeAfterStatusInputVO.getTabTp())) {
				
				//check DMT03 authority
				if (dbDao.searchOwnedRole(beforeAfterStatusInputVO.getLoginUsrId(), beforeAfterStatusInputVO.getUsrRoleCd())) {
					//if it is DMT03
					beforeAfterStatusInputVO.setIsOwnedRole("Y");
					beforeAfterStatusInputVO.setUsrOfcCd(beforeAfterStatusInputVO.getLoginOfcCd());
				}
				else {
					//if it is not DMT03
					beforeAfterStatusInputVO.setIsOwnedRole("N");
				}
			}
			
			//if  Type is S/C 
			if ("SC".equals(beforeAfterStatusInputVO.getType())) {
				if ("DATE".equals(beforeAfterStatusInputVO.getCondTp())) {
					if ("RCV".equals(beforeAfterStatusInputVO.getTabTp())) {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchSCTariffListByDateUserIDRCV(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchSCTariffListByDateUserOfficeRCV(beforeAfterStatusInputVO);
						}
					}
					else {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchSCTariffListByDateUserIDSND(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchSCTariffListByDateUserOfficeSND(beforeAfterStatusInputVO);
						}
					}
				}
				else {
					list = dbDao.searchSCTariffListByDAR(beforeAfterStatusInputVO);
				}
			}
			//if  Type is  Before Booking
			else if ("BB".equals(beforeAfterStatusInputVO.getType())) {
				if ("DATE".equals(beforeAfterStatusInputVO.getCondTp())) {
					if ("RCV".equals(beforeAfterStatusInputVO.getTabTp())) {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchBeforeBookingListByDateUserIDRCV(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchBeforeBookingListByDateUserOfficeRCV(beforeAfterStatusInputVO);
						}
					}
					else {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchBeforeBookingListByDateUserIDSND(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchBeforeBookingListByDateUserOfficeSND(beforeAfterStatusInputVO);							
						}
					}					
				}
				else {
					list = dbDao.searchBeforeBookingListByDAR(beforeAfterStatusInputVO);	
				}
			}
			//if  Type is After Booking 
			else if ("AB".equals(beforeAfterStatusInputVO.getType())) {
				if ("DATE".equals(beforeAfterStatusInputVO.getCondTp())) {
					if ("RCV".equals(beforeAfterStatusInputVO.getTabTp())) {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchAfterBookingListByDateUserIDRCV(beforeAfterStatusInputVO);	
						}
						else {
							list = dbDao.searchAfterBookingListByDateUserOfficeRCV(beforeAfterStatusInputVO);							
						}	
					}
					else {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchAfterBookingListByDateUserIDSND(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchAfterBookingListByDateUserOfficeSND(beforeAfterStatusInputVO);							
						}
					}					
				}
				else {
					list = dbDao.searchAfterBookingListByDAR(beforeAfterStatusInputVO);	
				}
			}			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 *  check Customer of Before Booking . <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isBeforeBKGCustomer(String custCntCd, String custSeq) throws EventException {
		try {
			return dbDao.isBeforeBKGCustomer(custCntCd, custSeq);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Search Before Booking of  Proposal No. <br>
	 * 
	 * @param BeforeExceptionListInputVO inputVO
	 * @return List<BeforeExceptionListVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionListVO> searchBeforeExceptionListByPropNo(BeforeExceptionListInputVO inputVO) throws EventException {
		try {
			return dbDao.searchBeforeExceptionListByPropNo(inputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Search Before Booking of Customer Code and RFA No.  <br>
	 * 
	 * @param BeforeExceptionListInputVO inputVO
	 * @return List<BeforeExceptionListVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionListVO> searchBeforeExceptionListByCustomer(BeforeExceptionListInputVO inputVO) throws EventException {
		try {
			return dbDao.searchBeforeExceptionListByCustomer(inputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Search approval authority.  <br>
	 * 
	 * @param ApprovalRequestUserVO approvalRequestUserVO
	 * @param String condType
	 * @return List<ApprovalRequestUserListVO>
	 * @exception EventException
	 */
	public List<ApprovalRequestUserListVO> searchApprovalAuthorityList(ApprovalRequestUserVO approvalRequestUserVO, String condType) throws EventException {
		try {
			return dbDao.searchApprovalAuthorityList(approvalRequestUserVO, condType);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * when Update button click, if status of Before Booking Request information is 'Approved', 'Rejected' , then Create new version.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */
	public void addBeforeExceptionByUpdate(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			//1.신규 버전 information를 Search한다.
			String 						versionSeq 					= dbDao.searchBeforeExceptionVersionSeq(rFAProgressVO);

			//2.Version, Version Prog information를 Create하기 위한 Version 객체를 Create 합니다.
			BeforeExceptionVersionVO	beforeExceptionVersionVO	= new BeforeExceptionVersionVO();
			
			beforeExceptionVersionVO.setRfaExptDarNo(		rFAProgressVO.getRfaExptDarNo()			);
			beforeExceptionVersionVO.setRfaExptMapgSeq(		rFAProgressVO.getRfaExptMapgSeq()		);
			beforeExceptionVersionVO.setRfaExptVerSeq(		versionSeq								);
			beforeExceptionVersionVO.setCreUsrId(			rFAProgressVO.getCreUsrId()				);
			beforeExceptionVersionVO.setCreOfcCd(			rFAProgressVO.getCreOfcCd()				);
			beforeExceptionVersionVO.setDmdtExptRqstStsCd(	rFAProgressVO.getDmdtExptRqstStsCd()	);
			beforeExceptionVersionVO.setPropNo(				rFAProgressVO.getPropNo()				);
			beforeExceptionVersionVO.setCustCntCd(			rFAProgressVO.getCustCntCd()			);
			beforeExceptionVersionVO.setCustSeq(			rFAProgressVO.getCustSeq()				);
			beforeExceptionVersionVO.setRqstUsrId(			rFAProgressVO.getRqstUsrId()			);
			beforeExceptionVersionVO.setRqstOfcCd(			rFAProgressVO.getRqstOfcCd()			);
			beforeExceptionVersionVO.setAproOfcCd(			rFAProgressVO.getAproOfcCd()			);

			//2-1.Before Booking Request 에 신규 채번된 Version Seq. 를 설정 합니다.
			rFAProgressVO.setRfaExptVerSeq(					versionSeq								);
			
			//3.신규 버전에 대한 information를 'Temp' 상태로 Version 에 Create 합니다.
			dbDao.addBeforeExceptionVersion(beforeExceptionVersionVO);
			
			//4.신규 버전에 대한 information를 'Temp' 상태로 Version Prog 에 Create 합니다.
			dbDao.addBeforeExceptionVersionProg(beforeExceptionVersionVO);
			
			//5.이전 버전의 모든 Before Booking Request 의 Detail information를 신규 버전으로 Create 합니다.
			dbDao.addBeforeExceptionDetailOfPrevVersion(rFAProgressVO);
			
			//6.이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는  Multi Origin or Dest. information를 신규 버전으로 Create 합니다.
			dbDao.addBeforeExceptionCoverageOfPrevVersion(rFAProgressVO);
			
			//7.이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Rate Adjustment information를 신규 버전으로 Create 합니다.
			dbDao.addBeforeExceptionRateAdjustmentOfPrevVersion(rFAProgressVO);
			
			//[2016.01.04] NYK Add
			//8.이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Tiered Free Time를 신규 버전으로 Create 합니다. 
			dbDao.addBeforeExceptionTieredFreeTimeOfPrevVersion(rFAProgressVO);
			
			//[2016.01.04] NYK Add
			//9.이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Commodity를 신규 버전으로 Create 합니다. 
			dbDao.addBeforeExceptionCommodityOfPrevVersion(rFAProgressVO);
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}		
	
	
	/**
	 * Delete information of current version ,create information of selected version in the DAR History of current version.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addBeforeExceptionByHistoryCopy(RFAProgressVO rFAProgressVO, SignOnUserAccount account) throws EventException {
		try {
			//1.Create VersionVO
			BeforeExceptionVersionVO	beforeExceptionVersionVO	= new BeforeExceptionVersionVO();
			BeforeExceptionDeleteVO		beforeExceptionDeleteVO		= null;
			
			//Create new DAR No.
			if (rFAProgressVO.getRfaExptDarNo().length() == 0) {
				rFAProgressVO.setRfaExptDarNo(dbDao.searchNewDAR(account, "B"));
			}
			
			beforeExceptionVersionVO.setRfaExptDarNo(		rFAProgressVO.getRfaExptDarNo()			);
			beforeExceptionVersionVO.setRfaExptMapgSeq(		rFAProgressVO.getRfaExptMapgSeq()		);
			beforeExceptionVersionVO.setRfaExptVerSeq(		rFAProgressVO.getRfaExptVerSeq()		);
			beforeExceptionVersionVO.setCreUsrId(			rFAProgressVO.getCreUsrId()				);
			beforeExceptionVersionVO.setCreOfcCd(			rFAProgressVO.getCreOfcCd()				);
			beforeExceptionVersionVO.setUpdUsrId(			rFAProgressVO.getUpdUsrId()				);
			beforeExceptionVersionVO.setUpdOfcCd(			rFAProgressVO.getUpdOfcCd()				);
			beforeExceptionVersionVO.setDmdtExptRqstStsCd(	rFAProgressVO.getDmdtExptRqstStsCd()	);
			beforeExceptionVersionVO.setPropNo(				rFAProgressVO.getPropNo()				);
			beforeExceptionVersionVO.setAproOfcCd(			rFAProgressVO.getAproOfcCd()			);
			beforeExceptionVersionVO.setCustCntCd(			rFAProgressVO.getCustCntCd()			);
			beforeExceptionVersionVO.setCustSeq(			rFAProgressVO.getCustSeq()				);
			beforeExceptionVersionVO.setRqstUsrId(			rFAProgressVO.getUpdUsrId()				);
			beforeExceptionVersionVO.setRqstOfcCd(			rFAProgressVO.getUpdOfcCd()				);
			
			//  Delete Before Booking Request information of current version.
			if (dbDao.existBeforeException(rFAProgressVO)) {
				beforeExceptionDeleteVO = new BeforeExceptionDeleteVO();
				beforeExceptionDeleteVO.setDelRfaExptDarNo(		rFAProgressVO.getRfaExptDarNo()		);
				beforeExceptionDeleteVO.setDelRfaExptMapgSeq(	rFAProgressVO.getRfaExptMapgSeq()	);
				beforeExceptionDeleteVO.setDelRfaExptVerSeq(	rFAProgressVO.getRfaExptVerSeq()	);
								
				dbDao.removeBeforeExceptionByVerNo(beforeExceptionDeleteVO);
			}
			
			//2.cahnge to 'Temp.Saved' 
			//  Search  Version information of Before Booking Request.
			if (!dbDao.existBeforeExceptionVersion(beforeExceptionVersionVO)) {
				//not exist
				dbDao.addBeforeExceptionVersion(beforeExceptionVersionVO);
			}
			else {
				//exist, update to 'Temp.Saved' 
				dbDao.modifyVersionSTS(beforeExceptionVersionVO);
			}
			
			//3.Create information ( status = 'Temp.Saved' )in Version Prog 
			if (dbDao.isTempSavedStatusOfLastVersionProg(beforeExceptionVersionVO)) {
				dbDao.modifyLastVersionProg(beforeExceptionVersionVO);
			}
			else {
				dbDao.addBeforeExceptionVersionProg(beforeExceptionVersionVO);
			}			
			
			//4.Create Detail information of previous version.
			dbDao.addBeforeExceptionDetailOfHistVersion(rFAProgressVO);
			
			//5.Create  Multi Origin or Dest. information of previous version.
			dbDao.addBeforeExceptionCoverageOfHistVersion(rFAProgressVO);
			
			//6.Create   Rate Adjustment information of previous version.
			dbDao.addBeforeExceptionRateAdjustmentOfHistVersion(rFAProgressVO);
			
			//[2016.01.04] NYK Add
			//7.Create   Tiered Free Time of previous version.
			dbDao.addBeforeExceptionTieredFreeTimeOfHistVersion(rFAProgressVO);
			
			//[2016.01.04] NYK Add
			//8.Create   Commodity of previous version.
			dbDao.addBeforeExceptionCommodityOfHistVersion(rFAProgressVO);
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Delete Detail of selected Before Exception Request and belongings.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */
	public void removeBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			//[2016.01.04] NYK Add
			dbDao.removeBeforeExceptionTieredFreeTimeByDetailSeq(	rFAProgressVO	);
			dbDao.removeBeforeExceptionCommodityByDetailSeq		(	rFAProgressVO	);
			
			dbDao.removeBeforeExceptionRateAdjustment			(	rFAProgressVO	);
			dbDao.removeBeforeExceptionCoverage					(	rFAProgressVO	);
			dbDao.removeBeforeExceptionDetail					(	rFAProgressVO	);
			
			//Search  Detail information of Before Booking Request version.
			if (!dbDao.existBeforeException(rFAProgressVO)) {
				//if not exists then,  Delete Version Prog information.
				dbDao.removeBeforeExceptionVersionProg(rFAProgressVO);
				//if not exists then,  Delete Version information information.
				dbDao.removeBeforeExceptionVersion(rFAProgressVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Check duplication in inputed RFA information and created RFA information.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isDuplicateRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.isDuplicateRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Search last Update Date when Approval, Counter Offer, Reject.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUpdateDate(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchUpdateDate(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  Search APVL OFC, DAR No., Version and Status of Before Booking APVL No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchRFATariffByAPVLNo(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchRFATariffByAPVLNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search Approval No. of Proposal No.or DAR No. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return RFAProgressVO
	 * @throws EventException
	 */
	public RFAProgressVO searchAproNoByPropApprovalNo(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchAproNoByPropApprovalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 *  Before Booking Exception-Tiered Free Time 조회 합니다. <br>
	 *  [2016.01.04] NYK Add.
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionFreeTimeVO>
	 * @exception EventException
	 */
	public List<RFAExceptionFreeTimeVO> searchTieredFreeTimeByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchTieredFreeTimeByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 *  Before Booking Exception-Commodity 조회 합니다. <br>
	 *  [2016.01.04] NYK Add.
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCommodityVO> searchCommodityListByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchCommodityListByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 *  Before Booking Exception-Default Commodity 조회 합니다. <br>
	 *  [2016.01.04] NYK Add.
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCommodityVO> searchCommodityDefaultListByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchCommodityDefaultListByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
}
