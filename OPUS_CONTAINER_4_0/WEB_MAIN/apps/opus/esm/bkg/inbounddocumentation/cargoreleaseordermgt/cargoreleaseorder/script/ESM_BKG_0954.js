/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0954.js
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/* Global Variables */
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler defined process to button click event */
document.onclick=processButtonClick;
/* Event handler is branch processing by name of button */
    function processButtonClick(){
    	 /***** Assignment sheet in case of over 2 by tab****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn1_Save":
                    doActionIBSheet(sheetObjects[0], formObject,IBSAVE);
                    break;
                case "btn1_Close":
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
     * Register as an IBSheet Object array
     * This is called from comSheetObject(id)
     * Process can add in case of future necessity to process other items
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing sheet
     * To implement onLoad event of body tag
     * Add functionality to after loading screen.
     */
    function loadPage(date, id) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //adding input row
        var j=sheetObjects[0].DataInsert(-1);
        if (document.form.remark.value != "") {
        	sheetObjects[0].SetCellValue(j, "sheet1_remark",document.form.remark.value);
            sheetObjects[0].SetCellValue(j, "sheet1_date",ComGetMaskedValue(document.form.evnt_dt.value, "ymd"));
            sheetObjects[0].SetCellValue(j, "sheet1_id",document.form.evnt_usr_id.value);
        	sheetObjects[0].SetCellEditable(j, "sheet1_remark",0);
        	document.getElementById("id_save").style.display='none';
        } else {
        	sheetObjects[0].SetCellValue(j, "sheet1_remark",'');
            sheetObjects[0].SetCellValue(j, "sheet1_date",date.substring(0,16));
            sheetObjects[0].SetCellValue(j, "sheet1_id",id);
        	sheetObjects[0].SetCellEditable(j, "sheet1_remark",1);
        	document.getElementById("id_save").style.display='';
        }
        sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(), "sheet1_remark", true);
    }
    /**
  	 * Initializing sheet. Defining header
  	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
  	 * Composition a initial module in case of multi sheet
  	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":
                with (sheetObj) {
                var HeadTitle1="|Remark for Release|Input Date|Staff ID";
                var headCount=ComCountHeadTitle(HeadTitle1);
                var prefix="sheet1_";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [
                          {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                          {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"remark", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(95,1);
                }
                break;
        }
    }
    /* Processing Sheet */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //retrieve
            	if ("sheet1" == sheetObj.id) sheetObj.DoSearch("UI_BKG_0954_DATA1.html" );
                break;
            case IBSAVE:        //save
                if(!validateForm(sheetObj,formObj,sAction)) return;
            	//adding DB save module
	            formObj.f_cmd.value=MODIFY;
	            formObj.h_rmk.value=sheetObj.GetCellValue(1, "sheet1_remark");
	            var aryPrefix=new Array("sheet1_");    //prefix string array
	            var sParam1=sheetObjects[0].GetSaveString(true);
	            var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
	            var sXml=sheetObj.GetSaveData("ESM_BKG_0954GS.do", sparam);
	            sheetObjects[0].LoadSaveData(sXml,{Sync:1} );
	            sXml=ComDeleteMsg(sXml);
                break;
        }
    }
    /**
  	 * Checking validation of input value
  	 */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            //checking mandatory value
        	if(sheetObj.GetCellValue(1, "sheet1_remark") ==''){
                ComShowCodeMessage('BKG00548');
                sheetObj.SelectCell(1, "sheet1_remark", true);
                return false;
            }
            //checking input length
        	if( ComChkLenByByte(sheetObj.GetCellValue(1, "sheet1_remark"), 4000) == 0){
                ComShowCodeMessage("BKG00440");
                sheetObj.SelectCell(1, "sheet1_remark", true);
                return false;
            }
        }
        return true;
    }
    /**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
         if (ErrMsg == "") {
        	var returnValue=sheetObj.GetCellValue(1, "sheet1_remark");
        	 ComPopUpReturnValue(returnValue); 
         }
    }
