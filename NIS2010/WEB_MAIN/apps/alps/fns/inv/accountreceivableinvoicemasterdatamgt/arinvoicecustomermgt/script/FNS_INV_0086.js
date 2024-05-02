/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0086.js
*@FileTitle : Quick Customer Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.28 한동훈
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
     * @class fns_inv_0086 : fns_inv_0086 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0086() {
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

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 한동훈
	 * @version 2009.10.19
	 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

                                          
           switch(srcName) {

                case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                    break; 

                case "btn_new":
					ComResetAll();
					ComSetFocus(formObject.cust_cnt_cd);
                    break; 

                case "btn_apply":
					callParent();
                    break; 
                                        
                case "btn_close":
					window.close();
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
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;
			
    }



    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);


         //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        axon_event.addListenerForm ('focusout', 'obj_focusout', document.form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');		
//		if(document.form.cust_cnt_cd.value != ""){
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//		}	
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		document.form.cust_lgl_eng_nm.focus();
    }

    /** 
     * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
      	 * @version 2009.10.19
	 */
	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	switch(event.srcElement.name){

 	    	    case "cust_lgl_eng_nm":
 	    	    	//if(document.form.chk_nm.checked == true){
	 	    	    	 if(event.keyCode >= 97 && event.keyCode <= 122)
	 	    	    	  {
	 	    	    	     event.keyCode = event.keyCode - 32;
	 	    	    	  }else if(event.keyCode == 32){
	 	    	    		 event.keyCode = event.keyCode;
	 	    	    	  }
 	    	    	 //}else{
 	    	    	//	ComKeyOnlyAlphabet('upper'); break;
 	    	    	 //}
 	    	    	break;
 	    	    default:
		    	        //영문대문자만입력하기		    	        
		                ComKeyOnlyAlphabet('upper'); break;
	            }
	            break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	    }
	}
	
    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 260;
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

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel|Cust. Code|Actual Payer\nCode|Customer Name|Address|Zip Code|Credit Office|cust_cnt_cd|cust_seq|locl_nm|TaxPayerID\nRegNo|Status|No Use";
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,   false,  	"ibflag");
					InitDataProperty(0, cnt++,  dtRadioCheck, 	30,		daCenter, 	false,		"SelChk");
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,   false,     "cust_code",   		false,          "",      dfNone,   			0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,  	false,     "act_cust_cnt_cd",   false,          "",      dfNone,      		0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData, 		170,	daLeft,	  	false,     "cust_lgl_eng_nm",   false,          "",      dfNone,     		0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData, 		190,	daLeft,  	false,     "bzet_addr",   		false,          "",      dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData, 		60,		daCenter,   false,     "zip_cd",    		false,          "",      dfNone,    		0,     false,       false);					
                    InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,  	false,     "cr_clt_ofc_cd",   	false,          "",      dfNone,     		0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden, 		90,		daCenter,  	false,     "cust_cnt_cd",   	false,          "",      dfNone,     		0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden, 		90,		daCenter,  	false,     "cust_seq",   		false,          "",      dfNone,     		0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden, 		90,		daCenter,  	false,     "locl_nm",   		false,          "",      dfNone,     		0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData, 		80,		daCenter,  	false,     "cust_rgst_no", 		false,          "",      dfNone,     		0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,  	false,     "delt_flg",   		false,          "",      dfNone,     		0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,  	false,     "sls_delt_eff_dt",   false,          "",      dfNone,     		0,     false,       false);
               }
                break;


        }
    }

    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
     * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
     * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	        case IBSEARCH_ASYNC10: //Office 조회하여 cust_cnt_cd 세팅
	        	formObj.f_cmd.value = SEARCH02;
	    		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
	    		
	    		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
	    		var arrStr = sStr.split("|");
	    		var loc_cd = "";
	    		var login_ofc_cd = formObj.login_ofc_cd.value;
	    		var popOffice = formObj.popOffice.value;
	    		if(popOffice != ""){
	    			for (var i = 1; i < arrStr.length;i++ ) {
		       			var arrStr2 = arrStr[i].split("^");
		       			var ar_ofc_cd = arrStr2[1];
		       			if(ar_ofc_cd == popOffice){
		       				loc_cd = arrStr2[10];
		       			}
		       		}
	    		}else{
		    		for (var i = 1; i < arrStr.length;i++ ) {
		       			var arrStr2 = arrStr[i].split("^");
		       			var ar_ofc_cd = arrStr2[1];
		       			if(ar_ofc_cd == login_ofc_cd){
		       				loc_cd = arrStr2[10];
		       			}
		       		}
	    		}	
	    		
	    		formObj.cust_cnt_cd.value = loc_cd;
			break;
			
	        case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction) == false) return false;  
				if (sheetObj.id == "sheet1") {						
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("FNS_INV_0086GS.do", FormQueryString(formObj));
					
					var delt_flg = "";
					for (var i=1; i<=sheetObj.RowCount; i++) {
						delt_flg = sheetObj.cellValue(i,"delt_flg");
						if(delt_flg == "Delete"){
							sheetObj.CellFontColor(i, "delt_flg") =sheetObj.RgbColor(255, 0, 0);
						}
					}
					
				}
                break;          
          case IBSAVE:        //저장
          	if(validateForm(sheetObj,formObj,sAction))

                  alert (" Save .. ");

                break;

					case IBINSERT:      // 입력

                break;
        }
    }    
    
    /** 
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return true, false
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if (ComIsNull(formObj.cust_cnt_cd)) {            		
				ComShowCodeMessage('INV00004');
				ComSetFocus(form.cust_cnt_cd);
				return false;
			}
			if (ComIsNull(formObj.cust_lgl_eng_nm) && ComIsNull(formObj.zip_cd) && ComIsNull(formObj.cust_rgst_no)){
				ComShowCodeMessage('INV00004');
				ComSetFocus(form.cust_lgl_eng_nm);
				return false;
			}
        }

        return true;
    }
    
    /** 
     * 포커스 이동시 자리수 체크하여 자동으로 이동하도록 설정함 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} id_from : 입력되는 form object
     * @param  {object} id_to : 입력 후, 포커스 이동할 form object
     * @param  {number} maxSize : 입력되는 form object의 input value size
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
	function moveNext(id_from,id_to,maxSize) {			
		var cur = document.getElementById(id_from).value;
		curSize = cur.length;
		if (curSize == maxSize) {
			document.getElementById(id_to).focus();
		}
	}

	/* 개발자 작업  끝 */