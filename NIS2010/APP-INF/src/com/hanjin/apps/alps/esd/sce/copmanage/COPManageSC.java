/*=========================================================
*Copyright(c) 20006 CyberLogitec
*@FileName : COPManageSC.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 20006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 20006-08-29 Seong-mun Kang
* 1.0 최초 생성
* 2009.02.26 - 안정선 - CSR NO. N20009020300014 COP Inquiry 화면과 COP Summary 화면을 하나의 화면으로 통합
* 2010.10.29 김진승 [소스결함 보완] searchSceCopHdrInfo 메서드에 throw 추가 
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
* 2011.12.01 전준영 [CLT-111121289]Split R4J 소스품질 결함 조치 - Null Dereferencing(객체에 NULL이 배정된 이후 객체에 대한 참조를 하지 말아야 한다
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage;


import java.util.List;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.sce.common.SCEConstants;
import com.hanjin.apps.alps.esd.sce.common.setup.basic.CustomizedReportSetupBC;
import com.hanjin.apps.alps.esd.sce.common.setup.basic.CustomizedReportSetupBCImpl;
import com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC;
import com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.basic.COPSearchBC;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0001Event;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0006Event;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0009Event;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0118Event;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0915Event;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.BookingInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSCInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSOCostInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchTargetCOPInfoListVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copupdate.basic.COPUpdateBC;
import com.hanjin.apps.alps.esd.sce.copmanage.copupdate.basic.COPUpdateBCImpl;
import com.hanjin.apps.alps.esd.sce.copmanage.copupdate.vo.COPUpdateInfoVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SceCopHdrVO;


/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author Seong-mun Kang
 * @see EsdSce0001EventResponse , COPSearchDBDAO 참조
 * @since J2EE 1.4
 */
public class COPManageSC extends ServiceCommandSupport {
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * SCE 업무 시나리오 선행작업<br>
     * COPSearch업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("COPManageSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * SCE 업무 시나리오 마감작업<br>
     * COPManage업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("COPManageSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ENIS-SCE 업무에서 발생하는 모든 이벤트의 분기처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException ...
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;

        log.debug("\n EventName : "+e.getEventName());

        // NEW COP Inquiry +  COP Main Search 
          if (e.getEventName().equalsIgnoreCase("EsdSce0001Event")) {
        	log.debug("\n SC..NEW COP Inquiry ");
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
            	log.debug("\n SC..NEW COP Inquiry..SEARCHLIST ");
            	eventResponse = searchCOPMainList(e);
    		} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyCOPStatusChange(e); // Status Change
			}
          }
          // COP Detail Search
          else if(e.getEventName().equalsIgnoreCase("EsdSce0006Event")) {

          	EsdSce0006Event event         = (EsdSce0006Event)e ;
          	// COP Booking Search
              if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                  eventResponse = searchBookingList(e);
              }
              // COP Detail Search
              else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ||
              		 e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ||
              		 e.getFormCommand().isCommand(FormCommand.SEARCHLIST03) ||
              		 e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {

              	if(event.getClickBtnNm().equals("btn_manualclose")) {
              		modifyCopStsCd(event.getCopNo());
              	}

                  eventResponse = searchCOPDetail(e);

              }else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
              	eventResponse = modifyCOPDetailEstmActDT(e);            	
              }
              else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
            	  eventResponse = modifyTRSSoCnddtCreation(e);            	
              }
              else{
              	//eventResponse = searchCOPStatus(e);
              	eventResponse = searchBookingList(e);
              }

          }         
        // COP Manual Batch Update
        else if(e.getEventName().equalsIgnoreCase("EsdSce0010Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
//                eventResponse = modifyCOPEstmActDT(e);
        		log.debug("chk.081110");
            }
        	else{
        		//eventResponse = setUpdateParameter(e) ;
        	}
        }

        // BKG Info Search
        else if(e.getEventName().equalsIgnoreCase("EsdSce0915Event")) {
        		eventResponse = searchBookingDetail(e);
        }


        // searchTargetCOPInfoList Search
        else if(e.getEventName().equalsIgnoreCase("EsdSce0009Event")) {
        	//1. 0006 or 002 에서 호출시 Default -> 아무작업 안함
        	//2. 0009 로딩후 SEARCHLIST 호출
        	//3. Apply 클릭시 MULTI01 호출

            if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Apply Click
            	//
            	log.debug("\n usr id : " + account.getUsr_id());
                eventResponse = addCOPReplan(e,account.getUsr_id());
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {//0009 Search
            	//eventResponse = searchCopCurrentInfo(e);
            	eventResponse = searchTargetCOPInfoList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//0009 Search
            	//eventResponse = searchCopCurrentInfo(e);
            	eventResponse = searchTargetPCInfoList(e);
            }
        }

        else if (e.getEventName().equalsIgnoreCase("EsdSce0118Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
        		eventResponse = searchSceCopHdrInfo(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
        		eventResponse = searchSCInfo(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
        		eventResponse = modifyPCopHdr(e);
       		
        	}
        }

        return eventResponse;
    }
    /*********************************************************************************/

    /**
     * NEW COP Inquiry<br>
     * COP Main 조회 이벤트 처리<br>
     *
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCOPMainList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0001Event event         = (EsdSce0001Event)e ;
    	List<SearchCOPMainListVO> list = null;
    	
        try {
            COPSearchBC command = new COPSearchBCImpl();
            list = command.searchCOPMainList(event.getConditionVO());
			eventResponse.setRsVoList(list);            
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    } 
    /**
     * Search Master COP Inquiry
     * @param e Event
     * @return EventResponse 
     * @throws EventException ...
     */
    public EventResponse searchSceCopHdrInfo(Event e) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0118Event event         = (EsdSce0118Event)e ;    	
		COPSearchBC command = new COPSearchBCImpl();
		List<SearchSceCopHdrInfoVO> list = null;
		
		try{
			list = command.searchSceCopHdrInfo(event.getConditionVO());
			eventResponse.setRsVoList(list);  			
		} catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
	}

    /**
     * Search Master S/O 여부 조회
     * @param e Event
     * @return EventResponse 
     * @throws EventException ...
     */
    public EventResponse searchSCInfo(Event e) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0118Event event         = (EsdSce0118Event)e ;   
		CodeUtilBC	utilBc = new CodeUtilBCImpl();        
		COPSearchBC command = new COPSearchBCImpl();
		ReplanManageBC replanCommand = new ReplanManageBCImpl();
		//String replanResult[] = {"", "", "", ""};
//		List<SearchSCInfoVO> list = null;
		int retVal = SCEConstants.MST_FAIL;
		try{

/*
			list = command.searchSCInfo(inqVO);
	
			if(list != null){
				for(int i=0; i<list.size(); i++){
					SearchSCInfoVO vo = (SearchSCInfoVO)list.get(i);
					command.modifyTrsRailSvcOrd(vo);              //  trs_trsp_rail_bil_ord,trs_trsp_svc_ord Update
					if(inqVO.getOldCopNo() != null && inqVO.getOldCopNo().length() > 0){
						replanCommand.moveMstFlg(inqVO.getOldCopNo(), inqVO.getNewCopNo());		//  S/O Auto Change Logic						
					}

				}
			}
			command.modifyCopHdr(event.getConditionVO());   // SCE_COP_HDR Update
*/
			begin();
			COPInquiryVO inqVO = event.getConditionVO();			
			if(inqVO.getOldCopNo() != null && inqVO.getOldCopNo().length() > 0){
log.debug("\n ############################################################ ");				
log.debug("\n ############################################################ ");
log.debug("\n  fromCopNo:"+inqVO.getOldCopNo()+"    newCopNo:"+inqVO.getNewCopNo());
				retVal = replanCommand.moveMstFlg(inqVO.getOldCopNo(), inqVO.getNewCopNo());		//  S/O Auto Change Logic						
			}
			
			event.getConditionVO().setBkgEventTpCd("LC");
			if(SCEConstants.MST_SUCCESS == retVal){
				String ofcCode = e.getSignOnUserAccount()== null?"SysMan":e.getSignOnUserAccount().getOfc_cd();
				String usr_id = e.getSignOnUserAccount()== null?"SysMan":e.getSignOnUserAccount().getUsr_id();
				utilBc.addSceCopHistory(inqVO.getNewCopNo(), "LC", ofcCode, usr_id, "N");
				utilBc.addSceCopHistory(inqVO.getOldCopNo(), "RC", ofcCode, usr_id, "N");
				//command.addSceCopHis(event.getConditionVO());				
			}

			commit();
	  	
			List<SearchSceCopHdrInfoVO> resultList = command.searchSceCopHdrInfo(event.getConditionVO());    //Search Master COP Inquiry
			eventResponse.setRsVoList(resultList);			
		} catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

    /**
     * @param e Event
     * @return EventResponse 
     * @throws EventException ... 
     */
    public EventResponse modifyPCopHdr(Event e) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0118Event event         = (EsdSce0118Event)e ;   
		CodeUtilBC	utilBc = new CodeUtilBCImpl();        
		COPSearchBC command = new COPSearchBCImpl();
		
		try{
			begin();
			COPInquiryVO inqVO = event.getConditionVO();
			command.modifyPCopHdr(inqVO);
			//command.insertSceLog(e);
			//command.addSceCopHis(event.getConditionVO());
			String ofcCode = e.getSignOnUserAccount()== null?"SysMan":e.getSignOnUserAccount().getOfc_cd();

			utilBc.addSceCopHistory(inqVO.getNewCopNo(), "LC", ofcCode, inqVO.getUsrId(), "N");
			
			commit();
			//eventResponse = command.searchSceCopHdrInfo(e);    //Search Master COP Inquiry
			List<SearchSceCopHdrInfoVO> resultList = command.searchSceCopHdrInfo(event.getConditionVO());    //Search Master COP Inquiry
			eventResponse.setRsVoList(resultList);	
		} catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
        return eventResponse;
	}

    /**
     * BKG Info 조회 이벤트 처리<br>
     *
     * @return response EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	private EventResponse searchBookingDetail(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        //EventResponse eventResponse = new EsdSce0915EventResponse();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();    	
        EsdSce0915Event event         = (EsdSce0915Event)e ;   
    	
        try {
            COPSearchBC command = new COPSearchBCImpl();
            List<?> list = command.searchBookingDetail(event.getCopInquiryVO());
            DBRowSet bkgList = ( DBRowSet)list.get(0);
            List<BookingInfoVO> listVVD = (List<BookingInfoVO>)list.get(1);            
			//eventResponse.setRsVoList(bkgList);
            eventResponse.setRs(bkgList);
            eventResponse.setRsVoList(listVVD);
  
        } catch (EventException de) {
        	rollback() ;
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }

        return eventResponse;
    }
    
	/**
	 * Modify COP Status 
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @throws EventException ... 
	 */
	public EventResponse modifyCOPStatusChange(Event e) throws EventException {
//        EventResponse eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0001Event event         = (EsdSce0001Event)e ;
    	COPSearchBC command = new COPSearchBCImpl();
		SearchCOPMainListVO[] mainListVOs = event.getMainListVOs();

    	try {
			begin();
			command.modifyCOPStatusChange(mainListVOs);
	    	List<SearchCOPMainListVO> list = null;
			list = command.searchCOPMainList(event.getConditionVO());
			eventResponse.setRsVoList(list);            
			commit();
		} catch(EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


    /**
     * 조회 이벤트 처리<br>
     * COP Detial 조회 이벤트 처리<br>
     *
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCOPDetail(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0006Event event         = (EsdSce0006Event)e ;

        try {
            COPSearchBC command = new COPSearchBCImpl();
            eventResponse = command.searchCOPDetail(event.getCOPDetailVO());
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }


    /**
     * COP Status 수정
     *
     * @param copNo String
     * @exception EventException
     */
    private void modifyCopStsCd(String copNo) throws EventException {
        try {
        	COPUpdateBC command = new COPUpdateBCImpl();
            command.modifyCopStsCd(copNo);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }


    /**
     * 조회 이벤트 처리<br>
     * COP Booking List 조회 이벤트 처리<br>
     *
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchBookingList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0006Event event         = (EsdSce0006Event)e ;
        List<SearchSceCopHdrInfoVO> list = null;
        try {
            COPSearchBC command = new COPSearchBCImpl();
            list = command.searchBookingList(event.getCOPDetailVO());
			eventResponse.setRsVoList(list);      
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /** Manual Change
     * @param e
     * @param usr_id
     * @return
     * @throws EventException
     */
    // Manual Change 사용.
    private EventResponse addCOPReplan(Event e,String usr_id) throws EventException {
//    	 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        //EventResponse eventResponse = null;
        //EsdSce0009EventResponse_R res_0009 = null;
//        String ioBndCd = "";
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0009Event event = (EsdSce0009Event) e;
    	
//        String copNo = "";
        try {
//			CodeUtilBC	utilBc = new CodeUtilBCImpl();
        	//COPReplanBC command = new COPReplanBCImpl();
			ReplanManageBC command  = new ReplanManageBCImpl();
			
        	begin();
            //eventResponse = command.addCOPReplan(e,usr_id);
            COPReplanInfoVO[] inqVO = event.getCOPReplanInfoVOs();
            if(inqVO != null){
            	for(int i=0; i<inqVO.length; i++){
            		
                   	SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
                	sceCopHdrVO.setBkgNo(inqVO[i].getBkgNo());
                	sceCopHdrVO.setCntrNo(inqVO[i].getCntrNo());
                	sceCopHdrVO.setCopNo(inqVO[i].getCopNo());
                	sceCopHdrVO.setCopStsCd(inqVO[i].getCopStsCd());
                	sceCopHdrVO.setPctlNo(inqVO[i].getPctlNo());
        log.debug("\n  bkgNo:"+ inqVO[i].getBkgNo()+"  cntrNo:"+inqVO[i].getCntrNo()+" copNo:"+inqVO[i].getCopNo() +"  copStsCd:"+inqVO[i].getCopStsCd()
        		+"  pctlNo:"+inqVO[i].getPctlNo());
     				command.replanCopInclPrt(sceCopHdrVO, account);        
            		
            	}
            }


//            res_0009 = (EsdSce0009EventResponse_R)eventResponse;
//            EsdSce0009Event_R event        = (EsdSce0009Event_R)e ;
//            ArrayList          sce_cop_hdrs = (ArrayList)event.getSCE_COP_HDRS() ;
//			SCE_COP_HDR_INFO        sce_cop_hdr  = null ;
			commit();

			//history 정리후 점검 필요 20091203
//			for(int i=0; i<sce_cop_hdrs.size()-1; i++){
//
//				sce_cop_hdr = (SCE_COP_HDR_INFO)sce_cop_hdrs.get(i) ;
//				copNo = sce_cop_hdr.getCop_no();
//
//				// resolve는 command.addCOPReplan 안에서 해줌.	            
//				utilBc.setCopExptResistAct(copNo,"exptMC","Y");
//	            
//	            begin();	            
//	            command.updateCost("", "","" , copNo, "UC");
//				// cop history 관리용 2008-02-27 반영
//				String ofcCode = e.getSignOnUserAccount()== null?"SysMan":e.getSignOnUserAccount().getOfc_cd();
//				utilBc.addSceCopHistory(copNo, "MC", ofcCode, usr_id, "N");
//				utilBc.modifyUnmatchedReason(copNo,"N");
//	            commit() ;
//
//			}
			//utilBc = null;

            /* 2007.09.17 LCL인 Cntr도 함께 Replan을 실행하도록 한다. 트렌젝션을 따로 가져 가도록 한다.*/
            /* LCL인 COP_NO를 찾아온다.*/
			/* 20091203  아래 내용을 replan 모듈에서 하므로 주석 처리*/
//            begin();
//            command.lclCOPReplan(e,usr_id);
//            commit();

        } catch (EventException de) {
        	rollback() ;
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
        	rollback() ;
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());            
        //} catch (DAOException de) {
		//	de.printStackTrace();
		}
        return eventResponse;
    }

    /**
     * COP Detail Search Update 처리 이벤트 처리<br>
     *
     * @param e EsdSce0006Event
     * @return EventResponse GeneralEventResponse
     * @exception EventException
     */
    private EventResponse modifyCOPDetailEstmActDT(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();    	
    	EsdSce0006Event event = (EsdSce0006Event)e ;
        COPUpdateInfoVO inqVO = event.getCOPUpdateInfoVO();

        try {
        	begin() ;
            COPUpdateBC command = new COPUpdateBCImpl();
            command.modifyCOPDetailEstmActDT(inqVO);
            commit() ;


        }catch (EventException de) {
        	rollback() ;
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }   
    
    /**
     * 조회 이벤트 처리<br>
     * COP Detial 조회 이벤트 처리<br>
     *
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse modifyTRSSoCnddtCreation(Event e) throws EventException {

    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0006Event event = (EsdSce0006Event)e ;

    	try {
            COPSearchBC command = new COPSearchBCImpl();
            command.modifyTRSSoCnddtCreation(event);
            
			
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    	return eventResponse;
    }

    /**
     * COP Info 조회 이벤트 처리<br>
     *
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchTargetCOPInfoList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0009Event event = (EsdSce0009Event) e;

        try {
//        	begin();
            COPSearchBC command = new COPSearchBCImpl();
            COPReplanInfoVO inqVO = event.getCOPReplanInfoVO();
            List<SearchTargetCOPInfoListVO> list = command.searchTargetCOPInfoList(inqVO);
            eventResponse.setRsVoList(list);  
//            commit() ;
        } catch (EventException de) {
        	rollback() ;
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /**
     * PC Info 조회 이벤트 처리<br>
     *
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchTargetPCInfoList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0009Event event = (EsdSce0009Event) e;

        try {
       

            COPSearchBC command = new COPSearchBCImpl();
            COPReplanInfoVO[] inqVOs = event.getCOPReplanInfoVOs();            
            COPReplanInfoVO inqVO = event.getCOPReplanInfoVO(); 
            
            
            String[] frmtoNumArray = command.searchCopCurrentInfo(inqVOs, inqVO);
            
            String cop_no 		= frmtoNumArray[0];
            String io_bnd_cd	= frmtoNumArray[1];
            String new_nod 		= frmtoNumArray[2];
            String cre_usr_id	= account.getUsr_id();
           	begin();
            //com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl
            ProductCatalogCreateBC prdCommand = new ProductCatalogCreateBCImpl();
            String pctlHdrNo = prdCommand.createSceManualReplan(cop_no, io_bnd_cd, new_nod, cre_usr_id);
            log.debug("\n call prdCommand.createSceManualReplan("+cop_no+","+io_bnd_cd+","+new_nod+","+cre_usr_id+")"+
            			"\n params...." +
            			"\n copno : " +frmtoNumArray[0]+
            			"\n ioBndCd : " +frmtoNumArray[1]+
            			"\n newNod : " +frmtoNumArray[2]+
            			"\n creUsrId : "+frmtoNumArray[3]+
            		  "\n");   
            
            commit() ;
            
            // 2012.02.27 김인수 [CHM-201216364] "[SCEM] COP replan 시 S/O check validation 추가요청"
            // parameter 추가
            
            String[] resultArray = {pctlHdrNo, cop_no, io_bnd_cd, new_nod};
           
            eventResponse =  command.searchTargetPCInfoList(inqVOs, inqVO, resultArray);
            
        } catch (EventException de) {
        	rollback() ;
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

}
