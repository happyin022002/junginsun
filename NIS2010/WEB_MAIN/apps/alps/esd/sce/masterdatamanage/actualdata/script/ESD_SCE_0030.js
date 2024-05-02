/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0030.js
*@FileTitle : Actual Source Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-31 Seong-mun Kang
* --------------------------------------------------------
* History
* 2013.05.14 김상수 [CHM-201324115] Actual Data Receiving Status 보완요청
*                    - CNTR no 입력후 retrieve 시 다른 조회 조건은 필요하지 않도록 로직 수정
*                    - CNTR No.가 없는 건 (SMCU0000000) 대상에서 제외
*                    - EDI MSG ID, EDI 컬럼을 Service Provider 앞 위치로 이동시키고 그 위치에 VVD 컬럼 추가
*                    - On Time 정렬기능 추가
*                    - Activity 컬럼 앞에 Activity Code 컬럼 추가
* 2013.06.21 김상수 [CHM-201324903] Actual Data Receiving Status 보완요청(추가)
*                    - 조회조건에 다건의 Yard Code 입력 가능하게 수정
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var onTimeClick = 0 ;

document.onclick = processButtonClick;

function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObj = sheetObjects[0];
	 /*******************************************************/
	 var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			break;

			case "btn_new":
				sheetObj.RemoveAll();
				comboObjects[0].Index =0;
				formObj.reset();
			break;

			case "btn_downexcel":
				sheetObj.Down2Excel(-1);
			break;

			case "btn_calendar" :
				cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.act_dt1, formObj.act_dt2, 'yyyy-MM-dd');
			break ;

			case "search_div":    // Retrieve
				with (formObj) {
					if (formObj.search_div[0].checked) {
						nod_cd_display.className = "input1";
						act_dt1.className = "input1";
						act_dt2.className = "input1";
						cntr_no_nonbit.className = "input";
						cntr_no_split.className = "input";
						nod_cd_display.focus();
					} else {
						nod_cd_display.className = "input";
						act_dt1.className = "input";
						act_dt2.className = "input";
						cntr_no_nonbit.className = "input1";
						cntr_no_split.className = "input1";
						cntr_no_nonbit.focus();
					}
				}
			break;

		} // end switch
	} catch(e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111") ;
		} else {
			ComShowMessage(e);
		}
	}
}

function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Combo Object를 배열로 등록
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	setActivity_Combo(); //Activity 콤보 세팅

	document.form.nod_cd_display.focus();
}

function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				style.height = 355 ;
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, document.form.row_size.value);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(22, 0, 0, true);

				//헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
				InitHeadMode(true, true, true, true, false, false)

				var HeadTitle = "Container|COP No.|BKG No.|Yard|Activity|Activity Name|RCV\nType|MVMT\nSTS|VVD|Planned\nDate/Time|Planned\nDate/Time|Actual\nDate/Time|Actual\nDate/Time|On\nTime|User Name|Receiving\nDate/Time|Receiving\nDate/Time|EDI\nMSG ID|EDI|Service Provider|non_on_time|on_time";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 		SAVENAME, 		  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,	  90,   daCenter,  false,	"cntr_no");
				InitDataProperty(0, cnt++ , dtData,	  100,   daCenter,  false,	"cop_no");
				InitDataProperty(0, cnt++ , dtData,	  90,   daCenter,  false,	"bkg_no");
				InitDataProperty(0, cnt++ , dtData,	  60,   daCenter,  false,	"nod_cd");
				InitDataProperty(0, cnt++ , dtData,	  60,   daCenter,  false,	"act_cd");
				InitDataProperty(0, cnt++ , dtData,	 180,   daCenter,  false,	"act_nm");
				InitDataProperty(0, cnt++ , dtData,	  50,   daCenter,  false,	"act_rcv_tp_nm");
				InitDataProperty(0, cnt++ , dtData,	  40,   daCenter,  false,	"stnd_edi_sts_cd");
				InitDataProperty(0, cnt++ , dtData,   70,   daCenter,  false,	"vvd");
				InitDataProperty(0, cnt++ , dtData,   70,   daCenter,  false,	"pln_date");
				InitDataProperty(0, cnt++ , dtData,   35,   daCenter,  false,	"pln_time");
				InitDataProperty(0, cnt++ , dtData,	  70,   daCenter,  false,	"act_date");
				InitDataProperty(0, cnt++ , dtData,   35,   daCenter,  false,	"act_time");
				InitDataProperty(0, cnt++ , dtImage,  40,   daCenter,  false,	"on_time_ck");
				InitDataProperty(0, cnt++ , dtData,	  80,   daCenter,  false,	"usr_id");
				InitDataProperty(0, cnt++ , dtData,	  70,   daCenter,  false,	"rcv_date");
				InitDataProperty(0, cnt++ , dtData,	  35,   daCenter,  false,	"rcv_time");
				InitDataProperty(0, cnt++ , dtData,	  50,   daCenter,  false,	"act_sts_mapg_cd");
				InitDataProperty(0, cnt++ , dtData,	  70,   daCenter,  false,	"edi_msg_tp_cd");
				InitDataProperty(0, cnt++ , dtData,	 100,   daCenter,  false,	"vndr_seq");

				InitDataProperty(0, cnt++ , dtHidden, 35,   daCenter,  false,	"non_on_time");
				InitDataProperty(0, cnt++ , dtHidden, 35,   daCenter,  false,	"on_time");

				ImageList(0) = "img/alps/ico_b1.gif";
				ImageList(1) = "img/alps/ico_r.gif";
		}
		break;

	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:    // 조회
			if (validateForm(formObj)) {
				formObj.f_cmd.value = SEARCHLIST;
				if (formObj.nod_cd_display.value == "") {
					formObj.nod_cd.value = "";
				} else {
					formObj.nod_cd.value = ("'" + ComReplaceStr(formObj.nod_cd_display.value, ",", "', '") + "'");
				}
				sheetObj.DoSearch4Post("ESD_SCE_0030Search.do", SceFrmQryString(formObj));//, + "&" + sheetObjects[0].GetSaveString() );
			}
			break;
	}
}


function validateForm(formObj) {
	var result = true;

	with (formObj) {
		if (formObj.search_div[0].checked) {
			if (nod_cd_display.value == "") {
				ComShowCodeMessage("SCE90016");
				ComSetFocus(nod_cd_display);
				result = false;
			} else {
				var nodCd = nod_cd_display.value.split(",");
				if (nodCd.length < 2) {
					if (nodCd[0].length < 7 || nodCd[0].length > 7) {
						ComShowCodeMessage("SCE90039");    // "Node is 7 characters long."
						ComSetFocus(nod_cd_display);
						result = false;
					} else if (act_dt1.value == "") {
						ComShowCodeMessage("SCE90003", "Duration");    // "{?msg1}.\n\n Please enter correct date.\n\n Format : YYYY-MM-DD"
						ComSetFocus(act_dt1);
						result = false ;
					} else if (act_dt2.value == "") {
						ComShowCodeMessage("SCE90003", "Duration");    // "{?msg1}.\n\n Please enter correct date.\n\n Format : YYYY-MM-DD"
						ComSetFocus(act_dt2);
						result = false;
					} else {
						if (dateCalcuration_sce(act_dt1.value, act_dt2.value) > 31) {
							ComShowMessage("Max term of Duration should be under one month!\n\nNo limit of Duration for container no.");
							ComSetFocus(act_dt1);
							result = false;
						}
					}
				} else {
					for (var i=0; i<nodCd.length; i++) {
						if (nodCd[i].length < 7 || nodCd[i].length > 7) {
							ComShowCodeMessage("SCE90039");    // "Node is 7 characters long."
							ComSetFocus(nod_cd_display);
							result = false;
							break;
						}
					}
					if (result) {
						if (act_dt1.value == "") {
							ComShowCodeMessage("SCE90003", "Duration");    // "{?msg1}.\n\n Please enter correct date.\n\n Format : YYYY-MM-DD"
							ComSetFocus(act_dt1);
							result = false ;
						} else if (act_dt2.value == "") {
							ComShowCodeMessage("SCE90003", "Duration");    // "{?msg1}.\n\n Please enter correct date.\n\n Format : YYYY-MM-DD"
							ComSetFocus(act_dt2);
							result = false;
						} else {
							if (dateCalcuration_sce(act_dt1.value, act_dt2.value) > 7) {
								ComShowMessage("Max term of duration should be under one week for multiple yards.\n\nNo limit of Duration for container no.");
								ComSetFocus(act_dt2);
								result = false;
							}
						}
					}
				}
			}

		} else {
			if (cntr_no_nonbit.value == "") {
				ComShowCodeMessage("SCE90016");
				ComSetFocus(cntr_no_nonbit);
				result = false;
			} else if (nod_cd_display.value != "") {
				var nodCd = nod_cd_display.value.split(",");
				if (nodCd.length < 2) {
					if (nodCd[0].length < 7 || nodCd[0].length > 7) {
						ComShowCodeMessage("SCE90039");    // "Node is 7 characters long."
						ComSetFocus(nod_cd_display);
						result = false;
					}
				} else {
					for (var i=0; i<nodCd.length; i++) {
						if (nodCd[i].length < 7 || nodCd[i].length > 7) {
							ComShowCodeMessage("SCE90039");    // "Node is 7 characters long."
							ComSetFocus(nod_cd_display);
							result = false;
							break;
						}
					}
				}
			} else if (act_dt1.value != "" && act_dt2.value == "") {
				ComShowCodeMessage("SCE90003", "Duration");    // "{?msg1}.\n\n Please enter correct date.\n\n Format : YYYY-MM-DD"
				ComSetFocus(act_dt2);
				result = false;
			} else if (act_dt1.value == "" && act_dt2.value != "") {
				ComShowCodeMessage("SCE90003", "Duration");    // "{?msg1}.\n\n Please enter correct date.\n\n Format : YYYY-MM-DD"
				ComSetFocus(act_dt1);
				result = false;
			}
		}
	}
	return result;
}


function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	var formObj = document.form ;
	selectVal = SceFrmQryString(formObj);
	sheetObj.DoSearch4Post("ESD_SCE_0030Search.do", selectVal, "cur_page=" + PageNo, true);
}


/**
 * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet Object
 * @param {Button} Integer 마우스버튼 방향, 1:왼쪽, 2:오른쪽
 * @param {Shift} Integer Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {X} Long X 좌표
 * @param {Y} Long Y 좌표
 */
function sheet1_OnMouseDown(sheetObj, Button, Shift) {
	with (sheetObj) {
		if (MouseRow == 0 && SaveNameCol("on_time_ck") == MouseCol) {
			if (onTimeClick == 0) {
				ColumnSort("on_time", "ASC");
				onTimeClick = 1;
			} else {
				ColumnSort("on_time", "DESC");
				onTimeClick = 0;
			}
		}
	}
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	if (ErrMsg != "") return;
	var formObj = document.form;
	if (sheetObj.RowCount > 0) {
		formObj.on_time_cnt.value = sheetObj.ComputeSum("on_time");
		formObj.not_on_time_cnt.value = sheetObj.ComputeSum("non_on_time");
	} else {
		formObj.on_time_cnt.value = "";
		formObj.not_on_time_cnt.value = "";
	}
}


/**
 * 날짜에 빼기에 대한 유효성을 체크
 * trs_common.js 에서 차용
 */
function dateCalcuration_sce (objFrom, objTo) {
	var lvfrmDate = doSepRemove(doSepRemove(objFrom, " "), "-");
	var lvtoDate = doSepRemove(doSepRemove(objTo, " "), "-");
	var lvFrom = lvfrmDate.substring(4, 6)+"-"+lvfrmDate.substring(6)+"-"+lvfrmDate.substring(0, 4);
	var lvTo = lvtoDate.substring(4, 6)+"-"+lvtoDate.substring(6)+"-"+lvtoDate.substring(0, 4);
	var fromDay = new Date(lvFrom);
	var toDay = new Date(lvTo);
	var objFT = (toDay.getTime()-fromDay.getTime()) / (24*60*60*1000);
	return objFT;
}


function comboChange(){
}


function CheckDigit(obj){
	var rtnval = cntrCheckDigit(obj);
	obj.value  = rtnval;
}


// Container No. 의 CheckDigit 을 설정.
function CheckDigitSplit(obj, bitTarget, valueTarget){
	var cntrNo = obj.value;
	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = cntrNo;
		return;
	}
	chkField(obj, 'eng_num', true, 10)
	var sum = 0;
	cntrNo = cntrNo.toUpperCase();

	for(var i=0;i<10;i++){
		sum = sum + productValue(cntrNo.charAt(i),i);
	}
	var mod = sum % 11;

	if (mod == 10) mod =0;

	if( isNaN(mod)){
		document.getElementById(bitTarget).value = '';
		document.getElementById(valueTarget).value = obj.value;
	}else{
		document.getElementById(bitTarget).value = mod;
		document.getElementById(valueTarget).value = obj.value + mod;
	}
}


/*
function act_OnChange(obj){
	if(obj.value=="Y"){
		sheetObjects[0].ColHidden("act_date") = false;
		sheetObjects[0].ColHidden("act_time") = false;
		sheetObjects[0].ColHidden("pln_date") = true;
		sheetObjects[0].ColHidden("pln_time") = true;
	}else{
		sheetObjects[0].ColHidden("act_date") = true;
		sheetObjects[0].ColHidden("act_time") = true;
		sheetObjects[0].ColHidden("pln_date") = false;
		sheetObjects[0].ColHidden("pln_time") = false;
	}
}
*/


/* Activity 콤보 가져옴 */
function setActivity_Combo(){
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH01;
	var sRhqXml = sheetObjects[0].GetSearchXml("ESD_SCE_0030Search.do", FormQueryString(formObj));
	comboObjects[0].DropHeight=180;
	ComXml2ComboItem(sRhqXml, comboObjects[0], "act_cd", "act_cd|act_nm");
	comboObjects[0].Index =0;
}
