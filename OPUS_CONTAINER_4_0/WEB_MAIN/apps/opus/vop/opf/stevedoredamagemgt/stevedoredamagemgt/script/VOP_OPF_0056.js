/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0056.js
*@FileTitle  : SDMS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class vop_opf_0056 : vop_opf_0056 business script for 
     */
   	/* Developer performance	*/
    var sheetObjects=new Array(); 
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
       　
	     var sheetObject1=sheetObjects[0];
	     var sheetObject2=sheetObjects[1];
	     var sheetObject3=sheetObjects[2];
	     var sheetObject4=sheetObjects[3];
	     var sheetObject5=sheetObjects[4];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false; 
            switch(srcName) {
            	case "cal_stv_dmg_evnt_dt_to":
            		var cal=new ComCalendarFromTo();
//                	cal.select(formObject.stv_dmg_evnt_dt_from, formObject.stv_dmg_evnt_dt_to, 'yyyy-MM-dd');
                	//var cal=new ComCalendar();
//                    cal.select(formObject.stv_dmg_evnt_dt_from, 'yyyy-MM-dd');
                    cal.select(formObject.stv_dmg_evnt_dt_from, formObject.stv_dmg_evnt_dt_to, 'yyyy-MM-dd');

            		break;
            	case "loc_cd_pop":
            		ComOpenPopup("COM_ENS_0M1.do", 564, 490, "loc_cd_pop_event", "1,0,1", true);
            		break;
            	case "vps_port_cd_pop":
            		var port_cd=formObject.vps_port_cd.value;
            		ComOpenPopup("VOP_VSK_0043.do?port_cd="+port_cd, 425, 520, "vps_port_cd_pop_event", "0,0", true); 
            		break;
            	case "slan_cd_pop":
            		var slan_cd=formObject.slan_cd.value;
            		ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 425, 480, "slan_cd_pop_event", "0,0", true);
            		break;
            	case "vsl_cd_pop":
            		ComOpenPopup("COM_ENS_0A1.do", 620, 470, "vsl_cd_pop_event", "1,0,1", true);
            		break;
            	case "btn_t1DownExcel":
            		//sheetObject1.Down2Excel(-1);
            		
	                var paramObj=new Object();
	                paramObj.title="Performance";
	                paramObj.columnwidth=ComOpfGetExcelDown(sheetObject1);
	                paramObj.cols=ComOpfGetExcelDownCols(sheetObject1); 		                
	                var url=ComOpfGetPgmTitle(sheetObject1, paramObj); 
	               
                    if(sheetObject1.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
        	       		//var pathArr = url.split("?");
	       	       		var str = sheetObjects[0].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1,ReportXML:str});
        	       	}
            		
//                    var paramObj=new Object();
//                    paramObj.title="";
//                    paramObj.datarowheight="1:30";
//                    paramObj.columnwidth="1:8|2:20|3:20|4:22|5:22|6:24";
//                    var url=ComOpfGetExcelSet(sheetObject1, paramObj);
//                    if(sheetObject1.RowCount() < 1){//no data
//                    	ComShowCodeMessage("COM132501");
//                    }else{
//                    	//sheetObject1.Down2Excel({ HiddenColumn:-1,Merge:true,URL:"url"});
//                    	sheetObject1.Down2Excel({ HiddenColumn:-1,Merge:true});
//                    }
            		break;
            	case "btn_t2DownExcel":
            		//sheetObject2.Down2Excel(-1);
            		
	                var paramObj=new Object();
	                paramObj.title="Damage";
	                paramObj.columnwidth=ComOpfGetExcelDown(sheetObject2);
	                paramObj.cols=ComOpfGetExcelDownCols(sheetObject2); 		                
	                var url=ComOpfGetPgmTitle(sheetObject2, paramObj); 
	               
                    if(sheetObject2.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
        	       		//var pathArr = url.split("?");
	       	       		var str = sheetObjects[0].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1,ReportXML:str});
        	       	}
            		
//                    var paramObj=new Object();
//                    paramObj.title="";
//                    paramObj.orientation="Portrait";
//                    paramObj.columnwidth="1:5|2:9|3:8|4:8|5:8|6:12|7:8|8:8|9:9";
//                    var url=ComOpfGetExcelSet(sheetObject2, paramObj);
//                    if(sheetObject2.RowCount() < 1){//no data
//                    	ComShowCodeMessage("COM132501");
//                    }else{
//                    	//sheetObject2.Down2Excel({ HiddenColumn:-1,Merge:true,URL:"url"});
//                    	sheetObject2.Down2Excel({ HiddenColumn:-1,Merge:true});
//                    }
            		break;
            	case "btn_t3DownExcel":
            		//sheetObject3.Down2Excel(-1);
            		
	                var paramObj=new Object();
	                paramObj.title="Repair";
	                paramObj.columnwidth=ComOpfGetExcelDown(sheetObject3);
	                paramObj.cols=ComOpfGetExcelDownCols(sheetObject3); 		                
	                var url=ComOpfGetPgmTitle(sheetObject3, paramObj); 
	               
                    if(sheetObject3.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
        	       		//var pathArr = url.split("?");
	       	       		var str = sheetObjects[0].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObject3.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject3), SheetDesign:1,Merge:1,ReportXML:str});
        	       	}            		
            		
//                    var paramObj=new Object();
//                    paramObj.title="";
//                    paramObj.orientation="Portrait";
//                    paramObj.columnwidth="1:5|2:12|3:12|4:12|5:12|6:12|7:12";
//                    var url=ComOpfGetExcelSet(sheetObject3, paramObj);
//                    if(sheetObject3.RowCount() < 1){//no data
//                    	ComShowCodeMessage("COM132501");
//                    }else{
//                    	//sheetObject3.Down2Excel({ HiddenColumn:-1,Merge:true,URL:"url"});
//                    	sheetObject3.Down2Excel({ HiddenColumn:-1,Merge:true});
//                    }
            		break;
            	case "btn_t4DownExcel":
            		//sheetObject4.Down2Excel(-1);
	                var paramObj=new Object();
	                paramObj.title="Compensation";
	                paramObj.columnwidth=ComOpfGetExcelDown(sheetObject4);
	                paramObj.cols=ComOpfGetExcelDownCols(sheetObject4); 		                
	                var url=ComOpfGetPgmTitle(sheetObject4, paramObj); 
	               
                    if(sheetObject4.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
        	       		//var pathArr = url.split("?");
	       	       		var str = sheetObjects[0].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObject4.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject4), SheetDesign:1,Merge:1,ReportXML:str});
        	       	}             		
//                    var paramObj=new Object();
//                    paramObj.title="";
//                    paramObj.orientation="Portrait";
//                    paramObj.datarowheight="1:30";
//                    paramObj.columnwidth="1:5|2:9|3:8|4:8|5:9|6:9|7:9|8:9|9:9";
//                    var url=ComOpfGetExcelSet(sheetObject4, paramObj);
//                    if(sheetObject4.RowCount() < 1){//no data
//                    	ComShowCodeMessage("COM132501");
//                    }else{
//                    	//sheetObject4.Down2Excel({ HiddenColumn:-1,Merge:true,URL:"url"});
//                    	sheetObject4.Down2Excel({ HiddenColumn:-1,Merge:true});
//                    }
            		break;
            	case "btn_t5DownExcel":
            		//sheetObject5.Down2Excel(-1);
	                var paramObj=new Object();
	                paramObj.title="Settlement";
	                paramObj.columnwidth=ComOpfGetExcelDown(sheetObject5);
	                paramObj.cols=ComOpfGetExcelDownCols(sheetObject5); 		                
	                var url=ComOpfGetPgmTitle(sheetObject5, paramObj); 
	               
                    if(sheetObject5.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
        	       		//var pathArr = url.split("?");
	       	       		var str = sheetObjects[0].GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetObject5.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject5), SheetDesign:1,Merge:1,ReportXML:str});
        	       	}
//                    var paramObj=new Object();
//                    paramObj.title="";
//                    paramObj.orientation="Portrait";
//                    paramObj.columnwidth="1:8|2:36|3:36";
//                    var url=ComOpfGetExcelSet(sheetObject5, paramObj);
//                    if(sheetObject4.RowCount() < 1){//no data
//                    	ComShowCodeMessage("COM132501");
//                    }else{
//                    	//sheetObject5.Down2Excel({ HiddenColumn:-1,Merge:true,URL:"url"});
//                    	sheetObject5.Down2Excel({ HiddenColumn:-1,Merge:true});
//                    }
            		break;
				case "btn_Retrieve":
					if(validateForm(sheetObject1,formObject)){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
				case "btn_new":
					dataClear(formObject);
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
     function initCombo(comboObj, comboId) {
    	var i=0;
    	var objCb = comboObj.options;
     	with(comboObj) {
     		switch(objCb.id) {
 		        case "vsl_oshp_cntr_blk_tp_cd":
 	            	SetTitle("Category");
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		        case "group_by":
 					with(comboObj) {
 						comboObj.SetDropHeight(270);
 						InsertItem(i++,  "By Month/Qtr/Half/Year", "A");
 						InsertItem(i++,  "By Port               ", "D");
 						InsertItem(i++,  "By Country            ", "C");
 						InsertItem(i++,  "By Lane               ", "E");
 						InsertItem(i++,  "By Vessel             ", "F");
 						InsertItem(i++,  "By Damage Category    ", "G");
 						InsertItem(i++,  "By Damage Part        ", "H");
 						InsertItem(i++,  "By Responsible Party  ", "I");
 						InsertItem(i++,  "By Vessel Category    ", "B");
						comboObj.SetSelectCode("A");
 		        	}
 		            break; 		            
 		        case "stv_dmg_prt_cate_cd":
 	            	SetTitle("Category");
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		        case "stv_dmg_prt_cd":
 	            	SetTitle("Code|Description");
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		        case "stv_dmg_tp_cd":
 	            	SetTitle("Code|Description");
 	            	SetDropHeight(230);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 	            	SetUseAutoComplete(1);
 		            break;
 		        case "stv_dmg_respb_pty_kwn_flg":
 					//with(comboObj) {
 						comboObj.SetDropHeight(120);
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "Yes", "Y");
 						InsertItem(i++,  "No", "N");
						comboObj.SetSelectText("All");
 		        	//}
 		            break;
 		        case "stv_dmg_step_cd":
 					//with(comboObj) {
 						comboObj.SetDropHeight(120);
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "Repair", "R");
 						InsertItem(i++,  "Supply", "S");
 						InsertItem(i++,  "Quotation", "Q");
						comboObj.SetSelectText("All");
 		        	//}
 		            break;
 		        case "stv_dmg_rpr_proc_sts_cd":
 					//with(comboObj) {
 						comboObj.SetDropHeight(120);
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "None", "NN");
 						InsertItem(i++,  "Ordered", "O");
 						InsertItem(i++,  "Repairing", "R");
 						InsertItem(i++,  "Completed", "C"); 						
 						InsertItem(i++,  "Quoted", "Q");
						comboObj.SetSelectText("All");
 		        	//}
 		            break;
 		        case "stv_dmg_cmpn_proc_sts_cd":
 					//with(comboObj) {
 						comboObj.SetDropHeight(240);
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "None        ", "NN");
 						InsertItem(i++,  "Ready       ", "R");
 						InsertItem(i++,  "Claimed     ", "C");
 						InsertItem(i++,  "Noticed     ", "N");
 						InsertItem(i++,  "Accepted    ", "A");
 						InsertItem(i++,  "Rejected    ", "J");
 						InsertItem(i++,  "Completed   ", "P");
 						InsertItem(i++,  "Cancellation", "E");
 						comboObj.SetSelectText("All");
 		        	//}
 		            break;
 		        case "stv_dmg_stl_proc_sts_cd":
 					with(comboObj) {
 						comboObj.SetDropHeight(90);
 						InsertItem(i++,  "All", " ");
 						InsertItem(i++,  "None", "NN");
 						InsertItem(i++,  "Paid ", "P");
 						comboObj.SetSelectText("All");
 		        	}
 		            break; 		            
 		    }
     	}
 	}
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Setting Tab
     * Set item of Tab
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "Performance" , "");
                    InsertItem( "Damage" , "");
                    InsertItem( "Repair" , "");
                    InsertItem( "Compensation" , "");
                    InsertItem( "Settlement" , "");
                }
             break;
         }
    }
    /**
     * In case of clicking Tab event relation
     * activate element of Tab chosen
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[beforetab].style.display="none";
    	objs[nItem].style.display="Inline";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    	
    	
    	var excelBtn=document.all.item("excelDiv");
    	excelBtn[beforetab].style.display="none";
    	excelBtn[nItem].style.display="Inline";
    	
    	
    	resizeSheet();
    }
     /**
      * loc_cd Data PopUp Value input method.
      */
     function loc_cd_pop_event(aryPopupData) {
     	document.form.loc_cd.value=aryPopupData[0][3];
     }
    /**
     * vps_port_cd Data PopUp Value input method.
     */
    function vps_port_cd_pop_event(aryPopupData) {
//    	document.form.vps_port_cd.value=aryPopupData[0][2];
    	document.form.vps_port_cd.value=aryPopupData;
    }
    /**
     * slan_cd Data PopUp Value input method.
     */
    function slan_cd_pop_event(aryPopupData) {
    	document.form.slan_cd.value=aryPopupData[0][1];
    }
     /**
      * vsl_cd Data PopUp Value input method.
      */
     function vsl_cd_pop_event(aryPopupData) {
     	document.form.vsl_cd.value=aryPopupData[0][3];
     }
    /**
     * popup Data Validation method input in Key
     */
    function focus_event() {
    	var objEvt = ComGetEvent();
    	objEvt.select();
    }
    /**
     * popup Data Validation method input in Key
     */
    function blur_event() {
    	var elementObj=ComGetEvent();
    	var sheetObj=sheetObjects[0];
    	var gubun="";
    	if(!isNull(elementObj.value)){
    		// Length Check
	    	if(elementObj.maxLength != elementObj.value.length){
	    		//ComShowMessage(elementObj.caption+" is must be input data "+elementObj.maxLength+" Length.");
	    		ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
	    		elementObj.focus();
	    		return false;
	    	}
    		// Popup Data Validation Check!
    		if(elementObj.name=="loc_cd"){
    			gubun="locCd";
        	}
        	else if(elementObj.name=="vps_port_cd"){
        		gubun="portCd";
        	}
        	else if(elementObj.name=="slan_cd"){
        		gubun="slanCd";
        	}
        	else if(elementObj.name=="vsl_cd"){
        		gubun="vslCd";
        	}
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(comboXml) {
    	//Vessel Category Combo List Set..
    	var vslCateCode=ComGetEtcData(comboXml, "vslCategory");
    	setComboItem(comboObjects[0], vslCateCode);
    	comboObjects[0].InsertItem(0, "All", "All");
    	comboObjects[0].SetSelectIndex(0);
    	//Damage Category Combo List Set..
    	var categoryCode=ComGetEtcData(comboXml, "categoryCode");
    	setComboItem(comboObjects[2], categoryCode);
    	//Damage Type Combo List Set..
    	var damageCode=ComGetEtcData(comboXml, "damageCode");
    	setComboItem2(comboObjects[4], damageCode);
    }
    /**
     * Data Clear <br>
     **/
    function dataClear(formObj) {
		ComResetAll();
		ComAddSeparator(document.form.stv_dmg_evnt_dt_from);
        ComAddSeparator(document.form.stv_dmg_evnt_dt_to);
    	comboObjects[0].SetSelectIndex(0);
    	comboObjects[1].SetSelectIndex(0);
    	comboObjects[2].SetSelectIndex("");
    	comboObjects[3].SetSelectIndex("");
    	comboObjects[4].SetSelectIndex("");
    	comboObjects[5].SetSelectIndex(0);
    	comboObjects[6].SetSelectIndex(0);
    	comboObjects[7].SetSelectIndex(0);
    	comboObjects[8].SetSelectIndex(0);
    	comboObjects[9].SetSelectIndex(0);
    	sheetObjects[0].RemoveAll();
    	sheetObjects[1].RemoveAll();
    	sheetObjects[2].RemoveAll();
    	sheetObjects[3].RemoveAll();
    	sheetObjects[4].RemoveAll();
    	formObj.stv_dmg_evnt_dt_from.focus();
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(strUsrId, strUsrNm, strOffcCd) {
    	for(i=0;i<sheetObjects.length;i++){
			//change start configuration method name 
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//add last configuration method 
			ComEndConfigSheet(sheetObjects[i]);
		}
		// initializing Combo Object
    	for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k]);
        }
    	// initializing Tab 
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
		
		resizeSheet();
		
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "Combo");
		ComAddSeparator(document.form.stv_dmg_evnt_dt_from);
        ComAddSeparator(document.form.stv_dmg_evnt_dt_to);
        comboObjects[0].SetSelectIndex(0);
		document.form.stv_dmg_evnt_dt_from.focus();
		//document.form.vsl_oshp_cntr_blk_tp_cd.select();
		comboObjects[5].SetSelectIndex(0);
		comboObjects[6].SetSelectIndex(0);
		comboObjects[7].SetSelectIndex(0);
		comboObjects[8].SetSelectIndex(0);
		comboObjects[9].SetSelectIndex(0);
		
		var objs=document.all.item("tabLayer");
		for(var j=1; j<objs.length; j++) {
			objs[j].style.display="none";
		}
	}
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }

    
    /**
     * Loading event of HTML Control in page dynamically <br>
     * initializing IBSheet by calling {@link #loadPage}Method <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 
     **/
    function initControl(){
    	//axon_event.addListenerFormat('blur',      'obj_deactivate', document.form); 
        //axon_event.addListenerFormat('focus',     'obj_activate',   document.form); 
        //axon_event.addListenerFormat('keypress',  'obj_keypress',   document.form); 
    	//axon_event.addListener  ('keypress', 'eng_keypress' , 'loc_cd', 'vps_port_cd', 'slan_cd', 'vsl_cd');
    	//axon_event.addListener  ('keyup', 'obj_keyup' , 'stv_dmg_evnt_dt_from');
    	//axon_event.addListener  ('blur', 'blur_event' , 'loc_cd'
//														, 'vps_port_cd'
//														, 'slan_cd'
//														, 'vsl_cd');
    	//axon_event.addListener  ('focus', 'focus_event' , 'loc_cd', 'vps_port_cd', 'slan_cd', 'vsl_cd');
    	// Enter Key Search.
        //axon_event.addListener ('keydown', 'ComKeyEnter', 'stv_dmg_evnt_dt_from', 'stv_dmg_evnt_dt_to'
        												//, 'vsl_oshp_cntr_blk_tp_cd'
//        												, 'group_by'
//        												, 'loc_cd'
//        												, 'vps_port_cd'
//        												, 'slan_cd'
//        												, 'vsl_cd'
        												//, 'stv_dmg_prt_cate_cd'
        												//, 'stv_dmg_prt_cd'
        												//, 'stv_dmg_tp_cd'
//        												, 'stv_dmg_respb_pty_kwn_flg'
//        												, 'stv_dmg_step_cd'
//        												, 'stv_dmg_rpr_proc_sts_cd'
//        												, 'stv_dmg_cmpn_proc_sts_cd'
//        												, 'stv_dmg_stl_proc_sts_cd');
    }
    /**
     * Input only capital in onkeypress event of HTML Control <br>
     **/
    function eng_keypress() {
    	var objEvt = ComGetEvent();
    	if(objEvt.name=="vvd_cd" || objEvt.name=="slan_cd" ||objEvt.name=="vsl_cd")
        {
            ComKeyOnlyAlphabet('uppernum');
        }else{
        	ComKeyOnlyAlphabet('upper');
        }
    }
    /**
     * change focus, in case of inputting Max Length of certain data . <br>
     **/
    function obj_keyup() {
    	ComKeyEnter('LengthNextFocus');
    }
    /**
     * Input only number in onkeypress event of HTML Control <br>
     **/
    function obj_keypress(){
    	ComKeyOnlyNumber(event.srcElement);
    }
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
     	var formObj=document.form;
     	var elementObj=ComGetEvent();
    	if(!isNull(elementObj.value)){
	    	// dataformat Validation Check!
	    	if(!ComChkObjValid(elementObj)){
	    		elementObj.value="";
	    		elementObj.focus();
	    		return false;
	    	}	
	    	// From To Date Validation Check!
    		if(elementObj.name=="stv_dmg_evnt_dt_from")
        	{
        		var dateFlagFrom=ComGetDaysBetween(elementObj.value, formObj.stv_dmg_evnt_dt_to.value);
        		if(dateFlagFrom < 0){
        			//ComShowMessage("[From Date] must be earlier than [To Date].");
        			ComShowCodeMessage("OPF50013", "To Date", "From Date");
        			elementObj.value="";
        			elementObj.focus();
        			return false;
        		}
        	}
        	else if(elementObj.name=="stv_dmg_evnt_dt_to"){
        		var dateFlagTo=ComGetDaysBetween(formObj.stv_dmg_evnt_dt_from.value, elementObj.value);
        		if(dateFlagTo < 0){
        			//ComShowMessage("[To Date] must be later than [From Date].");
        			ComShowCodeMessage("OPF50013", "To Date", "From Date");
        			elementObj.value="";
        			elementObj.focus();
        			return false;
        		}
        		formObj.vsl_oshp_cntr_blk_tp_cd.focus();
        	}
    	}
		if(elementObj.name=="stv_dmg_evnt_dt_to"){
			formObj.vsl_oshp_cntr_blk_tp_cd.focus();
		}
    }
     /**
      * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
      **/
     function vsl_oshp_cntr_blk_tp_cd_OnKeyDown(comboObj, keyCode, text) {
    	 if(keyCode==13){
    		 var obj=document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
    	 //ComKeyEnter();
     }
     /**
      * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
      **/
     function stv_dmg_prt_cate_cd_OnKeyDown(comboObj, keyCode, text) {
    	 if(keyCode==13){
    		 var obj=document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
     }
     /**
      * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
      **/
     function stv_dmg_prt_cd_OnKeyDown(comboObj, keyCode, text) {
    	 if(keyCode==13){
    		 var obj=document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
     }
     /**
      * occur retrieve event in  case of inputting Combo Object Enter Key. <br>
      **/
     function stv_dmg_tp_cd_OnKeyDown(comboObj, keyCode, text) {
    	 if(keyCode==13){
    		 var obj=document.getElementById("btn_Retrieve");
     		 obj.fireEvent("onclick");
    	 }
     }
    /**
     * in case of selecting Damage Category Combo Data , set data applicable on Damage Part Combo List. <br>
     **/
    function stv_dmg_prt_cate_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.stv_dmg_prt_cate_cd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    	if(!isNull(comboObj.GetSelectCode())){
	    	formObj.f_cmd.value=SEARCH03;
	    	var categoryPartXml=sheetObjects[0].GetSearchData("VOP_OPF_0052GS.do" , FormQueryString(formObj));
	    	var categoryPart=ComGetEtcData(categoryPartXml, "catePart");
	    	if(categoryPart==null || categoryPart.length<1){
	    		//ComShowMessage("Part Code not exist.");
    			ComShowCodeMessage("OPF50009", "Part Code");
	    		comboObjects[3].RemoveAll();
	    		return false;
	    	}else{
	    		setComboItem2(comboObjects[3], categoryPart);
	    		formObj.stv_dmg_prt_cate_cd.focus();
	    	}
    	}else{
    		comboObjects[3].RemoveAll();
    		formObj.stv_dmg_prt_cate_cd.focus();
    	}
    }
    function vsl_oshp_cntr_blk_tp_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.vsl_oshp_cntr_blk_tp_cd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
    function stv_dmg_respb_pty_kwn_flg_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.stv_dmg_respb_pty_kwn_flg_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
    function stv_dmg_tp_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.stv_dmg_tp_cd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
    
    function stv_dmg_step_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.stv_dmg_step_cd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
    function stv_dmg_rpr_proc_sts_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.stv_dmg_rpr_proc_sts_cd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
    function stv_dmg_cmpn_proc_sts_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.stv_dmg_cmpn_proc_sts_cd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
    
    function stv_dmg_stl_proc_sts_cd_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.stv_dmg_stl_proc_sts_cd_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
    function group_by_OnChange(comboObj, OldIndex,  OldText,  OldCode,  NewIndex,  NewText, NewCode) {
    	var formObj=document.form;
    	form.group_by_text.value = comboObj.GetText(parseInt(NewIndex), 0);
    }
    /**
     * adding data on combo field
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList=comboItems.split("|");
        	for (var i=0 ; i < dataList.length ; i++) {
        		var comboItem=dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
        	}
    	}
    }
    /**
     * adding data on combo field
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList=comboItems.split("|");
        	for (var i=0 ; i < dataList.length ; i++) {
        		var comboItem=dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
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
                
             var HeadTitle1="|Group|Performance|Performance|Performance|Performance|Performance";
             var HeadTitle2="|Group|Unknown 3RD Party\n/ Total Damage|Repair(Completed)\n/ Total Damage|Compensation(Completed)\n/ Total Damage|Amount of Compensation\n/ Total Amount of Repair|Paid for Owner's Billing Amount\n/ Total Amount of Repair";
             var headCount=ComCountHeadTitle(HeadTitle1);
             (headCount, 0, 0, true);
             var prefix="sheet1_";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                       { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"grp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:160,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rat_unknown",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:160,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rat_rep",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:170,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rat_comp",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:170,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rat_amt_comp", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:175,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rat_bill_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);
             SetSheetHeight(330);
             SetEditable(0);
             SetRowHeight(1,30);
             }


                break;
            case "sheet2":
                with(sheetObj){
               
              var HeadTitle1="|Group|Damage|Damage|Damage|Damage|Damage|Damage|Damage|Damage";
              var HeadTitle2="|Group|Damage Count|Repair|Supply|Quotation|Unknown 3rd Party|Hull|Material|Machinery";
              var headCount=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, true);
              var prefix="sheet2_";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"grp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"dmg_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rep_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"sup_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"quo_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:115,  Align:"Right",   ColMerge:1,   SaveName:prefix+"unk_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"hull",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"matl",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mach",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
              SetSheetHeight(330);
              SetEditable(0);
              SetRowHeight(1,30);
              }


                break;
            case "sheet3":
                with(sheetObj){
               
             var HeadTitle1="|Group|Repair|Repair|Repair|Repair|Repair|Repair";
             var HeadTitle2="|Group|Ordered|Repairing|Completed|Completed Amount|Quoted|Quoted Amount";
             var headCount=ComCountHeadTitle(HeadTitle1);
             (headCount, 0, 0, true);
             var prefix="sheet3_";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                       { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"grp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:140,  Align:"Right",   ColMerge:1,   SaveName:prefix+"order_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:140,  Align:"Right",   ColMerge:1,   SaveName:prefix+"repr_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:140,  Align:"Right",   ColMerge:1,   SaveName:prefix+"comp_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:140,  Align:"Right",   ColMerge:1,   SaveName:prefix+"comp_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:140,  Align:"Right",   ColMerge:1,   SaveName:prefix+"quo_cnt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:140,  Align:"Right",   ColMerge:1,   SaveName:prefix+"quo_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);
             SetSheetHeight(330);
             SetEditable(0);
             SetRowHeight(1,30);
             }


                break;
            case "sheet4":
                with(sheetObj){
               
             var HeadTitle1="|Group|Compensation|Compensation|Compensation|Compensation|Compensation|Compensation|Compensation|Compensation";
             var HeadTitle2="|Group|Ready|Claimed|Noticed|Accepted|Rejected|Completed|Completed\nAmount|Cancellation";
             var headCount=ComCountHeadTitle(HeadTitle1);
             (headCount, 0, 0, true);
             var prefix="sheet4_";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                       { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"grp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ready_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"claim_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"not_cnt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"acc_cnt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rej_cnt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"com_cnt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"com_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:105,  Align:"Right",   ColMerge:1,   SaveName:prefix+"can_cnt",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);
             SetSheetHeight(330);
             SetEditable(0);
             SetRowHeight(1,30);
             }


                break;
            case "sheet5":
                with(sheetObj){
                
             var HeadTitle1="|Group|Settlement|Settlement";
             var HeadTitle2="|Group|Paid|Paid Amount";
             var headCount=ComCountHeadTitle(HeadTitle1);
             (headCount, 0, 0, true);
             var prefix="sheet5_";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                       { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"grp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Int",       Hidden:0,  Width:400,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_cnt", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",     Hidden:0,  Width:400,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);
             SetSheetHeight(330);
             SetEditable(0);
          	 SetRowHeight(1,30);
             }


                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction,gubun) {
    	sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	      case IBSEARCH:      //Retrieve
	    	  if(gubun=="Combo"){
	    		  formObj.f_cmd.value=SEARCH01;
	    		  var comboXml=sheetObj.GetSearchData("VOP_OPF_0056GS.do" , FormQueryString(formObj));
	    		  //Default ComboData Set..
	              setDefaultComboData(comboXml);
	    	  }
	    	  else{
	    		  	formObj.f_cmd.value=SEARCH;
	    	    	var aryPrefix=new Array("sheet1_","sheet2_","sheet3_","sheet4_","sheet5_");
	    	    	var sXml=sheetObj.GetSearchData("VOP_OPF_0056GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	  	    		var arrXml=sXml.split("|$$|");
	              	if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	              	if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
	              	if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
	              	if (arrXml.length > 3) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
	              	if (arrXml.length > 4) sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
	    	  }
	        break;
	      case IBROWSEARCH:
	    	  if(gubun=="locCd"){
	    		  formObj.f_cmd.value=SEARCH;
	    		  var locXml=sheetObj.GetSearchData("COM_ENS_0M1GS.do?cnt_cd="+formObj.loc_cd.value, FormQueryString(formObj));
	    		  var locArr=ComOpfXml2Array(locXml, "cnt_cd");
	    		  if(isNull(locArr) || locArr.length < 1){
	      			  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.loc_cd.value="";
	    			  formObj.loc_cd.focus();
	    			  return false;
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
	    			  return false;
	    		  }else{
	    			  formObj.slan_cd.focus();
	    		  }
	    	  }
	    	  else if(gubun=="slanCd"){
	    		  formObj.f_cmd.value=COMMAND12;
	    		  var lanXml=sheetObj.GetSearchData("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
	    		  var strLanCdDesc=ComGetEtcData(lanXml, "checkLane");
	    		  if(isNull(strLanCdDesc)){
	      			  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.slan_cd.value="";
	    			  formObj.slan_cd.focus();
	    			  return false;
	    		  }else{
	    			  formObj.vsl_cd.focus();
	    		  }
	    	  }
	    	  else if(gubun=="vslCd"){
	    		  formObj.f_cmd.value=SEARCH;
	    		  var vslXml=sheetObj.GetSearchData("COM_ENS_0A1GS.do", FormQueryString(formObj));
	    		  var vslArr=ComOpfXml2Array(vslXml, "vsl_cd");
	    		  if(isNull(vslArr) || vslArr.length < 1){
	      			  ComShowCodeMessage("OPF50004", "Data");
	    			  formObj.vsl_cd.value="";
	    			  formObj.vsl_cd.focus();
	    			  return false;
	    		  }else{
	    			  formObj.stv_dmg_prt_cate_cd.focus();
	    		  }
	    	  }
	    	  break;
	    }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj){
    	if(ComChkValid(formObj)){
    		return true;
    	}
    	else{
    		return false;
    	}
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
	/* Developer performance  end */
