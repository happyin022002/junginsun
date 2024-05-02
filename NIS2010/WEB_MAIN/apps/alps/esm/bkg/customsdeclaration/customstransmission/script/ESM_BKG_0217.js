/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0217.js
 *@FileTitle : B/L Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.25 이수빈
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
 * @class B/L Inquiry : B/L Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function esm_bkg_0217() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.setComboObject = setComboObject;
    this.validateForm = validateForm;
    this.sheet1_OnClick = sheet1_OnClick;
    this.sheet1_OnDblClick = sheet1_OnDblClick;
}

/* 개발자 작업    */

//공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[0]; // Tab1 : Container
    var sheetObject2 = sheetObjects[1]; // Tab2 : Customer
    var sheetObject3 = sheetObjects[2]; // Tab3 : Danger
/*******************************************************/
    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {

            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;

            case "btn_New":
                doActionIBSheet(sheetObject1,formObject,IBRESET);
                break;

            case "btn_Save":
                doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break;

            case "btn_Mark":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
                break;

            case "btn_Transmit":
				doActionIBSheet(sheetObject1,formObject,MULTI01);
                break;

            case "btn_Close":
                window.close();
                break;
                    
            case "btn_RowAdd":
				doActionIBSheet(sheetObject1,formObject,IBINSERT);
                break;

            case "btn_RowAdd_3":
				doActionIBSheet(sheetObject3,formObject,IBINSERT);
                break;
                    
            case "btn_RowDel":
				doActionIBSheet(sheetObject1,formObject,IBDELETE);
                break;

            case "btn_RowDel_3":
				doActionIBSheet(sheetObject3,formObject,IBDELETE);
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

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj; 
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
                InsertTab( cnt++ , "Container Info." , -1 );
                InsertTab( cnt++ , "Customer Info." , -1 );
                InsertTab( cnt++ , "Danger Info." , -1 );
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

    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";

    //--------------- 요기가 중요 --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//
    beforetab= nItem;
}

/**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "trsp_mod_id":
            var i=0;
            with(comboObj) {
            	ColBackColor(0) = "#FFFFFF";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
        case "seal_pty_tp_cd":
            with(comboObj) {
            	ColBackColor(0) = "#CCFFFD";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
        case "wgt_ut_cd":
            var i=0;
            with(comboObj) {
            	ColBackColor(0) = "#FFFFFF";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
        case "meas_ut_cd":
            var i=0;
            with(comboObj) {
            	ColBackColor(0) = "#FFFFFF";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
        case "msg_type":
            var i=0;
            with(comboObj) {
            	ColBackColor(0) = "#CCFFFD";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
    }
}



/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
        
    for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
        
        sheetObjects[i].WaitImageVisible = false;
    }
    
	for(i = 0; i < comboObjects.length; i++ ) {
		initCombo(comboObjects[i], i+1);
	}

	//화면에서 필요한 이벤트    	
	axon_event.addListenerForm("FocusIn","obj_FocusIn", document.form);
	axon_event.addListenerForm("FocusOut","obj_FocusOut", document.form);
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	// 콤보 데이터 생성
	SetComboData(document.form.code_list.value);

    if(document.form.bl_no.value != ""){
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }else{
    	SetButtonStatus();	// Button Disabled
    	document.form.bl_no.focus();
    }
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

        case "t1sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 262;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 2, 100);

                var HeadTitle1 = "|Sel.|Seq.|trans_mode|bl_no|Container No.|Tp.|full_mty_cd|Seal No.|Seal Kind|Sealer|Sealer|Weight|Weight|Measure|Measure|pck|pck|Over Front / Back / Height / Left / Right|Over Front / Back / Height / Left / Right|Over Front / Back / Height / Left / Right|Over Front / Back / Height / Left / Right|Over Front / Back / Height / Left / Right";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
               

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    30,    daCenter,	false,    "ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,        40,    daCenter, true,  	  "Chk"); 
				InitDataProperty(0, cnt++ , dtDataSeq,         30,    daCenter, true,  	  "Seq");      
                InitDataProperty(0, cnt++ , dtHidden,    	   70,    daCenter,	true,     "chn_mf_snd_ind_cd",	false,	"",  dfNone,    	0,true,true);
                InitDataProperty(0, cnt++ , dtHidden,    	   70,    daCenter,	true,     "bl_no",				false,	"",  dfNone,    	0,true,true);  
                InitDataProperty(0, cnt++ , dtData,            100,   daCenter,	false,    "cntr_no",			true,	"",  dfEngUpKey,	0,true,true,	14);
                InitDataProperty(0, cnt++ , dtData,            40,    daCenter,	true,     "cntr_tpsz_cd",		false,	"",  dfNone,		0,false,false);
                InitDataProperty(0, cnt++ , dtHidden,      	   100,   daCenter,	true,     "full_mty_cd",		false,	"",  dfNone,		0,true,true);
                InitDataProperty(0, cnt++ , dtData,            90,    daCenter,	true,     "seal_no",			false,	"",  dfEngUpKey,	0,true,true,	20);
                InitDataProperty(0, cnt++ , dtCombo,           95,    daLeft,	true,     "seal_knd_cd",		false,	"",  dfNone,		0,true,true);
                InitDataProperty(0, cnt++ , dtCombo,           105,   daLeft,	true,     "seal_pty_tp_cd",		false,	"",  dfNone,		0,true,true);
                InitDataProperty(0, cnt++ , dtHidden,      	   100,   daLeft,	true,     "seal_pty_nm",		false,	"",  dfNone,		0,true,true);
                InitDataProperty(0, cnt++ , dtData,            135,   daRight,	true,     "cntr_wgt",			false,	"",  dfNullFloat,	3,true,true,	18);
                InitDataProperty(0, cnt++ , dtCombo,           45,    daCenter,	true,     "wgt_ut_cd",			false,	"",  dfNone,		0,true,true);
                InitDataProperty(0, cnt++ , dtData,            95,    daRight,	true,     "cntr_meas_qty",		false,	"",  dfNullFloat,	3,true,true,	12);
                InitDataProperty(0, cnt++ , dtCombo,           45,    daCenter,	true,     "meas_ut_cd",			false,	"",  dfNone,		0,true,true);
                InitDataProperty(0, cnt++ , dtHidden,      	   100,   daCenter,	true,     "pck_qty",			false,	"",  dfNone,		0,true,true);
                InitDataProperty(0, cnt++ , dtHidden,      	   100,   daCenter,	true,     "pck_tp_cd",			false,	"",  dfNone,		0,true,true);
                InitDataProperty(0, cnt++ , dtData,            40,    daCenter,	true,     "ovr_dim_fnt_len",	false,	"",  dfFloat,		1,true,true,	6);
                InitDataProperty(0, cnt++ , dtData,            40,    daCenter,	true,     "ovr_dim_rear_len",	false,	"",  dfFloat,		1,true,true,	6);
                InitDataProperty(0, cnt++ , dtData,            65,    daCenter,	true,     "ovr_hgt",			false,	"",  dfFloat,		1,true,true,	6);
                InitDataProperty(0, cnt++ , dtData,            40,    daCenter,	true,     "ovr_dim_lf_len",		false,	"",  dfFloat,		1,true,true,	6);
                InitDataProperty(0, cnt++ , dtData,            40,    daCenter,	true,     "ovr_dim_rt_len",		false,	"",  dfFloat,		1,true,true,	6);
                
                CountPosition = 0;
            }
        break;

        case "t2sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 0;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 2, 100);

                var HeadTitle1 = "|Seq.|trans_mode|bl_no|BKG_CUST_TP_CD|CUST_NM|CUST_ADDR|CUST_CNT|CUST_ST_PO|RGST_NO|CO_CHN_TP_CD|CUST_FAX|CUST_EML|CUST_PHN";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, 
                //			  EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 30,        	daCenter,       false,      "ibflag");
                InitDataProperty(0, cnt++ , dtSeq,    		35,        	daCenter,       false,      "Seq");
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"chn_mf_snd_ind_cd",false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"bl_no",			false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		100,    	daCenter,		true,    	"bkg_cust_tp_cd",	false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		120,    	daCenter,		true,    	"cust_nm",			false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		300,    	daCenter,		true,    	"cust_addr",		false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"cust_cnt",			false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"chn_cstms_st_nm",	false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"rgst_no",			false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"co_chn_tp_cd",		false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"cust_fax_no",		false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"cust_eml",			false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"cust_phn_no",		false,"",  dfNone,    0,true,true);
                
                CountPosition = 0;
            }
        break;

        case "t3sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 262;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 2, 100);

                var HeadTitle1 = "|Sel.|Seq.|trans_mode|bl_no|Container No.|Class|UN DGNO|Label||";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 30,        	daCenter,       false,      "ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,     30,    		daCenter, 		true,  	  	"Chk");    
                InitDataProperty(0, cnt++ , dtSeq,    		35,        	daCenter,       false,      "Seq");
                InitDataProperty(0, cnt++ , dtHidden,    	70,    		daCenter,		true,    	"chn_mf_snd_ind_cd",	false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtHidden,    	70,    		daCenter,		true,    	"bl_no",				false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtData,    		100,    	daCenter,		true,    	"cntr_no",				true, "",  dfEngUpKey,0,true,true,	14);
                InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"imdg_clss_cd",			false,"",  dfNone,    0,true,true,	3);
                //InitDataProperty(0, cnt++ , dtData,    		70,    		daCenter,		true,    	"imdg_pg_no",			false,"",  dfNone,    0,true,true,	10);
                InitDataProperty(0, cnt++ , dtData,    		120,    	daCenter,		true,    	"imdg_un_no",			false,"",  dfNone,    0,true,true,	4);
                InitDataProperty(0, cnt++ , dtData,    		300,    	daCenter,		true,    	"imdg_subs_rsk_lbl_cd",	false,"",  dfNone,    0,true,true,	3);
                InitDataProperty(0, cnt++ , dtHidden,    	120,    	daCenter,		true,    	"cntc_pson_nm",			false,"",  dfNone,    0,true,true);
                InitDataProperty(0, cnt++ , dtHidden,    	300,    	daCenter,		true,    	"cntc_pson_telcm_no",	false,"",  dfNone,    0,true,true);
                
                CountPosition = 0;
            }
        break;

    }
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;
	
    switch(sAction) {
	  	case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			initFormData();  			
			ComOpenWait(true,true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0217GS.do", FormQueryString(formObj));
       	    var arrXml = sXml.split("|$$|");
			var State = ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
                 sheetObj.Redraw = false;           
                 sheetObjects[0].LoadSearchXml(arrXml[0]);  
                 sheetObjects[2].LoadSearchXml(arrXml[1]);
                 ComEtcDataXmlToForm(arrXml[0], formObj);
                 
                 formObj.vvd_pod_cd.value = formObj.bkg_pod_cd.value;
                 sheetObj.Redraw = true;          
                 if( ComGetEtcData(arrXml[0],"bl_no") == undefined && 
            		 ComGetEtcData(arrXml[0],"shpr_nm") == undefined &&
            		 sheetObjects[0].TotalRows == 0 && 
            		 sheetObjects[2].TotalRows == 0 ) {
                	 	// 조회된 데이터가 없을 경우
         				ComShowCodeMessage("BKG00889"); // No Data Found
                 }
                 else{
	                 formObj.trsp_mod_id.Code = ComGetEtcData(arrXml[0],"trsp_mod_id");
	                 formObj.wgt_ut_cd.Code = ComGetEtcData(arrXml[0],"wgt_ut_cd") == "" ? 'KGS' : ComGetEtcData(arrXml[0],"wgt_ut_cd");
	                 formObj.meas_ut_cd.Code = ComGetEtcData(arrXml[0],"meas_ut_cd") == "" ? 'CBM' : ComGetEtcData(arrXml[0],"meas_ut_cd");
	
	                 if(document.form.pck_qty.value != "") AddComma( document.form.pck_qty, "#,###.#" );
	                 if(document.form.act_wgt.value != "") AddComma( document.form.act_wgt, "#,###.#" );
	                 if(document.form.meas_qty.value != "") AddComma( document.form.meas_qty, "#,###.#" );
	                 if(document.form.temp.value != "") AddComma( document.form.temp, "#,###.#" );
	                 
	                 SetButtonStatus();	// Button Enabled
	             	
	                 if(document.form.cnee_addr.value == 'TO ORDER') {
	            		document.form.cnee_addr.readOnly = true;
	            	}
                 }
	        }
	        else{
	        	ComShowMessage(ComResultMessage(sXml));
	        }
	         ComOpenWait(false);
        break;
			
		case IBROWSEARCH: // 그리드에서 Container No. 입력시 조회
			if(!validateForm(sheetObj,formObj,IBSEARCH)) return false;
			
			formObj.f_cmd.value = SEARCH01;
            sheetObj.WaitImageVisible = false;  
            var Row = sheetObj.SelectRow;
			var params = FormQueryString(formObj)+"&cntr_no="+sheetObj.CellValue(Row, "cntr_no");
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0217GS.do", params);
    		var cntr_no = ComGetEtcData(sXml, "cntr_no");
    		var cntr_tpsz_cd = ComGetEtcData(sXml, "cntr_tpsz_cd");
    		
	        if(cntr_no == undefined || cntr_no == ""){
    			ComShowCodeMessage("BKG06012", sheetObj.CellText(Row, "cntr_no"));
    			sheetObj.CellValue2(Row, "cntr_no") = "";
    			sheetObj.SelectCell(Row, "cntr_no");
    			if(sheetObj.id == "t1sheet1"){
        			sheetObj.CellValue2(Row, "cntr_tpsz_cd") = "";
    			}
    		}else{
				sheetObj.CellValue2(Row, "cntr_no") = cntr_no;
    			if(sheetObj.id == "t1sheet1"){
    				sheetObj.CellValue2(Row, "cntr_tpsz_cd") = cntr_tpsz_cd; 
    			}
    		}
			break;

        case IBRESET:        //New
    	    formObj.reset();
        	document.form.wgt_ut_cd.Code = "KGS";
        	document.form.meas_ut_cd.Code = "CBM";
        	
    	    sheetObjects[0].RemoveAll();
    	    sheetObjects[1].RemoveAll();
    	    sheetObjects[2].RemoveAll();
        	SetButtonStatus();	// Button Disabled
        	
        	document.form.bl_no.focus();
    	break;

        case IBSAVE:         //Save
			if(!validateForm(sheetObj,formObj,IBSAVE)) return false;
			ComOpenWait(true,true);
			formObj.f_cmd.value = MULTI;
			var sheet2 = sheetObjects[1];
			sheet2.RemoveAll();
			var row;
			// Customer Info. 탭의 입력된 정보를  sheet 로 옮겨서 저장 시 파라미터로 전송
			row = GetAddRowIndex(sheet2);
			sheet2.CellValue2(row, "bkg_cust_tp_cd") = 'S';
			sheet2.CellValue2(row, "cust_nm") 		 = formObj.shpr_nm.value; 
			sheet2.CellValue2(row, "cust_addr") 	 = formObj.shpr_addr.value;
			sheet2.CellValue2(row, "rgst_no")		 = formObj.shpr_rgst_no.value;
			sheet2.CellValue2(row, "cust_cnt")		 = formObj.shpr_cnt.value;
			sheet2.CellValue2(row, "chn_cstms_st_nm")= formObj.shpr_st_po.value;
			sheet2.CellValue2(row, "cust_fax_no")	 = formObj.shpr_fax.value;
			sheet2.CellValue2(row, "cust_eml")		 = formObj.shpr_eml.value;
			sheet2.CellValue2(row, "cust_phn_no")		 = formObj.shpr_phn.value;
			
			row = GetAddRowIndex(sheet2);
			sheet2.CellValue2(row, "bkg_cust_tp_cd") = 'C';
			sheet2.CellValue2(row, "cust_nm") 		 = formObj.cnee_nm.value; 
			sheet2.CellValue2(row, "cust_addr") 	 = formObj.cnee_addr.value;
			sheet2.CellValue2(row, "rgst_no")		 = formObj.cnee_rgst_no.value;
			sheet2.CellValue2(row, "co_chn_tp_cd")	 = formObj.cnee_co_chn_tp_cd.value;
			sheet2.CellValue2(row, "cust_cnt")		 = formObj.cnee_cnt.value;
			sheet2.CellValue2(row, "chn_cstms_st_nm")= formObj.cnee_st_po.value;
			sheet2.CellValue2(row, "cust_fax_no")	 = formObj.cnee_fax.value;
			sheet2.CellValue2(row, "cust_eml")		 = formObj.cnee_eml.value;
			sheet2.CellValue2(row, "cust_phn_no")	 = formObj.cnee_phn.value;
			
			row = GetAddRowIndex(sheet2);
			sheet2.CellValue2(row, "bkg_cust_tp_cd") = 'N';
			sheet2.CellValue2(row, "cust_nm") 		 = formObj.ntfy_nm.value; 
			sheet2.CellValue2(row, "cust_addr") 	 = formObj.ntfy_addr.value;
			sheet2.CellValue2(row, "rgst_no")		 = formObj.ntfy_rgst_no.value;
			sheet2.CellValue2(row, "co_chn_tp_cd")	 = formObj.ntfy_co_chn_tp_cd.value;
			sheet2.CellValue2(row, "cust_cnt")		 = formObj.ntfy_cnt.value;
			sheet2.CellValue2(row, "chn_cstms_st_nm")= formObj.ntfy_st_po.value;
			sheet2.CellValue2(row, "cust_fax_no")	 = formObj.ntfy_fax.value;
			sheet2.CellValue2(row, "cust_eml")		 = formObj.ntfy_eml.value;
			sheet2.CellValue2(row, "cust_phn_no")	 = formObj.ntfy_phn.value;			
			
			var params  = FormQueryString(formObj) + "&";
			var params1 = ComSetPrifix(ComGetSaveString(sheetObjects[0], false, true), "t1_") + "&";
			var params2 = ComSetPrifix(ComGetSaveString(sheetObjects[1], false, true), "t2_") + "&";
			var params3 = ComSetPrifix(ComGetSaveString(sheetObjects[2], false, true), "t3_");
						 
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0217GS.do", params+params1+params2+params3);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
                sheetObj.Redraw = false;           
                sheetObj.LoadSearchXml(sXml);
                sheetObj.Redraw = true;
	        	ComOpenWait(false);
		   		ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
		    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	        }else{
	        	ComOpenWait(false);
	        	ComShowMessage(ComResultMessage(sXml));
	        }
        break;

		case IBINSERT:       //Row Add
			var row = GetAddRowIndex(sheetObj);			
			break;
			
		case IBDELETE:		 //Row Del
			if(ComShowCodeConfirm('BKG03037')){
				ComRowHideDelete(sheetObj,"Chk");
			}
		break;
		
		case IBSEARCH_ASYNC01:	//Mark		
			ComOpenWindowCenter("ESM_BKG_1036.do?pgmNo=ESM_BKG_1036&bl_mk_desc="+formObj.bl_mk_desc.value, "ESM_BKG_1036", 330, 248);
		break;
		
		case MULTI01: // Transmit Manifest
			
			// 2014.06.17 Hannah Lee , validate the form for transmision
			if(!validateForm(sheetObj,formObj,MULTI01))	return false;
			// 2014.06.17 end
		
			
			ComOpenWait(true,true);
			formObj.f_cmd.value = MULTI01;
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0217GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
			ComShowMessage(ComResultMessage(sXml));
	        if(State == "S"){
	        	//formObj.output.value = ComGetEtcData(sXml, "flatFile");
	        }
	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		break;
    }
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
	    case IBSEARCH: // 조회
			if(!ComChkRequired(formObj)) return false;
	        return true;
	        break;
	    case IBSAVE: // 저장
	    	for(var i=1; i<sheetObj.RowCount+1; i++){
	    		if(sheetObj.CellValue(i, "cntr_no") == "") {
//	    			alert("[Container Info.] Container No. is Mandatory item.");
	    			ComShowCodeMessage('BKG00104','Container Info.');
        			tabObjects[0].SelectedIndex = 0;
	    			sheetObj.SelectCell(i, "cntr_no");
	    			return false;
	    		}
	    	}
	    	var sheetObj3 = sheetObjects[2];
	    	for(var i=1; i<sheetObj3.RowCount+1; i++){
	    		if(sheetObj3.CellValue(i, "cntr_no") == "") {
//	    			alert("[Danger Info.] Container No. is Mandatory item.");
	    			ComShowCodeMessage('BKG00104','Danger Info.');
        			tabObjects[0].SelectedIndex = 2;
	    			sheetObj3.SelectCell(i, "cntr_no");
	    			return false;
	    		}
	    	}
	    	
	    	if(ComIsEmpty(formObj.shpr_nm)) {
	    		ComShowCodeMessage('BKG95025', 'Shipper Name on the Customer Info. tab');
	    		ComSetFocus(formObj.shpr_nm);
	    		return false;
	    	} else if(ComIsEmpty(formObj.shpr_addr)) {
	    		ComShowCodeMessage('BKG95025', 'Shipper Address on the Customer Info. tab');
	    		ComSetFocus(formObj.shpr_addr);
	    		return false;
			} else if(ComIsEmpty(formObj.cnee_nm)) {
				ComShowCodeMessage('BKG95025', 'Consignee Name on the Customer Info. tab');
				ComSetFocus(formObj.cnee_nm);
				return false;
			} else if(ComIsEmpty(formObj.cnee_addr)) {
				ComShowCodeMessage('BKG95025', 'Consignee Address on the Customer Info. tab');
				ComSetFocus(formObj.cnee_addr);
				return false;
	    	} else if(ComIsEmpty(formObj.ntfy_nm)) {
	    		ComShowCodeMessage('BKG95025', 'Notify Name on the Customer Info. tab');
	    		ComSetFocus(formObj.ntfy_nm);
	    		return false;
	    	} else if(ComIsEmpty(formObj.ntfy_addr)) {
	    		ComShowCodeMessage('BKG95025', 'Notify Address on the Customer Info. tab');
	    		ComSetFocus(formObj.ntfy_addr);
	    		return false;
	    	}			
	    	if(document.form.str_pgm_no.value == "ESM_BKG_0217-1") {
		    	if(ComIsEmpty(formObj.shpr_cnt)) {
		    		ComShowCodeMessage('BKG95025', 'Shipper Country on the Customer Info. tab');
		    		ComSetFocus(formObj.shpr_cnt);
		    		return false;
		    	} else if(ComIsEmpty(formObj.shpr_st_po)) {
		    		ComShowCodeMessage('BKG95025', 'Shipper Street / P.O.Box on the Customer Info. tab');
		    		ComSetFocus(formObj.shpr_st_po);
		    		return false;
		    	} else if(ComIsEmpty(formObj.shpr_rgst_no)) {
		    		ComShowCodeMessage('BKG95025', 'Shipper Enterprise Code on the Customer Info. tab');
		    		ComSetFocus(formObj.shpr_rgst_no);
		    		return false;
		    	} else if(ComIsEmpty(formObj.shpr_fax) && ComIsEmpty(formObj.shpr_eml) && ComIsEmpty(formObj.shpr_phn)) {
		    		ComShowCodeMessage('BKG95143', 'Shipper');
		    		ComSetFocus(formObj.shpr_fax);
		    		return false;
		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComIsEmpty(formObj.cnee_cnt)) {
		    		ComShowCodeMessage('BKG95025', 'Consignee Country on the Customer Info. tab');
		    		ComSetFocus(formObj.cnee_cnt);
		    		return false;
		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComIsEmpty(formObj.cnee_st_po)) {
		    		ComShowCodeMessage('BKG95025', 'Consignee Street / P.O.Box on the Customer Info. tab');
		    		ComSetFocus(formObj.cnee_st_po);
		    		return false;
//		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComIsEmpty(formObj.cnee_co_chn_tp_cd)) {
//		    		ComShowCodeMessage('BKG95025', 'USCI/ORG/B.License Code on the Customer Info. tab');
//		    		ComSetFocus(formObj.cnee_co_chn_tp_cd);
//		    		return false;
		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComIsEmpty(formObj.cnee_rgst_no )) {
		    		ComShowCodeMessage('BKG95025', 'Consignee Enterprise/USCI/ORG/B.Lic Code on the Customer Info. tab');
		    		ComSetFocus(formObj.cnee_rgst_no);
		    		return false;
		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComIsEmpty(formObj.cnee_fax) && ComIsEmpty(formObj.cnee_eml) && ComIsEmpty(formObj.cnee_phn)) {
		    		ComShowCodeMessage('BKG95143', 'Consignee');
		    		ComSetFocus(formObj.cnee_fax);
		    		return false;
		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComIsEmpty(formObj.ntfy_cnt)) {
		    		ComShowCodeMessage('BKG95025', 'Notify Country on the Customer Info. tab');
		    		ComSetFocus(formObj.ntfy_cnt);
		    		return false;
		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComIsEmpty(formObj.ntfy_st_po)) {
		    		ComShowCodeMessage('BKG95025', 'Notify Street / P.O.Box on the Customer Info. tab');
		    		ComSetFocus(formObj.ntfy_st_po);
		    		return false;
//		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComIsEmpty(formObj.ntfy_co_chn_tp_cd)) {
//		    		ComShowCodeMessage('BKG95025', 'USCI/ORG/B.License Code on the Customer Info. tab');
//		    		ComSetFocus(formObj.ntfy_co_chn_tp_cd);
//		    		return false;	    		
		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComIsEmpty(formObj.ntfy_rgst_no)) {
		    		ComShowCodeMessage('BKG95025', 'Notify Enterprise/USCI/ORG/B.Lic Code on the Customer Info. tab');
		    		ComSetFocus(formObj.ntfy_rgst_no);
		    		return false;
		    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComIsEmpty(formObj.ntfy_fax) && ComIsEmpty(formObj.ntfy_eml) && ComIsEmpty(formObj.ntfy_phn)) {
		    		ComShowCodeMessage('BKG95143', 'Notify');
		    		ComSetFocus(formObj.ntfy_fax);
		    		return false;
		    	}  		    		
		    }
	        return true;
	        break;
	        
	    // 2014.06.17 Hannah Lee, Add
	    case MULTI01: // transmit
	    	
	    	var sheetObject1 = sheetObjects[0]; // Container Info
	    	var sheetObject3 = sheetObjects[2]; // Danger Info
	    	
	    	var formObject = document.form;
	    	
	    	if(formObject.bkg_cgo_tp_cd.value=="F"){
	    		// form & tab2
		    	if( ComTrim(formObject.pck_qty.value) <= 0 || ComTrim(formObject.pck_tp_cd.value) == "") {
		    		ComShowCodeMessage("BKG06155", "Package");
		    		return false;
		    		
		    	} else if( ComTrim(formObject.act_wgt.value) <= 0 || ComTrim(formObject.wgt_ut_cd.Code) == "") {
		    		ComShowCodeMessage("BKG06155", "Weight");
		    		return false;
		    		
		    	} /*else if( ComTrim(formObj.meas_qty.value) <= 0 ){
		    		ComShowCodeMessage("BKG06155", "Measure");
		    		return false;
		    		
		    	}*/ 
		    	else if( ComTrim(formObj.rcv_term_cd.value) == "" || ComTrim(formObj.de_term_cd.value) == "") {
		    		ComShowCodeMessage("BKG06155", "R/D Term");
		    		return false;
		    	} else if( ComTrim(formObj.frt_term_cd.value) == "") {
		    		ComShowCodeMessage("BKG06155", "Freight");
		    		return false;
		    	} else if( ComTrim(formObj.shpr_nm.value) == "" 
		    		    || ComTrim(formObj.shpr_addr.value) == ""
		    		    || ComTrim(formObj.cnee_nm.value) == ""
		    		    || ComTrim(formObj.cnee_addr.value) == ""
		    		    || ComTrim(formObj.ntfy_nm.value) == ""
		    		    || ComTrim(formObj.ntfy_addr.value) == ""
		    		    ) {
		    		ComShowCodeMessage("BKG06155", "Customer Info.");
		    		return false;
		    	} 
		    	if(document.form.str_pgm_no.value == "ESM_BKG_0217-1") {
			    	if(ComTrim(formObj.shpr_cnt.value) == ""){
			    		ComShowCodeMessage("BKG06155", "Customer Info.");
			    		return false;		    		
			    	// Cnee 가 TO ORDER가 아니면 Cnee Country 필수 입력
			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComTrim(formObj.cnee_cnt.value) == "") {
			    		ComShowCodeMessage("BKG06155", "Customer Info.");
			    		ComSetFocus(formObj.cnee_cnt);
			    		return false;
			    	// Cnee 가 TO ORDER이면 Ntfy Country 필수 입력	
			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComTrim(formObj.ntfy_cnt.value) == "") {
			    		ComShowCodeMessage("BKG06155", "Customer Info.");
			    		ComSetFocus(formObj.ntfy_cnt);
			    		return false;		    		
			    	} else if( ComTrim(formObj.shpr_rgst_no.value) == ""){
			    		ComShowCodeMessage('BKG95025', 'Shipper Enterprise Code on the Customer Info. tab');
			    		ComSetFocus(formObj.shpr_rgst_no);
			    		return false;
			    	// Cnee 가 TO ORDER가 아니면 Cnee USCI/ORG/B.License 유형 필수 입력	
//			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComTrim(formObj.cnee_co_chn_tp_cd.value) == ""){ 
//			    		ComShowCodeMessage("BKG95139");
//			    		ComSetFocus(formObj.cnee_co_chn_tp_cd);
//			    		return false;
			    	// Cnee 가 TO ORDER 이면 Ntfy USCI/ORG/B.License 유형 필수 입력	
//			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComTrim(formObj.ntfy_co_chn_tp_cd.value) == "") {
//			    		ComShowCodeMessage("BKG95139");
//			    		ComSetFocus(formObj.ntfy_co_chn_tp_cd);
//			    		return false;		    		
			    	// Cnee 가 TO ORDER가 아니면 Cnee USCI/ORG/B.License Code 필수 입력	
			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComTrim(formObj.cnee_rgst_no.value) == ""){ 
			    		ComShowCodeMessage('BKG95025', 'Consignee Enterprise/USCI/ORG/B.Lic Code on the Customer Info. tab');
			    		ComSetFocus(formObj.cnee_rgst_no);
			    		return false;
			    	// Cnee 가 TO ORDER 이면 Ntfy USCI/ORG/B.License Code 필수 입력	
			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComTrim(formObj.ntfy_rgst_no.value) == "") {
			    		ComShowCodeMessage('BKG95025', 'Notify Enterprise/USCI/ORG/B.Lic Code on the Customer Info. tab');
			    		ComSetFocus(formObj.ntfy_rgst_no);
			    		return false;		    		
			    	} else if(ComTrim(formObj.shpr_st_po.value) == ""){
			    		ComShowCodeMessage("BKG95141", "Shipper");
			    		ComSetFocus(formObj.shpr_st_po);
			    		return false;
			    	// Cnee 가 TO ORDER가 아니면 Cnee Street / P.O.Box 필수 입력	
			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComTrim(formObj.cnee_st_po.value) == ""){
			    		ComShowCodeMessage("BKG95141", "Consignee");
			    		ComSetFocus(formObj.cnee_st_po);
			    		return false;
			    	// Cnee 가 TO ORDER 이면 Cnee Street / P.O.Box 필수 입력	
			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComTrim(formObj.ntfy_st_po.value) == ""){
			    		ComShowCodeMessage("BKG95141", "Notify");
			    		ComSetFocus(formObj.ntfy_st_po);
			    		return false;		    		
			    	} else if(ComTrim(formObj.shpr_fax.value) == "" && ComTrim(formObj.shpr_eml.value) == "" && ComTrim(formObj.shpr_phn.value) == "") {
			    		ComShowCodeMessage("BKG95143", "Shipper");
			    		ComSetFocus(formObj.shpr_fax);
			    		return false;
			    	// Cnee가 TO ORDER이면 Ntfy Fax, E-mail, Phone 중 하나 필수 입력	
			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) == "TOORDER" && ComTrim(formObj.ntfy_fax.value) == "" 
			    		&& ComTrim(formObj.ntfy_eml.value) == "" && ComTrim(formObj.ntfy_phn.value) == ""){
			    		ComShowCodeMessage("BKG95143", "Notify");
			    		ComSetFocus(formObj.ntfy_fax);
			    		return false;
			    	// Cnee 가 TO ORDER가 아니면 Cnee Fax, E-mail, Phone 중 하나 필수 입력	
			    	} else if(ComTrimAll(formObj.cnee_addr.value.toUpperCase()) != "TOORDER" && ComTrim(formObj.cnee_fax.value) == "" 
			    		&& ComTrim(formObj.cnee_eml.value) == "" && ComTrim(formObj.cnee_phn.value) == ""){
			    		ComShowCodeMessage("BKG95143", "Consignee");
			    		ComSetFocus(formObj.cnee_fax);
			    		return false;
			    	}
		    	}
		    	
		    	if(formObj.sav_flg.value == "Y") {
		    		ComShowCodeMessage("BKG00178");
		    		return false;
		    	}
		    	
		    	for( var i = 1; i <= sheetObject1.RowCount; i++ ) {
		    		
			    	if( ComTrim(sheetObject1.CellValue(i, "seal_no")) == ""){
			    		ComShowCodeMessage("BKG06155", "Seal No.");
			    		return false;
			    	} else if( ComTrim(sheetObject1.CellText(i, "seal_knd_cd")) == "" ){
			    		ComShowCodeMessage("BKG06155", "Seal Kind");
			    		return false;
			    	} else if( ComTrim(sheetObject1.CellText(i, "seal_pty_tp_cd")) == "" ){
			    		ComShowCodeMessage("BKG06155", "Sealer");
			  			return false;
			   		} 
			    }//end for
			    	
		    	for( var i=1; i <= sheetObject3.RowCount; i++ ) {
		    		
					var psonNm  = ComTrim(sheetObject3.CellValue(i, "cntc_pson_nm"));
					var psonTel = ComTrim(sheetObject3.CellValue(i, "cntc_pson_telcm_no"));
					
					if(psonNm == ""){
						ComShowCodeMessage("BKG06155", "DG Contact Person");
						return false;
					}else if (psonTel== ""){
						ComShowCodeMessage("BKG06155", "DG Emergency Contact");
						return false;
					}
					
				}//end for
		    	
	    	}
	    	
	    	return true;
	    	break;
	    	
    }
}

/**
 * 시트 데이터 변경 시 데이터 처리
 */
function t1sheet1_OnChange(sheetObj, row, col, val){
	if(sheetObj.ColSaveName(col) == "seal_pty_tp_cd") {
		document.form.seal_pty_tp_cd.Code = val;
		sheetObj.CellValue2(row, "seal_pty_nm") = document.form.seal_pty_tp_cd.Text;
	}
	else if (sheetObj.ColSaveName(col) == "cntr_no" && sheetObj.CellValue(row, "cntr_no") != ""){
		for(var i=1; i<=sheetObj.LastRow; i++){
			if(i == row) continue;
			if(sheetObj.CellValue(i, "cntr_no") == sheetObj.CellValue(row, "cntr_no")) {
				//"Container No. [{?msg1}] is duplicated. Check container number.
		   		ComShowCodeMessage("BKG00965", sheetObj.CellValue(row, "cntr_no")); 
		   		sheetObj.CellValue2(row, "cntr_no") = "";
		   		sheetObj.SelectCell(row, "cntr_no");
				return;
			}
		}
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH);
	}
}

/**
 * Cntr No 데이터 변경 시 유효성 체크 함수 호출
 */
function t3sheet1_OnChange(sheetObj, row, col, val){
	if (sheetObj.ColSaveName(col) == "cntr_no" && sheetObj.CellValue(row, "cntr_no") != ""){
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH);
	}
}

/**
 * Select Box 변경 시 데이터 처리
 */
function form_OnChange() {
	ComSetObjValue(document.form.sav_flg, "Y");
}

/**
 * Form 컨트롤에서 포커스인 시 데이터 처리
 */
function obj_FocusIn(){
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "pck_qty" || srcName == "act_wgt" || srcName == "meas_qty") {
		srcObj.style.textAlign = "left";
		if(srcValue.substr(srcValue.length-4) == ".000"){
			srcObj.value = srcValue.substr(0, srcValue.length-4);
		}
	}
	if (srcName == "temp") {
		srcObj.style.textAlign = "left";
		if(srcValue == "0.0"){
			srcObj.value = "";
		}
	}
}

/**
 * Form 컨트롤에서 포커스아웃 시 데이터 처리
 */
function obj_FocusOut(){
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "pck_qty" || srcName == "act_wgt" || srcName == "meas_qty") {
		srcObj.style.textAlign = "right";
		AddComma(srcObj,"#,###.#");
	}
	if (srcName == "temp") {
		srcObj.style.textAlign = "right";
		if(srcValue == ""){
			srcObj.value = "0.0";
		}else{
			AddComma(srcObj,"#,###.#");
		}
	}
}

/**
 * 키보드 누를 때 Form 데이터 처리
 */
function obj_KeyUp() {
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "pck_qty" || srcName == "act_wgt" || srcName == "meas_qty") {
		AddComma(srcObj,"#,###.###",srcMaxLength);
	}
	if (srcName == "temp") {
		AddComma(srcObj,"#,###.##",srcMaxLength);
	}
	if (srcName == "shpr_rgst_no" || srcName =="cnee_rgst_no" || srcName == "ntfy_rgst_no"
		|| srcName == "shpr_cnt" || srcName == "cnee_cnt" || srcName == "ntfy_cnt" 
		|| srcName == "shpr_st_po" || srcName == "cnee_st_po" || srcName == "ntfy_st_po" 
		|| srcName == "shpr_fax" || srcName == "cnee_fax" || srcName == "ntfy_fax" 	
		|| srcName == "shpr_eml" || srcName == "cnee_eml" || srcName == "ntfy_eml"	
		|| srcName == "shpr_phn" || srcName == "cnee_phn" || srcName == "ntfy_phn") {
		ComSetObjValue(document.form.sav_flg, "Y");
	}
}

/**
 * Form 데이터 초기화
 */
function initFormData() {
	var frmChild = document.getElementsByTagName("input");
	
	for(var i=0; i<frmChild.length; i++){
		if(frmChild[i].type == "text" && frmChild[i].name != "bl_no") {
    		frmChild[i].value = "";
		}
		if(frmChild[i].type == "hidden"){
			if( frmChild[i].name == "bl_mk_desc" ||
				frmChild[i].name == "bkg_pol_cd" ||
				frmChild[i].name == "bkg_pod_cd" ||
				frmChild[i].name == "chn_mf_snd_ind_cd" ||
				frmChild[i].name == "sav_flg") {
	    		frmChild[i].value = "";
			}
		}
		if(frmChild[i].type == "checkbox") {
    		frmChild[i].checked = false;
		}
    }
	
	document.form.wgt_ut_cd.Code = "KGS";
	document.form.meas_ut_cd.Code = "CBM";
	
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
}


/**
 * 문자열을 숫자포멧에 맞게 변경하여 리턴한다. 숫자포멧으로 설정할수 있는 값은 다음과 같다. <br>
 * <br>
 * @param {object,string}   obj      필수,숫자문자열 또는 HTML태그(Object)
 * @param {string}   		string   필수,포맷 스트링
 * @param {int}   			int      선택,HTML태그(Object)의 Maxlength
 * @returns string, 숫자포멧이 설정된 문자열<br>
 *          "":sVal인자의 값이 잘못된 경우 공백("")을 리턴한다.
 * @see #ComAddComma
 * @see #ComGetMaskedValue
 */
function AddComma(obj, sFormat, len){
    try {
        var sVal = obj.value.replace(/\,/g,"");
    	switch(sFormat){
    		case "#,###":
    			obj.value = ComAddComma(sVal);
    			break;
    		case "#,###.#":
    			if(sVal == ".") sVal = "0.";
    	    	p = sVal.split(".");
                p[0] = ComAddComma(p[0]);
                if      (p.length <= 1) obj.value = p[0]+".000";
                else if (p.length == 2) obj.value = p[0]+"."+p[1].substr(0,3);
                else if (p.length > 2) 	obj.value = p[0]+"."+p[1].substr(0,3);
                else sVal = "";
    			break;
    		case "#,###.##":
    			if(sVal == ".") sVal = "0.";
    	    	p = sVal.split(".");
                p[0] = ComAddComma(p[0]);
                if (p.length <= 1) {
                	if(p[0].length > len-3) {
                		sVal = p[0].substr(0, len-3).replace(/\,/g,"");
                		p[0] = ComAddComma(sVal);
                	}
                	obj.value = p[0];
                }
                else if (p.length == 2) obj.value = p[0]+"."+p[1].substr(0,2);
                else if (p.length > 2) obj.value = p[0]+"."+p[1].substr(0,2);
                else sVal = "";
    			break;
    		case "#,###.###":
    			if(sVal == ".") sVal = "0.";
    	    	p = sVal.split(".");
                p[0] = ComAddComma(p[0]);
                if (p.length <= 1) {
                	if(p[0].length > len-4) {
                		sVal = p[0].substr(0, len-3).replace(/\,/g,"");
                		p[0] = ComAddComma(sVal);
                	}
                	obj.value = p[0];
                }
                else if (p.length == 2) obj.value = p[0]+"."+p[1].substr(0,3);
                else if (p.length > 2) obj.value = p[0]+"."+p[1].substr(0,3);
                else sVal = "";
    			break;
    	}
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * sheet에 새 Row 를 추가하고 기본값을 셋팅한뒤 Row index를 리턴한다.<br>
 */
function GetAddRowIndex(sheetObj){
	var row = sheetObj.DataInsert(-1);
	sheetObj.CellValue2(row, "chn_mf_snd_ind_cd") = document.form.trans_mode.value;
	sheetObj.CellValue2(row, "bl_no") = document.form.bl_no.value;
	return row;
}

/**
 * 화면 로드 시 버튼 처리
 */
function SetButtonStatus(){
    if(document.form.bl_no.value == ""){
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_RowDel");
		ComBtnDisable("btn_RowAdd_3");
		ComBtnDisable("btn_RowDel_3");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_Mark");
    }
    else{
		 ComBtnEnable("btn_RowAdd");
		 ComBtnEnable("btn_RowDel");
		 ComBtnEnable("btn_RowAdd_3");
		 ComBtnEnable("btn_RowDel_3");
		 ComBtnEnable("btn_Save");
		 ComBtnEnable("btn_Transmit");
		 ComBtnEnable("btn_Mark");
    }
}

/**
 * 화면 로드 시 콤보 데이터 생성
 */
function SetComboData(sXml){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
    var arrXml = sXml.split("|$$|");
    var arrCombo;
    
	ComXml2ComboItem(arrXml[0], formObj.trsp_mod_id, "val", "desc");
	
	ComXml2ComboItem(arrXml[2], formObj.seal_pty_tp_cd, "val", "desc");
	formObj.seal_pty_tp_cd.InsertItem(0, ' ', ' '); 
	
	ComXml2ComboItem(arrXml[3], formObj.wgt_ut_cd, "val", "desc");	
	ComXml2ComboItem(arrXml[4], formObj.meas_ut_cd, "val", "desc");
	formObj.wgt_ut_cd.Code = "KGS";
	formObj.meas_ut_cd.Code = "CBM";
	
	ComXml2ComboItem(arrXml[5], formObj.msg_type, "attr_ctnt1", "attr_ctnt2");
	if(formObj.trans_mode.value == "D"){
		formObj.msg_type.Code = '0';
	}else{
		formObj.msg_type.Code = '9';
	}			
	
	arrCombo = ComXml2ComboString(arrXml[1], "desc", "val");
	sheetObj.InitDataCombo(0, "seal_knd_cd", " |"+arrCombo[0], " |"+arrCombo[1]);
	
	arrCombo = ComXml2ComboString(arrXml[2], "desc", "val");
	sheetObj.InitDataCombo(0, "seal_pty_tp_cd", " |"+arrCombo[0], " |"+arrCombo[1]);
	
	arrCombo = ComXml2ComboString(arrXml[3], "desc", "val");
	sheetObj.InitDataCombo(0, "wgt_ut_cd", arrCombo[0], arrCombo[1]);
	
	arrCombo = ComXml2ComboString(arrXml[4], "desc", "val");
	sheetObj.InitDataCombo(0, "meas_ut_cd", arrCombo[0], arrCombo[1]);
}
/* 개발자 작업  끝 */