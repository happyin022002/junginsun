/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0024.js
*@FileTitle : Proposal Origin/Destination Arbitrary - Excel Import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.06 김재연
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2015.05.15 송호진 [CHM-201535875] Zero 인 경우도 입력 될수 있도록 로직을 수정
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
     * @class ESM_PRI_0024 : ESM_PRI_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0024() {
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
    var errFlg = false;	// Check 버튼동작후 flag 값 세팅
    
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
     * @version 2009.07.06
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
    			case "btn_template":
    				downform.submit();
    				break;
    		    
	    		case "btn_openfile":
	    			sheetObject1.LoadExcel(-1);
					break;
				
	    		case "btn_check":
	    			doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
					break;
					
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;

				case "btn_close":
					dialogArguments.reloadExcelCopy();
					self.close();
					break;
            }
    	}catch(e) {
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
     * @version 2009.07.06
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
     * @version 2009.07.06
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
     * @version 2009.07.06
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
     	var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":      //t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 260;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "state|Seq.|Point|Trans Mode|Term|Base Port|VIA|D/Call|Per|Cargo Type|Commodity|Currency|Proposal|||||||||||||";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,   daCenter,  false,		"ibflag");
                    
    				InitDataProperty(0, cnt++, dtDataSeq,    	30,   daCenter,  false,    	"Seq");
    				InitDataProperty(0, cnt++, dtPopupEdit,  	60,   daCenter,  false,     "rout_pnt_loc_def_cd",  false,	"", dfEngUpKey, 0,  true,	true);
    				InitDataProperty(0, cnt++, dtCombo,      	70,   daCenter,  false,     "prc_trsp_mod_cd",    	false,  "", dfEngUpKey, 0,  true,   true);
    				InitDataProperty(0, cnt++, dtCombo,      	50,   daCenter,  false,     "rcv_de_term_cd",       false,  "", dfEngUpKey, 0,  true,   true);
    				InitDataProperty(0, cnt++, dtPopupEdit,   	80,   daCenter,  false,     "bse_port_def_cd",     	false,  "", dfEngUpKey, 0,  true,   true);
    				InitDataProperty(0, cnt++, dtPopupEdit,   	70,   daCenter,  false,     "via_port_def_cd",    	false, 	"", dfEngUpKey, 0,  true,   true);
    				InitDataProperty(0, cnt++, dtCheckBox,   	60,   daCenter,  false,     "dir_call_flg",      	false,  "", dfNone, 	0,  true,   true,	-1,	false,	true,	"",	false);
    				InitDataProperty(0, cnt++, dtCombo,  		40,   daCenter,  false,     "rat_ut_cd",      		false,  "", dfNone, 	0,  true,   true);
    				InitDataProperty(0, cnt++, dtCombo,     	90,   daCenter,  false,     "prc_cgo_tp_cd",     	false, 	"", dfNone, 	0,  true,   true);
    				InitDataProperty(0, cnt++, dtPopupEdit,   	80,   daCenter,  false,     "prc_cmdt_def_cd", 		false, 	"", dfNone,		0,  true,   true);
    				InitDataProperty(0, cnt++, dtCombo,      	70,   daCenter,  false,     "curr_cd",      		false,  "", dfNone, 	0,  true,   true);
    				InitDataProperty(0, cnt++, dtData,      	70,   daRight,   false,     "prop_frt_rt_amt",     	false,  "",	dfFloat,	2,	true,   true,	9);
                    
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"prop_no");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"amdt_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"svc_scp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"add_chg_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"org_dest_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "rout_pnt_loc_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "bse_port_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "via_port_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "prc_cmdt_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,    	"add_chg_seq");
    				InitDataProperty(0, cnt++, dtHidden,      	80,   daCenter,  false,     "n1st_cmnc_amdt_seq", 	false,	"",	dfNone, 0,     false,   false);
    				InitDataProperty(0, cnt++, dtHidden,     	90,   daCenter,  false,     "src_info_cd",     		false,  "", dfNone, 0,     false,   false);
    				InitDataProperty(0, cnt++, dtHidden,  		80,   daCenter,  false,     "prc_prog_sts_cd",      false,  "", dfNone,	0,     false,   false);
    				
    				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 				    InitDataValid(0, "rout_pnt_loc_def_cd",     vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 				    
    				InitDataValid(0,  "bse_port_def_cd",		vtEngUpOther, "012456789"); // 영문대문자와 숫자만 입력
    				InitDataValid(0,  "via_port_def_cd",		vtEngUpOther, "012456789"); // 영문대문자와 숫자만 입력
    				
    				InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);
    				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
    				InitDataCombo(0, "curr_cd", currCdText, currCdValue,"USD");
    				InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
    				InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);
    				InitDataCombo(0, "prc_prog_sts_cd", PrcProgStsCdText, PrcProgStsCdValue);
    				
    				AutoRowHeight = false;
    				WaitImageVisible = false;
               	}
            	break;
            
            case "sheet2":
            	with (sheetObj) {
		            // 높이 설정
		            // 전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            // 전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		            // 전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            var HeadTitle = "status";
		            var headCount = ComCountHeadTitle(HeadTitle);
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 1, 1, 6, 100);
		
		            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, true, true, false,false)
		
		            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   false,  "ibflag");
		
		            Visible = false;
		        }
            	break;	
            case "sheet3":      //기존데이터와  DUP체크하기위한 SHEET
	            with (sheetObj) {
	                /*
            		// 높이 설정
	                style.height = 0;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
					*/
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
	                var HeadTitle = "state|Point|Trans Mode|Term|Base Port|VIA|D/Call|Per|Cargo Type|Commodity|Currency";
	                var headCount = ComCountHeadTitle(HeadTitle);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus, 30,   daCenter,  false,		"ibflag");
	               
					InitDataProperty(0, cnt++, dtPopupEdit,  	60,   daCenter,  false,     "rout_pnt_loc_def_cd",  false);
					InitDataProperty(0, cnt++, dtCombo,      	70,   daCenter,  false,     "prc_trsp_mod_cd",    	false);
					InitDataProperty(0, cnt++, dtCombo,      	50,   daCenter,  false,     "rcv_de_term_cd",       false);
					InitDataProperty(0, cnt++, dtPopupEdit,   	80,   daCenter,  false,     "bse_port_def_cd",     	false);
					InitDataProperty(0, cnt++, dtPopupEdit,   	70,   daCenter,  false,     "via_port_def_cd",    	false);
					InitDataProperty(0, cnt++, dtCheckBox,   	60,   daCenter,  false,     "dir_call_flg",      	false);
					InitDataProperty(0, cnt++, dtCombo,  		40,   daCenter,  false,     "rat_ut_cd",      		false);
					InitDataProperty(0, cnt++, dtCombo,     	90,   daCenter,  false,     "prc_cgo_tp_cd",     	false);
					InitDataProperty(0, cnt++, dtPopupEdit,   	80,   daCenter,  false,     "prc_cmdt_def_cd", 		false);
					InitDataProperty(0, cnt++, dtCombo,      	70,   daCenter,  false,     "curr_cd",      		false);
					
					WaitImageVisible = false;
	           	}
	        	break;        
            case "sheet4":      //CODE 체크하기위한 SHEET
	            with (sheetObj) {
	                
	        		// 높이 설정
	                style.height = 200;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
					
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
	                var HeadTitle = "state|Point|Base Port|VIA|Commodity";
	                var headCount = ComCountHeadTitle(HeadTitle);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus, 30,   daCenter,  false,		"ibflag");	               
	                InitDataProperty(0, cnt++, dtData, 60,   daCenter,  false,     "rout_pnt_loc_def_cd");
					InitDataProperty(0, cnt++, dtData, 80,   daCenter,  false,     "bse_port_def_cd");
					InitDataProperty(0, cnt++, dtData, 70,   daCenter,  false,     "via_port_def_cd");
					InitDataProperty(0, cnt++, dtData, 80,   daCenter,  false,     "prc_cmdt_def_cd");

					WaitImageVisible = false;
	           	}
	        	break;  	        	
        }
    }
    
    /**
     * 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {Long} Row 필수 해당 셀의 Row Index
     * @param {Long} Col 필수 해당 셀의 Column Index
     * @param {Integer} KeyCode 필수 키보드의 아스키 값
     * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @return 없음
     * @author 김재연
     * @version 2009.07.20
     */ 
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        if (errFlg && KeyCode == 9) {
            while (true) {
            	if (Col > sheetObj.LastCol) {
            		Row++;
                    Col = 1;
                }
                if (Row > sheetObj.LastRow) {
                    Row = sheetObj.HeaderRows;
                }
                if (sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255,0,0)) {
                   sheetObj.SelectCell(Row, Col, false);
                   break;
                }
                Col++;
            }
        }
    }
     
    /**
 	 * sheet1 OnPopupClick 이벤트 발생시 호출되는 function <br>
 	 * 해당 popup 화면을 호출한다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 	 * @return 없음
 	 * @author 김재연
 	 * @version 2009.05.18
 	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
     	var formObj = document.form;
     	var propNO = sheetObj.CellValue(Row, "prop_no");
     	var amdtSeq = sheetObj.CellValue(Row, "amdt_seq");
     	var svcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
     	var tpCd = "";
     	
  		if (colName == "rout_pnt_loc_def_cd") { //Point
  			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd="+ PRI_SP_SCP +"&location_cmd=L&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
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
  			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
  			if (rtnVal != null && checkBasePort(sheetObj, Row, rtnVal.cd)){
  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
  				if(rtnVal.cd.length == 5) { //Location Type을 변경한다
  					tpCd = "L";
  				} else if(rtnVal.cd.length == 4) { //Location Type을 변경한다
  					tpCd = "G";
  				}
  				sheetObj.CellValue2(Row,"bse_port_tp_cd") = tpCd ;
  			}
  		} else if (colName == "via_port_def_cd") { //VIA
  			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
  			if (rtnVal != null){
  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;

  				if (rtnVal.cd.length == 5){ //Location Type을 설정한다
  					tpCd = "L";
  				}
  				sheetObj.CellValue2(Row,"via_port_tp_cd") = tpCd ;
  				sheetObj.CellEditable(Row,"dir_call_flg") = false; //Direct Call 사용불가
  			}
  		}  else if (colName == "prc_cmdt_def_cd") { //Commodity
  			var sUrl = "/hanjin/ESM_PRI_4027.do?commodity_cmd=CG&grp_cd="+PRI_SP_SCP+"&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 325, true);
  			if (rtnVal != null){
  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;

  				if(rtnVal.cd.length == 5) {
  					tpCd = "G";
  				} else if(rtnVal.cd.length == 6) {
  					tpCd = "C";
  				}
  				
  				sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = tpCd ;
  			}
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
     * @version 2009.07.06
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        try{
	        switch(sAction) {
	        	
	        	case IBSEARCH_ASYNC01: //체크
	        		ComOpenWait(true);
	        		if(!validateForm(sheetObj,formObj,sAction)) {
	        			ComOpenWait(false);
	        			return false;
	        		}
	        		ComOpenWait(false);
	                break;
	            
	        	case IBSEARCH_ASYNC03: // Term Code 조회
					formObj.f_cmd.value = SEARCH19;
					if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
						formObj.cd.value="CD02138";
					} else {
						formObj.cd.value="CD02139";
					}
					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
					setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
					break;
	        	case IBSAVE:        //저장
		    		ComOpenWait(true);
		    		if(!validateForm(sheetObj,formObj,sAction)) {
		    			ComOpenWait(false);
		    			return false;
		        	}
		    		
					formObj.f_cmd.value = MULTI01;
					sheetObj.DoSave("ESM_PRI_0024GS.do", FormQueryString(formObj), -1, false);
					
	//				if(sFlag == "N") {
	//					ComShowCodeMessage("PRI02017", sDupIdx);
	//					sheetObj.Editable = true;
	//				} else {
	//					formObj.f_cmd.value = MULTI01;
	//					sheetObj.DoSave("ESM_PRI_0024GS.do", FormQueryString(formObj), -1, false);
	//				}
					ComOpenWait(false);
		            break;				
				
	//        	case IBSAVE:        //저장
	//        		ComOpenWait(true);
	//        		if(!validateForm(sheetObj,formObj,sAction)) {
	//        			ComOpenWait(false);
	//        			return false;
	//            	}
	//        	
	//	        	formObj.f_cmd.value = SEARCH01;
	//				var sXml = sheetObj.getSearchXml("ESM_PRI_0024GS.do", FormQueryString(formObj)+"&"+sheetObj.GetSaveString());
	//				//sheetObj.LoadSearchXml(sXml);
	//				
	//				var sFlag = ComGetEtcData(sXml, "FLAG");
	//				var sDupIdx = ComGetEtcData(sXml, "DUP_INDEX");
	//				
	//				if(sFlag == "N") {
	//					ComShowCodeMessage("PRI02017", sDupIdx);
	//					sheetObj.Editable = true;
	//				} else {
	//					formObj.f_cmd.value = MULTI01;
	//					sheetObj.DoSave("ESM_PRI_0024GS.do", FormQueryString(formObj), -1, false);
	//				}
	//				ComOpenWait(false);
	//                break;
	        }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	if (sAction == IBSEARCH_ASYNC03) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
        

    }
    
    /**
	 * 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {Long} Row 필수 해당 셀의 Row Index
	 * @param {Long} Col 필수 해당 셀의 Column Index
	 * @param {Integer} KeyCode 필수 키보드의 아스키 값
	 * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.06
	 */ 
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
	    if (errFlg && KeyCode == 9) {
		    while (true) {
			    if (Col > sheetObj.LastCol) {
			    	Row++;
			    	Col = 1;
				}
				if (Row > sheetObj.LastRow) {
					Row = sheetObj.HeaderRows;
				}
				if (sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255,0,0)) {
					sheetObj.SelectCell(Row, Col, false);
					break;
				}
				Col++;
			}
		}
	}
      
    /**
	 * OnChange 이벤트 발생시 호출되는 function <br>
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
	 * @version 2009.07.06
	 */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj = document.form;
 		var sName = sheetObj.ColSaveName(Col);
 		var amdt_seq = formObj.amdt_seq.value;
 		var validColor = sheetObj.RgbColor(255, 0, 0);
 		
 		switch(sName) {
 			case "rout_pnt_loc_def_cd": //point
	 			if(!checkRoutePointLocation(sheetObj, Row, Value)) {
					return;
				}
 				if(checkLocation(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false)) {
 					sheetObj.CellBackColor(Row, sName) = sheetObj.RgbColor(255, 255, 255);
 				}
 				break;	
 			
 			case "prc_trsp_mod_cd":
 				if(checkCommonCode(sheetObj, Row, sheetObj.CellValue(Row, "prc_trsp_mod_cd"), "prc_trsp_mod_cd")) {
 					sheetObj.CellBackColor(Row, sName) = sheetObj.RgbColor(255, 255, 255);
 	     		}
 				break;
 				
 			case "rcv_de_term_cd":
 				if(checkCommonCode(sheetObj, Row, sheetObj.CellValue(Row, "rcv_de_term_cd"), "rcv_de_term_cd")) {
 					sheetObj.CellBackColor(Row, sName) = sheetObj.RgbColor(255, 255, 255);
 	     		}
 				break;
 				
 			case "bse_port_def_cd": //base port
 				if(!checkBasePort(sheetObj, Row, Value)) { //point와 비교
 					 return false;
 				}
 				if(checkLocation(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true)) {
 					sheetObj.CellBackColor(Row, sName) = sheetObj.RgbColor(255, 255, 255);
 				}
  	    		break;
  	    	
 			case "via_port_def_cd":
 				checkLocation(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false);
 				setDirectCall(sheetObj, Row, Value);
  				break;	
 			
 			case "dir_call_flg":
 				checkVia(sheetObj, Row, Value);
 				break;
 			
 			case "rat_ut_cd":
 				checkPerType(sheetObj, Row, Value);
 				break;
 				
 			case "prc_cgo_tp_cd":
 				checkCargoType(sheetObj, Row, Value);
 				break;
 				
 			case "prc_cmdt_def_cd":
 				checkCommodity(sheetObj, Row, Value);
 	 			break;
 	 			
 			case "prop_frt_rt_amt":
 				if(checkProposalFreightRateAmount(sheetObj, Row, Value)) {
 					sheetObj.CellBackColor(Row, sName) = sheetObj.RgbColor(255, 255, 255);
 				}
 				break;
 		}
    }
 	 
    /**
     * LoadExcel 이벤트 발생시 호출되는 function <br>
     * 엑셀파일 로드 후 정상이면 SHEET COLUMN 을 제어한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.07.08
     */
  	function sheet1_OnLoadExcel(sheetObj){
  		setAllDirectCall(sheetObj);
  		toggleButtons("INIT");
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
     * @version 2009.07.06
     */ 	
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
 			dialogArguments.reloadExcelCopy();
			self.close();
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
     * @version 2009.07.06
     */ 
    function pageOnLoadFinish() {
    	 toggleButtons("CLEAR");
    	 doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
    	 toggleButtons("INIT");
    }
     
  	/**
     * location code 유효성 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocation(sheetObj, Row, "del_tp_cd", "del_def_cd");
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */
	function checkLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj = document.form;
		var locCd = sheetObj.CellValue(Row, cellDefCdNm);
		
		if(ComIsNull(locCd)) {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return true;
		}
		
		// Location
		if (locCd.length == 5 && isLoc) {
			formObj.f_cmd.value = SEARCH05; 	    			
			formObj.cd.value = locCd;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.CellValue2(Row, cellTpCdNm) = "L" ;
				return true;
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				return false;
			}
		} 
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
 			formObj.f_cmd.value = SEARCH17;
 			formObj.cd.value = locCd;
 			
 			var param = "&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+param); 	  				
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			
			if (arrData[1] != "") {
				sheetObj.Cellvalue2(Row, cellTpCdNm) = "G";
				return true;
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				return false;
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return false;
 		}
		return true;
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
     * @version 2009.07.06
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.CellValue2(Row, cellTpCdNm) = "";
		sheetObj.CellValue2(Row, cellDefCdNm) = "";
	}
	
	/**
     * sheet의 dir_call_flg의 edit 여부를 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setDirectCall(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */
	function setDirectCall(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			sheetObj.CellEditable(Row,"dir_call_flg") = true; //Direct Call 사용
		} else {
			sheetObj.CellValue2(Row,"dir_call_flg") = "";
			sheetObj.CellEditable(Row,"dir_call_flg") = false; //Direct Call 사용불가
		}
	}
	
	/**
     * sheet의 전체 dir_call_flg의 edit 여부를 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setAllDirectCall(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */
	function setAllDirectCall(sheetObj) {
		var rCnt = sheetObj.Rows;
		for (var i=1; i<=rCnt; i++) {
			if (sheetObj.CellValue(i, "via_port_def_cd") != "") {
				sheetObj.CellEditable(i, "dir_call_flg") = false;
			} else if (sheetObj.CellValue(i, "dir_call_flg") == "1") {
				sheetObj.CellEditable(i, "via_port_def_cd") = false;
			}
		}
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
     * @version 2009.07.06
     */
	function checkRoutePointLocation(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if (sheetObj.CellValue(Row, "bse_port_def_cd") == Value) {
			ComShowCodeMessage('PRI01078');
			sheetObj.CellValue(Row, "bse_port_def_cd") = "";
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
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
     * @version 2009.07.06
     */
	function checkBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if (sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.CellValue(Row, "bse_port_def_cd") = "";
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	
	/**
     * via_port_def_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setVia(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */
	function checkVia(sheetObj, Row, Value) {
		if (Value == "1") {
			sheetObj.CellValue2(Row,"via_port_def_cd") = "";
			sheetObj.CellEditable(Row,"via_port_def_cd") = false;
		} else {
			sheetObj.CellEditable(Row,"via_port_def_cd") = true;
			if(sheetObj.CellValue(Row,"via_port_def_cd") != "") {
				sheetObj.CellEditable(Row, "dir_call_flg") = false;
				sheetObj.CellBackColor(Row, "dir_call_flg") = sheetObj.UnEditableColor;
			}
		}
	}
	
    /**
     * rat_ut_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */
	function checkPerType(sheetObj, Row, Value) {
		 var validPerClass = "A,F,O,Q,S,P";
		 if(sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
			 ComShowCodeMessage("PRI08003");
			 sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
		 }
	}
	
	/**
     * prc_cgo_tp_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
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
     * cmdt_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCommodity(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */ 
	function checkCommodity(sheetObj, Row, Value) {
		var formObj = document.form; 
		
		if(ComIsNull(Value)) {
			sheetObj.CellBackColor(i, 'prc_cmdt_def_cd') = sheetObj.RgbColor(255, 255, 255);
			sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "";
			return false;
		}
		
		if (Value.length == 5) { //Group Commodity
			var propNo = sheetObj.CellValue(Row, "prop_no");
			var amdtSeq = sheetObj.CellValue(Row, "amdt_seq");
			var svcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
			
			formObj.f_cmd.value = SEARCH10;
			formObj.cd.value = Value;
			sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=proposal");
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			
			if (arrData[1] == "") {
				sheetObj.Cellvalue2(Row,"prc_cmdt_def_cd") = "";
				sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "";
				sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
				return false;
			} else {
				sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "G";
				return true;
			}

		} else if (Value.length == 6) {
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_PRI_4027GS.do", FormQueryString(formObj)+"&cmdt_cd="+Value);
			var arrDesc = ComPriXml2Array(sXml, "cmdt_cd|cmdt_nm");
			
			if (arrDesc == null || arrDesc.length < 1) {
				sheetObj.Cellvalue2(Row,"prc_cmdt_def_cd") = "";
				sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "";
				sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
				return false;
			} else {
				sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "C";
				return true;
			}
		} else {
			sheetObj.Cellvalue2(Row,"prc_cmdt_def_cd") = "";
			sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
			return false;
		}
	}
	
	/**
     * 유효성 확인하는 function <br>
     * 필수입력 항목인데 입력되지 않았을때 오류 리턴 <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCommonCode(sheetObj, i, sheetObj.CellValue(i, "pay_term_cd"), "pay_term_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @param (string) CellName 필수 이벤트가 발생한 해당 셀의 Name
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.06
     */
	function checkCommonCode(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value) && ComTrim(sheetObj.CellText(Row, CellName)) != "") {
			return false;
		}
		return true;
	}
	
	/**
     * prop_frt_rt_amt 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCommodity(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */ 
	function checkProposalFreightRateAmount(sheetObj, Row, Value) {
		if(ComIsNull(ComZeroToNull(Value))) {
			return false;
		}
		
		if(!ComIsMoneyNumber(Value)) {
			return false;
		}
		//alert("Value : "+Value+"\t Trunc : "+ComTrunc(Value,0)+"\t 결과 : "+ComChkLen(ComTrunc(Value,0),7));
		if(Value >= 10000000) {
			return false;
		}
		return true;
	}
	
//	/**
//     * sheet의 column별 validation을 확인하는 function <br> 사용안함
//     * <br><b>Example :</b>
//     * <pre>
//     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
//     * </pre>
//     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
//     * @param {object} formObj 필수 HTML태그 form 오브젝트
//     * @return validCnt
//     * @author 김재연
//     * @version 2009.07.06
//     */
//	function validateCheckSheet(sheetObj, formObj) {
//		var validCnt = 0;
//		var rCnt = sheetObj.RowCount;
//		var baseColor = sheetObj.RgbColor(255, 255, 255);
//		var validColor = sheetObj.RgbColor(255, 0, 0);
//		
//		for(var i=1; i<=rCnt; i++) {
//     		//필수코드 데이터셋
//     		sheetObj.CellValue(i, "prop_no") = formObj.prop_no.value;
//     		sheetObj.CellValue(i, "amdt_seq") = formObj.amdt_seq.value;
//     		sheetObj.CellValue(i, "svc_scp_cd") = formObj.svc_scp_cd.value;
//     		sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
//     		sheetObj.CellValue(i, "add_chg_tp_cd") = formObj.add_chg_tp_cd.value;
//     		sheetObj.CellValue(i, "org_dest_tp_cd") = formObj.org_dest_tp_cd.value;
//     		sheetObj.CellValue(i, "src_info_cd") = "NW";
//			sheetObj.CellValue(i, "prc_prog_sts_cd") = "I";
//			
//     		if(!validCheckLocation(sheetObj, i, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false)) {
//     			sheetObj.CellBackColor(i, 'rout_pnt_loc_def_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Trans Mode
//     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "prc_trsp_mod_cd"), "prc_trsp_mod_cd")) {
//     			sheetObj.CellBackColor(i, 'prc_trsp_mod_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Term
//     		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "rcv_de_term_cd"), "rcv_de_term_cd")) {
//     			sheetObj.CellBackColor(i, 'rcv_de_term_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Base Port
//     		if(!validCheckLocation(sheetObj, i, 'bse_port_tp_cd', 'bse_port_def_cd', true, true)) {
//     			sheetObj.CellBackColor(i, 'bse_port_def_cd') = validColor;
//     			validCnt++;
//     		} else if(!validCheckBasePort(sheetObj, i, sheetObj.CellValue(i, "bse_port_def_cd"))) { //point와 비교
//     			sheetObj.CellBackColor(i, 'bse_port_def_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// VIA
//     		if(!validCheckLocation(sheetObj, i, 'via_port_tp_cd', 'via_port_def_cd', true, false)) {
//     			sheetObj.CellBackColor(i, 'via_port_def_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// D/Call
//     		if(!validCheckDirectCall(sheetObj, i, sheetObj.CellValue(i, "via_port_def_cd"))) {
//     			sheetObj.CellBackColor(i, 'dir_call_flg') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Per
//     		if(!validCheckPerType(sheetObj, i, sheetObj.CellValue(i, "rat_ut_cd"))) { //Per(Rating Unit) 확인
//     			sheetObj.CellBackColor(i, 'rat_ut_cd') = validColor;
//     			validCnt++;
//     		}
//
//     		// Cargo Type
//     		if(!validCheckCargoType(sheetObj, i, sheetObj.CellValue(i, "prc_cgo_tp_cd"))) { 
//     			sheetObj.CellBackColor(i, 'prc_cgo_tp_cd') = validColor;
//     			validCnt++;
//     		}
//
//     		// Commodity
//     		if(!validCheckCommodity(sheetObj, i, sheetObj.CellValue(i, "prc_cmdt_def_cd"))) {
//     			sheetObj.CellBackColor(i, 'prc_cmdt_def_cd') = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Currency
//     		if(!validCheckCurrency(sheetObj, i, sheetObj.CellValue(i, "curr_cd"))) {
//     			sheetObj.CellBackColor(i, "curr_cd") = validColor;
//     			validCnt++;
//     		}
//     		
//     		// Proposal
//     		if(!validCheckProposalFreightRateAmount(sheetObj, i, sheetObj.CellValue(i, "prop_frt_rt_amt"))) {
//     			sheetObj.CellBackColor(i, "prop_frt_rt_amt") = validColor;
//     			validCnt++;
//     		}
//		}
//
//        document.body.scroll = "no";
//		return validCnt;
//	}
	
//	/**
//     * location code 유효성 확인하는 function <br>
//     * <br><b>Example :</b>
//     * <pre>
//     *    validCheckLocation(sheetObj, i, "del_tp_cd", "del_def_cd")
//     * </pre>
//     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
//     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
//     * @param (string) cellTpCdNm 선택한 cell의 tp code
//     * @param (string) cellDefCdNm 선택한 cell의 def code
//     * @return boolean
//     * 			true  : 정상
//     * 			false : 오류
//     * @author 김재연
//     * @version 2009.07.06
//     */
//	function validCheckLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
//		var formObj = document.form;
//		var locCd = sheetObj.CellValue(Row, cellDefCdNm);
//		
//		if(ComIsNull(locCd) && (cellDefCdNm == "rout_pnt_loc_def_cd" || cellDefCdNm == "bse_port_def_cd")) {
//			return false;
//		} else if(ComIsNull(locCd)) {
//			return true;
//		}
//		
//		// Location
//		if (locCd.length == 5 && isLoc) {
//			formObj.f_cmd.value = SEARCH05;
//			formObj.cd.value = locCd;
//			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
//			
//			if (arrDesc != null && arrDesc.length > 0) {
//				sheetObj.CellValue2(Row, cellTpCdNm) = "L" ;
//				return true;
//			} else {
//				sheetObj.CellValue2(Row, cellTpCdNm) = "" ;
//				return false;
//			}
//		} 
//		// Group Location
//		else if (locCd.length == 4 && isGrpLoc) {
// 			formObj.f_cmd.value = SEARCH17;
// 			formObj.cd.value = locCd;
// 			
// 			var param = "&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
//			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+param); 	  				
//			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//			
//			if(arrData[1] != "") {
//				sheetObj.Cellvalue2(Row, cellTpCdNm) = "G";
//				return true;
//			} else {
//				sheetObj.Cellvalue2(Row, cellTpCdNm) = "";
//				return false;
//			}
// 		} else {
//			return false;
// 		}
//		return true;
//	}
	
	/**
     * bse_port_def_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	validCheckBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.06
     */
	function validCheckBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}

		if(sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			return false;
		}
		return true;
	}
	 
	/**
     * dir_call_flg의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	validCheckDirectCall(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.06
     */
	function validCheckDirectCall(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		
		if(sheetObj.CellValue(Row, "dir_call_flg") == 1) {
			sheetObj.CellEditable(Row, "dir_call_flg") = true;
			return false;
		}
		return true;
	}
	
	/**
     * rat_ut_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	validCheckPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.06
     */
	function validCheckPerType(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		
		if(!validCheckCommonCode(sheetObj, Row, Value, "rat_ut_cd")) {
			return false;
		}
		
    	return true;
	}
	
	/**
     * prc_cgo_tp_cd 의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	validCheckCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.06
     */
	function validCheckCargoType(sheetObj, Row, Value) {
		if(!validCheckCommonCode(sheetObj, Row, Value, "prc_cgo_tp_cd")) {
			return false;
		}

		var validPerClass = "A,F,O,Q,S,P";
        var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
        
        if(!ComIsNull(perClass) && validPerClass.indexOf(perClass) > -1 && Value != "AK") {
       		return false;
        } else if(!ComIsNull(perClass) && validPerClass.indexOf(perClass) < 0 && Value == "AK") {
       		return false;
        }
        return true;
	}
	
//	/**
//     * prc_cmdt_tp_cd 의 validation 확인하는 function <br>
//     * <br><b>Example :</b>
//     * <pre>
//     *	 	validCheckCommodity(sheetObj, Row, Value)
//     * </pre>
//     * @param {ibsheet} sheetObj 필수 IBSheet Object
//     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
//	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
//     * @return boolean
//     * 			true  : 정상
//     * 			false : 오류
//     * @author 김재연
//     * @version 2009.07.06
//     */
//	function validCheckCommodity(sheetObj, Row, Value) {
//		var formObj = document.form; 
//		
//		if(ComIsNull(Value)) {
//			return true;
//		}
//		
//		if(Value.length == 5) { //Group Commodity
//			var propNo = sheetObj.CellValue(Row, "prop_no");
//			var amdtSeq = sheetObj.CellValue(Row, "amdt_seq");
//			var svcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
//
//			formObj.f_cmd.value = SEARCH10;
//			formObj.cd.value = Value;
//			sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=proposal");
//			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//			
//			if (arrData[1] == "") {
//				sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "";
//				return false;
//			} else {
//				sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "G";
//				return true;
//			}
//		} else if(Value.length == 6) {
//			formObj.f_cmd.value = SEARCH01;
//			var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_4027GS.do", FormQueryString(formObj)+"&cmdt_cd="+Value);
//			var arrDesc = ComPriXml2Array(sXml, "cmdt_cd|cmdt_nm");
//			
//			if (arrDesc == null || arrDesc.length < 1) {
//				sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "";
//				return false;
//			} else {
//				sheetObj.Cellvalue2(Row,"prc_cmdt_tp_cd") = "C";
//				return true;
//			}
//		} else {
//			return false;
//		}
//	}
	
	/**
     * curr_cd 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCurrency(sheetObj, i, sheetObj.CellValue(i, "curr_cd"))
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.06
     */
	function validCheckCurrency(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		
		if(!validCheckCommonCode(sheetObj, Row, Value, "curr_cd")) {
			return false;
		}
    	return true;
	}
	
	/**
     * 유효성 확인하는 function <br>
     * 필수입력 항목인데 입력되지 않았을때 오류 리턴 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "pay_term_cd"), "pay_term_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @param (string) CellName 필수 이벤트가 발생한 해당 셀의 Name
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.06
     */
	function validCheckCommonCode(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value) && ComTrim(sheetObj.CellText(Row, CellName)) != "") {
			return false;
		}
		return true;
	}
	
	/**
     * prop_frt_rt_amt 의 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "pay_term_cd"), "pay_term_cd")
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @param (string) CellName 필수 이벤트가 발생한 해당 셀의 Name
     * @return boolean
     * 			true  : 정상
     * 			false : 오류
     * @author 김재연
     * @version 2009.07.06
     */
	function validCheckProposalFreightRateAmount(sheetObj, Row, Value) {
		/* Zero 인 경우도 입력 될수 있도록 로직을 수정 2015.05.15 송호진	
		if(ComIsNull(ComZeroToNull(Value))) {
			return false;
		}
		*/
		if(ComIsNull(Value)) {
			return false;
		}
		
		if(!ComIsMoneyNumber(Value)) {
			return false;
		}

		if(Value >= 10000000) {
			return false;
		}
		return true;
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
     * @version 2009.07.06
     */
    function setFirstValidCell(sheetObj) {
        var topRow = sheetObj.TopRow;
 		var lastRow = sheetObj.LastRow;
 		var lastCol = sheetObj.LastCol;
 		
     	for(var i=topRow; i<=lastRow; i++) {
 			for(var j=0; j<=lastCol; j++) {
   				if(sheetObj.CellBackColor(i, j) == sheetObj.RgbColor(255,0,0)) {
                     sheetObj.SelectCell(i, j, false);
                     return;
                 }
 			}
     	}
    }
     
	/**
     * button의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    toggleButtons("INIT")
     * </pre>
     * @param (string) 필수 button 설정 mode
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */
	function toggleButtons(mode) {
		switch (mode) {
			case "CLEAR":
				ComBtnDisable("btn_template");
				ComBtnDisable("btn_openfile");
				ComBtnDisable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_close");
				break;
			case "INIT":
				ComBtnEnable("btn_template");
				ComBtnEnable("btn_openfile");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnEnable("btn_close");
				break;
			case "READONLY":
				ComBtnEnable("btn_template");
				ComBtnEnable("btn_openfile");
				ComBtnDisable("btn_check");
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_close");
				break;
		}
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.07.06
     */ 
    function validateForm(sheetObj,formObj,sAction){
    	 
    	  switch (sAction) {
    	  
	  		case IBSEARCH_ASYNC01: // 체크
				var orgDestTpCd = formObj.org_dest_tp_cd.value;
	  			
		  		if (!sheetObj.IsDataModified) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
		  		
		  		//셀 바탕색 초기화
		  		for(var i=1; i<=sheetObj.RowCount; i++) {
		  			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,255);
		  		}
		  		
		  		//데이타 유효성 체크
//	  			var validCnt = validateCheckSheet(sheetObj, formObj);
		  		var check = 0;
		  		//오류셀 색지정
		 		var color = sheetObjects[0].RgbColor(255, 0, 0); //빨강
		 	
	  			//화면에서의 validation 체크
	  	  		check += validateSheetData(sheetObjects[0], formObj);
		 	
		  		//code db check
//		  		searchCheckDBCodeExist();
	  			formObj.f_cmd.value = SEARCH03;
	  	 		var sParam = FormQueryString(formObj);
	  	 		var sParamSheet1 = sheetObjects[0].GetSaveString();
	  			sParam += "&" + sParamSheet1; 
	  			var sXml = sheetObjects[3].GetSearchXml("ESM_PRI_0024GS.do", sParam);
	  	 		sheetObjects[3].LoadSearchXml(sXml);
	  	  		
	  	  		
	  	  	
	  			//DB에서의 validation 체크
	  	  		check += checkDBCodeExist(sheetObjects[3], color);

		  		if(check > 0) {
		  			errFlg = true;
		  			ComBtnDisable("btn_save");
		  			setFirstValidCell(sheetObj);
		  			
		  			return false;
		  		} else {	
		  			errFlg = true;
		  			//모든셀 readonly 처리할것
		  			sheetObj.Editable = false;
		  			ComBtnEnable("btn_save");
		  			
		  		}
		 		
		  		return true;
		  		break;
		  		
	  		case IBSAVE:
	  			if(!sheetObjects[0].IsDataModified) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
	  			
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
	  			
	  			var rowDupCnt1 = sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd", false);
	  			if (rowDupCnt1 >= 0) {
	  				ComShowCodeMessage("PRI00303", "Sheet", rowDupCnt1);
				    return false;
	  			}
  				//기존데이터와 중복 체크 위한 처리
  				sheetObjects[2].RemoveAll();
  				var sXml = ComPriSheet2Xml(sheetObjects[0])
  				sheetObjects[2].LoadSearchXml(sXml);
	    		
	        	formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObjects[2].getSearchXml("ESM_PRI_0024GS.do", FormQueryString(formObj));
				sheetObjects[2].LoadSearchXml(sXml, true);
				
				var rowM = sheetObjects[2].ColValueDupRows("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|"
						+"bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|"
						+"curr_cd", false,true);
				if (rowM != "") {
					 var rowDup = rowM.split("|");
	  				ComShowCodeMessage("PRI02017", rowDup[0]);
	  				sheetObj.Editable = true;
	  				return false;
				}	  			
				
	  			break;
    	  }
    	  return true;
    }
     
     
 	/**
      * sheet의 column별 validation을 확인하는 function <br>
      * <br><b>Example :</b>
      * <pre>
      *    validateSheetData(sheetObj, formObj);
      * </pre>
      * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
      * @param {object} formObj 필수 HTML태그 form 오브젝트
      * @return validCnt
      * @author 김재연
      * @version 2009.07.06
      */
 	function validateSheetData(sheetObj, formObj) {
 		var validCnt = 0;
 		var rCnt = sheetObj.RowCount;
 		var baseColor = sheetObj.RgbColor(255, 255, 255);
 		var validColor = sheetObj.RgbColor(255, 0, 0);

 		for(var i=1; i<=rCnt; i++) {
      		//필수코드 데이터셋
      		sheetObj.CellValue(i, "prop_no") = formObj.prop_no.value;
      		sheetObj.CellValue(i, "amdt_seq") = formObj.amdt_seq.value;
      		sheetObj.CellValue(i, "svc_scp_cd") = formObj.svc_scp_cd.value;
      		sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
      		sheetObj.CellValue(i, "add_chg_tp_cd") = formObj.add_chg_tp_cd.value;
      		sheetObj.CellValue(i, "org_dest_tp_cd") = formObj.org_dest_tp_cd.value;
      		sheetObj.CellValue(i, "src_info_cd") = "NW";
 			sheetObj.CellValue(i, "prc_prog_sts_cd") = "I";
 			

      		// Trans Mode
      		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "prc_trsp_mod_cd"), "prc_trsp_mod_cd")) {
      			sheetObj.CellBackColor(i, 'prc_trsp_mod_cd') = validColor;
      			validCnt++;
      		}
      		
      		// Term
      		if(!validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "rcv_de_term_cd"), "rcv_de_term_cd")) {
      			sheetObj.CellBackColor(i, 'rcv_de_term_cd') = validColor;
      			validCnt++;
      		}


	  		if(!validCheckBasePort(sheetObj, i, sheetObj.CellValue(i, "bse_port_def_cd"))) { //point와 비교
				sheetObj.CellBackColor(i, 'bse_port_def_cd') = validColor;
	  			sheetObj.CellBackColor(i, 'rcv_de_term_cd') = validColor;
	  			sheetObj.CellBackColor(i, 'rout_pnt_loc_def_cd') = validColor;
				validCnt++;
			}      		

      		
      		// D/Call
      		if(!validCheckDirectCall(sheetObj, i, sheetObj.CellValue(i, "via_port_def_cd"))) {
      			sheetObj.CellBackColor(i, 'dir_call_flg') = validColor;
      			validCnt++;
      		}

      		
      		// Per
      		if(!validCheckPerType(sheetObj, i, sheetObj.CellValue(i, "rat_ut_cd"))) { //Per(Rating Unit) 확인
      			sheetObj.CellBackColor(i, 'rat_ut_cd') = validColor;
      			validCnt++;
      		}

      		// Cargo Type
      		if(!validCheckCargoType(sheetObj, i, sheetObj.CellValue(i, "prc_cgo_tp_cd"))) { 
      			sheetObj.CellBackColor(i, 'prc_cgo_tp_cd') = validColor;
      			validCnt++;
      		}
      		
      		// Currency
      		if(!validCheckCurrency(sheetObj, i, sheetObj.CellValue(i, "curr_cd"))) {
      			sheetObj.CellBackColor(i, "curr_cd") = validColor;
      			validCnt++;
      		}
      		
      		// Proposal
      		if(!validCheckProposalFreightRateAmount(sheetObj, i, sheetObj.CellValue(i, "prop_frt_rt_amt"))) {
      			sheetObj.CellBackColor(i, "prop_frt_rt_amt") = validColor;
      			validCnt++;
      		}
 		}

         document.body.scroll = "no";
 		return validCnt;
 	}     
      
      
  /**
   * 엑셀파일을 로드한후  디비조회하여 validation 하는 함수 <br>
   * 잘못된 데이터 존재할때 색상처리한다. <br>
   * <br><b>Example :</b>
   * <pre>
   * 		checkDBCodeExist(sheetObj, formObj);
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {object} color 필수 IBSheet RgbColor
   * @return check
   * @author 최성민
   * @version 2009.05.17
   */
   function checkDBCodeExist(sheetObj, color) {
 	  	var check = 0;
 	  	var arbSeq = 0;
		for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if(sheetObjects[0].CellValue(i, "via_port_def_cd") != "") {
				if(sheetObj.CellValue(i, "via_port_def_cd") == "0"){
					sheetObjects[0].CellBackColor(i, "via_port_def_cd") = color;
					check ++;
				} else {
					if(sheetObjects[0].CellValue(i, "via_port_def_cd").length == 4) {
						sheetObjects[0].CellValue2(i, "via_port_tp_cd") = "G";
					} else if(sheetObjects[0].CellValue(i, "via_port_def_cd").length == 5) {
						sheetObjects[0].CellValue2(i, "via_port_tp_cd") = "L";
					}
				}
			}
							
			if(sheetObj.CellValue(i, "rout_pnt_loc_def_cd") == "0"){
				sheetObjects[0].CellBackColor(i, "rout_pnt_loc_def_cd") = color; 
				check ++;
			} else {
				sheetObjects[0].CellValue2(i, "rout_pnt_loc_tp_cd") = "L";
			}
			
			if(sheetObj.CellValue(i, "bse_port_def_cd") == "0"){
				sheetObjects[0].CellBackColor(i, "bse_port_def_cd") = color;
				check ++;
			} else {
				if(sheetObjects[0].CellValue(i, "bse_port_def_cd").length == 4) {
					sheetObjects[0].CellValue2(i, "bse_port_tp_cd") = "G";
				} else if(sheetObjects[0].CellValue(i, "bse_port_def_cd").length == 5) {
					sheetObjects[0].CellValue2(i, "bse_port_tp_cd") = "L";
				}
			}
			
			if(sheetObjects[0].CellValue(i, "prc_cmdt_def_cd") != "") {
				if(sheetObj.CellValue(i, "prc_cmdt_def_cd") == "0"){
					sheetObjects[0].CellBackColor(i, "prc_cmdt_def_cd") = color;
					check ++;
				} else {
					if(sheetObjects[0].CellValue(i, "prc_cmdt_def_cd").length == 5) {
						sheetObjects[0].CellValue2(i, "prc_cmdt_tp_cd") = "G";
					} else if(sheetObjects[0].CellValue(i, "prc_cmdt_def_cd").length == 6) {
						sheetObjects[0].CellValue2(i, "prc_cmdt_tp_cd") = "C";
					}
				}
			}			
			
		}
		
		return check;
   }      
   
//   /**
//    * 엑셀파일을 로드한후 로드한 데이터의 코드를 db에서 check한다. <br>
//    * 잘못된 데이터 존재할때 색상처리한다. <br>
//    * <br><b>Example :</b>
//    * <pre>
//    * 		searchCheckDBCodeExist(sheetObj, formObj);
//    * </pre>
//    * @author 최성민
//    * @version 2009.05.17
//    */   
//   function searchCheckDBCodeExist(){		
//	   var formObj = document.form;
//		formObj.f_cmd.value = SEARCH03;
// 		var sParam = FormQueryString(formObj);
// 		var sParamSheet1 = sheetObjects[0].GetSaveString();
//		sParam += "&" + sParamSheet1; 
//		var sXml = sheetObjects[3].GetSearchXml("ESM_PRI_0024GS.do", sParam);
// 		sheetObjects[3].LoadSearchXml(sXml);
//   }
     
     
	/* 개발자 작업  끝 */