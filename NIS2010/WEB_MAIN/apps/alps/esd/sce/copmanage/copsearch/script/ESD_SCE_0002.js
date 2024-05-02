// 공통전역변수
var selectVal = "" ;
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_copchange":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					if(sheetObj.CheckedRows("chk")>0) {
						var iCheckRow = sheetObj.FindCheckedRow("chk");
						var copNo = "";

						//가져온 행을 배열로 반든다.
						var arrRow = iCheckRow.split("|");
						var nodeCd = sheetObj.CellValue(arrRow[0] , "r_nod_cd") ;

						for (idx=0; idx<arrRow.length-1; idx++) {
							if( sheetObj.CellValue(arrRow[idx], "r_cop_sub_sts_cd") == "R" && sheetObj.CellValue(arrRow[idx], "r_cop_sts_cd") == "F" ) {
								if(nodeCd!==sheetObj.CellValue(arrRow[idx],"r_nod_cd")){
									ComShowMessage(getMsg('SCE90010', 'Current Location')) ;
									return ;
								} else {
									if(idx > 0){
										copNo += "<>" ;
									}
									copNo += sheetObj.CellValue( arrRow[idx] , "cop_no");
								}
							} else {
								if(nodeCd!==sheetObj.CellValue(arrRow[idx],"r_nod_cd")){
									ComShowMessage(getMsg('SCE90010', 'Current Location')) ;
									return ;
								} else if(isEmpty2(sheetObj.CellValue(arrRow[idx],"r_act_nm"))) {
									ComShowMessage(getMsg('SCE90012')) ;
									return ;
								} else {
									if(idx > 0){
										copNo += "<>" ;
									}
									copNo += sheetObj.CellValue( arrRow[idx] , "cop_no");
								}
							}
						}
						formObj.cop_no.value = copNo;
						window.open ("ESD_SCE_0053.do?cop_no=" + formObj.cop_no.value, "list", "scrollbars=no,fullscreen=no,width=415,height=195");
					} else {
						ComShowMessage(getMsg('COM12113', 'COP')) ;
					}
				}
			break;

			case "btn_bkginfo":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					openESD_SCE_0915(sheetObj);
				}
			break;

			case "btn_batchupdate":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					openESD_SCE_0010(sheetObj);
				}
			break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
			break;

			case "btn_statuschange":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;
			// minestar - COP-History 관련 시작
			case "btn_history":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					formObj.cop_no.value =  sheetObj.CellValue(sheetObj.FindCheckedRow("chk").substring(0,1), 'cop_no');
					window.open ("ESD_SCE_0071.do?cop_no="+ formObj.cop_no.value	 , "list", "scrollbars=no,fullscreen=no,width=800,height=600,resizable");
				}
			break;
			// minestar - COP-History 관련 끝

            // 20080731 - COP-Inquiry 신용호
			case "btn_mastersave":
			     window.open("ESD_SCE_0118.do","Master","scrollbars=no,fullscreen=no,width=1300,height=670,resizable");
			break;
/* 20070927 삭제 요청
			case "btn_terminalchange":
				if( ibSheet_BKGCheck(sheetObj, "chk") ) {
					window.open ("ESD_SCE_0055.do?VVD_POP=Y", "list", "scrollbars=no,fullscreen=no,width=530,height=150");
				}
			break;
*/
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
		} else {
			ComShowMessage(e) ;
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function openESD009Screen(openStr){
	window.open(openStr, "list2", "scrollbars=no,fullscreen=no,width=1020,height=550");
}

//function vvdTerminalUpdate(vvd, nod_cd, call_port){
//	var sheetObj = sheetObjects[0];
//	var formObj = document.form;
//	formObj.vvd.value = vvd;
//	formObj.nod.value = nod_cd;
//	formObj.port.value = call_port;
//	formObj.f_cmd.value = SEARCHLIST01;
//	formObj.target = "_self" ;
//	sheetObj.DoSearch4Post("/hanjin/ESD_SCE_0002GS.do", SceFrmQryString(formObj));
//}

function researchScreen(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];
	/*******************************************************/
	var formObj = document.form;

	try {
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	} catch(e) {
		if( e == "[object Error]" ) {
			ComShowMessage(getMsg('COM12111')) ;
		} else {
			ComShowMessage(e) ;
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				style.height = 380 ;
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, document.form.row_size.value);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(30, 8, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle0 = "|STS|Expt|COP No|COP BKG Seq|COP DTL Seq|BKG No|BKG No|Container No|TP/SZ|VOL|Master|COP\nStatus CD|COP\nStatus|Status\nChange|Activity Code|Current\nActivity|Current\nLocation|Planned D/T|Planned D/T|Estimated D/T|Estimated D/T|Delivery Planned D/T|Delivery Planned D/T|Delivery Estimated D/T|Delivery Estimated D/T|Delivery Appointment D/T|Delivery Appointment D/T" ;
				var HeadTitle1 = "|STS|Expt|COP No|COP BKG Seq|COP DTL Seq|No|Split|Container No|TP/SZ|VOL|Master|COP\nStatus CD|COP\nStatus|Status\nChange|Activity Code|Current\nActivity|Current\nLocation|Date|Time|Date|Time|Date|Time|Date|Time|Date|Time" ;

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,    SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "chk", false, "", dfNone, 0, true, true);//check box
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtImage, 40, daCenter, true, "cop_ext_sts_cd", false, "", dfNone, 0, false, true);//Exception
				InitDataProperty(0, cnt++, dtData, 106, daCenter, true, "cop_no", false, "", dfNone, 0, false, true);//COP No
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "r_cop_grp_seq", false, "", dfNone, 0, false, true);//COP BKG seq
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "r_cop_dtl_seq", false, "", dfNone, 0, false, true);//COP DTL seq
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "r_bkg_no", false, "", dfNone, 0, false, true);//BKG No
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "r_bkg_no_split", false, "", dfNone, 0, false, true);//BKG Split No
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "r_cntr_no_v", false, "", dfNone, 0, false, true);//Container No
				InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "r_cntr_tpsz_cd", false, "", dfNone, 0, false, true);//Container Type Size
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "", false, "", dfNone, 0, false, true);// Container Vol
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cop_mst_bkg", false, "", dfNone, 0, false, true);// Partial Container ( Master)
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "r_cop_sts_cd", false, "", dfNone, 0, false, true);//COP Status CD
				InitDataProperty(0, cnt++, dtData, 70, daLeft,   true, "r_cop_sts", false, "", dfNone, 0, false, true);//COP Status
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "cop_sub_sts_cd", false, "", dfNone, 0, true, true);//COP Status
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft,  true, "r_act_cd", false, "", dfNone, 0, false, true);//Current Activities
				InitDataProperty(0, cnt++, dtData, 150, daLeft,  true, "r_act_nm", false, "", dfNone, 0, false, true);//Current Activities
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "r_nod_cd", false, "", dfNone, 0, false, true);//Current Location
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "", false, "", dfDateYmd, 0, false, true);//Planned Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "", false, "", dfTimeHm, 0, false, true);//Planned Time
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "", false, "", dfDateYmd, 0, false, true);//Estimated Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "", false, "", dfTimeHm, 0, false, true);//Estimated Time
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "", false, "", dfDateYmd, 0, false, true);//Delivery Planned Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "", false, "", dfTimeHm, 0, false, true);//Delivery Planned Time
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "", false, "", dfDateYmd, 0, false, true);//Delivery Estimated Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "", false, "", dfTimeHm, 0, false, true);//Delivery Estimated Time
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "", false, "", dfDateYmd, 0, false, true);//Delivery Apointment Date
				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "", false, "", dfTimeHm, 0, false, true);//Delivery Apointment Time
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "r_cntr_no", false, "", dfNone,   0,     false,  true);//Delivery Apointment Time
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "r_cop_sub_sts_cd", false, "", dfNone, 0, false, true);

				ImageList(0) = "/hanjin/img/alps/ico_b.gif" ;
				ImageList(1) = "/hanjin/img/alps/ico_g.gif" ;
				ImageList(2) = "/hanjin/img/alps/ico_r.gif" ;

				InitDataCombo(0, 'cop_sub_sts_cd', 'YES|NO', 'Y|N');

				DataLinkMouse = true;
			}
		break;
	}
}

function sheet1_OnDblClick(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "cop_sub_sts_cd" ) {

	} else {
		newForm  = "<form name='form1' method='post'>" ;
		newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.CellValue(row, "cop_no") + "'>" ;
		newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(row, "r_bkg_no") + "'>" ;
		newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(row, "r_bkg_no_split") + "'>" ;
		newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(row, "r_cntr_no") + "'>" ;
		newForm += "  <input type='hidden' name='cop_mst_bkg'      value='" + sheetObj.CellValue(row, "cop_mst_bkg") + "'>" ;
		newForm += "</form>"
		document.all.new_form.innerHTML = newForm ;
		var formObj = document.form1 ;
		formObj.action = "ESD_SCE_0006.do";
		formObj.submit() ;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			//       if(!comCheckRequiredField(formObj)) return;
			formObj.f_cmd.value = SEARCHLIST;
			formObj.target = "_self" ;
			sheetObj.DoSearch4Post("/hanjin/ESD_SCE_0002GS.do", SceFrmQryString(formObj));
		break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel(-1, false, false, true);
		break;
		case IBSAVE:
			if( sheetObj.CheckedRows("chk") < 1 ) {
				ComShowMessage("Please select at least one.");
				return false;
			} else {
				if( confirm("Are you sure you want to proceed?") ) {
					formObj.f_cmd.value = MODIFY;
					sheetObj.DoSave("ESD_SCE_0002GS.do", SceFrmQryString(formObj), "chk", false, true);
				}
			}
		break;
	}
}

function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow) {
	var formObj = document.form ;
	selectVal = SceFrmQryString(formObj);
	sheetObj.DoSearch4Post("/hanjin/ESD_SCE_0002GS.do", selectVal, "cur_page=" + PageNo, true);
}

function openESD_SCE_0915(sheetObj){
	var row = sheetObj.SelectRow  ;
	var bkgNo      = sheetObj.CellValue(row, "r_bkg_no") ;
	var bkgNoSplit = sheetObj.CellValue(row, "r_bkg_no_split") ;
	var copno = sheetObj.CellValue(row, "cop_no") ;

	newForm  = "<form name='form1' method='post'>" ;
	newForm += "  <input type='hidden' name='bkg_no'       value='" + bkgNo + "'>" ;
	newForm += "  <input type='hidden' name='bkg_no_split' value='" + bkgNoSplit + "'>" ;
	newForm += "  <input type='hidden' name='cop_no' value='" + copno + "'>" ;
	newForm += "</form>"

	document.all.new_form.innerHTML = newForm ;

	var formObj = document.form1 ;
	var newWin  = window.open("","bkg_info_win", "width=810,height=425," + getCenterXY(810, 425));
	formObj.action = "/hanjin/ESD_SCE_0915.do" ;
	formObj.target = "bkg_info_win" ;
	formObj.submit() ;
}

/**
 * Batch Update 창 오픈
 */
function openESD_SCE_0010(sheetObj) {
	var chkCnt = sheetObj.CheckedRows(0) ;

	if( chkCnt==0 ) {
		ComShowMessage(getMsg('COM12113', 'COP')) ;
		return false ;
	}

	var chkRows = sheetObj.FindCheckedRow(0) ;
	var arrChkRows = chkRows.split("|") ;
	var newForm = "" ;

	newForm += "<form name='form1' method='post'>" ;
	for(i=0 ; i<arrChkRows.length-1; i++) {
		if( sheetObj.CellValue(arrChkRows[i], "r_cop_sts_cd")!="T" && sheetObj.CellValue(arrChkRows[i],"r_cop_sts_cd")!="C" ) {
			ComShowMessage(getMsg('SCE90011')) ;
			return false ;
		}
		newForm += "  <input type='hidden' name='cop_no'      value='" + sheetObj.CellValue(arrChkRows[i], "cop_no") + "'>" ;
		newForm += "  <input type='hidden' name='cop_grp_seq' value='" + sheetObj.CellValue(arrChkRows[i], "r_cop_grp_seq") + "'>" ;
		newForm += "  <input type='hidden' name='cop_dtl_seq' value='" + sheetObj.CellValue(arrChkRows[i], "r_cop_dtl_seq") + "'>" ;
		newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(arrChkRows[i], "r_bkg_no") + "'>" ;
		newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(arrChkRows[i], "r_bkg_no_split") + "'>" ;
		newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(arrChkRows[i], "r_cntr_no") + "'>" ;
		newForm += "  <input type='hidden' name='act_cd'      value='" + sheetObj.CellValue(arrChkRows[i], "r_act_cd") + "'>" ;
		newForm += "  <input type='hidden' name='act_nm'      value='" + sheetObj.CellValue(arrChkRows[i], "r_act_nm") + "'>" ;
		newForm += "  <input type='hidden' name='nod_cd'      value='" + sheetObj.CellValue(arrChkRows[i], "r_nod_cd") + "'>" ;
	}
	newForm += "</form>" ;
	document.all.new_form.innerHTML = newForm ;
	var formObj = document.form1 ;
	var newWin  = window.open("","cop_batch_update", "width=704,height=166," + getCenterXY(704, 166));
	formObj.action = "/hanjin/ESD_SCE_0010.do" ;
	formObj.target = "cop_batch_update" ;
	formObj.submit() ;
	newWin.focus() ;
}

function getCenterXY(w, h){
	var height = screen.availHeight ;
	var width = screen.availWidth ;
	var leftpos = width/2 - w/2;
	var toppos = height/2 - h/2;

	if(leftpos<0) leftpos=0;
	if(toppos<0) toppos=0;

	return "left=" + leftpos + ", top=" + toppos ;
}

/*
 * 선택한 Row중 Bkg_No가 중복 된 건이 있는지 체크
 */
function ibSheet_BKGCheck(sheetObj, sStatus) {
	if( sheetObj.CheckedRows("chk") < 1 ) {
		ComShowMessage("Please select at least one.");
		return false;
	}
	var fromRow = 0;
	var docPrvBkgno = "";
	var sRow = sheetObj.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");

	for( var ir = 0; ir < arrRow.length-1; ir++ ) {
		fromRow = arrRow[ir];
		if( ir == 0 ) {
			docPrvBkgno = doSepRemove(sheetObj.CellValue(fromRow, "r_bkg_no")+sheetObj.CellValue(fromRow, "r_bkg_no_split"), " ");
		} else {
			if( docPrvBkgno != doSepRemove(sheetObj.CellValue(fromRow, "r_bkg_no")+sheetObj.CellValue(fromRow, "r_bkg_no_split"), " ") ) {
				sheetObj.CellValue2(fromRow,"chk") = "0";
				sheetObj.RowStatus(fromRow) = "R";
			}
		}
	}
	return true;
}

function sheet1_OnChange(sheetObj,Row, Col, Value) {
	if( sheetObj.ColSaveName(Col) == "chk" ) {
		if( Value == "1" ) {
			sheetObj.RowStatus(Row) = "U";
		} else {
			sheetObj.RowStatus(Row) = "R";
		}
	} else if( sheetObj.ColSaveName(Col) == "cop_sub_sts_cd" ) {
		if( sheetObj.CellValue(Row, "chk") == "1" ) {
			sheetObj.RowStatus(Row) = "U";
		} else {
			sheetObj.RowStatus(Row) = "R";
		}
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		var iCheckRow = sheetObj.FindCheckedRow("chk");
		var arrRow = iCheckRow.split("|");
		var fromRow = 0;
		for( var ir = 0; ir < arrRow.length-1; ir++ ) {
			fromRow = arrRow[ir];
			if( sheetObj.CellValue(fromRow, "cop_sub_sts_cd") == "Y" && sheetObj.CellValue(fromRow, "r_cop_sts_cd") == "F" ) {
				sheetObj.CellValue2(fromRow, "r_cop_sub_sts_cd") = "R";
			} else {
				sheetObj.CellValue2(fromRow, "r_cop_sub_sts_cd") = "";
			}
		}
	}
}

function sheet1_OnAfterColumnMove(sheetObj, col, newPos){
	var newColName = sheetObj.ColSaveName(newPos) ;
	switch (newColName) {
		case "r_bkg_no":
			if (col > newPos) {
				newPos = newPos+1;
			}
			sheetObj.MoveColumnPos("r_bkg_no_split", newPos, false);
		break;
		default:
			break;
	}
}

/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
	var ch = "";
	var lvobj = "";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch = "";
		} else {
			ch = obj.charAt(i);
		}
		lvobj = lvobj + ch;
	}
	return lvobj;
}