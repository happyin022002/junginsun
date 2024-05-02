/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0024.js
*@FileTitle : Container Status Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.28 이호선
* 1.0 Creation
=========================================================
*2010.06.24 NKJH : MUI Container Status Creation 로직 변경
                   - 기존 MUI Status Container 조회 후 선택하여 처리하였으나
                     RowAdd 후 CNTR NO. 입력 후 체크하여 처리 하는방법으로 변경.
*2010.07.05 남궁진호 : SRO,SRI Status Creation 추가 
                   - 기존 MUI,MUO와 같은 방식으로  SRO,SRI신규 추가함.      
*2012.11.19 문동선 [CHM-201221413] [MST] ALPS MST-Master - Master Update Creation에서 문제점 발생 및 수정 요청   
                                  - LSO 인 경우 체크표시 된 것만 저장하는 방식으로 변경, Delete 버튼 비활성화 
* 2013.03.13 채창호    [CHM-201323498-01] ALPS Maater-Status에서 SOC 장비의 OC/OP상태에서 Movement XX 처리 로직 Upgarde  요청                                          
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
     * @class ees_mst_0024 : ees_mst_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

    function ees_mst_0024() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;    
		this.sheet1_OnChange        = sheet1_OnChange;
		this.sheet1_OnAfterEdit     = sheet1_OnAfterEdit;
    }
   	/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var IBSEARCH01  = 29;
 var IBSEARCH02  = 30;
 var tcnt = 0;
 var blurflg = false;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         /*******************************************************/
         var formObject = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
				case "btn_master":
					if (sheetObjects[0].rowCount != 0 ) {
						var cntr_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no");
						if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"){
							var cntr_no_len =cntr_no.length;
							if ( cntr_no_len > 10 ) {
								cntr_no = cntr_no.substring(0,10);
							} 
							ComOpenPopup("/hanjin/EES_MST_0019.do?popup_mode=Y&cntr_no="+cntr_no,1100, 630, "", "1,0,1,1,1,1,1,1", true);
						}
					}
					break;                 	
             
             
				case "btn_retrieve":
					if (formObject.st_cd.value == "") {
						ComShowCodeMessage("MST00001", "Status Code");
						ComSetFocus(formObject.st_cd);
						return;
					} 
					if (formObject.hire_date.value == "") {
						ComShowCodeMessage("MST00001", "Date");
						ComSetFocus(formObject.hire_date);
						return;
					}
					if (formObject.sts_evnt_yd_cd.value == "") {
						ComShowCodeMessage("MST00001", "Yard");
						ComSetFocus(formObject.sts_evnt_yd_cd);
						return;
					}
					
					if (formObject.st_cd.value == "1" || formObject.st_cd.value == "3"|| formObject.st_cd.value == "5") {
						if (formObject.agmt_cty_cd.value == "" || formObject.agmt_seq.value == ""){
							ComShowCodeMessage("MST00001", "AGMT No.");
							ComSetFocus(formObject.agmt_seq);
							return;
						}
					}
					if ((formObject.st_cd.value == "0" && formObject.agmt_seq.value.trim().length > 0)  || formObject.st_cd.value == "1" || formObject.st_cd.value == "3" || formObject.st_cd.value == "5") {
					   doActionIBSheet(sheetObject1,formObject,IBSEARCH01);
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					
				break;
				
				case "btn_loadexcel" :
					var target = document.getElementById("st_cd");
					var targetText = target.options[target.selectedIndex].text;
					sheetObject1.RemoveAll();
					sheetObjects[1].RemoveAll();
					var ccheck = sheetObject1.LoadExcel(-1,1,"",-1,-1,"",false);
					if(sheetObject1.RowCount > 1 && targetText != sheetObject1.CellValue(1, "sts_cd")){
						ComShowCodeMessage("MST02027");
						sheetObject1.RemoveAll();
						sheetObjects[1].RemoveAll();
						return;
					}
				break;	
				
				case "btn_downexcel":
					var expt = "";
					if(formObject.st_cd.value == 2 || formObject.st_cd.value == 4){
						expt = "cntr_pkup_chg_amt|cntr_pkup_cr_chg_amt";
					}else if(formObject.st_cd.value == 1 || formObject.st_cd.value == 3){
						expt = "cntr_drff_amt|cntr_drff_cr_amt";
					}else if(formObject.st_cd.value == 5 || formObject.st_cd.value == 6){
						expt = "cntr_drff_amt|cntr_drff_cr_amt|cntr_pkup_chg_amt|cntr_pkup_cr_chg_amt";
					}
					var target = document.getElementById("st_cd");
					var targetText = target.options[target.selectedIndex].text;
					sheetObject3.DataInsert(-1);
					sheetObject3.CellValue(1, "st_cd") = targetText;
					sheetObject3.Down2Excel(-1,false,false,true,"","",false,false,"",false, expt);
					sheetObject3.RowDelete(sheetObject3.LastRow, false);
				break;
				
				case "btn_new":
					sheetObject1.RemoveAll();
					sheetObjects[1].RemoveAll();
					setSearchField('1');
					setFieldOfStatusCode(formObject.st_cd.value);
					formObject.sts_evnt_yd_cd.value = "";
					formObject.agmt_seq.value = "";
					formObject.vndr_seq.value = "";
					formObject.vndr_abbr.value = "";
					formObject.ref_no.value = "";
					formObject.vndr_nm.value = "";
					formObject.vndr_abbr.value = "";
					formObject.yd_cd_nm.value = "";
					formObject.st_cd.value = "";
					formObject.hire_date.value = "";
					sheetObject1.HeadCheck(0,"del_chk") = false;
					ComSetFocus(formObject.st_cd);					
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE)
				break;
				
				case "btn_add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT)
				break;
				
				case "btn_delete":
   					if(sheetObject1.FindCheckedRow("del_chk")==""){
   						ComShowCodeMessage("MST00010");
   					} else if(ComShowCodeConfirm("MST00005")){ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
   				break;
					
                case "ComOpenPopupWithTargetYard":
                	if (formObject.sts_evnt_yd_cd.readOnly == false){
         		        ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 1000, 500, "3:sts_evnt_yd_cd", "0,0,1,1,1,1,1", true);
         		       
         		        if (formObject.sts_evnt_yd_cd.value == ""){
         		        	formObject.yd_cd_nm.value = "";
         		        }
         		        
	                	if (formObject.sts_evnt_yd_cd.value.length > 0 && formObject.sts_evnt_yd_cd.value.length != 7){
	                		ComShowCodeMessage("MST01019", formObject.sts_evnt_yd_cd.value);
	                		formObject.sts_evnt_yd_cd.value = "";
	                		formObject.yd_cd_nm.value = "";
	                		ComSetFocus(formObject.sts_evnt_yd_cd);
	                		return;
	                	} else {
	                		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
	                	}          		       
                	}   
         		break;
         		
                case "ComOpenPopupWithTargetAgmtNo": //agmt no
                if (formObject.agmt_seq.readOnly == false)
   			       ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '0,0,1', true); 			                	
                break;
                
                case "btn_close":
                    window.close();
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

         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             sheetObjects[i].CountPosition = 0;
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         document.form.st_cd.value = "";
         document.form.hidden_curdate.value = ComGetNowInfo("ymd");
         document.form.agmt_cty_cd.value = "HHO";
 	     document.getElementById("agmt_cty_cd").className = "input";
 	     document.getElementById("agmt_seq").className = "input";             
         initControl();
     }
      
     function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);    	 
        ComBtnDisable("btn_add");
        ComBtnDisable("btn_loadexcel");
        ComBtnDisable("btn_downexcel");
        ComSetFocus(document.form.st_cd);
     }      
      
 	 // Axon 이벤트 처리
 	 // 1. 이벤트catch
 	 function initControl() {
 		var formObj = document.form;
 		
        //axon_event.addListenerFormat('beforedeactivate','obj_blur',form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
 		axon_event.addListenerFormat('blur',	'obj_blur',          form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리 		
        axon_event.addListenerFormat('focus',   'obj_focus',         form);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
 	    axon_event.addListener('keydown',		'ComKeyEnter',	     'form'); //- 키 눌렸을때
 	    axon_event.addListenerFormat('keypress','obj_keypress',	     form);   //- 키 눌렸을때
		axon_event.addListener('change', 		'status_code_change','st_cd');
	    axon_event.addListenerFormat('keyup',	'obj_keyup',		 form);   //- 키 눌렸을때		
	    axon_event.addListenerFormat('keydown',	'obj_keydown',		 form);   //- 키 눌렸을때
  	}

 	function status_code_change(){
		var formObj  = document.form;		
        //formObj.st_cd.value : 0 ==> LSO
		//formObj.st_cd.value : 1 ==> SBO
		//formObj.st_cd.value : 2 ==> SBI
		//formObj.st_cd.value : 3 ==> MUO
		//formObj.st_cd.value : 4 ==> MUI		
		setFieldOfStatusCode(formObj.st_cd.value);
		if (formObj.agmt_seq.value != "") {
		   doActionIBSheet(sheetObjects[0],formObj,IBSEARCH01);
		}
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}
 	 
 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    var vKeyCode = event.keyCode;

	    switch(obj.dataformat) {
	        case "engup":
	            if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum');	  
	            if(obj.name=="agmt_cty_cd") ComKeyOnlyAlphabet('upper');
	            if(obj.name=="agmt_seq") ComKeyOnlyNumber('int');
	            break;
	        case "ymd":
	        	if(obj.name=="hire_date") ComKeyOnlyNumber('int', "-");
	        	break;
	    }
	}
 	
 	function obj_keydown() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;
 		
 		switch (obj.name) {
			case "agmt_seq":
				if ((vKeyCode == 13 || vKeyCode == 9) &&   //엔터 키 입력시 2번 검색하는것 임시로 막음.
					formObj.agmt_cty_cd.value.length == 3 && 
					formObj.agmt_seq.value.trim().length > 0 &&
					formObj.agmt_seq.readOnly == false) {
					// LSE 쪽에 검색 조건 호출
		    		ComSetFocus(formObj.agmt_cty_cd);
				}
			break;			
 	    }
 	}	
 	
  	function obj_keyup() {
 		
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

 		switch (obj.name) {
       
			case "agmt_cty_cd":
				if (formObj.agmt_cty_cd.value.length == 3) {
					ComSetFocus(formObj.agmt_seq);
				}
			break;
			
			case "sts_evnt_yd_cd":
				if ((vKeyCode == 13 || vKeyCode == 9) && 
					formObj.agmt_cty_cd.value.length == 3 && 
					formObj.agmt_seq.value.trim().length > 0 &&
					formObj.agmt_seq.readOnly == false) {
					// LSE 쪽에 검색 조건 호출
					ComSetFocus(formObj.agmt_cty_cd);
				} else if (vKeyCode == 13){
					ComSetFocus(formObj.agmt_cty_cd);
				}
				if (formObj.sts_evnt_yd_cd.value.length == 7) {
	        		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
	        		ComSetFocus(formObj.agmt_cty_cd);				
				}
			break;
 		}
 	}  	  	
 	
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_blur(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "hire_date"){
	    	ComAddSeparator(formObj.hire_date);
	    	if (ComGetNowInfo("ymd") < formObj.hire_date.value){
	    		formObj.hire_date.value = ComGetNowInfo("ymd");
	    		ComAlertFocus(formObj.hire_date,ComGetMsg("MST01006", "", "", ""));
	    	} else {
	    		ComAddSeparator(formObj.hire_date, "ymd");
	    	}
	    }
	    else if(event.srcElement.name == "agmt_seq"){
    		tcnt = tcnt + 1;
    		var toggle = tcnt%2;
    		if (toggle == 1){		    	
		    	if (formObj.agmt_seq.value.trim().length > 0){    			
	    		   doActionIBSheet(sheetObjects[0], formObj, IBSEARCH01);
	    		   tcnt = 0;
		    	}
    		} else {
    		} 
	    }
	    else if(event.srcElement.name == "sts_evnt_yd_cd"){
	    	
		    if (formObj.sts_evnt_yd_cd.value == ""){
		    	formObj.yd_cd_nm.value = "";
 		    }
		    
        	if (formObj.sts_evnt_yd_cd.value.length > 0 && formObj.sts_evnt_yd_cd.value.length != 7){
        		ComShowCodeMessage("MST01019", formObj.sts_evnt_yd_cd.value);
        		formObj.sts_evnt_yd_cd.value = "";
        		formObj.yd_cd_nm.value = "";
        		ComSetFocus(formObj.sts_evnt_yd_cd);
        		return;
        	}
	    }
	    else {
            //Validation 전체 체크(길이,format,최대,최소 등등)
            ComChkObjValid(obj);
	    }
	}
	
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_focus(){
		var formObj = document.form;
		var obj = event.srcElement;
		
	    if (event.srcElement.name == "hire_date"){		
	    	ComClearSeparator(formObj.hire_date, "ymd");
	    	ComSetFocus(formObj.hire_date);
	    }	
	}	
      
     /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetNo) {
             case 1:      // t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 410;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle1 = "||CNTR No.|Off-hire\nConfirm Flag|Off-Hire\nDue Date|TP/SZ|Term|AGMT No.|Contract No.|Lessor|Lessor Name|EQ Status|EQ Status Date|F/M|MVMT Status|MVMT Yard|MVMT Date|Off-Hire Yard|DOC\nCharge|DOC\nCredit|Lift On/Off Charge|Lift On/Off Charge|Free Day|Old/New|Pick Up\nCharge|Pick Up\nCredit|Remark(s)|a|b|c|d|e|f|g|h|s|t|Status Code";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 3, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,0,    daCenter,  true,   "ibflag");
                     InitDataProperty(0, cnt++, dtCheckBox,    40,   daCenter,  false,  "del_chk");
                     InitDataProperty(0, cnt++, dtData,        90,   daCenter,  	false,  "cntr_no",         false,  "",     dfNone,      0,    true,		true, 11);
                     InitDataProperty(0, cnt++, dtHidden,      100,  daCenter,  false,  "offh_sts_cd",         false,  "",     dfNone,      0,    true,		true);
                     InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,  "offh_due_dt",         false,  "",     dfDateYmd);
                     InitDataProperty(0, cnt++, dtCombo,       50,   daCenter,  false,  "cntr_tpsz_cd",        false,  "",     dfNone,      0,    true,		true, 2);
                     InitDataProperty(0, cnt++, dtData,        50,   daCenter,  false,  "lstm_cd",             false,  "",     dfNone,      0,    true,		true, 2);
                     InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,  "agmt_no",         	   false,  "",     dfNone,      0,    true,		true, 3);
                     InitDataProperty(0, cnt++, dtData,        120,  daLeft,    false,  "ref_no",              false,  "",     dfNone,      0,    true,		true, 20);
                     InitDataProperty(0, cnt++, dtData,        65,   daCenter,  false,  "vndr_seq",            false,  "",     dfNone,      0,    true,		true, 6);
                     InitDataProperty(0, cnt++, dtData,        100,  daLeft,    false,  "vndr_lgl_eng_nm",     false,  "",     dfNone,      0,    true,		true, 100);
                     InitDataProperty(0, cnt++, dtData,        60,   daCenter,  false,  "cntr_sts_cd",         false,  "",     dfNone,      0,    true,		true, 3);
                     InitDataProperty(0, cnt++, dtPopup,       100,  daCenter,  false,  "cntr_sts_evnt_dt",    false,  "",     dfDateYmd);
                     InitDataProperty(0, cnt++, dtData,        45,   daCenter,  false,  "full_flg",            false,  "",     dfNone,      0,    true,		true, 1);
                     InitDataProperty(0, cnt++, dtData,        90,   daCenter,  false,  "cnmv_sts_cd",         false,  "",     dfNone,      0,    true,		true, 2);
                     InitDataProperty(0, cnt++, dtData,        80,   daCenter,  false,  "crnt_yd_cd",          false,  "",     dfNone,      0,    true,		true, 7);
                     InitDataProperty(0, cnt++, dtPopup,       90,   daCenter,  false,  "cnmv_dt",             false,  "",     dfDateYmd);
                     
                     InitDataProperty(0, cnt++, dtData,        80,   daCenter,  false,  "lse_co_rtn_yd_cd",    false,  "",     dfNone,      0,    false,	false, 7);                     
                     
                     InitDataProperty(0, cnt++, dtData,        60,   daRight,   false,  "cntr_drff_amt",       false,  "",     dfNullFloat, 2,    true,		true, 13);
                     InitDataProperty(0, cnt++, dtData,        60,   daRight,   false,  "cntr_drff_cr_amt",    false,  "",     dfNullFloat, 2,    true,		true, 13);
                     InitDataProperty(0, cnt++, dtPopup,       80,   daCenter,  false,  "cntr_lft_chg_cur",    false,  "",     dfNone,      0,    true,		true, 3);
                     InitDataProperty(0, cnt++, dtData,        60,   daRight,   false,  "cntr_lft_chg_amt",    false,  "",     dfNullFloat, 2,    true,		true, 13);
                     InitDataProperty(0, cnt++, dtData,        70,   daRight,   false,  "rntl_chg_free_dys",   false,  "",     dfNullInteger,     0,    true,		true, 5);
                     InitDataProperty(0, cnt++, dtCombo,       70,   daCenter,  false,  "cntr_old_van_flg",    false,  "",     dfNone,      0,    true,		true);
                     InitDataProperty(0, cnt++, dtData,        70,   daRight,   false,  "cntr_pkup_chg_amt",   false,  "",     dfNullFloat, 2,    true,		true, 13);
                     InitDataProperty(0, cnt++, dtData,        70,   daRight,   false,  "cntr_pkup_cr_chg_amt",false,  "",     dfNullFloat, 2,    true,		true, 13);
                     InitDataProperty(0, cnt++, dtData,        110,  daLeft,    false,  "cntr_rmk",            false,  "",     dfNone,      0,    true,		true, 100);
                     
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "aeflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "beflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "ceflg",       false,     "",      dfNone,        0,     true,       true);                     
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "deflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "eeflg",       false,     "",      dfNone,        0,     true,       true);                     
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "feflg",       false,     "",      dfNone,        0,     true,       true);                     
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "ieflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "ueflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "seflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "teflg",       false,     "",      dfNone,        0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,     85, daCenter,  true,     "sts_cd",       false,     "",      dfNone,        0,     true,       true);
                     
                     
                     InitDataCombo(0, "cntr_old_van_flg", "Old|New", "O|N");
                     InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789"); //대문자/숫자 만     
                     InitDataValid(0, "offh_sts_cd", vtEngUpOnly); //대문자만
                     InitDataValid(0, "lstm_cd", vtEngUpOnly); //대문자만
                     InitDataValid(0, "ref_no", vtEngUpOther, "0123456789-"); //대문자/숫자 + "-"
                     InitDataValid(0, "vndr_seq", vtNumericOnly); //숫자만
                     InitDataValid(0, "vndr_lgl_eng_nm", vtEngUpOther, "0123456789"); //대문자/숫자 만
                     InitDataValid(0, "cntr_sts_cd", vtEngUpOnly); //대문자만
                     InitDataValid(0, "crnt_yd_cd", vtEngUpOther, "0123456789"); //대문자/숫자 만
                     InitDataValid(0, "cntr_rmk", vtEngOther, "0123456789-~[]{}_|*&^%$#@!,<>.?/-=\+ ");   //영문만     
                     
                     PopupImage  =  "img/btns_search.gif";
                     ShowButtonImage = 1;
                     SelectFontBold = true;
                     SelectHighLight = false;                     
                 }
                 break;
                 
             case 2:      // t1sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 170;
                 
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 10, 100);

                 var HeadTitle1 = "|Sel.|CNTR No.|Off-Hire\nConfirm Flag|Off-Hire\nConfirm Date|TP/SZ|Term|AGMT No.|Contract No.|Lessor|Lessor\nName|EQ\nStatus|EQ Status\nDate|F/M|MVMT\nStatus|MVMT\nYard|MVMT Date|Off-Hire Yard|DOC\nCharge|DOC\nCredit|Lift On/Off Charge|Lift On/Off Charge|Free Day|Old/New|Pick Up\nCharge|Pick Up\nCredit|Remark(s)|a|b|c|d|e|f|g|h|s|t";

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(ComCountHeadTitle(HeadTitle1), 3, 0, true);
                 //InitColumnInfo(ComCountHeadTitle(HeadTitle1), 3, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus,0,    daCenter,  true,   "ibflag");
                 InitDataProperty(0, cnt++, dtCheckBox,    40,   daCenter,  false,  "del_chk");
                 InitDataProperty(0, cnt++, dtData,        90,   daCenter,  false,  "cntr_no",             false,  "",     dfNone,      0,    true,		true, 10);
                 InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,  "offh_sts_cd",         false,  "",     dfNone,      0,    true,		true);
                 InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,  "offh_due_dt",         false,  "",     dfDateYmd);
                 InitDataProperty(0, cnt++, dtCombo,       50,   daCenter,  false,  "cntr_tpsz_cd",        false,  "",     dfNone,      0,    true,		true, 2);
                 InitDataProperty(0, cnt++, dtData,        50,   daCenter,  false,  "lstm_cd",             false,  "",     dfNone,      0,    true,		true, 2);
                 InitDataProperty(0, cnt++, dtData,        100,  daCenter,  false,  "agmt_no",         	   false,  "",     dfNone,      0,    true,		true, 3);
                 InitDataProperty(0, cnt++, dtData,        120,  daLeft,    false,  "ref_no",              false,  "",     dfNone,      0,    true,		true, 20);
                 InitDataProperty(0, cnt++, dtData,        65,   daCenter,  false,  "vndr_seq",            false,  "",     dfNone,      0,    true,		true, 6);
                 InitDataProperty(0, cnt++, dtData,        100,  daLeft,    false,  "vndr_lgl_eng_nm",     false,  "",     dfNone,      0,    true,		true, 100);
                 InitDataProperty(0, cnt++, dtData,        60,   daCenter,  false,  "cntr_sts_cd",         false,  "",     dfNone,      0,    true,		true, 3);
                 InitDataProperty(0, cnt++, dtPopup,       100,  daCenter,  false,  "cntr_sts_evnt_dt",    false,  "",     dfDateYmd);
                 InitDataProperty(0, cnt++, dtData,        45,   daCenter,  false,  "full_flg",            false,  "",     dfNone,      0,    true,		true, 1);
                 InitDataProperty(0, cnt++, dtData,        50,   daCenter,  false,  "cnmv_sts_cd",         false,  "",     dfNone,      0,    true,		true, 2);
                 InitDataProperty(0, cnt++, dtData,        70,   daCenter,  false,  "crnt_yd_cd",          false,  "",     dfNone,      0,    true,		true, 7);
                 InitDataProperty(0, cnt++, dtPopup,       90,   daCenter,  false,  "cnmv_dt",             false,  "",     dfDateYmd);
                 
                 InitDataProperty(0, cnt++, dtData,        80,   daCenter,  false,  "lse_co_rtn_yd_cd",    false,  "",     dfNone,      0,    false,	false, 7);
                 
                 InitDataProperty(0, cnt++, dtData,        60,   daRight,   false,  "cntr_drff_amt",       false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtData,        60,   daRight,   false,  "cntr_drff_cr_amt",    false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtPopup,       80,   daCenter,  false,  "cntr_lft_chg_cur",    false,  "",     dfNone,      0,    true,		true, 3);
                 InitDataProperty(0, cnt++, dtData,        60,   daRight,   false,  "cntr_lft_chg_amt",    false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtData,        70,   daRight,   false,  "rntl_chg_free_dys",   false,  "",     dfNullInteger,     0,    true,		true, 5);
                 InitDataProperty(0, cnt++, dtCombo,       70,   daCenter,  false,  "cntr_old_van_flg",    false,  "",     dfNone,      0,    true,		true);
                 InitDataProperty(0, cnt++, dtData,        70,   daRight,   false,  "cntr_pkup_chg_amt",   false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtData,        70,   daRight,   false,  "cntr_pkup_cr_chg_amt",false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtData,        110,  daLeft,    false,  "cntr_rmk",            false,  "",     dfNone,      0,    true,		true, 100);
                 
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "aeflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "beflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ceflg",       false,     "",      dfNone,        0,     true,       true);                     
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "deflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "eeflg",       false,     "",      dfNone,        0,     true,       true);                 
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "feflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ieflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,     	 85, daCenter,  true,     "ueflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,       85, daCenter,  true,     "seflg",       false,     "",      dfNone,        0,     true,       true);
                 InitDataProperty(0, cnt++ , dtHidden,       85, daCenter,  true,     "teflg",       false,     "",      dfNone,        0,     true,       true);
             
                 
                 InitDataCombo(0, "cntr_old_van_flg", "Old|New", "O|N");
                 InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789"); //대문자/숫자 만     
                 InitDataValid(0, "offh_sts_cd", vtEngUpOnly); //대문자만
                 InitDataValid(0, "lstm_cd", vtEngUpOnly); //대문자만
                 InitDataValid(0, "ref_no", vtEngUpOther, "0123456789-"); //대문자/숫자 + "-"
                 InitDataValid(0, "vndr_seq", vtNumericOnly); //숫자만
                 InitDataValid(0, "vndr_lgl_eng_nm", vtEngUpOther, "0123456789"); //대문자/숫자 만
                 InitDataValid(0, "cntr_sts_cd", vtEngUpOnly); //대문자만
                 InitDataValid(0, "crnt_yd_cd", vtEngUpOther, "0123456789"); //대문자/숫자 만
                 InitDataValid(0, "cntr_rmk", vtEngOther, "0123456789-~[]{}_|*&^%$#@!,<>.?/-=\+ ");   //영문만                     
                 
                 PopupImage  =  "img/btns_search.gif";
                 ShowButtonImage = 1;
                 SelectFontBold = true;
                 SelectHighLight = false;                     
             }
             break;   
             case 3:      // t1sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 170;
                 
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 10, 100);

                 var HeadTitle1 = "CNTR No.|DOC\nCharge|DOC\nCredit|Pick Up\nCharge|Pick Up\nCredit|Remark(s)|Status Code";

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(ComCountHeadTitle(HeadTitle1), 3, 0, true);
                 //InitColumnInfo(ComCountHeadTitle(HeadTitle1), 3, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtData,        90,   daCenter,  false,  "cntr_no",             false,  "",     dfNone,      0,    true,		true, 10);
                 InitDataProperty(0, cnt++, dtData,        60,   daRight,   false,  "cntr_drff_amt",       false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtData,        60,   daRight,   false,  "cntr_drff_cr_amt",    false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtData,        70,   daRight,   false,  "cntr_pkup_chg_amt",   false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtData,        70,   daRight,   false,  "cntr_pkup_cr_chg_amt",false,  "",     dfNullFloat, 2,    true,		true, 13);
                 InitDataProperty(0, cnt++, dtData,        110,  daLeft,    false,  "cntr_rmk",            false,  "",     dfNone,      0,    true,		true, 100);
                 InitDataProperty(0, cnt++, dtData,        110,  daLeft,    false,  "st_cd",               false,  "",     dfNone,      0,    true,		true, 100);
             }
             break;   
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //조회
            if(validateForm(sheetObj,formObj,sAction)){
            	var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
            	
        		var arrRow = dupRows.split(",");

		        if (dupRows != ""){
	       			 //오류메시지 : 데이터가 중복됩니다.
	       			 ComShowCodeMessage("MST00002", sheetObj.CellValue(arrRow[0],2));
		             sheetObj.SelectCell(arrRow[0], 2, true);
	       			 return;
		        }
				//color 원복
				for (var i = 1; i <= sheetObj.RowCount; i++){
					setsheetRowColorBlack(i);				
				}
                if (formObj.st_cd.value == "0" ){
                   sheetObj.WaitImageVisible=false;
                   ComOpenWait(true);
 			       formObj.f_cmd.value = SEARCH;
 			       sheetObj.DoSearch("EES_MST_0024GS.do", FormQueryString(formObj));
 			       ComOpenWait(false);
 	               setFieldOfStatusCode(formObj.st_cd.value);
 				   setSearchField('0');			       
                } else if(formObj.st_cd.value == "1" || formObj.st_cd.value == "2" || formObj.st_cd.value == "3" || formObj.st_cd.value == "4" || formObj.st_cd.value == "5" || formObj.st_cd.value == "6" || formObj.st_cd.value == "7" ){
//             	    formObj.hid_cntr_no.value = "";
// 					for (var i = 1; i <= sheetObj.RowCount; i++){
// 						if (formObj.hid_cntr_no.value == ""){
// 							if (sheetObj.RowHidden(i) != true)
// 							   formObj.hid_cntr_no.value = sheetObj.CellValue(i,"cntr_no");
// 						} else {
// 							if (sheetObj.RowHidden(i) != true)
// 							   formObj.hid_cntr_no.value = formObj.hid_cntr_no.value + "," + sheetObj.CellValue(i,"cntr_no");
// 						}
// 					}
 					if (sheetObj.RowCount > 0){
 	                    sheetObj.WaitImageVisible=false;
 	                    ComOpenWait(true); 						
 						formObj.f_cmd.value = SEARCH;
 						sheetObj.DoSearch("EES_MST_0024GS.do", FormQueryString(formObj)+"&"+sheetObj.GetSaveString(true));
 						ComOpenWait(false);
 					} else {
 	            		ComShowCodeMessage("MST00001", "CNTR No.");
 	            		return;							
 					}
 		            setFieldOfStatusCode(formObj.st_cd.value);
 					setSearchField('0');
 					
 					var cntrnochk = false;
 					for (var i = 1; i <= sheetObj.RowCount; i++){
 						if(sheetObj.CellValue(i, "agmt_no") == ""){
 							cntrnochk = true;
 							sheetObj.CellFontColor(i,"cntr_no") = sheetObj.RgbColor(255, 0, 0);
 							sheetObj.CellEditable(i, "cntr_no") = true;
 						} else {
 							sheetObj.CellEditable(i, "cntr_no") = false;
 						}
 					}
 				    if (cntrnochk == true)
 				    	ComShowCodeMessage("MST02014");
                }
             }
			break;
			
			case IBINSERT:      // 입력
				sheetObj.DataInsert();
			    setFieldOfStatusCode(formObj.st_cd.value);
			    sheetObj.CellValue2(sheetObj.SelectRow,"cntr_tpsz_cd") = "";
			    sheetObj.SelectCell(sheetObj.SelectRow,"cntr_no", true);
			break;
			
			case IBDELETE:      // 삭제
   	   		if (sheetObj.id == 'sheet1') {  
   	   		    sheetObj.SelectFontBold = false;
	   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
					//ComRowHide(sheetObj,"del_chk");
					ComRowHideDelete(sheetObj,"del_chk");
					sheetObj.SelectFontBold = true;
				}
			}
			break;
			
			case IBSAVE:
				//dup 체크
            	var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
        		var arrRow = dupRows.split(",");
		        if (dupRows != ""){
	       			 //오류메시지 : 데이터가 중복됩니다.
	       			 ComShowCodeMessage("MST00002", sheetObj.CellValue(arrRow[0],"cntr_no"));
		             sheetObj.SelectCell(arrRow[0], "cntr_no", true);
	       			 return;
		        }
		        
				for(var i = 0; i <= sheetObj.RowCount; i++){
					if (sheetObj.CellEditable(i, "cntr_no") == true){
						ComShowCodeMessage("MST02015");
						sheetObj.SelectCell(i, "cntr_no", true);
						return;
					}
					
			    	var lftamt = parseFloat(sheetObj.CellValue(i,"cntr_lft_chg_amt"));
			    	var currcd = sheetObj.CellValue(i,"cntr_lft_chg_cur");
			    	if (lftamt > 0 && currcd == ""){
			    		ComShowCodeMessage("MST00001", "Lift On/Off Charge Currency.");
			    		sheetObj.SelectCell(i,"cntr_lft_chg_amt");
			    		return;
			    	}
				}
				
				//필수항목에 값이 입력 되었는지 확인한 뒤 에러 메시지를 표시
				if(formObj.st_cd.value == "0"){
				   if (formObj.hire_date.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Date");
			    	   ComSetFocus(formObj.hire_date);
			    	   return;
				   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Yard");
			    	   ComSetFocus(formObj.sts_evnt_yd_cd);
			    	   return;
				   } 
				} else if (formObj.st_cd.value == "1"){
				   if (formObj.hire_date.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Date");
			    	   ComSetFocus(formObj.hire_date);
			    	   return;
				   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Yard");
			    	   ComSetFocus(formObj.sts_evnt_yd_cd);
			    	   return;
				   } else if (formObj.agmt_cty_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "AGMT No.");
			    	   ComSetFocus(formObj.agmt_cty_cd);
			    	   return;					   
				   } else if (formObj.agmt_seq.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "AGMT No.");
			    	   ComSetFocus(formObj.agmt_seq);
			    	   return;					   
				   }
				   
				   //Sheet의 필수입력 체크.
				   for(var i = 0; i <= sheetObj.RowCount; i++){
					   var cv = sheetObj.CellValue(i,"cntr_no");
					   if (cv.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "CNTR No.");
				    	   sheetObj.SelectCell(i, "cntr_no", true);
				    	   return;						   
					   }
				   }
				} else if (formObj.st_cd.value == "2"){
				   if (formObj.hire_date.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Date");
			    	   ComSetFocus(formObj.hire_date);
			    	   return;
				   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Yard");
			    	   ComSetFocus(formObj.sts_evnt_yd_cd);
			    	   return;
				   }
				   
				   //Sheet의 필수입력 체크.
				   for(var i = 0; i <= sheetObj.RowCount; i++){
					   var cv = sheetObj.CellValue(i,"cntr_no");
					   if (cv.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "CNTR No.");
				    	   sheetObj.SelectCell(i, "cntr_no", true);
				    	   return;						   
					   }
				   }					
				} else if (formObj.st_cd.value == "3"){
					   if (formObj.hire_date.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Date");
				    	   ComSetFocus(formObj.hire_date);
				    	   return;
					   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Yard");
				    	   ComSetFocus(formObj.sts_evnt_yd_cd);
				    	   return;
					   } else if (formObj.agmt_cty_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "AGMT No.");
				    	   ComSetFocus(formObj.agmt_cty_cd);
				    	   return;					   
					   } else if (formObj.agmt_seq.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "AGMT No.");
				    	   ComSetFocus(formObj.agmt_seq);
				    	   return;					   
					   }
					   
					   //Sheet의 필수입력 체크.
					   for(var i = 0; i <= sheetObj.RowCount; i++){
						   var cv = sheetObj.CellValue(i,"cntr_no");
						   if (cv.trim() == ""){
					    	   ComShowCodeMessage("MST00001", "CNTR No.");
					    	   sheetObj.SelectCell(i, "cntr_no", true);
					    	   return;						   
						   }
					   }
				 } else if (formObj.st_cd.value == "4"){
				   if (formObj.hire_date.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Date");
			    	   ComSetFocus(formObj.hire_date);
			    	   return;
				   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Yard");
			    	   ComSetFocus(formObj.sts_evnt_yd_cd);
			    	   return;
				   }
				   
				   //Sheet의 필수입력 체크.
				   for(var i = 0; i <= sheetObj.RowCount; i++){
					   var cv = sheetObj.CellValue(i,"cntr_no");
					   if (cv.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "CNTR No.");
				    	   sheetObj.SelectCell(i, "cntr_no", true);
				    	   return;						   
					   }
				   }
				 } else if (formObj.st_cd.value == "5"){
					 if (formObj.hire_date.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Date");
				    	   ComSetFocus(formObj.hire_date);
				    	   return;
					   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Yard");
				    	   ComSetFocus(formObj.sts_evnt_yd_cd);
				    	   return;
					   } else if (formObj.agmt_cty_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "AGMT No.");
				    	   ComSetFocus(formObj.agmt_cty_cd);
				    	   return;					   
					   } else if (formObj.agmt_seq.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "AGMT No.");
				    	   ComSetFocus(formObj.agmt_seq);
				    	   return;					   
					   }
					   
					   //Sheet의 필수입력 체크.
					   for(var i = 0; i <= sheetObj.RowCount; i++){
						   var cv = sheetObj.CellValue(i,"cntr_no");
						   if (cv.trim() == ""){
					    	   ComShowCodeMessage("MST00001", "CNTR No.");
					    	   sheetObj.SelectCell(i, "cntr_no", true);
					    	   return;						   
						   }
					   }		
				 } else if (formObj.st_cd.value == "6"){
					   if (formObj.hire_date.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Date");
				    	   ComSetFocus(formObj.hire_date);
				    	   return;
					   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Yard");
				    	   ComSetFocus(formObj.sts_evnt_yd_cd);
				    	   return;
					   }
					 //Sheet의 필수입력 체크.
					   for(var i = 0; i <= sheetObj.RowCount; i++){
						   var cv = sheetObj.CellValue(i,"cntr_no");
						   if (cv.trim() == ""){
					    	   ComShowCodeMessage("MST00001", "CNTR No.");
					    	   sheetObj.SelectCell(i, "cntr_no", true);
					    	   return;						   
						   }
					   }
				}  else if (formObj.st_cd.value == "7"){
					   if (formObj.hire_date.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Date");
				    	   ComSetFocus(formObj.hire_date);
				    	   return;
					   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Yard");
				    	   ComSetFocus(formObj.sts_evnt_yd_cd);
				    	   return;
					   }
					 //Sheet의 필수입력 체크.
					   for(var i = 0; i <= sheetObj.RowCount; i++){
						   var cv = sheetObj.CellValue(i,"cntr_no");
						   if (cv.trim() == ""){
					    	   ComShowCodeMessage("MST00001", "CNTR No.");
					    	   sheetObj.SelectCell(i, "cntr_no", true);
					    	   return;						   
						   }
					   }
				}
				
				
				// 체크된  TN, EN 이면서 F 일경우 Empty 상태에서 반납
				var vDelCheck = sheetObj.FindCheckedRow("del_chk").split("|");
				for(var x=0 ; x<vDelCheck.length-1 ; x++) {
					if( (sheetObj.CellValue(vDelCheck[x], "full_flg") == "F" && sheetObj.CellValue(vDelCheck[x], "cnmv_sts_cd") == "TN")
 				        || (sheetObj.CellValue(vDelCheck[x], "full_flg") == "F" && sheetObj.CellValue(vDelCheck[x], "cnmv_sts_cd") == "EN") ){
							ComShowCodeMessage("MST01031");
							return ;
		 			}
				}
				var lsocnt = 0; //[CHM-201221413] LSO, 체크된 로우 카운트
				for (var i = 1; i <= sheetObj.RowCount; i++){
				   setsheetRowColorBlack(i);
				   if(formObj.st_cd.value != "0"){ //[CHM-201221413] LSO 인 경우, 체크된 것만 저장
					   if (sheetObj.RowStatus(i) == "R" && !sheetObj.RowHidden(i)){
						   sheetObj.RowStatus(i) = "U";
					   }
					   else if (sheetObj.RowHidden(i) && (sheetObj.RowStatus(i) == "U" || sheetObj.RowStatus(i) == "I")){
						   sheetObj.RowStatus(i) = "R";
					   }
				   }else{
					   if(sheetObj.RowStatus(i) == "U"){
						   lsocnt ++;
					   }
				   }
				}
				
//				if (sheetObj.RowCount > 0){
//					if (formObj.st_cd.value == "0"){
////					if (formObj.st_cd.value == "4" || formObj.st_cd.value == "0"){ 
////						if (formObj.st_cd.value == "4"){ 
////							if (!ComShowCodeConfirm("MST02023","Mis-used out", "MUI")){
////								return;
////							}
////							if (!ComShowCodeConfirm("MST02024","MUI")){
////							   	return;
////							}
////						}
//						if (formObj.st_cd.value == "0"){ //[CHM-201221413] - 기존 메시지 주석처리
//							if (!ComShowCodeConfirm("MST02023","Lease out target", "LSO")){
//								return;
//							}
//							if (!ComShowCodeConfirm("MST02024","LSO")){
//							   	return;
//							}
//						}
//					}
//				}

				if(formObj.st_cd.value == "0"){ //[CHM-201221413] LSO 인경우에 
					if(lsocnt > 0){
						if (!ComShowCodeConfirm("MST02028",lsocnt)){ // [CHM-201221413] 'You selected {?msg1} container(s).\n Do you want to create as LSO selected container(s)?'
							return;
						}
					}else{
						return;
					}
				}
				
				sheetObjects[1].RemoveAll();
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);				
		    	formObj.f_cmd.value = MULTI;
     	        var sParam = ComGetSaveString(sheetObjects[0]);
     	        sParam += "&" + FormQueryString(formObj);
     	        var sXml = sheetObj.GetSaveXml("EES_MST_0024GS.do", sParam);
     	        sheetObjects[1].LoadSaveXml(sXml);
     	        ComOpenWait(false);
				var sheetcnt = 1;
				
				var aecnt = 0;
				var becnt = 0;
				var cecnt = 0;
				var decnt = 0;
				var eecnt = 0;
				var fecnt = 0;
				var iecnt = 0;
				var uecnt = 0;
				var secnt = 0;
				var tecnt = 0;
				var suc = 0;
				
//				aeflg  MST_CNTR_PRE_STS의 체크  error E
//				beflg  Input Yard와 movement yard가 서로 다르면 error message('E') 처리 
//				ceflg  공백처리 에러날 염려 없음
//				deflg  LSO 경우 MVMT Status 가 ‘MT’, ‘ID’, ‘EN’, ‘TN’ 가 아니면 에러	
//				eeflg  SBO 경우 MVMT Status 가 ‘MT’가 아니면 에러
//				feflg 
//				teflg  XX(SOC) 인경우 term_cd 가 'SH'가 아닌경우 term_cd 에러 
//				seflg  XX(SOC) 인경우 MVMT status 가 'OP','OC','TN','EN'이 아니고 BKG cancel아  아닌경우 MVMT status 에러 
//				ueflg 'mst_cntr_sts_his update flg ,error 이면 'E'
//				ieflg 'mst_container flg Error 이면 E
				
				for (var j = 1; j <= sheetObjects[1].RowCount; j++){
					if (sheetObjects[1].CellValue(j, "aeflg") == "E" || 
						sheetObjects[1].CellValue(j, "beflg") == "E" ||	
						sheetObjects[1].CellValue(j, "ceflg") == "E" ||
						sheetObjects[1].CellValue(j, "deflg") == "E" ||
						sheetObjects[1].CellValue(j, "eeflg") == "E" ||
						sheetObjects[1].CellValue(j, "ieflg") == "E" ||
						sheetObjects[1].CellValue(j, "ueflg") == "E" ||
						sheetObjects[1].CellValue(j, "seflg") == "E" ||
						sheetObjects[1].CellValue(j, "teflg") == "E" ||
						sheetObjects[1].CellValue(j, "feflg") == "E"){
						
						for (var i = 1; i <= sheetObj.RowCount; i++){
							if (sheetObj.CellValue(i,"cntr_no") == sheetObjects[1].CellValue(j, "cntr_no")){
								if (sheetObjects[1].CellValue(j, "aeflg") == "E"){
									sheetObj.CellFontColor(i,"cntr_sts_cd") = sheetObj.RgbColor(255, 0, 0);
									aecnt = aecnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "beflg") == "E"){
									sheetObj.CellFontColor(i,"crnt_yd_cd") = sheetObj.RgbColor(255, 0, 0);
									becnt = becnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "ceflg") == "E"){
									sheetObj.CellFontColor(i,"cnmv_dt") = sheetObj.RgbColor(255, 0, 0);
									cecnt = cecnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "deflg") == "E"){
									sheetObj.CellFontColor(i,"cnmv_sts_cd") = sheetObj.RgbColor(255, 0, 0);
									decnt = decnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "eeflg") == "E"){
									sheetObj.CellFontColor(i,"cnmv_sts_cd") = sheetObj.RgbColor(255, 0, 0);
									eecnt = eecnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "seflg") == "E"){
									sheetObj.CellFontColor(i,"cnmv_sts_cd") = sheetObj.RgbColor(255, 0, 0);
									secnt = secnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "feflg") == "E"){
									sheetObj.CellFontColor(i,"cntr_tpsz_cd") = sheetObj.RgbColor(255, 0, 0);
									fecnt = fecnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "ieflg") == "E"){
									setsheetRowColorRed(i);
									iecnt = iecnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "ueflg") == "E"){
									setsheetRowColorRed(i);
									uecnt = uecnt + 1;
								}
								if (sheetObjects[1].CellValue(j, "teflg") == "E"){
									sheetObj.CellFontColor(i,"lstm_cd") = sheetObj.RgbColor(255, 0, 0);
									tecnt = tecnt + 1;
								}
							}
						}
					}
					else {
						suc = suc + 1;
					}
				}
					
				var sMsg = "";

				if (suc > 0){
					sMsg = ComGetMsg("MST01025", "", "", "");
				}				
				if (iecnt > 0 || uecnt > 0){
					sMsg = sMsg + ComGetMsg("MST02008", "", "", "");
				}
				if (aecnt > 0){
					sMsg = sMsg + ComGetMsg("MST02004", "", "", "");
				}
				if (becnt > 0){
					sMsg = sMsg + ComGetMsg("MST02011", "", "", "");
				}
				if (cecnt > 0){
					sMsg = sMsg + ComGetMsg("MST02012", "", "", "");
				}
				if (decnt > 0){
					sMsg = sMsg + ComGetMsg("MST02013", "", "", "");
				}
				if (fecnt > 0){
					sMsg = sMsg + ComGetMsg("MST02020", "", "", "");
				}
				if (eecnt > 0){
					sMsg = sMsg + ComGetMsg("MST02022", "", "", "");
				}
				if (secnt > 0){
					sMsg = sMsg + ComGetMsg("MST02029", "", "", "");
				}
				if (tecnt > 0){
					sMsg = sMsg + ComGetMsg("MST02030", "", "", "");
				}
				if (aecnt > 0 || becnt > 0 || cecnt > 0 || decnt > 0 || fecnt > 0 || eecnt > 0 || secnt > 0 || tecnt > 0){
					sMsg = sMsg + ComGetMsg("MST02021", "", "", "");
				}
			
				ComShowMessage (sMsg);
				
				
			break;
			
            case IBSEARCH_ASYNC02://Sheet Combo 데이타 담아오기
 	 	   		formObj.f_cmd.value = SEARCH02;
 	  	   		var xml = sheetObj.GetSearchXml ("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd=U");
				var chk = xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchXml(xml);
				   return;
				} 	  	   		
 	  	   		var cols = ComMstXml2ComboString(xml, "code", "code|code_nm", "\t");
 	  	   		sheetObj.InitDataCombo(0, "cntr_tpsz_cd", cols[0], cols[0]);    // IBSheet내 Combo 초기화
 	  	   	break;
 	  	   	
            case IBSEARCH01:
				formObj.f_cmd.value = SEARCH05;
            	var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
				var chk = sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				   sheetObj.LoadSearchXml(sXml);
				   return;
				}            	
            	formObj.ref_no.value = ComXmlString(sXml, "ref_no");
            	formObj.vndr_seq.value = ComXmlString(sXml, "vndr_seq");
            	formObj.vndr_nm.value = ComXmlString(sXml, "vndr_lgl_eng_nm");
            	formObj.vndr_abbr.value = ComXmlString(sXml, "vndr_abbr_nm");   
            	var lstmcd = ComXmlString(sXml, "lstm_cd");

            	if (formObj.ref_no.value.length == 0) {
				    formObj.agmt_seq.value = "";
		            formObj.ref_no.value = "";
	            	formObj.vndr_seq.value = "";
	            	formObj.vndr_nm.value = "";
	            	formObj.vndr_abbr.value = "";
	            	ComShowCodeMessage("MST01003");
					ComSetFocus(formObj.agmt_seq);
					blurflg = true;
					return;
            	}
      	    	if (formObj.st_cd.value == "1" && lstmcd != "SO"){
      	    		formObj.agmt_seq.value = "";
      	    		formObj.ref_no.value = "";
      	    		formObj.vndr_seq.value = "";
      	    		formObj.vndr_nm.value = "";
      	    		formObj.vndr_abbr.value = "";
      	    		blurflg = true;
      	    		ComShowCodeMessage("MST01003");
      	    		ComSetFocus(formObj.agmt_seq);
      	    		return;
      	    	}
      	    	if (formObj.st_cd.value == "3" && lstmcd != "MO"){
      	    		formObj.agmt_seq.value = "";
      	    		formObj.ref_no.value = "";
      	    		formObj.vndr_seq.value = "";
      	    		formObj.vndr_nm.value = "";
      	    		formObj.vndr_abbr.value = "";
      	    		blurflg = true;
      	    		ComShowCodeMessage("MST01003");
      	    		ComSetFocus(formObj.agmt_seq);
      	    		return;
      	    	}
      	    	if (formObj.st_cd.value == "5" && (lstmcd != "OW" && lstmcd != "OL" && lstmcd != "LP")){
      	    		formObj.agmt_seq.value = "";
      	    		formObj.ref_no.value = "";
      	    		formObj.vndr_seq.value = "";
      	    		formObj.vndr_nm.value = "";
      	    		formObj.vndr_abbr.value = "";
      	    		blurflg = true;
      	    		ComShowCodeMessage("MST01003");
      	    		ComSetFocus(formObj.agmt_seq);
      	    		return;
      	    	}
            break;
            
			case IBSEARCH02 :
				if (formObj.sts_evnt_yd_cd.value != ""){
					formObj.f_cmd.value = SEARCH06;
	            	var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+formObj.sts_evnt_yd_cd.value+"&yd_chk_flg=Y");
					var chk = sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchXml(sXml);
					   return;
					}
	            	var codestr = ComXmlString(sXml, "code_nm");
	            	if (codestr == ""){
	            		ComShowCodeMessage("MST01019", formObj.sts_evnt_yd_cd.value);
	            		formObj.sts_evnt_yd_cd.value = "";
	            		formObj.yd_cd_nm.value = "";
	            		ComSetFocus(formObj.sts_evnt_yd_cd);
	            		return;
	            	} else {
	            		formObj.yd_cd_nm.value = codestr;
	            	}
				} else {
					formObj.yd_cd_nm.value = "";
				}
            break;            
         }
         sheetObj.ShowDebugMsg = false;
     }
				
 	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			sheetObj.CellValue(Row,Col) = aryPopupData[0][2];
		}
	} 	

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
      
     function func_calendar(){
      	var formObj = document.form; 
        if (formObj.hire_date.readOnly == false){    	 
  	       var cal = new ComCalendar();
  	       cal.select(document.form.hire_date, "yyyy-MM-dd");
        } 
     }
     
     /**
     * 아이비시트 팝업 클릭시 이벤트
     */
    function sheet1_OnPopupClick(sheetObj, Row,Col,Value)
    {
    	 if (sheetObj.ColSaveName(Col) == "cntr_lft_chg_cur"){
        	 var param = "cnt_cd=&curr_cd="+sheetObj.CellValue(Row,Col)+"&curr_desc=";
        	 ComOpenPopup('/hanjin/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 500, 420, 'setPopData_Currency', '0,0,1', true, true, Row, "cntr_lft_chg_cur", 1);
    	 }
         if (sheetObj.ColSaveName(Col) != "cnmv_dt" && 
        	 sheetObj.ColSaveName(Col) != "cntr_sts_evnt_dt" &&
        	 sheetObj.ColSaveName(Col) != "offh_due_dt") return;
         var cal = new ComCalendarGrid("myCal");
         cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
    }     
     
	// [sheet1] 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
 		if(sheetObj.RowCount > 0){
 			for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
 				if( (sheetObj.CellValue(i, "full_flg") == "F" && sheetObj.CellValue(i, "cnmv_sts_cd") == "TN")
 				   || (sheetObj.CellValue(i, "full_flg") == "F" && sheetObj.CellValue(i, "cnmv_sts_cd") == "EN") ){
					sheetObj.CellBackColor(i, "full_flg") = sheetObj.RgbColor(255, 0, 0);
					sheetObj.CellBackColor(i, "cnmv_sts_cd") = sheetObj.RgbColor(255, 0, 0);
				}
 	 		}
		}
	 }
	
  	/**
  	 * Currency Pop-up Return Value 처리 부분<br>
  	 * @param {arry} returnedValues Pop-up 화면의 Return value array
  	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
  	 * @param 대상IBSheet의 Sheet Array index
  	 */
  	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
  	    var formObj  = document.form;
  	    var sheetObj = sheetObjects[0];
  	    if ( aryPopupData.length > 0 ) {
  	    	if (formObj.st_cd.value == "1" && aryPopupData[0][6] != "SO"){
  	    		formObj.agmt_seq.value = "";
  	    		formObj.ref_no.value = "";
  	    		formObj.vndr_seq.value = "";
  	    		formObj.vndr_nm.value = "";
  	    		formObj.vndr_abbr.value = "";  	    		
  	    		ComShowCodeMessage("MST01003");
  	    		ComSetFocus(formObj.agmt_seq);
  	    		return;
  	    	}
  	    	if (formObj.st_cd.value == "3" && aryPopupData[0][6] != "MO"){
  	    		formObj.agmt_seq.value = "";
  	    		formObj.ref_no.value = "";
  	    		formObj.vndr_seq.value = "";
  	    		formObj.vndr_nm.value = "";
  	    		formObj.vndr_abbr.value = "";  	    		
  	    		ComShowCodeMessage("MST01003");
  	    		ComSetFocus(formObj.agmt_seq);
  	    		return;
  	    	}
  	    	if (formObj.st_cd.value == "5" && (aryPopupData[0][6] != "OW" && aryPopupData[0][6] != "OL" && aryPopupData[0][6] != "LP")){
  	    		formObj.agmt_seq.value = "";
  	    		formObj.ref_no.value = "";
  	    		formObj.vndr_seq.value = "";
  	    		formObj.vndr_nm.value = "";
  	    		formObj.vndr_abbr.value = "";  	    		
  	    		ComShowCodeMessage("MST01003");
  	    		ComSetFocus(formObj.agmt_seq);
  	    		return;
  	    	}
  	        ComSetObjValue(formObj.agmt_cty_cd, aryPopupData[0][3]);
  	        ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
  	        ComSetObjValue(formObj.ref_no,   aryPopupData[0][5]);
  	        ComSetObjValue(formObj.vndr_seq, aryPopupData[0][7]);
  	        ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][8]);
  	        ComSetObjValue(formObj.vndr_abbr,  aryPopupData[0][13]);
  	    }    
  	}
  	 
  	//Status Code에 따라서 화면 필드와 시트의 필드 조정
  	function setFieldOfStatusCode(code){
  	var formObj = document.form;
       var sheetObj = sheetObjects[0];
	    switch(code) {
		    case "0": //LSO
		       document.getElementById("hire_date").className = "input1";
		       document.getElementById("sts_evnt_yd_cd").className = "input1";
		       document.getElementById("agmt_cty_cd").className = "input";
		       document.getElementById("agmt_seq").className = "input";
		       formObj.agmt_cty_cd.readOnly = false;
		       formObj.agmt_seq.readOnly = false;
		       formObj.agmt_cty_cd.value = "HHO";

			   for(var i = 1; i <= sheetObj.RowCount; i++){
				   sheetObj.CellEditable(i, "cntr_no")              = false;
				   sheetObj.CellEditable(i, "offh_sts_cd")          = false;
				   sheetObj.CellEditable(i, "offh_due_dt")          = false;
				   sheetObj.CellEditable(i, "cntr_tpsz_cd")         = false;
				   sheetObj.CellEditable(i, "lstm_cd")              = false;
				   sheetObj.CellEditable(i, "agmt_no")          	= false;
				   sheetObj.CellEditable(i, "ref_no")               = false;
				   sheetObj.CellEditable(i, "vndr_seq")             = false;
				   sheetObj.CellEditable(i, "vndr_lgl_eng_nm")      = false;
				   sheetObj.CellEditable(i, "cntr_sts_cd")          = false;
				   sheetObj.CellEditable(i, "cntr_sts_evnt_dt")     = false;
				   sheetObj.CellEditable(i, "full_flg")             = false;
				   sheetObj.CellEditable(i, "cnmv_sts_cd")          = false;
				   sheetObj.CellEditable(i, "crnt_yd_cd")           = false;
				   sheetObj.CellEditable(i, "cnmv_dt")              = false;
				   sheetObj.CellEditable(i, "cntr_drff_amt")        = true;
				   sheetObj.CellEditable(i, "cntr_drff_cr_amt")     = true;
				   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = true;
				   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = true;
				   sheetObj.CellEditable(i, "rntl_chg_free_dys")    = false;
				   sheetObj.CellEditable(i, "cntr_old_van_flg")     = false;
				   sheetObj.CellEditable(i, "cntr_pkup_chg_amt")    = false;
				   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt") = false;
				   sheetObj.CellEditable(i, "cntr_rmk")             = true;	
				   
				   sheetObj.CellValue(i,"rntl_chg_free_dys") 	= "";
				   sheetObj.CellValue(i,"cntr_old_van_flg") 	= "";
				   sheetObj.CellValue(i,"cntr_pkup_chg_amt") 	= "";
				   sheetObj.CellValue(i,"cntr_pkup_cr_chg_amt") = "";
				   sheetObj.CellValue(i,"cntr_drff_cr_amt")     = "";				   
				   
				   if (sheetObj.CellValue(i,"cntr_lft_chg_amt") != "" && eval(sheetObj.CellValue(i,"cntr_lft_chg_amt")) != 0){
					   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
					   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
				   }
				   
				   sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
			   }
	 		   ComBtnDisable("btn_add");
	 		   ComBtnDisable("btn_loadexcel");
	 		   ComBtnDisable("btn_downexcel");
	 		   ComBtnDisable("btn_delete"); //[CHM-201221413]
			break;
				
			case "1": //SBO
		       document.getElementById("hire_date").className = "input1";
		       document.getElementById("sts_evnt_yd_cd").className = "input1";
		       document.getElementById("agmt_cty_cd").className = "input1";
		       document.getElementById("agmt_seq").className = "input1";
		       formObj.agmt_cty_cd.readOnly = false;
		       formObj.agmt_seq.readOnly = false;
		       formObj.agmt_cty_cd.value = "HHO";
		       
			   for(var i = 1; i <= sheetObj.RowCount; i++){
				   //sheetObj.CellEditable(i, "cntr_no")              = true;
				   sheetObj.CellEditable(i, "offh_sts_cd")          = false;
				   sheetObj.CellEditable(i, "offh_due_dt")          = false;
				   sheetObj.CellEditable(i, "cntr_tpsz_cd")         = false;
				   sheetObj.CellEditable(i, "lstm_cd")              = false;
				   sheetObj.CellEditable(i, "agmt_no")              = false;
				   sheetObj.CellEditable(i, "ref_no")               = false;
				   sheetObj.CellEditable(i, "vndr_seq")             = false;
				   sheetObj.CellEditable(i, "vndr_lgl_eng_nm")      = false;
				   sheetObj.CellEditable(i, "cntr_sts_cd")          = false;
				   sheetObj.CellEditable(i, "cntr_sts_evnt_dt")     = false;
				   sheetObj.CellEditable(i, "full_flg")             = false;
				   sheetObj.CellEditable(i, "cnmv_sts_cd")          = false;
				   sheetObj.CellEditable(i, "crnt_yd_cd")           = false;
				   sheetObj.CellEditable(i, "cnmv_dt")              = false;
				   sheetObj.CellEditable(i, "cntr_drff_amt")        = false;
				   sheetObj.CellEditable(i, "cntr_drff_cr_amt")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
				   sheetObj.CellEditable(i, "rntl_chg_free_dys")    = false;
				   sheetObj.CellEditable(i, "cntr_old_van_flg")     = false;
				   sheetObj.CellEditable(i, "cntr_pkup_chg_amt")    = true;
				   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt") = true;
				   sheetObj.CellEditable(i, "cntr_rmk")             = true;
				   
				   sheetObj.CellValue(i,"cntr_drff_amt") = "";
				   sheetObj.CellValue(i,"cntr_drff_cr_amt") = "";
				   sheetObj.CellValue(i,"cntr_old_van_flg") = "";  
				   
				   sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
			   }
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   ComBtnEnable("btn_downexcel");
			   ComBtnEnable("btn_delete");
			break;
				
			case "2": //SBI
		       document.getElementById("hire_date").className = "input1";
		       document.getElementById("sts_evnt_yd_cd").className = "input1";
		       document.getElementById("agmt_cty_cd").className = "input2";
		       document.getElementById("agmt_seq").className = "input2";
		       formObj.agmt_cty_cd.value = "";
		       formObj.agmt_seq.value = "";
		       formObj.agmt_cty_cd.readOnly = true;
		       formObj.agmt_seq.readOnly = true;
		       
			   for(var i = 1; i <= sheetObj.RowCount; i++){
				   //sheetObj.CellEditable(i, "cntr_no")              = true;
				   sheetObj.CellEditable(i, "offh_sts_cd")          = false;
				   sheetObj.CellEditable(i, "offh_due_dt")          = false;
				   sheetObj.CellEditable(i, "cntr_tpsz_cd")         = false;
				   sheetObj.CellEditable(i, "lstm_cd")              = false;
				   sheetObj.CellEditable(i, "agmt_no")              = false;
				   sheetObj.CellEditable(i, "ref_no")               = false;
				   sheetObj.CellEditable(i, "vndr_seq")             = false;
				   sheetObj.CellEditable(i, "vndr_lgl_eng_nm")      = false;
				   sheetObj.CellEditable(i, "cntr_sts_cd")          = false;
				   sheetObj.CellEditable(i, "cntr_sts_evnt_dt")     = false;
				   sheetObj.CellEditable(i, "full_flg")             = false;
				   sheetObj.CellEditable(i, "cnmv_sts_cd")          = false;
				   sheetObj.CellEditable(i, "crnt_yd_cd")           = false;
				   sheetObj.CellEditable(i, "cnmv_dt")              = false;
				   sheetObj.CellEditable(i, "cntr_drff_amt")        = true;
				   sheetObj.CellEditable(i, "cntr_drff_cr_amt")     = true;
				   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
				   sheetObj.CellEditable(i, "rntl_chg_free_dys")    = false;
				   sheetObj.CellEditable(i, "cntr_old_van_flg")     = false;
				   sheetObj.CellEditable(i, "cntr_pkup_chg_amt")    = false;
				   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt") = false;
				   sheetObj.CellEditable(i, "cntr_rmk")             = true;
				   
				   sheetObj.CellValue(i,"cntr_old_van_flg") = ""; 
				   if (sheetObj.CellValue(i,"cntr_lft_chg_amt") != "") {
					   if (eval(sheetObj.CellValue(i,"cntr_lft_chg_amt")) != 0){
						   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
						   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
					   }
				   }
				   
				   sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
			   }
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   ComBtnEnable("btn_downexcel");
			   ComBtnEnable("btn_delete");
			break;
				
			case "3": //MUO
		       document.getElementById("hire_date").className = "input1";
		       document.getElementById("sts_evnt_yd_cd").className = "input1";
		       document.getElementById("agmt_cty_cd").className = "input1";
		       document.getElementById("agmt_seq").className = "input1";
		       formObj.agmt_cty_cd.readOnly = false;
		       formObj.agmt_seq.readOnly = false;
		       formObj.agmt_cty_cd.value = "HHO";
		       
			   for(var i = 1; i <= sheetObj.RowCount; i++){
				   sheetObj.CellEditable(i, "offh_sts_cd")          = false;
				   sheetObj.CellEditable(i, "offh_due_dt")          = false;
				   sheetObj.CellEditable(i, "cntr_tpsz_cd")         = false;
				   sheetObj.CellEditable(i, "lstm_cd")              = false;
				   sheetObj.CellEditable(i, "agmt_no")              = false;
				   sheetObj.CellEditable(i, "ref_no")               = false;
				   sheetObj.CellEditable(i, "vndr_seq")             = false;
				   sheetObj.CellEditable(i, "vndr_lgl_eng_nm")      = false;
				   sheetObj.CellEditable(i, "cntr_sts_cd")          = false;
				   sheetObj.CellEditable(i, "cntr_sts_evnt_dt")     = false;
				   sheetObj.CellEditable(i, "full_flg")             = false;
				   sheetObj.CellEditable(i, "cnmv_sts_cd")          = false;
				   sheetObj.CellEditable(i, "crnt_yd_cd")           = false;
				   sheetObj.CellEditable(i, "cnmv_dt")              = false;
				   sheetObj.CellEditable(i, "cntr_drff_amt")        = false;
				   sheetObj.CellEditable(i, "cntr_drff_cr_amt")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
				   sheetObj.CellEditable(i, "rntl_chg_free_dys")    = false;
				   sheetObj.CellEditable(i, "cntr_old_van_flg")     = false;
				   sheetObj.CellEditable(i, "cntr_pkup_chg_amt")    = true;
				   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt") = true;
				   sheetObj.CellEditable(i, "cntr_rmk")             = true;
				   
				   sheetObj.CellValue(i,"cntr_drff_amt") = "";
				   sheetObj.CellValue(i,"cntr_drff_cr_amt") = "";
				   sheetObj.CellValue(i,"cntr_old_van_flg") = "";  
				   
				   sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
			   }
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   ComBtnEnable("btn_downexcel");
			   ComBtnEnable("btn_delete");
			break;			
			
			case "4": //MUI
//		       document.getElementById("hire_date").className = "input1";
//		       document.getElementById("sts_evnt_yd_cd").className = "input1";
//		       document.getElementById("agmt_cty_cd").className = "input2";
//		       document.getElementById("agmt_seq").className = "input2";
//		       formObj.agmt_cty_cd.value = "";
//		       formObj.agmt_seq.value = "";
//		       formObj.agmt_cty_cd.readOnly = true;
//		       formObj.agmt_seq.readOnly = true;
		       document.getElementById("hire_date").className = "input1";
		       document.getElementById("sts_evnt_yd_cd").className = "input1";
		       document.getElementById("agmt_cty_cd").className = "input2";
		       document.getElementById("agmt_seq").className = "input2";
		       formObj.agmt_cty_cd.value = "";
		       formObj.agmt_seq.value = "";
		       formObj.agmt_cty_cd.readOnly = true;
		       formObj.agmt_seq.readOnly = true;
		       
			   for(var i = 1; i <= sheetObj.RowCount; i++){
//				   sheetObj.CellEditable(i, "cntr_no")              = false;
				   sheetObj.CellEditable(i, "offh_sts_cd")          = false;
				   sheetObj.CellEditable(i, "offh_due_dt")          = false;
				   sheetObj.CellEditable(i, "cntr_tpsz_cd")         = false;
				   sheetObj.CellEditable(i, "lstm_cd")              = false;
				   sheetObj.CellEditable(i, "agmt_no")              = false;
				   sheetObj.CellEditable(i, "ref_no")               = false;
				   sheetObj.CellEditable(i, "vndr_seq")             = false;
				   sheetObj.CellEditable(i, "vndr_lgl_eng_nm")      = false;
				   sheetObj.CellEditable(i, "cntr_sts_cd")          = false;
				   sheetObj.CellEditable(i, "cntr_sts_evnt_dt")     = false;
				   sheetObj.CellEditable(i, "full_flg")             = false;
				   sheetObj.CellEditable(i, "cnmv_sts_cd")          = false;
				   sheetObj.CellEditable(i, "crnt_yd_cd")           = false;
				   sheetObj.CellEditable(i, "cnmv_dt")              = false;
				   sheetObj.CellEditable(i, "cntr_drff_amt")        = true;
				   sheetObj.CellEditable(i, "cntr_drff_cr_amt")     = true;
				   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
				   sheetObj.CellEditable(i, "rntl_chg_free_dys")    = false;
				   sheetObj.CellEditable(i, "cntr_old_van_flg")     = false;
				   sheetObj.CellEditable(i, "cntr_pkup_chg_amt")    = false;
				   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt") = false;
				   sheetObj.CellEditable(i, "cntr_rmk")             = true;
				   
				   sheetObj.CellValue(i, "rntl_chg_free_dys") = "";				   
				   sheetObj.CellValue(i,"cntr_old_van_flg") = "";
				   sheetObj.CellValue(i, "cntr_pkup_chg_amt") = "";
				   sheetObj.CellValue(i, "cntr_pkup_cr_chg_amt") = "";
				   
				   sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
			   }		       
//			   ComBtnDisable("btn_add"); 
//			   ComBtnDisable("btn_loadexcel");
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   ComBtnEnable("btn_downexcel");
			   ComBtnEnable("btn_delete");
			break;
			
			case "5": //SRO
		       document.getElementById("hire_date").className = "input1";
		       document.getElementById("sts_evnt_yd_cd").className = "input1";
		       document.getElementById("agmt_cty_cd").className = "input1";
		       document.getElementById("agmt_seq").className = "input1";
		       formObj.agmt_cty_cd.readOnly = false;
		       formObj.agmt_seq.readOnly = false;
		       formObj.agmt_cty_cd.value = "HHO";
		       
			   for(var i = 1; i <= sheetObj.RowCount; i++){
				   sheetObj.CellEditable(i, "offh_sts_cd")          = false;
				   sheetObj.CellEditable(i, "offh_due_dt")          = false;
				   sheetObj.CellEditable(i, "cntr_tpsz_cd")         = false;
				   sheetObj.CellEditable(i, "lstm_cd")              = false;
				   sheetObj.CellEditable(i, "agmt_no")              = false;
				   sheetObj.CellEditable(i, "ref_no")               = false;
				   sheetObj.CellEditable(i, "vndr_seq")             = false;
				   sheetObj.CellEditable(i, "vndr_lgl_eng_nm")      = false;
				   sheetObj.CellEditable(i, "cntr_sts_cd")          = false;
				   sheetObj.CellEditable(i, "cntr_sts_evnt_dt")     = false;
				   sheetObj.CellEditable(i, "full_flg")             = false;
				   sheetObj.CellEditable(i, "cnmv_sts_cd")          = false;
				   sheetObj.CellEditable(i, "crnt_yd_cd")           = false;
				   sheetObj.CellEditable(i, "cnmv_dt")              = false;
				   sheetObj.CellEditable(i, "cntr_drff_amt")        = false;
				   sheetObj.CellEditable(i, "cntr_drff_cr_amt")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
				   sheetObj.CellEditable(i, "rntl_chg_free_dys")    = false;
				   sheetObj.CellEditable(i, "cntr_old_van_flg")     = false;
				   sheetObj.CellEditable(i, "cntr_pkup_chg_amt")    = false;
				   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt") = false;
				   sheetObj.CellEditable(i, "cntr_rmk")             = true;
				   
				   sheetObj.CellValue(i,"cntr_drff_amt") = "";
				   sheetObj.CellValue(i,"cntr_drff_cr_amt") = "";
				   sheetObj.CellValue(i,"cntr_old_van_flg") = "";  
				   
				   sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_lft_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "rntl_chg_free_dys") = 0;
			   }
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   ComBtnEnable("btn_downexcel");
			   ComBtnEnable("btn_delete");
			break;	
			
			case "6": //SRI
//		       document.getElementById("hire_date").className = "input1";
//		       document.getElementById("sts_evnt_yd_cd").className = "input1";
//		       document.getElementById("agmt_cty_cd").className = "input2";
//		       document.getElementById("agmt_seq").className = "input2";
//		       formObj.agmt_cty_cd.value = "";
//		       formObj.agmt_seq.value = "";
//		       formObj.agmt_cty_cd.readOnly = true;
//		       formObj.agmt_seq.readOnly = true;
		       document.getElementById("hire_date").className = "input1";
		       document.getElementById("sts_evnt_yd_cd").className = "input1";
		       document.getElementById("agmt_cty_cd").className = "input2";
		       document.getElementById("agmt_seq").className = "input2";
		       formObj.agmt_cty_cd.value = "";
		       formObj.agmt_seq.value = "";
		       formObj.agmt_cty_cd.readOnly = true;
		       formObj.agmt_seq.readOnly = true;
		       
			   for(var i = 1; i <= sheetObj.RowCount; i++){
//				   sheetObj.CellEditable(i, "cntr_no")              = false;
				   sheetObj.CellEditable(i, "offh_sts_cd")          = false;
				   sheetObj.CellEditable(i, "offh_due_dt")          = false;
				   sheetObj.CellEditable(i, "cntr_tpsz_cd")         = false;
				   sheetObj.CellEditable(i, "lstm_cd")              = false;
				   sheetObj.CellEditable(i, "agmt_no")              = false;
				   sheetObj.CellEditable(i, "ref_no")               = false;
				   sheetObj.CellEditable(i, "vndr_seq")             = false;
				   sheetObj.CellEditable(i, "vndr_lgl_eng_nm")      = false;
				   sheetObj.CellEditable(i, "cntr_sts_cd")          = false;
				   sheetObj.CellEditable(i, "cntr_sts_evnt_dt")     = false;
				   sheetObj.CellEditable(i, "full_flg")             = false;
				   sheetObj.CellEditable(i, "cnmv_sts_cd")          = false;
				   sheetObj.CellEditable(i, "crnt_yd_cd")           = false;
				   sheetObj.CellEditable(i, "cnmv_dt")              = false;
				   sheetObj.CellEditable(i, "cntr_drff_amt")        = false;
				   sheetObj.CellEditable(i, "cntr_drff_cr_amt")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
				   sheetObj.CellEditable(i, "rntl_chg_free_dys")    = false;
				   sheetObj.CellEditable(i, "cntr_old_van_flg")     = false;
				   sheetObj.CellEditable(i, "cntr_pkup_chg_amt")    = false;
				   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt") = false;
				   sheetObj.CellEditable(i, "cntr_rmk")             = true;
				   
				   sheetObj.CellValue(i, "rntl_chg_free_dys") = "";				   
				   sheetObj.CellValue(i,"cntr_old_van_flg") = "";
				   sheetObj.CellValue(i, "cntr_pkup_chg_amt") = "";
				   sheetObj.CellValue(i, "cntr_pkup_cr_chg_amt") = "";
				   
				   sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
			   }		       
//			   ComBtnDisable("btn_add"); 
//			   ComBtnDisable("btn_loadexcel");
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   ComBtnEnable("btn_downexcel");
			   ComBtnEnable("btn_delete");
			break;
			case "7": //XX(SOC)
//		       document.getElementById("hire_date").className = "input1";
//		       document.getElementById("sts_evnt_yd_cd").className = "input1";
//		       document.getElementById("agmt_cty_cd").className = "input2";
//		       document.getElementById("agmt_seq").className = "input2";
//		       formObj.agmt_cty_cd.value = "";
//		       formObj.agmt_seq.value = "";
//		       formObj.agmt_cty_cd.readOnly = true;
//		       formObj.agmt_seq.readOnly = true;
		       document.getElementById("hire_date").className = "input1";
		       document.getElementById("sts_evnt_yd_cd").className = "input1";
		       document.getElementById("agmt_cty_cd").className = "input2";
		       document.getElementById("agmt_seq").className = "input2";
		       formObj.agmt_cty_cd.value = "";
		       formObj.agmt_seq.value = "";
		       formObj.agmt_cty_cd.readOnly = true;
		       formObj.agmt_seq.readOnly = true;
		       
			   for(var i = 1; i <= sheetObj.RowCount; i++){
//				   sheetObj.CellEditable(i, "cntr_no")              = false;
				   sheetObj.CellEditable(i, "offh_sts_cd")          = false;
				   sheetObj.CellEditable(i, "offh_due_dt")          = false;
				   sheetObj.CellEditable(i, "cntr_tpsz_cd")         = false;
				   sheetObj.CellEditable(i, "lstm_cd")              = false;
				   sheetObj.CellEditable(i, "agmt_no")              = false;
				   sheetObj.CellEditable(i, "ref_no")               = false;
				   sheetObj.CellEditable(i, "vndr_seq")             = false;
				   sheetObj.CellEditable(i, "vndr_lgl_eng_nm")      = false;
				   sheetObj.CellEditable(i, "cntr_sts_cd")          = false;
				   sheetObj.CellEditable(i, "cntr_sts_evnt_dt")     = false;
				   sheetObj.CellEditable(i, "full_flg")             = false;
				   sheetObj.CellEditable(i, "cnmv_sts_cd")          = false;
				   sheetObj.CellEditable(i, "crnt_yd_cd")           = false;
				   sheetObj.CellEditable(i, "cnmv_dt")              = false;
				   sheetObj.CellEditable(i, "cntr_drff_amt")        = false;
				   sheetObj.CellEditable(i, "cntr_drff_cr_amt")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_cur")     = false;
				   sheetObj.CellEditable(i, "cntr_lft_chg_amt")     = false;
				   sheetObj.CellEditable(i, "rntl_chg_free_dys")    = false;
				   sheetObj.CellEditable(i, "cntr_old_van_flg")     = false;
				   sheetObj.CellEditable(i, "cntr_pkup_chg_amt")    = false;
				   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt") = false;
				   sheetObj.CellEditable(i, "cntr_rmk")             = true;
				   
				   sheetObj.CellValue(i, "rntl_chg_free_dys") = "";				   
				   sheetObj.CellValue(i,"cntr_old_van_flg") = "";
				   sheetObj.CellValue(i, "cntr_pkup_chg_amt") = "";
				   sheetObj.CellValue(i, "cntr_pkup_cr_chg_amt") = "";
				   
				   sheetObj.MinimumValue(i, "cntr_drff_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_drff_cr_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt") = 0;
				   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt") = 0;
			   }		       
//			   ComBtnDisable("btn_add"); 
//			   ComBtnDisable("btn_loadexcel");
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   ComBtnEnable("btn_downexcel");
			   ComBtnEnable("btn_delete");
			break;

	     } //end switch
  	}
  	
	function ComRowHide(sheetObj, col, isMsg) {
   	    if (isMsg==undefined || isMsg==null) isMsg = true;
		var org_col = col;
		//컬럼Index가 아닌 경우 SaveName인 경우 -> 컬럼Index를 가져온다.
		col = ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);
		
		//컬럼 인자의 유효성 확인하기
		if (col< 0 || col > sheetObj.LastCol) {
			ComShowMessage("[ComRowHideDelete] '" + sheetObj.id + "'의 '" + org_col + "' 컬럼은 존재하지 않습니다.");
			return -1;
		}
		
		//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
		var sRow = sheetObj.FindCheckedRow(col);
		if (sRow == "") {
			if(isMsg) ComShowCodeMessage("COM12189");
			return 0;
		}
		
		//가져온 행을 배열로 만들기 
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		
		sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비

		//기준컬럼의 DataType이 dtDelCheck이면 그냥 숨기기만하고, dtDelCheck가 아닌 경우만 숨기고, 트랜잭션 바꾼다.
		if (sheetObj.ReadDataProperty(0, col, dpDataType) == dtDelCheck) {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
			}
		} else {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				sheetObj.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
			}
		}
		sheetObj.RedrawSum = true;	//합계 계산하기
		return arrRow.length-1;
	}
	
    function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
    	var formObj = document.form;
    	var sName = SheetObj.ColSaveName(Col);
    	
     	 var celltxt  = SheetObj.EditValue;
       	 var celltxt1 = SheetObj.CellValue(Row, "cntr_no");
       	 if (celltxt == "" && celltxt1 != ""){
       		 celltxt = celltxt1;
       	 } 
       	 
        if (sName == "cntr_drff_amt"){
           if (SheetObj.CellEditable(Row,"cntr_drff_amt") == false) 
        		return;         	
       	   if(SheetObj.CellEditable(Row,"cntr_drff_cr_amt") == true ||
       		  SheetObj.CellEditable(Row,"cntr_drff_amt") == true){
        	  if (KeyCode != 9)
         	     SheetObj.CellValue(Row,"cntr_drff_cr_amt") = 0;
       	   }
        }
        else if (sName == "cntr_drff_cr_amt"){
           if (SheetObj.CellEditable(Row,"cntr_drff_cr_amt") == false) 
        		return;          	
       	   if(SheetObj.CellEditable(Row,"cntr_drff_cr_amt") == true ||
              SheetObj.CellEditable(Row,"cntr_drff_amt") == true){
       		  if (KeyCode != 9)
       	         SheetObj.CellValue(Row,"cntr_drff_amt") = 0;
       	   }
        }
        else if (sName == "cntr_pkup_chg_amt"){
        	if (SheetObj.CellEditable(Row,"cntr_pkup_chg_amt") == false) 
        		return;        	
        	if(SheetObj.CellEditable(Row,"cntr_pkup_cr_chg_amt") == true ||
        	   SheetObj.CellEditable(Row,"cntr_pkup_chg_amt") == true){
        	   if (KeyCode != 9)
        	      SheetObj.CellValue(Row,"cntr_pkup_cr_chg_amt") = 0;
        	}        	
        }
        else if (sName == "cntr_pkup_cr_chg_amt"){
        	if (SheetObj.CellEditable(Row,"cntr_pkup_cr_chg_amt") == false) 
        		return;
        	if(SheetObj.CellEditable(Row,"cntr_pkup_cr_chg_amt") == true ||
               SheetObj.CellEditable(Row,"cntr_pkup_chg_amt") == true){
               if (KeyCode != 9)
                  SheetObj.CellValue(Row,"cntr_pkup_chg_amt") = 0;
            }        	
        }
        else if (sName == "cntr_no" && (celltxt.length == 11 || KeyCode == 13)){
           
        	SheetObj.CellValue2(Row,"cntr_no") = celltxt;
			if (formObj.st_cd.value == "") {
				ComShowCodeMessage("MST00001", "Status Code");
				ComSetFocus(formObj.st_cd);
				return;
			} 
			if (formObj.hire_date.value == "") {
				ComShowCodeMessage("MST00001", "Date");
				ComSetFocus(formObj.hire_date);
				return;
			}
			if (formObj.sts_evnt_yd_cd.value == "") {
				ComShowCodeMessage("MST00001", "Yard");
				ComSetFocus(formObj.sts_evnt_yd_cd);
				return;
			}
			
			if (formObj.st_cd.value == "1" || formObj.st_cd.value == "3" || formObj.st_cd.value == "5") {
				if (formObj.agmt_cty_cd.value == "" || formObj.agmt_seq.value == ""){
					ComShowCodeMessage("MST00001", "AGMT No.");
					ComSetFocus(formObj.agmt_seq);
					return;
				}
			}
			if ((formObj.st_cd.value == "0" && formObj.agmt_seq.value.trim().length > 0)  || formObj.st_cd.value == "1" || formObj.st_cd.value == "3" || formObj.st_cd.value == "5") {
			   doActionIBSheet(SheetObj,formObj,IBSEARCH01);
			}        	
        	doActionIBSheet(SheetObj,formObj,IBSEARCH);
        } 
    }
    
    function setSearchField(gubun){
    	var formObj = document.form;
    	if (gubun == '0'){
	    	formObj.st_cd.disabled = true;
	    	formObj.hire_date.readOnly = true;
	    	formObj.sts_evnt_yd_cd.readOnly = true;
	        formObj.agmt_cty_cd.readOnly = true;
	        formObj.agmt_seq.readOnly = true;
    	} else {
	    	formObj.st_cd.disabled = false;
	    	formObj.hire_date.readOnly = false;
	    	formObj.sts_evnt_yd_cd.readOnly = false;
	        formObj.agmt_cty_cd.readOnly = false;
	        formObj.agmt_seq.readOnly = false;    		
    	}
    }
    
    function setsheetRowColorBlack(cnt){
   	 	 var formObj = document.form;
	   	 for (var i = 1; i <= 25; i++){
	   	    sheetObjects[0].CellFontColor(cnt,i) = sheetObjects[0].RgbColor(0, 0, 0);
	   	 }
    }
    
    function setsheetRowColorRed(cnt){
	   	 var formObj = document.form;
	   	 for (var i = 1; i <= 25; i++){
	   	    sheetObjects[0].CellFontColor(cnt,i) = sheetObjects[0].RgbColor(255, 0, 0);
	   	 }
    }     
  	
	/* 개발자 작업  끝 */