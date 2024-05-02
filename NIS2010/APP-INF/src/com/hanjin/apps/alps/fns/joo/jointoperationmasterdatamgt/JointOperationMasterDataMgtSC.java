/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtSC.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.04.24 박희동
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBC;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBC;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0002Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0003Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0004Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0005Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0006Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0028Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0079Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0083Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0085Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0086Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0091Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0092Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0093Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0095Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0096Event;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AdditionalSlotManageVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BlkVygSttsVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaCarrieHistoryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaInformationEntryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BzcAgmtCrrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.StlBssPortVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.bizcommon.util.BizComUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.StringUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooCrrMrgVO;
import com.hanjin.syscommon.common.table.JooStlVvdVO;


/**
 * ALPS-JointOperationMasterDataMgtSC Business Logic ServiceCommand - ALPS-JointOperationMasterDataMgtSC 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Park Hee Dong
 * @see JointOperationMasterDataMgtBCDBDAO
 * @since J2EE 1.4
 */

public class JointOperationMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JointOperationMasterDataMgtSC system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * JointOperationMasterDataMgtSC system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("JointOperationMasterDataMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-JointOperationMasterDataMgtSC system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		
		//FNS_JOO_0002 Financial Affairs Creation & Inquiry
		if (e.getEventName().equalsIgnoreCase("FnsJoo0002Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCarFinancialMtrxList(e);
			}
			//Create
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = calCarFinancialMtrx(e);
			}
			//저장
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCarFinanAffairs(e);
			}
			//화면 Open
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0002(e);				
			}
		//FNS_JOO_0003 Vendor & Customer Code Inquiry
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0003Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVndrCustListByCar(e);
			//화면 Open
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0003(e);
			}
			//FNS_JOO_0004 Basic Port Creation & Inquiry By Settlement Item
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0004Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementBasicPortList(e);
			}
			//저장
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementBasicPort(e);
			}
			//duplicate error가 난 경우 user의 confirm을 받고 Data 삭제 후 입력하는 이벤트 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = manageCopyBasicPort(e);
			}
			//Create
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchItemDirList(e);
			}
			//화면 Open시 코드성 data읽어오기
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0004(e);	
			}
		//FNS_JOO_0005 Target Voyage Creation & Inquiry By Settlement Item
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0005Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTargetVVDList(e);
			}
			//저장
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTargetVVD(e);
			}
			//create
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = createTargetVVDList(e);
			}
			//jo_stl_itm_cd 가 OUS인 경우 jo_mnu_nm을 읽어온다.(RDR, TDR, UI)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchOusTdrRdrInBssPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeTargetVVD(e);
			}
			//화면 Open시 코드성 data읽어오기
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0005(e);	
			}
		//FNS_JOO_0006 Carrier Merge
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0006Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCarrierMerge(e);
			}
			//저장
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCarrierMerge(e);
			}
			//화면 Open시 코드성 data읽어오기
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0006(e);	
			}
		//FNS_JOO_0028 Settlement Item List 화면의 이벤트
		}else if (e.getEventName().equalsIgnoreCase("FnsJoo0028Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSTLItemAcctList(e);
			}
			//저장
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSTLItemAcct(e);
			}
			//화면 Open시 코드성 data읽어오기
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0028(e);	
			}
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0079Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0079(e);
            }
            //조회
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchAuthorityOffice(e);
            }
            
            //저장
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageAuthorityOffice(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0083Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchArHqFnsJoo(e);
            }
            //조회
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchOfficeMappingManagementList(e);
            }        
            //저장
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageOfficeMappingManagement(e);
                
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0083(e);
            }    
 
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0085Event")) {

            //조회
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchJooBzcAgmtList(e);
            }        
            //저장
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageJooBzcAgmt(e);
            }                
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRefNoList(e);
            }                
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRefNoNPeriod(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0085(e);
            }    
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0086Event")) {

            //조회
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchAddCarriersList(e);
            }        
            //저장
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = addCarriersList(e);
            }                
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRefNoList(e);
            }                
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRefNoNPeriod(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0086(e);
            }    
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0091Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0091(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchBsaInformationEntryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchBsaInformationYyyyWwDt(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
            	eventResponse = searchBsaInformationEntryListForTargetExcel(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageBsaInformationEntryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
            	eventResponse = manageAddCarrierList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0092Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchBsaInformationEntryHistoryList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0092(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0093Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchAddBsaCarrieList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageAddBsaCarrieList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0093(e);
            }  
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0096Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0096(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAdditionalSlotManage(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageAdditionalSlotManage(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
            	eventResponse = manageAddCarrierList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("FnsJoo0095Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	        	eventResponse = searchBlankVoyageStatus(e);
	        } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
	        	eventResponse = manageBlankVoyageStatus(e);              
	        } else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
	            eventResponse = openFnsJoo0095(e);
	        }
        }
		return eventResponse;
	}
	/**
	 * FNS_JOO_0028 : Retrieve
	 * Settlement Item 을 조회한다.
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
	 * Settlement Item 을 저장한다.
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
	 * FNS_JOO_0028 : 화면 open
	 * 화면이 open될 때 필요한 Estimate Account Code 를 조회한다. 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0028(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//Direction 조회
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> currList = codeUtil.getCodeSelect("CD02297", 0);
		String sheetComboAcct[] = StringUtil.split(BizComUtil.getCodeSelectString(currList),BizComUtil.CODE_DELIMITTER);

		eventResponse.setETCData("ESTM_ACCT_CD"  ,sheetComboAcct[0]);
		return eventResponse;
	}	
	

	/**
	 * FNS_JOO_0002 : 화면 open
	 * 화면이 open될 때 필요한 Trade코드 리스트와, Currency 리스트를 조회한다. 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0002(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		//Mdm Trade 코드 조회
		List<JooCodeInfoVO> list = command.searchMdmTrdCdList(jooCodeParamVO);

		String trdCombo = makeComboString(list, 1); //IBCombo, Code만

		CodeUtil codeUtil = CodeUtil.getInstance();
		
		//Currency 공통코드 조회
		Collection<CodeInfo> currList = codeUtil.getCodeSelect("CD02081", 0);
		String currCombo[] = StringUtil.split(BizComUtil.getCodeSelectString(currList),BizComUtil.CODE_DELIMITTER);

		//Settlement Option Code 조회 (Bound, Round, Cycle)
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
	 * Carrier, Trade, Lane을 조회조건으로 Carrier정보와 Financial Matrix를 조회한다. 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
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
	 * Financial Matrix에 존재하지 않는 Settlement Item을 조회하여 저장할 수 있도록 한다. 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
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

		//둘다 비었다면 Message 띄워줌
//		if (grpVO.getRCarFinanMtrxVOs().isEmpty() && grpVO.getECarFinanMtrxVOs().isEmpty()){
//			eventResponse.setUserMessage("There is no data to be appended...");
//		}
		
		return eventResponse;
	}

	/**
	 * FNS_JOO_0002 : Save
	 * Financial Matrix를 저장한다.
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
			//Revenue와 Expense list를 담는다. 
			CarFinanMtrxGrpVO grpVO = event.getCarFinanMtrxGrpVO();			
			if("2".equals(event.getCarrierVO().getChgOfcGubun())){
				grpVO.setCarrierVO(event.getCarrierVO());				
				// Change Ofc 버튼 클릭시 실행												
				command.manageCarFinancialMtrxChgOfc(grpVO, account);
			}else if("1".equals(event.getCarrierVO().getChgOfcGubun())){
				//Save 버튼 클릭시 실행
				command.manageCarFinancialMtrx(grpVO, account);				
			}else if("3".equals(event.getCarrierVO().getChgOfcGubun())){
				//PIC Save 버튼 클릭시 실행
				command.managePic(grpVO, account);
			}
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
	 * Carrier Merge 정보를 조회한다.
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
	 * Carrier Merge정보를 저장한다.
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
	 * FNS_JOO_0006 : 화면 open
	 * open시 필요한 Trade, Lane, Carrier, Direction List를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0006(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		//공동운항에 등록된 모든 TRADE조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
		
		String tradeComboList = ",|"+makeComboString(list, 1); //IBCombo 용
		String tradeSheetList = makeComboString(list, 2);   //IBSheet 용 

		//공동운항에 등록된 모든 lane코드를 조회하되 trade코드도 같이 조회한다.
		//Lane Code 조회
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
		
		//Carrier 조회
		jooCodeParamVO.setSuperCd1("");
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setSortKey ("");

		// 공동운항에 등록된 모든 Carrier를 조회한다.
		list = command.searchCarrierCodeList(jooCodeParamVO);

		String carriSheetList = makeComboString(list, 2);
		
		//Direction 조회
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
	 * FNS_JOO_0003 : 화면 Open 
	 * Open시 필요한 Carrier Code list를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0003(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		//Carrier 코드 조회
		//jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);

		String crrCombo = ",|"+makeComboString(list, 1);

		eventResponse.setETCData("jo_crr_cd"  ,crrCombo);
		return eventResponse;
	}	

	
	/**
	 * FNS_JOO_0003 : Retrieve
	 * 선사별 Vendor와 Customer 정보를 조회한다.
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
	 * FNS_JOO_0004 : 화면 open
	 * Basic Port 화면 open시에 Carrier Code List, Settlement Item List, 
	 * Direction 정보, Status (BETB, BETD, CETA, CETD), TDR/RDR 구분등의 Code List를 조회한다.   
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0004(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		//Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
		
		String crrCombo = makeComboString(list, 1);

		jooCodeParamVO.setSuperCd1("Y"); //auto cre flg = 'Y' 인 것만
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setName    ("");

		//ABBR조회
		list = command.searchStlItemCodeList(jooCodeParamVO);
		
		String abbrCombo = ",|" + makeComboString(list, 1); //IBCombo용

		CodeUtil codeUtil = CodeUtil.getInstance();
		
		//Direction 조회
		Collection<CodeInfo> dirCodeList = codeUtil.getCodeSelect("CD00593", 0);
		String dirSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(dirCodeList),BizComUtil.CODE_DELIMITTER);

		//STATUS 조회
//		Collection<CodeInfo> staCodeList = codeUtil.getCodeSelect("CD01869", 0);
//		String staSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(staCodeList),BizComUtil.CODE_DELIMITTER);

		//TDR/RDR조회
		Collection<CodeInfo> tdrCodeList = codeUtil.getCodeSelect("CD01867", 0);
		String tdrSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(tdrCodeList),BizComUtil.CODE_DELIMITTER);
		
		//AR Head Quarter Office Code를 조회한다. ==> 서남아지역인지 확인하기 위함
		jooCodeParamVO.setCode(account.getOfc_cd());
		String arHqOfcCd = command.searchArHqOfcCd(jooCodeParamVO);

		//Month Condition, C-당월,B-전월,N-익월,T-두달전
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
	 * Settlement Basic Port list를 조회한다.
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
	 * Settlement Basic Port 정보를 저장한다.
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
			//Carrier-Trade-Lane관계가 옳지 않음
			}else if (rtnVal == 999){
				eventResponse.setETCData("RTNVAL","W");
				rollback();
			//정상
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
	 * Duplicate Error 가 나서 User의 Confirm 을 받은 후 기존 data를 삭제하고 Insert한다.
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
	 * Basic Port 정보에 존재하지 않는 Settlement Item 과 Direction(E,W)을 조회하여 저장하도록 한다. 
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
	 * Carrier Code List, Settlement Item List, Direction List, Status List(BETB, BETD, CETA, CETD)를 조회한다. 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0005(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//FnsJoo0005Event event = (FnsJoo0005Event)e;

		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		
		//Carrier 조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);
		
		String crrCombo = makeComboString(list, 1);

		jooCodeParamVO.setSuperCd1("");
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setName    ("");
		
		//ABBR조회
		list = command.searchStlItemCodeList(jooCodeParamVO);
		
		String abbrSheet = makeComboString(list, 2);//IBSheet 내 combo용

		//Direction 조회
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> dirCodeList = codeUtil.getCodeSelect("CD00593", 0);
		String dirSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(dirCodeList),BizComUtil.CODE_DELIMITTER);

		//STATUS 조회
//		Collection<CodeInfo> staCodeList = codeUtil.getCodeSelect("CD01869", 0);
//		String staSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(staCodeList),BizComUtil.CODE_DELIMITTER);

		//Fin. Dir 조회
//		Collection<CodeInfo> finCodeList = codeUtil.getCodeSelect("CD02115", 0);
//		String finSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(finCodeList),BizComUtil.CODE_DELIMITTER);
		
		//Month Condition, C-당월,B-전월,N-익월,T-두달전
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
	 * Target VVD를 조회한다.
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
	 * FNS_JOO_0005 : Create 
	 * Target VVD에 존재하지 않는 항차정보를 Basic Port정보에서 조회하여 저장할 수 있도록 한다.
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
	 * Target VVD를 저장한다.
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
			List<JooStlVvdVO> list= command.manageTargetVVD(event.getJooStlVvdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();

			Iterator iterator = (Iterator) list.iterator();

			String vvdItemList = "";
			StringBuilder sb = new StringBuilder();
			while(iterator.hasNext()){
				JooStlVvdVO jooStlVvdVO = (JooStlVvdVO)iterator.next();
				sb.append(jooStlVvdVO.getVvdItem()+"|");
			}
			
			vvdItemList = sb.toString();
			
			if (vvdItemList.length() > 0)
				vvdItemList = vvdItemList.substring(0,vvdItemList.length()-1);	
			
			eventResponse.setETCData("vvditem", vvdItemList);
			
			//String vvdItem = "";
			//while(iterator.hasNext()){
			//	JooStlVvdVO vo = (JooStlVvdVO)iterator.next();
			//	vvdItem = vo.getVvdItem();
			//}
			//eventResponse.setETCData("vvditem", vvdItem);
			
			//eventResponse.setRsVoList(list);
			
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
	 * FNS_JOO_0005 : Settlement Item 변경
	 * Settlement Item이 'OUS'-Over Used인 경우 jo_mnu_nm에 RDR, TDR, UI를 Basic Port의 JO_STL_TGT_TP_CD 에서 조회한다.
	 * @param Event e 
	 * @return EventResponse
	 * @throws EventException
	 */
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
	 * List를 IBMultiCombo나 IBSheet내의 Combo의 item으로 넣기 위해 String으로 변환해준다.
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	private String makeComboString(List<JooCodeInfoVO> list, int flg) throws EventException{
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
			//일반적인 IBCombo용(name, code|)
			if (flg==0){
				sb.append(jooCodeInfoVO.getName()+","+jooCodeInfoVO.getCode()+"|");				
			//IBCombo (code, code|)
			}else if (flg==1){
				sb.append(jooCodeInfoVO.getCode()+","+jooCodeInfoVO.getCode()+"|");				
			//IBSheet의 코드부분(code|)
			}else if (flg==2){
				sb.append(jooCodeInfoVO.getCode()+"|");				
			//IBSheet의 코드명부분(name|)
			}else if (flg==3){
				sb.append(jooCodeInfoVO.getName()+"|");				
			//SuperCd조회
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
     *  Authority Office Creation 의 Open시, Carrier Code를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
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
     * Authority Office Creation 의 권한정보를 조회  합니다.<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
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
     * Authority Office Creation 의 지역 권한정보를 저장  합니다.<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
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
     * Office Mapping Management 의 Open 시, RHQ Code 를 조회 합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author Jong kyu Weon
     */
    private EventResponse openFnsJoo0083(Event e) throws EventException {
    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    	FnsJoo0083Event event = (FnsJoo0083Event) e;
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        	
		String offCombo = "";
		List<JooCodeInfoVO> list = command.searchArHqOfcAllList(event.getJooCodeParamVO());
		log.debug("list:"+list);
		offCombo = " ,|"+makeComboString(list, 1);
		
		eventResponse.setETCData("office", offCombo);
        return eventResponse;        
    }
    
	/**
	 * FNS_JOO_0083 : search rhq by office
	 * office 에 해당하는 RHQ를 조회한다.   
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author Jong Kyu Weon
	 */
	private EventResponse searchArHqFnsJoo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		FnsJoo0083Event event = (FnsJoo0083Event) e;		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String arHqOfcCd = command.searchArHqOfcCd(event.getJooCodeParamVO());	
		
		eventResponse.setETCData("arHqOfcCd"   , arHqOfcCd);
		return eventResponse;
	}
	
    /**
     * FNS_JOO_0083 : Retrieve
     * D : [FnsJoo0083Event]<br>
     * Office Mapping Management 의 Office 정보를 조회합니다.<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author Jong Kyu Weon
     */
    private EventResponse searchOfficeMappingManagementList(Event e) throws EventException {
 
        FnsJoo0083Event event = (FnsJoo0083Event)e;
        JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
        List<CustomSearchOfficeMappingManagementVO> list = command.searchOfficeMappingManagementList( event.getCustomSearchOfficeMappingManagementVO());
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        return eventResponse;   
    }
    
    /**
     * FNS_JOO_0083 : Save
     * D : [FnsJoo0083Event]<br>
     * Office Mapping Management 의 Office 정보를 저장합니다.<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author Jong Kyu Weon
     */
    private EventResponse manageOfficeMappingManagement(Event e) throws EventException {
        JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
 
        FnsJoo0083Event event = (FnsJoo0083Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            String rtnVal = command.manageOfficeMappingManagement( event.getCustomSearchOfficeMappingManagementVOs() , this.account);             
            eventResponse.setETCData("iRtn", rtnVal);
            if ("".equals(rtnVal)){
                eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
            	commit();      
            } else {
            	rollback();
            }            
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
	 * FNS_JOO_0005 : Delete 
	 * Target VVD를 삭제한다.
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


	/**
	 * FNS_JOO_0085 OPEN
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0085(Event e) throws EventException {
    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    	//FnsJoo0085Event event = (FnsJoo0085Event) e;
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
        
        String crrCdList = makeComboString(list, 0);
		eventResponse.setETCData("CRR_CD_LIST",crrCdList);

		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        
        String trdCdList = makeComboString(list, 0);
		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
		
		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		
		String crrTrdLaneList = makeComboString(list, 4);
		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);
		
		//Direction 조회
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> joBkgTpCdList = codeUtil.getCodeSelect("CD02791", 0);
		Collection<CodeInfo> joSrcCdList   = codeUtil.getCodeSelect("CD02792", 0);

		String joBkgTpCd[] = StringUtil.split(BizComUtil.getCodeSelectString(joBkgTpCdList),BizComUtil.CODE_DELIMITTER);
		String joSrcCd  [] = StringUtil.split(BizComUtil.getCodeSelectString(joSrcCdList  ),BizComUtil.CODE_DELIMITTER);
		
		//////////////////////////2011-12-09 Ofc_Cd 추가
		String ofcCd = this.account.getOfc_cd();

		//Office Code 조회
		String offCombo = "";
		if ("SELADG".equals(ofcCd)){
			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list1, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}
        eventResponse.setETCData("OFC_CD", offCombo);
		//////////////////////////2011-12-09 Ofc_Cd 추가
        
		
		eventResponse.setETCData("JO_BKG_TP_CD",joBkgTpCd[0]);
		eventResponse.setETCData("JO_BKG_TP_NM",joBkgTpCd[1]);
		eventResponse.setETCData("JO_SRC_CD"   ,joSrcCd  [0]);
		eventResponse.setETCData("JO_SRC_NM"   ,joSrcCd  [1]);
		
        return eventResponse;        
    }
	
	/**
	 * FNS_JOO_0086 OPEN
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0086(Event e) throws EventException {
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    	//FnsJoo0085Event event = (FnsJoo0085Event) e;
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
        
        String crrCdList = makeComboString(list, 0);
		eventResponse.setETCData("CRR_CD_LIST",crrCdList);

		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        
        String trdCdList = makeComboString(list, 0);
		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
		
		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		
		String crrTrdLaneList = makeComboString(list, 4);
		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);
		
		//Direction 조회
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> joBkgTpCdList = codeUtil.getCodeSelect("CD02791", 0);
		Collection<CodeInfo> joSrcCdList   = codeUtil.getCodeSelect("CD02792", 0);

		String joBkgTpCd[] = StringUtil.split(BizComUtil.getCodeSelectString(joBkgTpCdList),BizComUtil.CODE_DELIMITTER);
		String joSrcCd  [] = StringUtil.split(BizComUtil.getCodeSelectString(joSrcCdList  ),BizComUtil.CODE_DELIMITTER);
		
		//////////////////////////2011-12-09 Ofc_Cd 추가
		String ofcCd = this.account.getOfc_cd();

		//Office Code 조회
		String offCombo = "";
		if ("SELADG".equals(ofcCd)){
			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list1, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}
        eventResponse.setETCData("OFC_CD", offCombo);
		//////////////////////////2011-12-09 Ofc_Cd 추가
        
		
		eventResponse.setETCData("JO_BKG_TP_CD",joBkgTpCd[0]);
		eventResponse.setETCData("JO_BKG_TP_NM",joBkgTpCd[1]);
		eventResponse.setETCData("JO_SRC_CD"   ,joSrcCd  [0]);
		eventResponse.setETCData("JO_SRC_NM"   ,joSrcCd  [1]);
		
        return eventResponse;        
    }

	/**
	 * FNS_JOO_0092 OPEN
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0092(Event e) throws EventException {
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
        
        String crrCdList = makeComboString(list, 0);
		eventResponse.setETCData("CRR_CD_LIST",crrCdList);

		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        
        String trdCdList = makeComboString(list, 0);
		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
		
		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		
		String crrTrdLaneList = makeComboString(list, 4);
		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);
		
		//Direction 조회
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> joBkgTpCdList = codeUtil.getCodeSelect("CD02791", 0);
		Collection<CodeInfo> joSrcCdList   = codeUtil.getCodeSelect("CD02792", 0);

		String joBkgTpCd[] = StringUtil.split(BizComUtil.getCodeSelectString(joBkgTpCdList),BizComUtil.CODE_DELIMITTER);
		String joSrcCd  [] = StringUtil.split(BizComUtil.getCodeSelectString(joSrcCdList  ),BizComUtil.CODE_DELIMITTER);
		
		//////////////////////////2011-12-09 Ofc_Cd 추가
		String ofcCd = this.account.getOfc_cd();

		//Office Code 조회
		String offCombo = "";
		if ("SELADG".equals(ofcCd)){
			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list1, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}
        eventResponse.setETCData("OFC_CD", offCombo);
		//////////////////////////2011-12-09 Ofc_Cd 추가
        
		
		eventResponse.setETCData("JO_BKG_TP_CD",joBkgTpCd[0]);
		eventResponse.setETCData("JO_BKG_TP_NM",joBkgTpCd[1]);
		eventResponse.setETCData("JO_SRC_CD"   ,joSrcCd  [0]);
		eventResponse.setETCData("JO_SRC_NM"   ,joSrcCd  [1]);
		
        return eventResponse;        
    }
	/**
	 * FNS_JOO_0093 OPEN
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0093(Event e) throws EventException {
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
        
        String crrCdList = makeComboString(list, 0);
		eventResponse.setETCData("CRR_CD_LIST",crrCdList);

		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        
        String trdCdList = makeComboString(list, 0);
		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
		
		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		
		String crrTrdLaneList = makeComboString(list, 4);
		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);
		
		//Direction 조회
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> joBkgTpCdList = codeUtil.getCodeSelect("CD02791", 0);
		Collection<CodeInfo> joSrcCdList   = codeUtil.getCodeSelect("CD02792", 0);

		String joBkgTpCd[] = StringUtil.split(BizComUtil.getCodeSelectString(joBkgTpCdList),BizComUtil.CODE_DELIMITTER);
		String joSrcCd  [] = StringUtil.split(BizComUtil.getCodeSelectString(joSrcCdList  ),BizComUtil.CODE_DELIMITTER);
		
		//////////////////////////2011-12-09 Ofc_Cd 추가
		String ofcCd = this.account.getOfc_cd();

		//Office Code 조회
		String offCombo = "";
		if ("SELADG".equals(ofcCd)){
			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list1, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}
        eventResponse.setETCData("OFC_CD", offCombo);
		//////////////////////////2011-12-09 Ofc_Cd 추가
        
		
		eventResponse.setETCData("JO_BKG_TP_CD",joBkgTpCd[0]);
		eventResponse.setETCData("JO_BKG_TP_NM",joBkgTpCd[1]);
		eventResponse.setETCData("JO_SRC_CD"   ,joSrcCd  [0]);
		eventResponse.setETCData("JO_SRC_NM"   ,joSrcCd  [1]);
		
        return eventResponse;        
    }
	/**
	 * Business Agreement List 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchJooBzcAgmtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0085Event event = (FnsJoo0085Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<CusBzcAgmtVO> list = command.searchJooBzcAgmtList(event.getCusBzcAgmtVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * Businesss Agreement 저장
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageJooBzcAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0085Event event = (FnsJoo0085Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			String rtnVal = command.manageJooBzcAgmt(event.getCusBzcAgmtVOS(),account);

			if ("".equals(rtnVal)){
				eventResponse.setETCData("RTNVAL","N");
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}else{
				eventResponse.setETCData("RTNVAL",rtnVal);
				rollback();
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
	 * Business Agreement Ref. No List 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRefNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//FnsJoo0085Event event = (FnsJoo0085Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		List<JooCodeInfoVO> list = command.searchRefNoList(jooCodeParamVO);
		
		String refNoComboList = makeComboString(list, 1);
		eventResponse.setETCData("REF_NO_COMBO", refNoComboList);
		return eventResponse;
	}

	/**
	 * Business Agreement List 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRefNoNPeriod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0085Event event = (FnsJoo0085Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<CusBzcAgmtVO> list = command.searchRefNoNPeriod(event.getCusBzcAgmtVO());
		
		StringBuffer code = new StringBuffer();
		StringBuffer text = new StringBuffer();
		
		if (!list.isEmpty()){
			for (int i=0; i<list.size(); i++){
				if (i==list.size()-1){
					code.append(list.get(i).getJoRefNo());
					text.append(list.get(i).getJoRefNo()+"\t"+list.get(i).getAgmtEffDt()+"\t"+list.get(i).getAgmtExpDt());
				}else{
					code.append(list.get(i).getJoRefNo()+"|");
					text.append(list.get(i).getJoRefNo()+"\t"+list.get(i).getAgmtEffDt()+"\t"+list.get(i).getAgmtExpDt()+"|");
				}
			}
		}
		eventResponse.setETCData("CODE", code.toString());
		eventResponse.setETCData("TEXT", text.toString());
		return eventResponse;
	}
	
	/**
	 * CSR Approval List 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddCarriersList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0086Event event = (FnsJoo0086Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<BzcAgmtCrrVO> list = command.searchAddCarriersList(event.getBzcAgmtCrrVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * Add Carriers 저장
	 * @param Event e    
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse addCarriersList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0086Event event = (FnsJoo0086Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();		
		try{
			begin();
			String rtnVal = command.addCarriersList(event.getBzcAgmtCrrVOs(),account);
     
			if ("".equals(rtnVal)){
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}else{
				rollback();
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
	 * FNS_JOO_0091 OPEN
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0091(Event e) throws EventException {
    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    	//FnsJoo0085Event event = (FnsJoo0085Event) e;
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
        
        String crrCdList = makeComboString(list, 0);
		eventResponse.setETCData("CRR_CD_LIST",crrCdList);

		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        
        String trdCdList = makeComboString(list, 0);
		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
		
		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		
		String crrTrdLaneList = makeComboString(list, 4);
		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);
		
		//Direction 조회
		CodeUtil codeUtil = CodeUtil.getInstance();
		
		Collection<CodeInfo> joBkgTpCdList = codeUtil.getCodeSelect("CD02791", 0);
		Collection<CodeInfo> joSrcCdList   = codeUtil.getCodeSelect("CD02792", 0);

		String joBkgTpCd[] = StringUtil.split(BizComUtil.getCodeSelectString(joBkgTpCdList),BizComUtil.CODE_DELIMITTER);
		String joSrcCd  [] = StringUtil.split(BizComUtil.getCodeSelectString(joSrcCdList  ),BizComUtil.CODE_DELIMITTER);
		
		String ofcCd = this.account.getOfc_cd();

		//Office Code 조회
		String offCombo = "";
		if ("SELADG".equals(ofcCd)){
			List<JooCodeInfoVO> list1 = command.searchAuthOfficeList(jooCodeParamVO);
			offCombo = " ,|"+makeComboString(list1, 1);
		}else{
			offCombo = ofcCd+","+ofcCd;
		}
        eventResponse.setETCData("OFC_CD", offCombo);
        
		
		eventResponse.setETCData("JO_BKG_TP_CD",joBkgTpCd[0]);
		eventResponse.setETCData("JO_BKG_TP_NM",joBkgTpCd[1]);
		eventResponse.setETCData("JO_SRC_CD"   ,joSrcCd  [0]);
		eventResponse.setETCData("JO_SRC_NM"   ,joSrcCd  [1]);
		
        return eventResponse;        
    }
	
	/**
	 * BSA Information Entry를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaInformationEntryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0091Event event = (FnsJoo0091Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<BsaInformationEntryVO> list = command.searchBsaInformationEntryList(event.getBsaInformationEntryVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * YYYY-WW, Date 조회한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaInformationYyyyWwDt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0091Event event = (FnsJoo0091Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();

		try{
			List<BsaInformationEntryVO> list = command.searchBsaInformationYyyyWwDt(event.getBsaInformationEntryVO());
			if(list.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("COM12114").getUserMessage());
			}else{
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("etcYrwk", ((BsaInformationEntryVO)list.get(0)).getYrwk() );
				etcData.put("etcRevPortEtdDt", ((BsaInformationEntryVO)list.get(0)).getRevPortEtdDt() );
				etcData.put("etcJoRdrPortCd", ((BsaInformationEntryVO)list.get(0)).getJoRdrPortCd() );
				eventResponse.setETCData(etcData);
			}	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;		
	}	
	
	
	/**
	 * BSA Information Entry를 조회한다. Target Excel을 위한 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaInformationEntryListForTargetExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0091Event event = (FnsJoo0091Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<BsaInformationEntryVO> list = command.searchBsaInformationEntryListForTargetExcel(event.getBsaInformationEntryVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	
	/**
	 * BSA Information Entry를 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBsaInformationEntryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0091Event event = (FnsJoo0091Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();

		try{
			begin();
			command.manageBsaInformationEntryList(event.getBsaInformationEntryVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BSA Information Add Carrier를 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageAddCarrierList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0091Event event = (FnsJoo0091Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		try{
			begin();
			command.manageAddCarrierList(event.getBsaInformationEntryVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * [FNS_JOO_0092]
	 * BSA Information Entry History를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaInformationEntryHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0092Event event = (FnsJoo0092Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<BsaInformationEntryVO> list = command.searchBsaInformationEntryHistoryList(event.getBsaInformationEntryVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * [FNS_JOO_0093]
	 * BSA Information Entry Carrier를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddBsaCarrieList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0093Event event = (FnsJoo0093Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<BsaCarrieHistoryVO> list = command.searchAddBsaCarrieList(event.getBsaCarrieHistoryVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * [FNS_JOO_0093]
	 * BSA Information Entry Carrier를 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageAddBsaCarrieList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0093Event event = (FnsJoo0093Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageAddBsaCarrieList(event.getBsaCarrieHistoryVO(), event.getBsaCarrieHistoryVOs(), account);
//			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();

		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0096 : Retreive 
	 * Additional Slot Sales 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAdditionalSlotManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0096Event event = (FnsJoo0096Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<AdditionalSlotManageVO> list = command.searchAdditionalSlotManage(event.getAdditionalSlotManageVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * FNS_JOO_0096 : Save
	 * Additional Slot Sales정보를 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageAdditionalSlotManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0096Event event = (FnsJoo0096Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageAdditionalSlotManage(event.getAdditionalSlotManageVOs(),account);
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
	 * FNS_JOO_0096 : 화면 open
	 * open시 필요한 Trade, Lane, Carrier, Direction List를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0096(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		//공동운항에 등록된 모든 TRADE조회
		jooCodeParamVO.setOfcCd(account.getOfc_cd());
		List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
		
		String tradeComboList = ",|"+makeComboString(list, 1); //IBCombo 용
		String tradeSheetList = makeComboString(list, 2);   //IBSheet 용 

		//공동운항에 등록된 모든 lane코드를 조회하되 trade코드도 같이 조회한다.
		//Lane Code 조회
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
		
		//Carrier 조회
		jooCodeParamVO.setSuperCd1("");
		jooCodeParamVO.setSuperCd2("");
		jooCodeParamVO.setCode    ("");
		jooCodeParamVO.setSortKey ("");

		// 공동운항에 등록된 모든 Carrier를 조회한다.
		list = command.searchCarrierCodeList(jooCodeParamVO);

		String carriSheetList = makeComboString(list, 2);
		
		//Direction 조회
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
	 * FNS_JOO_0095 OPEN
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0095(Event e) throws EventException {

		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
        
        //Carrier
        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
        
        String crrCdList = makeComboString(list, 0);		
		eventResponse.setETCData("CRR_CD_LIST",crrCdList);
		
		//Trade
		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        
        String trdCdList = makeComboString(list, 0);
		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
		
		//Lane
		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		
		String crrTrdLaneList = makeComboString(list, 4);
		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);

		//Kind
		jooCodeParamVO.setSuperCd1("CD03286"); 
		list = command.searchComCodeList(jooCodeParamVO);
		
		String kndCDList = makeComboString(list, 0);
		eventResponse.setETCData("KND_CD_LIST",kndCDList);
		
        return eventResponse;        
    }

	/**
	 * FNS_JOO_0095 : Save
	 * Blank Voyage Status 정보를 저장한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageBlankVoyageStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0095Event event = (FnsJoo0095Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageBlankVoyageStatus(event.getBlkVygSttsVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
			eventResponse.setETCData("RTNVAL", "N");
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
	 * FNS_JOO_0095 : Retreive 
	 * Blank Voyage Status 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBlankVoyageStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0095Event event = (FnsJoo0095Event)e;
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<BlkVygSttsVO> list = command.searchBlankVoyageStatus(event.getBlkVygSttsVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}	
} 