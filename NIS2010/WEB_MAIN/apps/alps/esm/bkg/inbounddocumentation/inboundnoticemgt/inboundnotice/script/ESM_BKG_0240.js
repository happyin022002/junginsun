/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0240.js
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.04.28 박성호
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
     * @class esm_bkg_0240 : esm_bkg_0240 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function esm_bkg_0240() {
    this.processButtonClick		= tprocessButtonClick;
    this.setSheetObject 		= setSheetObject;
    this.loadPage 				= loadPage;
    this.initSheet 				= initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet 		= doActionIBSheet;
    this.setTabObject 			= setTabObject;
    this.validateForm 			= validateForm;
    this.obj_keypress 			= obj_keypress;
}

/* 개발자 작업	*/


// 공통전역변수

var tabObjects = new Array();

var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// tab prefix
var prefixArr = new Array(6);
prefixArr[0] = "ge_";
prefixArr[1] = "dr_";
prefixArr[2] = "cy_";
prefixArr[3] = "cf_";
prefixArr[4] = "sp_";
prefixArr[5] = "e1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
    var sheetObject3 = sheetObjects[2];
    var sheetObject4 = sheetObjects[3];
    var sheetObject5 = sheetObjects[4];//TRO


    /*******************************************************/
    var formObject = document.form;
    //tabLayer[0].style.display="block";

    //try {
    var srcName = window.event.srcElement.getAttribute("name");


    //버튼 사용이 금지 될 경우 사용금지
    if(!ComIsBtnEnable(srcName)){
        return;
    }




    switch(srcName) {


        case "btn_Retrieve":
            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;

        case "btn_DownExcel":
//            if(sheetObjects[beforetab+1].rowcount < 1){//결과가 없을경우
//                ComShowCodeMessage("BKG00109");
//            }else{
                //sheetObjects[beforetab+1].Down2Excel(true);//열린 탭에 따라 엑셀다운로드
                sheetObject1.SpeedDown2Excel(-1);
//            }
            break;

        case "btn_Save":
            if(sheetObject2.IsDataModified == true){//수정여부에 따라
            if(validateForm(sheetObject2,formObject,IBSAVE)){
            	doActionIBSheet(sheetObject2,formObject,IBSAVE);
                ComShowCodeMessage("COM12156");
                }
            }else{
                ComShowCodeMessage("BKG00233");
            }
            break;

        case "btn_Del":
            dataFlagToIBSheet(sheetObject1, "D");
            doActionIBSheet(sheetObject1,formObject,IBDELETE);
            break;

        //------------------------------
        // I/B
        //------------------------------
        case "t1btn_RowAdd":
            var row = sheetObject2.DataInsert(-1);
            //alert('a');
            //alert("row " + row);
            //alert("formObject.login_ofc_cd.value  " + formObject.login_ofc_cd.value);
            //항추가시 자동으로 로그인한 사용자의 ofc_cd 를 입력한다.
            sheetObject2.CellValue(row,3) = formObject.login_ofc_cd.value;
            break;

        case "t1btn_RowCopy":

            sheetObject2.DataCopy();
            break;

        case "t1btn_Delete":
            //ComRowHideDelete(sheetObject2, "t1sheet_delChk");
            fncTab1RowDelete(sheetObject2,"t1sheet_delChk");
            break;

        case "t1btn_SettingAN":
            //location.href="ESM_BKG_0672.do";
            var goUrl = "ESM_BKG_0672.do?1=1";
            var param = "&pgmNo=ESM_BKG_0672-01";
            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0672",1024,600,true);
            //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0381", 1200, 600, false);
            break;

        case "btn_Retrieve_Ib":
            doActionIBSheet_Search(sheetObject2,formObject,IBSEARCH);
            break;

        //------------------------------
        // O/B
        //------------------------------

        //------------------------------
        // Invoice
        //------------------------------


        //------------------------------
        // TRO
        //------------------------------


        case "btn_FullUpdatedHistory":
            //alert("Customer Date Management Update History로 이동하는 버튼");
            //0764 로 이동
            
            var formObj = document.form;
            var param = "";            
            
            param += "cust_cnt_cd="+formObj.cust_cnt_cd_ib.value;
            param += "&cust_seq="+formObj.cust_seq_ib.value;
            param += "&cust_nm="+encodeURI(formObj.cust_lgl_eng_nm_ib.value);
            param += "&ofc_cd="+formObj.ofc_cd_ib.value;

            if(formObj.cust_cnt_cd_ib.value == ""
                || formObj.cust_seq_ib.value == ""){
                return;
            }
            //if(param != ""){
            var goUrl = "/hanjin/ESM_BKG_0764.do?"+param;
            ComOpenWindowCenter(goUrl,"ESM_BKG_0764",1024,510,true);
            //}
            break;
        case "btn_CustomersClearanceType":
            //alert("US AMS Customs Clearance Set Up화면으로 이동하는 버튼");
            //0540 으로 이동
            //var param = clickSheet.CellValue(clickRow,"t1sheet_cust_cntc_tp_cd");
            if(param != "")
            {
                var formObj = document.form;
                var goUrl = "/hanjin/ESM_BKG_0540.do?";
                var param = "";
                param += "cust_cnt_cd="+formObj.cust_cnt_cd_ib.value;
                param += "&cust_seq="+formObj.cust_seq_ib.value;
                //param += "&cust_nm="+formObj.cust_lgl_eng_nm_ib.value;
                param += "&ofc_cd="+formObj.login_ofc_cd.value;
                ComOpenWindowCenter(goUrl+encodeURI(param),"ESM_BKG_0540",1024,700,true);
            }
            break;
        case "btn_ConcernedParty":
            //alert("Concerned Party를 추가하는 팝업 버튼");
            //1044 로 이동
            //var param = clickSheet.CellValue(clickRow,"t1sheet_cust_cntc_tp_cd");
            if(param != "")
            {
                var formObj = document.form;
                var goUrl = "/hanjin/ESM_BKG_1044.do?";
                var param = "";
                param += "cust_cnt_cd="+formObj.cust_cnt_cd_ib.value;
                param += "&cust_seq="+formObj.cust_seq_ib.value;
                param += "&cust_nm="+formObj.cust_lgl_eng_nm_ib.value;
                param += "&ofc_cd="+formObj.ofc_cd_ib.value;
                ComOpenWindowCenter(goUrl+encodeURI(param),"ESM_BKG_1044",800,380,true);
            }

            break;
        case "btn_UpdateSetup":
            //alert("Customer 정보를 수정하는 팝업 버튼");
            //1099 로 이동
            //var param = clickSheet.CellValue(clickRow,"t1sheet_cust_cntc_tp_cd");
            if(param != "")
            {
                var formObj = document.form;
                var goUrl = "/hanjin/ESM_BKG_1099.do?";
                var param = "";
                param += "&ofc_cd="+formObj.ofc_cd_ib.value;
                ComOpenWindowCenter(goUrl+encodeURI(param),"ESM_BKG_1099",400,200,true);
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
    ComBtnSetInquiry();

    for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }

    for(i=0;i<sheetObjects.length;i++){
    //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
    }

    // html컨트롤 이벤트초기화
    initControl();

    //Main -> Open : 초기화하고 Customer Code항목에 Selected.

    // IB Sheet 사용 버튼 비활성화
    ComBtnDisable("t2btn_SettingAN");
    //alert('b');
    ComBtnDisable("t3btn_SettingAN");
    //alert('c');
    ComBtnDisable("t4btn_SettingAN");


    //radio 에 따라 활성화/비활성화
    fncSelRadioChange();
    ComBtnDisable("btn_CustomersClearanceType");
    ComBtnDisable("btn_ConcernedParty");

	form.ofc_cd_ib.value = sessOfcCd;

    if(document.form.cust_cnt_cd.value != ""
        && document.form.cust_seq.value != ""
        && autoSearchFlg == "Y"){
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
}


/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
        case 1:      // sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 152;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(20, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //var HeadTitle = "|Seq.|Code|Name|Country|City|Address|Tel.|Fax|E-mail|Status|Blacklisted|Create Date|Sales Rep|S/Office";
                var HeadTitle = "|Seq.|Code|Financial Risk|No Use|Merged code|Type|Name|S/Office|Sales Rep|Country|City|Location code|State|Address|Zip Code|Tel.|Fax|E-mail|F/F FMC no.";


                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var sheetName = "sheet1_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		sheetName + "hdnStatus");
                InitDataProperty(0, cnt++ , dtSeq,					40,		daCenter,	false,		sheetName + "Seq",				false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,		sheetName + "cust_cd",				false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	false,		sheetName + "booking_alert_to_date",false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtCombo,				70,		daCenter,	false,		sheetName + "no_use",			false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		sheetName + "mrg_cd",	false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,		sheetName + "cust_div_flag",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					80,	daLeft,	false,		sheetName + "cust_lgl_eng_nm",				false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					50,	   daCenter,	false,		sheetName + "ofc_cd",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					105,	daCenter,	false,		sheetName + "srep_cd",	false,		"",	dfNone,		0,		false,		false);

                InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		sheetName + "cust_cnt_cd",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					60,	   daCenter,	false,		sheetName + "cty_nm",	false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					120,	   daCenter,	false,		sheetName + "location_code",	false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					55,	   daCenter,	false,		sheetName + "ste_cd",	false,		"",	dfNone,		0,		false,		false);
                //InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	false,		sheetName + "cty_nm",				false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					290,	daLeft,		false,		sheetName + "bzet_addr",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					55,	   daCenter,	false,		sheetName + "zip_cd",	false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		sheetName + "phn_no",				false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		sheetName + "fax_no",				false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					150,	daLeft,		false,		sheetName + "cust_eml",			false,		"",	dfNone,		0,		false,		false);
               // InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		sheetName + "cre_dt",	false,		"",	dfUserFormat2,		0,		false,		false);
                
                InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		sheetName + "ff_fmc_no",	false,		"",	dfNone,		0,		false,		false);


//                InitDataCombo(0, sheetName + "cust_sts_cd", "Active|Inactive|Pending|Deleted|Merged", "A|I|P|D|M");



                //InitUserFormat2(0, sheetName +"booking_alert_to_date", "####-##-## ##:##", "-|:" );
                //InitUserFormat2(0, sheetName +"cre_dt", "####-##-## ##:##", "-|:" );
                CountPosition = 2;
                DataRowMerge(0) = true;
                WaitImageVisible = false;

                }
            break;

        case 2:      // t1sheet init
            with (sheetObj) {
                // 높이 설정
                style.height = 170;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(22, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false)

                var HeadTitle = "|Seq.|Check|OFC|Concern Party|Do Not\nSend|Fax|Do Not\nSend|E-mail|Tel.|Mobile|Updated|Update ID|User Name|Remark(s)|cust_cnt_cd|cust_seq|Fax_org|E-Mail_org";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var sheetName = "t1sheet_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,	  sheetName + "ibflag");
                //InitDataProperty(0, cnt++ , dtStatus,	0,		daCenter,   true,	  sheetName + "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,					35,		daCenter,	false,		sheetName + "Seq");
                InitDataProperty(0, cnt++ , dtCheckBox,	40,		daCenter,	false,		    sheetName + "delChk");

                InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	false,		sheetName + "ofc_cd",				false,		"",	dfNone,		0,		false,		false,    6);
                InitDataProperty(0, cnt++ , dtCombo,					195,	daCenter,	false,		sheetName + "cust_cntc_tp_cd",	false,		"",	dfNone,		0,		false,		false,  2);
                InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	false,		sheetName + "fax_snd_flg",	false,		"",	dfNone,		0,		true,		true);

                InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		sheetName + "fax_no",				false,		"",	dfNone,		0,		true,		true,     20);
                InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	false,		sheetName + "eml_snd_flg",	false,		"",	dfNone,		0,		true,		true);
                InitDataProperty(0, cnt++ , dtData,					150,	daLeft,		false,		sheetName + "cntc_eml",			false,		"",	dfNone,		0,		true,		true,     200);
                InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		sheetName + "phn_no",				false,		"",	dfNone,		0,		true,		true,     20);
                InitDataProperty(0, cnt++ , dtData,					115,	daCenter,	false,		sheetName + "mphn_no",			false,		"",	dfNone,		0,		true,		true,     20);

                InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,		sheetName + "upd_dt",		false,		"",	dfUserFormat2,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		false,		sheetName + "upd_usr_id",	false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		false,		sheetName + "usr_nm",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		false,		sheetName + "cntc_rmk",			false,		"",	dfNone,		0,		true,		true);

                InitDataProperty(0, cnt++ , dtHidden,					0,	daLeft,		false,		  sheetName + "cust_cnt_cd",			false,		"",	dfNone,		0,		true,		true);
                InitDataProperty(0, cnt++ , dtHidden,					0,	daLeft,		false,		  sheetName + "cust_seq",			false,		"",	dfNone,		0,		true,		true);
                InitDataProperty(0, cnt++ , dtHidden,					115,	daCenter,	false,		sheetName + "fax_no_org",				false,		"",	dfNone,		0,		true,		true,     20);
                InitDataProperty(0, cnt++ , dtHidden,					150,	daLeft,		false,		sheetName + "cntc_eml_org",			false,		"",	dfNone,		0,		true,		true,     200);

                InitDataProperty(0, cnt++ , dtHidden,					150,	daLeft,		false,		sheetName + "fax_snd_flg_org",			false,		"",	dfNone,		0,		true,		true,     200);
                InitDataProperty(0, cnt++ , dtHidden,					150,	daLeft,		false,		sheetName + "eml_snd_flg_org",			false,		"",	dfNone,		0,		true,		true,     200);
                InitDataProperty(0, cnt++ , dtHidden,					100,	daLeft,		false,		sheetName + "ib_cmdt_flg",			false,		"",	dfNone,		0,		true,		true);



                ColHidden(2) = true;
                CountPosition = 2;
                //ColHidden(cnt-1) = true;
                //ColHidden(cnt-2) = true;
                //ColHidden(cnt-3) = true;
                //ColHidden(cnt-4) = true;
                InitUserFormat2(0, sheetName +"upd_dt", "####-##-## ##:##", "-|:" );


                InitDataValid(0, sheetName + "phn_no", vtNumericOther, "-,");
                InitDataValid(0, sheetName + "fax_no", vtNumericOther, "-,");
                InitDataValid(0, sheetName + "mphn_no", vtNumericOther, "-,");

                InitDataCombo(0, sheetName + "cust_cntc_tp_cd", 	"Consignee #1|Consignee #2|Broker/Husbanding Agent #1|Broker/Husbanding Agent #2|Also Notify", 	"C1|C2|B1|B2|AN");

                SetSortDialog(false);			// 소트 다이얼로그를 표시하지 않는다.
                DataRowMerge(0) = true;
                WaitImageVisible = false;




                }
            break;

        case 3:      // t2sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 165;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(12, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false)

                var HeadTitle = "|Seq.|Name|Address|Tel. No.|Fax. No.|Attention|City|State|Zip Code|E-mail|Remark";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var sheetName = "t2sheet_";

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	false,		sheetName + "Status");
                InitDataProperty(0, cnt++ , dtSeq,			35,	daCenter,	false,				sheetName + "Seq");
                InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	false,				sheetName + "cust_nm",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			195,daCenter,	false,				sheetName + "cust_addr",	false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			95,	daCenter,	false,				sheetName + "cust_phn_no",	false,		"",	dfNone,		0,		false,		false);

                InitDataProperty(0, cnt++ , dtData,			95,	daCenter,	false,				sheetName + "cust_fax_no",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	false,				sheetName + "Attention",false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	false,				sheetName + "cust_cty_nm",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			65,daCenter,	false,				sheetName + "cust_ste_cd",	false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			100,daCenter,	false,				sheetName + "cust_zip_cd",	false,		"",	dfPostNo,	0,		false,		false);

                InitDataProperty(0, cnt++ , dtData,			200,daLeft,		false,				sheetName + "cust_eml",	false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			100,daLeft,		false,				sheetName + "tmplt_rmk",	false,		"",	dfNone,		0,		false,		false);

                SetSortDialog(false);			// 소트 다이얼로그를 표시하지 않는다.
                DataRowMerge(0) = true;
                WaitImageVisible = false;

                }
            break;

        case 4:      // t3sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 165;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(14, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false)

                var HeadTitle = "|Seq.|Actual Payer Code|O/B E-mail|I/B E-mail|Local Name|Local Address #1|Local Address #2|Customer Type|I/B OFC|Local Zip Code|Local TEL No.|Local Fax No.|Remark";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var sheetName = "t3sheet_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	false,		"ibflag");
                InitDataProperty(0, cnt++ , dtSeq,			35,	daCenter,	false,		sheetName + "Seq");
                InitDataProperty(0, cnt++ , dtData,			150,daCenter,	false,		sheetName + "act_cust_cd",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			150,daCenter,	false,		sheetName + "ob_eml",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			120,daCenter,	false,		sheetName + "ib_eml",		false,		"",	dfNone,		0,		false,		false);

                InitDataProperty(0, cnt++ , dtData,			150,daCenter,	false,		sheetName + "locl_nm",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			200,daLeft,	false,		sheetName + "addr1",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			200,daLeft,	false,		sheetName + "addr2",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			120,daCenter,	false,		sheetName + "cr_cust_tp_cd",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			100,daCenter,	false,		sheetName + "kr_ib_ofc_cd",		false,		"",	dfNone,		0,		false,		false);

                InitDataProperty(0, cnt++ , dtData,			100,daLeft,		false,		sheetName + "locl_zip_cd",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			100,daLeft,		false,		sheetName + "phn_no",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			150,daLeft,		false,		sheetName + "fax_no",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			200,daLeft,		false,		sheetName + "cr_cust_rmk",		false,		"",	dfNone,		0,		false,		false);

                SetSortDialog(false);			// 소트 다이얼로그를 표시하지 않는다.
                DataRowMerge(0) = true;
                WaitImageVisible = false;

                }
            break;

        case 5:      // t4sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 165;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false)

                var HeadTitle = "|Seq.|Location|Zone|Factory Name (Actual Customer)|Contact Person|Telephone|Mobile|Address|Zip|Remark";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                var sheetName = "t4sheet_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	false,		sheetName + "Status");
                InitDataProperty(0, cnt++ , dtSeq,			35,	daCenter,	false,		sheetName + "Seq");
                InitDataProperty(0, cnt++ , dtData,			150,daCenter,	false,		sheetName + "loc_cd",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			50, daCenter,	false,		sheetName + "zn_cd",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			250,daCenter,	false,		sheetName + "act_shpr_nm",		false,		"",	dfNone,		0,		false,		false);

                InitDataProperty(0, cnt++ , dtData,			130,daCenter,	false,		sheetName + "cntc_pson_nm",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			100,daCenter,	false,		sheetName + "cntc_phn_no",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			100,daCenter,	false,		sheetName + "cntc_mphn_no",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			250,daCenter,	false,		sheetName + "act_shpr_addr",		false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,			100,daCenter,	false,		sheetName + "dor_zip_id",		false,		"",	dfNone,		0,		false,		false);

                InitDataProperty(0, cnt++ , dtData,			200,daLeft,		false,		sheetName + "diff_rmk",		false,		"",	dfNone,		0,		false,		false);

                SetSortDialog(false);			// 소트 다이얼로그를 표시하지 않는다.
                DataRowMerge(0) = true;
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

            doActionIBSheet_Search(sheetObj,formObj,sAction);
            break;

        case IBSAVE:        //저장

            doActionIBSheet_Save(sheetObj,formObj,sAction);
            doActionIBSheet(sheetObjects[beforetab+1],formObj,IBSEARCH);

            break;

        case IBINSERT:      // 입력
            break;



    }
}

// Sheet관련 프로세스 처리(조회)
function doActionIBSheet_Search(sheetObj,formObj,sAction){

    if(validateForm(sheetObj,formObj,sAction))
        //----------------------------
        // Master 그리드 조회
        //----------------------------
        if(sheetObj.id == "sheet1"){


            formObj.f_cmd.value = SEARCH01;

            //다중조회
            var anyPrefix = new Array("sheet1_","t1sheet_"); //prefix 문자열 배열, sheet의 개수만큼
            var param = ComGetPrefixParam(anyPrefix);
    
			ComOpenWait(true);
            var sXml = sheetObj.GetSearchXml("ESM_BKG_0240GS.do", FormQueryString(formObj) + "&" + param);

            var arrXml = sXml.split("|$$|");

            for(var i = 0; i < arrXml.length; i++){
                sheetObjects[i].Redraw = false;
                if(i > 0) {
                    sheetObjects[i].WaitImageVisible = false;
                }
                sheetObjects[i].LoadSearchXml(arrXml[i]);
                sheetObjects[i].Redraw = true;
            }
        //----------------------------
        // I/B 조회
        //----------------------------
        }else if ( sheetObj.id == "t1sheet"){

          
            formObj.f_cmd.value = SEARCH02;
            //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
            //alert(addParam);

            //alert(FormQueryString(formObj));
			ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0240GS.do"
                ,FormQueryString(formObj)
                + "&"
                + ComGetPrefixParam("t1sheet_")
                );
        //----------------------------
        // O/B 조회
        //----------------------------
        }else if ( sheetObj.id == "t2sheet"){
            formObj.f_cmd.value = SEARCH03;
            var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ob.value+"&cust_seq="+formObj.cust_seq_ob.value;
            //alert(addParam);
			ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0240GS.do"
                ,FormQueryString(formObj)
                + "&"
                + ComGetPrefixParam("t2sheet_")
                );
        }else if ( sheetObj.id == "t3sheet"){
            formObj.f_cmd.value = SEARCH04;
            var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_invoice.value+"&cust_seq="+formObj.cust_seq_invoice.value;
            //alert(addParam);
			ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0240GS.do"
                ,FormQueryString(formObj)
                + "&"
                + ComGetPrefixParam("t3sheet_")
                );

        }else if ( sheetObj.id == "t4sheet"){
            formObj.f_cmd.value = SEARCH05;
            var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_tro.value+"&cust_seq="+formObj.cust_seq_tro.value;
            //alert(addParam);
			ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0240GS.do"
                ,FormQueryString(formObj)
                + "&"
                + ComGetPrefixParam("t4sheet_")
                );
        }
}
// Sheet관련 프로세스 처리(저장)
function doActionIBSheet_Save(sheetObj,formObj,sAction){
    //----------------------------
    // I/B 저장
    //----------------------------
    if ( sheetObj.id == "t1sheet"){

        formObj.f_cmd.value = MULTI01;
        var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;

        if(validateForm(sheetObj,formObj,sAction)){
			ComOpenWait(true);
            sheetObj.DoSave("ESM_BKG_0240GS.do", FormQueryString(formObj)+addParam);
        }

    }

}
/**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;

}


/**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {

                var cnt  = 0 ;
                InsertTab( cnt++ , "I/B" , -1 );
                InsertTab( cnt++ , "O/B" , -1 );
                InsertTab( cnt++ , "Invoice" , -1 );
                InsertTab( cnt++ , "TRO(Warehouse)" , -1 );

                }
            break;

    }
}

/**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
function tab1_OnChange(tabObj , nItem)
{

    var objs = document.all.item("tabLayer");
    var formObject = document.form;

    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";

    /*
	 			if(nItem==0 &&tabLoad[0]!=1)
					frameLayer0.document.location = 'tab1.jsp?frame=Tab1';
				else if(nItem==1 &&tabLoad[1]!=1)
					frameLayer1.document.location = 'tab3.jsp?frame=Tab2';
	    	*/


    //--------------- 요기가 중요 --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//
    beforetab= nItem;

    // I/B
    if(nItem == 0){
        ComBtnEnable("btn_DownExcel");
        ComBtnEnable("btn_Save");
        ComBtnDisable("t4btn_RowAdd");
        ComBtnDisable("t4btn_RowDelete");

        ComBtnEnable("t1btn_SettingAN");
    //doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
    }else{
        ComBtnDisable("btn_DownExcel");
        ComBtnDisable("btn_Save");
        ComBtnDisable("t1btn_SettingAN");
        //alert('a');
        ComBtnDisable("t2btn_SettingAN");
        //alert('b');
        ComBtnDisable("t3btn_SettingAN");
        //alert('c');
        ComBtnDisable("t4btn_SettingAN");

    }


    // O/B
    if(nItem == 1){
        doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
    }

    // Invoice
    if(nItem == 2){
        doActionIBSheet(sheetObjects[3],formObject,IBSEARCH);
    }

    // TRO
    if(nItem == 3){
        doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
    }


}



/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
function validateForm(sheetObj,formObj,sAction){

    switch(sAction) {

        case IBSEARCH:      //조회

            with(formObj){

                //---------------------------------------
                //Cusotmer Code
                //---------------------------------------
                if(sel_radio[0].checked){
                    if(cust_cnt_cd.value == ""){
                        ComShowCodeMessage("BKG40012");
                        cust_cnt_cd.focus();
                        return false;
                    }

                    if(cust_seq.value == ""){
                        ComShowCodeMessage("BKG40012");
                        cust_seq.focus();
                        return false;
                    }
                    cust_lgl_eng_nm.value = "";
                    cust_cnt_cd_ext.value = "";

                //---------------------------------------
                //Cusotmer Name
                //---------------------------------------
                }else if(sel_radio[1].checked){
                    if(cust_cnt_cd_ext.value == ""){
                        ComShowCodeMessage("BKG40012");
                        cust_cnt_cd_ext.className = "input1";
                        cust_cnt_cd_ext.focus();
                        return false;
                    }
                    
                    if(cust_lgl_eng_nm.value == ""){
                        ComShowCodeMessage("BKG40012");
                        cust_lgl_eng_nm.className = "input1";
                        cust_lgl_eng_nm.focus();
                        return false;
                    }
                    //길이가 2글자 이상
                    if(cust_lgl_eng_nm.value.length < 2){
                        ComShowCodeMessage("BKG04017");
                        cust_lgl_eng_nm.className = "input1";
                        cust_lgl_eng_nm.focus();
                        return false;
                    }

                  //space나 특수문자만 조회할 경우 막음
                 	if(ComTrimAll(cust_lgl_eng_nm.value, "&", "+", "-","."," ").length <= 0 ||ComTrimAll(cust_lgl_eng_nm.value).length <= 0){
                 		ComShowCodeMessage("BKG43048");
                        cust_lgl_eng_nm.className = "input1";
                        cust_lgl_eng_nm.focus();
                        return false;
                 	}
                     
                    cust_cnt_cd.value = "";
                    cust_seq.value = "";

                }


                }
            break;


        case IBSAVE:      //조회
            

    	for(var i=1 ; i < sheetObj.Rows ; i++){
        if(sheetObj.CellValue(i,"t1sheet_cntc_eml")!=""){
            if(!BkgIsEmailAddr(sheetObj.CellValue(i,"t1sheet_cntc_eml"))){
            	ComShowCodeMessage("BKG00366");
                sheetObj.SelectCell(i, "t1sheet_cntc_eml");
                return false;
            }
         }
        }
        
      //데이터 중복                
        return fncDupCheck(sheetObj);
        
            break;
    }


    return true;
}


function fncDupCheck(sheetObj){
    var faxStr = new Array();
    var emlStr = new Array();

    for(var i=0 ; i < sheetObj.Rows ; i++){
        faxStr[i] = sheetObj.CellValue(i,"t1sheet_fax_no");
        emlStr[i] = sheetObj.CellValue(i,"t1sheet_cntc_eml");
    }

    for(var j=0;j<faxStr.length;j++){
        for(var k=0;k < faxStr.length;k++){
            if(j != k && faxStr[j] != "" && faxStr[k] != "" && faxStr[j] == faxStr[k]){
                //alert("The Fax No and/or E-mail Address you inputted is duplicated one. Please check it and Re-Save");
                ComShowCodeMessage("BKG40104");
                return false;
            }
        }
    }

    for(var j=0;j<emlStr.length;j++){
        for(var k=0;k < emlStr.length;k++){
            if(j != k && emlStr[j] != "" && emlStr[k] != "" && emlStr[j] == emlStr[k]){
                //alert("The Fax No and/or E-mail Address you inputted is duplicated one. Please check it and Re-Save");
                ComShowCodeMessage("BKG40104");
                return false;
            }
        }
    }
    return true;
}


/**
     * Master 조회 완료
     */
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
    formObj = document.form;
    with(sheetObj){

      
        //formObj.hdr_rmk.value = CellValue(1,8);//Address
        //formObj.hdr_rmk.value = CellValue(1,9);//Remark
        //DataRowMerge(1) = true;



        ColFontColor(2) = RgbColor(0,0,255);
        ColFontUnderline(2) = true;

        //Black List 값에 따른 색 설정
        for(var b=1;b<=RowCount;b++){

            //Black List 값에 따른 색 설정
            var txt = CellValue(b,"sheet1_booking_alert_to_date");
            if(txt == "Yes"){
                CellFontColor(b,"sheet1_booking_alert_to_date") = RgbColor(255, 0, 0);
            }else if(txt == "No"){
                CellFontColor(b,"sheet1_booking_alert_to_date") = RgbColor(0, 0, 255);
            }
        }



        //검색완료후 I/B,O/B 에 값입력
        if(rowcount == 1){
            setDetailSearchCondition(sheetObj,1,2);
            doActionIBSheet(sheetObjects[beforetab + 1],formObj,IBSEARCH);

        }




        //공통코드 Sheet 안의 Combo 에 넣기
        //var formObj = document.form;
        formObj.f_cmd.value = SEARCH19;
        //var param = "&etc1=" + formObj.cust_cnt_cd.value + "&etc2=" + formObj.cust_seq.value;
        var param = "&cd=CD02129";
        var sXml = sheetObj.GetSearchXml("ESM_BKG_0240GS.do", FormQueryString(formObj) + param);

        var arrData = ComBkgXml2ComboString(sXml, "intg_cd_val_ctnt", "intg_cd_val_dp_desc");
        ComSetIBCombo(sheetObjects[1],sXml,"t1sheet_cust_cntc_tp_cd",false,"","","","cd");


        //조회 완료시 tab1 으로 이동




        }



}

/**
     * Master 클릭시 Detail 조회(I/B)
     */
function sheet1_OnDblClick(sheetObj,row,col){

    //alert("row " + row + "    " + "col " + col);
    formObj = document.form;
    with(sheetObj)
    {
        //if(col == "2"){
        setDetailSearchCondition(sheetObj,row,2);

        doActionIBSheet(sheetObjects[beforetab+1],formObj,IBSEARCH);
        //}
        }

}

var clickSheet;
var clickRow = 1;
var clickCol;
/**
     * I/B Detail 클릭시 처리 이벤트
     */
function t1sheet_OnClick(sheetObj,row,col,value)
{

    clickSheet = sheetObj;
    clickRow = row;
    clickCol = col;

}


//tab 마다 각각의 검색조건을 세팅
function setDetailSearchCondition(sheetObj,row,col){
    with(sheetObj)
    {
        formObj.cust_cnt_cd.value = CellValue(row,col).substr(0,2);
        formObj.cust_seq.value = CellValue(row,col).substr(2);
        //formObj.ofc_cd.value = CellValue(row,13); // S/Office

        //IB
        formObj.cust_cnt_cd_ib.value = CellValue(row,col).substr(0,2);
        formObj.cust_seq_ib.value = CellValue(row,col).substr(2);
        formObj.cust_lgl_eng_nm_ib.value = CellValue(row,col+5);
        formObj.ofc_cd_ib.value = sessOfcCd;

        //OB
        formObj.cust_cnt_cd_ob.value = CellValue(row,col).substr(0,2);
        formObj.cust_seq_ob.value = CellValue(row,col).substr(2);
        formObj.cust_lgl_eng_nm_ob.value = CellValue(row,col+5);

        //Invoice
        formObj.cust_cnt_cd_invoice.value = CellValue(row,col).substr(0,2);
        formObj.cust_seq_invoice.value = CellValue(row,col).substr(2);
        formObj.cust_lgl_eng_nm_invoice.value = CellValue(row,col+5);

        //TRO
        formObj.cust_cnt_cd_tro.value = CellValue(row,col).substr(0,2);
        formObj.cust_seq_tro.value = CellValue(row,col).substr(2);
        formObj.cust_lgl_eng_nm_tro.value = CellValue(row,col+5);
        }
}

//업무 자바스크립트 OnKeyDown 이벤트 Catch
function initControl() {
//Axon 이벤트 처리1. 이벤트catch(개발자변경)
//axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//axon_event.addListener ('keypress', 'engnum_keypress', 'cust_cnt_cd');
//axon_event.addListener ('keypress', 'engnum_keypress', 'ofc_cd');
//axon_event.addListener ('keypress', 'engnum_keypress', 'cust_lgl_eng_nm');
//axon_event.addListenerFormat ('keypress', 'obj_KeyPress', form);
}



//업무 자바스크립트 OnKeyPress 이벤트 처리
function engnum_keypress() {
    //영대문자 자동변환
    ComKeyOnlyAlphabet('uppernum');
}


//IB sheet의 값이 변경될경우.
function t1sheet_OnChange(sheetObj,row,col,value){
    var formObj = document.form;
    if(col < 3){// check 까지는 수정이 적용되지 않도록.
        return;
    }
    //ofc_cd 값이 없을경우 INS로
    if(sheetObj.CellValue(row,3).trim() != formObj.login_ofc_cd.value){
        //alert("diff");
        sheetObj.RowStatus(row) = "I";

    }
}

/**
	 * 체크된 항목의 삭제표시
	 * @return
	 */
function fncTab1RowDelete(sheetObj,col){

    var sRow = sheetObj.FindCheckedRow(col);
    var startCol = 5;//삭제체크시 값을지울 컬럼시작번호
    var endCol = 19-3;//삭제체크시 값을지울 컬럼종료번호(마지막 Org 데이터는 남겨둔다)

    if (sRow == "") return 0;

    //가져온 행을 배열로 만들기
    var arrRow = sRow.split("|"); //결과 : "1|3|5|"

    sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비

    //기준컬럼의 DataType이 dtDelCheck이면 그냥 숨기기만하고, dtDelCheck가 아닌 경우만 숨기고, 트랜잭션 바꾼다.
    if (sheetObj.ReadDataProperty(0, col, dpDataType) == dtDelCheck) {
        //역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
        for (var idx=arrRow.length-2; idx>=0; idx--){
            var row = arrRow[idx];
            //sheetObj.RowHidden(row)= true;		//2.행 숨기기
            fncCellValueClear(sheetObj,row,startCol,endCol);
        }
    } else {
        //역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
        for (var idx=arrRow.length-2; idx>=0; idx--){
            var row = arrRow[idx];
            sheetObj.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
            //sheetObj.RowHidden(row)= true;		//2.행 숨기기
            fncCellValueClear(sheetObj,row,startCol,endCol);
            sheetObj.RowStatus(row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
        }
    }

    sheetObj.RedrawSum = true;	//합계 계산하기

    return arrRow.length-1;
}

/**
	 * cellvalue 지우기
	 * @return
	 */
function fncCellValueClear(sheetObj,row,startCol,endCol){

    for(var i=startCol;i <= endCol;i++){
        sheetObj.CellValue2(row,i) = "";//이벤트가 발생하지 않도록.
    }
}
/**
	 * radio 에 따라 활성화/비활성화
	 * @return
	 */
function fncSelRadioChange(){
    var formObj = document.form;
    var obj = formObj.sel_radio;


    if(obj[0].checked){
    	ComEnableObject(formObj.cust_cnt_cd_ext,false);
        ComEnableObject(formObj.cust_lgl_eng_nm,false);
        ComEnableObject(formObj.cust_cnt_cd,true);
        ComEnableObject(formObj.cust_seq,true);
        formObj.cust_cnt_cd.className = "input1";
        formObj.cust_seq.className = "input1";

    }else if(obj[1].checked){
    	ComEnableObject(formObj.cust_cnt_cd_ext,true);
    	formObj.cust_cnt_cd_ext.className = "input1";
        ComEnableObject(formObj.cust_lgl_eng_nm,true);
        formObj.cust_lgl_eng_nm.className = "input1";
        ComEnableObject(formObj.cust_cnt_cd,false);
        ComEnableObject(formObj.cust_seq,false);
    }
}
/**
	 * seq 에서 포커스를 떠날시
	 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
	 * @param obj
	 * @return
	 */
function fncCustSeqBlur(obj){
    var orgV = obj.value;
    if(orgV.length < 1){
        obj.value = "";
    }else{
        obj.value = fncSeqTo6(orgV);
    }




}
/**
	 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
	 * @param str
	 * @return
	 */
function fncSeqTo6(str){
    var currentObjLen = str.length;

    var retStr = "";
    for(var i=0;i<6-currentObjLen;i++){
        retStr += "0";
    }
    return retStr + str;
}

/**
	* t1sheet 조회 완료시 발생이벤트 처리
	**/
function t1sheet_OnSearchEnd(sheetObj, ErrMsg){
    //alert(sheetObj.Rows);
    //alert(sheetObj.RowCount);
    var formObj = document.form;

    if(sheetObj.RowCount == 5){
        ComBtnEnable("btn_CustomersClearanceType");
        ComBtnEnable("btn_ConcernedParty");
        t1sheet_OnClick(sheetObj,1,1,"");

        if(parseInt(sheetObj.CellValue(1,"t1sheet_" + "ib_cmdt_flg")) > 0){
            //진하게

            document.getElementById("btn_ConcernedParty").style.color='red';
        }else{
            //보통그대로.
            document.getElementById("btn_ConcernedParty").style.color='';
        }

    }else{
        ComBtnDisable("btn_CustomersClearanceType");
        ComBtnDisable("btn_ConcernedParty");
    }
    ComOpenWait(false);


}
function t1sheet_OnSaveEnd(sheetObj, ErrMsg){
	ComOpenWait(false);
}
function t2sheet_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
}
function t3sheet_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
}
function t4sheet_OnSearchEnd(sheetObj, ErrMsg){
    ComOpenWait(false);
}

/**
	* sheet 값 변경시 발생 이벤트 처리
	**/
function t1sheet_OnChange(sheetObj, Row, Col, Value) {

    var colName = sheetObj.ColSaveName(Col);
    
    var prefix = "t1sheet_";

    //<7.29>3.2 Email : Focus Out시 Email 포맷에 대한 Valdation 체크 ( 값이 있을 경우만)
    if(colName == prefix + "cntc_eml"){
    	//alert(sheetObj.CellValue(Row,Col));
     if(sheetObj.CellValue(Row,Col)!=""){
    	if(!BkgIsEmailAddr(sheetObj.CellValue(Row,Col))){
            ComShowCodeMessage("BKG00366");
            sheetObj.SelectCell(Row, Col);
            return;
        }
    	  }
    }
}
/**
	* 엔터 클릭시 IB 탭의 조회
	**/
function fncSearchIb(){
    var sheetObj = sheetObjects[1];
    var formObj = document.form;

    doActionIBSheet_Search(sheetObj,formObj,IBSEARCH);
}



	/* 개발자 작업  끝 */