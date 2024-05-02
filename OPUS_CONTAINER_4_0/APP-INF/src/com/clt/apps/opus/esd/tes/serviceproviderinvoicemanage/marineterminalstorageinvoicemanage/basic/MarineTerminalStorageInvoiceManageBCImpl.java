/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageBCImpl.java
*@FileTitle : Marine Terminal Strorage Invoice Management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.basic.FinCommonBC;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.basic.FinCommonBCImpl;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.esd.tes.common.tescommon.util.TESUtil;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration.MarineTerminalInvoiceManageDBDAO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0009Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0019Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9142Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9234Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9254Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration.MarineTerminalStorageInvoiceManageDBDAO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo.MarineTerminalStorageInvoiceManageVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9140Event;
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


/**
 * ESD Business Logic Basic Command implementation<br>
 * ESD business logic handling.<br>
 * 
 * @author byungheeyoo
 * @see ESD_TES_009EventResponse,MarineTerminalStorageInvoiceManageBC each DAO class reference
 * @since J2EE 1.4
 */
public class MarineTerminalStorageInvoiceManageBCImpl   extends BasicCommandSupport implements MarineTerminalStorageInvoiceManageBC {

	// Database Access Object
	private transient MarineTerminalStorageInvoiceManageDBDAO dbDao=null;
	private transient MarineTerminalInvoiceManageDBDAO dbDao2=null;
	
	/**
	 * MarineTerminalStorageInvoiceManageBCImpl object creation<br>
	 * MarineTerminalStorageInvoiceManageDBDAO creation<br>
	 */
	public MarineTerminalStorageInvoiceManageBCImpl(){
		dbDao = new MarineTerminalStorageInvoiceManageDBDAO();
		dbDao2 = new MarineTerminalInvoiceManageDBDAO();
	}

	
	/**
	 * storage invoice headerInfo Search
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse searchStorageInvoiceBasicInfo(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		try {
			eventResponse.setRs( dbDao.searchStorageInvoiceBasicInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	/**
	 * reject Info Search
	 * @param  e Event
	 * @return EventResponse
	 */
	public EventResponse searchStorageInvoiceRejectInfo(Event e) throws EventException {

		log.debug("\n\n BC.searchStorageInvoiceRejectInfo \n");
		
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		
		try {
			eventResponse.setRs( dbDao.searchStorageInvoiceRejectInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
			
		} catch (DAOException de) {	
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * container List Remove
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceContainerList(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceContainerList(event.getTesTmlSoHdrVO());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * detail List Remove ByDay
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceDetailByDay(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.removeStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * detail List Remove ByPool 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceDetailByPool(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		

	/**
	 * detail List Remove EQ(Chassis/MG Set) 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceDetailByEq(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"EQ");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * detail List Remove ByPool 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceN3rd01(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceN3rd(event.getTesTmlSoHdrVO(),"SD");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * detail List Remove ByPool 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceN3rd02(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceN3rd(event.getTesTmlSoHdrVO(),"SP");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * detail List Remove ByPool 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceN3rd03(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceN3rd(event.getTesTmlSoHdrVO(),"EQ");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 *  detail List Remove ByDay
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageAutoCalcByDay(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.removeStorageInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(),"SD");
			dbDao.removeStorageInvoiceAutoCalcData(event.getTesTmlSoHdrVO(),"SD");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 *  detail List Remove ByPool
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageAutoCalcByPool(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(),"SP");
			dbDao.removeStorageInvoiceAutoCalcData(event.getTesTmlSoHdrVO(),"SP");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Storage Container List
	 * @param Event e
	 * @return EventResponse 
	 */
	public EventResponse searchStorageContainerList(Event e) throws EventException {
		log.debug("\n\nBC.searchStorageContainerList\n");
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 
		
		try {
//			dbDao.searchStorageContainerList(event.getTES_TML_SO_HDR(),"CO");
//			dbDao.searchStorageContainerList(event.getTES_TML_SO_HDR(),"DC");
			
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"CO") );
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"DC") );

			eventResponse.setRsList(rsList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *  Storage detail List
	 * @param Event e
	 * @return EventResponse
	 */	
	public EventResponse searchStorageInvoiceDetail(Event e) throws EventException {
		log.debug("\n\nBC.searchStorageInvoiceDetail\n");
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		
		String tml_cost_grp_cd = "";
		String dtl_by_day_only_mode = "";
		String dtl_by_pool_only_mode = "";
		String dtl_by_eq_only_mode = "";
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 
		
		try {
			log.debug(" BC.searchStorageInvoiceDetail formCommand - "+event.getFormCommand().getCommand() + "<<<<<<<<<<<<<<<<<<<<");
			tml_cost_grp_cd = event.getTesTmlSoHdrVO().getTmlCostGrpCd();
			dtl_by_day_only_mode = event.getMarineTerminalStorageInvoiceManageVO().getDtlByDayOnlyMode();
			dtl_by_pool_only_mode = event.getMarineTerminalStorageInvoiceManageVO().getDtlByPoolOnlyMode();
			dtl_by_eq_only_mode = event.getMarineTerminalStorageInvoiceManageVO().getDtlByEqOnlyMode();
			
			if (tml_cost_grp_cd!=null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length()==2){
				log.debug(" BC.tml_cost_grp_cd - "+tml_cost_grp_cd.substring(0,1) + " / " + tml_cost_grp_cd.substring(1,2) + "<<<<<<<<<<<<<<<<<<<<<");
				log.debug(" BC.dtl_by_pool_only_mode - "+dtl_by_pool_only_mode + "<<<<<<<<<<<<<<<<<<<<<");
				if (dtl_by_day_only_mode!=null && dtl_by_day_only_mode.equals("Y")){
					log.debug("DDDDDDDDDDDDDD");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD") ); //ByDay
				} else if (dtl_by_pool_only_mode!=null && dtl_by_pool_only_mode.equals("Y")){
					log.debug("PPPPPPPPPPPPP");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP") ); //ByPool
				} else if (dtl_by_eq_only_mode!=null && dtl_by_eq_only_mode.equals("Y")){
					log.debug("EEEEEEEEEEEEE");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"EQ") ); //ByEQ
				} else {
					log.debug("DDDDDDDDDDDDDD");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD") ); //ByDay
					log.debug("PPPPPPPPPPPPP");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP") ); //ByPool
					log.debug("EEEEEEEEEEEEE");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"EQ") ); //ByEQ
				}
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );	
				
				return eventResponse;
				
			} else {
				return eventResponse;
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *  Retrieve sheet List
	 * @param Event e
	 * @return EventResponse
	 */	
	public EventResponse searchStorageInvoiceAllSheets(Event e) throws EventException {
		log.debug("\n\nBC.searchStorageInvoiceAllSheets\n");
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 
		try {
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"CO") ); //COINCIDENCE
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"DC") ); //DISCREPANCY
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD") ); //ByDay
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP") ); //ByPool
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"EQ") ); //ByEQ
			
			eventResponse.setRsList(rsList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * storage header Info Creation/Update/Delete
	 * @param Event e
	 * @return EventResponse
	 */
	@SuppressWarnings("unchecked")
	public EventResponse createStorageInvoiceBasicInfo(Event e) throws EventException {
		EsdTes0009Event event=(EsdTes0009Event)e;
//		String return_flag = "N";
		DBRowSet rowSet = null;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		FinCommonBC command2 = new FinCommonBCImpl();
		CheckInvoiceNoVO checkInvoiceNoVO = event.getCheckInvoiceNoVO();
		
		try {
			rowSet = dbDao.searchStorageInvoiceBasicInfo(event.getTesTmlSoHdrVO());
			if (rowSet.getRowCount()> 0){ 
//				throw new DAOException("이미 등록된 header정보 입니다.");
				throw new DAOException(new ErrorHandler("TES00097").getMessage());

			}			

			java.util.HashMap hm = new java.util.HashMap();
			hm.put("vndr_seq",event.getTesTmlSoHdrVO().getVndrSeq());
			hm.put("inv_no",event.getTesTmlSoHdrVO().getInvNo());
			
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );
			tesTmlSoHdrVO.setCreUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclCreDt( event.getSignOnUserAccount().getOfc_cd() );
			
			checkInvoiceNoVO.setRefPk("0");
			command2.checkInvoiceNo(checkInvoiceNoVO);
			
			dbDao.createStorageInvoiceBasicInfo( tesTmlSoHdrVO );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Calculation ByDay
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse calStorageInvoiceCost(Event e) throws EventException {
		log.debug("\n\nBC.calStorageInvoiceCost\n");
		EsdTes0009Event event=(EsdTes0009Event)e;		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String agmtCostYN = "";
		try {
			agmtCostYN = dbDao2.searchTerminalInvoiceAgmtCost(event.getTesTmlSoHdrVO());
			
			eventResponse.setRs( dbDao.calStorageInvoiceCost(event.getTesTmlSoHdrVO(), agmtCostYN) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );		
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}		
	}
	
	/**
	 * verify temporary data Creation  
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9142Event event=(EsdTes9142Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

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
				
				if(ins_idx == 0)ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_FILE_IMP_TMP", "TML_SO_TMP_SEQ");
				
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
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());			
		}

//		try {
//			dbDao.createTES_FILE_IMP_TMP(event.getTES_TML_SO_HDR(), event.getTES_TML_SO_CNTR_LISTS(), event.getParams());
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}

	/**
	 * verify temporary data remove
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9142Event event=(EsdTes9142Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.removeTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieve event process
	 * Offdock retrieve event process
	 * @param e EsdTes9142Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException {

		EsdTes9142Event event = (EsdTes9142Event)e;
		@SuppressWarnings("unused")
		DBRowSet rowSet = null;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			rowSet = dbDao.searchCNTRNumber(event.getTesTmlSoHdrVO());
			//return new ESD_TES_9142EventResponse(rowSet,"SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Update Event Process<br>
	 * Offdock retrieve event process
	 *
	 * @param e EsdTes9142Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException {
		EsdTes9142Event event = (EsdTes9142Event)e;
		DBRowSet rowSet = null;
		TesFileImpTmpVO tesFileImpTmpVO = null;
		List<TesFileImpTmpVO> voList = new ArrayList<TesFileImpTmpVO>();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			rowSet = dbDao.searchCNTRNumber(event.getTesTmlSoHdrVO());
			//tesFileImpTmpVO = event.getTesFileImpTmpVO();
			
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
			return eventResponse;
			
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
	 * retrieve event process
	 * EDI CNTRList retrieve - eBilling
	 *
	 * @param e EsdTes9142Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerList(Event e) throws EventException {
		
		EsdTes9142Event event = (EsdTes9142Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchEDIStorageInvoiceContainerList(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}	
	
	}
	
	/**
	 * retrieve event process
	 * Offdock retrieve event process
	 *
	 * @param e EsdTes9142Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9142Event event = (EsdTes9142Event)e;
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
	 * Storage verify ByDay
	 * 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse verifyStorageInvoiceVolumne(Event e) throws EventException {
		log.debug("\n\nBC.verifyStorageInvoiceVolumne ------------- \n");
		EsdTes9142Event event=(EsdTes9142Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.verifyStorageInvoiceVolumne(event.getTesTmlSoHdrVO()) );
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

//	/**
//	 * verify Temporary data Creation  
//	 */
//	public int insertStorageInvoiceContainerList(Event e) throws EventException {
//		EsdTes9142Event event=(EsdTes9142Event)e;
//		int insCnt = 0;
//		
//		try {
//			insCnt = dbDao.insertStorageInvoiceContainerList(event.getTES_TML_SO_HDR(),
//					   event.getRowSet(),
//					   event.getSignOnUserAccount().getUsr_id(),
//					   event.getSignOnUserAccount().getOfc_cd());
//			return insCnt;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/** Container retrieve
	 *  @param Event e
	 *  @return int
	 *  @throws EventException
	 */
	public int insertStorageInvoiceContainerList(Event e) throws EventException {
		EsdTes9142Event event = (EsdTes9142Event) e;
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
			
			//rowSet = dbDao.verifyStorageInvoiceVolumne(event.getTesTmlSoHdrVO());
			rowSet = event.getRowSet();
				
			if (rowSet != null){
				if(ins_idx == 0)ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
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
					
					voList.add(tesTmlSoCntrListVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				dbDao.removeStorageInvoiceContainerList(tesTmlSoHdrVO);
				insCnt = dbDao.insertStorageInvoiceContainerList(voList);
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
	 * storage invoice Update
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse modifyStorageInvoice(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		FinCommonBC command2 = new FinCommonBCImpl();
		CheckInvoiceNoVO checkInvoiceNoVO = event.getCheckInvoiceNoVO();
		
		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );
			
			String tml_so_ofc_cty_cd  	= event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd();
			String tml_so_seq  			= event.getTesTmlSoHdrVO().getTmlSoSeq();
			String tmp_tml_so_seq 		= String.format("%09d", Integer.parseInt(tml_so_seq));
			checkInvoiceNoVO.setRefPk(tml_so_ofc_cty_cd+tmp_tml_so_seq);
			command2.checkInvoiceNo(checkInvoiceNoVO);
			
			dbDao.modifyStorageInvoice( tesTmlSoHdrVO );
			//dbDao.modifyStorageInvoice(event.getTES_TML_SO_HDR(),event.getSignOnUserAccount().getUsr_id(),event.getSignOnUserAccount().getOfc_cd());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * confirm Info Update
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse modifyStorageInvoiceConfirm(Event e) throws EventException {
		log.debug("\n\nBC.modifyStorageInvoiceConfirm\n");	
		EsdTes0009Event event=(EsdTes0009Event)e;
		String chkAmt = "";
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TESInvoiceCommonBC	invCom	= new TESInvoiceCommonBCImpl();
			
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );	
			
			chkAmt = dbDao.checkSOInvAmt(tesTmlSoHdrVO);
			log.error("\n DONE - modifyStorageInvoiceConfirm.checkInvAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
//				throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
				throw new DAOException(new ErrorHandler("TES00088").getMessage());
			}
			// 1. SO_DTL N3PTY_FLG value check 
			//invCom.checkDetailTpb(event.getTES_TML_SO_HDR().getTml_so_ofc_cty_cd(), event.getTES_TML_SO_HDR().getTml_so_seq() );			
			invCom.checkDetailTpb(tesTmlSoHdrVO);
			
			// 2. check result update
			dbDao.modifyStorageInvoiceConfirm(tesTmlSoHdrVO);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * confirm cancel
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse cancelStorageInvoiceConfirm(Event e) throws EventException {
		log.debug("\n\nBC.modifyStorageInvoiceConfirm\n");	
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );
			
			dbDao.cancelStorageInvoiceConfirm(tesTmlSoHdrVO);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * account code update
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse updateStorageAccountCode(Event e) throws EventException {
		log.debug("\n\nBC.updateStorageAccountCode\n");	
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		DBRowSet rowSet = null;
		TesTmlSoDtlVO tesTmlSoDtlVO = null;
		List<TesTmlSoDtlVO> voList = new ArrayList<TesTmlSoDtlVO>();
		
		try {
			rowSet = dbDao.searchStorageAccountCode(event.getTesTmlSoHdrVO());
			
			if (rowSet != null){
				while (rowSet.next()){
					tesTmlSoDtlVO = new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setAcctCd( rowSet.getString("acct_cd") );
					tesTmlSoDtlVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
					tesTmlSoDtlVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );
					tesTmlSoDtlVO.setLgsCostCd( rowSet.getString("lgs_cost_cd") );
					tesTmlSoDtlVO.setTmlSoOfcCtyCd(rowSet.getString("tml_so_ofc_cty_cd") );
					tesTmlSoDtlVO.setTmlSoSeq(rowSet.getString("tml_so_seq") );
					tesTmlSoDtlVO.setTmlSoDtlSeq(rowSet.getString("tml_so_dtl_seq") );
					voList.add(tesTmlSoDtlVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				dbDao.updateStorageAccountCode( voList );
			}
			return eventResponse;
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
	 * reject info update
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse modifyStorageInvoiceReject(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );	
			dbDao.modifyStorageInvoiceReject( tesTmlSoHdrVO );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * reject cancel
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse cancelStorageInvoiceReject(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );			
			dbDao.cancelStorageInvoiceReject(tesTmlSoHdrVO);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/** multiStorageTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiStorageTerminalInvoiceDBVerify(Event e) throws EventException{
		EsdTes0009Event event = (EsdTes0009Event)e;
		DBRowSet dbRowSet					=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		TesTmlSoCntrListVO  tesTmlSoCntrListVO = null;
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalStorageInvoiceManageBCImpl    multiStorageTerminalInvoiceDBVerify() ============");

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
	
	/** searchDBCheckStorageTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckStorageTerminalInvoice(Event e) throws EventException {
		EsdTes0009Event event = (EsdTes0009Event)e;
		DBRowSet rowSet					=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		int db_cnt = 0;
		String inv_no = "";
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalStorageInvoiceManageBCImpl    searchDBCheckStorageTerminalInvoice() ============");

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
	 * container List Creation/Update/Delete
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse createStorageInvoiceContainerList(Event e) throws EventException{

		log.debug("\n\n BC.createStorageInvoiceContainerList \n");
		
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
		
		try {
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();
			
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
//			List<TesTmlSoCntrListVO> deleteVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
			String usr_id = event.getSignOnUserAccount().getUsr_id();			
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++){
				
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				tesTmlSoCntrListVOs[i].setCreUsrId(usr_id);
				tesTmlSoCntrListVOs[i].setUpdUsrId(usr_id);
				tesTmlSoCntrListVOs[i].setLoclCreDt(ofc_cd);
				tesTmlSoCntrListVOs[i].setLoclUpdDt(ofc_cd);
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0) ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq((String.valueOf(++ins_idx)));
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoCntrListVOs[i]);
//				} else if( "D".equals(sIbFlag) ) {		//delete
//					deleteVOList.add(tesTmlSoCntrListVOs[i]);
				}
				
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.addStorageInvoiceContainerList(insertVOList);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.modifyStorageInvoiceContainerList(updateVOList);
			}

//			if ( deleteVOList.size() > 0 ) {
//				dbDao.removeStorageInvoiceContainerList(deleteVOList);
//			}
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

//		try {
//			dbDao.createStorageInvoiceContainerList(event.getTES_TML_SO_HDR(), event.getTES_TML_SO_CNTR_LISTS(), event.getSignOnUserAccount().getUsr_id(),event.getSignOnUserAccount().getOfc_cd());
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
		
	}

	/**
	 * detail List Creation/Update/Delete
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	@SuppressWarnings("null")
	public EventResponse createStorageInvoiceDetail(Event e) throws EventException{

		log.debug("\n\n BC.createStorageInvoiceDetail \n");
		
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
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
			
			String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
			String usr_id = event.getSignOnUserAccount().getUsr_id();			
			
			for( int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++){
				
				sIbFlag = tesTmlSoDtlVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				tesTmlSoDtlVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesTmlSoDtlVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				tesTmlSoDtlVOs[i].setCreUsrId(usr_id);
				tesTmlSoDtlVOs[i].setUpdUsrId(usr_id);
				tesTmlSoDtlVOs[i].setLoclCreDt(ofc_cd);
				tesTmlSoDtlVOs[i].setLoclUpdDt(ofc_cd);
				
				tesTmlSoDtlVOs[i].setCalcRmk( TESUtil.convertText(tesTmlSoDtlVOs[i].getCalcRmk()) );
				
				String revYrmon = tesTmlSoDtlVOs[i].getRevYrmon();
				
				if("S".equals(tesTmlSoDtlVOs[i].getCalcTpCd())){
					tesTmlSoDtlVOs[i].setCalcTpCd("M");
				}
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>> revYrmon : "+revYrmon);
				
				revYrmon = revYrmon==null||"".equals(revYrmon.trim())?revYrmon:revYrmon.substring(0,6);
				
				tesTmlSoDtlVOs[i].setRevYrmon( revYrmon );				
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0) ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_DTL", "TML_SO_DTL_SEQ");

					tesTmlSoDtlVOs[i].setTmlSoDtlSeq((String.valueOf(++ins_idx)));
					insertVOList.add(tesTmlSoDtlVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoDtlVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoDtlVOs[i]);
				}
				
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.addStorageInvoiceDetail(insertVOList);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.modifyStorageInvoiceDetail(updateVOList);
			}

			if ( deleteVOList.size() > 0 ) {
				dbDao.removeStorageInvoiceDetailDeleteN3rd(deleteVOList);
				dbDao.removeStorageInvoiceDetailDeleteRvis(deleteVOList);
				dbDao.removeStorageInvoiceDetailDeleteDtl(deleteVOList);
			}
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		
		
//		try {			
//			dbDao.createStorageInvoiceDetail(event.getTES_TML_SO_HDR(), 
//											 event.getTES_TML_SO_DTLS(), 
//											 event.getStorageInvoiceDTLseqs(), 
//											 event.getStorageInvoiceN3rdPtyIFs(),
//											 event.getSignOnUserAccount().getOfc_cd(),
//											 event.getSignOnUserAccount().getUsr_id());
//			
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}	

	/**
	 * 3rd List retrieve ByDay
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse searchStorage3rdIFlistOnly(Event e) throws EventException {
		log.debug("BC.searchStorage3rdIFlistOnly ###############################");
		EsdTes9254Event event=(EsdTes9254Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
//		DBRowSet rowSet=null; 
		
		try {
			eventResponse.setRs( dbDao.searchStorage3rdIFlistOnly(event.getTesN3rdPtyIfVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 3rd List retrieve ByDay
	 */
//	public EventResponse searchStorage3rdIFlist(Event e) throws EventException {
//		log.debug("BC.searchStorage3rdIFlist ###############################");
//		EsdTes9234Event event=(EsdTes9234Event)e;
//		DBRowSet rowSet=null; 
//		String calc_tp_cd = null;
//		
//		try {
//			calc_tp_cd = event.getMarineTerminalStorageInvoiceManageVO().getCalcTpCd();
//
//			GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
//			
//			if (calc_tp_cd!=null && calc_tp_cd.equals("A")){
//				eventResponse.setRs( dbDao.searchStorage3rdIFlist(event.getMarineTerminalStorageInvoiceManageVO()) );		
//			} else if (calc_tp_cd!=null && calc_tp_cd.equals("M")){
//				eventResponse.setRs( dbDao.searchStorage3rdIFlistManual(event.getMarineTerminalStorageInvoiceManageVO()) );
//			}			
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/**
	 * 3rd List retrieve ByDay
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse searchStorage3rdIFlistByDay(Event e) throws EventException {
		log.debug("BC.searchStorage3rdIFlistByDay ###############################");
		EsdTes9234Event event=(EsdTes9234Event)e;
		String calc_tp_cd = null;
		
		try {
			calc_tp_cd = event.getMarineTerminalStorageInvoiceManageVO().getCalcTpCd();
			
			GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
				
			if (calc_tp_cd!=null && calc_tp_cd.equals("A")){
				eventResponse.setRs( dbDao.searchStorage3rdIFlistByDay(event.getMarineTerminalStorageInvoiceManageVO()) );		
			} else if (calc_tp_cd!=null && (calc_tp_cd.equals("M") || calc_tp_cd.equals("S"))){
				eventResponse.setRs( dbDao.searchStorage3rdIFlistByPoolManual(event.getMarineTerminalStorageInvoiceManageVO()) );
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
	 * 3rd List retrieve ByPool
	 */
//	public EventResponse searchStorage3rdIFlistByPool(Event e) throws EventException {
//		log.debug("BC.searchStorage3rdIFlistByPool ###############################");
//		EsdTes9234Event event=(EsdTes9234Event)e;
//		String calc_tp_cd = null;
//		
//		try {
//			calc_tp_cd = event.getMarineTerminalStorageInvoiceManageVO().getCalcTpCd();
//			
//			GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
//				
//			if (calc_tp_cd!=null && calc_tp_cd.equals("A")){
//				eventResponse.setRs( dbDao.searchStorage3rdIFlistByPool(event.getMarineTerminalStorageInvoiceManageVO()) );
//			} else if (calc_tp_cd!=null && calc_tp_cd.equals("M")){
//				eventResponse.setRs( dbDao.searchStorage3rdIFlistByPoolManual(event.getMarineTerminalStorageInvoiceManageVO()) );
//			}	
//			
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
//			
//			return eventResponse;
//		} catch (DAOException ex) {
//			throw new EventException(ex.getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(ex.getMessage(),ex);
//		}
//	}
	

	
	/**
	 * header Info Search (main sheet)
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */	
	public EventResponse searchStorageInvoiceBasicInfo2(Event e) throws EventException {

		EsdTes0019Event event=(EsdTes0019Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		try {
			eventResponse.setRs( dbDao.searchStorageInvoiceBasicInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Storage Container List
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse searchStorageContainerList2(Event e) throws EventException {

		EsdTes0019Event event=(EsdTes0019Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		try {
			
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"CO") );	//Coincidence
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"DC") );	//Discrepancy
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD") ); 	//ByDay
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP") ); 	//ByPool
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"EQ") ); 	//By EQl
			
			eventResponse.setRsList(rsList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}	
	}

//	/**
//	 * Storage detail List
//	 */
//	public EventResponse searchStorageInvoiceDetail2(Event e) throws EventException {
//		log.debug("\n\nBC.searchStorageInvoiceDetail\n");
//		EsdTes0019Event event=(EsdTes0019Event)e;
//		DBRowSet[] rowSetArr = new DBRowSet[2];
//		int curr_idx = 0;
//
//		try {
//			log.debug(" BC.searchStorageInvoiceDetail formCommand - "+event.getFormCommand().getCommand() + "<<<<<<<<<<<<<<<<<<<<");
//
//			rowSetArr[curr_idx++] = dbDao.searchStorageInvoiceDetail(event.getTES_TML_SO_HDR(),"SD"); //ByDay
//			//rowSetArr[curr_idx++] = dbDao.searchStorageInvoiceDetail(event.getTES_TML_SO_HDR(),event.getParams(),"SP"); //ByPool
//
//			return new ESD_TES_019EventResponse(rowSetArr,"SUCCESS");
//
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/** multiStorage3rdIFlist TPB retrieve
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse multiStorage3rdIFlist(Event e) throws EventException {

		EsdTes9234Event event = (EsdTes9234Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO = null;
		MarineTerminalStorageInvoiceManageVO[] marineTerminalStorageInvoiceManageVOs = null;
		TesN3rdPtyIfVO tesN3rdPtyIfVO = null;
		TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		TesTmlSoDtlVO tesTmlSoDtlVO = null;
		
		String sIbFlag = "";
		try {
			marineTerminalStorageInvoiceManageVO = event.getMarineTerminalStorageInvoiceManageVO();
			marineTerminalStorageInvoiceManageVOs = event.getMarineTerminalStorageInvoiceManageVOs();
			tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
			
			List<TesN3rdPtyIfVO> insertVOList = new ArrayList<TesN3rdPtyIfVO>();
			List<TesN3rdPtyIfVO> updateVOList = new ArrayList<TesN3rdPtyIfVO>();
			List<TesN3rdPtyIfVO> deleteVOList = new ArrayList<TesN3rdPtyIfVO>();

			List<TesTmlSoCntrListVO> updateCntrList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoDtlVO> updateDtlList = new ArrayList<TesTmlSoDtlVO>();

			List<TesN3rdPtyIfVO> deleteTpbPsList = new ArrayList<TesN3rdPtyIfVO>();
			List<TesTmlSoCntrListVO> updateCntrList2 = new ArrayList<TesTmlSoCntrListVO>();
			
			String sOfcCd = event.getSignOnUserAccount().getOfc_cd();
			String sUsrId = event.getSignOnUserAccount().getUsr_id();			
			int insIdx = 0;
					
			for( int i=0; tesN3rdPtyIfVOs!=null && i<tesN3rdPtyIfVOs.length; i++){
				
				sIbFlag = tesN3rdPtyIfVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				tesN3rdPtyIfVOs[i].setTmlIfOfcCd(sOfcCd);
				tesN3rdPtyIfVOs[i].setCreUsrId(sUsrId);
				tesN3rdPtyIfVOs[i].setUpdUsrId(sUsrId);
				tesN3rdPtyIfVOs[i].setLoclCreDt(sOfcCd);
				tesN3rdPtyIfVOs[i].setLoclUpdDt(sOfcCd);
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					//if(ins_idx == 0) ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					if(insIdx == 0) insIdx = dbDao.searchStorageN3rdTableMaxSeq(sOfcCd);
					
					tesN3rdPtyIfVOs[i].setTmlN3ptyIfStsCd("N");
					tesN3rdPtyIfVOs[i].setTmlIfSeq((String.valueOf(++insIdx)));
					tesN3rdPtyIfVOs[i].setInvNo( marineTerminalStorageInvoiceManageVO.getInvNo() );
					tesN3rdPtyIfVOs[i].setYdCd( marineTerminalStorageInvoiceManageVO.getYdCd() );
					tesN3rdPtyIfVOs[i].setCxlFlg("N");
					insertVOList.add(tesN3rdPtyIfVOs[i]);
					
					if ( marineTerminalStorageInvoiceManageVO.getCalcTpCd()!=null
							&& "A".equals( marineTerminalStorageInvoiceManageVO.getCalcTpCd() )							
							&& marineTerminalStorageInvoiceManageVOs[i].getTmlSoCntrListSeq()!=null
							&& marineTerminalStorageInvoiceManageVOs[i].getTmlSoCntrListSeq()!="" ){
							//(String)param_map.get("calc_tp_cd")!=null && ((String)param_map.get("calc_tp_cd")).equals("A") && model.getTml_so_cntr_list_seq()!=null && !model.getTml_so_cntr_list_seq().trim().equals("")){
						tesTmlSoCntrListVO = new TesTmlSoCntrListVO();						
						tesTmlSoCntrListVO.setTmlIfSeq( (String.valueOf(insIdx)) );
						tesTmlSoCntrListVO.setTmlSoOfcCtyCd(marineTerminalStorageInvoiceManageVO.getTmlSoOfcCtyCd());
						tesTmlSoCntrListVO.setTmlSoSeq(marineTerminalStorageInvoiceManageVO.getTmlSoSeq());
						tesTmlSoCntrListVO.setTmlSoCntrListSeq( marineTerminalStorageInvoiceManageVOs[i].getTmlSoCntrListSeq() );
						updateCntrList.add( tesTmlSoCntrListVO );
					}
					
					tesTmlSoDtlVO = new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setN3ptyFlg("Y");
					tesTmlSoDtlVO.setTmlSoOfcCtyCd( marineTerminalStorageInvoiceManageVO.getTmlSoOfcCtyCd() );
					tesTmlSoDtlVO.setTmlSoSeq( marineTerminalStorageInvoiceManageVO.getTmlSoSeq() );
					tesTmlSoDtlVO.setTmlSoDtlSeq( marineTerminalStorageInvoiceManageVO.getTmlSoDtlSeq() );
					updateDtlList.add(tesTmlSoDtlVO);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesN3rdPtyIfVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesN3rdPtyIfVOs[i]);
				}
				
			}
			
			String	delIfSeq	= JSPUtil.getNull( marineTerminalStorageInvoiceManageVO.getDelIfSeq() );
			String	delCntrSeq	= JSPUtil.getNull( marineTerminalStorageInvoiceManageVO.getDelCntrSeq() );

log.debug(">>>>>>>>>>>>>>> delIfSeq : "+delIfSeq+", delCntrSeq : "+delCntrSeq);
			
			if ( delIfSeq.length() > 0 ) {
				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); //.replaceAll("\\|", ",");
				String	[]	arrIfSeq	= delIfSeq.split("\\|");
				delCntrSeq	= delCntrSeq.substring( 0, delCntrSeq.length() - 1 ); //.replaceAll("\\|", ",");
				String	[]	arrCntrSeq	= delCntrSeq.split("\\|");
				
				for ( int j = 0; j < arrIfSeq.length; j++ ) {
					tesN3rdPtyIfVO = new TesN3rdPtyIfVO();
					tesN3rdPtyIfVO.setTmlIfOfcCd(sOfcCd);
					tesN3rdPtyIfVO.setTmlIfSeq(arrIfSeq[j]);
					tesN3rdPtyIfVO.setTmlSoOfcCtyCd(marineTerminalStorageInvoiceManageVO.getTmlSoOfcCtyCd());
					tesN3rdPtyIfVO.setTmlSoSeq(marineTerminalStorageInvoiceManageVO.getTmlSoSeq());
					tesN3rdPtyIfVO.setTmlSoDtlSeq(marineTerminalStorageInvoiceManageVO.getTmlSoDtlSeq());
					deleteTpbPsList.add(tesN3rdPtyIfVO);
					
					// Container List TML_IF_SEQ Update		
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();						
					tesTmlSoCntrListVO.setTmlIfSeq( "" );
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(marineTerminalStorageInvoiceManageVO.getTmlSoOfcCtyCd());
					tesTmlSoCntrListVO.setTmlSoSeq(marineTerminalStorageInvoiceManageVO.getTmlSoSeq());
					tesTmlSoCntrListVO.setTmlSoCntrListSeq( arrCntrSeq[j] );
					updateCntrList2.add( tesTmlSoCntrListVO );
				}
			}
			
			if ( deleteTpbPsList!=null && deleteTpbPsList.size() > 0 ) {
				
				dbDao.removeStorage3rdIFlistTPB(deleteTpbPsList);

				int iCnt = dbDao.searchStorageN3rdFlag(marineTerminalStorageInvoiceManageVO);
				
				log.debug("updateOffdockDetailN3rdFlagSearch result is "+iCnt);
				
				if( iCnt<1 ) dbDao.modifyStorageN3rdFlag(marineTerminalStorageInvoiceManageVO);
			}
			
			if( updateCntrList2!=null && updateCntrList2.size() > 0 )	dbDao.modifyStorage3rdIFlistCNTR(updateCntrList2);
			
			if ( insertVOList!=null && insertVOList.size() > 0 ) {
				dbDao.addStorage3rdIFlist(insertVOList);
				if( updateCntrList!=null && updateCntrList.size() > 0 )	dbDao.modifyStorage3rdIFlistCNTR(updateCntrList);
				if( updateDtlList!=null && updateDtlList.size() > 0 )	dbDao.modifyStorage3rdIFlistDTL(updateDtlList);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.modifyStorage3rdIFlist(updateVOList);
			}

			if ( deleteVOList.size() > 0 ) {
				dbDao.removeStorage3rdIFlist(deleteVOList);
			}
			
			//dbDao.multiStorage3rdIFlist(event.getTES_N3RD_PTY_IFS(), event.getParams(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieve event process
	 * 9142 Search CNTR TYPE CD List
	 *
	 * @param e EsdTes9142Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCDList(Event e) throws EventException {
		EsdTes9142Event event = (EsdTes9142Event)e;
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
	
	/**
	 * ESD Handling for the end of working scenario<br>
	 * MarineTerminalStorageInvoiceManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}