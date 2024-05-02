/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0248.js
*@FileTitle : P/F SKD History Inquiry (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.05.27 서창열
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
     * @class vop_vsk_0248 : vop_vsk_0248 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0248() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  
  var sheetObject1 = sheetObjects[0];
  
  /*******************************************************/
  var formObject = document.form;

try {
	var srcName = window.event.srcElement.getAttribute("name");

     switch(srcName) {
     	/*
     	case "btn_Select":
			comPopupOK();
			break;
		*/	
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
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
             
         case "sheet1":      // sheet1 init
         with (sheetObj) {
             // 높이 설정
             style.height = 300;
             // 전체 너비 설정
             SheetWidth = mainTable.clientWidth;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = false;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo( 1, 1, 10, 100);

             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(8, 0, 0, true);

             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(false, false, false, true, false, false);

             var HeadTitle1 = "|SEQ|Status|Date|ID|Remark(s)||";

             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle1, true);
             
             var prefix = "sheet1_";
             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	prefix+"ibflag",				false,	"",      	dfNone,			0,			true,		true);
			 InitDataProperty(0, cnt++ , dtSeq,				30,		daCenter,	false,	prefix+	"num",		false,	"",			dfNone,		0,			true,		true);
			 InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	prefix+	"history",		false,	"",			dfNone,		0,			true,		true);
			 InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	false,	prefix+	"upd_dt",		false,	"",			dfUserFormat2,		0,			true,		true);
			 InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	prefix+	"upd_usr_id",		false,	"",			dfNone,		0,			true,		true);
			 InitDataProperty(0, cnt++ , dtData,			110,	daLeft,		false,	prefix+	"diff_rmk",		false,	"",			dfNone,		0,			true,		true);
			 InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		false,	prefix+	"vsl_slan_cd",		false,	"",			dfNone,		0,			true,		true);
			 InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		false,	prefix+	"pf_svc_tp_cd",		false,	"",			dfNone,		0,			true,		true);
			 
			 InitUserFormat2(0, prefix+"upd_dt", "####-##-## ##:##", "-|:" );

 			 //CountPosition = 0;
 			}
                 break;
                 
         case "sheet2":      // sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 300;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 var HeadTitle1 = "|Created VVD|Created VVD|Created VVD|Created VVD";
                 var HeadTitle2 = "|VVD|VVD|VVD|Start Date";
                 var headCount = ComCountHeadTitle(HeadTitle1);
                 
                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 10, 100);
                 
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);
                 
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, false, false, true, false, false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);		
                 InitHeadRow(1, HeadTitle2, true);
                 
                 var prefix = "sheet2_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	prefix+"ibflag",				false,	"",      	dfNone,			0,			true,		true);
    			 InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,	prefix+"vsl_cd",		false,	"",			dfNone,		0,			true,		true);
    			 InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,	prefix+"skd_voy_no",		false,	"",			dfNone,		0,			true,		true);
    			 InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	prefix+"skd_dir_cd",		false,	"",			dfNone,		0,			true,		true);
    			 InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	prefix+"n1st_port_brth_dt",		false,	"",			dfNone,		0,			true,		true);

     			// CountPosition = 0;
     			}
                     break;

         }
     }

   // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {

        case IBSEARCH:      //조회
        	sheetObj.WaitImageVisible = false;
  		    ComOpenWait(true);
  		    
        	formObj.f_cmd.value = SEARCH;
        	var aryPrefix = new Array("sheet1_", "sheet2_");	//prefix 문자열 배열
        	var sXml = sheetObj.GetSearchXml("VOP_VSK_0248GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
        	var arrXml = sXml.split("|$$|");
        	
        	for(var inx=0; inx<arrXml.length; inx++){
				showSheetData(sheetObjects[inx],formObj,arrXml[inx]);
			}
        	ComOpenWait(false);
         break;

     }
 }
 
 
 /**
 * 조회 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml,Pos){
	var prefix = sheetObj.id + "_";
	
	switch(sheetObj.id){
		case "sheet1":
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(sXml);

			var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");

			if(dataNode){
				var totValue = dataNode.value;

				sheetObj.LoadSearchXml(sXml);

				if(totValue > 0){
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}
			}
		break;
		
		case "sheet2":

			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
			
		break;
	}
}

 /**
  * 부모창에 선택값 리턴
  */
/*
 function sheet1_OnDblClick(sheetObj, Row, Col) {
	 comPopupOK();
 }
*/

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
     }

     return true;
 }


	/* 개발자 작업  끝 */