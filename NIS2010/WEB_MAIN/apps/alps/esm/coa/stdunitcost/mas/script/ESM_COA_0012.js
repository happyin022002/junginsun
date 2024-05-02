/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0012.js
*@FileTitle : ABC (PA) / STP Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.08.04 전윤주
* 1.0 Creation
* 2009.10.14 장영석 : f_ofc_act_cd_OnChang메서드를 사용하지 않으므로 삭제
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가 
* 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
     * @class ESM_COA_0012 : ESM_COA_0012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0012() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
    	this.sheet1_OnChange        = sheet1_OnChange;
    	this.validateForm 			= validateForm;
    	this.check_Enter            = check_Enter;
    }
    
   	/* 개발자 작업	*/
  // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_new":
        	            sheetObject.RemoveAll();
        	            formObject.reset();
            	        break;
        			case "btn_Retrieve":        				
        				doActionIBSheet(sheetObject,formObject,IBSEARCH);
        				break;

        			case "btn_Save":
        				doActionIBSheet(sheetObject,formObject,IBSAVE);
        				break;

        			case "btng_rowadd":
        				doActionIBSheet(sheetObject,formObject,IBINSERT);
        				break;

        			case "btn_DownExcel":
        				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        				break;
        			case "btn_Month_Copy":		//팝업창(Month Copy)
        	     	       var display = "0,1";
        	     	       ComOpenPopup("ESM_COA_0173.do?classId=ESM_COA_0012", 250, 200, "AverageUcCopy", display, true, false);
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
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {

            for(i=0;i<sheetObjects.length;i++){
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가 
                ComEndConfigSheet(sheetObjects[i]);
            }
            loadingMode = true;
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            // 멀티콤보 처리
            //---------------------------------------------
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
            loadingMode = false;
            
        	//SELCDA일 경우만 COPY/SAVE 버튼 활성화 
        	
        	if (document.form.v_ofc_cd.value == 'SELCSG' || document.form.v_ofc_cd.value == 'CLTCO'){
//        		ComBtnEnable("btn_Save");
//        		ComBtnEnable("btn_Month_Copy");
        	} else {
//        		ComBtnDisable("btn_Month_Copy");
//        		ComBtnDisable("btn_Save");
        	}
            ComSetFocus(document.form.f_cost_yrmon);
        }
        
        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj, sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {

                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);
                        //대량데이타조회시
                        //MassOfSearch = 1;
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(14, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle0 = " |YYYYMM|Office|act_cd|Activity|STP CHK|By Activity|By Activity|By Activity|By Activity|STP Margin|STP Margin|STP Margin|STP Margin" ;
                        var HeadTitle1 = " |YYYYMM|Office|act_cd|Activity|STP CHK|UOM|Vol.|AMT|Unit Cost|Country|Unit Cost|Margin%|STP U/C" ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle0, true);
                        InitHeadRow(1, HeadTitle1, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        //InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  true,    "del1");
                        InitDataProperty(0, cnt++ , dtStatus,     1,     daCenter,  true,    "ibflag");
    		            InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "cost_yrmon",           false,      "",       dfNone,      0,     false,      false);
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "ofc_cd",               false,      "",       dfNone,      0,     false,      false);
           				InitDataProperty(0, cnt++ , dtHidden,  	  60,	 daCenter,	true,	 "ofc_act_cd",	         false,		 "",	   dfNone, 	    0,	   false,	   false);
                        InitDataProperty(0, cnt++ , dtData,      150,    daCenter,  true,    "ofc_act_nm",           false,      "",       dfNone, 	    0,     false,      false);
                        InitDataProperty(0, cnt++ , dtCheckBox,	  70,	 daCenter,	true,	 "svc_trns_prc_flg",	 false,		 "",	   dfNone, 	    0,	   false,	   false);
                        InitDataProperty(0, cnt++ , dtData,      250,    daLeft,    true,    "div_meas_nm",          false,      "",       dfNone,      0,     false,      false);
                        InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,    "act_ofc_ttl_qty",      false,      "",       dfNullFloatOrg,   2,false,	   false);
                        InitDataProperty(0, cnt++ , dtData,       80,    daRight,   true,    "act_ofc_ttl_amt",      false,      "",       dfNullFloatOrg,   2,false,      false);
                        InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,    "act_cost_ut_amt",      false,      "",       dfNullFloatOrg,   5,true,        true);
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "svc_trns_prc_cnt_cd",  false,      "",       dfNone,      0,     false,	   false);
                        InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,    "cnt_avg_uc_amt",       false,      "",       dfNullFloatOrg,   5,false,	   false);
                        InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,    "stp_mgn_rto",          false,      "",       dfNullFloatOrg,   2,true,        true);
                        InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,    "svc_trns_prc_ut_amt",  false,      "",       dfNullFloatOrg,   5,false,      false);//|act_avg_uc_amt|*(|svc_trns_prc_mgn_amt|/100)

    					RangeBackColor(1, 5, 1, 13) = RgbColor(222, 251, 248);  // ENIS

                        CountPosition  = 2 ;
                        style.height = GetSheetHeight(14) ;

                   }
                   break;
            }
        }
         
         /**
          * 콤보 항목을 설정한다. 
          */
         function initCombo (comboObj, comboId) {
         	 with (comboObj) {
     	    	 DropHeight = 300;
     	    	 comboObj.InsertItem(0, 'All' ,'');
     	    	 Index = 0;
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
          * IBCombo Object를 배열로 등록
          * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
          * 배열은 소스 상단에 정의 by.yjjeon
          */
         function setComboObject(combo_obj){
             comboObjects[comboCnt++] = combo_obj;
         }
        /**
         * 조회후 소개 계산
         */
        function sheet1_OnSearchEnd(sheetObj, ErrMsg)
        {
            //sheetObj.ShowSubSum( "ofc_cd", "col6|col7|col8|col10|col11|col12", -1, true, false , 1 ,"0=;1=;3=%s TTL");
        }
        
        
        /**
         * 수치 바꾼후에 소개 계산
         */
        function sheet1_OnChange(sheetObj , Row, Col, Val)
        {
            var lstcol = sheetObj.LastRow ;

            for(var i = 2; i <= lstcol; i++ ){
                sheetObj.CellValue2(i,"stp_mgn_rto") = sheetObj.CellValue(Row, Col);
            }

            //sheetObj.HideSubSum("ofc_cd");
            //sheetObj.ShowSubSum( "ofc_cd", "col6|col7|col8|col10|col11|col12", -1, true, false , 1 ,"0=;1=;3=%s TTL");

        }

        /**
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {        	
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {
            	case IBCLEAR:          //조회
			        sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_COA_0012GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_ofc_act_cd, "code", "name");
					
					ComOpenWait(false);
					break;	
               case IBSEARCH:      //조회
                    if(validateForm(sheetObj,formObj,sAction)) {                	
                    	// 업무처리중 버튼사용 금지 처리
                    	sheetObj.WaitImageVisible = false;
                    	ComOpenWait(true);
                        formObj.f_cmd.value = SEARCH;                        
                        sheetObj.DoSearch4Post("ESM_COA_0012GS.do", coaFormQueryString(formObj));
                        ComOpenWait(false);
                    }
                    break;
                case IBSAVE:       //저장
                  if(validateForm(sheetObj,formObj,sAction)) {
                	  // 업무처리중 버튼사용 금지 처리
                  	  sheetObj.WaitImageVisible = false;
                  	  ComOpenWait(true);
                      formObj.f_cmd.value = MULTI;
                      sheetObj.DoAllSave("ESM_COA_0012GS.do", coaFormQueryString(formObj, 'f_cost_yrmon'));
                      ComOpenWait(false);
                  }
                  break;

               case IBINSERT:      // 입력
                    sheetObj.DataInsert();
                    //sheetObj.HideSubSum("ofc_cd");
                    //sheetObj.ShowSubSum( "ofc_cd", "col6|col7|col8|col10|col11|col12", -1, true, false , 1 ,"0=;1=;3=%s TTL");
                    break;

               case IBCOPYROW:        //행 복사
                  sheetObj.DataCopy();
                  break;

               case IBDOWNEXCEL:        //엑셀 다운로드
    				//sheetObj.SpeedDown2Excel(-1, true, true);
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false);
    						break;
    				}
    				break;

               case IBLOADEXCEL:        //엑셀 업로드
                  sheetObj.LoadExcel();
                  break;
            }
        }  

       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){        	
    		var rt = false;
            with(formObj){            	
                if (!ComIsDate(formObj.f_cost_yrmon , "ym")) {
                	ComShowCodeMessage('COM12180');
          			ComSetFocus(formObj.f_cost_yrmon);
                } else {
    				rt = true;
    			}    			
                if (ComParseInt(formObj.f_cost_yrmon.value.replace("-","")) < 200707) {
        		    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
        			ComShowCodeMessage('COA10037');
        		    rt = false;
        		}
            }
            return rt;
        }

        /**
         * 조회조건 엔터키 이력시 조회
         */
        function check_Enter(){
            if (event.keyCode==13) {
              if(Layer.style.display == "none"){
               doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
              }else {
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
         }
      }

	/* 개발자 작업  끝 */