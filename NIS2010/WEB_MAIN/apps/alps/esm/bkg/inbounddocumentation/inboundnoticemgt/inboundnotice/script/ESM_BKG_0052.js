/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0052.js
*@FileTitle : MRN & Return yard Setup
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
 * @class esm_bkg_0052 : esm_bkg_0052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0052() {
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
	  var sheetObject1 = sheetObjects[1];
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
									if(confirm(ComGetMsg("BKG00168"))){
										window.close();
									}
								}
								window.close();
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
     formObj.vvd.value = strVvd;

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
                 InitColumnInfo(8, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, false, true, false,false)

                 var HeadTitle1 = "ibflag|Seq.|BL NO|BKG NO|Container No.|MRN|RTN YD|Reference";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 var prefix = "sheet1_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    0,      daCenter,    false,      prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,			40,	  	daCenter,		false,		prefix + "Seq",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,	  	daCenter,		false,		prefix + "bl_no",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			80,	  	daCenter,		false,		prefix + "bkg_no",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		prefix + "cntr_no",		false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daCenter,		false,		prefix + "vsl_mrn_no",			false,			"",      dfNone,			0,		true,		true,19);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		false,		prefix + "mty_rtn_yd_cd",		false,			"",      dfNone,			0,		true,		true,7);
				InitDataProperty(0, cnt++ , dtData,			260,	daLeft,			false,		prefix + "rtn_ref_no",		false,			"",      dfNone,			0,		true,		true, 25);

				InitDataValid(0, prefix + "mty_rtn_yd_cd", vtEngUpOther, "1234567890");
				WaitImageVisible = false;

            }
             break;
		case 2:      //sheet2 init
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
                 InitColumnInfo(8, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, false, true, false,false)

                 var HeadTitle1 = "ibflag|Seq.|BL NO|BKG NO|Container No.|MRN|RTN YD|Reference";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 var prefix = "sheet2_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    0,      daCenter,    false,      prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,			40,	  	daCenter,		false,		prefix + "Seq",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,	  	daCenter,		false,		prefix + "bl_no",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			80,	  	daCenter,		false,		prefix + "bkg_no",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		prefix + "cntr_no",		false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix + "vsl_mrn_no",			false,			"",      dfNone,			0,		true,		true,19);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		false,		prefix + "mty_rtn_yd_cd",		false,			"",      dfNone,			0,		true,		true,7);
				InitDataProperty(0, cnt++ , dtData,			260,	daLeft,			false,		prefix + "rtn_ref_no",		false,			"",      dfNone,			0,		true,		true, 100);

				InitDataValid(0, prefix + "mty_rtn_yd_cd", vtEngUpOther, "1234567890");

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
							if(formObj.vvd.value.length != 0  && formObj.vvd.value.length != 6 && formObj.vvd.value.length != 9){
								ComShowCodeMessage("BKG00007");
								formObj.vvd.focus();
								return;
							}
							ComOpenWait(true);
							sheetObj.DoSearch("ESM_BKG_0052GS.do"
												,FormQueryString(formObj)
														+ "&"
														+ ComGetPrefixParam("sheet1_")
												);
						}
					break;

					case IBSAVE:        //저장
						if(validateForm(sheetObj,formObj,sAction))
							fncSave();
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



function sheet1_OnSaveEnd(sheetObj, errMsg){
	//저장후 다시 읽어들임.
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
* 1. grid validation 처리
* 2. grid 저장 처리.
*/
function fncSave(){
	var formObject = document.form;
	var sheetObj = sheetObjects[0];
	var prefix = "sheet1_";

	//<8.7>2.MRN 7~ 19 자리
	//RTN YD ; 7자리 대문자
	//Reference 100자
	for(var i=1;i<sheetObj.RowCount;i++){
		if(     sheetObj.CellValue(i,prefix + "vsl_mrn_no").length != 0
			&&	  (sheetObj.CellValue(i,prefix + "vsl_mrn_no").length < 7
			||    sheetObj.CellValue(i,prefix + "vsl_mrn_no").length > 18)   ){
			//alert("7자리 이상 10자리 이하로 입력가능합니다");
			ComShowCodeMessage("BKG40105","MRN");
			sheetObj.SelectCell(i,prefix + "vsl_mrn_no") ;
			return;
		}
		if(    sheetObj.CellValue(i,prefix + "mty_rtn_yd_cd").length != 0
			&& sheetObj.CellValue(i,prefix + "mty_rtn_yd_cd").length != 7 ){
			//ComShowCodeMessage("BKG01078");
			//alert("7자리만 입력가능합니다");
			ComShowCodeMessage("BKG40106","7");
			sheetObj.SelectCell(i,prefix + "mty_rtn_yd_cd") ;
			return;
		}
		if(        sheetObj.CellValue(i,prefix + "rtn_ref_no").length > 100 ){
			//alert("100자리이하로만 입력할수 있습니다.");
			ComShowCodeMessage("BKG40106","REF NO","100");
			sheetObj.SelectCell(i,prefix + "rtn_ref_no") ;
			return;
		}
	}


	formObject.f_cmd.value = MULTI01;

	var param = "&vvd="+formObject.vvd.value;

	sheetObj.DoSave("ESM_BKG_0052GS.do", FormQueryString(formObject) + param + "&" + ComGetPrefixParam("sheet1_"));
}


/**
 * 엑셀업로드 완료시 실행 이벤트
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadExcel(sheetObj){
	//alert("엑셀업로드 후 이벤트");
	var sheetOrg;
	var sheetNew;
	var cnt = 0;
	var lineNumber = 0;
	var colName = 0;

	sheetOrg = sheetObj;
	sheetNew = sheetObjects[1];
	sheetOrg.DataAutoTrim = true;
	sheetNew.DataAutoTrim = true;

	//alert(sheetOrg.id);
	//alert(sheetNew.id);
	//2010-03-30 by sungho
	//엑셀업로드시 알수없는 데이터가 들어감을 처리
	for(var i=1;i <= sheetOrg.RowCount+1;i++){
		if(sheetOrg.CellValue(i,"sheet1_"+"bl_no") == ""){
			sheetOrg.RowDelete(i,false);
		}
	}



	if(sheetOrg.RowCount != sheetNew.RowCount){
		//ComShowMessage("Excel Data의 Row수가 다릅니다.\n다시조회후 사용하십시오.");
		ComShowCodeMessage("BKG43041");
		return;
	}
	ComBtnDisable("btn_save");
	for(var i=2;i <= sheetOrg.RowCount;i++){
		//1.데이터를 비교하여 키값이 다를경우 오류 리턴
		//2.key ; bl_no,cust_nm
		//3.bkg_no,bkg_cust_tp_cd 값을 세팅 ; 엑셀업로드시 없으므로

		if(fncDiff( sheetOrg.CellValue(i,"sheet1_"+"bl_no"),sheetNew.CellValue(i,"sheet2_"+"bl_no") )){
			colName = "bl_no";
			lineNumber = i;
			cnt++;
			//break;
		}
		if(fncDiff( sheetOrg.CellValue(i,"sheet1_"+"cntr_no"),sheetNew.CellValue(i,"sheet2_"+"cntr_no") )){
			//alert(sheetOrg.CellValue(i,"sheet1_"+"cntr_no"));
			//alert(sheetOrg.CellValue(i,"sheet2_"+"cntr_no"));
			colName = "cntr_no";
			lineNumber = i;
			cnt++;

			//break;
		}

		sheetOrg.CellValue(i,"sheet1_"+"bl_no") = sheetNew.CellValue(i,"sheet2_"+"bl_no");
		sheetOrg.CellValue(i,"sheet1_"+"cntr_no") = sheetNew.CellValue(i,"sheet2_"+"cntr_no");
		//sheetOrg.CellValue(i,"sheet1_"+"is_validated") = sheetNew.CellValue(i,"sheet2_"+"is_validated");

	}

	if(cnt > 0){
		//ComShowMessage("Excel Data (" + colName + ") 가 잘못되었습니다.\n다시조회후 사용하십시오.(Line No. : "+ lineNumber + ")");
		ComShowCodeMessage("BKG43042");
	}else{
		ComBtnEnable("btn_save");
	}
}

/**
 * 두개의 문자열 비교
 * 동일 ; 리턴 true
 * @param orgStr
 * @param newStr
 * @return
 */
function fncDiff(orgStr,newStr){
	orgStr = orgStr.replace(eval("/\\r\\n/gi"), " ").trim();
	newStr = newStr.replace(eval("/\\r\\n/gi"), " ").trim();

	//alert("["+orgStr+"]" +"["+newStr+"]");


	if(orgStr != newStr){
		return true;
	}else{
		return false;
	}
}
/**
 * t4sheet1 의 데이터 조회완료시
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	//1.결과 값이 없을경우 save 버튼 disable
	//is_validated 의 값에 따라 처리

	//alert("search t4sheet1 end");
    with(sheetObj)
    {

    	if(rowcount < 1){
    		ComBtnDisable("btn_save");
    	}else{
    		ComBtnEnable("btn_save");
    	}


        //CheckAll2("t2sheet1_Chk")  = true;
    	//t4sheet2 그리드로 데이터 복사
    	var xmlStr = IBS_GetDataSearchXml(sheetObj);//sheet를 xml 로 변환
    	sheetObjects[1].LoadSearchXml(xmlStr,false);//xml 데이터를 로딩

		ComOpenWait(false);

    }
}
    /* 개발자 작업  끝 */
