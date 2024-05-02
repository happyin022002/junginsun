/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0429.js
 *@FileTitle : US AMS: Receive File
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.06.01 이수빈
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
 * @class Generate Arrival Manifest by Container : Generate Arrival Manifest by Container 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0429() {
    this.processButtonClick		= tprocessButtonClick;
    this.setSheetObject 		= setSheetObject;
    this.loadPage 				= loadPage;
    this.initSheet 				= initSheet;
    this.doActionIBSheet 		= doActionIBSheet;
    this.validateForm 			= validateForm;
}
    
/* 개발자 작업	*/

 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
	
 var rdObjects = new Array();
 var rdCnt = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      var sheetObject = sheetObjects[0];
      var sheetObject1 = sheetObjects[1];
      var rdObject = rdObjects[0];

      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

	        case "btn_downexcel":
	        	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	            break; 
	             
	        case "btn_print":
	        	if (sheetObject.RowCount == 0) {
	        		ComShowCodeMessage("BKG00394"); 
	        	    return;
	        	} else {
		        	rdOpen(rdObject);
	        		//ComOpenWindow2("ESM_BKG_0882.do", "print", "width=755,height=460");
	        	}
	            break;
				
			case "btn_close":
				window.close();
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
     
 	 initRdConfig(rdObjects[0]);
 	 
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 }


/**
 * Rd 설정
 */
function initRdConfig(rdObject){
	
	var Rdviewer = rdObject;
	
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0); 
	Rdviewer.IsShowDlg = 0;
	Rdviewer.setbackgroundcolor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);
	Rdviewer.style.height = 0;
}


 /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;
			var sheetId = sheetObj.id;

     switch(sheetId) {

         case "sheet1":
             with (sheetObj) {

                 // 높이 설정
                 style.height = 402;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(1, 1, 15, 100);
                 
                 var HeadTitle1 = "||";
                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibFlag");
				 //InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		"rcv_seq");
				 InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		"seq_no");
				 InitDataProperty(0, cnt++ , dtData,			150,	daLeft,			false,		"msg_desc",		false,		"",		dfNone,		0,		true,		true);

				 CountPosition = 0;
		}
		break;

     }
 }

 /**
  * Sheet관련 프로세스 처리
  */ 
 function doActionIBSheet(sheetObj,formObj,sAction) {
     //sheetObj.ShowDebugMsg = false;
	 sheetObj.WaitImageVisible = false;
		
     switch(sAction) {
       	case IBSEARCH:   //조회
    		ComOpenWait(true);
            formObj.f_cmd.value = SEARCH;
	        sheetObj.DoSearch("ESM_BKG_0429GS.do", FormQueryString(formObj));
    		ComOpenWait(false);
	        break;

		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
        	if (sheetObj.RowCount == 0) {
        		ComShowCodeMessage("BKG00109"); 
        	    return;
        	} else {
        		ComOpenWait(true);
		   		var xmlUrl = "http://"+location.hostname +":"+ location.port + "/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/script/ESM_BKG_0429.xml";
				sheetObj.SpeedDown2Excel(-1, false, false, "", xmlUrl, false, false, "", true);
	    		ComOpenWait(false);
        	}
			break;
     } //switch end
 }


 
/**
 * RD 오픈  및  출력
 */
function rdOpen(rdObject){

	var formObject = document.form;
	
	var msgTpId = formObject.rcv_msg_tp_id.value;
	var vvd   = formObject.vvd.value;
	var polCd = formObject.pol_cd.value;
	var podCd = formObject.pod_cd.value;
	var blNo = formObject.bl_no.value;
	var batchNo = formObject.batch_no.value;
	var rcvDt = formObject.rcv_dt.value;
	
	var cntCd = formObject.cnt_cd.value;
	var ioBndCd = formObject.io_bnd_cd.value;
	var rcvDate = formObject.rcv_date.value;
	var rcvSeq = formObject.rcv_seq.value;
		
	var param = "/rp [" + msgTpId + "][" + vvd + "][" + polCd +"][" + podCd +"][" + blNo + "][" + batchNo + "][" + rcvSeq + "][" + rcvDt + 
				"][" + cntCd + "][" + ioBndCd + "][" + rcvDate + "][" + rcvSeq + "]";
	
	var sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(sheetObjects[0], 1);
	sXml += "</SHEET>";
	
	//var RD_path = "http://localhost:7001/hanjin/";

	var rdParam = param +  " /riprnmargin /rwait";
	var strPath = RD_path+"apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0874.mrd";

	//alert(rdParam + "\n\n" + strPath);

	var Rdviewer = rdObject;
	Rdviewer.SetRData(sXml);
	Rdviewer.FileOpen(strPath, RDServer + rdParam); 
	if (strCntCd == "US") {
		Rdviewer.SetPrint2(4,1,1,100);
	}
	Rdviewer.PrintDialog();

}

/**
 * RD 출력
 * @param rdObject
 * @return
 */
function rdPrint(rdObject) {
	var Rdviewer = rdObject;
	
	Rdviewer.PrintDialog();
}

/* 개발자 작업  끝 */