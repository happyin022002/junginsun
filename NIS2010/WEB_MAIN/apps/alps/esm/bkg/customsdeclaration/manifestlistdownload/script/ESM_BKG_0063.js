/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0063.js
 *@FileTitle : Customer Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.04.16 정재엽
 * 1.0 Creation
 * History
 * 2011.12.22 김경섭 [CHM-201115203]] [ESM-BKG] Manifest Transmit (CUSCAR) : B/L Inquiry(ESM_BKG_0045) 화면   전송 Flat File 생성시 C/M 정보 매핑 수정 - CM_PKG_CD: PKG_TP_CD >> CM_PKG_TP_CD로 수정 
=========================================================*/
/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
	 * @extends
	 * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무
	 *        스크립트를 정의한다.
	 */
    function esm_bkg_0063() {
    	
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnDblClick      = sheet1_OnDblClick;
    	
    }
    
    
    
   	/* 개발자 작업 */
    

    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var blNo = '' ;
    var kind = '' ;

    var comboObjects = new Array();
    var comboCnt = 0;

    /**
     * 콤보 Object를 comboObjects 배열에 등록
     * 
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
    }

    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		         var sheetObject1 = sheetObjects[0];
		         var sheetObject2 = sheetObjects[1]; 
		         var sheetObject4 = sheetObjects[3]; 
         /** **************************************************** */
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
				
				case "btn_new":
					sheetObject1.RemoveAll();
 					sheetObject2.RemoveAll();
					formObject.reset();
					formObject.pod.Index2 = 0;
				break;
				
				case "btn_downexcel":
					sheetObject1.SpeedDown2Excel(-1);
 					sheetObject2.SpeedDown2Excel(-1);
				break;							

				case "btn_cuscar":
					doActionIBSheet(sheetObject2,document.form,MULTI01);					
					break;
				break;							
				
				case "btn_view":
					doActionIBSheet(sheetObject2,document.form,MULTI02);
				break;				

				case "btn_transfer":
					doActionIBSheet(sheetObject4,document.form,MULTI03);
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
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }



    /**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는
	 * 기능을 추가한다
	 */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
				
        initControl();
	      //MultiCombo초기화 
 	    for(var k=0;k < comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }

        doActionIBSheet(sheetObjects[0], form, COMMAND11);
        if( document.form.vvd.value != '' ){
        	var formObject = document.form;
        	var vvdValue   = formObject.vvd.value;
        	var ssrNoValue = formObject.ssr_no.value;
        	document.form.f_cmd.value = SEARCH;
        	sheetObjects[2].DoSearch("ESM_BKG_0063GS.do?vvd="+vvdValue+"&ssr_no="+ssrNoValue, FormQueryString(document.form));
        	
        	vvdValue = sheetObjects[2].CellValue( 1, 2 );
        	ssrNoValue = sheetObjects[2].CellValue( 1, 3 );
        	var vvdNm  = sheetObjects[2].CellValue( 1, 4 );
        	var eta    = sheetObjects[2].CellValue( 1, 5 );

        	formObject.vvd.value      = vvdValue;
        	formObject.ssr_no.value   = ssrNoValue; 
        	formObject.vsl_name.value = vvdNm; 
        	formObject.eta.value      = eta;
        	
        	doActionIBSheet( sheetObjects[0], document.form, IBSEARCH );
        }
        
        if( document.form.popup.value == 'y' ){
        	//document.getElementById("navi").style.display = "none";
        	// document.getElementById("headtitle").innerHTML="<tr><td
			// class='title'><img src='img/icon_title_dot.gif'
			// align='absmiddle'><span id='title'></span></td></tr>"
        }
        
        
    }    
   

    function initControl() {
    	// 화면에서 필요한 이벤트
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
	/**
     * Combo Object 초기화
     * 
     * @param comboObj
     * @param comNo
     * @return
     */
    function initCombo(comboObj, comNo) {
    	switch (comboObj.id) {
    		case "pod":
    			with (comboObj) {
    				BackColor = "#CCFFFD";
    				Style = 1;//0 -편집 가능,1 -편집 불가능
    			}
    			break;
    	} // end switch
    }
        
    
    /**
	 * 조회조건 입력할 때 처리
	 */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	if (srcName == "vvd" || srcName == "ssr_no") {

        	var vvdValue   = formObject.vvd.value;
        	var ssrNoValue = formObject.ssr_no.value;
        	if (ComChkLen(vvdValue, 9) == "2" || ComChkLen(ssrNoValue, 6) == "2" ) {
        		document.form.f_cmd.value = SEARCH;
            	sheetObjects[2].DoSearch("ESM_BKG_0063GS.do?vvd="+vvdValue+"&ssr_no="+ssrNoValue, FormQueryString(document.form));
            	
            	vvdValue = sheetObjects[2].CellValue( 1, 2 );
            	ssrNoValue = sheetObjects[2].CellValue( 1, 3 );
            	var vvdNm  = sheetObjects[2].CellValue( 1, 4 );
            	var eta    = sheetObjects[2].CellValue( 1, 5 );

            	formObject.vvd.value = vvdValue;
            	formObject.ssr_no.value = ssrNoValue; 
            	formObject.vsl_name.value = vvdNm; 
            	formObject.eta.value = eta; 
            	
            	if(vvdValue != '')
            		formObject.pol_cd.focus();
            		
        	}
        	
    	}
	}
        
    /**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에
	 * 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
        	
        
        	case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 140;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

					          // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Seq.|POL|POL ATD|POD|BDR|BDR DATE|B/L|DNLD|ACPT|DIFF|CNTR|DNLD|ACPT|DIFF";

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,    daCenter,  false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,	 		 45,    daCenter,    true,     "SEQ",     		false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,    true,     "pol",     		false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData, 	155,   daCenter,    true,     "pol_atd",      false,    "",      dfUserFormat2, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter,    true,     "pod",       	false,    "",      dfNone, 		0,     false,		false);
                                                                                                                                                 
                    InitDataProperty(0, cnt++ , dtData,      55,    daCenter,    true,     "bdr",       	false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData, 	150,   daCenter,    true,     "bdr_date",       	false,    "",      dfUserFormat2, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtAutoSum,   45,    daRight,	   true,     "bl",      		false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtAutoSum, 	 55,    daRight,     true,     "dnld",      	false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,   55,    daRight,     true,     "acpt",       false,    "",      dfNone, 		0,     false,		false);
                                                  
                    InitDataProperty(0, cnt++ , dtAutoSum,   55,    daRight,     true,     "diff",       false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum, 	 55,    daRight,     true,     "cntr",       	false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtAutoSum,   55,    daRight,	   true,     "cntr_dnld",      	false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtAutoSum, 	 55,    daRight,     true,     "cntr_acpt",      	false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,   55,    daRight,     true,     "cntr_diff",       false,    "",      dfNone, 		0,     false,		false);

					InitUserFormat2(0, "pol_atd", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, "bdr_date", "####-##-## ##:##", "-|:" );

               }
                break;
                 

            case 2:      // sheet2 init
            	 with (sheetObj) {
            		// 높이 설정
                     style.height = 285;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge;

                    // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

 					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(64, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Seq.|Kind|B/L No.|A|A|S|Last EDI|Last EDI|CNTR|A|A|S|Last EDI|Last EDI|TS|POR|POL|POD|DEL|PRE|POST|BDR|PKG|PKG|WGT|WGT|Description|Notify Name||";

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
						// COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
						// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
						// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
						// FORMATFIX]

                     InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    daCenter,    true,     "sStatus");
                     InitDataProperty(0, cnt++ , dtData,			35,   daCenterTop,    true,     "seq");
                     InitDataProperty(0, cnt++ , dtCombo,			100,  daCenterTop,    true,      "kind",                false,    "",      dfNone,    0,     true,    true);
                     InitDataProperty(0, cnt++ , dtData,           100,  daCenterTop,    true,     "bl_no",               false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,           25,   daCenterTop,    true,     "bl_ack2",         	false,    "",      dfNone,    0,     false,   false);

                     InitDataProperty(0, cnt++ , dtHidden,         25,   daCenter,    true,     "bl_ack",              false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtCheckBox,       0,    daCenterTop,  	true,       "s1",                 false,    "",       dfNone,    0,     false,    false,      400,    false,      true,     "",     false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daCenterTop,    true,     "bl_last_edi2",       false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,    true,     "bl_last_edi",         false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          90,    daCenter,    true,     "cntr_no",             false,    "",      dfNone,    0,     false,   false);

                     InitDataProperty(0, cnt++ , dtData,          25,    daCenter,    true,     "cntr_ack2",          false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,        25,    daCenter,    true,     "cntr_ack",            false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtCheckBox,      25,    daCenter,    true,     "s2",                  false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "cntr_last_edi2",      false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,    true,     "cntr_last_edi",       false,    "",      dfNone,    0,     false,   false);

                     InitDataProperty(0, cnt++ , dtData,          35,    daCenter,    true,     "cntr_tpsz_cd",        false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "por_cd",              false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "pol_cd",              false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "pod_cd",              false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "del_cd",              false,    "",      dfNone,    0,     false,   false);

                     InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "pre_rly_port_cd",     false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "pst_rly_port_cd",     false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "bdr_flg",             false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          40,    daCenter,    true,     "cntr_pck_tp_cd",           false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daRight,     true,     "cntr_pck_qty",             false,    "",      dfNone,    0,     false,   false);

                     InitDataProperty(0, cnt++ , dtData,          40,    daCenter,    true,     "wgt_ut_cd",           false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          60,    daRight,     true,     "cntr_wgt_qty",         false,    "",      dfNone,    0,     false,   false);
                     
                     InitDataProperty(0, cnt++ , dtData,          250,   daLeft,      true,     "mf_desc",             false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtData,          180,   daLeft,      true,     "ntfy_name",           false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "svc_rqst_no",         false,    "",      dfNone,    0,     false,   false);
                                        
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cnee_addr",           false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "prev_docno",          false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cm_pck_qty",          false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "anr_msg_sts_cd",      false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "lloyd_cd",            false,    "",      dfNone,    0,     false,   false);
                                        
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "pagerows",            false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cntr_seq",            false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "brth_desc",           false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cntr_wgt_ut_cd",      false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "vvd_seq",             false,    "",      dfNone,    0,     false,   false);
                                                                   
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cntr_pck_tp_cd",      false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "rd_term",             false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "vvd",                 false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "bkg_no",              false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "ntfy_name",           false,    "",      dfNone,    0,     false,   false);
                                                                   
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "decl_flg",            false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "ibflag",              false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "act_wgt_ut_cd",       false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "shpr_addr",           false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cntr_mf_desc",        false,    "",      dfNone,    0,     false,   false);
                                                                   
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cm_cntr_no",          false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "anr_decl_no",         false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "ntfy_addr",           false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cntr_anr_msg_sts_cd", false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "act_wgt",             false,    "",      dfNone,    0,     false,   false);
                                                                   
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cm_pck_tp_cd",        false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "sequence",            false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cntr_pck_qty22",        false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "cntr_fm",             false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "msg_tp_cd",             false,    "",      dfNone,    0,     false,   false);

                     InitDataProperty(0, cnt++ , dtHidden,          180,   daLeft,      true,     "msg_seq",             false,    "",      dfNone,    0,     false,   false);
                     InitDataProperty(0, cnt++,  dtHidden,       	50,     daCenter,    false,    "s3",                  false,    "",       dfNone,    0,     false,    false,      400,    false,      true,     "",     false);
                     InitDataProperty(0, cnt++,  dtHidden,       	50,     daCenter,    false,    "pck_qty",                  false,    "",       dfNone,    0,     false,    false,      400,    false,      true,     "",     false);
                     InitDataProperty(0, cnt++ , dtHidden,          60,    daRight,     true,     "cntr_mf_wgt",         false,    "",      dfNone,    0,     false,   false);
                     
                     InitDataCombo(0, "kind", "Original|Cancel| ", "O|C|N", " ");
                     
                     CountPosition = 0;
        	  }

                break; 
            case 3:
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = 0; // mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					          // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|SEQ|VVD|SSR_NO|POL|ENG_NM|ETA";

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,    daCenter,  false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,	 		 45,    daCenter,    true,     "SEQ",     		false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,    true,     "vvd",     		false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData, 		 155,   daCenter,    true,     "ssr_no",      false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter,    true,     "vvd_nm",       	false,    "",      dfNone, 		0,     false,		false);
                                                                                                                                                 
                    InitDataProperty(0, cnt++ , dtData,      55,    daCenter,    true,     "eta_dt",       	false,    "",      dfNone, 		0,     false,		false);

               }
                break;    
            case 4:      // sheet2 init
       	 with (sheetObj) {
       		// 높이 설정
                style.height = 0;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge;

               // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(65, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle1 = "|Seq|Kind|B/L No|A|A|S|Last EDI|Last EDI|CNTR|A|A|S|Last EDI|Last EDI|TS|POR|POL|POD|DEL|PRE|POST|BDR|PKG|PKG|WGT|WGT|Description|Notify Name|S||";

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
					// COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
					// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
					// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
					// FORMATFIX]
                var prefix4 = 'sheet4_';
                InitDataProperty(0, cnt++ , dtStatus,  0,     daCenter,    true,     "sStatus");
                InitDataProperty(0, cnt++ , dtData,	     35,    daCenterTop, true,     	   "seq");
                InitDataProperty(0, cnt++ , dtCombo,	     100,   daCenterTop, true,     "kind",                false,    "",      dfNone,    0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,          100,   daCenterTop, true,     "bl_no",               false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          25,    daCenterTop, true,     "bl_ack2",         	false,    "",      dfNone,    0,     false,   false);

                InitDataProperty(0, cnt++ , dtHidden,        25,    daCenter,    true,     "bl_ack",              false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtCheckBox,      0,     daCenterTop, true,     "s1",                 false,    "",       dfNone,    0,     false,    false,      400,    false,      true,     "",     false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenterTop, true,     "bl_last_edi2",       false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,    true,     "bl_last_edi",         false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          90,    daCenter,    true,     "cntr_no",             false,    "",      dfNone,    0,     false,   false);

                InitDataProperty(0, cnt++ , dtData,          25,    daCenter,    true,     "cntr_ack2",          false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        25,    daCenter,    true,     "cntr_ack",            false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtCheckBox,      25,    daCenter,    true,     "s2",                  false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "cntr_last_edi2",      false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        60,    daCenter,    true,     "cntr_last_edi",       false,    "",      dfNone,    0,     false,   false);

                InitDataProperty(0, cnt++ , dtData,          35,    daCenter,    true,     "cntr_tpsz_cd",        false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "por_cd",              false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "pol_cd",              false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "pod_cd",              false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "del_cd",              false,    "",      dfNone,    0,     false,   false);

                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "pre_rly_port_cd",     false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "pst_rly_port_cd",     false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daCenter,    true,     "bdr_flg",             false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          40,    daCenter,    true,     "cntr_pck_tp_cd",           false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daRight,     true,     "cntr_pck_qty",             false,    "",      dfNone,    0,     false,   false);

                InitDataProperty(0, cnt++ , dtData,          40,    daCenter,    true,     "wgt_ut_cd",           false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daRight,     true,     "cntr_wgt_qty",         false,    "",      dfNone,    0,     false,   false);
                
                InitDataProperty(0, cnt++ , dtData,          250,   daLeft,      true,     "mf_desc",             false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          180,   daLeft,      true,     "ntfy_name",           false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "svc_rqst_no",         false,    "",      dfNone,    0,     false,   false);
                                    
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cnee_addr",           false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "prev_docno",          false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cm_pck_qty",          false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "anr_msg_sts_cd",      false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "lloyd_cd",            false,    "",      dfNone,    0,     false,   false);
                                    
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "pagerows",            false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          180,   daLeft,      true,     "cntr_seq",            false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "brth_desc",           false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cntr_wgt_ut_cd",      false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "vvd_seq",             false,    "",      dfNone,    0,     false,   false);
                                                             
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cntr_pck_tp_cd",      false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "rd_term",             false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "vvd",                 false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "bkg_no",              false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "ntfy_name",           false,    "",      dfNone,    0,     false,   false);
                                                             
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "decl_flg",            false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "ibflag",              false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "act_wgt_ut_cd",       false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "shpr_addr",           false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cntr_mf_desc",        false,    "",      dfNone,    0,     false,   false);
                                                             
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cm_cntr_no",          false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,        180,   daLeft,      true,     "anr_decl_no",         false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "ntfy_addr",           false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cntr_anr_msg_sts_cd", false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "act_wgt",             false,    "",      dfNone,    0,     false,   false);
                                                             
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cm_pck_tp_cd",        false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,        180,   daLeft,      true,     "sequence",            false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cntr_pck_qty22",        false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "cntr_fm",             false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtHidden,        180,   daLeft,      true,     "msg_tp_cd",             false,    "",      dfNone,    0,     false,   false);
                 
                InitDataProperty(0, cnt++ , dtData,        180,   daLeft,      true,     "msg_seq",             false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++,  dtData,        	 50,    daCenter,    false,    "s3",                  false,    "",       dfNone,    0,     false,    false,      400,    false,      true,     "",     false);
                InitDataProperty(0, cnt++ , dtData,        180,   daLeft,      true,     "flat_type",             false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daRight,     true,     "pck_qty",         false,    "",      dfNone,    0,     false,   false);
                InitDataProperty(0, cnt++ , dtData,          60,    daRight,     true,     "cntr_mf_wgt",         false,    "",      dfNone,    0,     false,   false);
                
                InitDataCombo(0, "kind", "Original|Cancel| ", "O|C|N", " ");
                
                CountPosition = 0;
   	  }

           break;    
            
                            
        }
    }

    function execSecondRetrive( pol, vvd ){
    			
		if ( pol != '' || pol != null ){
	    	document.form.f_cmd.value = SEARCH02;
	    	sheetObjects[1].DoSearch("ESM_BKG_0063GS.do?vvd="+vvd+"&pol_cd="+pol+"&is_cmdt=x"+"&pod="+form.pod.Code, FormQueryString(document.form));
	    	
	    	sheetObjects[3].DoSearch("ESM_BKG_0063GS.do?vvd="+vvd+"&pol_cd="+pol+"&is_cmdt=o"+"&pod="+form.pod.Code, FormQueryString(document.form));
	    	
//			var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_"); //prefix 문자열 배열
//			var sXml = sheetObjects[3].GetSearchXml("ESM_BKG_0063GS.do?vvd="+vvd+"&pol_cd="+pol+"&is_cmdt=o", FormQueryString(document.form) + "&" + ComGetPrefixParam(aryPrefix));
//			alert();
//			var arrXml = sXml.split("|$$|");
//			alert();
//			sheetObjects[3].LoadSearchXml(arrXml[0]);
	    	//sheetObjects[3].DoSearch("ESM_BKG_0063GS.do?vvd="+vvd+"&pol_cd="+pol+"&is_cmdt=o", FormQueryString(document.form));
	    	//for(var i=1; i<sheetObjects[1].RowCount+1; i++ ){
	    	//	sheetObjects[1].CellValue2(i,'s3') = 1
 			//}
		}	
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
			case IBSEARCH:      // Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_BKG_0063GS.do", FormQueryString(formObj));
					
					// 상위 시트가 조회되면 첫째 로우 의 값으로 두번째 시트를 조회한다.
			    	var pol = document.form.pol_cd.value;
			    	var vvd = document.form.vvd.value;
			    	execSecondRetrive( pol, vvd );
				}
				break;
							
			case MULTI03:     
				if( validateForm(sheetObj,formObj,sAction) ) {
					
					formObj.f_cmd.value = MULTI03;
					sheetObj.DoSave("ESM_BKG_0063GS.do?flat_type=0063", FormQueryString(formObj));
					state = sheetObj.EtcData("TRANS_RESULT_KEY");
					if (state == "S") {
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
					}
					
					
				}
				break;
				
			case MULTI01:
				if( validateForm(sheetObj,formObj,sAction) ){ 
					if( sheetObjects[1].RowCount > 0 ){
					    ComOpenWindowCenter("ESM_BKG_0183.do?popup=y&bl_no=" + blNo , "0183", 1020, 650);
					}
				}		
				break;
			case MULTI02:
				if( validateForm(sheetObj,formObj,sAction) ){
					if( sheetObjects[1].RowCount > 0 ){
						ComOpenWindowCenter("ESM_BKG_0045.do?popup=y&bl_no=" + blNo + "&pKind=" + kind, "0045", 1020, 670);
					}
				}		
				break;
				
			case COMMAND11 : //  PORT 조회
				
				formObj.f_cmd.value = SEARCH11;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
				ComXml2ComboItem(sXml, formObj.pod, "pod_cd", "pod_cd");
				
				formObj.pod.Code = form.in_pod.value;
					
				if(formObj.pod.Index < 0) formObj.pod.Index2 = 0;
				
				ComOpenWait(false);
				
				break;		

            }
		   
        }


    /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
    function validateForm(sheetObj,formObj,sAction){
        	switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if (formObj.vvd.value == "" || (formObj.ssr_no.value == "" ) ) 
	 			{
	 				ComShowCodeMessage('BKG00626','VVD or SSR NO');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case MULTI03:
	 			var chkCnt = 0;
	 			for(var i=1; i<sheetObj.RowCount+1; i++ ){
	 				// alert( sheetObj.CellValue(i,5) );
	 				if( sheetObj.CellValue(i,6) == '1' ) {
	 					chkCnt ++;
	 					
	 				}	
	 			}

	 			if( chkCnt == 0 ) {
	 				return false;
	 			}
	 			
	 			return true;
	 		break;
	 		case MULTI01:
	 			if (blNo == '' ) 
	 			{
	 				ComShowCodeMessage('BKG00249','');
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case MULTI02:
	 			if (blNo == '' ) 
	 			{
	 				ComShowCodeMessage('BKG00249','');
	 				return false;
	 			}
	 			return true;
	 			break;
    	}
    }
    
    /**
	 * 시트를 더블클릭했을 때 처리
	 * 
	 * @param row
	 * @param col
	 * @return
	 */    
    function sheet2_OnDblClick(sheetObj, row, col) {
    	doActionIBSheet(sheetObj,document.form,MULTI02);
    }        

    /**
	 * 시트를 클릭했을 때 처리
	 */
    function sheet1_OnClick(sheetObj, row, col) {
    	for(var i=1; i <= sheetObj.RowCount; i++) {
    		sheetObj.RowBackColor(i) = sheetObj.UnEditableColor;
		}
    	sheetObj.RowBackColor(row) = sheetObj.SelectBackColor;
    }
    
    /**
	 * 시트를 키보드로 이동할때 처리
	 */
    function sheet1_OnKeyUp(row, col, KeyCode, Shift) {
    	sheet1_OnClick(sheetObjects[0], col, 0);
    }
    
    /**
	 * 시트를 더블클릭했을 때 처리
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
    function sheet2_OnClick(sheetObj, row, col) {
    	
    	blNo = sheetObj.CellValue( row, "bl_no" );
    	kind = sheetObj.CellValue( row, "kind" );
    	
		/**
		 * 시트를 선택하면 BL No.가 머지되서 선택한 색깔이 제대로 표시되지 않음 BL No.가 같은거는 같은색으로 보이도록
		 * 처리함. 초기 바탕색은 흰색
		 */

		for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
			if (sheetObj.CellValue(i, "bl_no") == blNo) {
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(231, 250, 246);
			} else {
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 255)
			}
		}
    }
 	
    
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
    	
    	var blNo ;
    	kind = sheetObj.CellValue( Row, 2 );
    	if( Value == 'O' ) {
    		
    		if( sheetObj.CellValue(Row,"bl_last_edi")  != 'ON' ){
    			blNo = sheetObj.CellValue(Row,"bl_no")
    			for(var i=1; i<=sheetObj.RowCount; i++){
    				if( blNo == sheetObj.CellValue(i,"bl_no") ){
    					if( sheetObj.CellValue(i,"bl_last_edi")  != 'ON' ){
    						if( sheetObj.CellValue(i,"bl_last_edi")  == 'OA' ){
    							ComShowCodeMessage('BKG43031');
    							sheetObj.CellValue2(i,"s1")  = '0' ;
    	    					sheetObj.CellValue2(i,"s2")  = '0' ;
    							return false;
    						}	
	    					sheetObj.CellValue2(i,"s1")  = '1' ;
	    					sheetObj.CellValue2(i,"s2")  = '1' ;
	    					sheetObj.CellValue2(i, "msg_tp_cd") = 'C';
	    					sheetObj.CellValue2(i,"kind") = 'O';
    					}
    				}
    			}
    		}
    		sheet3Reflect(sheetObjects[3], blNo, Value);

    	} else if ( Value == 'C' ) {
    		if( sheetObj.CellValue(Row,"bl_last_edi")  != 'ON' ){
    			for(var i=1; i<sheetObj.RowCount+1; i++){
    				blNo = sheetObj.CellValue(Row,"bl_no")
    				if( blNo == sheetObj.CellValue(i,"bl_no") ){
    					if( sheetObj.CellValue(i,"bl_last_edi")  != 'ON' ){
	    					sheetObj.CellValue2(i,"s1")  = '1' ;
	    					sheetObj.CellValue2(i,"s2")  = '1' ;
	    					sheetObj.CellValue2(i, "msg_tp_cd") = 'C';
	    					sheetObj.CellValue2(i,"kind") = 'C';
    					}
    				}
    			}
    		}
    		sheet3Reflect(sheetObjects[3], blNo, Value);
    	} else if ( Value == 'N' ){
    		for(var i=1; i<sheetObj.RowCount+1; i++){
				blNo = sheetObj.CellValue(Row,"bl_no")
				if( blNo == sheetObj.CellValue(i,"bl_no") ){
					
    				sheetObj.CellValue2(i,"s1")  = '0' ;
    				sheetObj.CellValue2(i,"s2")  = '0' ;
    				sheetObj.CellValue2(i,"kind") = ' ';
    				sheetObj.CellValue2(i,"sStatus") = ' ';
				}
			}
    		sheet3Reflect(sheetObjects[3], blNo, Value);
    	}
    }
    
    function sheet3Reflect(sheetObj, blNo, Value) {
    	
    	var blNo ;
    	var Row = 0;
    	for(var i=1; i<=sheetObj.RowCount; i++){
    		if( blNo == sheetObj.CellValue(i,"bl_no") )
    			Row = i;
    	}
    	
    	
    	if( Value == 'O' ) {
    		
    		if( sheetObj.CellValue(Row,"bl_last_edi")  != 'ON' ){
    			blNo = sheetObj.CellValue(Row,"bl_no")
    			for(var i=1; i<=sheetObj.RowCount; i++){
    				if( blNo == sheetObj.CellValue(i,"bl_no") ){
    					if( sheetObj.CellValue(i,"bl_last_edi")  != 'ON' ){
    						if( sheetObj.CellValue(i,"bl_last_edi")  == 'OA' ){
    							ComShowCodeMessage('BKG43031');
    							sheetObj.CellValue2(i,"s1")  = '0' ;
    	    					sheetObj.CellValue2(i,"s2")  = '0' ;
    	    					sheetObj.CellValue2(i,"s3")  = '0' ;
    	    					sheetObj.CellValue2(i,"flat_type") = '0063';
    							return false;
    						}	
	    					sheetObj.CellValue2(i,"s1")  = '1' ;
	    					sheetObj.CellValue2(i,"s2")  = '1' ;
	    					sheetObj.CellValue2(i,"s3")  = '1' ;
	    					sheetObj.CellValue2(i, "msg_tp_cd") = 'C';
	    					sheetObj.CellValue2(i,"kind") = 'O';
	    					sheetObj.CellValue2(i,"flat_type") = '0063';
    					}
    				}
    				
    			}
    		}

    	} else if ( Value == 'C' ) {
    		if( sheetObj.CellValue(Row,"bl_last_edi")  != 'ON' ){
    			for(var i=1; i<sheetObj.RowCount+1; i++){
    				blNo = sheetObj.CellValue(Row,"bl_no")
    				if( blNo == sheetObj.CellValue(i,"bl_no") ){
    					if( sheetObj.CellValue(i,"bl_last_edi")  != 'ON' ){
	    					sheetObj.CellValue2(i,"s1")  = '1' ;
	    					sheetObj.CellValue2(i,"s2")  = '1' ;
	    					sheetObj.CellValue2(i,"s3")  = '1' ;
	    					sheetObj.CellValue2(i, "msg_tp_cd") = 'C';
	    					sheetObj.CellValue2(i,"kind") = 'C';
	    					sheetObj.CellValue2(i,"flat_type") = '0063';
    					}
    				}
    			}
    		}
    	} else if ( Value == 'N' ){
    		for(var i=1; i<sheetObj.RowCount+1; i++){
				blNo = sheetObj.CellValue(Row,"bl_no")
				if( blNo == sheetObj.CellValue(i,"bl_no") ){
					
    				sheetObj.CellValue2(i,"s1")  = '0' ;
    				sheetObj.CellValue2(i,"s2")  = '0' ;
    				sheetObj.CellValue2(i,"s3")  = '0' ;
    				sheetObj.CellValue2(i,"kind") = ' ';
    				sheetObj.CellValue2(i,"sStatus") = ' ';
				}
			}
    	}
    }
    
    function retrieve()
    {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
  
	/* 개발자 작업 끝 */    