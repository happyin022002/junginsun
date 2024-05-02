/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0064.js
*@FileTitle  : Surcharge Group Commodity Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
// global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    
//아래 화면들에서 호출됨
//ESM_PRI_0001_03
    
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
         ComOpenWait(true);
         try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
            	case "btn_CheckAll":
                    sheetObject1.CheckAll("sel_chk",1);
                    break;
                case "btn_UncheckAll":
                    sheetObject1.CheckAll("sel_chk",0);
                    break;
                case "btn_Ok":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;
                case "btn_Close":
                	ComClosePopup(); 
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    /**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
    	ComOpenWait(true);
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                var HeadTitle="|Check|||||GroupCode|Description";
                var headCount=ComCountHeadTitle(HeadTitle);
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sel_chk" },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd" },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"scg_grp_cmdt_seq" },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"scg_grp_cmdt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"scg_grp_cmdt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);
                SetWaitImageVisible(0);
                SetSheetHeight(160);
               }
                break;
        }
    }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_PRI_0064GS.do", FormQueryString(formObj) );
                break;
            case IBSAVE:       
                if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
                formObj.f_cmd.value=MULTI;
                sheetObj.DoSave("ESM_PRI_0064GS.do", FormQueryString(formObj));
                break;
            case IBINSERT:      
                break;
        }
    }
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction) {
    	var checkedRows=sheetObj.FindCheckedRow("sel_chk");
    	var checkedRowArr = checkedRows.split("|");
    	
    	if (checkedRows == "" || checkedRowArr.length == 0 ) {
			ComShowCodeMessage('PRI00327');	
			return false;
		} 
    	
//        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
//        }
        return true;
    }
    /**
     * calling function when occurring OnChange Event <br>
     * when selecting multi comboBox, showing description <br>
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname) {
            case "sel_chk":
            	if (sheetObj.GetCellValue(Row, Col) == 1) {
                    sheetObj.SetRowStatus(Row,"I");
                }
                else {
                    sheetObj.SetRowStatus(Row,"R");
                }
                break;
        }
    }
    /**
     * calling function when occurring OnSearchEnd Event <br>
     * setting key data in the sheet after retrieving  <br>
     */
    function sheet1_OnSearchEnd(sheetObj) {
        var cnt=sheetObj.RowCount();
        var formObj=document.form;
        if (cnt > 0) {
            for (var i=1; i <= cnt; i++) {
                sheetObj.SetCellValue(i, "gline_seq",formObj.gline_seq.value,0);
                sheetObj.SetCellValue(i, "prc_cust_tp_cd",formObj.prc_cust_tp_cd.value,0);
                sheetObj.SetRowStatus(i,"R");
            }
        }
    }
    
    /**
     * calling function when occurring OnSaveEnd Event <br>
     * setting key data in the sheet after retrieving  <br>
     */
    function sheet1_OnSaveEnd(sheetObj, Code, Msg) {
    	if(Code == "0")	ComPopUpReturnValue("ok");
    }