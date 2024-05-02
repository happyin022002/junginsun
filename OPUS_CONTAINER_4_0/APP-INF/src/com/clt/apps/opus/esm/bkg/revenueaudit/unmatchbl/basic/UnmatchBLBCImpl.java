/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLBCImpl.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLDBDAO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLEAIDAO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.CreateSurchargeInputVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchDiffAmountVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.ScNoteConversionVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgRevUmchBkgVO;

/**
 * OPUS-RevenueAudit Business Logic Basic Command implementation<br>
 * - OPUS-RevenueAudit handling business transaction.<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public class UnmatchBLBCImpl extends BasicCommandSupport implements UnmatchBLBC {

	// Database Access Object
	private transient UnmatchBLDBDAO dbDao = null;
	private transient UnmatchBLEAIDAO eaiDao = null;

	/**
	 * Generating UnmatchBLBCImpl Object<br>
	 * Generating UnmatchBLDBDAO<br>
	 */
	public UnmatchBLBCImpl() {
		dbDao = new UnmatchBLDBDAO();
		eaiDao = new UnmatchBLEAIDAO();
	}
	
	
	/**
	 * RETRIEVING BKG COUNT SEARCH IN UNMATCH BL INQUERY <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFilterdBkgCount(SignOnUserAccount account, RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) throws EventException {
		SearchFilteredBkgCountBackEndJob searchFilteredBkgCountBackEndJob = new SearchFilteredBkgCountBackEndJob();
		searchFilteredBkgCountBackEndJob.setRsltUnmatchBLListbyAuditorVO(rsltUnmatchBLListbyAuditorVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchFilteredBkgCountBackEndJob, account.getUsr_id(), "searchFilterdBkgCount");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	/**
	 *  unmatch bl list by auditor.<br>
	 * 
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 * @return List<RsltUnmatchBLListbyAuditorVO>
	 * @exception EventException
	 */
	public List<RsltUnmatchBLListbyAuditorVO> searchUnmatchBLListbyAuditor(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) throws EventException {
		try {
			return dbDao.searchUnmatchBLListbyAuditor(rsltUnmatchBLListbyAuditorVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	
	/**
	 *  unmatch bl list by auditor.<br>
	 * 
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 * @return List<RsltUnmatchBLListbyAuditorVO>
	 * @exception EventException
	 */
	public List<RsltUnmatchBLListbyAuditorVO> searchUnmatchBLListbyRegionalOffice(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) throws EventException {
		try {
			return dbDao.searchUnmatchBLListbyAuditor(rsltUnmatchBLListbyAuditorVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	
	/**
	 *  retrieving event of unmatched result<br>
	 * 
	 * @param RsltUnmatchDiffAmountVO rsltUnmatchDiffAmountVO
	 * @return List<RsltUnmatchDiffAmountVO>
	 * @exception EventException
	 */
	public List<RsltUnmatchDiffAmountVO> searchUnmatchItemDetailList(RsltUnmatchDiffAmountVO rsltUnmatchDiffAmountVO) throws EventException {
		try {
			return dbDao.searchUnmatchItemDetailList(rsltUnmatchDiffAmountVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	
	/**
	 *  unmatch status report list search.<br>
	 * 
	 * @param RsltUnmatchStatusReportVO resltUnmatchStatusReportVO
	 * @return List<RsltUnmatchStatusReportVO>
	 * @exception EventException
	 */
	public List<RsltUnmatchStatusReportVO> searchUnmatchBLStatusList(RsltUnmatchStatusReportVO resltUnmatchStatusReportVO) throws EventException {
		try {
			return dbDao.searchUnmatchBLStatusList(resltUnmatchStatusReportVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	
	/**
	 * UNMACH LIST SETTLE<br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException{
		try {
			//List<BkgRevUmchBkgVO> insertVoList = new ArrayList<BkgRevUmchBkgVO>();
//			List<BkgRevUmchBkgVO> updateVoList = new ArrayList<BkgRevUmchBkgVO>();
			//List<BkgRevUmchBkgVO> deleteVoList = new ArrayList<BkgRevUmchBkgVO>();
			for ( int i=0; i < bkgRevUmchBkgVO.length; i++ ) {
//				if ( bkgRevUmchBkgVO[i].getIbflag().equals("I")){
//					bkgRevUmchBkgVO[i].setCreUsrId(account.getUsr_id());
//					insertVoList.add(bkgRevUmchBkgVO[i]);
//				} 
				
				//if ( bkgRevUmchBkgVO[i].getIbflag().equals("U")){ 
					
					//settle
					bkgRevUmchBkgVO[i].setRevAudStsCd("S");
					//manual settle
					bkgRevUmchBkgVO[i].setRevAudStlKndCd("M");
					
					bkgRevUmchBkgVO[i].setStlUsrId(account.getUsr_id());
					bkgRevUmchBkgVO[i].setUpdUsrId(account.getUsr_id());
					
					dbDao.modifySettleUnmatchBL(bkgRevUmchBkgVO[i]);
					
					//updateVoList.add(bkgRevUmchBkgVO[i]);
				//} 
//				if ( bkgRevUmchBkgVO[i].getIbflag().equals("D")){
//					deleteVoList.add(bkgRevUmchBkgVO[i]);
//				}
			}
			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addUnmatchBLS(insertVoList);
//			}
			
//			if ( updateVoList.size() > 0 ) {
//				dbDao.settleUnmatchBL(updateVoList);
//			}
			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeUnmatchBLS(deleteVoList);
//			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * UNMACH LIST SETTLE<br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleOfficeUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException{
		try {
			for ( int i=0; i < bkgRevUmchBkgVO.length; i++ ) {
					
					//settle
					bkgRevUmchBkgVO[i].setRevAudStsCd("S");
					//manual settle Office
					bkgRevUmchBkgVO[i].setRevAudStlKndCd("O");
					
					bkgRevUmchBkgVO[i].setStlUsrId(account.getUsr_id());
					bkgRevUmchBkgVO[i].setUpdUsrId(account.getUsr_id());
					
					dbDao.modifySettleUnmatchBL(bkgRevUmchBkgVO[i]);
					
				
			}
			

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	/**
	 * UNMACH LIST RMK <br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException{
		try {
			//List<BkgRevUmchBkgVO> insertVoList = new ArrayList<BkgRevUmchBkgVO>();
//			List<BkgRevUmchBkgVO> updateVoList = new ArrayList<BkgRevUmchBkgVO>();
			//List<BkgRevUmchBkgVO> deleteVoList = new ArrayList<BkgRevUmchBkgVO>();
			//log.debug("qwer" +bkgRevUmchBkgVO.length);	
			for ( int i=0; i<bkgRevUmchBkgVO .length; i++ ) {
//				if ( bkgRevUmchBkgVO[i].getIbflag().equals("I")){
//					bkgRevUmchBkgVO[i].setCreUsrId(account.getUsr_id());
//					insertVoList.add(bkgRevUmchBkgVO[i]);
//				} 
				if ( bkgRevUmchBkgVO[i].getIbflag().equals("U")){
					
					bkgRevUmchBkgVO[i].setStlUsrId(account.getUsr_id());
					bkgRevUmchBkgVO[i].setUpdUsrId(account.getUsr_id());
					
					dbDao.modifyUnmatchBLRmk(bkgRevUmchBkgVO[i]);
					
					//updateVoList.add(bkgRevUmchBkgVO[i]);
				} 
//				if ( bkgRevUmchBkgVO[i].getIbflag().equals("D")){
//					deleteVoList.add(bkgRevUmchBkgVO[i]);
//				}
			}
			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addUnmatchBLS(insertVoList);
//			}
			
//			if ( updateVoList.size() > 0 ) {
//				dbDao.settleUnmatchBL(updateVoList);
//			}
			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeUnmatchBLS(deleteVoList);
//			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	
	/**
	 * Unmatch B/L Inquiry by Office RMK<br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUnmatchBLRegionalOffice(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException{
		try {
			//List<BkgRevUmchBkgVO> insertVoList = new ArrayList<BkgRevUmchBkgVO>();
//			List<BkgRevUmchBkgVO> updateVoList = new ArrayList<BkgRevUmchBkgVO>();
			//List<BkgRevUmchBkgVO> deleteVoList = new ArrayList<BkgRevUmchBkgVO>();
			for ( int i=0; i<bkgRevUmchBkgVO .length; i++ ) {
//				if ( bkgRevUmchBkgVO[i].getIbflag().equals("I")){
//					bkgRevUmchBkgVO[i].setCreUsrId(account.getUsr_id());
//					insertVoList.add(bkgRevUmchBkgVO[i]);
//				} 
				if ( bkgRevUmchBkgVO[i].getIbflag().equals("U")){
					
					bkgRevUmchBkgVO[i].setStlUsrId(account.getUsr_id());
					bkgRevUmchBkgVO[i].setUpdUsrId(account.getUsr_id());
					
					dbDao.modifyUnmatchBLRmk(bkgRevUmchBkgVO[i]);
					
					//updateVoList.add(bkgRevUmchBkgVO[i]);
				} 
//				if ( bkgRevUmchBkgVO[i].getIbflag().equals("D")){
//					deleteVoList.add(bkgRevUmchBkgVO[i]);
//				}
			}
			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addUnmatchBLS(insertVoList);
//			}
			
//			if ( updateVoList.size() > 0 ) {
//				dbDao.settleUnmatchBL(updateVoList);
//			}
			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeUnmatchBLS(deleteVoList);
//			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * Retrieving event of Unmatch Details List <br>
	 * 
	 * @param RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO
	 * @return List<RsltSearchUnmatchItemListVO>
	 * @exception EventException
	 */
	public List<RsltSearchUnmatchItemListVO> searchUnmatchItemList(RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO) throws EventException {
		try {
			return dbDao.searchUnmatchItemList(rsltSearchUnmatchItemListVO);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}		
	
	/**
	 * retrieving event of Unmatch Description List<br>
	 * 
	 * @param RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO
	 * @return List<RsltSearchUnmatchTypeListVO>
	 * @exception EventException
	 */
	public List<RsltSearchUnmatchTypeListVO> searchUnmatchTypeList(RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO) throws EventException {
		try {
			return dbDao.searchUnmatchTypeList(rsltSearchUnmatchTypeListVO);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}		

	/**
	 * for Charge Filtering handling requested job by BackEndJob<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchChargeFilteringList(SignOnUserAccount account, RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO) throws EventException {
		SearchChargeFilteringListBackEndJob searchChargeFilteringListBackEndJob = new SearchChargeFilteringListBackEndJob();
		searchChargeFilteringListBackEndJob.setRsltSearchChargeFilteringListVO(rsltSearchChargeFilteringListVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchChargeFilteringListBackEndJob, account.getUsr_id(), "ESM_BKG_0151 - Search");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * for Audit by Commodity And Route handling requested job by BackEndJob<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAuditByCommodityAndRouteList(SignOnUserAccount account, RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO) throws EventException {
		SearchAuditByCommodityAndRouteListBackEndJob searchAuditByCommodityAndRouteListBackEndJob = new SearchAuditByCommodityAndRouteListBackEndJob();
		searchAuditByCommodityAndRouteListBackEndJob.setRsltSearchAuditByCommodityAndRouteListVO(rsltSearchAuditByCommodityAndRouteListVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchAuditByCommodityAndRouteListBackEndJob, account.getUsr_id(), "ESM_BKG_1092 - Search");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * retrieving event of BackEndJob state.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVO(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), e);
		} catch (SQLException e) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), e);
		} catch (InterruptedException e) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), e);
		} catch(Exception ex){
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving event of Audit by CNTR Qty Discrepancy List<br>
	 * 
	 * @param RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO
	 * @return List<RsltSearchAuditByCNTRQtyDiscrepancyListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchAuditByCNTRQtyDiscrepancyListVO> searchAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO) throws EventException {
		try {
			return dbDao.searchAuditByCNTRQtyDiscrepancyList(rsltSearchAuditByCNTRQtyDiscrepancyListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}	
	/**
	 *  Handling manage event of Audit by CNTR Qty Discrepancy List<br>
	 * 
	 * @param RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	
	public void manageAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs, SignOnUserAccount account) throws EventException{
		try {
			String rtn= "";
			
			for ( int i=0; i<rsltSearchAuditByCNTRQtyDiscrepancyListVOs.length; i++ ) {
				
				rsltSearchAuditByCNTRQtyDiscrepancyListVOs[i].setUpdUsrId(account.getUsr_id());
				rtn = dbDao.searchByBkgRevAudRslt(rsltSearchAuditByCNTRQtyDiscrepancyListVOs[i]);
				
				if(!"0".equals(rtn) && rtn.length() > 0){
					rsltSearchAuditByCNTRQtyDiscrepancyListVOs[i].setCreUsrId(account.getUsr_id());
					rsltSearchAuditByCNTRQtyDiscrepancyListVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyAuditByCNTRQtyDiscrepancyList(rsltSearchAuditByCNTRQtyDiscrepancyListVOs[i]);
					
				}else{
					rsltSearchAuditByCNTRQtyDiscrepancyListVOs[i].setCreUsrId(account.getUsr_id());
					rsltSearchAuditByCNTRQtyDiscrepancyListVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.createAuditByCNTRQtyDiscrepancyList(rsltSearchAuditByCNTRQtyDiscrepancyListVOs[i]);
				
				}

			}
			

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), de);
		}
	}
	/**
	 *  Handling retrieving event of Audit by Hanger Installation List<br>
	 * 
	 * @param RsltSearchAuditByHangerInstallationListVO pVO
	 * @return List<RsltSearchAuditByHangerInstallationListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchAuditByHangerInstallationListVO> searchAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO pVO) throws EventException {
		try {
			return dbDao.searchAuditByHangerInstallationList(pVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}	
	
	/**
	 * Handling Audit by Hanger Installation RMK <br>
	 * @param RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */	
	
	public void manageAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs, SignOnUserAccount account) throws EventException{
		try {
			String rtn= "";
			
			for ( int i=0; i<rsltSearchAuditByHangerInstallationListVOs.length; i++ ) {
				
				rsltSearchAuditByHangerInstallationListVOs[i].setUpdUsrId(account.getUsr_id());
				rtn = dbDao.searchByBkgRevAudRsltByHanger(rsltSearchAuditByHangerInstallationListVOs[i]);
				
				if(!"0".equals(rtn) && rtn.length() > 0){
					rsltSearchAuditByHangerInstallationListVOs[i].setCreUsrId(account.getUsr_id());
					rsltSearchAuditByHangerInstallationListVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyAuditByHangerInstallationList(rsltSearchAuditByHangerInstallationListVOs[i]);
					
				}else{
					rsltSearchAuditByHangerInstallationListVOs[i].setCreUsrId(account.getUsr_id());
					rsltSearchAuditByHangerInstallationListVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.createAuditByHangerInstallationList(rsltSearchAuditByHangerInstallationListVOs[i]);
				
				}

			}
			

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), de);
		}
	}

	/**
	 *  Handling retrieving event of B/L No to BkgNo and caFlg, ctrtTpCD<br>
	 * 
	 * @param String blNo
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> searchBkgCaFlg(String blNo) throws EventException {
		try {
			return dbDao.searchBkgCaFlg(blNo);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}	
	
	/**
	  *  Handling retrieving event of B/L No to BkgNo and caFlg, ctrtTpCD<br>
	 * 
	 * @param String blNo
	 * @param String caFlg
	 * @return UnmatchBLVO
	 * @exception EventException
	 */
	public UnmatchBLVO searchBkgCaFlg(String blNo, String caFlg) throws EventException {
		try {
			return dbDao.searchBkgCaFlg(blNo, caFlg);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}	
	
	/**
	 *  Handling retrieving event of Booking No to aFlg, ctrtTpCD<br>
	 * 
	 * @param String bkgNo
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> searchBkgStatus(String bkgNo) throws EventException {
		try {
			return dbDao.searchBkgStatus(bkgNo);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}		

	/**
	 * retrieving of Self Audit - RFA A ~ F <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;	
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		int cnt = 0;
		try {
			listA1 =	dbDao.selectCheckRfaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
			listA2 =	dbDao.selectCheckApplicationDateDiscrepancy(bkgNo, caFlg); // A2
			listB  =	dbDao.selectCheckRfaCustomerDiscrepancy(bkgNo, caFlg);     // B    
			listC  = 	dbDao.selectCheckRfaCommodityDiscrepancy(bkgNo, caFlg);    // C
			listD  =	dbDao.selectCheckRfaNonchargedBl(bkgNo, caFlg);            // D 
			listE  =	dbDao.selectCheckRfaOftDiscrepancy(bkgNo, caFlg);               // E
			listF  =	dbDao.selectCheckRfaSurchargeDiscrepancy(bkgNo, caFlg);         // F

			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0){
				cnt++;
			}
			if(listF.size() > 0){
				cnt++;
			}
			if(cnt > 0 && listA2.size() > 0 ){
				listA1.addAll(listA2);
			}
			listA1.addAll(listB);
			listA1.addAll(listC);
			listA1.addAll(listD);
			
			if(listE.size() > 0){
				listA1.addAll(listE);          
				if(listE.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckRfaOftDiscrepancyDetail(bkgNo, caFlg)); // E Detail  
				}
			}
			listF = dbDao.selectCheckRfaSurchargeDiscrepancy(bkgNo, caFlg);         // F
			if(listF.size() > 0){
				listA1.addAll(listF);          
				if(listF.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckRfaSurchargeDiscrepancyDetail(bkgNo, caFlg)); // F Detail
				}
			}
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}		
	
	/**
	 * retrieving of Self Audit - RFA A ~ F <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaUnmatchSCRA(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;	
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		int cnt = 0;
		try {
			listA1 =	dbDao.selectCheckRfaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
			listA2 =	dbDao.selectCheckApplicationDateDiscrepancy(bkgNo, caFlg); // A2
			listB  =	dbDao.selectCheckRfaCustomerDiscrepancy(bkgNo, caFlg);     // B    
			listC  = 	dbDao.selectCheckRfaCommodityDiscrepancy(bkgNo, caFlg);    // C
			listD  =	dbDao.selectCheckRfaNonchargedBl(bkgNo, caFlg);            // D 
			listE  =	dbDao.selectCheckRfaSelfOftDiscrepancy(bkgNo, caFlg);               // E
			listF  =	dbDao.selectCheckRfaSelfSurchargeDiscrepancy(bkgNo, caFlg);         // F

			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0){
				cnt++;
			}
			if(listF.size() > 0){
				cnt++;
			}
			if(cnt > 0 && listA2.size() > 0 ){
				listA1.addAll(listA2);
			}
			listA1.addAll(listB);
			listA1.addAll(listC);
			listA1.addAll(listD);
			
			if(listE.size() > 0){
				listA1.addAll(listE);          
				if(listE.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckRfaOftDiscrepancyDetail(bkgNo, caFlg)); // E Detail  
				}
			}
			if(listF.size() > 0){
				listA1.addAll(listF);          
				if(listF.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckRfaSurchargeDiscrepancyDetail(bkgNo, caFlg)); // F Detail
				}
			}
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}	

	/**
	 * retrieving Self Audit - SC A ~ D<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list =      dbDao.selectCheckScEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
			list.addAll(dbDao.selectCheckScApplicationDateDiscrepancy(bkgNo, caFlg));     // A2
			list.addAll(dbDao.selectCheckScCustomerDiscrepancy(bkgNo, caFlg));     // B   
			list.addAll(dbDao.selectCheckScCommodityDiscrepancy(bkgNo, caFlg));    // C
			list.addAll(dbDao.selectCheckScNonchargedBl(bkgNo, caFlg));            // D
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		
	
	/**
	 * retrieving Audit - TAA A ~ F<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkTaaUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		int cnt = 0;
		try {
			listA1 =	dbDao.selectCheckTaaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
			listA2 =	dbDao.selectCheckTaaApplicationDateDiscrepancy(bkgNo, caFlg);// A2 
			listB  = 	dbDao.selectCheckTaaCustomerDiscrepancy(bkgNo, caFlg);     // B   
			listC  = 	dbDao.selectCheckTaaCommodityDiscrepancy(bkgNo, caFlg);    // C
			listD  =	dbDao.selectCheckTaaNonchargedBl(bkgNo, caFlg);            // D
			listE  =	dbDao.selectCheckTaaOftDiscrepancy(bkgNo, caFlg);               // E
			listF  =	dbDao.selectCheckTaaSurchargeDiscrepancy(bkgNo, caFlg);         // F
						
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0){
				cnt++;
			}
			if(listF.size() > 0){
				cnt++;
			}
			if(cnt > 0 && listA2.size() > 0 ){
				listA1.addAll(listA2);
			}
			listA1.addAll(listB);
			listA1.addAll(listC);
			listA1.addAll(listD);
			
			if(listE.size() > 0){
				listA1.addAll(listE);          
				if(listE.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckTaaOftDiscrepancyDetail(bkgNo, caFlg)); // E Detail
				}
			}
			if(listF.size() > 0){
				listA1.addAll(listF);          
				if(listF.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckTaaSurchargeDiscrepancyDetail(bkgNo, caFlg)); // F Detail
				}
			}
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}		
	
	/**
	 * retrieving Self Audit - TAA A ~ F<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkTaaSelfBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		int cnt = 0;
		try {
			listA1 =	dbDao.selectCheckTaaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
			listA2 =	dbDao.selectCheckTaaApplicationDateDiscrepancy(bkgNo, caFlg);// A2 
			listB  = 	dbDao.selectCheckTaaCustomerDiscrepancy(bkgNo, caFlg);     // B   
			listC  = 	dbDao.selectCheckTaaCommodityDiscrepancy(bkgNo, caFlg);    // C
			listD  =	dbDao.selectCheckTaaNonchargedBl(bkgNo, caFlg);            // D
			listE  =	dbDao.selectCheckTaaSelfOftDiscrepancy(bkgNo, caFlg);               // E
			listF  =	dbDao.selectCheckTaaSelfSurchargeDiscrepancy(bkgNo, caFlg);         // F
						
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0){
				cnt++;
			}
			if(listF.size() > 0){
				cnt++;
			}
			if(cnt > 0 && listA2.size() > 0 ){
				listA1.addAll(listA2);
			}
			listA1.addAll(listB);
			listA1.addAll(listC);
			listA1.addAll(listD);
			
			if(listE.size() > 0){
				listA1.addAll(listE);          
				if(listE.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckTaaSelfOftDiscrepancyDetail(bkgNo, caFlg)); // E Detail
				}
			}
			if(listF.size() > 0){
				listA1.addAll(listF);          
				if(listF.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckTaaSelfSurchargeDiscrepancyDetail(bkgNo, caFlg)); // F Detail
				}
			}
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}	
	
	/**
	 * retrieving Self Audit - TAA A ~ F<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkTaaUnmatchSCRA(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		int cnt = 0;
		try {
			listA1 =	dbDao.selectCheckTaaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
			listA2 =	dbDao.selectCheckTaaApplicationDateDiscrepancy(bkgNo, caFlg);// A2 
			listB  = 	dbDao.selectCheckTaaCustomerDiscrepancy(bkgNo, caFlg);     // B   
			listC  = 	dbDao.selectCheckTaaCommodityDiscrepancy(bkgNo, caFlg);    // C
			listD  =	dbDao.selectCheckTaaNonchargedBl(bkgNo, caFlg);            // D
			listE  =	dbDao.selectCheckTaaSelfOftDiscrepancy(bkgNo, caFlg);               // E
			listF  =	dbDao.selectCheckTaaSelfSurchargeDiscrepancy(bkgNo, caFlg);         // F
						
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0){
				cnt++;
			}
			if(listF.size() > 0){
				cnt++;
			}
			if(cnt > 0 && listA2.size() > 0 ){
				listA1.addAll(listA2);
			}
			listA1.addAll(listB);
			listA1.addAll(listC);
			listA1.addAll(listD);
			
			if(listE.size() > 0){
				listA1.addAll(listE);          
				if(listE.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckTaaOftDiscrepancyDetail(bkgNo, caFlg)); // E Detail
				}
			}
			if(listF.size() > 0){
				listA1.addAll(listF);          
				if(listF.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckTaaSurchargeDiscrepancyDetail(bkgNo, caFlg)); // F Detail
				}
			}
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}	

	/**
	 * update state.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyReauditUnmatchBLStatus(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id();
		try {
			pVo.setUpdUsrId(usrId);
			pVo.setCreUsrId(usrId);
			dbDao.modifyReauditUnmatchBLStatus(pVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * manage event of BKG_REV_UMCH_BKG Table.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @exception EventException
	*/
	public void modifyCompareBkgRevUmchBkg(UnmatchBLVO pVo) throws EventException{
		try {
			dbDao.modifyCompareBkgRevUmchBkg(pVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * Create RFA Surcharge<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchRfaOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRfaSurchargeInput(String bkgNo, List<SearchRfaOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); 
		String bkgBqSeq, tmpBkgBqSeq = "1";
		String bkgBqOccrSeq;
		int oftListLen = 0;
		String[][] arrStr = null;
		List<String[]> occrList = null;
		int occrListLen = 0;
		int gi = 0, gk = -1, maxGk = 0;
		
		CreateSurchargeInputVO tmpOftListVo = null;
		List<CreateSurchargeInputVO> insertVoList = new ArrayList<CreateSurchargeInputVO>();
		
		try {
			
			oftListLen = oftList.size();
			
			/* 
			* 1 row : 1-1 => bkSeq - BqOccrSeq
			* 2 row : 1-2
			* 3 row : 2-1
			* 4 row : 2-2
			* 5 row : 2-3
			* 6 row : 3-1
			* ..
			*/
			for(int i = 0; i < oftListLen; i++) {
				bkgBqSeq = oftList.get(i).getBkgBqSeq();
				bkgBqOccrSeq = oftList.get(i).getBkgBqOccrSeq();
				
				if(bkgBqSeq.equals(tmpBkgBqSeq)) {
					gk = gk + 1;
				}else{
					gi = gi + 1;
					gk = 0;
				}
				tmpBkgBqSeq = bkgBqSeq;
				
				if(gk > maxGk) {
					maxGk = gk; 
				}
			}

			arrStr = new String[gi+1][maxGk+1];
			
			tmpBkgBqSeq = "1";
			gi = 0; 
			gk = -1;
			for(int i = 0; i < oftListLen; i++) {
				bkgBqSeq = oftList.get(i).getBkgBqSeq();
				bkgBqOccrSeq = oftList.get(i).getBkgBqOccrSeq();
				
				if(bkgBqSeq.equals(tmpBkgBqSeq)) {
					gk = gk + 1;
					arrStr[gi][gk] = bkgBqOccrSeq;
				}else{
					gi = gi + 1;
					gk = 0;
					arrStr[gi][gk] = bkgBqOccrSeq;
				}
				tmpBkgBqSeq = bkgBqSeq;
			}
			
			if(oftListLen > 0) {
				
				if(gi == 0) { 
					String[] tmpArr = new String[gk+1];
					for(int i = 0; i < oftListLen; i++) {
						tmpArr[i] = oftList.get(i).getBkgBqOccrSeq();
					}
					occrList = new ArrayList<String[]>();
					occrList.add(tmpArr);
					occrListLen = 1;
				}else{
					occrList = makeOccurenceCase(arrStr);
					occrListLen = occrList.size();
				}
			}
			
			String[] arrOccr = null;
			int arrOccrLen = 0;
			String chkOccrSeq = "0";
			int bkgBqSeqInt = 0;
			
			String chkOaAddChgSeq = "";
			String chkDaAddChgSeq = "";
			String porMtchFlg = "";
			String delMtchFlg = ""; 
			String oihFlg = ""; 
			String dihFlg = ""; 
			int kkk = 0;
			int cmbSeq = 0;
			
			for(int i = 0; i < occrListLen; i++) {
				
				kkk = 0;
				
				arrOccr = (String[]) occrList.get(i);
				arrOccrLen = arrOccr.length;

				for(int k = 0; k < arrOccrLen; k++) { 
					
					chkOccrSeq = arrOccr[k];
					
					if(gi == 0) {
						kkk = 0;
					}

					for(int g = 0; g < oftListLen; g++) {
						
						bkgBqSeq = oftList.get(g).getBkgBqSeq();
						bkgBqSeqInt = Integer.parseInt(bkgBqSeq); 
						bkgBqOccrSeq = oftList.get(g).getBkgBqOccrSeq();
						
						if( 
							( gi > 0 && (k + 1) == bkgBqSeqInt && bkgBqOccrSeq.equals(chkOccrSeq) ) 
							|| ( gi == 0 && bkgBqOccrSeq.equals(chkOccrSeq) ) 					
						) { 

							if(gi > 0) { 
								cmbSeq = i + 1;
							}else{
								cmbSeq = k + 1;
							}
							
							oftList.get(g).setRatAsQty(oftList.get(g).getOpCntrQty());
							
							kkk++;
							tmpOftListVo = null;
							tmpOftListVo = new CreateSurchargeInputVO();
							ObjectCloner.build( oftList.get(g), tmpOftListVo);
							tmpOftListVo.setBkgNo(bkgNo);
							tmpOftListVo.setUsrId(usrId);
							tmpOftListVo.setOftCmbSeq(""+cmbSeq);
							tmpOftListVo.setOfrtSeq(""+kkk);
							tmpOftListVo.setChgCd("OFT");
							tmpOftListVo.setChgUtAmt(tmpOftListVo.getRtCalcFrtRtAmt()); // CHG_CD = 'OFT' THEN RT_CALC_FRT_RT_AMT

							insertVoList.add(tmpOftListVo);
								
							chkOaAddChgSeq = oftList.get(g).getOaAddChgSeq();
							chkDaAddChgSeq = oftList.get(g).getDaAddChgSeq();
							porMtchFlg     = oftList.get(g).getPorMtchFlg();
							delMtchFlg     = oftList.get(g).getDelMtchFlg();
							oihFlg         = oftList.get(g).getOihFlg();
							dihFlg         = oftList.get(g).getDihFlg();
							
							if(!chkOaAddChgSeq.equals("0")) { // OA_ADD_CHG_SEQ <> 0
								kkk++;
								tmpOftListVo = null;
								tmpOftListVo = new CreateSurchargeInputVO();
								ObjectCloner.build(oftList.get(g), tmpOftListVo);
								tmpOftListVo.setBkgNo(bkgNo);
								tmpOftListVo.setUsrId(usrId);
								tmpOftListVo.setOftCmbSeq(""+cmbSeq);
								tmpOftListVo.setOfrtSeq(""+kkk);
								tmpOftListVo.setChgCd("OAR");
								if(porMtchFlg.equals("Y") && oihFlg.equals("Y")) {
									tmpOftListVo.setChgCd("OIH"); 
								}
								tmpOftListVo.setCurrCd(tmpOftListVo.getOaCurrCd()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CURR_CD
								tmpOftListVo.setChgUtAmt(tmpOftListVo.getOaCalcFrtRtAmt()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CALC_FRT_RT_AMT
								
								insertVoList.add(tmpOftListVo);
							}
							
							// 'DAR'
							// DA_ADD_CHG_SEQ <> 0 AND DEL_MTCH_FLG = 'Y' AND DIH_FLG = 'Y'  'DAR' -> 'DIH'
							if(!chkDaAddChgSeq.equals("0")) {  // DA_ADD_CHG_SEQ <> 0
								kkk++;
								tmpOftListVo = null;
								tmpOftListVo = new CreateSurchargeInputVO();
								ObjectCloner.build(oftList.get(g), tmpOftListVo);
								tmpOftListVo.setBkgNo(bkgNo);
								tmpOftListVo.setUsrId(usrId);
								tmpOftListVo.setOftCmbSeq(""+cmbSeq);
								tmpOftListVo.setOfrtSeq(""+kkk);
								tmpOftListVo.setChgCd("DAR");
								if(delMtchFlg.equals("Y") && dihFlg.equals("Y")) {
									tmpOftListVo.setChgCd("DIH");  // DA_ADD_CHG_SEQ <> 0 AND DEL_MTCH_FLG = 'Y' AND DIH_FLG = 'Y'  'DAR' -> 'DIH' 
								}
								tmpOftListVo.setCurrCd(tmpOftListVo.getDaCurrCd());	// CHG_CD IN ( 'DAR', 'DIH' ) THEN DA_CURR_CD						
								tmpOftListVo.setChgUtAmt(tmpOftListVo.getDaCalcFrtRtAmt());	// CHG_CD IN ( 'DAR', 'DIH' ) THEN DA_CALC_FRT_RT_AMT							
								
								insertVoList.add(tmpOftListVo);
							}
							
							if(porMtchFlg.equals("N")) { 
								kkk++;
								tmpOftListVo = null;
								tmpOftListVo = new CreateSurchargeInputVO();
								ObjectCloner.build(oftList.get(g), tmpOftListVo);
								tmpOftListVo.setBkgNo(bkgNo);
								tmpOftListVo.setUsrId(usrId);
								tmpOftListVo.setOftCmbSeq(""+cmbSeq);
								tmpOftListVo.setOfrtSeq(""+kkk);
								tmpOftListVo.setChgCd("OIH");
								tmpOftListVo.setChgUtAmt("0"); 
								
								insertVoList.add(tmpOftListVo);
							}
							
							if(delMtchFlg.equals("N")) {
								kkk++;
								tmpOftListVo = null;
								tmpOftListVo = new CreateSurchargeInputVO();
								ObjectCloner.build(oftList.get(g), tmpOftListVo);
								tmpOftListVo.setBkgNo(bkgNo);
								tmpOftListVo.setUsrId(usrId);
								tmpOftListVo.setOftCmbSeq(""+cmbSeq);
								tmpOftListVo.setOfrtSeq(""+kkk);
								tmpOftListVo.setChgCd("DIH");
								tmpOftListVo.setChgUtAmt("0"); 
								
								insertVoList.add(tmpOftListVo);
							}

						} // end if
						
					} // end for
					
				} // end for
				
			} // end for
			
			if(insertVoList.size() > 0) {
				dbDao.createRfaSurchargeInput(insertVoList); 
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * Create TAA Surcharge<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchTaaOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTaaSurchargeInput(String bkgNo, List<SearchTaaOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); 
		String bkgBqSeq, tmpBkgBqSeq = "1";
		String bkgBqOccrSeq;
		int oftListLen = 0;
		String[][] arrStr = null;
		List<String[]> occrList = null;
		int occrListLen = 0;
		int gi = 0, gk = -1, maxGk = 0;
		
		CreateSurchargeInputVO tmpOftListVo = null;
		
		List<CreateSurchargeInputVO> insertVoList = new ArrayList<CreateSurchargeInputVO>();
		
		try {
			
			oftListLen = oftList.size();

			for(int i = 0; i < oftListLen; i++) {
				bkgBqSeq = oftList.get(i).getBkgBqSeq();
				bkgBqOccrSeq = oftList.get(i).getBkgBqOccrSeq();
				
				if(bkgBqSeq.equals(tmpBkgBqSeq)) {
					gk = gk + 1;
				}else{
					gi = gi + 1;
					gk = 0;
				}
				tmpBkgBqSeq = bkgBqSeq;
				
				if(gk > maxGk) {
					maxGk = gk; 
				}
			}

			arrStr = new String[gi+1][maxGk+1];
			
			tmpBkgBqSeq = "1";
			gi = 0; 
			gk = -1;
			for(int i = 0; i < oftListLen; i++) {
				bkgBqSeq = oftList.get(i).getBkgBqSeq();
				bkgBqOccrSeq = oftList.get(i).getBkgBqOccrSeq();
				
				if(bkgBqSeq.equals(tmpBkgBqSeq)) {
					gk = gk + 1;
					arrStr[gi][gk] = bkgBqOccrSeq;
				}else{
					gi = gi + 1;
					gk = 0;
					arrStr[gi][gk] = bkgBqOccrSeq;
				}
				tmpBkgBqSeq = bkgBqSeq;
			}
			
			if(oftListLen > 0) {
				if(gi == 0) { 
					String[] tmpArr = new String[gk+1];
					for(int i = 0; i < oftListLen; i++) {
						tmpArr[i] = oftList.get(i).getBkgBqOccrSeq();
					}
					occrList = new ArrayList<String[]>();
					occrList.add(tmpArr);
					occrListLen = 1;
				}else{
					occrList = makeOccurenceCase(arrStr);
					occrListLen = occrList.size();
				}
			}
			
			String[] arrOccr = null;
			int arrOccrLen = 0;
			String chkOccrSeq = "0";
			int bkgBqSeqInt = 0;
			
			String porMtchFlg = "";
			String delMtchFlg = ""; 
			int kkk = 0;
			int cmbSeq = 0;
			
			for(int i = 0; i < occrListLen; i++) { 
				kkk = 0;
				
				arrOccr = (String[]) occrList.get(i);
				arrOccrLen = arrOccr.length;

				for(int k = 0; k < arrOccrLen; k++) {
					
					chkOccrSeq = arrOccr[k];
					if(gi == 0) {
						kkk = 0;
					}

					for(int g = 0; g < oftListLen; g++) {
						
						bkgBqSeq = oftList.get(g).getBkgBqSeq();
						bkgBqSeqInt = Integer.parseInt(bkgBqSeq); 
						bkgBqOccrSeq = oftList.get(g).getBkgBqOccrSeq();
						
						// 조합 발행 
						if( 
							( gi > 0 && (k + 1) == bkgBqSeqInt && bkgBqOccrSeq.equals(chkOccrSeq) ) ||
							( gi == 0 && bkgBqOccrSeq.equals(chkOccrSeq) ) 							  
						) { 

							if(gi > 0) {
								cmbSeq = i + 1; 
							}else{
								cmbSeq = k + 1;
							}
							
							oftList.get(g).setRatAsQty(oftList.get(g).getOpCntrQty());
							
							kkk++;
							tmpOftListVo = null;
							tmpOftListVo = new CreateSurchargeInputVO();
							ObjectCloner.build( oftList.get(g), tmpOftListVo);
							tmpOftListVo.setBkgNo(bkgNo);
							tmpOftListVo.setUsrId(usrId);
							tmpOftListVo.setOftCmbSeq(""+cmbSeq);
							tmpOftListVo.setOfrtSeq(""+kkk);
							tmpOftListVo.setChgCd("OFT");
							tmpOftListVo.setChgUtAmt(tmpOftListVo.getRtCalcFrtRtAmt()); // CHG_CD = 'OFT' THEN RT_CALC_FRT_RT_AMT

							insertVoList.add(tmpOftListVo);
								
							porMtchFlg     = oftList.get(g).getPorMtchFlg();
							delMtchFlg     = oftList.get(g).getDelMtchFlg();
							
							if(porMtchFlg.equals("N")) { 
								kkk++;
								tmpOftListVo = null;
								tmpOftListVo = new CreateSurchargeInputVO();
								ObjectCloner.build(oftList.get(g), tmpOftListVo);
								tmpOftListVo.setBkgNo(bkgNo);
								tmpOftListVo.setUsrId(usrId);
								tmpOftListVo.setOftCmbSeq(""+cmbSeq);
								tmpOftListVo.setOfrtSeq(""+kkk);
								tmpOftListVo.setChgCd("OIH");
								tmpOftListVo.setChgUtAmt("0"); 
								
								insertVoList.add(tmpOftListVo);
							}
							
							if(delMtchFlg.equals("N")) {
								kkk++;
								tmpOftListVo = null;
								tmpOftListVo = new CreateSurchargeInputVO();
								ObjectCloner.build(oftList.get(g), tmpOftListVo);
								tmpOftListVo.setBkgNo(bkgNo);
								tmpOftListVo.setUsrId(usrId);
								tmpOftListVo.setOftCmbSeq(""+cmbSeq);
								tmpOftListVo.setOfrtSeq(""+kkk);
								tmpOftListVo.setChgCd("DIH");
								tmpOftListVo.setChgUtAmt("0");
								
								insertVoList.add(tmpOftListVo);
							}

						} // end if
						
					} // end for
					
				} // end for
				
			} // end for
			
			if(insertVoList.size() > 0) {
				dbDao.createTaaSurchargeInput(insertVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * get RFA Surcharge<br>
	 * 
	 * @param String[][] caseList
	 * @return ArrayList<String[]>
	 * @exception EventException
	 */
	public ArrayList<String[]> makeOccurenceCase(String[][] caseList) throws EventException{
		ArrayList<String[]> occurCase = new ArrayList<String[]>();
		try {
			findCase(occurCase, caseList, null, 0);
			return 	occurCase;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}

	/**
	 * find RFA Surcharge<br>
	 * 
	 * @param ArrayList<String[]> occurList
	 * @param String[][] caseList
	 * @param String[] route
	 * @param int idx
	 * @exception EventException
	 */
	public void findCase(ArrayList<String[]> occurList, String[][] caseList, String[] route, int idx) throws EventException {
		try {
			for(int i = 0 ; i < caseList[idx].length ; i++){
				if( caseList.length == idx+1) {
					String[] tmp = route.clone();
					tmp[idx] = caseList[idx][i];	
					occurList.add(tmp);
				}
				else {
					if( route == null ){
						route = new String[caseList.length];
					}
					route[idx] = caseList[idx][i];
					findCase(occurList, caseList, route, idx+1);
				}
			}
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}	
	
	/**
	 * Create RFA, TAA RevenueAuditOft<br>
	 *  
	 * @exception EventException
	 */
	public void createRevenueAuditOft() throws EventException{
		try {
			dbDao.createRevenueAuditOft();	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * Create RFA, TAA RevenueAudit Surcharge<br>
	 * 
	 * @param List<SearchScOftAutoratingListVO> surList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRevenueAuditSurcharge(List<SearchScOftAutoratingListVO> surList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); 
		int listLen = 0;
		try {
			listLen = surList.size();
			for(int i = 0; i < listLen; i++) {
				surList.get(i).setUsrId(usrId);
			}
			if(listLen > 0) {
				dbDao.createRevenueAuditSurcharge(surList);			
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * retrieving maxseq <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMaxUmchBkgSeq(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException {
		String usrId = account.getUsr_id();
		try {
			pVo.setCreUsrId(usrId);
			return dbDao.searchMaxUmchBkgSeq(pVo);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}		
	
	/**
	 * Crate Unmatch data<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param List<UnmatchBLVO> unmatchList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addCompareBkgRevUmchAll(UnmatchBLVO pVo, List<UnmatchBLVO> unmatchList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id();
		int unmatchListLen = 0;
		String umchTpCd;
		String mtchUmchTpCd;
		String umchItmSeq;
		UnmatchBLVO lVo = null;
		try {
			
			pVo.setCreUsrId(usrId);
			dbDao.addCompareBkgRevUmchBkg(pVo); // bkg create
			
			unmatchListLen = unmatchList.size();
			
			for(int i = 0; i < unmatchListLen; i++) {
				
				umchTpCd     = unmatchList.get(i).getUmchTpCd();
				mtchUmchTpCd = unmatchList.get(i).getMtchUmchTpCd();
				umchItmSeq   = unmatchList.get(i).getUmchItmSeq();
				if(null == umchTpCd)     { umchTpCd = "";}
				if(null == mtchUmchTpCd) { mtchUmchTpCd = "";}
				if(null == umchItmSeq)   { umchItmSeq = "";}
				
				if( ( umchTpCd.equals("E") || umchTpCd.equals("F") ) && !umchItmSeq.equals("") ){
					lVo = new UnmatchBLVO();
					lVo = unmatchList.get(i);
					lVo.setBkgNo(pVo.getBkgNo());
					lVo.setMaxUmchBkgSeq(pVo.getMaxUmchBkgSeq());
					lVo.setCreUsrId(usrId);				
					dbDao.addCompareBkgRevUmchItmDtl(lVo); // itm dtl create
				}else{
					lVo = new UnmatchBLVO();
					lVo = unmatchList.get(i);
					lVo.setBkgNo(pVo.getBkgNo());
					lVo.setMaxUmchBkgSeq(pVo.getMaxUmchBkgSeq());
					lVo.setCreUsrId(usrId);				
					dbDao.addCompareBkgRevUmchItm(lVo); // itm create
				}
				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * retrieving of BKG_REV_UMCH_BKG state<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchBkg(UnmatchBLVO pVo) throws EventException {
		try {
			return dbDao.selectCompareBkgRevUmchBkg(pVo);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}		
	
	/**
	 * retrieving of BKG_REV_UMCH_ITM <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchItm(UnmatchBLVO pVo) throws EventException {
		try {
			return dbDao.selectCompareBkgRevUmchItm(pVo);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}		
	
	/**
	 * retrieving of BKG_REV_UMCH_ITM_DTL  <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchItmDtl(UnmatchBLVO pVo) throws EventException {
		try {
			return dbDao.selectCompareBkgRevUmchItmDtl(pVo);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}		
	
	/**
	 * delete Unmatch data<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @exception EventException
	 */
	public void removeCompareBkgRevUmchAll(UnmatchBLVO pVo) throws EventException{
		try {
			dbDao.removeCompareBkgRevUmchItmDtl(pVo);
			dbDao.removeCompareBkgRevUmchItm(pVo);
			dbDao.removeCompareBkgRevUmchBkg(pVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * Modify BKG_REV_UMCH_BKG TABLE LST_UMCH_FND_DT<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCompareBkgRevUmchBkgFndDt(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException{
		try {
			pVo.setUpdUsrId(account.getUsr_id());
			dbDao.modifyCompareBkgRevUmchBkgFndDt(pVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}	
	
	/**
	 * Retrieving of RFA, TAA
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @exception EventException
	 */
	public String searchAuditRtAplyDt(String bkgNo, String caFlg) throws EventException {
		try {
			return dbDao.searchAuditRtAplyDt(bkgNo, caFlg);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}		

	/**
	 * Retrieving RDN
	 * @param unmatchBLVO
	 * @return AutoRdnInfoVO
	 * @throws EventException
	 */
	public AutoRdnInfoVO searchAutoRdnInfo(UnmatchBLVO unmatchBLVO) throws EventException {
		try {
			return dbDao.searchAutoRdnInfo(unmatchBLVO);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00098").getMessage(), ex);
	    }catch (Exception de) {
	        throw new EventException(new ErrorHandler("BKG00098").getMessage(), de);
		}
	}
	/**
	 * Self Audit 
	 * @param String blNo
	 * @param String caflg
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchSelfAuditListBackEndJob(String blNo, String caFlg, SignOnUserAccount account) throws EventException { 
		BackEndJobManager backEndJobManager = null;
		SearchSelfAuditListBackEndJob backEndJob = null;
		String jobID = null;
		try {
			backEndJobManager = new BackEndJobManager();
			backEndJob = new SearchSelfAuditListBackEndJob(blNo, caFlg, account);
			jobID = backEndJobManager.execute(backEndJob, account.getUsr_id(), "SearchSelfAuditListBackEndJob");
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return jobID;
	}
	
	/**
	 * Self Audit 리스트 조회
	 * @param String key
	 * @return RlstSearchSelfAuditListVO
	 * @throws EventException
	 */
	public RlstSearchSelfAuditListVO searchSelfAuditList(String key) throws EventException {
		RlstSearchSelfAuditListVO rlstSearchSelfAuditListVO = null;
		try {
			rlstSearchSelfAuditListVO = eaiDao.searchSelfAuditList(key);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return rlstSearchSelfAuditListVO;
	}
	
	/**
	 * Self Audit - RFA A1을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaEffectiveDateDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		

	/**
	 * Self Audit - RFA A2을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkApplicationDateDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckApplicationDateDiscrepancy(bkgNo, caFlg); // A2
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		

	/**
	 * Self Audit - RFA B을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaCustomerDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaCustomerDiscrepancy(bkgNo, caFlg); // B
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		

	/**
	 * Self Audit - RFA C을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaCommodityDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaCommodityDiscrepancy(bkgNo, caFlg); // C
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		

	/**
	 * Self Audit - RFA D을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaNonchargedBl(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaNonchargedBl(bkgNo, caFlg); // D
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		

	/**
	 * Audit - RFA E을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaOftDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaOftDiscrepancy(bkgNo, caFlg); // E
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		

	/**
	 * Self Audit - RFA E을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSelfOftDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaSelfOftDiscrepancy(bkgNo, caFlg); // E
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Audit - RFA F을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSurchargeDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaSurchargeDiscrepancy(bkgNo, caFlg); // F
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		
	
	/**
	 * Self Audit - RFA F을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSelfSurchargeDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaSelfSurchargeDiscrepancy(bkgNo, caFlg); // F
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Self Audit - checkRfaOftDiscrepancyDetail <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaOftDiscrepancyDetail(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaOftDiscrepancyDetail(bkgNo, caFlg);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}		

	/**
	 * Self Audit - checkRfaSurchargeDiscrepancyDetail <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSurchargeDiscrepancyDetail(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaSurchargeDiscrepancyDetail(bkgNo, caFlg);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Audit - SC A ~ E 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLIncludeOFTbyBooking(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;	
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
//		List<UnmatchBLVO> listG = null;
		int cnt = 0;
		String passFlg = "N";
		try {
			listA1 = dbDao.selectCheckScEffectiveDateDiscrepancy(bkgNo, caFlg);		// A1
			listA2 = dbDao.selectCheckScApplicationDateDiscrepancy(bkgNo, caFlg);	// A2
			listB  = dbDao.selectCheckScCustomerDiscrepancy(bkgNo, caFlg);			// B   
			listC  = dbDao.selectCheckScCommodityDiscrepancy(bkgNo, caFlg);			// C
			listD  = dbDao.selectCheckScNonchargedBl(bkgNo, caFlg);					// D
			listE  = dbDao.selectCheckScOftDiscrepancy(bkgNo, caFlg);				// E
			listF  = dbDao.selectCheckScSurchargeDiscrepancy(bkgNo, caFlg);			// F
			passFlg = dbDao.checkTotalBlAmount(bkgNo, caFlg);
			
			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0){
				cnt++;
			}
			if(listF.size() > 0){
				cnt++;
			}
			if(cnt > 0 && listA2.size() > 0 ){
				listA1.addAll(listA2);
			}
			listA1.addAll(listB);
			listA1.addAll(listC);
			listA1.addAll(listD);
			
			if(listE.size()>0 && "N".equals(passFlg)){
				listA1.addAll(listE);
				if(listE.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckScOftDiscrepancyDetail(bkgNo, caFlg));
				}
			}
				
			if(listF.size() > 0){
				listA1.addAll(listF);          
				if(listF.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckScSurchargeDiscrepancyDetail(bkgNo, caFlg)); // F Detail
				}
			}
			
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}
	
	/**
	 * Self Audit - SC A ~ E 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLIncludeSelfOFTbyBooking(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;	
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
//		List<UnmatchBLVO> listG = null;
		int cnt = 0;
		String passFlg = "N";
		try {
			listA1 = dbDao.selectCheckScEffectiveDateDiscrepancy(bkgNo, caFlg);		// A1
			listA2 = dbDao.selectCheckScApplicationDateDiscrepancy(bkgNo, caFlg);	// A2
			listB  = dbDao.selectCheckScCustomerDiscrepancy(bkgNo, caFlg);			// B   
			listC  = dbDao.selectCheckScCommodityDiscrepancy(bkgNo, caFlg);			// C
			listD  = dbDao.selectCheckScNonchargedBl(bkgNo, caFlg);					// D
			listE  = dbDao.selectCheckScSelfOftDiscrepancy(bkgNo, caFlg);				// E
			listF  = dbDao.selectCheckScSelfSurchargeDiscrepancy(bkgNo, caFlg);			// F
			passFlg = dbDao.checkTotalBlAmount(bkgNo, caFlg);
			
			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0){
				cnt++;
			}
			if(listF.size() > 0){
				cnt++;
			}
			if(cnt > 0 && listA2.size() > 0 ){
				listA1.addAll(listA2);
			}
			listA1.addAll(listB);
			listA1.addAll(listC);
			listA1.addAll(listD);
			
			if(listE.size()>0 && "N".equals(passFlg)){
				listA1.addAll(listE);
				if(listE.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckScSelfOftDiscrepancyDetail(bkgNo, caFlg));
				}
			}
				
			if(listF.size() > 0){
				listA1.addAll(listF);          
				if(listF.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckScSelfSurchargeDiscrepancyDetail(bkgNo, caFlg)); // F Detail
				}
			}
			
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}
	
	/**
	 * Self Audit - SC A ~ E 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchSCRA(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;	
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
//		List<UnmatchBLVO> listG = null;
		int cnt = 0;
		String passFlg = "N";
		try {
			listA1 = dbDao.selectCheckScEffectiveDateDiscrepancy(bkgNo, caFlg);		// A1
			listA2 = dbDao.selectCheckScApplicationDateDiscrepancy(bkgNo, caFlg);	// A2
			listB  = dbDao.selectCheckScCustomerDiscrepancy(bkgNo, caFlg);			// B   
			listC  = dbDao.selectCheckScCommodityDiscrepancy(bkgNo, caFlg);			// C
			listD  = dbDao.selectCheckScNonchargedBl(bkgNo, caFlg);					// D
			listE  = dbDao.selectCheckScSelfOftDiscrepancy(bkgNo, caFlg);				// E
			listF  = dbDao.selectCheckScSelfSurchargeDiscrepancy(bkgNo, caFlg);			// F
			passFlg = dbDao.checkTotalBlAmount(bkgNo, caFlg);
			
			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0){
				cnt++;
			}
			if(listF.size() > 0){
				cnt++;
			}
			if(cnt > 0 && listA2.size() > 0 ){
				listA1.addAll(listA2);
			}
			listA1.addAll(listB);
			listA1.addAll(listC);
			listA1.addAll(listD);
			
			if(listE.size()>0 && "N".equals(passFlg)){
				listA1.addAll(listE);
				if(listE.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckScOftDiscrepancyDetail(bkgNo, caFlg));
				}
			}
				
			if(listF.size() > 0){
				listA1.addAll(listF);          
				if(listF.get(0).getMtchUmchTpCd().equals("U") && mod.equals("C")){
					listA1.addAll(dbDao.selectCheckScSurchargeDiscrepancyDetail(bkgNo, caFlg)); // F Detail
				}
			}
			
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}
	/**
	 * SC Surcharge를 생성한다.<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchScOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createScSurchargeInput(String bkgNo, List<SearchScOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); // 배치도확인
		String bkgBqSeq, tmpBkgBqSeq = "1";
		String bkgBqOccrSeq;
		int oftListLen = 0;
		int oftChgCnt = 0;
		String[][] arrStr = null;
		List<String[]> occrList = null;
		int occrListLen = 0;
		int gi = 0, gk = -1, maxGk = 0;
		
		CreateSurchargeInputVO tmpOftListVo = null;
		List<CreateSurchargeInputVO> insertVoList = new ArrayList<CreateSurchargeInputVO>();
		
		try {
			
			oftListLen = oftList.size();
			oftChgCnt = dbDao.searchOftChargeCount(bkgNo);
			
			/* 경우의 수를 구하기 위해 위해 배열 크기정함.
			* 1 row : 1-1 => bkSeq - BqOccrSeq
			* 2 row : 1-2
			* 3 row : 2-1
			* 4 row : 2-2
			* 5 row : 2-3
			* 6 row : 3-1
			* 이런식으로 데이터 넘어온다함.
			*/
			for(int i = 0; i < oftListLen; i++) {
				bkgBqSeq = oftList.get(i).getBkgBqSeq();
				bkgBqOccrSeq = oftList.get(i).getBkgBqOccrSeq();
				
				if(bkgBqSeq.equals(tmpBkgBqSeq)) {
					gk = gk + 1;
				}else{
					gi = gi + 1;
					gk = 0;
				}
				tmpBkgBqSeq = bkgBqSeq;
				
				if(gk > maxGk) {
					maxGk = gk; // 행 중 제일 큰 열 값구함.
				}
			}

			arrStr = new String[gi+1][maxGk+1];
			
			// 배열에  BqOccrSeq 넣어줌
			tmpBkgBqSeq = "1";
			gi = 0; 
			gk = -1;
			for(int i = 0; i < oftListLen; i++) {
				bkgBqSeq = oftList.get(i).getBkgBqSeq();
				bkgBqOccrSeq = oftList.get(i).getBkgBqOccrSeq();
				
				if(bkgBqSeq.equals(tmpBkgBqSeq)) {
					gk = gk + 1;
					arrStr[gi][gk] = bkgBqOccrSeq;
				}else{
					gi = gi + 1;
					gk = 0;
					arrStr[gi][gk] = bkgBqOccrSeq;
				}
				tmpBkgBqSeq = bkgBqSeq;
			}
			
			// 경우의 수 구함.
			if(oftListLen > 0) {
				// 경우의 수 구할수 있는지 확인
				if(gi == 0) { // 경우의 수 구할 수 없다. ex) 1-1, 1-2  이런식으로만 넘어올시 경우의 수 만들어줌
					String[] tmpArr = new String[gk+1];
					for(int i = 0; i < oftListLen; i++) {
						tmpArr[i] = oftList.get(i).getBkgBqOccrSeq();
					}
					occrList = new ArrayList<String[]>();
					occrList.add(tmpArr);
					occrListLen = 1;
				}else{
					occrList = makeOccurenceCase(arrStr);
					occrListLen = occrList.size();
				}
			}
			
			String[] arrOccr = null;
			int arrOccrLen = 0;
			String chkOccrSeq = "0";
			int bkgBqSeqInt = 0;
			
			String rtMtchPattCd = "";
			String oaFnlFrtRtAmt  = "";
			String oiCalcFrtRtAmt = "";
			String daCalcFrtRtAmt = "";
			String diCalcFrtRtAmt = "";
			String porMtchFlg = "";
			String delMtchFlg = ""; 
			int kkk = 0;
			int cmbSeq = 0;
			
			for(int i = 0; i < occrListLen; i++) { // 경우의 수
				
				// 경우의 수 있을 경우 OfrtSeq는 경우의 수 별로 증가
				kkk = 0;
				
				arrOccr = (String[]) occrList.get(i);
				arrOccrLen = arrOccr.length;

				for(int k = 0; k < arrOccrLen; k++) { // 경우의 수 에서 경우 만큼
					
					chkOccrSeq = arrOccr[k];
					
					// 경우의 수 없을 경우 OfrtSeq는 경우의 수 경우별로 증가
					if(gi == 0) {
						kkk = 0;
					}

					// 리스트에서 경우의 수 경우에 해당 되는것 찾는다.
					for(int g = 0; g < oftListLen; g++) {

						bkgBqSeq = oftList.get(g).getBkgBqSeq();
						bkgBqSeqInt = Integer.parseInt(bkgBqSeq); 
						bkgBqOccrSeq = oftList.get(g).getBkgBqOccrSeq();
						
						// 조합 발행 
						if( 
							( gi > 0 && (k + 1) == bkgBqSeqInt && bkgBqOccrSeq.equals(chkOccrSeq) ) // 경우수 있을때는 bkgSeq 와 해당 경우의수 가 같고, BqOccrSeq 와 경우가 같을때 조합 발생
							|| ( gi == 0 && bkgBqOccrSeq.equals(chkOccrSeq) ) 						// 경우수 없을때는 BqOccrSeq 와 경우가 같을때 조합 발생
						) { 

							if(gi > 0) { 
								cmbSeq = i + 1; // 경우의 수가 있을경우 cmbSeq 는 경우의 수 별로...
							}else{
								cmbSeq = k + 1; // 경우의 수가 없을경우 cmbSeq 는 경우의 수 경우 별로...
							}
							
							// RAT_AS_QTY <- OP_CNTR_QTY 미리 바꿔준다.
							oftList.get(g).setRatAsQty(oftList.get(g).getOpCntrQty());
							
							// OFT 무조건생성
							kkk++;
							tmpOftListVo = null;
							tmpOftListVo = new CreateSurchargeInputVO();
							ObjectCloner.build( oftList.get(g), tmpOftListVo);
							tmpOftListVo.setBkgNo(bkgNo);
							tmpOftListVo.setUsrId(usrId);
							tmpOftListVo.setOftCmbSeq(""+cmbSeq);
							tmpOftListVo.setOfrtSeq(""+kkk);
							tmpOftListVo.setChgCd("OFT");
							tmpOftListVo.setInclOftFlg("N");
							if(oftChgCnt>1){
								tmpOftListVo.setChgUtAmt(tmpOftListVo.getRtCalcFrtRtAmt()); // CHG_CD = 'OFT' THEN RT_CALC_FRT_RT_AMT
							}else{
								tmpOftListVo.setChgUtAmt(tmpOftListVo.getFnlFrtRtAmt());
							}
							
							insertVoList.add(tmpOftListVo);
							

							rtMtchPattCd   = oftList.get(g).getRtMtchPattCd();
							oaFnlFrtRtAmt  = oftList.get(g).getOaFnlFrtRtAmt();
							oiCalcFrtRtAmt = oftList.get(g).getOiCalcFrtRtAmt();
							daCalcFrtRtAmt = oftList.get(g).getDaCalcFrtRtAmt();
							diCalcFrtRtAmt = oftList.get(g).getDiCalcFrtRtAmt();
							porMtchFlg     = oftList.get(g).getPorMtchFlg();
							delMtchFlg     = oftList.get(g).getDelMtchFlg();
							
							if(oftChgCnt>1 || "N".equals(porMtchFlg) || "N".equals(delMtchFlg)){
							
								if("1".equals(rtMtchPattCd.substring(2,3))){
									if(!"0".equals(oaFnlFrtRtAmt)){
										kkk++;
										tmpOftListVo = null;
										tmpOftListVo = new CreateSurchargeInputVO();
										ObjectCloner.build(oftList.get(g), tmpOftListVo);
										tmpOftListVo.setBkgNo(bkgNo);
										tmpOftListVo.setUsrId(usrId);
										tmpOftListVo.setOftCmbSeq(""+cmbSeq);
										tmpOftListVo.setOfrtSeq(""+kkk);
										tmpOftListVo.setChgCd("OAR");
										tmpOftListVo.setInclOftFlg("N");
										tmpOftListVo.setCurrCd(tmpOftListVo.getOaCurrCd());
										tmpOftListVo.setChgUtAmt(tmpOftListVo.getOaCalcFrtRtAmt());
										insertVoList.add(tmpOftListVo);
									}
									
								}
								
								if("1".equals(rtMtchPattCd.substring(1,2))){
									if(!"0".equals(oiCalcFrtRtAmt)){
										kkk++;
										tmpOftListVo = null;
										tmpOftListVo = new CreateSurchargeInputVO();
										ObjectCloner.build(oftList.get(g), tmpOftListVo);
										tmpOftListVo.setBkgNo(bkgNo);
										tmpOftListVo.setUsrId(usrId);
										tmpOftListVo.setOftCmbSeq(""+cmbSeq);
										tmpOftListVo.setOfrtSeq(""+kkk);
										tmpOftListVo.setChgCd("OIH");
										tmpOftListVo.setInclOftFlg("N");
										tmpOftListVo.setCurrCd(tmpOftListVo.getOiCurrCd());
										tmpOftListVo.setChgUtAmt(tmpOftListVo.getOiCalcFrtRtAmt());
										insertVoList.add(tmpOftListVo);
									}
									
								}
								if("1".equals(rtMtchPattCd.substring(3,4))){
									if(!"0".equals(daCalcFrtRtAmt)){
										kkk++;
										tmpOftListVo = null;
										tmpOftListVo = new CreateSurchargeInputVO();
										ObjectCloner.build(oftList.get(g), tmpOftListVo);
										tmpOftListVo.setBkgNo(bkgNo);
										tmpOftListVo.setUsrId(usrId);
										tmpOftListVo.setOftCmbSeq(""+cmbSeq);
										tmpOftListVo.setOfrtSeq(""+kkk);
										tmpOftListVo.setChgCd("DAR");
										tmpOftListVo.setInclOftFlg("N");
										tmpOftListVo.setCurrCd(tmpOftListVo.getDaCurrCd());
										tmpOftListVo.setChgUtAmt(tmpOftListVo.getDaCalcFrtRtAmt());
										insertVoList.add(tmpOftListVo);
										
									}
								}
								if("1".equals(rtMtchPattCd.substring(4,5))){
									if(!"0".equals(diCalcFrtRtAmt)){
										kkk++;
										tmpOftListVo = null;
										tmpOftListVo = new CreateSurchargeInputVO();
										ObjectCloner.build(oftList.get(g), tmpOftListVo);
										tmpOftListVo.setBkgNo(bkgNo);
										tmpOftListVo.setUsrId(usrId);
										tmpOftListVo.setOftCmbSeq(""+cmbSeq);
										tmpOftListVo.setOfrtSeq(""+kkk);
										tmpOftListVo.setChgCd("DIH");
										tmpOftListVo.setInclOftFlg("N");
										tmpOftListVo.setCurrCd(tmpOftListVo.getDiCurrCd());
										tmpOftListVo.setChgUtAmt(tmpOftListVo.getDiCalcFrtRtAmt());
										insertVoList.add(tmpOftListVo);
									}
								}
								
								// 'OIH' 추가 ( 이때 CHG_UT_AMT = 0 )
								if(porMtchFlg.equals("N")) {
									kkk++;
									tmpOftListVo = null;
									tmpOftListVo = new CreateSurchargeInputVO();
									ObjectCloner.build(oftList.get(g), tmpOftListVo);
									tmpOftListVo.setBkgNo(bkgNo);
									tmpOftListVo.setUsrId(usrId);
									tmpOftListVo.setOftCmbSeq(""+cmbSeq);
									tmpOftListVo.setOfrtSeq(""+kkk);
									tmpOftListVo.setChgCd("OIH");
									tmpOftListVo.setInclOftFlg("N");
									tmpOftListVo.setChgUtAmt("0"); // OIH 추가 일때 CHG_UT_AMT = 0
									
									insertVoList.add(tmpOftListVo);
								}
								
								// 'DIH' 추가 ( 이때 CHG_UT_AMT = 0 )
								if(delMtchFlg.equals("N")) {
									kkk++;
									tmpOftListVo = null;
									tmpOftListVo = new CreateSurchargeInputVO();
									ObjectCloner.build(oftList.get(g), tmpOftListVo);
									tmpOftListVo.setBkgNo(bkgNo);
									tmpOftListVo.setUsrId(usrId);
									tmpOftListVo.setOftCmbSeq(""+cmbSeq);
									tmpOftListVo.setOfrtSeq(""+kkk);
									tmpOftListVo.setChgCd("DIH");
									tmpOftListVo.setInclOftFlg("N");
									tmpOftListVo.setChgUtAmt("0"); // DIH 추가 일때CHG_UT_AMT = 0
									
									insertVoList.add(tmpOftListVo);
								}
							}

						} // end if
						
					} // end for
					
				} // end for
				
			} // end for
			
			if(insertVoList.size() > 0) {
				dbDao.createScSurchargeInput(insertVoList); // 배치입력
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * 심사를 위해 특정 Rule Type (Conversion Table상 Code)을 포함하는 SC Note를 조회 <br>
	 * 
	 * @param ScNoteConversionVO vo
	 * @return List<ScNoteConversionVO>
	 * @exception EventException
	 */	
	public List<ScNoteConversionVO> searchScNoteConversionListByRule(ScNoteConversionVO vo) throws EventException {
		try {
			return dbDao.searchScNoteConversionListByRule(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchReauditBackEndJobResult(String key) throws EventException {
		String result = null;
		try {
			result = eaiDao.searchReauditBackEndJobResult(key);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return result;
	}
	
	/**
	 * ESM_BKG_0256 : reaudit click <br>
	 * 선택한 BL들에 대한 re-audit을 수행한다.<br>
	 * 
	 * @param String[] bkgNoArr
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String reauditUnmatchBL(String[] bkgNoArr, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = null;
		ReAuditListBackEndJob backEndJob = null;
		String jobID = null;
		try {
			backEndJobManager = new BackEndJobManager();
			backEndJob = new ReAuditListBackEndJob(bkgNoArr, account);
			jobID = backEndJobManager.execute(backEndJob, account.getUsr_id(), "ReAuditListBackEndJob");
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return jobID;
	}

}