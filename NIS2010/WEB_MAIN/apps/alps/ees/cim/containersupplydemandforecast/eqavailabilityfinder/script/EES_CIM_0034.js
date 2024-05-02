/*=========================================================
*Copyright(c) 2009 CyberLogitec
 * @FileName : EES_CIM_0034.js
 * @FileTitle : EQ Availability
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.06.24
 * @LastModifier : 김종준
 * @LastVersion : 1.0
 * 2009.06.24 김종준
 * 1.0 Creation
 * ======================================================
 * 2011.03.16 남궁진호 [CHM-201109288-01]Location Code 숫자입력가능하게수정
 *                    ComKeyOnlyAlphabet('upper') ->ComKeyOnlyAlphabet('uppernum')
=========================================================*/
    /**
     * @extends 
     * @class ees_cim_0034 : ees_cim_0034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cim_0034() {
    	this.processButtonClick			= tprocessButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.initControl            	= initControl;
    	this.doActionIBSheet 			= doActionIBSheet;
    	this.setTabObject 				= setTabObject;
    	this.validateForm 				= validateForm;
    	this.MinimizeSheet1 			= MinimizeSheet1;
    	this.MinimizeSheet2 			= MinimizeSheet2;
    	this.cntr_tpsz_cd_OnCheckClick 	= cntr_tpsz_cd_OnCheckClick;
    	this.loc_type_code_onchange 	= loc_type_code_onchange;
    	this.obj_blur 					= obj_blur;
    	this.obj_keypress 				= obj_keypress;
    	this.obj_activate 				= obj_activate;
    	this.cntr_tpsz_cd_change 		= cntr_tpsz_cd_change;
    	this.loc_cd_onkeyUp 			= loc_cd_onkeyUp;
    	this.cntr_tpsz_cd_onkeyUp 		= cntr_tpsz_cd_onkeyUp;
    	this.chkTpSz 					= chkTpSz;
    	this.cntr_tpsz_cd1_onkeyUp 		= cntr_tpsz_cd1_onkeyUp;
    	this.cntr_tpsz_cd2_onkeyUp 		= cntr_tpsz_cd2_onkeyUp;
    	this.cntr_tpsz_cd3_onkeyUp 		= cntr_tpsz_cd3_onkeyUp;
    	this.cntr_tpsz_cd4_onkeyUp 		= cntr_tpsz_cd4_onkeyUp;
    	this.setHeaderValue 			= setHeaderValue;
    	this.popupFinish 				= popupFinish;
    	this.sheetSetBackColor 			= sheetSetBackColor;
    	this.sheet1_OnSearchEnd 		= sheet1_OnSearchEnd;
    	this.sheet1_OnClick		 		= sheet1_OnClick;
    	this.sheet1_OnMouseDown		 	= sheet1_OnMouseDown;
    	this.sheet1_OnDblClick		 	= sheet1_OnDblClick;
    	this.sheet2_OnSearchEnd		 	= sheet2_OnSearchEnd;
    	this.chkDumTpSz		 			= chkDumTpSz;
    	this.sheet1_OnMouseMove		 	= sheet1_OnMouseMove;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0 ;
	
    var tot_cntr_tpsz_cd ="";
    var headCount = 0;
	 
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	 
	var IBSEARCH01  = 29;	 
	var IBSEARCH02  = 30;	 
	
	var Mincount1 = 0 ;
	var Mincount2 = 0 ;
	
	var HeadTitle1 = "";

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt = 0;
    	var sheetObject = sheetObjects[shtCnt++];

    	/*******************************************************/
    	var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 				switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					case "btn_new":		//조회조건 초기화
						formObject.reset();
						sheetObjects[0].Redraw = false;
						sheetObjects[0].RemoveAll();
						sheetObjects[0].Redraw = true;
						sheetObjects[1].Redraw = false;
						sheetObjects[1].RemoveAll();
						sheetObjects[1].Redraw = true;
						comboObjects[0].Code ='';
						ComSetFocus(document.form.loc_cd);
						comboObjects[0].Code = "D2,D4,D5,D7";
						break;
					case "btn_loc_cd":	//Location 조회 팝업
		    	        var cnt_cd = "";
		    	        var loc_cd = "";
			            cnt_cd = formObject.loc_type_code.value;
			            loc_cd = formObject.loc_cd.value;
			            if ( formObject.loc_type_code.value != '' ) {	
							if ( formObject.loc_type_code.value == 'S' ) {	//SCC
								var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
								ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 456, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
			           		} else {	//YARD
								var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
								ComOpenPopup("/hanjin/COM_ENS_061.do",780, 476, "popupFinish", "1,0,1,1,1,1,1,1", true);
			           		}
			            }
						break;
	                case "btn_minimize1":	//시트1최소화 하기
	                    Mincount1 = (Mincount1+1)%2 ;
	                    MinimizeSheet1(Mincount1);
	                    break;
	                case "btn_minimize2":	//시트2최소화 하기
	                    Mincount2 = (Mincount2+1)%2 ;
	                    MinimizeSheet2(Mincount2);
	                    break;
	                case "past_Br":		//Past BR Information 핍업화면 호출
	                	if(sheetObjects[0].RowCount > 0){
		                	var loc_cd = sheetObjects[0].CellValue(2, "scc_cd"); 
		                	var cntr_tpsz_cd_val1 = document.form.param_cntr_tpsz_cd_val1.value;
		                	var cntr_tpsz_cd_val2 = document.form.param_cntr_tpsz_cd_val2.value;
		                	var cntr_tpsz_cd_val3 = document.form.param_cntr_tpsz_cd_val3.value;
		                	var cntr_tpsz_cd_val4 = document.form.param_cntr_tpsz_cd_val4.value;

							var param =  "?loc_cd="			  +loc_cd
										+"&cntr_tpsz_cd_val1="+cntr_tpsz_cd_val1
										+"&cntr_tpsz_cd_val2="+cntr_tpsz_cd_val2
										+"&cntr_tpsz_cd_val3="+cntr_tpsz_cd_val3
										+"&cntr_tpsz_cd_val4="+cntr_tpsz_cd_val4
										;
							ComOpenPopup("/hanjin/EES_CIM_0052.do"+param,900, 615, "", "1,0,1,1,1,1,1,1", true);
	                	}
	                    break;
						
	 		        case "btn_downexcel":	//엑셀 다운로드
	 		        	if(sheetObjects[0].RowCount > 0){
	 		        		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
	 		        	}
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
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function MinimizeSheet1(nItem)
    {
        var objs = document.all.item("showMin");
        var showsheet1 = document.all.item("showsheet1");
        var showsheet2 = document.all.item("showsheet2");

        if ( nItem == "1" )
        {
    	    objs.style.display = "none";
    	    sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
    	    showsheet1.style.display = "block";
    	    showsheet2.style.display = "none";
    	    document.btn_minimize1.src='img/bu_prev01.gif';
    	    
    	    sheetObjects[0].ViewRows = 24;
    	    
    	}
    	else
    	{
    	    objs.style.display = "block";

    	    sheetObjects[0].style.height = 170;
    	    showsheet1.style.display = "block";
    	    showsheet2.style.display = "block";
    	    document.btn_minimize1.src='img/bu_next01.gif';

    	    sheetObjects[0].ViewRows = 10;
    	}
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function MinimizeSheet2(nItem)
    {
        var objs = document.all.item("showMin");
        var showsheet1 = document.all.item("showsheet1");
        var showsheet2 = document.all.item("showsheet2");
        if ( nItem == "1" )
        {
    	    objs.style.display = "none";
    	    sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(20);
    	    showsheet1.style.display = "none";
    	    showsheet2.style.display = "block";
    	    document.btn_minimize2.src='img/bu_prev01.gif';
    	    
    	    sheetObjects[1].ViewRows = 24;
    	}
    	else
    	{
    	    objs.style.display = "block";

    	    sheetObjects[1].style.height = 170;
    	    showsheet1.style.display = "block";
    	    showsheet2.style.display = "block";
    	    document.btn_minimize2.src='img/bu_next01.gif';

    	    sheetObjects[1].ViewRows = 10;
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
    }

    /**
     * sheet1 화면 조회 종료후 프로세스 처리
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //Period,HEAD,TPSZ 데이타 가져오기
    	ComSetFocus(document.form.loc_cd);
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
	* 초기 이벤트 등록 
	*/
	function initControl() {
		axon_event.addListener('change', 'cntr_tpsz_cd_change', 'cntr_tpsz_cd');			//TP/SZ 변경시 이벤트 처리
		axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');						//LOC_CD keyup 이벤트 처리
		axon_event.addListener('keyup', 'cntr_tpsz_cd_onkeyUp', 'cntr_tpsz_cd_val1', 'cntr_tpsz_cd_val2', 'cntr_tpsz_cd_val3', 'cntr_tpsz_cd_val4');						//LOC_CD keyup 이벤트 처리
		axon_event.addListener('keyup', 'cntr_tpsz_cd1_onkeyUp', 'cntr_tpsz_cd_val1');		//TP/SZ keyup 이벤트 처리
		axon_event.addListener('keyup', 'cntr_tpsz_cd2_onkeyUp', 'cntr_tpsz_cd_val2');		//TP/SZ keyup 이벤트 처리
		axon_event.addListener('keyup', 'cntr_tpsz_cd3_onkeyUp', 'cntr_tpsz_cd_val3');		//TP/SZ keyup 이벤트 처리
		axon_event.addListener('keyup', 'cntr_tpsz_cd4_onkeyUp', 'cntr_tpsz_cd_val4');		//TP/SZ keyup 이벤트 처리
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form);
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');	//Location by 변경시 이벤트 처리
	}
	
	/**
     * TP/SZ  클릭 이벤트 등록
     */
	function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }
    
    /**
     * loc_type_code 변경시 이벤트 처리
     */   
    function loc_type_code_onchange() {
        var formObject = document.form;
		if  ( formObject.loc_type_code.value == 'Y' ) {
			document.getElementById("loc_cd").setAttribute("maxLength",7);
		} else {
			document.getElementById("loc_cd").setAttribute("maxLength",5);
		}
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);		
    }   
    
	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		switch (event.srcElement.name) {
			case "loc_cd":
				if ( document.form.loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
				}
				break;
			case "cntr_tpsz_cd_val1":
				if ( document.form.cntr_tpsz_cd_val1.value !='' ) {
					chkTpSz(document.form.cntr_tpsz_cd_val1);	//TP/SZ 유효성 체크
				}
				if (chkDumTpSz()) {
					ComClearObject(document.form.cntr_tpsz_cd_val1);
					ComSetFocus(document.form.cntr_tpsz_cd_val1);
					document.form.cntr_tpsz_cd_val1.select();
					return false;
				}
				comboObjects[0].Code =document.form.cntr_tpsz_cd_val1.value+","+document.form.cntr_tpsz_cd_val2.value+","+document.form.cntr_tpsz_cd_val3.value+","+document.form.cntr_tpsz_cd_val4.value;
				break;
			case "cntr_tpsz_cd_val2":
				if ( document.form.cntr_tpsz_cd_val2.value !='' ) {
					chkTpSz(document.form.cntr_tpsz_cd_val2);	//TP/SZ 유효성 체크
				}
				if (chkDumTpSz()) {
					ComClearObject(document.form.cntr_tpsz_cd_val2);
					ComSetFocus(document.form.cntr_tpsz_cd_val2);
					document.form.cntr_tpsz_cd_val2.select();
					return false;
				}
				comboObjects[0].Code =document.form.cntr_tpsz_cd_val1.value+","+document.form.cntr_tpsz_cd_val2.value+","+document.form.cntr_tpsz_cd_val3.value+","+document.form.cntr_tpsz_cd_val4.value;
				break;
			case "cntr_tpsz_cd_val3":
				if ( document.form.cntr_tpsz_cd_val3.value !='' ) {
					chkTpSz(document.form.cntr_tpsz_cd_val3);	//TP/SZ 유효성 체크
				}
				if (chkDumTpSz()) {
					ComClearObject(document.form.cntr_tpsz_cd_val3);
					ComSetFocus(document.form.cntr_tpsz_cd_val3);
					document.form.cntr_tpsz_cd_val3.select();
					return false;
				}
				comboObjects[0].Code =document.form.cntr_tpsz_cd_val1.value+","+document.form.cntr_tpsz_cd_val2.value+","+document.form.cntr_tpsz_cd_val3.value+","+document.form.cntr_tpsz_cd_val4.value;
				break;
			case "cntr_tpsz_cd_val4":
				if ( document.form.cntr_tpsz_cd_val4.value !='' ) {
					chkTpSz(document.form.cntr_tpsz_cd_val4);	//TP/SZ 유효성 체크
				}
				if (chkDumTpSz()) {
					ComClearObject(document.form.cntr_tpsz_cd_val4);
					ComSetFocus(document.form.cntr_tpsz_cd_val14);
					document.form.cntr_tpsz_cd_val4.select();
					return false;
				}
				comboObjects[0].Code =document.form.cntr_tpsz_cd_val1.value+","+document.form.cntr_tpsz_cd_val2.value+","+document.form.cntr_tpsz_cd_val3.value+","+document.form.cntr_tpsz_cd_val4.value;
				break;
		}
	}

    /**
     * key press 이벤트 처리
     */  	
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				if ( formObject.loc_type_code.value == 'S' ) {
					ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
			    } else { 
					ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
			    }
				break;
			case "cntr_tpsz_cd_val1":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "cntr_tpsz_cd_val2":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "cntr_tpsz_cd_val3":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "cntr_tpsz_cd_val4":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
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
    * TP/SZ 변경시 이벤트 처리
    */   
    function cntr_tpsz_cd_change() {
    	var cntr_tpsz_cd  = comboObjects[0].Code;
    	var arrTpszs = cntr_tpsz_cd.split(",");
    	for ( var i=0; i<4; i++ ) {
    		if ( i<arrTpszs.length ) {
    			eval("document.form.cntr_tpsz_cd_val"+(i+1)).value = arrTpszs[i];
    		} else {
    			eval("document.form.cntr_tpsz_cd_val"+(i+1)).value = "";
    		}
    	}
    }   	

    /**
     * LOC_CD keyup 이벤트 처리
     * LOC_CD keyup시 대분자로 처리
     */
     function loc_cd_onkeyUp() {
        var formObject = document.form;
        if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	        formObject.loc_cd.value = formObject.loc_cd.value.toUpperCase();
	        if ( formObject.loc_type_code.value == 'S' ) {
	        	document.getElementById("loc_cd").setAttribute("maxlength",5);
	 		   	formObject.loc_cd.value = formObject.loc_cd.value.substring(0,5).toUpperCase();
	 		   	if ( formObject.loc_cd.value.length == 5 ) {
	 		   		ComSetFocus(document.form.cntr_tpsz_cd);
	 		   	}
	        } else {
	        	document.getElementById("loc_cd").setAttribute("maxlength",7);
	 		   	if ( formObject.loc_cd.value.length == 7 ) {
	 		   		ComSetFocus(document.form.cntr_tpsz_cd);
	 		   	}
	        }
        }        
     }
     /**
      * LOC_CD keyup 이벤트 처리
      * LOC_CD keyup시 대분자로 처리
      */
    function cntr_tpsz_cd_onkeyUp() {
       var formObject = document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       formObject.cntr_tpsz_cd_val1.value = formObject.cntr_tpsz_cd_val1.value.toUpperCase();
	       formObject.cntr_tpsz_cd_val2.value = formObject.cntr_tpsz_cd_val2.value.toUpperCase();
	       formObject.cntr_tpsz_cd_val3.value = formObject.cntr_tpsz_cd_val3.value.toUpperCase();
	       formObject.cntr_tpsz_cd_val4.value = formObject.cntr_tpsz_cd_val4.value.toUpperCase();
       }
    }

    /**
     * TP/SZ 유효성 체크
     */
   function chkTpSz(tpsz) {
	   var chkFlag = false; 
	   var arrTpsz = tot_cntr_tpsz_cd.split("|");
	   for ( var i=0; i<arrTpsz.length; i++ ) {
		   if ( arrTpsz[i] == tpsz.value  ) {
			   chkFlag = true;
			   break;
		   }
	   }	   
	   if ( !chkFlag ) {
		   ComShowCodeMessage("CIM30013", "TP/SZ");    //유효한 TP/SZ 가 아닙니다.
		   ComClearObject(tpsz);
		   ComSetFocus(tpsz);
		   tpsz.select();
		   
	   }
	   return;
   }
    
    
    /**
     * TP/SZ1 keyup 이벤트 처리
     * TP/SZ1 keyup시 대분자로 처리
     */
    function cntr_tpsz_cd1_onkeyUp() {
       var formObject = document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       if ( formObject.cntr_tpsz_cd_val1.value.length ==2 ) {
	           ComSetFocus(formObject.cntr_tpsz_cd_val2); 
	       }
       }
    }
    /**
     * TP/SZ2 keyup 이벤트 처리
     * TP/SZ2 keyup시 대분자로 처리
     */
    function cntr_tpsz_cd2_onkeyUp() {
       var formObject = document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       if ( formObject.cntr_tpsz_cd_val2.value.length ==2 ) {
	           ComSetFocus(formObject.cntr_tpsz_cd_val3); 
	       }
       }
    }
    /**
     * TP/SZ3 keyup 이벤트 처리
     * TP/SZ3 keyup시 대분자로 처리
     */
    function cntr_tpsz_cd3_onkeyUp() {
       var formObject = document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       if ( formObject.cntr_tpsz_cd_val3.value.length ==2 ) {
	           ComSetFocus(formObject.cntr_tpsz_cd_val4); 
	       }
       }
    }    

    /**
     * TP/SZ3 keyup 이벤트 처리
     * TP/SZ3 keyup시 대분자로 처리
     */
    function cntr_tpsz_cd4_onkeyUp() {
       var formObject = document.form;
       if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	       if ( formObject.cntr_tpsz_cd_val4.value.length ==2 ) {
	           ComSetFocus(formObject.fm_fcast_dt); 
	       }
       }
    }  
	
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
	function initSheet(sheetObj,sheetNo,colCnt,HeadTitle1,HeadTitle2) {
		var cnt = 0;
        var shtID = sheetObj.id;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 192;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    if (HeadTitle1==null || HeadTitle1 =="") {
                    	HeadTitle1 = "|SCC|DATE|D2|D2|D2|D2|D2|D2|D2|D2|D2|D2|D4|D4|D4|D4|D4|D4|D4|D4|D4|D4|D5|D5|D5|D5|D5|D5|D5|D5|D5|D5|D7|D7|D7|D7|D7|D7|D7|D7|D7|D7";
                    	HeadTitle2 = "|SCC|DATE|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON";
                    	colCnt=4;
                    }
                    	
                    headCount = ComCountHeadTitle(HeadTitle1);
                    
                    SheetWidth = headCount*45;
                    if ( SheetWidth>975 ) {
                  	   SheetWidth = 975;
                    }
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false);
                    sheetObj.FrozenCols = 3;
                     

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    CountPosition = 0;	//페이지카운트 없애기 

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(	0, 	cnt++ , dtHidden,	0,		daCenter,	true,	"loc_level",	false,	"",	dfNone);
                    InitDataProperty(	0, 	cnt++ , dtData,		60,		daCenter,	true,	"scc_cd",		false,	"",	dfNone);
                    InitDataProperty(	0, 	cnt++ , dtData,		75,		daCenter,	true,	"fcast_dt",		false,	"",	dfDateYmd);
                    for(var i=1 ; i <= colCnt ; i++){
	                    InitDataProperty(0, cnt++ , dtData,		50,   	daRight,  	false,	"ea"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"br"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"pup"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"ro"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"ofh"+i,    	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,	  	daRight,	false,	"sn"+i,  		false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"ig"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"rtn"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"ri"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,		daRight,	false,	"onh"+i,  		false,	"",	dfInteger);
                    }
                    for ( var i=2; i<headCount; i++ ) {
                    	if ( headCount < i+11 ) {
                    		sheetObjects[0].ColHidden(i) = true;
                    		sheetObjects[1].ColHidden(i) = true;
                    	} else {
                    		sheetObjects[0].ColHidden(i) = false;
                    		sheetObjects[1].ColHidden(i) = false;
                    	}
                    }
                }
                break;


            case 2:      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 192;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    if (HeadTitle1==null || HeadTitle1 =="") {
                    	HeadTitle1 = "|Yard|DATE|D2|D2|D2|D2|D2|D2|D2|D2|D2|D2|D4|D4|D4|D4|D4|D4|D4|D4|D4|D4|D5|D5|D5|D5|D5|D5|D5|D5|D5|D5|D7|D7|D7|D7|D7|D7|D7|D7|D7|D7";
                    	HeadTitle2 = "|Yard|DATE|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON|Avail\nEQ|BR|PUP|RO|OFF|SN|IG|RTN|RI|ON";
                    	colCnt=4;
                    }                    
                    	
                    headCount = ComCountHeadTitle(HeadTitle1);
                    
                    SheetWidth = headCount*45;
                    if ( SheetWidth>975 ) {
                  	   SheetWidth = 975;
                    }
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false);
                    sheetObj.FrozenCols = 3;
                     

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    CountPosition = 0;	//페이지카운트 없애기

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(	0, 	cnt++ , dtHidden,	0,		daCenter,	true,	"loc_level",	false,	"",	dfNone);
                    InitDataProperty(	0, 	cnt++ , dtData,		60,		daCenter,	true,	"yd_cd",		false,	"",	dfNone);
                    InitDataProperty(	0, 	cnt++ , dtData,		75,		daCenter,	true,	"fcast_dt",		false,	"",	dfDateYmd);
                    for(var i=1 ; i <= colCnt ; i++){
	                    InitDataProperty(0, cnt++ , dtData,		50,   	daRight,  	false,	"ea"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"br"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"pup"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"ro"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"ofh"+i,    	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,	  	daRight,	false,	"sn"+i,  		false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"ig"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"rtn"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,   	daRight,  	false,	"ri"+i,     	false,	"",	dfInteger);
	                    InitDataProperty(0, cnt++ , dtData,		40,		daRight,	false,	"onh"+i,  		false,	"",	dfInteger);
                    }
                    for ( var i=2; i<headCount; i++ ) {
                    	if ( headCount < i+11 ) {
                    		sheetObjects[0].ColHidden(i) = true;
                    		sheetObjects[1].ColHidden(i) = true;
                    	} else {
                    		sheetObjects[0].ColHidden(i) = false;
                    		sheetObjects[1].ColHidden(i) = false;
                    	}
                    }                    
                }
                break;
         }
     }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
//		sheetObj.ShowDebugMsg = false;  
		switch(sAction) {
		
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
            	ComEndConfigSheet(sheetObjects[0]);	  //헤더 색생 유지
            	ComEndConfigSheet(sheetObjects[1]);
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.WaitImageVisible=false;
    			sheetObjects[1].WaitImageVisible = false;
    			ComOpenWait(true); 
    			setHeaderValue(sheetObj);	//타이틀 해더 세팅
    			sheetObjects[0].Redraw = false;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0034GS.do" , FormQueryString(formObj));
    			sheetObjects[0].LoadSearchXml(sXml);
    			sheetObjects[1].LoadSearchXml(sXml);
    			ComOpenWait(false); 
    			
                break;
    		case IBSEARCH01:      //공통조회
    			sheetObj.WaitImageVisible = false;
    			form.f_cmd.value = SEARCH01;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0034GS.do" , FormQueryString(form));
    			var cntr_tpsz_cd =ComGetEtcData(sXml,"cntr_tpsz_cd");	   //TP/SZ 조회
    			tot_cntr_tpsz_cd = cntr_tpsz_cd;
    			var strCntrTpszCd  = cntr_tpsz_cd.split("|");

    			//멀티콤보초기화
    			with (form.cntr_tpsz_cd) {
    				MultiSelect = true;
    				MultiSeparator = ",";
    				MaxSelect = 4;
    				DropHeight = 360;
    				InsertItem(0 , 'Uncheck','');
    				for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
    					InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
    				}    				
    			}    
    	         comboObjects[0].Code = "D2,D4,D5,D7";

    			break;
			case IBSEARCH02: //location focusOut
				var flag = false;
				var inquiryLevel = "";
				if ( formObj.loc_type_code.value == "S" ) {
					inquiryLevel = "S";
				} else if ( formObj.loc_type_code.value == "Y" ) {
					inquiryLevel = "Y";
				} 
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH02;
				if (formObj.loc_cd.value == "") {
					flag = false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0034GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM29013");
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						document.form.loc_cd.select()
						flag = false;
					} else {
						ComSetFocus(document.form.loc_cd);
						flag = true;
					}
				} else {
					ComSetFocus(document.form.cntr_tpsz_cd_val1);
				}
				return flag;
				break;	    			
			case IBDOWNEXCEL:      // 엑섹다운로드
    			sheetObjects[0].SpeedDown2Excel(-1,false,false,'','',false,false,'SCC List',false,'','',false,'',true);
	            if(sheetObjects[1].RowCount > 0){
	            	sheetObjects[1].SpeedDown2Excel(-1,true,true,'','',false,false,'YARD List',false,'','',false,'',true);
    	        }
    			break;
    			
		}
	}

	/**
	 * 타이틀 해더 세팅
	 */    
	function setHeaderValue(sheetObj) {
		var arrTpsz = new Array(4);
		var headerValue = "";
		arrTpsz[0] = document.form.cntr_tpsz_cd_val1.value;
		arrTpsz[1] = document.form.cntr_tpsz_cd_val2.value;
		arrTpsz[2] = document.form.cntr_tpsz_cd_val3.value;
		arrTpsz[3] = document.form.cntr_tpsz_cd_val4.value;
		var strHeader = tot_cntr_tpsz_cd.split("|");
    	 
		for ( var i=0; i<strHeader.length; i++ ) {
			for ( var j=0; j<arrTpsz.length; j++) {
				if ( arrTpsz[j] !='' && strHeader[i] == arrTpsz[j] ) {
					headerValue = headerValue+strHeader[i]+"|";
				}
			}
		}
    	 
		var strHeader = headerValue.split("|");
		var totHeader1 = "|SCC|DATE|";

		for ( var i=0; i<strHeader.length; i++ ) {
			if ( strHeader[i] != '' ) {
				for ( var j=0; j<=9; j++ ) {
					totHeader1 = totHeader1+strHeader[i]+"|";	
					}
			}
		}

		HeadTitle1 = totHeader1.substring(0,(totHeader1.length)-1);
		for ( var i=2; i<headCount; i++ ) {
			if ( ComCountHeadTitle(totHeader1) < i+2 ) {
				sheetObjects[0].ColHidden(i) = true;
				sheetObjects[1].ColHidden(i) = true;
			} else {
				sheetObjects[0].ColHidden(i) = false;
				sheetObjects[1].ColHidden(i) = false;
			}
		}
		for ( var i=2; i<ComCountHeadTitle(HeadTitle1); i++ ) {
			sheetObjects[0].CellValue2(0,i) = HeadTitle1.split("|")[i];	 
			sheetObjects[1].CellValue2(0,i) = HeadTitle1.split("|")[i];	 
		}
		 
		sheetObjects[0].SheetWidth = ComCountHeadTitle(totHeader1)*45;
		if ( sheetObjects[0].SheetWidth>975 ) {
			sheetObjects[0].SheetWidth = 974;
		}
		sheetObjects[1].SheetWidth = ComCountHeadTitle(totHeader1)*45;
		if ( sheetObjects[1].SheetWidth>975 ) {
			sheetObjects[1].SheetWidth = 974;
		}
	}
 	
    /**
     * Location by loc_cd 팝업에서 선택한 값 Setting.
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
       var sheetObject = sheetObjects[0];
       var formObject = document.form;
       formObject.loc_cd.value = aryPopupData[0][3];
       ComSetFocus(formObject.cntr_tpsz_cd_val1);        
       
       if ( formObject.loc_type_code.value == 'S' ) {
		   document.getElementById("loc_cd").setAttribute("minlength",5);
       } else {
    	   document.getElementById("loc_cd").setAttribute("minlength",7);
       }
    }
    
    /**
     * sheet 색상변경
     * sheet col별 색상변경
     */
    function sheetSetBackColor(sheetObj){
    	sheetObj.ColBackColor(3) = sheetObj.CellBackColor(1,3)
    	sheetObj.ColBackColor(13) = sheetObj.CellBackColor(1,3)
    	sheetObj.ColBackColor(23) = sheetObj.CellBackColor(1,3)
    	sheetObj.ColBackColor(33) = sheetObj.CellBackColor(1,3)
    }
    
    /**
    * Tab1 조회종료
    * Tab1 조회종료후 이벤트 호출
    */
    function sheet1_OnSearchEnd(sheetObj, msg){
    	for(var i=0; i<=sheetObj.LastRow; i++){
    		if(sheetObj.CellValue(i,0) == 'YARD'){
    			sheetObj.RowHidden(i) = true;
    		}
    		
    		sheetObj.CellFont("FontBold", i,"ea1") = true;
    		sheetObj.CellFont("FontBold", i,"ea2") = true;
    		sheetObj.CellFont("FontBold", i,"ea3") = true;
    		sheetObj.CellFont("FontBold", i,"ea4") = true;
    		if ( i !=0 && i !=1  ) {
       			if ( eval(ComReplaceStr(sheetObj.CellValue(i,"ea1"),",","")) < 0 ) {
       				sheetObj.CellFontColor(i,"ea1") = sheetObj.RgbColor(255, 0, 0);
       			}
       			if ( eval(ComReplaceStr(sheetObj.CellValue(i,"ea2"),",","")) < 0 ) {
       				sheetObj.CellFontColor(i,"ea2") = sheetObj.RgbColor(255, 0, 0);
       			}
       			if ( eval(ComReplaceStr(sheetObj.CellValue(i,"ea3"),",","")) < 0 ) {
       				sheetObj.CellFontColor(i,"ea3") = sheetObj.RgbColor(255, 0, 0);
       			}
       			if ( eval(ComReplaceStr(sheetObj.CellValue(i,"ea4"),",","")) < 0 ) {
       				sheetObj.CellFontColor(i,"ea4") = sheetObj.RgbColor(255, 0, 0);
       			}
    		}
    	}
    	document.form.fm_fcast_dt.value =  ComGetMaskedValue(sheetObj.CellValue(2,"fcast_dt"),'ymd');
    	document.form.to_fcast_dt.value = ComGetMaskedValue(sheetObj.CellValue(sheetObj.LastRow,"fcast_dt"),'ymd');
    	
    	document.form.param_loc_type_code.value = document.form.loc_type_code.value;
    	document.form.param_loc_cd.value = document.form.loc_cd.value;
    	document.form.param_cntr_tpsz_cd_val1.value = document.form.cntr_tpsz_cd_val1.value;
    	document.form.param_cntr_tpsz_cd_val2.value = document.form.cntr_tpsz_cd_val2.value;
    	document.form.param_cntr_tpsz_cd_val3.value = document.form.cntr_tpsz_cd_val3.value;
    	document.form.param_cntr_tpsz_cd_val4.value = document.form.cntr_tpsz_cd_val4.value;
    	
    	sheetObj.SelectHighLight = false;
    	
    	sheetSetBackColor(sheetObj);     	
    	sheetObj.Redraw = true;

    }

    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
     	
    }
    
    /**
     * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 EES_CIM_0039 호출
     */
    function sheet1_OnMouseDown(Button, Shift, X, Y) {
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	if ( sheetObj.MouseRow == 1) {
    		sheet1_OnDblClick(sheetObj, sheetObj.MouseRow, sheetObj.MouseCol, 0, 0, 0, 0);
    	}
    }

    /**
     * 셀을 마우스 더블클릭했을때 발생하는 이벤트 <br>
     * 더블클릭시 선택행 각각의 Detail한 BKG 정보화면 호출
     */
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	if ( Row == 0  ) return;
    	var colSaveName = sheetObj.ColSaveName(Col);
    	if( sheetObj.RowCount > 0 ){
	    	if ( colSaveName == "ro1" || colSaveName == "ro2" || colSaveName == "ro3" || colSaveName == "ro4" || colSaveName == "ri1" || colSaveName == "ri2" || colSaveName == "ri3" || colSaveName == "ri4") {
		    	var cntr_tpsz_cd = eval("document.form.param_cntr_tpsz_cd_val"+( colSaveName.substring(2,3))).value;
		    	var fcast_dt = "";
		    	var io_bnd_cd = colSaveName.substring(1,2).toUpperCase();	//I,O
	
		    	if ( Row != 1) {
		    		fcast_dt = sheetObj.CellValue(Row,"fcast_dt");
		    	}
	        	var loc_type_code = document.form.param_loc_type_code.value;
	        	var loc_cd = sheetObj.CellValue(2, "scc_cd"); 
	        	
	        	
				var param =  "loc_type_code="+loc_type_code
							+"&loc_cd="		 +loc_cd
							+"&fcast_dt="	 +fcast_dt
							+"&io_bnd_cd="	 +io_bnd_cd
							;
				ComOpenPopup("/hanjin/EES_CIM_0039.do?"+param,900, 698, "", "1,0,1,1,1,1,1,1", true);
	    	} else { 
		    	var fcast_dt = "";
            	var loc_cd = sheetObj.CellValue(2, "scc_cd"); 
            	var cntr_tpsz_cd = "";
		    	if ( Row != 1) {
		    		fcast_dt = sheetObj.CellValue(Row,"fcast_dt");	
		    	}
		    	
            	if ( colSaveName == "br1" || colSaveName == "pup1" || colSaveName == "ig1" || colSaveName == "rtn1" || colSaveName == "ofh1" || colSaveName == "onh1" ) {
            		cntr_tpsz_cd = document.form.param_cntr_tpsz_cd_val1.value;
            	} else if ( colSaveName == "br2" || colSaveName == "pup2" || colSaveName == "ig2" || colSaveName == "rtn2" || colSaveName == "ofh2" || colSaveName == "onh2" ) {
            		cntr_tpsz_cd = document.form.param_cntr_tpsz_cd_val2.value;
            	} else if ( colSaveName == "br3" || colSaveName == "pup3" || colSaveName == "ig3" || colSaveName == "rtn3" || colSaveName == "ofh3" || colSaveName == "onh3" ) {
            		cntr_tpsz_cd = document.form.param_cntr_tpsz_cd_val3.value;
            	} else if ( colSaveName == "br4" || colSaveName == "pup4" || colSaveName == "ig4" || colSaveName == "rtn4" || colSaveName == "ofh4" || colSaveName == "onh4" ) {
            		cntr_tpsz_cd = document.form.param_cntr_tpsz_cd_val4.value;
            	}
            	
				var param =  "?loc_cd="		 +loc_cd
							+"&cntr_tpsz_cd="+cntr_tpsz_cd	
							+"&fcast_dt="	 +fcast_dt;
	    		if ( colSaveName == "br1" || colSaveName == "br2" || colSaveName == "br3" || colSaveName == "br4" ) {				//BR Detail
					ComOpenPopup("/hanjin/EES_CIM_0046.do"+param,900, 570, "", "1,0,1,1,1,1,1,1", true);
		    	} else if ( colSaveName == "pup1" || colSaveName == "pup2" || colSaveName == "pup3" || colSaveName == "pup4" ) {	//PUP(Picked Up) Information
					ComOpenPopup("/hanjin/EES_CIM_0047.do"+param,900, 570, "", "1,0,1,1,1,1,1,1", true);				
		    	} else if ( colSaveName == "ofh1" || colSaveName == "ofh2" || colSaveName == "ofh3" || colSaveName == "ofh4" ) {	//OFF Detail
					ComOpenPopup("/hanjin/EES_CIM_0048.do"+param,700, 570, "", "1,0,1,1,1,1,1,1", true);				
		    	} else if ( colSaveName == "ig1" || colSaveName == "ig2" || colSaveName == "ig3" || colSaveName == "ig4" ) {		//IG Detail
					ComOpenPopup("/hanjin/EES_CIM_0049.do"+param,900, 570, "", "1,0,1,1,1,1,1,1", true);				
		    	} else if ( colSaveName == "rtn1" || colSaveName == "rtn2" || colSaveName == "rtn3" || colSaveName == "rtn4" ) {	//RTN Detail
					ComOpenPopup("/hanjin/EES_CIM_0050.do"+param,900, 570, "", "1,0,1,1,1,1,1,1", true);				
		    	} else if ( colSaveName == "onh1" || colSaveName == "onh2" || colSaveName == "onh3" || colSaveName == "onh4" ) {	//ON Detail
					ComOpenPopup("/hanjin/EES_CIM_0051.do"+param,810, 570, "", "1,0,1,1,1,1,1,1", true);				
		    	}
	    	}
    	}
    }

    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
    function sheet2_OnSearchEnd(sheetObj, msg) {
    	for(var i=0; i<=sheetObj.LastRow; i++){
    		if(sheetObj.CellValue(i,0) == 'SCC'){
    			sheetObj.RowHidden(i) = true;
    		}
    		sheetObj.CellFont("FontBold", i,"ea1") = true;
    		sheetObj.CellFont("FontBold", i,"ea2") = true;
    		sheetObj.CellFont("FontBold", i,"ea3") = true;
    		sheetObj.CellFont("FontBold", i,"ea4") = true;    		
    		if ( i !=0 && i !=1  ) {
       			if ( eval(ComReplaceStr(sheetObj.CellValue(i,"ea1"),",","")) < 0 ) {
       				sheetObj.CellFontColor(i,"ea1") = sheetObj.RgbColor(255, 0, 0);
       			}
       			if ( eval(ComReplaceStr(sheetObj.CellValue(i,"ea2"),",","")) < 0 ) {
       				sheetObj.CellFontColor(i,"ea2") = sheetObj.RgbColor(255, 0, 0);
       			}
       			if ( eval(ComReplaceStr(sheetObj.CellValue(i,"ea3"),",","")) < 0 ) {
       				sheetObj.CellFontColor(i,"ea3") = sheetObj.RgbColor(255, 0, 0);
       			}
       			if ( eval(ComReplaceStr(sheetObj.CellValue(i,"ea4"),",","")) < 0 ) {
       				sheetObj.CellFontColor(i,"ea4") = sheetObj.RgbColor(255, 0, 0);
       			}
    		}
    		
    	}
    	sheetSetBackColor(sheetObj);
    	sheetObj.Redraw = true;
    }

     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
            var formObject = document.form;
            
            if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
            	return false;
            } else {
	       	 	var arrTpsz = new Array(4);
	       	 	arrTpsz[0] = document.form.cntr_tpsz_cd_val1.value;
	       	 	arrTpsz[1] = document.form.cntr_tpsz_cd_val2.value;
	       	 	arrTpsz[2] = document.form.cntr_tpsz_cd_val3.value;
	       	 	arrTpsz[3] = document.form.cntr_tpsz_cd_val4.value;
	       	 	for ( var i=0; i<arrTpsz.length; i++) {
	       	 		if (arrTpsz[i] !='') {
	       	 			for ( var j=0; j<arrTpsz.length; j++) {
	       	 				if (i == j ) continue;
	       	 				if ( arrTpsz[i] == arrTpsz[j] ) {
	       	 					ComShowCodeMessage("CIM30006", "TP/SZ");    //TP/SZ 가 중복됩니다.
	       	 					ComSetFocus(eval("document.form.cntr_tpsz_cd_val"+(j+1)));
			    				return false;
	       	 				}
	       	 			}
	       	 		}
	       	 	}      	     
	     	     
	       	 	if ( document.form.cntr_tpsz_cd_val1.value == '' && document.form.cntr_tpsz_cd_val2.value == '' && document.form.cntr_tpsz_cd_val3.value == '' && document.form.cntr_tpsz_cd_val4.value == '' ) {
	       	 		ComShowMessage(msgs["CIM30005"]);	//TP/SZ는 최소 하나를 입력하여야 합니다.
	       	 		formObj.cntr_tpsz_cd_val1.focus();
	       	 		return false;
	       	 	}
            }
            if (!ComChkValid(formObj)) return false;
        }
        return true;
    }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function chkDumTpSz() {
  	     var arrTpsz = new Array(4);
 		 arrTpsz[0] = document.form.cntr_tpsz_cd_val1.value;
		 arrTpsz[1] = document.form.cntr_tpsz_cd_val2.value;
		 arrTpsz[2] = document.form.cntr_tpsz_cd_val3.value;
		 arrTpsz[3] = document.form.cntr_tpsz_cd_val4.value;
		 for ( var i=0; i<arrTpsz.length; i++) {
			 if ( arrTpsz[i] !='') {
    			 for ( var j=0; j<arrTpsz.length; j++) {
    				 if (i == j ) continue;
	    			 if ( arrTpsz[i] == arrTpsz[j] ) {
	    				ComShowCodeMessage("CIM30006", "TP/SZ");    //TP/SZ 가 중복됩니다.
	    				ComClearObject(eval("document.form.cntr_tpsz_cd_val"+(j+1)));
	    				ComSetFocus(eval("document.form.cntr_tpsz_cd_val"+(j+1)));
	    				return false;
	    			 }
    			 }
			 }
		 }      	     
     }

     /**
      * sheet1 마우스 move시
      * sheet1 마우스 move시 풍선도움말 표시,마우스 커서 변경
     */
     function sheet1_OnMouseMove( sheetObj, Button, Shift, X, Y) {
    	 Row = sheetObj.MouseRow;
    	 Col = sheetObj.MouseCol;
         var colSaveName = sheetObj.ColSaveName(Col);
         var sText = "";
         var mouseFlag = false;
         if ( colSaveName == "ea1" || colSaveName == "ea2" || colSaveName == "ea3" || colSaveName == "ea4" ) {
        	 sText = "Est. MT Vol. Avail EQ = SN + Supply(IG,RTN,RI,ON) - Demand(BR,PUP,RO,OFF)";
         } else if ( colSaveName == "br1" || colSaveName == "br2" || colSaveName == "br3" || colSaveName == "br4" ) {
        	 mouseFlag = true;
        	 sText = "Booking Reserved.  Based on MTY Pick-up Vol & Date. BKG vol, not yet picked up";
         } else if ( colSaveName == "pup1" || colSaveName == "pup2" || colSaveName == "pup3" || colSaveName == "pup4" ) {
        	 mouseFlag = true;
        	 sText = "Picked-up Vol today.";
         } else if ( colSaveName == "ro1" || colSaveName == "ro2" || colSaveName == "ro3" || colSaveName == "ro4" ) {
        	 mouseFlag = true;
        	 sText = "MTY Reposition-Out Exec. Plans. Based on ETD";
         } else if ( colSaveName == "ofh1" || colSaveName == "ofh2" || colSaveName == "ofh3" || colSaveName == "ofh4" ) {
        	 mouseFlag = true;
        	 sText = "Off-hire(LSO,SBO,TLL,LST,SCR,DON,MUO)";	
         } else if ( colSaveName == "sn1" || colSaveName == "sn2" || colSaveName == "sn3" || colSaveName == "sn4" ) {
        	 sText = "Sound MT vol, snapshot at 00:00 today";
         } else if ( colSaveName == "ig1" || colSaveName == "ig2" || colSaveName == "ig3" || colSaveName == "ig4" ) {
        	 mouseFlag = true;
        	 sText = "Est. I/B MTY Generation vol after Full Delivery. IG date = Est. Full Delivery Date in COP + ID~MT Turn Time";
         } else if ( colSaveName == "rtn1" || colSaveName == "rtn2" || colSaveName == "rtn3" || colSaveName == "rtn4" ) {
        	 mouseFlag = true;
        	 sText = "MTY Return vol today.";
         } else if ( colSaveName == "ri1" || colSaveName == "ri2" || colSaveName == "ri3" || colSaveName == "ri4" ) {
        	 mouseFlag = true;
        	 sText = "MTY Reposition-In Exec. Plans. Based on ETB/ETA";
         } else if ( colSaveName == "onh1" || colSaveName == "onh2" || colSaveName == "onh3" || colSaveName == "onh4" ) {
        	 mouseFlag = true;
        	 sText = "OW&On-hire(LSI,SBI,MUI,FND)";
         } else {
        	 sText = "";
         }
         
         if ( Row == 1) {
        	 sheetObj.MouseToolTipText = sText;	//풍선도움말 만들기
         } else {
        	 sheetObj.MouseToolTipText = "";	//풍선도움말 만들기
         }
         
         if ( mouseFlag && Row > 0 && sheetObj.RowCount > 0) {
    		 sheetObj.MousePointer = "Hand";  	// 손가락 모양으로 마우스 커서 변경
         }         
     }         

     /* 개발자 작업  끝 */