/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_ENS_0U1.js
*@FileTitle  : Approval
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;

document.onclick=processButtonClick;
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_Retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_New":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
    	            //doActionBtnEnable('S');
        	        break;
        	    //달력    
	 			case "btns_Calendar2" :		// Agreement Date (To Date)
 	    		var cal=new ComCalendarFromTo();
	            cal.select(formObject.sdate,  formObject.edate,  'yyyy-MM-dd');
 	    		break;   
        	    case "btn_Detail":
                	if(sheetObject.RowCount()==0){
                		ComShowCodeMessage( "COM130401");
                		return;                		
                	}
        	        var selRow=sheetObject.GetSelectRow();
        	        if(selRow < 1) {
        	            ComShowMessage(ComGetMsg("COM12176"));
        	            return;
        	        }
        	        var v_csr_no=sheetObject.GetCellValue(selRow, "csr_no");
        	        var height=screen.height; 
                	var width=screen.width;
                	var url="";
                	var subSysCd=sheetObject.GetCellValue(selRow, "sub_sys_cd");
	                if(subSysCd == "AGT") {
	                    var param="?csr_no=" + v_csr_no;
	                    ComOpenWindowCenter("ESM_AGT_0043.do" + param, "compop3", "700", "570", false);
	                } else if(subSysCd == "ACM") {
	                	var param="?csr_no=" + v_csr_no;
	                    ComOpenWindowCenter("ESM_AGT_0043.do" + param, "compop3", "700", "570", false);
	                }else if(subSysCd == "LSE" || subSysCd == "CHS" || subSysCd == "MGS" || subSysCd == "MNR" || subSysCd == "PSO" || subSysCd == "TLL" || subSysCd == "CNI" ) {
	                    var w=800;
	                    var h=560;
	                    var leftpos=width/2 - w/2; 
                    	var toppos=height/2 - h/2; 
                    	if(leftpos<0) leftpos=0;
                    	if(toppos<0) toppos=0;
						var csrNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'csr_no');
						var costOfcCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'cost_ofc_cd');
						var currCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'curr_cd');
						var invSubSysCd=sheetObject.GetCellValue(selRow, "sub_sys_cd");
						 //ComOpenWindow("/opuscntr/COM_CSR_0011.do?csr_no="+csrNo+"&cost_ofc_cd="+costOfcCd+"&inv_sub_sys_cd="+invSubSysCd+"&curr_cd="+currCd,  window,  "dialogWidth:820px; dialogHeight:510px; help:no; status:no; scroll:no; resizable:no;" , true);
						 ComOpenWindowCenter("/opuscntr/COM_CSR_0011.do?csr_no="+csrNo+"&cost_ofc_cd="+costOfcCd+"&inv_sub_sys_cd="+invSubSysCd+"&curr_cd="+currCd, window, 860, 420, true);
	                } else if(subSysCd == "TES") {
	                    var w=800;
	                    var h=560;
	                    var leftpos=width/2 - w/2; 
                    	var toppos=height/2 - h/2; 
                    	if(leftpos<0) leftpos=0;
                    	if(toppos<0) toppos=0;
	                    var url="/opuscntr/ESD_TES_0026.do?csr_no="+v_csr_no;
	                    window.open(url, "detailPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
	                 } else if(subSysCd == "TRS") {
	                     var url="/opuscntr/ESD_TRS_0960.do?mode=trs&csr_no="+v_csr_no;
	                     ComOpenWindowCenter(url, window, 855, 420, true);
	                 }
        	        break;
                case "btng_confirm":
//                	var selRow=sheetObject.GetSelectRow();
                	if(sheetObject.RowCount()==0){
                		ComShowCodeMessage( "COM130401");
                		return;                		
                	}
                	var sRow=sheetObject.FindCheckedRow("checkbox");
                	if(sRow == "") {
                		ComShowCodeMessage( "COM12176");
                		return;
                	}
                	//doActionBtnEnable('C');
	                doActionIBSheet(sheetObject,formObject,MULTI01);
        	        break;
        	    case "btng_reject":
                	if(sheetObject.RowCount()==0){
                		ComShowCodeMessage( "COM130401");
                		return;                		
                	}
                	var sRow=sheetObject.FindCheckedRow("checkbox");
                	if(sRow == "") {
                		ComShowCodeMessage( "COM12176");
                		return;
                	}
        	    	//doActionBtnEnable('C'); 
					var selRow=sheetObject.GetSelectRow();
                    doActionIBSheet(sheetObject,formObject,MULTI02);
        	        break;
        	    case "btng_viewapprovalstep":  
            	    var selRow=sheetObject.GetSelectRow();
            	    // [26/6/2014] @Dung.Nguyen
            	    // Content: Disable Code at line 86 87 88 below.
					// if(selRow < 1) {
					// ComShowMessage(ComGetMsg("COM12176"));
					// return;
					// }       	        }
        	        var height=screen.height; 
                	var width=screen.width;
      	            var w=615;
                    var h=280;
                    var leftpos=width/2 - w/2; 
                	var toppos=height/2 - h/2; 
                	if(leftpos<0) leftpos=0;
                	if(toppos<0) toppos=0;
                	var apro_rqst_no=sheetObject.GetCellValue(selRow, "apro_rqst_no");
                	if (apro_rqst_no==''){
						showErrMessage(ComGetMsg("COM12176"));
						return false;
					}                	
                    var url="/opuscntr/COM_ENS_0W1.do?apro_rqst_no="+apro_rqst_no;
                    window.open(url, "stepPop", "status=no, width="+w+", height="+h+", resizable=no, scrollbars=no, left="+leftpos+", top="+toppos);
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg("COM12111"));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    /**
    * Action 버튼의 활성/비활성을 설정한다. <br>
    * @param  invStatus String
    * @param  statusCd String
    * @return 없음
    * @author 김창식
    * @version 2009.10.12
    */	
   function doActionBtnEnable (invStatus){
   	// Invoice Confirm 버튼 활성/비활성
   	if(invStatus == 'S'){
   		ComBtnEnable("btng_confirm");
   	} else {
   		ComBtnDisable("btng_confirm");
   	}
   }
    /**
     * make IBSheet Object array 
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet init
     * add axon event
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        formObj=document.form;

    }
   /**
     * init sheet
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
	             var HeadTitle="||NO||STS|Module|Date|Cost Office|CSR No.|No. Of INV|Payment S/P|Payment Due Date|Currency|Total Amount|Remark|" ;
	
	             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,  SaveName:"apro_rqst_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apro_rqst_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"apsts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_sys_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_st_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inv_knt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pay_due_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"apro_ttl_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",  ColMerge:0,   SaveName:"apro_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"appyn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	              
	             InitColumns(cols);
	
	             SetEditable(1);
                 SetColHidden(1,1);
//                 SetSheetHeight(420);
                 resizeSheet();
             }


             break;
        }
    }
  
    function sheet1_OnSearchEnd() {
    	var sheetObj=sheetObjects[0];
    	for(var i=0; i<sheetObj.RowCount(); i++) {
    		if(sheetObj.GetCellValue(i + 1, "appyn") == "Y") {
                sheetObj.SetCellEditable(i + 1, "checkbox",0);
                sheetObj.SetCellEditable(i + 1, "apro_rmk",0);
            }
        }
    }
    function sheet1_OnSaveEnd() {
    	
    	var sheetObj=sheetObjects[0];
    	var formObj = document.form;
    	
    	if(formObj.f_cmd.value != COMMAND01) {
	    	for(var i=0; i<sheetObj.RowCount(); i++) {
	    		if(sheetObj.GetCellValue(i + 1, "appyn") == "Y") {
	                sheetObj.SetCellEditable(i + 1, "checkbox",0);
	                sheetObj.SetCellEditable(i + 1, "apro_rmk",0);
	            }
	        }
	    	ComShowCodeMessage("COM130903", "Data");
	    	doActionIBSheet(sheetObj,formObj,IBSEARCH);
	    	doActionBtnEnable('S');
    	}
    }
    function sheet1_OnChange(sheetObj , row , col, value)
    {
    	var formObj=document.form;
		var sName=sheetObj.ColSaveName(col);
  		var rows=sheetObj.LastRow();
		var pi=0;
		//기존 로직 
		if (sName == "checkbox") {
   			if(row > 0 && row < rows) {
   				if(sheetObj.GetCellValue(row,"checkbox") == 1) {	 //Check
   					//doActionBtnEnable('S');
   				}
   			}
		}
    }
  // Sheet evnet action declear
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:        //search process
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                if(formObj.status.value != "P") {
                   sheetObj.SetRowEditable(4,0);
                }
                formObj.f_cmd.value=SEARCHLIST;                
                selectVal=FormQueryString(formObj)
                sheetObj.DoSearch("COM_ENS_0U1ViewGS.do", selectVal,{Sync:2} );
           break;
           case IBSEARCHAPPEND:  // paging process
                formObj.f_cmd.value=SEARCHLIST;  
                sheetObj.DoSearch("COM_ENS_0U1GS.do", selectVal+"&"+ "iPage=" + PageNo,{Sync:2,Append:true} );
           break;
           case IBINSERT:      //  insert 
                var Row=sheetObj.DataInsert(0);
                sheetObj.SetCellValue(Row,"hol_knd_cd","C");
                break;
           case IBDOWNEXCEL:        //down excel
        	   sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
              break;
           case MULTI01:        // Confirm
                for(var i=0; i<sheetObj.RowCount(); i++) {
                	if(sheetObj.GetCellValue(i + 1, "checkbox") == 1) {
                        sheetObj.SetCellValue(i + 1, "ibflag","U",0);
                    }
                }
                formObj.f_cmd.value=MULTI01;
    			//파라미터 명시적인 생성
    			var formParams="";
    			formParams+="f_cmd="+ComGetObjValue(formObj.f_cmd);
                var param=sheetObj.GetSaveString(false,true,1);
                doActionBtnEnable('C');
                ComOpenWait(true);
                
                //sheetObj.DoSave("COM_ENS_0U1ViewGS.do", FormQueryString(formObj), 1, false);
     			var sXml=sheetObj.GetSearchData("COM_ENS_0U1ViewGS.do", param+'&'+formParams);
     			
 				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				//alert(backendJobKey);
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // calling getBackEndJobStatus function after three seconds - recall
				}

           break;
           case IBSEARCH_ASYNC02: 
               formObj.f_cmd.value=SEARCHLIST02;
               selectVal=FormQueryString(formObj);
      		    var sXml=sheetObj.GetSearchData("COM_ENS_0U1ViewGS.do", selectVal);
     		    var jobState=ComGetEtcData(sXml, "jb_sts_flg")
     		    var jobError=ComGetEtcData(sXml, "jb_usr_err_msg")
     		    if (jobState == "3") {
     		        ComOpenWait(false);
     		        ComShowCodeMessage("CSR25021");
     		        if (gRefresh)
     		        	doActionIBSheet(sheetObj, formObj, IBSEARCH);
     		        clearInterval(timer);
     		    } else if (jobState == "4") {
     		        ComOpenWait(false);
     		        clearInterval(timer);
     		        // BackEndJob을 실패 하였습니다.
     		        ComShowMessage(jobError);
     		    } else if (jobState == "5") {
     		        ComOpenWait(false);
     		        clearInterval(timer);
     		        // 이미 BackEndJob 결과 파일을 읽었습니다.
     		        ComShowCodeMessage('JOO00152');
     		    }
            break;
           case MULTI02:        // Reject
                for(var i=0; i<sheetObj.RowCount(); i++) {
                	if(sheetObj.GetCellValue(i + 1, "checkbox") == 1) {
                        sheetObj.SetCellValue(i + 1, "ibflag","U",0);
                    }
                }
                formObj.f_cmd.value=MULTI02;    
                sheetObj.DoSave("COM_ENS_0U1ViewGS.do", FormQueryString(formObj), 1, false);
                break;
           case COMMAND01:        // Approve 이후 BackendJob 실행 후 Business Error 발생 후 상태 메세지 update
               	formObj.f_cmd.value=COMMAND01;    
               	//sheetObj.DoSave("COM_ENS_0U1ViewGS.do", FormQueryString(formObj), 1, false);
               	var sXml=sheetObj.GetSaveData("COM_ENS_0U1ViewGS.do", FormQueryString(formObj));
               
               	var csr_no = ComGetEtcData(sXml, "csr_no");
               	var err_msg = ComGetEtcData(sXml, "err_msg");
               
               	if (csr_no != "" ) { 
            	   ComShowMessage("[" + csr_no + "] " + err_msg);
               	}
               	
               	formObj.f_csr_no.value = "";
    			formObj.f_apro_rqst_no.value = "";
    			formObj.f_apro_rqst_seq.value = "";
    			formObj.f_apro_rmk.value = "";		
               
           		doActionIBSheet(sheetObj,formObj,IBSEARCH);
           		doActionBtnEnable('S');
           	
           		break;     
        }
    }
   /**
     * check validate form
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
 
        }
        return true;
    }
    function releasePage() {
    	event.returnValue="If you navigate away from this page now, the approval can't be completed successfully."
    }
	 function UF_getBackEndJobStatus() {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	}
	 
	 //UI 표준화관련 하단 여백 설정
	 function resizeSheet(){
		    ComResizeSheet(sheetObjects[0]);
	}
	 

	 /**	 
	 * BackEndJob Status='3' check.<br>
	 *
	 * @return none
	 * @see #doActionIBSheet
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
 	
 		formObj.f_cmd.value=SEARCHLIST02;
 		var sXml=sheetObjects[0].GetSearchData("COM_ENS_0U1ViewGS.do", FormQueryString(form));
		var arrXml=sXml.split("|$$|");
		var jobState=ComGetEtcData(arrXml[0], "jb_sts_flg");
		//alert("getBackEndJobStatus:::" + jobState);
		if(jobState == "3") {
			clearInterval(timer);
			getBackEndJobLoadFile();
			//ComOpenWait(false);
		} else if(jobState == "4") {
			clearInterval(timer);
	 		// BackEndJob was failed
			ComOpenWait(false);
	 		
	 		var jbUsrErrMsg=setErrMsgInfo(getBackEndJobErrMsg( ComGetEtcData(sXml, "jb_usr_err_msg") ));
	 		
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '') {
	 			
	 			if(formObj.f_csr_no.value != '') {
	 				doActionIBSheet(sheetObj,formObj,COMMAND01);
	 			} else {
	 				ComShowMessage(jbUsrErrMsg);
	 			}
	 		} else {
	 			ComShowCodeMessage("COM132101"); 
			}
		} else if(jobState == "5") {
			clearInterval(timer);
			ComShowCodeMessage("COM132101"); //Unexpected system error took place during data processing. Please try again later.
			ComOpenWait(false);
		} else {
			ComOpenWait(false);
		}
	} 	

	// reflect result data in case of BackEndJob successful end
	function getBackEndJobLoadFile() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	ComOpenWait(false);
	 	//backendjob 완료후 작업할것 있으면 수행.
	 	ComShowCodeMessage("COM130102", "Approve"); 
	 	doActionBtnEnable('S');
	 	doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}	
	 
	//getBackEndJobErrMsg
	function getBackEndJobErrMsg(params) {
		var ary=params.split('<||>');
		if (ary != undefined && ary.length > 4 ) {
			return ary[3];
		} else {
			return ary[ary.length-1];
		}
			
	}
	
	//setErrMsgInfo
	function setErrMsgInfo(params) {
		
		var formObj=document.form;
		
		var ary=params.split('#');
		if(ary.length == 4) {
			formObj.f_csr_no.value = ary[0];
			formObj.f_apro_rqst_no.value = ary[1];
			formObj.f_apro_rqst_seq.value = ary[2];
			formObj.f_apro_rmk.value = ary[3];	
		
		} else {
			formObj.f_csr_no.value = "";
			formObj.f_apro_rqst_no.value = "";
			formObj.f_apro_rqst_seq.value = "";
			formObj.f_apro_rmk.value = params;		
		}
		return formObj.f_apro_rmk.value;
	}	