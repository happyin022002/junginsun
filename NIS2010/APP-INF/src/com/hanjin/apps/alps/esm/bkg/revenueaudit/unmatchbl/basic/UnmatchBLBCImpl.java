/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLBCImpl.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
* 2010.09.30 이지영 Session User ID 변경
* 2011.05.12 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청
* 2011.05.20 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청 - 오류 수정
* 2012.04.02 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사기능 개발
* 2012.05.18 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사기능 개발 - OFT 계산결과 경우의수 관련 로직 수정
* 2012.06.27 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
* 2012.08.23 김진주 [CHM-201219530] RFA AEE/AEW Autorating 로직 보완
* 2012.09.   김진주 [CHM-201220005] [BKG/DOC - Revenue Audit System] S/C B/L Surcharge 자동심사 시스템 보완 요청
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
* 2012.11.02 김진주 [CHM-201220005] [BKG/DOC - Revenue Audit System] S/C B/L Surcharge 자동심사 시스템 보완 요청
* 2012.12.24 김진주 [CHM-201220395-04] Add-on management T/F
* 2013.02.04 김진주 [CHM-201322626] [BKG/DOC - Revenue Audit System] SZPBB, HKGBB의 DHF 심사로직 추가
* 2013.04.24 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발
* 2013.07.30 김진주 [CHM-201325469] [BKG/DOC - Revenue Audit System] COD BKG Inquiry 기능 개발 요청
* 2013.10.01 김진주 [CHM-201326784] [BKG/DOC - Revenue Audit Syste] Error B/L Inquiry 기능의 Manual Settle(OFC) 기능 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.BlRatingDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLDBDAO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLEAIDAO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BayPlanVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BKGvsBayPlanVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CreateSurchargeInputVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.EqSubErrSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IndiaDthBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IranDthBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgList1VO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.NonAutoratedChargeVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.OblSurrenderForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchDiffAmountVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.SearchStopOffBkgListforAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UmchErrBlReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchSettlementListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AwkwardBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IhcBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListInVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListOutVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.DiversionCAVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RetroactiveBLStatusListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RetroActFilterSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.ScNoteConversionVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.TxsBkgListForAuditSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.TxsBkgListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchRetroActFilterVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.WscBkgListForAuditSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.ReAuditListBackEndJob;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.ManualSettleBackEndJob;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgRevUmchBkgVO;

/**
 * NIS2010-RevenueAudit Business Logic Basic Command implementation<br>
 * - NIS2010-RevenueAudit에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0256EventResponse,UnmatchBLBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class UnmatchBLBCImpl extends BasicCommandSupport implements UnmatchBLBC {

	// Database Access Object
	private transient UnmatchBLDBDAO dbDao = null;
	private transient UnmatchBLEAIDAO eaiDao = null;

	/**
	 * UnmatchBLBCImpl 객체 생성<br>
	 * UnmatchBLDBDAO를 생성한다.<br>
	 */
	public UnmatchBLBCImpl() {
		dbDao = new UnmatchBLDBDAO();
		eaiDao = new UnmatchBLEAIDAO();
	}
	
	
	/**
	 * UNMATCH BL INQUERY 시 조건에 해당되는 BKG COUNT SEARCH<br>
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
	 *  차이금액 상세내역을 조회한다.<br>
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
	 *  unmatch settlement status report list search.<br>
	 * 
	 * @param UnmatchSettlementListVO unmatchSettlementListVO
	 * @return List<UnmatchSettlementListVO>
	 * @exception EventException
	 */
	public List<UnmatchSettlementListVO> searchUnmatchBLSettlementList(UnmatchSettlementListVO unmatchSettlementListVO)  throws EventException {
		try {
			return dbDao.searchUnmatchBLSettlementList(unmatchSettlementListVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	
	/**
	 *  Retroactive B/L status report list search.<br>
	 * 
	 * @param RetroactiveBLStatusListVO retroactiveBLStatusListVO
	 * @return List<RetroactiveBLStatusListVO>
	 * @exception EventException
	 */
	public List<RetroactiveBLStatusListVO> searchRetroactiveBlStatusList(RetroactiveBLStatusListVO retroactiveBLStatusListVO)  throws EventException {
		try {
			return dbDao.searchRetroactiveBlStatusList(retroactiveBLStatusListVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00627").getMessage(), de);
		}
	}
	
	
	/**
	 * UNMACH LIST를 SETTLE 시킴<br>
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
				
				//if ( bkgRevUmchBkgVO[i].getIbflag().equals("U")){ // 선택된것만 넘김 2010.02.22 김대호
					
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
	 * UNMACH LIST를 SETTLE 시킴<br>
	 * 
	 * @param BkgRevUmchBkgVO bkgRevUmchBkgVO
	 * @exception EventException
	 */
	public void settleUnmatchBL(BkgRevUmchBkgVO bkgRevUmchBkgVO) throws EventException{
		try {
				dbDao.modifySettleUnmatchBL(bkgRevUmchBkgVO);
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * UNMACH LIST를 SETTLE 시킴<br>
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
	 * UNMACH LIST를 RMK 수정<br>
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
					
					dbDao.modifyUnmatchBLRmk(bkgRevUmchBkgVO[i],"AUDIT");
					
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
	 * Unmatch B/L Inquiry by Office 를 RMK 수정<br>
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
					
					dbDao.modifyUnmatchBLRmk(bkgRevUmchBkgVO[i],"OFC");
					
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
	 * Unmatch Details 리스트를 조회한다. <br>
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
	 * Unmatch Description 리스트를 조회한다. <br>
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
	 * Charge Filtering 리스트 조회를 위해 BackEndJob을 실행한다. <br>
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
			BookingUtil utilCmd = new BookingUtil();
			
			utilCmd.addBkgLog("BKG_CHARGE_FILTER",account.getUsr_id(), rsltSearchChargeFilteringListVO.toString().substring(0, rsltSearchChargeFilteringListVO.toString().length()));
	        if("".equals(rsltSearchChargeFilteringListVO.getBkgRhqCd())) {
	        	throw new EventException(new ErrorHandler("BKG08237",new String[]{"RHQ"}).getMessage());
	        }
	        if("".equals(rsltSearchChargeFilteringListVO.getChgCd())) {
	        	throw new EventException(new ErrorHandler("BKG08237",new String[]{"Charge Code"}).getMessage());
	        }
	        
	        if((null == rsltSearchChargeFilteringListVO.getBlNo() || "".equals(rsltSearchChargeFilteringListVO.getBlNo().trim())) &&
	           (null == rsltSearchChargeFilteringListVO.getVvd() || "".equals(rsltSearchChargeFilteringListVO.getVvd().trim())) &&
	           (null == rsltSearchChargeFilteringListVO.getFromDt() || "".equals(rsltSearchChargeFilteringListVO.getFromDt()) &&
	        	null == rsltSearchChargeFilteringListVO.getToDt() || "".equals(rsltSearchChargeFilteringListVO.getToDt()))) {
	        		throw new EventException(new ErrorHandler("BKG08237",new String[]{"BL No or Date"}).getMessage());
	        }
			return backEndJobManager.execute(searchChargeFilteringListBackEndJob, account.getUsr_id(), "ESM_BKG_0151 - Search");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Audit by Commodity And Route 리스트 조회를 위해 BackEndJob을 실행한다. <br>
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
	 * BackEndJob의 상태값을 조회한다.<br>
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
	 * Audit by CNTR Qty Discrepancy 리스트를 조회한다. <br>
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
	 * Audit by CNTR Qty Discrepancy 리스트를 저장,수정한다. <br>
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
	 * Audit by Hanger Installation 리스트를 조회한다. <br>
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
	 * Audit by Hanger Installation 리마크를 관리한다. <br>
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
	 * B/L No 로 BkgNo 와 caFlg, ctrtTpCD 를 조회한다. <br>
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
	 * Booking No 로 caFlg, ctrtTpCD 를 조회한다. <br>
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
	 * Self Audit - RFA A ~ F 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException {
		BlRatingDBDAO rateDao = new BlRatingDBDAO();
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;	
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		List<UnmatchBLVO> listG = null;
		int cnt = 0;
		String passFlg = "N";
		try {
			listA1 =	dbDao.selectCheckRfaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
			listA2 =	dbDao.selectCheckApplicationDateDiscrepancy(bkgNo, caFlg); // A2
			listB  =	dbDao.selectCheckRfaCustomerDiscrepancy(bkgNo, caFlg);     // B    
			listC  = 	dbDao.selectCheckRfaCommodityDiscrepancy(bkgNo, caFlg);    // C
			listD  =	dbDao.selectCheckRfaNonchargedBl(bkgNo, caFlg);            // D 
			listE  =	dbDao.selectCheckRfaOftDiscrepancy(bkgNo, caFlg);          // E
			listF  =	dbDao.selectCheckRfaSurchargeDiscrepancy(bkgNo, caFlg, mod);    // F
			listG  =    dbDao.selectAwkwardVoidSlotDiscrepancy(bkgNo, caFlg); //G
			passFlg =   dbDao.checkTotalBlAmount(bkgNo, caFlg);

			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0 && "N".equals(passFlg)){
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
			
			if(listE.size() > 0 && "N".equals(passFlg)){
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
			
			
			//인도 ,이란 향 발에 대해서 IHC,THC 별도 심사
			if(listD.size() == 0){
				String[] cntCd = dbDao.searchCntForSurchargeAudit(bkgNo);
				
				if("IN".equals(cntCd[0]) || "IN".equals(cntCd[1])){ //인도
					String[] chgFlg = new String[2];
					chgFlg = dbDao.selectCheckRfaSurchargeDiscrepancyDetailByCnt(bkgNo, caFlg, "IN"); 
					rateDao.modifyAuditForCnt(bkgNo, chgFlg[0], chgFlg[1], "IN");
				}
				
				if("IR".equals(cntCd[0]) || "IR".equals(cntCd[1])){ //이란
					String[] chgFlg = new String[2];
					chgFlg = dbDao.selectCheckRfaSurchargeDiscrepancyDetailByCnt(bkgNo, caFlg, "IR"); 
					rateDao.modifyAuditForCnt(bkgNo, "" , chgFlg[1], "IR");
				}

			}
			
			if(listG.size() > 0){
				listA1.addAll(listG);
			}
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
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
	 * Self Audit - RFA E을 조회한다. <br>
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
	 * Self Audit - RFA F을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSurchargeDiscrepancy(String bkgNo, String caFlg, String mod) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectCheckRfaSurchargeDiscrepancy(bkgNo, caFlg, mod); // F
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
	 * Self Audit - G 을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkAwkwardVoidSlotDiscrepancy(String bkgNo, String caFlg) throws EventException {
		List<UnmatchBLVO> list = null;
		try {
			list = dbDao.selectAwkwardVoidSlotDiscrepancy(bkgNo, caFlg); // G
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return list;
	}

	/**
	 * Self Audit - SC A ~ D 를 조회한다. <br>
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
	 * Self Audit - SC A ~ E 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @param String batFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLIncludeOFTbyBooking(String bkgNo, String caFlg, String mod, String batFlg) throws EventException {
		BlRatingDBDAO rateDao = new BlRatingDBDAO();
		List<UnmatchBLVO> listA1 = null;
		List<UnmatchBLVO> listA2 = null;
		List<UnmatchBLVO> listB = null;
		List<UnmatchBLVO> listC = null;
		List<UnmatchBLVO> listD = null;	
		List<UnmatchBLVO> listE = null;
		List<UnmatchBLVO> listF = null;
		List<UnmatchBLVO> listG = null;
		int cnt = 0;
		String passFlg = "N";
		try {
			listA1 = dbDao.selectCheckScEffectiveDateDiscrepancy(bkgNo, caFlg);		// A1
			listA2 = dbDao.selectCheckScApplicationDateDiscrepancy(bkgNo, caFlg);	// A2
			listB  = dbDao.selectCheckScCustomerDiscrepancy(bkgNo, caFlg);			// B   
			listC  = dbDao.selectCheckScCommodityDiscrepancy(bkgNo, caFlg);			// C
			listD  = dbDao.selectCheckScNonchargedBl(bkgNo, caFlg);					// D
			listE  = dbDao.selectCheckScOftDiscrepancy(bkgNo, caFlg);				// E
			listF  = dbDao.selectCheckScSurchargeDiscrepancy(bkgNo, caFlg, mod);			// F
			listG  = dbDao.selectAwkwardVoidSlotDiscrepancy(bkgNo, caFlg);          // G
			passFlg = dbDao.checkTotalBlAmount(bkgNo, caFlg);
			
			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0 && "N".equals(passFlg)){
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
			
			
			//인도 향 발에 대해서 IHC,THC 별도 심사
			if(listD.size() == 0 && "Y".equals(batFlg)){
				String[] cntCd = dbDao.searchCntForSurchargeAudit(bkgNo);
				
				if("IN".equals(cntCd[0]) || "IN".equals(cntCd[1])){ //인도
					String[] chgFlg = new String[2];
					chgFlg = dbDao.selectCheckScSurchargeDiscrepancyDetailByCnt(bkgNo, caFlg, "IN"); 
					rateDao.modifyAuditForCnt(bkgNo, chgFlg[0], chgFlg[1], "IN");
				}
				
				if("IR".equals(cntCd[0]) || "IR".equals(cntCd[1])){ //이란
					String[] chgFlg = new String[2];
					chgFlg = dbDao.selectCheckScSurchargeDiscrepancyDetailByCnt(bkgNo, caFlg, "IR"); 
					rateDao.modifyAuditForCnt(bkgNo, "" , chgFlg[1], "IR");
				}

			}
			
			if(listG.size() > 0){
				listA1.addAll(listG);
			}
			
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}
	
	/**
	 * Self Audit - TAA A ~ F 를 조회한다. <br>
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
		List<UnmatchBLVO> listG = null;
		int cnt = 0;
		String passFlg = "N";
		try {
			listA1 =	dbDao.selectCheckTaaEffectiveDateDiscrepancy(bkgNo, caFlg); // A1
			listA2 =	dbDao.selectCheckTaaApplicationDateDiscrepancy(bkgNo, caFlg);// A2 
			listB  = 	dbDao.selectCheckTaaCustomerDiscrepancy(bkgNo, caFlg);     // B   
			listC  = 	dbDao.selectCheckTaaCommodityDiscrepancy(bkgNo, caFlg);    // C
			listD  =	dbDao.selectCheckTaaNonchargedBl(bkgNo, caFlg);            // D
			listE  =	dbDao.selectCheckTaaOftDiscrepancy(bkgNo, caFlg);          // E
			listF  =	dbDao.selectCheckTaaSurchargeDiscrepancy(bkgNo, caFlg);    // F
			listG  =    dbDao.selectAwkwardVoidSlotDiscrepancy(bkgNo, caFlg);      // G 
			passFlg = dbDao.checkTotalBlAmount(bkgNo, caFlg);
									
			/* Error Type 이 D or E or F 가 없으면 A2 는  Success 처리 */
			if(listD.size() > 0){
				cnt++;
			}
			if(listE.size() > 0 && "N".equals(passFlg)){
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
			
			if(listE.size() > 0 && "N".equals(passFlg)){
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
			if(listG.size() > 0){
				listA1.addAll(listG);
			}
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
		return listA1;
	}		

	/**
	 * booking status 가 X 일때 Re Audit 상태를 업데이트 한다.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyReauditUnmatchBLStatus(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); // 배치도확인
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
	 * 신규생성된 BKG_REV_UMCH_BKG 테이블을 새로이 갱신한다.<br>
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
	 * SC Surcharge를 생성한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param List<SearchScOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createScSurchargeInput(String bkgNo, String caFlg, List<SearchScOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException{
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
			oftChgCnt = dbDao.searchOftChargeCount(bkgNo, caFlg);
			
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
							oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
							

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
										oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
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
										oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
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
										oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
										
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
										oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
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
									oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
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
									oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
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
	 * TAA Surcharge를 생성한다.<br>
	 * RFA Surcharge 와 다르게 TAA는 'OAR', 'DAR' 없다.<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchTaaOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTaaSurchargeInput(String bkgNo, List<SearchTaaOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); // 배치도확인
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
				if(gi == 0) { // // 경우의 수 구할 수 없다. ex) 1-1, 1-2  이런식으로만 넘어올시 경우의 수 만들어줌
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
							( gi > 0 && (k + 1) == bkgBqSeqInt && bkgBqOccrSeq.equals(chkOccrSeq) ) || // 경우수 있을때는 bkgSeq 와 해당 경우의수 가 같고, BqOccrSeq 와 경우가 같을때 조합 발생
							( gi == 0 && bkgBqOccrSeq.equals(chkOccrSeq) ) 							   // 경우수 없을때는 BqOccrSeq 와 경우가 같을때 조합 발생
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
							tmpOftListVo.setChgUtAmt(tmpOftListVo.getRtCalcFrtRtAmt()); // CHG_CD = 'OFT' THEN RT_CALC_FRT_RT_AMT

							insertVoList.add(tmpOftListVo);
							oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
							
							rtMtchPattCd   = oftList.get(g).getRtMtchPattCd();
							oaFnlFrtRtAmt  = oftList.get(g).getOaFnlFrtRtAmt();	
							porMtchFlg     = oftList.get(g).getPorMtchFlg();
							delMtchFlg     = oftList.get(g).getDelMtchFlg();
							
							// TAA는 'OAR', 'DAR' 가 보통 없다. (하지만 ACE,TPE의 경우에는 OAR만 존재)
							if("N".equals(porMtchFlg)){
								if("1".equals(rtMtchPattCd.substring(1,2))){
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
										oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
									}
									
								}
							}
							
							// 'OIH' 추가 ( 이때 CHG_UT_AMT = 0 )
							if(porMtchFlg.equals("N") && !"1".equals(rtMtchPattCd.substring(1,2))) { 
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
								oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
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
								oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
							}

						} // end if
						
					} // end for
					
				} // end for
				
			} // end for
			
			if(insertVoList.size() > 0) {
				dbDao.createTaaSurchargeInput(insertVoList); // 배치입력
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
	 * RFA Surcharge를 생성한다.<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchRfaOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRfaSurchargeInput(String bkgNo, List<SearchRfaOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); // 배치도확인
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
				
				if(bkgBqSeq.equals(tmpBkgBqSeq) || (i==0 && !"1".equals(bkgBqSeq))) {
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
				
				if(bkgBqSeq.equals(tmpBkgBqSeq) || (i==0 && !"1".equals(bkgBqSeq))){
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
			
			String rtMtchPattCd   = "";
			String porMtchFlg = "";
			String delMtchFlg = ""; 
			String oihFlg = ""; 
			String dihFlg = ""; 
			String svcScpCd = "";
			String rcvTermCd = "";
			String deTermCd = "";
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
							tmpOftListVo.setChgUtAmt(tmpOftListVo.getRtCalcFrtRtAmt()); // CHG_CD = 'OFT' THEN RT_CALC_FRT_RT_AMT

							insertVoList.add(tmpOftListVo);
							oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가

							rtMtchPattCd  = oftList.get(g).getRtMtchPattCd();
							porMtchFlg    = oftList.get(g).getPorMtchFlg();
							delMtchFlg    = oftList.get(g).getDelMtchFlg();
							oihFlg          = oftList.get(g).getOihFlg();
							dihFlg          = oftList.get(g).getDihFlg();
							svcScpCd	     = oftList.get(g).getSvcScpCd();
							rcvTermCd	 = oftList.get(g).getRcvTermCd();
							deTermCd	 = oftList.get(g).getDeTermCd();
							
							if("000".equals(rtMtchPattCd.substring(1,4)) && tmpOftListVo.getOiFnlFrtRtAmt()!="" && tmpOftListVo.getOiFnlFrtRtAmt()!= null ){
								if(Double.parseDouble(tmpOftListVo.getOiFnlFrtRtAmt())>0){
									kkk++;
									tmpOftListVo = null;
									tmpOftListVo = new CreateSurchargeInputVO();
									ObjectCloner.build(oftList.get(g), tmpOftListVo);
									tmpOftListVo.setBkgNo(bkgNo);
									tmpOftListVo.setUsrId(usrId);
									tmpOftListVo.setOftCmbSeq(""+cmbSeq);
									tmpOftListVo.setOfrtSeq(""+kkk);
									tmpOftListVo.setChgCd("OIH");
									tmpOftListVo.setInclOftFlg("I");
									tmpOftListVo.setCurrCd(tmpOftListVo.getOiCurrCd()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CURR_CD
									tmpOftListVo.setChgUtAmt(tmpOftListVo.getOiFnlFrtRtAmt()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CALC_FRT_RT_AMT
									insertVoList.add(tmpOftListVo);
									oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
								}
							}
							

							
							if("000".equals(rtMtchPattCd.substring(1,4)) && tmpOftListVo.getDiFnlFrtRtAmt()!= "" && tmpOftListVo.getDiFnlFrtRtAmt()!= null){
								if(Double.parseDouble(tmpOftListVo.getDiFnlFrtRtAmt())>0){
									kkk++;
									tmpOftListVo = null;
									tmpOftListVo = new CreateSurchargeInputVO();
									ObjectCloner.build(oftList.get(g), tmpOftListVo);
									tmpOftListVo.setBkgNo(bkgNo);
									tmpOftListVo.setUsrId(usrId);
									tmpOftListVo.setOftCmbSeq(""+cmbSeq);
									tmpOftListVo.setOfrtSeq(""+kkk);
									tmpOftListVo.setChgCd("DIH");
									tmpOftListVo.setInclOftFlg("I");
									tmpOftListVo.setCurrCd(tmpOftListVo.getDiCurrCd()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CURR_CD
									tmpOftListVo.setChgUtAmt(tmpOftListVo.getDiFnlFrtRtAmt()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CALC_FRT_RT_AMT
									insertVoList.add(tmpOftListVo);
									oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
								}
							}
							
							
							//Origin - Guideline IHC
							if("1".equals(rtMtchPattCd.substring(1,2))){
								if(Double.parseDouble(tmpOftListVo.getOiFnlIhcRtAmt())>0){
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
									tmpOftListVo.setRatUtCd(tmpOftListVo.getOiRatUtCd());
									tmpOftListVo.setCurrCd(tmpOftListVo.getOiCurrCd()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CURR_CD
									tmpOftListVo.setChgUtAmt(tmpOftListVo.getOiFnlIhcRtAmt()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CALC_FRT_RT_AMT
									insertVoList.add(tmpOftListVo);
									oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
								}
								
							}
							
							//Origin - Guideline Add-on
							if("1".equals(rtMtchPattCd.substring(2,3)) && Double.parseDouble(tmpOftListVo.getOiFnlFdrRtAmt())>0 ){
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
								tmpOftListVo.setRatUtCd(tmpOftListVo.getOiRatUtCd());
								tmpOftListVo.setCurrCd(tmpOftListVo.getOiFdrCurrCd()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CURR_CD
								tmpOftListVo.setChgUtAmt(tmpOftListVo.getOiFnlFdrRtAmt()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CALC_FRT_RT_AMT
								insertVoList.add(tmpOftListVo);
								oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
							}
							
							//Origin - Arbitrary
							if("1".equals(rtMtchPattCd.substring(3,4))){
								if(Double.parseDouble(tmpOftListVo.getOaCalcFrtRtAmt())>0){
									kkk++;
									tmpOftListVo = null;
									tmpOftListVo = new CreateSurchargeInputVO();
									ObjectCloner.build(oftList.get(g), tmpOftListVo);
									tmpOftListVo.setBkgNo(bkgNo);
									tmpOftListVo.setUsrId(usrId);
									tmpOftListVo.setOftCmbSeq(""+cmbSeq);
									tmpOftListVo.setOfrtSeq(""+kkk);
									
									if("0".equals(rtMtchPattCd.substring(1,2))&& "Y".equals(porMtchFlg) 
											&& ( "Y".equals(oihFlg) || ( "N".equals(oihFlg) && "D".equals(rcvTermCd)))){
										tmpOftListVo.setChgCd("OIH");
									}else{
										tmpOftListVo.setChgCd("OAR");
									}
									tmpOftListVo.setInclOftFlg("N");
									tmpOftListVo.setRatUtCd(tmpOftListVo.getOaRatUtCd());
									tmpOftListVo.setCurrCd(tmpOftListVo.getOaCurrCd()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CURR_CD
									tmpOftListVo.setChgUtAmt(tmpOftListVo.getOaCalcFrtRtAmt()); // CHG_CD IN ( 'OAR', 'OIH' ) THEN OA_CALC_FRT_RT_AMT
									insertVoList.add(tmpOftListVo);
									oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
								}
							}
							
							//Destination - Guideline IHC
							if("1".equals(rtMtchPattCd.substring(6,7))){
								if(Double.parseDouble(tmpOftListVo.getDiFnlIhcRtAmt())>0){
									kkk++;
									tmpOftListVo = null;
									tmpOftListVo = new CreateSurchargeInputVO();
									ObjectCloner.build(oftList.get(g), tmpOftListVo);
									tmpOftListVo.setBkgNo(bkgNo);
									tmpOftListVo.setUsrId(usrId);
									tmpOftListVo.setOftCmbSeq(""+cmbSeq);
									tmpOftListVo.setOfrtSeq(""+kkk);
									tmpOftListVo.setChgCd("DIH");  // DA_ADD_CHG_SEQ <> 0 AND DEL_MTCH_FLG = 'Y' AND DIH_FLG = 'Y' 일 경우 'DAR' 을 'DIH' 로 표시
									tmpOftListVo.setInclOftFlg("N");
									tmpOftListVo.setRatUtCd(tmpOftListVo.getDiRatUtCd());
									tmpOftListVo.setCurrCd(tmpOftListVo.getDiCurrCd());	// CHG_CD IN ( 'DAR', 'DIH' ) THEN DA_CURR_CD						
									tmpOftListVo.setChgUtAmt(tmpOftListVo.getDiFnlIhcRtAmt());	// CHG_CD IN ( 'DAR', 'DIH' ) THEN DA_CALC_FRT_RT_AMT							
									insertVoList.add(tmpOftListVo);
									oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
								}
							}
							
							//Destination - Guideline Add-on
							if("1".equals(rtMtchPattCd.substring(5,6)) && Double.parseDouble(tmpOftListVo.getDiFnlFdrRtAmt())>0){
								kkk++;
								tmpOftListVo = null;
								tmpOftListVo = new CreateSurchargeInputVO();
								ObjectCloner.build(oftList.get(g), tmpOftListVo);
								tmpOftListVo.setBkgNo(bkgNo);
								tmpOftListVo.setUsrId(usrId);
								tmpOftListVo.setOftCmbSeq(""+cmbSeq);
								tmpOftListVo.setOfrtSeq(""+kkk);
								tmpOftListVo.setChgCd("DAR");  // DA_ADD_CHG_SEQ <> 0 AND DEL_MTCH_FLG = 'Y' AND DIH_FLG = 'Y' 일 경우 'DAR' 을 'DIH' 로 표시
								tmpOftListVo.setInclOftFlg("N");
								tmpOftListVo.setRatUtCd(tmpOftListVo.getDiRatUtCd());
								tmpOftListVo.setCurrCd(tmpOftListVo.getDiFdrCurrCd());	// CHG_CD IN ( 'DAR', 'DIH' ) THEN DA_CURR_CD						
								tmpOftListVo.setChgUtAmt(tmpOftListVo.getDiFnlFdrRtAmt());	// CHG_CD IN ( 'DAR', 'DIH' ) THEN DA_CALC_FRT_RT_AMT							
								insertVoList.add(tmpOftListVo);
								oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
							}
							
							//Destination - Guideline Add-on
							if("1".equals(rtMtchPattCd.substring(4,5))){
								if(Double.parseDouble(tmpOftListVo.getDaCalcFrtRtAmt())>0){
									kkk++;
									tmpOftListVo = null;
									tmpOftListVo = new CreateSurchargeInputVO();
									ObjectCloner.build(oftList.get(g), tmpOftListVo);
									tmpOftListVo.setBkgNo(bkgNo);
									tmpOftListVo.setUsrId(usrId);
									tmpOftListVo.setOftCmbSeq(""+cmbSeq);
									tmpOftListVo.setOfrtSeq(""+kkk);
									if("0".equals(rtMtchPattCd.substring(6,7)) && "Y".equals(delMtchFlg) 
											&& ("Y".equals(dihFlg) || ("N".equals(dihFlg) && "D".equals(deTermCd)))){
										tmpOftListVo.setChgCd("DIH");
									}else{
										tmpOftListVo.setChgCd("DAR");
									}
									tmpOftListVo.setInclOftFlg("N");
									tmpOftListVo.setRatUtCd(tmpOftListVo.getDaRatUtCd());
									tmpOftListVo.setCurrCd(tmpOftListVo.getDaCurrCd());	// CHG_CD IN ( 'DAR', 'DIH' ) THEN DA_CURR_CD						
									tmpOftListVo.setChgUtAmt(tmpOftListVo.getDaCalcFrtRtAmt());	// CHG_CD IN ( 'DAR', 'DIH' ) THEN DA_CALC_FRT_RT_AMT							
									insertVoList.add(tmpOftListVo);
									oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
								}								
							}
																					
							// 'OIH' 추가 ( 이때 CHG_UT_AMT = 0 )
							if(porMtchFlg.equals("N") && ("0".equals(tmpOftListVo.getOiFnlFrtRtAmt()) || "".equals(tmpOftListVo.getOiFnlFrtRtAmt()))) { 
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
								oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
							}
							
							// 'DIH' 추가 ( 이때 CHG_UT_AMT = 0 )
							if(delMtchFlg.equals("N") && ("0".equals(tmpOftListVo.getDiFnlFrtRtAmt()) || "".equals(tmpOftListVo.getDiFnlFrtRtAmt()))) {
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
								oftList.get(g).setOftCmbSeq(""+cmbSeq);	// RFA(SC/TAA)AuditUnmatchBl.java에서 cmb_seq를 가져오기 위해 추가
							}

						} // end if
						
					} // end for
					
				} // end for
				
			} // end for
			
			if(insertVoList.size() > 0) {
				dbDao.createRfaSurchargeInput(insertVoList); // 배치입력
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
	 * RFA Surcharge 경우의 수 만큼 가져온다.<br>
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
	 * RFA Surcharge 경우의 수 만큼 계산한다.<br>
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
					
					if("".equals(tmp[idx]) || tmp[idx]==null) break;
					occurList.add(tmp);
				}
				else {
					if( route == null ){
						route = new String[caseList.length];
					}
					route[idx] = caseList[idx][i];
					if("".equals(route[idx]) || route[idx]==null){
						break;
					}else{
						findCase(occurList, caseList, route, idx+1);
					}
				}
			}
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}	
	
	/**
	 * RFA, TAA RevenueAuditOft를 생성한다.<br>
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
	 * Group & Multi B/L Rating을위해 RevenueAuditOft를 생성한다.<br>
	 *  
	 * @exception EventException
	 */
	public void createRevenueAuditOftForMultiRating() throws EventException{
		try {
			dbDao.createRevenueAuditOftForMultiRating();	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * RFA, TAA RevenueAudit Surcharge를 생성한다.<br>
	 * 
	 * @param List<SearchScOftAutoratingListVO> surList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRevenueAuditSurcharge(List<SearchScOftAutoratingListVO> surList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); // 배치도확인
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
	 * 특정 SC에 대해 OTH <> ORC 상호 호환하여 심사할 수 있도록 Charge Code를 업데이트<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyORCOTHChargeRate(String bkgNo, String caFlg) throws EventException{
		try {
			dbDao.modifyORCOTHChargeRate(bkgNo, caFlg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628").getMessage(), de);
		}
	}
	
	/**
	 * 비교 데이터 생성위한 maxseq 를 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMaxUmchBkgSeq(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException {
		String usrId = account.getUsr_id(); // 배치도확인
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
	 * 비교할 Unmatch 데이터를 모두 생성한다.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param List<UnmatchBLVO> unmatchList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addCompareBkgRevUmchAll(UnmatchBLVO pVo, List<UnmatchBLVO> unmatchList, SignOnUserAccount account) throws EventException{
		String usrId = account.getUsr_id(); // 배치도확인
		int unmatchListLen = 0;
		String umchTpCd;
		String mtchUmchTpCd;
		String umchItmSeq;
		UnmatchBLVO lVo = null;
		try {
			
			pVo.setCreUsrId(usrId);
			dbDao.addCompareBkgRevUmchBkg(pVo); // bkg 생성
			
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
					dbDao.addCompareBkgRevUmchItmDtl(lVo); // itm dtl 생성
				}else{
					lVo = new UnmatchBLVO();
					lVo = unmatchList.get(i);
					lVo.setBkgNo(pVo.getBkgNo());
					lVo.setMaxUmchBkgSeq(pVo.getMaxUmchBkgSeq());
					lVo.setCreUsrId(usrId);				
					dbDao.addCompareBkgRevUmchItm(lVo); // itm 생성
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
	 * BKG_REV_UMCH_BKG 상태를 비교 조회한다. <br>
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
	 * BKG_REV_UMCH_ITM 상태를 비교 조회한다. <br>
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
	 * BKG_REV_UMCH_ITM_DTL 상태를 비교 조회한다. <br>
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
	 * 비교 Unmatch 데이터를 모두 삭제한다.<br>
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
	 * BKG_REV_UMCH_BKG 테이블의 LST_UMCH_FND_DT 를 갱신한다.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCompareBkgRevUmchBkgFndDt(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException{
		try {
			pVo.setUpdUsrId(account.getUsr_id()); // 배치도확인
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
	 * RFA, TAA 심사 에서 OFT 와 SURCHARGE Autorating 을 Call 할때 필요한 rtAplyDt 를 YYYYMMDD 형식으로 조회한다. <br>
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
	 * RDN 자동 발행 대상을 조회
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
	 * Self Audit 리스트 조회
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
	 * Audit by CNTR Qty Discrepancy 리스트 정보를 CNTR별로 조회한다. <br>
     *
	 * @param EqSubErrSchVO eqSubErrSchVO
	 * @return List<EqSubErrSchVO>
	 * @exception EventException
	 */
	public List<EqSubErrSchVO> searchAuditByEqSubErrList(EqSubErrSchVO eqSubErrSchVO) throws EventException {
		try{
			return dbDao.searchAuditByEqSubErrList(eqSubErrSchVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * EQ. Sub. Inquiry 리스트의 변경 사항을 저장한다. <br>
	 * @param EqSubErrSchVO[] eqSubErrSchVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public  void  manageAuditByEqSubErrList(EqSubErrSchVO[] eqSubErrSchVOs, SignOnUserAccount account) throws EventException {
		try {
			int updInt = 0;
			
			for ( int i=0; i<eqSubErrSchVOs.length; i++ ) {
				
					updInt = dbDao.modifyAuditRmkByEqSubErrList(eqSubErrSchVOs[i], account);
					
					// 수정 건수가 0일 경우 Insert
					if(updInt == 0){
						dbDao.addAuditRmkByEqSubErrList(eqSubErrSchVOs[i], account);
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
	 * COD BKG Inquiry 리스트를 조회한다. <br>
	 * 
	 * @param CODBookingListInVO vo
	 * @return List<CODBookingListOutVO>
	 * @exception EventException
	 */	
	public List<CODBookingListOutVO> searchCODBookingList(CODBookingListInVO vo) throws EventException {
		try {
			return dbDao.searchCODBookingList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * Merchant Request에 의한 Diversion C/A 목록을 조회한다 <br>
	 * 
	 * @param DiversionCAVO vo
	 * @return List<DiversionCAVO>
	 * @exception EventException
	 */	
	public List<DiversionCAVO> searchDiversionCAList(DiversionCAVO vo) throws EventException {
		try {
			return dbDao.searchDiversionCAList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * COD BKG Inquiry 리마크를 관리한다. <br>
	 * @param CODBookingListOutVO[] vos
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */	
	
	public void manageCodBookingList(CODBookingListOutVO[] vos, SignOnUserAccount account) throws EventException{
		try {
			String rtn= "";
			
			for ( int i=0; i<vos.length; i++ ) {
				
				rtn = dbDao.searchByCodBookingList(vos[i]);
				
				if(!"0".equals(rtn) && rtn.length() > 0){
					dbDao.modifyCodBookingList(vos[i], account);
					
				}else{
					dbDao.createCodBookingList(vos[i], account);
				
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
	
	
	/**
	 * ESM_BKG_0256 : reaudit click <br>
	 * 선택한 BL들에 대한 re-audit을 수행한다.<br>
	 * 
	 * @param String[] bkgNoArr
	 * @param String settleKindCode;
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String settleUnmatchBL(String[] bkgNoArr, String settleKindCode, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = null;
		ManualSettleBackEndJob backEndJob = null;
		String jobID = null;
		try {
			backEndJobManager = new BackEndJobManager();
			backEndJob = new ManualSettleBackEndJob(bkgNoArr, settleKindCode, account);
			jobID = backEndJobManager.execute(backEndJob, account.getUsr_id(), "ManualSettleBackEndJob");
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return jobID;
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
	 * 심사를 위한 AK BKG 리스트를 조회한다. <br>
	 * 
	 * @param AwkwardBKGListForAuditVO vo
	 * @return List<AwkwardBKGListForAuditVO>
	 * @exception EventException
	 */	
	public List<AwkwardBKGListForAuditVO> searchAwkwardBKGListforAudit(AwkwardBKGListForAuditVO vo) throws EventException {
		try {
			return dbDao.searchAwkwardBKGListforAudit(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * AK Application vs Bay Plan Discrepancy 조회 <br>
	 * 
	 * @param BKGvsBayPlanVO vo
	 * @return List<BKGvsBayPlanVO>
	 * @exception EventException
	 */	
	public List<BKGvsBayPlanVO> searchAwkwardBKGvsBayPlanList(BKGvsBayPlanVO vo) throws EventException {
		try {
			return dbDao.searchAwkwardBKGvsBayPlanList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * 심사를 위한 IHC BKG 리스트를 조회한다. <br>
	 * 
	 * @param IhcBKGListForAuditVO vo
	 * @return List<IhcBKGListForAuditVO>
	 * @exception EventException
	 */	
	public List<IhcBKGListForAuditVO> searchIhcBKGListforAudit(IhcBKGListForAuditVO vo) throws EventException {
		try {
			return dbDao.searchIhcBKGListforAudit(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * 소급적용 BKG 리스트를 조회한다. <br>
	 * 
	 * @param RetroActFilterSchVO vo
	 * @return List<RsltSearchRetroActFilterVO>
	 * @exception EventException
	 */	
	public List<RsltSearchRetroActFilterVO> searchRetroactBLFilterList(RetroActFilterSchVO vo) throws EventException {
		try {
			return dbDao.searchRetroactBLFilterList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * TXS BKG List for Audit 리스트를 조회한다. <br>
	 * 
	 * @param TxsBkgListForAuditSchVO vo
	 * @return List<TxsBkgListForAuditVO>
	 * @exception EventException
	 */	
	public List<TxsBkgListForAuditVO> searchTxsBkgListForAudit(TxsBkgListForAuditSchVO vo) throws EventException {
		try {
			return dbDao.searchTxsBkgListForAudit(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
     * Stop Off BKG List for Audit 정보를 조회한다.<br>
     *
     * @param String fmDt
     * @param String toDt
     * @return List<SearchStopOffBkgListforAuditVO>
     * @exception EventException
     */
    public List<SearchStopOffBkgListforAuditVO> searchStopOffBkgListforAudit(String fmDt, String toDt) throws EventException {
    	try {
			return dbDao.searchStopOffBkgListforAudit(fmDt,toDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
    }
	
	/**
	 * 심사를 위해 특정 Rule Type (Conversion Table상 Code)을 포함하는 Contract Note를 조회 <br>
	 * 
	 * @param ScNoteConversionVO vo
	 * @return List<ScNoteConversionVO>
	 * @exception EventException
	 */	
	public List<ScNoteConversionVO> searchCtrtNoteConversionListByRule(ScNoteConversionVO vo) throws EventException {
		List<ScNoteConversionVO> scNoteConversionVOs = new ArrayList<ScNoteConversionVO>();
		try {
			if("S".equals(vo.getBkgCtrtTpCd())){
				scNoteConversionVOs = dbDao.searchScNoteConversionListByRule(vo);
			}else{
				scNoteConversionVOs = dbDao.searchRfaNoteConversionListByRule(vo);
			}
			return scNoteConversionVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	/**
	 * BKG별 Bay Plan을 조회한다 <br>
	 * 
	 * @param String bkgNo
	 * @return List<BayPlanVO>
	 * @exception EventException
	 */	
	public List<BayPlanVO> searchBayPlanByBooking(String bkgNo) throws EventException {
		try {
			return dbDao.searchBayPlanByBooking(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}

	
	/**
	 * OFT성 운임 총합을 비교 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @exception EventException
	 */
	public String checkTotalBlAmount(String bkgNo, String caFlg) throws EventException {
		try {
			return dbDao.checkTotalBlAmount(bkgNo, caFlg);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	
	/**
	 * 심사를 위한 O B/L Surrencer 목록을 조회한다. <br>
	 * 
	 * @param OblSurrenderForAuditVO vo
	 * @return List<OblSurrenderForAuditVO>
	 * @exception EventException
	 */	
	public List<OblSurrenderForAuditVO> searchOblSurrenderForAudit(OblSurrenderForAuditVO vo) throws EventException {
		try {
			return dbDao.searchOblSurrenderForAudit(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	
	/**
	 * 심사를 위한 Non Autorated Charge 목록을 조회한다. <br>
	 * 
	 * @param NonAutoratedChargeVO vo
	 * @return List<NonAutoratedChargeVO>
	 * @exception EventException
	 */	
	public List<NonAutoratedChargeVO> searchNonAutoratedChargeForAudit(NonAutoratedChargeVO vo) throws EventException {
		try {
			return dbDao.searchNonAutoratedChargeForAudit(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	
	/**
	 * Wsc BKG List for Audit 리스트를 조회한다. <br>
	 * 
	 * @param WscBkgListForAuditSchVO vo
	 * @return List<WscBkgListForAuditSchVO>
	 * @exception EventException
	 */	
	public List<WscBkgListForAuditSchVO> searchWscBkgListForAudit(WscBkgListForAuditSchVO vo) throws EventException {
		try {
			return dbDao.searchWscBkgListForAudit(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	/**
	 * India DTH BKG 리스트를 조회한다. <br>
	 * 
	 * @param IndiaDthBKGListForAuditVO vo
	 * @return List<IndiaDthBKGListForAuditVO>
	 * @exception EventException
	 */	
	public List<IndiaDthBKGListForAuditVO> searchIndiaDthBKGListforAudit(IndiaDthBKGListForAuditVO vo) throws EventException {
		try {
			return dbDao.searchIndiaDthBKGListforAudit(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	
	/**
	 * Iran DTH BKG 리스트를 조회한다. <br>
	 * 
	 * @param IranDthBKGListForAuditVO vo
	 * @return List<IranDthBKGListForAuditVO>
	 * @exception EventException
	 */	
	public List<IranDthBKGListForAuditVO> searchIranDthBKGListforAudit(IranDthBKGListForAuditVO vo) throws EventException {
		try {
			return dbDao.searchIranDthBKGListforAudit(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
	
    /**
     * unmatch bl age 리스트를 조회한다.
     * @param UmchErrBlReportVO vo
     * @return List<UmchErrBlReportVO>
     * @throws EventException
     */
    public List<UmchErrBlReportVO> searchUnmatchBLAgingList(UmchErrBlReportVO vo) throws EventException {
		try {
			return dbDao.searchUnmatchBLAgingList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
	
    
    /**
     * rating시 OFT가 2개 이상 뜨는 건에 대해 조회한다.
     * @param MultiRateBkgListVO vo
     * @return List<MultiRateBkgListVO>
     * @throws EventException
     */
    public List<MultiRateBkgListVO> searchMultiRateBkgList(MultiRateBkgListVO vo) throws EventException {
		try {
			return dbDao.searchMultiRateBkgList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
    
    
    /**
     * Multi Rate BKG List for Audit(1) 조회
     * @param MultiRateBkgList1VO vo
     * @return List<MultiRateBkgList1VO>
     * @throws EventException
     */
    public List<MultiRateBkgList1VO> searchMultiRateBkgList_1(MultiRateBkgList1VO vo) throws EventException {
		try {
			return dbDao.searchMultiRateBkgList_1(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), ex);
		}
	}
    
    /**
     * Multi Rate BKG List for Audit(1) 수정(Save 버튼)
     * @param multiRateBkgList1VOs
     * @param account
     * @throws EventException
     */
    public void manageMultiRateBkgList_1(MultiRateBkgList1VO[] multiRateBkgList1VOs, SignOnUserAccount account) throws EventException {
    	try {
    		List<MultiRateBkgList1VO> updateVoList = new ArrayList<MultiRateBkgList1VO>();
    		for (int i = 0; i < multiRateBkgList1VOs.length; i++) {
    			if (multiRateBkgList1VOs[i].getIbflag().equals("U")) {
    				multiRateBkgList1VOs[i].setUpdUsrId(account.getUsr_id());
    				updateVoList.add(multiRateBkgList1VOs[i]);
    			}
    		}
    		
    		if ( updateVoList.size() > 0 ) {
    			dbDao.manageMultiRateBkgList_1(updateVoList);
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
     * Multi Rate BKG List for Audit(1) 확인(Confirm 버튼)
     * @param multiRateBkgList1VOs
     * @param account
     * @throws EventException
     */
    public void confirmMultiRateBkgList_1(MultiRateBkgList1VO[] multiRateBkgList1VOs, SignOnUserAccount account) throws EventException {
    	try {
    		List<MultiRateBkgList1VO> updateVoList = new ArrayList<MultiRateBkgList1VO>();
    		for (int i = 0; i < multiRateBkgList1VOs.length; i++) {
    			if (multiRateBkgList1VOs[i].getIbflag().equals("U")) {
    				multiRateBkgList1VOs[i].setUpdUsrId(account.getUsr_id());
    				updateVoList.add(multiRateBkgList1VOs[i]);
    			}
    		}
    		
    		if ( updateVoList.size() > 0 ) {
    			dbDao.confirmMultiRateBkgList_1(updateVoList);
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
     * Multi Rate BKG List for Audit(1) 확인 취소(Release 버튼)
     * @param multiRateBkgList1VOs
     * @param account
     * @throws EventException
     */
    public void releaseMultiRateBkgList_1(MultiRateBkgList1VO[] multiRateBkgList1VOs, SignOnUserAccount account) throws EventException {
    	try {
    		List<MultiRateBkgList1VO> updateVoList = new ArrayList<MultiRateBkgList1VO>();
    		for (int i = 0; i < multiRateBkgList1VOs.length; i++) {
    			if (multiRateBkgList1VOs[i].getIbflag().equals("U")) {
    				multiRateBkgList1VOs[i].setUpdUsrId(account.getUsr_id());
    				updateVoList.add(multiRateBkgList1VOs[i]);
    			}
    		}
    		
    		if ( updateVoList.size() > 0 ) {
    			dbDao.releaseMultiRateBkgList_1(updateVoList);
    		}
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00244").getMessage(), de);
		}
    } 
}
