/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0995.js
*@FileTitle : Pick up Notice Receiver Setup Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.07.14 박미옥
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
     * @class ESM_BKG_0995 : ESM_BKG_0995 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0995() {
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
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            case "btn_DownExcel":
            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	break;
            
            case "btn_LoadExcel":
            	doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
            	break;
            	
            case "btn_Setup":
            	doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;                      

            case "btn_close":
            	doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
                break; 
            
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    /**
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;                       
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
     * 
     * @return 없슴
     */
    function loadPage() {

        for(var i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            
            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
    }
    
    
    /**
     * Sheet1 인스턴스가 생성 완료될때 발생하는 Event 처리<br>
     * 
     * @return 없슴
     */
    function sheet1_OnLoadFinish(sheetObj) {
        doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }


     
    /**
     * Sheet2 엑셀 로드가 완료될때 발생하는 Event 처리<br>
     * 
     * @return 없슴
     */
    function sheet2_OnLoadExcel(sheetObj) {
        for (var i=sheetObj.RowCount; i>0; i--) {   
     		if (sheetObj.CellValue(i, "bl_no") == "" && sheetObj.CellValue(i, "cntr_no") == "") {
     			sheetObj.RowDelete(i, false);
     		}
     	}
     	
     	if(validateForm(sheetObjects[0],document.form,IBLOADEXCEL) == true) {
         	fncModifyReceiverInfo();
     	}
    }

     
    /**
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetId = sheetObj.id;
                                
        switch(sheetId) {
                
        case "sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 202;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 5, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(18, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                // [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
                InitHeadMode(false, false, false, true, false, false);

                var HeadTitle1 = "Status|Index|Seq.|B/L Detail|B/L Detail|B/L Detail|Customer|Customer|Customer|Customer|Broker/Husbanding Agent #1|Broker/Husbanding Agent #1|Broker/Husbanding Agent #1|Broker/Husbanding Agent #1|Broker/Husbanding Agent #2|Broker/Husbanding Agent #2|Broker/Husbanding Agent #2|Broker/Husbanding Agent #2";
                var HeadTitle2 = "Status|Index|Seq.|B/L No.|Container No.|Name|Fax No.||E-mail||Fax No.||E-mail||Fax No.||E-mail|";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,40,daCenter, true,   "ibflag");
                InitDataProperty(0, cnt++ , dtHidden,35,    daCenter,   true,   "row_idx",       false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtSeq,   35,    daCenter,   true,   "seq",           false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  85,    daCenter,   true,   "bl_no",         false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  85,    daCenter,   true,   "cntr_no",       false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  200,   daLeft,     true,   "cust_nm",       false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  120,   daCenter,   true,   "c2_fax_no",     false,  "",      dfNone,        0,              true,   true,        20);
                InitDataProperty(0, cnt++ , dtHidden,35,    daCenter,   true,   "c2_fax_snd_flg",false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  165,   daLeft,     true,   "c2_ntc_eml",    false,  "",      dfEngKey,      0,              true,   true,        200);
                InitDataProperty(0, cnt++ , dtHidden,35,    daCenter,   true,   "c2_eml_snd_flg",false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  120,   daCenter,   true,   "b1_fax_no",     false,  "",      dfNone,        0,              true,   true,        20);
                InitDataProperty(0, cnt++ , dtHidden,35,    daCenter,   true,   "b1_fax_snd_flg",false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  165,   daLeft,     true,   "b1_ntc_eml",    false,  "",      dfEngKey,      0,              true,   true,        200);
                InitDataProperty(0, cnt++ , dtHidden,35,    daCenter,   true,   "b1_eml_snd_flg",false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  120,   daCenter,   true,   "b2_fax_no",     false,  "",      dfNone,        0,              true,   true,        20);
                InitDataProperty(0, cnt++ , dtHidden,35,    daCenter,   true,   "b2_fax_snd_flg",false,  "",      dfNone,        0,              false,  false);                
                InitDataProperty(0, cnt++ , dtData,    0,   daLeft,     true,   "b2_ntc_eml",    false,  "",      dfEngKey,      0,              true,   true,        200);
                InitDataProperty(0, cnt++ , dtHidden,35,    daCenter,   true,   "b2_eml_snd_flg",false,  "",      dfNone,        0,              false,  false);

                InitDataValid(0, "c2_fax_no", vtNumericOther, "-");
                InitDataValid(0, "b1_fax_no", vtNumericOther, "-");
                InitDataValid(0, "b2_fax_no", vtNumericOther, "-");
                
                CountPosition = 0;
                                                                
            }
            
            break;

        case "sheet2":
            with (sheetObj) {

                // 높이 설정
                style.height = 0;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
                
                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(10, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                // [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
                InitHeadMode(false, false, false, true, false, false);

                var HeadTitle1 = "Seq.|B/L No.|Container No.|Name|Fax No.|E-mail|Fax No.|E-mail|Fax No.|E-mail";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,  35,    daCenter,   true,   "seq",           false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  85,    daCenter,   true,   "bl_no",         false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  85,    daCenter,   true,   "cntr_no",       false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  200,   daLeft,     true,   "cust_nm",       false,  "",      dfNone,        0,              false,  false);
                InitDataProperty(0, cnt++ , dtData,  120,   daCenter,   true,   "c2_fax_no",     false,  "",      dfNone,        0,              false,  false,        20);
                InitDataProperty(0, cnt++ , dtData,  165,   daLeft,     true,   "c2_ntc_eml",    false,  "",      dfEngKey,      0,              false,  false,        200);
                InitDataProperty(0, cnt++ , dtData,  120,   daCenter,   true,   "b1_fax_no",     false,  "",      dfNone,        0,              false,  false,        20);
                InitDataProperty(0, cnt++ , dtData,  165,   daLeft,     true,   "b1_ntc_eml",    false,  "",      dfEngKey,      0,              false,  false,        200);
                InitDataProperty(0, cnt++ , dtData,  120,   daCenter,   true,   "b2_fax_no",     false,  "",      dfNone,        0,              false,  false,        20);
                InitDataProperty(0, cnt++ , dtData,    0,   daLeft,     true,   "b2_ntc_eml",    false,  "",      dfEngKey,      0,              false,  false,        200);
                
                CountPosition = 0;
            }
            
            break;
        }
    }

    
    /**
     * Sheet관련 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return 없슴
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        
        sheetObj.WaitImageVisible = false;
        
        
        switch(sAction) {

        case IBSEARCH_ASYNC01: // Close
            if(validateForm(sheetObj,formObj,sAction) == false) {
            	if (ComShowCodeConfirm("BKG00168")) {
                	window.close();
            	}
            } else {
            	window.close();
            }
        
        	break;
        	
        	
        	
		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
    	    if (sheetObj.RowCount == 0) {
    		    ComShowCodeMessage("BKG00109"); 
    	        break;
    	    } else {
                sheetObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "", "",  true, true, "");
                //sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "",  true, true);
    	    }
		    break;
		    
		    
        	
        case IBLOADEXCEL:
        	sheetObjects[1].LoadExcel(1, 1, "", 2, -1, "", false, false, "");
        	break;
		    
        	
        	
        case IBSEARCH:      //조회
            if(validateForm(sheetObj,formObj,sAction) == false) break;
                              
            ComOpenWait(true);
            
            fncGetReceiverInfo(window.dialogArguments.receiverList);
            
            ComOpenWait(false);
                   
            break;

            
            
        case IBSAVE:        //저장
            if(validateForm(sheetObj,formObj,sAction) == false) break;
        
            ComOpenWait(true);
            
            window.returnValue = fncSetReceiverInfo();
            
            ComOpenWait(false);

        	window.close();

        	break;

        }
    }
        
    
    /**
     * 엑셀 업로드된 데이터를 화면 Sheet 에 업데이트 한다.<br>
     * 
     * @return 없슴
     */
    function fncModifyReceiverInfo() {
    	var orgSheet = sheetObjects[0];
    	var tmpSheet = sheetObjects[1];
    	
    	for (var i=0; i<orgSheet.RowCount; i++) {    		
    		if (orgSheet.CellEditable(i+2, "c2_fax_no"))  orgSheet.CellValue2(i+2, "c2_fax_no")  = tmpSheet.CellValue(i+1, "c2_fax_no");
    		if (orgSheet.CellEditable(i+2, "b1_fax_no"))  orgSheet.CellValue2(i+2, "b1_fax_no")  = tmpSheet.CellValue(i+1, "b1_fax_no");
    		if (orgSheet.CellEditable(i+2, "b2_fax_no"))  orgSheet.CellValue2(i+2, "b2_fax_no")  = tmpSheet.CellValue(i+1, "b2_fax_no");    		
    		if (orgSheet.CellEditable(i+2, "c2_ntc_eml")) orgSheet.CellValue2(i+2, "c2_ntc_eml") = tmpSheet.CellValue(i+1, "c2_ntc_eml");
    		if (orgSheet.CellEditable(i+2, "b1_ntc_eml")) orgSheet.CellValue2(i+2, "b1_ntc_eml") = tmpSheet.CellValue(i+1, "b1_ntc_eml");
    		if (orgSheet.CellEditable(i+2, "b2_ntc_eml")) orgSheet.CellValue2(i+2, "b2_ntc_eml") = tmpSheet.CellValue(i+1, "b2_ntc_eml");
    	}
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(sheetObj,formObj,sAction){
         with(sheetObj) {
         	switch(sAction) {

         	case IBSEARCH_ASYNC01:
                if (ComIsModifiedSheets(sheetObj)) {
                	return false;
            	}
                
                break;
         		
        	case IBSAVE:
                if (ComIsModifiedSheets(sheetObj) == false) {
                	ComShowCodeMessage("BKG00743");
                	return false;
            	}
                
    		    for(var i=0; i<RowCount; i++) {    		    	
	                // E-mail 형식 체크
		    		if (CellValue(i+2, "c2_ntc_eml") != "" && ComIsEmailAddr(CellValue(i+2, "c2_ntc_eml")) == false) {
		    			ComShowCodeMessage("BKG04006");
		    			SelectCell(i+2, "c2_ntc_eml");
		    			return false;
		    		} 

		    		if (CellValue(i+2, "b1_ntc_eml") != "" && ComIsEmailAddr(CellValue(i+2, "b1_ntc_eml")) == false) {
		    			ComShowCodeMessage("BKG04006");
		    			SelectCell(i+2, "b1_ntc_eml");
		    			return false;
		    		} 

		    		if (CellValue(i+2, "b2_ntc_eml") != "" && ComIsEmailAddr(CellValue(i+2, "b2_ntc_eml")) == false) {
		    			ComShowCodeMessage("BKG04006");
		    			SelectCell(i+2, "b2_ntc_eml");
		    			return false;
		    		} 
    		    }
                
        		break;
        		
    	    /* 엑셀 데이터의 유효성을 검증한다.
    	     * 화면 Sheet 데이터와 일치하는지 검증한다.(데이터 건수 비교. 키 데이터 비교)
    	     */
        	case IBLOADEXCEL:
        	    	
    	    	var tmpSheet = sheetObjects[1];
    	    	
    	    	if (RowCount != tmpSheet.RowCount) {
    	    		ComShowCodeMessage("BKG04001");
    	    		return false;
    	    	}
    	    	
    	    	for (var i=0; i<RowCount; i++) {
    	    		if ( (CellValue(i+2, "seq") != tmpSheet.CellValue(i+1, "seq")) ||  
    	    		     (CellValue(i+2, "bl_no") != tmpSheet.CellValue(i+1, "bl_no")) || 
    	    		     (CellValue(i+2, "cntr_no") != tmpSheet.CellValue(i+1, "cntr_no")) ||
    	    		     (CellValue(i+2, "cust_nm") != tmpSheet.CellValue(i+1, "cust_nm")) ) {
        	    		ComShowCodeMessage("BKG04005");
    	    			return false;
    	    		}    	    		
    	    	}

    	    	break;        		
            }
        }
         	
        return true;
    }

    /**
     * 메인 화면으로부터 Receiver 정보를 가져와 Sheet 를 구성한다.
     * 
     * @param {array} arrReceiverInfo 필수. Receiver 정보를 담고 있는 배열
     * @return 없슴
     */
    function fncGetReceiverInfo(arrReceiverInfo) {
    	var info = null;
        var vRow = -1;
        
        with (sheetObjects[0]) {
        	for (var i=0; i<arrReceiverInfo.length; i++) {
        		info = arrReceiverInfo[i];
        		
            	vRow = DataInsert();
            	
            	CellValue2(vRow, "row_idx")        = info.seq;
            	CellValue2(vRow, "bl_no")          = info.bl_no;
            	CellValue2(vRow, "cntr_no")        = info.cntr_no;
            	CellValue2(vRow, "cust_nm")        = info.cust_nm;
            	CellValue2(vRow, "c2_fax_no")      = info.c2_fax_no;
            	CellValue2(vRow, "c2_fax_snd_flg") = info.c2_fax_snd_flg;            	
            	CellValue2(vRow, "b1_fax_no")      = info.b1_fax_no;
            	CellValue2(vRow, "b1_fax_snd_flg") = info.b1_fax_snd_flg;            	
            	CellValue2(vRow, "b2_fax_no")      = info.b2_fax_no;
            	CellValue2(vRow, "b2_fax_snd_flg") = info.b2_fax_snd_flg;            	
            	CellValue2(vRow, "c2_ntc_eml")     = info.c2_ntc_eml;
            	CellValue2(vRow, "c2_eml_snd_flg") = info.c2_eml_snd_flg;
            	CellValue2(vRow, "b1_ntc_eml")     = info.b1_ntc_eml;
            	CellValue2(vRow, "b1_eml_snd_flg") = info.b1_eml_snd_flg;
            	CellValue2(vRow, "b2_ntc_eml")     = info.b2_ntc_eml;
            	CellValue2(vRow, "b2_eml_snd_flg") = info.b2_eml_snd_flg;
            	
        		CellValue2(vRow, "ibflag") = "R";

        		// Fax Notice 대상 여부
        		if (CellValue(vRow, "c2_fax_snd_flg") == "N") {
        			CellEditable(vRow, "c2_fax_no") = false;
        		}
        		if (CellValue(vRow, "b1_fax_snd_flg") == "N") {
        			CellEditable(vRow, "b1_fax_no") = false;
        		}
        		if (CellValue(vRow, "b2_fax_snd_flg") == "N") {
        			CellEditable(vRow, "b2_fax_no") = false;
        		}

        		// Email Notice 대상 여부
        		if (CellValue(vRow, "c2_eml_snd_flg") == "N") {
        			CellEditable(vRow, "c2_ntc_eml") = false;
        		}
        		if (CellValue(vRow, "b1_eml_snd_flg") == "N") {
        			CellEditable(vRow, "b1_ntc_eml") = false;
        		}
        		if (CellValue(vRow, "b2_eml_snd_flg") == "N") {
        			CellEditable(vRow, "b2_ntc_eml") = false;
        		}
        		
                //CellBackColor(vRow, "bl_no") = RgbColor(239,235,239);
        	}
        	
            SelectCell(2, 1);
        }
    }
        
    /**
     * Receiver 정보를 배열로 구성한다. <br>
     * 
     * @return  Receiver 배열 
     */
    function fncSetReceiverInfo() {
    	var arrInfo = new Array();
    	var idx = 0;
    	var info = null;
    	var vFomCd = document.form.fom_cd.value;

    	with(sheetObjects[0]) {
        	for (var i=0; i<RowCount; i++) {
        		info = new Object();
        		
        		info.fom_cd     = vFomCd;
        		
        		info.seq        = CellValue(i+2, "row_idx");
        		info.bl_no      = CellValue(i+2, "bl_no");
        		info.cntr_no    = CellValue(i+2, "cntr_no");
        		info.cust_nm    = CellValue(i+2, "cust_nm");
        		info.c2_fax_no  = CellValue(i+2, "c2_fax_no");
        		info.b1_fax_no  = CellValue(i+2, "b1_fax_no");
        		info.b2_fax_no  = CellValue(i+2, "b2_fax_no");
        		info.c2_ntc_eml = CellValue(i+2, "c2_ntc_eml");
        		info.b1_ntc_eml = CellValue(i+2, "b1_ntc_eml");
        		info.b2_ntc_eml = CellValue(i+2, "b2_ntc_eml");
        		
        		arrInfo[idx++] = info;       	
        	}
    	}

    	return arrInfo;
    }
    
    /* 개발자 작업  끝 */