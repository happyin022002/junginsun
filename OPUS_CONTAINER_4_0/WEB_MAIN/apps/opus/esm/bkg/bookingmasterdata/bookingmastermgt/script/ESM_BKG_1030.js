/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1030.js
*@FileTitle  : EMandatory Item(s) Setup for Customized Service Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                              MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
                              Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;    
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
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
    
     /**
      * process when you enter retrieve condition
      */
     function obj_KeyUp() {
//         var formObject=document.form;
//         var srcName=ComGetEvent("name");
//         var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//         var srcValue=window.event.srcElement.getAttribute("value");
//         if (ComChkLen(srcValue, srcMaxLength) == "2") {
//            ComSetNextFocus();
//         }
     }
     
     
          /**
       * load HTML Control event on the page <br>
       * {@link #loadPage}call the function and init IBSheet Object <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 
       */
      function initControl() {
        var formObject=document.form;
      }
      
      
     /**
     * control keyboard input  onkeypress event of HTML Control
     **/
     function obj_keypress(){
//        switch(event.srcElement.dataformat){
//            case "int":
//                //num
//                ComKeyOnlyNumber(event.srcElement);
//                break;
//            case "float":
//                //num+"."
//                ComKeyOnlyNumber(event.srcElement, ".");
//                break;
//            case "eng":
//                //eng+num -> ComKeyOnlyAlphabet('num');
//                ComKeyOnlyAlphabet();
//                break;
//            case "engdn":
//                //lower Eng+num -> ComKeyOnlyAlphabet('lowernum');
//                ComKeyOnlyAlphabet('lower');
//                break;
//            case "engup":
//                //English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
//                ComKeyOnlyAlphabet('upper');
//                break;
//            case "engupnum":
//                //English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
//                ComKeyOnlyAlphabet('uppernum');
//                break;
//            default:
//                //enter just number
//                ComKeyOnlyNumber(event.srcElement);
//        }
    }
     
     
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":
                with(sheetObj){
                    var HeadTitle1="|Sel.|Seq.|Customer Code|Customer Code|Customer Code|Customer Code|S/C No.|Expire Date|RFA No.|Expire Date|SVC Scope|Origin|Dest.|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Remark(s)|Update Date|User ID";
                    var headCount=ComCountHeadTitle(HeadTitle1);
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
                         {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mdt_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_grp_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 , AcceptKeys:"E|N", InputCaseSensitive:1},
                         {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 , AcceptKeys:"E|N", InputCaseSensitive:1},
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sc_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9, AcceptKeys:"E|N", InputCaseSensitive:1 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sc_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rfa_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11, AcceptKeys:"E|N", InputCaseSensitive:1 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rfa_exp_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_pob",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"itm_nm_pob",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_poc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"itm_nm_poc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_pom",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"itm_nm_pom",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_inv",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"itm_nm_inv",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_dep",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:95,   Align:"Left",    ColMerge:1,   SaveName:"itm_nm_dep",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_lc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"itm_nm_lc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_shp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"itm_nm_shp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_pat",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"itm_nm_pat",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:22,   Align:"Center",  ColMerge:1,   SaveName:"itm_cd_inc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"itm_nm_inc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"mdt_itm_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fcust",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mdt_itm_seq" },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_code" } ];
                     
                    InitColumns(cols);
                      SetEditable(1);
                      SetColProperty("mdt_cust_tp_cd", {ComboText:"SH|CN|NT|All", ComboCode:"SH|CN|NT|Al"} );
                      SetSheetHeight(420);
                      SetColProperty("cust_grp_id", {AcceptKeys:"E|N"});
                      SetColProperty("cust_seq", {AcceptKeys : "N"} );
                  }
                break;
        }
    }
        
        
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	sheetObj.SetColBackColor(5, "#FFFF6F");
    	sheetObj.SetColBackColor(6, "#FFFF6F");
        	sheetObj.SetColBackColor(7, "#FFFF6F");
        	sheetObj.SetColBackColor(9, "#FFFF6F");
       
    }
    
  // Event handler processing by button name */
     function processButtonClick(){
          /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Add":
                    sheetObject1.DataInsert(-1);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),15,"P/O No.(by BKG)",0);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),17,"P/O No.(by CNTR)",0);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),19,"P/O No.(by Item)",0);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),21,"Invoice No.",0);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),23,"Department No.",0);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),25,"L/C No.",0);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),27,"Ship ID",0);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),29,"Part No",0);
                    sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),31,"Incoterms",0);
                    break;
                case "btn_Delete":
                    doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
                    break;
                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                    break;
                case "btn_Close":
                    ComClosePopup(); 
                    break;
                case "btn_Copy":
                    rowCopy();                      
                    break;
             } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
     }
     
     function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
                case IBSEARCH:      //retrieve
                if(!validateForm(sheetObj,formObj,sAction)) return;
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;   
                sheetObj.DoSearch("ESM_BKG_1030GS.do",FormQueryString(formObj) );
                break;
            case IBSAVE:        //Save
                if(!validateForm(sheetObj,formObj,sAction)) return;
                
                if(!chkDuplicate(sheetObj)) return;
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI;  
                var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("");
                sheetObj.DoSave("ESM_BKG_1030GS.do", sParam);
                break;
            case IBDELETE:      // delete                       
                ComRowHideDelete(sheetObj, "Sel");  
                break;
        }
        ComOpenWait(false);
    }
        
        
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
         switch(sAction) {
            case IBSEARCH:      //retrieve
            break;
            
            case IBSAVE:      //save
                for(var i=1 ; i < sheetObj.LastRow()+1 ; i++){
                    if (sheetObj.GetRowStatus(i) == "I" || sheetObj.GetRowStatus(i) == "U"){
                        var custCntCd=sheetObj.GetCellValue(i, "cust_cnt_cd");
                        var custSeq=sheetObj.GetCellValue(i, "cust_seq"   );
                        var scNo=sheetObj.GetCellValue(i, "sc_no"      );
                        var rfaNo=sheetObj.GetCellValue(i, "rfa_no"     );
                        if ((ComIsNull(custCntCd) || ComIsNull(custSeq)) && ComIsNull(scNo) && ComIsNull(rfaNo)) {
                            if ((ComIsNull(custCntCd) || ComIsNull(custSeq))) {
                                if (ComIsNull(custCntCd)) {
                                    ComShowCodeMessage("BKG00888", "Customer Code(cust_cnt_cd)");//Mandatory Input item(s) is(are) missing: {?msg1}
                                    sheetObj.SelectCell(i, "cust_cnt_cd", true, "");
                                }
                                if (ComIsNull(custSeq)) {
                                    ComShowCodeMessage("BKG00888", "Customer Code(cust_seq)");//Mandatory Input item(s) is(are) missing: {?msg1}
                                    sheetObj.SelectCell(i, "cust_seq", true, "");
                                }
                            } else if (ComIsNull(scNo)) {
                                if (ComIsNull(scNo)) {
                                    ComShowCodeMessage("BKG00888", "S/C No.");//Mandatory Input item(s) is(are) missing: {?msg1}
                                    sheetObj.SelectCell(i, "sc_no", true, "");
                                }
                            } else if (ComIsNull(rfaNo)) {
                                if (ComIsNull(rfaNo)) {
                                    ComShowCodeMessage("BKG00888", "RFA No.");//Mandatory Input item(s) is(are) missing: {?msg1}
                                    sheetObj.SelectCell(i, "rfa_no", true, "");
                                }
                            }
                            return false;
                        }
                        formObj.chk_cust_cd.value=custCntCd;
                        formObj.chk_cust_seq.value=custSeq;
                        formObj.f_cmd.value=SEARCH01;                         
                        var searchXml=sheetObj.GetSearchData("ESM_BKG_1030GS.do" ,FormQueryString(formObj));
                        if (searchXml.indexOf("MESSAGE") > 0){
                        	showErrorMsg(searchXml);
                            return false;
                        }
                    }
                }
                break;
         }
        return true;
    }
        
        
        
     /**
      * Row Copy
      */
    function rowCopy(){
        var formObj=document.form;
        var rowIdx=formObj.copy_idx.value;
        if (rowIdx == ''){
            rowIdx=1;
            formObj.copy_idx.value=1;
        }
        //for (var i=0 ; i < rowIdx ; i++){
        var cnt = sheetObjects[0].DataCopy();
        sheetObjects[0].DataMove(sheetObjects[0].RowCount() + 1, cnt);
        //}
    }
        
        
        
   function chkCustCd(sheetObj,Row, Col, Value){
       var formObj=document.form; 
       if (sheetObj.GetCellValue(Row, "cust_cnt_cd") != '' && sheetObj.GetCellValue(Row, "cust_seq") == ''){
               ComShowCodeMessage("BKG00408");//Please input Customer Code or Name.
               sheetObj.SelectCell(Row, "cust_seq", true, '');
               return;
           }
       if (sheetObj.GetCellValue(Row, "cust_cnt_cd") == '' && sheetObj.GetCellValue(Row, "cust_seq") != ''){
               ComShowCodeMessage("BKG00408");//Please input Customer Code or Name.
               sheetObj.SelectCell(Row, "cust_cnt_cd", true, '');
               return;
           }
       if (sheetObj.GetCellValue(Row, "cust_cnt_cd") == '' && sheetObj.GetCellValue(Row, "sc_no") == '' && sheetObj.GetCellValue(Row, "rfa_no") == ''){
               ComShowCodeMessage("BKG00888");//Mandatory Input item(s) is(are) missing: {?msg1}
               sheetObj.SelectCell(Row, "cust_cnt_cd", true, '');
               return;
           }
           if (Col == 5 || Col == 6){
                formObj.chk_cust_cd.value=sheetObj.GetCellValue(Row, "cust_cnt_cd");
                formObj.chk_cust_seq.value=sheetObj.GetCellValue(Row, "cust_seq");
               formObj.f_cmd.value=SEARCH01;                      
               var searchXml=sheetObj.GetSearchData("ESM_BKG_1030GS.do" ,FormQueryString(formObj));
               var check=ComGetEtcData(searchXml,"check");
               if (searchXml.indexOf("MESSAGE") > 0){
                   ComShowCodeMessage("BKG08141");//Duplicate Control Office,Agent,Customer Code! Please try again.
                   sheetObj.SelectCell(i, "cust_cnt_cd", true, '');
               } 
           }               
   }
   
   
   
     /* After retrieve, Sheet Change Event
      * add duplicate Validation 
      */
     function sheet1_OnChange(sheetObj, Row, Col, Value){
         if (3==Col || 5==Col || 6==Col) {
             var formObj=document.form;
             var r_focus=sheetObj.ColSaveName(Col);
            var cust_tp_cd=sheetObj.GetCellValue(Row, "mdt_cust_tp_cd");
            var cust_cnt_cd=sheetObj.GetCellValue(Row, "cust_cnt_cd");
            var cust_seq=sheetObj.GetCellValue(Row, "cust_seq");
             var cnt=sheetObj.RowCount();
                 if(ComIsNull(cust_tp_cd) != true && ComIsNull(cust_cnt_cd) != true && ComIsNull(cust_seq) != true){
                     var findRow=sheetObj.FindText("fcust",cust_tp_cd + cust_cnt_cd + cust_seq);
                     if(findRow > 0 && findRow != Row){
                         ComShowCodeMessage('BKG00764', 'Customer Code');
                         sheetObj.SelectCell(Row,Col,true)
                         return ;
                     }
                 }      
         }
     }
     
     
     
     /* Customer Redundant processing 
      * add duplicate Validation 
      */
     function chkDuplicate(sheetObj){
    	 var formObj=document.form;
    	 formObj.f_cmd.value=SEARCH02;                   
         var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
         var searchXml=sheetObj.GetSearchData("ESM_BKG_1030GS.do" ,sParam);
         
         var check=ComGetEtcData(searchXml,"DUP_CUST");
         if (searchXml.indexOf("MESSAGE") > 0){
        	 showErrorMsg(searchXml);
             return false;
         }
         if (check=="Y"){
        	 ComShowCodeMessage('BKG00764', 'Customer Code');
        	 return false;
         }
         return true;
     }
     
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if(ErrMsg=="")		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}     
     
//     function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
//    		sheetObj.SetRowBackColor(1, 4, "#FFFF6F");
//    	}
