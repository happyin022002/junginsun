/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1030.js
*@FileTitle : booking master
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2009.07.30 강동윤
* 1.0 Creation
*----------------------------------------------------------
* History
* 2010.12.01 최 선     1.1 [CHM-201007417] Mandatory Item(s) Setup for Customized Service Incoterms Column Add
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
     * @class ESM_BKG_1030 : ESM_BKG_1030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1030() {
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
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++] = sheet_obj;
        }



        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);    			
            }	
            initControl();
            
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		
        }

     /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
	     var formObject = document.form;
	     var srcName = window.event.srcElement.getAttribute("name");
	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	     var srcValue = window.event.srcElement.getAttribute("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
          /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
          axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt = 0;
            switch(sheetObj.id) {

                case "sheet1":
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 420;
                        
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 17, 100);

    					var HeadTitle1 = "|Sel.|Seq.|Customer Code|Customer Code|Customer Code|Customer Code|S/C No.|Expire Date|RFA No.|Expire Date|SVC Scope|POR|POL|POD|DEL|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|Mandatory Item(s)|B/L Issue Note|Remark(s)|Update Date|User ID";
    					var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount+3, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        
                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			InitColumnInfo(43, 11, 0, true);
                       
                        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					
                        InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");
    					InitDataProperty(0, cnt++ , dtDelCheck,			40,		daCenter,	true,		"Sel");
    					InitDataProperty(0,	cnt++ , dtDataSeq,			40,		daCenter,	false,		"Seq",				false,	"",		dfNone,			0,	false,	true);
    					InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		"mdt_cust_tp_cd",	false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,		"cust_grp_id",		false,	"",		dfEngUpKey,		0,	true,	true,	1);
    					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		"cust_cnt_cd",		false,	"",		dfEngUpKey,		0,	true,	true,	2);
    					InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"cust_seq",			false,	"",		dfEngUpKey,		0,	true,	true,	6);
    					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"sc_no",			false,	"",		dfEngUpKey,		0,	true,	true,	9);
    					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"sc_exp_dt",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"rfa_no",			false,	"",		dfEngUpKey,		0,	true,	true,	11);
    					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"rfa_exp_dt",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"svc_scp_cd",		false,	"",		dfEngUpKey,		0,	true,	true,	3);
    					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"por_cd",			false,	"",		dfEngUpKey,		0,	true,	true,	5);
    					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"pol_cd",			false,	"",		dfEngUpKey,		0,	true,	true,	5);
    					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"pod_cd",			false,	"",		dfEngUpKey,		0,	true,	true,	5);
    					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	true,		"del_cd",			false,	"",		dfEngUpKey,		0,	true,	true,	5);
    					
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_pob",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,		true,		"itm_nm_pob",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_poc",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,		true,		"itm_nm_poc",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_pom",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,		true,		"itm_nm_pom",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_inv",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				70,		daLeft,		true,		"itm_nm_inv",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_dep",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				95,		daLeft,		true,		"itm_nm_dep",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_lc",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		"itm_nm_lc",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_shp",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		"itm_nm_shp",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_pat",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		"itm_nm_pat",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_inc",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				50,		daLeft,		true,		"itm_nm_inc",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtCheckBox,			22,		daCenter,	true,		"itm_cd_msl",		false,	"",		dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,				140,		daLeft,		true,		"itm_nm_msl",		false,	"",		dfNone,			0,	false,	false);
    					
//    					InitDataProperty(0, cnt++ , dtData,				200,	daLeft,		true,		"bl_iss_note",		false,	"",		dfNone,			0,	true,	true);    					
    					InitDataProperty(0, cnt++ , dtData,				200,	daLeft,		true,		"bl_iss_note_ctnt",		false,	"",		dfNone,			0,	true,	true); 
    					InitDataProperty(0, cnt++ , dtData,				200,	daLeft,		true,		"mdt_itm_rmk",		false,	"",		dfNone,			0,	true,	true,	30);
    					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"upd_dt",			false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"upd_usr_id",		false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	true,		"fcust",			false,	"",		dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++ , dtHidden,  			0,     	daCenter,   true,       "mdt_itm_seq");
    					InitDataProperty(0, cnt++ , dtHidden,  			0,   	daCenter,   true,       "cust_code");
    					
    					InitDataValid(0, 	6, vtNumericOnly);

    					InitDataCombo(0,"mdt_cust_tp_cd","SH|CN|NT|All","SH|CN|NT|Al");

    					//CountPosition = 0;
    				}
    				break;
            }
        }

    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with (sheetObj) {
    		ColBackColor(5) = WebColor("#FFFF6F");
    		ColBackColor(6) = WebColor("#FFFF6F");
    		ColBackColor(7) = WebColor("#FFFF6F");
    		ColBackColor(9) = WebColor("#FFFF6F");
    	}
    }

      // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
         function processButtonClick(){
              /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
              var sheetObject1 = sheetObjects[0];

              /*******************************************************/
              var formObject = document.form;

         	try {
         		var srcName = window.event.srcElement.getAttribute("name");
     			switch(srcName) {
     				case "btn_Add":
     					/*
     					var cnt = sheetObject1.RowCount;
     					
     					if (cnt == 0 || cnt <0 ){
     						ComShowCodeMessage("BKG00012")//Please retrieve data first.
     						return;
     					}
     					*/
     					sheetObject1.DataInsert(-1);
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,15) = "P/O No.(by BKG)";
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,17) = "P/O No.(by CNTR)";
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,19) = "P/O No.(by Item)";
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,21) = "Invoice No.";
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,23) = "Department No.";
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,25) = "L/C No.";
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,27) = "Ship ID";
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,29) = "Part No";
//     					sheetObject1.CellValue2(sheetObject1.SelectRow,31) = "Incoterms";
     					
     					sheetObject1.CellValue2(sheetObject1.SelectRow,17) = "P/O No.(by BKG)";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,19) = "P/O No.(by CNTR)";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,21) = "P/O No.(by Item)";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,23) = "Invoice No.";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,25) = "Department No.";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,27) = "L/C No.";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,29) = "Ship ID";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,31) = "Part No";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,33) = "Incoterms";
     					sheetObject1.CellValue2(sheetObject1.SelectRow,35) = "Load ID (by CNTR)";
     					
     					break;
     				case "btn_Delete":
     					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
     					break;
     				case "btn_Retrieve":
     					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     					break;
     				case "btn_Save":
     					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
     					break;
     				case "btn_Close":
     					window.close();
     					break;
     				case "btn_Copy":
     					rowCopy();     					
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
         
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

    			case IBSEARCH:      //조회
    				if(!validateForm(sheetObj,formObj,sAction)) return;
    				
    				sheetObj.WaitImageVisible = false;
 					ComOpenWait(true);
 					
	    			formObj.f_cmd.value = SEARCH;   
					sheetObj.DoSearch("ESM_BKG_1030GS.do",FormQueryString(formObj));

    				break;

    			case IBSAVE:        //저장
    				if(!validateForm(sheetObj,formObj,sAction)) return;
    				/* Save 시 Dup Validation 체크 */
    				if(!chkDuplicate()) return;
    				
    				sheetObj.WaitImageVisible = false;
 					ComOpenWait(true);
 					
	    			formObj.f_cmd.value = MULTI;	
			 		
			 		var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("");
			        
	                sheetObj.DoSave("ESM_BKG_1030GS.do", sParam);
    			
    				break;

    			case IBDELETE:      // 삭제	 					
				
					ComRowHideDelete(sheetObj, "Sel");	
    			
    				break;
            }
            
            ComOpenWait(false);
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 switch(sAction) {

 				case IBSEARCH:      //조회
/*
 					if (formObj.cust_cnt_cd.value != "" && formObj.cust_seq.value == ""){
 						
 						ComShowCodeMessage("BKG00307");//Please, select & save specific commodity code. 						
 						formObj.cust_seq.focus(); 						
 						return false;
 					}
 				
 					if (formObj.cust_cnt_cd.value == "" && formObj.cust_seq.value != ""){
						
						ComShowCodeMessage("BKG00307");//Please, select & save specific commodity code. 						
						formObj.cust_cnt_cd.focus(); 						
						return false;
					}
*/
 					break;
 					
 				case IBSAVE:      //저장
					
 					for(var i = 1 ; i < sheetObj.LastRow+1 ; i++){
 				
 						if (sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U"){
/*
 							if (sheetObj.CellValue(i, "cust_cnt_cd") != '' && sheetObj.CellValue(i, "cust_seq") == ''){
			     			   
			     			    ComShowCodeMessage("BKG00408");//Please input Customer Code or Name.
			   				 
			     			    sheetObj.SelectCell(i, "cust_seq", true, ''); 
			     			   
			     			    return false;
			     		    }

			     		    if (sheetObj.CellValue(i, "cust_cnt_cd") == '' && sheetObj.CellValue(i, "cust_seq") != ''){
			     			   
			     			    ComShowCodeMessage("BKG00408");//Please input Customer Code or Name.
			   				 
			     			    sheetObj.SelectCell(i, "cust_cnt_cd", true, ''); 
			     			   
			     			    return false;
			     		    }

 							if (sheetObj.CellValue(i, "cust_cnt_cd") == '' && sheetObj.CellValue(i, "sc_no") == '' && sheetObj.CellValue(i, "rfa_no") == ''){
 			     			   
			     			    ComShowCodeMessage("BKG00888");//Mandatory Input item(s) is(are) missing: {?msg1}

			     			    sheetObj.SelectCell(i, "cust_cnt_cd", true, ''); 

			     			    return false;
			     		    }
*/
 							var custCntCd = sheetObj.CellValue(i, "cust_cnt_cd");
 							var custSeq   = sheetObj.CellValue(i, "cust_seq"   );
 							var scNo      = sheetObj.CellValue(i, "sc_no"      );
 							var rfaNo     = sheetObj.CellValue(i, "rfa_no"     );
 							if ((ComIsNull(custCntCd) || ComIsNull(custSeq)) && ComIsNull(scNo) && ComIsNull(rfaNo)) {
 								if ((ComIsNull(custCntCd) || ComIsNull(custSeq))) {
	 								if (ComIsNull(custCntCd)) {
	 									ComShowCodeMessage("BKG00888", "Customer Code(cust_cnt_cd)");//Mandatory Input item(s) is(are) missing: {?msg1}
				     			    	sheetObj.SelectCell(i, "cust_cnt_cd", true, ""); 
	 								}
	 								if (ComIsNull(custSeq)) {
	 									ComShowCodeMessage("BKG00888", "Customer Code(cust_seq)");//Mandatory Input item(s) is(are) missing: {?msg1}
				     			    	sheetObj.SelectCell(i, "cust_seq", true, ""); 
	 								}
 								} else if (ComIsNull(scNo)) {
	 								if (ComIsNull(scNo)) {
	 									ComShowCodeMessage("BKG00888", "S/C No.");//Mandatory Input item(s) is(are) missing: {?msg1}
				     			    	sheetObj.SelectCell(i, "sc_no", true, ""); 
	 								}
								} else if (ComIsNull(rfaNo)) {
	 								if (ComIsNull(rfaNo)) {
	 									ComShowCodeMessage("BKG00888", "RFA No.");//Mandatory Input item(s) is(are) missing: {?msg1}
				     			    	sheetObj.SelectCell(i, "rfa_no", true, ""); 
	 								}
 								}
 								return false;
 							}

			     		    formObj.chk_cust_cd.value  = custCntCd;
		    			    formObj.chk_cust_seq.value = custSeq;
		    	      	   	 
		    			    formObj.f_cmd.value = SEARCH01;   					  

		    			    var searchXml = sheetObj.GetSearchXml("ESM_BKG_1030GS.do" ,FormQueryString(formObj));	
		  			   
		    			    var check = ComGetEtcData(searchXml,"check");
		
		    			    if (searchXml.indexOf("MESSAGE") > 0){
		    					
		    				    ComShowCodeMessage("BKG08141");//Duplicate Control Office,Agent,Customer Code! Please try again.
		    					 
		    				    sheetObj.SelectCell(i, "cust_seq", true, ''); 
		    				    
		    				    return false;
		    			    }
 						}
 					}
				
					break;
        	 }

            return true;
        }
        
        
        
         
         /**
          * Row Copy
          */
        function rowCopy(){
        	
        	var formObj = document.form;

        	var rowIdx = formObj.copy_idx.value;

        	if (rowIdx == ''){

        		rowIdx = 1;
        		formObj.copy_idx.value = 1;
        	}

        	for (var i = 0 ; i < rowIdx ; i++){
        		
        		sheetObjects[0].DataCopy();
        	}
        }

        /**
         * POL - Destination이 같은 국가는 저장이 안되도록 처리함
         */
//       function sheet1_OnAfterEdit(sheetObj,Row, Col, Value){
       function chkCustCd(sheetObj,Row, Col, Value){
        	    	  
    	   var formObj = document.form; 
    	   
    		   if (sheetObj.CellValue(Row, "cust_cnt_cd") != '' && sheetObj.CellValue(Row, "cust_seq") == ''){
    			   
    			   ComShowCodeMessage("BKG00408");//Please input Customer Code or Name.
  				 
    			   sheetObj.SelectCell(Row, "cust_seq", true, ''); 
    			   
    			   return;
    		   }
    		   
    		   if (sheetObj.CellValue(Row, "cust_cnt_cd") == '' && sheetObj.CellValue(Row, "cust_seq") != ''){
    			   
    			   ComShowCodeMessage("BKG00408");//Please input Customer Code or Name.
  				 
    			   sheetObj.SelectCell(Row, "cust_cnt_cd", true, ''); 
    			   
    			   return;
    		   }
    		   
    		   if (sheetObj.CellValue(Row, "cust_cnt_cd") == '' && sheetObj.CellValue(Row, "sc_no") == '' && sheetObj.CellValue(Row, "rfa_no") == ''){
    			   
    			   ComShowCodeMessage("BKG00888");//Mandatory Input item(s) is(are) missing: {?msg1}
    				 
    			   sheetObj.SelectCell(Row, "cust_cnt_cd", true, ''); 
    			   
    			   return;
    		   }
    		   
    		   if (Col == 5 || Col == 6){
    			   
    			   formObj.chk_cust_cd.value  = sheetObj.CellValue(Row, "cust_cnt_cd");
    			   formObj.chk_cust_seq.value = sheetObj.CellValue(Row, "cust_seq");
    	      	   	 
    			   formObj.f_cmd.value = SEARCH01;   					  
    			   
    			   var searchXml = sheetObj.GetSearchXml("ESM_BKG_1030GS.do" ,FormQueryString(formObj));	
  			   
    			   var check = ComGetEtcData(searchXml,"check");

    			   if (searchXml.indexOf("MESSAGE") > 0){
    					
    				   ComShowCodeMessage("BKG08141");//Duplicate Control Office,Agent,Customer Code! Please try again.

    				   sheetObj.SelectCell(i, "cust_cnt_cd", true, ''); 
    			   } 
    		   }  			   
    	   
       }
     /* 조회후 Sheet Change Event
      * Customer Code 에 대하여  중복 Validation 추가 
      */
     function sheet1_OnChange(sheetObj, Row, Col, Value){
    	 if (3==Col || 5==Col || 6==Col) {
	    	 var formObj = document.form;
	    	 var r_focus = sheetObj.ColSaveName(Col);
	    	 var cust_tp_cd = sheetObj.CellValue(Row, "mdt_cust_tp_cd");
	    	 var cust_cnt_cd = sheetObj.CellValue(Row, "cust_cnt_cd");
	    	 var cust_seq = sheetObj.CellValue(Row, "cust_seq");
	    	 var cnt = sheetObj.RowCount;
	    	 
	    		 if(ComIsNull(cust_tp_cd) != true && ComIsNull(cust_cnt_cd) != true && ComIsNull(cust_seq) != true){
		    		 var findRow = sheetObj.FindText("fcust",cust_tp_cd + cust_cnt_cd + cust_seq);
		    		 if(findRow > 0 && findRow != Row){
		    			 ComShowCodeMessage('BKG00764', 'Customer Code');
		    			 sheetObj.SelectCell(Row,Col,true)
		    			 return ;
		    		 }
	    		 }    	
    	 }
     }
     /* OnChange 에서 처리 안된 Customer 중복 처리 
      * Customer Code 에 대하여  중복 Validation 추가 
      */
     function chkDuplicate(){
    	 var formObj = document.form;
    	 var cnt = sheetObjects[0].RowCount;
    	 var sheetObj = sheetObjects[0];
    	 for (var ix = 1; ix <= cnt; ix++ ){
    		 var cust_tp_cd = sheetObj.CellValue(ix,"mdt_cust_tp_cd");
    		 var cust_cnt_cd = sheetObj.CellValue(ix,"cust_cnt_cd");
    		 var cust_seq = sheetObj.CellValue(ix,"cust_seq");
    		 var fcust = sheetObj.CellValue(ix,"fcust");
    		 if (sheetObj.RowStatus(ix) == "I" || sheetObj.RowStatus(ix) == "U"){
	    		 if(ComIsNull(cust_tp_cd) != true && ComIsNull(cust_cnt_cd) != true && ComIsNull(cust_seq) != true){
	    			 var findRow = sheetObj.FindText("fcust",cust_tp_cd + cust_cnt_cd + cust_seq);
	    			 
	    			 if(findRow > 0 && findRow != ix){
	    				 ComShowCodeMessage('BKG00764','Customer Code');
	    			 	 sheetObj.SelectCell(ix, "cust_seq");   			 	 
	    			 	 return false ;
	    			 }
	    		 }
    		 }
    	 }
    	 return true;
     }
         
	/* 개발자 작업  끝 */