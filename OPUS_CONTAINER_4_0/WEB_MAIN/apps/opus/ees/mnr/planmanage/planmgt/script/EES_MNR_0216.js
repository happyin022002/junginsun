	/*=========================================================
	*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	*@FileName : EES_MNR_0216.js
	*@FileTitle : M&R Guideline & Information
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2014/05/22
	=========================================================*/
	/****************************************************************************************
	Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
	***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0216 : ees_mnr_0216 - Defining a script used by screen
	 */
   	/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
 	//Saving status for clicked sheet
	var sheetClicks=new Array(0,0,0);
	//Variable for saving status of clicked retrieve button
	var retrieveClick=0;
	// Office level of login user : HO - L1, RHQ - L2, Office - L3 (from CoMnr.js MnrOfficialLevel)
	var strMnrOfficeLevel="";
	var uploadObjects=new Array();
	var uploadCnt=0;
	var chksave=false;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
    	/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					if(chksave==true)doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_RowAdd":
                    doActionIBSheet(sheetObject, formObject, IBINSERT);
                    break;
				case "btn_RowDelete":
                    doActionIBSheet(sheetObject, formObject, IBDELETE);
                    break;
				default:
					break;
             } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
				ComFuncErrMsg(e);
    		} else {
				ComFuncErrMsg(e);
    		}
    	}
     }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		MnrWaitControl(true);
        for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i + 1);
 			ComEndConfigSheet(sheetObjects[i]);
        }
    	//Initializing IBMultiCombo
  	    for(var k=0; k < comboObjects.length; k++){
  	        initCombo(comboObjects[k], k + 1);
  	    }
		var formObj=document.form;
 		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
 		initUpload();
        //ComConfigUpload(uploadObjects[0], "/opuscntr/MNR_INTGS.do");
    }
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
			SaveUrl:'/opuscntr/MNR_INTGS.do',
			ShowButtonArea: false,
			ShowInfoArea: true,
			ExtraForm:'upLoadForm'
  			,Files:[]
 			,AfterSaveStatus : function(result) {  
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			pSheetObj.SetCellValue(pRow, "file_seq" ,  ComGetEtcData(sXml,"seqValue") , 0);
		 			
//	 				var files = result.files;
//	                for( var i = 0; i < files.length; i++) {
//	                    files[i].DeleteFromList();
//	                }
		 			
		 			ComUploadRemoveFile(upload1, "", true);
	      		}else {
	      			
					ComShowMessage(result.msg);
				}
 			}
	 		,AfterAddFile:function(result){
//	 			var files = result.files;
	 			
	 			
	 			var files = upload1.GetList();
 				var fileName=files[files.length-1].GetFileName();
 				pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
 				pSheetObj.SetCellValue(pRow, pCol,fileName,0);
 				pSheetObj.SetCellValue(pRow, 'file_dw','0',0);
 				var file_seq=pSheetObj.GetCellValue(pRow, 'file_seq');
 				var file_dtl_seq=pSheetObj.GetCellValue(pRow, 'file_dtl_seq');
 				if(file_dtl_seq=="") file_dtl_seq="1";
 				var ibflag='U';
 				if(file_seq=="") ibflag='I';
 	 			var sParam="f_cmd="+COMMAND01;
 	 			sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
 	 			sParam+= "&file_seq=" + file_seq;    // Existed file sequence
 	 			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // Existed file sequence
 	 			sParam+= "&org_file_nm=" + fileName; // Fileupload file name
 	 			sParam+= "&ibflag=" + ibflag;        // I : First time file upload, U : modify file
 	 			paramToForm(sParam);
 				upload1.SaveStatus();
			}
 		});
 	}
    function sheet1_OnMouseMove(sheetObj, e) {
	  	  var row     = sheet1.MouseRow(),
	        col     = sheet1.MouseCol(),
	        info    = null;
	        if (row > 0 &&col == 5) {
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
 	/*function initUpload(uploadObj, uploadNo) {
 	   uploadObj.Files="";
 	}*/
    /**
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
  	    switch(comboNo) {
  	    	case 1:
  	            with (comboObj) {
  	    		SetColAlign(0, "left");
  	    		SetColWidth(0, "75");
					SetUseAutoComplete(1);
					SetEnable(1);
	            	SetUseEdit(true);
	            	ValidChar(1,2);
  		        }
  	            break;
  	     }
  	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
    /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                    with(sheetObj){
							
						  var HeadTitle1="|Sel|Seq.|Guideline Type|Guideline Title|File Name|Link|Attach User|Attach Office|Attach Date";
						  var headCount=ComCountHeadTitle(HeadTitle1);

						  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

						  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						  InitHeaders(headers, info);

						  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_check",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",            KeyField:0,   CalcLogic:"",   Format:"" },
								 {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"mnr_grp_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"mnr_gline_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
								 {Type:"Popup",     Hidden:0, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"org_file_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
								 {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"file_dw",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"upd_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"mnr_gline_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"file_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"file_dtl_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"file_path_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
						   
								InitColumns(cols);

								SetEditable(1);
								SetCountPosition(0);
								SetImageList(0,"img/ico_attach.gif");
								SetShowButtonImage(1);
								SetColProperty(0 ,"mnr_gline_nm" , {AcceptKeys:"E|[0123456789]|[~`!@#$%^&*()-_+=:;\"' ]"});
//								SetSheetHeight(342);
								resizeSheet( sheetObj );
						  }


 				break;
         }
     }
	function initControl() {
	}
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
    }
 	/**
 	 * Assigning array of IBCombo object
 	 * @param    {IBCombo}	combo_obj        Registered as an array IBCombo Object
 	 */
    function setComboObject(combo_obj){
  		comboObjects[comboCnt++]=combo_obj;
  	}
	 //Assigning array of IBUpload object
 	function setUploadObject(uploadObj){
 	   uploadObjects[uploadCnt++]=uploadObj;
 	}

	/**
	 * Event handling of click of sheet1 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	Selected row
	 * @param {ibsheet} Col     	Selected column
	 * @param {String} 	Value     	File name
	 **/
	function sheet1_OnClick(sheetObj,Row,Col,Value){
		if (sheetObj.ColSaveName(Col)!="file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, "file_path_nm") == "") return;
		alert(sheetObj.GetCellText(Row, "file_path_nm"));
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "file_path_nm");
		return;
	}
  	/**
     * Sheet related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
           case IBCLEAR:
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
	        	//Initializing combo data
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].RemoveAll();
				}
				//Retrieving combo data
				var sCondition=new Array (
					new Array("MnrGenCd","CD00006", "COMMON")
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault="";
				mnr_grp_tp_cd.InsertItem(0, 'ALL' ,'ALL');
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						mnr_grp_tp_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
						var tempText=comboList[0][j].split("|");
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						if(j ==0){
							sheetComboDefault=tempText[0];
						}
					}
				}
				mnr_grp_tp_cd.SetSelectCode("ALL");
				if (sheetComboText != "")
			        sheetComboText=sheetComboText.substr(0, sheetComboText.length - 1);
				if (sheetComboCode != "")
			        sheetComboCode=sheetComboCode.substr(0, sheetComboCode.length - 1);
				sheetObj.InitDataCombo (0, "mnr_grp_tp_cd", sheetComboText, sheetComboCode,sheetComboDefault);
				//Initializing all sheet
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll();
					sheetClicks[i]=0;
	            }
				//Initializing clicked status of retrieve button
				retrieveClick=0;
				sheetObj.SetWaitImageVisible(1);
				//GET OFFICE LVL
				MnrOfficeLevel(currOfcCd,rhqOfcCd);
				MnrWaitControl(false);
				//SET BTN AUTH
				if(strMnrOfficeLevel=="L1" || strMnrOfficeLevel=="L2"){
					ComBtnEnable("btn_Save");
				} else {
					ComBtnDisable("btn_Save");
				}
        	   break;
           case IBSEARCH:      //Retrieving
				//Initializing all sheet
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll();
					sheetClicks[i]=0;
	            }
				sheetObj.SetWaitImageVisible(1);
	            if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id =="sheet1"){
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("EES_MNR_0216GS.do",FormQueryString(formObj) );
					}
				}
               break;
			case IBINSERT:  // ROWADD
				var Row=sheetObj.DataInsert(-1);
	      		break;
			case IBDELETE:  // ROWDELETE
	        	if(sheetObj.FindCheckedRow("del_check") != ""){
					ComRowHideDelete(sheetObj,"del_check");
				} else {
					ComShowCodeMessage("MNR00150");
				}
				break;
	 		case IBSAVE:        //Saving
  				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("EES_MNR_0216GS.do", FormQueryString(formObj),-1,0);
				}
		 		break;
         }
     }
    /**
     * Validating process for input form data
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
		 	if(sAction==IBSAVE) {
			 	for (var i=1; i<=sheetObjects[0].RowCount(); i++){
					if(sheetObjects[0].GetRowStatus(i)=="D"){
						var ret=ComShowConfirm(ComGetMsg("MNR00216"));
						return ret;
					}
				}
			}
         }
         return true;
     }
     
     function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	 if (errMsg == "" || errMsg == undefined) {
    		 ComShowCodeMessage("MNR00023");
    		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	 }
     }
	/* End of developer's task */
