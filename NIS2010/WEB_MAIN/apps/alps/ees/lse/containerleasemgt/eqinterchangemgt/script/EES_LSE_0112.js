/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0095.js
*@FileTitle : Lease Agreement Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.26 노정용
* 1.0 Creation 
* ======================================================
* 2010.12.08 신자영 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 노정용
	 */

	/**
	 * @extends 
	 * @class ees_lse_0095 : ees_lse_0095 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0112() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setComboObject         = setComboObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initTab                = intiTab;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
		this.obj_change             = obj_change;
		this.obj_keypress           = obj_keypress;
    	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
    	this.combo1_OnBlur 			= combo1_OnBlur;
    	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
/*		this.obj_blur               = obj_blur;
		this.obj_focus              = obj_focus;
		this.obj_keyup              = obj_keyup;*/
		this.obj_keydown            = obj_keydown;
		this.t1sheet1_OnLoadFinish  = t1sheet1_OnLoadFinish;
		this.t1sheet1_OnSearchEnd   = t1sheet1_OnSearchEnd;
		this.tab1_OnChange			= tab1_OnChange;
		this.auth_no_OnChange 		= auth_no_OnChange;
	}

	/* 개발자 작업 */

	/* 공통전역변수 Start *****************************************************/
	// Tab Object Array
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	// Sheet Object Array
	var sheetObjects = new Array();
	var sheetCnt = 0;


	
	//파일업로드를 사용하기 위한
	var uploadObjects = new Array();
	var uploadCnt = 0;
	
	//Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq  = "";
	var fileUploadFlag = false;
	var fileSaveFlag = false;
	
	  /* 현재 Active 상태의 컨테이너 타입/사이즈 코드 문자열 : "|"로 연결 */
	  var vOrgCntrTpSzCd;
	  /* 현재 Active 상태의 컨테이너 타입/사이즈 코드 배열 */
	  var arrOrgCntrTpSzCd;
	
	/* 화면 설정 구분 : 조회/신규입력/수정용 */
	var formActionType;
	/* 현재 Active 상태의 컨테이너 타입/사이즈 코드 문자열 : "|"로 연결 */
	var orgCntrTpSzCd;
	/* 현재 Active 상태의 컨테이너 타입/사이즈 코드 배열 */
	var arrOrgCntrTpSzCd;

	/* 화면 설정 구분 코드 */
	var MODE_CREATE = 1001;
	var MODE_MODIFY = 1002;
	var MODE_SEARCH = 1003;
	var MODE_VRSNUP = 1004;

	/* 각 탭의 컬럼 갯수 */
	var t2TabColCnt = 0;
	var t3TabColCnt = 0;
	var t4TabColCnt = 0;
	var t5TabColCnt = 0;
	
	var SEARCH_ENABLE = true;
	
	/* 공통전역변수 End *****************************************************/

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1  = sheetObjects[0];   //t1sheet1. General
		var sheetObject2  = sheetObjects[1];   //t2sheet1. Per-diem
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
				//	sheetObject1.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;

		  		case "btn_New":

		  			//sheetObject1.RemoveAll();
		  			sheetObject1.RemoveAll();
		  			sheetObject2.RemoveAll();
		  			formObj.loc_fm_tp.value = "";
		  			formObj.loc_fm.value = "";
		  			formObj.trd.value = "";
		  			formObj.loc_tp.value  = "";
		  			formObj.loc_to.value = "";
		  			formObj.sts.value = "";
		  			formObj.stay.value = "";
					formObj.dys.value = "";
					formObj.agmt_cty_cd.value = "";
					formObj.agmt_seq.value = "";
					formObj.vndr_seq.value = "";
					formObj.vndr_nm.value = "";
					formObj.tpsz_cd.value = "";
					formObj.dpsl.checked = false;
					
		            for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
				        comboObjects[0].CheckIndex(i)=false;
					}
		            comboObjects[0].CheckIndex(0) = true;
		            formObj.org_cntr_tpsz_cd.value = vOrgCntrTpSzCd;
					arrOrgCntrTpSzCd = vOrgCntrTpSzCd.split("|");
	
                    var HeadTitle = "Status|RCC|LCC|ECC|TRADE|Term|Off-hire LOC|"+vOrgCntrTpSzCd+"|";		
			        initSheet(sheetObject1,1,HeadTitle);
			        
		  			break;
				case "btns_search":		
					if ( srcObj.style.filter == "" ) {
						openPopup("3");
					}
					break;			  			
				case "btns_search1":		
					if ( srcObj.style.filter == "" ) {
						openPopup("4");
					}
					break;	
		  		case "btns_search3":    
		  			if ( srcObj.style.filter == "" ) {
		  				openPopup("1");
		  			}
		  			break;
		  		case "btns_search4":    
		  			if ( srcObj.style.filter == "" ) {
		  				openPopup("2");
		  			}
		  			break;
				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
					break;

				case "btn_DownExcel2":
					sheetObject2.SpeedDown2Excel(-1);
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
     * Location by 변경시 이벤트 처리
     * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
     * 나머지 활성화
     */
     function loc_type_code_onchange() {
         var formObject = document.form;
         if ( formObject.loc_type_code.value == '1' || formObject.loc_type_code.value == '2') {
             formObject.loc_cd.readOnly = true;
             formObject.loc_cd.className = "input2";
             formObject.loc_cd.value = "";
         } else {
             formObject.loc_cd.readOnly = false;
             formObject.loc_cd.className = "input";
         }
//         formObject.loc_cd.value = "";
         ComSetFocus(document.form.loc_cd);
     }
 
	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		switch (event.srcElement.name) {
			case "loc_fm":
				if ( document.form.loc_fm.value !='') {				
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
				}
				break;
			case "loc_to":
				if ( document.form.loc_to.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
				}
				break;
			case "vndr_seq":
				if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
					document.form.vndr_nm.value = "";
				}
				break;	
		}
	}
	

    /**
    * LOC_CD keyup 이벤트 처리
    * LOC_CD keyup시 대분자로 처리
    */
    function loc_to_onkeyUp() {
        var formObject = document.form;
        if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && event.keyCode != 13) {
	        if ( formObject.loc_tp.value == '' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_to").setAttribute("maxLength",2);
	        	    formObject.loc_to.value = formObject.loc_to.value.substring(0,2).toUpperCase();
	            }
	        } else {
	            document.getElementById("loc_to").setAttribute("maxLength",5);
	     	   if ( formObject.loc_to.value.length == 5 ) {
	    		   ComSetFocus(document.form.loc_to);
	    	   }
	        }
        }
    }
    
    /**
     * LOC_CD keyup 이벤트 처리
     * LOC_CD keyup시 대분자로 처리
     */
     function loc_fm_onkeyUp() {
         var formObject = document.form;
         if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 && event.keyCode != 13) {
 	        if ( formObject.loc_fm_tp.value == '' ) {
 	            if ( formObject.loc_fm.value.length > 1) {
 	        	    document.getElementById("loc_fm").setAttribute("maxLength",2);
 	        	    formObject.loc_fm.value = formObject.loc_fm.value.substring(0,2).toUpperCase();
 	            }
 	        } else {
 	            document.getElementById("loc_fm").setAttribute("maxLength",5);
 	     	   if ( formObject.loc_fm.value.length == 5 ) {
 	    		   ComSetFocus(document.form.loc_fm);
 	    	   }
 	        }
         }
     }
     
     /**
      * Location by 변경시 이벤트 처리
      * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
      * 나머지 활성화
      */
      function loc_fm_onchange() {
          var formObject = document.form;
          if ( formObject.loc_fm_tp.value == '') {
              formObject.loc_fm.readOnly = true;
              formObject.loc_fm.className = "input2";
              formObject.loc_fm.value = "";
          } else {
              formObject.loc_fm.readOnly = false;
              formObject.loc_fm.className = "input";
          }
//          formObject.loc_cd.value = "";
          ComSetFocus(document.form.loc_fm);
      }
      
      /**
       * Location by 변경시 이벤트 처리
       * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
       * 나머지 활성화
       */
       function loc_to_onchange() {
           var formObject = document.form;
           if ( formObject.loc_tp.value == '') {
               formObject.loc_to.readOnly = true;
               formObject.loc_to.className = "input2";
               formObject.loc_to.value = "";
           } else {
               formObject.loc_to.readOnly = false;
               formObject.loc_to.className = "input";
           }
//           formObject.loc_cd.value = "";
           ComSetFocus(document.form.loc_to);
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
	   * IBMultiCombo Object를 배열로 등록
	   * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	   * 배열은 소스 상단에 정의
	   */
	function setComboObject(combo_obj){
	   	comboObjects[comboCnt++] = combo_obj;
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
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj){
		uploadObjects[uploadCnt++] = uploadObj;
	}

	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {


		/* IBSheet 초기화 */
		for ( var j = 0 ; j < sheetObjects.length ; j++ ) {
			var formObj = document.form;
	  		vOrgCntrTpSzCd   = ComGetObjValue(formObj.org_cntr_tpsz_cd);
	  		arrOrgCntrTpSzCd = vOrgCntrTpSzCd.split("|");
	  		
			ComConfigSheet(sheetObjects[j]);
			initSheet(sheetObjects[j], j+1);
			ComEndConfigSheet(sheetObjects[j]);
		}
		
		/* IBTab 초기화 */
		for ( var i = 0 ; i < tabObjects.length ; i++ ) {
			initTab(tabObjects[i], i+1);
		}
		
		/* Axon Control Setting*/
		initControl();
		
	  	/* IBMultiCombo 초기화 */
	  	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	  		initCombo(comboObjects[k], k+1);
	  	}
	}
	
	  /**
	  * 콤보 초기설정값, 헤더 정의
	  * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	  * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	  */
	  function initCombo(comboObj, comboNo) {
	  	switch(comboObj.id) {
	  	case "combo1":
	  		with(comboObj) {
	  			DropHeight = 200;
	  			MultiSelect = true;
	  			//MaxSelect = 1;
	  			MultiSeparator = ",";
	  			Style = 0;
	  			UseAutoComplete = true;
	  			//영문(대)+특수문자,숫자 - TP/SZ
	  			ValidChar(2,3);
	  		}
	  		break;
	  	}
	  }
	  
	  /**
	   * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	   * @return
	   */
	  function combo1_OnCheckClick(comboObj, index, code) {
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
	   * combo1_OnBlur
	   */
	  function combo1_OnBlur(comboObj, Index_Code, Text) {
	  	var formObj = document.form;
/*	  	if( comboObj.CheckIndex(0)){
	  		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
	  			comboObj.CheckIndex(i) = false;
	  		}
	  		formObj.tpsz_cd.value = "";
	  	}else if(comboObj.Text == ""){
	  		comboObj.CheckIndex(0) = true;
	  		formObj.tpsz_cd.value = "";
	  	}else{
	  	    formObj.tpsz_cd.value = ComGetObjValue(comboObj);
	  	}
		var formObj = document.form;*/
		formObj.tpsz_cd.value = ComGetObjValue(comboObj);
	  }


	  /**
	   * combo1_OnKeyDown
	   */
	  function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
/*	      with(comboObj) {
	          if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
	              comboObj.Text = "";
	  		  }else if(KeyCode == 13){
	 		      sheetObjects[0].RemoveAll();
	 			  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			  }
	  	  }*/
	      
			var formObj = document.form;
			var sheetObj = sheetObjects[0];

			with(comboObj) {
				if ( KeyCode == 8 || KeyCode == 46 ) {
					for ( var i = 0 ; i < GetCount() ; i++ ) {
						if ( CheckIndex(i) ) {
							//CheckIndex(i) = false;
						}
					}
				} else if(KeyCode == 13) {
					formObj.tpsz_cd.value = ComGetObjValue(comboObj);
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
			}
	  }
	  	  

  	/* Axon 이벤트 처리 Start ****************************************************************************/
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
		//axon_event.addListenerFormat('beforedeactivate', 'obj_blur',		formObj); //- 포커스 나갈때
  	  	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
  	  	axon_event.addListenerForm('change','obj_change',formObj);       //- 변경될때.
  	  	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
  	  	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
  	  	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
  	  	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
  	    axon_event.addListener('keyup', 'loc_to_onkeyUp', 'loc_to', '');
  	    axon_event.addListener('keyup', 'loc_fm_onkeyUp', 'loc_fm', '');
  	    axon_event.addListener('change', 'loc_fm_onchange', 'loc_fm_tp', '');
  	    axon_event.addListener('change', 'loc_to_onchange', 'loc_tp', '');
  	      
  	}

/*  	// 2. 이벤트처리함수 -- Start
  	*//**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 *//*
	function obj_blur() {
		var obj = event.srcElement;

	    switch(obj.name){
	        case "agmt_seq":
	        	 숫자이면서 천단위 구분을 하지 않는다. 
	            //if ( !ComChkObjValid(obj, true, false, false) ) {
	            //	ComSetObjValue(obj, "");
	    		//}
	            break;

	        case "vndr_seq":
	             숫자이면서 천단위 구분을 하지 않는다. 
	            ComChkObjValid(obj, true, false, false);
	            break;

	        default:
	             Validation 전체 체크(길이,format,최대,최소 등등) 
	            ComChkObjValid(obj);
	        	break;
	    }
  	}*/

/*	*//**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 *//*
	function obj_focus(){
		var obj  = event.srcElement;
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		     마스크구분자 없애기 
		    ComClearSeparator(event.srcElement);
		}
	}*/

	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		
		switch(obj.name) {
		case "loc_fm_tp":
			formObj.loc_fm.value = '';
			break;

		case "loc_tp":
			formObj.loc_to.value = '';
			break;

		case "stay":
			formObj.dys.value = '';
			break;
		case "agmt_seq":
			if ( formObj.agmt_seq.value != null && formObj.agmt_seq.value != "" ) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
			}
			break;
		case "vndr_seq":
			if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC06);
			}
			break;	
		}	    
	}

	/**
	 * HTML Control의 Key-Press Event 처리한다.
	 */
  	function obj_keypress() {
		var obj = event.srcElement;
		//alert(event.keyCode);
		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	        	if ( obj.name == "lse_ctrt_no" || obj.name == "ref_no" ) {
	        		ComKeyOnlyAlphabet("num","45|95");
	        	} else {
	        		ComKeyOnlyAlphabet();
	        	}
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
			case "loc_fm":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "loc_to":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;	    
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

/*  	*//**
  	 * HTML Control의 Key-Up Event 처리한다.
  	 *//*
  	function obj_keyup() {
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
			case "agmt_seq":
  				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

 			case "vndr_seq":
  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
  					ComSetObjValue(formObj.vndr_nm,"");
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

 			default:
  				ComKeyEnter('LengthNextFocus');
  				break;
  		}
  	}*/


  	function obj_keydown() {
  		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch (obj.name) {
  			case "loc_fm": 
		  		if ( vKeyCode == 13 ) {
		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		  		}
		  		break;

  			case "loc_to":
		  		if ( vKeyCode == 13 ) {
		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		  		}
		  		break;
  		}
  	}

   	function obj_click() {
   		var obj     = event.srcElement;
   		var formObj = document.form;

   		switch (obj.name) {
   			case "lse_vndr_url" :
   				if ( ComGetObjValue(formObj.lse_vndr_url) != "" ) {
   					var url = ComGetObjValue(formObj.lse_vndr_url);
   					if ( (url.substr(0,4)).toLowerCase() != "http" ) {
   						url = "http://" + url;
   					}
   					window.open(url,"_blank");
   					return;
   				}
   				break;
   		}
   	}

  	// 2. 이벤트처리함수 -- End
  	/* Axon 이벤트 처리 End ****************************************************************************/

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo, hTitle) {
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "t1sheet1":      // t1sheet1 init
				with (sheetObj) {
				
				sheetObj.RemoveEtcData();
	   			// 높이 설정
	   			style.height = 365;
	   			SheetWidth = mainTable.clientWidth;
	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msPrevColumnMerge;
	  			//전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	  			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	   			InitRowInfo(1, 1, 20, 100);
		
	   			var HeadTitle = "Status|RCC|LCC|ECC|TRADE|Term|Off-hire Loc|"+vOrgCntrTpSzCd; 
	   			if(hTitle != undefined ){
		  			var HeadTitle = hTitle;
	   			}
	   			
/*	   			//전체 너비 설정
	   			if(arrOrgCntrTpSzCd.length<7){
	   				style.width = 200;
	   			}else{
	   				SheetWidth = mainTable.clientWidth;
	   			}*/
	   			
	   			//style.width = 200;

	   			var headCount   = ComCountHeadTitle(HeadTitle);
	   			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	   			InitColumnInfo(headCount, 7, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
	   		    InitHeadMode(false, true, true, true, false,false)
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

	   			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"sts",			false,	"",	dfNone);
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	false,	"rcc_cd",		false,	"",	dfNone);
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	false,	"lcc_cd",			false,	"",	dfNone);					
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	false,	"ecc_cd",		false,	"",	dfNone);					
				InitDataProperty(0, cnt++ , dtData,		60,daLeft,		false,	"trd",			false,	"",	dfNone);
				InitDataProperty(0, cnt++ , dtData,		60,daLeft,		false,	"lstm_cd",			false,	"",	dfNone);
				InitDataProperty(0, cnt++ , dtData,		75,daLeft,		false,	"off_hire_loc",			false,	"",	dfNone);
				for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
					eval('InitDataProperty(0, cnt++, dtData, 60, daRight, false, "cntr'+(i+1)+'_qty", false, "", dfInteger);');
				}
	 		
	   			//SelectBackColor = LSE_SELECT_BACK_COLOR;
	   		}
	   		break;

			case "t2sheet1":      // t2sheet1 init
				with (sheetObj) {
	   			// 높이 설정
	   			style.height = 365;
	   			//전체 너비 설정
	   			SheetWidth = mainTable.clientWidth;
	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msNone;
	  			//전체Edit 허용 여부 [선택, Default false]
	   			Editable = false;
	  			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  			InitRowInfo( 1, 1, 3, 100);
	  			var HeadTitle = "RCC|LCC|ECC|CNTR No.|Term|T/Size|Quantity|Trade|Off-hire LOC|Target DOL|MVNT|MVNT Date|MVNT Yard|MVNT ECC DOL|On-hire Date|F/Days|Using Days|Lessor|AGMT No.|Approval Date|S.Days"		
	   			var headCount   = ComCountHeadTitle(HeadTitle);
	   			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	   			InitColumnInfo(headCount, 4, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
	   		    InitHeadMode(true, true, true, true, false,false);
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

	   			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"rcc_cd",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"lcc_cd",		false,	"",	dfNone, 0, false, false, -1, true);					
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"ecc_cd",		false,	"",	dfNone, 0, false, false, -1, true);					
				InitDataProperty(0, cnt++ , dtData,		90, daCenter,	true,	"cntr_no",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"lstm_cd",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"cntr_tpsz_cd", false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"onh_qty",	    false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"trd",			false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"off_hire_loc",	false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"target_dol",	false,	"",	dfNone, 0, false, false, -1, true);					
				InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,	"cnmv_sts_cd",	false,	"",	dfNone, 0, false, false, -1, true);					
				InitDataProperty(0, cnt++ , dtData,		110,daCenter,	true,	"cnmv_dt",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		75, daCenter,	true,	"crnt_yd_cd",	false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		90, daCenter,	true,	"mvnt_dol",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		110,daCenter,	true,	"onh_dt",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"free_dys",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"using_days",	false,	"",	dfNone, 0, false, false, -1, true);					
				InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"lessor",		false,	"",	dfNone, 0, false, false, -1, true);					
				InitDataProperty(0, cnt++ , dtData,		65, daCenter,	true,	"agmt_seq",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		110,daCenter,	true,	"app_dt",		false,	"",	dfNone, 0, false, false, -1, true);
				InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"s_days",		false,	"",	dfNone, 0, false, false, -1, true);

	   			SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

		}
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
                     InsertTab( cnt++ , "Summary",			-1 );
                     InsertTab( cnt++ , "Detail",			-1 );
                 }
                 break;
         }
     }



	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */ 
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCREATE:
/*				sheetObj.WaitImageVisible = false;
				
				 Lease Term Form Combo Item Setting 
				ComSetObjValue(formObj.f_cmd, SEARCH01);
		     	var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		        if ( sXml != "" ) {
		        	LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		        }

		         DEPR Level Form Combo Item Setting 
				var strText = "Daily|Monthly|Yearly";
        		var strCode = "D|M|Y";

        		LseComText2ComboItem(comboObjects[1], strText, strCode, "|");

		         DPC_VAL_FLG Level Form Combo Item Setting 
				var strText2 = "Manufacture Date|On-Hire Date";
        		var strCode2 = "N|Y";

        		LseComText2ComboItem(comboObjects[2], strText2, strCode2, "|");

        		 Container Type/Size Grid Combo Item Setting 
        		if ( orgCntrTpSzCd != "" ) {
        			sheetObj.InitDataCombo(0, "cntr_tpsz_cd", " |"+orgCntrTpSzCd, " |"+orgCntrTpSzCd);
        		}

        		ComSetFocus(formObj.agmt_seq);
		        sheetObj.WaitImageVisible = true;*/
		        break;

			case IBSEARCH:      //조회
				/* Org 컨테이너 타입/사이즈 코드 재설정 : Form Data 설정시 Org 컨테이너 타입/사이즈 코드 데이터가 삭제됨으로 재설정. */
				//ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);

				//if(validateForm(sheetObj,formObj,sAction)) {
				ComOpenWait(true);
				
				if(formObj.loc_to.value == '' && formObj.loc_tp.value != ''){
					ComOpenWait(false);
					ComShowCodeMessage("LSE01037");
					 break;
				}
				
				if(formObj.loc_fm.value == '' && formObj.loc_fm_tp.value != ''){
					ComOpenWait(false);
					ComShowCodeMessage("LSE01037");
					 break;
				}
				
				if(formObj.tpsz_cd.value != ''){
					formObj.org_cntr_tpsz_cd.value =  ComReplaceStr(formObj.tpsz_cd.value,",","|");	
				}else{
					formObj.org_cntr_tpsz_cd.value = vOrgCntrTpSzCd;
				}
				
				arrOrgCntrTpSzCd = formObj.org_cntr_tpsz_cd.value.split("|");
				
				 var HeadTitle = "Status|RCC|LCC|ECC|TRADE|Term|Off-hire Loc|"+formObj.org_cntr_tpsz_cd.value+"|";				 
				 initSheet(sheetObj,1,HeadTitle);

				//sheetObj.Redraw = false;
        		ComSetObjValue(formObj.f_cmd, SEARCH01);

				//sheetObj.WaitImageVisible = false;
				
				var sXml = sheetObj.GetSearchXml("EES_LSE_0112GS.do" , FormQueryString(formObj));


					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
					if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);

				ComOpenWait(false);
				
				//sheetObject2.FitSize(false, true);	
				
			//	}
	            break;
	            
			case IBSEARCH_ASYNC03:
		  		/* Lease Term Form Combo Item Setting */
		  		//ComSetObjValue(formObj.f_cmd, SEARCH01);
		  		ComSetObjValue(formObj.f_cmd, SEARCH02);
		  		sheetObj.WaitImageVisible = false;
		  		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		  		if ( sXml != "" ) {
		  			//comboObjects[0].InsertItem(0 , 'ALL','ALL');
		  			comboObjects[0].InsertItem(0 , 'ALL','');
		  			LseComXml2ComboItem(sXml, comboObjects[0], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
		  		}
		  		//vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");
	        	vOrcCntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
		  		break;	
 			case IBSEARCH_ASYNC02:	//조회(Form Lessor No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
					var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetNextFocus(formObj.vndr_seq);
	 						} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.vndr_seq, "");
	 							ComSetObjValue(formObj.vndr_nm, "");
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.vndr_seq, "");
							ComSetFocus(formObj.vndr_seq);
						}
 				}
 				break;
 			case IBSEARCH_ASYNC01:	//조회(Form Lessor No. 입력시)
				var inquiryLevel = "";
				if ( formObj.loc_fm_tp.value == 'RCC' ) {
					inquiryLevel = "R";
				} else if ( formObj.loc_fm_tp.value == 'LCC' ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_fm_tp.value == 'ECC' ) {
					inquiryLevel = "E";
				} else if  ( formObj.loc_fm_tp.value == 'SCC' ) {
					inquiryLevel = "S";
				} else{
					break;
				} 
				
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_fm.value;
				formObj.f_cmd.value = SEARCH04;
				if (formObj.loc_fm.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_fm.value != "") {
						ComShowCodeMessage("LSE01037");
						document.form.loc_fm.value = "";
						ComSetFocus(document.form.loc_fm);
						return false;
					} else {
						return true;
					}
				}
				break;
 			case IBSEARCH_ASYNC04:	//조회(Form Lessor No. 입력시)
				var inquiryLevel = "";
				if ( formObj.loc_tp.value == 'RCC' ) {
					inquiryLevel = "R";
				} else if ( formObj.loc_tp.value == 'LCC' ) {
					inquiryLevel = "L";
				} else if  ( formObj.loc_tp.value == 'ECC' ) {
					inquiryLevel = "E";
				} else if  ( formObj.loc_tp.value == 'SCC' ) {
					inquiryLevel = "S";
				} else{
					break;
				} 
				
				formObj.inquiryLevel.value = inquiryLevel;
				formObj.location.value = formObj.loc_to.value;
				formObj.f_cmd.value = SEARCH04;
				if (formObj.loc_to.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_to.value != "") {
						ComShowCodeMessage("LSE01037");
						document.form.loc_to.value = "";
						ComSetFocus(document.form.loc_to);
						return false;
					} else {
						return true;
					}
				}
				break;
 			case IBSEARCH_ASYNC05:	//조회(Form Lessor No. 입력시)
 				formObj.f_cmd.value = SEARCH03;
			    sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
				sheetObj.WaitImageVisible = true;
				if ( ComGetEtcData(sXml, "ref_no") != undefined ) {
					formObj.vndr_seq.value = ComGetEtcData(sXml, "vndr_seq");
					formObj.vndr_nm.value  = ComGetEtcData(sXml, "vndr_lgl_eng_nm");

				} else {
					ComShowCodeMessage("LSE01007");
				}					
				break;
 			case IBSEARCH_ASYNC06:	//조회(Form Lessor No. 입력시)
 				var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
 			//	sheetObj.WaitImageVisible = false;
 				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
 			//	sheetObj.WaitImageVisible = true;

 				if ( sXml != "" ) {
 					if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
 						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
 						ComSetFocus(formObj.vndr_nm);
 					} else {
 						ComShowCodeMessage("LSE01019");
 						formObj.vndr_seq.value = "";
 						formObj.vndr_nm.value  = "";
 						ComSetFocus(formObj.vndr_seq);
 					}
 				} else {
 					ComShowCodeMessage("LSE01019");
 					formObj.vndr_seq.value = "";
 					formObj.vndr_nm.value  = "";
 					ComSetFocus(formObj.vndr_seq);
 				}					
				break;	
			case IBDOWNEXCEL:
 				with(sheetObj) {
 					var vSheetName = ComReplaceStr(tabObjects[0].TabText(tabObjects[0].SelectedIndex),"/","_");
					if ( ToTalRows < 1 ) {
						var row = DataInsert(0);
						RowHidden(row) = true;
						Down2Excel(-1, false, false, true, "", "", false, false, vSheetName);
						RowDelete(row, false);
					} else {
						Down2Excel(-1, false, false, true, "", "", false, false, vSheetName);
					}
 				}
 				break;
		}
	}

	function t1sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	  	doActionIBSheet(sheetObj, formObj,IBSEARCH_ASYNC03);
		comboObjects[0].CheckIndex(0) = true;
	}
	


	/**
	 * Lease Agreement Master/General Tab IBSheet Object Search-End Event
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		
		for(var i=1; i<=sheetObj.LastRow; i++){
	   		if(sheetObj.CellValue(i,0) == 'Total' || sheetObj.CellValue(i,0) == 'S.Total'){
	   			sheetObj.RowBackColor(i) = sheetObj.RgbColor(247,225,236);
	   			sheetObj.CellFont("FontBold", i, 0) = true;	
	   		}	
		}
		

	//	if ( ErrMsg == "" ) {

/*			//ComEtcDataToForm(formObj, sheetObj);

			 InActive CheckBox Setting 
			if ( ComGetObjValue(formObj.agmt_act_flg) == "Y" ) {
				formObj.chk_agmt_act_flg.checked = true;
			} else {
				formObj.chk_agmt_act_flg.checked = false;
			}

			 ICF Flag CheckBox Setting 
			if ( ComGetObjValue(formObj.itchg_fee_flg) == "Y" ) {
				formObj.chk_itchg_fee_flg.checked = true;
			} else {
				formObj.chk_itchg_fee_flg.checked = false;
			}



			 DPP Coverage 의 값이 'N' 일 경우 DPP Tab 비활성화 
			if ( ComGetObjValue(formObj.dpp_tp_cd) == "Y" ) {
				if ( tabObjects[0].TabEnable(5) == false ) {
					tabObjects[0].TabEnable(5)= true;
				}
			} else {
				if ( tabObjects[0].TabEnable(5) == true ) {
					tabObjects[0].TabEnable(5)= false;
				}
			}

			 Mask 추가 
			ComAddSeparator(form.eff_dt, "ymd");
			ComAddSeparator(form.exp_dt, "ymd");
			ComAddSeparator(form.agmt_dt, "ymd");
			ComAddSeparator(form.bld_up_dt, "ymd");

			 Duration 계산 
			//setDuration();

			 Lease Term 에 따른 General Sheet Control 
			//control_Spec_No(ComGetObjValue(formObj.combo1));

			sheetObj.Redraw = true;

			 화면모드를 조회모드로 설정 
			//setFormEnable(MODE_SEARCH, formObj);

			//tabObjects[0].SelectedIndex = 0;

		} else {
			ComResetAll();

			 조회가능하도록 Form 설정 
			//setFormEnable(MODE_SEARCH, formObj);
		}*/

	   //	sheetObj.SelectHighLight = false;
	   	sheetObj.Redraw = true;

/*		 Org 컨테이너 타입/사이즈 코드 재설정 : Form Data 설정시 Org 컨테이너 타입/사이즈 코드 데이터가 삭제됨으로 재설정. 
		ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);*/
	}

	/**
	 * Penalty Tab IBSheet Object Search-End Event
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;

		if ( sheetObj.SearchRows > 0 ) {
			ComSetObjValue(formObj.agmt_chg_val, sheetObj.CellValue(1,"agmt_chg_val"));
		} else {
			ComSetObjValue(formObj.agmt_chg_val, "");
			sheetObj.CellValue(1, "loc_cd") = "KRSEL";
			sheetObj.RowStatus(1) = "R";
		}
	}
	
    
    /**
	 * sheet7_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function t7sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var linkFlag = CellValue(MouseRow, MouseCol) != "";
			DataLinkMouse("file_path_nm") = linkFlag;
		}
	}		
	
	/**
	 * sheet7_OnClick
	 */
	function t7sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);

		if(sheetObj.MousePointer != "Hand") return;

		with(sheetObj) {
			switch(sName) {
				case "file_path_nm":
					location.href = "/hanjin/FileDownload?key="+CellText(Row, "org_file_nm");
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
		var formObj = document.form;
		var objs    = document.all.item("tabLayer");

		objs[nItem].style.display     = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 ------------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//--------------------------------------------------------//
		beforetab = nItem;

/*		 General Tab에 있는 Container Type/Size Column만 Show 
		switch(nItem) {
			case 1 :	// Per-diem
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[1]);
				break;
	
			case 2 :	// Lifting Charges
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[2]);
				break;
		}*/
	}  

	/**
	 * Sheet Object 내 Container Type/Size 코드들을 문자열로 반환
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function getGeneralCntrTypeSizes(sheetObj) {
		var vSelectedCntrTpSz = "";
		if ( sheetObj.RowCount > 0 ) {
			for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
				if ( sheetObj.RowHidden(i) == false ) {
					if ( vSelectedCntrTpSz != "" ) {
						vSelectedCntrTpSz = vSelectedCntrTpSz + "|" + sheetObj.CellValue(i, "cntr_tpsz_cd");
					} else {
						vSelectedCntrTpSz = sheetObj.CellValue(i, "cntr_tpsz_cd");
					}
				}
			}
		}
		return vSelectedCntrTpSz;
	}

    /**
	 * Per-diem/Lifting Charges/DOLDOC/Penalty Tab Container Type/Size Setting
	 * Target Sheet 의 Container Type/Size Column 형태로 있는 경우
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeColumns(sourceSheetObj, targetSheetObj) {
		var vSelectedCntrTpSz = getGeneralCntrTypeSizes(sourceSheetObj);
		var vShowSheetWidth   = 0;
		var vStartCntrColIdx  = 0;

		if ( vSelectedCntrTpSz != "" ) {
			with(targetSheetObj) {
				if ( FrozenCols == 0 ) {
					vStartCntrColIdx = 1;
				} else {
					vStartCntrColIdx = FrozenCols;
				}

				/* Frozen된 Column의 Width 계산(Hidden Column 제외) */
				for ( var colIdx = 0 ; colIdx < vStartCntrColIdx ; colIdx++ ) {
					if ( ColHidden(colIdx) == false ) { 
						vShowSheetWidth = vShowSheetWidth + ColWidth(colIdx);
					}
				}

				Redraw = false;
				/* General Tab에 입력된 Container Type/Size Column의 Width 계산  */
				for ( var colIdx = vStartCntrColIdx ; colIdx <= LastCol ; colIdx++ ) {
					/* Header Title이 있으면서 General Grid에 있는 Container Type/Size Code와 같을 경우 Hidden false, 다를 경우 Hidden true */
					if ( CellValue(0, colIdx) != "" ) {
						if ( vSelectedCntrTpSz.match(CellValue(0, colIdx)) ) {
							if ( ColHidden(colIdx) == true ) {
								ColHidden(colIdx) = false;
							}
							vShowSheetWidth = vShowSheetWidth + ColWidth(colIdx);
						} else {
							if ( ColHidden(colIdx) == false ) {
								//for ( var i = HeaderRows ; i <= RowCount+(HeaderRows-1) ; i++ ) {
								for ( var i = HeaderRows ; i <= LastRow ; i++ ) {
									CellValue2(i, colIdx) = "";
								}
								ColHidden(colIdx) = true;
							}
						}
					}
				}

				if ( RowCount >= ViewRows ) {
					vShowSheetWidth = vShowSheetWidth + 20;
				} else {
					vShowSheetWidth = vShowSheetWidth + 10;
				}

				if ( vShowSheetWidth > mainTable.clientWidth-20 ) {
					SheetWidth = mainTable.clientWidth-20;
				} else {
					SheetWidth = vShowSheetWidth;
				}

				Redraw = true;
			}
		}

		targetSheetObj.Visible = true;
	}

    /**
	 * DPP Tab Container Type/Size Setting
	 * Target Sheet 의 Container Type/Size Row 형태로 있는 경우
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeRows(sourceSheetObj, targetSheetObj) {
		var formObj = document.form;

		/* Source Sheet Container Type/Size */
		var vGeneralCntrTpSz = getGeneralCntrTypeSizes(sourceSheetObj);

		/* Target Sheet Container Type/Size */
		var vDppCntrTpSz     = getGeneralCntrTypeSizes(targetSheetObj);

		with(targetSheetObj) {
			if ( RowCount > 0 ) {
				/* Target Sheet Container Type/Size 가 있을 경우 비교하여 입력 */
				if ( (vGeneralCntrTpSz != "") && (vGeneralCntrTpSz != vDppCntrTpSz) ) {
					var arrGeneralCntrTpSz = vGeneralCntrTpSz.split("|");
					/* DPP Sheet에 없을 경우 신규입력 */
					for ( var i = 0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						if ( !vDppCntrTpSz.match(arrGeneralCntrTpSz[i]) ) {
							var Row = DataInsert(-1);
							CellValue2(Row, "cntr_tpsz_cd")        = arrGeneralCntrTpSz[i];
							CellValue2(Row, "loc_cd")              = "KRSEL";
							CellValue2(Row, "cntr_rntl_chg_tp_cd") = "DPPV";
						}
					}
					var arrDppCntrTpSz = vDppCntrTpSz.split("|");
					for ( var i = 0 ; i < arrDppCntrTpSz.length ; i++ ) {
						if ( !vGeneralCntrTpSz.match(arrDppCntrTpSz[i]) ) {
							var Row = FindText("cntr_tpsz_cd", arrDppCntrTpSz[i]);
							RowHidden(Row)= true;		//1.행 숨기기
							RowStatus(Row)= "D";		//2.트랜잭션 상태 "삭제"로 만들기
						}
					}
				}
			} else {
				/* DPP Sheet에 Container Type/Size 가 없을 경우 모두 입력 */
				if ( vGeneralCntrTpSz != "" ) {
					var arrGeneralCntrTpSz = vGeneralCntrTpSz.split("|");
					for ( var i = 0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						var Row = DataInsert(-1);
						CellValue2(Row, "cntr_tpsz_cd")        = arrGeneralCntrTpSz[i];
						CellValue2(Row, "loc_cd")              = "KRSEL";
						CellValue2(Row, "cntr_rntl_chg_tp_cd") = "DPPV";
					}
				}
			}
		}
	}

	 /**
	  * Pop-up Open 부분<br>
	  * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
	  * @param object 대상 Object
	  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	  */
	  function openPopup(type, Row, Col) {
	  	var formObj = document.form;
	  	if ( type == "1" ) {
			switch(formObj.loc_fm_tp.value) {
			case "RCC" :	//RCC
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_fm", "1,0,1,1,1,1,1", true);
				break;
			case "LCC" :	//LCC
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_fm", "1,0,1,1,1,1,1", true);
				break;
			case "SCC" :	//SCC
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_fm", "1,0,1,1,1,1,1", true);
				break;
			case "ECC" :	//SCC
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"ecc_cd:loc_fm", "1,0,1,1,1,1,1", true);
				break;
			case "CN" :	//contury
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"cnt_cd:loc_fm", "1,0,1,1,1,1,1", true);
				break
			default:	//do nothing
			}
		}else if (type == "2"){
			switch(formObj.loc_tp.value) {
			case "RCC" :	//RCC
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_to", "1,0,1,1,1,1,1", true);
				break;
			case "LCC" :	//LCC
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_to", "1,0,1,1,1,1,1", true);
				break;
			case "SCC" :	//SCC
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_to", "1,0,1,1,1,1,1", true);
				break;
			case "ECC" :	//SCC
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"ecc_cd:loc_to", "1,0,1,1,1,1,1", true);
				break;
			case "CN" :	//contury
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"cnt_cd:loc_to", "1,0,1,1,1,1,1", true);
				break
			default:	//do nothing
			}
		}else if (type == "3") {
	  		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
		}else if (type == "4") {
			ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 430, 'setPopData_Agreement', '1,0', true);
		}
	  }

	/**
	 * Agreement Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
		}
	}

	/**
	 * Agreement Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_AgreementVer(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq,     aryPopupData[0][4]);
			ComSetObjValue(formObj.agmt_ver_seq, aryPopupData[0][8]);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
      	}
	}
	
	/**
	 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj = sheetObjects[SheetIdx];
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
		}
	}	

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			return ComChkValid(formObj);
    			break;
		}

		return true;
	}

	/**
	 * Effective Date 입력 시 Duration 계산 처리 부분<br>
	 */
    function setDuration() {
    	var formObj = document.form;

    	if ( !checkEffDate() ) {
       		ComSetFocus(formObj.exp_dt);
       		return;
       	}

   		var input1 = ComReplaceStr(ComGetObjValue(formObj.eff_dt), "-", "");
   		var input2 = ComReplaceStr(ComGetObjValue(formObj.exp_dt), "-", "");
   		var duration = LseComGetMonthsDateDiff(input1, input2);
		ComSetObjValue(formObj.dt_drtn, duration);
    }

	/**
	 * Effective Date Validation 처리 부분<br>
	 */
    function checkEffDate() {
    	var formObj = document.form;

		/* Effective Date Validation(eff_dt) */
		if( ComGetObjValue(formObj.eff_dt) == "" ) {
			ComShowCodeMessage("LSE01010");
			ComSetFocus(formObj.eff_dt);
			return false;
		} else if ( !ComIsDate(formObj.eff_dt) ) {
			ComShowCodeMessage("LSE01020");
			ComSetObjValue(formObj.eff_dt,"");
			ComSetFocus(formObj.eff_dt);
			return false;
		}

		/* Effective Date Validation(exp_dt) */
		if( ComGetObjValue(formObj.exp_dt) == "" ) {
			ComShowCodeMessage("LSE01011");
			ComSetFocus(formObj.exp_dt);
			return false;
		} else if ( !ComIsDate(formObj.exp_dt) ) {
			ComShowCodeMessage("LSE01026");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}

		/* Effective Date Validation(eff_dt < exp_dt) */
		var vEffDt = ComReplaceStr(ComGetObjValue(formObj.eff_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.exp_dt),"-","");
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01051");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}

		return true;
    }

	/*
	 * Container Spec No. Cell Control
	 * - Lease Term 이 'LT' 일 경우에만 Genearl Data 의 Spec No. 입력 가능.
	 * - 2009.09.16 by 이유목 수석 요청
	 */
	function control_Spec_No (text) {
		var sheetObj = sheetObjects[0];

		if ( text == "LT" ) {
			sheetObj.ColHidden("cntr_spec_no") = false;
		} else {
			sheetObj.ColHidden("cntr_spec_no") = true;
		}
	}

	/* 개발자 작업  끝 */
