/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0243.js
*@FileTitle : Integrated Customer Data Management
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
 * @class esm_bkg_0243 : esm_bkg_0243 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0243() {
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

      /*******************************************************/
      var formObj = document.form;

 	//try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

				case "btn_set":
					alert("btn_set");
				break;

				case "btn_close"://Close 버튼 클릭
					//aa.innerText = "asdfasdfasdfasdfasdfasdfasdf";
					window.close();
				break;

				case "btn_setup_arrival_info"://Setup Arrival Info 저장

					//formObj.f_cmd.value = MULTI01;
					//sheetObjects[1].DoSave("ESM_BKG_0243GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet2_"),-1,false);

					//opener 한 창으로 데이터 입력으로 요구조건 변경
					fncSetup();

				break;

				case "btn_mnr_rtn_yard_setup"://MNR RTN Yard Setup 조회팝업
					fncT2CustomerInfoClick(formObj.vvd.value);
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

 function loadPage(){
	 var formObj = document.form;

	 for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
	            ComConfigSheet (sheetObjects[i] );

	            initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	            ComEndConfigSheet(sheetObjects[i]);
	  }
	 initControl();
	 //화면 로딩시 param 으로 넘어온 데이터를 세팅한다.
	 fncInitData();

	 doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);


	 if(strOfc_cd == "ANRSO"||strOfc_cd == "RTMSC"){ //@ 2015.08.03 한진그룹 코드 표준화
		ComBtnEnable("btn_mnr_rtn_yard_setup");
		//<8.10>Log-In ID가 ANRBS(TES_ANRBS)인 경우, [Empty Return CY]는 비활성화되어야 함
		formObj.rtn_yd_cd.readOnly = true;
		formObj.rtn_yd_cd.className="input2";

	 }else{
		ComBtnDisable("btn_mnr_rtn_yard_setup");
		formObj.rtn_yd_cd.readOnly = false;
		formObj.rtn_yd_cd.className="input";
	 }


	//부모창으로 부터 vvd를 받아 combo 생성
	fncSplit2Combo(form.vvd, dialogArguments.form.vvd0243list.value, arrColValues[1]);



 }


function initControl(){
	axon_event.addListener("beforedeactivate", 'obj_deactivate', form);
	axon_event.addListenerForm('keyup','obj_keyup', form);

}
function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}

 /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;

     switch(sheetNo) {
     //조회할 용도로 사용
         case 1:      // sheet1 init
             with (sheetObj) {

                 // 높이 설정
                 style.height = 117;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 //MergeSheet = msAll;
                 MergeSheet = msNone;


                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(6, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 //var HeadTitle = "||Code|Name|Country|City|Address|Tel.|Fax|E-mail|Status|Blacklisted|Create Date|Primary Sale Rep|S/Office";
                 var HeadTitle = "||an_seq|an_fom_cd|addr_ctnt|impt_ntc_rmk";


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

				var sheetName = "sheet1_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		sheetName + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,	false,		sheetName + "Seq",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,		sheetName + "an_seq",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					125,	daLeft,	false,		sheetName + "an_fom_cd",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	false,		sheetName + "addr_ctnt",		false,		"",	dfNone,		0,		false,		false);

				//InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		sheetName + "cty_nm",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					290,	daLeft,		false,		sheetName + "impt_ntc_rmk",		false,		"",	dfNone,		0,		false,		false);

				//InitUserFormat2(0, sheetName +"booking_alert_to_date", "####-##-## ##:##", "-|:" );
				//InitUserFormat2(0, sheetName +"cre_dt", "####-##-## ##:##", "-|:" );

				DataRowMerge(0) = true;

            }
             break;
         //저장할 데이터용도로 사용
         case 2:      // sheet2 init
             with (sheetObj) {

                 // 높이 설정
                 style.height = 117;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(14, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 //var HeadTitle = "||Code|Name|Country|City|Address|Tel.|Fax|E-mail|Status|Blacklisted|Create Date|Primary Sale Rep|S/Office";
                 var HeadTitle = "||vvd|pod_arr_dt|del_arr_dt|pkup_aval_dt|pkup_free_dt|pkup_yd_cd|rtn_yd_cd|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|an_fom_cd";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

				var sheetName = "sheet2_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,	false,		sheetName + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,	false,		sheetName + "Seq",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,	false,		sheetName + "vvd",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,		sheetName + "pod_arr_dt",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					125,	daLeft,	false,		sheetName + "del_arr_dt",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					40,		daCenter,	false,		sheetName + "pkup_aval_dt",		false,		"",	dfNone,		0,		false,		false);

				InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		sheetName + "pkup_free_dt",				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					70,	daLeft,		false,		sheetName + "pkup_yd_cd",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,					70,	daLeft,		false,		sheetName + "rtn_yd_cd",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,					70,	daLeft,		false,		sheetName + "bkg_no",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,            80,        daCenter,    false,        sheetName + "vsl_cd",          false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,            80,        daCenter,    false,        sheetName + "skd_voy_no",          false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,            80,        daCenter,    false,        sheetName + "skd_dir_cd",          false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,            80,        daCenter,    false,        sheetName + "an_fom_cd",          false,        "",    dfNone,        0,        false,        false);

				//InitUserFormat2(0, sheetName +"booking_alert_to_date", "####-##-## ##:##", "-|:" );
				//InitUserFormat2(0, sheetName +"cre_dt", "####-##-## ##:##", "-|:" );

				DataRowMerge(0) = true;

            }
             break;
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

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = false;


		switch(sAction) {

				case IBSEARCH:      //조회
					//doActionIBSheet_Search(sheetObj,formObj,sAction);
					if(sheetObj.id == "sheet1"){
						//alert(FormQueryString(formObj));
						formObj.f_cmd.value = SEARCH01;
						//var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
						//alert(addParam);

						ComOpenWait(true);
						sheetObj.DoSearch("ESM_BKG_0243GS.do"
											,FormQueryString(formObj)
													+ "&"
													+ ComGetPrefixParam("sheet1_")
											);
					}
				break;

				case IBSAVE:        //저장
					//doActionIBSheet_Save(sheetObj,formObj,sAction);
					//doActionIBSheet(sheetObjects[beforetab+1],formObj,IBSEARCH);

				break;

				case IBINSERT:      // 입력
				break;

	    }
	}
/**
 * 화면 로딩시 param 으로 넘어온 데이터를 세팅한다.
 * @return
 */
function fncInitData(){

	//var arrColNames = new Array("vsl_nm","vvd","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd");
	var arrColNames = new Array("vsl_nm","vvd","vsl_flg","vsl_flg_cnt_nm","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","diff_rmk","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd"); //2011.08.04 diff_rmk 추가
	var formObj = document.form;

	for(var i=0;i<arrColNames.length;i++){
		var valObj = document.getElementById(arrColNames[i]);

		if(arrColNames[i] == "diff_rmk"){ //2011.08.04 Remark 추가
			valObj.value = decodeURIComponent(arrColValues[i]);//text box 에 값을 설정
		}else{
			valObj.value = arrColValues[i];//text box 에 값을 설정
		}
		//valObj.value = arrColValues[i];//text box 에 값을 설정
		if(valObj.value == "Y"){
			valObj.checked = true;
		}else{
			valObj.checked = false;
		}
		if(arrColNames[i] == "ntc_rvis_flg"){
			break;
		}
	}

	sheetObjects[1].DataInsert(-1);
	for(var k=0;k<arrColNames.length;k++){
		sheetObjects[1].CellText(1,"sheet2_"+arrColNames[k]) = arrColValues[k];
	}

	//alert("dialogArguments.document.form.pod_cd.value " + dialogArguments.document.form.pod_cd.value);

	//if(typeof(opener) != "undefined"){
	//	formObj.pod_cd.value = dialogArguments.document.form.pod_cd.value;
	//}
	//alert(formObj.an_fom_cd.value);

}
/**
 * MNR RTN Yard Setup 로 이동(0052)
 * @return
 */
function fncT2CustomerInfoClick(vvd){
	var goUrl = "";
	goUrl = "/hanjin/ESM_BKG_0052.do?";

	ComOpenWindowCenter(goUrl+"vvd="+encodeURI(vvd),"ESM_BKG_0052",700,420,true);

}
/**
 *
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;

	//값 초기화
	formObj.addr_cnt.value = "";
	formObj.impt_ntc_rmk.value = "";

	if(sheetObj.RowCount > 0){
		formObj.addr_cnt.value = sheetObj.CellValue(1,"sheet1_"+"addr_ctnt");
		formObj.impt_ntc_rmk.value = sheetObj.CellValue(1,"sheet1_"+"impt_ntc_rmk");
	}


	ComOpenWait(false);
}
/**
 * an_fom_cd 값의 변경에 따라
 * @param obj
 * @return
 */
function fncAnFomCdChange(obj){
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
}


function fncBlur(obj){
	var formObj = document.form;
	var colName = obj.id;

	var chkObj = document.getElementById(colName+ "_chk");
	var valObj = document.getElementById(colName);

	if(sheetObjects[1].CellValue(1,"sheet2_"+colName) != valObj.value){
			chkObj.checked = true;
			valObj.style.color="blue";
			sheetObjects[1].CellValue(1,"sheet2_"+colName) = valObj.value;
	}else{
			//valObj.style.color="";
			chkObj.checked = false;
	}
	if(document.getElementById(obj.id+ "_null") != undefined){
		checkNull(obj);
	}

	/***************

	if(obj.name == "vsl_nm"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"vsl_nm") != obj.value){
			formObj.vsl_nm_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"vsl_nm") = obj.value;
		}else{
			formObj.vsl_nm_chk.checked = false;
		}
	}
	if(obj.name == "pod_arr_dt"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"pod_arr_dt") != obj.value){
			formObj.pod_arr_dt_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"pod_arr_dt") = obj.value;
		}else{
			formObj.pod_arr_dt_chk.checked = false;
		}
	}
	if(obj.name == "pod_arr_dt"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"pod_arr_dt") != obj.value){
			formObj.pod_arr_dt_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"pod_arr_dt") = obj.value;
		}else{
			formObj.pod_arr_dt_chk.checked = false;
		}
	}
	if(obj.name == "del_arr_dt"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"del_arr_dt") != obj.value){
			formObj.del_arr_dt_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"del_arr_dt") = obj.value;
		}else{
			formObj.del_arr_dt_chk.checked = false;
		}
	}
	if(obj.name == "pkup_aval_dt"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"pkup_aval_dt") != obj.value){
			formObj.pkup_aval_dt_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"pkup_aval_dt") = obj.value;
		}else{
			formObj.pkup_aval_dt_chk.checked = false;
		}
	}
	if(obj.name == "pkup_free_dt"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"pkup_free_dt") != obj.value){
			formObj.pkup_free_dt_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"pkup_free_dt") = obj.value;
		}else{
			formObj.pkup_free_dt_chk.checked = false;
		}
	}
	if(obj.name == "pkup_yd_cd"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"pkup_yd_cd") != obj.value){
			formObj.pkup_yd_cd_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"pkup_yd_cd") = obj.value;
		}else{
			formObj.pkup_yd_cd_chk.checked = false;
		}
	}
	if(obj.name == "rtn_yd_cd"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"rtn_yd_cd") != obj.value){
			formObj.rtn_yd_cd_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"rtn_yd_cd") = obj.value;
		}else{
			formObj.rtn_yd_cd_chk.checked = false;
		}
	}
	if(obj.name == "an_fom_cd"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"an_fom_cd") != obj.value){
			formObj.an_fom_cd_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"an_fom_cd") = obj.value;
		}else{
			formObj.an_fom_cd_chk.checked = false;
		}
	}
	if(obj.name == "chn_agn_cd"){
		if(sheetObjects[1].CellValue(1,"sheet2_"+"chn_agn_cd") != obj.value){
			formObj.chn_agn_cd_chk.checked = true;
			sheetObjects[1].CellValue(1,"sheet2_"+"chn_agn_cd") = obj.value;
		}else{
			formObj.chn_agn_cd_chk.checked = false;
		}
	}

	***********/
}

function sheet2_OnSaveEnd(sheetObj, errMsg){
	if (errMsg == "") {
		ComBkgSaveCompleted();

		self.close();
		//doActionIBSheet(sheetObj,document.form,IBSEARCH);
  	}
}

/**
*체크박스 클릭시 데이터 초기화
*<7.31>입력필드에 값을 입력 후 Focus Out시 왼쪽 체크박스에 자동 체크가 되는데...그 상태에서 체크박스를 Un Check 했을 경우 해당 필드를 초기화 함
    즉,,,,닦어버리세요^^
*/
function fncCheckboxOnClick(colName){
	//<7.31>4. 입력필드에 값을 입력 후 Focus Out시 왼쪽 체크박스에 자동 체크가 되는데...그 상태에서 체크박스를 Un Check 했을 경우 해당 필드를 초기화 함
	var formObj = document.form;


	var chkObj = document.getElementById(colName+ "_chk");
	var valObj = document.getElementById(colName);

	//<8.12>필드에 값 입력 후 왼 쪽에 Check Box를 Uncheck 했을때 필드 값을 닦아달라고했는데..
	// 딱지 말고 그냥 두라고합니다.^^
	if(!chkObj.checked){
		//valObj.value = "";
	}

}



/**
* 팝업에서 수정된 값을 부모창으로 세팅
*
*/

function fncSetup(){
	var formObj = document.form;
	var selectVVD = formObj.vvd.value;

	//<8.10> 6-1)[ETA POD]는 반드시 [ETA DEL],[Available Date],[Free Date] 보다 늦어야됨. [BKG04009] 출력
	//pod_arr_dt, (del_arr_dt, pkup_aval_dt,pkup_free_dt)


	if(formObj.del_arr_dt.value != ""
		&& ComGetDaysBetween(formObj.pod_arr_dt.value,formObj.del_arr_dt.value) < 0){
		ComShowCodeMessage("BKG04009","ETA DEL");
		return;
	}
	if(formObj.pkup_aval_dt.value != ""
		&& ComGetDaysBetween(formObj.pod_arr_dt.value,formObj.pkup_aval_dt.value) < 0){
		ComShowCodeMessage("BKG04009","Available Date");
		return;
	}
	if(formObj.pkup_free_dt.value != ""
		&& ComGetDaysBetween(formObj.pod_arr_dt.value,formObj.pkup_free_dt.value) < 0){
		ComShowCodeMessage("BKG04009","Free Date");
		return;
	}

	//<8.7>6. 변경 후 Set Up Arrival Info 버튼 클릭 시 하기 내용에대한 유효성 체크
	//  => Full CNTR P/Up CY , Empty Return CY : 자릿수 체크(7자리 )  = > [ BKG01078 ] 경고 메세지 후 해당 필드로 포커스 Out
	if(formObj.pkup_yd_cd.value.length > 0 && formObj.pkup_yd_cd.value.length != 7){
		ComShowCodeMessage("BKG01078","Full CNTR P/Up CY");
		formObj.pkup_yd_cd.focus();
		return;
	}
	//<8.10>Empty Return CY]는 Setup하기 위한 필수 항목이 아닙니다. Error Message " The yard Code(Empty Return CY) is invalid !"는 뺴주세요.
	if(formObj.rtn_yd_cd.value.length > 0 && formObj.rtn_yd_cd.value.length != 7){
		ComShowCodeMessage("BKG01078","Empty Return CY");
		formObj.rtn_yd_cd.focus();
		return;
	}



	//opener 에 있는 함수를 호출해서 값을 넣음.

	dialogArguments.fncSetupFrom243(document,selectVVD);

	if(formObj.vvd.options.length > 1){
		//alert("완료");
		ComShowCodeMessage("BKG40067",selectVVD);
	}



	//<09.03>combo 의 값이 1일경우 부모창으로 값을 설정후 창을 자동으로 닫음.
	if(formObj.vvd.options.length == 1){
		self.close();
	}
	//alert(formObj.vvd.options.length);

}

/**
* 시간 포맷이 맞을경우 00:00 을 자동으로 입력
*/
function fncAutoSettingTime(obj){
	var val = obj.value;

	if(ComIsDate(val)){
		//alert("포맷이 맞다");
		obj.value = val + " " + "00:00";
	}

}


//문자열을 잘라, combo에 입력
function fncSplit2Combo(obj, pStr, vvd){
	//var pStr = "AAA/BBB/CCC/DDD/";
	var arr = fncSplit2Arr(pStr);
	//var obj = form.combo1;
	//ComDebug("vvd " + vvd );

	var dbg = "";
	for(var i=0;i<arr.length-1;i++){
		//dbg += " <" + i + "> [" + arr[i] + "]";
		//dbg += "\n";

		var oOption = document.createElement("OPTION");
		obj.options.add(oOption);
		oOption.innerText = arr[i];
		oOption.value = arr[i];

		//alert(vvd + " " + arr[i]);

		if(vvd == arr[i]){

			oOption.selected = true;

		}
	}

	//alert("\n결과 " + dbg);

}


//문자열을 잘라 배열로 리턴
function fncSplit2Arr(pStr){
	var arr = pStr.split("/");
	return arr;

}

function fncChangeVVD(obj){
	//alert(obj.value);

	var parentSheetObj = dialogArguments.sheetObjects["t2sheet1"];
	var tmpVvd = obj.value;

	//ComDebug("tmpVvd " + tmpVvd);


	for(var i=0;i<parentSheetObj.RowCount;i++){
		if(parentSheetObj.CellValue(i,"t2sheet1_vvd") == tmpVvd){
			//alert(tmpVvd);
			dialogArguments.t2sheet1_OnClick(parentSheetObj, i+1, 2, "");
			dialogArguments.fncT2SetDataClick();
			break;
		}

	}

}


function checkNull(obj){

	var objNull = document.getElementById(obj.id+ "_null");

	if(obj.value == '') {
		objNull.checked=true;
	}else{
		objNull.checked=false;
	}
}

// Remark의 글자수 제한
function  obj_keyup(){

	switch (event.srcElement.name) {
		case "diff_rmk":
	     	var frm = document.form.diff_rmk.value.length;
	     	if(frm > 500){
	     		ComShowCodeMessage("BKG01137", "500");
	     		document.form.diff_rmk.value = document.form.diff_rmk.value.substring(0, 500);
	     	}
	 break;
	}
}
    /* 개발자 작업  끝 */
