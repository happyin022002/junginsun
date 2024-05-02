/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TPB_0807.js
*@FileTitle  : Recovery Activity Inquiry / Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
	//var calPop = new calendarPopupGrid();
	var curTab=1;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabObjects=new Array();
	var tabCnt=0 ;
	var isReadOnly="";
	/**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
//  				InsertTab( 0, "TPB No" , -1 );
//  				InsertTab( 1, " Invoice No " , -1 );
  				//TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e.message);
  		}
  		if(document.form.s_n3pty_no.value == ''){
  			tabObjects[0].SetSelectedIndex(1);
  		}
  	}
  	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */
  	function tab1_OnChange(obj,nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	/**
  	 * Showing tab contents in case of clicking IBTab Object
  	 * ID of Grouped each tab DIV TAG defined "tabLayer"
  	 */
  	function ChangeTab(tabObj,nItem){
  		//tabObj.BackColor="#FFFFFF";
  		//tabObj.TabBackColor(nItem)="146,174,230";
  		var objs=document.all.item("tabLayer");
  		objs[beforetab].style.display="none";
  		objs[nItem].style.display="Inline";
  		//--------------- Notice --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//Not a click button in case of zIndex under 2
  		objs[beforetab].style.zIndex=0;
  		objs[nItem].style.zIndex=9;
  		//------------------------------------------------------//
  		beforetab=nItem;
  		curTab=beforetab+1;
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
  		isReadOnly=document.form.s_readonly.value;
  		for(i=0;i<sheetObjects.length;i++){
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
  		var file_no=document.form.s_file_no.value; 
//  		if ( file_no!=null && file_no.length > 0 ) {
//  			getFileNo(file_no);
//  		}
  	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
  	function initSheet(sheetObj,sheetNo) {
  		var cnt=0;
  		switch(sheetNo) {
  		case 1:      //t1sheet1 init
  		    with(sheetObj){  	        
  	      var HeadTitle="Del.|STS|sortNo|TPB No.|Seq.|Remark|Update Date|Updated By|Updated By|Contact Person|Auto\nGenerated|Manual Input|File Attached|file no|n3pty_inv_no|n3pty_clt_rmk_tp_cd|file_count" ;
  	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
  	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
  	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
  	      InitHeaders(headers, info);
  	      var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                      Wrap:1 },
  	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                Wrap:1 },
  	             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"sortNo",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8,     Wrap:1 },
  	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14,     Wrap:1 },
  	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ots_grp_rcvr_act_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8,     Wrap:1 },
  	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"act_rmk",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000,  Wrap:1 },
  	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"locl_cre_dt",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
  	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"clt_act_upd_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6,     Wrap:1 },
  	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20,    Wrap:1 },
  	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100,   Wrap:1 },
  	             {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_no_y",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8,     Wrap:1 },
  	             {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_no_n",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7,     Wrap:1 },
  	             {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"img_file_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:12,     Wrap:1 },
  	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"file_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8,     Wrap:1 },
  	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8,     Wrap:1 },
  	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_clt_rmk_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8,     Wrap:1 },
  	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"file_count",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8,     Wrap:1 } ];
  	       
  	      InitColumns(cols);
  	      SetEditable(1);
  	      
//  	      SetColProperty(0 ,"act_rmk" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
  	      
  	      //SetSheetHeight(400);
  	      ComResizeSheet(sheetObjects[0]);    
  	      SetDataLinkMouse("img_file_no",1);
  	      }
  		    break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab ****/
  		 var sheetObject=sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject=document.form;
  		 //if(curTab == 2)
  		//	formObject = document.form2;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
  				case "btn_add1":
  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_add2":
  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save1":
  					doActionIBSheet(sheetObject,formObject,MULTI01);
  					break;
  				case "btn_save2":
  					doActionIBSheet(sheetObject,formObject,MULTI02);
  					break;
  				case "bttn_preview":
 					sheetObject.ExcelPrint="PreView";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_downexcel":
 					sheetObject.ExcelPrint="";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
 					sheetObject.ExcelPrint="PrintOnly";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_close1":
  					ComClosePopup(); 
  					break;
  				case "btn_close2":
  					ComClosePopup(); 
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('COM12111'));
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg(false);
  		switch(sAction) {
  		   case SEARCH01:	  //Retrieve
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value=SEARCH01;
   				sheetObj.DoSearch("ESD_TPB_0807GS.do", tpbFrmQryStr(formObj) );
  				//retrieveEnd(sheetObj);
  				break;
  			case MULTI01:		//Save
	  			for(var idx=1;idx<=sheetObj.RowCount();idx++){
	  				if (sheetObj.GetCellValue(idx,"ibflag") == "I"
	  					&& sheetObj.GetCellValue(idx,"act_rmk") == " Max. 1,000 charactors allowed as the remark. If more, please attach it with file after 'Confirmation'"){
	  	        		sheetObj.SetCellValue(idx,"act_rmk","",0);
 	  	        		sheetObj.SetCellFontColor(idx,"act_rmk","#000000");
 	  	        		sheetObj.SetCellFont("FontItalic",idx,"act_rmk",0);
	  	        	}
	  	  		}
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				for(var i=1;i<=sheetObj.RowCount();i++){
  					if(sheetObj.GetRowStatus(i) != "R"){
  						if(sheetObj.GetCellValue(i, "n3pty_no_n")=='1'){
  							sheetObj.SetCellValue(i,"n3pty_clt_rmk_tp_cd",'1');
  						}
  					}
  				}				
  				formObj.f_cmd.value=MULTI01;
  				sheetObj.DoSave("ESD_TPB_0807GS.do", tpbFrmQryStr(formObj));
  				break;
  			case MULTI02:		//Save
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				//Setting n3pty_clt_rmk_tp_cd
  				for(var i=1;i<=sheetObj.RowCount();i++){
  					if(sheetObj.GetRowStatus(i) != "R"){
  						if(sheetObj.GetCellValue(i, "n3pty_no_n")=='1'){
  							sheetObj.SetCellValue(i,"n3pty_clt_rmk_tp_cd",'1');
  						}
  					}
  				}
  				formObj.f_cmd.value=MULTI02;
  				sheetObj.DoSave("ESD_TPB_0807GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	  //Insert
  				var Row=sheetObj.DataInsert(-1);
  				sheetObj.SetCellValue(Row,"ots_grp_rcvr_act_seq",ComParseInt(sheetObj.GetCellValue(Row - 1,"ots_grp_rcvr_act_seq")) + 1,0);
  				sheetObj.SetCellValue(Row,"upd_usr_id",formObj.s_user_id.value,0);
  				sheetObj.SetCellValue(Row,"locl_cre_dt",getDateStrAdd(null, "", 0, "-"),0);
  				sheetObj.SetCellValue(Row,"img_file_no","File Attach",0);
  				// sheetObj.CellFontUnderline(Row, "img_file_no") = true;
  				if(curTab-1 == 0){
  					sheetObj.SetCellValue(Row,"n3pty_no",formObj.s_n3pty_no.value);
  					sheetObj.SetCellValue(Row,"clt_act_upd_ofc_cd",formObj.s_if_ofc_cd.value);
  					sheetObj.SetCellValue(Row,"n3pty_no_n",'1');
  				}else if(curTab-1 == 1){
  					sheetObj.SetCellValue(Row,"clt_act_upd_ofc_cd",formObj.s_if_ofc_cd.value);
  					sheetObj.SetCellValue(Row,"n3pty_inv_no_n",'1');
  				}
  				//setting n3pty_clt_rmk_tp_cd
  				if(sheetObj.GetCellValue(Row, "n3pty_no_n")=='1'){
  					sheetObj.SetCellValue(Row,"n3pty_clt_rmk_tp_cd",'1');
  				}
  				//setting n3pty_clt_rmk_tp_cd
  				if(sheetObj.GetCellValue(Row, "n3pty_inv_no_n")=='1'){
  					sheetObj.SetCellValue(Row,"n3pty_clt_rmk_tp_cd",'1');
  				}
  				sheetObj.SetCellValue(Row,"act_rmk"," Max. 1,000 charactors allowed as the remark. If more, please attach it with file after 'Confirmation'",0);
   				sheetObj.SetCellFontColor(Row,"act_rmk","#999999");
   				sheetObj.SetCellFont("FontItalic",Row,"act_rmk",1);
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //Excel download
  				sheetObj.Down2Excel(TPBDown2ExcelOptions);
  				break;
  		}
  	}
  	function retrieveEnd(sheetObj){
  		var cnt=sheetObj.RowCount();
  		var idx;
  		for(idx=1;idx<=cnt;idx++)
  		{
  			if (sheetObj.GetCellValue(idx, 'n3pty_no_y') == 0){
  				sheetObj.SetCellEditable(idx, 0,0);
  			}
  		}
  	}
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			/**
  			 */
  		}
  		return true;
  	}
  	/**
     * handling process after ending sheet1 retrieve
     */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		try{
  			var matchYN=false;
  			var matchStr='';
  			var tmpFileNo='';
  			var n3pty_no=document.form.s_n3pty_no.value; 
  			for ( var i=1; i <= sheetObj.RowCount(); i++ ){
  				if(sheetObj.GetCellValue(i,'n3pty_no_y') == '1'){
  					sheetObj.SetRowEditable(i,0);
  				}
  				if(!matchYN && sheetObj.GetCellValue(i,'n3pty_no') == matchStr){
  					matchYN=true;
  				}
				matchStr=sheetObj.GetCellValue(i,'n3pty_no');
				tmpFileNo=sheetObj.GetCellValue(i, "file_no");
				tmpFileCount=sheetObj.GetCellValue(i, "file_count");
  				if ( tmpFileNo!=null && tmpFileNo.length>0 && tmpFileCount > 0){
   	    			sheetObj.SetCellFontUnderline(i, "img_file_no",1);
  				} 
  			}
  			if(sheetObj.searchRows == 1) matchYN=true;
  			if(sheetObj.SearchRows()> 0 && !matchYN){
  				$('#btn_save1').hide();
  				$('#btn_add1').hide();
//  				document.all.btn_save1.style.display="none";
//  				document.all.btn_add1.style.display="none";
  			}else{
  				$('#btn_save1').show();
  				$('#btn_add1').show();
//  				document.all.btn_save1.style.display="";
//  				document.all.btn_add1.style.display="";
  			}
  			if(document.form.s_n3pty_no.value == ''){
  				$('#btn_save1').hide();
  				$('#btn_add1').hide();
  				//document.all.btn_save1.style.display="none";
  				//document.all.btn_add1.style.display="none";
  			}
  		}catch(e){}
  	}	
  	/**
     * registering IBTab Object as array
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
  	function setTabObject(tab_obj){
  		tabObjects[tabCnt++]=tab_obj;
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		var matchYN=false;
  		var matchStr='';
  		var tmpFileNo='';
  		for ( var i=1; i <= sheetObj.RowCount(); i++ ){
  			if(sheetObj.GetCellValue(i,'n3pty_no_y') == '1'){
  				sheetObj.SetRowEditable(i,0);
  			}
  			if(!matchYN && sheetObj.GetCellValue(i,'n3pty_no') == matchStr){
  				matchYN=true;
  			}
			matchStr=sheetObj.GetCellValue(i,'n3pty_no');
			tmpFileNo=sheetObj.GetCellValue(i, "file_no");
			tmpFileCount=sheetObj.GetCellValue(i, "file_count");
  			if ( tmpFileNo!=null && tmpFileNo.length>0 && tmpFileCount > 0){
       			sheetObj.SetCellFontUnderline(i, "img_file_no",1);
  			} 
  		}
  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(getMsg('COM12149','Data','',''));
  		}
  	}
  	
  	var fileAttchRow="0";
    
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
          if(sheetObj.ColSaveName(Col) == "img_file_no"){ // sheetObj.GetRowEditable(Row) &&
        	  if(sheetObj.GetCellValue(Row, "act_rmk") == "" || sheetObj.GetCellValue(Row, "act_rmk") == " Max. 1,000 charactors allowed as the remark. If more, please attach it with file after 'Confirmation'"){
        		  ComShowMessage(ComGetMsg('TPB90108'));
        		  return false;
        	  }
        	  
              var fileAttachAuthYn="N";
              if ( sheetObj.GetCellValue(Row, "n3pty_no_n")=='1' || sheetObj.GetCellValue(Row, "img_file_no").length>0) { // MANUAL INPUT
  				if ( isReadOnly != "Y" && document.form.s_n3pty_no.value != ""
              			&& ( sheetObj.GetCellValue(Row,"upd_usr_id") == document.form.s_user_id.value ) // same user
              	   ){
              	    fileAttachAuthYn="Y";
  				}
  				fileAttchRow=Row;
  			    openFileUploadPopup(sheetObj.GetCellValue(Row,"file_no"), '', 'Y', fileAttachAuthYn);
//  			    getFileNoSheet(rtnValue);
  			}
  		}
  	}
      
	function getFileNoSheet(fileNoReceive){
      	var currentFileNo = sheetObjects[0].GetCellValue(fileAttchRow, "file_no");
          if ( currentFileNo==undefined || currentFileNo==null || currentFileNo=="" || currentFileNo=="0" ) { // 현재 file no가 유효하지 않았을 경우
      		if ( fileNoReceive!=undefined && fileNoReceive!=null && fileNoReceive!="" && fileNoReceive!="0" ) {
                  sheetObjects[0].SetCellValue(fileAttchRow, "file_no", fileNoReceive);
                  sheetObjects[0].SetCellFontUnderline(i, "img_file_no", true);

                  doActionIBSheet(sheetObjects[0],document.form,MULTI01);
              }
          }
  		// var rowStatus = sheetObjects[0].RowStatus(fileAttchRow);
  		// if ( rowStatus == 'R' ) { // R상태에서 file attach하였을 경우
  		// 	docObjects[0].RowStatus(fileAttchRow) = "U";
  		// }
          

  		
  		
  	}
    	
    	
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
  		var colNm=sheetObj.ColSaveName(NewCol);
  		if( colNm == "act_rmk"){
  			if (sheetObj.GetCellValue(NewRow,"ibflag") == "I"
  				&& sheetObj.GetCellValue(NewRow,"act_rmk") == " Max. 1,000 charactors allowed as the remark. If more, please attach it with file after 'Confirmation'"){
        		sheetObj.SetCellValue(NewRow,"act_rmk","",0);
         		sheetObj.SetCellFontColor(NewRow,"act_rmk","#000000");
         		sheetObj.SetCellFont("FontItalic",NewRow,"act_rmk",0);
        	}
  		}
    }
