/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0737.js
*@FileTitle      : eDO Transmit
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-07-17
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009-07-17 임진영
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.02.27 김보배 [CHM-201216327] [BKG] 수입 냉동화물에 대한 자가운송 규제관련(D/O, 자가운송 승인전 팝업요청)
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
     * @class esm_bkg_0737 : esm_bkg_0737 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0737() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

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
                case "btn_submit":
                    checkBoxDataSet();
                    if (document.form.rdo_5JM[1].checked){
                    	doActionIBSheet(sheetObject1,document.form,SEARCH01);
                    } else {
                    	doActionIBSheet(sheetObject1,document.form,MULTI01);
                    }
                    break;
                case "btn_close":
                    window.close();
                break;

            } // end switch
        } catch(e) {
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
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        //페이지 로딩 시 기본 설정
        var edoRqstStsArray = new Array();
        var arrParam = document.getElementById("h_approvals").value.substring(0,document.getElementById("h_approvals").value.lastIndexOf(";"));
        edoRqstStsArray = arrParam.split(";");

        //5JM - 자가요청
        //5JK - 보세운송동의
        //5JN - D/O 발급

        if(edoRqstStsArray[0] == 'T'){

            document.getElementsByName("rdo_5JN")[0].checked = true;

            for(var idx=0; idx < document.getElementsByName("rdo_5JN").length; idx++){
                document.getElementsByName("rdo_5JN")[idx].disabled = false;
            }
        }

        if(edoRqstStsArray[1] == 'T'){

            document.getElementsByName("rdo_5JM")[0].checked = true;


            for(var idx=0; idx < document.getElementsByName("rdo_5JM").length; idx++){
                document.getElementsByName("rdo_5JM")[idx].disabled = false;
            }
        }

        if(edoRqstStsArray[2] == 'T'){

            document.getElementsByName("rdo_5JK")[0].checked = true;

            for(var idx=0; idx < document.getElementsByName("rdo_5JK").length; idx++){
                document.getElementsByName("rdo_5JK")[idx].disabled = false;
            }
        }

        var edoTpCds = new Array("5JN","5JM","5JK");

        for(var idx =1; idx <4; idx++ ){
            var j = sheetObjects[0].DataInsert(-1);
            sheetObjects[0].CellValue(j, "edo_tp_cd")  = edoTpCds[idx-1];
            sheetObjects[0].CellValue(j, "edo_ack_cd") = 'N';
            sheetObjects[0].CellValue(j, "rqst_no")    = document.getElementById("rqst_no").value;
            sheetObjects[0].CellValue(j, "bkg_no")     = document.getElementById("bkg_no").value;
        }
    }

    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case 'sheet1':      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    //style.height = 82;
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = " |edo_tp_cd|edo_ack_cd|rej_rmk|rqst_no|bkg_no";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    //헤더속성    [SortEnable, ColumnMove, AllCheckEnable, AllCheckEnable, UserResize, RowMove, Head3D]
                    InitHeadMode(false, false, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,   COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC,        DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus ,30,     daCenter,   false,       "ibflag");
                    InitDataProperty(0, cnt++ , dtData,         160,    daCenter,    true,       "edo_tp_cd",   false,      "",       dfNone,   0,     false,    false);
                    InitDataProperty(0, cnt++ , dtData,         0,      daCenter,    true,       "edo_ack_cd",  false,      "",       dfNone,   0,     false,    false);
                    InitDataProperty(0, cnt++ , dtData,         0,      daCenter,    true,       "rej_rmk",     false,      "",       dfNone,   0,     false,    false);
                    InitDataProperty(0, cnt++ , dtData,         0,      daCenter,    true,       "rqst_no",     false,      "",       dfNone,   0,     false,    false);
                    InitDataProperty(0, cnt++ , dtData,         0,      daCenter,    true,       "bkg_no",      false,      "",       dfNone,   0,     false,    false);

                    CountPosition = 0;
                }
            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case MULTI01:

                //MRN NO , MSN NO 체크
                if(document.getElementById("mrn_no").value =='' || document.getElementById("msn_no").value ==''){
                    ComShowCodeMessage("BKG40093");
                    //Unable to Send without MRN, MSN No.
                    return;
                }

                if(document.getElementById("h_last_rlse_sts_cd").value !='R' && document.getElementsByName("rdo_5JN")[1].checked){
                    ComShowCodeMessage("BKG40081");
                    return;
                }
                // DEL이 POD와 동일하지 않은 DOOR 조건의 경우 자가운송 승인내려고 할 경우 
                if(document.form.de_term_desc.value =='Door' && 
                   document.form.pod_cd.value != document.form.del_cd.value && 
                   document.form.rdo_5JM[1].checked ){   
                	 if(!ComShowCodeConfirm('BKG43033')){
                         return false;
                     }
                }
                
                var cnt =0;
  
                for(var idx=1; idx <= sheetObjects[0].RowCount; idx++){
                    if(sheetObjects[0].CellValue(idx, "edo_ack_cd") == 'N'){
                        cnt ++;
                    }
                }

                if(cnt == 3){
                    ComShowCodeMessage("BKG40082");
                    return;
                }

                if(document.form.self_trans_chk_flg.value == 'Y'){
                	dialogArguments.pressSelfTransToTMNL('ES');
                }

                if( !ComShowCodeConfirm('BKG00447') ){
                    return false;
                }

                formObj.f_cmd.value = MULTI01;
              
                sheetObj.DoSave("ESM_BKG_0737GS.do", FormQueryString(formObj),'', false);
            break;
            
            
            case SEARCH01:

            	formObj.f_cmd.value = SEARCH01;
        		var sXml = sheetObj.GetSearchXml("ESM_BKG_0737GS.do", FormQueryString(formObj));

        		var rcFlg	= ComGetEtcData(sXml,"rc_flg");
            	var cntCd	= ComGetEtcData(sXml,"cnt_nm");
				var contiNm	= ComGetEtcData(sXml,"conti_nm");

            	var confirmFlag = false;

            	if(rcFlg == 'Y'){
            		// "POR이 {?msg1} ({?msg2}) 이고 냉동화물은 자가운송이 제한되어 있습니다. 그래도 진행하시겠습니까?"
            		confirmFlag = ComShowCodeConfirm('BKG95050', cntCd, contiNm );
            		if(confirmFlag == true) {
                    	doActionIBSheet(sheetObj,document.form,MULTI01);
                    }
                } else {
                	doActionIBSheet(sheetObj,document.form,MULTI01);
                }
            	
				
            break;
        }
    }

   /**
    * 라디오버튼 클릭 시
    */
    function TransmitDataSet(edoAckCd){

        switch(event.srcElement.name){
            case 'rdo_5JN' :
                idx = 1;
                break ;
            case 'rdo_5JM' :
                idx = 2;
                break ;
            case 'rdo_5JK' :
                idx = 3;
                break ;
            default :
                break ;
        }//end switch

        if( edoAckCd =='R' || edoAckCd =='P' ){  // 기각및 보류시
            document.all.rej_rmk[idx-1].readOnly  = false
            document.all.rej_rmk[idx-1].className = "input";
        }else{
            document.all.rej_rmk[idx-1].readOnly  = true
            document.all.rej_rmk[idx-1].className = "input2";
            document.all.rej_rmk[idx-1].value     = "";
            sheetObjects[0].CellValue(idx, "rej_rmk") = "";
        }
        
        if(idx==2 && edoAckCd =='A'){  // 자가운송 승인시
            //부모창의 Self Trans To TMNL 체크박스를 체크한다.
            document.form.self_trans_chk_flg.value = 'Y';
        }        
        
        sheetObjects[0].CellValue(idx, "edo_ack_cd") = edoAckCd
        sheetObjects[0].CellValue(idx, "rej_rmk")    = document.getElementsByName("rej_rmk")[parseInt(idx-1)].value;
    }

    /**
     * 입력창에 입력된 보류 내용을 시트에 세팅한다.
     */
    function rejRmkDataSet(idx){
        sheetObjects[0].CellValue(idx, "rej_rmk") = document.getElementsByName("rej_rmk")[idx-1].value;
    }

    /**
     * eDO Transmit 결과를 히든 컬럼에 세팅한다. : 부모창으로 보 낼 값
     */
    function checkBoxDataSet(){
        var str = sheetObjects[0].CellValue(1, "edo_ack_cd")+','+sheetObjects[0].CellValue(2, "edo_ack_cd")+','+sheetObjects[0].CellValue(3, "edo_ack_cd");
        document.getElementById("edo_ack_cd_arr").value = str;
    }

    /**
     * sheet1를 저장하고 나서 처리할 사항 : 부모창에 eDO Transmit 결과를 리턴한다.
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
    	dialogArguments.edoCheckBoxColorSet(document.getElementById("edo_ack_cd_arr").value);
        self.close();
    }  

    /**
     * 입력된 보류 내용의 바이트 수를 체크한다.
     */
    /*
    function rejRmkNmByteCheck(sheetObj) {

        for(var idx=0; idx < document.getElementsByName("rej_rmk").length; idx++){
            //보류내용이 존재 하면 바이트 체크
            if(document.getElementsByName("rej_rmk")[idx].value !=''){
                if( ComChkLenByByte(document.getElementsByName("rej_rmk")[idx].value),1000) == 0){
                    ComShowCodeMessage("BKG40006");
                    document.getElementsByName("rej_rmk")[idx].focus();
                    return false;
                    break;
                }
            }
        }
        return true;
    }
    */
    /* 개발자 작업  끝 */
