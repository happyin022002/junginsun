/*======================================================== =
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1506.js
*@FileTitle  : PSA DG EDI Transmit History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/07
======================================================== = */

//Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;

//Event handler processing by button click event */
document.onclick = processButtonClick;


	//Event handler processing by button name */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
//		try {
			var srcName = ComGetEvent("name");
				switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;

					case "btn_downexcel":
						if (sheetObject.RowCount() < 1) {
							ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
							return;
						}
						ComOpenWait(true);
						sheetObject.Down2Excel();
						ComOpenWait(false);
					break;

					case "btn_calendar":
						visibleFalse("2");
						var cal = new ComCalendarFromTo();
						cal.select(formObject.snd_dt_from, formObject.snd_dt_to, 'yyyy-MM-dd');
					break;

					case "vvd_cd" :
					case "port_cd" :
						visibleFalse("1");
					break;

					case "snd_dt_from" :
					case "snd_dt_to" :
						visibleFalse("2");
					break;

					case "search_type" :
						if(formObject.search_type[0].checked) {
							visibleFalse("1");
						} else {
							visibleFalse("2");
						}
					break;
			} // end switch
//		} catch(e) {
//			if( e == "[object Error]") {
//				ComShowMessage(OBJECT_ERROR);
//			} else {
//				ComShowMessage(e.message);
//			}
//		}
	}


	/**
	 * 조회조건 visible
	 * @param searchType ("1" : VVD, PORT 활성화, "2" : Transmit Date 활성화)
	 * @return
	 */
	function visibleFalse(searchType) {
		var formObject = document.form;
		if (searchType == "1") {
			formObject.vvd_cd.readOnly = false;
			formObject.vvd_cd.setAttribute("required", "");
			formObject.port_cd.readOnly = false;
			formObject.port_cd.setAttribute("required", "");

			formObject.snd_dt_to.value = "";
			formObject.snd_dt_to.removeAttribute("required");
			formObject.snd_dt_to.readOnly = true;

			formObject.snd_dt_from.value = "";
			formObject.snd_dt_from.removeAttribute("required");
			formObject.snd_dt_from.readOnly = true;
			formObject.search_type[0].checked = true;

		} else {
			formObject.snd_dt_to.readOnly = false;
			formObject.snd_dt_to.setAttribute("required", "");

			formObject.snd_dt_from.readOnly = false;
			formObject.snd_dt_from.setAttribute("required", "");

			formObject.vvd_cd.value = "";
			formObject.vvd_cd.removeAttribute("required");
			formObject.vvd_cd.readOnly = true;

			formObject.port_cd.value = "";
			formObject.port_cd.removeAttribute("required");
			formObject.port_cd.readOnly = true;

			formObject.search_type[1].checked = true;
			//날짜 셋팅
			if(formObject.snd_dt_from.value == "" && formObject.snd_dt_to.value == "") {
				formObject.snd_dt_from.value = ComGetDateAdd(null, 'd', -7, '-');
				formObject.snd_dt_to.value = ComGetNowInfo('ymd','-');
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//화면에서 필요한 이벤트
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetId = sheetObj.id;
		switch(sheetId) {
			case "sheet1":
				with(sheetObj) {
					SetSheetHeight(380);
					var HeadTitle1 = "|Seq|MSG Send Num|Send Date|Send User|MSG Func ID|DECL Type|VVD|Port";
					var headCount = ComCountHeadTitle(HeadTitle1);
					(headCount, 0, 0, true);
					SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );

					var info = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status", Hidden:1, Width:1,     Align:"Center",   SaveName:"ibflag"            },
								 {Type:"Seq",    Hidden:0, Width:40,    Align:"Center",   SaveName:"rcv_log_seq"       },
								 {Type:"Text",   Hidden:0, Width:200,   Align:"Center",   SaveName:"msg_snd_no"        },
								 {Type:"Date",   Hidden:0, Width:120,   Align:"Center",   SaveName:"snd_dt"            },
								 {Type:"Text",   Hidden:0, Width:120,   Align:"Center",   SaveName:"snd_usr_id"        },
								 {Type:"Text",   Hidden:0, Width:130,   Align:"Center",   SaveName:"msg_func_id"       },
								 {Type:"Text",   Hidden:0, Width:120,   Align:"Center",   SaveName:"psa_dg_decl_tp_cd" },
								 {Type:"Text",   Hidden:0, Width:120,   Align:"Center",   SaveName:"vvd_cd"            },
								 {Type:"Text",   Hidden:0, Width:110,   Align:"Center",   SaveName:"port_cd"           } ];
					InitColumns(cols);

					SetEditable(0);
				}
			break;
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //조회
				if (!ComChkValid(formObj)) return;
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_BKG_0573GS.do", FormQueryString(formObj));
			break;
		}
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction){
		switch (sAction) {
			case IBSEARCH:
				// from - to 범위값이 31일이 넘으면 오류
				if(ComGetDaysBetween(formObj.snd_dt_from.value, formObj.snd_dt_to.value) > 30) {
					ComShowCodeMessage('BKG00605');
					ComSetFocus(formObj.snd_dt_to);
					return false;
				}
			break;
		} // end switch
		return true;
	}
