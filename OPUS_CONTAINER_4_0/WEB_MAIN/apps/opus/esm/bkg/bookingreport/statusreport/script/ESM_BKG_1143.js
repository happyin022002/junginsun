/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1143.js
*@FileTitle  : booking report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/05
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author CLT
 */
/**
 * @extends
 * @class ESM_BKG_0111_01 : ESM_BKG_0111_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1143_01() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var combo1=null;
	var comboCnt=0;
	var tabItem=0;
	var seqSheet1=0;
	var seqSheet2=0;
	var loadPageCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
		for (k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			tabObjects[k].SetSelectedIndex(0);
		}
		//MultiCombo초기화 
		for ( var k=1; k < comboObjects.length - 1; k++) {
			initCombo(comboObjects[k]);
		}
		document.form.vvd.focus();
		initControl();
		loadPageCnt=1;
	}
/**
 * 콤보 초기설정값
 * @param {IBMultiCombo} comboObj  comboObj
 */
	function initCombo(comboObj) {
		comboObj.SetMultiSelect(0);
	//no support[check again]CLT 	comboObj.UseCode=true;
		// comboObj.LineColor = "#ffffff";
		// comboObj.SetColAlign("left|left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(150);
	}
/**
 * 조회조건 입력할 때 처리
 */
//function obj_KeyUp() {
//     var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//     //alert("keyValue : " + keyValue);
//	var formObject=document.form;
//	var srcName=ComGetEvent("name");
//	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	var srcValue=window.event.srcElement.getAttribute("value");
//	if ( keyValue != 9 && keyValue !=16 && ComChkLen(srcValue, srcMaxLength) == "2" ) {
//		ComSetNextFocus();
//	}
//}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
	function initControl() {
		var formObject=document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // - 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); // - 포커스 들어갈때
		//axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key 처리
		//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	}
/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
//function obj_keypress() {
//	switch (event.srcElement.dataformat) {
//	case "int":
//		//숫자만입력하기
//		ComKeyOnlyNumber(event.srcElement);
//		break;
//	case "float":
//		//숫자+"."입력하기
//		ComKeyOnlyNumber(event.srcElement, ".");
//		break;
//	case "eng":
//		//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
//		ComKeyOnlyAlphabet();
//		break;
//	case "engdn":
//		//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
//		ComKeyOnlyAlphabet('lower');
//		break;
//	case "engup":
//		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyOnlyAlphabet('upper');
//		break;
//	case "engupnum":
//		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyOnlyAlphabet('uppernum');
//		break;
//	default:
//		//숫자만입력하기(정수,날짜,시간)
//		ComKeyOnlyNumber(event.srcElement);
//	}
//}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: //t1sheet1 init
	    with(sheetObj){        
//		      var HeadTitle1="Seq|B/L No.|Booking No.|Filer|Filer|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|B/L Data (Match)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|Container|Container|Container|Container|Container";
//		      var HeadTitle2="Seq|B/L No.|Booking No.|US|CA|NM|AD|CT|CN|ZIP|STR|EORI|TAXID|NM|AD|CT|ST|CN|ZIP|STR|EORI|TAXID|NM|AD|CT|ST|CN|ZIP|STR|EORI|TAXID|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|HS|NCM|Container |S|Package|Weight|Measure";
		      var HeadTitle1="Seq|B/L No.|Booking No.|POL|POD|Filer|Filer|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|B/L Data (Match with C/M)|B/L Data (Match with C/M)|B/L Data (Match with C/M)|B/L Data (Match with C/M)|B/L Data (Match with C/M)|B/L Data (Match with C/M)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|TOTAL C/M (Container Manifest)|Container|Container|Container|Container|Container";
		      var HeadTitle2="Seq|B/L No.|Booking No.|POL|POD|US|CA|NM|AD|CT|CN|ZIP|STR|EORI|TAXID|NM|AD|CT|ST|CN|ZIP|STR|EORI|TAXID|NM|AD|CT|ST|CN|ZIP|STR|EORI|TAXID|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|HS|NCM|Container |S|Package|Weight|Measure";
		      //SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0, HeaderMergeMode:1 } );
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"usa_cstms_file_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cnd_cstms_file_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm_s",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm_s",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd_s",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id_s",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_st_nm_s",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_eori_no_s",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_tax_id_s",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm_c",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd_c",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_st_nm_c",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_eori_no_c",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_tax_id_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm_n",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr_n",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_cnt_cd_n",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_st_nm_n",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"cust_eori_no_n",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_tax_id_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty_da",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"act_wgt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"act_wet_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"meas_qty_da",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty_cm",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty_cm",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_gds_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_mk_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_hts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_hs",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_ncm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty_co",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty_co",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_nm" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"good_idx" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"error_idx" } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(450);
		      SetEditable(0);
		      SetRangeBackColor(1,3,1,55,"#555555");
            }


		break;
	case 2: //t2sheet1 init
	    with(sheetObj){
	     
//	      var HeadTitle1="Seq|H/B No.|Manifest File No.|Master B/L No.|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|Container|Container|Container|Container|Container";
//	      var HeadTitle2="Seq|H/B No.|Manifest File No.|Master B/L No.|NM|AD|CT|CN|NM|AD|CT|ST|CN|NM|AD|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|NCM|AMS|Container |S|Package|Weight|Measure";	
	      var HeadTitle1="Seq|H/B No.|Manifest File No.|Master B/L No.|POL|POD|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|House B/L Data (Match)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|C/M (Container Manifest)|Container|Container|Container|Container|Container";
	      var HeadTitle2="Seq|H/B No.|Manifest File No.|Master B/L No.|POL|POD|NM|AD|CT|CN|NM|AD|CT|ST|CN|NM|AD|Package|Package|Weight|Weight|Measure|Measure|Package|Weight|Measure|DS|MK|HTS|NCM|AMS|Container |S|Package|Weight|Measure";	
	      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);	
	      var cols = [ {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bhl_no" },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"b_usa_cstms_file_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"b_bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"b_pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"b_pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_nm_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_addr_s",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_ct_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_cn_s",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_nm_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_addr_c",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_ct_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_st_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_cn_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_nm_n",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"b_cust_addr_n",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Int",      Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"b_pck_qty_da",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b_pck_qty_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"b_hbl_wgt_da",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b_hbl_wgt_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",      Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"b_meas_qty_da",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b_meas_qty_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Int",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"b_pck_qty_cm",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"b_cntr_wgt_cm",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"b_meas_qty_cm",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_gds_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_mk_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_hts",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_ncm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_mf_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"b_cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"b_cntr_seal_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Int",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"b_pck_qty_co",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"b_cntr_wgt_co",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Float",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"b_meas_qty_co",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_nm" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"good_idx" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"error_idx" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" } ];
	       
		      InitColumns(cols);
		      SetSheetHeight(450);
		      SetEditable(0);
		      SetRangeBackColor(1,4,1,33,"#555555");
            }
		break;
	}
}
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			if (tabItem == 0) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				
			} else {
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			}
			break;
		case "btn_New":
			for (i=0; i < sheetObjects.length; i++) {
    			
    			sheetObjects[i].RemoveAll();
    		}
			//ComResetAll();
			formObject.vvd.value="";   
			formObject.pol_cd.value="";   
			formObject.pol_nod_cd.value="";	
			formObject.pod_cd.value="";	
			formObject.pod_nod_cd.value=""; 
			formObject.cust_cnt_cd.value=""; 
			formObject.cust_seq.value="";  
			formObject.bkg_ofc_cd.value="";	
			formObject.cre_usr_id.value=""; 	
			formObject.obl_iss_ofc_cd.value=""; 
			formObject.obl_iss_usr_id.value=""; 
			formObject.ob_srep_cd.value=""; 
			cnd_cstms_file_cd.SetSelectIndex(-1);
			usa_cstms_file_cd.SetSelectIndex(-1);
			formObject.chk_err.value=1;
			document.form.vvd.focus();
			document.form.tab_item.value=tabItem;
			document.getElementById('tab_tot').innerHTML="Total : ";
			break;
		case "btn_SaveExcel":
			if (tabItem == 0) {
				if(sheetObject1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					//sheetObject1.Down2Excel({ HiddenColumn:-1});
					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
				}
				
			} else {
				if(sheetObject2.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					//sheetObject2.Down2Excel({ HiddenColumn:-1});
					sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
				}
				
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		sheetObj.SetFocusAfterProcess(0);
		formObj.f_cmd.value=SEARCH;
		sheetObj.DoSearch("ESM_BKG_1143GS.do", FormQueryString(formObj) );
		searchEnd(sheetObj);
		sheetObj.SelectCell(0, 0, false);
		ComOpenWait(false);
		break;
	case COMMAND01: //CODE 조회						
		formObj.f_cmd.value=SEARCH01;
		// sheetObj.DoSearch("ESM_BKG_0111GS.do",FormQueryString(formObj));
		var searchXml=sheetObj.GetSearchData("ESM_BKG_1143GS.do", FormQueryString(formObj));
		var sXml=searchXml.split("|$$|");
		// US Filer
		ComBkgXml2ComboItem(sXml[0], usa_cstms_file_cd, "val", "name");
		// CA Filer
		ComBkgXml2ComboItem(sXml[0], cnd_cstms_file_cd, "val", "name");
		break;
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	if (formObj.vvd.value == '' || formObj.vvd.value.length != 9) {
		ComShowCodeMessage("BKG00007");// VVD is not available !
		formObj.vvd.focus();
		return false;
	} else {
		formObj.vsl_cd.value=formObj.vvd.value.substring(0, 4);
		formObj.skd_voy_no.value=formObj.vvd.value.substring(4, 8);
		formObj.skd_dir_cd.value=formObj.vvd.value.substring(8);
		// alert( formObj.vsl_cd.value + "_" + formObj.skd_voy_no.value + "_" + formObj.skd_dir_cd.value);
	}
	if (formObj.pol_cd.value == '' && formObj.pod_cd.value == '') {
		ComShowCodeMessage("BKG00137");// POL/POD is not available
		formObj.pol_cd.focus();
		return false;
	}
	if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value == '') {
		ComShowCodeMessage("BKG00458");// invalid customer code
		formObj.cust_cnt_cd.focus();
		return false;
	}
	if (formObj.cust_cnt_cd.value == '' && formObj.cust_seq.value != '') {
		ComShowCodeMessage("BKG00458");// invalid customer code
		formObj.cust_seq.focus();
		return false;
	}
	if (formObj.pol_nod_cd.value != '') {
		formObj.pol_yd_cd.value=formObj.pol_cd.value + formObj.pol_nod_cd.value;
	} else {
		formObj.pol_yd_cd.value="";
	}
	if (formObj.pod_nod_cd.value != '') {
		formObj.pod_yd_cd.value=formObj.pod_cd.value + formObj.pod_nod_cd.value;
	} else {
		formObj.pod_yd_cd.value="";
	}
	return true;
}
/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Master B/L", "");
			InsertItem( "House B/L", "");
		}
		break;
	}
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	tabItem=nItem;
	document.form.tab_item.value=tabItem;
	if (tabItem == 0) {
		//document.getElementById('tab_tot').innerHTML=document.form.master_tot.value;
		setTabTotalValue(document.form.master_tot.value);
		if (document.form.vvd.value != '' ) doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	} else {
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		//document.getElementById('tab_tot').innerHTML = document.form.houser_tot.value;
	}
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab=nItem;
}
// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function searchEnd(sheetObj)// 변수명 임의 생성
{
	with (sheetObj) {
		var redColor="#FF0000";
		var blueColor="#0000FF";
		for ( var i=2; i <= LastRow(); i++) {
			if (tabItem == 0) {
				SetCellFontColor(i, "bkg_no",blueColor);
				SetCellFontUnderline(i, "bkg_no",1);
				SetCellFontColor(i, "bl_no",blueColor);
				SetCellFontUnderline(i, "bl_no",1);
			if ("E" == GetCellValue(i, "pck_qty_chk")) {
				SetCellFontColor(i, "pck_qty_chk",redColor);
				}
			if ("E" == GetCellValue(i, "act_wet_chk")) {
				SetCellFontColor(i, "act_wet_chk",redColor);
				}
			if ("E" == GetCellValue(i, "meas_qty_chk")) {
				SetCellFontColor(i, "meas_qty_chk",redColor);
				}
				/*
			if ("N" == GetCellValue(i, "cntr_mf_mk_desc")){
			//parameter changed[check again]CLT 					SetCellFontColor(i, "cntr_mf_mk_desc",redColor);
				}
				 */
				/*
				 * if ("N" == CellValue(i, "cntr_mf_hts")){ CellFontColor(i, "cntr_mf_hts") = redColor; } if ("N" == CellValue(i,
				 * "cntr_mf_hs")){ CellFontColor(i, "cntr_mf_hs") = redColor; } if ("N" == CellValue(i, "cntr_mf_ncm")){
				 * CellFontColor(i, "cntr_mf_ncm") = redColor; }
				 */
			if ("N" == GetCellValue(i, "cntr_mf_no")) {
				SetCellFontColor(i, "cntr_mf_no",redColor);
				}
				/*
			if ("N" == GetCellValue(i, "cntr_mf_gds_desc")){
				//parameter changed[check again]CLT 					SetCellFontColor(i, "cntr_mf_gds_desc",redColor);
				}*/
			if ("E" == GetCellValue(i, "cntr_seal_seq")) {
				SetCellFontColor(i, "cntr_seal_seq",redColor);
				}
			if ("E" == GetCellValue(i, "cust_nm_s")) {
				SetCellFontColor(i, "cust_nm_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_addr_s")) {
				SetCellFontColor(i, "cust_addr_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_cty_nm_s")) {
				SetCellFontColor(i, "cust_cty_nm_s",redColor);
				}
			if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_s")) {
				SetCellFontColor(i, "cstms_decl_cnt_cd_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_zip_id_s")) {
				SetCellFontColor(i, "cust_zip_id_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_st_nm_s")) {
				SetCellFontColor(i, "cust_st_nm_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_eori_no_s")) {
				SetCellFontColor(i, "cust_eori_no_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_tax_id_s")) {
				SetCellFontColor(i, "cust_tax_id_s",redColor);
							}
			if ("E" == GetCellValue(i, "cust_nm_c")) {
				SetCellFontColor(i, "cust_nm_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_addr_c")) {
				SetCellFontColor(i, "cust_addr_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_cty_nm_c")) {
				SetCellFontColor(i, "cust_cty_nm_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_ste_cd_c")) {
				SetCellFontColor(i, "cust_ste_cd_c",redColor);
							}
			if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_c")) {
				SetCellFontColor(i, "cstms_decl_cnt_cd_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_zip_id_c")) {
				SetCellFontColor(i, "cust_zip_id_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_st_nm_c")) {
				SetCellFontColor(i, "cust_st_nm_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_eori_no_c")) {
				SetCellFontColor(i, "cust_eori_no_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_tax_id_c")) {
				SetCellFontColor(i, "cust_tax_id_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_nm_n")) {
				SetCellFontColor(i, "cust_nm_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_addr_n")) {
				SetCellFontColor(i, "cust_addr_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_cty_nm_n")) {
				SetCellFontColor(i, "cust_cty_nm_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_ste_cd_n")) {
				SetCellFontColor(i, "cust_ste_cd_n",redColor);
							}
			if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_n")) {
				SetCellFontColor(i, "cstms_decl_cnt_cd_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_zip_id_n")) {
				SetCellFontColor(i, "cust_zip_id_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_st_nm_n")) {
				SetCellFontColor(i, "cust_st_nm_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_eori_no_n")) {
				SetCellFontColor(i, "cust_eori_no_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_tax_id_n")) {
				SetCellFontColor(i, "cust_tax_id_n",redColor);
							}
			if ("E" == GetCellValue(i, "pck_qty_chk")) {
				SetCellFontColor(i, "pck_qty_chk",redColor);
							}
			if ("E" == GetCellValue(i, "act_wet_chk")) {
									SetCellFontColor(i, "act_wet_chk",redColor);
							}
			if ("E" == GetCellValue(i, "meas_qty_chk")) {
									SetCellFontColor(i, "meas_qty_chk",redColor);
							}
			if ("E" == GetCellValue(i, "cntr_mf_hts")) {
								SetCellFontColor(i, "cntr_mf_hts",redColor);
							}
			if ("E" == GetCellValue(i, "cntr_mf_hs")) {
						SetCellFontColor(i, "cntr_mf_hs",redColor);
							}
			if ("E" == GetCellValue(i, "cntr_mf_ncm")) {
				SetCellFontColor(i, "cntr_mf_ncm",redColor);
							}
						} else {
				SetCellFontColor(i, "b_bl_no",blueColor);
				SetCellFontUnderline(i, "b_bl_no",1);
			if ("E" == GetCellValue(i, "b_pck_qty_chk")) {
				 					SetCellFontColor(i, "b_pck_qty_chk",redColor);
							}
			if ("E" == GetCellValue(i, "b_hbl_wgt_chk")) {
								SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
							}
			if ("E" == GetCellValue(i, "b_meas_qty_chk")) {
									SetCellFontColor(i, "b_meas_qty_chk",redColor);
							}
				/*
			if ("N" == GetCellValue(i, "b_cntr_mf_mk_desc")){
			//parameter changed[check again]CLT 					SetCellFontColor(i, "b_cntr_mf_mk_desc",redColor);
				}*/
				/*
				 * if ("N" == CellValue(i, "b_cntr_mf_hts")){ CellFontColor(i, "b_cntr_mf_hts") = redColor; } if ("N" ==
				 * CellValue(i, "b_cntr_mf_ncm")){ CellFontColor(i, "b_cntr_mf_ncm") = redColor; }
				 */
				/*
				 * if ("N" == CellValue(i, "b_cntr_mf_no")){ CellFontColor(i, "b_cntr_mf_no") = redColor; }
				 */
				/*
				 * if ("N" == CellValue(i, "b_cntr_mf_gds_desc")){ CellFontColor(i, "b_cntr_mf_gds_desc") = redColor; }
				 */
				if ("E" == GetCellValue(i, "b_cntr_seal_seq")) {
					SetCellFontColor(i, "b_cntr_seal_seq",redColor);
								}
				if ("0" == GetCellValue(i, "b_pck_qty_cm")) {
					SetCellFontColor(i, "b_pck_qty_cm",redColor);
								}
				if ("0" == GetCellValue(i, "b_cntr_wgt_cm")) {
					SetCellFontColor(i, "b_cntr_wgt_cm",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_nm_s")) {
					SetCellFontColor(i, "b_cust_nm_s",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_addr_s")) {
					SetCellFontColor(i, "b_cust_addr_s",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_nm_c")) {
					SetCellFontColor(i, "b_cust_nm_c",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_addr_c")) {
					SetCellFontColor(i, "b_cust_addr_c",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_nm_n")) {
					SetCellFontColor(i, "b_cust_nm_n",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_addr_n")) {
					SetCellFontColor(i, "b_cust_addr_n",redColor);
								}
				if ("E" == GetCellValue(i, "b_pck_qty_chk")) {
					SetCellFontColor(i, "b_pck_qty_chk",redColor);
								}
				if ("E" == GetCellValue(i, "b_hbl_wgt_chk")) {
					SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
								}
				if ("E" == GetCellValue(i, "b_meas_qty_chk")) {
					SetCellFontColor(i, "b_meas_qty_chk",redColor);
				}
			}
		}
		document.form.master_tot.value="Total : " + GetCellValue(LastRow(), "Seq") + " (Good : " + GetCellValue(LastRow(), "good_idx")
		+ " , Error : " + GetCellValue(LastRow(), "error_idx") + ")";
//				document.getElementById('tab_tot').innerHTML=document.form.master_tot.value;
				setTabTotalValue(document.form.master_tot.value);
				
		// sheetObj.CountFormat = "[ 1 / " + seqSheet1 + " ]";
	}
}
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var redColor="#FF0000";
		var blueColor="#0000FF";
		for ( var i=2; i <= LastRow(); i++) {
			if (tabItem == 0) {
				SetCellFontColor(i, "bkg_no",blueColor);
				SetCellFontUnderline(i, "bkg_no",1);
				SetCellFontColor(i, "bl_no",blueColor);
				SetCellFontUnderline(i, "bl_no",1);
			if ("E" == GetCellValue(i, "pck_qty_chk")) {
				SetCellFontColor(i, "pck_qty_chk",redColor);
				}
			if ("E" == GetCellValue(i, "act_wet_chk")) {
				SetCellFontColor(i, "act_wet_chk",redColor);
				}
			if ("E" == GetCellValue(i, "meas_qty_chk")) {
				SetCellFontColor(i, "meas_qty_chk",redColor);
				}
				
			if ("N" == GetCellValue(i, "cntr_mf_no")) {
				SetCellFontColor(i, "cntr_mf_no",redColor);
				}
				
			if ("E" == GetCellValue(i, "cntr_seal_seq")) {
				SetCellFontColor(i, "cntr_seal_seq",redColor);
				}
			if ("E" == GetCellValue(i, "cust_nm_s")) {
				SetCellFontColor(i, "cust_nm_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_addr_s")) {
				SetCellFontColor(i, "cust_addr_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_cty_nm_s")) {
				SetCellFontColor(i, "cust_cty_nm_s",redColor);
				}
			if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_s")) {
				SetCellFontColor(i, "cstms_decl_cnt_cd_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_zip_id_s")) {
				SetCellFontColor(i, "cust_zip_id_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_st_nm_s")) {
				SetCellFontColor(i, "cust_st_nm_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_eori_no_s")) {
				SetCellFontColor(i, "cust_eori_no_s",redColor);
				}
			if ("E" == GetCellValue(i, "cust_tax_id_s")) {
				SetCellFontColor(i, "cust_tax_id_s",redColor);
							}
			if ("E" == GetCellValue(i, "cust_nm_c")) {
				SetCellFontColor(i, "cust_nm_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_addr_c")) {
				SetCellFontColor(i, "cust_addr_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_cty_nm_c")) {
				SetCellFontColor(i, "cust_cty_nm_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_ste_cd_c")) {
				SetCellFontColor(i, "cust_ste_cd_c",redColor);
							}
			if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_c")) {
				SetCellFontColor(i, "cstms_decl_cnt_cd_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_zip_id_c")) {
				SetCellFontColor(i, "cust_zip_id_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_st_nm_c")) {
				SetCellFontColor(i, "cust_st_nm_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_eori_no_c")) {
				SetCellFontColor(i, "cust_eori_no_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_tax_id_c")) {
				SetCellFontColor(i, "cust_tax_id_c",redColor);
							}
			if ("E" == GetCellValue(i, "cust_nm_n")) {
				SetCellFontColor(i, "cust_nm_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_addr_n")) {
			SetCellFontColor(i, "cust_addr_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_cty_nm_n")) {
				SetCellFontColor(i, "cust_cty_nm_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_ste_cd_n")) {
				SetCellFontColor(i, "cust_ste_cd_n",redColor);
							}
			if ("E" == GetCellValue(i, "cstms_decl_cnt_cd_n")) {
				SetCellFontColor(i, "cstms_decl_cnt_cd_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_zip_id_n")) {
				SetCellFontColor(i, "cust_zip_id_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_st_nm_n")) {
				SetCellFontColor(i, "cust_st_nm_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_eori_no_n")) {
				SetCellFontColor(i, "cust_eori_no_n",redColor);
							}
			if ("E" == GetCellValue(i, "cust_tax_id_n")) {
				SetCellFontColor(i, "cust_tax_id_n",redColor);
							}
			if ("E" == GetCellValue(i, "pck_qty_chk")) {
				SetCellFontColor(i, "pck_qty_chk",redColor);
							}
			if ("E" == GetCellValue(i, "act_wet_chk")) {
									SetCellFontColor(i, "act_wet_chk",redColor);
							}
			if ("E" == GetCellValue(i, "meas_qty_chk")) {
									SetCellFontColor(i, "meas_qty_chk",redColor);
							}
			if ("E" == GetCellValue(i, "cntr_mf_gds_desc")) {
				SetCellFontColor(i, "cntr_mf_gds_desc",redColor);
			}
			if ("E" == GetCellValue(i, "cntr_mf_mk_desc")) {
				SetCellFontColor(i, "cntr_mf_mk_desc",redColor);
			}
			if ("E" == GetCellValue(i, "cntr_mf_hts")) {
								SetCellFontColor(i, "cntr_mf_hts",redColor);
							}
			if ("E" == GetCellValue(i, "cntr_mf_hs")) {
						SetCellFontColor(i, "cntr_mf_hs",redColor);
							}
			if ("E" == GetCellValue(i, "cntr_mf_ncm")) {
				SetCellFontColor(i, "cntr_mf_ncm",redColor);
							}
						} else {
				SetCellFontColor(i, "b_bl_no",blueColor);
				SetCellFontUnderline(i, "b_bl_no",1);
			if ("E" == GetCellValue(i, "b_pck_qty_chk")) {
				 					SetCellFontColor(i, "b_pck_qty_chk",redColor);
							}
			if ("E" == GetCellValue(i, "b_hbl_wgt_chk")) {
								SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
							}
			if ("E" == GetCellValue(i, "b_meas_qty_chk")) {
									SetCellFontColor(i, "b_meas_qty_chk",redColor);
							}
				
				if ("E" == GetCellValue(i, "b_cntr_seal_seq")) {
					SetCellFontColor(i, "b_cntr_seal_seq",redColor);
								}
				if ("0" == GetCellValue(i, "b_pck_qty_cm")) {
					SetCellFontColor(i, "b_pck_qty_cm",redColor);
								}
				if ("0" == GetCellValue(i, "b_cntr_wgt_cm")) {
					SetCellFontColor(i, "b_cntr_wgt_cm",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_nm_s")) {
					SetCellFontColor(i, "b_cust_nm_s",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_addr_s")) {
					SetCellFontColor(i, "b_cust_addr_s",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_nm_c")) {
					SetCellFontColor(i, "b_cust_nm_c",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_addr_c")) {
					SetCellFontColor(i, "b_cust_addr_c",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_nm_n")) {
					SetCellFontColor(i, "b_cust_nm_n",redColor);
								}
				if ("E" == GetCellValue(i, "b_cust_addr_n")) {
					SetCellFontColor(i, "b_cust_addr_n",redColor);
								}
				if ("E" == GetCellValue(i, "b_pck_qty_chk")) {
					SetCellFontColor(i, "b_pck_qty_chk",redColor);
								}
				if ("E" == GetCellValue(i, "b_hbl_wgt_chk")) {
					SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
								}
				if ("E" == GetCellValue(i, "b_meas_qty_chk")) {
					SetCellFontColor(i, "b_meas_qty_chk",redColor);
				}
			}
		}
		document.form.master_tot.value="Total : " + GetCellValue(LastRow(), "Seq") + " (Good : " + GetCellValue(LastRow(), "good_idx")
		+ " , Error : " + GetCellValue(LastRow(), "error_idx") + ")";
				document.getElementById('tab_tot').innerHTML=document.form.master_tot.value;
		// sheetObj.CountFormat = "[ 1 / " + seqSheet1 + " ]";
	}
	}



// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
		function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
			with (sheetObj) {
		document.form.houser_tot.value="Total : " + GetCellValue(LastRow(), "Seq") + " (Good : " + GetCellValue(LastRow(), "good_idx")
		+ " , Error : " + GetCellValue(LastRow(), "error_idx") + ")";
				//document.getElementById('tab_tot').innerHTML=document.form.houser_tot.value;
		setTabTotalValue(document.form.houser_tot.value);
				var redColor="#FF0000";
				var blueColor="#0000FF";
				for ( var i=2; i <= LastRow(); i++) {
			SetCellFontColor(i, "b_bl_no",blueColor);
			SetCellFontUnderline(i, "b_bl_no",1);
		if ("N" == GetCellValue(i, "b_pck_qty_chk")) {
			SetCellFontColor(i, "b_pck_qty_chk",redColor);
					}
		if ("N" == GetCellValue(i, "b_hbl_wgt_chk")) {
			SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
					}
		if ("N" == GetCellValue(i, "b_meas_qty_chk")) {
			SetCellFontColor(i, "b_meas_qty_chk",redColor);
					}
					
		if ("E" == GetCellValue(i, "b_cntr_seal_seq")) {
			SetCellFontColor(i, "b_cntr_seal_seq",redColor);
					}
		if ("0" == GetCellValue(i, "b_pck_qty_cm")) {
			SetCellFontColor(i, "b_pck_qty_cm",redColor);
					}
		if ("0" == GetCellValue(i, "b_cntr_wgt_cm")) {
			SetCellFontColor(i, "b_cntr_wgt_cm",redColor);
					}
		if ("E" == GetCellValue(i, "b_cust_nm_s")) {
			SetCellFontColor(i, "b_cust_nm_s",redColor);
					}
		if ("E" == GetCellValue(i, "b_cust_addr_s")) {
			SetCellFontColor(i, "b_cust_addr_s",redColor);
					}
		if ("E" == GetCellValue(i, "b_cust_nm_c")) {
			SetCellFontColor(i, "b_cust_nm_c",redColor);
					}
		if ("E" == GetCellValue(i, "b_cust_addr_c")) {
			SetCellFontColor(i, "b_cust_addr_c",redColor);
					}
		if ("E" == GetCellValue(i, "b_cust_nm_n")) {
			SetCellFontColor(i, "b_cust_nm_n",redColor);
					}
		if ("E" == GetCellValue(i, "b_cust_addr_n")) {
			SetCellFontColor(i, "b_cust_addr_n",redColor);
					}
		if ("E" == GetCellValue(i, "b_pck_qty_chk")) {
			SetCellFontColor(i, "b_pck_qty_chk",redColor);
					}
		if ("E" == GetCellValue(i, "b_hbl_wgt_chk")) {
			SetCellFontColor(i, "b_hbl_wgt_chk",redColor);
					}
		if ("E" == GetCellValue(i, "b_meas_qty_chk")) {
			SetCellFontColor(i, "b_meas_qty_chk",redColor);
					}

		if ("E" == GetCellValue(i, "b_cntr_mf_gds_desc")) {
			SetCellFontColor(i, "b_cntr_mf_gds_desc",redColor);
					}
		if ("E" == GetCellValue(i, "b_cntr_mf_mk_desc")) {
			SetCellFontColor(i, "b_cntr_mf_mk_desc",redColor);
					}
		if ("E" == GetCellValue(i, "b_cntr_mf_hts")) {
			SetCellFontColor(i, "b_cntr_mf_hts",redColor);
					}
		if ("E" == GetCellValue(i, "b_cntr_mf_ncm")) {
			SetCellFontColor(i, "b_cntr_mf_ncm",redColor);
					}
		if ("E" == GetCellValue(i, "b_cntr_mf_no")) {
			SetCellFontColor(i, "b_cntr_mf_no",redColor);
					}					

		if ("E" == GetCellValue(i, "b_cust_ct_s")) {
			SetCellFontColor(i, "b_cust_ct_s",redColor);				
		}					
		if ("E" == GetCellValue(i, "b_cust_cn_s")) {
			SetCellFontColor(i, "b_cust_cn_s",redColor);				
		}
		if ("E" == GetCellValue(i, "b_cust_ct_c")) {
			SetCellFontColor(i, "b_cust_ct_c",redColor);				
		}
		if ("E" == GetCellValue(i, "b_cust_st_c")) {
			SetCellFontColor(i, "b_cust_st_c",redColor);				
		}
		if ("E" == GetCellValue(i, "b_cust_cn_c")) {
			SetCellFontColor(i, "b_cust_cn_c",redColor);				
		}
				
		}
		
	}
}
/*
 *  Search Option or Item Option Modify
 * */
	function t1sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {
		if (colIdx == sheetObj.SaveNameCol("bkg_no")) {
			// 모달로 변경 2010.04.10
			//comBkgCallBkgDetail(sheetObj.GetCellValue(rowIdx, "bkg_no"));
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, "bkg_no"));
			
		} else if (colIdx == sheetObj.SaveNameCol("bl_no")) {
	var param="?bkg_no=" + sheetObj.GetCellValue(rowIdx, "bkg_no");
			
			//ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927.do" + param, "BL Preview", 1024, 740, true, "scrollbars=yes,resizable=yes");
			ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927_POP.do" + param, "BL Preview", 1024, 740, true, "scrollbars=yes,resizable=yes");
			
		}
	}
/*
 *  Search Option or Item Option Modify
 * */
	function t2sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {
		if (colIdx == sheetObj.SaveNameCol("b_bkg_no")) {
			// 모달로 변경 2010.04.10
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, "bkg_no"));
		} else if (colIdx == sheetObj.SaveNameCol("b_bl_no")) {
	var param="?pgmNo=ESM_BKG_0079&bkg_no=" + sheetObj.GetCellValue(rowIdx, "bkg_no");
		comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, "bkg_no"));
		}
	}
	function setTabTotalValue(val) {
		if ($('#tab1_TabAreaDiv').find('#tab_tot').length == 0) {
			$('#tab1_TabAreaDiv').append("<div id='tab_tot' style='font-size:12px;margin-top: 3px'>" + val +  "</div>");
		} else {
			$('#tab_tot').html(val);
		}
	}
/* 개발자 작업 끝 */
