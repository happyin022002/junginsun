/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0153.js
*@FileTitle  : Chinese Booking Agent 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0153 : business script for esm_bkg_0153 
     */

   	/* developer's work*/
 // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1; 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
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
						case "btn_downexcel":
							if(sheetObject1.RowCount() < 1){
								ComShowCodeMessage("COM132501");
							}else{
								sheetObject1.Down2Excel({HiddenColumn:1,Merge:true,TreeLevel:false, SheetDesign:1, AutoSizeColumn:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
							}
						break;			
						case "btn_save":
							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
						break;
						case "btn_add":
							doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
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
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			initControl();
    	}
        /**
         * Dynamic loading the event of  HTML Control in the page <br>
         * initializing IBSheet Object when this function is called from {@link #loadPage} <br>
         * 
         * @param {ibsheet}
         *            sheetObj IBSheet Object
         * @param {int}
         *            sheetNo sheetObjects 
         */
        function initControl() {
        	var formObject=document.form;
        	// Axon handling event 1. event catch
        	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- keyboard
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        }
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets 
         */
        function initSheet(sheetObj,sheetNo) {
        	var formObj=document.form;
            var cnt=0;
    		var sheetID=sheetObj.id;
            switch(sheetID) {
                case "sheet1":      //sheet1 init
                  with(sheetObj){
                	
                  var HeadTitle1="|Control\nOffice|Agent\nCode|Customer\nCode|Customer\nCode|Booking Agent Name|Financial\nOffice|BKG\nBlock|Vendor|Vendor|Dir.\nPay|Remark(s)|Email Address|Auto\nEmail|Creation|Creation|Creation|Auto Agent\nEmail Flag||";
                  var HeadTitle2="|Control\nOffice|Agent\nCode|Customer\nCode|Customer\nCode|Booking Agent Name|Financial\nOffice|BKG\nBlock|Vendor|Vendor|Dir.\nPay|Remark(s)|Email Address|Auto\nEmail|Date|By|Office|Auto Agent\nEmail Flag||";

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                         {Type:"Text",      Hidden:0, Width:53,   Align:"Center",  ColMerge:1,   SaveName:"chn_agn_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                         {Type:"Text",      Hidden:0, Width:38,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",         KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                         {Type:"Text",      Hidden:0, Width:220,  Align:"Left",    ColMerge:1,   SaveName:"agn_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"finc_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
                         {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_blck_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
                         {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"dir_pay_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                         {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                         {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"agn_eml",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"auto_eml_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"upd_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"auto_dp_chk_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"origin_vndr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"origin_cust",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                   
                  InitColumns(cols);
                  SetEditable(1);
                  if (ComGetObjValue(formObj.screenName).indexOf("Q") > -1) {
                	  SetEditable(false);
                  }
                  SetSheetHeight(400);
                  SetFocusEditMode(-1);
                  
                  SetColProperty("cust_cnt_cd", {AcceptKeys : "E", InputCaseSensitive :1} );
                  SetColProperty("dir_pay_ofc_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
                  SetColProperty("cust_seq", {AcceptKeys : "N"} );
                 
                  }
                  break;
            }
        }
      // handling of Sheet 
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
				case IBSEARCH:      //search
					if(validateForm(sheetObj,formObj,sAction)){
			        	  formObj.f_cmd.value=SEARCH;
			        	  sheetObj.DoSearch("ESM_BKG_0153GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(""));
					}	  
			        break;
				case IBSAVE:        //save
					if(validateForm(sheetObj,formObj,sAction)) {
						formObj.f_cmd.value=MULTI;
						sheetObj.DoSave("ESM_BKG_0153GS.do", FormQueryString(formObj));
	    			}
	                break;
				case IBINSERT:      // insert
					//add new row
	 				sheetObj.DataInsert(-1);
	                break;
            }
        }
        function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {	
   	 	 	if (Msg == "") {
    	 		ComBkgSaveCompleted();  //handling server message
    	 		doActionIBSheet(sheetObj, document.form, IBSEARCH);
    		} 	 	
       }
       function sheet1_OnAfterEdit(sheetObj,Row,Col){
    	   var formObj=document.form;
    	   var param ;
    	   var sheet2=sheetObjects[1];
    	   with (sheetObj) {
	    	   var sName=ColSaveName(Col);
				if (GetCellValue(Row,Col) =="") return;
				var cust_cd=GetCellValue(Row,"cust_cnt_cd")+ GetCellValue(Row,"cust_seq");
	    	   if (sName == 'ofc_cd'){
					formObj.f_cmd.value=COMMAND01;
					param=param+"&f_cmd="+COMMAND01;
					param=param+"&ofc_cd="+GetCellValue(Row,Col);
					var sXml=sheetObj.GetSearchData("ESM_BKG_0153GS.do", param);
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F') {LoadSearchData(sXml,{Sync:0} );
						//CellValue2(Row,Col) = "";
						SelectCell(Row,Col,false);
						return;
					}
					SetCellValue(Row, "finc_ofc_cd",ComGetEtcData(sXml,"ar_ofc_cd"),0);
	    	   }else if (sName == 'cust_cnt_cd'){
	    		   if (GetCellValue(Row,'cust_seq') != ""){
	    			   	formObj.f_cmd.value=COMMAND02;
	    			   	param=param+"&f_cmd="+COMMAND02;
						param=param+"&cust_cnt_cd="+GetCellValue(Row,"cust_cnt_cd");
						param=param+"&cust_seq="+GetCellValue(Row,"cust_seq");
						var cust_cd=GetCellValue(Row,"cust_cnt_cd")+ GetCellValue(Row,"cust_seq");
						if (cust_cd == GetCellValue(Row,"origin_cust")){
							 return;
	 				    }
						var sXml=sheetObj.GetSearchData("ESM_BKG_0153GS.do", param);
						if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F') {
							LoadSearchData(sXml,{Append : 1 } );
							SelectCell(Row,Col,false);
							return;
						}
						//CellValue2(Row, "agn_nm")= ComGetEtcData(sXml,"name");
	    		   }
	    	   }else if (sName == 'cust_seq'){
	    		   formObj.f_cmd.value=COMMAND02;
	    		   param=param+"&f_cmd="+COMMAND02;
	    		   param=param+"&cust_cnt_cd="+GetCellValue(Row,"cust_cnt_cd");
	    		   param=param+"&cust_seq="+GetCellValue(Row,"cust_seq");
	    		   if (cust_cd == GetCellValue(Row,"origin_cust")){
				    	return;
				   }
	    		   var sXml=sheetObj.GetSearchData("ESM_BKG_0153GS.do", param);
				   if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F') {
					   LoadSearchData(sXml,{Append : 1 } );
						SelectCell(Row,Col,false);
						return;
				   }
				   //CellValue2(Row, "agn_nm")= ComGetEtcData(sXml,"name");
	    	   }
    	   }
       }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
	            	switch(sAction) {
						case IBSAVE: 
			            	var rowM=sheetObj.ColValueDup("ofc_cd|chn_agn_cd|cust_cnt_cd|cust_seq|agn_nm");
							if (rowM >= 0) {
								 ComShowCodeMessage("BKG03833", "Sheet", rowM); //BKG00833
							     return false;
						    }	 
							for(var i=2; i<=sheetObj.RowCount();i++){
								if(sheetObj.GetCellValue(i,"agn_eml")!=""){
									if(!ComIsEmailAddr(sheetObj.GetCellValue(i,"agn_eml"))){
										ComShowCodeMessage("BKG00366");
										sheetObj.SelectCell(i,"agn_eml");
										return false;
									}
								}
							}
							break;
					case IBSEARCH: // checking when it is saved
		         		if (!ComChkValid(formObj)) return false;
		        		if(!ComIsNull(formObj.cust_seq)&&!ComIsNumber(formObj.cust_seq.value)){
		        			ComShowCodeMessage("BKG00340");
		        			ComSetFocus(formObj.cust_seq);
		        			return false;
		        		}
		         		break;
		         		
            	}	
            }
            return true;
        }
	/* the end of developer's work */
