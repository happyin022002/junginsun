/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7021_02.js
 *@FileTitle : Cost Table Interface - IHC(Barge/Rail/Truck) Tab
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.04
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 *2013.02.27 전윤주 creation date 컬럼에 upd_dt를 보여주고 있어 에러 수정    
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7021_02() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rsltCostIf = "";

document.onclick = processButtonClick;

function processButtonClick() {
	var form = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var prefix = "sheet3_";
		switch (srcName) {
		case "btn_new":		
			doActionIBSheet(sheetObjects[0],document.form,IBRESET);
			break;
		case "btn_retrieve":		
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
		case "btn_costIf":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_ctryPopup":
			selectCountry();
			break;
		case "btn_opn_trf":	
			if (sheetObjects[0].RowCount == "0"){
                ComShowCodeMessage('PRI04006');
                return;
            }
			if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"ihc_cost_trf_no") == ""){
                ComShowCodeMessage('PRI07025');       
                return;
            }
 			
 			if(document.form.menu_rhq_cd.value == "HAMRU"){
 				var pgmNo = "ESM_PRI_7101";
 				var pgmUrl = "/hanjin/ESM_PRI_7101.do";
 			}else if(document.form.menu_rhq_cd.value == "SHARC"){
 				var pgmNo = "ESM_PRI_7201";
 				var pgmUrl = "/hanjin/ESM_PRI_7201.do";
 			}else if(document.form.menu_rhq_cd.value == "SINRS"){
 				var pgmNo = "ESM_PRI_7301";
 				var pgmUrl = "/hanjin/ESM_PRI_7301.do";
 			}else if(document.form.menu_rhq_cd.value == "NYCRA"){
 				var pgmNo = "ESM_PRI_7031";
 				var pgmUrl = "/hanjin/ESM_PRI_7031.do";
 			}			
    		var params = "&in_svc_scp_cd="    	+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"svc_scp_cd")
    		               + "&in_cnt_cd="         +	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"cnt_cd")
    		               + "&in_rhq_cd="			+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"rhq_cd")
    		               + "&in_org_dest_tp_cd="  +  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"org_dest_tp_cd");
			var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
 			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);  
			break;		
		case "btn_copy_scope":
			doActionIBSheet(sheetObjects[0], document.form, MULTI02);
			break;
		case "btn_down_excel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			break;
		}
	} catch (e) {

	}
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
	if(document.form.menu_rhq_cd.value != ""){
		comboObjects[2].Code = document.form.menu_rhq_cd.value;
	}
	// loading 시 In bound 선택하도록 셋팅
	comboObjects[0].Code = 'D' ;
	initControl();
	parent.loadTabPage();
	document.form.cntCd.focus(); 
}

/**
 * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     initControl()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 공백진
 * @version 2012.04.17
 */    
  function initControl() {
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
//     axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
//     axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
//     axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
//     axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
//     axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);
//     axon_event.addListenerForm('click', 'obj_click', document.form);   
     axon_event.addListenerForm('change', 'obj_change', document.form);
  }    

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet3":
		with (sheetObj) {
			style.height = 365;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = true;
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "||Sel.|Scope|Country|Country|Cost Tariff|Cost Tariff|Cost Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|ORG_DEST_TP_CD|RHQ_CD";
			var HeadTitle2 = "||Sel.|Scope|Code|Description|No.|Confirmed Date|Count|No.|AMD No.|Creation Date|Status|Interfaced\nCost Tariff No|ORG_DEST_TP_CD|RHQ_CD";
			
			var prefix = "sheet3_";
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);   
			InitHeadMode(true, true, true, true, false, false);
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter,	true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 		30, 	daCenter,	true, prefix + "fic_prop_sts_cd");
			InitDataProperty(0, cnt++, dtCheckBox, 		40, 	daCenter, 	true, prefix + "chk");
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "svc_scp_cd", 		false, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, prefix + "cnt_cd", 			false, "", dfNone, 0, false, false, 50);
			InitDataProperty(0, cnt++, dtData, 			130, 	daLeft, 	true, prefix + "cnt_nm", 			false, "", dfNone, 0, false, false, 50);
			InitDataProperty(0, cnt++, dtData, 			80,		daCenter, 	true, prefix + "cost_trf_no", 		false, "", dfNone, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	true, prefix + "eff_fm_dt", 		false, "", dfUserFormat, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			50, 	daRight, 	true, prefix + "row_no", 			false, "", dfInteger, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 			100,	daCenter, 	true, prefix + "ihc_trf_no", 		false, "", dfUserFormat, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, prefix + "amdt_seq", 			false, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 			90, 	daCenter, 	true, prefix + "cre_dt", 			false, "", dfUserFormat, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, prefix + "fic_prop_sts_cd_nm",false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "ihc_cost_trf_no",	false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, prefix + "org_dest_tp_cd",	false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, prefix + "rhq_cd",	false, "", dfNone, 0, false, false, 1);
			
			sheetObj.InitUserFormat(0, prefix + "eff_fm_dt", "####-##-##", "-")
			sheetObj.InitUserFormat(0, prefix + 'cre_dt', "####-##-##", "-")
			sheetObj.InitUserFormat(0, prefix + 'ihc_trf_no', "###-#-##-####", "-")
		}
		break;
	}
}

function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "svcScpCd":
		with (comboObj) {
			DropHeight = 260;
			MultiSelect = false;
			MaxSelect = 1;
			UseAutoComplete = true;
			MaxLength = 3;
			IMEMode = 0;
			ValidChar(2, 0);
			SetColWidth("50|300");			
		}
		break;
		
	case "org_dest_tp_cd" :	
        var i = 0;
        with (comboObj) {
			DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
			MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
			MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
			UseAutoComplete = true;  
            InsertItem(i++, "In bound", "D");
			InsertItem(i++, "Out bound", "O");
        }
        break;  
		
	case "rhq_cd" :	
        var i = 0;
        with (comboObj) {
			DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
			MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
			MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
			UseAutoComplete = true;  
            InsertItem(i++, "HAMRU", "HAMRU");
            InsertItem(i++, "NYCRA", "NYCRA");
            InsertItem(i++, "SHARC", "SHARC");
            InsertItem(i++, "SINRS", "SINRS");
        }
        break;  
	}
}

/**
 * Action 이벤트
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
//		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
//			ComOpenWait(true);
//		}
		var sheetID = sheetObj.id;
		switch (sheetID) {
		case "sheet3":
			var prefix = "sheet3_";
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
			
			case IBSEARCH:
				formObj.f_cmd.value 	= SEARCHLIST;
				ComOpenWait(true); //->waiting->start
				sheetObj.DoSearch("ESM_PRI_7021_02GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.CheckAll(prefix + 'chk') = 0;
				var headerCnt = sheetObj.HeaderRows;			
				for ( var i = 0; i < sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i + headerCnt, prefix + 'fic_prop_sts_cd') == 'I') {
						sheetObj.RowEditable(i + headerCnt) = false;
					} else {
						sheetObj.RowEditable(i + headerCnt) = true;
					}
				}
				ComOpenWait(false); //->waiting->start
				break;
			case IBSAVE:
				if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
				if (!ComShowCodeConfirm('PRI00358')) {
					    return false;
				}
				
				if(rsltCostIf != "") {
					if(rsltCostIf.lastIndexOf(",") == rsltCostIf.length -1) {
						rsltCostIf = rsltCostIf.substring(0, rsltCostIf.length -1);
					}
					
					if(!ComShowCodeConfirm('PRI07011', rsltCostIf)) {
						return false;	
					}
				}

				formObj.f_cmd.value = MULTI;
				sheetObj.WaitImageVisible = false;
				var sParam = FormQueryString(formObj);
				sParam += "&" + ComGetPrefixParam(prefix);
		 		sParam += "&" + sheetObj.GetSaveString(false, true);
				var sXml = sheetObj.GetSaveXml("ESM_PRI_7021_02GS.do", sParam);
				var save_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        		ComOpenWait(false); 
		     	if(save_result != "F" ){
		     		ComShowCodeMessage('PRI07017');
		     		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		     	} else {
		     		ComShowMessage(ComGetEtcData(sXml, "Exception"));
		     	}  
				break;				
				
			case IBRESET:
				comboObjects[0].Index = 0;
				formObj.reset();
				sheetObj.CheckAll(prefix + 'chk') = 0;
				sheetObj.RemoveAll();
				formObj.cntCd.focus();
				break;		
				
			case MULTI02:
				if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
				
				var copy_cnt_cd = "";
		        var checkedRows = sheetObj.FindCheckedRow(prefix + 'chk'); 
		        var arrRow = checkedRows.split("|");
		        for (idx=0; idx < arrRow.length-1 ; idx++) {
		        	var  cnt_cd = sheetObj.CellValue(arrRow[idx], prefix + 'cnt_cd');
		        	copy_cnt_cd += cnt_cd;
		        	if( idx < arrRow.length-2){
		        		copy_cnt_cd +=",";
		        	}
		        }
		        
                var sParam = "&org_dest_tp_cd=" + comboObjects[0].Code 
                			   + "&rhq_cd="  		  + comboObjects[2].Code
                			   + "&cnt_cd="			  + copy_cnt_cd ;
                var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7006.do?"+ sParam,	730, 600, '', "1,0,1,1,1,1,1", true);      
	            if (rtnVal == true) {            	
	            	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	            }	
				break;	
				
			case IBDOWNEXCEL :
				sheetObj.Down2Excel(-1, true, true);
				break;
				
			}
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}
}

function validateForm(sheetObj, formObj, sAction) {			
	var formObj = document.form;
	 var prefix = "sheet3_";
	 
    switch (sAction) {
    case IBSAVE:       
        if(!sheetObj.IsDataModified){
            ComShowCodeMessage('PRI07010'); 
            return false;
        }
        
        rsltCostIf = "";
        var checkedRows = sheetObj.FindCheckedRow(prefix + 'chk'); 
        var arrRow = checkedRows.split("|");
        for (idx=0; idx < arrRow.length-1; idx++) {
        	var  cost_trf_no = sheetObj.CellValue(arrRow[idx], prefix + 'cost_trf_no');
        	var  ihc_cost_trf_no = sheetObj.CellValue(arrRow[idx], prefix + 'ihc_cost_trf_no');
        	var  cnt_cd = sheetObj.CellValue(arrRow[idx], prefix + 'cnt_cd');
        	if(ihc_cost_trf_no != '') {
        		if(cost_trf_no == ihc_cost_trf_no) {
        			rsltCostIf += cnt_cd + ",";
        		}
        	}
        }
        
        break;
        
    case MULTI02:    
    	// checked row validation - 1) no check
        var checkedRows = sheetObj.FindCheckedRow(prefix + 'chk');    
        var arrRow = checkedRows.split("|");
        if( checkedRows == ""){
            ComShowCodeMessage('PRI04006'); 
            return false;
        }
        // 2) multi rows check
        for (idx=0; idx < arrRow.length-1; idx++) {
        	var  check_svc_scp_cd = sheetObj.CellValue(arrRow[idx], prefix + 'svc_scp_cd');
        	for(i=idx+1; i < arrRow.length-1; i++) {
        		if(check_svc_scp_cd != sheetObj.CellValue(arrRow[i], prefix + 'svc_scp_cd')){
                	ComShowCodeMessage('PRI07031','IHC');  
                	return false;
        		}
        	}
        	 // 3) if user select non interfaced
        	if(sheetObj.CellValue(arrRow[idx], prefix + 'ihc_trf_no') == ""){ 
    			ComShowCodeMessage('PRI07026');  
    			return false;
        	}
        }
        break;
        
    }
    return true;
}  

function svcScpCd_OnChange(comboObj, code, text) {
	var formObj = document.form;
		formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
}

function selectCountry(){
	var parameter = FormQueryString(document.form);
	ComOpenPopup("/hanjin/ESM_PRI_7027.do?" + parameter,565, 400, 'getCountry', "0,1,1,1,1", true);
}

function getCountry(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;
	if ( aryPopupData.length > 0 ) {
		var cntCdVal = "";
		for(var i =0; i < aryPopupData.length; i++) {
			cntCdVal += aryPopupData[i][3];
			if( i < aryPopupData.length-1) {
				cntCdVal += ",";
			}
		}
		formObj.cntCd.value = cntCdVal;
		formObj.cntCd.fireEvent("onchange")	
	}
}

function sheet3_OnSearchEnd(sheetObj, errMsg) {
	var prefix = "sheet3_";
	for(var i = sheetObj.HeaderRows, n = sheetObj.RowCount + sheetObj.HeaderRows; i < n; i++) {
		var cost_trf_no = sheetObj.CellValue(i, prefix + 'cost_trf_no');
		var ihc_cost_trf_no = sheetObj.CellValue(i, prefix + 'ihc_cost_trf_no');
		if(cost_trf_no != ihc_cost_trf_no) {
			sheetObj.CellFont("FontColor", i, prefix + 'cost_trf_no', i, prefix + 'cost_trf_no') = sheetObj.RgbColor(255,0,0);
			sheetObj.CellFont("FontColor", i, prefix + 'ihc_cost_trf_no', i, prefix + 'ihc_cost_trf_no') = sheetObj.RgbColor(255,0,0);
		}
	}
}

	/**
	 * 
	 * @return 
	 */
	function load_check_sheet(){
		var prefix = "sheet3_";
		return ComPriSheet2Xml(sheetObjects[0],"",prefix + "chk","1");
	}
	
	/**
	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    tariff_cd_OnBlur(comboObj);
	 * </pre>
	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
	 * @return 없음
	 * @author 서미진
	 * @version 2012.10.25
	 */   	
//	function svcScpCd_OnBlur(comboObj) {
//		var formObj = document.form;	
//		var code = comboObjects[0].Code;
//		if (code != null && code != "") {
//			formObj.f_cmd.value = SEARCH27;
//			formObj.svc_scp_cd.value = code;
//			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//		    var arrData  = ComPriXml2Array(sXml, "cd");   
//		    comboObjects[1].Enable =  true;
//		    if(arrData.length == 1){
//		    	comboObjects[1].Code = arrData ;
//		    	comboObjects[1].Enable =  false;
//		    }else {
//			comboObjects[1].Index = 0 ; 
//			comboObjects[1].Enable =  true;
//		    }
//		}
//	}
	
 function DoPaste(){
		event.returnValue=false;
		var a = window.clipboardData.getData('Text');
		var b = replaceAll(a,'\r\n', ',');
		document.form.cntCd.value=b;
	}
 
 function replaceAll(inputString, targetString, replacement)
 {
	  var v_ret = null;
	  var v_regExp = new RegExp(targetString, "g");
	  v_ret = inputString.replace(v_regExp, replacement);
	  
	  return v_ret;
 }
	
    /**
     * OnChange event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function obj_change () {
    	var srcValue = event.srcElement.getAttribute("value");
        switch (event.srcElement.name) {
            case "cntCd":         
        		var formObj = document.form;
        		formObj.svc_scp_nm.value = "";
        		formObj.f_cmd.value = SEARCH25;
        		formObj.cd.value = comboObjects[2].Code;  // RHQ_CD
        		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
        		formObj.etc2.value = document.form.cntCd.value;	//	CNT_CD
        		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
        		ComPriXml2ComboItem(sXml, formObj.svcScpCd, "cd", "cd|nm");
        	    formObj.svcScpCd.focus(); 	  
        	    break; 
        }
    }   
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 서미진
	 * @version 2010.11.01
	 */
	function org_dest_tp_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		formObj.svc_scp_nm.value = "";
		formObj.f_cmd.value = SEARCH25;
		formObj.cd.value = comboObjects[2].Code;     // RHQ_CD
		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
		if(formObj.cntCd.value != ""){
			formObj.etc2.value = formObj.cntCd.value;	//	CNT_CD
		}else{
			formObj.etc2.value = "";
		}
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		ComPriXml2ComboItem(sXml, formObj.svcScpCd, "cd", "cd|nm");    
	    formObj.cntCd.focus(); 	
	}
	
	/**
     * row double click 으로 open creation pop-up open <br>
     */
	function sheet3_OnDblClick(sheetObj,Row,Col){
		var prefix = "sheet3_";
		if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"ihc_cost_trf_no") == ""){
            ComShowCodeMessage('PRI07025');       
            return;
        }
			
		if(document.form.menu_rhq_cd.value == "HAMRU"){
			var pgmNo = "ESM_PRI_7101";
			var pgmUrl = "/hanjin/ESM_PRI_7101.do";
		}else if(document.form.menu_rhq_cd.value == "SHARC"){
			var pgmNo = "ESM_PRI_7201";
			var pgmUrl = "/hanjin/ESM_PRI_7201.do";
		}else if(document.form.menu_rhq_cd.value == "SINRS"){
			var pgmNo = "ESM_PRI_7301";
			var pgmUrl = "/hanjin/ESM_PRI_7301.do";
		}else if(document.form.menu_rhq_cd.value == "NYCRA"){
			var pgmNo = "ESM_PRI_7031";
			var pgmUrl = "/hanjin/ESM_PRI_7031.do";
		}			
		var params = "&in_svc_scp_cd="    	+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"svc_scp_cd")
		               + "&in_cnt_cd="         +	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"cnt_cd")
		               + "&in_rhq_cd="			+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"rhq_cd")
		               + "&in_org_dest_tp_cd="  +  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"org_dest_tp_cd");
		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
		var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);  
	}