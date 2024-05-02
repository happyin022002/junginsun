/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0054.js
*@FileTitle : Commodity Note Conversion - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================
* History
* 2012.01.12 서미진 [CHM-201215426] Special Note , Rate 의 Commodity 별, Route 별 Note conversion 항목에 By Charge 컬럼 추가
* 2013.07.01 전윤주 [CHM-201325096] S/C Conversion 신규 Rule Code 생성 요청 - FAR, FAD Rule code 신규 생성
* 2013.11.07 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
* 2014.08.08 송호진 [CHM-201431411] Split 01-S/C Note conversion상에 컬럼 추가 - Rate indicator 앞 Pattern type 컬럼 추가 및 autorating 로직 추가
* 2014.12.22 송호진 [CHM-201433111] Split 01-오토레이팅 개발 - TYP Rule code 중 Surcharge에 대한 Ignore Tariff 로직 개발
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
     * @class ESM_PRI_0054 : ESM_PRI_0054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0054() {
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

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;
	
	//콤보에서의  VISIALE 항목 리스트
	var sChgCdVisiable = "";
	
	//화면로딩시 OPEN CHECK
	var openSheet1YN = false;
	var openSheet2YN = false;
	var openSheet3YN = false;
	//처음 SHEET 조회 CHECK
	var runSheet1YN  = false;
	var runSheet2YN  = false;   

	var isFiredNested = false;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2009.10.28
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
			switch (srcName) {
				case "btn_retrieve":
					if(validateForm(sheetObject3,formObject,IBSEARCH_ASYNC01)) {
						doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC01);
					}
					break;
		
				case "btn_close":
					window.close();
					break;
					
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
	* @author 최성민
	* @version 2009.10.28
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
  /**
	* IBCombo Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj 필수 IBCombo Object
	* @return 없음
	* @author 최성민
	* @version 2009.10.28
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 최성민
    * @version 2009.05.17
    */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }

	    ComPriTextCode2ComboItem(multRuleApplChgTpCdComboValue, multRuleApplChgTpCdComboText, getComboObject(comboObjects, 'note_chg_tp_cd') ,"|","\t" );
	    
 	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}


    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 최성민
     * @version 2009.05.22
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
         	 case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 102;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     
                     var HeadTitle = "Seq.|Commodity Group|Actual Customer";
                     HeadTitle +=  "|1|2|3|4|5";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtDataSeq, 	60,   	daCenter, 	false,  "seq");
					 InitDataProperty(0, cnt++ , dtData,      	680,	daLeft,		false,	"prc_cmdt_def_nm",	false,	"",		dfNone,		  0,	false,		false);
 					 InitDataProperty(0, cnt++ , dtData,      	100,	daLeft,		false,	"cust_lgl_eng_nm",	false,	"",		dfNone,		  0,	false,		false);

 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "cmdt_hdr_seq");
					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "gen_spcl_rt_tp_cd");
					 InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                 
 					 CountPosition = 0;		// Total 숨김

 					 //전체편집불가능인데~ 쓸데 없는 회색 처리하기 
 					 //DataBackColor = UnEditableColor;
                     WaitImageVisible = false;
                 }
                 break;

         	case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 82;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

					// 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 1, 80);

                    var HeadTitle = "Seq.|Item|Surcharge|Content";
                    HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtDataSeq,  	60,   	daCenter, 	false,  "seq");
					 InitDataProperty(0, cnt++ , dtCombo, 		150,	daCenter,	false,	"note_clss_cd",  	false,	"",      dfNone, 		0,     false,       false);
					 InitDataProperty(0, cnt++ , dtData, 		150,	daCenter,	false,	"chg_cd",      		false,	"",      dfNone, 		0,     false,       false);
					 InitDataProperty(0, cnt++ , dtData, 		200,	daLeft,		false,	"note_ctnt",      	false,	"",      dfNone, 		0,     false,       false);
                    
					 InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "gen_spcl_rt_tp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "cmdt_hdr_seq");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "cmdt_note_seq");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_conv_mapg_id");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_chg_tp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "eff_dt");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "exp_dt");
	                 
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "src_info_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prc_prog_sts_cd");

	                 InitDataCombo(0, "note_clss_cd", noteClssSdComboText, noteClssSdComboValue);
 					                					 
					 CountPosition = 0;		// Total 숨김

					 //전체편집불가능인데~ 쓸데 없는 회색 처리하기 
					 //DataBackColor = UnEditableColor; 
	                 WaitImageVisible = false;					
				}
                break;
                
                
         	case "sheet3":
         		with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);

                    var HeadTitle1 = "|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
		             		"|POR|POL|POD|DEL|Commodity|Commodity\nGroup|Org.\nTrans. Mode|Dest.\nTrans. Mode" +
		             		"|Receiving\nTerm|Delivery\nTerm|Lane|Direct\ncall|T/S Port|In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|S/I|BL Type" +
		             		"|Pay Term|Type|By Charge|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition" +
		             		"|S/C Condition|S/C Condition|Updated Date|Updated Staff" +
                    		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26";
                    var HeadTitle2 = "|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
		             		"|POR|POL|POD|DEL|Commodity|Commodity\nGroup|Org.\nTrans. Mode|Dest.\nTrans. Mode" +
		             		"|Receiving\nTerm|Delivery\nTerm|Lane|Direct\ncall|T/S Port|In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|S/I|BL Type" +
		             		"|Pay Term|Type|By Charge|Ignore\nTariff|Rate\nPattern|Rate\nIndicator|Per|Cargo\nType|Commodity|Origin|Origin Via|Dest. Via|Dest.|Receiving\nTerm|Delivery\nTerm|Updated Date|Updated Staff" +
                    		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		30,   daCenter,  true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,     		40,   daCenter,  true,	"chk");
                    InitDataProperty(0, cnt++ , dtData,	   			50,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				100,  daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				100,  daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,    		80,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,  	    	45,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        		40,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,         	80,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   		3,     false,       false,	10);
                    InitDataProperty(0, cnt++ , dtData,   			40,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtData,  			40,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   	    	40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     false,       false, 	3);
                    InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                    InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     false,       false,	5);
                    InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     false,       false,	5);
                    InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                    InitDataProperty(0, cnt++ , dtData,    			80,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     false,       false,	6);
                    InitDataProperty(0, cnt++ , dtCombo,    		80,   daCenter,  true,	"bkg_scg_grp_cmdt_cd", 		false,	"",	dfNone,				0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,   			80,   daCenter,  true,	"bkg_org_trsp_mod_cd",		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,  	    	80,   daCenter,  true,	"bkg_dest_trsp_mod_cd",		false,	"",	dfNone, 			0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtCombo,        	70,   daCenter,  true,	"bkg_rcv_term_cd", 			false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,        	70,   daCenter,  true,	"bkg_de_term_cd",			false,	"",	dfNone,				0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,  			50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     false,       false,	3);
                    InitDataProperty(0, cnt++ , dtCombo,			50,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				70,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     false,       false,	5);

                    InitDataProperty(0, cnt++ , dtCombo,			70,   daCenter,  true,	"bkg_io_ga_cd",				false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,			60,   daCenter,  true,	"bkg_cnl_tz_cd", 			false,	"",	dfNone, 			0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtData,				100,  daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     false,       false,	9);
                    InitDataProperty(0, cnt++ , dtData,  	 		80,   daCenter,  true,	"bkg_act_cust_def_cd",		false,	"",	dfNone, 			0,     false,       false,	8);
                    InitDataProperty(0, cnt++ , dtCombo,			50,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,      		90,   daCenter,  true,	"bkg_usa_svc_mod_cd",  		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,      		60,   daCenter,  true,	"bkg_esvc_tp_cd",  			false,	"",	dfNone, 			0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,   	 		70,   daCenter,  true,	"bkg_mst_hbl_tp_cd",     	false,	"",	dfNone, 			0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtCombo,      		80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,        	70,   daCenter,  true,	"rule_appl_chg_tp_cd", 		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    	  		70,   daCenter,  true,	"rule_appl_chg_cd", 		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,			50,   daCenter,  true,	"ign_trf_flg",				false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,        	100,  daLeft,    true,	"rt_patt_tp_cd", 			false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,			80,   daCenter,  true,	"gen_spcl_rt_tp_cd",		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,   	 		40,   daCenter,  true,	"conv_rat_ut_cd",   		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,  			40,   daCenter,  true,	"conv_prc_cgo_tp_cd",		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				80,   daCenter,  true,	"conv_cmdt_def_cd",			false,	"",	dfNone, 			0,     false,       false,	6);
                    InitDataProperty(0, cnt++ , dtData,     		70,   daCenter,  true,	"conv_org_loc_def_cd",  	false,	"",	dfNone, 			0,     false,       false,	5);
                    InitDataProperty(0, cnt++ , dtData,				70,   daCenter,  true,	"conv_org_via_loc_def_cd",	false,	"",	dfNone, 			0,     false,       false,	5);
                    InitDataProperty(0, cnt++ , dtData,				70,   daCenter,  true,	"conv_dest_via_loc_def_cd",	false,	"",	dfNone,				0,     false,       false,	5);
                    InitDataProperty(0, cnt++ , dtData,				70,   daCenter,  true,	"conv_dest_loc_def_cd", 	false,	"",	dfNone,				0,     false,       false,	5);
                    
                    InitDataProperty(0, cnt++ , dtCombo,   			70,   daCenter,  true,	"conv_prc_rcv_term_cd",		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,			70,   daCenter,  true,	"conv_prc_de_term_cd",		false,	"",	dfNone, 			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				90,   daCenter,  true,	"upd_dt",					false,	"",	dfDateYmd,			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,				90,   daCenter,  true,	"usr_nm",					false,	"",	dfNone,				0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"svc_scp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"prop_no");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"chg_rule_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_chg_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_rule_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_hdr_seq");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_tp_cd");    
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_cmdt_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_tp_cd");
                    
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_vsl_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_voy_no");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_skd_dir_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_act_cust_seq");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_act_cust_cnt_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_ts_port_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_cmdt_tp_cd");
                    
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_org_loc_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_org_via_loc_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_dest_via_loc_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_dest_loc_tp_cd");
                                         
                    InitDataCombo(0, "bkg_soc_flg", 	" |Yes|No", " |Y|N");										
                    InitDataCombo(0, "bkg_dir_call_flg", " |Yes|No", " |Y|N");
                    InitDataCombo(0, "ign_trf_flg", 	" |Yes|No", " |Y|N");										

                    InitDataCombo(0, "rule_appl_chg_tp_cd", ruleApplChgTpCdComboText, ruleApplChgTpCdComboValue);
                    InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);        
                    InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);
                    InitDataCombo(0, "bkg_usa_svc_mod_cd", bkgUsaSvcModCdComboText, bkgUsaSvcModCdComboValue);
                    InitDataCombo(0, "bkg_rcv_term_cd", bkgRcvTermCdComboText, bkgRcvTermCdComboValue);
                    InitDataCombo(0, "bkg_de_term_cd", bkgDeTermCdComboText, bkgDeTermCdComboValue);
                    InitDataCombo(0, "bkg_scg_grp_cmdt_cd", bkgScgGrpCmdtCdComboText, bkgScgGrpCmdtCdComboValue);
                    
                    InitDataCombo(0, "bkg_org_trsp_mod_cd", bkgOrgTrspModCdComboText, bkgOrgTrspModCdComboValue);
                    InitDataCombo(0, "bkg_dest_trsp_mod_cd", bkgDestTrspModCdComboText, bkgDestTrspModCdComboValue);
                    InitDataCombo(0, "bkg_mst_hbl_tp_cd", bkgMstHblTpCdText, bkgMstHblTpCdValue);
                    //InitDataCombo(0, "gen_spcl_rt_tp_cd", genSpclRtTpCdComboText, genSpclRtTpCdComboValue);
                    InitDataCombo(0, "conv_prc_rcv_term_cd", convPrcRcvTermCdComboText, convPrcRcvTermCdComboValue);
                    InitDataCombo(0, "conv_prc_de_term_cd", convPrcDeTermCdComboText, convPrcDeTermCdComboValue);

                    InitDataCombo(0, "bkg_io_ga_cd", bkgIoGaCdComboText, bkgIoGaCdComboValue);  
                    InitDataCombo(0, "bkg_cnl_tz_cd", bkgCnlTzCdComboText,bkgCnlTzCdComboValue);
                    InitDataCombo(0, "bkg_esvc_tp_cd", bkgEsvcTpCdComboText,bkgEsvcTpCdComboValue);
                    InitDataCombo(0, "rt_patt_tp_cd", rtPattTpCdComboText,rtPattTpCdComboValue);
    		 
			 		 ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 		 CountPosition = 0;		// Total 숨김
			 		 ImageList(0) = "img/btns_calendar.gif";
			 		 PopupButtonImage(0, "eff_dt") = 0;
			 		 PopupButtonImage(0, "exp_dt") = 0;
	                 WaitImageVisible = false;

        		}
             	break;

     	}
	}

   /**
    * IBCOMBO를 초기화하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj 필수 IBMultiCombo Object
    * @param {int} comboNo 필수 IBMultiCombo의 순번
    * @return 없음
    * @author 최성민
    * @version 2009.07.15
    */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "note_chg_tp_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	Enable = false;
	            }
	            break;
	    }
	}
     
   /**
    * Special Note 의 MASTER SHEET를 클릭할때 호출되는 function <br>
    * MASTER SHEET의 ROW별로 DETAIL을 조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetM 필수 IBSheet Object
    * @param {ibsheet} sheetD 필수 IBSheet Object
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.07.15
    */ 
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		
		if (!openSheet2YN || OldRow != NewRow) {  
			formObj.cmdt_hdr_seq.value = sheetM.CellValue(NewRow, "cmdt_hdr_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
		}
	}

   /**
    * Special Note 의 DETAIL SHEET를 클릭할때 호출되는 function <br>
    * DETAIL SHEET의 ROW별로 CONVERSION을 조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetM 필수 IBSheet Object
    * @param {ibsheet} sheetD 필수 IBSheet Object
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.07.15
    */ 
	function doRowChangeConversion(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;

		if (!isFiredNested && (!openSheet3YN || OldRow != NewRow)) {    

			if(sheetM.CellValue(NewRow, "note_clss_cd") =="D" || sheetM.CellValue(NewRow, "note_clss_cd") =="C") {
				ComShowCodeMessage("PRI00313");
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				return -1;
			} else {			
				formObj.cmdt_hdr_seq.value = sheetM.CellValue(NewRow, "cmdt_hdr_seq");
				formObj.cmdt_note_seq.value = sheetM.CellValue(NewRow, "cmdt_note_seq");
				formObj.note_conv_mapg_id.value = sheetM.CellValue(NewRow, "note_conv_mapg_id");
				doActionIBSheet(sheetD,document.form,IBSEARCH_ASYNC01);
			}
		}
	}

	/**
    * OnSelectCell 이벤트 발생시 호출되는 function <br>
    * 다른 ROW를 선택할때 재조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.07.15
    */ 
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if(openSheet1YN) {
			runSheet1YN = true;
			doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
		}
	}
	
   /**
    * OnSelectCell 이벤트 발생시 호출되는 function <br>
    * 다른 ROW를 선택할때 재조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.07.15
    */ 
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj = document.form;
		if(openSheet2YN) {	
			runSheet2YN = true;
			formObj.note_ctnt.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_ctnt");
			doRowChangeConversion(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
		}
	}

    /**
    * Sheet관련 프로세스 처리 <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {form} formObj 필수 html form object
    * @param {int} sAction 필수 프로세스 플래그 상수
    * @return 없음
    * @author 최성민
    * @version 2009.05.22
    */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {
				case IBSEARCH: // 조회
	  				ComOpenWait(true);
					var sArr = dialogArguments.getSheetXml(0);
					var sXml = sArr[0];
					
					sheetObj.LoadSearchXml(sXml);
					break;
					
				case IBSEARCHAPPEND: // 조회
	  				ComOpenWait(true);
					if(openSheet2YN) {
						//처리 중 대기 이미지를 표시하지 않도록 설정한다.
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_0054GS.do" , FormQueryString(formObj));
					} else {
						var sArr = dialogArguments.getSheetXml(0);
						var sXml = sArr[1];
						sheetObj.LoadSearchXml(sXml);
					}				
					break;
						
	 			case IBSEARCH_ASYNC01: // 조회
	  				ComOpenWait(true);
		 			formObj.f_cmd.value = SEARCH03;
					var sXml = sheetObj.GetSearchXml("ESM_PRI_0054GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
					break;
				}
 		}catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e);
 			}
 		}finally {
 			 ComOpenWait(false);
 		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 최성민
     * @version 2009.04.17
     */
		function validateForm(sheetObj, formObj, sAction) {
			
			switch (sAction) {
			
			case IBSEARCH:
								
				break;
			
			
				
			}
	
			return true;
		}

	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj = document.form;
		if (errMsg == "") {
			openSheet1YN = true; 
			if(!runSheet1YN) {
				sheetObj.SelectCell(formObj.master_seq.value, 1);
			}
		}	
	}
		
		/**
		 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
		 * <br><b>Example :</b>
		 * <pre>
		 * 
		 * </pre>
		 * @param {ibsheet} sheetObj 필수 IBSheet Object
		 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
		 * @return 없음
		 * @author 최성민
		 * @version 2009.05.20
		 */ 
		function sheet2_OnSearchEnd(sheetObj, errMsg){
			var formObj = document.form;
			
			if (errMsg == "") {
				
				openSheet2YN = true;
				if(!runSheet2YN) {
			  		sheetObj.SelectCell(formObj.detail_seq.value, 1);
				}
				
			}
		} 	 
		
		/**
		 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
		 * <br><b>Example :</b>
		 * <pre>
		 * 
		 * </pre>
		 * @param {ibsheet} sheetObj 필수 IBSheet Object
		 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
		 * @return 없음
		 * @author 최성민
		 * @version 2009.05.20
		 */ 
		function sheet3_OnSearchEnd(sheetObj, errMsg){
			if(errMsg == "") {
	 		
	 		// C/TYPE SET
			comboObjects[0].Code2 = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_chg_tp_cd");
			
			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		 		//Route 에서 State 코드일 경우 색상처리
		 		setStateColor(sheetObj, i);
				
		 		//Rule Code 일 경우에는 색상을 지정
		 		//setChargeRuleColor(sheetObj, i);
			}
	 		
	 		//처음 화면 오픈할때 조회하기 위한 flag
	 		openSheet3YN = true;
			}
		}
	
	  	/**
	  	 * Route 에 State 코드일 경우에는 색상을 지정하는 function <br>
	  	 * <br><b>Example :</b>
	  	 * <pre>
	  	 * setStateColor(sheetObj, Row);
	  	 * </pre>
	  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @param {int} Row 필수 IBSheet Object 의 Row Index
	  	 * @return 없음
	  	 * @author 최성민
	  	 * @version 2009.07.09
	  	 */ 
	 	function setStateColor(sheetObj, Row) {
	 		// State 색 구분
	 		var pinkColor = sheetObj.RgbColor(255,192,203);
	 		
			if(sheetObj.CellValue(Row, "bkg_por_tp_cd") == "T") {
	 			sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
	 		}
			if(sheetObj.CellValue(Row, "bkg_pol_tp_cd") == "T") {
	 			sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
	 		}
			if(sheetObj.CellValue(Row, "bkg_pod_tp_cd") == "T") {
	 			sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
	 		}
			if(sheetObj.CellValue(Row, "bkg_del_tp_cd") == "T") {
	 			sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
	 		}
			
			if(sheetObj.CellValue(Row, "conv_org_loc_tp_cd") == "T") {
	 			sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = pinkColor;
	 		}
			if(sheetObj.CellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
	 			sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = pinkColor;
	 		}
			if(sheetObj.CellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
	 			sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = pinkColor;
	 		}
			if(sheetObj.CellValue(Row, "conv_dest_loc_tp_cd") == "T") {
	 			sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = pinkColor;
	 		} 		
	 	
	 	}
	 	
	  	/**
	  	 * Code 가 Rule Code 일 경우에는 색상을 지정하는 function <br>
	  	 * <br><b>Example :</b>
	  	 * <pre>
	  	 * setChargeRuleColor(sheetObj, Row);
	  	 * </pre>
	  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @param {int} Row 필수 IBSheet Object 의 Row Index
	  	 * @return 없음
	  	 * @author 최성민
	  	 * @version 2009.07.09
	  	 */ 
	 	function setChargeRuleColor(sheetObj, Row) {
	 		// Rule & Charge Code 색 구분
	 		var sCodeColor = sheetObj.RgbColor(255,200,200);
	 		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
		 		
	 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
	 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
	 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
	 			&& chgRuleDefCd != "RAC" && chgRuleDefCd != "FAR" && chgRuleDefCd != "FAD") {//[CHM-201325096]FAR, FAD 추가
	 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
	 		} else {
	 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = sCodeColor;
	 		} 
	 	}

   
	/* 개발자 작업  끝 */