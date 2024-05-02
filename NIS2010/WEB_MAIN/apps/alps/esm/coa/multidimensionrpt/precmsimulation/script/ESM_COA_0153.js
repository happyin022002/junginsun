/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0153.js
*@FileTitle : Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2010-02-22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.09.15 송호진
* 1.0 Creation
*=========================================================
* History
* 2008-05-16 Ari
* 1.0 최초 생성 CSR No.N200804140004, N200804146015, N200804146018
* 2008.07.02 전성진 CSR No.N200807070015
*                   - Route error message 출력 관련 수정
* 2008.08.12 전성진 CSR No.N200808128626
*                   - AGT 관련 Message 출력. AGT 수정될 때까지 임시로 메세지 사용
* 2008.09.92 전성진 CSR No.N200809030003
*                   - f_cob_profit_vw 선택에 따라 tradeLv/officLv의 style 변경함
* 2009-03-05 Ari CSR No.N200902250060 DEM/DET, MRI MISC Rev 추가
* 2009-03-05 Ari CSR No.N200902250060 MRI 쿼리 변경
* 2009-03-06 Ari CSR No.N200902250060 MRI 쿼리 변경
* 2009-04-20 Ari CSR No.N200904070080 CM/OP 변경에 따른 dem/det처리
* 2009-04-21 Ari CSR No.N200904070080 CM/OP 변경에 따라 CM계산시 Office조건 빠질수 있도록 처리
* 2009-06-10 박상희  N200905110270 COA_Pre CM/OP Simulation : Temp T/S Route 입력기능
*                                 Temp P/C Generation 검색 후 다시 Retrieve버튼 클릭 시, 검색 입력 된 값을 기초로 하여 검색 값을 보여 줌
* 2009-10-08 송호진 ALPS 전환
* 2009-10-22 송호진 PRD 연동 부분 ALPS 전환
* 2010-02-22 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.12.13 최성민 [CHM-CHM-201115090-01] 검색데이터 디폴트값 세팅
* 2011.12.21 최윤성 [CHM-201115260-01] [COA] Pre CM/OP Simulation화면 U.I 변경요청 - avg_lvl_chk 추가 하여 값에 따라 색상 및 Bold 처리
* 2012.01.02 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
* 2012.02.20 김종준 [CHM-201216268-01] [COA] Pre CM/OP 화면 Backandjob로 조회로  로직 변경
* * 2012.03.09 이석준 [CHM-201216641] R/D Term Default를 CY로 변경하고, Combo에 Code+Name 값으로 보일 수 있도록 수정
* 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 - MTY P/Up CY 조회조건 추가 (Pre CM/OP Simulation)
* 2012.08.22 최윤성 [CHM-201219661] [COA] Pre CM/OP SImulation 화면상 Voide 조건에 따른 AWK Surcharge 추정 로직 변경
*                                  - Special Cargo 에 AWK를 선택 했을 시 CNTR Type 이 O,S,F,A 일 경우에 Void 필수로직 추가
* 2013.06.12 성미영 [CHM-201325207] COA preCM 에러 수정 관련                                  
* 2013.12.04 김수정 [CHM-201327857] [COA] Pre CM 조회시 에러 메세지 관련 - Backend Job으로 변경
* 2013.12.13 김수정 [CHM-201328111] [COA] EMU COST 변경 로직 Pre CM 반영 요청 - DEL Code, DEL Term 에 따른 MT Return CY 조회 추가
* 2014.07.08 최덕우 [CHM-201431086] [COA] Pre-CM 진행 금지 Route 관련 Pop-up 기능 추가
* 2014.12.10 이영헌 [CHM-201433087] Pre-CM/OP simulation 기능 추가 요청 CSR
* 2015.05.18 손진환 [CHM-201535827] [COA] Pre-CM/OP Simulation 상 MTY Pick Up CY가 자동으로 똑같이 들어가는 로직 수정
*=========================================================*/
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
     * @class ESM_COA_0153 : ESM_COA_0153 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0153() {
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

 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0; 
    var sheet1_maxRows = 7; //최대로우수
    var sheet2_maxRows = 16;
    var result_key = "";
    
    var PROF_LVL_CD = "C|M";	//Profit Level Code
    var PROF_LVL_NM = "CM|CM2";	//Profit Level Name
    var PROF_LVL_XML = "";		//Profit Level Xml Data

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
         				formObject.f_pc_creation.value = "N";
         				document.getElementById("btns_constraints").style.color = "#737373";
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    					break;

    				case "btng_costdetail":
    					if (sheetObject.CellValue(sheetObject.SelectRow, "remark_img") == "1") {
    		    			document.getElementById("btns_constraints").style.color = "red";
    		    		} else {
    		    			document.getElementById("btns_constraints").style.color = "#737373";
    		    		}
    					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    					break;

    				case "btns_remarks":
    					btng_remarks_OnClick(sheetObject1);
    					break;

    				case "bu_zoom_in1":
    					if(sheetObject.Rows > sheet1_maxRows){
    						sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.Rows+1);
    						div_zoom_out1.style.display = "inline";
    						div_zoom_in1.style.display = "none";
    						parent.syncHeight();
    					}
    					break;

    				case "bu_zoom_out1":
    					if(sheetObject.Rows > sheet1_maxRows ){
    						sheetObject.style.height = sheetObject.GetSheetHeight(sheet1_maxRows);
    						div_zoom_in1.style.display = "inline";
    						div_zoom_out1.style.display = "none";
    						parent.syncHeight();
    					}
    					break;

    				case "bu_zoom_in2":
    					if(sheetObject1.Rows>sheet2_maxRows){
    						sheetObject1.style.height = sheetObject1.GetSheetHeight(sheetObject1.Rows+1);
    						div_zoom_out2.style.display = "inline";
    						div_zoom_in2.style.display = "none";
    						parent.syncHeight();
    					}
    					break;

    				case "bu_zoom_out2":
    					if(sheetObject1.Rows>sheet2_maxRows){
    						sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet2_maxRows);
    						div_zoom_in2.style.display = "inline";
    						div_zoom_out2.style.display = "none";
    						parent.syncHeight();
    					}
    					break;

//    				case "btng_reset":
//    					doActionIBSheet(sheetObject,formObject,IBRESET);
//                        loadPage();
//    					break;

                    case "btng_pccreation":
                        formObject.f_pc_creation.value = "Y";
                        document.getElementById("btns_constraints").style.color = "#737373";
        				doActionIBSheet(sheetObject,formObject,IBSEARCH);
        				break;
        				
                    case "btns_constraints":
                    	if (document.getElementById("btns_constraints").style.color == "red") {
                    		fnPopConstraintDetail(formObject.f_pctl_no.value);
                    	}
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
    	* Sheet 기본 설정 및 초기화
    	* body 태그의 onLoad 이벤트핸들러 구현
    	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	*/
    	function loadPage() {
    		var formObject = document.form;
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			sheetObjects[i].RemoveAll();
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}

    		loadingMode = true;
    	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

            // Profit Level 초기값 세팅 - Profit View 의 초기값이  Trade 일 경우
    		ComTextCode2ComboItem(PROF_LVL_CD,PROF_LVL_NM, formObject.f_cob_profit_lv);
    		
    	    // 멀티콤보 처리
    		//---------------------------------------------
    		for(k=0;k<comboObjects.length;k++){
    			initCombo(comboObjects[k], comboObjects[k].id);
    		}
    		//---------------------------------------------
    		loadingMode = false;
    		

    	    //Axon 이벤트 초기화
    	    initControl();
    	    

            //Default 세팅
            formObject.f_qty.value = "1";            
            document.getElementById("f_cntr_tpsz_cd").Code2 = "D4";
            
            //focusing
            formObject.f_g_rev.focus();

            //default값 넣기 TEST용
            //setTestDefaultValue();
    	}

    	/**
    	* 시트 초기설정값, 헤더 정의
    	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	*/
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
    		switch(sheetNo) {
    			case 1:	 //sheet1 init
    				with (sheetObj) {
                        SheetWidth = mainTable.clientWidth;//전체 너비 설정
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                        MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                        Editable = false; //전체Edit 허용 여부 [선택, Default false]
                        InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(17, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitHeadMode(true, true, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

                        var HeadTitle = "SEQ|Constraint\n/Ref.|Rem|Ocean\nFlag|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|T/Time\n(day/HR)" ;
                        var HeadTitle1 = "SEQ|Constraint\n/Ref.|Rem|Ocean\nFlag|POR|Inter Change|POL|T/S Route|POD|Inter Change|DEL|MTY RTN CY|T/Time\n(day/HR)" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,   "",             false,          "",       dfNone,   	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtImage,      50,    daCenter,  true,   "remark_img",   false,          "",       dfNone,   	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,  true,   "remark",       false,          "",       dfNone,   	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   "routFlag",     false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "por",          false,          "",       dfNone,	    0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,   "ob_itchg_ctnt",false,          "",       dfNone,   	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "pol",          false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,      230,    daCenter,  true,   "ts_route",     false,          "",       dfNone, 	    0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "pod",          false,          "",       dfNone,	    0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,   "ib_itchg_ctnt",false,          "",       dfNone,   	0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       43,    daCenter,  true,   "del",          false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       75,    daCenter,  true,   "mty_rtn_yd_cd",false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,   "ttl_tztm_hrs", false,          "",       dfUserFormat2,0,     false,       false);
                        //hidden
                        InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "pctl_no",      false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,   "cnst_seq",     false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,   "trnk_lane",    false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "cnst_rmk",     false,          "",       dfNone,       0,     false,       false);

                        HeadRowHeight = "10" ;
                        InitUserFormat2(0, "ttl_tztm_hrs", "##D ##H" , "D|H"  );
                        CountPosition	= 0 ;

            		    CellBackColor(1,"por") = RgbColor(231,250,249);
            		    CellBackColor(1,"ob_itchg_ctnt") = CellBackColor(1,"por")
            		    CellBackColor(1,"pol") = CellBackColor(1,"por")
            		    CellBackColor(1,"ts_route") = CellBackColor(1,"por")
            		    CellBackColor(1,"pod") = CellBackColor(1,"por")
            		    CellBackColor(1,"ib_itchg_ctnt") = CellBackColor(1,"por")
            		    CellBackColor(1,"del") = CellBackColor(1,"por")
            		    CellBackColor(1,"mty_rtn_yd_cd") = CellBackColor(1,"del")
                        ImageList(0) = "/hanjin/img/alps/ico_b.gif" ;
                        ImageList(1) = "/hanjin/img/alps/ico_r.gif" ;

            		    style.height = GetSheetHeight(7) ;
    				}
    				break;
    			case 2:	 //sheet2 init
    				with (sheetObj) {
    					SheetWidth = mainTable2.clientWidth;
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					MergeSheet = msHeaderOnly;//msHeaderOnly; //msAll;
    					Editable = false;
    					InitRowInfo(2, 1, 9, 100);
    					InitColumnInfo(11, 0, 0, true);
    					InitHeadMode(false, false, false, true, false,false);

    					var HeadTitle  = "Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Feeder Term|Feeder Term|Amount|level|avg_lvl_chk" ;
    					var HeadTitle1 = "Node Link|Activity Group|Activity Group|Activity Group|Cost Group/Cost Element|Cost Group/Cost Element|Rev_Term|Del_Term|Amount|level|avg_lvl_chk" ;
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, false);

    					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"nod_cd");
    					InitDataProperty(0, cnt++, dtData,		130,	daLeft,	    true,	"grp");
    					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"dw_nod_cd");
    					InitDataProperty(0, cnt++, dtData,		130,	daCenter,	true,	"dw_grp");
    					InitDataProperty(0, cnt++, dtData,		220,	daLeft,		true,	"tree_col");  // sheet 에서 보여줄 정보
    					InitDataProperty(0, cnt++, dtData,		220,	daLeft,		true,	"dw_tree_col"); // excel down 시 보여줄 정보

    					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_rcv_term_cd");
    					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_de_term_cd");
    					InitDataProperty(0, cnt++ ,dtData,	    80,		daRight,    true,	"amt",		false,	"",		dfNullFloatOrg,	2);
    					InitDataProperty(0, cnt++ ,dtHidden,	70,		daCenter,	true,	"lvl");
    					InitDataProperty(0, cnt++ ,dtHidden,	70,		daCenter,	true,	"avg_lvl_chk");
    					RangeBackColor(1, 6, 1, 7) = RgbColor(222, 251, 248);

    					InitTreeInfo("tree_col", "", RgbColor(0,0,255), false);
    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(16) ;
    					ColHidden("nod_cd")    = false;
    					ColHidden("grp")       = false;
    					ColHidden("tree_col")  = false;
    					ColHidden("dw_nod_cd") = true;
    					ColHidden("dw_grp")    = true;
    					ColHidden("dw_tree_col") = true;
    					ColHidden("lvl") = true;
    				}
    				break;
    		}
    	}

    // 콤보 처리
    //--------------------------------------------------------------------
        /**
		* Tab 기본 설정
		* 탭의 항목을 설정한다.
		*/
		function initCombo (comboObj, comboId) {
            with (comboObj) {
                if (comboId == "f_cob_profit_lv") {
                    MaxLength = 2;
                    ValidChar(2, 0);
                } else if (comboId == "f_cntr_tpsz_cd") {
                    MaxLength = 2;
                    ValidChar(2, 1);
                } else {
                    MaxLength = 5;
                    ValidChar(2, 1);
                }
                IMEMode = 0;
                DropHeight = 300;
                Index2 = 0;
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
         * IBCombo Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
        }


        function getF_por_cd(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_por_cd.value = colArray[3].substr(0, 5);
    		document.form.f_por_node.value = colArray[3].substr(5);
    		
    		document.form.f_mty_pkup_yd_cd.value = colArray[3].substr(0, 5);
    		document.form.f_mty_pkup_yd_node.value = colArray[3].substr(5);
    		
    		document.form.f_pol_cd.focus();
    	}

        function getF_del_cd(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_del_cd.value = colArray[3].substr(0, 5);
    		document.form.f_del_node.value = colArray[3].substr(5);
    		
    		document.form.f_mty_rtn_yd_cd.value = colArray[3].substr(0, 5);
    		document.form.f_mty_rtn_yd_node.value = colArray[3].substr(5);
    		
    		document.form.f_r_term.focus();
/*    		f_del_cd_onKeyUp(colArray[3].substr(0, 5)); */
    	}

        function getF_pol_cd(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_pol_cd.value = colArray[3];
    		document.form.f_pod_cd.focus();
    	}

        function getF_pod_cd(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_pod_cd.value = colArray[3];
    		document.form.f_del_cd.focus();
    	}

        function getF_commodity(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_cmdt_cd.value = colArray[3];
    	}


    	function openCalendar(){
             var cal = new ComCalendar();
    	  	 cal.select(document.form.f_skd_date_fm, 'f_skd_date_fm' , 'yyyy-MM-dd');
    	}

    	function openCommodity(funtionNm){
    		ComOpenPopup('/hanjin/COM_ENS_011.do', 770, 470, funtionNm, "1,0,1,1,1,1,1,1,1,1,1,1");
    	}

    //팝업 처리

    	/**
    	* location code 공통 팝업 오픈
    	*/
    	function openLocationCode(funtionNm){
            if(funtionNm == 'getF_por_cd' || funtionNm == 'getF_del_cd' || funtionNm == 'getF_pkup_yd' || funtionNm == 'getF_rtn_yd') {
            	ComOpenPopup('/hanjin/COM_ENS_061.do', 775, 490, funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);
            } else if(funtionNm == 'getF_pol_cd' || funtionNm == 'getF_pod_cd') {
            	ComOpenPopup('/hanjin/COM_ENS_051.do', 775, 490, funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);
            }
    	}

    	/**
    	* MTY P/Up CY 공통 팝업 오픈
    	*/
        function getF_pkup_yd(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_mty_pkup_yd_cd.value = colArray[3].substr(0, 5);
    		document.form.f_mty_pkup_yd_node.value = colArray[3].substr(5);
    		document.form.f_mty_pkup_yd_cd.focus();
    	}

    	/**
    	* MTY Return CY 공통 팝업 오픈
    	*/
        function getF_rtn_yd(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_mty_rtn_yd_cd.value = colArray[3].substr(0, 5);
    		document.form.f_mty_rtn_yd_node.value = colArray[3].substr(5);
    		document.form.f_mty_rtn_yd_cd.focus();
    	}

    	/**
    	* rowadd 버튼 활성화 시 edit 가능하게 수정해준다.
    	*/
    	function setEdit(){
    	    var sheetObject = sheetObjects[0];
     	    var cnt = sheetObjects[0].RowCount;
     	    for(i=1;i<=cnt;i++){
         	sheetObject.CellEditable(i+1, "por") = true;
         	sheetObject.CellEditable(i+1, "ob_itchg_ctnt") = true;
         	sheetObject.CellEditable(i+1, "pol") = true;
         	sheetObject.CellEditable(i+1, "ts_route") = true;
         	sheetObject.CellEditable(i+1, "pod") = true;
         	sheetObject.CellEditable(i+1, "ib_itchg_ctnt") = true;
         	sheetObject.CellEditable(i+1, "del") = true;
     	    }
    	}

    	function callADD(){
    	    var formObj = document.form;
    	    var sheetObj = sheetObjects[0];

    	    ComOpenWindow2('ESM_COA_0171.do?','vvd_Popup', 'width=700, height=430, menubar=0,status=1,scrollbars=0,resizable=0');
    	}

        /**
         * Location Check
         */
        function checkLoc_onKeyUp(obj, val) {
            if(val.length == 5) {
                formObj = document.form;
                if (obj.name == "f_del_cd" ){
                	var spcl_cgo_cd = "'AL'";
                	if(formObj.f_cntr_tpsz_cd.Text.substring(0,1)=="D"){
                		spcl_cgo_cd = spcl_cgo_cd + ",'DR'"
                	}
                	if(formObj.f_cntr_tpsz_cd.Text.substring(0,1)=="F"){
                		spcl_cgo_cd = spcl_cgo_cd + ",'FO'"
                	}
                	if(formObj.f_spcl_dg.checked){
                		spcl_cgo_cd = spcl_cgo_cd + ",'DG'"
                	}
                	if(formObj.f_spcl_rf.checked){
                		spcl_cgo_cd = spcl_cgo_cd + ",'RF'"
                	}
                	ComCoaCheckLocCd("DEL_CD",obj,formObj.f_d_term.Code, formObj.f_del_node.value, formObj.f_pod_cd.value, spcl_cgo_cd);
                }else{
                	ComCoaCheckLocCd("LOC_CD",obj);
                }
            }else {
            	// DEL Node가 입력된 경우
            	if (obj.name == "f_del_node" ){
                	ComCoaCheckLocCd("DEL_CD",formObj.f_del_cd,formObj.f_d_term.Code, val);
                }
            }
        }

     	function f_bkg_ofc_cd_OnChange(comObj, value, text ){
     		 var formObj = document.form;
             //ppd ofc를 자동으로 세팅해줌
             ComSetObjValue(formObj.f_ppd_ofc_cd,value);
    	}

    	/*
    	 * Profit변경시
    	 */
    	function f_cob_profit_vw_OnChange(comObj, value){   		
    		var formObj = document.form;    		
    		var profitLvl = document.getElementById("f_cob_profit_lv"); 
    		
    		//Profit Level 콤보 삭제 후 초기화
    		profitLvl.RemoveAll();
    		if(value == "R") {
    			// Profit View 가 Office 일경우에는 XML 데이터로 초기화
    			ComXml2ComboItem(PROF_LVL_XML, formObj.f_cob_profit_lv, "code", "name");
    			document.getElementById("f_mty_pkup_yd_cd").className = "input1";
    			document.getElementById("f_mty_rtn_yd_cd").className = "input1";
    		} else {
    			// Profit View 가 Trade 일경우에는 하드코드 값으로 초기화
    			// ComTextCode2ComboItem()는 COA.js에서 참조
        		ComTextCode2ComboItem(PROF_LVL_CD,PROF_LVL_NM, formObj.f_cob_profit_lv);
    			document.getElementById("f_mty_pkup_yd_cd").className = "input";
    			document.getElementById("f_mty_rtn_yd_cd").className = "input";
    		}
    		profitLvl.Index2 = 0;
    	}

    	/**
    	* sheet1을 더블클릭하여 상세조회한다
    	*/
    	function btng_remarks_OnClick(sheetObj){
        	document.form.f_cmd.value = SEARCHLIST01;
			ComOpenWindow('ESM_COA_0155.do?'
        	+ coaFormQueryString(document.form), '_RMK', 'width=900,height=700,menubar=0,status=1,scrollbars=1,resizable=1');
    	}

    	/**
    	* sheet1을 더블클릭하여 상세조회한다
    	*/
    	function sheet1_OnDblClick(sheetObj, row, col){
    		if (sheetObj.CellValue(row, "remark_img") == "1") {
    			document.getElementById("btns_constraints").style.color = "red";
    		} else {
    			document.getElementById("btns_constraints").style.color = "#737373";
    		}
    	    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	}

        /**
    	* sheet1을 새로 조회하면 sheet2의 데이터를 초기화한다.
    	*/
    	function sheet1_OnSearchEnd(sheetObj, errMessge) {
    		var errMsg;
    		var formObj = document.form;
    		if(formObj.f_mty_rtn_yd_chk.checked) {
    			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
        			sheetObj.CellValue(i, "mty_rtn_yd_cd") = formObj.f_mty_rtn_yd_cd.value + formObj.f_mty_rtn_yd_node.value;
        		}
    		}
    		
    		
    		
    	//sheet2 지우기
    		sheetObjects[1].RemoveAll();

    		errMsg = sheetObj.EtcDataString;

    		// <||>를 줄바꿈으로 변경하고 trim 처리
    		errMsg = errMsg.replace("etcErrMsg=","").replace(/\<\|\|\>/g,"\n").replace(/^\s+|\s+$/g,"");

    		if (errMsg != "" && result_key != 'S' ) {
    		    //ComShowMessage(errMsg);
    		    result_key="";
    		}

    	}

    	/**
    	* sheet1을 더블클릭하여 상세조회한다
    	*/
    	function sheet2_OnDblClick(sheetObj, row, col){

    		if(row==8) { //Total Cost 값을 클릭한 경우
    		    document.form.f_cmd.value = SEARCHLIST01;
    		    ComOpenWindow2('ESM_COA_0155.do?'
    		    + coaFormQueryString(document.form), '_RMK', 'width=800,height=670,menubar=no, status=yes, scrollbars=no, resizable=yes');
    		}
    	}


    	/**
    	트리 접기
    	*/
    	function sheet2_OnSearchEnd(sheetObj, errMessge) {
    	    //1:Freight Rev, 2:DEM/DET, 3:SMU, 4:Misc OP Rev, 5:BKG CM, 6:BKG OP, 7:Total Cost
    	    var total_index = 8;//Total을 구하기 위해 계정이 시작하는 Row
    	    var cm_index = 6;
    	    var op_index = 7;
    	    var dem_det_index = 3//
    	    var total_cost = 0;
    	    var smu_cost = 0;//SMU
    	    var dmdt_rev = 0;//DEM/DET
    	    var f_rev = 0;//Freight Rev
    	    var misc_rev = 0;//Misc OP Rev
    	    var cm_minus_cost = 0;//OP Cost에서 CM계산을 위해 활동원가&장비비 추출

    	    var bkg_op_visible = sheetObj.EtcData("bkg_op_visible");//OP항목 보여줄지 여부
     	    if(bkg_op_visible == "Y") smu_cost = parseFloat(sheetObj.CellValue(4, "amt"));//OP의 경우만 SMU값을 가져온다.
    	    dmdt_rev =  parseFloat(sheetObj.CellValue(dem_det_index, "amt"));
    	    f_rev =  parseFloat(sheetObj.CellValue(2, "amt"));
    	    misc_rev =  parseFloat(sheetObj.CellValue(5, "amt"));

    	    //cost SUM 구하기
    	    var k = 0;
    	    for(k=total_index+1; k <= sheetObj.LastRow; k++) {
    	        if(sheetObj.CellValue(k, "lvl") == 1) {
    	            total_cost = total_cost + parseFloat(sheetObj.CellValue(k, "amt"));
                    if((ComTrim(sheetObj.CellValue(k, "tree_col")) == 'Business Activity Cost') ||( ComTrim(sheetObj.CellValue(k, "tree_col")) == 'EQ Cost')){
                        cm_minus_cost = cm_minus_cost + parseFloat(sheetObj.CellValue(k, "amt"));
                    }
    	        }
    	    }

            //Total Cost Setting
    		sheetObj.CellValue2(total_index, "amt") = total_cost;

        	//BKG CM Setting REV + DEM/DET - SMU를 제외한 Cost
        	//sheetObj.CellValue2(cm_index, "amt") = f_rev + misc_rev + dmdt_rev - (total_cost - smu_cost);
        	sheetObj.CellValue2(cm_index, "amt") = f_rev + misc_rev - (total_cost - smu_cost - cm_minus_cost);//CM에서 DEMDET 및 OP비용 제외

     		//BKG OP
    		if(bkg_op_visible == "Y") {//OP였을 경우 BKG OP = REV + DEM/DET - SMU를 포함한 Cost
    		    sheetObj.CellValue2(op_index, "amt") =  f_rev + misc_rev + dmdt_rev - total_cost;
                sheetObj.CellFont("FontBold", op_index,  "nod_cd") = true;
                sheetObj.CellFont("FontBold", op_index,  "amt") = true;
    		}
    		//Revenue관련 색상 변경

            //글자 Bold 설정
            sheetObj.CellFont("FontBold", total_index, "nod_cd") = true;
            sheetObj.CellFont("FontBold", cm_index, "nod_cd") = true;
            sheetObj.CellFont("FontBold", total_index, "amt") = true;
            sheetObj.CellFont("FontBold", cm_index, "amt") = true;
            
            // NOD, LOC를 제외한 평균단가로 추정된 비용에 대해 파란색 글씨 및 진하게 표시
            var s_row = 1;
            
            while(s_row > 0){
            	s_row = sheetObj.FindText("avg_lvl_chk", "Y", s_row);
            	
            	if(s_row == -1) {
            		break;
            	}
            	
            	sheetObj.CellFont("FontBold", s_row, 0, s_row, "avg_lvl_chk") = true;
            	sheetObj.RowFontColor(s_row) = sheetObj.RgbColor(0,0,255);
            	s_row = s_row + 1;
            }

            //minus CM 빨강색으로
            if(parseFloat(sheetObj.CellValue(cm_index, "amt")) < 0) sheetObj.CellFontColor (cm_index,  "amt") = sheetObj.RgbColor(255, 0, 0);
            //minus OP 빨강색으로
            if(parseFloat(sheetObj.CellValue(op_index, "amt")) < 0) sheetObj.CellFontColor (op_index,  "amt") = sheetObj.RgbColor(255, 0, 0);
            //OP가 아닌 경우 OP Hidden
            if(bkg_op_visible == "N") {
                sheetObj.RowHidden(op_index) = true;
                sheetObj.RowHidden(dem_det_index) = true;
            }
            //SMU Hidden
            sheetObj.RowHidden(4) = true;

    		//TREE 접기
    		sheetObj.ShowTreeLevel(1);
    		sheetObj.SelectCell(8, 0);//Total Cost에 Focus

    	}


    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBCLEAR:          //조회

	    	        sheetObj.WaitImageVisible = false;
	    			ComOpenWait(true);
	    			formObj.f_cmd.value = INIT;
	    			var sXml = sheetObj.GetSearchXml("ESM_COA_0153GS3.do", coaFormQueryString(formObj));
	    			var arrXml = sXml.split("|$$|");
	    			if (arrXml.length > 0)
	    				ComXml2ComboItem(arrXml[0], formObj.f_cob_profit_vw, "code", "name");
	    			if (arrXml.length > 1) {
	    				//전역변수에 세팅
	    				//화면로딩후 초기값은 하드코드값으로 세팅하기 때문에 전역변수에 담고 있다가 Profit View OnChange발생시 전역변수로 다시 세팅한다.
	    				PROF_LVL_XML = arrXml[1];
	    			}
	    			if (arrXml.length > 2)
	    				ComXml2ComboItem(arrXml[2], formObj.f_cntr_tpsz_cd, "code", "name");
	    			if (arrXml.length > 3)
	    				ComXml2ComboItem(arrXml[3], formObj.f_agmt_sgn_ofc_cd, "code", "name");
	    			if (arrXml.length > 3)
	    				ComXml2ComboItem(arrXml[3], formObj.f_sls_ofc_cd, "code", "name");
	    			if (arrXml.length > 3)
	    				ComXml2ComboItem(arrXml[3], formObj.f_bkg_ofc_cd, "code", "name");
	    			if (arrXml.length > 3)
	    				ComXml2ComboItem(arrXml[3], formObj.f_ppd_ofc_cd, "code", "name");
	    			if (arrXml.length > 3)
	    				ComXml2ComboItem(arrXml[3], formObj.f_clt_ofc_cd, "code", "name");
	    			if (arrXml.length > 4)
	    				ComXml2ComboItem(arrXml[4], formObj.f_r_term, "code", "name");
	    			if (arrXml.length > 5)
	    				ComXml2ComboItem(arrXml[5], formObj.f_d_term, "code", "name");
	    			ComOpenWait(false);
	    			break;
    			case IBSEARCH:	 //조회
    				if(validateForm(sheetObj,formObj,sAction)) {
    					if ( sheetObj.id == "sheet1" ) {
    						if (formObj.f_del_cd.value == "USIWS") {
    							ComShowCodeMessage("COA10073");
    						}
    						// 업무처리중 버튼사용 금지 처리
    						sheetObj.WaitImageVisible = false;
    						ComOpenWait(true);
// prd backend job으로     						
    						formObj.f_cmd.value = SEARCHLIST01;
    						
    						var sXml = sheetObj.GetSearchXml("ESM_COA_0153GS.do", coaFormQueryString(formObj));

    						//prd pc생성 backendjob
							var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
							if (backendJobKey != null && backendJobKey.length > 0) {
								ComSetObjValue(formObj.backendjob_key, backendJobKey);
								sheetObj.RequestTimeOut = 600; //초 - 10분
								backEndJobTimer = setInterval(getPrdBackEndJobStatus, 10000);	//밀리초  - 10초
							}	
    						
    						
//    			    		result_key = searchEtcData("TRANS_RESULT_KEY", sXml);
//    			            if(result_key != ""){
//    			                // header
//    			                //-------------------------
//    			            	sheetObj.Redraw = false;
//    			            	sheetObj.RemoveAll();
//    			            	sheetObj.Reset();
//    			                initSheet(sheetObj, 1 );
//    			                sheetObj.Redraw = true;
//    			                // data
//    			                //-------------------------
//    			                sheetObj.LoadSearchXml(sXml);
//    			                //-------------------------
//    			            }
//    			            ComOpenWait(false);
//    						viewCreation();
    					}

    					else if ( sheetObj.id == "sheet2" ) {
    						if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
    							// 업무처리중 버튼사용 금지 처리
    							sheetObj.WaitImageVisible = false;
    							ComOpenWait(true);
    							formObj.f_cmd.value = SEARCHLIST02;
    							var sheetObject = sheetObjects[0];
    							//sheet1의 선택된 행들을 쿼리로
    							var selrow = sheetObject.SelectRow;
/* PRD 될 때까지 */				formObj.f_pctl_no.value = sheetObject.CellValue(selrow, "pctl_no");
// 됐다???						formObj.f_pctl_no.value = 'B0909290000006610001' ;
//    							sheetObj.DoSearch4Post("ESM_COA_0153GS2.do", coaFormQueryString(formObj));
    							
    							
    							var sXml = sheetObj.GetSearchXml("ESM_COA_0153GS2.do", coaFormQueryString(formObj));
    							var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
    							if (backendJobKey != null && backendJobKey.length > 0) {
    								ComSetObjValue(formObj.backendjob_key, backendJobKey);
    								sheetObj.RequestTimeOut = 7200; //초 - 2시간
    								backEndJobTimer = setInterval(getBackEndJobStatus, 10000);	//밀리초  - 10초
    							}				
    							
    							
//    							ComOpenWait(false);
    						} else {
    							ComShowMessage(ComGetMsg('COA10005', 'Sheet1'));
    						}
    					}
    				}

    				break;

    			case IBCOPYROW:		//행 복사
    			 sheetObj.DataCopy();
    			 break;

    			case IBDOWNEXCEL:		//엑셀 다운로드
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false);
    						break;
    				}

    				break;

    			case IBLOADEXCEL:		//엑셀 업로드
        			 sheetObj.LoadExcel();
        			 break;

    		}
    	}

    	 /**
         * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *      getBackEndJobStatus();
         * </pre>
         */     
        function getPrdBackEndJobStatus() {
        	var formObj = document.form;
        	var sheetObj = sheetObjects[0];
        	ComOpenWait(true);
        	formObj.f_cmd.value = SEARCHLIST06;
        	var sXml = sheetObj.GetSearchXml("ESM_COA_0153GS2.do", coaFormQueryString(formObj));
        	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
        	var prd_msg  = ComGetEtcData(sXml, "prd_msg");
        	
        	if (jobState == "3") {
        		getPrdBackEndJobSearch();
        		clearInterval(backEndJobTimer);
        	} else if (jobState == "4") {
        		ComShowMessage(prd_msg);
        		ComOpenWait(false);
        		clearInterval(backEndJobTimer);
        	} else if (jobState == "5") {
        		ComShowCodeMessage("COA00002");
        		ComOpenWait(false);
        		clearInterval(backEndJobTimer);
        	}
        }   
    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		var rt = false;

    		with(formObj){
    		    if(f_g_rev.value == ""){
    			    ComAlertFocus(f_g_rev, ComGetMsg("COM12114", "G.Rev"));
    			} else if (f_por_cd.value == "") {
    			    ComAlertFocus(f_por_cd, ComGetMsg("COM12114", "POR"));
    			} else if(f_pol_cd.value == ""){
    			    ComAlertFocus(f_pol_cd, ComGetMsg("COM12114", "POL"));
    			} else if(f_del_cd.value == ""){
    			    ComAlertFocus(f_del_cd, ComGetMsg("COM12114", "DEL"));
    			} else if ( comboObjects[0].Code =='R' && ComTrim(formObj.f_mty_pkup_yd_cd.value) =='' ) {
    				ComAlertFocus(f_mty_pkup_yd_cd, ComGetMsg("COM12114", "MTY P/Up CY"));
    			} else if ( comboObjects[0].Code =='R' && ComTrim(formObj.f_mty_rtn_yd_cd.value) =='' ) {
    				ComAlertFocus(f_mty_rtn_yd_cd, ComGetMsg("COM12114", "MTY RTN CY"));
    			} else if(ComTrim(ComGetObjValue(formObj.f_cntr_tpsz_cd)) == ""){
    			    ComAlertFocus(f_cntr_tpsz_cd, ComGetMsg("COM12113", "TP/SZ"));
    			} else if(f_qty.value == ""){
    			    ComAlertFocus(f_qty, ComGetMsg("COM12114", "QTY (BOX)"));
    			} else if(ComTrim(ComGetObjValue(formObj.f_agmt_sgn_ofc_cd)) == "" && f_cob_profit_lv.Code == "O"){//f_agmt_sgn_ofc_cd
    			    ComAlertFocus(f_agmt_sgn_ofc_cd, ComGetMsg("COM12114", "Contract OFC"));
    			} else if(ComTrim(ComGetObjValue(formObj.f_sls_ofc_cd))== "" && f_cob_profit_lv.Code == "O"){//f_sls_ofc_cd
    			    ComAlertFocus(f_sls_ofc_cd, ComGetMsg("COM12114", "Loading OFC"));
    			} else if(ComTrim(ComGetObjValue(formObj.f_bkg_ofc_cd))== "" && f_cob_profit_lv.Code == "O"){//f_bkg_ofc_cd
    			    ComAlertFocus(f_bkg_ofc_cd, ComGetMsg("COM12114", "Booking OFC"));
    			} else if(f_void_qty.value == "" && ComGetObjValue(formObj.f_spcl_ak) == 'Y' && (    ComGetObjValue(formObj.f_cntr_tpsz_cd).substr(0,1)=='O'
    				                                                                              || ComGetObjValue(formObj.f_cntr_tpsz_cd).substr(0,1)=='S'
    				                                                                              || ComGetObjValue(formObj.f_cntr_tpsz_cd).substr(0,1)=='F'
    				                                                                              || ComGetObjValue(formObj.f_cntr_tpsz_cd).substr(0,1)=='A')) {
    			    ComAlertFocus(f_void_qty, ComGetMsg("COM12114", "Void (TEU)"));
    			} else if(f_mty_rtn_yd_chk.checked && (f_mty_rtn_yd_cd.value == "" || f_mty_rtn_yd_node.value == "")){
    				ComAlertFocus(f_mty_rtn_yd_cd, ComGetMsg("COM12114", "MTY RTN CY"));
    			}
    			else {
    			    if(f_void_qty.value == ""){
    			      f_void_qty.value = 0;
    			    }
    			    rt = true;
    			}
    			//TP/SZ의 경우는 combo에서 처리함
    		}
    		
    		return rt;
    		//return true;
    	}

        function isValidLocation(obj,rtnValue) {
        	var formObj = document.form;
            if(rtnValue == "false") {
                ComShowMessage(ComGetMsg('COA10040'));
                obj.focus();
                obj.value = "";
                formObj.f_mty_pkup_yd_cd.value = '';
                formObj.f_mty_rtn_yd_cd.value = '';
            } else if (obj.name == "f_del_cd") {
            	//formObj.f_mty_rtn_yd_cd.value = formObj.f_del_cd.value;
            	
            	var arrXml = rtnValue.split("|##|");
            	
            	// Collection Office
            	if(arrXml.length > 0){
	                if (formObj.f_clt_ofc_cd != undefined){
	  					ComSetObjValue(formObj.f_clt_ofc_cd,arrXml[0]);
	                }
                }
            	
            	// MT Return CY
            	if(arrXml.length > 1){
            		// MT Return CY 가 존재하는 경우에는 리턴받은 값을 셋팅해준다.
	                if (formObj.f_mty_rtn_yd_cd != undefined && arrXml[1] != "" ){
	                	ComSetObjValue(formObj.f_mty_rtn_yd_cd,arrXml[1].substring(0, 5));
	                	ComSetObjValue(formObj.f_mty_rtn_yd_node,arrXml[1].substring(5));
	                	
	                // MT Return CY가 없는 경우에는, DEL 정보를 셋팅해준다.
	                }else{
	                	formObj.f_mty_rtn_yd_cd.value = formObj.f_del_cd.value;
	                	
	                	// DEL Node가 입력된 경우에만 셋팅하며, 입력되지 않은 경우에는 공란으로 채운다.
	                	if(formObj.f_del_node.value.length == 2) {
	                		formObj.f_mty_rtn_yd_node.value = formObj.f_del_node.value;
	                	}else{
	                		formObj.f_mty_rtn_yd_node.value = "";
	                	}
	                }
                }
            	
            } else if (obj.name == "f_por_cd") {	//POR 포커스 아웃시 MTY P/Up CY 세팅
            	
            	// Profit View가 Trade로 선택되어있을 때만 MTY P/Up CY필드값이 자동으로 입력되도록 한다
            	if(rtnValue == "true") {            		
            		if(ComGetObjValue(formObj.f_cob_profit_vw) == 'P') { // P : Trade / R : Office
            			formObj.f_mty_pkup_yd_cd.value = formObj.f_por_cd.value;            			
            		}
            	} 
            }
            if (obj.name == "f_por_node") {
            	if(rtnValue.length == 2) {
            		formObj.f_mty_pkup_yd_node.value = formObj.f_por_node.value;
            	}
            }
            if (obj.name == "f_del_node") {
            	if(rtnValue.length == 2) {
            		formObj.f_mty_rtn_yd_node.value = formObj.f_del_node.value;
            	}
            }
            obj.focus();
        }
        
        /**
         * 입력한 값이 숫자가 아닌 경우 이전 값으로 셋팅하기 위해 이전값을 변수에 담는다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     setBfVal(obj)
         * </pre>
         * @param Object Name
         */
        var bfVal = ""
        function setBfVal(obj){
        	bfVal = obj.value;
        }
        
        /**
         * 숫자가 아닐 경우 이전 값을 셋팅한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     chkNumber(obj)
         * </pre>
         * @param Object Name
         */  
        function chkNumber(obj){
	       	var afVal = obj.value;
	       	var flg = false;
	       	if(isNaN(ComGetUnMaskedValue(afVal, "float"))){
	       		obj.value = bfVal;
	       	}
        }
        
        /**
         * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
         * 선택된 Type/Size가 RF일경우 Special Cargo에 RF Check Box Check한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *    f_cntr_tpsz_cd_OnChange(comboObj, code, text);
         * </pre>
         * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
         * @param   {string} code 필수 코드
         * @param   {string} text 필수 화면에 표시된 문자 
         * @return 없음
         * @author 공백진
         * @version 2012.02.09
         */     
         function f_cntr_tpsz_cd_OnChange(comboObj, code, text) {
             var formObj = document.form;
             if (code.substr(0,1)=='R' && code.substr(0,2)!='RD' ){
            	 ComSetObjValue(formObj.f_spcl_rf,true);
             } else {
            	 ComSetObjValue(formObj.f_spcl_rf,false);
             }
             
             // Special Cargo 에 AWK를 선택 했을 시 CNTR Type 이 O,S,F,A 일 경우에 Void 필수
             if(ComGetObjValue(formObj.f_spcl_ak) == 'Y' && (    code.substr(0,1)=='O'
            	                                              || code.substr(0,1)=='S'
            	                                              || code.substr(0,1)=='F'
            	                                              || code.substr(0,1)=='A')) {
            	
            	if(formObj.f_void_qty.className == "input") formObj.f_void_qty.value = "";
             	
             	formObj.f_void_qty.className = "input1";
             } else {
            	 formObj.f_void_qty.className = "input";
             }
         }
        
        /**
         * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *      getBackEndJobStatus();
         * </pre>
         * @return 없음
         * @author 김종준
         * @version 2012.02.20
         */     
        function getBackEndJobStatus() {
        	var formObj = document.form;
        	var sheetObj = sheetObjects[0];
        	ComOpenWait(true);
        	formObj.f_cmd.value = SEARCHLIST03;
        	var sXml = sheetObj.GetSearchXml("ESM_COA_0153GS2.do", coaFormQueryString(formObj));
        	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
        	if (jobState == "3") {
        		getBackEndJobSearch();
        		clearInterval(backEndJobTimer);
        	} else if (jobState == "4") {
        		ComShowCodeMessage("COA00001");
        		ComOpenWait(false);
        		clearInterval(backEndJobTimer);
        	} else if (jobState == "5") {
        		ComShowCodeMessage("COA00002");
        		ComOpenWait(false);
        		clearInterval(backEndJobTimer);
        	}
        }          
        
        /**
         * BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *      getBackEndJobSearch();
         * </pre>
         * @return 없음
         * @author 김종준
         * @version 2012.02.20
         */       
        function getBackEndJobSearch() {
        	var formObj = document.form;
        	var sheetObj = sheetObjects[1];
        	formObj.f_cmd.value = SEARCHLIST04;    	
        	var sXml = sheetObj.GetSearchXml("ESM_COA_0153GS2.do", coaFormQueryString(formObj));
        	var err_cd = ComGetEtcData(sXml, "err_cd");
        	var err_msg = ComGetEtcData(sXml, "err_msg");    	
    		
    		ComOpenWait(false);
    		
    		if (err_cd == "00000") {
    			formObj.f_cmd.value = SEARCHLIST05;    	
    			sheetObj.DoSearch4Post("ESM_COA_0153GS2.do", coaFormQueryString(formObj));
    		} else if (err_cd == "00028") {
    			ComShowMessage("ERROR(COA00153): " + err_msg);
    		} else{
    			ComShowMessage("ERROR(COA00153): " + err_msg);
    		}		
    	}
        
        /**
         * PRD Route BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *      getBackEndJobStatus();
         * </pre>
         */ 
        function getPrdBackEndJobSearch() {
        	var formObj = document.form;
        	var sheetObj = sheetObjects[0];
        	formObj.f_cmd.value = SEARCHLIST07;    	
        	var sXml = sheetObj.GetSearchXml("ESM_COA_0153GS2.do", coaFormQueryString(formObj));
    		ComOpenWait(false);
    		
    		result_key = searchEtcData("TRANS_RESULT_KEY", sXml);
            if(result_key != ""){
                // header
                //-------------------------
            	sheetObj.Redraw = false;
            	sheetObj.RemoveAll();
            	sheetObj.Reset();
                initSheet(sheetObj, 1 );
                sheetObj.Redraw = true;
                // data
                //-------------------------
                sheetObj.LoadSearchXml(sXml);
                //-------------------------
            }
            ComOpenWait(false);
			//viewCreation();    		
		
    	}
        
        /**
    	* Check Box Item 이 변경되었을 때 발생하는 이벤트.
    	*/
        function checkbox_OnChange(obj) {
        	var formObj = document.form;
        	
            // 현재는 AWK 에만 걸려있는 function 이라서 구분없음
            // Special Cargo 에 AWK를 선택 했을 시 CNTR Type 이 O,S,F,A 일 경우에 Void 필수
            if(ComGetObjValue(obj) == 'Y' && (    ComGetObjValue(formObj.f_cntr_tpsz_cd).substr(0,1)=='O'
            	                               || ComGetObjValue(formObj.f_cntr_tpsz_cd).substr(0,1)=='S'
            	                               || ComGetObjValue(formObj.f_cntr_tpsz_cd).substr(0,1)=='F'
            	                               || ComGetObjValue(formObj.f_cntr_tpsz_cd).substr(0,1)=='A')) {
            	
            	// 변경되기 전에 필수상태가 아니면 값 제거
            	if(formObj.f_void_qty.className == "input") formObj.f_void_qty.value = "";
            	
            	formObj.f_void_qty.className = "input1";
            } else {
            	formObj.f_void_qty.className = "input";
            }
        }
        
        function f_d_term_OnChange(comObj, value, text ){
        	var formObj = document.form;
        	
        	if(formObj.f_del_cd.value != "")
        		ComCoaCheckLocCd("DEL_CD",formObj.f_del_cd, value, formObj.f_del_node.value);
        }
        
        /**
    	 * constraint 팝업 호출
    	 * 
    	 * @param formObj
    	 * @return
    	 */
    	function fnPopConstraintDetail(pctlNo){
    		var newForm  = "<form name='form_prd_pop' method='post'>" ;
    	   	newForm += "  <input type='hidden' name='pctl_no'       value='" + pctlNo + "'>" ;	
    	   	newForm += "  <input type='hidden' name='pgmNo' value='ESD_PRD_0082'>" ;	
    	   	newForm += "</form>";
    	   	var prdFormObj = document.getElementById("prd_form");
    	   	prdFormObj.innerHTML = newForm;
    	   	var formObj = document.all.form_prd_pop ;
    	   	var paramUrl = "pgmNo=ESD_PRD_0082&pctl_no="+pctlNo;
    	    var newWin = window.showModalDialog("ESD_PRD_0082.do?"+paramUrl, "detail", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:450px");
    	}
        
        /**
         * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     initControl()
         * </pre>
         * @param 없음
         * @return 없음
         * @version 2014.08.11
         */ 	    
         function initControl() {        
             axon_event.addListenerForm ('click', 'obj_onClick', document.form);
         }
         

       /**
        * onClick event를 처리한다. <br>
        * <br><b>Example :</b>
        * <pre>
        *
        * </pre>
        * @param 없음
        * @return 없음
        * @version 2014.08.11
        */  
        function obj_onClick(){
        	var formObj = document.form;
        	var eleName = event.srcElement.name;
    	 	if (eleName == "f_mty_rtn_yd_chk"){
    	 	
    	 		if(formObj.f_mty_rtn_yd_chk.checked) {
    	 			formObj.f_mty_rtn_yd_cd.readOnly = false;
    	 			formObj.f_mty_rtn_yd_cd.className ="input";
    	 			formObj.f_mty_rtn_yd_node.readOnly = false;
    	 			formObj.f_mty_rtn_yd_node.className ="input";    	 			
    	 		} else {
    	 			formObj.f_mty_rtn_yd_cd.readOnly = true;
    	 			formObj.f_mty_rtn_yd_cd.className ="input2";
    	 			formObj.f_mty_rtn_yd_node.readOnly = true;
    	 			formObj.f_mty_rtn_yd_node.className ="input2";    	 
    	 		}    	 		
    		}
        }

          
     	
	/* 개발자 작업  끝 */