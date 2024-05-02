 /*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0442.js
*@FileTitle : ESM_BKG-0442
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.01 임재택
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.08.28 김보배 [CHM-201326243] [ALPS 데이터품질 - BKG validation 로직보완] 8월 대상 건에 대한 진행 요청 건
* 2013.10.23 김보배 [CHM-201327128] [ROCS] B/L inquiry 화면상 Select all check box 추가요청
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0442() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick     = sheet1_OnClick;
    	this.sheet2_OnClick         = sheet2_OnClick;
    	this.sheet3_OnClick         = sheet3_OnClick; 
    }
 // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var deleteRowIndex = -1;
    var deleteRowIndex2 = -1;
    var deleteRowIndex3 = -1;
    var cntrNo  = ""; 
    var crnNo   = ""; 
    var cntr_no = "";
    var crn_no  = "";
    var bkg_No2  = "";
    var cntrNoTemp  = ""; 
    var crnNoTemp   = ""; 
    var cntr_noTemp = "";
    var crn_noTemp  = "";
    var bkg_No2Temp  = "";    
    var memo_imsi = "";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		         var sheetObject1 = sheetObjects[0];
    		         var sheetObject2 = sheetObjects[1];
    		         var sheetObject2 = sheetObjects[2];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

    							case "btn_add1":
    								doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
    							break;
    							
    							case "btn_delete1":
    								hideNchangeStatByD(sheetObjects[0], deleteRowIndex );
    							break;
    							
    							case "btn_add2":
    								doActionIBSheet(sheetObjects[2],document.form,COMMAND02);
    							break;
    							
    							case "btn_delete2":
    								hideNchangeStatByD2(sheetObjects[2], deleteRowIndex2, deleteRowIndex3 );
    							break;							
    							
    							case "btn_retrieve":    								 
    								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    							break;		
    							
    							case "pop_shipper":  
    								ComOpenWindowCenter("/hanjin/ESM_BKG_0240.do?pgmNo=ESM_BKG_0240&autoSearchFlg=Y&cust_cnt_cd=" + formObject.shpr_cnt_cd.value + "&cust_seq=" + formObject.shpr_cust_seq.value  , "cust1", 1024, 640, true);
    							break;		
    							
    							case "pop_consignee":    								 
    								ComOpenWindowCenter("/hanjin/ESM_BKG_0240.do?pgmNo=ESM_BKG_0240&autoSearchFlg=Y&cust_cnt_cd=" + formObject.cnee_cnt_cd.value + "&cust_seq=" + formObject.cnee_cust_seq.value  , "cust2", 1024, 640, true);
    							break;		
    							
    							case "pop_notify":    								 
    								ComOpenWindowCenter("/hanjin/ESM_BKG_0240.do?pgmNo=ESM_BKG_0240&autoSearchFlg=Y&cust_cnt_cd=" + formObject.ntfy_cnt_cd.value + "&cust_seq=" + formObject.ntfy_cust_seq.value  , "cust3", 1024, 640, true);
    							break;		
    							
    							case "btn_new":
    								sheetObject1.RemoveAll();
    								sheetObject2.RemoveAll();
    								formObject.reset();
    							break;							
    											
    							case "btn_save":
    								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
    							break;		
    							
    							case "btn_contact":
    								ComOpenWindowCenter("/hanjin/ESM_BKG_0240.do?pgmNo=ESM_BKG_0240", "cust", 1024, 640, true);
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
//            if(document.form.cn_no.value != "" || document.form.frm_bl_no.value != "")
//            {   
//            	document.form.frm_crn_number.value = document.form.cn_no.value;
//            	document.form.bl_no.value = document.form.frm_bl_no.value;
//    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//            }
    			//doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    			axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
//    			axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    			axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
    			
                if(document.form.cn_no.value != "" || document.form.frm_bl_no.value != "")
                {   
                	document.form.frm_crn_number.value = document.form.cn_no.value;
                	document.form.bl_no.value = document.form.frm_bl_no.value;
        			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                }    	
                initControl();
        }
         
         function initControl() {
      	   var formObject = document.form;      		
      	   axon_event.addListenerFormat('keypress','bkg0042_keypress',formObject); //- 키보드 입력할때
      	}    

         //function sheet1_OnLoadFinish(sheetObj) {
         //    if(document.form.cn_no.value != "" || document.form.frm_bl_no.value != "")
        //     {   
          //   	document.form.frm_crn_number.value = document.form.cn_no.value;
         //    	document.form.bl_no.value = document.form.frm_bl_no.value;
     	//		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         //    }
         //}

      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
    		var sheetID = sheetObj.id;
    				
            switch(sheetID) {
            	 
                case "sheet1":      //sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 100;
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
                        InitColumnInfo(16, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle = "|Sel.|CNTR No.|SEAL No.|TYPE & Description|TYPE & Description|TYPE & Description|Package|Package|Packag|Weight|Weight|T1 Ind||";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);


                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                  InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,   daCenter,  	 false,  "ibflag");
    	                  InitDataProperty(0, cnt++ , dtRadioCheck,	 40,    daCenter,    false,  "Chk");
                          InitDataProperty(0, cnt++ , dtData,		100,    daCenter,    false,     "cntr_no",      		false,    "",      dfNone, 			0,     true,		true,14);
    					  InitDataProperty(0, cnt++ , dtData,     	100,    daCenter,    false,     "cntr_seal_no",      		false,    "",      dfNone, 			0,     true,		true,20);
    					  InitDataProperty(0, cnt++ , dtData,      	30,     daCenter,    false,     "cntr_tpsz_cd",      	false,    "",      dfNone, 			0,     true,		true,4);
    					  InitDataProperty(0, cnt++ , dtData,      	45,     daCenter,    false,     "iso_cntr_tpsz_cd",      	false,    "",      dfNone, 			0,     true,		true,4);
                                                                                                                                                	
    					  InitDataProperty(0, cnt++ , dtData,      	255,    daLeft,    false,     "cntr_tpsz_desc",      	false,    "",      dfNone, 			0,     true,		true);
    					  InitDataProperty(0, cnt++ , dtData,      	80,     daRight,    false,     "pck_qty",     false,    "",      dfNullInteger, 			0,     true,		true);
    					  InitDataProperty(0, cnt++ , dtData,      	40,     daCenter,    false,     "pck_tp_cd",     false,    "",      dfNone, 			0,     true,		true,2);
    					  InitDataProperty(0, cnt++ , dtData,      	60,     daLeft,    false,     "pck_desc",     false,    "",      dfNone, 			0,     true,		true);
    					  InitDataProperty(0, cnt++ , dtData,      	85,     daRight,     false,     "cntr_mf_wgt",      false,    "",      dfNullFloat, 2,     true,		true);

    					  InitDataProperty(0, cnt++ , dtData,      	40,     daCenter,    false,     "cntr_wgt_ut_cd",      false,    "",      dfNone, 			0,     true,		true,3);
    					  InitDataProperty(0, cnt++ , dtCombo,     	50,     daCenter,    false,     "t1_doc_cd",      	false,    "",      dfNone, 			0,     true,		true);
    					  InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "vsl_call_ref_no",      	false,    "",      dfNone, 			0,     true,		true);
    					  InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "bkg_no",      	false,    "",      dfNone, 			0,     true,		true);
    					  InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "bkg_no_split",      	false,    "",      dfNone, 			0,     true,		true);
    					  InitDataCombo(0, "t1_doc_cd", "Yes|No", "Y|N");	
    					  
    					  InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789"); 
    					  InitDataValid(0, "cntr_seal_no", vtEngOther, "0123456789"); 
    					  InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "0123456789"); 	
    					  InitDataValid(0, "iso_cntr_tpsz_cd", vtEngUpOther, "0123456789"); 	
    					  InitDataValid(0, "cntr_tpsz_desc", vtEngUpOther, "0123456789-");
    					  InitDataValid(0, "pck_tp_cd", vtEngUpOnly);
    					  InitDataValid(0, "pck_desc", vtEngUpOnly);
    					  InitDataValid(0, "cntr_wgt_ut_cd", vtEngUpOnly);
    					  //InitDataValid(0, "cntr_mf_wgt", vtNumericOnly); 	
//    						CountPosition = 0;
                   }
                    break;


                case "sheet2":      //sheet2 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 200;
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
                        InitColumnInfo(15, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle = "||Seq.|QTY & Description|QTY & Description|QTY & Description|Weight|Weight|Description|HS Code||||";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);


                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,   daCenter,  	 false,  "ibflag");
    	                InitDataProperty(0, cnt++ , dtRadioCheck,	 40,    daCenter,    false,  "Chk");
    	                InitDataProperty(0, cnt++ , dtData,				65,     daCenter,    false,     "cntr_mf_seq",      			false,    "",      dfNone, 	0,     true,		true);
    					InitDataProperty(0, cnt++ , dtAutoSumEx,      	65,     daCenter,    false,     "pck_qty",      			false,    "",      dfNullFloat,     3,     true,		true);
    					InitDataProperty(0, cnt++ , dtData,      	70,     daCenter,    false,     "pck_tp_cd",      			false,    "",      dfNone, 			0,     true,		true,2);
    					InitDataProperty(0, cnt++ , dtData,      	125,    daCenter,    false,     "pck_desc",      			false,    "",      dfNone, 			0,     true,		true);

    					InitDataProperty(0, cnt++ , dtData,      	125,    daRight,     false,     "cntr_mf_wgt",      	false,    "",      dfNullFloat,	3,     true,		true);
    					InitDataProperty(0, cnt++ , dtData,      	65,     daRight,     false,     "cntr_wgt_ut_cd",     		false,    "",      dfNone, 			0,     true,		true,3);
    					InitDataProperty(0, cnt++ , dtData,     	330,    daLeft,	     false,     "cntr_mf_desc2",    false,    "",      dfNone, 			0,     true,		true);
    	 				InitDataProperty(0, cnt++ , dtData,      	70,     daCenter,    false,     "hamo_trf_cd",     		false,    "",      dfNone, 			0,     true,		true,10);
    					InitDataProperty(0, cnt++ , dtHidden,      	70,     daCenter,    false,     "cntr_no",     		false,    "",      dfNone, 			0,     true,		true);
    					InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "vsl_call_ref_no",      	false,    "",      dfNone, 			0,     true,		true);
						InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "bkg_no",      	false,    "",      dfNone, 			0,     true,		true);
						InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "bkg_no_split",      	false,    "",      dfNone, 			0,     true,		true);
						InitDataProperty(0, cnt++ , dtHidden,     	330,    daLeft,	     false,     "cntr_mf_desc",    false,    "",      dfNone, 			0,     true,		true);


    				    ShowButtonImage = 2;
                   }
                    break;
                case "sheet3":      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 120;
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
                    InitColumnInfo(16, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel.|Seq.|QTY & Description|QTY & Description|QTY & Description|Weight|Weight|Description|HS Code|||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,   daCenterTop,  	 false,  "ibflag");
	                InitDataProperty(0, cnt++ , dtDummyCheck,	 40,    daCenterTop,    false,  "Chk");
                    InitDataProperty(0, cnt++ , dtData,			65,     daCenterTop,    true,     "cntr_mf_seq",      		false,    "",      dfNone, 	0,     false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,    65,     daCenterTop,    false,     "pck_qty",      		false,    "",      dfNullFloat,     3,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	70,     daCenterTop,    false,     "pck_tp_cd",      		false,    "",      dfEngUpKey, 		0,     true,		true,2);
					InitDataProperty(0, cnt++ , dtData,      	125,    daCenterTop,    false,     "pck_desc",      		false,    "",      dfEngUpKey, 		0,     true,		true);

					InitDataProperty(0, cnt++ , dtAutoSumEx,    125,    daRightTop,     false,     "cntr_mf_wgt",      	false,    "",      dfNullFloat,	    3,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	65,     daRightTop,     false,     "cntr_wgt_ut_cd",     	false,    "",      dfEngUpKey, 		0,     true,		true,3);
					InitDataProperty(0, cnt++ , dtData,     	330,    daLeftTop,	     false,     "cntr_mf_desc2",        false,    "",      dfNone, 			0,     false,		false,30);
					InitDataProperty(0, cnt++ , dtData,      	70,     daCenterTop,    false,     "hamo_trf_cd",     		false,    "",      dfNone, 			0,     true,		true,10);
					InitDataProperty(0, cnt++ , dtHidden,      	70,     daCenter,    false,     "cntr_no",     		    false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "vsl_call_ref_no",      false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "bkg_no",      	        false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "bkg_no_split",      	false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	70,     daCenter,    false,     "row_falg",      	    false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtHidden,     	330,    daLeft,	     false,     "cntr_mf_desc",         false,    "",      dfNone, 			0,     false,		false);
					 
					InitDataValid(0, "cntr_wgt_ut_cd", vtEngUpOnly);					
					InitDataValid(0, "pck_tp_cd", vtEngUpOnly);
					InitDataValid(0, "pck_desc", vtEngUpOnly);
					InitDataValid(0, "cntr_mf_seq", vtNumericOnly); 
					InitDataValid(0, "hamo_trf_cd", vtNumericOnly); 
					//InitDataValid(0, "pck_qty", vtNumericOnly); 	
					CountPosition = 0;
               }
                break;
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
            		   case COMMAND01:               			    
            				sheetObjects[0].DataInsert(-1);
            				sheetObjects[0].SelectCell(sheetObjects[0].RowCount,2);             				 
                    		sheetObjects[0].CellValue2(sheetObjects[0].RowCount, 13 ) = formObj.frm_crn_number.value;
                    		sheetObjects[0].CellValue2(sheetObjects[0].RowCount, 14 ) = bkg_No2;  
            			break;
            			 
            			case COMMAND02:            				
            				sheetObjects[2].DataInsert(-1);
            				sheetObjects[2].SelectCell(sheetObjects[2].RowCount,1);       
            				//sheetObjects[2].SelectCell(sheetObjects[2].RowCount,1);     
            			break;
            				
    					case IBSEARCH:      //조회
    					
    					if(!validateForm(sheetObj,formObj,sAction)) {
     						return false;
     					}
     					sheetObj.WaitImageVisible = false;
     					ComOpenWait(true);
    					if(formObj.bl_no.value.length > 12)
    					{    					
    						formObj.bl_tp_cd.value  = formObj.bl_no.value.substring(12);    						 
    					}
    					else formObj.bl_tp_cd.value  = "";
    					formObj.f_cmd.value = SEARCH;
    					formObj.dif_chr.value = "@@";
    					sheetObjects[0].RemoveAll();
    					sheetObjects[1].RemoveAll();
    					sheetObjects[2].RemoveAll();
    					 
     					sXml = sheetObj.GetSearchXml("ESM_BKG_0442GS.do", FormQueryString(formObj));
     				 
    					var arrXml = sXml.split("|$$|");
    					 
    			   	  	if (arrXml.length > 0) {			   	  		 
    			   	  	    sheetObjects[0].LoadSearchXml(arrXml[0]);
    			   	  	}
    			   	  	 
    			   	  	if (arrXml.length > 1) {    			   	  		 
    			   	  		sheetObjects[1].LoadSearchXml(arrXml[1]);
    			   	  	}
    			   	   	   	  	
    			   	    ComEtcDataToForm(formObj, sheetObj);    			   	    
    			   	    if(sheetObjects[1].RowCount == 0)
    			   	    {
    			   	    	sheetObjects[1].RemoveAll();
    					    sheetObjects[2].RemoveAll();
    			   	    }
    			   	    else
    			   	    {
    			   	    	sheet1_OnClick(sheetObjects[0], 1, 1);
    			   	    	//sheet2_total_setup(formObj, sheetObjects[2]);
    			   	    }
    			   	    ComOpenWait(false);
    					break;
    					
    					case IBSAVE:        //저장
    						if(!validateForm(sheetObj,formObj,sAction)) {
         						return false;
         					}
    						formObj.f_cmd.value = MULTI;

    					    if(sheetObjects[0].RowCount >0)
    					    {
    					    	for(var i=0; i<sheetObjects[0].RowCount; i++){        					    		 
    					    			sheetObjects[0].CellValue2( i+1, 14 ) = formObj.etc_bkg_no.value;    					    		 
    					    	}
    					    }
    					    if(sheetObjects[2].RowCount >0)
    					    {
    					    	for(var i=0; i<sheetObjects[2].RowCount; i++){
    					    		 
    					    		if(sheetObjects[2].CellValue(i+1, "ibflag") == "I")
    					    		{       					 
    					    			if(cntr_no == "")
    					    			{
    					    				ComShowCodeMessage('BKG00565');
    					    				return false;
    					    			}
    					    			//if(sheetObjects[2].CellValue( i+1, "cntr_mf_seq" )== "")
    					    			//{
    					    			//	ComShowCodeMessage('BKG00578');
    					    			//	return false;
    					    			//}
    					    			sheetObjects[2].CellValue2( i+1, 10 ) = cntr_no;
    					        		sheetObjects[2].CellValue2( i+1, 11 ) = crn_no;
    					        		sheetObjects[2].CellValue2( i+1, 12 ) = bkg_No2;    					        		 
    					    			sheetObjects[2].Copy2SheetCol(sheetObjects[1],"","",i+1,i+1,-1,2,true,false,"","");
    					    			sheetObjects[1].CellValue2( i+1, 14 ) = sheetObjects[2].CellValue(i+1, 15 );   
    					    			
    					    		}
    					    		if(sheetObjects[2].CellValue(i+1, "ibflag") == "U")
    					    		{
    					    			var row1 = sheetObjects[2].CellValue(i+1,14);
    					    			//sheetObjects[1].CellValue2(row1,2) = sheetObjects[2].CellValue(i+1,2);
    					    			sheetObjects[1].CellValue2(row1,3) = sheetObjects[2].CellValue(i+1,3);
    					    			sheetObjects[1].CellValue2(row1,4) = sheetObjects[2].CellValue(i+1,4);
    					    			sheetObjects[1].CellValue2(row1,5) = sheetObjects[2].CellValue(i+1,5);
    					    			sheetObjects[1].CellValue2(row1,6) = sheetObjects[2].CellValue(i+1,6);
    					    			sheetObjects[1].CellValue2(row1,7) = sheetObjects[2].CellValue(i+1,7);
    					    			sheetObjects[1].CellValue2(row1,8) = sheetObjects[2].CellValue(i+1,8);
    					    			sheetObjects[1].CellValue2(row1,9) = sheetObjects[2].CellValue(i+1,9);
    					    			sheetObjects[1].CellValue2(row1,10) = sheetObjects[2].CellValue(i+1,10);
    					    			sheetObjects[1].CellValue2(row1,11) = sheetObjects[2].CellValue(i+1,11);
    					    			sheetObjects[1].CellValue2(row1,12) = sheetObjects[2].CellValue(i+1,12);
    					    			sheetObjects[1].CellValue2(row1,13) = sheetObjects[2].CellValue(i+1,13);     					    		 
    					    			replaceStr(sheetObjects[2].CellValue(i+1,15),i+1)    					    					    			 
    					    			sheetObjects[1].CellValue2(row1,14) = sheetObjects[2].CellValue(i+1,15);      					    			 
    					    		}
    					    	}
    					    }
    					    if(ComShowConfirm(ComGetMsg("BKG00350"))){     
         						sheetObj.WaitImageVisible = false;
         						ComOpenWait(true);
    					    	var sParam = "";	    						 
	    						var sParamSheet1 = sheetObjects[0].GetSaveString();
	    						if (sParamSheet1 != "") {
	    							sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
	    						}
	    						var sParamSheet2 = sheetObjects[1].GetSaveString();
	    						if (sParamSheet2 != "") {
	    							sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
	    						}	    						 
	    						//if (sParam == "") return;
	    						sParam += "&" + FormQueryString(formObj);
	    						var sXml = sheetObj.GetSaveXml("ESM_BKG_0442GS.do", sParam);    						  
	    						sheetObjects[0].LoadSaveXml(sXml);
	        					sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용
	        					sheetObjects[1].LoadSaveXml(sXml);
	        					ComOpenWait(false);
	        					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    					    }
		    						
        					 
    					break;
    					
    					case IBINSERT:      // 입력
    					break;
            }
        }
       /**
        * 
        * @param sheetObj
        * @param Row
        * @return
        */ 
       function hideNchangeStatByD(sheetObj,Row){  
    	   
    	   var vIsCheck = false;
			for(var i=1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, 1) == 1) {
					vIsCheck = true;
					sheetObjects[0].RowHidden(i) = true;
			    	sheetObjects[0].RowStatus(i)= "D";
			    	//sheetObjects[0].CellValue2(i) = "D"					
					break;
				}
			}
			if (!vIsCheck) {
				ComShowCodeMessage('BKG00442');	
				return;
			}
			
	//3.트랜잭션 상태 "삭제"로 만들기	 			
			//for(var i=1; i<sheetObjects[0].RowCount; i++){
    		//   if(sheetObjects[0].CellValue(i+1,1) == 1)
    		//   {
    		//	   sheetObjects[0].RowHidden(Row)= true;		//2.행 숨기기
     
    		//   }
    	   //}
    	      		 
		}
       /**
        * 화면에서 선택된 체크 데이타만 처리
        * @param sheetObj
        * @param Row
        * @param Row1
        * @return
        */
       function hideNchangeStatByD2(sheetObj,Row,Row1){ 
    	   
        	var vIsCheck = false;
        	var rowCnt = sheetObj.RowCount + 2;
        	for(var i= 0; i<= rowCnt; i++) {
				if (sheetObj.CellValue(i, 1) == 1) {
					vIsCheck = true;
	    	    	var row1 = sheetObjects[2].CellValue(i,14);
	    	    	if(sheetObjects[2].CellValue(i,"ibflag") != "I"){
	    	    		sheetObjects[1].CellValue2(row1,"ibflag") = "D";	//3.트랜잭션 상태 "삭제"로 만들기
	    	    		sheetObjects[2].CellValue2(i,"ibflag") = "D";
	    	    	}else if(sheetObjects[2].CellValue(i,"ibflag") == "I"){
//		    	    	sheetObjects[2].RowStatus(i)= "D";
	    	    		sheetObjects[2].CellValue(i,"ibflag") = "U";
	    	    	}
				}
			}
        	
        	// row add 해서 생성된 row 를 바로 다시 row delete 하는 경우에
        	// ibflag 가 I 인 상태에서 바로 D 로 변경하면 ibflag 만 변경되는 것이 아니라 row 자체가 삭제되어
        	// RowCount 에 영향을 미쳐 마지막 row 가 삭제 되지 않으므로
        	// ibflag I 를 U 로 바꾸고 다시 D 로 변경한다.
        	for(var i= 0; i<= rowCnt; i++) {
        		if (sheetObj.CellValue(i, 1) == 1) {
	        		if(sheetObjects[2].CellValue(i,"ibflag") == "U"){
	    	    		sheetObjects[2].CellValue(i,"ibflag") = "D";
	        		}	
        		}
			}
        	
        	for(var i= 0; i<= rowCnt; i++) {
        		if (sheetObj.CellValue(i, 1) == 1) {
	        		if(sheetObjects[2].CellValue(i,"ibflag") == "D"){
	    	    		sheetObjects[2].RowHidden(i)= true;    	   
	        		}	
        		}
			}

        	if (!vIsCheck) {
				ComShowCodeMessage('BKG00442');			
				return;
			}
		}

       /**
         * 
         * @param sheetObj
         * @param row
         * @param col
         * @return
         */
        function sheet1_OnClick(sheetObj, row, col) { 
        	    	
        	
         	cntrNo  = sheetObjects[0].CellValue( row, 2 ); 
        	crnNo   = sheetObjects[0].CellValue( row, 13 ); 
        	bkgNo   = sheetObjects[0].CellValue( row, 14 );
        	cntr_no = sheetObjects[0].CellValue( row, 2 ); 
        	crn_no  = sheetObjects[0].CellValue( row, 13 ); 
        	bkg_No2 = sheetObjects[0].CellValue( row, 14 ); 
        	
       	
        	
        	
        	//alert("start");
        	if(sheetObjects[2].RowCount >0)
		    {
		    	//alert("test");
        		for(var i=1; i<sheetObjects[2].RowCount+1; i++){
		    		 
		    		if(sheetObjects[2].CellValue(i, "ibflag") == "I")
		    		{       					 
		    			//alert("test I");
		    			if(cntr_noTEMP == "")
		    			{
		    				ComShowCodeMessage('BKG00565');
		    				return false;
		    			}
		    			//if(sheetObjects[2].CellValue( i, "cntr_mf_seq" )== "")
		    			//{
		    			//	ComShowCodeMessage('BKG00578');
		    			//	return false;
		    			//}
		    			sheetObjects[2].CellValue2( i, 10 ) = cntr_noTEMP;
		        		sheetObjects[2].CellValue2( i, 11 ) = crn_noTEMP;
		        		sheetObjects[2].CellValue2( i, 12 ) = bkg_No2TEMP;    					        		 
		    			sheetObjects[2].Copy2SheetCol(sheetObjects[1],"","",i,i,-1,2,true,false,"","");
		    			sheetObjects[1].CellValue2( i, 14 ) = sheetObjects[2].CellValue(i, 15 );   
		    			
		    		}
		    		if(sheetObjects[2].CellValue(i, "ibflag") == "U")
		    		{
		    			//alert("test U");
		    			var row1 = sheetObjects[2].CellValue(i,14);
		    			//sheetObjects[1].CellValue2(row1,2) = sheetObjects[2].CellValue(i,2);
		    			sheetObjects[1].CellValue2(row1,3) = sheetObjects[2].CellValue(i,3);
		    			sheetObjects[1].CellValue2(row1,4) = sheetObjects[2].CellValue(i,4);
		    			sheetObjects[1].CellValue2(row1,5) = sheetObjects[2].CellValue(i,5);
		    			sheetObjects[1].CellValue2(row1,6) = sheetObjects[2].CellValue(i,6);
		    			sheetObjects[1].CellValue2(row1,7) = sheetObjects[2].CellValue(i,7);
		    			sheetObjects[1].CellValue2(row1,8) = sheetObjects[2].CellValue(i,8);
		    			sheetObjects[1].CellValue2(row1,9) = sheetObjects[2].CellValue(i,9);
		    			sheetObjects[1].CellValue2(row1,10) = sheetObjects[2].CellValue(i,10);
		    			sheetObjects[1].CellValue2(row1,11) = sheetObjects[2].CellValue(i,11);
		    			sheetObjects[1].CellValue2(row1,12) = sheetObjects[2].CellValue(i,12);
		    			sheetObjects[1].CellValue2(row1,13) = sheetObjects[2].CellValue(i,13);     					    		 
		    			replaceStr(sheetObjects[2].CellValue(i,15),i)    					    					    			 
		    			sheetObjects[1].CellValue2(row1,14) = sheetObjects[2].CellValue(i,15);      					    			 
		    		}
		    		//if(sheetObjects[2].CellValue(i, "ibflag") == "D")
		    		//{
		    		//	var row1 = sheetObjects[2].CellValue(i,14);
		    		//	sheetObjects[1].CellValue2(row1,"ibflag") = "D";
		    		//}		    		
		    	}
		    }
        	

        	
        	sheetObjects[2].RemoveAll(); 
        	
        	
        	sheetObjects[0].CellValue2( row,1 ) = 1;
        	deleteRowIndex = row;  
            if(ComGetLenByByte(sheetObjects[0].CellValue( row, 2 )) != 0)
            {            	 
            	
            	for(var i=0; i<sheetObjects[1].RowCount; i++){
            		var cmcntrNo    = sheetObjects[1].CellValue( i+1, 10 );
            		var cmcrnNo     = sheetObjects[1].CellValue( i+1, 11 );
            		var cmbkgNo     = sheetObjects[1].CellValue( i+1, 12 );       
            		//cntr_no  		= sheetObjects[1].CellValue( i+1, 10 );
            		//crn_no   		= sheetObjects[1].CellValue( i+1, 11 );
            		//bkg_No2  		= sheetObjects[1].CellValue( i+1, 12 );  
        		 
            		if ( cntrNo == cmcntrNo && crnNo == cmcrnNo && bkgNo == cmbkgNo 
        				&& sheetObjects[1].CellValue( i+1, "ibflag" ) != "D")
            		{
            			sheetObjects[2].DataInsert(-1);  
        			 
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 0 ) = "R"; 
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 2 ) = sheetObjects[1].CellValue( i+1, 2 );    
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 3 ) = sheetObjects[1].CellValue( i+1, 3 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 4 ) = sheetObjects[1].CellValue( i+1, 4 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 5 ) = sheetObjects[1].CellValue( i+1, 5 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 6 ) = sheetObjects[1].CellValue( i+1, 6 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 7 ) = sheetObjects[1].CellValue( i+1, 7 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 8 ) = sheetObjects[1].CellValue( i+1, 8 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 9 ) = sheetObjects[1].CellValue( i+1, 9 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 10 ) = sheetObjects[1].CellValue( i+1, 10 ); 
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 11 ) = sheetObjects[1].CellValue( i+1, 11 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 12 ) = sheetObjects[1].CellValue( i+1, 12 );  
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 13 ) = sheetObjects[1].CellValue( i+1, 13 );   
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 15 ) = sheetObjects[1].CellValue( i+1, 14 );   
            			sheetObjects[2].CellValue2( sheetObjects[2].RowCount, 14 ) = i+1; 
            		}        		        	
            	}
            }  
            
         	cntrNoTEMP  = cntrNo; 
        	crnNoTEMP   = crnNo; 
        	bkgNoTEMP   = bkgNo;
        	cntr_noTEMP = cntr_no; 
        	crn_noTEMP  = crn_no; 
        	bkg_No2TEMP = bkg_No2;              
             
        }


        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 switch (sAction) {
        	 case IBSEARCH: // 조회
        	 
  		     if(ComGetLenByByte(formObj.frm_crn_number) == 0)
  		     {
  		    	ComShowCodeMessage('BKG00608');
   				formObj.frm_crn_number.focus();
   				return false;
  		     }
   			 
        	 if (ComGetLenByByte(formObj.bl_no) == 0) {
    				ComShowCodeMessage('BKG00609');
    				formObj.bl_no.focus();
    				return false;
        	 }   			      		     	
        	 return true;
   				break;
   				
   			
        	 case IBSAVE:        //저장
        		 
        		 // Container 시트의 Weight Unit 체크
        		 if(sheetObjects[0].RowCount >0){
        			 for(var i= sheetObjects[0].HeaderRows; i<= sheetObjects[0].LastRow; i++) {
        				 if((sheetObjects[0].CellValue( i, "cntr_wgt_ut_cd" ) != "KGS") 
        				 	&& (sheetObjects[0].CellValue( i, "cntr_wgt_ut_cd" ) != "LBS")
        				 	&& (sheetObjects[0].CellValue( i, "cntr_wgt_ut_cd" ) != "PND")
        				 	&& (sheetObjects[0].CellValue( i, "ibflag" ) != "D")){
        					 ComShowCodeMessage('BKG06150', 'KGS, LBS or PND');
        					 return false;
        				 }
			    	}
			     }
        		 
        		 // Cargo 시트의 Weight Unit 체크
        		 // 제일 마지막 row 는 total 을 보여주는 row 이므로 단위 체크에서 제외
        		 if(sheetObjects[2].RowCount >0){
        			 for(var i= sheetObjects[2].HeaderRows; i<= sheetObjects[2].LastRow; i++) {
        				 if((i != sheetObjects[2].LastRow)
        					&& (sheetObjects[2].CellValue( i, "cntr_wgt_ut_cd" ) != "KGS") 
        				 	&& (sheetObjects[2].CellValue( i, "cntr_wgt_ut_cd" ) != "LBS")
        				 	&& (sheetObjects[2].CellValue( i, "cntr_wgt_ut_cd" ) != "PND")
        				 	&& (sheetObjects[2].CellValue( i, "ibflag" ) != "D")){
        					 ComShowCodeMessage('BKG06150', 'KGS, LBS or PND');
        					 return false;
        				 }
			    	}
			    }
			    return true;
   				break;
   				
        	 }            
        }
         
        
         /**
          * 
          * @param SheetObj
          * @param Row
          * @param Col
          * @return
          */ 
         function sheet3_OnClick(SheetObj, Row, Col){
         	deleteRowIndex2 = sheetObjects[2].CellValue( sheetObjects[2].RowCount, 14 );           	 
         	deleteRowIndex3 = Row;        
//         	sheetObjects[2].CellValue2( Row, 1 ) = 1;  
         	
         	 if (SheetObj.ColSaveName(Col) == "cntr_mf_desc2")
         	 {
         		ComShowMemoPad2(SheetObj,Row,15,false,326,100,4000,8);         		
         	 }         		          	 
         }
          /**\
           * 
           * @param str
           * @param Row
           * @return
           */
         function replaceStr(str,Row)
         {
        	 var pck_desc = "";
          	pck_desc = replaceAll(str,"'","^");           
          	sheetObjects[2].CellValue2( Row, 15 ) = pck_desc;           
         }
          
         
         /**
          * IBSheet에 셀 클릭시 팝업 처리
          * @param sheetObj
          * @param Row
          * @param Col
          * @return
          */ 
    	function sheet3_OnPopupClick(sheetObj, Row, Col)
    	{
    		var colName = sheetObj.ColSaveName(Col);
    		var formObj = document.form;    			    	      	 
    		var pck_desc = sheetObjects[2].CellValue(Row,'cntr_mf_desc');
    		 
    		pck_desc = replaceAll(pck_desc,"\r\n","<br>");
    		 
    		var sUrl = "/hanjin/ESM_BKG_1016.do?pgmNo=ESM_BKG_1016&pck_desc="+pck_desc;     		  	     		 
    		var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_1016", 300, 300, true);    	    
    		if (rtnVal != null){    		  				 
    		  		sheetObj.CellValue2(Row, 'cntr_mf_desc') = rtnVal.nm;    
    		  		if(sheetObjects[2].CellValue( sheetObjects[2].RowCount, 14 ) > 0)    		  
    		  		  sheetObjects[1].CellValue2(sheetObjects[2].CellValue( sheetObjects[2].RowCount, 14 ), 'cntr_mf_desc') = rtnVal.nm;
    		 }
    	  	     
    	}
        /**
        * 값을 치환
        * @param strTemp 
        * @param strValue1 
        * @param strValue2 치환 변수
        * @return
        */
        function replaceAll(strTemp,strValue1,strValue2)
        {
             while(1){
            	 if(strTemp.indexOf(strValue1) != -1)
            		 strTemp = strTemp.replace(strValue1,strValue2);
            	 else
            		 break;
             }
             return strTemp;
        }
        /**
         * Enter 이벤트
         * @return
         */
        function obj_ComKeyEnter() {
        	
         	var formObject = document.form;
         	var srcName = window.event.srcElement.getAttribute("name");
            
         	if(srcName != "fax_no" && srcName != "cust_eml" 
         		&& srcName != "shpr_addr1" && srcName != "cnee_addr1" && srcName != "ntfy_addr1"
         		&& srcName != "shpr_addr2" && srcName != "cnee_addr2" && srcName != "ntfy_addr2" && srcName != "") {         		 
         		ComKeyEnter();
         	}         	         
        }
         /**
     	 * IBSheet의 특정셀의 글자가 줄바꿈되어 한눈에 볼수 없을때 MemoPad를 이용하여 확인하거나 값을 변경할 때 사용한다. <br>
     	 * MemoPad는 TextArea와 버튼으로 구성되며, 값을 확인하고 MemoPad를 닫을때는 ESC키를 누르거나 Close 버튼을 누르거나 HTML 영역을 클릭한다. <br>
     	 * MemoPad가 표시될 위치의 셀은 반드시 편집불가능이어야 한다. <br>
          * <br><b>Example :</b>
          * <pre>
          *    function sheet1_OnClick(sheetObj, Row, Col, Value) {
          *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
          *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj);
          *    }
          *    function sheet2_OnClick(sheetObj, Row, Col, Value) {
          *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집불가능)
          *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj, Row, Col, true);
          *    }
          * </pre>
          * @param {ibsheet} 	sheetObj    필수,IBSheet Object
          * @param {int} 		row    		선택,MemoPad를 표시할 셀의 행 Index, default=sheetObj.SelectRow
          * @param {int} 		col    		선택,MemoPad를 표시할 셀의 컬럼 Index, default=sheetObj.SelectCol
          * * @param {int} 		col2    	선택,MemoPad를 표시할 위치 계산값
          * @param {bool} 		bReadOnly	선택,MemoPad에 표시된 값의 편집가능 여부, default=true
          * @param {int}    		iWidth		선택,MemoPad의 넓이, default=200
          * @param {int}    		iHeight		선택,MemoPad의 높이, default=200
          * @see #ComHideMemoPad
          * @return 없음<br>
     	 */
         function ComShowMemoPad2(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax,col2) {
     		try{
     			//함수의 인자 default 값 설정하기			
     			if (row == undefined 		|| row == null) 		row=sheetObj.SelectRow;
     			if (col == undefined 		|| col == null) 		col=sheetObj.SelectCol;
     			if (bReadOnly == undefined  || bReadOnly == null) 	bReadOnly=false;
     			if (iWidth == undefined 	|| iWidth == null) 		iWidth = 200; 
     			if (iHeight == undefined 	|| iHeight == null) 	iHeight = 200; 
     			if (iMax == undefined 	    || iMax == null) 	    iMax = 4000; 

     			//메모를 위한 IBSheet 정보의 Validation 확인하기
     			if (sheetObj.CellEditable(row,col)) {
     				return ComShowMessage("[ComShowMemoPad] "+ sheetObj.id + "(" + row + "," + col + ") 셀은 편집불가능이어야 합니다.");
     			}
     			//메모를 위한 IBSheet 정보 받기
     			if (!ComIsNumber(col)) col = sheetObj.SaveNameCol(col);
     	        memoSheet=sheetObj;
     	        memoRow=row;
     	        memoCol=col;

     			//메모메드 만들기
     	        
     	        momo_imsi = sheetObj.CellText(row,col);
     			if (!initMemoPad2(iMax)) return;
     			
     	        //메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
     	        var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col2) + 2;
     	        var iTop  = AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row)  + 2;
     	        if (sheetObj.CountPosition!= 0)  iTop += 16; //건수정보가 표시될 때 표시위치를 조금 내린다.
     	
                 //현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
                 if (top.document != document && window.frameElement.scrolling=="no") {
                 	//높이초과
                 	if (iTop + iHeight  > document.body.clientHeight) {
                 		iBottom = iTop + sheetObj.RowHeight(row);
                 		if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;  
                 		iTop = iBottom-iHeight;
                 		if (iTop <0) iTop = 0
                 	}
                 	
                 	//넓이초과
                     if (iLeft + iWidth  > document.body.clientWidth)   {
                     	iLeft = document.body.clientWidth - iWidth;    
                     	if (iLeft<0) iLeft = 0;
                     }
                 }

     	        var _divMemo = document.getElementById(MEMO_DIV_NAME);
     	        var _frameDoc  = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
     	
     			_frameDoc.getElementById("btn_apply").style.display = (bReadOnly)?"none":"inline";
     	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor = bReadOnly?"#E8E7EC":"";
     	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily  = sheetObj.SheetFontName;
     	        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize  = 11;
     			_frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight-25;
     	        _frameDoc.getElementById(MEMO_TEXT_NAME).value = sheetObj.CellText(row,col);
     	        _frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = bReadOnly;

     			_divMemo.style.width = iWidth;
     			_divMemo.style.height = iHeight;
     	        _divMemo.style.top = iTop;
     	        _divMemo.style.left = iLeft;
     	        _divMemo.style.visibility = "visible";
     	        _divMemo.focus();	
     	        
     	        ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
             } catch(err) { ComFuncErrMsg(err.message); }
     	}
     	/**
          * MemoPad를 위한 DIV안에 iFrame을 만들고, iFrame안에 Textarea와 버튼을 생성한다. <br>
          * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
          */
     	function initMemoPad2(iMax) {
     		try {
     	        //메모용 Div가 없으면 생성한다.
     	        if (document.getElementById(MEMO_DIV_NAME) != null) return true;
     			
     			//메모용 Div 만들기	        
     	        var _divMemo=document.createElement("<div id='"+  MEMO_DIV_NAME +"' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
     	        document.body.insertBefore(_divMemo);

     	        //메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
     	        var _frameMemo = document.createElement("<IFRAME id='"+MEMO_FRAME_NAME+"' src='' frameborder=0 marginHeight=0 marginWidth=0 width=100% height=100% />");
     	        _divMemo.appendChild(_frameMemo);	        
     	
     	        var _FrameDoc = _frameMemo.contentWindow.document;

     			//iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
     	        var _FrameDiv=_FrameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
     	        _FrameDoc.appendChild(_FrameDiv);
     	        
     			//Div안에 Textarea 만들기
     	        var _area = _FrameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME +"' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
     	        _FrameDiv.appendChild(_area);
     	        
     	        //Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
     	        var _centerTag = _FrameDoc.createElement("<center>");
     	        _FrameDiv.appendChild(_centerTag);
     			
     			//Apply 버튼 만들기
     	        var _button1 = _FrameDoc.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemoValue2(document.getElementById(\""+MEMO_TEXT_NAME+"\").value,"+iMax+");'/>");
     	        _button1.innerHTML = "Apply";
     	        _centerTag.appendChild(_button1);
     	        
     			//Close 버튼 만들기
     	        var _button2 = _FrameDoc.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
     	        _button2.innerHTML = "Close";
     	        _centerTag.appendChild(_button2);
     	        
     	        //메모용 iFrame 자동 닫기 처리
     	        if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
     		        //Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
     		        window.popupMemoOldEventListener = document.onmouseup;
     		        if (window.popupMemoOldEventListener != null) {
     		        	//alert("CoObject \n" + window.popupMemoOldEventListener.toString());
     		            //기존에 document.onmouseup에  정의된 함수가 있는 경우
     		            document.onmouseup = new Function("window.popupMemoOldEventListener(); ComHideMemoPad();");
     		        } else {
     		            //기존에 document.onmouseup에  정의된 함수가 없는 경우
     		            document.onmouseup = ComHideMemoPad;
     		        }
     		        
     		        //ActiveX에 포커스가 갔을때 메모DiV 닫기
     		        var objs = document.getElementsByTagName("OBJECT")
     				window.popupMemoOldObjEventListener = new Array(objs.length);
     		        for(var i = 0 ; i < objs.length ; i++){
     			        window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
     			        if (window.popupMemoOldObjEventListener[i] != null) {
     			            //기존에 document.onmouseup에  정의된 함수가 있는 경우
     			            objs[i].onfocus = new Function("window.popupMemoOldObjEventListener["+i+"](); ComHideMemoPad();");
     			        } else {
     			            //기존에 document.onmouseup에  정의된 함수가 없는 경우
     			            objs[i].onfocus = ComHideMemoPad;
     			        }
     		        }
     	        }
             } catch(err) { ComFuncErrMsg(err.message); return false;}
             return true;
     	} 
     	/**
         * MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
         * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
         */
    	function setMemoValue2(sValue,iMax) {
    		try {
    			//alert(sValue); 
    			if(sValue.length > iMax){    				
    				ComShowMessage("characters long");
//    				document.getElementById(MEMO_FRAME_NAME).focus();
    				return;
    			}else{
    				//alert("test1");
    				if (memoSheet == null) return; 
    				//alert(momo_imsi);
    				//if(momo_imsi == "")
    				//{
    					//alert("test3");
    					memoSheet.CellValue2(memoRow, "cntr_mf_desc2") = sValue;
    				//}
    					///alert(memoCol);
    				memoSheet.CellValue2(memoRow, memoCol) = sValue;
    				//alert(memoCol);
    				ComHideMemoPad(true);
    			}
            } catch(err) { ComFuncErrMsg(err.message); }
    	}
        /**
         * 그리드에 있는 
         * @param formObj
         * @param sheetObj
         * @return
         */ 
         function sheet2_total_setup(formObj, sheetObj){
        	 var pck_qty = 0;
        	 var cntr_mf_wgt = 0;
        	  
        	 for(var i = 1; i <= sheetObjects[2].rowCount; i++){        		 
        		 pck_qty       =  pck_qty + sheetObjects[2].CellValue(i,"pck_qty");
        		 cntr_mf_wgt   =  cntr_mf_wgt + sheetObjects[2].CellValue(i,"cntr_mf_wgt");        		 
        	 }
            document.all.t2simple.innerHTML = pck_qty;
		   	document.all.t3simple.innerHTML = cntr_mf_wgt;        	 
         }
         /**
          * 조회조건 입력할 때 처리
          */
         function obj_KeyUp() {
        		var formObject = document.form;
        		var srcName = window.event.srcElement.getAttribute("name");
        		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
        		var srcValue = window.event.srcElement.getAttribute("value");

        		if (  ( srcName == "frm_crn_number" || 
        				srcName == "vvd_number" || 
        				srcName == "bl_no")         				 
        			&& ComChkLen(srcValue, srcMaxLength) == "2") 
        		{
        			ComSetNextFocus();
        		}
        	}
          
          function bkg0042_keypress(){
          	var srcName = window.event.srcElement.getAttribute("name");
          	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
      	    switch(event.srcElement.dataformat){
      	    case "engup":
  	        //영문대문자
      			ComKeyOnlyAlphabet('upper');
  	        	break;
      	    case "engupnum":
      	    	//숫자+"영문대분자"입력하기
      	    	ComKeyOnlyAlphabet('uppernum');
      	    	break;
      	    case "engupspace": //영문대문자 + Space
      	    	if(event.keyCode != 32) {
      	    		ComKeyOnlyAlphabet('uppernum');
      	    	}	        
      	    case "custname":
      	    	//숫자+"영문대분자"입력하기
      	    	ComKeyOnlyAlphabet('uppernum','32');
      	    	break;
      	    case "engdnnum":
      	    	//숫자+"영문대분자"입력하기
      	    	ComKeyOnlyAlphabet('lowernum');
      	    	break;
      	    case "int":
      	    	//숫자 입력하기
      	    	ComKeyOnlyNumber(event.srcElement);
      	    	break;	            
      	    case "address":
      	    	//숫자+"영문대분자"입력하기
      	    	ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
      	    	break;
      	    case "num":
      	    case "zipcode":
      	    	//숫자 입력하기
      	    	ComKeyOnlyAlphabet('uppernum','45|32');
      	    	break;	            
  	        case "etc": //모든 문자 가능하지만 영문은 대문자로
  	        	if(keyValue >= 97 && keyValue <= 122) {//소문자
  	        		event.keyCode = keyValue + 65 - 97;
  	        	}
          		break;	        	            
      	    default:
      	    }
      	}         
         
        
         