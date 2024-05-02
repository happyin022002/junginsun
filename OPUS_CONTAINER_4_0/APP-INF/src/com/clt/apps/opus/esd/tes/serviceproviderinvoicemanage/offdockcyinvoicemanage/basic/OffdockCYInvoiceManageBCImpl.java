/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OffdockCYInvoiceManageBCImpl.java
 *@FileTitle : Off-dock CY Invoice 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.basic.FinCommonBC;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.basic.FinCommonBCImpl;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.esd.tes.common.tescommon.util.TESUtil;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration.MarineTerminalInvoiceManageDBDAO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9142Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0004Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0018Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9030Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9050Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9074Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9075Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9140Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9233Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9240Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9253Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration.OffdockCYInvoiceManageDBDAO;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TesFileImpTmpVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;

/**
 * ESD Business Logic Basic Command implementation<br> - ESD business logic handling.<br>
 * 
 * @author byungheeyoo
 * @see ESD_TES_004EventResponse,OffdockCYInvoiceManageBC each DAO class reference
 * @since J2EE 1.4
 */
public class OffdockCYInvoiceManageBCImpl extends BasicCommandSupport implements OffdockCYInvoiceManageBC {

	private transient OffdockCYInvoiceManageDBDAO dbDao = null;
	private transient MarineTerminalInvoiceManageDBDAO dbDao2=null;  

	/**
	 * OffdockCYInvoiceManageBCImpl object creation<br>
	 * OffdockCYInvoiceManageDBDAO creation<br>
	 */
	public OffdockCYInvoiceManageBCImpl() {
		dbDao = new OffdockCYInvoiceManageDBDAO();
		dbDao2 = new MarineTerminalInvoiceManageDBDAO();
	}

	/**
	 * Cost Calc. Calculation
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse calOffdockCYInvoiceCost(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		String tml_cost_grp_cd = "";
		String tml_calc_ind_cd = "";
		String agmtCostYN = "";

		try {
			tml_cost_grp_cd = event.getOffdockCYInvoiceManageVO().getTmlCostGrpCd();
			tml_calc_ind_cd = event.getOffdockCYInvoiceManageVO().getTmlCalcIndCd();

			log.debug("at calOffdockCYInvoiceCost [tml_cost_grp_cd "+tml_cost_grp_cd+"], [tml_calc_ind_cd "+tml_calc_ind_cd+"]");
			
			if (tml_cost_grp_cd != null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length() == 2) {
				agmtCostYN = dbDao2.searchTerminalInvoiceAgmtCost(event.getTesTmlSoHdrVO());
				
				if (tml_cost_grp_cd.substring(0, 1).equals("T")) {
					if (tml_calc_ind_cd != null && tml_calc_ind_cd.equals("TP")) {
						dbDao.calOffdockCYInvoiceCostTMNLUpdate( event.getTesTmlSoHdrVO() );
						rsList.add( dbDao.calOffdockCYInvoiceCostTMNL(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO(), agmtCostYN));
						
					} else if (tml_calc_ind_cd != null && (tml_calc_ind_cd.equals("SP") || tml_calc_ind_cd.equals("GP"))) {
						dbDao.calOffdockCYInvoiceCostTMNLUpdate( event.getTesTmlSoHdrVO() );
						rsList.add( dbDao.calOffdockCYInvoiceCostTMNLseparate(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO(), agmtCostYN) );
						
					} else {
						rsList.add( new DBRowSet() );
					}
				}
				else {
					rsList.add( new DBRowSet() );
				}
				
				if (tml_cost_grp_cd.substring(1, 2).equals("D")) {
					rsList.add( dbDao.calOffdockCYInvoiceCostByDay(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO(), agmtCostYN) );
				}
				else {
					rsList.add( new DBRowSet() );
				}
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );
				
				return eventResponse;
				
			} else {
				return null;
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Container List Import File Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		
		int ins_idx = 0;	
		String strTmlSoOfcCtyCd = "";
		String strTmlSoSeq = "";
		String strVndrSeq = "";
		String strYdCd = "";
		String strRcvDt = "";
		String strFmPrdDt = "";
		String strToPrdDt = "";
		String strCreUsrId = "";
		String strUpdUsrId = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesFileImpTmpVO[] tesFileImpTmpVOs = null;		
		List<TesFileImpTmpVO> insertVOList = new ArrayList<TesFileImpTmpVO>();
		
		try {		
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesFileImpTmpVOs = event.getTesFileImpTmpVOs();
			
			strTmlSoOfcCtyCd= tesTmlSoHdrVO.getTmlSoOfcCtyCd();
			strTmlSoSeq     = tesTmlSoHdrVO.getTmlSoSeq();
			strVndrSeq      = tesTmlSoHdrVO.getVndrSeq();
			strYdCd         = tesTmlSoHdrVO.getYdCd();
			strRcvDt		= JSPUtil.replace( tesTmlSoHdrVO.getRcvDt(), "-", "" );
			strFmPrdDt      = JSPUtil.replace( event.getTesTmlSoHdrVO().getFmPrdDt(), "-", "" );
			strToPrdDt      = JSPUtil.replace( event.getTesTmlSoHdrVO().getToPrdDt(), "-", "" );
			strCreUsrId     = event.getSignOnUserAccount().getUsr_id();
			strUpdUsrId     = event.getSignOnUserAccount().getUsr_id();	
			
			for( int i=0; tesFileImpTmpVOs!=null && i<tesFileImpTmpVOs.length; i++){
				
				if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_FILE_IMP_TMP", "TML_SO_TMP_SEQ");
				
				tesFileImpTmpVOs[i].setTmlSoOfcCtyCd(strTmlSoOfcCtyCd);
				tesFileImpTmpVOs[i].setTmlSoSeq(strTmlSoSeq);
				tesFileImpTmpVOs[i].setTmlSoTmpSeq((String.valueOf(++ins_idx)));
				tesFileImpTmpVOs[i].setVndrSeq(strVndrSeq);
				tesFileImpTmpVOs[i].setYdCd(strYdCd);
				tesFileImpTmpVOs[i].setRcvDt(strRcvDt);
				tesFileImpTmpVOs[i].setFmPrdDt(strFmPrdDt);
				tesFileImpTmpVOs[i].setToPrdDt(strToPrdDt);
				tesFileImpTmpVOs[i].setCreUsrId(strCreUsrId);
				tesFileImpTmpVOs[i].setUpdUsrId(strUpdUsrId);
				
				insertVOList.add(tesFileImpTmpVOs[i]);
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.createTES_FILE_IMP_TMP(insertVOList);
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * OffDock CY Invoice Container List Import File Delete.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;

		try {
			dbDao.removeTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * insertOffdockCYInvoiceContainerList Including information
	 * OffDock CY Invoice Container List Verify
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyOffdockCYInvoiceVolume(Event e) throws EventException {
		log.debug("\n\n BC.verifyOffdockCYInvoiceVolume++++++++++++++++++++\n");

		EsdTes9140Event event = (EsdTes9140Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			if("GP".equals(event.getTesTmlSoHdrVO().getTmlCalcIndCd())){
				eventResponse.setRs( dbDao.verifyOffdockCYInvoiceForGates(event.getTesTmlSoHdrVO(), event.getTesCommonVO()) );
			}else{
				eventResponse.setRs( dbDao.verifyOffdockCYInvoiceVolume(event.getTesTmlSoHdrVO(), event.getTesCommonVO()) );
			}
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}		
	}

	/**
	 * OffDock CY Invoice Container List Verify Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public int insertOffdockCYInvoiceContainerList(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		DBRowSet rowSet = null;
		int insCnt = 0;
		
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		List<TesTmlSoCntrListVO> voList = new ArrayList<TesTmlSoCntrListVO>();
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		String strTmlSoOfcCtyCd = "";
		String strTmlSoSeq = "";	
		String strUsrId = "";
		String strOfcCd = "";
		int ins_idx = 0;
		try {
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			
			strTmlSoOfcCtyCd = tesTmlSoHdrVO.getTmlSoOfcCtyCd(); 
			strTmlSoSeq = tesTmlSoHdrVO.getTmlSoSeq();
			strUsrId = event.getSignOnUserAccount().getUsr_id();
			strOfcCd = event.getSignOnUserAccount().getOfc_cd();
			
			rowSet = event.getRowSet();
			
			if (rowSet != null){
				if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
				while (rowSet.next()) {	
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(strTmlSoOfcCtyCd);
					tesTmlSoCntrListVO.setTmlSoSeq(strTmlSoSeq); 
					tesTmlSoCntrListVO.setTmlSoCntrListSeq(String.valueOf(++ins_idx));
					tesTmlSoCntrListVO.setVrfyRsltIndCd( rowSet.getString("VRFY_RSLT_IND_CD") );
					tesTmlSoCntrListVO.setDscrIndCd( rowSet.getString("DSCR_IND_CD") );
					tesTmlSoCntrListVO.setVslCd( rowSet.getString("VSL_CD") );
					tesTmlSoCntrListVO.setSkdVoyNo( rowSet.getString("SKD_VOY_NO") );
					tesTmlSoCntrListVO.setSkdDirCd( rowSet.getString("SKD_DIR_CD") );
					tesTmlSoCntrListVO.setIoBndCd( rowSet.getString("IO_BND_CD") );
					tesTmlSoCntrListVO.setCntrNo( rowSet.getString("CNTR_NO") );
					tesTmlSoCntrListVO.setCntrTpszCd( rowSet.getString("CNTR_TPSZ_CD") );
					tesTmlSoCntrListVO.setCntrStyCd( rowSet.getString("CNTR_STY_CD") );
					tesTmlSoCntrListVO.setLoclTsIndCd( rowSet.getString("LOCL_TS_IND_CD") );
					tesTmlSoCntrListVO.setMvmtGateInDt( rowSet.getString("MVMT_GATE_IN_DT") );
					tesTmlSoCntrListVO.setInvGateInDt( rowSet.getString("INV_GATE_IN_DT") );
					tesTmlSoCntrListVO.setGateInTdDys( rowSet.getString("GATE_IN_TD_DYS") );
					tesTmlSoCntrListVO.setMvmtGateOutDt( rowSet.getString("MVMT_GATE_OUT_DT") );
					tesTmlSoCntrListVO.setInvGateOutDt( rowSet.getString("INV_GATE_OUT_DT") );
					tesTmlSoCntrListVO.setGateOutTdDys( rowSet.getString("GATE_OUT_TD_DYS") );
					tesTmlSoCntrListVO.setMvmtStayDys( rowSet.getString("MVMT_STAY_DYS") );
					tesTmlSoCntrListVO.setInvStayDys( rowSet.getString("INV_STAY_DYS") );
					tesTmlSoCntrListVO.setStayDiffDys( rowSet.getString("STAY_DIFF_DYS") );
					tesTmlSoCntrListVO.setDcgoClssCd( rowSet.getString("DCGO_CLSS_CD") );
					tesTmlSoCntrListVO.setBbCgoFlg( rowSet.getString("BB_CGO_FLG") );
					tesTmlSoCntrListVO.setBkgNo( rowSet.getString("BKG_NO") );
					tesTmlSoCntrListVO.setBlNo( rowSet.getString("BL_NO") );
					tesTmlSoCntrListVO.setAwkCgoFlg( rowSet.getString("AWK_CGO_FLG") );
					tesTmlSoCntrListVO.setRcFlg( rowSet.getString("RC_FLG") );
					tesTmlSoCntrListVO.setCntrRmk( rowSet.getString("CNTR_RMK") );
					tesTmlSoCntrListVO.setCreUsrId(strUsrId);
					tesTmlSoCntrListVO.setUpdUsrId(strUsrId);
					tesTmlSoCntrListVO.setLoclCreDt(strOfcCd);
					tesTmlSoCntrListVO.setLoclUpdDt(strOfcCd);
					tesTmlSoCntrListVO.setTmlTrnsModCd(rowSet.getString("TML_TRNS_MOD_CD") );
					
					voList.add(tesTmlSoCntrListVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				dbDao.removeOffdockCYInvoiceContainerList(tesTmlSoHdrVO);
				insCnt = dbDao.insertOffdockCYInvoiceContainerList(voList);
			}	
			return insCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		}	
	}

	/**
	 * OffDock CY Invoice Container Number Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException {

		EsdTes9140Event event = (EsdTes9140Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		

		try {
			eventResponse.setRs( dbDao.searchCNTRNumber(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * OffDock CY Invoice Container Number Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		DBRowSet rowSet = null;
		TesFileImpTmpVO tesFileImpTmpVO = null;
		List<TesFileImpTmpVO> voList = new ArrayList<TesFileImpTmpVO>();

		try {
			rowSet = dbDao.searchCNTRNumber(event.getTesTmlSoHdrVO());
			
			if (rowSet != null){
				while (rowSet.next()) {
					tesFileImpTmpVO = new TesFileImpTmpVO();
					tesFileImpTmpVO.setCntrNo( JSPUtil.getNull( rowSet.getString("CNTR_NO") ) );
					tesFileImpTmpVO.setTmlSoOfcCtyCd( JSPUtil.getNull( rowSet.getString("TML_SO_OFC_CTY_CD") ) );
					tesFileImpTmpVO.setTmlSoSeq( JSPUtil.getNull( rowSet.getString("TML_SO_SEQ") ) );
					tesFileImpTmpVO.setTmlSoTmpSeq( JSPUtil.getNull( rowSet.getString("TML_SO_TMP_SEQ") ) );	
					voList.add(tesFileImpTmpVO);
				}
			}
			if ( voList.size() > 0 ) {
				dbDao.updateCNTRNumber( voList );
			}			 
			return null;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		}		
	}

	/**
	 * OffDock CY Invoice Container List Import File Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRs( dbDao.searchTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock Invoice Detail Search
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceDetail(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String tml_cost_grp_cd = "";	
		String dtl_by_pool_only_mode = "";	
		String dtl_by_eq_only_mode = "";	
		
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 		
		try {
			tml_cost_grp_cd = (String) event.getOffdockCYInvoiceManageVO().getTmlCostGrpCd();
			dtl_by_pool_only_mode = (String) event.getOffdockCYInvoiceManageVO().getDtlByPoolOnlyMode();
			dtl_by_eq_only_mode = (String) event.getOffdockCYInvoiceManageVO().getDtlByEqOnlyMode();
			
			log.debug("########   tml_cost_grp_cd : "+tml_cost_grp_cd+", dtl_by_pool_only_mode : "+dtl_by_pool_only_mode);
			if (tml_cost_grp_cd != null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length() == 2) {
				if (dtl_by_pool_only_mode != null && dtl_by_pool_only_mode.equals("Y")) {
					rsList.add( dbDao.searchCalcCostByPoolList(event.getTesTmlSoHdrVO()) );
				} else if(dtl_by_eq_only_mode != null && dtl_by_eq_only_mode.equals("Y")){
					rsList.add( dbDao.searchCalcCostByEQList(event.getTesTmlSoHdrVO()) );
				}else {
					if (tml_cost_grp_cd.substring(0, 1).equals("T")) {
						rsList.add( dbDao.searchCalcCostTMNLList(event.getTesTmlSoHdrVO()) );
					}
					else rsList.add(null);
					
					if (tml_cost_grp_cd.substring(1, 2).equals("D")) {
						rsList.add( dbDao.searchCalcCostByDayList(event.getTesTmlSoHdrVO()) );
					}
					else rsList.add(null);
					
					rsList.add( dbDao.searchCalcCostByPoolList(event.getTesTmlSoHdrVO()) );
					rsList.add( dbDao.searchCalcCostByEQList(event.getTesTmlSoHdrVO()) );
					
				}
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );
				
				return eventResponse;

			} else {
				return null;
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice All Data Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceAllSheets(Event e) throws EventException {

		log.debug("\n\n BC.searchOffdockCYInvoiceAllSheets() - @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String tml_cost_grp_cd = "";	
		
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		try {

			tml_cost_grp_cd = (String)event.getOffdockCYInvoiceManageVO().getTmlCostGrpCd();
			log.debug("\n - tml_cost_grp_cd:" + tml_cost_grp_cd + " -------\n");

			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "CO"));
			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "DC"));
					
			if (tml_cost_grp_cd != null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length() == 2) {
				if (tml_cost_grp_cd.substring(0, 1).equals("T")) {
					rsList.add(dbDao.searchCalcCostTMNLList(event.getTesTmlSoHdrVO()));
				}
				else {
					rsList.add( new DBRowSet());
				}

				if (tml_cost_grp_cd.substring(1, 2).equals("D")) {
					rsList.add(dbDao.searchCalcCostByDayList(event.getTesTmlSoHdrVO()));
				}
				else {
					rsList.add( new DBRowSet());
				}
				
				rsList.add(dbDao.searchCalcCostByPoolList(event.getTesTmlSoHdrVO()));				
				
				rsList.add(dbDao.searchCalcCostByEQList(event.getTesTmlSoHdrVO()));	
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );
				
				return eventResponse;
			} else {
				return null;
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}			
	}

	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolume(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String calc_tp_cd = "";

		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug("at BC.searchRevisedVolume >> calc_tp_cd >> "+calc_tp_cd);
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {
				eventResponse.setRs( dbDao.searchRevisedVolume(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			} else if (calc_tp_cd != null && calc_tp_cd.equals("M")) {
				eventResponse.setRs( dbDao.searchRevisedVolumeManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			}
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolumeSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String calc_tp_cd = "";

		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {
				eventResponse.setRs( dbDao.searchRevisedVolumeSeparate(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			} else if (calc_tp_cd != null && (calc_tp_cd.equals("M") || calc_tp_cd.equals("S"))) {
				eventResponse.setRs( dbDao.searchRevisedVolumeSeparateManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			}
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolume2(Event e) throws EventException {
		
		EsdTes9074Event event = (EsdTes9074Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String calc_tp_cd = "";
		
		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug(">>>>>>>>>>>>> BCImpl [calc_tp_cd - "+calc_tp_cd+"]");
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {			
				eventResponse.setRs( dbDao.searchRevisedVolume(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()));
			} else if (calc_tp_cd != null && calc_tp_cd.equals("M")) {
				eventResponse.setRs( dbDao.searchRevisedVolumeManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()));
			}
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolumeSeparate2(Event e) throws EventException {
		
		EsdTes9075Event event = (EsdTes9075Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String calc_tp_cd = "";
		
		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug(">>>>>>>>>>>>> BCImpl [calc_tp_cd - "+calc_tp_cd+"] fm prd dt : "+event.getOffdockCYInvoiceManageVO().getFmPrdDt());
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {			
				eventResponse.setRs( dbDao.searchRevisedVolumeSeparate(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()));
			} else if (calc_tp_cd != null && calc_tp_cd.equals("M")) {
				eventResponse.setRs( dbDao.searchRevisedVolumeSeparateManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()));
			}
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * OffDock CY Invoice 수동시 revise mode TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYReviseMode(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYReviseModeSeparate(event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice manually revise mode Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYReviseModeSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYReviseModeSeparate(event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(N) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchOffdockCYRvisCntrListCdN(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
//			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdN() );
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * OffDock CY Invoice revise mode(N) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchOffdockCYRvisCntrListCdNSeparate(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
//			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdN() );
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * OffDock CY Invoice revise mode(MT) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdMT(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {			
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdMT(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(MT) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdMTSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdMT(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(DG) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdDG(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdDG(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(DG) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdDGSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdDG(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(RF) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdRF(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdRF(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
	}

	/**
	 * OffDock CY Invoice revise mode(RF) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdRFSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {			
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdRF(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(AK) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdAK(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdAK(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(AK) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdAKSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdAK(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice 3rd party List TMNL Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlistOnly(Event e) throws EventException {
		EsdTes9253Event event = (EsdTes9253Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		

		try {
			eventResponse.setRs( dbDao.searchOffdock3rdIFlistOnly(event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice 3rd party List TMNL Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlist(Event e) throws EventException {
		EsdTes9233Event event = (EsdTes9233Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		DBRowSet rowSet = null;
		String calc_tp_cd = null;

		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug("\nBC.calc_tp_cd:" + calc_tp_cd + "\n");
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {
				rowSet = dbDao.searchOffdock3rdIFlist(event.getOffdockCYInvoiceManageVO());
			} else if (calc_tp_cd != null && (calc_tp_cd.equals("M") || calc_tp_cd.equals("S"))) {
				rowSet = dbDao.searchOffdock3rdIFlistManual(event.getOffdockCYInvoiceManageVO());
			}
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice 3rd party List ByDay Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlistByDay(Event e) throws EventException {
		EsdTes9233Event event = (EsdTes9233Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		DBRowSet rowSet = null;
		String calc_tp_cd = null;
		OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = event.getOffdockCYInvoiceManageVO(); 
		
		try {
			
			calc_tp_cd = JSPUtil.getNull( offdockCYInvoiceManageVO.getCalcTpCd() );
			log.debug("\nBC.calc_tp_cd:" + calc_tp_cd + "\n");
			
			if (calc_tp_cd != null && "A".equals(calc_tp_cd)) {
				rowSet = dbDao.searchOffdock3rdIFlistByDay(offdockCYInvoiceManageVO);
			} else if (calc_tp_cd != null && ("M".equals(calc_tp_cd) || "S".equals(calc_tp_cd))) {
				rowSet = dbDao.searchOffdock3rdIFlistByDayManual(offdockCYInvoiceManageVO);
			}
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * OffDock CY Invoice Total Amount Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYTotalAmount(Event e) throws EventException {
		EsdTes9050Event event = (EsdTes9050Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYTotalAmount(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * OffDock CY Container List Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYContainerList(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		try {
			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "CO"));
			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "DC"));

			eventResponse.setRsList(rsList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * off-dock invoice header Search
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceBasicInfo(Event e) throws EventException {
		log.debug("at BC.searchOffdockCYInvoiceBasicInfo");
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		

		try {
			eventResponse.setRs( dbDao.searchOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * OffDock CY Invoice Reject Info Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceRejectInfo(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	

		try {
			eventResponse.setRs( dbDao.searchOffdockCYInvoiceRejectInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * confirm Info Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOffdockCYInvoiceConfirm(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		String chkAmt = "";

		try {
			TESInvoiceCommonBC	invCom	= new TESInvoiceCommonBCImpl();
			
			chkAmt = dbDao.checkSOInvAmt(event.getTesTmlSoHdrVO());
			log.error("\n DONE - modifyStorageInvoiceConfirm.checkInvAmt:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			if (chkAmt == null || (chkAmt != null && !chkAmt.equals("Y"))) {
//				throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
				throw new DAOException(new ErrorHandler("TES00088").getMessage());
			}
			
			// 1. SO_DTL N3PTY_FLG check 
			invCom.checkDetailTpb(event.getTesTmlSoHdrVO());
			
			// 2. check result update
			dbDao.modifyOffdockCYInvoiceConfirm(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * confirm Cancel
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelOffdockCYInvoiceConfirm(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		// String return_flag = "N";
		// DBRowSet rowSetList = null;

		try {
			dbDao.cancelOffdockCYInvoiceConfirm(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Reject Cancel.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelOffdockCYInvoiceReject(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.cancelOffdockCYInvoiceReject(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/** multiOffDockTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiOffDockTerminalInvoiceDBVerify(Event e) throws EventException{
		EsdTes0004Event event = (EsdTes0004Event)e;
		DBRowSet dbRowSet					=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		TesTmlSoCntrListVO  tesTmlSoCntrListVO = null;
		
		if(log.isDebugEnabled())log.debug("\n==========OffdockCYInvoiceManageBCImpl    multiOffDockTerminalInvoiceDBVerify() ============");

		try {
			String costCdFtrRmk = new TESInvoiceCommonBCImpl().selectCostCdFtrRmk(event.getTesTmlSoHdrVO());
			event.getTesTmlSoHdrVO().setCostCdFtrRmk(costCdFtrRmk);
			
			dbRowSet = dbDao2.dBCheckTerminalInvoice(event.getTesTmlSoHdrVO(), event.getTesTmlSoCntrListVO(), event.getTesCommonVO());
			
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			if(dbRowSet!=null && dbRowSet.getRowCount()>0){
				
				while (dbRowSet.next()) {
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
					
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(event.getTesTmlSoCntrListVO().getTmlSoOfcCtyCd());
					tesTmlSoCntrListVO.setTmlSoSeq(event.getTesTmlSoCntrListVO().getTmlSoSeq());
					tesTmlSoCntrListVO.setCntrNo(dbRowSet.getString("cntr_no"));
					
					tesTmlSoCntrListVO.setVrfyRsltIndCd("DC") ;	
					tesTmlSoCntrListVO.setDscrIndCd("DB");		
					tesTmlSoCntrListVO.setCntrRmk("Double billing Inv : " + dbRowSet.getString("inv_no"));	

					tesTmlSoCntrListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					updateVOList.add(tesTmlSoCntrListVO);
				}

			}
			
			dbDao2.multiTerminalInvoiceDBVerify2(updateVOList);
			
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}	

	/** searchDBCheckOffDockTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckOffDockTerminalInvoice(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event)e;
		DBRowSet rowSet					=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		int db_cnt = 0;
		String inv_no = "";
		
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageBCImpl    searchDBCheckOffDockTerminalInvoice() ============");

		try {
			
			String costCdFtrRmk = new TESInvoiceCommonBCImpl().selectCostCdFtrRmk(event.getTesTmlSoHdrVO());
			event.getTesTmlSoHdrVO().setCostCdFtrRmk(costCdFtrRmk);
			
			rowSet = dbDao2.dBCheckTerminalInvoice(event.getTesTmlSoHdrVO(), event.getTesTmlSoCntrListVO(), event.getTesCommonVO());
			
			if(rowSet!=null && rowSet.getRowCount()>0){
				rowSet.next();
				
				db_cnt = rowSet.getRowCount();
				etcData.put("db_cnt", db_cnt+"");
				inv_no = rowSet.getString("INV_NO");
				etcData.put("inv_no", inv_no);
			}
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * OffDock CY Invoice Account Code Update.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateOffdockCYAccountCode(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		DBRowSet rowSet = null;
		TesTmlSoDtlVO tesTmlSoDtlVO = null;

		List<TesTmlSoDtlVO> voList = new ArrayList<TesTmlSoDtlVO>();
		
		Map<String, String> etcMap = new HashMap<String, String>();
		
		try {
			
			etcMap.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			etcMap.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
			
			rowSet = dbDao.searchOffdockCYAccountCode(event.getTesTmlSoHdrVO());
			
			if (rowSet != null){
				while( rowSet.next() ) {
					tesTmlSoDtlVO = new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setAcctCd( JSPUtil.getNull( rowSet.getString("ACCT_CD") ) );
					tesTmlSoDtlVO.setLgsCostCd( JSPUtil.getNull( rowSet.getString("LGS_COST_CD") ) );
					tesTmlSoDtlVO.setTmlSoOfcCtyCd( JSPUtil.getNull( rowSet.getString("TML_SO_OFC_CTY_CD") ) );
					tesTmlSoDtlVO.setTmlSoSeq( JSPUtil.getNull( rowSet.getString("TML_SO_SEQ") ) );
					tesTmlSoDtlVO.setTmlSoDtlSeq( JSPUtil.getNull( rowSet.getString("TML_SO_DTL_SEQ") ) );
					
					voList.add(tesTmlSoDtlVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				dbDao.updateOffdockCYAccountCode(voList, etcMap);
			}
			 
			return null;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		} 
	}

	/**
	 * OffDock CY Cost Calculation Status Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYCostCalcSts(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.searchOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Off Dock CY Invoice Creation & Correction - insert TES_TML_SO_HDR
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createOffdockCYInvoiceBasicInfo(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;

		DBRowSet rowSet = null;
		
		FinCommonBC command2 = new FinCommonBCImpl();
		CheckInvoiceNoVO checkInvoiceNoVO = event.getCheckInvoiceNoVO();
		
		try {
			rowSet = dbDao.searchOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO());
			if (rowSet.getRowCount() != 0) { 
//				throw new DAOException("DUP --> addOffdockCYInvoiceManage() ");
				throw new DAOException(new ErrorHandler("TES00095").getMessage());

			}
			
			java.util.HashMap<String, String> hm = new java.util.HashMap<String, String>();
			hm.put("vndr_seq",event.getTesTmlSoHdrVO().getVndrSeq());
			hm.put("inv_no",event.getTesTmlSoHdrVO().getInvNo());
			//new TESInvoiceCommonBCImpl().checkEDIInvoiceDup(hm);

			checkInvoiceNoVO.setRefPk("0");
			command2.checkInvoiceNo(checkInvoiceNoVO);
			
			dbDao.createOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * confirm Info Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOffdockCYInvoice(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		FinCommonBC command2 = new FinCommonBCImpl();
		CheckInvoiceNoVO checkInvoiceNoVO = event.getCheckInvoiceNoVO();
		
		log.debug(">>>>>>>>>>>>>> BC.modifyOffdockCYInvoice() - "+event.getSignOnUserAccount().getUsr_id()+" - "+event.getSignOnUserAccount().getOfc_cd());
		try {
			
			String tml_so_ofc_cty_cd  	= event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd();
			String tml_so_seq  			= event.getTesTmlSoHdrVO().getTmlSoSeq();
			String tmp_tml_so_seq 		= String.format("%09d", Integer.parseInt(tml_so_seq));
			
			checkInvoiceNoVO.setRefPk(tml_so_ofc_cty_cd+tmp_tml_so_seq);
			command2.checkInvoiceNo(checkInvoiceNoVO);
			
			dbDao.modifyOffdockCYInvoice(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Reject Invoice Info Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOffdockCYInvoiceReject(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.modifyOffdockCYInvoiceReject(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Container List Delete.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceContainerList(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceContainerList(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Detail TMNL List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceDetailTMNL(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceDetail(event.getTesTmlSoHdrVO(), "TM");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Detail By Day List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceDetailByDay(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceDetail(event.getTesTmlSoHdrVO(), "SD");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Detail By Pool List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceDetailByPool(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceDetail(event.getTesTmlSoHdrVO(), "SP");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/** removeOffdockCYInvoiceDetailByEQ
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse removeOffdockCYInvoiceDetailByEQ(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceDetail(event.getTesTmlSoHdrVO(), "EQ");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	/**
	 * OffDock CY Invoice Revise List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceRvis(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceRvis(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 3rd list(TMNL, FD) Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceN3rd01(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceN3rd(event.getTesTmlSoHdrVO(), "TM");
			dbDao.removeOffdockCYInvoiceN3rd(event.getTesTmlSoHdrVO(), "SD");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 3rd list(FP) Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceN3rd02(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceN3rd(event.getTesTmlSoHdrVO(), "SP");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/** removeOffdockCYInvoiceN3rd03
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse removeOffdockCYInvoiceN3rd03(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceN3rd(event.getTesTmlSoHdrVO(), "EQ");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * OffDock CY Invoice Auto Calculation TMNL Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYAutoCalcTMNL(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(), "TM");
			dbDao.removeOffdockCYInvoiceAutoCalcData(event.getTesTmlSoHdrVO(), "TM");			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Auto Calculation By Day List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYAutoCalcByDay(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(), "SD");
			dbDao.removeOffdockCYInvoiceAutoCalcData(event.getTesTmlSoHdrVO(), "SD");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Auto Calculation By Pool List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYAutoCalcByPool(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(), "SP");
			dbDao.removeOffdockCYInvoiceAutoCalcData(event.getTesTmlSoHdrVO(), "SP");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Off Dock CY Invoice Creation & Correction - Container List Insert
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createOffdockCYInvoiceContainerList(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;
		
		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
		
		List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
		List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
		
		Map<String, String> etcMap = new HashMap<String, String>();

		try {
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );	
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();		
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++){
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE : "+sIbFlag);
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq((String.valueOf(++ins_idx)));
					
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					updateVOList.add(tesTmlSoCntrListVOs[i]);
				}
				
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceContainerListInsert(insertVOList, etcMap);
			} 
			
			if ( updateVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceContainerListUpdate(updateVOList, etcMap);
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolume(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
		
		
		try {
						
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();
			
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> deleteVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolume >> tesTmlSoCntrListVOs.length >> "+tesTmlSoCntrListVOs.length);
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++ ){
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolume >> sIbFlag >> "+sIbFlag);
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoCntrListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq(String.valueOf(++ins_idx));
					
					tesTmlSoCntrListVOs[i].setCntrTpszCd(event.getOffdockCYInvoiceManageVO().getParamCntrTpszCd());
					tesTmlSoCntrListVOs[i].setDcgoClssCd(event.getOffdockCYInvoiceManageVO().getDcgoClssCd());
					tesTmlSoCntrListVOs[i].setRcFlg(event.getOffdockCYInvoiceManageVO().getRcFlg());
					                    	
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoCntrListVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoCntrListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolumeM(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoRvisListVO[] tesTmlSoRvisListVOs = null;

		try {

			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoRvisListVOs = event.getTesTmlSoRvisListVOs();
			
			List<TesTmlSoRvisListVO> insertVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updateVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> deleteVOList = new ArrayList<TesTmlSoRvisListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolumeM >> tesTmlSoRvisListVOs.length >> "+tesTmlSoRvisListVOs.length);
			
			for( int i=0; tesTmlSoRvisListVOs!=null && i<tesTmlSoRvisListVOs.length; i++ ){
				sIbFlag = tesTmlSoRvisListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeM >> sIbFlag >> "+sIbFlag);   				
				
				tesTmlSoRvisListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoRvisListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_RVIS_LIST", "TML_SO_RVIS_LIST_SEQ");
					
					tesTmlSoRvisListVOs[i].setTmlSoRvisListSeq(String.valueOf(++ins_idx));
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					                    	
					insertVOList.add(tesTmlSoRvisListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					
					tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk());   				
					
					updateVOList.add(tesTmlSoRvisListVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoRvisListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revise Calculated Volume Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolumeSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;

		try {
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();
			
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> deleteVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolumeSeparate >> tesTmlSoCntrListVOs.length >> "+tesTmlSoCntrListVOs.length);
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++ ){
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeSeparate >> sIbFlag >> "+sIbFlag);   				
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoCntrListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq(String.valueOf(++ins_idx));
					tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
					tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
					tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());  									
					updateVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "D".equals(sIbFlag) ) {		//delete
					
					tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
					tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());  						
					deleteVOList.add(tesTmlSoCntrListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revise Calculated Volume Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolumeSeparateM(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		int ins_idx = 0;
		String sIbFlag = "";

		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoRvisListVO[] tesTmlSoRvisListVOs = null;

		try {
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoRvisListVOs = event.getTesTmlSoRvisListVOs();
			
			List<TesTmlSoRvisListVO> insertVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updateVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> deleteVOList = new ArrayList<TesTmlSoRvisListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			for( int i=0; tesTmlSoRvisListVOs!=null && i<tesTmlSoRvisListVOs.length; i++ ){
				log.debug("at BC.multiReviseCalculatedVolumeSeparateM >> tesTmlSoRvisListVOs.length >> "+tesTmlSoRvisListVOs.length);
				
				sIbFlag = tesTmlSoRvisListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeSeparateM >> sIbFlag >> "+sIbFlag);   				
				
				tesTmlSoRvisListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoRvisListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_RVIS_LIST", "TML_SO_RVIS_LIST_SEQ");
					
					tesTmlSoRvisListVOs[i].setTmlSoRvisListSeq(String.valueOf(++ins_idx));
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					                    	
					insertVOList.add(tesTmlSoRvisListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					
					tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk());   				
					
					updateVOList.add(tesTmlSoRvisListVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoRvisListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
	}

	/** multiReviseCalculatedVolumeSeparateMTPB
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiReviseCalculatedVolumeSeparateMTPB(Event e) throws EventException {
		EsdTes9233Event event = (EsdTes9233Event) e;

		int ins_idx = 0;
		String sIbFlag = "";

		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoRvisListVO[] tesTmlSoRvisListVOs = null;
		MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs = null;
		
		try {
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoRvisListVOs = event.getTesTmlSoRvisListVOs();
			marineTerminalInvoiceCommonVOs = event.getMarineTerminalInvoiceCommonVOs();
					
			List<TesTmlSoRvisListVO> insertVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updateVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> deleteVOList = new ArrayList<TesTmlSoRvisListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			for( int i=0; tesTmlSoRvisListVOs!=null && i<tesTmlSoRvisListVOs.length; i++ ){
				log.debug("at BC.multiReviseCalculatedVolumeSeparateMTPB >> tesTmlSoRvisListVOs.length >> "+tesTmlSoRvisListVOs.length);
				
				sIbFlag = tesTmlSoRvisListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeSeparateMTPB >> sIbFlag >> "+sIbFlag);   				
				
				tesTmlSoRvisListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoRvisListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if(marineTerminalInvoiceCommonVOs!=null && "Y".equals(marineTerminalInvoiceCommonVOs[i].getRvisInsFlg())){//20150528 add
					if ( "I".equals(sIbFlag) ) {			//insert
						
						if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_RVIS_LIST", "TML_SO_RVIS_LIST_SEQ");
						
						tesTmlSoRvisListVOs[i].setTmlSoRvisListSeq(String.valueOf(++ins_idx));
						tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
						tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
						tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
						                    	
						insertVOList.add(tesTmlSoRvisListVOs[i]);
						
					} else if( "U".equals(sIbFlag) ) {		//update		
						
						tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
						tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
						tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
						
						tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk());   				
						
						updateVOList.add(tesTmlSoRvisListVOs[i]);
					} else if( "D".equals(sIbFlag) ) {		//delete
						deleteVOList.add(tesTmlSoRvisListVOs[i]);
					}
					
				}
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
	}
	
	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCount(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		try {
			
			tesTmlSoCntrListVO = event.getTesTmlSoCntrListVO();
			
			String sIbFlag = tesTmlSoCntrListVO.getIbflag();
			
			if ( "U".equals(sIbFlag) ) 
				dbDao.recalculateRevisedVolumeCount( tesTmlSoCntrListVO, event.getOffdockCYInvoiceManageVO() );
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountM(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		try {
			dbDao.recalculateRevisedVolumeCountM( event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		try {
			dbDao.recalculateRevisedVolumeCountSeparate(event.getTesTmlSoCntrListVO(), event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountSeparateM(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		try {
			dbDao.recalculateRevisedVolumeCountSeparateM(event.getTesTmlSoCntrListVO(), event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/** recalculateReviseCalculatedVolumeCountSeparateMTPB
	 *  	
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountSeparateMTPB(Event e) throws EventException {

		EsdTes9233Event event = (EsdTes9233Event) e;

		try {
			dbDao.recalculateRevisedVolumeCountSeparateM(event.getTesTmlSoCntrListVO(), event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Recalculated OffDock Invoice Cost Amount
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateOffdocCYInvoiceCostAmount(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;

		try {
			
			tesTmlSoCntrListVO = event.getTesTmlSoCntrListVO();
			
			String sIbFlag = tesTmlSoCntrListVO.getIbflag();
			
			if ( "U".equals(sIbFlag) ) {	
				dbDao.recalculateOffdocCYInvoiceCostAmount( tesTmlSoCntrListVO, event.getOffdockCYInvoiceManageVO() );
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Recalculated OffDock Invoice Cost Amount Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateOffdocCYInvoiceCostAmountSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		try {
			dbDao.recalculateOffdocCYInvoiceCostAmount(event.getTesTmlSoCntrListVO(), event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Off Dock CY Invoice Creation & Correction - Cost Calculation(Detail) List Insert
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createOffdockCYInvoiceDetail(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;
		
		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoDtlVO[] tesTmlSoDtlVOs = null;
		
		try {
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoDtlVOs = event.getTesTmlSoDtlVOs();
			
			List<TesTmlSoDtlVO> insertVOList = new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> updateVOList = new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> deleteVOList = new ArrayList<TesTmlSoDtlVO>();
			
			Map<String, String> etcMap = new HashMap<String, String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );			
			
			for( int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++){
				
				sIbFlag = tesTmlSoDtlVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				tesTmlSoDtlVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesTmlSoDtlVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				tesTmlSoDtlVOs[i].setCalcRmk( TESUtil.convertText(tesTmlSoDtlVOs[i].getCalcRmk()) );

				if("S".equals(tesTmlSoDtlVOs[i].getCalcTpCd())){
					tesTmlSoDtlVOs[i].setCalcTpCd("M");
				}
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_DTL", "TML_SO_DTL_SEQ");

					tesTmlSoDtlVOs[i].setTmlSoDtlSeq((String.valueOf(++ins_idx)));
					
					insertVOList.add(tesTmlSoDtlVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoDtlVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoDtlVOs[i]);
				}
				
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceDetailInsert(insertVOList, etcMap);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceDetailUpdate(updateVOList, etcMap);
			}

			if ( deleteVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceDetailDeleteN3rd(deleteVOList, etcMap);
				dbDao.createOffdockCYInvoiceDetailDeleteRvis(deleteVOList, etcMap);
				dbDao.createOffdockCYInvoiceDetailDeleteDtl(deleteVOList, etcMap);
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/** Off-duck CY Container List - * */
	/**
	 * OffDock CY Invoice Basic(Header) Info Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceBasicInfoInquiry(Event e) throws EventException {
		EsdTes0018Event event = (EsdTes0018Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		try {
			eventResponse.setRs(dbDao.searchOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO()));
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}


	/**
	 * OffDock CY Invoice All Data Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceAllSheetsInquiry(Event e) throws EventException {

		log.debug("\n\n BC.searchOffdockCYInvoiceAllSheetsInquiry() - @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		
		EsdTes0018Event event = (EsdTes0018Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		String tml_cost_grp_cd = "";	
		
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		try {

			tml_cost_grp_cd = (String)event.getOffdockCYInvoiceManageVO().getTmlCostGrpCd();
			log.debug("\n - tml_cost_grp_cd:" + tml_cost_grp_cd + " -------\n");

			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "CO"));
			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "DC"));
					
			if (tml_cost_grp_cd != null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length() == 2) {
				if (tml_cost_grp_cd.substring(0, 1).equals("T")) {
					rsList.add(dbDao.searchCalcCostTMNLList(event.getTesTmlSoHdrVO()));
				}
				else {
					rsList.add( new DBRowSet());
				}

				if (tml_cost_grp_cd.substring(1, 2).equals("D")) {
					rsList.add(dbDao.searchCalcCostByDayList(event.getTesTmlSoHdrVO()));
				}
				else {
					rsList.add( new DBRowSet());
				}
				
				rsList.add(dbDao.searchCalcCostByPoolList(event.getTesTmlSoHdrVO()));		
				rsList.add( dbDao.searchCalcCostByEQList(event.getTesTmlSoHdrVO()) );
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );
				
				return eventResponse;
			} else {
				return null;
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}			
	}

	/**
	 * OffDock CY Invoice 3rd Party Insert, Update.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOffdock3rdIFlist(Event e) throws EventException {

		EsdTes9233Event event = (EsdTes9233Event) e;
		int ins_idx = 0;
		String sIbFlag = "";
		
		String sOfcCd = event.getSignOnUserAccount().getOfc_cd();
		String sUserId = event.getSignOnUserAccount().getUsr_id();
		
		log.debug("sOfcCd : "+sOfcCd+", sUserID : "+sUserId);
		
		OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = null;
		OffdockCYInvoiceManageVO[] offdockCYInvoiceManageVOs = null;
		TesN3rdPtyIfVO tesN3rdPtyIfVO = null;
		TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
		
		try {
			offdockCYInvoiceManageVO = event.getOffdockCYInvoiceManageVO();
			offdockCYInvoiceManageVOs = event.getOffdockCYInvoiceManageVOs();
			tesN3rdPtyIfVO = event.getTesN3rdPtyIfVO();
			tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
			
			List<TesN3rdPtyIfVO> insertVOList = new ArrayList<TesN3rdPtyIfVO>();
			List<OffdockCYInvoiceManageVO> updateCNTRVOList = new ArrayList<OffdockCYInvoiceManageVO>();		// 	Update TES_TML_SO_CNTR_LIST (자동 계산 수정 ) 
			
			List<TesN3rdPtyIfVO> updateVOList = new ArrayList<TesN3rdPtyIfVO>();
			
			List<TesN3rdPtyIfVO> deleteVOList = new ArrayList<TesN3rdPtyIfVO>();
			
			List<TesN3rdPtyIfVO> deleteTPBVOList = new ArrayList<TesN3rdPtyIfVO>();
			
			for( int i=0; tesN3rdPtyIfVOs!=null && i<tesN3rdPtyIfVOs.length; i++){
				
				sIbFlag = tesN3rdPtyIfVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYN3rdTableMaxSeq(sOfcCd);
					
					tesN3rdPtyIfVOs[i].setTmlIfOfcCd(sOfcCd);
					tesN3rdPtyIfVOs[i].setTmlIfSeq(String.valueOf(++ins_idx));
					tesN3rdPtyIfVOs[i].setTmlN3ptyIfStsCd("N");
					tesN3rdPtyIfVOs[i].setCalcCostGrpCd( JSPUtil.getNull(tesN3rdPtyIfVO.getCalcCostGrpCd()) );					
					tesN3rdPtyIfVOs[i].setTmlInvTpCd( JSPUtil.getNull(tesN3rdPtyIfVO.getTmlInvTpCd()) );
					tesN3rdPtyIfVOs[i].setInvNo( JSPUtil.getNull(tesN3rdPtyIfVO.getInvNo()) );
					tesN3rdPtyIfVOs[i].setVndrSeq( JSPUtil.getNull(tesN3rdPtyIfVO.getVndrSeq()) );
					tesN3rdPtyIfVOs[i].setYdCd( JSPUtil.getNull(tesN3rdPtyIfVO.getYdCd()) );					
					tesN3rdPtyIfVOs[i].setTmlSoOfcCtyCd( JSPUtil.getNull(tesN3rdPtyIfVO.getTmlSoOfcCtyCd()) );
					tesN3rdPtyIfVOs[i].setTmlSoSeq( JSPUtil.getNull(tesN3rdPtyIfVO.getTmlSoSeq()) );
					tesN3rdPtyIfVOs[i].setTmlSoDtlSeq( JSPUtil.getNull(tesN3rdPtyIfVO.getTmlSoDtlSeq()) );					
					tesN3rdPtyIfVOs[i].setCurrCd( JSPUtil.getNull(tesN3rdPtyIfVO.getCurrCd()) );
					tesN3rdPtyIfVOs[i].setCxlFlg("N");
					
					tesN3rdPtyIfVOs[i].setCreUsrId(sUserId);
					tesN3rdPtyIfVOs[i].setUpdUsrId(sUserId);
					tesN3rdPtyIfVOs[i].setLoclCreDt(sOfcCd);
					tesN3rdPtyIfVOs[i].setLoclUpdDt(sOfcCd);
					
					insertVOList.add(tesN3rdPtyIfVOs[i]);
					
					//Auto
					
					log.debug("ibflag : I ==> "+offdockCYInvoiceManageVO.getCalcTpCd()+", "+offdockCYInvoiceManageVO.getTmlSoCntrListSeq());
					
					if( offdockCYInvoiceManageVO.getCalcTpCd()!=null && "A".equals(offdockCYInvoiceManageVO.getCalcTpCd()) && 
						offdockCYInvoiceManageVO.getTmlSoCntrListSeq()!=null && !"".equals(offdockCYInvoiceManageVO.getTmlSoCntrListSeq().trim()) ){ 
						
						offdockCYInvoiceManageVOs[i].setTmlIfSeq( String.valueOf(ins_idx) );
						offdockCYInvoiceManageVOs[i].setTmlSoOfcCtyCd(offdockCYInvoiceManageVO.getTmlSoOfcCtyCd());
						offdockCYInvoiceManageVOs[i].setTmlSoSeq(offdockCYInvoiceManageVO.getTmlSoSeq());
						
						updateCNTRVOList.add(offdockCYInvoiceManageVOs[i]); 
					}
					
				} else if( "U".equals(sIbFlag) ) {		//update	
					tesN3rdPtyIfVOs[i].setCurrCd( tesN3rdPtyIfVO.getCurrCd() );
					tesN3rdPtyIfVOs[i].setUpdUsrId(sUserId);
					tesN3rdPtyIfVOs[i].setLoclUpdDt(sOfcCd);		
					tesN3rdPtyIfVOs[i].setErrInvNo("");
					updateVOList.add(tesN3rdPtyIfVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete					
					deleteVOList.add(tesN3rdPtyIfVOs[i]);
				}
							
			}
			
			String	delIfSeq	= JSPUtil.getNull( offdockCYInvoiceManageVO.getDelIfSeq() );
			String	delCntrSeq	= JSPUtil.getNull( offdockCYInvoiceManageVO.getDelCntrSeq() );

			log.debug(">>>>>>>>>>>>>>> delIfSeq : "+delIfSeq+", delCntrSeq : "+delCntrSeq);
			
			if ( delIfSeq != null && !delIfSeq.equals("") ) {
				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); //.replaceAll("\\|", ",");
				String	[]	arrIfSeq	= delIfSeq.split("\\|");
				
				delCntrSeq	= delCntrSeq.substring( 0, delCntrSeq.length() - 1 ); //.replaceAll("\\|", ",");
				String	[]	arrCntrSeq	= delCntrSeq.split("\\|");
				
				TesN3rdPtyIfVO[] tpbVOs = new TesN3rdPtyIfVO[arrIfSeq.length];
				OffdockCYInvoiceManageVO[] offdockVOs = new OffdockCYInvoiceManageVO[arrIfSeq.length];
				
				updateCNTRVOList = new ArrayList<OffdockCYInvoiceManageVO>();
				
				for ( int j = 0; arrIfSeq!=null && j < arrIfSeq.length; j++ ) {
					tpbVOs[j] = new TesN3rdPtyIfVO();					       
					tpbVOs[j].setTmlIfOfcCd(sOfcCd);
					tpbVOs[j].setTmlIfSeq(arrIfSeq[j]);
					tpbVOs[j].setTmlSoOfcCtyCd( offdockCYInvoiceManageVO.getTmlSoOfcCtyCd() );
					tpbVOs[j].setTmlSoSeq( offdockCYInvoiceManageVO.getTmlSoSeq() );
					tpbVOs[j].setTmlSoDtlSeq( offdockCYInvoiceManageVO.getTmlSoDtlSeq() );					
					deleteTPBVOList.add(tpbVOs[j]);					
				}
				
				for ( int j = 0; arrCntrSeq!=null && j < arrCntrSeq.length; j++ ) {	
					offdockVOs[j] = new OffdockCYInvoiceManageVO();
					offdockVOs[j].setTmlIfSeq("");
					offdockVOs[j].setTmlSoOfcCtyCd(offdockCYInvoiceManageVO.getTmlSoOfcCtyCd());
					offdockVOs[j].setTmlSoSeq(offdockCYInvoiceManageVO.getTmlSoSeq());
					offdockVOs[j].setTmlSoCntrListSeq(arrCntrSeq[j]);
					
					updateCNTRVOList.add(offdockVOs[j]);
				}
			}

			if ( deleteTPBVOList.size() > 0 ) {
				dbDao.multiOffdock3rdIFlistNewTPBDelete(deleteTPBVOList);
				int iCnt = dbDao.updateOffdockDetailN3rdFlagSearch(offdockCYInvoiceManageVO);
				
				log.debug("updateOffdockDetailN3rdFlagSearch result is "+iCnt);
				
				if( iCnt < 1 ) {
					offdockCYInvoiceManageVO.setN3ptyFlg("");
					dbDao.updateOffdockDetailN3rdFlag(offdockCYInvoiceManageVO);
				}
			}
			
			if ( updateCNTRVOList.size() > 0 ) {
				dbDao.multiOffdock3rdIFlistNewCNTRUpdate(updateCNTRVOList);
			}	
			
			log.debug(">>>>>>>>>>>>>>>>>>> insertVOList.size() "+insertVOList.size());
			if ( insertVOList.size() > 0 ) {
				/*
				 * 1. insert into TES_N3RD_PTY_IF (insertVOList)
				 * 2. Update TES_TML_SO_CNTR_LIST (updateCNTRVOList)
				 * 3. Update TES_TML_SO_DTL DTL - (OffdockCYInvoiceManageVO)
				 */				
				
				dbDao.multiOffdock3rdIFlistNewInsert(insertVOList);
				dbDao.multiOffdock3rdIFlistNewCNTRUpdate(updateCNTRVOList);
				
				offdockCYInvoiceManageVO.setN3ptyFlg("Y");
				dbDao.multiOffdock3rdIFlistNewDTLUpdate(offdockCYInvoiceManageVO);
				dbDao.updateOffdockDetailN3rdFlag(offdockCYInvoiceManageVO);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.multiOffdock3rdIFlistNewUpdate(updateVOList);
			}

			if ( deleteVOList.size() > 0 ) {
				dbDao.multiOffdock3rdIFlistNewDelete(deleteVOList);
			}				
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieve event process
	 * OffDock Search CNTR TYPE CD List
	 *
	 * @param e EsdTes9140Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCDList(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event)e;
		List<TesFileImpTmpVO> rtnList = new ArrayList<TesFileImpTmpVO>();
		
		TesFileImpTmpVO[] tesFileImpTmpVOs = event.getTesFileImpTmpVOs();				
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			for( int i=0; tesFileImpTmpVOs!=null && i<tesFileImpTmpVOs.length; i++){				
				if("".equals(tesFileImpTmpVOs[i].getCntrTpszCd())){
					tesFileImpTmpVOs[i].setCntrTpszCd(dbDao.searchBkgCntrTPCDList(tesFileImpTmpVOs[i]));				
				}
				rtnList.add(tesFileImpTmpVOs[i]);
			}	
			
			eventResponse.setRsVoList(rtnList);			
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}				
	}

	/** Moon. Off-duck CY Container List - 끝 * */

	/**
	 * ESD Handling for the end of working scenario<br>
	 * OffdockCYInvoiceManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}