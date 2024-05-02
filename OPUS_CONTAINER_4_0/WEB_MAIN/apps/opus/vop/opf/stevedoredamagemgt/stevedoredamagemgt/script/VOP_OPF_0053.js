/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_OPF_0053.js
*@FileTitle  : Stevedore Damage Inquiry & Update 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7 
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class vop_opf_0053 : vop_opf_0053 business script for
     */

   	/* Developer performance	*/
	// common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
       　
	         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		var prefix="sheet1_"
            switch(srcName) {
	            case "vvd_cd_pop":
	            	var vsl_cd=formObject.vvd_cd.value;
	            	ComOpenPopup("VOP_VSK_0219.do?vsl_cd="+vsl_cd, 460, 500, "event_vvd_cd_pop", "0,0", true);
	            	break;
	            case "vps_port_cd_pop":
	            	var port_cd=formObject.vps_port_cd.value;
	            	ComOpenPopup("VOP_VSK_0043.do?port_cd="+port_cd, 500, 520, "event_vps_port_cd_pop", "0,0", true);
	            	break;
	            case "slan_cd_pop":
	            	var slan_cd=formObject.slan_cd.value;
	            	ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 500, 480, "event_slan_cd_pop", "0,0", true);
	            	break;
	            case "cal_stv_dmg_evnt_dt_to":
                	var cal=new ComCalendarFromTo();
                	cal.select(formObject.stv_dmg_evnt_dt_from, formObject.stv_dmg_evnt_dt_to, 'yyyy-MM-dd');
	            	break;
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						//sheetObject1.Down2Excel({ HiddenColumn:-1});
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					}					
					break;
				case "btn_Retrieve":
					if(!ComChkValid(formObject)){
			        	return false;
			        }
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					dataClear(sheetObject1, formObject);
					break;
				case "btn_Open":
					if(sheetObject1.GetSelectRow()>0){
						sheet1_OnDblClick(sheetObject1, sheetObject1.GetSelectRow());
					}else{
						//ComShowMessage("Open Data is not Selected.");
						//ComShowCodeMessage("OPF07012");
					}
					break;
				case "btn_History":
					if(sheetObject1.GetSelectRow()> 0){
						var paramNo=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),"sheet1_stv_dmg_no");
						ComOpenPopup("VOP_OPF_0054.do?stv_dmg_no="+paramNo, 800, 545, "", "0,0", true);
					}
					else{
						//ComShowMessage("There is no Selected Row.");
						//ComShowCodeMessage("OPF07012");
						return false;
					}
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
     * Loading event of HTML Control in page dynamically <br>
     * initializing IBSheet by calling {@link #loadPage}Method <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 
     **/
    function initControl(){
    	axon_event.addListenerFormat('blur',      'obj_deactivate', document.form); 
        axon_event.addListenerFormat('focus',     'obj_activate',   document.form); 
       // axon_event.addListenerFormat('keypress',  'obj_keypress',   document.form); 
    	//axon_event.addListener  ('keypress', 'event_keypress' , 'vvd_cd', 'vps_port_cd', 'slan_cd');
    	//axon_event.addListener  ('keyup', 'event_keyup' , 'vvd_cd', 'vps_port_cd', 'slan_cd', 'stv_dmg_evnt_dt_from', 'cmpn_cost_usd_amt');
    	axon_event.addListener  ('blur', 'change_event' , 'vvd_cd', 'vps_port_cd', 'slan_cd');
    	// Enter Key Search.
       // axon_event.addListener ('keydown', 'ComKeyEnter', 'vvd_cd', 'vps_port_cd', 'slan_cd', 'stv_dmg_evnt_dt_from', 'stv_dmg_evnt_dt_to', 'elapse_day', 'stv_dmg_ref_no', 'cmpn_cost_usd_amt');
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
     * registering IBMultiCombo Object as list <br>
     * defining list on the top of source and this  method called automatically by creating IBMultiCombo object by {@link CoObject#ComComobject} <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
     /**
      * setting Combo
      * set item of Combo
      */
     function initCombo(comboObj) {
     	with(comboObj) {
     		switch(comboObj.id) {
 		        case "vsl_type_cd":
 	            	SetTitle("Category");
 	            	//SetColWidth("100|50|200")
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		        case "stv_dmg_req_cate_cd":
 	            	SetTitle("Category");
 	            	//SetColWidth("100|50|200")
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		        case "stv_dmg_rpr_proc_sts_cd":
 	            	SetTitle("Repair");
 	            	//SetColWidth("100|50|200")
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		        case "stv_dmg_cmpn_proc_sts_cd":
 	            	SetTitle("Compensation");
 	            	//SetColWidth("100|50|200")
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		        case "stv_dmg_stl_proc_sts_cd":
 	            	SetTitle("Settlement");
 	            	//SetColWidth("100|50|200")
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		    }
     	}
 	}
    /**
     * Input only number in onkeypress event of HTML Control <br>
     **/
//    function obj_keypress(){
//    	ComKeyOnlyNumber(event.srcElement,'.');
//    }
    /**
     * delete mask separator in onfocus event of HTML Control <br>
     **/
    function obj_activate(){
        ComClearSeparator(ComGetEvent());
        event.srcElement.select();
    }
    /**
     *checking validation on onblur event of HTML Control<br>
     **/
    function obj_deactivate(){
    	// dataformat Validation Check!
    	ComChkObjValid(ComGetEvent());
    }
    /**
     * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
     **/
//    function vsl_type_cd_OnKeyDown(comboObj, keyCode, text) {
//    	 if(keyCode==13){
//    		 var obj=document.getElementById("btn_Retrieve");
//     		 obj.fireEvent("onclick");
//    	 }
//    }
    /**
     * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
     **/
//    function stv_dmg_req_cate_cd_OnKeyDown(comboObj, keyCode, text) {
//    	 if(keyCode==13){
//    		 var obj=document.getElementById("btn_Retrieve");
//     		 obj.fireEvent("onclick");
//    	 }
//    }
    /**
     * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
     **/
//    function stv_dmg_rpr_proc_sts_cd_OnKeyDown(comboObj, keyCode, text) {
//     	 if(keyCode==13){
//     		 var obj=document.getElementById("btn_Retrieve");
//      		 obj.fireEvent("onclick");
//     	 }
//    }
    /**
     * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
     **/
    function stv_dmg_cmpn_proc_sts_cd_OnKeyDown(comboObj, keyCode, text) {
     	 if(keyCode==13){
     		 var obj=document.getElementById("btn_Retrieve");
      		 obj.fireEvent("onclick");
     	 }
    }
    /**
     * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
     **/
    function stv_dmg_stl_proc_sts_cd_OnKeyDown(comboObj, keyCode, text) {
     	 if(keyCode==13){
     		 var obj=document.getElementById("btn_Retrieve");
      		 obj.fireEvent("onclick");
     	 }
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
			for(i=0;i<sheetObjects.length;i++){
	        //change start configuration method name 
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
	        //add last configuration method 
				ComEndConfigSheet(sheetObjects[i]);
			}
			//initializing Combo Object
	    	for(var k=0; k<comboObjects.length; k++){
	        	initCombo(comboObjects[k]);
	        }
			initControl();
			setDefaultComboData(sheetObjects[0], document.form);
			ComAddSeparator(document.form.stv_dmg_evnt_dt_to);
			setSubButton();
			document.form.stv_dmg_evnt_dt_to.value=ComGetNowInfo("ymd");
	}
    /**
     * initializing page. <br>
     **/
    function dataClear(sheetObj, formObj) {
    	formObj.vvd_cd.value="";
    	formObj.vps_port_cd.value="";
    	formObj.slan_cd.value="";
    	formObj.stv_dmg_evnt_dt_from.value="";
    	formObj.stv_dmg_evnt_dt_from.value="2001-01-01";
    	formObj.stv_dmg_evnt_dt_to.value=ComGetNowInfo("ymd");
    	formObj.elapse_day.value="";
    	formObj.stv_dmg_ref_no.value="";
    	formObj.cmpn_cost_usd_amt.value="";
    	comboObjects[0].SetSelectIndex(0);
    	comboObjects[1].SetSelectIndex(0);
    	comboObjects[2].SetSelectIndex(0);
    	comboObjects[3].SetSelectIndex(0);
    	comboObjects[4].SetSelectIndex(0);
    	sheetObj.RemoveAll();
    }
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(sheetObj, formObj) {
    	var comboXml=sheetObj.GetSearchData("VOP_OPF_0053GS.do" , FormQueryString(formObj));
    	// Vessel Category Combo List Set..
    	var vslCateCode=ComGetEtcData(comboXml, "vslCategory");
    	if(!isNull(vslCateCode)){
    		setComboItem(comboObjects[0], vslCateCode);
    	}
    	// Category Combo List Set..
    	var categoryCode=ComGetEtcData(comboXml, "categoryCode");
    	if(!isNull(categoryCode)){
    		setComboItem(comboObjects[1], categoryCode);
    	}
    	// Repair Combo List Set..
    	var repairCode=ComGetEtcData(comboXml, "repairCode");
    	if(!isNull(repairCode)){
    		setComboItem(comboObjects[2], repairCode);
    	}
    	// Compensation Combo List Set..
    	var compenCode=ComGetEtcData(comboXml, "compenCode");
    	if(!isNull(compenCode)){
    		setComboItem(comboObjects[3], compenCode);
    	}
    	// Settlement Combo List Set..
    	var stlmntCode=ComGetEtcData(comboXml, "stlmntCode");
    	if(!isNull(stlmntCode)){
    		setComboItem(comboObjects[4], stlmntCode);
    	}
    	// Default Combo Data Set..
    	comboObjects[0].SetSelectIndex(0);
    	comboObjects[1].SetSelectIndex(0);
    	comboObjects[2].InsertItem(1, "None", "None");
    	comboObjects[2].SetSelectIndex(0);
    	comboObjects[3].InsertItem(1, "None", "None");
    	comboObjects[3].SetSelectIndex(0);
    	comboObjects[4].InsertItem(1, "None", "None");
    	comboObjects[4].SetSelectIndex(0);
    }
    /**
     * adding data on combo field
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList=comboItems.split("|");
    	for (var i=0 ; i < dataList.length ; i++) {
    		var comboItem=dataList[i].split(",");
    		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
    	}
    	comboObj.InsertItem(0, "All", "All");
    }
    /**
     *  method which input code data capital.
     */
//    function event_keypress() {
//        if(event.srcElement.name=="vvd_cd" || event.srcElement.name=="slan_cd")
//        {
//        	//capital & input only number
//            ComKeyOnlyAlphabet('uppernum');
//        }else{
//        	ComKeyOnlyAlphabet('upper');
//        }
//    }
     /**
      * in case of inputting Data Max Length , Focus change method.
      */
//     function event_keyup() {
//     	ComKeyEnter('LengthNextFocus');
//    	if(event.srcElement.name=="cmpn_cost_usd_amt"){
//    		var str=event.srcElement.value;
//    		if(str.indexOf(".") > 0 && str.substring(str.indexOf(".")).length > 3){
//    			event.srcElement.value=str.substring(0,str.length-1);
//    			return false;
//    		}
//    	}
//     }
    /**
     * popup Data Validation method input in Key
     */
    function change_event() {
    	var elementObj=ComGetEvent();
    	var sheetObj=sheetObjects[0];
    	var gubun="";
    	if(!isNull(elementObj.value)){
    		// Length Check
        	if(elementObj.maxLength != elementObj.value.length){
        		ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
        		//elementObj.focus();
        		elementObj.select();
        		return false;
        	}
    		if(elementObj.name=="vvd_cd"){
    			gubun="vvdCd";
        	}
        	else if(elementObj.name=="vps_port_cd"){
        		gubun="portCd";
        	}
        	else if(elementObj.name=="slan_cd"){
        		gubun="slanCd";
        	}
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }
    /**
     * vvd_cd Data PopUp Value input method.
     */
    function event_vvd_cd_pop(aryPopupData) {
    	document.form.vvd_cd.value=aryPopupData[0][1];
    }
    /**
     * vps_port_cd Data PopUp Value input method.
     */
    function event_vps_port_cd_pop(aryPopupData) {
    	document.form.vps_port_cd.value=aryPopupData[0][2];
    }
    /**
     * slan_cd Data PopUp Value input method.
     */
    function event_slan_cd_pop(aryPopupData) {
    	document.form.slan_cd.value=aryPopupData[0][1];
    }
    /**
     * slan_cd Data PopUp Value input method.
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var formObj=document.form;
    	ComOpenPopup("VOP_OPF_1053.do?stv_dmg_no="+sheetObj.GetCellValue(row,"sheet1_stv_dmg_no"), 1000, 730, "", "0,0", true);
    }
     /**
      * slan_cd Data PopUp Value input method.
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) 
     {
    	 with(sheetObj)
 		 {
    		 //CellFontColor(0,prefix+"dmg_auth_sts_cd") = "#FF0000";
 	         //sheetObj.ColFontColor("sheet1_dmg_auth_sts_cd") = "#0000FF";
    		 for(var i=2; i < LastRow(); i++){
    			 if(GetCellValue(i,"sheet1_dmg_auth_sts_cd")=="Y" || GetCellValue(i,"sheet1_dmg_auth_sts_cd")=="N")
    			 {
    				 SetCellFont("FontColor", i, "sheet1_dmg_auth_sts_cd","#FF0000");
    				 SetCellFont("FontBold", i, "sheet1_dmg_auth_sts_cd",1);
    			 }
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
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
		             var HeadTitle1="|SDMS No.|VVD CD|Port|Damage\nDate|Damage\nCategory|Elapsed\nDays|APVL|Damage\nRequirement|Process|Process|Process|Requirement|Requirement";
		             var HeadTitle2="|SDMS No.|VVD CD|Port|Damage\nDate|Damage\nCategory|Elapsed\nDays|APVL|Damage\nRequirement|Repair|Compen.|Settle|Port|ETA";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             (headCount, 0, 0, true);
		             var prefix="sheet1_";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_evnt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"elapse_day",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dmg_auth_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_req_cate_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_rpr_proc_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_cmpn_proc_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"stv_dmg_stl_proc_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"req_port_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"req_eta_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetRangeBackColor(1,1,1,13,"#555555");
		             //SetSheetHeight(360);
		             resizeSheet();
               }
                break;
        }
    }
    
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
    	sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	      case IBSEARCH:
	    	if(!ComChkValid(formObj)){
	    		return false;
	    	}
	        formObj.f_cmd.value=SEARCH;
	        sheetObj.DoSearch("VOP_OPF_0053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
	        break;
	      case IBROWSEARCH:
	    	  if(gubun=="vvdCd"){
	    		  formObj.f_cmd.value=COMMAND16;
	    		  var vslXml=sheetObj.GetSearchData("VOP_VSK_0219GS.do?vsl_cd="+formObj.vvd_cd.value , FormQueryString(formObj));
	    		  var strVslCd=ComGetEtcData(vslXml, "vsl_eng_nm");
	    		  if(isNull(strVslCd)){
	    			  //ComShowMessage("Data is not available.");
					  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.vvd_cd.value="";
	    			  formObj.vvd_cd.focus();
	    			  return;
	    		  }else{
	    			  formObj.vps_port_cd.focus();
	    		  }
	    	  }
	    	  else if(gubun=="portCd"){
	    		  formObj.f_cmd.value=COMMAND13;
	    		  var polXml=sheetObj.GetSearchData("VOP_VSK_0043GS.do?loc_cd="+formObj.vps_port_cd.value , FormQueryString(formObj));
	    		  var strPolCd=ComGetEtcData(polXml, "port_name");
	    		  if(isNull(strPolCd)){
	    			  //ComShowMessage("Data is not available.");
					  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.vps_port_cd.value="";
	    			  formObj.vps_port_cd.focus();
	    			  return;
	    		  }else{
	    			  formObj.slan_cd.focus();
	    		  }
	    	  }
	    	  else if(gubun=="slanCd"){
    	    	  var auto_skd_cng_flg="LANE";
    	    	  var lane_cd="";
    	    	  lane_cd=formObj.slan_cd.value; 
    	    	  formObj.f_cmd.value=COMMAND01;
    	    	  var resultXml=sheetObj.GetSearchData("VOP_OPF_0052GS.do?f_cmd="+COMMAND01+"&auto_skd_cng_flg="+auto_skd_cng_flg+"&slan_cd="+lane_cd);
	    		  var strLanCdDesc=ComGetEtcData(resultXml, "result_chk");
    	    	  if (strLanCdDesc==null ||strLanCdDesc =="null"|| strLanCdDesc=="" || strLanCdDesc==undefined){
					  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.slan_cd.value="";
	    			  formObj.slan_cd.focus();
    	    		  return false;
	  	    	  } else {
	  	    		  return true;
	  	    	  }
	    	  }
	    	  break;
	    }
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }
    /**
     * checking Null in window form input value
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
    /**
     * setting Disable/Enable of sub button <br>
     **/
    function setSubButton(){
    	var formObj=document.form;
    		 ComBtnEnable("btn_Open");
    }
    //occur event in case of Close on VOP_OPF_1053 
    function call_1053(){
        var sheetObject1=sheetObjects[0];
        var formObject=document.form;		
		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    }    
	/* Developer performance  end */
