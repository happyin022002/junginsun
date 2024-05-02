/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2005_01.js
*@FileTitle  : Hard Coding Contents
*@author     : CLT
*@version    : 1.0
*@since      : 2015/06/24
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends
 * @class ESM_BKG_2005_01 : ESM_BKG_2005_01 - task script definition for screen
 */
 
    // public variable
	var sheetObjects=new Array(); 
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
     function processButtonClick(){
          /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
 		  var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					case "btn_Copy":
						doActionIBSheet(sheetObjects[0], formObject, IBCOPYROW);
						break;
					case "btn_RowAdd":
						addRow();
						break;
					case "btn_RowDel":
						deleteRow();
						break;
	 				case "btn_Close":
	 					ComClosePopup(); 
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
    	  sheetObjects[sheetCnt++]=sheet_obj;
     }
     function setComboObject(combo_obj) {  
    		comboObjects[comboCnt++]=combo_obj;  
    	}
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         // Event needed for screen
    	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
    	axon_event.addListenerForm('click', 'obj_click', document.form); // click
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }
   /**
      * setting sheet initial values and header
      * 
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
                 with(sheetObj){
                
            	 var HeadTitle1="|||Seq.";
            	 var attr_nm=new Array();
            	 attr_nm[0]=document.form.attr_nm1.value;
            	 attr_nm[1]=document.form.attr_nm2.value;
            	 attr_nm[2]=document.form.attr_nm3.value;
            	 attr_nm[3]=document.form.attr_nm4.value;
            	 attr_nm[4]=document.form.attr_nm5.value;
            	 attr_nm[5]=document.form.attr_nm6.value;
            	 attr_nm[6]=document.form.attr_nm7.value;
            	 attr_nm[7]=document.form.attr_nm8.value;
            	 attr_nm[8]=document.form.attr_nm9.value;
            	 attr_nm[9]=document.form.attr_nm10.value;
              	for(var i=0;i<10;i++){
              		if(attr_nm[i] == ''){
              			HeadTitle1 += "|Attribute" +(i+1);
              		}
              		else
              			HeadTitle1 += "|" + attr_nm[i];
              	}
              	var headCount=ComCountHeadTitle(HeadTitle1);
              	(headCount, 0, 0, true);

              	SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );

              	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              	InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                  {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hrd_cdg_id" },
                  {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hrd_cdg_id_seq" },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt6",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt7",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt8",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt9",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt10",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
               
              InitColumns(cols);
              SetSheetHeight(440);
              SetEditable(1);
                       }


     			break;
         }
     }
   // handling sheet process
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg(false);
	     switch(sAction) {
	     	case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH; 
				var sParam=FormQueryString(formObj);
 				sheetObj.DoSearch("ESM_BKG_2005_01GS.do",sParam );
				ComOpenWait(false);
				break;
	     	case IBSAVE: // Save
				if(!validateForm(sheetObj,formObj,sAction))	return;
				formObj.f_cmd.value=MULTI;
				var sheet2=sheetObjects[1];
				var sParam=sheetObj.GetSaveString(false, true, "ibflag");
				sParam += "&" + FormQueryString(formObj);
 				var sXml=sheetObjects[0].GetSaveData("ESM_BKG_2005_01GS.do",sParam);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					ComOpenWait(false, false);
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('BKG00166');
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case IBCOPYROW: // Row Copy                                                                                                                                                                                                                                                                                                                                                                                                                                   
				if(sheetObj.CheckedRows("check") > 1) {
					copyMultyRow(sheetObj);                                                                                                                                                                                                                                                                                                                                                                                                         
				} 
				else{
					var oldIdx=sheetObj.GetSelectRow();
					var newIdx=sheetObj.DataCopy();
					if(newIdx > 0) {                 
						sheetObj.SetCellValue(oldIdx, "check",0,0);
					}                                                                                                                                                                                                                                                                                                                                                                                                                               
				}                                                                                                                                                                                                                                                                                                                                                                                                                                       
				break;   
	     }
	 }
     /**
      * handling process for input validation
      */
      function validateForm(sheetObj,formObj,sAction){
    	  if(sAction==IBSAVE){
  	     	if (! sheetObj.IsDataModified()){
  	     		ComShowCodeMessage('BKG95053');
				return false; //There is no data to Save.\n\n Please check again.
		      	}
    	  }
          return true;
      }
     /**
      * process when you enter retrieve condition
      */
     function obj_KeyUp() {
     	var formObject=document.form;
     	var srcName=ComGetEvent("name");
     	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
     	var srcValue=window.event.srcElement.getAttribute("value");
     }
  	/**
  	 * add row process in sheet1
  	 * add one row
  	 */
	 	function addRow() {
	 	  with (sheetObjects[0]) {
	         var nowRow=GetSelectRow();
	       	 nowRow=DataInsert(-1);
	       	sheetObjects[0].SetCellValue(nowRow,"hrd_cdg_id",document.form.hrd_cdg_id.value);
	         return true;
	          }
	 }
	/**
	 * delete row process in sheet1
	 * delete one row
	 */ 
	 function deleteRow() {
	     with (sheetObjects[0]) {
	         var sRowStr=FindCheckedRow("check");
	         var arr=sRowStr.split("|");
	         for (var i=0; i<=arr.length - 1; i++) {
	        	 SetRowStatus(arr[i],"D");
	             SetRowHidden(arr[i],"1");
	         }
	     }         
	 }
	/**
	 * copyMultyRow process
	 * copy multi row
	 */  	 
	function copyMultyRow(sheetObj) {                                                                                                                                                                                                                                                                                                                                                                                                                               
		var checkArr=ComRtrim(sheetObj.FindCheckedRow("check"), '|').split("|");
		if(checkArr != null && checkArr.length > 0) {                                                                                                                                                                                                                                                                                                                                                                                                           
			for(var i=checkArr.length-1; i>=0; i--) {                                                                                                                                                                                                                                                                                                                                                                                                       
				sheetObj.SetSelectRow(checkArr[i]);
				sheetObj.DataCopy();
				sheetObj.SetCellValue(checkArr[i], "check",0,0);
			}                                                                                                                                                                                                                                                                                                                                                                                                                                               
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	}        
