/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingMaterDataSC.java
 *@FileTitle : Mark & Description Template
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchPortCdByVvdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchSvcLaneBoundVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.CustomsMasterMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.CustomsMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.Cms0070001Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0050001Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0060001Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0070001Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0019Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0040Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0073Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0082Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0153Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0192Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0253Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0354Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0374Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0554Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0596Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0607Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0653Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0696Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0741Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0949Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0975Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1030Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1060Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1114Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1180Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg2004Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg200401Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg2005Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg200501Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg3001Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg3002Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg3003Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg3008Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingMasterMgtDBDAO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsAdvScacVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpCustVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgInetBlCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkganDestOfcStupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgCtnt2VO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgDesc2VO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0064Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0154Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0232Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0320Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0365Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0384Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0743Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0922Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0976Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg1075Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg1606Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg3005Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg3011Event;			//SJH.20141121.ADD
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg3012Event;			//SJH.20141121.ADD
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg3100Event;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlCluzStupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlESignatureVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.PlaceOfIssueAssociationVO;	//SJH.20141121.ADD
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0726Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rdexport.ReportDesignerExporter;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.framework.table.ComUpldFileVO;
import com.clt.syscommon.common.table.BkgChnBkgNoGenVO;
import com.clt.syscommon.common.table.BkgCorrectionVO;
import com.clt.syscommon.common.table.BkgHamoTrfVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgMTPickupCYVO;
import com.clt.syscommon.common.table.BkgRateVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmPckTpVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * BookingMaterData Business Logic ServiceCommand - Handling business transaction for BookingMaterData
 * @author 
 * @see BookingMasterMgtDBDAO 
 * @since J2EE 1.4
 */

public class BookingMasterDataSC extends ServiceCommandSupport {

    // Login User Information
    private SignOnUserAccount account = null;
	/**
	 * BookingMaterData system preceding process for biz scenario<br>
	 * BookingMaterData system Creating related object by calling work scenario<br>
	 */
    public void doStart() {
        try {
            account = getSignOnUserAccount();
        } catch(Exception e) {
            log.error(e.getMessage());
        }
    }

	 /**
	 * BookingMaterData system Handling for the end of working scenario<br>
	 * BookingMaterData system Clearing object by the end of work scenario<br>
	 */
    public void doEnd() {
        log.debug("BookingMaterDataSC end");
    }

	/**
	 * Handling working scenario of each event<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
    	log.debug("[START:: BookingMasterDataSC perform== e.getEventName() ]=========="+e.getEventName());
        /* UiBkg0365Event */
        if (e.getEventName().equalsIgnoreCase("EsmBkg0365Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchUserTmpltList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageUserTmpltList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0384Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchUserTmpltList(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageUserTmpltList(e);
            }else{
            	eventResponse = searchUserTmpltList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0082Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchMTPickUpCY(e);
        	}	
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0154Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchUserDefaultSettingByBooking(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = createUserDefaultSettingByBooking(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchComCode0154(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0232Event")) {
         	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
          		eventResponse = searchUserXterSearchSet(e);
          	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageUserXterSearchSet(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0976Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchRmkTemplate(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageUserTmpltList(e);
            }
        }
        
        else  /* EsmBkg0019Event */
            if(e.getEventName().equalsIgnoreCase("EsmBkg0019Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchEtbEtdEta(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                    eventResponse = searchSvcLaneByLoc(e);
                }    
    	}
        else 
            if (e.getEventName().equalsIgnoreCase("EsmBkg0607Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchHTSCode(e);
            }else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
            	eventResponse = searchComCode0607(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = manageHtsCode(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            	eventResponse = searchHTSCode(e);
            }
        }
           
        else  /* EsmBkg0696Event */
            if(e.getEventName().equalsIgnoreCase("EsmBkg0696Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchPackageCode (e);
            	}  
    	}
        else  /* EsmBkg0653Event */
            if(e.getEventName().equalsIgnoreCase("EsmBkg0653Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchCmdtCdRepCmdtCd (e);
            	}  
    	}
        else  /* EsmBkg0554Event */
            if(e.getEventName().equalsIgnoreCase("EsmBkg0554Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchWareHouse (e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                    eventResponse = manageWareHouse(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                    eventResponse = searchLocation(e);
                }
            	
    	}
        else  /* EsmBkg0040Event */
        	if(e.getEventName().equalsIgnoreCase("EsmBkg0040Event")) {
        		
        		if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        			eventResponse = searchScacNumber (e);
                } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                    eventResponse = manageScacNumber (e);
                }
                	
        }
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0596Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchBDRTime (e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                    eventResponse = modifyBDRLog(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                    eventResponse = modifyBDRLog(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                    eventResponse = modifyBDRLog(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {
                    eventResponse = modifyBDRLog(e);
                }
        }    	
    	else if (e.getEventName().equalsIgnoreCase("EsmBkg0320Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchUserInternetAuth(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchUserInternetAuth(e); 
	        }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = manageUserInternetAuth(e);
	    	}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0743Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchUserPrintSetup(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchHouseBlRirderBl(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = searchUserPrintSetup3(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = manageUserPrintSetup(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
	    		eventResponse = modifyOBLRlseFlg(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
	    		eventResponse = modifyWaybillFlg(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
	    		eventResponse = createOBL(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
	    		eventResponse = createGBOBL(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = downLoadOBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDownLoadOBLBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchDownLoadOBLBackEndJobResult(e);
			////////////////// MODFIY 12, MODIFY 13 ////////////////////////
//	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY14)) {
//	    		eventResponse = createTOBL(e);
//	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY15)) {
//	    		eventResponse = createGBTOBL(e);
	    	} 	    	
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0922Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeDetail(e);
			} 	    	
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUserPrintSetup0064(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageUserPrintSetup(e);
			} 	    	
	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0073Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchBDRPol(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchBDRTimeTable(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageVVDBDRTime(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = manageBKGBDRLOG(e);    
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchComCode0073(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchComCode0073_port(e);  
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchComCode0073_port(e);        
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchComCode0073_vvd_port(e);    
            }
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0253Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchEqualizetionPortCD(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageEqualizationPort(e);
        	} 
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0192Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInBoundCustList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInBoundCustTmpltList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageInBoundCustList(e);
            } 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0153Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchChinaAgentCodeList(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageChinaAgentCode (e);
           	} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = searchCheckCode0153(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
                eventResponse = searchCheckCode0153(e);
            }
           		
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0741Event")) {
           	
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchOfficePfmc(e);
           	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageOfficePfmc(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkOfficePfmc(e);
            }
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0354Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchCanadaGroupLocationCD(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCanadaGroupLocationCD2(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse = searchYardDesc(e);
        	} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){
				eventResponse = searchLocDesc(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCanadaGroupLocationCD(e);
            } 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0374Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchANDestOfcList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchANDestOfcList2(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageANDestOfcList(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("Cms0070001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBkgCustSlsRep(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0949Event")) {
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		
				eventResponse = searchDocCutOffTimeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				
				eventResponse = searchServiceLane();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				
				eventResponse = searchLocationCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {

				eventResponse = searchDayTypeCode();
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                
				eventResponse = manageDocCutOffTimeList(e);
            } 
		}
        /* EsmBkg0975Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0975Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchChargeCode(e);
            	}  
    	}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1030Event")) {
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		
				eventResponse = searchMandatoryItemSetupList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                
				eventResponse = manageMandatoryItemSetupList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                
				eventResponse = checkCustCd(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
            	eventResponse = checkDupCustCd(e);
            }  
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1060Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchChnMnlWithBkgNoGenList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = createChnMnlWithBkgNoGenList(e);
        	}
        } 
        else if (e.getEventName().equalsIgnoreCase("EsmBkg3008Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchChnMnlWithoutBkgNoGenList(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = createChnMnlWithoutBkgNoGenList(e);
        	}
        }
        else if ("Edi0050001Event".equalsIgnoreCase(e.getEventName())) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = receiveBkgEdiTrdPrnrSubLnk(e);
			} 
        } 
        else if ("Edi0060001Event".equalsIgnoreCase(e.getEventName())) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = receiveBkgEdiSubLnkMsg(e);
			} 
        } 
        else if ("Edi0070001Event".equalsIgnoreCase(e.getEventName())) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = receiveBkgEdiPrnrPortLane(e);
			} 
		}
        /* EsmBkg1075Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg1075Event")){
            if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
                eventResponse = searchCombo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRptItmStup(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRptItmStup(e);
            }
        }
        /* EsmBkg1114Event */
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1114Event")) {
        	 if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
           		eventResponse = searchMdmCnt(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchZipCode(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
          		eventResponse = manageZipCode(e);
            }	
           		
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg2004Event")) {

			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHrdCdgDesc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHrdCdgDesc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkHrdCdgId(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkChildCnt(e);
			}
			
       }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg200401Event")) {

			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHrdCdgDesc2(e);
			}
       }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg2005Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHrdCdgCtnt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHrdCdgCtnt(e);
			}
       }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg200501Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHrdCdgCtnt2(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHrdCdgCtnt2(e);
			}
       }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg3001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchControllingPartyList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInernettBlControlPartyList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBlGroupList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageControllingParty(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeControllingParty(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeInernettBlControlParty(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = removeBlGroup(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = selectMaxCntrPtySeq(e);
			}
       }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg3002Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlGroupMasterList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBlGroupCustomerList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlGroup(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeBlGroupMaster(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeBlGroupCustomer(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = selectMaxBlGroupSeq(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg3003Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlGroupMasterList(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg3005Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlESignatureList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeBlESignature(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg3100Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchBlESignature(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
    			eventResponse = searchAttachFileKey(e);
    		} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
    			eventResponse = addBlESignature(e);
    		} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
    			eventResponse = modifyBlESignature(e);
    		}
        }
        //SJH.20141121.ADD
        else if (e.getEventName().equalsIgnoreCase("EsmBkg3011Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPlaceOfIssueAssociationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removePlaceOfIssueAssociation(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg3012Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchPlaceOfIssueAssociation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBoCdList3012(e);        		
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
    			eventResponse = addPlaceOfIssueAssociation(e);
    		} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
    			eventResponse = modifyPlaceOfIssueAssociation(e);
    		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfcCdCheck(e);
			}
        }         
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1180Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchHandlingOffice(e);
           	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageHandlingOffice(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchHandlingOfficeCheck(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchCustCntCdCheck(e);
            }
        }
        /* EsmBkg1606Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg1606Event")){
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchBlCluzStup(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageBlCluzStup(e);
            }
        }

        
        return eventResponse;
    }

    /**
     * 	
	 * EsmBkg0975Event retrieve event process<br>
	 * ChargeCode List retrieve<br>
	 * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchChargeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0975Event event = (EsmBkg0975Event) e;
        BookingProcessMgtBC command = null;
        List<CodeDescVO> list = null;
        try {
        	command = new BookingProcessMgtBCImpl();
	        list = command.searchChargeCode(event.getCodeDescVO());
	        eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
	 * EsmBkg0040Event retrieve event process<br>
	 * ScacNumber List retrieve<br>
	 * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchScacNumber(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0040Event event = (EsmBkg0040Event) e;
        BookingProcessMgtBC command = null;
        List<BkgCstmsAdvScacVO> list = null;
        try {
        	command = new BookingProcessMgtBCImpl();
            list = command.searchScacNumber(event.getBkgCstmsAdvScacVO());
	        eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * BookingMasterMgt management<br>
     * SCAC (Standard Carrier Alpha Code)management<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageScacNumber(Event e) throws EventException {
    	 GeneralEventResponse eventResponse = new GeneralEventResponse();
    	 EsmBkg0040Event event = (EsmBkg0040Event) e;
    	 BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
         try {
             begin();
             command.manageScacNumber(event.getBkgCstmsAdvScacVOS());
             eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
             commit();
         } catch(EventException ex) {
             rollback();
             throw ex;
         } catch (Exception ex) {
             rollback();
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         }
         return eventResponse;
    }
    

    /**
	* UserSetupMgt retrieve event process<br>
	* UserTmplt List retrieve<br>
	* 
	* @param e
	* @return
	* @throws EventException
	*/
    private EventResponse searchUserTmpltList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil bookingUtil = null;
        UserSetupMgtBC command = null;
        BkgUsrTmpltVO bkgUsrTmplt = null;
        BkgBlNoVO bkgBlNo = null;
        PpdCctCustInVO ppdCctCustInVO = null;
        BkgRateVO bkgRate = null;
        List<BkgUsrTmpltVO> list = null;
        try{
        	String tmpltTpCd = "";
        	if (e.getEventName().equalsIgnoreCase("EsmBkg0384Event")) {
        		//EsmBkg0384Event event = (EsmBkg0384Event) e;
        		tmpltTpCd = "R";//event.getBkgUsrTmpltVO().getTmpltTpCd();
        	} else if (e.getEventName().equalsIgnoreCase("EsmBkg0365Event")) {
        		EsmBkg0365Event event = (EsmBkg0365Event) e;
    			bookingUtil = new BookingUtil();
    			bkgBlNo = new BkgBlNoVO();
    			bkgBlNo.setBkgNo(event.getBkgNo());
    			bkgBlNo.setCaUsrId(account.getUsr_id());
    			bkgBlNo = bookingUtil.searchBkgBlNoVO(bkgBlNo);
	            ppdCctCustInVO = new PpdCctCustInVO();
	            ppdCctCustInVO.setBkgNo(bkgBlNo.getBkgNo());
	            ppdCctCustInVO.setCallType("CCT");
	            ppdCctCustInVO.setCaFlg(bkgBlNo.getCaFlg());
	            bkgRate = bookingUtil.searchBkgRate(bkgBlNo.getBlNo());
	            if (null!=bkgRate) {
	            	eventResponse.setETCData("ofc_cd", bkgRate.getCltOfcCd());
	            }
        	}
            bkgUsrTmplt = new BkgUsrTmpltVO();
            bkgUsrTmplt.setUsrId(account.getUsr_id());
            bkgUsrTmplt.setTmpltTpCd(tmpltTpCd);
            command = new UserSetupMgtBCImpl();
            list = command.searchUserTmpltList(bkgUsrTmplt);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

    /**
     * UserSetupMgt management<br>
     * UserTmplt List management<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageUserTmpltList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        try {
            begin();
            if (e.getEventName().indexOf("0365") > 0) {
                EsmBkg0365Event event = (EsmBkg0365Event) e;
                command.manageUserTmpltList(event.getBkgUsrTmpltVOS(), account);
            }else if (e.getEventName().indexOf("0384") > 0) {
                    EsmBkg0384Event event = (EsmBkg0384Event) e;
                    command.manageUserTmpltList(event.getBkgUsrTmpltVOS(), account);    
            } else {
            	EsmBkg0976Event event = (EsmBkg0976Event) e;
                command.manageUserTmpltList(event.getBkgUsrTmpltVOS(), account);
            }
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
   /**
    * EsmBkg0082Event retrieve event process<br>
    * MTPickUpCY List retrieve<br>
    * 
    * @param e
    * @return
    * @throws EventException
    */
    private EventResponse searchMTPickUpCY(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsmBkg0082Event event = (EsmBkg0082Event) e;
        MdmYardVO vo = event.getMdmYardVO();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
        BookingUtil command2 = new BookingUtil();

      
        /*String yardCode = JSPUtil.getNull(vo.getLocCd());
        if (yardCode.equals("")){
        	 yardCode = JSPUtil.getNull(vo.getLocCd());
        }*/
        String toDaty = JSPUtil.getKSTDate();
        
        List<MdmYardVO> mList = null;
        List<BkgMTPickupCYVO> dList = null;
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
	    try {  
	        if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	        	mList = command2.searchYardCode(vo);
	        	eventResponse.setRsVoList(mList);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	        	String yardCode = JSPUtil.getNull(event.getSelectSheetYdCd());
	        	dList = command.searchMTPickUpCY(yardCode,toDaty);
	        	eventResponse.setRsVoList(dList);
	        }
    	} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
        return eventResponse;
    }
    
	/**
	 * HtsCode management<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse manageHtsCode(Event e) throws EventException {
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();      
    	EsmBkg0607Event event = (EsmBkg0607Event) e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	 String hamoTpCd = event.getHamoTpCd();                                 
       try {
            begin();
            BkgHamoTrfVO[] bkgHamoTrfVOS = event.getBkgHamoTrfVOS();
            for(int i = 0; i < bkgHamoTrfVOS.length; i++){
            	bkgHamoTrfVOS[i].setHamoTpCd(hamoTpCd);
            }
            command.manageHtsCode(bkgHamoTrfVOS,account.getUsr_id());                                            
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }
   
 

	
   /**
   * EsmBkg0607Event retrieve event process<br>
   * HTSCode List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchHTSCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0607Event event = (EsmBkg0607Event) e;
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
        List<BkgHamoTrfVO> list = null;
        try {
        	list = command.searchHTSCode(event.getBkgHamoTrfVO());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * EsmBkg0607Event retrieve event process<br>
     * ComCode List retrieve<br>
  	 * @param e Event
  	 * @return response EventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchComCode0607(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
        List<BkgComboVO> list = null;
        try {
        	//HTS CODE Type
        	command = new BookingUtil();
	        list = command.searchCombo("CD02190");
	        eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
	        throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
        return eventResponse;
    }
    
    

    /**
     * EsmBkg0154Event retrieve event process<br>
     * UserDefaultSetting List retrieve<br>
  	 * @param e Event
  	 * @return response EventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchUserDefaultSettingByBooking(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0154Event event = (EsmBkg0154Event) e;
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
         
        
        if (JSPUtil.getNull(event.getBkgUsrDfltSetVO().getUsrId()).equals("")){
        	event.getBkgUsrDfltSetVO().setUsrId(account.getUsr_id());
        }
        try {
            BkgUsrDfltSetVO usrDfltSetVO = command.searchUserDefaultSetting(event.getBkgUsrDfltSetVO().getUsrId());
        	if(usrDfltSetVO!=null){
        	    eventResponse.setETCData(usrDfltSetVO.getColumnValues());
        	}
        	eventResponse.setETCData("cnt_cd",account.getCnt_cd());
            //eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * EsmBkg0154Event management event process<br>
     * UserDefaultSetting List management<br>
  	 * @param e Event
  	 * @return response EventResponse
  	 * @exception EventException
  	 */
	private EventResponse createUserDefaultSettingByBooking(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0154Event event = (EsmBkg0154Event) e;
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        BookingUtil command2 = new BookingUtil();
        
        if (JSPUtil.getNull(event.getBkgUsrDfltSetVO().getUsrId()).equals("")){
        	event.getBkgUsrDfltSetVO().setUsrId(account.getUsr_id());
        }
        event.getBkgUsrDfltSetVO().setCreUsrId(account.getUsr_id());
        event.getBkgUsrDfltSetVO().setUpdUsrId(account.getUsr_id());
        String toDaty = JSPUtil.getKSTDate();
        event.getBkgUsrDfltSetVO().setCreDt(toDaty);
        event.getBkgUsrDfltSetVO().setUpdDt(toDaty);
        
        try {
        	
        	/*******************************************************************
        	Empty P/UP CY MDM YARD CODE  등록  CHECK.
        	*******************************************************************/
        	MdmYardVO yardVo =  new MdmYardVO();;
        	yardVo.setYdCd(event.getBkgUsrDfltSetVO().getMtyPkupYdCd());
        	
        	List<MdmYardVO> yardList= command2.searchYardCode(yardVo);

        	if (yardList == null || yardList.size() < 1) {
        		String message = "Empty P/UP CY [" + event.getBkgUsrDfltSetVO().getMtyPkupYdCd() +"] is not registered in DB(MDM_YARD)";
        		eventResponse.setUserMessage(message);
				return eventResponse;
			}
        	/*******************************************************************/
            begin();
            command.createUserDefaultSettingByBooking(event.getBkgUsrDfltSetVO());
            //eventResponse.setUserMessage(new ErrorHandler("BKG00110").getUserMessage());
            //eventResponse.setUserMessage((String) new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
			
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
	
    /**
     * EsmBkg0019Event retrieve event process<br>
     * EtbEtdEta List retrieve<br>
  	 * @param e Event
  	 * @return response EventResponse
  	 * @exception EventException
  	 */
    private EventResponse searchEtbEtdEta (Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0019Event event = (EsmBkg0019Event)e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try {
			List<VskVslPortSkdConditionVO> list = command.searchEtbEtdEta(event.getVskVslPortSkdConditionVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
   /**
	* BookingUtil retrieve event process<br>
	* SvcLaneByLoc List retrieve<br>
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
    private EventResponse searchSvcLaneByLoc (Event e) throws EventException {
    	//EsmBkg0019Event event = (EsmBkg0019Event)e;
    	BookingUtil command = new BookingUtil();
    	
		try {
			List<MdmVslSvcLaneVO> list = command.searchSvcLaneCd();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

	/**
	* EsmBkg0696Event retrieve event process<br>
	* PackageCode List retrieve<br>
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
    private EventResponse searchPackageCode (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0696Event event = (EsmBkg0696Event)e;
    	BookingMasterMgtBC command = null;
    	List<MdmPckTpVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchPackageCode(event.getMdmPckTpVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }

	/**
	 * EsmBkg0653Event retrieve event process<br>
	 * CmdtCdRepCmdtCd List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCmdtCdRepCmdtCd (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0653Event event = (EsmBkg0653Event)e;
    	BookingMasterMgtBC command = null;
    	List<SearchCmdtCdRepCmdtCdVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchCmdtCdRepCmdtCd(event.getSearchCmdtCdRepCmdtCdVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
	/**
	 * EsmBkg0554Event retrieve event process<br>
	 * WareHouse List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchWareHouse (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0554Event event = (EsmBkg0554Event)e;
    	BookingMasterMgtBC command = null;
    	String cuntryCd = null;
    	String wareHouse = null;
    	List<SearchWareHouseVO> list = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
	    	cuntryCd = JSPUtil.getNull(event.getSearchWareHouseVO().getCntCd());
	    	wareHouse = JSPUtil.getNull(event.getSearchWareHouseVO().getWhCd());
			list = command.searchWareHouse(cuntryCd,wareHouse);
			if (list.size() > 0){
        		eventResponse.setETCData(((SearchWareHouseVO)list.get(0)).getColumnValues());
        	}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
	/**
	 * EsmBkg0554Event management event process<br>
	 * WareHouse List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageWareHouse(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0554Event event = (EsmBkg0554Event) e;
        BookingMasterMgtBC command = null;
        try {
            command = new BookingMasterMgtBCImpl();
            event.getSearchWareHouseVO().setCreUsrId(account.getUsr_id());
            event.getSearchWareHouseVO().setUpdUsrId(account.getUsr_id());
            begin();
            command.manageWareHouse(event.getSearchWareHouseVO());
            //eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * EsmBkg0554Event retrieve event process<br>
	 * Location List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchLocation (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0554Event event = (EsmBkg0554Event)e;
    	BookingUtil command = null;
    	String locCd = null;
		SearchLocationCodeVO vo = null;
		try {
	    	command = new BookingUtil();
	    	locCd = JSPUtil.getNull(event.getSearchWareHouseVO().getLocCd());
			vo = command.searchLocationCode(locCd);
			if (vo != null){
				eventResponse.setETCData(vo.getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
 
	/**
	 * BookingUtil retrieve event process<br>
	 * ComCode List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchComCode0154(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
        List<BkgComboVO> list = null;
        List<BkgComboVO> list2 = null;
        try {
            command = new BookingUtil();
            list = command.searchCombo("CD00765");
            eventResponse.setRsVoList(list);
            list2 = command.searchCombo("CD00764");
            eventResponse.setRsVoList(list2);
        } catch(EventException ex) {
            rollback();
            throw ex;
	    } catch (Exception ex) {
            rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * EsmBkg0596Event retrieve event process<br>
	 * BDRTime List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchBDRTime (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0596Event event = (EsmBkg0596Event)e;
    	BookingMasterMgtBC command = null;
		List<SearchBDRTimeVO> list = null;
		String vvdBdrLog = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
			list = command.searchBDRTime(event.getSearchBDRTimeVO());
			eventResponse.setRsVoList(list);
			if (0==list.size()) {
				event.getSearchBDRTimeVO().setBdrFlg("");
				list = command.searchBDRTime(event.getSearchBDRTimeVO());
			}
			
			/*
			 * bkg_no 로 조회시 vvd, pol, pod가 없어 조회된에 있는 값으로 쓴다.
			 */
			if(event.getSearchBDRTimeVO().getVvdCd() != null 
					&& "".equals(event.getSearchBDRTimeVO().getVvdCd()) 
					&& list.size() > 0 ) {
				event.getSearchBDRTimeVO().setVvdCd(list.get(0).getVvdCd());
				event.getSearchBDRTimeVO().setPolCd(list.get(0).getPolCd());
				event.getSearchBDRTimeVO().setPodCd(list.get(0).getPodCd());
			}
				
			vvdBdrLog = command.checkVvdBdrLog(event.getSearchBDRTimeVO().getVvdCd(),event.getSearchBDRTimeVO().getPolCd(),event.getSearchBDRTimeVO().getPodCd(),event.getSearchBDRTimeVO().getRdoTrunkFeeder());
			vvdBdrLog = vvdBdrLog.equals("Y")?"Yes":"No";
			if (0 < list.size()) {
				eventResponse.setETCData("vvd_bdr", vvdBdrLog);
	    		eventResponse.setETCData("total_booking_cnt", list.get(0).getTotBookingCnt());
	    		eventResponse.setETCData("btr_booking_cnt", list.get(0).getBtrBookingCnt());
			} else {
				eventResponse.setETCData("total_booking_cnt", "0");
	    		eventResponse.setETCData("btr_booking_cnt", "0");
	    		eventResponse.setETCData("vvd_bdr", vvdBdrLog);
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
	/**
	 * EsmBkg0596Event modify event process<br>
	 * BDRLog List modify<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse modifyBDRLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0596Event event = (EsmBkg0596Event)e;
		BookingMasterMgtBC mstBc = new BookingMasterMgtBCImpl();
		BLDocumentationBLBC blDocBc = new BLDocumentationBLBCImpl();
		//CargoReleaseOrderBC inboundBc = new  CargoReleaseOrderBCImpl();
		BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
		String flag="";
		
		OblRdemVO[] oblRdems = null;
		HistoryTableVO historyTableVO = new HistoryTableVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		
		try {
			SearchBDRTimeVO vo = event.getSearchBDRTimeVO();
			SearchBDRTimeVO[] vos = event.getSearchBDRTimeVOS();
		 	
			if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				flag = "BKG_BDR";
	    	} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
	    		flag = "VVD_BDR";
	    	} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
	    		flag = "BKG_C_BDR";
	    	} else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {	
	    		flag = "VVD_C_BDR";
	    	}
			begin();
			
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			
			if (flag.equalsIgnoreCase("BKG_BDR") || flag.equalsIgnoreCase("BKG_C_BDR")){
				oblRdems = new OblRdemVO[vos.length];
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					if ( vos[i].getIbflag().equals("U")){
						// searchOldBkgForHistory 수행
						bkgBlNoVO.setBkgNo(vos[i].getBkgNo());
						historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0596", bkgBlNoVO);
						if (flag.equalsIgnoreCase("BKG_C_BDR")){
							vos[i].setIbflag("D");
						}
						blDocBc.modifyCntrCFM(vos[i].getBkgNo(),vos[i].getIbflag(),vos[i].getUpdUsrId());
						blDocBc.modifyBKGBDR(vos[i].getBkgNo(),vos[i].getIbflag(),vos[i].getUpdUsrId());
						if (flag.equalsIgnoreCase("BKG_BDR")){ 
							oblRdems[i] = setupFocByObl(vos[i]);
						}
						
						historyBC.manageBookingHistory("ESM_BKG_0596", historyTableVO, account);
					}
				}
			}else if (flag.equalsIgnoreCase("VVD_BDR") || flag.equalsIgnoreCase("VVD_C_BDR")){
				
				if (vo.getVslCd().equals("")){
					vo.setVslCd(vo.getVvdCd().substring(0,4));
					vo.setSkdVoyNo(vo.getVvdCd().substring(4,8));
					vo.setSkdDirCd(vo.getVvdCd().substring(8,9));
					vo.setVpsPortCd(vo.getPolCd());
				}	
				boolean rtnChk = mstBc.checkBDRVVDPOL(vo);
				if (rtnChk == false){
					throw new EventException((String) new ErrorHandler("BKG00058", new String []{vo.getVvdCd()}).getMessage());
				}
				if (flag.equalsIgnoreCase("VVD_C_BDR")){
					vo.setIbflag("D");
					vo.setBdrFlg("Y");
					
				}else{
					vo.setIbflag("U");
					vo.setBdrFlg("N");
				}
				List<SearchBDRTimeVO> bdrVvdList = mstBc.searchBDRTime(vo);
				
				//BKG_VVD_BDR_LOG -TRNK_AUTO_BDR_FLG,TRNK_MNL_BDR_FLG,FDR_AUTO_BDR_FLG,FDR_MNL_BDR_FLG,FDR_BDR_FLG,TRNK_BDR_FLG,TRNK_MNL_BDR_DT
				mstBc.modifyBDRLog(vo);	
				oblRdems = new OblRdemVO[bdrVvdList.size()];
				
				if (null!=bdrVvdList && 0<bdrVvdList.size()) {
					for (int i = 0; i < bdrVvdList.size(); i++) {
						// searchOldBkgForHistory 수행
						bkgBlNoVO.setBkgNo(bdrVvdList.get(i).getBkgNo());
						historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0596", bkgBlNoVO);
						if (flag.equalsIgnoreCase("VVD_C_BDR")){
							bdrVvdList.get(i).setIbflag("D");
						}
						bdrVvdList.get(i).setCreUsrId(account.getUsr_id());
						bdrVvdList.get(i).setUpdUsrId(account.getUsr_id());
						//BKG_BL_DOC -BDR_FLG
						blDocBc.modifyBKGBDR(bdrVvdList.get(i).getBkgNo(),bdrVvdList.get(i).getIbflag(),bdrVvdList.get(i).getUpdUsrId());
						//BKG_CONTAINER -CNTR_CFM_FLG
						blDocBc.modifyCntrCFM(bdrVvdList.get(i).getBkgNo(),bdrVvdList.get(i).getIbflag(),bdrVvdList.get(i).getUpdUsrId());	 
						
						if (flag.equalsIgnoreCase("VVD_BDR")){
							oblRdems[i] = setupFocByObl(bdrVvdList.get(i));
						}
						
						historyBC.manageBookingHistory("ESM_BKG_0596", historyTableVO, account);
					}
				}	
			}
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
			
			/*
			if (flag.equalsIgnoreCase("BKG_BDR") || flag.equalsIgnoreCase("VVD_BDR")){
				inboundBc.setupFocByOblAutoBdr(oblRdems);
			}*/
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 *
	 * BDR Transfer process to IB<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @exception EventException
	 */	
	private OblRdemVO setupFocByObl(SearchBDRTimeVO vo) throws EventException {
		OblRdemVO oblRdem = null;
		try {
			oblRdem = new OblRdemVO();
			oblRdem.setBlNo(vo.getBlNo());
			oblRdem.setCgorTeamCd("B");
			oblRdem.setCgoEvntNm("B/L BDR");
			oblRdem.setEvntDt(JSPUtil.getKST("yyyyMMddHHmmss")); //YYYYMMDDHH24MISS
			oblRdem.setEvntOfcCd("SYS");
			oblRdem.setEvntUsrId("BDRBookingSetting");
			oblRdem.setOblChk("N");
			oblRdem.setOblRdemFlg(vo.getOblIssFlag());
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return oblRdem;
	}

	/**
	 * UserSetupMgt의 retrieve event process<br>
	 * RmkTemplate List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchRmkTemplate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BkgUsrTmpltVO vo = null;
        UserSetupMgtBC command = null;
        List<BkgUsrTmpltVO> list = null;
        try {
	        vo = new BkgUsrTmpltVO();
	        vo.setUsrId(account.getUsr_id());
	        log.debug(">>> USER_ID : " + vo.getUsrId());
	        command = new UserSetupMgtBCImpl();
	        list = command.searchRmkTemplate(vo);
	        eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

	/**
	 * UserSetupMgt의 retrieve event process<br>
	 * UserXterSearchSet List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchUserXterSearchSet(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        UserSetupMgtBC command = new UserSetupMgtBCImpl();
	        BookingUtil comboUtil = new BookingUtil();
	        
	        EBookingReceiptBC comboMdmUtil = new EBookingReceiptBCImpl();
	
			// Doc Type - doc_tp_inq_cd - CD02348
	        List<BkgComboVO> doc_tp_cd = comboUtil.searchCombo("CD02348");
			eventResponse.setRsVoList(doc_tp_cd);
	
			// Upload Status - bkg_upld_sts_cd - CD01630
			List<BkgComboVO> bkg_upld_sts_cd  = comboUtil.searchCombo("CD01630");
			eventResponse.setRsVoList(bkg_upld_sts_cd);
	
			// Via - xter_rqst_via_cd - CD01622
			List<BkgComboVO> xter_rqst_via_cd  = comboUtil.searchCombo("CD01622");
			eventResponse.setRsVoList(xter_rqst_via_cd);
	
			// DOCType - bkg_cust_tp_cd - CD02140
			List<BkgComboVO> bkg_cust_tp_cd  = comboUtil.searchCombo("CD02140");
			eventResponse.setRsVoList(bkg_cust_tp_cd);
	
			// Delivery - conti_cd - CD00191
			List<BkgComboVO> conti_cd  = comboMdmUtil.searchComboMdmConti();
			eventResponse.setRsVoList(conti_cd);
	
			eventResponse.setRsVoList(command.searchUserXterSearchSet(account.getUsr_id()));
        } catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }

	/**
	 * EsmBkg0232Event retrieve event process<br>
	 * UserXterSearchSet List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse manageUserXterSearchSet(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        EsmBkg0232Event event = (EsmBkg0232Event) e;
        try {
            begin();
            command.manageUserXterSearchSet(event.getBkgXterSrchSetVOS(), account);
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

	    
	/**
	 * EsmBkg0073Event retrieve event process<br>
	 * BDRPol List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchBDRPol (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0073Event event = (EsmBkg0073Event)e;
    	BookingMasterMgtBC command = null;
		List<SearchBDRPolVO> list = null;
		List<SearchBDRTimeTableVO> list2 = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
			if (event.getSearchBDRPolVO().getOptSelBdr().equals("Lane")){
				list = command.searchBDRPol(event.getSearchBDRPolVO());
				eventResponse.setRsVoList(list);
			} else {
				list2 = command.searchBDRTimeTable(event.getSearchBDRTimeTableVO());
				eventResponse.setRsVoList(list2);
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
	/**
	 * EsmBkg0073Event retrieve event process<br>
	 * BDRTimeTable List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchBDRTimeTable (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0073Event event = (EsmBkg0073Event)e;
    	BookingMasterMgtBC command = null;
		List<SearchBDRTimeTableVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchBDRTimeTable(event.getSearchBDRTimeTableVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
	/**
	 * BookingUtil retrieve event process<br>
	 * ComCode0073 List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchComCode0073(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
    	List<MdmVslSvcLaneVO> list = null;
        List<BkgComboVO> list2 = null;
        try {
            command = new BookingUtil();
        	list = command.searchSvcLaneCd();
            eventResponse.setRsVoList(list);
            list2 = command.searchCombo("CD00714");
            eventResponse.setRsVoList(list2);
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * EsmBkg0073Event retrieve event process<br>
	 * ComCode0073_port List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchComCode0073_port(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0073Event event = (EsmBkg0073Event)e;
        BookingUtil command = null;
        String vsl_slan_cd = "";
        String skd_dir_cd  = "";
        String port_cd  = "";
        try {
        	List<SearchSvcLaneBoundVO> list = null;
        	List<SearchSvcLaneBoundVO> list2 = new ArrayList<SearchSvcLaneBoundVO>();
        	
        	command = new BookingUtil();
        	vsl_slan_cd = event.getSearchBDRPolVO().getCbSlanCd();
        	skd_dir_cd = event.getSearchBDRPolVO().getCbSkdDirCd();
        	port_cd = event.getSearchBDRPolVO().getCbPolCd();
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
        		port_cd = "";
        	}
        	list = command.searchPortCdListByLane(vsl_slan_cd,skd_dir_cd,port_cd);
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
	        	if (null!=list && 0<list.size()) {
//	        		list2 = new ArrayList<SearchSvcLaneBoundVO>();
					for (SearchSvcLaneBoundVO vo : list) {
						if (!vo.getPortCd().equals(port_cd)) {
							list2.add(vo);
						}
					}
	        	}	
	        	eventResponse.setRsVoList(list2);
        	} else {
        		eventResponse.setRsVoList(list);
        	}	
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * EsmBkg0073Event retrieve event process<br>
	 * vvd_port List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchComCode0073_vvd_port(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0073Event event = (EsmBkg0073Event)e;
        BookingUtil command = null;
        String vvd_cd  = "";
    	List<SearchPortCdByVvdVO> list = null;
        try {
            command = new BookingUtil();
        	vvd_cd = event.getSearchBDRTimeTableVO().getVvd();
        	list = command.searchPortCdListByVvd(vvd_cd);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * EsmBkg0073Event management event process<br>
	 * BDR TIME TABLE management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse manageVVDBDRTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0073Event event = (EsmBkg0073Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try {
			SearchBDRPolVO[] searchBDRPolVOs = event.getSearchBDRPolVOS();
			SearchBDRTimeTableVO[] searchBDRTimeTableVOs = event.getSearchBDRTimeTableVOS();
			
			if (null != searchBDRPolVOs && searchBDRPolVOs.length > 0){
				for ( int i=0; i<searchBDRPolVOs.length; i++ ) {
					if ( searchBDRPolVOs[i].getIbflag().equals("I") ||  searchBDRPolVOs[i].getIbflag().equals("U")){
						if (command2.validateLoc(searchBDRPolVOs[i].getPodCd())==false){
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00165",new String[]{}).getUserMessage());
							return eventResponse;
						}
					}
				}
			}
			begin();
			command.manageVVDBDRTime(searchBDRPolVOs,searchBDRTimeTableVOs, account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			  
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EsmBkg0073Event management event process<br>
	 * BKGBDRLOG management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse manageBKGBDRLOG(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0073Event event = (EsmBkg0073Event)e;
		BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
		try {
			BkgVvdBdrLogVO bkgVvdBdrLogVO = new BkgVvdBdrLogVO() ;
			
			String vvdCd = event.getSearchBDRTimeTableVO().getVvd();
			bkgVvdBdrLogVO.setVslCd(vvdCd.substring(0,4));
			bkgVvdBdrLogVO.setSkdVoyNo(vvdCd.substring(4,8));
			bkgVvdBdrLogVO.setSkdDirCd(vvdCd.substring(8,9));
			begin();
			bkgVvdBdrLogVO = command.manageBKGBDRLOG(bkgVvdBdrLogVO, account);
			 
			if (bkgVvdBdrLogVO.getOResult().equals("F")){
				rollback();
				throw new EventException (new ErrorHandler(bkgVvdBdrLogVO.getOErrMsg()).getMessage());
			} 
			eventResponse.setUserMessage(bkgVvdBdrLogVO.getOErrMsg());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EsmBkg0253Event retrieve event process<br>
	 * EqualizetionPortCD List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchEqualizetionPortCD (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0253Event event = (EsmBkg0253Event)e;
    	BookingMasterMgtBC command = null;
		List<BkgEqlzPortVO> list = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
			list = command.searchEqualizetionPortCD(event.getBkgEqlzPortVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }

	/**
	 * EsmBkg0253Event management event process<br>
	 * EqualizationPort List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEqualizationPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0253Event event = (EsmBkg0253Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try {
			BkgEqlzPortVO[] bkgEqlzPortVOs= event.getBkgEqlzPortVOS();
			
//			if (bkgEqlzPortVOs !=null && bkgEqlzPortVOs.length > 0){
			if (bkgEqlzPortVOs.length > 0){
				for ( int i=0; i<bkgEqlzPortVOs.length; i++ ) {
					if ( bkgEqlzPortVOs[i].getIbflag().equals("I") ||  bkgEqlzPortVOs[i].getIbflag().equals("U")){
						if (command2.validateLoc(bkgEqlzPortVOs[i].getLocCd()) ==false){
							throw new EventException((String) new ErrorHandler("BKG00138", new String []{}).getMessage());
						}
						if (command2.validateLoc(bkgEqlzPortVOs[i].getEqlzPortCd())==false){
							throw new EventException((String) new ErrorHandler("BKG00138", new String []{}).getMessage());
						}
					}
					if ( bkgEqlzPortVOs[i].getIbflag().equals("I")){
						List<BkgEqlzPortVO> list = command.searchEqualizetionPortCD(bkgEqlzPortVOs[i]);
						if (list != null && list.size() > 0){
							throw new EventException((String) new ErrorHandler("BKG06018", new String []{}).getMessage());
						}
					}
				}
			}
			begin();
			command.manageEqualizationPort(bkgEqlzPortVOs, account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * EsmBkg0192Event management event process<br>
	 * InBoundCustList List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInBoundCustList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0192Event event = (EsmBkg0192Event)e;
		BookingMasterMgtBC command = null;
		try {
			List<SearchInBoundCustListVO> list = null;
			command = new BookingMasterMgtBCImpl();
			list = command.searchInBoundCustList(event.getInfoVO());
			if (null!=list && 0 < list.size()) {
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
				
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkg0192Event retrieve event process<br>
	 * InBoundCustTmpltList List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInBoundCustTmpltList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0192Event event = (EsmBkg0192Event)e;
		BookingMasterMgtBC command = null;
		List<BkgCustTmpltVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchInBoundCustTmpltList(event.getInfoVO2());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg0192Event management event process<br>
	 * InBoundCustTmpltList List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInBoundCustList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0192Event event = (EsmBkg0192Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try{
			begin();
			
			command.manageInBoundCustList(event.getInfoVO2s(),account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * EsmBkg0153Event retrieve event process<br>
	 * ChinaAgentCode List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchChinaAgentCodeList (Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0153Event event = (EsmBkg0153Event)e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BkgChinaAgentVO> list = command.searchChinaAgentCodeList(event.getSearchChinaAgentCodeVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
	/**
	 * EsmBkg0153Event management event process<br>
	 * ChinaAgentCode List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChinaAgentCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0153Event event = (EsmBkg0153Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try {
			BkgChinaAgentVO[] bkgChinaAgentVOs= event.getSearchChinaAgentCodeVOS();
			
//			if (bkgChinaAgentVOs !=null && bkgChinaAgentVOs.length > 0){
			if (bkgChinaAgentVOs.length > 0){
				for ( int i=0; i<bkgChinaAgentVOs.length; i++ ) {
					if ( bkgChinaAgentVOs[i].getIbflag().equals("I") ||  bkgChinaAgentVOs[i].getIbflag().equals("U")){
						
						
						/*customer check*/
						if (bkgChinaAgentVOs[i].getCustCntCd().equals("") || bkgChinaAgentVOs[i].getCustSeq().equals("")){
							//The Customer code($s,$s) is not registered
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00831",new String[]{bkgChinaAgentVOs[i].getCustCntCd(),bkgChinaAgentVOs[i].getCustSeq()}).getUserMessage());
							return eventResponse;
						}
						
						MdmCustVO mdmCustVO = command2.searchMdmCust(bkgChinaAgentVOs[i].getCustCntCd(), bkgChinaAgentVOs[i].getCustSeq(),"Y");
						if (mdmCustVO.getName().equals("")){
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00831",new String[]{bkgChinaAgentVOs[i].getCustCntCd(),bkgChinaAgentVOs[i].getCustSeq()}).getUserMessage());
							return eventResponse;
						}
						
						/*office code check*/
						if (bkgChinaAgentVOs[i].getFincOfcCd().equals("")){
							//The Control Office code($s)  is not registered
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00830",new String[]{bkgChinaAgentVOs[i].getFincOfcCd()}).getUserMessage());
							return eventResponse;
						}
						MdmOrganizationVO  mdmOrzVO = command2.searchMdmOrzByOfcCd(bkgChinaAgentVOs[i].getFincOfcCd());
						if (mdmOrzVO.getArOfcCd().equals("")){
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00830",new String[]{bkgChinaAgentVOs[i].getFincOfcCd()}).getUserMessage());
							return eventResponse;
						}
						
						/*vendor code check*/
						if (bkgChinaAgentVOs[i].getVndrCntCd().equals("") || bkgChinaAgentVOs[i].getVndrSeq().equals("")){
							//The Vendor code($s,$s)  is not registered
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00832",new String[]{bkgChinaAgentVOs[i].getVndrCntCd(),bkgChinaAgentVOs[i].getVndrSeq()}).getUserMessage());
							return eventResponse;
						}
						if (command2.checkVenodrCode(bkgChinaAgentVOs[i].getVndrCntCd(),bkgChinaAgentVOs[i].getVndrSeq())==false){
							//The Vendor code($s,$s)  is not registered
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00832",new String[]{bkgChinaAgentVOs[i].getVndrCntCd(),bkgChinaAgentVOs[i].getVndrSeq()}).getUserMessage());
							return eventResponse;
						}
						
					}
				}
			}
			begin();
			command.manageChinaAgentCode(bkgChinaAgentVOs, account);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EsmBkg0153Event retrieve event process<br>
	 * CheckCode0153 List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchCheckCode0153(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsmBkg0153Event event = (EsmBkg0153Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        try {
        	
        	if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
        		MdmOrganizationVO  mdmOrzVO = command.searchMdmOrzByOfcCd(event.getSearchChinaAgentCodeVO().getOfcCd());
    			if (mdmOrzVO == null || mdmOrzVO.getArOfcCd().equals("")){
    				throw new EventException((String)new ErrorHandler("BKG00830",new String[]{event.getSearchChinaAgentCodeVO().getOfcCd()}).getUserMessage());
    			}
    			eventResponse.setETCData(mdmOrzVO.getColumnValues());
           	} 
        	if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
           		MdmCustVO mdmCustVO  = command.searchMdmCust(event.getSearchChinaAgentCodeVO().getCustCntCd(),event.getSearchChinaAgentCodeVO().getCustSeq(),"Y");
           		if (mdmCustVO == null || mdmCustVO.getName().equals("")){
					eventResponse.setUserMessage((String) new ErrorHandler("BKG00831",new String[]{event.getSearchChinaAgentCodeVO().getCustCntCd(),event.getSearchChinaAgentCodeVO().getCustSeq()}).getUserMessage());
					return eventResponse;
				}
           		eventResponse.setETCData(mdmCustVO.getColumnValues());
            }
        } catch(EventException ex) {
        	throw ex;
			//throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

	/**
	 * EsmBkg0354Event retrieve event process<br>
	 * CanadaGroupLocationCD List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchCanadaGroupLocationCD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = null;
		List<BkgcustomscanadagrouplocationVO> list = null;
		try {
			command = new CustomsMasterMgtBCImpl();
			list = command.searchCanadaGroupLocationCD(event.getInfoVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * 0354: EsmBkg0354Event<br>
	 * Canada ACI: Location of Goods Setup - Loc Code 생성/수정을 위한 기존 데이타를 조회합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanadaGroupLocationCD2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = null;
		List<BkgcustomscanadagrouplocationVO> list = null;
		StringBuilder sbReturnVal = null;
		try {
			command = new CustomsMasterMgtBCImpl();
			list = command.searchCanadaGroupLocationCD2(event.getInfoVO());
			sbReturnVal = new StringBuilder();  //중복데이타가 존재하면 POD,DEL코드를 알려준다.
			if (null!=list && 0<list.size()) {
				for (BkgcustomscanadagrouplocationVO vo : list) {
					sbReturnVal.append(vo.getPodCd()).append("\n");
				}
	    		eventResponse.setETCData("EXIST_MSG",sbReturnVal.toString());
	    	} else {
	    		eventResponse.setETCData("EXIST_MSG","");
	    	}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * EsmBkg0741Event retrieve event process<br>
	 * OfficePfmc List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchOfficePfmc (Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0741Event event = (EsmBkg0741Event)e;
    	
    	String option = event.getBkgDocPerfOfcVO().getChkOp();
    	
    	String temp[] = option.split(":");
    	
    	BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BkgDocPerfOfcVO> list = command.searchOfficePfmc(event.getBkgDocPerfOfcVO());
			
			//Doc Performance    
			if (temp[0].equals("A")){
				
				eventResponse.setRsVoList(list);
			}else{//e-Service Handling Office
				
				String ctrnOfcCd = null;
	    		
	    		String[] tempCtrl = null;
	    		
	    		int maxCtrl = 0;
	        	
	    		BkgDocPerfOfcVO vo = new BkgDocPerfOfcVO();
	    		
	        	for(int i = 0 ; i < list.size() ; i++){
	        		
	        		vo = list.get(i);
	        		
	        		ctrnOfcCd = vo.getCtrlOfcCd();
	        		
	        		if (ctrnOfcCd != null){        		
		        		
	        			tempCtrl = ctrnOfcCd.split(",");
	        			
	        			if (tempCtrl.length > maxCtrl){
	        				
	        				maxCtrl = tempCtrl.length;
	        			}	        			
	        		}
	        		
	        	}	
	        	
	        	eventResponse.setETCData("maxCtrl", Integer.toString(maxCtrl));
				eventResponse.setRsVoList(list);
			}
							
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    

	/**
	 * EsmBkg0741Event management event process<br>
	 * OfficePfmc List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageOfficePfmc(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0741Event event = (EsmBkg0741Event) e;
    	BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
        try {
            begin();
            command.manageOfficePfmc(event.getBkgEsvcHndlOfcVOS(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }

	/**
	 * EsmBkg0741Event check event process<br>
	 * OfficePfmc List check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkOfficePfmc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0741Event event = (EsmBkg0741Event) e;
        BookingProcessMgtBC command = null;
        List<BkgDocPerfOfcVO> list = null;

        try {
            String check   = "";
//            String chkHOFC = null;
            String chkHOFC = "";
            String[] temp  = null;
        	
        	command = new BookingProcessMgtBCImpl();
	        list = command.checkOfficePfmc(event.getBkgDocPerfOfcVO());
	        temp  = event.getBkgDocPerfOfcVO().getChkOp().split(":");
        	check = 0 < list.size() ? "Y" : "N";
	        log.debug("ofc_ty >>> " + event.getBkgDocPerfOfcVO().getOfcTy());
	        log.debug("chk_op >>> " + temp[0]);
	        
	        event.getBkgDocPerfOfcVO().setChkOp(temp[0]);
	        //e-Service Handling Office 占쎈Ŋ苑� 
	        //Controlled Office 占쏙옙占쎄퉭以됵옙占폨ffice 揶쏉옙 H/OFC 占쏙옙占쎄퉭以됵옙�꼷占� 占쎈봾猷꾣에占쏙㎗�똾寃뺧옙占�
	       
	        if ("3".equals(event.getBkgDocPerfOfcVO().getOfcTy())) {
	        	list = command.checkCtrlOffice(event.getBkgDocPerfOfcVO());
        		chkHOFC = 0 < list.size() ? "N" : "Y";
	        }
	        eventResponse.setETCData("check",check);
	        eventResponse.setETCData("chkHOFC",chkHOFC);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * EsmBkg0354Event management event process<br>
	 * CanadaGroupLocationCD( List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCanadaGroupLocationCD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = new CustomsMasterMgtBCImpl();
		try{
			begin();
			BkgcustomscanadagrouplocationVO[] vos= event.getInfoVOs();
			String tempParam = ""; 
			StringBuilder sbReturnVal = new StringBuilder();
			
			if (vos !=null && vos.length > 0){
				for ( int i=0; i<vos.length; i++ ) {
					if ( vos[i].getIbflag().equals("I") ||  vos[i].getIbflag().equals("U")){
						tempParam = tempParam +  vos[i].getPodCd() + ">" + vos[i].getDelCd() + "|";
					}
				}
				
				if (!tempParam.equals("")){
					BkgcustomscanadagrouplocationVO svo = new BkgcustomscanadagrouplocationVO();
					svo.setPodCd(tempParam);
					
					List<BkgcustomscanadagrouplocationVO> list = command.searchCanadaGroupLocationCD2(svo);
					if (null!=list && 0<list.size()){
						sbReturnVal.append("[");
						for (BkgcustomscanadagrouplocationVO vo : list) {
							sbReturnVal.append(vo.getPodCd()).append("");
						}
						sbReturnVal.append("]");
						eventResponse.setUserMessage((String) new ErrorHandler("BKG00764",new String[]{sbReturnVal.toString()}).getUserMessage());
						return eventResponse;
					}
				}	
			}	
						
			command.manageCanadaGroupLocationCD(event.getInfoVOs(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * EsmBkg0374Event management event process<br>
	 * ANDestOfcList List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchANDestOfcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0374Event event = (EsmBkg0374Event)e;
		BookingProcessMgtBC command = null;
		List<BkganDestOfcStupVO> list = null;
		try {
			command = new BookingProcessMgtBCImpl();
			list = command.searchANDestOfcList(event.getInfoVO().getPEqCtrlOfcCd(),event.getInfoVO().getPHndlOfcCd());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkg0374Event retrieve event process<br>
	 * ANDestOfcList2 List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchANDestOfcList2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0374Event event = (EsmBkg0374Event)e;
		BookingProcessMgtBC command = null;
		List<BkganDestOfcStupVO> list = null;
		try {
			command = new BookingProcessMgtBCImpl();
			list = command.searchANDestOfcList2(event.getInfoVO().getPEqCtrlOfcCd(),event.getInfoVO().getPHndlOfcCd());
			if (0 < list.size()) {
				eventResponse.setETCData("HQ_OFC_SELECT_FLAG", "Y");
				eventResponse.setETCData("EQ_OFC_CD", list.get(0).getEqCtrlOfcCd());
				eventResponse.setETCData("HQ_OFC_CD", list.get(0).getHndlOfcCd());
			} else {
				eventResponse.setETCData("HQ_OFC_SELECT_FLAG", "N");
			}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg0374Event management event process<br>
	 * ANDestOfcList List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageANDestOfcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0374Event event = (EsmBkg0374Event)e;
		BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
		try{
			begin();
			command.manageANDestOfcList(event.getInfoVOs(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Cms0070001Event management event process<br>
	 * BkgCustSlsRep List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgCustSlsRep(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Cms0070001Event event = (Cms0070001Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try{
			begin();
			command.manageBkgCustSlsRep(event.getMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	 /**
	 * 0949: EsmBkg0949Event<br>
	 * SERVICE LANE CODE SEARCH.
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceLane() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = null;
		BookingMasterMgtBC command2 = null;
		List<MdmVslSvcLaneVO> list = null;
		List<MdmCountryVO> list2 = null;
		StringBuffer slanCd = null;
		StringBuffer slanVa = null;
		StringBuffer cntCd = null;
		StringBuffer cntNm = null;
		try {
			command = new BookingUtil();
			command2 = new BookingMasterMgtBCImpl();
			list = command.searchSvcLaneCd();
			list2 = command2.searchCntCdNm();
			slanCd = new StringBuffer();
			slanVa = new StringBuffer();
			cntCd = new StringBuffer();
			cntNm = new StringBuffer();
			slanCd.append("ALL");
			slanVa.append("*");
			cntCd.append("*");
			cntNm.append("ALL");
			if (0 < list.size()) {
	        	for (MdmVslSvcLaneVO mdmVslSvcLaneVO : list) {
	        		slanCd.append("|" + mdmVslSvcLaneVO.getVslSlanCd());
	        		slanVa.append("|" + mdmVslSvcLaneVO.getVslSlanCd());
	        	}
			}
			if (0 < list2.size()) {
				for (MdmCountryVO mdmCountryVO : list2) {
					cntCd.append("|" + mdmCountryVO.getCntCd());
					cntNm.append("|" + mdmCountryVO.getCntNm());
				}
			}
	        eventResponse.setETCData("slanCd",slanCd.toString());
	        eventResponse.setETCData("slanVa",slanVa.toString());
	        eventResponse.setETCData("cntCd",cntCd.toString());
	        eventResponse.setETCData("cntNm",cntNm.toString());
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg0949Event retrieve event process<br>
	 * DocCutOffTimeList List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchDocCutOffTimeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0949Event event = (EsmBkg0949Event)e;
		BookingMasterMgtBC command = null;
		String vslSlanCd = null;
		String ydCd = null;
		String deltFlg = null;
		List<BkgdocClzSetListVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			vslSlanCd = event.getBkgdocClzSetListVO().getVslSlanCd();
			ydCd = event.getBkgdocClzSetListVO().getYdCd();
			deltFlg = event.getBkgdocClzSetListVO().getDeltFlg();
			list = command.searchDocCutOffTimeList(ydCd, vslSlanCd, deltFlg);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg0949Event management event process<br>
	 * ocCutOffTimeList List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDocCutOffTimeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0949Event event = (EsmBkg0949Event)e;
		BookingMasterMgtBC command = null;
		try{
			begin();
			command = new BookingMasterMgtBCImpl();
			command.manageDocCutOffTimeList(event.getBkgdocClzSetVOS(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg0949Event retrieve event process<br>
	 * LocationCode List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchLocationCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0949Event event = (EsmBkg0949Event)e;
		BookingUtil command = null;
		String pol = null;
		SearchLocationCodeVO vo = null;
		try {
			command = new BookingUtil();
			pol = event.getBkgdocClzSetListVO().getPol();
			vo = command.searchLocationCode(pol);
			if (null != vo && "Y".equals(vo.getCallPortFlg())) {
				eventResponse.setETCData("check","Y");
			} else {
				eventResponse.setETCData("check","N");
			}
			
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BookingUtil retrieve event process<br>
	 * DayTypeCode List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchDayTypeCode() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = null;
        List<BkgComboVO> list = null;

		try {
			command = new BookingUtil();
		
			list = command.searchCombo("CD02769");
	        eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg1030Event management event process<br>
	 * MandatoryItemSetup List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMandatoryItemSetupList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1030Event event = (EsmBkg1030Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		try{
			begin();
			command.manageMandatoryItemSetupList(event.getMandatoryItemSetupListVOS(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EsmBkg1030Event retrieve event process<br>
	 * MandatoryItemSetup List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchMandatoryItemSetupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1030Event event = (EsmBkg1030Event)e;
		BookingMasterMgtBC command = null;
		List<BkgMdtItmVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchMandatoryItemSetupList(event.getBkgMdtItmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg1030Event check event process<br>
	 * CustCd List check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */

	private EventResponse checkCustCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1030Event event = (EsmBkg1030Event)e;
		BookingUtil command = null;
		String custCd = null;
		String custSeq = null;
		MdmCustVO vo = null;
		try {
			command = new BookingUtil();
			custCd = event.getCustCd();
			custSeq = event.getCustSeq();
			if (!"".equals(custCd) && !"".equals(custSeq)) {
				vo 	= command.searchMdmCust(custCd, custSeq, "N");
			}
			eventResponse.setETCData("check",null!=vo ? "N":"Y");
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg1030Event check event process<br>
	 * CustCd List check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse checkDupCustCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1030Event event = (EsmBkg1030Event)e;
		
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		String checkFlg = "N";
		
		try{
			checkFlg = command.checkDupCustCd(event.getBkgMdtItmVOS());
			eventResponse.setETCData("DUP_CUST",checkFlg);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * EsmBkg0743Event retrieve event process<br>
	 * UserPrintSetup List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchUserPrintSetup(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0743Event event = (EsmBkg0743Event)e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	BLIssuanceBC command2 = new BLIssuanceBCImpl();
    	
    	String strBkgNo = "";
    	String strCorrNo = "";
    	String strRate = "";
    	String strCntr = "";
    	String strHData = "";
    	
        BookingUtil command3 = new BookingUtil();
    	
		try {
			List<BkgUsrDfltSetVO> list = command.searchUserPrintSetup(event.getInfoVO(),account);
			if(list.size() > 0){
				eventResponse.setETCData("bl_face_prn_dvc_nm", list.get(0).getBlFacePrnDvcNm());
				eventResponse.setETCData("bl_ridr_prn_dvc_nm", list.get(0).getBlRidrPrnDvcNm());
				eventResponse.setETCData("bl_prn_dvc_nm", list.get(0).getBlPrnDvcNm());
				eventResponse.setETCData("obl_iss_knt", list.get(0).getOblIssKnt());
				eventResponse.setETCData("bl_prn_setup", list.get(0).getBlPrnSetup());
				eventResponse.setETCData("bl_tp_cd", list.get(0).getBlTpCd());
				eventResponse.setETCData("obl_iss_flg", list.get(0).getOblIssFlg());
				eventResponse.setETCData("obl_prn_flg", list.get(0).getOblPrnFlg());
				eventResponse.setETCData("bb_cgo_flg",  list.get(0).getBbCgoFlg());
				eventResponse.setETCData("bl_cpy_knt",  list.get(0).getBlCpyKnt());
				eventResponse.setETCData("bl_cpy_no",  list.get(0).getBlCpyNo());
				eventResponse.setETCData("conti_cd",  list.get(0).getContiCd());
				eventResponse.setETCData("org_ppd_rcv_cd",  list.get(0).getOrgPpdRcvCd());
				eventResponse.setETCData("org_n3pty_ppd_cd",  list.get(0).getOrgN3ptyPpdCd());
				eventResponse.setETCData("print_release_yn",  list.get(0).getPrintReleaseYn());
				eventResponse.setETCData("bl_esig_flg",  list.get(0).getBlEsigFlg());
				eventResponse.setETCData("bl_cpy_esig_flg",  list.get(0).getBlCpyEsigFlg());
				eventResponse.setETCData("bl_knt_flg",  list.get(0).getBlKntFlg());
				eventResponse.setETCData("bl_prn_chg_tp_cd",  list.get(0).getBlPrnChgTpCd());
			}
			
			strBkgNo = event.getBkgNo();
			strCorrNo = event.getCorrNo() == null ? "" : event.getCorrNo();
			strHData = event.getHiddenData().equals("") || event.getHiddenData() == null ? "N" : event.getHiddenData();
			strRate = event.getChargeTp().equals("") || event.getChargeTp() == null ? "1" : event.getChargeTp();
			strCntr = event.getContainerTp().equals("") || event.getContainerTp() == null ? "1" : event.getContainerTp();
			
			eventResponse.setETCData("rider_only_yn", command2.searchRiderYn(strBkgNo, strHData, strRate, strCntr, strCorrNo));
			eventResponse.setETCData("nvocc_only_yn", command2.searchHouseBlYn(event.getBkgNo()));
			eventResponse.setETCData("obl_rlse_flg", command2.searchOblRlseFlg(event.getBkgNo(), strCorrNo));
			
			//C/A NO
			List<BkgCorrectionVO> list2 = command.searchUserPrintSetup2(event.getBkgNo(),account);
			eventResponse.setRsVoList(list2);
			
			//B/L Type
	        List<BkgComboVO> list3 = command3.searchCombo("CD02381");
	        eventResponse.setRsVoList(list3);
	        //Charge Type
	        list3 = command3.searchCombo("CD02385");
	        eventResponse.setRsVoList(list3);
	        //Container Type
	        list3 = command3.searchCombo("CD02384");
	        eventResponse.setRsVoList(list3);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg0743Event retrieve event process<br>
	 * UserPrintSetup3 List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchUserPrintSetup3(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0743Event event = (EsmBkg0743Event)e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	UserSetupMgtBC command = new UserSetupMgtBCImpl();
        BookingUtil command3 = new BookingUtil();
    	
		try {
			List<BkgUsrDfltSetVO> list = command.searchUserPrintSetup4(event.getInfoVO());
			if(list.size() > 0){
				eventResponse.setETCData("bl_prn_setup", list.get(0).getBlPrnSetup());
				eventResponse.setETCData("bl_prn_chg_tp_cd", list.get(0).getBlPrnChgTpCd());
			}else{
				eventResponse.setETCData("bl_prn_setup", "");
				eventResponse.setETCData("bl_prn_chg_tp_cd", "");
			}
			
			//B/L retrieve print option 
			List<BkgUsrDfltSetVO> list2 = command.searchUserPrintSetup3(event.getInfoVO());
			if(list2.size() > 0){
				eventResponse.setETCData("conti_cd",  list2.get(0).getContiCd());
			}
			eventResponse.setRsVoList(list2);
			
			//B/L Type
	        List<BkgComboVO> list3 = command3.searchCombo("CD02381");
	        eventResponse.setRsVoList(list3);
	        //Charge Type
	        list3 = command3.searchCombo("CD02385");
	        eventResponse.setRsVoList(list3);
	        //Container Type
	        list3 = command3.searchCombo("CD02384");
	        eventResponse.setRsVoList(list3);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * EsmBkg0743Event retrieve event process<br>
	 * HouseBlRirderBl List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchHouseBlRirderBl(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0743Event event = (EsmBkg0743Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command2 = new BLIssuanceBCImpl();
		
		String strBkgNo = "";
		String strCorrNo = "";
		String strRate = "";
		String strCntr = "";
		String strHData = "";
		
		try {
			strBkgNo = event.getBkgNo();
			strCorrNo = event.getCorrNo() == null ? "" : event.getCorrNo();
			strHData = event.getHiddenData().equals("") || event.getHiddenData() == null ? "N" : event.getHiddenData();
			strRate = event.getChargeTp().equals("") || event.getChargeTp() == null ? "1" : event.getChargeTp();
			strCntr = event.getContainerTp().equals("") || event.getContainerTp() == null ? "1" : event.getContainerTp();
			
			eventResponse.setETCData("rider_only_yn", command2.searchRiderYn(strBkgNo, strHData, strRate, strCntr, strCorrNo));
			eventResponse.setETCData("nvocc_only_yn", command2.searchHouseBlYn(event.getBkgNo()));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
    
	/**
	 * EsmBkg0064Event retrieve event process<br>
	 * UserPrintSetup0064 List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchUserPrintSetup0064(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0064Event event = (EsmBkg0064Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		
		try {
			List<BkgUsrDfltSetVO> list = command.searchUserPrintSetup(event.getInfoVO(),account);
			if(list.size() > 0){
				eventResponse.setETCData("bl_face_prn_dvc_nm", list.get(0).getBlFacePrnDvcNm());
				eventResponse.setETCData("bl_ridr_prn_dvc_nm", list.get(0).getBlRidrPrnDvcNm());
				eventResponse.setETCData("bl_prn_dvc_nm", list.get(0).getBlPrnDvcNm());
			}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	    
	
	
	/**
	 * EsmBkg0743Event management event process<br>
	 * UserPrintSetup management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUserPrintSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0743Event event = (EsmBkg0743Event)e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		try{
			BkgUsrDfltSetVO bkgUsrDfltSetVO = event.getInfoVO();
			begin();
			command.manageUserPrintSetup(bkgUsrDfltSetVO,account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			eventResponse.setETCData("success_yn"      ,  "Y");
		
		} catch(EventException ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EsmBkg0743Event modify event process<br>
	 * OBLRlseFlg List modify<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse modifyOBLRlseFlg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0743Event event = (EsmBkg0743Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		
		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		String uiId = "ESM_BKG_0743";
		
		try{
			
			BlIssInfoVO blIssInfoVO = event.getInfoVO2();
			begin();
						
			/* search old history */
			bkgBlNoVO.setBkgNo(blIssInfoVO.getBkgNo());
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			command.modifyOBLRlseFlg(blIssInfoVO);
			
			/* create history */
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		} catch(EventException ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		
		return eventResponse;
	}
	
	
	/**
	 * EsmBkg0743Event modify event process<br>
	 * WBL_PRN_FLG modify<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse modifyWaybillFlg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0743Event event = (EsmBkg0743Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		
		/* History Setup */
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		String uiId = "ESM_BKG_0743";
		
		try{
			
			BlIssInfoVO blIssInfoVO = event.getInfoVO2();
			begin();
						
			command.modifyWaybillFlg(blIssInfoVO, "P", account);//E:Email, P:Print
			
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(blIssInfoVO.getBkgNo());
			historyLineVO.setCaFlg("N");
			historyLineVO.setBkgDocProcTpCd("");
			historyLineVO.setUiId(uiId);
			historyLineVO.setCrntCtnt("PRINTED");
			historyLineVO.setHisCateNm("SWB B/L PRINT");
			bookingHistoryMgtBC.createBkgHistoryLine(historyLineVO, account);
			
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		} catch(EventException ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		
		return eventResponse;
	}	
	
	/**
	 * EsmBkg1060Event retrieve event process<br>
	 * ChnMnlBkgNoGen List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchChnMnlWithBkgNoGenList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg1060Event event = (EsmBkg1060Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = event.getChnMnlBkgNoGenCondVO();
		
		try {
			List<BkgChnBkgNoGenVO> list = command.searchChnMnlBkgNoGenList(chnMnlBkgNoGenCondVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler(ex).getUserMessage(),ex);
		}
		
	}

	/**
	 * EsmBkg3008Event retrieve event process<br>
	 * ChnMnlBkgNoGen List retrieve<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchChnMnlWithoutBkgNoGenList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg3008Event event = (EsmBkg3008Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = event.getChnMnlBkgNoGenCondVO();
		
		try {
			List<BkgChnBkgNoGenVO> list = command.searchChnMnlBkgNoGenList(chnMnlBkgNoGenCondVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler(ex).getUserMessage(),ex);
		}
		
	}

	/**
	 * EsmBkg0922Event retrieve event process<br>
	 * OfficeDetail List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchOfficeDetail(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0922Event event = (EsmBkg0922Event)e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	
		try {
			List<MdmOrganizationVO> list = command.searchOfficeDetail(event.getOfcCd(),account);
			if(list.size() > 0){
				eventResponse.setETCData("eng_nm", list.get(0).getOfcEngNm());
				eventResponse.setETCData("address", list.get(0).getOfcAddr());
				eventResponse.setETCData("country", list.get(0).getLocCd());
				eventResponse.setETCData("phone_no", list.get(0).getOfcPhnNo());
				eventResponse.setETCData("fax_no", list.get(0).getOfcFaxNo());
			}else{
				eventResponse.setETCData("eng_nm", "");
				eventResponse.setETCData("address", "");
				eventResponse.setETCData("country", "");
				eventResponse.setETCData("phone_no", "");
				eventResponse.setETCData("fax_no", "");
			}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	     

	/**
	 * Edi0050001Event receive event process<br>
	 * BKG_EDI_TRD_PRNR_SUB_LNK receive<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveBkgEdiTrdPrnrSubLnk(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		Edi0050001Event event = null;
		BookingMasterMgtBC command = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (Edi0050001Event)e;
			command = new BookingMasterMgtBCImpl();
			begin();
			command.receiveBkgEdiTrdPrnrSubLnk(event.getMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Edi0060001Event receive event process<br>
	 * BKG_EDI_SUB_LNK_MSG receive<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveBkgEdiSubLnkMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		Edi0060001Event event = null;
		BookingMasterMgtBC command = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (Edi0060001Event)e;
			command = new BookingMasterMgtBCImpl();
			begin();
			command.receiveBkgEdiSubLnkMsg(event.getMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Edi0070001Event receive event process<br>
	 * BKG_EDI_PRNR_PORT_LANE receive<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveBkgEdiPrnrPortLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		Edi0070001Event event = null;
		BookingMasterMgtBC command = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (Edi0070001Event)e;
			command = new BookingMasterMgtBCImpl();
			begin();
			command.receiveBkgEdiPrnrPortLane(event.getMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkg1060Event create event process<br>
	 * ChnMnlBkgNoGen List create<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse createChnMnlWithBkgNoGenList(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkg1060Event event = null;
		BookingMasterMgtBC command = null;
		ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (EsmBkg1060Event)e;
			chnMnlBkgNoGenCondVO = event.getChnMnlBkgNoGenCondVO();
			command = new BookingMasterMgtBCImpl();
			String mnlBkgNoOptCd = command.searchOfcCheck(chnMnlBkgNoGenCondVO.getCreOfcCd());
			if(mnlBkgNoOptCd.equalsIgnoreCase("A")){
				begin();
				List<BkgChnBkgNoGenVO> list = command.createChnMnlBkgNoGenList(chnMnlBkgNoGenCondVO, getSignOnUserAccount());
				eventResponse = new GeneralEventResponse();
				eventResponse.setRsVoList(list);
				commit();
			}else{
				eventResponse.setETCData("MNL_BKG_NO_OPT_CD", mnlBkgNoOptCd);
			}
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg3008Event create event process<br>
	 * ChnMnlBkgNoGen List create<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse createChnMnlWithoutBkgNoGenList(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkg3008Event event = null;
		BookingMasterMgtBC command = null;
		ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (EsmBkg3008Event)e;
			chnMnlBkgNoGenCondVO = event.getChnMnlBkgNoGenCondVO();
			command = new BookingMasterMgtBCImpl();
			
			String mnlBkgNoOptCd = command.searchOfcCheck(chnMnlBkgNoGenCondVO.getCreOfcCd());
			if(mnlBkgNoOptCd.equalsIgnoreCase("O")){
				begin();
				List<BkgChnBkgNoGenVO> list = command.createChnMnlBkgNoGenList(chnMnlBkgNoGenCondVO, getSignOnUserAccount());
				eventResponse = new GeneralEventResponse();
				eventResponse.setRsVoList(list);
				commit();
			}else{
				eventResponse.setETCData("MNL_BKG_NO_OPT_CD", mnlBkgNoOptCd);
			}
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * UserSetupMgt retrieve event process<br>
	 * Combo List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchCombo(Event e) throws EventException {
        //
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        UserSetupMgtBC command = new UserSetupMgtBCImpl();
//        
//        try {
//            // measure unit, CD01116
//            List<BkgComboVO> ofc_cds = command.searchOfcCd();
//            //
//            eventResponse.setCustomData("ofc_cds", ofc_cds);
//        } catch (EventException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
//        }
        return eventResponse;
    }        

	/**
	 * EsmBkg1075Event retrieve event process<br>
	 * RptItmStup List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchRptItmStup(Event e) throws EventException {
        //
        EsmBkg1075Event event = (EsmBkg1075Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        String ofcCd = event.getOfcCd();
        String custCd = event.getCustCd();
        
        try {
            // search
            List<RptItmStupVO> list = command.searchRptItmStup(ofcCd, custCd);
            // set VOs
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }        

	/**
	 * EsmBkg1075Event management event process<br>
	 * BKG_EDI_TRD_PRNR_SUB_LNK management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageRptItmStup(Event e) throws EventException {
        //
        EsmBkg1075Event event = (EsmBkg1075Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        RptItmStupVO[] rptItmStupVOs = event.getRptItmStupVOs();

        try {
            begin();
            command.manageRptItmStup(rptItmStupVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * BookingUtil retrieve event process<br>
	 * MdmCnt List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchMdmCnt(Event e) throws EventException {
    	
      	BookingUtil command = new BookingUtil();
      	
		try {
			List<MdmCountryVO> list = command.searchMdmCnt();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
       
    }   
    
	/**
	 * EsmBkg1114Event retrieve event process<br>
	 * ZipCode List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchZipCode(Event e) throws EventException {
        EsmBkg1114Event event = (EsmBkg1114Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<ZipCdListVO> list = command.searchZipCode(event.getZipCdSchVO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    } 
    
	/**
	 * EsmBkg1114Event management event process<br>
	 * ZipCode List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse manageZipCode(Event e) throws EventException {
    	EsmBkg1114Event event = (EsmBkg1114Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageZipCode(event.getZipCdListVOS(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }   
    private EventResponse searchHrdCdgDesc(Event e) throws EventException {
        EsmBkg2004Event event = (EsmBkg2004Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<BkgHrdCdgDescVO> list = command.searchHrdCdgDesc(event.getBkgHrdCdgDescVO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    } 
    
	/**
	 * EsmBkg2004Event management event process<br>
	 * HrdCdgDesc List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageHrdCdgDesc(Event e) throws EventException {
    	EsmBkg2004Event event = (EsmBkg2004Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageHrdCdgDesc(event.getBkgHrdCdgDescVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }   
    
    
	/**
	 * EsmBkg2005Event retrieve event process<br>
	 * HrdCdgCtnt List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchHrdCdgCtnt(Event e) throws EventException {
        EsmBkg2005Event event = (EsmBkg2005Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<BkgHrdCdgCtntVO> list = command.searchHrdCdgCtnt(event.getBkgHrdCdgCtntVO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }  
    
	/**
	 * EsmBkg2005Event management event process<br>
	 * HrdCdgCtnt List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse manageHrdCdgCtnt(Event e) throws EventException {
    	EsmBkg2005Event event = (EsmBkg2005Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageHrdCdgCtnt(event.getBkgHrdCdgCtntVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 
    
	/**
	 * EsmBkg2004Event management event process<br>
	 * HrdCdgId List management<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkHrdCdgId(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2004Event event = (EsmBkg2004Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		String frmHrdCdgId = null;
		String hrd_id_cnt = null;
		
		try{

			frmHrdCdgId = event.getBkgHrdCdgDescVO().getFrmHrdCdgId();
			hrd_id_cnt = command.checkHrdCdgId(frmHrdCdgId);
			eventResponse.setETCData("hrd_id_cnt", hrd_id_cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**check if there is data on Hard coding contents
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkChildCnt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2004Event event = (EsmBkg2004Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		String hrdCdgId = null;
		String child_cnt = null;
		
		try{

			hrdCdgId = event.getBkgHrdCdgDescVO().getFrmHrdCdgId();
			child_cnt = command.checkChildCnt(hrdCdgId);
			eventResponse.setETCData("child_cnt", child_cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg0154Event<br>
	 * @param e EsmBkg0154Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserInternetAuth(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0320Event event = (EsmBkg0320Event)e;
		UserSetupMgtBC command = null;
		List<BkgInternetAuthorityVO> list = null;
		try {
			command = new UserSetupMgtBCImpl();
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				event.getInfoVO().setIbflag("R"); 
				list = command.searchUserInternetAuth(event.getInfoVO());
				eventResponse.setRsVoList(list);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		event.getInfoVO().setIbflag("R2");
	    		list = command.searchUserInternetAuth(event.getInfoVO());
	    		if(list.size() > 0){
	    			BkgInternetAuthorityVO vo =  list.get(0);
	        		eventResponse.setETCData("search_usr_nm", vo.getUsrNm());
	        		eventResponse.setETCData("search_ofc_cd", vo.getOfcCd());
	        	}
	    	}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BkgInternetAuthorityVO event에 대한 멀티 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUserInternetAuth(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0320Event event = (EsmBkg0320Event)e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		try {
			begin();
			command.manageUserInternetAuth(event.getInfoVOs(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("EVENTEXCEPTION... " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchYardDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = null;
		String ydNm = null;
		try {
			command = new CustomsMasterMgtBCImpl();
			ydNm = command.searchYardDesc(event.getInfoVO());
			if( ydNm != null ){
	    		eventResponse.setETCData("YD_DESC",ydNm);
	    	}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLocDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = null;
		String locNm = null;
		try {
			command = new CustomsMasterMgtBCImpl();
			locNm = command.searchLocDesc(event.getInfoVO());
			if( locNm != null ){
	    		eventResponse.setETCData("LOC_DESC",locNm);
	    	}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_3001 : IBSEARCH searching Controlling Party, Internet BL Control Party, BL Group
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchControllingPartyList(Event e) throws EventException {
		log.debug("START SEARCH====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3001Event event =(EsmBkg3001Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();

		try {
			List<BkgCtrlPtyVO> list 		= command.searchControllingPartyList(event.getBkgCtrlPtyVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	/**
	 * ESM_BKG_3001 : IBSEARCH searching Controlling Party, Internet BL Control Party, BL Group
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchInernettBlControlPartyList(Event e) throws EventException {
		log.debug("START SEARCH01====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3001Event event =(EsmBkg3001Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();

		try {
			List<BkgInetBlCtrlPtyVO> list 	= command.searchInernettBlControlPartyList(event.getBkgCtrlPtyVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * ESM_BKG_3001 : IBSEARCH searching Controlling Party, Internet BL Control Party, BL Group
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBlGroupList(Event e) throws EventException {
		log.debug("START SEARCH02====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3001Event event =(EsmBkg3001Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		UserSetupMgtBC userSetupMgtBC = new UserSetupMgtBCImpl();
		List<BkgInternetAuthorityVO> listAuthroity = null;
		try {
			List<BkgCtrlPtyBlGrpVO> list 	= command.searchBlGroupList(event.getBkgCtrlPtyVO());
			BkgInternetAuthorityVO bkgInternetAuthorityVO = new BkgInternetAuthorityVO();
			bkgInternetAuthorityVO.setUsrId(account.getUsr_id());
			bkgInternetAuthorityVO.setIbflag("R");
			listAuthroity = userSetupMgtBC.searchUserInternetAuth(bkgInternetAuthorityVO);
			if(listAuthroity != null && listAuthroity.size()>0){
				eventResponse.setETCData("INET_FTP_AUTH_FLG", listAuthroity.get(0).getInetFtpAuthFlg());
			}else{
				eventResponse.setETCData("INET_FTP_AUTH_FLG", "");
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * ESM_BKG_3001 : IBSAVE save Controlling Party, Internet BL Control Party, BL Group
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageControllingParty(Event e) throws EventException {
		log.debug("START SAVE====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3001Event event =(EsmBkg3001Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		BkgCtrlPtyVO[] bkgCntrlPtyVOs 			= event.getBkgCtrlPtyVOs();
		BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs= event.getBkgInetBlCtrlPtyVOs();			
		BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs 	= event.getBkgCtrlPtyBlGrpVOs();

		try {
            begin();
			command.manageControllingParty(bkgCntrlPtyVOs, bkgInetBlCtrlPtyVOs, bkgCtrlPtyBlGrpVOs, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}			
	
	/**
	 * ESM_BKG_3002, ESM_BKG_3003 : IBSEARCH searching BL CTRL BL GRoup, Internet BL Control Party, BL Group
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBlGroupMasterList(Event e) throws EventException {
		log.debug("START SEARCH====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try {
//			List<BkgCtrlBlGrpVO> list 		= null;

			if(e instanceof EsmBkg3002Event){
				List<BkgCtrlBlGrpVO> list 		= command.searchBlGroupMasterList(((EsmBkg3002Event)e).getBkgCtrlBlGrpVO());
				eventResponse.setRsVoList(list);
			}else if(e instanceof EsmBkg3003Event){
				List<BkgCtrlBlGrpVO> list 		= command.searchBlGroupMasterList(((EsmBkg3003Event)e).getBkgCtrlBlGrpVO());
				eventResponse.setRsVoList(list);
			}
//			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * ESM_BKG_3001 : IBDELETE delete Controlling Party
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeControllingParty(Event e) throws EventException {
		log.debug("START removeControllingParty====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3001Event event =(EsmBkg3001Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		BkgCtrlPtyVO[] bkgCntrlPtyVOs 			= event.getBkgCtrlPtyVOs();

		try {
            begin();
			command.removeControllingParty(bkgCntrlPtyVOs);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3001 : IBDELETE delete Internet B/L Control
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeInernettBlControlParty(Event e) throws EventException {
		log.debug("START removeInernettBlControlParty====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3001Event event =(EsmBkg3001Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		BkgInetBlCtrlPtyVO[] bkgInetBlCtrlPtyVOs 			= event.getBkgInetBlCtrlPtyVOs();

		try {
            begin();
			command.removeInernettBlControlParty(bkgInetBlCtrlPtyVOs);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3001 : IBDELETE delete BL Group
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeBlGroup(Event e) throws EventException {
		log.debug("START removeBlGroup====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3001Event event =(EsmBkg3001Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		BkgCtrlPtyBlGrpVO[] bkgCtrlPtyBlGrpVOs 			= event.getBkgCtrlPtyBlGrpVOs();

		try {
            begin();
			command.removeBlGroup(bkgCtrlPtyBlGrpVOs);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	private EventResponse selectMaxCntrPtySeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try {
			String maxCntrPtySeq = command.selectMaxCntrPtySeq();
			eventResponse.setETCData("ctrl_pty_seq", maxCntrPtySeq);
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * ESM_BKG_3002 : IBSEARCH01 searching BL Customer
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBlGroupCustomerList(Event e) throws EventException {
		log.debug("START SEARCH====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3002Event event =(EsmBkg3002Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		BkgCtrlBlGrpVO bkgCtrlBlGrpVO 		= event.getBkgCtrlBlGrpVO();
		try {
			List<BkgCtrlBlGrpCustVO> list	= command.searchBlGroupCustomerList(bkgCtrlBlGrpVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	private EventResponse manageBlGroup(Event e) throws EventException {
		log.debug("START SAVE====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3002Event event =(EsmBkg3002Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		BkgCtrlBlGrpVO[] bkgCntrlPtyVOs 		= event.getBkgCtrlBlGrpVOs();
		BkgCtrlBlGrpCustVO[] bkgInetBlCtrlPtyVOs= event.getBkgCtrlBlGrpCustVOs();			

		try {
            begin();
			command.manageBlGroup(bkgCntrlPtyVOs, bkgInetBlCtrlPtyVOs, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	private EventResponse selectMaxBlGroupSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try {
			String seq = command.selectMaxBlGroupSeq();
			eventResponse.setETCData("bl_grp_seq", seq);
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	private EventResponse removeBlGroupMaster(Event e) throws EventException {
		log.debug("START removeBlGroupMaster====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3002Event event =(EsmBkg3002Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		BkgCtrlBlGrpVO[] bkgCtrlBlGrpVOs = event.getBkgCtrlBlGrpVOs();

		try {
            begin();
			command.removeBlGroupMaster(bkgCtrlBlGrpVOs);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	private EventResponse removeBlGroupCustomer(Event e) throws EventException {
		log.debug("START removeBlGroupCustomer====");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3002Event event =(EsmBkg3002Event) e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		BkgCtrlBlGrpCustVO[] bkgCtrlBlGrpCustVOs = event.getBkgCtrlBlGrpCustVOs();

		try {
            begin();
			command.removeBlGroupCustomer(bkgCtrlBlGrpCustVOs);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3005 : Search B/L eSignature List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBlESignatureList(Event e) throws EventException {
		log.debug("===============START searchBlESignatureList");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3005Event event =(EsmBkg3005Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();

		try {
			List<BlESignatureVO> list = command.searchBlESignatureList(event.getCountryCode(), event.getESignatureLastNm());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3005 : Search B/L eSignature
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBlESignature(Event e) throws EventException {
		log.debug("===============START searchBlESignature");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3100Event event =(EsmBkg3100Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();

		try {
			List<BlESignatureVO> list = command.searchBlESignature(event.getBlESignatureVO().getBlEsigSeq());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3100 -> File Attach : Add <br>
	 * search attached eSignature File Key<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAttachFileKey(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg3100Event")) {
				EsmBkg3100Event event = (EsmBkg3100Event) e;				
				eventResponse.setETCData("fileKey", event.getKeys().get(0));
				log.debug("========================fileAttachInfo: " + event);
				log.debug("========================fileAttachInfo: " + event.getKeys().get(0));
			} 
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3100 -> File Attach : Add <br>
	 * add attached eSignature File Key<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addBlESignature(Event e) throws EventException {
		log.debug("===============START addBlESignature");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3100Event event =(EsmBkg3100Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		
		BlESignatureVO blESignatureVO = event.getBlESignatureVO();			

		try {
            begin();
			command.addBlESignature(blESignatureVO, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3100 -> update eSignature <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBlESignature(Event e) throws EventException {
		log.debug("===============START modifyBlESignature");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3100Event event =(EsmBkg3100Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		
		BlESignatureVO blESignatureVO = event.getBlESignatureVO();			

		try {
            begin();
			command.modifyBlESignature(blESignatureVO, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3100 -> File Attach : Remove <br>
	 * remove attached eSignature File Key<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeBlESignature(Event e) throws EventException {
		log.debug("===============START removeBlESignature");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3005Event event =(EsmBkg3005Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();			

		try {
            begin();
			command.removeBlESignature(event.getBlEsigSeq());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3011 : Search Place of issue association List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author 9014750
	 */
	private EventResponse searchPlaceOfIssueAssociationList(Event e) throws EventException {
		log.debug("===============START searchPlaceOfIssueAssociationList");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3011Event event =(EsmBkg3011Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();

		try {
			List<PlaceOfIssueAssociationVO> list = command.searchPlaceOfIssueAssociationList(event.getCountryCode(), event.getBlIssOfcNm());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse searchOfcCdCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3012Event event =(EsmBkg3012Event) e;
		BookingUtil command = new BookingUtil();

		try {
			/* MDM Code 가 존재하는지 체크 */
			MdmOrganizationVO vo = command.searchMdmOrzByOfcCd(event.getPlaceOfIssueAssociationVO().getBlIssOfcCd());
			if(vo == null){	// data가 존재하지 않으면 에러 처리함.(bc_test 에러처리)
				throw new Exception("MDM Code Check Fail...");
			}
			
			eventResponse.setRsVo(vo);
			eventResponse.setETCData("OfcCd", vo.getOfcCd());
			
			/* MDM Code 중복 체크 [ 중복일 경우 오류 발생 ] */
			int count = command.checkMdmOrzByOfcCd(event.getPlaceOfIssueAssociationVO().getBlIssOfcCd());
			if(count > 0){
				throw new Exception("MDM Code Check Fail...");
			}
			
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_3011 -> Remove Place of issue association <br>
	 * remove Place of issue association<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 9014750
	 */
	private EventResponse removePlaceOfIssueAssociation(Event e) throws EventException {
		log.debug("===============START removePlaceOfIssueAssociation");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3011Event event =(EsmBkg3011Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();			

		try {
            begin();
			command.removePlaceOfIssueAssociation(event.getBlEsigAsgnSeq());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_3012 : Search Place of issue association popup
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author 9014750
	 */
	private EventResponse searchPlaceOfIssueAssociation(Event e) throws EventException {
		log.debug("===============START searchPlaceOfIssueAssociation");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3012Event event =(EsmBkg3012Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();

		try {
			List<PlaceOfIssueAssociationVO> list = command.searchPlaceOfIssueAssociation(event.getPlaceOfIssueAssociationVO().getBlEsigAsgnSeq());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * ESM_BKG_3012 -> Add Place of issue association popup <br>
	 * add Place of issue association popups<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 9014750
	 */
	private EventResponse addPlaceOfIssueAssociation(Event e) throws EventException {
		log.debug("===============START addPlaceOfIssueAssociation");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3012Event event =(EsmBkg3012Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		
		PlaceOfIssueAssociationVO placeOfIssueAssociationVO = event.getPlaceOfIssueAssociationVO();			

		try {
            begin();
			command.addPlaceOfIssueAssociation(placeOfIssueAssociationVO, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3012 -> update Place of issue association popup <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 9014750
	 */
	private EventResponse modifyPlaceOfIssueAssociation(Event e) throws EventException {
		log.debug("===============START modifyPlaceOfIssueAssociation");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3012Event event =(EsmBkg3012Event) e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		
		PlaceOfIssueAssociationVO placeOfIssueAssociationVO = event.getPlaceOfIssueAssociationVO();			

		try {
            begin();
			command.modifyPlaceOfIssueAssociation(placeOfIssueAssociationVO, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_3012 -> update Place of issue association popup<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author 9014750
	 */
   private EventResponse searchComBoCdList3012(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg3012Event event = (EsmBkg3012Event)e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		try {
			List<PlaceOfIssueAssociationVO> list = command.searchEmployeeList(event.getPlaceOfIssueAssociationVO());
			log.debug("======list :"+list);
			StringBuffer codes = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < list.size(); i++) {
					codes.append(list.get(i).getEmpCd()).append("=").append(list.get(i).getEmpNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			
			eventResponse.setETCData("EMP", codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
   }		

   /**
    * 1180 조회 이벤트 처리<br>
    * Handling Office 를 조회한다 <br>
    * @param e Event EsmBkg1180Event
    * @return response EventResponse
    * @exception EventException
    */
   private EventResponse searchHandlingOffice (Event e) throws EventException {
   	// PDTO(Data Transfer Object including Parameters)
   	EsmBkg1180Event event = (EsmBkg1180Event)e;
   	
   	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
   	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BkgHandlingOfficeSetupVO> list = command.searchHandlingOffice(event.getBkgHandlingOfficeSetupVO());
			if(list.size() > 0){
				eventResponse.setRsVoList(list);
				eventResponse.setETCData("SIZE", String.valueOf(list.size()));
			}
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
   }
   
   /**
    * BKG OFC, POL, POR 존재여부 체크
    * @param e
    * @return
    * @throws EventException
    */
   private EventResponse searchHandlingOfficeCheck (Event e) throws EventException {
	   	// PDTO(Data Transfer Object including Parameters)
	   	EsmBkg1180Event event = (EsmBkg1180Event)e;
	    BookingUtil command = new BookingUtil();
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO = event.getBkgHandlingOfficeSetupVO();
		try {
			/* BKG OFC 체크 */
			if(bkgHandlingOfficeSetupVO.getVelType().equalsIgnoreCase("OFCCD")){
				MdmOrganizationVO vo = command.searchMdmOrzByOfcCd(bkgHandlingOfficeSetupVO.getVelData());
				eventResponse.setRsVo(vo);
				eventResponse.setETCData("OfcCd", vo.getOfcCd());
			}
			else if(bkgHandlingOfficeSetupVO.getVelType().equalsIgnoreCase("POLCD") || bkgHandlingOfficeSetupVO.getVelType().equalsIgnoreCase("PORCD")){
				SearchLocationCodeVO vo = command.searchLocationCode(bkgHandlingOfficeSetupVO.getVelData());
				eventResponse.setRsVo(vo);
				eventResponse.setETCData("OfcCd", vo.getLocCd());
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
   
   /**
    * 
    * @param e
    * @return
    * @throws EventException
    */
   	private EventResponse searchCustCntCdCheck (Event e) throws EventException {
	   	// PDTO(Data Transfer Object including Parameters)
	   	EsmBkg1180Event event = (EsmBkg1180Event)e;
	    BookingUtil command = new BookingUtil();
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO = event.getBkgHandlingOfficeSetupVO();
		try {
			MdmCountryVO countryVO = command.searchCountryCode(bkgHandlingOfficeSetupVO.getVtCustCntCd());
			eventResponse.setRsVo(countryVO);
			eventResponse.setETCData("vt_cust_cnt_cd", countryVO.getCntCd());
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
  
   
	/**
    * 1180 저장 이벤트 처리<br>
    * Handling Office 를 조회한다 <br>
    * @param e Event EsmBkg1180Event
    * @return response EventResponse
    * @exception EventException
	 */
	private EventResponse manageHandlingOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		EsmBkg1180Event event = (EsmBkg1180Event)e;
		BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOs = event.getBkgHandlingOfficeSetupVOS();
		try{
			begin();
			command.manageHandlingOffice(bkgHandlingOfficeSetupVOs, account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
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
	 * EsmBkg2004SEQEvent management event process<br>
	 * HrdCdgDesc List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHrdCdgDesc2(Event e) throws EventException {
        EsmBkg200401Event event = (EsmBkg200401Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<HrdCdgDesc2VO> list = command.searchHrdCdgDesc2(event.getHrdCdgDesc2VO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
	/**
	 * EsmBkg2005SEQEvent retrieve event process<br>
	 * HrdCdgCtnt List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchHrdCdgCtnt2(Event e) throws EventException {
        EsmBkg200501Event event = (EsmBkg200501Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<HrdCdgCtnt2VO> list = command.searchHrdCdgCtnt2(event.getHrdCdgCtnt2VO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }  
    
    /**
	 * EsmBkg2005SEQEvent management event process<br>
	 * HrdCdgCtnt List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse manageHrdCdgCtnt2(Event e) throws EventException {
    	EsmBkg200501Event event = (EsmBkg200501Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageHrdCdgCtnt(event.getHrdCdgCtnt2VOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 

	/**
	 * EsmBkg1606Event retrieve event process<br>
	 * Country Clause List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchBlCluzStup(Event e) throws EventException {
        //
        EsmBkg1606Event event = (EsmBkg1606Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        String orgCntCd = event.getOrgCntCd();
        
        try {
            // search
            List<BlCluzStupVO> list = command.searchBlCluzStup(orgCntCd);
            // set VOs
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }        

	/**
	 * EsmBkg1606Event management event process<br>
	 * Country Clause management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageBlCluzStup(Event e) throws EventException {
        //
        EsmBkg1606Event event = (EsmBkg1606Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        BlCluzStupVO[] blCluzStupVOs = event.getBlCluzStupVOs();

        try {
            begin();
            command.manageBlCluzStup(blCluzStupVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * EsmBkg0743Event OBL Print event process<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse createOBL(Event e) throws EventException {
    	GeneralEventResponse eventResponse = null;
		BLIssuanceBC command = null;
		String fileKey = null;
		EsmBkg0743Event event = (EsmBkg0743Event) e;
		BookingUtil bookingUtil = new BookingUtil();
    	try {
    		begin();
    		eventResponse = new GeneralEventResponse();
    		command = new BLIssuanceBCImpl();
    		
    		String blNo = event.getInfoVO().getBlNo();
    		String bkgNo = event.getInfoVO().getBkgNo();
    		if(blNo.length() > 12) blNo = blNo.substring(0, 12);	
    		String caYn = event.getCaYn();
    		
    		String[] arrMrdFiles = event.getMrdFiles();
    		String[] arrMrdParams = event.getMrdParams();
    		
    		String blPrnFlg ="N";
    		blPrnFlg = bookingUtil.searchBlPrnFlg(event.getInfoVO());
    		
			if (null != event.getInfoVO() && "Y".equals(blPrnFlg)) {
				throw new EventException(new ErrorHandler("BKG08091", new String[]{event.getBkgNo()}).getMessage());
			}
    		
    		fileKey = command.createOBL(bkgNo, blNo, caYn, arrMrdFiles, arrMrdParams, account);
    		eventResponse.setETCData("FILE_KEY", fileKey);
    		commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	    	rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
	/**
	 * EsmBkg0743Event Group OBL Print event process<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse createGBOBL(Event e) throws EventException {
    	GeneralEventResponse eventResponse = null;
		BLIssuanceBC command = null;
		String fileKey = null;
		EsmBkg0743Event event = (EsmBkg0743Event) e;
		
    	try {
    		begin();
    		eventResponse = new GeneralEventResponse();
    		command = new BLIssuanceBCImpl();
    		
//    		String blNo = event.getInfoVO().getBlNo();
//    		String bkgNo = event.getInfoVO().getBkgNo();
    		
    		String[] arrBkgNos = event.getPBkgNo();
    		String[] arrBlNos = event.getPBlNo();
    		String caYn = event.getCaYn();
    		String formType = event.getFormType();
    		String[] arrMrdFiles = event.getMrdFiles();
    		String[] arrMrdParams = event.getMrdParams();
    		
    		
    		log.error("###### BookingMasterDataSC.createGBOBL Start");
    		long startTime = System.currentTimeMillis();
    		fileKey = command.createGBOBL(arrBkgNos, arrBlNos, caYn, formType, arrMrdFiles, arrMrdParams, account);    		
    		long estimatedTime = System.currentTimeMillis() - startTime;
    		
    		log.error("###### BookingMasterDataSC.createGBOBL Get File Key Complete : " + estimatedTime);
    		
    		eventResponse.setETCData("FILE_KEY", fileKey);
    		startTime = System.currentTimeMillis();
    		commit();
    		estimatedTime = System.currentTimeMillis() - startTime;
    		log.error("###### BookingMasterDataSC.createGBOBL Commit Complete : " + estimatedTime);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	    	rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
	/**
	 * EsmBkg0743Event OBL Print event process<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse downLoadOBL(Event e) throws EventException {
   	GeneralEventResponse eventResponse = null;
		BLIssuanceBC command = null;
		String jobId = null;
		EsmBkg0743Event event = (EsmBkg0743Event) e;
		
   	try {
   		begin();
   		eventResponse = new GeneralEventResponse();
   		command = new BLIssuanceBCImpl();
   		
   		String fileKey = event.getFileKey();
   		

   		jobId = command.downLoadOBL(fileKey, account);
   		eventResponse.setETCData("jobID", jobId);
   		commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	    	rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
   }
    
	/**
	 * EsmBkg0743Event searchDownLoadOBLBackEndJobStatus BackEndJob <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchDownLoadOBLBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = null;
    	DBRowSet rowSet = null;
    	EsmBkg0743Event event = (EsmBkg0743Event) e;
		String key = null;
		String jobStsFlg = "";
		
    	try {    		
    		eventResponse = new GeneralEventResponse();
    		key = event.getKey();
			log.debug("searchDownLoadOBLBackEndJobStatus BackEndJobKey==>"+key);
    		if (null != key && !"".equals(key)) {
		    	backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(key);
		    	rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	
		    	while(rowSet.next())
				{
		    		jobStsFlg = rowSet.getString("JB_STS_FLG");
					log.debug("searchDownLoadOBLBackEndJobStatus jobStsFlg==>"+jobStsFlg);
		    		if ("4".equals(rowSet.getString("JB_STS_FLG")))
					{
						if (!"".equals(rowSet.getString("JB_ERR_MSG"))) {
							StringTokenizer st = new StringTokenizer(rowSet.getString("JB_ERR_MSG"), "<||>");
							st.nextToken();
							st.nextToken();
							st.nextToken();
							String strErrMsg = st.nextToken();
							eventResponse.setUserMessage(strErrMsg);
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00205").getUserMessage());
						}
					}
				}
		    	eventResponse.setETCData("JB_STS_FLG", jobStsFlg);
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
    	return eventResponse;
    }    

	/**
	 * EsmBkg0743Event BackEndJob Result<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchDownLoadOBLBackEndJobResult(Event e) throws EventException{
		GeneralEventResponse eventResponse = null;
		BLIssuanceBC command = null;
		String result = null;
		EsmBkg0743Event event = (EsmBkg0743Event) e;
		String key = null;
		try{
    		key = event.getKey();
			eventResponse = new GeneralEventResponse();
			command = new BLIssuanceBCImpl();
			log.debug("searchDownLoadOBLBackEndJobResult BackEndJobKey==>"+key);
			result = command.searchDownLoadOBLBackEndJobResult(key);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}	

}
