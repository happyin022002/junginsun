/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1004.js
*@FileTitle : Sales Forecast Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 전지예
*@LastVersion : 1.0
* 2014.11.27 전지예 [CHM-201432889]    Sales Forecast Detail 화면 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var headCount = 0;
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
    * @extends 
    * @class EES_EQR_1004 
    */
    function EES_EQR_1004() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    // 공통전역변수
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var IBSEARCH02  = 30;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt = 0;
        var sheetObject = sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            
            switch(srcName) {
	            case "btn_retrieve":
	                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	                break;
	                
				case "btn_new":
					// 초기화
					formObject.reset();
					
					formObject.loc_cd.value = "";
					formObject.fm_week.value = "";
					formObject.to_week.value = "";
					
	                sheetObjects[0].RemoveAll();
	                break;
	                
                case "btn_downExcel":
                    if(sheetObjects[0].RowCount > 0) {
                        doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                    }
                    break;
                    
                case "btn_close":
                    window.close();
                    break;
                    
				case "btn_loc_cd":	//Location Second 조회 팝업
	    	        var cnt_cd = "";
	    	        var loc_cd = "";
		            cnt_cd = formObject.loc_grp_cd.value;
		            loc_cd = formObject.loc_cd.value;
		            
		            if ( formObject.loc_grp_cd.value != '' ) {
	        			var loc_code = "";
	                    
	        			if ( formObject.loc_grp_cd.value == "" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( formObject.loc_grp_cd.value == "R" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( formObject.loc_grp_cd.value == "L" ) {
	        				loc_code = "lcc_cd";
	        			} else if ( formObject.loc_grp_cd.value == "E" ) {
	        				loc_code = "ecc_cd";
	        			}
						var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 440, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		            }
					break;
                    
            }
        } catch(e) {
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * 초기 이벤트 등록
     */
    function initControl() {
    	axon_event.addListener('change', 'loc_grp_cd_onchange', 'loc_grp_cd');		// Location 변경시 이벤트 처리
        axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');	// LOC_CD keyup 이벤트 처리
        axon_event.addListener('keyup', 'fm_week_onkeyUp', 'fm_week');			// fm_week keyup 이벤트 처리
        axon_event.addListener('keyup', 'to_week_onkeyUp', 'to_week');				// to_week keyup 이벤트 처리
        axon_event.addListener('keyup', 'fm_date_onKeyUp', 'fm_date');				// fm_date keyup 이벤트 처리
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 		// form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 	// form OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);                // 알파벳 대문자,숫자만 입력허용
        axon_event.addListenerForm('blur', 'obj_blur', form); 						// form obj_blur이벤트에 코드 처리
        
        // Creation Date 비활성화
		ComEnableObject(document.form.fm_date,		false);
		ComEnableObject(document.form.to_date,		false);
    }
    
    /**
     * Location  변경시 이벤트 처리
     * 나머지 활성화
     */
    function loc_grp_cd_onchange() {
    	var formObject = document.form;
        ComSetFocus(document.form.loc_cd);
    }
	
    /**
     * LOC_CD keyup 이벤트 처리
     * LOC_CD keyup시 대분자로 처리
     */
    function loc_cd_onkeyUp() {
        var formObject = document.form;
        if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
    	    document.getElementById("loc_cd").setAttribute("maxLength",5);
    	    if ( formObject.loc_cd.value.length == 5 ) {
    		    ComSetFocus(document.form.fm_week);
    	   }
        }
    }
 	
    /**
     * Week FM  keyup 이벤트 처리
     * Week FM  keyup YYYY-MM 포멧 처리
     */
     function fm_week_onkeyUp() {
    	 if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	        var formObject = document.form;
	        var fm_week = formObject.fm_week.value.replace(/\/|\-|\./g, "");
	        if ( fm_week.length == 6 ) {
	        	formObject.fm_week.value = fm_week.substr(0,4)+"-"+fm_week.substr(4,6);
	        	ComSetFocus(formObject.to_week);
	        }
    	 }
     }
     
     /**
     * Week TO  keyup 이벤트 처리
     * Week TO  keyup YYYY-MM 포멧 처리
     */
     function to_week_onkeyUp() {
    	 if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	        var formObject = document.form;
	        var to_week = formObject.to_week.value.replace(/\/|\-|\./g, "");
	        if ( to_week.length == 6 ) {
	        	formObject.to_week.value = to_week.substr(0,4)+"-"+to_week.substr(4,6);
	  	   	}
    	 }
     }
     
     function fm_date_onKeyUp(){
    	 if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
    		 var formObject = document.form;
    		 var fm_date = formObject.fm_date.value.replace(/\/|\-|\./g, "");
    		 if ( fm_date.length == 2 ) {
    			 ComSetFocus(document.form.to_date);
    		 }
    	 }
     }
     
     /**
      * Period FM  beforeactivate 이벤트 처리
      * Period FM  beforeactivate -없애기
      */    
  	function obj_activate() {
  		ComClearSeparator(event.srcElement);
  	}
	
  	function fncCheckWeek() {
  		var formObj = document.form;
	  	if(formObj.fm_week.value != "" && formObj.to_week.value != "") {
	  		if(formObj.fm_week.value.trimAll("-") > formObj.to_week.value.trimAll("-")) {
	  			ComShowMessage(ComGetMsg("EQR90070","FM"));
	  			ComSetFocus(formObj.fm_week);
	  			return false;
	  		}
	  		
	  		return true;
	  	}
  	}
  	
    /**
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
    function obj_keypress() {
        var formObject = document.form;
        
        switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
				break;
				
			case "rlane_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
				
			case "fm_week":
				ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "to_week":
				ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "fm_date":
				ComKeyOnlyNumber(event.srcElement);
				break;

			case "to_date":
				ComKeyOnlyNumber(event.srcElement);
				break;
        }
    }
    
    /**
     * blur 이벤트 처리
     */
    function obj_blur() {
		var formObject = document.form;
		
		switch (event.srcElement.name) {
			
			case "fm_week":
				if ( ComReplaceStr(formObject.fm_week.value,"-","") != "" && !ComIsDate(formObject.fm_week.value, "yw") ) {
		  			ComShowMessage(msgs["EQR90056"]);
		  			formObject.fm_week.value = "";
		  			ComSetFocus(formObject.fm_week);
		  			return;
		  		}
				break;
				
			case "to_week":
				if ( ComReplaceStr(formObject.to_week.value,"-","") != "" && !ComIsDate(formObject.to_week.value, "yw") ) {
		  			ComShowMessage(msgs["EQR90056"]);
		  			formObject.to_week.value = "";
					ComSetFocus(formObject.to_week);
					return;
				}
				
				if( ComReplaceStr(formObject.to_week.value,"-","") != "" ) {
					if ( !fncCheckWeek() ) {
						formObject.to_week.value = "";
						ComSetFocus(formObject.to_week);
						return;
					}
				}
				break;
				
			case "loc_cd":
				if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
	     	        return false;
	     	    }
				break;
			
			case "fm_date":
				if( formObject.fm_date.value != "" ) {
					if( parseInt(formObject.fm_date.value) > 28) {
						ComShowCodeMessage('EQR90001', 'Between 1 and 28');
						formObject.fm_date.value = "";
						ComSetFocus(formObject.fm_date);
						return false;
					}
				}
				break;
			
			case "to_date":
				if( formObject.to_date.value != "" ) {
					if( parseInt(formObject.to_date.value) > 28) {
						ComShowCodeMessage('EQR90001', 'Between 1 and 28');
						formObject.to_date.value = "";
						ComSetFocus(formObject.to_date);
						return false;
					}
				}
				break;
		}
	}
    
    /**
	* Period to  beforedeactivate 이벤트 처리
	* Period to  beforedeactivate YYYY-MM 포멧 처리
	*/	
	function obj_deactivate() {
		ComClearSeparator(event.srcElement);
		obj = event.srcElement;
		if (obj.name == "fm_week") {
			var fm_week = document.form.fm_week.value.substr(0,4)+"-"+document.form.fm_week.value.substr(4,6);
			if ( fm_week == '-' )  {
				document.form.fm_week.value = "";
			} else {
				document.form.fm_week.value = fm_week;
			}
		} else if (obj.name == "to_week") {
			var to_week = document.form.to_week.value.substr(0,4)+"-"+document.form.to_week.value.substr(4,6);
			if ( to_week == '-' )  {
				document.form.to_week.value = "";
			} else {
				document.form.to_week.value = to_week;
			}
		}
	}
     
    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
        
        if(document.form.popMode.value == "Y") {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var shtID = sheetObj.id;

        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
            		
                    // 높이 설정
                    style.height = 460;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle0 = "OP Week|Create\nDate|OP LOC\n(SCC)|RLANE|VVD|Sales\nOffice|POL\n(ECC)|ETB|Sales\nF’cast(Teu)|Convert Box|Convert Box|Convert Box|Convert Box|Convert Box|Turn\nTime|Portion By Size|Portion By Size|Portion By Size|Portion By Size|";
                    var HeadTitle1 = "OP Week|Create\nDate|OP LOC\n(SCC)|RLANE|VVD|Sales\nOffice|POL\n(ECC)|ETB|Sales\nF’cast(Teu)|Total Box|D2|D4|D5|D7|Turn\nTime|D2|D4|D5|D7|";
                    
					headCount = ComCountHeadTitle(HeadTitle1);
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    CountPosition = 0;  //페이지카운트 없애기
                    
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
                    
					HeadRowHeight = 20;
					
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,		true,	"week",					false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,		true,	"bse_dt",					false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		50,	daCenter,		true,	"cntr_pkup_scc_cd",	false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		45,	daCenter,		true,	"rlane_cd",				false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		80,	daCenter,		true,	"vvd",						false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		45,	daCenter,		true,	"sls_ofc_cd",				false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		45,	daCenter,		true,	"pol_ecc_cd",			false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		95,	daCenter,		true,	"pol_etb_dt",			false,	"",	dfUserFormat2);
					InitDataProperty(0,	cnt++,	dtData,		70,	daRight,		true,	"fcast_ttl_qty",			false,	"",	dfNullInteger);
					InitDataProperty(0,	cnt++,	dtData,		60,	daRight,		false,	"total_qty",				false,	"",	dfNullInteger);
					InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		false,	"d2_qty",					false,	"",	dfNullInteger);
					InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		false,	"d4_qty",					false,	"",	dfNullInteger);
					InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		false,	"d5_qty",					false,	"",	dfNullInteger);
					InitDataProperty(0,	cnt++,	dtData,		40,	daRight,		false,	"d7_qty",					false,	"",	dfNullInteger);
					InitDataProperty(0,	cnt++,	dtData,		60,	daRight,		true,	"avg_tt_dys",			false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		50,	daRight,		false,	"d2_fcast_rto",			false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		50,	daRight,		false,	"d4_fcast_rto",			false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		50,	daRight,		false,	"d5_fcast_rto",			false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		50,	daRight,		false,	"d7_fcast_rto",			false,	"",	dfNone);
					InitDataProperty(0,	cnt++,	dtData,		0,		daRight,		false,	"tmp",						false,	"",	dfNone);
                    
					InitUserFormat2(0, "pol_etb_dt", "####-##-## ##:##", "-|:" );
               }
               break;
        }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        
	        case IBSEARCH:      //조회
	        	if(!validateForm(sheetObj,formObj,sAction)) return;
	        	
	        	sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true); 
	            formObj.f_cmd.value = SEARCH;
	            
	            if(formObj.create_chk_box.checked) {
	            	formObj.create_chk_box.value = "Y";
	            } else {
	            	formObj.create_chk_box.value = "N";
	            }
	            
	            var sXml = sheetObj.GetSearchXml("EES_EQR_1004GS.do",FormQueryString(formObj));
	            sheetObj.LoadSearchXml(sXml);
	            
	            ComOpenWait(false);
	            break;
	            
			case IBSEARCH02: //location focusOut
				formObj.inquiryLevel.value = formObj.loc_grp_cd.value;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_EQR_1004GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						if (document.form.loc_grp_cd.value == "E") {
							ComShowCodeMessage("EQR01006");
						}else if (document.form.loc_grp_cd.value == "S") {
							ComShowCodeMessage("EQR01007");
						}else if (document.form.loc_grp_cd.value == "L") {
							ComShowCodeMessage("EQR01005");
						}
						
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.fm_week);
				}
				
				break;
				
			case IBDOWNEXCEL:      // 입력
				sheetObj.Down2Excel(-1, false, false, true);
				
				break;
		}
	}
	
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
    function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
    }
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
			
			if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
	 		   return false;
			} else {
				// required validation check
				if (!ComChkValid(formObj)) return false;
			}
			
			// Creation Date
			if(formObj.create_chk_box.checked) {
				if(formObj.fm_date.value == '') {
	    			ComShowCodeMessage('EQR90001', 'Creation Date From');
	    			ComSetFocus(formObj.fm_date);
					return false;
				} else if(formObj.to_date.value == '') {
					ComShowCodeMessage('EQR90001', 'Creation Date To');
					ComSetFocus(formObj.to_date);
					return false;
				}
				
				if( parseInt(formObj.fm_date.value) > parseInt(formObj.to_date.value) ) {
					ComShowCodeMessage('EQR90080');		// To Date must be greater than From Date.
					ComSetFocus(formObj.to_date);
					return false;
				}
			}
			
			return true;
    }
    
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
	function sheet1_OnSearchEnd(sheetObj, msg) {
		
		// First Row total
		sheetObj.CellAlign(2, "week") = daCenter;
		sheetObj.SetMergeCell(2, 0, 1, 9);
		
		for(var i=2; i<=sheetObj.LastRow; i++) {
			for ( var j=0; j<headCount; j++ ) {
				if(sheetObj.CellValue(i, "week").length != 6 ) {
					// week total
					sheetObj.CellAlign(i, "week") = daCenter;
					sheetObj.SetMergeCell(i, 0, 1, 9);
				} else {
					// Turn Time
					if( j == 14 ) {
						sheetObj.CellValue(i,j) = sheetObj.CellValue(i,j) + " day";
					}
					// PORTION BY SIZE
					if( j > 14 && j <= 18) {
						sheetObj.CellValue(i,j) = sheetObj.CellValue(i,j) + "%";
					}
				}
			}
		}
	}
	
	function creatioin_date() {
		var formObject = document.form;
		
		if(formObject.create_chk_box.checked) {
			document.getElementById("fm_date").className = "input1";
			document.getElementById("to_date").className = "input1";
			
			ComEnableObject(formObject.fm_date,	true);
			ComEnableObject(formObject.to_date,		true);
			
			ComSetFocus(formObject.fm_date);
		} else {
			formObject.fm_date.value = "";
			formObject.to_date.value = "";
			document.getElementById("fm_date").className = "input2";
			document.getElementById("to_date").className = "input2";
			
			ComEnableObject(formObject.fm_date,	false);
			ComEnableObject(formObject.to_date,		false);
			
		}
	}