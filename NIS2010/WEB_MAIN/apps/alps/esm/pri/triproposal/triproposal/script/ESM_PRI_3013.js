/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3013.js
*@FileTitle : TRI Inquiry
*Open Issues :
*Change history :
* 2010.10.19 송호진 TRI Inquiry 결과 Format 에서 컬럼의 순서 수정 - Tariff Item No 을 가장 상위 기준으로 설정함
*@LastModifyDate : 2010.10.19
*@LastModifier : 송호진
*@LastVersion : 1.22
* 2009.12.04 김재연
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
     * @class ESM_PRI_3013 : ESM_PRI_3013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3013() {
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
     * @version 2009.12.04
     */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;
					
				case "btn_New":
					doActionIBSheet(sheetObjects[0], document.form, IBRESET);
					break;
				
				case "btn_conversion":
					  var pgmNo = "ESM_PRI_3006";
	                  var pgmUrl = "/hanjin/ESM_PRI_3006.do"
	                  var parentPgmNo = pgmNo.substring(0, 8)+'M001';  
	                  var param = "&trf_cd="+comboObjects[0].Code;
	                  var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + param;
	                  var sUrl = "alpsMain.screen?parentPgmNo=" + parentPgmNo + src;
	                  var iWidth = 1024;
	                  var iHeight = 700;
	                  var leftpos = (screen.width - iWidth) / 2;
	                  if (leftpos < 0)
	                      leftpos = 0;
	                  var toppos = (screen.height - iHeight) / 2;
	                  if (toppos < 0)
	                      toppos = 0;

	                  var sFeatures = "status=no, resizable=yes, scrollbars=yes, width="+iWidth+", left="+leftpos+", top="+toppos;
	                  ComPriOpenWindow(sUrl, "", sFeatures, iHeight);
					break;
					
				case "srch_btn_srch_cmdt":
		            var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
		            sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=C";

					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 320, true);
					if (rtnVal != null){
						formObject.srch_cmdt_cd.value = rtnVal.cd;
						formObject.srch_cmdt_nm.value = rtnVal.nm;
					}
					break;
				
				case "btns_calendar": //달력버튼
					var cal = new ComCalendar();
					cal.select(formObject.srch_acs_dt,'yyyy-MM-dd');
					break;
					
				case "btn_downexcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
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
     * @version 2009.12.04
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수 IBMultiCombo Object
     * @return 없음
     * @author 김재연
     * @version 2009.06.04
     */
 	function setComboObject(combo_obj) {
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
     * @author 김재연
     * @version 2009.12.02
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		initControl();
		initIBComboItem();
        form.srch_acs_dt.value = ComGetNowInfo('ymd', '-');
		//doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
		ComBtnDisable("btn_conversion");
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
     * @version 2009.12.02
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
		
        switch(sheetID) {
        
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 360;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   	// 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    var HeadTitle = "Tariff Rate Item\n(TRI)|Commodity\nCode|Commodity Description|Effective\nDate|Expiration\nDate|Origin\n(POR)|Origin\nVia|Dest.\nVia|Dest.\n(DEL)|Per|Cur.|Rate|Note|TAA No.";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData, 	100,daCenterTop,true,	"tri_no",				false,	"",	dfNone);                    
                    InitDataProperty(0, cnt++ , dtHidden,	80,	daCenterTop,true,	"cmdt_cd",				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	200,daLeftTop,	true,	"cmdt_nm",				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	80,	daCenterTop,false,	"eff_dt",				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	80,	daCenterTop,false,	"exp_dt",				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	150,daLeftTop,	false,	"org_rout_pnt_loc_nm",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	60,	daLeftTop,	false,	"org_rout_via_port_nm",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	60,	daLeftTop,	false,	"dest_rout_via_port_nm",false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	150,daLeftTop,	false,	"dest_rout_pnt_loc_nm",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	50,	daCenterTop,false,	"rat_ut_cd",			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	50,	daCenterTop,false,	"curr_cd",				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	60,	daRightTop,	false,	"fnl_frt_rt_amt",		false,	"",	dfNullFloat,	2);
                    InitDataProperty(0, cnt++ , dtData, 	100,daLeftTop,false,	"note_ctnt",			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData, 	60,daCenterTop,	false,	"taa_no",				false,	"",	dfNone);
                    
                    ColHidden("taa_no") = true;
                    
                    InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
                    
                    ShowButtonImage = 2;
                    CountPosition = 0;
                    AutoRowHeight = true;
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
 	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
 	 * @return 없음
     * @author 김재연
     * @version 2009.12.04
 	 **/
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "-";
 		axon_event.addListenerForm('click', 'obj_click', document.form);
 		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
 		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListener('keydown', 'getKeyEnter', 'form');
 	}
    
 	/**
     * Open 시에 조회한 Combo Item 을 IBMultiCombo 에 셋팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.12
     */
    function initIBComboItem() {
         ComPriTextCode2ComboItem(srchTrfComboValue, srchTrfComboText, getComboObject(comboObjects, 'srch_trf_cd'),"|","\t");
         ComPriTextCode2ComboItem(srchRatUtComboValue, srchRatUtComboText, getComboObject(comboObjects, 'srch_rat_ut_cd'),"|","\t");
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
      		var obj = document.getElementById("btn_Retrieve");
      		if (obj == null) obj = document.getElementById("btn_Retrieve");
     		if (obj) obj.fireEvent("onclick");
        } catch(err) { ComFuncErrMsg(err.message); }
    }
         
    /**
     * 콤보 초기설정값, 헤더 정의 <br>
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.12.04
     */
	function initCombo(comboObj, comboNo) {
    	 
		switch (comboObj.id) {
			case "srch_trf_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	
	            	IMEMode = 0;
	            	MaxLength = 8;
	            	ValidChar(2, 3);
	            }
	            break;
				
			case "srch_rat_ut_cd":
				with (comboObj) {
					DropHeight = 200;
					MultiSelect = false;
					MaxSelect = 1;
					UseAutoComplete = true;
					
					IMEMode = 0;
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
     * @version 2009.12.04
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
//	        case IBCLEAR: // 화면 로딩시 
//		        sheetObj.WaitImageVisible = false;
//		        var sXml = "";  
//		        
//		        // Tariff Code
//		        formObj.f_cmd.value = SEARCHLIST12;
//		        sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//		        ComPriXml2ComboItem(sXml, formObj.srch_trf_cd, "cd", "cd|nm");
//		        
//		        // Per code
//		        formObj.f_cmd.value = SEARCH03;
//		        sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//		        ComPriXml2ComboItem(sXml, formObj.srch_rat_ut_cd, "cd", "cd|nm");
//		        comboObjects[1].InsertItem(0, "", "");
//		        
//		        // per combo
//		        formObj.f_cmd.value = SEARCH03;
//		        sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//		        setIBCombo(sheetObjects[0], sXml, "rat_ut_cd", false, 0, "D4");
//				
//		        sheetObj.WaitImageVisible = true;
//		        break;
	       
	        case IBRESET: // New
	        	sheetObjects[0].RemoveAll();
	        	comboObjects[0].Code2 = '-1';
	        	comboObjects[1].Code2 = '-1';
	        	formObj.srch_trf_nm.value = "";
	        	formObj.srch_acs_dt.value = "";
	        	formObj.srch_cmdt_cd.value = "";
        		formObj.srch_cmdt_nm.value = "";
        		formObj.srch_org_rout_pnt_loc_nm.value = "";
       			formObj.srch_org_rout_via_port_nm.value = "";
   				formObj.srch_dest_rout_via_port_nm.value = "";
				formObj.srch_dest_rout_pnt_loc_nm.value = "";
				formObj.srch_tri_no.value = "";
				formObj.srch_taa_no.value = "";
				formObj.srch_chk_taa_no.checked = false;
				sheetObjects[0].ColHidden("taa_no") = true;
	            break;
            
           case IBSEARCH:
        	   ComOpenWait(true);
        	   if(!validateForm(sheetObj, document.form, sAction)) {
        		   ComOpenWait(false);
        		   return false;
               }
        	   
        	   formObj.f_cmd.value = SEARCH;
               sheetObj.DoSearch("ESM_PRI_3013GS.do" , FormQueryString(formObj));
               ComOpenWait(false);
               break;
               
			case IBDOWNEXCEL: //Download excel
				var xmlFile = "apps/alps/esm/pri/triproposal/triproposal/script/ESM_PRI_3013.xml";
				// Excel 설정 파일
//				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false);
//				sheetObj.SpeedDown2Excel(-1, false, false, "", xmlFile, false, false, "", false);
				sheetObj.Down2Excel(-1, false, false, true, "", xmlFile);
				break;               
        }
    }
    
    /**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 김재연
	 * @version 2009.12.04
	 */
	function srch_trf_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		formObj.srch_trf_pfx_cd.value = code.substring(0, 4);
		formObj.srch_trf_no.value = code.substring(5, 8);
		formObj.trf_pfx_cd.value = code.substring(0, 4);
		formObj.trf_no.value = code.substring(5, 8);
//		if (text != null && text != "") {
//			formObj.srch_trf_nm.value = text.split("|")[1];
//		} else {
//			formObj.srch_trf_nm.value = "";
//		}
		
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.srch_trf_nm.value = comboObj.GetText(code, 1);
    	}else{
    		formObj.srch_trf_nm.value;
    	}
		

		if(ComIsNull(code)) {
			ComBtnDisable("btn_conversion");
		} else {
			ComBtnEnable("btn_conversion");
		}
	}
	 
  /**
   * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   * Combo의 text값을 Html Object에 표시한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *    srch_trf_cd_OnBlur(comboObj);
   * </pre>
   * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */  
  function srch_trf_cd_OnBlur(comboObj) {
		var formObj = document.form;		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		var srchTrfNm = "";
		if (code != null && code != "") {
			var text = comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.srch_trf_nm.value) {
				srchTrfNm = comboObj.GetText(code, 1);
				formObj.srch_trf_nm.value = srchTrfNm;
			}
			
			formObj.srch_trf_pfx_cd.value = code.substring(0, 4);
			formObj.srch_trf_no.value = code.substring(5, 8);
			formObj.trf_pfx_cd.value = code.substring(0, 4);
			formObj.trf_no.value = code.substring(5, 8);
			
		}
		if (code == -1 ){
			formObj.srch_trf_nm.value = "";
		}
	} 	 
	 
	 
    
	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.12.04
     */
	function obj_click() {
		if(event.srcElement.name == "srch_chk_taa_no") {
			if(event.srcElement.checked) {
			 	sheetObjects[0].ColHidden("taa_no") = false;
			} else {
				sheetObjects[0].ColHidden("taa_no") = true;
			}
			for(i=1; i<=sheetObjects[0].LastRow; i++) {
				sheetObjects[0].RowHeight(i) = 0;
			}
		}
	}
	
    /**
 	 * OnKeyPress event를 처리한다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     obj_keypress();
 	 * </pre>
 	 * @param 없음
 	 * @return 없음
 	 * @author 김재연
 	 * @version 2009.12.04
 	 */
 	function obj_keypress() {

 		switch (event.srcElement.dataformat) {
	 		case "int":
	 			ComKeyOnlyNumber(event.srcElement);
	 			break;
	 		case "float":
	 			ComKeyOnlyNumber(event.srcElement, ".");
	 			break;
	 		case "engup":
	 			if (event.srcElement.name == "srch_taa_no") {
	 				ComKeyOnlyAlphabet('uppernum');
	 			} else {
	 				ComKeyOnlyAlphabet('upper');
	            }
	            break;
	        //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 추가
	 		case "uppernum":
 				ComKeyOnlyAlphabet('uppernum');
 				break;
	 		default:
	 			break;
 		}
 	}

 	/**
 	 * OnBeforeActivate event를 처리한다. <br>
 	 * <br>
 	 * <b>Example :</b>
 	 * 
 	 * <pre>
 	 * obj_activate()
 	 * </pre>
 	 * 
 	 * @param 없음
 	 * @return 없음
 	 * @author 김재연
 	 * @version 2009.12.04
 	 */
 	function obj_activate() {
 		var formObj = document.form;
 	    var srcName = event.srcElement.getAttribute("name");
 	    
 	    if (srcName == "srch_tri_no") {
 	    	formObj.srch_tri_no.value = formObj.srch_tri_no.value.replace(RegExp(/-/ig), "");
 	    } else if (srcName == "srch_acs_dt") {
 	    	formObj.srch_acs_dt.value = formObj.srch_acs_dt.value.replace(RegExp(/-/ig), "");
 	    }
 	}
 	
 	/**
 	 * Onbeforedeactivate  event를 처리한다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     obj_deactivate()
 	 * </pre>
 	 * @param 없음
 	 * @return 없음
 	 * @author 김재연
 	 * @version 2009.12.04
 	 */
 	function obj_deactivate() {
 		var formObj = document.form;
 	    var srcName = event.srcElement.getAttribute("name");
 	    
 	    if (srcName == "srch_tri_no") {
// 	    	var sTriNo = formObj.srch_tri_no.value;
 	    	var sTriNo = formObj.srch_tri_no.value.replace(/-/g, '');
 	    	if (sTriNo.length >= 13) {
 	    		formObj.srch_tri_no.value = sTriNo.substring(0, 6) + "-" + sTriNo.substring(6, 10) + "-" + sTriNo.substring(10, 13);
 	    	}
 	    } else if (srcName == "srch_cmdt_cd") {
 	    	if (formObj.srch_cmdt_cd.value.length == 6) {
 				formObj.f_cmd.value = SEARCH08;
 				var param = "&cd=" + formObj.srch_cmdt_cd.value;
 				var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
 				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					formObj.srch_cmdt_nm.value = arrData[1];
 				} else {
 		    		formObj.srch_cmdt_cd.value = "";
 		    		formObj.srch_cmdt_nm.value = "";
 		    		return false;
 				}
 	    	} else {
 	    		formObj.srch_cmdt_cd.value = "";
 	    		formObj.srch_cmdt_nm.value = "";
 	    	}
 	    	
 	    } else if (srcName == "srch_acs_dt") {
 	    	ComChkObjValid(formObj.srch_acs_dt);
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
     * @version 2009.12.04
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    	if (errMsg == "") {
    		var formObj = document.form;
    		if(!ComIsNull(formObj.srch_taa_no.value)) {
    			formObj.srch_chk_taa_no.checked = true;
    			sheetObjects[0].ColHidden("taa_no") = false;
    		}
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
     * @version 2009.12.04
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
    		case IBSEARCH: // 조회
		     	if(ComIsNull(comboObjects[0].text)) {
		     		ComShowCodeMessage('PRI00337','Tariff Code');
		            return false;
		        }

    			if(!ComChkRequired(formObj)) return false;
		     	return true;
		        break;
    	}
        return true;
    }

	/* 개발자 작업  끝 */