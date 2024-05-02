/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0005.js
*@FileTitle : Accrual Result by CNTR
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.08.12
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.12 전재홍
* 2011.10.12 김종호 : Acct. Code 만 입력시에 검색이 불가능하도록 변경
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
     * @class ESD_LEA_0005 : ESD_LEA_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0005() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":  		
    			  		sheetObject.RemoveAll();
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

            	    case "btng_downexcel":
//    									lea_form2sheet(formObject,sheetObject1);
//    									sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
//    									sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);
    									//doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
            	        break;

            	    case "btns_acct_search":
    									window.showModalDialog('ESD_LEA_0901.do', window, "dialogWidth:800px; dialogHeight:480px; help:no; status:no; resizable:yes;");
            	        break;

            	    case "btns_rev_vvd_search":
    									var url_str = "ESD_LEA_0902.do";
    									url_str += "?exe_yrmon="	+formObject.frm_exe_yrmon.value;
										url_str += "&rev_yrmon="		+formObject.frm_rev_yrmon.value;
    									window.showModalDialog(url_str, window, "dialogWidth:600px; dialogHeight:480px; help:no; status:no; resizable:yes;");
            	    	                //ComOpenWindow(url_str, "RevVVD", "statebar = no , width= 600 , height=500" );
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
             var sheetObj = sheetObjects[0];
             var formObj = document.form;

            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }

            if(formObj.winopen_div.value == "POP")
    	    	  doActionIBSheet(sheetObj,formObj,IBSEARCH);

        }

       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;
                        
                     // 높이 설정
    					style.height = 400;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(23, 2, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "SEQ|CNTR No.|TP/SZ|Activity Group|QTY|1st Node|2nd Node|Account\nCode|Cost Code|Cost Code|Contract|Contract|Inv.Count|Inv.Count|Estimated\nCost|Actual Cost|Actual Cost|Actual Cost|Actual Cost|Actual Cost|Accrual\nCost|Confirmed\nCost|Cost\nDiff" ;
                        var HeadTitle1 = "SEQ|CNTR No.|TP/SZ|SEQ|QTY|1st Node|2nd Node|Account\nCode|Code|Type|Ini|Rev|Actual|Total|Estimated\nCost|By CNTR|By BKG|By VVD|By Yard|Total|Accrual\nCost|Confirmed\nCost|Cost\nDiff" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtSeq    		,       30,    daCenter,  true,    "",        false,          "",       dfNone,   	0,     true,        true);
                        InitDataProperty(0, cnt++ , dtData   		,       80,    daCenter,  true,    "cntr_no"         		 ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       40,    daCenter,  true,    "cntr_tpsz_cd"         ,        false,          "",       dfNone,     	0,     false,       false);
                        //InitDataProperty(0, cnt++ , dtData   		,      120,    daCenter,  true,    "cost_act_grp_nm"      ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       100,    daCenter,  true,    "cost_act_grp_seq"     ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden		,       50,    daCenter,  true,    "cntr_qty"             ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       70,    daCenter,  true,    "n1st_nod_cd"          ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       70,    daCenter,  true,    "n2nd_nod_cd"          ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       70,    daCenter,  true,    "acct_cd"              ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       70,    daCenter,  true,    "lgs_cost_cd"          ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       40,    daCenter,  true,    "accl_lgc_tp_cd"       ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       40,    daCenter,  true,    "cost_ass_bse_cd"      ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   		,       40,    daCenter,  true,    "ctrt_rtn_flg"         ,        false,          "",       dfNone,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData			,       40,    daRight,   true,    "act_inv_knt"          ,        false,          "",       dfNullInteger, 0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData			,       40,    daRight,   true,    "ttl_inv_knt"          ,        false,          "",       dfNullInteger, 0,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "estm_cost_amt"        ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "act_cntr_cost_amt"    ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "act_bkg_cost_amt"     ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "act_rev_vvd_cost_amt" ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "act_com_vvd_cost_amt" ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "act_cost_amt"         ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "accl_cost_amt"        ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "confirmed_cost_amt"   ,        false,          "",       dfFloat,  	2,     false,       false);
                        InitDataProperty(0, cnt++ , dtAutoSum		,       90,    daRight,   true,    "cost_diff_amt"        ,        false,          "",       dfFloat,  	2,     false,       false);

                        RangeBackColor(1, 2, 1, 20) = RgbColor(222, 251, 248);   // ENIS
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                        //style.height = GetSheetHeight(13) ;
                   }
                    break;
                case 2:      //IBSheet1 init
                    with (sheetObj) {
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(5, 0, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle  = "Exe.Month|Rev.Month|Account Code|Rev.VVD|BKG#" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "exe_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "rev_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "acct_cd"           ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "rev_vvd_cd"        ,        false,          "",       dfNone ,     	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "bkg_no"            ,        false,          "",       dfNone ,     	0,     false,       false);

                        style.height = GetSheetHeight(13) ;
                   }
                    break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {
            
               case IBSEARCH:      //조회
            	   
                   if(!validateForm(sheetObj,formObj,sAction)) return false;
                   
				    	formObj.f_cmd.value = SEARCH;
				    	
				    	//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0005GS.do", FormQueryString(formObj));
				    	
				    	//FormQueryString =>  leaFormQueryString 변경
						var searchXml = sheetObj.GetSearchXml("ESD_LEA_0005GS.do", leaFormQueryString(formObj));
						
					    //ComShowMessage(searchXml);
					    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
                    break;
                    
    					case IBDOWNEXCEL:        // excel down
    		
    						//if(validateForm(sheetObj,formObj,sAction))
    						/*
    							mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge],  [SaveAsName],[ReportPageUrl],[HideExcelMsg],
                                     [WriteTreeLevel], [WorkSheetName], [FocusFirstSheet]) 
                */
    						sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "",true);
    						break;

            }
        }

    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
    	   sheetObj.SumText(0,0) = "";
    	   sheetObj.SumText(0,1) = "Grand Total" ;
//    	   sheetObj.SumBackColor  	= sheetObj.RgbColor(153,153,255);
    		 sheetObj.SumFontBold 		= true;
    	}

       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	
        		//if(!lea_comm_validChkForm(formObj)) return false;

        	
//    	  		if((formObj.frm_acct_cd.value == "" || formObj.frm_acct_cd.value == null || formObj.frm_acct_cd.value == "ALL") &&
//    	  		   (formObj.frm_vvd_no .value == "" || formObj.frm_vvd_no .value == null || formObj.frm_vvd_no .value == "ALL") &&
//    	  		   (formObj.frm_bkg_no .value == "" || formObj.frm_bkg_no .value == null) ){

        	//Acct. Code 만 입력시에 검색이 불가능하도록 변경
	  			if((formObj.frm_vvd_no .value == "" || formObj.frm_vvd_no .value == null || formObj.frm_vvd_no .value == "ALL") &&
	     	  		(formObj.frm_bkg_no .value == "" || formObj.frm_bkg_no .value == null) ){
    	  			
    	  		   	ComShowMessage("Please enter Rev. VVD or BKG No.");
    	  		   	return false;
    	  		}
            return true;
        }
       /**
         * EnterKey Event 조회 프로세스 처리
         */
    		function lea_enterRetrieve(){
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
    			  sheetObject.RemoveAll();
     				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    			
    		}
       /**
         * Form Data를Sheet로 Copy 프로세스 처리
         */
    		function lea_form2sheet(formObj,sheetObj){
    			
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row , "exe_yrmon" ) = formObj.frm_exe_yrmon.value;
    			sheetObj.CellValue(Row , "rev_yrmon" ) = formObj.frm_rev_yrmon.value;
    			sheetObj.CellValue(Row , "acct_cd"   ) = formObj.frm_acct_cd  .value;
    			sheetObj.CellValue(Row , "rev_vvd_no") = formObj.frm_vvd_no   .value;
    			sheetObj.CellValue(Row , "bkg_no"    ) = formObj.frm_bkg_no   .value;
    		}


	/* 개발자 작업  끝 */