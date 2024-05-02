/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4017.js
*@FileTitle : Service Scope Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.07 김재연
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
     * @class ESM_PRI_4017 : ESM_PRI_4017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4017() {
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
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.07
     */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2]; 
        var sheetObject4 = sheetObjects[3];
        var sheetObject5 = sheetObjects[4];
        /*******************************************************/
        var formObject = document.form;

        try {
        	var srcName = window.event.srcElement.getAttribute("name");

        	switch(srcName) {
                    
        		case "btn_retrieve":
        			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;

                case "btn_new":
                	formObject.org_cd.value = "";
                	formObject.dest_cd.value = "";
                	sheetObject1.RemoveAll();
                	sheetObject2.RemoveAll();
                	sheetObject3.RemoveAll();
                	sheetObject4.RemoveAll();
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
     * @version 2009.10.07
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
     * @version 2009.10.07
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
        	ComConfigSheet (sheetObjects[i] );

        	initSheet(sheetObjects[i],i+1);
        	
        	//khlee-마지막 환경 설정 함수 추가
        	ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
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
     * @version 2009.10.07
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch (sheetObj.id) {
        
        	case "sheet1":
        		
                with (sheetObj) {

                    // 높이 설정
                    style.height = 140;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Scope|Description|FMC File|Tariff No|Conference|Bound|Update Date";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,	100,	daCenter,  	false,   "svc_scp_cd",		false,  "",	dfNone);
                    InitDataProperty(0, cnt++, dtData,  250,   	daCenter,  	false,   "svc_scp_nm",  	false,  "", dfNone);
					InitDataProperty(0, cnt++, dtData,  110,   	daCenter,   false,   "fmc_file_flg",    false,  "", dfNone);
                    InitDataProperty(0, cnt++, dtData,  110,   	daCenter,  	false,   "trf_no",   		false,  "", dfNone);
                    InitDataProperty(0, cnt++, dtData,  110,   	daCenter,  	false,   "conf_flg",   		false,  "", dfNone);
					InitDataProperty(0, cnt++, dtData,  110,   	daCenter,   false,   "svc_scp_bnd_cd",  false,  "", dfNone);
                    InitDataProperty(0, cnt++, dtData,  110,   	daCenter,	false,   "upd_dt",   		false,	"", dfDateYmd);
                    
                    AutoRowHeight = false;
                    WaitImageVisible = false;
               }
               break;

        	case "sheet2":
        		
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Lane|Description";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,	100,   	daCenter,	true,   "vsl_slan_cd",	false,  "",	dfNone);
                    InitDataProperty(0, cnt++, dtData,  50,		daCenter,  	true,	"vsl_slan_nm",  false,	"", dfNone);
                    
                    AutoRowHeight = false;
                    WaitImageVisible = false;
               }
               break; 
               
        	case "sheet3":
        		
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Origin Region|Description|Service Scope Indicator";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,	120,  	daCenter,	true,	"rgn_cd",   		false,	"", dfNone);
                    InitDataProperty(0, cnt++, dtData,  150,    daCenter,  	true,   "rgn_nm",   		false,  "", dfNone);
                    InitDataProperty(0, cnt++, dtData,  150,	daCenter,  	true,   "svc_scp_ind_flg",	false,  "",	dfNone);
                    
                    AutoRowHeight = false;
                    WaitImageVisible = false;
               }
               break;   
                
        	case "sheet4":
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
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Destination Region|Description|Service Scope Indicator";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,	120,  	daCenter,	true,	"rgn_cd",   		false,	"", dfNone);
                    InitDataProperty(0, cnt++, dtData,  150,    daCenter,  	true,   "rgn_nm",   		false,  "", dfNone);
                    InitDataProperty(0, cnt++, dtData,  150,	daCenter,  	true,   "svc_scp_ind_flg",	false,  "",	dfNone);
                    
                    AutoRowHeight = false;
                    WaitImageVisible = false;
               }
               break;
               
        	case "sheet5":
        		with (sheetObj) {
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(1, 0, 0, true);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, "", true);
	                
	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtStatus, 60, daCenter, false, "ibflag");
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
     * @author 김재연
     * @version 2009.10.07
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
    	sheetObj.ShowDebugMsg = false;
    	
    	switch(sAction) {

    		case IBSEARCH:
    			ComOpenWait(true);
    			if(!validateForm(sheetObj,formObj,sAction)) {
    				ComOpenWait(false);
    				return false;
    	  		}
    	  	
    	  		formObj.f_cmd.value = SEARCH01;
    	  		sheetObj.DoSearch("ESM_PRI_4017GS.do", FormQueryString(formObj));
                break;
                
    		case IBSEARCH_ASYNC01:
    			ComOpenWait(true);
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
		  			return false;
		  		}
				
				var svcScpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "svc_scp_cd");

		  		formObj.f_cmd.value = SEARCH02;
		  		sheetObj.DoSearch("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd);
	            break;
	            
    		case IBSEARCH_ASYNC02:
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
		  			return false;
		  		}
				
				var svcScpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "svc_scp_cd");
		  		formObj.f_cmd.value = SEARCH03;
		  		sheetObj.DoSearch("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd+"&org_dest_cd=O");
	            break;
	       
    		case IBSEARCH_ASYNC03:
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
					return false;
		  		}
				
				var svcScpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "svc_scp_cd");
		  		formObj.f_cmd.value = SEARCH03;
		  		sheetObj.DoSearch("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd+"&org_dest_cd=D");
		  		ComOpenWait(false);
	            break;
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
     * @version 2009.10.07
     */ 	
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
 		}
 	}   
    
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)<br>
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
     * @version 2009.10.07
     */ 
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
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
     * @version 2009.10.07
     */ 	
  	function sheet2_OnSearchEnd(sheetObj, errMsg)  {
  		if (errMsg == "") {
 			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
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
     * @version 2009.10.07
     */ 	
  	function sheet3_OnSearchEnd(sheetObj, errMsg)  {
  		if (errMsg == "") {
 			doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC03);
 		}
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
 	 * @version 2009.10.07
 	 */
  	function initControl() {
  		//** Date 구분자 **/
  		DATE_SEPARATOR = "/";
  	
  		//Axon 이벤트 처리1. 이벤트catch
  		axon_event.addListenerForm('blur', 'obj_blur', form);
  		axon_event.addListenerForm('change', 'obj_change', form);
  		axon_event.addListenerForm('keypress', 'obj_keypress', form);
  		axon_event.addListener('keydown', 'getKeyEnter', 'form');
  	}
  	
 	/**
     * HTML태그(Object)의 onKeyDown 이벤트에서 이 함수를 호출할수 있으며, Enter키를 눌렀을때 자동화 기능을 처리한다. <br>
     * 인자로 사용되는 sFlag 인자의 설정값은 다음과 같다. <br>
     * sFlag = 설정안한경우      : sFlag="Search"의 경우와 동일하게 처리한다.<br>
     * sFlag = "Search"          : Enter키가 누르면 조회버튼(btn_Retrieve 또는 btn_retrieve)이 눌린것처럼 처리한다.OnKeyDown에서 호출할것!<br>
     * sFlag = "NextFocus"       : Enter키를 누르면 Tab키를 누른것 처럼 다음 입력필드로 포커스를 이동한다.OnKeyDown에서 호출할것!<br>
     * sFlag = "LengthNextFocus" : 입력필드의 maxlength길이만큼 모두 입력되면 자동으로 포커스를 다음으로 이동하고, Enter키를 누르면 길이에 관계없이 Tab을 누른것처럼 옆으로 이동한다. OnKeyUp에서 호출할 것!<br>
     * sFlag = Function명문자열  : 특정Function명 문자열을 인자로 받아서 Enter키를 누르면 해당 함수를 호출한다. OnKeyDown에서 호출할 것!<br>
     * sFlag = "LengthNextFocus"는 OnKeyUp이벤트에서 호출하여야 하고, 나머지는 모두 OnKeyDown이벤트에서 호출해야 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;form name="form" onKeyDown="ComKeyEnter()"&gt; 					//조회조건Form에서 주로 사용
     *     &lt;form name="form" onKeyDown="ComKeyEnter('NextFocus')"&gt;		//저장Form에서 주로 사용
     *     &lt;form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')"&gt;	//저장Form에서 주로 사용
     * </pre>
     * @param {string} sFlag 선택,키처리 구분, default="Search"
     * @see #ComSetNextFocus
     */
    function getKeyEnter(sFlag)
    {
      	var formObj = document.form;
      	
       	try {
       		var keyValue = null;
           	if(event == undefined || event == null) {
           		keyValue = 13;
           	} else {
           		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
           	}
           	
           	if (keyValue != 13) return;
       		var obj = document.getElementById("btn_retrieve");
       		if (obj == null) obj = document.getElementById("btn_retrieve");
       		if (obj) obj.fireEvent("onclick");
         } catch(err) { ComFuncErrMsg(err.message); }
    }
     
  	/**
     * OnBlur 이벤트 발생시 호출되는 function <br>
     * 현재 일보다 이후의 날짜를 입력하지 않게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.07
     */
 	function obj_blur(){
 		srcName = event.srcElement.name;
 		srcValue = event.srcElement.value;
 		formObj = document.form;
 		
 		if(srcValue == "") {
 			return;
 		}
 		
 		switch(srcName) {
 			case "org_cd":
 				if(formObj.org_tp_cd.value != "S") {
 					if(srcValue.length == 2) {
 						formObj.org_tp_cd.value = 'C';
 					}else if(srcValue.length == 3) { 
 						formObj.org_tp_cd.value = 'R';
 					} else if(srcValue.length == 5) {
 						formObj.org_tp_cd.value = 'L';
 					}
 				}
 				formObj.f_cmd.value = SEARCH04;
		  		formObj.cd.value = formObj.org_cd.value;
		  		sXml = sheetObjects[4].getSearchXml("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&org_dest_cd=O");
		  		if(ComGetEtcData(sXml, "FLAG") == "N") {
		  			formObj.org_cd.value = "";
		  			formObj.org_cd.focus();
		  		} else {
		  			formObj.dest_cd.focus();
		  		}
 				break;
 				
 			case "dest_cd":
 				if(formObj.dest_tp_cd.value != "S") {
 					if(srcValue.length == 2) {
 						formObj.dest_tp_cd.value = 'C';
 					}else if(srcValue.length == 3) { 
 						formObj.dest_tp_cd.value = 'R';
 					} else if(srcValue.length == 5) {
 						formObj.dest_tp_cd.value = 'L';
 					}
 				}
 				formObj.f_cmd.value = SEARCH04;
		  		formObj.cd.value = formObj.dest_cd.value;
		  		sXml = sheetObjects[4].getSearchXml("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&org_dest_cd=D");
		  		if(ComGetEtcData(sXml, "FLAG") == "N") {
		  			formObj.dest_cd.value = "";
		  		}
 				break;
 		}
 	}
 	
 	/** 
	 * Object 의 OnChange 이벤트핸들러 <br>
	 * code 초기화  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.10.07
	 */ 
 	function obj_change(){
 		srcName = event.srcElement.name;
 		srcValue = event.srcElement.value;
 		formObj = document.form;
 		
 		switch(srcName) {
 			case "org_tp_cd":
 				formObj.org_cd.value = "";
 				break;
 			case "dest_tp_cd":
 				formObj.dest_cd.value = "";
 				break;
 		}		
 	}
 	
 	/** 
	 * Object 의 Keypress 이벤트핸들러 <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.10.07
	 */ 
  	function obj_keypress() {
  		 switch (event.srcElement.name) {
  		//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정 ComKeyOnlyAlphabet('upper') => uppernum
  			case "org_cd":
  				ComKeyOnlyAlphabet('uppernum');
  				break;
  				
  			case "dest_cd":
  				ComKeyOnlyAlphabet('uppernum');
  				break;
  		}
  	}
  	
	/**
     * Origin Code, Destination Code의 유효성을 조회하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.07
     */
 	function checkOriDestCd(){
    	var formObj = document.form;
    	var orgCd = formObj.org_cd.value; 
    	var destCd = formObj.dest_cd.value;

		if(formObj.org_tp_cd.value != "S") {
			if(orgCd.length == 2) {
				formObj.org_tp_cd.value = 'C';
			}else if(orgCd.length == 3) { 
				formObj.org_tp_cd.value = 'R';
			} else if(orgCd.length == 5) {
				formObj.org_tp_cd.value = 'L';
			}
		}
		
		formObj.f_cmd.value = SEARCH04;
  		formObj.cd.value = orgCd;
  		sXml = sheetObjects[4].getSearchXml("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&org_dest_cd=O");
  		if(ComGetEtcData(sXml, "FLAG") == "N") {
  			formObj.org_cd.value = "";
	  		formObj.org_cd.focus();
	  		return false;
  		}
  		
		if(formObj.dest_tp_cd.value != "S") {
			if(destCd.length == 2) {
				formObj.dest_tp_cd.value = 'C';
			}else if(destCd.length == 3) { 
				formObj.dest_tp_cd.value = 'R';
			} else if(destCd.length == 5) {
				formObj.dest_tp_cd.value = 'L';
			}
		}
		formObj.f_cmd.value = SEARCH04;
  		formObj.cd.value = destCd;
  		sXml = sheetObjects[4].getSearchXml("ESM_PRI_4017GS.do", FormQueryString(formObj)+"&org_dest_cd=D");
  		if(ComGetEtcData(sXml, "FLAG") == "N") {
  			formObj.dest_cd.value = "";
  			formObj.dest_cd.focus();
  			return false;
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
     * @author 김재연
     * @version 2009.10.07
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch (sAction) {
        		case IBSEARCH :
        			if(!ComChkRequired(formObj)) {
        				return false;
        			}
        			if(!checkOriDestCd()) {
        				return false;
        			}
        			break;
        			
        		case IBSEARCH_ASYNC01 :
        			if(!ComChkRequired(formObj)) {
        				return false;
        			}
        			if(sheetObjects[0].RowCount < 1) {
        				return false;
        			}
        			break;
        			
        		case IBSEARCH_ASYNC02 :
        			if(!ComChkRequired(formObj)) {
        				return false;
        			}
        			if(sheetObjects[0].RowCount < 1) {
        				return false;
        			}
        			break;
        			
        		case IBSEARCH_ASYNC03 :
        			if(!ComChkRequired(formObj)) {
        				return false;
        			}
        			if(sheetObjects[0].RowCount < 1) {
        				return false;
        			}
        			break;
        	}
        }
        return true;
	}
    
	/* 개발자 작업  끝 */