/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1148.js
*@FileTitle  : Pakistan Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
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
 * @class ESM_BKG-1148 : ESM_BKG-1148 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
/* 개발자 작업 */
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var intervalId="";
var comboObjects=new Array();
var comboCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 var sheetObject=sheetObjects[0];
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_down_excel":
					if( beforetab == 0 ){
						doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
					} else if( beforetab == 1 ){
						doActionIBSheet(sheetObjects[1],document.form,IBDOWNEXCEL);
					} else {
						doActionIBSheet(sheetObjects[2],document.form,IBDOWNEXCEL);
					}
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	 /**
	  * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	  *
	  * @param {IBMultiCombo}
	  *            combo_obj IBMultiCombo Object
	  */
	 function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	 }
	 /**
	  * IBTab Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setTabObject(tab_obj){
		 tabObjects[tabCnt++]=tab_obj;
	 }
	 /**
	  * Tab 기본 설정
	  * 탭의 항목을 설정한다.
	  */
	 function initTab(tabObj , tabNo) {
		  switch(tabNo) {
			  case 1:
				 with (tabObj) {
					 var cnt=0 ;
					 InsertItem( "B/L Info" , "");
					 InsertItem( "CNTR Info" , "");
					 InsertItem( "Charge Info" , "");
				 }
			  break;
		  }
	 }
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		initControl();
	}
	 /**
	  * 조회조건 입력할 때 처리
	  */
	 function obj_KeyUp() {
		  var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		  var formObject=document.form;
		 var srcName=ComGetEvent("name");
		 var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		 var srcValue=window.event.srcElement.getAttribute("value");
		 if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		 }
	 }
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
		DATE_SEPARATOR="-";
		var formObject=document.form;
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListenerForm("change", "obj_OnChange", document.form);
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var sheetID=sheetObj.id;
		switch(sheetID) {
		case "sheet1":      //sheet1 init
			with(sheetObj){
				  var cnt=0;
				  SetAutoRowHeight(1);
				  var HeadTitle1="|Sel.|Seq.|Vessel|Voayge||BL No.|Shipper|Shipper|CNEE|CNEE|Notify|Notify|A/Notify|A/Notify|POL|POD|DEL|Last Port|R/D Term|BL Date|Customs Description|Marks & Nos|Description of Goods|"; //
				  var HeadTitle2="|Sel.|Seq.|Vessel|Voayge||BL No.|Name|Address|Name|Address|Name|Address|Name|Address|POL|POD|DEL|Last Port|R/D Term|BL Date|Customs Description|Marks & Nos|Description of Goods|";
				  var headCount=ComCountHeadTitle(HeadTitle1);
				  (headCount, 0, 0, true);

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"},
							  { Text:HeadTitle2, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vvd_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"voy_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"shpr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"shpr_addr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cnee_addr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_addr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"a_ntfy_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"a_ntfy_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"last_port",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rd_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"obl_iss_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cstms_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"mk_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"total_bl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				  InitColumns(cols);

				  SetEditable(1);
				  SetSheetHeight(400);
				}


		   break;
		case "sheet2":
			with(sheetObj){
					var cnt=0;
				  if (location.hostname != "")
				  var HeadTitle1="|sel.|Seq.|BL No.|CNTR No.|TS|HS Code|Customs D|Seal No.|Package|Package|Weight|Weight|Measure|Measure|Un No.|IMDG|SOC";
				  var headCount=ComCountHeadTitle(HeadTitle1);
				  (headCount, 0, 0, true);

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_hs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pck_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				  InitColumns(cols);

				  SetEditable(1);
				  SetSheetHeight(400);
				}
			break;
		case "sheet3":
			with(sheetObj){
					var cnt=0;
				  if (location.hostname != "")
				  var HeadTitle1="|Seq.|BL No.|Charge Code|Per|Currency|P/C|Amount";
				  var headCount=ComCountHeadTitle(HeadTitle1);
				  (headCount, 0, 0, true);

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"chg_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"frt_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"chg_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				  InitColumns(cols);

				  SetEditable(1);
				  SetSheetHeight(400);
				}
			break;
		}
	}
  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				formObj.f_cmd.value=SEARCH;
				var frobs=document.getElementsByName("port_flg");
				for (i=0; i < frobs.length; i++) {
					if (frobs[i].checked) {
						if (frobs[i].value == "pol") {
							formObj.pol_cd.value=formObj.pol_pod_cd.value;
							formObj.pod_cd.value="";
						} else {
							formObj.pod_cd.value=formObj.pol_pod_cd.value;
							formObj.pol_cd.value="";
						}
					}
				}
				var sXml=sheetObj.GetSearchData("ESM_BKG_1148GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
					sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
				}
				ComEtcDataToForm(formObj, sheetObj);
				ComOpenWait(false);
				sheetObj.SetWaitImageVisible(1);
				break;
			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
				break;
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				break;
			case IBDOWNEXCEL:
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;
		}
		return true;
	}
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab=nItem;
	}
	/**
	 * radio버튼 클릭에 따라 조건 검색을 바꿔준다.
	 * @param formObj
	 * @return
	 */
	function OnClickRadioButton(formObj) {
		var frobs=formObj.elements("port_flg");
		for (i=0; i < frobs.length; i++) {
			if (frobs[i].checked) {
				if (frobs[i].value == "pol") {
					formObj.pol_cd.value=formObj.pol_pod_cd.value;
				} else {
					formObj.pod_cd.value=formObj.pol_pod_cd.value;
				}
			}
		}
	}
	/**
	 * 시트를 클릭했을 때 처리
	 */
	function sheet1_OnClick(sheetObj, row, col) {
		var colSaveName=sheetObj.ColSaveName(col);
		switch(colSaveName) {
			case "vvd_nm" :
			case "shpr_nm" :
			case "shpr_addr" :
			case "cnee_nm" :
			case "cnee_addr" :
			case "ntfy_nm" :
			case "ntfy_addr" :
			case "a_ntfy_nm" :
			case "a_ntfy_addr" :
			case "cstms_desc" :
			case "mk_desc" :
			case "cmdt_desc" :
				/* 긴 문자열 MemoPad 처리*/
				if(sheetObj.GetCellValue(row,col) != "") {
					ComShowMemoPad(sheetObj, null, null, true, 250, 80);
				}
				break;
		} // end switch
	}
	 /**
	  * 시트를 클릭했을 때 처리
	  */
	 function sheet2_OnClick(sheetObj, row, col) {
		 var colSaveName=sheetObj.ColSaveName(col);
		 switch(colSaveName) {
			case "cntr_mf_gds_desc" :
				/* 긴 문자열 MemoPad 처리*/
				if(sheetObj.GetCellValue(row,col) != "") {
					ComShowMemoPad(sheetObj, null, null, true, 250, 80);
				}
				break;
		 } // end switch
	 }
