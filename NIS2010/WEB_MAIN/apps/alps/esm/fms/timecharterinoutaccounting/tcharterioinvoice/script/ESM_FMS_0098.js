/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0098.js
*@FileTitle : Slip Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 채창호
*@LastVersion : 1.0
* 1.0 Creation
* 
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
    function ESM_FMS_0098() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.initRdConfig			= initRdConfig;
        this.rdOpen					= rdOpen;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수 
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
    var rdCnt = 0;
	
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
					setCancellationDate();
					sheetObject.Editable = true;
				    break;
	
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);	
                    break;
                    
				case "from_ef_dt": 
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.from_eff_dt, 'yyyy-MM');
					break;
				 
	 			case "to_ef_dt": 
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.to_eff_dt, 'yyyy-MM');
					break;
			           
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0022");
					break;
				case "btn_print":
					rdOpen(rdObjects[0], document.form);
					ComBtnEnable("btn_save");
					break;
					
				case "apro_step_btn" :
    				var v_ofc_cd = formObject.supplier_cd.value;
    	    	    
    	    	    
    	    	    var v_sub_sys_cd = "FMS";
    	            var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
    					ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 540, '', 'none', true);
    			break;

				case "btn_excel":
					sheetObject.Down2Excel(-1, false, false, true);
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
        setCancellationDate();
        //RD
		initRdConfig(rdObjects[0]);
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
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(true, true, true, true, false,false);
                   
                    var HeadTitle1 = "|Seq|Office.|CSR No|GL Date|VVD|Description|Attach|Attach|Curr|Amount|USD AMT|Matching  CSR No|GL Date|USD Amount|Ex. Diff|Transaction CSR No|org_csr_no1|org_csr_no2|attach_link";
                    var HeadTitle2 = "|Seq|Office.|CSR No|GL Date|VVD|Description|Cnt   |Cnt   |Curr|Amount|USD AMT|Matching  CSR No|GL Date|USD Amount|Ex. Diff|Transaction CSR No|org_csr_no1|org_csr_no2|attach_link";
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                 
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 00,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,   	40,    daCenter,  true,    "select_check");
					InitDataProperty(0, cnt++ , dtData,   		80,    daCenter,  true,    "slp_ofc_cd",   false,     "", 		dfNone,   		0,     	false,		false);
                                                                                                                             
					InitDataProperty(0, cnt++ , dtData,   		180,   daCenter,  true,    "csr_no",     	true,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,  true,    "eff_dt",       false,     "", 		dfDateYmd, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		90,    daCenter,  true,    "vvd",          false,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		160,   daLeft,   true,    "ap_desc",   	false,     "", 		    dfNone,   	    0, 		false,		false);
					InitDataProperty(0, cnt++ , dtPopupEdit, 	20,    daCenter,  true,    "att_link", 	false,     "",        	dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData, 	    60,    daCenter,  true,    "atch_file_flet_knt", 	false,     "",    	dfNone, 		0,     	false,		false);
					
					InitDataProperty(0, cnt++ , dtData  ,   	50,    daCenter,  true,    "curr",         false,     "", 		dfNone,   		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData  ,   	90,    daRight,  true,    "amt",          false,     "", 		dfFloat, 		2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData  ,   	90,    daRight,  true,    "usd_amt",  	   false,     "", 		dfFloat, 		2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData  ,   	180,   daCenter,  true,    "match_csr_no",	false,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData  ,   	90,    daCenter,  true,    "gl_date"   ,	false,     "", 		dfDateYmd, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData  ,   	90 ,   daRight,   true,    "match_csr_usd_amt",false,     "", 		dfFloat,			2, 		false,		false);
					InitDataProperty(0, cnt++ , dtData  ,   	90,    daCenter,  true,    "locl_xch_rt_amt",   	false,     "",    	dfFloat, 		2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData  ,   	150,   daCenter,  true,    "transaction_csr_no",    false,     "", 		dfNone, 		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden  ,   	150,   daCenter,   true,    "ori1_csr_no",  	false,     "", 		dfNone, 	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden  ,   	150,   daCenter,   true,    "ori2_csr_no",  	false,     "", 		dfNone, 	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtHidden  ,   	120,   daCenter,  false,    "attach_link",   	false,     "", 		dfNone,			0, 		false,		false);
					
					ShowButtonImage = 2;
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
        	   if(!validateForm(sheetObj,formObj,sAction)) return;
	  			formObj.f_cmd.value = SEARCH;
	  			
	  			sheetObj.DoSearch("ESM_FMS_0098GS.do" , FormQueryString(formObj));

                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction)) return;
           		var sParam = "";
           		var sParamSheet1 = sheetObjects[0].GetSaveString();
           	     formObj.f_cmd.value = MULTI;
	 			sParam += FormQueryString(formObj) + "&" + sParamSheet1;
				var sXml = sheetObj.GetSaveXml("ESM_FMS_0098GS.do", sParam);
		        var saveFlag = ComFmsGetXMLData(sXml, "TR-ALL");
		        sheetObj.LoadSaveXml(sXml);
		        
		        var new_csr_no = ComGetEtcData(sXml, "new_csr_no");
		        formObj.new_csr_no.value = new_csr_no; 
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

       			break;		
   				
       		case IBSEARCH_ASYNC04:	//2014.12 민정호 AR 결재 요청

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
       //2010.11.24 이상민 [CHM-201007233-01] : vsl_cd 는 eng_keypress-> eng_num_keypress로 변경
        axon_event.addListener  ('keypress', 'eng_num_keypress', 'vsl_cd', 'origin_csr_no','match_csr_no');
        axon_event.addListenerForm('blur', 'obj_deactivate', form); // - form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        axon_event.addListenerForm  ('blur'				, 'obj_blur', 		document.form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
      
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
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
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
//    function condition_click() {
//    	if(form.condition[0].checked) {
//    		setEffectiveDate(form.condition[0].value);
//    	} else {
//    
//    	}
//    }
     
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
	 * Cancellation Month Date에 오늘 년월 세팅
	 */
	function setCancellationDate() {
        var now=new Date();

        var y=now.getYear()+"";
        var M=now.getMonth()+1;
        if (M < 10) M = '0'+M;
   
        document.form.from_eff_dt.value = y+"-" +M ;
        document.form.to_eff_dt.value = y+"-" +M;
	}
	
	 
    /**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
 	function formReset() {
 	    ComResetAll();
 	    
//// 	    setEffectiveDate('E');
//// 		
// 		form.vsl_cd.readOnly = false;
// 		form.btn_vslpop.style.cursor = "hand";
// 		document.images["btn_vslpop"].name = "btn_vslpop";
// 		
// 		form.vsl_cd.value = "";
 	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction){

    	/*if(formObj.condition[0].checked) {
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
    	}*/

        if (sAction == IBSAVE) {
        	if(sheetObj.isDataModified == false) {
        		ComShowCodeMessage("FMS00007");
	     		return false;
        	}
       	
        	if(formObj.from_eff_dt.value == "") {
    			ComAlertFocus(formObj.from_eff_dt, ComGetMsg('FMS20009'));
    			return;
    		} else if(formObj.to_eff_dt.value == "") {
    			ComAlertFocus(formObj.to_eff_dt, ComGetMsg('FMS20010'));
    			return;
    		} else {
    			if(parseInt(formObj.from_eff_dt.value.trimAll('-')) > parseInt(formObj.to_eff_dt.value.trimAll('-'))) {
    				ComAlertFocus(formObj.to_eff_dt, ComGetMsg('FMS20011'));
        			return;
    			}
    		}
        }else {
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
        }
      
        return true;
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
	function t1sheet1_OnClick(sheetObj, row, col, cellX, cellY, cellW, cellH) {
		var csrNo =   sheetObj.CellValue(row,"csr_no");
		var slpSeqNo = sheetObj.CellValue(row ,"attach_link");
		var colName = sheetObj.ColSaveName(col);
 		if(colName == "att_link"){
 			fmsFileUploadPopUp(sheetObj, row, "Y", csrNo);		 		 		
 	 	}
	}
     
	
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function t1sheet1_OnSearchEnd(sheetObj, errMsg) {
    }
        
    
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
    	var formObj = document.form;
    	doActionIBSheet(sheetObj,formObj,IBSEARCH);
    	sheetObj.Editable = false;
    }    
        
    /**
     * FMS File Upload 팝업 오픈
     */
    function fmsFileUploadPopUp(sheetObj, Row, edit_able, csr_no) {
    	var atch_file_flet_lnk_id =  '';	 
    	atch_file_flet_lnk_id =  sheetObj.CellValue(Row, "attach_link");	
    	if (atch_file_flet_lnk_id == undefined || atch_file_flet_lnk_id == null || ComTrim(atch_file_flet_lnk_id) == ''){
    		atch_file_flet_lnk_id = '';
    	}
    	if (csr_no == undefined || csr_no == null || ComTrim(csr_no) == ''){
    		csr_no = '';
    	}
    	 		
    	var param = "?atch_file_flet_lnk_id=" + atch_file_flet_lnk_id+
    					 "&csr_no=" + csr_no +
    					 "&edit_able=" + edit_able +
    					 "&row=" + Row;					
    	ComOpenPopup("/hanjin/ESM_FMS_0092.do" + param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");	 
    }
    
    /**
     * FileUpload 호출 뒤에 발생  
     */
    function popupFinish(){
    }
    
    /**
     * RD 출력하기 <br>
     * @param {ibsheet}	rdObject    IBSheet Object
     * @param {form}    formObj     Form Object
     **/
    function rdOpen(rdObject, formObject){
  		/*if(sheetObjects[0].RowCount == 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		var searchFlg = "Y";
  		var row = sheetObjects[0].SelectRow;
  		form.csr_no.value = sheetObjects[0].CellValue(row, "transaction_csr_no");
		if(form.csr_no.value == "") {
		  ComShowCodeMessage("FMS00015");
		 return;
	   }
  		form.csr_type.value = "AP";
//  		if(form.csr_no.value == "") {
//  			searchFlg = "N";
//  			form.csr_no.value = form.slp_no.value;
//  		}
  		
//  		if(form.slp_no.value.substring(0,2) == "07") {
//  			form.csr_type.value = "AP";
//  		} else {
//  			form.csr_type.value = "AR";
//  		}
  		
  		
 		var Rdviewer = rdObject ;
 	
 		rdParam = RD_FormQueryString(formObject,1);
 		var rdParam = '/rv '+ rdParam;
 		var rdFile = 'ESM_FMS_032.mrd';

 		// 열고자 하는 RD 파일을 지정한다.
 	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/'+rdFile, RDServer+rdParam);
 		Rdviewer.CMPrint (); //인쇄 시작
 		
 		if(searchFlg == "N") {
 			form.csr_no.value = "";
 		}*/
 		
 		if (formObject.new_csr_no.value == "") {
 			ComShowCodeMessage("FMS00015");
 			return;
 		}

 		formObject.csr_type.value = "AP"; 
 		formObject.csr_no.value = formObject.new_csr_no.value; 
 		
 		var Rdviewer = rdObject;

 		rdParam = RD_FormQueryString(formObject, 1);
 		var rdParam = '/rv ' + rdParam;
 		var rdFile = 'ESM_FMS_032.mrd';

 		// 열고자 하는 RD 파일을 지정한다.
 		Rdviewer.FileOpen( RD_path + 'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/' + rdFile, RDServer + rdParam);
 		Rdviewer.CMPrint (); //인쇄 시작 
 	}
    
    /**
   	 * 페이지에 있는 RD Object를 로드한다. <br>
   	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
   	 * @param {rdObject} rdObject    RD Object
   	 **/
   	function initRdConfig(rdObject){
   	    var Rdviewer = rdObject ;
   	    Rdviewer.style.height = 0;
   	    Rdviewer.style.width = 0;
   	    
   	    Rdviewer.AutoAdjust = true;
   	    Rdviewer.ViewShowMode(0);

   		Rdviewer.setbackgroundcolor(128,128,128);
   		Rdviewer.SetPageLineColor(128,128,128);
   	}
   	

   	/**
   	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
   	 */
   	function obj_deactivate() {
   		obj = event.srcElement;
   		switch(obj.name) {
   			case "transact_cd":
   				if (obj.value == 'Y') {
   					ComBtnDisable("btn_save");
   				}
   				else {
   					ComBtnEnable("btn_save");
   				}
   				break;
   	   		}

   	}
	/* 개발자 작업  끝 */