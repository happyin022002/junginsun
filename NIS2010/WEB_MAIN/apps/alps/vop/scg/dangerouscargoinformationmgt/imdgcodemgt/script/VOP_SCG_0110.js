/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_SCG_0110.js
*@FileTitle : Packing Instruction Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.07
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2010.01.27 나상보
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
     * @class VOP_SCG_0110 : VOP_SCG_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_SCG_0110() {
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
    var tabLoad = new Array();
    tabLoad[0]= false;
    tabLoad[1]= false;
    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var comboObjects  = new Array();
	var comboCnt      = 0;
	
	var HeadTitleCnt  = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {
				
				case "btn_Validate":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
				case "btn_New":
					clearAll();
					break;
				
				case "srch_imdg_un_no":
					var imdg_un_no =  document.form.imdg_un_no.value;
		  	    	 ComOpenPopup("VOP_SCG_3005.do?imdg_un_no="+imdg_un_no,940, 397, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true);
					break;
					
				 case "out_btn1":    					                					    	     		
	                	document.getElementById("imdg_pck_tp_cd").value = "O";
	                	document.getElementById("pck_tp_seq").value = "1";
	                	document.getElementById("temp_pck_tp_cd").value = document.getElementById("out_imdg_pck_cd1").value;
	                	document.getElementById("temp_imdg_pck_desc").value = document.getElementById("out_imdg_pck_desc1").value;				                	
	                	var url = "VOP_SCG_0111.do";					                	
	                	ComOpenWindowCenter(url, "VOP_SCG_0111", 700, 660, true);
	                	
					break;
					
	                case "intmd_btn1":	
	                	document.getElementById("imdg_pck_tp_cd").value = "M";
	                	document.getElementById("pck_tp_seq").value = "3";
	                	document.getElementById("temp_pck_tp_cd").value = document.getElementById("intmd_imdg_pck_cd1").value;
	                	document.getElementById("temp_imdg_pck_desc").value = document.getElementById("intmd_imdg_pck_desc1").value;
	                	var url = "VOP_SCG_0111.do";
						ComOpenWindowCenter(url, "VOP_SCG_0111", 700, 660, true);								
					break;
	                	
	                case "in_btn1":	
	                	document.getElementById("imdg_pck_tp_cd").value = "I";
	                	document.getElementById("pck_tp_seq").value = "5";
	                	document.getElementById("temp_pck_tp_cd").value = document.getElementById("in_imdg_pck_cd1").value;
	                	document.getElementById("temp_imdg_pck_desc").value = document.getElementById("in_imdg_pck_desc1").value;
	                	var url = "VOP_SCG_0111.do";
						ComOpenWindowCenter(url, "VOP_SCG_0111", 700, 660, true);								
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
       */
      function setComboObject(combo_obj) {
           comboObjects[comboCnt++] = combo_obj;
      }

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
    	 
    	  for(i=0;i<sheetObjects.length;i++){
    		 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
    	 
    	 for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
    	 
    	//IBMultiCombo초기화
         for(k = 0; k < comboObjects.length; k++) {
        	 initCombo(comboObjects[k], k + 1);
         }
    	 
    	 initControl();
    	 doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
     }

      /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

    	 var cnt = 0;
    	 switch(sheetNo) {
    	 	case 1:      //t1sheet1 init
   	 		with (sheetObj) {
    		
	 			// 높이 설정
	 			style.height = 120;
	 			//전체 너비 설정
	 			SheetWidth = mainTable.clientWidth;
	
	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	 			//전체Merge 종류 [선택, Default msNone]
	 			MergeSheet = msHeaderOnly;
	
	 			//전체Edit 허용 여부 [선택, Default false]
	 			Editable = false;
	
	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 			InitRowInfo( 1, 1, 3, 100);
	
	 			
	
	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)
	
	 			var HeadTitle = "|Restriction Regulatory|Restriction Regulatory|Validation Result|Validation Result|Validation Result|Validation Result";
	 			var headCnt  = HeadTitle.split("|").length;
                HeadTitleCnt = headCnt;
                
              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(headCnt, 0, 0, true);
	 			
	 			Rows = 5;
	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);
	
	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
	 			InitDataProperty(0, cnt++ , dtData,      	200,	daLeft,  	true,   "div_nm",  			false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	150,	daRight,  	true,   "regu_val",			false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,  	true,   "max_wgt_nm",		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,  	true,   "max_wgt_rslt",		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,  	true,   "pkg_tp_nm",		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,  	true,   "pkg_tp_rslt",		false,  "",      dfNone,    0,     true,    	true);
	 			
	 			InitHeadColumn(1, "Limite Q'ty|Execpted Q'ty|Packing Instruction|Special Pack.Inst.|Others",daCenterTop);
                InitHeadColumn(3, "Max Weight|Max Weight|Max Weight|Max Weight",daCenterTop);
                InitHeadColumn(5, "PKG Type|PKG Type|PKG Type|PKG Type|PKG Type",daCenterTop);
                
                SelectHighLight = false;
                CountPosition = 0;
                initSheet1(sheetObjects[0]);	  //초기 sheet1 디지인 세팅

 			}
	 		break;
    	 		
    	 	case 2:		//t1sheet2
//	    	 	
    	 	with (sheetObj) {
	 			// 높이 설정
	 			style.height = 90;
	 			//전체 너비 설정
	 			SheetWidth = mainTable.clientWidth;
	
	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	 			//전체Merge 종류 [선택, Default msNone]
	 			MergeSheet = msHeaderOnly;
	
	 			//전체Edit 허용 여부 [선택, Default false]
	 			Editable = false;
	
	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 			InitRowInfo( 1, 1, 3, 100);
	
	 			
	
	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)
	
	 			var HeadTitle = "|SEQ|Reason of Invalid Details( Double click a data row for the packing instruction information )";
	 			var headCnt  = HeadTitle.split("|").length;
                
              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(headCnt, 0, 0, true);
	 			
	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);
	
	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
	 			InitDataProperty(0, cnt++ , dtData,      	30,		daCenter,  	true,   "seq",  			false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	200,	daLeft,  	true,   "invld_desc",  		false,  "",      dfNone,    0,     true,    	true,	-1,		false,		true,	"\"Double click a data row for the packing instruction information.\"");
                
                SelectHighLight = false;
                CountPosition = 0;
                WordWrap = true;
 			}
    	 	break;
    	 	
    	 	case 3:		//t1sheet3
//	    	 	
    	 	with (sheetObj) {
	 			// 높이 설정
	 			style.height = 90;
	 			//전체 너비 설정
	 			SheetWidth = mainTable.clientWidth;
	
	 			//Host정보 설정[필수][HostIp, Port, PagePath]
	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	 			//전체Merge 종류 [선택, Default msNone]
	 			MergeSheet = msHeaderOnly;
	
	 			//전체Edit 허용 여부 [선택, Default false]
	 			Editable = false;
	
	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 			InitRowInfo( 1, 1, 3, 100);
	
	 			
	
	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)
	
	 			var HeadTitle = "|Special Packaging Instruction & Provisions to be reffered|Special Packaging Instruction & Provisions to be reffered";
	 			var headCnt  = HeadTitle.split("|").length;
                
              //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(headCnt, 0, 0, true);
	 			
	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);
	
	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
	 			InitDataProperty(0, cnt++ , dtData,      	50,		daLeft,  	true,   "spcl_pck_provi_cd",  		false,  "",      dfNone,    0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,      	200,	daLeft,  	true,   "spcl_pck_provi_desc",  	false,  "",      dfNone,    0,     true,    	true);
                
                SelectHighLight = false;
                CountPosition = 0;
                WordWrap = true;
 			}
    	 	break;
    	 	
    	 	case 4:      //t2sheet1 init
            with (sheetObj) {

                //높이 설정
                style.height = 140;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 15, 100);

                var HeadTitle1 = "Type|Port Code|Seq|Required|Explanation|Sequence|Sequence|UN No./Seq.|UN No./Seq.";
                var HeadTitle2 = "Type|Port Code|Seq|Required|Explanation|CNTR|CGO|UN No./Seq.|UN No./Seq.";
				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                //해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,	   	50,    daCenter,	true,    "port_type",				false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,		70,    daCenter,  	true,    "port_cd",					false,     "",      dfNone,      0,     true,    true);
                
                InitDataProperty(0, cnt++ , dtHidden,	30,	    daCenter,   false,	 "seq",                     false,     "|spcl_cntr_seq|+|spcl_cgo_seq|");
                InitDataProperty(0, cnt++ , dtData,		100,    daCenter,   true,    "imdg_cmptn_auth_desc", 	false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,   	487,    daCenter,	true,    "txt_desc", 				false,     "",      dfNone,      0,     true,    true); 
                InitDataProperty(0, cnt++ , dtData,   	40,    	daCenter,	true,    "spcl_cntr_seq", 			false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,   	40,    	daCenter,	true,    "spcl_cgo_seq", 			false,     "",      dfNone,      0,     true,    true);
                
                InitDataProperty(0, cnt++ , dtData,   	60,    	daCenter,	true,    "imdg_un_no", 				false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,   	30,    	daCenter,	true,    "imdg_un_no_seq", 			false,     "",      dfNone,      0,     true,    true);
                
                //선택된 행의 하이라이트를 안준다.
                SelectHighLight = false;

                SetMergeCell(0, 7, 2, 2);
			}
            break;
    	 	
    	 	case 5:      //t2sheet2 init
            with (sheetObj) {

                //높이 설정
                style.height = 140;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 15, 100);

                var HeadTitle1 = "Sequence|Sequence|UN No./Seq.|UN No./Seq.|VVD CD|Vessel\nOperator|Prohibition on|";
				var HeadTitle2 = "CNTR|CGO| | |VVD CD|Vessel\nOperator|Prohibition on|";
				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                //해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);


                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,   			40,    daCenter,		true,    "spcl_cntr_seq", 		false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,	   			40,    daCenter,		true,    "spcl_cgo_seq",		false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,				60,    daCenter,   		true,    "imdg_un_no",			false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,				30,    daCenter,   		true,    "imdg_un_no_seq",		false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,		 		100,   daCenter,     	true,    "vvd_cd", 	  			false,     "",      dfNone,      0,     true,    true);
                InitDataProperty(0, cnt++ , dtData,   			80,    daCenter,		true,    "crr_cd", 		        false,     "",      dfNone,      0,     true,    true); 
                InitDataProperty(0, cnt++ , dtData,   			140,   daCenter,		true,    "prohibition_desc", 	false,     "",      dfNone,      0,     true,    true);
                
                InitDataProperty(0, cnt++ , dtHidden,   		0,     daCenter,		true,    "chk_type", 	        false,     "",      dfNone,      0,     true,    true);
                
                //선택된 행의 하이라이트를 안준다.
                SelectHighLight = false;

                EditableColorDiff = false;
                HeadRowHeight = 20;
                
                SetMergeCell(0, 2, 2, 2);
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
	   * Tab 기본 설정
	   * 탭의 항목을 설정한다.
	   */
	  function initTab(tabObj , tabNo) {
	 	 switch(tabNo) {
	 	 	case 1:
	 	 		with (tabObj) {
	 	 			var cnt  = 0 ;
	 	 			InsertTab( cnt++ , "Pakc. Inst./LTD Qty" , -1 );
//	 	 			InsertTab( cnt++ , "Port & Carrier" , -1 );
	 	 			TabEnable(6) = false;
	 	 		}
	 	 	break;
	 	 }
	  }
	   
	   /**
	    * Tab 클릭시 이벤트 관련
	    * 선택한 탭의 요소가 활성화 된다.
	    */
	   function tab1_OnChange(tabObj , nItem) {
    	 var objs = document.all.item("tabLayer");
    	 objs[nItem].style.display = "Inline";
	  	 objs[beforetab].style.display = "none";
	
	  	 //--------------- 요기가 중요 --------------------------//
	  	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	  	 //------------------------------------------------------//
	  	 beforetab= nItem;
	  	 tabIndex = nItem;
	   }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH:      //조회
         		if(!ComChkRequired(document.form)) return false;
         		formObj.f_cmd.value = SEARCH03;
		        var sXml = sheetObj.GetSearchXml("VOP_SCG_0110GS.do", FormQueryString(formObj));
		        var arrXml = sXml.split("|$$|");
		        sheetObjects[0].LoadSearchXml(arrXml[0]);
		        sheetObjects[1].LoadSearchXml(arrXml[1]);
		        sheetObjects[2].LoadSearchXml(arrXml[2]);
        	   	break;
			
			case IBSEARCH_ASYNC01:   //PCK INSTR CD 조회
		 								
				formObj.f_cmd.value = SEARCH;						
				var rXml = sheetObj.GetSearchXml("VOP_SCG_0110GS.do", FormQueryString(formObj));
				
				var imdg_pck_desc = ComGetEtcData(rXml, "imdg_pck_desc");
				
				if(valCnt == "1"){
					document.getElementById("out_imdg_pck_desc1").value = imdg_pck_desc;
					
				}
				if(valCnt == "2"){
					document.getElementById("intmd_imdg_pck_desc1").value = imdg_pck_desc;
					
				}
				if(valCnt == "3"){
					document.getElementById("in_imdg_pck_desc1").value = imdg_pck_desc;
				}
				
				//sheetObj.WaitImageVisible = true;
		 	
				break;
         }
     }

 	/**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {    	
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerForm('change', 	'obj_change', 	document.form); 
         axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
         axon_event.addListenerForm('blur', 	'obj_blur', 	document.form);
     }
      
      function clearAll() {
   		var formObj = document.form;
   		formObj.reset();
  		sheetObjects[0].RemoveAll();
  		sheetObjects[1].RemoveAll();
  		sheetObjects[2].RemoveAll();
  		sheetObjects[3].RemoveAll();
  		sheetObjects[4].RemoveAll();
  		tabLoad[0] = false;
  		tabLoad[1] = false;
  		sheetObjects[0].Rows = 5;
  		initSheet1(sheetObjects[0]);
  		comboObjects[0].Code2 = "S";
  		comboObjects[1].Code2 = "N";
  		comboObjects[2].Code2 = "N";
      }
      
      function obj_change() {
     	 var formObj = document.form;
     	 switch(event.srcElement.name){
//     	 	case "pck_cd":
//     	 		var pckCd = formObj.pck_cd.value;
//     	 		var length = formObj.pck_cd.value.length;
// 	 			if((document.form.pck_div_cd_radio[0].checked == true && pckCd.substr(0,1) == "P")
// 	 			|| (document.form.pck_div_cd_radio[1].checked == true && pckCd.substr(0,3) == "IBC")
// 	 			|| (document.form.pck_div_cd_radio[2].checked == true && pckCd.substr(0,2) == "LP")){
// 	 			clearAll();
// 	 			formObj.pck_cd.value = pckCd;
// 	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
//	 	 		}else{
//	 	 			ComShowCodeMessage('SCG50010',"Pack. Instruct. Code");
//	 	 			formObj.pck_cd.value = "";
//	 	 			formObj.pck_cd.focus();
//	 	 		}
//     	 		break;
     	 }
      }
      
   	/**
     * Form Object obj_keypress 이벤트시 처리
     * @param  void
     * @return void
     */     
     function obj_keypress (){
         var obj = event.srcElement;

         switch (obj.name){
              case 'pck_cd':
        	  	ComKeyOnlyAlphabet('uppernum');
        	  	break;
              case "out_imdg_pck_qty1":	
  		    	ComKeyOnlyNumber(event.srcElement);   	
  		    	break;
  			
  		    case "in_imdg_pck_qty1":		    	
  		    	ComKeyOnlyNumber(event.srcElement);		    	
  		    	break;
  			
  		    case "intmd_imdg_pck_qty1":		    	
  		    	ComKeyOnlyNumber(event.srcElement);		    	
  		    	break;
         }
         
     }
     
     /************************************User_event*************************************************/ 	
     /**
      * Unno Help 팝업으로 Unno, seq, ClassCd 구하기 
      * @param  {Array} aryPopupData	필수	 Array Object
      * @param  {Int} row				선택 선택한 Row
      * @param  {Int} col				선택 선택한 Column
      * @param  {Int} sheetIdx		선택 Sheet Index
      * @return 없음
      */  
      function setUnnoAndClassCd(aryPopupData){ 
         	with(document.form){
         		imdg_clss_cd.value   = aryPopupData[0][4]; 
         		imdg_un_no.value     = aryPopupData[0][2];      
         		imdg_un_no_seq.value = aryPopupData[0][3];          		
         		prp_shp_nm.value     = aryPopupData[0][6]; 
         		imdg_pck_grp_cd.value = aryPopupData[0][9];
  	       }
      }
      
      function obj_blur(){        	
       	var objName = event.srcElement.name;
       	
       	switch (objName) {
       	
  	     	case "out_imdg_pck_cd1":	     	     		
  	     		valCnt = "1";	    
  	     		document.getElementById("imdg_pck_tp_cd").value = "O";
  	     		document.getElementById("out_imdg_pck_cd1").value = (document.getElementById("out_imdg_pck_cd1").value).toUpperCase();
  	     		document.getElementById("imdg_pck_cd").value = document.getElementById("out_imdg_pck_cd1").value;
  	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
  			break;	
  			break;	
  			
  	     	case "intmd_imdg_pck_cd1":	     		
  	     		valCnt = "2";	    
  	     		document.getElementById("imdg_pck_tp_cd").value = "M";
  	     		document.getElementById("intmd_imdg_pck_cd1").value = (document.getElementById("intmd_imdg_pck_cd1").value).toUpperCase();
  	     		document.getElementById("imdg_pck_cd").value = document.getElementById("intmd_imdg_pck_cd1").value;
  	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
  			break;	
  			
  	     	case "in_imdg_pck_cd1":	     		
  	     		valCnt = "3";	     	
  	     		document.getElementById("imdg_pck_tp_cd").value = "I";
  	     		document.getElementById("in_imdg_pck_cd1").value = (document.getElementById("in_imdg_pck_cd1").value).toUpperCase();
  	     		document.getElementById("imdg_pck_cd").value = document.getElementById("in_imdg_pck_cd1").value;
  	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
  			break;	
  			
  	     	case "max_wgt":	    
  	     		if(document.form.max_wgt.value !=''){
  	     		var max_per_unit = eval(document.form.max_wgt.value.replaceStr(","))/eval(document.form.out_imdg_pck_qty1.value.replaceStr(","));    	          	
  	     		document.getElementById("max_per_unit").value = commitfy(roundXL(max_per_unit, 3)); 
  	     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
  	     		}   	     		
  			break;	
  			
  	     	case "out_imdg_pck_qty1": case "grs_wgt": case "net_wgt": case "grs_capa_qty": case "in_imdg_pck_qty1":
  	        	calWgt();  
  	        	ComAddSeparator(event.srcElement);
	    		if(objName == "grs_wgt" || objName == "net_wgt"){
	    			//상호 배제
		    		if(document.activeElement.name != 'grs_wgt' && document.activeElement.name != 'net_wgt') {
		    			chkGrossNetWeight(event.srcElement);
		    		}
	    		}
  			break;	
       	}
       }
      
      function calWgt(){
     	 if(document.form.out_imdg_pck_qty1.value !=''){
	     	 if(document.form.grs_wgt.value !=''){
	          	var outGrsPerUt = eval(document.form.grs_wgt.value.replaceStr(","))/eval(document.form.out_imdg_pck_qty1.value.replaceStr(","));        	              	
	          	document.form.out_grs_per_ut.value = commitfy(roundXL(outGrsPerUt, 2));
	          	ComAddSeparator(document.getElementById("out_grs_per_ut"));
	         }else{
	        	document.form.out_grs_per_ut.value = '';
	         }
	          	
	     	 if(document.form.net_wgt.value !=''){
	          	var outNetPerUt = eval(document.form.net_wgt.value.replaceStr(","))/eval(document.form.out_imdg_pck_qty1.value.replaceStr(","));
	          	document.form.out_net_per_ut.value = commitfy(roundXL(outNetPerUt, 2));
	          	ComAddSeparator(document.getElementById("out_net_per_ut"));
	     	 }else{
	        	document.form.out_net_per_ut.value = '';
	         }
	          	
	     	 if(document.form.grs_capa_qty.value !=''){
	          	var outTtlCapaPerUt = eval(document.form.grs_capa_qty.value.replaceStr(","))/eval(document.form.out_imdg_pck_qty1.value.replaceStr(","));
	          	document.form.out_ttl_capa_per_ut.value = commitfy(roundXL(outTtlCapaPerUt, 2));
	          	ComAddSeparator(document.getElementById("out_ttl_capa_per_ut"));
	     	 }else{
	        	document.form.out_ttl_capa_per_ut.value = '';
	         }
     	 }else{
     		document.form.out_grs_per_ut.value = '';
     		document.form.out_net_per_ut.value = '';
     		document.form.out_ttl_capa_per_ut.value = '';
     	 }
     	 if(document.form.in_imdg_pck_qty1.value !=''){
	     	 if(document.form.grs_wgt.value !=''){
		          	var inGrsPerUt = eval(document.form.grs_wgt.value.replaceStr(","))/eval(document.form.in_imdg_pck_qty1.value.replaceStr(","));
	 	          	document.form.in_grs_per_ut.value = commitfy(roundXL(inGrsPerUt, 2));
	 	          	ComAddSeparator(document.getElementById("in_grs_per_ut"));
		         }else{
		        	document.form.in_grs_per_ut.value = '';
		         }
		          	
		     	 if(document.form.net_wgt.value !=''){
		          	var inNetPerUt = eval(document.form.net_wgt.value.replaceStr(","))/eval(document.form.in_imdg_pck_qty1.value.replaceStr(","));
	 	          	document.form.in_net_per_ut.value = commitfy(roundXL(inNetPerUt, 2));
	 	          	ComAddSeparator(document.getElementById("in_net_per_ut"));
		     	 }else{
		        	document.form.in_net_per_ut.value = '';
		         }
		          	
		     	 if(document.form.grs_capa_qty.value !=''){
		          	var inTtlCapaPerUt = eval(document.form.grs_capa_qty.value.replaceStr(","))/eval(document.form.in_imdg_pck_qty1.value.replaceStr(","));
	 	          	document.form.in_ttl_capa_per_ut.value = commitfy(roundXL(inTtlCapaPerUt, 2));
	 	          	ComAddSeparator(document.getElementById("in_ttl_capa_per_ut"));
		     	 }else{
		        	document.form.in_ttl_capa_per_ut.value = '';
		         }
	     	 }else{
	     		document.form.in_grs_per_ut.value = '';
	     		document.form.in_net_per_ut.value = '';
	     		document.form.in_ttl_capa_per_ut.value = '';
	     	 }
      }
      
      
      function roundXL(n, digits) {
     	 if(digits >= 0) return parseFloat(n.toFixed(digits));

     	 digits = Math.pow(10, digits);
     	 var t = Math.round(n * digits) / digits;

     	 return parseFloat(t.toFixed(0));
      }
      
      function commitfy(n) { 

     	 var reg = /(^[+-]?\d+)(\d{3})/;
     	 n += '';
     	 while(reg.test(n))
     	 n = n.replace(reg,'$1'+','+'$2');
     	 return n;
      }
      
      /**
       * Combo 기본 설정 
       * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
       * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
       */ 
      function initCombo(comboObj, comboNo) {
       	switch(comboObj.id) {
       		case "imdg_lmt_qty_flg":  	  			
   	  			with(comboObj) {
   	  				InsertItem(0, "Y", "Y"); 
   	 	  			InsertItem(1, "N", "N"); 
   	 	  			
   	  				Enable = true;
   	  				MultiSelect = false;
   	  				BackColor = "#CCFFFD";
   	  				Code2 = "N";
   	  			} 	  			
   	  			break; 
   	  		case "imdg_expt_qty_flg":  	  			
   	  			with(comboObj) {
   	  				InsertItem(0, "Y", "Y"); 
   	 	  			InsertItem(1, "N", "N"); 
   	 	  			
   	  				Enable = true;
   	  				MultiSelect = false;
   	  				BackColor = "#CCFFFD";
   	  				Code2 = "N";
   	  			} 	  			
   	  			break; 
   	  		case "dcgo_sts_cd":   	  			 
   	  			with(comboObj) {
   	  				SetColWidth(62);
   	  				DropHeight = 19*6;
   	  				
   	  				InsertItem(0, "", 		"");
   	 	  			InsertItem(1, "GAS", 	"G"); 
   	 	  			InsertItem(2, "PASTE",  "P"); 
   	 	  			InsertItem(3, "LIQUID", "L"); 
   	 	  			InsertItem(4, "SOLID",  "S");
   	 	  			
   	  				Enable = true;
   	  				MultiSelect = false;
   	  				Index = "";
   	  				Code2 = "";
   	  			} 	  			
   	  			break; 
   	  	}
      }
     
   /**
    * sheet1 초기 디자인 세팅
    */
   	function initSheet1(sheetObj) {
   		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
   			if ( i==1 ) {
   				sheetObj.CellValue2(i,"div_nm") =  "Limited Q'TY";
   				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
   				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
   			}
   			if ( i==2 ) {
   				sheetObj.CellValue2(i,"div_nm") =  "Execpted Q'TY";
   				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
   				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
   			}
   			if ( i==3 ) {
   				sheetObj.CellValue2(i,"div_nm") =  "Packing Instruction";
   				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
   				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
   			}
   			if ( i==4 ) {
   				sheetObj.CellValue2(i,"div_nm") =  "Special Pack. Inst.";
   				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
   				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
   			}
   			if ( i==5 ) {
   				sheetObj.CellValue2(i,"div_nm") =  "Others";
   				sheetObj.CellValue2(i,"max_wgt_nm") =  "Max Weight";
   				sheetObj.CellValue2(i,"pkg_tp_nm") =  "PKG Type";
   				sheetObj.SetMergeCell (i, 2, 1, 5);
   			}
   	   		sheetObj.RowMerge(i) = true;
   	   		sheetObj.RowHeight(i) = 20;
   	   		
	   	   	setLeftFontColor(sheetObj);
   	   	}
   	}
        
    /**
     * left폰트 변경
     */
	function setLeftFontColor(sheetObj) {
		for ( var i=1; i<=sheetObj.rowCount; i++ ) {
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		if ( j ==1 || j ==3  || j ==5) {
		   			sheetObj.CellAlign(i,j) = daCenter;
				   	sheetObj.CellFont("FontBold", i,j) = true;
				   	sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#F6FAFB");
		   		}
		   		if(sheetObj.CellValue(i,j) == "Invalid"){
  		   			sheetObj.CellFontColor(i,j) = sheetObj.RgbColor(255, 0, 0);
  		   			sheetObj.CellFont("FontBold", i,j) = true;
  		   		}
		   		sheetObj.CellEditable(i,j) = false;
		   	}
		}
	}
     
     /**
      * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
      * @param {sheetObj} String : 해당 IBSheet셀
      * @param {Row} Long : 해당 셀의 Row Index
      * @param {Col} Long : 해당 셀의 Column Index
      * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
      * @param {CellX} Long : 해당셀의 X좌표
      * @param {CellY} Long : 해당셀의 Y좌표
      * @param {CellW} Long : 해당셀의 가로 넓이값
      * @param {CellH} Long : 해당셀의 세로 높이값
      */
     function t1sheet2_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {  	 
    	 with(sheetObj){
 				 if(ColSaveName(Col) == "invld_desc"){
 					var sUrl    = '/hanjin/VOP_SCG_0001.do';
 					var iWidth  = 1070;
 					var iHeight = 530;
 					var sTargetObjList = "";
 					var sDisplay = "0,1";
 				   	var param = "?imdg_un_no="+document.form.imdg_un_no.value
 				   				+"&imdg_un_no_seq="+document.form.imdg_un_no_seq.value
 				   				+"&popflag=1";
 					ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
 				 }
    	 }
     }     
     
     function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
     {
    	 setLeftFontColor(sheetObj);
     }
	
    /**
     * sheet1 배경색 변경
     */
	function chgBackColor(sheetObj) {
	   	for ( var i=1; i<=sheetObj.rowCount; i++ ) {
	   		sheetObj.RowStatus(i) = "R";
	   		sheetObj.CellEditable(i,"g_total") = false;
	   		sheetObj.CellEditable(i,"d_total") = false;
	   		sheetObj.CellEditable(i,"s_total") = false;
	   	
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		if ( i != 14  || i !=25 || i !=36 ) {
			   		if ( j !=0 ) {
				   		if ( i>=3 && i <=7 || i>=16 && i <=19 || i>=27 && i <=30 || i>=38 && i <=41 ) {
				   			sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#F6FAFB");
				   		} else if  ( i>=8 && i <=12 || i>=20 && i <=23 || i>=31 && i <=34 || i>=42 && i <=45 ) { 
				   			sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#FFEAEA");
				   		} else if  ( i==13 || i==24  || i==35  || i==46 ) { 
				   			sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#D0EC7F");
				   		} else {
				   			sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(255,255,255);
				   		}
			   		} else {
			   			sheetObj.CellFontColor(i,"yyyy_ww") = sheetObj.RgbColor(0,0,1);
			   			sheetObj.CellBackColor(i,"yyyy_ww") = sheetObj.RgbColor(255,255,255);
			   		}
		   		} else {
		   			sheetObj.RowBackColor(i) = sheetObj.HeadBackColor;
		   		}
		   	}
		   	
   			sheetObj.CellBackColor(14,"g_total") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(14,"yyyy_ww") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(14,"title") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(14,"item") = sheetObj.HeadBackColor;
		   	sheetObj.RowBackColor(14) = sheetObj.HeadBackColor;
		   	
   			sheetObj.CellBackColor(25,"yyyy_ww") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(25,"title") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(25,"item") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(25,"g_total") = sheetObj.HeadBackColor;
		   	sheetObj.RowBackColor(25) = sheetObj.HeadBackColor;
		   	
   			sheetObj.CellBackColor(36,"yyyy_ww") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(36,"title") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(36,"item") = sheetObj.HeadBackColor;
   			sheetObj.CellBackColor(36,"g_total") = sheetObj.HeadBackColor;
		   	sheetObj.RowBackColor(36) = sheetObj.HeadBackColor;		   	
	   	}
	}
     
  // 업무 자바스크립트 OnKeyUp 이벤트 처리
     function obj_keyup() {  
     	var sheetObj = sheetObjects[1];
     	with(event.srcElement) {
 	    	switch(name) { 
 	    		case "grs_wgt":	case "net_wgt":	case "grs_capa_qty":
 	    			var wgtVal  = ComGetObjValue(eval("document.form."+name));
 	        		var wgtVals = wgtVal.split("."); 
 	        		if(wgtVals.length > 1 && wgtVals[1].length > 3) {
 	        			wgtVal = wgtVal.substring(0,wgtVal.length-1);
 	        			ComSetObjValue(eval("document.form."+name), wgtVal);
 	        		}
//         			if(wgtVals[0].length > 15) {
//         				wgtVal = wgtVals[0].substring(0,wgtVals[0].length-1);
//         				if(wgtVals.length > 1) wgtVal = wgtVal + "." + wgtVals[1];
//         				ComSetObjValue(eval("document.form."+name), wgtVal);
//         			}
//         			var objMaxLength = ComReplaceStr(wgtVal.replace('.',''),',','').length;
//         			if(objMaxLength == 18) {
//         				if(name == 'grs_wgt') ComSetNextFocus(document.form.net_wgt);
//         				else ComSetNextFocus(document.form.prp_shp_nm);
//         			}

 		        	break;
 		        default:
 		        	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
 		        
 		        	break;
 	    	}
     	}
     }
     
     // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
     function obj_nextfocus(obj) {
     	var objMaxLength = obj.getAttribute("maxlength");
     	var objValue 	 = obj.getAttribute("value");
     	
     	if (ComChkLen(objValue, objMaxLength) == 2) {    		
     		if(obj.name == 'vsl_cd') {
     			ComSetObjValue(document.form.skd_voy_no, "");
     			ComSetObjValue(document.form.skd_dir_cd, "");
 			} else if(obj.name == 'skd_voy_no') {
 				ComSetObjValue(document.form.skd_dir_cd, "");
 			}
     		if(obj.name == 'skd_dir_cd' || obj.name == 'cgo_opr_cd') {
     			obj.blur();
     		} else {
     			ComSetNextFocus(obj);
     		}
     	}
     }
     
     /**
      * Gross/Net Weight의 입력값 체크
      */
     function chkGrossNetWeight(obj) {
     	if((document.form.grs_wgt.value !='' && document.form.grs_wgt.value != 0) 
     		&& parseFloat(document.form.grs_wgt.value) < parseFloat(document.form.net_wgt.value)) {
 			ComAlertFocus(obj, "Net weight should be less than gross weight.");
 			obj.select();
 			
 			return false;
 		}
     	
     	return true;
     }
	/* 개발자 작업  끝 */