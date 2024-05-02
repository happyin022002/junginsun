/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_APR_0S2.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : SSY
*@LastVersion : 1.0
* 2009.11.10 정인선
* 1.0 최초 생성
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
    function COM_APR_0S2() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }

    //공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
	var comboCnt = 0;
	var pgm_No = "";
	var cellRow = 0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        
        /*******************************************************/
        var formObject = document.form;
        
        try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		 

    		switch (srcName) {

    	
    	    	
    		case "btn_Close":
               window.close();
    	    	
    	    	break;
    	    	
    		case "btn_t1rowAdd":
	        	sheetObject.DataInsert(-1);
				
				break;
				
	        case "btn_t1rowDel":
				for(var i = 1; i <= sheetObject.Rows; i++){
					if(sheetObject.CellValue(i,"checkbox") == 1){
						sheetObject.RowHidden(i) = true;
						sheetObject.CellValue(i,"ibflag")="D";
					}
				}
				
				break;
				
	        case "btn_save":
	        	doActionIBSheet(sheetObject,formObject,IBSAVE);
				window.close();
				break;
    	    	
    	    	
    	    	
    		}
        }catch(e) {
    		if( e == "[object Error]") {
    			showErrMessage(getMsg('CSR23028')); //ComShowMessage(OBJECT_ERROR);
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
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
      //IBMultiCombo 초기화
		for(var k = 0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
		alert(document.form.modify.value);
		if(document.form.modify.value == 1){
			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		}
    }


    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false] 
                    Editable = true;
                    
                    MultiSelection = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				 InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

    				var HeadTitle1 = "||System|UI ID|Menu|Program Remarks|Field Name|Field ID|Button Name|Button ID|App Type|Detail Url" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    sheetObj.FrozenCols = 2;
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHiddenStatus,       20,     daCenter , false,   "ibflag",     false,          "");				
    				InitDataProperty(0, cnt++ , dtCheckBox,           30,     daCenter , true,   "checkbox",     false,          "");
    				InitDataProperty(0, cnt++ , dtCombo,			 80,	  daCenter,			false,    "sub_sys_cd_auth",				false,			"",			dfNone);
    				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "pgm_no",				false,			"",			dfNone);
    				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "pgm_nm",				false,			"",			dfNone,			0,			false,			false);
    				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "pgm_rmk",				false,			"",			dfNone);
    				InitDataProperty(0, cnt++ , dtData	,			 150, 	  daCenter,			false,    "pgm_fld_nm",				false,			"",			dfNone);
    				InitDataProperty(0, cnt++ , dtData,				 150, 	  daCenter,			false,    "pgm_fld_id",				false,			"",			dfNone);
    				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "pgm_btn_nm",				false,			"",			dfNone);
    				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "pgm_btn_id",				false,			"",			dfNone);
    				InitDataProperty(0, cnt++ , dtCombo,			 150,	  daCenter,			false,    "auth_apro_tp_cd",				false,			"",			dfNone);
    				InitDataProperty(0, cnt++ , dtData,				 150,	  daCenter,			false,    "dtl_pgm_url_ctnt",				false,			"",			dfNone);
    				
    				
    				InitDataCombo(0, "sub_sys_cd_auth", " |"+sub_sys_cd_auth, " |"+sub_sys_cd_auth, " ");
    				InitDataCombo(0, "auth_apro_tp_cd", " |After|Before", " |AF|BF", " ");
    				DataInsert(-1);
    				InitDataValid(0,"pgm_no",vtEngUpOther,"_1234567890");
             	}
                break;
        }
    }

    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //조회
    			formObj.f_cmd.value = SEARCH01;
    			var sXml = sheetObj.getSearchXml("COM_APR_0S2GS.do",FormQueryString(formObj)+"&pgm_no="+pgm_No);
    			var pgm_NM = ComGetEtcData(sXml , "PGM_NM");
    			sheetObj.CellValue(cellRow,"pgm_nm") = pgm_NM;
    		    break;
    		    
           case IBSAVE:        //전송
    			formObj.f_cmd.value = MULTI;
    			var param = sheetObj.GetSaveString();
    			var sXml = sheetObj.GetSaveXml("COM_APR_0S2GS.do", param + "&" + FormQueryString(formObj));
    			sheetObj.LoadSaveXml(sXml,true);
                break;
                
           case SEARCH01:        //조회
   				formObj.f_cmd.value = COMMAND01;
   				alert(FormQueryString(formObj));
   				sheetObj.DoSearch("COM_APR_0S2GS.do", FormQueryString(formObj));
//   				var sXml = sheetObj.GetSaveXml("COM_APR_0S2GS.do", FormQueryString(formObj));
//   				sheetObj.LoadSaveXml(sXml,true);
   				break;
          
        }
    }


    function sheet1_OnSearchEnd() {
    	var sheetObj = sheetObjects[0];
    	
    	
    }

    function sheet1_OnChange(sheetObj , row , col, value)
    {
    	var formObj = document.form;
    	var sName = sheetObj.ColSaveName(col);
    	cellRow = row;
    	//기존 로직 
    	if (sName == "pgm_no") {
    		pgm_No = sheetObj.cellvalue(row,"pgm_no");
    		doActionIBSheet(sheetObj, formObj, IBSEARCH);							
    			
    	}
    	
    }