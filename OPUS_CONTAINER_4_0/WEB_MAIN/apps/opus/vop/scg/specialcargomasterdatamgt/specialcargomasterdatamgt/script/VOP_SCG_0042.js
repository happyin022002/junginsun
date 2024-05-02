/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_SCG_0042.js
*@FileTitle  : Packing Instructions/Provisions (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var prefix="sheet1_";
    var uploadObjects=new Array();
	var uploadCnt=0;
	/**
     * Dynamically load HTML Control event in page. <br>
     * Initialize IBSheet Object by calling this function from {@link #loadPage} function. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects list in turn
     **/
    function initControl() {    	
        //Axon event handling1. event catch
     //   axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
       // axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
    }
    // Handling business javascript OnKeyUp event
//    function obj_keypress() {
//    	switch(event.srcElement.dataformat){
//    	    case "engup":
//    	    	switch(event.srcElement.name){
//	    	        case "imdg_pck_instr_cd":	
//	    	        	//common standard : only English,number
//	        	    	ComKeyOnlyAlphabet('uppernum');
//	    	        	break;
//    	    	}
//    	    	break; 
//    	}
//    }
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
	    var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_fileadd":  
					selectFile(sheetObject, true);
					break;
				case "btn_update":
//					selectFile(sheetObject, false);
					break; 
				case "btn2_Row_Insert":
					sheetObject.DataInsert();									//create below selected row[Sheet1]
					break;
				case "btn2_Row_Delete":
					var files = upload1.GetList();
					var row = sheetObject.GetSelectRow();
									
				    var sheet_serial = sheetObject.GetCellValue(row, prefix+"file_sav_id");
				    ComUploadRemoveFile(upload1, sheet_serial, false);

					ComRowHideDelete(sheetObject, prefix+"del_chk");
					break;	
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);					
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
     * Selecting file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} addRowFlag  sheetObj Row add
     **/
	function selectFile(sheetObj, addRowFlag){
		if(addRowFlag) {
			sheetObj.DataInsert(-1,0);
		} else {
			var filePath=sheetObj.OpenFileDialog('Please choose target file to upload.');
			if(filePath.indexOf("\\") !=-1) {
				with(sheetObj) {
					SetCellValue(GetSelectRow(), prefix+"file_set_yn","Y",0);
					SetCellValue(GetSelectRow(), prefix+"file_sav_id",filePath,0);
					fileName=filePath.substr(filePath.lastIndexOf("\\")+1);
					SetCellValue(GetSelectRow(), prefix+"file_nm",fileName,0);
 					GetCellFontUnderline(SetSelectRow, prefix+"file_nm")(0);
					SelectCell(GetSelectRow(),prefix+"imdg_pck_instr_cd");
				}
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
     * register IBUpload Object created in page as uploadObjects list <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++]=uploadObj;
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
        initControl();
        sheet1_OnLoadFinish(sheetObjects[0])
    }
    /**
     * 추가
     */
    function initUpload(){
    	upload1.Initialize({
			SaveUrl:'/opuscntr/VOP_SCG_0042GS.do',
			ShowButtonArea: true,
			ExtraForm:'upLoadForm',
			AddSaveButton: function(ibup){
				
			},
			AfterSaveStatus : function(result) {
				console.log(result)
				var code = result.code;
				ComUploadRemoveFile(upload1, "", true);
				if(document.upLoadForm){
					document.body.removeChild(document.upLoadForm);
				}
	      		if( code == 0) {
	 				var files = result.files;
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			sXml = convert2ibsheet7(sXml);
	      			if (sXml.length > 0) sheet1.LoadSaveData(sXml);
	      		}else {
	      			
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			var  Msg=ComScgGetMessageFromXml(sXml );
	      			alert(Msg)
	      			alert(sXml)
	      			var aaa = Msg.split("<||>");
	      			alert(aaa[1])
					ComShowMessage(result.msg);
				}
			},			
			BeforeSaveStatus : function(result) {
			   return true;
			},
			AfterAddFile : function(result) {
				 var files = upload1.GetList();
			     var fileName=files[files.length-1].GetFileName();
			     var serialNo = files[files.length-1].GetSerialNo();
			     var row = sheet1.GetSelectRow();
			     
			     var sheet_serial = sheet1.GetCellValue(row, prefix+"file_sav_id");
			     ComUploadRemoveFile(upload1, sheet_serial, false);
							
				sheet1.SetCellValue(row, prefix+"file_set_yn","Y",0);
				sheet1.SetCellValue(row, prefix+"file_sav_id",serialNo,0); //현재 full local url 은 지원되지않음.
				sheet1.SetCellValue(row, prefix+"file_nm",fileName,0);
				sheet1.SetCellFontUnderline(row, prefix+"file_nm",1);
				sheet1.SelectCell(row, prefix+"imdg_pck_instr_cd");
			},
			BeforeAddFile : function(result){
				if(sheet1.GetSelectRow() == -1) return false;
				return true;
			},
			AfterOnload : function() {
		          upload1.SetCustomAddButtonAsID('btn_update');
			}
		});
    }
    
    function sheet1_OnMouseMove(){
    	var row = sheet1.MouseRow(),
        col = sheet1.MouseCol(),
        info = null;
             
        if (row > 0 &&col == 8) {
        	prow = row;
        	info = sheet1.GetCellElement(row, col, 1);
        	upload1.SetFileUploadElement(info);
        } 
    }
    
    //ibupload-page별 변경 영역--s
    function resetUpload(){
    	//sheetObjects[0].RemoveAll();
    	ComUploadRemoveFile(upload1, "", true);
    }
    //ibupload-page별 변경 영역--e

    /**
     * 추가끝
     */
    /**
     * Handling sheet1 OnLoadFinish Event
     * param : sheetObj ==> sheet object
     * 
     */
    function sheet1_OnLoadFinish(sheetObj) {	
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		             var HeadTitle="|Sel.|No.|Seq|FileSetYn|File Sav Id||Packing Instructions\nProvisions|File Name|ID|Date";
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [
		                 {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"file_set_yn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"file_sav_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"imdg_pck_instr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"old_imdg_pck_instr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",   ColMerge:1,   SaveName:prefix+"imdg_pck_instr_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		                 {Type:"PopupEdit", Hidden:0,  Width:450,  Align:"Left",   ColMerge:1,   SaveName:prefix+"file_nm",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
		                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center", ColMerge:1,   SaveName:prefix+"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center", ColMerge:1,   SaveName:prefix+"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetColProperty(0 ,"sheet1_imdg_pck_instr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		             SetShowButtonImage(2);
		             SetSheetHeight(650);
               }
               break;
        }
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH;
				resetUpload();
 				sheetObj.DoSearch("VOP_SCG_0042GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );
				break;
			case IBSAVE:        //save
				if(!validateForm(sheetObj,formObj,sAction)) return true;
				formObj.f_cmd.value=MULTI;
				if (upload1.GetList().length == 0) {
					var sParam=ComGetSaveString(sheetObj);
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
					ComOpenWait(true, true);
 					var sXml=sheetObj.GetSaveData("VOP_SCG_0042GS.do", sParam);
 					if (sXml.length > 0) 
 						sheetObj.LoadSaveData(sXml);
 					ComOpenWait(false);
				} else {
					var sParam=ComGetFileSaveString(sheetObj, upload1, prefix+"file_sav_id");
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
					paramToForm(sParam);
	 				upload1.SaveStatus();
	 				
				}
			break;					
        }
    }
    /**
     * Event after retrieving Sheet
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			SetColFontUnderline(prefix+"file_nm",1);
			SetDataLinkMouse(prefix+"file_nm",1);
		}
	}
    /**
     * Event after saving Sheet
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {						
    	doActionIBSheet(sheetObj, document.form, IBSEARCH);	 	
    }
	/**
	 * Adding files selected to upload to IBSheet by IBUpload <br>
	 * @param {ibsheet}   sheetObj    IBSheet Object
	 * @param {ibupload}  upObj    	  IBUpload Object
	 **/
	function setFileUpload(sheetObj, upObj) {	
		for (var rowIdx=1; rowIdx<=sheetObj.RowCount(); rowIdx++){
			var fileSetYn=sheetObj.GetCellValue(rowIdx, prefix+"file_set_yn");
			if(fileSetYn == 'Y') {
				var sFile=sheetObj.GetCellValue(rowIdx, prefix + "file_sav_id");
				if (sFile=="") ComShowCodeMessage('SCG50004', 'Data');	//'{?msg1} is not available.'
				var ret=upObj.AddFile(sFile);
			}
		}
		return; 
	}
	/**
     * Downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj's selected Row
     * @param {ibsheet} Col     	sheetObj's selected Col
     * @param {String} 	Value     	file name
     **/
	function sheet1_OnDblClick(sheetObj, Row, Col, Value){		
		if (sheetObj.ColSaveName(Col) != prefix+"file_nm")
			return;
		if(sheetObj.GetCellText(Row, prefix+"file_nm") == ""
				|| sheetObj.GetRowStatus(Row) == "I"
				|| sheetObj.GetCellValue(Row, prefix+"file_set_yn") == "Y") {
			selectFile(sheetObj, false);			
			return;
		}
		parent.location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
    	var ibflag;
    	var sVal1;
    	var sVal2;
    	for(var rowIdx1=sheetObj.HeaderRows(); rowIdx1<=sheetObj.LastRow(); rowIdx1++) {
    		ibflag=sheetObj.GetCellValue(rowIdx1,0);
    		sVal1=sheetObj.GetCellValue(rowIdx1, 7);
			if((ibflag == 'U' || ibflag == 'I') && sVal1 != '') {				
	    		for(var rowIdx2=sheetObj.HeaderRows(); rowIdx2<=sheetObj.LastRow(); rowIdx2++) {
	    			ibflag=sheetObj.GetCellValue(rowIdx1,0);
	    			sVal2=sheetObj.GetCellValue(rowIdx2, 7);
					if(rowIdx1 != rowIdx2 && ibflag != 'D' && sVal2 != '') {
		    			if(sVal1 == sVal2) {
		    				ComShowCodeMessage('SCG50005', 'Data');   //'{?msg1} is duplicated.'
		    				sheetObj.SelectCell(rowIdx1,7);
		    				return false;
		    			}
		    		}
				}
			}
    	}
		if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'
        return true;
    }
