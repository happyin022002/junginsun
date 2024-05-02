/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0171.js
*@FileTitle  : VGM EDI (Others)
*@author     : CLT
*@version    : 1.0
*@since      : 2016/06/13
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var iStep = 0;  //0:first, 1:reSearch

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
	    var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_retrieve":
            	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
            	break;
			case "btn_EDITransmission":
				  var iCheckRow=sheetObjects[0].FindCheckedRow("slct_flg");
				  if(iCheckRow.length==0){
					  ComShowCodeMessage("BKG00155");
				  }else{
					  var arrRow=iCheckRow.split("|");
					doActionIBSheet(sheetObjects[0],formObject,"btn_EDITransmission");	
				  }
			    break; 
			case "btn_Yard":
				 var param="?pgmNo=ESM_BKG_0096&bkg_no="+ComGetObjValue(formObject.bkg_no);
				 param+="&callSheetIdx=2";
				 ComOpenPopup("ESM_BKG_0096.do"+param, 600, 400, '','1,0,1,1,1', true);
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
        for(var i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
        	ComEndConfigSheet(sheetObjects[i]);
        }
		if(!opener) {
			opener=parent;
		}
        document.form.bkg_no.value = opener.form.bkg_no_list.value.substring(1,13);
        document.form.cntr_nos.value = opener.form.cntr_no_list.value;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        case 'sheet1':      //sheet1 init
            with(sheetObj){
                var HeadTitle1="|Sel.|EDI Kind|Code|Receiver(TP ID)|EDI Sender ID|USR ID|Last Sent Date\n(GDT)|Result|Result|||||";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slct_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"ntc_knd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ref_code",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"edi_receive_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"edi_snd_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sender",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"send_dt",              KeyField:0,   CalcLogic:"",   Format:"####-##-####:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"result",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Image",     Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"edi_his_btn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"bkg_ntc_snd_rslt_cd" },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"bkg_no" },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ntc_knd_cd" },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"sender_nm" },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"func_code" } ];
                
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetImageList(0,"img/btns_multisearch.gif");
                SetShowButtonImage(1);
                SetExtendLastCol(0);
                SetWaitTimeOut(30);
                SetSheetHeight(350);
            }
            break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
		case IBSEARCH:      //Retrieve
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESM_BKG_0171GS.do", FormQueryString(formObj) );
		    break;
		case "btn_EDITransmission":
			formObj.f_cmd.value=MULTI01;
        	var slt =  sheetObjects[0].GetSelectRow();
			formObj.slct_flg.value = sheetObjects[0].GetCellValue(slt,"slct_flg");
			formObj.ref_code.value = sheetObjects[0].GetCellValue(slt,"ref_code");
			formObj.edi_receive_id.value = sheetObjects[0].GetCellValue(slt,"edi_receive_id");
			formObj.ntc_knd_cd.value = sheetObjects[0].GetCellValue(slt,"ntc_knd_cd");
			formObj.edi_snd_id.value = sheetObjects[0].GetCellValue(slt,"edi_snd_id");
			var params=FormQueryString(formObj);
//			params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
 			sXml=sheetObj.GetSaveData("ESM_BKG_0171GS.do", params);
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowMessage(msgs['BKG00693']);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			} else {
				sheetObj.LoadSaveData(sXml);
			}
		break;
        }
    }
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        if ("edi_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.GetCellValue(Row,"result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		}
	}
 	function sheetMultiBtnClick(sheetObject, Row, Col) {
		var formObject=document.form;
 		var bkgNo;
 		var ntcKndCd;
 		var ntcViaCd;
 		bkgNo=ComGetObjValue(formObject.bkg_no);
        ntcKndCd=sheetObject.GetCellValue(Row,"ntc_knd_cd");
        switch(sheetObject.ColSaveName(Col)) {
            case "fax_his_btn":
                ntcViaCd="F";
                break;
            case "eml_his_btn":
                ntcViaCd="M";
                break;
            case "edi_his_btn":
                ntcViaCd="E";
                break;
        }
		ComOpenWindowCenter("ESM_BKG_1071.do?bkg_no="+bkgNo+"&ntc_knd_cd="+ntcKndCd+"&ntc_via_cd="+ntcViaCd, "ESM_BKG_1071", 800, 530, true);
 	}
    /**
     * save received value from Remark <br>
     */
    function callBack0384(rArray){
    	var formObj=document.form;
    	if(rArray != null){
		var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow=chkRowArr.split("|");
		if ( sheetObjects[0].CheckedRows("slct_flg") > 0 ) {
			for (var idx=0;idx<chkRow.length;idx++) {
				sheetObjects[0].SetCellValue(chkRow[idx], "remark",rArray[0][6]);
			}
		}
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
		switch(sAction) {
		
			}
        }
        return true;
    }
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
            for(i=1 ; i<=LastRow(); i++) {
                if (!ComIsNull(GetCellValue(i,"result"))) {
 					SetCellImage(i, "edi_his_btn",0);
                } else {
                    SetMergeCell(i,11,1,2);
                }
                if (ComIsNull(GetCellValue(i,"edi_receive_id"))) {
                	SetCellEditable(i,"slct_flg",0);
                }
                if (sheetObj.GetCellValue(i,"ntc_knd_cd").substr(1,1) == "M"){
                	SetCellEditable(i,"slct_flg",1);
                	SetCellEditable(i,"ref_code",1);
                	SetCellEditable(i,"edi_receive_id",1);
                	SetCellEditable(i,"edi_snd_id",1);
                }
            }
		}
	}
	function initRdConfig(rdObject){
	    var Rdviewer=rdObject ;
		Rdviewer.SetSheetHeight(0);
		Rdviewer.SetBackgroundColor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.AutoAdjust=0;
		Rdviewer.ZoomRatio=180; 
	}
	function rdOpen(rdObject, formObject, viewType){
		var sheetObj=sheetObjects[0];
		var Rdviewer=rdObject;
		var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow=chkRowArr.split("|");
        var remarkArr=sheetObj.GetCellValue(chkRow[0], "remark").split("\r\n");
		var remark="";
		for(var idx=0;idx<remarkArr.length-1;idx++){
			remark=remark + remarkArr[idx] + "(##)";
		}
		remark=remark + remarkArr[remarkArr.length-1];
		remark=encodeRemark(remark);
		var rdParam="";
		var rdUrl="";
		var rdFile="";
		var formType="";
        if ( sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "BK" ) {
        rdParam=" /rp " + "['"+formObject.bkg_no.value+"']["+formObject.usr_id.value+"]["+encodeRemark(sheetObj.GetCellValue(chkRow[0], "remark"))+"]";
			formObject.com_mrdBodyTitle.value="Booking Receipt Notice";
			rdUrl="apps/opus/esm/bkg/bookingconduct/generalbookingconduct/generalbookinglistsearch/report/";
			if ( formObject.receipt_type.value == "China" ) {
				rdFile="ESM_BKG_5005C.mrd";
//				rdParam=rdParam + "[][Y]";
			} else {
				rdFile="ESM_BKG_5005G.mrd";
//				rdParam=rdParam + "[][][Y]";
				rdParam=rdParam + "[][][Y][][][][]";
			}
			formObject.com_mrdPath.value=rdUrl+rdFile;
			formObject.com_mrdArguments.value=rdParam + " /riprnmargin /rwait";
        } else if ( sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "CN" ) {
			var strBkgNo=" bkg_no[( '" + formObject.bkg_no.value + "' )] ";
            var strRemark=" remark[" + encodeRemark(sheetObj.GetCellValue(chkRow[0], "remark")) + " ] ";
			var strIsEncode=" isEncode[Y] ";
			var strUsrId=" usr_id[" + formObject.usr_id.value + "] ";
			var strType="type[detail]";
			formObject.com_mrdBodyTitle.value="Empty Container Release Order";
			rdParam="/rv "+ strBkgNo + strRemark + strUsrId + strType + strIsEncode;
			rdUrl="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/emptyreleaseorder/report/";
			rdFile="ESM_BKG_0861.mrd";
			formObject.com_mrdPath.value=rdUrl+rdFile;
			formObject.com_mrdArguments.value=rdParam + " /riprnmargin /rwait";
        } else if ( sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "SN" ) {
			var strBkgNo=formObject.bkg_no.value;
			formObject.com_mrdBodyTitle.value="Surrender Notice";
			rdUrl="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/";
			rdFile="ESM_BKG_0866.mrd";
			rdParam="/rp ["+ strBkgNo + "] ["+formObject.signFlag.value+"]";
			formObject.com_mrdPath.value=rdUrl+rdFile;
			formObject.com_mrdArguments.value=rdParam + " /riprnmargin /rwait";
        } else if ( sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "HO" ) {
			var strBkgNo=formObject.bkg_no.value;
			formObject.com_mrdBodyTitle.value="Carrier's Haulage Notice";
			rdUrl="apps/opus/esm/bkg/bookingconduct/generalbookingconduct/transferorderissue/report/";
			rdFile="ESM_BKG_5021.mrd";
			rdParam="/rp ['"+ strBkgNo + "'] ['O']";
			formObject.com_mrdPath.value=rdUrl+rdFile;
			formObject.com_mrdArguments.value=rdParam + " /riprnmargin /rwait";
        } else if ( sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "HI" ) {
			var strBkgNo=formObject.bkg_no.value;
			formObject.com_mrdBodyTitle.value="Carrier's Haulage Notice";
			rdUrl="apps/opus/esm/bkg/bookingconduct/generalbookingconduct/transferorderissue/report/";
			rdFile="ESM_BKG_5021.mrd";
			rdParam="/rp ['"+ strBkgNo + "'] ['I']";
			formObject.com_mrdPath.value=rdUrl+rdFile;
			formObject.com_mrdArguments.value=rdParam + " /riprnmargin /rwait";
        } else if ( sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "BL" || sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "NN" ) {
			var strBkgNo=formObject.bkg_no.value;
			var sLevel="";	
			var comboValue=(sheetObj.GetComboInfo(chkRow[0], "frt_term","Code").split("|"))[sheetObj.GetComboInfo(chkRow[0], "frt_term","SelectedIndex")];
	        var sEsig = "";
	        var sCpyEsig = "";

	        if ("ALL"==comboValue) {
				sLevel="1";
			} else if ("C"==comboValue) {
				sLevel="5";
			} else if ("P"==comboValue) {
				sLevel="4";
			} else if ("N"==comboValue) {
				sLevel="6";
			} else if ("A"==comboValue) {
				sLevel="3";
			} else {
				sLevel="1";
			}
			rdUrl="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/";
	        if (sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "BL") {
	        	formType="7";	//Draft B/L 
//				rdFile="ESM_BKG_0109_OBL_A4.mrd";
	        	if (0==sheetObj.GetCellValue(chkRow[0], "por_cd").indexOf("US")) {
					rdFile="ESM_BKG_0109_OBL_LETTER.mrd";
				} else {
					rdFile="ESM_BKG_0109_OBL_A4.mrd";
				}
				sEsig = "";
				sCpyEsig = "";
			} else {
	        	formType="2";	//Non-Negotiable B/L 
				if (0==sheetObj.GetCellValue(chkRow[0], "por_cd").indexOf("US")) {
					rdFile="ESM_BKG_0109_OBL_LETTER.mrd";
				} else {
					rdFile="ESM_BKG_0109_OBL_A4.mrd";
				}
				sEsig = "";
				if(sheetObj.GetCellValue(chkRow[0], "bl_cpy_esig_flg") == "1"){
					sCpyEsig = "Y";
				}else if(sheetObj.GetCellValue(chkRow[0], "bl_cpy_esig_flg") == "0"){
					sCpyEsig = "N";
				}else{
					sCpyEsig = sheetObj.GetCellValue(chkRow[0], "bl_cpy_esig_flg");
				}
			}
	        
			rdParam="/rv form_bkgNo[( '" + strBkgNo + "') ]"
				  + " form_type["+formType+"]"
			      + " form_dataOnly[N]"
			      + " form_manifest[N]"
			      + " form_usrId[" +formObject.usr_id.value+"] "
			      + " form_hiddeData[N]"
			      + " form_level[("+sLevel+")]"
				  + " form_remark["+remark+"]"
				  + " form_Cntr[1]"
				  + " form_mainOnly[N]"
				  + " form_CorrNo[]"
				  + " form_his_cntr[BKG_CONTAINER]"
				  + " form_his_bkg[BKG_BOOKING]"
				  + " form_his_mkd[BKG_BL_MK_DESC]"
				  + " form_his_xpt[BKG_XPT_IMP_LIC]"
				  + " form_his_bl[BKG_BL_DOC]"
				  + " isEncode[Y]"
				  + " form_rqst_via_cd[]"
				  + " form_his_bl_mkd[BKG_BL_ISS]"
				  + " form_path[" + getFileDownPath() + "] "
				  + " form_esig[" + sEsig + "] "
				  + " form_cpy_esig[" + sCpyEsig + "] "
				  + " form_knt_flg[] "
				  + " form_count[] "
				  + " /rp []"
				  + " /riprnmargin";
			formObject.com_mrdPath.value=rdUrl+rdFile;
			formObject.com_mrdArguments.value=rdParam + " /rwait";
			formObject.com_mrdBodyTitle.value="Draft B/L Copies";
        } else if ( sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "WB" ) {
			var strBkgNo=formObject.bkg_no.value;
			var sLevel="";					 
			var comboValue=(sheetObj.GetComboInfo(chkRow[0], "frt_term","Code").split("|"))[sheetObj.GetComboInfo(chkRow[0], "frt_term","SelectedIndex")];
	        var sEsig = "";
	        var sCpyEsig = "";

	        if ("ALL"==comboValue) {
				sLevel="1";
			} else if ("C"==comboValue) {
				sLevel="5";
			} else if ("P"==comboValue) {
				sLevel="4";
			} else if ("N"==comboValue) {
				sLevel="6";
			} else if ("A"==comboValue) {
				sLevel="3";
			} else {
				sLevel="1";
			}
			rdUrl="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/";
			formType="5";	//Sea Waybill
			if(sheetObj.GetCellValue(chkRow[0], "bl_esig_flg") == "1"){
				sEsig="Y";
			}else if(sheetObj.GetCellValue(chkRow[0], "bl_esig_flg") == "0"){
				sEsig="N";
			}else {
				sEsig=sheetObj.GetCellValue(chkRow[0], "bl_esig_flg");
			}
			sCpyEsig = "";
			
			if (0==sheetObj.GetCellValue(chkRow[0], "por_cd").indexOf("US")) {
				rdFile="ESM_BKG_0109_OBL_LETTER.mrd";
			} else {
				rdFile="ESM_BKG_0109_OBL_A4.mrd";
			}
			rdParam="/rv form_bkgNo[( '" + strBkgNo + "') ]"
				  + "  form_type["+formType+"]"
			      + " form_dataOnly[N]"
			      + " form_manifest[N]"
			      + " form_usrId[" +formObject.usr_id.value+"] "
			      + " form_hiddeData[N]"
			      + " form_level[("+sLevel+")]"
				  + " form_remark["+remark+"]"
				  + " form_Cntr[1]"
				  + " form_mainOnly[N]"
				  + " form_CorrNo[]"
				  + " form_his_cntr[BKG_CONTAINER]"
				  + " form_his_bkg[BKG_BOOKING]"
				  + " form_his_mkd[BKG_BL_MK_DESC]"
				  + " form_his_xpt[BKG_XPT_IMP_LIC]"
				  + " form_his_bl[BKG_BL_DOC]"
				  + " form_rqst_via_cd[]"
				  + " form_his_bl_mkd[BKG_BL_ISS]"
				  + " form_path[" + getFileDownPath() + "] "
				  + " form_esig[" + sEsig + "] "
				  + " form_cpy_esig[" + sCpyEsig + "] "
				  + " form_knt_flg[] "
				  + " form_count[] "
				  + " /rp []"
				  + " /riprnmargin";
			formObject.com_mrdPath.value=rdUrl+rdFile;
			formObject.com_mrdArguments.value=rdParam + " /rwait";
			formObject.com_mrdBodyTitle.value="Draft B/L Copies";
			
		}
		formObject.com_mrdSaveDialogFileName.value=formObject.bkg_no.value;
		ComOpenRDPopup("width=900,height=800");
	}
	/*
	* sheet1 OnChange Event
	*/
	function sheet1_OnChange(sheetObj,Row, Col, Value) {
		with (sheetObj) {
			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
			if (arrRow && 0<arrRow.length) {
				for (var i=0; i<arrRow.length; i++) {
                    if (Row!=arrRow[i]) {
						SetCellValue(arrRow[i],"slct_flg",0,0);
					}
				}
			}
		}
	}
	/*
	* sheet1 OnMouseMove Event
	*/
	function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){
	    var mCol = sheetObj.MouseCol();
	    var mRow = sheetObj.MouseRow()
		if (sheetObj.ColSaveName(mCol)=="sender"){
		    sheetObj.SetToolTipText(mRow,mCol, sheetObj.GetCellValue(mRow,"sender_nm"));
		}
	}
	/*
	*Grid State Handling
	*/
	function gridState(sheetObj){
		var formObj=document.form;
		if (ComGetObjValue(formObj.docType)=="S"){
 			for(var iRow=1;iRow<=sheetObj.LastRow();iRow++){
                if (sheetObj.GetCellValue(iRow, "ntc_knd_cd") == "SN"){
					sheetObj.SetCellValue(iRow, "slct_flg",1);
			 	}else{
			 		sheetObj.SetRowEditable(iRow,0);
			 	}
			}
			ComBtnDisable("btn_EDITransmission");
			sheetObjects[1].SetEnable(0);
		}else if (ComGetObjValue(formObj.docType)=="W"){
 			for(var iRow=1;iRow<sheetObj.LastRow();iRow++){
                if (sheetObj.GetCellValue(iRow, "ntc_knd_cd") == "WB"){
					sheetObj.SetCellValue(iRow, "slct_flg",1);
				} else {
			 		sheetObj.SetRowEditable(iRow,0);
				}
			}
		}
	}

	//Check data for Booking Receipt Notice 
	function validateBkReceipt(row, sAction){
		
		var remark = encodeRemark(sheetObjects[0].GetCellValue(row, "remark").replace(/\r\n/g, "(##)"));
		if(sAction=="btn_EmailEdit"){
			if(remark.indexOf(encodeRemark("@#"), 0) != -1){
				ComShowCodeMessage("BKG03061","@#" + " in Remark(s)");
				return false;			
			}
		}
		
		if(remark.length > 3988){ //6 chrs may be added in the server logic and 6 chrs may be added in the report SQL.
			ComShowCodeMessage("BKG04012","Remark data", "4000");
			return false;
		}
		return true;
	}
