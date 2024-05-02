﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0122.js
*@FileTitle : Wharfage Cargo Classification
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 오동현
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0122() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var vFreeRow = 0;
    var vFreeCol = 13;
    
    var vBulkWgt = 0;
    var vBulkMea = 0;
    

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
            				
	            case "btn_add":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND03);
	            	break;
	            	
	            case "btn_del":
	            	doActionIBSheet(sheetObject1,formObject,IBDELETE);
	            	break;	

	            case "btn_arif":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND04);
	            	break;	

	            case "btn_blif":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND05);
	            	break;	

	            case "btn_rateinquiry":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND01);
	            	break;	
	            
	            case "btn_blcheck":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND02);
	            	break;
	            	
	            case "btn_bkgcheck":
	            	doActionIBSheet(sheetObject1,formObject,COMMAND07);
	            	break;	

	            case "btn_retrieve":
                	doActionIBSheet(sheetObject1,formObject,SEARCH01);
                	break;
				
            	case "btn_save":
            		doActionIBSheet(sheetObjects[0],formObject,MULTI);
            		doActionIBSheet(sheetObject1,formObject,SEARCH01);

            		break;				
            	
            	case "btn_downexcel":
//            		sheetObjects[0].Down2Excel(-1, false, false, true, "", "", true);
            		sheetObjects[0].SpeedDown2Excel(-1);      //숨겨진 데이터는 제외하고 내려 받기
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        
        
    }
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObject = document.form;
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_Change', document.form);
    	formObject.vvd.focus();
    }
    
    function searcgBySelect(){
    	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
    	if( 'IN' ==  document.form.whf_bnd_cd.value ){
    		ComBtnDisable( "btn_save" );
    		ComBtnDisable( "btn_add" );
    		ComBtnDisable( "btn_del" );
    		ComBtnDisable( "btn_arif" );
    		ComBtnDisable( "btn_blif" );
    	}
    	else if( 'IT' == document.form.whf_bnd_cd.value ){
    		ComBtnEnable( "btn_save" );
    		ComBtnEnable( "btn_add" );
    		ComBtnEnable( "btn_del" );
    		ComBtnDisable( "btn_arif" );
    		ComBtnDisable( "btn_blif" );    	
    	}else{
    		ComBtnEnable( "btn_save" );
    		ComBtnEnable( "btn_add" );
    		ComBtnEnable( "btn_del" );
    		ComBtnEnable( "btn_arif" );
    		ComBtnEnable( "btn_blif" );
    	}
    }
   
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    /*
     * 조회조건입력시 자동 조회 처리
     */
    function condition_KeyUp(){
    	var formObject = document.form;
    	if( (    ComChkLen(formObject.vvd.value, 9) == "2" ) 
   				&& (ComChkLen(formObject.port_cd.value, 5) == "2" ) ){

    			doActionIBSheet(sheetObjects[0], formObject, SEARCH);
    	}
    }

   

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
				var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 255;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    
                    AutoRowHeight = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

					var HeadTitle1 = "|Sel.|Seq.|B/L No.|T|VVD|POL|POD|Commodity\nCode|Weight|Measure|Amount|Free|BZ No.|Shipper Name" +
							"|Export Ref.|Container Qty|Container Qty|Container Qty|CNTR Bulk Qty|CNTR Bulk Qty|CNTR Bulk Qty" +
							"|CNTR Bulk Qty|CNTR Bulk Qty|Booking Qty|Booking Qty|Booking Qty|Package\nType|Wharfage Rate|D/C" +
							"|Bulk Rton\nAppl Type|Bulk Rton|Bulk Whf\nAmount";
					var HeadTitle2 = "|Sel.|Seq.|B/L No.|T|VVD|POL|POD|Commodity\nCode|Weight|Measure|Amount|Free|BZ No.|Shipper Name" +
							"|Export Ref.|20’|40’|45’|20’|40’|45’|Weight|Measure|20’|40’|45’|Package\nType|Wharfage Rate|D/C" +
							"|Bulk Rton\nAppl Type|Bulk Rton|Bulk Whf\nAmount";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(44, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix = "sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,   	false,  prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,     40,   daCenter,   	true,   prefix + "Chk");
                    InitDataProperty(0, cnt++ , dtSeq,     		40,   daCenter,   	true,   prefix + "Seq.");
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,   	true,   prefix + "bl_no",                 	false,    "",   dfNone,         0,    false,   false, 12);
                    InitDataProperty(0, cnt++ , dtData,         20,   daCenter,   	true,   prefix + "t",                     	false,    "",   dfNone,         0,    false,   false, 1);
                    
                    InitDataProperty(0, cnt++ , dtData,         90,  daCenter,		true,   prefix + "vvd",                 	false,    "",   dfNone,         0,    false,   false, 9);
                    InitDataProperty(0, cnt++ , dtData,         40,   daCenter,   	true,   prefix + "pol_cd",                	false,    "",   dfNone,         0,    false,   false, 5);
                    InitDataProperty(0, cnt++ , dtData,         40,   daCenter,   	true,   prefix + "pod_cd",                	false,    "",   dfNone,         0,    false,   false, 5);
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,   	true,   prefix + "cmdt_cd",               	false,    "",   dfNone,      	0,    true,   true, 6);
                    InitDataProperty(0, cnt++ , dtData,         60,   daRight,    	true,   prefix + "wgt_qty",               	false,    "",   dfNullFloat,    3,    true,   true, 16);

                    InitDataProperty(0, cnt++ , dtData,         60,   daRight,    	true,   prefix + "meas_qty",              	false,    "",   dfNullFloat,    3,    true,   true, 22);
                    InitDataProperty(0, cnt++ , dtData,         100,   daRight,    	true,   prefix + "whf_amt",               	false,    "",   dfNullFloat,  	3,    true,   true, 22);
                    InitDataProperty(0, cnt++ , dtCombo,        100,  daCenter,   	true,   prefix + "wfg_expt_cd",           	false,    "",   dfNone,         0,    true,   true, 11);
                    InitDataProperty(0, cnt++ , dtData,         90,  daLeft,     	true,   prefix + "cust_rgst_no",          	false,    "",   dfNone,         0,    true,   true, 20);
                    InitDataProperty(0, cnt++ , dtData,         120,  daLeft,   	true,   prefix + "cust_nm",   				false,    "",   dfNone,         0,    false,   false, 20);

                    InitDataProperty(0, cnt++ , dtData,         120,   daLeft,    	true,   prefix + "xpt_ref_no",            	false,    "",   dfNone,    		0,    false,   false, 500);
                    InitDataProperty(0, cnt++ , dtData,      	40,   daRight,    	true,   prefix + "whf_cntr_20ft_qty",		false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtData,         40,   daRight,    	true,   prefix + "whf_cntr_40ft_qty",     	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtData,         40,   daRight,    	true,   prefix + "whf_cntr_45ft_qty",     	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtData,         40,   daRight,    	true,   prefix + "whf_blk_20ft_qty",      	false,    "",   dfNullFloat,    3,    true,   true, 16);

                    InitDataProperty(0, cnt++ , dtData,         40,   daRight,    	true,   prefix + "whf_blk_40ft_qty",      	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtData,         60,   daRight,    	true,   prefix + "whf_blk_45ft_qty",      	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtData,         60,   daRight,    	true,   prefix + "blk_wgt_qty",           	false,    "",   dfNullFloat,    3,    true,   true, 22);
                    InitDataProperty(0, cnt++ , dtData,         60,   daRight,    	true,   prefix + "blk_meas_qty",          	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtData,         40,   daRight,    	true,   prefix + "whf_bkg_20ft_qty",      	false,    "",   dfNullFloat,    3,    false,   false, 16);

                    InitDataProperty(0, cnt++ , dtData,         40,   daRight,    	true,   prefix + "whf_bkg_40ft_qty",      	false,    "",   dfNullFloat,    3,    false,	false, 16);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,   	true,   prefix + "whf_bkg_45ft_qty",      	false,    "",   dfNullFloat,    3,    false,   	false, 16);
                    InitDataProperty(0, cnt++ , dtCombo,        80,   daCenter,   	true,   prefix + "whf_pck_tp_cd",         	false,    "",   dfNone,         0,    true,		true, 3);
                    InitDataProperty(0, cnt++ , dtHidden,       120,  daLeft,     	true,   prefix + "whf_rt",                	false,    "",   dfNullFloat,    2,    true,   	true, 8);
                    InitDataProperty(0, cnt++ , dtHidden,       80,   daCenter,   	true,   prefix + "dc_flg",         			false,    "",   dfNone,         0,    true,   	true, 3);
                    
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,   	true,   prefix + "bulk_rton_appl_type",   	false,    "",   dfNone,    		3,    true,   true, 1);
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,   	true,   prefix + "rton_wgt",      			false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,   	true,   prefix + "bulk_wharfage_amount",  	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtHidden,       50,   daCenter,   	true,   prefix + "bkg_no",                	false,    "",   dfNone,         0,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtHidden,       40,   daRight,    	true,   prefix + "tax_teu_qty",           	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    
                    InitDataProperty(0, cnt++ , dtHidden,       40,   daRight,    	true,   prefix + "tax_feu_qty",           	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daRight,    	true,   prefix + "tax_45ft_qty",          	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtHidden,       70,   daRight,    	true,   prefix + "expt_teu_qty",          	false,    "",   dfNullFloat,    3,    true,   true, 22);
                    InitDataProperty(0, cnt++ , dtHidden,       40,   daRight,    	true,   prefix + "expt_feu_qty",          	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtHidden,       40,   daRight,    	true,   prefix + "expt_45ft_qty",         	false,    "",   dfNullFloat,    3,    true,   true, 16);

                    InitDataProperty(0, cnt++ , dtHidden,       40,   daCenter,   true,   	prefix + "whf_bnd_cd",            	false,    "",   dfNone,         0,    true,   true, 2);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daRight,    true,   	prefix + "blk_wgt_qty2",           	false,    "",   dfNullFloat,    3,    true,   true, 22);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daRight,    true,   	prefix + "blk_meas_qty2",          	false,    "",   dfNullFloat,    3,    true,   true, 16);
                    InitDataProperty(0, cnt++ , dtHidden,       100,  daRight,    true,   	prefix + "whf_amt_temp",       		false,    "",   dfNullFloat,  	3,    true,   true, 22);
                    
                    //InitDataCombo(0, prefix +"wfg_expt_cd", "일반", "B");
                    
                    InitDataValid(0, prefix + "bl_no", vtEngUpOther, "0123456789");
                    InitDataValid(0, prefix + "t", vtEngUpOnly);
                    InitDataValid(0, prefix + "vvd", vtEngUpOther, "0123456789");
                    InitDataValid(0, prefix + "cmdt_cd", vtNumericOnly, "");
                    //InitDataValid(0, prefix + "wfg_expt_cd", vtEngUpOnly);
                    InitDataValid(0, prefix + "cust_rgst_no", vtEngUpOther, "0123456789");
                    InitDataValid(0, prefix + "cust_nm", vtEngUpOther, "0123456789");
                    InitDataValid(0, prefix + "xpt_ref_no", vtEngUpOther, "0123456789");
                    InitDataCombo(0, prefix + "whf_pck_tp_cd", "CNT|BLK", "CNT|BLK");		
                    InitDataCombo(0, prefix + "dc_flg", "Y|N", "Y|N");		
                    

                    //InitUserFormat(0, prefix +"cust_rgst_no", "###-##-#####", "-" );
                    
                    WaitImageVisible=false;
                    
				}
				break;
								
            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

					var HeadTitle1 = "|구분|부과대상|정정대상|면제화주|면제화주|면제화주|T/S|IPO|Military|조달청|MTY|면제합계|TOT\nAmount|정정\nAmount|Bulk|Bulk|Bulk";
					var HeadTitle2 = "|구분|부과대상|정정대상|동부제강|현대|동국|T/S|IPO|Military|조달청|MTY|면제합계|TOT\nAmount|정정\nAmount|R.Ton|Rate|Amount";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix2 = 'sheet2_';
                    InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,		true,			prefix2 + "ibflag");
                    InitDataProperty(0, cnt++ , dtData,					40,		daCenter,		true,			prefix2 + "division",			false,		"",		dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					60,		daRight,		true,			prefix2 + "levy",				false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					60,		daRight,		true,			prefix2 + "correction",			false,		"",		dfNullFloat,		2,		true,		true);
                    //InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix2 + "hyosung",			false,		"",		dfNullFloat,		2,		true,		true);
                    //InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix2 + "daewoo",				false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					60,		daRight,		true,			prefix2 + "dongbu",				false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix2 + "hyundai",			false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix2 + "donguk",				false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix2 + "ts",					false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix2 + "ipo",				false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					60,		daRight,		true,			prefix2 + "military",			false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					55,		daRight,		true,			prefix2 + "government",			false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					40,		daRight,		true,			prefix2 + "mty",				false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					65,		daRight,		true,			prefix2 + "sum",				false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					65,		daRight,		true,			prefix2 + "totamount",			false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					60,		daRight,		true,			prefix2 + "correctionamt",		false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,			prefix2 + "bulk_rton",			false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,			prefix2 + "bulk_rate",			false,		"",		dfNullFloat,		2,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,			prefix2 + "bulk_amount",		false,		"",		dfNullFloat,		2,		true,		true);

					CountPosition = 0;
					
					WaitImageVisible=false;

				}
				break;

        }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case SEARCH:
        		if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value = SEARCH;   
					var aryPrefix = new Array("sheet1_"); 
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0122GS.do",FormQueryString(formObj) );
					
					if (ComGetEtcData(sXml,"mf_ref_no")){
						formObj.mf_ref_no.value = ComGetEtcData(sXml,"mf_ref_no");
						formObj.sail_dt.value   = ComGetEtcData(sXml,"sail_dt");
						formObj.whf_decl_no.value   = ComGetEtcData(sXml,"whf_decl_no"); 
					}
        		}
        		break;
        
        	case SEARCH01:      //조회
        		if( validateForm(sheetObj,formObj,sAction) ){
        			var prefix2 = 'sheet2_';
        			var prefix1 = 'sheet1_';	
					formObj.f_cmd.value = SEARCH01;   
					var aryPrefix = new Array("sheet1_", "sheet2_" ); //prefix 문자열 배열
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0122GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					ComOpenWait(false);
					var arrXml = sXml.split("|$$|");
					
					if (arrXml[1] != "") {
						var vArry = ComXml2ComboString(arrXml[1],  prefix2 +"attr_ctnt1", prefix2 +"attr_ctnt5" );
						sheetObjects[0].InitDataCombo (0, prefix1 + "wfg_expt_cd", vArry[1]+'| ', vArry[0]+'| ' );
					}
					
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					formObj.kr_whf_cntr_20ft_rt.value = ComGetEtcData(arrXml[0],"kr_whf_cntr_20ft_rt");
					formObj.kr_whf_cntr_40ft_rt.value = ComGetEtcData(arrXml[0],"kr_whf_cntr_40ft_rt");
					formObj.kr_whf_cntr_45ft_rt.value = ComGetEtcData(arrXml[0],"kr_whf_cntr_45ft_rt");
					formObj.kr_whf_blk_rt.value       = ComGetEtcData(arrXml[0],"kr_whf_blk_rt");
					
					/*
					   D/C 값 설정하기
					   - 그리드1의 첫 번째 Row의 D/C 값을 읽는다
					   - Port가 KRKAN이면 무조건 Y
					   - Bound가 OO 또는 OT이면 무조건 Y
					   - 위에 차례대로 읽어서 최종 결정 된 D/C 값을 Display Only D/C 값에 표시
					 */
					if( sheetObjects[0].RowCount > 1 ){ //헤더가 2라인이어서 로우는 3라인부터 데이터가 있다.
						var vDcFlg = sheetObjects[0].CellValue(2, prefix1+'dc_flg');
						
						if( 'Y' == vDcFlg )
							formObj.dc_flg.checked = true ;
						else
							formObj.dc_flg.checked = false ;
					}
					
									
					//버튼활성화
					searcgBySelect();
					
					//하단 그리드 데이터 만드는 메서드 호출.
					createData();

        		}
        		break;
						
			case COMMAND01 :
				if( validateForm(sheetObj,formObj,sAction) ){
					
					var checked = 0;
					for (var i = 2 ; i <= sheetObj.RowCount +1 ; i++){
						if( sheetObj.CellValue(i,1) == '1' ){
							checked = i;
							break;
						}
					}
					if ( checked == 0 ) {
						ComShowCodeMessage('BKG00249');
					} else {
						ComOpenWindow2("ESM_BKG_0124.do?vvd=" + formObj.vvd.value + "&bl_no=" + sheetObj.CellValue(checked,3) + "&whf_bnd_cd=" + formObj.whf_bnd_cd.value, "", "width=900, height=630");
					}
				} 
				break;
			case COMMAND02 :
				if( validateForm(sheetObj,formObj,sAction) ){
					
					ComOpenWindow2("ESM_BKG_0125.do?vvd=" + formObj.vvd.value 
							                              + "&port_cd=" + formObj.port_cd.value 
							                              + "&whf_bnd_cd=" + formObj.whf_bnd_cd.value 
							                              + "&mrn_no=" + formObj.mf_ref_no.value, "", "width=400, height=480");
				} 
				break;
				
			case COMMAND07 :
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWindow2("ESM_BKG_0129.do?vvd=" + formObj.vvd.value 
							+ "&port_cd=" + formObj.port_cd.value 
							+ "&whf_bnd_cd=" + formObj.whf_bnd_cd.value 
							+ "&mrn_no=" + formObj.mf_ref_no.value, "", "width=500, height=480");
				} 
				break;
				
			case COMMAND03: 
				if( validateForm(sheetObj,formObj,sAction) ){
					var checked = 0;
					for (var i = 2 ; i <= sheetObj.RowCount +1 ; i++){
						if( sheetObj.CellValue(i,1) == '1' ){
							checked = i;
							break;
						}
    				}
					if ( checked != 0 ){
						ComOpenWindow2("ESM_BKG_0123.do?popup=y&vvd=" + formObj.vvd.value 
	                            + "&port_cd="    + formObj.port_cd.value 
	                            + "&whf_bnd_cd=" + formObj.whf_bnd_cd.value 
	                            + "&whf_rate="   + sheetObj.CellValue(checked,28)
	                            + "&bl_no="   	 + sheetObj.CellValue(checked,3)
	                            + "&bkg_no="   	 + sheetObj.CellValue(checked,33), "ESM_BKG_0123", "width=800, height=510");
					}else {
						ComOpenWindow2("ESM_BKG_0123.do?popup=y&vvd=" + formObj.vvd.value 
	                            + "&port_cd="    + formObj.port_cd.value 
	                            + "&whf_rate="   + sheetObj.CellValue(3,28)
	                            + "&whf_bnd_cd=" + formObj.whf_bnd_cd.value , "ESM_BKG_0123", "width=800, height=510");
					}
					
				} 
				break; 	
			case MULTI:        //저장
				if( validateForm(sheetObj,formObj,sAction) ){
					
					formObj.f_cmd.value = MULTI;
				    if (! sheetObjects[0].IsDataModified ){
				    	ComShowCodeMessage('BKG00233');
	    	        	return;
	    	        }

					ComOpenWait(true);
				    var sParam = ComGetSaveString(sheetObjects);
				    
	    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");

	    	        var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0122GS.do", sParam);
	    	        sheetObj.LoadSaveXml(SaveXml);
	    	        ComOpenWait(false);
				}    
    	    break;
			case COMMAND04:        //저장
				if( validateForm(sheetObj,formObj,sAction) ){
					
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					
					formObj.f_cmd.value = COMMAND05;
					var sParam = sheetObjects[0].GetSaveString(true);
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0122GS.do", sParam);
					if( ComBkgErrMessage(sheetObj, SaveXml) ){
						ComShowCodeMessage('BKG00204');
					}else{
						ComShowCodeMessage('BKG00205');
					}
					ComOpenWait(false);
					
				}    
				break;
			case COMMAND05:        //저장
				if( validateForm(sheetObj,formObj,sAction) ){
					
					
					ComOpenWait(true);
					formObj.f_cmd.value = COMMAND05;
					var sParam = sheetObjects[0].GetSaveString(false, true, "sheet1_Chk");
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0122GS.do", sParam);
					if( ComBkgErrMessage(sheetObj, SaveXml) ){
						ComShowCodeMessage('BKG00204');
					}else{
						ComShowCodeMessage('BKG00205');
					}
					ComOpenWait(false);
				}    
				break;
			case COMMAND06: 
				if( validateForm(sheetObj,formObj,sAction) ){
					var bizNoObject = ComOpenWindowCenter('/hanjin/ESM_BKG_0738.do?pgmNo=ESM_BKG_0738&country=KR&popup=Y', 'SearchBizNo' ,600,400, true);
					if (bizNoObject) {
						sheetObjects[0].CellValue2(vFreeRow, vFreeCol) = bizNoObject.vRgstNo.substring(0,3) + "-" +
																		 bizNoObject.vRgstNo.substring(3,5) + "-" +
																		 bizNoObject.vRgstNo.substring(5);
					}
				} 
				break; 		
			case IBDELETE:      // 삭제
				var checked = 0;
				for (var i = 2 ; i <= sheetObj.RowCount +1 ; i++){
					if( sheetObj.CellValue(i,1) == '1' ){
						checked = 1;
						if (sheetObj.CellValue(i,0) != "I"){
							//if( sheetObj.CellValue(i,1) == '1' ){
								sheetObj.RowHidden( i ) = true;
								sheetObj.RowStatus( i ) = "D";
							//}
						}else{
							//if( sheetObj.CellValue(i,1) == '1' ){
								sheetObj.RowStatus( i ) = "U";
								sheetObj.RowStatus( i ) = "D";
								i--;
							//}
						}
					}	
				}
				if ( checked == 0 ) ComShowCodeMessage('BKG00249');
			
			break;
			case IBDOWNEXCEL:
				if( sheetObj.RowCount > 0 )
					sheetObjects[0].SpeedDown2Excel(-1);      //숨겨진 데이터는 제외하고 내려 받기
				else
					ComShowCodeMessage('BKG00389');
				
			break;	
		
        }
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
     	
    	var vvd       = formObj.vvd.value;
    	var vpsPortCd = formObj.port_cd.value;
    	var ioBndCd   = formObj.whf_bnd_cd.value;
    	
    	switch (sAction) {
     		case SEARCH01:
     			
     			if( ComChkLen(vvd, 9) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'vvd');
     				formObj.vvd.focus();
     				return false;
     			}
     			
     			if( ComChkLen(vpsPortCd, 5) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'Port');
     				formObj.vps_port_cd.focus();
     				return false;
     			} 
     			
     			return true;
     			break;
     	
     		case SEARCH:
     			if ( ComChkLen(vvd, 9) != "2") {
     				ComShowCodeMessage('BKG00887', 'VVD');
     				return false;
     			}
     			if( ComChkLen(vpsPortCd, 5) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'Port');
     				return false;
     			}
     			return true;
     			break;
     		
	 		case MULTI: // 저장
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			
	 			return true;
	 			break;
	 		case COMMAND01: // Rate Inquiry
	 			return true;
	 			break;
	 		case COMMAND02: // Bl Check
	 			return true;
	 			break;
	 		case COMMAND07: // Bkg Check
	 			return true;
	 			break;
	 		case COMMAND03: // 화면 초기화
	 			return true;
     		break;
	 		case COMMAND04: // 저장
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			
	 			return true;
	 			break;
	 		case COMMAND05: // 저장
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			
	 			return true;
	 			break;	
	 		case COMMAND06: // 저장
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			
	 			return true;
	 			break;	
	 		
     	}
     }
    
    /**
     * 콤마가 있는 숫자형에서 콤마를 제거하고 실수형으로 반환한다.
     * @param targetNum
     * @return
     */
    function parseFloatWithoutComma( targetNum ){
    	return parseFloat( targetNum.split(",").join("") );
    }
    
    /**
     * 데이터를 가공하는 메서드.
     * 
     * @return
     */
    function createData(){
    	var prefix2 = 'sheet2_';
		var prefix1 = 'sheet1_';	
		var formObj = document.form; 
		var vBndCd  = formObj.whf_bnd_cd.value ;
    	if( sheetObjects[0].RowCount > 0 ) {	
			
			/*
			 * 상단그리드 오른쪽 3개의 컬럼 생성
			 */
			var totalAmt = 0;
			var total20Qty = 0;
			var total40Qty = 0;
			var total45Qty = 0;
			var rtonWgt = 0;
			var expt_ton_wgt = 0;
			
			
			for(var i=2; i<=sheetObjects[0].RowCount+1; i++){
				
				totalAmt = totalAmt + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_amt') );
				//totalAmt = totalAmt + sheetObjects[0].CellValue(i,'sheet1_whf_amt');
				
//				total20Qty = total20Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_20ft_qty') ) +  parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_blk_20ft_qty') );
//				total40Qty = total40Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_40ft_qty') ) +  parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_blk_40ft_qty') );
//				total45Qty = total45Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_45ft_qty') ) +  parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_blk_45ft_qty') );
				
				total20Qty = total20Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_20ft_qty'));
				total40Qty = total40Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_40ft_qty'));
				total45Qty = total45Qty + parseFloat( sheetObjects[0].CellValue(i,'sheet1_whf_cntr_45ft_qty'));
				
				if( sheetObjects[0].CellValue(i, prefix1 + 'wfg_expt_cd') == ''  || 
					sheetObjects[0].CellValue(i, prefix1 + 'wfg_expt_cd') == 'N' ||
					sheetObjects[0].CellValue(i, prefix1 + 'wfg_expt_cd') == 'B'    ){ // 면제 사유가 없는
					rtonWgt      = rtonWgt + parseFloat( sheetObjects[0].CellValue(i,'sheet1_rton_wgt') );
				} else {	                                                        // 면제 사유가 있는
					expt_ton_wgt = expt_ton_wgt + parseFloat( sheetObjects[0].CellValue(i,'sheet1_rton_wgt') );
				}	
			}
			
			/*
			 * 중간 부분의 폼데이터 생성
			 */
			formObj.total_bl_count.value = sheetObjects[0].RowCount ;
			formObj.total_wharfage.value = CommaInputWithPoint(sheetObjects[0].CellValue(2,'sheet1_whf_rt'), 2 );
			formObj.whf_rt_amt.value     =  ComGetMaskedValue( ComTrunc( String( totalAmt ), 0), 'int' ) ;  //CommaInputWithPoint( String( totalAmt ), 3);//CommaInputWithPoint( String( sheetObjects[0].SumValue(3,'sheet1_whf_amt') ), 3 );
			
//			formObj.rtotal1.value = parseFloat(total20Qty).toFixed(3);
//			formObj.rtotal2.value = parseFloat(total40Qty).toFixed(3);
//			formObj.rtotal3.value = parseFloat(total45Qty).toFixed(3);
			
			formObj.rtotal1.value = ComRound(total20Qty, 3);
			formObj.rtotal2.value = ComRound(total40Qty, 3);
			formObj.rtotal3.value = ComRound(total45Qty, 3);
			
			formObj.rton_wgt.value     = rtonWgt;
			formObj.expt_ton_wgt.value = expt_ton_wgt;
			/*
			 * 하단 그리드 생성
			 */
			if( sheetObjects[1].RowCount < 3 ){
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].CellValue2(2, prefix2 + 'division') = '20' ;
				sheetObjects[1].CellValue2(3, prefix2 + 'division') = '40' ;
				sheetObjects[1].CellValue2(4, prefix2 + 'division') = '45' ;
			}
			// 부과 대상
			var levy_division_20 = 0;
			var levy_division_40 = 0;
			var levy_division_45 = 0;
			// 정정대상
			var correction_division_20 = 0;
			var correction_division_40 = 0;
			var correction_division_45 = 0;
			// 효성
//			var hyosung_division_20 = 0;
//			var hyosung_division_40 = 0;
//			var hyosung_division_45 = 0;
//			// 대우
//			var daewoo_division_20 = 0;
//			var daewoo_division_40 = 0;
//			var daewoo_division_45 = 0;
			// 동부제강
			var dongbu_division_20 = 0;
			var dongbu_division_40 = 0;
			var dongbu_division_45 = 0;
			// 현대
			var hyundai_division_20 = 0;
			var hyundai_division_40 = 0;
			var hyundai_division_45 = 0;
			// 동국
			var donguk_division_20 = 0;
			var donguk_division_40 = 0;
			var donguk_division_45 = 0;
			// T/S
			var ts_division_20 = 0;
			var ts_division_40 = 0;
			var ts_division_45 = 0;
			// IPO
			var ipo_division_20 = 0;
			var ipo_division_40 = 0;
			var ipo_division_45 = 0;
			// military
			var military_division_20 = 0;
			var military_division_40 = 0;
			var military_division_45 = 0;
			// government
			var government_division_20 = 0;
			var government_division_40 = 0;
			var government_division_45 = 0;
			// mty
			var mty_division_20 = 0;
			var mty_division_40 = 0;
			var mty_division_45 = 0;
			// sum
			var sum_division_20 = 0;
			var sum_division_40 = 0;
			var sum_division_45 = 0;
			// totamount
			var totamount_division_20 = 0;
			var totamount_division_40 = 0;
			var totamount_division_45 = 0;
			// correctionamt
			var correctionamt_division_20 = 0;
			var correctionamt_division_40 = 0;
			var correctionamt_division_45 = 0;
			// bulk_rton
			var bulk_rton_division_20 = 0;
			var bulk_rton_division_40 = 0;
			var bulk_rton_division_45 = 0;
			// bulk_rate
			var bulk_rate_division_20 = 0;
			var bulk_rate_division_40 = 0;
			var bulk_rate_division_45 = 0;
			// bulk_amount
			var bulk_amount_division_20 = 0;
			var bulk_amount_division_40 = 0;
			var bulk_amount_division_45 = 0;
			
			for( var i=0; i< sheetObjects[0].RowCount; i++ ){
				
				// "Grid_1에 조회된 20', 40', 45' 별 면제 사유가 없는 Container Qty와 CNTR Bulk QTY의 합계"
				if( sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == ''  || 
					sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'N' ||
					sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'B'){
					
//					levy_division_20 = levy_division_20 + (    parseFloat((sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')).split(",").join("")) 
//							                                 + parseFloat((sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_20ft_qty')).split(",").join("")) );
//					levy_division_40 = levy_division_40 + ( parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty').split(",").join("")) 
//												            +  parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_40ft_qty').split(",").join("")) );
//					levy_division_45 = levy_division_45 + ( parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty').split(",").join("")) 
//												        + parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_45ft_qty').split(",").join(""))  );
					
					
					levy_division_20 = levy_division_20 + ( parseFloat((sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')).split(",").join("")));
					levy_division_40 = levy_division_40 + ( parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty').split(",").join("")) );
					levy_division_45 = levy_division_45 + ( parseFloat(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty').split(",").join("")) );
					
					
				}
				//"Grid_1에 조회된  Amount가 20', 40', 45' 별  0 보다 작고 B/L 신고 Type이 T 나 R이 아닌 Container Qty와 CNTR Bulk QTY의 합계"
				
				if(  sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt') < 0 
						&& sheetObjects[0].CellValue(i+2, prefix1 + 't') != 'T' 
							&& sheetObjects[0].CellValue(i+2, prefix1 + 't') != 'R'){
					
					correction_division_20 = correction_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')) 
							+ parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_20ft_qty')));
					correction_division_40 = correction_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')) 
							+ parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_40ft_qty')));
					correction_division_45 = correction_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')) 
							+ parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_blk_45ft_qty')));
					
				}
				
				//Grid_1에 조회된 규격별 면제 화주 "효성(105-81-59519)"의 Container Qty 합계
//				if( sheetObjects[0].CellValue(i+2, prefix1 + 'cust_rgst_no')  == '105-81-59519' ){
//					hyosung_division_20 = hyosung_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')));
//					hyosung_division_40 = hyosung_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
//					hyosung_division_45 = hyosung_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
//				}
////				Grid_1에 조회된 규격별 면제 화주 "대우(401-85-04303 또는 401-85-08615)"의 Container Qty 합계
//				var tempFree1 = sheetObjects[0].CellValue(i+2, prefix1 + 'cust_rgst_no') ;
//				if( tempFree1 == '401-85-04303' || tempFree1 == '401-85-08615' ){
//					daewoo_division_20 = daewoo_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
//					daewoo_division_40 = daewoo_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
//					daewoo_division_45 = daewoo_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
//				}
//				Grid_1에 조회된 규격별 면제 화주 "동부(137-85-00522)"의 Container Qty 합계
				var tempFree2 = sheetObjects[0].CellValue(i+2, prefix1 + 'cust_rgst_no') ;
				if( tempFree2 == '137-85-00522' && sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'S'){
					dongbu_division_20 = dongbu_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
					dongbu_division_40 = dongbu_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
					dongbu_division_45 = dongbu_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
				}
				
//				Grid_1에 조회된 규격별 면제 화주 "현대하이스코(416-85-06244)"의 물량 합계
				var tempFree3 = sheetObjects[0].CellValue(i+2, prefix1 + 'cust_rgst_no') ;
				if( tempFree3 == '416-85-06244' && sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'S'){
					hyundai_division_20 = hyundai_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
					hyundai_division_40 = hyundai_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
					hyundai_division_45 = hyundai_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
				}
//				Grid_1에 조회된 규격별 면제 화주 "동국제강(506-85-03346)"의 Container Qty 합계
				var tempFree4 = sheetObjects[0].CellValue(i+2, prefix1 + 'cust_rgst_no') ;
				if( tempFree4 == '506-85-03346' && sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'S'){
					donguk_division_20 = donguk_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
					donguk_division_40 = donguk_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
					donguk_division_45 = donguk_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
				}
				/*
			 	Grid_1에 조회된 규격별 WHF 면제 사유가 T/S인 Container Qty 합계
			 	[참고]
			 	"일반=>Z
				Bulk=>B
				Exempt SHPR=>S
				IPO=>I
				Incl.OFT=>N
				MTY CNTR=>D
				Military=>J
				T/S=>X
				조달청=>K"
				*/
				if( sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'X' ){
					ts_division_20 = ts_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
					ts_division_40 = ts_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
					ts_division_45 = ts_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
				}
//				Grid_1에 조회된 규격별 WHF 면제 사유가 IPO인 Container Qty 합계
				if( sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'I' ){
					ipo_division_20 = ipo_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
					ipo_division_40 = ipo_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
					ipo_division_45 = ipo_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
				}
//				Grid_1에 조회된 규격별 WHF 면제 사유가 Military인 Container Qty 합계
				if( sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'J' ){
					military_division_20 = military_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
					military_division_40 = military_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
					military_division_45 = military_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
				}
//				Grid_1에 조회된 규격별 WHF 면제 사유가 조달청인 Container Qty 합계
				if( sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'K' ){
					government_division_20 = government_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
					government_division_40 = government_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
					government_division_45 = government_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
				}
//				Grid_1에 조회된 규격별 WHF 면제 사유가 Empty인 Container Qty
				if( sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'D' ){
					mty_division_20 = mty_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty'))); 
					mty_division_40 = mty_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty'))); 
					mty_division_45 = mty_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty'))); 
				}
//				"Grid_1에 조회된 규격별 WHF 금액 합계  20', 40', 45' 별 Container QTY * 20', 40', 45'별 Container Wharfage 단가"

				var cntr_20ft_amt = 0;
				var cntr_40ft_amt = 0;
				var cntr_45ft_amt = 0;
				
				if (sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == ''  || 
					sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'N' ||
					sheetObjects[0].CellValue(i+2, prefix1 + 'wfg_expt_cd') == 'B' )
				{
					cntr_20ft_amt = ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')) 
							* parseFloatWithoutComma(formObj.kr_whf_cntr_20ft_rt.value ));
					cntr_40ft_amt = ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')) 
							* parseFloatWithoutComma(formObj.kr_whf_cntr_40ft_rt.value ));
					cntr_45ft_amt = ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')) 
							* parseFloatWithoutComma(formObj.kr_whf_cntr_45ft_rt.value ));
				}
				
				totamount_division_20 = totamount_division_20 + cntr_20ft_amt;
				totamount_division_40 = totamount_division_40 + cntr_40ft_amt;
				totamount_division_45 = totamount_division_45 + cntr_45ft_amt;
				
				
//				totamount_division_20 = totamount_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')) 
//						* parseFloatWithoutComma(formObj.kr_whf_cntr_20ft_rt.value ));
//				totamount_division_40 = totamount_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')) 
//						* parseFloatWithoutComma(formObj.kr_whf_cntr_40ft_rt.value ));
//				totamount_division_45 = totamount_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')) 
//						* parseFloatWithoutComma(formObj.kr_whf_cntr_45ft_rt.value));
				
				
				
//				totamount_division_20 = totamount_division_20 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
//				totamount_division_40 = totamount_division_40 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
//				totamount_division_45 = totamount_division_45 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 

//				"Grid_1에 조회된 20', 40', 45' 별	0 보다 작고 B/L 신고 Type이 T 나 R이 아닌  Container Qty와 * 20', 40', 45'별 Container Wharfage 단가"
				
				if(  sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt') < 0 
						&& sheetObjects[0].CellValue(i+2, prefix1 + 't') != 'T' 
							&& sheetObjects[0].CellValue(i+2, prefix1 + 't') != 'R'){
					
					correctionamt_division_20 = correctionamt_division_20 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_20ft_qty')) 
							* parseFloatWithoutComma(formObj.kr_whf_cntr_20ft_rt.value) );
					correctionamt_division_40 = correctionamt_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_40ft_qty')) 
							* parseFloatWithoutComma(formObj.kr_whf_cntr_40ft_rt.value) );
					correctionamt_division_45 = correctionamt_division_45 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_cntr_45ft_qty')) 
							* parseFloatWithoutComma(formObj.kr_whf_cntr_45ft_rt.value) );
//					correctionamt_division_20 = correctionamt_division_20 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
//					correctionamt_division_40 = correctionamt_division_40 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
//					correctionamt_division_45 = correctionamt_division_45 + parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'whf_amt')); 
					
				}
//				"[Grid_2.구분 = ""20'"" OR Grid_2.구분 = ""45'"" ] {
//				   0
//			     }
//			     [Grid_2.구분 = ""45'""] {
//			         Grid_1.Bulk Rton의 합계
//		     	 }"
				bulk_rton_division_20 = 0;
				bulk_rton_division_40 = bulk_rton_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'rton_wgt'))); 
				bulk_rton_division_45 = 0;

				/*
				 * "[Grid_2.구분 = ""20'"" OR Grid_2.구분 = ""45'"" ] {
					   0
					}
					[Grid_2.구분 = ""45'""] {
					   Unit_Rate_Form.Bulk Rate
					}"
				 */
				bulk_rate_division_20 = 0;
				bulk_rate_division_40 = formObj.kr_whf_blk_rt.value;
				bulk_rate_division_45 = 0;
				
				/*
				   "[Grid_2.구분 = ""20'"" OR Grid_2.구분 = ""45'"" ] {
					   0
					}
					[Grid_2.구분 = ""45'""] {
					   Grid_1.Bulk Wharfage Amount의 합계
					}"
				 */
				bulk_amount_division_20 = 0;
				bulk_amount_division_40 = bulk_amount_division_40 + ( parseFloatWithoutComma(sheetObjects[0].CellValue(i+2, prefix1 + 'bulk_wharfage_amount')));
				bulk_amount_division_45 = 0;
			}	
				
//			Grid_1에 조회된 규격별 WHF 면제 물량 합계 (면제 화주 ~ MTY)
			sum_division_20 =  //hyosung_division_20 
			                 //+ daewoo_division_20 
			                 dongbu_division_20 
			                 + hyundai_division_20 
			                 + donguk_division_20
			                 + ts_division_20 
			                 + ipo_division_20 
			                 + military_division_20 
			                 + government_division_20 
			                 + mty_division_20;
			sum_division_40 =  //hyosung_division_40 
			                 //+ daewoo_division_40 
			                 dongbu_division_40 
			                 + hyundai_division_40 
			                 + donguk_division_40
			                 + ts_division_40 
			                 + ipo_division_40 
			                 + military_division_40 
			                 + government_division_40 
			                 + mty_division_40;
			sum_division_45 =  //hyosung_division_45 
			                 //+ daewoo_division_45 
			                 dongbu_division_45 
			                 + hyundai_division_45 
			                 + donguk_division_45
			                 + ts_division_45 
			                 + ipo_division_45 
			                 + military_division_45 
			                 + government_division_45 
			                 + mty_division_45; 
				
				
				
			}
    	
			//부과대상
    		if( 'IT' != vBndCd ) {
				sheetObjects[1].CellValue2(2, prefix2 + 'levy') = levy_division_20 ;
				sheetObjects[1].CellValue2(3, prefix2 + 'levy') = levy_division_40 ;
				sheetObjects[1].CellValue2(4, prefix2 + 'levy') = levy_division_45 ;
    		} else {
    			sheetObjects[1].CellValue2(2, prefix2 + 'levy') = '0' ;
    			sheetObjects[1].CellValue2(3, prefix2 + 'levy') = '0' ;
    			sheetObjects[1].CellValue2(4, prefix2 + 'levy') = '0' ;
    		}
			//정정대상
			sheetObjects[1].CellValue2(2, prefix2 + 'correction') = correction_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'correction') = correction_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'correction') = correction_division_45 ;
			//효성
//			sheetObjects[1].CellValue2(2, prefix2 + 'hyosung') = hyosung_division_20 ;
//			sheetObjects[1].CellValue2(3, prefix2 + 'hyosung') = hyosung_division_40 ;
//			sheetObjects[1].CellValue2(4, prefix2 + 'hyosung') = hyosung_division_45 ;
//			//대우
//			sheetObjects[1].CellValue2(2, prefix2 + 'daewoo') = daewoo_division_20 ;
//			sheetObjects[1].CellValue2(3, prefix2 + 'daewoo') = daewoo_division_40 ;
//			sheetObjects[1].CellValue2(4, prefix2 + 'daewoo') = daewoo_division_45 ;
			//동부
			sheetObjects[1].CellValue2(2, prefix2 + 'dongbu') = dongbu_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'dongbu') = dongbu_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'dongbu') = dongbu_division_45 ;
			//현대
			sheetObjects[1].CellValue2(2, prefix2 + 'hyundai') = hyundai_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'hyundai') = hyundai_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'hyundai') = hyundai_division_45 ;
			//동국
			sheetObjects[1].CellValue2(2, prefix2 + 'donguk') = donguk_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'donguk') = donguk_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'donguk') = donguk_division_45 ;
			//TS
			if( 'IT' != vBndCd ) {
				sheetObjects[1].CellValue2(2, prefix2 + 'ts') = ts_division_20 ;
				sheetObjects[1].CellValue2(3, prefix2 + 'ts') = ts_division_40 ;
				sheetObjects[1].CellValue2(4, prefix2 + 'ts') = ts_division_45 ;
			} else {
				sheetObjects[1].CellValue2(2, prefix2 + 'ts') = levy_division_20 ;
				sheetObjects[1].CellValue2(3, prefix2 + 'ts') = levy_division_40 ;
				sheetObjects[1].CellValue2(4, prefix2 + 'ts') = levy_division_45 ;
			}
			//IPO
			sheetObjects[1].CellValue2(2, prefix2 + 'ipo') = ipo_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'ipo') = ipo_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'ipo') = ipo_division_45 ;
			//military
			sheetObjects[1].CellValue2(2, prefix2 + 'military') = military_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'military') = military_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'military') = military_division_45 ;
			//government
			sheetObjects[1].CellValue2(2, prefix2 + 'government') = government_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'government') = government_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'government') = government_division_45 ;
			//mty
			sheetObjects[1].CellValue2(2, prefix2 + 'mty') = mty_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'mty') = mty_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'mty') = mty_division_45 ;
			//sum
			sheetObjects[1].CellValue2(2, prefix2 + 'sum') = sum_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'sum') = sum_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'sum') = sum_division_45 ;
			//totamount
			sheetObjects[1].CellValue2(2, prefix2 + 'totamount') = totamount_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'totamount') = totamount_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'totamount') = totamount_division_45 ;
			//correctionamt
			sheetObjects[1].CellValue2(2, prefix2 + 'correctionamt') = correctionamt_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'correctionamt') = correctionamt_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'correctionamt') = correctionamt_division_45 ;
			//bulk_rton
			sheetObjects[1].CellValue2(2, prefix2 + 'bulk_rton') = bulk_rton_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'bulk_rton') = bulk_rton_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'bulk_rton') = bulk_rton_division_45 ;
			//bulk_rate
			sheetObjects[1].CellValue2(2, prefix2 + 'bulk_rate') = bulk_rate_division_20 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'bulk_rate') = bulk_rate_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'bulk_rate') = bulk_rate_division_45 ;
			//bulk_amount
			sheetObjects[1].CellValue2(2, prefix2 + 'bulk_amount') = 0 ;
			sheetObjects[1].CellValue2(3, prefix2 + 'bulk_amount') = bulk_amount_division_40 ;
			sheetObjects[1].CellValue2(4, prefix2 + 'bulk_amount') = 0 ;
			
    }
    
    /**
     * 첫번째 시트 값이 변동이 있을때 가공데이터를 다시 만든다.
     * 
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){    	 
    	var prefix1 = 'sheet1_';
    	// 면제 화주 클릭시 금액 "0원"으로 세팅
//    	if( Col == 12 ){
//    		if( '' != Value  && 'N' != Value && 'B' != Value)
//    			sheetObj.CellValue2(Row, prefix1+"whf_amt") = 0;
//    		else
//    			sheetObj.CellValue2(Row, prefix1+"whf_amt") = sheetObj.CellValue(Row, prefix1+"whf_amt_temp");   		
//    	}
    	// Container Qty 에서 20' 40' 45' 값이 변경 되었을시에...
    	// Cntr Bulk Qty 에서 Weight 와  Measure 의 값이 변경되었을시에...Amount는 직접 수정 불가.
    	var Colnm = sheetObj.ColSaveName(Col);
    	
    	if(  Colnm == 'sheet1_whf_amt' || Colnm == 'sheet1_whf_cntr_20ft_qty' || Colnm == 'sheet1_whf_cntr_40ft_qty' || 
    		 Colnm == 'sheet1_whf_cntr_45ft_qty' || Colnm == 'sheet1_blk_wgt_qty' || Colnm == 'sheet1_blk_meas_qty'){
    		
    		if ( 'BLK' == sheetObj.CellValue(Row, prefix1 + 'whf_pck_tp_cd'))
    		{
    			sheetObj.CellValue2(Row, prefix1 + 'whf_amt') = Math.round(accountForBulkAmt(sheetObj, Row, Col, Value)) + Math.round(accountForWhfAmt(sheetObj, Row, Col, Value));	
    		}
    		else
    		{
    			sheetObj.CellValue2(Row, prefix1 + 'whf_amt') = Math.round(accountForWhfAmt(sheetObj, Row, Col, Value));	
    		}
    	}
    	// CNT/BLK 선택박스 변경시에 아래와 같은 처리를 해주고 AMOUT 를 계산한다.
    	if( Col == 27 ){
    		//if('BLK' == Value){
    		if('BLK' == sheetObj.CellValue(Row, prefix1 + 'whf_pck_tp_cd')){
    			sheetObj.CellValue2(Row, prefix1 + 'whf_blk_20ft_qty') = sheetObj.CellValue(Row, prefix1 + 'whf_cntr_20ft_qty');
    			sheetObj.CellValue2(Row, prefix1 + 'whf_blk_40ft_qty') = sheetObj.CellValue(Row, prefix1 + 'whf_cntr_40ft_qty');
    			sheetObj.CellValue2(Row, prefix1 + 'whf_blk_45ft_qty') = sheetObj.CellValue(Row, prefix1 + 'whf_cntr_45ft_qty'); 
    			sheetObj.CellValue2(Row, prefix1 + 'whf_cntr_20ft_qty') = 0;
    			sheetObj.CellValue2(Row, prefix1 + 'whf_cntr_40ft_qty') = 0;
    			sheetObj.CellValue2(Row, prefix1 + 'whf_cntr_45ft_qty') = 0;
    			//sheetObj.CellValue2(Row, prefix1+'blk_wgt_qty')  = sheetObj.CellValue(Row, prefix1+'blk_wgt_qty2');
    			//sheetObj.CellValue2(Row, prefix1+'blk_meas_qty') = sheetObj.CellValue(Row, prefix1+'blk_meas_qty2');
    			sheetObj.CellValue2(Row, prefix1+'blk_wgt_qty')  = sheetObj.CellValue(Row, prefix1+'wgt_qty');
    			sheetObj.CellValue2(Row, prefix1+'blk_meas_qty') = sheetObj.CellValue(Row, prefix1+'meas_qty');
    			
    			
    		}else{
    			sheetObj.CellValue2(Row, prefix1 + 'whf_cntr_20ft_qty') = sheetObj.CellValue(Row, prefix1 + 'whf_blk_20ft_qty');
    			sheetObj.CellValue2(Row, prefix1 + 'whf_cntr_40ft_qty') = sheetObj.CellValue(Row, prefix1 + 'whf_blk_40ft_qty');
    			sheetObj.CellValue2(Row, prefix1 + 'whf_cntr_45ft_qty') = sheetObj.CellValue(Row, prefix1 + 'whf_blk_45ft_qty');
    			sheetObj.CellValue2(Row, prefix1 + 'whf_blk_20ft_qty') = 0;
    			sheetObj.CellValue2(Row, prefix1 + 'whf_blk_40ft_qty') = 0;
    			sheetObj.CellValue2(Row, prefix1 + 'whf_blk_45ft_qty') = 0;
    			sheetObj.CellValue2(Row, prefix1+'blk_wgt_qty') = 0;
    			sheetObj.CellValue2(Row, prefix1+'blk_meas_qty') = 0;
    			
    			
    		}
    		
    		
    		
//    		sheetObj.CellValue2(Row, prefix1 + 'whf_amt') 
//    		= Math.round( accountForWhfAmt(sheetObj, Row, Col, Value) + accountForBulkAmt(sheetObj, Row, Col, Value) );
//    		
//    		if( 'BLK' != Value )
//    			sheetObj.CellValue2(Row, prefix1+'bulk_rton_appl_type') = '';

    	}
    		
    	if ( 'BLK' == sheetObj.CellValue(Row,prefix1 + 'whf_pck_tp_cd'))
    	{
			sheetObj.CellValue2(Row, prefix1 + 'whf_amt') = Math.round(accountForBulkAmt(sheetObj, Row, Col, Value)) + Math.round(accountForWhfAmt(sheetObj, Row, Col, Value));	
    	}
    	else
    	{
    		sheetObj.CellValue2(Row, prefix1 + 'rton_wgt') = 0;
    		sheetObj.CellValue2(Row, prefix1 + 'bulk_wharfage_amount') = 0;
    		sheetObj.CellValue2(Row, prefix1 + 'whf_amt') = Math.round( accountForWhfAmt(sheetObj, Row, Col, Value));
    	}
    		
		if( 'BLK' != sheetObj.CellValue(Row, prefix1 + 'whf_pck_tp_cd') )
			sheetObj.CellValue2(Row, prefix1+'bulk_rton_appl_type') = '';
    	
    	
    	if ( document.form.whf_bnd_cd.value == 'IT' || document.form.whf_bnd_cd.value == 'OT')
    	{
    		sheetObj.CellValue2(Row, prefix1 + 'whf_amt') = 0;
    	}
    	
    	// 화면 하단 데이터 생성
    	if( Col != 1 ){
    		createData();
    	}
    }
    
    
    
    /**
     * CNTR Amount 값을 계산하는 메서드.
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function accountForWhfAmt(sheetObj, Row, Col, Value){
    	var prefix1 = 'sheet1_';
    	var formObj = document.form ;
    	var v20Amt  = 0;
    	var v40Amt  = 0;
    	var v45Amt  = 0;
    	
    	if(formObj.port_cd.value == "KRPTK"){
    		var v20Rt = Math.round(formObj.kr_whf_cntr_20ft_rt.value) ;
        	var v40Rt = Math.round(formObj.kr_whf_cntr_40ft_rt.value) ;
        	var v45Rt = Math.round(formObj.kr_whf_cntr_45ft_rt.value) ;
    	} else {
        	var v20Rt = formObj.kr_whf_cntr_20ft_rt.value ;
        	var v40Rt = formObj.kr_whf_cntr_40ft_rt.value ;
        	var v45Rt = formObj.kr_whf_cntr_45ft_rt.value ;    		
    	}
    	
    	v20Amt = parseFloatWithoutComma(sheetObj.CellValue(Row, prefix1 + 'whf_cntr_20ft_qty')) * v20Rt;
    	v40Amt = parseFloatWithoutComma(sheetObj.CellValue(Row, prefix1 + 'whf_cntr_40ft_qty')) * v40Rt;
    	v45Amt = parseFloatWithoutComma(sheetObj.CellValue(Row, prefix1 + 'whf_cntr_45ft_qty')) * v45Rt;
    	//sheetObj.CellValue2(Row, prefix1 + 'whf_amt') = v20Amt + v40Amt + v45Amt ;
    	if ( sheetObj.CellValue(Row,prefix1 + 'whf_amt') < 0 )
    	{
    		return sheetObj.CellValue(Row,11);
    	}
    	else if( '' != sheetObj.CellValue(Row, prefix1 + 'wfg_expt_cd')  && 'N' != sheetObj.CellValue(Row, prefix1 + 'wfg_expt_cd') && 'B' != sheetObj.CellValue(Row,prefix1 + 'wfg_expt_cd'))
    	{
			return 0;
    	}
		else
		{
			return v20Amt + v40Amt + v45Amt ;
		}
    }
    
    /**
     * BULK 의 AMOUNT 를 계산해주는 메서드.
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function accountForBulkAmt(sheetObj, Row, Col, Value){
    	var prefix1 = 'sheet1_';
    	var formObj = document.form ;
    	var vBlkRt = formObj.kr_whf_blk_rt.value ;
    	var vMRt = 0.883 ;
    	var vWgt = parseFloatWithoutComma(sheetObj.CellValue(Row, prefix1 + 'blk_wgt_qty')) ;
    	var vMes = parseFloatWithoutComma(sheetObj.CellValue(Row, prefix1 + 'blk_meas_qty')) ;
    	var vRton = 0 ;
    	if( vWgt >= vMes ) {
    		vRton = Math.ceil( vWgt );
    		sheetObj.CellValue2(Row, prefix1 + 'bulk_rton_appl_type') = "W";
    	} else {
    		vRton = Math.ceil( vMes * vMRt );
    		sheetObj.CellValue2(Row, prefix1 + 'bulk_rton_appl_type') = "E";
    	}
    	sheetObj.CellValue2(Row, prefix1 + 'rton_wgt') = vRton;
    	sheetObj.CellValue2(Row, prefix1 + 'bulk_wharfage_amount') = parseInt( vRton * vBlkRt ) ;
    	
    	return vRton * vBlkRt ;
    	
    }
    
    
    function sheet1_OnMouseDown(sheetObj, Button, Shifft, X, Y){
    	if( '2' == Button ){
    		var m_row = sheetObj.MouseRow;
    		var m_col = sheetObj.MouseCol;
    		vFreeRow = m_row ; 
    		
    		if( vFreeCol == m_col )
    		  doActionIBSheet(sheetObjects[0],document.form,COMMAND06);
    	}	
    }
    
    function addRowSheet1( BlNo ,BkgNo ,Vvd ,PolCd ,PodCd, WhfBndCd ){
    	var formObject = document.form;
/*    	var vWbndCd = WhfBndCd.substr(0,1);

    	if( 'I' == vWbndCd )
    		formObject.port_cd.value = PodCd;
    	else if( 'O' == vWbndCd  )
    		formObject.port_cd.value = PolCd;
    	formObject.whf_bnd_cd.value = WhfBndCd;*/
    	doActionIBSheet(sheetObjects[0],formObject,SEARCH01);
    }
    
    /**
     * 조회조건 바꿀때 시트 초기화
     * @return
     */
    function obj_Change() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	if (srcName == "whf_bnd_cd") {
    		sheetObjects[0].RemoveAll();
    		sheetObjects[1].RemoveAll();
    		formObject.total_bl_count.value = "";
    		formObject.total_wharfage.value = "";
    		formObject.whf_rt_amt.value = "";
    		formObject.rtotal1.value = "";
    		formObject.rtotal2.value = "";
    		formObject.rtotal3.value = "";
    	}
    }
    
    
	/* 개발자 작업  끝 */    