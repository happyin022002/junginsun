/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0682.js
*@FileTitle      : Korea Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.22
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.05.22 임진영
* 1.0 Creation
* 2011.11.16 정선용 [CHM-201114497-01]	한국지역 e-D/O EDI 전송 오류
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview Korea Cargo Release (D/O) 업무에서 사용하는 자바스크립트파일.
     * @author 임진영
     */

    /* 개발자 작업  */

    // 공통전역변수
    var sheetObjects = new Array();
    //var sheetNames   = new Array("blInfo", "refInfo", "cstmsInfo", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl", "totBlbAmt", "ktNet", "stCancel", "partial", "otsRcvPop");
    var sheetNames   = new Array("blInfo", "doRlseSts", "demInfo", "demDtl", "totBlbAmt", "totVol", "partial");
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    var rdObjects = new Array();
    var rdCnt = 0;
    var blInfoHeadCount = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
                    //doActionIBSheet(sheetObjects["blIss"], formObject,IBSAVE);
                    doActionIBSheet(sheetObjects["blInfo"], formObject,IBSAVE);
                break;

                //Preview
                case "btn_preview":
                    preview();
                break;

                //Assign
                case "btn_assign":
                    //doActionIBSheet(sheetObjects["refInfo"], formObject, MULTI04);
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI04);
                break;

                //Release
                case "btn_release":
                    doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI06);
                break;

                //Hold
                case "btn_hold":
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI07);
                break;

                //History
                case "btn_history":
                    go_history();
                break;

                //Form Setting
                case "btn_form_setup":
                    go_formSetting();
                break;

                //Receiver Info
                case "btn_receiverinfo":
                    go_receiver();
                break;

                //Cancel
                case "btn_cancel":
                    doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI05);
                break;

                //Remark
                case "btn_remark":
                    go_remark();
                break;            

                //안진응 추가
                case "btn_cct":
                    blOutstandingAmountPopOpen(true);
                break;

                case "btn_third_cct":
                    blOutstandingAmountPopOpen(false);
                break;

                case "btn_erp":
                    go_erp();
                break;

                case "btn_dmdt":
                    go_dmdt();
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
                    
                    ComOpenWindowCenter('/hanjin/ESD_TPB_0134.do'+condition, 'win4', 1024, 318, true);

                break;

                case "btn_bl_surr_rmk":
                    var condition = "?";
                        condition += "bkg_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
                        condition += "&inquery_only=Y";
                        condition += "&pgmNo=ESM_BKG_0400";
                    ComOpenWindowCenter('/hanjin/ESM_BKG_0400.do'+condition, 'bl_surr_rmk', 900, 300, true);
                break;
                
                case "btn_bl_preview":
                	//조회 조건 체크한다.              
                 	if(ComIsEmpty(formObject.bkg_no.value)){
                        ComShowCodeMessage('BKG40031', formObject.bkg_no.value);
                        formObject.bkg_no.focus();
                        return false;
                    }
    	        	
    	        	var bkg_no = formObject.bkg_no.value;                
                	
        	        var blType = "";
        	     
        			var param = 'bkg_no=' + bkg_no + '&pgmNo=ESM_BKG_0927' + '&bl_tp_cd=D&form_level=6';
        		
        			var url = "ESM_BKG_0927.do?" + param;
        			ComOpenWindow("/hanjin/ESM_BKG_0927.do?" + param, "PopupEsmBkg0927", "scroll:yes;status:no;help:no;dialogWidth:900px;dialogHeight:700px;dialogLeft:0;dialogTop:0", true);
        			break;               
                break;
                

                case "btn_msnbonded":
                    go_msnbonded();
                break;

                //위임장
                case "btn_attorney":
                    go_attorney();
                break;

                case "btn_edoinquiry":
                    //팝업 호출
                    go_edoinquiry();
                break;

                case "btn_edotransmit":
                    //팝업창 호출
                    go_edotransmit();
                break;

                case "btn_edoresult":
                    //팝업 호출
                    go_edoresult();
                break;

                case "btn_stcancel":
                    pressSelfTransToTMNL('SC')
                    //doActionIBSheet(sheetObjects["stCancel"], formObject, MULTI08);
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI08);
                break;

                case "btn_edisend":
                    pressSelfTransToTMNL('ES');
                    //doActionIBSheet(sheetObjects["stCancel"], formObject, MULTI08);
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI08);
                break;

                case "img_exp_del_dt":
                    var cal = new ComCalendar();
                    cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
                break;

                //RCV Cancel
                case "btn_obl_cancel":
                    oblInit();
                break;

                case "btn_dem_retrieve":
                    doActionIBSheet(sheetObjects["blInfo"], formObject,COMMAND07);
                break;

                case "btn_do":

                    if(sheetObjects["blInfo"].rowcount == 0){//결과가 없을경우
                        ComShowCodeMessage("BKG00149");
                        return false;
                    }

                    if (sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_no") == "") {
                        ComShowCodeMessage("BKG40113");
                        return false;
                    }

                    var param = "?";
                        param += "edo_rqst_no="+sheetObjects["blInfo"].CellValue(1 ,"blInfo_edo_rqst_no");
                        param += "&edo_tp_cd=5JN";
                        param += "&edo_rqst_seq_5jn="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jn");
                        param += "&edo_rqst_seq_5jm="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jm");
                        param += "&edo_rqst_seq_5jk="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jk");
                        param += "&pgmNo=ESM_BKG_0133";

                    ComOpenWindow("/hanjin/ESM_BKG_0133.do"+param, "do", "scroll:no;status:no;help:no;dialogWidth:940px;dialogHeight:670px;dialogLeft:0;dialogTop:0", true);
                break;

                case "btn_self":
                    if(sheetObjects["blInfo"].rowcount == 0){//결과가 없을경우
                        ComShowCodeMessage("BKG00149");
                        return false;
                    }
                    
                    //@ 5jm수신 여부와 상관없이 자가 운송 업체 정보를 보여준다.
                    //if (sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jm") == "") {
                        //ComShowCodeMessage("BKG40111");
                        //return false;
                    //}
                    
                    if (sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_no") == "") {
	                    ComShowCodeMessage("BKG40111");
	                    return false;
                    }

                    var param = "?";
                        param += "edo_rqst_no="+sheetObjects["blInfo"].CellValue(1 ,"blInfo_edo_rqst_no");
                        param += "&edo_tp_cd=5JM";
                        param += "&edo_rqst_seq_5jn="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jn");
                        param += "&edo_rqst_seq_5jm="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jm");
                        param += "&edo_rqst_seq_5jk="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jk");
                        param += "&pgmNo=ESM_BKG_0136";

                    ComOpenWindow("/hanjin/ESM_BKG_0136.do"+param, "self", "scroll:auto;status:no;help:no;dialogWidth:960px;dialogHeight:695px;dialogLeft:0;dialogTop:0",true);

                break;

                case "btn_bonded":

                    if(sheetObjects["blInfo"].rowcount == 0){//결과가 없을경우
                        ComShowCodeMessage("BKG00149");
                        return false;
                    }

                    if (sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jk") == "") {
                        ComShowCodeMessage("BKG40112");
                        return false;
                    }

                    var param = "?";
                        param += "edo_rqst_no="+sheetObjects["blInfo"].CellValue(1 ,"blInfo_edo_rqst_no");
                        param += "&edo_tp_cd=5JK";
                        param += "&edo_rqst_seq_5jn="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jn");
                        param += "&edo_rqst_seq_5jm="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jm");
                        param += "&edo_rqst_seq_5jk="+sheetObjects["blInfo"].CellValue(1,"blInfo_edo_rqst_seq_5jk");
                        param += "&pgmNo=ESM_BKG_0135";

                    ComOpenWindow("/hanjin/ESM_BKG_0135.do"+param, "bonded", "scroll:auto;status:no;help:no;dialogWidth:960px;dialogHeight:670px;dialogLeft:0;dialogTop:0", true);
                break;

                case "btn_hold_remark":
                    var paramVal = "?sheet_name=B&pgmNo=ESM_BKG_1089";

//                    ComOpenWindow('/hanjin/ESM_BKG_1089.do' + paramVal, 'win4', 'width=600,height=270');
                    ComOpenWindowCenter('/hanjin/ESM_BKG_1089.do' + paramVal, 'win4', 600, 270, true);

                break;
                
                case "btn_unChecked":
                	/*********************** WEB OB/L 체크 추가 *********************/
                	ComOpenWait(true);        	
                	fnOblInterSerNoSave(sheetObjects["blInfo"],formObject,formObject.blInfo_bl_tp_cd.value, formObject.bkg_no.value);    
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       //sheetObjects[sheetCnt++] = sheet_obj;
       sheetObjects[sheet_obj.id] = sheet_obj; //화면에 정의된 시트 오브젝트를 시트 이름의 배열로 생성한다.
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetNames.length;i++){

            if(sheetObjects[sheetNames[i]].id =='doRlseSts' || sheetObjects[sheetNames[i]].id =='demInfo'){
                //시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[sheetNames[i]] );
            }

            initSheet(sheetObjects[sheetNames[i]],i+1);

            if(sheetObjects[sheetNames[i]].id =='doRlseSts' || sheetObjects[sheetNames[i]].id =='demInfo'){
                //마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[sheetNames[i]]);
            }
        }

        for(i=0;i<rdObjects.length;i++){
            initRdConfig(rdObjects[i]);
        }
        
    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k]);
    	}

        initControl();

        //조회조건 BL번호에 포커스를 준다.
        ComSetFocus(document.form.bl_no)

        //조회 버튼을 제외 한 모든 버튼 비 활성화
        buttonDisabledAll();

        if(document.getElementById("bkg_no").value !='' ){
            doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
        }
    }

    /**
     * 화면에서 발생하는 이벤트를 처리한다.
     * Axon 이벤트 처리
     */
    function initControl(){
        //1. 이벤트catch
        axon_event.addListenerForm('keypress' , 'obj_keypress'   , form);
        axon_event.addListenerForm('click'    , 'obj_click'      , form);
        axon_event.addListenerForm('change'   , 'obj_change'     , form);
        axon_event.addListenerForm('blur'     , 'obj_deactivate' , form);
        //axon_event.addListenerForm('activate' , 'obj_activate'   , form);
        axon_event.addListenerForm('focus'    , 'obj_focus'      , form);
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

    /************************************************************************************
        화면에서 발생하는 이벤트 처리 시작
    ************************************************************************************/

    /**
     * HTML Control의 onkeypress 이벤트 처리.
     */
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
                doActionIBSheet(sheetObjects["blInfo"], document.form, COMMAND07);
            }
        }

        //입력 인자값에 대한 키 입력 설정
        if(srcName == 'bl_no' || srcName == 'bkg_no' || srcName == 'cntr_no'){
            ComKeyOnlyAlphabet('uppernum') ;

        }else if(srcName == 'blInfo_obl_rdem_knt'){
            ComKeyOnlyNumber(event.srcElement);

        }else if(srcName == 'exp_del_dt'){
            ComKeyOnlyNumber(event.srcElement);
        }
    }

    /**
     * HTML Control의 onClick 이벤트 처리.
     */
    function obj_click(){
        //클릭 이벤트 발생 시 B/L No SelectBox 설정
        if (event.srcElement.name == "bl_no") {
            showHideLayers();
        }
    }

    /**
     * HTML Control의 onchange 이벤트에서 Validation을 체크한다.
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

        if(event.srcElement.name == 'blInfo_obl_rdem_knt' || event.srcElement.name == 'blInfo_bl_otr_doc_rcv_cd' || event.srcElement.name == 'blInfo_otr_doc_cgor_flg'){

            //Original Bill of Lading Status N => Y 일 경우만 History를 남긴다.
            if( document.getElementById("blInfo_obl_rdem_flg").value =='Y'){
                return;
            }

            //2009-11-17 윤윤한 수석 결정 사항 History는 obl cancel 또는 obl clear시 남긴다
            if( document.getElementById("blInfo_obl_rdem_knt").value >0 || (document.getElementById("blInfo_bl_otr_doc_rcv_cd").selectedIndex > 0 && document.getElementById("blInfo_otr_doc_cgor_flg").value =='Y')){
                document.getElementById("obl_cng_flg").value ='Y';
                document.getElementById("do_cng_evnt_cd").value = 'RB';
            }
        }
    }

    /**
     * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.
     * @return
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
        }
    }
    */

    /************************************************************************************
        화면에서 발생하는 이벤트 처리 끝
    ************************************************************************************/

    /**
     * 화면의 버튼을 비 활성화 시킨다.
     */
    function buttonDisabledAll(){

        ComBtnDisable("btn_save");
        ComBtnDisable("btn_assign");
        ComBtnDisable("btn_release");
        ComBtnDisable("btn_hold");
        ComBtnDisable("btn_history");
        ComBtnDisable("btn_cancel");
        ComBtnDisable("btn_remark");

        ComBtnDisable("btn_msnbonded");
        ComBtnDisable("btn_attorney");
      //ComBtnDisable("btn_edoinquiry");   //ED/O Inquiry
        ComBtnDisable("btn_edotransmit");  //ED/O Transmit
        ComBtnDisable("btn_edoresult");    //E-D/O Result
        ComBtnDisable("btn_erp");          //ERP
        ComBtnDisable("btn_demdet");       //DEM.DET조회
        ComBtnDisable("btn_stcancel");     //S/T Cancel
        ComBtnDisable("btn_edisend");      //EDI Send
        ComBtnDisable("btn_obl_cancel");   //RCV Canceld
        ComBtnDisable("btn_dem_retrieve"); //DMDT
        ComBtnDisable("btn_dmdt");         //em retrieve
        ComBtnDisable("btn_preview");      //Preview
        ComBtnDisable("btn_bl_preview");    //BLPreview
        ComBtnDisable("btn_receiverinfo"); //Receiver Info

        document.getElementById("selfTransToTMN").disabled = true;
        document.getElementById("btn_tpb").style.visibility = "hidden";
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
        //var resetSheetNames = new Array("blInfo", "refInfo", "cstmsInfo", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl", "totBlbAmt", "ktNet", "stCancel", "otsRcvPop");
        var resetSheetNames = new Array("blInfo", "doRlseSts", "demInfo", "demDtl", "totBlbAmt", "totVol");
        for(var idx = 0; idx < resetSheetNames.length; idx++){
            sheetObjects[resetSheetNames[idx]].RemoveAll();
        }

        document.getElementById("blInfo_inter_rmk").value = "";
        document.getElementById("blInfo_obl_iss_rmk").value = "";
        document.getElementById("blInfo_otr_doc_cgor_flg").options.value = '';
        document.getElementById("blInfo_bl_otr_doc_rcv_cd").options.value ='';
        document.getElementById("tot_ots_amt").options.value ='';
        document.getElementById("tot_bil_amt").options.value ='';

        display_init();
    }

    /**
     * 화면 인자 초기화
     */
    function display_init(){
        // D/O 발급 자가요청 보운동의 체크 박스 초기화
        document.getElementsByName("edo_rqst_sts")[0].checked = false;
        document.getElementsByName("edo_rqst_sts")[1].checked = false;
        document.getElementsByName("edo_rqst_sts")[2].checked = false;

        //체크박스 주위 테두리 색생 초기화

        //Demurrage Type 초기화
        document.getElementById("demur_type").value = "";
        //Hold / Internal Remark(s
        document.getElementById("blInfo_inter_rmk").value = "";

        document.getElementById("blInfo_otr_doc_cgor_flg").options.value = '';
        document.getElementById("blInfo_bl_otr_doc_rcv_cd").options.value ='';

        document.getElementById("selfTransToTMN").checked = false;
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

            case "blInfo":
                with (sheetObj) {

                    /*********************************************
                    //Korea D/O Release 기본 정보
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
                    InitHeadMode(false, false, false, true, false,false)

                    //var HeadTitle = " |POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|DSCH_LOC|BL_TP_CD|OBL_ISS_RMK";
                    var HeadTitle = "|POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|VVD|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|DSCH_LOC|OBL_ISS_RMK"
                                  + "|INTER_RMK|DO_HLD_FLG"
                                  + "|BL회수여부|BL발행통수|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG|OBL_ISS_USR_ID |OBL_RDEM_USR_ID|OTR_DOC_RCV_USR_ID|BL_TP_CD"
                                  + "|MRN|MSN|ENTRY TYPE| |Warehouse Cd|Warehouse|Discharging CY| DISC_LOC_CD"
                                  + "|TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5"
                                  + "|SEQ"
                                  + "|DO|SELF|BONDED|DO_EDO_ACK_CD|SELF_EDO_ACK_CD|BONDED_EDO_ACK_CD|EDO_RQST_NO|EDORQSTSEQ5JN|EDORQSTSEQ5JM|EDORQSTSEQ5JK|MS_PTY_RGST_NO|ATTORNEY_VAL_CHK |ERR_FLG|lcloblissueflg|kr_cstms_bl_tp_cd|cntr_self_trsp_flag";

                    blInfoHeadCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(blInfoHeadCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    var prefix="blInfo_";
                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,                     KEYFIELD,     CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,    prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"por_cd"                ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pol_cd"                ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"pod_cd"                ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,    prefix +"del_cd"                ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"de_term_cd"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"de_term_desc"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"arrival_vessel"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,    prefix +"vvd"        		   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"vps_eta_dt"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pck_qty"               ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"pck_tp_cd"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"act_wgt"               ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"wgt_ut_cd"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"meas_qty"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"meas_ut_cd"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"cntr_prt_flg"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"soc_flg"               ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ccust_nm"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ccust_addr"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ncust_nm"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"ncust_addr"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"scust_nm"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"scust_addr"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"split_flg"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bkg_no"                ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"bl_no"                 ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"dsch_loc"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,    prefix +"obl_iss_rmk"           ,   false,     "",        dfNone,     0,          false,       true);

                    //refInfo
                    InitDataProperty(0,   cnt++ ,     dtData,          200,   daCenter,  false,   prefix +"inter_rmk"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          100,   daCenter,  false,   prefix +"do_hld_flg"             ,   false,     "",        dfNone,     0,          false,       true);

                    //blIss
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_flg"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_cpy_knt"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_iss_ofc_cd"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_iss_dt"             ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"obl_rdem_knt"           ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_ofc_cd"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"obl_rdem_dt"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"bl_otr_doc_rcv_cd"      ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_rcv_ofc_cd"     ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_rcv_dt"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"otr_doc_cgor_flg"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_iss_usr_id"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"obl_rdem_usr_id"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"otr_doc_rcv_usr_id"     ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"bl_tp_cd"               ,   false,     "",        dfNone,     0,          false,       true);

                    //cstmsInfo
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"mf_ref_no"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"mf_seq_no"              ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"cstms_clr_tp_cd"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"cstms_clr_loc_cd"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"cstms_clr_wh_cd"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"wh_nm"                  ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"loc_nm"                 ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"cstms_dchg_loc_wh_cd"   ,   false,     "",        dfNone,     0,          false,       true);

                    //otsRcvInfo
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

                    //stCancel
                    InitDataProperty(0,    cnt++     , dtSeq,          30,    daCenter,  false,   prefix + "Seq");

                    //ktNet
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"do_issue"               ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"self_transportation"    ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"bonded_transportation"  ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"do_edo_ack_cd"          ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"self_edo_ack_cd"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"bonded_edo_ack_cd"      ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"edo_rqst_no"            ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"edo_rqst_seq_5jn"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"edo_rqst_seq_5jm"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"edo_rqst_seq_5jk"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"ms_pty_rgst_no"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,   prefix +"attorney_val_chk"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          90,    daCenter,  false,   prefix +"err_flg"                ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,    prefix +"lcloblissueflg"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,    prefix +"kr_cstms_bl_tp_cd"     ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          80,    daCenter,  false,    prefix +"cntr_self_trsp_flag"   ,   false,     "",        dfNone,     0,          false,       true);
                    
                    CountPosition = 0;
                }
            break;

            case "doRlseSts":

                /****************************************************************
                //B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 62;
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

                    var HeadTitle = " |Status|Status|D/O No.|Update Time|User ID|User Name|Office|BKG NO |RLSE SEQ|RLSE STS SEQ|DO NO SPLIT|SELF_TRNS_FLG";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="doRlseSts_";
                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  0,     daCenter,  false,   prefix +"ibflag");
                    InitDataProperty(0,   cnt++ ,     dtHidden,        150,   daCenter,  false,   prefix +"rlse_sts_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          150,   daCenter,  false,   prefix +"rlse_sts_nm"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          150,   daCenter,  false,   prefix +"do_no"         ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          200,   daCenter,  false,   prefix +"evnt_dt"       ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          150,   daCenter,  false,   prefix +"evnt_usr_id"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          150,   daCenter,  false,   prefix +"upd_usr_nm"    ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtData,          100,   daCenter,  false,   prefix +"evnt_ofc_cd"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        0,     daCenter,  false,   prefix +"bkg_no"        ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        0,     daCenter,  false,   prefix +"rlse_seq"      ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        0,     daCenter,  false,   prefix +"rlse_sts_seq"  ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        0,     daCenter,  false,   prefix +"do_no_split"   ,   false,     "",        dfNone,     0,          false,       true);
                    InitDataProperty(0,   cnt++ ,     dtHidden,        0,     daCenter,  false,   prefix +"self_trns_flg" ,   false,     "",        dfNone,     0,          false,       true);

                    CountPosition = 0;
                    sheetObj.ScrollBar = 0;
                }
            break;


            case "demInfo":

                /****************************************************************
                //DEM.DET I/F
                *****************************************************************/

                with (sheetObj) {
                    // 높이 설정
                    style.height = 92;
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

                    var HeadTitle = " |Seq\n|Container No.|TS|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";

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
                    InitDataProperty(0,   cnt++ , dtData,          50,     daCenter,  false,     prefix +"cntr_tpsz_cd"    , false,   "",    dfNone,      0,     false,       true);
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

                    var HeadTitle1 = "|SEQ||B/L NO.|CNEE NAME|BKG No|BL_TP_CD";
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
            	
            case "totVol":
	            with(sheetObj) {
            		// 높이 설정
	        		style.height = 0;
	        		// 전체 너비 설정
	        		SheetWidth = mainTable.clientWidth;

	        		// Host정보 설정[필수][HostIp, Port, PagePath]
	        		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	        		//전체Merge 종류 [선택, Default msNone]
	        		MergeSheet = msAll

	                //전체Edit 허용 여부 [선택, Default false]	        		
	        		Editable = true;

	        		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	        		InitRowInfo(1, 1, 15, 100);

	        		var HeadTitle1 = "|cntr_tpsz_cd|op_cntr_qty";
	        		var headCount = ComCountHeadTitle(HeadTitle1);

	        		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        		InitColumnInfo(headCount, 0, 0, true);

	        		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	        		InitHeadMode(true, true, false, true, false, false);

	        		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        		InitHeadRow(0, HeadTitle1, true);

	        		var prefix = "totVol_";
	        		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,   COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]	
	        		InitDataProperty(0, cnt++ , dtHiddenStatus, 		30,     daCenter, 	true,		prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,   false,      prefix + "cntr_tpsz_cd",    false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,                 100,    daLeft,     false,      prefix + "op_cntr_qty",     false,      "",     dfNone,         0,      false,      true);
                    CountPosition = 0;
	        	}
            break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        //sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH: //조회

                if(validateForm(sheetObj,formObj,sAction)){

                    //파라메터 초기화
                    inputParamReset();

                    //버튼 설정
                    buttonDisabledAll();

                    formObj.f_cmd.value = SEARCH;

                    var temp_bl  = formObj.bl_no.value;
                    var temp_bkg = formObj.bkg_no.value;

                    ComOpenWait(true);

                    formObj.bl_no.value   = temp_bl;
                    formObj.bkg_no.value  = temp_bkg;

                    //BL_TP_CD가 W Or S이면 BL_TP_CD 제거하기
                    if(formObj.bl_no.value !=''){
                        var blNo   = formObj.bl_no.value;
                        var suffix = blNo.substring(formObj.bl_no.value.length-1)

                        if(suffix =='W' || suffix =='S'){
                            formObj.bl_no.value = blNo.substring(0, blNo.lastIndexOf(suffix));
                        }
                    }

                    //다중조회
                    //var aryPrefix = new Array("blInfo_", "refInfo_", "cstmsInfo_", "doRlseSts_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_", "ktNet_"); //prefix 문자열 배열
                    var aryPrefix = new Array("blInfo_", "doRlseSts_", "demInfo_", "demDtl_",  "totBlbAmt_", "totVol_"); //prefix 문자열 배열
                    var sXml = sheetObjects["blInfo"].GetSearchXml("ESM_BKG_0682GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

                    var arrXml = sXml.split("|$$|");

                    //ETC DATA 처리 : LoadSearchXml 순간 OnSearchEnd Event 발생 (ETC Data로 OnSearchEnd Event에서 처리 할 경우 ETC 데이터 설정 부분을 LoadSearchXml 앞에서 처리 해야 함
                    if(undefined != ComGetEtcData(arrXml[0], "demurType")){
                        document.getElementById("demur_type").value = ComGetEtcData(arrXml[0], "demurType");
                    }

                    if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
                        document.getElementById("tpb_status").value = ComGetEtcData(arrXml[0], "tpbStatus");
                    }

                    if(undefined != ComGetEtcData(arrXml[0], "mrdId") && ComGetEtcData(arrXml[0], "mrdId") != 'null'){
                        //document.getElementById("mrd_id").value = ComGetEtcData(arrXml[0], "mrdId");
                        var mrdId = ComGetEtcData(arrXml[0], "mrdId");

                        var arrMrd = mrdId.split("@@");
                        document.getElementById("mrd_id").value = arrMrd[0];

                        if(undefined != arrMrd[1] && arrMrd[1] != 'null'){
                            document.getElementById("mrd_param").value = arrMrd[1];
                        }
                    }
                    for(var idx = 0; idx < arrXml.length; idx++){
                        sheetObjects[sheetNames[idx]].Redraw = false;
                        if(idx > 0) {
                            sheetObjects[sheetNames[idx]].WaitImageVisible = false;
                        }
                        sheetObjects[sheetNames[idx]].LoadSearchXml(arrXml[idx]);
                        sheetObjects[sheetNames[idx]].Redraw = true;
                    }
                    /*********************** WEB OB/L 체크 추가 ************************/
                    //fnOblInterSerNoCheck(sheetObj,formObj,formObj.blInfo_bl_tp_cd.value, formObj.bkg_no.value);   
                    fnOblInterSerNo(sheetObj, formObj, formObj.blInfo_bl_tp_cd.value, formObj.bkg_no.value);
                    //formObj.obl_inter_ser_no_chk_usr_id.value ="";
                    //formObj.obl_inter_ser_no_chk_dt.value = "";
                    /*********************** WEB OB/L 체크 추가 end*********************/
                    
                }
            break;

            case COMMAND07: //Dem 조회
                if(validateForm(sheetObj,formObj,sAction)){
                	//조회 조건이 변경되었는지를 체크한다.
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }

                    //버튼 설정
                    buttonDisabledAll();

                    formObj.f_cmd.value = SEARCH;

                    ComOpenWait(true);

                    //다중조회
                    //var aryPrefix = new Array("blInfo_", "refInfo_", "cstmsInfo_", "doRlseSts_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_", "ktNet_"); //prefix 문자열 배열
                    var aryPrefix = new Array("blInfo_", "doRlseSts_", "demInfo_", "demDtl_",  "totBlbAmt_", "totVol_"); //prefix 문자열 배열
                    var sXml = sheetObjects["blInfo"].GetSearchXml("ESM_BKG_0682GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                    var arrXml = sXml.split("|$$|");

                    //ETC DATA 처리 : LoadSearchXml 순간 OnSearchEnd Event 발생 (ETC Data로 OnSearchEnd Event에서 처리 할 경우 ETC 데이터 설정 부분을 LoadSearchXml 앞에서 처리 해야 함
                    if(undefined != ComGetEtcData(arrXml[0], "demurType")){
                        document.getElementById("demur_type").value = ComGetEtcData(arrXml[0], "demurType");
                    }

                    for(var idx = 0; idx < arrXml.length; idx++){
                        sheetObjects[sheetNames[idx]].Redraw = false;
                        if(idx > 0) {
                            sheetObjects[sheetNames[idx]].WaitImageVisible = false;
                        }
                        sheetObjects[sheetNames[idx]].LoadSearchXml(arrXml[idx]);

                        if(idx >= 3){
                            sheetObjects[sheetNames[idx]].Redraw = true;
                        }
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

                    CopyFormToRow(formObj, sheetObjects["blInfo"], 1, "");

                    //CopyFormToRow 함수 수행시 시트의 blInfo_ncust_nm blInfo_ncust_addr에서 데이터 변형이 일어남
                    //자동 변형된 데이터를 뺀 나머지의 변경여부를 체크 저장 여부를 확인한다.
                    var midifyCnt = 0; //변경된 갯수
                    for(var i=1; i < blInfoHeadCount; i++){
                        saveName = sheetObjects["blInfo"].ColSaveName(i);
                        idx = sheetObjects["blInfo"].SaveNameCol(saveName);
                        if(saveName =='blInfo_ncust_nm' || saveName =='blInfo_ncust_addr' || saveName == 'blInfo_Seq'){
                            continue;
                        }

                        var OrgValue = sheetObjects["blInfo"].CellSearchValue(1,idx);
                        if (OrgValue != sheetObjects["blInfo"].CellValue(1,idx)){
                              midifyCnt ++;
                        }
                    }

                    if(midifyCnt == 0){
                        ComShowCodeMessage('BKG00797');
                        return false;
                    }

                    var sParam1 = sheetObjects["blInfo"].GetSaveString(true);

                    if( !ComShowCodeConfirm('COM12147' , 'data' ) ){
                        return false;
                    }

                    var aryPrefix = new Array("blInfo_");
                    
                    var sparam = sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                        sparam += "&bkg_no="+sheetObjects["blInfo"].CellValue(1,"blInfo_bkg_no");
                    var sXml = sheetObj.GetSaveXml("ESM_BKG_0682GS.do", sparam);

                    sheetObjects["blInfo"].LoadSaveXml(sXml);
                    sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
                }
            break;

            case MULTI04:// Assign
	        	//조회 조건이 변경되었는지를 체크한다.
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }

                //Original Bill of Lading Status N이면 Release 진행 불가
                //2009-11-02  Kor D/O 수정사항 3.1 a 의거 주석처리
                //if(document.getElementById("blIss_obl_rdem_flg").value =='N'){
                //    ComShowCodeMessage('BKG40066');
                //    return;
                //}

                if(document.getElementById("evnt_flag").value == 'R'){
                    //ComShowCodeMessage('BKG00649');
                    ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no"), "Assign");
                    return;
                }

                //Are you sure to Assign?
                if(!ComShowCodeConfirm('BKG00672')){
                    return false;
                }

                formObj.f_cmd.value = MULTI04;

                var aryPrefix = new Array("blInfo_"); //prefix 문자열 배열

                var sParam1 = sheetObjects["blInfo"].GetSaveString(true);

                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0682GS.do", sparam);

                sheetObjects["blInfo"].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용

            break;

            case MULTI05:// Cancel
	        	//조회 조건이 변경되었는지를 체크한다.
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }

                if(document.getElementById("evnt_flag").value == 'R'){
                    //ComShowCodeMessage('BKG00649');
                    ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no"), "D/O Cancel");
                    return;
                }
              
               //MRN,MSN신고 정보 없을 경우 진행 불가
               if(document.form.blInfo_mf_ref_no.value =='' || document.form.blInfo_mf_ref_no.value ==null){
                   ComShowCodeMessage('BKG40062');
                  return;
               }    
            
                //Are you sure to Cancel?
                if(!ComShowCodeConfirm('BKG00670')){
                    return false;
                }

                var selfTrnsFlg = 'N';
                if(document.getElementById("selfTransToTMN").checked){
                    selfTrnsFlg = 'Y'
                }else{
                    selfTrnsFlg = 'N'
                }
                document.getElementById("self_trns_flg").value = selfTrnsFlg;

                formObj.f_cmd.value = MULTI05;

                //변경이 없어도 필요한 인자값 추출을 위해 상태를 강제로 변경시킨다.
//              2010.04.09 수정 지침에 따라서 수정(안진응)
//                sheetObjects["doRlseSts"].CellValue2(1, "doRlseSts_ibflag") = 'U';
                sheetObjects["doRlseSts"].RowStatus(1) = "U";
                
                
                sheetObj.DoSave("ESM_BKG_0682GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("doRlseSts_"),'', false);

            break;

            case MULTI06:// Release
	        	//조회 조건이 변경되었는지를 체크한다.
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }

            	//Original Bill of Lading Status N이면 Release 진행 불가
                if(document.form.blInfo_mf_ref_no.value =='' || document.form.blInfo_mf_seq_no.value ==''){
                   ComShowCodeMessage('BKG40062');
                   return;
                }    
            
               // 잘못 수신된 요청일경우
                if( sheetObjects["blInfo"].CellValue(1, "blInfo_edo_rqst_no") !="" ){        	
                	
                    if( sheetObjects["blInfo"].CellValue(1, "blInfo_edo_rqst_no") != ( document.form.blInfo_mf_ref_no.value 
                		                                                             + document.form.blInfo_mf_seq_no.value)  ){
                		ComShowCodeMessage("BKG43044");  
                		return;
                	}
                }
            
                if(document.getElementById("blInfo_obl_rdem_flg").value =='N'){
                    ComShowCodeMessage('BKG40066');
                    return;
                }

                if(document.getElementById("evnt_flag").value == 'R'){
                    //ComShowCodeMessage('BKG00649');
                    ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no"), "Release");
                    return;
                }

                var partial = document.getElementById("blInfo_cntr_prt_flg").value

                if(sheetObjects["doRlseSts"].RowCount == 1 && sheetObjects["doRlseSts"].CellValue(1, "doRlseSts_rlse_sts_cd") == 'C'){
                    document.getElementById("rlse_sts_cd").value = '';
                }

                //Freight Received Status Y가 아니면 Remark for Release를 필수로 남겨야 한다.
				// by sungho 2010.03.04 수정
                //if(document.getElementById("blInfo_tot_ots_sts_cd").value !='Y'){
				if(document.getElementById("blInfo_tot_ots_sts_cd").value =='N'){
                    if(!remarkForReleasePop()){
                        return;
                    }
                }

				/*********************** WEB OB/L 체크 추가 ***************************/
				//O B/L 중 Web OB/L Serial No. 체크 하지 않은 것
/*                if ( formObj.blInfo_bl_tp_cd.value == "B" && document.getElementById("obl_inter_ser_no").innerHTML != "" && formObj.obl_inter_ser_no_chk_usr_id.value == "") {
                	//체크 ID 가 없을 경우 메세지 출력
            		ComShowCodeMessage("BKG95098");
                    return;
            	}*/
				//alert("확인");
				
            	var comboCount = comboObjects[0].GetCount();
                if(formObj.blInfo_bl_tp_cd.value == "B" && comboCount>0 && formObj.blInfo_bl_otr_doc_rcv_cd.value == ""){
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
                if(!ComShowCodeConfirm('BKG00673')){
                    return false;
                }

                document.getElementById("self_trns_flg").value = document.getElementById("selfTransToTMN").checked ? 'Y' : 'N';

                formObj.f_cmd.value = MULTI06;

                var aryPrefix = new Array("blInfo_", "doRlseSts_");    //prefix 문자열 배열

                var sParam1 = sheetObjects["blInfo"].GetSaveString(true);
                var sParam2 = sheetObjects["doRlseSts"].GetSaveString(true);

                var sparam  = sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                var sXml = sheetObj.GetSaveXml("ESM_BKG_0682GS.do", sparam);

                sheetObjects["blInfo"].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용

            break;

            case MULTI07:// Hold
	        	//조회 조건이 변경되었는지를 체크한다.
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }

            	if(document.getElementById("evnt_flag").value =='H'){
                    //Are you sure to Hold?
                    if(!ComShowCodeConfirm('BKG00671')){
                        return false;
                    }
                }

                formObj.f_cmd.value = MULTI07;

                var aryPrefix = new Array("blInfo_");    //prefix 문자열 배열

                var sParam1 = sheetObjects["blInfo"].GetSaveString(true);
                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0682GS.do", sparam);

                sheetObjects["blInfo"].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml); // 넘어온 메시지는 한번만 보이고 싶을 때 사용

            break;

            case MULTI08:// S/T Cancel or EDI Send
	        	//조회 조건이 변경되었는지를 체크한다.
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }

                //2009-10-21 윤윤한 수석 협의 메세지 안보여주기
                //Do you want to Cancel it?
                //if(!ComShowCodeConfirm('BKG00575')){
                //    return false;
                //}
               
                formObj.f_cmd.value = MULTI08;

                document.getElementById("self_trns_flg").value = document.getElementById("selfTransToTMN").checked ? 'Y' : 'N';

                var aryPrefix = new Array("blInfo_");    //prefix 문자열 배열

                var sParam1 = sheetObjects["blInfo"].GetSaveString(true);
                var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

                var sXml = sheetObj.GetSaveXml("ESM_BKG_0682GS.do", sparam);

                sheetObjects["blInfo"].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml); // 넘어온 메시지는 한번만 보이고 싶을 때 사용

            break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        var oForm = document.form;

        if(sAction ==IBSAVE){

             if(document.getElementById("blInfo_obl_cpy_knt").value < parseInt(document.getElementById("blInfo_obl_rdem_knt").value)){
            //if(document.getElementById("blIss_obl_cpy_knt").value < parseInt(document.getElementById("blIss_obl_rdem_knt").value)){
                //The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen.\nYou have input the number in Received field less or the same number of B/L Released.
                ComShowCodeMessage('BKG40065');
                //document.getElementById("blIss_obl_rdem_knt").focus();
                 document.getElementById("blInfo_obl_rdem_knt").focus();
                return false;
            }

        }else if(sAction ==IBSEARCH){

            //조회조건의 끝 공백을 제거한다.
            conditionTrim();

            if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.bkg_no)){
                ComShowCodeMessage('BKG40097'); //필수 조회 조건이 누락되었습니다. B/L No or Container No or BKG No가 필수 조회 조건입니다.
                ComSetFocus(oForm.bl_no)
                return false;
            }

            if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
                return false;
            }

        //DEM.DET Retrieve
        }else if(sAction == COMMAND07){

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

    /**************************************************************
        TRIC SELECT BOX CODE START
    **************************************************************/

    /**
     * HTML Control의 deactivate 이벤트 처리. <br>
     */
    function showHideLayers() {
        var el = event.srcElement;

        if(el.tagName.toLowerCase() !='input'){
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
     * TRiC SELECT BOX를 그린다.
     */
    function conditionSet(aryPopupData){

        if(aryPopupData != undefined){
            document.getElementById("bl_no").value  = aryPopupData[0][3]+aryPopupData[0][6];
            document.getElementById("bkg_no").value = aryPopupData[0][5];
        }

        tbl = document.createElement("TABLE");
        tbl.id ='oTbl';
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

    function initRdConfig(rdObject){
        var Rdviewer = rdObject ;

        Rdviewer.AutoAdjust = true;
        Rdviewer.ViewShowMode(0);

        Rdviewer.setbackgroundcolor(128,128,128);
        Rdviewer.SetPageLineColor(128,128,128);
    }

    /**
     * O/BL Received 입력값에 따른 설정
     */
    function obl_rdem_knt_change(sheetObj, obj){
        //var sheetObj = sheetObjects["blIss"];
        var sheetObj = sheetObj;
        if (sheetObj.LastRow == 0 ) {return;}

        var blTpCd     = sheetObj.CellValue(1, "blInfo_bl_tp_cd");
        var oblRedmFlg = sheetObj.CellValue(1, "blInfo_obl_rdem_flg");
        //var delCntCd   = sheetObj.CellValue(1, "blInfo_del_cnt_cd");

        if (blTpCd == "S" || blTpCd == "W") {
            // Way Bill, Surrendered는 OB/L Cancel할 수 없다.
            //document.form.blInfo_obl_rdem_flg.value = "Y";
            ComBtnDisable("btn_obl_cancel");
            document.getElementById("blInfo_obl_rdem_knt").disabled = true;
            document.getElementById("blInfo_bl_otr_doc_rcv_cd").disabled = true;
            document.getElementById("blInfo_otr_doc_cgor_flg").disabled = true;
        } else if (document.form.blInfo_obl_rdem_flg.value == "Y") {
            ComBtnEnable("btn_obl_cancel");
            document.getElementById("blInfo_obl_rdem_knt").disabled = false;
            document.getElementById("blInfo_bl_otr_doc_rcv_cd").disabled = true;
            document.getElementById("blInfo_otr_doc_cgor_flg").disabled = true;
        } else {
            ComBtnDisable("btn_obl_cancel");
            document.getElementById("blInfo_obl_rdem_knt").disabled = false;
            document.getElementById("blInfo_bl_otr_doc_rcv_cd").disabled = false;            
            document.getElementById("blInfo_otr_doc_cgor_flg").disabled = false;
            
        }
    }

    //ERP로 부터 받아온 정보를 Select Box로 구성한다.
    function addSel(sheetObj) {
        var sel = document.form.tot_ots_amt;
        var prefix="blInfo_";

        for (i=sel.length-1; i>=0; i--){
            sel.options[i] = null
        }

        //미신용 화주이면 미수금을 회수 했을 경우
        //2010.03.04 by sungho 수정
		//if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")!='N'){
        
		if(sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")=='Y' || sheetObj.CellValue(1, prefix+"tot_ots_sts_cd")=='C'){

//            document.getElementById("blInfo_tot_ots_sts_cd").value = "Y";

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
            unit   = sheetObj.CellValue(1, "blInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
            amount = sheetObj.CellValue(1, "blInfo_"+"tot_ots_amt"+parseInt(j+1));
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
     * History 팝업 호출 <br>
     */
    function go_history(){
        //Window를 Open합니다.
        var condition = "?";
            condition += "bkg_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
            condition += "&bl_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no");
            condition += "&pgmNo=ESM_BKG_0711";
//        ComPostOpenWindow('/hanjin/ESM_BKG_0711.do'+condition, 'history', 'width=800,height=458');
        ComOpenWindowCenter('/hanjin/ESM_BKG_0711.do'+condition, 'history', 800, 458, true);    
    }

    /**
     * Form Setting 팝업 호출 <br>
     */
    function go_formSetting(){
        var condition = "?";
            condition += "pgmNo=ESM_BKG_0137";
            condition += "&office="+lginOfcCd;
//        ComPostOpenWindow('/hanjin/ESM_BKG_0137.do'+condition, 'setting', 'width=1024,height=510');
        ComOpenWindowCenter('/hanjin/ESM_BKG_0137.do'+condition, 'setting', 1024, 510, true);
    }

    /**
     * Receiver Info 팝업 호출 <br>
     */
    function go_receiver(){
        var doNo = sheetObjects["doRlseSts"].CellValue(1, "doRlseSts_do_no");
        //조회 안하고 버튼 클릭 시 DO No 초기값으로 설정
        if(doNo == undefined){
            doNo = '';
        }
        var condition = "?";
            condition += "do_no="+doNo;
            condition += "&pgmNo=ESM_BKG_0130";
//        ComPostOpenWindow('/hanjin/ESM_BKG_0130.do'+condition, 'receiver', 'width=500,height=290,scroll=no');
        ComOpenWindowCenter('/hanjin/ESM_BKG_0130.do'+condition, 'receiver', 500, 290, true);
    }

    /**
     * Remark 팝업 호출 <br>
     */
    function go_remark(){
        var condition = "?";
            condition += "do_no="+document.getElementById("h_do_no").value;
            condition += "&pgmNo=ESM_BKG_1018";
//        ComPostOpenWindow('/hanjin/ESM_BKG_1018.do'+condition, 'remark', 'width=530,height=318');
        ComOpenWindowCenter('/hanjin/ESM_BKG_1018.do'+condition, 'remark', 530, 318, true);
    }

    /**
     * Erp 팝업 호출 <br>
     */
    function go_erp(){
        // => Live : /http://erp.hanjin.com/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
        // => Test : /http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE
//        ComOpenWindow('http://ktrp4vpa.hanjin.com:8000/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE', 'erp', 'width=1024,height=700');

		// CoBkg.js 의 ERP 호출하는 함수 실행
		callInboundErp();
        
    }

    /**
     * Dmdt 호출 <br>
     */
    function go_dmdt(){
        var bkgNo  = sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
        var blNo   = sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no");
        var trfCd  = document.getElementById("demur_type").value;
        var paramVal = "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&pgmNo=EES_DMT_3002P";
        paramVal += "&pgmNo=EES_DMT_3002P";

//        ComOpenWindow('/hanjin/EES_DMT_3002P.do' + paramVal, 'dmdt', 'width=1010,height=670');
        ComOpenWindowCenter('/hanjin/EES_DMT_3002P.do' + paramVal, 'dmdt', 1010, 670, true);
    }

    /**
     * E/DO Inquiry 팝업 호출 <br>
     */
    function go_edoinquiry(){
        var podCd = document.form.blInfo_pod_cd.value;

        var param = "?";
            param += "&edo_rct_loc_cd="+podCd;
            param += "&autoSearchFlg=Y";
            param += "&pgmNo=ESM_BKG_0132";

        //Window를 Open합니다.
//        ComPostOpenWindow('/hanjin/ESM_BKG_0132.do'+param, 'edoinquiry', 'width=1024,height=692');
        ComOpenWindowCenter('/hanjin/ESM_BKG_0132.do'+param, 'edoinquiry', 1024, 692, false);
    }

    /**
     * MSN & Bonded 팝업 호출 <br>
     */
    function go_msnbonded(){
        var param = "?";
            param += "bl_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no");
            param += "&pgmNo="+"ESM_BKG_0333";
        //Window를 Open합니다.
//        ComPostOpenWindow('/hanjin/ESM_BKG_0333.do'+param, 'msnbonded', 'width=1024,height=558');
        ComOpenWindowCenter('/hanjin/ESM_BKG_0333.do'+param, 'msnbonded', 1024, 558, true);
    }

    /**
     * E/DO Result 팝업 호출 <br>
     */
    function go_edoresult(){
        var param = "?";
            param += "bl_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no");
            param += "&autoSearchFlg=Y";
            param += "&pgmNo=ESM_BKG_0134";

        //Window를 Open합니다.
//        ComPostOpenWindow('/hanjin/ESM_BKG_0134.do'+param, 'edoresult', 'width=1024,height=660');
        ComOpenWindowCenter('/hanjin/ESM_BKG_0134.do'+param, 'edoresult', 1024, 660, true);
    }

    /**
     * E/DO Transmit 팝업 호출 <br>
     */
    function go_edotransmit(){

        var approvals = '';
        
        //MRN 신고가 안됐을 경우  Release 진행 불가
        if(document.form.blInfo_mf_ref_no.value =='' || document.form.blInfo_mf_seq_no.value ==null){
           ComShowCodeMessage('BKG40062');
           return;
        }    
     // 잘못 수신된 요청일경우
            	
                
        if( sheetObjects["blInfo"].CellValue(1, "blInfo_edo_rqst_no") != ( document.form.blInfo_mf_ref_no.value 
            		                                                     + document.form.blInfo_mf_seq_no.value)  ){
        	ComShowCodeMessage("BKG43044");  
        	return;
        }
         
        //B/L Type 이 값이 없으면 ( Null 혹은 공백 ) 경고 메시지(BKG02101) 출력 후 작업 중단 
        if(document.form.blInfo_kr_cstms_bl_tp_cd.value =='' || document.form.blInfo_kr_cstms_bl_tp_cd.value ==null){
			ComShowCodeMessage("BKG02101");  
			return;
		}
        
        if (document.getElementsByName("edo_rqst_sts")[0].checked == true) {
            approvals += 'T;';
        }else{
            approvals += 'F;';
        }

        if (document.getElementsByName("edo_rqst_sts")[1].checked == true) {
            approvals += 'T;';
        }else{
            approvals += 'F;';
        }

        if (document.getElementsByName("edo_rqst_sts")[2].checked == true) {
            approvals += 'T;';
        }else{
            approvals += 'F;';
        }

        var param = "?";
        /*
            param += "approvals="+approvals;
            param += "&last_rlse_sts_cd="+document.getElementById("last_rlse_sts_cd").value;
            param += "&bkg_no="+sheetObjects["blInfo"].CellValue(1,"blInfo_bkg_no");
            param += "&rqst_no="+document.getElementById("blInfo_mf_ref_no").value+document.getElementById("blInfo_mf_seq_no").value;
            param += "&mrn_no="+document.getElementById("blInfo_mf_ref_no").value;
            param += "&msn_no="+document.getElementById("blInfo_mf_seq_no").value;
            param += "&de_term_desc="+document.form.blInfo_de_term_desc.value;
         */
            param += "approvals="+approvals;
            param += "&last_rlse_sts_cd="+document.form.last_rlse_sts_cd.value;
            param += "&bkg_no="+document.form.bkg_no.value ;
            param += "&rqst_no="+document.form.blInfo_mf_ref_no.value+document.form.blInfo_mf_seq_no.value;
            param += "&mrn_no="+document.form.blInfo_mf_ref_no.value;
            param += "&msn_no="+document.form.blInfo_mf_seq_no.value;
            param += "&pod_cd="+document.form.blInfo_pod_cd.value;
            param += "&del_cd="+document.form.blInfo_del_cd.value;
            param += "&de_term_desc="+document.form.blInfo_de_term_desc.value;

            param += "&pgmNo=ESM_BKG_0737";

        //Window를 Open합니다.
//        ComPostOpenWindow('/hanjin/ESM_BKG_0737.do'+param, 'edotransmit', 'width=718,height=186');
        ComOpenWindowCenter('/hanjin/ESM_BKG_0737.do'+param, "edotransmit", 718, 186, true);

        
    }

    function go_attorney(){
        var param = "?";
            param += "cust_biz_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_ms_pty_rgst_no");
            param += "&pgmNo=ESM_BKG_0999";

        //Window를 Open합니다.
//        ComPostOpenWindow('/hanjin/ESM_BKG_0999.do'+param, 'attorney', 'width=900,height=480');
        ComOpenWindowCenter('/hanjin/ESM_BKG_0999.do'+param, 'attorney', 900, 480, true);
    }

    /**
     * Container partial시 Bl No 선택 팝업 호출<br>
     */
    function blSelectPopOpen(){
        var sXml = IBS_GetDataSearchXml(sheetObjects["partial"]);
        document.form.xmlData.value = sXml;
        ComOpenPopup("/hanjin/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
    }

    /**
     * BL_NO SELECT BOX에서 선택된 값을 BKG_NO에 세팅한다.<br>
     * 선택된 값의 배경 색상을 변경 시킨다.
     */
    function blNoSelect(idx){

        document.getElementById("bkg_no").value = sheetObjects["partial"].CellValue(idx, "partial_"+"bkg_no");
        document.getElementById("bl_no").value  = sheetObjects["partial"].CellValue(idx, "partial_"+"bl_no")+sheetObjects["partial"].CellValue(idx, "partial_"+"bl_tp_cd");

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
     * 자가운송 승인 EDI전송시 부모창의 Self Trans To TMNL이 자동으로 클릭이 됨
     */
    function pressSelfTransToTMNL(flag){
        if(flag =='ES'){
            document.getElementById("selfTransToTMN").checked = true;
        }else{
            document.getElementById("selfTransToTMN").checked = false;
        }
    }

    /**
     * 체크 박스의 색상을 상태에 따라서 세팅한다.
     */
    function edoCheckBoxColorSet(str){
        var strArr = str.split(",");

        for(var idx = 0; idx < strArr.length; idx++){
            if (strArr[idx]=='A') {//승인,파랑색

                if(idx == '0') {
                    document.getElementById("btn_do").style.color='rgb(0,0,255)';
                }
                if(idx == '1') {
                    document.getElementById("btn_self").style.color='rgb(0,0,255)';
                }
                if(idx == '2') {
                    document.getElementById("btn_bonded").style.color='rgb(0,0,255)';
                }
            }
            if (strArr[idx]=='R') { //거부,빨강색
            	  if(idx == '0') {
                      document.getElementById("btn_do").style.color='rgb(255,0,0)';
                  }
                  if(idx == '1') {
                      document.getElementById("btn_self").style.color='rgb(255,0,0)';
                  }
                  if(idx == '2') {
                      document.getElementById("btn_bonded").style.color='rgb(255,0,0)';
                  }
            }
            if (strArr[idx]=='P') {//보류,연두색
            	 if(idx == '0') {
                     document.getElementById("btn_do").style.color='rgb(128,255,0)';
                 }
                 if(idx == '1') {
                     document.getElementById("btn_self").style.color='rgb(128,255,0)';
                 }
                 if(idx == '2') {
                     document.getElementById("btn_bonded").style.color='rgb(128,255,0)';
                 }
             }
        }
    }

    //Remark For Release Popup 호출
    function remarkForReleasePop(){

        var condition = "?";
            condition += "bkg_no="+sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");
            condition += "&pgmNo=ESM_BKG_0954";
        result = ComOpenWindowCenter('/hanjin/ESM_BKG_0954.do' + condition, "ESM_BKG_0954", 500, 200, true);

        if(result !=undefined){
            document.form.releaseRemark.value = result;
            return true;
        }else{
            return false;
        }
        return true;
    }

    //TPB로 부터 받아온 정보로 이미지 구성 및 코드 값 세팅
    function tpbImgSet(tpbStatus) {
        if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;

        if(document.getElementById("tpb_status").value == "1"){
            document.getElementById("tpb_icon").src = "img/btng_icon_green.gif";
            document.getElementById("tpb_cd").value = 'C';
            document.getElementById("btn_tpb").style.visibility = "visible";
            //tooltip C=Cleared
            document.getElementById("tpb_cd").setAttribute("title", "Cleared");
        }else if(document.getElementById("tpb_status").value == "0"){
            document.getElementById("tpb_icon").src = "img/btng_icon_r.gif";
            document.getElementById("tpb_cd").value = 'P';
            document.getElementById("btn_tpb").style.visibility = "visible";
            //tooltip P=Processing
            document.getElementById("tpb_cd").setAttribute("title", "Processing");
        }else{
            document.getElementById("tpb_icon").src = "img/btng_icon_g.gif";
            document.getElementById("tpb_cd").value = '';
            document.getElementById("btn_tpb").style.visibility = "hidden";
            
            document.getElementById("tpb_cd").removeAttribute("title");
        }
    }

    //OBL Cancel 버튼 클릭 시 OBL 값을 초기화 시킨다.
    function oblInit(){

        document.getElementById("blInfo_otr_doc_cgor_flg").options.value  = '';
        document.getElementById("blInfo_bl_otr_doc_rcv_cd").options.value = '';
        document.getElementById("blInfo_obl_rdem_knt").value = '0';

        document.getElementById("blInfo_obl_rdem_ofc_cd").value = '';
        document.getElementById("blInfo_obl_rdem_usr_id").value = '';
        document.getElementById("blInfo_obl_rdem_dt").value = '';
        document.getElementById("bl_surr_rmk_flg").value = '';

        document.getElementById("blInfo_otr_doc_rcv_ofc_cd").value = '';
        document.getElementById("blInfo_otr_doc_rcv_usr_id").value = '';
        document.getElementById("blInfo_otr_doc_rcv_dt").value = '';

        //CR : Cancelled O/BL Received
        document.getElementById("do_cng_evnt_cd").value = 'CR';
        //D/O EVENT 변경 전 값
        document.getElementById("pre_ctnt").value  = 'N';
        //D/O EVENT 변경 전 값
        document.getElementById("crnt_ctnt").value = 'Y';
        //OBL 변경 여부를 Y값으로 세팅한다.
        document.getElementById("obl_cng_flg").value ='Y';

        document.getElementById("new_obl_rdem_knt").value = '0';
    }

    /************************************************************************************
        IBSHEET의 OnSaveEnd Event 처리 시작
    ************************************************************************************/

    /**
     * blInfo를 저장하고 나서 처리할 사항
     */
    function blInfo_OnSaveEnd(sheetObj, ErrMsg){
        //if (ErrMsg == "") {
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
        //}
    }

    /**
     * refInfo를 저장하고 나서 처리할 사항
     */
    function refInfo_OnSaveEnd(sheetObj, ErrMsg){
        //if (ErrMsg == "") {
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
        //}
    }

    /**
     * doRlseSts를 저장하고 나서 처리할 사항
     */
    function doRlseSts_OnSaveEnd(sheetObj, ErrMsg){
        //if (ErrMsg == "") {
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
        //}
    }

    /**
     * stCancel를 저장하고 나서 처리할 사항
     */
    function stCancel_OnSaveEnd(sheetObj, ErrMsg){
        //if (ErrMsg == "") {
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
        //}
    }

    /************************************************************************************
        IBSHEET의 OnSaveEnd Event 처리 종료
    ************************************************************************************/

    /************************************************************************************
        IBSHEET의 OnSearchEnd Event 처리 시작
    ************************************************************************************/

    /**
     * IBSheet를 조회하고 나서 처리할 사항
     * 컨테이너 번호에 해당하는 BL NO가 멀티 건이면 선택 팝업을 호출 한다.
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

                doActionIBSheet(sheetObjects["blInfo"], document.form ,IBSEARCH);
            }else{
                sheetObjects["partial"].RemoveAll();
                ComShowCodeMessage('BKG00379');
            }
        }
    }

    /**
     * Kor D/O Release 기본 정보 조회 IBSheet를 조회하고 나서 처리할 사항
     */
    function blInfo_OnSearchEnd(sheetObj, ErrMsg){

        //Wait Image Show Hidden
        ComOpenWait(false);

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){

                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");

                //저장 버튼 활성화
                ComBtnEnable("btn_save");
                //Hold 버튼 활성화
                ComBtnEnable("btn_hold");

                //조회 조건
                document.getElementById("bkg_no").value = sheetObj.CellValue(1,"blInfo_bkg_no");
                //BL_NO 마지막 자리에 BL_TP_CD를 붙인다.
                if(sheetObj.CellValue(1,"blInfo_bl_tp_cd") !='B'){
                    document.getElementById("bl_no").value  = sheetObj.CellValue(1,"blInfo_bl_no")+sheetObj.CellValue(1,"blInfo_bl_tp_cd");
                }else{
                    document.getElementById("bl_no").value  = sheetObj.CellValue(1,"blInfo_bl_no");
                }
            }

            /*************************************************************
                TPB 설정 시작 0 : 빨강 1 : 녹색 -1 : 회색
            *************************************************************/
            tpbImgSet(document.getElementById("tpb_status").value);

            /*********************************************************************
                Sheet가 통합되면서 없어진 Sheet의 OnSearchEnd 함수를 호출한다.
            *********************************************************************/
            refInfo_OnSearchEnd(sheetObj, ErrMsg);
            cstmsInfo_OnSearchEnd(sheetObj, ErrMsg);
            blIss_OnSearchEnd(sheetObj, ErrMsg);
            otsRcvInfo_OnSearchEnd(sheetObj, ErrMsg);
            ktNet_OnSearchEnd(sheetObj, ErrMsg);

            //버튼 활성화
            ComBtnEnable("btn_erp");
            ComBtnEnable("btn_dem_retrieve");
            ComBtnEnable("btn_dmdt");
            ComBtnEnable("btn_history");
            ComBtnEnable("btn_attorney");
            ComBtnEnable("btn_msnbonded");
            ComBtnEnable("btn_bl_preview");
            ComBtnEnable("btn_edotransmit"); //ED/O Transmit
            ComBtnEnable("btn_edoinquiry");  //ED/O Transmit
            ComBtnEnable("btn_edoresult");   //ED/O Transmit
            
            

            chkRemark();
  
            // LCL O/BL Release 여부 체크
            if (sheetObj.CellValue(1,"blInfo_lcloblissueflg") == "Y") {
            	ComShowCodeMessage("BKG00667");
            }
           
            // 위임장  존재 여부 체크
            if (sheetObj.CellValue(1,"blInfo_attorney_val_chk") == "N") {           
            	ComShowCodeMessage("BKG43036");
            }           
            // 위임장  만료 여부 체크
            if (sheetObj.CellValue(1,"blInfo_attorney_val_chk") == "E") {
            	ComShowCodeMessage("BKG43037");
            }          
            
            if( sheetObj.CellValue(1,"blInfo_edo_rqst_no") !="" &&
                document.form.blInfo_mf_ref_no.value != "" ){          	
                
            	if( sheetObj.CellValue(1,"blInfo_edo_rqst_no") != ( document.form.blInfo_mf_ref_no.value 
            		                                              + document.form.blInfo_mf_seq_no.value)  ){
            		ComShowCodeMessage("BKG43044");           		
            	}
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
        }else{
            //에러발생시 시트를 초기화 시킨다.
            var resetSheetNames = new Array("blInfo", "doRlseSts", "demInfo", "demDtl", "totBlbAmt", "totVol");
            for(var idx = 0; idx < resetSheetNames.length; idx++){
                sheetObjects[resetSheetNames[idx]].RemoveAll();
            }
            display_init();
        }
    }

    /**
     * Korea D/O Release Reference 정보 조회 IBSheet를 조회하고 나서 처리할 사항
     */
    function refInfo_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                //ComCopyRowToForm(sheetObj, 1, form, "");

                //Hold 여부에 따라서 빨강 또는 회색으로 글씨 처리
                if(sheetObj.CellValue(1, "blInfo_do_hld_flg") =='N'){
                    document.getElementById("hold_flag").className = "input2";
                    //document.getElementById("hold_flag").value = 'Hold'; 2009-11-04 윤윤환 수석 India D/O와 동일하게 처리 (Hold 시에만 빨간색 글씨)
                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
                    document.getElementById("evnt_flag").value = 'H';

                    document.getElementById("hld").style.display="";
                    document.getElementById("uhld").style.display="none";

                }else if(sheetObj.CellValue(1, "blInfo_do_hld_flg") =='Y'){
                    document.getElementById("hold_flag").className = "input2_1";
                    document.getElementById("hold_flag").value = 'Hold';
                    //Hold Event에 대한 값 세팅 :CargoReleaseOrderBCImpl.java holdDo에서 Hold or Un-Hold 구분 값
                    document.getElementById("evnt_flag").value = 'R';

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
            }
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     * 한국세관 신고를 위한 B/L INFO 추출
     */
    function cstmsInfo_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                //ComCopyRowToForm(sheetObj, 1, form, "");
                //EDI ID 조회하기 위한 쿼리 조건 값
                document.getElementById("disc_loc_cd").value = sheetObj.CellValue(1, "blInfo_cstms_dchg_loc_wh_cd");
            }
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     */
     function blIss_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            /*
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");
            }
            */

            if (document.form.blInfo_bl_tp_cd.value == "") {
                document.form.blInfo_bl_tp_cd.value = "B";
            }

            //조회된 시점에 Original B/L회수여부가 Y값이면 파란색 N이면 빨간색으로 표시
            if( document.getElementById("blInfo_obl_rdem_flg").value =='Y'){
                document.getElementById("blInfo_obl_rdem_flg").style.color='blue';
            }else if(document.getElementById("blInfo_obl_rdem_flg").value =='N'){
                document.getElementById("blInfo_obl_rdem_flg").style.color='red';
            }

            //O/BL 회수  여부 Hidden 속성에 초기값을 세팅한다.
            document.getElementById("h_ori_obl_rdem_flg").value = document.getElementById("blInfo_obl_rdem_flg").value;
            document.getElementById("h_aft_obl_rdem_flg").value = document.getElementById("blInfo_obl_rdem_flg").value;

            //D/O EVENT에서 변경되기 전의 값 -->
            document.getElementById("pre_ctnt").value = document.getElementById("blInfo_obl_rdem_knt").value;

            obl_rdem_knt_change(sheetObj, document.getElementById("blInfo_obl_rdem_knt"))

            // BL이 Surrender이면 OB/L Received쪽  Remark조회 버튼을 enable 및 필드는 Y로 Setting, 아닐경우 button disable (add by mgpark)
            if (sheetObj.CellValue(1, "blInfo_bl_tp_cd") == "S") {
                document.getElementById("bl_surr_rmk_flg").value = "Y";
                document.getElementById("bl_surr_rmk_flg").className = "input2";
                document.getElementById("div_btn_bl_surr_flg").style.visibility="visible";
            } else {
                document.getElementById("bl_surr_rmk_flg").value = "";
                document.getElementById("bl_surr_rmk_flg").className = "noinput2";
                document.getElementById("div_btn_bl_surr_flg").style.visibility="hidden";
            }            
        }
        //O/BL Received 변경 전 값 설정
        document.getElementById("old_obl_rdem_knt").value = sheetObj.CellValue(1, "blInfo_obl_rdem_knt");

        //OBL Cancel 버튼 활성화
        //ComBtnEnable("btn_obl_cancel");
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     * 운임 결재 여부와 Outstanding Amounts 정보 추출
     */
    function otsRcvInfo_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                ComCopyRowToForm(sheetObj, 1, form, "");
                addSel(sheetObj);

                //2009-11-26 임진영 추가
                //조회된 시점에 Y값이면 파란색 N이면 빨간색으로 표시
                if( document.getElementById("blInfo_tot_ots_sts_cd").value =='Y'){
                    document.getElementById("blInfo_tot_ots_sts_cd").style.color='blue';
                }else if(document.getElementById("blInfo_tot_ots_sts_cd").value =='N'){
                    document.getElementById("blInfo_tot_ots_sts_cd").style.color='red';
                }
            }
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
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
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     */
    function totBlbAmt_OnSearchEnd(sheetObj, ErrMsg){

        var sel = document.form.tot_bil_amt;

        //SELECT BOX 초기화
        for (i=sel.length-1; i>=0; i--){
            sel.options[i] = null
        }

        var currCd = "";
        var bilAmt = "";
        var demSts = false; //안진응 추가
        if (sheetObj.RowCount > 0) {        //안진응 추가
            for (j=0; j<sheetObj.RowCount; j++){
                currCd  = sheetObj.CellValue(parseInt(j+1), "totBlbAmt_"+"curr_cd");
                bilAmt  = sheetObj.CellValue(parseInt(j+1), "totBlbAmt_"+"tot_bil_amt");

                //2010-01-07 SC에서 로직 추가
                //if(document.getElementById("invTotBilAmt").value >0){
                //    bilAmt= parseInt(bilAmt) - parseInt(document.getElementById("invTotBilAmt").value);
                //}

                //안진응 추가
                if (parseInt(bilAmt) > 0) {
                    demSts = true;
                }

                document.form['tot_bil_amt'][j] = new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
            }

            //안진응 추가
            if (demSts == true) {
                document.getElementById("demur_sts").value = "N";
                document.getElementById("demur_sts").style.color='red';
                
                document.getElementById("tot_bil_amt").className = "input2_1";

            } else {
                document.getElementById("demur_sts").value = "Y";
                document.getElementById("demur_sts").style.color='blue';
                
                document.getElementById("tot_bil_amt").className = "input2";
            }
        } else {    //안진응 추가
            document.getElementById("demur_sts").value = "Y";
            document.getElementById("demur_sts").style.color='blue';
            document.form['tot_bil_amt'][0] = new Option('0');
            document.getElementById("tot_bil_amt").className = "input2";
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
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
                    if(sheetObj.CellValue(idx, "doRlseSts_rlse_sts_cd") == 'A'){
                        //Cancel 버튼 활성화
                        ComBtnDisable("btn_cancel");
                        //Release 버튼 활성화
                        ComBtnEnable("btn_release");
                        //ComBtnEnable("btn_hold");
                        ComBtnEnable("btn_remark");
                        ComBtnEnable("btn_receiverinfo");
                        ComBtnEnable("btn_obl_cancel");
                    }else if(sheetObj.CellValue(idx, "doRlseSts_rlse_sts_cd") == 'R'){

                        //Cancel 버튼 활성화
                        ComBtnEnable("btn_cancel");
                        ComBtnDisable("btn_release");
                        //ComBtnDisable("btn_hold");
                        ComBtnEnable("btn_remark");
                        ComBtnEnable("btn_preview");
                        ComBtnDisable("btn_obl_cancel");

                        if(sheetObj.CellValue(idx, "doRlseSts_self_trns_flg") == 'Y'){
                            document.getElementById("selfTransToTMN").checked = true;
                            ComBtnDisable("btn_edisend");
                            ComBtnEnable("btn_stcancel");
                        }else{
                            document.getElementById("selfTransToTMN").checked = false;
                            ComBtnEnable("btn_edisend");
                            ComBtnDisable("btn_stcancel");
                        }
                    //조회 결과가 Cancel만 존재 할때
                    }else if(sheetObj.CellValue(idx, "doRlseSts_rlse_sts_cd") == 'C'){

                        ComBtnDisable("btn_edisend");
                        ComBtnDisable("btn_stcancel");
                        ComBtnEnable("btn_release");
                        ComBtnEnable("btn_assign");
                        ComBtnEnable("btn_obl_cancel");
                    }
                }

                //히든 값에  D/O 번호를 세팅한다.
                document.getElementById("h_do_no").value = sheetObj.CellValue(1, "doRlseSts_do_no");
                document.getElementById("h_do_no_split").value = sheetObj.CellValue(1, "doRlseSts_do_no_split");

                ComBtnEnable("btn_history");

                //조회 결과가 Cancel만 존재 할때
                /*
                if(sheetObj.RowCount == 1 && sheetObj.CellValue(1, "doRlseSts_rlse_sts_cd") == 'C'){
                    ComBtnEnable("btn_assign");
                    ComBtnEnable("btn_release");
                    ComBtnDisable("btn_cancel");
                    ComBtnDisable("btn_hold");
                }
                */
                //High-Light 맨아래 표시
                sheetObj.SelectCell(sheetObj.RowCount,0)
            }else{
                ComBtnEnable("btn_assign");
                ComBtnEnable("btn_release");
            }
        }
    }
    
    function totVol_OnSearchEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {
    		if (sheetObj.RowCount > 0) {
    			var totalVol;
    			var prefix = "totVol_";
    			for(i = 1; i < sheetObj.Rows; i++) {
	    			if(i > 1) {
	    					totalVol = totalVol + "," + sheetObj.CellValue(i, prefix + "cntr_tpsz_cd") + "X" + sheetObj.CellValue(i, prefix + "op_cntr_qty");
	    			} else {
	    					totalVol = sheetObj.CellValue(i, prefix + "cntr_tpsz_cd") + "X" + sheetObj.CellValue(i, prefix + "op_cntr_qty");
	    			}
    			}
    			ComSetObjValue(document.form.total_vol, totalVol);    		
    		}
    	}
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     */
    function ktNet_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            var checkCnt = 0;
            if(sheetObj.RowCount > 0){
            	
            	if (sheetObj.CellValue(1, "blInfo_err_flg")=='Y') { //빨강색
            		document.getElementById("btn_edoresult").style.color='rgb(255,0,0)';
            	}else {
            		document.getElementById("btn_edoresult").style.color='';
            	}          	


                if (sheetObj.CellValue(1, "blInfo_do_issue")=='5JN') {
                    document.getElementsByName("edo_rqst_sts")[0].checked = true;
                    checkCnt ++;
                }
                if (sheetObj.CellValue(1, "blInfo_self_transportation")=='5JM') {
                    document.getElementsByName("edo_rqst_sts")[1].checked = true;
                    checkCnt ++;
                }
                if (sheetObj.CellValue(1, "blInfo_bonded_transportation")=='5JK') {
                    document.getElementsByName("edo_rqst_sts")[2].checked = true;
                    checkCnt ++;
                }

                if (sheetObj.CellValue(1, "blInfo_do_edo_ack_cd")=='A') {
                    //파랑색
                    document.getElementById("btn_do").style.color='rgb(0,0,255)';
                }else if (sheetObj.CellValue(1, "blInfo_do_edo_ack_cd")=='R') {
                    //빨강색
                    document.getElementById("btn_do").style.color='rgb(255,0,0)';
                }else if (sheetObj.CellValue(1, "blInfo_do_edo_ack_cd")=='P') {
                    //연두색
                    document.getElementById("btn_do").style.color='rgb(128,255,0)';
                }else{
                	document.getElementById("btn_do").style.color='';
                }

                //@ 2015.09.02 주 한진에서 자가운송 edi가 수신 되었으면 파란색으로 버튼 변경 
                if (sheetObj.CellValue(1, "blInfo_self_edo_ack_cd")=='A' || sheetObj.CellValue(1,"blInfo_cntr_self_trsp_flag") == 'Y') {
                    //파랑색
                    document.getElementById("btn_self").style.color='rgb(0,0,255)';
                }else if (sheetObj.CellValue(1, "blInfo_self_edo_ack_cd")=='R') {
                    //빨강색
                    document.getElementById("btn_self").style.color='rgb(255,0,0)';
                }else if (sheetObj.CellValue(1, "blInfo_self_edo_ack_cd")=='P') {
                    //연두색
                    document.getElementById("btn_self").style.color='rgb(128,255,0)';
                }else{
                	document.getElementById("btn_self").style.color='';
                }
                
                
                if (sheetObj.CellValue(1, "blInfo_self_edo_ack_cd")=='A') {
                    //파랑색
                    document.getElementById("btn_self").style.color='rgb(0,0,255)';
                }
                

                if (sheetObj.CellValue(1, "blInfo_bonded_edo_ack_cd")=='A') {
                    //파랑색
                    document.getElementById("btn_bonded").style.color='rgb(0,0,255)';
                }else if (sheetObj.CellValue(1, "blInfo_bonded_edo_ack_cd")=='R') {
                    //빨강색
                    document.getElementById("btn_bonded").style.color='rgb(255,0,0)';
                }else if (sheetObj.CellValue(1, "blInfo_bonded_edo_ack_cd")=='P') {
                    //연두색
                    document.getElementById("btn_bonded").style.color='rgb(128,255,0)';
                }else{
                	document.getElementById("btn_bonded").style.color='';
                }
            }

            if(checkCnt > 0){
                //ComBtnEnable("btn_edotransmit"); //ED/O Transmit
                //ComBtnEnable("btn_edoinquiry");  //ED/O Transmit
                //ComBtnEnable("btn_edoresult");   //ED/O Transmit
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
     * Grid의 OnClick 이벤트가 발생하면 처리 할 사항 : 클릭 된 컨테이너 번호에 해당하는 INVOICE 정보를 보여준다.
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

    //5줄 이상 입력이 안되도록 막음(안진응)
    function fncTextareaMaxLine(obj){
        var str_line = obj;
        line = str_line.split("\r\n");
        ln = line.length;

        if(ln == 5 && event.keyCode == 13){
            event.returnValue = false;
        }
    }

    /**
     * CCT,Third Office(CCT)  팝업용 조회 처리 <br>
     */
    function blOutstandingAmountPopOpen(flag){

//        if (sheetObjects["blInfo"].RowCount == 0) {
//            alert("Outstanding Amount 값이 존재하지 않습니다.")
//            return;
//        }

        var maxRow = sheetObjects["blInfo"].LastRow;
        var cellValue = "";
        var prefix = "blInfo_";

        var curr_cd = "";
        var ots_amt = 0;

        var strXmlBody = "";
        var xmlCnt = 0;

        for(i=1;i <= maxRow ; i++){

            //전송상태에 따라 글자색 설정
            for(var q=1;q<6;q++){
                if (flag == true) { // CCT를 선택한 경우
                    if (sheetObjects["blInfo"].CellValue(i, prefix + "cct_ots_amt" + q) > 0) {
                        curr_cd = sheetObjects["blInfo"].CellValue(i, prefix + "cct_ots_curr_cd" + q);
                        ots_amt = sheetObjects["blInfo"].CellValue(i, prefix + "cct_ots_amt" + q);

                        strXmlBody = strXmlBody + "<TR><![CDATA[" + curr_cd + "☜☞☜☞" + ots_amt + "☜☞]]></TR>";

                        xmlCnt = parseInt(xmlCnt) + 1;
                    }
                } else {            // Third Office(CCT)를
                    if (sheetObjects["blInfo"].CellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
                        curr_cd = sheetObjects["blInfo"].CellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
                        ots_amt = sheetObjects["blInfo"].CellValue(i, prefix + "n3pty_cct_ots_amt" + q);

                        strXmlBody = strXmlBody + " <TR><![CDATA[" + curr_cd + "☜☞☜☞" + ots_amt + "☜☞]]></TR>";

                        xmlCnt = parseInt(xmlCnt) + 1;
                    }
                }
            }
        }

        if (parseInt(xmlCnt) > 0) {
            var sXml = "";
            sXml = "<SHEET> ";
            sXml = sXml + "<DATA COLORDER='otsRcvPop_curr_cd|otsRcvPop_ibflag|otsRcvPop_tot_ots_amt|otsRcvPop_pagerows|' COLSEPARATOR='☜☞' TOTAL='" + xmlCnt + "'>"
            sXml = sXml + strXmlBody;
            sXml = sXml + "</DATA> </SHEET>";

//            var sXml = IBS_GetDataSearchXml(sheetObjects["otsRcvPop"]);
            document.form.oaXmlData.value = sXml;
            ComOpenPopup("/hanjin/ESM_BKG_1022.do", 400, 320, "", "1,0", true);
       }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     */
    function demInfo_OnSearchEnd(sheetObj){
        //Wait Image Show Hidden
        ComOpenWait(false);

        ComBtnEnable("btn_dem_retrieve"); //DMDT
        ComBtnEnable("btn_dmdt");         //RCV Cancel
    }

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

    function preview() {

        if(document.getElementById("evnt_flag").value == 'R'){
            //ComShowCodeMessage('BKG00649');
            ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no"), "Preview");
            return;
        }

        if(document.getElementById("mrd_id").value == ""){
            ComShowCodeMessage("BKG40080");
            return;
        }

        var formObject = document.form;
        var doNo  = sheetObjects["doRlseSts"].CellValue(1, "doRlseSts_do_no");
        var bkgNo = sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no");

        formObject.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/" + formObject.mrd_id.value + ".mrd";
        formObject.com_mrdArguments.value = "/rv form_doNo['"+doNo+"'] form_bkgNo['"+bkgNo+"'] form_usrId['"+strUsr_id+"']  form_mainOnly[N] form_ofcCd['" + lginOfcCd + "'] " + formObject.mrd_param.value; // *.mrd에 맞게 파라메터 변경
        formObject.com_mrdBodyTitle.value = "DELIVERY ORDER";
        //alert(formObject.com_mrdPath.value  + "\n\n" + formObject.com_mrdArguments.value);
//        ComOpenRDPopup("width=1024, height=768");
//        ComOpenRDPopupModal("dialogWidth:1024px;dialogHeight:768px");
        ComOpenRDPopupModal();
    }

    function print() {

        if(document.getElementById("evnt_flag").value == 'R'){
            //ComShowCodeMessage('BKG00649');
            ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].CellValue(1, "blInfo_bl_no"), "Print");
            return;
        }

        if(document.getElementById("mrd_id").value == ""){
            ComShowCodeMessage("BKG40080");
            return;
        }

        var formObject = document.form;
        var doNo  = sheetObjects["doRlseSts"].CellValue(1, "doRlseSts_do_no");
        var bkgNo = sheetObjects["blInfo"].CellValue(1, "blInfo_bkg_no")

        var Rdviewer = rdObjects[0];
        // /rp [" + param + "] /riprnmargin /rprncenteropt [1] /rwait -- 파라메터 순서
        //var rdParam = "/rp [" + param + "] /riprnmargin /rwait";
        var rdParam = "/rv form_doNo['"+doNo+"']  form_bkgNo['"+bkgNo+"'] form_usrId['"+strUsr_id+"']  form_mainOnly[N] form_ofcCd['" + lginOfcCd + "'] " + formObject.mrd_param.value; // *.mrd에 맞게 파라메터 변경

        // 열고자 하는 RD 파일을 지정한다.
        var strPath = RD_path+"apps/alps/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/" + formObject.mrd_id.value + ".mrd"; // *.mrd 확인요망
        //alert(rdParam + "\n\n" + strPath);
        Rdviewer.FileOpen(strPath, RDServer + rdParam);
        Rdviewer.CMPrint();
    }

    /**
    * Hold/Internal Remarks 항목에 값이 존재하면 버튼을 Enable 처리하고 버튼색을 빨간색으로 표시한다.
    */
   function chkRemark() {
	   if (document.form.blInfo_inter_rmk.value.length > 0 ) {
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

//       if (color == 'red') {
//   	    curFlag = "hand";
//       } else {
//   	    curFlag = "default";
//       }

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
	   document.form.blInfo_inter_rmk.value = remark;

	   chkRemark();
   }

    /* 개발자 작업  끝 */