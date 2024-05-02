/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0104 .js
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-23
*@LastModifier : yujin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 var sheetObjects = new Array();
var sheetCnt = 0;
var selRow = 0;
var selCol = 0;
var selOfc = "";

   /**
    * IBSheet Object를 배열로 등록
    * ComSheetObject(id)에서 호출한다
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
	for(i=0;i<sheetObjects.length;i++) {

		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);

		ComEndConfigSheet(sheetObjects[i]);
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetNum = 0;
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		if( formObject.selection[0].checked) {
			sheetObject = sheetObjects[0];
			sheetObj = sheetObjects[0];
			sheetNum = 0;
		} else {
			sheetObject = sheetObjects[1];
			sheetObj = sheetObjects[1];
			sheetNum = 1;
		}

        switch(srcName) {
		//minestar
			case "selection":
				if( formObject.selection[0].checked) {
					document.getElementById("location").style.display= "";
					document.getElementById("node").style.display= "none";
				} else if( formObject.selection[1].checked) {

					document.getElementById("node").style.display= "";
					document.getElementById("location").style.display= "none";
				}
				break;

			case "btn_ok" :
				getChkedVl( sheetObject, sheetNum);
				self.close();
				break;
    	    case "btn_retrieve":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH , sheetNum);
    	        break;

    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;

            case "btn_close":
	            self.close();
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

function getChkedVl( sheetObject, sheetNum) {
	var chkCnt = sheetObj.CheckedRows(0) ;

	if( chkCnt==0 ) {
		ComShowMessage(getMsg('COM12113', 'Location')) ;
		return false ;
	}

	var chkRows = sheetObj.FindCheckedRow(0) ;
	var arrChkRows = chkRows.split("|") ;

	var loc_cd ="";
	
	if( sheetNum ==0) {
		loc_cd = sheetObj.CellValue(arrChkRows[0], "loc_cd");
	} else {
		if(document.form.modeVal.value=="zone"){
			loc_cd = sheetObj.CellValue(arrChkRows[0], "zn_cd");
		}else {
			loc_cd = sheetObj.CellValue(arrChkRows[0], "yd_cd")	
		}
	}
	var opener = window.dialogArguments;
	opener.getSelectedValue ( loc_cd);

}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObject,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
      case 1:      //IBSheet1 init
                with (sheetObject) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(16, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "||No|Location|Name|Conti|Sub Conti|Region|Country|State|SCC|ECC|LCC|RCC|Control Office|Port" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW,      COL,            DATATYPE, WIDTH,   DATAALIGN, COLMERGE,     SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,20,    daCenter,  false,    "radio",           false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  20,    daCenter,  false,    "check",           false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "seq",              false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "loc_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      140,   daLeft,  false,   "loc_nm",    false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "conti_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "sconti_cd",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "rgn_cd",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "cnt_cd",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "loc_state",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "scc_cd",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "ecc_cd",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "lcc_cd",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "rcc_cd",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      85,    daCenter,  false,    "loc_eq_ofc",       false,          "",       dfNone, 	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  false,    "loc_port_ind",       false,          "",       dfNone, 	0,     false,       true);
                }
                break;
      case 2:      //IBSheet1 init
                with (sheetObject) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "";
                    // as-is에서는 쓰지않는 header.
//                    if(document.form.modeVal.value == "zone") {
//                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                        InitColumnInfo(14, 0, 0, true);
//
//                        HeadTitle = "||SEQ|Node Code|Node Name|Ctrl Office|MAT|CY|CFS|R/R|PY|TYPE|vndr_cnt_cd|loc_cd";
//                    } else {
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(12, 0, 0, true);
                        HeadTitle = "||SEQ|Node Code|Node Name|Ctrl Office|Postal Code|District|Street|Address|vndr_cnt_cd|loc_cd";
//                    }

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false,    "radio",        false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);

                    if(document.form.modeVal.value == "zone") {
//                    	alert(documnet.form.modeVal.value);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "zn_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      120,    daLeft,  false,    "zn_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);

                        InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,    "",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  false,    "",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "",        false,          "",       dfNone,       0,     false,       true);
//                        InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  false,    "",        false,          "",       dfNone,       0,     false,       true);
//                        InitDataProperty(0, cnt++ , dtData,     70,    daCenter,    false,    "",        false,          "",       dfNone,       0,     false,       true);

//                        ImageList(0) = "/hanjin/img/enis/ico_round.gif" ;
                        // Yard : Node Code, Node Name, Ctrl Office, MAT, CY, CFS, R/R, PY, Type
                    } else {
//                    	alert(document.form.modeVal.value);
                        InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "yd_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      120,    daLeft,  false,    "yd_nm",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     80,    daCenter,    false,    "yd_fcty_tp_mrn_tml_flg",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  false,    "yd_fcty_tp_cy_flg",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     70,    daLeft,  false,    "yd_fcty_tp_cfs_flg",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,     100,    daLeft,  false,    "yd_fcty_tp_rail_rmp_flg",        false,          "",       dfNone,       0,     false,       true);
                        // Zone : Node Code, Node Name, Postal Code, District, Street, Address
                    }

                    // Hidden으로 Country코드, Location 코드를 세팅한다.
                    InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  false,   "cnt_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  false,   "loc_cd");
                }

                break;
    }
}
/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObject,formObj,sAction, sheetNum) {

	sheetObject.ShowDebugMsg = false;

	var target ;

	// target 변경
	if( sheetNum == 0) {
		formObj.cnt_cd.value = formObj.cnt_cd_1.value;
		formObj.loc_cd.value = formObj.loc_cd_1.value;
		target = "COM_ENS_051GS.do";
	} else if ( sheetNum == 1) {
		formObj.cnt_cd.value = formObj.cnt_cd_2.value;
		formObj.loc_cd.value = formObj.loc_cd_2.value;
		target = "COM_ENS_061GS.do";
	}

	switch(sAction) {

		case IBSEARCH:	//조회

			if(!validateForm(sheetObject,formObj,sAction, sheetNum)) {
	        	return false;
			}

			formObj.f_cmd.value = SEARCH;
			selectVal = SceFrmQryString(formObj)
			sheetObject.DoSearch4Post(target, selectVal);

			break;

		case IBSEARCHAPPEND:  // 페이징 조회
	    	formObj.f_cmd.value = SEARCHLIST;
	        sheetObject.DoSearch4Post(target, selectVal, "iPage=" + PageNo, true);

	        break;
	}
}

//TODO
function validateForm(sheetObject, formObj, sAction, sheetNum) {
	return true;

}


function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	//alert("111");
	var formObj = document.form ;
    if (sheetObj.RowCount >= OnePageRow && sheetObj.TotalRows > sheetObj.RowCount){
    	selectVal = SceFrmQryString(formObj);
    	formObj.f_cmd.value = SEARCH;
		PageNo = Math.ceil(sheetObj.SearchRows/OnePageRow)+1;
		
		//alert(OnePageRow);
		//alert(PageNo);
		// target 변경
		formObj.cnt_cd.value = formObj.cnt_cd_1.value;
		formObj.loc_cd.value = formObj.loc_cd_1.value;
		target = "COM_ENS_051GS.do";
		
    	sheetObj.DoSearch4Post(target, selectVal, "iPage=" + PageNo, true);

    }
}

function sheet2_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
	//alert("111");
	var formObj = document.form ;
    if (sheetObj.RowCount >= OnePageRow && sheetObj.TotalRows > sheetObj.RowCount){
    	selectVal = SceFrmQryString(formObj);
    	formObj.f_cmd.value = SEARCH;
		PageNo = Math.ceil(sheetObj.SearchRows/OnePageRow)+1;
		
		//alert(OnePageRow);
		//alert(PageNo);
		// target 변경
		
		formObj.cnt_cd.value = formObj.cnt_cd_2.value;
		formObj.loc_cd.value = formObj.loc_cd_2.value;
		target = "COM_ENS_061GS.do";
		
    	sheetObj.DoSearch4Post(target, selectVal, "iPage=" + PageNo, true);

    }
}

