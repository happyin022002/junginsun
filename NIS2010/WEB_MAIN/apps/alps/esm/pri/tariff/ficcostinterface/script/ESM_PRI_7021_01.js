/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7021_01.js
 *@FileTitle : Cost Table Interface - Add-on(Ocean Feeder) Tab
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.04
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================
* History                                      
* 2012.10.30 서미진 [CHM-201220395] Add-on management T/F Project             
* 2013.02.27 전윤주 creation date 컬럼에 upd_dt를 보여주고 있어 에러 수정                                                         
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7021_01() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.setComboObject = setComboObject;	
	this.validateForm = validateForm;
}

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

document.onclick = processButtonClick;

function processButtonClick() {
	var form = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var prefix = "sheet2_";
		
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
		case "btn_opn_trf":
            if (sheetObjects[0].RowCount == "0"){
                ComShowCodeMessage('PRI04006');
                return;
            }
			if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"add_fdr_cost_trf_no") == ""){
                ComShowCodeMessage('PRI07025');       
                return;
            }
 			if(document.form.menu_rhq_cd.value == "HAMRU"){
 				var pgmNo = "ESM_PRI_7111";
 				var pgmUrl = "/hanjin/ESM_PRI_7111.do";
 			}else if(document.form.menu_rhq_cd.value == "SHARC"){
 				var pgmNo = "ESM_PRI_7211";
 				var pgmUrl = "/hanjin/ESM_PRI_7211.do";
 			}else if(document.form.menu_rhq_cd.value == "SINRS"){
 				var pgmNo = "ESM_PRI_7311";
 				var pgmUrl = "/hanjin/ESM_PRI_7311.do";
 			}		
    		var params = "&in_svc_scp_cd="    	+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"svc_scp_cd")
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
	parent.loadTabPage();
} 

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet2":
		with (sheetObj) {
			style.height = 365;
			SheetWidth = mainTable.clientWidth;

			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = true;
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "|||Sel.|Scope|Cost Tariff|Cost Tariff|Cost Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|ORG_DEST_TP_CD";
			var HeadTitle2 = "|||Sel.|Scope|No.|Confirmed Date|Count|No.|AMD No.|Creation Date|Status|Interfaced\nCost Tariff No|ORG_DEST_TP_CD";
			
		
			var prefix = "sheet2_";
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false)
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter,	true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 		30, 	daCenter,	true, prefix + "fic_prop_sts_cd");
			InitDataProperty(0, cnt++, dtHidden, 		30, 	daCenter,	true, prefix + "rhq_cd");
			InitDataProperty(0, cnt++, dtCheckBox, 		40, 	daCenter, 	true, prefix + "chk",				false, "", dfNone, 0, true,  true, 3);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "svc_scp_cd", 		false, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 			80,		daCenter, 	true, prefix + "cost_trf_no", 		false, "", dfNone, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "eff_fm_dt", 		false, "", dfNone, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, prefix + "row_no", 			false, "", dfInteger, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 			120,	daCenter, 	true, prefix + "fdr_trf_no", 		false, "", dfUserFormat, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, prefix + "amdt_seq", 			false, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "cre_dt", 			false, "", dfUserFormat, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "fic_prop_sts_cd_nm",	false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "add_fdr_cost_trf_no",	false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, prefix + "org_dest_tp_cd",	false, "", dfNone, 0, false, false, 1);
			sheetObj.InitUserFormat(0, prefix + 'fdr_trf_no', "###-#-###-####", "-")		
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

function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		var sheetID = sheetObj.id;
		switch (sheetID) {
		case "sheet2":
			var prefix = "sheet2_";
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
			case IBSEARCH:
				formObj.f_cmd.value 	= SEARCHLIST;
				sheetObj.WaitImageVisible = false;
				sheetObj.DoSearch("ESM_PRI_7021_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.CheckAll(prefix + 'chk') = 0;
				var headerCnt = sheetObj.HeaderRows;
				var editableCnt = 0;
				for ( var i = 0; i < sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i + headerCnt, prefix + 'fic_prop_sts_cd') == 'I') {
						sheetObj.RowEditable(i + headerCnt) = false;
					} else {
						sheetObj.RowEditable(i + headerCnt) = true;
						editableCnt++;
					}
				}
				
				if(editableCnt == 0) {
					sheetObj.Editable = false;
				} else {
					sheetObj.Editable = true;
				}
					
				break;
			case IBSAVE:
				if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                
				if (!ComShowCodeConfirm('PRI00358')) {
					    return false;
				}
				ComOpenWait(true); //->waiting->start
				formObj.f_cmd.value = MULTI;
				sheetObj.WaitImageVisible = false;
				var sParam = FormQueryString(formObj);
				sParam += "&" + ComGetPrefixParam(prefix);
		 		sParam += "&" + sheetObj.GetSaveString(false, true);
				
				var sXml = sheetObj.GetSaveXml("ESM_PRI_7021_01GS.do", sParam);
				var save_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        		ComOpenWait(false); //->waiting->End
		     	if(save_result != "F" ){
		     		ComShowCodeMessage('PRI07017');
		     		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		     	} else {
		     		ComShowMessage(ComGetEtcData(sXml, "Exception"));
		     	}  
				break;
				
			case IBRESET:
				comboObjects[0].Index = 0;
				comboObjects[1].Index = -1;
				formObj.reset();
				sheetObj.CheckAll(prefix + 'chk') = 0;
				sheetObj.RemoveAll();
				formObj.svcScpCd.focus();
				break;	
				
			case MULTI02:
				if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }		        
                var sParam = "&org_dest_tp_cd=" + comboObjects[0].Code 
                			   + "&rhq_cd="  		  + comboObjects[2].Code ;
                var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7007.do?"+ sParam,	680, 550, '', "1,0,1,1,1,1,1", true); 
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
	var prefix = "sheet2_";	
	
    switch (sAction) {
    case IBSAVE:       
        if(!sheetObj.IsDataModified){
            ComShowCodeMessage('PRI07010'); 
            return false;
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
        if(arrRow.length > 2){
        	ComShowCodeMessage('PRI07031','Add-on');  
        	return false;
        }
       
        // if user select non interfaced
    	if(sheetObj.CellValue(arrRow[0], prefix + 'fdr_trf_no') == ""){ 
			ComShowCodeMessage('PRI07034');  
			return false;
    	}
        break;
    }
    return true;
}  

function svcScpCd_OnChange(comboObj, code, text) {
	var formObj = document.form;
		formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
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
	function svcScpCd_OnBlur(comboObj) {
		var formObj = document.form;	
		var code = comboObjects[1].Code;
		if (code != null && code != "") {
			formObj.f_cmd.value = SEARCH27;
			formObj.svc_scp_cd.value = code;
			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		    var arrData  = ComPriXml2Array(sXml, "cd");  
		}
	}

function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var prefix = "sheet2_";
	for(var i = sheetObj.HeaderRows, n = sheetObj.RowCount + sheetObj.HeaderRows; i < n; i++) {
		var cost_trf_no = sheetObj.CellValue(i, prefix + 'cost_trf_no');
		var add_fdr_cost_trf_no = sheetObj.CellValue(i, prefix + 'add_fdr_cost_trf_no');
		if(cost_trf_no != add_fdr_cost_trf_no) {
			sheetObj.CellFont("FontColor", i, prefix + 'cost_trf_no', i, prefix + 'cost_trf_no') = sheetObj.RgbColor(255,0,0);
			sheetObj.CellFont("FontColor", i, prefix + 'add_fdr_cost_trf_no', i, prefix + 'add_fdr_cost_trf_no') = sheetObj.RgbColor(255,0,0);
		}
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
		formObj.cd.value = comboObjects[2].Code;  // RHQ_CD
		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		ComPriXml2ComboItem(sXml, formObj.svcScpCd, "cd", "cd|nm");
		if(comboObjects[2].Code != 'NYCRA'){
			formObj.svcScpCd.focus();
		}
	}
	
	/**
	 * 
	 * @return 
	 */
	function load_check_sheet(){
		var prefix = "sheet2_";
		return ComPriSheet2Xml(sheetObjects[0],"",prefix + "chk","1");
	}
	
	/**
     * row double click 으로 open creation pop-up open <br>
     */
	function sheet2_OnDblClick(sheetObj,Row,Col){
		var prefix = "sheet2_";
		
		if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"add_fdr_cost_trf_no") == ""){
            ComShowCodeMessage('PRI07025');       
            return;
        }
		
		if(document.form.menu_rhq_cd.value == "HAMRU"){
			var pgmNo = "ESM_PRI_7111";
			var pgmUrl = "/hanjin/ESM_PRI_7111.do";
		}else if(document.form.menu_rhq_cd.value == "SHARC"){
			var pgmNo = "ESM_PRI_7211";
			var pgmUrl = "/hanjin/ESM_PRI_7211.do";
		}else if(document.form.menu_rhq_cd.value == "SINRS"){
			var pgmNo = "ESM_PRI_7311";
			var pgmUrl = "/hanjin/ESM_PRI_7311.do";
		}		
		
		var params = "&in_svc_scp_cd="    	   +  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"svc_scp_cd")
		               + "&in_org_dest_tp_cd="  +  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, prefix+"org_dest_tp_cd");
		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
		var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);  
	}