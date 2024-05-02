/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0214.js
*@FileTitle : Doc Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.21 김기종
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
     * @class ESM_BKG_0214 : ESM_BKG_0214 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0214() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setMainTableObject 	= setMainTableObject;
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
 var combo1 = null;
 var comboCnt = 0;
 
 var mainTableObjects = new Array();
 var mainTableCnt = 0;
  
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObjects[getActSheetIdx()], formObject, IBSEARCH);
 					break;
				break;
				
				case "btn_new":
					for(i=0;i<sheetObjects.length;i++){
						sheetObjects[i].RemoveAll();
					}
 					ComResetAll();
 					ComSetObjValue(formObject.fr_dt,ComGetNowInfo());
 			    	ComSetObjValue(formObject.to_dt,ComGetNowInfo());
				break; 
				
				case "btn_downexcel":
					if (ComGetObjValue(formObject.report_type)=="ofc"){
	            		doActionIBSheet(sheetObjects[getActSheetIdx()],formObject,IBDOWNEXCEL);
	            	}else if (ComGetObjValue(formObject.report_type)=="bl"){
	            		doActionIBSheet(sheetObjects[getActSheetIdx()+1],formObject,IBDOWNEXCEL);
	            	}
				break;
				
				case "btn_t1office":
					alert(srcName);
				break;				
 				
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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

     function setmainTableObject(mainTable_obj){
       	mainTableObjects[mainTableCnt++] = mainTable_obj;
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
		
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
         //IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
		    initCombo(comboObjects[k]);
		}
		//B/L List Sheet Table Visible 처리
		setSheetVisble(0);
        initControl();
 		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
 		setDocUser();

		document.all.item("lbPct").style.display = "block";
		document.all.item("lbEta").style.display = "none";
		document.all.item("lbGoto1").style.display = "none";
		document.all.item("lbGoto2").style.display = "none";
		document.all.item("lbCnee").style.display = "none";
		
     }
     
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects 배열에서 순번
      */
     function initControl() {
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "-";
     	
     	var formObject = document.form;
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
  	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     	combo1 = comboObjects[0];
 		comboCnt = comboObjects.length;
 	    
 	    ComSetObjValue(formObject.fr_dt,ComGetNowInfo());
    	ComSetObjValue(formObject.to_dt,ComGetNowInfo());    	
     }

     function setSheetVisble(inx){
    	// TABLE
    	for(var k=0; k< mainTable.length; k++){
 		    mainTable[k].style.display ="none";
 		}
    	mainTable[inx].style.display ="";
    	/* Pre-Auditing 항목만 PCT 항목 숨김 */
//    	if("Pre-Auditing" == tabObjects[0].TabText(inx)){
//    		sheetObjects[7].ColHidden("port_clz_dt") = true;
//    	}
    	/* Pre-Auditing 항목만 PCT 항목 숨김을 해제 하고 ETD, TVVD 사이로 변경 */
    	if("Pre-Auditing" == tabObjects[0].TabText(inx)){
    		if(sheetObjects[7].SaveNameCol("port_clz_dt") == 12){
    			sheetObjects[7].MoveColumnPos(12,8);
    		}
    	}

    	if("CNEE Code" == tabObjects[0].TabText(inx)){
			document.all.item("lbCnee").style.display = "block"; 	
			document.all.item("lbPct").style.display = "block";
			document.all.item("lbEta").style.display = "none";
			document.all.item("lbGoto1").style.display = "none";
			document.all.item("lbGoto2").style.display = "none"; 	
    	} else if("CNEE Code Accuracy" == tabObjects[0].TabText(inx)){
			document.all.item("lbPct").style.display = "none";
			document.all.item("lbEta").style.display = "block";
			document.all.item("lbGoto1").style.display = "block";
			document.all.item("lbGoto2").style.display = "block"; 
			document.all.item("lbCnee").style.display = "none"; 		
    	} else {
			document.all.item("lbPct").style.display = "block";
			document.all.item("lbEta").style.display = "none";   
			document.all.item("lbGoto1").style.display = "none"; 	
			document.all.item("lbGoto2").style.display = "none"; 	
			document.all.item("lbCnee").style.display = "none";	
    	}
     }
     
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
 		 var sheetID = sheetObj.id;
 		
 		if (sheetID == 't1sheet1' || sheetID == 't1sheet2' 
       	 || sheetID == 't1sheet3' || sheetID == 't1sheet4' || sheetID == 't1sheet5' 
         || sheetID == 't1sheet6' || sheetID == 't1sheet7' ){
 			
                with (sheetObj) {
	                  	
					// 높이 설정
					style.height = 320;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					var HeadTitle1 = "||Region|GSO|B.Office|Count|Ratio";
	
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		"Status");
					InitDataProperty(0, cnt++ , dtRadioCheck,	30,		daCenter,	false,		"Radio",			false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"region",			false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		"gso",				false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,		"bkg_ofc_cd",		false,		"",	dfNone,		0,		false,		false);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"ofc_cnt",			false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,		"ratio",			false,		"",	dfNone,		0,		false,		false);
					
                }
                return;
         }
         
         if ( sheetID == 't1sheet8' 
        	 || sheetID == 't1sheet9' || sheetID == 't1sheet10' || sheetID == 't1sheet11' 
        	 || sheetID == 't1sheet12'|| sheetID == 't1sheet13' || sheetID == 't1sheet14'){
         }else{
        	 return;
         }
            
         
         var tabColTitle = "";
//         alert(sheetID);
         switch(sheetID) {
          
         /* 
         	case "t1sheet7":
         		tabColTitle = "Contract|ETD";
         		break;
         	case "t1sheet8":
         		tabColTitle = "BKG STS|ETD";
         		break;
         	case "t1sheet9":
         		tabColTitle = "CNTR|ETD";
         		break;
         	case "t1sheet10":
         		tabColTitle = "CNEE|ETD";
         		break;
         	case "t1sheet11":
         		tabColTitle = "RATE|ETD";
         		break;
         	case "t1sheet12":
         		tabColTitle = "RELEASE|ETA";
         		break;
          */	
        	case "t1sheet8":
         		tabColTitle = "CNTR|ETD";
         		break;
         	case "t1sheet9":
         		tabColTitle = "CNEE|ETD";
         		break;
         	case "t1sheet10":
         		tabColTitle = "RATE|ETD";
         		break;
         	case "t1sheet11":
         		tabColTitle = "Pre-Auditing|ETD";
         		break;
        	case "t1sheet12":
         		tabColTitle = "Evaluation|ETA";
         		break;
         	case "t1sheet13":
         		tabColTitle = "RATE|ETD";
         		break;
         	case "t1sheet14":
         		tabColTitle = "RELEASE|ETA";
         		break;
         }		
      
         with (sheetObj) {
          	
			// 높이 설정
			style.height = 320;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle1 = ""; 
			if(sheetID == "t1sheet12"){
				HeadTitle1 = "|Seq.|Booking No|B/L No.|B.OFC|S.OFC|"+tabColTitle+"|T.VVD|Lane|POR|POL|POD|BDR|History|Validate Time";
			} else {
				HeadTitle1 = "|Seq.|Booking No|B/L No.|B.OFC|S.OFC|"+tabColTitle+"|T.VVD|Lane|POR|POL|POD|PCT|History|Batch Time";
			}

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);  


            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,	false,		"Status");
			InitDataProperty(0, cnt++, 	dtDataSeq,  			30,  	daCenter, 	true,  		"seq");
			InitDataProperty(0, cnt++ , dtData,					90,		daCenter,	false,		"bkg_no",   		false,		"",	dfNone,		0,		false,		false,	1);
			InitDataProperty(0, cnt++ , dtData,					85,		daLeft,		false,		"bl_no",  			false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,					55,		daCenter,	false,		"bkg_ofc_cd",  		false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"ob_sls_ofc_cd", 	false,		"",	dfNone,		0,		false,		false);
                                                                          
			InitDataProperty(0, cnt++ , dtData,					75,		daCenter,	false,		"bkg_sts",   		false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	false,		"docp_dt",			false,		"",	dfDateYmd,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	false,		"vvd_cd",			false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		"slan_cd",			false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"por_cd",			false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,					50,		daCenter,	false,		"pol_cd",			false,		"",	dfNone,		0,		false,		false);
                                                                          
			InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		"pod_cd",    		false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,				90,		daCenter,	false,		"port_clz_dt",    	false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,				120,	daCenter,	false,		"dpcs_smry_rmk",    false,		"",	dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,				90,		daCenter,	false,		"batch_dt",    		false,		"",	dfNone,		0,		false,		false);
			DataLinkMouse("bkg_no") = true;
			ColFontUnderline("bkg_no") = true;
        }
     }
     function getActSheetIdx(){
    	var index=tabObjects[0].SelectedIndex * 2;
    	return index;
     }
     function getClassBlList(){
    	var lsClass; 
    	/* 2011.01.21 유지훈씨 요청 Pre-Auditing 신규 추가 및 Container Confirm, CNEE Code, Rating 여부만 남겨둠 
         * 추후 다시 추가 될 가능성이 있어 삭제 하지 않음 
         */
    	/*
     	if (tabObjects[0].SelectedIndex == 0){
			lsClass = "4";
		}else if (tabObjects[0].SelectedIndex == 1){
			lsClass = "1";
		}else if (tabObjects[0].SelectedIndex == 2){
			lsClass = "6";
		}else if (tabObjects[0].SelectedIndex == 3){
			lsClass = "7";
		}else if (tabObjects[0].SelectedIndex == 4){
			lsClass = "2";
		}else if (tabObjects[0].SelectedIndex == 5){	
			lsClass = "3";
		}
		*/
     	if (tabObjects[0].SelectedIndex == 0){
			lsClass = "6";
		}else if (tabObjects[0].SelectedIndex == 1){
			lsClass = "7";
		}else if (tabObjects[0].SelectedIndex == 2){
			lsClass = "2";
		}else if (tabObjects[0].SelectedIndex == 3){
			lsClass = "9";
		}else if (tabObjects[0].SelectedIndex == 4){
			lsClass = "10";
		}
     	return lsClass;
     }
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         var lsClass;
         switch(sAction) {
         	case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0214GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) 
					ComXml2ComboItem(arrXml[0], formObj.region, "val", "val|val");
				     formObj.region.InsertItem(-1, '', '');
				//formObj.region.DropHeight = 150;
				formObj.region.index = 0;
				break;
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
           			formObj.f_cmd.value = SEARCH;
           			ComSetObjValue(formObj.class_type,getClassBlList());
           			sheetObjects[getActSheetIdx()+1].WaitImageVisible = false;
           			sheetObjects[getActSheetIdx()].WaitImageVisible = false;

           			ComOpenWait(true);  //대기이미지 표시
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0214GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					sheetObjects[getActSheetIdx()].RemoveAll();
					sheetObjects[getActSheetIdx()+1].RemoveAll();

					ComOpenWait(false); //대기이미지 숨김
					
//					if (arrXml.length > 1) 
//						sheetObjects[getActSheetIdx()+1].LoadSearchXml(arrXml[1]); 
					if (arrXml.length > 0) {
						sheetObjects[getActSheetIdx()].LoadSearchXml(arrXml[0]);
						if(sheetObjects[getActSheetIdx()].Rows > 0){
							t1sheet1_OnClick(sheetObjects[getActSheetIdx()], 1, 0, 0);
						}
					}
	          	} 
           		break;
			case IBROWSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
	       			formObj.f_cmd.value = SEARCH01;
	       			ComSetObjValue(formObj.class_type,getClassBlList());
	       			ComOpenWait(true);  //대기이미지 표시
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0214GS.do", FormQueryString(formObj));
					sheetObjects[getActSheetIdx()+1].RemoveAll();
					
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) 
						sheetObj.LoadSearchXml(arrXml[0]); 
					ComOpenWait(false); //대기이미지 숨김
	          	} 
	       		break;
			case IBDOWNEXCEL:      // 다운로드
   				sheetObj.SpeedDown2Excel(-1);
   				break;		
         }
     }
     
     function gotoCustCodeErrReport(){
	  	var sUrl = "/hanjin/alpsMain.screen";
	  	sUrl += "?parentPgmNo=ESM_BKG_M001";
	  	sUrl += "&pgmUrl=^hanjin^ESM_BKG_0941.do";
	  	sUrl += "&mainPage=true&pgmNo=ESM_BKG_0941";
		ComOpenWindowCenter(sUrl, "ESM_BKG_0941", 1024, 730, false, 'yes');
     }
     
 	 function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
 		var formObj = document.form;
 		
 		if (sheetObj.CellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.CellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.CellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet2_OnClick(sheetObj, Row, Col, Value) {
 		var formObj = document.form;
 		
 		if (sheetObj.CellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_gso_cd,"");
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.CellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.CellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet3_OnClick(sheetObj, Row, Col, Value) {
 		var formObj = document.form;
 		
 		if (sheetObj.CellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.CellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.CellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet4_OnClick(sheetObj, Row, Col, Value) {
 		var formObj = document.form;
 		
 		if (sheetObj.CellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.CellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.CellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet5_OnClick(sheetObj, Row, Col, Value) {
 		var formObj = document.form;
 		
 		if (sheetObj.CellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.CellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.CellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet6_OnClick(sheetObj, Row, Col, Value) {
 		var formObj = document.form;
 		
 		if (sheetObj.CellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.CellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.CellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet7_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet8_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet9_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet10_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet11_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet12_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet13_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
 	
 	function t1sheet7_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");
  	}
 	function t1sheet8_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");	 
  	}
 	function t1sheet9_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");	 
  	}
 	function t1sheet10_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");	 
  	}
 	function t1sheet11_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");	 
  	}
 	function t1sheet12_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no"); 
  	}
 	function t1sheet13_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no"); 
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
                     /* 2011.01.21 유지훈씨 요청 Pre-Auditing 신규 추가 및 Container Confirm, CNEE Code, Rating 여부만 남겨둠 
                      * 추후 다시 추가 될 가능성이 있어 삭제 하지 않음 
                      */
                     /*
                     InsertTab( cnt++ , "Contract No" , -1 );
                     //InsertTab( cnt++ , "TRO Confirm" , -1 );
                     InsertTab( cnt++ , "Booking Clearance" , -1 );
                     InsertTab( cnt++ , "Container Confirm" , -1 );
                     InsertTab( cnt++ , "CNEE Code" , -1 );
                     InsertTab( cnt++ , "Rating" , -1 );
                     InsertTab( cnt++ , "B/L Release" , -1 ); 
                     */
                     InsertTab( cnt++ , "Container Confirm" , -1 );
                     InsertTab( cnt++ , "CNEE Code" , -1 );
                     InsertTab( cnt++ , "Rating" , -1 );  
                     InsertTab( cnt++ , "Pre-Auditing", -1 );
                     InsertTab( cnt++ , "CNEE Code Accuracy", -1 );
                 }
              break;

          }
     }

     function tab1_OnClick(tabObj, nItem){
    	 setSheetVisble(nItem);
    	 //doActionIBSheet(sheetObjects[nItem+8],document.form,IBROWSEARCH);
     }
    
		
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
          	switch(sAction) {
 		     	case IBSEARCH: // 조회시 확인
 		     		
 			  		if (!ComChkValid(formObj)) return false;
 			  		
 			  		/*if (ComGetObjValue(formObj.search_opt) == "A" 
 			  			&& ComGetObjValue(formObj.bkg_ofc_cd) == "" 
						&& ComGetObjValue(formObj.ob_sls_ofc_cd)=="" 
							&& ComGetObjValue(formObj.gso)=="" ) {
       	
 			  			ComShowCodeMessage('BKG00626', '\n\n[GSO,Booking Office,Sales Office] , One must have value');
 			  			return false;
 			  		}*/
 			  		
 			  		if (!ComIsNull(formObj.fr_dt) 
 			  			&& !ComIsNull(formObj.to_dt) 
 			  			&& ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value) > 31){
		           		 
	         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
	         			formObj.fr_dt.focus();
	         			return false;
	         		}
 			  		
 			  		if(ComGetObjValue(formObj.fr_dt).substring(0,4) 
 			  				!= ComGetObjValue(formObj.to_dt).substring(0,4)
 	 			  			&& getClassBlList() == "9"){
	         			ComShowCodeMessage("BKG08250");//Pre-audit data for 2012 and 2013 cannot be searched together due to different evaluation logic.
	         			formObj.fr_dt.focus();
	         			return false;
 			  		} 
 			  		
 			  		if(ComGetObjValue(formObj.fr_dt).substring(0,4) < "2013" && formObj.bkg_no.value == ""
 			  			&& getClassBlList() == "10"){ 
 			  			
// 			  			booking no 도 체크가 안됐을 경우를 & 절로 넣어주기  
	         			ComShowCodeMessage("BKG08251");//Invalid ETA. Please insert the ETA from “2013-01-01
	         			formObj.fr_dt.focus();
	         			return false;			  			
 			  		}
 			  		break; 
          	}	
          }		
          return true;
     }
     /**
	  * 콤보 초기설정값
	  * @param {IBMultiCombo} comboObj  comboObj
	  */
	  function initCombo(comboObj) {
	  	comboObj.DropHeight = 220;
	  	MaxSelect = 0;
	  	
	  }  
	  
	  
	/**
	* from,to 기간 선택 달력 띄우기
	*/
	function callDatePop(val){
		var cal = new ComCalendarFromTo();
		if (val == 'BKG_DATE'){
		cal.select(form.fr_dt,  form.to_dt,  'yyyy-MM-dd');
		}
		
	}
	
	/**
     * 조회조건에 Search Key required clear
     */
	function clearKeyRequired(){
		var formObject = document.form;
		formObject.fr_dt.required = null;
		formObject.fr_dt.className = "input";
		
		formObject.to_dt.required = null;
		formObject.to_dt.className = "input";
		
		formObject.vvd_cd.required = null;
		formObject.vvd_cd.className = "input";   
		
		formObject.pol_cd.required = null;
		formObject.pol_cd.className = "input";
		
		formObject.bkg_ofc_cd.required = null;
		formObject.bkg_ofc_cd.className = "input";
		
		formObject.ob_sls_ofc_cd.required = null;
		formObject.ob_sls_ofc_cd.className = "input";
		
		formObject.gso.required = null;
		formObject.gso.className = "input";
		
		formObject.region.required = null;
		formObject.region.BackColor = "255,255,255" ;//"#ffffff";
		
		formObject.bkg_no.required = null;
		formObject.bkg_no.className = "input";
		
	}
	/**
     * 조회조건에 따른 Search Key 변경
     */
  	
  	function setSchKey(val){
  		var formObject = document.form;
  		
  		clearKeyRequired();
  		if (val == "A"){
			formObject.fr_dt.required = true;
			formObject.fr_dt.className = "input1";
			formObject.to_dt.required = true;
			formObject.to_dt.className = "input1";
			
			formObject.bkg_ofc_cd.className = "input1";
			formObject.ob_sls_ofc_cd.className = "input1";
			formObject.gso.className = "input1";
			//formObject.region.className = "input1";
			formObject.region.BackColor = "#CCFFFD" 
				//formObject.region.required = true;
				
			    ComSetObjValue(formObject.fr_dt,ComGetNowInfo());
	    	ComSetObjValue(formObject.to_dt,ComGetNowInfo());   
	    	formObject.region.index = 0;
			
  		}else if (val == "B"){
  			formObject.vvd_cd.required = true;
			formObject.vvd_cd.className = "input1";
  			formObject.pol_cd.required = true;
			formObject.pol_cd.className = "input1";
			formObject.region.index = 0;
  		}else if (val == "C"){
  			formObject.fr_dt.required = true;
			formObject.fr_dt.className = "input1";
			formObject.to_dt.required = true;
			formObject.to_dt.className = "input1";
			
			formObject.pol_cd.required = true;
			formObject.pol_cd.className = "input1";
			
		    ComSetObjValue(formObject.fr_dt,ComGetNowInfo());
	    	ComSetObjValue(formObject.to_dt,ComGetNowInfo());   
	    	formObject.region.index = 0;
	    	
  		}else if (val == "D"){
  			formObject.bkg_no.required = true;
			formObject.bkg_no.className = "input1";
			formObject.fr_dt.value ="";
			formObject.to_dt.value ="";
			formObject.region.value ="";
			formObject.region.index = 5;
  		}
  		
  	}
     /*
      * Login 한  User Check  
      */
    function setDocUser(){
    	
    	var input_text  ="";
     	var output_text ="";
     	
     	try{
		 		var param = param + "&f_cmd=" + SEARCH08 + "&input_text=" + input_text;
		 		var sXml = sheetObjects[1].GetSearchXml("ESM_Booking_UtilGS.do", param);
		 		output_text = ComGetEtcData(sXml, "output_text");
    		if ('Y' == output_text) {
    			for(i=1;i<sheetObjects.length;i++){
    				sheetObjects[i].ColHidden("port_clz_dt") = false;
        			sheetObjects[i].ColHidden("dpcs_smry_rmk") = false;
        			sheetObjects[i].ColHidden("batch_dt") = false;  				
    			}
    		}else{
    			for(i=1;i<sheetObjects.length;i++){
	    			sheetObjects[1].ColHidden("port_clz_dt") = true;
	    			sheetObjects[1].ColHidden("dpcs_smry_rmk") = true;
	    			sheetObjects[1].ColHidden("batch_dt") = true;
    			}
    		}
		
    	} catch (ex) {
    		ComShowCodeMessage("BKG00512");
    		return false;
    	}
    }
     
/*
  	 function obj_deactivate(){
  	     ComChkObjValid(event.srcElement);   // 포커스 나갈때 기간체크도 실시함..
  	 }
  	 
  	 function obj_activate(){
  	     ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기..
  	 }*/
	/* 개발자 작업  끝 */