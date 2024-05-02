/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_mst_0002.js
*@FileTitle : Container Type/Size Update/Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ees_mst_0002 : business script for ees_mst_0002
     */
 // common static variable  
var sheetObjects=new Array();
var sheetCnt=0;
var strOfcCd="";
var disp_seq='';	// using on checking rpt_dp_seq duplication
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
     function processButtonClick(){
 		  var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
	            case "btn_retrieve":
	            	if ( f_change_data_checking()  == true)  return;
	            	
	            		doActionIBSheet(sheetObject1,formObject,IBSEARCH);	            
	            	break;
	            case "btn_new":
	            	if ( f_change_data_checking()  == true)  return;
	    			sheetObject1.RemoveAll();
	    			break;
				case "btn_save":					
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;	
				case "btn_downexcel":
				 if(sheetObject1.RowCount() < 1){//no data
					  ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					}
					
					break; 
             } // end switch
     	}catch(e) {
       		if( e == "[object Error]") {
       			ComShowCodeMessage("MST00011",srcName+" Button Fail.");
       		} else {
       			ComShowCodeMessage("MST00011",e);
       		}
     	}
     }
     /**
      * registering IBsheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
        	 ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
                     with(sheetObj){
						
								
							  //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
							  var HeadTitle="|Seq.|TP/SZ|Description|ISO Code|ISO Description|TEU|Cost Group|Disp_Seq|Status";
							  var prefix="sheet1_";

							  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

							  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
							  var headers = [ { Text:HeadTitle, Align:"Center"} ];
							  InitHeaders(headers, info);

							  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
									 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
									 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
									 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
									 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_iso_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
									 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"iso_cntr_tpsz_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
									 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sz_teu_capa",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
									 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_grp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
									 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rpt_dp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
									 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"aciac_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
							   
							  InitColumns(cols);

							  SetEditable(1);
							 // SetSheetHeight(480);
							  SetColProperty(0,"rpt_dp_seq", {ComboText:"1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35", ComboCode:"1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35"} );
							  SetColProperty(0,"aciac_div_cd", {ComboText:"Active|Inactive", ComboCode:"A|I"} );
							  resizeSheet();
					}


                 break;
         }
     }
   // handling process forsheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
		 var selrow=sheetObj.GetSelectRow();
         switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj, formObj, sAction)){
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);					
					formObj.f_cmd.value=SEARCH;					
	 				var xml="";
					xml=sheetObj.GetSearchData("EES_MST_0002GS.do", FormQueryString(formObj));
	 				var dpSeq=ComXmlString(xml,"rpt_dp_seq");
//	 				sheetObj.InitDataCombo(0,"rpt_dp_seq", dpSeq, dpSeq);
	 				sheetObj.LoadSearchData(xml,{Sync:1} );
	 				ComOpenWait(false);
				}					
				break;
			case IBSAVE:        //save			
				if(sheetObj.id == "sheet1") 
				{						
	        		// duplicate rpt_dp_seq exists, showing message
	        		var dupRows = sheetObj.ColValueDupRows("rpt_dp_seq");
	        		var arrRow=dupRows.split(",");
			        if (dupRows != ""){
		       		   //error message : Data is duplicated, Please check data again.
			        	ComShowCodeMessage("MST00002", sheetObj.GetCellValue(arrRow[0],"rpt_dp_seq"));
			           sheetObj.SelectCell(arrRow[0], "rpt_dp_seq", true);
		       		   return;				        	
			        } 			         
			        var sel_code=sheetObj.GetCellValue(selrow,"cntr_tpsz_cd");
					var cur_code="";
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);						
					formObj.f_cmd.value=MULTI;					
					sheetObj.DoSave("EES_MST_0002GS.do", FormQueryString(formObj));
	 				ComOpenWait(false);				
				}			
				break; 	
			case IBSEARCH_ASYNC01:      //retrieving Officd Code 
				if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "MST", strOfcCd) ) {
					form.btn_save.style.display="none";
				}else{
					form.btn_save.style.display="";
				}
			break		    
         }
     }
     /**
      * handling process for input validation 
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
      /**
	  * 변경 가능한 컬럼에 대한 전,후 데이터 변경 여부를 리턴한다.
	  * return Value
	  * true : 변경 됨
	  * false : 유지 됨
	  */
	 function f_change_data_checking() {
		var modifyDataFlag=false;
		for (var i=1 ; i <= sheetObjects[0].RowCount(); i++){
			if ( sheetObjects[0].GetCellValue(i , "ibflag") != "R") {
				modifyDataFlag=true;
				break;
			}
		}
		if ( modifyDataFlag ) {
			return  ComShowCodeConfirm("COM130504")  ;
		 } else {
			 return false;
		 }
	 }

		function resizeSheet(){
	 	    ComResizeSheet(sheetObjects[0]);
	 	}