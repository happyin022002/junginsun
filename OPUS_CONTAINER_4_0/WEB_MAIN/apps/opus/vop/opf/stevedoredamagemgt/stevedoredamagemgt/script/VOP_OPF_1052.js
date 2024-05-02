/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_1052.js
*@FileTitle  : Supporting Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
    /* Developer performance	*/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var userId="";
    var stvDmgNo="";
    var stvDmgProcCd="";
    var stvDmgAtchFileTpCd="";
    var vslCd="";
    var uploadObjects = new Array();
	var uploadCnt = 0;
	var opener;
	var addFlg = true;
    // Event handler processing by buttbtn_FileAdd
    // Event handler processing by button name */
    document.onclick=processButtonClick;
    function processButtonClick(){
       　
	         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false; 
            switch(srcName) {
				case "btn_FileAdd":
					selectFile(sheetObject1, true);
					break;
				case "btn_Delete":
					deleteRow(sheetObject1);
					break;
				case "btn_Ok":
					returnPopupData(sheetObject1);
					//comPopupOK();
					ComClosePopup(); 
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
    /**
     * delete line chosen
     */
    function deleteRow(sheetObj){
    	var beforeStatus=sheetObj.GetRowStatus(sheetObj.GetSelectRow());
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "deleteFlag","Y");
    	sheetObj.SetRowStatus(sheetObj.GetSelectRow(),beforeStatus);
    	sheetObj.GetRowHidden(sheetObj.SetSelectRow)(1);
    	// resetting Sequence 
		setSequence(sheetObj);
    }
    /**
     * Sequence Update <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     **/
	function setSequence(sheetObj){
    	// resetting Sequence .
		var seq=1;
		var beforeStatus="";
		for(var i=1; i<=sheetObj.LastRow(); i++){
			if(sheetObj.GetCellValue(i, "deleteFlag") != "Y"){
			//if(sheetObj.RowStatus(i)!="D"){
				beforeStatus=sheetObj.GetRowStatus(i);
				sheetObj.SetCellValue(i,"strSeq",seq++,0);
				sheetObj.SetRowStatus(i,beforeStatus);
			}
		}
    }
    /**
     * select file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} addRowFlag  whether add Row or not on sheetObj
     **/
	function selectFile(sheetObj, addFlag){
		addFlg = addFlag;
		upload1.AddFile();
//no support[check again]CLT 		var fileName=sheetObj.OpenFileDialog("Supporting Upload");
//		if(addFlag){
//			var strSeq=1;
//			var fileSeq=1;
//			if(sheetObj.RowCount()> 0){
//				strSeq=parseInt(sheetObj.GetCellValue(sheetObj.RowCount(), "strSeq"))+1;
//				fileSeq=parseInt(sheetObj.GetCellValue(sheetObj.RowCount(), "stv_dmg_atch_file_seq"))+1;
//			}
//			var row=sheetObj.DataInsert(-1);
//			sheetObj.SetCellValue(row, "stv_dmg_no",stvDmgNo,0);
//			sheetObj.SetCellValue(row, "stv_dmg_proc_cd",stvDmgProcCd,0);
//			sheetObj.SetCellValue(row, "stv_dmg_atch_file_tp_cd",stvDmgAtchFileTpCd,0);
//			sheetObj.SetCellValue(row, "vsl_cd",vslCd,0);
//			sheetObj.SetCellValue(row, "strSeq",strSeq,0);
//			sheetObj.SetCellValue(row, "stv_dmg_atch_file_seq",fileSeq,0);
//		}
//		if(fileName.indexOf("\\") !=-1) {
//			with(sheetObj) {
//				SetCellValue(GetSelectRow(), "file_sav_id",fileName,0);//set file path
//				SetCellValue(GetSelectRow(), "file_set_yn","Y",0);//set whether select localfile or not
//				SetCellValue(GetSelectRow(), "cre_usr_id",userId,0);
//				SetCellValue(GetSelectRow(), "cre_dt",ComGetNowInfo("ymd"),0);
//				fileName=fileName.substr(fileName.lastIndexOf("\\")+1);
//				SetCellValue(GetSelectRow(), "file_nm",fileName,0);//set file name
//				GetCellFontUnderline(SetSelectRow, "file_nm")(0);//remove download link
//				}
//		}
//		else{
//			if(addFlag){
//				sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"D");
//			}
//		}
	}
    /**
     * downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Row chosen of sheetObj
     * @param {ibsheet} Col     	Col chosen of sheetObj
     * @param {String} 	Value     	file name
     **/
	function sheet1_OnDblClick(sheetObj,Row,Col,Value){		
		if (sheetObj.ColSaveName(Col) != "file_nm")
			return;
		//if filename doesn't exist or new creationRow or select file newly , show file selecting window
		if(sheetObj.GetCellText(Row, "file_nm") == ""
			|| sheetObj.GetRowStatus(Row) == "I"
				|| sheetObj.GetCellValue(Row, "file_set_yn") == "Y") {
			selectFile(sheetObj, false);			
			return;
		}
		//location.href = "/opuscntr/FileDownload?key="+sheetObj.CellText(Row, "file_sav_id");
		sheetObj.HtmlControlEnterKey("downbtn",sheetObj);
		return;
	}	
	/**
     * event after retreive Sheet 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			SetColFontUnderline("file_nm",1);
			SetDataLinkMouse("file_nm",1);
		}
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(strPageId, strStvDmgNo, strUserId, strStvDmgProcCd, strStvDmgAtchFileTpCd, strVslCd) {
	    //get information of parent window in case fileInfo which is being modified exists on parent window
	    //opener = window.dialogArguments;
    	opener=window.dialogArguments;
    	if (!opener) opener = parent;
		for(i=0;i<sheetObjects.length;i++){
        //change start configuration method name 
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
        //add last configuration method 
			ComEndConfigSheet(sheetObjects[i]);
		}
		initUpload();
		pageId=strPageId;
		userId=strUserId;
		stvDmgNo=strStvDmgNo;
		stvDmgProcCd=strStvDmgProcCd;
	    stvDmgAtchFileTpCd=strStvDmgAtchFileTpCd;
	    vslCd=strVslCd;
	    // Sheet name on parent window
	    var vSheetName;
	    if(strPageId == "OPF0052"){
		    if(strStvDmgAtchFileTpCd == "SDR"){
		    	vSheetName="sheet2_";
		    }else if(strStvDmgAtchFileTpCd == "PIC"){
		    	vSheetName="sheet3_";
	    	}else if(strStvDmgAtchFileTpCd == "DOC"){
		    	vSheetName="sheet4_";
	    	}
	    }else if(strPageId == "OPF1053"){
	    	//get information of parent window in case fileInfo which is being modified exists on parent window
	    	if(strStvDmgProcCd == "D"){
			    if(strStvDmgAtchFileTpCd == "SDR"){
			    	vSheetName="sheet7_";
			    }else if(strStvDmgAtchFileTpCd == "PIC"){
			    	vSheetName="sheet8_";
		    	}else if(strStvDmgAtchFileTpCd == "DOC"){
			    	vSheetName="sheet9_";
		    	}
			    //control File Add, Delete, Ok button by authority
			    if(!opener.officePermission(0)){
		     		ComBtnDisable("btn_FileAdd");
		     		ComBtnDisable("btn_Delete");
		     		ComBtnDisable("btn_Ok");
			    }
	    	}else if(strStvDmgProcCd == "R"){
			    if(strStvDmgAtchFileTpCd == "RES"){
			    	vSheetName="sheet10_";
			    }else if(strStvDmgAtchFileTpCd == "INV"){
			    	vSheetName="sheet11_";
		    	}else if(strStvDmgAtchFileTpCd == "PIC"){
			    	vSheetName="sheet12_";
		    	}else if(strStvDmgAtchFileTpCd == "DOC"){
			    	vSheetName="sheet13_";				    	
		    	}
			    //control File Add, Delete, Ok button by authority
			    if(!opener.officePermission(1)){
		     		ComBtnDisable("btn_FileAdd");
		     		ComBtnDisable("btn_Delete");
		     		ComBtnDisable("btn_Ok");
			    }
	    	}else if(strStvDmgProcCd == "S"){
			    if(strStvDmgAtchFileTpCd == "INV"){
			    	vSheetName="sheet14_";
		    	}else if(strStvDmgAtchFileTpCd == "DOC"){
			    	vSheetName="sheet15_";				    	
		    	}
			    //control File Add, Delete, Ok button by authority
			    if(!opener.officePermission(3)){
		     		ComBtnDisable("btn_FileAdd");
		     		ComBtnDisable("btn_Delete");
		     		ComBtnDisable("btn_Ok");
			    }
	    	}
	    }
	    var sheetObj=sheetObjects[0];
        if(opener != undefined && opener != null) {
        	var oSheetObj = opener.getFileUpload(document.form.stvDmgAtchFileTpCd.value, document.form.stvDmgProcCd.value);
        	if(strPageId == "OPF0052"){
	        	if(oSheetObj != undefined && oSheetObj != null && oSheetObj.RowCount()> 0 && (oSheetObj.FindText(vSheetName+"stv_dmg_no", stvDmgNo) > 0) ){
	        		for(var i=oSheetObj.HeaderRows(); i<=oSheetObj.LastRow(); i++) {
	        			if( oSheetObj.GetCellValue(i, vSheetName+"stv_dmg_no") == stvDmgNo ){
	    					var inx=sheetObj.DataInsert(-1);
	    					for(var cnt=0 ; cnt < 12 ; cnt++){
	    						sheetObj.SetCellValue(inx, cnt,oSheetObj.GetCellValue(i, cnt));
	    					}
	        			}
	        		}
	    			//ColFontUnderline("file_nm") = true;
	    			//DataLinkMouse("file_nm") = true;
	        		for(var rowIdx=sheetObj.HeaderRows(); rowIdx<=sheetObj.LastRow(); rowIdx++) {
	        			if(sheetObj.SetRowStatus(rowIdx) == 'D') sheetObj.GetRowHidden(rowIdx,1);
	        			if(sheetObj.SetRowStatus(rowIdx) == 'I') sheetObj.GetCellFont("FontUnderline", rowIdx,3,0);
	        		}
	        	}
        	}else if(strPageId == "OPF1053"){
	        	if(oSheetObj != undefined && oSheetObj != null && oSheetObj.RowCount()> 0){
	        		var sXml=IBS_GetDataSearchXml(oSheetObj);
	    			sheetObj.LoadSearchData(sXml,{Sync:1} );
	        		for(var rowIdx=sheetObj.HeaderRows(); rowIdx<=sheetObj.LastRow(); rowIdx++) {
	        			if(sheetObj.GetRowStatus(rowIdx) == 'D'){
	        				sheetObj.SetRowHidden(rowIdx,1);
	        			}else if(sheetObj.GetRowStatus(rowIdx) == 'I') {
	        				sheetObj.SetCellFont("FontUnderline", rowIdx, "file_nm",0);
	        			}
	        		}
	        	}
        	}
        }
        // resetting Sequence 
		setSequence(sheetObj);
	}
    
    var pSheetObj, pRow, pCol;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/MNR_INTGS.do'
 			,Files:[]
 			,AfterSaveStatus : function(result) {  
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			sheet1.SetCellValue(pRow, "file_seq" ,  ComGetEtcData(sXml,"seqValue") , 0);
	 				var files = result.files;
	                for( var i = 0; i < files.length; i++) {
	                    files[i].DeleteFromList();
	                }
	      		}else {
					ComShowMessage(result.msg);
				}
 			}
	 		,AfterAddFile:function(result){
	 			var sheetObj = sheet1;
	 			var files = result.files;
	 			var fileName = files[files.length-1].GetFileName();
	 			var serialNo = files[files.length-1].GetSerialNo();
	 			if(addFlg){
	 				var strSeq=1;
	 				var fileSeq=1;
	 				if(sheetObj.RowCount()> 0){
	 					strSeq=parseInt(sheetObj.GetCellValue(sheetObj.RowCount(), "strSeq"))+1;
	 					fileSeq=parseInt(sheetObj.GetCellValue(sheetObj.RowCount(), "stv_dmg_atch_file_seq"))+1;
	 				}
	 				var row=sheetObj.DataInsert(-1);
	 				sheetObj.SetCellValue(row, "stv_dmg_no",stvDmgNo,0);
	 				sheetObj.SetCellValue(row, "stv_dmg_proc_cd",stvDmgProcCd,0);
	 				sheetObj.SetCellValue(row, "stv_dmg_atch_file_tp_cd",stvDmgAtchFileTpCd,0);
	 				sheetObj.SetCellValue(row, "vsl_cd",vslCd,0);
	 				sheetObj.SetCellValue(row, "strSeq",strSeq,0);
	 				sheetObj.SetCellValue(row, "stv_dmg_atch_file_seq",fileSeq,0);
	 			}
	 			
	 			if(fileName) {
	 				with(sheetObj) {
	 					SetCellValue(GetSelectRow(), "file_sav_id",serialNo,0);//set file path
	 					SetCellValue(GetSelectRow(), "file_set_yn","Y",0);//set whether select localfile or not
	 					SetCellValue(GetSelectRow(), "cre_usr_id",userId,0);
	 					SetCellValue(GetSelectRow(), "cre_dt",ComGetNowInfo("ymd"),0);
	 					SetCellValue(GetSelectRow(), "file_nm",fileName,0);//set file name
	 					GetCellFontUnderline(SetSelectRow, "file_nm", 0);//remove download link
	 				}
	 			}
	 			else{
	 				if(addFlag){
	 					sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"D");
	 				}
	 			}
			}
 		});
 	}
    
    function sheet1_OnMouseMove(sheetObj, e) {
	  	  var row     = sheet1.MouseRow(),
	        col     = sheet1.MouseCol(),
	        info    = null;
	        if (row > 0 &&col == sheetObj.SaveNameCol("cre_usr_id")) {
	            /**
	                대상 셀의 DOM Element를 확인 한다.
	                @memberOf   IBSheet
	                @method     GetCellElement
	                @public
	                @param      {number}            Row       대상 행의 Index
	                @param      {number|string}     Col       대상 컬럼의 Index 또는 SaveName
	                @param      {boolean}           Button    해당 셀의 버튼 여부
	                @returns    {object}                      대상의 DOM Element [element, Pos.X, Pos.Y, Width, Height]
	            */
	            info = sheet1.GetCellElement(row, col, 1);
	            
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

	            upload1.SetFileUploadElement(info);
	            
	        } 
	  }
    
    function setUploadObject(uploadObj){
    	uploadObjects[uploadCnt++] = uploadObj;
	}
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
                with (sheetObj) {
                var HeadTitle="|Seq.|stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
                var headCount=ComCountHeadTitle(HeadTitle);
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"strSeq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"stv_dmg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"stv_dmg_atch_file_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:260,  Align:"Center",  ColMerge:1,   SaveName:"file_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"file_sav_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"stv_dmg_proc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stv_dmg_atch_file_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"deleteFlag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(162);
				}
                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	      case IBSEARCH:      //Retrieve
	        formObj.f_cmd.value=SEARCH;
	        sheetObj.DoSearch("VOP_OPF_1052GS.do", FormQueryString(formObj) );
	        break;
	    }
	}
	function doAction(sAction){
		switch(sAction){
			case "down":        //save
				location.href="/opuscntr/FileDownload?key="+sheetObjects[0].GetCellText(sheetObjects[0].GetSelectRow(), "file_sav_id");
				sheetObjects[0].GetSelectRow();
				break;
		}
	}
    /**
     * handling process for input validation
     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//        }
//
//        return true;
//    }
	/* Developer performance  end */
