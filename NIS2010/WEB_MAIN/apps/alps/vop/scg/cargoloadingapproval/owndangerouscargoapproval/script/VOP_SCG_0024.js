/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0024.js
*@FileTitle : Systematic Inspection Filtering Text
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.24 김도현
* 1.0 Creation

* History
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
     * @class vop_scg_0024 : vop_scg_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0024() {
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
	var tabIndex = 0;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0; 

    var auth_cd = null;
    var scg_flg = null;

    var laneSheetDataRows = 1; // laneSheet의 모든 Row 갯수
	
	var laneSheetLaneCdDataRow1 = 0;
	var laneSheetLaneCdDataRow2 = 1;
	
    var rqstOfcCdCol = 8; // rqst_ofc_cd 입력 가능 개수
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt = 0;
    	var t1sheet1 = sheetObjects[1];
    	var t2sheet1 = sheetObjects[2];
    	var t3sheet1 = sheetObjects[3];
    	var t4sheet1 = sheetObjects[4];
    	var t5sheet1 = sheetObjects[5];	// NON-DG CHEMICAL
    	var formObject = document.form;
    	/*******************************************************/

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {
	 			case "btn_SlanCd1": case "btn_SlanCd2": case "btn_SlanCd3": case "btn_SlanCd4": case "btn_SlanCd5": case "btn_SlanCd6": case "btn_SlanCd7": case "btn_SlanCd8": case "btn_SlanCd9":  case "btn_SlanCd10": case "btn_SlanCd11":
	 				onPopupClick(srcName, "Lane");
	 				break;

     			case "btn_Retrieve":
     				formObject.retrieve_flg.value = "Y";
     				//Retrieve 버튼 클릭시 Tab 조회 초기화
     				formObject.t0retrieve_flg.value = "N";
     				formObject.t1retrieve_flg.value = "N";
     				formObject.t2retrieve_flg.value = "N";
     				formObject.t3retrieve_flg.value = "N";
     				formObject.t4retrieve_flg.value = "N";	// NON-DG CHEMICAL
     				
     				var rqst_ofc_cd = "";
     				for(var i=1; i <= rqstOfcCdCol; i++){
     					if(sheetObjects[0].CellValue(1,"rqst_ofc_cd"+i).length > 0){
     						rqst_ofc_cd += (rqst_ofc_cd == "") ? "" : "^";
     						rqst_ofc_cd += sheetObjects[0].CellValue(1,"rqst_ofc_cd"+i);
     					}
     				}
     				formObject.rqst_ofc_cd.value = rqst_ofc_cd;
     				
					doActionIBSheet(sheetObjects[tabIndex+1],document.form,IBSEARCH);
     				break;
     				
     			case "btn_New":
     				if (!validateForm(sheetObjects[tabIndex+1],document.form,IBCLEAR)) return;
//     				comboObjects[0].Code = "";// 2016.03.29 조회조건에서 제외 - 로직유지
 					clearAll();
     				break;

     			case "btn_Save":
					doActionIBSheet(sheetObjects[tabIndex+1],document.form,IBSAVE);
     				break;

		        case "btns_period": // From 달력버튼
		        	var cal = new ComCalendarFromTo();
		        	cal.select(formObject.rqst_fr_dt, formObject.rqst_to_dt, 'yyyy-MM-dd');
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
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
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
         for(i=0, k=1;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
//             ComBtnDisable("btn_t"+k+"ApplDetails");
        	 k++;
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }

         //IBMultiCombo초기화
         for(var k = 0; k < comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
      
 		var formObj = document.form;
	    formObj.rqst_fr_dt.value = frDt;
	    formObj.rqst_to_dt.value = toDt;
	    
     }

     function t1sheet1_OnLoadFinish(sheetObj) {
         //html컨트롤 이벤트초기화
         initControl();
         // 2016.03.29 조회조건에서 제외
//         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);	//RSO Combo생성
     }
     
     /**
      * Combo 기본 설정 
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
      */ 
      function initCombo(comboObj, comboNo) {
    	  switch(comboObj.id) {
    	// 2016.03.29 조회조건에서 제외
//    	  	case "rgn_shp_opr_cd":    
//    	  		var i=0;
//    	  		with(comboObj) {
//    	  			SetTitle("Code|Description");
//    	  			SetColAlign("center|left");
//    	  			SetColWidth("50|150");
//    	  			DropHeight = 200;
//   	         	}
//    	  		break;  
    	  }
      }

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
    	 var cnt = 0;
         var sheetID = sheetObj.id ; 
         switch(sheetID) {
         	case "t1sheet1":
         		with (sheetObj) {
	                // 높이 설정
         			style.height = 400;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 0, 100);
	    			var HeadTitle1  = "|TYPE|UN NO|BKG NO.|BKG NO.|VVD|POL ETA Date|CNTR'NO|Request Date|LANE|KEYWORD I|Common Name|Customs Description|Container's Description|Booking Description of Goods|Booking Description of Goods|Booking Description of Goods|Commodity|Ext Remark|Int Remark|Commodity Detail|Remark(s)|Status|S/STWG|Booking STWG|Mail|Mail|Act Date|Mail|Mail|||";
	    			
	    			var headCount = ComCountHeadTitle(HeadTitle1);
	    			sheet1HeadTitleCnt = headCount;
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 12, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false, false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                
	                HeadRowHeight = 20;
	           
//	                var prefix="sheet1_";
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,    	daCenter,  	false,	"ibflag");
	                InitDataProperty(0, cnt++ , dtData,			 45,		daCenter,	true,	"bkg_dcgo_flg",     		false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 50,		daLeft,	    true,	"imdg_un_no", 				false,		"",		dfNone,		0,	false,	true);
		            InitDataProperty(0, cnt++ , dtData,			 85,		daCenter,	true,	"bkg_no", 					false,		"",		dfNone,		0,	false,	true);
		            InitDataProperty(0, cnt++,  dtImage, 		 25,		daCenter,	true,	"bkg_no_pop",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"vvd",						false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"pol_eta_dt",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"cntr_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"rqst_gdt", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 50,		daCenter,	true,	"slan_cd", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			140,		daLeft,		true,	"non_dcgo_kw_nm", 			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			140,		daLeft,		true,	"cmt_ctnt", 	    		false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cstms_desc", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cntr_mf_gds_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 25,		daCenter,	true,	"sb_cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			235,		daLeft,		true,	"cst_cmdt_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		235,		daLeft,		true,	"cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cmdt_nm",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"xter_rmk",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"inter_rmk",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_cmdt_nm",	false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_rmk", 		false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			 60,		daCenter,	true,	"spcl_cgo_apro_cd",			false,		"",		dfNone,		0,	true,	true);                    
	                InitDataProperty(0, cnt++ , dtData,			 55,		daCenter,	true,	"odek_flg",					false,		"",		dfNone,		0,	true,	true);                    
	                InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"stwg_cd",					false,		"",		dfNone,		0,	false,	true);                    
	                InitDataProperty(0, cnt++ , dtData,		 	 15,		daCenter,	true,	"eml_snd_no",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 25,		daCenter,	true,	"eml_snd_no_pop",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"upd_dt", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"non_dcgo_rqst_seq");
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"usr_eml");
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"pol_yd_cd");
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"pod_yd_cd");
	                InitDataProperty(0, cnt++ , dtCheckBox,		  0,		daCenter,	true,	"chg_flg");
	                ColHidden('chg_flg')= true;
	                
	                ImageList(0) = "/hanjin/img/btns_search.gif";
         		}
         	break;
         		
         	case "t2sheet1":
         		with (sheetObj) {
	                // 높이 설정
	     			style.height = 400;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 0, 100);
	                var HeadTitle1  = "|BKG NO.|BKG NO.|VVD|POL ETA Date|CNTR'NO|Request Date|LANE|KEYWORD II|Common Name|Customs Description|Container's Description|Booking Description of Goods|Booking Description of Goods|Booking Description of Goods|Commodity|Ext Remark|Int Remark|Commodity Detail|Remark(s)|Status|S/STWG|Booking STWG|Mail|Mail|Act Date|||";
	    			
	    			var headCount = ComCountHeadTitle(HeadTitle1);
	    			sheet1HeadTitleCnt = headCount;
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 10, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false, false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                
	                HeadRowHeight = 20;
	                
//	                var prefix="sheet1_";
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,		daCenter,  	true,	"ibflag");
	                InitDataProperty(0, cnt++ , dtData,			 85,		daCenter,	true,	"bkg_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++,  dtImage, 		 25,		daCenter,	true,	"bkg_no_pop",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"vvd",						false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"pol_eta_dt",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"cntr_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"rqst_gdt", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 50,		daCenter,	true,	"slan_cd", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			140,		daLeft,		true,	"non_dcgo_kw_nm", 			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			140,		daLeft,		true,	"cmt_ctnt", 		    	false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cstms_desc", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cntr_mf_gds_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 25,		daCenter,	true,	"sb_cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			235,		daLeft,		true,	"cst_cmdt_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		235,		daLeft,		true,	"cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cmdt_nm",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"xter_rmk",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"inter_rmk",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_cmdt_nm",	false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_rmk", 		false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			 60,		daCenter,	true,	"spcl_cgo_apro_cd",			false,		"",		dfNone,		0,	true,	true);                    
	                InitDataProperty(0, cnt++ , dtData,			 55,		daCenter,	true,	"odek_flg",					false,		"",		dfNone,		0,	true,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"stwg_cd",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 15,		daCenter,	true,	"eml_snd_no",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 25,		daCenter,	true,	"eml_snd_no_pop",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"upd_dt", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"non_dcgo_rqst_seq");
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"usr_eml");
	                InitDataProperty(0, cnt++ , dtCheckBox,		  0,		daCenter,	true,	"chg_flg");
	                ColHidden('chg_flg')= true;
	                
	                ImageList(0) = "/hanjin/img/btns_search.gif";
	     		}
	     	break;
     		
         	case "t3sheet1":
         		with (sheetObj) {
	                // 높이 설정
	     			style.height = 400;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 0, 100);
	                var HeadTitle1  = "|BKG NO.|BKG NO.|VVD|POL ETA Date|CNTR'NO|Request Date|LANE|KEYWORD III|Common Name|Customs Description|Container's Description|Booking Description of Goods|Booking Description of Goods|Booking Description of Goods|Commodity|Ext Remark|Int Remark|Commodity Detail|Remark(s)|Status|S/STWG|Booking STWG|Mail|Mail|Act Date|||";
	    			
	    			var headCount = ComCountHeadTitle(HeadTitle1);
	    			sheet1HeadTitleCnt = headCount;
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 10, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false, false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                
	                HeadRowHeight = 20;
	                
//	                var prefix="sheet1_";
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,		daCenter,  	true,	"ibflag");
	                InitDataProperty(0, cnt++ , dtData,			 85,		daCenter,	true,	"bkg_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++,  dtImage, 		 25,		daCenter,	true,	"bkg_no_pop",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"vvd",						false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"pol_eta_dt",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"cntr_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"rqst_gdt", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 50,		daCenter,	true,	"slan_cd", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			140,		daLeft,		true,	"non_dcgo_kw_nm", 			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			140,		daLeft,		true,	"cmt_ctnt", 		    	false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cstms_desc", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cntr_mf_gds_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 25,		daCenter,	true,	"sb_cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			235,		daLeft,		true,	"cst_cmdt_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		235,		daLeft,		true,	"cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cmdt_nm",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"xter_rmk",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"inter_rmk",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_cmdt_nm",	false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_rmk", 		false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			 60,		daCenter,	true,	"spcl_cgo_apro_cd",			false,		"",		dfNone,		0,	true,	true);                    
	                InitDataProperty(0, cnt++ , dtData,			 55,		daCenter,	true,	"odek_flg",					false,		"",		dfNone,		0,	true,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"stwg_cd",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 15,		daCenter,	true,	"eml_snd_no",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 25,		daCenter,	true,	"eml_snd_no_pop",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"upd_dt", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"non_dcgo_rqst_seq");
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"usr_eml");
	                InitDataProperty(0, cnt++ , dtCheckBox,		  0,		daCenter,	true,	"chg_flg");
	                ColHidden('chg_flg')= true;
	                
	                ImageList(0) = "/hanjin/img/btns_search.gif";
	     		}
	     	break;
     		
         	case "t4sheet1":
         		with (sheetObj) {
	                // 높이 설정
	     			style.height = 400;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 0, 100);
	                var HeadTitle1  = "|BKG NO.|BKG NO.|VVD|POL ETA Date|CNTR'NO|Request Date|LANE|KEYWORD IV|Common Name|Customs Description|Container's Description|Booking Description of Goods|Booking Description of Goods|Booking Description of Goods|Commodity|Ext Remark|Int Remark|Commodity Detail|Remark(s)|Status|S/STWG|Booking STWG|Mail|Mail|Act Date|||";
	    			
	    			var headCount = ComCountHeadTitle(HeadTitle1);
	    			sheet1HeadTitleCnt = headCount;
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 10, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false, false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                
	                HeadRowHeight = 20;
	                
//	                var prefix="sheet1_";
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,		daCenter,  	true,	"ibflag");
	                InitDataProperty(0, cnt++ , dtData,			 85,		daCenter,	true,	"bkg_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++,  dtImage, 		 25,		daCenter,	true,	"bkg_no_pop",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"vvd",						false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"pol_eta_dt",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"cntr_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"rqst_gdt", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 50,		daCenter,	true,	"slan_cd", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			140,		daLeft,		true,	"non_dcgo_kw_nm", 			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			140,		daLeft,		true,	"cmt_ctnt", 		    	false,		"",		dfNone,		0,	false,	true);
		            InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cstms_desc", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cntr_mf_gds_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 25,		daCenter,	true,	"sb_cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			235,		daLeft,		true,	"cst_cmdt_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		235,		daLeft,		true,	"cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cmdt_nm",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"xter_rmk",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"inter_rmk",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_cmdt_nm",	false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_rmk", 		false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			 60,		daCenter,	true,	"spcl_cgo_apro_cd",			false,		"",		dfNone,		0,	true,	true);                    
	                InitDataProperty(0, cnt++ , dtData,			 55,		daCenter,	true,	"odek_flg",					false,		"",		dfNone,		0,	true,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"stwg_cd",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 15,		daCenter,	true,	"eml_snd_no",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 25,		daCenter,	true,	"eml_snd_no_pop",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"upd_dt", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"non_dcgo_rqst_seq");
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"usr_eml");
	                InitDataProperty(0, cnt++ , dtCheckBox,		  0,		daCenter,	true,	"chg_flg");
	                ColHidden('chg_flg')= true;
	                
	                ImageList(0) = "/hanjin/img/btns_search.gif";
	     		}
	     	break;
     		
         	case "t5sheet1":
         		with (sheetObj) {// NON-DG CHEMICAL
	                // 높이 설정
	     			style.height = 400;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 0, 100);
//	                var HeadTitle1  = "|BKG NO.|VVD|POL ETA Date|CNTR'NO|Request Date|LANE|KEYWORD IV|Customs Description|Container's Description|Booking Description of Goods|Booking Description of Goods|Booking Description of Goods|Ext Remark|Int Remark|Status|S/STWG|Booking STWG|Mail|Mail|||";
	                var HeadTitle1  = "|BKG NO.|BKG NO.|OFC|VVD|POL ETA Date|CNTR'NO|Request Date|LANE|Customs Description|Customs Description|Container's Description|Booking Description of Goods|Booking Description of Goods|Booking Description of Goods|Commodity|Ext Remark|Int Remark|Commodity Detail|Remark(s)|Status|S/STWG|Booking STWG|Mail|Mail|||";
	    			
	    			var headCount = ComCountHeadTitle(HeadTitle1);
	    			sheet1HeadTitleCnt = headCount;
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 8, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false, false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                
	                HeadRowHeight = 20;
	            
//	                var prefix="sheet1_";
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,		daCenter,  	true,	"ibflag");
	                InitDataProperty(0, cnt++ , dtData,			 85,		daCenter,	true,	"bkg_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++,  dtImage, 		 25,		daCenter,	true,	"bkg_no_pop",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++,  dtData, 		 40,		daCenter,	true,	"rqst_ofc_cd",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"vvd",						false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"pol_eta_dt",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,	true,	"cntr_no", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,	"rqst_gdt", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 50,		daCenter,	true,	"slan_cd", 					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"pol_eta_dt", 				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daLeft,		true,	"non_dcgo_kw_nm", 			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cntr_mf_gds_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			 25,		daCenter,	true,	"sb_cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			235,		daLeft,		true,	"cst_cmdt_desc",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		235,		daLeft,		true,	"cmdt_desc",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"cmdt_nm",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"xter_rmk",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daLeft,		true,	"inter_rmk",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_cmdt_nm",	false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			150,		daLeft,		true,	"new_cust_apro_rmk", 		false,		"",		dfNone,		0,	false,	true);// NON-DG CHEMICAL
	                InitDataProperty(0, cnt++ , dtData,			 60,		daCenter,	true,	"spcl_cgo_apro_cd",			false,		"",		dfNone,		0,	true,	true);                    
	                InitDataProperty(0, cnt++ , dtData,			 55,		daCenter,	true,	"odek_flg",					false,		"",		dfNone,		0,	true,	true);
	                InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,	"stwg_cd",					false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 15,		daCenter,	true,	"eml_snd_no",				false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtData,		 	 25,		daCenter,	true,	"eml_snd_no_pop",			false,		"",		dfNone,		0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"non_dcgo_rqst_seq");
	                InitDataProperty(0, cnt++ , dtHidden,		  0,		daCenter,	true,	"usr_eml");
	                InitDataProperty(0, cnt++ , dtCheckBox,		  0,		daCenter,	true,	"chg_flg");
	                ColHidden('chg_flg')= true;

					ImageList(0) = "/hanjin/img/btns_search.gif";
	     		}
	     	break;
	     	
         	case 'laneSheet':      // Vessel 정보 그리드
				with (sheetObj) {
					
					// 영문입력모드
					style.imeMode = "inactive";
					// 전체 너비 설정
					SheetWidth =320;
					ScrollBar = 0;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, laneSheetDataRows, laneSheetDataRows, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 1, false);
					
					// 해더기능([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
					InitHeadMode(false, false, false, false, false, false);
					
					var HeadTitle1 = "|||||||";	// 14
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, false, true);
					
					for(var i = 0 ; i <laneSheetDataRows ; i++){
//						InitDataProperty(i, 0 , dtData,      50, daCenter,  true,   "left",	false,	"",		dfNone,				0,			false,		false);
						
						for ( var j = 1; j < 7; j++) {
//							if (i == laneSheetLaneCdDataRow1) {
								InitDataProperty(i, j, dtData, 50, daCenter, false, "slan_cd" + j, false, "", dfNone, 0, true, true, 3); // Start Date
								InitDataValid(i, j, vtEngUpOther, "0123456789");
//							} else if (i == laneSheetLaneCdDataRow2) {
//								InitDataProperty(i, j, dtData, 50, daCenter, false, "slan_cd" + (j+3), false, "", dfNone, 0, true, true, 3); // Vessel Code
//								InitDataValid(i, j, vtEngUpOther, "0123456789");
//							}
						}
						InitDataProperty(i, j , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					
					}
					
//		            ShowButtonImage = 2;

					CountPosition = 0;
					//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
					InitHeadColumn("left", "Lane|Lane", daCenter);
					
					WaitImageVisible = false;
					
				}            
	            break;
	            
         	case 'rqstOfcCd':      // Vessel 정보 그리드
				with (sheetObj) {
					
					// 영문입력모드
					style.imeMode = "inactive";
					// 전체 너비 설정
					SheetWidth =420;
					ScrollBar = 0;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 1, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 1, false);
					
					// 해더기능([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
					InitHeadMode(false, false, false, false, false, false);
					
					var HeadTitle1 = "|||||||||";	// 14
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, false, true);
					
					for ( var j = 1; j <= rqstOfcCdCol; j++) {
							InitDataProperty(0, j, dtData, 50, daCenter, false, "rqst_ofc_cd" + j, false, "", dfNone, 0, true, true, 6); // Start Date
							InitDataValid(0, j, vtEngUpOther, "0123456789");
					}

					InitDataProperty(0, j , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");

//		            ShowButtonImage = 2;

					CountPosition = 0;
					//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
					InitHeadColumn("left", "REQUEST OFFICE CODE|REQUEST OFFICE CODE", daCenter);
					
					WaitImageVisible = false;
					
				}            
	            break;
         }
     }

     //업무 자바스크립트 OnKeyPress 이벤트 Catch
     function initControl() {
    	 axon_event.addListener ('keydown', 	'ComKeyEnter', 	'form');
    	 axon_event.addListenerForm('click', 	'obj_click', 	document.form); 
    	 axon_event.addListenerForm('keypress', 'obj_keypress',	document.form);
    	 axon_event.addListenerForm('keyup',	'obj_keyup', 	document.form);
    	 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form); 
    	 axon_event.addListenerForm('focus', 	'obj_focus', 	document.form); 
     }   
     
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         sheetObj.IsBufferedScroll = true;
         switch(sAction) {
         // 2016.03.29 조회조건에서 제외
//         	case IBSEARCH_ASYNC01: //RSO 조회
//         		sheetObj.WaitImageVisible = false;
//				formObj.f_cmd.value = SEARCH01;
//				var sXml = sheetObj.GetSearchXml("VOP_SCG_0034GS.do", FormQueryString(formObj));
//				ComXml2ComboItem(sXml, formObj.rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
//				
//	   			comboObjects[0].InsertItem(0, "ALL","");
//	   			comboObjects[0].Text = "ALL";
//				
//				break;

      // 2016.03.29 조회조건에서 제외
//         	case IBSEARCH_ASYNC02: //checkLane 조회
//         		formObj.f_cmd.value = SEARCH02;
//				var sParam = FormQueryString(formObj);
//				var sXml = sheetObj.getSearchXml("VOP_SCG_0024GS.do", sParam);
//				var laneInfo = new Object();
//				laneInfo.vslSlanCd = ComGetEtcData(sXml, "vsl_slan_cd");
//				return laneInfo;
//				
//				break;

         	case IBSEARCH:      //조회
	 			if(!validateForm(sheetObj,formObj,sAction))return;
         		formObj.f_cmd.value = SEARCH;

         		sheetObj.removeAll();
         		if (tabIndex == 0) {
         			scg_flg = "A";
             		formObj.t0retrieve_flg.value = "Y";
         		}else if (tabIndex == 1) {
         			scg_flg = "B";
             		formObj.t1retrieve_flg.value = "Y";
         		}else if (tabIndex == 2) {
         			scg_flg = "C";
             		formObj.t2retrieve_flg.value = "Y";
         		}else if (tabIndex == 3) {
         			scg_flg = "D";
             		formObj.t3retrieve_flg.value = "Y";
         		}else if (tabIndex == 4) { // NON-DG CHEMICAL
         			scg_flg = "NDC";
             		formObj.t4retrieve_flg.value = "Y";
         		}
         		
         		//파라미터 명시적인 생성
         		var formParams = FormQueryString(formObj);
//         		formParams += "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
//         		formParams += "&pagerows="       +ComGetObjValue(formObj.pagerows);
//         		formParams += "&rgn_shp_opr_cd=" +comboObjects[0].Code;
         		formParams += "&rgn_shp_opr_cd=ALL";	// 2016.03.29 조회조건에서 제외 - 로직유지
         		formParams += "&non_dg_cgo_status="     +ComGetObjValue(formObj.non_dg_cgo_status);
         		formParams += "&dg_flg="     +ComGetObjValue(formObj.dg_flg);
         		var sParam = ComGetSaveString(sheetObjects[0]);
         		
         		var sXml = sheetObj.GetSearchXml("VOP_SCG_0024GS.do", formParams+"&scg_flg="+scg_flg+"&"+sParam);
    			sheetObj.LoadSearchXml(sXml);
                break;

         	case IBSAVE:        //저장
         		if(validateForm(sheetObj,formObj,sAction)) {
         			
    				if( sheetObj.CheckedRows("chg_flg") < 1 ) {
    					ComShowMessage(ComGetMsg("SCG50047"));
    					return false;
    				}
    				
         			formObj.f_cmd.value = MULTI;
             		if (tabIndex == 0) {
             			scg_flg = "A";
             		}else if (tabIndex == 1) {
             			scg_flg = "B";
             		}else if (tabIndex == 2) {
             			scg_flg = "C";
             		}else if (tabIndex == 3) {
             			scg_flg = "D";
             		}else if (tabIndex == 4) { // NON-DG CHEMICAL
             			scg_flg = "NDC";
             		}

         			var sParam = ComGetSaveString(sheetObj);
         			if (sParam == "") return;
         			
         			//파라미터 명시적인 생성
         			var formParams = "";
	         		formParams += "&f_cmd="          +ComGetObjValue(formObj.f_cmd);
	         		formParams += "&pagerows="       +ComGetObjValue(formObj.pagerows);
//	         		formParams += "&rgn_shp_opr_cd=" +comboObjects[0].Code;
	         		formParams += "&rgn_shp_opr_cd=ALL";// 2016.03.29 조회조건에서 제외- 로직 유지
         			sParam += "&" + formParams;

         			var sXml = sheetObj.GetSaveXml("VOP_SCG_0024GS.do", sParam+"&scg_flg="+scg_flg);
         			var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
         			sheetObj.LoadSaveXml(sXml);

    				if ( svcResult == "S" ) {
    					// 저장 성공시에만 재조회 실행.
    					doActionIBSheet(sheetObj,document.form,IBSEARCH);
    				}

         		}
         		break;
         }
  		sheetObj.WaitImageVisible = true;
         
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
                     InsertTab( cnt++ , "KEYWORD I" , -1 );
                     InsertTab( cnt++ , "KEYWORD II" , -1 );
                     InsertTab( cnt++ , "KEYWORD III" , -1 );
                     InsertTab( cnt++ , "KEYWORD IV" , -1 );
                     InsertTab( cnt++ , "NON D/G CHEMICAL" , -1 );
                 }
              break;
          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem){
    	 var formObj = document.form;
    	 var objs = document.all.item("tabLayer");
    	 var tabSelectedIdx = ComGetObjValue(formObj.tabSelectedIdx);

    	 objs[nItem].style.display = "Inline";
    	 objs[beforetab].style.display = "none";
		 
    	 //--------------- 요기가 중요 --------------------------//
    	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	 //------------------------------------------------------//
    	 if (!validateForm(sheetObjects[parseInt(tabSelectedIdx,10) + 1],formObj,IBCLEAR)) return;
    	 
    	 beforetab= nItem;
    	 tabIndex = nItem;
		 
    	 if (tabIndex == 0 && document.form.retrieve_flg.value == "Y" && document.form.t0retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	 }else if (tabIndex == 1 && document.form.retrieve_flg.value == "Y" && document.form.t1retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
    	 }else if (tabIndex == 2 && document.form.retrieve_flg.value == "Y" && document.form.t2retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
    	 }else if (tabIndex == 3 && document.form.retrieve_flg.value == "Y" && document.form.t3retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[4],document.form,IBSEARCH);
    	 }else if (tabIndex == 4 && document.form.retrieve_flg.value == "Y" && document.form.t4retrieve_flg.value != "Y") {
    		 doActionIBSheet(sheetObjects[5],document.form,IBSEARCH);
    	 }
    	 ComSetObjValue(formObj.tabSelectedIdx, nItem);
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
    		case "engup":
    			//영문 대문자 만입력하기
    			ComKeyOnlyAlphabet('upper');
    			break;
    		case "uppernum":
    			//영문 대문자 만입력하기
    			ComKeyOnlyAlphabet('uppernum');
    			break;
		}
     }

     function obj_keyup(){
    	 ComKeyEnter('LengthNextFocus');
    	 var formObj = document.form;
     }
     
     function obj_blur() {
    	 var formObj = document.form;
    	 switch(event.srcElement.name){
    	 	case "slan_cd1": case "slan_cd2": case "slan_cd3": case "slan_cd4": case "slan_cd5": case "slan_cd6": case "slan_cd7": case "slan_cd8": case "slan_cd9": case "slan_cd10": case "slan_cd11":
    	 		var sInt = event.srcElement.name.substring(event.srcElement.name.length-1, event.srcElement.name.length);
    	 		var sLen = eval("formObj.slan_cd"+sInt+".value.length");
    	 		if (sLen == 3) {
    	 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
    	 		}else if (sLen != 0) {
         			ComShowCodeMessage('SCG50006',"Lane Code"+sInt, "3");
         			event.srcElement.focus();
         	     	event.srcElement.select();
    	    		return false;
    	 		}
    	 		break;
 	    	case "rqst_fr_dt":	case "rqst_to_dt":
 	    		ComAddSeparator(event.srcElement);
 	        	break;
    	 }
     }
     
     // 업무 자바스크립트 OnFocus 이벤트 처리
     function obj_focus() {
    	 
     	switch(event.srcElement.name){ 
 	    	case "rqst_fr_dt":	case "rqst_to_dt":
 	    		ComAddSeparator(event.srcElement);
 	        	break;
     	}
     }
     
     function obj_click() {
     }

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
     function onPopupClick(srcName, srcType){
    	 if (srcType == "Lane") {
    		 var objName = "btn_SlanCd";
    		 var sInt;
    		 if (srcName.indexOf(objName) > -1) {
    			 sInt = srcName.substring(objName.length, srcName.length);
    		 }else{
    			 sInt = srcName.substring(srcName.length-1, srcName.length);
    		 }
    		 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do', 426, 480, "sheet1_vsl_slan_cd:slan_cd"+sInt, "0,0", true);
    	 }
     }

     function clearAll() {
    	 var formObj = document.form;
    	 formObj.reset();
    	 sheetObjects[0].RemoveAll();
    	 sheetObjects[1].RemoveAll();
    	 sheetObjects[2].RemoveAll();
    	 sheetObjects[3].RemoveAll();
    	 sheetObjects[4].RemoveAll();
     }
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (sAction == IBSAVE){
    	 }else if (sAction == IBSEARCH) {
    		 // 2016.03.29 조회조건에서 제외- 로직 유지
//    		 if (comboObjects[0].Code == ""){ 
//				 ComShowCodeMessage('SCG50011','RSO');
//    			 formObj.rgn_shp_opr_cd.focus();
//    			 return;
//    		 }
    		if (formObj.rqst_fr_dt.value == "" || formObj.rqst_to_dt.value == "") {
    			 ComShowCodeMessage('SCG50011','Request Date');
				formObj.rqst_fr_dt.focus();
				return false;
			}

    	 }else if (sAction == IBCLEAR) {
			if(sheetObj.IsDataModified) {
				var msg1 = "";
				if (formObj.tabSelectedIdx.value == "0") {
					msg1 = "KEYWORD I";
				}else if (formObj.tabSelectedIdx.value == "1") {
					msg1 = "KEYWORD II";
				}else if (formObj.tabSelectedIdx.value == "2") {
					msg1 = "KEYWORD III";
				}else if (formObj.tabSelectedIdx.value == "3") {
					msg1 = "KEYWORD IV";
				}else if (formObj.tabSelectedIdx.value == "4") {
					msg1 = "NON D/G CHEMICAL";
				}
			}
    	 }
         return true;
     }

     /**
      * 승인코드에 따른 색지정 및 REJECT 코드 콤보 활성여부 설정
      */
     function setAuthStat(sheetObj, row)
     {
     	with(sheetObj)
     	{
     		var auth = CellText(row, "spcl_cgo_apro_cd").substring(0,1);
     		CellFont("FontBold", row, "spcl_cgo_apro_cd") = true;
			switch(auth)
			{
				case "H":
					CellFontColor(row, "spcl_cgo_apro_cd") = RgbColor(255, 0, 0);
					break;
					
				case "P":
					CellFontColor(row, "spcl_cgo_apro_cd") = RgbColor(38, 99, 224);
					break;
			}
     	}
     }

     function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 if(LastRow > 1){
	    		 for (var i=1; i <= LastRow; i++)
	    		 {
	    			 CellFontColor(i, "eml_snd_no_pop") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontBold", i, "eml_snd_no_pop") = true;
	    			 CellFont("FontUnderline", i, "eml_snd_no_pop") = true;
	
	    			 CellFontColor(i, "bkg_no") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontUnderline", i, "bkg_no") = true;
	    			 
	    			 if(sheetObj.CellValue(i,"bkg_dcgo_flg") =="DG"){
	    				 CellFontColor(i, "bkg_dcgo_flg") = sheetObj.RgbColor(255,0,0);
	    				 CellFont("FontBold", i, "bkg_dcgo_flg") = true;
	    			 }
	    			
	    			 // Keyword가 한개이상일 경우 다음줄로 셋팅.
	    			 var non_dcgo_kw_nm = sheetObj.CellValue(i,"non_dcgo_kw_nm").split(',');
	    			 var str_non_dcgo_kw_nm = "";
	    			 for(var b=0; b<non_dcgo_kw_nm.length; b++) {
	    				 str_non_dcgo_kw_nm += non_dcgo_kw_nm[b]+"\n";
	    			 }
	    			 sheetObj.CellValue2(i,"non_dcgo_kw_nm") = str_non_dcgo_kw_nm;
	
	    			// Booking Description of Goods 한줄 이상일경우, 한줄만 보여준다 
	 		 		var cmdt_desc_split = sheetObj.CellValue(i,"cmdt_desc").split('\n');
	 		 		if(cmdt_desc_split.length > 1){
	 		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = cmdt_desc_split[0];
	 		 			sheetObj.CellValue2(i,"sb_cmdt_desc") = "(+)";
	 		 			CellFontColor(i, "sb_cmdt_desc") = sheetObj.RgbColor(255, 0, 0);
	 		 		}else{
	 		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = sheetObj.CellValue(i,"cmdt_desc");
	 		 		}
	 		 		
	    			CellFontColor(i, "bkg_no_pop") = sheetObj.RgbColor(38, 99, 224);
	    			CellFont("FontUnderline", i, "bkg_no_pop") = true;
	    			
	    			setAuthStat(sheetObj, i);
	    			
	    		 }
    		 }
    	 }
     }
     
     function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 if(LastRow > 1){
	    		 for (var i=1; i <= LastRow; i++)
	    		 {
	    			 CellFontColor(i, "eml_snd_no_pop") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontBold", i, "eml_snd_no_pop") = true;
	    			 CellFont("FontUnderline", i, "eml_snd_no_pop") = true;
	
	    			 CellFontColor(i, "bkg_no") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontUnderline", i, "bkg_no") = true;
	    			 // Keyword가 한개이상일 경우 다음줄로 셋팅.
	    			 var non_dcgo_kw_nm = sheetObj.CellValue(i,"non_dcgo_kw_nm").split(',');
	    			 var str_non_dcgo_kw_nm = "";
	    			 for(var b=0; b<non_dcgo_kw_nm.length; b++) {
	    				 str_non_dcgo_kw_nm += non_dcgo_kw_nm[b]+"\n";
	    			 }
	    			 sheetObj.CellValue2(i,"non_dcgo_kw_nm") = str_non_dcgo_kw_nm;
	
	     			// Booking Description of Goods 한줄 이상일경우, 한줄만 보여준다 
	  		 		var cmdt_desc_split = sheetObj.CellValue(i,"cmdt_desc").split('\n');
	  		 		if(cmdt_desc_split.length > 1){
	  		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = cmdt_desc_split[0];
	  		 			sheetObj.CellValue2(i,"sb_cmdt_desc") = "(+)";
	  		 			CellFontColor(i, "sb_cmdt_desc") = sheetObj.RgbColor(255, 0, 0);
	  		 		}else{
	  		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = sheetObj.CellValue(i,"cmdt_desc");
	  		 		}
	     			
	    			CellFontColor(i, "bkg_no_pop") = sheetObj.RgbColor(38, 99, 224);
	    			CellFont("FontUnderline", i, "bkg_no_pop") = true;
	    			
	    			setAuthStat(sheetObj, i);
	    		 }
    		 }
    	 }
     }

     function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 if(LastRow > 1){
	    		 for (var i=1; i <= LastRow; i++)
	    		 {
	    			 CellFontColor(i, "eml_snd_no_pop") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontBold", i, "eml_snd_no_pop") = true;
	    			 CellFont("FontUnderline", i, "eml_snd_no_pop") = true;
	
	    			 CellFontColor(i, "bkg_no") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontUnderline", i, "bkg_no") = true;
	    			 // Keyword가 한개이상일 경우 다음줄로 셋팅.
	//    			 sheetObj.CellValue2(i,"non_dcgo_kw_nm") = sheetObj.CellValue(i,"non_dcgo_kw_nm").replace(',','\n');
	    			 var non_dcgo_kw_nm = sheetObj.CellValue(i,"non_dcgo_kw_nm").split(',');
	    			 var str_non_dcgo_kw_nm = "";
	    			 for(var b=0; b<non_dcgo_kw_nm.length; b++) {
	    				 str_non_dcgo_kw_nm += non_dcgo_kw_nm[b]+"\n";
	    			 }
	    			 sheetObj.CellValue2(i,"non_dcgo_kw_nm") = str_non_dcgo_kw_nm;
	
	     			// Booking Description of Goods 한줄 이상일경우, 한줄만 보여준다 
	  		 		var cmdt_desc_split = sheetObj.CellValue(i,"cmdt_desc").split('\n');
	  		 		if(cmdt_desc_split.length > 1){
	  		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = cmdt_desc_split[0];
	  		 			sheetObj.CellValue2(i,"sb_cmdt_desc") = "(+)";
	  		 			CellFontColor(i, "sb_cmdt_desc") = sheetObj.RgbColor(255, 0, 0);
	  		 		}else{
	  		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = sheetObj.CellValue(i,"cmdt_desc");
	  		 		}
	     			
	  		 		CellFontColor(i, "bkg_no_pop") = sheetObj.RgbColor(38, 99, 224);
	  		 		CellFont("FontUnderline", i, "bkg_no_pop") = true;
	  		 		
	    			setAuthStat(sheetObj, i);
	    		 }
    		 }
    	 }
     }

     function t4sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 if(LastRow > 1){
	    		 for (var i=1; i <= LastRow; i++)
	    		 {
	    			 CellFontColor(i, "eml_snd_no_pop") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontBold", i, "eml_snd_no_pop") = true;
	    			 CellFont("FontUnderline", i, "eml_snd_no_pop") = true;
	
	    			 CellFontColor(i, "bkg_no") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontUnderline", i, "bkg_no") = true;
	    			 // Keyword가 한개이상일 경우 다음줄로 셋팅.
	    			 var non_dcgo_kw_nm = sheetObj.CellValue(i,"non_dcgo_kw_nm").split(',');
	    			 var str_non_dcgo_kw_nm = "";
	    			 for(var b=0; b<non_dcgo_kw_nm.length; b++) {
	    				 str_non_dcgo_kw_nm += non_dcgo_kw_nm[b]+"\n";
	    			 }
	    			 sheetObj.CellValue2(i,"non_dcgo_kw_nm") = str_non_dcgo_kw_nm;
	    			 
	
	     			// Booking Description of Goods 한줄 이상일경우, 한줄만 보여준다 
	  		 		var cmdt_desc_split = sheetObj.CellValue(i,"cmdt_desc").split('\n');
	  		 		if(cmdt_desc_split.length > 1){
	  		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = cmdt_desc_split[0];
	  		 			sheetObj.CellValue2(i,"sb_cmdt_desc") = "(+)";
	  		 			CellFontColor(i, "sb_cmdt_desc") = sheetObj.RgbColor(255, 0, 0);
	  		 		}else{
	  		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = sheetObj.CellValue(i,"cmdt_desc");
	  		 		}
	     			
	  		 		CellFontColor(i, "bkg_no_pop") = sheetObj.RgbColor(38, 99, 224);
	  		 		CellFont("FontUnderline", i, "bkg_no_pop") = true;
	  		 		
	  		 		setAuthStat(sheetObj, i);
	    		 }
    		 }
    	 }
     }

     function t5sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 with(sheetObj)
    	 {
    		 if(LastRow > 1){
	    		 for (var i=1; i <= LastRow; i++)
	    		 {
	    			 CellFontColor(i, "eml_snd_no_pop") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontBold", i, "eml_snd_no_pop") = true;
	    			 CellFont("FontUnderline", i, "eml_snd_no_pop") = true;
	
	    			 CellFontColor(i, "bkg_no") = sheetObj.RgbColor(38, 99, 224);
	    			 CellFont("FontUnderline", i, "bkg_no") = true;
//	    			 // Keyword가 한개이상일 경우 다음줄로 셋팅.
//	    			 var non_dcgo_kw_nm = sheetObj.CellValue(i,"non_dcgo_kw_nm").split(',');
//	    			 var str_non_dcgo_kw_nm = "";
//	    			 for(var b=0; b<non_dcgo_kw_nm.length; b++) {
//	    				 str_non_dcgo_kw_nm += non_dcgo_kw_nm[b]+"\n";
//	    			 }
//	    			 sheetObj.CellValue2(i,"non_dcgo_kw_nm") = str_non_dcgo_kw_nm;
	    			 
	
	     			// Booking Description of Goods 한줄 이상일경우, 한줄만 보여준다 
	  		 		var cmdt_desc_split = sheetObj.CellValue(i,"cmdt_desc").split('\n');
	  		 		if(cmdt_desc_split.length > 1){
	  		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = cmdt_desc_split[0];
	  		 			sheetObj.CellValue2(i,"sb_cmdt_desc") = "(+)";
	  		 			CellFontColor(i, "sb_cmdt_desc") = sheetObj.RgbColor(255, 0, 0);
	  		 		}else{
	  		 			sheetObj.CellValue2(i,"cst_cmdt_desc") = sheetObj.CellValue(i,"cmdt_desc");
	  		 		}
	     			
	  		 		CellFontColor(i, "bkg_no_pop") = sheetObj.RgbColor(38, 99, 224);
	  		 		CellFont("FontUnderline", i, "bkg_no_pop") = true;
	  		 		
	  		 		setAuthStat(sheetObj, i);
	    		 }
    		 }
    	 }
     }
     
     function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
     }
     
     function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
     }
     
     function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
     }
     
     function t4sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
     }

     function t5sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) 
     {
     }

     function t1sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
    		 
    		    case "imdg_un_no":
    		    	ComOpenWindowCenter("ESM_BKG_0200.do?pgmNo=ESM_BKG_0200&bkg_no="+sheetObj.CellValue(Row,"bkg_no")+"&ca_flg="+"", "ESM_BKG_0055", 1010, 570, true);
    		    	break;
	 		 	case "bkg_no":
	 		 		comBkgCallPopBkgDetail(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
	 		 	case "eml_snd_no_pop":
 		  	  		if(sheetObj.CellValue(Row,"eml_snd_no") == 'Y'){
 						if(ComShowCodeConfirm('SCG50046', "")) {
 							sendMail(sheetObj, Row, Col);
 						}
 		  	  		}else{
 		  	  			sendMail(sheetObj, Row, Col);
 		  	  		}
	 		 		
			 		break;
	 		 	case "spcl_cgo_apro_cd":
			 		auth_cd = CellText(Row, "spcl_cgo_apro_cd");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_apro_cd", "");      			
			 		sheetObj.InitDataCombo(0, "spcl_cgo_apro_cd", "Pass|Hold|Undeclared", "P|H|X");
			 		break;
	 		 	case "odek_flg":
			 		auth_cd = CellText(Row, "odek_flg");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "odek_flg", "");      			
			 		sheetObj.InitDataCombo(0, "odek_flg", "ON DECK|N/A", "O|N");
			 		break;
	 		 	case "bkg_no_pop":
	 		 		comBkgCallPopBkgAttachment(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
    		 }
    	 }
     }

     function t2sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "bkg_no":
	 		 		comBkgCallPopBkgDetail(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
	 		 	case "eml_snd_no_pop":
 		  	  		if(sheetObj.CellValue(Row,"eml_snd_no") == 'Y'){
 						if(ComShowCodeConfirm('SCG50046', "")) {
 							sendMail(sheetObj, Row, Col);
 						}
 		  	  		}else{
 		  	  			sendMail(sheetObj, Row, Col);
 		  	  		}
	 		 		
			 		break;
	 		 	case "spcl_cgo_apro_cd":
			 		auth_cd = CellText(Row, "spcl_cgo_apro_cd");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_apro_cd", "");      			
			 		sheetObj.InitDataCombo(0, "spcl_cgo_apro_cd", "Pass|Hold|Undeclared", "P|H|X");
			 		break;
	 		 	case "odek_flg":
			 		auth_cd = CellText(Row, "odek_flg");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "odek_flg", "");      			
			 		sheetObj.InitDataCombo(0, "odek_flg", "ON DECK|N/A", "O|");
			 		break;
	 		 	case "bkg_no_pop":
	 		 		comBkgCallPopBkgAttachment(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
    		 }
    	 }
     }

     function t3sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "bkg_no":
	 		 		comBkgCallPopBkgDetail(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
	 		 	case "eml_snd_no_pop":
 		  	  		if(sheetObj.CellValue(Row,"eml_snd_no") == 'Y'){
 						if(ComShowCodeConfirm('SCG50046', "")) {
 							sendMail(sheetObj, Row, Col);
 						}
 		  	  		}else{
 		  	  			sendMail(sheetObj, Row, Col);
 		  	  		}
	 		 		
			 		break;
	 		 	case "spcl_cgo_apro_cd":
			 		auth_cd = CellText(Row, "spcl_cgo_apro_cd");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_apro_cd", "");      			
			 		sheetObj.InitDataCombo(0, "spcl_cgo_apro_cd", "Pass|Hold|Undeclared", "P|H|X");
			 		break;
	 		 	case "odek_flg":
			 		auth_cd = CellText(Row, "odek_flg");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "odek_flg", "");      			
			 		sheetObj.InitDataCombo(0, "odek_flg", "ON DECK|N/A", "O|");
			 		break;
	 		 	case "bkg_no_pop":
	 		 		comBkgCallPopBkgAttachment(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
    		 }
    	 }
     }

     function t4sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "bkg_no":
	 		 		comBkgCallPopBkgDetail(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
	 		 	case "eml_snd_no_pop":
 		  	  		if(sheetObj.CellValue(Row,"eml_snd_no") == 'Y'){
 						if(ComShowCodeConfirm('SCG50046', "")) {
 							sendMail(sheetObj, Row, Col);
 						}
 		  	  		}else{
 		  	  			sendMail(sheetObj, Row, Col);
 		  	  		}
	 		 		
			 		break;
	 		 	case "spcl_cgo_apro_cd":
			 		auth_cd = CellText(Row, "spcl_cgo_apro_cd");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_apro_cd", "");      			
			 		sheetObj.InitDataCombo(0, "spcl_cgo_apro_cd", "Pass|Hold|Undeclared", "P|H|X");
			 		break;
	 		 	case "odek_flg":
			 		auth_cd = CellText(Row, "odek_flg");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "odek_flg", "");      			
			 		sheetObj.InitDataCombo(0, "odek_flg", "ON DECK|N/A", "O|");
			 		break;
	 		 	case "bkg_no_pop":
	 		 		comBkgCallPopBkgAttachment(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
    		 }
    	 }
     }
     
     function t5sheet1_OnClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "bkg_no":
	 		 		comBkgCallPopBkgDetail(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
	 		 	case "eml_snd_no_pop":
 		  	  		if(sheetObj.CellValue(Row,"eml_snd_no") == 'Y'){
 						if(ComShowCodeConfirm('SCG50046', "")) {
 							sendMail(sheetObj, Row, Col);
 						}
 		  	  		}else{
 		  	  			sendMail(sheetObj, Row, Col);
 		  	  		}
	 		 		
			 		break;
	 		 	case "spcl_cgo_apro_cd":
			 		auth_cd = CellText(Row, "spcl_cgo_apro_cd");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "spcl_cgo_apro_cd", "");
			 		sheetObj.InitDataCombo(0, "spcl_cgo_apro_cd", "Pass|Hold|Undeclared", "P|H|X");
			 		break;
	 		 	case "odek_flg":
			 		auth_cd = CellText(Row, "odek_flg");
			 		sheetObj.InitCellProperty(Row, Col, dtCombo, daCenter, "odek_flg", "");      			
			 		sheetObj.InitDataCombo(0, "odek_flg", "ON DECK|N/A", "O|");
			 		break;
	 		 	case "bkg_no_pop":
	 		 		comBkgCallPopBkgAttachment(sheetObj.CellValue(Row,"bkg_no"));
			 		break;
    		 }
    	 }
     }
     
     function t1sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "cstms_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cntr_mf_gds_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cst_cmdt_desc":
	 		 			bookingDescPop(sheetObj, Row, "cmdt_desc");
	 		 		break;
	 		 	case "xter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "inter_rmk":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
	 		 	case "new_cust_apro_cmdt_nm":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
	 		 	case "new_cust_apro_rmk":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
    		 }
    	 }
     }
     
     function t2sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "cstms_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cntr_mf_gds_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cst_cmdt_desc":
	 		 			bookingDescPop(sheetObj, Row, "cmdt_desc");
	 		 		break;
	 		 	case "xter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "inter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "new_cust_apro_cmdt_nm":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
	 		 	case "new_cust_apro_rmk":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
    		 }
    	 }
     }
     
     function t3sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "cstms_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cntr_mf_gds_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cst_cmdt_desc":
	 		 			bookingDescPop(sheetObj, Row, "cmdt_desc");
	 		 		break;
	 		 	case "xter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "inter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "new_cust_apro_cmdt_nm":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
	 		 	case "new_cust_apro_rmk":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
    		 }
    	 }
     }
     
     function t4sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "cstms_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cntr_mf_gds_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cst_cmdt_desc":
	 		 			bookingDescPop(sheetObj, Row, "cmdt_desc");
	 		 		break;
	 		 	case "xter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "inter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "new_cust_apro_cmdt_nm":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
	 		 	case "new_cust_apro_rmk":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
    		 }
    	 }
     }
     
     function t5sheet1_OnDblClick(sheetObj, Row, Col, Val)
     {
    	 with(sheetObj)
    	 {
    		 var colname = ColSaveName(Col);
    		 var formObj = document.form;
    		 switch(colname)
    		 {
	 		 	case "cstms_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cntr_mf_gds_desc":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "cst_cmdt_desc":
	 		 			bookingDescPop(sheetObj, Row, "cmdt_desc");
	 		 		break;
	 		 	case "xter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "inter_rmk":
	 		 			bookingDescPop(sheetObj, Row, colname);
			 		break;
	 		 	case "new_cust_apro_cmdt_nm":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
	 		 	case "new_cust_apro_rmk":
 		 			bookingDescPop(sheetObj, Row, colname);
 		 			break;
    		 }
    	 }
     }
     
     function t1sheet1_OnChange(sheetObj, Row, Col, Val){
   		var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);
	 	switch(colName) {
 		case('spcl_cgo_apro_cd'):
 			sheetObj.CellValue2(Row, "chg_flg") = "1";
 			break;
 		case('odek_flg'):
 			sheetObj.CellValue2(Row, "chg_flg") = "1";
 			break;
	 	}
     }

     function t2sheet1_OnChange(sheetObj, Row, Col, Val){
  		var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);
	 	switch(colName) {
 		case('spcl_cgo_apro_cd'):
 			sheetObj.CellValue2(Row, "chg_flg") = "1";
 			break;
 		case('odek_flg'):
 			sheetObj.CellValue2(Row, "chg_flg") = "1";
 			break;
	 	}
     }

     function t3sheet1_OnChange(sheetObj, Row, Col, Val){
   		var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);
	 	switch(colName) {
 		case('spcl_cgo_apro_cd'):
 			sheetObj.CellValue2(Row, "chg_flg") = "1";
 			break;
 		case('odek_flg'):
 			sheetObj.CellValue2(Row, "chg_flg") = "1";
 			break;
	 	}
     }

     function t4sheet1_OnChange(sheetObj, Row, Col, Val){
   		var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);
	 	switch(colName) {
 		case('spcl_cgo_apro_cd'):
 			sheetObj.CellValue2(Row, "chg_flg") = "1";
 			break;
 		case('odek_flg'):
 			sheetObj.CellValue2(Row, "chg_flg") = "1";
 			break;
	 	}
     }

     function t5sheet1_OnChange(sheetObj, Row, Col, Val){
    		var formObj = document.form;
 		var colName = sheetObj.ColSaveName(Col);
 	 	switch(colName) {
  		case('spcl_cgo_apro_cd'):
  			sheetObj.CellValue2(Row, "chg_flg") = "1";
  			break;
  		case('odek_flg'):
  			sheetObj.CellValue2(Row, "chg_flg") = "1";
  			break;
 	 	}
      }
  // 2016.03.29 조회조건에서 제외 - 로직유지
/*
     function laneSheet_OnChange(sheetObj , Row, Col, Value){
     	
		if(!Value || Value==""){
			return false;
		}
		var formObj = document.form;
		var datarow = Row - sheetObj.HeaderRows; // row는 DataRow 상의 위치
		if(sheetObj.CellValue(Row, Col).length == 3){
			formObj.vsl_slan_cd.value = Value;
			// 이미 입력한 lane code인지 확인
			for(var i=0; i<Col; i++){
				if(Value == sheetObj.CellValue(Row, i)){
					ComShowCodeMessage('SCG50005', Value);
					sheetObj.SelectCell(Row, Col);
		        	sheetObj.CellValue2(Row, Col) = "";
		        	return false;
				}
			}
				
			var laneInfo = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
			if(laneInfo.vslSlanCd && laneInfo.vslSlanCd!=""){
				sheetObj.ToolTipText(Row, Col) = laneInfo.vslSlanCd;
//				if(Col == 12){
//					sheetObj.SelectCell(Row, Col, false);
//				}else if(Col == 13){
//				}else{
					sheetObj.SelectCell(Row, Col+1);
//				}
			}else{
				alert(Value + " is not target lane");
				if(Col < 5){
					sheetObj.SelectCell(Row, Col);
				}else{
					sheetObj.SelectCell(Row, Col-1, false);
				}
				sheetObj.CellValue2(Row, Col) = "";
			}
		}
		
	}
*/
     function rqstOfcCd_OnChange(sheetObj , Row, Col, Value){
 		if(!Value || Value==""){
 			return false;
 		}
 		var formObj = document.form;
 		var datarow = Row - sheetObj.HeaderRows; // row는 DataRow 상의 위치
 	
 		// 이미 입력한 rqst_ofc_cd 인지 확인
		for(var i=0; i<9; i++){
			if(i == Col){
			}else{
				if(Value == sheetObj.CellValue(Row, i)){
					ComShowCodeMessage('SCG50005', Value);
					sheetObj.SelectCell(Row, Col);
		        	sheetObj.CellValue2(Row, Col) = "";
		        	return false;
				}
			}
		}
 	}
     
 	function laneSheet_OnKeyUp(sheetObj, Row, Col, Value){
		if(sheetObj.EditText.length == 3){
			if(Col != 3){
				sheetObj.SelectCell(Row, Col, false);
			}else{
				sheetObj.SelectCell(Row, Col-1, false);
			}
		}
    }
 	
 	function sendMail(sheetObj, Row, Col) {
 		var content = "";
 		var formObj = document.form;
		var non_dcgo_kw_nm = sheetObj.CellValue(Row,"non_dcgo_kw_nm");
		var non_dcgo_kw_nm_split = sheetObj.CellValue(Row,"non_dcgo_kw_nm").split(' ');
		var cmdt_desc = sheetObj.CellValue(Row,"cmdt_desc");
 		var cmdt_desc_split = cmdt_desc.split('\n');
 		
 		for(var i=0; i<cmdt_desc_split.length; i++) {
 			var space_cmdt_desc_split = cmdt_desc_split[i].split(' ');

 			for(var j=0; j<space_cmdt_desc_split.length; j++) {
 				content += space_cmdt_desc_split[j]+" ";
 			}
 			content += "<BR>";
 		}

    	 mailObj.bkg_no = sheetObj.CellValue(Row,"bkg_no");
    	 mailObj.non_dcgo_rqst_seq = sheetObj.CellValue(Row,"non_dcgo_rqst_seq");
    	 formObj.bkg_no.value = sheetObj.CellValue(Row,"bkg_no");
    	 formObj.non_dcgo_rqst_seq.value = sheetObj.CellValue(Row,"non_dcgo_rqst_seq");
    	 ComScgSendUDGMail(sheetObj, formObj, mailObj, true, "VOP_SCG_0024GS.do", "");
    	 
		// 메일 성공시에만 재조회 실행.
//		doActionIBSheet(sheetObj,document.form,IBSEARCH);
 	} 	
 	
 	function bookingDescPop(sheetObj, Row, Col) {
 		var formObj = document.form;
 		var content = "";
		var non_dcgo_kw_nm = sheetObj.CellValue(Row,"non_dcgo_kw_nm").split('\n');
		var non_dcgo_kw_nm_split = [];
		var desc_pop = sheetObj.CellValue(Row,Col);
		if(desc_pop != ''){
	 		var desc_pop_split = desc_pop.split('\n');
	
	 		var a = 0;
	 		for(var b=0; b<non_dcgo_kw_nm.length; b++) {
	 			var space_non_dcgo_kw_nm_1 = non_dcgo_kw_nm[b].split(' ');
	 		
	 		for(var c=0; c<space_non_dcgo_kw_nm_1.length; c++) {
	 			non_dcgo_kw_nm_split[a] = space_non_dcgo_kw_nm_1[c];
	 			a++;
	 		}
	 		}
	 		
	 		for(var i=0; i<desc_pop_split.length; i++) {
	 			var space_desc_pop_split = desc_pop_split[i].split(' ');
	
	 			for(var j=0; j<space_desc_pop_split.length; j++) {
	 				
	 				for(var k=0; k<non_dcgo_kw_nm_split.length; k++) {
		 				if(specialTrim(space_desc_pop_split[j]) == ComTrim(non_dcgo_kw_nm_split[k])){
		 					content += "<FONT COLOR='RED'>";
		 				}
		 				else {  if(space_desc_pop_split[j] !="" && non_dcgo_kw_nm_split[k] != "" && space_desc_pop_split[j].indexOf(non_dcgo_kw_nm_split[k]) != -1)
		 				          { 	content += "<FONT COLOR='RED'>"; }
		 			  	     }
	 				}
	 				
	 				content += space_desc_pop_split[j];
	 				
	 				for(var k=0; k<non_dcgo_kw_nm_split.length; k++) {
		 				if(specialTrim(space_desc_pop_split[j]) == ComTrim(non_dcgo_kw_nm_split[k])){
		 					content += "</FONT> ";
		 				}
		 				else {  if(space_desc_pop_split[j] !="" && non_dcgo_kw_nm_split[k] != "" && space_desc_pop_split[j].indexOf(non_dcgo_kw_nm_split[k]) != -1)
		 				        { 	content += "</FONT>"; }
		 				}
	 				}
	 				
	 				content += " ";
	 				
	 			}
	 			content += "<BR>";
	 			
	 		}
	 		formObj.content.value = content;
		   	var theURL = "VOP_SCG_0025.do";
//		   	var theURL = "VOP_SCG_0025.do?"+FormQueryString(formObj);
		   	var winName = "Booking Description of Goods Detail";
		   	var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:500px;dialogHeight:500px";
		   	ComOpenWindow(theURL,winName,features,true);
		} 		
 	} 	
 	
 	function specialTrim(str) {
// 		str = ComTrimAll(str,",","/","[","`","~","!","@","#","$","%","^",";","*","|",";",":","/","?","]","(",")").replace(/\s/g, "");
// 		str = ComTrimAll(str,",","/","`","~","!","@","#","$","%","^",";","|",";",":","/","?").replace(/\s/g, "");
 		str = ComTrimAll(str,",","`","~","!","@","#","$","%","^",";","|",";","/","?").replace(/\s/g, "");
 		return str;
 	} 	
     /* 개발자 작업  끝 */
 	