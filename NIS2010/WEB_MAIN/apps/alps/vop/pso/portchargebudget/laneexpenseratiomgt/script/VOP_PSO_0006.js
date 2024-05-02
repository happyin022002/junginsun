/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0006.js
*@FileTitle : Lane/Port Expense Ratio Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.27 박명종
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 [CHM-201109292-01] Location 조회불가건 수정 보완 요청
* 2011.04.26 진마리아 [CHM-201110289-01] Lane/Port Expense Ratio Creation 조회 로직 변경 - Add Row 관련 수정 포함
* 2012.06.28 이준범 [CHM-201218449-01] Lane Expense Ratio 저장시 seq 로직 변경
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
     * @class VOP_PSO_0006 : VOP_PSO_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0006() {
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
   	/* 개발자 작업	*/
﻿// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

          case "btn_Retrieve":
		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		break;

          case "btn_new":
		sheetObject2.RemoveAll(); 
		break;

          case "btn_save":
		doActionIBSheet(sheetObject1,formObject,IBSAVE);
		break;

          case "btn_add":
        	  var rowIdx = sheetObject1.RowCount + sheetObject1.HeaderRows;
        	  if( rowIdx > sheetObject2.HeaderRows ) {
        		  if(sheetObject1.CellValue(sheetObject1.rowIdx, 3) == "" ){
        			  ComShowCodeMessage('PSO00001','');
        			  return;  
        		  }
        	  }
        	  doActionIBSheet(sheetObject1,formObject,IBINSERT);
        	  createSeq(sheetObject1, "sheet1_seq");
        	  break; 

          case "btn_del":
        	  ComRowHideDelete(sheetObject1, "sheet1_del_chk");
        	  sheetObjects[1].RemoveAll(); 
        	  createSeq(sheetObject1, "sheet1_seq");
        	  break;

          case "btn_add2":
        	  var max = 1;
        	  for( var i=sheetObject2.HeaderRows ; i < sheetObject2.RowCount+1 ; i++ ) {
        		  if( max <= eval(sheetObject2.CellValue( i , "sheet2_seq" )) && sheetObject2.CellValue( i , "sheet2_ibflag" ) != "D" )
        			  max = eval(sheetObject2.CellValue( i , "sheet2_seq" ))+1; 
        	  }

        	  sheetObject2.DataInsert(-1);
        	  sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_slan_cd" ) = sheetObject2.CellValue(sheetObject2.HeaderRows , "sheet2_slan_cd" );
        	  //sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_port_seq" ) = eval(sheetObject2.CellValue(sheetObject2.LastRow-1 , "sheet2_port_seq" ))+1;
        	  sheetObject2.CellValue2(sheetObject2.SelectRow, "sheet2_seq") = max;
        	  //jmh
        	  sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_rlane_cd") = "";
        	  sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_rlane_dir_cd") = "";
        	  sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_skd_dir_cd") = "";
        	  sheetObject2.CellValue2(sheetObject2.LastRow, "sheet2_loc_cd") = "";
//      	  sheetObject2.ReNumberSeq(); 
        	  createSeq(sheetObject2, "sheet2_seq");
        	  break;
						
          case "btn_insert2":
	        var selectRow = eval(sheetObject2.SelectRow);
          	//modifySeq(sheetObject2 , selectRow );
	        var max = 1;
			for( var i=sheetObject2.HeaderRows ; i < sheetObject2.RowCount+1 ; i++ ) {
				if( max <= eval(sheetObject2.CellValue( i , "sheet2_seq" )) && sheetObject2.CellValue( i , "sheet2_ibflag" ) != "D" )
					max = eval(sheetObject2.CellValue( i , "sheet2_seq" ))+1; 
			}
	
			sheetObject2.DataInsert();
			//sheetObject2.CellValue2(selectRow+1,3) = eval(sheetObject2.CellValue(selectRow,3))+1;
			sheetObject2.CellValue2(selectRow+1,10) = sheetObject2.CellValue(selectRow,10);
	        sheetObject2.CellValue2(selectRow+1, "sheet2_slan_cd" ) = sheetObject2.CellValue(sheetObject2.HeaderRows , "sheet2_slan_cd" );
			sheetObject2.CellValue2(sheetObject2.SelectRow, "sheet2_seq") = max;
	//		sheetObject2.ReNumberSeq(); 
	
	//		doActionIBSheet(sheetObject2,formObject,IBINSERT3);
		
			createSeq(sheetObject2, "sheet2_seq");
		break; 
						
        case "btn_del2":
        	  var sRowStr = sheetObject2.FindCheckedRow(1);
        	  //deleteSeq(sheetObject2 , sRowStr );
        	  var delCnt = ComRowHideDelete(sheetObject2, "sheet2_del_chk");
        	  if(delCnt == 0) return;

        	  createSeq(sheetObject2, "sheet2_seq");
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

            //for(i=0;i<sheetObjects.length;i++){
            //}
            //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

			axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//	        initControl(sheetObjects[0]); 
        }



    /**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function initControl(sheetObj){
    	// Form 객체 선언
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
    

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
							style.height = 468;
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

							var HeadTitle1 = "||Seq.|Lane CD|Standard\nP/F SKD|Pendulum\nSVC Check|";
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, true, true, false,false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							var prefix = "sheet1_";

	            			//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
							InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk");
							InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		prefix+"seq",			false,		"",			dfNone,			0,		false,		false);
							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"vsl_slan_cd", 	true,		"", 		dfEngUpKey, 0,			false,		true , 		3, 			true);
							InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prefix+"pf_svc_tp_cd", 	true,		"", 		dfEngUpKey, 0,			false ,		false, 		4, 			false);
                            InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,		prefix+"pndlm_flg"     );
                            InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,		prefix+"skd_dir_cd"     );
							InitDataValid(0, prefix+"vsl_slan_cd", vtEngUpOnly);
							
							SelectionMode = smSelectionList; //추가       	                                                          
							
							InitDataValid(0, prefix+"vsl_slan_cd", vtEngUpOther, "0123456789");	//영대문자와 숫자만 입력 
							
						}
						break;

				case "sheet2":
					with (sheetObj) {
							// 높이 설정
							style.height = 468;
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

							var HeadTitle1 = "||Seq.|SEQ|Rev. Lane|Rev. \nDirection|Direction|Calling Port|I/B Ratio|O/B Ratio||||||";
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(false, true, true, true, false, false);

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							var prefix = "sheet2_";

	            			//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
							InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk");
							InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		prefix+"seq",			false,		"",			dfNone,			0,		false,		false);
							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		prefix+"port_seq",		false,		"", 		vtEngUpOnly, 	0,		false,		true , 		5 );
							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"rlane_cd",		false,		"", 		dfEngUpKey, 	0,		true,		true , 		5,		true );
							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"rlane_dir_cd",	false,		"", 		dfEngUpKey, 	0,		true,		true , 		1,		true );
							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"skd_dir_cd",	false,		"", 		dfEngUpKey, 	0,		false,		true , 		1,		true );
							InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		prefix+"loc_cd",		false,		"",			dfEngUpKey, 	0,		false,		true , 		5,		true );
							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"ib_rto",		false,		"",			dfNullInteger, 	0,		true,		true , 		3 );
							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"ob_rto",		false,		"",			dfNullInteger, 	0,		true,		true , 		3 );
							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		prefix+"slan_cd",		false,		"",			dfNone,			0,		true,		true);

							InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"port_seq_b",	false,		"",			dfNone,			0,		true,		true);
							InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"rlane_cd_b",	false,		"",			dfNone,			0,		true,		true);
							InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"rlane_dir_cd_b",false,		"",			dfNone,			0,		true,		true);
							InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"skd_dir_cd_b",	false,		"",			dfNone,			0,		true,		true);
							InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"loc_cd_b",		false,		"",			dfNone,			0,		true,		true);
							
							InitDataValid(0, prefix+"rlane_cd", vtEngUpOther, "0123456789");	//영대문자와 숫자만 입력
							InitDataValid(0, prefix+"rlane_dir_cd", vtEngUpOnly);
							InitDataValid(0, prefix+"skd_dir_cd", vtEngUpOnly);
							InitDataValid(0, prefix+"loc_cd", vtEngUpOther, "0123456789");
//							InitDataValid(0, prefix+"ib_rto", vtEngUpOnly);
//							InitDataValid(0, prefix+"rlane_cd", vtEngUpOnly);


							SelectionMode = smSelectionList; //추가
							
						}
						break;
						
												
        }
    }


      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction,etc) {
			sheetObj.ShowDebugMsg = false;
			var aryPrefix = new Array( "sheet1_", "sheet2_" );
			switch(sAction) {
				case IBSEARCH:      //조회
    	        sheetObjects[0].WaitImageVisible = false;
    	        ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("VOP_PSO_0006GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	//			sheetObjects[1].Redraw = false;   
	//			sheetObjects[1].RemoveAll(); 
				
	//			if( sheetObjects[1].RowCount == 0 )
				createSeq(sheetObjects[0], "sheet1_seq");
				ComOpenWait(false);
				sheet1_OnDblClick(sheetObjects[0], 1 , 3 );
					
				break;
				
				case IBSAVE:        //저장
					//2012.06.04 이준범 port_seq 재 채번				
					createSeq(sheetObjects[1], "sheet2_port_seq");
				
			  		formObj.f_cmd.value = MULTI;
		            if( !validateForm(sheetObj,formObj,sAction)) return;
					var sParam = ComGetSaveString(sheetObjects);
					if (sParam == "") return;
	    	        sheetObjects[0].WaitImageVisible = false;
	    	        ComOpenWait(true);
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
					var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0006GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);
					//sheetObjects[1].RemoveAll(); 
					ComOpenWait(false);
				break;
	 
	
				case IBINSERT:      // 입력
	                sheetObj.DataInsert(-1);
					sheetObjects[1].RemoveAll();
	            break;
	                	
	        	case IBINSERT2:      // 입력
	        		sheetObj.DataInsert(-1);
	        	break;
	        	
	        	case IBINSERT3:      // 입력
	        		sheetObject2.DataInsert();
	        	break;
	        	
//				case COMMAND01:      //RLANE
//					//formObj.f_cmd.value = COMMAND01;
//					//var param = "vsl_slan_cd=" + etc;
//					//var sXml = sheetObj.GetSearchXml("VOP_PSO_0006GS.do", param);
//					
//				break;
			}
        }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
    		 switch(sAction) {
    		 	case IBSAVE:

					//jmh
					for(i=sheetObjects[1].HeaderRows; i<sheetObjects[1].LastRow + 1; i++){
						
						 if(sheetObjects[1].RowStatus(i) == "D") continue;
						
						if(sheetObjects[1].CellValue(i, "sheet2_rlane_cd") == ""){
							ComShowCodeMessage('COM130403', " [Rev.Lane]");
							return;
						}
					}
					for(i=sheetObjects[1].HeaderRows; i<sheetObjects[1].LastRow + 1; i++){
						if(sheetObjects[1].RowStatus(i) == "D") continue;
						if(sheetObjects[1].CellValue(i, "sheet2_rlane_dir_cd") == ""){
							ComShowCodeMessage('COM130403', " [Rev. Direction]");
							return;
						}
					}
					for(i=sheetObjects[1].HeaderRows; i<sheetObjects[1].LastRow + 1; i++){
						if(sheetObjects[1].RowStatus(i) == "D") continue;
						if(sheetObjects[1].CellValue(i, "sheet2_skd_dir_cd") == ""){
							ComShowCodeMessage('COM130403', " [Direction]");
							return;
						}
					}
					for(i=sheetObjects[1].HeaderRows; i<sheetObjects[1].LastRow + 1; i++){
						if(sheetObjects[1].RowStatus(i) == "D") continue;
						if(sheetObjects[1].CellValue(i, "sheet2_loc_cd") == ""){
							ComShowCodeMessage('COM130403', " [Calling Port]");
							return;
						}
					}
					
					
					
    		 		
					for(i = sheetObjects[1].HeaderRows ; i < sheetObjects[1].LastRow+1 ; i++ ) {   		 
						if( sheetObjects[1].CellValue( i , "sheet2_rlane_cd_b") == "" && sheetObjects[1].CellValue( i , "sheet2_ibflag") != "D"){
							sheetObjects[1].RowStatus(i) = "I";
						}	
					}
					
					var prefix1 = "sheet1_";
					var dupRow1 = sheetObjects[0].ColValueDup(prefix1 + "vsl_slan_cd", false);
					if(dupRow1 != -1){
						ComShowCodeMessage('COM12115', dupRow1 + " Row");
						sheetObjects[0].selectRow = dupRow1;
						return false;
					}
					
					/*[2009.12.10:jmh] 중복체크 제거
					var prefix2 = "sheet2_";
					var dupRow2 = sheetObjects[1].ColValueDup(prefix2 + "rlane_cd" + "|" + prefix2 + "rlane_dir_cd" + "|" + prefix2 + "skd_dir_cd" + "|" + prefix2 + "loc_cd", false);
					if(dupRow2 != -1){
						ComShowCodeMessage('COM12115', dupRow2 + " Row");
						sheetObjects[1].selectRow = dupRow2;
						return false;
					}
					*/
           		break;
    		 }      
    	 }

        return true;
    }


/*********************************************/     
     
function sheet1_OnLoadFinish(sheetObj){
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
     
     	/**
         * IBSheet OnAfterEdit Event
         */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		var formObj = document.form;
		var prefix = "sheet1_";
		sheetObjects[1].RemoveAll();
		if(sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) == ""){
			return;
		}
		switch (sheetObj.ColSaveName(Col)) {
			case prefix + "vsl_slan_cd" :   
    	        sheetObjects[1].WaitImageVisible = false;
    	        ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST;
				var param = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
				param = param + "&vsl_slan_cd=" + sheetObj.CellValue(Row, Col); 
				sheetObjects[1].ReDraw = false;
				sheetObjects[1].DoSearch("VOP_PSO_0006GS.do",param);
				sheetObjects[1].ReDraw = true;
				ComOpenWait(false);
			break;
			case prefix + "pf_svc_tp_cd" :   
				if( sheetObj.CellValue(Row, 4) == '') return;
    	        sheetObjects[1].WaitImageVisible = false;
    	        ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST;
				var param = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
				param = param + "&vsl_slan_cd=" + sheetObj.CellValue(Row, Col-1); 
				sheetObjects[1].DoSearch("VOP_PSO_0006GS.do",param);
				ComOpenWait(false);
			break;
		}
	}	


         /**
          * IBSheet OnAfterEdit Event
          */
         function sheet1_OnChange(sheetObj,Row,Col) {
        	 var formObj = document.form;
        	 var prefix = "sheet1_";
        	 switch (sheetObj.ColSaveName(Col)) {
	        	 case prefix + "vsl_slan_cd" :   
	        		 var Row = sheetObj.ColValueDup(Col, false);
	        		 if( Row != -1 ){
	        			 ComShowCodeMessage('COM12115', Row + " Row");	//alert("중복된 코드가 있습니다.");
	        			 sheetObj.CellValue2(Row,Col) = "";
	        			 sheetObjects[0].selectRow = Row;
	        			 return;    	  		
	        		 }	
	
	        		 formObj.f_cmd.value = SEARCHLIST01;//2번으로 .. 
	        		 var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
	
	        		 param = param + "&vsl_slan_cd=" + sheetObj.CellValue(Row, Col); 
	        		 var sXml = sheetObj.GetSearchXml("VOP_PSO_0006GS.do", param );
	
	        		 var items = ComGetEtcData(sXml, "PfSvcTpCd");
	
	        		 sheetObj.CellValue2(Row,Col+1) = items;
	
	        		 if( items == "" ) {
	        			 
	        			 ComShowCodeMessage('COM132201', 'Lane Code');	//alert("등록되지 않은 Lane Code입니다.");
	        			 
	        			 sheetObj.CellValue2(Row,Col) = "";
	        		 } else {
	        			 sheet1_OnDblClick(sheetObj,Row,Col);
	        		 }		
	
	        		 break;
        	 }
         }
         
         /**
          * 수정시 seq를 생성
          */
         function modifySeq(sheetObj,Row) {
        	var prefix = "sheet2_";  
         	for(var i=Row+1 ; i < sheetObj.LastRow+1 ; i++ ){
         		if(sheetObj.CellValue(i, 3) == '1'){
         			break;
         		}
         		sheetObj.CellValue2(i,3) = eval(sheetObj.CellValue(i,3))+1;	
         	}	
        }

         /**
          *  삭제시 seq를 생성
          */
         function deleteSeq(sheetObj,sRowStr) {
         	var arrRow = sRowStr.split("|");
         	
         	if( arrRow.length == 2) {
	         	var row = eval(arrRow[0]);
	         	for(var j=row+1 ; j < sheetObj.LastRow+1 ; j++ ){
	         		if( sheetObj.CellValue(j, 3) == '1' ){
	         			i++;
	         			break;
	         		}
	         		
         			sheetObj.CellValue2(j,3) = eval(sheetObj.CellValue(j,3))-1;	
	         	}	
         	} else {	
	         	for(var i= 0 ; i < arrRow.length-1 ; i++) {
	         		var row = eval(arrRow[i]);
		         	
		         	for(var j=row+1 ; j < sheetObj.LastRow+1 ; j++ ){
		         		//if( sheetObj.CellValue(j, 0)
		         		if( sheetObj.CellValue(j, 3) == '1' ){
		         			break;;
		         		}
		         		else{
		         			sheetObj.CellValue2(j,3) = eval(sheetObj.CellValue(j,3))- 1;
	         			}	
		         	}	
	        	}
         	}
        }

		/**
		 *  삭제시 seq를 생성
		 */
		function createSeq(sheetObj, colName){
			 var xxx = "";
			 var prefix = "sheet2_";
			 var k = 0;
			 for(i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
				 if(sheetObj.RowStatus(i) != "D"){
					 k++;
					 sheetObj.CellValue2(i, colName) = k;
				 }
			 }
			 sheetObj.Redraw = true;
		}


		 /**
          * IBSheet OnSearchEnd Event
          */
         function sheet2_OnSearchEnd(sheetObj,ErrMsg) {

         	for(var i=sheetObj.HeaderRows ; i < sheetObj.LastRow+1 ; i++ ){
				sheetObj.CellValue2( i , "sheet2_seq" ) = i;
         		if( sheetObj.CellValue(i, 8) == 100 ){
         			sheetObj.CellEditable(i, 9) = false; 
         		}	

         		if( sheetObj.CellValue(i, 9) == 100 )
         			sheetObj.CellEditable(i, 8) = false; 
         	}
        }
        
        
        /**
         * IBSheet OnAfterEdit Event
         */
         function sheet2_OnAfterEdit(sheetObj,Row,Col) {
		var prefix = "sheet2_";
                switch (sheetObj.ColSaveName(Col)) {
             		case prefix + "ib_rto" :           
               			if( sheetObj.CellValue(Row,Col) == 100 ){
               			     sheetObj.CellValue2(Row, 9) = 0;
               			     sheetObj.CellEditable(Row, 9) = false;
               			} else if( sheetObj.CellValue(Row,Col) != 0 && sheetObj.CellValue(Row,Col) != 50 ){
               				 ComShowCodeMessage("PSO00026", "0,50,100");	//alert("0,50,100만 입력해주세요.");
               				 sheetObj.CellValue2(Row, Col) = "";
               				 sheetObj.SelectCell( Row , Col , true);
               				 sheetObj.CellEditable(Row, 9) = true;
               			} else {      
               			     sheetObj.CellEditable(Row, 9) = true;
               			}     
                	break;
             		case prefix + "ob_rto" :           
               			if( sheetObj.CellValue(Row,Col) == 100 ){
               			     sheetObj.CellValue2(Row, 8) = 0;	
               			     sheetObj.CellEditable(Row, 8) = false;
               			} else if( sheetObj.CellValue(Row,Col) != 0 && sheetObj.CellValue(Row,Col) != 50 ){
               				 ComShowCodeMessage("PSO00026", "0,50,100");	//alert("0,50,100만 입력해주세요.");
               				 sheetObj.CellValue2(Row, Col) = "";
               				 sheetObj.SelectCell( Row , Col , true);
               				 sheetObj.CellEditable(Row, 8) = true;
               			} else {      
               			     sheetObj.CellEditable(Row, 8) = true;
               			}     
                	break;
             	}
         }


   		function sheet1_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift){ 
			var prefix = sheetObj.id + "_";
			var formObj = document.form;
			if(Col == 3){
				
				var tempVal = sheetObj.EditValue;
				if(tempVal.length == 3){
					sheetObj.SelectCell( Row , Col+1 , true);
				}
			}
		}	
		         

   		function sheet2_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift){
			var prefix = sheetObj.id + "_";
			var formObj = document.form;
			if(Col == 4){
				var tempVal = sheetObj.EditValue;
				if(tempVal.length == 5){ 
					//doActionIBSheet(sheetObj,formObj,COMMAND01);
					formObj.f_cmd.value = COMMAND01;
					var param = "f_cmd=" + COMMAND01 + "&vsl_slan_cd=" + tempVal;
					var sXml = sheetObj.GetSearchXml("VOP_PSO_0006GS.do", param);
					var isLane = ComGetEtcData(sXml, "isLane");
					if(isLane != "Y"){
						ComShowCodeMessage('PSO00014', '[Rev.Lane]');
						sheetObj.CellValue2(Row, Col) = "";
						return;
					}
						
					sheetObj.SelectCell( Row , Col+1 , true);
				}
			} else if(Col == 5){
				var tempVal = sheetObj.EditValue;
				if(tempVal.length == 1){
					sheetObj.SelectCell( Row , Col+1 , true);
				}
			} else if(Col == 6){
				var tempVal = sheetObj.EditValue;
				if(tempVal.length == 1){
					sheetObj.SelectCell( Row , Col+1 , true);
				}
			} else if(Col == 7){
				var tempVal = sheetObj.EditValue;
				if(tempVal.length == 5){
					if( checkYard( Row,Col , tempVal) ) {
						sheetObj.SelectCell( Row , Col+1 , true);
					} else {
						ComShowCodeMessage("PSO00001");	//Invalid Data
						sheetObj.CellValue2(Row, Col) = "";	
						sheetObj.SelectCell( Row , Col , true);
					}	
				}
			} else if(Col == 8){
				var tempVal = sheetObj.EditValue;
				if( parseInt(tempVal) < 0 ||  parseInt(tempVal) > 100 ){
					ComShowCodeMessage("PSO00001");	//Invalid Data
					sheetObj.CellValue2(Row, Col) = "";	
					sheetObj.SelectCell( Row , Col , true);
				}
				if(tempVal.length == 3 && tempVal == 100 ){
					sheetObj.SelectCell( Row , Col+1 , true);
				}
			} else if(Col == 9){
				var tempVal = sheetObj.EditValue;
				if( parseInt(tempVal) < 0 ||  parseInt(tempVal) > 100 ){
					ComShowCodeMessage("PSO00001");	//Invalid Data
					sheetObj.CellValue2(Row, Col) = "";	
					sheetObj.SelectCell( Row , Col , true);
				}
			}
		}				

		/**
         * IBSheet OnAfterEdit Event
         */
         function checkYard( Row,Col , yardValue) {
         	 var sheetObj = sheetObjects[0];
         	 var formObj = document.form;
        	 var prefix = "sheet1_";

     	  	formObj.f_cmd.value = SEARCHLIST;//2번으로 .. 
             	var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
             	param = param + "&yd_cd1=" + yardValue; 

    	  	//2번으로 .. 
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0001GS.do", param );
			
			var comboItems = ComGetEtcData(sXml, "lane");
			
			if( comboItems == "" )
				return false;
			return true;	
		}	
        

         function checkVvd( Row,Col,yardValue ) {
         	 var sheetObj = sheetObjects[0];
         	 var formObj = document.form;
        	 var prefix = "sheet1_";
     	  	formObj.f_cmd.value = SEARCHLIST;//2번으로 .. 
             	var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
             	param = param + "&yd_cd1=" + yardValue; 

    	  	//2번으로 .. 
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0001GS.do", param );
			
			var comboItems = ComGetEtcData(sXml, "lane");
			
			if( comboItems == "" )
				return false;
			return true;	
		}	

        
 	/* 개발자 작업  끝 */