/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0045.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
* ----------------------------------------------------
* History
* 2011.10.19 김보배 [CHM-201114022] ANCS > BL inquiry< Download 버튼 제거
* 2013.08.13 김보배 [CHM-201325718] Split 02-[ALPS 데이터품질 - BKG validation 로직보완] 7월 대상 건에 대한 진행 요청 건
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
    function esm_bkg_0045() {
    	
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
    var deleteRowIndex = -1;
    var selCntrNo = '';
    var sheet3Cnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		         var sheetObject1 = sheetObjects[0];
		         var sheetObject2 = sheetObjects[1];
		         var sheetObject3 = sheetObjects[2];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

							case "btn_retrieve":
								doActionIBSheet(sheetObject1,document.form,IBSEARCH);
							break;
							
							case "btn_new":
								doActionIBSheet(sheetObject1,document.form,COMMAND04);
							break;
							
							case "btn_save":
								doActionIBSheet(sheetObject1,document.form,IBSAVE);
								//doActionIBSheet(sheetObject1,document.form,IBSAVE);
							break;
							
							/*
							 * 2011.10.19 김보배 [CHM-201114022] ANCS > BL inquiry< Download 버튼 제거
							 * 사용하지 않는 버튼 삭제
							 */
//							case "btn_down":
//								doActionIBSheet(sheetObject1,document.form,MULTI01);
//							break;							

							case "btn_cuscar":
								doActionIBSheet(sheetObject1,formObject,SEARCHLIST01);
							break;							
							
							case "btn_view":
								alert('UI_BKG-0044');
							break;				

							case "btn_transfer":
								doActionIBSheet(sheetObject1,formObject,MULTI02);
							break;
							case "btn_RowAdd":
			 					doActionIBSheet(sheetObject3,formObject,IBINSERT);
			 					break;
			 				case "btn_RowDelete":
			 					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
			 					//hideNchangeStatByD( sheetObject3, deleteRowIndex );
			 					break;
			 				case "btn_shipper":
			 					doActionIBSheet(sheetObject3,formObject,SEARCHLIST02);
			 					break;
			 				case "btn_cnee":
			 					doActionIBSheet(sheetObject3,formObject,SEARCHLIST03);
			 					break;
			 				case "btn_noty":
			 					doActionIBSheet(sheetObject3,formObject,SEARCHLIST04);
			 					break;	
			 				case "btn_contact":
								ComOpenWindow2("ESM_BKG_0240.do?pgmNo=ESM_BKG_0240", "", "width=1024,height=640");
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
				
        initControl()
        
        if( document.form.popup.value == 'y' ){
        //	document.getElementById("navi").style.display = "none";
        }
        if( document.form.bl_no.value != '' ){
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
        //FLAT 파일 데이터를 가지고 있는 SHEET 의 FLAG 에 'U' 를  넣는다.
        var kind = document.form.kind.value;
        document.form.transmit.value = kind;
        for(var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        	sheetObjects[0].CellValue2( i, 0 ) = 'U';
        	sheetObjects[0].CellValue2( i, 2 ) = kind;
        	if( kind == 'O' || kind == 'C' )
        		sheetObjects[0].CellValue2( i, 'sheet1_msg_tp_cd' ) = 'C';
        	else if(  kind == 'N'  )
        		sheetObjects[0].CellValue2( i, 'sheet1_msg_tp_cd' ) = '';
        	else
        		sheetObjects[0].CellValue2( i, 'sheet1_msg_tp_cd' ) = '';
        }
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
        	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
        	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 0; // mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                  InitColumnInfo(20, 0, 0, true);
                    InitColumnInfo(67, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

//                    var HeadTitle1 = "|SEQ|BL_NO|VVD_SEQ|VVD|SVC_RQST_NO|CSTMS_PRC_CD|BL_ACK|BL_LAST_EDI|FAX_NO|NTFY_EML|SHPR_NAME|SHPR_ADDR|CNEE_NAME|CNEE_ADDR|NTFY_NM|NTFY_ADDR";
                    var HeadTitle1 = "|Seq|kind| bl_no| bl_ack2| bl_ack| S1| bl_last_edi2| bl_last_edi| cntr_no| cntr_ack2|"
                    	             +"cntr_ack| S2| cntr_last_edi2| cntr_last_edi| cntr_tpsz_cd| por_cd| pol_cd|"
                    	             +"pod_cd| del_cd| pre_rly_port_cd| pst_rly_port_cd| bdr_flg| pck_tp_cd| pck_qty|"
                    	             +"wgt_ut_cd| cntr_mf_wgt| mf_desc| ntfy_name| svc_rqst_no| cnee_addr| prev_docno|"
                    	             +"cm_pck_qty| anr_msg_sts_cd| lloyd_cd| pagerows| cntr_seq| brth_desc|"
                    	             +"cntr_wgt_ut_cd| vvd_seq| cntr_pck_tp_cd| rd_term| vvd| bkg_no| ntfy_addr|"
                    	             +"decl_flg| ibflag| act_wgt_ut_cd| shpr_addr| cntr_mf_desc| cm_cntr_no|"
                    	             +"anr_decl_no| cntr_anr_msg_sts_cd| act_wgt| cm_pck_tp_cd| sequence| cntr_pck_qty|"
                    	             +"cntr_fm| msg_tp_cd| msg_seq| shpr_name| cnee_name| fax_no| ntfy_eml| S3 |";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    var prefix = 'sheet1_';
                   
                    InitDataProperty(0, cnt++ , dtStatus,   0,     daCenter,    false,     prefix + "sStatus");
                    InitDataProperty(0, cnt++ , dtSeq,            50,    daCenter,    false,     prefix + "Seq");
                    InitDataProperty(0, cnt++ , dtData,          50,   daCenter,    true,      prefix + "kind",                false,    "",      dfNone,    0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,           50,   daCenter,    false,     prefix + "bl_no",               false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "bl_ack2",         	 false,    "",      dfNone,    0,     false,   false);
                    //5                                                                           
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,    false,     prefix + "bl_ack",              false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++,  dtCheckBox,       50,     daCenter,    false,     prefix + "s1",                  false,    "",       dfNone,    0,     false,    false,      400,    false,      true,     "",     false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "bl_last_edi2",        false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,    false,     prefix + "bl_last_edi",         false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "cntr_no",             false,    "",      dfNone,    0,     false,   false);
                    //10                                                                             
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "cntr_ack2",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,    false,     prefix + "cntr_ack",            false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtCheckBox,       50,    daCenter,    false,     prefix + "s2",                  false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "cntr_last_edi2",      false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,    false,     prefix + "cntr_last_edi",       false,    "",      dfNone,    0,     false,   false);
                    //15                                                                             
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "cntr_tpsz_cd",        false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "por_cd",              false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "pol_cd",              false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "pod_cd",              false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "del_cd",              false,    "",      dfNone,    0,     false,   false);
                    //20                                                                           
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "pre_rly_port_cd",     false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "pst_rly_port_cd",     false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "bdr_flg",             false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "pck_tp_cd",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daRight,     false,     prefix + "cntr_wgt_qty",             false,    "",      dfNone,    0,     false,   false);
                    
                    //25                                                                          
                    InitDataProperty(0, cnt++ , dtData,           50,    daCenter,    false,     prefix + "wgt_ut_cd",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daRight,     false,     prefix + "cntr_mf_wgt",         false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daLeft,      false,     prefix + "mf_desc",             false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daLeft,      false,     prefix + "ntfy_name",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daLeft,      false,     prefix + "svc_rqst_no",         false,    "",      dfNone,    0,     false,   false);
                    //30                                                                          
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cnee_addr",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "prev_docno",          false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cm_pck_qty",          false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "anr_msg_sts_cd",      false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "lloyd_cd",            false,    "",      dfNone,    0,     false,   false);
                    //35                                                                            
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "pagerows",            false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cntr_seq",            false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "brth_desc",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cntr_wgt_ut_cd",      false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "vvd_seq",             false,    "",      dfNone,    0,     false,   false);
                    //40                                                                             
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cntr_pck_tp_cd",      false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "rd_term",             false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "vvd",                 false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "bkg_no",              false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "ntfy_addr",           false,    "",      dfNone,    0,     false,   false);
                    //45                                                                            
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "decl_flg",            false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "ibflag",              false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "act_wgt_ut_cd",       false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "shpr_addr",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cntr_mf_desc",        false,    "",      dfNone,    0,     false,   false);
                    //50                                                                             
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cm_cntr_no",          false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "anr_decl_no",         false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cntr_anr_msg_sts_cd", false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "act_wgt",             false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cm_pck_tp_cd",        false,    "",      dfNone,    0,     false,   false);
                    //55
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "sequence",            false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "pck_qty",        false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cntr_fm",             false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "msg_tp_cd",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "msg_seq",             false,    "",      dfNone,    0,     false,   false);
                    //60
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "shpr_name",           false,    "",      dfNone,    0,     false,   false);                                                  	
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "cnee_name",           false,    "",      dfNone,    0,     false,   false);                                                  	
                    InitDataProperty(0, cnt++ , dtData,      	55,    daCenter,    true,      prefix +"fax_no",       	false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	55,    daCenter,    true,      prefix +"ntfy_eml",       	false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++,  dtCheckBox,       50,     daCenter,    false,     prefix + "s3",                  false,    "",       dfNone,    0,     false,    false,      400,    false,      true,     "",     false);
                    //65
                    InitDataProperty(0, cnt++ , dtData,         50,   daLeft,      false,     prefix + "flat_type",           false,    "",      dfNone,    0,     false,   false);
                    InitDataProperty(0, cnt++ , dtData,           50,    daRight,     false,     prefix + "cntr_pck_qty",             false,    "",      dfNone,    0,     false,   false);
                    

                    
                }
                break;
            
            	case "sheet2":
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 100;
                        //전체 너비 설정
                        SheetWidth = 50; // mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 3, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(16, 0, 0, true);

                        //해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "|S|CNTR No.|A|A|RCV|DEL|Last EDI|Last EDI|TP/SZ|Package|Package|Weight|Weight";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        var prefix = 'sheet2_';
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,    daCenter,  false,  prefix +"ibflag");
    	                InitDataProperty(0, cnt++,  dtCheckBox,  0,     daCenter,  false,         prefix +"Chk",     		false,    "",      dfNone,      0,     true,        true,      400,    false,      true,     "",     false);
    	                InitDataProperty(0, cnt++ , dtData,      200,    daCenter,    true,     prefix +"cntr_no",       		false,    "",      dfNone, 		0,     false,		false);
    	                InitDataProperty(0, cnt++ , dtHidden,    0,    daCenter,    true,     prefix +"anr_msg_sts_cd",       	false,    "",      dfNone, 		0,     false,		false);
    	                InitDataProperty(0, cnt++ , dtData,      30,    daCenter,    true,     prefix +"bl_ack",       			false,    "",      dfNone, 		0,     false,		false);

    	                InitDataProperty(0, cnt++ , dtCombo,     55,    daCenter,    true,    prefix +"org_rcv_term_cd",        false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtCombo,     55,    daCenter,    true,     prefix +"dest_de_term_cd",       false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtHidden,    0,    daCenter,    true,     prefix +"cntr_last_edi",       	false,    "",      dfNone, 		0,     false,		false);
    	                InitDataProperty(0, cnt++ , dtData,      100,    daCenter,    true,     prefix +"cntr_last_edi2",       	false,    "",      dfNone, 		0,     false,		false);
    	                InitDataProperty(0, cnt++ , dtData,      100,    daCenter,    true,     prefix +"cntr_tpsz_cd",       	false,    "",      dfEngUpKey, 	0,     true,		true, 2);
    	         
    	                InitDataProperty(0, cnt++ , dtData,      100,    daCenter,    true,     prefix +"pck_qty",       	    false,    "",      dfFloat, 	3,     true,		true, 16);
    	                InitDataProperty(0, cnt++ , dtData,      55,    daCenter,    true,     prefix +"pck_tp_cd",       	    false,    "",      dfEngUpKey, 	0,     true,		true, 2);
    	                InitDataProperty(0, cnt++ , dtData,      100,   daCenter,    true,      prefix +"cntr_wgt",       	    false,    "",      dfFloat, 	3,     true,		true,22);
    	                InitDataProperty(0, cnt++ , dtCombo,      55,    daCenter,    true,    	prefix +"wgt_ut_cd",       		false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtHidden,    	 0,     daCenter,    true,     	prefix +"bkg_no",       		false,    "",      dfNone, 		0,     true,		true);

    	                InitDataProperty(0, cnt++ , dtHidden,      0,     daCenter,    true,     	prefix +"vvd",       			false,    "",      dfNone, 		0,     false,		false);
    	                
                        InitDataCombo(
            					0,
            					"sheet2_org_rcv_term_cd",
            					"FCL|LCL",
            					"FCL|LCL");
                        
                        InitDataCombo(
            					0,
            					"sheet2_dest_de_term_cd",
            					"FCL|LCL",
            					"FCL|LCL");
                        
                        InitDataCombo(
            					0,
            					"sheet2_wgt_ut_cd",
            					"KGS|LBS",
            					"KGS|LBS");
                        
                   }
                    break;
                    
            	case "sheet3":
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 140;
                        //전체 너비 설정
                        SheetWidth = 50; // mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 3, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(15, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "|Seq.|T1 Ind|Package|Package|Weight|Weight|DESCRIPTION";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        var prefix = 'sheet3_';
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,    false,    prefix +"ibflag");
    	                InitDataProperty(0, cnt++ , dtData,	     45,    daCenter,    true,     prefix +"SEQ2",     			false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtCombo,     55,    daCenter,    true,     prefix +"decl_flg",       	false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtData,      55,    daCenter,    true,     prefix +"pck_qty",       	false,    "",      dfFloat, 	3,     true,		true, 16);
    	                InitDataProperty(0, cnt++ , dtData,      55,    daCenter,    true,     prefix +"pck_tp_cd",      false,    "",      dfEngUpKey, 	0,     true,		true, 2);
    	                
    	                InitDataProperty(0, cnt++ , dtData,      100,    daCenter,    true,     prefix +"cntr_mf_wgt",       false,    "",      dfFloat, 	3,     true,		true, 22);
    	                InitDataProperty(0, cnt++ , dtCombo,      55,    daCenter,    true,     prefix +"wgt_ut_cd",       	false,    "",      dfNone, 	0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtData,      100,    daCenter,    true,     prefix +"cntr_mf_desc",      false,    "",      dfEngUpKey, 	0,     true,		true, 4000);
    	                InitDataProperty(0, cnt++ , dtHidden,      55,    daCenter,    true,     prefix +"cntr_no",       	false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtHidden,      55,    daCenter,    true,     prefix +"cntr_seq",       	false,    "",      dfNone, 		0,     true,		true);

    	                InitDataProperty(0, cnt++ , dtHidden,      55,    daCenter,    true,     prefix +"bkg_no",       		false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtHidden,      55,    daCenter,    true,     prefix +"vsl_cd",       		false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtHidden,      55,    daCenter,    true,     prefix +"skd_voy_no",       	false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++ , dtHidden,      55,    daCenter,    true,     prefix +"skd_dir_cd",       	false,    "",      dfNone, 		0,     true,		true);
    	                InitDataProperty(0, cnt++,  dtHidden,  		0,     daCenter,  false,     prefix +"chk_cmdt",     		false,    "",      dfNone,      0,     true,        true,      400,    false,      true,     "",     false);
     	               
    	                //InitDataProperty(0, cnt++ , dtDataSeq,	     45,    daCenter,    true,     prefix +"SEQ",     			false,    "",      dfNone, 		0,     true,		true);
    	                //InitDataProperty(0, cnt++ , dtCheckBox,			    40,		daCenter,		true,		prefix + "Chk");
    	                
                        InitDataCombo(
            					0,
            					"sheet3_decl_flg",
            					"YES|NO",
            					"Y|N");
                        
                        InitDataCombo(
            					0,
            					"sheet3_wgt_ut_cd",
            					"KGS|LBS",
            					"KGS|LBS");
                   }
                    break;
                     
            }
        }

        function doActionIBSheet(sheetObj,formObj,sAction) {
            
        	sheetObj.ShowDebugMsg = false;
            switch(sAction) {
            
    			case IBSEARCH:      //Retrieve
    				if(validateForm(sheetObj,formObj,sAction)) {
    					formObj.f_cmd.value = SEARCH;
    					var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "frm_sheet1_"); //prefix 문자열 배열
    					var sXml = sheetObj.GetSearchXml("ESM_BKG_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
    					var arrXml = sXml.split("|$$|");
    					if ( arrXml.length > 2 ){
	    					sheetObjects[0].LoadSearchXml(arrXml[0]);
	    					sheetObjects[1].LoadSearchXml(arrXml[1]);
	    					sheetObjects[2].LoadSearchXml(arrXml[2]);
    					}
    					if(sheetObjects[0].RowCount > 0) {
    		   	  			IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_");
    		   	  		}
    					
    					sheet2_OnClick(sheetObjects[1], 1, 2, '');
    					
    					on_transmission();
    					formObj.frm_article_chk.checked = 0
    				}
    				break;
    			case IBSAVE:        //저장
    				IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
    				if( validateForm(sheetObj,formObj,sAction) ){
    					
						formObj.f_cmd.value = MULTI;
						var sParam1 = sheetObjects[0].GetSaveString();
						var sParam2 = sheetObjects[1].GetSaveString();
						var sParam3 = sheetObjects[2].GetSaveString();
						
						if ((sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) 
								&& sParam == "") {
							return; 
						}
						
						/*
						 * Packgae Qty Weigth 의 값 체크
						 */
						for( var i=1; i<=sheetObjects[1].RowCount; i++ ){
							
							var vSheet2_CntrNo = sheetObjects[1].CellValue(i, "sheet2_cntr_no");
							var vSheet2_PckQty = Number( sheetObjects[1].CellValue(i, "sheet2_pck_qty") );
							//alert(vSheet2_PckQty);
							var vSheet3_PckQty = 0 ;
							
							var vSheet2_CntrWgt = Number( sheetObjects[1].CellValue(i, "sheet2_cntr_wgt") );
							var vSheet3_CntrWgt = 0 ;
							
							for( var i=1; i<=sheetObjects[2].RowCount; i++ ){
								if( vSheet2_CntrNo == sheetObjects[2].CellValue(i, "sheet3_cntr_no") 
									&& sheetObjects[2].CellValue(i, "sheet3_ibflag") != "D" ){
									vSheet3_PckQty = vSheet3_PckQty + Number( sheetObjects[2].CellValue(i, "sheet3_pck_qty") );
									vSheet3_CntrWgt = vSheet3_CntrWgt + Number( sheetObjects[2].CellValue(i, "sheet3_cntr_mf_wgt") );
								}
							}
							//alert(vSheet3_PckQty);
							if( vSheet2_PckQty != vSheet3_PckQty ){
								ComShowCodeMessage('BKG01123', vSheet2_CntrNo );
								return false;
							}
							if( vSheet2_CntrWgt != vSheet3_CntrWgt ){
								ComShowCodeMessage('BKG01124', vSheet2_CntrNo );
								return false;
							}	
							vSheet2_PckQty  = 0;
							vSheet3_CntrWgt = 0;
							
						}
						
						var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_");    //prefix 문자열 배열
						var sParam = ComGetSaveString(sheetObjects);
		                    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam( aryPrefix );
						
						var sXml = sheetObj.GetSaveXml("ESM_BKG_0045GS.do",sParam);
						
						//XML 문자열을 인자로 받아 트랜잭션 대상 데이터에 각종 결과 처리를 완료하고, OnSaveEnd Event를 발생한다. 
						sheetObjects[0].LoadSaveXml(sXml);
						sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
						sheetObjects[1].LoadSaveXml(sXml);
						sheetObjects[2].LoadSaveXml(sXml);
						
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
    					
    				}	
    				break;
    			case IBINSERT:      // 입력
    				sheetObj.DataInsert(-1);
    				sheetObj.CellValue ( sheetObj.RowCount, 8 ) = selCntrNo;
    				if ( sheetObj.RowCount == 1 )
    					sheetObj.CellValue ( sheetObj.RowCount, 9 ) = 1;
    				else
    					sheetObj.CellValue ( sheetObj.RowCount, 9 ) = (sheetObj.CellValue ( sheetObj.RowCount-1, 9 ) + 1);
    				//alert(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "bkg_no"));
    				//alert(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "bkg_no"));
    				sheetObj.CellValue ( sheetObj.RowCount, 10 ) = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_bkg_no");//sheetObj.CellValue ( sheetObj.RowCount-1, 10 );
    				sheetObj.CellValue ( sheetObj.RowCount, 11 ) = formObj.frm_sheet1_vvd.value.substring(0,4);//sheetObj.CellValue ( sheetObj.RowCount-1, 11 );
    				sheetObj.CellValue ( sheetObj.RowCount, 12 ) = formObj.frm_sheet1_vvd.value.substring(4,8);//sheetObj.CellValue ( sheetObj.RowCount-1, 12 );
    				sheetObj.CellValue ( sheetObj.RowCount, 13 ) = formObj.frm_sheet1_vvd.value.substring(8);//sheetObj.CellValue ( sheetObj.RowCount-1, 13 );
    				
    				makeSeq();
    				break;
    			
    			case IBDELETE:      // 삭제
    				var checked = 0;
    				if (sheetObjects[2].CellValue(deleteRowIndex,0) != "I"){
    					sheetObjects[2].RowHidden( deleteRowIndex ) = true;
    					sheetObjects[2].RowStatus( deleteRowIndex ) = "D";
    				} else {
    					sheetObjects[2].RowStatus( deleteRowIndex ) = "D";
    				}
    				if ( deleteRowIndex == -1 ) ComShowCodeMessage('BKG00249');
    				
    				makeSeq();
    				
    			case SEARCHLIST02:
    				if(validateForm(sheetObj,formObj,sAction)) 
    					ComOpenWindow2("ESM_BKG_0728.do?popup=y&keyAddr=" + formObj.frm_sheet1_shpr_name.value  , "", "width=900, height=600");
    				break;
    			case SEARCHLIST03:
    				if(validateForm(sheetObj,formObj,sAction)) 
    					ComOpenWindow2("ESM_BKG_0728.do?popup=y&keyAddr=" + formObj.frm_sheet1_cnee_name.value  , "", "width=900,height=600");
    				break;
    			case SEARCHLIST04:
    				if(validateForm(sheetObj,formObj,sAction)) {
    					ComOpenWindow2("ESM_BKG_0728.do?popup=y&keyAddr=" + formObj.frm_sheet1_ntfy_name.value  , "", "width=900,height=600");
    				}	
    				break;	
    			case COMMAND04:
//    				if( !sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified ){
//    					ComResetAll();
//    				} else {
//    					if (ComShowCodeConfirm("BKG00386")) {
//    						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
//    					} else {
//    						ComResetAll();
//    					}
//    				}
    				
    				if (ComShowCodeConfirm("BKG06166")) {
    					ComResetAll();
    				}
    				break;
    				
    			/*
    			 * 2011.10.19 김보배 [CHM-201114022] ANCS > BL inquiry< Download 버튼 제거
				 * 사용하지 않는 버튼 삭제
    			 */
//    			case MULTI01:
//    				if(validateForm(sheetObj,formObj,sAction)){
//             			formObj.f_cmd.value = MULTI01;
//             			var vVvd = formObj.frm_sheet1_vvd.value;
//             			var vDaoGbn = "blno";
//             			
//             			var sParam = ComGetSaveString(sheetObjects);
//	                    sParam += "&vvd=" + vVvd + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam( "frm_sheet1_" );
//						var sXml = sheetObj.GetSaveXml("ESM_BKG_0045GS.do?daoGbn=blno",sParam);
//						
//						//XML 문자열을 인자로 받아 트랜잭션 대상 데이터에 각종 결과 처리를 완료하고, OnSaveEnd Event를 발생한다. 
//						sheetObjects[0].LoadSaveXml(sXml);
//						sXml = ComDeleteMsg(sXml);
//             			
//             			
//             		}
//                    break;	
    			case SEARCHLIST01:
    				if(validateForm(sheetObj,formObj,sAction)){ 
    					var vBlNo = formObj.bl_no.value;
    					ComOpenWindow2("ESM_BKG_0183.do?popup=y&bl_no=" + vBlNo  , "", "width=1024,height=650");
    				}
    				break;    
                
		        case MULTI02:
		        	if(validateForm(sheetObj,formObj,sAction)){ 
		        		sheetObj.WaitImageVisible = false;
		        		ComOpenWait(true);
						formObj.f_cmd.value = MULTI02;
			        	var shprAddr = formObj.frm_sheet1_shpr_name.value + '@@' + formObj.frm_sheet1_shpr_addr.value ;
			        	var cneeAddr = formObj.frm_sheet1_cnee_name.value + '@@' + formObj.frm_sheet1_cnee_addr.value ;
			        	
			        	for( var i=1; i<sheetObjects[0].RowCount +1; i++ ){
			        		sheetObjects[0].CellValue2(i, 'sheet1_shpr_addr') = shprAddr;
			        		sheetObjects[0].CellValue2(i, 'sheet1_cnee_addr') = cneeAddr;
			        		
			        		sheetObjects[0].CellValue2(i, 'sheet1_ntfy_addr') = formObj.frm_sheet1_ntfy_addr.value; 
			        		sheetObjects[0].CellValue2(i, 'sheet1_ntfy_name') = formObj.frm_sheet1_ntfy_name.value;
			        		
			        		sheetObjects[0].CellValue2(i, 'sheet1_fax_no') = formObj.frm_sheet1_fax_no.value;
			        		sheetObjects[0].CellValue2(i, 'sheet1_ntfy_eml') = formObj.frm_sheet1_ntfy_eml.value;
			        		
			        		sheetObjects[0].CellValue2(i, 'sheet1_flat_type') = '0045';
			        		
			        	}
			        	//대기이미지 표시하기
			        	//sheetObjects[0].DoSave("ESM_BKG_0045GS.do", FormQueryString(formObj));
			        	
			        	var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_");    //prefix 문자열 배열
						var sParam = ComGetSaveString(sheetObjects);
		                    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam( aryPrefix );
						
						var sXml = sheetObj.GetSaveXml("ESM_BKG_0045GS.do",sParam);
						
						//XML 문자열을 인자로 받아 트랜잭션 대상 데이터에 각종 결과 처리를 완료하고, OnSaveEnd Event를 발생한다. 
						sheetObjects[0].LoadSaveXml(sXml);
						//sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
						//sheetObjects[1].LoadSaveXml(sXml);
						//sheetObjects[2].LoadSaveXml(sXml);
			        	
			        	
			        	
			        	ComOpenWait(false);		
			        	//alert(opener);
			        	if ( opener != null )
			        		opener.retrieve();
			        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			        	
		        	}
		        	
		        	
					break;   
		        
            }
        }
        

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch (sAction) {
		 		case IBSEARCH: // 조회
		 			if (formObj.bl_no.value == "" ) 
		 			{
		 				ComShowCodeMessage('BKG00266'); 
		 				return false;
		 			}
		 			return true;
		 		break;
		 		case IBSAVE:
		 			if( !formObj.IsDataModified && !sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified )
		 			{
		 				ComShowCodeMessage('BKG00233');
		 				return false;
					} 
		 			// email 형식 체크
		 			if (formObj.frm_sheet1_ntfy_eml.value != "" && ComIsEmailAddr(formObj.frm_sheet1_ntfy_eml.value) == false) {
		 				ComShowCodeMessage("BKG00245", '"' + formObj.frm_sheet1_ntfy_eml.value + '"');
						ComSetFocus(formObj.frm_sheet1_ntfy_eml);
						return false;
		    		} 
		 			return true;
		 		break;
		 		case SEARCHLIST02: // 조회
		 			if (formObj.frm_sheet1_shpr_name.value == "" )
		 			{
		 				ComShowCodeMessage('BKG00395');
		 				return false;
		 			}
		 			return true;
		 		break;
		 		case SEARCHLIST03: // 조회
		 			if (formObj.frm_sheet1_cnee_name.value == "" ) 
		 			{
		 				ComShowCodeMessage('BKG00395');
		 				return false;
		 			}
		 			return true;
		 		break;
		 		case SEARCHLIST04: // 조회
		 			
		 			if (formObj.frm_sheet1_ntfy_name.value == "" ) 
		 			{
		 				ComShowCodeMessage('BKG00395');
		 				return false;
		 			}
		 			return true;
		 		break;
		 		case MULTI01:
		 			
		 			return true;
		 		break;
		 		case SEARCHLIST01:
		 			
		 			return true;
		 		break;
		 		case MULTI02: 
		 			var vIsCheck = false;
		 			// alert(sheetObj.RowCount);
		 			for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		 				if (sheetObjects[1].CellValue(i, "sheet2_Chk") == 1) {
		 					vIsCheck = true;
		 					break;
		 				}
		 			}
		 			if (!vIsCheck && !formObj.frm_article_chk.checked ) {
		 				ComShowCodeMessage('BKG00333', '');
		 				return false;
		 			}
		 			
		 			var trnasSelVal = document.form.transmit.value ;
		 			if( "" == trnasSelVal || "N" == trnasSelVal ){
		 				ComShowCodeMessage('BKG43030');
		 				return false;
		 			}
		 			
		 			
		 			return true;
		 		break;
        	}
        }
        
        function hideNchangeStatByD(sheetObj,Row){
			
			sheetObj.RowHidden(Row)= false;		//2.행 숨기기
			sheetObj.RowStatus(Row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
		}
        
        function sheet3_OnClick(SheetObj, Row, Col){
        	deleteRowIndex = Row ;
        }
        
        function sheet2_OnClick(SheetObj, Row, Col, Value){
        	selCntrNo = SheetObj.CellValue( Row, 2 );
        	makeSeq( Row, Col, SheetObj.CellValue(Row, 1) );
        	
        	var vCntrNo = SheetObj.CellValue( Row, 'sheet2_cntr_no' );
        	
        	if( Col == 1 && Value == 0){
        		for( var i=1; i<= sheetObjects[0].RowCount; i++ ){
        			if( vCntrNo == sheetObjects[0].CellValue(i,'sheet1_cntr_no') )
        				sheetObjects[0].CellValue2(i,'sheet1_s2') = 1 ;
        		}
        	}else if( Col == 1 && Value == 1){
        		for( var i=1; i<= sheetObjects[0].RowCount; i++ ){
        			if( vCntrNo == sheetObjects[0].CellValue(i,'sheet1_cntr_no') )
        				sheetObjects[0].CellValue2(i,'sheet1_s2') = 0 ;
        		}
        	}
        }
        
        function makeSeq(Row, Col, isChk){
        	sheet3Cnt = 0;
        	//alert(Col);
        	for(var i=0; i<sheetObjects[2].RowCount; i++){
        		var cmCntrNo = sheetObjects[2].CellValue( i+1, 8 );
        		if ( selCntrNo != cmCntrNo ){
        			sheetObjects[2].RowHidden(i+1) = true;		//2.행 숨기기
        			
        			//sheetObjects[2].CellValue2(i+1,0) = '';
        			//if( sheetObjects[2].CellValue(i+1,14) != 'O' )
        			//	sheetObjects[2].CellValue2(i+1,0) = '';
        		} else {
        			sheetObjects[2].RowHidden(i+1) = false;
        			sheetObjects[2].CellValue2(i+1,1) = sheet3Cnt + 1;
        			
        			if( sheetObjects[2].CellValue(i+1,0) != 'D' )
        				sheet3Cnt ++;
        			
        			if( sheetObjects[2].CellValue(i+1,0) == 'D' )
        				sheetObjects[2].RowHidden(i+1) = true;
        			
//        			if(Col == 1 ){
//        				if(isChk != 1){
//        					sheetObjects[2].CellValue2(i+1,14) = 'O';
//        				} else {
//        					sheetObjects[2].CellValue2(i+1,14) = '';
//        				}	
//        			}
//        			if( sheetObjects[2].CellValue(i+1,14) != 'O' )
//        				sheetObjects[2].CellValue2(i+1,0) = '';
        			
        		}
        	}	
        }
        
        /**
         * CNTR 수신파일을 만들 데이터를 만들기위한 작업.
         * 
         * @param SheetObj
         * @param Row
         * @param Col
         * @param Value
         * @return
         */
        function sheet2_OnChange(SheetObj, Row, Col, Value){
        	/*
        	 * FLAT 파일에 담겨질 CNTR 의 내용 항목
        	 * CNTR_NO -- not editable
        	 * CNTR_TS -- editable
        	 * CNTR_FM -- not
        	 * CNTR_WGT -- editable
        	 * RD_TERM 
        	 */
        	var cntrNo = sheetObjects[2].CellValue(Row,2);
        	var s1Row;
        	var s1Col;
        	if( Col == 9 ){
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 15; //CNTR_TPSZ_CD 의 COL 넘버
        			}
        		}
        		sheetObjects[0].CellValue2(s1Row,s1Col) = Value;
        	} else if( Col == 12 ){
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 26; //CNTR_TPSZ_CD 의 COL 넘버
        			}
        		}
        		sheetObjects[0].CellValue2(s1Row,s1Col) = Value;
        	}else if( Col == 5 || Col == 6 ){
        		
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 41; //CNTR_TPSZ_CD 의 COL 넘버
        			}
        		}
        		sheetObjects[0].CellValue2(s1Row,s1Col) = sheetObjects[1].CellValue(Row,5) + sheetObjects[1].CellValue(Row,6);
        	}
        }
        
        /**
         * CMDT 수신파일을 만들 데이터를 만들기위한 작업.
         * 
         * @param SheetObj
         * @param Row
         * @param Col
         * @param Value
         * @return
         */
        function sheet3_OnChange(SheetObj, Row, Col, Value){
        	/*
        	 * CM_SEQ    - not
        	 * CM_PKG_NO - editable
        	 * CM_PKG_CD - editable
        	 * CM_DESC   - editable
        	 * CM_WGT    - editable
        	 * CM_WGT_U  - editable
        	 * CM_CNTR_NO - not
        	 * T1_IND    - editable
        	 */
        	
        	var cntrNo = sheetObjects[2].CellValue(Row,8);
        	var s1Row;
        	var s1Col;
        	if( Col == 2 ){
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 45; 
        			}
        		}
        		if( 'Y' == Value )
        			sheetObjects[0].CellValue2(s1Row,s1Col) = 'T1';
        		else
        			sheetObjects[0].CellValue2(s1Row,s1Col) = 'C';
        	} else if( Col == 3 ){
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 32; 
        			}
        		}
        		sheetObjects[0].CellValue2(s1Row,s1Col) = Value;
        	} else if( Col == 4 ){
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 40; 
        			}
        		}
        		sheetObjects[0].CellValue2(s1Row,s1Col) = Value;
        	}else if( Col == 5 ){
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 26; //CNTR_TPSZ_CD 의 COL 넘버
        			}
        		}
        		sheetObjects[0].CellValue2(s1Row,s1Col) = Value;
        	}else if( Col == 6 ){
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 25; //CNTR_TPSZ_CD 의 COL 넘버
        			}
        		}
        		sheetObjects[0].CellValue2(s1Row,s1Col) = Value;
        	}else if( Col == 7 ){
        		for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        			if( cntrNo == sheetObjects[0].CellValue(i,9) ){
        				s1Row = i;
        				s1Col = 49; //CNTR_TPSZ_CD 의 COL 넘버
        			}
        		}
        		sheetObjects[0].CellValue2(s1Row,s1Col) = Value;
        	}
        	
        }
         
        /**
         * 화면의 Transmission 셀렉트 박스의 값 선택시 동작하는 메서드.
         * 
         * @return
         */
        function on_transmission(){
        	var trnasSelVal = document.form.transmit.value ;
        	for( var i=1; i<sheetObjects[0].RowCount+1; i++ ){
        		if( trnasSelVal == "O" ){
        			sheetObjects[0].CellValue2(i, "sheet1_kind") = 'O';
        			sheetObjects[0].CellValue2( i, 'sheet1_msg_tp_cd' ) = 'C';
        		}else if( trnasSelVal == "T" ){
        			sheetObjects[0].CellValue2(i, "sheet1_kind") = 'T';
        			sheetObjects[0].CellValue2( i, 'sheet1_msg_tp_cd' ) = 'C';
        		}else if( trnasSelVal == "C" ){
        			sheetObjects[0].CellValue2(i, "sheet1_kind") = 'C';
        			sheetObjects[0].CellValue2( i, 'sheet1_msg_tp_cd' ) = 'C';
        		}else{ 
        			sheetObjects[0].CellValue2(i, "sheet1_kind") = 'N';
        			sheetObjects[0].CellValue2( i, 'sheet1_msg_tp_cd' ) = '';
        		}
        		
        		sheetObjects[0].CellValue2(i, "sheet1_s1") = '1'; 
        	}
        }
         
        function chkCmt(){
        	if( true == document.form.frm_article_chk.checked ){
        		for( var i=1; i<= sheetObjects[0].RowCount; i++ ){
       				sheetObjects[0].CellValue2(i,'sheet1_s3') = 1 ;
        		}
        	}else{
        		for( var i=1; i<= sheetObjects[0].RowCount; i++ ){
       				sheetObjects[0].CellValue2(i,'sheet1_s3') = 0 ;
        		}
        	}	
        }
        
	/* 개발자 작업  끝 */    