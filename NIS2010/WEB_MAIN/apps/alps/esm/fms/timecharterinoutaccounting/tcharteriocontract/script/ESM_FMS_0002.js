/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0002.js
*@FileTitle : Agreement Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 전상화
*@LastVersion : 1.2
* 2009.04.27 정윤태
* 1.0 최초 생성
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* History
* 2011.04.26 표준희 [CHM-201110435-01] 탭 (CP File up, Certi File up) Updae 날자 조회되게 처리
* 2012.06.12 전상화 [CHM-201218110-01] CP Period 단위 1)수정 GMT -> UTC, 2) LMT 삭제, 3)UTC로 고정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview Agreement Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @author 한진해운
     */

    /**
     * @extends FMS
     * @class Agreement Inquiry : Agreement Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0002() {
    	this.initControl        	= initControl;
        this.declaration_click		= declaration_click;
        this.validateForm       	= validateForm;
        this.eng_keypress			= eng_keypress;
        this.obj_deactivate			= obj_deactivate;
        this.obj_activate			= obj_activate;
        this.obj_keypress			= obj_keypress;
        this.clearAll				= clearAll;
        this.processButtonClick 	= processButtonClick;
        this.loadPage				= loadPage;
        this.vsl_cd_change			= vsl_cd_change;
        this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
        this.t7sheet1_OnSearchEnd   = t7sheet1_OnSearchEnd;
        this.t2sheet1_OnMouseMove	= t2sheet1_OnMouseMove;
        this.t5sheet1_OnMouseMove	= t5sheet1_OnMouseMove;
        this.t6sheet1_OnMouseMove	= t6sheet1_OnMouseMove;
        this.changeMousePointer		= changeMousePointer;
        this.setProgramNo			= setProgramNo;
        this.setVslCd				= setVslCd;
        this.setContractNo			= setContractNo;
    }

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    //2017.05.15 contract type 콤보로 변경
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var uploadObjects = new Array();
	var uploadCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
    	 var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         var sheetObject5 = sheetObjects[4];
         var sheetObject6 = sheetObjects[5];
         var sheetObject7 = sheetObjects[6];
		 var sheetObject8 = sheetObjects[7];
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_retrive":
					
					doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					
					break;

				case "btn_new":
					
					clearAll();
					
					break;
					
				case "btn_t5E-mail":
					
					var fileKey = checkAttachFile(sheetObject6, 'cpf_');
					
					if(fileKey == "") return;
					
					var vsl_eng_nm = formObject.vsl_eng_nm.value;
					var subject = "Charter Party ("+vsl_eng_nm+")";
					
					ComOpenPopup("ESM_FMS_0079.do?mailFlg=CON&subject="+subject+"&fileKey="+fileKey, 400, 456, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0079");
					break;
					
				case "btn_t6E-mail":
					var fileKey = checkAttachFile(sheetObject7, 'cef_');
					
					if(fileKey == "") return;
					
					var vsl_eng_nm = formObject.vsl_eng_nm.value;
					var subject = "Certificate ("+vsl_eng_nm+")";
					
					ComOpenPopup("ESM_FMS_0079.do?mailFlg=CON&subject="+subject+"&fileKey="+fileKey, 400, 456, "sendMail", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0079");
					break;

				case "btn_vslpop" :
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
					break;
					 
				case "contract_no":
					
					 /*
					 if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						 return;
					 }
					 */
					 
					 //ComOpenPopupWithTarget("ESM_FMS_0023.do?ctrtFlag=Y&vsl_cd=" + formObject.vsl_cd.value, 520, 385, "flet_ctrt_no:flet_ctrt_no", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
					
					 ComOpenPopup("ESM_FMS_0023.do?ctrtFlag=Y&vsl_cd=" + formObject.vsl_cd.value, 520, 405, "setContractNo", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
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

       sheetObjects[sheetCnt++] = sheet_obj;

    }
    
    //2017.05.15 contract type 콤보로 변경
    function setComboObject(combo_obj){          
    	comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            
        //마지막 컬럼을 전체 너비에 맞춘다.
            sheetObjects[i].ExtendLastCol = false;
        }
		
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();
        
        //2017.05.15 contract type 콤보로 변경
        doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
        	case "sheet1":      //sheet1 init
        		with (sheetObj) {
                	var prefix = "oli_";
                	
                	//AutoSizeMode=false;
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    //SheetWidth = mainTable.clientWidth;
                	SheetWidth = 665;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, false, false, false)

                    var HeadTitle = "Item Name|From Date|To Date|Cur|Amount";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    	[ROW, COL,  DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	   			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,      	134,   daLeft,    false,    prefix + "acct_itm_nm",		false,          "",      	dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "eff_dt",    		false,          "",      	dfDateYmd,   0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "exp_dt",     		false,          "",      	dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,    prefix + "curr_cd",     	false,          "",      	dfEngUpKey,  0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,    prefix + "otr_expn_amt",	false,          "",      	dfNullFloat, 2,     true,       true,	13);
					
					CountPosition = 0;
					FitColWidth("32|13|13|8|34");
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";

               }
                break;
            case "t1sheet1":      //t1sheet1 init
                with (sheetObj) {
                	var prefix = "hir_";
                	
                    // 높이 설정
                    style.height = 120;
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
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                    InitHeadMode(false, true, true, true, false, false)

                    //var HeadTitle = "|Seq|Sel|From Date|To Date|Cur 1|Daily Hire|Cur 2|Daily Hire|Cur 2 Apply|Ori From Date|Ori To Date ";
                    var HeadTitle = "|Seq|From Date|To Date|Cur 1|Daily Hire|Cur 2|Daily Hire|Ori From Date|Ori To Date ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,    prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,    		40,    daCenter,  true,    prefix + "Seq");
					InitDataProperty(0, cnt++ , dtData,      	187,   daCenter,  false,   prefix + "eff_dt",   		false,          "",      dfUserFormat2,     0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	187,   daCenter,  false,   prefix + "exp_dt",     		false,          "",      dfUserFormat2,     0,     true,       true);

					InitDataProperty(0, cnt++ , dtData,      	62,    daCenter,  false,   prefix + "hir_curr_n1st_cd", false,          "",      dfEngUpKey,      	0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtData,      	134,   daRight,   false,   prefix + "hir_rt_n1st_amt",  false,          "",      dfNullFloat,      	2,     true,       true,	13);
					InitDataProperty(0, cnt++ , dtData,      	62,    daCenter,  false,   prefix + "hir_curr_n2nd_cd", false,          "",      dfEngUpKey,      	0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtData,      	134,   daRight,   false,   prefix + "hir_rt_n2nd_amt",  false,          "",      dfNullFloat,      	2,     true,       true,	13);
					//InitDataProperty(0, cnt++ , dtCheckBox,     134,   daCenter,  false,   prefix + "Cur2Apply",     	false,          "",      dfNone,      		0,     true,       true, 	-1, 	false, 	false, "", 	false);
					
					//hidden으로 보관 Start
					InitDataProperty(0, cnt++ , dtHidden,      	187,   daCenter,  false,   prefix + "ori_eff_dt",   	false,          "",      dfUserFormat2,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	187,   daCenter,  false,   prefix + "ori_exp_dt",     	false,          "",      dfUserFormat2,     0,     true,       true);
					//hidden으로 보관 End
					
					InitUserFormat2(0, prefix + "eff_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "exp_dt", "####-##-## ##:##", "-|:" );
					
					InitUserFormat2(0, prefix + "ori_eff_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "ori_exp_dt", "####-##-## ##:##", "-|:" );
					
					InitDataValid(0, prefix + "hir_curr_n1st_cd", vtEngUpOnly); 
					InitDataValid(0, prefix + "hir_curr_n2nd_cd", vtEngUpOnly);
					
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";

               }
                break;

				case "t2sheet1":      //t2sheet1 init
                with (sheetObj) {
                	var prefix = "otr_";
                    // 높이 설정
                    style.height = 120;
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
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false, false)

                    var HeadTitle = "|Seq|Item Name|Account Code|From Date|To Date|Cur|Amount|Acct Itm Seq|Ori Account Code|Ori From Date|Ori To Date|Ori Acct Itm Seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    										  //134
                    //데이터속성    	[ROW, COL,  DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	   			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,    	prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    		40,    daCenter,  true,    	prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtData,      	252,   daLeft,    false,    prefix + "acct_itm_nm",		false,          "",      	dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,  false,    prefix + "acct_cd",			false,          "",      	dfNone,      0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	161,   daCenter,  false,    prefix + "eff_dt",    		false,          "",      	dfDateYmd,   0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	161,   daCenter,  false,    prefix + "exp_dt",     		false,          "",      	dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	62,    daCenter,  false,    prefix + "curr_cd",     	false,          "",      	dfEngUpKey,  0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtData,      	99,    daRight,   false,    prefix + "otr_expn_amt",	false,          "",      	dfNullFloat, 2,     true,       true,	13);
					InitDataProperty(0, cnt++ , dtHidden,      	134,   daCenter,  false,    prefix + "acct_itm_seq",	false,          "",      	dfNone,      0,     true,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,      	134,   daCenter,  false,    prefix + "ori_acct_cd",		false,          "",      	dfNone,      0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	161,   daCenter,  false,    prefix + "ori_eff_dt",  	false,          "",      	dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	161,   daCenter,  false,    prefix + "ori_exp_dt",  	false,          "",      	dfDateYmd,   0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	134,   daCenter,  false,    prefix + "ori_acct_itm_seq",false,          "",      	dfNone,      0,     true,       false);
					
					//DataLinkMouse(prefix + "acct_itm_nm") = true;
					InitDataValid(0, prefix + "curr_cd", vtEngUpOnly); 
					
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";
					
					ShowButtonImage = 1;
               }
                break;

				case "t3sheet1":      //t3sheet1 init
                with (sheetObj) {
                	
                	var prefix = "pay_";
                	
                    // 높이 설정
                    style.height = 120;
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
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false, false)

                    var HeadTitle = "|Seq|Payment Term|From Date|To Date|Ori_From Date|Ori_To Date ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  true,    prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    		40,    	daCenter,  true,    prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtData,      	419,    daCenter,  false,   prefix + "ctrt_pay_term_cd",    false,          "",      dfNone,      		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      	223,    daCenter,  false,   prefix + "eff_dt",     			false,          "",      dfUserFormat2,     0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	223,    daCenter,  false,   prefix + "exp_dt",     			false,          "",      dfUserFormat2,     0,     true,       true);	
					
					//hidden으로 보관 Start
					InitDataProperty(0, cnt++ , dtHidden,      	187,   daCenter,  false,   prefix + "ori_eff_dt",   		false,          "",      dfUserFormat2,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	187,   daCenter,  false,   prefix + "ori_exp_dt",     		false,          "",      dfUserFormat2,     0,     true,       true);
					//hidden으로 보관 End
					
					//InitDataCombo(0, prefix + "ctrt_pay_term_cd", "Semi Month|15 days|Month", "A|B|C", "Semi Month", "A");
					
					InitUserFormat2(0, prefix + "eff_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "exp_dt", "####-##-## ##:##", "-|:" );
					
					InitUserFormat2(0, prefix + "ori_eff_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "ori_exp_dt", "####-##-## ##:##", "-|:" );
					
					//날짜구분자를 설정한다.
					//DateFormatChar = "/";

               }
                break;

				case "t4sheet1":      //t4sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 120;	//60
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
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Period ( + - Option)|Redelivery Range|Redelivery Notice ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [	ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  	"ibflag");
                    InitDataProperty(0, cnt++ , dtData,      	317,    daLeft,  	false,     	"chtr_prd_opt_ctnt",    false,          "",      dfNone,      0,     	true,       true);
                    InitDataProperty(0, cnt++ , dtData,      	367,    daLeft,  	false,     	"rde_rng_ctnt",      	false,          "",      dfNone,      0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	277,    daLeft,  	false,     	"rde_ntc_ctnt",     	false,          "",      dfNone,      0,     	true,       true);

					ShowButtonImage = 1;
               }
                break;

				case "t5sheet1":      //t5sheet1 init
                with (sheetObj) {
                	var prefix = "cpf_";
                	
                    // 높이 설정
                    style.height = 120;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel|CP File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id|Update ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  true,	prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40,		daCenter,  false,   prefix + "DelChk");
                    InitDataProperty(0, cnt++ , dtData,      	320,    daLeft,    false,   prefix + "file_nm",     	false,          "",      dfNone,      0,     false,		true,	50);
                    InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,  false,   prefix + "eff_dt",    		false,          "",      dfDateYmd,   0,     false,     true);
					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,  false,   prefix + "exp_dt",     		false,          "",      dfDateYmd,   0,     false,     true);
                    InitDataProperty(0, cnt++ , dtData,      	320,    daLeft,    false,   prefix + "file_desc",   	false,          "",      dfNone,      0,     false,     true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_path",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,     	108,    daCenter,  false,   prefix + "flet_file_tp_cd", false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_seq",   		false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtImage,      	100,   	daCenter,  false,   prefix + "file_download",   false,          "",      dfNone,      0,     false,		true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_sav_id",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,     	108,    daCenter,  false,   prefix + "upd_dt",   	    false,          "",      dfNone,      0,     false,     false); 
                    //InitDataProperty(0, cnt++ , dtCheckBox,     108,    daCenter,  false,   prefix + "Check",     	false,          "",      dfNone,      0,     true,      true);
                    
                    ColHidden(prefix + "flet_file_tp_cd") = true;
                    InitDataCombo(0,prefix + "flet_file_tp_cd","CP","CP","CP");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";
                    
					ShowButtonImage = 1;
               }
                break;

				case "t6sheet1":      //t6sheet1 init
                with (sheetObj) {
                	var prefix = "cef_";
                	
                    // 높이 설정
                    style.height = 120;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel|Certi File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id|Update ";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,  true,	prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  false,   prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtData,      	320,    daLeft,    false,   prefix + "file_nm",     	false,          "",      dfNone,      0,     false,		true,	50);
					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,  false,   prefix + "eff_dt",    		false,          "",      dfDateYmd,   0,     false,     true);
					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,  false,   prefix + "exp_dt",     		false,          "",      dfDateYmd,   0,     false,     true);
                    InitDataProperty(0, cnt++ , dtData,      	320,    daLeft,    false,   prefix + "file_desc",   	false,          "",      dfNone,      0,     false,     true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_path",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtCombo,     	108,    daCenter,  false,   prefix + "flet_file_tp_cd", false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_seq",   		false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtImage,      	100,    daCenter,  false,   prefix + "file_download",   false,          "",      dfNone,      0,     false,		true);
                    InitDataProperty(0, cnt++ , dtHidden,     	108,    daCenter,  false,   prefix + "file_sav_id",   	false,          "",      dfNone,      0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,     	108,    daCenter,  false,   prefix + "upd_dt",   	    false,          "",      dfNone,      0,     false,     false);
                    //InitDataProperty(0, cnt++ , dtCheckBox,     108,    daCenter,  false,   prefix + "Check",     	false,          "",      dfNone,      0,     true,       true);
                    
                    ColHidden(prefix + "flet_file_tp_cd") = true;
                    InitDataCombo(0,prefix + "flet_file_tp_cd","CF","CF","CF");
                    
                    ImageList(0)= "/hanjin/img/ico_attach.gif";

                    
					ShowButtonImage = 1;
               }
                break;   
                 
				case "t7sheet1":      //t7sheet1 init
                with (sheetObj) {
                	
                	var prefix = "vsl_";
                    // 높이 설정
                    style.height = 120;
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
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Vessel Code|Vessel Name|Accounting|Report|Ori Vessel Code|Ori Vessel Name";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,    	 prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,         320,   daCenter,  false,     prefix + "vsl_cd",    	 	false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         400,   daCenter,  false,     prefix + "vsl_eng_nm",     false,          "",      dfNone,      0,     false,      false);
					InitDataProperty(0, cnt++ , dtCheckBox,  	80,    daCenter,  false,     prefix + "use_flg", 		false,          "",      dfNone,      0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,  	80,    daCenter,  false,     prefix + "flet_rpt_flg",	false,          "",      dfNone,      0,     true,       true);
					
					InitDataProperty(0, cnt++ , dtHidden,       400,   daCenter,  false,     prefix + "ori_vsl_cd",    	false,          "",      dfNone,      0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,       400,   daCenter,  false,     prefix + "ori_vsl_eng_nm", false,          "",      dfNone,      0,     false,      false);
					
					ShowButtonImage = 1;

               }
                break; 

        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,gubun,row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        
        case IBSEARCH:      //조회
        	
        	/*
        	if(formObj.vsl_cd.value == "") {
        		ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01138'));
	    		return;
        	}
        	*/
        	
        	if(formObj.flet_ctrt_no.value == "") {
        		ComAlertFocus(formObj.flet_ctrt_no, ComGetMsg('FMS01052'));
	    		return;
        	}
        	
        	//formObj.contract_no.style.cursor = "default";
			//document.images["contract_no"].name = "no_contract_no";
        	
        	formObj.f_cmd.value = SEARCH;
        	
        	var aryPrefix = new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");
 			
   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0002GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
   			//alert(sXml);
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);
			if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);	
			if (arrXml.length > 2) sheetObjects[3].LoadSearchXml(arrXml[2]);	
			if (arrXml.length > 3) sheetObjects[4].LoadSearchXml(arrXml[3]);
			if (arrXml.length > 4) sheetObjects[5].LoadSearchXml(arrXml[4]);
			if (arrXml.length > 5) sheetObjects[6].LoadSearchXml(arrXml[5]);
			if (arrXml.length > 6) sheetObjects[7].LoadSearchXml(arrXml[6]);
			if (arrXml.length > 7) sheetObjects[0].LoadSearchXml(arrXml[7]);
			
			//*********** CONTRACT 테이블의 정보 가져오기(START) ***************//
			if(typeof sheetObjects[1].EtcData("fletCtrtNo") != "undefined") {
				tabObjects[0].SelectedIndex = 0;
			}
			
			ComEtcDataToForm2(formObj,sheetObjects[1],"",true);
			
			if(typeof sheetObjects[1].EtcData("declFlg") != "undefined") {
				if(sheetObjects[1].EtcData("declFlg") == "Y") {
					formObj.decl_flg.checked = true;
				} else {
					formObj.decl_flg.checked = false;
				}
			}
			
			if(sheetObjects[1].EtcData("fletCtrtTpCd") == "T/C Out") {
				if(typeof sheetObjects[1].EtcData("custSeq") != "undefined") {
					formObj.cust_seq.value = sheetObjects[1].EtcData("custSeq");
				}
			} else {
				if(typeof sheetObjects[1].EtcData("vndrSeq") != "undefined") {
					formObj.cust_seq.value = sheetObjects[1].EtcData("vndrSeq");
					formObj.cust_cnt_cd.value = "";
				}
			}
			
			if( formObj.flet_gmt_lmt_cd.value == "G" || formObj.flet_gmt_lmt_cd.value =="GMT") {
				formObj.flet_gmt_lmt_cd.value = "UTC";
			} else {
				formObj.flet_gmt_lmt_cd.value = "LMT";
			}
			
		
			ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);
        	
           break;
           
		case IBROWSEARCH:      //조회
        	
			if(gubun == "Vessel") {
		    	if(formObj.vsl_cd.value == "") {
		    		formObj.vsl_eng_nm.value = "";
		    		return;
		    	}
		    	
		    	formObj.f_cmd.value = SEARCH01;
				
	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
	
	   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
	   			
	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
	   				formObj.vsl_eng_nm.value = vslEngNm;
	   				//formObj.vsl_cd.readOnly = true;
	   				//formObj.btn_vslpop.style.cursor = "default";
	   				//document.images["btn_vslpop"].name = "no_btn_vslpop";
	   				initDefaultContractNo();  //선박 대 계약 자동 매치
				} else {
					formObj.vsl_cd.value = "";
					formObj.vsl_eng_nm.value = "";
					ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
					return;
				}
			} else if(gubun == "ComCd") {		//2017.05.15 contract type 콤보로 변경
				
				sheetObj.WaitImageVisible = false;
				
				formObj.f_cmd.value = SEARCH04;
				
	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
	   			
	   			var fletCtrtTpCd   = ComGetEtcData(sXml, "fletCtrtTpCd");
	   			var fletCtrtTpNm   = ComGetEtcData(sXml, "fletCtrtTpNm");
	   			
	   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "") {
    				var comboCode = fletCtrtTpCd;
    				var comboText = fletCtrtTpNm;

    				setDataCombo(comboObjects[0], comboText, comboCode);
    			}
	   			
	   			sheetObj.WaitImageVisible = true;
	   			
			}
   			break;
   			
	  case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치		
			if(formObj.vsl_cd.value == "") return;	

			var f_query = "";					
			f_query += "f_cmd=" + SEARCH01; 
			f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
			f_query += "&type_flag="+gFletCtrtTpCdAll;  

			var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);
   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
   			var varFletCtrtTpCd = ComGetEtcData(sXml, "flet_ctrt_tp_cd");	//2017.05.15 contract type 콤보로 변경
   			
   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
				formObj.flet_ctrt_no.value = varFletCtrtNo;
				formObj.flet_ctrt_tp_cd.Code2 = varFletCtrtTpCd;	//2017.05.15 contract type 콤보로 변경
			}else{
				ComShowCodeMessage("FMS20001","Agreement");
				clearAll();
				return;
			}
			
			break;		
   			
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
                    InsertTab( cnt++ , "Hire" , -1 );
                    InsertTab( cnt++ , "Other Exp" , -1 );
                    InsertTab( cnt++ , "Payment Term" , -1 );
                    InsertTab( cnt++ , "Redelivery" , -1 );
                    InsertTab( cnt++ , "CP File up" , -1 );
                    InsertTab( cnt++ , "Certi File up" , -1 );
                    InsertTab( cnt++ , "Duplication" , -1 );

                }
                sheetObjects[4].DataInsert();
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {

        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction){

    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;

        return true;
    }

	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "/";
    	
        //Axon 이벤트 처리1. 이벤트catch
    	//2010.11.24 이상민 [CHM-201007233-01] : vsl_cd 는 engnum_keypress로 변경
    	axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); //- Vessel Code 입력 시 영문 대문자/숫자만 입력하기
        axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');		//Vessel Code 입력 후 Name정보 가져오기
    }
    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "shp_spd_qty": 
	    	case "vsl_dznd_capa": 
	    	case "bse_14ton_vsl_capa": 
	    	case "rf_cntr_plg_qty": 
	    	case "ddwt_cgo_capa_qty": 
	    	case "grs_wgt": 
	    	case "nrt_wgt":
	    	case "cust_seq":
	    		//숫자이면서 천단위 구분을 하지 않는다.
	    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    			ComChkObjValid(event.srcElement, true, false, false);
    			break;
    			/*
	    	case "vsl_cd":
	    	case "ori_eff_dt":
	    	case "ori_exp_dt":
	    	case "vsl_cnt_cd":
    			break;
    			*/
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        ComClearSeparator(event.srcElement);
    }
    
    /**
     * CustSeq변경 시 해당 Name 을 가져온다. <br>
     **/
    function cust_seq_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Owner');
    }
    
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {    	
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
    }
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- end
    
    /**
     * CheckBox선택시 값 설정. <br>
     **/
    function declaration_click() {
    	if(form.decl_flg.checked) {
    		form.decl_flg.value = 'Y';
    	} else {
    		form.decl_flg.value = 'N';
    	}
    }
	
    /**
     * Owner Code 변경 시 값 설정. <br>
     **/
	function setOwnerCode(val) {
		if(val == "TO") {
			form.cust_cnt_cd.readOnly = false;
		} else {
			form.cust_cnt_cd.readOnly = true;
			form.cust_cnt_cd.value = "";
		}
		
		form.cust_seq.value = "";
		form.vndr_lgl_eng_nm.value = "";
		form.ownr_nm.value = "";
		
	}
	
	/**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
	function clearAll() {
		ComResetAll();
		
		tabObjects[0].SelectedIndex = 0;
		
		form.vsl_cd.readOnly = false;
		form.btn_vslpop.style.cursor = "hand";
		document.images["btn_vslpop"].name = "btn_vslpop";
		
		form.contract_no.style.cursor = "hand";
		document.images["contract_no"].name = "contract_no";
		
		sheetObjects[5].CheckAll("cpf_DelChk") = 0;
		sheetObjects[6].CheckAll("cef_DelChk") = 0;
	}

	/**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "oli_";
    	 
		//width 비율로 조정
		sheetObj.FitColWidth("32|13|13|8|34");
		
		//2컬럼 글자색을 1컬럼 글자색으로 설정한다.
		sheetObj.ColFontColor(0) = sheetObj.WebColor("#532FC3");
		
		setInitCellProperty(sheetObj, prefix, "curr_cd", "otr_expn_amt", 4);
	}
     
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "hir_";
		
		setInitCellProperty(sheetObj, prefix);
	}
	
	/**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix = "otr_";
		
		setInitCellProperty(sheetObj, prefix, "curr_cd", "otr_expn_amt");
	}
     
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
  	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  		ComColFontName(sheetObj, "1"); 
  	}
     
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  prefix     	변수 구분자
     * @param {string}  curSaveName currency saveName
     * @param {string}  amtSaveName amt saveName
     **/
    function setInitCellProperty(sheetObj, prefix, curSaveName, amtSaveName, col) {
    	if(curSaveName == null || curSaveName == "") {
	    	for(var ir=1; ir<=sheetObj.LastRow; ir++) {
				if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + "hir_curr_n1st_cd"))) {
					
					sheetObj.InitCellProperty(ir, 5, dtNull, daRight, prefix+"hir_rt_n1st_amt", "", dfNullInteger);
				}
				
				if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + "hir_curr_n2nd_cd"))) {
					
					sheetObj.InitCellProperty(ir, 7, dtNull, daRight, prefix+"hir_rt_n2nd_amt", "", dfNullInteger);
				}
			}
	    	
    	} else {
    		for(var ir=1; ir<=sheetObj.LastRow; ir++) {
				if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, prefix + curSaveName))) {
					if(col == null || col == "") {
						sheetObj.InitCellProperty(ir, 7, dtNull, daRight, prefix+ amtSaveName, "", dfNullInteger);
					} else {
						sheetObj.InitCellProperty(ir, col, dtNull, daRight, prefix+ amtSaveName, "", dfNullInteger);
					}
				}
			}
    	}
    }
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function t5sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix = "cpf_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function t6sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix = "cef_";
		
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.RowStatus(Row)=="I")return;
		
		if(sheetObj.CellText(Row, prefix+"file_sav_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		return;
	}
	
	/**
     * 마우스 포인터 이동시 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	sheetObj의 선택된 Button
     * @param {ibsheet} Shift     	sheetObj의 선택된 Shift
     * @param {int} 	X     		X좌표값
     * @param {int} 	Y     		Y좌표값
     **/
	function t5sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeMousePointer(sheetObj,"cpf_");
	}
	
	/**
     * 마우스 포인터 이동시 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	sheetObj의 선택된 Button
     * @param {ibsheet} Shift     	sheetObj의 선택된 Shift
     * @param {int} 	X     		X좌표값
     * @param {int} 	Y     		Y좌표값
     **/
	function t6sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeMousePointer(sheetObj,"cef_");
	}
	
	/**
     * 마우스 포인터 이동시 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	sheetObj의 선택된 Button
     * @param {ibsheet} Shift     	sheetObj의 선택된 Shift
     * @param {int} 	X     		X좌표값
     * @param {int} 	Y     		Y좌표값
     **/
	function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeMousePointer(sheetObj,"otr_");
	}
	

	/**
     * 마우스 포인터 모양 변경하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	변수 구분값
     **/
	function changeMousePointer(sheetObj, prefix){
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		if (Row<sheetObj.HeaderRows || Col<0) return;
		
		var saveName=sheetObj.ColSaveName(Col);
		
		if(prefix == "otr_") {
			if (saveName!=prefix+"acct_itm_nm") return;
			
			var status = sheetObj.RowStatus(Row);
			
			if (saveName==prefix+"acct_itm_nm") {
				sheetObj.MousePointer = (status=="I")?"Hand":"Default";
			}
		} else {
			if (saveName!=prefix+"file_nm" && saveName!=prefix+"file_download") return;
			
			var status = sheetObj.RowStatus(Row);
			
			if (saveName==prefix+"file_nm") {
				sheetObj.MousePointer = (status=="I")?"Hand":"Default";
			} else if (saveName==prefix+"file_download") {
				sheetObj.MousePointer = (status=="I")?"Default":"Hand";
			}
		}
		
	}
	
	/**
	 * programNo 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		sheetObjects[2].CellValue2(row,col) = aryPopupData[0][2];
	    sheetObjects[2].Cellvalue2(row,"otr_acct_cd") = aryPopupData[0][3];
	    sheetObjects[2].Cellvalue2(row,"otr_acct_itm_seq") = aryPopupData[0][4];
	    
	    setOtrEffDt(row,"otr_");
	}
	
	/**
	 * Contract No 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value = aryPopupData[0][3];
		form.flet_ctrt_tp_cd.Code2 = aryPopupData[0][5];		//2017.05.15 contract type 콤보로 변경
		
		if(form.vsl_cd.value.length != 4) {
			form.vsl_cd.value = form.flet_ctrt_no.value.substring(0,4);
			//form.vsl_cd.readOnly = true;
			//form.btn_vslpop.style.cursor = "default";
			//document.images["btn_vslpop"].name = "no_btn_vslpop";
			
			vsl_cd_change();
		}
	}
	
	/**
	  * Vessel Code 입력부분.<br>
	  * @param {arry} aryPopupData
	  */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
		
		//form.vsl_cd.readOnly = true;
		//form.btn_vslpop.style.cursor = "default";
		//document.images["btn_vslpop"].name = "no_btn_vslpop";
		initDefaultContractNo(); //선박 대 계약 자동 매치
	}
	
	/**
     * 이메일로 발송될 첨부파일 FileSaveId를 가져온다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {String} fileKey     첨부파일 FileSaveId 값
     **/
	function checkAttachFile(sheetObj, prefix) {
		var fileKey = "";
		
		var sRow = sheetObj.FindCheckedRow(prefix + "DelChk");

		if (sRow == "") {
			ComShowMessage(ComGetMsg('COM12189'));
			//ComShowMessage(ComGetMsg('FMS01153'));
			return fileKey;
		} else {
			var arrRow = sRow.split("|");
			
			for (var idx=arrRow.length-2; idx>=0; idx--) {
				var row = arrRow[idx];
				
				if(sheetObj.CellValue(row,prefix + "file_sav_id") == "") {
					ComShowMessage(ComGetMsg('FMS01148', row));
					//ComShowMessage("파일이 저장되지 않았습니다\n\n[저장되지않은 ROW : "+row+"]");
					return "";
					break;
				}
				
				fileKey += sheetObj.CellValue(row,prefix + "file_sav_id")+";";
			}
		}

		fileKey = fileKey.substring(0,fileKey.length-1);

		return fileKey;
	}
	
	//선박 대 계약 자동 매치
    function initDefaultContractNo(){
    	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);  
      } 
    	  
//2017.05.15 contract type 콤보로 변경    
function setDataCombo(comboObj, comboText, comboCode) {
		
    switch(comboObj.id) {
        case "flet_ctrt_tp_cd":
        	
        	if(comboText != "" ) {
            	var comboTextList = comboText.split("|");
            	var comboCodeList = comboCode.split("|");
            	
            	for(var i=0; i < comboTextList.length-1; i++) {
            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i]);
            	}
            	
            	comboObj.Code = comboCodeList[0];
            	
            	comboObj.BackColor = "#CCFFFD";
        	}
            break;
            
    } 
}

//2017.05.15 contract type 콤보로 변경
function flet_ctrt_tp_cd_OnChange(idx_cd, text) {
	
	if(form.vsl_cd.value == "") return;	

	var f_query = "";					
	f_query += "f_cmd=" + SEARCH01; 
	f_query += "&vsl_cd="+form.vsl_cd.value;	 			
	f_query += "&type_flag="+text;  

	var sXml = sheetObjects[0].GetSearchXml("FMS_COMGS.do",f_query);
	var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
		
	if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
		form.flet_ctrt_no.value = varFletCtrtNo;
	}else{
		ComShowCodeMessage("FMS20001","Agreement");
		clearAll();
		return;
	}
		
}