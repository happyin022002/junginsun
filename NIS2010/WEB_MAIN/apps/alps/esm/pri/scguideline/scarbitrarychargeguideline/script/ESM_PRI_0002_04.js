/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0002_04.js
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.05 김재연
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview .
     * @author 한진해운
     */

    /**
     * @extends 
     * @class Origin/Destination Arbitrary Charge Guideline Inquiry : Origin/Destination Arbitrary Charge Guideline Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0002_04() {
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
    var enableFlag = true;


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
     * @version 2009.10.05
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		
     		if (srcName != null && srcName !="" && srcName.indexOf("btn") == 0 
						&& getButtonDisableStatus(srcName)){
				return;
			}
     		switch(srcName) {
				case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						fontChange();
					}
					break;						
				
				case "btn_DownExcel":
					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}else{
		                ComShowCodeMessage('PRI08001');
		                return false;
					}
					break;

				case "dest_tp_cd":
					obj_click();
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
     * @version 2009.10.05
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
     * @version 2009.10.05
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
     * @version 2009.10.05
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
    	var sheetID = sheetObj.id;
    	switch(sheetID) {
    		case "sheet1":
    			with (sheetObj) {
    				// 높이 설정
    				style.height = 320;
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
                     
    				var HeadTitle = "Seq.|ARBSEQ|pnttpcd|Point|Description|Term|Trans. Mode|bptpcd|Base Port|vptpcd|VIA|Direct Call|Per|Cargo Type|Cur|Rate|svcscpcd|glineseq|orgdesttpcd";
    				var headCount = ComCountHeadTitle(HeadTitle);
                     
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false, false);

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);


//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//				  	  				  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//	 			  	  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//				  	  				  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]  
    				InitDataProperty(0, cnt++, dtDataSeq,	40, daCenter,	true, "Seq");
    				InitDataProperty(0, cnt++, dtHidden,   	40, daCenter,  	true, "arb_seq");
    				InitDataProperty(0, cnt++, dtHidden,   	40, daCenter,  	true, "rout_pnt_loc_tp_cd");
    				InitDataProperty(0, cnt++, dtData, 		90, daCenter,  	true, "rout_pnt_loc_def_cd", false,  "", dfNone, 	  0);
    				InitDataProperty(0, cnt++, dtData,     	120,daLeft,		true, "loc_des",             false,  "", dfNone,	  0);
    				InitDataProperty(0, cnt++, dtCombo,    	70, daCenter,  	true, "rcv_de_term_cd",      false,  "", dfNone, 	  0);
    				InitDataProperty(0, cnt++, dtCombo,    	100,daCenter,  	true, "prc_trsp_mod_cd",     false, "", dfNone, 	  0); 					 
    				InitDataProperty(0, cnt++, dtHidden,   	40, daCenter,  	true, "bse_port_tp_cd");
    				InitDataProperty(0, cnt++, dtData,   	85, daCenter,  	true, "bse_port_def_cd",     false,  "", dfNone, 	  0);
    				InitDataProperty(0, cnt++, dtHidden,   	40, daCenter,  	true, "via_port_tp_cd");
    				InitDataProperty(0, cnt++, dtData,   	85, daCenter,  	true, "via_port_def_cd",     false, "", dfNone, 	  0);
    				InitDataProperty(0, cnt++, dtCheckBox, 	75, daCenter,  	true, "dir_call_flg",        false, "", dfNone, 	  0);
    				InitDataProperty(0, cnt++, dtCombo,  	60, daCenter,  	true, "rat_ut_cd",      	  false,  "", dfNone, 	  0);
    				InitDataProperty(0, cnt++, dtCombo,    	80, daCenter,  	true, "prc_cgo_tp_cd",       false,  "", dfNone, 	  0);
    				InitDataProperty(0, cnt++, dtCombo,    	60, daCenter,  	true, "curr_cd",      	      false,  "", dfNone, 	  0);
    				InitDataProperty(0, cnt++, dtData,     	75, daRight,   	true, "frt_rt_amt",          false,  "", dfNullFloat, 2);
    				InitDataProperty(0, cnt++, dtHidden,   	40, daCenter,  	true, "svc_scp_cd");
    				InitDataProperty(0, cnt++, dtHidden,   	40, daCenter,  	true, "gline_seq");    
    				InitDataProperty(0, cnt++, dtHidden,   	40, daCenter,  	true, "org_dest_tp_cd"); 

    				ShowButtonImage = 2;
    				AutoRowHeight = false;
    				WaitImageVisible = false;
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
     * @version 2009.10.05
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH_ASYNC01: // 화면조회시 Customer Type 재조회
    			var firstCheck = false;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_0002_04GS.do" , FormQueryString(formObj));
			
				var arrData = ComPriXml2Array(sXml, "typecd|typecount");
				var obj = document.form;
				if (parseInt(arrData[0][1]) > 0) {
					document.getElementById("dest_tp_cd1").style.fontWeight = "bold";
					formObj.dest_tp_cd[0].checked = true;
					obj.org_dest_tp_cd.value = "O";
					firstCheck = true;
				}else{
					document.getElementById("dest_tp_cd1").style.fontWeight = "";
					formObj.dest_tp_cd[0].checked = true;
				}

				if (parseInt(arrData[1][1]) > 0) {
					document.getElementById("dest_tp_cd2").style.fontWeight = "bold";
					if (!firstCheck){
						formObj.dest_tp_cd[1].checked = true;
						obj.org_dest_tp_cd.value = "D";
					}
				}else{
					document.getElementById("dest_tp_cd2").style.fontWeight = "";
				}		
				break;
				
 			case IBCLEAR: // 화면 로딩시 
 				
 				var sXml = "";
 			
				formObj.f_cmd.value = COMMAND14;
				formObj.cd.value = "PER:CUR";		//per combo:currency combo		
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				var aXml = sXml.split("|$$|");
				
				if ( aXml[0] != null) setIBCombo(sheetObj,aXml[0],"rat_ut_cd",true,0);	
				if ( aXml[1] != null) setIBCombo(sheetObj,aXml[1],"curr_cd",true,0,"USD");	
				
         		formObj.f_cmd.value = COMMAND13;
         		//공통  trans mode,term,cargo
         		formObj.cd.value = "CD01720:N:CD02138:N:CD01701:Y";// 명칭이 code|desc일 경우는 Y         		
 				sXml = sheetObj.GetSearchXml("PRICommonGS.do" , FormQueryString(formObj));
 				var arrXml = sXml.split("|$$|");
 				if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"prc_trsp_mod_cd",true,0);					
 				if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"rcv_de_term_cd", true,0);
 				if ( arrXml[2] != null)	setIBCombo(sheetObj,arrXml[2],"prc_cgo_tp_cd", false, 0,"","");
 			
			case IBSEARCH:      //조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_PRI_0002_04GS.do", FormQueryString(formObj));
				ComOpenWait(false);
             	break;

			case IBDOWNEXCEL:
				//sheetObj.Down2Excel(-1);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "Seq");
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
     * @author 김재연
     * @version 2009.10.05
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
    		case IBSEARCH: // 조회			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} else {
					return true;
				}
				break;    	  

            case IBDOWNEXCEL: // 엑셀조회
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            }
	            break;				
    	  }
         return true;
     }

    /**
     * radio버튼 Axon 이벤트  처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @returns 없음
     * @author 김재연
     * @version 2009.10.05
     */ 	 
    function initControl() {
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	//axon_event.addListener('click', 'obj_click', 'dest_tp_cd');
    }
 	
    /**
     * radio버튼 click 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param 없음
     * @returns 없음
     * @author 김재연
     * @version 2009.10.05
     */ 	
 	function obj_click() {
 		var obj = document.form;
 		if (obj.dest_tp_cd[0].checked == true){
 			obj.org_dest_tp_cd.value = "O";
 			obj.cd.value="CD02138"; // origin
 		} else {
 			obj.org_dest_tp_cd.value = "D";
 			obj.cd.value="CD02139"; //dest
 		}

		//공통 term
		obj.f_cmd.value = SEARCH19;
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(obj));
		setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true, 0);	  	 		
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	}
     
 	/**
     * Radio 버튼의  font를 변경하는 function <br>
     * 데이터가 있다면 BOLD로 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 	fontChange()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 	     
    function fontChange(){
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetObjects[0]);
    	var formObj = document.form;
		var fontBold ="";
    	var eleName ="";
		
 		if (formObj.dest_tp_cd[0].checked == true){
 			eleName ="dest_tp_cd1";
 		}else{
 			eleName ="dest_tp_cd2";
 		}
 		if (row_count > 0) {
 			fontBold = "bold";
 		}    	
    	document.getElementById(eleName).style.fontWeight = fontBold;
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
     * @version 2009.10.05
     */ 	  	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		for(i = 1 ; i < sheetObj.Rows; i++){
			if (sheetObj.CellValue(i, "dir_call_flg") =="1" ){
				sheetObj.CellEditable(i,"via_port_def_cd") = false;
			}
		}
		
		if(sheetObj.RowCount > 0) {
			ComBtnDisable("btn_LoadExcel");
		}else{
			ComBtnEnable("btn_LoadExcel");
		}
	}  	   
     
 	/**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 
    function pageOnLoadFinish() {
    	initControl();
     	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
     	toggleButtons("CLEAR");
     	parent.loadTabPage();
    }
     
    /**
     * parent 화면의 상태로 edit여부를 판단한다. function <br>
     * <br><b>Example :</b>
     * <pre>
     * getMainStatus())
     * </pre>
     * @param 없음
     * @return {Boolean} true(수정가능,메인의 상태는 No) false(수정불가능,메인의상태는 Yes)
     * @author 김재연
     * @version 2009.10.05
     */    
    function getMainStatus(){
    	var mainStatus = parent.document.form.cfm_flg.value;
    	var editStatus = true;
    	if (mainStatus == "Yes"){
    		editStatus = false;
    	}
    	return editStatus;
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
     * @version 2009.10.05
     */
	function toggleButtons(mode) {
		switch (mode) {
			case "CLEAR":
				ComBtnDisable("btn_Retrieve");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_DownExcel");
				ComBtnEnable("btn_LoadExcel");
				break;
				
			case "INIT":
				ComBtnEnable("btn_Retrieve");
				if (getMainStatus()){
					ComBtnEnable("btn_Save");
				}else{
					ComBtnDisable("btn_Save");
				}
				
				ComBtnEnable("btn_DownExcel");
				ComBtnEnable("btn_LoadExcel");
				
				
				break;
			case "READONLY":
				ComBtnEnable("btn_Retrieve");
				ComBtnDisable("btn_Save");
				ComBtnEnable("btn_DownExcel");
				ComBtnEnable("btn_LoadExcel");
				
				break;
		}
	}
  	
    /**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sGlineSeq 필수 gline_seq 값
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject = document.form;
		
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;
			
			if (enableFlag) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}
			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
 	
    /**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 		 
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";
		
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");
	}     
	 
    /**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 	 
	function tabEnableSheet(flag) {
		var formObject = document.form;	
		enableFlag = flag;
		sheetObjects[0].Editable = flag;
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		
	}
	
	/* 개발자 작업  끝 */