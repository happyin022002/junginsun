/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0471.js
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
var comboObjects = new Array(); //다중콤보박스를 위한 콤보박스 선언
var comboCnt=0;
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
	                
//	    			setComboData(sheetObject);
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
	            case "btn_back":
	            	history.back();
	                break;
                case "btn_save":
                	sheetObject.SetWaitImageVisible(1);
                    doActionIBSheet(sheetObject, frmObj, IBSAVE);
                    break; 
                case "btn_close":
                	ComClosePopup(); 
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
		for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
		}
        // CTM-COMMON
        setEventProcess();
        if (document.form.bkg_no.value!=undefined && document.form.bkg_no.value!="")
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        // focusing on page loading
        document.form.bkg_no.focus();
        
        setComboData(sheetObj);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
	              var HeadTitle="|| VSL SEQ | VSL TYPE | SLAN | VVD | POL | POD | Creation Date (s) | Update Date (s) ";
	             
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:11, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                           {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	  	                 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",             KeyField:1},
	                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:4 },
	                     {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"vvd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:9 },
	                     {Type:"Text",     	Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:7 },
	                     {Type:"Text",     Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:7  },
	                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:19 },
	                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:19 },
	                     {Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	               
	              InitColumns(cols);
	              
	              SetEditable(1);
	              SetCountPosition(0);
	//              SetSheetHeight(442);
	              resizeSheet();
             }


                break;
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
                    sheetObj.DoSearchFx("EES_CTM_0471GS.do", "f_cmd=" + SEARCH + "&bkg_no=" + frmObj.bkg_no.value);
                    ComOpenWait(false);
                }
                break;
            case IBSAVE:     
            	for(i=1; i<=sheetObj.RowCount(); i++) {
        			var vslSeq = sheetObj.GetCellValue(i, "vsl_seq");
        			var vslPrePstCd=sheetObj.GetCellValue(i, "vsl_pre_pst_cd");
        			var vvd = sheetObj.GetCellValue(i, "vvd");
        			var polCd = sheetObj.GetCellValue(i, "pol_cd");
        			var podCd = sheetObj.GetCellValue(i, "pod_cd");
        			
            		if (vslSeq == null || vslSeq == "") {
            			ComShowCodeMessage("CTM00000", "Vessel sequence");
                        sheetObj.SelectCell(i, "vsl_seq", true);
            			return;
            		} else if (vslPrePstCd == null || vslPrePstCd == "") {
            			ComShowCodeMessage("CTM00000", "Vessel type");
                        sheetObj.SelectCell(i, "vsl_pre_pst_cd", true);
            			return;
            		} else if (vvd == null || vvd == "") {
            			ComShowCodeMessage("CTM00000", "VVD");
                        sheetObj.SelectCell(i, "vvd", true);
            			return;
            		} else if (polCd == null || polCd == "") {
            			ComShowCodeMessage("CTM00000", "POL");
                        sheetObj.SelectCell(i, "pol_cd", true);
            			return;
            		} else if (podCd == null || podCd == "") {
            			ComShowCodeMessage("CTM00000", "POD");
                        sheetObj.SelectCell(i, "pod_cd", true);
            			return;
            		}
            		if (i < sheetObj.RowCount()){
                		for(j=i+1; j<=sheetObj.RowCount(); j++) {
                			var jvslSeq = sheetObj.GetCellValue(j, "vsl_seq");
                        	var jvslPrePstCd=sheetObj.GetCellValue(j, "vsl_pre_pst_cd");
                        	if ((vslSeq == jvslSeq || vslPrePstCd=="TRUNK") && vslPrePstCd == jvslPrePstCd) {
                        		if (sheetObj.GetRowStatus(j) != "D" && sheetObj.GetRowStatus(i) != "D") {
                                    ComShowCodeMessage("CTM99999","There is duplicated data.");
                                    sheetObj.SelectCell(j, "vsl_seq", true);
                                    return;
                        		} 
                        	}
                		}
            		}
            	}
                if (sheetObj.IsDataModified()) {
                    sheetObj.SetWaitImageVisible(0);

                    sheetObj.RemoveEtcData();
                    sheetObj.DoSave("EES_CTM_0471GS.do", "f_cmd=" + MULTI + "&bkg_no=" + frmObj.bkg_no.value);
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
        if (SaveName == "slan_cd") {
        	var vsl_pre_pst_cd=GetCellValue(Row, "vsl_pre_pst_cd");
        	if (vsl_pre_pst_cd=="TRUNK") {
	        	var nowValue=GetCellText(Row, Col);
	            var originValue=CellSearchValue(Row, Col);
	            // comparing EventDate in case Event Date changed
	            if (nowValue != originValue) {
	            	SetCellValue(Row, "flg", "Y");
	            } else {
	            	SetCellValue(Row, "flg", "N");
	            }
        	} else {
        		SetCellValue(Row, "flg", "N");
        	}
        } else if (SaveName == "vvd") {            
        	var vsl_pre_pst_cd=GetCellValue(Row, "vsl_pre_pst_cd");
        	if (vsl_pre_pst_cd=="TRUNK") {
	        	var nowValue=GetCellText(Row, Col);
	            var originValue=CellSearchValue(Row, Col);
	            // comparing EventDate in case Event Date changed
	            if (nowValue != originValue) {
	            	SetCellValue(Row, "flg", "Y");
	            } else {
	            	SetCellValue(Row, "flg", "N");
	            }
        	} else {
        		SetCellValue(Row, "flg", "N");
        	}
        } else if (SaveName == "pol_cd") {
            queryString="f_cmd=" + SEARCH24 + "&p_yard1=" + GetCellText(Row, Col);
            xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
            rtnValue=ComGetEtcData(xml, "rtnValue");
            //alert("BOOKING rtnValue : " + rtnValue);
            if (rtnValue == "") {
                ComShowCodeMessage("CTM10001");
                sheetObj.SelectCell(Row, Col, true);
            }
            
        	if (Row = 1) {
	        	var nowValue=GetCellText(Row, Col).substr(1,5);
	            var originValue=CellSearchValue(Row, Col).substr(1,5);
	            
	            if (nowValue != originValue) {
	            	SetCellValue(Row, "flg", "Y");
	            } else {
	            	SetCellValue(Row, "flg", "N");
	            }
        	} else {
        		SetCellValue(Row, "flg", "N");
        	}
        } else if (SaveName == "pod_cd") {
            queryString="f_cmd=" + SEARCH24 + "&p_yard1=" + GetCellText(Row, Col);
            xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
            rtnValue=ComGetEtcData(xml, "rtnValue");
            //alert("BOOKING rtnValue : " + rtnValue);
            if (rtnValue == "") {
                ComShowCodeMessage("CTM10001");
                sheetObj.SelectCell(Row, Col, true);
            }
            
        	if (Row = sheetObj.LastRow()) {
	        	var nowValue=GetCellText(Row, Col).substr(1,5);
	            var originValue=CellSearchValue(Row, Col).substr(1,5);
	            
	            if (nowValue != originValue) {
	            	SetCellValue(Row, "flg", "Y");
	            } else {
	            	SetCellValue(Row, "flg", "N");
	            }
        	} else {
        		SetCellValue(Row, "flg", "N");
        	}
        }
    }
    
    /**
     * handling OnChange event in Sheet2
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var rtnXml="";
        var rtnValue="";
        var rtnName="";
        with (sheetObj) {
            switch (ColSaveName(Col)) {
                case "slan_cd":
                	var orgSlan = GetCellValue(Row,Col);
                    strQuery="f_cmd=" + SEARCH25 + "&slanCd=" + orgSlan;
                    rtnXml=GetSearchData("CTMCommonGS.do", strQuery);
                    rtnValue=ComGetEtcData(rtnXml, "rtnValue");
                    
                    if(rtnValue!=null && rtnValue!=""){
                    	 SetCellValue(Row,Col, rtnValue.trim()); 
                         var vvd=GetCellValue(Row,Col).substr(1,4);
                         
                         if(orgSlan != GetCellValue(Row,Col)) {
                        	 alert( orgSlan+" ==> " + GetCellValue(Row,Col)  + "  Service Lane is changed.");
                        	 return;
                         }
                    }else{
                    	ComShowCodeMessage("CTM99999", "Service Lane does not Exists");
                    }
                    
                	var vsl_pre_pst_cd=GetCellValue(Row, "vsl_pre_pst_cd");
                	if (vsl_pre_pst_cd=="TRUNK") {
	                    var nowValue=GetCellText(Row, Col);
	                    var originValue=CellSearchValue(Row, Col);
	                    // comparing EventDate in case Event Date changed
	                    if (nowValue != originValue) {
	                    	SetCellValue(Row, "flg", "Y");
	                    } else {
	                    	SetCellValue(Row, "flg", "N");
	                    }
                	} else {
                		SetCellValue(Row, "flg", "N");
                	}
                    break;
                case "vsl_pre_pst_cd" :
                	var vslPrePstCd=GetCellValue(Row, "vsl_pre_pst_cd");
                	for (i=1; i<Row; i++) {
                    	var ivslPrePstCd=GetCellValue(i, "vsl_pre_pst_cd");
                    	if (vslPrePstCd == ivslPrePstCd && vslPrePstCd == "TRUNK") {
                            SetCellValue(Row, "vsl_pre_pst_cd","");
                            ComShowCodeMessage("CTM99999","There is another Trunk VVD.");
                            SelectCell(Row, Col, true);
                    	}
                    }
                	break;
                case "vvd":
                    if(GetCellValue(Row,Col).length == 7){
                    	var orgvvd = GetCellValue(Row,Col);
                        strQuery="f_cmd=" + SEARCH06 + "&p_vvd=" + orgvvd;
                        rtnXml=GetSearchData("EES_CTM_0406GS.do", strQuery);
                        rtnValue=ComGetEtcData(rtnXml, "rtnStr");
                        
                        if(rtnValue!=null && rtnValue!="" && rtnValue.length==9){
                        	 SetCellValue(Row,Col, rtnValue.trim()); 
                        	 alert( orgvvd+" ==> " + GetCellValue(Row,Col)  + "  VVD is changed.");

                        	 return;
                        }else{
                        	ComShowCodeMessage("CTM20073"); // VVD Code is Not Exists
                        }
                	}
                    
                	var vsl_pre_pst_cd=GetCellValue(Row, "vsl_pre_pst_cd");
                	if (vsl_pre_pst_cd=="TRUNK") {
	                    var nowValue=GetCellText(Row, Col);
	                    var originValue=CellSearchValue(Row, Col);
	                    // comparing EventDate in case Event Date changed
	                    if (nowValue != originValue) {
	                    	SetCellValue(Row, "flg", "Y");
	                    } else {
	                    	SetCellValue(Row, "flg", "N");
	                    }
                	} else {
                		SetCellValue(Row, "flg", "N");
                	}
                    break;
                case "pol_cd":
    	            queryString="f_cmd=" + SEARCH24 + "&p_yard1=" + GetCellText(Row, Col);
    	            xml=GetSearchData("CTMCommonGS.do", queryString);
    	            rtnValue=ComGetEtcData(xml, "rtnValue");
    	            //alert("BOOKING rtnValue : " + rtnValue);
    	            if (rtnValue == "") {
    	                ComShowCodeMessage("CTM10001");
    	                SelectCell(Row, Col, true);
    	            }
    	            
                	if (Row = 1) {
	                    var nowValue=GetCellText(Row, Col).substr(1,5);
	                    var originValue=CellSearchValue(Row, Col).substr(1,5);
	    	            
	                    if (nowValue != originValue) {
	                    	SetCellValue(Row, "flg", "Y");
	                    } else {
	                    	SetCellValue(Row, "flg", "N");
	                    }
                	} else {
                		SetCellValue(Row, "flg", "N");
                	}
                    break;
                case "pod_cd":
    	            queryString="f_cmd=" + SEARCH24 + "&p_yard1=" + GetCellText(Row, Col);
    	            xml=GetSearchData("CTMCommonGS.do", queryString);
    	            rtnValue=ComGetEtcData(xml, "rtnValue");
    	            //alert("BOOKING rtnValue : " + rtnValue);
    	            if (rtnValue == "") {
    	                ComShowCodeMessage("CTM10001");
    	                SelectCell(Row, Col, true);
    	            }
    	            
                	if (Row = LastRow()) {
	                    var nowValue=GetCellText(Row, Col).substr(1,5);
	                    var originValue=CellSearchValue(Row, Col).substr(1,5);

	                    if (nowValue != originValue) {
	                    	SetCellValue(Row, "flg", "Y");
	                    } else {
	                    	SetCellValue(Row, "flg", "N");
	                    }
                	} else {
                		SetCellValue(Row, "flg", "N");
                	}
                    break;
            }
        }
    }
    
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    
	function setComboData(sheetObj) {
		with (sheetObj) {
			var vslPrePstCd ="|PRE|TRUNK|POST";
			
			for(i=1; i<=RowCount(); i++) {
				var vslPrePstCd=GetCellValue(i,"vsl_pre_pst_cd");
			}
			SetColProperty("vsl_pre_pst_cd", {ComboText:vslPrePstCd, ComboCode:vslPrePstCd});
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
	        sheetObj.SetCellEditable(Row, "vsl_seq",1);
	        sheetObj.SetCellEditable(Row, "vsl_pre_pst_cd",1);
	        sheetObj.SetCellEditable(Row, "slan_cd",1);
	        sheetObj.SetCellEditable(Row, "vvd",1);
	        sheetObj.SetCellEditable(Row, "pol_cd",1);
	        sheetObj.SetCellEditable(Row, "pod_cd",1);
	        sheetObj.SetCellEditable(Row, "cre_dt",0);
	        sheetObj.SetCellEditable(Row, "upd_dt",0);
	        
            // initializing date 
            strTime=new Date();
            y=strTime.getFullYear();
            m=strTime.getMonth() + 1;
            d=strTime.getDate();
            if (m < 10) m="0" + m;
            if (d < 10) d="0" + d;
  
            digital=new Date();
            hours=digital.getHours();
            minutes=digital.getMinutes();
            seconds=digital.getSeconds();
            if (minutes < 10) minutes="0" + minutes;
            if (hours < 10)   hours="0" + hours;
            if (seconds < 10)   seconds="0" + seconds;

            sheetObject.SetCellValue(Row, "cre_dt", y + "-" + m + "-" + d + " " + hours + ":" + minutes + ":" + seconds);
            sheetObject.SetCellValue(Row, "upd_dt", y + "-" + m + "-" + d + " " + hours + ":" + minutes + ":" + seconds);
            sheetObject.SetCellValue(Row, "flg", "N");
            
            sheetObj.SelectCell(Row, 3);
        }
        //conditionDisable();
        return Row;
    }
    
    function row_Editable4Sheet2() {
        var rowDiableCount=0;    // counting in case GetRowEditablesetting is false
        with (sheetObjects[0]) {
            for (i=1; i <= LastRow(); i++) {
                if (document.form.bkg_no.value.length==12) {
                    SetRowEditable(i,0);
                    rowDiableCount++;
                    ComBtnDisable("btn_add");
                    ComBtnDisable("btn_del");
                    ComBtnDisable("btn_save");
                } else {
        	        SetCellEditable(i, "vsl_seq",0);
        	        SetCellEditable(i, "vsl_pre_pst_cd",0);
        	        SetCellEditable(i, "slan_cd",1);
        	        SetCellEditable(i, "vvd",1);
        	        SetCellEditable(i, "pol_cd",1);
        	        SetCellEditable(i, "pod_cd",1);
        	        SetCellEditable(i, "cre_dt",0);
        	        SetCellEditable(i, "upd_dt",0);
        	        
                    SetCellValue(i, "flg", "N");
                    SetCellValue(i, "ibflag", "");
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