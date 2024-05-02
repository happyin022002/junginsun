/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1096.js
*@FileTitle  : Email(Edit)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


 var sheetObjects = new Array();
 var sheetCnt = 0;

 var por_cd;
 
 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
 function processButtonClick(){
     /***** using extra sheet valuable if there are more 2 sheets *****/
     /*******************************************************/
     var sheetObject=sheetObjects[0];
     var formObject=document.form;
     try {
         var srcName=ComGetEvent("name");
         switch(srcName) {
             case "btn_Send":
 				if(!validateForm(sheetObject,formObject,MULTI)) {
 					return false;
 				}
                 doActionIBSheet(sheetObject,formObject,MULTI);
                 break;
             case "btn_Close":
            	 ComClosePopup(); 
                 break;
         } // end switch
     } catch(e) {
         if ( e == "[object Error]") {
             ComShowCodeMessage("COM12111");
         } else {
        	 ComShowCodeMessage(e.message);
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
     for (var i=0; i<sheetObjects.length; i++) {
         ComConfigSheet(sheetObjects[i]);
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 }
 function initControl() {
	   	if (document.getElementById("ui_id").value == "ESM_BKG_0079_02C") {
	   		document.form.email.value=opener.document.form.eml.value;
	   		ComBtnDisable("btn_ok");
		}
 }
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     var sheetID=sheetObj.id;
     switch(sheetID) {
         case "sheet1":      //sheet_search
        	 with(sheetObj){
	        	 var HeadTitle1="ibflag|edt_bkg_no_list|edt_ntc_knd_cd|edt_to_eml|edt_cc_eml|edt_from_eml|edt_subject|edt_contents";
	
	        	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	 InitHeaders(headers, info);
	
	        	 var cols = [ {Type:"Status",    Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
	        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"edt_bkg_no_list",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"edt_ntc_knd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"edt_to_eml",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"edt_cc_eml",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"edt_from_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"edt_subject",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"edt_contents",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
	
	        	 InitColumns(cols);
	
	        	 SetVisible(0);
        	 }


             break;
     }
 }
 // handling sheet process
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
     	case IBSEARCH : //retrieve
	        	formObj.f_cmd.value=SEARCH;
 	            sheetObj.DoSearch("ESM_BKG_1096GS.do", FormQueryString(formObj));
 	            break;
     	case MULTI : //Email
	    		var ui_id=ComGetObjValue(formObj.ui_id);
	    		var win=(opener||parent);
	    		 if( ComTrim(ComGetObjValue(formObj.edt_to_eml)) != ""
	                 && !ComIsEmailAddr(ComGetObjValue(formObj.edt_to_eml))){
	                 ComShowCodeMessage("BKG40021" , ComGetObjValue(formObj.edt_to_eml));
	                 return;
	             }
	    		 if( ComTrim(ComGetObjValue(formObj.edt_cc_eml)) != ""
	                 && !ComIsEmailAddr(ComGetObjValue(formObj.edt_cc_eml))){
	                 ComShowCodeMessage("BKG40021" , ComGetObjValue(formObj.edt_cc_eml));
	                 return;
	             }
				sheetObj.SetCellValue(1,"edt_to_eml",ComGetObjValue(formObj.edt_to_eml),0);
				sheetObj.SetCellValue(1,"edt_cc_eml",ComGetObjValue(formObj.edt_cc_eml),0);
				sheetObj.SetCellValue(1,"edt_from_eml",ComGetObjValue(formObj.edt_from_eml),0);
				sheetObj.SetCellValue(1,"edt_subject",ComGetObjValue(formObj.edt_subject),0);
				sheetObj.SetCellValue(1,"edt_contents",CKEDITOR.instances.edt_contents.getData(),0);
				ComSetObjValue(win.document.form.elements["edt_ntc_knd_cd" ],sheetObj.GetCellValue(1,"edt_ntc_knd_cd" ));
				ComSetObjValue(win.document.form.elements["edt_bkg_no_list"],sheetObj.GetCellValue(1,"edt_bkg_no_list"));
				ComSetObjValue(win.document.form.elements["edt_to_eml"     ],sheetObj.GetCellValue(1,"edt_to_eml"     ));
				ComSetObjValue(win.document.form.elements["edt_cc_eml"     ],sheetObj.GetCellValue(1,"edt_cc_eml"     ));
				ComSetObjValue(win.document.form.elements["edt_from_eml"   ],sheetObj.GetCellValue(1,"edt_from_eml"   ));
				ComSetObjValue(win.document.form.elements["edt_subject"    ],sheetObj.GetCellValue(1,"edt_subject"    ));
				ComSetObjValue(win.document.form.elements["edt_contents"   ],sheetObj.GetCellValue(1,"edt_contents"   ));
				//Fax/EDI
				if ("ESM_BKG_0095"==ui_id) {
					var arrRow=ComFindText(win.sheetObjects[0], "slct_flg", 1);
					if (arrRow && 1==arrRow.length) {
						win.sheetObjects[0].SetCellValue(arrRow[0],"eml",sheetObj.GetCellValue(1,"edt_to_eml"),0);
						if(!win.validateForm(win.sheetObjects[0],win.document.form,"btn_Email")) return false;
						win.doActionIBSheet(win.sheetObjects[0],win.document.form,"btn_Email");
						self.close();
					}
				//Booking Receipt Notice (Fax/Email)
				} else if ("ESM_BKG_0098"==ui_id) {
					var arrRow=ComFindText(win.sheetObjects[0], "slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							win.sheetObjects[0].SetCellValue(arrRow[i],"eml",sheetObj.GetCellValue(1,"edt_to_eml"),0);
						}
						if(!win.validateForm(win.sheetObjects[0],win.document.form,"btn_GroupEmail")) return false;
						win.doActionIBSheet(win.sheetObjects[0],win.document.form,"btn_GroupEmail");
						self.close();
					}
				//Draft B/L & Waybill (Fax/E-Mail) - Outbound
				} else if ("ESM_BKG_0218_01"==ui_id) {
					var arrRow=ComFindText(win.sheetObjects[0],win.sheetObjects[0].id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							win.sheetObjects[0].SetCellValue(arrRow[i],win.sheetObjects[0].id+"eml",sheetObj.GetCellValue(1,"edt_to_eml"),0);
						}
						if(!win.validateForm(win.sheetObjects[0],win.document.form,"btn_groupemail_t1sht1")) return false;
						win.doActionIBSheet(win.sheetObjects[0],win.document.form,"btn_groupemail_t1sht1");
					}
				//Draft B/L & Waybill (Fax/E-Mail) - Inbound
				} else if ("ESM_BKG_0218_02"==ui_id) {
					var arrRow=ComFindText(win.sheetObjects[1],win.sheetObjects[1].id+"slct_flg", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							win.sheetObjects[1].SetCellValue(arrRow[i],win.sheetObjects[1].id+"eml",sheetObj.GetCellValue(1,"edt_to_eml"),0);
						}
						if(!win.validateForm(win.sheetObjects[1],win.document.form,"btn_groupemail_t2sht1")) return false;
						win.doActionIBSheet(win.sheetObjects[1],win.document.form,"btn_groupemail_t2sht1");
					}
				} else if ("ESM_BKG_0252"==ui_id) {
					var arrRow=ComFindText(win.sheetObjects[0], "Check", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							win.sheetObjects[0].SetCellValue(arrRow[i],"ntc_eml",sheetObj.GetCellValue(1,"edt_to_eml"),0);
						}
						win.makeRdParam(win.rdObjects[0],win.document.form,win.sheetObjects[0]);
						win.doActionIBSheet(win.sheetObjects[0],win.document.form,"EMAIL");
					}
				// COD Application
				} else if ("ESM_BKG_0156" == ui_id){
					ComSetObjValue(win.document.form.elements["edt_eml_btn_flg" ],"Y");
					win.doActionIBSheet(win.sheetObjects[0],win.document.form,"snd_mail");
					ComShowMessage(msgs['BKG00497']);
					self.close();
				}
         break;
     }
 }
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
 	switch (sAction) {
 		case MULTI:
 			if (ComIsNull(formObj.edt_to_eml)) {
                 ComShowCodeMessage("BKG00245");  //E-mail is invalid {?msg1}. Please check it again.
                 formObj.edt_to_eml.select();
                 return false;
 			}
 		break;
 	}
     return true;
 }
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			if (1==GetTotalRows()) {
				/*CKEDITOR toolbar
				['Source','-','Save','NewPage','Preview','-','Templates'],
		        ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
		        ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
		        ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
		        '/',
		        ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
		        ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote','CreateDiv'],
		        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
		        ['Link','Unlink','Anchor'],
		        ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
		        '/',
		        ['Styles','Format','Font','FontSize'],
		        ['TextColor','BGColor'],
		        ['Maximize', 'ShowBlocks','-','About']*/
				var formObj=document.form;
				ComSetObjValue(formObj.edt_to_eml,GetCellValue(1,"edt_to_eml"));
				ComSetObjValue(formObj.edt_cc_eml,GetCellValue(1,"edt_cc_eml"));
				ComSetObjValue(formObj.edt_from_eml,GetCellValue(1,"edt_from_eml"));
				ComSetObjValue(formObj.edt_subject,GetCellValue(1,"edt_subject"));
				setTimeout(function(){CKEDITOR.instances.edt_contents.setData(GetCellValue(1,"edt_contents"));},10);
				CKEDITOR.config.toolbar=[
					["NewPage","Preview","Print","-","Bold","Italic","Underline","Strike","-","TextColor","BGColor","-","Link"],
					"/",
					["Format","Font","FontSize","-","Source"]
			    ];
			}
		}
	}
