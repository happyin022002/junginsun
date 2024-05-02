/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0977.js
*@FileTitle  :  ESM_BKG_0977
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04 
=========================================================*/
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
 					case "btn2_RowAdd":
 							sheetObject.DataInsert(-1);
							break;
 					case "btn2_Delete":
 							doActionIBSheet(sheetObject,formObject,IBDELETE);
 							break;
 					case "btn1_Retrieve":
 							doActionIBSheet(sheetObject,formObject,IBSEARCH);
 							break;
 					case "btn1_Save":
		                	doActionIBSheet(sheetObject,formObject,IBSAVE);
							break;
					case "btn_Select":
	 						doActionIBSheet(sheetObject,formObject,COMMAND01);
	 						break;
 					case "btn1_Close":
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
  		//Event needed for screen
      	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
      	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     }
   /**
      * setting sheet initial values and header
      * 
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		var sheetId=sheetObj.id;
         switch(sheetId) {
             case "sheet1":
                 with (sheetObj) {
                 var HeadTitle1="|Sel.|UN Numbers|Description|hidden1|hidden2";
                 var headCount=ComCountHeadTitle(HeadTitle1);
                 var prefix="sheet1_";
                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                 InitHeaders(headers, info);
                 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                  {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"imdg_un_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                  {Type:"Combo",     Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"spcl_id_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_imdg_un_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"anr_spcl_tp_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                 InitColumns(cols);
                 SetEditable(1);
                 SetColProperty(prefix+"spcl_id_desc", {ComboText:"|Ammonium Nitrate|Explosives|Very Toxic Gases", ComboCode:"|AMN|SPR|ZTG"} );
                 SetColProperty(0 ,prefix+"imdg_un_no" , {AcceptKeys:"N"});
                 SetSheetHeight(235);
            	 SetCountPosition(0);
             }
 			break;
         }
     }
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 			case IBSEARCH:      //retrieve
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0977GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
 				break;
 			case IBSAVE:        //save
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("ESM_BKG_0977GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				break;
 			case IBDELETE:		// row delete
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				if(ComShowCodeConfirm('BKG03037')){
                	ComRowHideDelete(sheetObj,"sheet1_del_chk");
                	sheetObj.CheckAll("sheet1_del_chk",0,1);
				}
 				break;
    	    case COMMAND01 :
    	    	if(!validateForm(sheetObj,formObj,sAction)) return false;
    	    	sheet1_OnDblClick(sheetObj, sheetObj.GetSelectRow(), "");
    	    	break;
         }
     }
     /**
      * Cell DblClick Event
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
     function sheet1_OnDblClick(sheetObj,Row,Col) {
     	//alert("데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event \n" + "Row : " + Row + "\n" + "Col : " + Col);
//    	var pageType=document.form.pageType.value;
    	var pageType=document.form.pageGubun.value;
     	if(pageType != "MAIN") {
			var obj=new Object(); 
			obj.cd=sheetObj.GetCellValue(Row, "sheet1_imdg_un_no");
			//obj.nm = sheetObj.CellValue(Row, "sheet1_spcl_id_desc");
			var sCode=sheetObj.GetComboInfo(Row, "sheet1_spcl_id_desc", "Code");
			var arrCode=sCode.split("|");
			var idx=sheetObj.GetComboInfo(Row, "sheet1_spcl_id_desc", "SelectedIndex");
			obj.nm=arrCode[idx];
			//alert("[" + obj.cd + "] | [" + obj.nm + "]")
			if(obj.cd !="" && obj.nm != "") {
				window.returnValue=obj;

		    	if(!opener) opener=window.dialogArguments;
		    	if(!opener) opener=parent;
		    	opener.setCallBackSpclTpId(obj); 
				ComClosePopup(); 
			}
       }    
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 var sheet1RowCnt=sheetObj.RowCount();
    	 switch(sAction) {
			case IBSEARCH: { // retrieve
				//format check
				if (!ComChkValid(formObj)) return false;
				break;
			}
			case IBSAVE: {
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.GetCellValue(i,"sheet1_imdg_un_no") == "") {
						//ComShowMessage("저장대상중 UN Numbers가 없는 Row가 있습니다.");
						ComShowCodeMessage('BKG01101', " UN Numbers");
						sheetObj.SelectCell(i,"sheet1_imdg_un_no");
						return false;
					}
				}
				break;
			}
			case IBDELETE : {
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				var checkedCnt=0;
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.GetCellValue(i,"sheet1_del_chk") == "1") {
						checkedCnt++;
					}
				}
				if(checkedCnt == 0) {
					ComShowCodeMessage("BKG00546");
					return false;
				}
				break;
			}
			case COMMAND01 :
				//alert('sheet1RowCnt : ' + sheet1RowCnt + "["+sheetObj.CellValue(1,"sheet1_imdg_un_no")+"]");
				if(sheet1RowCnt == 0 || (sheet1RowCnt == 1 && (sheetObj.GetCellValue(sheetObj.GetSelectRow(),"sheet1_imdg_un_no") == "" || sheetObj.GetCellValue(sheetObj.GetSelectRow(),"spcl_id_desc") == ""))) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				break;
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
     	if (srcName == "imdg_un_no" && ComChkLen(srcValue, srcMaxLength) == "2") {
     		ComSetNextFocus();
     	}
     }
 	/**
 	 * event after save
 	 * @param sheetObj
 	 * @param ErrMsg
 	 * @return
 	 */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
 		sheetObj.CheckAll("sheet1_del_chk",0);
 		if (ErrMsg == "") {
 			var maxSheetLen=sheetObj.RowCount();
 	    	for(i=1; i <= maxSheetLen; i++) {
 	    		sheetObj.SetCellValue(i, 'sheet1_old_imdg_un_no',sheetObj.GetCellValue(i, 'sheet1_imdg_un_no'));
 	    	}
 	    	if (document.form.f_cmd.value == MULTI) {
 				ComShowCodeMessage('BKG00102');
 				doActionIBSheet(sheetObj,document.form,IBSEARCH); //재retrieve
 			}
 		} 
     }
     /**
      * event after retrieve 
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		sheetObj.CheckAll("sheet1_del_chk",0);
 		if(ErrMsg == "") {
	     	if(sheetObj.RowCount()== 0) {
	     		//ComShowMessage("There is no data to search");
	     		ComShowCodeMessage('BKG00095');
	     		sheetObj.DataInsert(-1);
	     	}
 		} else {
 			ComShowMessage(ErrMsg);
 		}
     }
