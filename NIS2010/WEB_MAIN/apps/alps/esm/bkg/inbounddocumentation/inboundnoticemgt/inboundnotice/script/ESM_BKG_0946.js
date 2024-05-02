/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0946.js
*@FileTitle : Group A/N Merge Popup
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
 * @class esm_bkg_0946 : esm_bkg_0946 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0946() {
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



// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var t1beforetab = 1;



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


    var srcName = window.event.srcElement.getAttribute("name");
    switch(srcName) {

        case "btn_row_delete":
            alert(srcName);
            break;
        case "btn_form_setup":
            //alert(srcName);
            //1020으로 화면이동
            fncFormSetup(sheetObject1,formObject);
            break;

        case "btn_fax":
            fncFax(sheetObject1,formObject);
            break;

        case "btn_email":
            fncEmail(sheetObject1,formObject);
            break;


        case "btn_down_excel":

            sheetObjects[0].Down2Excel(true,false,true);
            break;
        case "btn_close":
            self.close();
            break;
        case "btn_preview":
            for(var i=0;i<=sheetObjects[0].RowCount;i++){
                sheetObjects[0].RowStatus(i) = "U";
            }


            formObject.f_cmd.value = MULTI03;

            //sparam = sParam + "&" + ComGetPrefixParam("sheet1_");

            //alert(sparam);

            //sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
            //var arrXml = sheetObject1.GetSearchXml("ESM_BKG_0946GS.do",sParam);

            var saveStr = sheetObjects[0].GetSaveString(false);
            saveStr += "&" + FormQueryString(formObject);


            if(formObject.div_cd[0].checked){//Combine
                //alert("Combine 선택");
                fncCallCombineRD(sheetObjects[0],formObject);
            }else if(formObject.div_cd[1].checked){//Separate
                //alert("Separate 선택");
                fncCallSeparateRD(sheetObjects[0],formObject);
            }else{
                //alert("combine,separate 값중 하나를 체크");
                return;
            }

            //return;



            break;

    } // end switch

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
    var formObj = document.form;



    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }

	for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }

    if(strGubun == "C"){
        formObj.gubun[0].checked = true;
    }else if(strGubun == "S"){
        formObj.gubun[1].checked = true;
    }

    //opener에서 넘어온 값설정
    if(dialogArguments.form.sch_tp[0].checked){
        formObj.sch_tp.value = dialogArguments.form.sch_tp[0].value;
    }
    if(dialogArguments.form.sch_tp[1].checked){
        formObj.sch_tp.value = dialogArguments.form.sch_tp[1].value;
    }else if(dialogArguments.form.sch_tp[2].checked){
        formObj.sch_tp.value = dialogArguments.form.sch_tp[2].value;
    }

    formObj.vvd.value              = dialogArguments.form.vvd.value;
    formObj.vps_eta_dt_start.value = dialogArguments.form.vps_eta_dt_start.value;
    formObj.vps_eta_dt_end.value   = dialogArguments.form.vps_eta_dt_end.value;
    formObj.pod_cd.value           = dialogArguments.form.pod_cd.value;
    formObj.del_cd.value           = dialogArguments.form.del_cd.value;
    formObj.pol_cd.value           = dialogArguments.form.pol_cd.value
    formObj.bl_no.value            = dialogArguments.form.bl_no.value;
    formObj.cust_cnt_cd.value      = dialogArguments.form.cust_cnt_cd.value;
    formObj.cust_seq.value         = dialogArguments.form.cust_seq.value;
    formObj.cust_ref_no.value      = dialogArguments.form.cust_ref_no.value;  // po_no
    formObj.sc_no.value            = dialogArguments.form.s_no.value + dialogArguments.form.c_no.value;
    //formObj.cust_nm.value          = dialogArguments.form.cust_nm.value;
    //alert(dialogArguments.sheetObjects[0].CellValue(dialogArguments.sheetObjects[0].SelectRow ,"t1sheet1_"+"cust_nm"));
    strCustNm                      = dialogArguments.sheetObjects[0].CellValue(dialogArguments.sheetObjects[0].SelectRow ,"t1sheet1_"+"cust_nm");
    formObj.diff_rmk.value            = dialogArguments.sheetObjects[0].CellValue(dialogArguments.sheetObjects[0].SelectRow ,"t1sheet1_"+"diff_rmk");
    formObj.rvis_flg.value            = dialogArguments.sheetObjects[0].CellValue(dialogArguments.sheetObjects[0].SelectRow ,"t1sheet1_"+"rvis_flg");
	if(dialogArguments.form.ts_flg.checked){
		formObj.ts_flg.value           = "Y";
	}else{
		formObj.ts_flg.value           = "N";
	}

    formObj.fax_no.value           = strFaxNo;
    formObj.email.value            = strEmail;

    //		alert("vvd.value             :" + formObj.vvd.value              );
    //		alert("vps_eta_dt_start.value:" + formObj.vps_eta_dt_start.value );
    //		alert("vps_eta_dt_end.value  :" + formObj.vps_eta_dt_end.value   );
    //		alert("pod_cd.value          :" + formObj.pod_cd.value           );
    //		alert("del_cd.value          :" + formObj.del_cd.value           );
    //		alert("pol_cd.value          :" + formObj.pol_cd.value           );
    //		alert("bl_no.value           :" + formObj.bl_no.value            );
    //		alert("cust_cnt_cd.value     :" + formObj.cust_cnt_cd.value      );
    //		alert("cust_seq.value        :" + formObj.cust_seq.value         );
    //		alert("po_no.value           :" + formObj.cust_ref_no.value      );
    //		alert("sc_no.value           :" + formObj.sc_no.value            );


    // Select Line Prarmeter
    formObj.cust_cnt_cd.value = strCustCntCd;
    if (strCustSeq != null && strCustSeq != "" && strCustSeq != "0") {
        formObj.cust_seq.value = fncSeqTo6(strCustSeq);
        formObj.cust_nm_view.value = strCustNm;
    } else {
        formObj.cust_seq.value = "";
    }
    formObj.sc_no.value = strScNo;
    //alert(formObj.bl_no.value);

    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	fncFaxEmlInsert();
}


/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    switch(sheetObj.id) {

        case "sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 122;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                //MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 14, 100);

                var HeadTitle1 = "|Seq.|B/L No.|CNTR QTY|Customs Descirption|VVD|POL|POD|ETA|Del.|bkg_cust_tp_cd|bkg_no|cust_cnt_cd|cust_seq|bkg_cust_tp_cd_odr|cust_nm|diff_rmk|rvis_flg|ts_flg";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                var prefix = "sheet1_";

                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		prefix + "ibflag");

                InitDataProperty(0, cnt++ , dtDataSeq,		60,		daCenter,	false,		prefix + "Seq",				false,		"",			dfNone,		0,			true,		true);
                InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		prefix + "bl_no",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		prefix + "knt",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtData,			220,	daCenter,	true,		prefix + "cstms_desc",				false,		"",			dfNone,		0,			false,		true);

                InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		prefix + "vvd",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		prefix + "pol_cd",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		prefix + "pod_cd",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		prefix + "eta_dt",				false,		"",			dfUserFormat2,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	false,		prefix + "del_cd",				false,		"",			dfNone,		0,			false,		true);

                InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		prefix + "bkg_cust_tp_cd",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		prefix + "bkg_no",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		prefix + "cust_cnt_cd",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		prefix + "cust_seq",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		prefix + "bkg_cust_tp_cd_odr",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	false,		prefix + "cust_nm",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,	false,		prefix + "diff_rmk",				false,		"",			dfNone,		0,			false,		true);
                InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,	false,		prefix + "rvis_flg",				false,		"",			dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,	false,		prefix + "ts_flg",				false,		"",			dfNone,		0,			false,		true);


                CountFormat           = "[SELECTDATAROW / SEARCHROWS]";
                InitUserFormat2(0, prefix + "eta_dt", "####-##-## ##:##", "-|:" );

               // CountPosition = 2;
                WaitImageVisible = false;

                //MassOfSearch = 1;
                }
            break;


			case "t1sheet1":      //t1sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 122;
                //전체 너비 설정
                SheetWidth = mainTable1.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                //MergeSheet = msHeaderOnly;
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                var HeadTitle1 = "";
                HeadTitle1 += "||CNEE/NTFY||CNEE/NTFY #2||BROKER#1||BROKER#2||A/Ntfy #1||A/Ntfy #2||One Time Only";
                HeadTitle1 += "";//FAX

                HeadTitle1 += "||CNEE/NTFY||CNEE/NTFY #2||BROKER#1||BROKER#2||A/Ntfy #1||A/Ntfy #2||One Time Only";

                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, true, true, false,false)


                var headCount = ComCountHeadTitle(HeadTitle1);
        		////컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        		InitColumnInfo(headCount, 0, 0, true);
        		
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                //InitHeadRow(1, HeadTitle2, true);

                var prefix = "t1sheet1_";


                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,		true,	prefix + "ibflag");
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "fax_evnt_flg1",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "fax_no1",			false,          "",      dfNone,			0,     true,       true);

                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "fax_evnt_flg2",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "fax_no2",			false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "fax_evnt_flg3",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "fax_no3",			false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "fax_evnt_flg4",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "fax_no4",			false,          "",      dfNone,			0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "fax_evnt_flg5",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "fax_no5",			false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "fax_evnt_flg6",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "fax_no6",			false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "fax_evnt_flg7",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "fax_no7",			false,          "",      dfNone,			0,     true,       true);

                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "eml_evnt_flg1",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daLeft,		    true,	prefix + "ntc_eml1",		false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "eml_evnt_flg2",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daLeft,		    true,	prefix + "ntc_eml2",		false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "eml_evnt_flg3",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daLeft,		    true,	prefix + "ntc_eml3",		false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "eml_evnt_flg4",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daLeft,		    true,	prefix + "ntc_eml4",		false,          "",      dfNone,			0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "eml_evnt_flg5",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "ntc_eml5",		false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	30,		daCenter,		true,	prefix + "eml_evnt_flg6",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "ntc_eml6",		false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	20,		daCenter,		true,	prefix + "eml_evnt_flg7",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,		170,	daCenter,		true,	prefix + "ntc_eml7",		false,          "",      dfNone,			0,     true,       true);


                //InitUserFormat2(0, prefix + "fax_snd_dt", "####-##-## ##:##", "-|:" );
                //InitUserFormat2(0, prefix + "eml_snd_dt", "####-##-## ##:##", "-|:" );
                InitDataValid(0, prefix + "fax_no1", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no2", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no3", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no4", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no5", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no6", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no7", vtNumericOther, "-,");


                //CountFormat           = "[SELECTDATAROW / TOTALROWS]";
                ShowButtonImage = 2;
                CountPosition = 0;
                AutoRowHeight = false;
                Ellipsis = true;

                WaitImageVisible = false;
				Editable = false;




                }
            break;
    }
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {

    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {

        case IBSEARCH:      //조회
            ComOpenWait(true);
            //doActionIBSheet_Search(sheetObj,formObj,sAction);
            //alert('조회');
            if(sheetObj.id == "sheet1"){
                //alert(FormQueryString(formObj));
                formObj.f_cmd.value = SEARCH01;
                //formObj.f_cmd.value = MULTI11;

                //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
                //alert(addParam);
                //alert(formObj.vvd.value.length);
                //if(formObj.vvd.value.length != 0  && formObj.vvd.value.length != 6 && formObj.vvd.value.length != 9){
                //	ComShowCodeMessage("BKG00007");
                //	formObj.vvd.focus();
                //	return;
                //}

                var param = "";
                if(formObj.gubun[0].checked){
                    param += "gubun=C";
                }else if(formObj.gubun[1].checked){
                    param += "gubun=S";
                }

                param += "&cust_cnt_cd="+formObj.cust_cnt_cd.value;
                param += "&cust_seq="+formObj.cust_seq.value;
                param += "&cust_nm="+formObj.cust_nm.value;
                param += "&sc_no="+formObj.sc_no.value;


                sheetObj.DoSearch("ESM_BKG_0946GS.do"
                    ,FormQueryString(formObj)
                    + "&"
                    + param
                    + "&"
                    + ComGetPrefixParam("sheet1_")
                    );
            }
            break;

        case IBSAVE:        //저장

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



function sheet1_OnSaveEnd(sheetObj, errMsg){
//저장후 다시 읽어들임.
//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
 * 해당길이를 채울경우 다음으로 포커스 이동
 */
function fncNextFocusByMax(srcObj,maxLength,nextObj){

    if(srcObj.value.length == maxLength){
        nextObj.focus();
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
*
**/
function fncFormSetup(sheetObj,formObj){
    //alert(sheetObj.CheckedRows("chk"));
    if(sheetObj.RowCount == 0){
        //대상 항목 미 선택 시  오류 메시지
        ComShowCodeMessage("BKG00149");
        return;
    }


    var goUrl = "";
    var param = "";

    goUrl = "/hanjin/ESM_BKG_1020.do?";

    param += "1=1";
    param += "";
    param += "&pgmNo=ESM_BKG_1020";


    ComOpenWindowCenter(goUrl + param,"ESM_BKG_1020",540,430,true);
}

/**
* Fax 전송
**/
function fncFax(sheetObj,formObj){
    //alert(sheetObj.CheckedRows("chk"));

    for(var i=0;i<=sheetObj.RowCount;i++){
        sheetObj.RowStatus(i) = "U";
    }

    formObj.f_cmd.value = MULTI01;
    var sParam = FormQueryString(formObj);
    sparam = sParam + "&" + ComGetPrefixParam("sheet1_");

    //alert(sparam);

	sheetObj.WaitImageVisible=false;
	ComOpenWait(true);//progress 보이자
    sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
}
/**
* EMail 전송
**/

function fncEmail(sheetObj,formObj){
    for(var i=0;i<=sheetObj.RowCount;i++){
        sheetObj.RowStatus(i) = "U";
    }

    formObj.f_cmd.value = MULTI02;
    var sParam = FormQueryString(formObj);

    sparam = sParam + "&" + ComGetPrefixParam("sheet1_");

	sheetObj.WaitImageVisible=false;
	ComOpenWait(true);//progress 보이자
    sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
}

/**********************************************************
* sheet1 조회 완료
**********************************************************/
function sheet1_OnSearchEnd(sheetObj, errStr) {
    var maxRow = sheetObj.LastRow;
    //alert(document.form.rvis_flg.value);
    for (var i = maxRow; i >= 0; i --) {
        sheetObj.CellValue(i, "sheet1_" + "rvis_flg") = document.form.rvis_flg.value;

        //    	alert(i + ":" + sheetObj.CellValue(i, "sheet1_" + "bkg_cust_tp_cd_odr"));
        if (sheetObj.CellValue(i, "sheet1_" + "bkg_cust_tp_cd_odr") == "2") {
            sheetObj.RowHidden(i) = true;
        } else {
    //break; // 1을 만나면 RowHidden 세팅을 종료한다.
    }


    }
    ComOpenWait(false);
}


/**********************************************************
* Combine 선택 RD 호출
**********************************************************/
function fncCallCombineRD(sheetObj,formObject){
    //사용할 변수 선언부
    var bkgNoStr = "";
    var parentSheetObj = dialogArguments.sheetObjects[0];//부모 Sheet

    //var sParam = FormQueryString(formObject);
    //sparam = sParam + "&" + ComGetPrefixParam("sheet1_");
    //var arrXml = sheetObjects[0].GetSaveXml("ESM_BKG_0946GS.do", saveStr);


    //alert(arrXml);
    //var grpNtcSeq = ComGetEtcData(arrXml, "grpNtcSeq");
    //alert(grpNtcSeq);return;

    //부킹번호 연결
    bkgNoStr = fncGetBkgNo(sheetObj);

    formObject.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/"
    + "ESM_BKG_0918"
    + ".mrd";
    var strArg = "/rv ";
    //strArg += " form_grpNtcSeq['" + grpNtcSeq + "']";
    strArg += " form_bkgNo[(" + bkgNoStr + ")]";
    strArg += " form_usrId['" + strUsr_id + "']";
    strArg += " form_loclFlg['N']";
    strArg += " form_mainOnly['N']";
    strArg += " form_remarkCtnt['']";
    strArg += " form_rvisFlg['" + formObject.rvis_flg.value+ "']";
    strArg += " form_usrTo['" + parentSheetObj.CellValue(parentSheetObj.SelectRow ,"t1sheet1_"+"cust_nm") + "']";
    strArg += " form_tsFlg['" + formObject.ts_flg.value + "']";
	strArg += " form_ofcCd['" + strOfc_cd + "']";

	//strArg += " /rfonttype40";//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결


    //alert(mrdId);
    //alert(strArg);




    formObject.com_mrdArguments.value = strArg;
    formObject.com_mrdTitle.value = "Group Arrival Notice";
    formObject.com_mrdDisableToolbar.value = "";
    formObject.com_mrdSaveDialogFileName.value = "Group_Arrival_Notice";
    formObject.com_mrdSaveDialogFileExt.value = "pdf";
    formObject.com_mrdBodyTitle.value = "Group Arrival Notice";
    //ComOpenRDPopup();


    ComOpenRDPopupModal("dialogWidth:950px;dialogHeight:700px");
}



/**********************************************************
* Separate 선택 RD 호출
**********************************************************/
function fncCallSeparateRD(sheetObj,formObject){
    //사용할 변수 선언부
    var bkgNoStr = "";
    var parentSheetObj = dialogArguments.sheetObjects[0];//부모 Sheet



    //부킹번호 연결
    bkgNoStr = fncGetBkgNo(sheetObj);


    //RD 정보 구해오기
    formObject.f_cmd.value = SEARCH02;

    var sParam = FormQueryString(formObject);
    //앞에서 넘어온 bkg_no를 RD정보를 구하기 위해 사용함.
    sParam += "&bkg_no=" + formObject.bkg_no.value;
    //sparam = sParam + "&" + ComGetPrefixParam("sheet1_");

    //alert(sparam);

    //sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
    var arrXml = parentSheetObj.GetSearchXml("ESM_BKG_0381GS.do",sParam);

    //alert(arrXml);
    var mrdId = ComGetEtcData(arrXml, "MRD_ID");
    var loclLangFlg = ComGetEtcData(arrXml, "LOCL_LANG_FLG");
    var comParam = ComGetEtcData(arrXml, "COM_PARAM");

    //alert("사용할 rd 파일명 '" + mrdId + "'");
    //return;
    if(mrdId == ""){
        //alert("Arrival Notice Setting 정보가 없습니다.");
        ComShowCodeMessage("BKG40050");
        return;
    }


    if(formObject.bkg_no.value == ""){
        //alert("부킹번호가 없습니다.");
        ComShowCodeMessage("BKG00149");
        return;
    }

    formObject.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/"
    + mrdId
    + ".mrd";
    var strArg = "/rv ";
    strArg += " form_bkgNo[(" + bkgNoStr + ")]";
    strArg += " form_usrId['" + strUsr_id + "']";
    strArg += " form_loclFlg['" + loclLangFlg + "']";
    strArg += " form_chgDpFlg['" + parentSheetObj.CellValue(parentSheetObj.SelectRow,"t1sheet1_"+"chg_dp_flg") + "']";
    strArg += " form_rvisFlg['" + parentSheetObj.CellValue(parentSheetObj.SelectRow,"t1sheet1_"+"rvis_flg")+ "']";
    strArg += " form_usrTo['" + parentSheetObj.CellValue(parentSheetObj.SelectRow ,"t1sheet1_"+"cust_nm") + "']";
    strArg += " form_tsFlg['" + formObject.ts_flg.value + "']";
	strArg += " form_ofcCd['" + strOfc_cd + "']";
    //strArg += " form_level[(6)]";
    //var _rmk = parentSheetObj.CellValue(parentSheetObj.SelectRow,"t1sheet1_"+"diff_rmk");
    //_rmk = _rmk.replace("'","");
    //_rmk = _rmk.replace("\n","");
    strArg += " form_remarkCtnt['']";

    strArg += " " + comParam;

	//strArg += " /rfonttype40";//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결

    //alert("호출할 RD Parameter '" + strArg + "'");

    formObject.com_mrdArguments.value = strArg;
    formObject.com_mrdTitle.value = "Group Arrival Notice";
    formObject.com_mrdDisableToolbar.value = "";
    formObject.com_mrdBodyTitle.value = "Group Arrival Notice";
    //ComOpenRDPopup();


    ComOpenRDPopupModal();

//formObject.action=goUrl;
//formObject.submit();
//ComOpenWindowCenter(goUrl + "arg="+encodeURI(strArg),"RD",800,600,true);

}

/**********************************************************
* 화면의 bkg_no 를 모두 결합하여 넘김.
**********************************************************/
function fncGetBkgNo(sheetObj){
    var bkgNoStr = "";
    for(var i=1;i<sheetObj.rows; i++){
        bkgNoStr += "'" + sheetObj.CellText(i,"sheet1_"+"bkg_no") + "'";
        if(i == (sheetObj.rows -1)     ){
            break;
        }
        bkgNoStr += ",";
    }

    return bkgNoStr;
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
                InsertTab( cnt++ , "Fax" , -1 );
                InsertTab( cnt++ , "E-Mail" , -1 );

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
    //alert(nItem);
    var sheetObj = sheetObjects[1];
    var prefix = "t1sheet1_";
    if(nItem == 0){//Fax


        sheetObj.ColHidden(prefix + "fax_evnt_flg1") = false;
        sheetObj.ColHidden(prefix + "fax_no1") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg2") = false;
        sheetObj.ColHidden(prefix + "fax_no2") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg3") = false;
        sheetObj.ColHidden(prefix + "fax_no3") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg4") = false;
        sheetObj.ColHidden(prefix + "fax_no4") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg5") = false;
//        sheetObj.ColHidden(prefix + "fax_chg_flg5") = false;
        sheetObj.ColHidden(prefix + "fax_no5") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg6") = false;
//        sheetObj.ColHidden(prefix + "fax_evnt_flg6") = false;
        sheetObj.ColHidden(prefix + "fax_no6") = false;
        sheetObj.ColHidden(prefix + "fax_chg_flg7") = false;
        sheetObj.ColHidden(prefix + "fax_no7") = false;

        sheetObj.ColHidden(prefix + "eml_evnt_flg1") = true;
        sheetObj.ColHidden(prefix + "ntc_eml1") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg2") = true;
        sheetObj.ColHidden(prefix + "ntc_eml2") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg3") = true;
        sheetObj.ColHidden(prefix + "ntc_eml3") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg4") = true;
        sheetObj.ColHidden(prefix + "ntc_eml4") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg5") = true;
//        sheetObj.ColHidden(prefix + "eml_chg_flg5") = true;
        sheetObj.ColHidden(prefix + "ntc_eml5") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg6") = true;
//        sheetObj.ColHidden(prefix + "eml_chg_flg6") = true;
        sheetObj.ColHidden(prefix + "ntc_eml6") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg7") = true;
        sheetObj.ColHidden(prefix + "ntc_eml7") = true;

		ComBtnEnable("btn_fax");
		ComBtnDisable("btn_email");




    }else if(nItem == 1){//E-Mail

        sheetObj.ColHidden(prefix + "fax_evnt_flg1") = true;
        sheetObj.ColHidden(prefix + "fax_no1") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg2") = true;
        sheetObj.ColHidden(prefix + "fax_no2") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg3") = true;
        sheetObj.ColHidden(prefix + "fax_no3") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg4") = true;
        sheetObj.ColHidden(prefix + "fax_no4") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg5") = true;
//        sheetObj.ColHidden(prefix + "fax_chg_flg5") = true;
        sheetObj.ColHidden(prefix + "fax_no5") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg6") = true;
//        sheetObj.ColHidden(prefix + "fax_chg_flg6") = true;
        sheetObj.ColHidden(prefix + "fax_no6") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg7") = true;
        sheetObj.ColHidden(prefix + "fax_no7") = true;

        sheetObj.ColHidden(prefix + "eml_evnt_flg1") = false;
        sheetObj.ColHidden(prefix + "ntc_eml1") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg2") = false;
        sheetObj.ColHidden(prefix + "ntc_eml2") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg3") = false;
        sheetObj.ColHidden(prefix + "ntc_eml3") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg4") = false;
        sheetObj.ColHidden(prefix + "ntc_eml4") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg5") = false;
//        sheetObj.ColHidden(prefix + "eml_chg_flg5") = false;
        sheetObj.ColHidden(prefix + "ntc_eml5") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg6") = false;
//        sheetObj.ColHidden(prefix + "eml_chg_flg6") = false;
        sheetObj.ColHidden(prefix + "ntc_eml6") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg7") = false;
        sheetObj.ColHidden(prefix + "ntc_eml7") = false;

		ComBtnEnable("btn_email");
		ComBtnDisable("btn_fax");

    }
    beforetab = nItem;

    //alert('beforetab' + beforetab);
    return;


    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";

    //--------------- 요기가 중요 --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
//------------------------------------------------------//



}


function fncFaxEmlInsert(){
	var form = document.form;
	var sheetObj = sheetObjects[1];
	var prefix = "t1sheet1_";

	sheetObj.DataInsert();

	//alert(form.email.value);
	var faxNos = form.fax_no.value.split(",");

	for(var x=0;x<faxNos.length;x++){
		
		var faxInfo = faxNos[x].split("|");

		var faxFlg = faxInfo[0];
		var faxNo = faxInfo[1];
		//alert(faxFlg);
		//alert(faxNo);

		
		if(x < 7){ 
			sheetObj.CellValue(1,prefix + "fax_evnt_flg"+(x+1)) = faxFlg;
			sheetObj.CellValue(1,prefix + "fax_no"+(x+1)) = faxNo;
		}

	}


	var emailInfos = form.email.value.split(",");

	for(var x=0;x<emailInfos.length;x++){

		var emailInfo = emailInfos[x].split("|");
		//alert(emailInfo.length);

		var emailFlg = emailInfo[0];
		var email = emailInfo[1];

		sheetObj.CellValue(1,prefix + "eml_evnt_flg"+(x+1)) = emailFlg;
		sheetObj.CellValue(1,prefix + "ntc_eml"+(x+1)) = email;
		
		if(x < 7){ 
			sheetObj.CellValue(1,prefix + "eml_evnt_flg"+(x+1)) = emailFlg;
			sheetObj.CellValue(1,prefix + "ntc_eml"+(x+1)) = email;
		}
	}
}

function sheet1_OnSaveEnd(sheetObj, errMsg){
    ComOpenWait(false);
    //sheetObj.WaitImageVisible = true;

    if(errMsg != ""){

	}

}
    /* 개발자 작업  끝 */
