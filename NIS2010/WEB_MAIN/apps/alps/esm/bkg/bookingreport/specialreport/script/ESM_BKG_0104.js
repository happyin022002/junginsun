/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0104.js
*@FileTitle : Report Template
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* 2011.06.20 변종건 [CHM-201111601-01] VIP Report -조회조건추가 (RFA#컬럼 )
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
     * @extends 
     * @class esm_bkg_0104  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0104() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;    	
    }
    
   	/* 개발자 작업	*/
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var prefix = "";//IBSheet 구분자
 

 /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
 /*********************** EDTITABLE MULIT COMBO END ********************/
 	
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
	 	    setItemOptionHidden();//Item Option Hidden 처리
		    initControl();
		    //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		    //setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); },100);
		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 		
		    //form.cust_cnt_cd.focus();
		 		
     }
	
	 	
	
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }        
    function bkg_change(){   	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_bkg_rpt_knd_cd":
    			
    			setItemOptionHidden();
					break;
				default:
					break;
	    }
	    
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
    /*
     *  Report Kind가 Booking Status Report 이면 Item Option 을 감춤. 조회 칼럼이 고정임 
     */ 
    function setItemOptionHidden(){
    	if(form.p_bkg_rpt_knd_cd.value =="B"){
    				//sheetObjects[0].ColHidden(prefix + "item_option") = true;
    			}	else{
    				//sheetObjects[0].ColHidden(prefix + "item_option") = false;
    	}
    }   	
    
    
     /*
      * 조회 후 Type이 Common, Shared이면 Editable = false; 
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
      with (sheetObj) {
      		var blueColor = RgbColor(0, 0, 255);
   				var type_gubun;
	      	for (var i = HeaderRows; i < TotalRows + HeaderRows ; i++) {
		      		type_gubun = CellValue(i, prefix+"type_gubun");
		      		if( type_gubun == 'C' ){ // 'P'- Private , 'S' - Shared
		      			RowEditable(i) = false;
		      		}else{
		      			sheetObj.CellFontColor(i,prefix+"type_nm") = blueColor;
		      			sheetObj.CellFontUnderline(i,prefix+"type_nm") = true;
		      		}
		      			sheetObj.CellFontColor(i,prefix+"search_option") = blueColor;
		      			sheetObj.CellFontUnderline(i,prefix+"search_option") = true;
		      			
		      			sheetObj.CellFontColor(i,prefix+"item_option") = blueColor;
		      			sheetObj.CellFontUnderline(i,prefix+"item_option") = true;
	      	}
    	 }
     }


		/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
		    if(sheetObj.CellValue(rowIdx, prefix+"ibflag") =="D" || sheetObj.CellValue(rowIdx, prefix+"ibflag") =="I") return;
		    
     		if( colIdx == sheetObj.SaveNameCol(prefix + 	"type_nm")){
						//if(sheetObj.CellValue(rowIdx, prefix+"ibflag") == 'I' || sheetObj.CellValue(rowIdx, prefix+"type_gubun") !="P") return;
						
						var param= "?rpt_id="+sheetObj.CellValue(rowIdx, prefix+"rpt_id")+"&bkg_rpt_knd_cd="+form.p_bkg_rpt_knd_cd.value;
						if(sheetObj.CellValue(rowIdx, prefix+"ibflag") == 'I' || sheetObj.CellValue(rowIdx, prefix+"type_gubun") !="P"){
								param += "&edit_yn=N"; 
							}
						ComOpenPopup('/hanjin/ESM_BKG_0896.do'+param, 400, 250, '', '1,0,1,1,1,1,1,1,1,1', false,false,0,0,0,"Shared");			
						
     		}else if( colIdx == sheetObj.SaveNameCol(prefix + 	"search_option")){
     					//if(sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="C" || sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="S") return;
     					selectedIndex = rowIdx;
							var param= "?rpt_nm="+sheetObj.CellValue(rowIdx, prefix+"rpt_nm");
							if(sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="C" || sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="S"){
								param += "&edit_yn=N"; 
							}
							if(form.p_bkg_rpt_knd_cd.value == "V"){
	 							ComOpenPopup('/hanjin/ESM_BKG_0104_02.do'+param, 1010, 300, '', '1,0,1,1,1,1,1,1,1,1', false,false,0,0,0,"Search Option");
							}else if(form.p_bkg_rpt_knd_cd.value == "B"){
	 							ComOpenPopup('/hanjin/ESM_BKG_0104_01.do'+param, 1010, 640, '', '1,0,1,1,1,1,1,1,1,1', false,false,0,0,0,"Search Option");
							}else if(form.p_bkg_rpt_knd_cd.value == "L"){
	 							ComOpenPopup('/hanjin/ESM_BKG_0104_03.do'+param, 1010, 300, '', '1,0,1,1,1,1,1,1,1,1', false,false,0,0,0,"Search Option");
							}
     		}	else if( colIdx == sheetObj.SaveNameCol(prefix + 	"item_option")){
							//if(sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="C" || sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="S")return;
							 
							selectedIndex = rowIdx;
							var param= "?rpt_id="+sheetObj.CellValue(rowIdx, prefix+"rpt_id")+"&bkg_rpt_knd_cd="+form.p_bkg_rpt_knd_cd.value;
							
							if(sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="C" || sheetObj.CellValue(rowIdx, prefix+"type_gubun") =="S"){
								param += "&edit_yn=N"; 
							}
 							ComOpenPopup('/hanjin/ESM_BKG_0895.do'+param, 780, 640, '', '1,0,1,1,1,1,1,1,1,1', false,false,0,0,0,"Item Option");
     		}
     }				
				

   
  var selectedIndex;//선택된 Row Index
  /*
   * 팝업에서 변경된 검색조건을 세팅한다. 
   * */
	function setSearchOption(str){
		if(selectedIndex == null){
			return;
		}
		var temp;
		sheetObjects[0].CellValue(selectedIndex, prefix + 	"bzc_cond_sql_ctnt") = str;
		temp = sheetObjects[0].CellValue(selectedIndex, prefix + 	"bzc_cond_sql_ctnt");
		
	}
  /*
   * 팝업에서 변경된 검색조건을 저장한다. 
   * */
 function setSearchSaveOption(){
     var sheetObject1 = sheetObjects[0];
	 var formObject = document.form;
	 
	 	doActionIBSheet(sheetObject1,formObject,IBSAVE);
		if(opener == null || opener == undefined) return;	 					
		opener.location.reload();
 }
 
 function setTemplate(returnVal){
 		if(selectedIndex == null){
			return;
		}
		var temp="";
		sheetObjects[0].CellValue(selectedIndex, prefix + 	"modified_col_nm") = returnVal;
		temp = sheetObjects[0].CellValue(selectedIndex, prefix + 	"modified_col_nm");
		
 }
/*********************** KEY EVENT END ********************/

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
					
					var comboObject1 = comboObjects[0]; 
          /*******************************************************/
          var formObject = document.form;

	     	//try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 					
		 				case "btn_Save":
		 					saveValidFlag = true; //밸리데이트 초기화
		 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					break;
		 							 					
		 				case "btn_RowAdd":
		 					var addRow     = sheetObject1.RowCount+1;
			        //데이터 행 추가
			        var row = sheetObject1.DataInsert(addRow);
		 					sheetObject1.CellValue(row, prefix+"vis_flg")= 'Y';
		 					break;
		 				case "btn_RowDelete":
		 					ComRowHideDelete(sheetObject1,prefix+"del_chk");
		 					break;
		 				case "btn_New":
		 					form.reset();
		 					sheetObject1.RemoveAll();  
		 					break;
		 				case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				case "btn_Close":
							if(opener != undefined ){
								//opener.setParent();
							}		 				
		 					self.close();
		 					break;
		        } // end switch
//	     	}catch(e) {
//		     		if( e == "[object Error]") {
//		    			ComShowMessage(OBJECT_ERROR);
//		    		} else {
//		    			ComShowMessage(e);
//		    		}
//	     	}
	     	
	     	
    }
 
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				formObj.f_cmd.value = SEARCH;
								var sXml = sheetObj.DoSearch("ESM_BKG_0104GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
							
								break;
			 			case SEARCH01:      //조회
							break;

 						case IBSEARCHAPPEND:  // 페이징 조회
						case IBINSERT:      // 입력					
							//sheetObj.DataInsert(-1);
							var Row = sheetObj.DataInsert(-1);
							//sheetObj.CellValue2(Row, prefix + "type_nm") = "Private";
							sheetObj.CellValue2(Row, prefix + "search_option") = "Modify";
							sheetObj.CellValue2(Row, prefix + "item_option") = "Modify";
							
							break;
							
						case IBSAVE:        //저장
				 				formObj.f_cmd.value = MULTI;
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				
				 				var sParam = sheetObj.GetSaveString();
								if (!sheetObj.IsDataModified && sParam == "")	return;
								sParam += "&" + FormQueryString(formObj);
								var sXml = sheetObj.GetSaveXml("ESM_BKG_0104GS.do" , sParam);
								sheetObj.LoadSaveXml(sXml);
								//window.returnValue = true;
			 				break;									
			    }
     }
     

		 /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @version 2009.05.17
     */ 	
		function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
	 		var formObject = document.form;
	 		if (ErrMsg == "") {
				ComBkgSaveCompleted();
				opener.location.reload();
				sheetObj.RemoveAll();
				doActionIBSheet(sheetObj,formObject,IBSEARCH);
			}
		}    
		
 /*
  * 페이징 처리
  * */
  function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
     
  }    


   
   /*
    * Report Name 중복 체크
    * */
     function isRptNameDup(rowIdx,p_rpt_nm){
				with (sheetObjects[0]) {
	   				var rpt_nm;
		      	for (var i = HeaderRows; i < Rows  ; i++) {
		      		
		      			if(rowIdx == i) continue;
		      			if(CellValue(i, prefix+"ibflag") == 'D')	continue;
		      			
			      		rpt_nm = CellValue(i, prefix+"rpt_nm");
			      		if( rpt_nm == p_rpt_nm ){
			      			return true;
			      		}
		      	}
	    	 } 
	    	 
	    	return false;    			
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	  			break;
    		case IBSAVE:
    		
	    		with (sheetObj) {
			      	for (var i = HeaderRows; i < Rows  ; i++) {
			      		if(CellValue(i, prefix+"ibflag") == 'R' || CellValue(i, prefix+"ibflag") == 'D')	continue;
			      		
								if(CellValue(i, prefix + 	"rpt_nm")==""){
									ComShowCodeMessage("BKG00625"); 
		              sheetObj.SelectCell(i, prefix + 	"rpt_nm");
									return false;
								}else	if (isRptNameDup(i,CellValue(i,prefix + "rpt_nm")))  {
									ComShowCodeMessage("BKG03064",CellValue(i,prefix + "rpt_nm")); 
		              sheetObj.SelectCell(i, prefix + 	"rpt_nm");
									return false;
								}
		        		
			      	}//end for
		    	 } //end with(sheetObject[0])
	    	 
	  			break;
    	 }
         return true;
     }
     


    
   

 /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
                 // 높이 설정
                 style.height = 282;
                 
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(1, 1, 15, 50);

		            var HeadTitle1 = "ibflag|rpt_id|type gubun|sel col_nm|modi col_nm|sql ctnt| Del. |Report Name|Type|Display|Search Option|Item Option";
		            
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                
               //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
              //InitDataProperty(0, cnt++ , dtSeq,					35,		daCenter,		false,		prefix + 	"Seq");
							InitDataProperty(0, cnt++ , dtHiddenStatus, 0,	daCenter,		true,		 prefix + "ibflag");                                                            
							/*********************  Hidden *******************/							
							InitDataProperty(0, cnt++ , dtHidden,		 	  20,	daCenter,		true,		 prefix + "rpt_id");
							InitDataProperty(0, cnt++ , dtHidden,		 	  20,	daCenter,		true,		 prefix + "type_gubun");
							
							InitDataProperty(0, cnt++ , dtHidden,		 	  20,	daCenter,		true,		 prefix + "selected_col_nm");
							InitDataProperty(0, cnt++ , dtHidden,		 	  20,	daCenter,		true,		 prefix + "modified_col_nm");
							InitDataProperty(0, cnt++ , dtHidden,		 	  20,	daCenter,		true,		 prefix + "bzc_cond_sql_ctnt");
							/*********************  Hidden data end *******************/
							
							InitDataProperty(0, cnt++ , dtDelCheck,		 	40,	daCenter,		true,		 prefix + "del_chk");
							 
							InitDataProperty(0, cnt++ , dtData,					210,	daLeft,		false,	 prefix + "rpt_nm",			    false,			"",      dfNone,			0,		true,		true,50);
							InitDataProperty(0, cnt++ , dtData,					190,	daLeft,	false,	 prefix + "type_nm",				false,			"",      dfNone,			0,		false,	false);
		
							InitDataProperty(0, cnt++ , dtCheckBox,			120,	daCenter,	false,   prefix + "vis_flg",		    false,			"",      dfNone,			0,		true,		true);
							InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	false,	 prefix + "search_option",	false,			"",      dfNone,			0,		false,	false);
							InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,	 prefix + "item_option",		false,			"",      dfNone,			0,		false,	false);
							
						//	if(form.p_bkg_rpt_knd_cd.value="B")
							//	ColHidden(prefix + "item_option") = true;							
               								
			 				CountPosition = 0;//[1/3] 페이지 위치 
 						}
 				
 					break;
         }
     }
    
      /* version up 2010.1.22 */
	/* 개발자 작업  끝 */    
										
		