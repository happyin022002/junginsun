/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_2003.js
*@FileTitle  : P/L Report Item Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_COA_2003 : ESM_COA_2003 business script for
     */
   	/* developer job	*/
 // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboXml=new Array();
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
        /**
         * Event handler processing by button name 
         */
        function processButtonClick(){
            var sheetObject=sheetObjects[0];
            var formObject=document.form;
            try {
                var srcName=ComGetEvent("name");
                if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
                    case "btn_retrieve":
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
                    case "btn_save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;
                    case "btn_downexcel":
						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
						break;    
                    case "btn_Close":
                    	ComClosePopup(); 
                        break;
                    case "btng_rowadd":
						doActionIBSheet(sheetObject,formObject,IBINSERT);
						break;
                } // end switch
            }catch(e) {
                if( e == "[object Error]") {
                	ComShowMessage(ComGetMsg(OBJECT_ERROR));
                } else {
                	ComShowMessage(e.message);
                }
            }
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
			for(i=0;i<sheetObjects.length;i++){
				ComConfigSheet(sheetObjects[i]);//
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]);//
			}
//			axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
//	    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	    	axon_event.addListenerForm('click', 'obj_click', document.form); // click
	    	//initial setting
	    	//initPage();
	//		btn_retrieve.focus();
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
        //  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
//		                    (13, 0, 0, true);                      //setting Column information [mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                         var HeadTitle0="||Profit Level|Profit View|Sub Group|Sub Group|Sub Group|Performance\nView Code|Report Item|Report Item|Seq.|Seq.|Flag";
                         var HeadTitle1="Del.|STS|Profit Level|Profit View|Cost Code|Cost Code Desc.|Local Desc.|Performance\nView Code|Desc.|Local Desc.|RPT Disp.|Sub Disp.|Color";
		
		                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		                 var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		                 var headers = [ { Text:HeadTitle0, Align:"Center"},
		                           { Text:HeadTitle1, Align:"Center"} ];
		                 InitHeaders(headers, info);
		
		                 var cols = [ {Type:"DelCheck",  Hidden:0, Width:25,   Align:"Left",    ColMerge:0,   SaveName:"delt_flg" },
		                     {Type:"Status",    Hidden:0, Width:25,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"rpt_vw_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:1,   SaveName:"sgrp_cost_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
		                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"sgrp_cost_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
		                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"sgrp_locl_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"stnd_cost_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
		                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"rpt_itm_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"locl_rpt_itm_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rpt_dp_seq",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rpt_dp_sgrp_seq",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rpt_itm_colr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" } ];
		                  
		                 InitColumns(cols);
		
		                 SetEditable(1);//Editkind[optional,Defaultfalse]
		                 SetColProperty(0 ,"sgrp_cost_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		                 SetColProperty(0 ,"stnd_cost_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		                 SetColHidden("rpt_vw_cd",1);//cause only one select
//		                 SetSheetHeight(500);
						 resizeSheet();
		                 InitComboNoMatchText(1,"",1);
                 }


                    break;
            }
        }
        /**
         * registering IBCombo Object as list
         * adding process for list in case of needing batch processing with other items
         * defining list on the top of source
         */
        function setSheetObject(sheet_obj){
        	sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * handling process for Sheet
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
            	case IBCLEAR:          //retrieve
			        sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=INIT;
					var sParam=coaFormQueryString(formObj);
 	  				var sXml=sheetObj.GetSearchData("ESM_COA_2003GS.do", sParam);
	  				var arrXml=sXml.split("|$$|");
	  				if (arrXml.length > 0)
						ComCoaSetIBCombo(sheetObj, arrXml[0], "stnd_cost_tp_cd", false, 0);
	  				if (arrXml.length > 1)
						ComCoaSetIBCombo(sheetObj, arrXml[1], "rpt_vw_cd", false, 0);
					ComOpenWait(false);
					break;
                case IBSEARCH:      //retrieve
                	if (sheetObj.IsDataModified()&& ComShowCodeConfirm("COM130504")) {
    	   				//validation check
    	   				if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
    	   					return false;
    	   				}
    				}
                    if(validateForm(sheetObj,formObj,sAction))
                    	sheetObj.SetWaitImageVisible(0);
				    ComOpenWait(true);
                    formObj.f_cmd.value=SEARCH;
                    sheetObj.DoSearch("ESM_COA_2003GS.do", coaFormQueryString(formObj) );
//                    ComOpenWait(false);
                    break;
                case IBINSERT:	// inserting
					sheetObj.DataInsert(-1);
					break;
				case IBSAVE: // Save
					if(validateForm(sheetObj,formObj,IBSAVE)){
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
			     		formObj.f_cmd.value=MULTI;
		     			var sParam=sheetObjects[0].GetSaveString(false, true, "ibflag");
 		     			var sXml=sheetObjects[0].GetSaveData("ESM_COA_2003GS.do", "f_cmd=" + MULTI + "&" +sParam);
						var dupChk=ComGetEtcData(sXml, "dup_chk");
						var transResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
						if((dupChk == "S"||dupChk=="") && transResultKey == "S"){
		     				ComShowCodeMessage("COM130102","Data");//Success
						}else if(dupChk == "Dup"){
							ComShowCodeMessage('COM12115', 'Standard Cost Code');//Standard Cost Code and Profit View -> Standard Cost Code
							ComOpenWait(false);
							break;
		     			}else{
		     				ComShowCodeMessage("COM12151",'Data'); //Failed 
		     			}
						sheetObj.RemoveAll();
		     			//doActionIBSheet(sheetObj,formObj,IBSEARCH);

						ComOpenWait(true);
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch("ESM_COA_2003GS.do", FormQueryString(formObj));
						ComOpenWait(false);
	     			}
	     			break;
	     		case IBDOWNEXCEL:	//down excel
					var excelType=selectDownExcelMethod(sheetObj);
					break;
            }
        }
        
        function callBackExcelMethod(excelType){
        	var sheetObj = sheetObjects[0];
        	 switch (excelType) {
	            case "AY":
	                sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	                break;
	            case "AN":
			    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			    	break;
	            case "DY":
	            	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	            	break;
	            case "DN":
			    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
			    	break;
        	 }
        }

        function sheet1_OnSearchEnd(shtObj, ErrMsg) {
    		ComOpenWait(false);
        }			
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            switch(sAction){		
			case IBSAVE:
				// key field filled ? 
				var j=0;
				with(sheetObj){
					for(var i=1;i<=LastRow();i++){
						if(GetCellValue(i, "ibflag")=='I'){
							j=j+1;
							if(GetCellValue(i, "stnd_cost_tp_cd")==null || GetCellValue(i, "stnd_cost_tp_cd")==""){
								ComShowCodeMessage('COM130403', 'Profit Level');//key field missing
								sheetObj.SelectCell(i, "stnd_cost_tp_cd");
								return false;
								break;
							}else if(GetCellValue(i, "rpt_vw_cd")==null || GetCellValue(i, "rpt_vw_cd")==""){
							 	ComShowCodeMessage('COM130403', 'Profit View');//key field missing
								sheetObj.SelectCell(i, "rpt_vw_cd");
								return false;
								break;
							}else if(GetCellValue(i, "sgrp_cost_cd")==null || GetCellValue(i, "sgrp_cost_cd")==""){
							 	ComShowCodeMessage('COM130403', 'Sub Group Cost Code');//key field missing
								sheetObj.SelectCell(i, "sgrp_cost_cd");
								return false;
								break;
							}else if(GetCellValue(i, "stnd_cost_cd")==null || GetCellValue(i, "stnd_cost_cd")=="" ){
								ComShowCodeMessage('COM130403', 'Standard Cost Code');//key field missing
								sheetObj.SelectCell(i, "stnd_cost_cd");
								return false;
								break;
							}else if(GetCellValue(i, "sgrp_cost_cd").length!=4){
								ComShowCodeMessage('COA10067', 'Sub Group Cost Code', '4');//'{?msg1} must be {?msg2} characters long.'
								sheetObj.SelectCell(i, "sgrp_cost_cd");
								return false;
								break;
							}else if(GetCellValue(i, "stnd_cost_cd").length!=8){
								ComShowCodeMessage('COA10067', 'Standard Cost Code', '8');//'{?msg1} must be {?msg2} characters long.'
								sheetObj.SelectCell(i, "stnd_cost_cd");
								return false;
								break;
							}
						}else if(GetCellValue(i, "ibflag")=='U'||GetCellValue(i, "ibflag")=='D'){
							j=j+1;
						}
					}
					if(j==0){
						ComShowCodeMessage('COA10065');
						return false;
						break;
					}
				}
				var dr=sheetObj.ColValueDup("stnd_cost_cd|rpt_vw_cd");
				if(dr>0){//duplication		
					ComShowCodeMessage('COM12115', 'Standard Cost Code');//Standard Cost Code and Profit View -> Standard Cost Code
					sheetObj.SelectCell(dr,"stnd_cost_cd");
					return false;
				}
				break;
			}   
            return true;
        }
        
        function resizeSheet(){
       	 ComResizeSheet(sheetObjects[0]);
        }
	/* developer job end */
