/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2017.js
*@FileTitle : SZPSC DEM Calculation &amp; Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.13 황효근
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
     * @class EES_DMT_2017 : EES_DMT_2017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_2017() {
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
	
	var uploadObjects = new Array();
	var uploadCnt = 0;
	 
	// RD
	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	var oldRow = 0;
	
	//Action 정의
	var IBSEARCH_ACTCOST	= 90;
	var IBSEARCH_FULLHIS	= 91;
	var IBSEARCH_ADDRSN		= 92;
	var IBSEARCH_DETAIL     = 93;
	var IBSEARCH_PFMC		= 94;
	var IBSEARCH_LCC_MAS    = 95;
	
	var IBSAVE_FILEUPLOAD   = 101;
	var IBSEARCH_LOC		= 102;
	var IBSEARCH_VVD		= 103;
	
	var IBSEARCH_ITEM       = 201;
	var IBSEARCH_RSNVAL     = 202;
	var IBSEARCH_UCTTL      = 203;
	
	//업무전역변수
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	var PAYER_CD = "act_payr_cust_cd";
	var PAYER_NM = "act_payr_cust_nm";
	var TRUCKER_CD = "vndr_seq";
	var TRUCKER_NM = "vndr_nm";
	
	var FILE_SELECT_CANCEL     = "USER_CANCEL";
	var FILE_NM 			    = "file_nm";
	var FILE_SIZE			    = "file_size";
	var FILE_PATH 			    = "file_path";
	var FILE_SAV_ID 		    = "file_sav_id";
	var UPD_DT                 = "upd_dt";
	var PREFIX 			    = "";
	var URL_FILE_DOWNLOAD 	    = "/hanjin/FileDownload";
	var FILE_DIV_CD             = "aft_bkg_file_div_cd";
	var RMK_LVL                 = "aft_bkg_rmk_lvl";
	
	// Tab2내  IBSeet Height 초기값
	var TAB2_SHEET_HEIGHT = 82;
	// ****************************************
	
	 var REASON_DETAIL_START    = 1;
	 var REASON_DETAIL_END      = 9;
	 	 
	 var spec_rsn_cd_1 = "";
	 var spec_rsn_row = "";

	 var retrieve_flg = "N";

	 var gObjId = "";	// Button Click 이벤트 발생시 해당 Callback 함수로 발생된 폼컨트롤의 id 를 전달하기 위해서 사용함.
	 var spec_rsn_cd_row = 0;
	 var spec_rsn_cd_col = "";

	 var vvd_flg = "N";
	 var port_flg = "N";
	 
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;

	 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){

         var formObj = document.form;

         try {
        	 var srcObj = window.event.srcElement;
        	 var srcName = srcObj.getAttribute("name");
        	 
        	 // 그리드 하단 버튼 클릭시  비활성화 상태이면 그냥 return
        	 if(!ComIsBtnEnable(srcName)) return;
                                           
        	 switch(srcName) {
        	 	case "btn_crl_upload": 
        	 		doActionFileUpload('CSRL01');
					break;
        	 	case "btn_crl_file_delete":
        	 		doActionFileDelete('CSRL01');
					break;
        	 	case "btn_oain_upload": 
        	 		doActionFileUpload('OAIN01');
					break;
        	 	case "btn_oain_file_delete":
        	 		doActionFileDelete('OAIN01');
					break;
        	 	case "btn_cin_upload": 
        	 		doActionFileUpload('CINW01');
					break;
        	 	case "btn_cin_file_delete":
        	 		doActionFileDelete('CINW01');
					break;
        	 	case "btn_csp_upload": 
        	 		doActionFileUpload('CSSP01');
					break;
        	 	case "btn_csp_file_delete":
        	 		doActionFileDelete('CSSP01');
					break;										

        	 	case "btn_gtl_upload": 
        	 		doActionFileUpload('LETT01');
					break;
        	 	case "btn_gtl_file_delete":
        	 		doActionFileDelete('LETT01');
					break;

        	 	case "btn_full_row_add": 
        	 		doActionRowAdd('FULL');
					break;
        	 	case "btn_full_row_delete":
        	 		doActionRowDelete('FULL');
					break;
					

        	 	case "btn_aer_upload": 
        	 		doActionFileUpload('AER');
					break;
        	 	case "btn_aer_file_delete":
        	 		doActionFileDelete('AER');
					break;
					
        	 	case "btn_aer_row_add": 
        	 		doActionRowAdd('AER');
					break;
        	 	case "btn_aer_row_delete":
        	 		doActionRowDelete('AER');
					break;
					
        	 	case "btn_pfmc_retrieve":
        	 		doActionPrmcRetrieve();
        	 		break;
        	 		
        	 	case "btn_Save":
        	 		doActionSave();
        	 		break;

				case "btn_Close":
					window.close();
					break;
					
				case "btn_lcc_retrieve":
					doActionLccRetrieve();
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
      
    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++] = combo_obj;
  	} 

    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
    function setUploadObject(upload_obj) {
    	uploadObjects[uploadCnt++] = upload_obj;
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
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
	function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
    	}
         
    	// IBMultiCombo초기화 
//		for(var k=0;k<comboObjects.length;k++){
//			initCombo(comboObjects[k],k+1);
//		}

    	for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
        }
    	
		// UPLOAD 환경 설정
		for (var i=0; i<uploadObjects.length; i++) {
			// 기본 환경 설정
			ComConfigUpload(uploadObjects[i], "/hanjin/EES_DMT_2017GS.do");
		}
		uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
		
	    //Axon 
 		
 		//html컨트롤 이벤트초기화
		initControl();
		
		doInit();

	}
      
	// Tab-1 화면 초기화
  	function doInit() {
		var formObj = document.form;
		
		formObj.pfmc_flg[2].checked = true;
		formObj.lcc_flg[2].checked = true;
		
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ACTCOST);		//Actual Cost
		doActionIBSheet(sheetObjects[6], formObj, IBSEARCH_PFMC);			//DMT PFMC
		doActionIBSheet(sheetObjects[7], formObj, IBSEARCH_LCC_MAS);		//DMT MAS
		doActionIBSheet(sheetObjects[8], formObj, IBSEARCH_FULLHIS);		//Full History
		doActionIBSheet(sheetObjects[10], formObj, IBSEARCH_ADDRSN);		//Additional Evidence Reason
		
		if (formObj.rqst_flg.value != "Y") {
			doActionIBSheet(sheetObjects[12], formObj, IBSEARCH_ITEM);		//Approval
		} 
		else {
			tabObjects[0].TabEnable(4) = false;
		}
		
		if (formObj.rqst_flg.value != "Y") {
			
			tabObjects[0].SelectedIndex = 4;
			
            ComEnableObject(formObj.rsn_dc_rqst, false);
            ComEnableObject(formObj.rsn_cle_delay, false);
            
            if (formObj.save_sts_cd.value == "N" || formObj.save_sts_cd.value == "R") {
	            for(var i=0; i < sheetObjects.length ; i++) {
	    			sheetObjects[i].Editable = false;
	    		}
            } 
            else {
	            for(var i=0; i < sheetObjects.length-1 ; i++) {
	    			sheetObjects[i].Editable = false;
	    		}

	            var col_1 = 0;
	            var col_2 = 0;
	            
	            switch(formObj.apvl_path_cd.value) {
	            	case "BBOPIC":
	            		col_1 = 5;
	            		col_2 = 6;
	            		break;
	            	case "BBGMGR": 
	            		col_1 = 7;
	            		col_2 = 8;      		
	            		break;
	            	case "RHQPIC":	 
	            		col_1 = 9;
	            		col_2 = 10;           		
	            		break;
	            	case "RHQMGR":	 
	            		col_1 = 11;
	            		col_2 = 12;           		
	            		break;
	            	case "HDOPIC":	  
	            		col_1 = 13;
	            		col_2 = 14;          		
	            		break;
	            	case "HDOMGR":
	            		col_1 = 15;
	            		col_2 = 16;	            		
	            		break;
	            }
	            
	            if ( col_1 != 0 ){
		            sheetObjects[12].CellEditable(3,col_1) = true;
	        		sheetObjects[12].CellEditable(3,col_2) = true;
	        		sheetObjects[12].CellEditable(5,col_1) = true;
	        		sheetObjects[12].CellEditable(5,col_2) = true;
	        		sheetObjects[12].CellEditable(7,col_1) = true;
	        		sheetObjects[12].CellEditable(7,col_2) = true;
	        		sheetObjects[12].CellEditable(9,col_1) = true;
	        		sheetObjects[12].CellEditable(9,col_2) = true;
	        		sheetObjects[12].CellEditable(10,col_1) = true;
	        		sheetObjects[12].CellEditable(10,col_2) = true;
	        		sheetObjects[12].CellEditable(12,col_1) = true;
	        		sheetObjects[12].CellEditable(12,col_2) = true;
	        		sheetObjects[12].CellEditable(14,col_1) = true;
	        		sheetObjects[12].CellEditable(14,col_2) = true;
	            }
            }

    		ComBtnDisable("btn_crl_upload");
    		ComBtnDisable("btn_crl_file_delete");
    		ComBtnDisable("btn_oain_upload");
    		ComBtnDisable("btn_oain_file_delete");
    		ComBtnDisable("btn_cio_upload");
    		ComBtnDisable("btn_cio_file_delete");
    		ComBtnDisable("btn_cin_upload");
    		ComBtnDisable("btn_cin_file_delete");
    		ComBtnDisable("btn_csp_upload");
    		ComBtnDisable("btn_csp_file_delete");
    		
    		ComBtnDisable("btn_pfmc_retrieve");
    		
    		ComBtnDisable("btn_full_row_add");
    		ComBtnDisable("btn_full_row_delete");
    		
    		ComBtnDisable("btn_aer_upload");
    		ComBtnDisable("btn_aer_file_delete");    		
    		ComBtnDisable("btn_aer_row_add");
    		ComBtnDisable("btn_aer_row_delete");
    		
    		ComBtnDisable("btn_lcc_retrieve");
		}
	}
	    
	function initControl() {
//  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- 포커스 나갈때
//  		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form2);
//  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
//  		axon_event.addListenerFormat('focus',	'obj_focus',	document.form2); //- 포커스 들어갈때
//  		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
//  		axon_event.addListenerFormat('keypress','obj_keypress', document.form2); //- 키보드 입력할때
//  		axon_event.addListener('click', 'condType_click', 'cond_type');
//  		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//  		axon_event.addListener('mouseover', 'obj_mouseover', 'txt_remark','btn_CRemark');	// onMouseover 이벤트
//		axon_event.addListener('mouseout', 'obj_mouseout',	 'txt_remark','btn_CRemark');	// onMouseout 이벤트
////		axon_event.addListener('blur', 'sheetobj_blur', 't1sheet1');
  	}
	
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 		 var sheetID = sheetObj.id;
         
         switch(sheetObj.id) {     
//
              case "t1sheet2":      // sheet1 init
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 200;
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

              		// 전체Edit 허용 여부 [선택, Default false]
              		Editable = true;

              		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
              		InitRowInfo(1, 1, 3, 100);

              		var HeadTitle = "|Item|CUR|AMT|Note|";
              		
              		var headCount = ComCountHeadTitle(HeadTitle);
              		
              		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
              		InitColumnInfo(headCount, 0, 0, true);

              		// 해더에서 처리할 수 있는 각종 기능을 설정한다
              		InitHeadMode(true, true, true, true, false, false)

              		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
              		InitHeadRow(0, HeadTitle, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
              		InitDataProperty(0, cnt++, dtHiddenStatus, 	  0, 	daCenter, 	true, 	"ibflag");
              		InitDataProperty(0, cnt++, dtData, 			120,   	daLeft, 	false, 	"aft_bkg_act_cost_itm_nm", 		false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtData, 			 40, 	daCenter, 	false, 	"aft_bkg_act_cost_curr_cd", 	false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtAutoSum, 		 80, 	daRight, 	false, 	"aft_bkg_act_cost_amt", 		false, "", dfNullFloat, 2, true, true);
              		InitDataProperty(0, cnt++, dtData, 		  	 80, 	daLeft, 	false, 	"aft_bkg_act_cost_rmk");
              		InitDataProperty(0, cnt++, dtHidden, 		 80, 	daCenter, 	false, 	"aft_bkg_act_cost_itm_lvl");

  					CountPosition = 0;
                  }
                  
                  break;      
                  
              case "t1sheet1":    
              case "t1sheet3":     
              case "t1sheet5":      
              case "t1sheet7":  
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 80;
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

              		// 전체Edit 허용 여부 [선택, Default false]
              		Editable = true;

              		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
              		InitRowInfo(1, 1, 3, 100);

              		var HeadTitle = "|Sel.|File Name|File Size";
              		
              		var headCount = ComCountHeadTitle(HeadTitle) + 4;
              		
              		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
              		InitColumnInfo(headCount, 0, 0, true);

              		// 해더에서 처리할 수 있는 각종 기능을 설정한다
              		InitHeadMode(true, true, true, true, false, false)

              		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
              		InitHeadRow(0, HeadTitle, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
              		InitDataProperty(0, cnt++, dtHiddenStatus, 	  0, 	daCenter, true, 	"ibflag");
              		InitDataProperty(0, cnt++, dtCheckBox, 		 40, 	daCenter, true, 	"del_chk", 	false, "", dfNone, 0, true, true);
              		InitDataProperty(0, cnt++, dtPopup, 		200,   	  daLeft, false, 	FILE_NM, 		false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtData, 			 50, 	daCenter, false, 	FILE_SIZE, 	false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	FILE_PATH);
              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	FILE_SAV_ID);
              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	FILE_DIV_CD);
              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	RMK_LVL);

                  }
                  
                  break;      

              case "t1sheet6":      // sheet1 init
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 100;
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

              		// 전체Edit 허용 여부 [선택, Default false]
              		Editable = true;

              		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
              		InitRowInfo(1, 1, 3, 100);

              		var HeadTitle = "|BKG No|CNTR|STS|Cargo\nReleasing|Empty CNTR\nReturning";
              		
              		var headCount = ComCountHeadTitle(HeadTitle);
              		
              		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
              		InitColumnInfo(headCount, 0, 0, true);

              		// 해더에서 처리할 수 있는 각종 기능을 설정한다
              		InitHeadMode(true, true, true, true, false, false)

              		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
              		InitHeadRow(0, HeadTitle, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
              		InitDataProperty(0, cnt++, dtHiddenStatus, 	  0, 	daCenter, true, 	"ibflag");
              		InitDataProperty(0, cnt++, dtData, 			90,   	  daCenter, false, 	"bkg_no", 		false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, false, 	"cntr_no", 	false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtData, 		  	30, 	daCenter, false, 	"dmdt_chg_sts_cd", 	false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtData, 		  	70, 	daCenter, false, 	"cgor_dt", 	false, "", dfDateYmd, 0, true, true);
              		InitDataProperty(0, cnt++, dtData, 		  	70, 	daCenter, false, 	"mcntr_rtn_dt", 	false, "", dfDateYmd, 0, true, true);

  					CountPosition = 0;
                  }
                  
                  break;        
                  
              case "t2sheet1":
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 200;
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                      Editable = false;

                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo(2, 1, 7, 100);

  					  var HeadTitle1 = "|Seq|Contract Customer|Contract Customer|POL|POD|DMT Type|Incurred|Exception TTL|Discount|Billable 2|Collected|Collection Ratio|Exception+D/C(RATIO)";
  					  var HeadTitle2 = "|Seq|Code|Name|POL|POD|DMT Type|Incurred|Exception TTL|Discount|Billable 2|Collected|Collection Ratio|Exception+D/C(RATIO)";
                      var headCount = ComCountHeadTitle(HeadTitle1);

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(headCount, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, false, true, false,false)

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle1, true);
                      InitHeadRow(1, HeadTitle2, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
 					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"aft_bkg_perf_rqst_seq");
  					InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,		true,		"cust_cd",				false,	"",		dfNone,		0,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,   		200,	daLeft,			true,		"cust_nm",				false,	"",		dfNone,		0,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,   		50,		daCenter,		true,		"pol_cd",				false,	"",		dfNone,		0,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,   		50,		daCenter,		true,		"pod_cd",				false,	"",		dfNone,		0,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,		true,		"dmdt_trf_cd",			false,	"",		dfNone,		0,	false,	false);
  					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,		true,		"org_chg_amt",			false,	"",		dfNullFloat,		2,	false,	false);
  					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,		true,		"expt_amt",				false,	"",		dfNullFloat,		2,	false,	false);
  					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,		true,		"aft_expt_dc_amt",		false,	"",		dfNullFloat,		2,	false,	false);
  					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,		true,		"bill_amt",				false,	"",		dfNullFloat,		2,	false,	false);
  					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,		true,		"inv_pay_amt",			false,	"",		dfNullFloat,		2,	false,	false);
  					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,		true,		"coll_rt",				false,	"",		dfNullFloat,		2,	false,	false);
  					InitDataProperty(0, cnt++ , dtAutoSum,  		100,	daRight,		true,		"expt_dc_rt",			false,	"",		dfNullFloat,		2,	false,	false);
  			}
  			break;

              case "t2sheet2":
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 150;
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                      Editable = false;

                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo(2, 1, 7, 100);

  					  var HeadTitle1 = "|Seq|Contract Customer|Contract Customer|Load|CM|CMPB";
  					  var HeadTitle2 = "|Seq|Code|Name|Load|CM|CMPB";
                      var headCount = ComCountHeadTitle(HeadTitle1);

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(headCount, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, false, true, false,false)

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle1, true);
                      InitHeadRow(1, HeadTitle2, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
 					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"aft_bkg_mas_rqst_seq");
  					InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,		true,		"cust_cd",				false,	"",		dfNone,				0,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,   		200,	daLeft,			true,		"cust_nm",				false,	"",		dfNone,				0,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,  		100,	daRight,		true,		"lod_qty",				false,	"",		dfNullFloat,		2,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,  		100,	daRight,		true,		"cm_amt",				false,	"",		dfNullFloat,		2,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,  		100,	daRight,		true,		"cmpb_amt",				false,	"",		dfNullFloat,		2,	false,	false);
  			}
  			break;

              case "t3sheet1":
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 200;
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                      Editable = true;

                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo(1, 1, 7, 100);

  					var HeadTitle1 = "||Date|Your Action|Customer's Reaction|";
                      var headCount = ComCountHeadTitle(HeadTitle1);

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(headCount, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, false, true, false,false)

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle1, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
              		InitDataProperty(0, cnt++, dtCheckBox, 		 40, 	daCenter, 		false, 		"del_chk", 						false,  "", 	dfNone, 	0, 	true, 	true);
  					InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,		false,		"aft_cust_ans_dt",				false,	"",		dfDateYmd,	0,	false,	true);
  					InitDataProperty(0, cnt++ , dtData,   		400,	daLeft,			false,		"usr_act_rmk",					false,	"",		dfNone,		0,	true,	true);
  					InitDataProperty(0, cnt++ , dtData,   		400,	daLeft,			false,		"cust_ans_rmk",					false,	"",		dfNone,		0,	true,	true);
  					InitDataProperty(0, cnt++ , dtHidden,   	  0,	daCenter,		false,		"aft_bkg_full_his_rqst_seq",	false,	"",		dfNone,		0,	false,	false);

  			}
  			break;

              case "t4sheet1": 
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 130;
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msAll;

                     //전체Edit 허용 여부 [선택, Default false]
                      Editable = true;

                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo(1, 1, 10, 100);

                      var HeadTitle1 = "|Seq.|Sel.|Reason|Specific Reason|Rsn. Code";
 					//var headCount = ComCountHeadTitle(HeadTitle1);

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(12, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(false, true, false, true, false, false);

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle1, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
 					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	false,	"seq");
 					InitDataProperty(0, cnt++ , dtRadioCheck,	30,		daCenter,	false,	"chk",				false,	"",	dfNone, 0,	true,	true);
 					InitDataProperty(0, cnt++ , dtData,    	   300,		daLeft,		true,	"rsn_desc",			false,	"",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtData,    	   500,		daLeft,		false,	"spec_rsn_desc",	false,	"",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtData,   	    45,		daCenter,	false,	"spec_rsn_cd",		false,	"",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,	false,	"rsn_bt_cd",			false,	"",	dfNone, 0,	false,	true);
 					InitDataProperty(0, cnt++ , dtHidden,   	 0,		daCenter,	false,	"rsn_desc_flg",	false,	"",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,   	 0,		daCenter,	false,	"rsn_file_flg",	false,	"",	dfNone,	0,	false,  false);
 					
 					InitDataProperty(0, cnt++ , dtHidden,   	 0,		daCenter,	false,	"file_lvl_nm",	false,	"",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,   	 0,		daCenter,	false,	"file_lvl_value",	false,	"",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,   	 0,		daCenter,	false,	"dtl_rmk",	false,	"",	dfNone,	0,	false,  false);
 					
 					CountPosition = 0;
              	 }
                  break;


              case "t4sheet2":
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 80;
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

              		// 전체Edit 허용 여부 [선택, Default false]
              		Editable = true;

              		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
              		InitRowInfo(1, 1, 4, 100);

              		var HeadTitle = "|Sel.|Attachment Kind|File Name|File Size";
              		
              		var headCount = ComCountHeadTitle(HeadTitle) + 3;
              		
              		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
              		InitColumnInfo(headCount, 0, 0, true);

              		// 해더에서 처리할 수 있는 각종 기능을 설정한다
              		InitHeadMode(true, true, true, true, false, false)

              		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
              		InitHeadRow(0, HeadTitle, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
              		InitDataProperty(0, cnt++, dtHiddenStatus, 	  0, 	daCenter, true, 	"ibflag");
              		InitDataProperty(0, cnt++, dtCheckBox, 		 40, 	daCenter, true, 	"del_chk", 		false, "", dfNone, 0, true, true);
              		InitDataProperty(0, cnt++, dtCombo, 		150,   	daCenter, false, 	RMK_LVL, 	false, "", dfNone, 0, false, true);
              		InitDataProperty(0, cnt++, dtPopup, 		200,   	  daLeft, false, 	FILE_NM, 		false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtData, 			 50, 	daCenter, false, 	FILE_SIZE, 		false, "", dfNone, 0, false, false);
              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	FILE_PATH);
              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	FILE_SAV_ID);
              		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	FILE_DIV_CD);
              		
              		InitDataCombo(0,RMK_LVL,"","");
                  }
                  
                  break;      

              case "t4sheet3":  
                  with (sheetObj) {
                      // 높이 설정
                      style.height = 120;
                
                      // 전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msNone;

                     //전체Edit 허용 여부 [선택, Default false]
                      Editable = true;

                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo( 1, 1, 2, 100);

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(22, 0, 0, true);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, true, true, false,false)

                      var HeadTitle  = "||Seq.|1|2|3|4|5|6|7|8|9|10|1|2|3|4|5|6|7|8|9";

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle, true);

                      //데이터속성    [ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"ibflag");
               		InitDataProperty(0, cnt++, dtCheckBox, 		 40, 	daCenter, true, 	"del_chk", 	false, "", dfNone, 0, true, true);
 					InitDataProperty(0, cnt++ , dtSeq, 	  		30,		daCenter,		false,		"Seq");
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_1_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_2_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_3_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_4_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_5_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_6_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_7_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_8_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_9_type",		false,  "",	dfNone,	0,	true,  true);
 					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"detail_10_type",		false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_1",			false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_2",			false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_3",			false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_4",			false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_5",			false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_6",			false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_7",			false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_8",			false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"popup_code_9",			false,  "",	dfNone,	0,	false,  false);

              }
                break;
                


              case "t5sheet1":  
                  with (sheetObj) {
                      // 높이 설정
//                      style.height = 500;
                
                      // 전체 너비 설정
                      SheetWidth = 950;
//                      SheetHeight = 500;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msAll;

                     //전체Edit 허용 여부 [선택, Default false]
                      Editable = true;

                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo(1, 1, 23);

                      var HeadTitle1  = "|Review\nItem|Formular|Value #1|Value #2|Result|";

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(7, 0, 0, false);

                      // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                      InitHeadMode(false, false, false, false, false, false);
                      
                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle1, true);

                      //데이터속성    [ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"ibflag");
 					InitDataProperty(0, cnt++ , dtData,			180,		daCenter,	true,	"rvw_itm",				false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtData,			180,		daCenter,	true,	"foml_nm",				false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtData,			180,		daCenter,	true,	"value_1",				false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtData,			180,		daCenter,	true,	"value_2",				false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtImage,		180,		daCenter,	true,	"value_image_3",		false,  "",	dfNone,	0,	false,  false);
 					InitDataProperty(0, cnt++ , dtHidden,		180,		daCenter,	true,	"value_3",				false,  "",	dfNone,	0,	false,  false);
 					
 					ImageList(0) = "img/btng_icon_green.gif";
 					ImageList(1) = "img/btng_icon_y.gif";
 					ImageList(2) = "img/btng_icon_r.gif";
              
              }
                break;
         }
     }
    

    function save_click() {
    	var _frameDoc  = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
		var btnSaveObj = _frameDoc.getElementById("btn_apply");
		btnSaveObj.detachEvent('onclick', eval('save_click'));
		
		doActionIBSheet(sheetObjects[0], document.form, IBSAVE_CORRRMK);
    }

    
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
 			case IBSEARCH_ACTCOST:      // Actual Cost Retrive
 				if(!validateForm(sheetObj,formObj,sAction)) return;
        	
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
 				formObj.f_cmd.value = SEARCH01;

 				var opener = window.dialogArguments;
 				var opnSheetObj = opener.sheetObjects[0];
 				
				var sParam = ComSetPrifix(opnSheetObj.GetSaveString(true), "opnSheetObj");
				sParam += "&" + FormQueryString(formObj);
 		 		
 				var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", sParam);

				var arrXml = sXml.split("|$$|");

				/* Customer's Request Letter */
				sheetObjects[1].LoadSearchXml(arrXml[0]);
				/* FILE */
				sheetObjects[0].LoadSearchXml(arrXml[1]);
				
				sheetObjects[2].LoadSearchXml(arrXml[2]);
				
				sheetObjects[3].LoadSearchXml(arrXml[3]);
				//sheetObjects[4].LoadSearchXml(arrXml[4]);
				
				/* Expected Clearance Date (STS L) */
				sheetObjects[4].LoadSearchXml(arrXml[5]);

				sheetObjects[5].LoadSearchXml(arrXml[6]);

				var rsn_dc_rqst = ComGetEtcData(arrXml[0], "RSN_DC_RQST");
				if(rsn_dc_rqst == null || rsn_dc_rqst == "" || rsn_dc_rqst == undefined) {
					formObj.rsn_dc_rqst.value = "";
				} else {
					formObj.rsn_dc_rqst.value = rsn_dc_rqst;
				}
				
				var rsn_cle_delay = ComGetEtcData(arrXml[0], "RSN_CLE_DELAY");
				if(rsn_cle_delay == null || rsn_cle_delay == "" || rsn_cle_delay == undefined) {
					formObj.rsn_cle_delay.value = "";
				} else {
					formObj.rsn_cle_delay.value = rsn_cle_delay;
				}
				
				var ucCgoPsblFlg = ComGetEtcData(arrXml[0], "UC_CGO_PSBL_FLG");
				formObj.uc_cgo_psbl_flg.value = ucCgoPsblFlg;
				
				if ( ucCgoPsblFlg == "Y" ){
					formObj.ucCgoPsblFlg1.checked = true;
				} else if ( ucCgoPsblFlg == "N" ){
					formObj.ucCgoPsblFlg2.checked = true;					
				}
				
				var gnteLtrCd = ComGetEtcData(arrXml[0], "GNTE_LTR_CD");
				formObj.gnte_ltr_cd.value = gnteLtrCd;
				
				if ( gnteLtrCd == "P" ){
					formObj.gnteLtrCd_P.checked = true;
				} else if ( gnteLtrCd == "V" ){
					formObj.gnteLtrCd_V.checked = true;					
				} else if ( gnteLtrCd == "B" ){
					formObj.gnteLtrCd_P.checked = true;
					formObj.gnteLtrCd_V.checked = true;					
				}
				
 				ComOpenWait(false);
 				break;
 				
 			case IBSEARCH_FULLHIS:
				if(!validateForm(sheetObj,formObj,sAction)) return;
    	
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));
	
				sheetObjects[8].LoadSearchXml(sXml);
				
				ComOpenWait(false);
				
 				break;
 				
 			case IBSEARCH_ADDRSN:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
    	
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH04;
				var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));

				var arrXml = sXml.split("|$$|");				
				
				retrieve_flg = "Y";

				/* Requst Detail */
				sheetObjects[9].LoadSearchXml(arrXml[0]);
				
				/* Attached File */
				sheetObjects[10].LoadSearchXml(arrXml[1]);
				/* Requst Detail Remark */
				sheetObjects[11].LoadSearchXml(arrXml[2]);

				if ( sheetObjects[11].RowCount == 0 ){
					sheetObjects[11].DataInsert(-1);
				}

				var spec_rsn_cd = ComGetEtcData(arrXml[0], "SPEC_RSN_CD");
				//Inactivation Specific Reason View 	
				for (var i=1; i<sheetObjects[9].RowCount+1; i++) {
					if (sheetObjects[9].CellValue(i, "spec_rsn_cd") == spec_rsn_cd) {
						sheetObjects[9].CellValue(i, "chk") = "1";
						sheetObjects[9].SelectCell(i, 0, false);
						break;
					}
				}
				retrieve_flg = "N";
				
				ComOpenWait(false);
				
 				break;

            case IBSEARCH_DETAIL:      //조회
            	ComSetObjValue(formObj.f_cmd, SEARCH05);
            	
            	var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));
            	
            	var nDtlRsnMdtRows = 0;
				//4.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
            	for (var i=REASON_DETAIL_START; i<=REASON_DETAIL_END; i++) {
            		
            		var prefix = "detail_" + i;

            		var rsnFieldName   = prefix + "_rsn_field_name";
            		var rsnFieldType   = prefix + "_rsn_field_type";
            		var rsnFieldSize   = prefix + "_rsn_field_size";
            		var rsnFieldFormat = prefix + "_rsn_field_format";
            		var rsnFieldItem   = prefix + "_rsn_field_item";
            		var rsnFieldCond   = prefix + "_rsn_field_cond";
            		var rsnFieldPopup  = prefix + "_rsn_field_popup";
            		var rsnFieldValue  = prefix + "_rsn_field_value";

            		var fieldName   = ComGetEtcData(sXml, rsnFieldName);
					var fieldType   = ComGetEtcData(sXml, rsnFieldType);
					var fieldSize   = ComGetEtcData(sXml, rsnFieldSize);
					var fieldFormat = ComGetEtcData(sXml, rsnFieldFormat);
					var fieldItem   = ComGetEtcData(sXml, rsnFieldItem);
					var fieldCond   = ComGetEtcData(sXml, rsnFieldCond);
					var fieldPopup  = ComGetEtcData(sXml, rsnFieldPopup);
					var fieldValue  = ComGetEtcData(sXml, rsnFieldValue);

					if (typeof(fieldName) != 'undefined') {
						nDtlRsnMdtRows++;

						ComSetObjValue(eval("formObj.h_" + rsnFieldName),   fieldName);
						ComSetObjValue(eval("formObj.h_" + rsnFieldType),   fieldType);
						ComSetObjValue(eval("formObj.h_" + rsnFieldSize),   fieldSize);
						ComSetObjValue(eval("formObj.h_" + rsnFieldFormat), fieldFormat);
						ComSetObjValue(eval("formObj.h_" + rsnFieldItem),   fieldItem);
						ComSetObjValue(eval("formObj.h_" + rsnFieldCond),   fieldCond);
						ComSetObjValue(eval("formObj.h_" + rsnFieldPopup),  fieldPopup);
						ComSetObjValue(eval("formObj.h_" + rsnFieldValue),  fieldValue);
					}
					else {
						ComSetObjValue(eval("formObj.h_" + rsnFieldName),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldType),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldSize),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldFormat), "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldItem),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldCond),   "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldPopup),  "");
						ComSetObjValue(eval("formObj.h_" + rsnFieldValue),  "");
					}
	            	
            	}
//            	ComSetObjValue(formObj.h_detail_rsn_mandatory_rows, nDtlRsnMdtRows);
 			break; 			
 				
 			case IBSEARCH_PFMC:
				if(!validateForm(sheetObj,formObj,sAction)) return;
    	
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));
	
				sheetObj.LoadSearchXml(sXml);
				
				ComOpenWait(false);
				
 				break;
 				
	
 				
 			case IBSEARCH_LCC_MAS:
				if(!validateForm(sheetObj,formObj,sAction)) return;
    	
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH09;
				var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));
	
				sheetObj.LoadSearchXml(sXml);
				
				ComOpenWait(false);
				
 				break;
 			
 			case IBSAVE:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = MULTI;
				
				var gnteLtrCd = "";
				
				if ( formObj.gnteLtrCd_P.checked && formObj.gnteLtrCd_V.checked ){
					gnteLtrCd = "B";
				} else if ( formObj.gnteLtrCd_P.checked ){
					gnteLtrCd = "P";			
				} else if ( formObj.gnteLtrCd_V.checked ){
					gnteLtrCd = "V";						
				}
				
				formObj.gnte_ltr_cd.value = gnteLtrCd;

				var sParam = doActionParam();
								
	            sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
	        	// 2.저장조건으로 저장실행
	        	var sXml = sheetObj.GetSaveXml("EES_DMT_2017GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);	  

				if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S" ){
	        		retrieve_flg = "Y";
				}
				ComOpenWait(false);
				
 				break;
 				
 			case IBSAVE_FILEUPLOAD:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = MULTI;

				var sParam = doActionParam();
				
				ComOpenWait(true);

				// 2.저장조건으로 저장실행
				var uploadObj = uploadObjects[0];
				uploadObj.ExtendParam = sParam; // param값 추가
				uploadObj.ParamDecoding = true;
				var sXml = uploadObj.DoUpload(true);
				sheetObj.LoadSaveXml(sXml);

				if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S" ){
	        		retrieve_flg = "Y";
				}
				ComOpenWait(false);
				
 				break;
 				
 			case IBSEARCH_ITEM :

				if(!validateForm(sheetObj,formObj,sAction)) return;
    	
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH06;
				var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));
	
				sheetObjects[12].LoadSearchXml(sXml);
				
				ComOpenWait(false);
				
 				break;

 			case IBSEARCH_RSNVAL :

				if(!validateForm(sheetObj,formObj,sAction)) return;
    	
	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH07;
				var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));
	
				var uclm_flg 	= ComGetEtcData(sXml, "UCLM_FLG");
				var ttl_inv_no 	= ComGetEtcData(sXml, "TTL_INV_NO");
				var bkg_sts_cd 	= ComGetEtcData(sXml, "BKG_STS_CD");
				
		    	if ( spec_rsn_cd_1 == "CGOSHB"){
		    		sheetObjects[11].CellValue2(spec_rsn_row,"detail_2_type") = bkg_sts_cd;
		    	}
		    	
				ComOpenWait(false);
				
 				break;

 			case IBSEARCH_UCTTL :
				if(!validateForm(sheetObj,formObj,sAction)) return;

	 			sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
				formObj.f_cmd.value = SEARCH08;
				var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));

				sheetObjects[11].LoadSearchXml(sXml);

				ComOpenWait(false);
				
 				break;
 				

	         case IBSEARCH_VVD:
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, SEARCH10); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_2017GS.do", FormQueryString(formObj));

	        	 //3.조회후 결과처리
        		 var dmdt_inv_flg = ComGetEtcData(sXml, "VVD_FLG");
        		 if ( dmdt_inv_flg == "" ){
        			 ComShowCodeMessage('DMT03028', "VVD");
        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
        		 }
	        	 
	         break;
         
	    	//Location 을 조회한다.
	    	case IBSEARCH_LOC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, COMMAND07);

				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************

				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************

				//3.조회후 결과처리
				var locCd = ComGetEtcData(sXml, "LOC_CD");
				
        		 if ( locCd == "" ){
        			 ComShowCodeMessage('DMT03028', "Prot Code");
        			 sheetObj.CellValue2(spec_rsn_cd_row,spec_rsn_cd_col) = '';
        		 }
				break;
 				
         }
	}
	
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	  
    	  with(formObj){
    		  
        	 switch(sAction) {
        	 	case IBSAVE:
        	 	case IBSAVE_FILEUPLOAD:

        	 		var sheetObjFullHis   = sheetObjects[8]; 
        	 		var sheetObjRsnHD     = sheetObjects[9]; 
        	 		var sheetObjRsnFile   = sheetObjects[10]; 
        	 		var sheetObjRsnDetail = sheetObjects[11]; 

        	 		for (var i=1;i<sheetObjFullHis.rowcount+1; i++) {
    	 				if ( sheetObjFullHis.RowStatus(i) != "D"){
    	 					if ( ComTrim(sheetObjFullHis.CellText(i,"aft_cust_ans_dt")) == "" ){
    	 						ComShowCodeMessage("DMT05014", "Full History Date");
           			    		return false;
           	 				}
    	 					if ( ComTrim(sheetObjFullHis.CellText(i,"usr_act_rmk")) == "" && ComTrim(sheetObjFullHis.CellText(i,"cust_ans_rmk")) == "" ){
    	 						ComShowCodeMessage("DMT05014", "Full History Your Action or Customer's Reaction");
           			    		return false;
           	 				}
       	 				}
        	 		}
        	 		
        	 		for (var i=1;i<sheetObjRsnFile.rowcount+1; i++) {
    	 				if ( ComTrim(sheetObjRsnFile.CellText(i,RMK_LVL)) == "" && sheetObjRsnFile.RowStatus(i) == "I"){
       			    		alert("Please select Attachment Kind.");
       			    		return false;
       	 				}
        	 		}

        	 		switch(spec_rsn_cd_1) {
        	 			case "VSLACC":
        	 				if ( sheetObjRsnFile.RowCount == 0 
        	 				     && ( ComTrim(sheetObjRsnDetail.CellValue(1,"detail_1_type")) == "" ||  ComTrim(sheetObjRsnDetail.CellValue(1,"detail_2_type")) == ""  )){
        			    		ComShowCodeMessage("DMT05014", "Mandatory item");
        			    		return false;
        	 				}
        	 				if ( ComTrim(sheetObjRsnDetail.CellValue(1,"detail_3_type")) =="" ){
           			    		ComShowCodeMessage("DMT05014", "Mandatory item(report of the accident)");
           			    		return false;
           	 				}
        	 				break;
        	 			case "VSLOTH":
        	 				if ( sheetObjRsnFile.RowCount == 0 && ComTrim(sheetObjRsnDetail.CellValue(1,"detail_1_type")) == "" ){
        			    		ComShowCodeMessage("DMT05014", "Mandatory item");
        			    		return false;
        	 				}
        	 				break;
        	 			case "CGOSHB":        	 			 	
        	 		    	for (var j=1;j<sheetObjRsnDetail.rowcount+1; j++) {
	        	 				if ( ComTrim(sheetObjRsnDetail.CellValue(j,"detail_1_type")) == "" ){
	        			    		ComShowCodeMessage("DMT05014", "Mandatory item");
	        			    		return false;
	        	 				}
	        	 				if ( ComTrim(sheetObjRsnDetail.CellValue(j,"detail_2_type")) != "F" ){
	        			    		ComShowCodeMessage("DMT03028", "Cancelled BKG or Advanced BKG or Waiting BKG");
	        			    		return false;
	        	 				}        	
        	 		    	}
        	 				break;
        	 			case "UCOTT1":
        	 			case "UCOTT2":
        	 			case "UCOTT3":
        	 			case "UCOTT4":
        	 			case "UCOTT5":
        	 			case "UCOTT6":
        	 			case "UCOTT7":
        	 			case "UCOTT8":
        	 			case "UCOTT9":
        	 			case "UCOTTA":
        	 			case "UCOTTB":
        	 		    	for (var j=1;j<sheetObjRsnDetail.rowcount+1; j++) {
	        	 				if ( ComTrim(sheetObjRsnDetail.CellValue(j,"detail_3_type")) != "Y" && ComTrim(sheetObjRsnDetail.CellValue(j,"detail_4_type")) == "" ){
	        			    		ComShowCodeMessage("DMT03028", "UC Flag or TTL nbr");
	        			    		return false;
	        	 				}
//	        	 				if ( ComTrim(sheetObjRsnDetail.CellValue(j,"detail_4_type")) == "" ){
//	        			    		ComShowCodeMessage("DMT03028", "TTL nbr");
//	        			    		return false;
//	        	 				}
        	 		    	}
        	 				if ( sheetObjRsnFile.RowCount == 0 ){
        	 					ComShowCodeMessage("DMT05014", "Optional (at least one should be attached)");
        			    		return false;
        	 				}
        	 				break;
        	 			case "CNTISS":
        	 			case "CSRSLS":
        	 			case "OTHERS":
        	 				if ( sheetObjRsnFile.RowCount == 0 ){
        			    		ComShowCodeMessage("DMT05014", "Mandatory item");
        			    		return false;
        	 				}
        	 				break;
        	 			case "CUSTOM":
        	 			case "CSRGVM":
        	 			case "EXTDLY":
        	 				if ( sheetObjRsnFile.RowCount == 0 ){
        			    		ComShowCodeMessage("DMT05014", "Optional (at least one should be attached)");
        			    		return false;
        	 				}
        	 				break;
        	 			case "TRMNAL":
        	 			case "LCLPRT":
        	 				if ( sheetObjRsnFile.RowCount == 0 && ComTrim(sheetObjRsnDetail.CellValue(j,"detail_1_type")) == ""){
        			    		ComShowCodeMessage("DMT05014", "Optional (at least one should be inputted or attached)");
        			    		return false;
        	 				}
        	 				break;
        	 			case "INTSTF":
        	 			case "INTOPR":
        	 				if ( sheetObjRsnFile.RowCount == 0 && ComTrim(sheetObjRsnDetail.CellValue(j,"detail_1_type")) == ""){
        			    		ComShowCodeMessage("DMT05014", "Mandatory item");
        			    		return false;
        	 				}
        	 				break;
        	 			case "PLTISS":
        	 				if ( sheetObjRsnFile.RowCount == 0 ){
        	 					ComShowCodeMessage("DMT05014", "Mandatory item");
        			    		return false;
        	 				}
        	 				var cnt_1 = 0;
        	 				var cnt_2 = 0;
        	 				var cnt_3 = 0;
        	 				
        	 				for (var j=1;j<sheetObjRsnFile.rowcount+1; j++) {
        	 					if ( ComTrim(sheetObjRsnDetail.CellText(j,RMK_LVL)) != "official letter of authority/regulation" ){
        	 						cnt_1 = cnt_1 + 1;
               	 				}
        	 					if ( ComTrim(sheetObjRsnDetail.CellText(j,RMK_LVL)) != "news report of the situation" ){
        	 						cnt_2 = cnt_2 + 1;
               	 				}
        	 					if ( ComTrim(sheetObjRsnDetail.CellText(j,RMK_LVL)) != "other liners' discount status" ){
        	 						cnt_3 = cnt_3 + 1;
               	 				}
        	 				}
    	 					if ( cnt_1 != 0 && cnt_2 != 0 && cnt_3 != 0  ){
    	 						ComShowCodeMessage("DMT05014", "Mandatory item");
           			    		return false;
           	 				}
        	 				break;
        	 			case "NTRDST":
        	 				var cnt_1 = 0;
        	 				var cnt_2 = 0;
        	 				
        	 				for (var j=1;j<sheetObjRsnFile.rowcount+1; j++) {
        	 					if ( ComTrim(sheetObjRsnDetail.CellText(j,RMK_LVL)) != "report of the situation" ){
        	 						cnt_1 = cnt_1 + 1;
               	 				}
        	 					if ( ComTrim(sheetObjRsnDetail.CellText(j,RMK_LVL)) != "other liners' policy" ){
        	 						cnt_2 = cnt_2 + 1;
               	 				}
        	 				}
    	 					if ( ( cnt_1 != 0 || ComTrim(sheetObjRsnDetail.CellValue(j,"detail_1_type")) != "" ) 
    	 							&& ( cnt_2 != 0 && ComTrim(sheetObjRsnDetail.CellValue(j,"detail_2_type")) != "")  ){
    	 						ComShowCodeMessage("DMT05014", "Mandatory item");
           			    		return false;
           	 				}
        	 				break;        	 				

        	 			case "CGOPRH":
        	 			case "CGOABD":
        	 			case "CGOOTH":
        	 			case "SHPCNE":
        	 			case "TRFISS":
        	 			case "OTHERS":
        	 			case "PRTAGM":
        	 				if ( sheetObjRsnFile.RowCount == 0 && ComTrim(sheetObjRsnDetail.CellValue(j,"detail_1_type")) == ""){
        	 					ComShowCodeMessage("DMT05014", "Optional (at least one should be attached)");
        			    		return false;
        	 				}
        	 				break;
        	 		}
        	 		
        	 		if ( formObj.rqst_flg.value != "Y" ){

        	            var col_1 = 0;
        	            var col_2 = 0;
        	            
        	            switch(formObj.apvl_path_cd.value) {
        	            	case "BBOPIC":
        	            		col_1 = 5;
        	            		col_2 = 6;
        	            		break;
        	            	case "BBGMGR": 
        	            		col_1 = 7;
        	            		col_2 = 8;      		
        	            		break;
        	            	case "RHQPIC":	 
        	            		col_1 = 9;
        	            		col_2 = 10;           		
        	            		break;
        	            	case "RHQMGR":	 
        	            		col_1 = 11;
        	            		col_2 = 12;           		
        	            		break;
        	            	case "HDOPIC":	  
        	            		col_1 = 13;
        	            		col_2 = 14;          		
        	            		break;
        	            	case "HDOMGR":
        	            		col_1 = 15;
        	            		col_2 = 16;	            		
        	            		break;
        	            }
	        	            
        	            if ( col_1 != 0 ){
        		            if ( sheetObjects[12].CellValue(3,col_1) == "" ){
        	        			ComShowCodeMessage("DMT00171", "Approval Detail (CM)");
        	        			return false;
        		            }
        		            else if ( sheetObjects[12].CellValue(3,col_1) == "R" || sheetObjects[12].CellValue(3,col_1) == "O" ){
        		            	if ( ComTrim(sheetObjects[12].CellValue(3,col_2)) == "" ){
	        	        			ComShowCodeMessage("DMT00171", "Approval Detail (CM)");
	        	        			return false;
        		            	}
        		            }
        		            
        		            if ( sheetObjects[12].CellValue(5,col_1) == "" ){
        	        			ComShowCodeMessage("DMT00171", "Approval Detail (Cost)");
        	        			return false;
        		            }
        		            else if ( sheetObjects[12].CellValue(5,col_1) == "R" || sheetObjects[12].CellValue(5,col_1) == "O" ){
        		            	if ( ComTrim(sheetObjects[12].CellValue(5,col_2)) == "" ){
	        	        			ComShowCodeMessage("DMT00171", "Approval Detail (Cost)");
	        	        			return false;
        		            	}
        		            }
        		            
        		            if ( sheetObjects[12].CellValue(7,col_1) == "" ){
        	        			ComShowCodeMessage("DMT00171", "Approval Detail (Exception)");
        	        			return false;
        		            }
        		            else if ( sheetObjects[12].CellValue(7,col_1) == "R" || sheetObjects[12].CellValue(7,col_1) == "O" ){
        		            	if ( ComTrim(sheetObjects[12].CellValue(7,col_2)) == "" ){
	        	        			ComShowCodeMessage("DMT00171", "Approval Detail (Exception)");
	        	        			return false;
        		            	}
        		            }

        		            if ( sheetObjects[12].CellValue(9,col_1) == "" ){
        	        			ComShowCodeMessage("DMT00171", "Approval Detail (L/S, U/C Possibility)");
        	        			return false;
        		            }
        		            else if ( sheetObjects[12].CellValue(9,col_1) == "R" || sheetObjects[12].CellValue(9,col_1) == "O" ){
        		            	if ( ComTrim(sheetObjects[12].CellValue(9,col_2)) == "" ){
	        	        			ComShowCodeMessage("DMT00171", "Approval Detail (L/S, U/C Possibility)");
	        	        			return false;
        		            	}
        		            }

        		            if ( sheetObjects[12].CellValue(10,col_1) == "" ){
        	        			ComShowCodeMessage("DMT00171", "Approval Detail (DEST, ORG office's efforts for colledtion)");
        	        			return false;
        		            }
        		            else if ( sheetObjects[12].CellValue(10,col_1) == "R" || sheetObjects[12].CellValue(10,col_1) == "O" ){
        		            	if ( ComTrim(sheetObjects[12].CellValue(10,col_2)) == "" ){
	        	        			ComShowCodeMessage("DMT00171", "Approval Detail (DEST, ORG office's efforts for colledtion)");
	        	        			return false;
        		            	}
        		            }

        		            if ( sheetObjects[12].CellValue(12,col_1) == "" ){
        	        			ComShowCodeMessage("DMT00171", "Approval Detail (DEM/DET collection Performance)");
        	        			return false;
        		            }
        		            else if ( sheetObjects[12].CellValue(12,col_1) == "R" || sheetObjects[12].CellValue(12,col_1) == "O" ){
        		            	if ( ComTrim(sheetObjects[12].CellValue(12,col_2)) == "" ){
	        	        			ComShowCodeMessage("DMT00171", "Approval Detail (DEM/DET collection Performance)");
	        	        			return false;
        		            	}
        		            }

        		            if ( sheetObjects[12].CellValue(14,col_1) == "" ){
        	        			ComShowCodeMessage("DMT00171", "Approval Detail (DEM/DET DC or Waive PFMC)");
        	        			return false;
        		            }
        		            else if ( sheetObjects[12].CellValue(14,col_1) == "R" || sheetObjects[12].CellValue(14,col_1) == "O" ){
        		            	if ( ComTrim(sheetObjects[12].CellValue(14,col_2)) == "" ){
	        	        			ComShowCodeMessage("DMT00171", "Approval Detail (DEM/DET DC or Waive PFMC)");
	        	        			return false;
        		            	}
        		            }
        		            
        	            }
                    }
        	 		
        	 		break;
        	 		
        	 } // swith - end
    	  } // with - end
    	  
    	  return true;
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

                     tabObj.ImageUrl(0)="http://"+location.host+"/hanjin/img/ico_star.gif";
                     
                     InsertTab( cnt++ , "Evidence" , -1 );
                     InsertTab( cnt++ , "DMT PFMC" , 0 );
                     InsertTab( cnt++ , "Full History" , 0 );
                     InsertTab( cnt++ , "Additional Evidence_Reason" , 0 );
                     InsertTab( cnt++ , "Approval" , -1 );
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
      * 파일을 업로드해준다.
      */
     function doActionFileUpload(fileCode) {

 		var upObj = uploadObjects[0];
 		
    	 if ( fileCode == 'CSRL01'){
 	   		var sheetObj = sheetObjects[0];  
 	    } 
    	else if ( fileCode == 'CINW01' ){
 	   		var sheetObj = sheetObjects[3];    		 
 	    } 
    	else if ( fileCode == 'OAIN01' ){
 	   		var sheetObj = sheetObjects[2];    		 
 	    } 
    	else if ( fileCode == 'AER' ){
 	   		var sheetObj = sheetObjects[10];    		 
 	    } 
    	else if ( fileCode == 'LETT01' ){
 	   		var sheetObj = sheetObjects[5];    		 
 	    }     
    	 
    	 var fileName = sheetObj.OpenFileDialog("");
 		
 		// 파일대화상자에서 선택한 파일이 없을 경우 종료
 		if (fileName.indexOf(FILE_SELECT_CANCEL) != -1) {
 			return;
 		}

    	ComOpenWait(true);
    	
 		// 행이 없는 경우..
		var Row = sheetObj.DataInsert(-1, 0);// File Add인 경우 New Row 생성
		
		sheetObj.CellValue2(Row, "ibflag") = "I";

 		if (fileName.indexOf("\\") != -1) {
 			
 			sheetObj.CellValue2(Row, FILE_PATH) = fileName;

			upObj.Files = "";

			var ret = upObj.AddFile(fileName);
			
 			var fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
 			sheetObj.CellValue2(Row, FILE_NM) = fileName;

 			if ( fileCode == 'AER' ){
 				sheetObj.CellValue2(Row, FILE_DIV_CD) = sheetObjects[9].CellValue(oldRow, 'spec_rsn_cd');
 			} else {
 				sheetObj.CellValue2(Row, FILE_DIV_CD) = fileCode;
 			}

			upObj.ExtendParam = "f_cmd=" + COMMAND01;			
			var sXml = upObj.DoUpload(true);
			
			var fileSaveId = ComGetEtcData(sXml, "fileSaveId");
		
 			sheetObj.CellValue2(Row, FILE_SAV_ID) = fileSaveId;
 		} 		
    	ComOpenWait(false);
     }
     

     /**
      * 파일을 삭제해준다. <br>
      */
	function doActionFileDelete(fileCode) {

	   	if ( fileCode == 'CSRL01'){
	   		var sheetObj = sheetObjects[0];  
	    } 
	   	else if ( fileCode == 'CINW01' ){
	   		var sheetObj = sheetObjects[3];    		 
	    } 
	   	else if ( fileCode == 'OAIN01' ){
	   		var sheetObj = sheetObjects[2];    		 
	    } 
	   	else if ( fileCode == 'AER' ){
 	   		var sheetObj = sheetObjects[10];    		 
 	    } 
	   	else if ( fileCode == 'LETT01' ){
 	   		var sheetObj = sheetObjects[5];    		 
 	    }  
		
		if (sheetObj.FindCheckedRow("del_chk") != "") {
			
			var sRow = sheetObj.FindCheckedRow("del_chk");
//			sheetObj.CellValue2(sRow, "ibflag") = "D";			
//			ComRowHideDelete(sheetObj, "del_chk");

			//가져온 행을 배열로 반든다.
			var arrRow = sRow.split("|");
			for (var idx = arrRow.length-2; idx>=0; idx--){				
				if ( sheetObj.RowStatus(arrRow[idx]) == "I" ) {
					sheetObj.RowStatus(arrRow[idx]) = "D";
				} else {
					sheetObj.RowStatus(arrRow[idx]) = "D";
					sheetObj.RowHidden(arrRow[idx]) = true;
				}
			}
		} 
		else {
			alert("No Selected Row");
			//ComShowCodeMessage("BKG00249");// "No Selected Row";
		}
	}     

	

 	 function doActionRowAdd(sheetCode){

 		var formObj 	= document.form;
 		
 		if ( sheetCode == "FULL"){
 			var sheetObj = sheetObjects[8];  
 		} else if ( sheetCode == "AER"){
 			var sheetObj = sheetObjects[11];   			
 		}
 		
		var rowNo = sheetObj.DataInsert(-1);
		
 	 }
 	 
 	 function doActionRowDelete(sheetCode){
  		var formObj 	= document.form;

 		if ( sheetCode == "FULL"){
 			var sheetObj = sheetObjects[8];  
 		} else if ( sheetCode == "AER"){
 			var sheetObj = sheetObjects[11];   			
 		}
 		
		if (sheetObj.FindCheckedRow("del_chk") != "") {
			if (!confirm("Are you sure to delete?")) { 
				return;
			}
			ComRowHideDelete(sheetObj, "del_chk");
		} 
		else {
			alert("No Selected Row");
		}
  	 }
 	 

	function doActionPrmcRetrieve(){
  		var formObj 	= document.form;
		 //Period Date 초기화
		 //사용자 Office 의 현재 날짜를 조회한다.
		 var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj);
		 if ( formObj.pfmc_flg[0].checked == true ){
			 var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -365);
			 var toMvmtDt = ofcCurrDate;
		 }  else if ( formObj.pfmc_flg[2].checked == true ){
			 var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -457);
			 var toMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -92);	 
		 } else if ( formObj.pfmc_flg[1].checked == true ){
			 var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -183);
			 var toMvmtDt = ofcCurrDate;
		 } else if ( formObj.pfmc_flg[3].checked == true ){
			 var fmMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -275);
			 var toMvmtDt = ComGetDateAdd(ofcCurrDate, "D", -92);
		 }
		 ComSetObjValue(formObj.fm_dt, fmMvmtDt);
		 ComSetObjValue(formObj.to_dt, toMvmtDt);
		 
		 doActionIBSheet(sheetObjects[6], formObj, IBSEARCH_PFMC);		//Full History
		 
		for (var i=2; i<sheetObjects[6].RowCount+2; i++) {
			sheetObjects[6].CellValue(i, "ibflag") = "I";
		}
	}
	

	function doActionLccRetrieve(){
  		var formObj 	= document.form;
  		
		 ComSetObjValue(formObj.retrive_flg, "Y");
		 
		 doActionIBSheet(sheetObjects[7], formObj, IBSEARCH_LCC_MAS);
		 
		for (var i=2; i<sheetObjects[7].RowCount+2; i++) {
			sheetObjects[7].CellValue(i, "ibflag") = "I";
		}
	}

	function doActionSave(){
		
  		var formObj 	= document.form;
//     	var uploadObj = uploadObjects[0];
//    	
//    	uploadObj.Files = ""; // -먼저기존파일을 모두 지운후 추가함
//    	
//		if ( formObj.rqst_flg.value == "Y" ){
//	     	// 업로드파일이 존재할 경우, 파일업로드 객체에 파일정보를 추가해준다.
//	    	appendFileToUploadObjects(sheetObjects[0]);	 
//	    	appendFileToUploadObjects(sheetObjects[2]);	 
//	    	appendFileToUploadObjects(sheetObjects[3]);	 
//	    	appendFileToUploadObjects(sheetObjects[4]);	
//	    	appendFileToUploadObjects(sheetObjects[11]);	 
//		}
//
//  		if (uploadObj.LocalFiles == "") {
  			doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
//    	}
//    	else {	
//    		doActionIBSheet(sheetObjects[1], formObj, IBSAVE_FILEUPLOAD);
//    	}
//  		
  		if ( retrieve_flg == "Y" ){
  			doInit();
  		}
//		retrieve_flg == "N"
//  		if ( retrieve_flg == "Y" ){
//  			window.close();
//  		}
  		
	}
	

    /**
     * 업로드파일이 존재할 경우, 파일업로드 객체에 파일정보를 추가해준다. <br>
     */
    function appendFileToUploadObjects(sheetObj) {
    	var formObj   = document.form;
    	var uploadObj = uploadObjects[0];
    	
    	var arrRow = sheetObj.FindStatusRow("I").split(";");
    	for (i=0; i<arrRow.length-1; i++) {
    		//IBUpload에 파일 추가하기
    		uploadObj.AddFile(sheetObj.CellValue(arrRow[i], FILE_PATH));
    	}
    }    

     //########################################################< CHARGE SPECIFIC REASON 기능 추가 - START >############################################################################
    /**
 	 * t1sheet1 클릭 이벤트 발생
 	 */
 	function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
    	fnDownloadAtchFile(sheetObj, Row, Col, "");
 	}
 	
 	/**
 	 * t1sheet3 클릭 이벤트 발생
 	 */
 	function t1sheet3_OnClick(sheetObj, Row, Col, Value) {
    	fnDownloadAtchFile(sheetObj, Row, Col, "");
 	}
 	
 	/**
 	 * t1sheet5 클릭 이벤트 발생
 	 */
 	function t1sheet5_OnClick(sheetObj, Row, Col, Value) {
    	fnDownloadAtchFile(sheetObj, Row, Col, "");
 	}
 	/**
 	 * t1sheet7 클릭 이벤트 발생
 	 */
 	function t1sheet7_OnClick(sheetObj, Row, Col, Value) {
    	fnDownloadAtchFile(sheetObj, Row, Col, "");
 	}

    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	with(sheetObj)
    	{
//			sheetObj.ShowSubSum("ofc_cd", "incr_cntr|incr_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr1|bill_amt1|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt|inv_pay_cntr|inv_pay_amt", -1, true, false, -1
//					, "chk=;ofc_cd=%s;seq=S.TTL;coll_rto_a=Round(|coll_amt|/|incr_amt|, 4)*100;coll_rto_b=Round(|coll_amt|/|bill_amt1|, 4)*100;coll_rto_c=Round(|coll_amt|/|bill_amt|, 4)*100;coll_rto_d=Round(|coll_amt|/|inv_amt|, 4)*100");

    		var row = LastRow;
    		
    		SumText(0, "aft_bkg_perf_rqst_seq")		= "";
    		SumText(0, "cust_cd")					= "";
    		SumText(0, "cust_nm")					= "";
    		SumText(0, "pol_cd") 					= "";
    		SumText(0, "pod_cd") 					= "";
    		SumText(0, "dmdt_trf_cd") 				= "Total";
    		
    		var collRt = '0';
    		var exptDcRt = '0';
    		
    		if(SumValue(0, "bill_amt") != '0')
    			collRt = ComRound(SumValue(0, "inv_pay_amt")/SumValue(0, "bill_amt"), 4)*100;

    		if(SumValue(0, "org_chg_amt") != '0')
    			exptDcRt = ComRound((SumValue(0, "expt_amt")+SumValue(0, "aft_expt_dc_amt"))/SumValue(0, "org_chg_amt"), 4)*100;
    			
    		SumValue(0, "coll_rt") = collRt;
    		SumValue(0, "expt_dc_rt") = exptDcRt;
       	}
    }
 	
 	/**
 	 * t4sheet2 클릭 이벤트 발생
 	 */
 	function t4sheet2_OnClick(sheetObj, Row, Col, Value) {
    	fnDownloadAtchFile(sheetObj, Row, Col, "4_2");
 	}

    /**
      * Sheet10 에 Click 이벤트 발생시 호출되는 함수
      */
	function t4sheet3_OnChange(sheetObj, Row, Col, Value) {
    	var formObj   = document.form;
    	
    	spec_rsn_row = Row;
    	if ( spec_rsn_cd_1 == "CGOSHB"){
    		formObj.bkg_no.value = Value;
    		doActionIBSheet(sheetObj, formObj, IBSEARCH_RSNVAL);
    	}
    	formObj.bkg_no.value = "";
    	
		spec_rsn_cd_row = Row;
		spec_rsn_cd_col = Col;
		
		var colName = sheetObj.ColSaveName(Col);
		
    	switch(spec_rsn_cd_1) {
	    	case "VSLACC":
		 		if(colName == 'detail_1_type') {
		 			if ( Value.length != 9 ){
		 				ComShowCodeMessage('DMT03028', 'VVD');		 				
		 				sheetObj.CellValue2(Row,Col) = '';
		 				return false;
		 			} else {
		 				vvd_flg = "Y";
		 			}
		 		}
		 		if(colName == 'detail_2_type') {
		 			if ( Value.length != 5 ){
		 				ComShowCodeMessage('DMT03028', 'Port Code');		 				
		 				sheetObj.CellValue2(Row,Col) = '';
		 				return false;
		 			} else {
		 				port_flg = "Y";
		 			}
		 		}
		 		break;		 		
    	}

		if ( vvd_flg == "Y" ){
	 		formObj.vvd_cd.value = Value;
	 		doActionIBSheet(sheetObj, document.form, IBSEARCH_VVD);
	 		formObj.vvd_cd.value = "";
	 		vvd_flg = "N";
		}
		if ( port_flg == "Y" ){
	 		formObj.loc_cd.value = Value;
	 		doActionIBSheet(sheetObj, document.form, IBSEARCH_LOC);
	 		formObj.loc_cd.value = "";
		}

 		vvd_flg = "N";
 		port_flg = "N";
	}
	
	//팝업버튼 Click 이벤트 처리
	function t4sheet3_OnPopupClick(sheetObj, row,col){
		var col_nm = sheetObj.ColSaveName(col);

		if (sheetObj.ColSaveName(col) == "detail_1_type" || 
			sheetObj.ColSaveName(col) == "detail_2_type" ||
			sheetObj.ColSaveName(col) == "detail_3_type" ||
			sheetObj.ColSaveName(col) == "detail_4_type" ||
			sheetObj.ColSaveName(col) == "detail_5_type" ||
			sheetObj.ColSaveName(col) == "detail_6_type" ||
			sheetObj.ColSaveName(col) == "detail_7_type" ||
			sheetObj.ColSaveName(col) == "detail_8_type" ||
			sheetObj.ColSaveName(col) == "detail_9_type"   ) {

			gObjId = col_nm;
			
			if ( sheetObj.CellValue(row,"popup_code_"+col_nm.substring(7,8)) == "port" ){
				ComOpenPopup("ESM_BKG_0083.do", 1000, 450, "getPort", "1,0,1,1,1,1,1", true);
			} else if ( sheetObj.CellValue(row,"popup_code_"+col_nm.substring(7,8)) == "vvd" ){
				var param = "";
		  	    param += "vvd_cd="+sheetObj.CellValue(row,col);
				ComOpenPopup("/hanjin/COM_ENS_0B2.do?"+param , 780, 465, "getVvd", "1,0,1,1,1,1,1", true);
			}
		}
	}
 	
    /*
  	 * vvd Code값을 해당 필드에 설정 
  	 */    
    function getVvd(rArray) {
        var formObj = document.form;
  		var sheetObj = sheetObjects[11];

  		with(sheetObj) {
  			CellValue2(SelectRow, gObjId) = rArray[0][7];
  		}
  		gObjId = "";
    } 
    
    /*
  	 * Port Code 값을 해당 필드에 설정 
  	 */    
    function getPort(locTp, tab, rArray) {
        var formObj = document.form;
  		var sheetObj = sheetObjects[11];

  		with(sheetObj) {
  			CellValue2(SelectRow, gObjId) = rArray[0][2];
  		}
  		gObjId = "";
    }   

	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		
//		sheetObj.RowMerge(1) = true;
//		sheetObj.RowMerge(2) = true;
//		sheetObj.RowMerge(5) = true;
		sheetObj.RowMerge(7) = true;
//		sheetObj.RowMerge(9) = true;
		sheetObj.RowMerge(10) = true;
		sheetObj.RowMerge(11) = true;
		sheetObj.RowMerge(12) = true;
		sheetObj.RowMerge(13) = true;

		sheetObj.RowHeight(0) = 60;
		sheetObj.RowHeight(1) = 30;
		sheetObj.RowHeight(2) = 30;
		sheetObj.RowHeight(3) = 30;
		sheetObj.RowHeight(4) = 30;
		sheetObj.RowHeight(5) = 30;
		sheetObj.RowHeight(6) = 30;
		sheetObj.RowHeight(7) = 30;
		sheetObj.RowHeight(8) = 30;
		sheetObj.RowHeight(9) = 30;
		sheetObj.RowHeight(10) = 30;
		sheetObj.RowHeight(11) = 30;
		sheetObj.RowHeight(12) = 30;
		sheetObj.RowHeight(13) = 30;

		for (var i = 1 ; i <= sheetObj.RowCount ; i++) {
			sheetObj.CellImage(i, "value_image_3") = sheetObj.CellValue(i,"value_3");
		}
	}
    /**
      * Sheet10 에 Click 이벤트 발생시 호출되는 함수
      */
	function t4sheet1_OnChange(sheetObj, Row, Col, Value) {

    	var formObj   = document.form;
    	
		if ( oldRow == Row ) return;	
		if (sheetObj.ColSaveName(Col) != "chk") return;
		
		spec_rsn_cd_1 = sheetObj.CellValue(Row,"spec_rsn_cd");

		displayInactivationDetailReason(sheetObj, Row);		
		
		if ( spec_rsn_cd_1.substring(0,5) == "UCOTT"){
			sheetObjects[11].Editable = false;
			if ( retrieve_flg != "Y"){
		    	doActionIBSheet(sheetObj, formObj, IBSEARCH_UCTTL);
		    }	
		} else {
			sheetObjects[11].Editable = true;
		}
		detail_explanation.innerHTML = sheetObj.CellValue(Row,"dtl_rmk");;
	}
	

    /**
     * Specific Reason 선택시, 해당 Detail 내역을 화면에 그려준다.
     */	
	function displayInactivationDetailReason(sheetObj, Row) {
		
		var formObj = document.form;

		oldRow =  Row;
		
		// Detail 내역을 조회하기 위해 매개변수를 설정한다.
		ComSetObjValue(formObj.spec_rsn_cd, sheetObj.CellValue(Row, "spec_rsn_cd"));

		// 선택한 삭제상세코드에 설정된 단계별 Remark 를 조회한다.
		doActionIBSheet(sheetObj, formObj, IBSEARCH_DETAIL);

		if ( retrieve_flg != "Y"){
			sheetObjects[10].RemoveAll();
			sheetObjects[11].RemoveAll();		
		}
		
		var file_lvl_nm = sheetObj.Cellvalue(Row,"file_lvl_nm");
		var file_lvl_value = sheetObj.Cellvalue(Row,"file_lvl_value");

		sheetObjects[10].InitDataCombo(0,RMK_LVL,file_lvl_nm,file_lvl_value);

		if ( sheetObj.Cellvalue(Row,"rsn_file_flg") == "Y"){
			ComSetDisplay('t4sheet2_id', true);
			if ( sheetObj.CellValue(Row, "spec_rsn_cd") == "INTSTF" || sheetObj.CellValue(Row, "spec_rsn_cd") == "INTOPR" ){
				ComSetDisplay('t4sheet2_down', true);
			} else {
				ComSetDisplay('t4sheet2_down', false);
			}
		} else {
			ComSetDisplay('t4sheet2_id', false);
		}
		
		if ( sheetObj.Cellvalue(Row,"rsn_desc_flg") == "Y"){
			ComSetDisplay('t4sheet3_id', true);
			if ( retrieve_flg != "Y"){
				sheetObjects[11].DataInsert(-1);
			}
		} else {
			ComSetDisplay('t4sheet3_id', false);
		}

		if ( sheetObj.Cellvalue(Row,"rsn_bt_cd") == "B"){
			ComSetDisplay('t4sheet3_button', true);
		} else {
			ComSetDisplay('t4sheet3_button', false);
		}

		clearDetailReason();

    	displayDetailReason(formObj, REASON_DETAIL_START, REASON_DETAIL_END);
	}
	

	// Specific Reason 코드값에 따라서 입력해야될 Detail Depth 목록을 지워준다.
    function clearDetailReason() {
    	
    	var sheetObj = sheetObjects[11];
    	
    	sheetObj.ColHidden("detail_1_type") = true;    	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_1_type",dtData,daCenter,"detail_1_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_1_type") = 80;    	

    	sheetObj.ColHidden("detail_2_type") = true;    	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_2_type",dtData,daCenter,"detail_2_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_2_type") = 80;    	
    	
    	sheetObj.ColHidden("detail_3_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_3_type",dtData,daCenter,"detail_3_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_3_type") = 80;    	
    	
    	sheetObj.ColHidden("detail_4_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_4_type",dtData,daCenter,"detail_4_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_4_type") = 80;    	
    	
    	sheetObj.ColHidden("detail_5_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_5_type",dtData,daCenter,"detail_5_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_5_type") = 80;    	
    	
    	sheetObj.ColHidden("detail_6_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_6_type",dtData,daCenter,"detail_6_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_6_type") = 80;    	

    	sheetObj.ColHidden("detail_7_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_7_type",dtData,daCenter,"detail_7_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_7_type") = 80;  

    	sheetObj.ColHidden("detail_8_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_8_type",dtData,daCenter,"detail_8_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_8_type") = 80;  

    	sheetObj.ColHidden("detail_9_type") = true;   	
    	for (var j=1;j<sheetObj.rowcount+1; j++) {
			sheetObj.InitCellProperty(j,"detail_9_type",dtData,daCenter,"detail_9_type","",dfNone,-1,-1);
		}
    	sheetObj.ColWidth("detail_9_type") = 80;  
    	
    	sheetObj.ColHidden("detail_10_type") = true;    	

    }

//	// Specific Reason 코드값에 따라서 입력해야될 Detail Depth 목록을 화면에 그려준다.
    function displayDetailReason(formObj, nRsnDtlStRow, nRsnDtlEndRow) {

    	var sheetObj = sheetObjects[11];
    	
    	if (nRsnDtlStRow  < REASON_DETAIL_START) return;
    	if (nRsnDtlEndRow > REASON_DETAIL_END)   return;

		//4.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
    	for (var i=nRsnDtlStRow; i<=REASON_DETAIL_END; i++) {
    	
    		var prefix = "detail_" + i;

    		if (i > nRsnDtlEndRow) {   			
    		}
	    	else {
				var fieldName   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_name"));
				var fieldType   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_type"));
				var fieldSize   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_size"));
				var fieldFormat = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_format"));
				var fieldItem   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_item"));
				var fieldCond   = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_cond"));
				var fieldPopup  = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_popup"));
				var fieldValue  = ComGetObjValue(eval("formObj.h_" + prefix + "_rsn_field_value"));
				
				var detailType  = "";
				
				if (fieldName != "") {
					
					sheetObj.ColHidden(prefix+"_type") = false;
					sheetObj.CellText(0,prefix+"_type") = fieldName;
					
					if (fieldType == "radio") {
						if (fieldItem.indexOf("|") != -1) {
							for (var j=1;j<sheetObj.rowcount+1; j++) {
								sheetObj.InitCellProperty(j,prefix+"_type",dtCombo,daCenter,prefix+"_type","",dtNull);
								if ( fieldName == "Delivery Term"){
									sheetObj.CellEditable(j,prefix+"_type") = false;
								} else {
									sheetObj.CellEditable(j,prefix+"_type") = true;
								}
							}
							sheetObj.InitDataCombo(0,prefix+"_type",fieldItem,fieldItem);
						}
					}
					else if (fieldType == "textarea") {
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type",dtData, daLeft, prefix+"_type","",dtNull,-1,fieldSize);
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}
					} else if (fieldFormat == "ymd") {
						
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type",dtData, daCenter,prefix+"_type","",dfDateYmd);						
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}
					} else if (fieldPopup == "cust_cd"||fieldPopup == "vvd"||fieldPopup == "port"||fieldPopup == "curr_cd") {
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type",dtPopupEdit, daCenter,prefix+"_type","",dfEngUpKey,-1,fieldSize);
							sheetObj.CellValue2(j,"popup_code_"+i) = fieldPopup;
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}
					} else if ( fieldFormat == "engup"){
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type",dtData, daCenter,prefix+"_type","",dfEngUpKey,-1,fieldSize);
							if ( fieldName == "BKG Status"){
								sheetObj.CellEditable(j,prefix+"_type") = false;
							} else {
								sheetObj.CellEditable(j,prefix+"_type") = true;
							}
						}
					} else if ( fieldFormat == "int"){
						for (var j=1;j<sheetObj.rowcount+1; j++) {
							sheetObj.InitCellProperty(j,prefix+"_type", dtData, daRight,prefix+"_type","",dfNullInteger,-1,fieldSize);
							sheetObj.CellEditable(j,prefix+"_type") = true;
						}						
					} else {
						sheetObj.InitCellProperty(j,prefix+"_type",dtData, daCenter,prefix+"_type","",dtNull,-1,fieldSize);
						sheetObj.CellEditable(j,prefix+"_type") = true;
					}
					
					if ( fieldSize > 99 ){
						sheetObj.ColWidth(prefix+"_type") = 350;
					} else if ( fieldSize > 15 ){
						sheetObj.ColWidth(prefix+"_type") = 250;
					} else if ( fieldSize > 10 ){
						sheetObj.ColWidth(prefix+"_type") = 180;
					} else {
						sheetObj.ColWidth(prefix+"_type") = 120;
					}
				}
	    	}
    	}
		    	
    }
    function doActionParam(){

		var formObj = document.form;
		var sParam = FormQueryString(formObj);
		
		if ( formObj.rqst_flg.value == "Y" ){
			var row_8 = sheetObjects[1].DataInsert(-1);
			
			sheetObjects[1].Cellvalue2(row_8,"aft_bkg_act_cost_itm_nm") = "Reason of D/C Request";
			sheetObjects[1].Cellvalue2(row_8,"aft_bkg_act_cost_rmk") = formObj.rsn_dc_rqst.value;
			sheetObjects[1].Cellvalue2(row_8,"aft_bkg_act_cost_itm_lvl") = "8";
			
			var row_9 = sheetObjects[1].DataInsert(-1);
	
			sheetObjects[1].Cellvalue2(row_9,"aft_bkg_act_cost_itm_nm") = "Reason of Clearance Delay";
			sheetObjects[1].Cellvalue2(row_9,"aft_bkg_act_cost_rmk") = formObj.rsn_cle_delay.value;
			sheetObjects[1].Cellvalue2(row_9,"aft_bkg_act_cost_itm_lvl") = "9";
			
			sParam += "&" + ComSetPrifix(sheetObjects[1].GetSaveString(false), "t1sheet2_");
			sParam += "&" + ComSetPrifix(sheetObjects[4].GetSaveString(false), "t1sheet6_");  
			sParam += "&" + ComSetPrifix(sheetObjects[6].GetSaveString(false), "t2sheet1_"); 
			sParam += "&" + ComSetPrifix(sheetObjects[7].GetSaveString(false), "t2sheet2_"); 
			sParam += "&" + ComSetPrifix(sheetObjects[8].GetSaveString(false), "t3sheet1_");   
			sParam += "&" + ComSetPrifix(sheetObjects[9].GetSaveString(false),"t4sheet1_");
			sParam += "&" + ComSetPrifix(sheetObjects[11].GetSaveString(true), "t4sheet3_");

			sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false), "");
			sParam += "&" + ComSetPrifix(sheetObjects[2].GetSaveString(false), "");
			sParam += "&" + ComSetPrifix(sheetObjects[3].GetSaveString(false), "");
			sParam += "&" + ComSetPrifix(sheetObjects[5].GetSaveString(false), "");
			sParam += "&" + ComSetPrifix(sheetObjects[10].GetSaveString(false), "");
			
			sheetObjects[1].RowDelete(row_9, false);
			sheetObjects[1].RowDelete(row_8, false);
		} else {
			sParam += "&" + ComSetPrifix(sheetObjects[12].GetSaveString(false), "t5sheet1_");
		}

		return sParam;
    	
    }
    

	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 **/
	function downloadFileINT(fileSavId) {	
		var param = "key=" + fileSavId;
		hiddenFrame.location.href = URL_FILE_DOWNLOAD + "?" + param;	
	} 	

	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 **/
	function fnDownloadAtchFile(sheetObj, Row, Col, Sheet) {
		
		if ( Sheet != "4_2"){
			if (Col != 2) return;
		} else {
			if (Col != 3) return;
		}
 
		// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		if (sheetObj.CellText(Row, FILE_NM) == "") {
			return;
		}

		// 파일이 존재시 다운로드 받는다.
		var fileSavId = sheetObj.CellValue(Row, FILE_SAV_ID);
		var exist     = fnSaveFileExist(fileSavId, sheetObj);

		// 서버에 파일존재유무확인
		if (eval(exist)) {
			var param = "key=" + fileSavId;
			hiddenFrame.location.href = URL_FILE_DOWNLOAD + "?" + param;
		}
		else {
			alert("Attached File is deleted due to storage server capacity");
		}	
	} 	
	
	/**
	 * 파일존재유무판단  
	 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
	 * param :file_id
	 * return :boolean
	 */
	function fnSaveFileExist(fileSavId, sheetObj) {
		var formObj = document.form;
		var param   = "&f_cmd=" + SEARCH26 + "&file_sav_id=" + fileSavId;
		var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", param);
		var exist   = ComGetEtcData(sXml, "is_exists");
		return exist;
	}
	
	/**
	 * 용량계산하기  <br>
	 * @param {String} 	_val 		파일용량
	 * @param {String} 	r_value    	MB/KB계산 
	 **/
	function getSize(_val) {

		var r_value = _val;
		var _value = Math.round(_val / 1024);

		if (_value > 0) {
			r_value = _value;
			_value = Math.round(_value / 1024);
			if (_value > 0) {
				_value = _value + " MB"
			} 
			else {
				_value = r_value + " KB"
			}
		} 
		else {
			_value = r_value + " Bytes"
		}
		return _value;
	}	
	
    function unLoadPage() {
		window.returnValue="Y";
    }
    
    function setHighLow(value){
		var formObj = document.form;
		
		if ( value == "1" && formObj.ucCgoPsblFlg1.checked == true ){
			formObj.ucCgoPsblFlg2.checked = false;
		} else if ( value == "2" && formObj.ucCgoPsblFlg2.checked == true ){
			formObj.ucCgoPsblFlg1.checked = false;
		}
    	
		if ( formObj.ucCgoPsblFlg1.checked == true ){
			formObj.uc_cgo_psbl_flg.value = "Y";
		} else if ( formObj.ucCgoPsblFlg2.checked == true ){
			formObj.uc_cgo_psbl_flg.value = "N";
		} else {
			formObj.uc_cgo_psbl_flg.value = "";
		}
    }
    

//    function setVolumePayment(value){
//		var formObj = document.form;
//		
//		if ( value == "1" && formObj.letterFlg1.checked == true ){
//			formObj.letterFlg2.checked = false;
//		} else if ( value == "2" && formObj.letterFlg2.checked == true ){
//			formObj.letterFlg1.checked = false;
//		}
//    	
//		if ( formObj.letterFlg1.checked == true ){
//			formObj.letter_flg.value = "Y";
//		} else if ( formObj.letterFlg2.checked == true ){
//			formObj.letter_flg.value = "N";
//		} else {
//			formObj.letter_flg.value = "";
//		}
//    }
	/* 개발자 작업  끝 */