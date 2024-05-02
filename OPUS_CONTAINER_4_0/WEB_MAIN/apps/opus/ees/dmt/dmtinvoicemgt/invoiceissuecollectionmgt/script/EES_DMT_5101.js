/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5101.js
*@FileTitle : Hold Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.12 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
    * @extends 
    * @class EES_DMT_5101 :  business script for EES_DMT_5101.
    */
    function ui_dmt_5101() {
        this.processButtonClick=processButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.validateForm=validateForm;
    }
// Common Global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn1_save":
                    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;
                case "btn1_close":
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); // HOLD REASON LIST
        document.form.holdRemrk.value="";
        //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
                
              var HeadTitle="Sel.|Seq.|Invoice Hold Reason|";

              

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"CheckBox" },
                     {Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"intg_cd_val_dp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"intg_cd_val_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
              SetSheetHeight(130);
              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
              SetEditable(1);
              SetCountPosition(0);
                    }
            break;
        }
    }
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     // Search
                formObj.f_cmd.value=SEARCH01;
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_DMT_5101GS.do",FormQueryString(formObj));
				ComOpenWait(false);
                var holdReason=ComGetEtcData(sXml, "holdReason");
                if ( holdReason != undefined && holdReason != '') {
                    var holdReasonArr=holdReason.split("||");
                    document.form.invoiceNo.value=holdReasonArr[0];
                    document.form.holdReasn.value=holdReasonArr[1];
                    document.form.holdRemrk.value=holdReasonArr[2];
                    document.form.holdYear .value=holdReasonArr[3];
                    document.form.holdOffc .value=holdReasonArr[4];
                    document.form.holdUser .value=holdReasonArr[5];
                    for ( var i18=1 ; i18 < sheetObjects[0].RowCount()+1 ; i18++  ) {
                    	if ( holdReasonArr[1] == sheetObjects[0].GetCellValue( i18 , 3 ) ) {
                            sheetObjects[0].SetCellValue( i18 , 0 ,1,0);
                        }
                    }
                }
            break;
            case IBSEARCH_ASYNC01:     // Search
                formObj.f_cmd.value=SEARCH;
//                sheetObj.Reset();
//                initSheet(sheetObjects[0], 1);
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				sheetObj.DoSearch("EES_DMT_5101GS.do", FormQueryString(formObj)  );
				ComOpenWait(false);
            break;
            case IBSAVE:        // save
                formObj.f_cmd.value=MULTI;
                var holdRsnTxt="";
                if ( sheetObjects[0].GetCellValue(4,0) == 1 ) {
                    if ( document.form.holdRemrk.value == "" || (document.form.holdRemrk.value).length < 10 ) {
                        ComShowCodeMessage( "DMT01106" );
                        document.form.holdRemrk.focus();
                        return false;
                    }
                }
                var cntChk=0;
                for ( var i18=1 ; i18 < sheetObjects[0].RowCount()+1 ; i18++  ) {
                	if ( sheetObjects[0].GetCellValue( i18 , 0 ) == 1 ) {
                        cntChk++;
                        holdRsnTxt=sheetObjects[0].GetCellText( i18 , "intg_cd_val_dp_desc" );
                    }
                }
                if ( cntChk == 0 ) {
                    ComShowCodeMessage( "DMT01107" );
                    return false;
                }
                document.form.holdRemrk.value=holdRsnTxt + " : " + document.form.holdRemrk.value;
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				sheetObj.DoSave("EES_DMT_5101GS.do", FormQueryString(formObj));
				ComOpenWait(false);
                var opener=window.dialogArguments;
        		if (!opener) opener=window.opener;  //이 코드 추가할것
        		if (!opener) opener=parent;  
                opener.chk_hold.value="Y";
                opener.loadPage();
                ComClosePopup(); 
            break;
        }
    }

    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
    function sheet1_OnSearchEnd( sheetObj ,  code, ErrMsg ) {
        with (sheetObj) {
        }
    }
    function sheet1_OnClick( sheetObj , Row, Col, Value ) {
        with (sheetObj) {
        	document.form.holdReasn.value=GetCellValue( Row , 3 );
        }
    }
