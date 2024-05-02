/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6038.js
*@FileTitle : CMPB Guideline Creation - Commodity 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.09 이승준
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_pri_6038() {
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
 var enableFlag = true;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 /**
  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return 없음
  * @author 이승준
  * @version 2009.05.07
  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
//          var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
	            case "btn_Ok":
					if (validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						window.returnValue = "O";
						window.close();
					}	            	
	                break;
	            case "btn_Close":  
	            	window.returnValue = "C";
	            	if (sheetObject1.IsDataModified){
	            		if(ComShowCodeConfirm("PRI00006")){
	    					if (validateForm(sheetObject1,formObject,IBSAVE)) {
	    						doActionIBSheet(sheetObject1,formObject,IBSAVE);
	    						window.returnValue = "O";
	    						window.close();
	    					}else{
	    						return;
	    					}
	            		}
	            	}
					window.close();
	                break;
	            case "btn_RowAdd":
					if (validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;		            	
	            case "btn_RowDel":
					if (validateForm(sheetObject1,formObject,IBDELETE)) { 
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

     }


     /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
         
         
      }


     /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         var sheetID = sheetObj.id;
         switch(sheetID) {

              case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 280;
                     
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);

                     var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|CMDT Type|CMDT Code|Commodity Description|display_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false, false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
// 	  				  				  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//  	  				  			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
// 	  				  				  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,	daCenter,	false, "ibflag");
                     InitDataProperty(0, cnt++ , dtCheckBox,	 40,	daCenter,	false, "chk");
                     InitDataProperty(0, cnt++ , dtSeq,			 30,	daCenter,	false, "seq",				false,	"",	dfNone,	0,	true,	true);
                     
                     InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "svc_scp_cd", 	  	true, 	"", dfNone, 0,  false, false);
	   				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "cre_ofc_cd", 	  	true, 	"", dfNone, 0,  false, false);
	   				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "gline_seq", 	  	true, 	"", dfNone, 0,  false, false);
	   				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "prs_cust_tp_cd", 	true, 	"", dfNone, 0,  false, false);
	   				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "bse_seq", 		  	true, 	"", dfNone, 0,  false, false);
    				 InitDataProperty(0, cnt++,  dtHidden, 		 90, 	daLeft, 	false,  "cmdt_seq", 	  	true, 	"", dfNone, 0,  false, false);
    				
                     InitDataProperty(0, cnt++ , dtCombo,	  	 150,	daCenter,	false, "prc_cmdt_tp_cd",	true,	"",	dfNone,	0,	true,	true);
                     InitDataProperty(0, cnt++ , dtPopupEdit, 	 100,	daCenter,	false, "prc_cmdt_def_cd",	true,	"",	dfNone,	0,	true,	true, 6);
                     InitDataProperty(0, cnt++ , dtData,	  	 300,	daLeft,		false, "prc_cmdt_def_nm",	false,	"",	dfNone,	0,	false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,  	 90,  daCenter,		false, "display_seq",	 	false,  "",	dfNone,	0,	true,	true);               
 					 
 					 InitDataValid(0, "prc_cmdt_def_cd", vtEngOther,"0123456789");	// 영대문자,숫자만 입력
                     ShowButtonImage = 2;

 				 }
                 break;

         }
     }

     /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
          sheetObj.ShowDebugMsg = false;
          switch(sAction) {
 			case IBCLEAR: // 화면 로딩시 
 				var sXml = "";
 			
				//공통 cmdt type
 				sheetObj.InitDataCombo(0,"prc_cmdt_tp_cd", COMODITY_TYPE3[1], COMODITY_TYPE3[0], "", "R", 0); 			
//				formObj.f_cmd.value = SEARCH19;
//				formObj.cd.value="CD01703";
//				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//				setIBCombo(sheetObj,sXml,"prc_cmdt_tp_cd",true,0);
				
 				break;
			case IBSEARCH:      //조회				
				var sXml = dialogArguments.getSheetXml(5);
				sheetObjects[0].LoadSearchXml(sXml);
				sheetRowHidden(sheetObjects[0]);
	         	break; 				
 			case IBINSERT:      // 입력
 			    //sheetObj.DataAutoTrim = false;
 		        var idx = sheetObj.DataInsert();		
 			
				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "cre_ofc_cd") = formObj.cre_ofc_cd.value;
				sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
				sheetObj.CellValue(idx, "prs_cust_tp_cd") = formObj.prs_cust_tp_cd.value;
				sheetObj.CellValue(idx, "bse_seq") = formObj.bse_seq.value;
				sheetObj.CellValue(idx, "cmdt_seq") = parseInt(ComPriGetMax(sheetObj, "cmdt_seq"))+ 1;
				
				sheetObj.SelectCell(idx, "prc_cmdt_def_cd", false);
			
 				break;
 			case IBDELETE: // Delete
 				
 				if (sheetObj.CheckedRows("chk") <= 0) {
 					sheetObj.RowDelete(sheetObj.SelectRow,false);
  	        	}
 				
				for(var i = sheetObj.LastRow; i >= sheetObj.HeaderRows; i--) {
					if(sheetObj.CellValue(i, "chk") == "1") {
						sheetObj.RowDelete(i,false);
					}
				}
 				
 				break;			
			case IBSAVE:        //저장	
        		//정렬 한 후 메인 페이지로 보낸다.
//				sheetObjects[0].ColumnSort("prc_cmdt_tp_cd|prc_cmdt_def_cd","ASC","DESC|ASC"); 
				//타입에 따라 display_seq 세팅
				setDisplaySeq (sheetObj);
				
				sheetObjects[0].ColumnSort("display_seq|prc_cmdt_def_cd","ASC","ASC|ASC",true); 
				
				// opener화면으로 sheet data 내리는 방법
//				if ( sheetObjects[0].RowCount != 0){
					var sXml = ComPriSheet2Xml(sheetObjects[0]);
					dialogArguments.setSheetXml(sXml, 5);
//				}
	            break; 				
          }
      }

      /**
       * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
       * <br><b>Example :</b>
       * <pre>
       *     if (validateForm(sheetObj,document.form,IBSAVE)) {
       *         로직처리;
       *     }
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {form} formObj 필수 html form object
       * @param {int} sAction 필수 프로세스 플래그 상수
       * @returns bool <br>
       *          true  : 폼입력값이 유효할 경우<br>
       *          false : 폼입력값이 유효하지 않을 경우
       * @author 이승준
       * @version 2009.05.07
       */
     function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
	  		case IBSEARCH: // 조회			
//				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
//					ComShowCodeMessage('PRI08001');
//					return false;
//				} else {
//					return true;
//				}
				return true;
				break;    	  
    	  	case IBSAVE: // 저장
	        	//if (!ComChkValid(formObj)) return false;	    	
				if (sheetObjects[0].IsDataModified ) {
	 		  		var sParamSheet1 = sheetObjects[0].GetSaveString();
	 		  		if (sParamSheet1==""){
	 		  			return ; 		  			
	 		  		} 					
					 var rowM = sheetObjects[0].ColValueDup("prc_cmdt_tp_cd|prc_cmdt_def_cd");
					 if (rowM >= 0) {
						 ComShowCodeMessage("PRI00303", "Sheet", rowM);
					     return false;
				    }	    		
				}
				break;
    			
    		case IBINSERT: // Row Add
//    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
//    				return false;
//    			} else {
//    				return true;
//    			}
    			return true;
    			break;
    			
    		case IBDELETE: // Delete
//    			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
//    				return false;
//    			} else {
//    				return true;
//    			}
    			return true;
    			break;
				
    	  }
         return true;
     }

     /**
      * OnChange 이벤트 발생시 호출되는 function <br>
      * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
      * @return 없음
      * @author 이승준
      * @version 2009.05.07
      */  	    
   function sheet1_OnChange(sheetObj, Row, Col, Value)
   {
   	var colname = sheetObj.ColSaveName(Col);  
   	var formObj = document.form

   	switch(colname)
   	{
    	case "prc_cmdt_def_cd":
    		if (Value.length == 6){
    			formObj.f_cmd.value = SEARCH08;
    			formObj.cd.value = Value; 
  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");	  				
  				
  				if (arrData != null && arrData.length > 0) {
 					sheetObj.Cellvalue2(Row, "prc_cmdt_def_nm") = arrData[1];
 					sheetObj.Cellvalue2(Row, "prc_cmdt_tp_cd") = "C";
 					//display seq 세팅
 					sheetObj.CellValue2(Row,"display_seq") = 3 ;
  				}else{
  					locationCellClear(sheetObj,Row);
  				}
  				
    		}else if (Value.length == 5) {
    			formObj.f_cmd.value = COMMAND32;
    			formObj.cd.value = Value;
    			var param = "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value 
    						+ "&etc3=" + formObj.gline_seq.value + "&etc5=CMPB";	
  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");	
  				
  				if (arrData != null && arrData.length > 0) {
 					sheetObj.Cellvalue2(Row, "prc_cmdt_def_nm") = arrData[1];
 					sheetObj.Cellvalue2(Row, "prc_cmdt_tp_cd") = "G";
 					//display seq 세팅
 					sheetObj.CellValue2(Row,"display_seq") = 1 ;
  				}else{
  					locationCellClear(sheetObj,Row);
  				}

    		} else if (Value.length == 4){
    			//alert(222)
    			formObj.f_cmd.value = COMMAND29;
    			formObj.cd.value = Value; 
  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");	  				
  				
  				if (arrData != null && arrData.length > 0) {
 					sheetObj.Cellvalue2(Row, "prc_cmdt_def_nm") = arrData[1];
 					sheetObj.Cellvalue2(Row, "prc_cmdt_tp_cd") = "R";
 					//display seq 세팅
 					sheetObj.CellValue2(Row,"display_seq") = 2 ;
  				}else{
  					locationCellClear(sheetObj,Row);
  				}
  				
    			
    		}else{
    			locationCellClear(sheetObj,Row);
    		}
    		break;
    	case "prc_cmdt_tp_cd": 	 
    		locationCellClear(sheetObj,Row);
    		break;
   		}
   }  

      /**
       * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
       * <br><b>Example :</b>
       * <pre>
       * 		locationCellClear(sheetObj,Row)
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
       * @return 없음
       * @author 이승준
       * @version 2009.05.07
       */  	    
    	function locationCellClear(sheetObj,Row){
    		sheetObj.CellValue2(Row,"prc_cmdt_def_nm")= "";
    		sheetObj.CellValue2(Row,"prc_cmdt_def_cd")= "";
    		sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
    		
    		sheetObj.CellValue2(Row,"display_seq")= "";
    	}      
      
      
  	 /**
	    * 삭제된 row가 sheet 간 이동하면 Hidden이 되었던게 보이므로 다시 hidden 시켜주는 function <br>
	    * sheet 간 데이터 이동시 실행한다.
	    * <br><b>Example :</b>
	    * <pre>
	    * 		sheetRowHidden (sheetObj)
	    * </pre>
	    * @param {ibsheet} sheetObj 필수 IBSheet Object
	    * @return 없음
	    * @author 이승준
	    * @version 2009.05.07
	    */     
  	function sheetRowHidden ( sheetObj){
 		for (i = sheetObj.RowCount; i > 0; i-- ){
 			if (sheetObj.CellValue( i, "ibflag") == "D" ){
 				sheetObj.RowHidden(i) = true;
 			}
    	}	
  	} 	 
  	
  	
  	function setDisplaySeq (sheetObj) {
  		
 		for (var i=1; i <= sheetObj.RowCount; i++) {

			if(sheetObj.CellValue(i, "prc_cmdt_tp_cd") == "C") 
				sheetObj.CellValue2(i,"display_seq") = 3;
			else if(sheetObj.CellValue(i, "prc_cmdt_tp_cd") == "R") 
				sheetObj.CellValue2(i,"display_seq") = 2;
			else if(sheetObj.CellValue(i, "prc_cmdt_tp_cd") == "G") 
				sheetObj.CellValue2(i,"display_seq") = 1;	
 				
    	}	
  	}
  	

    /**
	    * OnPopupClick 이벤트 발생시 호출되는 function <br>
	    * Location PopUp을 호출한다. <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *
	    * </pre>
	    * @param {ibsheet} sheetObj 필수 IBSheet Object
	    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
	    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
	    * @return 없음
	    * @author 이승준
	    * @version 2009.05.07
	    */  	      	 
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var tpCd = "C";
		
		if (colName == "prc_cmdt_def_cd"){
//			var sUrl = "/hanjin/ESM_PRI_4027.do?commodity_cmd=CG&grp_cd="+PRI_SG+"&svc_scp_cd="+formObj.svc_scp_cd.value+"&gline_seq="+formObj.gline_seq.value+"&prs_cust_tp_cd="+formObj.prs_cust_tp_cd.value;
			
			var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
			sUrl += "&grp_cd=" + 5;
			sUrl += "&commodity_cmd=CRG";
			
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;			
				//Commodity Type을 변경한다.
				if (rtnVal.cd.length == 5){
					tpCd = "G";
				} else if(rtnVal.cd.length == 4){
					tpCd = "R";
				}
				sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = rtnVal.tp;		
			}
		}
	}
	
	/* 개발자 작업  끝 */