/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MarineTerminalInvoiceManageBCImpl.java
*@FileTitle : Marine Terminal Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-10-16 parkyeonjin
* 1.0 최초 생성
* 2009-03-12 [R200903110001] : TES_TML_SO_PAY_DYS 테이블 미사용 제거 주석처리
* 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
* 							    RH용 EDI전송 manual cntrList 조회
*@OPUSModifyDate : 2009.08.10
*@OPUSModifier : chae heung Park
*@OPUSVersion : 1.0
* 2009.08.10  chae heung Park
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.basic.FinCommonBC;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.basic.FinCommonBCImpl;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0014Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0017Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes1003Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes1004Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9010Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9032Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9072Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9190Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9191Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9220Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9232Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9252Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9300Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration.MarineTerminalInvoiceManageDBDAO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCostCodeDetailListVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9140Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesFileImpTmpVO;
import com.clt.syscommon.common.table.TesMgstFuelChgVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;


/**
 * ESD Business Logic Basic Command implementation<br>
 * ESD business logic  handling.<br>
 *
 * @author parkyeonjin
 * @see MarineTerminalInvoiceManageBC each DAO class reference
 * @since J2EE 1.4
 */
public class MarineTerminalInvoiceManageBCImpl   extends BasicCommandSupport implements MarineTerminalInvoiceManageBC {

	// Database Access Object
	private transient MarineTerminalInvoiceManageDBDAO dbDao=null;

	/**
	 * MarineTerminalInvoiceManageBCImpl object creation<br>
	 * MarineTerminalInvoiceManageDBDAO creation<br>
	 */
	public MarineTerminalInvoiceManageBCImpl(){
		dbDao = new MarineTerminalInvoiceManageDBDAO();
	}


	/**
	 *  retrieve event process
	 * searchTerminalInvoiceBasicInfo 대한  retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event=(EsdTes0001Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList<DBRowSet>  	arrList 		= new ArrayList<DBRowSet>();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchMarineTerminalInvoiceManage() ============");

		// DB ResultSet object For data transfer

		try {
			arrList.add(dbDao.searchTerminalInvoiceBasicInfo(event.getTesTmlSoHdrVO()));
			arrList.add(dbDao.searchTerminalInvoiceVVD(event.getTesTmlSoHdrVO()));
			
			if(event.getFormCommand().isCommand(FormCommand.ADD) || event.getFormCommand().isCommand(FormCommand.MODIFY)){
				arrList.add(dbDao.searchAccumulatedVolume(event.getTesTmlSoHdrVO(), event.getTesCommonVo(), event.getSignOnUserAccount().getOfc_cd()));
			}
			
			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process
	 * searchMarineTerminalCNTRList retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse  GeneralEventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchMarineTerminalCNTRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event=(EsdTes0001Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList  				arrList 		= new ArrayList();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchMarineTerminalCNTRList() ============");

		// DB ResultSet object For data transfer
		DBRowSet   rowSet 		= new DBRowSet();
		DBRowSet[] rowSetArr 	= new DBRowSet[2];

		try {
//			rowSetArr[0] = dbDao.searchTerminalInvoiceContainerList(event.getParams(),"CO");
//			rowSetArr[1] = dbDao.searchTerminalInvoiceContainerList(event.getParams(),"DC");

			rowSetArr[0] = dbDao.searchTerminalInvoiceContainerList(event.getTesTmlSoCntrListVO(), event.getTesCommonVo(), "CO");
			rowSetArr[1] = dbDao.searchTerminalInvoiceContainerList(event.getTesTmlSoCntrListVO(), event.getTesCommonVo(), "DC");
			
			arrList.add(rowSet);
			arrList.add(rowSetArr[0]);
			arrList.add(rowSetArr[1]);

			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}


	/**
	 * retrieve event process
	 * searchMarineTerminalInvoice List retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoice(Event e) throws EventException{
		EsdTes0001Event event=(EsdTes0001Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList<DBRowSet>  	arrList 		= new ArrayList<DBRowSet>();
		HashMap<String, String> etcData			= new HashMap<String, String>();
		
		if(log.isDebugEnabled()) log.debug("\n\n================MarineTerminalInvoiceManageBCImpl :::::: searchMarineTerminalInvoice()======================\n");
		try{
			arrList.add(dbDao.searchTerminalInvoiceContainerList(event.getTesTmlSoCntrListVO(), event.getTesCommonVo(),"CO"));
			arrList.add(dbDao.searchTerminalInvoiceContainerList(event.getTesTmlSoCntrListVO(), event.getTesCommonVo(),"DC"));
			arrList.add(dbDao.searchTerminalInvoiceCalculationList(event.getTesTmlSoDtlVO(), event.getTesCommonVo()));
			arrList.add(dbDao.searchAccumulatedVolume(event.getTesTmlSoHdrVO(), event.getTesCommonVo(), event.getSignOnUserAccount().getOfc_cd()));
			arrList.add(dbDao.searchTerminalInvoiceTotalAmount(event.getTesTmlSoHdrVO()));
			arrList.add(dbDao.searchTerminalInvoiceTotalAmountForPopup(event.getTesTmlSoDtlVO()));

			eventResponse.setRsList(arrList);
			
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		}catch(DAOException de){
			log.error("err"+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * retrieve event process
	 * search MarineTerminal Invoice Costs<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoiceCosts(Event e) throws EventException{
		EsdTes0001Event 		event=(EsdTes0001Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		ArrayList<DBRowSet>  	arrList 		= new ArrayList<DBRowSet>();
		HashMap<String, String> etcData			= new HashMap<String, String>();
		
		DBRowSet[] rowSetArr = new DBRowSet[4];

		if(log.isDebugEnabled()) log.debug("\n\n================MarineTerminalInvoiceManageBCImpl :::::: searchMarineTerminalInvoice()======================\n");
		try{
			rowSetArr[0] = dbDao.searchTerminalInvoiceCalculationList(event.getTesTmlSoDtlVO(), event.getTesCommonVo());
			rowSetArr[1] = dbDao.searchTerminalInvoiceTotalAmount(event.getTesTmlSoHdrVO());
			rowSetArr[2] = dbDao.searchTerminalInvoiceTotalAmountForPopup(event.getTesTmlSoDtlVO());
			rowSetArr[3] = dbDao.searchTerminalInvoiceVVD(event.getTesTmlSoHdrVO());
			
			arrList.add(rowSetArr[0]);
			arrList.add(rowSetArr[1]);
			arrList.add(rowSetArr[2]);
			arrList.add(rowSetArr[3]);
			
			etcData.put("successFlag", "SUCCESS");
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);

			return  eventResponse;
		}catch(DAOException de){
			log.error("err"+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}


	/**
	 * retrieve event process
	 * search MarineTerminal Invoice CNTR List retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoiceCNTRList(Event e) throws EventException{
		EsdTes0001Event event=(EsdTes0001Event)e;
		
		DBRowSet[] rowSetArr = new DBRowSet[3];
		ArrayList<DBRowSet>  arrList 	= new ArrayList<DBRowSet>();
		HashMap<String, String> etcData = new HashMap<String, String>();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if(log.isDebugEnabled()) log.debug("\n\n================MarineTerminalInvoiceManageBCImpl :::::: searchMarineTerminalInvoice()======================\n");
		try{
			rowSetArr[0] = dbDao.searchTerminalInvoiceContainerList(event.getTesTmlSoCntrListVO(), event.getTesCommonVo(),"CO");
			rowSetArr[1] = dbDao.searchTerminalInvoiceContainerList(event.getTesTmlSoCntrListVO(), event.getTesCommonVo(),"DC");
			rowSetArr[2] = dbDao.searchTerminalInvoiceCalculationList(event.getTesTmlSoDtlVO(), event.getTesCommonVo());
			
			arrList.add(rowSetArr[0]);
			arrList.add(rowSetArr[1]);
			arrList.add(rowSetArr[2]);

			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);

			return eventResponse;
		}catch(DAOException de){
			log.error("err"+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}



	/**
	 * Add Event Process<br>
	 * createTerminalInvoiceBasicInfo Add Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse ESD_TES_001EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceBasicInfo(Event e) throws EventException {
		EsdTes0001Event event=(EsdTes0001Event)e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		FinCommonBC command2 = new FinCommonBCImpl();
		CheckInvoiceNoVO checkInvoiceNoVO = event.getCheckInvoiceNoVO();

		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    createTerminalInvoiceBasicInfo() ============");
		try {
			rowSet = dbDao.searchTerminalInvoiceBasicInfo(event.getTesTmlSoHdrVO());
			if(rowSet.getRowCount()!=0){
//				throw new DAOException("DUP --> createTerminalInvoiceBasicInfo()");
				throw new EventException(new ErrorHandler("TES00096").getMessage());
			}
			
			java.util.HashMap<String, String> hm = new java.util.HashMap<String, String>();
			hm.put("vndr_seq",event.getTesTmlSoHdrVO().getVndrSeq());
			hm.put("inv_no",event.getTesTmlSoHdrVO().getInvNo());
			
			checkInvoiceNoVO.setRefPk("0");
			command2.checkInvoiceNo(checkInvoiceNoVO);
			
			dbDao.createTerminalInvoiceBasicInfo(event.getTesTmlSoHdrVO(),event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			multiAccumulatedVolume(event);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Update Event Process<br>
	 * MR Invoice Update Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse modifyTerminalInvoice(Event e) throws EventException {
		EsdTes0001Event event	=(EsdTes0001Event)e;
		String 			chkAmt 	= "";
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		FinCommonBC command2 = new FinCommonBCImpl();
		CheckInvoiceNoVO checkInvoiceNoVO = event.getCheckInvoiceNoVO();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    modifyTerminalInvoice() ============");

		try {
			
			if(Integer.parseInt(event.getTesCommonVo().getFCmd())==141){
				dbDao.modifyCntrListForTerminalInvoiceConfirm(event, event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			}
			
			String tml_so_ofc_cty_cd  	= event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd();
			String tml_so_seq  			= event.getTesTmlSoHdrVO().getTmlSoSeq();
			String tmp_tml_so_seq 		= String.format("%09d", Integer.parseInt(tml_so_seq));
			
			checkInvoiceNoVO.setRefPk(tml_so_ofc_cty_cd+tmp_tml_so_seq);
			
			command2.checkInvoiceNo(checkInvoiceNoVO);
			
			dbDao.modifyTerminalInvoice(event, event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());

			if(event.getTesCommonVo().getFCmd().equals("141")){
				chkAmt = dbDao.checkSOInvAmt(event.getTesTmlSoHdrVO());
				
				if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
					log.error("\n  modifyTerminalInvoice.checkInvAmt(Confirm):"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n INV NO/SP CODE : "+event.getEventParams().get("inv_no")+" / "+event.getEventParams().get("vndr_seq"));
//					throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
					throw new EventException(new ErrorHandler("TES00088").getMessage());
				}
			}

			multiAccumulatedVolume(event);

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/**
	 * Update Event Process<br>
	 * 3rdParty amount Update<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse modifyN3rdPartyAmount(Event e) throws EventException {
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    modifyN3rdPartyAmount() ============");

		try {
			dbDao.modifyN3rdPartyAmount(event);
			dbDao.modifyTmlSoDtlAmount(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/**
	 * Update Event Process <br>
	 * reject lift<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse rejectLiftTerminalInvoice(Event e) throws EventException {
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    rejectLiftTerminalInvoice() ============");

		try {
			dbDao.rejectLiftTerminalInvoice(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Update Event Process<br>
	 * MR Invoice Delete Porcess<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoice(Event e) throws EventException {
		EsdTes0013Event event=(EsdTes0013Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if(log.isDebugEnabled())log.debug("\n========== MarineTerminalInvoiceManageBCImpl    RemoveTerminalInvoice() ============");

		try {

			if(dbDao.checkTerminalInvoiceStatus(event.getTesTmlSoHdrVO())==false){
				log.error("[Invoice Status Error]  Invoice No : "+event.getTesTmlSoHdrVO().getInvNo()+"  Current Invoice Status : "+event.getTesTmlSoHdrVO().getTmlInvStsCd());
//				throw new DAOException("Check status of the invoice("+event.getTesTmlSoHdrVO().getInvNo()+"). \nPlease retrieve invoice again.");
				throw new DAOException(new ErrorHandler("TES00094", new String[]{event.getTesTmlSoHdrVO().getInvNo()}).getMessage());
			}
			
			dbDao.removeTerminalInvoice(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return eventResponse;
		} catch (DAOException de) {
			log.error("impl removeTerminalInvoice err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * ATB DATE retrieve event process
	 * MarineTerminalInvoiceManage ATB DATE retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceATBDt(Event e) throws EventException {
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		String etcxml ="";
		
		DBRowSet rowSet					=null;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTerminalInvoiceATBDt() ============");

		try {
			
			if(event.getTesCommonVo().getVvd().substring(0, 4).equalsIgnoreCase("CNTC")){
				rowSet = dbDao.searchTerminalInvoiceATBDtCntc(event.getSignOnUserAccount().getOfc_cd());	
			}else{
				rowSet = dbDao.searchTerminalInvoiceATBDtTrunk(event);	
			}
		
			if(rowSet!=null && rowSet.getRowCount()>0){
				rowSet.next();
				etcxml = rowSet.getString("ATB_DT");
			}

			etcData.put("successFlag", "SUCCESS");
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);
			eventResponse.setETCData("etcxml", etcxml);

			return eventResponse;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
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
	 * Add Event Process
	 * Invoice Header section for save ACCM Vol. Data apply
	 * User Input ACCM Vol Save
	 * 
	 * @param e EsdTes0001Event
	 * @exception EventException
	 */
	public void multiAccumulatedVolume(Event e) throws EventException{
		EsdTes0001Event event=(EsdTes0001Event)e;
		DBRowSet 	rowSet		=	null; // DB ResultSet object For data transfer
		DBRowSet 	rowSet2		=	null;
		String 		flag		=	null;

		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    multiAccumulatedVolume() ============");
		try {
			rowSet = dbDao.searchACCMUpdateData(event, event.getSignOnUserAccount().getOfc_cd());
			int x=0;
			if(rowSet.next()){
				x++;
			}
			rowSet.beforeFirst();

			if(x == 0){
				log.debug("\n\nACCM Update 대상이 아닙니다."+ x);
			}else{
				log.debug("\n\nACCM Update 대상입니다." + x);
				
				rowSet2 = dbDao.searchMarineTerminalAccumVolCase(event);
				
				if(rowSet2.next()){
					flag = rowSet2.getString("RESULT");
					log.debug("U or I ? "+flag);
				}

				if(rowSet.next()) {
					log.debug("\naccm_seq : "+rowSet.getString("accm_seq"));
					
					if(flag.endsWith("I")){
						dbDao.modifyMarineTerminalInvoiceAccumulatedVolumeInsert(rowSet.getString("accm_seq"),  event,  event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());						
					}else if(flag.endsWith("U")){
						dbDao.modifyMarineTerminalInvoiceAccumulatedVolumeUpdate(rowSet.getString("accm_seq"),  event,  event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/** MGSET COUNT Search
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchMgsetCount(Event e) throws EventException{
		log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchMgsetCount() ============");
		
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();

		TesTmlSoDtlVO	tesTmlSoDtlVO	= null;
		DBRowSet	dbRowSet = null;
//		int dtlCnt		= 0;
//		int resultCnt	= 0;
//		int mgSetCnt	= 0;

		try {
			tesTmlSoDtlVO 	= event.getTesTmlSoDtlVO();
			dbRowSet		= dbDao.searchDtlMgsetCount(tesTmlSoDtlVO);
			
			if(dbRowSet != null){
				while (dbRowSet.next()) {
					tesTmlSoDtlVO.setTmlSoDtlSeq(dbRowSet.getString("tml_so_dtl_seq"));
//					mgSetCnt = 
					dbDao.searchMgsetCount(tesTmlSoDtlVO);
				}
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
	 * Multi Event Process<br>
	 * ESD_TES_0001 multiTerminalInvoiceDetail Multi Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceDetail(Event e) throws EventException{

		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TesTmlSoDtlVO 	tesTmlSoDtlVO 	= null;
		TesTmlSoDtlVO[] tesTmlSoDtlVOs 	= null;
		
		int maxSeq 	= 0;
		int tpbCnt	= 0;
		
		try {
			log.debug("\n==========MarineTerminalInvoiceManageBCImpl    multiTerminalInvoiceDetail() ============");

			tesTmlSoDtlVO 				= event.getTesTmlSoDtlVO();
			tesTmlSoDtlVOs 				= event.getTesTmlSoDtlVOs();
			
			List<TesTmlSoDtlVO> insVoList 	= new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> updVoList 	= new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> delVoList 	= new ArrayList<TesTmlSoDtlVO>();

			if( Integer.parseInt(event.getTesCommonVo().getFCmd()) == 141 ){
				tpbCnt = dbDao.multiTerminalInvoiceDetailSearchCount(tesTmlSoDtlVO);
			
				if ( tpbCnt > 0 ) {
					throw new EventException(new ErrorHandler("TES00089").getMessage()); // [Cost Code : SVXXJO] 3rd party is not exist.
				}
			}
			
			maxSeq = dbDao.multiTerminalInvoiceCommonSeq("TML_SO_DTL_SEQ", "TES_TML_SO_DTL", "TML_SO_OFC_CTY_CD", "TML_SO_SEQ", event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd(), event.getTesTmlSoHdrVO().getTmlSoSeq());

			for( int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++ ){
				
				tpbCnt = 0;
				
				if (tesTmlSoDtlVOs[i].getIbflag().equals("I")) {
					tesTmlSoDtlVOs[i].setTmlSoDtlSeq(maxSeq+"");
					tesTmlSoDtlVOs[i].setTmlSoOfcCtyCd( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
					tesTmlSoDtlVOs[i].setTmlSoSeq( event.getTesTmlSoHdrVO().getTmlSoSeq() );
					tesTmlSoDtlVOs[i].setCreUsrId(e.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setUpdUsrId(e.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoDtlVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					if("S".equals(tesTmlSoDtlVOs[i].getCalcTpCd())){
						tesTmlSoDtlVOs[i].setCalcTpCd("M");
					}
					
					if(JSPUtil.getNull(tesTmlSoDtlVOs[i].getFmTrVolVal()).equals("")){
						tesTmlSoDtlVOs[i].setFmTrVolVal("1");
					}
					if(JSPUtil.getNull(tesTmlSoDtlVOs[i].getToTrVolVal()).equals("")){
						tesTmlSoDtlVOs[i].setToTrVolVal("9999999");
					}

					insVoList.add(tesTmlSoDtlVOs[i]);
					maxSeq++;
					
				}else if(tesTmlSoDtlVOs[i].getIbflag().equals("U")) {
					tesTmlSoDtlVOs[i].setTmlSoOfcCtyCd( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
					tesTmlSoDtlVOs[i].setTmlSoSeq( event.getTesTmlSoHdrVO().getTmlSoSeq() );
					tesTmlSoDtlVOs[i].setCreUsrId(e.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setUpdUsrId(e.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoDtlVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					if("S".equals(tesTmlSoDtlVOs[i].getCalcTpCd())){
						tesTmlSoDtlVOs[i].setCalcTpCd("M");
					}
					
					if(JSPUtil.getNull(tesTmlSoDtlVOs[i].getFmTrVolVal()).equals("")){
						tesTmlSoDtlVOs[i].setFmTrVolVal("1");
					}
					if(JSPUtil.getNull(tesTmlSoDtlVOs[i].getToTrVolVal()).equals("")){
						tesTmlSoDtlVOs[i].setToTrVolVal("9999999");
					}
	
					updVoList.add(tesTmlSoDtlVOs[i]);
					
				}else if(tesTmlSoDtlVOs[i].getIbflag().equals("D")) {
					tesTmlSoDtlVOs[i].setCreUsrId(e.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setUpdUsrId(e.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoDtlVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					delVoList.add(tesTmlSoDtlVOs[i]);
				}

			}//end for( int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++ ) 				

			dbDao.multiTerminalInvoiceDetailInsert(insVoList);
			dbDao.multiTerminalInvoiceDetailUpdate(updVoList);
			dbDao.multiTerminalInvoiceDetailDelete(delVoList);

			return eventResponse;
		}catch(EventException ee) {
			log.error("err "+ee.toString(),ee);
			throw ee;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(ex.getMessage());
		} 
		
	}

	/** multiTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiTerminalInvoiceDBVerify(Event e) throws EventException{
		EsdTes0001Event event = (EsdTes0001Event)e;
		DBRowSet dbRowSet					=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		TesTmlSoCntrListVO  tesTmlSoCntrListVO = null;
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    multiTerminalInvoiceDBVerify() ============");

		try {
			String costCdFtrRmk = new TESInvoiceCommonBCImpl().selectCostCdFtrRmk(event.getTesTmlSoHdrVO());
			event.getTesTmlSoHdrVO().setCostCdFtrRmk(costCdFtrRmk);
			
			dbRowSet = dbDao.dBCheckTerminalInvoice(event.getTesTmlSoHdrVO(), event.getTesTmlSoCntrListVO(), event.getTesCommonVo());
			
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			if(dbRowSet!=null && dbRowSet.getRowCount()>0){
				
				while (dbRowSet.next()) {
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
					
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(event.getTesTmlSoCntrListVO().getTmlSoOfcCtyCd());
					tesTmlSoCntrListVO.setTmlSoSeq(event.getTesTmlSoCntrListVO().getTmlSoSeq());
					tesTmlSoCntrListVO.setVslCd(event.getTesCommonVo().getVvd().substring(0, 4));
					tesTmlSoCntrListVO.setSkdVoyNo(event.getTesCommonVo().getVvd().substring(4, 8));
					tesTmlSoCntrListVO.setSkdDirCd(event.getTesCommonVo().getVvd().substring(8, 9));
					tesTmlSoCntrListVO.setCntrNo(dbRowSet.getString("cntr_no"));
					
					tesTmlSoCntrListVO.setVrfyRsltIndCd("DC") ;	
					tesTmlSoCntrListVO.setDscrIndCd("DB");		
					tesTmlSoCntrListVO.setCntrRmk("Double billing Inv : " + dbRowSet.getString("inv_no"));	

					tesTmlSoCntrListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					updateVOList.add(tesTmlSoCntrListVO);
				}

			}
			
			dbDao.multiTerminalInvoiceDBVerify(updateVOList);
			
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
	
	/**
	 * Add Event Process<br>
	 * Rvis Flg Update Porcess<br>
	 *
	 * @param e EsdTes9032Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse updateContainerListRvisFlg(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    updateContainerListRvisFlg() ============");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9032Event 		event			=(EsdTes9032Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 		= new HashMap<String, String>();
		
		TesTmlSoHdrVO 			tesTmlSoHdrVO 		= null;
		TesTmlSoCntrListVO 		tesTmlSoCntrListVO 	= null;
		MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs = null;

		try {
			tesTmlSoHdrVO 					= event.getTesTmlSoHdrVO();
			marineTerminalInvoiceCommonVOs 	= event.getMarineTerminalInvoiceCommonVOs();
			
			List<TesTmlSoCntrListVO> voList = new ArrayList<TesTmlSoCntrListVO>();

			for( int i=0; marineTerminalInvoiceCommonVOs!=null && i<marineTerminalInvoiceCommonVOs.length; i++ ){
				tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
log.debug("marineTerminalInvoiceCommonVOs[i].getRvisIndFlg()=====>"+marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());	

				//rvis_ind_flg
				tesTmlSoCntrListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
				tesTmlSoCntrListVO.setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoCntrListVO.setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq() );
				tesTmlSoCntrListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
				tesTmlSoCntrListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
				tesTmlSoCntrListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
				tesTmlSoCntrListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
				tesTmlSoCntrListVO.setTmlSoCntrListSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoCntrListSeq());
				
				voList.add(tesTmlSoCntrListVO);
			}			
			
			dbDao.updateContainerListRvisFlg(voList, event.getTesTmlSoDtlVO().getLgsCostCd());
			dbDao.updateMarineTerminalRvisVol(event.getTesTmlSoDtlVO());
			
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Add Event Process<br>
	 * Rvis Flag Update Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateContainerListRvisFlgManual(Event e) throws EventException {
		log.debug("\n==========MarineTerminalInvoiceManageBCImpl    updateContainerListRvisFlgManual() ============");
		EsdTes9032Event event=(EsdTes9032Event)e;
		int maxSeq = 0;
		
		MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs = null;
		TesTmlSoRvisListVO tesTmlSoRvisListVO = null;
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 	= new HashMap<String, String>();
		
		try {
			maxSeq = dbDao.multiTerminalInvoiceRvisSeq(event.getTesTmlSoDtlVO());
			marineTerminalInvoiceCommonVOs 	= event.getMarineTerminalInvoiceCommonVOs();
			
			List<TesTmlSoRvisListVO> insVoList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updVoList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> delVoList = new ArrayList<TesTmlSoRvisListVO>();

log.debug("marineTerminalInvoiceCommonVOs===>"+marineTerminalInvoiceCommonVOs);

for( int i=0; marineTerminalInvoiceCommonVOs!=null && i<marineTerminalInvoiceCommonVOs.length; i++ ){
				tesTmlSoRvisListVO = new TesTmlSoRvisListVO();
				
				if("I".equals(marineTerminalInvoiceCommonVOs[i].getIbflag())){
					tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					
					tesTmlSoRvisListVO.setTmlSoRvisListSeq(maxSeq+"");
					tesTmlSoRvisListVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());

					tesTmlSoRvisListVO.setTmlInvTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlInvTpCd());
					tesTmlSoRvisListVO.setCalcCostGrpCd(marineTerminalInvoiceCommonVOs[i].getRvisCalcCostGrpCd());
					tesTmlSoRvisListVO.setTmlRvisTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlRvisTpCd());
					tesTmlSoRvisListVO.setLgsCostCd(marineTerminalInvoiceCommonVOs[i].getRvisLgsCostCd());
					tesTmlSoRvisListVO.setCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCntrNo());
					tesTmlSoRvisListVO.setCntrTpszCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd());
					tesTmlSoRvisListVO.setCntrStyCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrStyCd());
					tesTmlSoRvisListVO.setBkgNo(marineTerminalInvoiceCommonVOs[i].getRvisBkgNo());
					
					tesTmlSoRvisListVO.setVslCd(marineTerminalInvoiceCommonVOs[i].getRvisVslCd());
					tesTmlSoRvisListVO.setSkdVoyNo(marineTerminalInvoiceCommonVOs[i].getRvisSkdVoyNo());
					tesTmlSoRvisListVO.setSkdDirCd(marineTerminalInvoiceCommonVOs[i].getRvisSkdDirCd());
	/*				
					tesTmlSoRvisListVO.setVslCd(event.getTesCommonVo().getVvd().substring(0, 4));
					tesTmlSoRvisListVO.setSkdVoyNo(event.getTesCommonVo().getVvd().substring(4, 8));
					tesTmlSoRvisListVO.setSkdDirCd(event.getTesCommonVo().getVvd().substring(8));				
	*/
					tesTmlSoRvisListVO.setCuzCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCuzCntrNo());
					tesTmlSoRvisListVO.setRhndRsnCd(marineTerminalInvoiceCommonVOs[i].getRvisRhndRsnCd());
					tesTmlSoRvisListVO.setRvisRmk(marineTerminalInvoiceCommonVOs[i].getRvisRmk());
					tesTmlSoRvisListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
					
					tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					insVoList.add(tesTmlSoRvisListVO);
					maxSeq++;
					
				}else if("U".equals(marineTerminalInvoiceCommonVOs[i].getIbflag())){
					tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					
					tesTmlSoRvisListVO.setTmlSoRvisListSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoRvisListSeq());
					tesTmlSoRvisListVO.setTmlSoDtlSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoDtlSeq());

					tesTmlSoRvisListVO.setTmlInvTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlInvTpCd());
					tesTmlSoRvisListVO.setCalcCostGrpCd(marineTerminalInvoiceCommonVOs[i].getRvisCalcCostGrpCd());
					tesTmlSoRvisListVO.setTmlRvisTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlRvisTpCd());
					tesTmlSoRvisListVO.setLgsCostCd(marineTerminalInvoiceCommonVOs[i].getRvisLgsCostCd());
					tesTmlSoRvisListVO.setCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCntrNo());
					tesTmlSoRvisListVO.setCntrTpszCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd());
					tesTmlSoRvisListVO.setCntrStyCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrStyCd());
					tesTmlSoRvisListVO.setBkgNo(marineTerminalInvoiceCommonVOs[i].getRvisBkgNo());
					
					tesTmlSoRvisListVO.setVslCd(marineTerminalInvoiceCommonVOs[i].getRvisVslCd());
					tesTmlSoRvisListVO.setSkdVoyNo(marineTerminalInvoiceCommonVOs[i].getRvisSkdVoyNo());
					tesTmlSoRvisListVO.setSkdDirCd(marineTerminalInvoiceCommonVOs[i].getRvisSkdDirCd());
	/*				
					tesTmlSoRvisListVO.setVslCd(event.getTesCommonVo().getVvd().substring(0, 4));
					tesTmlSoRvisListVO.setSkdVoyNo(event.getTesCommonVo().getVvd().substring(4, 8));
					tesTmlSoRvisListVO.setSkdDirCd(event.getTesCommonVo().getVvd().substring(8));				
	*/
					tesTmlSoRvisListVO.setCuzCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCuzCntrNo());
					tesTmlSoRvisListVO.setRhndRsnCd(marineTerminalInvoiceCommonVOs[i].getRvisRhndRsnCd());
					tesTmlSoRvisListVO.setRvisRmk(marineTerminalInvoiceCommonVOs[i].getRvisRmk());
					tesTmlSoRvisListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
					
					tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					updVoList.add(tesTmlSoRvisListVO);
					
				}else if("D".equals(marineTerminalInvoiceCommonVOs[i].getIbflag())){
					tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());

					tesTmlSoRvisListVO.setTmlSoRvisListSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoRvisListSeq());
					tesTmlSoRvisListVO.setTmlSoDtlSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoDtlSeq());

					tesTmlSoRvisListVO.setTmlInvTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlInvTpCd());
					tesTmlSoRvisListVO.setCalcCostGrpCd(marineTerminalInvoiceCommonVOs[i].getRvisCalcCostGrpCd());
					tesTmlSoRvisListVO.setTmlRvisTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlRvisTpCd());
					tesTmlSoRvisListVO.setLgsCostCd(marineTerminalInvoiceCommonVOs[i].getRvisLgsCostCd());
					tesTmlSoRvisListVO.setCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCntrNo());
					tesTmlSoRvisListVO.setCntrTpszCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd());
					tesTmlSoRvisListVO.setCntrStyCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrStyCd());
					tesTmlSoRvisListVO.setBkgNo(marineTerminalInvoiceCommonVOs[i].getRvisBkgNo());
					
					tesTmlSoRvisListVO.setVslCd(marineTerminalInvoiceCommonVOs[i].getRvisVslCd());
					tesTmlSoRvisListVO.setSkdVoyNo(marineTerminalInvoiceCommonVOs[i].getRvisSkdVoyNo());
					tesTmlSoRvisListVO.setSkdDirCd(marineTerminalInvoiceCommonVOs[i].getRvisSkdDirCd());
	/*				
					tesTmlSoRvisListVO.setVslCd(event.getTesCommonVo().getVvd().substring(0, 4));
					tesTmlSoRvisListVO.setSkdVoyNo(event.getTesCommonVo().getVvd().substring(4, 8));
					tesTmlSoRvisListVO.setSkdDirCd(event.getTesCommonVo().getVvd().substring(8));				
	*/
					tesTmlSoRvisListVO.setCuzCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCuzCntrNo());
					tesTmlSoRvisListVO.setRhndRsnCd(marineTerminalInvoiceCommonVOs[i].getRvisRhndRsnCd());
					tesTmlSoRvisListVO.setRvisRmk(marineTerminalInvoiceCommonVOs[i].getRvisRmk());
					tesTmlSoRvisListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
					
					tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					delVoList.add(tesTmlSoRvisListVO);
				}				
			}				

			dbDao.multiTerminalInvoiceRvisInsert(insVoList);
			dbDao.multiTerminalInvoiceRvisUpdate(updVoList);
			dbDao.multiTerminalInvoiceRvisDelete(delVoList);
			
			dbDao.updateMarineTerminalRvisVol(event.getTesTmlSoDtlVO());
			
			etcData.put("successFlag","SUCCESS");
			eventResponse.setETCData(etcData);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	      	
	
	
	/**
	 * Add Event Process<br>
	 * Container List Search <br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		int maxSeq = 1;
		
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();
		
		List<TesTmlSoCntrListVO> insVoList 			= new ArrayList<TesTmlSoCntrListVO>();
		List<TesTmlSoCntrListVO> delVoList 			= new ArrayList<TesTmlSoCntrListVO>();
		List<TesTmlSoCntrListVO> updVoList 			= new ArrayList<TesTmlSoCntrListVO>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    multiTerminalInvoiceContainerList() ============");

		try {
			maxSeq = dbDao.multiTerminalInvoiceCommonSeq("TML_SO_CNTR_LIST_SEQ", "TES_TML_SO_CNTR_LIST", "TML_SO_OFC_CTY_CD", "TML_SO_SEQ", event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd(), event.getTesTmlSoHdrVO().getTmlSoSeq());
log.debug("maxSeq===>"+maxSeq);			
log.debug("tesTmlSoCntrListVOs===>"+tesTmlSoCntrListVOs);

			for(int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++){
				if(tesTmlSoCntrListVOs[i].getIbflag().equals("I")){
					tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoCntrListVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq(maxSeq+"");
					
					tesTmlSoCntrListVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoCntrListVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					insVoList.add(tesTmlSoCntrListVOs[i]);
					maxSeq++;
					
				}else if(tesTmlSoCntrListVOs[i].getIbflag().equals("U")){
					tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoCntrListVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					
					tesTmlSoCntrListVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					updVoList.add(tesTmlSoCntrListVOs[i]);
				}else if(tesTmlSoCntrListVOs[i].getIbflag().equals("D")){
					delVoList.add(tesTmlSoCntrListVOs[i]);
					
				}
			}
			
			dbDao.multiTerminalInvoiceContainerListInsert(insVoList, event.getTesTmlSoDtlVO().getIoBndCd());
			dbDao.multiTerminalInvoiceContainerListUpdate(updVoList);
			dbDao.multiTerminalInvoiceContainerListDelete(delVoList);
			
			//dbDao.multiTerminalInvoiceContainerList(event.getTempTesN3rdPtyIfVOs(), event.getEventParams(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/**
	 * Add Event Process<br>
	 * removeTerminalInvoiceContainerList Delete<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    removeTerminalInvoiceContainerList() ============");

		try {
			dbDao.removeTerminalInvoiceContainerList(event);
			dbDao.removeTerminalInvoiceN3RDList(event);
			dbDao.removeTerminalInvoiceRvisList(event);
			dbDao.removeTerminalInvoiceCostCalculation(event);
			dbDao.removeTerminalInvoiceVVDList(event);

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Add Event Process<br>
	 * ESD_TES_001Add Event Process<br>
	 * removeTerminalInvoiceContainerList difference : VVD List does not delete.
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    removeTerminalInvoiceContainerList2() ============");

		try {
			dbDao.removeTerminalInvoiceContainerList(event);
			dbDao.removeTerminalInvoiceN3RDList(event);
			dbDao.removeTerminalInvoiceRvisList(event);
			dbDao.removeTerminalInvoiceCostCalculation(event);

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Add Event Process<br>
	 * ESD_TES_0001 Add Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceCosts(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    removeTerminalInvoiceCosts() ============");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event=(EsdTes0001Event)e;
		TesTmlSoDtlVO[] tesTmlSoDtlVOs = null;
		TesTmlSoHdrVO	tesTmlSoHdrVO = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			tesTmlSoDtlVOs 	= event.getTesTmlSoDtlVOs();
			tesTmlSoHdrVO	= event.getTesTmlSoHdrVO();
			
			List<TesTmlSoDtlVO> voList = new ArrayList<TesTmlSoDtlVO>();

			for( int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++ ){
				tesTmlSoDtlVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoDtlVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );

				tesTmlSoDtlVOs[i].setVslCd(event.getTesCommonVo().getVvd().substring(0, 4));
				tesTmlSoDtlVOs[i].setSkdVoyNo(event.getTesCommonVo().getVvd().substring(4, 8));
				tesTmlSoDtlVOs[i].setSkdDirCd(event.getTesCommonVo().getVvd().substring(8, 9));
				tesTmlSoDtlVOs[i].setIoBndCd(event.getTesTmlSoDtlVO().getIoBndCd());
				
				tesTmlSoDtlVOs[i].setCreUsrId(e.getSignOnUserAccount().getUsr_id());
				tesTmlSoDtlVOs[i].setUpdUsrId(e.getSignOnUserAccount().getUsr_id());
				
				voList.add(tesTmlSoDtlVOs[i]); 
			}				
			
log.debug("event.getMarineTerminalInvoiceCommonVO().getDeleteMode()===>"+event.getMarineTerminalInvoiceCommonVO().getDeleteMode());			
			if(event.getMarineTerminalInvoiceCommonVO().getDeleteMode().equals("ROW")){
				dbDao.removeTerminalInvoiceN3RDList(voList, event.getMarineTerminalInvoiceCommonVO().getDeleteMode());
				dbDao.removeTerminalInvoiceRvisList(voList, event.getMarineTerminalInvoiceCommonVO().getDeleteMode());
				dbDao.removeTerminalInvoiceCostCalculation(voList, event.getMarineTerminalInvoiceCommonVO().getDeleteMode());
			}else{
				dbDao.removeTerminalInvoiceN3RDList(event);
				dbDao.removeTerminalInvoiceRvisList(event);
				dbDao.removeTerminalInvoiceCostCalculation(event);
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}
	/**
	 * Add Event Process<br>
	 * ESD_TES_0001 Add Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @exception EventException
	 */
	public void multiTerminalInvoiceVVD(Event e) throws EventException{
		EsdTes0001Event event=(EsdTes0001Event)e;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    multiTerminalInvoiceVVD() ============");

		try {
			dbDao.multiTerminalInvoiceVVD(event.getTesTmlSoHdrVO(),event.getTesTmlSoCntrListVO(), event.getTesCommonVo(), event.getSignOnUserAccount().getUsr_id());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Add Event Process<br>
	 * ESD_TES_9010 Add Event Process<br>
	 *
	 * @param e EsdTes9010Event
	 * @exception EventException
	 */
	public void createTerminalInvoiceVVD(Event e) throws EventException{
		EsdTes9010Event event=(EsdTes9010Event)e;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    multiTerminalInvoiceVVD() ============");

		try {
			dbDao.multiTerminalInvoiceVVD(event.getTesTmlSoHdrVO(), event.getTesTmlSoCntrListVO(), event.getTesCommonVO(), event.getSignOnUserAccount().getUsr_id());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

//	public void multiTerminalInvoiceVVD(Event e) throws EventException{
//		EsdTes0001Event event=(EsdTes0001Event)e;
//		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    multiTerminalInvoiceVVD() ============");
//
//		try {
//			dbDao.multiTerminalInvoiceVVD(event. event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * TerminalInvoiceCalculationList  retrieve event process
	 * ESD_TES_0001 TerminalInvoiceCalculationList  retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse ESD_TES_0001EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateTerminalInvoiceCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event 		event			=(EsdTes0001Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		List<DBRowSet>  		arrList 		= new ArrayList<DBRowSet>();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    calculateTerminalInvoiceCost() ");
		
		DBRowSet[] rowSetArr = new DBRowSet[3];
		String agmtCostYN = "";
		
		try {
			
			agmtCostYN = dbDao.searchTerminalInvoiceAgmtCost(event.getTesTmlSoHdrVO());
			
			rowSetArr[0] = dbDao.calculateTerminalInvoiceCost(event, agmtCostYN);
			rowSetArr[1] = dbDao.searchTerminalInvoiceTotalAmount(event.getTesTmlSoHdrVO());
			rowSetArr[2] = dbDao.searchTerminalInvoiceTotalAmountForPopup(event.getTesTmlSoDtlVO());
			
			arrList.add(rowSetArr[0]);
			arrList.add(rowSetArr[1]);
			arrList.add(rowSetArr[2]);
			
			eventResponse.setRsList(arrList);
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/**
	 * VVD Validate Event Process<br>
	 * MarineTerminalInvoiceManage Check save VVD<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse checkMissingVVD(Event e) throws EventException {
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new  GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    checkMissingVVD() ============");

		try {
			rowSet = dbDao.checkMissingVVD(event);
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Accumulate Vol retrieve event process
	 * MarineTerminalInvoiceManage Accumulate Vol retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccumulatedVolume(Event e) throws EventException {

		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchAccumulatedVolume() ============");

		try {
			rowSet = dbDao.searchAccumulatedVolume(event.getTesTmlSoHdrVO(), event.getTesCommonVo(), event.getSignOnUserAccount().getOfc_cd());
			
			eventResponse.setRs(rowSet);
			
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


//	/**
//	 * Account Code retrieve event process
//	 * MarineTerminalInvoiceManage Account Code retrieve event process
//	 *
//	 * @param e EsdTes0001Event
//	 * @return response GeneralEventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOtherCarrierAccountCode(Event e) throws EventException {
//
//		EsdTes0001Event event=(EsdTes0001Event)e;
//		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
//		DBRowSet rowSet=null;
//		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchOtherCarrierAccountCode() ============");
//
//		try {
//			rowSet = dbDao.searchOtherCarrierAccountCode(event);
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * Revised Container Division retrieve event process
	 * MarineTerminalInvoiceManage Revised Container Division retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRvisDivision(Event e) throws EventException {

		EsdTes0001Event event=(EsdTes0001Event)e;
		DBRowSet rowSet = null;
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 	= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchManualRvisDivision() ============");

		try {
			rowSet = dbDao.searchManualRvisDivision(event.getMarineTerminalInvoiceCommonVO());
			etcData.put("successFlag", "SUCCESS" );
			rowSet.next();

			eventResponse.setETCData("etcxml", rowSet.getString("rvis_cntr_list_cd"));
			eventResponse.setRs(rowSet);
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


//	/**
//	 * CostCalcComboCodeList retrieve event process
//	 * MarineTerminalInvoiceManage CostCalcComboCodeList retrieve event process
//	 *
//	 * @param e EsdTes0001Event
//	 * @return response ESD_TES_001EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchTerminalInvoiceCostCalcComboCodeList(Event e) throws EventException {
//		EsdTes0001Event event=(EsdTes0001Event)e;
//		DBRowSet LaneRowSet			=null;
//		DBRowSet CntrTypeSizeRowSet	=null;
//		DBRowSet CarrierRowSet		=null;
//		DBRowSet CostCodeRowSet		=null;
//		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
//		
//		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTerminalInvoiceCostCalcComboCodeList() ============");
//
//		try {
//			LaneRowSet 			= dbDao.searchLaneCodeList(event.getEventParams());
//			CntrTypeSizeRowSet 	= dbDao.searchCntrTypeSizeList();
//			CarrierRowSet 		= dbDao.searchCarrierCodeList();
//			CostCodeRowSet 		= dbDao.searchCostCodeList();
//
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMPforReverify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    createTES_FILE_IMP_TMPforReverify() ============");

		// DB ResultSet object For data transfer
		try {
			dbDao.createTES_FILE_IMP_TMPforReverify(event);
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/**
	 * reVerifyTerminalInvoiceContainerList Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse reVerifyTerminalInvoiceContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    reVerifyTerminalInvoiceContainerList() ============");
//		 DB ResultSet object For data transfer
		
		DBRowSet rowSet=null;
		try {
			rowSet = dbDao.reVerifyTerminalInvoiceContainerList(event);
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Delete Event Porcess<br>
	 * Re-Verify시 TES_FILE_IMP_TMP Delete<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse ESD_TES_0001EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event 		event=(EsdTes0001Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 		= new HashMap<String, String>();

		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    removeTES_FILE_IMP_TMP2() ============");

		// DB ResultSet object For data transfer
		try {
			dbDao.removeTES_FILE_IMP_TMP(event.getTesTmlSoCntrListVO());

			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Save Event Process<br>
	 * Details Re-Verify TES_TML_SO_CNTR_LIST Save<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceContainerList2(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    createTerminalInvoiceContainerList() ============");

		EsdTes0001Event event=(EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		HashMap<String, String> etcData = new HashMap<String, String>();
		DBRowSet dbRowSet = null;
		int maxSeq = 0;

		// DB ResultSet object For data transfer
		try {
			maxSeq = dbDao.createTerminalInvoiceContainerListSeq(event.getTesTmlSoCntrListVO());
				
			dbRowSet = event.getRowSet();
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();		
					    
		    if(dbRowSet != null){
log.debug("dbRowSet.getRowCount()====>"+dbRowSet.getRowCount());
log.debug("dbRowSet"+dbRowSet);
log.debug("event.getTesTmlSoHdrVO()===>"+event.getTesTmlSoHdrVO());
log.debug("event.getTesTmlSoCntrListVO()getTmlSoOfcCtyCd===>"+event.getTesTmlSoCntrListVO().getTmlSoOfcCtyCd());
log.debug("event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd===>"+event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());		    	
		    	
				while (dbRowSet.next()) {
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
					
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoCntrListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesTmlSoCntrListVO.setTmlSoCntrListSeq(maxSeq+"");
					tesTmlSoCntrListVO.setVrfyRsltIndCd(dbRowSet.getString("vrfy_rslt_ind_cd")) ;	
					tesTmlSoCntrListVO.setDscrIndCd(dbRowSet.getString("dscr_ind_cd"));		
					tesTmlSoCntrListVO.setDscrDtlIndCd(dbRowSet.getString("dscr_dtl_ind_cd"));	
					tesTmlSoCntrListVO.setVslCd(dbRowSet.getString("vsl_cd"));			
					tesTmlSoCntrListVO.setSkdVoyNo(dbRowSet.getString("skd_voy_no"));		
					tesTmlSoCntrListVO.setSkdDirCd(dbRowSet.getString("skd_dir_cd"));		
					tesTmlSoCntrListVO.setIoBndCd(dbRowSet.getString("io_bnd_cd"));		
					tesTmlSoCntrListVO.setIocCd(dbRowSet.getString("ioc_cd"));		
					tesTmlSoCntrListVO.setSubTrdCd(dbRowSet.getString("sub_trd_cd"));           //2016.09.22 Add 
					tesTmlSoCntrListVO.setLaneCd(dbRowSet.getString("lane_cd"));			
					tesTmlSoCntrListVO.setAtbDt(dbRowSet.getString("atb_dt"));			
					tesTmlSoCntrListVO.setCntrNo(dbRowSet.getString("cntr_no"));			
					tesTmlSoCntrListVO.setCntrTpszCd(dbRowSet.getString("cntr_tpsz_cd"));		
					tesTmlSoCntrListVO.setCntrStyCd(dbRowSet.getString("cntr_sty_cd"));		
					tesTmlSoCntrListVO.setLoclTsIndCd(dbRowSet.getString("locl_ts_ind_cd"));	
					tesTmlSoCntrListVO.setRcvdeTermIndCd(dbRowSet.getString("rcvde_term_ind_cd"));
					tesTmlSoCntrListVO.setDcgoClssCd(dbRowSet.getString("dcgo_clss_cd"));		
					tesTmlSoCntrListVO.setBbCgoFlg(dbRowSet.getString("bb_cgo_flg"));		
					tesTmlSoCntrListVO.setAwkCgoFlg(dbRowSet.getString("awk_cgo_flg"));		
					tesTmlSoCntrListVO.setRcFlg(dbRowSet.getString("rc_flg"));			
					tesTmlSoCntrListVO.setWrkDt(dbRowSet.getString("wrk_dt"));			
					tesTmlSoCntrListVO.setBkgNo(dbRowSet.getString("bkg_no"));				
					tesTmlSoCntrListVO.setBlNo(dbRowSet.getString("bl_no"));				
					tesTmlSoCntrListVO.setCntrRmk(dbRowSet.getString("cntr_rmk"));			
					tesTmlSoCntrListVO.setTmlTrnsModCd(dbRowSet.getString("tml_trns_mod_cd"));
					tesTmlSoCntrListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoCntrListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					insertVOList.add(tesTmlSoCntrListVO);
					maxSeq++;
				}
		    }
					    
			dbDao.createTerminalInvoiceContainerList(insertVOList);			
			etcData.put("successFlag", "SUCCESS" );
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
	 * ESD Handling for the end of working scenario<br>
	 * MarineTerminalInvoiceManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		dbDao = null;
	}


	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e EsdTes9010Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n========== start MarineTerminalInvoiceManageBCImpl    createTES_FILE_IMP_TMP() ============");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event 		event			=(EsdTes9010Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		TesTmlSoHdrVO 			tesTmlSoHdrVO 		= null;
		TesFileImpTmpVO[]		tesFileImpTmpVOs	= null;
		TesFileImpTmpVO			tesFileImpTmpVO		= null;
		
		
		int ins_idx = 0;

		// DB ResultSet object For data transfer
		try {
			tesTmlSoHdrVO 		= event.getTesTmlSoHdrVO();
			tesFileImpTmpVOs 	= event.getTesFileImpTmpVOs();
			
			List<TesFileImpTmpVO> insertVOList = new ArrayList<TesFileImpTmpVO>();
			ins_idx 	= dbDao.createTES_FILE_IMP_TMP_getSeq(event);
			
			if(tesFileImpTmpVOs==null || (tesFileImpTmpVOs!=null && tesFileImpTmpVOs.length==0)){
				tesFileImpTmpVO = new TesFileImpTmpVO();
				
				tesFileImpTmpVO.setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesFileImpTmpVO.setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				tesFileImpTmpVO.setTmlSoTmpSeq(String.valueOf(++ins_idx));
				tesFileImpTmpVO.setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
				tesFileImpTmpVO.setYdCd(event.getTesTmlSoHdrVO().getYdCd());
				tesFileImpTmpVO.setVvdCd(event.getTesCommonVO().getVvd());
				tesFileImpTmpVO.setCreUsrId(e.getSignOnUserAccount().getUsr_id());
				tesFileImpTmpVO.setUpdUsrId(e.getSignOnUserAccount().getUsr_id());

				insertVOList.add(tesFileImpTmpVO); 
				
			}else{
				for( int i=0; tesFileImpTmpVOs!=null && i<tesFileImpTmpVOs.length; i++ ){
					tesFileImpTmpVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
					tesFileImpTmpVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
					
					tesFileImpTmpVOs[i].setTmlSoTmpSeq(String.valueOf(++ins_idx));
					tesFileImpTmpVOs[i].setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
					tesFileImpTmpVOs[i].setYdCd(event.getTesTmlSoHdrVO().getYdCd());
					tesFileImpTmpVOs[i].setVvdCd(event.getTesCommonVO().getVvd());
					tesFileImpTmpVOs[i].setCreUsrId(e.getSignOnUserAccount().getUsr_id());
					tesFileImpTmpVOs[i].setUpdUsrId(e.getSignOnUserAccount().getUsr_id());
					
					insertVOList.add(tesFileImpTmpVOs[i]); 
				}	
			}

			dbDao.createTES_FILE_IMP_TMP(insertVOList);
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process
	 * CNTR Number Search<br>
	 *
	 * @param e EsdTes9010Event
	 * @return EventResponse ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event 		event		=(EsdTes9010Event)e;
		HashMap<String, String> etcData 	= new HashMap<String, String>();
		GeneralEventResponse 	eventResponse = new GeneralEventResponse();
		
		DBRowSet rowSet = null;

		if(log.isDebugEnabled())log.debug("\n ========== MarineTerminalInvoiceManageBCImpl    searchCNTRNumber() ============");

		// DB ResultSet object For data transfer
		try {
			rowSet = dbDao.searchCNTRNumber(event);
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e EsdTes9010Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event 		event			=(EsdTes9010Event)e;
		GeneralEventResponse	eventResponse 	= new GeneralEventResponse(); 
		DBRowSet rowSet = null;

		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTES_FILE_IMP_TMP() ============");

		// DB ResultSet object For data transfer
		try {
			rowSet = dbDao.searchTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO());
			eventResponse.setRs(rowSet);
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Update Event Process<br>
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse GeneralEventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n==========start MarineTerminalInvoiceManageBCImpl    updateCNTRNumber() ============");

		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event event=(EsdTes9010Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesFileImpTmpVO[] tesFileImpTmpVOs = null;
		DBRowSet dbRowSet = null;
		HashMap<String, String> etcData = new HashMap<String, String>();
 

		// DB ResultSet object For data transfer
		try {
			
			tesTmlSoHdrVO 		= event.getTesTmlSoHdrVO();
			tesFileImpTmpVOs 	= event.getTesFileImpTmpVOs();
			dbRowSet			= event.getRowSet();
			
			List<TesFileImpTmpVO> insertVOList = new ArrayList<TesFileImpTmpVO>();

log.debug("dbRowSet====>"+dbRowSet);			

		    int i = 0; //
			while (dbRowSet != null && dbRowSet.next()) {
				tesFileImpTmpVOs[i].setTmlSoOfcCtyCd( dbRowSet.getString("tml_so_ofc_cty_cd") );
				tesFileImpTmpVOs[i].setTmlSoSeq( dbRowSet.getString("tml_so_seq") );
				tesFileImpTmpVOs[i].setTmlSoTmpSeq(dbRowSet.getString("tml_so_tmp_seq"));
				tesFileImpTmpVOs[i].setCntrNo(dbRowSet.getString("mst_cntr_no"));
				tesFileImpTmpVOs[i].setUpdUsrId(e.getSignOnUserAccount().getUsr_id());

log.debug("tesFileImpTmpVOs[i].getTmlSoOfcCtyCd()===>"+tesFileImpTmpVOs[i].getTmlSoOfcCtyCd());
log.debug("tesFileImpTmpVOs[i].getTmlSoSeq()===>"+tesFileImpTmpVOs[i].getTmlSoSeq());
log.debug("tesFileImpTmpVOs[i].getTmlSoTmpSeq()===>"+tesFileImpTmpVOs[i].getTmlSoTmpSeq());
log.debug("tesFileImpTmpVOs[i].getCntrNo()===>"+tesFileImpTmpVOs[i].getCntrNo());

				insertVOList.add(tesFileImpTmpVOs[i]);
				i++;
			}
			
			dbDao.updateCNTRNumber(insertVOList);
			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		}catch (SQLException se) {
			log.error("err "+se.toString(), se);
			throw new EventException(se.getMessage());
		}catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}

	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_901Event
	 * @return EventResponse ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse checkTerminalInvoiceContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event event	= (EsdTes9010Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		DBRowSet 	rowSet 	= null;

		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    checkTerminalInvoiceContainerList() ============");

		// DB ResultSet object For data transfer
		try {
			log.error("kkkkk : "+event.getMarineTerminalInvoiceCommonVO().getVvdType());
			if(event.getMarineTerminalInvoiceCommonVO().getVvdType().equalsIgnoreCase("H") || event.getMarineTerminalInvoiceCommonVO().getVvdType().equalsIgnoreCase("C")){
				rowSet = dbDao.verifyTerminalInvoiceContainerList(event);				
			}else{
				rowSet = dbDao.verifyTerminalInvoiceContainerListCNTC(event);
			}			
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e EsdTes9010Event
	 * @return EventResponse ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event event=(EsdTes9010Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		HashMap<String, String> etcData = new HashMap<String, String>();
		DBRowSet dbRowSet = null;
		int maxSeq = 0;

		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    createTerminalInvoiceContainerList() ============");

		// DB ResultSet object For data transfer
		try {
			
			
			maxSeq = dbDao.createTerminalInvoiceContainerListSeq(event.getTesTmlSoCntrListVO());
log.debug("maxSeq==============>"+maxSeq);
	
			dbRowSet = event.getRowSet();
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();		

		    if(dbRowSet != null){
log.debug("dbRowSet.getRowCount()====>"+dbRowSet.getRowCount());
log.debug("dbRowSet"+dbRowSet);
log.debug("event.getTesTmlSoHdrVO()===>"+event.getTesTmlSoHdrVO());
log.debug("event.getTesTmlSoCntrListVO()getTmlSoOfcCtyCd===>"+event.getTesTmlSoCntrListVO().getTmlSoOfcCtyCd());
log.debug("event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd===>"+event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());

		    	while (dbRowSet.next()) {
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
					
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoCntrListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesTmlSoCntrListVO.setTmlSoCntrListSeq(maxSeq+"");
					tesTmlSoCntrListVO.setVrfyRsltIndCd(dbRowSet.getString("vrfy_rslt_ind_cd")) ;	
					tesTmlSoCntrListVO.setDscrIndCd(dbRowSet.getString("dscr_ind_cd"));		
					tesTmlSoCntrListVO.setDscrDtlIndCd(dbRowSet.getString("dscr_dtl_ind_cd"));	
					tesTmlSoCntrListVO.setVslCd(dbRowSet.getString("vsl_cd"));			
					tesTmlSoCntrListVO.setSkdVoyNo(dbRowSet.getString("skd_voy_no"));		
					tesTmlSoCntrListVO.setSkdDirCd(dbRowSet.getString("skd_dir_cd"));		
					tesTmlSoCntrListVO.setIoBndCd(dbRowSet.getString("io_bnd_cd"));		
					tesTmlSoCntrListVO.setIocCd(dbRowSet.getString("ioc_cd"));			
					tesTmlSoCntrListVO.setLaneCd(dbRowSet.getString("lane_cd"));
					tesTmlSoCntrListVO.setSubTrdCd(dbRowSet.getString("sub_trd_cd"));
					tesTmlSoCntrListVO.setAtbDt(dbRowSet.getString("atb_dt"));			
					tesTmlSoCntrListVO.setCntrNo(dbRowSet.getString("cntr_no"));			
					tesTmlSoCntrListVO.setCntrTpszCd(dbRowSet.getString("cntr_tpsz_cd"));		
					tesTmlSoCntrListVO.setCntrStyCd(dbRowSet.getString("cntr_sty_cd"));		
					tesTmlSoCntrListVO.setLoclTsIndCd(dbRowSet.getString("locl_ts_ind_cd"));	
					tesTmlSoCntrListVO.setRcvdeTermIndCd(dbRowSet.getString("rcvde_term_ind_cd"));
					tesTmlSoCntrListVO.setDcgoClssCd(dbRowSet.getString("dcgo_clss_cd"));		
					tesTmlSoCntrListVO.setBbCgoFlg(dbRowSet.getString("bb_cgo_flg"));		
					tesTmlSoCntrListVO.setAwkCgoFlg(dbRowSet.getString("awk_cgo_flg"));		
					tesTmlSoCntrListVO.setRcFlg(dbRowSet.getString("rc_flg"));			
					tesTmlSoCntrListVO.setWrkDt(dbRowSet.getString("wrk_dt"));			
					tesTmlSoCntrListVO.setBkgNo(dbRowSet.getString("bkg_no"));				
					tesTmlSoCntrListVO.setBlNo(dbRowSet.getString("bl_no"));				
					tesTmlSoCntrListVO.setCntrRmk(dbRowSet.getString("cntr_rmk"));			
					tesTmlSoCntrListVO.setTmlTrnsModCd(dbRowSet.getString("tml_trns_mod_cd"));
					tesTmlSoCntrListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoCntrListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					insertVOList.add(tesTmlSoCntrListVO);
					maxSeq++;
				}
		    }
		    
			
			dbDao.createTerminalInvoiceContainerList(insertVOList);
			
			etcData.put("successFlag", "SUCCESS" );
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

//	/**
//	 * Save Event Process<br>
//	 *
//	 * @param e EsdTes0001Event
//	 * @return EventResponse ESD_TES_0001EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse deleteTerminalInvoiceContainerList(Event e) throws EventException {
//		EsdTes9010Event event=(EsdTes9010Event)e;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		HashMap<String, String> etcData = new HashMap<String, String>();
//
//		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    deleteTerminalInvoiceContainerList() ============");
//
//		try {
//			dbDao.deleteTerminalInvoiceContainerList(event);
//			etcData.put("successFlag", "SUCCESS");
//			
//			return eventResponse;
//
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e EsdTes9010Event
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event 		event			= (EsdTes9010Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    removeTES_FILE_IMP_TMP() ============");

		// DB ResultSet object For data transfer
		try {
			dbDao.removeTES_FILE_IMP_TMP(event.getTesTmlSoCntrListVO());
		
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * FinalBayFlanSource COMListOnly Search Event Process<br>
	 * CotainerList PopUp FinalBayFlanSource COMListOnly Search Event Process<br>
	 *
	 * @param e EsdTes9010Event
	 * @return response ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCOMListOnlyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event 		event = (EsdTes9010Event)e;
		GeneralEventResponse 	eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchCOMListOnlyList() ============");
		//DB ResultSet object For data transfer
		DBRowSet rowSet=null;
		try {
			
			//ofc_cd 추가해야함
			if(event.getMarineTerminalInvoiceCommonVO().getVvdType().equals("B")){
				rowSet = dbDao.searchCOMListOnlyListCNTC(event);
			}else{
				rowSet = dbDao.searchCOMListOnlyList(event);	
			}
			
			eventResponse.setRs(rowSet);
			
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Container List WorkOrder Input Inquiry<br>
	 *
	 * @param e ESD_TES_901Event
	 * @return response ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerListByWorkOrder(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9010Event event=(EsdTes9010Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchContainerListByWorkOrder() ============");
		//DB ResultSet object For data transfer
		DBRowSet rowSet=null;
		try {
			rowSet = dbDao.searchContainerListByWorkOrder(event);
			eventResponse.setRs(rowSet);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/** updateContainerListRvisFlgManual2
	 *  
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse updateContainerListRvisFlgManual2(Event e) throws EventException {
		log.debug("\n==========MarineTerminalInvoiceManageBCImpl    updateContainerListRvisFlgManual2() ============");
		EsdTes9232Event event=(EsdTes9232Event)e;
		int maxSeq = 0;
		
		MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs = null;
		TesTmlSoRvisListVO tesTmlSoRvisListVO = null;
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 	= new HashMap<String, String>();
		
		try {
			maxSeq = dbDao.multiTerminalInvoiceRvisSeq(event.getTesTmlSoDtlVO());
			marineTerminalInvoiceCommonVOs 	= event.getMarineTerminalInvoiceCommonVOs();
			
			List<TesTmlSoRvisListVO> insVoList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updVoList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> delVoList = new ArrayList<TesTmlSoRvisListVO>();


			for( int i=0; marineTerminalInvoiceCommonVOs!=null && i<marineTerminalInvoiceCommonVOs.length; i++ ){
				tesTmlSoRvisListVO = new TesTmlSoRvisListVO();
				
				if("Y".equals(marineTerminalInvoiceCommonVOs[i].getRvisInsFlg())){
					if("I".equals(marineTerminalInvoiceCommonVOs[i].getIbflag())){
						tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
						tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
						
						tesTmlSoRvisListVO.setTmlSoRvisListSeq(maxSeq+"");
						tesTmlSoRvisListVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());

						tesTmlSoRvisListVO.setTmlInvTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlInvTpCd());
						tesTmlSoRvisListVO.setCalcCostGrpCd(marineTerminalInvoiceCommonVOs[i].getRvisCalcCostGrpCd());
						tesTmlSoRvisListVO.setTmlRvisTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlRvisTpCd());
						tesTmlSoRvisListVO.setLgsCostCd(marineTerminalInvoiceCommonVOs[i].getRvisLgsCostCd());
						tesTmlSoRvisListVO.setCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCntrNo());
						tesTmlSoRvisListVO.setCntrTpszCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd());
						tesTmlSoRvisListVO.setCntrStyCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrStyCd());
						tesTmlSoRvisListVO.setBkgNo(marineTerminalInvoiceCommonVOs[i].getRvisBkgNo());
						
						tesTmlSoRvisListVO.setVslCd(marineTerminalInvoiceCommonVOs[i].getRvisVslCd());
						tesTmlSoRvisListVO.setSkdVoyNo(marineTerminalInvoiceCommonVOs[i].getRvisSkdVoyNo());
						tesTmlSoRvisListVO.setSkdDirCd(marineTerminalInvoiceCommonVOs[i].getRvisSkdDirCd());
		
						tesTmlSoRvisListVO.setCuzCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCuzCntrNo());
						tesTmlSoRvisListVO.setRhndRsnCd(marineTerminalInvoiceCommonVOs[i].getRvisRhndRsnCd());
						tesTmlSoRvisListVO.setRvisRmk(marineTerminalInvoiceCommonVOs[i].getRvisRmk());
						tesTmlSoRvisListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
						
						tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
						tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
						tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
						tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
						
						insVoList.add(tesTmlSoRvisListVO);
						maxSeq++;
						
					}else if("U".equals(marineTerminalInvoiceCommonVOs[i].getIbflag())){
						tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
						tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
						
						tesTmlSoRvisListVO.setTmlSoRvisListSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoRvisListSeq());
						tesTmlSoRvisListVO.setTmlSoDtlSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoDtlSeq());

						tesTmlSoRvisListVO.setTmlInvTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlInvTpCd());
						tesTmlSoRvisListVO.setCalcCostGrpCd(marineTerminalInvoiceCommonVOs[i].getRvisCalcCostGrpCd());
						tesTmlSoRvisListVO.setTmlRvisTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlRvisTpCd());
						tesTmlSoRvisListVO.setLgsCostCd(marineTerminalInvoiceCommonVOs[i].getRvisLgsCostCd());
						tesTmlSoRvisListVO.setCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCntrNo());
						tesTmlSoRvisListVO.setCntrTpszCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd());
						tesTmlSoRvisListVO.setCntrStyCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrStyCd());
						tesTmlSoRvisListVO.setBkgNo(marineTerminalInvoiceCommonVOs[i].getRvisBkgNo());
						
						tesTmlSoRvisListVO.setVslCd(marineTerminalInvoiceCommonVOs[i].getRvisVslCd());
						tesTmlSoRvisListVO.setSkdVoyNo(marineTerminalInvoiceCommonVOs[i].getRvisSkdVoyNo());
						tesTmlSoRvisListVO.setSkdDirCd(marineTerminalInvoiceCommonVOs[i].getRvisSkdDirCd());

						tesTmlSoRvisListVO.setCuzCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCuzCntrNo());
						tesTmlSoRvisListVO.setRhndRsnCd(marineTerminalInvoiceCommonVOs[i].getRvisRhndRsnCd());
						tesTmlSoRvisListVO.setRvisRmk(marineTerminalInvoiceCommonVOs[i].getRvisRmk());
						tesTmlSoRvisListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
						
						tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
						tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
						tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
						tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
						
						updVoList.add(tesTmlSoRvisListVO);
						
					}else if("D".equals(marineTerminalInvoiceCommonVOs[i].getIbflag())){
						tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
						tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());

						tesTmlSoRvisListVO.setTmlSoRvisListSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoRvisListSeq());
						tesTmlSoRvisListVO.setTmlSoDtlSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoDtlSeq());

						tesTmlSoRvisListVO.setTmlInvTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlInvTpCd());
						tesTmlSoRvisListVO.setCalcCostGrpCd(marineTerminalInvoiceCommonVOs[i].getRvisCalcCostGrpCd());
						tesTmlSoRvisListVO.setTmlRvisTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlRvisTpCd());
						tesTmlSoRvisListVO.setLgsCostCd(marineTerminalInvoiceCommonVOs[i].getRvisLgsCostCd());
						tesTmlSoRvisListVO.setCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCntrNo());
						tesTmlSoRvisListVO.setCntrTpszCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd());
						tesTmlSoRvisListVO.setCntrStyCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrStyCd());
						tesTmlSoRvisListVO.setBkgNo(marineTerminalInvoiceCommonVOs[i].getRvisBkgNo());
						
						tesTmlSoRvisListVO.setVslCd(marineTerminalInvoiceCommonVOs[i].getRvisVslCd());
						tesTmlSoRvisListVO.setSkdVoyNo(marineTerminalInvoiceCommonVOs[i].getRvisSkdVoyNo());
						tesTmlSoRvisListVO.setSkdDirCd(marineTerminalInvoiceCommonVOs[i].getRvisSkdDirCd());

						tesTmlSoRvisListVO.setCuzCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCuzCntrNo());
						tesTmlSoRvisListVO.setRhndRsnCd(marineTerminalInvoiceCommonVOs[i].getRvisRhndRsnCd());
						tesTmlSoRvisListVO.setRvisRmk(marineTerminalInvoiceCommonVOs[i].getRvisRmk());
						tesTmlSoRvisListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
						
						tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
						tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
						tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
						tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
						
						delVoList.add(tesTmlSoRvisListVO);
					}			
				}
					
			}				

			dbDao.multiTerminalInvoiceRvisInsert(insVoList);
			dbDao.multiTerminalInvoiceRvisUpdate(updVoList);
			dbDao.multiTerminalInvoiceRvisDelete(delVoList);
			
			dbDao.updateMarineTerminalRvisVol(event.getTesTmlSoDtlVO());
			
			etcData.put("successFlag","SUCCESS");
			eventResponse.setETCData(etcData);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 *  TPB save
	 *
	 * @param e EsdTes9232Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceN3rdParyIF(Event e) throws EventException {
		log.debug("\n==========MarineTerminalInvoiceManageBCImpl - multiTerminalInvoiceN3rdParyIF() ============");
		
		EsdTes9232Event event=(EsdTes9232Event)e;
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 	= new HashMap<String, String>();
		
		TesN3rdPtyIfVO[] 	tesN3rdPtyIfVOs 	= event.getTesN3rdPtyIfVOs();
		TesN3rdPtyIfVO 		tesN3rdPtyIfVO		= null;
		TesTmlSoDtlVO 		tesTmlSoDtlVO		= null;
		
		List<TesN3rdPtyIfVO> insVoList 			= new ArrayList<TesN3rdPtyIfVO>();
		List<TesN3rdPtyIfVO> delVoList 			= new ArrayList<TesN3rdPtyIfVO>();
		List<TesN3rdPtyIfVO> updVoList 			= new ArrayList<TesN3rdPtyIfVO>();
		List<TesTmlSoDtlVO>  updFlgVoList 		= new ArrayList<TesTmlSoDtlVO>();
		int maxSeq = 0;
		
		// DB ResultSet object For data transfer
		try {

			maxSeq = dbDao.multiTerminalInvoiceCommonSeq("TML_IF_SEQ", "TES_N3RD_PTY_IF", "TML_IF_OFC_CD", "", event.getTesTmlSoHdrVO().getInvOfcCd(), "");
			String	flgYn		= JSPUtil.getNull(event.getMarineTerminalInvoiceCommonVO().getFlgYn());

			for(int i=0; tesN3rdPtyIfVOs!=null && i<tesN3rdPtyIfVOs.length; i++ ){
log.debug("tesN3rdPtyIfVOs.length"+tesN3rdPtyIfVOs.length);	
log.debug("tesN3rdPtyIfVOs["+i+"].getIbflag()===>"+tesN3rdPtyIfVOs[i].getIbflag());				
				
				tesN3rdPtyIfVOs[i].setTmlIfOfcCd(event.getTesTmlSoHdrVO().getInvOfcCd());

				if("I".equals(tesN3rdPtyIfVOs[i].getIbflag())){
					tesN3rdPtyIfVOs[i].setTmlIfSeq(maxSeq+"");
					tesN3rdPtyIfVOs[i].setCalcCostGrpCd(event.getTesTmlSoDtlVO().getCalcCostGrpCd());
					tesN3rdPtyIfVOs[i].setTmlInvTpCd(event.getTesTmlSoHdrVO().getTmlInvTpCd());
					tesN3rdPtyIfVOs[i].setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
					tesN3rdPtyIfVOs[i].setYdCd(event.getTesTmlSoHdrVO().getYdCd());
					tesN3rdPtyIfVOs[i].setAcctCd(event.getTesTmlSoDtlVO().getAcctCd());
					tesN3rdPtyIfVOs[i].setCurrCd(event.getTesTmlSoHdrVO().getCurrCd());
					                
					tesN3rdPtyIfVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesN3rdPtyIfVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesN3rdPtyIfVOs[i].setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					                
					tesN3rdPtyIfVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesN3rdPtyIfVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					 
					insVoList.add(tesN3rdPtyIfVOs[i]);
					maxSeq++;
					
					tesTmlSoDtlVO		= new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setN3ptyFlg("Y");
					tesTmlSoDtlVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoDtlVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
log.debug("event.getTesTmlSoDtlVO().getTmlSoDtlSeq()====>"+event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
log.debug("tesN3rdPtyIfVOs[i].getTmlSoDtlSeq()====>"+tesN3rdPtyIfVOs[i].getTmlSoDtlSeq());

					tesTmlSoDtlVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					tesTmlSoDtlVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					updFlgVoList.add(tesTmlSoDtlVO);					
					
				}else if("U".equals(tesN3rdPtyIfVOs[i].getIbflag())){
log.debug("tesN3rdPtyIfVOs["+i+"].getIbflag()===>"+tesN3rdPtyIfVOs[i].getIbflag());					
					tesN3rdPtyIfVOs[i].setCalcCostGrpCd(event.getTesTmlSoDtlVO().getCalcCostGrpCd());
					tesN3rdPtyIfVOs[i].setTmlInvTpCd(event.getTesTmlSoHdrVO().getTmlInvTpCd());
					tesN3rdPtyIfVOs[i].setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
					tesN3rdPtyIfVOs[i].setYdCd(event.getTesTmlSoHdrVO().getYdCd());
					tesN3rdPtyIfVOs[i].setAcctCd(event.getTesTmlSoDtlVO().getAcctCd());
					tesN3rdPtyIfVOs[i].setCurrCd(event.getTesTmlSoHdrVO().getCurrCd());
					                
					tesN3rdPtyIfVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesN3rdPtyIfVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesN3rdPtyIfVOs[i].setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					                
					tesN3rdPtyIfVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesN3rdPtyIfVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					 
					updVoList.add(tesN3rdPtyIfVOs[i]);					
					
				}else if("D".equals(tesN3rdPtyIfVOs[i].getIbflag())){
log.debug("tesN3rdPtyIfVOs["+i+"].getIbflag()===>"+tesN3rdPtyIfVOs[i].getIbflag());					
					tesN3rdPtyIfVOs[i].setCalcCostGrpCd(event.getTesTmlSoDtlVO().getCalcCostGrpCd());
					tesN3rdPtyIfVOs[i].setTmlInvTpCd(event.getTesTmlSoHdrVO().getTmlInvTpCd());
					tesN3rdPtyIfVOs[i].setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
					tesN3rdPtyIfVOs[i].setYdCd(event.getTesTmlSoHdrVO().getYdCd());
					tesN3rdPtyIfVOs[i].setAcctCd(event.getTesTmlSoDtlVO().getAcctCd());
					tesN3rdPtyIfVOs[i].setCurrCd(event.getTesTmlSoHdrVO().getCurrCd());
					                
					tesN3rdPtyIfVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesN3rdPtyIfVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesN3rdPtyIfVOs[i].setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					                
					tesN3rdPtyIfVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesN3rdPtyIfVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					 
					delVoList.add(tesN3rdPtyIfVOs[i]);				
				}				
			}
			
			if(flgYn.equals("")){
				tesTmlSoDtlVO		= new TesTmlSoDtlVO();
				tesTmlSoDtlVO.setN3ptyFlg("");
				tesTmlSoDtlVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesTmlSoDtlVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesTmlSoDtlVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
				tesTmlSoDtlVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
				tesTmlSoDtlVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
				updFlgVoList.add(tesTmlSoDtlVO);
			}	
		
			dbDao.multiTerminalInvoiceN3rdParyIFDelete(delVoList);
			dbDao.multiTerminalInvoiceN3rdParyIFUpdate(updVoList);
			dbDao.multiTerminalInvoiceN3rdParyIF(insVoList);
			dbDao.multiTerminalInvoiceN3rdParyIFFlgUpdate(updFlgVoList);
			

			String	delIfSeq	= JSPUtil.getNull(event.getMarineTerminalInvoiceCommonVO().getDelIfSeq());
//			String	delCntrSeq	= JSPUtil.getNull(event.getMarineTerminalInvoiceCommonVO().getDelCntrSeq());

			if ( delIfSeq.length() > 0 ) {
				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
				String	[]	arrIfSeq	= delIfSeq.split("\\|");
//				delCntrSeq	= delCntrSeq.substring( 0, delCntrSeq.length() - 1 ); 	//.replaceAll("\\|", ",");
//				String[]	arrCntrSeq	= delCntrSeq.split("\\|");
				
//log.debug("delCntrSeq.length()=========>"+delCntrSeq.length());				

				delVoList 		= new ArrayList<TesN3rdPtyIfVO>();
				
				for ( int j = 0; j < arrIfSeq.length; j++ ) {
					tesN3rdPtyIfVO		= new TesN3rdPtyIfVO();
					tesN3rdPtyIfVO.setTmlIfOfcCd(event.getSignOnUserAccount().getOfc_cd());
					tesN3rdPtyIfVO.setTmlIfSeq(arrIfSeq[j]);
					tesN3rdPtyIfVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesN3rdPtyIfVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesN3rdPtyIfVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					delVoList.add(tesN3rdPtyIfVO);
				}
				
			}
			
			dbDao.multiTerminalInvoiceN3rdParyIFDeleteTpb(delVoList);
			
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 3rd Party retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e EsdTes9232Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTrdPartyVolume(Event e) throws EventException {
		EsdTes9232Event event = (EsdTes9232Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchAutoTrdPartyVolume() ============");

		try {
			rowSet = dbDao.searchAutoTrdPartyVolume(event);
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 3rd Party retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e ESD_TES_9232Event
	 * @return response ESD_TES_923_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTrdPartyVolume(Event e) throws EventException {
		EsdTes9232Event event=(EsdTes9232Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
				
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchManualTrdPartyVolume() ============");

		try {
log.debug("event.getTesTmlSoDtlVO().getLgsCostCd()==================>"+event.getTesTmlSoDtlVO().getLgsCostCd());

			if("SVXXJO".equals(event.getTesTmlSoDtlVO().getLgsCostCd())){
				rowSet = dbDao.searchManualTrdPartyVolumeJo(event);	
			}else{
				rowSet = dbDao.searchManualTrdPartyVolume(event);
			}
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 3rd Party retrieve event process
	 * MarineTerminalInvoiceManage 3rd Party  retrieve event process
	 *
	 * @param e ESD_TES_925_2Event
	 * @return response ESD_TES_925_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalTrdPartyVolume(Event e) throws EventException {
		EsdTes9252Event event=(EsdTes9252Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchMarineTerminalTrdPartyVolume() ============");

		try {
			rowSet = dbDao.searchMarineTerminalTrdPartyVolume(event.getTesN3rdPtyIfVO());
			eventResponse.setRs(rowSet);
			
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e EsdTes9032Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRevisedVolume(Event e) throws EventException {
		EsdTes9032Event event=(EsdTes9032Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		DBRowSet rowSet=null;
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchManualRevisedVolume() ============");

		try {
			rowSet = dbDao.searchManualRevisedVolume(event.getTesTmlSoCntrListVO(), event.getTesTmlSoDtlVO(), event.getTesCommonVo(), event.getMarineTerminalInvoiceCommonVO());
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e EsdTes9072Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalManualRevisedVolume(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchMarineTerminalManualRevisedVolume() ============");

		EsdTes9072Event event=(EsdTes9072Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		DBRowSet rowSet=null;

		try {
			rowSet = dbDao.searchManualRevisedVolume(event.getTesTmlSoCntrListVO(), event.getTesTmlSoDtlVO(), event.getTesCommonVo(), event.getMarineTerminalInvoiceCommonVO());
			eventResponse.setRs(rowSet);
			
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
		
	}


	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e EsdTes9032Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoRevisedVolume(Event e) throws EventException {
		EsdTes9032Event event=(EsdTes9032Event)e;
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchAutoRevisedVolume() ============");

		try {
			rowSet = dbDao.searchAutoRevisedVolume(event.getTesTmlSoCntrListVO(), event.getTesTmlSoDtlVO(), event.getTesCommonVo(), event.getTesTmlSoHdrVO());
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e ESD_TES_907_2Event
	 * @return response ESD_TES_907_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalAutoRevisedVolume(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchMarineTerminalAutoRevisedVolume() ============");

		EsdTes9072Event event=(EsdTes9072Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		DBRowSet rowSet=null;

		try {
			rowSet = dbDao.searchAutoRevisedVolume(event.getTesTmlSoCntrListVO(), event.getTesTmlSoDtlVO(), event.getTesCommonVo(), event.getTesTmlSoHdrVO());
			eventResponse.setRs(rowSet);
			
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/**
	 * MarineTerminal Contaner List Inquery
	 */


	/**
	 * MarineTerminal Container List Search
	 * Main_hidden Event Process
	 *
	 * @param e ESD_TES_0017Event
	 * @return GeneralEventResponse GeneralEventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	public EventResponse searchTerminalInvoiceBasicInfo2(Event e) throws EventException{
		if(log.isDebugEnabled()) log.debug("\n ==============MarineTerminalInvoiceManageBCImpl  searchTerminalInvoiceBasicInfo2 start \n");
		
		EsdTes0017Event event = (EsdTes0017Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList  arrList 	= new ArrayList();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try{
			arrList.add(dbDao.searchTerminalInvoiceBasicInfo(event.getTesTmlSoHdrVO()));
			arrList.add(dbDao.searchTerminalInvoiceVVD(event.getTesTmlSoHdrVO()));
			eventResponse.setRsList(arrList);
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			//return new ESD_TES_017EventResponse(rowSetArr, "SUCCESS");
		}catch(DAOException de){
			log.error("err"+de.toString());
			throw new EventException(de.getMessage());
		}
	}




	/**
	 * MarineTerminal Container List Inquery
	 * Container_List_Hidden Event Process
	 *
	 * @param e EsdTes0017Event
	 * @return EventResponse ESD_TES_017EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	public EventResponse searchTerminalContainerList2(Event e) throws EventException{
		if(log.isDebugEnabled()) log.debug("\n============MarineTerminalInvoiceManageBCImpl   :::::::::   searchTerminalContainerList2\n");
		EsdTes0017Event event = (EsdTes0017Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		List arrList 							= new ArrayList();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		// DBResultSet for Data Transmission
		DBRowSet[] rowSetArr = new DBRowSet[5];

		try{
			rowSetArr[0] = dbDao.searchTerminalInvoiceContainerList(event.getTesTmlSoCntrListVO(), event.getTesCommonVo(),"CO");
			rowSetArr[1] = dbDao.searchTerminalInvoiceContainerList(event.getTesTmlSoCntrListVO(), event.getTesCommonVo(),"DC");
			rowSetArr[2] = dbDao.searchTerminalInvoiceCalculationList(event.getTesTmlSoDtlVO(), event.getTesCommonVo());
			rowSetArr[3] = dbDao.searchAccumulatedVolume(event.getTesTmlSoHdrVO(), event.getTesCommonVo(), event.getSignOnUserAccount().getOfc_cd());
			rowSetArr[4] = dbDao.searchTerminalInvoiceTotalAmountForPopup(event.getTesTmlSoDtlVO());
			
			/*
			arrList.add(rowSetArr[0]==null?new DBRowSet():rowSetArr[0]);
			arrList.add(rowSetArr[1]==null?new DBRowSet():rowSetArr[1]);
			arrList.add(rowSetArr[2]==null?new DBRowSet():rowSetArr[2]);
			arrList.add(rowSetArr[3]==null?new DBRowSet():rowSetArr[3]);
			arrList.add(rowSetArr[4]==null?new DBRowSet():rowSetArr[4]);*/
			
			arrList.add(rowSetArr[0]);
			arrList.add(rowSetArr[1]);
			arrList.add(rowSetArr[2]);
			arrList.add(rowSetArr[3]);
			arrList.add(rowSetArr[4]);
			
			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);

			return eventResponse;
		}catch(DAOException de){
			log.error("err"+de.toString());
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * MarineTerminal Container List Search
	 * Accumulate_Hidden Event Process
	 *
	 * @param e EsdTes0017Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	public EventResponse searchAccumulatedVolume2(Event e) throws EventException{
		if(log.isDebugEnabled()) log.debug("\n========MarineTerminalInvoiceManageBCImpl   :::::::::   searchAccumulatedVolume2\n");
		EsdTes0017Event event = (EsdTes0017Event)e;
		//DBResultSet for Data Transmission
		DBRowSet rowSet=null;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try{
			rowSet = dbDao.searchAccumulatedVolume(event.getTesTmlSoHdrVO(), event.getTesCommonVo(), event.getSignOnUserAccount().getOfc_cd());
			
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setRs(rowSet);
			
			return eventResponse;
		}catch(DAOException de){
			log.error("err"+de.toString());
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TerminalInvoiceCalculationList retrieve event process
	 * ESD_TES_0001 TerminalInvoiceCalculationList retrieve event process
	 *
	 * @param e ESD_TES_017Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
//	public EventResponse searchTerminalInvoiceCalculationList2(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTes0017Event event=(EsdTes0017Event)e;
//		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTerminalInvoiceCalculationList2() ============");
////		 DB ResultSet object For data transfer
//		DBRowSet rowSet=null;
//		try {
//			rowSet = dbDao.searchTerminalInvoiceCalculationList2(event.getEventParams());
//			return new ESD_TES_017EventResponse(rowSet,"SUCCESS");
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}


	/**
	 * Terminal Invoice Inquiry - Summary 
	 * @author kimjinjoo
	 */


	/**
	 * retrieve event process
	 * marineterminalinvoicemanage retrieve event process
	 *
	 * @param e ESD_TES_013Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0013Event event=(EsdTes0013Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTerminalInvoiceSummary() ============");
			//rowSet=dbDao.searchTerminalInvoiceSummary(event.getTES_TML_SO_HDR(), event.getParam_map());

			eventResponse.setRs(dbDao.searchTerminalInvoiceSummary(event));
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieve event process
	 * Terminal Expense Inquiry retrieve event process
	 *
	 * @param e EsdTes0014Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalExpenseSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0014Event event=(EsdTes0014Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		// DB ResultSet object For data transfer
		DBRowSet rowSet=null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTerminalExpenseSummary() ============");
			rowSet=dbDao.searchTerminalExpenseSummary(event);
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	 /**
	 * retrieve event process
	 * Office Hierarchy retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeHierarchy(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9300Event event=(EsdTes9300Event)e;

		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();

		// DB ResultSet object For data transfer
		DBRowSet rowSet=null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchOfficeHierarchy() ============");
			rowSet=dbDao.searchOfficeHierarchy(event);
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	 /**
	 * retrieve event process
	 * Office Hierarchy retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9300Event event=(EsdTes9300Event)e;

		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		// DB ResultSet object For data transfer
		DBRowSet rowSet=null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchSubOffice() ============");
			rowSet=dbDao.searchSubOffice(event);
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	
	/**
	 * retrieve event process
	 * Terminal Expense Inquiry retrieve event process
	 *
	 * @param e EsdTes0014Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalExpenseVolumeSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0014Event event=(EsdTes0014Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		Map<String, String>		etcData			= new HashMap<String, String>();

		// DB ResultSet object For data transfer
		DBRowSet rowSet=null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTerminalExpenseVolumeSummary() ============");
//			rowSet=dbDao.searchTerminalExpenseVolumeSummary(event.getParam_map());
			rowSet=dbDao.searchTerminalExpenseVolumeSummary(event);
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
						
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}




	/**
	 * Update Event Process<br>
	 * marineterminalinvoicemanage Update Event Process<br>
	 *
	 * @param e EsdTes0013Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalInvoiceConfirm(Event e) throws EventException {
		log.debug("\n========== marineterminalinvoicemanageBCImpl : modifyTerminalInvoiceConfirm 실행 ==========\n");
		//		 PDTO(Data Transfer Object including Parameters)
		EsdTes0013Event event=(EsdTes0013Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// DB ResultSet object For data transfer

		try {
			dbDao.modifyTerminalInvoiceConfirm(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());

			/*
			models = event.getTES_TML_SO_HDRS();
			model  = event.getTES_TML_SO_HDR();
			Iterator itr = models.iterator();
			int i;

			int j=110;
			while(itr.hasNext()){
				model = (TES_TML_SO_HDR)itr.next();
				i = 1;
				j++;
				if(model.getTml_inv_tp_cd().equalsIgnoreCase("TM")){
					log.debug("\n\nSO No. : "+ model.getTml_so_ofc_cty_cd() + model.getTml_so_seq() + "::: This is a Marine Terminal Invoice. Check ACCM Data for updating.");
					rowSet = dbDao.searchACCMUpdateData(model.getInv_no(), model.getVndr_seq());

					if(rowSet == null){
						log.debug("\n\nACCM Update 대상이 아닙니다.");
					}else{
						log.debug("\n\nACCM Update 대상입니다.");

						while(rowSet.next()) {
							rowSetSum = dbDao.searchACCMUpdateSum(model.getVndr_seq(), rowSet.getString("accm_seq"));
							dbDao.modifySoACCMData(event.getTES_TML_SO_HDR(), rowSet.getString("accm_seq"), rowSet.getString("tml_so_dtl_seq"), rowSetSum.getString("qty"), rowSetSum.getString("amt"), event.getSignOnUserAccount().getUsr_id());
						}
					}
				}else{
					log.debug("\n\nSO No. : "+ model.getTml_so_ofc_cty_cd() + model.getTml_so_seq() + "::: This is Not a Marine Terminal Invoice");
				}
			}*/
			return eventResponse;//new ESD_TES_013EventResponse(null,"SUCCESS");
		/*} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new EventException(se.getMessage());*/
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Accumulate Vol List retrieve event process
	 * MarineTerminalInvoiceManage Accumulate Vol List retrieve event process
	 *
	 * @param e ESD_TES_922Event
	 * @return response ESD_TES_922EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccumulatedVolumeList(Event e) throws EventException {

		EsdTes9220Event event=(EsdTes9220Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchAccumulatedVolumeList() ============ ");

		try {
			rowSet = dbDao.searchAccumulatedVolumeList(event.getTesTmlSoAccmYdVO());
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * RehandlingVolume List retrieve event process
	 * MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 *
	 * @param e ESD_TES_919Event
	 * @return response ESD_TES_919EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandlingVolume(Event e) throws EventException {
		EsdTes9190Event event=(EsdTes9190Event)e;
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchRehandlingVolume() ============");

		try {
			rowSet = dbDao.searchRehandlingVolume(event.getTesTmlSoRvisListVO(), event.getTesCommonVo(), event.getTesTmlSoHdrVO());
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * RehandlingVolume List retrieve event process
	 * MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 *
	 * @param e ESD_TES_919_1Event
	 * @return response ESD_TES_919_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalRehandlingVolume(Event e) throws EventException {

		EsdTes9191Event 		event			=(EsdTes9191Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchMarineTerminalRehandlingVolume() ============");

		try {
			rowSet = dbDao.searchRehandlingVolume(event.getTesTmlSoRvisListVO(), event.getTesCommonVo(), event.getTesTmlSoHdrVO());
			
			eventResponse.setRs(rowSet);
			
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);

			return eventResponse;
			//return new ESD_TES_919_1EventResponse(rowSet, "SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * RehandlingVolume List Save Event Process<br>
	 * MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 *
	 * @param e EsdTes9190Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiRehandlingVolume(Event e) throws EventException {
		log.debug("\n==== MarineTerminalInvoiceManageBCImpl - multiRehandlingVolume() ==========");
		
		EsdTes9190Event 		event			=(EsdTes9190Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		Map<String, String>		etcData	 		= new HashMap<String, String>();

		TesTmlSoHdrVO 			tesTmlSoHdrVO 		= null;
		TesTmlSoRvisListVO 		tesTmlSoRvisListVO 	= null;
		MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs = null;
		
		int maxSeq = 0; 

		try {
			tesTmlSoHdrVO 					= event.getTesTmlSoHdrVO();
			marineTerminalInvoiceCommonVOs 	= event.getMarineTerminalInvoiceCommonVOs();
			
			List<TesTmlSoRvisListVO> insVoList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updVoList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> delVoList = new ArrayList<TesTmlSoRvisListVO>();
			
			maxSeq = dbDao.multiTerminalInvoiceRvisSeq(event.getTesTmlSoDtlVO());
			
			for( int i=0; marineTerminalInvoiceCommonVOs!=null && i<marineTerminalInvoiceCommonVOs.length; i++ ){
				tesTmlSoRvisListVO = new TesTmlSoRvisListVO();
log.debug("marineTerminalInvoiceCommonVOs[i].getIbflag()===>"+marineTerminalInvoiceCommonVOs[i].getIbflag());

				if(marineTerminalInvoiceCommonVOs[i].getIbflag().equals("I")){
					tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					
					tesTmlSoRvisListVO.setTmlSoDtlSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoDtlSeq());
					
					tesTmlSoRvisListVO.setTmlSoRvisListSeq(maxSeq+"");
					tesTmlSoRvisListVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					
					tesTmlSoRvisListVO.setTmlInvTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlInvTpCd());
					tesTmlSoRvisListVO.setCalcCostGrpCd(marineTerminalInvoiceCommonVOs[i].getRvisCalcCostGrpCd());
					tesTmlSoRvisListVO.setTmlRvisTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlRvisTpCd());
					tesTmlSoRvisListVO.setLgsCostCd(event.getTesTmlSoDtlVO().getLgsCostCd());
					tesTmlSoRvisListVO.setCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCntrNo());
					
					tesTmlSoRvisListVO.setCntrTpszCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd());
					if(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd()==null || marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd().equals("")){
						tesTmlSoRvisListVO.setCntrTpszCd(event.getTesTmlSoDtlVO().getCntrTpszCd());
					}
					
					tesTmlSoRvisListVO.setCntrStyCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrStyCd());
					tesTmlSoRvisListVO.setBkgNo(marineTerminalInvoiceCommonVOs[i].getRvisBkgNo());

					tesTmlSoRvisListVO.setVslCd(event.getTesCommonVo().getVvd().substring(0, 4));
					tesTmlSoRvisListVO.setSkdVoyNo(event.getTesCommonVo().getVvd().substring(4, 8));
					tesTmlSoRvisListVO.setSkdDirCd(event.getTesCommonVo().getVvd().substring(8));
					
					tesTmlSoRvisListVO.setCuzCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCuzCntrNo());
					tesTmlSoRvisListVO.setRhndRsnCd(marineTerminalInvoiceCommonVOs[i].getRvisRhndRsnCd());
					tesTmlSoRvisListVO.setRvisRmk(marineTerminalInvoiceCommonVOs[i].getRvisRmk());
					tesTmlSoRvisListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
					
					tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());				
					
					insVoList.add(tesTmlSoRvisListVO);
					maxSeq++;
					
				}else if(marineTerminalInvoiceCommonVOs[i].getIbflag().equals("U")){
					tesTmlSoRvisListVO.setCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCntrNo());
					tesTmlSoRvisListVO.setBkgNo(marineTerminalInvoiceCommonVOs[i].getRvisBkgNo());
					tesTmlSoRvisListVO.setCuzCntrNo(marineTerminalInvoiceCommonVOs[i].getRvisCuzCntrNo());
					
					tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesTmlSoRvisListVO.setTmlSoDtlSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoDtlSeq());
					tesTmlSoRvisListVO.setTmlSoRvisListSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoRvisListSeq());
					tesTmlSoRvisListVO.setTmlSoDtlSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoDtlSeq());

					tesTmlSoRvisListVO.setTmlInvTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlInvTpCd());
					tesTmlSoRvisListVO.setCalcCostGrpCd(marineTerminalInvoiceCommonVOs[i].getRvisCalcCostGrpCd());
					tesTmlSoRvisListVO.setTmlRvisTpCd(marineTerminalInvoiceCommonVOs[i].getRvisTmlRvisTpCd());
					tesTmlSoRvisListVO.setLgsCostCd(event.getTesTmlSoDtlVO().getLgsCostCd());
					
					tesTmlSoRvisListVO.setCntrTpszCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd());
					//if(marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd()==null || marineTerminalInvoiceCommonVOs[i].getRvisCntrTpszCd().equals("")){
					//	tesTmlSoRvisListVO.setCntrTpszCd(event.getTesTmlSoDtlVO().getCntrTpszCd());
					//}
					
					tesTmlSoRvisListVO.setCntrStyCd(marineTerminalInvoiceCommonVOs[i].getRvisCntrStyCd());					
					tesTmlSoRvisListVO.setRhndRsnCd(marineTerminalInvoiceCommonVOs[i].getRvisRhndRsnCd());
					tesTmlSoRvisListVO.setRvisRmk(marineTerminalInvoiceCommonVOs[i].getRvisRmk());
					tesTmlSoRvisListVO.setRvisIndFlg(marineTerminalInvoiceCommonVOs[i].getRvisIndFlg());
					
					tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());				
					
					updVoList.add(tesTmlSoRvisListVO);
					
				}else if(marineTerminalInvoiceCommonVOs[i].getIbflag().equals("D")){
					tesTmlSoRvisListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoRvisListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesTmlSoRvisListVO.setTmlSoDtlSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoDtlSeq());
					tesTmlSoRvisListVO.setTmlSoRvisListSeq(marineTerminalInvoiceCommonVOs[i].getRvisTmlSoRvisListSeq());
	
					tesTmlSoRvisListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoRvisListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoRvisListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());				
					
					delVoList.add(tesTmlSoRvisListVO);
				}
			}				
			
			dbDao.multiRehandlingVolumeInsert(insVoList);
			dbDao.multiRehandlingVolumeUpdate(updVoList);
			dbDao.multiRehandlingVolumeDelete(delVoList);

			///dbDao.multiRehandlingVolume(event.getTES_TML_SO_RVIS_LISTS(), event.getParams(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			dbDao.updateMarineTerminalRehandlingVolume(event.getTesTmlSoDtlVO());
			dbDao.updateMarineTerminalRvisVol(event.getTesTmlSoDtlVO());
			
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Terminal Invoice Inquiry - Summary //End
	 */


	/**
	 * VVD Dual retrieve event process
	 * MarineTerminalInvoiceManage VVD Dual  retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return response ESD_TES_0001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceVVDDual(Event e) throws EventException {
		EsdTes0001Event event = (EsdTes0001Event)e;
		DBRowSet rowSet					=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTerminalInvoiceVVDDual() ============");

		try {
			rowSet = dbDao.searchTerminalInvoiceVVDDual(event);
			etcData.put("successFlag", "SUCCESS");
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/** searchDBCheckTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckTerminalInvoice(Event e) throws EventException {
		EsdTes0001Event event = (EsdTes0001Event)e;
		DBRowSet rowSet					=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData = new HashMap<String, String>();
		int db_cnt = 0;
		String inv_no = "";
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchDBCheckTerminalInvoice() ============");

		try {
			
			String costCdFtrRmk = new TESInvoiceCommonBCImpl().selectCostCdFtrRmk(event.getTesTmlSoHdrVO());
			event.getTesTmlSoHdrVO().setCostCdFtrRmk(costCdFtrRmk);
			
			rowSet = dbDao.dBCheckTerminalInvoice(event.getTesTmlSoHdrVO(), event.getTesTmlSoCntrListVO(), event.getTesCommonVo());
			
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
	 * BOUND retrieve event process
	 * MarineTerminalInvoiceManage BOUND retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return response ESD_TES_0001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceAutoBoundList(Event e) throws EventException {
		EsdTes1003Event event = (EsdTes1003Event)e;
		DBRowSet rowSet						= null;
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		Map<String, String>		etcData	 	= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    searchTerminalInvoiceAutoBoundList() ============");

		try {
			rowSet = dbDao.searchTerminalInvoiceAutoBoundList(event);
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * BOUND Save Event Process<br>
	 * MarineTerminalInvoiceManage BOUND Save Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response ESD_TES_0001EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceAutoBoundList(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageBCImpl    multiTerminalInvoiceAutoBoundList() ============");

		EsdTes1003Event event = (EsdTes1003Event) e;
		TesTmlSoDtlVO[] tesTmlSoDtlVOs		= event.getTesTmlSoDtlVOs();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		int maxSeq = 0;

		try {
			List<TesTmlSoDtlVO> insVoList 			= new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> updVoList 			= new ArrayList<TesTmlSoDtlVO>();
			
			maxSeq = dbDao.multiTerminalInvoiceCommonSeq("TML_SO_DTL_SEQ", "TES_TML_SO_DTL", "TML_SO_OFC_CTY_CD", "TML_SO_SEQ", event.getTesTmlSoDtlVO().getTmlSoOfcCtyCd(), event.getTesTmlSoDtlVO().getTmlSoSeq());

			for(int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++){
				if(tesTmlSoDtlVOs[i].getIbflag().equals("I")){

					tesTmlSoDtlVOs[i].setTmlSoDtlSeq(maxSeq+"");
					tesTmlSoDtlVOs[i].setCalcCostGrpCd("TM");
					tesTmlSoDtlVOs[i].setCalcTpCd("M");
					
					tesTmlSoDtlVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoDtlVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					insVoList.add(tesTmlSoDtlVOs[i]);
					maxSeq++;
				}else if(tesTmlSoDtlVOs[i].getIbflag().equals("U")){	
					tesTmlSoDtlVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					updVoList.add(tesTmlSoDtlVOs[i]);
				}
			}
			
			dbDao.multiTerminalInvoiceAutoBoundListInsert(insVoList);
			dbDao.multiTerminalInvoiceAutoBoundListUpdate(updVoList);
			
			//dbDao.multiTerminalInvoiceAutoBoundList(event.getTES_TML_SO_DTLS(), event.getParam_map(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * BOUND CHECK Event Process<br>
	 * MarineTerminalInvoiceManage BOUND CHECK Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response ESD_TES_0001EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDualVVD(Event e) throws EventException {
		EsdTes1003Event event = (EsdTes1003Event) e;
		String rsltStr = "";
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rsltStr = dbDao.checkDualVVDChk(event);
			if(!"0".equals(rsltStr)){
//				throw new DAOException("\n [checkDualVVD] Dup Check error exists on VVD. \nClick Retrieve Button to process Invoice. VVD : ");
				throw new DAOException(new ErrorHandler("TES00093", new String[]{}).getMessage());
			}
			dbDao.checkDualVVDInsert(event);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Search MGSet List
	 * @param e EsdTes1004Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchMGSetFuelingChargeList(Event e) throws EventException{
		EsdTes1004Event event = (EsdTes1004Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchMGSetFuelingChargeList(event.getMarineTerminalInvoiceCommonVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * MGSet List CUD
	 * @param e EsdTes1004Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiMGSetFuelingCharge(Event e) throws EventException{
		EsdTes1004Event event = (EsdTes1004Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String usr_id = event.getSignOnUserAccount().getUsr_id();
			String sIbFlag = "";
			
			TesMgstFuelChgVO[] tesMgstFuelChgVOs = event.getTesMgstFuelChgVOs();			
			List<TesMgstFuelChgVO> insertVOList = new ArrayList<TesMgstFuelChgVO>();
			List<TesMgstFuelChgVO> updateVOList = new ArrayList<TesMgstFuelChgVO>();
			List<TesMgstFuelChgVO> deleteVOList = new ArrayList<TesMgstFuelChgVO>();
			
			for( int i=0; i<tesMgstFuelChgVOs.length; i++){
				sIbFlag = tesMgstFuelChgVOs[i].getIbflag();
				log.debug("at BC.multiMGSetList >> sIbFlag >> "+sIbFlag);
				
				if ( "I".equals(sIbFlag) ) {			//insert
					tesMgstFuelChgVOs[i].setCreUsrId( usr_id );
					tesMgstFuelChgVOs[i].setUpdUsrId( usr_id );
					insertVOList.add(tesMgstFuelChgVOs[i]);
				} else if( "U".equals(sIbFlag) ) {		//update	
					tesMgstFuelChgVOs[i].setUpdUsrId( usr_id );
					updateVOList.add(tesMgstFuelChgVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesMgstFuelChgVOs[i]);
				}		
			}
			
			if ( deleteVOList.size() > 0 ) {
				dbDao.deleteMGSetFuelingCharge(deleteVOList);
			}			
			if ( insertVOList.size() > 0 ) {
				dbDao.insertMGSetFuelingCharge(insertVOList);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.updateMGSetFuelingCharge(updateVOList);
			}

			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 9001 팝업화면 에서의 searchCostCodeList
	 * @param SearchCostCodeDetailListVO paramVO
	 * @param TesCommonVO cmnVO
	 * @param String cost_cd_inv_tp_cd
	 * @param SignOnUserAccount account
	 * @return List<SearchCostCodeDetailListVO>
	 * @throws EventException
	 */	
	public List<SearchCostCodeDetailListVO> searchCostCodeList(SearchCostCodeDetailListVO paramVO, TesCommonVO cmnVO , String cost_cd_inv_tp_cd, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchCostCodeList(paramVO, cmnVO, cost_cd_inv_tp_cd, account);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 9001 팝업화면 에서의 searchCostCodeDetailList
	 * @param SearchCostCodeDetailListVO paramVO
	 * @param TesCommonVO paramVO2
	 * @return List<SearchCostCodeDetailListVO>
	 * @throws EventException
	 */	
	public  List<SearchCostCodeDetailListVO> searchCostCodeDetailList(SearchCostCodeDetailListVO paramVO, TesCommonVO paramVO2) throws EventException{
		try {
			return dbDao.searchCostCodeDetailList(paramVO, paramVO2);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieve event process
	 * 9010 Search CNTR TYPE CD List
	 *
	 * @param e EsdTes9010Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCDList(Event e) throws EventException {
		EsdTes9010Event event = (EsdTes9010Event)e;
		List<TesTmlSoCntrListVO> rtnList = new ArrayList<TesTmlSoCntrListVO>();
		
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();				
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++){				
				if("".equals(tesTmlSoCntrListVOs[i].getCntrTpszCd())){
					tesTmlSoCntrListVOs[i].setCntrTpszCd(dbDao.searchBkgCntrTPCDList(tesTmlSoCntrListVOs[i]));				
				}
				rtnList.add(tesTmlSoCntrListVOs[i]);
			}	
			
			eventResponse.setRsVoList(rtnList);			
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}				
	}
}