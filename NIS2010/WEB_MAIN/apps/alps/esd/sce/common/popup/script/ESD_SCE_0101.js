/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0101 .js
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

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 var sheetObj = sheetObjects[0];
	 var formObj  = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_close":
	            self.close();
    	        break;
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
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
function setSheetObject(sheet_obj) {
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

	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                    InitRowInfo( 1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

					var HeadTitle = "STS|SEQ|Expt|Activity|VVD|Location|Estimated\nDate / Time|Actual\nDate / Time|Actual Data\nSource" ;
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, 	SAVENAME, 			KEYFIELD, CALCULOGIC, DATAFORMAT, 		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,   25,    daCenter,  false,    "r_dt_sts",     	  	false,          "",       dfNone,   		0,     	false,       true);
                    InitDataProperty(0, cnt++ , dtSeq,            45,    daCenter,  false,    "r_seq",            	false,          "",       dfNone,	        0,     	false,       true);
					InitDataProperty(0, cnt++ , dtImage,      	  40,    daCenter,  false,    "cop_expt_sts",     false,          "",       dfNone,   		0,     	false,       true);
                    InitDataProperty(0, cnt++ , dtData,     	 220,    daLeft,    false,    "act_nm",         	false,          "",       dfNone,   		0,     	false,       true);
                    InitDataProperty(0, cnt++ , dtData,     	  80,    daCenter,  false,    "vvd",				false,          "",       dfNone,   		0,     	false,       true);
                    InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,    "nod_cd",         	false,          "",       dfNone,   		0,     	false,       true);
                    InitDataProperty(0, cnt++ , dtData,       	  80,    daCenter,  false,    "estm_date",     	false,          "",       dfDateYmd,     	0,     	false,   	 true);
                    InitDataProperty(0, cnt++ , dtData,       	  80,    daCenter,  false,    "act_date",      	false,          "",       dfDateYmd,     	0,     	false,        true);
                    InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter,  false,    "act_rcv_tp_cd",   	false,          "",       dfNone,	        0,     	false,       true);

                ImageList(0) = "/hanjin/img/alps/ico_b.gif" ;
                ImageList(1) = "/hanjin/img/alps/ico_g.gif" ;
                ImageList(2) = "/hanjin/img/alps/ico_r.gif" ;

                CountPosition  = 0;

           }
            break;

    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.DoSearch4Post("ESD_SCE_0101GS.do", SceFrmQryString(formObj));
				
				//alert(sheetObj.EtcData("bkgno"));
				
			formObj.all.bkg_no.innerHTML = (sheetObj.EtcData("bkgno") != undefined) ? sheetObj.EtcData("bkgno") : "";
			formObj.all.bl_no.innerHTML = (sheetObj.EtcData("blno") != undefined) ? sheetObj.EtcData("blno") : ""; 
			formObj.all.rdterm.innerHTML = (sheetObj.EtcData("rdterm") != undefined) ? sheetObj.EtcData("rdterm") : ""; 
			formObj.all.cntr_no.innerHTML = (sheetObj.EtcData("cntr_no") != undefined) ? sheetObj.EtcData("cntr_no") : ""; 
			formObj.all.cop_no1.innerHTML = (sheetObj.EtcData("cop_no") != undefined) ? sheetObj.EtcData("cop_no") : ""; 
			formObj.all.vvd.innerHTML = (sheetObj.EtcData("tvvd") != undefined) ? sheetObj.EtcData("tvvd") : ""; 
			formObj.all.por.innerHTML = (sheetObj.EtcData("por") != undefined) ? sheetObj.EtcData("por") : ""; 
			formObj.all.pol.innerHTML = (sheetObj.EtcData("pol") != undefined) ? sheetObj.EtcData("pol") : ""; 
			formObj.all.pod.innerHTML = (sheetObj.EtcData("pod") != undefined) ? sheetObj.EtcData("pod") : ""; 
			formObj.all.del.innerHTML = (sheetObj.EtcData("del") != undefined) ? sheetObj.EtcData("del") : ""; 

			break;
	   case IBDOWNEXCEL:        //엑셀 다운로드
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}

