/*=========================================================
***Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0701.js
*@FileTitle  :   Unmatch B/L Inquiry by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* Developer Work	*/
 // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var comboObjects=new Array();
    var comboCnt=0;
    var gRctRhqCd;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    var eventStatus="";
    //when bkg_contract selected,blank 
    var bkg_contract_bk="";
    /**
	  * Event handler processing by button name <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 
	  * @author 이승준
	  * @version 2009.04.17
	  */
        function processButtonClick(){
             /***** using extra sheet valuable if there are more 2 sheets *****/
    		         var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
            	switch(srcName) {
	    	        case "btns_calendar1": //calendar button
			        	var cal=new ComCalendar();
			        	cal.select(form.rt_aply_dt_from, 'yyyy-MM-dd');
			        	break;
	    	        case "btns_calendar2":
				        var cal=new ComCalendar();
				        cal.select(form.rt_aply_dt_to, 'yyyy-MM-dd');
				        break;
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
						break;
					case "btn_New":
						removeAll(formObject);
						break;
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					case "btn_DownExcel":						
//						sheetObjects[1].Copy2SheetCol(sheetObjects[1],"bkg_contract","bkg_contract_bk");
//						sheetObjects[1].Down2Excel({ HiddenColumn:-1});
//						resetUnMatchDetail();
//						sheetObjects[1].SetMergeCell(0, 17, 2, 1);
//						break;
						if(sheetObjects[1].RowCount() < 1){//no data	
//							ComShowCodeMessage("BKG00155");
							ComShowCodeMessage("COM132501");
						}else{
							sheetObjects[1].Down2Excel({ HiddenColumn:1});
							resetUnMatchDetail();
							sheetObjects[1].SetMergeCell(0, 17, 2, 1);
//							sheetObjects[1].Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
						}	
						break;
					case "btn_ReAudit":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
						break;
//					case "pol_popup":
//						ComOpenPopup("COM_ENS_051.do", 650, 440,"setPolCd", "1,0,1,1,1", false);
//						break;
					case "btn_Settle":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
						break;
					case "btn_Close":
						ComClosePopup(); 
						break;
					case "btn_Filtered_Bl":
						if (!validateForm(sheetObjects[1],formObject,IBSEARCH)) return;
			        	try {
							ComOpenWait(true);
							sheetObjects[0].SetWaitImageVisible(0);
							formObject.f_cmd.value=SEARCH02;
							var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0701GS.do", FormQueryString(formObject));
							var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
							if (backendJobKey.length > 0) {
								formObject.backendjob_key.value=backendJobKey;
								sheetObjects[0].SetWaitTimeOut(10000);
								timer=setInterval(getBackEndJobStatus, 3000); // after 3 sec
																				// getBackEndJobStatus function
																				// action 
			    			}else{
			        			ComOpenWait(false);
			    			}
			        	}catch(e){
			        		ComShowMessage(e);
			    			ComOpenWait(false);
			        	}
						break; 	
					case "audit_seq_radio":
						obj_click();
						break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowMessage(OBJECT_ERROR);
        		} else {
        			ComShowMessage(e);
        		}
        	}
        }
        /**
	   	  * About BackEndJob, validate Status='3' <br>
	   	  * <br><b>Example :</b>
	   	  * <pre>
	   	  *     getBackEndJobStatus()
	   	  * </pre>
	   	  * @param 
	   	  * @return 
	   	  * @version 2009.04.17
	   	  */
         function getBackEndJobStatus() {
	   		try {
	         	var form=document.form;	
	         	form.f_cmd.value=SEARCH03;
	         	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0701GS.do", FormQueryString(form));
	         	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	         	if (jobState == "3") {
	         		getBackEndJobLoadFile();
	         		clearInterval(timer);
	         	} else if (jobState == "4") { // BackEndJob failed.
	         		ComShowCodeMessage("BKG95019"); //msgs['PRI00338']='Failed to download. Please try again.';
	         		clearInterval(timer);	
	         		ComOpenWait(false);	
	         	} else if (jobState == "5") {
	         		ComShowCodeMessage("BKG95020"); //msgs['PRI00339']='Data was downloaded successfully.';
	         		clearInterval(timer);
	         		ComOpenWait(false);	
	         	}
	   		}catch(e){
	   			ComShowMessage(e);
	   			ComOpenWait(false);
	   		}
	   	}
         /**
	   	  * when BackEndJob end, Excel down.(Request Expense Inital)<br>
	   	  * <br><b>Example :</b>
	   	  * <pre>
	   	  *     getBackEndJobLoadFile()
	   	  * </pre>
	   	  * @param 
	   	  * @return 
	   	  * @version 2009.04.17
	   	  */
         function getBackEndJobLoadFile() {
	   		try {	   		  
	         	var form=document.form;
	         	form.f_cmd.value=SEARCH04;
	         	ComOpenWait(false);
	         	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0701GS.do", FormQueryString(form));
	         	form.filtered_bkg_count.value=ComAddComma(ComGetEtcData(sXml, "RESULT"));
	   		}catch(e){
	   			ComShowMessage(e);
	   		}finally{        	
	   			ComOpenWait(false);        		
	   		}
         }
         /**
          * registering IBSheet Object as list <br>
          * adding process for list in case of needing batch processing with other items  <br>
          * defining list on the top of source <br>
          * <br><b>Example :</b>
          * <pre>
          *     setSheetObject(sheetObj);
          * </pre>
          * @param {ibsheet} sheet_obj mandatory IBSheet Object
          * @return 
          * @version 2009.04.17
          */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * IBMulti Combo Object array <br>
         * adding process for list in case of needing batch processing with other items  <br>
         * defining list on the top of source <br>
         * <br><b>Example :</b>
         * <pre>
         *     setComboObject(combo_obj);
         * </pre>
         * @param {ibCombo} combo_obj mandatory IBMulti Combo Object
         * @return 
         * @version 2009.04.17
         */ 
        function setComboObject(combo_obj){
     		comboObjects[comboCnt++]=combo_obj;
     	}
        /**
         * initializing sheet <br>
         * implementing onLoad event handler in body tag <br>
         * adding first-served functions after loading screen.. <br>
         * <br><b>Example :</b>
         * <pre>
         *     loadPage();
         * </pre>
         * @return 
         * @version 2009.04.17
         */
        function loadPage() {
        	 var form=document.form;
        	 sheet1=sheetObjects[1];
        	 sheet2=sheetObjects[2];
        	 gRctRhqCd=form.strRhq_ofc_cd.value;
 			//IBMultiCombo Initialization
      	    for(var k=0; k < comboObjects.length; k++){
      	        initCombo(comboObjects[k], k + 1);
      	    }
			for(i=0;i<sheetObjects.length;i++){
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
   		    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		    
   	        doActionIBSheet(sheet2, form, IBSEARCH_ASYNC03);    	
        //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
//       	 sheetObj.SetMergeCell (0, 20, 2, 2);
	       	initIBComboItem();
        } 
 /** 
 * Onbeforedeactivate event handling <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param   
 * @return 
 * @see #
 * @version 2010.01.04
 */ 
 function obj_deactivate() {
 	var form=document.form;
 	var formObj=ComGetEvent();
     var srcName=formObj.getAttribute("name");
     switch(srcName) {
		case "vvd_cd":
		case "bl_no":
			var vvdObj=form.vvd_cd;
			var blNoObj=form.bl_no;
			var fmDtObj=form.rt_aply_dt_from;
			var toDtObj=form.rt_aply_dt_to;
			if(vvdObj.value.length == vvdObj.maxLength || blNoObj.value.length == blNoObj.maxLength){
				fmDtObj.className="input";
				toDtObj.className="input";
			}else{
				fmDtObj.className="input1";
				toDtObj.className="input1";
			}
			break;
		case "contract_no":
			break;
 		default :
 			ComChkObjValid(formObj);
 	}
 }
     	/**
         * IBSHEET COMBO LOAD function<br>
         * <br><b>Example :</b>
         * <pre>
         * 		initCombo(comboObj, comboNo)
         * </pre>
         * @return 
         * @version 2009.06.10
         */ 
        function initCombo(comboObj, comboNo) {
            switch(comboObj.options.id) {
            case "rct_rhq_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
    				ValidChar(2, 0);    
                    SetMaxLength(6);
                }
                break;
            case "rct_ofc_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
    				ValidChar(2, 0);    
                    SetMaxLength(6);
                }
                break;
            case "conti_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
     				ValidChar(2, 0);    
                    SetMaxLength(6);
                }
                break;    
            case "bkg_ctrt_tp_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                 	ValidChar(2, 2);    
                }
                break;      
            case "umch_tp_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                 	ValidChar(1, 2);    
                }
                break;          
            case "auto_rat_flg":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                	ValidChar(1, 2);   
                }
                break;  
            case "rev_aud_sts_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                 	ValidChar(1, 2);    
                }
                break;    
            case "rev_aud_stl_knd_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                	ValidChar(1, 2);    
                }
                break;       
            case "bdr_status_cd":
                var i=0;
                with(comboObj) {
                	SetDropHeight(200);
    				SetUseAutoComplete(1);
                	ValidChar(1, 2);    
                }
                break;     
    		case "chg_cd":
    			var i=0;
    			with (comboObj) {
    				SetDropHeight(200);
    				SetUseAutoComplete(1);
    				ValidChar(2, 0);    
                    SetMaxLength(3);
    			}
    			break;
            }
      	}
        /**
         * when rct_rhq_cd change, active<br>
         * qttn_ver_no retrieve.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    mandatory,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return    
         * @version 2009.06.10
         */ 
        function rct_rhq_cd_OnChange(comboObj, oldindex, oldtext, oldcode , newindex, newtext , newcode) {
        	if(comboObj.GetSelectIndex()== "0") {
 				comboObjects[1].removeAll();
 				return;
 			}	
     		if(comboObj.GetItemCount () > 0 && comboObj.GetSelectIndex()!= "-1") {
 				var formObj=document.form;
 				formObj.etc2.value=newcode;
 				// 조직도 combo2
 	        	formObj.f_cmd.value=COMMAND02;
 	        	var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
 				ComXml2ComboItem(sXml, rct_ofc_cd, "cd", "cd");
 				rct_ofc_cd.SetSelectCode(strOfc_cd.value);
 				rct_ofc_cd.InsertItem(0,'','');
     		} 
       	}
        /**
         * when rev_aud_sts_cd change, active<br>
         * qttn_ver_no retrieve.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    mandatory,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return    
         * @version 2009.06.10
         */ 
        function rev_aud_sts_cd_OnChange(comboObj, oldindex, oldtext, oldcode , newindex, newtext , newcode) {
        	if(comboObj.GetItemCount () > 0 && comboObj.GetSelectIndex()!= "-1") {
     			//settle
     			if(newcode == "S") {
     				rev_aud_stl_knd_cd.SetSelectIndex("-1");
     				rev_aud_stl_knd_cd.SetEnable(1);
     			} else {
     				rev_aud_stl_knd_cd.SetSelectIndex("-1");
     				rev_aud_stl_knd_cd.SetEnable(0);
     			}
     		} 
       	}
 /**
  * IBMultiCombo Item setting <br>
  * <br><b>Example :</b>
  * <pre>
  *     initIBComboItem();
  * </pre>
  * @return 
  * @version 2009.12.15
  */
function initIBComboItem() {
	ComBkgTextCode2ComboItem(rhqComboValue,          rhqComboValue,         getComboObject(comboObjects, 'rct_rhq_cd'),         "|", "\t" );
	ComBkgTextCode2ComboItem(contiCdComboValue,      contiCdComboText,      getComboObject(comboObjects, 'conti_cd'),   	    "|", "\t" );
    ComBkgTextCode2ComboItem(contiCdComboValue,		 contiCdComboText,      getComboObject(comboObjects, 'conti_cd2'),	        "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );
	ComBkgTextCode2ComboItem(errorTypeComboValue,    errorTypeComboText,    getComboObject(comboObjects, 'umch_tp_cd'),         "|", "\t" );
	ComBkgTextCode2ComboItem(ratingTypeComboValue,   ratingTypeComboText,   getComboObject(comboObjects, 'auto_rat_flg'),       "|", "\t" );
	ComBkgTextCode2ComboItem(status1ComboValue,      status1ComboText,      getComboObject(comboObjects, 'rev_aud_sts_cd'),     "|", "\t" );
	ComBkgTextCode2ComboItem(status2ComboValue,      status2ComboText,      getComboObject(comboObjects, 'rev_aud_stl_knd_cd'), "|", "\t" );
	getComboObject(comboObjects, 'rev_aud_sts_cd').SetSelectCode('U');
//		ComBkgTextCode2ComboItem(recordComboValue,       recordComboText,       getComboObject(comboObjects, 'audit_seq_cd'),       "|", "\t" );
//		getComboObject(comboObjects, 'audit_seq_cd').Code = 'P'; 
	bdr_status_cd.InsertItem(0,'','');
	bdr_status_cd.InsertItem(1,'Yes','Y');
	bdr_status_cd.InsertItem(2,'No','N');
	getComboObject(comboObjects, 'bdr_status_cd').SetSelectCode('N');
}
       /**
        * setting sheet initial values and header <br>
        * adding case as numbers of counting sheets <br>
        * <br><b>Example :</b>
        * <pre>
        *     initSheet(sheetObj,1);
        * </pre>
        * @param {ibsheet} sheetObj mandatory IBSheet Object
        * @param {int} sheetNo mandatory IBSheet Object 
        * @return 
        * @version 2009.04.17
        */
        function initSheet(sheetObj,sheetNo) {
        	var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
            case "sheet0":      //hidden 
	             with (sheetObj) {
	            	 SetVisible(false);
	             }
	             break; 
	   		case "sheet1":      //sheet1 init:      //sheet1 init
	   		    with(sheetObj){
			         var HeadTitle1="|Sel.|RHQ|Office|B/L No.|Appl. Date|POL ETD|T/VVD|POL|Error\nSeq.|Error\nLapse|BDR\nStatus|Contract\nType|Contract No.|Non-\nRevenue|Non-\nRevenue|Non-\nRevenue|Non-\nRevenue|Revenue|Revenue|Revenue|Error\nDetails|Error Charge|Diff Amount\n(USD)|Self Audit|RDN\nReceipt|RDN\nStatus|Error Status|Settle Type|Remarks\n(Office)|Remarks\n(Auditor)|Rater ID|Sales Rep.|BDR Date|Audit Date\n(Initial)|Audit Date\n(Update)|Audit Type|Settle Date|Settler ID|bkg_no|ctrt_tp_cd|Error Details|rev_aud_sts_cd|";
			         var HeadTitle2="|Sel.|RHQ|Office|B/L No.|Appl. Date|POL ETD|T/VVD|POL|Error\nSeq.|Error\nLapse|BDR\nStatus|Contract\nType|Contract No.|A1|A2|B|C|D|E|F|Error\nDetails|Error Charge|Diff Amount\n(USD)|Self Audit|RDN\nReceipt|RDN\nStatus|Error Status|Settle Type|Remarks\n(Office)|Remarks\n(Auditor)|Rater ID|Sales Rep.|BDR Date|Audit Date\n(Initial)|Audit Date\n(Update)|Audit Type|Settle Date|Settler ID|bkg_no|ctrt_tp_cd|Error Details|rev_aud_sts_cd|";
			         var headCount=ComCountHeadTitle(HeadTitle1);
		
			         SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle1, Align:"Center"},
			                   { Text:HeadTitle2, Align:"Center"} ];
			         InitHeaders(headers, info);
		
			         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rct_rhq_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rt_aply_dt",          KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd",             KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"umch_bkg_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"error_lapse",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sc_rfa_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"umch_al",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"umch_all",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"umch_b",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"umch_c",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"umch_d",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"umch_e",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"umch_f",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Popup",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"bkg_contract_bk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"err_chg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Popup",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"diff_usd_amt",        KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Popup",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"self_audit",          KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rdn_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rdn_staus",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rev_aud_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"rev_aud_stl_knd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"umch_rsn_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rgn_grp_avc_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rater_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"srep_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bdr_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"n1st_umch_fnd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lst_umch_fnd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rev_aud_tp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"bkg_contract",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rev_aud_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"umch_rsn_rmk_bk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			          
			         InitColumns(cols);
		
			         SetEditable(1);
	       			 SetImageList("myImage1","js/ibsheet/Main/popup.gif");
			          //no support[check again]CLT 		                UnEditableColor="#FFFFFF";                    
         		     SetShowButtonImage(2);
			         SetAutoRowHeight(0);
			         FrozenCols=5;
			         SetCellImage(0, 14,"js/ibsheet/Main/popup.gif");
			         SetCellImage(0, 15,"js/ibsheet/Main/popup.gif");
			         //no support[check again]CLT 		       			HeaderImageAlign(0,13)=daRight;
			         //no support[check again]CLT 		       			HeaderImageAlign(0,17)=daRight;
			         SetColHidden("pol_cd",1);
			   		 SetSheetHeight(360);
	   	      }
	               break;
	   		case "sheet2": // Combo
	   		    with(sheetObj){			   	       
			   	      var HeadTitle1="Seq.|chg_cd|chg_nm|rep_chg_cd"
			   	      (ComCountHeadTitle(HeadTitle1), 0, 0, false);			
			   	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );			
			   	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			   	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			   	      InitHeaders(headers, info);
			
			   	      var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			   	             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			   	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			   	             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];			   	       
			   	      InitColumns(cols);			
			   	      SetEditable(1);
			   	      SetSheetHeight(100);
	   	            }
    			break;
            }
        }
//        function sheet1_OnChange(sheetObj, ErrMsg){
//        	alert("abc");
//        }
        /**
         * handling sheet process <br>
         * <br><b>Example :</b>
         * <pre>
         *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @param {form} formObj mandatory html form object
         * @param {int} sAction mandatory 
         * @return 
         * @version 2009.04.17
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
//            sheetObj.ShowDebugMsg(false);
			var form=document.form;
			var chkRows=sheet1.FindCheckedRow("chk");
			var arrRow=chkRows.split("|");
			var arrLen=arrRow.length;
            switch(sAction) {
            	case IBSEARCH:      //retrieve
            		if (validateForm(sheetObj,formObj,sAction)) {
            			setAuditSeqCd(formObj);
        	    		ComOpenWait(true);		
        	    		sheetObj.SetWaitImageVisible(0);
            			formObj.f_cmd.value=SEARCH01;
            			var sXml=sheet1.GetSearchData("ESM_BKG_0701GS.do" , FormQueryString(formObj));
        	     		sheet1.LoadSearchData(sXml,{Sync:0});
    	        	}    
            	    break;
    			case IBSAVE:        //save
	   	 			if(!sheet1.IsDataModified()) {
	          			ComShowCodeMessage("BKG95005");
					    return false;
	          		}
    				if (!ComShowCodeConfirm("BKG95003", "save Remarks")) { return false; } // msgs['BKG95003']="Do you want to {?msg1}?"
	 				formObj.f_cmd.value=MULTI02;
					var sParam=FormQueryString(formObj);
					var sParamSheet1=sheet1.GetSaveString();
					if (sParamSheet1 == "") {
	          			ComShowCodeMessage("BKG95005");
					    return false;
					}
					sParam += "&" + sParamSheet1;
		    		ComOpenWait(true);		
		    		var sXml=sheet1.GetSaveData("ESM_BKG_0701GS.do", sParam);
		    		sheet1.LoadSaveData(sXml);
					ComOpenWait(false);
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("BKG95033"); // "Saved."
						doActionIBSheet(sheet1,document.form,IBSEARCH);						
					}
	        		break;
    			case IBSEARCH_ASYNC01:           //manual settle(office)
    	  		//if no check items
    	  		if(arrLen < 1 || chkRows == "") {
    	  			ComShowCodeMessage("BKG95031", "the Error B/L that you want to settle manually");
    			    return false;
    	  		}
    			for(var i=1; i<= sheet1.RowCount(); i++){
    				if(sheet1.GetCellValue(i, "chk") == "1"){
    					if(sheet1.GetCellValue(i, "bdr_flg") == "Yes"){
    						ComShowCodeMessage("BKG95045");
    						return false;//ComShowCodeMessage("BKG95045"); //"You can settle Error B/L manually only for B/L in staus of BDR_No. Please see if you selected B/L in status of BDR_Yes."
    					}
    				}
    			}
    			for(var i=2; i<= sheet1.RowCount()+2; i++){
    				if(sheet1.GetCellValue(i, "chk") == "1"){
    					if(sheet1.GetCellValue(i, "umch_rsn_rmk") == "" || sheet1.GetCellValue(i,"umch_rsn_rmk_bk") == ""){
    						ComShowCodeMessage("BKG95044");
    						return false;//ComShowCodeMessage("BKG95044"); //"Please input the reason of manual settlement into Remarks(Office)."
    					}
    				}
    			}
    			if (!ComShowCodeConfirm("BKG95003", "settle the Error manually")) { return; }
 				formObj.f_cmd.value=MULTI01;
				var sParam=FormQueryString(formObj);
				var sParamSheet1=sheet1.GetSaveString(false, true, "chk");
				sParam += "&" + sParamSheet1;
	    		ComOpenWait(true);
	    		var sXml=sheet1.GetSaveData("ESM_BKG_0701GS.do", sParam);
	    		sheet1.LoadSaveData(sXml);
				ComOpenWait(false);        		
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComShowCodeMessage("BKG95032"); // "Settled manually."
					doActionIBSheet(sheet1,document.form,IBSEARCH);
				}
        		break;
    			case IBSEARCH_ASYNC02: // Re Audit
					if (arrLen < 1 || chkRows == "") {
						ComShowCodeMessage("BKG95028"); // "Please select the B/L that you want to audit again."
						return;
					}
					if (ComShowCodeConfirm("BKG95029")) { // "Do you want to execute Re-Audit?"
						var bkgNoArrObj=form.bkg_no_arr;
						bkgNoArrObj.value="";
						var rowIdx, bkgNo, bkgNoStr="";
						for(var idx=0; idx < arrLen; idx++){
							bkgNo=sheet1.GetCellValue(arrRow[idx], "bkg_no");
							if(idx ==0) {
								bkgNoStr=bkgNo; 
							}else{
								bkgNoStr=bkgNoStr + "|" + bkgNo;
							}
						}
						bkgNoArrObj.value=bkgNoStr;
						form.f_cmd.value=MULTI03;
						var params=FormQueryString(formObj);
			    		ComOpenWait(true);		
			    		var sXml=sheet1.GetSaveData("ESM_BKG_0701GS.do", params);
			    		sheet1.LoadSaveData(sXml);
						ComOpenWait(false);        		
						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
							ComShowCodeMessage("BKG95030"); // "Re-Audited."
							doActionIBSheet(sheet1,document.form,IBSEARCH);
						}
					}
	        		break;	 
       			case IBSEARCH_ASYNC03:
//       					sheetObjects[2].ShowDebugMsg(false);
       					gXml=sheetObjects[1].GetSearchData("RASCommonGS.do?", "f_cmd=" + SEARCHLIST09);
        				ComXml2ComboItem(gXml, chg_cd, "chg_cd", "chg_cd|chg_nm");
        				chg_cd.InsertItem(0, "", "");
//        				sheetObjects[2].LoadSearchXml(gXml);
				break;
            }
        }
        /**
		 * handling process for input validation <br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
		 *         logic handling;
		 *     }
		 * </pre>
		 * @param {ibsheet} sheetObj mandatory IBSheet Object
		 * @param {form} formObj mandatory html form object
		 * @param {int} sAction mandatory 
		 * @return bool <br>
		 * @version 2009.04.17
		 */
        function validateForm(sheetObj,formObj,sAction){
       	  switch (sAction) {
   	 		case IBSEARCH: // retrieve
		 		var isChkDt=true;
		 		var vvdObj=form.vvd_cd;
		 		var blNoObj=form.bl_no;
		 		var fmDtObj=form.rt_aply_dt_from;
		 		var toDtObj=form.rt_aply_dt_to;
		 		var fmDtValue=fmDtObj.value.replace(/-/g, "");
		 		var toDtValue=toDtObj.value.replace(/-/g, "");
	 			if(!ComChkObjValid(fmDtObj)) { return false; }	 			
	 			if(!ComChkObjValid(toDtObj)) { return false; }
		 		if("" == vvdObj.value && "" == blNoObj.value && ("" == fmDtValue || "" == toDtValue)) {
					 ComShowCodeMessage("BKG95025", "Audit Date(Update) or T/VVD or B/L No"); // "Please input {?msg2}."
					 if("" == fmDtObj.value) {
						 ComSetFocus(fmDtObj);
					 }else{
						 ComSetFocus(toDtObj);
					 }
					 return false;
		 		}
				if(vvdObj.value.length == vvdObj.maxLength || blNoObj.value.length == blNoObj.maxLength){
					isChkDt=false;
				}else{
					isChkDt=true;
				}
	 			if(isChkDt){
	 		 		if("" == fmDtValue || "" == toDtValue){
	 					 ComShowCodeMessage("BKG95025", "Audit Date(Update)"); // "Please input {?msg2}."
	 					 if("" == fmDtValue) {
		 					 ComSetFocus(fmDtObj);
	 					 }else{
		 					 ComSetFocus(toDtObj);
	 					 }
	 					 return false;
	 		 		}
		 		}
	 			if( "" != fmDtValue && "" != toDtValue && ( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) ) {
					 ComShowCodeMessage("BKG95026", "From Date", "To Date");
					 ComSetFocus(fmDtObj);
					 return false;
		 		}
	 			if(isChkDt){
	 	 			var fromAddDays=ComGetDateAdd(fmDtValue, "D", 99, "", true);
	 	 			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
	 	 				ComShowCodeMessage("BKG95027", "100 days"); // "The period of Date can't be over {?msg1}."
	 	 				ComSetFocus(fmDtObj);
	 	 				return false;
	 	 			}
	 			}   	 		
   				return true;
   	 			break;
   	 		}
            return true;
        }
        /** 
    	* sheet2 OnSearchEnd event handler <br>
    	*/ 
        function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg)
    	{
        	ComOpenWait(false);
//        	setFontColor("white");
    		var formObj=document.form;
    		var unmatched_bl_count=0;
    		var unmatched_case_count=0;
    		var unmatch_al=0;
    		var unmatch_all=0;
    		var unmatch_b=0;
    		var unmatch_c=0;
    		var unmatch_d=0;
    		var unmatch_e=0;
    		var unmatch_f=0;
 	 		var startRow1=sheet1.HeaderRows();
 			var endRow1=sheet1.HeaderRows()+ sheet1.RowCount();
			for(var i=startRow1; i < endRow1; i++) {
				if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_al"))) unmatch_al++;
				if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_all"))) unmatch_all++;
				if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_b"))) unmatch_b++;
				if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_c"))) unmatch_c++;
				if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_d"))) unmatch_d++;
				if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_e"))) unmatch_e++;
				if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_f"))) unmatch_f++;
				if(sheetObj.GetCellValue(i, "rev_aud_sts_cd") != "U") {
 	 				sheetObj.SetCellEditable(i, "chk",0);
 	 				sheetObj.SetCellBackColor(i, "chk","#EFF0F3");
 	 			}
 	 		}
			//total
			unmatched_bl_count=sheetObj.GetTotalRows();
			unmatched_case_count=unmatch_al + unmatch_all + unmatch_b + unmatch_c + unmatch_d + unmatch_e + unmatch_f;
			formObj.unmatched_bl_count.value=ComAddComma(unmatched_bl_count);
			formObj.unmatched_case_count.value=ComAddComma(unmatched_case_count);
			formObj.unmatch_al.value=ComAddComma(unmatch_al);
			formObj.unmatch_all.value=ComAddComma(unmatch_all);
			formObj.unmatch_b.value=ComAddComma(unmatch_b);
			formObj.unmatch_c.value=ComAddComma(unmatch_c);
			formObj.unmatch_d.value=ComAddComma(unmatch_d);
			formObj.unmatch_e.value=ComAddComma(unmatch_e);
			formObj.unmatch_f.value=ComAddComma(unmatch_f);
			/* set Apply in umch_rsn_rmk_bk */
 	 		for(var i=2; i<= sheetObj.RowCount()+2; i++){
 	 			sheetObj.SetCellValue(i,"umch_rsn_rmk_bk",sheetObj.GetCellValue(i,"umch_rsn_rmk"),0);
 	 		} 	 		
    	}
        /** 
         * sheet1 OnPopupClick event handler <br>
         */
        function sheet1_OnPopupClick(sheetObj ,Row, Col) {
			var form=document.form;
			var sName=sheet1.ColSaveName(Col);
			var scRfaNo=sheet1.GetCellValue(Row, "sc_rfa_no");
			var ctrtTpCd=sheet1.GetCellValue(Row, "ctrt_tp_cd");
			var bkgNo=sheet1.GetCellValue(Row, "bkg_no");
			var blNo=sheet1.GetCellValue(Row, "bl_no");
			var umchBkgSeq=sheet1.GetCellValue(Row, "umch_bkg_seq");
			var rdnNo=sheet1.GetCellValue(Row, "rdn_no");
			switch(sName) {
		 		case "sc_rfa_no":
		         	if(null == scRfaNo || "" == scRfaNo) { return; }
		     		var pgmNo="ESM_PRI_0004";
		     		var scRfaNoP=scRfaNo.substr(0, 3);
		     		var scRfaNoS=scRfaNo.substr(3);
		     		var popParams="sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.rt_aply_dt_from.value + "&exp_dt=" + form.rt_aply_dt_to.value;
		 	    	if(ctrtTpCd == "RFA") { // RFA
		 	    		pgmNo="ESM_PRI_2019";
		 	    		popParams="s_rfa_no=" + scRfaNo;
		 	    	}
		 	    	else if(ctrtTpCd == "TAA") { // TAA
		 	    		pgmNo="ESM_PRI_3007";
		 	    		popParams="cond_taa_no=" + scRfaNo;
			    	}
		        	comRASCallPop(pgmNo, "ESM_BKG_0701", popParams, "");
		 		    break;
		 		case "bl_no":
		         	if(null == bkgNo || "" == bkgNo) { return; }
		         	var popParams="bkg_no=" + bkgNo + "&openTab=B9";
    	        	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0701", popParams, "");
		 			break;
				case "bkg_contract_bk":
					var popParams="bl_no=" + blNo + "&bkg_no=" + bkgNo + "&umch_bkg_seq=" + umchBkgSeq;
					comRASCallPop("ESM_BKG_1049", "ESM_BKG_0701", popParams, "");
					break;
    			case "diff_usd_amt":
					var popParams="bkg_no="+bkgNo+"&umch_bkg_seq="+umchBkgSeq;
					comRASCallPop("ESM_BKG_0698", "ESM_BKG_0701", popParams, "");
					break;
    			case "self_audit":
//					var popParams = "bl_no="+blNo+"&umch_bkg_seq="+umchBkgSeq;   /*add*/
//					comRASCallPop("ESM_BKG_0263", "ESM_BKG_0256", popParams, "");
//					break;
					var _Width='1000';
					var _Height='728';
					var pgmNo="&pgmNo=ESM_BKG_0263";
					var popParams="bl_no="+blNo+"&umch_bkg_seq="+umchBkgSeq; 
					var url="ESM_BKG_0263.do?" + popParams + pgmNo;
					ComOpenPopupWithTarget(url, _Width, _Height, "","none",false);
					break;
             	case "rdn_no":
					if(null == rdnNo || "" == rdnNo) { return; }
    	    		var popParams="rdn_no=" + rdnNo + "&bl_no=" + blNo;
    	    		comRASCallPop("ESM_BKG_0712", "ESM_BKG_0701", popParams, "");
					break;
			}
			
    	}
    	/*
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{
    		with(sheetObj)
    		{
    			var blank1="              ";
    			var blank2="  ";
CellComboItem(2,"bkg_contract", {ComboText:"VN001700"+blank1+"VN001701|OFT:D4:USD1000"+blank2+"OFT:D4:USD1200", ComboCode:"1"} );
CellComboItem(4,"bkg_contract", {ComboText:"DTH:D4:AUD20"+blank2+"DTH:D4:AUD120", ComboCode:"1"} );
    		}
    	}
    	*/
 	 	/** 
         * settle status U set. <br>
         */
function setGetRowStatus(sheetObj)  {
 	 		var cnt=0;	
 	 		for(var i=1; i<=sheetObj.RowCount(); i++) {
 	 			if(sheetObj.GetCellValue(i, "chk") == "1") {
 	 				sheetObj.SetRowStatus(i,"U");
 	 				cnt++;
 	 			}
 	 		}
 	 		return cnt;
 	 	}
 	 	/**
 	     * OnClick event handling function <br>
 	     */  	           
 	     function sheet1_OnClick(sheetObj, Row, Col, Value) {
 		    //when desc sel click, MemoPad display.(MemoPad editable)
 		    var colname=sheetObj.ColSaveName(Col);
 	     	switch(colname){
 	 	    	case "umch_rsn_rmk":
 	 	    		ComShowMemoPad(sheetObj,Row,Col,false,200,200); 
 	 	    		break;
 	 	    	case "rgn_grp_avc_rmk":
 	 	    		ComShowMemoPad(sheetObj,Row,Col,true,200,200);
 	 	    		break;	
 	     	}    	 
 	    }
/**
 * OnMouseDown event handling function <br>
 */  	           
 function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	 var rowIdx=sheetObj.MouseRow();
	 var colIdx=sheetObj.MouseCol();
	 if( rowIdx == 0 && (13 < colIdx && colIdx < 15) ) {
		 var popParams="";
		 comRASCallPop("ESM_BKG_1055", "ESM_BKG_0701", popParams, "")
	 }
 }
 	/**
	 * screen reset.<br>
	 */
  	 	function removeAll(formObj) {
  	 		formObj.reset();
  	 		/***************************************/
  	 		comboObjects[1].RemoveAll(); 
  	 		comboObjects[0].SetSelectIndex("-1");
  	 		comboObjects[0].SetSelectCode(gRctRhqCd);
  	 		/***************************************/
  	 		comboObjects[2].SetSelectIndex("-1");
  	 		comboObjects[3].SetSelectIndex("-1");
  	 		comboObjects[4].SetSelectIndex("-1");
  	 		comboObjects[5].SetSelectCode("-1");
  	 		comboObjects[6].SetSelectIndex("U");
  	 		comboObjects[7].SetSelectIndex("-1");
  	 		sheetObjects[1].RemoveAll();
  		} 
  	 	/**
  	     * radio button click event handling function <br>
  	     */ 	
  	 	function obj_click()
  	 	{	 		
  	 		//bdr_status setting
  	 		setAuditSeqCd(document.form);
  	  	}
  	 	/**
  	     * setAuditSeqCd.<br>
  	     */
  	 	function setAuditSeqCd(formObj) {
  	 		if (formObj.audit_seq_radio[0].checked == true){
  	        	formObj.audit_seq_cd.value=formObj.audit_seq_radio[0].value;
  	        } else if(formObj.audit_seq_radio[1].checked == true) {
  	        	formObj.audit_seq_cd.value=formObj.audit_seq_radio[1].value;
  	        }
  	 	}
  	  /**
  	     * UnMatch Detail value reset. <br>
  	     */
  	    function resetUnMatchDetail() {
  	    	var sheetObj=sheetObjects[1];
  	    	for (var i=sheetObj.HeaderRows()-1, n=sheetObj.HeaderRows()+sheetObj.RowCount(); i < n; i++) {
  	    		sheetObj.SetCellValue(i, "bkg_contract_bk","");
  	    	}
  	    }
	/* Developer Work End */
