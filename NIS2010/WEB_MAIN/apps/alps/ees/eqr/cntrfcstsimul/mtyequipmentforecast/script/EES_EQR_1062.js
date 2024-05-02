/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1062.js
*@FileTitle : :Forecast Accuracy Review (By Week)
*Open Issues :
*Change history : 1. 2012-12-24 CHM-201222064, 신용찬 수석, Location By 옵션 조정
*                 2. 2013-01-21 CHM-201322369, Location 검색조건 추가, 신용찬 수석
*@LastModifyDate :  2009.12.17
*@LastModifier : 김종준
*@LastVersion : 1.0
*  2009.12.17 김종준
* 1.0 Creation
* ======================================================
* 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
=========================================================*/

	function EES_LSE_0022() {
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
	}
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var tpszArr = new Array();
	
	var comboObjects = new Array();
	var comboCnt = 0 ;
	
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
		var sheetObject2 = sheetObjects[shtCnt++];
		var sheetObject3 = sheetObjects[shtCnt++];
			
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			
				case "btn_retrieve":
					if ( beforetab == 0 ) {	  //첫번째 탭에서 조회
						initSheet(sheetObjects[0],1);
						formObject.search_flag.value = 'WEEK';
						
		    			sheetObjects[0].RemoveAll();
		    			sheetObjects[1].RemoveAll();
		    			
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						initSheet(sheetObjects[2],2);
						formObject.search_flag.value = 'FACTOR';
						formObject.view_flag[0].checked = true;
						
		    			sheetObjects[2].RemoveAll();
		    			
						doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
					}
					break;
				case "btn_new":
					tpszChange('');
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					break;
	
				case "btn_downexcel":

					if ( beforetab == 0 ) {	  //첫번째 탭에서 조회
						
		    			sheetObjects[0].Down2Excel(0,false,true,true,'','',false,false,'',false,'','');
			            if(sheetObjects[1].RowCount > 0){
			            	sheetObjects[1].Down2Excel(0,true,false,true,'','',false,false,'',false,'','');
		    	        }
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						sheetObjects[2].Down2Excel(-1,false,true,true,'','',false,false,'',false,'','');
		    			
					}					

					break;
	
				case "btn_loc_cd":	//Location By 조회 팝업
	    	        var cnt_cd = "";
	    	        var loc_cd = "";
		            cnt_cd = formObject.loc_tp_cd.value;
		            loc_cd = formObject.loc_cd.value;
		            if ( formObject.loc_tp_cd.value != '' ) {	
	        			var loc_code = "";
	                    
	        			if ( form.loc_tp_cd.value == "" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( form.loc_tp_cd.value == "R" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( form.loc_tp_cd.value == "L" ) {
	        				loc_code = "lcc_cd";
	        			} else if ( form.loc_tp_cd.value == "S" ) {
	        				loc_code = "lcc_cd";	        				
	        			} else if ( form.loc_tp_cd.value == "E" ) {
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
	                    
	        			if ( form.loc_tp_cd_second.value == "" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( form.loc_tp_cd_second.value == "R" ) {
	        				loc_code = "rcc_cd";
	        			} else if ( form.loc_tp_cd_second.value == "L" ) {
	        				loc_code = "lcc_cd";        				
	        			} else if ( form.loc_tp_cd_second.value == "E" ) {
	        				loc_code = "ecc_cd";
	        			}
						var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 440, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		            }
					break;			
					
				case "btn_t1detail":
					ComOpenPopupWithTarget('apps/alps/ees/eqr/cntrfcstsimul/mtyequipmentforecast/jsp/EES_EQR_1065.jsp', 600, 300,"", "0,1,1,1,1,1", true);
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
    	axon_event.addListener('change', 'loc_tp_cd_onchange', 'loc_tp_cd');		            //Location by 변경시 이벤트 처리
    	axon_event.addListener('change', 'loc_tp_cd_second_onchange', 'loc_tp_cd_second');		//Location 변경시 이벤트 처리    	
    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');				//LOC_CD keyup 이벤트 처리
    	axon_event.addListener('keyup', 'loc_cd_second_onkeyUp', 'loc_cd_second');	//LOC_CD_SECOND keyup 이벤트 처리    	
    	axon_event.addListener('keyup', 'fm_week_onkeyUp', 'fm_week');				//from_bse_dt keyup 이벤트 처리
    	axon_event.addListener('keyup', 'to_week_onkeyUp', 'to_week');				//to_week keyup 이벤트 처리
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');					//엔터키 조회 이벤트처리
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 		//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 	//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerForm('blur', 'obj_blur', form); 						//form obj_blur이벤트에 코드 처리
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);			//알파벳 대문자,숫자만 입력허용
    	axon_event.addListener('click', 'view_flag_click', 'view_flag');			//All   FCST   PFMC   Diff.Vol   Diff.(%)   Evaluation 클릭시 이벤트 처리
    	axon_event.addListenerForm('change','form_change',form);
    	
    	ComEnableObject(document.form.loc_cd_second,  false); // 두번째 radio 비사용화
    }
    
    /**
     * 시간텀으로 필터링시 체크안되는 문제 해결
     */
    function view_flag_click() {
        setTimeout("fnc_view_flag_click();",1);
    }
    


    /**
     * All   FCST   PFMC   Diff.Vol   Diff.(%)   Evaluation 클릭시 이벤트 처리
     * All   FCST   PFMC   Diff.Vol   Diff.(%)   Evaluation 조건별 조회.
     */ 
     function fnc_view_flag_click() {
    	 if ( sheetObjects[2].rowCount > 0 ) {
    		 sheetObjects[2].Redraw = false;
	    	 var view_flag_value = "";
	    	 if ( document.form.view_flag[0].checked ) {
	    		 view_flag_value = document.form.view_flag[0].value;
	    	 } else if ( document.form.view_flag[1].checked ) {
	    		 view_flag_value = document.form.view_flag[1].value;
	    	 } else if ( document.form.view_flag[2].checked ) {
	    		 view_flag_value = document.form.view_flag[2].value;
	    	 } else if ( document.form.view_flag[3].checked ) {
	    		 view_flag_value = document.form.view_flag[3].value;
	    	 } else if ( document.form.view_flag[4].checked ) {
	    		 view_flag_value = document.form.view_flag[4].value;
	    	 } else if ( document.form.view_flag[5].checked ) {
	    		 view_flag_value = document.form.view_flag[5].value;
	    	 }
	
	    	 var sxml = CimMakeHiddenXml(sheetObjects[2], view_flag_value, "bound|loc_cd|factor|yrwk|tot_qty|d2_qty|d4_qty|d5_qty|d7_qty|r2_qty|r5_qty|r9_qty|o2_qty|o4_qty|o5_qty|s2_qty|s4_qty|f2_qty|f4_qty|f5_qty|a2_qty|a4_qty|a5_qty|dp_seq");
	    	 sheetObjects[2].LoadSearchXml4Sax(sxml);
    	 
    		 for ( var i=1; i<=sheetObjects[2].rowCount; i++) {
    			 for ( var j=0; j<HeadTitleCnt; j++ ) {
    				 if ( j >4 ) {
    					 if ( ComIsContainsChars(sheetObjects[2].CellValue(i,j), "-") ) {
    						 sheetObjects[2].CellFontColor(i,j) = sheetObjects[2].RgbColor(255,0,0);
    					 }
    				 } 
    				 if ( j < 4 ) {
    					 sheetObjects[2].CellAlign(i,j) = daCenterTop;
    				 }
    			 }
    		 }
    		 sheetObjects[2].Redraw = true;
    	 }
     }
     
     /**
      * All   FCST   PFMC   Diff.Vol   Diff.(%)   Evaluation 조건별 필터링.
      */ 
     function CimMakeHiddenXml(sheet_obj, pMatch, saveColName)  {
         try {
             var allXml = "";
             var sColSep = "?";
             var sColOrder = "";
             if (saveColName!=undefined && saveColName != null && saveColName!="") {
                 sColOrder = " COLORDER='" + saveColName + "' ";
             }

             allXml = "<?xml version='1.0'  ?>\n"
                    + "<SHEET>\n"
             allXml += "  <DATA " + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
             var aryTRs = "";
             var sheetText = sheet_obj.GetRangeText(sheet_obj.HeaderRows,0,sheet_obj.LastRow,sheet_obj.LastCol,sColSep,"^");
             var aryTRs = sheetText.split("^");
             for (var i in aryTRs) {
    			 var color = '';
        		 if( sheet_obj.CellValue(parseInt(i)+sheet_obj.HeaderRows, "yrwk") == 'Total' ) { 
        			 if ( sheet_obj.CellValue(parseInt(i)+sheet_obj.HeaderRows, "factor") == 'Evaluation' ) {
        				 color = '247,225,236';
        			 } else {
        				 color = '201, 213, 235';
        			 }
        		 }

        		 if ( pMatch == '' ) {
            		 aryTRs[i] = "<TR BGCOLOR='"+color+"'><![CDATA["+aryTRs[i]+"]]></TR>";
            	 } else { 
	                if(sheet_obj.CellValue(parseInt(i)+sheet_obj.HeaderRows, "dp_seq") != pMatch) {
	               	 	aryTRs[i] = "<TR HIDDEN=\"TRUE\" BGCOLOR='"+color+"'><![CDATA["+aryTRs[i]+"]]></TR>";
	                } else {
	               	 	aryTRs[i] = "<TR BGCOLOR='"+color+"'><![CDATA["+aryTRs[i]+"]]></TR>";
	                }
            	 }
             }
             allXml += aryTRs.join("\n"); 
             allXml += "  </DATA>\n"
                    +  "</SHEET>";
             return allXml;
         } catch(err) { ComFuncErrMsg(err.message); }
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
		  			formObject.fm_week.focus();
		  			return;
		  		}
				break;
			case "to_week":
				if ( ComReplaceStr(formObject.to_week.value,"-","") != "" && !ComIsDate(formObject.to_week.value, "yw") ) {
		  			ComShowMessage(msgs["EQR90056"]);
		  			formObject.to_week.value = "";
		  			formObject.to_week.focus();
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
				if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH01) ) {	//Location By유효성체크
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
		var formObject = document.form;
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
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
    function loc_tp_cd_onchange() {
    	var formObject = document.form;
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);  
    }
    
    /**
     * Location  변경시 이벤트 처리
     * 나머지 활성화
     */
    function loc_tp_cd_second_onchange() {
    	var formObject = document.form;
//        formObject.loc_cd.value = "";
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
     * Week FM  keyup 이벤트 처리
     * Week FM  keyup YYYY-MM 포멧 처리
     */
     function fm_week_onkeyUp() {
    	 if ( event.keyCode != 16 && event.keyCode != 46 && event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	        var formObject = document.form;
	        var fm_week = formObject.fm_week.value.replace(/\/|\-|\./g, "");
	        if ( fm_week.length == 6 ) {
	        	formObject.fm_week.value = fm_week.substr(0,4)+"-"+fm_week.substr(4,6);
	        	formObject.to_week.focus();
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
	        	formObject.bound.focus();
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

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        for(p=0;p< comboObjects.length;p++){
			initCombo (comboObjects[p],p+1);
		}

        tpszChange('');
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
        
        // 2015-11-12, 신용찬, 타입사이즈 표현 방식 변경(버그 수정)
        /*
        if(( comboObjects[0].Text == null || comboObjects[0].Text == "")){
			tpszArr = tpszallText.split("|");
		} else {
			tpszArr = (comboObjects[0].Text).split(",") ;			
		}
		*/
        tpszArr = tpszallText.split("|"); // 항상 모두 보이게 한후, 조회 끝나면 선택된 타입사이즈만 표시(search end에서 처리)

        switch(shtID) {
            case "t1sheet1":      // By Week
                with (sheetObj) {
                    // 높이 설정
                    style.height = 330;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 20, 100);
                    
                    var HeadTitle1 = "";
                                        
                    if(document.form.div_flag[0].checked == true) {
	                    if(document.form.loc_tp_cd.value == "R"){        // RCC(by LCC )
	                    	HeadTitle1 = "Bound|Week|LCC|Evaluation|Factor|Total";
	                    }else if(document.form.loc_tp_cd.value == "L"){	 // LCC(by ECC )
	                    	HeadTitle1 = "Bound|Week|ECC|Evaluation|Factor|Total";
	                    }else{   										 // ECC(by SCC), LCC(by SCC)
	                    	HeadTitle1 = "Bound|Week|SCC|Evaluation|Factor|Total";
	                    }
                    }else { // radio 버튼 2번째 클릭
                    	if(document.form.loc_tp_cd_second.value == "L"){        // LCC
                    		HeadTitle1 = "Bound|Week|LCC|Evaluation|Factor|Total";
                    	}else if(document.form.loc_tp_cd_second.value == "E"){  // ECC
                    		HeadTitle1 = "Bound|Week|ECC|Evaluation|Factor|Total";
                    	}else{                                           // SCC
                    		HeadTitle1 = "Bound|Week|SCC|Evaluation|Factor|Total";
                    	}                    	
                    }                    
                    
                    for(var j=0; j < tpszArr.length; j++ ){
                    	HeadTitle1 += "|" +tpszArr[j];
					}
                  
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    HeadTitleCnt = headCount

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                   
                    InitDataProperty(0, cnt++ , dtData,	60,	daCenterTop,	true,	"bound",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	60,	daCenterTop,	true,	"yrwk",		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	60,	daCenterTop,	true,	"loc_cd",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenterTop,	true,	"eval",		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenterTop,	true,	"factor",	false,	"",	dfNone);
                    
                    InitDataProperty(0, cnt++ , dtData,	60,	daRight,		true,	"tot_qty",	false,	"",	dfNone);
                    for(var k=0; k < tpszArr.length; k++ ){
						InitDataProperty(0, cnt++ , dtData,      50,    daRight, true,     tpszArr[k].toLowerCase()+"_qty"  ,       false,          "",       dfNone);
					}
                       
                    SetSortDialog(false);
                    CountPosition = 0;
                    ExtendLastCol = false;
                    
                }
                break;

            case "t1sheet2":      //By Factor
            	with (sheetObj) {

                    // 높이 설정
                    style.height = 388;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 20, 100);

                    var HeadTitle1 = "";
                    
                    if(document.form.div_flag[0].checked == true) {
                    	if(document.form.loc_tp_cd.value == "R"){        // RCC(by LCC )
                    		HeadTitle1 = "Bound|LCC|Factor|Week|Total";
                    	}else if(document.form.loc_tp_cd.value == "L"){  // LCC(by ECC )
                    		HeadTitle1 = "Bound|ECC|Factor|Week|Total";
                    	}else{                                           // ECC(by SCC ), LCC(by SCC)
                    		HeadTitle1 = "Bound|SCC|Factor|Week|Total";
                    	}
                    }else { // radio 버튼 2번째 클릭
                    	if(document.form.loc_tp_cd_second.value == "L"){        // LCC
                    		HeadTitle1 = "Bound|LCC|Factor|Week|Total";
                    	}else if(document.form.loc_tp_cd_second.value == "E"){  // ECC
                    		HeadTitle1 = "Bound|ECC|Factor|Week|Total";
                    	}else{                                           // SCC
                    		HeadTitle1 = "Bound|SCC|Factor|Week|Total";
                    	}                    	
                    }
                    
                    for(var j=0; j < tpszArr.length; j++ ){
                    	HeadTitle1 += "|" +tpszArr[j];
					}
                    HeadTitle1 += "|";
                    
                  
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    HeadTitleCnt = headCount
                    //alert(headCount);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true); 

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++ , dtData,		60,	daCenterTop,	true,	"bound",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,		60,	daCenterTop,	true,	"loc_cd",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,		70,	daCenterTop,	true,	"factor",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,		70,	daCenterTop,	true,	"yrwk",		false,	"",	dfDateYm);
                                                        	
                    InitDataProperty(0, cnt++ , dtData,		60,	daRight,		true,	"tot_qty",	false,	"",	dfNone);
                    for(var k=0; k < tpszArr.length; k++ ){
						InitDataProperty(0, cnt++ , dtData,      50,    daRight, true,     tpszArr[k].toLowerCase()+"_qty"  ,       false,          "",       dfNone);
					}
                    InitDataProperty(0, cnt++ , dtHidden,	50,	daRight,		true,	"dp_seq",	false,	"",	dfNone);
                       
                    SetSortDialog(false);
                    CountPosition = 0;
                    ExtendLastCol = false;
            	}
            	break;
            case "t2sheet1":      //Accuracy Ranking
            	with (sheetObj) {

                    // 높이 설정
                    //style.height = 62;
                    style.height = 82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "FCST|Top|2nd|3rd|4th|5th|6th|7th|8th|9th|10th";
                  
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,	"bound",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	true,	"yrwk",		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	true,	"loc_cd",	false,	"",	dfNone);
                    
                    InitDataProperty(0, cnt++ , dtData,	91,		daCenter,	true,	"eval",		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	91,		daCenter,	true,	"factor",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	91,		daCenter,	true,	"tot_qty",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	91,		daCenter,	true,	"d2_qty",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	91,		daCenter,	true,	"d4_qty",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	91,		daCenter,	true,	"d5_qty",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	91,		daCenter,	true,	"d7_qty",	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,	91,		daCenter,	true,	"r2_qty",	false,	"",	dfNone);
                       
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
    			var sXml = sheetObj.GetSearchXml("EES_EQR_1062GS.do",FormQueryString(formObj));
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
				var sXml = sheetObj.GetSearchXml("EES_EQR_1062GS.do",FormQueryString(formObj));
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
						
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
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
				var sXml = sheetObj.GetSearchXml("EES_EQR_1062GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");

				if (sCheck != "OK") {
					if (document.form.loc_cd_second.value != "") {
						if ( formObj.loc_tp_cd_second.value == 'E' ) {
							ComShowCodeMessage("EQR90203");
						} else if ( formObj.loc_tp_cd_second.value == 'L' ) {
							ComShowCodeMessage("EQR90202");
						} else if  ( formObj.loc_tp_cd_second.value == 'S' ) { // LCC 단위검색
							ComShowCodeMessage("EQR90204");
						}
						
						document.form.loc_cd_second.value = "";
						ComSetFocus(document.form.loc_cd_second);
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
 	 * @param {object}	combo_obj - Combo Object
 	 * @see #링크연결
 	 * @author 작성자
 	 * @version 2009.01.01
 	 */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
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
                    InsertTab( cnt++ , "By Week" , -1 );
                    InsertTab( cnt++ , "By Factor" , -1 );
    			}
    			break;
    		case 2:
    			with (tabObj) {
    				var cnt  = 0 ;
                    InsertTab( cnt++ , "Accuracy Ranking" , -1 );
    			}
    			break;

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
//     		initSheet(sheetObjects[0],1);
//			document.form.search_flag.value = 'WEEK';
// 		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	} else if ( nItem == 1 ) {
//     		initSheet(sheetObjects[2],2);
//     		document.form.search_flag.value = 'FACTOR';
//     		document.form.view_flag[0].checked = true;
// 			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
     	} 
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	
        	if(document.form.div_flag[0].checked == true) {
        		if(document.form.loc_cd.value == "") { 
        			ComShowCodeMessage("EQR90001", "Location By Value");
        			ComSetFocus(document.form.loc_cd);
        			return false;
        		}
        		
    			if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH01) ) {	//Location By 유효성체크
    				ComSetFocus(document.form.loc_cd);
         	        return false;
        	  	} else {
        	  		if (!ComChkValid(formObj)) return false;    	  		
        	  		if (!fncCheckWeek()) return false;    	  		
        	  	}        		
    			
        	}if(document.form.div_flag[1].checked == true) {
        		if(document.form.loc_cd_second.value == "") { 
        			ComShowCodeMessage("EQR90001", "Location Value");
        			ComSetFocus(document.form.loc_cd_second);
        			return false;
        		}
    			if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
    				ComSetFocus(document.form.loc_cd_second);
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
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	if ( sheetObj.rowCount > 0 ) {


	    	if ( document.form.bound.value == 'A' ) { // Forecast "ALL" 선택상태에서 조회됨.(Accuracy Ranking 쉬트에서 row 2개를 생성함.)
	    		var row_count = 1;
	    		if(sheetObj.CellValue(sheetObj.LastRow-1, "loc_cd") != "Total") row_count++;
	    		if(sheetObj.CellValue(sheetObj.LastRow,   "loc_cd") != "Total") row_count++;
	    		
		    	sheetObjects[1].Rows = row_count; 
		    	var i=0;

		    	// 마지막 row-1가 2번째 sheet 에 표현가능한지 확인
		    	if(sheetObj.CellValue(sheetObj.LastRow-1, "loc_cd") != "Total") {
		    		i++;
		    		for ( var j=0; j<HeadTitleCnt; j++ ) {
		    			sheetObjects[1].CellValue2(i,j) = sheetObj.CellValue(sheetObj.LastRow-1, j);
		    			sheetObjects[1].CellAlign(i,j)  = daCenter;		    			
		    		}
		    	}
		    	
		    	// 마지막 row가 2번째 sheet 에 표현가능한지 확인
		    	if(sheetObj.CellValue(sheetObj.LastRow, "loc_cd") != "Total") {
		    		i++;
		    		for ( var j=0; j<HeadTitleCnt; j++ ) {
		    			sheetObjects[1].CellValue2(i,j) = sheetObj.CellValue(sheetObj.LastRow, j);
		    			sheetObjects[1].CellAlign(i,j)  = daCenter;		    			
		    		}
		    	}		    		

		    	//sheetObj.RowDelete(sheetObj.LastRow-1, false);  // SHEET1 의 마지막 ROW-1를 삭제
		    	//sheetObj.RowDelete(sheetObj.LastRow, false);    // SHEET1 의 마지막 ROW를 삭제
		    	
	    	} else {  // I/B, O/B 둘중 한개를 선택 (1개 ROW만 생성)
		    	sheetObjects[1].Rows = 2;
	    		for ( var i=0; i<HeadTitleCnt; i++ ) {
	    			sheetObjects[1].CellValue2(1,i) =  sheetObj.CellValue(sheetObj.LastRow, i);
	    			sheetObjects[1].CellAlign(1,i) = daCenter;
	    		}
		    	sheetObj.RowDelete(sheetObj.LastRow, false);  // SHEET1 의 마지막 ROW를 삭제
	    	}
    	}
    	sheetObj.redrew = true;
    	
    	//alert("TPSZ 1 : " +form.tpsztype.Text);
    	setGridHidden(form.tpsztype.Text, sheetObjects[0]); // 선택된 TYPE SIZE 만 표현하는 기능 (By week GRID)
    }

    
    /**
     * Tab2(By Factor) 조회종료
     * Tab2(By Factor) 조회종료후 이벤트 호출
     */
	function t1sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{

    	sheetObj.redrew = true;
    	
    	//alert("TPSZ 2 : " +form.tpsztype.Text);
    	setGridHidden(form.tpsztype.Text, sheetObjects[2]); // 선택된 TYPE SIZE 만 표현하는 기능    (By week By Factor)	    	
	}
	
    /*
     * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
     * OnloadPage,OnSearchEnd event에서 호출
     * @param {String} tpsz_cd
     * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
     */
    function setGridHidden(tpsz_cd, sheetObj){
        //var sheetObj = sheetObjects[0]; 
        var arr_tpsz = tpsz_cd.split(",");

       // alert("arr_tpsz : " +arr_tpsz);
        
        for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size       
            for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
                if(consTpszArr[i] == arr_tpsz[j]){
                    sheetObj.ColHidden(consTpszArr[i].toLowerCase() + "_qty")   = false;
                    break;
                }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
                    sheetObj.ColHidden(consTpszArr[i].toLowerCase() + "_qty")   = true;
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
 					
 					var menuname = tpszallText.split('|'); 
 					var menucode = tpszallCode.split('|'); 
 					
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
 		switch (key) {
 		case "":
 			comboObjects[0].Code = consTpsz;                            
 			break;
 		case "D":
 			comboObjects[0].Code = consTpszDry;                
 			break;
 		case "R":
 			comboObjects[0].Code = consTpszRfr;
 			break;
 		case "O":
 			comboObjects[0].Code = consTpszOt;
 			break;
 		case "F":
 			comboObjects[0].Code = consTpszFr;
 			break;
 		}
 	}
 	
	/**
	 * 설  명 : Form Object의 Change Event <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     form_change()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function form_change(){
	  	var srcName = window.event.srcElement.getAttribute("name");

	  	if ( srcName == "cntrTpsz"){
	   		var index = document.form.cntrTpsz.selectedIndex;
	   		tpszChange(document.form.cntrTpsz.options[index].value);
	   	}
	}
	 
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetNum.GetSearchXml("EES_EQR_1062GS.do", FormQueryString(formObj));
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
		var sXml = sheetNum.GetSearchXml("EES_EQR_1062GS.do", FormQueryString(form));
		sheetNum.LoadSearchXml(sXml);
	}
	
	/**
	 * 
	 */
	function ChangeInputStatus(radio_num) {
		if(radio_num == 1) {
			ComEnableObject(document.form.loc_cd,         true);			
			ComEnableObject(document.form.loc_cd_second,  false);
			
			document.form.loc_cd_second.value="";
			document.getElementById("loc_cd").className = "input1";
			document.getElementById("loc_cd").focus();
			
		}else {  // 두번째 라디오 선택(Location)
			ComEnableObject(document.form.loc_cd,         false);
			ComEnableObject(document.form.loc_cd_second,  true);
			
			document.form.loc_cd.value="";
			document.getElementById("loc_cd_second").className = "input1";
			document.getElementById("loc_cd_second").focus();
		}
		
		
	}
