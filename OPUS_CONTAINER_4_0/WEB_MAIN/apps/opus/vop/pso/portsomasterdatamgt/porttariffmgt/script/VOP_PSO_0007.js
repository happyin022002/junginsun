/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0007.js
*@FileTitle  : Formula & Condition Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================**/

/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// public variable

var sheetObjects=new Array();
var sheetCnt=0;

var firstFlag=true;
var isEdit=false;
var isForm=false;
var prvId="";
var chkMode="1";//
var infoArr=new Array();

// Event handler processing by button click event */
document.onclick=processButtonClick;
//Making information of ()
function buildParenthesesInfo(){
	var infostack=new Array();
	infoArr=new Array();
	var stackidx=0;
	var infoidx=0;
	var sheetObject1=sheetObjects[0];
	var rowCnt=sheetObject1.RowCount();
	for(var row=1; row<rowCnt+1; row++){
		for(var col=2; col<15; col++){
			var txt=sheetObject1.GetCellValue(row,col);
			var regexp=new RegExp(/\(|\)/g);
			if(txt.indexOf("(")!=-1 || txt.indexOf(")")!=-1){
				for(var i=0; i<txt.length;i++){
		    	    var info=regexp.exec(txt);
		    	    if(info==null)
		    	    	break;
		    	    else{
			    		if(info=="("){//PUSH
			    		  infostack[stackidx++]=row+"_"+col;
			    		}
			    	    else{//POP
			    	      var popVal=infostack[stackidx-1];
			    	      eval("infoArr._"+popVal+"=\""+row+"_"+col+"\"");
			    	      eval("infoArr._"+row+"_"+col+"=\""+popVal+"\"");
			    	      infoArr[infoidx++]=infostack[stackidx-1] + "|" + row+"_"+col;
			    		  infostack[stackidx-1]="";//clear
			    		  stackidx--;
			    		}
		    	    }
				}
			}
		}
	}
}
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		var altValue=ComGetEvent("alt");
        switch(srcName) {
        	case "btng_Cell_Add":
        		//current Row Col
        		var rowIdx=sheetObject1.GetSelectRow();
        		var colIdx=sheetObject1.GetSelectCol();
        		if(colIdx<2||colIdx>14) return;
        		if(sheetObject1.GetCellValue(sheetObject1.RowCount(), "sheet1_col13") != "")
        		{
        			sheetObject1.DataInsert(-1);
        			sheetObject2.DataInsert(-1);
        			sheetObject1.SelectCell(rowIdx,colIdx);
        		}
        		for(var row=sheetObject1.RowCount(); row >= rowIdx ; row--)
        		{
        			for(var col=14; col >= 2; col--)
        			{
        				if(row == rowIdx && col == colIdx){
        					sheetObject1.SetCellValue(row, col,"",0);
        					sheetObject2.SetCellValue(row, col,"",0);
        					break;
        				}
        				if(col==2){
        					if(row - 1 > 0){
        						sheetObject1.SetCellValue(row, col,sheetObject1.GetCellValue(row-1, 14),0);
        						sheetObject2.SetCellValue(row, col,sheetObject2.GetCellValue(row-1, 14),0);
        					}
        				}
        				else{
        					sheetObject1.SetCellValue(row, col,sheetObject1.GetCellValue(row, col-1),0);
        					sheetObject2.SetCellValue(row, col,sheetObject2.GetCellValue(row, col-1),0);
        				}
        			}
        		}
        		for(var i=2; i<15; i++){
        			sheetObject1.SetColWidth(i,0);
        			if(sheetObject1.GetColWidth(i)<70){
        				sheetObject1.SetColWidth(i,70);
        			}
        		}
        		for(var row=sheetObject1.RowCount(); row >= rowIdx ; row--)
        		{
        			for(var col=14; col >= 2; col--)
        			{                 				
        				sheetObject1.SetCellFontColor(row, col,sheetObject1.GetCellFontColor(row,1));
        				sheetObject1.SetCellFont("FontBold", row,col,0);
        			}
        		}
        		buildParenthesesInfo();
        		displayExpression(sheetObject1);
        		break;
        	case "btng_Cell_Delete":
        		//current Row Col
        		var rowIdx=sheetObject1.GetSelectRow();
        		var colIdx=sheetObject1.GetSelectCol();
        		if(colIdx<2||colIdx>14) return;
        		for(var row=rowIdx; row <= sheetObject1.RowCount(); row++)
        		{
        			var col=colIdx;
        			if(row!=rowIdx) col=2;
        			for(; col <= 14; col++)
        			{
        				if(col==14){
        					if(row + 1 <= sheetObject1.RowCount()){
        						sheetObject1.SetCellValue(row, col,sheetObject1.GetCellValue(row+1, 2),0);
        						sheetObject2.SetCellValue(row, col,sheetObject2.GetCellValue(row+1, 2),0);
        					}
        				}
        				else{
        					sheetObject1.SetCellValue(row, col,sheetObject1.GetCellValue(row, col+1),0);
        					sheetObject2.SetCellValue(row, col,sheetObject2.GetCellValue(row, col+1),0);
        				}
        			}
        		}
        		sheetObject1.SetCellValue(row-1, col-1,"",0);
		    	sheetObject2.SetCellValue(row-1, col-1,"",0);
        		for(var i=2; i<15; i++){
        			sheetObject1.SetColWidth(i,0);
        			if(sheetObject1.GetColWidth(i)<70){
        				sheetObject1.SetColWidth(i,70);
        			}
        		}
        		for(var row=rowIdx; row <= sheetObject1.RowCount(); row++)
        		{
        			for(var col=14; col >= 2; col--)
        			{                 				
        				sheetObject1.SetCellFontColor(row, col,sheetObject1.GetCellFontColor(row,1));                 				
        				sheetObject1.SetCellFont("FontBold", row,col,0);
        			}
        		}
        		buildParenthesesInfo();
        		displayExpression(sheetObject1);
        		break;
            case "dscTbl":
            	break;
        	case "btn_foml_cond":
        		var flg=formObject.radioflag[0].checked ? "1":"2";
        		var turl="/opuscntr/VOP_PSO_0209.do?formcond="+flg;	//Retrieving only UPD_MNU_NO IN (1, 2)
				ComOpenPopup( turl , 900, 500, 'setFomlCondId', '0,0', true, true);
            	break;
        	case "radioflag":
        	case "txtid":
        		break;
        		//======SubjectFavorites Btn Click ============/
            case "btn_Subject_Favorites":
            	var turl="/opuscntr/VOP_PSO_0208.do";
				ComOpenPopup( turl , 870, 676, 'refreshButton', 'none', true, true);
            	break;
            	//================= Main ====================//
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);//Retrieving Formula or Condtion Information
				for(var i=0; i<13; i++){//autosizing
					sheetObjects[0].SetColWidth(i,0);
					if(sheetObjects[0].GetColWidth(i)<70){
						sheetObjects[0].SetColWidth(i,70);
		        	}
					sheetObjects[1].SetColWidth(i,sheetObjects[0].GetColWidth(i));
				}
				if(sheetObjects[0].RowCount()> 0) buildParenthesesInfo();
				break;
			case "btn_New":
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				formObject.txtid.value="";
				ComSetFocus(formObject.txtid);
				var dspXpr=document.getElementById("dspXpr");
				dspXpr.innerHTML="";
			break;
			case "btn_Delete":
				doActionIBSheet(sheetObjects[2],document.form,IBDELETE);//Deleting using Hidden Sheet
				break;
			case "btn_Save":
				//Setting inflag to "I" except "D"
				for(var i=0;i<sheetObjects[0].RowCount();i++){
					if(sheetObjects[0].GetCellValue(i+1, 0) != "D"){
						sheetObjects[0].SetCellValue(i+1, 0,"I",0);
						sheetObjects[1].SetCellValue(i+1, 0,"I",0);
					}
					
					//NYK Modify 2014.11.13
					/*for(var j=sheetObjects[0].SaveNameCol("sheet1_col1") ; j<=sheetObjects[0].LastCol() ; j++){
						var tmpCellValue = sheetObjects[0].GetCellValue(i+1, j);
						if(tmpCellValue == "Rate"){
							ComShowCodeMessage("PSO01005");//In case of using Rate  please click "+Rate" button.  For example : GRT (click GRT object button) +Rate(click +Rate button) within a cell
							return;
						}
					}*/
				}
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);//Save
			break;
			//================= Main ====================//
			//================= Grid ====================//
			case "btng_Row_Add":
				var id = formObject.txtid.value;
				if(id == ""){
			    	ComShowCodeMessage("PSO00003", "ID");
			    	ComSetFocus(formObject.txtid);
			    	return false;
			    }
				
				//fillCell(srcName);
				sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SelectCell(sheetObjects[1].GetSelectRow(),2);
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(),2);
			break;
			case "btng_Row_Delete":
				//fillCell(srcName);
				var selcnt=0;
			    for(var i=0;i<sheetObject1.RowCount()+1;i++){
			    	if(sheetObject1.GetCellValue(i, 1)==1){
			    		sheetObject2.SetCellValue(i, 1,1);
			    		selcnt++;
			    	}
			    }
			    ComRowHideDelete(sheetObject1, "sheet1_del_chk");
			    if(selcnt > 0 ){
			    	ComRowHideDelete(sheetObject2, "sheet2_del_chk");
			    }
			    
				if(sheetObjects[0].RowCount()> 0 ){
					sheetObjects[1].SelectCell(1, 2); //focusing to (1,1) cell
					sheetObjects[0].SelectCell(1, 2); //focusing to (1,1) cell
				}
				buildParenthesesInfo();
				
				displayExpression(sheetObject1);
			break;
			//================= Grid ====================//
			//================= Subject ====================//
			case "btn1_NRT":
			case "btn1_GRT":
			case "btn1_Draft":
			case "btn1_LOA":
			    fillCell(srcName, altValue);
			    break;
			case "btn1_LBP":
			case "btn1_SCNT":
			case "btn1_DWT":
			case "btn1_Berthing_Hour":
			case "btn1_Tug_Used_Hour":
			case "btn1_No_of_Tug":
			case "btn1_Line_Tractor":
			case "btn1_Water_Volume":
			case "btn1_Anchoring_Hour":
				fillCell(srcName, altValue);
				break;
			case "btn1_Rate":    	
	        	if(sheetObjects[0].RowCount()== 0 || sheetObjects[0].GetSelectCol()== 0 || sheetObjects[0].GetSelectCol()== 1 ){
	        		return;
	        	}    		        	
	        	var curVal=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol());
	        	if(curVal != ""){
	        		return;
	        	}
				fillCell(srcName, "45", "append");
				break;
			case "btn2_Rate":	//+Rate
	        	if(sheetObjects[0].RowCount()== 0 || sheetObjects[0].GetSelectCol()== 0 || sheetObjects[0].GetSelectCol()== 1 ) return;
	        	var curVal=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol());
	        	if(curVal == "") return;
				fillCell(srcName, "45", "append");
				break;
			case "btn1_1_Delete":
				sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),"");
				sheetObjects[1].SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),"");
				buildParenthesesInfo();
				displayExpression(sheetObject1);
				break;
			//================= Subject ====================//
			//================= Number ====================//
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
				break;
			case "btn2_.":
				fillNumber(srcName);
				break;
			//================= Number ====================//
			//================= Operator ====================//
			case "btn2_X":
				fillCell(srcName,"*","P");
				break;
			case "btn2_*":
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
				fillCell(srcName,"AND","P");
				break;
			case "btn3_Or":
				fillCell(srcName,"OR","P");
				break;
			case "btn3_Y":
				fillCell(srcName,"'Y'","C");
				break;
			case "btn3_N":
				fillCell(srcName,"'N'","C");
				break;
			case "btn3_(":
				fillCell(srcName,"(","P");
				buildParenthesesInfo();
				break;
			case "btn3_)":
				fillCell(srcName,")","P");
				buildParenthesesInfo();
				break;
			case "btn3_>":
				fillCell(srcName,">","P");
				break;
			case "btn3_>=":
				fillCell(srcName,">=","P");
				break;
			/*case "btn3_<":
				//alert(srcName);
				fillCell(srcName,"<","P");
				break;*/
			case "btn3_c1":
				srcName = "btn3_<";
				fillCell(srcName,"<","P");
				break;
			case "btn3_<=":
				fillCell(srcName,"<=","P");
				break;
			case "btn3_=":
				fillCell(srcName,"=","P");
				break;
			case "btn3_!=":
				fillCell(srcName,"!=","P");
				break;
			case "btn3_IN":
				fillCell(srcName,"IN","P");
				break;//2010.01.27 bug fix
			case "btn3_NOT IN"://2009.12.10 add
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
			case "dspXpr":
				return;
				break;
			default:
				if(srcName!=null&&srcName!=""&&srcName!="undefined")
					fillCell(srcName, altValue);
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
 * Filling in Formula or Condition data
 * @return
 */
function setFomlCondId(aryPopupData, row, col, sheetIdx){
	var id=aryPopupData[0][1].trim(); 
	if(id == "ID"){
		document.form.txtid.value="";
		prvId="";
		return;
	}
	var sheetObject=sheetObjects[0];
	var prefix="sheet1_"
		
	document.form.txtid.value=id;
	ComSetFocus(document.form.txtid);
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);//Retrieving Formula or Condtion
	for(var i=0; i<13; i++){//autosizing
		sheetObjects[0].SetColWidth(i,0);
		if(sheetObjects[0].GetColWidth(i)<70){
			sheetObjects[0].SetColWidth(i,70);
    	}
		sheetObjects[1].SetColWidth(i,sheetObjects[0].GetColWidth(i));
	}
	prvId=document.form.txtid.value;
 }
/**
 * 
 * @return
 */
function refreshButton()
{
	 doActionIBSheet(sheetObjects[2],document.form,SEARCH01);
}
/**
 * Handling keypress event
 * @return
 */
function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift) 
{
	if(!isEdit){
    	switch(KeyCode){
    		case 46://DeleteKey click ;
        		sheetObj.SetCellValue(sheetObj.GetSelectRow(),sheetObj.GetSelectCol(),"");
        		sheetObjects[1].SetCellValue(sheetObj.GetSelectRow(),sheetObj.GetSelectCol(),"");
        		displayExpression(sheetObj);
    			break;
    		case 48://Number 0 
    			fillNumber("_"+(KeyCode-48));
    			break;
    		case 49://Number 1 
    			fillNumber("_"+(KeyCode-48));
    			break;
    		case 50://Number 2 
	    		fillNumber("_"+(KeyCode-48));
	    		break;
    		case 51://Number 3 
	    		fillNumber("_"+(KeyCode-48));
	    		break;
    		case 52://Number 4 
	    		fillNumber("_"+(KeyCode-48));
	    		break;
    		case 53://Number 5 
	    		fillNumber("_"+(KeyCode-48));
	    		break;
    		case 54://Number 6 
	    		fillNumber("_"+(KeyCode-48));
	    		break;
    		case 55://Number 7 
	    		fillNumber("_"+(KeyCode-48));
	    		break;
    		case 56://Number 8 
    			if(Shift==1){
    				fillCell("_*","*","P");
    			}else{
    				fillNumber("_"+(KeyCode-48));
    			}
    			break;
    		case 57://Number 9 
	    		fillNumber("_"+(KeyCode-48));
	    		break;
    		case 96://Number 0 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 97://Number 1 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 98://Number 2 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 99://Number 3 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 100://Number 4 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 101://Number 5 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 102://Number 6 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 103://Number 7 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 104://Number 8 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 105://Number 9 
	    		fillNumber("_"+(KeyCode-96));
	    		break;
    		case 110:
    		case 190:
    			fillNumber("_.");
    			break;
    		case 107:
    			//fillCell("_+");
    			fillCell("_+","+","P");
    			break;
    		case 187:
    			if(Shift == 1)
    				fillCell("_+","+","P");
    			//fillCell("_+");
    			break;
    		case 109:
    		case 189:
    			//fillCell("_-");
    			fillCell("_-","-","P");
    			break;
    		case 111:
    		case 191:
    			//fillCell("_/");
    			fillCell("_/","/","P");
    			break;
    		case 106:
				fillCell("_*","*","P");
    			break;
    		default : break;
    	}
	}
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
	 if(sheetObj.GetCellValue(Row,Col)!==""){
		ComShowMessage("This Cell is not empty. Delete this cell first to input user data.");
		sheetObj.SelectCell(Row, Col);
		return;
	  }
	 isEdit=true;
	 sheetObj.SetCellEditable(Row, Col,1);
	 //sheetObj.InitDataProperty2(Row, Col, dfEngKey, "");
	 //sheetObj.InitDataValid(Row, Col, vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
 }
 function sheet1_OnAfterEdit(sheetObj, Row,Col){
	 sheetObj.SetColWidth(Col,0);
 	if(sheetObj.GetColWidth(Col)<70)
 		sheetObj.SetColWidth(Col,70);
 	isEdit=false;
 	sheetObj.SetCellEditable(Row, Col,0);
 	if(sheetObj.GetCellValue(Row, Col) !== ""){
 		sheetObjects[1].SetCellValue(Row, Col,sheetObj.GetCellValue(Row, Col)+"@C");//M -> C
 	}
 	//in case of last Cell, Adding row automatically 
 	if(sheetObj.GetSelectCol()%14==0 && sheetObj.GetSelectRow()==sheetObj.RowCount() ){
		sheetObjects[1].DataInsert(-1);
		sheetObjects[1].SelectCell(sheetObjects[1].GetSelectRow(),2);
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(),2);
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
	firstFlag=true;
	var val=sheetObj.GetCellValue(NewRow, NewCol);
	if(typeof val =="undefined"){
		return;
	}
	if(val=="("||val==")"){
		var infoVal=eval("infoArr._"+NewRow+"_"+NewCol);
		if(typeof infoVal =="undefined"){
			return;
		}
		var splitArr=infoVal.split("_");
		if(splitArr!=null){
			if(splitArr.length > 1){
				var oldVal=eval("infoArr._"+OldRow+"_"+OldCol);
				//if(typeof oldVal == "undefined"){
				//	alert(5);
				//	return;
				//}         				
				sheetObj.SetCellFontColor(NewRow, NewCol,"#FF0000");         				
				sheetObj.SetCellFont("FontBold", NewRow,NewCol,1);       				
				sheetObj.SetCellFontColor(splitArr[0]*1, splitArr[1]*1,"#FF0000");         				
				sheetObj.SetCellFont("FontBold", splitArr[0]*1,splitArr[1]*1,1);
			}
		}
	}
	val=sheetObj.GetCellValue(OldRow, OldCol);
	if(typeof val =="undefined"){
		return;
	}
	if(val=="("||val==")"){
		oldVal=eval("infoArr._"+OldRow+"_"+OldCol);
		if(typeof oldVal =="undefined"){
			return;
		}
		if(oldVal == NewRow+"_"+NewCol) return;
		splitArr=oldVal.split("_");
		if(splitArr!=null){
			if(splitArr.length > 1){      				
				sheetObj.SetCellFontColor(OldRow, OldCol,sheetObj.GetCellFontColor(NewRow,1));         				
				sheetObj.SetCellFont("FontBold", OldRow,OldCol,0);        				
				sheetObj.SetCellFontColor(splitArr[0]*1, splitArr[1]*1,sheetObj.GetCellFontColor(NewRow,1));         				
				sheetObj.SetCellFont("FontBold", splitArr[0]*1,splitArr[1]*1,0);
			}
		}
	}
}

function sheet1_OnSearchEnd(sheetObj){
	displayExpression(sheetObj);
	ComOpenWait(false);
}
/**
 * 
 */
function fillNumber(srcName){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];

	if(sheetObject1.GetSelectCol()== 0 || sheetObject1.GetSelectCol== 1 ) return;
	//sheetObject1.ColWidth(sheetObject1.SelectCol) = 70;
	var dsp=srcName.split("_");
	var curVal=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol());
	
	if(dsp[1]=="." && curVal.indexOf(".") > 0)
		return;
	else{
		if(firstFlag){
			//sheetObject1.InitCellProperty(sheetObject1.SelectRow, sheetObject1.SelectCol, sheetObject1.dtData, sheetObject1.daCenter, "", "", 
			//sheetObject1.dfNumber, -1, -1) ;
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),dsp[1]);
			firstFlag=false;
		}else{        		
			//sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol()) += dsp[1];
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),curVal + dsp[1]);
		}
	}
	var txtNumber=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol());
	txtNumber=txtNumber.replace(/,/gi, '');
	sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),txtNumber);
	//sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),ComAddComma(txtNumber));
	sheetObject2.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),txtNumber+"@C");
	sheetObject1.SetColWidth(sheetObject1.GetSelectCol(),0);
	sheetObject2.SetColWidth(sheetObject1.GetSelectCol(),0);
	if(sheetObject1.GetColWidth(sheetObject1.GetSelectCol())<70){
		sheetObject1.SetColWidth(sheetObject1.GetSelectCol(),70);
		sheetObject2.SetColWidth(sheetObject1.GetSelectCol(),70);
	}
	//------------>()         	
	sheetObject1.SetCellFontColor(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),(sheetObject1.GetCellFontColor(sheetObject1.GetSelectRow(),1))); 			
	sheetObject1.SetCellFont("FontBold", sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),0);
	buildParenthesesInfo();
	displayExpression(sheetObject1);
}
/**
 * Filling in Cell and Focusing to Next
 * @param srcName
 * @return
 */
function fillCell(srcName, altValue, opt){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	if(sheetObject1.RowCount()== 0 || sheetObject1.GetSelectCol()== 0 || sheetObject1.GetSelectCol()== -1 ) return;
	//sheetObject1.ColWidth(sheetObject1.SelectCol) = 70; 
	var dsp=srcName.split("\_");
	
	
	//Formula 일때만 체크 한다. 2016.02.25
	if(formObject.radioflag[0].checked){//Formula
	  	if(getObjectUomCd(dsp[1])){
	  		//"Please check the object in formula, it's only allowed to input numeric types of Objects"
	  		ComShowCodeMessage('PSO01013');
	  		return;
	  	}        		
  	}        	
	
	if(opt =="append"){
		var curVal=sheetObject2.GetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol());
		var strTmp=curVal.split("@");
		if(curVal.indexOf(altValue) !== -1 ) return;
		if(strTmp.length >= 2){
			if(strTmp[1] !== "O") return ; //Getting Rate of Object Type
		}
		//sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol()) += " "+dsp[1];
		var sheet1_curVal = sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol());
		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(), sheet1_curVal+" "+dsp[1]);
	}
	else if( opt =="C" ){
		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),altValue);
	}
	else
		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),dsp[1]);
	//alert("sheetObject1.SelectRow:="+sheetObject1.SelectRow+"sheetObject1.SelectCol:="+sheetObject1.SelectCol);
	if(altValue ==null || altValue =="")
		sheetObject2.SetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol(),srcName);
	else{
		if(opt ==null || opt =="" || opt ==undefined){
			//alert("O");
			sheetObject2.SetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol(),altValue+"@O");
		}
		else if (opt =="P"){
			//alert("P");
			sheetObject2.SetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol(),altValue+"@P");
		}
		else if (opt =="F"){//Setting M
			//alert("P");
			sheetObject2.SetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol(),altValue+"@C");//M->C
		}
		else if (opt =="C"){
			//alert("P");
			sheetObject2.SetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol(),altValue+"@C");
		}
		else if (opt =="append"){//Fomula
			var curVal=sheetObject2.GetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol());
			//if(curVal.indexOf(altValue) !== -1 ) return;
			var strTmp=curVal.split("@");
			if(strTmp.length >= 2){
				sheetObject2.SetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol(),altValue+"<"+strTmp[0]+">@"+strTmp[1]);
			}
			else{
				if(curVal =="" ){
					sheetObject2.SetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol(),altValue+"@O");
				}else{
					sheetObject2.SetCellValue(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol(),altValue+"<"+curVal+">");
				}
			}
		}
		else{
			//alert("opt:="+opt);
			;
		}
	}
	//sheetObject1.ColWidth(sheetObject1.SelectCol) = 0;
	//AUTO COL Sizing
	sheetObject1.SetColWidth(sheetObject1.GetSelectCol(),0);
 	if(sheetObject1.GetColWidth(sheetObject1.GetSelectCol())<70)
 		sheetObject1.SetColWidth(sheetObject1.GetSelectCol(),70);
 	//Next Row Select Logic
	var rIdx=sheetObject1.GetSelectCol()%14==0 ? sheetObject1.GetSelectRow()+1 : sheetObject1.GetSelectRow();
	var cIdx=sheetObject1.GetSelectCol()%14==0 ? 2 : sheetObject1.GetSelectCol()+1;

	//in case of last Cell, Adding row automatically
	if(sheetObject1.GetSelectCol()%14==0 && sheetObject1.GetSelectRow()==sheetObject1.RowCount() ){
		sheetObjects[1].DataInsert(-1);
		sheetObjects[1].SelectCell(sheetObjects[1].GetSelectRow(),2);
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(),2);
	}
	//------------>() 			
	sheetObject1.SetCellFontColor(sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),sheetObject1.GetCellFontColor(sheetObject1.GetSelectRow(),1)); 			
	sheetObject1.SetCellFont("FontBold", sheetObject1.GetSelectRow(),sheetObject1.GetSelectCol(),0);
	buildParenthesesInfo();
	sheetObject1.SelectCell(rIdx,cIdx);
	displayExpression(sheetObject1);
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
        //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
    }		
    //Making Button LayOut of subjectList using innerHTML
    //abc();
    createSubjectButtonLayout();
    //createSubjectButtonLayout_temp();
    initControl();
}
 /**
  * registering initial event
  */
 function initControl(){
	 axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	 axon_event.addListenerForm('change', 'obj_change', form);
	 axon_event.addListenerForm('blur', 'obj_blur', form);
	 prvId=document.form.txtid.value;//Setting initial information
 }

function obj_change(){
	var formObject=document.form;
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
            case "txtid":
            	if(prvId==""){
            		prvId=formObject.txtid.value;
            	} else if(prvId!=="" && prvId!==formObject.txtid.value && sheetObjects[0].RowCount()> 0 ){
            		if(ComShowConfirm("Are you sure to save this to other ID ?")){
	            		prvId=formObject.txtid.value;
	            	} else{
    					sheetObject1.RemoveAll();
    					sheetObject2.RemoveAll();
    					prvId=formObject.txtid.value;
    				}
            	} else{
            		if(sheetObjects[0].RowCount()> 0){
            			formObject.txtid.value=prvId;
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
			ComShowMessage(e.message);
		}
	}
}
function obj_blur(){
	return;
	var formObj=document.form;
	var obj=event.srcElement;
	switch(ComGetEvent("name")) {
		case "txtid":
			var curId=obj.value; 
			removeSheet();
    	break;
    }
}
function removeSheet(){
	var formObj=document.form;
	var curId=formObj.txtid.value;
	if(curId != prvId && curId != ""){
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		var dspXpr=document.getElementById("dspXpr");
		dspXpr.innerHTML="";							
	}
	prvId=curId;
}
/**
 * Setting Flag when Form Obj Click
 * @return
 */
function setFlag(mode){
	var formObj=document.form;
	isForm=true;
	var opr=document.getElementById("oprpanel");
	var cons=document.getElementById("consTbl");
	if(formObj.radioflag[0].checked){//Hidden to Formula
		opr.style.display="none";
		cons.style.display="none";
	}
	else{
		opr.style.display="";
		cons.style.display="";
		if(parent!=null && typeof parent.syncHeight != 'undefined')
			parent.syncHeight();
	}
	if(chkMode !== mode){
		chkMode=mode;
		//clear Data. 
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		var dspXpr=document.getElementById("dspXpr");
		dspXpr.innerHTML="";
		
		var curId=formObj.txtid.value;
		if(curId != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);//Retrieving Formula or Condtion Information
			for(var i=0; i<13; i++){//autosizing
				sheetObjects[0].SetColWidth(i,0);
				if(sheetObjects[0].GetColWidth(i)<70){
					sheetObjects[0].SetColWidth(i,70);
	        	}
				sheetObjects[1].SetColWidth(i,sheetObjects[0].GetColWidth(i));
			}
			if(sheetObjects[0].RowCount()> 0) buildParenthesesInfo();
		}
		
	}
	
}
/**
 * Focusing to IBSheet
 * @return
 */
function setFocusIBsheet(){
	var sheetObject1=sheetObjects[0];
	if(!isForm){
		ComSetFocus(document.form.sheet1);
		sheetObject1.SelectCell(sheetObject1.GetSelectRow(), sheetObject1.GetSelectCol());
	}else{
		isForm=false;
	}
}

/**
 * Handling key down event
 * @return
 */
function onKeyDown(){
	ComKeyEnter();
}
function onBlur(){
}
/**
 * 
 * @return
 */
function obj_keypress(){
	obj=event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus=obj.dataformat;
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
 * Handling about activate event
 */
function obj_deactivate(){
}
/**
 * Showing or Hidden adding function button
 */
function showAddFuncs(obj){
	var panel=document.getElementById("additonalFuncs");
	panel.style.display=obj.innerHTML=="▼" ?  "":"none";
	obj.innerHTML=obj.innerHTML =="▼" ?  "▲":"▼";
	if(parent!=null && typeof parent.syncHeight != 'undefined' && obj.innerHTML=="▲"){
		parent.syncHeight();
	}
}
/**
 * Making Button LayOut of subjectList using innerHTML
 * @return
 */
function createSubjectButtonLayout(){
	var formObj = document.form;
	var btnList = document.getElementById("btnList");
	var strInnerHMTL = "<table class=\"search_sm2\" border=\"0\" width=\"979px\">"
    				  + "	<tr class=\"h23\">"
					  + "		<td width=\"60px\" rowspan=\"0\" valign=\"top\"><h3>Subject </h3></td>";

	var prvRow = "1";
	var colCount = 10;//count of column per row
	for(var i=0; i<btnObjects.length; i++){
		if(prvRow !== btnObjects[i].row ){
			if(colCount > 1)//before 10 column, filling with colspan
				strInnerHMTL += "<td colspan=\""+colCount+"\"></td></tr><tr class=\"h23\"><td></td>";
			else
				strInnerHMTL += "</tr><tr class=\"h23\"><td></td>";

			prvRow = btnObjects[i].row;
			colCount = 10;
		}
		else{
			if(colCount == 0){//after 10 column, make a next line
				strInnerHMTL += "</tr><tr class=\"h23\"><td>&nbsp;</td>";
				colCount = 10;
			}
		}
		strInnerHMTL +="<td width=\"108px\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">";
		strInnerHMTL +="<tr>";
		switch(prvRow){//Change Color of TD
			case "1"://black
				strInnerHMTL +="<td>";
				strInnerHMTL += "<button type=\"button\" class=\"btn_etc align_center\" style=\"width:100%\" name=\"btn1_"+btnObjects[i].name+"\" title=\""+btnObjects[i].name+":"+btnObjects[i].uom+"\" alt=\""+btnObjects[i].no+"\"><font color=\"black\">";
				break;
			case "2"://red
				strInnerHMTL +="<td>";
				strInnerHMTL += "<button type=\"button\" class=\"btn_etc align_center\" style=\"width:100%\" name=\"btn1_"+btnObjects[i].name+"\" title=\""+btnObjects[i].name+":"+btnObjects[i].uom+"\" alt=\""+btnObjects[i].no+"\"><font color=\"red\">";
				break;
			case "3"://blue
				strInnerHMTL +="<td>";
				strInnerHMTL += "<button type=\"button\" class=\"btn_etc align_center\" style=\"width:100%\" name=\"btn1_"+btnObjects[i].name+"\" title=\""+btnObjects[i].name+":"+btnObjects[i].uom+"\" alt=\""+btnObjects[i].no+"\"><font color=\"blue\">";
				break;
			default:
				strInnerHMTL +="<td><button><font>";
			 	break;
		}
		strInnerHMTL += btnObjects[i].dspname+"</font></button></td>"
					 +"</tr>"
					 +"</table></td>";
		colCount--;
	}
	 
	//Adding +Rate Button, Delete Button
	strInnerHMTL += "</tr><tr class=\"h23\">"
		+"	<td	width=\"84%\" colspan=\"9\"></td>"
		+"	<td width=\"8%\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">"
		+"		<tr>                                                 "
		+"         <td style=\"color:#3399ff;\"><button type=\"button\" class=\"btn_etc align_center\" style=\"width:100%\" name=\"btn2_Rate\" id=\"btn2_Rate\">+Rate</button></td>"
		+"		</tr>                                                                           "
		+"		</table></td>                                                                   "
		+"	        <td width=\"8%\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">"
		+"		<tr>                                                 "
		+"          <td style=\"color:#3399ff;\"><button type=\"button\" class=\"btn_etc align_center\" style=\"width:100%\" name=\"btn1_1_Delete\" id=\"btn1_1_Delete\">Delete</button></td>"
		+"		</tr>                                                                           "
		+"		</table></td>                                                                   ";
	 strInnerHMTL += "</tr>"
		 		  + "</table>";
	 var txtDebug = document.getElementById("txtDebug");
	 txtDebug.value = strInnerHMTL;
	 btnList.innerHTML = strInnerHMTL;
	 
	if(parent!=null && typeof parent.syncHeight != "undefined"){
		parent.syncHeight();//Calling SyncHeight function of Parent Frame
	}
	
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetObj.id) {                
		case "sheet1":      //sheet1 init
		    with(sheetObj){		    		        
    		      var HeadTitle1="||A|B|C|D|E|F|G|H|I|J|K|L|M";
    		      var headCount=ComCountHeadTitle(HeadTitle1);
    		      var prefix="sheet1_";

    		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

    		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
    		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    		      InitHeaders(headers, info);

    		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col4",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col5",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col6",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col7",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col8",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col9",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col10",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col11",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col12",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
    		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"col13",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 } ];
    		       
    		      InitColumns(cols);		
    		      SetCountPosition(0);
    		      SetColProperty(0, prefix+"col1" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col2" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col3" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col4" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col5" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col6" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col7" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col8" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col9" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col10" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col11" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col12" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      SetColProperty(0, prefix+"col13" , {AcceptKeys:"E|[0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>]"});
    		      
    		      SetSelectionMode(smSelectionFree);
    		      SetSheetHeight(162);
	      	}
            break;
		case "sheet2":      //sheet2 Hidden
		    with(sheetObj){		    		        
    		      var HeadTitle1="||COL1|COL2|COL3|COL4|COL5|COL6|COL7|COL8|COL9|COL10|COL11|COL12|COL13";
    		      var headCount=ComCountHeadTitle(HeadTitle1);
    		      var prefix="sheet2_";

    		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
    		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    		      InitHeaders(headers, info);

    		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1  ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col4",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col5",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col6",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col7",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col8",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col9",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col10",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col11",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"col12",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50},
    		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"col13",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:50} ];
    		       
    		      InitColumns(cols);		
    		      SetEditable(1);
    		      SetCountPosition(0);
    		      SetSheetHeight(102);
			}
			break;
		case "sheet3":      //hidden sheet
		    with(sheetObj){		    		        
    		      SetConfig( { SearchMode:2, DataRowMerge:0 } );

    		      var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
    		      var headers = [ ];
    		      InitHeaders(headers, info);		
    		      var cols = [  ];		    		       
    		      //InitColumns(cols);
    		      //SetSheetHeight(0);
    		}
			break;
    }
}
/**
 * Checking count of ()
 * @return
 */
function validateParentheses(){
	var sheet1=sheetObjects[0];
	var sheet2=sheetObjects[1];
	var rowCount=sheet1.RowCount();
	var txt="";
	var len=0;
    var pCnt=0;
	for(var row=1 ; row<=rowCount; row++ ){
		for(var col=2; col<15; col++){
			if(sheet2.GetCellValue(row, col).indexOf("@O")==-1){
				txt=sheet1.GetCellValue(row, col);
    			if(txt!=""){
    				len=txt.length;
    				for(var i=0; i<len;i++){
    					if(txt.indexOf("(",i)!=-1){
    						i=txt.indexOf("(",i);
    						pCnt++;
    					}
    				}
    				for(var i=0; i<len;i++){
    					if(txt.indexOf(")",i)!=-1){
    						i=txt.indexOf(")",i);
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
	var dspXpr=document.getElementById("dspXpr");
	var strXpr="";
	if(sheetObj.RowCount()> 0){
		for(var row=1;row<=sheetObj.RowCount();row++){
			if(sheetObj.GetRowStatus(row) == "D") continue;
			for(var col=2;col<15;col++){
				if(sheetObj.GetCellValue(row, col)!=""){
					strXpr += sheetObj.GetCellValue(row, col) + " ";	
				} else{
					continue;
				}
			}
		}
		dspXpr.innerHTML=strXpr;
		if(parent!=null && typeof parent.syncHeight != 'undefined')
		  parent.syncHeight();//Calling SyncHeight function of Parent Frame
	} else{
		dspXpr.innerHTML="";
	}
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var saveObjs=new Array(2);
	saveObjs[0]=sheetObject1;
	saveObjs[1]=sheetObject2;
	sheetObject1.SetWaitImageVisible(0);
	sheetObject2.SetWaitImageVisible(0);
	sheetObject3.SetWaitImageVisible(0);
	switch(sAction) {
    	case SEARCH01:
    			ComOpenWait(true);
    			formObj.f_cmd.value=SEARCH01;           			
    			var sXml=sheetObj.GetSearchData("VOP_PSO_0007GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
    			var data=ComGetEtcData(sXml,"BTNLIST");
    			eval(data);
    			createSubjectButtonLayout();
    			ComOpenWait(false);
    		break;
		case IBSEARCH:      //Retrieving Retrive BtnClick 
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var aryPrefix=new Array("sheet1_", "sheet2_");     					
				var sXml=sheetObj.GetSearchData("VOP_PSO_0007GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var sXmls=sXml.split('|$$|');
				for(var i=0; i<sXmls.length;i++){
					sheetObjects[i].LoadSearchData(sXmls[i],{Sync:1} );
				}
			}
        break;
		case IBDELETE:        //Deleting
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=REMOVE;
				var sXml=null;
				var dspXpr=document.getElementById("dspXpr");
				if(formObj.radioflag[0].checked ==true){
					if(ComShowCodeConfirm("PSO09012", "Formula", formObj.txtid.value)){     							
						sXml=sheetObj.GetSearchData("VOP_PSO_0007GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
    					sheetObj.LoadSearchData(sXml,{Sync:1} );
    					sheetObject1.RemoveAll();
    					sheetObject2.RemoveAll();
    					dspXpr.innerHTML="";
					}
				} else{
					if(ComShowCodeConfirm("PSO09012", "Condition", formObj.txtid.value)){     							
						sXml=sheetObj.GetSearchData("VOP_PSO_0007GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
    					sheetObj.LoadSearchData(sXml,{Sync:1} );
    					sheetObject1.RemoveAll();
    					sheetObject2.RemoveAll();
    					dspXpr.innerHTML="";
					}
				}
				ComOpenWait(false);
    		}
			break;
		case IBSAVE:        //Save
			if(!validateForm(sheetObj,formObj,sAction)) return;
		    var pCnt=validateParentheses(); 
		    if(pCnt!=0)
		    {
				ComShowMessage("Parentheses must be correct. Parenthesis count="+pCnt);
				return ;
			}
		    ComOpenWait(true);
		  	formObj.f_cmd.value=MULTI;
//				  	for(var i=0; i<saveObjs.length;i++){
//				  		for(var j=saveObjs[i].HeaderRows ; j<=saveObjs[i].RowCount;j++)
//				  			saveObjs[i].CellValue2(j,0) = "I";
//				  	}
			var SaveStr=ComGetSaveString(saveObjs);
			if(SaveStr.length <= 0 ){
				ComOpenWait(false);
				ComShowCodeMessage("PSO00036", formObj.radioflag[0].checked == true ? "formula data" : "condition data");
				return;
			}
			var aryPrefix=new Array("sheet1_", "sheet2_");	//prefix String Array 					
			var sXml=sheetObject1.GetSaveData("VOP_PSO_0007GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			ComOpenWait(false);
			var new_id=ComGetEtcData(sXml, "NEW_ID");
			if(new_id != undefined && new_id != ""){	//in case of new creating, Setting new_id
				prvId=new_id;
				formObj.txtid.value=new_id; 
			} 					
			sheetObjects[0].LoadSaveData(sXml);//Loading to Hidden Object
			break;
		default : 
			break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
	    var id=txtid.value; 
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
	var dsctbl=document.getElementById("sysDscTbl");
	dsctbl.style.display=dsctbl.style.display =="" ? "none":"";
	var dbgWin=document.getElementById("txtDebug");
	dbgWin.style.display=dbgWin.style.display =="" ? "none":"";
}

function getObjectUomCd(objName){
 	var formObj = document.form;
 	var btnList = document.getElementById("btnList");
 	
 	var rtnUomCd = "";
 	
 	for(var i=0; i<btnObjects.length; i++){
 		var tmpUomCd = btnObjects[i].uomcd;
 		var tmpObjName = btnObjects[i].name;
 		
 		if(objName == tmpObjName) {
 			rtnUomCd = tmpUomCd;
 			break;
 		} 
 	}
 	
 	for(var j=0; j < gCheckArrayMeasUnitCd.length; j++){
 		if(gCheckArrayMeasUnitCd[j] == rtnUomCd) return true;
 	}
 	
 	
 	return false;
}
