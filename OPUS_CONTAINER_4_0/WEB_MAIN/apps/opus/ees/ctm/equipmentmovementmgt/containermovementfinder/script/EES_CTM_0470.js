/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0470.js
*@FileTitle : Deleted CNTR MVMT History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
	            case "btn_add":
	                addRow();
	                break;
	            case "btn_del":
	                var sRowStr=sheetObject.FindCheckedRow("del_chk");
	                if (sRowStr == "") {
	                     ComShowCodeMessage("CTM30001"); 
	                     return ;
	                 }
	                var arr=sRowStr.split("|");
	                
	                for (i=arr.length; i >= 0; i--) {
	                    if (sheetObj.GetRowStatus(arr[i]) == "I") {
	                        sheetObj.RowDelete(arr[i], false);    // changing selected row's status to 'D' for deleting
	                    } else {
	                        sheetObj.SetRowStatus(arr[i],"D");// changing selected row's status to 'D' for deleting
	                        sheetObj.SetRowHidden(arr[i],1);// hiding selected row
	                    }
	                }
	                break;
                case "btn_retrieve":
                    if (!checkFormField()) return;
                    doActionIBSheet(sheetObject, frmObj, IBSEARCH);
                    break;
                case "btn_save":
                	sheetObject.SetWaitImageVisible(1);
                    doActionIBSheet(sheetObject, frmObj, IBSAVE);
                    break;                     
                case "btn_new":
                    ComResetAll();
                    frmObj.cntr_no.focus();
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
                case "btn_detail":
                	selectedRow=sheetObject.GetSelectRow();
                    bkg_no=sheetObject.GetCellValue(selectedRow, "bkg_no")
                    sUrl="/opuscntr/EES_CTM_0471_POP.do?bkg_no=" + bkg_no;
                    iWidth="1000";
                    iHeight="400";
                    ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1");
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
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for (i=0; i<sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // CTM-COMMON
        setEventProcess();
        if (document.form.cntr_no.value!=undefined && document.form.cntr_no.value!="")
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        // focusing on page loading
        document.form.cntr_no.focus();
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        with (sheetObj) {
            switch (sheetNo) {
            case 1:    // sheet[0] init
	              var HeadTitle="||OSCAR FLAG|BKG NO|CNTR No. | CYC No. | LAST MOVEMENT | LAST MOVEMENT DATE| 1st LP ETD DT | Trunk VVD";
	             
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:11, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                           {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                     {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"oscar_flag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:10 },
	                     {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",     	Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",             KeyField:0,   CalcLogic:"",   Format:"###",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	                     {Type:"Text",     Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:19 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"vps_etd_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:19 },
	                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trunk_vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"max_cnmv_cyc_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	               
	              InitColumns(cols);
	              
	              SetEditable(1);
	              SetCountPosition(0);
	//              SetSheetHeight(442);
	              resizeSheet();
	              break;
            }
        }
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    frmObj.f_cmd.value=SEARCH;
                    sheetObj.DoSearch("EES_CTM_0470GS.do", FormQueryString(frmObj), { Sync : 1, Append : 0 } );
                }
                break;
            case IBSAVE:
            	for(i=1; i<=sheetObj.RowCount(); i++) {
            		if (sheetObj.GetCellValue(i, "bkg_no") == null || sheetObj.GetCellValue(i, "bkg_no") == "") {
            			ComShowCodeMessage("CTM00000", "Booking no");
                        sheetObj.SelectCell(i, "bkg_no", true);
            			return;
            		} else if (sheetObj.GetCellValue(i, "bkg_no").length < 10) {
            			ComShowCodeMessage("CTM99999", "Booking no have to be 10 digit");
                        sheetObj.SelectCell(i, "bkg_no", true);
            			return;
            		}
                	
                	if ( ("I"==sheetObj.GetCellValue(i, "ibflag") || "U"==sheetObj.GetCellValue(i, "ibflag")) && sheetObj.GetCellValue(i, "cnmv_cyc_no")) {
                		var cntrNo = sheetObj.GetCellValue(i, "cntr_no")
                		var xml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntrNo);
                        var rtnValue=ComGetEtcData(xml, "rtnValue");
                        if (rtnValue == null) {
                            ComShowCodeMessage("CTM10004");
                            return;
                        } else {
                        	rtnStr=rtnValue.split("|");
                        	var cycNo = "";
                        	if (rtnStr[1] == "ID" || ((rtnStr[1] == "MT" || rtnStr[1] == "EN" || rtnStr[1] == "TN") && rtnStr[8] == "N")) {
                        		cycNo = "9999";
                        	} else {
                        		var sxml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH30 + "&p_cntrno=" + cntrNo);
                                cycNo=ComGetEtcData(sxml, "rtnValue");
                        	}
                        	var txml=sheetObj.GetSearchData("EES_CTM_0470GS.do", "f_cmd=" + SEARCH01 + "&cntr_no=" + cntrNo + "&cnmv_cyc_no=" + cycNo);
                            var bkgFlg = ComGetEtcData(txml, "rtnValue");
                            if (bkgFlg != "N") {
                            	ComShowCodeMessage("CTM99999", "["+cntrNo+"] has been assigned to OPUS Booking. ["+bkgFlg+"]");
                            	sheetObj.SetCellValue(i, "cnmv_cyc_no", "");
                                sheetObj.SelectCell(i, "cnmv_cyc_no", true);
                    			return;
                            }
                        }
                	}
            	}

                if (sheetObj.IsDataModified()) {
                    sheetObj.SetWaitImageVisible(0);
                    frmObj.f_cmd.value=MULTI;
                    sheetObj.DoSave("EES_CTM_0470GS.do", FormQueryString(frmObj));
                }
                break;
        }
    }
    /**
     * handling OnSearchEnd event in Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        
        row_Editable4Sheet2();
        
        for(var i=0;i<sheetObj.RowCount();i++){
        	if(sheetObj.GetCellValue(i+1,"oscar_flag")=="Y" && (sheetObj.GetCellValue(i+1,"cnmv_cyc_no") == "" || sheetObj.GetCellValue(i+1,"cnmv_cyc_no") == "9999" || sheetObj.GetCellValue(i+1,"cnmv_cyc_no") ==  sheetObj.GetCellValue(i+1,"max_cnmv_cyc_no"))){
            	sheetObjects[0].SetCellEditable(i+1, "cnmv_cyc_no", 1);
        	}
        }        
        sheetObj.SetWaitImageVisible(1);
    }
    
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);     
        sheetObj.SetWaitImageVisible(1);
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
    
    /**
     * comparing values for validation in case grid value changed
     * @param sheetObj
     * @param Row
     * @param Col
     * @param KeyCode
     * @param Shift
     * @return
     */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	//alert("event name : sheet1_OnKeyUp(" + row + "," + sheetObj.ColSaveName(Col) + "," + KeyCode + "," + Shift + ")");
        var SaveName=sheetObj.ColSaveName(Col);
        if (Row < 1) return;
    }

    function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue, RaiseFlag) {
    	//alert("event name : sheet1_OnChange(" + Row + "," + sheetObj.ColSaveName(Col) + "," + Value + "," + OldValue + "," + RaiseFlag + ")");
        var SaveName=sheetObj.ColSaveName(Col);
        switch (SaveName) {
    	    case "bkg_no":
    	    	if(sheetObj.GetCellValue(Row,Col).length >= 10) {
    	        	sheetCheckValue(sheetObj, Row, Col, true);	 
    	        }
    	    	break;
        }
    	
    }
    /**
     * validating real value
     * @param sheetObj
     * @param Row
     * @param Col
     * @param isOut
     * @return
     */
    function sheetCheckValue(sheetObj, Row, Col, isOut) {
        var SaveName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch (SaveName) {
        case "bkg_no":
            bkg_no=sheetObj.GetCellValue(Row, "bkg_no");
            
            if (bkg_no.length < 10) {
                return;
            }
            
            queryString="f_cmd=" + SEARCH21 + "&p_bkg_no=" + bkg_no;
            xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
            rtnValue=ComGetEtcData(xml, "rtnValue");
            //alert("BOOKING rtnValue : " + rtnValue);
            if (rtnValue == "") {
                sheetObj.SetCellValue(Row, "bkg_no","");
                ComShowCodeMessage("CTM20999");
                sheetObj.SelectCell(Row, Col, true);
            } else {
                rtnStr=rtnValue.split("||");
            	sheetObj.SetCellValue(Row, "vps_etd_dt",rtnStr[8]);
                sheetObj.SetCellValue(Row, "trunk_vvd",rtnStr[9]);
            }
            
            for (i=1; i<Row; i++) {
            	ibkg_no=sheetObj.GetCellValue(i, "bkg_no");
            	if (bkg_no == ibkg_no) {
                    sheetObj.SetCellValue(Row, "bkg_no","");
                    sheetObj.SetCellValue(Row, "vps_etd_dt","");
                    sheetObj.SetCellValue(Row, "trunk_vvd","");
                    ComShowCodeMessage("CTM99999","Same Booking no already exists.");
                    sheetObj.SelectCell(Row, Col, true);
            	}
            }
            
            break;
        }
    }
    
    /**
     * Use in [btn_add]
     * @param Row
     * @return
     */
    function addRow() {
        var sheetObject=sheetObjects[0];
        var formObj=document.form;
        var Row=0;
        if (checkFormField()) {       

            Row=sheetObject.DataInsert(-1);
            sheetObject.SetCellValue(Row, "oscar_flag","Y");
            sheetObject.SetCellValue(Row, "cntr_no",formObj.cntr_no.value);
	        sheetObj.SetCellEditable(Row, "bkg_no",1);
	        sheetObj.SetCellEditable(Row, "cnmv_cyc_no",1);
            sheetObj.SelectCell(Row, 3);
        }
        //conditionDisable();
        return Row;
    }
    
    function row_Editable4Sheet2() {
        var rowDiableCount=0;    // counting in case GetRowEditablesetting is false
        with (sheetObjects[0]) {
            for (i=1; i <= LastRow(); i++) {
                if (GetCellValue(i,"oscar_flag")=="N") {
                    SetRowEditable(i,0);
                    rowDiableCount++;
                }
            }
            //RenderSheet(1);
        }
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, frmObj, sAction){
        with (frmObj) {
        }
        return true;
    }
    function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}