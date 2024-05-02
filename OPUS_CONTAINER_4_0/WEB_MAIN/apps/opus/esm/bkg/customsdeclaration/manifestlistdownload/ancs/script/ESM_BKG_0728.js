/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0728.js
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * business script for esm_bkg_0567
	 */
	 // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
        	/***** using extra sheet valuable if there are more 2 sheets *****/
    		         var sheetObject1=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
	                case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
	            	case "btn_save":
	            		doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	            	break;				
	            	case "btn_downexcel":
	            		if(sheetObject1.RowCount() < 1){//no data
	            			ComShowCodeMessage("COM132501");
	            			}else{
//	            				sheetObject1.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
	            				sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1,DownSum:1,KeyFieldMark:0});
	            			}

	            		//sheetObject1.SpeedDown2Excel(-1);
 	            		
	            	break;
	            	case "btn_add":
						sheetObject1.DataInsert(-1);
					break;
					case "btn_del":
						doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;	
					case "btn_close":
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
         * @param sheet_obj IBSheet Object
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
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            initControl();
        }
        /**
        * init control
        */
        function initControl() {
        	var formObject=document.form;
            axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- blur focus
            axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- on focus
            axon_event.addListenerFormat('keypress',         'obj_keypress',    formObject); //- key press
            axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        }
        /**
    	 * obj key press event handling
    	 */
	     function obj_keypress(){
			switch(event.srcElement.dataformat){
		    	case "int":
			        //only Number
			        ComKeyOnlyNumber(event.srcElement);
			        break;
		        case "float":
		            //only Number + "."
		            ComKeyOnlyNumber(event.srcElement, ".");
		            break;
		        case "eng":
		            //only Alphabet, Alphabet+Number -> ComKeyOnlyAlphabet('num');
		            ComKeyOnlyAlphabet();
		            break;
		        case "engdn":
		            //only lower case of Alphabet, lower case of Alphabet+Number -> ComKeyOnlyAlphabet('lowernum');
		            ComKeyOnlyAlphabet('lower');
		            break;
		        case "engup":
		            //only upper case of Alphabet, upper case of Alphabet+Number -> ComKeyOnlyAlphabet('uppernum');
		            ComKeyOnlyAlphabet('upper');
		            break;
		        default:
		            //only number (Decimal, Date, Time)
		            ComKeyOnlyNumber(event.srcElement);
		    }
		}        
	     /**
	      * setting sheet initial values and header
	      * param : sheetObj, sheetNo
	      * adding case as numbers of counting sheets
	      * @param sheetObj sheet Object
	      * @param sheetNo 
	      */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    				var sheetID=sheetObj.id;
            switch(sheetID) {
                case "sheet1":      //sheet1 init
                    with(sheetObj){
                   
                  var HeadTitle1="|Sel.|Company Name|Address1|Address2|Address3|Address4|Address5|AR Cust.|Remark|Updated ID|Upated Office|Updated Date|Created Date";
                  var prefix='sheet1_';

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",         Wrap:1 },
                         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Chk",            Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"key_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_addr1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_addr2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_addr3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_addr4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_addr5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ar_cust_ref_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntfy_ltr_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                         {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                         {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"addr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
                   
                  InitColumns(cols);

                  SetEditable(1);
                  SetSheetHeight(430);
                        }


                    break;
            }
        }
        /**
         * Sheet process handling
         * @param sheetObj
         * @param formObj
         * @param sAction
         * @return
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
            	case IBSEARCH:      //Retrieve
            		validateForm(sheetObj,formObj,sAction);
					formObj.f_cmd.value=SEARCH;   
 					sheetObj.DoSearch("ESM_BKG_0728GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
				break;
				case IBSAVE:        //Save
					if( validateForm(sheetObj,formObj,sAction) ) {
						formObj.f_cmd.value=MULTI;
					    if (! sheetObj.IsDataModified()){
					    	ComShowCodeMessage('BKG00989');
		    	        	return;
		    	        }
					    var sParam=ComGetSaveString(sheetObjects);
		    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 		    	        var SaveXml=sheetObj.GetSaveData("ESM_BKG_0728GS.do", sParam);
 		    	        sheetObj.LoadSaveData(SaveXml);
					}
					return;
	    	    break;
				case IBDELETE:      // Delete
					var checked=0;
					for (var i=1 ; i <= sheetObj.RowCount()+1 ; i++){
						if( sheetObj.GetCellValue(i,1) == '1' ){
							checked=1;
							if (sheetObj.GetCellValue(i,0) != "I"){
								if( sheetObj.GetCellValue(i,1) == '1' ){
									sheetObj.SetRowHidden( i ,1);
									sheetObj.SetRowStatus( i ,"D");
								}
							}else{
								if( sheetObj.GetCellValue(i,1) == '1' ){
									sheetObj.SetRowStatus( i ,"D");
									i--;
								}
							}
						}	
					}
					if ( checked == 0 ) ComShowCodeMessage('BKG00249');
				break;
            }
        }
        /**
    	* handling process for input validation
    	* @param sheetObj sheet Object
    	* @param formObj  form Object
    	* @param sAction 
    	*/
     function validateForm(sheetObj,formObj,sAction){
     	switch (sAction) {
	 		case IBSEARCH: // Retrieve
//	 			if (formObj.key_addr.value == "" ) 
//	 			{
//	 				ComShowCodeMessage('BKG01101', 'Company Name');
//	 				formObj.key_addr.focus();
//	 				return false;
//	 			}
	 			return true;
	 		break;
	 		case IBSAVE: // Save
	 			for(var i=1; i<sheetObj.RowCount()+ 1 ; i++){
	 				if( sheetObj.GetCellValue(i,0) == 'I' ){
	 					if( sheetObj.GetCellValue(i,2).replace(/(^[ \\f\\n\\r\\t]*)|([ \\f\\n\\r\\t]*$)/g,"") == ""  ){
	 						ComShowCodeMessage('BKG01101', 'Company Name');
	 						return false;
	 					}
	 				}
	 			}
	 			return true;
	 		break;
	 		case IBDELETE: // Save
	 			return true;
	 		break;
     	}
     }
     
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
    var state=sheetObj.GetEtcData("TRANS_RESULT_KEY");    	
    if (state == "S") {
        ComShowCodeMessage('BKG00166');
    }
}