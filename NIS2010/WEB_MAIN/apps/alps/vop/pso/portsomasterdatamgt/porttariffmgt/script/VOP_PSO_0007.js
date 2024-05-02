/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0007.js
*@FileTitle : Formula & Condition Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.05 김진일
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
     * @class VOP_PSO_0007 : VOP_PSO_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0007() {
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
    var firstFlag = true;
    var isEdit = false;
    var isForm = false;//Form Obj에 포커스가 왔는지 에 대한 전역변수 
    var prvId = ""; //이전 ID정보를 저장하는 전역변수 
    var chkMode = "1";//
//    var braceCount = 0;// () 괄호의 Count 를 저장
    
//    var btnObjects = [{"key1":"val1","key2":"val2"}];//Subject의 BtnObject를 관리하는 JSON타입의 변수 

    var infoArr = new Array(); 

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    //괄호의 정보를 만든다.
    function buildParenthesesInfo(){
    	var infostack = new Array();
    	infoArr = new Array();
    	var stackidx = 0;
    	var infoidx = 0;
    	var sheetObject1 = sheetObjects[0];
    	var rowCnt = sheetObject1.RowCount;
    	
    	for(var row=1; row<rowCnt+1; row++){
    		for(var col=2; col<15; col++){
    			var txt = sheetObject1.CellValue(row,col);
    			var regexp = new RegExp(/\(|\)/g);
    			if(txt.indexOf("(")!=-1 || txt.indexOf(")")!=-1){
//    				alert("txt:="+txt);
    				for(var i=0; i<txt.length;i++){
//    					alert("txt:="+txt);
			    	    var info = regexp.exec(txt);
//			    	    alert("info:="+info)
			    	    if(info==null)
			    	    	break;
			    	    else{
				    		if(info=="("){//PUSH
				    		  infostack[stackidx++] = row+"_"+col;
//				    		  alert("push:="+infostack[stackidx-1]);
				    		}
				    	    else{//POP
//				    	      alert("pop:="+infostack[stackidx-1] + "|" + row+":"+col);
				    	      var popVal = infostack[stackidx-1];
				    	      eval("infoArr._"+popVal+" = \""+row+"_"+col+"\"");
				    	      eval("infoArr._"+row+"_"+col+" = \""+popVal+"\"");
				    	      infoArr[infoidx++] =  infostack[stackidx-1] + "|" + row+"_"+col;
				    		  infostack[stackidx-1]  = "";//clear
				    		  stackidx--;
				    		}
			    	    }
    				}
    			}
    		}
    	}
    }
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
    		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		var sheetObject1 = sheetObjects[0];
    		var sheetObject2 = sheetObjects[1];

    		/*******************************************************/
    		var formObject = document.form;

        	try {
        		var srcName  = window.event.srcElement.getAttribute("name");
        		var altValue = window.event.srcElement.getAttribute("alt");

                switch(srcName) {
                	case "btng_Cell_Add":
//                		alert(srcName);
                		//현재 선택된 Row 의 최종 값을 체크 
//                		alert(sheetObject1.CellValue(sheetObject1.RowCount, "sheet1_col13") == "" ? "Y":"N");
                		//현재 Row Col
                		var rowIdx = sheetObject1.SelectRow;
                		var colIdx = sheetObject1.SelectCol;
//                		alert("colIdx:="+colIdx);
                		if(colIdx<2||colIdx>14) return;
                		if(sheetObject1.CellValue(sheetObject1.RowCount, "sheet1_col13") != "")
                		{
                			sheetObject1.DataInsert(-1);
                			sheetObject2.DataInsert(-1);
//                			alert(sheetObject1.RowCount);
                			sheetObject1.SelectCell(rowIdx,colIdx);
                		}
                		// 한개의 cell 을 RowAdd없이 더할 수 있는 상황 
                		for(var row = sheetObject1.RowCount; row >= rowIdx ; row--) 
                		{
                			for(var col = 14; col >= 2; col--)
                			{
                				if(row == rowIdx && col == colIdx){
                					sheetObject1.CellValue2(row, col) = "";
                					sheetObject2.CellValue2(row, col) = "";
//                					alert(1);
                					break;
                				}
                				if(col==2){
                					if(row - 1 > 0){
//                						alert(2);
                						sheetObject1.CellValue2(row, col) = sheetObject1.CellValue(row-1, 14);
                						sheetObject2.CellValue2(row, col) = sheetObject2.CellValue(row-1, 14);
                					}
                				}
                				else{
//                					alert(3);
                					sheetObject1.CellValue2(row, col) = sheetObject1.CellValue(row, col-1);
                					sheetObject2.CellValue2(row, col) = sheetObject2.CellValue(row, col-1);
                				}
                			}
                		}
                		for(var i=2; i<15; i++){
                			sheetObject1.ColWidth(i) = 0;
                			if(sheetObject1.ColWidth(i)<70)
                				sheetObject1.ColWidth(i) = 70
                		}

                		for(var row = sheetObject1.RowCount; row >= rowIdx ; row--) 
                		{
                			for(var col = 14; col >= 2; col--)
                			{
                				sheetObject1.CellFontColor(row, col) = sheetObject1.CellFontColor(row,1);
                				sheetObject1.CellFont("FontBold", row,col) = false;
                			}
                		}
                		buildParenthesesInfo();
                		displayExpression(sheetObject1);
                		break;
                	case "btng_Cell_Delete":
                		//현재 Row Col
                		var rowIdx = sheetObject1.SelectRow;
                		var colIdx = sheetObject1.SelectCol;
                		if(colIdx<2||colIdx>14) return;
                		// 한개의 cell 을 RowAdd없이 더할 수 있는 상황 
                		for(var row = rowIdx; row <= sheetObject1.RowCount ; row++) 
                		{
                			var col = colIdx;
                			if(row!=rowIdx) col = 2;
                			for(; col <= 14; col++)
                			{
                				if(col==14){
                					if(row + 1 <= sheetObject1.RowCount){
//                					    if(row == sheetObject1.RowCount){
//                					    	sheetObject1.CellValue2(row, col) = "";
//                					    	sheetObject2.CellValue2(row, col) = "";
//                					    }
//                					    else{
                					    	sheetObject1.CellValue2(row, col) = sheetObject1.CellValue(row+1, 2);
                					    	sheetObject2.CellValue2(row, col) = sheetObject2.CellValue(row+1, 2);
//                					    }
                						
                					}
                				}
                				else{
                					sheetObject1.CellValue2(row, col) = sheetObject1.CellValue(row, col+1);
                					sheetObject2.CellValue2(row, col) = sheetObject2.CellValue(row, col+1);
                				}
                			}
                		}
                		sheetObject1.CellValue2(row-1, col-1) = "";
				    	sheetObject2.CellValue2(row-1, col-1) = "";
                		for(var i=2; i<15; i++){
                			sheetObject1.ColWidth(i) = 0;
                			if(sheetObject1.ColWidth(i)<70)
                				sheetObject1.ColWidth(i) = 70
                		}
                		for(var row = rowIdx; row <= sheetObject1.RowCount ; row++) 
                		{
                			for(var col = 14; col >= 2; col--)
                			{
                				sheetObject1.CellFontColor(row, col) = sheetObject1.CellFontColor(row,1);
                				sheetObject1.CellFont("FontBold", row,col) = false;
                			}
                		}
                		buildParenthesesInfo();
                		displayExpression(sheetObject1);
                		break;
	                case "dscTbl":
	                	break;
                	case "btn_foml_cond":
                		//해당 RadioButton의 타입을 확인하여 .. 
//                		alert(formObject.radioflag[0].checked);
//                		alert(formObject.radioflag[1].checked);
                		var flg = formObject.radioflag[0].checked ? "1":"2";
                		//var turl = "/hanjin/VOP_PSO_0209.do?formcond="+flg + "&caller=rice_store";	//UPD_MNU_NO IN (1, 2)만 조회할 수 있도록
                		var turl = "/hanjin/VOP_PSO_0209.do?formcond="+flg;	//UPD_MNU_NO IN (1, 2)만 조회할 수 있도록
						ComOpenPopup( turl , 700, 440, 'setFomlCondId', '0,0', true, true);
	                	break;
                	case "radioflag":
                	case "txtid":
                		break;//아무일도 안함 
                //======SubjectFavorites Btn Click ============/
	                case "btn_Subject_Favorites":
	                	var turl = "/hanjin/VOP_PSO_0208.do";
						ComOpenPopup( turl , 870, 676, 'refreshButton', 'none', true, true);
	                	break;
    //================= Main ====================//
    				case "btn_Retrieve":
//    					alert(srcName);
    					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);//Formula 혹은 Condtion 정보를 조회한다.
    					for(var i=0; i<13; i++){//autosizing
    						sheetObjects[0].ColWidth(i) = 0
	    					if(sheetObjects[0].ColWidth(i)<70){
	    						sheetObjects[0].ColWidth(i) = 70;
	    		        	}
    						sheetObjects[1].ColWidth(i) = sheetObjects[0].ColWidth(i);
    					}
    					if(sheetObjects[0].RowCount > 0) buildParenthesesInfo();
    					break;
    				case "btn_New":
    					//ComDebug("[Debug] \n" + FormQueryString(formObject) + "\n");	//alert
    					//formObject.reset();	//[2010.03.16:jmh] 주석처리
    					//ComDebug("[Debug] \n" + FormQueryString(formObject) + "\n");	//alert
    					sheetObject1.RemoveAll();
    					sheetObject2.RemoveAll();
//    					for(var i=0; i<4 ; i++){
//    						sheetObject1.DataInsert(-1);
//    						sheetObject2.DataInsert(-1);
//    						sheetObject1.SelectCell(1, 2);
//    					}
    					formObject.txtid.value = "";
    					ComSetFocus(formObject.txtid);
    					var dspXpr = document.getElementById("dspXpr");
    					dspXpr.innerHTML = "";
    				break;
    				case "btn_Delete":
    					//Delete 기능
//    					setFlag();
//    					alert("formObject.radioflag[0].checked:="+formObject.radioflag[0].checked);
    					doActionIBSheet(sheetObjects[2],document.form,IBDELETE);//Hidden Sheet를 이용하여 Delete한다.
    					break;
    				case "btn_Save":
    					//이전 데이터를 저장하기 위해.. 강제로 ibflag 를 I로 처준다.
						// "D" 인 넘은 Skkip한다. 
    					for(var i=0;i<sheetObjects[0].RowCount;i++){
//    						alert(sheetObjects[0].CellValue(i+1, 0));
    						if(sheetObjects[0].CellValue(i+1, 0) != "D"){
    							sheetObjects[0].CellValue2(i+1, 0) = "I";
    							sheetObjects[1].CellValue2(i+1, 0) = "I";
    						}
    					}
    					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);//Save 호출 
    				break;
    				case "btn_Subject_Favorites":
    					alert(srcName);
    				break;
    //================= Main ====================//

    //================= Grid ====================//
    				case "btng_Row_Add":
    					//if(formObject.txtid.value == ""){	//[2010.03.16:jmh] 추가	
    					//	ComShowCodeMessage("PSO00036", "[ID]");
    					//	return;	
    					//}
//    					fillCell(srcName);
    					sheetObjects[1].DataInsert(-1);
    					sheetObjects[1].SelectCell(sheetObjects[1].SelectRow,2);
						sheetObjects[0].DataInsert(-1);
						sheetObjects[0].SelectCell(sheetObjects[0].SelectRow,2);
    				break;
    				case "btng_Row_Delete":
//    					fillCell(srcName);
    					var selcnt = 0;
    				    for(var i=0;i<sheetObject1.RowCount+1;i++){
    				    	if(sheetObject1.CellValue(i, 1)==1){
    				    		sheetObject2.CellValue(i, 1) = 1;
    				    		selcnt++;
    				    	}
    				    }
    				    ComRowHideDelete(sheetObject1, "sheet1_del_chk");
    				    if(selcnt > 0 ){
    				    	ComRowHideDelete(sheetObject2, "sheet2_del_chk");
    				    }
//    					sheetObjects[0].RowDelete(sheetObjects[0].SelectRow, false); 
    				    //select cell sync // 1. Data 가 있을 경우 만. 처리 .
						if(sheetObjects[0].RowCount > 0 ){
							sheetObjects[1].SelectCell(1, 2); //(1,1) 셀에 포커싱 
							sheetObjects[0].SelectCell(1, 2); //(1,1) 셀에 포커싱 
						}
						buildParenthesesInfo();
//    				    sheetObjects[1].SelectCell(sheetObjects[0].SelectRow, heetObjects[0].SelectCol);
						displayExpression(sheetObject1);	//[2010.03.16:jmh] 추가
    				break;
    //================= Grid ====================//

    //================= Subject ====================//
    				case "btn1_NRT":
//    					alert(srcName);
//    				break;
    				case "btn1_GRT":
//    					alert(srcName);
//    				break;
    				case "btn1_Draft":
//    					alert(srcName);
//    				break;
    				case "btn1_LOA":
//    					alert(srcName);
//    					alert(altValue);
    				    fillCell(srcName, altValue);
    				break;
    				case "btn1_LBP":
//    					alert(srcName);
//    				break;
    				case "btn1_SCNT":
//    					alert(srcName);
//    				break;
    				case "btn1_DWT":
//    					alert(srcName);
//    				break;
    				case "btn1_Berthing_Hour":
//    					alert(srcName);
//    				break;
    				case "btn1_Tug_Used_Hour":
//    					alert(srcName);
//    				break;
    				case "btn1_No_of_Tug":
//    					alert(srcName);
//    				break;
    				case "btn1_Line_Tractor":
//    					alert(srcName);
//    				break;
    				case "btn1_Water_Volume":
//    					alert(srcName);
//    				break;
    				case "btn1_Anchoring_Hour":
//    					alert(srcName);
    					fillCell(srcName, altValue);
    					break;
    				case "btn1_Rate":
    					//>>[2010.03.05:jmh] 두개의 btn1_Rate 버튼이 존재했음. +Rate를 btn2_Rate로 변경
    		        	if(sheetObjects[0].RowCount == 0 || sheetObjects[0].SelectCol == 0 || sheetObjects[0].SelectCol == 1 ) return;
    		        	var curVal = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, sheetObjects[0].SelectCol);
    		        	if(curVal != "") return;
    		        	//<<[2010.03.05:jmh]
    					
//    					if(formObject.radioflag[0].checked)
    						fillCell(srcName, "45", "append");
//    					else
//    						fillCell(srcName, "45");
    				break;
    				case "btn2_Rate":	//+Rate
    					//>>[2010.03.05:jmh] 두개의 btn1_Rate 버튼이 존재했음. +Rate를 btn2_Rate로 변경
    		        	if(sheetObjects[0].RowCount == 0 || sheetObjects[0].SelectCol == 0 || sheetObjects[0].SelectCol == 1 ) return;
    		        	var curVal = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, sheetObjects[0].SelectCol);
    		        	if(curVal == "") return;
    		        	//<<[2010.03.05:jmh]
    		        	
//    					if(formObject.radioflag[0].checked)
    						fillCell(srcName, "45", "append");
//    					else
//    						fillCell(srcName, "45");
    				break;
    				case "btn1_1_Delete":
//    					alert(srcName);
						//ComSetFocus(document.form.sheet1);
						sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol)="";
						sheetObjects[1].CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol)="";
						buildParenthesesInfo();
						displayExpression(sheetObject1);
    				break;
    //================= Subject ====================//
    				
    //================= 숫자 ====================//
    				case "btn2_1":
    					fillNumber(srcName);
    				break;
    				case "btn2_2":
    					fillNumber(srcName);
    				break;
    				case "btn2_3":
    					fillNumber(srcName);
    				break;
    				case "btn2_4":
    					fillNumber(srcName);
    				break;
    				case "btn2_5":
    					fillNumber(srcName);
    				break;
    				case "btn2_6":
    					fillNumber(srcName);
    				break;
    				case "btn2_7":
    					fillNumber(srcName);
    				break;
    				case "btn2_8":
    					fillNumber(srcName);
    				break;
    				case "btn2_9":
    					fillNumber(srcName);
    				break;
    				case "btn2_0":
    					fillNumber(srcName);
    				break;
    				case "btn2_":
    					alert(srcName);
    				break;
    				case "btn2_.":
    					fillNumber(srcName);
    				break;
//    				case "btn2_X":
//    					fillCell(srcName);
//    				break;
//    				case "btn2_/":
//    					fillCell(srcName);
//    				break;
//    				case "btn2_+":
//    					fillCell(srcName);
//    				break;
//    				case "btn2_-":
//    					fillCell(srcName);
//    				break;
    //================= 숫자 ====================//
    				
    //================= Operator ====================//
    				case "btn2_X":
    					fillCell(srcName,"*","P");
    					break;
    				case "btn2_*":		//[2010.03.18:jmh] add
    					fillCell(srcName,"*","P");
    					break;
    				case "btn2_/":
    					fillCell(srcName,"/","P");
    					break;
    				case "btn2_+":
    					fillCell(srcName,"+","P");
    					break;
    				case "btn2_-":
    					fillCell(srcName,"-","P");
    					break;
    				case "btn3_And":
    					//alert(srcName);
    					fillCell(srcName,"AND","P");
    					break;
    				case "btn3_Or":
    					//alert(srcName);
    					fillCell(srcName,"OR","P");
    					break;
    				case "btn3_Y":
    					//alert(srcName);
    					fillCell(srcName,"'Y'","C");
    					break;
    				case "btn3_N":
    					//alert(srcName);
    					fillCell(srcName,"'N'","C");
    					break;
    				case "btn3_(":
    					//alert(srcName);
    					fillCell(srcName,"(","P");
    					buildParenthesesInfo();
//    					alert(infoArr.toString());
//    					braceCount++;
    					break;
    				case "btn3_)":
    					//alert(srcName);
    					fillCell(srcName,")","P");
    					buildParenthesesInfo();
//    					alert(infoArr.toString());
//    					braceCount--;
    					break;
    				case "btn3_>":
    					//alert(srcName);
    					fillCell(srcName,">","P");
    					break;
    				case "btn3_>=":
    					//alert(srcName);
    					fillCell(srcName,">=","P");
    					break;
    				case "btn3_<":
    					//alert(srcName);
    					fillCell(srcName,"<","P");
    					break;
    				case "btn3_<=":
    					//alert(srcName);
    					fillCell(srcName,"<=","P");
    					break;
    				case "btn3_=":
    					//alert(srcName);
    					fillCell(srcName,"=","P");
    					break;
    				case "btn3_!=":
    					//alert(srcName);
    					fillCell(srcName,"!=","P");
    					break;
    				case "btn3_IN":
    					//alert(srcName);
    					fillCell(srcName,"IN","P");
    					break;//2010.01.27 bug fix
    				case "btn3_NOT IN"://2009.12.10 add
    					//alert(srcName);
    					fillCell(srcName,"NOT IN","C");
    					break;
    //================= Operator ====================//
    				//===========FUNCTION===========>
    				case "btn2_RoundUp":
    					fillCell(srcName,"RoundUp","F");
    					break;
    				case "btn2_RoundDown":
    					fillCell(srcName,"RoundDown","F");
    					break;
    				case "btn2_Round":
    					fillCell(srcName,"Round","F");
    					break;
    				case "btn2_MAX":
    					fillCell(srcName,"GREATEST","F");
    					break;
    				case "btn_auto_id":
    		
    					doActionIBSheet(sheetObjects[0],document.form,SEARCH02); 
    					
    					break;	
    				default:
    					if(srcName!=null&&srcName!="undefined")
    						fillCell(srcName, altValue);
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
         * Formula 혹은 Condition 의 내용을 채운다. 
         * @return
         */
        function setFomlCondId(aryPopupData, row, col, sheetIdx){
        	//[2010.03.16:jmh] 추가	 
        	var id = aryPopupData[0][1].trim(); 
        	if(id == "ID"){
        		document.form.txtid.value = "";
        		prvId = "";
        		return;
        	}
         
 			var sheetObject = sheetObjects[0];
 			var prefix = "sheet1_"
// 				alert(aryPopupData[0][1]);
// 				alert(aryPopupData);
 			document.form.txtid.value = id;
 			ComSetFocus(document.form.txtid);
 			//자동 검색? 
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);//Formula 혹은 Condtion 정보를 조회한다.
			for(var i=0; i<13; i++){//autosizing
				sheetObjects[0].ColWidth(i) = 0
				if(sheetObjects[0].ColWidth(i)<70){
					sheetObjects[0].ColWidth(i) = 70;
	        	}
				sheetObjects[1].ColWidth(i) = sheetObjects[0].ColWidth(i);
			}
			prvId = document.form.txtid.value;	//[2010.03.16:jmh] 추가	
         }
        
        /**
         * 
         * @return
         */
        function refreshButton()
        {
        	 //ButtonObject의 변동사항을 Select해 온다. 
        	//alert('refresh');
        	 doActionIBSheet(sheetObjects[2],document.form,SEARCH01);//일단. 
        	 
        }
//         
//         /**
//          * sheet1_OnBeforeEdit 이벤트 핸들러
//          * @param sheetObj
//          * @param Row
//          * @param Col
//          * @return
//          */
//        function sheet1_OnBeforeEdit(sheetObj, Row,Col){
//        	alert(sheetObj.EditValue);
//        }
        /**
         * keypress시 delete처리 
         * @return
         */
        function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift) 
        {
        	//alert(Shift);
        	//해당키가 delete key이면 ..
			if(!isEdit){
				//ComDebug("[Debug] \n" + KeyCode + "\n");	//alert
	        	switch(KeyCode){
	        		case 46://DeleteKey click ;
		        		sheetObj.CellValue(sheetObj.SelectRow,sheetObj.SelectCol) = "";
		        		sheetObjects[1].CellValue(sheetObj.SelectRow,sheetObj.SelectCol) = "";
		        		displayExpression(sheetObj);
	        			break;
	        		case 48://숫자키 0 
	        		fillNumber("_"+(KeyCode-48));
	        			break;
	        		case 49://숫자키 1 
	        		fillNumber("_"+(KeyCode-48));
	        			break;
	        		case 50://숫자키 2 
	        		fillNumber("_"+(KeyCode-48));
	        		break;
	        		case 51://숫자키 3 
	        		fillNumber("_"+(KeyCode-48));
	        		break;
	        		case 52://숫자키 4 
	        		fillNumber("_"+(KeyCode-48));
	        		break;
	        		case 53://숫자키 5 
	        		fillNumber("_"+(KeyCode-48));
	        		break;
	        		case 54://숫자키 6 
	        		fillNumber("_"+(KeyCode-48));
	        		break;
	        		case 55://숫자키 7 
	        		fillNumber("_"+(KeyCode-48));
	        		break;
	        		case 56://숫자키 8 
	        			if(Shift==1)
	        				//fillCell("_X","*","P");	//[2010.03.17:jmh] close
	        				fillCell("_*","*","P");	//[2010.03.17:jmh] add
	        			else
	        				fillNumber("_"+(KeyCode-48));
	        		break;
	        		case 57://숫자키 9 
	        		fillNumber("_"+(KeyCode-48));
	        		break;
	        		case 96://숫자키 0 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 97://숫자키 1 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 98://숫자키 2 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 99://숫자키 3 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 100://숫자키 4 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 101://숫자키 5 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 102://숫자키 6 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 103://숫자키 7 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 104://숫자키 8 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 105://숫자키 9 
	        		fillNumber("_"+(KeyCode-96));
	        		break;
	        		case 110:
	        		case 190:
	        			fillNumber("_.");
	        			break;
	        		case 107:
//	        			fillCell("_+");
	        			fillCell("_+","+","P");
	        			break;
	        		case 187:
	        			if(Shift == 1)
	        				fillCell("_+","+","P");
//	        				fillCell("_+");
	        			break;
	        		case 109:
	        		case 189:
//	        			fillCell("_-");
	        			fillCell("_-","-","P");
	        			break;
	        		case 111:
	        		case 191:
//	        			fillCell("_/");
	        			fillCell("_/","/","P");
	        			break;
	        		case 106:
        				//fillCell("_X","*","P");	//[2010.03.17:jmh] close
        				fillCell("_*","*","P");	//[2010.03.17:jmh] add
	        			break;
	        			
	        		default : break;
	        	}
			}
//			else{//User Edit 모드이면서 
//				alert(KeyCode);
//	        	alert(Shift);
//	        	if(Shift == 1 && KeyCode == 57 )//( 이면 
//	        		braceCount++;
//	        	if(Shift == 1 && KeyCode == 48 )//) 이면
//	        		braceCount--;
//			}	
        }

         /**
          * 
          * @param sheetObj
          * @param Row
          * @param Col
          * @param CellX
          * @param CellY
          * @param CellW
          * @param CellH
          * @return
          */
         function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){ 
        	  //alert(sheetObj.CellValue(Row,Col));
        	  if(sheetObj.CellValue(Row,Col)!==""){
//        		ComShowMessage("오직 빈 셀에만 사용자 데이터를 추가 할 수 있습니다.");
        		ComShowMessage("This Cell is not empty. Delete this cell first to input user data.");
        		sheetObj.SelectCell(Row, Col);
        		return;
        	  }
        	 isEdit = true;
        	 sheetObj.CellEditable(Row, Col) = true;
        	 //sheetObj.InitDataProperty2(Row, Col, dfEngKey, "");
        	 //sheetObj.InitDataValid(Row, Col, vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
         }
         function sheet1_OnAfterEdit(sheetObj, Row,Col){
        	 sheetObj.ColWidth(Col) = 0;
         	if(sheetObj.ColWidth(Col)<70)
         		sheetObj.ColWidth(Col) = 70;
         	isEdit = false;
         	sheetObj.CellEditable(Row, Col) = false;
         	if(sheetObj.CellValue(Row, Col) !== "")
         		sheetObjects[1].CellValue(Row, Col) = sheetObj.CellValue(Row, Col)+"@C";//M -> C 
         	
         	//마지막 Cell의 경우 Row 자동 추가 처리 
			if(sheetObj.SelectCol%14==0 && sheetObj.SelectRow === sheetObj.RowCount){
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SelectCell(sheetObjects[1].SelectRow,2);
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SelectCell(sheetObjects[0].SelectRow,2);
			}
			displayExpression(sheetObj);
         } 
         /**
          * 
          * @param sheetObj
          * @param OldRow
          * @param OldCol
          * @param NewRow
          * @param NewCol
          * @return
          */
        function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        	firstFlag = true;
        	var val = sheetObj.CellValue(NewRow, NewCol);
        	if(typeof val === "undefined"){
//        		alert(1)
    			return;
    		}
        	if(val=="("||val==")"){
        		var infoVal = eval("infoArr._"+NewRow+"_"+NewCol);
        		if(typeof infoVal === "undefined"){
//        			alert(2);
        			return;
        		}
        		var splitArr = infoVal.split("_");
        		if(splitArr!=null){
        			if(splitArr.length > 1){
        				var oldVal  = eval("infoArr._"+OldRow+"_"+OldCol);
//                		if(typeof oldVal === "undefined"){
//                			alert(5);
//                			return;
//                		}
        				sheetObj.CellFontColor(NewRow, NewCol) = sheetObj.RgbColor(255, 0, 0);
        				sheetObj.CellFont("FontBold", NewRow,NewCol) = true;
//        				sheetObj.CellFont("FontItalic", NewRow,NewCol) = true;
        				sheetObj.CellFontColor(splitArr[0]*1, splitArr[1]*1) = sheetObj.RgbColor(255, 0, 0);
        				sheetObj.CellFont("FontBold", splitArr[0]*1,splitArr[1]*1) = true;
//        				sheetObj.CellFont("FontItalic", splitArr[0]*1,splitArr[1]*1) = true;
        			}
        		}
        	}
        	val = sheetObj.CellValue(OldRow, OldCol);
        	if(typeof val === "undefined"){
//        		alert(3);
    			return;
    		}
        	if(val=="("||val==")"){
        		oldVal  = eval("infoArr._"+OldRow+"_"+OldCol);
        		if(typeof oldVal === "undefined"){
//        			alert(4);
        			return;
        		}
        		if(oldVal == NewRow+"_"+NewCol) return;
        		splitArr = oldVal.split("_");
        		if(splitArr!=null){
        			if(splitArr.length > 1){
//        				alert("oldVal<<<");
        				sheetObj.CellFontColor(OldRow, OldCol) = sheetObj.CellFontColor(NewRow,1);
        				sheetObj.CellFont("FontBold", OldRow,OldCol) = false;
//        				sheetObj.CellFont("FontItalic", OldRow,OldCol) = false;
        				sheetObj.CellFontColor(splitArr[0]*1, splitArr[1]*1) = sheetObj.CellFontColor(NewRow,1);
        				sheetObj.CellFont("FontBold", splitArr[0]*1,splitArr[1]*1) = false;
//        				sheetObj.CellFont("FontItalic", splitArr[0]*1,splitArr[1]*1) = false;
        			}
        		}
        	}
        }
        /**
         * 
         */
        function fillNumber(srcName){
        	var sheetObject1 = sheetObjects[0];
        	var sheetObject2 = sheetObjects[1];
//        	alert(sheetObject1.RowCount);
        	if(sheetObject1.SelectCol == 0 || sheetObject1.SelectCol == 1 ) return;
//        	sheetObject1.ColWidth(sheetObject1.SelectCol) = 70;
        	//"_"를 기준으로 Split하여 뒷넘을 셋팅 한다. 
        	var dsp = srcName.split("_");
        	//.의 경우 이전에 .이 있는 경우는 처리 안한다. 
        	var curVal = sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol);
//        	alert(curVal.indexOf("."));
        	if(dsp[1]=="." && curVal.indexOf(".") > 0)
        		return;
        	else{
        		if(firstFlag){
//        			sheetObject1.InitCellProperty(sheetObject1.SelectRow, sheetObject1.SelectCol, sheetObject1.dtData, sheetObject1.daCenter, "", "", 
//        					sheetObject1.dfNumber, -1, -1) ;
        			sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol) = dsp[1];
        			firstFlag = false;
        		}
        		else        		
        			sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol) += dsp[1];
        	}
        	var txtNumber = sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol);
        	txtNumber = txtNumber.replace(/,/gi, '');
        	sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol) = ComAddComma(txtNumber);
        	sheetObject2.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol) = txtNumber+"@C";
        	sheetObject1.ColWidth(sheetObject1.SelectCol) = 0;
        	sheetObject2.ColWidth(sheetObject1.SelectCol) = 0;
        	if(sheetObject1.ColWidth(sheetObject1.SelectCol)<70){
        		sheetObject1.ColWidth(sheetObject1.SelectCol) = 70;
        		sheetObject2.ColWidth(sheetObject1.SelectCol) = 70;
        	}
        	
        	//------------>()
        	sheetObject1.CellFontColor(sheetObject1.SelectRow,sheetObject1.SelectCol) = sheetObject1.CellFontColor(sheetObject1.SelectRow,1);
			sheetObject1.CellFont("FontBold", sheetObject1.SelectRow,sheetObject1.SelectCol) = false;
			buildParenthesesInfo();
			
			displayExpression(sheetObject1);
        }
        
        /**
         * Cell의 내용을 채우고 Focus를 Next로 변경 한다.
         * @param srcName
         * @return
         */
        function fillCell(srcName, altValue, opt){
        	var sheetObject1 = sheetObjects[0];
        	var sheetObject2 = sheetObjects[1];
        	var formObject = document.form;
        	
        	if(sheetObject1.RowCount == 0 || sheetObject1.SelectCol == 0 || sheetObject1.SelectCol == 1 ) return;
        	//sheetObject1.ColWidth(sheetObject1.SelectCol) = 70; 
        	//"_"를 기준으로 Split하여 뒷넘을 셋팅 한다. 
        	var dsp = srcName.split("\_");
        	if(opt === "append"){
        		var curVal = sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol);
        		var strTmp = curVal.split("@");
				if(curVal.indexOf(altValue) !== -1 ) return;
				if(strTmp.length >= 2){
					if(strTmp[1] !== "O") return ; //Object Type만 Rate를 취할 수 있다. 
				}
				sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol) += " "+dsp[1];
        	}
        	else if( opt === "C" ){
        		sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol) = altValue;
        	}
        	else
        		sheetObject1.CellValue(sheetObject1.SelectRow,sheetObject1.SelectCol) = dsp[1];
//			alert("sheetObject1.SelectRow:="+sheetObject1.SelectRow+"sheetObject1.SelectCol:="+sheetObject1.SelectCol);

			if(altValue === null || altValue === "")
				sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol) = srcName;
			else{
				if(opt === null || opt === "" || opt === undefined){
//					alert("O");
					sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol) = altValue+"@O";
				}
				else if (opt === "P"){
//					alert("P");
					sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol) = altValue+"@P";
				}
				else if (opt === "F"){//일단 M로 인식 시킨다. 
//					alert("P");
					sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol) = altValue+"@C";//M->C
				}
				else if (opt === "C"){
//					alert("P");
					sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol) = altValue+"@C";
				}
				else if (opt === "append"){//Fomula만 처리 
					var curVal = sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol);
//					if(curVal.indexOf(altValue) !== -1 ) return;
					var strTmp = curVal.split("@");
					if(strTmp.length >= 2){
						sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol) = altValue+"<"+strTmp[0]+">@"+strTmp[1];
					}
					else{
						if(curVal === "" )
							sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol) = altValue+"@O";
						else
							sheetObject2.CellValue(sheetObject1.SelectRow, sheetObject1.SelectCol) = altValue+"<"+curVal+">";
					}
				}
				else{
//					alert("opt:="+opt);
					;
				}
			}
//			sheetObject1.ColWidth(sheetObject1.SelectCol) = 0;
			//AUTO COL Sizing
			sheetObject1.ColWidth(sheetObject1.SelectCol) = 0;
         	if(sheetObject1.ColWidth(sheetObject1.SelectCol)<70)
         		sheetObject1.ColWidth(sheetObject1.SelectCol) = 70;
         	
         	//Next Row Select 로직 
			var rIdx = sheetObject1.SelectCol%14==0 ? sheetObject1.SelectRow+1 : sheetObject1.SelectRow;
			var cIdx = sheetObject1.SelectCol%14==0 ? 2 : sheetObject1.SelectCol+1;
//			alert("rIdx:="+rIdx+"cIdx:="+cIdx);
			//마지막 Cell의 경우 Row 자동 추가 처리 
			if(sheetObject1.SelectCol%14==0 && sheetObject1.SelectRow === sheetObject1.RowCount){
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SelectCell(sheetObjects[1].SelectRow,2);
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SelectCell(sheetObjects[0].SelectRow,2);
			}
			//------------>()
			sheetObject1.CellFontColor(sheetObject1.SelectRow,sheetObject1.SelectCol) = sheetObject1.CellFontColor(sheetObject1.SelectRow,1);
			sheetObject1.CellFont("FontBold", sheetObject1.SelectRow,sheetObject1.SelectCol) = false;
			buildParenthesesInfo();

			sheetObject1.SelectCell(rIdx,cIdx);
			
			displayExpression(sheetObject1);
			
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
//    			doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
            }		
           
            //subjectList의 버튼 레이아웃을 innerHTML로 만든다. 
            createSubjectButtonLayout();
            
            initControl();
        }
         /**
          * form의 컨트롤 초기화 처리 및 이벤트 맵핑 처리 
          * @return
          */
         function initControl(){
//        	 axon_event.addListener('keydown', 'onKeyDown', 'form');
        	 axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        	 axon_event.addListenerForm('change', 'obj_change', form);
        	 axon_event.addListenerForm('blur', 'obj_blur', form);
        	 
        	 prvId = document.form.txtid.value;//초기 정보 설정 
         }
          function obj_change(){
        	  	//return;	//[2010.03.17:jmh] obj_change() 없앴다가 다시 살림
        		var formObject = document.form;
        	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
        	    var sheetObject1 = sheetObjects[0];
        	    var sheetObject2 = sheetObjects[1];
        	    /*******************************************************/
        		try {
        			var srcName = window.event.srcElement.getAttribute("name");
        	        switch(srcName) {
        	            case "txtid":
        	            	if(prvId===""){
        	            		prvId = formObject.txtid.value;
        	            	} else if(prvId!=="" && prvId!==formObject.txtid.value && sheetObjects[0].RowCount > 0 ){
	        	            	//[2010.03.16:jmh] Confirm 없앴다가 다시 살림
        	            		if(ComShowConfirm("Are you sure to save this to other ID ?")){
	        	            		prvId = formObject.txtid.value;
	        	            	} else{
		        					sheetObject1.RemoveAll();
		        					sheetObject2.RemoveAll();
		        					prvId = formObject.txtid.value;
		        				}

        	            	} else{
        	            		if(sheetObjects[0].RowCount > 0){
        	            			formObject.txtid.value = prvId;
        	            		}	
        	            	}
        	            	
        	            	displayExpression(sheetObjects[0]);
        	            	break;
        	            default : break;
        	        }
        		}catch(e) {
        			if( e == "[object Error]") {
        				ComShowCodeMessage('VSK00011');
        			} else {
        				ComShowMessage(e);
        			}
        		}
        	}
          
			function obj_blur(){
				return;
			
				var formObj = document.form;
				var obj = event.srcElement;
				
				switch(obj.name) {
					case "txtid":
						var curId = obj.value; 
						removeSheet();
		        	break;
	            }
			}
			
			function removeSheet(){
				var formObj = document.form;
				var curId = formObj.txtid.value;
			
				if(curId != prvId && curId != ""){
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					var dspXpr = document.getElementById("dspXpr");
					dspXpr.innerHTML = "";							
				}
				
				prvId = curId;
			}
          
          /**
           * Form Obj를 클릭했을 경우 전역 플라그 설정.
           * @return
           */
          function setFlag(mode){
        	  var formObject = document.form;
        	  isForm = true;
        	  
        	  var opr = document.getElementById("oprpanel");
        	  var cons = document.getElementById("consTbl");
        	  if(formObject.radioflag[0].checked){//Formula의 경우 숨김
        		  opr.style.display = "none";
        		  cons.style.display = "none";
        	  }
        	  else{
        		  opr.style.display = "";
        		  cons.style.display = "";
        		  if(parent!=null && typeof parent.syncHeight != 'undefined')
        			  parent.syncHeight();//부모프레임에 높이 Sync함수 콜 
        	  }
        	  //현재 모드가.. 이전 모드와 바뀌었는지 체크 
        	  if(chkMode !== mode){
        		  chkMode = mode;
//        		  //clear Data. 
//        		  sheetObjects[0].RemoveAll();
//        		  sheetObjects[1].RemoveAll();
        	  }
        		  
          }

          /**
           * 강제로 IBSheet에 포커싱한다.
           * @return
           */
          function setFocusIBsheet(){
//        	   alert(document.form.txtid.focus());
        	  var sheetObject1 = sheetObjects[0];
        	  if(!isForm){
        		  ComSetFocus(document.form.sheet1);
        		  sheetObject1.SelectCell(sheetObject1.SelectRow, sheetObject1.SelectCol);
        	  }
        	  else
        		  isForm = false;
//			  alert("sheetObject1.SelectRow:sheetObject1.SelectCol"+sheetObject1.SelectRow+":"+sheetObject1.SelectCol);
//			  alert("setFocusIBsheet");
          }
           /**
            * KEY_DOWN이벤트 처리 
            * @return
            */
          function onKeyDown(){
//            if(isForm)//Form에 포커싱 된 경우만 Retrieve 한다. 
        	  ComKeyEnter();
          }
          function onBlur(){
        	  alert("onBlur");
          }
          /**
           * 
           * @return
           */
           function obj_keypress(){
   	    	 obj = event.srcElement;
   	    	 if(obj.dataformat == null) return;
   	    	 	
   	    	 window.defaultStatus = obj.dataformat;
   	    	 
   	    	 switch(obj.dataformat) {
   	    	 	case "y": 
   	    	 	case "ym": 
   	    	 	case "ymd":
   	    	 		ComKeyOnlyNumber(obj);
   	    	 		break;
   	    	 	case "num":
   	    	 		if(obj.name=="vndr_seq"){
   	    	    		ComKeyOnlyNumber(obj,",");
   	    	    	} else {
   	    	    		ComKeyOnlyNumber(obj);
   	    	    	}
   	    	        break;
   	    	    case "eng":
   	    	        ComKeyOnlyAlphabet(); 
   	    	        break;
   	    	    case "engup":
   	    	        //if(obj.name=="vsl_slan_cd") ComKeyOnlyAlphabet('uppernum')
   	    	        //else 
   	    	        ComKeyOnlyAlphabet('upper');
   	    	        break;
   	    	    case "engdn":
   	    	        //if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
   	    	        //else 
   	    	        ComKeyOnlyAlphabet('lower');
   	    	        break;
   	    	 }
   	     }
         /** 
          * Object 의 activate 이벤트에 대한 처리  <br>
          * @param  없음
          * @return 없음
          * @author 김창식
          * @version 2009.05.20
          */
         function obj_deactivate(){
        	  //다른 넘이 activate되더라도 sheet1Object로 포커싱 
        	  alert("obj_deactivate:>>"+event.srcElement);
         }
          /**
           * 추가 함수 버튼을 보이거나 숨긴다 Toggle
           */
          function showAddFuncs(obj){
        	  var panel = document.getElementById("additonalFuncs");
        	  panel.style.display = obj.innerHTML=== "▼" ?  "":"none";
        	  obj.innerHTML = obj.innerHTML === "▼" ?  "▲":"▼";
        	  if(parent!=null && typeof parent.syncHeight != 'undefined' && obj.innerHTML=== "▲")
    			  parent.syncHeight();//부모프레임에 높이 Sync함수 콜 
          }
         /**
          * subjectList의 버튼 레이아웃을 innerHTML로 만든다. 
          * @return
          */
         function createSubjectButtonLayout(){
        	 var formObj = document.form;
        	 var btnList = document.getElementById("btnList");
        	 //979+200
        	 //style=\"background-color: #E9E9E9; border:4px solid #E9E9E9\";
        	 var strInnerHMTL = "<table class=\"search_sm2\" border=\"0\" width=\"979\">"
             //var strInnerHMTL = "<table  style=\"overflow-y:auto;background-color: #E9E9E9; border:4px solid #E9E9E9\" border=\"0\" width=\"979\">"
							  + "	<tr class=\"h23\">"
							  + "		<td width=\"60\" rowspan=\"0\" valign=\"top\">Subject </td>";

        	 var prvRow = "1";
        	 var colCount = 10;//table의 한 row당 컬럼갯수 
        	 for(var i=0; i<btnObjects.length; i++){
//             	alert(btnObjects[i].name);
        		 if(prvRow !== btnObjects[i].row ){
        			 if(colCount > 1)//10컬럼을 못 채우면 colspan 으로 채움
        				 strInnerHMTL += "<td colspan=\""+colCount+"\"></td></tr><tr class=\"h23\"><td></td>";
        			 else
        				 strInnerHMTL += "</tr><tr class=\"h23\"><td></td>";

        			 prvRow = btnObjects[i].row;
        			 colCount = 10;
        		 }
        		 else{
        			 if(colCount == 0){//10컬럼 채우면 줄바꿈
        				 strInnerHMTL += "</tr><tr class=\"h23\"><td>&nbsp;</td>";
        				 colCount = 10;
        			 }
        		 }
        		 strInnerHMTL +="<td width=\"108px\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">";
        		 strInnerHMTL +="<tr><td class=\"btn2_left\"></td>";
        		 switch(prvRow){//TD의 Color변경 
        		 case "1":
        			 strInnerHMTL +="<td style=\"color:black;\" ";
        			 break;
        		 case "2":
        			 strInnerHMTL +="<td style=\"color:red;\" ";
        			 break;
        		 case "3":
        			 strInnerHMTL +="<td style=\"color:blue;\" ";
        			 break;
        		 default:
        			 strInnerHMTL +="<td ";
        			 break;
        		 }
        		 strInnerHMTL += "class=\"btn2\" name=\"btn1_"+btnObjects[i].name+"\" title=\""+btnObjects[i].name+":"+btnObjects[i].uom+"\" alt=\""+btnObjects[i].no+"\">"+btnObjects[i].dspname+"</td>"
        			 		  +"<td class=\"btn2_right\"></td>"
							  +"</tr>"
							  +"</table></td>";
        		 colCount--;
        	 }
        	 
        	 //+Rate Button과 DeleteButton을 넣는다.
        	 strInnerHMTL += "</tr><tr class=\"h23\">                                                                    "
        		 +"	<td	colspan=\"9\">			                                                          "
        		 +"	<td width=\"108px\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">"
        		 +"		<tr><td class=\"btn2_left\"></td>                                                 "
        		 +"		<td class=\"btn2\" name=\"btn2_Rate\" style=\"color:#3399ff;\">+Rate</td><!-- name변경 : btn1_Rate를 btn2_Rate로  -->             "
        		 +"		<td class=\"btn2_right\"></td>                                                    "
        		 +"		</tr>                                                                           "
        		 +"		</table></td>                                                                   "
        		 +"	<td width=\"108px\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">"
        		 +"		<tr><td class=\"btn2_left\"></td>                                                 "
        		 +"		<td class=\"btn2\" name=\"btn1_1_Delete\" style=\"color:#3399ff;\">Delete</td>        "
        		 +"		<td class=\"btn2_right\"></td>                                                    "
        		 +"		</tr>                                                                           "
        		 +"		</table></td>                                                                   ";
        	 
        	 strInnerHMTL += "</tr>"
        		 		  + "</table>";
        	 //alert(strInnerHMTL);
        	 var txtDebug = document.getElementById("txtDebug");
        	 txtDebug.value = strInnerHMTL;
        	 btnList.innerHTML = strInnerHMTL;
        	 
// 			alert(typeof parent.syncHeight === "undefined" ? "1":"0");
 			if(parent!=null && typeof parent.syncHeight != "undefined"){
 				parent.syncHeight();//부모프레임에 높이 Sync 함수 콜
 			}
			
         }

    	 /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt = 0;
            switch(sheetObj.id) {
                
    			case "sheet1":      //sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 162;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 15, 100);

    					var HeadTitle1 = "||A|B|C|D|E|F|G|H|I|J|K|L|M";
//    					var HeadTitle2 = "||||||||||||||";
    					var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, true, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle1, false);
//                        InitHeadRow(1, HeadTitle2, false);
                        var prefix = "sheet1_";
                        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefix+"ibflag");
                        
    					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk",			false,		"",				dfNone,		0,			true,		true);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col1",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col2",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col3",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col4",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col5",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col6",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col7",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col8",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col9",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col10",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col11",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col12",			false,      "",				dfEngKey,		0,			false,		false);
    					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		prefix+"col13",			false,      "",				dfEngKey,		0,			false,		false);
    					
    					InitDataValid(0, prefix+"col1", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col2", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col3", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col4", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col5", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col6", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col7", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col8", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col9", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col10", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col11", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col12", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					InitDataValid(0, prefix+"col13", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
    					
    					CountPosition = 0;
    					
//    					MultiSelection = true;
    					SelectionMode = smSelectionFree; //추가
    				}
                    break;
    			case "sheet2":      //sheet2 쌀집계산기 Hidden쉬트
    			with (sheetObj) {
    				
    				// 높이 설정
    				style.height = 102;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				
    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				
    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;
    				
    				//전체Edit 허용 여부 [선택, Default false]
    				Editable = true;
    				
    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 15, 100);
    				
    				var HeadTitle1 = "||COL1|COL2|COL3|COL4|COL5|COL6|COL7|COL8|COL9|COL10|COL11|COL12|COL13";
    				var headCount = ComCountHeadTitle(HeadTitle1);
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(false, true, true, true, false,false)
    				
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				var prefix = "sheet2_";
    				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefix+"ibflag");
    				
    				InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"del_chk",			false,		"",				dfNone,		0,			true,		true);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col1",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col2",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col3",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col4",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col5",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col6",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col7",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col8",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col9",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col10",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col11",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"col12",			false,      "",				dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		prefix+"col13",			false,      "",				dfNone,		0,			false,		false);
    				
    				CountPosition = 0;
    			}
    			break;
                    
    			case "sheet3":      //hidden sheet
	                with (sheetObj) {
	
	                    // 높이 설정
	                    style.height = 0;
	                    //전체 너비 설정
	                    SheetWidth = mainTable.clientWidth;
	
	                    //Host정보 설정[필수][HostIp, Port, PagePath]
	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    			}
	    			break;
            }
        }

        /**
         * 괄호 () 쌍의 갯수만 체크 
         * @return
         */
        function validateParentheses(){
        	var sheet1 = sheetObjects[0];
        	var sheet2 = sheetObjects[1];
        	var rowCount = sheet1.RowCount;
        	var txt = "";
        	var len = 0;
            var pCnt = 0;
        	for(var row=1 ; row<=rowCount; row++ ){
        		for(var col=2; col<15; col++){
        			if(sheet2.CellValue(row, col).indexOf("@O")==-1){
        				txt = sheet1.CellValue(row, col);
	        			if(txt!=""){
	        				len = txt.length;
	        				for(var i=0; i<len;i++){
	        					if(txt.indexOf("(",i)!=-1){
	        						i = txt.indexOf("(",i);
	        						pCnt++;
	        					}
	        				}
	        				for(var i=0; i<len;i++){
	        					if(txt.indexOf(")",i)!=-1){
	        						i = txt.indexOf(")",i);
	        						pCnt--;
	        					}
	        				}
	        			}
        			}
        		}
        	}
        	return pCnt;
        }
        
        function displayExpression(sheetObj){
        	var dspXpr = document.getElementById("dspXpr");
        	var strXpr = "";

        	if(sheetObj.RowCount > 0){
				for(var row=1;row<=sheetObj.RowCount;row++){
					
					if(sheetObj.RowStatus(row) == "D") continue;	//[2010.03.16:jmh] 추가	
					
					for(var col=2;col<15;col++){
						if(sheetObj.CellValue(row, col)!=""){
							strXpr += sheetObj.CellValue(row, col) + " ";
						} else{
							continue;
						}
					}
				}
				dspXpr.innerHTML = strXpr;
				if(parent!=null && typeof parent.syncHeight != 'undefined')
      			  parent.syncHeight();//부모프레임에 높이 Sync함수 콜 
			} else{
				dspXpr.innerHTML = "";	//[2010.03.02:jmh]
			}
        }

    	// Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            var sheetObject1 = sheetObjects[0];
    		var sheetObject2 = sheetObjects[1];
    		var sheetObject3 = sheetObjects[2];
    		var saveObjs = new Array(2);
    		saveObjs[0] = sheetObject1;
    		saveObjs[1] = sheetObject2;

    		sheetObject1.WaitImageVisible=false;
    		sheetObject2.WaitImageVisible=false;
    		sheetObject3.WaitImageVisible=false;
    		
    		switch(sAction) {

            	case SEARCH01://
//            		if(validateForm(sheetObj,formObj,sAction)){
            			ComOpenWait(true);
            			formObj.f_cmd.value = SEARCH01;//2번으로 
//            			sheetObj.DoSearch("TrainingMaterialsGS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
            			//alert("SEARCH01");
            			var sXml = sheetObj.GetSearchXml("VOP_PSO_0007GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
//            			alert(sXml);
            			var data = ComGetEtcData(sXml,"BTNLIST");
            			//alert(data);
            			
            			eval(data);
            			
            			createSubjectButtonLayout();
            			ComOpenWait(false);
//            		}
            		break;
    			case IBSEARCH:      //조회 Retrive BtnClick 
    				if(validateForm(sheetObj,formObj,sAction)){
    					ComOpenWait(true);
    					formObj.f_cmd.value = SEARCH;
    					var aryPrefix = new Array("sheet1_", "sheet2_"); //prefix 문자열 배열
    					var sXml = sheetObj.GetSearchXml("VOP_PSO_0007GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
    					var sXmls = sXml.split('|$$|');
    					//alert(sXmls.length);
    					for(var i=0; i<sXmls.length;i++){
//    						alert(sXmls[i]);
    						sheetObjects[i].LoadSearchXml(sXmls[i]);
    					}
//    					sheetObj.DoSearch("VOP_PSO_0007GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
//    					if ("sheet1" == sheetObj.id)sheetObj.DoSearch("UI_PSO_0007_DATA.html");
						//불러온 값을 dspXpr에 표시 한다. 
						displayExpression(sheetObj);
						ComOpenWait(false);
    				}
                break;

    			case IBDELETE:        //삭제
	    			if(validateForm(sheetObj,formObj,sAction)){
	    				ComOpenWait(true);
	    				formObj.f_cmd.value = REMOVE;
	    				var sXml = null;
	    				var dspXpr = document.getElementById("dspXpr");
	    				if(formObj.radioflag[0].checked === true){
    						if(ComShowCodeConfirm("PSO09012", "Formula", formObj.txtid.value)){
    							sXml = sheetObj.GetSearchXml("VOP_PSO_0007GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
    	    					sheetObj.LoadSearchXml(sXml);//Message 를 뿌릴려면 Load 를 sheet 에 해야 된다.
    	    					//해당 sheet 의 데이터를 모두 지운다. 
    	    					sheetObject1.RemoveAll();
    	    					sheetObject2.RemoveAll();
    	    					dspXpr.innerHTML = "";
    						}
    					} else{
    						if(ComShowCodeConfirm("PSO09012", "Condition", formObj.txtid.value)){
    							sXml = sheetObj.GetSearchXml("VOP_PSO_0007GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
    	    					sheetObj.LoadSearchXml(sXml);//Message 를 뿌릴려면 Load 를 sheet 에 해야 된다.
    	    					//해당 sheet 의 데이터를 모두 지운다. 
    	    					sheetObject1.RemoveAll();
    	    					sheetObject2.RemoveAll();
    	    					dspXpr.innerHTML = "";
    						}
    					}
	    				ComOpenWait(false);
            		}
	    			break;
	    			
    			case IBSAVE:        //저장
    				if(!validateForm(sheetObj,formObj,sAction)) return;
    			    var pCnt = validateParentheses(); 
    			    if(pCnt!=0)
    			    {
    					ComShowMessage("Parentheses must be correct. Parenthesis count="+pCnt);
    					return ;
    				}
    			    ComOpenWait(true);
				  	formObj.f_cmd.value = MULTI;
//				  	for(var i=0; i<saveObjs.length;i++){
//				  		for(var j=saveObjs[i].HeaderRows ; j<=saveObjs[i].RowCount;j++)//강제로 Insert로 만든다
//				  			saveObjs[i].CellValue2(j,0) = "I";
//				  	}

					var SaveStr = ComGetSaveString(saveObjs); // 배열입니다.
					if(SaveStr.length <= 0 ){
						ComOpenWait(false);
						ComShowCodeMessage("PSO00036", formObj.radioflag[0].checked == true ? "formula data" : "condition data");
						return;
					}

					var aryPrefix = new Array("sheet1_", "sheet2_");	//prefix 문자열 배열	
					var sXml = sheetObject1.GetSaveXml("VOP_PSO_0007GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					
					var error = ComGetEtcData(sXml , "ERROR");
					if(ComTrim(error) == "Y"){
						ComOpenWait(false);
						ComShowMessage("Not defined object Rate, please check it again.");	//필수
						return;
					}
					ComOpenWait(false);
					var new_id = ComGetEtcData(sXml, "NEW_ID");
					if(new_id != undefined && new_id != ""){	//신규생성이면 NEW_ID를 찍어준다.
						prvId = new_id;
						formObj.txtid.value = new_id; 
					}
					sheetObjects[0].LoadSaveXml(sXml);//Hidden Object 에 로드
					break;
					
    			case SEARCH02:     
    				formObj.f_cmd.value = SEARCH02; 
        			var sXml = sheetObj.GetSearchXml("VOP_PSO_0007GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
        			var rtVal = ComGetEtcData(sXml, "AUTO_NO");
        			formObj.txtid.value = rtVal;
        			
        			break;
				default : 
					break;
            }
        }


        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
				
			    var id = txtid.value; 
			    
				switch(sAction) {
					case IBSEARCH:
					    if(id == ""){
					    	ComShowCodeMessage("PSO00003", "ID");
					    	ComSetFocus(formObj.txtid);
					    	return false;
					    }
						break;
					
					case IBSAVE:
					    if(id == ""){
					    	ComShowCodeMessage("PSO00003", "ID");
					    	ComSetFocus(formObj.txtid);
					    	return false;
					    }
						break;
						
					case IBDELETE:
					    if(id == ""){
					    	ComShowCodeMessage("PSO00003", "ID");
					    	ComSetFocus(formObj.txtid);
					    	return false;
					    }
						break;
				}
            }

            return true;
        }
        
        
        
        /**
         * sysDscTbl Toggle Displaying.
         * @return
         */
        function showDscTbl(){
        	var dsctbl = document.getElementById("sysDscTbl");
        	dsctbl.style.display = dsctbl.style.display === "" ? "none":"";
        	var dbgWin = document.getElementById("txtDebug");
        	dbgWin.style.display = dbgWin.style.display === "" ? "none":"";
        }
	/* 개발자 작업  끝 */