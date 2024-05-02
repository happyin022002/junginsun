/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0059.js
*@FileTitle  : RPT Pop UP for the office weekly atypical performance analysis
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0059 : ESM_COA_0059 Business script for the UI
 */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
    /**
     *  Event handler processing by button name
     */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
        
        try {
	        	var srcName=ComGetEvent("name");
	            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_New":
                    sheetObject1.RemoveAll();
                    formObject.reset();
                    break;
                case "btn_Delete":
                    doActionIBSheet(sheetObject1, formObject, IBDELETE);
                    sheetObject1.RemoveAll();
                    //formObject.reset();
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObject1,formObject, IBSAVE);
                    break;
                case "btns_add":
                    var sRowStr=sheetObject.GetSelectionRows("/");   //"/" row separator, results: "3/4/5"
                    var arr=sRowStr.split("/");
                    for (var j=0; j<arr.length; j++) {
                    	var findRow=sheetObject1.FindText("rpt_itm_cd", sheetObject.GetCellValue(arr[j],"rpt_itm_cd"), 0, -1);
                        if(findRow < 0){
                            // findRow == -1 : There's no same data
                            // Add a data on the sheet2
                            //--------------------------------------
                            addRow(arr[j]);
                            //--------------------------------------
                        }
                    }
                    break;
                case "btns_del":
                    var sRowStr=sheetObject1.GetSelectionRows("/");  //"/" row separator, results: "3/4/5"
                    var arr=sRowStr.split("/");
                    // In case of multi selection using the CTRL OR the SHIFT KEY
                    // Reverse() is used to delete from a large number
                    //---------------------------------------------------------
                    arr.reverse();  //Change array reverse
                    //---------------------------------------------------------
                    for (var k=0; k<arr.length; k++) {
                        sheetObject1.RowDelete(arr[k], false);
                    }
                    break;
                case "btns_up":
                    var sRowStr=sheetObject1.GetSelectionRows("/");  //"/" row separator, results: "3/4/5"
                    var arr=sRowStr.split("/");
                    sheetObject1.DataMove(Number(arr)-1);
                    break;
                case "btns_down":
                    var sRowStr=sheetObject1.GetSelectionRows("/");  //"/" row separator, results: "3/4/5"
                    var arr=sRowStr.split("/");
                    sheetObject1.DataMove(Number(arr)+2);
                    break;
                case "btn_Close":
                    var col_desc="";
                    var col_nm="";
                    var param="";
                    var lstcol=sheetObject1.LastRow();
                    for(var i=1; i <= lstcol; i++ ){
                    	col_desc=col_desc + sheetObject1.GetCellValue(i, "to") ;
                    	col_nm=col_nm + sheetObject1.GetCellValue(i, "rpt_itm_col_nm") ;
                        if(i != lstcol){
                            col_desc=col_desc + "|";
                            col_nm=col_nm + "|";
                        }
                    }
                    opener.document.form.f_header.value=col_desc;
                    opener.document.form.f_headernm.value=col_nm;

                    opener.chgInitSheet();
                    if(document.form.saveYn[1].checked){
                        param=ComGetObjValue(f_selgroup);
                    };
                    opener.chgGroup(param);
                    ComClosePopup(); 
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
     */
    function loadPage() {
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        for(i=0;i<sheetObjects.length;i++){
            //Sheet configuration setting function(start)
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //Sheet configuration setting function(end)
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        //Multi-combo handling
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            //initCombo(comboObjects[k], k+1);
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        doActionIBSheet(sheetObject,formObject,IBSEARCH);  
    }
     /**
      * Setting multicombo items
      */
      function initCombo(comboObj, comboId) {
     	 with (comboObj) {
     		SetDropHeight(200);
     	 }
      }	
    /**
			* setting sheet initial values and header
			* param : sheetObj, sheetNo
			* adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	                var HeadTitle="Sts|2|3|4|5|From" ;
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lstatus" },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slct_itm_fom_seq" },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slct_itm_fom_desc" },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rpt_itm_cd" },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rpt_itm_col_nm" },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"from",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);//Editkind[optional,Defaultfalse]
	                SetSelectionMode(smSelectionList);
	                SetSheetHeight(ComGetSheetHeight(sheetObj, 11));
                }
                break;
            case 2:      //sheet1 init
                with (sheetObj) {
	                var HeadTitle="Sts|2|3|4|5|To" ;
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lstatus" },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slct_itm_fom_seq" },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slct_itm_fom_desc" },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rpt_itm_cd" },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rpt_itm_col_nm" },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"to",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);//Editkind[optional,Defaultfalse]
	                SetSelectionMode(smSelectionList);
	                SetSheetHeight(ComGetSheetHeight(sheetObj, 11));
                }
                break;
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
     *  In case of changing group code, inquiry sheet2
     */
     function f_selgroup_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
        var formObj=document.form;
        var sheetObject1=sheetObjects[1];
        formObj.f_cmd.value=SEARCHLIST02;
        sheetObject1.DoSearch("ESM_COA_0059GS.do", coaFormQueryString(formObj) );
        formObj.f_savename.value=f_selgroup.GetSelectText();
        formObj.f_group.value=f_selgroup.GetSelectText();
    }
    /**
     *  Add to the sheet2 the selected information from sheet1
     */
    function sheet1_OnDblClick(sheetObj , row, col , value) {
        var sheetObj2=sheetObjects[1];
        var findRow=sheetObj2.FindText("rpt_itm_cd", sheetObj.GetCellValue(row,"rpt_itm_cd"), 0, -1);
        if(findRow < 0){
            // findRow == -1 : There's no same data
            // Add a data on the sheet2
            //--------------------------------------
            addRow(row);
            //--------------------------------------
        }
    }
    /**
     * Delete the information from the sheet2 
     */
    function sheet2_OnDblClick(sheetObj, row, col, value){
        sheetObj.RowDelete(row, false);
    }
    function sheet2_OnMouseMove(sheetObj, button, shift, x, y){
        var row=sheetObj.MouseRow();
        var col=sheetObj.MouseCol();
    }
    /**
     * After saving sheet2
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg){
    	var formObj=document.form; 
        var grop_cd=sheetObj.GetEtcData("selGroup");
        //-----------------------------
        doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
        ComSetObjValue(f_selgroup,grop_cd);
        //-----------------------------
    }
    /**
     * Add the selected information from the sheet1 to the sheet2  
     */
    function addRow(selRow){
        var sheetObj1=sheetObjects[0];
        var sheetObj2=sheetObjects[1];
        var row=sheetObj2.DataInsert(-1);
        sheetObj2.SetCellValue(row, "slct_itm_fom_seq",sheetObj1.GetCellValue(selRow, "slct_itm_fom_seq"));
        sheetObj2.SetCellValue(row, "slct_itm_fom_desc",sheetObj1.GetCellValue(selRow, "slct_itm_fom_desc"));
        sheetObj2.SetCellValue(row, "rpt_itm_cd",sheetObj1.GetCellValue(selRow, "rpt_itm_cd"));
        sheetObj2.SetCellValue(row, "rpt_itm_col_nm",sheetObj1.GetCellValue(selRow, "rpt_itm_col_nm"));
        sheetObj2.SetCellValue(row, "to",sheetObj1.GetCellValue(selRow, "from"));
    }
    /**
     * Handling process about the sheet object
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBCLEAR:          //Inquiry
	        	formObj.f_cmd.value=SEARCHLIST12;
	        	var sXml=sheetObj.GetSearchData("ESM_COA_0060GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_selgroup, "code", "name");
				break;
            case IBSEARCH:      //Inquiry
                formObj.f_cmd.value=SEARCHLIST;
                sheetObj.DoSearch("ESM_COA_0059GS.do", coaFormQueryString(formObj) );
                break;
            case IBSAVE:        //Save
                if(validateForm(sheetObj,formObj,sAction)) {
                	// Prohibit button click when a business transaction is processing 
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
                    formObj.f_cmd.value=MULTI;
                    formObj.f_dividename.value="save";
                    sheetObj.DoAllSave("ESM_COA_0059GS.do", coaFormQueryString(formObj));
                    ComOpenWait(false);
                    //sheet2_OnSaveEnd(sheetObj, "");
                }
                break;
            case IBDELETE:        //Delete
                if(validateForm(sheetObj,formObj,sAction)) {
                    for(j=1;j<= sheetObj.LastRow(); j++) sheetObj.SetRowStatus(j,"D");
                    // Prohibit button click when a business transaction is processing 
										sheetObj.SetWaitImageVisible(0);
										ComOpenWait(true);
                    formObj.f_cmd.value=MULTI;
                    formObj.f_dividename.value="delete";
                    sheetObj.DoAllSave("ESM_COA_0059GS.do", coaFormQueryString(formObj));
                    ComOpenWait(false);
                }
                break;
        }
    }
    /**
     * Handling process for form object input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (saveYn[1].checked){
                if(f_savename.value == ""){
                    // [COA10010] : Group name to save
                    ComShowMessage(ComGetMsg("COA10010"));
                    if(sAction == IBSAVE)f_savename.focus();
                    if(sAction == IBDELETE)f_selgroup.focus();
                    return false;
                }
            } else {
                if(f_savename.value == ""){
                    saveYn[1].checked=true;
                    // [COA10010] : Group name to save
                    ComShowMessage(ComGetMsg("COA10010"));
                    if(sAction == IBSAVE)f_savename.focus();
                    if(sAction == IBDELETE)f_selgroup.focus();
                    return false;
                }
            }
        }
        return true;
    }
