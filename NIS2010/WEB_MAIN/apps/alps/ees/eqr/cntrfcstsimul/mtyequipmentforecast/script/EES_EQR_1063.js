/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1063.jsp
*@FileTitle :SALES FORECAST HISTORY
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2014. 11. 30 전지예
* 1.0 Creation
=========================================================*/
	/**
	 * @extends 
	 * @class EES_EQR_1063 : EES_EQR_1063 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_EQR_1063() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setTabObject 			= setTabObject;
    	this.sheet1_OnPopupClick = sheet1_OnPopupClick;	
    	
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
    }
	// 공통전역변수
	
	var headCount = 0;
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var tpszArr = new Array();
	
	var comboObjects = new Array();
	var comboCnt = 0 ;
	
	var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
	var tpszdryCode = "D2|D4|D5|D7";
	var consTpszArr   = tpszdryCode.split('|');
	
	var HeadTitleCnt =0;
	
	var IBSEARCH01  = 29;
	var IBSEARCH02  = 30;
	
	var timer = null;
	
	var sheetNum = null;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var shtCnt = 0;
		var sheetObject1 = sheetObjects[shtCnt++];
		
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
				case "btn_new":
					tpszChange('D');
					formObject.reset();
					sheetObject1.RemoveAll();
					break;
					
				case "btn_downexcel":
	                ComOpenWait(true);
	                sheetObjects[0].Down2Excel(-1,false,false,true,"","",false,false,"",false,"");
	                ComOpenWait(false);
					break;
					
				case "btn_loc_cd":	//Location By 조회 팝업
	    	        var cnt_cd = "";
	    	        var loc_cd = "";
		            cnt_cd = formObject.loc_tp_cd.value;
		            loc_cd = formObject.loc_cd.value;
		            if ( formObject.loc_tp_cd.value != '' ) {	
	        			var loc_code = "";
	                    
	        			if ( formObject.loc_tp_cd.value == "" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( formObject.loc_tp_cd.value == "R" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( formObject.loc_tp_cd.value == "L" ) {
	        				loc_code = "lcc_cd";
	        			} else if ( formObject.loc_tp_cd.value == "S" ) {
	        				loc_code = "lcc_cd";
	        			} else if ( formObject.loc_tp_cd.value == "E" ) {
	        				loc_code = "ecc_cd";
	        			}
						var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 440, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		            }
					break;
					
				case "btn_loc_cd_second":	//Location Second 조회 팝업
	    	        var cnt_cd = "";
	    	        var loc_cd = "";
		            cnt_cd = formObject.loc_tp_cd_second.value;
		            loc_cd = formObject.loc_cd_second.value;
		            if ( formObject.loc_tp_cd_second.value != '' ) {
	        			var loc_code = "";
	                    
	        			if ( formObject.loc_tp_cd_second.value == "" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( formObject.loc_tp_cd_second.value == "R" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( formObject.loc_tp_cd_second.value == "L" ) {
	        				loc_code = "lcc_cd";
	        			} else if ( formObject.loc_tp_cd_second.value == "E" ) {
	        				loc_code = "ecc_cd";
	        			}
						var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 440, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		            }
					break;
					
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * 초기 이벤트 등록 
	 */
	function initControl() {
    	axon_event.addListener('change', 'loc_tp_cd_onchange', 'loc_tp_cd');		            //Location by 변경시 이벤트 처리
    	axon_event.addListener('change', 'loc_tp_cd_second_onchange', 'loc_tp_cd_second');		//Location 변경시 이벤트 처리    	
    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');				//LOC_CD keyup 이벤트 처리
    	axon_event.addListener('keyup', 'loc_cd_second_onkeyUp', 'loc_cd_second');	//LOC_CD_SECOND keyup 이벤트 처리    	
    	axon_event.addListener('keyup', 'fm_week_onkeyUp', 'fm_week');				//fm_week keyup 이벤트 처리
    	axon_event.addListener('keyup', 'to_week_onkeyUp', 'to_week');				//to_week keyup 이벤트 처리
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 		//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 	//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerForm('blur', 'obj_blur', form); 						//form obj_blur이벤트에 코드 처리
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);			//알파벳 대문자,숫자만 입력허용
    	
    	// 두번째 radio 비사용화
		ComEnableObject(document.form.loc_cd_second,  false);
		
		// type size 수정금지
    	document.form.tpsztype.disabled = true;
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
    
    /**
     * 설  명 : IBCombo Object를 배열로 등록 <br>
     *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     *          배열은 소스 상단에 정의<br>
     * <br><b>Example : </b>
     * <pre>
     *     setComboObject(combo_obj)
     * </pre>
     * @param {object}  combo_obj - Combo Object
     * @see #링크연결
     * @author 작성자
     * @version 
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
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
     * LOC_CD_SECOND keyup 이벤트 처리
     * LOC_CD_SECOND keyup시 대분자로 처리
     */
    function loc_cd_second_onkeyUp() {
        var formObject = document.form;
        if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
    	   document.getElementById("loc_cd_second").setAttribute("maxLength",5);
    	   if ( formObject.loc_cd_second.value.length == 5 ) {
    		   ComSetFocus(document.form.fm_week);
    	   }
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
				if( ComReplaceStr(formObject.to_week.value,"-","") != "") {
					if ( !fncCheckWeek() ) {
						formObject.to_week.value = "";
						ComSetFocus(formObject.to_week);
						return;
					}
				}
				break;
				
			case "loc_cd":
				if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH01) ) {	//Location By 유효성체크
	     	        return false;
	     	    }
				break;
				
			case "loc_cd_second":
				if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
	     	        return false;
	     	    }
				break;
		}
	}
    
    /**
     * keypress 이벤트 처리
     * keypress시 대분자로 처리
     */
    function obj_keypress() {
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
				break;
			case "loc_cd_second":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
				break;
			case "fm_week":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "to_week":
				ComKeyOnlyNumber(event.srcElement);
				break;
		}
	}
    
    /**
     * Period FM  beforeactivate 이벤트 처리
     * Period FM  beforeactivate -없애기
     */    
 	function obj_activate() {
 		ComClearSeparator(event.srcElement);
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
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
    function loc_tp_cd_onchange() {
    	var formObject = document.form;
      ComSetFocus(document.form.loc_cd);
    }
    
    /**
     * Location  변경시 이벤트 처리
     * 나머지 활성화
     */
    function loc_tp_cd_second_onchange() {
    	var formObject = document.form;
      ComSetFocus(document.form.loc_cd_second);  
    }
    
    /**
     * Week 체크 이벤트 처리
     * 최대 1~53주까지인지 확인
     * 범위 : 시작주~시작주+12
     */
    function fncCheckWeek() {
    	var formObj = document.form;
		if(formObj.fm_week.value != "" && formObj.to_week.value != "") {
			if(formObj.fm_week.value.trimAll("-") > formObj.to_week.value.trimAll("-")) {
				ComShowMessage(ComGetMsg("EQR90070","FM"));
				formObj.fm_week.focus();
				return false;
			}
			var input1=ComReplaceStr(formObj.fm_week.value,"-","");
			var input2=ComReplaceStr(formObj.to_week.value,"-","");

			var date1 = new Date(input1.substr(0,4),input1.substr(4,2)-1);
			var date2 = new Date(input2.substr(0,4),input2.substr(4,2)-1);
			var interval = date2 - date1;
			var day = 1000*60*60*24;
			var month = day*30;
			var year = month*12;
			var fromTo = 52;  // 52주간격을 의미함(01-53)

			var fm_week_yyyy = input1.substr(0,4);
			var fm_week_mm = input1.substr(4,2);

			var to_week_yyyy = input2.substr(0,4);
			var to_week_mm = input2.substr(4,2);

			if ( fm_week_yyyy == to_week_yyyy ) {
				month = eval(to_week_mm) - eval(fm_week_mm) + 1;
			} else {
				betwMonth = fromTo - eval(fm_week_mm) + eval(to_week_mm) + 1;
				if ( (eval(to_week_yyyy) - eval(fm_week_yyyy) ) == 1 ) {	 //1년 차이일때
					month = betwMonth;
				} else {	//ex:2009-08 ~ 2011-19
					month = (eval(to_week_yyyy) - eval(fm_week_yyyy) -1 ) * fromTo + betwMonth;
				}
			}
			if ( month > 12 ) {
				ComShowMessage(msgs["EQR70007"]);	//메세지 추가요
				return false;
			}
			return true;
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
    
 	/**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(p=0;p< comboObjects.length;p++){
 			initCombo (comboObjects[p],p+1);
 		}

         tpszChange('D');
         initControl();
         ComSetFocus(document.form.loc_cd);
     }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var shtID = sheetObj.id;
		
		if(( comboObjects[0].Text == null || comboObjects[0].Text == "")) {
			tpszArr = tpszallText.split("|");
		} else {
			tpszArr = (comboObjects[0].Text).split(",");
		}

		switch(shtID) {
			case "sheet1":      // By Week
				with (sheetObj) {
					// 높이 설정
					style.height = 460;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 20, 100);
                    
                    var HeadTitle0 = "";
                    var HeadTitle1 = "";
                    
					if(document.form.div_flag[0].checked == true) {
    					if(document.form.loc_tp_cd.value == "R"){        // RCC(by LCC )
    						HeadTitle0 = "OP LOC\n(LCC)";
    						HeadTitle1 = "OP LOC\n(LCC)";
 	   					}else if(document.form.loc_tp_cd.value == "L"){	 // LCC(by ECC )
 	   						HeadTitle0 = "OP LOC\n(ECC)";
 	   						HeadTitle1 = "OP LOC\n(ECC)";
 	   					}else{   										 // ECC(by SCC), LCC(by SCC)
 	   						HeadTitle0 = "OP LOC\n(SCC)";
 	   						HeadTitle1 = "OP LOC\n(SCC)";
 	   					}
                    }else { // radio 버튼 2번째 클릭
                    	if(document.form.loc_tp_cd_second.value == "L"){        // LCC
                    		HeadTitle0 = "OP LOC\n(LCC)";
                    		HeadTitle1 = "OP LOC\n(LCC)";
                    	}else if(document.form.loc_tp_cd_second.value == "E"){  // ECC
                    		HeadTitle0 = "OP LOC\n(ECC)";
                    		HeadTitle1 = "OP LOC\n(ECC)";
                    	}else{                                           // SCC
                    		HeadTitle0 = "OP LOC\n(SCC)";
                    		HeadTitle1 = "OP LOC\n(SCC)";
                    	}     
    				}
                    
					HeadTitle0 += "|OP Week" + "|Sales F'cast (Converted)|Sales F'cast (Converted)|Sales F'cast (Converted)|Sales F'cast (Converted)|Sales F'cast (Converted)";
					HeadTitle1 += "|OP Week" + "|Total Box|" + tpszdryText;
					
					HeadTitle0 += "|OP Forecast|OP Forecast|OP Forecast|OP Forecast|OP Forecast";
					HeadTitle1 += "|Total Box|" + tpszdryText;
					
					HeadTitle0 += "|DIFF(Sales F’cast-OP F’cast)/Sales F’cast|DIFF(Sales F’cast-OP F’cast)/Sales F’cast|DIFF(Sales F’cast-OP F’cast)/Sales F’cast|DIFF(Sales F’cast-OP F’cast)/Sales F’cast|DIFF(Sales F’cast-OP F’cast)/Sales F’cast";
					HeadTitle1 += "|Total Box|" + tpszdryText;
					
					HeadTitle0 += "|OP Perfomance|OP Perfomance|OP Perfomance|OP Perfomance|OP Perfomance";
					HeadTitle1 += "|Total Box|" + tpszdryText;
					
					HeadTitle0 += "|DIFF(Sales F’cast-OP PERF)/Sales F’cast|DIFF(Sales F’cast-OP PERF)/Sales F’cast|DIFF(Sales F’cast-OP PERF)/Sales F’cast|DIFF(Sales F’cast-OP PERF)/Sales F’cast|DIFF(Sales F’cast-OP PERF)/Sales F’cast";
					HeadTitle1 += "|Total Box|" + tpszdryText + "|";
					
					headCount = ComCountHeadTitle(HeadTitle1);
					HeadTitleCnt = headCount;
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 2, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
					
					HeadRowHeight = 20;
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                   
					InitDataProperty(0, cnt++, dtData, 60, daCenter, true,		"loc_cd",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 60, daCenter,	true,	"week",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 60, daRight,	false,	"total",			false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"d2_fcast_qty",		false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"d4_fcast_qty",		false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"d5_fcast_qty",		false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"d7_fcast_qty",		false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 60, daRight,	false,	"fcst_total",					false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"fcst_d2_fcast_qty",		false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"fcst_d4_fcast_qty",		false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"fcst_d5_fcast_qty",		false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"fcst_d7_fcast_qty",		false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 60, daRight,	false,	"df1_total",	false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daRight,	false,	"df1_d2",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daRight,	false,	"df1_d4",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daRight,	false,	"df1_d5",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daRight,	false,	"df1_d7",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 60, daRight,	false,	"pfmc_total",				false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"pfmc_d2_fcast_qty",	false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"pfmc_d4_fcast_qty",	false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"pfmc_d5_fcast_qty",	false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 40, daRight,	false,	"pfmc_d7_fcast_qty",	false,	"", dfInteger,     0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 60, daRight,	false,	"df2_total",	false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daRight,	false,	"df2_d2",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daRight,	false,	"df2_d4",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daRight,	false,	"df2_d5",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daRight,	false,	"df2_d7",		false,	"", dfNone);
					InitDataProperty(0, cnt++, dtData, 0, 	daRight,	false,	"tmp",			false,	"", dfNone);
					
					SetSortDialog(false);
					CountPosition = 0;
					ExtendLastCol = false;
					
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
    			sheetObj.redrew = false;
    			
    			formObj.f_cmd.value = SEARCH;
    			var sXml = sheetObj.GetSearchXml("EES_EQR_1063GS.do",FormQueryString(formObj));
    			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
    			
    			if (backendJobKey.length > 0) {
					formObj.backendjob_key.value = backendJobKey;
					sheetObj.RequestTimeOut = 10000;
					timer = setInterval(getBackEndJobStatus, 3000);
					sheetNum = sheetObj;
				}    
                break;
                
			case IBSEARCH01: //location by focusOut
				var inquiryLevel = "";
				if ( formObj.loc_tp_cd.value == 'E' ) {
					inquiryLevel = "E";
				} else if ( formObj.loc_tp_cd.value == 'L' ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_tp_cd.value == 'R' ) {
					inquiryLevel = "R";
				} else if  ( formObj.loc_tp_cd.value == 'S' ) {
					inquiryLevel = "L";
				}
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH01;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_EQR_1063GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						if ( formObj.loc_tp_cd.value == 'E' ) {
							ComShowCodeMessage("EQR90203");
						} else if ( formObj.loc_tp_cd.value == 'L' ) {
							ComShowCodeMessage("EQR90202");
						} else if  ( formObj.loc_tp_cd.value == 'R' ) {
							ComShowCodeMessage("EQR90201");
						} else if  ( formObj.loc_tp_cd.value == 'S' ) { // LCC 단위검색
							ComShowCodeMessage("EQR90202");
						}
						
						formObj.loc_cd.value = "";
						ComSetFocus(formObj.loc_cd);
						return false;
					} else {
						return true;
					}
				} else {
					ComSetFocus(document.form.fm_week);
				}
				
				break;
				
			case IBSEARCH02: //location focusOut

				var inquiryLevel = "";
				if ( formObj.loc_tp_cd_second.value == 'E' ) {
					inquiryLevel = "E";
				} else if ( formObj.loc_tp_cd_second.value == 'L' ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_tp_cd_second.value == 'S' ) {
					inquiryLevel = "S";
				}
				
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd_second.value;
				
				formObj.f_cmd.value = SEARCH01;
				if (formObj.loc_cd_second.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_EQR_1063GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				
				if (sCheck != "OK") {
					if (formObj.loc_cd_second.value != "") {
						if ( formObj.loc_tp_cd_second.value == 'E' ) {
							ComShowCodeMessage("EQR90203");
						} else if ( formObj.loc_tp_cd_second.value == 'L' ) {
							ComShowCodeMessage("EQR90202");
						} else if  ( formObj.loc_tp_cd_second.value == 'S' ) { // LCC 단위검색
							ComShowCodeMessage("EQR90204");
						}
						
						formObj.loc_cd_second.value = "";
						ComSetFocus(formObj.loc_cd_second);
						return false;
					} else {
						return true;
					}
				} else {
					ComSetFocus(document.form.fm_week);
				}
			
			break;
        }
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj) {
        	
        	if(document.form.div_flag[0].checked == true) {
        		if(formObj.loc_cd.value == "") {
        			ComShowCodeMessage("EQR90001", "Location By Value");
        			ComSetFocus(formObj.loc_cd);
        			return false;
        		}
        		
    			if ( doActionIBSheet(sheetObjects[0], formObj, IBSEARCH01) ) {	//Location By 유효성체크
    				ComSetFocus(formObj.loc_cd);
         	        return false;
        	  	} else {
        	  		if (!ComChkValid(formObj)) return false;
        	  		if (!fncCheckWeek()) return false;
        	  	}
        	}
        	
        	if(document.form.div_flag[1].checked == true) {
        		if(formObj.loc_cd_second.value == "") {
        			ComShowCodeMessage("EQR90001", "Location Value");
        			ComSetFocus(formObj.loc_cd_second);
        			return false;
        		}
        		
    			if ( doActionIBSheet(sheetObjects[0], formObj, IBSEARCH02) ) {	//Location 유효성체크
    				ComSetFocus(formObj.loc_cd_second);
         	        return false;
        	  	} else {
        	  		if (!ComChkValid(formObj)) return false;
        	  		if (!fncCheckWeek()) return false;
        	  	}
        	}
        }

        return true;
    }
    
    /**
     * 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
    	fnHeaderChange();
    	
		for(var i=2; i<=sheetObj.LastRow; i++) {
			for ( var j=0; j<headCount; j++ ) {
				
				// DIFF(OP FCAST/SALES PROJ)
				if( j >= 12 && j <= 16 ) {
					sheetObj.CellValue(i,j) = sheetObj.CellValue(i,j) + "%";
				}
				// DIFF(OP PERF/SALESPROJ)
				if( j >= 22 && j <= 26 ) {
					sheetObj.CellValue(i,j) = sheetObj.CellValue(i,j) + "%";
				}
			}
		}
    }
    
 	/**
 	 * 설  명 :  Combo 기본 설정 <br>
 	 * <br><b>Example : </b>
 	 * <pre>
 	 *     initCombo(comboObj,comboNo)
 	 * </pre>
 	 * @param {object}	comboObj - Combo Object
 	 * @param {Number}	comboNo  - Combo Number
 	 * @see #링크연결
 	 * @author 작성자
 	 * @version 2009.01.01
 	 */
 	function initCombo (comboObj, comboNo) {
 		var cnt  = 0 ;
 		
 		switch(comboNo) {		
 			// Type Size
 			case 1:
 				with (comboObj) {				
 					DropHeight = 12 * 20;
 					
 					var menuname = tpszdryText.split('|'); 
 					var menucode = tpszdryCode.split('|'); 
 					
 					MultiSelect = true;
 					MaxSelect = menuname.length;
 					MultiSeparator = ",";
 					
 					for(i=0; i<menuname.length; i++) {
 						InsertItem(cnt++, menuname[i], menucode[i]);                      		
 					} 
 				}
 				break;
 		}
 	}
    
 	/**
 	 * 설  명 : TP/SZ 종류 변경시 코드 설정 <br>
 	 * <br><b>Example : </b>
 	 * <pre>
 	 *     tpszChange('')
 	 * </pre>
 	 * @param {String}	key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
 	 * @see #링크연결
 	 * @author 작성자
 	 * @version 2009.01.01
 	 */
 	function tpszChange(key){
		comboObjects[0].Code = consTpszDry;
 	}
	
 	function tpsztype_OnChange() {
 		setGridHidden(form.tpsztype.Text);
 	}
 	
	/*
	 * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
	 * OnloadPage,OnSearchEnd event에서 호출
	 * @param {String} tpsz_cd
	 * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
	 */
	function setGridHidden(tpsz_cd){
	    var sheetObj = sheetObjects[0];
	    var arr_tpsz = tpsz_cd.split(",");
	    
	    for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size
	        for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
	            if(consTpszArr[i] == arr_tpsz[j]){
	                sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_fcast_qty")= false;
		            sheetObj.ColHidden("fcst_"+consTpszArr[i].toLowerCase()+"_fcast_qty")= false;
		            sheetObj.ColHidden("df1_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("pfmc_"+consTpszArr[i].toLowerCase()+"_fcast_qty")= false;
		            sheetObj.ColHidden("df2_"+consTpszArr[i].toLowerCase())= false;
					break;
	            }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
	            	sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_fcast_qty")= true;
		            sheetObj.ColHidden("fcst_"+consTpszArr[i].toLowerCase()+"_fcast_qty")= true;
		            sheetObj.ColHidden("df1_"+consTpszArr[i].toLowerCase())= true;
		            sheetObj.ColHidden("pfmc_"+consTpszArr[i].toLowerCase()+"_fcast_qty")= true;
		            sheetObj.ColHidden("df2_"+consTpszArr[i].toLowerCase())= true;
				}
			}
	    }
	}
 	
	/**
	 * 라디오 버튼 선택에 따른 활성&비활성 관리
	 */
	function ChangeInputStatus(radio_num) {
		var formObj = document.form;
		
		if(radio_num == 1) {
			ComEnableObject(formObj.loc_cd,				true);
			ComEnableObject(formObj.loc_cd_second,	false);
			
			formObj.loc_cd_second.value="";
			document.getElementById("loc_cd").className = "input1";
			document.getElementById("loc_cd").focus();
			
		} else {  // 두번째 라디오 선택(Location)
			ComEnableObject(formObj.loc_cd,				false);
			ComEnableObject(formObj.loc_cd_second,	true);
			
			formObj.loc_cd.value="";
			document.getElementById("loc_cd_second").className = "input1";
			document.getElementById("loc_cd_second").focus();
		}
		
	}
	
	function fnHeaderChange() {
		if(document.form.div_flag[0].checked == true) {
			if(document.form.loc_tp_cd.value == "R"){        // RCC(by LCC )
				HeadTitle0 = "OP LOC\n(LCC)";
				HeadTitle1 = "OP LOC\n(LCC)";
				}else if(document.form.loc_tp_cd.value == "L"){	 // LCC(by ECC )
					HeadTitle0 = "OP LOC\n(ECC)";
					HeadTitle1 = "OP LOC\n(ECC)";
				}else{   										 // ECC(by SCC), LCC(by SCC)
					HeadTitle0 = "OP LOC\n(SCC)";
					HeadTitle1 = "OP LOC\n(SCC)";
				}
        }else { // radio 버튼 2번째 클릭
        	if(document.form.loc_tp_cd_second.value == "L"){        // LCC
        		HeadTitle0 = "OP LOC\n(LCC)";
        		HeadTitle1 = "OP LOC\n(LCC)";
        	}else if(document.form.loc_tp_cd_second.value == "E"){  // ECC
        		HeadTitle0 = "OP LOC\n(ECC)";
        		HeadTitle1 = "OP LOC\n(ECC)";
        	}else{                                           // SCC
        		HeadTitle0 = "OP LOC\n(SCC)";
        		HeadTitle1 = "OP LOC\n(SCC)";
        	}
		}
		
		sheetObjects[0].CellValue2(0,0) = HeadTitle0;
		sheetObjects[0].CellValue2(1,0) = HeadTitle1;
	}
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetNum.GetSearchXml("EES_EQR_1063GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer);
		} else if (jobState == "4") {
			ComShowCodeMessage("EQR90233");
			ComOpenWait(false);
			sheetNum.WaitImageVisible = true;
			clearInterval(timer);
		} else if (jobState == "5") {
			ComShowCodeMessage("EQR90234");
			clearInterval(timer);
		}
	}
	 
	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		
		formObj.f_cmd.value = SEARCH03;
		ComOpenWait(false);
		var sXml = sheetNum.GetSearchXml("EES_EQR_1063GS.do", FormQueryString(form));
		sheetNum.LoadSearchXml(sXml);
	}