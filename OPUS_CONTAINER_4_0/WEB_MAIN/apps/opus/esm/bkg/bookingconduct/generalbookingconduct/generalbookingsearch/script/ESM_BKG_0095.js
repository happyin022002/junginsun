/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0095.js
*@FileTitle  : Booking Fax & EDI
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var sheetObjects = new Array();
var sheetCnt = 0;

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
			case "btn_RemarkTemplate":
				if(!validateForm(sheetObjects[0],formObject,"btn_RemarkTemplate")) {
					return false;
				}
		        ComOpenPopup("ESM_BKG_0384POP.do?pgmNo=ESM_BKG_0384", 760, 440, "callBack0384","1,0", true);
			    break;
			case "btn_Remark":
				if(!validateForm(sheetObjects[0],formObject,"btn_Remark")) {
					return false;
				}
				var arrRow=ComFindText(sheetObjects[0],"slct_flg", 1);
				var rmk="";
				if (arrRow !="" && 0<arrRow.length) {
//                    rmk=(1==arrRow.length)? sheetObjects[0].GetCellValue(arrRow[0],"remark") : "";
					var remark="";
					if(sheetObjects[0].GetCellValue(arrRow[0],"remark").length==0 && sheetObjects[0].GetCellValue(arrRow[0],"diff_rmk").length==0){
						remark = "";
					}else if(sheetObjects[0].GetCellValue(arrRow[0],"remark").length==0){
						remark = sheetObjects[0].GetCellValue(arrRow[0],"diff_rmk");
					}else if(sheetObjects[0].GetCellValue(arrRow[0],"diff_rmk").length==0){
						remark = sheetObjects[0].GetCellValue(arrRow[0],"remark");
					}else{
						remark = sheetObjects[0].GetCellValue(arrRow[0],"remark") +"\n" +sheetObjects[0].GetCellValue(arrRow[0],"diff_rmk");
					}
					remark = replaceRemark(remark);		//last character '\n'
					rmk=(1==arrRow.length) ? remark : "";
				}
				formObject.elements["inter_rmk"].value=rmk;
				ComOpenWindowCenter("ESM_BKG_0913.do?pgmNo=ESM_BKG_0913&screen_id=0095", "ESM_BKG_0913", 600, 345, true);

			    break;
			case "btn_Preview":
				if(!validateForm(sheetObjects[0],formObject,"btn_Preview")) {
					return false;
				}
				rdOpen("preview");
			    break; 
			case "btn_FaxSend":
				if(!validateForm(sheetObjects[0],formObject,"btn_FaxSend")) {
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,"btn_FaxSend");
			    break; 
			case "btn_Email":
				if(!validateForm(sheetObjects[0],formObject,"btn_Email")) {
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,"btn_Email");
			    break; 
			case "btn_EmailEdit":
				if(!validateForm(sheetObjects[0],formObject,"btn_EmailEdit")) {
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,"btn_EmailEdit");
			    break;
			case "btn_EDITransmission":
				  var iCheckRow=sheetObjects[1].FindCheckedRow("slct_flg");
				  if(iCheckRow.length==0){
					  ComShowCodeMessage("BKG00155");
				  }else{
					  var arrRow=iCheckRow.split("|");
					  var arrRow2=ComFindText(sheetObjects[1],"slct_flg2", 1);
					  var popFlag=false;
					  var popRcvId="";
					  if (arrRow != "" && 0<arrRow.length) {
						  for (var idx=0; idx<arrRow.length; idx++) {
                            if (sheetObjects[1].GetCellValue(arrRow[idx],"ntc_knd_cd")=="EX"){
								popFlag=true;
                                popRcvId=sheetObjects[1].GetCellValue(arrRow[idx],"edi_receive_id");
								break;
							}
						  }
					  }
					  if (arrRow2 && 0<arrRow2.length) {
						  for (var idx=0; idx<arrRow2.length; idx++) {
						      sheetObjects[1].SetCellValue(arrRow2[idx],"func_code","9",0);
						  }
					  }
					  if (popFlag){
						  var param="?pgmNo=ESM_BKG_0904&bkg_no="+ComGetObjValue(formObject.bkg_no);
						  param+="&pol_cd="+ComGetObjValue(formObject.pol_cd);
						  param+="&pgmNo=ESM_BKG_0904";
						  param+="&rcv_Id="+popRcvId;
						  ComOpenPopup("ESM_BKG_0904.do"+param, 600, 420, '','1,0,1,1,1', true);
					  }else{
						doActionIBSheet(sheetObjects[1],formObject,"btn_EDITransmission");	
					  }
				  }
			    break; 
			case "btn_Yard":
				 var param="?pgmNo=ESM_BKG_0096&bkg_no="+ComGetObjValue(formObject.bkg_no);
				 param+="&callSheetIdx=2";
				 ComOpenPopup("ESM_BKG_0096.do"+param, 600, 400, '','1,0,1,1,1', true);
			    break; 
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],document.form,"research");
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
            		var HeadTitle1="| |Document Kind|Fax|Fax|Fax|Fax|Fax|Fax|Freight|Freight|Freight|E-mail|E-mail|E-mail|E-mail|E-mail|E-mail|Signed|Signed Copy|||||||||bkg_no|YD_EML";
            		var HeadTitle2="| |Document Kind|Fax No.|Fax No.|Sender|Send Date|Result|Result| | | |E-mail Address|E-mail Address|Sender|Send Date|Result|Result|Signed|Signed Copy|||||||||bkg_no|YD_EML";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                                 { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slct_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"ntc_knd_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"fax_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"fax_no_btn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fax_sender",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"fax_send_dt",      KeyField:0,   CalcLogic:"",   Format:"####-##-####:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fax_send_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"fax_his_btn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"frt_term",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:"|AllCharge|Collect|Prepaid|NoCharge|Arranged", ComboCode:"|ALL|C|P|N|A" },
                                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"frt_clt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"display_hidden",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"eml",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                                 {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"eml_btn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eml_sender",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eml_send_dt",      KeyField:0,   CalcLogic:"",   Format:"####-##-####:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eml_send_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Image",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_his_btn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_esig_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
                                 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_cpy_esig_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",falseValue:"N"},
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"new_flg" },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ntc_knd_cd" },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"remark" },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"diff_rmk" },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"enable" },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"fax_sender_nm" },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"eml_sender_nm" },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"por_cd" },
                                 {Type:"Text",      Hidden:1, Width:100,    Align:"Left",    ColMerge:0,   SaveName:"bkg_no" },
                                 {Type:"Text",      Hidden:1, Width:100,    Align:"Left",    ColMerge:0,   SaveName:"yd_eml" }];
                    
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetImageList(0,"img/btns_plus.gif");
                    SetImageList(1,"img/btns_minus.gif");
                    SetImageList(2,"img/btns_multisearch.gif");
                    SetCountPosition(0);
                    SetDataLinkMouse("fax_no_btn", 1);
                    SetDataLinkMouse("eml_btn", 1);
                    SetDataLinkMouse("fax_his_btn", 1);
                    SetDataLinkMouse("eml_his_btn", 1);
                    SetWaitTimeOut(30);
                    SetExtendLastCol(0);
                    SetSheetHeight(ComGetSheetHeight(sheetObj, 8));

                }


                break;
            case 'sheet2':      //sheet2 init
                with(sheetObj){
                    var HeadTitle1="|Sel.|EDI Kind|EDI Kind|Code|Code|Receiver(TP ID)|Group ID/Name|Group ID/Name|Sender|Last Sent Date|Result|Result|||||";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slct_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ntc_knd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"slct_flg2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ref_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"ref_code",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"edi_receive_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"group_edi_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:105,  Align:"Left",    ColMerge:1,   SaveName:"group_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"sender",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"send_dt",              KeyField:0,   CalcLogic:"",   Format:"####-##-####:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"result",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Image",     Hidden:0, Width:16,   Align:"Center",  ColMerge:1,   SaveName:"edi_his_btn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_cd" },
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
                    SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
                }
                break;
            case "sheet3"://0096의 sheet
                with(sheetObj){
                    var HeadTitle1="|TP/SZ|Q'ty|P/Up CY|Return CY";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"op_cntr_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"full_rtn_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 } ];
                    
                    InitColumns(cols);
                    
                    SetVisible(0);
                }
				break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
		case IBSEARCH:      //Retrieve
			var sXml=formObj.sXml.value;
        	var arrXml=sXml.split("|$$|");
        	for(var i=0; i < arrXml.length; i++){ 
        		sheetObjects[i].LoadSearchData(arrXml[i]);
        	}
		    break;
		case "research":
    		formObj.f_cmd.value=SEARCH;
    		var params = FormQueryString(formObj);
    		params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true, true, 1), "sheet1_");
     		var sXml=sheetObj.GetSearchData("ESM_BKG_0095GS.do", params);
    		var arrXml=sXml.split("|$$|");
    		for(var i=0; i < arrXml.length; i++){ 
    			sheetObjects[i].LoadSearchData(arrXml[i]);
    		}
    		break;

		case "btn_FaxSend":
			formObj.f_cmd.value=MULTI01;
			var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow=chkRowArr.split("|");

			for(var i = 0 ; i<chkRow.length; i++){
				var remarkArr=sheetObjects[0].GetCellValue(chkRow[i], "remark").split("\r\n");
				var remark="";
				for(var idx=0;idx<remarkArr.length-1;idx++){
					remark=remark + remarkArr[idx] + "(##)";
				}
				remark=remark + remarkArr[remarkArr.length-1];
				remark=encodeRemark(remark);
				sheetObjects[0].SetCellValue(chkRow[i], "remark",remark);
			}
            
			var sXml=formObj.sXml.value;
			formObj.sXml.value="";
			var params=FormQueryString(formObj);
			formObj.sXml.value=sXml;
			params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
 			sXml=sheetObj.GetSaveData("ESM_BKG_0095GS.do", params);
			if (ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowMessage(msgs['BKG00496']);
				doActionIBSheet(sheetObjects[0],document.form,"research");
			} else {
				sheetObj.LoadSaveData(sXml);
			}
		break;
		case "btn_Email":
			formObj.f_cmd.value=MULTI02;
			var chkRowArr=sheetObjects[0].FindCheckedRow("slct_flg");
			var chkRow=chkRowArr.split("|");
			for(var i = 0 ; i<chkRow.length; i++){
				var remarkArr=sheetObjects[0].GetCellValue(chkRow[i], "remark").split("\r\n");
				var remark="";
				for(var idx=0;idx<remarkArr.length-1;idx++){
					remark=remark + remarkArr[idx] + "(##)";
				}
				remark=remark + remarkArr[remarkArr.length-1];
				remark=encodeRemark(remark);
				sheetObjects[0].SetCellValue(chkRow[i], "remark",remark);
			}
			var sXml=formObj.sXml.value;
			formObj.sXml.value="";
			var params=FormQueryString(formObj);
			formObj.sXml.value=sXml;
			params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
 			sXml=sheetObj.GetSaveData("ESM_BKG_0095GS.do", params);
			if (ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowMessage(msgs['BKG00497']);
				ComSetObjValue(formObj.edt_ntc_knd_cd   ,"");
				ComSetObjValue(formObj.edt_bkg_no_list  ,"");
				ComSetObjValue(formObj.edt_to_eml       ,"");
				ComSetObjValue(formObj.edt_cc_eml       ,"");
				ComSetObjValue(formObj.edt_from_eml     ,"");
				ComSetObjValue(formObj.edt_subject      ,"");
				ComSetObjValue(formObj.edt_contents     ,"");
				doActionIBSheet(sheetObjects[0],document.form,"research");
			} else {
				sheetObj.LoadSaveData(sXml);
			}
		break;
		case "btn_EmailEdit":
			var arrRow=ComFindText(sheetObjects[0], "slct_flg", 1);
			var bkg_no="";
			var ntc_knd_cd="";
			var edt_to_eml="";
			if (arrRow && 1==arrRow.length) {
                bkg_no=sheetObjects[0].GetCellValue(arrRow[0],"bkg_no");
                ntc_knd_cd=sheetObjects[0].GetCellValue(arrRow[0],"ntc_knd_cd");
                edt_to_eml=sheetObjects[0].GetCellValue(arrRow[0],"eml");
				ComOpenWindowCenter("ESM_BKG_1096.do?ui_id=ESM_BKG_0095&ntc_knd_cd="+ntc_knd_cd+"&bkg_no_list="+bkg_no+"&edt_to_eml="+edt_to_eml, "ESM_BKG_1096", 700, 670, false);
			}
		break;
		case "btn_EDITransmission":
			formObj.f_cmd.value=MULTI03;
			var sXml=formObj.sXml.value;
			formObj.sXml.value="";
			var params=FormQueryString(formObj);
			formObj.sXml.value=sXml;
			params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(false, true, 1), "sheet2_");
 			sXml=sheetObj.GetSaveData("ESM_BKG_0095GS.do", params);
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowMessage(msgs['BKG00693']);
				doActionIBSheet(sheetObjects[0],document.form,"research");
			} else {
				sheetObj.LoadSaveData(sXml);
			}
		break;
        }
    }
    
	/**
	* Popup Click
	*/
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	//Popup->Image 이후 OnPopupClick을 OnClick으로
    	if (sheetObj.GetCellProperty(Row, Col, "Type")!="Image") return;
    	
		var formObject=document.form;
		var param="";
		if (sheetObj.ColSaveName(Col) == "fax_no_btn" || sheetObj.ColSaveName(Col) == "eml_btn") {
            if ( sheetObj.GetCellValue(Row, "new_flg") == "Y" ) {
				sheetObj.SetRowHidden(Row,1);//2.Row Hidden
                sheetObj.SetRowStatus(Row,"D");//3.GetRowStatus=D
			} else {
				var iRow = sheetObj.DataInsert();
				sheetObj.SetRowStatus(iRow,"R");
                sheetObj.SetCellValue(iRow, "ntc_knd_nm",sheetObj.GetCellValue(Row, "ntc_knd_nm"));
                sheetObj.SetCellValue(iRow, "fax_sender",sheetObj.GetCellValue(Row, "fax_sender"));
                sheetObj.SetCellValue(iRow, "frt_term",sheetObj.GetCellValue(Row, "frt_term"));
                sheetObj.SetCellValue(iRow, "frt_clt_flg",sheetObj.GetCellValue(Row, "frt_clt_flg"));
                sheetObj.SetCellValue(iRow, "display_hidden",sheetObj.GetCellValue(Row, "display_hidden"));
                sheetObj.SetCellValue(iRow, "ntc_knd_cd",sheetObj.GetCellValue(Row, "ntc_knd_cd"));
                sheetObj.SetCellValue(iRow, "remark",sheetObj.GetCellValue(Row, "remark"));
				sheetObj.SetCellValue(iRow, "fax_no","");
				sheetObj.SetCellValue(iRow, "eml","");
				sheetObj.SetCellValue(iRow, "fax_no_btn","");
				sheetObj.SetCellValue(iRow, "eml_btn","");
				sheetObj.SetCellValue(iRow, "new_flg","Y");
				sheetObj.SetCellValue(iRow, "fax_send_result","");
				sheetObj.SetCellValue(iRow, "fax_send_dt","");
				sheetObj.SetCellValue(iRow, "eml_send_result","");
				sheetObj.SetCellValue(iRow, "eml_send_dt","");
				sheetObj.SetCellValue(iRow, "slct_flg", 0, 0);
				sheetObj.SetCellImage(iRow,"fax_no_btn", 1);
				sheetObj.SetCellImage(iRow,"eml_btn", 1);
				sheetObj.SetCellImage(iRow,"fax_his_btn", 2);
				sheetObj.SetCellImage(iRow,"eml_his_btn", 2);
			}
        } else if ("fax_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.GetCellValue(Row,"fax_send_result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
        } else if ("eml_his_btn"==sheetObj.ColSaveName(Col) && ""!=sheetObj.GetCellValue(Row,"eml_send_result")) {
	 		sheetMultiBtnClick(sheetObj, Row, Col);
		}
	}
    function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
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
		case "btn_Preview":
			if (sheetObj.RowCount()== 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sAction == "btn_Preview") {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
			}
			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
			if (arrRow != ""  && 0<arrRow.length) {
				for (var i=0; i < arrRow.length; i++) {					
					//Check remark value for Booking Receipt Notice
					if(sheetObj.GetCellValue(arrRow[i], "ntc_knd_cd")=="BK"){
						if(!validateBkReceipt(arrRow[i], sAction)) return false;
					}
				}
			}
			break;
		case "btn_Remark":
			if (sheetObj.RowCount()== 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sAction == "btn_Preview") {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
			}
			break;
		 case "btn_RemarkTemplate":
			if (sheetObj.RowCount()== 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sAction == "btn_Preview") {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
			}
			break;
		case "btn_FaxSend":
			
			
			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
			if(arrRow == ""){
				ComShowCodeMessage("BKG00155");
				return false;
			}
			if (arrRow != "" && 0<arrRow.length) {
				for (var i=0; i < arrRow.length; i++) {
					var fax=sheetObj.GetCellValue(arrRow[i],"fax_no");
					if(""==fax){
						ComShowCodeMessage("BKG00365");
						return false;
					}
					//Check remark value for Booking Receipt Notice
					if(sheetObj.GetCellValue(arrRow[i], "ntc_knd_cd")=="BK"){
						if(!validateBkReceipt(arrRow[i], sAction)) return false;
					}
				}
			}
			
			
//			if (sheetObj.RowCount()== 0) {
//				ComShowMessage(msgs['BKG00155']);
//				return false;
//			}
//			if (sheetObj.CheckedRows("slct_flg") == 0) {
//				ComShowMessage(msgs['BKG00155']);
//				return false;
//			}
			break;
		case "btn_Email":
			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
			if(arrRow == ""){
				ComShowCodeMessage("BKG00155");
				return false;
			}
			if (arrRow != ""  && 0<arrRow.length) {
				for (var i=0; i < arrRow.length; i++) {
					var email=sheetObj.GetCellValue(arrRow[i],"eml");
					if(""==email || !ComIsEmailAddr(email)){
						ComShowCodeMessage("BKG00366");
						return false;
					}					
					//Check remark value for Booking Receipt Notice
					if(sheetObj.GetCellValue(arrRow[i], "ntc_knd_cd")=="BK"){
						if(!validateBkReceipt(arrRow[i], sAction)) return false;
					}
				}
			}
			
//			E-mail Address is missing or not correct format 
		case "btn_EmailEdit":
			if (sheetObj.RowCount()== 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}

			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
			if (arrRow != ""  && 0<arrRow.length) {
				for (var i=0; i < arrRow.length; i++) {					
					//Check remark value for Booking Receipt Notice
					if(sheetObj.GetCellValue(arrRow[i], "ntc_knd_cd")=="BK"){
						if(!validateBkReceipt(arrRow[i], sAction)) return false;
					}
				}
			}
			
			
			break;
		}
        }
        return true;
    }
 	// Search End Event
 	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
 		var formObj=document.form;
 		with(sheetObj)
 		{
 			SetColBackColor("RFQTY","#CCFFFD");
            for(var i=HeaderRows() ; i<=LastRow(); i++) {
                if ("Failed"==GetCellValue(i,"fax_send_result")) {
 					SetCellFontUnderline(i,"fax_send_result",1);
                } else if ("Failed"==GetCellValue(i,"eml_send_result")) {
 					SetCellFontUnderline(i,"eml_send_result",1);
				}
                if (""==GetCellValue(i,"fax_send_result")) {
				    SetMergeCell(i,7,1,2);
				}
                if (""==GetCellValue(i,"eml_send_result")) {
                    SetMergeCell(i,16,1,2);
                }

                if (GetCellValue(i, "ntc_knd_cd") == "BL" || 
                    GetCellValue(i, "ntc_knd_cd") == "WB" || 
                    GetCellValue(i, "ntc_knd_cd") == "NN"){
                	
    				SetCellEditable(i,"frt_term",1);
    				SetCellEditable(i,"frt_clt_flg",1);
    				
                    if (""==GetCellValue(i,"frt_term")) {
    					SetCellValue(i,"frt_term","",0);
    				}
    			}
                if (GetCellValue(i, "enable") == "N"){
    				SetRowEditable(i,0);
    			} else {
    				if (""!=GetCellValue(i,"fax_send_result")) SetCellImage(i, "fax_his_btn", 2);
                    if (""!=GetCellValue(i,"eml_send_result")) SetCellImage(i, "eml_his_btn", 2);
                    SetCellImage(i, "fax_no_btn", 0);
                    SetCellImage(i, "eml_btn", 0);
                    
                    //Draft B/L(BL), N/N Copy(NN), Waybill(WB) -- signed, signed copy
                    if(GetCellValue(i,"ntc_knd_cd")=="NN"){//form_type=2
                    	SetCellEditable(i,"bl_esig_flg",0);
                    	SetCellEditable(i,"bl_cpy_esig_flg",1);
                    }else if(GetCellValue(i,"ntc_knd_cd")=="WB"){//form_type=5
                    	SetCellEditable(i,"bl_esig_flg",1);
                    	SetCellEditable(i,"bl_cpy_esig_flg",0);
                    }else{
                    	SetCellEditable(i,"bl_esig_flg",0);
                    	SetCellEditable(i,"bl_cpy_esig_flg",0);
                    }
    			}
    			
    			//초기로드시에만 아래 코드 실행. 재조회시에는 호출하지 않음
                if (formObj.f_cmd.value==""){
                    if("Draft B/L"==GetCellValue(i, "ntc_knd_nm")
                        || "N/N Copy"==GetCellValue(i, "ntc_knd_nm")
                        || "Waybill"==GetCellValue(i, "ntc_knd_nm")){
//    					if(0==GetComboInfo(i,"frt_term", "SelectedIndex")){
//    						SetCellText(i, "frt_term" ,"All Charge");
//    					}
                    	if(formObj.bl_prn_chg_tp_cd.value=="1"){
                    		SetCellValue(i,"frt_term","ALL",0);
                    	}else if(formObj.bl_prn_chg_tp_cd.value=="5"){
                    		SetCellValue(i,"frt_term","C",0);
                    	}else if(formObj.bl_prn_chg_tp_cd.value=="4"){
                    		SetCellValue(i,"frt_term","P",0);
                    	}else if(formObj.bl_prn_chg_tp_cd.value=="6"){
                    		SetCellValue(i,"frt_term","N",0);
                    	}else if(formObj.bl_prn_chg_tp_cd.value=="3"){
                    		SetCellValue(i,"frt_term","A",0);
                    	}
    				}
    			}
                
                if(GetCellValue(i,"ntc_knd_nm") == 'Empty Release Order' && (GetCellValue(i,"eml") != GetCellValue(i,"yd_eml"))){
                	SetCellBackColor(i, 'eml', '#FFFF00');
                }
            }
		}
		//초기로드시에만 아래 코드 실행. 재조회시에는 호출하지 않음
		gridState(sheetObj);
	}
	// Search End Event
	function sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
            for(i=1 ; i<=LastRow(); i++) {
                if ("EX"==GetCellValue(i,"ntc_knd_cd") || "IM"==GetCellValue(i,"ntc_knd_cd") || "PS"==GetCellValue(i,"ntc_knd_cd")) {
            		SetCellEditable(i,"slct_flg",1);
            	}
                if ("BL"!=GetCellValue(i,"ntc_knd_cd")) {
            		SetCellEditable(i,"slct_flg2",0);
            	}
                if (!ComIsNull(GetCellValue(i,"result"))) {
 					SetCellImage(i, "edi_his_btn",0);
                } else {
                    SetMergeCell(i,11,1,2);
                }
                if (ComIsNull(GetCellValue(i,"edi_receive_id"))) {
                	SetCellEditable(i,"slct_flg",0);
                	SetCellEditable(i,"slct_flg2",0);
                }
            }
		}
	}
	
	function rdOpen(viewType){
		var formObject = document.form;
		var sheetObj = sheetObjects[0];
		var chkRowArr = sheetObjects[0].FindCheckedRow("slct_flg");
		var chkRow = chkRowArr.split("|");
        var remarkArr = sheetObj.GetCellValue(chkRow[0], "remark").split("\r\n");
		var remark = "";
		for(var idx=0; idx<remarkArr.length-1; idx++){
			remark = remark + remarkArr[idx] + "(##)";
		}
		remark = remark + remarkArr[remarkArr.length-1];
		remark = encodeRemark(remark);
		var rdParam = "";
		var rdUrl = "";
		var rdFile = "";
		var formType = "";
        if ( sheetObj.GetCellValue(chkRow[0], "ntc_knd_cd") == "BK" ) {
        rdParam=" /rp " + "['"+formObject.bkg_no.value+"']["+formObject.usr_id.value+"]["+encodeRemark(sheetObj.GetCellValue(chkRow[0], "remark"))+"]";
			formObject.com_mrdBodyTitle.value="Booking Receipt Notice";
			rdUrl="apps/opus/esm/bkg/bookingconduct/generalbookingconduct/generalbookinglistsearch/report/";
			if ( formObject.receipt_type.value == "China" ) {
				rdFile="ESM_BKG_5005C.mrd";
			} else {
				var opener = window.dialogArguments;
				if (!opener) opener = parent;
				
				if(opener.document.form.bkg_por_cd.value.substring(0,2) == 'US'){
					rdFile='ESM_BKG_5005G_LETTER.mrd';
				}else{
					rdFile="ESM_BKG_5005G.mrd";
				}
				
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
	        	formType = "7";	//Draft B/L 
	        	if (0==sheetObj.GetCellValue(chkRow[0], "por_cd").indexOf("US")) {
					rdFile="ESM_BKG_0109_OBL_LETTER.mrd";
				} else {
					rdFile="ESM_BKG_0109_OBL_A4.mrd";
				}
				sEsig = "";
				sCpyEsig = "";
			} else {
	        	formType = "2";	//Non-Negotiable B/L 
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
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		with (sheetObj) { 
		    switch(ColSaveName(Col)) {
		        case "slct_flg":
                    var chkNtcKndCd=GetCellValue(Row,"ntc_knd_cd");
        			var arrRow=ComFindText(sheetObj, "slct_flg", 1);
        			if (arrRow && 0<arrRow.length) {
        				for (var i=0; i<arrRow.length; i++) {
                            if (chkNtcKndCd!=GetCellValue(arrRow[i],"ntc_knd_cd")) {
        						SetCellValue(arrRow[i],"slct_flg",0,0);
        					}
        				}
        			}
		            break;
		        case "fax_no":
		            SetCellValue(Row,Col,Value.replace(/[^\d-]/g,""),0);
		            break;
		    }
		}
	}
	/*
	* sheet2 OnChange Event
	*/
	function sheet2_OnChange(sheetObj,Row, Col, Value) {
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
	    var mRow = sheetObj.MouseRow();
		if (sheetObj.ColSaveName(mCol)=="fax_sender"){
		    sheetObj.SetToolTipText(mRow,mCol, sheetObj.GetCellValue(mRow,"fax_sender_nm"));
		}else if (sheetObj.ColSaveName(mCol)=="eml_sender"){
		    sheetObj.SetToolTipText(mRow,mCol, sheetObj.GetCellValue(mRow,"eml_sender_nm"));
		}
	}
	/*
	* sheet2 OnMouseMove Event
	*/
	function sheet2_OnMouseMove(sheetObj,Button, Shift, X, Y){
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
	/*
	* remark popup(0913)
	*/
    function setRemark(remark) {
		var arrRow=ComFindText(sheetObjects[0], "slct_flg", 1);
		if (arrRow && 0<arrRow.length) {
			for (var i=0; i<arrRow.length; i++) {
				sheetObjects[0].SetCellValue(arrRow[i],"remark",remark,0);
			}
		}
    }
	//remark encoding
	function encodeRemark(remark) {
		return encodeURIComponent(remark).replace(/'/g, "%27");
	}
	
	//remark 
	function replaceRemark(str){
		var re_str = str.replace(/(\r\n|\n|\r)/g,'\n');
		
		if(re_str.indexOf("\n", re_str.length - "\n".length) != -1){	//last character '\n'
			re_str = re_str.substring(0,re_str.length - "\n".length); 
		}
		return re_str;
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
