/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0001.js
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.10.05
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.10.05 Jeon Jae Hong
* 1.0 Creation
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

	/**
	 * @extends 
	 * @class ESD_LEA_0001 : ESD_LEA_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */

	function ESD_LEA_0001() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
		var sheetObject = sheetObjects[0];
		/**********************************************************************/
		
		var formObject = document.form;
 
		try {
				var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":     		
						lea_retrieve(sheetObject,formObject);        	            
						break;

					case "btn_batchstart":
						if(sheetObject.CellValue(1, "cond_cfm_flg") != "Y"){
							//ComShowMessage("Please check conditions before starting batch.");
							ComShowMessage(ComGetMsg("LEA90007"));
						  return false;
						}

        	            doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
        	            //ComShowMessage(ComGetMsg("LEA90025"));
            	        break;

            	    case "btng_confirm":
        	    		if(!(sheetObject.CellValue(1, "ap_clz_flg" ) == "Y" &&
							sheetObject.CellValue(1, "rev_vvd_if_flg" ) == "Y" &&
							sheetObject.CellValue(1, "mon_avg_xch_rt_if_flg" ) == "Y")){
							//ComShowMessage("Please check conditions before starting batch.");
							ComShowMessage(ComGetMsg("LEA90007"));
							return false;
        	    		}
        	    		doActionIBSheet(sheetObject,formObject,IBSAVE);
        	    		break;

            	    case "btns_rev_vvd_search":
						var url_str = "ESD_LEA_0902.do";
						url_str += "?exe_yrmon="	+formObject.frm_exe_yrmon.value;
						url_str += "&rev_yrmon="	+formObject.frm_exe_yrmon.value;
						window.showModalDialog(url_str, window, "dialogWidth:600px; dialogHeight:480px; help:no; status:no; resizable:yes;");
						//ComOpenWindow(url_str, "RevVVD", "statebar = no , width= 600 , height=500" );
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
			//시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			
			initSheet(sheetObjects[i],i+1);
			
			//마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		} 
		
		lea_enterRetrieve();
		
	}

	
	
       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        //전체 너비 설정
                        //SheetWidth = mainTable.clientWidth;
    										SheetWidth = 400;
                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(22, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle = "SEQ|Checking Items|Status" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++,  dtStatus,    30,    daCenter,  true,    "ibflag");
                        InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,    ""												 ,        false,          "",       dfNone,   	0,     true,        true);
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "exe_yrmon"								 ,        false,          "",       dfNone,   	0,     false,        false);  	                                                             														
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ap_clz_flg"               ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "ap_clz_flg_nm"            ,        false,          "",       dfNone,   	0,     false,        false);                                        
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "rev_vvd_if_flg"           ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "rev_vvd_if_flg_nm"        ,        false,          "",       dfNone,   	0,     false,        false);                                    
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "rev_vvd_if_knt"           ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mon_avg_xch_rt_if_flg"    ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mon_avg_xch_rt_if_flg_nm" ,        false,          "",       dfNone,   	0,     false,        false);                             
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mon_avg_xch_rt_if_knt"    ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mon_avg_xch_rt_if_flg_desc",        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "cond_cfm_flg"             ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "cond_cfm_flg_nm"          ,        false,          "",       dfNone,   	0,     false,        false);                                      
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mnl_inp_flg"              ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "mnl_inp_flg_nm"           ,        false,          "",       dfNone,   	0,     false,        false);                                       
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "erp_if_flg"               ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "erp_if_flg_nm"            ,        false,          "",       dfNone,   	0,     false,        false);                                        
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "erp_if_flg_desc"          ,        false,          "",       dfNone,   	0,     false,        false);  
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "erp_if_dt"                ,        false,          "",       dfNone,   	0,     false,        false);                                                                          
						InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "rev_vvd_if_desc"          ,        false,          "",       dfNone,   	0,     false,        false);                                                                          

                        style.height = GetSheetHeight(11) ;
                   }
                    break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //조회
               		if (!lea_fnChkSearchForm(formObj)) return false;
            	            
    				    	formObj.f_cmd.value = SEARCH;
    				    	
    						 //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0001GS.do", FormQueryString(formObj));
    				    	
    				    	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0001GS.do",leaFormQueryString(formObj));
    				    	
    					    //ComShowMessage(searchXml);
    						  
    					    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
    					   
                    break;
                    
			case IBSAVE:  //저장
				if (!lea_validateForm(sheetObj,formObj,sAction))return false;				
				formObj.f_cmd.value = MULTI01;
				//var savexml = sheetObj.GetSaveXml("ESD_LEA_0001GS.do", FormQueryString(formObj));
				
				var savexml = sheetObj.GetSaveXml("ESD_LEA_0001GS.do", leaFormQueryString(formObj));
				
				if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
				break;
			
				
			case IBSEARCH_ASYNC01: //Batch Start
			    if (!lea_validateForm(sheetObj,formObj,sAction))return false;
			    formObj.f_cmd.value = MULTI02;
			    
			    //var savexml = sheetObj.GetSaveXml("ESD_LEA_0001GS.do", FormQueryString(formObj));			    	   
			    var savexml = sheetObj.GetSaveXml("ESD_LEA_0001GS.do", leaFormQueryString(formObj));
			    
			    if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
			    ComShowMessage(sheetObj.EtcData("BATCH_EXE_RESULT"));
			    break;

			    

		}
	}
       
	
	/*
	 * Sheet Save 끝난후 발생하는 Event처리 함수
	 */
	function t1sheet1_OnSaveEnd(t1sheet1, ErrMsg) {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		//if (ErrMsg == null || ErrMsg == ""){
		lea_enterRetrieve();
		//}   
	} 
	
	
	/**
	 * 조회 프로세스처리. Enter Event에 사용하기위해 파라메터 받지않음.
	 */
	function lea_retrieve(sheetObj,formObj){
		//zu_openRunning(true);      //화면 로딩 또는 기능 수행시 Progressing bar 표시 Start   
		sheetObj.RemoveAll();		
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
		lea_setSheetToForm(sheetObj,formObj);
		//zu_openRunning(false);     //화면 로딩 또는 기능 수행시 Progressing bar 표시 End   
	}    

	
	/**
	* EnterKey Event 조회 프로세스 처리
	*/
	function lea_enterRetrieve(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;		 
		lea_retrieve(sheetObject,formObject);	
	}
    		

	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function lea_validateForm(sheetObj,formObj,sAction){
		return true;
	}
        

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function lea_fnChkSearchForm(formObj){
		if(!lea_comm_fnChkEmptyObj(formObj.frm_exe_yrmon)) return false;
		return true;
	}
      
	
	/**
	 *  Sheet값 Form으로 Copy 프로세스 처리
	 */
	function lea_setSheetToForm(sheetObj,formObj){
		if (sheetObj.RowCount > 0){
			formObj.frm_ap_clz_flg_nm.value = sheetObj.CellValue(1, "ap_clz_flg_nm"  );
			formObj.frm_rev_vvd_if_flg_nm.value = sheetObj.CellValue(1, "rev_vvd_if_desc" );
			formObj.frm_mon_avg_xch_rt_if_flg_nm.value = sheetObj.CellValue(1, "mon_avg_xch_rt_if_flg_desc");
			//formObj.frm_rev_vvd_if_knt.value = sheetObj.CellValue(1, "rev_vvd_if_knt" );
			formObj.frm_erp_if_flg_desc .value = sheetObj.CellValue(1, "erp_if_flg_desc" );

			//조건에 따라 Confirm 버튼 활성
			if( sheetObj.CellValue(1, "ap_clz_flg" ) == "Y" &&
				sheetObj.CellValue(1, "rev_vvd_if_flg"  			) == "Y" &&
				sheetObj.CellValue(1, "mon_avg_xch_rt_if_flg") == "Y"){
				//set_ButtonImageVisiable(formObj.btng_confirm,	true);
			}else{
				//set_ButtonImageVisiable(formObj.btng_confirm,	true);
				//set_ButtonImageVisiable(document.form.btng_confirm,	false);
			}
		}
	}
	
	
	/* 개발자 작업  끝 */