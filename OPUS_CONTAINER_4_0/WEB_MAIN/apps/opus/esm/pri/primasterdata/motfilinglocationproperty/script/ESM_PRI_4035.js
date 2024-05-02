/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4035.js
*@FileTitle  : MOT Base Port Table Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
   	/* 개발자 작업	*/
    // 공통전역변수
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
   	  * @author 이승준
   	  * @version 2009.04.17
   	  */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject1=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
               switch(srcName) {
                    case "btn_add":
                    	doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
      					break;
                    case "btn_del":
                    	doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
      					break;
                    case "btn_retrieve":
                   	 	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
         				break;
                    case "btn_new":
                   	 	removeAll(document.form);
          				break;
                    case "btn_save":
                    	if (validateForm(sheetObjects[0],document.form,IBSAVE)) {
          					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
          				}	
          				break;                    
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowMessage(OBJECT_ERROR);
        		} else {
        			ComShowMessage(e.message);
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
         * @version 2009.04.17
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
         * @author 이승준
         * @version 2009.04.17
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
           	 	//khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
                
                initSheet(sheetObjects[i],i+1);
                
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            sheet0_OnLoadFinish(sheet0);
        }
        
        /**
         * LoadFinish 이벤트 시 발생한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */

        function sheet0_OnLoadFinish(sheetObj) {
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		sheetObj.WaitImageVisible = true;     		
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
         * @version 2009.04.17
         */ 
        function initSheet(sheetObj,sheetNo) {
       	 var cnt=0;
            var sheetID=sheetObj.id;            
            switch(sheetID) {
	            case "sheet0":     
	                    with (sheetObj) {
				   	       var HeadTitle="|Sel.|Del Check|Seq.|Ori/Dest|Location|File Location|File Location Name|Lane Code|Not used Flag|Creation Date|Update Date ";
				   	       (ComCountHeadTitle(HeadTitle), 0, 0, true);
				   	       SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				   	       var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				   	       var headers = [ { Text:HeadTitle, Align:"Center"} ];
				   	       InitHeaders(headers, info);
				   	       var cols = [	  {Type:"Status",    	Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" 	},
						   	              {Type:"DummyCheck", 	Hidden:0, 	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" 		},
						   	              {Type:"DelCheck",  	Hidden:0, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" 	},
						   	              {Type:"Seq",       	Hidden:0, 	Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" 		},
						   	              {Type:"Combo",     	Hidden:0, 	Width:90,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						   	              {Type:"PopupEdit", 	Hidden:0, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   AcceptKeys:"E", InputCaseSensitive:1, EditLen:5 },
						   	              {Type:"Text",      	Hidden:0,  	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mot_file_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   AcceptKeys:"E", InputCaseSensitive:1, EditLen:5 },
						   	              {Type:"Text",      	Hidden:0,  	Width:470,  Align:"Left",    ColMerge:0,   SaveName:"mot_file_loc_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   	              {Type:"Combo", 	Hidden:0, 	Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mot_file_lane_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   	              {Type:"CheckBox",  	Hidden:0, 	Width:110,  Align:"Center",  ColMerge:0,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
						   	              {Type:"Text",      	Hidden:0,  	Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   	              {Type:"Text",      	Hidden:0,  	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   	       
				   	       InitColumns(cols);				   	       
				   	       SetEditable(1);
	
				   	       SetColProperty("org_dest_tp_cd", 	{ComboText:orgDestCdText, 		ComboCode:orgDestCdValue} 		);
				   	       SetColProperty("mot_file_lane_cd", 	{ComboText:motFileLaneCdText, 	ComboCode:motFileLaneCdValue} 	);	
		       	           
				   	       SetColHidden("del_chk",1);
		       	           InitComboNoMatchText(1);
		       	           resizeSheet(); // SetSheetHeight(462);
				   	       SetComboOpenMode(1);				   	       	
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
         * @version 2009.04.17
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {	
   	       		case IBSEARCH:      //조회
   	       			try {
   	       				sheetObj.SetWaitImageVisible(0);
   	       				ComOpenWait(true);
   	       				formObj.f_cmd.value=SEARCH;
   	       				sheetObj.DoSearch("ESM_PRI_4035GS.do", FormQueryString(formObj) );
   	       				ComOpenWait(false);
   	       			} catch (e) {
         	            if (e == "[object Error]") {
         	                ComShowMessage(OBJECT_ERROR);
         	            } else {
         	                ComShowMessage(e.message);
         	            }
   	       			} finally {
   	       				ComOpenWait(false);
   	       			}	
   	       			break;
   	       			
   	       		case IBSAVE:        //저장
   	       			formObj.f_cmd.value=MULTI;
   	       			var sParam=FormQueryString(formObj);
   	       			var sParamSheet1=sheetObjects[0].GetSaveString();
   	       			if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
   	       				return;
   	       			}
   	       			sParam += "&" + sParamSheet1;
	   				if (!ComPriConfirmSave()) {
	   					return false;
	   				}
	   				try {
	   					ComOpenWait(true);
	   					var sXml=sheetObjects[0].GetSaveData("ESM_PRI_4035GS.do", sParam);
	   					sheetObjects[0].LoadSaveData(sXml);
	   					ComOpenWait(false);
	   					
	   					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	   				} catch (e) {
         	            if (e == "[object Error]") {
         	                ComShowMessage(OBJECT_ERROR);
         	            } else {
         	                ComShowMessage(e.message);
         	            }
	   				} finally {
         	    	   ComOpenWait(false);
         	       	}	
         	       	break;
         	       	
   	       		case IBINSERT: // Row Add
   	       			var idx=sheetObj.DataInsert();
   	       			break;
   	       			
   	       		case IBDELETE: // Delete
   	       			deleteRowCheck(sheetObj, "chk", true);
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
         * @author 이승준
         * @version 2009.04.17
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch (sAction) {
          		case IBSAVE: // 저장
          			if (sheetObj.IsDataModified()) {
          				var rowM = sheetObj.ColValueDup("org_dest_tp_cd|loc_cd",true);
   	   				 	if (rowM >= 0) {
   	   					 
	   	   					 sheetObj.SelectHighLight = false;
	   	   					 
	   	   					 var errRowFstIdx = -1;
	   	   					 for (var i = 1  ; i <= sheetObj.LastRow(); i++) {
	   	
	   	   			             if(sheetObj.GetCellValue(i,"org_dest_tp_cd") == sheetObj.GetCellValue(rowM,"org_dest_tp_cd") &&
	   	   			            		 sheetObj.GetCellValue(i,"loc_cd") == sheetObj.GetCellValue(rowM,"loc_cd")	 ) {           
	   	   			            	 errRowFstIdx = i;
	   	   			            	 break;
	   	   			             }
	   	   			         }
	   	   					 //when loc_cd is duplicated
	   	   					 if(errRowFstIdx > 0) {
	   	   						ComShowCodeMessage('PRI00302');
	   	   						sheetObj.SelectCell(errRowFstIdx, "loc_cd"); 
	   	   					 } 
	   	   				     return false;
   	   				 	}	//if (rowM >= 0) end   		
      				 
          			} else {
   	   					ComShowCodeMessage("PRI00301");
   	   					return false;
          			} //if (sheetObj.IsDataModified()) end
           		
          			return true;
          			break;	
        	}
            return true;
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
         * @author 이승준
         * @version 2009.06.10
         */
    	function removeAll(formObj) {
    		if (sheetObjects[0].IsDataModified()) {
    			if (ComShowCodeConfirm("PRI00006")) {
    				doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
    			} else {
    				formObj.reset();
   		 			sheetObjects[0].RemoveAll();
    			}
    		} else {	
    			formObj.reset();
   	 			sheetObjects[0].RemoveAll();
    		}
    	}
    	/**
        * sheet를 클릭시 발생한다.<br>
        * 체크박스를 언체크 한다.
        * <br><b>Example :</b>
        * <pre>
        *     sheet0_OnClick(sheetObj, Row, Col, Value)
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {int} Row 
        * @param {int} Col   
        * @param {String} Value   
        * @return 없음
        * @author 이승준
        * @version 2009.06.10
        */

    	function sheet0_OnClick(sheetObj, Row, Col, Value)  {
    		var colName=sheetObj.ColSaveName(Col);
    		if (colName == "chk") {
    			if (Value == "0") {
    				sheetObj.SetCellValue(Row, "del_chk","0");
    			}
    		}
    		
    	}
    	
    	function sheet0_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    		sheetObjects[0].ColumnSort();
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
        * @author 이승준
        * @version 2009.06.10
        */
    	function sheet0_OnSaveEnd(sheetObj, ErrMsg)  {
    		if (ErrMsg == "") {
    			ComPriSaveCompleted();
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
         * @author 최성민
         * @version 2009.05.07
         */ 	 	 
      	function sheet0_OnPopupClick(sheetObj, Row, Col)
      	{
      		var colName=sheetObj.ColSaveName(Col);
      		var formObj=document.form;
            	switch(colName)
            	{
        	    	case "loc_cd":
        				var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_SCG                                                                                                                                                                                                                                                                                                                                                                                       
    					+ "&location_cmd=L&chg_cd=";                                                                                                                                                                                                                                                                                                                                                                                                                       
        				ComOpenPopup(sUrl, 700, 325, "getValueLocationPop", "1,0,1,1,1,1,1", true);
        				
        	    		break;
            	}
      	} 
      	
      	function getValueLocationPop(rtnVal) {
            var sheetObj = sheetObjects[0];
            if (rtnVal != null) {  
            	var sRowStr = sheetObj.GetSelectionRows("/");
            	if (sRowStr != null && sRowStr > 0) { 
					sheetObj.SetCellValue(sRowStr, "loc_cd"		   ,rtnVal.cd,0);
					sheetObj.SetCellValue(sRowStr, "mot_file_loc_cd",rtnVal.cd,0);
					sheetObj.SetCellValue(sRowStr, "mot_file_loc_nm",rtnVal.nm,0);
            	}
			} 
        }
      	
        /**
         * OnChange 이벤트 발생시 호출되는 function <br>
         * COMMBO에 없는 코드를 입력할 경우 서버를 검색해서 데이터가 존재하면 코드값을 화면에 출력하는 function  <br>
         * <br><b>Example :</b>
         * <pre>
         *
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
         * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
         * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
         * @return 없음
         * @author 최성민
         * @version 2009.04.17
         */  	
    	function sheet0_OnChange(sheetObj, Row, Col, Value) {
    		var formObj=document.form;
    		var sName=sheetObj.ColSaveName(Col);
    		if (sName == "loc_cd") {
    			if (Value.length == 5) {
    				formObj.f_cmd.value=SEARCH05;
    				var sParam=FormQueryString(formObj);
    				sParam += "&cd="+Value;
    				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
    				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
    				if (arrDesc != null && arrDesc.length > 0) {
    					sheetObjects[0].SetCellValue(Row, "mot_file_loc_cd",Value,0);
    					sheetObjects[0].SetCellValue(Row, "mot_file_loc_nm",arrDesc[0][1],0);
    				} else {
    					sheetObj.SetCellValue(Row, "loc_cd","",0);
    					sheetObj.SetCellValue(Row, "mot_file_loc_cd","",0);
    					sheetObj.SetCellValue(Row, "mot_file_loc_nm","",0);
    					sheetObj.SelectCell(Row, "loc_cd");
    					return false;
    				}
    			
    			} else {
					sheetObj.SetCellValue(Row, "loc_cd","",0);
					sheetObj.SetCellValue(Row, "mot_file_loc_cd","",0);
					sheetObj.SetCellValue(Row, "mot_file_loc_nm","",0);
    				sheetObj.SelectCell(Row, "loc_cd");
    				return false;
    			}
    		} 	
    	}
    	
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }