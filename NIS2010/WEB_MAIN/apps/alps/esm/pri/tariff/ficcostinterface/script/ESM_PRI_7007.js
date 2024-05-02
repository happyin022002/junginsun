/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7007.js
 *@FileTitle : Add-on(Ocean Feeder) tariff copying to other trade
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.11
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.10.11 서미진
 * 1.0 Creation
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7007() {
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
		switch (srcName) {
			case "btn_save":
				doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
				break;	
	
			case "btn_add_row":
				doActionIBSheet(sheetObjects[1], document.form, MULTI03);
				break;
				
            case "btn_delete_row":    
                doActionIBSheet(sheetObjects[1],document.form, MULTI02);
                break;   
				
			case "btn_close":
				self.close();
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
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
}

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			style.height = 130;
			SheetWidth = mainTable.clientWidth;

			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = false;
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "|||Seq.|Scope|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Guideline Tariff|Cost Tariff|Cost Tariff|Cost Tariff|ORG_DEST_TP_CD";
			var HeadTitle2 = "|||Seq.|Scope|No.|AMD\nNo.|Creation\nDate|Status|Interfaced\nCost Tariff No|No.|Confirmed\nDate|Count|ORG_DEST_TP_CD";
			
		
			var prefix = "sheet2_";
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);   // 
			InitHeadMode(true, true, true, true, false, false)
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter,	true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 		30, 	daCenter,	true, prefix + "fic_prop_sts_cd");
			InitDataProperty(0, cnt++, dtHidden, 		30, 	daCenter,	true, prefix + "rhq_cd");
			InitDataProperty(0, cnt++, dtDataSeq, 		40, 	daCenter, 	true, prefix + "chk",				false, "", dfNone, 0, true,  true, 3);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "svc_scp_cd", 		false, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 			100,	daCenter, 	true, prefix + "fdr_trf_no", 		false, "", dfUserFormat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 			0, 	daRight, 	true, prefix + "amdt_seq", 			false, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "upd_dt", 			false, "", dfUserFormat, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "fic_prop_sts_cd_nm",	false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "add_fdr_cost_trf_no",	false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtHidden,			0,		daCenter, 	true, prefix + "cost_trf_no", 		false, "", dfNone, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, 	true, prefix + "eff_fm_dt", 		false, "", dfNone, 0, false, false, 10);
			InitDataProperty(0, cnt++, dtData, 			0, 	daRight, 	true, prefix + "row_no", 			false, "", dfInteger, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, prefix + "org_dest_tp_cd",	false, "", dfNone, 0, false, false, 1);
			sheetObj.InitUserFormat(0, prefix + 'fdr_trf_no', "###-#-###-####", "-")		
		}
		break;
		
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 200;
			 //전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]      
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "ibflag|Sel.|Scope|Effective Date";
			
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false);
			InitHeadRow(0, HeadTitle1, true);
			
			 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 		30, 	daCenter,	false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 			60, 		daCenter, 	false, 	"chk");         
			InitDataProperty(0, cnt++, dtCombo, 			100, 		daCenter, 	false, "svc_scp_cd", 		true, "", dfNone, 0, 		false, true, 3);
			InitDataProperty(0, cnt++, dtData,	 			200, 		daCenter, 	false, "eff_dt", 			true, "", dfDateYmd, 0, false, true);
		}
		break;
		
	case "sheet3":    // validation 용 sheet
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			 //전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]      dtHiddenStatus
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "ibflag|svc_scp_cd|eff_dt|rhq_cd|org_dest_tp_cd";
			
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false);
			InitHeadRow(0, HeadTitle1, true);
			
			 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 		30, 	daCenter,	false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 			50, 		daCenter, 	false, "svc_scp_cd", 		false, "", dfNone, 0, 		false, true, 3);
			InitDataProperty(0, cnt++, dtData,	 		100, 		daCenter, 	false, "eff_dt", 			false, "", dfNone);
			InitDataProperty(0, cnt++, dtData,	 		100, 		daCenter, 	false, "rhq_cd", 			false, "", dfNone);
			InitDataProperty(0, cnt++, dtData,	 		50, 		daCenter, 	false, "org_dest_tp_cd", 			false, "", dfNone);
		}
		break;
		
	case "sheet4":    // save 용 sheet
		with (sheetObj) {
			// 높이 설정
			style.height = 400;
			 //전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]      dtHiddenStatus
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "ibflag|svc_scp_cd|rhq_cd|eff_dt|org_dest_tp_cd|ori_svc_scp_cd|ori_fdr_trf_no|ori_amdt_seq";
			
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false);
			InitHeadRow(0, HeadTitle1, true);
			
			 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 		30, 	daCenter,	false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 			50, 		daCenter, 	false, "svc_scp_cd", 		false, "", dfNone, 0, 		false, true, 3);
			InitDataProperty(0, cnt++, dtData,	 		50, 		daCenter, 	false, "rhq_cd", 			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,	 		100, 		daCenter, 	false, "eff_dt", 			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,	 		50, 		daCenter, 	false, "org_dest_tp_cd", 			false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 			50, 		daCenter, 	false, "ori_svc_scp_cd", 		false, "", dfNone, 0, 		false, true);
			InitDataProperty(0, cnt++, dtData, 			150, 		daCenter, 	false, "ori_fdr_trf_no", 		false, "", dfNone, 0, 		false, true);
			InitDataProperty(0, cnt++, dtData, 			50, 		daCenter, 	false, "ori_amdt_seq", 		false, "", dfNone, 0, 		false, true);
		}
		break;
	}
}

	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 서미진
	 * @version 2012.05.14
	 */ 
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
				switch (sAction) {
				// upper sheet retrieve
				case IBSEARCH:   
			        var checkedRows = dialogArguments.load_check_sheet();
			        ComPriXml2Sheet(sheetObjects[0], checkedRows);
					break;
					
				// lower sheet service scope combo setting	
				case SEARCH01:	
					var formObj = document.form;
					formObj.f_cmd.value = SEARCH25;
					var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));		
					setIBCombo(sheetObjects[1], sXml, "svc_scp_cd", true, 0 , "", "", true);
				    break;
				  
				// copying     
				case IBSAVE:
					clearAllsheets();
					if (!validateForm(sheetObj,document.form,sAction)) {
	                    return false;
	                }
					if (!ComShowCodeConfirm('PRI00012')) {
						    return false;
					}
	
					formObj.f_cmd.value = MULTI;
					sheetObj.WaitImageVisible = false;
					var sParam = FormQueryString(formObj);
					sParam += "&" + sheetObjects[3].GetSaveString(false, true);
					
					var sXml = sheetObjects[3].GetSaveXml("ESM_PRI_7007GS.do", sParam);
					var save_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	        		ComOpenWait(false); 
			     	if(save_result != "F" ){
			     		ComShowCodeMessage('PRI07017');
						window.returnValue = true;
						window.close();
			     	} else {
			     		ComShowMessage(ComGetEtcData(sXml, "Exception"));
			     	}  
					break;				
				
			   // Delete row	
				case MULTI02: 
					if(sheetObj.RowCount > 0){
			        	if (sheetObj.CheckedRows("chk") <= 0) {
			        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
			        	}
			        	deleteRowCheck(sheetObj, "chk");
					}
					break;		
				
			    // Add row	
				case MULTI03: 
	                var iRow = sheetObjects[1].DataInsert(-1);
	                sheetObjects[1].CellValue(iRow, 'svc_scp_cd') = "";
	                sheetObjects[1].CellValue(iRow, 'eff_dt') = ComGetNowInfo();
	                sheetObjects[1].SelectCell(iRow, "svc_scp_cd");
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
        
        //Mandatory check & bound check
        for(var i = sheetObjects[1].HeaderRows; i <= sheetObjects[1].LastRow ; i++){
        	// Mandatory check - service scope
        	if(sheetObjects[1].CellValue(i, "svc_scp_cd") == ""){
	           	 ComShowCodeMessage('PRI00316',"Service Scope");
	           	 sheetObjects[1].SelectCell(i, "svc_scp_cd");
	        	 return false;
        	}
        	// Mandatory check - eff_dt
        	if(sheetObjects[1].CellValue(i, "eff_dt") == ""){
	           	 ComShowCodeMessage('PRI00316',"Effective Date");
	           	 sheetObjects[1].SelectCell(i, "eff_dt");
	        	 return false;
        	}
        }
        
        //Service Scope 중복 데이터 체크
        var dupRow = sheetObj.ColValueDup("svc_scp_cd");
        if (dupRow>0) {
        	sheetObj.SelectRow = dupRow;
            ComShowCodeMessage("PRI00342","Service Scope");
            ComSetFocus(sheetObj.ColValueDupRows("svc_scp_cd"));	
            return false;
        }	  

        // validation 1 - check exist IHC tariff's status
        formObj.f_cmd.value = SEARCH02;
        for(var i=sheetObjects[1].HeaderRows; i <= sheetObjects[1].LastRow; i++){
        	var  svc_scp_cd = sheetObjects[1].CellValue(i, "svc_scp_cd");

        	for(var k=sheetObjects[0].HeaderRows; k <= sheetObjects[0].LastRow; k++){      
	        	if(svc_scp_cd == sheetObjects[0].CellValue(k, prefix+"svc_scp_cd")){
	                ComShowCodeMessage("PRI07032");
	        		return false;
	        	}
        	}
       	    var newRow = sheetObjects[2].DataInsert(-1);
            sheetObjects[2].CellValue(newRow, "svc_scp_cd") = svc_scp_cd;
            sheetObjects[2].CellValue(newRow, "rhq_cd") = formObj.rhq_cd.value;	
            sheetObjects[2].CellValue(newRow, "org_dest_tp_cd") = formObj.org_dest_tp_cd.value;	
    	}

 		var sParam = FormQueryString(formObj) + "&" + sheetObjects[2].GetSaveString(false, true);
        var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_7007GS.do", sParam);        
        var arrData  = ComPriXml2Array(sXml, "svc_scp_cd|fdr_trf_no");   
   
        if(arrData != undefined){
        	var copycheck = "";
            for(var i = 0; i < arrData.length; i++){
            	copycheck += parseInt(i)+1 +") " + arrData[i][0] + ", G/L tariff no : " + arrData[i][1] + "\n" ;
            }
            ComShowCodeMessage('PRI07036',copycheck); 
            return false;
        }
      
 		// validation 2 - check exist IHC tariff's effective date
        formObj.f_cmd.value = SEARCH03;
        for(var i = sheetObjects[2].HeaderRows; i <= sheetObjects[1].LastRow ; i++){
	    	for(var j = sheetObjects[1].HeaderRows; j <= sheetObjects[1].LastRow ; j++){
	    		if(sheetObjects[2].CellValue(i, "svc_scp_cd") == sheetObjects[1].CellValue(j, "svc_scp_cd")){
	    			sheetObjects[2].CellValue(i, "eff_dt") = sheetObjects[1].CellValue(j, "eff_dt");
	    		}	        		
	    	}	
        } 	
    	
        var sParam = FormQueryString(formObj) + "&" + sheetObjects[2].GetSaveString(false);      
        var sXml = sheetObj.GetSearchXml("ESM_PRI_7007GS.do", sParam);    
        var arrData  = ComPriXml2Array(sXml, "svc_scp_cd|fdr_trf_no");   
        if(arrData != undefined){
        	var copycheck = "";
            for(var i = 0; i < arrData.length; i++){
            	copycheck += parseInt(i)+1 +") " + arrData[i][0] + ", G/L tariff no : " + arrData[i][1] + "\n" ;
            }
            ComShowCodeMessage('PRI07035',copycheck); 
            return false;
        }
 
        // save 용 sheet
        if(sheetObjects[2].RowCount != 0){
	        for(var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow ; i++){
            	for(var k= sheetObjects[0].HeaderRows; k <= sheetObjects[0].LastRow ; k++){
        			var newRow = sheetObjects[3].DataInsert(-1);
        			sheetObjects[3].CellValue(newRow, "svc_scp_cd") = sheetObjects[2].CellValue(i, "svc_scp_cd"); 			
        			sheetObjects[3].CellValue(newRow, "eff_dt") = sheetObjects[2].CellValue(i, "eff_dt");
        			sheetObjects[3].CellValue(newRow, "rhq_cd") = formObj.rhq_cd.value;
        			sheetObjects[3].CellValue(newRow, "org_dest_tp_cd") = formObj.org_dest_tp_cd.value;			        			
        			sheetObjects[3].CellValue(newRow, "ori_svc_scp_cd") = sheetObjects[0].CellValue(k, prefix+"svc_scp_cd");
        			sheetObjects[3].CellValue(newRow, "ori_fdr_trf_no") = sheetObjects[0].CellValue(k, prefix+"fdr_trf_no");
        			sheetObjects[3].CellValue(newRow, "ori_amdt_seq") = sheetObjects[0].CellValue(k, prefix+"amdt_seq");
                	}	                	
	        } 
        }
        break;
    }
    return true;
}  


	/**
	 * 화면의 숨긴 sheet를 모두 clear 
	 * @author 서미진
	 * @version 2012.10.23
	 */      
	 function clearAllsheets(){   
	     sheetObjects[2].RemoveAll();     
	     sheetObjects[3].RemoveAll();     
	 }
