/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_05.js
*@FileTitle : S/C Proposal Origin/Destination IHC Charge-Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.22 김재연
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
     * @class ESM_PRI_0003_05 : ESM_PRI_0003_05 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0003_05() {
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
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
	
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
    		
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				buttonControl();
    				break;
	
    			case "btn_save":
    				doActionIBSheet(sheetObject1, formObject, IBSAVE);
    				buttonControl();
    				break;
	
    			case "btn_acceptall":
    				doActionIBSheet(sheetObject1,document.form,MODIFY03);
    				break;
	
    			case "btn_cancelall":
    				doActionIBSheet(sheetObject1,document.form,MODIFY04);
    				break;
	
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    				break;
	
    			case "btn_loadexcel":
    				doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
    				break;

    			case "btn_rowadd":
    				doActionIBSheet(sheetObject1,formObject,IBINSERT);
    				break;
	
    			case "btn_rowcopy":
    				doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
    				break;
	
    			case "btn_delete":
    				doActionIBSheet(sheetObject1,formObject,IBDELETE);
    				break;
	
    			case "btn_amend":
    				doActionIBSheet(sheetObject1,document.form,COMMAND01);
    				break;
	 				
    			case "btn_amendcancel":
    				doActionIBSheet(sheetObject1,document.form,COMMAND02);
    				break;
	 					
    			case "btn_accept":
    				doActionIBSheet(sheetObject1,document.form,MODIFY01);
    				break;
	 				
    			case "btn_acceptcancel":
    				doActionIBSheet(sheetObject1,document.form,MODIFY02);
    				break;
              }
     	} catch(e) {
     		if( e == "[object Error]") {
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
     * @author 김재연
     * @version 2009.05.22
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
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
     * @author 김재연
     * @version 2009.05.22
     */
    function loadPage() {

    	for(i=0;i<sheetObjects.length;i++){
	
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );
	
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	pageOnLoadFinish();
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
     * @author 김재연
     * @version 2009.05.22
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
    	var sheetID = sheetObj.id;

    	switch (sheetID) {
    	
    		case "sheet1":
    			
    			with (sheetObj) {
    				// 높이 설정
    				style.height = 260;
    				// 전체 너비 설정
    				SheetWidth = mainTable.clientWidth;

    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 3, 100);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false, false);

    				var HeadTitle = "state|Sel.|Seq.|Point|Description|Zip Code|Zip Code|Trans Mode|Term|Base Port|Per|Cargo Type|Currency|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|prop_no|amdt_seq||||||||per_type";
    				var headCount = ComCountHeadTitle(HeadTitle);
    				
    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 11, 0, true);
    				
    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
    				// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++, dtHiddenStatus, 	40,   daCenter,  false,		"ibflag");
    				
    				InitDataProperty(0, cnt++, dtDummyCheck,	40,   daCenter,  false,   	"chk");
    				InitDataProperty(0, cnt++, dtDataSeq,    	30,   daCenter,  true,    	"seq");
    				InitDataProperty(0, cnt++, dtPopupEdit,  	60,   daCenter,  false,     "rout_pnt_loc_def_cd",  true,	"",      dfEngUpKey, 	0,     true,	true,	5,	true);
    				InitDataProperty(0, cnt++, dtData,    		80,   daLeft,	 false,    	"rout_pnt_loc_def_nm",  false,  "",      dfNone, 		0,     false,   false);
    				InitDataProperty(0, cnt++, dtData,    		20,   daLeft,	 false,    	"loc_grd_cnt_cd",  		false,  "",      dfEngUpKey, 	0,     true,   	true,	2,	true);
    				InitDataProperty(0, cnt++, dtData,    		60,   daLeft,	 false,    	"loc_grd_cd",  			false,  "",      dfNone, 		0,     true,   	true,	8);
    				InitDataProperty(0, cnt++, dtCombo,      	70,   daCenter,  false,     "prc_trsp_mod_cd",    	false,  "",      dfEngUpKey, 	0,     true,    true);
    				InitDataProperty(0, cnt++, dtCombo,      	50,   daCenter,  false,     "rcv_de_term_cd",       false,  "",      dfEngUpKey, 	0,     true,    true);
    				InitDataProperty(0, cnt++, dtPopupEdit,   	75,   daCenter,  false,     "bse_port_def_cd",     	true,  	"",      dfEngUpKey, 	0,     true,    true,	5);
    				InitDataProperty(0, cnt++, dtCombo,  		40,   daCenter,  false,     "rat_ut_cd",      		true,  	"",      dfNone, 		0,     true,    true);
    				InitDataProperty(0, cnt++, dtCombo,     	90,   daCenter,  false,     "prc_cgo_tp_cd",     	false,  "",      dfNone, 		0,     true,    true);
    				InitDataProperty(0, cnt++, dtCombo,      	70,   daCenter,  false,     "curr_cd",      		true,  	"",      dfNone, 		0,     true,    true);
    				InitDataProperty(0, cnt++, dtData,      	70,   daRight,   false,     "prop_frt_rt_amt",     	true,  	"",      dfFloat,		2,     true,   	true,	9);
    				InitDataProperty(0, cnt++, dtData,      	60,   daCenter,  false,     "coffr_frt_rt_amt",    	false,  "",      dfNullFloat, 	2,     false,   false,	9);
    				InitDataProperty(0, cnt++, dtData,      	70,   daRight,   false,     "fnl_frt_rt_amt",     	false,  "",      dfNullFloat, 	2,     false,   false);
    				InitDataProperty(0, cnt++, dtData,      	80,   daCenter,  false,     "eff_dt",    			false,	"",      dfDateYmd, 	0,     false,   false);
    				InitDataProperty(0, cnt++, dtData,      	80,   daCenter,  false,     "exp_dt",      			false,  "",      dfDateYmd, 	0,     false,   false);
    				InitDataProperty(0, cnt++, dtCombo,     	90,   daCenter,  false,     "src_info_cd",     		false,  "",      dfNone, 		0,     false,   false);
    				InitDataProperty(0, cnt++, dtCombo,  		80,   daCenter,  false,     "prc_prog_sts_cd",      false,  "",      dfNone, 		0,     false,   false);
                     
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"prop_no");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"amdt_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"svc_scp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"add_chg_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"org_dest_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "rout_pnt_loc_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "bse_port_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,    	"add_chg_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "n1st_cmnc_amdt_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "per_type");
    				
    				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

    				InitDataValid(0,  "loc_grd_cnt_cd",			vtEngUpOnly);		// 영문대문자만 입력
    				InitDataValid(0,  "loc_grd_cd",				vtNumericOnly);		// 숫자만 입력
    				InitDataValid(0,  "bse_port_def_cd",		vtEngUpOther, "012456789"); // 영문대문자와 숫자만 입력
    				
    				InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);
    				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
    				InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");
    				InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
    				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
    				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
    				
    				AutoRowHeight = false;
    				WaitImageVisible = false;
    			}
    			break;
    		
    		case "sheet2":

    			with (sheetObj) {
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, "", true);

               }
               break;	
    	}
    }
     
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author 김재연
     * @version 2009.05.22
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName = sheetObj.ColSaveName(Col);
    	var formObj = document.form;
    	var tpCd = "";
    	
 		if (colName == "rout_pnt_loc_def_cd") { //Point
 			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd="+ PRI_SP_SCP +"&location_cmd=L&prop_no="+ formObj.prop_no.value +"&amdt_seq="+ formObj.amdt_seq.value +"&svc_scp_cd="+ formObj.svc_scp_cd.value;
 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 			if (rtnVal != null){
 				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
 				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
 				
 				if (rtnVal.cd.length == 5){ //Location Type을 설정한다
 					tpCd = "L";
 				}
 				sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = tpCd ;
 			}
 		} else if (colName == "bse_port_def_cd") { //Base Point
 			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+ formObj.prop_no.value +"&amdt_seq="+ formObj.amdt_seq.value +"&svc_scp_cd="+ formObj.svc_scp_cd.value;
 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 			if (rtnVal != null  && checkBasePort(sheetObj, Row, rtnVal.cd)){
 				sheetObj.CellValue2(Row, Col) = rtnVal.cd;

 				if(rtnVal.cd.length == 5) { //Location Type을 변경한다
 					tpCd = "L";
 				} else if(rtnVal.cd.length == 4) { //Location Type을 변경한다
 					tpCd = "G";
 				}
 				sheetObj.CellValue2(Row,"bse_port_tp_cd") = tpCd ;
 			}
 		}
    }
    
    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }
     
    /**
	 * sheet1에서 OnChange 이벤트 발생시 호출되는 function <br>
	 * Multi ComboBox 선택 시 Validation 조회 및 Description의 내용을 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	 * @return 없음
	 * @author 김재연
	 * @version 2009.05.22
	 */   
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		var amdt_seq = formObj.amdt_seq.value;
		
		switch(sName) {
			case "rout_pnt_loc_def_cd":
				if(!checkRoutePointLocation(sheetObj, Row, Value)) {
					return;
				}
				checkLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false);
				break;
			
			case "rcv_de_term_cd": //Term
				setTermCode(sheetObj, Row, Value);
				break;
			
			case "bse_port_def_cd":
				if(sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && !checkBasePort(sheetObj, Row, Value)) { //point와 비교
					 return;
				}
				checkLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
 	    		break;
 	    	
			case "rat_ut_cd":
				checkPerType(sheetObj, Row, Value);
				break;
				
			case "prc_cgo_tp_cd":
				checkCargoType(sheetObj, Row, Value);
				break;
			
			case "prop_frt_rt_amt":
//				if(Value < 0) {
//					ComShowMessage("Negative number is inputted. Please check again.");
//				}
				break;
				
			case "coffr_frt_rt_amt":
//				if(Value < 0) {
//					ComShowMessage("Negative number is inputted. Please check again.");
//				}
				if(sheetObj.CellValue(Row, "prop_frt_rt_amt") == Value) {
					ComShowCodeMessage('PRI01044');
					sheetObj.CellValue2(Row, "coffr_frt_rt_amt") = "";
					sheetObj.SelectCell(Row, "coffr_frt_rt_amt");
					return;
				}
				if(ComNullToZero(Value) == 0) {
					sheetObj.CellValue2(Row, "prc_prog_sts_cd") = "I"; //Initial으로 변경
				} else {
					sheetObj.CellValue2(Row, "prc_prog_sts_cd") = "R"; //Return으로 변경
				}
				break;
		}
		
		var propStsCd = formObj.prop_sts_cd.value;
		
		if(amdt_seq == 0 && propStsCd == 'I') {
			if (sheetObj.CellValue(Row, "src_info_cd") == "PC") {
				sheetObj.CellValue2(Row, "src_info_cd") = "PM";
			} else if (sheetObj.CellValue(Row, "src_info_cd") == "GC") {
				sheetObj.CellValue2(Row, "src_info_cd") = "GM";
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
	 * @author 김재연
	 * @version 2009.05.22
	 */
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
		 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
  			var formObj = document.form;
			setSheetDisplay(sheetObj);
// 			setProposalStatusSummary(formObj);
 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
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
     * @author 김재연
     * @version 2009.05.20
     */
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			var formObj = document.form;
			setSheetDisplay(sheetObj);
			setProposalStatusSummary(formObj);
			
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
		}
	}
 	
    /**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.05.22
     */  
    function pageOnLoadFinish() {
    	initControl();
     	buttonControl();
     	parent.loadTabPage();
    }
     
 	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.05.22
	 **/
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "/";
 	
 		//Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	
 	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function obj_click(){
		var sheetObject1 = sheetObjects[0];
		var formObj = document.form;
		
		if (event.srcElement.name == "org_dest_tp_cd") {
			if(sheetObjects[0].IsDataModified) { //변경내역이 있을때
				if(ComShowCodeConfirm('PRI00006')) { //변경내역 저장 여부 확인
					if(!doActionIBSheet(sheetObjects[0], formObj, MODIFY05)) {
						returnRadioButton();
						return;
					}
				} else {
					returnRadioButton();
					return;
				}
			}
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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
     * @author 김재연
     * @version 2009.05.22
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
        try{
    		switch(sAction) {	     	
	     	case IBSEARCH:
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		
	     		formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESM_PRI_0003_05GS.do", FormQueryString(formObj));
				ComOpenWait(false);
	     		break;
	     	
			case IBSEARCH_ASYNC02: // font style 설정
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.getSaveXml("ESM_PRI_0003_05GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;		
		
			case IBSEARCH_ASYNC03:
				formObj.f_cmd.value = SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02138";
				} else {
					formObj.cd.value="CD02139";
				}
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
			
			case IBSEARCH_ASYNC04: //Ori, Dest 데이터 건수 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.getSaveXml("ESM_PRI_0003_05GS.do", FormQueryString(formObj));
				var arrDesc = ComPriXml2Array(sXml, "org_all_cnt|dest_all_cnt");
				if (arrDesc != null && arrDesc.length > 0) {
		 			if(arrDesc[0][0] > 0) {
		 				formObj.org_dest_tp_cd[0].checked = true;
		 				CONFIRM_ORG_GLINE = true;
		 			} else if(arrDesc[0][1] > 0) {
		 				formObj.org_dest_tp_cd[1].checked = true;
		 				CONFIRM_DEST_GLINE = true;
		 			} else {
		 				formObj.org_dest_tp_cd[0].checked = true;
		 			}
				}
				break;
				
	     	case IBSAVE:
	     		ComOpenWait(true);
	     		if(!enableFlag || !validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		
	     		formObj.f_cmd.value = MULTI01;
	     		var sParam = FormQueryString(formObj);
				var sParamSheet1 = sheetObj.GetSaveString();
				sParam = sParamSheet1 + "&" + sParam;
				
				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_05GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
	     		break;
	
			case IBINSERT:	//Row Add
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				
				var amdt_seq = formObj.amdt_seq.value;
				var idx = sheetObj.DataInsert();
				
				sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
				sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
				sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
				sheetObj.CellValue(idx, "add_chg_tp_cd") = formObj.add_chg_tp_cd.value;
				sheetObj.CellValue(idx, "org_dest_tp_cd") = ComGetObjValue(formObj.org_dest_tp_cd);
				sheetObj.CellValue(idx, "add_chg_seq") = parseInt(ComPriGetMax(sheetObj, "add_chg_seq")) + 1;
				sheetObj.CellValue(idx, "exp_dt") = formObj.exp_dt.value;
				sheetObj.CellValue(idx, "src_info_cd") = "NW";
				sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
				
				if(amdt_seq > 0) {
					sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
					changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
				}
				
				sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
				break;
			
			case IBCOPYROW: // Row Copy
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				
				var amdt_seq = formObj.amdt_seq.value;
				var idx = sheetObj.DataCopy();
				if(idx == 0) return false;
				setRowEditable(sheetObj, idx, true, "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt");
				sheetObj.CellValue(idx, "chk") = 0;
				sheetObj.CellValue(idx, "add_chg_seq") = parseInt(ComPriGetMax(sheetObj, "add_chg_seq")) + 1;
				sheetObj.CellValue(idx, "coffr_frt_rt_amt") = "";
				sheetObj.CellValue(idx, "fnl_frt_rt_amt") = "";
				sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
				sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
				sheetObj.CellValue(idx, "src_info_cd") = "NW";	//New
				sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";	//Initial
				
				if(amdt_seq != 0) {
					sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
					changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
				}
				break;
				
			case IBDELETE: // Delete
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
			
				var amdt_seq = formObj.amdt_seq.value;
				if (amdt_seq == "0") {
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length == 0) {
						sheetObj.CellValue2(sheetObj.SelectRow, "chk") = 1;
						if (sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd")!="I"){
							sheetObj.CellValue2(sheetObj.SelectRow, "chk") = 0;
							ComShowCodeMessage("PRI01002");
							return;
						}
					}else{
						for(var i=0;i < chkArr.length;i++){							
							if (sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd")!="I"){
								ComShowCodeMessage("PRI01002");
								return;
							}
						}
					}
					deleteRowCheck(sheetObj, "chk");
				} else {
					var eff_dt = formObj.eff_dt.value;
					var amdt_seq = formObj.amdt_seq.value;
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					
					if(chkArr.length > 0) {
						for(i=0; i<chkArr.length; i++) {
							//현재 Amend 상태의 데이터일 경우 delete 불가하고 amend cancel만  가능하므로 error message 출력
							if(sheetObj.CellValue(chkArr[i],"amdt_seq") != amdt_seq) {
								ComShowCodeMessage("PRI01002");
								return;
							}
							if(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq") == amdt_seq) {
								if(sheetObj.CellValue(chkArr[i],"src_info_cd") == "AM" 
									|| sheetObj.CellValue(chkArr[i],"src_info_cd") == "AD"
									|| sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd") != "I") {
									ComShowCodeMessage("PRI01002");
									return;
								}
							}
						}
						var sRow = 0;
						for(j=0; j<chkArr.length; j++) {
							//현재 입력한 데이터 즉 amend나 new로 입력한 데이터가 아니므로 delete amend에 해당한다
							if(sheetObj.CellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq") != amdt_seq) {
								amendRow(sheetObj, formObj, chkArr[j]+sRow, "D");		
								sRow++; //delete amend하면서 row가 증가함								
							}
						}
						deleteRowCheck(sheetObj, "chk");
					} else {
						if(sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq") != amdt_seq) {
							ComShowCodeMessage("PRI01002");
							return;
						}
						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
							if(sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd") == "AM" 
								|| sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd") == "AD"
								|| sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") !="I") {
								ComShowCodeMessage("PRI01002");
								return;
							}	
						}
						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
							sheetObj.CellValue(sheetObj.SelectRow,"chk") = 1;
							deleteRowCheck(sheetObj,"chk");							
						} else {
							amendRow(sheetObj, formObj, sheetObj.SelectRow, "D");
						}
					}					
				}
				break;			
			
			
//				if(!validateForm(sheetObj,document.form,sAction)) {
//					return false;
//				}
//			
//				var amdt_seq = formObj.amdt_seq.value;
//				if (amdt_seq == "0") {
//					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
//					if(chkArr.length == 0) {
//						sheetObj.CellValue2(sheetObj.SelectRow, "chk") = 1;
//					}
//					deleteRowCheck(sheetObj, "chk");
//				} else {
//					var eff_dt = formObj.eff_dt.value;
//					var amdt_seq = formObj.amdt_seq.value;
//					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
//					
//					if(chkArr.length > 0) {
//						for(i=0; i<chkArr.length; i++) {
//							//현재 Amend 상태의 데이터일 경우 delete 불가하고 amend cancel만  가능하므로 error message 출력
//							if(sheetObj.CellValue(chkArr[i],"amdt_seq") != amdt_seq) {
//								ComShowCodeMessage("PRI01002");
//								return;
//							}
//							if(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq") == amdt_seq) {
//								if(sheetObj.CellValue(chkArr[i],"src_info_cd") == "AM" || sheetObj.CellValue(chkArr[i],"src_info_cd") == "AD") {
//									ComShowCodeMessage("PRI01002");
//									return;
//								}
//							}
//						}
//						var sRow = 0;
//						for(j=0; j<chkArr.length; j++) {
//							//현재 입력한 데이터 즉 amend나 new로 입력한 데이터가 아니므로 delete amend에 해당한다
//							if(sheetObj.CellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq") != amdt_seq) {
//								amendRow(sheetObj, formObj, chkArr[j]+sRow, "D");		
//								sRow++; //delete amend하면서 row가 증가함								
//							}
//						}
//						deleteRowCheck(sheetObj, "chk");
//					} else {
//						if(sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq") != amdt_seq) {
//							ComShowCodeMessage("PRI01002");
//							return;
//						}
//						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
//							if(sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd") == "AM" || sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd") == "AD") { 
//								ComShowCodeMessage("PRI01002");
//								return;
//							}	
//						}
//						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
//							sheetObj.CellValue(sheetObj.SelectRow,"chk") = 1;
//							deleteRowCheck(sheetObj,"chk");							
//						} else {
//							amendRow(sheetObj, formObj, sheetObj.SelectRow, "D");
//						}
//					}					
//				}
//				break;
				
			case MODIFY01:	//Accept
				ComOpenWait(true);
				if(!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				
				formObj.f_cmd.value = MULTI03;
				acceptRows(sheetObjects[0], document.form, "ESM_PRI_0003_05GS.do");
				ComOpenWait(false);
				break;
				
			case MODIFY02:	//Accept Cancel
				ComOpenWait(true);
				if(!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				
				formObj.f_cmd.value = MULTI04;
				acceptCancelRows(sheetObjects[0],document.form,"ESM_PRI_0003_05GS.do");
				ComOpenWait(false);
				break;
				
			case MODIFY03:	//Accept All
				ComOpenWait(true);
				if(!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				
				formObj.f_cmd.value = MULTI05;
				acceptAllRows(sheetObjects[0],document.form,"ESM_PRI_0003_05GS.do");
				ComOpenWait(false);
				break;
				
			case MODIFY04:	//Cancel All
				ComOpenWait(true);
				if(!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				
				formObj.f_cmd.value = MULTI06;
				acceptCancelAllRows(sheetObjects[0], document.form, "ESM_PRI_0003_05GS.do");
				ComOpenWait(false);
				break;
			
			case MODIFY05:
				ComOpenWait(true);	
				if(!enableFlag || !validateForm(sheetObj,formObj,sAction)) {
	     			if(formObj.org_dest_tp_cd[0].checked) {
						formObj.org_dest_tp_cd[1].checked = true;
					} else if(formObj.org_dest_tp_cd[1].checked) {
						formObj.org_dest_tp_cd[0].checked = true;
					}
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		
				var sParamSheet = sheetObj.GetSaveString()+"&f_cmd="+MULTI01;
				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_05GS.do", sParamSheet);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
	     		break;
	     		
			case COMMAND01:	//Amend
				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0) {
					if(chkArr.length > 1) {					
						ComShowCodeMessage("PRI00310");
					} else {
						amendRow(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "M");
					}
				} else { 
					amendRow(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "M");					
				}
				break;
			
			case COMMAND02: // Amend Cancel
				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0) {
					if(chkArr.length > 1) {					
						ComShowCodeMessage("PRI00310");
					} else {
						amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "M");
					}
				} else { 
					amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "M");
				}
				break;					
				
			case IBDOWNEXCEL: //download excel
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "chk|seq");
				break;
			
			case IBLOADEXCEL:      //upload excel
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
		    	var propNO = formObj.prop_no.value;
		    	var amdtSeq = formObj.amdt_seq.value;
		    	var svcScpCd = formObj.svc_scp_cd.value;
		    	var orgDestTpCd = getOrgDestTpCd();
		    	var effDt = formObj.eff_dt.value;
		    	
				var sUrl = "/hanjin/ESM_PRI_0068.do?prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd+"&org_dest_tp_cd="+orgDestTpCd+"&eff_dt="+effDt;
	 			ComPriOpenWindowCenter(sUrl, "ESM_PRI_0068", 900, 405, true);
				break;
    		}        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	if (sAction == IBSEARCH_ASYNC02 || sAction == IBSEARCH_ASYNC03 || sAction == IBSEARCH_ASYNC04
        			|| sAction == IBINSERT || sAction == IBCOPYROW || sAction == IBDELETE
        			|| sAction == COMMAND01 || sAction == COMMAND02 || sAction == IBDOWNEXCEL
        			|| sAction == IBLOADEXCEL ) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
	}
	
	/**
     * 선택한 row 또는 check된 row를 Accpet 처리한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptRows(sheetObjects[0], document.form, "ESM_PRI_0003_04GS.do")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (string) sUrl 필수
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.05.22
     */
 	function acceptRows(sheetObj,formObj,sUrl) {
     	var propStsCd = formObj.prop_sts_cd.value;
 		var effDt = formObj.eff_dt.value;
 		var amdtSeq = formObj.amdt_seq.value;
 		
 		var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");

 		if(chkArr.length == 0) {
 			// 현재 선택된 Row는 이전회차이다.
 			if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") != amdtSeq) {
 				ComShowCodeMessage("PRI00313");
 				return false;
 			}
 			sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
 			chkArr[0] = sheetObj.SelectRow;
 		}
 		
 		for(var i=0; i<chkArr.length; i++) { // check행 중에서 이미 Accept된 항목이 있으면 에러메세지 출력
 			// 이전회차이다. 
 			if(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq") != amdtSeq) {
 				ComShowCodeMessage("PRI00313");
 				comChangeValue(sheetObj, "chk", "0", "chk", "1");
 				return false;
 			}
 			if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd") == "A") {
 				ComShowCodeMessage("PRI01037");
 				comChangeValue(sheetObj, "chk", "0", "chk", "1");
 				return false;
 			}
 		}
 		
 		var trgtArr = ComPriSheetFilterRows(sheetObj, "chk|n1st_cmnc_amdt_seq", "1|"+amdtSeq);
 		
  		if(trgtArr.length == 0) {
  			ComShowCodeMessage("PRI00301");
 			return false;
  		}
  		
  		for(var i=0; i<trgtArr.length; i++) {
  			var prcProgStsCd = sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd");

  			if(prcProgStsCd == "A") { // Accept 제외
  				continue;
  			}
  			if(propStsCd == "Q") { //현재 진행 상태가 Request 일때는 Propsal 금액을 Final에 입력 
  				sheetObj.CellValue2(trgtArr[i], "fnl_frt_rt_amt") = sheetObj.CellValue(trgtArr[i], "prop_frt_rt_amt"); //Sales.Rep의 금액을 승인
  			}
  			if(propStsCd == "R") { //현재 진행 상태가 Return 일때는 Counter Offer 금액을 Final에 입력
  				sheetObj.CellValue2(trgtArr[i], "fnl_frt_rt_amt") = sheetObj.CellValue(trgtArr[i], "coffr_frt_rt_amt"); //Counter Offer의 금액을 승인
  			}
  			sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "A"; //Accept로 변경 
   			///////////Per_type입력
   			if (sheetObj.CellValue(trgtArr[i], "rat_ut_cd")==""){
   				sheetObj.CellValue2(trgtArr[i], "rat_ut_cd") = sheetObj.CellValue(trgtArr[i], "per_type");
   			}   			
  		}

  		var sParam = FormQueryString(formObj);
		var sParamSheet = sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow = sheetObj.TopRow;
			var lastRow = sheetObj.LastRow;
			
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}

		sParam = sParam + "&" + sParamSheet;
		var sXml = sheetObj.GetSaveXml(sUrl, sParam);
		sheetObj.LoadSaveXml(sXml);
		
  		comChangeValue(sheetObj, "chk", "0", "chk", "1");
  		return true;
 	}
	
 	/**
     * 전체 accpet 대상에 대해서 Accpet를 처리한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptAllRows(sheetObjects[0], document.form, "ESM_PRI_0003_04GS.do")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (string) sUrl 필수
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.05.22
     */
 	function acceptAllRows(sheetObj, formObj, sUrl) {
     	var amdtSeq = formObj.amdt_seq.value;
 		var effDt = formObj.eff_dt.value;
 		var propStsCd = formObj.prop_sts_cd.value;
 		
 		var trgtArr = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdtSeq+"|"+amdtSeq);

 		if(trgtArr.length == 0) { // accept 대상에 해당하는 것이 없다.
 			ComShowCodeMessage("PRI00331", "Accept");
			return false;
 		}
 		
 		for(var i=trgtArr.length-1; i>=0; i--) {
 			if(sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") == "A") { //Accept 항목은 제외한다
 				trgtArr.splice(i, 1);
 			}
 		}
 		
 		if(trgtArr.length == 0) { // 이미 모두 accept 되었다
 			ComShowCodeMessage("PRI00329");
			return false;
 		}
 		
 		var rCnt = trgtArr.length;
 		
 		for(var i=0; i<rCnt; i++) {
 			if(propStsCd == "Q") { //현재 진행 상태가 Request 일때는 Propsal 금액을 Final에 입력 
 				sheetObj.CellValue2(trgtArr[i], "fnl_frt_rt_amt") = sheetObj.CellValue(trgtArr[i], "prop_frt_rt_amt"); //Sales.Rep의 금액을 승인
 			}
 			if(propStsCd == "R") { //현재 진행 상태가 Return 일때는 Counter Offer 금액을 Final에 입력
 				sheetObj.CellValue2(trgtArr[i], "fnl_frt_rt_amt") = sheetObj.CellValue(trgtArr[i], "coffr_frt_rt_amt"); //Counter Offer의 금액을 승인
 			}
 			sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "A"; //Accept로 변경 
   			///////////Per_type입력
   			if (sheetObj.CellValue(trgtArr[i], "rat_ut_cd")==""){
   				sheetObj.CellValue2(trgtArr[i], "rat_ut_cd") = sheetObj.CellValue(trgtArr[i], "per_type");
   			}  			
 		}

 		var sParam = FormQueryString(formObj);
		var sParamSheet = sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow = sheetObj.TopRow;
			var lastRow = sheetObj.LastRow;
			
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}

		sParam = sParam + "&" + sParamSheet;
		var sXml = sheetObj.GetSaveXml(sUrl, sParam);
		sheetObj.LoadSaveXml(sXml);
 		return true;
 	}
 	
 	/**
     * 선택한 row 또는 check된 row를 Accpet cancel 처리한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelRows(sheetObjects[0], document.form, "ESM_PRI_0003_04GS.do")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (string) sUrl 필수
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.05.22
     */
  	function acceptCancelRows(sheetObj, formObj, sUrl) {
     	var propStsCd = formObj.prop_sts_cd.value;
  		var effDt = formObj.eff_dt.value;
  		var amdtSeq = formObj.amdt_seq.value;
  		var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");

  		if(chkArr.length == 0) {
  			// 현재 선택된 Row는 이전회차이다.
  			if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") != amdtSeq) {
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
  			sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
  			chkArr[0] = sheetObj.SelectRow;
  		}
  		
  		for(var i=0; i<chkArr.length; i++) { //check행 중에서 Accept상태가 아닌경우가 있으면 에러메세지
  			// 이전회차에 Accept 된 Row 이다.
  			if(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq") != amdtSeq) {
  				sheetObj.CellValue2(chkArr[i], "chk") = "0";
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
  			// Accept 된 행이 아니다. 
  			if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd") != "A") {
				sheetObj.CellValue2(chkArr[i], "chk") = "0";
				ComShowCodeMessage("PRI01038");
				return false;
			}
  		}
  		
  		var trgtArr = ComPriSheetFilterRows(sheetObj, "chk|n1st_cmnc_amdt_seq", "1|"+amdtSeq+"|"+effDt);
  		
		if(trgtArr.length == 0) {
			ComShowCodeMessage("PRI00301");
			return false;
		}
   		
		for(var i=0; i<trgtArr.length; i++) {
  			var prcProgStsCd = sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd");
  			var propFrtRtAmt = sheetObj.CellValue(trgtArr[i], "prop_frt_rt_amt");
  			var cofferFrtRtAmt = sheetObj.CellValue(trgtArr[i], "coffr_frt_rt_amt");
  			var fnlFrtRtAmt = sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt");
  			
  			if(ComNullToZero(cofferFrtRtAmt) == 0) { //Counter Offer 금액이 없을때 Initial 상태로 되돌리고 Final 리셋
  				sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "I"; 
  				sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt") = "";
  			} else { //Counter Offer 금액이 있을때 Return 상태로 되돌리고 Final 리셋
  				sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "R"; 
 				sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt") = "";
  			}
   			///////////Per_type입력
   			if (sheetObj.CellValue(trgtArr[i], "rat_ut_cd")==""){
   				sheetObj.CellValue2(trgtArr[i], "rat_ut_cd") = sheetObj.CellValue(trgtArr[i], "per_type");
   			}   			
  		}

		var sParam = FormQueryString(formObj);
		var sParamSheet = sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow = sheetObj.TopRow;
			var lastRow = sheetObj.LastRow;
			
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}

		sParam = sParam + "&" + sParamSheet;
		var sXml = sheetObj.GetSaveXml(sUrl, sParam);
		sheetObj.LoadSaveXml(sXml);
		
		comChangeValue(sheetObj, "chk", "0", "chk", "1");	
  		return true;
  	}
  	
  	/**
     * 전체 accpet 된 row를 Accpet cancel 처리한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelAllRows(sheetObjects[0], document.form, "ESM_PRI_0003_04GS.do")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (string) sUrl 필수
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.05.22
     */	
  	function acceptCancelAllRows(sheetObj, formObj, sUrl){
  		var amdtSeq = formObj.amdt_seq.value;
  		var effDt = formObj.eff_dt.value;
  		
  		// 체크된 Row는 모두 해제해준다.
  		comChangeValue(sheetObj, "chk", "0");
  		
  		// Accept Cancel 대상 Row 인덱스를 검색한다.
  		var trgtArr = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdtSeq+"|"+amdtSeq);

  		if(trgtArr.length == 0) {
  			ComShowCodeMessage("PRI00330"); //현재 Amdt seq에 해당하는 Row가 없다.
 			return false;
  		}
  		
  		for(var i=trgtArr.length-1; i>=0; i--) {
 			if(sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") != "A") { //Accept 아닌 항목은 제외한다
 				trgtArr.splice(i, 1);
 			}
 		}
 		
 		if(trgtArr.length == 0) { //accept인 데이터가 없다
 			ComShowCodeMessage("PRI00330");
			return false;
 		}
 		
  		for(var i=0; i<trgtArr.length; i++) {
  			var prcProgStsCd = sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd");
  			var propFrtRtAmt = sheetObj.CellValue(trgtArr[i], "prop_frt_rt_amt");
  			var cofferFrtRtAmt = sheetObj.CellValue(trgtArr[i], "coffr_frt_rt_amt");
  			var fnlFrtRtAmt = sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt");

  			if(prcProgStsCd != "A") { // Accept 아닌것은 제외
  				continue;
  			}
  			
  			if(ComNullToZero(cofferFrtRtAmt) == 0) { //Counter Offer 금액이 없을때 Initial 상태로 되돌리고 Final 리셋
  				sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "I"; 
  				sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt") = "";
  			} else { //Counter Offer 금액이 있을때 Return 상태로 되돌리고 Final 리셋
  				sheetObj.CellValue(trgtArr[i], "prc_prog_sts_cd") = "R"; 
 				sheetObj.CellValue(trgtArr[i], "fnl_frt_rt_amt") = "";
  			}
   			///////////Per_type입력
   			if (sheetObj.CellValue(trgtArr[i], "rat_ut_cd")==""){
   				sheetObj.CellValue2(trgtArr[i], "rat_ut_cd") = sheetObj.CellValue(trgtArr[i], "per_type");
   			}   			
  		}

  		var sParam = FormQueryString(formObj);
		var sParamSheet = sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow = sheetObj.TopRow;
			var lastRow = sheetObj.LastRow;
			
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}

		sParam = sParam + "&" + sParamSheet;
		var sXml = sheetObj.GetSaveXml(sUrl, sParam);
		sheetObj.LoadSaveXml(sXml);
 		return true;
  	}
	
  	/**
     * 선택한 row를 amend 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRow(sheetObjects[0], document.form, Row, "M")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (int) sRow 필수 row index
     * @param (string) sAction 필수 amend 인지 delete amend 인지 구분
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.05.22
     */
	function amendRow(sheetObj, formObj, sRow, sAction) {
		var prop_no      = formObj.prop_no.value;
		var amdt_seq 	 = formObj.amdt_seq.value;
		var pre_amdt_seq = formObj.pre_amdt_seq.value;
		var eff_dt 		 = formObj.eff_dt.value;
		var exp_dt 		 = formObj.exp_dt.value;
		var pre_exp_dt 	 = formObj.pre_exp_dt.value;
		var dur_dup_flg	 = formObj.dur_dup_flg.value;
		var sColNames	 = "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|" +
		"bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt"
			
		// Check box 를 이용할 경우 해당 chk 를 제거
		sheetObj.CellValue(sRow,"chk") = 0;

		// delete / modify Amend 중 이미 amend 된 과거 row 는 제외
		if(sheetObj.CellValue(sRow,"amdt_seq") != amdt_seq || sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq") == amdt_seq) {		
			ComShowCodeMessage("PRI01011");		
		 	return false;
		}
		
		// DataCopy/ Insert 기준 row 를 잡기 위해 sRow 설정
		sheetObj.SelectRow = sRow;
		
		var amdRow = sheetObj.DataCopy();	   // 신규 row
		var preRow = amdRow-1;  				   // 기존 row
		
		sheetObj.CellValue2(amdRow,"coffr_frt_rt_amt") = "";
		sheetObj.CellValue2(amdRow,"fnl_frt_rt_amt") = "";
		sheetObj.CellValue2(amdRow,"eff_dt") = eff_dt;
		sheetObj.CellValue2(amdRow,"n1st_cmnc_amdt_seq") = amdt_seq;
		sheetObj.CellValue2(amdRow,"prc_prog_sts_cd") = "I";
//		sheetObj.CellValue2(amdRow,"ibflag") = "U";
		sheetObj.RowStatus(amdRow) = "U";
		if(sAction == "M") { //Amend
			sheetObj.CellValue2(amdRow, "src_info_cd") = "AM";
			sheetObj.CellValue2(amdRow, "prop_frt_rt_amt") = 0; //Proposal Rate는 0원으로 초기화한다.
			setRowEditable(sheetObj, amdRow, true, "chk|"+sColNames); //Amend Row를 수정가능 하게 변경한다.
		} else if(sAction == "D") { //Delete Amend
			sheetObj.CellValue2(amdRow, "src_info_cd") = "AD";
			///////////Per_type입력(콤보에 per_type이 없는 경우
			sheetObj.CellValue2(amdRow, "rat_ut_cd") = sheetObj.CellValue(amdRow, "per_type");		
			setRowEditable(sheetObj, amdRow, true, "chk"); //chk 항목만 edit 가능하게 변경한다.
		}
		
		sheetObj.CellFont("FontColor", amdRow, 1, amdRow, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); //Amend Row 색 변경
		sheetObj.CellFont("FontStrikethru", preRow, 1, preRow, sheetObj.LastCol) = true; //Amend Row 줄긋기
		sheetObj.CellValue2(preRow,"amdt_seq") = pre_amdt_seq;
		if(dur_dup_flg=="Y") {
			sheetObj.CellValue2(preRow,"exp_dt") = pre_exp_dt;        	
		}
//		sheetObj.CellValue2(preRow,"ibflag") = "R";
		sheetObj.RowStatus(preRow) = "R";
		setRowEditable(sheetObj, preRow, false, "chk|"+sColNames);
		
		changeSelectBackColor(sheetObj, sheetObj.CellValue(amdRow, "n1st_cmnc_amdt_seq"), amdt_seq);
		return true;
	}
	
	/**
     * 선택한 row를 amend cancel 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendCancelRow(sheetObjects[0], document.form, Row, "M")
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param (int) sRow 필수 row index
     * @param (string) sAction 필수 amend 인지 delete amend 인지 구분
     * @return boolean
     * 		true  : 정상
     * 		false : 오류
     * @author 김재연
     * @version 2009.05.22
     */
	function amendCancelRow(sheetObj, formObj, sRow, sAction) {
		var eff_dt = formObj.eff_dt.value;
		var exp_dt = formObj.exp_dt.value;
		var pre_amdt_seq = formObj.pre_amdt_seq.value;
		var amdt_seq = formObj.amdt_seq.value;
		var dur_dup_flg  = formObj.dur_dup_flg.value;
		
		sheetObj.CellValue(sRow,"chk")=0;

		// 	A/M/D 동일하게 n1st_cmnc_amdt_seq == amdt_seq 일 경우에만 처리해줌
		if(sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq") != amdt_seq 
				|| (sheetObj.CellValue(sRow,"src_info_cd") != "AD" 
					&& sheetObj.CellValue(sRow,"src_info_cd") != "AM")
				||	sheetObj.CellValue(sRow,"prc_prog_sts_cd")!= "I") {
			ComShowCodeMessage("PRI00313");		
		 	return false;
		}
		
		// DELETE AMEND를 Cancel 할때  GROUP LOCATION 이 유효한지 체크한다.
		if(sheetObj.CellValue(sRow, "src_info_cd") == "AD" && !checkGroupLocationExist(sheetObj, formObj, sRow)) {
			ComShowCodeMessage("PRI01127", "[LOC Group]");
			return false;
		}
		
		var preRow = sRow-1;
		var amdRow = sRow;

		sheetObj.CellFont("FontStrikethru", preRow, 1, preRow, sheetObj.LastCol) = false;
		sheetObj.CellFont("FontItalic", preRow, 1, preRow, sheetObj.LastCol) = false;
		
		sheetObj.CellValue2(preRow,"amdt_seq") = sheetObj.CellValue(amdRow,"amdt_seq");
		sheetObj.CellEditable(preRow, "chk") = true;
		if(dur_dup_flg == "Y") {
			sheetObj.CellValue2(preRow,"exp_dt") = exp_dt;
		}
		///////////////PER_TYPE 코드가  삭제된 경우 per_type  입력
		if (sheetObj.CellValue(preRow, "rat_ut_cd") == ""){
			sheetObj.CellValue2(preRow, "rat_ut_cd") = sheetObj.CellValue(preRow, "per_type") 
		}		
		if(sheetObj.CellSearchValue(amdRow, "amdt_seq") != unescape("%00")) {
			sheetObj.RowStatus(preRow) = "U";
		}
		
		sheetObj.RowDelete(amdRow, false);
		changeSelectBackColor(sheetObj, sheetObj.CellValue(preRow, "n1st_cmnc_amdt_seq"), amdt_seq);
		return true;
	}
	
    /**
     * Group Location 유효한지 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkGroupLocationExist(sheetObj, formObj, sRow)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 처리 대상 form object
     * @param {int} sRow 필수 이벤트가 발생한 해당 셀의 Row Index
     * @return 없음
     * @author 김재연
     * @version 2009.05.18
     */ 
    function checkGroupLocationExist(sheetObj, formObj, sRow) {
     	
    	if(sheetObj.CellValue(sRow, "bse_port_tp_cd") == "G") {
    		formObj.f_cmd.value = SEARCH17;
    		formObj.cd.value = sheetObj.CellValue(sRow, "bse_port_def_cd");
 			
 			var param = "&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
 			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+param); 	  				
 			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 			
 			if(arrData[1] == "") {
 				return false;
 			}
     	}
     	return true;
    }
     
	/**
     * rout_pnt_loc_tp_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkRoutePointLocation(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function checkRoutePointLocation(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if (sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.CellValue(Row, "bse_port_def_cd") == Value) {
			ComShowCodeMessage('PRI01078');
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
			sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "";
			sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
			return false;
		}
		return true;
	}
	
	/**
     * rcv_de_term_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setTermCode(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function setTermCode(sheetObj, Row, Value) {
		if(sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == sheetObj.CellValue(Row, "bse_port_def_cd")) {
			sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
		}
	}
	
	/**
     * bse_port_def_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function checkBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if(sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
			sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	
	/**
     * prc_cgo_tp_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
     function checkPerType(sheetObj, Row, Value) {
 		var validPerClass = "A,F,O,Q,S,P";
         if(sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
         	ComShowCodeMessage("PRI08003");
     		sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
         }
 	}
	
	/**
     * rat_ut_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function checkCargoType(sheetObj, Row, Value) {
		var validPerClass = "A,F,O,Q,S,P";
     	var ratUtCd = sheetObj.CellValue(Row, "rat_ut_cd");
        if (Value == "AK" && ( ComIsNull(ratUtCd) || validPerClass.indexOf(ratUtCd.charAt(0)) < 0 )) {
             ComShowCodeMessage("PRI08003");
             sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
        }
 	}
	
	/**
     * sheet 의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
 	function setSheetDisplay(sheetObj) {
 		var formObj = document.form;
 		var amdtSeq = formObj.amdt_seq.value;
 		var effDt = formObj.eff_dt.value;
 		var propStsCd = formObj.prop_sts_cd.value;
 		var aproUsrFlg = form.apro_usr_flg.value;
 		var lgcyIfFlg = form.lgcy_if_flg.value;
 		var sColNames = "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt";
 		var rCnt = sheetObj.RowCount;
 		
 		if(amdtSeq == 0) {
 			for(var i=1; i<=rCnt; i++) {
 				if(propStsCd == "I") { //Initial
 					if(sheetObj.CellValue(i, "prc_prog_sts_cd") != "I") {
 						sheetObj.RowEditable(i) = false;
 					}else{
 						sheetObj.RowEditable(i) = true;
 					}
 					
 				} else if(propStsCd == "Q") { //Request
 					setRowEditable(sheetObj, i, false, sColNames);
 					if(sheetObj.CellValue(i, "prc_prog_sts_cd") != "A" && aproUsrFlg == "true") { //승인권자 일때만 Counter Offer 금액입력가능
 						sheetObj.CellEditable(i, "coffr_frt_rt_amt") = true;
 					} else {
 						sheetObj.CellEditable(i, "coffr_frt_rt_amt") = false;
 					}	
 				} else if(propStsCd == "R") { //Return
 					sheetObj.RowEditable(i) = false;
 				} else {
 					sheetObj.RowEditable(i) = false;
 				}
 			}
 			return;
 		}
 		
 		for(var i=1 ; i<=rCnt; i++) {
 			if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq) { //이전회차는 줄긋고 전부 Edit불가
 				sheetObj.CellFont("FontStrikethru", i, "chk", i, "prc_prog_sts_cd") = true;
 				//sheetObj.RowEditable(i) = false;
 				setRowEditable(sheetObj, i, false, "chk|"+sColNames);
 				continue;
 			}
 			if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq) { //Amend가 아닌 Row는 Edit 불가, check는 선택가능
 				setRowEditable(sheetObj, i, false, sColNames);
 				continue;
 			}
 			if(lgcyIfFlg != "Y") {
 				sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); //빨간색
 			}
// 			if(sheetObj.CellValue(i, "src_info_cd") == "AD"
// 				&& sheetObj.CellValue(i, "prc_prog_sts_cd")!= "I" ) {
// 				setRowEditable(sheetObj, i, false, sColNames);
// 				alert(1)
// 				continue;
// 			}
	
 			if(sheetObj.CellValue(i, "src_info_cd") == "AD") {
 				setRowEditable(sheetObj, i, false, sColNames);
 				continue;
 			}	
	
 			
 			if(propStsCd == "I") { //Initial
 				if(sheetObj.CellValue(i, "prc_prog_sts_cd") != "I") {
 					sheetObj.RowEditable(i) = false;
 				}else{
 					sheetObj.RowEditable(i) = true;
 				} 				
 				continue;
 			} else if(propStsCd == "Q") { //Request
 				setRowEditable(sheetObj, i, false, sColNames);
 				if(sheetObj.CellValue(i, "prc_prog_sts_cd") != "A" 
 					&& aproUsrFlg == "true"
 					&& sheetObj.CellValue(i, "src_info_cd") != "AD"	) { //승인권자 일때만 Counter Offer 금액입력가능
 					sheetObj.CellEditable(i, "coffr_frt_rt_amt") = true;
 				} else {
 					sheetObj.CellEditable(i, "coffr_frt_rt_amt") = false;
 				}	
 			} else if(propStsCd == "R") { //Return
 				sheetObj.RowEditable(i) = false;
 			} else {
 				sheetObj.RowEditable(i) = false;
 			}
 		}
 	}     
     
//	function setSheetDisplay(sheetObj) {
//		var formObj = document.form;
//		var amdtSeq = formObj.amdt_seq.value;
//		var effDt = formObj.eff_dt.value;
//		var propStsCd = formObj.prop_sts_cd.value;
//		var aproUsrFlg = form.apro_usr_flg.value;
//		var lgcyIfFlg = form.lgcy_if_flg.value;
//		var sColNames = "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt";
//		var rCnt = sheetObj.RowCount;
//		
//		if(amdtSeq == 0) {
//			for(var i=1; i<=rCnt; i++) {
//				if(propStsCd == "I") { //Initial
//					sheetObj.RowEditable(i) = true;
//				} else if(propStsCd == "Q") { //Request
//					setRowEditable(sheetObj, i, false, sColNames);
//					if(sheetObj.CellValue(i, "prc_prog_sts_cd") != "A" && aproUsrFlg == "true") { //승인권자 일때만 Counter Offer 금액입력가능
//						sheetObj.CellEditable(i, "coffr_frt_rt_amt") = true;
//					} else {
//						sheetObj.CellEditable(i, "coffr_frt_rt_amt") = false;
//					}	
//				} else if(propStsCd == "R") { //Return
//					sheetObj.RowEditable(i) = false;
//				} else {
//					sheetObj.RowEditable(i) = false;
//				}
//			}
//			return;
//		}
//		
//		for(var i=1 ; i<=rCnt; i++) {
//			if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq) { //이전회차는 줄긋고 전부 Edit불가
//				sheetObj.CellFont("FontStrikethru", i, "chk", i, "prc_prog_sts_cd") = true;
//				//sheetObj.RowEditable(i) = false;
//				setRowEditable(sheetObj, i, false, "chk|"+sColNames);
//				continue;
//			}
//			if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq) { //Amend가 아닌 Row는 Edit 불가, check는 선택가능
//				setRowEditable(sheetObj, i, false, sColNames);
//				continue;
//			}
//			if(lgcyIfFlg != "Y") {
//				sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); //빨간색
//			}
//			if(sheetObj.CellValue(i, "src_info_cd") == "AD") {
//				setRowEditable(sheetObj, i, false, sColNames);
//				continue;
//			}
//			
//			if(propStsCd == "I") { //Initial
//				continue;
//			} else if(propStsCd == "Q") { //Request
//				setRowEditable(sheetObj, i, false, sColNames);
//				if(sheetObj.CellValue(i, "prc_prog_sts_cd") != "A" && aproUsrFlg == "true") { //승인권자 일때만 Counter Offer 금액입력가능
//					sheetObj.CellEditable(i, "coffr_frt_rt_amt") = true;
//				} else {
//					sheetObj.CellEditable(i, "coffr_frt_rt_amt") = false;
//				}	
//			} else if(propStsCd == "R") { //Return
//				sheetObj.RowEditable(i) = false;
//			} else {
//				sheetObj.RowEditable(i) = false;
//			}
//		}
//	}
	
	/**
     * Row의 특정 column들의 edit 가능 여부를 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setRowEditable(sheetObj, i, false, "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (int) Row 필수 선택한 Row Index
     * @param (boolean) isEdit 필수 edit 가능 여부
     * @param (String) sColNames 필수 edit 설정 column name list
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function setRowEditable(sheetObj, Row, isEdit, sColNames) {
		var arrColNames = sColNames.split("|");
		var colCnt = arrColNames.length;

		for(i=0; i<=colCnt; i++) {
			sheetObj.CellEditable(Row, arrColNames[i]) = isEdit;
		}
	}
	
	/**
     * org_dest_tp_cd의 value를 가져오는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 김재연
     * @version 2009.05.22
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
	
	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		tabLoadSheet("ACE", "1", "ACE", 0, "I", "20090101", "20091230", "20090601", "true", "true")
     * </pre>
     * @param {string} sPropNo 필수 prop_no 값
     * @param {string} sAmdtSeq 필수 amdt_seq 값
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sPreAmdtSeq 필수 pre_amdt_seq 값
     * @param {string} sPropStsCd 필수 pro_sts_cd 값
     * @param {string} sEffDt 필수 eff_dt 값
     * @param {string} sExpDt 필수 exp_dt 값
     * @param {string} sPreExpDt 필수 pre_exp_dt 값
     * @param (string) sIsReqUsr 필수 req_usr_flg 값
     * @param (string) sIsAproUsr 필수 apro_usr_flg 값
     * @param (string) sDurDupFlg 필수 dur_dup_flg 값
     * @return (String)
     * @author 김재연
     * @version 2009.05.22
     */
 	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
		var formObj = document.form;
		if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd || formObj.pre_amdt_seq.value != sPreAmdtSeq ||
			formObj.prop_sts_cd.value != sPropStsCd || formObj.eff_dt.value != sEffDt || formObj.pre_exp_dt.value != sPreExpDt || formObj.exp_dt.value != sExpDt) {
			formObj.prop_no.value = sPropNo;
			formObj.amdt_seq.value = sAmdtSeq;
			
			formObj.svc_scp_cd.value = sSvcScpCd;
			formObj.pre_amdt_seq.value = sPreAmdtSeq;
			formObj.prop_sts_cd.value = sPropStsCd;

			formObj.eff_dt.value = sEffDt;
			formObj.exp_dt.value = sExpDt;
			formObj.pre_exp_dt.value = sPreExpDt;
			
			formObj.req_usr_flg.value = sIsReqUsr ;
			formObj.apro_usr_flg.value = sIsAproUsr;
	 		formObj.dur_dup_flg.value = sDurDupFlg ;
			formObj.lgcy_if_flg.value = sLgcyIfFlg;
			
			buttonControl();
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC04); //Radio Button Default 설정
			if(sSvcScpCd == "TAE") {
 				formObj.org_dest_tp_cd[0].disabled = true;
 				formObj.org_dest_tp_cd[1].checked = true;
 			} else {
 				formObj.org_dest_tp_cd[0].disabled = false;
 			}
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC03); //Term 설정
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
	
 	/**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.prop_no.value = "";
		formObject.amdt_seq.value = "";
		formObject.svc_scp_cd.value = "";
		formObject.pre_amdt_seq.value = "";
		formObject.eff_dt.value = "";
		formObject.exp_dt.value = "";
		formObject.pre_exp_dt.value = "";
		
		sheetObjects[0].RemoveAll();

	}     
	
	var enableFlag = true;
	
	/**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function tabEnableSheet(flag) {
		var formObject = document.form;	
		enableFlag = flag;
		sheetObjects[0].Editable = flag;
	}

	/**
     * location code 유효성 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */ 
	function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj = document.form;
		var locCd = sheetObj.CellValue(Row, cellDefCdNm);
		
		// Location
		if(locCd.length == 5 && isLoc) {
			formObj.f_cmd.value = SEARCH05; 	    			
			formObj.cd.value = locCd;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			
			if(arrDesc != null && arrDesc.length > 0) {
				sheetObj.CellValue2(Row, cellTpCdNm) = "L" ;
				if(cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm") = arrDesc[0][1];
				}
			}else{	
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				if(cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm") = "";
				}
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		} 
		// Group Location
		else if(locCd.length == 4 && isGrpLoc) {
 			formObj.f_cmd.value = SEARCH17;
 			formObj.cd.value = locCd;
 			
 			var param = "&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+param); 	  				
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			
			if(arrData[1] != "") {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "G";
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row,cellDefCdNm);
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			if(cellDefCdNm == "rout_pnt_loc_def_cd") {
				sheetObj.CellValue2(Row,"rout_pnt_loc_def_nm") = "";
			}
			sheetObj.SelectCell(Row, cellDefCdNm);
 		}
	}
	
	/**
     * location code 를 리셋하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.CellValue2(Row, cellTpCdNm) = "";
		sheetObj.CellValue2(Row, cellDefCdNm) = "";
	}
	
	/**
	 * TYPE RADIO 버튼의 폰트색을 변경하는 function <br>
     * 1) ALL ACCEPT일 경우는 파란색 <br>
     * 2) AMEND할 건수가 존재할 경우 빨간색 <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setTypeFontStyle(sXml);
     * </pre>
     * @param {object} sXml 필수 Xml Object
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
     function setTypeFontStyle(sXml) {
     	var arrDesc = ComPriXml2Array(sXml, "org_font_style|dest_font_style");
     	var lgcyIfFlg = form.lgcy_if_flg.value;
     	
 		if (arrDesc != null && arrDesc.length > 0) {
 			if(arrDesc[0][0] == "blue") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color = "blue";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color = "black";
 				}
 			} else if(arrDesc[0][0] == "red") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color = "red";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color = "black";
 				}
 			} else if(arrDesc[0][0] == "bold") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
 				document.getElementById("org_dest_tp_cd1").style.color = "black";
 			} else {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
 				document.getElementById("org_dest_tp_cd1").style.color = "black";
 			}
 			
 			if(arrDesc[0][1] == "blue") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color = "blue";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color = "black";
 				}
 			} else if(arrDesc[0][1] == "red") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color = "red";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color = "black";
 				}
 			} else if(arrDesc[0][1] == "bold") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
 				document.getElementById("org_dest_tp_cd2").style.color = "black";
 			} else {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
 				document.getElementById("org_dest_tp_cd2").style.color = "black";
 			}
 		}
     }
	
	/**
     * Proposal status를 변경하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {object} formObj 필수 Form Object
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
    function setProposalStatusSummary(formObj) {
    	var orgDestTpCd = getOrgDestTpCd();
    	if(orgDestTpCd == "O") {
 			parent.comUpdateProposalStatusSummary("61", formObj.svc_scp_cd.value);
 		} else if(orgDestTpCd == "D") {
 			parent.comUpdateProposalStatusSummary("62", formObj.svc_scp_cd.value);
 		}
    }
    
    /**
     * excel popup 화면을 닫으면서 호출하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    reloadExcelCopy()
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */ 
    function reloadExcelCopy() {
    	var formObj = document.form;
    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    	setProposalStatusSummary(formObj); //excel
    }
    
    /**
     * Zip code 의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkZipCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */ 
    function checkZipCode(sheetObj) {
    	var rCnt = sheetObj.RowCount; 
    	for(var i=1; i<=rCnt; i++) {
    		if(ComIsNull(sheetObj.CellValue(i, "loc_grd_cnt_cd")) != ComIsNull(sheetObj.CellValue(i, "loc_grd_cd"))) {
    			ComShowCodeMessage('PRI01065','Zip Code','10');
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Type Radio button Click 시 Validation 체크나 변경내용 저장 Confirm 에서 No 선택시 되돌리는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    returnRadioButton()
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */  
    function returnRadioButton() {
    	var formObj = document.form;
    	if(formObj.org_dest_tp_cd[0].checked) {
			formObj.org_dest_tp_cd[1].checked = true;
		} else if(formObj.org_dest_tp_cd[1].checked) {
			formObj.org_dest_tp_cd[0].checked = true;
		}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (object) formObj 필수 Form Object
     * @param (string) sAction 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH: // 조회			
				if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}
				return true;
 				break;
 				
  			case IBSAVE: // 저장
  				var amdtSeq = formObj.amdt_seq.value;
  			
	  			if(!ComShowCodeConfirm('PRI00001')) {
	     			return false;
	     		}
	  			
	  			if(!sheetObjects[0].IsDataModified) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
	  			
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
	  			
  				if(!checkZipCode(sheetObjects[0])) {
  					return false;
  				}
  				
  				if(amdtSeq == 0) {
					var rowM = sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", false);
					if(rowM >= 0) {
						 ComShowCodeMessage("PRI00303", "Sheet", rowM);
					     return false;
				    }	    		
  				} else {
  					var dupRow = ComPriAmendDupCheck(sheetObjects[0], "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", amdtSeq);
  					if(dupRow >= 0) {
  						ComShowCodeMessage("PRI00303", "Sheet", dupRow);
  						return false;
  					}
  				}
  				
  			    // Proposal 금액을 확인한다.
				for(var i=sheetObj.TopRow; i<=sheetObj.LastRow; i++) {
					if(sheetObj.CellValue(i, "prop_frt_rt_amt") == 0) {
						ComShowCodeMessage("PRI08010", i, 'proposal rate');
						return false;
					}
				}
				return true;
				break;
    			
    		case IBINSERT: // Row Add
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != form.amdt_seq.value) { //amend 사이에 add 안되게 막기
    				ComShowCodeMessage("PRI01002");		
    				return false;
    			}						
    			return true;
    			break;
    			
    		case IBCOPYROW: // Row Copy
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
	    		if(sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != form.amdt_seq.value) { //amend 사이에 add 안되게 막기
					ComShowCodeMessage("PRI01002");		
					return false;
				}
    			return true;
    			break;
    			
    		case IBDELETE: // Delete
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			return true;
    			break;
    			
    		case IBSEARCH_ASYNC01: //Guideline Copy
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(sheetObj.RowCount > 0) {
    				ComShowCodeMessage("PRI01005");
    				return false;
    			}
    			return true;
    			break;
    			
    		case MODIFY01:	//Accept
	    		if(!ComShowCodeConfirm('PRI00008')) {
					return false;
				}
				return true;
				break;
			
			case MODIFY02:	//Accept Cancel
	    		if(!ComShowCodeConfirm('PRI00009')) {
					return false;
				}
				return true;
				break;
			
			case MODIFY03: //Accept All
	    		if(!ComShowCodeConfirm('PRI01015')) {
					return false;
				}
				return true;
				break;
			
			case MODIFY04: //Cancel
	    		if(!ComShowCodeConfirm('PRI01010')) {
					return false;
				}
				return true;
				break;
			
			case MODIFY05: // Radio Button Click Save
				var amdtSeq = formObj.amdt_seq.value;
			
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
  			
				if(!checkZipCode(sheetObjects[0])) {
					return false;
				}
				
				if(amdtSeq == 0) {
					var rowM = sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", false);
					if(rowM >= 0) {
						 ComShowCodeMessage("PRI00303", "Sheet", rowM);
					     return false;
				    }	    		
				} else {
					var dupRow = ComPriAmendDupCheck(sheetObjects[0], "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", amdtSeq);
					if(dupRow >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", dupRow);
						return false;
					}
				}
				
			    // Proposal 금액을 확인한다.
				for(var i=sheetObj.TopRow; i<=sheetObj.LastRow; i++) {
					if(sheetObj.CellValue(i, "prop_frt_rt_amt") == 0) {
						ComShowCodeMessage("PRI08010", i, 'proposal rate');
						return false;
					}
				}
				return true;
				break;
			
			case IBLOADEXCEL:
				if(sheetObjects[0].IsDataModified) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
				return true;
				break;
		}
		return true;
	}

	/**
     * 버튼 권한 컨트롤 function <br>
     * 버튼을 제어한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		buttonControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.05.22
     */
  	function buttonControl(){
 		var formObj = document.form;
 		var req_usr_flg = formObj.req_usr_flg.value;
 		var apro_usr_flg = formObj.apro_usr_flg.value;
 		var amdt_seq = formObj.amdt_seq.value;
 		var sts = formObj.prop_sts_cd.value;
 		var row_cnt = sheetObjects[0].RowCount;
 		
 		try {			
 			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_acceptall");
			ComBtnDisable("btn_cancelall");
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowcopy");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_accept");
			ComBtnDisable("btn_acceptcancel");
			ComBtnDisable("btn_downexcel");
			ComBtnDisable("btn_loadexcel");
			
			if(amdt_seq > 0){
				showButton("btn_amend");
				showButton("btn_amendcancel");
				ComBtnDisable("btn_amendcancel");
				ComBtnDisable("btn_amend");
			} else {
				hiddenButton("btn_amend");
				hiddenButton("btn_amendcancel");
			}

 			switch (sts) {
 				case 'I':   // Initial
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_downexcel");
 						ComBtnEnable("btn_loadexcel");
 						ComBtnEnable("btn_rowadd");
 						ComBtnEnable("btn_rowcopy");
 						ComBtnEnable("btn_delete");
 						ComBtnEnable("btn_amend");
 						ComBtnEnable("btn_amendcancel");
 					}				
 					break;
 					
 				case 'Q':   // Requested
 					if(apro_usr_flg == "true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_acceptall");
 						ComBtnEnable("btn_cancelall");
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 						ComBtnDisable("btn_amend");
						ComBtnDisable("btn_amendcancel");
 					}
 					break;
 					
 				case 'R':   // Returned
 				if(apro_usr_flg == "true") {
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_cancelall");
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					} else if(req_usr_flg == "true") {
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_accept");
					}
 					ComBtnDisable("btn_amend");
 					ComBtnDisable("btn_amendcancel");
 					break;
 					
 				case 'A':   // Approved
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
						ComBtnEnable("btn_downexcel");
					}
 				case 'F':   // Filed
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
						ComBtnEnable("btn_downexcel");
					}
 				case 'C':   // Canceled
 					break;		
 			}	
 			
 		} catch (e) {
 			if(e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e);
 			}
 		}
 	}

	/* 개발자 작업  끝 */