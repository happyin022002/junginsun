/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_BKG_S003.js
*@FileTitle : SAC Master Data (India)
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.28 송민석
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
     * @extends Pri
     * @class ESM_BKG_S003 : MDM Charge 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_S003() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;
    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 송민석
     * @version 2017.07.07
     */  
      function initControl() {
          axon_event.addListenerForm ('keydown', 'obj_keydown', document.form);
      }
      
 /**
     * OnKeyDown event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 송민석
     * @version 2017.07.07
     */ 
   function obj_keydown(){
       //enter key조회
       var eleName = event.srcElement.name;
       var keyValue = null;
       if(event == undefined || event == null) {
           keyValue = 13;
       }else{
           keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
       }
       if (keyValue == 13){
           switch (eleName){
               case "ida_sac_cd":
        
                   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
               break;
           }        
       }
   }     


	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * processButtonClick();
     * </pre>
     * 
     * @return 없음
     * @author 송민석
     * @version 2017.06.28
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    	var sheetObject1 = sheetObjects[0];
 
    	/** **************************************************** */
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

 
	
	    		case "btn_Retrieve":
	    			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	    			break;
	
	    		case "btn_Save":
	    			doActionIBSheet(sheetObject1,formObject,IBSAVE);
	    			break;

    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
        } finally {
            ComOpenWait(false);
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
     * @author 송민석
     * @version 2017.06.28
     */
    function setSheetObject(sheet_obj){

    	sheetObjects[sheetCnt++] = sheet_obj;

    }
    /**
     * IBMulti Combo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
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
     * @author 송민석
     * @version 2017.06.28
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
        	    //khlee-시작 환경 설정 함수 이름 변경
        		ComConfigSheet (sheetObjects[i] );
        		initSheet(sheetObjects[i],i+1);
        		// khlee-마지막 환경 설정 함수 추가
        		ComEndConfigSheet(sheetObjects[i]);

        	}
            
            //IBMultiCombo초기화
            for(var k = 0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
        
        ComBkgTextCode2ComboItem(chargeListValue, chargeListText, getComboObject(comboObjects, 'chg_cd') ,"|","\t" );
        initControl();
    }
    

    /**
     * Combo 기본 설정, Combo의 항목을 설정한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */        
    function initCombo(comboObj, comboNo) {

        switch(comboObj.id) {
          
            case "chg_cd":
                var i=0;
                with(comboObj) {
                    //BackColor = "cyan";
                    DropHeight = 500;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    SetColWidth("70|350");
                }
                break;     
                  
                      
        }
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
     * @author 송민석
     * @version 2017.06.28
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	switch(sheetNo) {
        	case 1:      // sheet1 init
            	with (sheetObj) {
        	    
            		// 높이 설정
            		style.height = 480;
            		// 전체 너비 설정
            		SheetWidth = mainTable.clientWidth;
                    
            		// Host정보 설정[필수][HostIp, Port, PagePath]
            		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
            		// 전체Merge 종류 [선택, Default msNone]
            		MergeSheet = msNone;
                    
            		// 전체Edit 허용 여부 [선택, Default false]
            		Editable = true;
                     
            		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            		InitRowInfo( 1, 1, 3, 100);
                    
            		// 해더에서 처리할 수 있는 각종 기능을 설정한다
            		InitHeadMode(true, true, true, true, false,false)
        
            		var HeadTitle = "|Seq.|CHG Code|Revenue Charge Head|SAC|SAC Description|CHG Code Name(MDM)";
            		
            		var headCount = ComCountHeadTitle(HeadTitle);
        
            		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            		InitColumnInfo(headCount, 0, 0, true);
        
            		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            		InitHeadRow(0, HeadTitle, true);

        
            		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
                    // POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
                    // FORMATFIX]
            		InitDataProperty(0, cnt++ , dtHiddenStatus,		30,	daCenter,	false,	"ibflag");
        			InitDataProperty(0, cnt++ , dtDataSeq,			30,	daCenter,	true,	"Seq");
            		InitDataProperty(0, cnt++ , dtData,		  		80,	daCenter,	true,	"chg_cd",	false,	"",		dfNone,		0,			false,		true,	3,	true);
                    InitDataProperty(0, cnt++ , dtData,             200, daLeft,     true,   "ida_chg_nm",  false,    "",     dfNone,     0,          true,       true,   50);
                    InitDataProperty(0, cnt++ , dtPopupEdit,             80, daCenter,   true,   "ida_sac_cd",   false,   "",     dfNone,     0,          true,      true,   6,true);
                    InitDataProperty(0, cnt++ , dtData,             200, daLeft,     true,   "ida_sac_nm",  false,    "",     dfNone,     0,          false,       false,   500);
                    InitDataProperty(0, cnt++ , dtData,             200,    daLeft,     true,   "chg_nm",  false,    "",     dfNone,     0,          false,      true,   50);

             		WaitImageVisible = false;
             	}
            	break;

    	}
    }
    
    

    /**
    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    * SAC 코드 조회시 호출한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 송민석
    * @version 2017.07.06
    */      
    function sheet1_OnPopupClick(sheetObj, Row, Col)
    {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
          
        switch(colName)
        {
            case "ida_sac_cd":
                
                
                var sParam = "";
                var rtnVal = ComOpenWindowCenter("/hanjin/ESM_BKG_S005.do?"+sParam, "ESM_BKG_S005", 640, 715, true);      
                if (rtnVal != null){
                    sheetObj.CellValue2(Row, "ida_sac_cd") = rtnVal.cd;
                    sheetObj.CellValue2(Row, "ida_sac_nm") = rtnVal.nm;
                  
                }     
                break;
                 
        }
    }    
    

    /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * SAC code 을 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 송민석
    * @version 2017.07.06
    */  
    function sheet1_OnChange(sheetObj, Row, Col)
    {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
          
        switch(colName)
        {
                 
            case "ida_sac_cd":
                                                
                var cd = sheetObj.CellValue(Row,"ida_sac_cd");
                var sParam = "ida_sac_cd="+cd +"&f_cmd="+COMMAND21;

                var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", sParam);
                var idaSacNm = ComGetEtcData(sXml, "ida_sac_nm");
                sheetObj.CellValue2(Row,"ida_sac_nm") = idaSacNm;
                if(idaSacNm === undefined || idaSacNm == ""){
                    sheetObj.CellValue2(Row,"ida_sac_cd") = "";
                }
                break;
             
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
     * @author 송민석
     * @version 2017.06.28
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

	    	case IBSEARCH:      //조회
	    	    ComOpenWait(true);
	    		if ( sheetObj.id == "sheet1"){
	    		    ComOpenWait(true);
	    			formObj.f_cmd.value = SEARCH01;
	    			sheetObj.DoSearch("ESM_BKG_S003GS.do", FormQueryString(formObj));
	    			ComOpenWait(false);
	    		}
	    		ComOpenWait(false);
		    	break;

	    	case IBSAVE:        //저장
	    	    if(!validateForm(sheetObj,formObj,sAction)){
                    return;
                }
	    	    ComOpenWait(true);
	            if (!ComShowConfirm(ComGetMsg("BKG00824")))
	                return; // Are you sure to save the changes?

		    	formObj.f_cmd.value = MULTI01;
		    	sheetObj.DoSave("ESM_BKG_S003GS.do", FormQueryString(formObj), -1, false);
		    	ComOpenWait(false);
		    	break;
	
 
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
     * @author 송민석
     * @version 2017.06.28
     */
    function validateForm(sheetObj,formObj,sAction){

    	with(sheetObj){
    	     
    	}

    	return true;
    }

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장 시 에러났을 경우 삭제된 Row 를 원래대로 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 송민석
     * @version 2017.06.28
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) != "S") {
            // 저장시 에러났을 경우 삭제된 Row 를 원래대로 보여줌
            var sRow = sheetObj.FindStatusRow("D");
            var arRow = sRow.split(";");
            for (var i = 0, n = arRow.length-1 ; i < n ; i++) {
                sheetObj.RowHidden(arRow[i]) = false;
                sheetObj.RowStatus(arRow[i]) = "R";
            }
        }
    }
    /* 개발자 작업  끝 */