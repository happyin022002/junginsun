/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0375.js
 *@FileTitle  : Arrival Notice Template
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/05
 =========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class esm_bkg_0375 : esm_bkg_0375 
 */

       /* Start of developer's work*/
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// MultiComboBox
var comboObjects=new Array();
var comboCnt=0;
var bMultiComboDataAdded=false;
var vComboData="";
// screen status
var screenStatus="N";  // NCRX N:initial status[able to search], C:new[able to save], R:status of searching[ able to save and delete] X:changing condition of seaching[able to search]
var dataStatus="N";
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject1=sheetObjects[0];
    var comboObject1=comboObjects[0];
    /*******************************************************/
    var formObject=document.form;
    //try {
    var srcName=ComGetEvent("name");
    if (!ComIsBtnEnable(srcName)){ return; }
    switch(srcName) {
        case "btn_Retrieve":
            if (!validateForm(sheetObject1, formObject, IBSEARCH)) {return; }
            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;
        case "btn_New":
            if (screenStatus == "N") {
                // Please Click the Retrieve button before putting the data in the text fields
                ComShowCodeMessage("BKG00448");
                return;
            } else if (screenStatus == "X") {
                // There is no data in Text Fields of Office ["Value"], please put Text in the fields
                ComShowCodeMessage("BKG04016", formObject.ofc_cd.value);
                return;
            }
            //initializing all data
            fncClearFormValue(formObject);
            sheetObject1.RemoveAll();
            dataStatus="Y"; // initializing
            break;
        case "btn_Save":
            if (screenStatus == "N") {
                // Please Click the Retrieve button before putting the data in the text fields
                ComShowCodeMessage("BKG00448");
                return;
            } else if (screenStatus == "X") {
                // There is no data in Text Fields of Office ["Value"], please put Text in the fields
                ComShowCodeMessage("BKG04016", formObject.ofc_cd.value);
                return;
            }
            if (dataStatus == "N") {
                // Nothing has been changed after data is retrieved
                ComShowCodeMessage("BKG00797");
                return;
            }
            doActionIBSheet(sheetObject1,formObject,IBSAVE);
            break;
        case "btn_Del":
            if (screenStatus == "C") {
                // there is no target to delete 
                ComShowCodeMessage("BKG03054");
                return;
            } else if (screenStatus == "N") {
                // Please Click the Retrieve button before putting the data in the text fields
                ComShowCodeMessage("BKG00448");
                return;
            } else if (screenStatus == "X") {
                // Searching option was changed. Please retrive first.
                ComShowCodeMessage("BKG03053");
                return;
            }
            if(ComShowCodeConfirm("COM12165")){ // Do you want to delete {?msg1}?
                dataFlagToIBSheet(sheetObject1, "D");
                doActionIBSheet(sheetObject1,formObject,IBDELETE);
            }
            break;
        case "btn_ANSetup":
            var cur_pod_cd=formObject.pod_cd.value;
            var autoSearchFlg="Y";
            if (cur_pod_cd == "ALL" ) {
                cur_pod_cd="";
                autoSearchFlg="N";
            }
            var goUrl="";
            var param="";
            goUrl="/opuscntr/ESM_BKG_0672_POP.do?";
            param += "1=1";
            param += "&pgmNo=ESM_BKG_0672-01";
            if (formObject.pod_cd.value != "ALL") {
                param += "&pod_cd=" + formObject.pod_cd.value;
            }
            // No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param, "ESM_BKG_0672-01", 1250, 700, false);
            break;
        case "btn_Close":
        	ComClosePopup();
        	break;
    } // end switch
}
/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj mandatory, Sheet object
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
    	// initializing Sheet 
        initSheet(sheetObjects[i],i+1);
    }
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
    /*
     * not calling event because this sheet is hidden
     * handling it in load page  
     * description by Park Mangeon
     * date 20091113
     */
    initControl();
    screenStatus="N";
    var formObj=document.form;
    fncSetPodCdCombo(sheetObjects[0],formObj);//setting POD Combo
    formObj.pod_cd.value=formObj.pod_cd_combo[0].value;
    fncSetAgentCombo(sheetObjects[0],formObj);//Agent combo
    //in case Office of login user is　BEANR, NLRTM, Default is Notify Lette1
    
    fncInitANPreviewForm(formObj.login_ofc_cd, formObj.arr_prv_fom_cd);
    //initializing 
    //formObj.ofc_cd.focus();
    fnChangeImeMode();
}
/**
 * registering event <br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initControl() {
   
   axon_event.addListenerForm('change', 'objChange', form );   
   //axon_event.addListenerForm ('keyup'   , 'objKeyUp', form);
   //axon_event.addListenerForm ('keypress', 'objKeyPress', form);
   axon_event.addListenerForm ('deactivate', 'objDeactivate', form);
   axon_event.addListener      ('keydown'         ,'ComKeyEnter',         'form');
}
function objDeactivate() {
   var objName=event.srcElement.name;
   if(objName == "ge_impt_ntc_rmk"
       || objName == "dr_impt_ntc_rmk"
       || objName == "cy_impt_ntc_rmk"
       || objName == "cf_impt_ntc_rmk"
       || objName == "sp_impt_ntc_rmk"
       || objName == "e1_impt_ntc_rmk") {
	  var caption=event.srcElement.getAttribute("caption");
	  if(ComChkLenByByte(event.srcElement, 4000) == 0) {
		  ComShowCodeMessage("BKG43035", caption , 4000, ComGetLenByByte(ComGetEvent()));
	  }
   }
}
/**
 *  deactivating the function which retrieve automatically in text area in case of clicking Enter <br>
 * @param void
 * @return void
 */
function objEnter(obj) {
	var formObj=document.form;
	if(event.keyCode == 13 && obj.name == "ofc_cd" ){
		if(formObj.ofc_cd.value.length >= 5){
			ComKeyEnter('LengthNextFocus');
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		}
	}else if(event.keyCode == 13 && obj.name == "pod_cd" ){
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}else if(event.keyCode == 13 && obj.name == "chn_agn_cd"){
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
	return;
   var objName=ComGetEvent("name");
   var formObj=document.form;
   if (objName == "arr_prv_fom_cd"
         || objName == "locl_lang_flg"
         || objName == "eclz_bl_cpy_flg"
         || objName == "ge_addr_ctnt" )
   {
    //  skip in Edit area 
   } else if(objName == "ge_impt_ntc_rmk"
             || objName == "dr_addr_ctnt"
             || objName == "dr_impt_ntc_rmk"
             || objName == "cy_addr_ctnt"
             || objName == "cy_impt_ntc_rmk"
             || objName == "cf_addr_ctnt"
             || objName == "cf_impt_ntc_rmk"
             || objName == "sp_addr_ctnt"
             || objName == "sp_impt_ntc_rmk"
             || objName == "e1_addr_ctnt"
             || objName == "e1_impt_ntc_rmk")
   {
    // skip in Edit area
       //fncTextareaMaxLine(event.srcElement.value);
   } else if(objName == "ofc_cd" ){
		if(formObj.ofc_cd.value.length >= 5){
			//document.getElementById("btn_Retrieve").fireEvent("onclick");
		}
   } else {
       ComKeyEnter();
   }
}
/**
 * in case Object is changed, managing the status of screen <br>
 * @param void
 * @return void
 */
function objChange(){
    var objName=ComGetEvent("name");
    var formObj=document.form;
    //activating in case of changing condition of searching
    if(objName == "ofc_cd"
        || objName == "pod_cd"
        || objName == "pod_cd_combo"
        || objName == "chn_agn_cd"
        || objName == "chn_agn_cd_combo"
            )
    {
        if (screenStatus != "N") {
            screenStatus="X";
            dataStatus="N";
        }
    }
    if (objName == "arr_prv_fom_cd"
         || objName == "locl_lang_flg"
         || objName == "eclz_bl_cpy_flg"
         || objName == "ge_addr_ctnt"
         || objName == "ge_impt_ntc_rmk"
         || objName == "dr_addr_ctnt"
         || objName == "dr_impt_ntc_rmk"
         || objName == "cy_addr_ctnt"
         || objName == "cy_impt_ntc_rmk"
         || objName == "cf_addr_ctnt"
         || objName == "cf_impt_ntc_rmk"
         || objName == "sp_addr_ctnt"
         || objName == "sp_impt_ntc_rmk"
         || objName == "e1_addr_ctnt"
         || objName == "e1_impt_ntc_rmk" )
    {
        dataStatus="Y";
    }
    if (objName == "locl_lang_flg") {
        fnChangeImeMode();
    }
    switch (objName) {
        case "ofc_cd":
			if(formObj.ofc_cd.value.length >= 5){
				fncSetPodCdCombo(sheetObjects[0],formObj);
				fncSetAgentCombo(sheetObjects[0],formObj);
			}
            break;
        case "pod_cd_combo":
            fncPodCdComboOnChange(ComGetEvent());
            break;
        case "chn_agn_cd_combo":
            fncAgentComboOnChange(ComGetEvent());
            break;
    }
}
/**
 * in case Object is changed, managing the status of screen <br>
 * @param void
 * @return void
 */
function objKeyUp(){
    var objName=ComGetEvent("name");
    var formObj=document.form;
	//  deleting the key event which is moving automatically
    switch(objName) {
        case "ofc_cd":
			//ComKeyEnter('LengthNextFocus');
            break;
        case "pod_cd":
            fncPodCdKeyUp(ComGetEvent());
            //ComKeyEnter('LengthNextFocus');
            break;
        case "chn_agn_cd":
            fncAgentKeyUp(ComGetEvent());
            //ComKeyEnter('LengthNextFocus');
            break;
        case "pod_cd_combo":
            //ComKeyEnter('LengthNextFocus');
            break;
        case "chn_agn_cd_combo":
            //ComKeyEnter('LengthNextFocus');
            break;
    }
}
/**
 * setting ime-mode as locl_lang_flg<br>
 * @param void
 * @return void
 */
function fnChangeImeMode() {
   var formObj=document.form;
    if (formObj.locl_lang_flg[0].selected == true) {
       formObj.ge_addr_ctnt.style.imeMode="disabled";
       formObj.ge_impt_ntc_rmk.style.imeMode="disabled";
       formObj.dr_addr_ctnt.style.imeMode="disabled";
       formObj.dr_impt_ntc_rmk.style.imeMode="disabled";
       formObj.cy_addr_ctnt.style.imeMode="disabled";
       formObj.cy_impt_ntc_rmk.style.imeMode="disabled";
       formObj.cf_addr_ctnt.style.imeMode="disabled";
       formObj.cf_impt_ntc_rmk.style.imeMode="disabled";
       formObj.sp_addr_ctnt.style.imeMode="disabled";
       formObj.sp_impt_ntc_rmk.style.imeMode="disabled";
       formObj.e1_addr_ctnt.style.imeMode="disabled";
       formObj.e1_impt_ntc_rmk.style.imeMode="disabled";
   } else {
       formObj.ge_addr_ctnt.style.imeMode="active";
       formObj.ge_impt_ntc_rmk.style.imeMode="active";
       formObj.dr_addr_ctnt.style.imeMode="active";
       formObj.dr_impt_ntc_rmk.style.imeMode="active";
       formObj.cy_addr_ctnt.style.imeMode="active";
       formObj.cy_impt_ntc_rmk.style.imeMode="active";
       formObj.cf_addr_ctnt.style.imeMode="active";
       formObj.cf_impt_ntc_rmk.style.imeMode="active";
       formObj.sp_addr_ctnt.style.imeMode="active";
       formObj.sp_impt_ntc_rmk.style.imeMode="active";
       formObj.e1_addr_ctnt.style.imeMode="active";
       formObj.e1_impt_ntc_rmk.style.imeMode="active";
   }
}
 /**
 * setting sheet initial values and header<br>
 * param : sheetObj, sheetNo<br>
 * adding case as numbers of counting sheets<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj , 
 * @param {int} sheetNo , Sheet Index
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch (sheetID) {
    case "sheet1"://Detail Grid
		with(sheetObj){
			var HeadTitle="status|an_fom_cd|addr_ctnt|impt_ntc_rmk";
			var prefix="sheet1_";			
			SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"an_fom_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"addr_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"impt_ntc_rmk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			 
			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
        }
        break;
    }
}
/**
 * registering IBTab Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} tabObj , 
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
/**
 * setting Tab 
 * setting item of Tab
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} tabObj , 
 * @param {int} nItem , index
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt=0 ;
				InsertItem( "General" , "");
				InsertItem( "Door" , "");
				InsertItem( "CY" , "");
				InsertItem( "CFS Cargo" , "");
				InsertItem( "Special Cargo" , "");
				InsertItem( "Event" , "");
            }
         break;
     }
}
/**
 * Event when clicking Tab
 * activating selected tab items
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} tabObj , 
 * @param {int} nItem , index
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs=document.all.item("tabLayer");
     objs[nItem].style.display="Inline";
     //objs[beforetab].style.display="none";
     for(var i = 0; i<objs.length; i++){
 		if(i != nItem){
 			objs[i].style.display="none";
 			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
 		}
 	}
     //--------------- important  --------------------------//
     objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     //------------------------------------------------------//
     beforetab=nItem;
     var formObj=document.form;
     if(beforetab == 0){
        //formObj.ge_addr_ctnt.focus();
     }else if(beforetab == 1){
        //formObj.dr_addr_ctnt.focus();
     }else if(beforetab == 2){
        //formObj.cy_addr_ctnt.focus();
     }else if(beforetab == 3){
        //formObj.cf_addr_ctnt.focus();
     }else if(beforetab == 4){
        //formObj.sp_addr_ctnt.focus();
     }else if(beforetab == 5){
        //formObj.e1_addr_ctnt.focus();
     }
}
/**
 * handling of Sheet 
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj , 
 * @param {Object} formObj , 
 * @param {String} sAction , 
 * @param {String} CondParam , 
 * @param {int} pageNo , 
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj, sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
         case IBSEARCH:      
            formObj.f_cmd.value=SEARCH;
         	ComOpenWait(true,true);
         	sheetObj.DoSearch("ESM_BKG_0375GS.do",fnFormStringUtil(FormQueryString(formObj))+ "&"+ ComGetPrefixParam("sheet1_"));
               //moving into sheet1_OnSearchEnd 
            break;
        case IBSAVE:        
             //save-1. copying to grid 
        	 if(!validateForm(sheetObj,formObj,sAction))return;
             //sheetObj.removeAll();
             var arr_prv_fom_cd_value="";
             for(var k=0;k<formObj.arr_prv_fom_cd.length;k++){
                 if(formObj.arr_prv_fom_cd[k].checked){
                     arr_prv_fom_cd_value=formObj.arr_prv_fom_cd[k].value;
                 }
             }
            sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "an_fom_cd","CF");
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "addr_ctnt",formObj.cf_addr_ctnt.value);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "impt_ntc_rmk",formObj.cf_impt_ntc_rmk.value);
            sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "an_fom_cd","CY");
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "addr_ctnt",formObj.cy_addr_ctnt.value);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "impt_ntc_rmk",formObj.cy_impt_ntc_rmk.value);
            sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "an_fom_cd","DR");
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "addr_ctnt",formObj.dr_addr_ctnt.value);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "impt_ntc_rmk",formObj.dr_impt_ntc_rmk.value);
            sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "an_fom_cd","E1");
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "addr_ctnt",formObj.e1_addr_ctnt.value);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "impt_ntc_rmk",formObj.e1_impt_ntc_rmk.value);
            sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "an_fom_cd","GE");
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "addr_ctnt",formObj.ge_addr_ctnt.value);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "impt_ntc_rmk",formObj.ge_impt_ntc_rmk.value);
            sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "an_fom_cd","SP");
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "addr_ctnt",formObj.sp_addr_ctnt.value);
            sheetObj.SetCellValue(sheetObj.LastRow(),"sheet1_" + "impt_ntc_rmk",formObj.sp_impt_ntc_rmk.value);
            formObj.f_cmd.value=MULTI;
            sheetObj.DoSave("ESM_BKG_0375GS.do", fnFormStringUtil(FormQueryString(formObj)), -1 ,false);
            break;
        case IBDELETE:       
           formObj.f_cmd.value=REMOVE01;
           sheetObj.DoSave("ESM_BKG_0375GS.do", fnFormStringUtil(FormQueryString(formObj)), -1, false);
           fncClearFormValue(formObj);
           formObj.an_seq.value="";
           break;
       case SEARCH01:
           fncSetPodCdCombo(sheetObjects[0],formObj);//setting POD Combo 
           break;
    }
}
/**
 * handling process for input validation<br>
 * @param {Object} sheetObj , 
 * @param {Object} formObj , 
 * @param {int} sAction , 
 * @return boolean 
 */
function validateForm(sheetObj,formObj,sAction){
    var formObj=document.form;
    with(formObj){
        switch (sAction){
        case IBSEARCH:
            if(!ComChkValid(formObj)) return false;
            break;
        case IBSAVE:
            if(!ComChkValid(formObj)) return false;
      	    if(ComChkLenByByte(ge_impt_ntc_rmk, 4000) == 0) {
    		    ComShowCodeMessage("BKG43035", "'General' Important Notice", 4000, ComGetLenByByte(ge_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(dr_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'Door' Important Notice", 4000, ComGetLenByByte(dr_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(cy_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'CY' Important Notice", 4000, ComGetLenByByte(cy_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(cf_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'CFS Cargo' Important Notice", 4000, ComGetLenByByte(cf_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(sp_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'Special Cargo' Important Notice", 4000, ComGetLenByByte(sp_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(formObj.e1_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'Event' Important Notice", 4000, ComGetLenByByte(formObj.e1_impt_ntc_rmk));
    		    return false;
    	    }
      	    break;
        case IBDELETE:
            if(!ComChkValid(formObj)) return false;
            break;
        }
    }
    return true;
}
/**
 *  changing combo in case of changing sheet<br>
 * @param {Object} sheetObj , Sheet
 * @param {Object} errMsg , 
 * @return void
 */
function sheet1_OnSaveEnd(sheetObj, code, errMsg)
{
    var formObj=document.form;
    if (errMsg != null && errMsg != "") {
        if (sheetObj.GetEtcData("opr_name") == "D") {
            screenStatus="N";
            dataStatus="N";
            fncSetPodCdCombo(sheetObj,formObj);//POD combo
            fncSetAgentCombo(sheetObj,formObj);//Agent combo
            formObj.arr_prv_fom_cd[0].checked=true;
            formObj.locl_lang_flg[0].selected=true;
            formObj.eclz_bl_cpy_flg[0].selected=true;
        }
        else if(sheetObj.GetEtcData("opr_name") == "I") {
            fncSetPodCdCombo(sheetObj,formObj);//POD combo
            fncSetAgentCombo(sheetObj,formObj);//Agent combo
        }
        return;
    }
    fncSetPodCdCombo(sheetObj,formObj);//POD combo
    fncSetAgentCombo(sheetObj,formObj);//Agent combo
    // {?msg1} update has been completed.
    ComShowCodeMessage ("COM12156","Remark Template");
    screenStatus="R";
    dataStatus="N";
    doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
/**
 *  handling after transmitting data at IBsheet
 * 1. in case of existing data
 * 1-1. modifying mode (activating:new,saving,deleting)(deactivating:searching)      
 * 1-2. inserting sheet data to form
 *
 * 2.in case of none existing data
 * 2-1. new mode(activating:new,saving)(deactivating:searching,deleting) 
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj , 
 * @param {String} errStr , 
 * @returns void
 * @author
 * @version 2009.10.01
 */
function sheet1_OnSearchEnd(sheetObj, code, errMsg){
    if (errMsg != null && errMsg != "") {
    	ComOpenWait(false);
    	return;
    }
    var formObject=document.form;
    dataStatus="N";
    //1.in case of existing data
    if(sheetObj.RowCount()>= 6){
        //1-1.modifying mode (activating:new,saving,deleting)(deactivating:searching)
        screenStatus="R";
        //1-2.inserting sheet data to form
        for(var i=0;i<sheetObj.RowCount();i++){
			if(sheetObj.GetCellValue(i+1,"sheet1_" + "an_fom_cd") == "CF"){
				formObject.cf_addr_ctnt.value=sheetObj.GetCellValue(i+1,"sheet1_" + "addr_ctnt");
				formObject.cf_impt_ntc_rmk.value=sheetObj.GetCellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
			if(sheetObj.GetCellValue(i+1,"sheet1_" + "an_fom_cd") == "CY"){
				formObject.cy_addr_ctnt.value=sheetObj.GetCellValue(i+1,"sheet1_" +"addr_ctnt");
				formObject.cy_impt_ntc_rmk.value=sheetObj.GetCellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
			if(sheetObj.GetCellValue(i+1,"sheet1_" + "an_fom_cd") == "DR"){
				formObject.dr_addr_ctnt.value=sheetObj.GetCellValue(i+1,"sheet1_" +"addr_ctnt");
				formObject.dr_impt_ntc_rmk.value=sheetObj.GetCellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
			if(sheetObj.GetCellValue(i+1,"sheet1_" + "an_fom_cd") == "E1"){
				formObject.e1_addr_ctnt.value=sheetObj.GetCellValue(i+1,"sheet1_" +"addr_ctnt");
				formObject.e1_impt_ntc_rmk.value=sheetObj.GetCellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
			if(sheetObj.GetCellValue(i+1,"sheet1_" + "an_fom_cd") == "GE"){
				formObject.ge_addr_ctnt.value=sheetObj.GetCellValue(i+1,"sheet1_" +"addr_ctnt");
				formObject.ge_impt_ntc_rmk.value=sheetObj.GetCellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
			if(sheetObj.GetCellValue(i+1,"sheet1_" + "an_fom_cd") == "SP"){
				formObject.sp_addr_ctnt.value=sheetObj.GetCellValue(i+1,"sheet1_" +"addr_ctnt");
				formObject.sp_impt_ntc_rmk.value=sheetObj.GetCellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
        }
        var anSeq=sheetObj.GetEtcData("an_seq");
        var arrPrvFomCd=sheetObj.GetEtcData("arr_prv_fom_cd");
        var loclLangFlg=sheetObj.GetEtcData("locl_lang_flg");
        var ezclBlCpyFlg=sheetObj.GetEtcData("eclz_bl_cpy_flg");
        formObject.an_seq.value=anSeq;
        for(var x=0;x < formObject.arr_prv_fom_cd.length;x++){
            if(formObject.arr_prv_fom_cd[x].value == arrPrvFomCd){
                formObject.arr_prv_fom_cd[x].checked=true;
            }
        }
        for(var x=0;x < formObject.locl_lang_flg.options.length;x++){
            if(formObject.locl_lang_flg.options[x].value == loclLangFlg){
                formObject.locl_lang_flg.options[x].selected=true;
            }
        }
        for(var x=0;x < formObject.eclz_bl_cpy_flg.options.length;x++){
            if(formObject.eclz_bl_cpy_flg.options[x].value == ezclBlCpyFlg){
                formObject.eclz_bl_cpy_flg.options[x].selected=true;
            }
        }
    }
    //2.in case of none existing data
    if(sheetObj.RowCount()== 0){
        //2-1.new mode(activating:new,saving)(deactivating:searching,deleting)
        screenStatus="C";
        //2-2.initializing all
        fncClearFormValue(formObject);
        formObject.an_seq.value="";
        formObject.arr_prv_fom_cd[0].checked=true;
        formObject.locl_lang_flg[0].selected=true;
        formObject.eclz_bl_cpy_flg[0].selected=true;
        // There is no data in Text Fields of Office ["Value"], please put Text in the fields
        ComShowCodeMessage("BKG04016", formObject.ofc_cd.value);
    }
    ComOpenWait(false);
    //alert("dataStatus[" + dataStatus + "]  screenStatus[" + screenStatus + "]");
    fnChangeImeMode();
}
/**
 * initializing all<br>
 * @param {Object} formObject , 
 * @return void
 */
function fncClearFormValue(formObject){
    formObject.cf_addr_ctnt.value="";
    formObject.cf_impt_ntc_rmk.value="";
    formObject.cy_addr_ctnt.value="";
    formObject.cy_impt_ntc_rmk.value="";
    formObject.dr_addr_ctnt.value="";
    formObject.dr_impt_ntc_rmk.value="";
    formObject.e1_addr_ctnt.value="";
    formObject.e1_impt_ntc_rmk.value="";
    formObject.ge_addr_ctnt.value="";
    formObject.ge_impt_ntc_rmk.value="";
    formObject.sp_addr_ctnt.value="";
    formObject.sp_impt_ntc_rmk.value="";
}
/**
 * checking the value which is inserted at combo is adding or not<br>
 * registering input value to upper<br>
 * @param {Object} obj , changed object
 * @return void
 */
function fncPodCdComboOnChange(obj) {
   var formObj=document.form;
   formObj.pod_cd.value=obj.value;
   fncSetAgentCombo(sheetObjects[0],formObj);
}
/**
 * checking the value which is inserted at combo is adding or not<br>
 * registering input value to upper<br>
 * @param {Object} obj , changed object
 * @return void
 */
function fncAgentComboOnChange(obj) {
    var formObj=document.form;
    formObj.chn_agn_cd.value=obj.value;
}
/**
 * pod_cd <br>
 * @param {Object} obj , Agent
 * @return void
 */
function fncPodCdKeyUp(obj){
    var formObj=document.form;
    var pCombo=formObj.pod_cd_combo;
    for(var i=0;i<pCombo.options.length;i++){
        if(obj.value.trim() == pCombo.options[i].value.substring(0,obj.value.length)){
            pCombo.options[i].selected=true;
            break;
        }
    }
    if (formObj.pod_cd.value.length == 5) {
        fncSetAgentCombo(sheetObjects[0],formObj);
    }
}
/**
 * agent <br>
 * @param {Object} obj , Agent
 * @return void
 */
function fncAgentKeyUp(obj){
    var formObj=document.form;
    var pCombo=formObj.chn_agn_cd_combo;
    for(var i=0;i<pCombo.options.length;i++){
        if(obj.value.trim() == pCombo.options[i].value.substring(0,obj.value.length)){
            pCombo.options[i].selected=true;
            break;
        }
    }
}
/**
 * changing flag at IB Sheet.<br>
 * @param {Object} sheetObj , Sheet 
 * @param {String} status , IBsheet 
 * @return void
 */
function dataFlagToIBSheet(sheetObj, status) {
    for (var idx=1; idx <= sheetObj.LastRow(); idx++) {
        sheetObj.SetRowStatus(idx,status);
    }
}
/**
 * setting data at POD Combo <br>
 * @param {Object} sheetObj , Sheet 
 * @param {Object} formObj , 
 * @return void
 */
function fncSetPodCdCombo(sheetObj,formObj){
    formObj.f_cmd.value=SEARCH01;
    var sParam=fnFormStringUtil(FormQueryString(formObj));
	var sXml=sheetObj.GetSearchData("ESM_BKG_0375GS.do", sParam);
    var bComboExists=false;
    if (!ComBkgErrMessage(sheetObj, sXml) || sXml == "") return;
    var codes=ComGetEtcData(sXml,"code");
    var values=ComGetEtcData(sXml,"value");
    var sPodCdExists=false;
    var codeArr=codes.split("|");
    var valueArr=values.split("|");
    for(var i=formObj.pod_cd_combo.options.length;i >= 0;i--){
        formObj.pod_cd_combo.remove(i);
    }
    for(var m=0; m<codeArr.length -1; m++) {
        var oOption=document.createElement("OPTION");
        formObj.pod_cd_combo.options.add(oOption);
        oOption.innerText=valueArr[m];
        oOption.value=codeArr[m];
        if(formObj.pod_cd.value == codeArr[m]){
            oOption.selected=true;
            bComboExists=true;
        }
    }
    if (!bComboExists) {
        formObj.pod_cd.value=valueArr[0];
    }
}
/**
 * setting data at Agent Combo <br>
 * @param {Object} sheetObj , 
 * @param {Object} formObj , 
 * @return void
 */
function fncSetAgentCombo(sheetObj,formObj){
    formObj.f_cmd.value=SEARCH02;
    var sParam=fnFormStringUtil(FormQueryString(formObj));
	var sXml=sheetObj.GetSearchData("ESM_BKG_0375GS.do", sParam);
    var bComboExists=false;
    if (!ComBkgErrMessage(sheetObj, sXml)) return;
    var codes=ComGetEtcData(sXml,"code");
    var values=ComGetEtcData(sXml,"value");
    var sPodCdExists=false;
    var codeArr=codes.split("|");
    var valueArr=values.split("|");
    for(var i=formObj.chn_agn_cd_combo.options.length;i >= 0;i--){
        formObj.chn_agn_cd_combo.remove(i);
    }
    for(var m=0; m<codeArr.length -1; m++) {
        var oOption=document.createElement("OPTION");
        formObj.chn_agn_cd_combo.options.add(oOption);
        oOption.innerText=valueArr[m];
        oOption.value=codeArr[m];
        if(formObj.chn_agn_cd.value == codeArr[m]){
        	oOption.selected=true;
        	bComboExists=true;
        }
    }
    // in case textbox and combo box are different, changing textbox to combobox 
    if (!bComboExists) {
        formObj.chn_agn_cd.value=codeArr[0];
    }
    //  searching in case of calling from A/N
    if (parAutoSearchFlg != null && parAutoSearchFlg == "Y") {
        parAutoSearchFlg="N";
        if (!validateForm(sheetObj, formObj, IBSEARCH)) {return; }
        doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }
}
/**
 * OnKeyPress <br>
 * @param {void}
 * @return void
 */
function objKeyPress() {
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
        case "ofc_cd":
            ComKeyOnlyAlphabet('upper');
            break;
        case "pod_cd":
            ComKeyOnlyAlphabet('upper');
            break;
        case "chn_agn_cd":
            ComKeyOnlyAlphabet('upper');
            break;
    }
}
/**
 * controlling A/N Preview Form as OFC_CD of login user <br>
 * BEANR and NLRTM use Notice Letter <br>
 * @param {String} loginOfcCd , 
 * @param {String} arrPrvFomCd ,
 * @return void
 */
function fncInitANPreviewForm(loginOfcCd, arrPrvFomCd){
    if(loginOfcCd.value == "BEANR"
        || loginOfcCd.value == "NLRTM"
        )
    {
        arr_prv_fom_cd[2].checked=true;
    }
}
/**
 *  The actual change of ALL with an asterisk must be sent, so the code changes necessary<br>
 * @param {String} formStr ,  form String
 * @return String form String
 */
function fnFormStringUtil(formStr){
    var tmpStr=formStr;
    tmpStr=tmpStr.replace("&pod_cd=ALL&", "&pod_cd=*&");
    tmpStr=tmpStr.replace("&pod_cd_combo=ALL&", "&pod_cd_combo=*&");
    tmpStr=tmpStr.replace("&chn_agn_cd=&", "&chn_agn_cd=*&");
    tmpStr=tmpStr.replace("&chn_agn_cd_combo=&", "&chn_agn_cd_combo=*&");
    return tmpStr;
}

/**
 * when Radio button clicked, value Check.
 **/
 function fnRadioCheck() {
     if (document.form.arr_prv_fom_cd[0].checked == true) {
 	    document.form.locl_lang_flg.disabled=false;
     } else {
     	document.form.locl_lang_flg.value = "N";
 	    document.form.locl_lang_flg.disabled=true;
     }
 }
 /* the end of developer's work */
 