/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0256.js
*@FileTitle  : Unmatch B/L Inquiry by Auditor
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
  /* developer job	*/
 // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var comboObjects=new Array();
    var comboCnt=0;
    var sheet1;
    var intervalId;
    var intervalTime = 2000;
    var processCnt = 0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
		// Event handler processing by button name
        function processButtonClick(){
	         var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
            	switch(srcName) {
	    	        case "btns_calendar1": 
			        	var cal=new ComCalendar();
			        	cal.select(form.rt_aply_dt_from, 'yyyy-MM-dd');
			        	break;
	    	        case "btns_calendar2":
				        var cal=new ComCalendar();
				        cal.select(form.rt_aply_dt_to, 'yyyy-MM-dd');
				        break;
//					case "pol_popup":
//						ComOpenPopup("COM_ENS_051.do", 650, 440,"setPolCd", "1,0,1,1,1", false);
//						break;
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
						if(sheetObjects[1].RowCount() < 1){//no data 
							 ComShowCodeMessage("COM132501");
							}else{ 
							sheetObjects[1].Copy2SheetCol(sheetObjects[1],"bkg_contract","bkg_contract_bk");
	 						sheetObjects[1].Down2Excel({ HiddenColumn:1});
							resetUnMatchDetail();
							sheetObjects[1].SetMergeCell(0, 17, 2, 1);
						}
						break;
					case "btn_Filtered_Bl":
						if (!validateForm(sheetObjects[1], formObject, IBSEARCH_ASYNC03)) { return false; }
			        	try {
							ComOpenWait(true);			
							sheetObjects[0].SetWaitImageVisible(0);
			        		formObject.f_cmd.value=SEARCH02;
 							var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0256GS.do", FormQueryString(formObject));
							var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
							if (backendJobKey.length > 0) {
								formObject.backendjob_key.value=backendJobKey;
								sheetObjects[0].SetWaitTimeOut(10000);
								timer=setInterval(getBackEndJobStatus, 3000);
			    			}else{
			        			ComOpenWait(false);
			    			}
			        	}catch(e){
			        		ComShowMessage(e.message);
			    			ComOpenWait(false);
			        	}
						break;
					case "btn_ReAudit":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
						break;
					case "btn_Settle":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
						break;
					case "audit_seq_radio":
						obj_click();
						break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowMessage(OBJECT_ERROR);
        		} else {
        			ComShowMessage(e.message);
        		}
        	}     	
        }
        /**
	   	  * BackEndJob : check jobState : '3'
	   	  */
        function getBackEndJobStatus() {
	   		try {
	        	var form=document.form;	
	        	form.f_cmd.value=SEARCH03;
 	        	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0256GS.do", FormQueryString(form));
	        	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	        	if (jobState == "3") {
	        		getBackEndJobLoadFile();
	        		clearInterval(timer);
	        	} else if (jobState == "4") { 
	        		ComShowCodeMessage("BKG95019"); //msgs['BKG95019']='Failed to download. Please try again.';
	        		clearInterval(timer);	
	        		ComOpenWait(false);	
	        	} else if (jobState == "5") {
	        		ComShowCodeMessage("BKG95020"); //msgs['BKG95020']='Data was downloaded successfully.';
	        		clearInterval(timer);
	        		ComOpenWait(false);	
	        	}
	   		}catch(e){
	   			ComShowMessage(e.message);
	   			ComOpenWait(false);
	   		}
        }
        /**
	   	  * BackEndJob Excel file download is complete, the results are accepted.(Request Expense Inital)<br>
	   	  */
        function getBackEndJobLoadFile() {
	   		try {	   		  
	        	var form=document.form;
	        	form.f_cmd.value=SEARCH04;
 	        	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0256GS.do", FormQueryString(form));
	        	form.filtered_bkg_count.value=ComAddComma(ComGetEtcData(sXml, "RESULT"));
	   		}catch(e){
	   			ComShowMessage(e.message);
	   		}finally{        	
	   			ComOpenWait(false);        		
	   		}
        }
	  	/**
	  	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	  	 * defining list on the top of source
	  	 */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
        }
    	/**
    	 * register combo Object to comboObjects array
    	 * 
    	 * @param combo_obj
    	 * @return
    	 */
        function setComboObject(combo_obj){
     		comboObjects[comboCnt++]=combo_obj;
     	}
    	/**
    	 * initializing sheet
    	 * implementing onLoad event handler in body tag
    	 * adding first-served functions after loading screen.
    	 */
        function loadPage() {
        	sheet1=sheetObjects[1];
        	sheet2=sheetObjects[2]; 
			//IBMultiCombo init
     	    for(var k=0; k < comboObjects.length; k++){
     	        initCombo(comboObjects[k], k + 1);
     	    }
     	    sheet1=sheetObjects[1];
        	for(i=0;i<sheetObjects.length;i++){
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
//     		axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
//     	    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
   		    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		    
   	        doActionIBSheet(sheet2, form, IBSEARCH_ASYNC03);
   	        sheet1_OnLoadFinish(sheetObjects[0]);
    	}
          function sheet1_OnLoadFinish(sheetObj) {
        	 initIBComboItem();
         } 
/** 
* Object Keypress event Handler <br>
*/ 
//function obj_keypress(){
//	var obj=event.srcElement;
//	var objName=obj.getAttribute("name");
// 	if(obj.dataformat == null) return;
// 	window.defaultStatus=obj.dataformat;
//	switch(obj.dataformat){
// 	case "ymd": //Enter date	
//		ComKeyOnlyNumber(obj,"-"); 
//		break;
// 	case "int": //Number enter only
// 	case "number": //Number enter only
// 		ComKeyOnlyNumber(obj);
// 		break;
// 	case "engup":
// 		ComKeyOnlyAlphabet('upper');
// 		break;
// 	case "uppernum":
// 		ComKeyOnlyAlphabet('uppernum');
// 		break;
// 	default:
// 		//ComKeyOnlyNumber(obj);
// 		break;
//	}
//}         
/** 
* Onbeforedeactivate event Handler <br>
*/ 
function obj_deactivate() {
	var form=document.form;
	var formObj=event.srcElement;
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
 * OnBeforeActivate event Handler <br>
 */ 
function obj_activate() {
	ComClearSeparator (event.srcElement);	   
}
     	/**
         * IBSHEET COMBO LOAD Function<br>
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
            case "conti_cd":
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
         * rct_rhq_cd change event<br>
         */ 
        function rct_rhq_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
        	if(comboObj.GetSelectIndex()== "0") {
 				comboObjects[1].RemoveAll();
 				return;
 			}
     		if(comboObj.GetItemCount () > 0 && comboObj.GetSelectIndex()!= "-1") {
 				var formObj=document.form;
 				formObj.etc2.value=code;
 	        	formObj.f_cmd.value=COMMAND02;
  				var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
 				ComXml2ComboItem(sXml, comboObjects[1], "cd", "cd");
 				rct_ofc_cd.InsertItem(0,'','');
     		} 
       	}
        /**
         * rev_aud_sts_cd change event
         */ 
        function rev_aud_sts_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
     		if(comboObj.GetItemCount () > 0 && comboObj.GetSelectIndex()!= "-1") {
     			//settle
     			if(code == "S") {
     				rev_aud_stl_knd_cd.SetSelectIndex("-1");
     				rev_aud_stl_knd_cd.SetEnable(1);
     			} else {
     				rev_aud_stl_knd_cd.SetSelectIndex("-1");
     				rev_aud_stl_knd_cd.SetEnable(0);
     			}
     		} 
       	}
 /**
  * IBMultiComb Item setting
  */
function initIBComboItem() {
    ComBkgTextCode2ComboItem(rhqComboValue,          rhqComboValue,         getComboObject(comboObjects, 'rct_rhq_cd'),         "|", "\t" );
    ComBkgTextCode2ComboItem(contiCdComboValue,		 contiCdComboText,      getComboObject(comboObjects, 'conti_cd'),	        "|", "\t" );
    ComBkgTextCode2ComboItem(contiCdComboValue,		 contiCdComboText,      getComboObject(comboObjects, 'conti_cd2'),	        "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );
	ComBkgTextCode2ComboItem(errorTypeComboValue,    errorTypeComboText,    getComboObject(comboObjects, 'umch_tp_cd'),         "|", "\t" );
	ComBkgTextCode2ComboItem(ratingTypeComboValue,   ratingTypeComboText,   getComboObject(comboObjects, 'auto_rat_flg'),       "|", "\t" );
	//ComBkgTextCode2ComboItem(bdrstsComboValue,   bdrstsComboText,       getComboObject(comboObjects, 'bdr_status_cd'),       "|", "\t" );
	ComBkgTextCode2ComboItem(status1ComboValue,      status1ComboText,      getComboObject(comboObjects, 'rev_aud_sts_cd'),     "|", "\t" );
	ComBkgTextCode2ComboItem(status2ComboValue,      status2ComboText,      getComboObject(comboObjects, 'rev_aud_stl_knd_cd'), "|", "\t" );
	//getComboObject(comboObjects, 'rev_aud_sts_cd').SetSelectCode('U');
//	ComBkgTextCode2ComboItem(recordComboValue,       recordComboText,       getComboObject(comboObjects, 'audit_seq_cd'),       "|", "\t" );
//	getComboObject(comboObjects, 'audit_seq_cd').Code = 'P'; 
	bdr_status_cd.InsertItem(0,'','');
	bdr_status_cd.InsertItem(1,'Yes','Y');
	bdr_status_cd.InsertItem(2,'No','N');
	getComboObject(comboObjects, 'bdr_status_cd').SetSelectCode('Y');
	comboObjects[9].SetSelectIndex(2);	
}
		/**
		 * setting sheet initial values and header
		 * param : sheetObj, sheetNo
		 * adding case as numbers of counting sheets
		 */
        function initSheet(sheetObj,sheetNo) {
        	var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
        		case "sheet0":      //hidden 
    	             with (sheetObj) {
    	             }
    	             break; 
        		case "sheet1":      //sheet1 init:      //sheet1 init
 	               with (sheetObj) {
        			//setting height
        			
        			var HeadTitle1="|Sel.|RHQ|Office|B/L No.|Appl. Date|POL ETD|T/VVD|POL|Error\nSeq.|Error\nLapse|BDR\nStatus|Contract\nType|Contract No.|Non-\nRevenue|Non-\nRevenue|Non-\nRevenue|Non-\nRevenue|Revenue|Revenue|Revenue|Error\nDetails|Error Charge|Diff Amount\n(USD)|Self Audit|RDN\nIssuance|RDN\nStatus|Error Status|Settle Type|Remarks\n(Office)|Remarks\n(Auditor)|Rater ID|Sales Rep.|BDR Date|Audit Date\n(Initial)|Audit Date\n(Update)|Audit Type|Settle Date|Settler ID|bkg_no|ctrt_tp_cd|Error Details|rev_aud_sts_cd|bdr_flg";
        			var HeadTitle2="|Sel.|RHQ|Office|B/L No.|Appl. Date|POL ETD|T/VVD|POL|Error\nSeq.|Error\nLapse|BDR\nStatus|Contract\nType|Contract No.|A1|A2|B|C|D|E|F|Error\nDetails|Error Charge|Diff Amount\n(USD)|Self Audit|RDN\nIssuance|RDN\nStatus|Error Status|Settle Type|Remarks\n(Office)|Remarks\n(Auditor)|Rater ID|Sales Rep.|BDR Date|Audit Date\n(Initial)|Audit Date\n(Update)|Audit Type|Settle Date|Settler ID|bkg_no|ctrt_tp_cd|Error Details|rev_aud_sts_cd|bdr_flg";
        			var headCount=ComCountHeadTitle(HeadTitle1);
        			SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        			var headers = [ { Text:HeadTitle1, Align:"Center"},
        			                { Text:HeadTitle2, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rct_rhq_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rt_aply_dt",          KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd",             KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
        			             {Type:"Popup",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"diff_usd_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
        			             {Type:"Popup",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"self_audit",          KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
        			             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rdn_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rdn_status",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
        			             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"bkg_contract",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rev_aud_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
        			 
        			InitColumns(cols);
        			SetSheetHeight(330);
        			SetEditable(1);
        			SetImageList("myImage1","js/ibsheet/Main/popup.gif");
        			SetCellImage(0, 14,"js/ibsheet/Main/popup.gif");
        			SetShowButtonImage(2);
        			SetAutoRowHeight(0);
        			SetColHidden("pol_cd",1);
 	              }
 	               break;
        		case "sheet2": // combo
        	  		with (sheetObj) {
        			var HeadTitle1="Seq.|chg_cd|chg_nm|rep_chg_cd"

        			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
        			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
        			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
        			 
        			InitColumns(cols);
        			SetSheetHeight(100);
        			SetEditable(1);
        			}
        			break;
            }
        }
		//handling of Sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
			var form=document.form;
			var chkRows=sheet1.FindCheckedRow("chk");
			var arrRow=chkRows.split("|");
			var arrLen=arrRow.length;
		       switch(sAction) {
           	case IBSEARCH:      // retrieve
           		if (!validateForm(sheetObj,formObj,sAction)) { return false; }
           		ComOpenWait(true);
       			formObj.f_cmd.value=SEARCH01;
       			setAuditSeqCd(formObj);
   	    		sheetObj.SetWaitImageVisible(0);
       			var sXml=sheetObj.GetSearchData("ESM_BKG_0256GS.do" , FormQueryString(formObj));
       			sheetObj.LoadSearchData(sXml,{Sync:1} );
           	    break;

    			case IBSAVE:        // save
	    			if(!sheet1.IsDataModified()) {
	    	  			ComShowCodeMessage("BKG95005");
	    			    return false;
	    	  		}
	 				if (!ComShowCodeConfirm("BKG95003", "save Remarks")) { return false; }
	 				formObj.f_cmd.value=MULTI02;
					var sParam=FormQueryString(formObj);
					var sParamSheet1=sheet1.GetSaveString();
	    			if("" == sParamSheet1) {
	    	  			ComShowCodeMessage("BKG95005");
	    			    return false;
	    	  		}
					sParam += "&" + sParamSheet1;
		    		ComOpenWait(true);
 					var sXml=sheet1.GetSaveData("ESM_BKG_0256GS.do", sParam);
 					sheet1.LoadSaveData(sXml);
					ComOpenWait(false);        		
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("BKG95033"); // "Saved."
						doActionIBSheet(sheet1,document.form,IBSEARCH);
					}
	        		break;
    			case IBSEARCH_ASYNC01:        //settle
	    	  		if(arrLen < 1 || chkRows == "" ) {
	    	  			ComShowCodeMessage("BKG95031", "the Error B/L that you want to settle manually");
	    			    return false;
	    	  		}
	 				if (!ComShowCodeConfirm("BKG95003", "settle the Error manually")) { return; }
	 				formObj.f_cmd.value=MULTI01;
					var sParam=FormQueryString(formObj);
					var sParamSheet1=sheet1.GetSaveString(false, true, "chk");
					sParam += "&" + sParamSheet1;
		    		ComOpenWait(true);
 					var sXml=sheet1.GetSaveData("ESM_BKG_0256GS.do", sParam);
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
						return false;
					}
					if (ComShowCodeConfirm("BKG95029")) { // "Do you want to execute Re-Audit?"
						var bkgNoArrObj=form.bkg_no_arr;
						bkgNoArrObj.value="";
						var rowIdx, bkgNo, bkgNoStr="";
						for(var idx=0; idx < arrLen; idx++){
							bkgNo=sheet1.GetCellValue(arrRow[idx], "bkg_no");
							if(idx == 0) {
								bkgNoStr=bkgNo; 
							}else{
								bkgNoStr=bkgNoStr + "|" + bkgNo;
							}
						}
						bkgNoArrObj.value=bkgNoStr;
						form.f_cmd.value=MULTI03;
						var params=FormQueryString(formObj);
						ComOpenWait(true);
 			    		var sXml=sheet1.GetSearchData("ESM_BKG_0256GS.do", params);
 			    		
			    		var arrXml = sXml.split("|$$|");
						if (ComGetEtcData(arrXml[0], "jobID")) {
							ComSetObjValue(formObj.backendjob_key, ComGetEtcData(arrXml[0], "jobID"));
							
				            intervalId = setInterval(callIntervalBackEndJob, intervalTime);
						} else {  //backendJob 호출 실패
							ComOpenWait(false);
						}
					}
	        		break;
	       			case IBSEARCH_ASYNC03:
	       					sheetObjects[2].ShowDebugMsg(false);
 	        	        	gXml=sheetObjects[2].GetSearchData("RASCommonGS.do?", "f_cmd=" + SEARCHLIST09);
	        				ComXml2ComboItem(gXml, chg_cd, "chg_cd", "chg_cd|chg_nm");
	        				chg_cd.InsertItem(0, "", "");
    				break;
    				
	       			case SEARCH05:
	    		    	ComSetObjValue(formObj.f_cmd,SEARCH05);
	    		    	params = FormQueryString(formObj);
	    		    	var sXml = sheetObj.GetSearchData("ESM_BKG_0256GS.do", params);
	    		    	var arrXml = sXml.split("|$$|");
	    				var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg");
	    				if ("3"==jobState) {  // BackEndJob 성공
	    					clearInterval(intervalId);
	    		            doActionIBSheet(sheetObjects[1], document.form, SEARCH06);  // BackEndJob 결과 조회
	    				} else if ("4"==jobState) {  // BackEndJob 실패
	    					clearInterval(intervalId);
	    					ComOpenWait(false);
	    					ComShowCodeMessage("BKG00110", "Re-Audit");  

	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				} else if ("5"==jobState) {  // 이미 BackEndJob 결과 파일을 읽었습니다.
	    					clearInterval(intervalId);
	    					ComOpenWait(false);
	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				}
	    				ComOpenWait(false);

	       				break;
	       				
	       			case SEARCH06: // BackEndJob 결과 조회
	    		    	ComSetObjValue(formObj.f_cmd,SEARCH06);
	    		    	
	    		    	params = FormQueryString(formObj);
	    		    	var sXml = sheetObj.GetSearchData("ESM_BKG_0256GS.do", params);
	    		    	var arrXml = sXml.split("|$$|");
	    		    	if ("Y"==ComGetEtcData(arrXml[0], "result")) {
	    		    		clearInterval(intervalId);
	    					ComOpenWait(false);
	    					ComShowCodeMessage("BKG95030");
	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				} else if ("N"!=ComGetEtcData(arrXml[0], "result")) {  // BackEndJob 9분30초 경과
	    					ComShowMessage(ComGetEtcData(arrXml[0], "result"));
	    					ComOpenWait(false);
	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				} else { // Re-audit 중 Exception 발생
	    					clearInterval(intervalId);
	    					ComOpenWait(false);
	    					ComShowCodeMessage("BKG00110", "Re-Audit");   
	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				}
	    		    	break;
            }
        }
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction){
	 var form=document.form;
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
 					 if("" == fmDtValue){
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
	 	case IBSEARCH_ASYNC03: // bl count
			if(!ComChkObjValid(formObj.rt_aply_dt_from)) { return false; }
			if(!ComChkObjValid(formObj.rt_aply_dt_to)) { return false; }
			var vvdObj=formObj.vvd_cd;
			if( !ComIsEmpty(vvdObj.value) && (vvdObj.value.length != vvdObj.maxLength) ) {
				ComShowCodeMessage("BKG95018", vvdObj.caption, vvdObj.maxLength);
 				ComSetFocus(vvdObj);
				return false;
			}
			return true;
			break;
	 }
}
       /** 
        * sheet1_OnPopupClick event handler
        */
    	function sheet1_OnPopupClick(sheetObj, Row, Col) {
    		var form=document.form;
			var sName=sheet1.ColSaveName(Col);
			var scRfaNo=sheet1.GetCellValue(Row, "sc_rfa_no");
			var ctrtTpCd=sheet1.GetCellValue(Row, "ctrt_tp_cd");
			var blNo=sheet1.GetCellValue(Row, "bl_no");
			var bkgNo=sheet1.GetCellValue(Row, "bkg_no");
			var umchBkgSeq=sheet1.GetCellValue(Row, "umch_bkg_seq");
			var rdnNo=sheet1.GetCellValue(Row, "rdn_no");
			var rctRhqCd=sheet1.GetCellValue(Row, "rct_rhq_cd");
			var rctOfcCd=sheet1.GetCellValue(Row, "bkg_ofc_cd");
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
    	        	comRASCallPop(pgmNo, "ESM_BKG_0256", popParams, "");
    				break;
    			case "bl_no":
    	        	if(null == bkgNo || "" == bkgNo) { return; }
		         	var popParams="bkg_no=" + bkgNo + "&openTab=B9";
    	        	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0256", popParams, "");
    				break;
				case "bkg_contract_bk":
    	    		var popParams="bl_no=" + blNo + "&bkg_no=" + bkgNo + "&umch_bkg_seq=" + umchBkgSeq;
					comRASCallPop("ESM_BKG_1049", "ESM_BKG_0256", popParams, "");
					break;
				case "diff_usd_amt":
					var popParams="bkg_no="+bkgNo+"&umch_bkg_seq="+umchBkgSeq;
					comRASCallPop("ESM_BKG_0698", "ESM_BKG_0256", popParams, "");
					break;
				case "self_audit":
//					var popParams = "bl_no="+blNo+"&umch_bkg_seq="+umchBkgSeq;   /*추가*/
//					comRASCallPop("ESM_BKG_0263", "ESM_BKG_0256", popParams, "");
//					break;
					var _Width='1000';
					var _Height='728';
					var pgmNo="&pgmNo=ESM_BKG_0263";
					var popParams="bl_no="+blNo+"&umch_bkg_seq="+umchBkgSeq+"&ca_flg=N"; 
					var url="ESM_BKG_0263.do?" + popParams + pgmNo;
					ComOpenPopupWithTarget(url, _Width, _Height, "","none",false);
					break;
				case "rdn_no":
				    //B/L No ( <- B/L No ), Receipt RHQ ( <- RHQ ), Receipt Office( <- Office ), Responsible RHQ ( <- RHQ ), Responsible Office ( <- Office ) 항목 복사해 줌
					var popParams="rdn_no=" + rdnNo + "&bl_no=" + blNo + "&rct_rhq_cd=" + rctRhqCd + "&rct_ofc_cd=" + rctOfcCd;
    	    		comRASCallPop("ESM_BKG_0426", "ESM_BKG_0256", popParams, "");
					break;
			}
    	}
    	/** 
         * sheet1 search end event handler
         */
    	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
			ComOpenWait(false);
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
			if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_al"))) { unmatch_al++; }
			if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_all"))) { unmatch_all++; }
			if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_b"))) { unmatch_b++; }
			if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_c"))) { unmatch_c++; }
			if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_d"))) { unmatch_d++; }
			if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_e"))) { unmatch_e++; }
			if(!ComIsEmpty(sheetObj.GetCellValue(i,"umch_f"))) { unmatch_f++; }
			if(sheetObj.GetCellValue(i, "rev_aud_sts_cd") != "U") {
	 				sheetObj.SetCellEditable(i, "chk",0);
	 				sheetObj.SetCellBackColor(i, "chk","#EFF0F3");
	 			}
	 		}
			//total
			unmatched_bl_count=sheetObj.GetTotalRows();
			unmatched_case_count=unmatch_al + unmatch_all +unmatch_b + unmatch_c + unmatch_d + unmatch_e + unmatch_f;  //수정
			formObj.unmatched_bl_count.value=ComAddComma(unmatched_bl_count);
			formObj.unmatched_case_count.value=ComAddComma(unmatched_case_count);
			formObj.unmatch_al.value=ComAddComma(unmatch_al);
			formObj.unmatch_all.value=ComAddComma(unmatch_all);
			formObj.unmatch_b.value=ComAddComma(unmatch_b);
			formObj.unmatch_c.value=ComAddComma(unmatch_c);
			formObj.unmatch_d.value=ComAddComma(unmatch_d);
			formObj.unmatch_e.value=ComAddComma(unmatch_e);
			formObj.unmatch_f.value=ComAddComma(unmatch_f);
		}
 	 	/**
 	     * OnClick event function <br>
 	     */  	           
 	     function sheet1_OnClick(sheetObj, Row, Col, Value) {
 		    var colname=sheetObj.ColSaveName(Col);
 	     	switch(colname){
 	 	    	case "umch_rsn_rmk":
 	 	    		ComShowMemoPad(sheetObj,Row,Col,true,200,200); 
 	 	    		break;
 	 	    	case "rgn_grp_avc_rmk":
 	 	    		ComShowMemoPad(sheetObj,Row,Col,false,200,200);
 	 	    		break;
 	     	}    	 
 	    }
/**
 * OnMouseDown event function <br>
 */  	           
		function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
			var rowIdx=sheetObj.MouseRow();
			var colIdx=sheetObj.MouseCol();
			if( rowIdx == 0 && (13 < colIdx && colIdx < 15) ) {
				var popParams="";
				comRASCallPop("ESM_BKG_1055", "ESM_BKG_0256", popParams, "")		
			}
		}
 	     /**
		 * remove All 
		 */
  	 	function removeAll(formObj) {
  	 		//self.location.reload();
  	 		formObj.reset();
  	 		comboObjects[1].RemoveAll(); 
  	 		comboObjects[0].SetSelectIndex("-1");
  	 		comboObjects[2].SetSelectIndex("-1");
  	 		comboObjects[3].SetSelectIndex("-1");
  	 		comboObjects[4].SetSelectIndex("-1");
  	 		comboObjects[5].SetSelectCode("-1");
  	 		comboObjects[6].SetSelectIndex("U");
  	 		comboObjects[7].SetSelectIndex("-1");
 	 		sheetObjects[1].RemoveAll();
  		} 
  	 	/**
  	     * radio btn click event function
  	     */ 	
  	 	function obj_click()
  	 	{	 		
  	 		setAuditSeqCd(document.form);
  	  	}
  	 	/**
  	     * Setting Error Seq
  	     */
  	 	function setAuditSeqCd(formObj) {
  	 		if (formObj.audit_seq_radio[0].checked == true){
  	        	formObj.audit_seq_cd.value=formObj.audit_seq_radio[0].value;
  	        } else if(formObj.audit_seq_radio[1].checked == true) {
  	        	formObj.audit_seq_cd.value=formObj.audit_seq_radio[1].value;
  	        }
  	 	}
  	 	/**
  	     * reset UnMatch Detail value 
  	     */
  	    function resetUnMatchDetail() {
  	    	var sheetObj=sheetObjects[1];
  	    	for (var i=sheetObj.HeaderRows()-1, n=sheetObj.HeaderRows()+sheetObj.RowCount(); i < n; i++) {
  	    		sheetObj.SetCellValue(i, "bkg_contract_bk","");
  	    	}
  	    }
  	    
  	    //BackEndJob 상태 조회용 루프 함수
  	    function callIntervalBackEndJob() {
  	    	if (300==processCnt++) {  //intervalTime(3초) * 600 = 30분
  	    		clearInterval(intervalId);
  	    		ComOpenWait(false);
  	    		return;
  	    	}
  	        doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
  	    }