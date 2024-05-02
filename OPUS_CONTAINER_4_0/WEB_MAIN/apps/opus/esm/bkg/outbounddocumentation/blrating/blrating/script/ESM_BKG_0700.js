/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0700.js
*@FileTitle  : CAF Adjustment 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
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
 * @class esm_bkg_0700 : esm_bkg_0700 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var btn_calc=false;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
		fn_InitProperty();
		initControl();
		for (i=0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		var Row=sheetObjects[0].DataInsert(-1);
	}
	function initControl() {
		DATE_SEPARATOR="-";
		var formObject=document.form;
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // -포커스나갈때
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); // -포커스들어갈때
	}
	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_deactivate() {
		var formObj=document.form;
		//입력Validation 확인하기
		switch (ComGetEvent("name")) {
		case "caf_percentage":
			var val=parseFloat(formObj.caf_percentage.value);
			formObj.caf_percentage.value=val.toFixed(2);
			break;
		default:
			break;
		}
	}
	/**
	 * fn_InitProperty 이벤트 처리<br>
	 * selectCombo box 초기화 및 데이터를 생성한다. <br>
	 * @param 
	 * @exception EventException
	 */
	var CAF_MAP=null;
	var CAF_Value_Box=null;
	var CAF_Text_Box=null;
	var CAF_Exist=false;
	var CAF_Row=0;
	function fn_InitProperty() {
		var formObj=document.form;			
		var opener = window.dialogArguments;		
		if (!opener) {
			opener=parent;
			CAF_MAP= opener.CAF_MAP;
		}		
		if (CAF_MAP.getTextString() == "") {
			ComShowMessage(ComGetMsg("BKG00701", "Booking Rate"));
			ComClosePopup(); 
		} else {
			CAF_Text_Box=' ' + CAF_MAP.getTextString();
			CAF_Value_Box=' ' + CAF_MAP.getKeyString();
		}		
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: //sheet1 init
		    with(sheetObj){
			      var HeadTitle=" | |Charges Included to CAF|Charges Included to CAF|Charges Included to CAF";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"Status" },
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
			             {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"charge_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"charge_cur",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"charge_rate",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetShowButtonImage(2);
			      SetColProperty("charge_cd", {ComboText:CAF_Text_Box, ComboCode:CAF_Value_Box} );
//			      SetSheetHeight(122);
			      SetSheetHeight(135);
	      		}
			break;
		}
	}
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_calc":
				if (sheetObject.LastRow()== 0)
					return;
				if (ComGetObjValue(formObj.caf_percentage) == '') {
					ComShowMessage(ComGetMsg("BKG00992", "CAF Percentage"));
					return;
				}
				var caf_sum=0;
				var cnt=sheetObject.LastRow();
				for ( var i=1; i <= cnt; i++) {
					if (sheetObject.GetCellValue(i, 'charge_cur') == "") {
						sheetObject.RowDelete(i, false);
					}
				}
				// 화폐단위표시 
				var cur_charge=sheetObject.GetCellValue(1, 'charge_cur');
				if (typeof cur_charge == "undefined" && cur_charge == "")return;
				ComSetObjValue(formObj.caf_currency, cur_charge);
				var tcnt=sheetObject.LastRow();
				for ( var ix=1; ix <= tcnt; ix++) {
					caf_sum=caf_sum + parseFloat(sheetObject.GetCellValue(ix, 'charge_rate'));
				}
				ComSetObjValue(formObj.caf_sum, caf_sum);
				var result=caf_sum * (ComGetObjValue(formObj.caf_percentage) / 100);
				result=ComRound(result, 2);// 소수점 2자리로 요청
				ComSetObjValue(formObj.caf_amount, result);
				ComSetObjValue(formObj.caf_amount, ComAddComma2(formObj.caf_amount, "#,###.00"));
				btn_calc=true;
				break;
			case "btn_apply":
				if (!btn_calc) {
					return;
				} else {
					var caf_sum=0;
					var cnt=sheetObject.LastRow();
					for ( var i=1; i <= cnt; i++) {
						if (sheetObject.GetCellValue(i, 'charge_cur') == "") {
							sheetObject.RowDelete(i, false);
						}
					}
					// 화폐단위표시 
					if (sheetObject.LastRow()> 1) {
						ComSetObjValue(formObj.caf_currency, sheetObject.GetCellValue(1, 'charge_cur'));
					}
					var tcnt=sheetObject.LastRow();
					for ( var ix=1; ix <= tcnt; ix++) {
						caf_sum=caf_sum + parseFloat(sheetObject.GetCellValue(ix, 'charge_rate'));
					}
					ComSetObjValue(formObj.caf_sum, caf_sum);
					var result=caf_sum * (ComGetObjValue(formObj.caf_percentage) / 100);
					result=ComRound(result, 2);// 소수점 2자리로 요청
					ComSetObjValue(formObj.caf_amount, result);
					ComSetObjValue(formObj.caf_amount, ComAddComma2(formObj.caf_amount, "#,###.00"));
				}
				//기본값 셋팅
				var obj=new Object();
				obj.caf_charge='CAF';
//				obj.caf_cur=first_currency;
				obj.caf_cur=ComGetObjValue(formObj.caf_currency);
				obj.caf_per='PC';
				obj.caf_rate=ComGetObjValue(formObj.caf_sum); //결과값
				obj.caf_rate_as=ComGetObjValue(formObj.caf_percentage);//결과값
				obj.caf_amount=ComGetObjValue(formObj.caf_amount);//결과값			
				ComPopUpReturnValue(obj);
				ComClosePopup(); 
				break;
			case "btn_add":
				var charge_cur=sheetObject.GetCellValue(sheetObject.LastRow(), "charge_cur");
				if (typeof charge_cur != "undefined" && charge_cur != "") {
					var Row=sheetObject.DataInsert(-1);
				}
				break;
			case "btn_del":
				if (sheetObject.RowCount()== 0)
					return;
				if (sheetObject.FindCheckedRow("del_chk") != "") {
					ComRowHideDelete(sheetObject, "del_chk");
				} else {
					ComShowCodeMessage("BKG00333");
				}
				break;
			case "btn_new":
				if (!confirm(ComGetMsg("BKG08094")))
					return;
				ComResetAll();
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	var first_currency='';
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		if (sheetObj.ColSaveName(Col) != "charge_cd")
			return; // 체크컬럼이 바뀐경우만 아래 코드 처리
		var Col2=sheetObj.SaveNameCol("charge_cd"); // 선택된 sheet 컬럼 위치
		var type_charge=sheetObj.GetCellText(Row, Col2); // 선택된 Text 값
		if (typeof CAF_MAP.get(type_charge) == "undefined") {
			sheetObj.SetCellValue(Row, 'charge_cd',"",0);
			sheetObj.SetCellValue(Row, 'charge_cur',"",0);
			sheetObj.SetCellValue(Row, 'charge_rate',"",0);
			return;
		}
		// 화폐값 얻기 
		var currency=CAF_MAP.get(type_charge).currency;
		if (first_currency == '') {
			if (CAF_MAP.containsKey("CAF")) {
				first_currency=CAF_MAP.get("CAF").currency;
			} else {
				first_currency=currency;
			}
		}
		//정상값 셋팅 
		sheetObj.SetCellValue(Row, 'charge_cd',CAF_MAP.get(type_charge).charge,0);
		sheetObj.SetCellValue(Row, 'charge_cur',CAF_MAP.get(type_charge).currency,0);
		sheetObj.SetCellValue(Row, 'charge_rate',CAF_MAP.get(type_charge).amount,0);
		// 통화가 다르면 선택불가
//		if (first_currency != currency) {
//			//alert(first_currency+"::"+currency);
//			ComShowMessage(ComGetMsg("BKG00883")); //Please Check The Currency Code of Charge In CAF
//			sheetObj.SetCellValue(Row, 'charge_cd',"",0);
//			sheetObj.SetCellValue(Row, 'charge_cur',"",0);
//			sheetObj.SetCellValue(Row, 'charge_rate',"",0);
//		}
	}
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * 입력된 숫자값을 지정된 소숫점 자릿수로 Round해서 값을 리턴한다.<p>
	 * ex) fncRoundPrecision(300.12345678,3) <p>
	 * Result ) 300.123
	 * @param {Number} val 반올림할 값
	 * @param {Number} precision 소숫점 자리수
	 * @return 지정한 소숫점 자리수에 따른 반올림 값
	 * @type Number
	 * @author Lee Jeong Hak
	 * @version 1.0
	 */
	function fncRoundPrecision(val, precision) {
		var p=Math.pow(10, precision);
		return Math.round(val * p) / p;
	}
	/* 개발자 작업  끝 */