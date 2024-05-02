﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0243.js
*@FileTitle : Hold Remark Setup Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.03 박성호
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
 * @class esm_bkg_0956 : esm_bkg_0956 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0956() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
    this.obj_keypress           = obj_keypress;
}

   /* 개발자 작업    */



//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      var sheetObject = sheetObjects[0];
      /*******************************************************/
      var formObject = document.form;

 	//try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

							case "btn_Retrieve":
								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
							break;

							case "btn_new":
								sheetObject.RemoveAll();
							break;

							case "btn_down_excel":
								sheetObjects[0].Down2Excel(true,false,true);
							break;

							case "btn_upload_excel":
								sheetObjects[0].LoadExcel(-1,1,"",-1,-1,"",false);
							break;

							case "btn_save":
								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);

							break;

							case "btn_close":
								//<8.5>Close 버튼 클릭 시 변경 내역 체크 후  변경 내역존재 시 [BKG00168] 메세지 출력 후 선택적 작업 진행.
								//    => 'Yes' 클릭 시 창 Close, 'No' 클릭 시 창 Close하지 않음
								if(sheetObjects[0].IsDataModified){
									//if(confirm(ComGetMsg("BKG00168"))){
									//2009.10.14 메시지 변경
									if(confirm(ComGetMsg("BKG40068"))){
										window.close();
									}
								}else{
									window.close();
								}
							break;



         } // end switch
 	//}catch(e) {
 	//	if( e == "[object Error]") {
 	//		ComShowMessage(OBJECT_ERROR);
 	//	} else {
 	//		ComShowMessage(e);
 	//	}
 	//}
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
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
     //khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
     }


     var formObj = document.form;
     //alert(sheetObjects.length);

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
         case 1:      //sheet1 init
             with (sheetObj) {

                 // 높이 설정
                 style.height = 260;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msPrevColumnMerge;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(1, 1, 15, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(6, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, false, true, false,false)

                 var HeadTitle1 = "ibflag|Seq.|CNTR No.|H|Hold Reason";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 var prefix = "sheet1_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    0,      daCenter,    false,      prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,			40,	  	daCenter,		false,		prefix + "Seq",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		prefix + "cntr_no",		false,			"",      dfNone,			0,		false,		false,14);
				InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,		false,		prefix + "hld_flg",			false,			"",      dfNone,			0,		true,		true,1);
				InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		false,		prefix + "hld_rsn",		false,			"",      dfEngUpKey,			0,		true,		true,4000);
				InitDataProperty(0, cnt++ , dtHidden,			70,		daCenter,		false,		prefix + "bkg_no",		false,			"",      dfEngUpKey,			0,		true,		true,1);

				WaitImageVisible = false;

            }
             break;

     }
 }

// Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {

     //sheetObj.ShowDebugMsg = false;
     switch(sAction) {

					case IBSEARCH:      //조회
						//doActionIBSheet_Search(sheetObj,formObj,sAction);
						//alert('조회');
						if(sheetObj.id == "sheet1"){
							//alert(FormQueryString(formObj));
							formObj.f_cmd.value = SEARCH01;

							//var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
							//alert(addParam);
							//alert(formObj.vvd.value.length);
							//if(formObj.vvd.value.length != 0  && formObj.vvd.value.length != 6 && formObj.vvd.value.length != 9){
							//	ComShowCodeMessage("BKG00007");
							//	formObj.vvd.focus();
							//	return;
							//}

							ComOpenWait(true);
							sheetObj.DoSearch("ESM_BKG_0956GS.do"
												,FormQueryString(formObj)
														+ "&"
														+ "bkg_no="+strBkgNo
														+ "&"
														+ ComGetPrefixParam("sheet1_")
												);
						}
					break;

					case IBSAVE:        //저장
						formObj.f_cmd.value = MULTI01;

						var sParam = FormQueryString(formObj);

						sparam = sParam + "&" + ComGetPrefixParam("sheet1_");


						if(! sheetObj.IsDataModified){
							 ComShowCodeMessage('BKG00743');
							 return false;
						}

						// Hold 체크박스를 선택하지 않고 remark 만 입력후 저장시 하기 에러 메세지 출력 후 작업중지
						// =>[BKG40048]
						// Hold 체크박스 체크 후  remark 입력하지 않고 저장 시 하기 에러 메세지 출력 후 작업중지
						// =>[BKG40049]

						for(var i=1;i<=sheetObj.RowCount;i++){

							if(sheetObj.CellValue(i,"sheet1_" + "hld_flg") == "0"
									&& sheetObj.CellValue(i,"sheet1_" + "hld_rsn") != ""
									 ){
								ComShowCodeMessage("BKG40048");
								return;
							}


							if(sheetObj.CellValue(i,"sheet1_" + "hld_flg") == "1"
									&& sheetObj.CellValue(i,"sheet1_" + "hld_rsn") == ""
									 ){
								ComShowCodeMessage("BKG40049");
								return;

							}

						}






						sheetObj.DoSave("ESM_BKG_0956GS.do", sparam);
					break;

					case IBINSERT:      // 입력
					break;
     }
 }



 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
//         if (!isNumber(formObj.iPage)) {
//             return false;
//         }
     }

     return true;
 }

//업무 자바스크립트 OnKeyDown 이벤트 Catch
function initControl() {
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);

}

function sheet1_OnSaveEnd(sheetObj, errMsg){
	//저장후 다시 읽어들임.
	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	if(errMsg == ""){
		self.close();
	}
}

/**
* 더블클릭 이벤트 발생시
**/
function sheet1_OnClick(sheetObj, Row, Col){
	var colName = sheetObj.ColSaveName(Col);
	var prefix = "sheet1_";
	//alert(colName);
	if(colName == prefix + "hld_rsn"){
		sheetObj.CellEditable(Row, Col) = false;
		ComShowMemoPad(sheetObj, Row, Col, false, 200, 100, 200 );
		sheetObj.CellEditable(Row, Col) = true;
	}
}

    /* 개발자 작업  끝 */
