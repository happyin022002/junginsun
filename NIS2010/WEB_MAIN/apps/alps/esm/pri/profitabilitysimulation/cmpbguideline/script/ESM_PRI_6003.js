/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6003.js
*@FileTitle : CMPB Guideline Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.29 이승준
* 1.0 Creation
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
     * @class ESM_PRI_6003 : ESM_PRI_6003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_pri_6003() {
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
 
 var comboObjects = new Array();
 var comboCnt = 0;
 
 var errMsg = "";
 
//현재 이벤트를 저장
 var eventStatus = "";
 
//현재 sheet1의 selected row
 var selectedRow = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

	 /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
        /*******************************************************/
        var formObject = document.form;

     	try {
     		 var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             
             	case "btn_New":
					removeAll(document.form);
					break;

 				case "btn_retrieve":
 					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
 					break;
 					
				case "btns_calendar1": //달력버튼
 					var cal = new ComCalendar();
		        	cal.select(formObject.eff_dt, 'yyyy-MM-dd');
		        	break;
		        
		        case "btns_calendar2":
		        	var cal = new ComCalendar();
			        cal.select(formObject.exp_dt, 'yyyy-MM-dd');
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
      * IBSheet Object를 배열로 등록 <br>
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
      * 배열은 소스 상단에 정의 <br>
      * <br><b>Example :</b>
      * <pre>
      *     setSheetObject(sheetObj);
      * </pre>
      * @param {ibsheet} sheet_obj 필수 IBSheet Object
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */   
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }
     
     /**
      * IBMulti Combo Object를 배열로 등록 <br>
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
      * 배열은 소스 상단에 정의 <br>
      * <br><b>Example :</b>
      * <pre>
      *     setComboObject(combo_obj);
      * </pre>
      * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */  
     function setComboObject(combo_obj){
   		comboObjects[comboCnt++] = combo_obj;
   	 }
 	
     /**
      * Sheet 기본 설정 및 초기화 <br>
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
 	 function loadPage() {
 		for(i=0;i<sheetObjects.length;i++){
 			 //khlee-시작 환경 설정 함수 이름 변경
 			 ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);

 		}
 		
 		//IBMultiCombo초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
 	    
 	   var iWidth = window.document.body.clientWidth;
       
//       if(iWidth > 1024) {
    	   sheetColResize();
//      	 }
 		
    }
 	 
 	 
 	/**
      * LoadFinish 이벤트 시 발생한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function sheet2_OnLoadFinish(sheetObj) {
    	 sheetObj.WaitImageVisible = false; 
    	 axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
 		 axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
 		 axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
 		 axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
  		
  		 doActionIBSheet(sheetObj, document.form, IBCLEAR);
  		
  		 comboObjects[0].focus();
     }
 	 
 	
 	 /**
      * OnFocus event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_activate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */ 
 	function obj_activate() {
 		ComClearSeparator (event.srcElement);	   
 	}
 	
	/**
     * Onbeforedeactivate  event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
 	function obj_deactivate() {
    	 var srcName = event.srcElement.getAttribute("name");
    	 
    	 if (srcName == "prc_cmdt_def_cd") {// 정상적인 commodity or rep. commodity code인지 검사한다.
	    		var formObj = document.form;
		 		var prc_cmdt_def_cd = formObj.prc_cmdt_def_cd.value
			     
		   	 
				if(prc_cmdt_def_cd.length == 0 ){
					return;
				}
		 		
				var param = "f_cmd="+SEARCH03+"&prc_cmdt_def_cd="+formObj.prc_cmdt_def_cd.value.toUpperCase();
				
	 
			    var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_6003GS.do" , param);
			    var rowCnt = ComPriGetRowCountFromXML(sXml) ;
			    if( rowCnt > 0 ){
			    	return;
			    }
			    formObj.prc_cmdt_def_cd.value = "";
			    	 
	     } else if (srcName == "origin_cd" ) {
	    		var formObj = document.form;
	    		var origin = formObj.origin_cd.value
	     
	    	 
	    		if(origin.length == 0 ){
	    			return;
	    		}
				var param = "f_cmd="+SEARCH04+"&origin_cd="+formObj.origin_cd.value.toUpperCase();
			    var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_6003GS.do" , param);
			    var rowCnt = ComPriGetRowCountFromXML(sXml) ;
			    if( rowCnt > 0 ){
			    	return;
			    }
			    formObj.origin_cd.value = "";
	     }  else if ( srcName == "dest_cd" ){
	    		var formObj = document.form;
	    		var origin = formObj.origin_cd.value
	    		if(origin.length == 0 ){
	    			return;
	    		}
				var param = "f_cmd="+SEARCH04+"&dest_cd="+formObj.dest_cd.value.toUpperCase();
					 
			    var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_6003GS.do" , param);
			    var rowCnt = ComPriGetRowCountFromXML(sXml) ;
			    if( rowCnt > 0 ){
			    	return;
			    }
		    	formObj.dest_cd.value = "";
	     }
 	    ComChkObjValid(event.srcElement);
 	}
 	
 	/**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
	function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
//                ComKeyOnlyAlphabet('upper');
                ComKeyOnlyAlphabet('uppernum');
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            
            default:
        }
    }    
 	 
	/**
     * IBSHEET COMBO를 LOAD하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     * 		initCombo(comboObj, comboNo)
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function initCombo(comboObj, comboNo) {
 	    switch(comboObj.id) {
 	        case "svc_scp_cd":
 	            var i=0;
 	            with(comboObj) {
 	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	                MaxLength = 3;      // 3자리만 입력
 	            }
 	            break;
 	       
 	      case "cre_ofc_cd_in":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	            }
	            break;          
	            
 	      case "prs_cust_tp_cd_in":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	            }
	            break;   
	            
 	      case "r_rcv_de_term_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;    
	            
 	      case "d_rcv_de_term_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;  
	            
 	      case "rat_ut_cd_in":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 1);
                    MaxLength = 2;
	            }
	            break;    
	            
	      case "prc_cgo_tp_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	            	MaxLength = 2;	
                }
	            break;              
 	            
 	    }
 	}
  	
  	/**
     * comboObjects[0]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getSvcScpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function getSvcScpCd() {
		return comboObjects[0].Code;
	}
  	/**
     * comboObjects[1]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getCreOfcCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getCreOfcCd() {
   		return comboObjects[1].Code;
   	}
	/**
     * comboObjects[2]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getPrsCustTpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getPrsCustTpCd() {
   		return comboObjects[2].Code;
   	}
	/**
     * comboObjects[2]의 Text값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getPrsCustTpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */
	function getPrsCustTpTxt() {
   		return comboObjects[2].Text;
   	}
	/**
     * comboObjects[3]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getRRcvDeTermCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getRRcvDeTermCd() {
   		return comboObjects[3].Code;
   	}
	/**
     * comboObjects[4]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getDRcvDeTermCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getDRcvDeTermCd() {
   		return comboObjects[4].Code;
   	}
	/**
     * comboObjects[5]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getRatUtCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getRatUtCd() {
   		return comboObjects[5].Code;
   	}
	/**
     * comboObjects[6]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getPrcCgoTpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getPrcCgoTpCd() {
   		return comboObjects[6].Code;
   	}
  	
	/**
     * service scope combo 변경시 활성화됨<br>
     * 하위 조건 및 화면을 리셋함
     * <br><b>Example :</b>
     * <pre>
     * 		svc_scp_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param {comboObj} comboObj    필수,comboObj Object
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function svc_scp_cd_OnChange(comboObj, code, text) {
  		
  		if(comboObjects[0].GetCount () > 0 && comboObjects[0].Index != "-1") {
 	 			
			var formObj = document.form;
			
			var arrText = text.split("|");
			
			if (arrText[1] != null && arrText[1] != "undefined" && arrText[1].length > 1) {
				
				searchConditionReset(formObj);
				
				//office combo 조회
				doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
				
				formObj.svc_scp_nm.value = formObj.svc_scp_cd.GetText(code,1);
				
				formObj.svc_scp_nm.focus();
			}
			
  		}	
 	}
	/**
     * service scope combo 초기화시 동작함<br>
     * <br><b>Example :</b>
     * <pre>
     * 		svc_scp_cd_OnClear(comboObj);
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
  	function svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.svc_scp_nm.value = "";
		
		comboObj.Index2 = -1;
	}

  	
  	/**
     * service scope combo 포커스 아웃시 동작함<br>
     * 하위 조건 및 화면을 리셋함
     * <br><b>Example :</b>
     * <pre>
     * 		svc_scp_cd_OnBlur(comboObj)
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
  	function svc_scp_cd_OnBlur(comboObj) {
  		
		var formObj = document.form;
	
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			
			var text = comboObj.GetText(code, 1);
			
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				
				searchConditionReset(formObj);
				
				//office combo 조회
				doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
				
				formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
				
				formObj.svc_scp_nm.focus();
			}
		}
	}
  	
  	
  
  	/**
     * 화면을 전체 리셋한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeAll(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function removeAll(formObj) {
 		
		formObj.reset();
		
		comboObjects[0].Index2 = "-1";
 		comboObjects[1].Index2 = "-1";
 		comboObjects[2].Index2 = "-1";
 		comboObjects[3].Index2 = "-1";
 		comboObjects[4].Index2 = "-1";
 		comboObjects[5].Index2 = "-1";
 		comboObjects[6].Index2 = "-1";
 		
 		for (var i = 1; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
 		
 		comboObjects[0].focus();
 	}
  	
 	/**
     * 메인화면 콤보의 값이 바뀐 경우 화면을 리셋한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @version 2009.06.10
     */
 	function searchConditionReset(formObj) {
 		
		formObj.reset();
		
 		comboObjects[1].Index2 = "-1";
 		comboObjects[2].Index2 = "-1";
 		comboObjects[3].Index2 = "-1";
 		comboObjects[4].Index2 = "-1";
 		comboObjects[5].Index2 = "-1";
 		comboObjects[6].Index2 = "-1";
 		
 		for (var i = 1; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
 	}
  	
	
  	
 	
  	/**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {
         
	         case "sheet0":      //hidden 
	             with (sheetObj) {
	            	// Host정보 설정[필수][HostIp, Port, PagePath]
	 				if (location.hostname != "")
	 					InitHostInfo(location.hostname, location.port, page_path);
											
	             }
	             break;
         
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                    // 높이 설정
                    style.height = 293;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1  = "|Seq.|Customer\nType|SVC Lane|CMDT|Origin|O.Via|D.Via|Dest.|Per|CGO\nType|Cur.|CMPB\nGuideline|" +
                    				  "Creation\nOffice|MQC\n(Min.)|MQC\n(Max.)|Eff.\nDate|Exp.\nDate|" +
                    				  "svc_scp_cd|cre_ofc_cd|gline_seq|prs_cust_tp_cd|bse_seq";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		
                    //KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, 
                    //SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30, daCenter,   false, "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,  34, daCenter,   false, "Seq");
                    
 					InitDataProperty(0, cnt++ , dtData,	64,	daCenter,	true,	"prs_cust_tp_nm",			false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	67,	daCenter,	true,	"vsl_slan_cd",				false,	"",	dfNone,			0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData,	72,	daCenter,	true,	"prc_cmdt_def_cd",			false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"org_rout_pnt_loc_def_cd",	false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	65, daCenter,	true,	"org_rout_via_port_def_cd",	false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	65, daCenter,	true,	"dest_rout_via_port_def_cd",false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	72,	daCenter,	true,	"dest_rout_pnt_loc_def_cd",	false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	32,	daCenter,	true,	"rat_ut_cd",				false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	36, daCenter,	true,	"prc_cgo_tp_cd",			false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	34,	daCenter,	true,	"curr_cd",					false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	66, daRight,	true,	"cmpb_amt",					false,	"",	dfNullFloat,	2,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	55,	daCenter,	true,	"cre_ofc_cd",				false,	"",	dfNone,			0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	50,	daRight,	true,	"mqc_rng_fm_qty",			false,	"",	dfNullInteger,	0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	50,	daRight,	true,	"mqc_rng_to_qty",			false,	"",	dfNullInteger,	0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	65, daCenter,	true,	"eff_dt",					false,	"",	dfDateYmd,		0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,	68, daCenter,	true,	"exp_dt",					false,	"",	dfDateYmd,		0,	true,	true);	
 					
 					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, 	false, "svc_scp_cd",  	 			true,   "", dfNone, 0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, 	false, "cre_ofc_cd", 	 			true,   "", dfNone, 0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 90, daLeft,	false, "gline_seq", 	 			true,   "", dfNone, 0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, 	false, "prs_cust_tp_cd", 			true,   "", dfNone, 0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, 	false, "bse_seq", 		 			true,   "", dfNone, 0,  false,  false);
 	               
 	                Ellipsis = true;
// 					CountPosition = 0;
 					ColHidden("bse_seq") = true;
 			    }
                break;
                
             case "sheet2":      // sheet2 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 110;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

                     var HeadTitle1  = "|Sel.|Del Check|Seq.|SVC Lane|Commodity|Origin|Origin Via|Destination Via|Destination";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	
                     //DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,daCenter,   false, "ibflag");
  	                 InitDataProperty(0, cnt++,  dtDummyCheck, 	40, daCenter,   false, "chk",false,  "", dfNone, 0,  true,  true,0,	false,false,"",true);
                     InitDataProperty(0, cnt++,  dtDelCheck, 	40, daCenter,   false, "del_chk");
                     InitDataProperty(0, cnt++ , dtSeq,    		30, daCenter,   false, "Seq");
                     InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	true,  "vsl_slan_cd",				false,	"",	dfNone,0,false,	false);	
 					 InitDataProperty(0, cnt++ , dtData,	220,	daLeft,		true,  "prc_cmdt_def_nm",			false,	"",	dfNone,0,false,	false);	
 					 InitDataProperty(0, cnt++ , dtData,	160,	daLeft,		true,  "org_rout_pnt_loc_def_nm",	false,	"",	dfNone,0,false,	false);	
 					 InitDataProperty(0, cnt++ , dtData,	160,	daLeft,		true,  "org_rout_via_port_def_nm",	false,	"",	dfNone,0,false,	false);	
 					 InitDataProperty(0, cnt++ , dtData,	160,	daLeft,		true,  "dest_rout_via_port_def_nm",	false,	"",	dfNone,0,false,	false);	
 					 InitDataProperty(0, cnt++ , dtData,	165,	daLeft,		true,  "dest_rout_pnt_loc_def_nm",	false,	"",	dfNone,0,false,	false);	
 					
 					 Ellipsis = true;
// 					 WordWrap = true;
 					 CountPosition = 0;
 					 ColHidden("chk") = true;
 					 ColHidden("del_chk") = true;
 					 ColHidden("Seq") = true;
 					 //Editable  = false;
 					 SelectHighLight = false;
 					
 			    }
                break;
                
             case "sheet3":  // svc lane 
  	            with (sheetObj) {
  	                // 높이 설정
  	                style.height = 100;
  	                // 전체 너비 설정
  	                SheetWidth = mainTable.clientWidth;
  	    
  	                // Host정보 설정[필수][HostIp, Port, PagePath]
  	                if (location.hostname != "")
  	                    InitHostInfo(location.hostname, location.port, page_path);
  	    
  	                // 전체Merge 종류 [선택, Default msNone]
  	                MergeSheet = msNone;
  	    
  	                // 전체Edit 허용 여부 [선택, Default false]
  	                Editable = true;
  	    
  	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  	                InitRowInfo(1, 1, 3, 100);
  	    
  	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  	                InitColumnInfo(7, 0, 0, true);
  	    
  	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
  	                InitHeadMode(true, true, true, true, false, false)
  	    
  	                var HeadTitle = "3-1|3-2|3-3|3-4|3-5|3-6|3-7";
  	    
  	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  	                InitHeadRow(0, HeadTitle, true);
  	    
  	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
  	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
  	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
  	                // SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
  	                //InitDataProperty(0, cnt++ , dtCheckBox,	   40, daCenter, false,	"chk",		false,	"",	dfNone,	0,	false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++,  dtData, 100, daCenter,false, "cre_ofc_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vsl_slan_cd", 	false, "", dfNone, 0, false, false);
  	                
  	            }
  	            break; 
  	            
             case "sheet4":  // svc lane 
  	            with (sheetObj) {
  	                // 높이 설정
  	                style.height = 100;
  	                // 전체 너비 설정
  	                SheetWidth = mainTable.clientWidth;
  	    
  	                // Host정보 설정[필수][HostIp, Port, PagePath]
  	                if (location.hostname != "")
  	                    InitHostInfo(location.hostname, location.port, page_path);
  	    
  	                // 전체Merge 종류 [선택, Default msNone]
  	                MergeSheet = msNone;
  	    
  	                // 전체Edit 허용 여부 [선택, Default false]
  	                Editable = true;
  	    
  	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  	                InitRowInfo(1, 1, 3, 100);
  	    
  	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  	                InitColumnInfo(7, 0, 0, true);
  	    
  	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
  	                InitHeadMode(true, true, true, true, false, false)
  	    
  	                var HeadTitle = "3-1|3-2|3-3|3-4|3-5|3-6|3-7";
  	    
  	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  	                InitHeadRow(0, HeadTitle, true);
  	    
  	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
  	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
  	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
  	                // SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
  	                //InitDataProperty(0, cnt++ , dtCheckBox,	   40, daCenter, false,	"chk",		false,	"",	dfNone,	0,	false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++,  dtData, 100, daCenter,false, "cre_ofc_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vsl_slan_cd", 	false, "", dfNone, 0, false, false);
  	                
  	            }
  	            break; 
  	            
  			case "sheet5":  // commodity
  	            with (sheetObj) {
  	                // 높이 설정
  	                style.height = 100;
  	                // 전체 너비 설정
  	                SheetWidth = mainTable.clientWidth;
  	    
  	                // Host정보 설정[필수][HostIp, Port, PagePath]
  	                if (location.hostname != "")
  	                    InitHostInfo(location.hostname, location.port, page_path);
  	    
  	                // 전체Merge 종류 [선택, Default msNone]
  	                MergeSheet = msNone;
  	    
  	                // 전체Edit 허용 여부 [선택, Default false]
  	                Editable = true;
  	    
  	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  	                InitRowInfo(1, 1, 3, 100);
  	    
  	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  	                InitColumnInfo(10, 0, 0, true);
  	    
  	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
  	                InitHeadMode(true, true, true, true, false, false)
  	    
  	                var HeadTitle = "4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10";
  	    
  	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  	                InitHeadRow(0, HeadTitle, true);
  	    
  	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
  	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
  	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
  	                // SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_tp_cd", 	false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_nm", false, "", dfNone, 0, false, false);
  	            }
  	            break;   
  	            
  			case "sheet6":  // point origin
  	            with (sheetObj) {
  	                // 높이 설정
  	                style.height = 100;
  	                // 전체 너비 설정
  	                SheetWidth = mainTable.clientWidth;
  	    
  	                // Host정보 설정[필수][HostIp, Port, PagePath]
  	                if (location.hostname != "")
  	                    InitHostInfo(location.hostname, location.port, page_path);
  	    
  	                // 전체Merge 종류 [선택, Default msNone]
  	                MergeSheet = msNone;
  	    
  	                // 전체Edit 허용 여부 [선택, Default false]
  	                Editable = true;
  	    
  	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  	                InitRowInfo(1, 1, 3, 100);
  	    
  	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  	                InitColumnInfo(13, 0, 0, true);
  	    
  	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
  	                InitHeadMode(true, true, true, true, false, false)
  	    
  	                var HeadTitle = "5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13";
  	    
  	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  	                InitHeadRow(0, HeadTitle, true);
  	    
  	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
  	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
  	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
  	                // SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  	false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", 	false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_nm", 		false, "", dfNone, 0, false, false);
  	            }
  	            break; 
  	            
  	            
  			case "sheet7":  // via origin
  	            with (sheetObj) {
  	                // 높이 설정
  	                style.height = 100;
  	                // 전체 너비 설정
  	                SheetWidth = mainTable.clientWidth;
  	    
  	                // Host정보 설정[필수][HostIp, Port, PagePath]
  	                if (location.hostname != "")
  	                    InitHostInfo(location.hostname, location.port, page_path);
  	    
  	                // 전체Merge 종류 [선택, Default msNone]
  	                MergeSheet = msNone;
  	    
  	                // 전체Edit 허용 여부 [선택, Default false]
  	                Editable = true;
  	    
  	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  	                InitRowInfo(1, 1, 3, 100);
  	    
  	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  	                InitColumnInfo(11, 0, 0, true);
  	    
  	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
  	                InitHeadMode(true, true, true, true, false, false)
  	    
  	                var HeadTitle = "6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11";
  	    
  	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  	                InitHeadRow(0, HeadTitle, true);
  	    
  	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
  	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
  	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
  	                // SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  	false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd",false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm",false, "", dfNone, 0, false, false);
 	                
  	            }
  	            break; 
  	            
  	            
  			case "sheet8":  // point via
  	            with (sheetObj) {
  	                // 높이 설정
  	                style.height = 100;
  	                // 전체 너비 설정
  	                SheetWidth = mainTable.clientWidth;
  	    
  	                // Host정보 설정[필수][HostIp, Port, PagePath]
  	                if (location.hostname != "")
  	                    InitHostInfo(location.hostname, location.port, page_path);
  	    
  	                // 전체Merge 종류 [선택, Default msNone]
  	                MergeSheet = msNone;
  	    
  	                // 전체Edit 허용 여부 [선택, Default false]
  	                Editable = true;
  	    
  	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  	                InitRowInfo(1, 1, 3, 100);
  	    
  	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  	                InitColumnInfo(11, 0, 0, true);
  	    
  	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
  	                InitHeadMode(true, true, true, true, false, false)
  	    
  	                var HeadTitle = "8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11";
  	    
  	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  	                InitHeadRow(0, HeadTitle, true);
  	    
  	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
  	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
  	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
  	                // SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  	false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd",false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm",false, "", dfNone, 0, false, false);
  	            }
  	            break;      
  	            
  	            
  			case "sheet9":  // point dest
  	            with (sheetObj) {
  	                // 높이 설정
  	                style.height = 100;
  	                // 전체 너비 설정
  	                SheetWidth = mainTable.clientWidth;
  	    
  	                // Host정보 설정[필수][HostIp, Port, PagePath]
  	                if (location.hostname != "")
  	                    InitHostInfo(location.hostname, location.port, page_path);
  	    
  	                // 전체Merge 종류 [선택, Default msNone]
  	                MergeSheet = msNone;
  	    
  	                // 전체Edit 허용 여부 [선택, Default false]
  	                Editable = true;
  	    
  	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  	                InitRowInfo(1, 1, 3, 100);
  	    
  	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  	                InitColumnInfo(13, 0, 0, true);
  	    
  	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
  	                InitHeadMode(true, true, true, true, false, false)
  	    
  	                var HeadTitle = "7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13";
  	    
  	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  	                InitHeadRow(0, HeadTitle, true);
  	    
  	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
  	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
  	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
  	                // SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  	false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 			false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", 		false, "", dfNone, 0, false, false);
  	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", 	false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_nm", 		false, "", dfNone, 0, false, false);
  	            }
  	            break;
                
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
         	 case IBCLEAR: 
 		        	// 화면 로딩시 Service Scope 조회
 		 			formObj.f_cmd.value = SEARCH01;
 		 			formObj.etc5.value="PRS";
 		 			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 		 			ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
 	
 		 			
 		 			// 화면 로딩시customer type 조회
 					formObj.f_cmd.value = SEARCH20;
 					formObj.cd.value="CD02085";
 					
 					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 					ComPriXml2ComboItem(sXml, formObj.prs_cust_tp_cd_in, "cd", "nm");
 					//formObj.prc_cust_tp_cd.InsertItem(0,'','|');
 					
 					//code가 BOTH 인 경우  삭제 후   Text를 ""로 세팅
 					var itemindex = formObj.prs_cust_tp_cd_in.FindIndex("ALL",0);
 					
 					if(itemindex != "-1") {
 						formObj.prs_cust_tp_cd_in.DeleteItem(itemindex); 
 						formObj.prs_cust_tp_cd_in.InsertItem(0,' ','M');
 					}
 					
 					
 					// R term 조회
 					formObj.f_cmd.value = SEARCH20;
 					formObj.cd.value="CD02138";
 					
 					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 					
 					ComPriXml2ComboItem(sXml,  comboObjects[3], "cd", "nm");
 					comboObjects[3].InsertItem(0,' ','');
 					
 					// D term 조회
 					formObj.f_cmd.value = SEARCH20;
 					formObj.cd.value="CD02139";
 					
 					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 					ComPriXml2ComboItem(sXml,  comboObjects[4], "cd", "nm");
 					comboObjects[4].InsertItem(0,' ','');
 		 			
 		 			// per combo
 		            formObj.f_cmd.value = SEARCH03;
 		            formObj.etc5.value = "PRS";
 		            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 		    		ComPriXml2ComboItem(sXml, formObj.rat_ut_cd_in, "cd", "cd|nm");
 		    		formObj.rat_ut_cd_in.InsertItem(0,' ','');
			          
 		            //공통 cargo
 		            formObj.f_cmd.value = SEARCH20;
 		            formObj.cd.value="CD01701";
 		            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 		            ComPriXml2ComboItem(sXml, formObj.prc_cgo_tp_cd, "cd", "cd|nm");
 		            formObj.prc_cgo_tp_cd.InsertItem(0,' ','');
 		
 		            break;	
 		            
         	case IBCREATE: // Service Scope 선택시, office 조회
	 			formObj.f_cmd.value = SEARCH02;
	 			//alert(FormQueryString(formObj))
	 			
	 			formObj.cre_ofc_cd_in.RemoveAll();
	 			
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_6003GS.do", FormQueryString(formObj));
	 			
	 			ComPriXml2ComboItem(sXml, formObj.cre_ofc_cd_in, "cre_ofc_cd", "cre_ofc_cd");       
	 			formObj.cre_ofc_cd_in.InsertItem(0,' ','');
	 			
	 			break;    
 	 		
 	         case IBSEARCH:      //조회
	 	        	if (validateForm(sheetObj,formObj,sAction)) {
	 	        		try {
	 	        			sheetObjects[1].WaitImageVisible = false;
	 	        			ComOpenWait(true);
	 	        		
	 	        		if (sheetObj.id == "sheet1") {
		         			formObj.f_cmd.value = SEARCH;
	
		         			
		         			if(!ComIsEmpty(formObj.eff_dt.value) && setDash(formObj.eff_dt.value) != 'undefined')
		         				formObj.eff_dt.value = setDash(formObj.eff_dt.value);
		         			if(!ComIsEmpty(formObj.exp_dt.value) && setDash(formObj.exp_dt.value) != 'undefined')
		         				formObj.exp_dt.value = setDash(formObj.exp_dt.value);
		         			
		         			formObj.vsl_slan_cds.value = formObj.vsl_slan_cds.value.toUpperCase();
		         			formObj.prc_cmdt_def_cd.value = formObj.prc_cmdt_def_cd.value.toUpperCase();
		         			formObj.origin_cd.value = formObj.origin_cd.value.toUpperCase();
		         			formObj.dest_cd.value = formObj.dest_cd.value.toUpperCase();
		         			
		         			makeInParam(formObj);
//		         			setSearchDetailConditionCount(formObj);
		         			
		         			makeInParamPerType(formObj);
		         			
		    			    //sheetObj.DoSearch("ESM_PRI_6003GS.do", FormQueryString(formObj));
//		         			alert(FormQueryString(formObj))	
		    			    var sXml = sheetObj.GetSearchXml("ESM_PRI_6003GS.do" , FormQueryString(formObj));
		                    sheetObjects[1].LoadSearchXml(sXml);    // Grid1.
		                    //sheetObjects[2].LoadSearchXml(sXml);    // Grid2.
		                    
		                    formObj.rat_ut_cd.value = "";
		                    formObj.vsl_slan_cd.value = "";
		 	        	} 
	 	        		else if (sheetObj.id == "sheet2") {
	 	        			for (var i = 2; i < sheetObjects.length; i++) {
		                           sheetObjects[i].RemoveAll();
	                        }
	 	        			sheetObj.WaitImageVisible = false;
	                        formObj.f_cmd.value = SEARCH03;
	                        var sXml = sheetObj.GetSearchXml("ESM_PRI_6001GS.do" , FormQueryString(formObj));
	                        var arrXml = sXml.split("|$$|");
	                        sheetObj.WaitImageVisible = true;
	                        //if (arrXml.length > 0) sheetObjects[3].LoadSearchXml(arrXml[0]);    // Grid3.
	                        if (arrXml.length > 1) sheetObjects[4].LoadSearchXml(arrXml[1]);    // Hidden. Grid1의 scv lane.
	                        if (arrXml.length > 2) sheetObjects[5].LoadSearchXml(arrXml[2]);    // Hidden. Grid1의 cmdt.
	                        if (arrXml.length > 3) sheetObjects[6].LoadSearchXml(arrXml[3]);    // Hidden. Grid1의 Origin Point.
	                        if (arrXml.length > 4) sheetObjects[7].LoadSearchXml(arrXml[4]);    // Hidden. Grid1의 Origin Via.
	                        if (arrXml.length > 5) sheetObjects[8].LoadSearchXml(arrXml[5]);    // Hidden. Grid1의 Dest Via.
	                        if (arrXml.length > 6) sheetObjects[9].LoadSearchXml(arrXml[6]);    // Hidden. Grid1의 Dest Point.
 	        			
	                        formObj.rat_ut_cd.value = "";
	                        formObj.vsl_slan_cd.value = "";
	 	        		}
	 	        		
	 	        		ComOpenWait(false);

	 	        		} catch (e) {
	        	            if (e == "[object Error]") {
	        	                ComShowMessage(OBJECT_ERROR);
	        	            } else {
	        	                ComShowMessage(e);
	        	            }
	        	       } finally {
	        	    	   ComOpenWait(false);
	        	       }
	        	       
	 	        	} 	
	         	    break;
         	}
     }
     
     
     /**
      * 날짜에 -를 세팅한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *      setDash(date)
      * </pre>
      * @param {string} 날짜 input box의 value
      * @return string
      * @author 이승준
      * @version 2009.05.18
      */
 	function setDash(value) {
 		
 	   if(ComIsEmpty(value) || value.length == 0) return;
 	   
 	   var date = ComTrimAll(value).replace(/-/g, ""); 
 	 
 	   var str = "";
 	   for(var i=0; i<date.length; i++) {
 		   if(i == 4 || i == 6) {
 			  str += "-" + date.substring(i,i+1);
 		   } 
 		   else {
 			  str += date.substring(i,i+1);
 		   }
 	   }
 	   
 	   return str;

 	}
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     if (validateForm(sheetObj,document.form,IBSAVE)) {
      *         로직처리;
      *     }
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @return bool <br>
      *          true  : 폼입력값이 유효할 경우<br>
      *          false : 폼입력값이 유효하지 않을 경우
      * @author 이승준
      * @version 2009.04.17
      */
     function validateForm(sheetObj,formObj,sAction){
     	
    	  	switch (sAction) {
    	 
 	 		case IBSEARCH: // 조회
 	 			 	 				
 				if (ComIsEmpty(getSvcScpCd())) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
 				
	 			if (ComIsEmpty(formObj.eff_dt.value)) {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
	 				return false;
				}
 				if( ComChkObjValid(formObj.eff_dt) == false){
 					return false;
 				}
	 			

	 			if(!ComIsEmpty(formObj.exp_dt.value)) {

		 			if (formObj.eff_dt.value > formObj.exp_dt.value) {
						ComShowCodeMessage('PRI00305', '[Duration]');
						return false;
					}
	 			}
	 			if (!ComIsEmpty(getRRcvDeTermCd()) && ComIsEmpty(formObj.origin_cd.value)) {
	 				ComPriInputValueFailed("select","Origin",formObj.origin_cd);
					return false;
				}
	 			
	 			if (!ComIsEmpty(getDRcvDeTermCd()) && ComIsEmpty(formObj.dest_cd.value)) {
	 				ComPriInputValueFailed("select","Destination",formObj.dest_cd);
					return false;
				}
	 			
	 			
 				return true;
 	 			break;
 	 		
 	 	
 			}
    	  	

         return true;
     }
     
     
 	
 	
 	/**
 	 * SvcLane popup 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *    popupSvcLane()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function popupSvcLane() {
 		
 		var formObj = document.form;
 		 
 		if (!validateForm(sheetObjects[1],formObj,IBSEARCH)) {
			return;
		}
 		
 		//vsl cd를 |로 세팅
    	var vslCdList = makeVslCd(sheetObjects[3]);
 		
        var sUrl = "/hanjin/ESM_PRI_6039.do?svc_scp_cd=" + getSvcScpCd() + "&svc_scp_nm=" + formObj.svc_scp_nm.value + "&vslCdList=" + vslCdList;
		
        var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6039", 600, 420, true);
       
        var  sCd = "";
        
        if (rtnVal == "O") {
            
            for (var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].LastRow; i++) {

                if (sheetObjects[3].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[3].CellValue(i, "vsl_slan_cd");

                sCd += "; ";
            }
            
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(";");
            	sCd = sCd.substring(0, lastIdx);
            }

            formObj.vsl_slan_cds.value = sCd;
        }    
    }
        
        
    /**
 	 * SvcLane popup 호출시 현재 세팅한 VslCd를 |로 연결  세팅 <br>
     * <br><b>Example :</b>
     * <pre>
     *    makeVslCd(sheetObj)
     * </pre>
     * @param {sheetObj} sheetObj 
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function makeVslCd(sheetObj) {
        
        var sStr = "";
        for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            if (sheetObj.RowStatus(i) == "D") {
                continue;
            }
            sStr += sheetObj.CellValue(i, "vsl_slan_cd");
            
            if(i < sheetObj.LastRow) {
            	sStr += "|";
            }
            
        }
        return sStr;
        
    }   
 	
 	
 	/**
 	 * popup 창에서 선택한 row 를 hidden grid에 세팅<br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetXml(sXml, sheetNo)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} sheetNo 쉬트 일련번호    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function setSheetXml(sXml, sheetNo) {
        var formObj = document.form;
        var sCol = "";
        var sValue = "";
        var bAppendMode = 0;
        
        sheetObjects[3].LoadSearchXml(sXml, false);
	     
        ComPriXml2Sheet(sheetObjects[3], sXml, bAppendMode, sCol, sValue);
        
    }
 	
 	
 	/**
 	 * search 시 체크 된 vsl_slan_cd 항목을 쉼표로 조합 <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetXml(sXml, sheetNo)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} sheetNo 쉬트 일련번호    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function makeInParam(formObj) {
 		
 		var vsl_slan_cd = "";
 		
 		if(ComIsEmpty(formObj.vsl_slan_cds.value)) {
 			formObj.vsl_slan_cd.value = vsl_slan_cd;
 			return;
 		}
 		
 		var vsl_slan_cds = ComTrimAll(formObj.vsl_slan_cds.value).split(";");

 		for(var i=0;i<vsl_slan_cds.length;i++){
 			
 			vsl_slan_cd = vsl_slan_cd + "'" + vsl_slan_cds[i] + "'";	

 			if(i < (vsl_slan_cds.length-1)) {
 			    
 				vsl_slan_cd = vsl_slan_cd + ",";
 		    }
 		}
 		
 		formObj.vsl_slan_cd.value = vsl_slan_cd;
 		
	}
 	
 	/**
 	 * Commodity popup 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *    popupCommodity()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */ 
	function popupCommodity()
	{
		var formObj = document.form;
		
		if (!validateForm(sheetObjects[1],formObj,IBSEARCH)) {
			return;
		}
		
		var sUrl = "/hanjin/ESM_PRI_4027.do?commodity_cmd=CR&grp_cd=5&svc_scp_cd="+getSvcScpCd()+"&prc_cmdt_tp_cd=C";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
		if (rtnVal != null){
			formObj.prc_cmdt_def_cd.value = rtnVal.cd;
			
		}
		
	}
	
	/**
 	 * Origin popup 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *    popupOrigin()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function popupOrigin()
	{
		var formObj = document.form;
		
//		if (!validateForm(sheetObjects[1],formObj,IBSEARCH)) {
//			return;
//		}
		
		var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_CMPB + "&location_cmd=L&svc_scp_cd=" + getSvcScpCd()+"&loc_tp_cd=L";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null){
			formObj.origin_cd.value = rtnVal.cd;
		}
		
	}
	
	
	/**
 	 * Dest popup 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *    popupDest()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */	 
	function popupDest()
	{
		var formObj = document.form;
		
//		if (!validateForm(sheetObjects[1],formObj,IBSEARCH)) {
//			return;
//		}
			
		var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_CMPB + "&location_cmd=L&svc_scp_cd=" + getSvcScpCd()+"&loc_tp_cd=L";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null){
			formObj.dest_cd.value = rtnVal.cd;
		}
		
	}
	
	
	
	/**
 	 *  조회조건의 수를 카운트하여 세팅- 조회시 param으로 활용<br>
     * <br><b>Example :</b>
     * <pre>
     *    setSearchDetailConditionCount(formObj)
     * </pre>
     * @param {formObj} formObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function setSearchDetailConditionCount(formObj)
	{
		//svc lane
		var vsl_slan_cd = formObj.vsl_slan_cd.value;
		//prc_cmdt_def_cd
		var prc_cmdt_def_cd = formObj.prc_cmdt_def_cd.value;
		//origin_cd
		var origin_cd = formObj.origin_cd.value;
		//dest_cd
		var dest_cd = formObj.dest_cd.value;
		//r term
		var rTerm = getRRcvDeTermCd();
		//d term
		var dTerm = getDRcvDeTermCd();
		//per
		var per = getRatUtCd();
		//cargo
		var cargo = getPrcCgoTpCd();
		
		if(!ComIsEmpty(vsl_slan_cd) || !ComIsEmpty(prc_cmdt_def_cd) || !ComIsEmpty(origin_cd) ||
		   !ComIsEmpty(dest_cd) || !ComIsEmpty(rTerm) || !ComIsEmpty(dTerm) ||
		   !ComIsEmpty(per) || !ComIsEmpty(cargo) ) {
			
			formObj.search_count.value = "Y";
		}
		
	}
 	
	
	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if(selectedRow == -1) return;
		
		if (OldRow != NewRow) {
			doRowChange(OldRow, NewRow, OldCol, NewCol);
		}	
    }
 
	/**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 선택한 행에 대한 디테일 정보를 조회한다.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
         var formObj = document.form;
   
         formObj.cre_ofc_cd.value = sheetObjects[1].CellValue(NewRow, "cre_ofc_cd");
         formObj.prs_cust_tp_cd.value = sheetObjects[1].CellValue(NewRow, "prs_cust_tp_cd");
         formObj.gline_seq.value = sheetObjects[1].CellValue(NewRow, "gline_seq");
    	 formObj.bse_seq.value = sheetObjects[1].CellValue(NewRow, "bse_seq");
         
    	 if(formObj.bse_seq.value == "undefined" || ComIsEmpty(formObj.bse_seq.value)) {
        	 formObj.cre_ofc_cd.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"cre_ofc_cd");
        	 formObj.gline_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"gline_seq");
         	 formObj.prs_cust_tp_cd.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"prs_cust_tp_cd");
         	formObj.bse_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"bse_seq");
         }

         doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
	    
         selectedRow = sheetObjects[1].SelectRow; 
        
    }
	
	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet4_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
 		var vsl_slan_cd = "";
        if (ErrMsg == "") {
        		
        	var arrData  = new Array();
        	var arrXml = ComPriSheet2Xml(sheetObj, "vsl_slan_cd");
        	arrData = ComPriXml2Array(arrXml, "vsl_slan_cd");

        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
        		
        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
	        		
	        		sheetObjects[2].CellValue2(i+1,"vsl_slan_cd") = "";
	        		
	        		deleteRowEmpty(sheetObjects[2], i+1);
	        	}
        		
        		
	        	for(var i=0; i<arrData.length; i++) {
	        		var insertCount = arrData.length - sheetObjects[2].RowCount;

	        		if(insertCount > 0) {
	        			sheetObjects[2].DataInsert();
	        			insertCount--;
	        		}	
//	        		vsl_slan_cd += arrData[i];
	        		sheetObjects[2].CellValue2(i+1,"vsl_slan_cd") = arrData[i];
	        	}
	        	
        	}
//        	sheetObjects[2].SelectCell(1,"vsl_slan_cd");
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet5_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
        		
        	var arrData  = new Array();
        	var arrXml = ComPriSheet2Xml(sheetObj, "prc_cmdt_def_nm");
        	arrData = ComPriXml2Array(arrXml, "prc_cmdt_def_nm");

        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
        		
        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
	        		
	        		sheetObjects[2].CellValue2(i+1,"prc_cmdt_def_nm") = "";
	        		
	        		deleteRowEmpty(sheetObjects[2], i+1);
	        	}
        		
	        	for(var i=0; i<arrData.length; i++) {
	        		var insertCount = arrData.length - sheetObjects[2].RowCount;

	        		if(insertCount > 0) {
	        			sheetObjects[2].DataInsert();
	        			insertCount--;
	        		}
	        		sheetObjects[2].CellValue2(i+1,"prc_cmdt_def_nm") = arrData[i];
	        	}
	        	
	        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
        	}
        	
//        	sheetObjects[2].SelectCell(1,"vsl_slan_cd");
        
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet6_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
       		
        	var arrData  = new Array();
        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_pnt_loc_def_nm|rcv_de_term_nm");
        	arrData = ComPriXml2Array(arrXml, "rout_pnt_loc_def_nm|rcv_de_term_nm");

        	if(typeof arrData != "undefined" && arrData != null) {
//	        		sheetObjects[2].RemoveAll();
        		
        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
	        		
	        		sheetObjects[2].CellValue2(i+1,"org_rout_pnt_loc_def_nm") = "";
	        		
	        		deleteRowEmpty(sheetObjects[2], i+1);
	        	}
        		
        		var rcv_de_term_nm = "";

	        	for(var i=0; i<arrData.length; i++) {
	        		var insertCount = arrData.length - sheetObjects[2].RowCount;

	        		if(insertCount > 0) {
	        			sheetObjects[2].DataInsert();
	        			insertCount--;
	        		}
	        		//rcv_de_term_nm
	        		if(arrData[i][1] != "" && arrData[i][1] != null && arrData[i][1] != "undefined") 
	        			rcv_de_term_nm = "(" + arrData[i][1] + ")";
	        		
	        			sheetObjects[2].CellValue2(i+1,"org_rout_pnt_loc_def_nm") = arrData[i][0] + rcv_de_term_nm;
	        			
	        		
	        	}
	        	
	        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
        	}

//        	sheetObjects[2].SelectCell(1,"vsl_slan_cd");
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet7_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
        		
        	var arrData  = new Array();
        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_via_port_def_nm");
        	arrData = ComPriXml2Array(arrXml, "rout_via_port_def_nm");

        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
        		
        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
	        		
	        		sheetObjects[2].CellValue2(i+1,"org_rout_via_port_def_nm") = "";
	        		
	        		deleteRowEmpty(sheetObjects[2], i+1);
	        	}
        		
	        	for(var i=0; i<arrData.length; i++) {
	        		var insertCount = arrData.length - sheetObjects[2].RowCount;

	        		if(insertCount > 0) {
	        			sheetObjects[2].DataInsert();
	        			insertCount--;
	        		}
	        		sheetObjects[2].CellValue2(i+1,"org_rout_via_port_def_nm") = arrData[i];
	        	}
	        	
	        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
        	}	
//        	sheetObjects[2].SelectCell(1,"vsl_slan_cd");
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet8_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
 		
	   	if (ErrMsg == "") {
    		var arrData  = new Array();
        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_via_port_def_nm");
        	arrData = ComPriXml2Array(arrXml, "rout_via_port_def_nm");

        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
        		
        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
	        		
	        		sheetObjects[2].CellValue2(i+1,"dest_rout_via_port_def_nm") = "";
	        		
	        		deleteRowEmpty(sheetObjects[2], i+1);
	        	}
        		
	        	for(var i=0; i<arrData.length; i++) {
	        		var insertCount = arrData.length - sheetObjects[2].RowCount;

	        		if(insertCount > 0) {
	        			sheetObjects[2].DataInsert();
	        			insertCount--;
	        		}
	        		sheetObjects[2].CellValue2(i+1,"dest_rout_via_port_def_nm") = arrData[i];
	        	}
	        	
	        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
        	}
//        	sheetObjects[2].SelectCell(1,"vsl_slan_cd");
	    }
          
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.)<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet9_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
 		
 		if (ErrMsg == "") {

    		var arrData  = new Array();
        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_pnt_loc_def_nm|rcv_de_term_nm");
        	arrData = ComPriXml2Array(arrXml, "rout_pnt_loc_def_nm|rcv_de_term_nm");
        	
        	if(typeof arrData != "undefined") {
        		
//	        		sheetObjects[2].RemoveAll();
        		
        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
	        		
	        		sheetObjects[2].CellValue2(i+1,"dest_rout_pnt_loc_def_nm") = "";
	        		
	        		deleteRowEmpty(sheetObjects[2], i+1);
	        	}

	        	for(var i=0; i<arrData.length; i++) {
	        		var insertCount = arrData.length - sheetObjects[2].RowCount;

	        		if(insertCount > 0) {
	        			sheetObjects[2].DataInsert();
	        			insertCount--;
	        		}

	        		var rcv_de_term_nm = "";
	        		if(arrData[i][1] != "" && arrData[i][1] != null && arrData[i][1] != "undefined") 
	        			rcv_de_term_nm = "(" + arrData[i][1] + ")";
	        		
	        			sheetObjects[2].CellValue2(i+1,"dest_rout_pnt_loc_def_nm") = arrData[i][0] + rcv_de_term_nm;
	        	}
	        	
	        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
        	}
//        	sheetObjects[2].SelectCell(1,"vsl_slan_cd");
 		}		
 		sheetObjects[2].SelectCell(1,"Seq");
 		selectedRow = -1;
 		sheetObjects[1].SelectCell(selectedRow,"ibflag");
 		
// 		sheetObjects[1].SelectRow = selectedRow;
    }
 	
 	/**
     * description sheet에서 로우의 데이터가 없는 경우 row delete.<br>
     * <br><b>Example :</b>
     * <pre>
     *    deleteRowEmpty(sheetObj, Row)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {int} Row  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function deleteRowEmpty(sheetObj, Row) {
 		
 		if(ComIsEmpty(sheetObj.CellValue(Row,"vsl_slan_cd")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"prc_cmdt_def_nm")) &&		
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_pnt_loc_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_via_port_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_via_port_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_pnt_loc_def_nm")) ) {
     			
 			sheetObj.RowDelete(Row, false);
     	}
 	}
 	
 	
 	/**
  	 * window가 resize 시 sheet col width를 재조정한다.<br>
  	 * <br><b>Example :</b>
     * <pre>
     *    onResize="sheetColResize();"
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
  	function sheetColResize() {

  		var sheetObj1 = sheetObjects[1];
  		var sheetObj2 = sheetObjects[2];
  		
  		sheetObj1.FitColWidth("0|3.9|6.3|6|7|7|6|6|7|4|4|4|7|6|5|5|7|5.8|0|0|0|0|0");
  		sheetObj2.FitColWidth("0|0|0|0|6|25|18.5|16|16|16.5");
  		
  		
  	}
  	
  	
  	/**
     * search 시 PER TYPE을 MAPPING 하여 쉼표로 조합한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     makeInParamPerType(formObj)
     * </pre>
     * @param {form} formObj
     * @return 없음<br>
     * @author 이승준
     * @version 2009.04.17
     */
	 	function makeInParamPerType(formObj) {
	 		
	 		var rat_ut_cd = "";
	 		
	 		if(getRatUtCd() == '20') rat_ut_cd = "\'D2\', \'F2\', \'O2\', \'P2\', \'Q2\', \'R2\', \'S2\', \'T2\'";
	 		else if(getRatUtCd() == '40') rat_ut_cd = "\'D4\', \'F4\', \'O4\', \'P4\', \'Q4\', \'R4\', \'S4\', \'T4\'";
	 		else if(getRatUtCd() == 'HC') rat_ut_cd = "\'D5\', \'F5\', \'R5\'";
	 		else if(getRatUtCd() == '45') rat_ut_cd = "\'D7\', \'R7\'";
	 		else if(getRatUtCd() == '') rat_ut_cd = "";
	 		else rat_ut_cd = "\'" + getRatUtCd() + "\'";
	 		
	 		formObj.rat_ut_cd.value = rat_ut_cd;

		}

	/* 개발자 작업  끝 */