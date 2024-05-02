/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0002.js
*@FileTitle : UN Number (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.14 이도형
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
     * @class vop_scg_0002 : vop_scg_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0002() {
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
	  
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
 
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/          
    	var sheetObject1 = sheetObjects[0];
    	var formObject = document.form;
    	/*******************************************************/

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

				case "btn_Retrieve":
					sheetObjects[0].RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
					formObject.page_no.value="1";
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case "btn_New":
 					clearAll();
	 	     		ComBtnDisable("btn_Detail");
	 	     		ComBtnDisable("btn_DownExcel");
					break;
				
 				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
 					break;
 					
 				case "btn_OK":
					comPopupOK();
					break;
 					
 				case "btn_Close":
					window.close();
					break;
				
 				case "btn_Detail":
					if( sheetObjects[0].RowCount > 0) {
						openPopupUnNo();
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
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
     }

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage(preCond) {

    	 for(i=0;i<sheetObjects.length;i++){
    		 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }

         //html컨트롤 이벤트초기화
         initControl();
		 
		 //최초 화면 로드 시 버튼 비활성화(Detail, DownExcel)
 		 ComBtnDisable("btn_Detail");
 		 ComBtnDisable("btn_DownExcel");
     }

     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
         
         //팝업여부와 초기 조회
         if(preConds.pop_yn == 'Y') {
        	 //초기 조건 셋팅
	         if(preConds.imdg_un_no != '' || preConds.imdg_tec_nm != '') {	         	
	         	if(preConds.imdg_un_no != '') ComSetObjValue(document.form.imdg_un_no, preConds.imdg_un_no);
	         	if(preConds.imdg_tec_nm != '') ComSetObjValue(document.form.imdg_tec_nm, preConds.imdg_tec_nm);
	            
	         	//조회
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	         }
         } else {
        	 sheetObjects[0].ColHidden(1) = true;	//체크박스 활성
         }
     }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
         	case 1:      // sheet1 init
         		with (sheetObj) {
	         		// 높이 설정
	     			style.height = 428;
	     			// 전체 너비 설정
	     			SheetWidth = mainTable.clientWidth;
	     			
	     			//Host정보 설정[필수][HostIp, Port, PagePath]
	     			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	     			//전체Merge 종류 [선택, Default msNone]
	     			MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	     			Editable = true;
	
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=SCG_PAGE_SIZE]
	    			InitRowInfo(1, 1, 15, SCG_PAGE_SIZE);	//20140805수정 : SCG_PAGE_SIZE > 200건씩 조회 	//InitRowInfo( 1, 1, 3, 100);
	
	     			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	     			InitColumnInfo(28, 0, 0, true);
	
	     			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	     			InitHeadMode(true, true, true, true, false,false)
	
	     			var HeadTitle = "||UN No./Seq.|UN No./Seq.|Class|Class|Proper Shipping Name|Technical Name|Sub\nRisks|Packing\nGroup|Special\nProvisions|Limited\nQuantities|EmS|Stowage and\nSegregation|SML\nRestrictions|||||||||||||";
	     			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	     			InitHeadRow(0, HeadTitle, true);
	
	     			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	     			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
	     			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	false,	"checkbox");
	     			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"imdg_un_no",			false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"imdg_un_no_seq",		false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,	"imdg_clss_cd",			false,	"",		dfNone,			0,			false,		false); 					
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,	"imdg_comp_grp_cd",		false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			390,	daLeft,		false,	"prp_shp_nm",			false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		170,	daLeft,		false,	"imdg_tec_nm");
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"imdg_subs_rsk_lbl_cd",	false,	"",		dfNone,			0,			false,		false); 					
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"imdg_pck_grp_cd",		false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		false,	"imdg_spcl_provi_no",	false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"imdg_lmt_qty",			false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"imdg_emer_no",			false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			390,	daLeft,		false,	"segr_desc",			false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		false,	"imdg_crr_rstr_expt_nm",false,	"",		dfNone,			0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_expt_qty_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_subs_rsk_lbl_rmk");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"psa_no");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"hcdg_flg");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"hcdg_pck_rstr_desc");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"hcdg_intmd_bc_rstr_desc");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"hcdg_tnk_rstr_desc");					
					
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_ctrl_temp");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"emer_rspn_gid_no");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"emer_rspn_gid_chr_no");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_emer_temp");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_lmt_qty_meas_ut_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"imdg_mrn_polut_cd");
					
         			ScrollTrack		= false;
					MassOfSearch 	= 0;
					
					ColHidden("checkbox") = false;
					EditableColorDiff = false;
					
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
         		}
         		break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

	      	case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
	        		formObj.f_cmd.value = SEARCH;
	        	   	//sheetObj.DoSearch("VOP_SCG_0002GS.do", FormQueryString(formObj)); 
	        	   	
					var sXml = sheetObj.GetSearchXml("VOP_SCG_0002GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
			
					if (arrXml.length > 0) {
						sheetObj.LoadSearchXml(arrXml[0], true);
						//조회 후 데이터가 있는 경우에만 버튼 활성화(Detail, DownExcel)
						if( sheetObjects[0].RowCount > 0) {
			 	     		ComBtnEnable("btn_Detail");
			 	     		ComBtnEnable("btn_DownExcel");					
						} else {
			 	     		ComBtnDisable("btn_Detail");
			 	     		ComBtnDisable("btn_DownExcel");
						}						
					}
				}
				break;

	      	case IBDOWNEXCEL:
                var paramObj = new Object();
                paramObj.title = "UN Number";
                paramObj.cols = "12";
                paramObj.columnwidth = "1:5|2:5|3:5|4:5|5:70|6:10|7:10|8:10|9:10|10:10|11:40|12:10";
                paramObj.datarowheight   = "0:25";
                var url = ComScgGetPgmTitle(sheetObj, paramObj); 
                sheetObj.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
	      		break;

			case IBSEARCH_ASYNC01: // Class 조회
         		sheetObj.WaitImageVisible = false;
                formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
				//Class
				ComXml2ComboItem(sXml, formObj.imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd", "Y");
				break;

			case IBSEARCH_ASYNC11: // Class1 조회
         		sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH;
	    		comboObjects[1].Code = "";
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0047GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.imdg_comp_grp_cd, "imdg_comp_grp_cd", "imdg_comp_grp_cd", "Y");
				break;
         }
  		sheetObj.WaitImageVisible = true;
     }

     //업무 자바스크립트 OnKeyPress 이벤트 Catch
     function initControl() {
    	 axon_event.addListener('keydown',		'ComKeyEnter',	'form');
    	 axon_event.addListener('change',		'clss_OnChange','imdg_clss_cd');
    	 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form);      
    	 axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
    	 axon_event.addListenerForm('keyup',	'obj_keyup', 	document.form);
     }

     function initCombo(comboObj, comboNo) {
 	    switch(comboObj.id) {
 	        case "imdg_clss_cd":
 	            with(comboObj) {
 	            	DropHeight = 260;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 	            }
 	            break;
 	            
 	        case "imdg_comp_grp_cd":
 	            with(comboObj) {
 	            	DropHeight = 260;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	UseAutoComplete = false;
 	        		Enable = false;	            	
 	            }
 	            break;
 	    }
     }     

     function obj_blur(){
    	 var formObj = document.form;
    	 switch(event.srcElement.name){
	    	 /*case "imdg_un_no":
	    		  2009-12-23 서동호 부장님 요청으로 UN No.를 like검색으로 수정 length체크 삭제
	    		 if (event.srcElement.value.length > 0 && event.srcElement.value.length < 4) {
	    			 ComShowCodeMessage('SCG50006', event.srcElement.caption, event.srcElement.maxLength);
	    			 formObj.imdg_un_no.select();
	    			 formObj.imdg_un_no.focus();
	    		 }
	    		 break;
	    		 
    	 case "imdg_tec_nm":
    		 if (event.srcElement.value.length > 0 && event.srcElement.value.length < 3) {
    			 ComShowCodeMessage('SCG50006', event.srcElement.caption, 3);
    			 formObj.imdg_tec_nm.select();
    			 formObj.imdg_tec_nm.focus();
    		 }*/
    	 }
    	 ComChkObjValid(event.srcElement); 
     }

     /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
     function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
    	}
    	switch(event.srcElement.name){
			case "imdg_un_no":
				//숫자 만입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
    	}
     }

     function obj_keyup(){
    	 ComKeyEnter('LengthNextFocus');
//    	 switch(event.srcElement.name){
//    	 	case "imdg_un_no":
//				if ( ComTrim(event.srcElement.value) != "" ) {
//					ComKeyEnter('LengthNextFocus');
//				}
//				break;
//    	}
     }

     function clss_OnChange(comboObj, code, text) {
    	var formObj = document.form;
		if (code == "1" || code == "1.1" || code == "1.2" || code == "1.3" || code == "1.4" || code == "1.5" || code == "1.6" ){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC11);
  			comboObjects[1].Enable = true;
    		comboObjects[1].Code = "";
  		}else{
    		comboObjects[1].Code = "";
  			comboObjects[1].Enable = false;
  		}
    }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
		 switch(sAction){
 			case IBSEARCH:
 				//2014-07-24 조회필수체크
 				if (formObj.imdg_tec_nm.value.length > 0 && formObj.imdg_tec_nm.value.length < 3) {
    	 			ComShowCodeMessage('SCG50006', 'Proper Shipping Name', 3);
	    			formObj.imdg_tec_nm.select(); 
	    			formObj.imdg_tec_nm.focus();
	    			return;
    	 		}
 				
 				/*if (formObj.imdg_un_no.value == "" && comboObjects[0].Code == "") {
    	 			ComShowCodeMessage('SCG50007', 'UN No. or Class');
    	 			ComSetFocus(formObj.imdg_un_no);
    	 			return;
    	 		}*/
    	 		
 				//if (!ComChkObjValid(formObj.imdg_un_no)) return;
		 }
         return true;
     }
     
     /**
      * sheet1 조회완료후 호출
      * @param sheetObj
      * @param ErrMsg
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	 var k = 0;
    	 for(var i=0; i<sheetObj.RowCount; i++) {
    		 if (sheetObj.CellValue(i+1, "imdg_pck_grp_cd") == 1) {
    			 sheetObj.CellValue(i+1, "imdg_pck_grp_cd") = "I";
    		 }else if (sheetObj.CellValue(i+1, "imdg_pck_grp_cd") == 2) {
    			 sheetObj.CellValue(i+1, "imdg_pck_grp_cd") = "II";
    		 }else if (sheetObj.CellValue(i+1, "imdg_pck_grp_cd") == 3) {
    			 sheetObj.CellValue(i+1, "imdg_pck_grp_cd") = "III";
    		 }
    		 if (sheetObj.CellValue(i+1, "imdg_tec_nm") != "") {
    			 k++;
    		 }
    	 }

		 if (k < 1) {
			 sheetObj.ColHidden("imdg_tec_nm") 	= true;
             sheetObj.ColWidth("prp_shp_nm") 	= 560;
             sheetObj.ColWidth("imdg_crr_rstr_expt_nm") 	= 130;
		 }else{
			 /* Technical Name 조회되지 않도록
			 sheetObj.ColHidden("imdg_tec_nm") 	= false;
             sheetObj.ColWidth("prp_shp_nm") 	= 390;
             sheetObj.ColWidth("imdg_tec_nm") 	= 170;
             sheetObj.ColWidth("imdg_crr_rstr_expt_nm") 	= 130;
             */
		 }
     }
     
   	/**
   	 * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 이벤트
   	 */
   	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows){ 
       var formObj = document.form ;
       //formObj.f_cmd.value = SEARCH;
       formObj.page_no.value = PageNo;
       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

  	function clearAll() {
 		var formObj = document.form;
 		formObj.reset();
		sheetObjects[0].RemoveAll();
        for(var k=0; k<comboObjects.length; k++){
        	comboObjects[k].RemoveAll();
        	initCombo(comboObjects[k], k + 1);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
 	}
	
	 	
    /**
    * Pop-up Open 부분<br>
    */
   function openPopupUnNo(){
    	var sRow = sheetObjects[0].SelectRow;
		var sUrl    = '/hanjin/VOP_SCG_0001.do';
		var iWidth  = 1070;
		var iHeight = 530;
		var sTargetObjList = "";
		var sDisplay = "0,1";
				
		var param = "?imdg_un_no="+sheetObjects[0].CellValue(sRow, "imdg_un_no")
		+"&imdg_un_no_seq="+sheetObjects[0].CellValue(sRow, "imdg_un_no_seq")
		+"&popflag=1";

		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
   }
   
   
    /**
     * sheet2의 선택된 정보를 삭제한다.
     */
    function sheet1_OnDblClick(shtObj, row, col, value){
        openPopupUnNo();
    }
     
     /* 개발자 작업  끝 */