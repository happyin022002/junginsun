/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0111.js
 *@FileTitle : EQ interchange Pick-up/Off-hire Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.09
 *@LastModifier : 이유목
 *@LastVersion : 1.0
 * 2015.06.09 이유목
 * 1.0 Creation
 * 
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
	 * @class EES_LSE_0111 : EES_LSE_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0111() {
		this.processButtonClick	= processButtonClick;
		this.setSheetObject 	= setSheetObject;
		this.setComboObject 	= setComboObject;
		this.loadPage 			= loadPage;
		this.sheet1_OnLoadFinish = sheet1_OnLoadFinish;
		this.initControl 		= initControl;
		this.obj_blur 			= obj_blur;
		this.obj_focus 			= obj_focus;
		this.obj_change 		= obj_change;
		this.obj_keypress 		= obj_keypress;
		this.obj_keyup 			= obj_keyup;
		this.obj_keydown 		= obj_keydown;
		this.initSheet 			= initSheet;
		this.initCombo 			= initCombo;
		this.doActionIBSheet 	= doActionIBSheet;
		this.sheet1_OnMouseMove = sheet1_OnMouseMove;
		this.sheet1_OnDblClick 	= sheet1_OnDblClick;
		this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
		this.combo1_OnCheckClick = combo1_OnCheckClick;
		this.combo2_OnCheckClick = combo2_OnCheckClick;
		this.combo1_OnBlur 		= combo1_OnBlur;
		this.combo2_OnBlur 		= combo2_OnBlur;
		this.combo1_OnKeyDown 	= combo1_OnKeyDown;
		this.combo2_OnKeyDown 	= combo2_OnKeyDown;
		this.openPopup 			= openPopup;
		this.setPopData_Agreement = setPopData_Agreement;
		this.setPopData_Country = setPopData_Country;
		this.setPopData_Lessor 	= setPopData_Lessor;
		this.validateForm 		= validateForm;
		this.checkDurationDate 	= checkDurationDate;
		this.clearForm 			= clearForm;
	}


	/* 개발자 작업	*/

	// 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

//	var vCntrTpszHdr = "| | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
//	var vArrCntrTpsz = vCntrTpszHdr.split("|");
//	var vCntrTpszCnt = vArrCntrTpsz.length;

	var vOrcLstmCd = "";
   	var vOrcCntrTpszCd = "";
   	var vCntrTpszCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");
    		
            switch(srcName) {
//            	case "total_flg" :
//            		sheetObject1.ColHidden("loc_cd") = srcObj.checked;
//            		break;
            	case "lst_sts_flg" :
//	  				if ( ComGetObjValue(srcObj) == "02" ) {
//	  					formObj.str_evnt_dt.className = "input1";
//	  					formObj.end_evnt_dt.className = "input1";
//	  				} else {
	  					formObj.str_evnt_dt.className = "input";
	  					formObj.end_evnt_dt.className = "input";
	  					
//	  				}
	  						  					
    				if (formObj.cntr_sts_cd.value == "OF"){
    					if ( ComGetObjValue(srcObj) == "01" )
    	    	        	var HeadTitle1 = "From RCC|From LCC|T/Size|Auth Vol.|P/up Vol.|O/B Match|Balance|Lessor|AGMT|Auth No.|Creation Date|S/Days|" //+ vCntrTpszHdr;
       					if ( ComGetObjValue(srcObj) == "02" )
    	    	        	var HeadTitle1 = "From RCC|From LCC|T/Size|Auth Vol.|P/up Vol.|Off-hired|Balance|Lessor|AGMT|Auth No.|Creation Date|S/Days|" //+ vCntrTpszHdr;				
    				}
        	        sheetObjects[0].InitHeadRow(0, HeadTitle1);
  					break;

				case "btn_Retrieve":
					dcondTD.innerHTML = "&nbsp;"
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;

				case "btn_New":
					dcondTD.innerHTML = "&nbsp;"
					ComResetAll();
					sheetObject1.SheetWidth = 984;
//					for( var i = 1; i < vCntrTpszCnt; i++ ) {
//						if(vArrCntrTpsz[i] != "") {
//							eval('sheetObject1.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
//						} else {
//							eval('sheetObject1.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
//						}
//					}

					formObj.loc_cd.readOnly = true;
					formObj.loc_cd.className = "input2";
					formObj.loc_cd2.readOnly = true;
					formObj.loc_cd2.className = "input2";
					formObj.str_evnt_dt.className = "input";
	  				formObj.end_evnt_dt.className = "input";
					ComEnableObject(formObj.btns_search, false);
					ComEnableObject(formObj.btns_search2, false);
					sheetObjects[0].CellText(0, "loc_cd") = "RCC";
//					sheetObjects[0].CellText(0, "loc_cd2") = "RCC";
					sheetObjects[0].ColHidden("loc_cd") = false;
//					sheetObjects[0].ColHidden("loc_cd2") = false;
					ComSetFocus(formObj.lst_sts_flg[0]);
					break;

				case "btn_DownExcel":
					//sheetObject1.SpeedDown2Excel(-1);
					sheetObject1.Down2Excel(-1, false, false, true);
					break;

				case "btn_DownExcel2":
					sheetObject2.SpeedDown2Excel(-1);
					break;

				case "btns_search":	//Form Location. 조회 팝업
 					openPopup("1");
 					break;

				case "btns_search2": //Form Location2. 조회 팝업
					openPopup("2");
					break;

				case "btns_search3": // Form Lessor Search
					openPopup("3");
					break;

				case "btns_calendar":	// Event Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.str_evnt_dt, formObj.end_evnt_dt, 'yyyy-MM-dd');
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		var formObj = document.form;

        /* IBSheet 초기화 */
		 for( var i = 0 ; i < sheetObjects.length ; i++ ) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);

			//khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		}

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
    }

    /**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

     	/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

		/* Axon Control Setting*/
		initControl();

		/* 초기 Focus Setting */
		ComEnableObject(formObj.btns_search, false);
		ComEnableObject(formObj.btns_search2, false);
		ComSetFocus(formObj.cntr_sts_cd[0]);
		sheetObjects[0].CellText(0, "loc_cd") = "RCC";
		
    }

    /**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet2_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* Container Type Size Dynamic Header Setting */
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC05);

		/* IBSheet 재설정 */
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[0] );
		initSheet(sheetObjects[0],1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[0]);
		sheetObjects[0].ScrollBar = 3;
    }

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm('focus',			'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',		'obj_change',	formObj); //- 변경될때.
  	}

	//이벤트 중복방지 변수
	var preEventType = null;
  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name){
//	    	case "agmt_seq" :
	    	case "vndr_seq" :
	    		/* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	            break;

			default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj);
	        	break;
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus(){
		var obj  = event.srcElement;
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //마스크구분자 없애기
		    ComClearSeparator(event.srcElement);
		}
	}

	/**
	 * OnChange Event 처리
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		switch(obj.name) {
			case "loc_tp":		//Location Type
				formObj.loc_cd.value = "";
				if(obj.value == "0" ) {
					formObj.loc_cd.readOnly = true;
					formObj.loc_cd.className = "input2";
					ComEnableObject(formObj.btns_search, false);
					sheetObj.CellText(0, "loc_cd") = "ALL";
				} else {
					formObj.loc_cd.readOnly = false;
					formObj.loc_cd.className = "input";
					ComEnableObject(formObj.btns_search, true);
					formObj.loc_cd.maxLength = obj.value == "5" ? 2 : 5;
					ComSetNextFocus(obj);
					if(obj.value == "1") {
						sheetObj.CellText(0, "loc_cd") = "RCC";
					} else if(obj.value == "2") {
						sheetObj.CellText(0, "loc_cd") = "LCC";
					} else if(obj.value == "3") {
						sheetObj.CellText(0, "loc_cd") = "ECC";
					} else if(obj.value == "4") {
						sheetObj.CellText(0, "loc_cd") = "SCC";
					} else {//obj.value is '5'
						sheetObj.CellText(0, "loc_cd") = "Country";
					}
				}

				break;
			case "loc_tp2":		//Location Type
				formObj.loc_cd2.value = "";
				if(obj.value == "0" ) {
					formObj.loc_cd2.readOnly = true;
					formObj.loc_cd2.className = "input2";
					ComEnableObject(formObj.btns_search2, false);
					sheetObj.CellText(0, "loc_cd2") = "ALL";
				} else {
					formObj.loc_cd2.readOnly = false;
					formObj.loc_cd2.className = "input";
					ComEnableObject(formObj.btns_search2, true);
					formObj.loc_cd2.maxLength = obj.value == "5" ? 2 : 5;
					ComSetNextFocus(obj);
					if(obj.value == "1") {
						sheetObj.CellText(0, "loc_cd2") = "RCC";
					} else if(obj.value == "2") {
						sheetObj.CellText(0, "loc_cd2") = "LCC";
					} else if(obj.value == "3") {
						sheetObj.CellText(0, "loc_cd2") = "ECC";
					} else if(obj.value == "4") {
						sheetObj.CellText(0, "loc_cd2") = "SCC";
					} else {//obj.value is '5'
						sheetObj.CellText(0, "loc_cd2") = "Country";
					}
				}

				break;
			case "loc_cd":		//Location Code
  				if ( ComTrim(obj.value) != "" ) {
  					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  					} else {
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  					}
  				}
				break;
			case "loc_cd2":		//Location Code 2
  				if ( ComTrim(obj.value) != "" ) {
  					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC11);
  					} else {
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC12);
  					}
  				}
				break;
  			case "str_evnt_dt":
    		case "end_evnt_dt":
    			checkDurationDate(obj);
	    		break;

//  			case "agmt_seq":	//Agreement No.
//  				if ( ComTrim(obj.value) != "" ) {
//					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
//				}
//				break;

			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
  				}
  				break;

			case "cntr_sts_cd":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		if(formObj.cntr_sts_cd.value == "OF"){
	        	        div_off.style.display = "";
	        	        div_lse.style.display = "none";
	        	        sheetObjects[0].RemoveAll();
	        	        sheetObjects[1].RemoveAll();
        	        	var HeadTitle1 = "From RCC|From LCC|T/Size|Auth Vol.|P/up Vol.|O/B Match|Balance|Lessor|AGMT|Auth No.|Creation Date|S/Days|" //+ vCntrTpszHdr;
						var HeadTitle2 = "Seq.|CNTR No.|TP/SZ|AGMT No.|Ref No.|MVMT|On-Hire Date|On-Hire Yard|F/Days|Off-Hire Date|Off-Hire Yard|Using Days|BKG No|POL|POR|POD|DEL|ETD DT|ETA DT|VVD";
	        	        sheetObjects[0].InitHeadRow(0, HeadTitle1);
	        	        sheetObjects[1].InitHeadRow(0, HeadTitle2);

	        	        sheetObjects[1].ColHidden("bkg_no") = false;
	        	        sheetObjects[1].ColHidden("pol_cd") = false;
	        	        sheetObjects[1].ColHidden("pod_cd") = false;
	        	        sheetObjects[1].ColHidden("por_cd") = false;
	        	        sheetObjects[1].ColHidden("del_cd") = false;
	        	        sheetObjects[1].ColHidden("etd_dt") = false;
	        	        sheetObjects[1].ColHidden("eta_dt") = false;
	        	        sheetObjects[1].ColHidden("vvd") = false;

	        		}else{
	        	        div_off.style.display = "none";
	        	        div_lse.style.display = "";
	        	        sheetObjects[0].RemoveAll();
	        	        sheetObjects[1].RemoveAll();
						var HeadTitle1 = "From RCC|From LCC|T/Size|Auth Vol.|Out Vol|In Vol|Balance|Lessor|AGMT|Auth No.|Creation Date|S/Days|" //+ vCntrTpszHdr;
	        	        var HeadTitle2 = "Seq.|CNTR No.|TP/SZ|AGMT No.|Ref No.|MVMT|Out Date|Out Yard|F/Days|In Date|In Yard|Using Days|BKG No|POL|POR|POD|DEL|ETD DT|ETA DT|VVD";
	        	        sheetObjects[0].InitHeadRow(0, HeadTitle1);
	        	        sheetObjects[1].InitHeadRow(0, HeadTitle2);

	        	        sheetObjects[1].ColHidden("bkg_no") = true;
	        	        sheetObjects[1].ColHidden("pol_cd") = true;
	        	        sheetObjects[1].ColHidden("pod_cd") = true;
	        	        sheetObjects[1].ColHidden("por_cd") = true;
	        	        sheetObjects[1].ColHidden("del_cd") = true;
	        	        sheetObjects[1].ColHidden("etd_dt") = true;
	        	        sheetObjects[1].ColHidden("eta_dt") = true;
	        	        sheetObjects[1].ColHidden("vvd") = true;

	        		}
	        		
  				}
  				break;
//			case "use_day":
//				if (ComTrim(obj.value) == "1") {
//					formObj.onh_free_dys.value = "" ;
//					formObj.onh_free_dys.readOnly = true;
//					formObj.onh_free_dys.className = "input2";
//				}
//				if (ComTrim(obj.value) == "2") {
//					formObj.onh_free_dys.readOnly = false;
//					formObj.onh_free_dys.className = "input";
//				}
		}
	}

	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
		var obj = event.srcElement;

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
	            ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	        	if(obj.name == "loc_cd") {
		            ComKeyOnlyAlphabet('uppernum');
	        	}else{
	        		ComKeyOnlyAlphabet('upper');
	        	}
	            break;
	            
	            if(obj.name == "loc_cd2") {
		            ComKeyOnlyAlphabet('uppernum');
	        	}else{
	        		ComKeyOnlyAlphabet('upper');
	        	}
	            break;
	            
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

  	/**
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj = event.srcElement;

  		switch(obj.name) {
  			case "vndr_seq":
//  			case "agmt_seq":
//				if ( ComTrim(obj.value) == "" ) {
//  					clearForm(obj.name);
//  				} else {
//  					ComKeyEnter('LengthNextFocus');
//  				}
//  				break;

  			default :
			  	ComKeyEnter('LengthNextFocus');
  		}
  	}

   	/**
	 * Key-Down Event 처리
	 */
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			switch(obj.name) {
   				case "loc_cd":
				case "vndr_seq":
//	  			case "agmt_seq":
//	  				if ( ComTrim(obj.value) == "" ) {
//						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//					}
//					break;

				default :
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
   		}
   	}
  	// 2. 이벤트처리함수 -- End

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetid = sheetObj.id;

        switch(sheetid) {
            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                   SheetWidth = mainTable.clientWidth;
                   // SheetWidth = 980;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;
                 //    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    
						var HeadTitle = "From RCC|From LCC|T/Size|Auth Vol.|P/up Vol.|OB Match|Balance|Lessor|AGMT|Auth No.|Creation Date|S/Days|" //+ vCntrTpszHdr;
					
//						var HeadTitle = "From RCC|From LCC|From OFC|T/Size|Auth Vol.|Out Vol.|In Vol.|Balance|Lessor|AGMT|Auth No.|Creation date|S/Days" //+ vCntrTpszHdr;
						var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"rcc_cd",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"lcc_cd",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,  		80,  	daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,  		80,  	daRight,	true,	"auth_vol",			false,	"",		dfInteger);
                    InitDataProperty(0, cnt++ , dtData,  		80,  	daRight,	true,	"out_vol",			false,	"",		dfInteger);
                    InitDataProperty(0, cnt++ , dtData,  		80,  	daRight,	true,	"in_vol",			false,	"",		dfInteger);
                    InitDataProperty(0, cnt++ , dtData,  		80,  	daRight,	true,	"balance",			false,	"",		dfInteger);
                    InitDataProperty(0, cnt++ , dtData,  		80,  	daCenter,	true,	"lessor",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,  		80,  	daCenter,	true,	"agmt_no",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,  		100,  	daCenter,	true,	"auth_no",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,			100,  	daCenter,	false,	"cre_dt",			false,	"",		dfNone);
					InitDataProperty(0, cnt++ , dtData,	 		60,  	daRight,	false,	"s_days",			false,	"",		dfInteger);
					InitDataProperty(0, cnt++ , dtHidden,	 		60,  	daRight,	false,	"auth_seq",			false,	"",		dfInteger);

					CountFormat = "[SELECTDATAROW / TOTALROWS]";
					

				}
				break;

            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 1000);

					var HeadTitle  = "Seq.|CNTR No.|TP/SZ|AGMT No.|Ref No.|MVMT|Out Date|Out Yard|F/Days|In Date|In Yard|Using Days|BKG No|POL|POR|POD|DEL|ETD DT|ETA DT|VVD";
					//var HeadTitle2 = "Seq.|CNTR No.|TP/SZ|AGMT No.|Ref No.|MVMT|Out Date|Out Yard|F/Days|In Date|In Yard|Using Days||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 3, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"seq_no");
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"cntr_no",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		40,  	daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		70,  	daCenter,	true,	"lsi_agmt_no",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		100,  	daLeft,		true,	"lsi_ref_no",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		40,  	daCenter,	true,	"cnmv_sts_cd",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		100,  	daCenter,	true,	"cntr_sts_evnt_dt",	false,	"",		dfDateYmd);
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"yd_cd",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		60,  	daRight,	true,	"rntl_chg_free_dys",false,	"",		dfInteger);
                    InitDataProperty(0, cnt++ , dtData,   		100,  	daCenter,	true,	"cntr_rtn_evnt_dt",	false,	"",		dfDateYmd);
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daCenter,	true,	"rtn_yd_cd",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,   		80,  	daRight,	true,	"ttl_use_dys",		false,	"",		dfInteger);

                    InitDataProperty(0, cnt++ , dtData,     	85, 	daCenter,	false,	"bkg_no",			false,	"",		dfNone);
        			InitDataProperty(0, cnt++ , dtData,     	60, 	daCenter,	false,	"pol_cd",			false,	"",		dfNone);
        			InitDataProperty(0, cnt++ , dtData,     	60, 	daCenter,	false,	"por_cd",			false,	"",		dfNone);
        			InitDataProperty(0, cnt++ , dtData,     	60,		daCenter,	false,	"pod_cd",			false,	"",		dfNone);
        			InitDataProperty(0, cnt++ , dtData,     	60, 	daCenter,	false,	"del_cd",			false,	"",		dfNone);
        			InitDataProperty(0, cnt++ , dtData,     	80,  	daCenter,	false,	"etd_dt",			false,	"",		dfNone);
        			InitDataProperty(0, cnt++ , dtData,     	80,  	daCenter,	false,	"eta_dt",			false,	"",		dfNone);
        			InitDataProperty(0, cnt++ , dtData,     	75, 	daCenter,	false,	"vvd",				false,	"",		dfNone);
                    
                    CountFormat = "[SELECTDATAROW / TOTALROWS]";
				}
				break;

        }
    }

	/**
	 * 콤보 초기설정값, 헤더 정의
	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
//	        case "combo1":
//	        	with(comboObj) {
//	            	DropHeight = 250;
//	            	MultiSelect = true;
//	            	//MaxSelect = 1;
//	            	MultiSeparator = ",";
//	            	Style = 0;
//             		UseAutoComplete = true;
//             		//영문(대)+특수문자 - Lease Term
//             		ValidChar(2,2);
//	        	}
//
//	        	break;
	        case "combo2":
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
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBCREATE:
	        	sheetObj.WaitImageVisible = false;

	        	//Lease Term Combo Item Setting
//				formObj.f_cmd.value = SEARCH01;
//				var sXml_1 = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value = SEARCH02;
				var sXml_1 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
//				alert('sXml_2' + sXml_2);
		        sheetObj.WaitImageVisible = true;

//				if(sXml_1 != "") {
//					comboObjects[0].InsertItem(0 , 'ALL','');
//					LseComXml2ComboItem(sXml_1, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
//					vOrcLstmCd = ComGetEtcData(sXml_1, "lease_term_cd");
//				}
	            if ( sXml_1 != "" ) {
	            	comboObjects[0].InsertItem(0 , 'ALL','');
	            	LseComXml2ComboItem(sXml_1, comboObjects[0], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	vOrcCntrTpszCd = ComGetEtcData(sXml_1, "cntr_tpsz_cd");
	            }

	            break;

           case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
//						formObj.lstm_cd.value = ComGetObjValue(comboObjects[0]);
						formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObjects[0]);

						sheetObj.WaitImageVisible = false;
	         			ComOpenWait(true);
//	         			formObj.onh_free_dys.value = formObj.onh_free_dys.value.replace(",","");
						var sXml = sheetObj.GetSearchXml("EES_LSE_0111GS.do", FormQueryString(formObj));
						if ( sXml != "" ) {
							var comboVal = ComGetObjValue(comboObjects[0]);

//							if ( comboVal != "" ) {
//								for ( var i = 1 ; i < vCntrTpszCnt ; i++ ) {
//									eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
//								}
//
//								var arrComboVal = comboVal.split(",");
//
//								for ( var i = 0 ; i < arrComboVal.length ; i++ ) {
//									for( var j = 1; j < vCntrTpszCnt; j++ ) {
//										if(arrComboVal[i] == vArrCntrTpsz[j]) {
//											eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(j, 2, "0") + '") = false;');
//											break;
//										}
//									}
//								}
//							} else {
//								for( var i = 1; i < vCntrTpszCnt; i++ ) {
//									if(vArrCntrTpsz[i] != "") {
//										eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
//									} else {
//										eval('sheetObj.ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
//									}
//								}
//							}

							sheetObj.Redraw = false;
							sheetObj.LoadSearchXml(sXml);
							sheetObj.Redraw = true;

							ComOpenWait(false);
						}
					}
				}
				break;

			case IBSEARCH_ASYNC01:	// Location 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
// 						var vLocTp = formObj.loc_tp.value == "1" ? "RCC" :
// 									 formObj.loc_tp.value == "2" ? "LCC" :
//									 formObj.loc_tp.value == "3" ? "ECC" : "SCC";
// 									 formObj.loc_tp.value == "2" ? "LCC" ;
 						var vLocTp = "ECC";
 						var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
 								  +"&loc_cd="+ComGetObjValue(formObj.loc_cd);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocCd = "";
									switch (vLocTp) {
										case "RCC":
											vLocCd = ComGetEtcData(sXml, "rcc_cd");
											break;
										case "LCC":
											vLocCd = ComGetEtcData(sXml, "lcc_cd");
											break;
										case "ECC":
											vLocCd = ComGetEtcData(sXml, "ecc_cd");
											break;
										case "SCC":
											vLocCd = ComGetEtcData(sXml, "scc_cd");
											break;

									}
									formObj.loc_cd.value = vLocCd;
									ComSetFocus(formObj.loc_cd);
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_cd.value = "";
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd.value = "";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}
 				break;

 			case IBSEARCH_ASYNC02:	// Country 조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH10+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
									formObj.loc_cd.value = ComGetEtcData(sXml, "loc_cd") ;
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.loc_cd.value = "";
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd.value = "";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}
				break;
				
 			case IBSEARCH_ASYNC11:	// Location 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vLocTp = formObj.loc_tp2.value == "1" ? "RCC" :
 									 formObj.loc_tp2.value == "2" ? "LCC" :
									 formObj.loc_tp2.value == "3" ? "ECC" : "SCC";
// 									 formObj.loc_tp.value == "2" ? "LCC" ;
 						var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
 								  +"&loc_cd="+ComGetObjValue(formObj.loc_cd2);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocCd = "";
									switch (vLocTp) {
										case "RCC":
											vLocCd = ComGetEtcData(sXml, "rcc_cd");
											break;
										case "LCC":
											vLocCd = ComGetEtcData(sXml, "lcc_cd");
											break;
										case "ECC":
											vLocCd = ComGetEtcData(sXml, "ecc_cd");
											break;
										case "SCC":
											vLocCd = ComGetEtcData(sXml, "scc_cd");
											break;

									}
									formObj.loc_cd2.value = vLocCd;
									ComSetFocus(formObj.loc_cd2);
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_cd2.value = "";
									ComSetFocus(formObj.loc_cd2);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd2.value = "";
								ComSetFocus(formObj.loc_cd2);
							}
						}
					}
				}
 				break;

 			case IBSEARCH_ASYNC12:	// Country 조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH10+"&loc_cd="+ComGetObjValue(formObj.loc_cd2);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
									formObj.loc_cd2.value = ComGetEtcData(sXml, "loc_cd") ;
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.loc_cd2.value = "";
									ComSetFocus(formObj.loc_cd2);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd2.value = "";
								ComSetFocus(formObj.loc_cd2);
							}
						}
					}
				}
				break;
				
// 			case IBSEARCH_ASYNC03:	//조회(Form Agreement No. 입력시)
// 				if(validateForm(sheetObj,formObj,sAction)) {
// 					if ( sheetObj.id == "sheet1") {
// 						ComSetObjValue(formObj.f_cmd, SEARCH03);
// 						var param = "f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.agmt_cty_cd)
// 								  + "&agmt_seq="+ComGetObjValue(formObj.agmt_seq);
// 						sheetObj.WaitImageVisible = false;
//						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
//						sheetObj.WaitImageVisible = true;
//
//						if ( sXml != "" ) {
//							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
//								ComSetObjValue(formObj.ref_no,   ComGetEtcData(sXml, "ref_no"));
//								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
//								ComSetFocus(formObj.ref_no);
//								doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
//							} else {
//	 							ComShowCodeMessage("LSE01007");
//	 							clearForm("agmt_seq");
//	 						}
//						} else {
//							var errMsg = LseComGetErrMsg(sXml);
//							if ( errMsg != "" ) {
//								ComShowMessage(errMsg);
//							}
//							clearForm("agmt_seq");;
//						}
// 					}
//				}
//				break;

			case IBSEARCH_ASYNC04:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
							ComSetFocus(formObj.vndr_nm);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq");
 						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("vndr_seq");;
					}
				}
				break;

			case IBSEARCH_ASYNC05:	//Container Type Size Dynamic Header Setting
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH12;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
				sheetObj.WaitImageVisible = true;

				if(sXml != "") {
//					if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != undefined ) {
//						if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != "" ) {
//							vCntrTpszHdr = ComGetEtcData(sXml, "cntr_tpsz_hd");
//							vArrCntrTpsz = vCntrTpszHdr.split("|");
//							vCntrTpszCnt = vArrCntrTpsz.length;
//						}
//					}
				}
				break;

			case IBSEARCHAPPEND:	//조회(페이징처리)
				if(sheetObj.id == "sheet2") {
					formObj.f_cmd.value = SEARCH01;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.DoSearch4Post("EES_LSE_0111GS.do", CondParam, "iPage="+ PageNo, true);
					ComOpenWait(false);
				}
				break;
        }
    }

	/**
	 * Sheet의 OnScrollNext Event 처리부분.<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
	function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}

	/**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
		}
	}

	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var param ="";
		formObj.auth_no.value = sheetObj.CellValue(Row,"auth_no");
		formObj.auth_seq.value = sheetObj.CellValue(Row,"auth_seq");
		formObj.f_cmd.value = SEARCH01;
		sheetObjects[1].WaitImageVisible = false;
		ComOpenWait(true);
		sheetObjects[1].DoSearch("EES_LSE_0111GS.do",FormQueryString(formObj));
		ComOpenWait(false);
	}

	/**
	 * sheet1_OnMouseDown
	 * 마우스가 눌러졌을때 발생하는 Event 처리
	 * SUMMARY 에 해당하는 DETAIL 조회
	 */
	function sheet1_OnMouseDown(sheetObj , Button, Shift, X, Y) {

		var formObj = document.form;
	
	}

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			
		}
    }

    /**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return6
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
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function combo2_OnCheckClick(comboObj, index, code) {
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
	 * combo2_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.lstm_cd.value = ComGetObjValue(comboObj);
	}

    /**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
	}

	/**
	 * combo1_OnKeyDown
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
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
				formObj.lstm_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}

	/**
	 * combo2_OnKeyDown 
	 */
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
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
				formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Lessor Code Popup for FORM, 2:Agreement No. Popup for FORM
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {
    		switch(formObj.loc_tp.value) {
    			case "1" :	//RCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "2" :	//LCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "3" :	//ECC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"ecc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "4" :	//SCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "5" :	//Country
					ComOpenPopup("/hanjin/COM_ENS_0M1.do",565, 480, 'setPopData_Country', "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		} 
    	} else if ( type == "2" ) {
        		switch(formObj.loc_tp2.value) {
        			case "1" :	//RCC2
        				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_cd2", "1,0,1,1,1,1,1", true);
        				break;
        			case "2" :	//LCC2
        				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_cd2", "1,0,1,1,1,1,1", true);
        				break;
        			case "3" :	//ECC2
        				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"ecc_cd:loc_cd2", "1,0,1,1,1,1,1", true);
        				break;
        			case "4" :	//SCC2
        				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_cd2", "1,0,1,1,1,1,1", true);
        				break;
        			case "5" :	//Country2
    					ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 480, 'setPopData_Country2', "1,0,1,1,1,1,1", true);
        				break;
        			default : 	//do nothing
        		}
//    	} else if ( type == "2" ) {
//    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "3" ) {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}

    	return;
    }

	/**
     * Agreement Pop-up Return Value 처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
//			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
    		ComSetObjValue(formObj.ref_no,   aryPopupData[0][5]);
    		ComSetObjValue(formObj.vndr_seq, aryPopupData[0][7]);
    		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
    	}
    }

    /**
	 * Country Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Country(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj = sheetObjects[SheetIdx];
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
		}
	}
	
	function setPopData_Country2(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj = sheetObjects[SheetIdx];
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.loc_cd2, aryPopupData[0][3]);
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
			ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //조회
    				if (!checkDurationDate()) {
    					return false;
    				}

    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}

        return true;
    }

	/**
	 * Duration Date Validation 처리 부분<br>
	 */
    function checkDurationDate(eventObj) {
    	var formObj = document.form;
    	var vEffDt = ComReplaceStr(ComGetObjValue(formObj.str_evnt_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.end_evnt_dt),"-","");

    	//Duration이 필수입력이 아닌경우
    	if(formObj.str_evnt_dt.className == "input") {
	    	if( vEffDt == "" && vExpDt == "" ) {
	    		return true;
	    	}
    	}

		/* Duration Date Validation(str_evnt_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "str_evnt_dt") {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.str_evnt_dt) ) {
			ComShowCodeMessage("LSE01080");
			ComSetObjValue(formObj.str_evnt_dt,"");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		}

		/* Duration Date Validation(end_evnt_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "end_evnt_dt") {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.end_evnt_dt) ) {
			ComShowCodeMessage("LSE01081");
			ComSetObjValue(formObj.end_evnt_dt,"");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		}

		/* Duration Date Validation(str_evnt_dt < end_evnt_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("LSE01082");

				if(eventObj == null) {
					ComSetObjValue(formObj.end_evnt_dt,"");
					ComSetFocus(formObj.end_evnt_dt);
				} else {
					ComSetObjValue(eventObj,"");
					ComSetFocus(eventObj);
				}
				return false;
			}
		}

		return true;
    }

	/**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
//			case "agmt_seq":
//				ComSetObjValue(formObj.agmt_seq,    "");
//				ComSetObjValue(formObj.ref_no,   	"");
//				ComSetFocus(formObj.agmt_seq);
//				break;
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
		}
	}

	/* 개발자 작업  끝 */