/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0032.js
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2012.01.09 서미진 [CHM-201215426] Special Note , Rate 의 Commodity 별, Route 별 Note conversion 항목에 By Charge 컬럼 추가
* 2013.02.28 전윤주 [SRM-201333576] SC Converson용 group location 에 IPBC 추가
* 2013.06.27 송호진 [CHM-201325462] 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
* 2013.07.01 전윤주 [CHM-201325096] S/C Conversion 신규 Rule Code 생성 요청 - FAR, FAD Rule code 신규 생성
* 2013.11.07 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
* 2014.03.31 전윤주 [CHM-201429636] S/C Note conversion 입력시 Pay 조건에 중복체크 요청
* 2014.08.08 송호진 [CHM-201431411] Split 01-S/C Note conversion상에 컬럼 추가 - Rate indicator 앞 Pattern type 컬럼 추가 및 autorating 로직 추가
* 2014.12.22 송호진 [CHM-201433111] Split 01-오토레이팅 개발 - TYP Rule code 중 Surcharge에 대한 Ignore Tariff 로직 개발
* 2015.02.26 송호진 [CHM-201533937] 4026 ( Location ), 4012 ( Svc Lane ), 4013 ( VVD ) Popup 호출시 FormQueryString 함수로 Note Content 가 함께 전송되어 
*                                2000 Digit 이상의 길이를 가지는 Note 의 경우 URL Length Limit 를 초과하는 상황이 발생하여 이를 수정함.  
* 2015.04.02 송호진 [CHM-201535140] S/C Note conversion에 중복 체크 로직 수정요청 - validateDupCheck 상의 로직 오류 수정 
* 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
     * @class ESM_PRI_0032 : ESM_PRI_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0032() {
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
	var byChgCdVisiable = "";
	
	/* 화면로딩시 OPEN CHECK :
	 * -. 부모창에서 선택한 ROW의 CONVERSION 데이터를 조회해야 하므로 처음 로딩시에는 SelectCell() 기능을 차단하여
	 * -. 불필요한 조회를 막는다. 
	 * -. SelectCell()이 OnSearchEnd()보다 먼저 호출되기 때문임.
	 */
	var openSheet1YN = false;
	var openSheet2YN = false;
	var openSheet3YN = false;
	/* 화면로딩시 SHEET CHECK :
	 * -. 처음 화면로딩시 SelectCell()기능을 리턴시키므로  OnSearchEnd()에서 호출할 필요가 있다.
	 * -. 부모창에서 선택한 ROW의 CONVERSION 데이터를 조회해야 하므로 처음 로딩시에는 SelectCell() 기능을 차단하여
	 * -. 불필요한 조회를 막는다. 
	 */ 
	var runSheet1YN  = false;
	var runSheet2YN  = false;   
	
	var isFiredNested = false;
	
	//저장후 MAIN화면에 RETURN 할 데이터를 배열로 담는다. CONTENTS별 CONVERSION을 저장하기때문에
	var array = new Array();
	//배열의 크기를 세팅한다.
	var arrayCnt = 0;
	
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
				case "btn_copy":
					if(validateForm(sheetObject3,formObject,COMMAND01)) {
						doActionIBSheet(sheetObject3,formObject,COMMAND01);
					}
					break;
					
				case "btn_paste":
					if(validateForm(sheetObject3,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject3,formObject,COMMAND02);
					}
					break;
					
				case "btn_rowadd":
					if(validateForm(sheetObject3,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject3,formObject,IBINSERT);
					}
					break;
					
				case "btn_rowcopy":
					if(validateForm(sheetObject3,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject3,formObject,IBCOPYROW);
					}
					break;
					
				case "btn_delete":
					if(validateForm(sheetObject3,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject3,formObject,IBDELETE);
					}
					break;
				
				case "btn_retrieve":
					if(validateForm(sheetObject3,formObject,IBSEARCH_ASYNC01)) {
						doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC01);
					}
					break;
		
				case "btn_save":
					if(validateForm(sheetObject3,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject3,formObject,IBSAVE);
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
	    
	    //C/TYPE CODE
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
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     
                     var HeadTitle = "Seq.|Item|Title|1|2|3|4|5|6|7|8|9";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtDataSeq, 	40,   	daCenter, 	false,  "seq");
 					 InitDataProperty(0, cnt++ , dtCombo,      	100,	daLeft,		false,	"note_clss_cd",	false,	"",		dfNone,		  0,	false,		false);
  					 InitDataProperty(0, cnt++ , dtData,      	100,	daLeft,		false,	"note_tit_nm",	false,	"",		dfNone,		  0,	false,		false);

  					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					 InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                 InitDataProperty(0, cnt++ , dtHidden,	 	40, 	daCenter,  	false,  "src_info_cd");    
	                 InitDataProperty(0, cnt++ , dtHidden,  	40, 	daCenter,  	false,  "prc_prog_sts_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,  	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");
	                 InitDataProperty(0, cnt++ , dtHidden,  	40, 	daCenter,  	false,  "dp_fix_flg");
	                 
	                 InitDataCombo(0, "note_clss_cd", noteClssSdComboText, noteClssSdComboValue);
	                
  					 CountPosition = 0;	// Total 숨김  
                     WaitImageVisible = false;					 
         		}
            	break;


         	case "sheet2":
            	 with (sheetObj) {
                     // 높이 설정
                     style.height = 102;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

 					 // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 1, 100);
                     
                     var HeadTitle = "|Seq.|Surcharge|Content|1|2|3|4|5|6|7|8|9|10|11|12|13|14";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,30,    	daCenter,	false,	"ibflag");
 					 InitDataProperty(0, cnt++ , dtDataSeq,  	60,   	daCenter,	false,  "seq");
 					 InitDataProperty(0, cnt++ , dtData,      	100,	daCenter,	false,	"chg_cd",			false,	"",		dfNone,		0,	false,		false);
 					 InitDataProperty(0, cnt++ , dtData,      	100,	daLeft,		false,	"note_ctnt",		false,	"",		dfNone,		0,	false,		false);
 					 
 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_ctnt_seq");
 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
 					 InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_conv_mapg_id");
 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_chg_tp_cd");
 					 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_hdr_seq");
 					 InitDataProperty(0, cnt++ , dtHidden,  	40, 	daCenter,  	false,  "src_info_cd"); 
 					 
 					 InitDataProperty(0, cnt++ , dtHidden,  	40, 	daCenter,  	false,  "prc_prog_sts_cd");
 					 InitDataProperty(0, cnt++ , dtHidden,     	40,    	daCenter, 	false,	"eff_dt");
 					 InitDataProperty(0, cnt++ , dtHidden,     	40,    	daCenter, 	false, 	"exp_dt");
 	                 InitDataProperty(0, cnt++ , dtHidden,  	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");
	                
 					 CountPosition = 0;	// Total 숨김
 					 ColHidden("chg_cd") = true;
 					 AutoRowHeight = false;
                     WaitImageVisible = false;
            	 }
                 break;

         	case "sheet3":
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 240;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     var HeadTitle1 = "|Sel.|T|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
                     		"|POR|POL|POD|DEL|Commodity|Commodity\nGroup|Org.\nTrans. Mode|Dest.\nTrans. Mode" +
                     		"|Receiving\nTerm|Delivery\nTerm|Lane|Direct\ncall|T/S Port|In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|S/I|BL Type" +
                     		"|Pay Term|Type|By Charge|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition" +
                     		"|S/C Condition|S/C Condition|Updated Date|Updated Staff" +
                     		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33";
                     var HeadTitle2 = "|Sel.|T|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
                     		"|POR|POL|POD|DEL|Commodity|Commodity\nGroup|Org.\nTrans. Mode|Dest.\nTrans. Mode" +
                     		"|Receiving\nTerm|Delivery\nTerm|Lane|Direct\ncall|T/S Port|In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|S/I|BL Type" +
                     		"|Pay Term|Type|By Charge|Ignore\nTariff|Rate\nPattern|Rate\nIndicator|Per|Cargo\nType|Commodity|Origin|Origin Via|Dest. Via|Dest.|Receiving\nTerm|Delivery\nTerm|Updated Date|Updated Staff" +
                     		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter,  true,	"ibflag");
                     
                     InitDataProperty(0, cnt++ , dtDummyCheck,     	40,   daCenter,  true,	"chk");
                     InitDataProperty(0, cnt++ , dtCombo,			15,	  daCenter,	 true,	"chg_rule_tp_cd",			false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtComboEdit,	   	50,   daCenter,  true,	"chg_rule_def_cd",			true,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEditFormat,	110,  daCenter,  true,	"eff_dt",  					true,	"",	dfDateYmd,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEditFormat,	110,  daCenter,  true,	"exp_dt",     				true,	"",	dfDateYmd, 		 	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,    		80,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,  	    	45,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,        	40,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,         	80,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   		3,     true,       true,	10);
                     InitDataProperty(0, cnt++ , dtCombo,   		40,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
                     
                     InitDataProperty(0, cnt++ , dtCombo,  			40,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,   	    	40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     true,       true, 	3);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     true,       true,	5);                     
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	75,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	80,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     true,       true,	6);
                     InitDataProperty(0, cnt++ , dtCombo,    		80,   daCenter,  true,	"bkg_scg_grp_cmdt_cd", 		false,	"",	dfNone,				0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,   		80,   daCenter,  true,	"bkg_org_trsp_mod_cd",		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,  	    	80,   daCenter,  true,	"bkg_dest_trsp_mod_cd",		false,	"",	dfNone, 			0,     true,       true);
                     
                     InitDataProperty(0, cnt++ , dtCombo,        	70,   daCenter,  true,	"bkg_rcv_term_cd", 			false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,        	70,   daCenter,  true,	"bkg_de_term_cd",			false,	"",	dfNone,				0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,  		65,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     true,       true,	3);
                     InitDataProperty(0, cnt++ , dtCombo,			50,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,		75,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
                     
                     InitDataProperty(0, cnt++ , dtCombo,			70,   daCenter,  true,	"bkg_io_ga_cd",				false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,			60,   daCenter,  true,	"bkg_cnl_tz_cd", 			false,	"",	dfNone, 			0,     true,       true);
                                         
                     InitDataProperty(0, cnt++ , dtPopupEdit,		100,  daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     true,       true,	9);
                     InitDataProperty(0, cnt++ , dtPopupEdit,  	 	95,   daCenter,  true,	"bkg_act_cust_def_cd",		false,	"",	dfNone, 			0,     true,       true,	8);
                     InitDataProperty(0, cnt++ , dtCombo,			50,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);                     
                     InitDataProperty(0, cnt++ , dtCombo,      		90,   daCenter,  true,	"bkg_usa_svc_mod_cd",  		false,	"",	dfNone, 			0,     true,       true);
                     
                     InitDataProperty(0, cnt++ , dtCombo,      		60,   daCenter,  true,	"bkg_esvc_tp_cd",  			false,	"",	dfNone, 			0,     true,       true);
                     
                     InitDataProperty(0, cnt++ , dtCombo,   	 	70,   daCenter,  true,	"bkg_mst_hbl_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
                     
                     InitDataProperty(0, cnt++ , dtCombo,      		80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,        	70,   daCenter,  true,	"rule_appl_chg_tp_cd", 		false,	"",	dfNone, 			0,     true,       true);
 /////
                     InitDataProperty(0, cnt++ , dtComboEdit,        	70,   daCenter,  true,	"rule_appl_chg_cd", 		false,	"",	dfNone, 			0,     true,       true);
//////                                          
                     InitDataProperty(0, cnt++ , dtCombo,			50,   daCenter,  true,	"ign_trf_flg",				false,	"",	dfNone, 			0,     true,       true);                     
                     InitDataProperty(0, cnt++ , dtCombo,			100,  daLeft,    true,	"rt_patt_tp_cd",			false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,			80,   daCenter,  true,	"gen_spcl_rt_tp_cd",		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,   	 	40,   daCenter,  true,	"conv_rat_ut_cd",   		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,  			40,   daCenter,  true,	"conv_prc_cgo_tp_cd",		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,		80,   daCenter,  true,	"conv_cmdt_def_cd",			false,	"",	dfNone, 			0,     true,       true,	6);
                     InitDataProperty(0, cnt++ , dtPopupEdit,     	75,   daCenter,  true,	"conv_org_loc_def_cd",  	false,	"",	dfNone, 			0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtPopupEdit,		75,   daCenter,  true,	"conv_org_via_loc_def_cd",	false,	"",	dfNone, 			0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtPopupEdit,		75,   daCenter,  true,	"conv_dest_via_loc_def_cd",	false,	"",	dfNone,				0,     true,       true,	5);
                     InitDataProperty(0, cnt++ , dtPopupEdit,		75,   daCenter,  true,	"conv_dest_loc_def_cd", 	false,	"",	dfNone,				0,     true,       true,	5);
                     
                     InitDataProperty(0, cnt++ , dtCombo,   		70,   daCenter,  true,	"conv_prc_rcv_term_cd",		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,			70,   daCenter,  true,	"conv_prc_de_term_cd",		false,	"",	dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,			90,   daCenter,  true,	"upd_dt",					false,	"",	dfDateYmd,			0,     false,      false);
                     InitDataProperty(0, cnt++ , dtData,			90,   daCenter,  true,	"usr_nm",					false,	"",	dfNone,				0,     false,      false);

                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"svc_scp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"prop_no");
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
                     
                     /////////////////////////////////////////////////////////////////////////////////////////
                     //STATE코드는 CNT_CD+STE_CD로 저장되어야 하기때문에 아래와 같이 컬럼을 추가함
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_por_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pol_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_pod_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_del_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_org_loc_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_org_via_loc_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_dest_via_loc_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"conv_dest_loc_cnt_cd");
                     
                     
                     InitDataCombo(0, "chg_rule_tp_cd",	" |R|S", " |R|C");
                     InitDataCombo(0, "bkg_soc_flg", 	" |Yes|No", " |Y|N");										
                     InitDataCombo(0, "bkg_dir_call_flg", " |Yes|No", " |Y|N");                     
                     InitDataCombo(0, "ign_trf_flg", 	" |Yes|No", " |Y|N");										
                     
                     InitDataCombo(0, "rule_appl_chg_tp_cd", ruleApplChgTpCdComboText, ruleApplChgTpCdComboValue);
                     InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);            
                     InitDataCombo(0, "bkg_prc_cgo_tp_cd", bkgPrcCgoTpCdComboText, bkgPrcCgoTpCdComboValue);
                     InitDataCombo(0, "rt_op_cd", rtOpCdComboText, rtOpCdComboValue);
                     InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);
                     InitDataCombo(0, "bkg_usa_svc_mod_cd", bkgUsaSvcModCdComboText, bkgUsaSvcModCdComboValue);
                     InitDataCombo(0, "bkg_rcv_term_cd", bkgRcvTermCdComboText, bkgRcvTermCdComboValue);
                     InitDataCombo(0, "bkg_de_term_cd", bkgDeTermCdComboText, bkgDeTermCdComboValue);
                     InitDataCombo(0, "conv_prc_cgo_tp_cd", convPrcCgoTpCdComboText, convPrcCgoTpCdComboValue);
                     
                     InitDataCombo(0, "bkg_org_trsp_mod_cd", bkgOrgTrspModCdComboText, bkgOrgTrspModCdComboValue);
                     InitDataCombo(0, "bkg_dest_trsp_mod_cd", bkgDestTrspModCdComboText, bkgDestTrspModCdComboValue);
                     InitDataCombo(0, "bkg_mst_hbl_tp_cd", bkgMstHblTpCdText, bkgMstHblTpCdValue);
                     InitDataCombo(0, "gen_spcl_rt_tp_cd", genSpclRtTpCdComboText, genSpclRtTpCdComboValue);
                     InitDataCombo(0, "conv_prc_rcv_term_cd", convPrcRcvTermCdComboText, convPrcRcvTermCdComboValue);
                     InitDataCombo(0, "conv_prc_de_term_cd", convPrcDeTermCdComboText, convPrcDeTermCdComboValue);
                     
                     InitDataCombo(0, "bkg_rat_ut_cd", bkgRatUtCdComboText, bkgRatUtCdComboValue);
                     InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);                      
                     InitDataCombo(0, "conv_rat_ut_cd", convRatUtCdComboText, convRatUtCdComboValue);
                     InitDataCombo(0, "bkg_scg_grp_cmdt_cd", bkgScgGrpCmdtCdComboText, bkgScgGrpCmdtCdComboValue);  
                     InitDataCombo(0, "chg_rule_def_cd", chargeRuleCdComboText,chargeRuleCdComboValue);
                     
                     InitDataCombo(0, "bkg_io_ga_cd", bkgIoGaCdComboText, bkgIoGaCdComboValue);  
                     InitDataCombo(0, "bkg_cnl_tz_cd", bkgCnlTzCdComboText,bkgCnlTzCdComboValue);
                     InitDataCombo(0, "bkg_esvc_tp_cd", bkgEsvcTpCdComboText,bkgEsvcTpCdComboValue);
                     ////
                     InitDataCombo(0, "rule_appl_chg_cd", chargeCdComboText,chargeCdComboValue);
                     InitDataCombo(0, "rt_patt_tp_cd", rtPattTpCdComboText,rtPattTpCdComboValue);
                     
                     sChgCdVisiable = chargeRuleCdComboText;	//초기로딩값 세팅
                     byChgCdVisiable = chargeCdComboText;	//초기로딩값 세팅                
                     
                     InitDataValid(0, "chg_rule_def_cd", 			vtEngUpOnly);
                     InitDataValid(0, "rule_appl_chg_cd", 			vtEngUpOnly);
                     InitDataValid(0, "bkg_imdg_clss_cd", 			vtNumericOther, "."); 
 					 InitDataValid(0, "bkg_cmdt_def_cd", 			vtEngUpOther, "1234567890");
 					 //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
  					 InitDataValid(0, "bkg_por_def_cd",				vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					 InitDataValid(0, "bkg_pol_def_cd",				vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					 InitDataValid(0, "bkg_pod_def_cd",				vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					 InitDataValid(0, "bkg_del_def_cd",				vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					 InitDataValid(0, "conv_cmdt_def_cd",			vtEngUpOther, "1234567890");
					 InitDataValid(0, "conv_org_loc_def_cd",		vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					 InitDataValid(0, "conv_org_via_loc_def_cd",	vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					 InitDataValid(0, "conv_dest_via_loc_def_cd",	vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					 InitDataValid(0, "conv_dest_loc_def_cd",		vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					 InitDataValid(0, "bkg_ts_port_def_cd",			vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					 
					 InitDataValid(0, "bkg_slan_cd", 				vtEngUpOnly);
					 InitDataValid(0, "bkg_vvd_cd", 				vtEngUpOther, "1234567890");
					 InitDataValid(0, "bkg_act_cust_def_cd", 		vtEngUpOther, "1234567890");					 
					 
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
		
		if (!isFiredNested && (!openSheet2YN || OldRow != NewRow)) {  
			
			//CONVERSION에서 DEM/DET, Chassis는 선택불가
			if(sheetM.CellValue(NewRow, "note_clss_cd") =="D" || sheetM.CellValue(NewRow, "note_clss_cd") =="C") {
				ComShowCodeMessage("PRI00313");
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				return -1;
			} else {

				//하이라이트 처리
				changeSelectBackColor4Master(sheetM, document.form);
				
				//Item 에서 SURCHARGE 를 선택할 경우 SURCHARGE 항목 활성화
				if(sheetM.CellValue(NewRow,"note_clss_cd") == "S") {
					sheetD.ColHidden("chg_cd") = false;
				} else {
					sheetD.ColHidden("chg_cd") = true;
				}
				
				formObj.note_seq.value = sheetM.CellValue(NewRow, "note_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
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
		
		if (!openSheet3YN || OldRow != NewRow) {    			
			formObj.note_seq.value = sheetM.CellValue(NewRow, "note_seq");
			formObj.note_ctnt_seq.value = sheetM.CellValue(NewRow, "note_ctnt_seq");
			formObj.note_conv_mapg_id.value = sheetM.CellValue(NewRow, "note_conv_mapg_id");
			doActionIBSheet(sheetD,document.form,IBSEARCH_ASYNC01);
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
		
		if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }

		buttonControl();
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
	  				//화면로딩시에는 부모창의 데이터를 가져온다.
					var sXml = dialogArguments.getSheetXml(0);
					sheetObj.LoadSearchXml(sXml);
					break;
					
				case IBSEARCHAPPEND: // 조회
	  				ComOpenWait(true);
					if(openSheet2YN) {
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_0003_10GS.do" , FormQueryString(formObj));
					} else {
						//화면로딩시에는 부모창의 데이터를 가져온다.
						var sXml = dialogArguments.getSheetXml(1);
						sheetObj.LoadSearchXml(sXml);
					}				
					break;
						
	 			case IBSEARCH_ASYNC01: // 조회
	  				ComOpenWait(true);
		 			// NOTE CONVERSION RULE
					var sCd = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			
		 			////////////////////////////////////////////////////////////////////////////////
					//Conversion-Code 에 저장된 데이터중에는 Rule, Charge 코드리스트에 없는 코드가 존재하기 때문에
					//Sheet 에 표시하기 위해서는 Code Combo List 를 다시 세팅해야 한다.(InitDataCombo())
		 			formObj.f_cmd.value = SEARCH03;
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_0032GS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd");			
	  				
					if (arrData != null && arrData.length > 0) {
						for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
						sheetObj.InitDataCombo(0,"chg_rule_def_cd", sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
					}
				
					sheetObj.LoadSearchXml(sXml);
	 				break;
		 			  		
	 			case IBSAVE: // 저장  	
	 			
		  			if((ComShowCodeConfirm("PRI00001")) ) {
		  					  					  				
		  				//C/TYPE만 업데이트할경우가 존재하기때문에 저장을 분리함.
		  				if(sheetObj.IsDataModified) {	
			  				ComOpenWait(true);
				  			formObj.f_cmd.value = MULTI01;
				  			formObj.note_conv_mapg_id.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_mapg_id");
				  			
							var sParam = FormQueryString(formObj);
			  				var sParamSheet = sheetObj.GetSaveString();
			  				if (sParamSheet != "") {
			  					sParam = ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
			  				}
			  					  			
			  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0032GS.do", sParam); 
			  				sheetObj.LoadSaveXml(sXml);
			  				
							
		  				} else {
			  				ComOpenWait(true);
		  					formObj.f_cmd.value = MODIFY;
				  			formObj.note_conv_mapg_id.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_mapg_id");			  									
	
				  			var sXml = sheetObj.GetSaveXml("ESM_PRI_0032GS.do", FormQueryString(formObj));
				  			sheetObj.LoadSaveXml(sXml);
		  				}
	
						//메인의 Conversion Flag에 데이터를 세팅한다.
						var obj = new Object();
						if(sheetObj.RowCount > 0){
							obj.note_conv_flg = "1";
							obj.master_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_seq");
							obj.detail_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_ctnt_seq");
							obj.amdt_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq");
							obj.note_chg_tp_cd = comboObjects[0].Code;												
						} else {
							obj.note_conv_flg = "0";
							obj.master_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_seq");
							obj.detail_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_ctnt_seq");
							obj.amdt_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq");
							obj.note_chg_tp_cd = comboObjects[0].Code;
						}
						
						array[arrayCnt]= obj;
						window.returnValue = array;
						arrayCnt++;
						
		  			}
	 				break;
	 				
	 			case IBINSERT: // Row Add
					
					var idx = sheetObj.DataInsert();
	 			
		  			sheetObj.CellValue2(idx, "exp_dt") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"exp_dt");					
					sheetObj.CellValue2(idx, "eff_dt") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"eff_dt");
					sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
					sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
					sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
					sheetObj.CellValue2(idx, "note_conv_mapg_id") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_mapg_id");
					sheetObj.CellValue2(idx, "note_conv_tp_cd") = "P"; //Proposal Special Note
					sheetObj.CellValue2(idx, "note_conv_seq") = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
					
					if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"note_clss_cd") == "G") {
						sheetObj.CellValue2(idx, "chg_rule_tp_cd") = "C";//CHARGE
						sheetObj.CellValue2(idx, "chg_rule_def_cd") = "GRI";
			 			sheetObj.CellValue2(idx, "note_conv_chg_cd") = "GRI";
					} else if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"note_clss_cd") == "S") { 
						sheetObj.CellValue2(idx, "chg_rule_tp_cd") = "C";//CHARGE
						sheetObj.CellValue2(idx, "chg_rule_def_cd") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "chg_cd");
			 			sheetObj.CellValue2(idx, "note_conv_chg_cd") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "chg_cd");
					}
					sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
					
					
					//Code 에 Default 값이 존재할경우 적용
					defaultColumnValidation(sheetObj, idx, "chg_rule_def_cd", sheetObj.CellValue(idx, "chg_rule_def_cd"));
					//Editable를 세팅한다.
					disableColumnValidation(sheetObj, idx, "chg_rule_def_cd", sheetObj.CellValue(idx, "chg_rule_def_cd"));
					
												  	
	 				break;
	 				
				case IBDELETE: // Delete
					var iCheckRow = sheetObj.FindCheckedRow("chk");
					if(iCheckRow == ""){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}
					iCheckRow = sheetObj.FindCheckedRow("chk");	
					
					if(iCheckRow != "") {
						deleteRowCheck(sheetObj, "chk");
					}
					break;
					
				case IBCOPYROW:
					copySheetData(sheetObj);
					break;
					
				case COMMAND01: //COPY
					
					var iCheckRow = sheetObj.FindCheckedRow("chk");
				
					//카피하시겠습니까?
					if((ComShowCodeConfirm("PRI00012")) ) {

						if(iCheckRow != "") {
							comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
						}
						
		  				ComOpenWait(true);
						formObj.f_cmd.value = MULTI02;
						var sParam = FormQueryString(formObj);
		  				var sParamSheet = sheetObj.GetSaveString();
		  				if (sParamSheet != "") {
		  					sParam = ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
		  				}
		  					  				
		  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0032GS.do", sParam); 

						//sheetObj.CheckAll2("chk") = "0";
		  				sheetObj.LoadSaveXml(sXml);
					}
					
					break;
					
				case COMMAND02: //PASTE
				
					//붙여넣기 하시겠습니까?
					if((ComShowCodeConfirm("PRI00016")) ) {
		  				ComOpenWait(true);
						// NOTE CONVERSION RULE
						var sCd = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
						var sNm = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
					
						formObj.f_cmd.value = SEARCH04;
						var sXml = sheetObj.GetSearchXml("ESM_PRI_0032GS.do", FormQueryString(formObj));				
						var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd"); 
				      	
				      	if(arrData != null && arrData.length > 0) {
				      		//콤보리스트에 추가후 InitDataCombo 호출
				      		for(var i=0; i<arrData.length; i++){						
								if (sCd.indexOf(arrData[i][0]) < 0) {
									sCd += "|" + arrData[i][0];
									sNm += "|" + arrData[i][0];
								}
							}					
							sheetObj.InitDataCombo(0,"chg_rule_def_cd", sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
				      		sheetObj.LoadSearchXml(sXml, true);
				      				    
				      		//SHEET를 LOAD한 후에 기본 값을 세팅한다.
				      		var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
				      		var arrRow = ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
				      		
				      		if(arrRow != null && arrRow.length > 0) {  
				      			
				      			for(var i=0; i<arrRow.length; i++) {
					      			sheetObj.RowStatus(arrRow[i]) 						= "I";
					      			sheetObj.CellValue2(arrRow[i], "note_conv_seq") 	= maxSeq + i;
					      			sheetObj.CellValue2(arrRow[i], "note_conv_mapg_id") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_mapg_id");
					      			sheetObj.CellValue2(arrRow[i], "svc_scp_cd") 		= formObj.svc_scp_cd.value;
					      			sheetObj.CellValue2(arrRow[i], "prop_no") 			= formObj.prop_no.value;
									sheetObj.CellValue2(arrRow[i], "amdt_seq") 			= formObj.amdt_seq.value;
									
					      			sheetObj.CellValue2(arrRow[i], "note_conv_tp_cd") 	= "P"; //Proposal Special Note
				      			}
				      		}	
				      	} else {
				      		ComShowCodeMessage("PRI00328");
				      	}
	
					}
			      	
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
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 최성민
     * @version 2009.06.25
     */  
 	function sheet3_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
 		switch(colName)
     	{
     		case "chg_rule_tp_cd":
     			//CODE가 ADD인경우에만 사용됨.
     			var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
     	 		
     	 		if(Value == "C" && chgRuleDefCd == "ADD") {
     	 			//CHARGE
     	 			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "C"; 
     	 			sheetObj.CellValue2(Row, "note_conv_chg_cd") = chgRuleDefCd;
     	 			sheetObj.CellValue2(Row, "note_conv_rule_cd") = "";
     	 		} else if(Value == "R" && chgRuleDefCd == "ADD") {
     	 			//RULE
     	 			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R"; 
     	 			sheetObj.CellValue2(Row, "note_conv_rule_cd") = chgRuleDefCd;
     	 			sheetObj.CellValue2(Row, "note_conv_chg_cd") = "";
     	 		}
     	 		     	 		
				//DEFAULT 데이터처리
				defaultColumnValidation(sheetObj, Row, "chg_rule_def_cd", chgRuleDefCd);
				//컬럼 disable 처리
				disableColumnValidation(sheetObj, Row, "chg_rule_def_cd", chgRuleDefCd);	
				
				break;
				
 			case "chg_rule_def_cd":		
 				
 				if (Value != null && Value != "" && Value.length == 3) {
 					//DEFAULT 데이터처리
 					defaultColumnValidation(sheetObj, Row, Col, Value);
 					//컬럼 disable 처리
 					disableColumnValidation(sheetObj, Row, Col, Value);
 					
 					var sCode = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
 					var sText = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");

 					if (sCode.indexOf(Value) < 0) {
 						formObj.f_cmd.value = COMMAND09;
 						sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
 						
 						var arrData = ComPriXml2Array(sXml, "cd|nm");
 						if (arrData != null && arrData.length > 0) {
 							sCode += "|" + Value;
 							sText += "|" + Value;
 							sheetObj.InitDataCombo(0, "chg_rule_def_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
 							
 							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value); 							
 						} else {
 							sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
 						}
 					}
 					
 					insertChargeRuleType(sheetObj, Row);
 	                  /*[CSR #1652] [Conversion] Rule code : NOT 선택 시 Pop Up msg 생성*/
                    if( sheetObj.CellValue(Row, "chg_rule_def_cd" ) == "NOT"){
                       ComShowCodeMessage("PRI00362");
                    }
				} else {
 					sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
 				}

 				// Rule & Charge Code 색 구분
 				//setChargeRuleColor(sheetObj, Row);
 				break;
 				
 				
 			case "eff_dt":	
				var effDt = ComGetDateAdd(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "eff_dt"), "D", 0, "");
		 		var expDt = ComGetDateAdd(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "exp_dt"), "D", 0, "");

		 		//이행데이터이면 (I) validation 하지 않는다.
		 		if(returnCreationTypeCode()) {
		 			return true;
		 		}
		 		
 				if(sheetObj.CellValue(Row, "eff_dt") < effDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.CellValue2(Row, "eff_dt") = effDt;
 					sheetObj.SelectCell(Row,"eff_dt");
 				}
 				
 				if(sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt") ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.CellValue2(Row, "eff_dt") = effDt;
 					sheetObj.SelectCell(Row,"eff_dt");
 				}
 				break;
 				
 			case "exp_dt":	
 				var effDt = ComGetDateAdd(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "eff_dt"), "D", 0, "");
		 		var expDt = ComGetDateAdd(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "exp_dt"), "D", 0, "");
 				
		 		//이행데이터이면 (I) validation 하지 않는다.
		 		if(returnCreationTypeCode()) {
		 			return true;
		 		}
		 		
 				if(sheetObj.CellValue(Row, "exp_dt") > expDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.CellValue2(Row, "exp_dt") = expDt;
 					sheetObj.SelectCell(Row,"exp_dt");
 				}
 				
 				if(sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt") ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.CellValue2(Row, "exp_dt") = expDt;
 					sheetObj.SelectCell(Row,"exp_dt");
 				}
 				break;
 				
			case "bkg_prc_cgo_tp_cd": 	
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				
				if(chgRuleDefCd == "APP"){
					if(Value != "DG") {
						ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
						sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") = "";
					}
				}
				
				if(Value == "DG") {
					sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = true;
				} else {
					sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = false;
					sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
				}
				break;	
						
 			case "bkg_cmdt_def_cd":	
 				
 				if (Value.length == 5) { //Group Commodity
 					var propNo = formObj.prop_no.value;
 					var amdtSeq = formObj.amdt_seq.value;
 					var svcScpCd = formObj.svc_scp_cd.value;

 					formObj.f_cmd.value = SEARCH10;
 					formObj.cd.value = Value;
 					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=proposal");
 					var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 				
 					if(arrData[1] != ""){
 						sheetObj.CellValue2(Row, "bkg_cmdt_def_cd") = Value;
 						sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = 'G';
 					} else {
 						sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd") = "";
 						sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd") = "";
 						sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 					}

 				} else if (Value.length == 6) {
	    			formObj.f_cmd.value = SEARCH08;
	    			//COMMODITY CODE 앞에 '0'문자로 채움
	    			formObj.cd.value = ComLpad(Value, 6, "0");
	    			
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
  					if (arrData[1] != "") {
  						sheetObj.CellValue2(Row,"bkg_cmdt_def_cd") = Value;
  						//6자리일경우 COMMODITY CODE임
						sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = "C";
  					}else{
	  					sheetObj.CellValue2(Row,"bkg_cmdt_def_cd") = "";
	  					sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
  					}
 				} else {
 					sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd") = "";
 					sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd") = "";
 					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 				}
 				
 	    		break;
 	    		
 			case "bkg_por_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"bkg_por_def_cd") = Value;
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_por_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_por_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_por_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_por_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_por_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_por_def_cd") ; 				
 	    		}
 	    		sheetObj.CellBackColor(Row,"bkg_por_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_pol_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	  				
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"bkg_pol_def_cd") = Value;
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_pol_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_pol_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_pol_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_pol_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_pol_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_pol_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_pod_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	  				
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"bkg_pod_def_cd") = Value;
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_pod_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_pod_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_pod_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_pod_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_pod_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_pod_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_del_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	  				
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"bkg_del_def_cd") = Value;
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_del_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_del_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_del_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_del_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_del_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_del_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"bkg_del_def_cd") = 0;
 	    		break;	
 	    		
 			case "rt_appl_tp_cd":	
 				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
 				var chgRuleTpCd = 	sheetObj.CellValue(Row, "chg_rule_tp_cd");
 				var rtOpCd = 	sheetObj.CellValue(Row, "rt_op_cd");

 				if(Value == "A" || Value == "F") {
 					sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 					sheetObj.CellValue2(Row, "curr_cd") 		= "USD";
 					sheetObj.CellValue2(Row, "frt_rt_amt") 		= "0";
 					sheetObj.CellEditable(Row, "rt_op_cd")		= true;
					sheetObj.CellEditable(Row, "curr_cd")		= true;
					sheetObj.CellEditable(Row, "frt_rt_amt")	= true;
 				} else {
 					sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
 					sheetObj.CellValue2(Row, "curr_cd") 		= "";
 					sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
 					sheetObj.CellEditable(Row, "rt_op_cd")		= false;
 					sheetObj.CellEditable(Row, "curr_cd") 		= false;
 					sheetObj.CellEditable(Row, "frt_rt_amt")	= false;
 				}
 				
 				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "RAC" && chgRuleDefCd != "NOT"
 					&& chgRuleDefCd != "ADD" && chgRuleDefCd != "FAD" && chgRuleDefCd != "FAR ") { //[CHM-201325096]FAR, FAD 추가
 					if( Value == "F") {
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellEditable(Row, "rt_op_cd") 	= false;
 					}
 					
 					if( Value == "A") {
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellEditable(Row, "curr_cd") 	= false;
 					}
 				} else if(chgRuleDefCd == "ADD" && chgRuleTpCd == "C") {
 					if( Value == "F") {
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellEditable(Row, "rt_op_cd") 	= false;
 					}
 					
 					if( Value == "A") {
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellEditable(Row, "curr_cd") 	= false;
 					}
 					
 	    		} else if((chgRuleDefCd == "ADD" && chgRuleTpCd == "R") || chgRuleDefCd == "ARB" ) { 
 	    			if (Value == "I" || Value == "A"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 	    				sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 						
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			} else if (Value == "S" || Value == "N"){
 						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 					} else {
 						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= true;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 						sheetObj.CellValue2(Row, "curr_cd") 	= "USD";
 						sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "0";
 					}
 	    		} else if(chgRuleDefCd == "NOT") {
 	    			if (Value != "I" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "I";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			}
 	    		} else if(chgRuleDefCd == "APP") { 
 	    			if (Value != "S" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
 						sheetObj.CellValue2(Row, "curr_cd") 		= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			}
 	    		} else if(chgRuleDefCd == "FAR" || chgRuleDefCd == "FAD" ) { //[CHM-201325096]FAR, FAD 추가
 	    			if (Value != "S"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
 						sheetObj.CellValue2(Row, "curr_cd") 		= "";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 	    			}
 	    		} else if(chgRuleDefCd == "TYP") {
 	    			
 	    			if (Value == "A"){ 	    	    				
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 						sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
 	    				sheetObj.CellValue2(Row, "curr_cd") 		= "";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 	    			} else if (Value == "N"){ 	    	    				
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 						sheetObj.CellValue2(Row, "curr_cd") 	= "";
 	    			} else {
 	    				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 	    				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 	    				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
 	    				sheetObj.CellValue2(Row, "curr_cd") 		= "";
 	    				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 						sheetObj.CellValue2(Row, "frt_rt_amt") 		= "0";
 	    			}
 	    		}
 				
 	    		break;
 	    		
 			case "rt_op_cd":
 				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
 				var chgRuleTpCd = 	sheetObj.CellValue(Row, "chg_rule_tp_cd");
 				var rtApplTpCd = 	sheetObj.CellValue(Row, "rt_appl_tp_cd");
 				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 					&& chgRuleDefCd != "RAC" && chgRuleDefCd != "ARB" && chgRuleDefCd != "NOT"
 	 				&& chgRuleDefCd != "ADD" && chgRuleDefCd != "FAR" && chgRuleDefCd != "FAD") { //[CHM-201325096]FAR, FAD 추가
 										
 					if( rtApplTpCd == "F") {
 			    		if(Value == ">" || Value == "<" ) {
 			    			ComShowCodeMessage("PRI00326");
 			    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
 			    			sheetObj.SelectCell(Row, "rt_op_cd");
 			    		}
 		    		}
 				} else if(chgRuleDefCd == "ADD" &&chgRuleTpCd == "C") {
 					if( rtApplTpCd == "F") {
 			    		if(Value == ">" || Value == "<" ) {
 			    			ComShowCodeMessage("PRI00326");
 			    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
 			    			sheetObj.SelectCell(Row, "rt_op_cd");
 			    		}
 		    		}
 				} else if(chgRuleDefCd == "RAR") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 				} else if(chgRuleDefCd == "RAP") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		} else if(chgRuleDefCd == "DOR") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		} else if(chgRuleDefCd == "TYP") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.CellValue2(Row, "rt_op_cd") 	= "+";
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		}
 	    		break;	
 	    		 	    		
 			case "conv_cmdt_def_cd":	
 				if (Value.length == 5) { //Group Commodity
 					var propNo = formObj.prop_no.value;
					var amdtSeq = formObj.amdt_seq.value;
					var svcScpCd = formObj.svc_scp_cd.value;

 					formObj.f_cmd.value = SEARCH10;
 					formObj.cd.value = Value;
 					sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=proposal");
 					var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 					
 					if(arrData[1] != ""){
 						sheetObj.CellValue2(Row, "conv_cmdt_def_cd") = Value;
 						sheetObj.CellValue2(Row, "conv_cmdt_tp_cd") = 'G';
 					} else {
 						sheetObj.Cellvalue2(Row,"conv_cmdt_def_cd") = "";
 						sheetObj.Cellvalue2(Row,"conv_cmdt_tp_cd") = "";
 						sheetObj.SelectCell(Row,"conv_cmdt_def_cd");
 					} 					
 				} else if (Value.length == 6) {
 					formObj.f_cmd.value = SEARCH08;
	    			//COMMODITY CODE 앞에 '0'문자로 채움
	    			formObj.cd.value = ComLpad(Value, 6, "0");
	    			
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
  					if (arrData[1] != ""){
  						sheetObj.CellValue2(Row,"conv_cmdt_def_cd") = Value;
  						//6자리일경우 COMMODITY CODE임
						sheetObj.CellValue2(Row, "conv_cmdt_tp_cd") = "C";
  					}else{
	  					sheetObj.CellValue2(Row,"conv_cmdt_def_cd") = "";
	  					sheetObj.CellValue2(Row,"conv_cmdt_tp_cd") = "";
	  					sheetObj.SelectCell(Row,"conv_cmdt_def_cd");
  					}  					
 				} else {
 					sheetObj.Cellvalue2(Row,"conv_cmdt_def_cd") = "";
 					sheetObj.Cellvalue2(Row,"conv_cmdt_tp_cd") = "";
 					sheetObj.SelectCell(Row,"conv_cmdt_def_cd");
 				}
 				
 	    		break;
 	    		
 			case "conv_org_loc_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"conv_org_loc_def_cd") = Value;
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "conv_org_loc_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"conv_org_loc_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"conv_org_loc_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"conv_org_loc_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "conv_org_loc_def_cd") = "";
   					sheetObj.CellValue2(Row, "conv_org_loc_tp_cd") = "";
   					sheetObj.SelectCell(Row, "conv_org_loc_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = 0;
 	    		break;	
 	    		
 			case "conv_org_via_loc_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"conv_org_via_loc_def_cd") = Value;
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "conv_org_via_loc_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"conv_org_via_loc_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"conv_org_via_loc_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"conv_org_via_loc_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "conv_org_via_loc_def_cd") = "";
   					sheetObj.CellValue2(Row, "conv_org_via_loc_tp_cd") = "";
   					sheetObj.SelectCell(Row, "conv_org_via_loc_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = 0;
 	    		break;	
 	    		
 			case "conv_dest_via_loc_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"conv_dest_via_loc_def_cd") = Value;
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "conv_dest_via_loc_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"conv_dest_via_loc_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"conv_dest_via_loc_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"conv_dest_via_loc_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "conv_dest_via_loc_def_cd") = "";
   					sheetObj.CellValue2(Row, "conv_dest_via_loc_tp_cd") = "";
   					sheetObj.SelectCell(Row, "conv_dest_via_loc_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = 0;
 	    		break;	
 	    		
 			case "conv_dest_loc_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"conv_dest_loc_def_cd") = Value;
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "conv_dest_loc_def_cd") = arrData[0];
 						getLocationTypeCode(sheetObj, Row, Col, Value.length);
   					}else{
 	  					sheetObj.CellValue2(Row,"conv_dest_loc_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"conv_dest_loc_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"conv_dest_loc_def_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "conv_dest_loc_def_cd") = "";
   					sheetObj.CellValue2(Row, "conv_dest_loc_tp_cd") = "";
   					sheetObj.SelectCell(Row, "conv_dest_loc_def_cd");  				
 	    		}
 	    		sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_ts_port_def_cd":	    		
 	    		if (Value.length == 5){
 	    			formObj.f_cmd.value = COMMAND24;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&etc1="+PRI_SP_SCP;
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if(Value == "EAST" || Value == "WEST" || Value == "IPBC" ) {
						sheetObj.CellValue2(Row,"bkg_ts_port_def_cd") = Value;
						sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "L";			
 						//T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
 						sheetObj.CellEditable(Row, "bkg_dir_call_flg") = false;
					} else if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = arrData[0];
 						sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "L";
 						 						
 						//T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
 						sheetObj.CellEditable(Row, "bkg_dir_call_flg") = false;
 						
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_ts_port_def_cd") = "";
 	  					sheetObj.CellValue2(Row,"bkg_ts_port_tp_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_ts_port_def_cd");
 	  					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
   					sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");  	
   					sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
 	    		}
 	    	
 	    		sheetObj.CellBackColor(Row,"bkg_ts_port_def_cd") = 0;
 	    		break;	
 	    		
 			case "bkg_dir_call_flg":
 	    		if (Value == "Y"){
 	    			sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
 	    			sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
 	    			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = false;
 	    		} else {
 	    			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = true;
 	    		}
 	    		break;	
 	    		
 			case "bkg_slan_cd":
 				if (Value.length == 3){
 	    			formObj.f_cmd.value = COMMAND26;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_slan_cd") = arrData[0];
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_slan_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_slan_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_slan_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_slan_cd");  				
 	    		}
 	    		break;
 	    		
 			case "bkg_vvd_cd":
 				if (Value.length == 9){
 					
 					var vslCd 		= Value.substring(0,4);
 					var skdVoyNo 	= Value.substring(4,8);
 					var skdDirCd 	= Value.substring(8,9);
 							
 	    			var sParam = "f_cmd="+COMMAND27;
 	    			sParam += "&cd="+vslCd;
 	    			sParam += "&etc1="+skdVoyNo;
 	    			sParam += "&etc2="+skdDirCd;
 	  
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if (arrData != null && arrData.length > 0) {
 	  					sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= arrData[0];
 						sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= vslCd;
 						sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= skdVoyNo;
 						sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= skdDirCd;
 						
   					}else{
 						sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
 						sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
 						sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
 						sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
   						sheetObj.SelectCell(Row, "bkg_vvd_cd");
 	  					
   					}
 	    		} else{	
 	    			sheetObj.CellValue2(Row, "bkg_vvd_cd") 		= "";
					sheetObj.CellValue2(Row, "bkg_vsl_cd") 		= "";
					sheetObj.CellValue2(Row, "bkg_skd_voy_no")	= "";
					sheetObj.CellValue2(Row, "bkg_skd_dir_cd")	= "";
 	    			sheetObj.SelectCell(Row, "bkg_vvd_cd");	
  						
 	    		}
 	    		break;
 	    		
 			case "bkg_act_cust_def_cd": 				
 				if (Value.length > 2){
 					var bkgActCustCntCd		= Value.substring(0,2);
 					var bkgActCustSeq 		= ComLpad(Value.slice(2), 6, "0");
 					
 					formObj.f_cmd.value = SEARCH01; 	    			
 	    			var sParam = FormQueryString(formObj);
 	    			sParam += "&cust_cnt_cd="+bkgActCustCntCd;
 	    			sParam += "&cust_seq="+bkgActCustSeq;
 	    			 	    			
   	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_4014GS.do", sParam);	  			
   	  				var arrData = ComPriXml2Array(sXml, "cust_cnt_cd|cust_seq");
   	  				
   	  				if (arrData != null && arrData.length > 0){
						sheetObj.CellValue2(Row,"bkg_act_cust_def_cd") = bkgActCustCntCd + bkgActCustSeq;
						sheetObj.CellValue2(Row, "bkg_act_cust_cnt_cd")	= bkgActCustCntCd;
						sheetObj.CellValue2(Row, "bkg_act_cust_seq")	= bkgActCustSeq;
					}else{
						sheetObj.CellValue2(Row, "bkg_act_cust_def_cd")	= "";
						sheetObj.CellValue2(Row, "bkg_act_cust_cnt_cd")	= "";
						sheetObj.CellValue2(Row, "bkg_act_cust_seq")	= "";
						sheetObj.SelectCell(Row, "bkg_act_cust_def_cd");	

					} 					
 				} else {
 					sheetObj.CellValue2(Row, "bkg_act_cust_def_cd")	= "";
					sheetObj.CellValue2(Row, "bkg_act_cust_cnt_cd")	= "";
					sheetObj.CellValue2(Row, "bkg_act_cust_seq")	= "";
					sheetObj.SelectCell(Row, "bkg_act_cust_def_cd");
 				}
 	    		break; 	 
 	    		
 			case "bkg_imdg_clss_cd":
 				if (Value.length > 0){
 	    			formObj.f_cmd.value = COMMAND30;
 	    			formObj.cd.value = Value;
 	    			var sParam = FormQueryString(formObj);
 	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 	
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = arrData[0];
   					}else{
 	  					sheetObj.CellValue2(Row,"bkg_imdg_clss_cd") = "";
 	  					sheetObj.SelectCell(Row,"bkg_imdg_clss_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
   					sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");  				
 	    		}
 	    		break;
 	    		
 			case "curr_cd":
 				var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
 				var chgRuleTpCd = sheetObj.CellValue(Row, "chg_rule_tp_cd");
 				if(chgRuleDefCd == "ARB" || (chgRuleDefCd == "ADD" && chgRuleTpCd == "R")){
	 				if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK"){
	 	    			
	 					ComShowCodeMessage("PRI01074","USD, EUR, GBP, INR, NOK");
	 					sheetObj.CellValue2(Row, "curr_cd") = "USD";
	 					sheetObj.SelectCell(Row, "curr_cd");
	 	    		}
 				}
 	    		break;
 	    		
 			case "rule_appl_chg_tp_cd":
 				var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
 				var ruleApplChgTpCd = sheetObj.CellValue(Row, "rule_appl_chg_tp_cd");
 				if(chgRuleDefCd == "TYP" && ruleApplChgTpCd =="S"){
 					sheetObj.CellEditable(Row, "rule_appl_chg_cd") 		= true;
 					sheetObj.CellEditable(Row, "ign_trf_flg") 			= true;
 				}else{
 					sheetObj.CellValue(Row, "rule_appl_chg_cd") = "";
 					sheetObj.CellValue(Row, "ign_trf_flg")      = "";
 					sheetObj.CellEditable(Row, "rule_appl_chg_cd") 		= false;
 					sheetObj.CellEditable(Row, "ign_trf_flg") 			= false;
 				}
 				break;
 				
 			case "rule_appl_chg_cd":						
 				if (Value != null && Value != "" && Value.length == 3) { 					
 					var sCode = sheetObj.GetComboInfo(0, "rule_appl_chg_cd", "Code");
 					var sText = sheetObj.GetComboInfo(0, "rule_appl_chg_cd", "Text");

 					if (sCode.indexOf(Value) < 0) {
 						formObj.f_cmd.value = COMMAND09;
 						sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
 						
 						var arrData = ComPriXml2Array(sXml, "cd|nm");
 						if (arrData != null && arrData.length > 0) {
 							sCode += "|" + Value;
 							sText += "|" + Value;
 							sheetObj.InitDataCombo(0, "rule_appl_chg_cd", sText, sCode, "", "", 0, "", "", byChgCdVisiable);							
 							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value); 							
 						} else {
 							sheetObj.CellValue2(Row, "rule_appl_chg_cd") = "";
 						}
 					}				
 				} else {
 					sheetObj.CellValue2(Row, "rule_appl_chg_cd") = "";
 				}
 				break;	 				
 			case "rt_patt_tp_cd":
				var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
				if(    chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "TYP" 
					&& chgRuleDefCd != "RAC" && chgRuleDefCd != "RAS" && chgRuleDefCd != "APP" ) {
					sheetObj.CellValue2(Row, "rt_patt_tp_cd") = "";
				}
				break;
     	} 		
 	}
  
  	/**
  	 * ROUTE의 항목에 데이터 입력시 해당하는 ROUTE의 TYPE CODE를 세팅하는 FUNCTION <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {int} Len 필수 이벤트가 발생한 해당 셀의 Value Length
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.15
  	 */ 
     function getLocationTypeCode(sheetObj, Row, Col, Len) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		switch(colName)
     	{
 			case "bkg_por_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "L";
 		    	} else if(Len == 2) {
 		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "C";
 		    	} else if(Len == 3) {
 		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "R";
 		    	} else if(Len == 4) {
 		    		sheetObj.CellValue2(Row, "bkg_por_tp_cd") = "G";
 		    	}
 		    	break;
 		    	
 			case "bkg_pol_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "L";
 		    	} else if(Len == 2) {
 		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "C";
 		    	} else if(Len == 3) {
 		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "R";
 		    	} else if(Len == 4) {
 		    		sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = "G";
 		    	} 
 		    	break;

 			case "bkg_pod_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "L";
 		    	} else if(Len == 2) {
 		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "C";
 		    	} else if(Len == 3) {
 		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "R";
 		    	} else if(Len == 4) {
 		    		sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = "G";
 		    	} 
 		    	break;
 		    	
 			case "bkg_del_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "L";
 		    	} else if(Len == 2) {
 		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "C";
 		    	} else if(Len == 3) {
 		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "R";
 		    	} else if(Len == 4) {
 		    		sheetObj.CellValue2(Row, "bkg_del_tp_cd") = "G";
 		    	} 
 		    	break;
 		    	
 			case "conv_org_loc_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.CellValue2(Row, "conv_org_loc_tp_cd") = "L";
 		    	} else if(Len == 2) {
 		    		sheetObj.CellValue2(Row, "conv_org_loc_tp_cd") = "C";
 		    	} else if(Len == 3) {
 		    		sheetObj.CellValue2(Row, "conv_org_loc_tp_cd") = "R";
 		    	} else if(Len == 4) {
 		    		sheetObj.CellValue2(Row, "conv_org_loc_tp_cd") = "G";
 		    	}
 		    	break;
 		    	
 			case "conv_org_via_loc_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.CellValue2(Row, "conv_org_via_loc_tp_cd") = "L";
 		    	} else if(Len == 2) {
 		    		sheetObj.CellValue2(Row, "conv_org_via_loc_tp_cd") = "C";
 		    	} else if(Len == 3) {
 		    		sheetObj.CellValue2(Row, "conv_org_via_loc_tp_cd") = "R";
 		    	} else if(Len == 4) {
 		    		sheetObj.CellValue2(Row, "conv_org_via_loc_tp_cd") = "G";
 		    	}
 		    	break;

 			case "conv_dest_via_loc_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.CellValue2(Row, "conv_dest_via_loc_tp_cd") = "L";
 		    	} else if(Len == 2) {
 		    		sheetObj.CellValue2(Row, "conv_dest_via_loc_tp_cd") = "C";
 		    	} else if(Len == 3) {
 		    		sheetObj.CellValue2(Row, "conv_dest_via_loc_tp_cd") = "R";
 		    	} else if(Len == 4) {
 		    		sheetObj.CellValue2(Row, "conv_dest_via_loc_tp_cd") = "G";
 		    	} 
 		    	break;
 		    	
 			case "conv_dest_loc_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.CellValue2(Row, "conv_dest_loc_tp_cd") = "L";
 		    	} else if(Len == 2) {
 		    		sheetObj.CellValue2(Row, "conv_dest_loc_tp_cd") = "C";
 		    	} else if(Len == 3) {
 		    		sheetObj.CellValue2(Row, "conv_dest_loc_tp_cd") = "R";
 		    	}  else if(Len == 4) {
 		    		sheetObj.CellValue2(Row, "conv_dest_loc_tp_cd") = "G";
 		    	}
 		    	break;
     	}
     	
     }

 	/**
 	 * Duration 의 Validation function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @return 없음
 	 * @author 최성민
 	 * @version 2009.07.15
 	 */ 
     function checkDuration(sheetObj) {
 		var formObj = document.form;
 		var rowCount = sheetObj.RowCount;
 		var effDt = ComGetDateAdd(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "eff_dt"), "D", 0, "");
 		var expDt = ComGetDateAdd(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "exp_dt"), "D", 0, "");
 		var prcPropCreTpCd = formObj.prc_prop_cre_tp_cd.value;
 		
 		//이행데이터이면 (I) validation 하지 않는다.
 		if(returnCreationTypeCode()) {
 			return true;
 		}
 		
 		if(rowCount > 0){
 			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
 				if (sheetObj.RowStatus(i) == "D") {
					continue;
				}
 				
 				if(sheetObj.CellValue(i, "eff_dt") < effDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.CellValue2(i, "eff_dt") = effDt;
 					sheetObj.SelectCell(i, "eff_dt");
 					return false;
 				}
 				
 				if(sheetObj.CellValue(i, "eff_dt") > sheetObj.CellValue(i, "exp_dt") ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.CellValue2(i, "eff_dt") = effDt;
 					sheetObj.CellValue2(i, "exp_dt") = expDt;
 					sheetObj.SelectCell(i, "eff_dt");
 					return false;
 				}
 				
 				if(sheetObj.CellValue(i, "exp_dt") > expDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.CellValue2(i, "exp_dt") = expDt;
 					sheetObj.SelectCell(i, "exp_dt");
 					return false;
 				}
 			}
 		}
 		
 		return true;
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
 		
   		case IBSAVE:
   			
   			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
				return false;
			}
   			
   			if(!checkDuration(sheetObj)) {
   				return false;
   			}
   			
	   		//FOCUS가 ROW이동될때마다 체크하는 방식을 SAVE할때 체크하는걸로 수정 - 잘못된 데이터가 이행될 경우가 존재하기 때문임.
	   		for(var i = sheetObj.HeaderRows; getValidRowCount(sheetObj) > 0 && i <= sheetObj.LastRow; i++) {
	  	 		//삭제데이터는 체크하지 않는다.
	  	 		if(sheetObj.RowStatus(i) == "D") {
	  	 			continue;
	  	 		}
	  	 		
	   			if(!checkMandatoryValidation(sheetObj, i)) {
	   				return false;
	   			}
	   		}
   			
   			if (sheetObj.IsDataModified ) {
				
				for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		 			if(sheetObj.CellValue(i, "bkg_vvd_cd") != ""  && sheetObj.CellValue(i, "bkg_vvd_cd").length != 9 && sheetObj.RowStatus(i) != "D") {
		 				sheetObj.SelectCell(i, "bkg_vvd_cd");
		 				ComShowCodeMessage("PRI01065", "VVD", "9");
		 				return false;
		 			}
		 		}
				
				//중복체크
				if(!validateDupCheck(sheetObj)) {
					 return false;
				}
			}
   			     			
 			break;
 			
   		case IBCOPYROW:
   			/*
   			if(!checkDuration(sheetObj)) {
   				return false;
   			}
   			*/
   			if(sheetObj.RowCount > 0) {
   				//mandatory check
 				if(!checkMandatoryValidation(sheetObj, sheetObj.SelectRow)) {
 					return false;
 				}
 				
   			}
   			
 			break;
 			
   		case IBINSERT:
   			if(sheetObj.RowCount > 0) {
   				//mandatory check
 				if(!checkMandatoryValidation(sheetObj, sheetObj.SelectRow)) {
 					return false;
 				}
 				
   			}
 			break;	  			
 	
 		case COMMAND01:
 			var iCheckRow = sheetObj.FindCheckedRow("chk");
 			
 			if(iCheckRow == "") {
 				ComShowCodeMessage("PRI00327");
 				return false;
 			}
 							
 			break;
 			
 		case COMMAND02:
 							
 			break;
 		
 		
 			
 		}

 		return true;
 	}

 	/**
 	 * SHEET ROW 중복체크를 하는 FUNCTION <br>
 	 * 모든 항목이 같고 EFF_DT와 EXP_DT가 중첩이 발생할경우에 중복체크를 한다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * validateDupCheck(sheetObj)
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @return boolean
 	 * @author 최성민
 	 * @version 2009.05.20
 	 */ 
 	function validateDupCheck(sheetObj) {
 			
 		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|chg_rule_tp_cd|rule_appl_chg_tp_cd|rule_appl_chg_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
 		 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_scg_grp_cmdt_cd|bkg_usa_svc_mod_cd|bkg_por_def_cd|bkg_pol_def_cd|bkg_org_trsp_mod_cd" +
 		 		"|bkg_pod_def_cd|bkg_dest_trsp_mod_cd|bkg_del_def_cd|bkg_rcv_term_cd|bkg_de_term_cd" +
 		 		"|bkg_slan_cd|bkg_vvd_cd|bkg_soc_flg|bkg_act_cust_def_cd|bkg_dir_call_flg|bkg_mst_hbl_tp_cd|gen_spcl_rt_tp_cd|bkg_ts_port_def_cd" +
 		 		"|bkg_por_tp_cd|bkg_pol_tp_cd|bkg_pod_tp_cd|bkg_del_tp_cd|bkg_esvc_tp_cd|bkg_io_ga_cd|bkg_cnl_tz_cd|pay_term_cd|rt_patt_tp_cd|ign_trf_flg", false, true);
 		
 		if (rowM != "") {
 			// ColValueDupRows(ColList, false, true) 함수는 "중복되는 기준 Row List|중복발상기준 Row List" 형식으로 값이 반환되므로 
 			// "|" 문자를 기준으로 split 하여 0 은 Key List 로 , 1 은 비고 대상 List 로 한다.  
 			var rowDupKeyList = rowM.split("|");
 			
 			// var rowDup = rowM.replace("|", ","); 			
 			// 중복되는 모든ROW
 			// var rowArr = rowDup.split(",");
 			var rowArr = rowDupKeyList[0].split(",");
 			var rowObj = rowDupKeyList[1].split(",");
 			var dupValue = "";
 			var temValue = "";						
 			var firstEffDt = "";
 			var firstExpDt = "";						
 			var SecondEffDt = "";
 			var SecondExpDt = "";
 			var hrows = sheetObj.HeaderRows;
 			
 			for(var i=0; i<rowArr.length; i++) {
 				dupValue  = sheetObj.CellValue(rowArr[i], "chg_rule_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "chg_rule_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "rule_appl_chg_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "rule_appl_chg_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_rat_ut_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_imdg_clss_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_cmdt_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_scg_grp_cmdt_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_usa_svc_mod_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_por_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pol_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_org_trsp_mod_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pod_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_dest_trsp_mod_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_del_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_rcv_term_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_de_term_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_slan_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_vvd_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_soc_flg");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_act_cust_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_dir_call_flg");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_mst_hbl_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "gen_spcl_rt_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_ts_port_def_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_por_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pol_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_pod_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_del_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_esvc_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_io_ga_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_cnl_tz_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "pay_term_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "rt_patt_tp_cd");
 				dupValue += "\t" + sheetObj.CellValue(rowArr[i], "ign_trf_flg");
 				
 				for(var j=0; j<rowObj.length; j++) {
 					temValue  = sheetObj.CellValue(rowObj[j], "chg_rule_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "chg_rule_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "rule_appl_chg_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "rule_appl_chg_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_rat_ut_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_prc_cgo_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_imdg_clss_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_cmdt_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_scg_grp_cmdt_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_usa_svc_mod_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_por_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pol_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_org_trsp_mod_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pod_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_dest_trsp_mod_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_del_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_rcv_term_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_de_term_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_slan_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_vvd_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_soc_flg");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_act_cust_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_dir_call_flg");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_mst_hbl_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "gen_spcl_rt_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_ts_port_def_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_por_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pol_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_pod_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_del_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_esvc_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_io_ga_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_cnl_tz_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "pay_term_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "rt_patt_tp_cd");
 					temValue += "\t" + sheetObj.CellValue(rowObj[j], "ign_trf_flg");
 					
 					//if(i != j) {
	 					if(dupValue == temValue) {
	 						firstEffDt = sheetObj.CellValue(rowArr[i], "eff_dt");
	 						firstExpDt = sheetObj.CellValue(rowArr[i], "exp_dt");
	 						
	 						SecondEffDt = sheetObj.CellValue(rowObj[j], "eff_dt");
	 						SecondExpDt = sheetObj.CellValue(rowObj[j], "exp_dt");
	 						
	 						if(firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
	 							ComShowCodeMessage("PRI00303", "Sheet", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
	 						     return false;
	 			 			}
	 			 			
	 			 			if(firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
	 			 				ComShowCodeMessage("PRI00303", "Sheet", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
	 						     return false;
	 			 			}
	 					} //if
 					//} //if
 				} //for
 				
 			} //for
 			
 		} //if
 		
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
		var formObj 	= document.form;
		var sLgcyIfFlg 	= formObj.lgcy_if_flg.value;
		
		if (errMsg == "") {
			
			openSheet1YN = true; 
			if(!runSheet1YN) {
				sheetObj.SelectCell(formObj.master_seq.value, 1);
			}
			
			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				if(sheetObj.CellValue(i,"amdt_seq") > 0) {
					if(sheetObj.CellValue(i,"src_info_cd") == 'AD' && sLgcyIfFlg != "Y") {
						sheetObj.CellFont("FontStrikethru", i, "seq", i, sheetObj.LastCol)=true;
						sheetObj.CellFont("FontColor", i, "seq", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
					} else if((sheetObj.CellValue(i,"src_info_cd") == 'AM' || sheetObj.CellValue(i,"src_info_cd") == 'NW') && sLgcyIfFlg != "Y") {
						sheetObj.CellFont("FontColor", i, "seq", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
					}
				}			
			}

			//하이라이트 처리
			changeSelectBackColor4Master(sheetObj, document.form);
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
   		var formObj 	= document.form;
   		var sAmdtSeq 	= formObj.amdt_seq.value;
		var sLgcyIfFlg 	= formObj.lgcy_if_flg.value;
   		
   		if (errMsg == "") {
   			
   			//AMEND처리된 이전 SEQ는 HIDDEN처리한다.
			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				if(sheetObj.CellValue(i, "amdt_seq") != sAmdtSeq) {
					sheetObj.CellFont("FontStrikethru", i, "seq", i, sheetObj.LastCol)=true;
				}
				
				if(formObj.amdt_seq.value > 0 && sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == sAmdtSeq && sLgcyIfFlg != "Y") {
					sheetObj.CellFont("FontColor", i, "seq", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
				}
				
				if (sheetObj.RowHidden(i)){
					sheetObj.RowHidden(i) = true;
				}
			}
					
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
	 		var formObj 	= document.form;
	 		var amdtSeq 	= formObj.amdt_seq.value;
	 		var propStsCd 	= formObj.prop_sts_cd.value;
	 		var convCfmFlg 	= formObj.conv_cfm_flg.value;
	 		var ofcAuthYn 	= formObj.ofc_auth_yn.value;
	        var reqUsrFlg = formObj.req_usr_flg.value;

	 		var currAmdtSeq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq");
	 		var currSrcInfoCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "src_info_cd");
	 		
	 		// C/TYPE SET
			comboObjects[0].Code2 = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_chg_tp_cd");
						
			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				//if(convCfmFlg == "Y" && propStsCd != "I" && ofcAuthYn == "Y" && currAmdtSeq == amdtSeq && currSrcInfoCd != "AD") {
			    if(convCfmFlg == "Y" &&  ( ofcAuthYn == "Y" || reqUsrFlg == "Y" ) && currAmdtSeq == amdtSeq && currSrcInfoCd != "AD") {
					disableColumnValidation(sheetObj, i, "chg_rule_def_cd", sheetObj.CellValue(i,"chg_rule_def_cd"));
				} else {
					sheetObj.RowEditable(i) = false;
				}
				
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
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "RAC" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "ADD" && chgRuleDefCd != "FAR" && chgRuleDefCd != "FAD") {//[CHM-201325096]FAR, FAD 추가		
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
 		} else if(chgRuleDefCd == "ADD" && chgRuleTpCd == "C") {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
 		} else {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = sCodeColor;
 		} 
 	}
 	 
 	 
 	 /**
      * OnClick 이벤트 발생시 호출되는 function <br>
      * 달력 DIV를 호출한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
      * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
      * @return 없음
      * @author 최성민
      * @version 2009.06.18
      */
      function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
  	    var colname = sheetObj.ColSaveName(Col);
  	    var formObj = document.form;
  	    var pinkColor = sheetObj.RgbColor(255,192,203);
  	    
       	switch(colname)
       	{
   	    	case "eff_dt":
   	    		cal = new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
   	    		break;
   	    	case "exp_dt":
   	    		cal = new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
   	    		break;
   	    		
   	    	case "bkg_cmdt_def_cd":
   	    		var sUrl = "/hanjin/ESM_PRI_4027.do?";
   	   	    		sUrl += "commodity_cmd=CG";
   	   	    		sUrl += "&grp_cd="+PRI_SP_SCP;
   	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
   	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
   	   	    	
   	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
   	  			if (rtnVal != null){
   	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;	
   	  				//6자리일경우 COMMODITY CODE임
   	  				sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") = rtnVal.tp;
   	  			}
   	  			break;
   	  			
   	    	case "bkg_por_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "bkg_por_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "bkg_por_tp_cd") = rtnVal.tp;
 	  				
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_por_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"bkg_por_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   	    	case "bkg_pol_def_cd":
 	  			var sUrl = "/hanjin/ESM_PRI_4026.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "bkg_pol_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "bkg_pol_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_pol_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   	    	case "bkg_pod_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "bkg_pod_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "bkg_pod_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_pod_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   	    	case "bkg_del_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "bkg_del_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "bkg_del_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "bkg_del_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"bkg_del_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   		
   	    	case "conv_cmdt_def_cd":
   	    		var sUrl = "/hanjin/ESM_PRI_4027.do?"
   	   	    		sUrl += "commodity_cmd=CG";
   	   	    		sUrl += "&grp_cd="+PRI_SP_SCP;
   	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
   	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
   	   	    		
	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;	
	  				//6자리일경우 COMMODITY CODE임
	  				sheetObj.CellValue2(Row, "conv_cmdt_tp_cd") = rtnVal.tp;
	  			}
   	  			break;
   	  			
   	    	case "conv_org_loc_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "conv_org_loc_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "conv_org_loc_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "conv_org_loc_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = 0;
 	  				}
 	  			} 	  			
   				break;
   				
   	    	case "conv_org_via_loc_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "conv_org_via_loc_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "conv_org_via_loc_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "conv_org_via_loc_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = 0;
 	  				}
 	  			} 
   				break;
   				
   	    	case "conv_dest_via_loc_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "conv_dest_via_loc_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "conv_dest_via_loc_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "conv_dest_via_loc_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   	    	case "conv_dest_loc_def_cd":	
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
 	  			sUrl += "&group_cmd=" + PRI_SP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "conv_dest_loc_def_cd") = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, "conv_dest_loc_tp_cd") = rtnVal.tp;
 	  				//State 일경우 배경에 분홍처리
 	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.CellValue2(Row, "conv_dest_loc_cnt_cd") = rtnVal.cnt_cd;
 	  					sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = pinkColor;
 	  				} else {
 	  					sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = 0;
 	  				}
 	  			}
   				break;
   				
   	    	case "bkg_ts_port_def_cd":	
   				var sUrl = "/hanjin/ESM_PRI_4026.do?";
   				var sParam = "&location_cmd=L";
   					
   				var rtnVal = ComPriOpenWindowCenter(sUrl+sParam, "ESM_PRI_4026", 700, 325, true);
   				if (rtnVal != null){
   					sheetObj.CellValue2(Row, Col) = rtnVal.cd;
   					sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = rtnVal.tp;			
   				}
   				break;	
   				
   	    	case "bkg_slan_cd":	
   				var sUrl = "/hanjin/ESM_PRI_4012.do?"; //  + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;

   				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4012", 415, 340, true);
   				if (rtnVal != null){
   					sheetObj.CellValue2(Row, Col) = rtnVal.toString();
   				}
   				break;		
   				
   	    	case "bkg_vvd_cd":	
   				var sUrl = "/hanjin/ESM_PRI_4013.do?"; // + FormQueryString(document.form);
   	    		sUrl += "prop_no="+formObj.prop_no.value;
   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
   					
   				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4013", 415, 340, true);
   				if (rtnVal != null){
   					sheetObj.CellValue2(Row, Col) = rtnVal.toString();
   					sheetObj.SelectCell(Row, Col);
   				}
   				break;	
   			
   	    	case "bkg_act_cust_def_cd":
   	    		var cust_cnt_cd = "";
   	    		var cust_seq = "";
   	    		if(sheetObj.CellValue(Row, Col).length > 2 && sheetObj.CellValue(Row, Col).length <= 8) {
   	    			cust_cnt_cd = sheetObj.CellValue(Row, Col).substring(0,2);
   	    			cust_seq = sheetObj.CellValue(Row, Col).substring(2,8);
   	    		}
 	  	  		var sUrl = "/hanjin/ESM_PRI_4014.do?is_popup=true&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4014", 640, 480, true);
 	  			
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, Col) = rtnVal.custCntCd + ComLpad(rtnVal.custSeq, 6, "0");
 	  				sheetObj.CellValue2(Row, "bkg_act_cust_cnt_cd") = rtnVal.custCntCd;
 	  				sheetObj.CellValue2(Row, "bkg_act_cust_seq") 	= rtnVal.custSeq;
 	  			}
   	    		break;
    
       	}    	 

      }   
      
      
      /**
      * OnSaveEnd 이벤트 발생시 호출되는 function <br>
      * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
      * @return 없음
      * @author 최성민
      * @version 2009.04.17
      */ 		
      function sheet3_OnSaveEnd(sheetObj, ErrMsg)  {
		  //현재 저장된 C/TYPE 을 SHEET1에  임시로 저장한다. - ROW이동시에 데이터를 가지고 있어야하기 때문
		  sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "note_chg_tp_cd") = comboObjects[0].Code;
      }
      
      /**
       * CODE항목 선택시 CODE값에 따라 수정가능한 항목을 체크하는 function <br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	disableColumnValidation(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
       * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
       * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
       * @return 없음
       * @author 최성민
       * @version 2009.07.02
       */           
      function disableColumnValidation(sheetObj, Row, Col, Value) {
    	
    	initColumnEditable(sheetObj, Row, Col, Value);
    	
 		switch(Value)
     	{
     	    case "FAR":
     	    case "FAD":
     		case "APP":	
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
     			sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= false;
     			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
     			sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= false;
     			sheetObj.CellEditable(Row, "bkg_scg_grp_cmdt_cd") 		= false;
     			sheetObj.CellEditable(Row, "bkg_usa_svc_mod_cd") 		= false;
     			sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_org_trsp_mod_cd") 		= false;
				sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_dest_trsp_mod_cd") 		= false;
				sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_rcv_term_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_de_term_cd") 			= false;
				sheetObj.CellEditable(Row, "bkg_io_ga_cd") 				= false;
								
				sheetObj.CellEditable(Row, "gen_spcl_rt_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;				
				var bEdit = false;
				if ( Value == "APP" ) bEdit = true;
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= bEdit;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
				break;
				
		   
				
     		case "NOT":	
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
     			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
				
				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= false;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
			break;
					
     		case "RAS":	
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
     			sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
     			sheetObj.CellEditable(Row, "curr_cd") 					= false;
     			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
     			sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
     			sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= true;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
				break;
					
 			case "ARB":	
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
 				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= false;
 			 				
				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
				
				if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
		    		
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
					sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
				}				
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= false;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
 				break;
 				
 			case "ADD":
 				if(sheetObj.CellValue(Row, "chg_rule_tp_cd") == "R") {
	 				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
	 				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
	 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
	 				sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= false;
	 			 				
					sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
					sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
					sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
					sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
					sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
					sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
					sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
					sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
					sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
					
					if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
						|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
						|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
			    		
						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
						sheetObj.CellEditable(Row, "curr_cd") 				= false;
						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
					} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
						sheetObj.CellEditable(Row, "curr_cd") 				= false;
					}
 				} else {								
 					sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
 					sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
 					sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
 					sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
 					sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
 					sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
 					sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
 					sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
 					sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
 					sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
 					sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
 					
 			    	if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
 						|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
 						|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
 			    		
 						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 						sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 					} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {					
 						sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
 					} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
 						sheetObj.CellEditable(Row, "curr_cd") 				= false;
 					}
 				}
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= false;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
 				break;
 				
 			case "TYP":
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;							
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= true;
				var bEdit = false;
				if ( sheetObj.CellValue ( Row, "rule_appl_chg_tp_cd") == "S" ) bEdit = true;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= bEdit;
				break;
 				
 			case "RAR":
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
 				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
 				sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= false;
 				
				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= true;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
				break;
 				
 			case "RAP":
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
 				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
 				sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= false;
 				
				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= true;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
				break;
 				
 			case "DOR":
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
 				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
 				sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= false;
 				
				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;				
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= false;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
				break;
 				
 			case "RAC":	
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
 				sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
 				sheetObj.CellEditable(Row, "curr_cd") 					= false;
 				sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
 				sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= false;
 												
 				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= true;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
				break;
 				
 			default:  //SURCHARGE 
				sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;								
				sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
				sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
				sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
				sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
				sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;
				
		    	if(sheetObj.CellValue(Row, "rt_appl_tp_cd")=="S" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="I" 
					|| sheetObj.CellValue(Row, "rt_appl_tp_cd")=="N" ) {
		    		
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
					sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.CellEditable(Row, "curr_cd") 				= false;
				}
				sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= false;
				sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
				break;
     	}
  	}
       
       /**
        * SHEET에 보이는 항목들을 EDITABLE 초기화하는 function <br>
        * 
        * <br><b>Example :</b>
        * <pre>
        *	initColumnEditable(sheetObj, Row, Col, Value);
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
        * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
        * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
        * @return 없음
        * @author 최성민
        * @version 2009.07.02
        */           
       function initColumnEditable(sheetObj, Row, Col, Value) {  
			sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= true;  	   
    	   	sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= true;
	   	   	sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= true;
	   	   	sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= true;
	   	   	sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 	= true;	  	
	   	   	sheetObj.CellEditable(Row, "rule_appl_chg_cd") 		= true;
			if(sheetObj.CellValue(Row, "rule_appl_chg_tp_cd") == "S") {
				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 		= true;
			}else{
				sheetObj.CellEditable(Row, "rule_appl_chg_cd") 		= false;
			}
	   	   	if(sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
	   	   		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd")		= true;
	   	   	} else {
	   	   		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") 		= false;
	   	   	}
			sheetObj.CellEditable(Row, "rt_op_cd") 					= true;
			sheetObj.CellEditable(Row, "curr_cd") 					= true;
			sheetObj.CellEditable(Row, "frt_rt_amt") 				= true;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_scg_grp_cmdt_cd") 		= true;
			sheetObj.CellEditable(Row, "bkg_usa_svc_mod_cd") 		= true;
			sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_org_trsp_mod_cd") 		= true;
			sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_dest_trsp_mod_cd") 		= true;
			sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_rcv_term_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_de_term_cd") 			= true;
			
			sheetObj.CellEditable(Row, "bkg_slan_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_vvd_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_soc_flg") 				= true;
			sheetObj.CellEditable(Row, "bkg_act_cust_def_cd") 		= true;
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 		= true;
			
			if(sheetObj.CellValue(Row, "bkg_ts_port_def_cd") != "") {
				sheetObj.CellEditable(Row, "bkg_dir_call_flg") 		= false;
			} else {
				sheetObj.CellEditable(Row, "bkg_dir_call_flg") 		= true;
			}
			
			if(sheetObj.CellValue(Row, "bkg_dir_call_flg") == "Y") {
				sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 	= false;
			} else {
				sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 	= true;
			}
			
			sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= true;
			
			sheetObj.CellEditable(Row, "gen_spcl_rt_tp_cd") 		= true;
			sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= true;
			sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= true;
			sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= true;
			sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= true;
			sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= true;
			sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= true;
			sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= true;
			sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= true;
			sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= true;

			sheetObj.CellEditable(Row, "bkg_io_ga_cd") 				= true;
			sheetObj.CellEditable(Row, "bkg_cnl_tz_cd") 			= true;
			sheetObj.CellEditable(Row, "bkg_esvc_tp_cd") 			= true;
			sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= true;
			sheetObj.CellEditable(Row, "ign_trf_flg") 				= true;
			
   	}
       
       
       /**
        * SHEET에 보이는 항목들을 EDITABLE FALSE 초기화하는 function <br>
        * 
        * <br><b>Example :</b>
        * <pre>
        *	initColumnEditableFalse(sheetObj, Row, Col, Value);
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
        * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
        * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
        * @return 없음
        * @author 최성민
        * @version 2010.03.03
        */           
       function initColumnEditableFalse(sheetObj, Row, Col, Value) {
           	sheetObj.CellEditable(Row, "chk") 						= false;
           	sheetObj.CellEditable(Row, "chg_rule_tp_cd") 			= false;
           	sheetObj.CellEditable(Row, "chg_rule_def_cd") 			= false;
           	sheetObj.CellEditable(Row, "eff_dt") 					= false;
           	sheetObj.CellEditable(Row, "exp_dt") 					= false;
    	   	sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
	   	   	sheetObj.CellEditable(Row, "bkg_rat_ut_cd") 			= false;
	   	   	sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= false;
	   	   	sheetObj.CellEditable(Row, "rule_appl_chg_tp_cd") 		= false;	
	   	   	sheetObj.CellEditable(Row, "bkg_imdg_clss_cd")			= false;
			sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
			
			sheetObj.CellEditable(Row, "curr_cd") 					= false;
			sheetObj.CellEditable(Row, "frt_rt_amt") 				= false;
			sheetObj.CellEditable(Row, "pay_term_cd") 				= false;
			sheetObj.CellEditable(Row, "bkg_cmdt_def_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_scg_grp_cmdt_cd") 		= false;
			sheetObj.CellEditable(Row, "bkg_usa_svc_mod_cd") 		= false;
			sheetObj.CellEditable(Row, "bkg_por_def_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_org_trsp_mod_cd") 		= false;
			sheetObj.CellEditable(Row, "bkg_pol_def_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_pod_def_cd") 			= false;
			
			sheetObj.CellEditable(Row, "bkg_dest_trsp_mod_cd") 		= false;
			sheetObj.CellEditable(Row, "bkg_del_def_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_rcv_term_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_de_term_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_slan_cd") 				= false;
			sheetObj.CellEditable(Row, "bkg_vvd_cd") 				= false;
			sheetObj.CellEditable(Row, "bkg_soc_flg") 				= false;
			sheetObj.CellEditable(Row, "bkg_act_cust_def_cd") 		= false;
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 		= false;
			sheetObj.CellEditable(Row, "bkg_dir_call_flg") 			= false;
			
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") 		= false;
			sheetObj.CellEditable(Row, "bkg_mst_hbl_tp_cd") 		= false;
			sheetObj.CellEditable(Row, "gen_spcl_rt_tp_cd") 		= false;
			sheetObj.CellEditable(Row, "conv_rat_ut_cd") 			= false;
			sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 		= false;
			sheetObj.CellEditable(Row, "conv_cmdt_def_cd") 			= false;
			sheetObj.CellEditable(Row, "conv_org_loc_def_cd") 		= false;
			sheetObj.CellEditable(Row, "conv_org_via_loc_def_cd") 	= false;
			sheetObj.CellEditable(Row, "conv_dest_via_loc_def_cd")	= false;
			sheetObj.CellEditable(Row, "conv_dest_loc_def_cd") 		= false;
			
			sheetObj.CellEditable(Row, "conv_prc_rcv_term_cd") 		= false;
			sheetObj.CellEditable(Row, "conv_prc_de_term_cd") 		= false;	

			sheetObj.CellEditable(Row, "bkg_io_ga_cd") 				= false;
			sheetObj.CellEditable(Row, "bkg_cnl_tz_cd") 			= false;
			sheetObj.CellEditable(Row, "bkg_esvc_tp_cd") 			= false;
			sheetObj.CellEditable(Row, "rule_appl_chg_cd") 			= false;
			sheetObj.CellEditable(Row, "rt_patt_tp_cd") 			= false;
			sheetObj.CellEditable(Row, "ign_trf_flg") 				= false;
   	}       

    /**
     * CODE항목 선택시 CODE TYPE에 따라 필수 컬럼을 체크하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	checkMandatoryValidation(sheetObj, Row);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @return 없음
     * @author 최성민
     * @version 2009.07.02
     */ 	
  	function checkMandatoryValidation(sheetObj, Row) {
  		var rowCount = sheetObj.RowCount; 		
  		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
  		var chgRuleTpCd = sheetObj.CellValue(Row, "chg_rule_tp_cd");
		 		
  		if(chgRuleTpCd == "" && chgRuleDefCd != "") {
  			ComShowCodeMessage("PRI00316","Code Type");
			sheetObj.SelectCell(Row, "chg_rule_tp_cd");
			return false;
  		}
  		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "RAC" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "ADD" && chgRuleDefCd != "FAR" && chgRuleDefCd != "FAD") { //[CHM-201325096]FAR, FAD 추가
 			
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
 				//Application 이 Fixed Amount, Adjust 로 지정될 경우는 Amount 가 필수입력항목 지정.(7/21)
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "") { 			
	 			// SURCHARGE CODE 입력시, APPLICATION이 FIXED AMOUNT 또는 ADJUST 일 경우
	 			// BKG SOURCE부분의 PER를 필수 입력 항목 변경 요청 - 2009.11.09
				if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
 			} 		
 		} else if (chgRuleDefCd == "APP" || chgRuleDefCd == "FAR" || chgRuleDefCd == "FAD") { //[CHM-201325096]FAR, FAD 추가
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} 
 		} else if (chgRuleDefCd == "NOT") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}		
 		} else if (chgRuleDefCd == "RAS") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			}
 			// RAS Code 일때 Amount 0 입력 가능하게 변경
// 			else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001) {
// 				ComShowCodeMessage("PRI00316","Amount");
// 				sheetObj.SelectCell(Row, "frt_rt_amt");
// 				return false;
// 			} 
 		} else if (chgRuleDefCd == "ARB") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "ADD" && chgRuleTpCd == "R") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "ADD" && chgRuleTpCd == "C") {

 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
 				//Application 이 Fixed Amount, Adjust 로 지정될 경우는 Amount 가 필수입력항목 지정.(7/21)
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "") { 			
	 			// SURCHARGE CODE 입력시, APPLICATION이 FIXED AMOUNT 또는 ADJUST 일 경우
	 			// BKG SOURCE부분의 PER를 필수 입력 항목 변경 요청 - 2009.11.09
				if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
 			}
 		} else if (chgRuleDefCd == "TYP") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "") {
 				ComShowCodeMessage("PRI00316","Per");
 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rule_appl_chg_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Type");
 				sheetObj.SelectCell(Row, "rule_appl_chg_tp_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "conv_rat_ut_cd") == "") { 
 				ComShowCodeMessage("PRI00316","Per (in S/C)"); 
 				sheetObj.SelectCell(Row, "conv_rat_ut_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAR") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_por_def_cd") == "" && sheetObj.CellValue(Row, "bkg_pol_def_cd") == "" 
 				 && sheetObj.CellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.CellValue(Row, "bkg_del_def_cd") == "") {
 				//POR, POL,POD,DEL중 1개이상 입력 				 				
 				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
 				sheetObj.SelectCell(Row, "bkg_por_def_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "conv_org_loc_def_cd") == "" && sheetObj.CellValue(Row, "conv_org_via_loc_def_cd") == "" 
 				 && sheetObj.CellValue(Row, "conv_dest_via_loc_def_cd") == "" && sheetObj.CellValue(Row, "conv_dest_loc_def_cd") == "") {
 				//Origin , Origin Via,Dest Via, Dest 중  1개이상 입력 				 				
 				ComShowCodeMessage("PRI01052","Origin, Origin Via, Dest Via, Dest");
 				sheetObj.SelectCell(Row, "conv_org_loc_def_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAP") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_cmdt_def_cd") == "" && sheetObj.CellValue(Row, "bkg_scg_grp_cmdt_cd") == "") {
 				ComShowCodeMessage("PRI00334","Commodity","GRI Commodity");
 				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "conv_cmdt_def_cd") == "") {
 				ComShowCodeMessage("PRI00316","Commodity (in S/C)");
 				sheetObj.SelectCell(Row, "conv_cmdt_def_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "DOR") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_rcv_term_cd") == "" && sheetObj.CellValue(Row, "bkg_de_term_cd") == "") {
 				ComShowCodeMessage("PRI00334","Receiving Term","Delivery Term");
 				sheetObj.SelectCell(Row, "bkg_rcv_term_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "conv_prc_rcv_term_cd") == "" && sheetObj.CellValue(Row, "conv_prc_de_term_cd") == "") {
 				ComShowCodeMessage("PRI00334","Receiving Term (in S/C)","Delivery Term (in S/C)");
 				sheetObj.SelectCell(Row, "conv_prc_rcv_term_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAC") {
 			if(sheetObj.CellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cargo Type");
 				sheetObj.SelectCell(Row, "bkg_prc_cgo_tp_cd");
 				return false;
 			} else if(sheetObj.CellValue(Row, "conv_prc_cgo_tp_cd") == "") { 
 				ComShowCodeMessage("PRI00316","Cargo Type (in S/C)"); 
 				sheetObj.SelectCell(Row, "conv_prc_cgo_tp_cd");
 				return false;
 			}
 		}

 		return true;
  	}
  	
     /**
      * CODE항목 선택시 CODE TYPE에 따라 컬럼항목 DEFAULT 처리하는 function <br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *	defaultColumnValidation(sheetObj, Row, Col, Value);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
      * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
      * @return 없음
      * @author 최성민
      * @version 2009.07.02
      */ 	
  	function defaultColumnValidation(sheetObj, Row, Col, Value) {
 	 	
    	initColumnValue(sheetObj, Row);
    	  
 		switch(Value)
     	{	
 			case "TYP":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "bkg_rat_ut_cd") 		= "D4";
 				sheetObj.CellValue2(Row, "conv_rat_ut_cd") 		= "D4";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";	
 				sheetObj.CellValue2(Row, "rule_appl_chg_tp_cd")	= "O";
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "A";
 				break;
 				
 			case "NOT":
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "I";			
 				break;
 			
 			case "RAS":
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";	
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";	
 				break;
 				
 			case "RAR":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				break;
 				
 			case "RAP":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				break;
 				
 			case "DOR":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				break;
 				
 			case "ARB":
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
 				break;
 				
 			case "FAR":
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
 				break;
 				
 			case "FAD":
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
 				break;
 				
 			case "ADD":
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
 				break;
 			
 			case "RAC":
 				sheetObj.CellValue2(Row, "curr_cd") 			= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
 				sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
 				break;
 				
 			default:
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 		= "S";
 				break;
 				
     	}
  	}
      
  /**
   * 데이터를 초기화하는 function <br>
   * 
   * <br><b>Example :</b>
   * <pre>
   *	initColumnValue(sheetObj, Row);
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
   * @return 없음
   * @author 최성민
   * @version 2009.07.02
   */ 	
   	function initColumnValue(sheetObj, Row) {
  	 		
     	  sheetObj.CellValue2(Row, "rule_appl_chg_tp_cd") 			= "";
	 	  sheetObj.CellValue2(Row, "rule_appl_chg_cd") 				= "";
     	  sheetObj.CellValue2(Row, "rt_appl_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "rt_op_cd") 						= "";
     	  sheetObj.CellValue2(Row, "curr_cd") 						= "";
     	  sheetObj.CellValue2(Row, "frt_rt_amt") 					= "";
     	  sheetObj.CellValue2(Row, "pay_term_cd") 					= "";
     	  sheetObj.CellValue2(Row, "gen_spcl_rt_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_rat_ut_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_cmdt_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_cmdt_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_scg_grp_cmdt_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_usa_svc_mod_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_por_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_por_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_pol_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_pol_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_pod_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_pod_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_del_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_del_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_org_trsp_mod_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_dest_trsp_mod_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_rcv_term_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_de_term_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_slan_cd") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_vsl_cd") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_skd_voy_no") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_skd_dir_cd") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_soc_flg") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_act_cust_cnt_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_act_cust_seq") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") 			= "";
     	  sheetObj.CellValue2(Row, "bkg_dir_call_flg") 				= "";
     	  sheetObj.CellValue2(Row, "bkg_mst_hbl_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "conv_rat_ut_cd") 				= "";
     	  sheetObj.CellValue2(Row, "conv_prc_cgo_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "conv_cmdt_tp_cd") 				= "";
     	  sheetObj.CellValue2(Row, "conv_cmdt_def_cd") 				= "";
     	  sheetObj.CellValue2(Row, "conv_org_loc_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "conv_org_loc_def_cd") 			= "";
     	  sheetObj.CellValue2(Row, "conv_org_via_loc_tp_cd") 		= "";
     	  sheetObj.CellValue2(Row, "conv_org_via_loc_def_cd") 		= "";
     	  sheetObj.CellValue2(Row, "conv_dest_via_loc_tp_cd") 		= "";
     	  sheetObj.CellValue2(Row, "conv_dest_via_loc_def_cd") 		= "";
     	  sheetObj.CellValue2(Row, "conv_dest_loc_tp_cd") 			= "";
     	  sheetObj.CellValue2(Row, "conv_dest_loc_def_cd") 			= "";
     	  sheetObj.CellValue2(Row, "conv_prc_rcv_term_cd") 			= "";
     	  sheetObj.CellValue2(Row, "conv_prc_de_term_cd") 			= "";

     	  sheetObj.CellValue2(Row, "bkg_vvd_cd") 					= "";
     	  sheetObj.CellValue2(Row, "bkg_act_cust_def_cd") 			= "";

	 	  sheetObj.CellValue2(Row, "bkg_io_ga_cd") 					= "";
	 	  sheetObj.CellValue2(Row, "bkg_cnl_tz_cd") 				= "";
	 	  sheetObj.CellValue2(Row, "bkg_esvc_tp_cd") 				= "";
	 	  sheetObj.CellValue2(Row, "rt_patt_tp_cd") 				= "";
	 	  sheetObj.CellValue2(Row, "ign_trf_flg") 					= "";
   	}
  	
    /**
     * SHEET ROW를 멀티 복사하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	copySheetData(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2010.03.23
     */	
 	function copySheetData(sheetObj) {
	    
  		//SHEET를 LOAD한 후에 기본 값을 세팅한다.
  		var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;  
  		var sCheckRow = sheetObj.FindCheckedRow("chk");
		if(sCheckRow == ""){
			sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
		}
		sCheckRow = sheetObj.FindCheckedRow("chk");	
		
 		var aCheckArr = ComRtrim(sCheckRow, '|').split("|");
 		
 		if(aCheckArr != null && aCheckArr.length > 0) {
 			for(var i=aCheckArr.length-1; i>=0; i--) {
 				sheetObj.SelectRow = aCheckArr[i];
 				var idx = sheetObj.DataCopy();
      			sheetObj.CellValue2(idx, "note_conv_seq") 	= maxSeq;      	
      			sheetObj.CellValue2(idx, "chk") = 0;

      			// State 색 구분
      			setStateColor(sheetObj, idx);
      			// Rule & Charge Code 색 구분
      			//setChargeRuleColor(sheetObj, idx);
      			      			
      			maxSeq++;
 			}
 		}
 	}
 	
 	/**
      * CODE COMBO 선택시 CHARGE RULE TYPE에 따라 데이터를 분기하는 function <br>
      * RULE코드를 선택하면 CHG_RULE_TP_CD:C 이고 NOTE_CONV_RULE_CD에 코드값등록  <br>
      * CHARGE코드를 선택하면 CHG_RULE_TP_CD:R 이고 NOTE_CONV_CHG_CD에 코드값등록  <br>
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @return 없음
      * @author 최성민
      * @version 2009.07.02
      */	
 	function insertChargeRuleType(sheetObj, Row) {
 		var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
 		var chgRuleTpCd = 	sheetObj.CellValue(Row, "chg_rule_tp_cd");
 		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "RAC" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "ADD" && chgRuleDefCd != "FAR" && chgRuleDefCd != "FAD") { //[CHM-201325096]FAR, FAD 추가
 			
 			//CHARGE
 			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "C"; 
 			sheetObj.CellValue2(Row, "note_conv_chg_cd") = chgRuleDefCd;
 			sheetObj.CellValue2(Row, "note_conv_rule_cd") = "";
 		} else {
 			//RULE
 			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R"; 
 			sheetObj.CellValue2(Row, "note_conv_rule_cd") = chgRuleDefCd;
 			sheetObj.CellValue2(Row, "note_conv_chg_cd") = "";
 		}
 	}
      
   	 /**
       * proposal 데이터가 이행데이터이면 리턴한다.  <br>
       * <br><b>Example :</b>
       * <pre>
       *	returnCreationTypeCode();
       * </pre>
       * @param 없음
       * @return 없음
       * @author 최성민
       * @version 2009.07.02
       */
      function returnCreationTypeCode() {
    		var formObj = document.form;
     		var prcPropCreTpCd = formObj.prc_prop_cre_tp_cd.value;
     		
     		if(prcPropCreTpCd == "I"){
     			return true;
     		} else {
     			return false;
     		}
      }

	/**
    * 버튼 권한 컨트롤 function <br>
    * 버튼을 제어한다. <br>
    * <br><b>Example :</b>
    * <pre>
    * buttonControl()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 최성민
    * @version 2009.04.17
    */
 	function buttonControl(){
 		var formObj = document.form;
 		var amdtSeq = formObj.amdt_seq.value;
 		var propStsCd = formObj.prop_sts_cd.value;
 		var convCfmFlg = formObj.conv_cfm_flg.value;
 		var ofcAuthYn = formObj.ofc_auth_yn.value;
        var reqUsrFlg = formObj.req_usr_flg.value;

 		//테스트용 - Conversion 입력
		//ofcAuthYn = "Y";
 		//propStsCd = "Q";
		
		try{	
			/* 버튼 활성화되는 조건
			 * 1. History 화면에서 Conversion Check 가 이전Seq 에 체크되어 있는경우
			 * 2. Main 의 Status 코드가 Initial 이 아닌경우
			 * 3. 로그인 유저의 오피스 코드가 'PKGSA,SELCMQ' 인 경우
			 * 4. 선택한 Note Content 의 Row 의 Amdt_Seq 가 현재 Amdt_Seq 일경우
			 * 5. Amend Delete 된 데이터가 아닌경우
			 */
            if( convCfmFlg == "Y" // && propStsCd != "I" 상태와 상관없이 입력
                    && ( ofcAuthYn == "Y" || reqUsrFlg == "Y" )//작성자			
					&& sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq") == amdtSeq 
					&& sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "src_info_cd") != "AD") {
				ComBtnEnable("btn_copy");
				ComBtnEnable("btn_paste");
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowcopy");
				ComBtnEnable("btn_delete");
				ComBtnEnable("btn_save");
			} else {
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_save");
			}
		} catch (e) {}
	}

	/* 개발자 작업  끝 */