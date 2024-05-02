﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0257.js
*@FileTitle  :  Europe Customs EDI 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* developer's work*/
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // global variable
    var intervalId="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
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
	       		case "mode_type":
	       			if(formObject.mode_type[0].checked){
	       				formObject.pol_cd.className = "input1";
	       				formObject.pod_cd.className = "input";
					}else if(form.mode_type[1].checked){
						formObject.pol_cd.className = "input";
						formObject.pod_cd.className = "input1";
					} 
				break; 		            
            	case "btn_retrieve":
 					doActionIBSheet(sheetObjects[1],formObject,SEARCH08);
 					break;
            	case "btn_new":
            		doActionIBSheet(sheetObjects[1], formObject, IBCLEAR);
            		break; 
            	case "btn_DownExcel":
 					doActionIBSheet(sheetObjects[1], formObject, IBDOWNEXCEL);
 					
 					break; 
 				case "btn_transmit":
 					doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
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
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering combo Object at comboObjects list 
     * @param combo_obj
     * @return
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
    	var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	    initControl();
		
	}
    
    function initControl(){
    	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm("change", "obj_change", document.form);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
					 var HeadTitle="|flatFile";
					 var headCount=ComCountHeadTitle(HeadTitle);

					 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					 var headers = [ { Text:HeadTitle, Align:"Center"} ];
					 InitHeaders(headers, info);

					 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"flat_file",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					  
					 InitColumns(cols);

					 SetEditable(1);
					 SetSheetHeight(220);
					 
				}

                break;
                
            case 2:      //sheet2 init
                 with(sheetObj){

				var HeadTitle1 = "|Seq.|Sel.|B/L No|CNTR  No|Partial|Sent Time|Received Time|Cargo Type|Transhipment|POL|POD|B/POL|B/POD|DEL|SH|SH|SH|SH|SH|SH|SH|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|POFE|POFE ETA|ENS MRN|EXS MRN|Export MRN||BKG_NO|POL|POD|ERR_YN|LANE";
		        var HeadTitle2 = "|Seq.|Sel.|B/L No|CNTR  No|Partial|Sent Time|Received Time|Cargo Type|Transhipment|POL|POD|B/POL|B/POD|DEL|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str |EORI|POFE|POFE ETA|ENS MRN|EXS MRN|Export MRN||BKG_NO|POL|POD|ERR_YN|LANE";
					 var headCount=ComCountHeadTitle(HeadTitle1);
					 headCount=ComCountHeadTitle(HeadTitle1);

					 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );

					 var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
					 var headers = [ { Text:HeadTitle1, Align:"Center"},      
							   { Text:HeadTitle2, Align:"Center"} ];
					 InitHeaders(headers, info);

					 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"DummyCheck",Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sel",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1},
						 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_nos",    MultiLineText:1,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  , Wrap:1},
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_prt_flg",MultiLineText:1, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  , Wrap:1},
						 {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:1,   SaveName:"tran_status",MultiLineText:1, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"receive_status",MultiLineText:1, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cargo_type"  ,MultiLineText:1, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  , Wrap:1},
						 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"trns_mod_cd"  ,KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"b_pol_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"b_pod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_ad",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_ct",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_cn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_zip",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_str",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_eori",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_ad",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_ct",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_zip",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_str",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_eori",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_ad",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_ct",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_zip",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_str",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_eori",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pofe",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pofe_eta",    KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mrn",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"exs_mrn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"export_mrn",  MultiLineText:1, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dr_yn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"err_yn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 } ];
					  
					 InitColumns(cols);

					 SetEditable(1);
					 SetCountPosition(0);
					 SetSelectionMode(smSelectionRow);
		             SetSheetHeight(420);
		            // ShowSubSum([{StdCol:"pol_cd", SumCols:"dr_yn", Sort:true, ShowCumulate:false, CaptionCol:SaveNameCol("cntr_nos"), CaptionText:"POL : %col" }]);

				}


           break;
        		}
    }
    /**
     * handling of Sheet <br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
	    switch (sAction) {
	        case SEARCH08: // 
				ComSetFocus(formObj.f_cmd);
				if(!validateForm(sheetObj,formObj,sAction))return;
				formObj.f_cmd.value=SEARCH08;
				if(formObj.check_frob_search.checked) {
					formObj.check_frob_search.value="Y";
				}
				var sXml=sheetObj.GetSearchData("ESM_BKG_0257GS.do", FormQueryString(formObj));
				if (ComBkgErrMessage(sheetObj, sXml)) {
					formObj.vvd_nm.value=(ComGetEtcData(sXml,"vvd_nm") != undefined ? ComGetEtcData(sXml,"vvd_nm") : "") ;
					formObj.vvd_ld.value=(ComGetEtcData(sXml,"vvd_ld") != undefined ? ComGetEtcData(sXml,"vvd_ld") : "") ;
					formObj.vvd_call.value=(ComGetEtcData(sXml,"vvd_call") != undefined ? ComGetEtcData(sXml,"vvd_call") : "") ;
					formObj.eta.value=(ComGetEtcData(sXml,"eta") != undefined ? ComGetEtcData(sXml,"eta") : "") ;
					formObj.etd.value=(ComGetEtcData(sXml,"etd") != undefined ? ComGetEtcData(sXml,"etd") : "") ;
					sheetObjects[1].LoadSearchData(sXml);
				}
				sheetObjects[1].CheckAll("sel",0,1);
				formObj.p_ori_amd_cd[0].checked=true;
				break;
			case INIT: // searching receiver id combo
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchData("ESM_BKG_0257GS.do", FormQueryString(formObj));
				var receiver_uvi = ComGetEtcData(sXml, "receiver_uvi");
				var arr1 = receiver_uvi.split("_");
				formObj.receiver_id.value = arr1[0];
				if(formObj.mode_type[1].checked && formObj.pod_cd.value.substring(0, 2) == "GB") {
					formObj.uvi.readOnly=false;
					formObj.uvi.style.backgroundColor="";
					formObj.uvi.value = arr1[1];
				} else if(formObj.mode_type[0].checked && formObj.pol_cd.value.substring(0, 2) == "GB") {
					formObj.uvi.readOnly=false;
					formObj.uvi.style.backgroundColor="";
					formObj.uvi.value = arr1[1];
				} else {
					formObj.uvi.readOnly=true;
				}
				break;
			case IBDOWNEXCEL:
				if(sheetObjects[1].RowCount() > 0) {
					sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1,DownSum:1});
				}else{
					ComShowCodeMessage("COM132501");
				}
				break;
			case IBCLEAR: // 폼과 시트의 값 삭제
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.reset();
				formObj.vvd_cd.focus();
//				comboObjects[0].SetSelectCode("");
				formObj.uvi.value="";
				
				formObj.mode_type[1].checked;
				formObj.pol_cd.className = "input";
				formObj.pod_cd.className = "input1";				
				break;
			case IBSAVE: // creating and transmitting EDI FLAT FILE 
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
	            	return false;
	            }
	            ComOpenWait(true);
				var rowCnt=sheetObj.RowCount();
				for(var i=1; i<=rowCnt+1; i++) {
					
					if(sheetObj.GetCellValue(i, "sel") == 1) {
							sheetObj.SetRowStatus(i,"I");
					} else {
						sheetObj.SetRowStatus(i,"R");
					}
				}
				var sParam="";
				var sParamSheet=sheetObj.GetSaveString();
				if (sParamSheet != "") {
					sParam += "&" + sParamSheet;
				}
				// 전송한다.
				formObj.f_cmd.value=MULTI;

				if (document.form.mode_type[0].checked){
					formObj.search_pod_cd.value = formObj.pol_cd.value;
				}else{
					formObj.search_pod_cd.value = formObj.pod_cd.value;
				}
				
//				formObj.search_pod_cd.value=formObj.pod_cd.value;
				sParam += "&" + FormQueryString(formObj);
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0257GS.do", sParam)
 				//ComOpenWait(false);
				//formObj.output.value = ComGetEtcData(sXml, "flatFile");
				//sheetObj.LoadSaveXml(sXml);
				var key=ComGetEtcData(sXml, "KEY");
//				alert("key : " + key);
				intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				break;
        }
    }
    /**
     * searching BackEndJob result<br>
     * 
     * @param sheetObj
     * @param sKey
     */
    function doActionValidationResult(sheetObj, sKey) {
		var sXml=sheetObj.GetSearchData("ESM_BKG_0257GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		ComShowCodeMessage('BKG00101'); // 전송 성공 메시지
    		doActionIBSheet(sheetObjects[1],document.form,SEARCH08); // 전송 성공 후 재조회
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		ComShowMessage(ComResultMessage(sXml));
    	}
    }
    
	function baseValidation(sheetObj,formObj,sAction){
		if (!ComChkValid(formObj)) return false;
		var polVal=formObj.pol_cd.value;
		var podVal=formObj.pod_cd.value;
		
		if(podVal == "" && formObj.mode_type[1].checked) {
			ComShowCodeMessage("BKG00210");
			ComSetFocus(formObj.pod_cd);
			return false;
		} else if(polVal == "" && formObj.mode_type[0].checked) {
			ComShowCodeMessage("BKG00209");
			ComSetFocus(formObj.pol_cd);
			return false;
		}
		
//		if(podVal == "") {
//			ComShowCodeMessage("BKG00210");
//			ComSetFocus(formObj.pod_cd);
//			return false;
//		}
		
		if(formObj.receiver_id.value == "") {
			ComShowCodeMessage("BKG06084");
			return false;
		}
		
		// POL, POL Validation
		formObj.f_cmd.value=SEARCH06;
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0257GS.do", FormQueryString(formObj));
		var polResult=ComGetEtcData(sXml, "polResult");
		var podResult=ComGetEtcData(sXml, "podResult");
		if(polVal != "" && polResult == "") {
			ComShowCodeMessage('BKG06012', polVal);	// {?msg1} is invalid.
			ComSetFocus(formObj.pol_cd);
			return false;
		}
		if(podVal != "" && podResult == "") {
			ComShowCodeMessage('BKG06012', podVal);	// {?msg1} is invalid.
			ComSetFocus(formObj.pod_cd);
			return false;
		}
		return true;
	}
	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
    	case SEARCH08: { // Retrieve
    		//기본포멧체크
			//if (!ComChkValid(formObj)) return false;
    		sheetObjects[0].RemoveAll();
    		sheetObjects[1].RemoveAll();
			
			if ( ComIsNull(formObj.vvd_cd)) {
				ComShowCodeMessage('BKG00626','VVD');
				formObj.vvd_cd.focus();
				return false;	
			}else if ( formObj.mode_type[0].checked && ComIsNull(formObj.pol_cd)) {
				ComShowCodeMessage('BKG00626','POL');
				formObj.pol_cd.focus();
				return false;
			}else if ( formObj.mode_type[1].checked && ComIsNull(formObj.pod_cd)) {
				ComShowCodeMessage('BKG00626','POD');
				formObj.pod_cd.focus();
				return false;
			}
			break;
    	}
    	
	    	case SEARCH05: {
	    		return baseValidation(sheetObj,formObj,sAction);
	    		break;
	    	}
			case IBSAVE: {
				var baseValFlg=false;
	    		baseValFlg=baseValidation(sheetObj,formObj,sAction);
	    		if(!baseValFlg) return baseValFlg
	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189");
	    			return false;
	    	 		}
	    		var errYN="N";
	    		var arrRow=ComFindText(sheetObj, "sel", 1);
	    		var errorCnt=0;
	    		var errorBls="";
	    		var tempBl="";
	    		var ackBls ="";
	    		var ackCnt=0;
	    		var errBlArray=new Array();
				for (var i=0; i<arrRow.length; i++) {
					if(sheetObj.GetCellValue(arrRow[i], "err_yn") == "Y" || sheetObj.GetCellValue(arrRow[i], "cntr_nos") == ""){
						if(errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")] == undefined){
							errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")]=sheetObj.GetCellValue(arrRow[i], "bl_no");
							errorCnt++;
							if(errorCnt <= 10)
								errorBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
						}
					}
					if (tempBl== sheetObj.GetCellValue(arrRow[i], "bl_no")) continue;
						tempBl=sheetObj.GetCellValue(arrRow[i], "bl_no");
						
				}//end for
				if(errorCnt > 0){
					errorBls=errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
			    	ComShowCodeMessage("BKG01133",errorBls,"");
			    	return false;
			    }
				
//				if(document.form.pol_cd.value.substring(0,2)=="DE" || document.form.pod_cd.value.substring(0,2)=="DE"){
//					for(var i=2; i<=sheetObjects[1].RowCount()+1; i++){
//						if(sheetObjects[1].GetCellValue(i,"tran_status").substring(0,1)=="S" && sheetObjects[1].GetCellValue(i,"sel")=="1" && sheetObjects[1].GetCellValue(i,"receive_status").substring(0,1)=="N"){
//							ackCnt++;
//							if(ackCnt <= 5 ){
//								ackBls += sheetObjects[1].GetCellValue(i,"bl_no")+",";
//							}
//						}
//					}
//					if(ackCnt > 0 ){
//						ackBls=ackCnt > 5 ? ackBls+"..etc.":ackBls.substring(0,ackBls.length-1);
//						ComShowCodeMessage("BKG08332",ackBls," ");
//				    	return false;
//					}
//				}else{
//					for(var i=2; i<=sheetObjects[1].RowCount()+1; i++){
//						if(sheetObjects[1].GetCellValue(i,"tran_status").substring(0,1)=="S" && sheetObjects[1].GetCellValue(i,"sel")=="1" && sheetObjects[1].GetCellValue(i,"receive_status").substring(0,1)=="N"){
//							ackCnt++;
//							if(ackCnt <= 5 ){
//								ackBls += sheetObjects[1].GetCellValue(i,"bl_no")+",";
//							}
//						}
//					}//end for
//					//5개까지만 보여주고 그 다음부터는 ..etc POD가 DE가 아닌 경우에는 Not Received 상태이면 전송이 여부를 묻는 창이 나오게 만듦.
//				if(ackCnt > 0 && sheetObjects[1].GetCellValue(2,"pod_yd_cd").substring(0,2)!="DE" ){
//					ackBls=ackCnt > 5 ? ackBls+"..etc.":ackBls.substring(0,ackBls.length-1);
//					if(!ComShowConfirm(ComGetMsg("BKG08333",ackBls," ")) ){
//						return false;
//					}
//				}
//			}
//			var emptyBls = "";
//			var firstRow = "";
//			var rowCnt = "";
//				for(var i=2; i<sheetObjects[1].RowCount()+1; i++){ // IFTMCS의 경우 Empty 전송을 하지 않음
//					if(sheetObjects[1].GetCellValue(i,"cargo_type")=="EMPTY" && sheetObjects[1].GetCellValue(i,"sel")=="1"){
//						rowCnt++;
//						emptyBls += sheetObjects[1].GetCellValue(i,"bl_no")+",";
//						if(rowCnt==1){
//							firstRow = i; 
//						}
//					}
//				}
//				if(emptyBls != ""){
//					sheetObjects[1].SelectCell(firstRow,"cargo_type"); // emty 부킹을 전송하려고 하는 경우 해당 셀로 이동
//					ComShowCodeMessage("COM12114",emptyBls+". The B/L(s) is(are) empty reposition booking. IFTMCS cannot transmit empty booking.");
//					return false;
//				}
//			break;
			}
	    }
        return true;
    }
    
     /**
      * Sheet2 Search End Method
      * @param sheetObj
      * @param ErrMsg
      * @return
      */ 
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
         with (sheetObj) {
    		 if (document.form.mode_type[0].checked){
    			 // pod별로 그룹을 묶어 pod를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
    			 SetSumText(0,"SubSum","POD");
//    			 ShowSubSum("pod_cd", "dr_yn", 0, true, false, SaveNameCol("cntr_nos"));
    		 }else{
    			 // pol별로 그룹을 묶어 pol를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
    			 SetSumText(0,"SubSum","POL");
//   			  	 ShowSubSum("pol_cd", "dr_yn", 0, true, false, SaveNameCol("cntr_nos"));
    		 }
    		 
             var redColor="#FF0000";
             var blueColor="#0000FF";
             for(var i=HeaderRows(); i<= LastRow(); i++) {
            	 	SetColFontUnderline("bl_no",1);
                	SetColFontColor("bl_no",blueColor);
	                if (isError(GetCellValue(i,"sh_nm"))) SetCellFontColor(i,"sh_nm",redColor);
 	                if (isError(GetCellValue(i,"sh_ad")))SetCellFontColor(i,"sh_ad",redColor);
 	                if (isError(GetCellValue(i,"sh_ct"))) SetCellFontColor(i,"sh_ct",redColor);
 	                if (isError(GetCellValue(i,"sh_cn"))) SetCellFontColor(i,"sh_cn",redColor);
 	                if (isError(GetCellValue(i,"sh_zip"))) SetCellFontColor(i,"sh_zip",redColor);
 	                if (isError(GetCellValue(i,"sh_str"))) SetCellFontColor(i,"sh_str",redColor);
 	                if (isError(GetCellValue(i,"sh_eori"))) SetCellFontColor(i,"sh_eori",redColor);
 	                if (isError(GetCellValue(i,"cnee_nm"))) SetCellFontColor(i,"cnee_nm",redColor);
 	                if (isError(GetCellValue(i,"cnee_ad"))) SetCellFontColor(i,"cnee_ad",redColor);
 	                if (isError(GetCellValue(i,"cnee_ct"))) SetCellFontColor(i,"cnee_ct",redColor);
 	                if (isError(GetCellValue(i,"cnee_cn"))) SetCellFontColor(i,"cnee_cn",redColor);
 	                if (isError(GetCellValue(i,"cnee_zip"))) SetCellFontColor(i,"cnee_zip",redColor);
 	                if (isError(GetCellValue(i,"cnee_str"))) SetCellFontColor(i,"cnee_str",redColor);
 	                if (isError(GetCellValue(i,"cnee_eori"))) SetCellFontColor(i,"cnee_eori",redColor);
 	                if (isError(GetCellValue(i,"ntfy_nm"))) SetCellFontColor(i,"ntfy_nm",redColor);
 	                if (isError(GetCellValue(i,"ntfy_ad"))) SetCellFontColor(i,"ntfy_ad",redColor);
 	                if (isError(GetCellValue(i,"ntfy_ct"))) SetCellFontColor(i,"ntfy_ct",redColor);
 	                if (isError(GetCellValue(i,"ntfy_cn"))) SetCellFontColor(i,"ntfy_cn",redColor);
 	                if (isError(GetCellValue(i,"ntfy_zip"))) SetCellFontColor(i,"ntfy_zip",redColor);
 	                if (isError(GetCellValue(i,"ntfy_str"))) SetCellFontColor(i,"ntfy_str",redColor);
 	                if (isError(GetCellValue(i,"ntfy_eori"))) SetCellFontColor(i,"ntfy_eori",redColor);
             }
         }//end width
         pagedMaxCnt=sheetObj.LastRow();
     }
    
     /**
      * Booking Creation Error Check
      * @param String cellValue
      * return boolean
      */
     function isError(cellValue) {
    	 if(cellValue == "E") return true;
    	 return false;
     }
	/**
	 * B/L Inquiry
	 * @param sheetObj Sheet
	 * @param Row Row Index
	 * @param Col Col Index
	 */
	 function sheet2_OnDblClick(sheetObj, row, col) {
	        var colSaveName=sheetObj.ColSaveName(col);
	        switch(colSaveName) {
	        	case "bl_no" :
					ComBkgCall0079(sheetObj.GetCellValue(row, "bkg_no"));
		    	break;
	        } // end switch
	 }
    /* the end of developer's work */

function obj_change() {
	var formObj = document.form;
	var srcName=window.event.srcElement.getAttribute("name");
	if(formObj.mode_type[1].checked)
	{
		// Inbound
		if (srcName == "pod_cd" && formObj.pod_cd.value.length == 5 && formObj.vvd_cd.value.length == 9) {
			doActionIBSheet(sheetObjects[0],formObj,INIT);
		}
	}
	else
	{
		// Outbound
		if (srcName == "pol_cd" && formObj.pol_cd.value.length == 5 && formObj.vvd_cd.value.length == 9) {
			doActionIBSheet(sheetObjects[0],formObj,INIT);
		}
	}
}