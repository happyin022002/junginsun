/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0375.js
 *@FileTitle : Arrival Notice Form Setting
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.04.28 박만건
 * 1.0 Creation
 * 2009.06.30 박성호 수정
 * 2009.09.20 박만건 수정
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
  * @fileoverview Arrival Notice Form Setting을 위한 처리로직을 구현한다.
  * @author Park Mangeon
  */

/**
 * @extends
 * @class esm_bkg_0375 : esm_bkg_0375 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0375() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
    this.obj_keypress           = obj_keypress;
    this.setComboObject         = setComboObject;
}

       /* 개발자 작업    */


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// MultiComboBox관련 변수
var comboObjects = new Array();
var comboCnt = 0;
var bMultiComboDataAdded = false;
var vComboData = "";

// 화면 상태 변경 관련
var screenStatus = "N";  // NCRX N:초기상태[조회가능], C:신규상태[저장 가능], R:조회상태[저장,삭제가능] X:조회조건 변경[조회가능]
var dataStatus = "N";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    var sheetObject1 = sheetObjects[0];

    var comboObject1 = comboObjects[0];
    /*******************************************************/
    var formObject = document.form;

    //try {
    var srcName = window.event.srcElement.getAttribute("name");
    if (!ComIsBtnEnable(srcName)){ return; }
    switch(srcName) {
        case "btn_Retrieve":
            if (!validateForm(sheetObject1, formObject, IBSEARCH)) {return; }
            //if (  document.getElementsByName(srcName + "_tbl")[0].disabled ) { return; }
            ////////ComOpenWait(true, true);

            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;

        case "btn_New":
            if (screenStatus == "N") {
                // Please Click the Retrieve button before putting the data in the text fields
                ComShowCodeMessage("BKG00448");
                return;
            } else if (screenStatus == "X") {
                // There is no data in Text Fields of Office ["Value"], please put Text in the fields
                ComShowCodeMessage("BKG04016", formObject.ofc_cd.value);
                return;
            }

            //모든 데이터 초기화
            fncClearFormValue(formObject);
            sheetObject1.RemoveAll();
            dataStatus = "Y"; // 초기화로 수정했기 때문이다.
            break;

        case "btn_Save":
            if (screenStatus == "N") {
                // Please Click the Retrieve button before putting the data in the text fields
                ComShowCodeMessage("BKG00448");
                return;
            } else if (screenStatus == "X") {
                // There is no data in Text Fields of Office ["Value"], please put Text in the fields
                ComShowCodeMessage("BKG04016", formObject.ofc_cd.value);
                return;
            }

            if (dataStatus == "N") {
                // Nothing has been changed after data is retrieved
                ComShowCodeMessage("BKG00797");
                return;
            }
            doActionIBSheet(sheetObject1,formObject,IBSAVE);
            break;

        case "btn_Del":
            if (screenStatus == "C") {
                // 신규상태입니다.\n삭제할 대상이 없습니다
                ComShowCodeMessage("BKG03054");
                return;
            } else if (screenStatus == "N") {
                // Please Click the Retrieve button before putting the data in the text fields
                ComShowCodeMessage("BKG00448");
                return;
            } else if (screenStatus == "X") {

                // Searching option was changed. Please retrive first.
                ComShowCodeMessage("BKG03053");
                return;
            }

            if(ComShowCodeConfirm("COM12165")){ // Do you want to delete {?msg1}?
                dataFlagToIBSheet(sheetObject1, "D");
                doActionIBSheet(sheetObject1,formObject,IBDELETE);
            }
            break;

        case "btn_ANSetup":
            var cur_pod_cd = formObject.pod_cd.value;
            var autoSearchFlg = "Y";
            if (cur_pod_cd == "ALL" ) {
                cur_pod_cd = "";
                autoSearchFlg = "N";
            }
            var goUrl = "";
            var param = "";
            goUrl = "/hanjin/ESM_BKG_0672.do?";

            param += "1=1";
            param += "&pgmNo=ESM_BKG_0672-01";
            if (formObject.pod_cd.value != "ALL") {
                param += "&pod_cd=" + formObject.pod_cd.value;
            }

            //선택되지 않을경우는 No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param, "ESM_BKG_0672-01", 1024, 630, true);

            break;


    } // end switch
        //}catch(e) {
        //    if( e == "[object Error]") {
        //        ComShowMessage(OBJECT_ERROR);
        //    } else {
        //        ComShowMessage(e);
        //    }
        //}
}


/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 필수, Sheet개체
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function loadPage() {

    for(i=0;i<sheetObjects.length;i++){
    	// Sheet 칼럼만 초기화한다.
        initSheet(sheetObjects[i],i+1);
    }

    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }

    /*
     * 해당 프로그램은 sheet1_OnLoadFinish를 사용할 수 없다.
     * OnLoadFinish는 Load되면서 화면에 표시되는 sheet에 대해서만 발생하므로,
     * 해당 sheet는 hidden이므로 이벤트를 발생시키지 않는다.
     * 따라서 loadPage에서 처리해야만 한다.
     * description by Park Mangeon
     * date 20091113
     */
    initControl();
    screenStatus = "N";

    var formObj = document.form;
    fncSetPodCdCombo(sheetObjects[0],formObj);//POD Combo 설정
    formObj.pod_cd.value = formObj.pod_cd_combo[0].value;

    fncSetAgentCombo(sheetObjects[0],formObj);//Agent 콤보

    //로그인　사용자　Office 코드가　BEANR, NLRTM일 경우의 Default값은 Notify Lette
    fncInitANPreviewForm(formObj.login_ofc_cd, formObj.arr_prv_fom_cd);


    //초기화시 버튼
    formObj.ofc_cd.focus();
    fnChangeImeMode();
}

/**
 * 초기화 작업 : 이벤트를 등록한다.<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initControl() {
   //Axon 이벤트 처리1. 이벤트catch
   axon_event.addListenerForm('change', 'objChange', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리

   //대문자로 변경
   //axon_event.addListenerForm ('keydown' , 'objEnter', form);
   axon_event.addListenerForm ('keyup'   , 'objKeyUp', form);
   axon_event.addListenerForm ('keypress', 'objKeyPress', form);
   axon_event.addListenerForm ('deactivate', 'objDeactivate', form);
}

function objDeactivate() {
   var objName =event.srcElement.name;
   if(objName == "ge_impt_ntc_rmk"
       || objName == "dr_impt_ntc_rmk"
       || objName == "cy_impt_ntc_rmk"
       || objName == "cf_impt_ntc_rmk"
       || objName == "sp_impt_ntc_rmk"
       || objName == "e1_impt_ntc_rmk") {

	  var caption = event.srcElement.getAttribute("caption");
	  if(ComChkLenByByte(event.srcElement, 4000) == 0) {
		  ComShowCodeMessage("BKG43035", caption , 4000, ComGetLenByByte(event.srcElement));
	  }
   }
}

/**
 * Enter를 입력하였을 경우 textarea영역에서 자동조회가 되는 기능을 비활성화 시킨다.<br>
 * @param void
 * @return void
 */
function objEnter(obj) {
	//사용될 object 만 찍어서 반영.
	//2010-04-05
	//by sungho
	var formObj = document.form;

	if(event.keyCode == 13 && obj.name == "ofc_cd" ){
		if(formObj.ofc_cd.value.length >= 5){
			ComKeyEnter('LengthNextFocus');
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		}
	}else if(event.keyCode == 13 && obj.name == "pod_cd" ){
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}else if(event.keyCode == 13 && obj.name == "chn_agn_cd"){
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}

	return;

   var objName =event.srcElement.name;
   var formObj = document.form;
   if (objName == "arr_prv_fom_cd"
         || objName == "locl_lang_flg"
         || objName == "eclz_bl_cpy_flg"
         || objName == "ge_addr_ctnt" )
   {
    // Edit 영역은 enter시 조회되는 기능을 무시하도록 한다.
   } else if(objName == "ge_impt_ntc_rmk"
             || objName == "dr_addr_ctnt"
             || objName == "dr_impt_ntc_rmk"
             || objName == "cy_addr_ctnt"
             || objName == "cy_impt_ntc_rmk"
             || objName == "cf_addr_ctnt"
             || objName == "cf_impt_ntc_rmk"
             || objName == "sp_addr_ctnt"
             || objName == "sp_impt_ntc_rmk"
             || objName == "e1_addr_ctnt"
             || objName == "e1_impt_ntc_rmk")
   {
    // Edit 영역은 enter시 조회되는 기능을 무시하도록 한다.
       //fncTextareaMaxLine(event.srcElement.value);
   } else if(objName == "ofc_cd" ){
		if(formObj.ofc_cd.value.length >= 5){
			//document.getElementById("btn_Retrieve").fireEvent("onclick");
		}
   } else {
       ComKeyEnter();
   }
}

/**
 * Object 값의 변경시 발생 화면 변경 상태를 관리한다.<br>
 * @param void
 * @return void
 */
function objChange(){
    var objName =event.srcElement.name;
    var formObj = document.form;

    //조회 조건이 변경시 조회만 활성
    if(objName == "ofc_cd"
        || objName == "pod_cd"
        || objName == "pod_cd_combo"
        || objName == "chn_agn_cd"
        || objName == "chn_agn_cd_combo"
            )
    {
        if (screenStatus != "N") {
            screenStatus = "X";
            dataStatus = "N";
        }
    }

    if (objName == "arr_prv_fom_cd"
         || objName == "locl_lang_flg"
         || objName == "eclz_bl_cpy_flg"
         || objName == "ge_addr_ctnt"
         || objName == "ge_impt_ntc_rmk"
         || objName == "dr_addr_ctnt"
         || objName == "dr_impt_ntc_rmk"
         || objName == "cy_addr_ctnt"
         || objName == "cy_impt_ntc_rmk"
         || objName == "cf_addr_ctnt"
         || objName == "cf_impt_ntc_rmk"
         || objName == "sp_addr_ctnt"
         || objName == "sp_impt_ntc_rmk"
         || objName == "e1_addr_ctnt"
         || objName == "e1_impt_ntc_rmk" )
    {
        dataStatus = "Y";
    }

    if (objName == "locl_lang_flg") {
        fnChangeImeMode();
    }

    switch (objName) {
        case "ofc_cd":
			if(formObj.ofc_cd.value.length >= 5){
				fncSetPodCdCombo(sheetObjects[0],formObj);
				fncSetAgentCombo(sheetObjects[0],formObj);
			}
            break;
        case "pod_cd_combo":
            fncPodCdComboOnChange(event.srcElement);
            break;
        case "chn_agn_cd_combo":
            fncAgentComboOnChange(event.srcElement);
            break;
    }
}

/**
 * Object 값의 변경시 발생 화면 변경 상태를 관리한다.<br>
 * @param void
 * @return void
 */
function objKeyUp(){
    var objName =event.srcElement.name;
    var formObj = document.form;
	//2010-04-05
	//by sungho ; 자동으로 이동 키이벤트 제거
    switch(objName) {
        case "ofc_cd":

			//ComKeyEnter('LengthNextFocus');

            break;
        case "pod_cd":
            fncPodCdKeyUp(event.srcElement);
            //ComKeyEnter('LengthNextFocus');
            break;
        case "chn_agn_cd":
            fncAgentKeyUp(event.srcElement);
            //ComKeyEnter('LengthNextFocus');
            break;
        case "pod_cd_combo":
            //ComKeyEnter('LengthNextFocus');
            break;
        case "chn_agn_cd_combo":
            //ComKeyEnter('LengthNextFocus');
            break;
    }
}
/**
 * locl_lang_flg 값에 따라 ime-mode를 설정한다.<br>
 * @param void
 * @return void
 */
function fnChangeImeMode() {
   var formObj = document.form;
    if (formObj.locl_lang_flg[0].selected == true) {
       formObj.ge_addr_ctnt.style.imeMode="disabled";
       formObj.ge_impt_ntc_rmk.style.imeMode="disabled";
       formObj.dr_addr_ctnt.style.imeMode="disabled";
       formObj.dr_impt_ntc_rmk.style.imeMode="disabled";
       formObj.cy_addr_ctnt.style.imeMode="disabled";
       formObj.cy_impt_ntc_rmk.style.imeMode="disabled";
       formObj.cf_addr_ctnt.style.imeMode="disabled";
       formObj.cf_impt_ntc_rmk.style.imeMode="disabled";
       formObj.sp_addr_ctnt.style.imeMode="disabled";
       formObj.sp_impt_ntc_rmk.style.imeMode="disabled";
       formObj.e1_addr_ctnt.style.imeMode="disabled";
       formObj.e1_impt_ntc_rmk.style.imeMode="disabled";
   } else {
       formObj.ge_addr_ctnt.style.imeMode="active";
       formObj.ge_impt_ntc_rmk.style.imeMode="active";
       formObj.dr_addr_ctnt.style.imeMode="active";
       formObj.dr_impt_ntc_rmk.style.imeMode="active";
       formObj.cy_addr_ctnt.style.imeMode="active";
       formObj.cy_impt_ntc_rmk.style.imeMode="active";
       formObj.cf_addr_ctnt.style.imeMode="active";
       formObj.cf_impt_ntc_rmk.style.imeMode="active";
       formObj.sp_addr_ctnt.style.imeMode="active";
       formObj.sp_impt_ntc_rmk.style.imeMode="active";
       formObj.e1_addr_ctnt.style.imeMode="active";
       formObj.e1_impt_ntc_rmk.style.imeMode="active";
   }

}


 /**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {int} sheetNo 필수, Sheet Index
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;
    var sheetID = sheetObj.id;
    switch (sheetID) {

    case "sheet1"://Detail Grid
        with (sheetObj) {
            style.height = 0;
            Editable = true;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 100);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(4, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false)

            var HeadTitle = "status|an_fom_cd|addr_ctnt|impt_ntc_rmk";

            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]

            var prefix = "sheet1_";
            InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, prefix + "ibflag");
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, prefix + "an_fom_cd", false, "", dfNone,0,    true,true);
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, prefix + "addr_ctnt", false, "", dfNone,0,    true,true);
            InitDataProperty(0, cnt++ , dtData,    100, daCenter, true, prefix + "impt_ntc_rmk", false, "", dfNone,0,    true,true);
        }
        break;


    }
}


/**
 * IBTab Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} tabObj 필수, tab개체
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;
}


/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} tabObj 필수, tab개체
 * @param {int} nItem 필수, index
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {

                var cnt  = 0 ;
                InsertTab( cnt++ , "General" , -1 );
                InsertTab( cnt++ , "Door" , -1 );
                InsertTab( cnt++ , "CY" , -1 );
                InsertTab( cnt++ , "CFS Cargo" , -1 );
                InsertTab( cnt++ , "Special Cargo" , -1 );
                InsertTab( cnt++ , "Event" , -1 );
            }
         break;

     }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} tabObj 필수, tab개체
 * @param {int} nItem 필수, index
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function tab1_OnChange(tabObj , nItem)
{


    var objs = document.all.item("tabLayer");
     objs[nItem].style.display = "Inline";
     objs[beforetab].style.display = "none";

     //--------------- 요기가 중요 --------------------------//
     objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     //------------------------------------------------------//
     beforetab= nItem;


     var formObj = document.form;
     if(beforetab == 0){
        formObj.ge_addr_ctnt.focus();
     }else if(beforetab == 1){
        formObj.dr_addr_ctnt.focus();
     }else if(beforetab == 2){
        formObj.cy_addr_ctnt.focus();
     }else if(beforetab == 3){
        formObj.cf_addr_ctnt.focus();
     }else if(beforetab == 4){
        formObj.sp_addr_ctnt.focus();
     }else if(beforetab == 5){
        formObj.e1_addr_ctnt.focus();
     }

}


/**
 * Sheet관련 프로세스 처리
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {Object} formObj 필수, 폼개체
 * @param {String} sAction 필수, 작업코드
 * @param {String} CondParam 선택, 이전 조회 조건정보
 * @param {int} pageNo 선택, 페이지 번호
 * @return {void}
 * @author Park Mangeon
 * @version 2009.10.01
 */
function doActionIBSheet(sheetObj,formObj, sAction) {

    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {

         case IBSEARCH:      //조회

            formObj.f_cmd.value = SEARCH;
         	ComOpenWait(true,true);
            sheetObj.DoSearch("ESM_BKG_0375GS.do"
                   ,fnFormStringUtil(FormQueryString(formObj))
                           + "&"
                           + ComGetPrefixParam("sheet1_")
                   );

               //조회 완료이벤트 발생후 로직처리필요.(sheet1_OnSearchEnd 함수로 이동)

            break;

        case IBSAVE:        //저장
             //save-1.저장시 grid 로 모든값을 복사한다.
        	 if(!validateForm(sheetObj,formObj,sAction))return;
             sheetObj.removeAll();

             var arr_prv_fom_cd_value = "";
             for(var k=0;k<formObj.arr_prv_fom_cd.length;k++){
                 if(formObj.arr_prv_fom_cd[k].checked){
                     arr_prv_fom_cd_value = formObj.arr_prv_fom_cd[k].value;
                 }
             }

            sheetObj.DataInsert(-1);
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "an_fom_cd") = "CF";
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "addr_ctnt") = formObj.cf_addr_ctnt.value;
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "impt_ntc_rmk") = formObj.cf_impt_ntc_rmk.value;

            sheetObj.DataInsert(-1);
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "an_fom_cd") = "CY";
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "addr_ctnt") = formObj.cy_addr_ctnt.value;
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "impt_ntc_rmk") = formObj.cy_impt_ntc_rmk.value;

            sheetObj.DataInsert(-1);
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "an_fom_cd") = "DR";
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "addr_ctnt") = formObj.dr_addr_ctnt.value;
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "impt_ntc_rmk") = formObj.dr_impt_ntc_rmk.value;

            sheetObj.DataInsert(-1);
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "an_fom_cd") = "E1";
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "addr_ctnt") = formObj.e1_addr_ctnt.value;
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "impt_ntc_rmk") = formObj.e1_impt_ntc_rmk.value;

            sheetObj.DataInsert(-1);
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "an_fom_cd") = "GE";
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "addr_ctnt") = formObj.ge_addr_ctnt.value;
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "impt_ntc_rmk") = formObj.ge_impt_ntc_rmk.value;

            sheetObj.DataInsert(-1);
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "an_fom_cd") = "SP";
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "addr_ctnt") = formObj.sp_addr_ctnt.value;
            sheetObj.CellValue(sheetObj.LastRow,"sheet1_" + "impt_ntc_rmk") = formObj.sp_impt_ntc_rmk.value;


            formObj.f_cmd.value = MULTI;
            sheetObj.DoSave("ESM_BKG_0375GS.do", fnFormStringUtil(FormQueryString(formObj)), -1 ,false);
            //저장완료 이벤트 발생후 로직처리필요(
            break;

        case IBDELETE:        //삭제

//           if(!validateDataModify(sheetObj,formObj,sAction))return;
           //if(!validateForm(sheetObj,formObj,sAction))return;
           //vComboData = comboObjects[0].Text;
           formObj.f_cmd.value = REMOVE01;
           sheetObj.DoSave("ESM_BKG_0375GS.do", fnFormStringUtil(FormQueryString(formObj)), -1, false);
           fncClearFormValue(formObj);
           formObj.an_seq.value = "";
           break;
       case SEARCH01:
           fncSetPodCdCombo(sheetObjects[0],formObj);//POD Combo 설정
           break;
    }

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @param {Object} formObj 필수, 폼객체
 * @param {int} sAction 필수, 이벤트 코드
 * @return boolean 성공 실패정보
 */
function validateForm(sheetObj,formObj,sAction){
    var formObj = document.form;
    with(formObj){
        switch (sAction){
        case IBSEARCH:
            if(!ComChkValid(formObj)) return false;
            break;

        case IBSAVE:
            if(!ComChkValid(formObj)) return false;
      	    if(ComChkLenByByte(formObj.ge_impt_ntc_rmk, 4000) == 0) {
    		    ComShowCodeMessage("BKG43035", "'General' Important Notice", 4000, ComGetLenByByte(formObj.ge_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(formObj.dr_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'Door' Important Notice", 4000, ComGetLenByByte(formObj.dr_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(formObj.cy_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'CY' Important Notice", 4000, ComGetLenByByte(formObj.cy_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(formObj.cf_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'CFS Cargo' Important Notice", 4000, ComGetLenByByte(formObj.cf_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(formObj.sp_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'Special Cargo' Important Notice", 4000, ComGetLenByByte(formObj.sp_impt_ntc_rmk));
    		    return false;
    	    }
      	    if(ComChkLenByByte(formObj.e1_impt_ntc_rmk, 4000) == 0) {
      	    	ComShowCodeMessage("BKG43035", "'Event' Important Notice", 4000, ComGetLenByByte(formObj.e1_impt_ntc_rmk));
    		    return false;
    	    }

      	    break;

        case IBDELETE:
            if(!ComChkValid(formObj)) return false;
            break;
        }
    }

    return true;
}

/**
 * Sheet가 변경되면 combo를 변경해준다.<br>
 * @param {Object} sheetObj 필수, Sheet객체
 * @param {Object} errMsg 선택, 에러메시지
 * @return void
 */
function sheet1_OnSaveEnd(sheetObj, errMsg)
{
    var formObj = document.form;
    if (errMsg != null && errMsg != "") {
        if (sheetObj.EtcData("opr_name") == "D") {
            screenStatus = "N";
            dataStatus = "N";

            fncSetPodCdCombo(sheetObj,formObj);//POD 콤보
            fncSetAgentCombo(sheetObj,formObj);//Agent 콤보
            formObj.arr_prv_fom_cd[0].checked = true;
            formObj.locl_lang_flg[0].selected = true;
            formObj.eclz_bl_cpy_flg[0].selected = true;
        }
        else if(sheetObj.EtcData("opr_name") == "I") {

            fncSetPodCdCombo(sheetObj,formObj);//POD 콤보
            fncSetAgentCombo(sheetObj,formObj);//Agent 콤보
        }
        return;
    }

    fncSetPodCdCombo(sheetObj,formObj);//POD 콤보
    fncSetAgentCombo(sheetObj,formObj);//Agent 콤보
    // {?msg1} update has been completed.
    ComShowCodeMessage ("COM12156","Remark Template");

    screenStatus = "R";
    dataStatus = "N";
    doActionIBSheet(sheetObj,formObj,IBSEARCH);
}

/**
 * IB Sheet에 데이터가 전송된 이후 처리를 수행한다.
 * 1.데이터 있을경우
 * 1-1.수정모드(활성:신규,저장,삭제)(비활성:조회)      *
 * 1-2.sheet 데이터를 form에 입력
 *
 * 2.데이터 없을경우
 * 2-1.신규모드(활성:신규,저장)(비활성:조회,삭제)
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 필수, Sheet개체
 * @param {String} errStr 필수, 메시지 문자열
 * @returns void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function sheet1_OnSearchEnd(sheetObj, errMsg){
    if (errMsg != null && errMsg != "") {
    	ComOpenWait(false);
    	return;
    }
    var formObject = document.form;
    dataStatus = "N";
    //1.데이터가 있을경우
    if(sheetObj.RowCount >= 6){
        //1-1.수정모드(활성:신규,저장,삭제)(비활성:조회)
        screenStatus = "R";
        //1-2.sheet 데이터를 form에 입력
        for(var i=0;i<sheetObj.RowCount;i++){
            if(sheetObj.CellValue(i+1,"sheet1_" + "an_fom_cd") == "CF"){
                formObject.cf_addr_ctnt.value = sheetObj.CellValue(i+1,"sheet1_" + "addr_ctnt");
                formObject.cf_impt_ntc_rmk.value = sheetObj.CellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
            if(sheetObj.CellValue(i+1,"sheet1_" + "an_fom_cd") == "CY"){
                formObject.cy_addr_ctnt.value = sheetObj.CellValue(i+1,"sheet1_" +"addr_ctnt");
                formObject.cy_impt_ntc_rmk.value = sheetObj.CellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
            if(sheetObj.CellValue(i+1,"sheet1_" + "an_fom_cd") == "DR"){
                formObject.dr_addr_ctnt.value = sheetObj.CellValue(i+1,"sheet1_" +"addr_ctnt");
                formObject.dr_impt_ntc_rmk.value = sheetObj.CellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
            if(sheetObj.CellValue(i+1,"sheet1_" + "an_fom_cd") == "E1"){
                formObject.e1_addr_ctnt.value = sheetObj.CellValue(i+1,"sheet1_" +"addr_ctnt");
                formObject.e1_impt_ntc_rmk.value = sheetObj.CellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
            if(sheetObj.CellValue(i+1,"sheet1_" + "an_fom_cd") == "GE"){
                formObject.ge_addr_ctnt.value = sheetObj.CellValue(i+1,"sheet1_" +"addr_ctnt");
                formObject.ge_impt_ntc_rmk.value = sheetObj.CellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }
            if(sheetObj.CellValue(i+1,"sheet1_" + "an_fom_cd") == "SP"){
                formObject.sp_addr_ctnt.value = sheetObj.CellValue(i+1,"sheet1_" +"addr_ctnt");
                formObject.sp_impt_ntc_rmk.value = sheetObj.CellValue(i+1,"sheet1_" +"impt_ntc_rmk");
            }

        }

        var anSeq        = sheetObj.EtcData("an_seq");
        var arrPrvFomCd  = sheetObj.EtcData("arr_prv_fom_cd");
        var loclLangFlg  = sheetObj.EtcData("locl_lang_flg");
        var ezclBlCpyFlg = sheetObj.EtcData("eclz_bl_cpy_flg");

        formObject.an_seq.value = anSeq;
        for(var x=0;x < formObject.arr_prv_fom_cd.length;x++){
            if(formObject.arr_prv_fom_cd[x].value == arrPrvFomCd){
                formObject.arr_prv_fom_cd[x].checked = true;
            }
        }

        for(var x=0;x < formObject.locl_lang_flg.options.length;x++){
            if(formObject.locl_lang_flg.options[x].value == loclLangFlg){
                formObject.locl_lang_flg.options[x].selected = true;
            }
        }


        for(var x=0;x < formObject.eclz_bl_cpy_flg.options.length;x++){
            if(formObject.eclz_bl_cpy_flg.options[x].value == ezclBlCpyFlg){
                formObject.eclz_bl_cpy_flg.options[x].selected = true;
            }
        }

    }

    //2.데이터가 없을경우 (wait 창 이후에 발생해야할 처리들은 여기에 둔다.
    if(sheetObj.RowCount == 0){
        //2-1.신규모드(활성:신규,저장)(비활성:조회,삭제)
        screenStatus = "C";

        //2-2.모든 값 초기화
        fncClearFormValue(formObject);
        formObject.an_seq.value = "";
        formObject.arr_prv_fom_cd[0].checked = true;
        formObject.locl_lang_flg[0].selected = true;
        formObject.eclz_bl_cpy_flg[0].selected = true;


        // There is no data in Text Fields of Office ["Value"], please put Text in the fields
        ComShowCodeMessage("BKG04016", formObject.ofc_cd.value);
    }
    ComOpenWait(false);

    //alert("dataStatus[" + dataStatus + "]  screenStatus[" + screenStatus + "]");
    fnChangeImeMode();
}

/**
 * 화면의 모든값을 초기화 한다.<br>
 * @param {Object} formObject 필수, 폼 객체
 * @return void
 */
function fncClearFormValue(formObject){
    formObject.cf_addr_ctnt.value = "";
    formObject.cf_impt_ntc_rmk.value = "";
    formObject.cy_addr_ctnt.value = "";
    formObject.cy_impt_ntc_rmk.value = "";
    formObject.dr_addr_ctnt.value = "";
    formObject.dr_impt_ntc_rmk.value = "";
    formObject.e1_addr_ctnt.value = "";
    formObject.e1_impt_ntc_rmk.value = "";
    formObject.ge_addr_ctnt.value = "";
    formObject.ge_impt_ntc_rmk.value = "";
    formObject.sp_addr_ctnt.value = "";
    formObject.sp_impt_ntc_rmk.value = "";
}


/**
 * Combo에 입력된 값이 추가된 값인지 확인하여 처리한다.<br>
 * 입력값을 upper로 변경하여 재등록 한다.<br>
 * @param {Object} obj 필수, 변경된 폼 객체
 * @return void
 */
function fncPodCdComboOnChange(obj) {
   var formObj = document.form;
   formObj.pod_cd.value = obj.value;
   fncSetAgentCombo(sheetObjects[0],formObj);
}


/**
 * Combo에 입력된 값이 추가된 값인지 확인하여 처리한다.<br>
 * 입력값을 upper로 변경하여 재등록 한다.<br>
 * @param {Object} obj 필수, 변경된 객체
 * @return void
 */
function fncAgentComboOnChange(obj) {
    var formObj = document.form;
    formObj.chn_agn_cd.value = obj.value;
}

/**
 * pod_cd 값을 입력함에 따라 반응.<br>
 * @param {Object} obj 선택, Agent객체
 * @return void
 */
function fncPodCdKeyUp(obj){
    var formObj = document.form;
    var pCombo = formObj.pod_cd_combo;
    //alert(pCombo.options.length);
    for(var i=0;i<pCombo.options.length;i++){
        if(obj.value.trim() == pCombo.options[i].value.substring(0,obj.value.length)){
            pCombo.options[i].selected = true;
            break;
        }
    }

    if (formObj.pod_cd.value.length == 5) {
        fncSetAgentCombo(sheetObjects[0],formObj);
    }
}

/**
 * agent 값을 입력함에 따라 반응.<br>
 * @param {Object} obj 선택, Agent객체
 * @return void
 */
function fncAgentKeyUp(obj){
    var formObj = document.form;
    var pCombo = formObj.chn_agn_cd_combo;
    //alert(pCombo.options.length);
    for(var i=0;i<pCombo.options.length;i++){
        if(obj.value.trim() == pCombo.options[i].value.substring(0,obj.value.length)){
            pCombo.options[i].selected = true;
            break;
        }
    }
}

/**
 * IB Sheet에 데이터를 특정 flag로 변경한다.<br>
 * @param {Object} sheetObj 필수, Sheet 객체
 * @param {String} status 필수, IBsheet 상태 값
 * @return void
 */
function dataFlagToIBSheet(sheetObj, status) {
    for (var idx = 1; idx <= sheetObj.LastRow ; idx++) {
        sheetObj.RowStatus(idx) = status;
    }
}

/**
 * POD Combo 에 데이터 설정<br>
 * @param {Object} sheetObj 필수, Sheet 객체
 * @param {Object} formObj 필수, 폼 객체
 * @return void
 */
function fncSetPodCdCombo(sheetObj,formObj){
    formObj.f_cmd.value = SEARCH01;
    var sParam = fnFormStringUtil(FormQueryString(formObj));
    var sXml = sheetObj.GetSearchXml("ESM_BKG_0375GS.do", sParam);
    var bComboExists = false;
	//alert(sXml);
    if (!ComBkgErrMessage(sheetObj, sXml) || sXml == "") return;

    var codes = ComGetEtcData(sXml,"code");
    var values = ComGetEtcData(sXml,"value");
    var sPodCdExists = false;


    var codeArr = codes.split("|");
    var valueArr = values.split("|");

     for(var i=formObj.pod_cd_combo.options.length;i >= 0;i--){
         formObj.pod_cd_combo.remove(i);
     }

    for(var m=0; m<codeArr.length -1; m++) {
        var oOption = document.createElement("OPTION");
        formObj.pod_cd_combo.options.add(oOption);
        oOption.innerText = valueArr[m];
        oOption.value = codeArr[m];
        if(formObj.pod_cd.value == codeArr[m]){
            oOption.selected = true;
            bComboExists = true;
        }
    }

    if (!bComboExists) {
        formObj.pod_cd.value = valueArr[0];
    }

}

/**
 * Agent Combo 에 데이터 설정<br>
 * @param {Object} sheetObj 필수, Sheet 객체
 * @param {Object} formObj 필수, 폼 객체
 * @return void
 */
function fncSetAgentCombo(sheetObj,formObj){
    formObj.f_cmd.value = SEARCH02;
    var sParam = fnFormStringUtil(FormQueryString(formObj));
    var sXml = sheetObj.GetSearchXml("ESM_BKG_0375GS.do", sParam);
    var bComboExists = false;
    if (!ComBkgErrMessage(sheetObj, sXml)) return;

    var codes = ComGetEtcData(sXml,"code");
    var values = ComGetEtcData(sXml,"value");
    var sPodCdExists = false;

    var codeArr = codes.split("|");
    var valueArr = values.split("|");

    for(var i=formObj.chn_agn_cd_combo.options.length;i >= 0;i--){
        formObj.chn_agn_cd_combo.remove(i);
    }

    for(var m=0; m<codeArr.length -1; m++) {
        var oOption = document.createElement("OPTION");
        formObj.chn_agn_cd_combo.options.add(oOption);
       oOption.innerText = valueArr[m];
       oOption.value = codeArr[m];
       if(formObj.chn_agn_cd.value == codeArr[m]){
           oOption.selected = true;
           bComboExists = true;
       }
    }

    // add by mgpark 20090706
    // textbox와 combo box값이 서로 다를 경우에는 ALL이므로 combobox 값으로 textbox를 수정한다.
    if (!bComboExists) {
        formObj.chn_agn_cd.value = codeArr[0];
    }

    // add by Park Mangeon 20091112 심영우과장 요청사항 A/N에서 호출시 자동 조회
    if (parAutoSearchFlg != null && parAutoSearchFlg == "Y") {
        parAutoSearchFlg = "N";
        if (!validateForm(sheetObj, formObj, IBSEARCH)) {return; }
        doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }
}

/**
 * 업무 자바스크립트 OnKeyPress 이벤트 처리<br>
 * @param {void}
 * @return void
 */
function objKeyPress() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
        case "ofc_cd":
            ComKeyOnlyAlphabet('upper');
            break;
        case "pod_cd":
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "chn_agn_cd":
            ComKeyOnlyAlphabet('upper');
            break;
    }
}

/**
 * 로그인 사용자의 OFC_CD 에 따라 A/N Preview Form 기본값 제어<br>
 * BEANR, NLRTM은 Notice Letter를 기본으로 사용하도록 제어한다.<br>
 * @param {String} loginOfcCd 필수, 로그인 사용자의 오피스 코드
 * @param {String} arrPrvFomCd 선택,
 * @return void
 */
function fncInitANPreviewForm(loginOfcCd, arrPrvFomCd){
    if(loginOfcCd.value == "BEANR"
        || loginOfcCd.value == "NLRTM"
        )
    {
        arr_prv_fom_cd[2].checked = true;
    }

}

///**
// * 데이터를 입력 가능한 최대 라인수는 13라인이다.<br>
// * Text Area 개체를 검사하여 13라인을 넘는 작업을 하면 enter입력을 취소시킨다<br>
// * @param {Object} obj 필수, text area 개체
// * @return void
// */
//function fncTextareaMaxLine(obj)
//{
//    var str_line = obj;
//    line = str_line.split("\r\n");
//    ln = line.length;
//
//    if(ln == 13 && event.keyCode == 13){
//        event.returnValue = false;
//    }
//}


/**
 * 조건구문을 처리한다. ALL의 경우 실제는 별표로 변경하여 전송해야 하므로 필요한 코드 변경을 일으킨다.<br>
 * @param {String} formStr 필수, 구성한 form String
 * @return String form String을 변경하여생성
 */
function fnFormStringUtil(formStr){
    var tmpStr = formStr;
    tmpStr = tmpStr.replace("&pod_cd=ALL&", "&pod_cd=*&");
    tmpStr = tmpStr.replace("&pod_cd_combo=ALL&", "&pod_cd_combo=*&");
    tmpStr = tmpStr.replace("&chn_agn_cd=&", "&chn_agn_cd=*&");
    tmpStr = tmpStr.replace("&chn_agn_cd_combo=&", "&chn_agn_cd_combo=*&");
    return tmpStr;
}

 /* 개발자 작업  끝 */