/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0589.js
*@FileTitle : User Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08 
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2011.11.08 정선용
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.11.23 김보배 [CHM-201221561] [BKG] User SMS Creation
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
     * @class esm_bkg_0589 : esm_bkg_0589 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0589() {
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
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;

 				case "btn_New":
 					sheetObject.RemoveAll();
 					ComResetAll();
 					break;
 				
 				case "btn_RowAdd":
 					doActionIBSheet(sheetObject, formObject, IBINSERT);  
 					break;
 					
 				case "btn_Delete":
 					sheetObject.CellValue2(sheetObject.SelectRow, "ibflag") = "D";
// 					sheetObject.RowHidden(sheetObject.SelectRow)  = true;
 					
 					//ComRowHideDelete(sheetObject, "del_chk");
 					break;
 				
 				case "btn_Save":
 					//if (sheetObjects[0].IsDataModified ) {
//					 var rowM = sheetObjects[0].ColValueDup("usr_id");
//					 if (rowM >= 0) {
//						 ComShowCodeMessage("BKG00827", "Sheet", rowM);
//					     return false;
//				    }	    		
 					//}
 					doActionIBSheet(sheetObject, formObject, IBSAVE);  
 					break;
 				case "btn_excel":
 					sheetObject.SpeedDown2Excel();
 					//sheetObject.Down2Excel();
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
 						
 						var HeadTitle = "|Seq.|Port|L/T|Lane Code|Direction|Office|User Name|User ID|E-Mail|File Attach|Office Phone No|Office fax No|Phone No|Update User|Update Date||";
 						var headCount = ComCountHeadTitle(HeadTitle);

 						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 						InitColumnInfo(headCount, 0, 0, true);
 						
 						// 해더에서 처리할 수 있는 각종 기능을 설정한다
 						InitHeadMode(true, true, false, true, false,false);
 						
 						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 						InitHeadRow(0, HeadTitle, true);
 						
 						//데이터속성    [ROW, 	COL,  	DATATYPE,	WIDTH, DATAALIGN, 	COLMERGE, SAVENAME, 	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						InitDataProperty(0, 	cnt++ , dtHiddenStatus,	 30,	daCenter,	 true,	"ibflag");
// 						InitDataProperty(0,		cnt++,	dtCheckBox,	 27, 	daCenter,	false,	"chk",      		false,		"",		dfNone,		0,		true);                    
 						InitDataProperty(0,		cnt++ , dtSeq,		 50, 	daCenter,	false,	"seq",				 true,		"",		dfNone,		0,		false,		 true);
 						InitDataProperty(0,		cnt++ , dtCombo,	 70,	daCenter,	false,	"port_cd",	         true,		"",		dfNone,	    0,		false,		 true,	5);
 						InitDataProperty(0,		cnt++ , dtCombo,	 70,	daCenter,	false,	"locl_ts_ind_cd",	 true,		"",		dfNone,	    0,		false,		 true,	1);
 						InitDataProperty(0,		cnt++ , dtData,		100,	daCenter,	false,	"slan_cd",			 true,		"",		dfEngUpKey,	0,		false,		 true,	3);
 						InitDataProperty(0,		cnt++ , dtData,		100,	daCenter,	false,	"dir_cd",			 true,		"",		dfEngUpKey,	0,		false,		 true,	1);
 						InitDataProperty(0,		cnt++ , dtData,		100,	daCenter,	false,	"ofc_cd", 	         true,		"",		dfNone,		0,		false,		false);
 						InitDataProperty(0,		cnt++ , dtData,		120,	daCenter,	false,	"rcvr_usr_nm",		 true,		"",		dfNone,		0,		 true,		 true);
 						InitDataProperty(0,		cnt++ , dtData,		120,	daCenter,	false,	"rcvr_usr_id",		 true,		"",		dfNone,		0,		 true,		 true);
 						InitDataProperty(0,		cnt++ , dtData,		150,	daCenter,	false,	"rcvr_eml",			 true,		"",		dfNone,		0,		 true,		 true);
 						InitDataProperty(0,		cnt++ , dtCheckBox,	100,	daCenter,	false,	"file_atch_flg",	 true,		"",		dfNone,		0,		 true,		 true);
 						InitDataProperty(0,		cnt++ , dtData,		150,	daCenter,	false,	"ofc_phn_no",		 true,		"",		dfNone,		0,		 true,		 true);
 						InitDataProperty(0,		cnt++ , dtData,		150,	daCenter,	false,	"ofc_fax_no",		 true,		"",		dfNone,		0,		 true,		 true);
 						InitDataProperty(0,		cnt++ , dtData,		150,	daCenter,	false,	"phn_no",			 true,		"",		dfNone,		0,		 true,		 true);
 						InitDataProperty(0,		cnt++ , dtData,		120,	daCenter,	false,	"upd_usr_id",		false,		"",		dfNone,		0,		false,		false);
 						InitDataProperty(0,		cnt++ , dtData,		120,	daCenter,	false,	"upd_dt",			false,		"",		dfDateYmd,	0,		false,		false);
 						InitDataProperty(0,		cnt++ , dtHidden,	140,	daCenter,	false,	"cre_seq",			false,		"",		dfNone,		0,		false,		 true);
 						InitDataProperty(0,		cnt++ , dtHidden,	140,	daCenter,	false,	"usr_nm",			false,		"",		dfNone,		0,		false,		 true);
 						
 						FocusEditMode = -1;
 						InitDataValid(0, "rcvr_eml", vtEngOther, "1234567890@_-.");
 						InitDataValid(0, "phn_no", vtNumericOther, "-");
 						InitDataValid(0, "ofc_phn_no", vtNumericOther, "-");
 						InitDataValid(0, "ofc_fax_no", vtNumericOther, "-");
 						InitDataValid(0,  "slan_cd", vtEngUpOther,	'0123456789');
 						InitDataValid(0,  "dir_cd", vtCharOnly,	'EWSN');
 						InitDataCombo(0,"port_cd","KRPUS|KRKAN|KRUSN|KRINC|KRPTK|KRGIN","KRPUS|KRKAN|KRUSN|KRINC|KRPTK|KRGIN");
 						//SelectionMode = smSelectionCol;
 						/*USER WORKING GROUP ==> 'S': Front Office FAX S/R BKG no. Match & Transfer, B/L Issue 담당,  
 												'I' : Doc Center INPUT 담당,  
 												'R' : Doc Center RATE 담당,  
 												'A' : Doc Center AUDIT 담당,  
 												'U' : Super User(ALL 기능담당 가능)*/
 						
 						/*CD01602
 						  USER POSITION ==> 'M': Manager, 
 										  'C' : Clerk 
						  CD01603	
						WORKING PART  ==> 담당 Part(일본지역/서남아지역/구주지역)(JP,PK,NL)
								-->담당 Part Code 일본지역 : JP, 서남아지역 : PK, 구주지역 : NL
						  
						  CD01604
						WORKING SERVER ==> 담당 Part Server ID (Routing에 사용)
								-->담당 Part Server ID (Routing에 사용) KOR, SWA, EUR
						*/
 	                   // InitDataCombo(0, "dpcs_wrk_grp_cd", " |Input|Rate|Audit|Super", " |I|R|A|U");
 						/*InitDataCombo(0, "Group", "F/OFC|Input|Rate|Audit|Super", "1|2|3|4|5");
 						InitDataCombo(0, "Position", "Clerk|Manage", "1|2");
 						InitDataCombo(0, "DocPart", "PK|JP|NL|DE", "1|2|3|4");*/
 	                    
 				}
 				break;


 			}
 	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

           case IBCLEAR: // 화면 로딩시 코드 조회
        	    formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0589GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.dir_cd, "val", "name");
				    ComXml2ComboItem(arrXml[1], formObj.locl_ts_ind_cd, "val", "name");
				formObj.dir_cd.InsertItem(0, 'All',' ');
				formObj.dir_cd.index = 0;
				formObj.locl_ts_ind_cd.InsertItem(0, 'All',' ');
				formObj.locl_ts_ind_cd.index = 0;

				setIBCombo(sheetObjects[0], arrXml[1], "locl_ts_ind_cd", false, "", "val","name","val");
//				if (arrXml.length > 2) 
//					setIBCombo(sheetObj, arrXml[2], "dpcs_wrk_grp_cd", true, "", "","","name");
//				if (arrXml.length > 1) 
//					setIBCombo(sheetObj, arrXml[1], "dpcs_wrk_prt_cd", true, "", "","","val");
//				if (arrXml.length > 0) 
//					setIBCombo(sheetObj, arrXml[0], "dpcs_psn_cd", true	, "", "","","name");
//					
				sheetObj.DataAutoTrim = true;	
				
        	   break;
           case IBSEARCH:      //조회
 	          if(validateForm(sheetObj,formObj,sAction))
// 	        	  if(!formObj.usr_id.value==""){
// 	        		 formObj.usr_id.value = formObj.usr_id.value.toUpperCase();
// 	        	  }
 	        	 formObj.f_cmd.value = SEARCH;
 	          	 sheetObj.DoSearch("ESM_BKG_0589GS.do", FormQueryString(formObj)
 					+ "&" + ComGetPrefixParam(""));
          
                 break;

 			case IBSAVE:        //저장
	 			if(validateForm(sheetObj,formObj,sAction)){
                    
//	 				if(!chkDuplicate()) return;
	 				
 					
	 				formObj.f_cmd.value = MULTI;
	  				sheetObj.DoSave("ESM_BKG_0589GS.do", FormQueryString(formObj));
	  				sheet1_OnSearchEnd(sheetObj, "");
	  				
	 			}

                 break;
 			case IBDELETE:        //저장
	 			if(validateForm(sheetObj,formObj,sAction)){
	 				formObj.f_cmd.value = MULTI;
	  				sheetObj.DoSave("ESM_BKG_0589GS.do", FormQueryString(formObj));
	 			}

                 break;     
 			case IBINSERT:      // 입력
				//신규행 추가
 				//sheetObj.DataInsert(-1);
// 				if(!checkOffice()) {
// 					return;
// 				}
 				if(sheetObj.RowCount("I") > 0) {
 					ComShowCodeMessage('BKG06098');
 					return;
 				}
 				sheetObj.DataInsert(-1);
 				//sheetObj.CellValue2(sheetObj.LastRow,"usr_id") = ComGetObjValue(formObj.strUsr_id);
 				sheetObj.CellValue2(sheetObj.LastRow ,"upd_usr_id") = ComGetObjValue(formObj.strUsr_id);
 				sheetObj.CellValue2(sheetObj.LastRow ,"ofc_cd") = ComGetObjValue(formObj.strOfc_cd);
// 				sheetObj.CellValue2(sheetObj.LastRow ,"cre_dt") = ComGetNowInfo();
// 				sheetObj.CellValue2(sheetObj.LastRow ,"upd_dt") = ComGetNowInfo();
// 				sheetObj.SelectCell(sheetObj.LastRow ,"usr_id");
 				if (sheetObj.CellValue(sheetObj.LastRow,"ofc_cd") == "SELSC" || sheetObj.CellValue(sheetObj.LastRow,"ofc_cd") == "PUSSC"
					  || sheetObj.CellValue(sheetObj.LastRow,"ofc_cd") == "PUSBO"|| sheetObj.CellValue(sheetObj.LastRow,"ofc_cd") == "PUSSC"){
 					  sheetObj.CellEditable(sheetObj.LastRow,"file_atch_flg") = true;
					  //CellEditable(i,"dpcs_wrk_grp_cd") = false;
				  } else{
					  sheetObj.CellEditable(sheetObj.LastRow,"file_atch_flg") = false;
					  
				  }
                 break;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){

         }
         
         return true;
     }
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		with(sheetObj){
 			  for (i=1; i<= LastRow; i++) {
 				  if (sheetObj.CellValue(i,"ofc_cd") == "SELSC" || sheetObj.CellValue(i,"ofc_cd") == "PUSSC"
 					  || sheetObj.CellValue(i,"ofc_cd") == "PUSBO"|| sheetObj.CellValue(i,"ofc_cd") == "PUSSC"){
					  CellEditable(i,"file_atch_flg") = true;
					  //CellEditable(i,"dpcs_wrk_grp_cd") = false;
 				  } else {
 					  CellEditable(i,"file_atch_flg") = false;
 					  
 				  }
 			  }
 		}
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
    		 var usr_id = sheetObj.CellValue(ix,"usr_id");
    		 if (sheetObj.RowStatus(ix) == "I" || sheetObj.RowStatus(ix) == "U"){
	    		 if(ComIsNull(usr_id) != true){
	    			 var findRow = sheetObj.FindText("usr_id",usr_id,0,2,false);
	    			 if(findRow > 0 && findRow != ix){
	    				 ComShowCodeMessage('BKG00827');
	    			 	 sheetObj.SelectCell(ix, "usr_id");   			 	 
	    			 	 return false ;
	    			 }
	    		 }
    		 }
    	 }
    	 return true;
     }
     
     function checkOffice() {
    	 var formObj = document.form;
    	 formObj.f_cmd.value = SEARCH02;
    	 var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0589GS.do", FormQueryString(formObj));
    	 var ofc_cnt = ComGetEtcData(sXml, "ofc_cnt");
		 if(ofc_cnt >= 6){
			 ComShowCodeMessage('BKG08216');
			return false;
		 }  
		 return true;
     }
     
     function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    		with (sheetObj) {
    			Row = MouseRow;
    			var colName = ColSaveName(MouseCol);
    			if ("rcvr_usr_id" == colName) {
    				MousePointer = "Hand";
    				sText = CellText(Row, "usr_nm");
    				MouseToolTipText = sText;
    			} else {
    				MouseToolTipText = "";
    			}
    		}
     }
     
     function sheet1_OnChange(sheetObj, Row, Col,Value){
    	 var formObj = document.form;
     	with (sheetObj) {
	        	 
	        	if (ColSaveName(Col) == "slan_cd") {
	        		formObj.chk_slan_cd.value = Value;
	        		
	        		if(sheetObj.CellValue(Row,"slan_cd")!="" && sheetObj.CellValue(Row,"dir_cd")!="" ){
	        			
	        			if(!checkOffice()) {
	        				CellValue2(Row,"slan_cd") = "";
	        			}
	        		}
	        	} else if (ColSaveName(Col) == "dir_cd") {
	        		formObj.chk_dir_cd.value = Value;
	        		if(sheetObj.CellValue(Row,"slan_cd")!="" && sheetObj.CellValue(Row,"dir_cd")!="" ){
	        			
	        			if(!checkOffice()) {
	        				CellValue2(Row,"dir_cd") = "";
	        			}
	        		}
	        	} else if(ColSaveName(Col) == "rcvr_eml") {
	        		if(!ComIsEmailAddr(Value)) {
	        			ComShowCodeMessage("BKG40021" , sheetObj.CellValue(Row,Col));
	        			CellValue2(Row,"rcvr_eml") = "";
		                sheetObj.SelectCell(Row, Col);
	        		}
	        	}	
     	}
      }
 	/*
 	* 그리드 선택 포커스 이벤트 
 	*/
 	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
 		with(sheetObj){  
 			if (ColSaveName(NewCol) =="dir_cd"){
 				if(OldRow == NewRow &&  CellValue(NewRow,"slan_cd") ==''){
 					SelectCell(NewRow,"slan_cd",false);
 				}
 			}
 		}
 	}
	/* 개발자 작업  끝 */