/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1114.js
*@FileTitle  : booking master data
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* developer job	*/
	// common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var maxCtrl=0;
 var comboObjects=new Array();
 var comboCnt=0;
	// Event handler processing by button click event
 document.onclick=processButtonClick;
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     function setComboObject(combo_obj){
     	comboObjects[comboCnt++]=combo_obj;
     }
 	/**
 	 * initializing sheet
 	 * implementing onLoad event handler in body tag
 	 * adding first-served functions after loading screen.
 	 */
     function loadPage() {
    	  ComBtnSetInquiry();
         for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
         }     
  		  doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
          ComSetFocus(document.form.cnt_cd);	
		  initControl();
		  // Retrieve a value, the ZIP Code Country or perform an event
		  ComSetObjValue(document.form.cnt_cd, document.form.sheet1_cnt_cd.value);
    	  if(document.form.sheet1_cnt_cd.value != "" || document.form.zip_cd.value != ""){
    		  comboObjects[0].SetSelectCode(document.form.cnt_cd.value);
    	   	  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	  }
    	  
    	  form.zip_cd.focus();
     }
   	 /**
      * Dynamically load HTML Control event in page. <br>
      * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
      **/
      function initControl() {
      	var formObject=document.form;
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          //axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
         // axon_event.addListener ('keydown', 'ComKeyEnter', 'form'); 
      }
      	// initializeIBCombo  
        function initCombo(comboObj) {
        	comboObj.SetDropHeight(150);
        	
        }  
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
    /* function obj_keypress(){
		 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(event.srcElement.dataformat){
	         case "etc": //ENG=Upper Case
             if(keyValue >= 97 && keyValue <= 122) {//lower case
                 event.keyCode=keyValue + 65 - 97;
             }
         	  break;    
	        default:
	            // number only
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}*/
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 				var sheetID=sheetObj.id;
 				switch(sheetID) {
 	 					case "sheet1":
 	 					    with(sheetObj){
 	 				
 	 				      var HeadTitle1="|Sel|Del.|Seq.|Zip Code|Country|State|City|Street P.O Box (Address)|By|Update Date";
 	 				      var headCount=ComCountHeadTitle(HeadTitle1);
 	 				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
 	 				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 	 				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
 	 				      InitHeaders(headers, info);

 	 				      var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
 	 				      {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Del",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 	 				      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
 	 				      
 	 				      {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
 	 				      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"zip_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
 	 				      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:2 },
 	 				      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"ste_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
 	 				      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"cty_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
 	 				      {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"zip_dtl_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
 	 				      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"evnt_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
 	 				      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
 	 				      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 }];
 	 				 
 	 				      
 	 				    
 	 				      InitColumns(cols);
 	 				      SetSheetHeight(300);
 	 				      SetEditable(1);
 	 				      SetColProperty(0 ,"cnt_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
 	 				      SetColProperty(0 ,"ste_nm" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
 	 				            }
 					    break;
 				}
 	}
	// Event handler processing by button name
      function processButtonClick(){
  		         var sheetObject1=sheetObjects[0];
           var formObject=document.form;
      	try {
      		var srcName=ComGetEvent("name");
  					switch(srcName) {
  						case "btn_Retrieve":
  							 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  						break;
  						case "btn_Save":
  							 doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
  						break;
  						case "btn_Delete":
  							 doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
  						break;
  						case "btn_Add":
  							var row=sheetObject1.DataInsert(-1);
  							sheetObject1.SetCellValue(row, "cnt_cd",comboObjects[0].GetSelectCode());
  						break;
  						case "btn_down_excel":
  							
  							if(sheetObject1.RowCount() < 1){//no data
  							  ComShowCodeMessage("COM132501");
  							}else{
  								sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
  							}
  						break;
  						case "btn_Load_Excel":
  							sheetObject1.LoadExcel();
  							//sheetObject1.LoadExcel(1, 1, "", "-1", "-1", "", false, false, "1=>zip_cd");
  						break;
  						case "btn_New":
   							 ComResetAll();
  		                	 doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
  			   				// ComBtnEnable("btn_Add");
  		    				// ComBtnEnable("btn_Delete");
  		    				// ComBtnEnable("btn_Save"); 
    					break;
						case "btn_Select":
							zipCodePopupOK();
  						break;
  						case "btn_close":
  		                    if(sheetObject1.IsDataModified()){
  		                        if(ComShowCodeConfirm("BKG00168")){
  		                        	ComClosePopup(); 
  		                        }
  		                    }else{
  		                    	ComClosePopup(); 
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
	// handling of Sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBCLEAR:      //Combo retrieve
				formObj.f_cmd.value=SEARCH01;
			    //ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("ESM_BKG_1114GS.do", FormQueryString(formObj));
				ComBkgXml2ComboItem2(sXml, cnt_cd, "cnt_cd", "cnt_nm" );
			break;
			case IBSEARCH:      //retrieve
			 if(validateForm(sheetObj,formObj,sAction)){   
			     formObj.f_cmd.value=SEARCH;   
			     sheetObj.SetWaitImageVisible(0);
			     ComOpenWait(true);
			     sheetObj.DoSearch("ESM_BKG_1114GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("") );
			 }						
		    break;
			case IBSAVE:        //save
		      	   	if(!validateForm(sheetObj,formObj,sAction)) return;
		    	   	if(sheetObj.RowCount()== 0) return;
					formObj.f_cmd.value=MULTI;					
					var sParam=ComGetSaveString(sheetObjects);
					if(sheetObj.IsDataModified()== false || sParam == ""){
						ComShowCodeMessage('BKG00260');
						return;
					}
					if(!dupSaupjaCheck(sheetObj)){
	                    return false;
	                }
		            sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("");
		            var SaveXml=sheetObj.GetSaveData("ESM_BKG_1114GS.do", sParam );
		            sheetObj.LoadSaveData(SaveXml);
					if (SaveXml.indexOf(">OK<") > -1){
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
					break;		
			case IBDELETE:      // delete	 					
			      ComRowHideDelete(sheetObj, "Del");
			break;
         }
        ComOpenWait(false);
     }
     /**
     * handling process for input validation
     */
     function validateForm(sheetObj,formObj,sAction){
    	     with(formObj){
         	 if (!ComChkValid(formObj)) return false;
         	 if (comboObjects[0].GetSelectCode()== "" ){
         		 if (sAction == IBSEARCH){
         			 ComShowCodeMessage('BKG00545', 'Country');
         			 cnt_cd.focus();
          		 }
         		 return false;
         	 }
          }
          return true;
      }
      /**
       * IBSheet zip code entered in the grid, check for duplicate
       */
      function dupSaupjaCheck(sheetObj) {
          var dRow=sheetObj.ColValueDup("zip_cd", false);
          if (dRow != -1) {
        	  ComShowCodeMessage('COM12115', 'Zip Cpde: ['+sheetObj.GetCellValue(dRow, "zip_cd")+']');
              sheetObj.SelectCell(dRow, sheetObj.SaveNameCol("zip_cd"));
              return false;
          } else {
              return true;
          }
      }
  	function sheet1_OnMouseMove(Button, Shift, X, Y) {
		//window.status = "OnMouseMove Row=" + Row + ", Col=" + Col + ", Text=" + sText;
		Row=sheetObjects[0].MouseRow();
		Col=sheetObjects[0].MouseCol();
        var colSaveName=sheetObjects[0].ColSaveName(Col);
		if(colSaveName == "evnt_usr_id") {
			sText=sheetObjects[0].GetCellText(Row,"usr_nm");
        } else {
		sText="";
		}
//no support[check again]CLT 		
		sheetObjects[0].MouseToolTipText=sText;
	}
  	function zipCodePopupOK() {
  		var selectedRowForSave=sheetObjects[0].GetSelectRow();
  		var selectedDel=sheetObjects[0].GetCellValue(selectedRowForSave, "Del");
	  	  if(sheetObjects[0].GetTotalRows()== 0 || selectedDel == 0){
	  				ComShowCodeMessage("COM12189");
	  				return;
		  }
  		var retObj=getZipCodeInfoRows(selectedRowForSave);
  		if(callbackMethod == null){
  			ComClosePopup(); 
  		}else{
  			ComClosePopup(); 
  			callbackMethod(retObj);
  		}
  	}
	function getZipCodeInfoRows(idx) {
		if(sheetObjects[0].GetTotalRows()== 0)
			return null;
		var cArray=new Array(); 
		cArray[0]=sheetObjects[0].GetCellValue(idx, "cty_nm");
		cArray[1]=sheetObjects[0].GetCellValue(idx, "ste_nm");
		cArray[2]=sheetObjects[0].GetCellValue(idx, "cnt_cd");
		cArray[3]=sheetObjects[0].GetCellValue(idx, "zip_cd");
		cArray[4]=sheetObjects[0].GetCellValue(idx, "zip_dtl_addr");
    	return cArray;
	}
	/* End developers work */
