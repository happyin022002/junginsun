/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0680.js
*@FileTitle      : India Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.22
*@LastModifier   : 박만건
*@LastVersion    : 1.0
* 2009.05.22 박만건
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.19 최도순 [CHM-201006922] CCUBA D./O Form 개발 요청
* 2011.08.02 김봉균 [CHM-201112547-01]  India Cargo Release 기능 보완 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview India Cargo Release를 위한 Javascript함수가 정의되어 있다.
     * @author Park Mangeon
     */
 
    /* 개발자 작업  */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheetNames   = new Array("blInfo", "refInfo", "cstmsInfo", "cntrRlseSts", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "partial", "otsRcvPop");

    var rdObjects = new Array();
    var comboObjects = new Array();
    var comboCnt = 0;
    var rdCnt = 0;

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

        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            //비활성화되었다면 리턴
            if(!ComIsBtnEnable(srcName)){
                return;
            }

            switch(srcName) {
                //Retrieve
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects["blInfo"], formObject,IBSEARCH);
                break;

                //Save
                case "btn_save":
                    doActionIBSheet(sheetObjects["blIss"], formObject,IBSAVE);
                break;


                //Release
                case "btn_release":
                    doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI01);
                break;
                
                //Cancel
                case "btn_cancel":
                	if(!ComShowCodeConfirm("BKG00670")) return;
                	doActionIBSheet(sheetObjects["doRlseSts"], formObject, REMOVE);
                	doActionIBSheet(sheetObjects["blInfo"], formObject,IBSEARCH);
                	break;
                
                //Survey Letter
                case "btn_survey":
                	if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                	fnSurvey();
               	break;
               	
               	// Slot Letter
                case "btn_slot":
                	if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                	fnSlot();
                break;

                // Carting Order
                case "btn_carting":
                	if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                	fnCarting();
                break;
                
                //Hold
                case "btn_hold":
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI02);
                break;

                //Un-Hold
                case "btn_unhold":
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI03);
                break;

                case "img_exp_del_dt":
                    var cal = new ComCalendar();
                    cal.select(formObject.exp_del_dt, "yyyy-MM-dd");
                break;

                //OBL Cancel
                case "btn_obl_cancel":
                    if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                    oblInit();
                break;

                case "btn_preview":
                    if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                    fnPreview();
                    break;

                case "btn_print":
                    if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                    fnPrint();
                break;

                case "img_exp_del_dt":
                    var cal = new ComCalendar();
                    cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
                break;

                case "btn_bl_surr_rmk":
                    if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                    if (formObject.bl_surr_rmk_flg.value == "Y") {
                        fnShowSurrRemark();
                    }
                break;

                case "btn_history":
                    if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                    fnShowHistory();
                break;

                case "btn_form_setup":
                    fnShowFormSetup();
                break;

                case "btn_receiverinfo":
                    if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                    fnShowRcvrInfo();
                break;

                case "btn_remark":
                    if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                    fnShowRemark();
                break;

                case "btn_cct":
                    blOutstandingAmountPopOpen(true);
                break;
                case "btn_third_cct":
                    blOutstandingAmountPopOpen(false);
                break;

                case "btn_erp":
                    // => Live : /http://erp.hanjin.com/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
                    // => Test : /http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
//                    ComOpenWindow('http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE', 'win4', 'width=1024,height=700');

                    // CoBkg.js 의 ERP 호출하는 함수 실행
					callInboundErp();
                break;

                case "btn_tpb":
                    var frDate = ComGetDateAdd(null, "D", -60);
                    var toDate = ComGetNowInfo("ymd", "");
                    var otsStsCd = "";

                    if (document.form.tpb_status.value == "1") {
                        otsStsCd = "P";
                    } else {
                        otsStsCd = "T";
                    }

                    var condition = "?";
                        condition += "s_state=BKG";
                        condition += "&s_bkg_no_all="+sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
                        condition += "&s_bl_no_all="+sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no");
                        condition += "&s_ots_sts_cd=" + otsStsCd;
                        condition += "&pgmNo=ESD_TPB_0134";
                    ComOpenWindow('/hanjin/ESD_TPB_0134.do'+condition, 'win4', 'width=1024,height=318');

                break;

                //안진응 추가
                case "btn_dem_retrieve":

                    doActionIBSheet(sheetObjects["blInfo"], formObject,COMMAND05);
                break;

                case "btn_dmdt":
                    var bkgNo  = sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
                    var blNo   = sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no");
                    var trfCd  = document.getElementById("demur_type").value;

                    var paramVal = "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&pgmNo=EES_DMT_3002P";

                    ComOpenWindow('/hanjin/EES_DMT_3002P.do' + paramVal, 'win4', 'width=1010,height=670');
                break;

                case "btn_hold_remark":
                    var paramVal = "?sheet_name=R&pgmNo=ESM_BKG_1089";

//                    ComOpenWindow('/hanjin/ESM_BKG_1089.do' + paramVal, 'win4', 'width=600,height=270');
                    ComOpenWindowCenter('/hanjin/ESM_BKG_1089.do' + paramVal, 'win4', 600, 270, true);

                break;
                
                case "btn_unChecked":
                	/*********************** WEB OB/L 체크 추가 *********************/
                	ComOpenWait(true);        	
                	fnOblInterSerNoSave(sheetObjects["blInfo"],formObject,formObject.blIss_bl_tp_cd.value, formObject.bkg_no.value);    
                	ComOpenWait(false);
                	/*********************** WEB OB/L 체크 추가 end*********************/
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
       //sheetObjects[sheetCnt++] = sheet_obj;
       sheetObjects[sheet_obj.id] = sheet_obj; //화면에 정의된 시트 오브젝트를 시트 이름의 배열로 생성한다.
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
        for(i=0;i<sheetNames.length;i++){
            if(sheetObjects[sheetNames[i]].id =='doRlseSts' || sheetObjects[sheetNames[i]].id =='cntrRlseSts' || sheetObjects[sheetNames[i]].id =='demInfo'){
                //시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[sheetNames[i]] );
            }
            initSheet(sheetObjects[sheetNames[i]],i+1);
            if(sheetObjects[sheetNames[i]].id =='doRlseSts' || sheetObjects[sheetNames[i]].id =='cntrRlseSts' || sheetObjects[sheetNames[i]].id =='demInfo'){
                //마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[sheetNames[i]]);
            }
        }

        initControl();
        
    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k]);
    	}

        //조회조건 BL번호에 포커스를 준다.
        ComSetFocus(document.form.bl_no);

        //조회 버튼을 제외 한 모든 버튼 비 활성화
        //buttonDisabledAll();
        document.getElementById("btn_tpb").style.visibility = "hidden";

        //2011.08.02
		doActionIBSheet(sheetObjects[sheetNames[0]], document.form, COMMAND07);  
//        if("CCUBS" != lginOfcCd){ //ofc_cd가 "CCUBS"일때만 콤보 활성화
        if("CCUSO" != lginOfcCd){ //ofc_cd가 "CCUSO"일때만 콤보 활성화 //@ 2015.08.03 한진그룹 코드 표준화
        	document.form.ida_do_yd_cd.Enable = false;
        }
//        document.form.ida_do_yd_cd.UseCode = false;
    }

    /**
     * 화면에서 발생하는 이벤트를 처리한다.<br>
     * Axon 이벤트 처리<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function initControl(){
        //1. 이벤트catch
        axon_event.addListenerForm("keypress" , "obj_keypress"   , form);
        axon_event.addListenerForm("click"    , "obj_click"      , form);
        axon_event.addListenerForm("change"   , "obj_change"     , form);
        axon_event.addListenerForm("blur"     , "obj_deactivate" , form);
        //axon_event.addListenerForm("activate" , "obj_activate"   , form);
        axon_event.addListenerForm('focus'    , 'obj_focus'      , form);

        obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"));
    }

    /************************************************************************************
        화면에서 발생하는 이벤트 처리 시작
    ************************************************************************************/

    /**
     * HTML Control의 onkeypress 이벤트 처리.<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     **/
   function obj_keypress(){
        var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var srcName = window.event.srcElement.getAttribute("name");

        // 엔터키(13)이면
        if (keyCode == 13 && (srcName == 'bl_no' || srcName == 'bkg_no' || srcName == 'cntr_no')) {
            conditionReset();
            if (srcName == 'cntr_no'){
                if(!ComChkObjValid(document.form.cntr_no)) {
                    return false;
                }
                fnSearchContainer();
            } else {
                doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
            }
        } // end if
        else if (keyCode == 13 && srcName == 'exp_del_dt') {
            //기본정보가 조회 된 상태가 아니면 엔터키를 입력해도 조회 하지 않는다.
            if(sheetObjects["blInfo"].CellValue(1,"blInfo_bkg_no") != undefined){
                doActionIBSheet(sheetObjects["blInfo"], document.form, COMMAND05);
            }
        }

        //입력 인자값에 대한 키 입력 설정
        if(srcName == 'bl_no' || srcName == 'bkg_no' || srcName == 'cntr_no'){
            ComKeyOnlyAlphabet('uppernum') ;

        }else if(srcName == 'blIss_obl_rdem_knt'){
            ComKeyOnlyNumber(event.srcElement);

        }else if(srcName == 'exp_del_dt' || srcName == 'refInfo_ida_do_vty_dt'){
            ComKeyOnlyNumber(event.srcElement);
        }
    }

    /**
     * HTML Control의 onClick 이벤트 처리.<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function obj_click(){
        var form = document.form;
        //클릭 이벤트 발생 시 B/L No SelectBox 설정
        if (event.srcElement.name == "bl_no") {
            showHideLayers();
        } else if (event.srcElement.name == "refInfo_do_split_flg") {
            if (form.refInfo_do_split_flg[0].checked) {
                sheetObjects["cntrRlseSts"].Visible  = false;
                sheetObjects["cntrRlseSts"].style.height=0;
                sheetObjects["doRlseSts"].Visible  = true;
                sheetObjects["doRlseSts"].style.height=82;
                document.getElementById("div_remain_cnt").style.visibility="hidden";
            } else {
                sheetObjects["doRlseSts"].Visible  = false;
                sheetObjects["doRlseSts"].style.height=0;
                sheetObjects["cntrRlseSts"].Visible  = true;
                sheetObjects["cntrRlseSts"].style.height=82;
                document.getElementById("div_remain_cnt").style.visibility="visible";
            }
        }
    }

    /**
     * HTML Control의 onchange 이벤트에서 Validation을 체크한다.<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function obj_change(){

        var oForm = document.form;

        //조회조건의 끝 공백을 제거한다.
        conditionTrim();

        if(event.srcElement.name == "bl_no" || event.srcElement.name == "bkg_no" ){
            conditionReset();
        }

        if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
            return false;
        }

        if( event.srcElement.name == "blIss_obl_rdem_knt" ||
            event.srcElement.name == "blIss_bl_otr_doc_rcv_cd" ||
            event.srcElement.name == "blIss_ibd_doc_rcv_flg" ||
            event.srcElement.name == "blIss_otr_doc_cgor_flg"){

            if (event.srcElement.name == 'blIss_bl_otr_doc_rcv_cd') {
               if (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0) {
                   document.getElementById("blIss_otr_doc_cgor_flg").disabled = false;
                   document.getElementById("blIss_otr_doc_cgor_flg").options.value ='N';
               } else {
                   document.getElementById("blIss_otr_doc_cgor_flg").selectedIndex = 0;
                   document.getElementById("blIss_otr_doc_cgor_flg").disabled = true;
               }
           }

            /*
             * India 추가부분 20091116 Park Mangeon
             * 1. bl이 Redemption되었으면, 수정 불가
             * 2. Obl Redemption이 안되었거나, Other Document Receive & Accept하지 않았으면 상태는 항상 N이고 수정 불가
             * 3. 아닐경우 Y로 변경가능
             */
            if(document.getElementById("blIss_obl_rdem_flg").value == "Y" ) {
                document.getElementById("blIss_ibd_doc_rcv_flg").disabled = true;
            }else if((document.getElementById("blIss_obl_rdem_knt").value ==""  || document.getElementById("blIss_obl_rdem_knt").value.parseInt() == 0) &&
                     (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex < 1 || document.getElementById("blIss_otr_doc_cgor_flg").selectedIndex < 2)) {
            }else{
                document.getElementById("blIss_ibd_doc_rcv_flg").disabled = false;
            }

            //Original Bill of Lading Status N => Y 일 경우만 History를 남긴다.
            if( document.getElementById("blIss_obl_rdem_flg").value =='Y'){
                return;
            }

            //2009-11-17 윤윤한 수석 결정 사항 History는 obl cancel 또는 obl clear시 남긴다. (인도는 나머지 D/O와 다른점 blIss_ibd_doc_rcv_flg가 영향을 미침)
            if((document.getElementById("blIss_obl_rdem_knt").value >0 && document.getElementById("blIss_ibd_doc_rcv_flg").options.value=='Y')  ||
                (document.getElementById("blIss_otr_doc_cgor_flg").options.value =='Y' && document.getElementById("blIss_ibd_doc_rcv_flg").options.value=='Y')){
                document.getElementById("obl_cng_flg").value ='Y';
                document.getElementById("do_cng_evnt_cd").value = 'RB';
            }
        }
    }

    /**
     * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function obj_deactivate(){
        var objName = event.srcElement.name;
        var formObj = document.form;

        //이벤트 발생 시 B/L No SelectBox 설정
        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }

        /*****************************************
        switch(objName) {
            case "exp_del_dt":
                ComChkObjValid(event.srcElement);
            break;
            case "refInfo_ida_do_vty_dt":
                ComChkObjValid(event.srcElement);
            break;
        }
        *****************************************/
    }

    function obj_focus(){
        var objName = event.srcElement.name;
        var formObj = document.form;
        switch(objName) {
            case "exp_del_dt":
                formObj.exp_del_dt.value = formObj.exp_del_dt.value.replace(eval("/-/gi"), "");
            break;
        }
    }

   /**
    * Form Object가 Active될때 발생하는 이벤트를 처리한다.
    * @return

    function obj_activate(){
        var objName = event.srcElement.name;
        var formObj = document.form;
        switch(objName) {
            case "exp_del_dt":
                formObj.exp_del_dt.value = formObj.exp_del_dt.value.replace(eval("/-/gi"), "");
            break;

            case "refInfo_ida_do_vty_dt":
                formObj.refInfo_ida_do_vty_dt.value = formObj.refInfo_ida_do_vty_dt.value.replace(eval("/-/gi"), "");
            break;
        }
    }
    */
    /************************************************************************************
        화면에서 발생하는 이벤트 처리 끝
    ************************************************************************************/

    /**
     * 화면의 모든 버튼을 비 활성화 시킨다.<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function buttonDisabledAll(){

        ComBtnDisable("btn_do_id_save");
        ComBtnDisable("btn_obl_cancel");
        ComBtnDisable("btn_erp");
        ComBtnDisable("btn_dem_retrieve");
        ComBtnDisable("btn_dmdt");
        ComBtnDisable("btn_save");
        ComBtnDisable("btn_hold");
        ComBtnDisable("btn_history");
        ComBtnDisable("btn_form_setup");
        ComBtnDisable("btn_receiverinfo");
        ComBtnDisable("btn_remark");
        ComBtnDisable("btn_assign");
        ComBtnDisable("btn_cancel");
        ComBtnDisable("btn_if");
        ComBtnDisable("btn_dorcancel");
        ComBtnDisable("btn_print");
        ComBtnDisable("btn_receipt");
        ComBtnDisable("btn_preview");
        ComBtnDisable("btn_release");
        ComBtnDisable("btn_unhold");
    }


    /**
     * 화면의 버튼을 활성화 시킨다.<br>
     * @param {String} name 필수, elemnts name
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function buttonEnable(name) {

        var tds = document.getElementsByTagName("td");
        for(var i = 0; i < tds.length; i++) {
            var td = tds[i];
            if(td.name == undefined || td.name.length == 0 ){
                continue;
            }

            if (td.className.length > 0 && td.name == name) {
                if (td.className.indexOf("_1") > 0){
                    td.className = td.className.replace(/_1/i, "");
                }
                td.name=name;
            }
        }
    }

    /**
     * 화면의 조회 조건을 제외 한 모든 값 (히든 값 포함) 초기화 시킨다.
     */
    function inputParamReset(){
        for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
            if ( document.form.getElementsByTagName("input")[i].name != "bl_no"   &&
                 document.form.getElementsByTagName("input")[i].name != "cntr_no" &&
                 document.form.getElementsByTagName("input")[i].name != "bkg_no"
                ){
                    document.form.getElementsByTagName("input")[i].value="";
                }
        }

        //시트를 초기화 시킨다.
        var resetSheetNames = new Array("blInfo", "refInfo", "cstmsInfo", "cntrRlseSts", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "otsRcvPop");
        for(var idx = 0; idx < resetSheetNames.length; idx++){
            sheetObjects[resetSheetNames[idx]].RemoveAll();
        }

        document.getElementById("refInfo_inter_rmk").value = "";
        document.getElementById("blIss_otr_doc_cgor_flg").options.value = '';
        document.getElementById("blIss_bl_otr_doc_rcv_cd").options.value ='';
        document.getElementById("bliss_ibd_doc_rcv_flg").options.value ='';
        document.getElementById("tot_ots_amt").options.value ='';
        document.getElementById("tot_bil_amt").options.value ='';
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

        switch(sheetID) {

            case "blInfo":
                with (sheetObj) {

                    /*********************************************
                    //D/O Release 기본 정보
                    **********************************************/

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //SortEnable | ColumnMove |AllCheckEnable |UserResize |RowMove |Head3D
                    InitHeadMode(false, false, false, false, false,false)

                    //var HeadTitle = " |POR|POL|POD|DEL|DELTerm|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|BL_TP_CD|DE_TERM_DESC|BL_TP_CD|OBL_ISS_RMK|lcloblissueflg";
                    var HeadTitle = " |POR|POL|POD|DEL|DELTerm|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|BL_TP_CD|DE_TERM_DESC|BL_TP_CD|OBL_ISS_RMK|lcloblissueflg|"; //2011.08.02 1Column추가

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix="blInfo_";
                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,                     KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,    prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"por_cd"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pol_cd"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"pod_cd"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,    prefix +"del_cd"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"de_term_cd"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"arrival_vessel"      ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"vps_eta_dt"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pck_qty"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pck_tp_cd"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"act_wgt"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"wgt_ut_cd"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"meas_qty"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"meas_ut_cd"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"cntr_prt_flg"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"soc_flg"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ccust_nm"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ccust_addr"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ncust_nm"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ncust_addr"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"scust_nm"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"scust_addr"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"split_flg"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bkg_no"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bl_no"               ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"de_term_desc"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"dsch_loc"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bl_tp_cd"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"obl_iss_rmk"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,    prefix +"lcloblissueflg"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,    daCenter,  false,    prefix +"del_nod_cd"          ,   false,     "",        dfNone,     0,          false,       true); //2011.08.02
                    
                    CountPosition = 0;
                }
                break;

            case "refInfo":

                /****************************************************************
                //D/O Release Reference 정보
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = " |BKG_NO|INTER_RMK|DO_HLD_FLG|CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT|CY_OP_CD|INFO_CGO_FLG|IDA_IMP_GEN_MF_NO|IDA_CGOR_ORD_YR|IDA_CSTMS_ASGN_LINE_NO|DO_SPLIT_FLG|";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix="refInfo_";
                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,     daCenter,  false,     prefix +"ibflag");
                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"bkg_no"                 , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"inter_rmk"              , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          100,    daCenter,  false,     prefix +"do_hld_flg"             , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"cstms_ref_nm"           , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          200,    daRight,   false,     prefix +"cstms_ref_ctnt"         , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"cstms_asgn_nm"          , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"cstms_asgn_ctnt"        , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          70,     daCenter,  false,     prefix +"cy_op_cd"               , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          70,     daCenter,  false,     prefix +"info_cgo_flg"           , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"ida_imp_gen_mf_no"      , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          200,    daCenter,  false,     prefix +"ida_cgor_ord_yr"        , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          70,     daCenter,  false,     prefix +"ida_cstms_asgn_line_no" , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          70,     daCenter,  false,     prefix +"do_split_flg"           , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,         0,     daCenter,  false,     prefix +"ida_do_yd_cd"          ,   false,     "",        dfNone,     0,          false,       true); //2011.08.02
                    
                    CountPosition = 0;
                }
            break;

            case "cstmsInfo":
                /****************************************************************
                //인도세관 신고를 위한 B/L INFO 추출
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false)

                    var HeadTitle = " |loc_nm|troi_flg";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="cstmsInfo_";
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"loc_nm"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"troi_flg" ,   false,     "",        dfNone,     0,          false,       true);

                    CountPosition = 0;
                }
            break;

            case "cntrRlseSts":

                /****************************************************************
                //DO가 Container별로 Split되어 DO발행 할 경우 표시되는 화면
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //SortEnable | ColumnMove |AllCheckEnable |UserResize |RowMove |Head3D
                    InitHeadMode(false, false, false, false, false, false)

                    var HeadTitle = "|Check|CNTR No|Status|D/O No|Validate Date|DMDT Payment type|Update Time|User ID|BKG NO |RLSE SEQ|RLSE STS SEQ|DO NO SPLIT|Status Code";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="cntrRlseSts_";
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,   0,   daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtCheckBox,      40,   daCenter,  false,   prefix +"check"               ,   false,     "",        dfNone,     0,           true,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,   daCenter,  false,   prefix +"cntr_no"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          65,   daCenter,  false,   prefix +"rlse_sts_ctnt"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,   daCenter,  false,   prefix +"do_no"               ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,         100,   daCenter,  false,   prefix +"do_vty_dt"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,         130,   daCenter,  false,   prefix +"do_dmdt_pay_tp_ctnt" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,         100,   daCenter,  false,   prefix +"evnt_dt"             ,   false,     "",        dfUserFormat,     0,          true,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,   daCenter,  false,   prefix +"evnt_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);

                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"bkg_no"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"rlse_seq"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"rlse_sts_seq"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"do_no_split"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"rlse_sts_cd"         ,   false,     "",        dfNone,     0,          false,       true);

                    InitUserFormat(0,prefix +"evnt_dt", "####-##-## ##:##", "-: ");
                    CountPosition = 0;
                    //sheetObj.ScrollBar = 0;
                    MultiSelection = false;
                }
            break;

            case "doRlseSts":

                /****************************************************************
                //B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //SortEnable | ColumnMove |AllCheckEnable |UserResize |RowMove |Head3D
                    InitHeadMode(false, false, false, false, false, false)

                    var HeadTitle = " |Status|Status|D/O No.|Validate Date|DMDT Payment type|Update Time|User ID|User Name|Office|BKG NO |RLSE SEQ|RLSE STS SEQ|DO NO SPLIT";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="doRlseSts_";
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,   0,   daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"rlse_sts_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          65,   daCenter,  false,   prefix +"rlse_sts_ctnt" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          85,   daCenter,  false,   prefix +"do_no"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          85,   daCenter,  false,   prefix +"do_vty_dt"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,         130,   daCenter,  false,   prefix +"do_dmdt_pay_tp_ctnt" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,         110,   daCenter,  false,   prefix +"evnt_dt"       ,   false,     "",        dfUserFormat,     0,          true,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          75,   daCenter,  false,   prefix +"evnt_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,         120,   daCenter,  false,   prefix +"evnt_usr_nm"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,   daCenter,  false,   prefix +"evnt_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"bkg_no"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"rlse_seq"      ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"rlse_sts_seq"  ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,         0,   daCenter,  false,   prefix +"do_no_split"   ,   false,     "",        dfNone,     0,          false,       true);
                    
                    InitUserFormat(0,prefix +"evnt_dt", "####-##-## ##:##", "-: ");
                    CountPosition = 0;
                    //sheetObj.ScrollBar = 0;
                    MultiSelection = false;
                }
            break;

            case "blIss":

                /***********************************************************************
                //조회된 시점에 조회된 Original B/L 회수 여부와 발행 통수 및  Detail정보
                ***********************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(23, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = " |BL회수여부|BL발행통수|O/BL ISSUE|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG| | ||||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix="blIss_";
                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_flg"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_cpy_knt"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"obl_iss_tp_cd"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_iss_ofc_cd"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_iss_dt"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"obl_rdem_knt"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_dt"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"bl_otr_doc_rcv_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_rcv_ofc_cd"      ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_rcv_dt"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_cgor_flg"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_iss_usr_id"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_rdem_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"otr_doc_rcv_usr_id"      ,   false,     "",        dfNone,     0,          false,       true);
                    // for india
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_flg"     ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_old_flg" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_ofc_cd"  ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_usr_id"  ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ibd_doc_rcv_dt"      ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"bl_tp_cd"                ,   false,     "",        dfNone,     0,          false,       true);  // 조회하는  bl type code이다 add by mgpark
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"del_cnt_cd"              ,   false,     "",        dfNone,     0,          false,       true); // 조회하는 delevery의 국가코드이다. add by mgpark

                    CountPosition = 0;
                }
            break;

            case "otsRcvInfo":
                /****************************************************************
                //운임 결재 여부와 Outstanding Amounts 정보 추출
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = " |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="otsRcvInfo_";
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  80,    daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_sts_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"tot_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_sts_cd"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"ppt_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_sts_cd"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_rcv_dt"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd1"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd2"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd3"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd4"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_curr_cd5"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt1"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt2"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt3"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt4"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"cct_ots_amt5"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_sts_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_ppt_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_sts_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_rcv_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd1" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd2" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd3" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd4" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_curr_cd5" ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt1"     ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt2"     ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt3"     ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt4"     ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"n3pty_cct_ots_amt5"     ,   false,     "",        dfNone,     0,          false,       true);

                    CountPosition = 0;
                }
            break;

            case "demInfo":

                /****************************************************************
                //DEM.DET I/F
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = " |Seq\n|Container No.|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="demInfo_";
                    InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,     daCenter,  false,     prefix +"ibflag");
                    InitDataProperty(0,   cnt++ , dtSeq,           40,     daCenter,  true,      prefix +"Seq");
                    InitDataProperty(0,   cnt++ , dtData,         100,     daCenter,  false,     prefix +"cntr_no"         , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,     daCenter,  false,     prefix +"fx_ft_ovr_dys"   , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          50,     daCenter,  false,     prefix +"curr_cd"         , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          90,     daRight,   false,     prefix +"bil_amt"         , false,   "",    dfNumber,    0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          90,     daCenter,  false,     prefix +"ft_dys"          , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtCheckBox,      90,     daCenter,  false,     prefix +"xcld_sat_flg"    , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtCheckBox,      90,     daCenter,  false,     prefix +"xcld_sun_flg"    , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtCheckBox,      90,     daCenter,  false,     prefix +"xcld_hol_flg"    , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,         0,     daCenter,  false,     prefix +""                , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,         0,     daCenter,  false,     prefix +"cntr_rt_amt"     , false,   "",    dfNumber,    0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          90,     daCenter,  false,     prefix +"ft_dys_calc"     , false,   "",    dfNone,      0,     false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          90,     daCenter,  false,     prefix +"ft_end_dt"       , false,   "",    dfDateYmd,   0,     false,       true);

                    CountPosition = 0;
                }
                break;

            case "demDtl":

                /****************************************************************
                //컨테이너 별 Demurrage
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 110;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = " |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,                    KEYFIELD,    CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="demDtl_";
                    InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,    daCenter,  false,     prefix +"ibflag");
                    InitDataProperty(0,   cnt++ , dtData,          90,    daCenter,  false,     prefix +"dmdt_inv_sts_cd",  false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          90,    daCenter,  false,     prefix +"dmdt_ar_if_cd",    false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"ft_end_dt",        false,       "",         dfDateYmd,  0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          80,    daCenter,  false,     prefix +"to_mvmt_dt",       false,       "",         dfDateYmd,  0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          40,    daCenter,  false,     prefix +"inv_curr_cd",      false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtData,          70,    daCenter,  false,     prefix +"bil_amt",          false,       "",         dfNumber,   0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,        80,    daCenter,  false,     prefix +"cntr_no",          false,       "",         dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ , dtHidden,        80,    daRight,   false,     prefix +"inv_chg_amt",      false,       "",         dfNumber,   0,          false,       true);

                    CountPosition = 0;
                }
                break;

            case "totBlbAmt":

                /****************************************************************
                //Total Billable Amount
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|curr_cd|tot_bil_amt";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    prefix = "totBlbAmt_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,   true,       prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "curr_cd",         false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daLeft,     false,      prefix + "tot_bil_amt",     false,      "",     dfNone,         0,      false,      true);

                    CountPosition = 0;
                }
                break;

            case "partial":

                /****************************************************************
                //파샬 컨테이너 정보 조회
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|Seq.||B/L NO.|CNEE NAME|BKG No|BL_TP_CD";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    prefix = "partial_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,   true,       prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,                  30,     daCenter,   false,      prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtRadioCheck,           0,      daCenter,   false,      prefix + "radio",           false,      "",     dfNone,         0,      true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "bl_no",           false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daLeft,     false,      prefix + "cstms_desc",      false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "bkg_no",          false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "bl_tp_cd",        false,      "",     dfNone,         0,      false,      true);

                    CountPosition = 0;
                }
            break;

            case "otsRcvPop":
                /****************************************************************
                //Total Billable Amount
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|OUTSTANDING|OUTSTANDING";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    prefix = "otsRcvPop_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,         30,     daCenter,   true,       prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "curr_cd",         false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daLeft,     false,      prefix + "tot_ots_amt",     false,      "",     dfNone,         0,      false,      true);

                    CountPosition = 0;
                }
            break;
        }
    }

    /**
     * Sheet관련 프로세스 처리<br>
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
    function doActionIBSheet(sheetObj, formObj, sAction) {

        //화면 디버그 설정
        //sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH: //조회
                if(validateForm(sheetObj,formObj,sAction)){

                    //파라메터 초기화
                    inputParamReset();
                    //버튼 설정
                    //buttonDisabledAll();

                    formObj.f_cmd.value = SEARCH;

                    ComOpenWait(true);

                    //BL_TP_CD가 W Or S이면 BL_TP_CD 제거하기
                    if(formObj.bl_no.value !=''){
                        var blNo   = formObj.bl_no.value;
                        var suffix = blNo.substring(formObj.bl_no.value.length-1)

                        if(suffix =='W' || suffix =='S'){
                            formObj.bl_no.value = blNo.substring(0, blNo.lastIndexOf(suffix));
                        }
                    }
                    formObj.ida_do_yd_cd.index2 = 0;
                    //다중조회
                    var aryPrefix = new Array("blInfo_", "refInfo_", "cstmsInfo_", "cntrRlseSts_", "doRlseSts_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix 문자열 배열
                    var sXml = sheetObjects["blInfo"].GetSearchXml("ESM_BKG_0680GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                    var arrXml = sXml.split("|$$|");

                    // 20091125 add by mgpark "DMDT Payment Type을 초기화 한다.
                    document.getElementById("refInfo_ida_do_dmdt_pay_tp_cd").options[0].selected = true; // 20091125 by mgpark
                    document.getElementById("refInfo_ida_do_vty_dt").removeAttribute("required");    // 20091125 by mgpark

                    //ETC DATA 처리 : LoadSearchXml 순간 OnSearchEnd Event 발생 (ETC Data로 OnSearchEnd Event에서 처리 할 경우 ETC 데이터 설정 부분을 LoadSearchXml 앞에서 처리 해야 함
                    if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != "null"){
                        document.getElementById("demur_type").value = ComGetEtcData(arrXml[0], "demurType");
                    }

                    if(undefined != ComGetEtcData(arrXml[0], "mrdId") && ComGetEtcData(arrXml[0], "mrdId") != 'null'){
//                        document.getElementById("h_mrd_id").value = ComGetEtcData(arrXml[0], "mrdId");
                        var mrdId = ComGetEtcData(arrXml[0], "mrdId");

                        var arrMrd = mrdId.split("@@");
                        document.getElementById("h_mrd_id").value = arrMrd[0];
//                      document.getElementById("h_mrd_param").value = arrMrd[1];
                        if (arrMrd.length > 1) {
                            document.getElementById("h_mrd_param").value = arrMrd[1];
                        } else {
                            document.getElementById("h_mrd_param").value = "";
                        }
                    }

                    if(undefined != ComGetEtcData(arrXml[0], "dorStsCd") && ComGetEtcData(arrXml[0], "dorStsCd") != "null"){
                        document.getElementById("dorStsCd").value = ComGetEtcData(arrXml[0], "dorStsCd");
                    }

                    if(undefined != ComGetEtcData(arrXml[0], "dorStowage") && ComGetEtcData(arrXml[0], "dorStowage") != "null"){
                        document.getElementById("dorStowage").value = ComGetEtcData(arrXml[0], "dorStowage");
                    }

                    if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != "null"){
                        document.getElementById("tpb_status").value = ComGetEtcData(arrXml[0], "tpbStatus");
                    }

                    if(undefined != ComGetEtcData(arrXml[0], "remain_cnt") && ComGetEtcData(arrXml[0], "remain_cnt") != "null"){
                        document.getElementById("remain_cnt").value = ComGetEtcData(arrXml[0], "remain_cnt");
                    }

                    //fnPreRetrieve(); // add by mgpark 20091005 search시 초기화
                    for(var idx = 0; idx < arrXml.length; idx++){
                        sheetObjects[sheetNames[idx]].Redraw = false;
                        if(idx > 0) {
                            sheetObjects[sheetNames[idx]].WaitImageVisible = false;
                        }
                        sheetObjects[sheetNames[idx]].LoadSearchXml(arrXml[idx]);
                        sheetObjects[sheetNames[idx]].Redraw = true;
                    }
                    // combobox와 비교 후 setting 2011.08.02
                    document.form.ida_do_yd_cd.UseCode = false;
                    var pkupYdCd = sheetObjects["refInfo"].CellValue(1, "refInfo_ida_do_yd_cd");
                    var maxCnt = formObj.ida_do_yd_cd.GetCount();
                    for (var i=0; i< maxCnt; i ++) {
                    	if (pkupYdCd == formObj.ida_do_yd_cd.GetText(i,0)) {
                    		// set
                    		formObj.ida_do_yd_cd.index2 = i;
                    		break;
                    	}
                    }
                    document.form.ida_do_yd_cd.UseCode = true;
                    document.form.ida_yd_cd.value = document.form.blInfo_dsch_loc.value;
                    
                    /*********************** WEB OB/L 체크 추가 ************************/
                    //fnOblInterSerNoCheck(sheetObj,formObj,formObj.blIss_bl_tp_cd.value, formObj.bkg_no.value);  
                    fnOblInterSerNo(sheetObj, formObj, formObj.blIss_bl_tp_cd.value, formObj.bkg_no.value);

//                    formObj.obl_inter_ser_no_chk_usr_id.value ="";
//                    formObj.obl_inter_ser_no_chk_dt.value = "";
                    /*********************** WEB OB/L 체크 추가 end*********************/
                }
                break;

            case COMMAND05: //Dem 조회 (안진응 추가)
                if(validateForm(sheetObj,formObj,sAction)){
    	        	//조회 조건이 변경되었는지를 체크한다.
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }

                    //버튼 설정
                    //buttonDisabledAll();

                    formObj.f_cmd.value = SEARCH;

                    ComOpenWait(true);

                    //다중조회
                    var aryPrefix = new Array("blInfo_", "refInfo_", "cstmsInfo_", "cntrRlseSts_", "doRlseSts_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix 문자열 배열
                    var sXml = sheetObjects["blInfo"].GetSearchXml("ESM_BKG_0680GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                    var arrXml = sXml.split("|$$|");

                    //ETC DATA 처리 : LoadSearchXml 순간 OnSearchEnd Event 발생 (ETC Data로 OnSearchEnd Event에서 처리 할 경우 ETC 데이터 설정 부분을 LoadSearchXml 앞에서 처리 해야 함
                    if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != "null"){
                        document.getElementById("demur_type").value = ComGetEtcData(arrXml[0], "demurType");
                    }

                    for(var idx = 7; idx < arrXml.length; idx++){
                        sheetObjects[sheetNames[idx]].Redraw = false;
                        if(idx > 0) {
                            sheetObjects[sheetNames[idx]].WaitImageVisible = false;
                        }
                        sheetObjects[sheetNames[idx]].LoadSearchXml(arrXml[idx]);
                        sheetObjects[sheetNames[idx]].Redraw = true;
                    }
                }
            break;

            case IBSAVE:   //저장

                if(validateForm(sheetObj, formObj, sAction)){
    	        	//조회 조건이 변경되었는지를 체크한다.
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }

                	formObj.f_cmd.value = MODIFY;

                    //Form의 값을 Sheet Row로 Copy
                    CopyFormToRow(formObj, sheetObjects["refInfo"], 1, "");
                    CopyFormToRow(formObj, sheetObjects["blIss"], 1, "");
                    CopyFormToRow(formObj, sheetObjects["cstmsInfo"], 1, "");

                    //라디오값이 카피가 잘 안되서 별도로 구현했음 (refInfo_do_split_flg가 저장 시 날아가는 현상 방지)
                    if(document.getElementsByName("refInfo_do_split_flg")[0].checked == true){
                        sheetObjects["refInfo"].CellValue(1, "refInfo_do_split_flg") = 'N'
                    }else{
                        sheetObjects["refInfo"].CellValue(1, "refInfo_do_split_flg") = 'Y'
                    }

                    //그리드의 변경 여부 체크
                    if(! sheetObjects["refInfo"].IsDataModified && ! sheetObjects["blIss"].IsDataModified && ! sheetObjects["cstmsInfo"].IsDataModified){
                        ComShowCodeMessage("BKG95005");
                        return false;
                    }

                    if( !ComShowCodeConfirm("COM12147" , "data" ) ){
                        return false;
                    }

                    //변경이 없어도 필요한 인자값 추출을 위해 상태를 강제로 변경시킨다.
//                  2010.04.09 수정 지침에 따라서 수정(안진응)
//                    sheetObjects["refInfo"].CellValue2(1, "refInfo_ibflag") = "U";
//                    sheetObjects["blIss"].CellValue2(1, "blIss_ibflag") = "U";
//                    sheetObjects["doRlseSts"].CellValue2(1, "cstmsInfo_ibflag") = "U";
                    
                    sheetObjects["refInfo"].RowStatus(1) = "U";
                    sheetObjects["blIss"].RowStatus(1) = "U";
                    sheetObjects["doRlseSts"].RowStatus(1) = "U";

                    var sParam1 = sheetObjects["refInfo"].GetSaveString();   //India D/O Release Reference 정보
                    var sParam2 = sheetObjects["blIss"].GetSaveString();     //Original B/L 회수 여부와 발행 통수 및  Detail정보
                    var sParam3 = sheetObjects["cstmsInfo"].GetSaveString(); //인도세관 신고를 위한 B/L INFO

                    var aryPrefix = new Array("refInfo_", "blIss_", "cstmsInfo_");    //prefix 문자열 배열
                    var sparam = sParam1 + "&" + sParam2 + "&" + sParam3 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                    var sXml = sheetObj.GetSaveXml("ESM_BKG_0680GS.do", sparam);

                    sheetObjects["refInfo"].LoadSaveXml(sXml);
                    sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
                    //sheetObjects["blIss"].LoadSaveXml(sXml);
                }
                break;

            case MULTI01:// Release
	        	//조회 조건이 변경되었는지를 체크한다.
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }

            	// HOLD체크
                if (formObj.refInfo_do_hld_flg.value == "Y") {
                    // B/L was Held
                    //ComShowCodeMessage("BKG00649");
                    ComShowCodeMessage("BKG40061", sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no"));
                    return;
                }

                // OBL Status 확인
                if (formObj.blIss_obl_rdem_flg.value == "N") {
                    // You can't release because B/L Status is "N".
                    // B/L Status will turn "Y" only when one out of items 1) Seaway Bill, 2) O.B/L Surrenderred, 3) O. B/L received, 4) LG received with "accepted" is satified with. please check it.
                    ComShowCodeMessage("BKG40066");
                    return;
                }

                // FOC체크
                if (!fnCheckFOC()) {
                    return;
                }

                if (formObj.blInfo_cntr_prt_flg.value == "Y") {
                    // The B/L is Partial One
                    ComShowCodeMessage("BKG40063");
                }

                // General이 아닐 경우에는 mandatory이다.
                if( formObj.refInfo_ida_do_dmdt_pay_tp_cd[0].selected == false) {
                    document.getElementsByName("refInfo_ida_do_vty_dt")[0].setAttribute("required", true);
                }
                if(!validateForm(sheetObj,formObj,sAction)){
                    // 임시로 mandatory로 한 것을 제거한다.
                    document.getElementsByName("refInfo_ida_do_vty_dt")[0].removeAttribute("required");
                    return ;
                }

                /*********************** WEB OB/L 체크 추가 ***************************/
                //O B/L 중 Web OB/L Serial No. 체크 하지 않은 것 
/*                if ( formObj.blIss_bl_tp_cd.value == "B" && document.getElementById("obl_inter_ser_no").innerHTML != "" && formObj.obl_inter_ser_no_chk_usr_id.value == "") {
                	//체크 ID 가 없을 경우 메세지 출력
            		ComShowCodeMessage("BKG95098");
                    return;
            	}*/
            	var comboCount = comboObjects[1].GetCount();
                if(formObj.blIss_bl_tp_cd.value == "B" && comboCount>0 && formObj.blIss_bl_otr_doc_rcv_cd.value == ""){
                	//Serial No 생성 불가한 17곳의 POR_CD에서는 Validation 대상에서 제외
                	if(!porCodeCheck(sheetObjects["blInfo"], formObj.blInfo_por_cd.value)){
	                	if(!oBlInterSerNoChecked(sheetObjects["blInfo"], formObj.bl_no.value)){
	                		ComShowCodeMessage("BKG95126");
	                        return;
	                	}
                	}
                }
                /*********************** WEB OB/L 체크 추가 END ************************/
                
                //Are you sure to Release?
                if(!ComShowCodeConfirm("BKG00673")){
                    return false;
                }

                formObj.f_cmd.value = MULTI01;
                formObj.do_cng_evnt_cd.value = "RE";

                CopyFormToRow(formObj, sheetObjects["doRlseSts"], 1, "");
                CopyFormToRow(formObj, sheetObjects["blIss"], 1, "");
                CopyFormToRow(formObj, sheetObjects["refInfo"], 1, "");

                // 20091125 Park Mangeon  -- Radio값이 정상적으로 들어오지 않는 것을 방지
                if(document.getElementsByName("refInfo_do_split_flg")[0].checked == true){
                    sheetObjects["refInfo"].CellValue(1, "refInfo_do_split_flg") = 'N'
                }else{
                    sheetObjects["refInfo"].CellValue(1, "refInfo_do_split_flg") = 'Y'
                }


                //변경이 없어도 필요한 인자값 추출을 위해 상태를 강제로 변경시킨다.
//                  2010.04.09 수정 지침에 따라서 수정(안진응)
//                sheetObjects["doRlseSts"].CellValue2(1, "doRlseSts_ibflag") = "U";
//                sheetObjects["blIss"].CellValue2(1, "blIss_ibflag") = "U";
//                sheetObjects["refInfo"].CellValue2(1, "refInfo_ibflag") = "U";
                
                sheetObjects["doRlseSts"].RowStatus(1) = "U";
                sheetObjects["blIss"].RowStatus(1) = "U";
                sheetObjects["refInfo"].RowStatus(1) = "U";
                

                var aryPrefix = new Array("doRlseSts_", "blIss_");    //prefix 문자열 배열

                var sParam1 = sheetObjects["doRlseSts"].GetSaveString();
                var sParam2 = sheetObjects["blIss"].GetSaveString();
                var sParam3 = sheetObjects["cntrRlseSts"].getSaveString();
                var sParam4 = sheetObjects["refInfo"].getSaveString();


                var sparam = sParam1 + "&" + sParam2 + "&" + sParam3 + "&" + sParam4 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0680GS.do", sparam);

                sheetObjects["doRlseSts"].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml); // 넘어온 메시지는 한번만 보이고 싶을 때 사용
                //sheetObjects["blIss"].LoadSaveXml(sXml);

                formObj.refInfo_ida_do_dmdt_pay_tp_cd[0].selected = true;
                formObj.refInfo_ida_do_vty_dt.value = "";
            break;

            case MULTI02:// Hold
                
	        	//조회 조건이 변경되었는지를 체크한다.
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
            
            	if (sheetObjects["blInfo"].LastRow == 0 ) {return;}
                if (formObj.blInfo_cntr_prt_flg.value == "Y") {
                    // The B/L is Partial One
                    ComShowCodeMessage("BKG40063");
                }

                //Are you sure to Hold?
                if(!ComShowCodeConfirm("BKG00671")){
                    return false;
                }

                formObj.f_cmd.value = MULTI02;

                //변경이 없어도 필요한 인자값 추출을 위해 상태를 강제로 변경시킨다.
//              2010.04.09 수정 지침에 따라서 수정(안진응)
//                sheetObjects["blInfo"].CellValue2(1, "blInfo_ibflag") = 'U';
                sheetObjects["blInfo"].RowStatus(1) = "U";
                
                var aryPrefix = new Array("blInfo_");    //prefix 문자열 배열

                var sParam1 = sheetObjects["blInfo"].GetSaveString();
                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0680GS.do", sparam);
                sheetObjects["blInfo"].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
                //sheetObjects["sheet2"].LoadSaveXml(sXml);

            break;

            case MULTI03:// Un-Hold
	        	//조회 조건이 변경되었는지를 체크한다.
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }

            	if (sheetObjects["blInfo"].LastRow == 0 ) {return;}

//              //Are you sure to Hold?
//              if(!ComShowCodeConfirm("BKG00671")){
//                  return false;
//              }

                formObj.f_cmd.value = MULTI03;

                //변경이 없어도 필요한 인자값 추출을 위해 상태를 강제로 변경시킨다.
//              2010.04.09 수정 지침에 따라서 수정(안진응)
//                sheetObjects["blInfo"].CellValue2(1, "blInfo_ibflag") = 'U';
                sheetObjects["blInfo"].RowStatus(1) = "U";

                var aryPrefix = new Array("blInfo_");    //prefix 문자열 배열

                var sParam1 = sheetObjects["blInfo"].GetSaveString();
                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0680GS.do", sparam);
                sheetObjects["blInfo"].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
                //sheetObjects["sheet2"].LoadSaveXml(sXml);

            break;
         case REMOVE:// Cancel
        	//조회 조건이 변경되었는지를 체크한다.
        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            formObj.f_cmd.value = REMOVE;

            var sparam = FormQueryString(formObj);

            var sXml = sheetObj.GetSaveXml("ESM_BKG_0680GS.do", sparam);

            sheetObjects["doRlseSts"].LoadSaveXml(sXml);
            sXml = ComDeleteMsg(sXml); // 넘어온 메시지는 한번만 보이고 싶을 때 사용
            
            break;

         case COMMAND07: //2011.08.02 초기화면 로딩시 콤보박스 생성
        	 
         	formObj.f_cmd.value = COMMAND07;
      		var sXml = sheetObj.GetSearchXml("ESM_BKG_0680GS.do", "f_cmd="+COMMAND07);
//     		ComXml2ComboItem(sXml, formObj.ida_do_yd_cd, "val", "desc");
     		ComXml2ComboItem(sXml, formObj.ida_do_yd_cd, "name", "desc");
     		formObj.ida_do_yd_cd.Index = 0;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {Object} formObj 필수, 폼개체
     * @param {int} sAction 필수, 작업코드
     * @return boolean Validation 결과값
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function validateForm(sheetObj, formObj, sAction){
        var oForm = document.form;

        if(sAction ==IBSAVE){
            //2010-01-13 윤윤한 수석님 결정 로직 불필요 삭제
            //if (document.form.blIss_obl_rdem_knt.value != sheetObjects["blIss"].CellValue(1, "blIss_obl_rdem_knt") ||
            //    document.form.blIss_bl_otr_doc_rcv_cd.value != sheetObjects["blIss"].CellValue(1, "blIss_bl_otr_doc_rcv_cd")||
            //    document.form.blIss_ibd_doc_rcv_flg.value != sheetObjects["blIss"].CellValue(1, "blIss_ibd_doc_rcv_flg")){
            //    // login사용자의 국가코드와 del의 앞2자리가 다를 경우 처리
            //    if (document.getElementById("blInfo_del_cd").value.substring(0,2) != lginCntCd) {
            //        ComShowCodeMessage("BKG00630");
            //        return false;
            //    }
            //}

            if(document.getElementById("blIss_obl_cpy_knt").value < parseInt(document.getElementById("blIss_obl_rdem_knt").value)){
                //The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen.\nYou have input the number in Received field less or the same number of B/L Released.
                ComShowCodeMessage("BKG40065");
                document.getElementById("blIss_obl_rdem_knt").focus();
                return false;
            }

            if(oForm.blIss_obl_rdem_flg.value == "Y"
                && sheetObjects["blIss"].CellValue(1, "blIss_obl_rdem_knt") > 0
                && oForm.blIss_obl_rdem_knt.value == 0) {
                // You can't change the number of B/L Received "[Value]" by manually inputting
                // Please amend the input to "0" by pressing [RCV Cancel] Button and [Save] Button.
                // Then input the correct Number once again.
                ComShowCodeMessage("BKG40072");
                return false;
            }
        }else if(sAction ==IBSEARCH){

            //조회조건의 끝 공백을 제거한다.
            conditionTrim();

            //if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.cntr_no) && ComIsNull(oForm.bkg_no)){
            if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.bkg_no)){
                //ComShowCodeMessage("BKG00786"); //필수 조회 조건이 누락되었습니다. B/L No or Container No or BKG No가 필수 조회 조건입니다.
                ComShowCodeMessage("BKG40097"); //필수 조회 조건이 누락되었습니다. B/L No or BKG No가 필수 조회 조건입니다.
                ComSetFocus(oForm.bl_no)
                return false;
            }
            if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
                return false;
            }
        }else if(sAction == MULTI01) {  // Release
            

            if (formObj.refInfo_do_split_flg[1].checked == true
                    && sheetObjects["cntrRlseSts"].getSaveString() == "") {
                // [{?msg1}] Button is available only when you select Containers by clicking a check box.\nPlease click a check box then press '{?msg1}' Button once again.
                ComShowCodeMessage("BKG40069", "Release");
                return false;
            }

            if(oForm.blIss_obl_rdem_flg.value == "Y"
                && sheetObjects["blIss"].CellValue(1, "blIss_obl_rdem_knt") > 0
                && oForm.blIss_obl_rdem_knt.value == 0) {
                // You can't change the number of B/L Received "[Value]" by manually inputting
                // Please amend the input to "0" by pressing [RCV Cancel] Button and [Save] Button.
                // Then input the correct Number once again.
                ComShowCodeMessage("BKG40072");
                return false;
            }

            if(document.getElementById("blIss_obl_rdem_flg").value == "N"){
                //'Orgin B/L not released!
                ComShowCodeMessage('BKG40066');
                return false;
            }
        //DEM.DET Retrieve
        }else if(sAction == COMMAND05){
            if(!ComChkObjValid(oForm.exp_del_dt)) {
                return false;
            }

            var toDay    = ComGetNowInfo('ymd','-').replace(eval("/-/gi"), "");
            var expDelDt = formObj.exp_del_dt.value.replace(eval("/-/gi"), "");

            //오늘 날짜 이전 날짜를 넣으면 경고 메세지
            if(toDay > expDelDt){
                ComShowCodeMessage('BKG40114', expDelDt);
                return false;
            }
        }
        return true;
    }

    /* *************************************************************
        TRIC SELECT BOX CODE START
    ************************************************************* */
    /**
     * HTML Control의 deactivate 이벤트 처리. <br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     **/
    function showHideLayers() {
        var el = event.srcElement;

        if(el.tagName.toLowerCase() !="input"){
            return;
        }
        var rect = el.getBoundingClientRect();

        blLayer.style.left    = rect.left-2;
        blLayer.style.top     = rect.top+20;
        blLayer.style.height  = 20 + (15* sheetObjects["partial"].RowCount)+3;

        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }else{
            blLayer.style.visibility="visible";
        }
    }

    /**
     * TRiC SELECT BOX를 그린다.<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function conditionSet(aryPopupData){

        if(aryPopupData != undefined){
            document.getElementById("bl_no").value  = aryPopupData[0][3]+aryPopupData[0][6];
            document.getElementById("bkg_no").value = aryPopupData[0][5];
        }

        tbl = document.createElement("TABLE");
        tbl.id ="oTbl";
        tbl.border = "0";

        tbody = document.createElement("TBODY");

        tbl.insertBefore(tbody, null);

        blLayer.insertBefore(tbl);

        for (idx=1; idx<=sheetObjects["partial"].RowCount; idx++) {
            tr = document.createElement("TR");
            td = document.createElement("TD");

            //text = document.createElement("<INPUT TYPE=TEXT NAME='h_bl_no' VALUE ='"+sheetObjects["partial"].CellValue(idx,"t1sheet4_bl_no")+"' READONLY STYLE='BORDER:0; HEIGHT:15;BACKGROUND-COLOR:rgb(49,106,197) ONCLICK=blNoSelect("+idx+")>");
            //text.value = sheetObjects["partial"].CellValue(idx,"t1sheet4_bl_no");
            //text.style.border = 0;
            //text.style.height = 15;
            //조회 조건과 같은 값이 나오면 색상 처리
            /*
            if(document.getElementById("bl_no").value == sheetObjects["partial"].CellValue(idx,"t1sheet4_bl_no")){
                text = document.createElement("<INPUT TYPE=TEXT VALUE ='"+sheetObjects["partial"].CellValue(idx,"t1sheet4_bl_no")+"' READONLY STYLE='BORDER:0; HEIGHT:15;BACKGROUND-COLOR:rgb(49,106,197);COLOR:#FFFFFF' ONMOUSEOVER='ONCLICK=blNoSelect("+idx+")'; ONCLICK=blNoSelect("+idx+")>");
            }else{
                text = document.createElement("<INPUT TYPE=TEXT VALUE ='"+sheetObjects["partial"].CellValue(idx,"t1sheet4_bl_no")+"' READONLY STYLE='BORDER:0; HEIGHT:15;' ONMOUSEOVER='ONCLICK=blNoSelect("+idx+")'; ONCLICK=blNoSelect("+idx+")>");
            }
            */
            if(document.getElementById("bl_no").value == sheetObjects["partial"].CellValue(idx, "partial_"+"bl_no")){
                text = document.createElement("<input type=text value ='"+sheetObjects["partial"].CellValue(idx, "partial_"+"bl_no")+sheetObjects["partial"].CellValue(idx, "partial_"+"bl_tp_cd")+"' readonly style='border:0; height:15;background-color:rgb(49,106,197);COLOR:#FFFFFF' onmouseover=blNoSelect("+idx+"); onclick=blNoSelect("+idx+")>");
            }else{
                text = document.createElement("<input type=text valuE ='"+sheetObjects["partial"].CellValue(idx, "partial_"+"bl_no")+sheetObjects["partial"].CellValue(idx, "partial_"+"bl_tp_cd")+"' readonly style='border:0; height:15;' onmouseover=blNoSelect("+idx+"); onclick=blNoSelect("+idx+")>");
            }

            text.id ="hdn_bl_no";
            //text.attachEvent ('onclick', blNoSelect);

            td.insertBefore(text);
            tr.insertBefore(td);
            tbody.insertBefore(tr);

            text.className="input";
        }
        //조회조건 BL번호에 포커스를 준다.
        ComSetFocus(document.form.bl_no)
    }

    /**
     * Container partial시 Bl No 선택 팝업 호출<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     **/
    function blSelectPopOpen(){
        var sXml = IBS_GetDataSearchXml(sheetObjects["partial"]);
        document.form.xmlData.value = sXml;
        ComOpenPopup("/hanjin/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
    }

    /**
     * BL_NO SELECT BOX에서 선택된 값을 BKG_NO에 세팅한다.<br>
     * 선택된 값의 배경 색상을 변경 시킨다.<br>
     * @param {int} idx 필수, Sheet의 Index값
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     **/
    function blNoSelect(idx){
        document.getElementById("bkg_no").value = sheetObjects["partial"].CellValue(idx, "partial_"+"bkg_no");
        document.getElementById("bl_no").value  = sheetObjects["partial"].CellValue(idx, "partial_"+"bl_no");

        var length = document.getElementsByName("hdn_bl_no").length;
        if(document.getElementsByName("hdn_bl_no").length > 1){
            for(var i=1; i<=length; i++){
                if(i==idx){
                    document.all.hdn_bl_no[i-1].style.backgroundColor= 'rgb(49,106,197)';
                    document.all.hdn_bl_no[i-1].style.color= '#FFFFFF';
                }else{
                    document.all.hdn_bl_no[i-1].style.backgroundColor= '#FFFFFF';
                    document.all.hdn_bl_no[i-1].style.color= 'black';
                }
            }
        }
    }

    /**
     * BL_NO 타이핑 시 BKG_NO. CNTR_NO 초기화<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function conditionReset(){
        if (event.srcElement.name == "bl_no") {
            document.getElementById("bkg_no").value  = '';
            document.getElementById("blInfo_split_flg").value  = '';
            document.getElementById("cntr_no").value = '';
            document.getElementById("h_cntr_no").value = '';
        }else if (event.srcElement.name == "bkg_no") {
            document.getElementById("bl_no").value  = '';
            document.getElementById("cntr_no").value = '';
            document.getElementById("h_cntr_no").value = '';
        }else if (event.srcElement.name == "cntr_no") {
            document.getElementById("bl_no").value  = '';
            document.getElementById("bkg_no").value = '';
            document.getElementById("blInfo_split_flg").value  = '';
            document.getElementById("h_cntr_no").value = '';
        }

        if(event.srcElement.name == "bkg_no" ){
            //이전에 그려 놓은 객체를 지운다.
            try {
                oTbl.removeNode(true);
            }catch(e){}
        }
    }

    /**
     * 조회조건의 끝 공백을 제거한다.
     */
    function conditionTrim(){
        document.getElementById("bl_no").value    = document.getElementById("bl_no").value.trim();
        document.getElementById("bkg_no").value   = document.getElementById("bkg_no").value.trim();
        document.getElementById("cntr_no").value  = document.getElementById("cntr_no").value.trim();
    }

    /**
     * O/BL Received 입력값에 따른 설정<br>
     * India에서는 확장되어 다른 flag도 확인해야 한다.<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function obl_rdem_knt_change(obj){

         var sheetObj = sheetObjects["blIss"];
         if (sheetObj.LastRow == 0 ) {return;}

         var blTpCd     = sheetObj.CellValue(1, "blIss_bl_tp_cd");
         var oblRedmFlg = sheetObj.CellValue(1, "blIss_obl_rdem_flg");
         var delCntCd   = sheetObj.CellValue(1, "blIss_del_cnt_cd");

         if (blTpCd == "S" || blTpCd == "W") {
             // Way Bill, Surrendered는 OB/L Cancel할 수 없다.

//           document.form.blIss_obl_rdem_flg.value = "Y";
             ComBtnDisable("btn_obl_cancel");
             document.getElementById("blIss_obl_rdem_knt").disabled = true;
             document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled = true;
             document.getElementById("blIss_otr_doc_cgor_flg").disabled = true;
             document.getElementById("blIss_ibd_doc_rcv_flg").disabled = true; // India
         } else if (document.form.blIss_obl_rdem_flg.value == "Y") {
             ComBtnEnable("btn_obl_cancel");
             document.getElementById("blIss_obl_rdem_knt").disabled = false;
             document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled = true;
             document.getElementById("blIss_otr_doc_cgor_flg").disabled = true;
             document.getElementById("blIss_ibd_doc_rcv_flg").disabled = true; // India
         } else {
             ComBtnDisable("btn_obl_cancel");
             document.getElementById("blIss_obl_rdem_knt").disabled = false;
             document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled = false;
             if (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0) {
                 document.getElementById("blIss_otr_doc_cgor_flg").disabled = false;
             } else {
                 document.getElementById("blIss_otr_doc_cgor_flg").disabled = true;
             }

             /* for india add by Park Mangeon 20091116 */
             if (document.getElementById("blIss_obl_rdem_knt").value != "" && document.getElementById("blIss_obl_rdem_knt").value.parseInt() > 0) {
                 document.getElementById("blIss_ibd_doc_rcv_flg").disabled = false; // India
             } else if(document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex && document.getElementById("blIss_otr_doc_cgor_flg").selectedIndex > 1) {
                 document.getElementById("blIss_ibd_doc_rcv_flg").disabled = false; // India
             } else {
                 document.getElementById("blIss_ibd_doc_rcv_flg").disabled = true; // India
             }
         }

    }

    /**
     * ERP로 부터 받아온 정보를 Select Box로 구성한다.
     * @param {Object} sheetObj 필수, Sheet객체
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function addSel(sheetObj) {
         var sel = document.form.tot_ots_amt;
         var prefix="otsRcvInfo_";

         for (i=sel.length-1; i>=0; i--){
             sel.options[i] = null
         }

         //미신용 화주이면 미수금을 회수 했을 경우
         //2010.03.04 by sungho 수정
 		//if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")!='N'){
 		if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")=='Y' || sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")=='C'){

//             document.getElementById("otsRcvInfo_tot_ots_sts_cd").value = "Y";

             // btn_cct disable
             document.getElementById("div_btn_cct").style.visibility="hidden";
             document.getElementById("div_btn_third_cct").style.visibility="hidden";

         } else if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")=='N'){
             // btn_cct, div_btn_third_cct visible (안진응)
             if (sheetObj.CellValue(1, prefix+"cct_ots_curr_cd1") == "N") {
               document.getElementById("div_btn_cct").style.visibility="visible";
             }else {
               document.getElementById("div_btn_cct").style.visibility="hidden";
             }

             if (sheetObj.CellValue(1, prefix+"n3pty_cct_ots_curr_cd1") == "N") {
               document.getElementById("div_btn_third_cct").style.visibility="visible";
             } else {
               document.getElementById("div_btn_third_cct").style.visibility="hidden";
             }
         	
         } else {
 			//2010.03.04 by sungho 추가
 			document.form['tot_ots_amt'][0] = new Option(sheetObj.CellValue(1, prefix+"tot_ots_amt1"));
 			
 			document.getElementById("tot_ots_amt").className = "input2_1";
 			
             // btn_cct disable
             document.getElementById("div_btn_cct").style.visibility="hidden";
             document.getElementById("div_btn_third_cct").style.visibility="hidden";
             
             return;
         }

         var unit   = "";
         var amount = "";
         var colorFlg = "";

         for (j=0; j<5; j++){
             unit   = sheetObj.CellValue(1, "otsRcvInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
             amount = sheetObj.CellValue(1, "otsRcvInfo_"+"tot_ots_amt"+parseInt(j+1));
             if(! ComIsEmpty(unit)){
	            	if (amount > 0) {
	            		colorFlg = "Y";
	            	}

             	    document.form['tot_ots_amt'][j] = new Option(unit+' '+ComAddCommaRun(amount), j);                
             }
         }
         
         if (colorFlg == "Y") {
         	//폰트 색상을 붉고 진하게 한다.
         	document.getElementById("tot_ots_amt").className = "input2_1";
         } else {
         	document.getElementById("tot_ots_amt").className = "input2";
         }
    }

    /**
     * TPB로 부터 받아온 정보로 이미지 구성 및 코드 값 세팅<br>
     * @param {String} tpbStatus 필수, TPB상태 값
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function tpbImgSet(tpbStatus) {
        if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;

        if(document.getElementById("tpb_status").value == "1"){
            document.getElementById("tpb_icon").src = "img/btng_icon_green.gif";
            document.getElementById("tpb_cd").value = "C";
            document.getElementById("btn_tpb").style.visibility = "visible";
            //tooltip C=Cleared
            document.getElementById("tpb_cd").setAttribute("title", "Cleared");
        }else if(document.getElementById("tpb_status").value == "0"){
            document.getElementById("tpb_icon").src = "img/btng_icon_r.gif";
            document.getElementById("tpb_cd").value = "P";
            document.getElementById("btn_tpb").style.visibility = "visible";
            //tooltip P=Processing
            document.getElementById("tpb_cd").setAttribute("title", "Processing");
        }else{
            document.getElementById("tpb_icon").src = "img/btng_icon_g.gif";
            document.getElementById("tpb_cd").value = "";
            document.getElementById("btn_tpb").style.visibility = "hidden";
            document.getElementById("tpb_cd").removeAttribute("title");  // tooltip  -- added by mgpark
        }
    }

    /**
     * OBL Cancel 버튼 클릭 시 OBL 값을 초기화 시킨다.<br>
     * @param {void}
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function oblInit(){

        if (document.getElementById("blIss_obl_rdem_flg").value != "Y" ) {
            // blIss_obl_rdem_flg가 Y일 경우에만 값을 초기화 시킨다.
            return;
        }

        document.getElementById("blIss_otr_doc_cgor_flg").options.value  = '';
        document.getElementById("blIss_bl_otr_doc_rcv_cd").options.value = '';
        document.getElementById("blIss_obl_rdem_knt").value = '0';
        document.getElementById("blIss_ibd_doc_rcv_flg").options.value = 'N'; // India

        document.getElementById("blIss_obl_rdem_ofc_cd").value = '';
        document.getElementById("blIss_obl_rdem_usr_id").value = '';
        document.getElementById("blIss_obl_rdem_dt").value = '';
        document.getElementById("bl_surr_rmk_flg").value = '';

        document.getElementById("blIss_otr_doc_rcv_ofc_cd").value = '';
        document.getElementById("blIss_otr_doc_rcv_usr_id").value = '';
        document.getElementById("blIss_otr_doc_rcv_dt").value = '';

        document.getElementById("blIss_ibd_doc_rcv_ofc_cd").value = ''; // india
        document.getElementById("blIss_ibd_doc_rcv_usr_id").value = ''; // india
        document.getElementById("blIss_ibd_doc_rcv_dt").value = '';   // india


        //CR : Cancelled O/BL Received
        document.getElementById("do_cng_evnt_cd").value = 'CR';
        //D/O EVENT 변경 전 값
        document.getElementById("pre_ctnt").value  = 'N';
        //D/O EVENT 변경 전 값
        document.getElementById("crnt_ctnt").value = 'Y';
        //OBL 변경 여부를 Y값으로 세팅한다.
        document.getElementById("obl_cng_flg").value ='Y';
        //OB/L Redemption 플래그를 N으로 세팅한다.
        document.getElementById("blIss_obl_rdem_flg").value = "N";  // TODO: 해당과 같이 정리되어야 하는것 아닌지?

        // OBL Receive, Oth doc, inbound doc receive enable/disable상태를 처리
//        obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"));

        // button을 disable한다.
        ComBtnDisable("btn_obl_cancel");

    }

    /************************************************************************************
        IBSHEET의 OnSaveEnd Event 처리 시작
    ************************************************************************************/

    /**
     * refInfo를 저장하고 나서 처리할 사항<br>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function refInfo_OnSaveEnd(sheetObj, ErrMsg){
        //if (ErrMsg == "") {
            //ComBkgSaveCompleted();  //서버메세지 처리
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
        //}
    }

    /**
     * doRlseSts를 저장하고 나서 처리할 사항<br>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function doRlseSts_OnSaveEnd(sheetObj, ErrMsg){
        //if (ErrMsg == "") {
            //ComBkgSaveCompleted();  //서버메세지 처리
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
        //}
    }

    /**
     * blInfo를 통해 저장 처리하는 Hold, Un-Hold이후 재조회 처리한다.<br>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function blInfo_OnSaveEnd(sheetObj, ErrMsg){
        //if (ErrMsg == "") {
            //ComBkgSaveCompleted();  //서버메세지 처리
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
        //}
    }

    /************************************************************************************

    /************************************************************************************
        IBSHEET의 OnSearchEnd Event 처리 시작
    ************************************************************************************/

    /**
     * IBSheet를 조회하고 나서 처리할 사항<br>
     * 컨테이너 번호에 해당하는 BL NO가 멀티 건이면 선택 팝업을 호출 한다.<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function partial_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            //이전에 그려 놓은 객체를 지운다.
            try {
                oTbl.removeNode(true);
            }catch(e){}

            if(sheetObj.RowCount > 1){
                blSelectPopOpen();
            }else if(sheetObj.RowCount == 1){

                document.getElementById("bl_no").value  = sheetObjects["partial"].CellValue(1, "partial_"+"bl_no")+sheetObjects["partial"].CellValue(1, "partial_"+"bl_tp_cd");
                document.getElementById("bkg_no").value = sheetObjects["partial"].CellValue(1, "partial_"+"bkg_no");

                conditionSet();
            }else{
                sheetObjects["partial"].RemoveAll();
                ComShowCodeMessage('BKG00379');
            }

        }
    }

    /**
     * India D/O Release 기본 정보 조회 IBSheet를 조회하고 나서 처리할 사항<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function blInfo_OnSearchEnd(sheetObj, ErrMsg){

        //Wait Image Show Hidden
        ComOpenWait(false);

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){

                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");

                //저장 버튼 활성화
                //buttonEnable("btn_save");

                //조회 조건
                document.getElementById("bkg_no").value = sheetObj.CellValue(1,"blInfo_bkg_no")
                document.getElementById("bl_no").value  = sheetObj.CellValue(1,"blInfo_bl_no")

                //BL_NO 마지막 자리에 BL_TP_CD를 붙인다.
                if(sheetObj.CellValue(1,"blInfo_bl_tp_cd") !='B'){
                    document.getElementById("bl_no").value  = sheetObj.CellValue(1,"blInfo_bl_no")+sheetObj.CellValue(1,"blInfo_bl_tp_cd");
                }else{
                    document.getElementById("bl_no").value  = sheetObj.CellValue(1,"blInfo_bl_no");
                }

                // 20091125 add by mgpark "DMDT Payment Type"에 따라 "Validity Date" validation속성을 초기화 한다.
                if(document.getElementById("refInfo_ida_do_dmdt_pay_tp_cd").options[0].selected == true) {
                    document.getElementById("refInfo_ida_do_vty_dt").removeAttribute("required");
                } else {
                    document.getElementById("refInfo_ida_do_vty_dt").setAttribute("required", true);
                }
                
                if (sheetObj.CellValue(1,"blInfo_lcloblissueflg") == "Y") {
                	ComShowCodeMessage("BKG00667");
                }
                
                if (document.getElementById("blInfo_cntr_prt_flg").value == "Y") {
                	//폰트 색상을 붉고 진하게 한다.
                	document.getElementById("blInfo_cntr_prt_flg").style.color = "red";            	
                	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight = "bold";
                } else {
                	document.getElementById("blInfo_cntr_prt_flg").style.color = "";
                	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight = "normal";
                }
                
                if (document.getElementById("blInfo_soc_flg").value == "Y") {
                	//폰트 색상을 붉고 진하게 한다.
                	document.getElementById("blInfo_soc_flg").style.color = "red";            	
                	document.getElementById("blInfo_soc_flg").style.fontWeight = "bold";
                } else {
                	document.getElementById("blInfo_soc_flg").style.color = "";
                	document.getElementById("blInfo_soc_flg").style.fontWeight = "normal";
                }
            }
            /*
            else {
                //조회 건이 없을 경우 HTML의 인자값을 초기화 한다. 단 조회조건 제외
                for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
                    if (document.form.getElementsByTagName("input")[i].name != "bl_no"   &&
                        document.form.getElementsByTagName("input")[i].name != "cntr_no" &&
                        document.form.getElementsByTagName("input")[i].name != "bkg_no") {
                        document.form.getElementsByTagName("input")[i].value="";
                    }
                }

            }
            */

            /*************************************************************
                TPB 설정 시작 0 : 빨강 1 : 녹색 -1 : 회색
            *************************************************************/
            tpbImgSet(document.getElementById("tpb_status").value);

        }else{
            //에러발생시 시트를 초기화 시킨다.
            var resetSheetNames = new Array("blInfo", "refInfo", "cstmsInfo", "cntrRlseSts", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "otsRcvPop");
            for(var idx = 0; idx < resetSheetNames.length; idx++){
                sheetObjects[resetSheetNames[idx]].RemoveAll();
            }
        }
    }

    /**
     * India D/O Release Reference 정보 조회 IBSheet를 조회하고 나서 처리할 사항<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function refInfo_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                if (sheetObj.CellValue(1, "refInfo_do_hld_flg") == "") {
                    sheetObj.CellValue2(1, "refInfo_do_hld_flg") = "N";
                }

                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");

                //Hold 여부에 따라서 빨강 또는 회색으로 글씨 처리
                if(sheetObj.CellValue(1, "refInfo_do_hld_flg") =="N"){
                    document.getElementById("hold_flag").className = "input2";
                    //document.getElementById("hold_flag").value = "Hold";
                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
                    document.getElementById("evnt_flag").value = "H";
                    document.getElementById("hld").style.display="";
                    document.getElementById("uhld").style.display="none";
                }else if(sheetObj.CellValue(1, "refInfo_do_hld_flg") =="Y"){
                    document.getElementById("hold_flag").className = "input2_1";
                    document.getElementById("hold_flag").value = "Hold";
                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
                    document.getElementById("evnt_flag").value = "R";
                    document.getElementById("hld").style.display="none";
                    document.getElementById("uhld").style.display="";
                }else{
                    document.getElementById("hold_flag").className = "input2";
                    //document.getElementById("hold_flag").value = 'Hold'; 2009-11-04 윤윤환 수석 India D/O와 동일하게 처리 (Hold 시에만 빨간색 글씨)
                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
                    document.getElementById("evnt_flag").value = 'H';

                    document.getElementById("hld").style.display="";
                    document.getElementById("uhld").style.display="none";
                }

                //DO Split Flg의 값을 세팅한다. (N이 default이므로, Y가 아닌경우 null을 포함하여 No를 true로 한다.
                if (sheetObj.CellValue(1, "refInfo_do_split_flg") ==  "Y") {
                    sheetObjects["doRlseSts"].Visible  = false;
                    sheetObjects["doRlseSts"].style.height=0;
                    sheetObjects["cntrRlseSts"].Visible  = true;
                    sheetObjects["cntrRlseSts"].style.height=82;
                    document.getElementById("div_remain_cnt").style.visibility="visible";
                    document.getElementsByName("refInfo_do_split_flg")[1].checked = true; // add by mgpark 20091125
                } else {
                    sheetObjects["cntrRlseSts"].Visible  = false;
                    sheetObjects["cntrRlseSts"].style.height=0;
                    sheetObjects["doRlseSts"].Visible  = true;
                    sheetObjects["doRlseSts"].style.height=82;
                    document.getElementById("div_remain_cnt").style.visibility="hidden";
                    document.getElementsByName("refInfo_do_split_flg")[0].checked = true; // add by mgpark 20091125
                }

                chkRemark();
            } else {
                document.getElementsByName("refInfo_do_split_flg")[0].checked = true; // add by mgpark 20091125
            }
            	document.form.ida_yd_cd.value = document.form.blInfo_dsch_loc.value;
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function blIss_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {

            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");
            }

            if (document.form.blIss_bl_tp_cd.value == "") {
                document.form.blIss_bl_tp_cd.value = "B";
            }

            //조회된 시점에 Original B/L회수여부가 Y값이면 파란색 N이면 빨간색으로 표시
            if( document.getElementById("blIss_obl_rdem_flg").value =="Y"){
                document.getElementById("blIss_obl_rdem_flg").style.color="blue";
            }else if(document.getElementById("blIss_obl_rdem_flg").value =="N"){
                document.getElementById("blIss_obl_rdem_flg").style.color="red";
            }

            //O/BL 회수  여부 Hidden 속성에 초기값을 세팅한다.
            document.getElementById("h_ori_obl_rdem_flg").value = document.getElementById("blIss_obl_rdem_flg").value;
            document.getElementById("h_aft_obl_rdem_flg").value = document.getElementById("blIss_obl_rdem_flg").value;

            //D/O EVENT에서 변경되기 전의 값 -->
            document.getElementById("pre_ctnt").value = document.getElementById("blIss_obl_rdem_knt").value;

            //O/BL Received 입력값에 따른 설정
            obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"));


            // BL이 Surrender이면 OB/L Received쪽  Remark조회 버튼을 enable 및 필드는 Y로 Setting, 아닐경우 button disable (add by mgpark)
            if (sheetObj.CellValue(1, "blIss_bl_tp_cd") == "S") {
                document.getElementById("bl_surr_rmk_flg").value = "Y";
                document.getElementById("bl_surr_rmk_flg").className = "input2";
                document.getElementById("div_btn_bl_surr_flg").style.visibility="visible";
            } else {
                document.getElementById("bl_surr_rmk_flg").value = "";
                document.getElementById("bl_surr_rmk_flg").className = "noinput2";
                document.getElementById("div_btn_bl_surr_flg").style.visibility="hidden";
            }
            buttonEnableAll();
        }
        //O/BL Received 변경 전 값 설정
        document.getElementById("old_obl_rdem_knt").value = sheetObj.CellValue(1, "blIss_obl_rdem_knt");
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항<br>
     * @param {Object} sheetObj 필수, Sheet개체
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function demInfo_OnSearchEnd(sheetObj){
        //Wait Image Show Hidden
        ComOpenWait(false);

        ComBtnEnable("btn_dem_retrieve"); //DMDT
        ComBtnEnable("btn_dmdt");         //RCV Cancel
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function demDtl_OnSearchEnd(sheetObj){

        var invTotBilAmt = 0;

        //컨테이너 정보의 첫 번째 컨테이너 번호
        var fist_cntr_no = sheetObjects["demInfo"].CellValue(1, "demInfo_cntr_no");

        for(var idx=1; idx <= sheetObj.RowCount; idx++){
            //INVOICE 정보 중 첫 번째 컨테이너 번호에 매치 되는 해당 정보만 보이도록  나머지 로우는 히든 처리
            if(fist_cntr_no != sheetObjects["demDtl"].CellValue(idx, "demDtl_cntr_no")){
                sheetObjects["demDtl"].RowHidden(idx) = true;
            }
            //2010-01-07 SC에서 로직 추가 invTotBilAmt += parseInt(sheetObjects["demDtl"].CellValue(idx, "demDtl_bil_amt"));
        }
        //2010-01-07 SC에서 로직 추가 document.getElementById("invTotBilAmt").value = invTotBilAmt;
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
     function totBlbAmt_OnSearchEnd(sheetObj, ErrMsg){

         var sel = document.form.tot_bil_amt;

         //SELECT BOX 초기화
         for (i=sel.length-1; i>=0; i--){
             sel.options[i] = null;
         }

         var currCd = "";
         var bilAmt = "";
         var demSts = false;

         if (sheetObj.RowCount > 0) {
             for (j=0; j<sheetObj.RowCount; j++){
                 currCd  = sheetObj.CellValue(parseInt(j+1), "totBlbAmt_"+"curr_cd");
                 bilAmt  = sheetObj.CellValue(parseInt(j+1), "totBlbAmt_"+"tot_bil_amt");

                //2010-01-07 SC에서 로직 추가
                //if(document.getElementById("invTotBilAmt").value >0){
                //    bilAmt= parseInt(bilAmt) - parseInt(document.getElementById("invTotBilAmt").value);
                //}

                if (parseInt(bilAmt) > 0) {
                    demSts = true;
                }

                document.form['tot_bil_amt'][j] = new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
             }
             if (demSts == true) {
                document.getElementById("demur_sts").value = "N";
                document.getElementById("demur_sts").style.color='red';
                
                document.getElementById("tot_bil_amt").className = "input2_1";

            } else {
                document.getElementById("demur_sts").value = "Y";
                document.getElementById("demur_sts").style.color='blue';
                
                document.getElementById("tot_bil_amt").className = "input2";
            }
         } else {
             document.getElementById("demur_sts").value = "Y";
             document.form['tot_bil_amt'][0] = new Option('0');
             document.getElementById("demur_sts").style.color='blue';
             document.getElementById("tot_bil_amt").className = "input2";
         }
     }


    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항<br>
     * 인도세관 신고를 위한 B/L INFO 추출<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function cstmsInfo_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");
            }
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항<br>
     * 운임 결재 여부와 Outstanding Amounts 정보 추출<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function otsRcvInfo_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");
                addSel(sheetObj);

                //2009-11-26 임진영 추가
                //조회된 시점에 Y값이면 파란색 N이면 빨간색으로 표시
                if( document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='Y'){
                    document.getElementById("otsRcvInfo_tot_ots_sts_cd").style.color='blue';
                }else if(document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='N'){
                    document.getElementById("otsRcvInfo_tot_ots_sts_cd").style.color='red';
                }
            }
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항<br>
     * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {String} errMsg 필수, 메시지 문자열
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function doRlseSts_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){

                //D/O의 최종 상태를 Hidden Value에 세팅한다.
                for(var idx=1; idx <= sheetObj.RowCount; idx++){

                    //취소 직전의 값을 담는다.
                    if(sheetObj.CellValue(idx, "doRlseSts_rlse_sts_cd") != 'C'){
                        document.getElementById("rlse_sts_cd").value = sheetObj.CellValue(idx, "doRlseSts_rlse_sts_cd");
                    }

                    //마지막 Row의 값을 세팅한다.
                    if(idx == sheetObj.RowCount){
                        document.getElementById("last_rlse_sts_cd").value = sheetObj.CellValue(idx, "doRlseSts_rlse_sts_cd");
                    }

                    //버튼 제어
                    if(sheetObj.CellValue(idx, "doRlseSts_rlse_sts_cd") == 'I'){
                        //Cancel 버튼 활성화
                        //buttonEnable("btn_cancel");
                        //Release 버튼 활성화
                        buttonEnable("btn_assign");
                        buttonEnable("btn_hold");
                        //ComBtnEnable("btn_remark");

                    }else if(sheetObj.CellValue(idx, "doRlseSts_rlse_sts_cd") == 'D'){
                        //Cancel 버튼 활성화
                        //ComBtnEnable("btn_cancel");
                        //ComBtnDisable("btn_assign");
                        //ComBtnDisable("btn_hold");
                        //ComBtnDisable("btn_remark");
                    }
                }

                //히든 값에  D/O 번호를 세팅한다.
                document.getElementById("h_do_no").value = sheetObj.CellValue(1, "doRlseSts_do_no");
                document.getElementById("h_do_no_split").value = sheetObj.CellValue(1, "doRlseSts_do_no_split");

                //ComBtnEnable("btn_history");

                //조회 결과가 Cancel만 존재 할때
                if(sheetObj.RowCount == 1 && sheetObj.CellValue(1, "doRlseSts_rlse_sts_cd") == 'C'){
                    //buttonEnable("btn_assign");
                    //buttonEnable("btn_release");
                    //ComBtnDisable("btn_cancel");
                    //ComBtnDisable("btn_hold");
                }

                //D/O EVENT에서 변경되기 전의 값 -->
                document.getElementById("pre_ctnt").value = sheetObj.CellValue(1, "doRlseSts_rlse_sts_cd");

                //High-Light 맨아래 표시
                sheetObj.SelectCell(sheetObj.RowCount,0)
            }
        }
    }
    /************************************************************************************
        IBSHEET의 OnSearchEnd Event 처리 끝
    ************************************************************************************/

    /************************************************************************************
        IBSHEET의 OnClick Event 처리 시작
    ************************************************************************************/

    /**
     * Grid의 OnClick 이벤트가 발생하면 처리 할 사항 : 클릭 된 컨테이너 번호에 해당하는 INVOICE 정보를 보여준다.<br>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {int} row 필수, 행번호
     * @param {int} col 필수, 열번호
     * @param {String} value 필수, 이벤트가 발생한 실제 값
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function demInfo_OnDblClick(sheetObj, row, col){

        //컨테이너 정보의 첫 번째 컨테이너 번호
        var click_cntr_no = sheetObj.CellValue(row, "demInfo_cntr_no");

        /* 팝업 분기로 로직 필요 없음 2009-12-08 임진영
        for(var idx=1; idx <= sheetObjects["demDtl"].RowCount; idx++){
            //INVOICE 정보 중 첫 번째 컨테이너 번호에 매치 되는 해당 정보만 보이도록  나머지 로우는 히든 처리
            if(click_cntr_no != sheetObjects["demDtl"].CellValue(idx, "demDtl_cntr_no")){
                sheetObjects["demDtl"].RowHidden(idx) = true;
            }else{
                sheetObjects["demDtl"].RowHidden(idx) = false;
            }
        }
        */

        //클릭 시 상세 팝업 호출
        demDtlPopOpen(click_cntr_no)
    }

    /**
     * DEM.DET 상세 정보 팝업
     */
    function demDtlPopOpen(cntr_no){
        var sXml = IBS_GetDataSearchXml(sheetObjects["demDtl"]);
        document.form.demDtlXmlData.value = sXml;

        var condition = "?";
            condition += "cntr_no="+cntr_no;
//        ComOpenWindow('/hanjin/ESM_BKG_1072.do'+condition, 'demDtl', 'width=500,height=275');
        ComOpenWindowCenter('/hanjin/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
    }

    /**
     * Container Release Sheet On Click Event<br>
     * @param {Object} sheetObj 필수, Sheet개체
     * @param {int} row 필수, 행번호
     * @param {int} col 필수, 열번호
     * @param {String} value 필수, 이벤트가 발생한 실제 값
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function cntrRlseSts_OnClick(sheetObj, row, col, value){
        var colName = sheetObj.ColSaveName(col);
        switch (colName) {
            case "cntrRlseSts_evnt_usr_id":
                if (value != "") {
                    ComUserPopup(value);
                }
                break;
        }

    }

     /**
      * Per B/L Release Sheet On Click Event<br>
      * @param {Object} sheetObj 필수, Sheet개체
      * @param {int} row 필수, 행번호
      * @param {int} col 필수, 열번호
      * @param {String} value 필수, 이벤트가 발생한 실제 값
      * @returns void
      * @author Park Mangeon
      * @version 2009.10.01
      */
     function doRlseSts_OnClick(sheetObj, row, col, value){
        var colName = sheetObj.ColSaveName(col);
        switch (colName) {
            case "doRlseSts_evnt_usr_id":
                if (value != "") {
                    ComUserPopup(value);
                }
                break;
        }

     }

    /**
     * Preview버튼 클릭에 대한 이벤트 처리<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnPreview() {
        var formObj = document.form;
        if (formObj.refInfo_do_hld_flg.value == "Y") {
            // B/L was Held
            ComShowCodeMessage("BKG00649");
            return;
        }

        var doNo = fnSelectedDoNo("Preview");
        if (doNo == "") {return; }
//        if(lginOfcCd == "CCUBS"){
       	if(lginOfcCd == "CCUSO"){//@ 2015.08.03 한진그룹 코드 표준화
        	rdLoad(formObj, "ESM_BKG_5038", formObj.h_mrd_param.value, doNo, "Preview");
        }else{
        	rdLoad(formObj, formObj.h_mrd_id.value, formObj.h_mrd_param.value, doNo, "Preview");
        }
    }

     /**
      * SurveyLetter버튼 클릭에 대한 이벤트 처리<br>
      * @param {void}
      * @returns void
      * @author Park Mangeon
      * @version 2010.08.20
      */
     function fnSurvey() {
         var formObj = document.form;
         if (formObj.refInfo_do_hld_flg.value == "Y") {
             // B/L was Held
             ComShowCodeMessage("BKG00649");
             return;
         }

         var doNo = fnSelectedDoNo("Survey");
         if (doNo == "") {return; }

         // doNo가 제공된 경우는 무조건 한개의 DO를 가지고 있다.
         // Container별 DO의 경우 체크된 DO중 최상위 DO만 가져온다. (20100810 mgpark)
         var prefix = "";
         var sheetObj = null;
         var evntDt = "";
         if (formObj.refInfo_do_split_flg[0].checked == true) {  // DO Split by Container = N
        	 prefix = "doRlseSts";
         	 sheetObj = sheetObjects[prefix];
         	 var sRowStr = sheetObj.GetSelectionRows("|");
             var sRowArr = sRowStr.split("|");
             evntDt = sheetObj.CellValue(sRowArr[0], prefix+ "_evnt_dt").substring(0,10);
         } else {
             prefix = "cntrRlseSts";
             sheetObj = sheetObjects[prefix];
             for (var idx = 1; idx <= sheetObj.LastRow; idx ++) {
                 if (sheetObj.CellValue(idx, prefix+"_check") == 1) {
                	 evntDt = sheetObj.CellValue(idx, prefix+ "_evnt_dt").substring(0,10);
                	 break;
                 }
             }
         }
         
         // evntDt를 검증한다. 연월일만 사용하므로 10자리만 잘라온다.
         if(!ComIsDate(evntDt)) {
        	 //alert("날짜가 아닙니다.");
        	 ComShowCodeMessage('COM12134', "Update Time [" + evntDt + "]");
        	 return;
         }
         var paramValue = "form_evntDt[" + evntDt.replace(new RegExp("-", "gi"), "") + "] " + formObj.h_mrd_param.value;
//         alert(formObj.h_mrd_id.value);
         rdLoad(formObj, "ESM_BKG_5034", paramValue, doNo, "Survey");
     }
     
     /**
      * Slot Letter버튼 클릭에 대한 이벤트 처리<br>
      * @param {void}
      * @returns void
      * @author Lee InYoung
      * @version 2011.11.21
      */
     function fnSlot() {
         var formObj = document.form;
         if (formObj.refInfo_do_hld_flg.value == "Y") {
             // B/L was Held
             ComShowCodeMessage("BKG00649");
             return;
         }

         var doNo = fnSelectedDoNo("Slot");
         if (doNo == "") {return; }

         var paramValue = "";
         rdLoad(formObj, "ESM_BKG_5040", paramValue, doNo, "Slot");
     }
     
     /**
      * Carting Order버튼 클릭에 대한 이벤트 처리<br>
      * @param {void}
      * @returns void
      * @author Lee InYoung
      * @version 2011.11.21
      */
     function fnCarting() {
         var formObj = document.form;
         if (formObj.refInfo_do_hld_flg.value == "Y") {
             // B/L was Held
             ComShowCodeMessage("BKG00649");
             return;
         }

         var doNo = fnSelectedDoNo("Carting");
         if (doNo == "") {return; }

         var paramValue = "";
         rdLoad(formObj, "ESM_BKG_5041", paramValue, doNo, "Carting");
     }

    /**
     * Print버튼 클릭에 대한 이벤트 처리<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnPrint() {
        var formObj = document.form;
        if (formObj.refInfo_do_hld_flg.value == "Y") {
            // B/L was Held
            //ComShowCodeMessage("BKG00649");
            ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no"), "Print");
            return;
        }

        var doNo = fnSelectedDoNo("Print");
        if (doNo == "") {return; }

        rdLoad(formObj, formObj.h_mrd_id.value, formObj.h_mrd_param.value, doNo, "Print");
    }

    /**
     * RD를 Load한다.
     * @param {Object} formObject 필수,  FORM개체
     * @param {String} mrdId      필수, DRD ID
     * @param {String} doNo       필수, DD/O 번호
     * @param {String} openType   필수, DPreview 또는 Print flag
     * @return void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function rdLoad(formObject, mrdId, mrdParam, doNo, openType) {
        if(mrdId == ""){
            ComShowCodeMessage("BKG40080");
            return;
        }
        formObject.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"
            + mrdId
            + ".mrd";
        var strArg = "/rv ";
        strArg += " form_bkgNo['" + sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no") + "']";
        strArg += " form_doNo['" + doNo + "']";
        strArg += " form_usrId['" + lginUsrId + "']";
        strArg += " form_mainOnly['Y']";
        strArg += " form_ofcCd['" + lginOfcCd + "']";
        strArg += " form_inDoOdcyAddrCd['" + formObject.in_do_odcy_addr_cd.value + "']";
        strArg += " " + mrdParam;        
//        strArg += " /rfonttype40";//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결

        if (openType == "Preview") {
            formObject.com_mrdArguments.value = strArg;
            formObject.com_mrdTitle.value = "India Cargo Release Order";
            formObject.com_mrdDisableToolbar.value = "";
            formObject.com_mrdBodyTitle.value = "India Cargo Release Order";
            ComOpenRDPopup();
        } else if (openType == "Print") {
            var rdParam = strArg + " /riprnmargin /rwait";

            // 열고자 하는 RD 파일을 지정한다.
            var strPath = RD_path+ formObject.com_mrdPath.value;
            var Rdviewer = rdObjects[0];
            Rdviewer.FileOpen(strPath, RDServer + rdParam);
            Rdviewer.CMPrint();
        } else if (openType == "Survey") {
            formObject.com_mrdArguments.value = strArg;
            formObject.com_mrdTitle.value = "India Cargo Release Order k Letter";
            formObject.com_mrdDisableToolbar.value = "";
            formObject.com_mrdBodyTitle.value = "India Cargo Release Order Survey Letter";
            ComOpenRDPopup();
        } else if (openType == "Slot") {
            formObject.com_mrdArguments.value = strArg + " /riprnmargin /rwait";
            formObject.com_mrdTitle.value = "India Cargo Release Order Slot Letter";
            formObject.com_mrdDisableToolbar.value = "";
            formObject.com_mrdBodyTitle.value = "India Cargo Release Order Slot Letter";
            ComOpenRDPopup();
        } else if (openType == "Carting") {
            formObject.com_mrdArguments.value = strArg + " /riprnmargin /rwait";
            formObject.com_mrdTitle.value = "India Cargo Release Order Carting Preview";
            formObject.com_mrdDisableToolbar.value = "";
            formObject.com_mrdBodyTitle.value = "India Cargo Release Order Carting Preview";
            ComOpenRDPopup();
        }

    }

    /**
     * 모든 Button을 Enable한다.<br>
     * 단 업무적으로 Enable할 수 없는 버튼은 Disabled되도록 유지한다.<br>
     * Event가 상호 간섭하는 것을 방지하기 위한 방안이다.<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function buttonEnableAll(){
        ComBtnEnable("btn_do_id_save");
        //ComBtnEnable("btn_obl_cancel"); btn_obl_cancel 버튼은 partial에 종속되므로 해당 영역에서 처리하도록 한다.
        ComBtnEnable("btn_erp");
        ComBtnEnable("btn_dem_retrieve");
        ComBtnEnable("btn_dmdt");
        ComBtnEnable("btn_save");
        ComBtnEnable("btn_hold");
        ComBtnEnable("btn_history");
        ComBtnEnable("btn_form_setup");
        ComBtnEnable("btn_receiverinfo");
        ComBtnEnable("btn_remark");
        ComBtnEnable("btn_assign");
        ComBtnEnable("btn_cancel");
        ComBtnEnable("btn_if");
        ComBtnEnable("btn_dorcancel");
        ComBtnEnable("btn_print");
        ComBtnEnable("btn_receipt");
        ComBtnEnable("btn_preview");
        ComBtnEnable("btn_release");
        ComBtnEnable("btn_unhold");
        fnBtnOblCancelEnable();
    }

    /**
     * OBL Cancel을 할 수 있는지에 따라 버튼을 Enable Disable한다.<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnBtnOblCancelEnable() {
        var sheetObj = sheetObjects["blIss"];
        if (sheetObj.LastRow == 0 ) {return;}
        if(sheetObj.CellValue(1, "blIss_obl_rdem_flg") != "Y") {
            ComBtnDisable("btn_obl_cancel");
            return;
        }
        var blTpCd     = sheetObj.CellValue(1, "blIss_bl_tp_cd");
        var oblRedmFlg = sheetObj.CellValue(1, "blIss_obl_rdem_flg");
        var delCntCd   = sheetObj.CellValue(1, "blIss_del_cnt_cd");
        if (blTpCd == "S" || blTpCd == "W") {
            // Way Bill, Surrendered는 OB/L Cancel할 수 없다.
            document.getElementById("blIss_obl_rdem_flg").value = "Y";
            ComBtnDisable("btn_obl_cancel");
        }else if (oblRedmFlg != "Y") {
            // OB/L Redemption이 안되어 있는 것은 Cancel할 수 없다.
            ComBtnDisable("btn_obl_cancel");
        }else if (delCntCd != lginCntCd) {
            // delevery국가코드와 로그인 사용자 Office코드가 다르면 작업 불가
            ComBtnDisable("btn_obl_cancel");
        } else {
            ComBtnEnable("btn_obl_cancel");
        }
    }

    /**
     * 각 Location마다 FOC체크 방법이 다를 가능성이 있어 별도 함수로 추출<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnCheckFOC() {
        var formObj = document.form;

        // OB/L Status Check
        if (formObj.blIss_obl_rdem_flg.value != "Y" && formObj.blIss_obl_rdem_flg.value != "C") {
            // Orgin B/L not released!
            ComShowCodeMessage("BKG40066");
            return false;
        }

        // Freight Check
        //Freight Received Status Y가 아니면 Remark for Release를 필수로 남겨야 한다.
		// by sungho 2010.03.04 수정
        //if(formObj.otsRcvInfo_tot_ots_sts_cd.value != "Y"){
		if(formObj.otsRcvInfo_tot_ots_sts_cd.value == "N"){
            if(!remarkForReleasePop()){
                return;
            }
        }

        // Customs Check

        // else OKAY
        return true;
    }

    /**
     * DO History를 조회한다.<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnShowHistory() {
        //Window를 Open합니다.
        var condition = "?";
            condition += "bkg_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
            condition += "&bl_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no");

        ComPostOpenWindow('/hanjin/ESM_BKG_0711.do'+condition, 'win3', 'width=800,height=430');
    }

    /**
     * Form Setup 화면 호출<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnShowFormSetup(){
        ComPostOpenWindow('/hanjin/ESM_BKG_0137.do?pgmNo=ESM_BKG_0137&office='+lginOfcCd, 'win3', 'width=1024,height=480');
    }


    /**
     * Receiver정보를 조회한다.<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnShowRcvrInfo(){
        var doNo = fnSelectedDoNo("Receiver Info");
        if (doNo == "") {return; }

        var formObj = document.form;
            
        var prefix = "";
        var sheetObj = null;
        var evntDt = "";
        if (formObj.refInfo_do_split_flg[0].checked == true) {  // DO Split by Container = N
       	 prefix = "doRlseSts";
        	 sheetObj = sheetObjects[prefix];
        	 var sRowStr = sheetObj.GetSelectionRows("|");
            var sRowArr = sRowStr.split("|");
            evntDt = sheetObj.CellValue(sRowArr[0], prefix+ "_evnt_dt").substring(0,10);
        } else {
            prefix = "cntrRlseSts";
            sheetObj = sheetObjects[prefix];
            for (var idx = 1; idx <= sheetObj.LastRow; idx ++) {
                if (sheetObj.CellValue(idx, prefix+"_check") == 1) {
               	 evntDt = sheetObj.CellValue(idx, prefix+ "_evnt_dt").substring(0,10);
               	 break;
                }
            }
        }
        
        evntDt = evntDt.replace(/\/|\-|\./g,"");
    
        //Window를 Open합니다.
        var condition = "?";
            condition += "do_no="+doNo;
            condition += "&bkg_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
            condition += "&in_do_odcy_addr_cd=" + form.in_do_odcy_addr_cd.value;
            condition += "&evnt_dt=" +  evntDt;
            
        ComPostOpenWindow('/hanjin/ESM_BKG_0936.do'+condition, 'win3', 'width=600,height=335');
    }

    /**
     * Remark를 Popup한다.<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnShowRemark() {
        var doNo = fnSelectedDoNo("Remark");
        if (doNo == "") {return; }
        //Window를 Open합니다.
        var condition = "?";
            condition += "do_no="+doNo;
        ComPostOpenWindow('/hanjin/ESM_BKG_1018.do'+condition, 'win4', 'width=530,height=290');
    }

    /**
     * Surrender Remark를 조회하는 창을 보여준다<br>
     * @param {void}
     * @returns void
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnShowSurrRemark() {
        //Window를 Open합니다.
        var condition = "?";
            condition += "bkg_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
            condition += "&inquery_only=Y";
        ComPostOpenWindow('/hanjin/ESM_BKG_0400.do'+condition, 'win4', 'width=900,height=300');

    }

     /**
      * Remark For Release Popup 호출<br>
      * @param {void}
      * @returns void
      * @author Park Mangeon
      * @version 2009.10.01
      */
     function remarkForReleasePop(){
         var condition = "?";
         condition += "bkg_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
         result = ComOpenWindowCenter('/hanjin/ESM_BKG_0954.do' + condition, "ESM_BKG_0954", 500, 200, true);

         if(result !=undefined){
             document.getElementById("releaseRemark").value = result;
             return true;
         }else{
             return false;
         }
         return true;
     }

     /**
      * 1022화면 Outstanding Amount 호출 <br>
      * @param {boolean} flag 필수, true = CCT, false = Third Party CCT
      * @returns void
      * @author Park Mangeon
      * @version 2009.10.01
      */
     function blOutstandingAmountPopOpen(flag){

        if (sheetObjects["otsRcvInfo"].RowCount == 0) {
             alert("Outstanding Amount 값이 존재하지 않습니다.")
             return;
         }

        sheetObjects["otsRcvPop"].RemoveAll();
         var maxRow = sheetObjects["otsRcvInfo"].LastRow;
        var cellValue = "";
        var prefix = "otsRcvInfo_";

        var curr_cd = "";
        var ots_amt = 0;

        for(i=1;i <= maxRow ; i++){

            //전송상태에 따라 글자색 설정
            for(var q=1;q<6;q++){
                if (flag == true) { // CCT를 선택한 경우
                    if (sheetObjects["otsRcvInfo"].CellValue(i, prefix + "cct_ots_amt" + q) > 0) {
                        curr_cd = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "cct_ots_curr_cd" + q);
                        ots_amt = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "cct_ots_amt" + q);

                        sheetObjects["otsRcvPop"].DataInsert(-1);
                        sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_curr_cd") = curr_cd;
                        sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_tot_ots_amt") = ots_amt;
                    }
                } else {            // Third Office(CCT)를
                    if (sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
                        curr_cd = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
                        ots_amt = sheetObjects["otsRcvInfo"].CellValue(i, prefix + "n3pty_cct_ots_amt" + q);

                        sheetObjects["otsRcvPop"].DataInsert(-1);
                        sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_curr_cd") = curr_cd;
                        sheetObjects["otsRcvPop"].CellValue2(sheetObjects["otsRcvPop"].LastRow, "otsRcvPop_tot_ots_amt") = ots_amt;
                    }
                }
            }
        }

        if (sheetObjects["otsRcvPop"].RowCount > 0) {
            var sXml = IBS_GetDataSearchXml(sheetObjects["otsRcvPop"]);
            document.form.oaXmlData.value = sXml;
            ComOpenPopup("/hanjin/ESM_BKG_1022.do", 400, 320, "", "1,0", true);
        }
     }

     /**
      * B/L별 또는 Container별 List에서 선택한 DO를 추출하여 반환한다.<br>
      * 작업 처리를 위한 공통 Validation을 포함한다.<br>
      * @param {String} buttonName 필수, 버튼 명
      * @returns void
      * @author Park Mangeon
      * @version 2009.10.01
      */
     function fnSelectedDoNo(buttonName) {
         var sheetObj = null;
         var formObj = document.form;
         var prefix = "";
         var doNo = "";
         var rlseStsCd = "";
         var blNo = ""; // 메시지를 위해 사용
         // SHEET 선택
         if (formObj.refInfo_do_split_flg[0].checked == true) {  // DO Split by Container = N
            prefix = "doRlseSts";
            sheetObj = sheetObjects[prefix];
            // SELECTION ROW 선택
            var sRowStr = sheetObj.GetSelectionRows("|");
            var sRowArr = sRowStr.split("|");
            if (sRowStr != "0" ) {
                doNo = sheetObj.CellValue(sRowArr[0], prefix+ "_do_no") + sheetObj.CellValue(sRowArr[0], prefix+ "_do_no_split");
                rlseStsCd = sheetObj.CellValue(sRowArr[0], prefix+ "_rlse_sts_cd");

            }

            if (doNo.trim() == "" || rlseStsCd != "R") {
                // If you want to go one step further, the B/L [{?msg1}] should be on 'Release' Status. \nPlease press 'Release' button then try it again.
                ComShowCodeMessage("BKG40059", sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no"));
                return "";
            }

         } else {
            prefix = "cntrRlseSts";
            sheetObj = sheetObjects[prefix];

            // CHECK ROW 검사
            var doNoTmp = "";
            for (var idx = 1; idx <= sheetObj.LastRow; idx ++) {
                if (sheetObj.CellValue(idx, prefix+"_check") == 1) {
                    // 체크한 정보에 대해서만 점검
                    doNoTmp = sheetObj.CellValue(idx, prefix+ "_do_no") + sheetObj.CellValue(idx, prefix+ "_do_no_split");
                    if (doNoTmp == "") {
                        // Release되지 않은 것
                        ComShowCodeMessage("BKG40071", sheetObj.CellValue(idx, prefix+ "_cntr_no"));
                        return "";
                    }

                    if (doNo != "" && doNoTmp != doNo) {
                        // 두가지 DO번호를 선택한 경우이다.
                        // You can't select the Containers which were assigned to different D/O No.
                        // Please check the D/O No of the containers you clicked.
                        // Then, mouse-click the check box of containers with same D/O No and press [value] Button once again.
                        ComShowCodeMessage("BKG40073");
                        return "";
                    }

                    if (doNo == "") {
                        doNo = doNoTmp;
                    }
                }
            }

            if (doNo.trim() == "") {
                // [{?msg1}] Button is available only when you select Containers by clicking a check box.\nPlease click a check box then press '{?msg1}' Button once again.
                ComShowCodeMessage("BKG40069", buttonName);
                return "";
            }
         }

//        var sheetObj = null;
//        var formObj = document.form;
//        var prefix = "";
//        // SHEET 선택
//        if (formObj.refInfo_do_split_flg[0].checked == true) {  // DO Split by Container = N
//          prefix = "doRlseSts";
//        } else {
//          prefix = "cntrRlseSts";
//        }
//      sheetObj = sheetObjects[prefix];
//      // SELECTION ROW 선택
//      var sRowStr = sheetObj.GetSelectionRows("|");
//
//        var sRowArr = sRowStr.split("|");
//        if(sRowArr.length > 1){
//            //대상을 하나만 지정해주시기 바랍니다.
//            ComShowCodeMessage("BKG00362");
//            return;
//        }
//
//        // DO Number 추출
//        var doNo = "";
//        if (sRowStr != "0" ) {
//          doNo = sheetObj.CellValue(sRowArr[0], prefix+ "_do_no") + sheetObj.CellValue(sRowArr[0], prefix+ "_do_no_split");
//        }


         return doNo;
     }

     /**
      * Hold / Internal Remark(s)의 최대 Line수를 조정<br>
      * @param {Object} obj 필수, 이벤트가 발생한 Text Area
      * @returns void
      * @author Park Mangeon
      * @version 2009.10.01
      */
     function fncTextareaMaxLine(obj)
     {
         var str_line = obj;
         line = str_line.split("\r\n");
         ln = line.length;

         if(ln == 5 && event.keyCode == 13){
             event.returnValue = false;
         }
     }

    /**
     * container를 입력하고 조회시 booking번호 및 bl번호를 조회한다.
     * @param {void}
     * @return void
      * @author Park Mangeon
      * @version 2009.11.13
     */
    function fnSearchContainer(){
        var formObj = document.form;

        if (ComIsNull(formObj.cntr_no)) return;
        if(document.getElementById("h_cntr_no").value == document.getElementById("cntr_no").value) {
            return;
        }
        //같은 cntr_no 번호로 다시 조회 되는 것을 방지하기 위한 비교 값 세팅
        document.getElementById("h_cntr_no").value = document.getElementById("cntr_no").value;
        //팝업호출
        formObj.f_cmd.value = SEARCH01;
        sheetObjects["partial"].DoSearch("ESM_BKG_0292GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("partial_"));
    }

     /**
      * Hold/Internal Remarks 항목에 값이 존재하면 버튼을 Enable 처리하고 버튼색을 빨간색으로 표시한다.
      */
     function chkRemark() {
  	   if (document.form.refinfo_inter_rmk.value.length > 0 ) {
  		   // 항목에 값이 존재하는 경우
  		   buttonColorSet("btn_hold_remark", "red");
  	   } else {
  		   // 항목에 값이 존재하지 않는 경우
  		   buttonColorSet("btn_hold_remark", "gray");
  	   }
     }

      /**
       * 화면의 버튼을 비 활성화 시킨다.
       * @param  void
       * @return void
       * @author An JinEung
       * @version 2009.11.01
       **/
     function buttonColorSet(btn_name, color){
         var tds = document.getElementsByTagName("td");
         var curFlag = null;

//         if (color == 'red') {
//     	    curFlag = "hand";
//         } else {
//     	    curFlag = "default";
//         }

         curFlag = "hand";

         for(var i = 0; i < tds.length; i++) {
             var td=tds[i];

             if(td.name == '•' + btn_name){
            	    td.style.color = color;
            	    td.style.cursor = curFlag;

            	    if (btn_name == "btn_hold_remark") {
             	    document.form.h_hold_remark.value = color;
             	}
                 break;
             }else if(td.name == btn_name){
            	    td.style.color = color;
            	    td.style.cursor = curFlag;

            	    if (btn_name == "btn_hold_remark") {
         		    document.form.h_hold_remark.value = color;
         	    }
                 break;
             }else{
            	    continue;
             }
         }
     }

     function funcSetRemark(remark) {
  	   document.form.refinfo_inter_rmk.value = remark;

  	   chkRemark();
     }
     
     function ida_do_yd_cd_OnChange(comboObj, Index_Code, Text){ //2011.08.02 ComboBox값 변경시 변경된 값 반영
    	 if (sheetObjects["refInfo"].LastRow == 0 ) {return;}
    	 if (document.form.ida_do_yd_cd.index == 0) {
    		 document.form.blInfo_dsch_loc.value = document.form.ida_yd_cd.value;
    	 	 //document.form.blInfo_dsch_loc.value = document.form.ida_do_yd_cd.Code;
    		 sheetObjects["refInfo"].CellValue2(1, "refInfo_ida_do_yd_cd") = "";
    	 } else {
    		 document.form.blInfo_dsch_loc.value = document.form.ida_do_yd_cd.Code;
    		 sheetObjects["refInfo"].CellValue(1, "refInfo_ida_do_yd_cd") = document.form.ida_do_yd_cd.text;
    	 }
     }    
     
     /**
      * 콤보 Object를 배열로 등록
      * @param combo_obj 콤보오브젝트
      */
     function setComboObject(combo_obj) {
     	comboObjects[comboCnt++] = combo_obj;
     }

     
     function initCombo(comboObj) {
    		comboObj.MultiSelect = true;
    		comboObj.UseCode = false;
    		comboObj.LineColor = "#ffffff";
    		comboObj.SetColAlign("left|left");
    		comboObj.MultiSeparator = ",";
    	}