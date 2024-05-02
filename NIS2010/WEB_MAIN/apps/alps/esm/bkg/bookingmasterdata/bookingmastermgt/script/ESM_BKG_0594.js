/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0594.js
*@FileTitle : Cargo Closing Time Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28 
*@LastModifier : 오동현
*@LastVersion : 1.0
* 2013.01.28 오동현
* 1.0 Creation
* -------------------------------------------------------
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
     * @class esm_bkg_0594 : esm_bkg_0594 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0594() {
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

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {

 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject, formObject, IBSEARCH);
 					break;

 				case "btn_New":
 					sheetObject.RemoveAll();
 					ComResetAll();
 					break;
 				
 				case "btn_RowAdd":
 					doActionIBSheet(sheetObject, formObject, IBINSERT);  
 					break; 					
 		
 				case "btn_Delete":
						doActionIBSheet(sheetObject, formObject, IBDELETE);
					break;				
 				
 				case "btn_Save":
 					doActionIBSheet(sheetObject, formObject, IBSAVE);
 					//doActionIBSheet(sheetObject, formObject, IBSEARCH);
 					break;
 				case "btn_excel":
 					sheetObject.SpeedDown2Excel();
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
         
         doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
         //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         initControl();	
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
     	var formObject = document.form;
     	
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	formObject.pol_cd.focus();
     }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
    	 var formObject = document.form;
         var cnt = 0;

 		switch(sheetNo) {
 			case 1:      //sheet1 init
 					with (sheetObj) {

 						// 높이 설정
 						style.height = 440;
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
 						
 						var HeadTitle = "|Del|Seq.|POL|Lane|BD|TIME(HR)|E-MAIL|SMS|SHPR PIC|BKG PIC|S/REP|OB PIC|E-MAIL|OFFICE TEL|MOBILE|AUTO Y/N";
 						var headCount = ComCountHeadTitle(HeadTitle);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);
 						
 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);
 						
 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle, true);
 						
 						//데이터속성    [ROW, 	COL,  	DATATYPE,	WIDTH, DATAALIGN, 	COLMERGE, SAVENAME, 	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0, 	cnt++ , dtHiddenStatus,	 30,	daCenter,	 true,	"ibflag");
 						InitDataProperty(0,		cnt++,	dtCheckBox,	 	 27, 	daCenter,	false,	"chk",      		 false,		"",		dfNone,		0,		true);                    
 						InitDataProperty(0,		cnt++ , dtSeq,		 	 50, 	daCenter,	false,	"seq",				 false,		"",		dfNone,		0,		false,		 true);
 						InitDataProperty(0,		cnt++ , dtData,			 70,	daCenter,	false,	"pol_cd",			 true,		"",		dfEngUpKey,	0,		false,		 true,	5);
 						InitDataProperty(0,		cnt++ , dtData,			 70,	daCenter,	false,	"lane_cd",			 true,		"",		dfEngUpKey,	0,		false,		 true,	3);
 						InitDataProperty(0,		cnt++ , dtData,			 50,	daCenter,	false,	"dir_cd", 	         true,		"",		dfEngUpKey,		0,		false,		 true,	1);
 						
 						InitDataProperty(0,		cnt++ , dtData,			 120,	daCenter,	true,	"cct_hrs",		 	 true,		"",		dfInteger,		0,		true,		 true,	3);
 						InitDataProperty(0,		cnt++ , dtCheckBox,		 80,	daCenter,	false,	"eml_snd_flg",		 false,		"",		dfNone,		0,		true,		 true);
 						InitDataProperty(0,		cnt++ , dtCheckBox,		 80,	daCenter,	false,	"mbl_snd_flg",		 false,		"",		dfNone,		0,		true,		 true);
 						InitDataProperty(0,		cnt++ , dtCheckBox,		 80,	daCenter,	false,	"shpr_ntc_flg",		 false,		"",		dfNone,		0,		true,		 true);
 						InitDataProperty(0,		cnt++ , dtCheckBox,		 80,	daCenter,	false,	"bkg_pic_ntc_flg",	 false,		"",		dfNone,		0,		true,		 true);
 						InitDataProperty(0,		cnt++ , dtCheckBox,		 80,	daCenter,	false,	"srep_ntc_flg",		 false,		"",		dfNone,		0,		true,		 true);
 						InitDataProperty(0,		cnt++ , dtCheckBox,		 80,	daCenter,	false,	"ob_pic_ntc_flg",	 false,		"",		dfNone,		0,		true,		 true);
 						InitDataProperty(0,		cnt++ , dtData,			 150,	daCenter,	false,	"cntc_eml",			 false,		"",		dfNone,		0,		true,		 true,	50);
 						InitDataProperty(0,		cnt++ , dtData,			 140,	daCenter,	false,	"ctrt_ofc_phn_no",	 false,		"",		dfNone,		0,		true,		 true,	20);
 						InitDataProperty(0,		cnt++ , dtData,			 140,	daCenter,	false,	"cntc_mphn_no",		 false,		"",		dfNone,		0,		true,		 true,	20);
 						InitDataProperty(0,		cnt++ , dtCheckBox,		 80,	daCenter,	false,	"auto_ntc_flg",		 false,		"",		dfNone,		0,		true,		 true);
 						
 						FocusEditMode = -1;
 						InitDataValid(0, "cntc_eml", vtEngOther, "1234567890@_-.");
 						InitDataValid(0, "ctrt_ofc_phn_no", vtNumericOther, "-");
 						InitDataValid(0, "cntc_mphn_no", vtNumericOther, "-");
 						InitDataValid(0, "lane_cd", vtEngUpOther,	'0123456789');
 						InitDataValid(0, "pol_cd", vtEngUpOther,	'');
 						InitDataValid(0, "dir_cd", vtCharOnly,	'EWSN');
 						//InitDataValid(0, "cct_hrs", vtNumericOther, "");
 						sheetObj.MinimumValue(0,"cct_hrs") = "-999";
 						sheetObj.MaximumValue(0,"cct_hrs") = "0";
 						
 	                    
 				}
 				break;


 			}
 	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

           case IBSEARCH:      //조회
 	          if(validateForm(sheetObj,formObj,sAction))
 	        	 formObj.f_cmd.value = SEARCH;
 	          	 sheetObj.DoSearch("ESM_BKG_0594GS.do", FormQueryString(formObj)
 					+ "&" + ComGetPrefixParam(""));
          
                 break;

 			case IBSAVE:        //저장
	 			if(validateForm(sheetObj,formObj,sAction)){
                    
	 				if(!chkDuplicate()) return;	 				
 					
	 				formObj.f_cmd.value = MULTI;
	  				sheetObj.DoSave("ESM_BKG_0594GS.do", FormQueryString(formObj));
	  				sheet1_OnSearchEnd(sheetObj, "");
	  				
	 			}

                 break;
                 
            case IBDELETE:      // 삭제
            	if (!validateForm(sheetObj, formObj, sAction))	return;
            	
            	if(ComShowCodeConfirm('BKG03037')){
					if(sheetObj.FindCheckedRow("chk")!= ""){
						ComRowHideDelete(sheetObj, "chk");
					}
				}
				break;
					
 	 
 			case IBINSERT:      // 입력
 				sheetObj.DataInsert(-1);
 				
                 break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         switch(sAction){
         	case IBDELETE : // Row Delete
				var sheet1RowCnt = sheetObj.RowCount;
			    var selCnt = 0;
			
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00389');
					return false;
				}

				for(var i=1; i<=sheet1RowCnt; i++) {
					
					if(sheetObj.CellValue(i, "chk") == 1) {
						selCnt++;
					}
					
					if(selCnt > 0) break;
				}
				
				if(selCnt == 0) {
					ComShowCodeMessage('BKG00442');
					return false;
				}
				
				break;

         }
         
         return true;
     }
     
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		/*with(sheetObj){
 			  for (i=1; i<= LastRow; i++) {
 				  if (sheetObj.CellValue(i,"dpcs_wrk_grp_cd") != ""){
					  CellEditable(i,"usr_id") = false;
					  //CellEditable(i,"dpcs_wrk_grp_cd") = false;
 				  }
 			  }
 		}*/
 	}
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	 
 	 	 if (ErrMsg == "") {
  	 		ComBkgSaveCompleted();  //서버메세지 처리
  	 		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		 } 	 	
      }
     
     function chkDuplicate(){
    	 var formObj = document.form;
    	 var cnt = sheetObjects[0].RowCount;
    	 var sheetObj = sheetObjects[0];
    	 for (var ix = 1; ix <= cnt; ix++ ){
    	 
    		 var pol_cd = sheetObj.CellValue(ix,"pol_cd");
    		 var lane_cd = sheetObj.CellValue(ix,"lane_cd");
    		 var dir_cd = sheetObj.CellValue(ix,"dir_cd");
    		
    		 var pol_lane = pol_cd + lane_cd + dir_cd;
    		 
    		  if (sheetObj.RowStatus(ix) == "I" || sheetObj.RowStatus(ix) == "U"){
	    		 for( var j = 1; j <= cnt; j++){
	    		 	var pol_cd2 = sheetObj.CellValue(j,"pol_cd");
    		 		var lane_cd2 = sheetObj.CellValue(j,"lane_cd");
    		 		var dir_cd2 = sheetObj.CellValue(j,"dir_cd");
    		 		var pol_lane2 = pol_cd2 + lane_cd2 +dir_cd2;
    		 		
    		 		if(ix != j && pol_lane == pol_lane2){
    		 			 ComShowCodeMessage('BKG03056',"POL: " + pol_cd + ", LANE: " + lane_cd + ", BD: " + dir_cd);
	    			 	 sheetObj.SelectCell(ix, "pol_cd");   			 	 
	    			 	 return false ;
    		 		}
	    		 }
    		 }
    		 
    	 }
    	 return true;
     }
     
	function sheet1_OnChange(sheetObj, Row, Col,Value){
    	 var formObj = document.form;
     	with (sheetObj) {
	        	 
	        	if (ColSaveName(Col) == "pol_cd") {
	        		formObj.chk_pol_cd.value = Value;
	        		if(sheetObj.CellValue(Row,"pol_cd")!=""){
	        			var pol_cd = sheetObj.CellValue(Row,"pol_cd");
	        			var lane_cd = sheetObj.CellValue(Row,"lane_cd");
	        			//var dir_cd = sheetObj.CellValue(Row,"dir_cd");
	        			if(!checkSetup(pol_cd, lane_cd)) {
	        				CellValue2(Row,"pol_cd") = "";
	        				sheetObj.SelectCell(Row, Col);
	        			}
	        		}
	        	} else if (ColSaveName(Col) == "lane_cd") {
	        		formObj.chk_lane_cd.value = Value;
	        		if(sheetObj.CellValue(Row,"lane_cd")!="" ){
	        			
	        			var pol_cd = sheetObj.CellValue(Row,"pol_cd");
	        			var lane_cd = sheetObj.CellValue(Row,"lane_cd");
	        			//var dir_cd = sheetObj.CellValue(Row,"dir_cd");
	        			//alert(lane_cd);
	        			if(!checkSetup(pol_cd, lane_cd)) {
	        				CellValue2(Row,"lane_cd") = "";
	        				sheetObj.SelectCell(Row, Col);
	        			}
	        		}
	        	} 
	        	
     		}
      }

	function checkSetup(pol_cd, lane_cd) {
		var formObj = document.form;
    	 formObj.f_cmd.value = SEARCH01;
    	
    	 var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0594GS.do", FormQueryString(formObj));
    	 var setup_cnt = ComGetEtcData(sXml, "setup_cnt");   
    	 var pol_cnt = ComGetEtcData(sXml, "pol_cnt"); 
    	 var lane_cnt = ComGetEtcData(sXml, "lane_cnt"); 
    	 var dir_cnt = ComGetEtcData(sXml, "dir_cnt"); 
 //  저장시에 validation 넣기로 함(onchange 쪽에서 validation 뺌).    	 
//		 if(setup_cnt >= 1){
//		 	ComShowCodeMessage('BKG03056',"POL: " + pol_cd + ", LANE: " + lane_cd + ", BD: " + dir_cd);			
//			return false;
//		 }
		 if(pol_cnt < 1 && pol_cd != ""){
		 	ComShowCodeMessage('BKG00993',"POL: " + pol_cd);			
			return false;
		 }
		 if(lane_cnt < 1 && lane_cd != ""){
		 	
		 	ComShowCodeMessage('BKG00993',"LANE: " + lane_cd);			
			return false;
		 }  
		 
		 return true;
     }
     

	/* 개발자 작업  끝 */