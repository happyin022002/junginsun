/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0508.js
 *@FileTitle : US AMS: Sent File
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.06.01 이수빈
 * 1.0 Creation
 * 
 * 2011.08.08 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
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
     * @class US AMS: Sent File : US AMS: Sent File 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0508() {
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
	        	rdOpen(rdObject);
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
	 var sheetID = sheetObj.id;

     switch(sheetID) {

     case "sheet1":
         with (sheetObj) {

             // 높이 설정
             style.height = 502;
             //전체 너비 설정
             SheetWidth = mainTable.clientWidth;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = true;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo(0, 1, 1, 100);

			 var HeadTitle1 = "|||";
             var headCount = ComCountHeadTitle(HeadTitle1);

             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(headCount, 0, 0, true);

             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(true, true, false, true, false, false);

             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle1, true, true);

             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
			 InitDataProperty(0, cnt++ , dtSeq,				50,		daCenter,		false,		"seq");
			 InitDataProperty(0, cnt++ , dtData,			150,	daLeft,			false,		"log_ctnt",		false,	"",	dfNone,		0,	true,	true);
			 InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,			false,		"log_ctnt2",		false,	"",	dfNone,		0,	true,	true);			 
			 //WordWrap = true;
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
	        sheetObj.DoSearch("ESM_BKG_0508GS.do", FormQueryString(formObj));
    		ComOpenWait(false);
	        break;

		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
        	if (sheetObj.RowCount == 0) {
        		ComShowCodeMessage("BKG00109"); 
        	    return;
        	} else {
        		if(ofmFlg == 'N'){
        			ComOpenWait(true);
        			//sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
        			
    				var xmlUrl = "http://"+location.hostname +":"+ location.port + "/hanjin/apps/alps/esm/bkg/customsdeclaration/customsreport/script/ESM_BKG_0508.xml";
    				sheetObj.SpeedDown2Excel(-1, false, false, "", xmlUrl, false, false, "", true);
    				ComOpenWait(false);
        		}
        		else{
        			// OFM 데이터 일 경우 TXT 파일로 로컬에 다운로드
//					formObj.f_cmd.value = COMMAND01;
//					formObj.target = "download";
//					formObj.action = "ESM_BKG_0508_1GS.do";
//					formObj.submit();
					
        			ComOpenWait(true);
                    formObj.f_cmd.value = SEARCH03;                    
                    var sXml = sheetObj.GetSearchXml("ESM_BKG_0508GS.do", FormQueryString(formObj));                    
                    var log_ctnt_etc = ComGetEtcData(sXml, "log_ctnt_etc");                                        
                    sheetObj.CellText(1, "log_ctnt2") = log_ctnt_etc;     
                    
        			var sDate = formObj.date.value;
        			var sFileName = "Transmission History Sent File_" + getCurrentTime() + ".txt"
        			ComOpenWait(false);
    				sheetObj.Down2Text("", "", "3", sFileName, "", "", false, false, true);					
        		}
        	}
			break;
    }
 }

 
/**
 * RD 오픈  및  출력
 */
function rdOpen(rdObject){

 	var formObject = document.form;
 	
 	var msgTpId = formObject.trsm_msg_tp_id.value;
	var vvd   	= formObject.vvd.value;
	var polCd 	= formObject.pol_cd.value;
	var podCd 	= formObject.pod_cd.value;
	var ofcCd 	= formObject.ofc_cd.value;
	var usrId 	= formObject.usr_id.value;
	var sndDate = formObject.snd_date.value;
	
	var cntCd 	= formObject.cnt_cd.value;
	var ioBndCd = formObject.io_bnd_cd.value;
	var hisSeq 	= formObject.his_seq.value;
	var sndDt 	= formObject.snd_dt.value;
	var stwgSndId = formObject.stwg_snd_id.value;
	
 	var param = "/rp [" + msgTpId + "][" + vvd + "][" + polCd +"][" + podCd +"][" + ofcCd + "][" + usrId + "][" + sndDate + 
 				"][" + cntCd + "][" + ioBndCd + "][" + sndDt + "][" + hisSeq + "][" + stwgSndId + "]";

//	var RD_path = "http://localhost:7001/hanjin/";

	var rdParam = param +  " /riprnmargin /rwait";
	var strPath = RD_path+"apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0834.mrd";

	//alert(rdParam + "\n\n" + strPath);

	var Rdviewer = rdObject;
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
 
 
 /**
 * 현재날짜 구한다.
 * @return
 */
function getCurrentTime(){	 
	 var now=new Date(); 
	 var y=now.getFullYear(); // 년도.
	 var mon=now.getMonth()+1; // 월 (월은 0부터 시작므로 +1을 해야 합니다.)
	 var td =now.getDate(); // 일 (일은 1부터 시작하므로 +1을 하면 안 됩니다.)
	 var h =now.getHours(); // 시
	 var min =now.getMinutes(); // 분
	 var s =now.getSeconds(); // 초
	 var ms=now.getMilliseconds(); //밀리세컨드 (1/1000초)
	 
	 if(String(mon).length == 1) mon = '0'+mon;
	 if(String(td).length == 1) td = '0'+td;
	 if(String(h).length == 1) h = '0'+h;
	 if(String(min).length == 1) min = '0'+min;
	 if(String(s).length == 1) s = '0'+s;
	 
	 return y+mon+td+h+min+s;
} 

/* 개발자 작업  끝 */