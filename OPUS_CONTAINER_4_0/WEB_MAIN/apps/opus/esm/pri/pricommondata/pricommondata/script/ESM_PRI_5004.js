/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_5004.js
*@FileTitle : Rating Unit Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.04.13 SHKIM
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

   	/* 개발자 작업	*/
 // 공통전역변수
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
	 /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author SHKIM
	  * @version 2012.04.13
	  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                 case "btn_add":
                	doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
   					break;
                 case "btn_del":
                	doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
   					break;
                 case "btn_retrieve":
                	 doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
      				 break;
                 case "btn_new":
                	 removeAll(document.form);
       				 break;
                 case "btn_save":
                	if (validateForm(sheetObjects[1],document.form,IBSAVE)) {
       					doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
       				}
                	break;
                 case "btn_delete":
                	 if (validateForm(sheetObjects[1],document.form,IBDELETE)) {            				 
        				doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
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
      * @author SHKIM
      * @version 2012.04.13
      */ 
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
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
      * @author SHKIM
      * @version 2012.04.17
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
             
         }
         
         sheet1_OnLoadFinish(sheetObjects[1]);
     }
     /**
      * LoadFinish 이벤트 시 발생한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @return 없음
      * @author SHKIM
      * @version 2012.04.13
      */
     function sheet1_OnLoadFinish(sheetObj) {
    	 sheetObj.SetWaitImageVisible(0);
 		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
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
      * @author SHKIM
      * @version 2012.04.17
      */ 
     function initSheet(sheetObj,sheetNo) {
    	 var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
	         case "sheet0":      //hidden 
	        	    with(sheetObj){
	        	 	SetVisible(0);
	         		}
	             break; 
	         case "sheet1":      //hidden 
	        	    with(sheetObj){
	             
			           var HeadTitle="|Sel.|Del Check|Seq.|SVC Scope Property|SVC Scope Property Name ";
		
			           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
			           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			           var headers = [ { Text:HeadTitle, Align:"Center"} ];
			           InitHeaders(headers, info);
		
			           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			                  {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			                  {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                  {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_ppt_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
			                  {Type:"Text",      Hidden:0,  Width:720,  Align:"Left",    ColMerge:0,   SaveName:"svc_scp_ppt_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
			            
			           InitColumns(cols);
			           
			           
			           SetEditable(1);
			           SetWaitImageVisible(0);
			           SetColProperty(0 ,"svc_scp_ppt_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			           //2014.09.25 OPUS_NYK_CR_227 수정
			           SetColProperty(0 ,"svc_scp_ppt_desc" , {AcceptKeys:"E|N|[ ]" , InputCaseSensitive:1 });
			           SetColHidden("del_chk",1);
			           resizeSheet();//SetSheetHeight(462);
	           		}
                 break;
         }
     }
     function resizeSheet(){ ComResizeSheet(sheetObjects[1]); }
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
      * @author SHKIM
      * @version 2012.04.13
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
	       case IBCLEAR:
			  break;	
           case IBSEARCH:      //조회
        	   try {
        		    sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
	        	    formObj.f_cmd.value=SEARCH;
	        	    sheetObj.DoSearch("ESM_PRI_5004GS.do", FormQueryString(formObj) );
	 				
				 } catch (e) {
      	            if (e == "[object Error]") {
      	                ComShowMessage(OBJECT_ERROR);
      	            } else {
      	                ComShowMessage(e);
      	            }
      	       } finally {
      	    	   ComOpenWait(false);
      	       }	
 			  break;
           case IBSAVE:        //저장
        	   formObj.f_cmd.value=MULTI;
				var sParam=FormQueryString(formObj);
				var sParamSheet1=sheetObjects[1].GetSaveString();
				if (sheetObjects[1].IsDataModified()&& sParamSheet1 == "") {
					return;
				}
				sParam += "&" + sParamSheet1;
				if (!ComPriConfirmSave()) {
					return false;
				}
				try {
					ComOpenWait(true);
					var sXml=sheetObjects[1].GetSaveData("ESM_PRI_5004GS.do", sParam);
					sheetObjects[1].LoadSaveData(sXml,{Sync:1});
					ComOpenWait(false);
				} catch (e) {
      	            if (e == "[object Error]") {
      	                ComShowMessage(OBJECT_ERROR);
      	            } else {
      	                ComShowMessage(e);
      	            }
      	       } finally {
      	    	   ComOpenWait(false);
      	       }	
       		 break;
         case IBINSERT: // Row Add
       		//sheetObj.DataAutoTrim = false;
        	var idx=sheetObj.DataInsert();
       		break;
       	 case IBDELETE: // Delete
       		// 부모테이블 조회. 
       		var locChk=0;
       		var locSvcScpCd='';
       		
       		for( var i=1 ; i<=sheetObj.RowCount(); i++){
       			locChk=sheetObj.GetCellValue(i,"chk"); // no '0' , yes '1'
       			
        		if(locChk == "Y" || locChk == "1"){
        			// checked
        			locSvcScpCd=sheetObj.GetCellValue(i,"svc_scp_ppt_cd");
        			formObj.f_cmd.value=SEARCH;
        			var sParam="svc_scp_ppt_cd=" + locSvcScpCd;
        			sParam += "&" + FormQueryString(formObj);     
        			var sXml=sheetObj.GetSearchData("ESM_PRI_5005GS.do",  sParam); //sheetObj.DoSearch
        			
            	    var dataCount=ComGetTotalRows(sXml);// 데이터 건수
            	    if(dataCount > 0){
            	    	ComShowCodeMessage("PRI01022", locSvcScpCd); 
            	    	//var msg = ComGetMsg("PRI01022");	alert(msg); 
               		 	return false;
            	    }
        		}
        	}
    	    if(sXml != null && sXml != ''){
    	    	deleteRowCheck(sheetObj, "chk", true);
    	    }
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
      * @return bool <br>
      *          true  : 폼입력값이 유효할 경우<br>
      *          false : 폼입력값이 유효하지 않을 경우
      * @author SHKIM
      * @version 2012.04.17
      */
     function validateForm(sheetObj,formObj,sAction){
       switch (sAction) {
        case IBDELETE:
        	var locChk=0; 
        	var locChkAll=0;
        	for( var i=1 ; i<=sheetObj.RowCount(); i++){
        		locChk=sheetObj.GetCellValue(i,"chk"); // no '0' , yes '1'
        		locChkAll=locChkAll+locChk;
        	}
        	
        	if(locChkAll < 1){
        		 var msg=ComGetMsg("PRI04006");
        		 alert(msg); 
        		 return false;
        	}
        	break;
     	case IBSAVE: // 저장
     		if (sheetObj.IsDataModified()) {
     			clearTooltip();
     			var saveStr = sheetObj.GetSaveString();
				 if(saveStr == "") return false;
				 
				 var rowM=sheetObj.ColValueDup("svc_scp_ppt_cd",false);
				 if (rowM >= 0) {
					 var msg=ComGetMsg("PRI00302");
					 for (var i=sheetObj.LastRow(); i >= 0; i--) {
						 if(sheetObj.GetCellValue(i,"rat_ut_cd") == sheetObj.GetCellValue(rowM,"rat_ut_cd")) {
			             	add2Tooltip(i, "rat_ut_cd", msg);
			             }
			         }
					 alert(msg);
				     return false;
			     }	    		
				 //중복 cd 체크
				 formObj.f_cmd.value=SEARCH02;
				 
	             var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
	             var sXml=sheetObjects[0].GetSearchData("ESM_PRI_4001GS.do", sParam);
	             var arrErr=ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
	             if (arrErr != null && arrErr.length > 0) {
	            	 var msg=ComGetMsg("PRI00302");
	            	 for (var i=0; i < arrErr.length; i++) {
	            		 add2Tooltip(parseInt(ComGetValidRow(sheetObj, "rat_ut_cd", arrErr[i][2])), arrErr[i][1], msg);
	            	 }
	            	 alert(msg);
	            	 return false;
	             }
			} else {
				ComShowCodeMessage("PRI00301");
				return false;
			}
     		return true;
     		break;
     	}
         return true;
     }
     
     function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	 ComOpenWait(false);
    	}
     
     /**
      * tooltip을 제거한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     clearTooltip()
      * </pre>
      * @param 없음
      * @return 없음
      * @author SHKIM
      * @version 2012.04.17
      */
     function clearTooltip() {
     	var sheetObj=sheetObjects[1];
     	for (var i=sheetObj.HeaderRows(), n=sheetObj.HeaderRows()+sheetObj.RowCount(); i < n; i++) {
     		for (var j=0; j <= sheetObj.LastCol(); j++) {
     			sheetObj.SetCellBackColor(i, j,sheetObj.GetEditableColor());
     			sheetObj.SetToolTipText(i, j,"");
     		}
     	}
     }
     /**
      * tooltip을 생성한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     add2Tooltip(row, col, msg)
      * </pre>
      * @param {int} row
      * @param {int} col
      * @param {String} msg 
      * @return 없음
      * @author SHKIM
      * @version 2012.04.17
      */
     function add2Tooltip(row, col, msg) {
     	var sheetObj=sheetObjects[1];
     	sheetObj.SetCellBackColor(row, col,"#FF0000");
     	sheetObj.SetToolTipText(row, col, msg);
     }
     /**
      * 화면 전체를 리셋한다.<br>
      * 데이터가 변경된 경우 저장한다.
      * <br><b>Example :</b>
      * <pre>
      *     searchConditionReset(formObj,gubun)
      * </pre>
      * @param {form} formObj 
      * @param {String} gubun    
      * @return 없음
      * @author SHKIM
      * @version 2012.04.17
      */
 	function removeAll(formObj) {
 		if (sheetObjects[1].IsDataModified()) {
 			if (ComShowCodeConfirm("PRI00006")) {
 				doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
 			} else {
 				formObj.reset();
		 		sheetObjects[1].RemoveAll();
 			}
 		} else {	
 			formObj.reset();
	 		sheetObjects[1].RemoveAll();
 		}
	}
 	/**
     * sheet를 클릭시 발생한다.<br>
     * 체크박스를 언체크 한다.
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnClick(sheetObj, Row, Col, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 
     * @param {int} Col   
     * @param {String} Value   
     * @return 없음
     * @author SHKIM
     * @version 2012.06.10
     */
 	function sheet1_OnClick(sheetObj, Row, Col, Value)  {
 		var colName=sheetObj.ColSaveName(Col);
 		if (colName == "chk") {
 			if (Value == "0") {
 				sheetObj.SetCellValue(Row, "del_chk","0");
 			}
 		}	
 	}
 	/**
     * OnSaveEnd 시 발생한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} ErrMsg    
     * @return 없음
     * @author SHKIM
     * @version 2012.04.17
     */
 	function sheet1_OnSaveEnd(sheetObj, Code , Msg)  {
 		if (Code >= 0) {
 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
 		}
 	}
	/* 개발자 작업  끝 */
