/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0010.js
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class vop_vsk_0010 : vop_vsk_0010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0702() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var marrPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_");
var marrTabTitle = new Array("Not Select Lane", "Main Lane", "CKY Lane", "Intra Asia Lane", "Other Lane");
var objFocusSheet = null;
var strFocusVal = "";
var strFocusPrefix = "";
var marrFleetType = new Array("M", "C", "I", "O");;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         var sheetObject5 = sheetObjects[4]; 
         var sheetObject6 = sheetObjects[5];
         var sheetObject7 = sheetObjects[6];         

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {

/**		TAB 1		**/
						case "btn_Retrieve":
								doActionIBSheet(document.form, IBSEARCH);
								break;
								
						case "btn_close":
								window.close();
								break;

						case "btn_downexcel":
								alert(srcName);
								break;					
								
						case "btn_ok":
								doActionIBSheet(document.form, IBSAVE);
								break;																		

						case "btn_add":
							sheet_closs(sheetObject1, objFocusSheet, sheetObject1.SelectRow, "sheet1_", strFocusPrefix, strFocusVal);
							break;

						case "btn_del":
							sheet_closs(objFocusSheet, sheetObject1, objFocusSheet.SelectRow, strFocusPrefix, "sheet1_", "");
							break;
						
						case "vsl_svc_tp_cd":
							doActionIBSheet2(formObject, IBSEARCH);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
	/**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++] = combo_obj;
	}

    
	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		initControl();
		doActionIBSheet(document.form, IBSEARCH)
    }
    /**
    * 초기 이벤트 등록 
    */
    function initControl() {
		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('focus',			'obj_activate',		form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',        'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		
		sheetObjects[0].WaitImageVisible = false;	
		document.form.f_cmd.value = SEARCH;
		var arr = new Array("", "", "");
		var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0007GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam(arr));
		var arrXml = sXml.split("|$$|");
/*
		if(arrXml.length > 0){
			marrFleetType = ComOPFXml2Array(arrXml[1], "val");
		}
		sheetObjects[0].WaitImageVisible = true;	
*/
    }
    
    function dateFormat(n, digits) {
    	var zero = '';
    	n = n.toString();

    	if (n.length < digits) {
    		for (i = 0; i < digits - n.length; i++)
    	    zero += '0';
    	}
    	return zero + n;
    }
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		with (sheetObj) {
			// 높이 설정
			if(sheetNo == 1){
				style.height = 460;
			}else if(sheetNo == 2){
				style.height = 100;
			}else{
				style.height = 100;
			}
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|No|Lane Code|Lane Name|vskd_flet_grp_cd|vsl_svc_tp_cd";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet" + sheetNo + "_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtSeq,			35,	 	daCenter,	true,		prefix + "Seq",					false,		"",	dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		prefix + "vsl_slan_cd",			false,		"",	dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,		prefix + "vsl_slan_nm",			false,		"",	dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix + "vskd_flet_grp_cd",	false,		"",	dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		prefix + "vsl_svc_tp_cd",		false,		"",	dfNone,	0,		false,		false);
			
			CountPosition = 0;
		}
	}


    function doActionIBSheet(formObj, sAction) {
        switch(sAction) {
			case IBSEARCH:		//조회
				var arrPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_");
				formObj.f_cmd.value = SEARCH;
					
				var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0702GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
				var arrXml = sXml.split("|$$|");

				if(arrXml.length > 3){
					for(var cnt = 0; cnt < arrXml.length; cnt++){
						sheetObjects[cnt].Redraw = false;    
						sheetObjects[cnt].WaitImageVisible = false;	
						sheetObjects[cnt].LoadSearchXml(arrXml[cnt]); 
						sheetObjects[cnt].Redraw = true; 
					}
				}
				focusSheet(sheetObjects[1], 1);
				break;
			case IBSAVE:		//저장.
				formObj.f_cmd.value = MULTI;
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;
								  
				sParam += "&" + FormQueryString(formObj);
				
				var sXml = sheetObjects[0].GetSaveXml("VOP_VSK_0702GS.do", sParam);
				//alert(">>결과:"+sXml);
				
				if(sXml.indexOf("OK") > -1){
					sheetObjects[0].LoadSaveXml(sXml);
					window.dialogArguments.doActionIBSheet(window.dialogArguments.beforetab, window.dialogArguments.document.form, IBSEARCH);
					window.close();
				}else{
					sheetObjects[0].LoadSaveXml(sXml);
				}

				break;
		}
	}

    function doActionIBSheet2(formObj, sAction) {

		for(var cnt = sheetObjects[0].HeaderRows; cnt <= sheetObjects[0].LastRow; cnt++){

			if(formObj.vsl_svc_tp_cd[1].checked && sheetObjects[0].CellValue(cnt, "sheet1_vsl_svc_tp_cd") == "O"){
				sheetObjects[0].RowHidden(cnt) = true;
			}else if(formObj.vsl_svc_tp_cd[2].checked && sheetObjects[0].CellValue(cnt, "sheet1_vsl_svc_tp_cd") != "O"){
				sheetObjects[0].RowHidden(cnt) = true;
			}else{
				sheetObjects[0].RowHidden(cnt) = false;
			}
		}

		sheetObjects[0].SelectCell(1, 1);
	}
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj,sAction){

        return true;
    }
	
	function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y){
		focusSheet(sheetObj, 1);
	}

	
	function sheet3_OnMouseDown(sheetObj, Button, Shift, X, Y){
		focusSheet(sheetObj, 2);
	}
	
	function sheet4_OnMouseDown(sheetObj, Button, Shift, X, Y){
		focusSheet(sheetObj, 3);
	}

	function sheet5_OnMouseDown(sheetObj, Button, Shift, X, Y){
		focusSheet(sheetObj, 4);
	}
	
	function sheet1_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, objFocusSheet, Row, "sheet1_", strFocusPrefix, strFocusVal);
	}

	function sheet2_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, sheetObjects[0], Row, strFocusPrefix, "sheet1_", "");
	}

	function sheet3_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, sheetObjects[0], Row, strFocusPrefix, "sheet1_", "");
	}

	function sheet4_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, sheetObjects[0], Row, strFocusPrefix, "sheet1_", "");
	}

	function sheet5_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, sheetObjects[0], Row, strFocusPrefix, "sheet1_", "");
	}

	function focusSheet(sheetObj, idx){
		strFocusVal = marrFleetType[idx - 1];
		strFocusPrefix = marrPrefix[idx];
		objFocusSheet = sheetObj;
		for(var cnt = 1; cnt < 5; cnt++){
			if(idx == cnt){
				document.all.item("sheetHelp" + cnt).bgColor = "#E9E9E9";
			}else{
				document.all.item("sheetHelp" + cnt).bgColor = "#F3F2F8";
			}
		}
	}

	function sheet_closs(sheetOrg, sheetCopy, Row, prefixOrg, prefixCopy, vskdFletGrpCd){
		try {
			if(parseInt(sheetOrg.RowCount) < 1){
				return;
			}

			var vsl_slan_cd = sheetOrg.CellValue(Row, prefixOrg + "vsl_slan_cd");
			var vsl_slan_nm = sheetOrg.CellValue(Row, prefixOrg + "vsl_slan_nm");
			var vsl_svc_tp_cd = sheetOrg.CellValue(Row, prefixOrg + "vsl_svc_tp_cd");
			sheetOrg.RowDelete(Row, false);

			var insRow = sheetCopy.DataInsert(-1);

			sheetCopy.CellValue(insRow, prefixCopy + "vsl_slan_cd") = vsl_slan_cd;
			sheetCopy.CellValue(insRow, prefixCopy + "vsl_slan_nm") = vsl_slan_nm;
			sheetCopy.CellValue(insRow, prefixCopy + "vskd_flet_grp_cd") = vskdFletGrpCd;
			sheetCopy.CellValue(insRow, prefixCopy + "vsl_svc_tp_cd") = vsl_svc_tp_cd;

			sheetCopy.RowBackColor(insRow) = sheetCopy.RgbColor(192,192,192);

			if(prefixCopy == "sheet1_" && document.form.vsl_svc_tp_cd[1].checked && vsl_svc_tp_cd == "O"){
				sheetCopy.RowHidden(insRow) = true;
			}else if(prefixCopy == "sheet1_" && document.form.vsl_svc_tp_cd[2].checked && vsl_svc_tp_cd != "O"){
				sheetCopy.RowHidden(insRow) = true;
			}else{
				sheetCopy.RowHidden(insRow) = false;
			}
		}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
	}

	/* 개발자 작업  끝 */