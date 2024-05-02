	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0220.js
	 *@FileTitle : Disposal Price File Import_Pop Up
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate :
	 *@LastModifier :
	 *@LastVersion : 1.0
	=========================================================*/
	/****************************************************************************************
	  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
						COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/

	/**
	 * @extends
	 * @class EES_MNR_0220 : EES_MNR_0220 - Defining a script used by screen
	 */
	function EES_MNR_0220() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}

	//Common global variable
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var uTpSz = new Array();
	var gTpSz = new Array();
	var zTpSz = new Array();
	var selTpSz = new Array();

	var verifyCheck = false;

	//Defining event handler of button click */
	document.onclick = processButtonClick;

	//Event handler to diverge process by button name */
	function processButtonClick(){
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {

			case "btn_FileImport":
				var preCnt = sheetObject.RowCount;
				for(var i = 1; i <= sheetObject.RowCount; i++){
					sheetObject.CellValue(i,"del_check") = "1";
				}
				sheetObject.LoadExcel(-1, 1, "", -1, -1, "", true,false,"");

				for(var i = 1; i <= sheetObject.RowCount; i++){
					if(sheetObject.CellValue(i,"del_check") == "1"){
						sheetObject.CellValue(i,"orgIbflag") = "D";
					} else {
						sheetObject.RowStatus(i) = "I";
						sheetObject.CellValue(i,"orgIbflag") = "I";
					}
					sheetObject.CellEditable(i,"checkbox") = false;
				}

				if(preCnt > 0){
					ComRowHideDelete(sheetObject, "del_check");
				}
				break;

			case "btn_new":
				doActionIBSheet(sheetObjects[0],formObject,IBCLEAR)
				break;

			case "btn_ok":
				if(sheetObject.FindCheckedRow("checkbox") == ""){
					ComShowCodeMessage("MNR00038","SELECT ");
				} else if(!verifyCheck){
					ComShowCodeMessage("MNR00157");
				} else {
					comPopupOK_220(sheetObject,formObject);
				}
				break;

			case "btn_Save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;

			case "btn_RowAdd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;

			case "btn_RowDel":
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			case "btn_downExcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				break;
			case "btn_close":
				self.close();
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
	 * Assigning array of IBSheet object
	 * Array defined at the top of the source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}


	 function setPopUpParam_COM_ENS_051(array) {

	 	if(array == null)return;
	 	var formObj = document.form;
	 	var str = array + "";
	 	var arr = str.split(",");

	 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"inp_msg2")=arr[3];
	 }

	 function setPopUpParam_COM_ENS_071(array) {

	 	if(array == null)return;
	 	var formObj = document.form;
	 	var str = array + "";
	 	var arr = str.split(",");

	 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"inp_msg2")=arr[3];
	}

	/**
	 * Sheet default setting and initializing
	 * To implement for onload event of body tag
	 * After loading in your browser should display the ability to add pre-processing
	 */
	function loadPage() {

		var Text=""

			if(window.dialogArguments!=undefined)
			{
				if(window.dialogArguments.document.form.combo_eq_knd_cd!=undefined)
				{
					Text=window.dialogArguments.document.form.combo_eq_knd_cd.Code;
					selTpSz=window.dialogArguments.selTpSz;
				}

			}else{
				initTpszSize();
				if(Text == "U"){
					selTpSz = uTpSz;
				} else if(Text == "G"){
					selTpSz = gTpSz;
				} else {
					selTpSz = zTpSz;
				}
			}

		for(i=0;i<sheetObjects.length;i++){

			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i + 1);

			ComEndConfigSheet(sheetObjects[i]);
		}

		var sheetObj=sheetObjects[0]
  		//comboRetrieving
  		var sCondition = new Array (
  				new Array("MnrGenCd","CD00048", "COMMON") //Disposal Tariff Group Code Sheet Combo
  				,new Array("MdmCurrency",""   ,"COMMON")  //Currecy Code Sheet Combo
  		);

  		var comboList = MnrComSearchCombo(sheetObj,sCondition);
  		//Setting sheet
  		var sheetComboText = "";
  		var sheetComboCode = "";
  		var sheetComboCodeText = "";
  		var sheetComboDefault = "";
  		for(var i = 0; i < comboList.length;i++){
  			//Initializing each combo of sheets
  			sheetComboText = "";
  			sheetComboCode = "";
  			sheetComboCodeText = "";
  			sheetComboDefault = "";
  			if(comboList[i] != null){
  				for(var j = 0; j < comboList[i].length;j++){
  					var tempText = comboList[i][j].split("|");
  					sheetComboText +=  tempText[1] + "|";
  					sheetComboCode +=  tempText[0] + "|";
  					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
  					if(j ==0){
  						sheetComboDefault = tempText[0];
  					}
  				}

  				//Sheet Setting combo
  				if(i == 0) {
  					sheetObjects[0].InitDataCombo(0, "inp_msg1", sheetComboText, sheetComboCode, sheetComboDefault);
  				}else if(i==1){
  					sheetObjects[0].InitDataCombo(0, "inp_msg3", sheetComboCode, sheetComboCode, sheetComboDefault);
  				}
  			}
  		}

  		if(window.dialogArguments != undefined)
  		{
  			SourceSheet=window.dialogArguments.sheetObjects[0];
  			var Row=0;
  			for(var i=SourceSheet.HeaderRows;i<=SourceSheet.LastRow;i++)
  				Row = sheetObj.DataInsert(-1);

  			for(var i=3;i<=SourceSheet.LastCol;i++)
  			{

  				if(i>=6)
  					SourceSheet.Copy2SheetCol(sheetObjects[0],i,i+ 2,1,Row,-1,0,false,false);
  				else
  					SourceSheet.Copy2SheetCol(sheetObjects[0],i,i+ 1,1,Row,-1,0,false,false);
  			}

  			var j=0;
  			for(var i=sheetObjects[0].HeaderRows;i<=sheetObjects[0].LastRow;i++)
  			{
  					if(SourceSheet.CellValue(i,"sheet1_ibflag")=="D")
  					{
  						sheetObjects[0].RowStatus(i)="R";
  						sheetObjects[0].CellValue(i,"del_check")="1";
  						j++;
  					} else {
  						sheetObjects[0].RowStatus(i)=SourceSheet.RowStatus(i);
  					}
  			}

  			if(j > 0)	ComRowHideDelete(sheetObjects[0], "del_check");
  		}

  		MnrWaitControl(false);
	}


	function initTpszSize()
	{
	 	var arrXml = MnrComSearchGrid(sheetObjects[0],"type_size_search_ind","");
		if(arrXml != null)
		{
			for(var i = 0; i < arrXml.length; i++)
			{
				if(i == 0){
					uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){
					zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){
					gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
			}
		}
	}

	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo)
		{
		case 1:
			with (sheetObj)
			{

				// Setting height
				style.height = 210;
				// Setting the overall width
				SheetWidth = mainTable.clientWidth;

				//Setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//All merge option[Default msNone]
				MergeSheet = msHeaderOnly;

				//All Editing option[Default msNone]
				Editable = true;

				//Setting all row[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);

				var HeadTitle1 = "|Sel.|Del.|Seq.|TYPE|Office\nLocation|Currency|System Verify Result";
				if(selTpSz.length > 0)
				{
					for(var i=0;i<selTpSz.length;i++)
					{
						HeadTitle1+="|" + selTpSz[i];
						HeadTitle1+="|" + selTpSz[i]+"_Seq";

					}
				}else{

					HeadTitle1+="|D2|D4|D5|D7|F2|F4|O2|O4|R2"
				}
				HeadTitle1+="|orgIbflag";
				var headCount = ComCountHeadTitle(HeadTitle1);

				//Setting all column[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// Setting various function of sheet header
				InitHeadMode(true, true, true, true, false,false)

				//Sheet header info setting[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//Setting attribute of Data    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "";
				InitDataProperty(0, cnt++ , dtHiddenStatus,		50,   	daCenter,	true,   prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,   		40,    	daCenter,  	false,	"checkbox",     	false,  "", dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtDummyCheck,   	40,    	daCenter,  	false,  "del_check",     	false,  "", dfNone,		0,	true,	true);
				InitDataProperty(0, cnt++ , dtDataSeq,      	40,   	daCenter, 	true,   "Seq");
				InitDataProperty(0, cnt++ , dtCombo,        	50,   	daCenter, 	true,   prefix+"inp_msg1",  false,  "",	dfNone, 	0, 	true,  	true);
				InitDataValid(   0,    cnt,  vtEngUpOther, "0123456789");
				InitDataProperty(0, cnt++ , dtPopupEditFormat,	60,   	daCenter, 	true,   prefix+"inp_msg2",  false,  "", dfEngUpKey,	0, 	true,  	true,	6);
				InitDataProperty(0, cnt++ , dtCombo,        	60,   	daCenter, 	true,   prefix+"inp_msg3",	false,  "", dfNone, 	0, 	true,  	true);
				InitDataProperty(0, cnt++ , dtData,         	130,	daLeft, 	true,   prefix+"inp_msg4",  false,	"", dfNone,		0,	false,	false);

				if(selTpSz.length>0)
				{
					for(var i=0;i<selTpSz.length;i++)
					{
						InitDataProperty(0, cnt++ , dtData,     60,   daRight, true,   prefix+selTpSz[i],         false,  "", dfFloat,	2, true,  true,	13);
						InitDataProperty(0, cnt++ , dtHidden,	60,   daRight, true,   prefix+selTpSz[i]+"_Seq",  false,  "", dfNone,	0, true,  true);

					}
				}else{

					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"D2",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"D4",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"D5",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"D7",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"F2",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"F4",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"O2",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"O4",         false,  "", dfFloat,	2, true,  true,	13);
					InitDataProperty(0, cnt++ , dtData,         60,   daRight, true,   prefix+"R2",         false,  "", dfFloat,	2, true,  true,	13);

				}

				InitDataProperty(0, cnt++ , dtHidden,         60,   daRight, true,   prefix+"orgIbflag",         false,  "", dfNone,	0, true,  true);


				CountPosition = 0;

			}
			break;

		case 2:
			with (sheetObj)
			{

				// Setting height
				style.height = 0;
				// Setting the overall width
				SheetWidth = mainTable.clientWidth;

				//Setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//All merge option[Default msNone]
				MergeSheet = msHeaderOnly;

				//All Editing option[Default msNone]
				Editable = true;

				//Setting all row[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);

				var HeadTitle1 = "|Sel|Del|Seq|TYPE|Office\nLocation|Currency|Verify\nResult";


				var headCount = ComCountHeadTitle(HeadTitle1);

				//Setting all column[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// Setting various function of sheet header
				InitHeadMode(true, true, true, true, false,false)

				//Sheet header info setting[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//Setting attribute of Data    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "";
				InitDataProperty(0, cnt++ , dtHiddenStatus,	50, daCenter,	true,   prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,   	40,	daCenter,  	false,	"checkbox",     	false,  "", dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtDummyCheck,   40, daCenter,  	false,  "del_check",     	false,  "", dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtDataSeq,      40, daCenter, 	true,   "Seq");
				InitDataProperty(0, cnt++ , dtCombo,        50, daCenter, 	true,   prefix+"inp_msg1",	false,  "",	dfNone, 0, 	true,	true);
				InitDataProperty(0, cnt++ , dtData,         60, daCenter, 	true,   prefix+"inp_msg2",  false,  "", dfNone, 0, 	true,  	true);
				InitDataProperty(0, cnt++ , dtData,        	60, daCenter, 	true,   prefix+"inp_msg3",  false,  "", dfNone, 0, 	true,  	true);
				InitDataProperty(0, cnt++ , dtData,         60, daRight, 	true,   prefix+"inp_msg5",  false,  "", dfNone,	0, 	true,  	true);

				CountPosition = 0;

			}
			break;

		}
	}


		function inp_msg1_AND_inp_msg2_UniqueCheck()
		{
			var sInpMsg1="";  //sheet
			var sInpMsg2=""; //sheet
			var chkOk=false;
			sheetObj=sheetObjects[0];
			sheetObj.ColumnSort("inp_msg1|inp_msg2", "ASC");
			for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
			{
				if(sheetObj.RowStatus(i)=="D") continue;
				var checkEqNo=sheetObj.CellValue(i, "inp_msg2"); //sheet
				if(checkEqNo=="") continue;
				sheetObj.CellFont("FontBold", i, "inp_msg2") = false;
				if(chkOk==false)
				{

					sInpMsg1=sheetObj.CellValue(i, "inp_msg1");  //sheet
					sInpMsg2=sheetObj.CellValue(i, "inp_msg2"); //sheet
					chkOk=true;
					continue;
				}else{
					if(sInpMsg1 ==sheetObj.CellValue(i, "inp_msg1")
							&& sInpMsg2 ==sheetObj.CellValue(i, "inp_msg2")
					)
					{
						var sSeq=sheetObj.CellValue(i, "Seq");
						sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq) - 1, "inp_msg1") = true;
						sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq) - 1, "inp_msg2") = true;
						sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq), "inp_msg1") = true;
						sheetObj.CellFont("FontBold", sheetObj.FindText("Seq",sSeq), "inp_msg2") = true;


						ComShowCodeMessage("MNR00006","Type and Office and Location");
						sheetObj.SelectCell(sheetObj.FindText("Seq",sSeq), "inp_msg2",true);


						return false;

					}else
					{
						sInpMsg1=sheetObj.CellValue(i, "inp_msg1");  //sheet
						sInpMsg2=sheetObj.CellValue(i, "inp_msg2"); //sheet
					}

				}
			}
			sheetObj.ColumnSort("Seq", "ASC"); //Initializing sort
			return true;
		}

	//Validating office code
	function sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var retArray =  null;
		 if (sheetObj.ColSaveName(Col) == "inp_msg2"){

			var strGrpCD =ComTrimAll(sheetObj.CellValue(Row, "inp_msg1")," ");
			if(strGrpCD=="")
			{
				ComShowCodeMessage("MNR00036","Type");
				sheetObj.CellValue2(Row ,Col) = "";
				sheetObj.SelectCell(Row, "inp_msg1",	true);
				return;
			}
			sheet1_ofc_loc_cd_Check(sheetObj,Row,Col,strGrpCD);
		}
	}

	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) != "inp_msg2") return;

		var strCostDtlCD =ComTrimAll(sheetObj.CellValue(Row, "inp_msg1")," ");
		if(strCostDtlCD=="")
		{
			ComShowCodeMessage("MNR00036","Type");
			sheetObj.SelectCell(Row, "inp_msg1",	true);
			return;
		}
		if(strCostDtlCD=="CNT")
		{
			document.form.mnr_disp_trf_grp_cd.value=strCostDtlCD;
			ComOpenPopup("COM_ENS_051.do", 810, 450, 'setPopUpParam_COM_ENS_051', '1,0', true);
		}
		else
		{
			document.form.mnr_disp_trf_grp_cd.value=strCostDtlCD;
			ComOpenPopup("COM_ENS_071.do", 810, 450, 'setPopUpParam_COM_ENS_071', '1,0', true);
		}
	}

	function sheet1_ofc_loc_cd_Check(sheetObj,Row,Col,strGrpCD){
		var OfficeMLocCd = sheetObj.CellValue(Row ,Col);
		var retArray=null;
		if(strGrpCD=="RHQ")
		{
			checkOffice=OfficeMLocCd+"\|2";
		    retArray = MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);
		}else if(strGrpCD=="OFC"){
			checkOffice=OfficeMLocCd+"\|none";
		    retArray = MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);
		}else if(strGrpCD=="CNT"){
			checkOffice=OfficeMLocCd;
		    retArray = MnrGeneralCodeCheck(sheetObj,"MLOC",checkOffice);
		}


		if(retArray == null){
			if(strGrpCD=="CNT")
				ComShowCodeMessage("MNR00165",OfficeMLocCd,"LOCATION");
			else
				ComShowCodeMessage("MNR00165",OfficeMLocCd,"OFFICE");
			sheetObj.CellValue2(Row ,Col) = "";
			sheetObj.SelectCell(Row ,Col);
		} else {
			sheetObj.CellFont("FontBold", Row, "inp_msg1",sheetObj.LastRow,"inp_msg1") = false;
			sheetObj.CellFont("FontBold", Row, "inp_msg2",sheetObj.LastRow,"inp_msg2") = false;
			return;
		}
	}

	//Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

		case IBSAVE:        //Saving
			if(!validateForm(sheetObj,formObj,sAction))return;
			formObj.f_cmd.value = MULTI;

			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i,"ibflag") != "D")
				{
					sheetObj.CellValue(i,"orgIbflag") = sheetObj.CellValue(i,"ibflag");
					sheetObj.RowStatus(i) = "I";
				}
			}

			var sParam = sheetObj.GetSaveString(false, true);
			if (sParam == "") return;
			sParam += "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("EES_MNR_0220GS.do", sParam);

			sheetObjects[1].LoadSaveXml(sXml);

			for(var i = 1; i <= sheetObjects[1].RowCount; i++){

				if(sheetObjects[1].CellValue(i,"checkbox") == 1){
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);

					sheetObj.CellEditable(i,"inp_msg1") = false;
					sheetObj.CellEditable(i,"inp_msg2") = false;
					sheetObj.CellEditable(i,"inp_msg3") = false;
					sheetObj.CellValue(i,"checkbox") =sheetObjects[1].CellValue(i,"checkbox");
					sheetObj.CellValue(i,"inp_msg4") =sheetObjects[1].CellValue(i,"inp_msg5");
				} else {
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(ErrorColBackColorR,ErrorColBackColorG,ErrorColBackColorB);
					sheetObj.CellValue(i,"inp_msg4") =sheetObjects[1].CellValue(i,"inp_msg5");

					sheetObj.CellEditable(i,"checkbox") = false;
				}
			}

			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i,"ibflag") != "D")
				{
					sheetObj.RowStatus(i) = sheetObj.CellValue(i,"orgIbflag");
				}
			}
			verifyCheck = true;

			break;

		case IBINSERT:  // ROWADD
			var Row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(Row,"inp_msg1") = "";
			sheetObj.CellValue2(Row,"inp_msg2") = "";
			sheetObj.CellValue2(Row,"inp_msg3") = "";
			sheetObj.CellEditable(Row,"checkbox") = false;
			verifyCheck = false;
			break;

		case IBDELETE:  // ROWDELETE
			ComRowHideDelete(sheetObj, "del_check");
			break;

		case IBCLEAR: //  Initializing all sheet and combo data
			MnrWaitControl(true);

			sheetObj.WaitImageVisible=false;

			//Initializing sheet
			sheetObj.RemoveAll();
			verifyCheck = false;
			sheetObj.WaitImageVisible=true;
			MnrWaitControl(false);
			break;

		case IBDOWNEXCEL:
			var cnt=sheetObj.RowCount;
			if(cnt <= 0){
				var Row = sheetObj.DataInsert(-1);
			}

			//4   /apps/opus/ees/mnr/operationmanage/disposalmgt/xml/EES_MNR_0220_FORMAT.xml
			sheetObj.SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,"1|2|3|7");
			if(cnt <= 0){
				sheetObj.RemoveAll();
			}
			break;
		}
	}

	/**
	 * Calling pop-up
	 */
	function comPopupOK_220(sheetObj,formObject) {
		var formObject = document.form;

		window.dialogArguments.setPopUpParam_EES_MNR_0220(sheetObj);
		window.close();
	}

	 /**
	  * Validating process for input form data
	  */
	 function validateForm(sheetObj,formObj,sAction){
	 		with(formObj){
	  			if(sAction==IBSAVE)
	  			{

	  			  var sTypeText = sheetObj.GetComboInfo(0,"inp_msg1", "Text");
	  			  var arrTypeText = sTypeText.split("|");

	  			  var sCurrencyText = sheetObj.GetComboInfo(0,"inp_msg3", "Text");
	  			  var arrCurrencyText = sCurrencyText.split("|");
	 				for(var i=sheetObjects[0].HeaderRows ;i<=sheetObjects[0].LastRow;i++)
	 				{
	 					var checkData =ComTrimAll(sheetObjects[0].CellText(i, "inp_msg1")," ");
	 					if(checkData=="")
	 					{
	 						ComShowCodeMessage("MNR00036","Type");
	 						sheetObjects[0].SelectCell(i, "inp_msg1",true);
	 						return false;
	 					}

						for(var j=0;j<arrTypeText.length;j++)
	 					{
	 						if(sheetObjects[0].CellText(i,"inp_msg1") == arrTypeText[j])
	 						{
	 							break;
	 						}

	 						if(j==arrTypeText.length - 1)
	 						{
	 							ComShowCodeMessage("MNR00165",sheetObjects[0].CellText(i, "inp_msg1"),"Type");
	 							sheetObjects[0].CellText(i, "inp_msg1")="";
	 							sheetObjects[0].SelectCell(i, "inp_msg1",true);
	 							return false;
	 						}
	 					}

	 					var checkData = ComTrimAll(sheetObjects[0].CellValue(i, "inp_msg2")," ");
	 					if(checkData=="")
	 					{
	 						ComShowCodeMessage("MNR00172","Office,Location");
	 						sheetObjects[0].SelectCell(i, "inp_msg2",true);
	 						return false;
	 					}

	 					var checkData = ComTrimAll(sheetObjects[0].CellText(i, "inp_msg3")," ");
	 					if(checkData=="")
	 					{
	 						ComShowCodeMessage("MNR00036","Currency");
	 						sheetObjects[0].SelectCell(i, "inp_msg3",true);
	 						return false;
	 					}

	 					for(var j=0;j<arrCurrencyText.length;j++)
	 					{
	 						if(sheetObjects[0].CellText(i,"inp_msg3")==arrCurrencyText[j])
	 						{
 								break;
 							}
	 						if(j==arrCurrencyText.length - 1)
	 						{
	 							ComShowCodeMessage("MNR00118");
	 							sheetObjects[0].CellText(i, "inp_msg3")="";
	 							sheetObjects[0].SelectCell(i, "inp_msg3",true);
	 							return false;
	 						}
	 					}
	 				}

					if(!inp_msg1_AND_inp_msg2_UniqueCheck())
					{
						return false;
					}
 	  			}
	 		}

	 	return true;
	 }