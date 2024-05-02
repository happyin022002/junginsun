/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtSC.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBC;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBC;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0002Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0003Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0004Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0005Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0006Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0028Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0079Event;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.StlBssPortVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.bizcommon.util.BizComUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooCrrMrgVO;
import com.clt.syscommon.common.table.JooStlVvdVO;


/**
 * OPUS-JointOperationMasterDataMgtSC Business Logic ServiceCommand - handling business transaction
 * 
 * @author
 * @see JointOperationMasterDataMgtBCDBDAO
 * @since J2EE 1.4
 */

public class JointOperationMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JointOperationMasterDataMgtSC system : preceding process for biz scenario<br>
	 */
	public void doStart() {
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * JointOperationMasterDataMgtSC system : biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("JointOperationMasterDataMgtSC 종료");
	}

	/**
	 * 
	 * OPUS-JointOperationMasterDataMgtSC system <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		
		//FNS_JOO_0002 Financial Affairs Creation & Inquiry
		if (e.getEventName().equalsIgnoreCase("FnsJoo0002Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCarFinancialMtrxList(e);
			}
			//Create
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = calCarFinancialMtrx(e);
			}
			//save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCarFinanAffairs(e);
			}
			//open screen
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0002(e);				
			}
		//FNS_JOO_0003 Vendor & Customer Code Inquiry
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0003Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVndrCustListByCar(e);
			//open screen
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0003(e);
			}
			//FNS_JOO_0004 Basic Port Creation & Inquiry By Settlement Item
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0004Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementBasicPortList(e);
			}
			//save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementBasicPort(e);
			}
			//inputting data after duplicate error
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = manageCopyBasicPort(e);
			}
			//Create
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchItemDirList(e);
			}
			//getting code data in case of opening screen
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0004(e);	
			}
		//FNS_JOO_0005 Target Voyage Creation & Inquiry By Settlement Item
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0005Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTargetVVDList(e);
			}
			//save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTargetVVD(e);
			}
			//create
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = createTargetVVDList(e);
			}
			//retrieving jo_mnu_nm
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchOusTdrRdrInBssPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeTargetVVD(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)){
				eventResponse = searchCloseYn(e);
			}
			//getting code data in case of opening screen
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0005(e);	
			}
		//FNS_JOO_0006 Carrier Merge
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0006Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCarrierMerge(e);
			}
			//save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCarrierMerge(e);
			}
			//getting code data in case of opening screen
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0006(e);	
			}
		//FNS_JOO_0028 Settlement Item List
		}else if (e.getEventName().equalsIgnoreCase("FnsJoo0028Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSTLItemAcctList(e);
			}
			//save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSTLItemAcct(e);
			}
			//getting code data in case of opening screen
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0028(e);	
			}
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0079Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0079(e);
            }
            //search
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchAuthorityOffice(e);
            }
            
            //save
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageAuthorityOffice(e);
            }
//        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0083Event")) {
//
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
//                eventResponse = searchArHqFnsJoo(e);
//            }
//            //search
//            else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//                eventResponse = searchOfficeMappingManagementList(e);
//            }        
//            //save
//            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//                eventResponse = manageOfficeMappingManagement(e);
//                
//            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//                eventResponse = openFnsJoo0083(e);
//            }    
 
//        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0085Event")) {
//
//            //search
//            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//                eventResponse = searchJooBzcAgmtList(e);
//            }        
//            //save
//            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//                eventResponse = manageJooBzcAgmt(e);
//            }                
//            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//                eventResponse = searchRefNoList(e);
//            }                
//            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//                eventResponse = searchRefNoNPeriod(e);
//            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
//                eventResponse = openFnsJoo0085(e);
//            }    
        }
		
		return eventResponse;
	}
	/**
	 * FNS_JOO_0028 : Retrieve
	 * retrieving Settlement Item
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSTLItemAcctList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//FnsJoo0028Event event = (FnsJoo0028Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<STLItemAcctVO> list = command.searchSTLItemAcctList();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0028 : Save
	 * saving Settlement Item
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSTLItemAcct(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0028Event event = (FnsJoo0028Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageSTLItemAcct(event.getSTLItemAcctVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0028 : screen open
	 * retrieving Estimate Account Code
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse openFnsJoo0028(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//Direction 
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> currList = codeUtil.getCodeSelect("CD02297", 0);
		String sheetComboAcct[] = StringUtil.split(BizComUtil.getCodeSelectString(currList),BizComUtil.CODE_DELIMITTER);

		eventResponse.setETCData("ESTM_ACCT_CD"  ,sheetComboAcct[0]);
		return eventResponse;
	}	
	

	/**
	 * FNS_JOO_0002 : screen open
	 * retrieving Trade code list and Currency list
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse openFnsJoo0002(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		//Mdm Trade 
		List<JooCodeInfoVO> list = command.searchMdmTrdCdList(jooCodeParamVO);

		String trdCombo = makeComboString(list, 1); //IBCombo, Code만

		CodeUtil codeUtil = CodeUtil.getInstance();
		
		//Currency 
		Collection<CodeInfo> currList = codeUtil.getCodeSelect("CD02081", 0);
		String currCombo[] = StringUtil.split(BizComUtil.getCodeSelectString(currList),BizComUtil.CODE_DELIMITTER);

		//Settlement Option Code (Bound, Round, Cycle)
		Collection<CodeInfo> joStlOptCdList = codeUtil.getCodeSelect("CD02346", 0);
		String joStlOptCdCombo[] = StringUtil.split(BizComUtil.getCodeSelectString(joStlOptCdList),BizComUtil.CODE_DELIMITTER);
		
		eventResponse.setETCData("trd_cd"   ,trdCombo);
		eventResponse.setETCData("CD02081"  ,currCombo[0]);
		eventResponse.setETCData("joStlOptCd",joStlOptCdCombo[0]);
		eventResponse.setETCData("joStlOptNm",joStlOptCdCombo[1]);
		
		return eventResponse;
	}	
	
	/**
	 * FNS_JOO_0002 : Retrieve
	 * retrieving Carrier and retrieving Financial Matrix by Carrier, Trade, Lane
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchCarFinancialMtrxList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0002Event event = (FnsJoo0002Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//Carrier
		CarrierVO carrierVO = event.getCarrierVO();

		CarFinanMtrxGrpVO grpVO = command.searchCarFinancialMtrxList(carrierVO);

		eventResponse.setRsVoList((List)grpVO.getRCarFinanMtrxVOs());
		eventResponse.setRsVoList((List)grpVO.getECarFinanMtrxVOs());
		eventResponse.setRsVo((CarrierVO)grpVO.getCarrierVO());
		return eventResponse;
	}

	/**
	 * FNS_JOO_0002 : Create
	 * saving Settlement Item
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse calCarFinancialMtrx(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0002Event event = (FnsJoo0002Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		CarrierVO carrierVO = event.getCarrierVO();
		carrierVO.setOfcCd   (account.getOfc_cd());

		String custCntCd = "";
		String custSeq   = "";
		if (carrierVO.getCustSeq() != null && carrierVO.getCustSeq().length() > 2){
			custCntCd = carrierVO.getCustSeq().substring(0,2);
			custSeq   = carrierVO.getCustSeq().substring(2);
		}
		carrierVO.setCustCntCd(custCntCd);
		carrierVO.setCustSeq  (custSeq);
		
		CarFinanMtrxGrpVO grpVO = command.calCarFinancialMtrx(carrierVO);
		
		eventResponse.setRsVoList((List)grpVO.getRCarFinanMtrxVOs());
		eventResponse.setRsVoList((List)grpVO.getECarFinanMtrxVOs());

		
//		if (grpVO.getRCarFinanMtrxVOs().isEmpty() && grpVO.getECarFinanMtrxVOs().isEmpty()){
//			eventResponse.setUserMessage("There is no data to be appended...");
//		}
		
		return eventResponse;
	}

	/**
	 * FNS_JOO_0002 : Save
	 * saving Financial Matrix
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiCarFinanAffairs(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0002Event event = (FnsJoo0002Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		try{
			begin();
			
			CarFinanMtrxGrpVO grpVO = event.getCarFinanMtrxGrpVO();
			command.manageCarFinancialMtrx(grpVO, account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * FNS_JOO_0006 : Retreive 
	 * retrieving Carrier Merge
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCarrierMerge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0006Event event = (FnsJoo0006Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<JooCrrMrgVO> list = command.searchCarrierMerge(event.getMstComInputVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0006 : Save
	 * saving Carrier Merge
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCarrierMerge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0006Event event = (FnsJoo0006Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageCarrierMerge(event.getJooCrrMrgVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0006 : screen open
	 * retrieving Trade, Lane, Carrier, Direction List
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private EventResponse openFnsJoo0006(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
		
		String tradeComboList = ",|"+makeComboString(list, 1); 
		String tradeSheetList = makeComboString(list, 2);   

		list = command.searchRLaneCodeListByTrade(jooCodeParamVO);
		
		Iterator iterator = (Iterator) list.iterator();

		String rlaneComboList = "";
		StringBuilder sb = new StringBuilder();
		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
			sb.append(jooCodeInfoVO.getSuperCd1()+","+jooCodeInfoVO.getCode()+"|");
		}
		
		rlaneComboList = sb.toString();
		
		if (rlaneComboList.length() > 0)
			rlaneComboList = rlaneComboList.substring(0,rlaneComboList.length()-1);			
		
		//Carrier 
		jooCodeParamVO.setSuperCd1("");
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setSortKey ("");

		// carrier code used in joint operation
		list = command.searchCarrierCodeList(jooCodeParamVO);

		String carriSheetList = makeComboString(list, 2);
		
		//Direction 
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> dirCodeList = codeUtil.getCodeSelect("CD00593", 0);
		String dirctSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(dirCodeList),BizComUtil.CODE_DELIMITTER);
		
		eventResponse.setETCData("tradeComboList" ,tradeComboList);
		eventResponse.setETCData("tradeSheetList" ,tradeSheetList);
		eventResponse.setETCData("rlaneSheetList", rlaneComboList);
		eventResponse.setETCData("carriSheetList", carriSheetList);
		eventResponse.setETCData("dirctSheetList", dirctSheetList[0]);

		return eventResponse;
	}
	

	/**
	 * FNS_JOO_0003 : screen Open 
	 * retrieving Carrier Code list
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0003(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		//Carrier 
		//jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);

		String crrCombo = ",|"+makeComboString(list, 1);

		eventResponse.setETCData("jo_crr_cd"  ,crrCombo);
		return eventResponse;
	}	

	
	/**
	 * FNS_JOO_0003 : Retrieve
	 * retrieving Vendor and Customer by carrier
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVndrCustListByCar(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0003Event event = (FnsJoo0003Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<CarrierVO> list = command.searchVndrCustListByCar(event.getCarrierVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0004 : screen open
	 * retrieving Carrier Code List, Settlement Item List, 
	 * Direction, Status (BETB, BETD, CETA, CETD), TDR/RDR
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse openFnsJoo0004(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		//Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
		
		String crrCombo = makeComboString(list, 1);

		jooCodeParamVO.setSuperCd1("Y"); //auto cre flg = 'Y'
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setName    ("");

		//ABBR
		list = command.searchStlItemCodeList(jooCodeParamVO);
		
		String abbrCombo = ",|" + makeComboString(list, 1); 

		CodeUtil codeUtil = CodeUtil.getInstance();
		
		//Direction 
		Collection<CodeInfo> dirCodeList = codeUtil.getCodeSelect("CD00593", 0);
		String dirSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(dirCodeList),BizComUtil.CODE_DELIMITTER);

		//STATUS 
//		Collection<CodeInfo> staCodeList = codeUtil.getCodeSelect("CD01869", 0);
//		String staSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(staCodeList),BizComUtil.CODE_DELIMITTER);

		//TDR/
		Collection<CodeInfo> tdrCodeList = codeUtil.getCodeSelect("CD01867", 0);
		String tdrSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(tdrCodeList),BizComUtil.CODE_DELIMITTER);
		
		//AR Head Quarter Office Code
		jooCodeParamVO.setCode(account.getOfc_cd());
		String arHqOfcCd = command.searchArHqOfcCd(jooCodeParamVO);

		
		Collection<CodeInfo> monthList = codeUtil.getCodeSelect("CD02366", 0);
		String monthSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(monthList),BizComUtil.CODE_DELIMITTER);
		
		//Port Condition, F-First, L-Last
		Collection<CodeInfo> portList = codeUtil.getCodeSelect("CD02369", 0);
		String portSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(portList),BizComUtil.CODE_DELIMITTER);
		
		//Port Type Condition,  L : Loading, D : Discharging
		Collection<CodeInfo> portTypeList = codeUtil.getCodeSelect("CD02368", 0);
		String portTypeSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(portTypeList),BizComUtil.CODE_DELIMITTER);

		//Operation Type Condition,  A : Arrival, B : Berth, D : Departure
		Collection<CodeInfo> operTypeList = codeUtil.getCodeSelect("CD02367", 0);
		String operTypeSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(operTypeList),BizComUtil.CODE_DELIMITTER);
		
		eventResponse.setETCData("jo_crr_cd"        , crrCombo );
		eventResponse.setETCData("jo_stl_cd"        , abbrCombo);
		eventResponse.setETCData("arHqOfcCd"        , arHqOfcCd);
		
		eventResponse.setCustomData("DIR", dirSheetList);
		//eventResponse.setCustomData("STA", staSheetList);
		eventResponse.setCustomData("TDR", tdrSheetList);
		eventResponse.setCustomData("MONTH", monthSheetList);
		eventResponse.setCustomData("PORT", portSheetList);
		eventResponse.setCustomData("PORT_TYPE", portTypeSheetList);
		eventResponse.setCustomData("OPER_TYPE", operTypeSheetList);

		return eventResponse;
	}	
	
	/**
	 * FNS_JOO_0004 : Retrieve
	 * retrieving Basic Port List
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementBasicPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0004Event event = (FnsJoo0004Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<StlBssPortVO> list = command.searchSettlementBasicPortList(event.getMstComInputVO(), event.getJoStlItmCd(), event.getSkdDirCd());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0004 : Save
	 * saving Settlement Basic Port
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementBasicPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0004Event event = (FnsJoo0004Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			int rtnVal = command.manageSettlementBasicPort(event.getJooStlBssPortVOS(),account);
			
			//duplicate error
			if (rtnVal == 1){
				eventResponse.setETCData("RTNVAL","E");
				rollback();
			//abnormal
			}else if (rtnVal == 999){
				eventResponse.setETCData("RTNVAL","W");
				rollback();
			//normal
			}else{
				eventResponse.setETCData("RTNVAL","N");
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0004 : Duplicate Error Confirm 
	 * deleting and inserting duplication data
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCopyBasicPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0004Event event = (FnsJoo0004Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageCopyBasicPort(event.getJooStlBssPortVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0004 : Create 
	 * retrieving Settlement Item and Direction(E,W)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchItemDirList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0004Event event = (FnsJoo0004Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<StlBssPortVO> list = command.searchItemDirList(event.getMstComInputVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if (list.isEmpty()){
			eventResponse.setUserMessage("There is no data appended...");
		}
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0005 : Open
	 * retrieving Carrier Code List, Settlement Item List, Direction List, Status List(BETB, BETD, CETA, CETD)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse openFnsJoo0005(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//FnsJoo0005Event event = (FnsJoo0005Event)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		
		//Carrier 
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
		
		String crrCombo = makeComboString(list, 1);

		jooCodeParamVO.setSuperCd1("");
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setName    ("");
		
		//ABBR
		list = command.searchStlItemCodeList(jooCodeParamVO);
		
		String abbrSheet = makeComboString(list, 2);

		//Direction 
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> dirCodeList = codeUtil.getCodeSelect("CD00593", 0);
		String dirSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(dirCodeList),BizComUtil.CODE_DELIMITTER);

		//STATUS 
//		Collection<CodeInfo> staCodeList = codeUtil.getCodeSelect("CD01869", 0);
//		String staSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(staCodeList),BizComUtil.CODE_DELIMITTER);

		//Fin. Dir 
//		Collection<CodeInfo> finCodeList = codeUtil.getCodeSelect("CD02115", 0);
//		String finSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(finCodeList),BizComUtil.CODE_DELIMITTER);
		
		
		Collection<CodeInfo> monthList = codeUtil.getCodeSelect("CD02366", 0);
		String monthSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(monthList),BizComUtil.CODE_DELIMITTER);
		
		//Port Condition, F-First, L-Last
		Collection<CodeInfo> portList = codeUtil.getCodeSelect("CD02369", 0);
		String portSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(portList),BizComUtil.CODE_DELIMITTER);
		
		//Port Type Condition,  L : Loading, D : Discharging
		Collection<CodeInfo> portTypeList = codeUtil.getCodeSelect("CD02368", 0);
		String portTypeSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(portTypeList),BizComUtil.CODE_DELIMITTER);

		//Operation Type Condition,  A : Arrival, B : Berth, D : Departure
		Collection<CodeInfo> operTypeList = codeUtil.getCodeSelect("CD02367", 0);
		String operTypeSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(operTypeList),BizComUtil.CODE_DELIMITTER);
		
		eventResponse.setETCData("jo_crr_cd"        , crrCombo );
		eventResponse.setETCData("sheet1_jo_stl_cd" , abbrSheet);

		eventResponse.setCustomData("DIR", dirSheetList);
		//eventResponse.setCustomData("STA", staSheetList);
		//eventResponse.setCustomData("FIN", finSheetList);
		eventResponse.setCustomData("MONTH", monthSheetList);
		eventResponse.setCustomData("PORT", portSheetList);
		eventResponse.setCustomData("PORT_TYPE", portTypeSheetList);
		eventResponse.setCustomData("OPER_TYPE", operTypeSheetList);

		return eventResponse;
	}	
	
	
	/**
	 * FNS_JOO_0005 : Retrieve 
	 * retrieving Target VVD
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTargetVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0005Event event = (FnsJoo0005Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		TargetVVDVO targetVVDVO = event.getTargetVVDVO(); 
		List<TargetVVDVO> list = command.searchTargetVVDList(targetVVDVO);
		//2015.04.07 NYK Modify
		/*
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setAcctYrmon(targetVVDVO.getAcctYrmon());
		jooCodeParamVO.setCode     (targetVVDVO.getReDivrCd());
		jooCodeParamVO.setOfcCd    (account.getOfc_cd());
		List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
		String clzYn = "O";
		if (lst.isEmpty()){
			clzYn = "C";
		}else{
			clzYn = lst.get(0).getCode();
		}*/
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		//eventResponse.setETCData("clz_yn", clzYn);
		return eventResponse;
	}
	
	/**
	 *  FNS_JOO_0005 : returning closing status 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCloseYn(Event e) throws EventException {
		FnsJoo0005Event event = (FnsJoo0005Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		TargetVVDVO targetVVDVO = event.getTargetVVDVO(); 
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setAcctYrmon(targetVVDVO.getAcctYrmon());
		jooCodeParamVO.setCode     (targetVVDVO.getReDivrCd());
		jooCodeParamVO.setOfcCd    (account.getOfc_cd());
		List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
		String clzYn = "O";
		if (lst.isEmpty()){
			clzYn = "C";
		}else{
			clzYn = lst.get(0).getCode();
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("clz_yn", clzYn);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0005 : Create 
	 * creating VVD exists not in Target VVD
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createTargetVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0005Event event = (FnsJoo0005Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		TargetVVDVO targetVVDVO = event.getTargetVVDVO(); 
		List<TargetVVDVO> list = command.createTargetVVDList(targetVVDVO, event.getJoStlOptCd());
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setAcctYrmon(targetVVDVO.getAcctYrmon());
		jooCodeParamVO.setCode     (targetVVDVO.getReDivrCd());
		jooCodeParamVO.setOfcCd    (account.getOfc_cd());
		List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
		String clzYn = "O";
		if (lst.isEmpty()){
			clzYn = "C";
		}else{
			clzYn = lst.get(0).getCode();
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("clz_yn", clzYn);
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0005 : Save 
	 * saving Target VVD
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageTargetVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0005Event event = (FnsJoo0005Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageTargetVVD(event.getJooStlVvdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_JOO_0005 : Settlement Item change
	 * retrieving RDR, TDR, UI from Basic Port information
	 * @param Event e 
	 * @return EventResponse
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchOusTdrRdrInBssPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0005Event event = (FnsJoo0005Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<JooStlVvdVO> list = command.searchOusTdrRdrInBssPort(event.getJooStlVvdVO());
		Iterator iterator = list.iterator();
		String joMnuNm = "";
		while(iterator.hasNext()){
			JooStlVvdVO vo = (JooStlVvdVO)iterator.next();
			joMnuNm = vo.getJoMnuNm();
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("jo_mnu_nm", joMnuNm);
		return eventResponse;
	}
	
	/**
	 * changing List to String
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private String makeComboString(List<JooCodeInfoVO> list, int flg) throws EventException{
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
			
			if (flg==0){
				sb.append(jooCodeInfoVO.getName()+","+jooCodeInfoVO.getCode()+"|");				
			//IBCombo (code, code|)
			}else if (flg==1){
				sb.append(jooCodeInfoVO.getCode()+","+jooCodeInfoVO.getCode()+"|");				
			//IBSheet code(code|)
			}else if (flg==2){
				sb.append(jooCodeInfoVO.getCode()+"|");				
			//IBSheet name(name|)
			}else if (flg==3){
				sb.append(jooCodeInfoVO.getName()+"|");				
			//SuperCd
			}else if (flg==4){
				sb.append(jooCodeInfoVO.getSuperCd1()+","+jooCodeInfoVO.getSuperCd2()+","+jooCodeInfoVO.getCode()+"|");				
			}else if (flg==5){
				sb.append(jooCodeInfoVO.getCode()+"\t"+jooCodeInfoVO.getName()+"|");				
			}
		}
		
		rtnVal = sb.toString();
		
		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}
		
		return rtnVal;
	}
    /**
     *  FNS_JOO_0079 : Open <br>
     *  retrieving Carrier Code<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse openFnsJoo0079(Event e) throws EventException {
        try{
            FnsJoo0079Event event = (FnsJoo0079Event)e;
            JOOFindCodeAndCheckBC    command    = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse  = new GeneralEventResponse();
            AuthorityOfficeVO authorityOfficeVO = event.getAuthorityOfficeVO();
            
            //authDelcheckYn
            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
            jooCodeParamVO.setAuthDelcheckYn(  authorityOfficeVO.getAuthDelcheckYn() );
            
            List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
            List<JooCodeInfoVO> officelist = command.searchAuthOfficeList(jooCodeParamVO);
            
            eventResponse.setRsVoList( carrlist   );
            eventResponse.setRsVoList( officelist   );
            return eventResponse;
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
    }  
    /**
     * FNS_JOO_0079 : Retrieve
     * D : [FnsJoo0079Event]<br>
     * retrieving authority of Authority Office Creation.<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchAuthorityOffice(Event e) throws EventException {
 
        FnsJoo0079Event event = (FnsJoo0079Event)e;
        JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
        List<AuthorityOfficeVO> list = command.searchAuthorityOffice(   event.getAuthorityOfficeVO() );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
    
    /**
     * FNS_JOO_0079 : Save
     * D : [FnsJoo0079Event]<br>
     * saving locale authority of Authority Office Creation<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse manageAuthorityOffice(Event e) throws EventException {
        JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
 
        FnsJoo0079Event event = (FnsJoo0079Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            
            command.manageAuthorityOffice( event.getAuthorityOfficeVOs() , this.account);
             
            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());            
            commit();
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * FNS_JOO_0083 : Open <br>
     *
     * @throws EventException
     * @return EventResponse
     * @author
     */
//    private EventResponse openFnsJoo0083(Event e) throws EventException {
//    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//    	FnsJoo0083Event event = (FnsJoo0083Event) e;
//    	
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        	
//		String offCombo = "";
//		List<JooCodeInfoVO> list = command.searchArHqOfcAllList(event.getJooCodeParamVO());
//		log.debug("list:"+list);
//		offCombo = " ,|"+makeComboString(list, 1);
//		
//		eventResponse.setETCData("office", offCombo);
//        return eventResponse;        
//    }
    
	/**
	 * FNS_JOO_0083 : search rhq by office
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author
	 */
//	private EventResponse searchArHqFnsJoo(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//		FnsJoo0083Event event = (FnsJoo0083Event) e;		
//		
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		String arHqOfcCd = command.searchArHqOfcCd(event.getJooCodeParamVO());	
//		
//		eventResponse.setETCData("arHqOfcCd"   , arHqOfcCd);
//		return eventResponse;
//	}
	
    /**
     * FNS_JOO_0083 : Retrieve
     * D : [FnsJoo0083Event]<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author
     */
//    private EventResponse searchOfficeMappingManagementList(Event e) throws EventException {
// 
//        FnsJoo0083Event event = (FnsJoo0083Event)e;
//        JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
//        List<CustomSearchOfficeMappingManagementVO> list = command.searchOfficeMappingManagementList( event.getCustomSearchOfficeMappingManagementVO());
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        eventResponse.setRsVoList(list);
//        return eventResponse;   
//    }
    
    /**
     * FNS_JOO_0083 : Save
     * D : [FnsJoo0083Event]<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author
     */
//    private EventResponse manageOfficeMappingManagement(Event e) throws EventException {
//        JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
// 
//        FnsJoo0083Event event = (FnsJoo0083Event) e;
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
// 
//        try {
//            begin();
//            String rtnVal = command.manageOfficeMappingManagement( event.getCustomSearchOfficeMappingManagementVOs() , this.account);             
//            eventResponse.setETCData("iRtn", rtnVal);
//            if ("".equals(rtnVal)){
//                eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
//            	commit();      
//            } else {
//            	rollback();
//            }            
//        } catch (EventException ex) {
//            log.error("error "+ex.toString(), ex);
//            rollback();
//            throw ex;
//        } catch (Exception ex) {
//            rollback();
//            log.error("error "+ex.toString(), ex);
//            throw new EventException(ex.getMessage(), ex);
//        }
//
//        return eventResponse;
//    }
    
	/**
	 * FNS_JOO_0005 : Delete 
	 * deleting target VVD
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeTargetVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0005Event event = (FnsJoo0005Event)e;
		JointOperationMasterDataMgtBC command  = new JointOperationMasterDataMgtBCImpl();
		CarrierSettlementProcessBC    command1 = new CarrierSettlementProcessBCImpl();

		try{
			begin();
			int iRslt = command1.removeStlDtlAndSettlement(event.getJooStlVvdVOS());
			
			if (iRslt == 2292){
				eventResponse.setETCData("RTNVAL", "E");
				rollback();
			}else{
				command.removeTargetVVD(event.getJooStlVvdVOS());
				eventResponse.setETCData("RTNVAL", "S");
				eventResponse.setUserMessage(new ErrorHandler("JOO10005").getUserMessage());
				commit();
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


//	/**
//	 * FNS_JOO_0085 OPEN
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse openFnsJoo0085(Event e) throws EventException {
//    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
//    	//FnsJoo0085Event event = (FnsJoo0085Event) e;
//    	
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        
//        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//
//        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
//        
//        String crrCdList = makeComboString(list, 0);
//		eventResponse.setETCData("CRR_CD_LIST",crrCdList);
//
//		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
//        
//        String trdCdList = makeComboString(list, 0);
//		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
//		
//		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
//		
//		String crrTrdLaneList = makeComboString(list, 4);
//		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);
//		
//		//Direction 
//		CodeUtil codeUtil = CodeUtil.getInstance();
//		
//		Collection<CodeInfo> joBkgTpCdList = codeUtil.getCodeSelect("CD02791", 0);
//		Collection<CodeInfo> joSrcCdList   = codeUtil.getCodeSelect("CD02792", 0);
//
//		String joBkgTpCd[] = StringUtil.split(BizComUtil.getCodeSelectString(joBkgTpCdList),BizComUtil.CODE_DELIMITTER);
//		String joSrcCd  [] = StringUtil.split(BizComUtil.getCodeSelectString(joSrcCdList  ),BizComUtil.CODE_DELIMITTER);
//
//		eventResponse.setETCData("JO_BKG_TP_CD",joBkgTpCd[0]);
//		eventResponse.setETCData("JO_BKG_TP_NM",joBkgTpCd[1]);
//		eventResponse.setETCData("JO_SRC_CD"   ,joSrcCd  [0]);
//		eventResponse.setETCData("JO_SRC_NM"   ,joSrcCd  [1]);
//		
//        return eventResponse;        
//    }

//	/**
//	 * Business Agreement List 
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse searchJooBzcAgmtList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FnsJoo0085Event event = (FnsJoo0085Event)e;
//		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
//		List<CusBzcAgmtVO> list = command.searchJooBzcAgmtList(event.getCusBzcAgmtVO());
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}

//	/**
//	 * Businesss Agreement 
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse manageJooBzcAgmt(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FnsJoo0085Event event = (FnsJoo0085Event)e;
//		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
//		
//		try{
//			begin();
//			String rtnVal = command.manageJooBzcAgmt(event.getCusBzcAgmtVOS(),account);
//
//			if ("".equals(rtnVal)){
//				eventResponse.setETCData("RTNVAL","N");
//				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
//				commit();
//			}else{
//				eventResponse.setETCData("RTNVAL",rtnVal);
//				rollback();
//			}
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		}catch(Exception ex){
//			rollback();
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}

//	/**
//	 * Business Agreement Ref. No List 
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse searchRefNoList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		//FnsJoo0085Event event = (FnsJoo0085Event)e;
//		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
//		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//		List<JooCodeInfoVO> list = command.searchRefNoList(jooCodeParamVO);
//		
//		String refNoComboList = makeComboString(list, 1);
//		eventResponse.setETCData("REF_NO_COMBO", refNoComboList);
//		return eventResponse;
//	}

//	/**
//	 * Business Agreement List 
//	 * @param Event e
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse searchRefNoNPeriod(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FnsJoo0085Event event = (FnsJoo0085Event)e;
//		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
//		List<CusBzcAgmtVO> list = command.searchRefNoNPeriod(event.getCusBzcAgmtVO());
//		
//		StringBuffer code = new StringBuffer();
//		StringBuffer text = new StringBuffer();
//		
//		if (!list.isEmpty()){
//			for (int i=0; i<list.size(); i++){
//				if (i==list.size()-1){
//					code.append(list.get(i).getJoRefNo());
//					text.append(list.get(i).getJoRefNo()+"\t"+list.get(i).getAgmtEffDt()+"\t"+list.get(i).getAgmtExpDt());
//				}else{
//					code.append(list.get(i).getJoRefNo()+"|");
//					text.append(list.get(i).getJoRefNo()+"\t"+list.get(i).getAgmtEffDt()+"\t"+list.get(i).getAgmtExpDt()+"|");
//				}
//			}
//		}
//		eventResponse.setETCData("CODE", code.toString());
//		eventResponse.setETCData("TEXT", text.toString());
//		return eventResponse;
//	}
} 