/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0001.js
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.04.30 김종준
* 1.0 Creation
 * ======================================================
 * 2011.03.16 남궁진호 [CHM-201109288-01]Location Code 숫자입력가능하게수정
 *                    ComKeyOnlyAlphabet('upper') ->ComKeyOnlyAlphabet('uppernum')
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cim_0001 : ees_cim_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cim_0001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
   
    var tot_cntr_tpsz_cd ="";
    var comboObjects = new Array();
    var comboCnt = 0 ;
    var HeadTitleCnt =0;
    var headCnt = 0;
   
    var IBSEARCH01  = 29;
    var IBSEARCH02  = 30;
    var IBSEARCH03  = 31;
    var IBSEARCH04  = 32;
    var IBSEARCH05  = 33;
    var IBSEARCH06  = 34;
   


   	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
   	document.onclick = processButtonClick;

   	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
   	function processButtonClick(){
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	        
	    var sheetObject1 = sheetObjects[0];
	    var sheetObject2 = sheetObjects[1];
	
	    
	    /*******************************************************/
	    var formObject = document.form;
	
		try {
	   		var srcName = window.event.srcElement.getAttribute("name");
	
            switch(srcName) {

			case "btn_new":		//조회조건 초기화
				sheetObjects[0].WaitImageVisible = false;
				sheetObjects[1].WaitImageVisible = false;
				formObject.loc_type_code.value="";
				formObject.op_trnd_tp_cd.value="IM"; 
				sheetObjects[0].Redraw = false;
				sheetObjects[0].RemoveAll();
				sheetObjects[0].Redraw = true;
				sheetObjects[1].Redraw = false;
				sheetObjects[1].RemoveAll();
				sheetObjects[1].Redraw = true; 

			    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH03);
			    loc_type_code_onchange();
			    comboObjects[0].Code = "";
			    
    			var HeadTitle = "RCC|TP/SZ|Division|Average|YYYY-M1|YYYY-M2|YYYY-M3";
    			HeadTitleCnt = HeadTitle.split("|").length;
    			for ( var i=0; i<headCnt; i++ ) {
    				if ( HeadTitleCnt <= i ) {
    					sheetObjects[0].ColHidden(i) = true;
    				} else {
    					sheetObjects[0].ColHidden(i) = false;
    				}
    			}
    			
    			for ( var i=0; i<HeadTitleCnt; i++ ) {
    				sheetObjects[0].CellValue2(0,i) = HeadTitle.split("|")[i];	 
    			}
    			
    			sheetObjects[0].SheetWidth = 580;
			    tabObjects[0].SelectedIndex = 0;

				break;
			case "btn_loc_cd":	//Location 조회 팝업
    	        var cnt_cd = "";
    	        var loc_cd = "";
	            cnt_cd = formObject.loc_type_code.value;
	            loc_cd = formObject.loc_cd.value;
	            if ( formObject.loc_type_code.value != '' ) {	
					if ( formObject.loc_type_code.value == '5' ) {	//Country
						var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopup("/hanjin/COM_ENS_0M1.do",565, 470, "popupFinish", "1,0,1,1,1,1,1,1", true);
	           		} else {
	        			var loc_code = "";
	                    
	        			if ( form.loc_type_code.value == "" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( form.loc_type_code.value == "1" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( form.loc_type_code.value == "2" ) {
	        				loc_code = "lcc_cd";
	        			} else if ( form.loc_type_code.value == "3" ) {
	        				loc_code = "lcc_cd";
	        			} else if ( form.loc_type_code.value == "4" ) {
	        				loc_code = "ecc_cd";
	        			} else if ( form.loc_type_code.value == "6" ) {
	        				loc_code = "scc_cd";
	        			} else if ( form.loc_type_code.value == "7" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( form.loc_type_code.value == "8" ) {
	        				loc_code = "rcc_cd";
	        			}
						var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 455, loc_code+":loc_cd", "0,1,1,1,1,1", true);
	           		}
	            }
				break;
			case "btn_downexcel":	//DOWN EXCEL
				if ( beforetab == 0 ) {	  //첫번째탭에서 조회
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
					doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
				}
				break;
			case "btn_Retrieve":	//조회
				if ( beforetab == 0 ) {	  //첫번째 탭에서 조회
					sheetObjects[0].RemoveAll();
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
					sheetObjects[1].RemoveAll();
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
				}
				break;
			case "btn_match_back":	//Match Back 클릭시
	    		var location = document.form.loc_cd.value ;
	    		var period = "";
	    		if ( document.form.op_trnd_tp_cd.value == 'IM') {
	    			period = "M";
	    		} else {
	    			period = "W";
	    		}
	    		var inquiryLevel = "";
	    		if ( document.form.loc_type_code.value == '') {
	    			inquiryLevel = "AR";
	    		} else if ( document.form.loc_type_code.value == '1') {
	    			inquiryLevel = "RL";
	    		} else if ( document.form.loc_type_code.value == '2') {
	    			inquiryLevel = "LE";
	    		} else if ( document.form.loc_type_code.value == '3') {
	    			inquiryLevel = "LS";
	    		} else if ( document.form.loc_type_code.value == '4') {
	    			inquiryLevel = "ES";
	    		} else if ( document.form.loc_type_code.value == '5') {
	    			inquiryLevel = "AC";
	    		} else if ( document.form.loc_type_code.value == '6') {
	    			inquiryLevel = "SS";
	    		} else if ( document.form.loc_type_code.value == '7') {
	    			inquiryLevel = "RL";
	    		} else if ( document.form.loc_type_code.value == '8') {
	    			inquiryLevel = "RL";
	    		}
	    		var froms = document.form.from_bse_dt.value;
	    		var tos = document.form.to_bse_dt.value;
	    		var param = "?inquiryLevel="+inquiryLevel+"&locationBy="+location+"&period="+period+"&froms="+froms+"&tos="+tos;
	    		ComOpenPopupWithTarget('/hanjin/EES_CIM_1018.do'+ param, 1024, 680, "", "0,1,1,1,1,1,1", true);				
				break;
			case "btn_turn_time":	//Turn Time 클릭시
	    		var location = document.form.loc_cd.value ;
	    		var period = "";
	    		if ( document.form.op_trnd_tp_cd.value == 'IM') {
	    			period = "M";
	    		} else {
	    			period = "W";
	    		}
	    		var inquiryLevel = "";
	    		if ( document.form.loc_type_code.value == '') {
	    			inquiryLevel = "AR";
	    		} else if ( document.form.loc_type_code.value == '1') {
	    			inquiryLevel = "RL";
	    		} else if ( document.form.loc_type_code.value == '2') {
	    			inquiryLevel = "LE";
	    		} else if ( document.form.loc_type_code.value == '3') {
	    			inquiryLevel = "LS";
	    		} else if ( document.form.loc_type_code.value == '4') {
	    			inquiryLevel = "ES";
	    		} else if ( document.form.loc_type_code.value == '5') {
	    			inquiryLevel = "CC";
	    		} else if ( document.form.loc_type_code.value == '6') {
	    			inquiryLevel = "SS";
	    		} else if ( document.form.loc_type_code.value == '7') {
	    			inquiryLevel = "RL";
	    		} else if ( document.form.loc_type_code.value == '8') {
	    			inquiryLevel = "RL";
	    		}
	    		var froms = document.form.from_bse_dt.value;
	    		var tos = document.form.to_bse_dt.value;
	    		var param = "?inquiryLevel="+inquiryLevel+"&location="+location+"&period="+period+"&from="+froms+"&to="+tos+"&tpsz="+comboObjects[0].Code;
	    		ComOpenPopupWithTarget('/hanjin/EES_CIM_1016.do'+ param, 1024, 670, "", "0,1,1,1,1,1,1", true);				
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
     * Location by loc_cd 팝업에서 선택한 값 Setting.
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
       var sheetObject = sheetObjects[0];
       var formObject = document.form;
       formObject.loc_cd.value = aryPopupData[0][3] 
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
    * 초기 이벤트 등록 
    */
    function initControl() {
    	axon_event.addListener('change', 'op_trnd_tp_cd_onchange', 'op_trnd_tp_cd', '');		//Period 변경시 이벤트 처리
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');		//Location by 변경시 이벤트 처리
    	axon_event.addListener('click', 'long_stay_cd_click', 'long_stay_cd', '');				//LONG STAYING Full/MTY 클릭시
    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd', '');						//LOC_CD keyup 이벤트 처리
    	axon_event.addListener('keyup', 'from_bse_dt_onkeyUp', 'from_bse_dt');					//from_bse_dt keyup 이벤트 처리
    	axon_event.addListener('keyup', 'to_bse_dt_onkeyUp', 'to_bse_dt');						//to_bse_dt keyup 이벤트 처리
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');								//엔터키 조회 이벤트처리
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListener('blur', 'obj_blur', 'loc_cd');
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
    }

    /**
     * 키이벤트 목록
    */
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "from_bse_dt":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "to_bse_dt":
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
		ComAddSeparator(event.srcElement);
	}

	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH06);
	}
	
    /**
    * Period FM  keyup 이벤트 처리
    * Period FM  keyup YYYY-MM 포멧 처리
    */
    function from_bse_dt_onkeyUp() {
       var formObject = document.form;
       var from_bse_dt = formObject.from_bse_dt.value.replace(/\/|\-|\./g, "");
       if ( event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
		   if ( from_bse_dt.length == 6 ) {
			   ComAddSeparator(event.srcElement);
			   if ( !chkPeriod('from') ) {  
				   return;
			   } else {
		    	   formObject.to_bse_dt.focus();
		    	   return;
			   }
		   }
       }
    }  
    
    /**
    * Period TO  keyup 이벤트 처리
    * Period TO  keyup YYYY-MM 포멧 처리
    */
    function to_bse_dt_onkeyUp() {
    	var formObject = document.form;
    	var to_bse_dt = formObject.to_bse_dt.value.replace(/\/|\-|\./g, "");
    	if ( event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	    	if ( to_bse_dt.length == 6 ) {
	    		ComAddSeparator(event.srcElement);
	    		if ( !chkPeriod('to') ) {
	    			return;
	    		} else {
	    			formObject.cntr_tpsz_cd.focus();
	    			return;
	    		}
	    	}
        }
    }     

    /**
     * Period TO  keyup 이벤트 처리
     * Period TO  keyup 날짜 체크 처리
     */
    function chkPeriod(fromToFlag) {
    	var formObj = document.form;
    	var chkFlag = true;
    	if ( fromToFlag == 'from') {
		  	if ( formObj.op_trnd_tp_cd.value == 'IM' ) {  
		  		if ( !ComIsDate(formObj.from_bse_dt.value, "ym") ) {
		  			formObj.from_bse_dt.value = "";
		  			formObj.from_bse_dt.focus();
		  			chkFlag = false;
		  		}
		  	} else {
		  		if ( !ComIsDate(formObj.from_bse_dt.value, "yw") ) {
		  			formObj.from_bse_dt.value = "";
		  			formObj.from_bse_dt.focus();
		  			chkFlag = false;
		  		}
		  	}
    	} else {
    	  	if ( formObj.op_trnd_tp_cd.value == 'IM' ) {
    	  		if ( !ComIsDate(formObj.to_bse_dt.value, "ym") ) {
    	  			formObj.to_bse_dt.value = "";
    	  			formObj.to_bse_dt.focus();
    	  			chkFlag = false;
    	  		}
    	  	} else {
    	  		if ( !ComIsDate(formObj.to_bse_dt.value, "yw") ) {
    	  			formObj.to_bse_dt.value = "";
    	  			formObj.to_bse_dt.focus();
    	  			chkFlag = false;
    	  		}
    	  	} 
    	}
   	
	  	if(formObj.from_bse_dt.value != "" && formObj.to_bse_dt.value != "") {
	  		if(formObj.from_bse_dt.value.trimAll("-") > formObj.to_bse_dt.value.trimAll("-")) {
	  			ComShowMessage(ComGetMsg("CIM30020", "To", "FM", "greater"));
	  			formObj.to_bse_dt.value = "";
	  			formObj.to_bse_dt.focus();
	  			chkFlag = false;
	  		}
	  		var input1=ComReplaceStr(formObj.from_bse_dt.value,"-","");
	  		var input2=ComReplaceStr(formObj.to_bse_dt.value,"-","");

	  		var date1 = new Date(input1.substr(0,4),input1.substr(4,2)-1);
	  		var date2 = new Date(input2.substr(0,4),input2.substr(4,2)-1);
	  		var interval = date2 - date1;
	  		var day = 1000*60*60*24;
	  		var month = day*30;
	  		var year = month*12;
	  		var fromTo = 52;
	  		if ( formObj.op_trnd_tp_cd.value == 'IM' ) {
	  			month = parseInt(interval/month)+1;
	  			if ( month > 12 ) {
	  				ComShowMessage(msgs["CIM30001"]);
	  				formObj.to_bse_dt.value = "";
	  				formObj.to_bse_dt.focus();
		  			chkFlag = false;
	  			}
	  		} else if ( formObj.op_trnd_tp_cd.value == 'IW' ) {
	  			var from_bse_dt_yyyy = input1.substr(0,4);
	  			var from_bse_dt_mm = input1.substr(4,2);

	  			var to_bse_dt_yyyy = input2.substr(0,4);
	  			var to_bse_dt_mm = input2.substr(4,2);
    		   
	  			if ( from_bse_dt_yyyy == to_bse_dt_yyyy ) {
	  				month = eval(to_bse_dt_mm) - eval(from_bse_dt_mm) + 1;
	  			} else {
	  				betwMonth = fromTo - eval(from_bse_dt_mm) + eval(to_bse_dt_mm) + 1;
	  				if ( (eval(to_bse_dt_yyyy) - eval(from_bse_dt_yyyy) ) == 1 ) {	 //1년 차이일때
	  					month = betwMonth;
	  				} else {	//ex:2009-08 ~ 2011-19
	  					month = (eval(to_bse_dt_yyyy) - eval(from_bse_dt_yyyy) -1 ) * fromTo + betwMonth;
	  				}
	  			}
	  			if ( month > 12 ) {
	  				ComShowMessage(msgs["CIM30001"]);
	  				formObj.to_bse_dt.value = "";
	  				formObj.to_bse_dt.focus();
		  			chkFlag = false;
	  			}
	  		}
	  	}
	  	return chkFlag;
    }    
    
    /**
     * TP/SZ 클릭 이벤트 처리
    */
    function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    } 
    
    /**
    * LONG STAYING Full/MTY 클릭시 이벤트 처리
    * LONG STAYING Full/MTY ALL,FULL,MTY 조건별 조회.
    */ 
    function long_stay_cd_click() {
       if ( document.form.long_stay_cd[0].checked ) {
    	   curr_stay_cd_value = document.form.long_stay_cd[0].value;
       } else if ( document.form.long_stay_cd[1].checked ) {
    	   curr_stay_cd_value = document.form.long_stay_cd[1].value;
       } else if ( document.form.long_stay_cd[2].checked ) {
    	   curr_stay_cd_value = document.form.long_stay_cd[2].value;
       }
	   doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
    }
    /**
    * LOC_CD keyup 이벤트 처리
    * LOC_CD keyup시 대분자로 처리
    */
    function loc_cd_onkeyUp() {
       var formObject = document.form;
       if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	       if ( formObject.loc_type_code.value == '5' ) {
	    	   if ( formObject.loc_cd.value.length > 1) {
	    		   document.getElementById("loc_cd").setAttribute("maxLength",2);
	    		   formObject.loc_cd.value = formObject.loc_cd.value.substring(0,2).toUpperCase();
	        	   if ( formObject.loc_cd.value.length == 2 ) {
	        		   ComSetFocus(document.form.from_bse_dt);
	        	   }
	    	   }
	       } else {
	    	   document.getElementById("loc_cd").setAttribute("maxLength",5);
	    	   if ( formObject.loc_cd.value.length == 5 ) {
	    		   ComSetFocus(document.form.from_bse_dt);
	    	   }
	       }
       }
    }
    
    /**
    * Period 변경시 이벤트 처리
    * Period 입력란에는 조회일자가 속한 달의 이전 달부터 3개월의 기간을 Default로 보여줌. (예. 2009-03-02에 조회시, FM: 2008-12  TO: 2009-02)
    * 마찬가지로, Week(YYYY-WW)를 선택시, 조회일자가 속한 주차의 이전주차 부터 12주차의 기간이 Period 입력란에 제시됨.
    	(예. 2009-03-02(WK09)에 조회시, FM:2008-49  TO:2009-08)
    */
    function op_trnd_tp_cd_onchange() {
       form.f_cmd.value = SEARCH03;
       sheetObjects[0].WaitImageVisible = false;
       var sXml = sheetObjects[0].GetSearchXml("EES_CIM_0001GS.do" , FormQueryString(form)); 
    
       //콤보코드와 콤보텍스트 가져오기
       var fm_prd = ComGetEtcData(sXml,"fm_prd");
       var to_prd = ComGetEtcData(sXml,"to_prd");
       
       form.from_bse_dt.value = fm_prd.substr(0,4)+"-"+fm_prd.substr(4,6);
       form.to_bse_dt.value = to_prd.substr(0,4)+"-"+to_prd.substr(4,6);
       obj = event.srcElement;
       if (obj.name == "op_trnd_tp_cd") {
    	   if (obj.value == "IM") {
    		   document.getElementById("from_bse_dt").setAttribute("dataformat", "ym");
    		   document.getElementById("to_bse_dt").setAttribute("dataformat", "ym");
    	   } else {
    		   document.getElementById("from_bse_dt").setAttribute("dataformat", "yw");
    		   document.getElementById("to_bse_dt").setAttribute("dataformat", "yw");
    	   }
       }
       
    }
    
    /**
    * Location by 변경시 이벤트 처리
    * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
    * 나머지 활성화
    */
    function loc_type_code_onchange() {
       var formObject = document.form;
       if ( formObject.loc_type_code.value != '' ) {
    	   formObject.loc_cd.readOnly = false;
    	   formObject.loc_cd.className = "input";
       } else {
    	   formObject.loc_cd.readOnly = true;
    	   formObject.loc_cd.className = "input2";
    	   formObject.loc_cd.value = "";
       }
//       formObject.loc_cd.value = "";
       ComSetFocus(document.form.loc_cd);  
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
	    for(k=0;k<tabObjects.length;k++){
	       initTab(tabObjects[k],k+1);
	    }
	    for(p=0;p< comboObjects.length;p++){
	       initCombo (comboObjects[p],p+1);
	    }
	    initControl();
	    
	    document.getElementById("from_bse_dt").setAttribute("dataformat", "ym");
	    document.getElementById("to_bse_dt").setAttribute("dataformat", "ym");
	    
    }

    /**
     * sheet1 로딩 완료시 이벤트 후출
     * Period,HEAD,TPSZ 데이타 가져오기
    */
    function t1sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObj,document.form,IBSEARCH01); //Period,HEAD,TPSZ 데이타 가져오기
    }    
    /**
    * IBCombo Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initCombo (comboObj, comboNo) {
    	
    }
    
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle) {
       var cnt = 0;
 
       with (sheetObj) {
      
	       switch (sheetObj.id) {
	           case "t1sheet1":      //t1sheet1 init
	                   //Host정보 설정[필수][HostIp, Port, PagePath]
	                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    
	                   //전체Merge 종류 [선택, Default msNone]
	                   MergeSheet = msPrevColumnMerge;
	    
	                   //전체Edit 허용 여부 [선택, Default false]
	                   Editable = false;
	    
	                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                   InitRowInfo( 1, 3, 20, 100);
	                   
	                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                   InitHeadMode(false, true, true, true, false,false)
	                   CountPosition = 0;	//페이지카운트 없애기 
	
	                   if (headTitle==null || headTitle =="") {
	                	   headTitle = "RCC|TP/SZ|Division|Average|YYYY-M1|YYYY-M2|YYYY-M3|YYYY-M4|YYYY-M5|YYYY-M6|YYYY-M7|YYYY-M8|YYYY-M9|YYYY-M10|YYYY-M11|YYYY-M12"; 
	                       InitColumnInfo(7, 0, 0, true);
	                   }
	                   headCnt  = headTitle.split("|").length;
	                   SheetWidth = headCnt*80;
	                   if ( SheetWidth>975 ) {
	                	   SheetWidth = 975;
	                   }
	                   InitColumnInfo(headCnt, 0, 0, true);
	                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                   InitHeadRow(0, headTitle, true);
	                   sheetObj.FrozenCols = 4;
	    
	                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			   InitDataProperty(0, cnt++ , dtAutoSum,   75,    daCenterTop,	true,		"loc_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      80,    daCenterTop,	true,		"cntr_tpsz_cd",		false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	true,		"division",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,   	80,    daRight,		true,		"average",			false,           "",      dfNullInteger,	0,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 4 ; i++){
	    				   InitDataProperty(0, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfNullInteger,	0,     true,       true);
	    			   }
	    				
	    			   cnt = 0;
	    			   InitDataProperty(1, cnt++ , dtAutoSum,   75,    daCenterTop,	true,		"loc_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtData,      80,    daCenterTop,	true,		"cntr_tpsz_cd",		false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtData,      80,    daCenter,	true,		"division",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtData,   	80,    daRight,		true,		"average",			false,           "",      dfNullInteger,	0,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 4 ; i++){
	    				   InitDataProperty(1, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfNullInteger,	0,     true,       true);
	    			   }
	    			    
	    			   cnt = 0;
	    			   InitDataProperty(2, cnt++ , dtAutoSum,   75,    daCenterTop,	true,		"loc_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,      80,    daCenterTop,	true,		"cntr_tpsz_cd",		false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,      80,    daCenter,	true,		"division",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,   	80,    daRight,		true,		"average",			false,           "",      dfNone,			0,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 4 ; i++){
	    				   InitDataProperty(2, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfNone,			0,     true,       true);
	    			   }
	    			   for ( var i=4; i<headCnt; i++ ) {
	    				   if ( headCnt < i+10 ) {
	    					   sheetObjects[0].ColHidden(i) = true;
	    					   sheetObjects[1].ColHidden(i) = true;	
	    				   } else {
	    					   sheetObjects[0].ColHidden(i) = false;
	    					   sheetObjects[1].ColHidden(i) = false;
	    				   }
	    			   }
	    			   SheetWidth = 7*80;
	               break;
	    
	           case "t2sheet1":      //t2sheet1 init
	                   //전체 너비 설정
	                   SheetWidth = mainTable.clientWidth;
	    
	                   //Host정보 설정[필수][HostIp, Port, PagePath]
	                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    
	                   //전체Merge 종류 [선택, Default msNone]
	                   MergeSheet = msPrevColumnMerge;
	    
	                   //전체Edit 허용 여부 [선택, Default false]
	                   Editable = false;
	    
	                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                   InitRowInfo( 1, 3, 18, 100);
	    
	                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                   InitHeadMode(false, true, true, true, false,false)
	                   CountPosition = 0;	//페이지카운트 없애기
	    
	                   if (headTitle==null || headTitle =="") {
	                	   headTitle = "RCC|TP/SZ|Division|Average|2008-01|2008-02|2008-03|2008-04|2008-05|2008-06|2008-07|2008-08|2008-09|2008-10|2008-11|2008-12";
	                       InitColumnInfo(7, 0, 0, true);
	                   }
	                   headCnt  = headTitle.split("|").length;
	                   SheetWidth = headCnt*80+20;
	                   if ( SheetWidth>975 ) {
	                	   SheetWidth = 975;
	                   }
	                   
	                   InitColumnInfo(headCnt, 0, 0, true);
	                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                   InitHeadRow(0, headTitle, true);
	                   sheetObj.FrozenCols = 4;
	    
	                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			   InitDataProperty(0, cnt++ , dtAutoSum,   75,    daCenterTop,	true,		"loc_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      80,    daCenterTop,	true,		"cntr_tpsz_cd",		false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      80,    daCenter,	true,		"division",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      80,    daRight,		true,		"average",			false,           "",      dfNullInteger,	0,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 4 ; i++){
	    				   InitDataProperty(0, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfNullInteger,	0,     true,       true);
	    			   }
	    				
	    			   cnt = 0;
	    			   InitDataProperty(1, cnt++ , dtAutoSum,   75,    daCenterTop,	true,		"loc_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtData,      80,    daCenterTop,	true,		"cntr_tpsz_cd",		false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtData,      80,    daCenter,	true,		"division",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtData,      80,    daRight,		true,		"average",			false,           "",      dfNullInteger,	0,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 4 ; i++){
	    				   InitDataProperty(1, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfNullInteger,	0,     true,       true);
	    			   }
	    			    
	    			   cnt = 0;
	    			   InitDataProperty(2, cnt++ , dtAutoSum,   75,    daCenterTop,	true,		"loc_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,      80,    daCenterTop,	true,		"cntr_tpsz_cd",		false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,      80,    daCenter,	true,		"division",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,      80,    daRight,		true,		"average",			false,           "",      dfNone,			0,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 4 ; i++){
	    				   InitDataProperty(2, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfNone,			0,     true,       true);
	    			   }
	    			   for ( var i=4; i<headCnt; i++ ) {
	    				   if ( headCnt < i+10 ) {
	    					   sheetObjects[0].ColHidden(i) = true;
	    					   sheetObjects[1].ColHidden(i) = true;	
	    				   } else {
	    					   sheetObjects[0].ColHidden(i) = false;
	    					   sheetObjects[1].ColHidden(i) = false;
	    				   }
	    			   }
	    			   SheetWidth = 7*80;	    			   
	                break;
	           case "sheet1":     //t3sheet1 init
	                   //Host정보 설정[필수][HostIp, Port, PagePath]
	                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	           			WaitImageVisible = false;
	               break;           
	       }
       }
    }
    
    /**
    * Tab 클릭시 이벤트 관련
    * 선택한 탭의 요소가 활성화 된다.
    */
    function tab1_OnChange(tabObj , nItem)
    {
    	var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }
    /**
    * Tab 클릭시 이벤트 관련
    * 선택한 탭의 data 조회한다.
    */
    function tab1_OnClick(tabObj , nItem)
    {
    	if ( nItem == 0 ) {
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	} else if ( nItem == 1 ) {	//Long Staying탭 클릭시
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
    	} 
    }
    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if(!validateForm(sheetObj,formObj,sAction)) return;
    			sheetObj.Redraw = false;
    			sheetObj.WaitImageVisible = false;
    			ComOpenWait(true); 
    			doActionIBSheet(sheetObj,document.form,IBSEARCH04); 
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch("EES_CIM_0001GS.do",FormQueryString(formObj));
    			ComOpenWait(false); 
             break;
    		case IBSEARCH01:      //공통조회
    			sheetObj.WaitImageVisible = false;
    			doActionIBSheet(sheetObj,document.form,IBSEARCH03);
    			form.f_cmd.value = SEARCH01;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0001GS.do" , FormQueryString(form));
    			var period = ComGetEtcData(sXml,"period");	  //period기간 조회
    			var fm_prd  = period.split("|")[0];
    			var to_prd  = period.split("|")[1];
    			form.from_bse_dt.value = fm_prd.substr(0,4)+"-"+fm_prd.substr(4,6);
    			form.to_bse_dt.value = to_prd.substr(0,4)+"-"+to_prd.substr(4,6);
             
    			var bse_dt = ComGetEtcData(sXml,"bse_dt");	  //기준월 조회
    			var str_loc_nm = "";
             
    			if ( form.loc_type_code.value == "" ) {
    				str_loc_nm = "RCC";
    			} else if ( form.loc_type_code.value == "1" ) {
    				str_loc_nm = "LCC";
    			} else if ( form.loc_type_code.value == "2" ) {
    				str_loc_nm = "ECC";
    			} else if ( form.loc_type_code.value == "3" ) {
    				str_loc_nm = "SCC";
    			} else if ( form.loc_type_code.value == "4" ) {
    				str_loc_nm = "SCC";
    			} else if ( form.loc_type_code.value == "5" ) {
    				str_loc_nm = "Country";
    			} else if ( form.loc_type_code.value == "6" ) {
    				str_loc_nm = "LCC";
    			} else if ( form.loc_type_code.value == "7" ) {
    				str_loc_nm = "ECC";
    			} else if ( form.loc_type_code.value == "8" ) {
    				str_loc_nm = "SCC";
    			}
    			var HeadTitle = str_loc_nm+"|TP/SZ|Division|Average|"+bse_dt;

    			HeadTitleCnt = HeadTitle.split("|").length;
    
    			var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");	   //TP/SZ 조회
    			tot_cntr_tpsz_cd = cntr_tpsz_cd;
    			var strCntrTpszCd  = cntr_tpsz_cd.split("|");
    			
    			//멀티콤보초기화
    			with (form.cntr_tpsz_cd) {
    				MultiSelect = true;
    				MultiSeparator = ",";
    				DropHeight = 330;
             		UseAutoComplete = true;	
             		//영문(대)+특수문자 - Lease Term
             		ValidChar(2,3);    				
    				InsertItem(0 , 'ALL','');
    				for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
    					InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
    				}
    			}    
    			break; 
    
    		case IBSEARCH02:      //Long Staying조회
    			if(!validateForm(sheetObj,formObj,sAction)) return;

    			sheetObj.Redraw = false;
    			sheetObj.WaitImageVisible = false;
    			ComOpenWait(true); 
    			doActionIBSheet(sheetObj,document.form,IBSEARCH04);
       	     	formObj.f_cmd.value = SEARCH02;
       	     	sheetObj.DoSearch("EES_CIM_0001GS.do",FormQueryString(formObj));
    			ComOpenWait(false); 

       	     	break;
    		case IBSEARCH03:      //Period 조회
    			form.f_cmd.value = SEARCH03;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0001GS.do" , FormQueryString(form)); 
             
    			//콤보코드와 콤보텍스트 가져오기  
    			var fm_prd = ComGetEtcData(sXml,"fm_prd");
    			var to_prd = ComGetEtcData(sXml,"to_prd");
    			form.from_bse_dt.value = fm_prd.substr(0,4)+"-"+fm_prd.substr(4,6);
    			form.to_bse_dt.value = to_prd.substr(0,4)+"-"+to_prd.substr(4,6);
        	 
    			break;
    		case IBSEARCH04:      //HEAD 조회
    			
    			form.f_cmd.value = SEARCH04;
    			var sXml = sheetObjects[0].GetSearchXml("EES_CIM_0001GS.do" , FormQueryString(form)); 
    			//헤더 데이터를 설정한다.
    			var bse_dt = ComGetEtcData(sXml,"bse_dt");
    			var str_loc_nm = "";
             
    			if ( form.loc_type_code.value == "" ) {
    				str_loc_nm = "RCC";
    			} else if ( form.loc_type_code.value == "1" ) {
    				str_loc_nm = "LCC";
    			} else if ( form.loc_type_code.value == "2" ) {
    				str_loc_nm = "ECC";
    			} else if ( form.loc_type_code.value == "3" ) {
    				str_loc_nm = "SCC";
    			} else if ( form.loc_type_code.value == "4" ) {
    				str_loc_nm = "SCC";
    			} else if ( form.loc_type_code.value == "5" ) {
    				str_loc_nm = "Country";
    			} else if ( form.loc_type_code.value == "6" ) {
    				str_loc_nm = "SCC";
    			} else if ( form.loc_type_code.value == "7" ) {
    				str_loc_nm = "ECC";
    			} else if ( form.loc_type_code.value == "8" ) {
    				str_loc_nm = "SCC";
    			}
    			var HeadTitle = str_loc_nm+"|TP/SZ|Division|Average|"+bse_dt;
    			HeadTitleCnt = HeadTitle.split("|").length;
    			for ( var i=0; i<headCnt; i++ ) {
    				if ( HeadTitleCnt <= i ) {
    					sheetObj.ColHidden(i) = true;
    				} else {
    					sheetObj.ColHidden(i) = false;
    				}
    			}
    			
    			for ( var i=0; i<HeadTitleCnt; i++ ) {
    				sheetObj.CellValue2(0,i) = HeadTitle.split("|")[i];	 
    			}
    			sheetObj.SheetWidth = HeadTitleCnt*80+20;
    			if ( sheetObj.SheetWidth>975 ) {
    				sheetObj.SheetWidth = 975;
    			}
    			break;
    		case IBSEARCH05:      //TP/SZ 콤보 조회
    			form.f_cmd.value = SEARCH05;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0001GS.do" , FormQueryString(form)); 
             
    			//헤더 데이터를 설정한다.
    			var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");
    			tot_cntr_tpsz_cd = cntr_tpsz_cd;
    			var strCntrTpszCd  = cntr_tpsz_cd.split("|");
    
    			//멀티콤보초기화
    			with (form.cntr_tpsz_cd) {
    				MultiSelect = true;
    				MultiSeparator = ",";
    				DropHeight = 320;
    				InsertItem(0 , 'ALL','ALL'); 
    				for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
    					InsertItem(i, strCntrTpszCd[i], strCntrTpszCd[i]);
    				}
    			}                     
    			break;
			case IBSEARCH06: //location focusOut
				var inquiryLevel = "";
				if ( formObj.loc_type_code.value == 1 ) {
					inquiryLevel = "R";
				} else if ( formObj.loc_type_code.value == 2 ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == 3 ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_type_code.value == 4 ) {
					inquiryLevel = "E";
				} else if  ( formObj.loc_type_code.value == 5 ) {
					inquiryLevel = "C";
				} else if  ( formObj.loc_type_code.value == 6 ) {
					inquiryLevel = "S";
				} else if  ( formObj.loc_type_code.value == 7 ) {
					inquiryLevel = "R";
				} else if  ( formObj.loc_type_code.value == 8 ) {
					inquiryLevel = "R";
				}
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH06;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0001GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM29013");
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						return true;
					}
				} else {
					ComSetFocus(document.form.from_bse_dt);
				}
		
				break;		    			
    		case IBDOWNEXCEL:      // 엑섹다운로드
    			sheetObj.Down2Excel(-1, false, false, true);
    			break;
    	}
    }
    
    /**
    * Tab1 조회종료
    * Tab1 조회종료후 이벤트 호출
    */
    function t1sheet1_OnSearchEnd(sheetObj, msg){
    	for(var i=1; i<=sheetObj.LastRow; i++){
    		if(sheetObj.CellValue(i,1).toUpperCase() == 'TOTAL'){
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(229,234,255);
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(229,234,255);
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
    		}
    	}
    	if ( sheetObj.rowCount != 0 ) {
	    	for ( var i=sheetObj.LastRow-5; i<sheetObj.LastRow-2; i++) {
	    		for ( var j=1; j<HeadTitleCnt; j++ ) {
	    			sheetObj.CellValue2(i+3,j) =  sheetObj.CellValue(i, j);
	    	    	sheetObj.CellAlign(i+3,"division") = daCenter;
	    		}
	    	}
	    	sheetObj.CellAlign(sheetObj.LastRow-2,"cntr_tpsz_cd") = daCenter;
	    	sheetObj.CellValue(sheetObj.LastRow-2,0) = '';
	    	sheetObj.CellValue(sheetObj.LastRow-2,1) = 'G.Total';
	    	
	    	sheetObj.RowDelete(sheetObj.LastRow-5, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-4, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-3, false);
	    	sheetObj.SetMergeCell (sheetObj.LastRow-2, 0, 3, 2);
    	}
    	sheetObj.SelectHighLight = false;
    	sheetObj.Redraw = true;
    }
   /**
    * Tab2 조회종료
    * Tab2 조회종료후 이벤트 호출
    */
    function t2sheet1_OnSearchEnd(sheetObj, msg){
    	for(var i=1; i<=sheetObj.LastRow; i++){
    		if(sheetObj.CellValue(i,1).toUpperCase() == 'TOTAL'){
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(229,234,255);
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(229,234,255);
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
    		}
    	}
    	if ( sheetObj.rowCount != 0 ) {
	    	for ( var i=sheetObj.LastRow-5; i<sheetObj.LastRow-2; i++) {
	    		for ( var j=1; j<HeadTitleCnt; j++ ) {
	    			sheetObj.CellValue2(i+3,j) =  sheetObj.CellValue(i, j);
	    	    	sheetObj.CellAlign(i+3,"division") = daCenter;
	    		}
	    	}
	    	sheetObj.CellAlign(sheetObj.LastRow-2,"cntr_tpsz_cd") = daCenter;
	    	sheetObj.CellValue(sheetObj.LastRow-2,0) = '';
	    	sheetObj.CellValue(sheetObj.LastRow-2,1) = 'G.Total';
	    	
	    	sheetObj.RowDelete(sheetObj.LastRow-5, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-4, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-3, false);
	    	sheetObj.SetMergeCell (sheetObj.LastRow-2, 0, 3, 2);
    	}
    	sheetObj.SelectHighLight = false;
    	sheetObj.Redraw = true;
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
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
               with (tabObj) {
                   var cnt  = 0 ;
                   InsertTab( cnt++ , "     Inventory     " , -1 );
                   InsertTab( cnt++ , "Long Staying(≥ 31 days)" , -1 );
               }
            break;
        }
    }
    
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    	  	var formObject = document.form;
    	  	if ( doActionIBSheet(sheetObj, document.form, IBSEARCH06) ) {	//Location 유효성체크
    	  		formObject.loc_cd.focus();
     	        return false;
     	    } else {
	    	  	if(formObject.loc_type_code.value != "" && formObject.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	  		formObject.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	if (!ComChkValid(formObj)) return false;
	    	  	
	    	  	return true;
     	    }
    	}
    	return true;
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t1sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t2sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }    
	/* 개발자 작업  끝 */