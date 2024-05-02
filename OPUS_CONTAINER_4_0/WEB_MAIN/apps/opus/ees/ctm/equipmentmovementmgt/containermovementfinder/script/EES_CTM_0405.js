/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_ctm_0405.js
*@FileTitle : Empty VL List without BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

//common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var errorXml="";
var wbl_no = "";//2014.12.26 김성욱 추가

// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick() {
         var sheetObj=sheetObjects[0];
         var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Calendar":
                    // if (!window.event.srcElement.disabled) {
                        var cal=new ComCalendarFromTo();
                        cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                    // }
                    break;
                case "btn_delete":
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    doActionIBSheet(sheetObj, frmObj, IBSAVE);    
                    ComOpenWait(false);
                    sheetObj.SetWaitImageVisible(1);
                    break;
                case "btn_retrieve":
                    if (!checkFormField()) return;
                    sheetObj.SetHeaderCheck(0, "Sel",0);
                    doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    break;
                case "btn_new":
                    ComResetAll();
                    frmObj.p_yard1.value="";
                    comboObjects[0].RemoveAll();
                    frmObj.lcc_cd.focus();
                    doActionIBSheet(sheetObj, frmObj, SEARCH01);
                    break;
                case "btn_downexcel":
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    if(sheetObj.RowCount() < 1){
                		ComShowCodeMessage("COM132501");
                	}else{
                		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(                    sheetObj), SheetDesign:1,Merge:1 });
                	}                    
                    ComOpenWait(false);
                    sheetObj.SetWaitImageVisible(1);
                    break;
            } // end switch
        } catch(e) {
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
    function setSheetObject (sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list
     * param : combo_obj
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setComboObject(combo_obj) {
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        setEventProcess("rcc_cd", "lcc_cd", "yd_cd_disp");
        // OnKeyPress
        //axon_event.addListener("keypress", "obj_keypress", "lcc_cd", "yd_cd_disp");
        // OnKeyUp 
        axon_event.addListenerForm("blur", "obj_onkeyup", document.form);
        ComBtnDisable("btn_delete");
        document.form.lcc_cd.focus();
        
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
        
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt=0;
        with(sheetObj){            

          //no support[check again]CLT MultiSelection=true;
          SetSelectionMode(smSelectionList);
          var HeadTitle="|Seq.|Container No.|TP/SZ|STS|Event date|Origin Yard|EDI POD|VVD|Call sign|Lloyd|Remark(s)";
          SetEditEnterBehavior("tab");

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"DummyCheck", Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"Sel",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lloyd_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:0,   SaveName:"mty_repo_vl_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_svr_id" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lst_flg" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_seq" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_co_cd" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_xch_cd" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mgst_no" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_no" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inp_yd_cd" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_split_no" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pkup_no" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wbl_no" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_id" } ];
           
          InitColumns(cols);

          SetEditable(1);
          SetDataAutoTrim(1);
          //SetCountPosition(0);
          SetSheetHeight(442);
          resizeSheet();
                }


    }
    
    //handling process for Sheet
    function doActionIBSheet(sheetObj,frmObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:   
            	// Added by Kato
            	if(frmObj.rcc_cd.value != "" || frmObj.lcc_cd.value != ""|| frmObj.vvd_cd.value != ""){
            	
	            	if (validateForm(sheetObj, frmObj, sAction)) {
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
	                    frmObj.f_cmd.value=SEARCH;
	                     sheetObj.DoSearchFx("EES_CTM_0405GS.do", FormQueryString(frmObj) );
	                }
            	
            	}else{ComShowCodeMessage("CTM00000", " at lease either RCC or LCC or VVD Code");
					return
				}
            	
                break;
            case IBSAVE:    
                if (sheetObj.CheckedRows("Sel") < 1) {
                    ComShowCodeMessage("CTM30001");
                    return;
                }
                if (ComShowCodeConfirm("CTM30006")) {
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    errorXml="";
                    // Object Disable
                    ComOpenWait(true);
                    ComBtnDisable("btn_delete");
                    ComBtnDisable("btn_retrieve");
                    ComBtnDisable("btn_new");
                    ComBtnDisable("btn_downexcel");
                    DomSetFormObjDisable(frmObj, true);
                    p_yard2.SetEnable(0);
                    var flag = true;
                    with (sheetObj) {
                        var queryString="";
                        var startIdx=0;
                        var endIdx=0;
                        var checkIdxArr=FindCheckedRow("Sel").split("|");//(FindCheckedRow("Sel").substring(0, FindCheckedRow("Sel").length - 1)).split("|");
                        var checkCount=checkIdxArr.length;
                        var loopCount=0;
                        if (checkCount < (sendRows * maxThreadCount) + 1) {
                            loopCount=Math.ceil(checkCount / sendRows);
                        } else {
                            sendRows=Math.ceil(checkCount / maxThreadCount);
                            loopCount=maxThreadCount;
                        }
                        for (var i=1; i<=loopCount; i++) {
                            if (i == loopCount) {
                                endIdx=checkCount - 1;
                            } else {
                                endIdx += sendRows;
                                var currStartIdx=Number(startIdx) + Number(endIdx);
                                var currEndIdx=endIdx;
                            }
                            var tempString="";
                            for (var h=startIdx; h<=endIdx; h++) {
                            	tempString=("&mty_repo_vl_rmk=" + GetCellValue(checkIdxArr[h], "mty_repo_vl_rmk"));
                            	queryString += ("ibflag=D&" + ComReplaceStr(RowSaveStr(checkIdxArr[h]), tempString, "") + "&");
                                tempString="";
                            }
                          
                            if( wbl_no[i] != "" ) {//2014.12.26 김성욱 추가
                            	//transmitting
                            	xmlHttpPost ("EES_CTM_0440GS.do", queryString + "AJAX=Y&f_cmd=" + MULTI, "rtnUpdateParses", checkIdxArr[startIdx]);
                            } else {//2014.12.26 김성욱 추가
                            	flag = false;//2014.12.26 김성욱 추가
                            }//2014.12.26 김성욱 추가
                            queryString="";
                            startIdx=endIdx + 1;
                            sendCount++;
                        }
                        SetHeaderCheck(0, "Sel",0);
                    }
                  //2014.12.26 김성욱 추가 시작
                    if( !flag ) {
	                    alert("Some data couldn't be deleted due to no booking number.\nPlease check it again. ");
	                	ComBtnEnable("btn_retrieve");
	                    ComBtnEnable("btn_new");
	                    ComBtnEnable("btn_downexcel");
	                    DomSetFormObjDisable(frmObj, false);
	                    p_yard2.SetEnable(1);
                    }
                  //2014.12.26 김성욱 추가 여기까지
                }
                break;
            case SEARCH01:    // retrieving RCC_CD
                frmObj.f_cmd.value=SEARCH01;
                comboObj=rcc_cd;
                var rtn=sheetObj.GetSearchData("EES_CTM_0418GS.do", FormQueryString(frmObj));
                if (rtn == "") return;
                rtn=ComGetEtcData(rtn, "rtn");
                var rtnList=rtn.split("^");
                comboObj.RemoveAll();
                sheetObj.RemoveAll();
                idxSelect="";
                
                for (var i=0; i<=rtnList.length; i++) {
                    if (rtnList[i]) {
                        rtnValue=rtnList[i].split("|");                        
                        comboObj.InsertItem(i, rtnValue[0], rtnValue[0]);                        
                    }
                }
                
                comboObj.InsertItem(comboObj.GetItemCount(), "", "");
                
                if (idxSelect == "") {                	
                    comboObj.SetSelectText("ALL", true);
                } else {                	
                    comboObj.SetSelectText(idxSelect, true);
                }
                comboObj.SetSelectText("", true);
                
                break;
        }
    }
    function rtnUpdateParses(rtnXml, startId) {
        sendCount--;
        if (ComGetEtcData(rtnXml, "TRANS_RESULT_KEY") == "F") {
            errorXml=rtnXml;
        }
        if (sendCount < 1) {
           var frmObj=document.form;
            // Object Enable
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_new");
            ComBtnEnable("btn_downexcel");
            DomSetFormObjDisable(frmObj, false);
            p_yard2.SetEnable(1);
            ComOpenWait(false);
            sheetObjects[0].SetWaitImageVisible(1);
            if (errorXml != "") {
                if (sheetObjects[0].RowCount()> 0) {
                    // making btn_del Enable
                    ComBtnEnable("btn_delete");
                } else {
                    // making btn_del Enable
                    ComBtnDisable("btn_delete");
                }
                 sheetObjects[0].LoadSaveData(errorXml);
            } else {
                ComShowCodeMessage("CTM10022", "Empty VL List without BKG");
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    }
    /**
     * handling OnKeyUp event for HTML Object
     */
    function obj_onkeyup(event) {
        srcValue=event.srcElement.value;    
        var frmObj=document.form;
        var sheetObj=sheetObjects[0];
        switch(event.srcElement.name) {
            case "lcc_cd":
                var lcc_cd=event.srcElement;
                // calling code_search() in CTM common function in case of 5 characters in lcc_cd
                if (lcc_cd.value.length > 4) {
                     var lccChechXml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH13 + "&p_yard1=" + lcc_cd.value);
                    var rtnValue=ComGetEtcData(lccChechXml, "rtnValue");
                    if (rtnValue) {
                        if (rtnValue == "S") {
                            setFocusIndex(lcc_cd, 1);
                        } else {
                            ComShowCodeMessage("CTM20072");
                            lcc_cd.value="";
                            lcc_cd.focus();
                        }
                    } else {
                        ComShowCodeMessage("CTM20072");
                        lcc_cd.value="";
                        lcc_cd.focus();
                    }
                }
                break;
            case "yd_cd_disp":
                var ydCdDisp=frmObj.yd_cd_disp;
                if (ydCdDisp.value.length > 1) {
                    frmObj.p_yard1.value=ydCdDisp.value.toUpperCase();
                    if (ydCdDisp.value.length > 4) {
                    	// calling  yard_search() in CTM common function in case of 5 characters in p_yard1
                         if (!yard_search()) {
                        	 frmObj.yd_cd_disp.value = "";
                             ydCdDisp.select();
                             ydCdDisp.focus();
                         } else {
                               frmObj.p_yard2.focus();
                         }
                    } else {
                        frmObj.p_yard2.RemoveAll();
                    }
                } else {
                    frmObj.p_yard1.value="";
                    frmObj.p_yard2.RemoveAll();
                }
                break;
        }
        onShowErrMsg=false;
    }
    /**
     * handling OnSearchEnd event for Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            // in case of existing result
            if (sheetObj.RowCount()> 0) {
                // making btn_del Enable
            	//2014.12.26 김성욱 추가 시작
            	wbl_no = new Array(sheetObj.RowCount());
            	var count = sheetObj.RowCount();
            	for( var x=1 ; x<=count ; x++ ){
            		wbl_no[x] = sheetObj.GetCellValue(x,"wbl_no");
            	}
            	//2014.12.26 김성욱 추가 여기까지
//            	var cntr_no = sheetObj.GetCellValue(1,"cntr_no");
//            	alert( cntr_no +":"+ wbl_no );
                ComBtnEnable("btn_delete");
            } else {
                // making btn_del Enable
                ComBtnDisable("btn_delete");
            }
        }
        ComOpenWait(false);
        sheetObj.SetWaitImageVisible(1);
    }
     /**
      * event when clicking cell in IBSheet data part
      * @param {sheetObj} String :  IBSheet cell name
      * @param {Row} Long : cell Row Index
      * @param {Col} Long : cell Column Index
      * @param {Value} String : changed value
      * @param {CellX} Long : cell x-coordinate
      * @param {CellY} Long : cell y-coordinate
      * @param {CellW} Long : cell width
      * @param {CellH} Long : cell length
      */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "Sel") {
                var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (GetCellEditable(arr[i], "Sel")) {
                            SetCellValue(arr[i], "Sel","1",0);
                        }
                    }
                }
            }
        }
    }

//  /**
//  * handling OnChange event of rcc_cd[combo0] Object
//  */
 function rcc_cd_OnChange (comboObj, OldIndex, OldText, OldCode, NewIndex, text, code){
     var frmObj=document.form;
     var sheetObj=sheetObjects[0];
     
     var rccChechXml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH13 + "&p_yard1=" + code);
     var rtnValue=ComGetEtcData(rccChechXml, "rtnValue");
   if (rtnValue) {
       if (rtnValue == "S") {
           setFocusIndex(rcc_cd, 1);
       } else {
           ComShowCodeMessage("CTM20072");
           comboObj.SetSelectText("", true);
       }
   } else {
       //ComShowCodeMessage("CTM20072");
       comboObj.SetSelectText("", true);
   }
     
 }
    
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,frmObj,sAction) {
        with (frmObj) {
        }
        return true;
    }
    function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
    }
