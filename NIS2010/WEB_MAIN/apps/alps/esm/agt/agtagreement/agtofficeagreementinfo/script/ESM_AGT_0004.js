/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0004.js
*@FileTitle : CNTR Type Size List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.09.02 추경원
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
	 * @class ESM_AGT_0004 : ESM_AGT_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_AGT_0004() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
   	/* 개발자 작업	*/
 // 공통전역변수


	var sheetObjects = new Array();
	var sheetCnt = 0;

	var IBDETAILSEARCH	 = 20; //corrct

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
		function processButtonClick(){
			 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
			 var sheetObject = sheetObjects[0];
			 var sheetObject1 = sheetObjects[1];
			 var sheetObject2 = sheetObjects[2];

			 /*******************************************************/
			 var formObject = document.form;

			try {
				var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBDETAILSEARCH);
						break;

					case "btn_ok":
						if(sheetObject2.CheckedRows("checkbox") < 1){
							ComShowMessage(ComGetMsg('AGT00085','Detail TP/SZ CheckBox.'));
							return false;
						}
						  comPopupOK();
					  break;

					case "btn_close":
						  window.close();
					  break;

				} // end switch
			}catch(e) {
				if( e == "[object Error]") {
					ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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

					//khlee-시작 환경 설정 함수 이름 변경
						ComConfigSheet(sheetObjects[i]);

						initSheet(sheetObjects[i],i+1);
					//khlee-마지막 환경 설정 함수 추가
						ComEndConfigSheet(sheetObjects[i]);
					}
			//ESM_AGT_003 화면에서 넘겨받은 파라미터로 조회
			var formObject = document.form;
		  	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		}

	   /**
		 * 시트 초기설정값, 헤더 정의
		 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
		 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
		 */
		function initSheet(sheetObj,sheetNo) {

			var cnt = 0;

			switch(sheetNo) {
				case 1:	  //sheet1 init
					with (sheetObj) {
						// 높이 설정
						style.height = GetSheetHeight(4) ;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

					   //전체Edit 허용 여부 [선택, Default false]
						if(document.form.pageType.value != "Inquiry"){
							Editable = true;
						}else{
							Editable = false;
						}

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 0, 1, 9, 100);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(5, 0 , 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						if(document.form.pageType.value != "Inquiry"){
							InitHeadMode(true, true, true, true, false,false) ;
						}else{
							InitHeadMode(true, true, false, true, false,false) ;
						}
						

						var HeadTitle = "STS|No|CHK|Size|Description";

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);

						//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,30,	daCenter,  false,	"",	 false,		  "",	   dfNone,   		0,	 false,	  true);
						InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,   false,	"",	 false,		  "",	   dfNone,		  0,	 true,	   true);
						InitDataProperty(0, cnt++ , dtCheckBox,   40,	daCenter,   false,	"check",	 false,		  "",	   dfNone,		  0,	 true,	   true);
						InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,   false,	"cntr_sz_cd",	 false,		  "",	   dfNone,		  0,	 false,	   false);
						InitDataProperty(0, cnt++ , dtData,	   50,	daLeft,   false,	"cntr_sz_desc",	 false,		  "",	   dfNone,		  0,	 false,	   false);

						CountPosition = 0 ;
					}
					break;
				case 2:	  //sheet1 init
					with (sheetObj) {
						// 높이 설정
						style.height = GetSheetHeight(4) ;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

					   //전체Edit 허용 여부 [선택, Default false]
						if(document.form.pageType.value != "Inquiry"){
							Editable = true;
						}else{
							Editable = false;
						}

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 0, 1, 9, 100);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(5, 0 , 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다						
						if(document.form.pageType.value != "Inquiry"){
							InitHeadMode(true, true, true, true, false,false) ;
						}else{
							InitHeadMode(true, true, false, true, false,false) ;
						}

						var HeadTitle = "STS|No|CHK|Type|Description";

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);

						//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ ,dtHiddenStatus,30,	daCenter,  false,	"",	 false,		  "",	   dfNone,   		0,	 false,	  true);
						InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,   false,	"",	 false,		  "",	   dfNone,		  0,	 true,	   true);
						InitDataProperty(0, cnt++ , dtCheckBox,   40,	daCenter,   false,	"check",	 false,		  "",	   dfNone,		  0,	 true,	   true);
						InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,   false,	"cntr_tp_cd",	 false,		  "",	   dfNone,		  0,	 false,	   false);
						InitDataProperty(0, cnt++ , dtData,	   50,	daLeft,   false,	"cntr_tp_desc",	 false,		  "",	   dfNone,		  0,	 false,	   false);

						CountPosition = 0 ;

				   }
					break;

				case 3:	  //sheet3 init
					with (sheetObj) {
						// 높이 설정
						style.height = GetSheetHeight(11) ;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

					   //전체Edit 허용 여부 [선택, Default false]
						if(document.form.pageType.value != "Inquiry"){
							Editable = true;
						}else{
							Editable = false;
						}

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 0, 1, 9, 100);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(5, 0 , 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						if(document.form.pageType.value != "Inquiry"){
							InitHeadMode(true, true, true, true, false,false) ;
						}else{
							InitHeadMode(true, true, false, true, false,false) ;
						}
						

						var HeadTitle = "STS|No|CHK|TP/SZ|Description";

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);

						//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,30,	daCenter,  false,	"",	 false,		  "",	   dfNone,   		0,	 false,	  true);
						InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,   false,	"",	 false,		  "",	   dfNone,		  0,	 true,	   true);
						InitDataProperty(0, cnt++ , dtCheckBox,   40,	daCenter,   false,	"checkbox",	 false,		  "",	   dfNone,		  0,	 true,	   true);
						InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,   false,	"cntr_tpsz_cd",	 false,		  "",	   dfNone,		  0,	 false,	   false);
						InitDataProperty(0, cnt++ , dtData,	   50,	daLeft,   false,	"cntr_tpsz_desc",	 false,		  "",	   dfNone,		  0,	 false,	   false);

						CountPosition = 0 ;

				   }
					break;
			}
		}

	  // Sheet관련 프로세스 처리
		function doActionIBSheet(sheetObj,formObj,sAction) {
//			sheetObj.ShowDebugMsg = false;

			switch(sAction) {

			   case IBSEARCH:	  //조회
					if(!validateForm(sheetObj,formObj,sAction)) return false;
				
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ESM_AGT_0004GS.do", agtQryStr(formObj));
	 				var arrXml = sXml.split("|$$|");
	 				if(arrXml.length>0)sheetObjects[0].LoadSearchXml(arrXml[0]);
	 				if(arrXml.length>1)sheetObjects[1].LoadSearchXml(arrXml[1]);
	 				if(arrXml.length>2)sheetObjects[2].LoadSearchXml(arrXml[2]);
					break;
				
			   case IBDETAILSEARCH:		//상세조회
					if(!validateForm(sheetObj,formObj,sAction)) return false;
					formObj.f_cmd.value = SEARCHLIST;
					var parameter = agtQryStr(formObj);
					parameter = parameter + '&cntr_sz_cd=' + chkdArgs(sheetObjects[0], 'check', 'cntr_sz_cd');
					parameter = parameter + '&cntr_tp_cd=' + chkdArgs(sheetObjects[1], 'check', 'cntr_tp_cd');
					var sXml = sheetObj.GetSearchXml("ESM_AGT_0004GS.do", parameter);
	 				var arrXml = sXml.split("|$$|");
	 				if(arrXml.length>2)sheetObjects[2].LoadSearchXml(arrXml[2]);

					break;
			}
		}

	   /**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
		function validateForm(sheetObj,formObj,sAction){
			var sheetObject = sheetObjects[0];
			var sheetObject1 = sheetObjects[1];
			var sheetObject2 = sheetObjects[2];
			switch(sAction) {

				case IBDETAILSEARCH:
					if(sheetObject.CheckedRows("check") < 1 &&  sheetObject1.CheckedRows("check") < 1){
						ComShowMessage(ComGetMsg('AGT00085','Rep. Type OR Rep. Size CheckBox'));
						return false;
					}
					break;
			}

			return true;
		}

function chkdArgs(sheetObj,chkCol,valCol,isNum)
{
	var rtn = '';
	with(sheetObj)
	{
		for (var i = 1; i <= LastRow; i ++)
		{
			if ("1" == CellValue(i, chkCol))
				rtn += (''!=rtn?',':'')+(isNum?'':'\'')+CellValue(i, valCol)+(isNum?'':'\'');
		}
	}
	return rtn;
}
	/* 개발자 작업  끝 */