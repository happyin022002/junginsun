/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_FMS_0079.js
*@FileTitle  : E-mail / Print 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class E-mail / Print : E-mail / Print definition of biz script for creation screen
     */

	// common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;

	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_rowAdd":
					var row=sheetObject.DataInsert(-1);
	                break;
				case "btn_rowDel":
					if(checkBoxCheckYn(sheetObject, "DelChk")) {
	            		rowRemove(sheetObject, "");
	            	}
					break;
                case "btn_new":
                		formObject.recipient.value="";
                		TextEditor.document.body.innerHTML="";
                		formObject.content.value="";
                		formObject.subject.value=formObject.title.value;
                		document.getElementById("ctntCount").innerText=0;
                		ComResetAll();
                		font_style.disabled=false;
                		font_size.disabled=false;
                		font_color.disabled=false;
                		font_etc.disabled=false;
                		document.all.i_edit.style.display="";
                		document.all.i_text.style.display="none";
                		formObject.email_mode.selectedIndex=0;
                		ComBtnEnable("btn_E-mail");
                    break;
                case "btn_E-mail":
                	doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                case "btn_close":
                		ComClosePopup(); 
                    break;
                case "btn_email":
                		ComOpenPopup("ESM_FMS_0084.do", 460, 370, "setEmail", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0084");
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
        initUpload();
        
        TextEditor.document.designMode="On";
    }
    
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/ESM_FMS_0079GS.do'
 			,Files:[]
	 		,BeforeAddFile : function(result){
			 	return true;
			}
			,BeforeSaveStatus : function(result){ 
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
	 			var formObj = document.form;
 				//fileName=fileName.substr(fileName.lastIndexOf("\\") + 1);
      			ComOpenWait(true);
      			
 				var param= "file_cnt=" + files.length; 
 				
				//2.Binding IBSheet Data in QueryString
				var arrSheets=new Array(sheetObjects[0]);
				var sParam=ComGetSaveString(arrSheets, true);
				if (sParam == "") return;
				//3.Binding Form Data in QueryString				
				var aryPrefix=new Array("");				
				sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
				sParam += "&" + param;
				
		 		paramToForm(sParam);
			 	return true;
			}
			,AfterSaveStatus : function(result) {
				ComOpenWait(false);
	      		var code = result.code;
	      		var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
//	      		alert("(Test)AfterSaveStatus code = "+code+"\nsXml = "+sXml);
	      		var formObj = document.form;
	      		if( code == 0) {
					//var arrXml=sXml.split("|$$|");   // 확인 
					//sheetObj.LoadSearchData(arrXml[0],{Sync:1} );  //확인
	      		}
	      		showErrorMsg(sXml);
			}
	 		,AfterAddFile:function(result){
                var files = result.files;
                var fileName=files[files.length-1].GetFileName();
                var row = sheet1.GetSelectRow();
				
                for( var i = 0; i < files.length; i++) {
                	if(sheet1.GetCellValue(sheet1.GetSelectRow(), "file_nm") == files[i].GetFileName()){
                		files[i].DeleteFromList();
                	}
                }
                sheet1.SetCellValue(row, "file_path",fileName,0);
                sheet1.SetCellValue(row, "file_nm" ,fileName,0);
 				
			}
 		});
 	}
    

    /**
     * Event occurred when mouse pointer is moving <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	Selected Button of sheetObj
     * @param {ibsheet} Shift     	Selected Shift of sheetObj
     * @param {int} 	X     		X Coordinate Value
     * @param {int} 	Y     		Y Coordinate Value
     **/
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		var row     = sheetObj.MouseRow(),
        col     = sheetObj.MouseCol(),
        info    = null;
        if (row > 0 &&sheetObj.ColSaveName(col) == "file_nm") {
            info = sheetObj.GetCellElement(row, col, 1);
    		pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
            upload1.SetFileUploadElement(info);
        } 
	}
	
	
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //t1sheet1 init
            	  with(sheetObj){
		               var HeadTitle="|Sel|File Upload|File Path";
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                         {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		                         {Type:"Popup",     Hidden:0, Width:400,  Align:"Left",    ColMerge:0,   SaveName:"file_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
		                         {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:"file_path",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                
		               InitColumns(cols);
		
		               SetEditable(1);
		               SetSheetHeight(120);
		               SetImageList(0,"/opuscntr/img/ico_attach.gif");
		               SetDataLinkMouse("file_nm",1);
		               SetShowButtonImage(1);
            	}
            	  break;
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					form.recipient.value=form.recipient.value + ";" + form.from.value;
					if(formObj.email_mode.value == "E") {
						var content=TextEditor.document.body.innerHTML;
						formObj.content.value=strReplace(strReplace(content, "<P>", ""),"</P>","");
						if(formObj.content.value == "" 
						   || formObj.content.value=="<P>&nbsp;</P>"
						   || formObj.content.value=="&nbsp;") {
							formObj.content.value=formObj.msg_ctnt.value;
							formObj.contentYn.value="N";
						} else {
							contentLen();
						}
					} else {
						if(formObj.content.value == "") {
						    formObj.content.value=formObj.msg_ctnt.value;
							formObj.contentYn.value="N";
						}
					}
        			formObj.f_cmd.value=MULTI;
        			// 1.Adding File to IBUpload
        			var fileList = upload1.GetList();
        			ComBtnDisable("btn_E-mail");
        			
    				if(fileList.length > 0) {
    					upload1.SaveStatus();
    				} else {
    					sheetObj.DoSearch("ESM_FMS_0079GS.do", FormQueryString(formObj) );
    				}
        			if(formObj.contentYn.value == "N") {
        				formObj.content.value="";
        				formObj.contentYn.value="";
        			}
        			//ComBtnEnable("btn_E-mail");
        		}
                break;
        }
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL)
     **/
    function validateForm(sheetObj,formObj,sAction){
    	if(form.recipient.value == "") {
    		ComAlertFocus(form.recipient, ComGetMsg('FMS01146'));
    		return false;
    	}
    	if(form.subject.value == "") {
    		ComAlertFocus(form.subject, ComGetMsg('FMS01191'));
    		return false;
    	}
        return true;
    }
    /**
     * Setting Email selected in E-mail List Select PopUp <br>
     * @param aryPopupData
     */
    function setEmail(aryPopupData) {
    	form.recipient.value="";
    	var recipient="";
    	var idx=0;
    	var chkCnt=aryPopupData.length;
        for(var i=0; i<aryPopupData.length; i++) {
        	idx++;
 		    var emailData=aryPopupData[i];
 		    if(chkCnt == 1) {
 		    	recipient=emailData.cntc_pson_eml;
 		    } else {
 		    	if(chkCnt == idx) {
 		    		recipient += emailData.cntc_pson_eml;
 		    	} else {
 		    		recipient += emailData.cntc_pson_eml+";";
 		    	}
 		    }
    	}
        form.recipient.value=recipient;
    	//form.recipient.value = aryPopupData[0][4];
    }
    /**
     * Restrict digit number of E-mail Contents <br>
     * @param {form}	formObj		Form Object(contents)
     */
    function contentLen(){
    	if(ComGetLenByByte(document.form.content) < 10001){
    		document.getElementById("ctntCount").innerText=ComGetLenByByte(document.form.content);
    	}else{
    		var temp=document.form.content.value.length;
    		ComShowCodeMessage('FMS01190');
    		document.form.content.value=document.form.content.value.substring(0,ComParseInt(temp)-1);
    	}
	} 
    /**
     * Deleting row  <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	Variable Separator
     * @return none
     **/
	function rowRemove(sheetObj, prefix) {
		var sRow=sheetObj.FindCheckedRow(prefix + "DelChk");
		if (sRow == "") return;
		var arrRow=sRow.split("|"); 
		for (var idx=arrRow.length-1; idx>=0; idx--){
			var row=arrRow[idx];
			sheetObj.SetRowHidden(row,1);
			sheetObj.SetRowStatus(row,"D");
		}
	}


    /**
     * Setting Iframe after Page loading  <br>
     **/
    function initEditor() {
    	//TextEditor.document.body.style.padding = "1px";
    	//TextEditor.document.body.style.font = "9pt 굴림";
        //TextEditor.document.body.style.fontSize = "12px";
        //TextEditor.document.body.style.lineHeight = "0px";
        //TextEditor.document.body.style.padding = "10px 10px 10px 0px";
    }
    /**
     * Changing Font/Size of inserted Contents <br>
     * @param {String} 	param 	selected value
     * @param {String} 	cmd 	Font/Size Separator
     **/
    function chBlockStyle(param, cmd) {
    	var ed=TextEditor.document.selection.createRange();
    	ed.execCommand(cmd, false, param);
    }
    /**
     * Changing Color of inserted contents <br>
     * @param {String} 	param 	selected Value
     * @param {String} 	cmd 	Font Separator
     **/
    function chFontColor(param,cmd){
    	var ed
    	ed=TextEditor.document.selection.createRange();
    	ed.execCommand(cmd, false, param);
    }
    /**
     * Changing inserted contents by othre options<br>
     * @param {String} 	Btn 	form Object
     * @param {String} 	cmd 	other option separator 
     **/
    function chSelectionCommand(Btn, cmd) {
    	TextEditor.focus();
    	var EdRange=TextEditor.document.selection.createRange();
    	EdRange.execCommand(cmd);
    }
    /**
     * Changing inserted contents by othre options <br>
     * @param {String} 	Btn 	form Object
     * @param {String} 	cmd 	other option separator
     **/
    function chMode(val) {
    	if(val == "E") {
    		document.all.font_style.disabled=false;
    		document.all.font_size.disabled=false;
    		document.all.font_color.disabled=false;
    		document.all.font_etc.disabled=false;
    		document.all.i_edit.style.display="";
    		document.all.i_text.style.display="none";
    		//TextEditor.document.body.innerHTML = document.form.content.value;
    		document.form.content.value="";
    		TextEditor.focus();
    	} else {
    		document.all.font_style.disabled=true;
    		document.all.font_size.disabled=true;
    		document.all.font_color.disabled=true;
    		document.all.font_etc.disabled=true;
    		document.all.i_edit.style.display="none";
    		document.all.i_text.style.display="";
    		//document.form.content.value = TextEditor.document.body.innerHTML;
    		TextEditor.document.body.innerHTML="";
    		document.form.content.focus();
    	}
    }
    /**
     * Changing inserted contents by othre options <br>
     * @param {String} 	strOriginal 	contents
     * @param {String} 	strFind 		string to find
     * @param {String} 	strChange 		string to change
     **/
    function strReplace(strOriginal, strFind, strChange){ 
        var position; 
        position=strOriginal.indexOf(strFind);  
        while (position != -1){ 
          strOriginal=strOriginal.replace(strFind, strChange); 
          position=strOriginal.indexOf(strFind); 
        } 
        return strOriginal;
    } 
