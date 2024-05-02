/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3519.js
*@FileTitle  : Tariff Rule Amend Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================**/

/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


    var sheetObjects=new Array();
    var sheetCnt=0;
    var returnData=false;
    
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_ok":
                    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                    break;
                case "btn_close":
                	ComPopUpReturnValue(returnData);
                    ComClosePopup(); 
                    break;
            } // end switch            
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        if (sheetObjects[0].RowCount()> 0){
            sheetObjects[0].SelectCell(1, "eff_dt");
        }
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
        case "sheet1":      //t1sheet1 init
            with(sheetObj){                 
                  //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                  var HeadTitle="|Amend No.|Effective Date|1|2|3|4|5|6|7|8|9";
                  var headCount=ComCountHeadTitle(HeadTitle);
        
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
        
                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                         {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Date",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_pfx_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_rule_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pub_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_rule_amdt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"trf_rule_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bef_eff_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt" } ];
                   
                  InitColumns(cols);        
                  SetEditable(1);
                  SetCountPosition(0);
                  SetWaitImageVisible(0);
                  SetSheetHeight(100);
                }
                break;            
        }
    }
  /**
   * Handling sheet process <br>
   */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            sheetObj.ShowDebugMsg(false);
            switch (sAction) {                                                                      
                case IBSEARCH: // retrieve
                    var opener=window.dialogArguments;
                    if (!opener) opener=parent; //이 코드 추가할것
                    var sXml=opener.getSheetXml();
                    
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    break;
                case IBSAVE: // Save
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    if (!ComPriConfirmSave()) {
                        return false;
                    }
                    ComOpenWait(true);
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "amdt_seq",parseInt(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")) + 1,0);
                    sheetObj.DoAllSave("ESM_PRI_3519GS.do", "f_cmd=" + MODIFY01);
                    break;                  
            }
        }catch(e){
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally {
             ComOpenWait(false);
        }
    }
    /**
     * calling function when occurring OnSearchEnd Event <br>
     */
    function sheet1_OnSearchEnd(sheetObj, code ,errMsg){
    	if(sheetObj.RowCount() ==0 ) return;
        var formObj=document.form;
        formObj.tariff_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")+"-"+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no");
        formObj.rule_no.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no");
        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bef_eff_dt",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt"),0);
        //sheetObj.CellValue2(sheetObj.SelectRow, "amdt_seq") = parseInt(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq")) + 1;
        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd","I",0);
        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "eff_dt","",0);
    }
    /**
     * calling function when occurring OnSaveEnd event  <br>
     * setting modify Flag = 'Y' after saving <br>
     */     
    function sheet1_OnSaveEnd(sheetObj, code ,ErrMsg)  {
    	if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            returnData=true;
        }
    	
    	if (returnData){
        	ComPopUpReturnValue(returnData);
            ComClosePopup(); 
            return;
        }
    }
    /**
    * checking data to prohibit modifying same S/C before processing amend, request <BR>
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
        var returnValue=false;
        /////////////////////////////////////////////////////////////////////
       switch(checkTpCd){
       case "CHECK1" :
            var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_RULE&page_name=Tariff Rule"
                + "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                + "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no") 
                + "&key3="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                + "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no")
                + "&upd_dt="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "upd_dt");          
            var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
            if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
                sheetObj.LoadSearchData(cXml,{Sync:1} );
                ComOpenWait(false); //->waiting->End
                returnValue=true;
            }
            break;
       case "CHECK2" : //amend
           var amdt_seq=parseInt(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq"));
            //checking existence of next seq
            amdt_seq++;
            var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_RULE&page_name=Tariff Rule"
                + "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                + "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                + "&key3="+amdt_seq
                + "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no")
                + "&upd_dt="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "upd_dt");          
            var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
            if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
                sheetObj.LoadSearchData(cXml,{Sync:1} );
                ComOpenWait(false); //->waiting->End
                returnValue=true;
            }
            break;
       }
       return returnValue;    
    }
     /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: // retrieve
            break;
        case IBSAVE:
            var effDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt");
            var bExpDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt");
            var bEffDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bef_eff_dt");
            if(effDt == "") {
                ComShowCodeMessage("PRI00316", "Effective Date");
                sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
                return false;
            }  
            if(bEffDt >= effDt) {
                ComShowCodeMessage("PRI00354", "previous amendment Seq. effective date");
                sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
                return false;
            }
            /*
            if(bExpDt != "" && bExpDt < effDt) {
                ComShowCodeMessage("PRI00353", "tariff rule expiration date");
                sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
                return false;
            }
            */
            /////////////////////////////////////////////////////////////////////
            if( checkChangingUpdateDate(sheetObj, "CHECK2") ){
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;
        }
        return true;
    }
