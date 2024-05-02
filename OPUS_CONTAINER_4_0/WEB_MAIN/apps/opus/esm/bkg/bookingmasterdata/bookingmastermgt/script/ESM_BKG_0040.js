/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0040.js
*@FileTitle : BookingMaster
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
     * @author 
     */
    /**
     * @extends 
     * @class esm_bkg_0040 : esm_bkg_0040 business script for
     */
    
	 // Common global variable
	 var tabObjects=new Array();
	 var tabCnt=0 ;
	 var beforetab=1;
	 var sheetObjects=new Array();
	 var sheetCnt=0;
     var prefix="sheet1_";

	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 
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
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         //khlee- Preferences change the name of the function to start
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //khlee- The final configuration functions added
             ComEndConfigSheet(sheetObjects[i]);
         }
 		 initControl();
     }
     
     /**
      * handling  search condition  Input 
      */
     function obj_KeyUp() {
	     var formObject=document.form;
	     var srcName=ComGetEvent("name");
	     var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	     var srcValue=window.event.srcElement.getAttribute("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
     
     /**
       * HTML Control on the page  loaded dynamically  the event. <br>
       * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects array  sequence number
       */
      function initControl() {
    	  var formObject=document.form;
      	//Axon Event Processing 1. Events catch (developers change)
//	      axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- out focus
//	      axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- in  focus 
//	      axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- When typing the keyboard
	      axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//	      axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
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
//            	       var HeadTitle1="flag|Sel|Seq.|SCAC|Name|Auto|Update|Remark|user_id";
            	       var HeadTitle1="flag|Sel|Seq.|SCAC|Name|Auto|Update|Remark|user_id|port_cd";
//            	       var prefix="sheet1_";

            	       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	       var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	       InitHeaders(headers, info);

            	       var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
            	              {Type:"DelCheck",  Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
            	              {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"scac_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
            	              {Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:1,   SaveName:prefix+"scac_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"usa_cstms_file_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, 
            	              {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"user_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
            	              ];
            	        
            	       InitColumns(cols);
            	       
            	       SetColProperty(prefix+"usa_cstms_file_cd", {ComboText:"Y|N", ComboCode:"Y|N"} );
            	       SetColProperty(prefix+"scac_cd", {AcceptKeys : "E|N", InputCaseSensitive:"1"} );
            	       SetColProperty(prefix+"scac_nm", {AcceptKeys : "E|N|[~!@#$%^&*()-_=+\|[{]};:'\",<.>/? ]", InputCaseSensitive:"1"} );
            	       SetEditable(1);
            	       SetSheetHeight(400);
            	       }
            	    


                 break;
         }
     }
     
     
     
   // Event handler processing by button name */
      function processButtonClick(){
           /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
  		         var sheetObject1=sheetObjects[0];
           /*******************************************************/
           var formObject=document.form;
      	try {
      		var srcName=ComGetEvent("name");
              switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				case "btn_new":
					sheetObject1.RemoveAll();
					formObject.reset();
				break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;				
				case "btn_add":
					sheetObject1.DataInsert(-1);
					//addRowEdit(sheetObjects[0],document.form);
				break;
				case "btn_del":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;	
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.SetHeaderBackColor("#CCCCCC");
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
						sheetObject1.SetHeaderBackColor("#333333");
						
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
      
      
      // Sheet handling process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;   
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0040GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
         		ComOpenWait(false);
			break;
			case IBSAVE:        //Save
 				if(!validateForm(sheetObj,formObj,sAction)) {
		            return;
		        }//end if
		        formObj.f_cmd.value=MULTI;		        
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
		        
		        var sParam=FormQueryString(formObj);				
		        sParam=sParam + "&" + sheetObj.GetSaveString();
		        var sXml=sheetObj.GetSaveData("ESM_BKG_0040GS.do", sParam);
		        
		        sheetObj.LoadSaveData(sXml);
		        ComOpenWait(false);
		        if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
		        	doActionIBSheet(sheetObj, formObj, IBSEARCH);
		        }
			break;
			case IBDELETE:  	
				ComRowHideDelete(sheetObj, "sheet1_del_chk");	
			break;
         }
     }
     
     
     
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 var saveStr = sheetObj.GetSaveString();
    	 if (saveStr == "") return false;

    	for (var i=1 ; i < sheetObj.RowCount()+1 ; i++){
    		if (sheetObj.GetCellValue(i,2) == ''){
	    		ComShowCodeMessage("BKG00307");//Please, select & save specific commodity code.
	    		sheetObj.SelectCell(i, 1, true, ' ');
	    		return false;
	    	}
    	}
    	
    	if (! sheetObj.IsDataModified()){
    		ComShowCodeMessage("BKG00249");//No Selected Row
    	    return false;
    	}
        return true;
    }
     
     
     /**
      * addrow Data Type
     */    
     function addRowEdit(sheetObj,formObj){
    	 var Row=sheetObj.GetSelectRow();
    	 sheetObj.SetCellValue(Row,1,"1",0);
    	 sheetObj.SetCellEditable(Row, 5,0);
     }
     
     
  	/**
      * Insert value check
     */ 
     function chkInsertVal(sheetObj,formObj,Row){
    	  var Row=sheetObj.GetSelectRow();
    	  var Col=sheetObj.GetSelectCol();
    	  if (sheetObj.GetCellValue(Row,2) == ''){
    		  ComShowCodeMessage("BKG00249");//No Selected Row
    		  sheetObj.SelectCell(Row, 1, true, ' ');
    		  return true;
    	  }
    	  return false;
     }
     
     
      /**
       * Event
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    		with (sheetObj) {
    			var color1="#CCFFFD";
    			SetColBackColor(3,color1);
				document.form.tot_count.value=sheetObj.RowCount();
    		}
     }
     
 	function sheet1_OnChange(sheetObj, Row, Col, Value){
 		if(sheetObj.GetCellValue(Row, prefix+"port_cd")==""){
 	 		sheetObj.SetCellValue(Row, prefix+"port_cd", ComGetObjValue(document.form.port_cd));
 	 		sheetObj.SetCellValue(Row, prefix+"user_id", ComGetObjValue(document.form.user_id));
 		}
 	}
     
