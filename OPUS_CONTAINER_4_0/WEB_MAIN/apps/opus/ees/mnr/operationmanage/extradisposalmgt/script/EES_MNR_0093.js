/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0093.jsp
*@FileTitle  : Scrapping/Donation Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_mnr_0093 : business script for ees_mnr_0093.
 */
/* ********* General Functions ************* */
	// common global variables
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// file upload
	//file sequence variable
	var uploadFileSeq="";
    // variable of savingbutton type
	var saveType=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObject1, document.form, IBSEARCH);
						break;
					case "btn_New":
						doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 1);
						break;
					case "btn_Save":
						saveType=1;
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 1);
						break;
					case "btn_Confirm":
						saveType=2;
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 2);
						break;
					case "btn_Cancel":
						saveType=3;
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 3);
						break;
					case "iss_dt_cal":
						var cal=new ComCalendar();
						cal.select(formObject.iss_dt, 'yyyy-MM-dd');
						break;
					case "btn_yard_popup":
						ComOpenPopup('/opuscntr/COM_ENS_061.do', 766, 545, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
						break;
					case "btn_FileAdd":
						file_Insert(sheetObjects[1]);
						break;
					case "btn_FileDel":
						file_Remove(sheetObjects[1]);
						break;
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	// setting button
    	MnrWaitControl(true);
    	// initializing IBMultiCombo
    	for ( var k=0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	// initializing IBSheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		// initializing Axon event
		initControl();
		//Initializing file upload
		initUpload();
		// initializing form
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }
    
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/MNR_INTGS.do'
 			,Files:[
 			]
	 		,BeforeAddFile : function(result){ 
	 			return true;
			}
			,BeforeSaveStatus : function(result){ 
		 		return true;
			}
	 		,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	 				uploadFileSeq=ComGetEtcData(sXml,"seqValue");
	 				if(uploadFileSeq != "" && uploadFileSeq != undefined){
	 					var fileXml=SearchFileUpload(sheetObjects[1],uploadFileSeq);
	 					sheetObjects[1].LoadSearchData(fileXml,{Sync:1} );
	 				}
	      		}else {
					ComShowMessage(result.msg);
				}
			}
	 		,AfterAddFile:function(result){
	 			var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();

	 			pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
				pSheetObj.SetCellValue(pRow, pCol,fileName,0);
				pSheetObj.SetCellValue(pRow,  "file_dw",'0',0);
				var file_seq=pSheetObj.GetCellValue(pRow,  "file_seq");
				var file_dtl_seq=pSheetObj.GetCellValue(pRow,  "file_dtl_seq");
				if(file_dtl_seq=="") file_dtl_seq=pRow;
				var ibflag='U';
				if(file_seq=="" || uploadFileSeq!="") ibflag='I'; // saving initially, in case of not existing saved file
				if(file_seq!="" && uploadFileSeq!="") ibflag='U';
				if(uploadFileSeq != "") {
					file_seq=uploadFileSeq;
				}
		 		var sParam="f_cmd="+COMMAND01;
		 		sParam+= "&mnr_grp_tp_cd=SCR";       // MNR Work Group Type Code
		 		sParam+= "&file_seq=" + file_seq;    // existing File Sequence
		 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // existing File Sequence
		 		sParam+= "&org_file_nm=" + fileName; // Fileupload file name
		 		sParam+= "&ibflag=" + ibflag;        // I : initial File Upload U : File change
		 		
		 		paramToForm(sParam);
			 	upload1.SaveStatus();
			}
 		});
 	}
    
    /**
	 * handling event when MouseMove Sheet1
	 */
	function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	  	  var row     = sheetObj.MouseRow(),
	        col     = sheetObj.MouseCol(),
	        info    = null;
	  	  var saveName = sheetObj.ColSaveName(col);
	      if (row > 0 && saveName=="org_file_nm") {
	            info = sheetObj.GetCellElement(row, col, 1);
	            
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

	            upload1.SetFileUploadElement(info);
	  	  }
	      
	}
	
  	/**
     * IBsetting combo basic info
     * @param	{IBCombo}	comboObj	initializing ComboObject
     * @param	{Number}	comboNo		ComboObject tag serial number
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1:
	    	case 2:
	    	case 3:
	            with (comboObj) {
	    		SetColAlign(0, "left");
					   SetDropHeight(160);
			        }
	    	case 4:
	    	case 5:
	            with (comboObj) {
	    		SetColAlign(0, "left");
				    SetDropHeight(160);
				    SetColWidth(0, "75");
					SetUseAutoComplete(1);
					SetUseEdit(1);
		        }
	            break;
	     }
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
                with(sheetObj){
              
            var HeadTitle1="|||||||||||||||||";
            var headCount=ComCountHeadTitle(HeadTitle1);
            (headCount, 0, 0, true);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xtra_disp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xtra_disp_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"iss_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mnr_xtra_disp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"iss_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xtra_disp_incm_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xtra_disp_expn_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xtra_disp_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xtra_disp_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"file_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
             
            InitColumns(cols);
            SetVisible(false);
            SetEditable(1);
            SetRowHidden(0, 1);
                        }


			    break;
            case "sheet2":
                with(sheetObj){
                var prefix="";
       
             var HeadTitle1="|Evidence Attached|Evidence Attached|Evidence Attached";
             var HeadTitle2="|Sel|File|Download";
             var headCount=ComCountHeadTitle(HeadTitle1);

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                       { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
                 {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
                 {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);
             SetSheetHeight(150);
             SetEditable(1);
             SetImageList(0,"img/ico_attach.gif");
             SetShowButtonImage(1);
             }
			    break;
        }
    }
    /**
	 * initializing  HTML Control event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	
	    //axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	
	   // axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
    }
	
    /**
     * registering IBCombo Object as list
     *
     * @param {IBCombo}
     *            combo_obj IBCombo Object as list
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj;
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
     * checking on HTML Control's onblur event. <br>
     **/
    function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}
	/**
     * checking on HTML Control's focus event. <br>
     **/
    function obj_focus(){
    	ComClearSeparator(ComGetEvent());
    }
	/**
	 * checking on HTML Control's onkeypress event. <br>
	 **/
	/*function obj_keypress(){
		obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "engup":
	          	ComKeyOnlyAlphabet("uppernum");
	            break;
			case "float":
				ComKeyOnlyNumber(ComGetEvent(), ".");
	        	break;
	    }
	}*/
	/**
	 * checking validaion onChange event on HTML Contorl. <br>
	 **/
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "eq_no":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
				case "iss_yd_cd":
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "eq_no":
					setEqInfoClear();
				   	break;
			}
		}
	}
	/**
	 * setting result after retrieving
	 *
	 * @param {IBSheet}sheetObj sheetObject of retrieving event
	 * @param {String}ErrMsg errorMessage
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount()< 1) {return;}
		var formObj=document.form;
		var xtraDispStsCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "xtra_disp_sts_cd");		//EQ Status
		var issOfcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "iss_ofc_cd");			//Request Office
		var creUsrId=sheetObj.GetCellValue(sheetObj.HeaderRows(), "cre_usr_id");			//Creation User
		var mnrXtraDispTpCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "mnr_xtra_disp_tp_cd");	//Type
		var issDt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "iss_dt");				//Issue Date
		var issYdCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "iss_yd_cd");				//Issue Yard
		var currCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "curr_cd");				//Currency
		var xtraDispIncmAmt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "xtra_disp_incm_amt");	//Income Total
		var xtraDispExpnAmt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "xtra_disp_expn_amt");	//Expense Total
		var xtraDispDesc=sheetObj.GetCellValue(sheetObj.HeaderRows(), "xtra_disp_desc");		//Information
		var xtraDispRmk=sheetObj.GetCellValue(sheetObj.HeaderRows(), "xtra_disp_rmk");			//Remark
		var fileSeq=sheetObj.GetCellValue(sheetObj.HeaderRows(), "file_seq");				//File Seq
		var ofcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ofc_cd");				//Creation Office
		xtra_disp_sts_cd.SetSelectCode(xtraDispStsCd);//EQ Status
		iss_ofc_cd.SetSelectText(issOfcCd);//Request Office
		formObj.cre_usr_id.value=creUsrId;			//Creation User
		mnr_xtra_disp_tp_cd.SetSelectCode(mnrXtraDispTpCd);//Type
		formObj.iss_dt.value=issDt;			//Issue Date
		formObj.iss_yd_cd.value=issYdCd;			//Issue Yard
		curr_cd.SetSelectText(currCd);//Currency
		formObj.xtra_disp_incm_amt.value=xtraDispIncmAmt;	//Income Total
		formObj.xtra_disp_expn_amt.value=xtraDispExpnAmt;	//Expense Total
		formObj.xtra_disp_desc.value=xtraDispDesc;		//Information
		formObj.xtra_disp_rmk.value=xtraDispRmk;		//Remark
		formObj.ofc_cd.value=ofcCd;			//Creation Office
		//retrieving file list
		if(fileSeq != "" && fileSeq != null){
			var fileXml=SearchFileUpload(sheetObjects[1],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[1].LoadSearchData(fileXml,{Sync:1} );
			}
		}
		formObj.xtra_disp_incm_amt.focus();
		formObj.xtra_disp_expn_amt.focus();
		mnr_xtra_disp_tp_cd.Focus();
		eq_knd_cd.SetEnable(0);
		formObj.eq_no.readOnly=true;
		formObj.eq_no.className="input2";
		setButtonEnDisable();
	}
	/**
	 * showing message after saving
	 *
	 * @param {IBSheet}sheetObj sheetObject of Saving event
	 * @param {String}ErrMsg errorMessage
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			//save
			if(saveType == 1) {
				ComShowCodeMessage("MNR00023");
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//confirm
			} else if (saveType == 2) {
				ComShowCodeMessage("MNR00313");
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//Cancel
			} else if(saveType == 3) {
				ComShowCodeMessage("MNR00104", "Data");
				doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 1);
			} else {
				ComShowCodeMessage("MNR00023");
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
		} else {
			//replaced by server error message.
			//ComShowCodeMessage("MNR00008", ErrMsg);
		}
		saveType=0;
	}
    /**
     * handling process sheet
     *
     * @param {IBSheet}sheetObj handling sheetObject
     * @param {Form}formObj handling formObject
     * @param {Number}sAction Action constants 
     */
    function doActionIBSheet(sheetObj,formObj,sAction, sActionIdx) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// initializing
	    	case IBCLEAR:
	    		// settng button and progressing bar
	    		sheetObj.SetWaitImageVisible(0);
	    		MnrWaitControl(true);
	    		//initializing sheet all
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		// Only Loading
	    		if (sActionIdx == 0) {
	    			// initializing Combo Data
	    			for ( var i=0; i < comboObjects.length; i++) {
	    				comboObjects[i].RemoveAll();
	    			}
					//retrieving combo data(Type)
					var sCondition=new Array (
						new Array("MnrGenCd","","CUSTOM9"),		//EQ Type
						new Array("MnrGenCd","CD00033", "COMMON"), 		//EQ Status
						new Array("MnrGenCd","CD00032", "COMMON"), 		//Type
						new Array("MdmCurrency","", "COMMON"),			//Currency
						new Array("MdmOrganization","SEARCH","NOTHQ")	//Request Office
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//setting combo data
					for(var i=0; i<comboList.length ; i++){
						//comboObjects[i].RemoveAll();
						if(comboList[i] != null){
							comboOfficeList=comboList[4]; //Validation check
							//[CODE_NAME]:EQ Type,EQ Status,Type
							if(i == 0 || i == 1 || i == 2) {
								for(var j=0; j < comboList[i].length;j++){
									var tempText=comboList[i][j].split("|");
									if(i==0) {//EQ Type
										eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
									} else if(i==1) {//EQ Status
										xtra_disp_sts_cd.InsertItem(j, tempText[1] ,tempText[0]);
									} else if(i==2) {//Type
									mnr_xtra_disp_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
									}
								}
							//[CODE]:Currency, Request Office
							} else if(i == 3 || i == 4){
								for(var j=0; j < comboList[i].length;j++){
									if(i == 3) {
									curr_cd.InsertItem(j, comboList[i][j] ,j);
									} else if (i == 4) {
										iss_ofc_cd.InsertItem(j, comboList[i][j] ,j);
									}
								}
							}
						}
					}
					xtra_disp_sts_cd.InsertItem(0, "New" ,"N" );
	    		}
	    		//setting initial value
	    		eq_knd_cd.SetSelectCode("U");//EQ Type
	    		eq_knd_cd.SetEnable(1);//EQ Type
	    		formObj.eq_no.value=""; 	  				//EQ No
	    		formObj.eq_no.readOnly=false;				//EQ No
	    		formObj.eq_no.className="input1";				//EQ No
	    		xtra_disp_sts_cd.SetSelectCode("N");//EQ Status
	    		xtra_disp_sts_cd.SetEnable(0);//EQ Status
	    		iss_ofc_cd.SetSelectText(currOfcCd);//Creation Office
	    		formObj.cre_usr_id.value=usrId;				//Creation User
	    		mnr_xtra_disp_tp_cd.SetSelectCode("SCR");//Type
	    		formObj.iss_dt.value=ComGetNowInfo("ymd");	//Issue Date
	    		formObj.iss_yd_cd.value="";					//Issue Yard
	    		curr_cd.SetSelectText("USD");//Currency
	    		formObj.xtra_disp_incm_amt.value="0.00";				//Income Total
	    		formObj.xtra_disp_expn_amt.value="0.00";				//Expense Total
	    		formObj.xtra_disp_desc.value="";					//Information
	    		formObj.xtra_disp_rmk.value="";					//Remark
	    		formObj.eq_tpsz_cd.value="";					//TP/SZ
	    		//eq_knd_cd.focus();
	    		uploadFileSeq="";
	    		// settng button and progressing bar end
	    		MnrWaitControl(false);
	    		sheetObj.SetWaitImageVisible(1);
	    		break;
          	//retrieving
          	case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("EES_MNR_0093GS.do",FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
                break;
            //saving
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction,sActionIdx)) {
					var xtraDispStsCd=xtra_disp_sts_cd.GetSelectCode(); 							//Status
					var eqKndCd=eq_knd_cd.GetSelectCode();									//EQ Type
					var eqNo=formObj.eq_no.value;										//EQ No
					var issOfcCd=iss_ofc_cd.GetSelectText();									//Request Office
					var creUsrId=formObj.cre_usr_id.value;									//Creation User
					var mnrXtraDispTpCd=mnr_xtra_disp_tp_cd.GetSelectCode();							//Type
					var issDt=formObj.iss_dt.value;										//Issue Date
					var issYdCd=formObj.iss_yd_cd.value;									//Issue Yard
					var currCd=curr_cd.GetSelectText();										//Currency
					var xtraDispIncmAmt=ComGetUnMaskedValue(formObj.xtra_disp_incm_amt, "float");	//Income Total
					var xtraDispExpnAmt=ComGetUnMaskedValue(formObj.xtra_disp_expn_amt, "float");	//Expense Total
					var xtraDispDesc=formObj.xtra_disp_desc.value;								//Information
					var xtraDispRmk=formObj.xtra_disp_rmk.value;								//Remark
					var fileSeq=uploadFileSeq;											//File Seq
					var eqTpszCd=formObj.eq_tpsz_cd.value;									//TP/SZ
					//EQ Status : New
					if(xtraDispStsCd == "N") {
						sheetObjects[0].DataInsert(-1);
						//Button:Save
						if(sActionIdx == 1) {
							sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_sts_cd","HS");
						//Button:Confirm
						} else if(sActionIdx == 2) {
							sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_sts_cd","HA");
						}
						sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"eq_knd_cd",eqKndCd);//EQ Type
						sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"eq_no",eqNo);//EQ No
						sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"iss_ofc_cd",issOfcCd);//Creation Office
						sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"cre_usr_id",creUsrId);//Creation User
					//EQ Status : Save
					} else if(xtraDispStsCd == "HS"){
						//Button:Confirm
						if(sActionIdx == 2) {
							sheetObjects[0].SetRowStatus(sheetObjects[0].HeaderRows(),"U");
							sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_sts_cd","HA");
						//Button:Cancel
						} else if (sActionIdx == 3) {
							sheetObjects[0].SetRowStatus(sheetObjects[0].HeaderRows(),"D");
							sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_sts_cd","HD");
						}
					//EQ Status : Confirm
					} else if (xtraDispStsCd == "HA") {
						//Button:Cancel
						if(sActionIdx == 3) {
							sheetObjects[0].SetRowStatus(sheetObjects[0].HeaderRows(),"D");
							sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_sts_cd","HC");
						}
					}
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"mnr_xtra_disp_tp_cd",mnrXtraDispTpCd);//Type
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"iss_dt",issDt);//Issue Date
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"iss_yd_cd",issYdCd);//Issue Yard
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"curr_cd",currCd);//Currency
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_incm_amt",xtraDispIncmAmt);//Income Total
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_expn_amt",xtraDispExpnAmt);//Expense Total
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_desc",xtraDispDesc);//Information
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"xtra_disp_rmk",xtraDispRmk);//Information
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"file_seq",fileSeq);//File Seq
					sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(),"eq_tpsz_cd",eqTpszCd);//TP/SZ
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObjects);
					if (sParam == "") {return;}
					sParam += "&" + FormQueryString(formObj);
					var sXml=sheetObjects[0].GetSaveData("EES_MNR_0093GS.do", sParam);
					sheetObjects[0].LoadSaveData(sXml);
				 }
                 break;
            //retrieving check(EQ No)
			case IBSEARCH_ASYNC01:
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var eqNo=formObj.eq_no.value;
					var eqKndCd=eq_knd_cd.GetSelectCode();
					var totalLossDate=ComGetNowInfo("ymd");
					var retArray=MnrGeneralCodeCheck(sheetObj,"ESTEQN",eqNo + "," + eqKndCd);
					if(retArray == null){
						ComShowCodeMessage("MNR00165",eqNo,"EQ No.");
						ComSetObjValue(formObj.eq_no, "");
						ComSetFocus(formObj.eq_no);
						setEqInfoClear();
						return;
					}
					//retrieving and setting EQ No reference
					setEqInfo(sheetObj,eqKndCd,eqNo,totalLossDate);
					//retrieving
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				}
				break;
			//retrieving check(Issue Yard)
			case IBSEARCH_ASYNC02:
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var issYdCdObj=formObj.iss_yd_cd;
					var issYdCd=issYdCdObj.value;
					var retArray=MnrGeneralCodeCheck(sheetObj,"YARD",issYdCd);
					if(retArray == null){
						ComShowCodeMessage("MNR00165",issYdCd,"YARD");
						ComSetObjValue(issYdCdObj, "");
						ComSetFocus(issYdCdObj);
					}
				}
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction, sActionIdx){

    		//checking when retrieving
		if (sAction == IBSEARCH) {
			// Dataformat
			if (!ComChkValid(formObj)) {
				return false;
			}
		}
		//checking when saving
		else if (sAction == IBSAVE) {
			// Dataformat
			if (!ComChkValid(formObj)) {return false;}
			var xtraDispStsCd=xtra_disp_sts_cd.GetSelectCode();
			// Button : Save
			if(sActionIdx == 1) {
				//saving mandatory
				if(!checkMandatory(mnr_xtra_disp_tp_cd)) {return false};
				if(!checkMandatory(formObj.iss_dt))  {return false};
				if(!checkMandatory(iss_ofc_cd))  {return false};
				if(!checkMandatory(formObj.iss_yd_cd))  {return false};
				if(!checkMandatory(curr_cd))  {return false};
    			// Status : New
				if(xtraDispStsCd == "N") {
					//checking duplicate retrieve
					if(!checkDuplication(sheetObj, formObj)) {return false;}
				// Status : Confirm
				} else if(xtraDispStsCd == "HA") {
					//This extra disposal was already confirmed.
    				ComShowCodeMessage("MNR00107");
    				return false;
				}
			// Button : Confirm
			} else if(sActionIdx == 2) {
				//saving mandatory
				if(!checkMandatory(mnr_xtra_disp_tp_cd)) {return false};
				if(!checkMandatory(formObj.iss_dt))  {return false};
				if(!checkMandatory(iss_ofc_cd))  {return false};
				if(!checkMandatory(formObj.iss_yd_cd))  {return false};
				if(!checkMandatory(formObj.iss_dt))  {return false};
				// Status : New
				if(xtraDispStsCd == "N") {
					//checking duplicate retrieve
					if(!checkDuplication(sheetObj, formObj)) {return false;}
				// Status : Confirm
				} else if(xtraDispStsCd == "HA"){
					//This extra disposal was already confirmed.
    				ComShowCodeMessage("MNR00107");
    				return false;
    			}
				// checking whether confirm
				if(!ComShowCodeConfirm("MNR00197")) {return false;}
			// Button : Cancel
			} else if (sActionIdx == 3) {
				// Status : New
				if(xtraDispStsCd == "N"){
					// Please retrieve (value) first
					ComShowCodeMessage("MNR00199");
    				return false;
    			}
				// checking whether Cancel
				if(!ComShowCodeConfirm("MNR00244")) {return false;}
			}
		}
		// checking EQ No Validation
		else if (sAction == IBSEARCH_ASYNC01) {
			// checking EQ_TYPE whether select
			var eqKndCd=eq_knd_cd.GetSelectCode();
			if(eqKndCd == ""){
				ComShowCodeMessage("MNR00119");
				ComSetObjValue(formObj.eq_no, "");
				eq_knd_cd.Focus();
				return;
			}
		}

        return true;
    }
    /* ********* User Functions ************* */
    /**
     * checking mandatory when saving
     * @param	{Element}	obj	checking Form Element
     */
	function checkMandatory(obj) {
		var objValue=ComGetObjValue(obj);
		if(ComIsEmpty(objValue)) {
		    ComShowCodeMessage("MNR00003");
		    obj.focus();
		    return false;
		}
		return true;
	}
    /**
     * checking duplicate
     * @param  {IBSheet} sheetObj handling sheetObject
     * @param  {Form} formObj handling formObject
     * @return {Boolean} true/false
     */
	function checkDuplication(sheetObj, formObj) {
		formObj.f_cmd.value=SEARCH01;
		var sXml=sheetObj.GetSearchData("EES_MNR_0093GS.do",FormQueryString(formObj));
		var strCnt=ComGetEtcData(sXml, "cnt");
		var intCnt=ComParseInt(strCnt);
		if(intCnt > 0) {
			ComShowCodeMessage("MNR00236");
			return false;
		}
		return true;
	}
	 /**
     * adding file upload Row of IBSheet. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Insert(sheetObj){
		uploadFileSeq=sheetObj.GetCellValue(2,"file_seq");
		if(uploadFileSeq == undefined || uploadFileSeq == -1){
			uploadFileSeq="";
		}
		for(var j=2; j <= sheetObj.LastRow();j++){
			if (sheetObj.GetCellValue(j,"org_file_nm") == ""){
				ComShowMessage(ComGetMsg('MNR00024'));
				sheetObj.SelectCell(j,"org_file_nm");
				return;
			}
		}
		var row=sheetObj.DataInsert(-1);
	}
	 /**
     * deleting file upload Row of IBSheet. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Remove(sheetObj) {
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}
	
	/**
     * downloading file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Col     	selected Row of sheetObj
     * @param {ibsheet} Col     	selected Col of sheetObj
     * @param {String} 	Value     	file name
     **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	/**
     * setting button whether disable <br>
     **/
	function setButtonEnDisable() {
		var xtraDispStsCd=xtra_disp_sts_cd.GetSelectCode(); //EQ Status
		//EQ Status : Confirm
		if(xtraDispStsCd == "HA") {
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_FileAdd");
			ComBtnDisable("btn_FileDel");
		} else {
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
			ComBtnEnable("btn_FileAdd");
			ComBtnEnable("btn_FileDel");
		}
	}
	/**
     * setting Issue Yard <br>
     **/
	function setEqInfo(sheetObj,sEqType,sEqNo,sTotalLossDate){
		var formObj=document.form;
		var sCostType="";
		if(sEqType == "U"){
			sCostType="MRDRRC";
		} else if(sEqType == "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr == null){
			ComShowCodeMessage("MNR00165",sEqNo,"EQ No.");
			ComSetObjValue(formObj.eq_no,"");
			ComSetObjValue(formObj.iss_yd_cd,"");
			ComSetObjValue(formObj.eq_tpsz_cd,"");
			return;
		}
		if(sEqType == "U") {
			var lstmCd=retArr[0][19];
			if(lstmCd != "OW") {
				//only Own equipment is possible Scrap/Donation
				ComShowCodeMessage("MNR00285");
				ComSetObjValue(formObj.eq_no,"");
				ComSetObjValue(formObj.iss_yd_cd,"");
				ComSetObjValue(formObj.eq_tpsz_cd,"");
				ComSetFocus(formObj.eq_no);
				return;
			}
		}
		ComSetObjValue(formObj.iss_yd_cd,retArr[0][18]);   //current Yard
		ComSetObjValue(formObj.eq_tpsz_cd,retArr[0][31]);  //TpSz
	}
	/**
     * initializing Issue Yard <br>
     **/
	function setEqInfoClear(){
		var formObj=document.form;
		ComSetObjValue(formObj.iss_yd_cd,"");
		ComSetObjValue(formObj.eq_tpsz_cd,"");
	}
	/**
	 * COM_ENS_061 receiving function values ​​from Pop-up
	 */
	function getCOM_ENS_061(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "")
    	 	formObj.iss_yd_cd.value=aryPopupData[0][3];
    }
