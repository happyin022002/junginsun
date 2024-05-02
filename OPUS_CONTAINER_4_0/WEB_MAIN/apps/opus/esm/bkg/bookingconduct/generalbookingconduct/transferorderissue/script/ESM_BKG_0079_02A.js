/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0079_02A.js
*@FileTitle  : TRO(Transportation Request Order) for General
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author 
     */
    // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
	//---------------------------------
    //Global Variables
    var x_sheetObject1=null; 
    var x_sheetObject2=null;
    var x_sheetObject3=null;
    var x_sheetObject4=null;
    var x_sheetObject5=null;
    var x_sheetObjMsg=null;
    var x_oldTroSeq="";   //old tro_seq value   
    var x_cancelAllFlg="N";  //Y:cancelAll 
    var xNessColor="#CCFFFD";
    var tab_alert_msg=false; // Presence of a message
    // Event handler processing by button click event */
    document.onclick=checkLoad;
	function checkLoad(){	//'target' undefined error
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
    // Event handler processing by button name */
    function processButtonClick(){
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (srcName == "" || srcName == undefined)
    			return;
    		if(ComGetBtnDisable(srcName)) return false;
    		
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display == ""){
        			layList.style.display="none";
        		}  
    		}
    		switch(srcName) {
				case "btn_splitPop":
					doActionIBSheet(x_sheetObjMsg, formObject, COMMAND03);	
					break; 
			    case "btn_Danger":
			    	if(checkTdUnLink(srcName)) return false;    
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
//			    	comBkgCallPop0200(bkgNo, caFlg);
					var url="ESM_BKG_0200_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0200_POP", 1280, 682, false);
			    	break;
			    case "btn_Reefer":
			    	if(checkTdUnLink(srcName)) return false;    		
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
//			    	comBkgCallPop0498(bkgNo, caFlg);
					var url="ESM_BKG_0498_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0498_POP", 1280, 682, false);
			    	break;
			    case "btn_Awkward":
			    	if(checkTdUnLink(srcName)) return false;    	
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
			    	var url="ESM_BKG_0055_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0055_POP", 1280, 682, false);
//			    	comBkgCallPop0055(bkgNo, caFlg);
			    	break;
			    case "btn_Bulk":
			    	if(checkTdUnLink(srcName)) return false;  
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
//			    	comBkgCallPop0106(bkgNo, caFlg);
					var url="ESM_BKG_0106_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0106_POP", 1280, 682, false);
			    	break;
				case "btn_t2aAdd":
					if(checkTdDisabled(srcName)) return false;
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					addRow(x_sheetObject1);   
					break;
				case "btn_t2aDelete":
					if(checkTdDisabled(srcName)) return false;					
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					var nRow=x_sheetObject1.CheckedRows("del_chk");
					if (nRow <= 0) {
						ComShowCodeMessage("BKG00567");
						return false;
					}					
					if (!ComShowCodeConfirm("COM12194", "")) {
        	    		return false;
        	    	} 
				    cancelDtl();
				    doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y");
					break;
				case "btn_t2aCopy": 
					if(checkTdDisabled(srcName)) return false;	
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					var bResult=checkCopySumTroqty(x_sheetObject1);
					if (!bResult) {						
						return false;
					}
					copyRow(x_sheetObject1);
					break;
				case "btn_retrieve":
					if(checkTdDisabled(srcName)) return false;						
					formObject.curr_tro_seq.value=""; 
					doActionIBSheet(x_sheetObject2, formObject, IBSEARCH);
					break;
				case "btn_t2aSave":	
					doActionIBSheet(x_sheetObject2, formObject, IBSAVE);
					break;
				case "btn_t2aSaveSeq": 
				    doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "C");
					break;
				case "btn_t2aSaveConfirm":
					if(checkTdDisabled(srcName)) return false;					
					if (!ComBkgProcessYn("All Confirm & Save")) {
        	    		return false;
        	    	}
					confirmSave();
					break;
				case "btn_t2aCancelAll":
					if(checkTdDisabled(srcName)) return false;					
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}						
					if (x_cancelAllFlg == "Y") {
						callShowMessageReProc("Cancel All");
						return false;
					}
					if (!ComBkgProcessYn("CANCEL All")) {
        	    		return false;
        	    	} 
					cancelAll();
					doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y");
					break;
				case "btn_t2aTROCopy":		
                    if(checkTdDisabled(srcName)) return false;
					var bkgNo=nullToBlank(formObject.bkg_no.value);
					var bkgNoOld=nullToBlank(formObject.oldBkgNo.value); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkgNo != bkgNoOld) {
						ComShowCodeMessage("BKG00048", bkgNoOld, bkgNo);
						ComSetFocus(bkg_no);
						return false;
					}
					var boundCd=""; 
					var troSeq=nullToBlank(tro_seq.GetSelectText());
					var uiId="ESM_BKG_0079_02A";
					comBkgCallPop0920('setTroCopy', bkgNo, boundCd, troSeq, uiId); 
					break;
				case "btn_t2aAddSeq":
					if(checkTdDisabled(srcName)) return false;
					addRow(x_sheetObject2);   
					break;
				case "btn_t2aCopySeq":
					if(checkTdDisabled(srcName)) return false;					
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}
					var bResult=checkCopySumTroqty(x_sheetObject2);
					if (!bResult) {
						return false;  
					}
					copyRow(x_sheetObject2);
					break;
				case "btn_t2aCancelSeq":	
					if(checkTdDisabled(srcName)) return false;					
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddSeq();
						return false;
					}						
					if (formObject.cxl_flg.checked) {
						callShowMessageReProc("Cancel Seq");
						return false; 
					}
					if (!ComBkgProcessYn("CANCEL Seq")) {
        	    		return false;
        	    	} 
			        cancelSeq();
			        doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y");
					break;
				case "btns_popActCust":
					if(checkInputDisabled("act_shpr_nm")) return false; 
					var conti_cd=document.form.conti_cd.value;     
					var cnt_cd=document.form.por_cd.value.substr(0,2);  
					var dor_loc_cd=document.form.dor_loc_cd.value; 
					var act_shpr_cnt_cd=document.form.act_shpr_cnt_cd.value; 
					var act_shpr_seq=document.form.act_shpr_seq.value; 
					var act_shpr_nm=document.form.act_shpr_nm.value; 
					var arrAct_shpr_nm=act_shpr_nm.split(" ");
					act_shpr_nm=arrAct_shpr_nm[0];
					var bkg_no=nullToBlank(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank(formObject.oldBkgNo.value); 
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					var type = "A";		//02A
					comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm,type);
					break;
				case "btns_popLocation":					
					if(checkInputDisabled("zn_cd")) return false;					
					var cnt_cd=document.form.por_cd.value.substr(0,2);  //Country code -> Disabled
					var node_cd="";
					var dor_loc_cd=formObject.dor_loc_cd.value;
					var zn_cd=formObject.zn_cd.value;					
					if (dor_loc_cd.length == 5 && zn_cd.length == 2) { 
						node=dor_loc_cd+zn_cd; 
					}					
					var param="";
					param += "?cnt_cd="    + cnt_cd;
					param += "&loc_cd="    + dor_loc_cd;
					param += "&ofc_cd="    + "N";
					param += "&node_cd="   + node_cd;
					param += "&mode="      + "zone";
					param += "&mode_only=" + "Y";
					ComOpenPopup("/opuscntr/COM_ENS_061.do"+param, 780, 470, 'getCOM_ENS_061_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;	
            }
    	}catch(e) {
    		if( e.name == "TypeError") {
    			return false;
    		}else{
        		ComShowMessage(e);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**    
     * registering IBCombo Object as list
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
     	var formObj=document.form;
   	    //Button link / button, the output ------------->
   	    changeDisplayBtn("btn_Danger",  "N");
   	    changeDisplayBtn("btn_Reefer",  "N");
   	    changeDisplayBtn("btn_Awkward", "N");
   	    changeDisplayBtn("btn_Bulk",    "N");
   	    //<----------------------------------
         for(var i=0; i<sheetObjects.length; i++){
             //ComConfigSheet   (sheetObjects[i]);
             initSheet        (sheetObjects[i], i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         //---------------
         //IBMultiCombo initialization
         for(var k=0;k<comboObjects.length;k++){
             initCombo(comboObjects[k],k+1);
         } 
        //*****  Tab ->two or more sheet : sheet  a variable assignment *****
 	   	x_sheetObject5=sheetObjects[0];  //sum_qty Screen
 	   	x_sheetObject1=sheetObjects[1];  //tro_dtl Screen 
 	   	x_sheetObject2=sheetObjects[2];  //tro all hidden
 	   	x_sheetObject3=sheetObjects[3];  //tro_dtl all hidden
 	   	x_sheetObject4=sheetObjects[4];  //tro_dg_seq all hidden
 	    x_sheetObjMsg=sheetObjects[5];  //msg hidden
        //**************************************************************
 	   	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form); 
 	   	axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form); 
 	   	axon_event.addListenerForm  ('click',    'obj_click',        document.form);
  	    axon_event.addListenerForm	('keydown',  'check_Enter', 	 document.form);
 		axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate'	, document.form); 
 	   	if (formObj.bkg_no.value != "" || formObj.bl_no.value != "") {
 	   		formObj.curr_tro_seq.value="";  //Seq default clear
             doActionIBSheet(x_sheetObject2, document.form, IBSEARCH);
 	   	} else {
 	   		//Search button enabled
 	   		ComEnableManyTd(true,  "btn_retrieve");
 	   		ComEnableManyTd(false, "btn_t2aSave", "btn_t2aSaveSeq", 
 	   				                "btn_t2aSaveConfirm", "btn_t2aCancelAll", "btn_t2aTROCopy", 
                                    "btn_t2aAddSeq", "btn_t2aCopySeq", "btn_t2aCancelSeq", 
                                    "btn_t2aAdd", "btn_t2aDelete", "btn_t2aCopy");
 	   	}
     	//------------------------------------------------>
     	//setInquiryDisableButton event call
     	if(ComGetObjValue(document.form.isInquiry) == "Y"){
     		setInquiryDisableButton();
     	}
    	initControl();
    }
	function initControl() {
		applyShortcut();
		inputEngSet();
	}
	
    var inputEngSet = function(){
        $("[data-eng='on']").keyup(function(event){
    	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
    	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
    		                                 var inputVal = $(this).val();
    	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
    	                                 }
                             });
       }	 	
	//  OnKeyPress Event
	function obj_keypress_loc() {
		switch(event.srcElement.dataformat){
	       case "float":
	           //Number + "." To enter
	           ComKeyOnlyNumber(event.srcElement, ".");
	           break;
	       case "eng":
	           //English only to enter, alphabet + number -> ComKeyOnlyAlphabet('num');
	           ComKeyOnlyAlphabet();
	           break;
	       case "engdn":
	           //English lowercase to enter , English lowercase + number -> ComKeyOnlyAlphabet('lowernum');
	           ComKeyOnlyAlphabet('lower');
	           break;
	       case "engup":
	           //enter only uppercase letters in English
	           ComKeyOnlyAlphabet('upper');
	           break;
	       case "int":
	           //only numbers Input(integer, date, time)
	           ComKeyOnlyNumber(event.srcElement);
	           break;
	       case "uppernum":
	           //Capital letters + numbers
	           ComKeyOnlyAlphabet('uppernum'); 
	           break;
	       case "tel":
		        // Number + "-" to enter
		        ComKeyOnlyNumber(event.srcElement, " -"); 
		        break;
           case "engupspecial": // English uppercase characters+Number + Space + &*-,./
	   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
	    	   break;
		}
	}
	function obj_keyup() {
		var formObj=document.form;
		with (formObj) {
			if (event.srcElement.type == "textarea") {
				return;
			}
			if ( window.event.keyCode == 13 ) { 
				formObj.curr_tro_seq.value="";  //Seq default clear
		    }
		}
	}   
	function obj_click() {
		var formObj=document.form;
		with(formObj) {
			switch(ComGetEvent("name")){
	            case "cfm_flg":
	            	//var strToDay = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm"); 
	            	//------------------------------------------------>
	            	var bReturn=doActionIBSheet(x_sheetObjMsg, formObj, COMMAND09);	            	
	            	var strToDay=formObj.cfm_sys_date.value;              
	            	//<------------------------------------------------	            	
	            	var bResult=setCfmCheck(strToDay); 
	            	break;
			}
		}
	}
    function initCombo(comboObj, comboNo) {
    	with (comboObj) {
    		SetMultiSeparator("|");
	    	switch(comboObj.options.id) {
			    case "tro_seq" : 
		    		SetColWidth(0, "46");
		        break;
	    	    case "dcgo_seq" : 
	    	    	SetColWidth(0, "60");
	    	    	SetColWidth(1, "280");
	    	    	SetTitleVisible(true);
	                SetTitle("seq|Remark");
	                SetMultiSelect(1);
    	        break;
	    	    case "rc_seq" : 
					SetColWidth(0, "60");
					SetColWidth(1, "380");
					SetTitleVisible(true);
	    	    	SetTitle("seq|Remark");
	    	    	SetMultiSelect(1);
	    	    break;
	    	    case "awk_cgo_seq" : 
	    	    	SetColWidth(0, "70");
	    	    	SetMultiSelect(1);
	    	        break;
	    	}
        }
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
    	switch(sheetObj.id) {
    		case "t2asheet1":      //t2asheet1 init  
    		    with(sheetObj){
	    	      var HeadTitle="|Sel.|||Seq.|Del|TP/SZ|Q'ty|Door Arrival Date|Door Arrival Date|Pick-Up Date|Pick-Up Date|"+
	    	      "Pick Up CY|Pick Up CY|Return CY|Return CY|CMDT|CNTR No.|Moved by Split|"+
	    	      "S/O|S/O|S/O|S/O|W/O|W/O|W/O|Frustrate|Rail S/O|COP No|||||";
	
	    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	      InitHeaders(headers, info);
	
	    	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	    	             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_sub_seq",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	    	             {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
	    	             {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt",          KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt_hhmi",     KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pkup_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt_hhmi",        KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rtn_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	    	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
	    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"split_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"so_cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:16 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"so_cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	    	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"so_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	    	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rail_so",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cop_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_old",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty_old",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
	    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg_old",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
	    	            ,{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id_old",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
	    	            ,{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt_old",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
	    	             ];
	    	       
	    	      InitColumns(cols);
	
	    	      SetEditable(1);
	    	      //SetColProperty("dor_arr_dt", {Format:"####-##-##"} );
	    	      SetWaitImageVisible(0);
	    	      sheetObj.SetColHidden("chk",1);
	    	      sheetObj.SetColHidden("tro_seq",1);
	    	      //conversion of function[check again]CLT 					InitDataValid(0, "cntr_tpsz_cd", vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	    	      SetColProperty("cntr_tpsz_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
	    	      //conversion of function[check again]CLT 					InitDataValid(0, "pkup_loc_cd",  vtEngUpOnly);
	    	      SetColProperty("pkup_loc_cd", {AcceptKeys : "E", InputCaseSensitive :1} );
	    	      //conversion of function[check again]CLT 					InitDataValid(0, "pkup_yd_cd",   vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	    	      SetColProperty("pkup_yd_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
	    	      //conversion of function[check again]CLT 					InitDataValid(0, "rtn_loc_cd",   vtEngUpOnly);
	    	      SetColProperty("rtn_loc_cd", {AcceptKeys : "E", InputCaseSensitive :1} );
	    	      //conversion of function[check again]CLT 					InitDataValid(0, "rtn_yd_cd",    vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	    	      SetColProperty("rtn_yd_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
	    	      //conversion of function[check again]CLT 					InitDataValid(0, "cmdt_cd",      vtNumericOnly);
	    	      SetColProperty("cmdt_cd", {AcceptKeys : "N"} );
	    	      //conversion of function[check again]CLT 					InitDataValid(0, "cntr_no",      vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	    	      SetColProperty("cntr_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );

	    	      SetShowButtonImage(2);
	    	      SetSheetHeight(160);
//	    	      updateSheetSize(sheetObj);
	    	      
    	      }


    		    break;
    		case "t2asheet2":      //t2asheet2 init : all-master <hidden>  
    		    with(sheetObj){
	    	      var HeadTitle=" |tro_seq|rcv_term_cd|rqst_dt|so_flg|ownr_trk_flg|biz_rgst_no|cntc_mphn_no|"+
	    	      "act_shpr_cnt_cd|act_shpr_seq|act_shpr_nm|dor_loc_cd|zn_cd|dor_pst_no|"+
	    	      "cfm_flg|cfm_dt|act_shpr_addr|diff_rmk|cntc_pson_nm|cntc_phn_no|cntc_fax_no|"+
	    	      "cxl_flg|cfm_flg_old|cxl_flg_old|||drp_and_pk_flg|tri_axl_req_flg|drp_and_pk_flg_old|tri_axl_req_flg_old";
	
	    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	      InitHeaders(headers, info);
	
	    	      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"rcv_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rqst_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"so_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ownr_trk_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"biz_rgst_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"cntc_mphn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"dor_loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"zn_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"dor_pst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"act_shpr_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_phn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntc_fax_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cfm_flg_old",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg_old",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"pickup_cy_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"return_cy_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"drp_and_pk_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tri_axl_req_flg", 	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"drp_and_pk_flg_old",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tri_axl_req_flg_old",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 }
	    	            ,{Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id_old",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }
	    	            ,{Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt_old",  			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }
	    	             ];
	    	       
	    	      InitColumns(cols);
	
	    	      SetEditable(0);
	    	      SetVisible(0);
    	      }


			    break;
    		case "t2asheet3":      //t2asheet3 init : all-detail <hidden>   			
    		    with(sheetObj){
	    	      var HeadTitle="|Sel.||Seq.|SubSeq|Del|TP/SZ|Q'ty|Door Arrival Date|Door Arrival Date|Pick-Up Date|Pick-Up Date|"+
	    	      "Pick Up CY|Pick Up CY|Return CY|Return CY|CMDT|CNTR No.|Moved by Split|"+
	    	      "S/O|S/O|S/O|S/O|W/O|W/O|W/O||||";
	
	    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	      InitHeaders(headers, info);
	
	    	      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	    	             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_sub_seq",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt_hhmi",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt",          	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pkup_dt_hhmi",        KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rtn_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"split_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
	    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"so_cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"so_cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"so_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	    	             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trsp_wo_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rail_so",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cop_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_old",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	    	             {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty_old",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 },
	    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cxl_flg_old",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
	    	            ,{Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id_old",	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
	    	            ,{Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt_old",		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
	    	             ];
	    	       
	    	      InitColumns(cols);
	
	    	      SetEditable(0);
	    	      SetColProperty("dor_arr_dt", {Format:"####-##-##"} );
	    	      SetColProperty("pkup_dt", {Format:"####-##-##"} );
	    	      SetWaitImageVisible(0);
	    	      SetVisible(0);
    	      }


		        break;	
    		case "t2asheet4":      //t2asheet4 init : tro_dg_seq all <hidden>  
                with(sheetObj){
					var HeadTitle=" | | | |";  //4 cols
					
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					{Type:"DummyCheck", Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"spcl_cgo_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"spcl_cgo_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					
					InitColumns(cols);
					
					SetEditable(0);
					SetWaitImageVisible(0);
					SetVisible(0);
				}
			    break;
    		case "t2asheet5":      //t2asheet5 init : sum_qty grid
                with(sheetObj){
					var HeadTitle="TP/SZ|Total Qty|TRO Qty";  //3 cols
					
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Int",       Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:"total_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Int",       Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"tro_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					
					InitColumns(cols);
					
					SetEditable(1);
					SetWaitImageVisible(0);
	                SetSheetHeight(112);
	                FitColWidth();
	            	SetCountPosition(0);

    			}


			    break;
     		case "t2amsgsheet1":      //t2amsgsheet1 init : msg grid
     		    with(sheetObj){
		     	      var HeadTitle="STATUS";
		
		     	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		     	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		     	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		     	      InitHeaders(headers, info);
		
		     	      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		     	       
		     	      InitColumns(cols);
		
		     	      SetEditable(0);
		     	      SetWaitImageVisible(0);
		     	     SetVisible(0);
   	            }
			    break;
    	}    	
    }
    
    function updateSheetSize(sheetObj){
    	  if(typeof sheetObj == "undefined") {
    		  sheetObj = sheetObjects[1];
    	  }
    	  var obj = $("#" + sheetObj.id).offset();
    	  var marginDefault = 160;
    	  var marginHeight = obj.top + marginDefault;
    	  var winHeight = $(parent.window).height();
    	  var sheetHeight = winHeight - marginHeight;

    	  with(sheetObj){
    		SetSheetHeight(sheetHeight > 90?sheetHeight:90);
    	  }    
    }            
    
    // Sheet handling process
    function doActionIBSheet(sheetObj, formObj, sAction, delFlg) {
    	if (delFlg == null) {
    		delFlg="N";
    	}
   //     sheetObj.ShowDebugMsg = 1;
        switch(sAction) {
			case COMMAND03:      //retrieve booking_split_no 
				formObj.f_cmd.value=COMMAND03;				
				var param="f_cmd=" + COMMAND03 + "&bkg_no=" + formObj.bkg_no.value;  
 			    var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02AGS.do", param);
			 	var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
			 	bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -23); 
			 	break;	
			case COMMAND09:      //retrieve system_date(local) 
				formObj.f_cmd.value=COMMAND09;
 			 	var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02AGS.do", FormQueryString(formObj));
			 	formObj.cfm_sys_date.value=ComGetEtcData(sXml, "cfm_sys_date");
			 	break;	
          	case IBSEARCH: 
          	    if(!validateForm(sheetObj,formObj,sAction)) return;  	
          	    initSearchVal(); 
				formObj.f_cmd.value=SEARCH;    		
				ComOpenWait(true);
				var parm="f_cmd=" + SEARCH + "&bkg_no=" + formObj.bkg_no.value + "&io_bnd_cd=" + "O"  + "&rtn_tro_flg=" + "N" + "&curr_tro_seq" + formObj.curr_tro_seq.value ;	
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02AGS.do", parm);
				var arrXml=sXml.split("|$$|");  
				ComOpenWait(false);				
				if(ComGetEtcData(arrXml[0], "DataYn") == "N") {					
					x_sheetObjMsg.LoadSearchData(arrXml[0],{Sync:1} );
					formObj.bkg_no.value=formObj.oldBkgNo.value;
					formObj.bl_no.value=formObj.oldBlNo.value;
					return;
				} 
				//(Retrieve all information): Start------------------------------------------>
                if (arrXml.length > 0) 
				{ 
                    x_sheetObject4.LoadSearchData(arrXml[2],{Sync:1} );
                    ComBkgXml2ComboItem(arrXml[3], dcgo_seq,    "display_nm", "dg_seq"); 
                    ComBkgXml2ComboItem(arrXml[4], rc_seq,      "display_nm", "rf_seq"); 
                    ComBkgXml2ComboItem(arrXml[5], awk_cgo_seq, "awk_seq",    "awk_seq"); 
                    ComBkgXml2ComboItem(arrXml[0], tro_seq,     "tro_seq",    "tro_seq");  
                	x_sheetObject2.LoadSearchData(arrXml[0],{Sync:1} );
                    setEtcDataToForm_bkg(formObj, x_sheetObject2);
                    //max_tro_seq_old : setting
                    var max_tro_seq_old=x_sheetObject2.GetCellValue(x_sheetObject2.RowCount(), "tro_seq");
                    formObj.max_tro_seq_old.value=(nullToBlank(max_tro_seq_old.trim())=="")? "0": max_tro_seq_old;
                    setDataToForm_TroMst(x_sheetObject2.GetCellValue(1, "tro_seq"));
                }
                if (arrXml.length > 1) 
				{
                	x_sheetObject3.LoadSearchData(arrXml[1],{Sync:1} );
                	changeMasterColor();  
                	setAllDataToData_TroDtl(tro_seq.GetSelectText());
                } 
                //<--------------------------------------------(Retrieve all information): End 
                x_sheetObject5.LoadSearchData(arrXml[6],{Sync:1} );
                changeTroQtyColor(x_sheetObject5);
                checkTroQty(x_sheetObject5);
                if (formObj.tro_seq_maxcnt.value == "0") {
                	addRow(x_sheetObject2); 
                } else {
                	if (formObj.curr_tro_seq.value != "") { 
                		tro_seq.SetSelectText(formObj.curr_tro_seq.value);//default seq set : onchange!!!!!!!!
                	}
                }
                if('X' == ComGetObjValue(formObj.bkg_sts_cd)){
                	ComEnableManyTd(false ,"btn_retrieve","btn_t2aSave","btn_t2aSaveSeq","btn_t2aSaveConfirm","btn_t2aCancelAll","btn_t2aTROCopy","btn_t2aAddSeq","btn_t2aCopySeq","btn_t2aCancelSeq");
                }else{
                	ComEnableManyTd(true ,"btn_retrieve","btn_t2aSave","btn_t2aSaveSeq","btn_t2aSaveConfirm","btn_t2aCancelAll","btn_t2aTROCopy","btn_t2aAddSeq","btn_t2aCopySeq","btn_t2aCancelSeq");
                }
                ComSetObjValue(formObj.modify_flag, "N");
                fnOnSearchEnd();
             	//------------------------------------------------>
             	//setInquiryDisableButton event call
             	if(ComGetObjValue(document.form.isInquiry) == "Y"){
             		setInquiryDisableButton();
             	}
                //2) C/A Button Control
				parent.initCAControl(ComGetEtcData(arrXml[0], "bkg_no"), 
						             ComGetEtcData(arrXml[0], "ca_flg"), 
						             ComGetEtcData(arrXml[0], "bdr_flg"), 
						             ComGetEtcData(arrXml[0], "ca_exist_flg"), 
						             ComGetEtcData(arrXml[0], "bl_no"));
                break;
     		case IBSAVE: 
				var currTroSeq=tro_seq.GetSelectText();
                setFormToData_Tro_dg_seq(currTroSeq); 
                x_sheetObject4.ColumnSort("tro_seq|spcl_cgo_cd|spcl_cgo_seq");
	        	setFormToData_TroMst(currTroSeq); 
     		    setDataToAllData_TroDtl(currTroSeq, false);      
				x_sheetObject3.ColumnSort("tro_seq|tro_sub_seq");
				if (delFlg == "C") {
					for (var i=1; i<=x_sheetObject2.RowCount(); i++) {
						if (x_sheetObject2.GetCellValue(i, "tro_seq") != currTroSeq) {
							x_sheetObject2.SetRowStatus(i,"R");
						}
	     		    }
					for (var i=1; i<=x_sheetObject3.RowCount(); i++) {
						if (x_sheetObject3.GetCellValue(i, "tro_seq") != currTroSeq) {
							x_sheetObject3.SetRowStatus(i,"R");
						}
	     		    }
					for (var i=1; i<=x_sheetObject4.RowCount(); i++) {
						if (x_sheetObject4.GetCellValue(i, "tro_seq") != currTroSeq) {
							x_sheetObject4.SetRowStatus(i,"R");
						}
	     		    }
				} else {
	     		    for (var i=1; i<=x_sheetObject4.RowCount(); i++) {
	     		    	x_sheetObject4.SetRowStatus(i,"I");
	     		    }
				}
				if(!validateForm(sheetObj, formObj, sAction, delFlg)) return;
          		//(containerVO)----------------------------------------->
          	    formObj.f_cmd.value=MULTI;           	  
          	    //formObj.f_del_flg.value    = delFlg;               
          	    formObj.curr_tro_seq.value=tro_seq.GetSelectText();
          	    var sheetSaveObjects=new Array();
          	    sheetSaveObjects[0]=x_sheetObject2;
          	    sheetSaveObjects[1]=x_sheetObject3;
          	    sheetSaveObjects[2]=x_sheetObject4;
				fnSetPickupReturn_no();
          	    var sParam1=ComSetPrifix(x_sheetObject2.GetSaveString(true), "t2asheet2_");  //allSave
          	    var sParam2=ComSetPrifix(x_sheetObject3.GetSaveString(true), "t2asheet3_");  //allSave
          	    var sParam3=ComSetPrifix(x_sheetObject4.GetSaveString(),     "t2asheet4_");
          	    //if (sParam1+sParam2+sParam3 == "") return;
          	    //var sParam = FormQueryString(formObj);
          	    var sParam="f_cmd=" + MULTI 
	    			+ "&bkg_no=" + formObj.bkg_no.value
	    			+ "&oldBkgNo=" + formObj.oldBkgNo.value
	    			+ "&io_bnd_cd=" + formObj.io_bnd_cd.value
	    			+ "&rtn_tro_flg=" + "N" 
	    			+ "&f_del_flg=" + formObj.f_del_flg.value
	    			+ "&curr_tro_seq=" + formObj.curr_tro_seq.value
	    			;
          		sParam += "&" + sParam1; 
          	    sParam += "&" + sParam2; 
          	    sParam += "&" + sParam3; 
           		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_02AGS.do", sParam);
           		sheetSaveObjects[0].LoadSaveData(sXml);
          		//<------------------------------------------(containerVO)
          		doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
          		break; 
        }
    }
    //Initialization
    function initSearchVal() {
    	var formObj=document.form;
    	//Global Variables clear -> OnLoad state
    	x_oldTroSeq=""; 
        x_cancelAllFlg="N";  //Y:cancelAll
    }    
    //######################[1. Event]############################################################
    /**
    * Tro master : tro_seq combo onchange event
    */
    function tro_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	changeTroSeqProc(); 
    	fnCheckTrsp_so_no();
    	fnSetPickupReturn_no();    
    }
    function changeTroSeqProc() {    	
    	var comboObj=tro_seq; 
    	//----------------------
    	//1)  Retrieve Tro_seq selected after change 
		var currTroSeq=comboObj.GetSelectText();
    	//----------------------
    	//2) tro-master  
		if (x_oldTroSeq != "") {
    	    setFormToData_TroMst(x_oldTroSeq);
		}
    	setDataToForm_TroMst(currTroSeq);          //tro-master Form Output Changes(Selected tro_seq) 
    	//----------------------
    	//3) cxl_flg checkbox : Master modify - true/false  	
    	changeMasterColor();
    	//----------------------
    	//4) tro-detail
    	if (x_oldTroSeq != "") {
    	    setDataToAllData_TroDtl(x_oldTroSeq);  //dtl(store) : display->hidden all 
    	}
    	setAllDataToData_TroDtl(currTroSeq);       //dtl(load)  : hidden all->display        	
    	//----------------------
    	//5) tro/tro-detail 
    	x_oldTroSeq=comboObj.GetSelectText();  //currTroSeq
    }
    /**
     * fnSetPickupReturn_no :  Event
     */
    function fnSetPickupReturn_no() {
    	var mstSheetObj=x_sheetObject2; 
    	var dtlsheetObj=x_sheetObject1; 
    	var comboObj=tro_seq; 
    	var formObj=document.form;
    	//----------------------
    	//1)  Retrieve Tro_seq selected after change 
		var tro_seq_index=comboObj.GetSelectText();
    	//-----------------------------------
    	var nRow=mstSheetObj.FindText("tro_seq", tro_seq_index);
    	if(nRow > 0){
    		mstSheetObj.SetCellValue(nRow, "pickup_cy_no",formObj.pickup_cy1.value + formObj.pickup_cy2.value ,0);
    		mstSheetObj.SetCellValue(nRow, "return_cy_no",formObj.return_cy1.value + formObj.return_cy2.value,0);
    	}
    }
    /**
    ;
    /**
    * Tro master :  dcgo_seq Multi Combo  Check event  
    */
    function dcgo_seq_OnCheckClick(comboObj, idx_cd, text) {
    	var formObj=document.form;
    	setAddRemarkText(comboObj, idx_cd, text);     	
    	setComboBackColor(dcgo_seq);
    }
    /**
    * Tro master : rc_seq Multi Combo  Check event  
    */
    function rc_seq_OnCheckClick(comboObj, idx_cd, text) {
    	var formObj=document.form; 
    	setAddRemarkText(comboObj, idx_cd, text); 
    	setComboBackColor(rc_seq);	
    }    
    /**
    * Tro master : awk_cgo_seq Multi Combo  Change event  
    */
    function awk_cgo_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {    	
    	var formObj=document.form; 
    	setComboBackColor(awk_cgo_seq);	    
    } 
    /**
    * Save and re-viewed
    */    
    function t2asheet2_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg.length > 9 && ErrMsg.substr(0,9) == "[Success]") {
    		doActionIBSheet(x_sheetObject2, document.form, IBSEARCH); 
    	}
    }
    function fnOnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		with(formObj) { 
		    if (fd_grd_flg.value == "Y" && spcl_hide_flg.value == "Y") {
    			if (diff_rmk.value == "") {
    			    diff_rmk.value="Food Grade, Hide ";
    			}
		    } 
		    else if (fd_grd_flg.value == "Y") {
    			if (diff_rmk.value == "") {
    			    diff_rmk.value="Food Grade ";
    			}
		    }
		    else if (spcl_hide_flg.value == "Y") {
    			if (diff_rmk.value == "") {
    			    diff_rmk.value="Hide ";
    			}
		    }
		}
		fnCheckTrsp_so_no();
    	sheetObjects[1].SetColFontUnderline("trsp_wo_no",1);
    	sheetObjects[1].SetColFontUnderline("trsp_wo_ofc_cty_cd",1);
    	sheetObjects[1].SetColFontUnderline("trsp_wo_seq",1);
    	
    	//Disable Cancel All button if any detail have trasnport S/O or Rail S/O
    	disableCancelAll();
    }
    /**
    * trsp_so_no presence check
    */  
    function fnCheckTrsp_so_no() {
		var sheetObj=x_sheetObject1; 
		var cnt=sheetObj.RowCount();
		var flg=false;
		for (var i=1; i <= cnt; i++){ 
			var _val=sheetObj.GetCellValue(i, "trsp_so_no");
			var fr_flg=sheetObj.GetCellValue(i, "fr_flg");
			var rail_so = sheetObj.GetCellValue(i, "rail_so");
//			if (_val.length > 0 && fr_flg == ''){
			if ((_val.length > 0 && fr_flg == '' )|| (rail_so.length > 0)){
				flg=true;
				break;
			}
		}
		if(flg){
			ComBtnDisable("btn_t2aCancelAll");
			ComBtnDisable("btn_t2aCancelSeq");
		}else{
			ComBtnEnable("btn_t2aCancelSeq");
			ComBtnEnable("btn_t2aSaveSeq");
		}
    }
    /**
    * Tro dtl : Calendar and W/O pop-up event
    */
    function t2asheet1_OnPopupClick(sheetObj, row,col){
    	var selColNm=sheetObj.ColSaveName(col);
    	if (selColNm == "dor_arr_dt" || selColNm == "pkup_dt") {
            var cal=new ComCalendarGrid("myCal");
            cal.select(sheetObj, row, col, 'yyyy-MM-dd');
        }
    }    
    function t2asheet1_OnDblClick(sheetObj, row, col) {
    	var selColNm=sheetObj.ColSaveName(col);
    	if(selColNm == "trsp_wo_no" && !sheetObjects[1].GetCellValue(row, "trsp_wo_no") == "") {
    		var trsp_wo_ofc_cty_cd=sheetObjects[1].GetCellValue(row, "trsp_wo_ofc_cty_cd");
    		var trsp_wo_seq=sheetObjects[1].GetCellValue(row, "trsp_wo_seq");
        	var wo_cancel_flag='';
        	var detain='';
        	var bno_issue='';
        	var eq_mode='IS';
        	var issued='Y';
        	var param="?trsp_wo_ofc_cty_cd="+trsp_wo_ofc_cty_cd+"&trsp_wo_seq="+trsp_wo_seq+"&wo_cancel_flag="+wo_cancel_flag+"&detain="+detain+"&eq_mode="+eq_mode+"&bno_issue="+bno_issue+"&isInquiry=Y"+"&pgmNo=ESD_TRS_0024&tro_prv_flg=Y";
        	window.open('ESD_TRS_0024.do'+param, 'OpneHistoryWin', "scroll:no,status:no,help:no,width=1000,Height=800");
        }
    }

    
    
    function t2asheet1_OnChange(sheetObj, Row, Col, Val) {
    	var colId=sheetObj.ColSaveName(Col);
        var formObj=document.form; 
        with(formObj) {
            switch(colId) {
				case "cntr_tpsz_cd": 
					if ("Y" == sheetObj.GetCellValue(Row, "cxl_flg") || "D" == sheetObj.GetCellValue(Row, "ibflag")) {
						return; 
					}
					var preVal_type=sheetObj.GetCellValue(Row, "cntr_tpsz_cd_old");
					var nxtVal_type=Val;  //"cntr_tpsz_cd"
	            	if (nxtVal_type != preVal_type) {
	            		var preTroQty=sheetObj.GetCellValue(Row, "tro_qty_old");
	            		var nxtTroQty=sheetObj.GetCellValue(Row, "tro_qty");
	            		changeSumTroQty(preVal_type, preTroQty, nxtVal_type, nxtTroQty, Row);
	            	}
					break;
				case "dor_arr_dt":
					if (Val != "") {
						var t_dor_arr_dt=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "dor_arr_dt")),      "-", "");
						var t_dor_arr_dt_hhmi=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "dor_arr_dt_hhmi")), ":", "");
		    			if (t_dor_arr_dt_hhmi == "") {
		    				t_dor_arr_dt_hhmi="0000"; 
		    			}
		    			var t_arr_dt=t_dor_arr_dt + t_dor_arr_dt_hhmi;	
	    				var t_etb_dt=etb_dt.value;
						if (t_etb_dt != "" && t_arr_dt > t_etb_dt) {
							ComShowCodeMessage("COM12133", "[Troseq:"+sheetObj.GetCellValue(Row, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(Row, "tro_sub_seq")+"] Door Arrival Date", "ETB Date("+t_etb_dt+")", "lesser");
							return false;  
						}
						if (t_dor_arr_dt_hhmi == "") {
						    sheetObj.SetCellValue(Row, "dor_arr_dt_hhmi","00:00",0);
						}
					}					
					break;
				case "pkup_dt":
					var t_pkup_dt_hhmi=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(Row, "pkup_dt_hhmi")), ":", "");
					if (t_pkup_dt_hhmi == "") {
					    sheetObj.SetCellValue(Row, "pkup_dt_hhmi","00:00",0);
					}
					break;
	         }
        }
	}

    /**
    * Tro-Master : Mater can not edit 
    */    
    function changeMasterColor() {
    	var formObj=document.form;
    	//-------------------------------------------
    	//1) cxl_flg/cfm_flg checkbox : Master 
    	var cxl_flg=(formObj.cxl_flg.checked)? "Y" : "N";
    	var cfm_flg=(formObj.cfm_flg.checked)? "Y" : "N";
    	var targetTroSeq=tro_seq.GetSelectText();
    	var so_no_flg=getExistYnSoNo(targetTroSeq);
    	formObj.so_no_flg.value=so_no_flg; 
    	changeEnabled_master_control(cxl_flg, cfm_flg, so_no_flg);
    	changeEnabled_flags(cxl_flg, cfm_flg, so_no_flg);
		//-------------------------------------------
    	//2) presence of a combo values -> background color change  
		setChangeAllComboBackColor();  
    	//----------------------
    	//3) tro_seq, SaveSeq  button state control
	    var t_max_tro_seq_old=(nullToBlank(formObj.max_tro_seq_old.value)=="")? "0" : formObj.max_tro_seq_old.value; 
	    var t_currTroSeq=tro_seq.GetSelectText();
	    if (parseInt(t_currTroSeq) > parseInt(t_max_tro_seq_old)+1) {
	    	ComEnableManyTd(false, "btn_t2aSaveSeq"); 
	    } else {
	    	ComEnableManyTd(true, "btn_t2aSaveSeq"); 
	    }
	    var cfm_flg=(formObj.cfm_flg.checked)? "Y" : "N"; 
	    if ("Y" == cfm_flg) {
	    	ComEnableManyTd(false, "btn_t2aSaveSeq");
	    	ComEnableManyTd(true, "btn_t2aCopySeq");
	    }
	    
	    //4) BKG_TRO, CFM_FLG = 'Y' enable 로직
	    if ("Y" == cfm_flg) {
	    	with(formObj) {				
		    	//true 이면 입력 가능하게 처리함.				
	    		ComEnableManyObjects_loc   (true,      act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm, btns_popActCust, dor_loc_cd, zn_cd, btns_popLocation, dor_pst_no, act_shpr_addr, diff_rmk);  //Active
		    }	    	
	    }

    }    
    /**
     * Tro-Master : Not modify 
     */  
    function changeEnabled_master_control(p_cxl_flg, p_cfm_flg, p_so_no_flg) {
 		var bFlag=true;
 		//master all : disabled case  
 		//if (p_cxl_flg=="Y" || p_cfm_flg=="Y") {
 		if (p_cxl_flg == "Y" || p_so_no_flg == "Y" || p_cfm_flg=="Y") {
 			bFlag=false;
 		}
 		//master : all disabled
 		changeEnabled_master(bFlag);
    	//cfm_flg : disabled 
    	changeEnabled_cfmFlg(p_cxl_flg, p_cfm_flg, p_so_no_flg);
    }
    /**
    * Tro-Master : all disabled 
    */ 
    function changeEnabled_master(bFlag) {
    	var formObj=document.form;
     	with(formObj) {
     		ComEnableManyObjects_loc(bFlag, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm, 
     				                        dor_loc_cd, zn_cd, dor_pst_no, act_shpr_addr, 
     				                        cntc_pson_nm, diff_rmk, cntc_phn_no, cntc_fax_no, 
     				                        btns_popActCust, btns_popLocation);
     	}
//	    	ComEnableManyIBCombo(bFlag, dcgo_seq, rc_seq, awk_cgo_seq);
	 		comboObjects[1].SetEnable(bFlag);
	 		comboObjects[2].SetEnable(bFlag);
	 		comboObjects[3].SetEnable(bFlag);
     		ComEnableManyTd(bFlag, "btn_t2aAdd", "btn_t2aDelete", "btn_t2aCopy", "btn_t2aCopySeq"); 	    	

    }
    /**
    * Tro-Master : cfm_flg disabled 
    */ 
    function changeEnabled_cfmFlg(p_cxl_flg, p_cfm_flg, p_so_no_flg) {
    	var formObj=document.form;
		if (p_cxl_flg == "Y" || p_so_no_flg == "Y" || p_cfm_flg == "Y") {
			ComEnableObject_loc(formObj.cfm_flg, false);	
		} else {
			ComEnableObject_loc(formObj.cfm_flg, true);
		}	    	
    }
    
    /**
     * Tro-Master : drp_and_pk_flg, tri_axl_req_flg disabled 
     */ 
     function changeEnabled_flags(cxl_flg, cfm_flg, so_no_flg) {
     	var formObj=document.form;
 		if (cxl_flg == "Y" || so_no_flg == "Y" || cfm_flg == "Y") {
 			formObj.drp_and_pk_flg.disabled = "true";
 			formObj.tri_axl_req_flg.disabled = "true";
 		} else {
 			formObj.drp_and_pk_flg.disabled = "";
 			formObj.tri_axl_req_flg.disabled = "";
 		}	    	
     }
   
 	/**  
	 *  Sheet ibflag('D') -> row : Delete Color Processing
	 * : -> dtl cxl/cfm -> disable  and strikethrough
	 */ 
    function setRowDelColorChange(sheetObj, colId) {
	    var formObj=document.form;
	    var cfm_flg_mst=getMstValue_currSeq(sheetObj, "cfm_flg");
	    var so_no_flg=formObj.so_no_flg.value;
	   	for (var i=1; i<=sheetObj.RowCount(); i++) {
	   		if ("Y" == sheetObj.GetCellValue(i, "cxl_flg")) {
				sheetObj.SetCellValue(i, "cxl_flg","Y",0);
				//sheetObj.SetRangeFontColor(i, 0, i, sheetObj.LastCol(),"#FF0000");
 				sheetObj.SetCellFont("FontStrike", i, 0, i, sheetObj.LastCol(),1);
				changeAllGetCellEditable(sheetObj, i, 3, sheetObj.LastCol(), false);
			} else if ("Y" == cfm_flg_mst) {
//				sheetObj.SetRangeFontColor(i, 0, i, sheetObj.LastCol(),"#FF0000");
				changeAllGetCellEditable(sheetObj, i, 3, sheetObj.LastCol(), false);
				changeAllGetCellEditable(sheetObj, i, 8, 9, true);	// BKG_TRO, CFM_FLG = 'Y' enable 로직
				
			} else if ("Y" == so_no_flg) {
				changeAllGetCellEditable(sheetObj, i, 3, sheetObj.LastCol(), false);
			}
		}
    }
    //######################[2. Button Proc : Add/Copy/Cancel/Confirm/Sumqty]#####################
	/**     
	  * confirmSave  
	  */
    function confirmSave() {
	    var formObj=document.form; 
	    var sheetObj_all=x_sheetObject2; 
	    //-----------------------
	    //01. confirm the time  to apply
    	//var strToDay = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm"); 
    	//------------------------------------------------>
    	var bReturn=doActionIBSheet(x_sheetObjMsg, formObj, COMMAND09);  //Wanted server time
    	var strToDay=formObj.cfm_sys_date.value;                        
    	//<------------------------------------------------
    	//----------------------->
    	//02. all row : cfm_flg change
	    for (var i=1; i<=sheetObj_all.RowCount(); i++)
	    {
	    	var p_cxl_flg=sheetObj_all.GetCellValue(i, "cxl_flg");
	    	var targetTroSeq=sheetObj_all.GetCellValue(i, "so_no_flg");
	    	var p_so_no_flg=getExistYnSoNo(targetTroSeq);
	        if (p_cxl_flg != "Y" && p_so_no_flg != "Y")  
	    	{
		    	//02-1) cfm_flg change 
		        sheetObj_all.SetCellValue(i, "cfm_flg","Y",0);
		        //02-2) cfm_dt change 
		        var str_cfm_flg=sheetObj_all.GetCellValue(i, "cfm_flg");
		        var str_cfm_flg_old=sheetObj_all.GetCellValue(i, "cfm_flg_old");
	        	if (str_cfm_flg == "Y" && str_cfm_flg_old == "N") 
	        	{
	        		sheetObj_all.SetCellValue(i, "cfm_dt",strToDay,0);
	        	}
	    	}
	    }
	    //<-----------------------
	    //------------------------>
    	var p_cxl_flg=(formObj.cxl_flg.checked)? "Y" : "N";
    	var str_cfm_flg=(formObj.cfm_flg.checked)? "Y" : "N";
    	var str_cfm_flg_old=formObj.cfm_flg_old.value; 
    	var p_so_no_flg=formObj.so_no_flg.value;  
        if (p_cxl_flg != "Y" && p_so_no_flg != "Y" && str_cfm_flg == "Y" && str_cfm_flg_old == "N")
	    {
		    formObj.cfm_flg.checked=true;	
	    	var bResult=setCfmCheck(strToDay); 
	    }
	    //-----------------------
	    //save call 
	    doActionIBSheet(sheetObj_all, formObj, IBSAVE, "AC");  //delFlg -> C: Confirm, AC: All Confirm
	}
	/**     
	  * setCfmCheck -> Tro-Master Form  : Screen
	  */
	function setCfmCheck(toDay) {
		var formObj=document.form;
		with(formObj) {        	
	    	//-------------------------------------------
			//1) cfm_flg : "Y" ->, Confirm Date setting 
	    	if (cfm_flg.checked) {
	    		cfm_dt.value=toDay;
	    	} else {
	    		cfm_dt.value="";
	    	}
			//-------------------------------------------
			//2) cfm_flg : "Y" ->, disabled
	    	var p_cxl_flg=(formObj.cxl_flg.checked)? "Y" : "N";
	    	var p_cfm_flg=(formObj.cfm_flg.checked)? "Y" : "N";
	        var p_so_no_flg=formObj.so_no_flg.value; 
		}
	} 
	/**     
	  * cancelAll 
	  */
    function cancelAll() {
	    var formObj=document.form; 
	    var sheetObj_all=x_sheetObject2; 
	    var sheetObj_all_dtl=x_sheetObject3; 
	    sheetObj_all_dtl.ReDraw=false;
	    for (var i=1; i<=sheetObj_all_dtl.RowCount(); i++)
	    {
	    	if ("Y" != sheetObj_all_dtl.GetCellValue(i, "cxl_flg"))
			{
			    sheetObj_all_dtl.SetCellValue(i, "cxl_flg","Y",0);
	            //sum-qty change  
	            var PM_gubun="M";  //P:Plus, M:Minus 
	            var p_Row=i;
	            var p_currVal_type=sheetObj_all_dtl.GetCellValue(p_Row, "cntr_tpsz_cd");
	            var p_currTroQty=sheetObj_all_dtl.GetCellValue(p_Row, "tro_qty");
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun); 
	            if (sheetObj_all_dtl.GetRowStatus(i) == "I") {
	            	sheetObj_all_dtl.SetRowStatus(i,"D");
	            } else {
	            	sheetObj_all_dtl.SetCellValue(i, "cxl_flg","Y",0);
	            	sheetObj_all_dtl.SetRangeFontColor(i, 0, i, sheetObj_all_dtl.LastCol(),"#FF0000");
 	            	sheetObj_all_dtl.SetCellFont("FontStrike", i, 0, i, sheetObj_all_dtl.LastCol(),1);
	            }
			}		    	
	    }	
	    sheetObj_all_dtl.ReDraw=true;
	    sheetObj_all.ReDraw=false;
	    for (var i=1; i<=sheetObj_all.RowCount(); i++)
	    {
	    	if ("Y" != sheetObj_all.GetCellValue(i, "cxl_flg"))
	    	{
	            sheetObj_all.SetCellValue(i, "cxl_flg","Y",0);
	    	}
	    }
	    sheetObj_all.ReDraw=true;
	    //Change the screen output:Synchronization
	    cancelSeq("Y");	 
	    //Change the global variable state
	    x_cancelAllFlg="Y";
	}
	/**     
	  * cancelSeq
	  */
	function cancelSeq(all_gubun) {
  	    var formObj=document.form; 
		var sheetObj_dtl=x_sheetObject1; 
		if (all_gubun == null) {
			all_gubun="N";
		}
		//-------------------------------------------
		//1) tro-master : cancel
		formObj.cxl_flg.checked=true;
		//-------------------------------------------
		//2) tro-detail : cancel
		for (var i=sheetObj_dtl.RowCount(); i>=1; i--)
		{
			if ("Y" != sheetObj_dtl.GetCellValue(i, "cxl_flg"))
			{
	            //sum-qty change
	            var PM_gubun="M";  //P:Plus, M:Minus 
	            var p_Row=i;
	            var p_currVal_type=sheetObj_dtl.GetCellValue(p_Row, "cntr_tpsz_cd");
	            var p_currTroQty=sheetObj_dtl.GetCellValue(p_Row, "tro_qty");
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);
	            //sheetObj_dtl.CellValue2(i, "cxl_flg") = "Y"; 
	            if (sheetObj_dtl.GetCellValue(i, "ibflag") == "I") {
	            	sheetObj_dtl.SetRowStatus(i,"D");
	            } else {
	            	sheetObj_dtl.SetCellValue(i, "cxl_flg","Y",0);
	            	sheetObj_dtl.SetRangeFontColor(i, 0, i, sheetObj_dtl.LastCol(),"#FF0000");
 	            	sheetObj_dtl.SetCellFont("FontStrike", i, 0, i, sheetObj_dtl.LastCol(),1);
	            	changeAllGetCellEditable(sheetObj_dtl, i, 3, sheetObj_dtl.LastCol(), false);
	            }
			}
		}
    	var cxl_flg=(formObj.cxl_flg.checked)? "Y" : "N";
    	var cfm_flg=(formObj.cfm_flg.checked)? "Y" : "N";
        var so_no_flg=formObj.so_no_flg.value;     	
    	changeEnabled_master_control(cxl_flg, cfm_flg, so_no_flg);
	}
	/**     
	  * cancel_dtl
	  */
	function cancelDtl() {
  	    var formObj=document.form; 
		var sheetObj=x_sheetObject1; 
		var colId="del_chk";
		//1) tro-detail : cancel
        var sRow=sheetObj.FindCheckedRow(colId);
        //      // ACTIVE 버젼처럼 추가해준다.
        if(sRow.length >0 ) {
     	   sRow = sRow +"|";
        }
        var arrRow=sRow.split("|");
        for (var idx=arrRow.length-2; idx>=0; idx--)
        { 
        	if ("Y" != sheetObj.GetCellValue(arrRow[idx], "cxl_flg"))
        	{	
	            //sum-qty change 
	            var PM_gubun="M";  //P:Plus, M:Minus 
	            var p_Row=arrRow[idx];
				var p_currVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd");
				var p_currTroQty=sheetObj.GetCellValue(p_Row, "tro_qty");
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);         	
	            if (sheetObj.GetCellValue(arrRow[idx], "ibflag") == "I") {
	     	         sheetObj.SetRowStatus(arrRow[idx],"D");
	            } else {
	            	 sheetObj.SetCellValue(arrRow[idx], "cxl_flg","Y",0);
	         	     sheetObj.SetRangeFontColor(arrRow[idx], 0, arrRow[idx], sheetObj.LastCol(),"#FF0000");
 	         	     sheetObj.SetCellFont("FontStrike", arrRow[idx], 0, arrRow[idx], sheetObj.LastCol(),1);
	         	     changeAllGetCellEditable(sheetObj, arrRow[idx], 3, sheetObj.LastCol(), false);
	            }   
        	}
        }
	}
	/**     
	 *  CopySeq -> dtl AllCopy processing logic control
	 */
    function copyAllRow_dtl(sheetObj, newTroSeq, sheetObj_copy, copyTroSeq) {
    	for (var i=1; i<=sheetObj_copy.RowCount(); i++) {
    		addRow(sheetObj, "C", i, newTroSeq, sheetObj_copy);  //i:copyRow, sheetObj:x_sheetObject3, sheetObj_copy:x_sheetObject1 
    	} 
    }
	/**     
	 *  Copy -> processing logic control
	 */
	function copyRow(sheetObj) {
	  	var formObj=document.form;	  	

		sheetObj.ReDraw=false;
	    if (sheetObj.id == "t2asheet2")       //master
	    {
	    	var nCopyRow=sheetObj.FindText("tro_seq", tro_seq.GetSelectText());
		    addRow(sheetObj, "C", nCopyRow);  
	    } 
	    else if (sheetObj.id == "t2asheet1")  //dtl
	    { 	
	    	
			var strCopyCnt=formObj.tro_copy_cnt.value;	
		    if (strCopyCnt == "") {
		    	strCopyCnt="1";  
		    }
		    var nCopyCnt=parseInt(strCopyCnt);
	    	var nCopyRow=sheetObj.GetSelectRow();
	    	if (nCopyRow < 0) {
	    		nCopyRow=0; 
	    	}
			for (var i=0; i<nCopyCnt; i++) {
				addRow(sheetObj, "C", nCopyRow);  
			}
		}
	    sheetObj.ReDraw=true;
	}
	function setDataCopy(sheetObj, nNewRow, nCopyRow) {
        var formObj=document.form;
        var sheetObj=x_sheetObject2;
		sheetObj.SetCellValue(nNewRow, "rqst_dt",sheetObj.GetCellValue(nCopyRow, "rqst_dt"),0);
		sheetObj.SetCellValue(nNewRow, "act_shpr_cnt_cd",sheetObj.GetCellValue(nCopyRow, "act_shpr_cnt_cd"),0);
		sheetObj.SetCellValue(nNewRow, "act_shpr_seq",sheetObj.GetCellValue(nCopyRow, "act_shpr_seq"),0);
		sheetObj.SetCellValue(nNewRow, "act_shpr_nm",sheetObj.GetCellValue(nCopyRow, "act_shpr_nm"),0);
		sheetObj.SetCellValue(nNewRow, "dor_loc_cd",sheetObj.GetCellValue(nCopyRow, "dor_loc_cd"),0);
		sheetObj.SetCellValue(nNewRow, "zn_cd",sheetObj.GetCellValue(nCopyRow, "zn_cd"),0);
		sheetObj.SetCellValue(nNewRow, "dor_pst_no",sheetObj.GetCellValue(nCopyRow, "dor_pst_no"),0);
		sheetObj.SetCellValue(nNewRow, "act_shpr_addr",sheetObj.GetCellValue(nCopyRow, "act_shpr_addr"),0);
		sheetObj.SetCellValue(nNewRow, "cntc_pson_nm",sheetObj.GetCellValue(nCopyRow, "cntc_pson_nm"),0);
		sheetObj.SetCellValue(nNewRow, "diff_rmk",sheetObj.GetCellValue(nCopyRow, "diff_rmk"),0);
		sheetObj.SetCellValue(nNewRow, "cntc_phn_no",sheetObj.GetCellValue(nCopyRow, "cntc_phn_no"),0);
		sheetObj.SetCellValue(nNewRow, "cntc_fax_no",sheetObj.GetCellValue(nCopyRow, "cntc_fax_no"),0);

		sheetObj.SetCellValue(nNewRow, "cxl_flg","N",0);
    	sheetObj.SetCellValue(nNewRow, "cfm_flg","N",0);
    	sheetObj.SetCellValue(nNewRow, "cxl_flg_old","N",0);
    	sheetObj.SetCellValue(nNewRow, "cfm_flg_old","N",0);
	}
	function setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy) {
	    var formObj=document.form;	    
	    if (sheetObj_copy == null) {
	    	sheetObj_copy=sheetObj;
	    }
		sheetObj.SetCellValue(nNewRow, "cntr_tpsz_cd",sheetObj_copy.GetCellValue(nCopyRow, "cntr_tpsz_cd"),0);
		sheetObj.SetCellValue(nNewRow, "tro_qty",sheetObj_copy.GetCellValue(nCopyRow, "tro_qty"),0);
		sheetObj.SetCellValue(nNewRow, "dor_arr_dt",sheetObj_copy.GetCellValue(nCopyRow, "dor_arr_dt"),0);
		sheetObj.SetCellValue(nNewRow, "dor_arr_dt_hhmi",sheetObj_copy.GetCellValue(nCopyRow, "dor_arr_dt_hhmi"),0);
		sheetObj.SetCellValue(nNewRow, "pkup_dt",sheetObj_copy.GetCellValue(nCopyRow, "pkup_dt"),0);
		sheetObj.SetCellValue(nNewRow, "pkup_dt_hhmi",sheetObj_copy.GetCellValue(nCopyRow, "pkup_dt_hhmi"),0);
		sheetObj.SetCellValue(nNewRow, "pkup_loc_cd",sheetObj_copy.GetCellValue(nCopyRow, "pkup_loc_cd"),0);
		sheetObj.SetCellValue(nNewRow, "pkup_yd_cd",sheetObj_copy.GetCellValue(nCopyRow, "pkup_yd_cd"),0);
		sheetObj.SetCellValue(nNewRow, "rtn_loc_cd",sheetObj_copy.GetCellValue(nCopyRow, "rtn_loc_cd"),0);
		sheetObj.SetCellValue(nNewRow, "rtn_yd_cd",sheetObj_copy.GetCellValue(nCopyRow, "rtn_yd_cd"),0);
		sheetObj.SetCellValue(nNewRow, "cmdt_cd",sheetObj_copy.GetCellValue(nCopyRow, "cmdt_cd"),0);
		sheetObj.SetCellValue(nNewRow, "cntr_no",sheetObj_copy.GetCellValue(nCopyRow, "cntr_no"),0);
		//s/o
		sheetObj.SetCellValue(nNewRow, "trsp_so_no","",0);
		sheetObj.SetCellValue(nNewRow, "so_cre_dt","",0);
		sheetObj.SetCellValue(nNewRow, "so_cre_usr_id","",0);
		sheetObj.SetCellValue(nNewRow, "so_usr_nm","",0);
		sheetObj.SetCellValue(nNewRow, "fr_flg","",0);
		//hidden
		sheetObj.SetCellValue(nNewRow, "cxl_flg","N",0);
		sheetObj.SetCellValue(nNewRow, "cxl_flg_old","N",0);
		sheetObj.SetCellValue(nNewRow, "cntr_tpsz_cd_old",sheetObj_copy.GetCellValue(nCopyRow, "cntr_tpsz_cd"),0);
		sheetObj.SetCellValue(nNewRow, "tro_qty_old",sheetObj_copy.GetCellValue(nCopyRow, "tro_qty"),0);
	}
    function copyTrodgseq(copy_tro_seq, new_tro_seq) {
	    var sheetObj=x_sheetObject4;  
        //1) dtl check (tro_seq) 
	    sheetObj.CheckAll("del_chk",0,1);//hidden chk : check clear
        //2) copy_tro_seq   checking
        var nRow=0;  //findRow 
        var nStartRow=0;  //find Start Index 
        while (nRow > -1) {
    	    nRow=sheetObj.FindText("tro_seq", copy_tro_seq, nStartRow);
    	    if (nRow > -1) { 
    		    sheetObj.SetCellValue(nRow, "del_chk","Y",0);
    		    nStartRow=nRow+1;
    	    }
        } 
        //3) sheetObj.copy 
        var sRow=sheetObj.FindCheckedRow("del_chk");
        //      // ACTIVE 버젼처럼 추가해준다.
        if(sRow.length >0 ) {
     	   sRow = sRow +"|";
        }
        var arrRow=sRow.split("|");
        for (var idx=0; idx<=arrRow.length-2; idx++)
        { 
	        var nNewRow=sheetObj.DataInsert(-1);
	        sheetObj.SetCellValue(nNewRow, "tro_seq",new_tro_seq,0);
			sheetObj.SetCellValue(nNewRow, "spcl_cgo_cd",sheetObj.GetCellValue(arrRow[idx], "spcl_cgo_cd"),0);
			sheetObj.SetCellValue(nNewRow, "spcl_cgo_seq",sheetObj.GetCellValue(arrRow[idx], "spcl_cgo_seq"),0);
        }
    }  
    /**     
    * AddRow -> processing logic control 
    */
    function addRow(sheetObj, NCflag, nCopyRow, newCopyTroSeq, sheetObj_copy) {  
    	var formObj=document.form;    	
    	if (NCflag == null) {
    		NCflag="N";  //N:New, C:Copy  
    	}    	
    	//---------------------------------------
    	//1) Add a new row
    	var nNewRow=sheetObj.DataInsert(-1);
	    if (sheetObj.id == "t2asheet2")       //master
	    {
	    	if (NCflag == "C") {
				if (x_oldTroSeq != "") {
		    	    setFormToData_TroMst(x_oldTroSeq);  //2-1) tro-master : store 
				}
	    	}
	    	//---------------------------------------
	        //2-2) default value  setting : master 
	    	setDefaultInsertRow(sheetObj, nNewRow, NCflag, nCopyRow);
	    } 
		else if (sheetObj.id == "t2asheet1")  //dtl
	    { 
	    	//---------------------------------------
	        //2) defaultvalue  setting : dtl  	
	    	var curr_tro_seq=tro_seq.GetSelectText();
	    	setDefaultInsertRow_Dtl(sheetObj, nNewRow, curr_tro_seq); 
	    	if (NCflag == "C") {
	    		setDataCopy_dtl(sheetObj, nNewRow, nCopyRow);
	            //sum-qty change  
	            var PM_gubun="P";  //P:Plus, M:Minus 
	            var p_Row=nNewRow;
				var p_currVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd");
				var p_currTroQty=sheetObj.GetCellValue(p_Row, "tro_qty");
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);
	    	}
	    }
		else if (sheetObj.id == "t2asheet3")  //dtl all : copy 
		{ 
	    	if (NCflag == "C") {
	    		sheetObj.SetCellValue(nNewRow, "tro_seq",newCopyTroSeq,0);
	    		sheetObj.SetCellValue(nNewRow, "tro_sub_seq",sheetObj_copy.GetCellValue(nCopyRow, "tro_sub_seq"),0);
	    		setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy);
	            //sum-qty change  
	            var PM_gubun="P";  //P:Plus, M:Minus 
	            var p_Row=nNewRow;
				var p_currVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd");
				var p_currTroQty=sheetObj.GetCellValue(p_Row, "tro_qty");
	            plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun);   
	    	}
		}
    }
    /**     
     * [tro_master]AddRow row, set the default value of certain items
     */
    function setDefaultInsertRow(sheetObj, nRow, NCflag, nCopyRow) {
    	var formObj=document.form; 
    	var prevMaxTroSeq=""; 
    	var newTroSeq="";   	
		prevMaxTroSeq=getPrevMaxTroSeq(sheetObj, nRow, "tro_seq"); 
		//-------------------------------------------
		//2) tro-master : The default setting grid
        sheetObj.SetCellValue(nRow, "tro_seq",parseInt(prevMaxTroSeq) + 1,0);//new tro_seq : max+1
        sheetObj.SetCellValue(nRow, "rcv_term_cd",formObj.term.value,0);
        sheetObj.SetCellValue(nRow, "act_shpr_cnt_cd",formObj.cust_cnt_cd.value,0);
        sheetObj.SetCellValue(nRow, "act_shpr_seq",formObj.cust_seq.value,0);
        sheetObj.SetCellValue(nRow, "act_shpr_nm",formObj.cust_nm.value,0);
        sheetObj.SetCellValue(nRow, "dor_loc_cd",formObj.por_cd.value,0);
        if (formObj.por_nod_cd.value.trim() == "") {
        	sheetObj.SetCellValue(nRow, "zn_cd","01",0);
        } else {
        	sheetObj.SetCellValue(nRow, "zn_cd",formObj.por_nod_cd.value,0);
        }        
        sheetObj.SetCellValue(nRow, "cxl_flg","N",0);
        sheetObj.SetCellValue(nRow, "cfm_flg","N",0);
        sheetObj.SetCellValue(nRow, "cxl_flg_old","N",0);
        sheetObj.SetCellValue(nRow, "cfm_flg_old","N",0);
	    //-------------------------------------------
    	//3) tro-master Form : Added in the new combo of  tro_seq
        newTroSeq=sheetObj.GetCellValue(nRow, "tro_seq");
	    tro_seq.InsertItem(-1, newTroSeq, newTroSeq);	
    	if (NCflag == "C") {
    		//CopyRow  		
            ComSetObjValue(formObj.tro_seq_maxcnt, sheetObj.RowCount());
    		setDataCopy(sheetObj, nRow, nCopyRow);  //nNewRow
    		var copyTroSeq=sheetObj.GetCellValue(nCopyRow, "tro_seq");
    		//dg_seq Copy 
    		copyTrodgseq(copyTroSeq, newTroSeq); 
    		//Dtl All Copy : call
    		copyAllRow_dtl(x_sheetObject3, newTroSeq, x_sheetObject1, copyTroSeq);     		
    	} else {
    		//AddRow 
        	tro_seq.SetSelectText(newTroSeq,false);
		    ComSetObjValue(formObj.tro_seq_maxcnt, sheetObj.RowCount());
        	changeTroSeqProc(); 
        	addRow(x_sheetObject1);  //5) tro-dtl Form output changes
    	}
    }
     /**     
      * [tro_dtl]AddRow row, set the default value of certain items
      */
    function  setDefaultInsertRow_Dtl(sheetObj, nRow, tro_seq) { 
      	var formObj=document.form; 
    	var prevMaxTroSubSeq=""; 
    	prevMaxTroSubSeq=getPrevMaxTroSeq(sheetObj, nRow, "tro_sub_seq");     	
    	sheetObj.SetCellValue(nRow, "tro_seq",tro_seq,0);
	    sheetObj.SetCellValue(nRow, "tro_sub_seq",parseInt(prevMaxTroSubSeq) + 1,0);//new tro_sub_seq : max+1
        sheetObj.SetCellValue(nRow, "tro_qty",1,0);
        //sheetObj.CellValue2(nRow, "del")             = "N";
	    sheetObj.SetCellValue(nRow, "cxl_flg","N",0);
	    sheetObj.SetCellValue(nRow, "cxl_flg_old","N",0);
	    sheetObj.SetCellValue(nRow, "dor_arr_dt",formObj.dor_arr_dt.value,0);
	    sheetObj.SetCellValue(nRow, "dor_arr_dt_hhmi",formObj.dor_arr_dt_hhmi.value,0);
	    sheetObj.SetCellValue(nRow, "pkup_dt",formObj.pkup_dt.value,0);
	    sheetObj.SetCellValue(nRow, "pkup_dt_hhmi",formObj.pkup_dt_hhmi.value,0);
	    sheetObj.SetCellValue(nRow, "pkup_loc_cd",formObj.pickup_cy1.value,0);
	    sheetObj.SetCellValue(nRow, "pkup_yd_cd",formObj.pickup_cy2.value,0);
	    sheetObj.SetCellValue(nRow, "rtn_loc_cd",formObj.return_cy1.value,0);
	    sheetObj.SetCellValue(nRow, "rtn_yd_cd",formObj.return_cy2.value,0);
        sheetObj.SetCellValue(nRow, "cmdt_cd",formObj.cmdt_cd.value,0);
    }
    /** 
     * Views -> qtysum color initialization
     */  
    function changeTroQtyColor(sheetObj_qty) {
       	var formObj=document.form;  	
       	for(var i=1; i<=sheetObj_qty.RowCount(); i++) {
			var cntr_tpsz_cd=sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd");
			var n_totQty=parseInt(sheetObj_qty.GetCellValue(i, "total_qty"));
			var n_currTroqty=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty"));
   			if (n_totQty > n_currTroqty) {
   				sheetObj_qty.SetCellFontColor(i, "tro_qty","#FF0000");
   			} else if (n_totQty == n_currTroqty) {
   				sheetObj_qty.SetCellFontColor(i, "tro_qty","#000000");
   			} else if (nullToBlank(sheetObj_qty.GetCellValue(i, "tro_qty")) != "") {
   				sheetObj_qty.SetCellFontColor(i, "tro_qty","#FF0000");
   			}
       	}
    }  
    /**     
     * [tro_dtl] changes -> sumqty output changes: All (P / M)
     */
	function changeSumTroQty(preVal_type, preTroQty, nxtVal_type, nxtTroQty, p_Row) {
	  	var formObj=document.form;
	  	var sheetObj=x_sheetObject1; 
	  	var sheetObj_qty=x_sheetObject5; 
	  	sheetObj_qty.ReDraw=false; 	  	
	    var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);
	    if (nSRow > -1) 
        {
	    	var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
	    	var n_currTroqty=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty"));
			var n_t_chgTroqty=n_currTroqty + parseInt(nxtTroQty);   
			if (n_totQty > n_t_chgTroqty) {
 				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#FF0000");
			} else if (n_totQty == n_t_chgTroqty) {
 				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#000000");
			} else {
				callShowMessageBiggerQty(sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd"));
				sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd",preVal_type,0);
				//sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preTroQty; 
				sheetObj.SelectCell(p_Row, "cntr_tpsz_cd");
				sheetObj_qty.ReDraw=true; 
				return;
			}
			//<-------------------
			//1) next qty (+)
			sheetObj_qty.SetCellValue(nSRow, "tro_qty",n_t_chgTroqty,0);
		  	//2) pre qty (-)
		  	var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", preVal_type);
		  	if (nSRow > -1) 
		  	{
		  		var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
		  		var n_currTroqty=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty"));
				var n_t_chgTroqty=n_currTroqty - parseInt(preTroQty);
				sheetObj_qty.SetCellValue(nSRow, "tro_qty",n_t_chgTroqty,0);
		  		//Change the color of
			  	if (n_totQty > n_t_chgTroqty) {
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#FF0000");
				} else if (n_totQty == n_t_chgTroqty) {
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#000000");
				}
		  	} 
		  	//3) currVal -> oldVal 
			sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd_old",nxtVal_type,0);
			sheetObj.SetCellValue(p_Row, "tro_qty_old",nxtTroQty,0);
        } else {
        	ComShowCodeMessage("BKG00297");  
			sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd",preVal_type,0);
			//sheetObj.CellValue2(p_Row, "cntr_tpsz_cd") = preTroQty;  
			sheetObj.SelectCell(p_Row, "cntr_tpsz_cd");
		}
		sheetObj_qty.ReDraw=true; 
	}
    /**     
    * [tro_dtl] changes -> sumqty output changes: Option (P / M)
    */	
	function plusMinusSumTroQty(p_currVal_type, p_currTroQty, p_Row, PM_gubun) {
	  	var formObj=document.form;
  	  	var sheetObj_qty=x_sheetObject5; 
  	    var sheetObj=x_sheetObject1; 
	  	sheetObj_qty.ReDraw=false; 
	  	if ("P" == PM_gubun) {
			var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", p_currVal_type);
		  	if (nSRow > -1) 
		  	{
				var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
				var n_currTroqty=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty"));
				var n_t_chgTroqty=n_currTroqty + parseInt(p_currTroQty);  //Copy 
				if (n_totQty > n_t_chgTroqty) {
					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#FF0000");
				} else if (n_totQty == n_t_chgTroqty) {
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty","#000000");
				} else {
					callShowMessageBiggerQty(sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd"));
					var preVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd_old");
					sheetObj.SetCellValue(p_Row, "cntr_tpsz_cd",preVal_type,0);
					sheetObj.SelectCell(p_Row, "cntr_tpsz_cd");
					sheetObj_qty.ReDraw=true; 
					return; 
				}
				//<-------------------
		  		sheetObj_qty.SetCellValue(nSRow, "tro_qty",n_t_chgTroqty,0);
		  	}
	    } else if ("M" == PM_gubun) {
		  	var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", p_currVal_type);
		  	if (nSRow > -1) 
		  	{
		  		var currTroqty=sheetObj_qty.GetCellValue(nSRow, "tro_qty");
		  		sheetObj_qty.SetCellValue(nSRow, "tro_qty",parseInt(currTroqty) - parseInt(p_currTroQty),0);//Delete
	      	} 
	  	} 
	  	sheetObj_qty.ReDraw=true; 
	}    
	/**
	 * Copy / CopySeq before -> troqty Quantity Check-out
	 */  
	function checkCopySumTroqty(sheetObj) {
	    var formObj=document.form;
	    var sheetObj_qty=x_sheetObject5;
	    var sheetObj_dtl=x_sheetObject1;
	    if (sheetObj.id == "t2asheet1") 
	    {
			var nCopyCnt=formObj.tro_copy_cnt.value;	
		    if (nCopyCnt == "") {
		    	nCopyCnt=1; 
		    }
	    	var nCopyRow=sheetObj.GetSelectRow();
	    	if (nCopyRow < 0) {
	    		nCopyRow=0; 
	    	}
	    	var n_t_troqty=parseInt(sheetObj.GetCellValue(nCopyRow, "tro_qty"));
			var n_t_sumqty=n_t_troqty * nCopyCnt; 
			var cntr_tpsz_cd_copy=sheetObj.GetCellValue(nCopyRow, "cntr_tpsz_cd");
			var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", cntr_tpsz_cd_copy);
 		  	if (nSRow > -1) {
 		  		var totqty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
 		  		var currTroqty=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty"));
 		  	    var changeTroqty=currTroqty + n_t_sumqty;
 		  	    if (totqty < changeTroqty) {
 		  	    	callShowMessageBiggerQty(sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd"));
 		  	        return false;
 		  	    }
 		  	}
	    } 
	    else if (sheetObj.id == "t2asheet2") 
	    {	    
	    	for (var i=1; i<=sheetObj_qty.RowCount(); i++) {
	    		var i_cntr_tpsz_cd=sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd");
	    		var n_t_sumqty=0;
	    		for (var j=1; j<=sheetObj_dtl.RowCount(); j++) {
	    			var j_cntr_tpsz_cd=sheetObj_dtl.GetCellValue(j, "cntr_tpsz_cd");
	    			if (j_cntr_tpsz_cd == i_cntr_tpsz_cd) {
	    				var n_t_troqty=parseInt(sheetObj_dtl.GetCellValue(j, "tro_qty"));
	    				n_t_sumqty += n_t_troqty;  
	    			}
	    		}
	    		var totqty=parseInt(sheetObj_qty.GetCellValue(i, "total_qty"));
	    		var currTroqty=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty"));
 		  	    var changeTroqty=currTroqty + n_t_sumqty; 
 		  	    if (totqty < changeTroqty) {
 		  	    	callShowMessageBiggerQty(sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd"));
 		  	        return false;
 		  	    }
	    	}
	    }
	    return true;
	}  
	//######################[3. Data Display/Store (Master/Detail)]###############################
    /** 
     * Tro-Mastr Output (Sheet -> Form : Display)
     */
    function setDataToForm_TroMst(tro_seq_index) {
        var formObj=document.form;
        var sheetObj=x_sheetObject2; 
        //-----------------------------------
        var nRow=sheetObj.FindText("tro_seq", tro_seq_index);
       //-----------------------------------
       //2) Output 
       //if(sheetObj.RowCount > 1){ IBS_CopyRowToForm(sheetObj, formObj, nRow, ""); }
        ComSetObjValue(formObj.tro_seq_maxcnt,   sheetObj.RowCount());
        if( nRow == -1 ) return false;
        tro_seq.SetSelectText(sheetObj.GetCellValue(nRow, "tro_seq"),false);
       if (x_oldTroSeq == "") { 
           x_oldTroSeq=tro_seq.GetSelectText();
       } 
       
       with(formObj) {
			ComSetObjValue(rcv_term_cd,      nullToBlank(sheetObj.GetCellValue(nRow, "rcv_term_cd")));
			ComSetObjValue(rqst_dt,          nullToBlank(sheetObj.GetCellValue(nRow, "rqst_dt")));
			ComSetObjValue(act_shpr_cnt_cd,  nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_cnt_cd")));
			ComSetObjValue(act_shpr_seq,     nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_seq")));
			ComSetObjValue(act_shpr_nm,      nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_nm")));
			ComSetObjValue(dor_loc_cd,       nullToBlank(sheetObj.GetCellValue(nRow, "dor_loc_cd")));
			ComSetObjValue(zn_cd,            nullToBlank(sheetObj.GetCellValue(nRow, "zn_cd")));
			ComSetObjValue(dor_pst_no,       nullToBlank(sheetObj.GetCellValue(nRow, "dor_pst_no")));
    	   //ComSetObjValue(cfm_flg,          nullToBlank(sheetObj.CellValue(nRow, "cfm_flg")));
			cfm_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "cfm_flg")) == "Y") ? true : false;
			ComSetObjValue(cfm_flg_old,      nullToBlank(sheetObj.GetCellValue(nRow, "cfm_flg_old")));
			ComSetObjValue(cfm_dt,           nullToBlank(sheetObj.GetCellValue(nRow, "cfm_dt")));
			ComSetObjValue(act_shpr_addr,    nullToBlank(sheetObj.GetCellValue(nRow, "act_shpr_addr")));
			ComSetObjValue(cntc_pson_nm,     nullToBlank(sheetObj.GetCellValue(nRow, "cntc_pson_nm")));
			ComSetObjValue(diff_rmk,         nullToBlank(sheetObj.GetCellValue(nRow, "diff_rmk")));
			ComSetObjValue(cntc_phn_no,      nullToBlank(sheetObj.GetCellValue(nRow, "cntc_phn_no")));
			ComSetObjValue(cntc_fax_no,      nullToBlank(sheetObj.GetCellValue(nRow, "cntc_fax_no")));
    	   //hidden  
			cxl_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "cxl_flg")) == "Y") ? true : false;
			drp_and_pk_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "drp_and_pk_flg")) == "Y") ? true : false;
			tri_axl_req_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "tri_axl_req_flg")) == "Y") ? true : false;
			ComSetObjValue(cxl_flg_old,      nullToBlank(sheetObj.GetCellValue(nRow, "cxl_flg_old")));
    	   //<B>-->            
			ComSetObjValue(so_flg,       nullToBlank(sheetObj.GetCellValue(nRow, "so_flg")));
			ownr_trk_flg.checked=(nullToBlank(sheetObj.GetCellValue(nRow, "ownr_trk_flg")) == "Y") ? true : false;
			ComSetObjValue(biz_rgst_no,  nullToBlank(sheetObj.GetCellValue(nRow, "biz_rgst_no")));
			ComSetObjValue(cntc_mphn_no, nullToBlank(sheetObj.GetCellValue(nRow, "cntc_mphn_no")));
    	   //<--<B>
           //-----------------------------------
           //2-1) spcl_cgo_seq Output to the screen
			setDataToForm_Tro_dg_seq(sheetObj.GetCellValue(nRow, "tro_seq"));
       }
   }  
    /** 
     * Tro-Master Temp Save (Form ->Sheet  : Store)
     */
    function setFormToData_TroMst(prev_tro_seq) {
    	var formObj=document.form; 
        var sheetObj=x_sheetObject2; 
        sheetObj.RenderSheet(0);//----------------->
        //-----------------------------------
        var nRow=sheetObj.FindText("tro_seq", prev_tro_seq);
        //-----------------------------------
        // 2) Store(Update) 
        with(formObj) {
        	sheetObj.SetCellValue(nRow, "tro_seq",prev_tro_seq,0);
        	sheetObj.SetCellValue(nRow, "rcv_term_cd",ComGetObjValue(rcv_term_cd),0);
        	sheetObj.SetCellValue(nRow, "rqst_dt",ComGetObjValue(rqst_dt),0);
        	sheetObj.SetCellValue(nRow, "act_shpr_cnt_cd",ComGetObjValue(act_shpr_cnt_cd),0);
        	sheetObj.SetCellValue(nRow, "act_shpr_seq",ComGetObjValue(act_shpr_seq),0);
        	sheetObj.SetCellValue(nRow, "act_shpr_nm",ComGetObjValue(act_shpr_nm),0);
        	sheetObj.SetCellValue(nRow, "dor_loc_cd",ComGetObjValue(dor_loc_cd),0);
        	sheetObj.SetCellValue(nRow, "zn_cd",ComGetObjValue(zn_cd),0);
        	sheetObj.SetCellValue(nRow, "dor_pst_no",ComGetObjValue(dor_pst_no),0);
        	sheetObj.SetCellValue(nRow, "cfm_flg",(cfm_flg.checked==1) ? "Y" : "N",0);
        	sheetObj.SetCellValue(nRow, "cfm_dt",ComGetObjValue(cfm_dt),0);
        	sheetObj.SetCellValue(nRow, "act_shpr_addr",ComGetObjValue(act_shpr_addr),0);
        	sheetObj.SetCellValue(nRow, "cntc_pson_nm",ComGetObjValue(cntc_pson_nm),0);
        	sheetObj.SetCellValue(nRow, "diff_rmk",ComGetObjValue(diff_rmk),0);
        	sheetObj.SetCellValue(nRow, "cntc_phn_no",ComGetObjValue(cntc_phn_no),0);
        	sheetObj.SetCellValue(nRow, "cntc_fax_no",ComGetObjValue(cntc_fax_no),0);
        	//hidden  
            sheetObj.SetCellValue(nRow, "cxl_flg",(cxl_flg.checked==1) ? "Y" : "N",0);
            sheetObj.SetCellValue(nRow, "drp_and_pk_flg",(drp_and_pk_flg.checked==1) ? "Y" : "N",0);
            sheetObj.SetCellValue(nRow, "tri_axl_req_flg",(tri_axl_req_flg.checked==1) ? "Y" : "N",0);
            //<B>-->            
            sheetObj.SetCellValue(nRow, "so_flg",ComGetObjValue(so_flg),0);
            sheetObj.SetCellValue(nRow, "ownr_trk_flg",(ownr_trk_flg.checked==1) ? "Y" : "N",0);
            sheetObj.SetCellValue(nRow, "biz_rgst_no",ComGetObjValue(biz_rgst_no),0);
            sheetObj.SetCellValue(nRow, "cntc_mphn_no",ComGetObjValue(cntc_mphn_no),0);
            //<--<B>
            //-----------------------------------
            // 2-1) dg_seq Store
            setFormToData_Tro_dg_seq(prev_tro_seq); 
        }  
        sheetObj.RenderSheet(1);//<------------------
    } 
    /** 
    * Tro-Detail Output ( HiddenSheet -> Sheet : Display ) 
    */
    function setAllDataToData_TroDtl(tro_seq) {
        var formObj=document.form;
        var sheetObj=x_sheetObject2;
        var sheetObjDtl=x_sheetObject1; 
        var sheetObjDtl_All=x_sheetObject3; 
        //sheetObjDtl.RenderSheet(0);//----------------->
        //sheetObjDtl_All.RenderSheet(0);
        //--------------------------------
        //1) Initialization 
        sheetObjDtl_All.CheckAll("chk",0,1);//dtl_all check Initialization
        sheetObjDtl.RemoveAll();               //dtl grid Initialization
        //--------------------------------
        //2) dtl check (tro_seq)       
        for (var i=1; i<=sheetObjDtl_All.RowCount(); i++) {
        	var tempTro_seq=sheetObjDtl_All.GetCellValue(i, "tro_seq");
    	    if (tro_seq == tempTro_seq) {
    		    sheetObjDtl_All.SetCellValue(i, "chk","1",0);
    	    }
        }
        //-------------------------------- 
        //3) ComMakeSearchXml
        var strSaveNames="ibflag|tro_seq|tro_sub_seq|cntr_tpsz_cd|tro_qty|dor_arr_dt|dor_arr_dt_hhmi|pkup_dt|pkup_dt_hhmi|"+
                           "pkup_loc_cd|pkup_yd_cd|rtn_loc_cd|rtn_yd_cd|cmdt_cd|cntr_no|split_rmk|"+
                           "trsp_so_no|so_cre_dt|so_cre_usr_id|so_usr_nm|trsp_wo_no|trsp_wo_ofc_cty_cd|trsp_wo_seq|fr_flg|rail_so|cop_no|"+  //s/o
                           "cxl_flg|cxl_flg_old|cntr_tpsz_cd_old|tro_qty_old|upd_usr_id_old|upd_dt_old";   
        var sXml=ComMakeSearchXml(sheetObjDtl_All, false, "chk", strSaveNames, true);  //all column : move 
        //--------------------------------
        //4) LoadSearchXml (Output  dtl grid) 
        sheetObjDtl.LoadSearchData(sXml,{Append:1 , Sync:1} );
        //--------------------------------
        setRowDelColorChange(sheetObjDtl, "del_chk");
        //sheetObjDtl_All.RenderSheet(1);
        //sheetObjDtl.RenderSheet(1);//<------------------
    }       
    /** 
     * Tro-Detail Temp Save   ( Sheet -> HidenSheet : Store )
     */
    function setDataToAllData_TroDtl(prev_tro_seq, del_flag) {    
        var sheetObjDtl=x_sheetObject1; 
        var sheetObjDtl_All=x_sheetObject3; 
        if (del_flag == null) {
    	    del_flag=true;  
        }       
        sheetObjDtl.RenderSheet(0);//----------------->
        //--------------------------------
        //1) dtl check (tro_seq) 
        sheetObjDtl.CheckAll("chk",1,1);//hidden chk : dtl_all check Initialization
        //--------------------------------
        //2) dtl-all delete (tro_seq)
        deleteRowDtlAll(prev_tro_seq);   
        //-------------------------------- 
        //3) ComMakeSearchXml / LoadSearchXml (Output  dtl grid) 
        var strSaveNames="ibflag|tro_seq|tro_sub_seq|cntr_tpsz_cd|tro_qty|dor_arr_dt|dor_arr_dt_hhmi|pkup_dt|pkup_dt_hhmi|"+
                           "pkup_loc_cd|pkup_yd_cd|rtn_loc_cd|rtn_yd_cd|cmdt_cd|cntr_no|split_rmk|"+
                           "trsp_so_no|so_cre_dt|so_cre_usr_id|so_usr_nm|trsp_wo_no|trsp_wo_ofc_cty_cd|trsp_wo_seq|fr_flg|rail_so|cop_no|"+  //s/o
                           "cxl_flg|cxl_flg_old|cntr_tpsz_cd_old|tro_qty_old|upd_usr_id_old|upd_dt_old"; 
        var sXml=ComMakeSearchXml(sheetObjDtl, false, "chk", strSaveNames, del_flag);  //all column : move/copy
        sheetObjDtl_All.LoadSearchData(sXml,{Append:1 , Sync:1} );
        sheetObjDtl.RenderSheet(1);//<------------------
    }
    function deleteRowDtlAll(prev_tro_seq) {
	    var sheetObj=x_sheetObject3;
        //--------------------------------
        //1) dtl check (tro_seq) 
	    sheetObj.CheckAll("del_chk",0,1);//hidden chk : check clear
        //2) prev_tro_seq delete flag setting  
        var nRow=0;  //findRow 
        var nStartRow=0;  //find Start Index 
        while (nRow > -1) {
    	    nRow=sheetObj.FindText("tro_seq", prev_tro_seq, nStartRow);
    	    if (nRow > -1) {    		   
    		    sheetObj.SetCellValue(nRow, "del_chk","1",0);
    		    nStartRow=nRow+1;
    	    }
        } 
        //3) sheetObj.RowDelete(); 
        var sRow=sheetObj.FindCheckedRow("del_chk");
        //      // ACTIVE 버젼처럼 추가해준다.
        if(sRow.length >0 ) {
     	   sRow = sRow +"|";
        }
        var arrRow=sRow.split("|");
        for (var idx=arrRow.length-2; idx>=0; idx--)
        { 
    	    sheetObj.RowDelete(arrRow[idx], false);
        }
    }
    //######################[4. Data Display/Store (Etc : Header/Combo)]##########################
    /**
    * Header Output(Booking Information) 
    */
    function setEtcDataToForm_bkg(formObj, sheetObj) {
        //------------------------------
        //sheetEtcData --> Form 
        //IBS_EtcDataToForm(formObj, sheetObj);
        with (formObj) 
        {	
	        por_nod_cd.value=nullToBlank(sheetObj.GetEtcData("por_nod_cd"));
	        skd_dir_cd.value=nullToBlank(sheetObj.GetEtcData("skd_dir_cd"));
	        cust_seq.value=nullToBlank(sheetObj.GetEtcData("cust_seq"));
	        fd_grd_flg.value=nullToBlank(sheetObj.GetEtcData("fd_grd_flg"));
	        spcl_hide_flg.value=nullToBlank(sheetObj.GetEtcData("spcl_hide_flg"));
	        pol_code.value=nullToBlank(sheetObj.GetEtcData("pol_code"));
	        bkg_sts_cd.value=nullToBlank(sheetObj.GetEtcData("bkg_sts_cd"));
	        cmdt_nm.value=nullToBlank(sheetObj.GetEtcData("cmdt_nm"));
	        //bl_tp_cd.value        = nullToBlank(sheetObj.EtcData("bl_tp_cd")); 
	        bkg_no.value=nullToBlank(sheetObj.GetEtcData("bkg_no"));
	        bl_no.value=nullToBlank(sheetObj.GetEtcData("bl_no"));
	        cust_cnt_cd.value=nullToBlank(sheetObj.GetEtcData("cust_cnt_cd"));
	        cust_nm.value=nullToBlank(sheetObj.GetEtcData("cust_nm"));
	        cmdt_cd.value=nullToBlank(sheetObj.GetEtcData("cmdt_cd"));
	        conti_cd.value=nullToBlank(sheetObj.GetEtcData("conti_cd"));
	        del_cd.value=nullToBlank(sheetObj.GetEtcData("del_cd"));
	        term.value=nullToBlank(sheetObj.GetEtcData("term"));
	        por_cd.value=nullToBlank(sheetObj.GetEtcData("por_cd"));
	        pod_cd.value=nullToBlank(sheetObj.GetEtcData("pod_cd"));
	        skd_voy_no.value=nullToBlank(sheetObj.GetEtcData("skd_voy_no"));
	        etb_dt.value=nullToBlank(sheetObj.GetEtcData("etb_dt"));
	        vsl_cd.value=nullToBlank(sheetObj.GetEtcData("vsl_cd"));
	        dor_arr_dt.value=nullToBlank(sheetObj.GetEtcData("dor_arr_dt"));
	        dor_arr_dt_hhmi.value=nullToBlank(sheetObj.GetEtcData("dor_arr_dt_hhmi"));
	        pkup_dt.value=nullToBlank(sheetObj.GetEtcData("pkup_dt"));
	        pkup_dt_hhmi.value=nullToBlank(sheetObj.GetEtcData("pkup_dt_hhmi"));
        }
        var t_returnCy=nullToBlank(sheetObj.GetEtcData("return_cy"));
	    if (t_returnCy.length >= 7) {
	    	formObj.return_cy1.value=t_returnCy.substr(0, 5);
	    	formObj.return_cy2.value=t_returnCy.substr(5, 2);	    	
	    } else {
	    	formObj.return_cy1.value=t_returnCy;
	    	formObj.return_cy2.value="";
	    }
	    var t_pickupCy=nullToBlank(sheetObj.GetEtcData("pickup_cy"));
	    if (t_pickupCy.length >= 7) {
	    	formObj.pickup_cy1.value=t_pickupCy.substr(0, 5);
	    	formObj.pickup_cy2.value=t_pickupCy.substr(5, 2);
	    } else {
	    	formObj.pickup_cy1.value=t_pickupCy;
	    	formObj.pickup_cy2.value="";
	    }
        //------------------------------
        formObj.oldBkgNo.value=nullToBlank(sheetObj.GetEtcData("bkg_no"));
        formObj.oldBlNo.value=nullToBlank(sheetObj.GetEtcData("bl_no"));
        formObj.ca_flg.value=nullToBlank(sheetObj.GetEtcData("ca_flg"));
        //------------------------------------------------
        if ("D" != formObj.term.value) {
    	    ComShowCodeMessage("BKG02021");  //"Receiving Term is not 'D' !"
        }
        //zip : Required fields
        if ("US" == formObj.por_cd.value.substr(0,2)) {
    	    document.getElementById("dor_pst_no").className="input1"; 
        } else {
    	    document.getElementById("dor_pst_no").className="input";   
        }
	    //Output checkbox reprocessing --------------------------> 
	    var dcgo_flg=nullToBlank(sheetObj.GetEtcData("dcgo_flg"));
	    var rc_flg=nullToBlank(sheetObj.GetEtcData("rc_flg"));
	    var awk_cgo_flg=nullToBlank(sheetObj.GetEtcData("awk_cgo_flg"));
	    var bb_cgo_flg=nullToBlank(sheetObj.GetEtcData("bb_cgo_flg"));
	    var rd_cgo_flg=nullToBlank(sheetObj.GetEtcData("rd_cgo_flg"));
	    formObj.dcgo_flg.checked=(dcgo_flg    == "Y") ? true : false;
	    formObj.rc_flag.checked=(rc_flg      == "Y") ? true : false;
	    formObj.awk_cgo_flg.checked=(awk_cgo_flg == "Y") ? true : false;
	    formObj.bb_cgo_flg.checked=(bb_cgo_flg  == "Y") ? true : false;
	    formObj.rd_cgo_flg.checked=(rd_cgo_flg  == "Y") ? true : false;
	    //<---------------------------Output checkbox reprocessing 
	    //Button link / button, the output -------------------------->
	    changeDisplayBtn("btn_Danger",  dcgo_flg);
	    changeDisplayBtn("btn_Reefer",  rc_flg);
	    changeDisplayBtn("btn_Awkward", awk_cgo_flg);
	    changeDisplayBtn("btn_Bulk",    bb_cgo_flg);
	    //<----------------------------------------------
	    //Search after, button enabled
 		if (formObj.oldBkgNo.value != "") {
 		    ComEnableManyTd(true, "btn_t2aSave", "btn_t2aSaveConfirm", "btn_t2aCancelAll", "btn_t2aTROCopy", 
		                          "btn_t2aAddSeq", "btn_t2aCopySeq", "btn_t2aCancelSeq", 
                                  "btn_t2aAdd", "btn_t2aDelete", "btn_t2aCopy");
 		}
    }
    /** 
    * Tro-Mastr spcl_cgo_seq Output : (multi Combo value) 
    */
    function setDataToForm_Tro_dg_seq(tro_seq_index) {
        var formObj=document.form;
        var sheetObj=x_sheetObject4; 
        var comboObj_1=dcgo_seq; 
        var comboObj_2=rc_seq; 
        var comboObj_3=awk_cgo_seq; 
        var comboId="spcl_cgo_seq";
//        var nRow=0;  //findRow 
//        var nStartRow=0;
        var strCode_1="";
        var strCode_2=""; 
        var strCode_3=""; 
//        while (nRow > -1) {
//    	    nRow=sheetObj.FindText("tro_seq", tro_seq_index, nStartRow);
//    	    if (nRow > -1) {
//    	    	var spcl_cgo_cd=sheetObj.GetCellValue(nRow, "spcl_cgo_cd");
//    	    	switch(spcl_cgo_cd) {
//    	    	    case "DG":
//    	    		    if (strCode_1 == "") {
//    	    		    	strCode_1 += sheetObj.GetCellValue(nRow, comboId);
//    	    		    } else {
//    	    		    	strCode_1 += "|"+sheetObj.GetCellValue(nRow, comboId);
//    	    		    }
//    	    	    	break;
//    	    	    case "RF":
//    	    		    if (strCode_2 == "") {
//    	    		    	strCode_2 += sheetObj.GetCellValue(nRow, comboId);
//    	    		    } else {
//    	    		    	strCode_2 += "|"+sheetObj.GetCellValue(nRow, comboId);
//    	    		    }
//    	    	    	break;
//    	    	    case "AK":
//    	    		    if (strCode_3 == "") {
//    	    		    	strCode_3 += sheetObj.GetCellValue(nRow, comboId);
//    	    		    } else {
//    	    		    	strCode_3 += "|"+sheetObj.GetCellValue(nRow, comboId);
//    	    		    }
//    	    	    	break;
//    	    	}
//                nStartRow=nRow+1;
//    	    }
//        } 
        
        for(i=1;i<sheetObj.RowCount() + 1; i++){
        	if(sheetObj.GetCellValue(i, "tro_seq")== tro_seq_index){
    	    	switch(sheetObj.GetCellValue(i, "spcl_cgo_cd")) {
		    	    case "DG":
		    		    if (strCode_1 == "") {
		    		    	strCode_1 += sheetObj.GetCellValue(i, comboId);
		    		    } else {
		    		    	strCode_1 += "|"+sheetObj.GetCellValue(i, comboId);
		    		    }
		    	    	break;
		    	    case "RF":
		    		    if (strCode_2 == "") {
		    		    	strCode_2 += sheetObj.GetCellValue(i, comboId);
		    		    } else {
		    		    	strCode_2 += "|"+sheetObj.GetCellValue(i, comboId);
		    		    }
		    	    	break;
		    	    case "AK":
		    		    if (strCode_3 == "") {
		    		    	strCode_3 += sheetObj.GetCellValue(i, comboId);
		    		    } else {
		    		    	strCode_3 += "|"+sheetObj.GetCellValue(i, comboId);
		    		    }
		    	    	break;
    	    	}
	    	} 
        }        
        
        comboObj_1.SetSelectText("",false);
        comboObj_2.SetSelectText("",false);
        comboObj_3.SetSelectText("",false);
        comboObj_1.SetSelectText(strCode_1,false);
        comboObj_2.SetSelectText(strCode_2,false);
        comboObj_3.SetSelectText(strCode_3,false);
    }
    /** 
     * Tro-Mastr spcl_cgo_seq Store_pre : (multi value combo) 
     */
    function setFormToData_Tro_dg_seq(prev_tro_seq) {
        var formObj=document.form;
        var sheetObj=x_sheetObject4; 
        var comboObj_1=dcgo_seq; 
        var comboObj_2=rc_seq; 
        var comboObj_3=awk_cgo_seq; 
//        var nRow=0;  //findRow 
//        var nStartRow=0;  //find Start Index 
//        while (nRow > -1) 
//	    {
//    	    nRow=sheetObj.FindText("tro_seq", prev_tro_seq, nStartRow);
//    	    if (nRow > -1) 
//		    {    		   
//    		    sheetObj.SetCellValue(nRow, "del_chk","1",0);
//    		    nStartRow=nRow+1;
//    	    }
//        } 
//        var sRow=sheetObj.FindCheckedRow("del_chk");
//        //      // ACTIVE 버젼처럼 추가해준다.
//        if(sRow.length >0 ) {
//     	   sRow = sRow +"|";
//        }
//        var arrRow=sRow.split("|");
//        for (var idx=arrRow.length-2; idx>=0; idx--)
//        { 
//    	    sheetObj.RowDelete(arrRow[idx], false);
//        }
        
        for(i=sheetObj.RowCount();0<i;i--){
        	if(sheetObj.GetCellValue(i, "tro_seq")== prev_tro_seq){
        		sheetObj.RowDelete(i, false);
        	}
        }
        
        //3) comboObj.Text -> parsing
        comboCodeToSheet(sheetObj, comboObj_1, "DG", prev_tro_seq);
        comboCodeToSheet(sheetObj, comboObj_2, "RF", prev_tro_seq);
        comboCodeToSheet(sheetObj, comboObj_3, "AK", prev_tro_seq);
    }
    /** 
    * Tro-Mastr spcl_cgo_seq Store : (multi value combo) 
    */
    function comboCodeToSheet(sheetObj, comboObj, spcl_cgo_cd, prev_tro_seq) {
        var strText=comboObj.GetSelectText();
        if (strText != "") {
	        var arrComboSeq=strText.split("|");   
	        for (var i=0; i<arrComboSeq.length; i++) {	
		        var nNewRow=sheetObj.DataInsert(-1);
		    	sheetObj.SetCellValue(nNewRow, "tro_seq",prev_tro_seq,0);
		    	sheetObj.SetCellValue(nNewRow, "spcl_cgo_cd",spcl_cgo_cd,0);
		    	sheetObj.SetCellValue(nNewRow, "spcl_cgo_seq",arrComboSeq[i],0);
	        }
        }
    }
    //######################[5. Etc]##############################################################
    // addRow prev MaxSeq get 
    function getPrevMaxTroSeq(sheetObj, nRow, colId)
	{
	    var prevMaxTroSeq=0;
		if (nRow > 1) {
			prevMaxTroSeq=sheetObj.GetCellValue(nRow-1, colId);
		}
		return prevMaxTroSeq;
	}
	/**  
	 * tro_seq master-row column Value return 
	 */ 
	function getMstValue_currSeq(sheetObj, colId) {    	
	   	var formObj=document.form;
	   	var strSheetId_gubun=sheetObj.id.substr(sheetObj.id.length-2, 2);    	
		var strCurrTroSeq="";
		var sheetObj_mst=null; 
		if (strSheetId_gubun == "_b") {
			sheetObj_mst=x_sheetObject7;
			strCurrTroSeq=t2_tro_seq.GetSelectText();
		} else {
			sheetObj_mst=x_sheetObject2;
			strCurrTroSeq=tro_seq.GetSelectText();
		} 
		var nSRow_mst=sheetObj_mst.FindText("tro_seq", strCurrTroSeq);
		var strReturnVal_mst=sheetObj_mst.GetCellValue(nSRow_mst, colId);
		return strReturnVal_mst;
	}
	//function getExistYnSoNo() {
    function getExistYnSoNo(targetTroSeq) {
		var formObj=document.form;		
		var sheetObjDtl_All=x_sheetObject3; 
		var strReturn="N";
		for (var i=1; i<=sheetObjDtl_All.RowCount(); i++) {
			var strTroSeq=sheetObjDtl_All.GetCellValue(i, "tro_seq");
			if (strTroSeq == targetTroSeq) {
				var strSoNo=sheetObjDtl_All.GetCellValue(i, "trsp_so_no");
				if (strSoNo != "") {
					strReturn="Y";
					break;
				}
			}
		}
		return strReturn;
	}
    function setAddRemarkText(comboObj, idx_cd, text) {
    	if (comboObj.GetItemCheck(idx_cd)) {
	    	if (comboObj) {
	        	var arrComboText=text.split("|"); 
	        	var objRemark=document.form.diff_rmk;
	        	if(objRemark.value != "") {
	        		objRemark.value += " ";
	        	}
	        	objRemark.value += arrComboText[1];
	    	}
    	}
    }
    /**
     * flag -> change the output processing
     */
    function changeDisplayBtn(btnNm, link_flag) {
 	    if ("Y" == link_flag) {
 		    //document.getElementById(btnNm).style.color="blue";
 	    	document.getElementById(btnNm).style.setProperty("color", BTN_BLUE, "important");
	    } else { 	    	
		    document.getElementById(btnNm).style.color="";
	    }
    }
    /**
     * Link button to check the status of Td
     */
    function checkTdUnLink(btnNm) {
//    	return !(document.getElementById(btnNm).style.color == "rgb(1, 0, 255)");
    	return !( ComGetWebColor( document.getElementById(btnNm).style.color ) == BTN_BLUE);
    	
    }     
    /** 
    * (All)combo Change the background color 
    */
    function setChangeAllComboBackColor() {
    	var formObj=document.form;    	
    	setComboBackColor(dcgo_seq);
    	setComboBackColor(rc_seq);
    	setComboBackColor(awk_cgo_seq);
    }
    /** 
    * (Certain)combo Change the background color 
    */
    function setComboBackColor(comboObj) {
    	if ("" != comboObj.GetSelectText()) {
    		comboObj.SetBackColor("#ff0000");
    		comboObj.fontcolor="#ffffff";
    	} else {
    		comboObj.SetBackColor("#ffffff");
    		comboObj.fontcolor="#606060";
    	} 
    }
	/**     
	 *  The specified cell -> Batch change edit
	 */
    function changeAllGetCellEditable(sheetObj, nRow, nSCol, nECol, bFlag) {
        for (var i=nSCol; i<=nECol; i++) {
            sheetObj.SetCellEditable(nRow, i,bFlag);
        }
    }
    /**
     * Td button Disabled
     */
    function checkTdDisabled(srcName) {
    	return !(document.getElementById(srcName).className.indexOf('_1') == -1);
    }
    /**
     * img button Disabled
     */
    function checkInputDisabled(srcName) {
     	return (document.getElementById(srcName).getAttribute("readOnly") || document.getElementById(srcName).getAttribute("isDisabled"));
    }
    //######################[6. Check/Link/Popup]#################################################
    /**
     * handling process for input validation 
     */
    function validateForm(sheetObj, formObj, sAction, delFlg) {
	    if (delFlg == null) {
	    	delFlg="N";
	    }
        with(formObj)
        {
        	switch (sAction) {
        	    case IBSEARCH:
					if (bkg_no.value == "" && bl_no.value == "") {
						//ComShowCodeMessage("BKG00255");
						//ComSetFocus(bkg_no);
						return false;
					}
        	    	break;
        	    case IBSAVE:
        	   	    //0)  Validation Check
        	   	    //if (!ComChkValid(formObj)) return false;
        	   	    if (!ComChkObjValid(bkg_no,          true, true, false)) return false;
        	   	    if (!ComChkObjValid(bl_no,           true, true, false)) return false;
        	   	    if (!ComChkObjValid(act_shpr_cnt_cd, true, true, false)) return false;
        	   	    if (!ComChkObjValid(act_shpr_seq,    true, true, false)) return false;
        	   	    if (!ComChkObjValid(act_shpr_nm,     true, true, false)) return false;
        	   	    if (!ComChkObjValid(dor_loc_cd,      true, true, false)) return false;
        	   	    if (!ComChkObjValid(zn_cd,           true, true, false)) return false;
        	   	    if (!ComChkObjValid(dor_pst_no,      true, true, false)) return false;
        	   	    if (!ComChkObjValid(act_shpr_addr,   true, true, false)) return false;
        	   	    if (!ComChkObjValid(cntc_pson_nm,    true, true, false)) return false;
        	   	    if (!ComChkObjValid(diff_rmk,        true, true, false)) return false;
        	        if (!ComChkObjValid(cntc_phn_no,     true, true, false)) return false;
        	     	if (!ComChkObjValid(cntc_fax_no,     true, true, false)) return false;
  					if (bkg_no.value != oldBkgNo.value) {
  					    ComShowCodeMessage("BKG00448"); 
  					    ComSetFocus(bkg_no);
  					    return false;
  					}
  					formObj.f_del_flg.value=delFlg;  //event (delete:Y, save:N, currSeqSave:C, allConfirmSave:AC) -> R:Request  Not troA
					//1) Dtl : check
					if (!checkDtl(x_sheetObject3)) {
						return false;
					}
					//2) Master : check
					if (!checkMaster(x_sheetObject2)) {
						return false;
					}
        	        if (delFlg == "N" && !ComShowCodeConfirm("COM12147", "")) {
        	    		return false;
        	        } else if (delFlg == "C" && !ComShowCodeConfirm("COM12147", "Current Troseq")) {
        	    		return false;
        	    	}
        	    	break; 
        	}
        }
        return true;
    }
    /**
     * Dtl Grid : Validation check
     */ 
    function checkDtl(sheetObj) {
    	var formObj=document.form;
    	var sheetObj_mst=x_sheetObject2;
    	var strCurrTroSeq=tro_seq.GetSelectText();
    	var delFlg=formObj.f_del_flg.value;
    	var strMsgExistYn="N";
    	for (var i=1; i<=sheetObj.RowCount(); i++) {
			var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
			var t_cxl_flg=sheetObj.GetCellValue(i, "cxl_flg");
    		//01. Request Row Find : 
	   	    //02. Confirm Row Find : 
	   		var nSRow_mst=sheetObj_mst.FindText("tro_seq", t_tro_seq);
	   		var cfm_flg_mst=sheetObj_mst.GetCellValue(nSRow_mst, "cfm_flg");
	   		var cfm_flg_old_mst=sheetObj_mst.GetCellValue(nSRow_mst, "cfm_flg_old");
    		if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) ||     			 
       	   		 (t_cxl_flg == "Y") )  
       		{
       			continue; 
       		}
    		//--------------------->
			//2) Arrival dt
    		var t_dor_arr_dt=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(i, "dor_arr_dt")), "-", "");
    		var t_dor_arr_dt_hhmi=ComReplaceStr(nullToBlank(sheetObj.GetCellValue(i, "dor_arr_dt_hhmi")), ":", "");
			var t_arr_dt=t_dor_arr_dt + t_dor_arr_dt_hhmi;
   	  	    //madatory check 
   			if (cfm_flg_mst != cfm_flg_old_mst)
   			{
    			//1) TP/SZ
   				var t_tpsz=nullToBlank(sheetObj.GetCellValue(i, "cntr_tpsz_cd"));
    			if (t_tpsz == "") {
    				ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+", TP/SZ");
    				return false;
    			}
    			//2) Arrival dt
    			if (t_dor_arr_dt != "" && t_dor_arr_dt_hhmi == "") {
    				ComShowCodeMessage("COM12138", "[Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
    				return false; 
    			}
    			if (t_dor_arr_dt_hhmi != "" && t_dor_arr_dt == "") {
    				ComShowCodeMessage("COM12138", "[Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
    				return false;  
    			}			
    			if (t_arr_dt != "") {
    				var etb_dt=formObj.etb_dt.value;
    				var toDay=ComGetNowInfo("ymd")+ComGetNowInfo("hm");
    				toDay=ComReplaceStr(toDay, "-", ""); 
    				toDay=ComReplaceStr(toDay, ":", "");  
    				if (t_arr_dt <= toDay) {
    					strMsgExistYn="Y";
    				}
    				if (etb_dt != "" && t_arr_dt > etb_dt) {
    					ComShowCodeMessage("COM12133", "[Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Dat", "ETB Date("+etb_dt+")", "lesser");
    					return false;  
    				}  
    			} else {
    				ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+", Door Arrival Date");
    				return false; 
    			}
   			} else {
    			//2) Arrival dt
    			if (t_dor_arr_dt != "" && t_dor_arr_dt_hhmi == "") {
    				ComShowCodeMessage("COM12138", "[Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
    				return false; 
    			}
    			if (t_dor_arr_dt_hhmi != "" && t_dor_arr_dt == "") {
    				ComShowCodeMessage("COM12138", "[Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Date", "Door Arrival Date : hour");
    				return false;  
    			}
    			if (t_arr_dt != "") {
    				var etb_dt=formObj.etb_dt.value;
    				var toDay=ComGetNowInfo("ymd")+ComGetNowInfo("hm");
    				toDay=ComReplaceStr(toDay, "-", ""); 
    				toDay=ComReplaceStr(toDay, ":", "");  
    				if (t_arr_dt <= toDay) {
    					strMsgExistYn="Y";
    				}
    				if (etb_dt != "" && t_arr_dt > etb_dt) {
    					ComShowCodeMessage("COM12133", "[Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", SubSeq:"+sheetObj.GetCellValue(i, "tro_sub_seq")+"] Door Arrival Dat", "ETB Date("+etb_dt+")", "lesser");
    					return false;  
    				}  
    			}
    		}
	   		//<-------------------
    	}
	   	if (strMsgExistYn == "Y") {
	   		ComShowCodeMessage("COM12131", "Door Arrival Date");
	   	} 
    	return true;
    }
    /**
    * Master Grid : Validation check
    */    
    function checkMaster(sheetObj) {
   	    var formObj=document.form;
   	    var strCurrTroSeq=tro_seq.GetSelectText();
   	    var delFlg=formObj.f_del_flg.value;
        var t_Por=formObj.por_cd.value.substr(0,2);
        var t_Pol=formObj.pol_code.value.substr(0,2);
        for (var i=1; i<=sheetObj.RowCount(); i++) {
        	var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
			var t_cxl_flg=sheetObj.GetCellValue(i, "cxl_flg");
			var strCfmFlg=sheetObj.GetCellValue(i, "cfm_flg");
			var strCfmFlg_old=sheetObj.GetCellValue(i, "cfm_flg_old");
 	   	    if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) || 
 	   		     (t_cxl_flg == "Y") ) 
 	   	    {
 		        continue; 
 		    }
    		//------------------------->
        	//Actual Customer Nm : act_shpr_nm
 	   	    var t_act_shpr_nm=nullToBlank(sheetObj.GetCellValue(i, "act_shpr_nm"));
        	if (t_act_shpr_nm == "") {
        		ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", Actual Customer Name");
                return false;
        	}
        	//Location 
        	var t_dor_loc_cd=nullToBlank(sheetObj.GetCellValue(i, "dor_loc_cd"));
        	if (t_dor_loc_cd == "") {
        		ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", Location");
                return false;
        	}
        	var t_zn_cd=nullToBlank(sheetObj.GetCellValue(i, "zn_cd"));
        	if (t_zn_cd == "") {            	
        		ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", Location Zone Code");
                return false;
        	}
        	//Zip
        	var t_zip=nullToBlank(sheetObj.GetCellValue(i, "dor_pst_no"));
            if ("US" == t_Por && t_zip == "") {
            	ComShowCodeMessage("COM12200", "Troseq:"+sheetObj.GetCellValue(i, "tro_seq")+", Zip");
                return false;
            }
            var t_dor_loc_cnt_cd = t_dor_loc_cd.substring(0,2);
            if ( "US" == t_dor_loc_cnt_cd ){
            	if(!ComIsNumber(t_zip) || ComChkLen(t_zip,5) != 2){
            		ComShowCodeMessage("BKG08355", "Troseq:"+sheetObj.GetCellValue(i, "tro_seq"));
            		return false;
            	}
            } 
            //POR-POL CHECK DOR_LOC_CD
            if ("KR" == t_Por || "KR" == t_Pol) {
            	if("KR" != t_dor_loc_cd.substring(0,2)) {
            		ComShowCodeMessage("BKG02017");
            		return false;
            	}
            }
            //<------------------------
        }
        return true;
    }
    /**
     * Actual Customer Select Value setting 
     */     
    function setActCustCallBack(aryPopupData) {
    	/*
    	 * [0] colVal=1
    	 * [1] colVal=USVHH
    	 * [2] colVal=Z1
    	 * [3] colVal=FUJIFILM HOLDINGS AMERICA CORPORATION
    	 * [4] colVal=US
    	 * [5] colVal=
    	 * [6] colVal=
    	 * [7] colVal=
    	 * [8] colVal=
    	 * [9] colVal=
    	 * [10] colVal=200 Summit Lake Drive #2 Valhalla, NY - 10595 United States
    	 * [11] colVal=10595
    	 * [12] colVal=Default appointmentLocation
    	 * [13] colVal=
    	 * [14] colVal=
    	 * [15] colVal=C
    	 * [16] colVal=318651
    	 * [17] colVal=
    	 * [18] colVal=102088
    	 * [19] colVal=ATLBB
    	 * [20] colVal=
    	 */
    	
        var formObj=document.form;        
    	var p_act_shpr_nm=nullToBlank(aryPopupData[0][3]); 
    	var p_cnt_cd=nullToBlank(aryPopupData[0][4]);
    	var p_cntc_pson_nm=nullToBlank(aryPopupData[0][7]);
    	var p_cntc_phn_no=nullToBlank(aryPopupData[0][8]);
    	var p_cntc_mphn_no=nullToBlank(aryPopupData[0][9]);
    	var p_act_shpr_addr=nullToBlank(aryPopupData[0][10]);
//    	var p_act_shpr_addr1=nullToBlank(aryPopupData[0][10]);
//    	var p_act_shpr_addr2=nullToBlank(aryPopupData[0][11]);
//    	var p_act_shpr_addr3=nullToBlank(aryPopupData[0][12]);
    	var p_dor_zip_id=nullToBlank(aryPopupData[0][14]);
    	var p_diff_rmk=nullToBlank(aryPopupData[0][15]);
    	var p_cntc_fax_no=nullToBlank(aryPopupData[0][16]);
    	var p_cntc_eml=nullToBlank(aryPopupData[0][17]);
    	var p_tro_act_cust_knd_cd=nullToBlank(aryPopupData[0][18]);   //E, C
    	var p_cust_seq=nullToBlank(aryPopupData[0][21]); 
        with(formObj) {
			act_shpr_cnt_cd.value=p_cnt_cd;
			act_shpr_seq.value=p_cust_seq;
			act_shpr_nm.value=p_act_shpr_nm;
            //dor_loc_cd.value      = p_loc_cd; 
            //zn_cd.value           = p_zn_cd; 
			dor_pst_no.value=p_dor_zip_id;
//			act_shpr_addr.value=p_act_shpr_addr1+p_act_shpr_addr2+p_act_shpr_addr3;
			act_shpr_addr.value=p_act_shpr_addr
			cntc_pson_nm.value=p_cntc_pson_nm;
			cntc_phn_no.value=p_cntc_phn_no;
			cntc_mphn_no.value=p_cntc_mphn_no;
			cntc_fax_no.value=p_cntc_fax_no;
			diff_rmk.value=p_diff_rmk;
        }
    }
    /**
    * Location popup Select Value setting 
    */
    function getCOM_ENS_061_1(aryPopupData, row, col, sheetIdx) { 
    	var formObj = document.form;
    	var nod_cd=aryPopupData[0][3];
    	if (nod_cd.length == 7) {
        	//POL-POD = 'KR'
        	if(ComGetObjValue(formObj.por_cd).substring(0,2) == 'KR' || ComGetObjValue(formObj.pol_code).substring(0,2) == 'KR')
        	{
        		if(nod_cd.substr(0,2) == "KR") {
            		ComSetObjValue(formObj.dor_loc_cd, nod_cd.substr(0,5));
            		ComSetObjValue(formObj.zn_cd, nod_cd.substr(0,5));
        		} else {
        			ComShowCodeMessage("BKG02017");
            		ComSetObjValue(formObj.dor_loc_cd, "");
            		ComSetObjValue(formObj.zn_cd, "");
        		}
        	}else{
        	    document.form.dor_loc_cd.value=nod_cd.substr(0,5); 
        	    document.form.zn_cd.value=nod_cd.substr(5,7);
        	}
    	}
    }
    //#############################(7. Util/Etc)##################################################    
    function ComEnableObject_loc(obj, bEnable)
    {
        try {
        	//disabled or readOnly 
            switch( obj.type ) {
                case "password" :
                case "text" :
                	obj.readOnly=!bEnable;
                    break;
                default:
                    obj.disabled=!bEnable;
            }
			//Depending on the setting css
            switch( obj.type ) {
                case "select-one" :
                case "text" :
                    if (bEnable){
                        if (obj.className=="input2_2"){	      //Gray - Required fields
                        	obj.className="input1";	      //White - Required fields
                        } else if (obj.className=="input2"){   
                        	obj.className="input";          //White
                        }
                    } else {
                        if (obj.className=="input1"){         
                        	obj.className="input2_2";       //Gray
                        } else if (obj.className=="input"){   
                        	obj.className="input2";         //Gray
                        }
                    }
                    break;
                case "textarea":
                    if (bEnable){
                    	obj.className="textarea";
                    } else {
                    	obj.className="textarea2";
                    }
                    break;
				default :
                    if (obj.tagName=="IMG" || obj.tagName=="img") {
                        if (bEnable){
                            obj.style.cursor="hand";
                            obj.style.filter="";
                        } else {
                            obj.style.cursor="default";
                            obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                        }
                    }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ComEnableManyObjects_loc(bEnable, objs) {
        try {
            var args=arguments;
            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
//	/**
//	 * IBMultiCombo All Enable/Disable   
//	 */
//    function ComEnableManyIBCombo(bEnable, objs) {
//        try {
//            var args=arguments;
//            if (args.length < 2) return;
//            for(var i=1; i<args.length; i++) {
//                if (args[i].tagName != undefined) {
//                	args[i].SetEnable(bEnable);
//                }
//            } 
//        } catch(err) { ComFuncErrMsg(err.message); }
//    }
	/**
	 * IBMultiCombo All Enable/Disable 
	 */
    function ComEnableManyTd(bEnable, objs) {
	    try {
	        var args=arguments;
	        if (args.length < 2) return;
	        for(var i=1; i<args.length; i++) {
	 	    	if (bEnable == true) {
		    		ComBtnEnable(args[i]);
		    	} else {
		    		ComBtnDisable(args[i]);
		    	} 
	        }
	    } catch(err) { ComFuncErrMsg(err.message); }
    }	 
    function callShowMessageAddSeq() {
    	ComShowCodeMessage("COM12130", "click event", "AddSeq button");
    }
    function callShowMessageReProc(strMsgTitle, strMsg2) {
    	if (strMsg2 == null) { strMsg2="rehandling"; }
    	ComShowCodeMessage("COM12242", "Already ["+strMsgTitle+"] process status. "+strMsg2);
    }    
    function callShowMessageBiggerQty(strMsgTitle) {
        ComShowCodeMessage("COM12133", "["+strMsgTitle+"] Total Qty", "or equal to the BKG Qty", "lesser"); 
    }     
	 /**
	 * check_Enter  
	 * @param 
	 * @return 
	 */
	function check_Enter() {
		var formObj=document.form;
    	var srcName=ComGetEvent("name");
    	var srcValue=ComGetEvent("value");
		if (event.keyCode == 13) {
			if(ComGetEvent("name") == "bkg_no" || ComGetEvent("name") == "bl_no"){
				formObj.elements[srcName].value=srcValue.toUpperCase();
				doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
			}
		}
	}
	 /**
	 * searchData : tab to move
	 * bkgNo : 
	 */
	 function searchData(bkgNo){
	 	var formObj=document.form;
	 	ComSetObjValue(formObj.bkg_no ,bkgNo);
	 	ComSetObjValue(formObj.modify_flag,"N");
	 	doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
	 }
	 /**
	  * HTML Control  onblur Event <br>
	  **/
	 function obj_deactivate() {
		if(ComGetEvent("name") != "bkg_no" && ComGetEvent("name") != "bl_no"){
			 if(eval('document.form.'+ComGetEvent("name")).value.length > 0){
				 ComSetObjValue(document.form.modify_flag, "Y");	 
			 }
		} else {
	    	var formObj=document.form;
	    	var srcName=ComGetEvent("name");
	    	var srcValue=ComGetEvent("value");
			formObj.elements[srcName].value=srcValue.toUpperCase();
		}
	  }
	 /**
	 * checkModify:tab to move
	 * param : 
	 */
	 function checkModify(){	
		var formObj=document.form;
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
			tab_alert_msg=false;
			if (!ComShowConfirm(ComGetMsg("BKG00350")))
				return false; // Are you sure to save the changes?
			doActionIBSheet(x_sheetObject2, formObj, IBSAVE);
		}
	 }
	/**
	* setInquiryDisableButton event call .<br>
	* ComBtnDisable -> Disabled
	* @param 
	*/
	function setInquiryDisableButton(){
		ComBtnDisable("btn_t2aSave");
		ComBtnDisable("btn_t2aSaveSeq");
		ComBtnDisable("btn_t2aCancelAll");
		ComBtnDisable("btn_t2aTROCopy");
		ComBtnDisable("btn_t2aAddSeq");
		ComBtnDisable("btn_t2aCopySeq");
		ComBtnDisable("btn_t2aCancelSeq");
		ComBtnDisable("btn_t2aAdd");
		ComBtnDisable("btn_t2aDelete");
		ComBtnDisable("btn_t2aCopy");
	}
	
    /** 
     * Check TRO container qty with booking
     */  
    function checkTroQty(sheetObj_qty) {
       	var cntr_tpsz_cd_msg = "";
       	for(var i=1; i<=sheetObj_qty.RowCount(); i++) {
			var cntr_tpsz_cd=sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd");
			var n_totQty=parseInt(sheetObj_qty.GetCellValue(i, "total_qty"));
			var n_currTroqty=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty"));
   			if (n_totQty < n_currTroqty) {
   				cntr_tpsz_cd_msg += ", " + cntr_tpsz_cd;
   			}   			
       	}
       	
		if(cntr_tpsz_cd_msg!=""){
			ComShowCodeMessage("BKG01194", cntr_tpsz_cd_msg.substr(2));
		}
    }  

    /**
     * trsp_so_no presence check
     */  
     function disableCancelAll() {
 		var sheetObj=x_sheetObject3; 
 		var cnt=sheetObj.RowCount();
 		var flg=false;
 		for (var i=1; i <= cnt; i++){ 
 			var _val=sheetObj.GetCellValue(i, "trsp_so_no");
 			var fr_flg=sheetObj.GetCellValue(i, "fr_flg");
 			var rail_so = sheetObj.GetCellValue(i, "rail_so");
// 			if (_val.length > 0 && fr_flg == ''){
 			if ((_val.length > 0 && fr_flg == '' )|| (rail_so.length > 0)){
 				flg=true;
 				break;
 			}
 		}
 		if(flg){
 			ComBtnDisable("btn_t2aCancelAll");
 		}
     }