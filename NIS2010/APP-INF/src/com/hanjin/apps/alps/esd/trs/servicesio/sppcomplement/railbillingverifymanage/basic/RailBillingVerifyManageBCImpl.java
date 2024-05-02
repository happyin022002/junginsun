/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingVerifyManageBCImpl.java
*@FileTitle : Rail Billing Verify
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
//import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.basic.RailSoManageBC;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.basic.RailSoManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.Constants;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event.RailBillingVerifyEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event.RailBillingVerifyEventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event.RailBillingVerifyList;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration.RailBillingVerifyManageDBDAO;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration.RailSoManageDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;




/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see RailBillingVerifyEventResponse,RailBillingVerifyManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailBillingVerifyManageBCImpl   extends BasicCommandSupport implements RailBillingVerifyManageBC {

	// Database Access Object
	private transient RailBillingVerifyManageDBDAO dbDao=null;
	private transient RailSoManageDBDAO rdbDao=null;
	
	/**
	 * RailBillingVerifyManageBCImpl 객체 생성<br>
	 * RailBillingVerifyManageDBDAO를 생성한다.<br>
	 */
	public RailBillingVerifyManageBCImpl(){
		dbDao = new RailBillingVerifyManageDBDAO();
		rdbDao = new RailSoManageDBDAO();
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * RailBillingVerifyEvent 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e RailBillingVerifyEvent
	 * @return EventResponse RailBillingVerifyEventResponse
	 * @throws EventException 
	 * @throws Exception 
	 */
	public EventResponse verifyRailBillingCNTRList(Event e) throws EventException {
   
		Collection 	models 			= new ArrayList();
		Collection 	models2 		= new ArrayList();
		
		RailBillingVerifyEvent 			event 					= (RailBillingVerifyEvent)e;
		RailBillingVerifyEventResponse 	eventResponse 			= null;
		String   						cgo_tp_cd  				= event.getCgo_tp_cd();
		String    						fm_yd_cd 				= event.getFm_yd_cd();
		ArrayList  						eqr_overplan_al 		= null;
		String 							currdt					= null;
		String 							eqr_fmnd 				= null, eqr_tond = null, eqr_tpsz = null;
		
		String							strWRSVerifyResultCd	= null;	
		String pln_yrwk="";
		String repo_pln_id="";
		String ref_id = "";
		String trsp_mod_cd = "R";
		
		RailSoManageBC command 				= new RailSoManageBCImpl();
		
		try {
			
			// WRS FULL Railbilling 일 경우 
			/*********************************************************************************************************
			 * 
			 * WRS Empty Railbilling Cancel 이후 30분동안 Full Railbilling불가를 위한 Verify
			 * "Please wait 30 minutes to rebill. Under processing to cancel the previous MT railbilling."
			 * -------------------------------------------------------------------------------------------------------
			 * First Verify	[checkFullContainerStatusFirst]
			 * 1 : Container Information Check
			 *     > COP.RD, OB, S/O Planned, COP Status, Master Flag
			 * 2 : Movement Status Check2 ()
			 * 3 : Movement Status Check  (최종상태)
			 * 4 : SEN/HJL(Domestic) Rail S/O 존재여부
			 * 5 : MDM Yard 추가?
			 * 6 : 미주지역 Check (POL)
			 * 
			 * Second Verify	[checkFullContainerStatusSecond]
			 * 1 : Dummy Cntr의 경우 Type/Size로 COP No Mapping
			 * 2 : Dummy Cntr의 경우 Booking이 Cntr Type/Size로 COP No Mapping
			 * 3 : COP No Mapping되지 않을경우 Cntr Type/Size별로 1,2에서 추출된 COP No Mapping
			 * 4 : Cntr No GOOD인경우 flg, weight 최종체크 
			 * 
			 *********************************************************************************************************/
			if (cgo_tp_cd != null && cgo_tp_cd.equals("F")) {				
				
				//verifyFullWRSforMtyWRSCancelList
				
				models 	= dbDao.checkFullContainerStatusFirst	(event			);	
				models2 = dbDao.checkFullContainerStatusSecond	(models, event	);
				
				for(Iterator itr2 = models2.iterator(); itr2.hasNext();){
					RailBillingVerifyList	railbillingverifyList	= (RailBillingVerifyList)itr2.next();
					
					if( Constants.VRFY_GOOD.equals(railbillingverifyList.getRailVrfyRstCd()) || Constants.VRFY_NOGOOD.equals(railbillingverifyList.getRailVrfyRstCd()) )
					{
						strWRSVerifyResultCd	= dbDao.checkFullContainerForMtyCancelHistory(railbillingverifyList.getEq_no());
						
						if( Constants.VRFY_NOBILLING.equals(strWRSVerifyResultCd) ) {
							
							railbillingverifyList.setRailVrfyRstCd(Constants.VRFY_NOBILLING);
							railbillingverifyList.setErr_msg_cd("TRS00406");	//Please wait 30 minutes to rebill. Under processing to cancel the previous MT railbilling
						}
					}
				}
				
		    // WRS MTY Railbilling 일 경우	
			} else if (cgo_tp_cd != null && cgo_tp_cd.equals("M")) {				
				models 	= dbDao.checkMtyContainerStatus(event);
				models2 = dbDao.checkMtyContainerStatusSe(models, event, fm_yd_cd);
				
				currdt = dbDao.currDate(); //User Office Current LocalTime
				


				for(Iterator itr2 = models2.iterator();	itr2.hasNext();) {
					RailBillingVerifyList railbillingverifyList = (RailBillingVerifyList)itr2.next();

					if ( railbillingverifyList.getErr_msg_cd() != null &&  railbillingverifyList.getErr_msg_cd().equals( "TRS00050") ) {
						
						pln_yrwk       	= rdbDao.searchPlnWeek(currdt);//Search Plan Week
						repo_pln_id 	= "REPO"+pln_yrwk+"W001";
						// REF ID채번 , n개의 컨테이너는 같은 REF ID를 갖는다.
						ref_id 			= rdbDao.searchGetRefId(fm_yd_cd.substring(0, 5), pln_yrwk,trsp_mod_cd);
						
						eqr_fmnd = railbillingverifyList.getRoute_org_nod_cd	();
						eqr_tond = railbillingverifyList.getRoute_dest_nod_cd	();
						eqr_tpsz = railbillingverifyList.getEq_tpsz_cd			();
						//EQR_REPO_EXE_SO_IF에 데이터 Insert	
						eqr_overplan_al = ((RailSoManageBCImpl) command).inlandWrsTrsSOIF(currdt, eqr_fmnd, eqr_tond, "R", eqr_tpsz, 1,repo_pln_id,pln_yrwk, ref_id);

						if(eqr_overplan_al != null) {
						   
						      String[] arr = null;
						      for(int z=0; z<eqr_overplan_al.size(); z++) {
						          arr = (String[])eqr_overplan_al.get(z);
						         
									if (railbillingverifyList != null){
										railbillingverifyList.setRepo_pln_id	( arr[0] 				);
										railbillingverifyList.setPln_yrwk		( arr[1] 				);
										railbillingverifyList.setRef_id			( arr[2]				);
										railbillingverifyList.setRef_seq		( arr[3]				);
										railbillingverifyList.setErr_msg_cd		( null					);
										railbillingverifyList.setRailVrfyRstCd	(Constants.VRFY_GOOD 	);	// verifyrst -> good으로.				
									}
						          
					          }
						      
						} else {
							// dblink 가 없을때.
						}	//END OF 2ND. INNER IF.
					}	//END OF 1ST. INNER IF.
				}	//END OF FOR LOOP.
			}	//END OF OUTER IF
			
			eventResponse = new RailBillingVerifyEventResponse(models2, "SUCCESS");
			 
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de); 
		}
		return eventResponse;
	}
	

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * RailBillingVerifyManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}