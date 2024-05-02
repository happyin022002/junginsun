/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0712.js
*@FileTitle : RDN Receipt by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.31
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
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
     * @class esm_bkg_0712 : esm_bkg_0712 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0712() {
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
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    //search xml
    var searchXml;
    
    //event status
    var eventStatus = "";

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
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

    					case "btn_Retrieve":
    						//doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    						if(comboObjects[0].GetCount () == 0 || getRdnNoTxt() != formObject.rdn_no) {
    							setRdnCd();
    							
    						} else {
    							//removeSearch(formObject);
    							doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    						}
    						break;
    						
    					case "btn_New":
    						removeAll(document.form);
    						break;
    						
    					case "btn_Save":
    						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
    						break;
    						
    					case "btn_Accept":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
    						break;
    					
    					case "btn_ReviseRequest":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
    						break;
    						
    					case "btn_CancelRequest":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
    						break;
    						
    					case "btn_Attachment":
    						var rdn_no = formObject.rdn_no.value;
    						var rvis_seq = formObject.rvis_seq.value;
    						var edit_flg = "Y";
//    						if(){
//    							edit_flg = "N";
//    						}
    						
    						var url = "ESM_BKG_1408.do?rdn_no="+rdn_no+"&rvis_seq="+rvis_seq+"&edit_flg="+edit_flg;
    						ComOpenWindowCenter(url, "ESM_BKG_1408", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    						break;
    						
    					case "btn_Print":
    						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
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

     		for(var k = 0; k < comboObjects.length; k++){
     	        initCombo(comboObjects[k], k + 1);
     	    }
        	 
        	 for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
     		axon_event.addListenerForm('keypress', 'obj_keypress', document.form);    		
     	    //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);     		
			axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	        			
     	    
     	    //doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
    		
    		setSumTxt(sheetObjects[1]);
    		
    		resetButton();
    		
    		comboObjects[0].focus();
    		
    		 //pop으로 호출시 rdn_no로 로딩시 조회
     	    if(document.form.rdn_no_pop.value != "") {
    			var rdn_no = document.form.rdn_no_pop.value.toUpperCase();
    			var code = comboObjects[0].FindIndex(rdn_no, 0);
    			if(code == "-1") {	
    				eventStatus = "INIT";
    				comboObjects[0].InsertItem(0,rdn_no);
    				comboObjects[0].Text = rdn_no;
    				eventStatus = "";
    			}	
     	    	setRdnCd();
     	    }
     	    
     	    //김대호 - rd 테스트
     	    //form.bl_no.value = "AARE01025401";
     	    //setRdnCd();
    		
    	}
        
 /** 
 * Object 의 Keypress 이벤트핸들러 <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  없음  
 * @return 없음
 * @see #
 * @author 김대호
 * @version 2010.01.04
 */ 
 function obj_keypress(){
 	var obj = event.srcElement;
 	var objName = obj.getAttribute("name");

  	if(obj.dataformat == null) return;
  	window.defaultStatus = obj.dataformat;
 	switch(obj.dataformat){
  	case "ymd": //날짜 입력하기
 		ComKeyOnlyNumber(obj,"-"); 
 		break;
  	case "int": //숫자만 입력
  	case "number": //숫자만 입력 	
  		ComKeyOnlyNumber(obj);
  		break;
  	case "engup":
  		ComKeyOnlyAlphabet('upper');
  		break;
  	case "uppernum":
  		ComKeyOnlyAlphabet('uppernum');
  		break;
  	default:
  		//ComKeyOnlyNumber(obj);
  		break;
 	}

  	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	switch(objName){
  	case "bl_no":
	 	if(ComIsEmpty(obj.value)) { return; }
	  	if(keyValue == 13 && obj.value.length == 12){
	 		var btnObj = document.getElementById("btn_retrieve");
	 		if (btnObj) { btnObj.fireEvent("onclick"); }
	  	}
 		break;
 	}
 }         
        
 /** 
 * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
 * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  없음  
 * @return 없음
 * @see #
 * @author 김대호
 * @version 2010.01.04
 */ 
 function obj_deactivate() {
 	var form = document.form;
 	var formObj = event.srcElement;
     var srcName = formObj.getAttribute("name");
     switch(srcName) {
 		case "bl_no":
 		//case "bkg_corr_no":
         	if(ComIsEmpty(formObj.value)) return;
         	var msg = formObj.caption;
 			if(formObj.value.length != formObj.maxLength) {
 				ComShowCodeMessage("BKG95018", msg, formObj.maxLength);
 				ComSetFocus(formObj);
 				return false;
 			} 
 			break;
 		case "inv_no":
 		case "vvd_cd":
 			break;
 		default :
 			ComChkObjValid(formObj);
 			break;
 	}
 }
 
        /**
         * bl_no로 콤보를 조회 후 첫번째 값으로 세팅한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     setRdnCd();
         * </pre>
         * @param 업음
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function setRdnCd() {
        	
        	var formObject = document.form;
        	
        	if (validateForm(sheetObjects[0],formObject,IBSEARCH)) {
        		//alert("setRdnCd : " + formObject.rdn_no.value)
	        	
				//rdn combo의 값을 hidden에 세팅
				//formObject.rdn_no.value = comboObjects[0].Code;
				
	        	formObject.f_cmd.value = SEARCH01;
		 		searchXml = sheetObjects[0].GetSearchXml("ESM_BKG_0426GS.do", FormQueryString(formObject));
		 		
		 		
		 		//화면 리셋
				removeSearch(formObject);
				
		 		
		 		ComXml2ComboItem(searchXml, formObject.rdn_no_cd, "rdn_no", "rdn_no");
		 		
		 		//alert(comboObjects[0].GetCount ())
		 		if(comboObjects[0].GetCount () > 0) {
		 			comboObjects[0].Index = "-1";
		 			comboObjects[0].Index = "0";
		 		} else {
		 			ComShowCodeMessage("BKG95010");
		 		}
		 		
//		 		formObject.rdn_no.value = code;
// 				
//   		 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        	}
        }	
        
        
        /**
         * RDN No로 조회한 후 리턴된 xml을 화면에 세팅한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     setSearchData(searchXml, formObj)
         * </pre>
         * @param {String} searchXml
         * @param {form} formObj
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function setSearchData(searchXml, formObj) {
        	
        	var arrData = ComBkgXml2Array(searchXml,  "rdn_no|rvis_seq|iss_ofc_cd|rdn_sts_cd|rdn_iss_dt" +
        					"|sts_upd_dt|rct_rhq_cd|rct_ofc_cd|respb_ofc_cd|umch_tp_cd" +  //5
        					"|umch_sub_tp_cd|rdn_iss_rsn_cd|sc_rfa_no|umch_rmk|rdn_rmk" +  //10
        					"|rdn_sts_nm|bkg_no|bkg_no_split|bkg_corr_no|prog_seq" +       //15
        					"|bl_no|respb_rhq_cd|rev_aud_tool_cd|ctrt_tp_cd|rdn_knd_cd" +  //20
        					"|inv_no|vvd_cd|n3pty_no|atch_file_lnk_id|file_cnt");       
        	
        	
        	formObj.rdn_no.value		= arrData[0][0];
        	formObj.rvis_seq.value		= arrData[0][1];
        	
        	formObj.iss_ofc_cd.value 	= arrData[0][2];
			formObj.rdn_sts_cd.value  	= arrData[0][3];
			formObj.rdn_iss_dt.value 	= arrData[0][4];
			formObj.sts_upd_dt.value 	= arrData[0][5];
		
			//조직도 		
			formObj.rct_rhq_cd.value 	= arrData[0][6];
			formObj.rct_ofc_cd.value 	= arrData[0][7];
			formObj.respb_ofc_cd.value 	= arrData[0][8];
			
			//unmatch combo1
			formObj.umch_tp_cd.value    = arrData[0][9];
			formObj.umch_sub_tp_cd_hidden.value= arrData[0][10];
			formObj.rdn_iss_rsn_cd.value= arrData[0][11];
			
			formObj.sc_rfa_no.value 	= arrData[0][12];
			formObj.umch_rmk.value 		= arrData[0][13];
			formObj.rdn_rmk.value 		= arrData[0][14];
			formObj.rdn_sts_nm.value 	= arrData[0][15];
			
			//BOOKING
			formObj.bkg_no.value 		= arrData[0][16];
			formObj.bkg_no_split.value 	= arrData[0][17];
			formObj.bkg_corr_no.value 	= arrData[0][18];
			
			//prog_seq
			formObj.prog_seq.value 		= arrData[0][19];
			
			//bl_no
			formObj.bl_no.value 		= arrData[0][20];
			
			//respb_rhq_cd
			formObj.respb_rhq_cd.value 		= arrData[0][21];
			//rev_aud_tool_cd
			formObj.rev_aud_tool_cd.value 		= arrData[0][22];
			formObj.ctrt_tp_cd.value 	= arrData[0][23];
			

			formObj.rdn_knd_cd.value 	= arrData[0][24];
			formObj.inv_no.value 	    = arrData[0][25];
			formObj.vvd_cd.value 	    = arrData[0][26];
			formObj.n3pty_no.value 	= arrData[0][27];
			formObj.atch_file_lnk_id.value 	= arrData[0][28];
			formObj.file_cnt.value 	    = arrData[0][29];
			
			return arrData;
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
            case "rdn_no_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 1);    // 영문대문자만 입력 + 숫자만입력
                    MaxLength = 10;      // 10자리만 입력
                }
                break;
 
            }
      	}
        
        /**
         * comboObjects[0]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRdnNoCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRdnNoCd() {
      		return comboObjects[0].Code;
      	}
        
        /**
         * comboObjects[0]의 Text값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRdnNoTxt();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRdnNoTxt() {
      		return comboObjects[0].Text;
      	}
        

        /**
         * rdn_no combo 변경시 활성화됨<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    필수,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function rdn_no_cd_OnChange(comboObj, code, text) {
        	
        	if(eventStatus == "INIT") return;
        	
     		if(comboObjects[0].GetCount () > 0 && comboObjects[0].Index != "-1") {
     			//alert("zzzz")
     			if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
     				var formObj = document.form;
     				 				
     				formObj.rdn_no.value = code;
     				
       		 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
   		 				
     				
     			} 
     		 
     		} 
     		
       }
        
        /**
         * rdn_no combo 포커스 아웃시 동작함<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */
        function rdn_no_cd_OnBlur(comboObj) {
        	
        	if(ComIsEmpty(comboObj.Text)) return;
        	
			if(comboObj.Text.length != 9 && comboObj.Text.length != 10) {
				ComShowCodeMessage("BKG95018","RDN No\'s","10");
				comboObj.focus();
				return;
			} 
			
			//var rdn_no = comboObj.Text.substr(0,3).toUpperCase() + comboObj.Text.substr(3,6)
			var rdn_no = comboObj.Text.toUpperCase()
			
			var code = comboObj.FindIndex(rdn_no, 0);
			
			if(code == "-1") {	
				//combo item insert
				eventStatus = "INIT";
				comboObj.InsertItem(0,rdn_no);
				comboObj.Text = rdn_no;
				//document.form.bl_no.focus();
				eventStatus = "";
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
            var sheetID = sheetObj.id;
            switch(sheetID) {
            
            		case "sheet0":      //hidden 
	    	             with (sheetObj) {
	    	            	 // Host정보 설정[필수][HostIp, Port, PagePath]
	    	 				 if (location.hostname != "")
	    	 					InitHostInfo(location.hostname, location.port, page_path);
	    											
	    	             }
	    	             break; 
            
            		case "sheet1":      //sheet1 init
    					with (sheetObj) {

    						// 높이 설정
    						style.height = 82;
    						//전체 너비 설정
    						SheetWidth = mainTable.clientWidth;
    						
    						//Host정보 설정[필수][HostIp, Port, PagePath]
    						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    						
    						//전체Merge 종류 [선택, Default msNone]
    						MergeSheet = msNone;
    						
    						//전체Edit 허용 여부 [선택, Default false]
    						Editable = false;
    						
    						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    						InitRowInfo(1, 1, 2, 100);
    						
    						var HeadTitle = "|Currency|Amount|USD Amount|rdn_no|rvis_seq";
    						
    						var headCount = ComCountHeadTitle(HeadTitle);
    						
    						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    						InitColumnInfo(headCount, 0, 0, true);
    						
    						// 해더에서 처리할 수 있는 각종 기능을 설정한다
    						InitHeadMode(true, true, false, true, false,false);
    						
    						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    						InitHeadRow(0, HeadTitle, true);
    						
    						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    						InitDataProperty(0, cnt++ ,  dtHiddenStatus, 30,    daCenter,   false,  "ibflag");
    						InitDataProperty(0, cnt++ ,  dtData,		 120,	daCenter,	true,	"curr_cd",		false,	"",	 dfNone,   0,	true,	true);
    						InitDataProperty(0, cnt++ ,  dtData,	 	 155,	daRight,	true,	"dr_amt",		false,	"",	 dfFloat,  2,	true,	true);
    						InitDataProperty(0, cnt++ ,  dtAutoSumEx,	 155,	daRight,	true,	"usd_amount",	false,	"",	 dfFloat,  2,	true,	true);
    						InitDataProperty(0, cnt++,   dtHidden, 		 90, 	daLeft,     false, 	"rdn_no",       false,  "",  dfNone,   0, 	false, false);
    	 					InitDataProperty(0, cnt++,   dtHidden, 		 90, 	daLeft,     false, 	"rvis_seq",  	false,  "",  dfNone,   0, 	false, false);
    						
    	 					InitDataValid(0,  "curr_cd",	vtEngUpOnly);		// 영문대문자만 입력
    						CountPosition = 0;				
    					}
    					break;

    		}
    	}

    	/**
         * Sheet관련 프로세스 처리 <br>
         * <br><b>Example :</b>
         * <pre>
         *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {form} formObj 필수 html form object
         * @param {int} sAction 필수 프로세스 플래그 상수
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
            case IBSEARCH:      //조회
            	//현재 이벤트를 전역변수로 세팅
        		eventStatus = "IBSEARCH";
        		if (validateForm(sheetObj,formObj,sAction)) {
        		   if ( sheetObj.id == "sheet0") {
        			   formObj.f_cmd.value = SEARCH04;
					   var sXml = sheetObj.GetSearchXml("ESM_BKG_0712GS.do", FormQueryString(formObj));
	       			   
					   var arrData = setSearchData(sXml, formObj);
	       			   
	       			   if (arrData != null && arrData.length > 0) {
	       				 	
	       					//키값이 있으면
	       					if (formObj.rdn_no.value != "" && formObj.rvis_seq.value != "") {
		       					//alert(formObj.rdn_no.value);
		       					formObj.f_cmd.value = SEARCH03;
		       					sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0712GS.do", FormQueryString(formObj));
		       					
		       					if(typeof ComGetEtcData(sXml, "regional_rmk") != "undefined" && ComGetEtcData(sXml, "regional_rmk") != "") {
		       						formObj.rdn_rmk.value = ComGetEtcData(sXml, "regional_rmk"); 
		       		 			}
		       					if(typeof ComGetEtcData(sXml, "receipt_rmk") != "undefined" && ComGetEtcData(sXml, "receipt_rmk") != "") {
		       						formObj.receiver_rmk.value = ComGetEtcData(sXml, "receipt_rmk");
		       					}
		       					
		        	    		ComOpenWait(true);		
		       					sheetObjects[1].WaitImageVisible = false;
		       					
		       					formObj.f_cmd.value = SEARCH02;
		       					sheetObjects[1].DoSearch("ESM_BKG_0712GS.do", FormQueryString(formObj));
		       					
		        	    		ComOpenWait(false);				       					
	       					}	
	       					
	       			   } else {
	       				   ComShowCodeMessage("BKG95010");
	       			   }
	       			  
	       			   ComBtnEnable("btn_Print");
	       			   ComBtnEnable("btn_Attachment");
	       			   
	       			   //Attachment 있는 경우 파란색
	       			   if ("0" == ComGetObjValue(formObj.file_cnt)) {
	       				   document.getElementById('btn_Attachment').style.color = '';
	       			   } else {
	       				   document.getElementById('btn_Attachment').style.color = 'blue';
	       			   }	       			
        		   } 
	        	}    
        		eventStatus = "";
                break;

			case IBSAVE:        //저장
				
 				if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}
 				
 				if (!ComBkgProcessYn("save")) return;

 				formObj.f_cmd.value = MULTI01;
				
				var sParam = FormQueryString(formObj);
				var sParamSheet1 = sheetObjects[1].GetSaveString();	
				
				if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
					return;
				}
				
				sParam += "&" + sParamSheet1;
				
	    		ComOpenWait(true);		

				var sXml = sheetObj.GetSaveXml("ESM_BKG_0712GS.do", sParam);
				sheetObjects[1].LoadSaveXml(sXml);
				
	    		ComOpenWait(false);		
				
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComShowCodeMessage("BKG95033"); // "Saved."
					//콤보 세팅
					//setRdnCd();
					
					formObj.inv_no.value = '';
					formObj.vvd_cd.value = '';				
					
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
				
        		break;
        		
        	
			case IBSEARCH_ASYNC01:        //Accept
				
   				 if (validateForm(sheetObj,document.form,sAction)) {
   					if (ComShowCodeConfirm("BKG95003", "accept the RDN")) {
   						
   						ComOpenWait(true);		   							
   						
   						if(formObj.umch_tp_cd.value != "Other (H/O Use)" && formObj.umch_tp_cd.value != "Non-Charged B/L" ) {
   							
   							if(formObj.bkg_corr_no.value != ""){
   								// CA No 확인
   		   						formObj.f_cmd.value = SEARCH06;
   		   						var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0712GS.do", FormQueryString(formObj)); 	
   		   						
   		   						if(ComGetEtcData(sXml, "count_bkg_corr_no") == "0") {
   		   							ComShowCodeMessage("BKG95042");
   		   							formObj.bkg_corr_no.focus();
   		   							ComOpenWait(false);
   		   							return false;
   		   						}
   							}
   							
   							if(formObj.n3pty_no.value != ""){
   								// TPB Invoice 확인
   								formObj.f_cmd.value = SEARCH07;
   		   						var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0712GS.do", FormQueryString(formObj)); 	
   		   						
   		   						if(ComGetEtcData(sXml, "count_tpb_no") == "0") {
   		   							ComShowCodeMessage("BKG00651", "TPB Number"); // "{?msg1} is invalid."
   		   							formObj.bkg_corr_no.focus();
   		   							ComOpenWait(false);
   		   							return false;
   		   						}
   								
   							}
   								   						
   						}
   						
   						
   						

   						// Accept
   						formObj.f_cmd.value = MULTI02;
   						var sParam = FormQueryString(formObj);

   						var sXml = sheetObj.GetSaveXml("ESM_BKG_0712GS.do", sParam);
   						
   			    		ComOpenWait(false);		
   						
						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
							ComShowCodeMessage("BKG95041"); // msgs['BKG95041'] = "Accepted."
	   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}
   							
   					}	
   				 }	
   					
   				 break;		
   				 
   				 
			case IBSEARCH_ASYNC02:        //Rivise Request
   				 if (validateForm(sheetObj,document.form,sAction)) {
   					if (ComShowCodeConfirm("BKG95003", "request the revise of the RDN")) {
   						
   						formObj.f_cmd.value = MULTI03;
   						
   						var sParam = FormQueryString(formObj);
   	
   						ComOpenWait(true);		
   						
   						var sXml = sheetObj.GetSaveXml("ESM_BKG_0712GS.do", sParam);
   						
   						ComOpenWait(false);		   						

   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
							ComShowCodeMessage("BKG95040"); // "Requested."
	   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}

   					}	
   				 }	
   					
   				 break;	
   				 
   				 
			case IBSEARCH_ASYNC03:        //Cancel Request
   				 if (validateForm(sheetObj,document.form,sAction)) {
   					if (ComShowCodeConfirm("BKG95003", "request the cancel of the RDN")) {
   						
   						formObj.f_cmd.value = MULTI04;
   						
   						var sParam = FormQueryString(formObj);
   	
   						ComOpenWait(true);		
   						
   						var sXml = sheetObj.GetSaveXml("ESM_BKG_0712GS.do", sParam);
   						
   						ComOpenWait(false);		
   						
   						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
							ComShowCodeMessage("BKG95040"); // "Requested."
	   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}
   						
   					}	
   				 }	
   					
   				 break;
   				 
			case IBSEARCH_ASYNC04:
				var popParams = "progId=ESM_BKG_0712";
				comRASCallPop("ESM_BKG_5001", "ESM_BKG_0712", popParams, "");
				break;
   				 
            }
            
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
   	 			
	   	 		if (ComIsEmpty(getRdnNoTxt()) && ComIsEmpty(formObj.bl_no) && ComIsEmpty(formObj.inv_no) && ComIsEmpty(formObj.vvd_cd)) {
					ComBkgInputValueFailed("input","RDN No, BL No, INV No or VVD Code",formObj.rdn_no_cd);
					return false;
		 		}
		   	 	if (!ComIsEmpty(getRdnNoTxt()) && getRdnNoTxt().length != 9 && getRdnNoTxt().length != 10) {
		   	 		ComShowCodeMessage("BKG95018","RDN No\'s","9");
		   	 		comboObjects[0].focus();
					return false;
	 			} 
	   	 		
		   	 	if (!ComIsEmpty(formObj.bl_no) && formObj.bl_no.value.length != 12) {
		   	 		ComShowCodeMessage("BKG95018","BL No\'s","12");
	   	 			formObj.bl_no.focus();
					return false;
	 			}
		   	 	
		   	 	if (!ComIsEmpty(getRdnNoTxt()) && !ComIsEmpty(formObj.bl_no)) {
		   	 		formObj.bl_no.value = "";
			 	}
		   	 	
		   	 	
 				//rdn 콤보의 값을 세팅
 				formObj.rdn_no.value = getRdnNoTxt();
 				//alert(formObj.rdn_no.value);
   	 			
	   	 		//formatRdnNo(formObj.rdn_no);
   				return true;
   	 			break;
   	 	
   	 		case IBSAVE: // 저장
   	 			var rdn_sts_cd = formObj.rdn_sts_cd.value;
   	 			//저장가능 상태
   	 			if(rdn_sts_cd == "AC" || rdn_sts_cd == "CR" || rdn_sts_cd == "RR") {
   	 				
	   	 			if (ComIsEmpty(formObj.bl_no)) {
						ComBkgInputValueFailed("input","BL No",formObj.bl_no);
						return false;
	   	 			}
	   	 			
		   	 		if (ComIsEmpty(formObj.bkg_no)) {
		   	 		    ComShowCodeMessage("BKG95009","BL No");
		   	 			formObj.bl_no.focus();
						return false;
	   	 			}
		   	 		
			   	 	if (formObj.bl_no.value.length != 12) {
			   	 		ComShowCodeMessage("BKG95018","BL No\'s","12");
		   	 			formObj.bl_no.focus();
						return false;
	   	 			}
	    			
	   	 			if (ComIsEmpty(formObj.receiver_rmk)) {
	   	 				ComBkgInputValueFailed("input","Remark",formObj.receiver_rmk);
	   	 				return false;
	   	 			}
	   	 			
	   	 			//formatRdnNo(formObj.rdn_no);
	   	 			
       	  		} else {
       	  			return false;
       	  		}	
   				return true;
   	 			break;
   	 			
        	case IBSEARCH_ASYNC01: // ACCEPT
	 			var rdn_sts_cd = formObj.rdn_sts_cd.value;
	 			//ACCEPT 가능 상태
	 			if(rdn_sts_cd == "IS" || rdn_sts_cd == "RV"){
	 				if(formObj.umch_tp_cd.value == "Other (H/O Use)") {
	 					return true;
	 				} else if(formObj.umch_tp_cd.value == "Non-Charged B/L") {
	 					if(formObj.umch_sub_tp_cd.Code == "") {
	 						ComShowCodeMessage("BKG95031", "Error Kind");
	 						formObj.umch_tp_cd.focus();
		 					return false;
	 					}
	 				} else {
		 				if (ComIsEmpty(formObj.bkg_corr_no) && ComIsEmpty(formObj.n3pty_no)) {
	 					    ComShowCodeMessage("BKG95025", "C/A No or TPB Invoice"); // ['BKG95025'] = "Please input {?msg1}." 					
			   	 			formObj.bkg_corr_no.focus();
							return false;
		   	 			}
		 				
		 				/*
		 				if (formObj.bkg_corr_no.value.length != 10) {
		 					ComShowCodeMessage("BKG95018","CA No\'s","10");
			   	 			formObj.bkg_corr_no.focus();
							return false;
		   	 			}
		   	 			*/
		 					 				
		 				if (ComIsEmpty(formObj.receiver_rmk)) {
		   	 				ComBkgInputValueFailed("input","Remark",formObj.receiver_rmk);
		   	 				return false;
		   	 			}
	 				}
	 				
	 				return true;
   	  			} else {
   	  				return false;
   	  			}	
				return true;
	 			break;	
	 			
        	case IBSEARCH_ASYNC02: // RIVISE REQUEST
        	case IBSEARCH_ASYNC03: // CANCEL REQUEST
        	
	 			var rdn_sts_cd = formObj.rdn_sts_cd.value;
	 			// RIVISE REQUEST 가능 상태, CANCEL REQUEST 가능 상태
	 			if(rdn_sts_cd == "IS" || rdn_sts_cd == "RV"){
	 				//formatRdnNo(formObj.rdn_no);
	 				
	 				if (ComIsEmpty(formObj.receiver_rmk)) {
	   	 				ComShowCodeMessage("BKG95025", "Remarks"); // "Please input {?msg2}."
	   	 				formObj.receiver_rmk.focus();
	   	 				return false;
	   	 			}
	 				
	 				return true;
   	  			} else {
   	  				return false;
   	  			}
				return true;
	 			break;	
	 		
   	 		}

            return true;
        }
        
        /**
		 * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     toggleButtons(mode)
		 * </pre>
		 * @param {String} mode    
		 * @return 없음
		 * @author 이승준
		 * @version 2009.06.10
		 */
        function toggleButtons(mode) {
        	var form = document.form;

			 switch (mode) {
	    		case "":		//신규
	    			ComBtnEnable("btn_Retrieve");
	    			ComBtnEnable("btn_New");
	    			ComBtnDisable("btn_Save");
	    			ComBtnDisable("btn_Accept");
	    			ComBtnDisable("btn_ReviseRequest");
	    			ComBtnDisable("btn_CancelRequest");
	    			ComBtnDisable("btn_Print");
	    			ComBtnDisable("btn_Attachment");
	    			break;
	    		case "IS":		//ISSUE
	    			ComBtnEnable("btn_Retrieve");
	    			ComBtnEnable("btn_New");
	    			ComBtnDisable("btn_Save");
	    			ComBtnEnable("btn_Print");
	    			ComBtnDisable("btn_Attachment");
	    			
	    			if(form.rdn_knd_cd.value == 'B/L'){
		    			ComBtnEnable("btn_Accept");
		    			ComBtnEnable("btn_ReviseRequest");
		    			ComBtnEnable("btn_CancelRequest");
	    			} else {
		    			ComBtnDisable("btn_Accept");
		    			ComBtnDisable("btn_ReviseRequest");
		    			ComBtnDisable("btn_CancelRequest");	    				
	    			}
	    			break;
	    		case "RV":		//REVISE
	    			ComBtnEnable("btn_Retrieve");
	    			ComBtnEnable("btn_New");
	    			ComBtnDisable("btn_Save");
	    			ComBtnEnable("btn_Print");
	    			ComBtnDisable("btn_Attachment");
	    			
	    			if(form.rdn_knd_cd.value == 'B/L'){
		    			ComBtnEnable("btn_Accept");
		    			ComBtnEnable("btn_ReviseRequest");
		    			ComBtnEnable("btn_CancelRequest");
	    			} else {
		    			ComBtnDisable("btn_Accept");
		    			ComBtnDisable("btn_ReviseRequest");
		    			ComBtnDisable("btn_CancelRequest");	    				
	    			}
	    			
					break;
				case "CL":		//CANCEL
					ComBtnEnable("btn_Retrieve");
	    			ComBtnEnable("btn_New");
	    			ComBtnDisable("btn_Save");
	    			ComBtnDisable("btn_Accept");
	    			ComBtnDisable("btn_ReviseRequest");
	    			ComBtnDisable("btn_CancelRequest");
	    			ComBtnEnable("btn_Print");
	    			ComBtnDisable("btn_Attachment");
					break;
				case "ST":		//SETTLE
					ComBtnEnable("btn_Retrieve");
	    			ComBtnEnable("btn_New");
	    			ComBtnDisable("btn_Save");
	    			ComBtnDisable("btn_Accept");
	    			ComBtnDisable("btn_ReviseRequest");
	    			ComBtnDisable("btn_CancelRequest");
	    			ComBtnEnable("btn_Print");
	    			ComBtnDisable("btn_Attachment");
					break;
				case "AC":		//Accepted
					ComBtnEnable("btn_Retrieve");
	    			ComBtnEnable("btn_New");
	    			ComBtnEnable("btn_Save");
	    			ComBtnDisable("btn_Accept");
	    			ComBtnDisable("btn_ReviseRequest");
	    			ComBtnDisable("btn_CancelRequest");
	    			ComBtnEnable("btn_Print");
	    			ComBtnDisable("btn_Attachment");
					break;
				case "CR":		//Cancel Requested
					ComBtnEnable("btn_Retrieve");
	    			ComBtnEnable("btn_New");
	    			ComBtnEnable("btn_Save");
	    			ComBtnDisable("btn_Accept");
	    			ComBtnDisable("btn_ReviseRequest");
	    			ComBtnDisable("btn_CancelRequest");
	    			ComBtnEnable("btn_Print");
					break;
				case "RR":		//REVISE Requested
					ComBtnEnable("btn_Retrieve");
	    			ComBtnEnable("btn_New");
	    			ComBtnEnable("btn_Save");
	    			ComBtnDisable("btn_Accept");
	    			ComBtnDisable("btn_ReviseRequest");
	    			ComBtnDisable("btn_CancelRequest");
	    			ComBtnEnable("btn_Print");
	    			ComBtnDisable("btn_Attachment");
					break;
	    		}			 
			 

/*
 Login Office 가 Receipt Office, Responsible Office, SELADG 중 하나와 같을때만 버튼을 활성화 시킨다.
 모든 경우에 활성화 되도록 아래 로직 주석 처리함 ( 2010/05/19)
    		if( document.form.in_user_ofc_cd.value != document.form.rct_ofc_cd.value 	&&
    			document.form.in_user_ofc_cd.value != document.form.respb_ofc_cd.value	&&
    			document.form.in_user_ofc_cd.value != 'SELADG'							&&
    			document.form.in_user_ofc_cd.value != 'PKGSA'							)
    		{
    			ComBtnDisable("btn_Save");
    			ComBtnDisable("btn_Accept");
    			ComBtnDisable("btn_ReviseRequest");
    			ComBtnDisable("btn_CancelRequest");
    		}
 */
		 
		 }

        
        /**
         * 조회 후 상태 코드에 따라 버튼 활성화/비활성화함.<br>
         * <br><b>Example :</b>
         * <pre>
         *     resetButton()
         * </pre>
         * @param 없음  
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
    	function resetButton() {
    		
    		var formObj = document.form;
    		var rdn_sts_cd = formObj.rdn_sts_cd.value;
    		toggleButtons(rdn_sts_cd);
    	}

    	/**
         * sheet1에 조회이벤트가 끝난 후 호출된다.<br>
         * 서브 sum을 구하고 버튼을 리셋한다.
         * <br><b>Example :</b>
         * <pre>
         *     
         * </pre>
         * @param {sheetObj} sheetObj  
         * @param {String} ErrMsg  
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{
    		setSumTxt(sheetObj);
    		
    		resetButton();
    		setUmchSubCd();
    	}
    	
    	/**
         * 이벤트가 발생시 umch_sub_tp_cd 콤보를 조회하고 hidden 값으로 세팅한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		setUmchSubCd();
         * </pre>
         * @param 없음
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
        function setUmchSubCd() {
        	var formObj = document.form;
        	var errorKind2 = formObj.umch_sub_tp_cd; 
 			formObj.f_cmd.value = COMMAND05;
 			formObj.etc1.value 	= formObj.umch_tp_cd.value;
			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, errorKind2, "cd", "nm");
			
			if(formObj.umch_tp_cd.value == 'Non-Charged B/L'){
				errorKind2.InsertItem(0, "", "");
			}
			//조회한 히든 값으로 세팅
			errorKind2.Code = formObj.umch_sub_tp_cd_hidden.value;
			if(errorKind2.Index == "-1" && errorKind2.GetCount() > 0) {
				errorKind2.Index = "0";
			}
			
        }
        
        
    	/**
         * sheet1에 조회이벤트가 끝난 후 호출된다.<br>
         * 마지막 row에 total sum 및 표시문자를 설정한다.
         * <br><b>Example :</b>
         * <pre>
         *     setSumTxt(sheetObj)
         * </pre>
         * @param {sheetObj} sheetObj  
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
    	function setSumTxt(sheetObj) {
    		with(sheetObj)
    		{
    			//SumText(0, "curr_cd") = "";
    			SumText(0, "curr_cd") = "USD Total";
    			//alert(SumText(0, "curr_cd"));
    			//CellAlign(LastRow, "dr_amt") = daRight;
//    			CellAlign(LastRow, "usd_amount") = daRight;
    		
	    		//조회된 curr_cd를 readonly로 setting
	    		for (var i=1; i<=SearchRows; i++) {
	    			CellEditable(i, "curr_cd") = false;
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
 	 		comboObjects[0].removeAll();
 	 		sheetObjects[1].RemoveAll();
 	 		
 	 		setSumTxt(sheetObjects[1]);
 	 		
 	 		resetButton();
    		
    		comboObjects[0].focus();
 	 	
 		}
 	 	
 	 	
 	 	/**
         * BLNO, RDN NO 외 리셋한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     removeSearch(formObj)
         * </pre>
         * @param {formObj} formObj    
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
 	 	function removeSearch(formObj) {
 	 		
 	 		//var rdnNo = formObj.rdn_no.value;
 	 		var blNo = formObj.bl_no.value;
 	 		
 	 		formObj.reset();
 	 		comboObjects[0].removeAll();
 	 		
 	 		sheetObjects[1].RemoveAll();
 	 		
 	 		setSumTxt(sheetObjects[1]);
 	 		
 	 		//formObj.rdn_no.value = rdnNo;
 	 		formObj.bl_no.value = blNo;
 	 		
 		}
 	 	
 	 	/**
         * rdn_no를 9자리 문자숫자혼합형식으로 맞춘다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     formatRdnNo(obj)
         * </pre>
         * @param {Object} obj    
         * @return String
         * @author 이승준
         * @version 2009.06.10
         */
    	function formatRdnNo(obj) {
    		
    		//var obj = eval("document.form."+formObj);
    		//alert(obj.value);
    		if(ComIsEmpty(obj)) 
    			return;
    		
    		
    		var d = new Date();
    		var year = "";
    		year = d.getYear() + "";
    		
    		
    		//숫자인 경우 
//    		if(ComIsNumber(obj.value)) {
//    			var rdnNo = obj.value+"";
//    			obj.value = "RDN" + year.substr(2,2) + plusZero(minusZero(rdnNo));
//    			//alert(obj.value);
//    		} else {
    			//alert(obj.value);
    			if(obj.value.length == 9) {
	    			var rdnNo = obj.value+"";
	    			obj.value = minusZero(rdnNo.substr(5,4));
    			} else {
    				//alert("9 아님 " + obj.value);
    				return "";
    			}
//    		}
    		
    	}
    	
    	
    	/**
         * rdn_no에 0 삽입한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     plusZero(rdnNo)
         * </pre>
         * @param {String} rdnNo    
         * @return String
         * @author 이승준
         * @version 2009.06.10
         */
    	function plusZero(rdnNo) {
    		var zero = "";
    		for(var i=0; i<(4-rdnNo.length); i++) {
    			zero = zero + "0";
    		}
    		return (zero+rdnNo);
    	}
    	
    	/**
         * rdn_no에 0을 제거한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     minusZero(rdnNo)
         * </pre>
         * @param {String} rdnNo    
         * @return String
         * @author 이승준
         * @version 2009.06.10
         */
    	function minusZero(rdnNo) {
    		var no = "";
    		var i = 0;
    		
    		for(i=0; i<rdnNo.length; i++) {
    			var num = rdnNo.charAt(i);
    			if(containsCharsOnly(num,"123456789"))  break;
    			
    		}
    		
    		return (no = rdnNo.substring(i));
    	}
    	
    	/**
         * 문자로만 이루어진 형식이면 true, 아니면 false를 리턴한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     containsCharsOnly(input,chars)
         * </pre>
         * @param {String} input    
         * @param {String} chars  
         * @return boolean
         * @author 이승준
         * @version 2009.06.10
         */
    	function containsCharsOnly(input,chars) {
    	    for (var inx = 0; inx < input.length; inx++) {
    	        if (chars.indexOf(input.charAt(inx)) == -1)
    	            return false;
    	    }
    	    return true;
    	}
    	
    	/**
         * ACCEPT 저장시  CA NO 존재 여부 체크한다.<br>
         * <br><b>Example :</b>
         * <pre>
         *     searchCano(formObj)
         * </pre>
         * @param {form} formObj    
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */
/*
         function searchCano(formObj) {
        	formObj.f_cmd.value = SEARCH06;
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0712GS.do", FormQueryString(formObj));
			if(ComGetEtcData(sXml, "count_bkg_corr_no") == "0") {
				ComShowCodeMessage("BKG95042");
				formObj.bkg_corr_no.focus();
   				return false;
			}
        }
 */	 	

	/* 개발자 작업  끝 */