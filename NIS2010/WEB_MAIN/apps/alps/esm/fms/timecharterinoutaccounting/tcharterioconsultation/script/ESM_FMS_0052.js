/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0052.js
*@FileTitle : Slip Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.17 윤세영
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* 
* 2014.07.25 민정호 CHM-20430993 [Develop-FMS-JOO]비용 전표 상신용 Approval 구축
* 10만불 이상 금액에 대해서 CEO 결재 승인 기능 추가
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
     * @class ESM_FMS_0052 : ESM_FMS_0052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0052() {
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
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_retrieve":
                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

				case "btn_new":
					formReset();
                    break;
	
				case "btn_save":
					if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').substring(0,2) == '07' &&
							sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'rqst_apro_step_flg') == 'Y' &&
							form.apro_flg[0].checked == true
							){												
							doActionIBSheet(sheetObjects[0], formObject , IBSEARCH_ASYNC03);
					}else if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').substring(0,2) == '07' &&
										sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'rqst_apro_step_flg') != 'Y' &&
										form.apro_flg[0].checked == true
										){
									return;
					}else if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').substring(0,2) == '20' &&
									form.apro_flg[0].checked == true
									){
									//2014.12 민정호 AR 승인시 GW호출
						 	doActionIBSheet(sheetObjects[0], formObject , IBSEARCH_ASYNC04);						 
					}else{
						doActionIBSheet(sheetObject,formObject,IBSAVE);	
					}										 					 
                    break;

				case "btn_slip":

					if(sheetObject.SelectRow > 0){
						var csr_no = formObject.slp_no.value;
						var vsl_cd = formObject.vsl_code.value;
						var vsl_eng_nm = formObject.vsl_eng_name.value;
						var csr_curr_cd = sheetObject.CellValue(sheetObject.SelectRow, "csr_curr_cd");
						
						ComOpenPopup("ESM_FMS_0042.do?csr_no="+ csr_no+"&vsl_cd="+vsl_cd+"&vsl_eng_nm="+vsl_eng_nm+"&csr_curr_cd="+csr_curr_cd, 1024, 476, "setSlipInquiry", "1,0,1,1,1,1", false, false, null, null, 0, "ESM_FMS_0042");
					} else {
						ComShowCodeMessage('FMS00019');
					}
                    break;
                    
				case "from_ef_dt": 
					var cal = new ComCalendar();
					cal.select(form.from_eff_dt, 'yyyy-MM-dd');
					break;
				 
	 			case "to_ef_dt": 
					var cal = new ComCalendar();
					cal.select(form.to_eff_dt, 'yyyy-MM-dd');
					break;
					
	 			case "from_cr_dt": 
					var cal = new ComCalendar();
					cal.select(form.from_cre_dt, 'yyyy-MM-dd');
					break;
				 
	 			case "to_cr_dt": 
					var cal = new ComCalendar();
					cal.select(form.to_cre_dt, 'yyyy-MM-dd');
					break;
                    
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0022");
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

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();
        
        sheetObjects[0].ExtendLastCol = false;
        
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);   
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 157;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(32, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Seq|CSR No.|CSR Date|Produced By|Currency|CSR Amount|CSR Description|Approval|Request Team|Rqst Date|Ownr Code|Ownr Name|Evid Type|Deduction|Rqst Amt|Diff Desc|Cxl Flg|Cxl Desc|Vsl Code|Vsl Eng Name|Lst Apro Flg|Apro Rqst No|Apro Rqst Seq|Urg Pay Flg|Urg Pay YN|RQST_APRO_STEP_FLG";
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 00,    daCenter,  false,    "Status");
                    InitDataProperty(0, cnt++ , dtSeq,    		40,    daCenter,  false,    "Seq");
					InitDataProperty(0, cnt++ , dtData,   		145,   daCenter,  false,    "csr_no",   	false,     "", 		dfNone,   		0,     	false,		false);
                                                                                                                             
					InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,  false,    "csr_dt",     	false,     "", 		dfDateYmd, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		100,   daCenter,  false,    "produced_by",  false,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		60,    daCenter,  false,    "csr_curr_cd",  false,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		120,   daRight,   false,    "csr_amt",   	false,     "", 		dfNullFloat,	2, 		false,		false);
					InitDataProperty(0, cnt++ , dtData,   		350,   daLeft,    false,    "csr_desc",   	false,     "",    	dfNone, 		0,     	false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,   	70,    daCenter,  false,    "apro_flg",     false,     "", 		dfNone,   		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	100,   daCenter,  false,    "request_team", false,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	100,   daCenter,  false,    "rqst_dt",  	false,     "", 		dfDateYmd, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	60,    daCenter,  false,    "ownr_cd",  	false,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daLeft,    false,    "ownr_nm",   	false,     "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "evid_tp",   	false,     "",    	dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	100,   daCenter,  false,    "deduction",    false,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	100,   daRight,   false,    "rqst_amt",  	false,     "", 		dfNullFloat, 	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	60,    daRight,   false,    "diff_desc",  	false,     "", 		dfNullFloat, 	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "cxl_flg",   	false,     "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daLeft,    false,    "cxl_desc",   	false,     "",    	dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "vsl_cd",   	false,     "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "vsl_eng_nm",   false,     "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "flet_ctrt_tp_cd",false,   "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "slip_type",    false,   "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "inter_co_cd",    false,   "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "ar_inter_co_cd",    false,   "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "lst_apro_flg",    false,   "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "apro_rqst_no",    	false,   "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "apro_rqst_seq",    	false,   "", 		dfNone,			0, 		false,		false);	
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "urg_pay_flg",    	false,   "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "apro_dt",    	false,   "", 		dfNone,			0, 		false,		false);					
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "urg_pay_yn",    	false,   "", 		dfNone,			0, 		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	120,   daCenter,  false,    "rqst_apro_step_flg",    	false,   "", 		dfNone,			0, 		false,		false);					
					
					DataLinkMouse("Status") = true;
	                DataLinkMouse("Seq") = true;
	                DataLinkMouse("apro_flg") = true;
	                DataLinkMouse("csr_no") = true;
	                DataLinkMouse("csr_dt") = true;
	                DataLinkMouse("produced_by") = true;
	                DataLinkMouse("csr_curr_cd") = true;
	                DataLinkMouse("csr_amt") = true;
	                DataLinkMouse("csr_desc") = true;
               }
                break;
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,gubun) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

           case IBSEARCH:      //조회

           	   if(   formObj.csr_no.value != ""
	       		  && formObj.csr_no.value.length < 3) {
	        	   formObj.csr_no.value = "";
				   ComAlertFocus(formObj.csr_no, ComGetMsg('FMS01331'));
				   return;
	       	   }
           
	           if(!(   formObj.csr_no.value != ""
		   		    && formObj.from_eff_dt.value == ""
		   		    && formObj.to_eff_dt.value == ""
		   		    && formObj.from_cre_dt.value == ""
		   		    && formObj.to_cre_dt.value == "")) {
	        	   if(!validateForm(sheetObj,formObj,sAction))  return true;
		   		}
	
	  			formObj.f_cmd.value = SEARCH;
	  			
	  			sheetObj.DoSearch("ESM_FMS_0052GS.do" , FormQueryString(formObj));

                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction)) return;
	 			formObj.f_cmd.value = MULTI;

				var sXml = sheetObj.GetSaveXml("ESM_FMS_0052GS.do", FormQueryString(formObj));
		
		        var saveFlag = ComFmsGetXMLData(sXml, "TR-ALL");
				sheetObjects[0].LoadSaveXml(sXml);
				if (saveFlag == "OK") {
		  			formObj.f_cmd.value = SEARCH;
		  			
		  			sheetObj.DoSearch("ESM_FMS_0052GS.do" , FormQueryString(formObj));
				}	
		
			break;

			case IBROWSEARCH:      //조회
	 			if(gubun == "Vessel") {
			    	if(formObj.vsl_cd.value == "") {
			    		formObj.vsl_eng_nm.value = "";
			    		return;
			    	}
			    	
			    	formObj.f_cmd.value = SEARCH01;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
		   				
		   				document.body.focus();
		   				
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
						return;
					}
		   			
				}
	 			break;
	 			
       		case IBSEARCH_ASYNC03:	//결재 요청

        	   	if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
        	   	
        	   	document.form2.f_cmd.value = MULTI10;
        	   	document.form2.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');
        	   	var param = "?inv_sub_sys_cd=FMS";
        	   	        	         	   	
 				var sXml = sheetObj.GetSearchXml("COM_CSR_00081GS.do"+param, FormQueryString(document.form2),"",true);   				
   				var gwUrl = ComGetEtcData(sXml , "GW_URL");
   				
   				if (ComIsNull(gwUrl)) {
   					ComShowCodeMessage("TES21017");
   					return;
   				}
   				
   				ComOpenPopup(gwUrl, 900, 780, "", "1,0,1,1,1", true);
   				// 재조회   				
   				doActionIBSheet(sheetObj,formObj,IBSEARCH);
   				break;		
   				
       		case IBSEARCH_ASYNC04:	//2014.12 민정호 AR 결재 요청

        	   	if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
        	   	
        	   	document.form2.f_cmd.value = MULTI10;
        	   	document.form2.csr_no.value = sheetObj.CellValue(sheetObj.SelectRow,'csr_no');
        	   	var param = "?inv_sub_sys_cd=FMS";
        	   	
 				var sXml = sheetObj.GetSearchXml("ESM_FMS_0088GS.do"+param, FormQueryString(document.form2),"",true);   				
   				var gwUrl = ComGetEtcData(sXml , "GW_URL");
   				
   				if (ComIsNull(gwUrl)) {
   					ComShowCodeMessage("TES21017");
   					return;
   				}
   				
   				ComOpenPopup(gwUrl, 900, 780, "", "1,0,1,1,1", true);
   				// 재조회
   				doActionIBSheet(sheetObj,formObj,IBSEARCH);
   				break;		   				
        }
    }
     
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
     	
    	//Axon 이벤트 처리1. 이벤트catch
        axon_event.addListener  ('change'  , 'vsl_cd_change'   , 'vsl_cd');		  	//Vessel Code 입력 후 Name정보 가져오기
        axon_event.addListener  ('click'   , 'condition_click' , 'condition');		//Condition 클릭시 날짜 필드 제어
      //2010.11.24 이상민 [CHM-201007233-01] : vsl_cd 는 eng_keypress-> eng_num_keypress로 변경
        axon_event.addListener  ('keypress', 'eng_num_keypress', 'vsl_cd', 'csr_no');
        axon_event.addListener  ('click'   , 'approval_click'  , 'apro_flg');		//Approval 클릭시 Cancel 관련 필드 제어
        axon_event.addListener  ('click'   , 'urg_pay_click'  , 'urg_pay_flg');		//urg_pay_flg 클릭시 Cancel 관련 필드 제어        
                
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
        setCsrDate();
    }
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_num_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('uppernum');
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
		ComChkObjValid(event.srcElement);

    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
    	//마스크구분자 없애기
    	ComClearSeparator(event.srcElement);
    }
     
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH,'Vessel');
    }
     
    /**
     * Condition 클릭시 날짜 필드를 제어한다. <br>
     **/
    function condition_click() {
    	if(form.condition[0].checked) {
    		setEffectiveDate(form.condition[0].value);
    	} else {
    		setCsrDate(form.condition[1].value);
    	}
    }
     
    /**
     * Approval 클릭시 Cancel 관련 필드를 제어한다. <br>
     **/
    function approval_click() {
    	if(form.apro_flg[0].checked) {
    		form.cxl_flg[0].checked = false;
    		form.cxl_flg[1].checked = true;
	    	form.cxl_desc.value = '';
	    	form.cxl_desc.readOnly = true;
	    	form.cxl_desc.className = "input2";	    	    		
    	} else {
    		form.cxl_flg[0].checked = true;
    		form.cxl_flg[1].checked = false;
	    	form.cxl_desc.value = '';
	    	form.cxl_desc.readOnly = false;
	    	form.cxl_desc.className = "input1";
    	}
    }
     
    /**
     * Approval 클릭시 Cancel 관련 필드를 제어한다. <br>
     **/
    function urg_pay_click() {
    	if(form.urg_pay_flg[0].checked) {
    		form.apro_flg[0].checked = true;
    	} else {
    		form.apro_flg[1].checked = true;
    	}
    	approval_click();
    }    
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- end
     
    /**
	  * Vessel Code 입력부분.<br>
	  * @param {arry} aryPopupData
	  */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
		
		form.vsl_cd.readOnly = true;
		form.btn_vslpop.style.cursor = "default";
		document.images["btn_vslpop"].name = "no_btn_vslpop";
	}
    
	/**
     * Effective Date 초기화 <br>
     **/
    function setEffectiveDate(val) {
    	if(val == 'E') {
	    	form.from_eff_dt.readOnly = false;
	    	form.to_eff_dt.readOnly = false;
	    	form.from_eff_dt.className = "input1";
	    	form.to_eff_dt.className = "input1";
			form.from_ef_dt.style.cursor = "hand";
			form.to_ef_dt.style.cursor = "hand";
			document.images["from_ef_dt"].name = "from_ef_dt";
			document.images["to_ef_dt"].name = "to_ef_dt";
			
			setCsrDate(val);
			
    	} else {
    		form.from_eff_dt.readOnly = true;
	    	form.to_eff_dt.readOnly = true;
	    	form.from_eff_dt.className = "input2";
	    	form.to_eff_dt.className = "input2";
			form.from_ef_dt.style.cursor = "default";
			form.to_ef_dt.style.cursor = "default";
			document.images["from_ef_dt"].name = "no_from_ef_dt";
			document.images["to_ef_dt"].name = "no_to_ef_dt";
    	}
		
		form.from_eff_dt.value = "";
		form.to_eff_dt.value = "";
    }
    
	/**
     * CSR Date 초기화 <br>
     **/
    function setCsrDate(val) {
        if(val == 'C') {
	    	form.from_cre_dt.readOnly = false;
	    	form.to_cre_dt.readOnly = false;
	    	form.from_cre_dt.className = "input1";
	    	form.to_cre_dt.className = "input1";
			form.from_cr_dt.style.cursor = "hand";
			form.to_cr_dt.style.cursor = "hand";
			document.images["from_cr_dt"].name = "from_cr_dt";
			document.images["to_cr_dt"].name = "to_cr_dt";
			
			setEffectiveDate(val)
			
        } else {
        	form.from_cre_dt.readOnly = true;
        	form.to_cre_dt.readOnly = true;
        	form.from_cre_dt.className = "input2";
        	form.to_cre_dt.className = "input2";
    		form.from_cr_dt.style.cursor = "default";
    		form.to_cr_dt.style.cursor = "default";
    		document.images["from_cr_dt"].name = "no_from_cr_dt";
    		document.images["to_cr_dt"].name = "no_to_cr_dt";
        }
		
		form.from_cre_dt.value = "";
		form.to_cre_dt.value = "";
    }
     
    /**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
 	function formReset() {
 	    ComResetAll();
 	    
 	    setEffectiveDate('E');
 	    
 	    setCsrDate();
 		
 		form.vsl_cd.readOnly = false;
 		form.btn_vslpop.style.cursor = "hand";
 		document.images["btn_vslpop"].name = "btn_vslpop";
 		
 		form.vsl_cd.value = "";
 	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction){

    	if(formObj.condition[0].checked) {
    		if(formObj.from_eff_dt.value == "") {
    			ComAlertFocus(formObj.from_eff_dt, ComGetMsg('FMS01430'));
    			return;
    		} else if(formObj.to_eff_dt.value == "") {
    			ComAlertFocus(formObj.to_eff_dt, ComGetMsg('FMS01431'));
    			return;
    		} else {
    			if(parseInt(formObj.from_eff_dt.value.trimAll('-')) > parseInt(formObj.to_eff_dt.value.trimAll('-'))) {
    				ComAlertFocus(formObj.to_eff_dt, ComGetMsg('FMS01432'));
        			return;
    			}
    		}
    	} else {
    		if(formObj.from_cre_dt.value == "") {
    			ComAlertFocus(formObj.from_cre_dt, ComGetMsg('FMS01433'));
    			return;
    		} else if(formObj.to_cre_dt.value == "") {
    			ComAlertFocus(formObj.to_cre_dt, ComGetMsg('FMS01434'));
    			return;
    		} else {
    			if(parseInt(formObj.from_cre_dt.value.trimAll('-')) > parseInt(formObj.to_cre_dt.value.trimAll('-'))) {
    				ComAlertFocus(formObj.to_cre_dt, ComGetMsg('FMS01435'));
        			return;
    			}
    		}
    		
    	}

    	if(formObj.csr_no.value != "") {
    		if(formObj.csr_no.value.length < 3) {
    			ComAlertFocus(formObj.csr_no, ComGetMsg('FMS01437'));
    			return;
    		}
    	}

        if (sAction == IBSAVE) {

			if (formObj.cxl_flg[0].checked && formObj.cxl_desc.value.trim() == "") {
				ComAlertFocus(formObj.cxl_desc, ComGetMsg("FMS00004","Cancel Remark"));
        		return false;
        	}
        	
        	if (formObj.apro_flg[0].checked) {
        		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "apro_flg") = "Y";
        	} else {
        		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "apro_flg") = "N";
        		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cxl_flg") = "Y";
        		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cxl_desc") = formObj.cxl_desc.value;
        	}
        	
        	if (formObj.urg_pay_flg[0].checked) {
        		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "urg_pay_flg") = "Y";
        	} 
        	                	
    		formObj.flet_ctrt_tp_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "flet_ctrt_tp_cd");
    		formObj.save_csr_no.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "csr_no");
    		formObj.inter_co_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "inter_co_cd");
    		formObj.ar_inter_co_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ar_inter_co_cd");
			
        }

        return true;
    }
    
    /**
     * IBSheet의 각 Grid의 클릭 정보를 CSR Head Information에 보여준다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @return {없음}
     **/
    function setCsrHeadInfomation(sheetObj, row) {
    	form.request_team.value = sheetObj.CellValue(row,"request_team");
    	form.csr_dt.value = sheetObj.CellText(row,"csr_dt");
    	form.rqst_dt.value = sheetObj.CellText(row,"rqst_dt");
    	form.produced_by.value = sheetObj.CellValue(row,"produced_by");
    	form.csr_desc.value = sheetObj.CellValue(row,"csr_desc");
    	form.ownr_cd.value = sheetObj.CellValue(row,"ownr_cd");
    	form.ownr_nm.value = sheetObj.CellValue(row,"ownr_nm");
    	form.csr_curr_cd.value = sheetObj.CellValue(row,"csr_curr_cd");
    	form.csr_amt.value = sheetObj.CellText(row,"csr_amt");
    	form.evid_tp.value = sheetObj.CellText(row,"evid_tp");
    	
    	if(sheetObj.CellValue(row,"deduction") == "Y") {
    		form.deduction[0].checked = true;
    		form.deduction[1].checked = false;
    	} else {
    		form.deduction[0].checked = false;
    		form.deduction[1].checked = true;
    	}
    	
    	form.rqst_amt.value = sheetObj.CellText(row,"rqst_amt");
    	form.diff_desc.value = sheetObj.CellText(row,"diff_desc");

    	if(sheetObj.CellValue(row,"apro_flg") == "Y") {
    		form.apro_flg[0].checked = true;
    		form.apro_flg[1].checked = false;
    	} else {
    		form.apro_flg[0].checked = false;
    		form.apro_flg[1].checked = true;
    	}

		//Approval에 따라 Cancel 관련 필드 제어
		approval_click();
		
		form.apro_flg[0].disabled = false;
		form.apro_flg[1].disabled = false;
		
		form.urg_pay_flg[0].checked = false;		// 기본값
		form.urg_pay_flg[1].checked = true;		// 기본값

    	form.cxl_desc.value = sheetObj.CellValue(row,"cxl_desc");
    	form.slp_no.value = sheetObj.CellValue(row,"csr_no");
    	form.vsl_code.value = sheetObj.CellValue(row,"vsl_cd");
    	form.vsl_eng_name.value = sheetObj.CellValue(row,"vsl_eng_nm");
    	form.slip_type.value = sheetObj.CellValue(row,"slip_type");
    	    	
    	form.lst_apro_flg.value = sheetObj.CellValue(row,"lst_apro_flg");
    	form.apro_rqst_no.value = sheetObj.CellValue(row,"apro_rqst_no");
    	form.apro_rqst_seq.value = sheetObj.CellValue(row,"apro_rqst_seq");
    	form.apro_dt.value = sheetObj.CellValue(row,"apro_dt");    	    	
    }
    
	/**
	 * CSR No에 해당하는 CSR Head Information를 보여준다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {int}     cellX     	X좌표값
     * @param {int} 	cellY     	Y좌표값
     * @param {int}     cellW     	Cell 넓이
     * @param {int}     cellW     	Cell 높이
     **/
	function sheet1_OnClick(sheetObj, row, col, cellX, cellY, cellW, cellH) {
		 setCsrHeadInfomation(sheetObj, row);
//		 setUrgPayFlg(sheetObj);	
		 
 		setSaveBtn();
	}
     
	/**
	 * ERP에서 결재선 진행 중이면 SAVE버튼 비활성화 <br>
     **/
	function setSaveBtn(){
		
		var gubunApAr = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no').substring(0,2);
		var rqst_apro_step_flg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'rqst_apro_step_flg'); 
		
		 // 201410 민정호 ERP에서 결재선 진행 중이면 SAVE버튼 비활성화
		 if(gubunApAr == '07' &&
			rqst_apro_step_flg == 'Y'){
			 ComBtnEnable("btn_save");
			 form.apro_flg[0].disabled = false;
			 form.apro_flg[1].disabled = false;
			 form.cxl_desc.disabled = false;						 
		     form.cxl_desc.readOnly = false;
		     form.cxl_desc.className = "input1";			 
		 }else  if(gubunApAr == '07' &&			 
					rqst_apro_step_flg != 'Y'){
			 ComBtnDisable("btn_save");
			 
			 form.apro_flg[0].disabled = true;
			 form.apro_flg[1].disabled = true;
	    	 form.cxl_desc.readOnly = true;
	    	 form.cxl_desc.className = "input2";	    	  
		 }else  if(gubunApAr == '20' &&			 
					rqst_apro_step_flg == 'Y'){	    	 
			 ComBtnEnable("btn_save");
			 form.apro_flg[0].disabled = false;
			 form.apro_flg[1].disabled = false;
			 form.cxl_desc.disabled = false;						 
		     form.cxl_desc.readOnly = false;
		     form.cxl_desc.className = "input1";				    	 
		 }else  if(gubunApAr == '20' &&			 
					rqst_apro_step_flg != 'Y'){
			 ComBtnDisable("btn_save");
			 
			 form.apro_flg[0].disabled = true;
			 form.apro_flg[1].disabled = true;
	    	 form.cxl_desc.readOnly = true;
	    	 form.cxl_desc.className = "input2";		    	 
		 }else{
			 ComBtnEnable("btn_save");
			 form.apro_flg[0].disabled = false;
			 form.apro_flg[1].disabled = false;
			 form.cxl_desc.disabled = false;						 
		     form.cxl_desc.readOnly = false;
		     form.cxl_desc.className = "input1";			 			 
		 }		
	}
	
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	if(sheetObj.RowCount > 0){
    		setCsrHeadInfomation(sheetObj, 1);
//    		setUrgPayFlg(sheetObj);
    		
    		setSaveBtn();    		
    	} else {
    		form.request_team.value = "";
    		form.csr_dt.value = "";
    		form.rqst_dt.value = "";
    		form.produced_by.value = "";
    		form.csr_desc.value = "";
    		form.ownr_cd.value = "";
    		form.ownr_nm.value = "";
    		form.csr_curr_cd.value = "";
    		form.csr_amt.value = "";
    		form.evid_tp.value = "";
    		form.deduction[0].checked = false;
    		form.deduction[1].checked = false;
    		form.rqst_amt.value = "";
    		form.diff_desc.value = "";
    		form.cxl_flg[0].checked = false;
    		form.cxl_flg[1].checked = false;
    		form.apro_flg[0].checked = false;
    		form.apro_flg[1].checked = false;
    		form.apro_flg[0].disabled = true;
    		form.apro_flg[1].disabled = true;
    		form.cxl_desc.value = "";
    		form.slp_no.value = "";
    		form.vsl_code.value = "";
    		form.vsl_eng_name.value = "";
    		
    		form.urg_pay_flg[0].disabled = true;
    		form.urg_pay_flg[1].disabled = true;    		
    		form.urg_pay_flg[0].checked = false;
    		form.urg_pay_flg[1].checked = true;		// 기본값    	    		
    	}
    }
        
    /**
     * Approval Step & Comments 화면 호출해서 승인 처리 한다.<br>
     **/    
    function doActionApprove(){
    		var sheetObj = sheetObjects[0];
    		var formObj = document.form;
    	    		
    		formObj.apro_flg[0].checked = true;    		
    		approval_click();
    		formObj.cxl_flg[1].checked = true;
    		    		    		
    		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "apro_flg") = "Y";
    		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cxl_flg") = "N";
    		
    		if(formObj.urg_pay_flg[0].checked){
    			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "urg_pay_flg") = "Y";	
    		}else{
    			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "urg_pay_flg") = "N";
    		} 		    		
    		    		    		
    		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cxl_desc") = ""; 		
    		
    		doActionIBSheet(sheetObj,formObj,IBSAVE);    		      		
    }
    
    /**
     * Approval Step & Comments 화면 호출해서 승인 처리 한다. <br>
     **/    
    function doActionDisapprove(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		formObj.apro_flg[1].checked = true;
		approval_click();
		
		formObj.cxl_flg[0].checked = true;
		formObj.cxl_desc.value = "Cancel";
				
		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "apro_flg") = "Y";
		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cxl_flg") = "N";
		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "urg_pay_flg") = "N";		
		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cxl_desc") = "Cancel"; 		    	
    	
		doActionIBSheet(sheetObj,formObj,IBSAVE);			        	    	
    }
    
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	var formObj = document.form;
    	doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }    
        
	/* 개발자 작업  끝 */