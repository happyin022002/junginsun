/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0418.js
*@FileTitle  : Multi-B/L Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	var sheetObjects=new Array();
	var sheetCnt=0;

	var IBPRINT="IBPRINT";
	var IBNEWBTN="IBNEWBTN";

	// Event handler processing by button click event  */
	document.onclick=processButtonClick;

	// Event handler processing by button name */
	function processButtonClick(){
		 var sheetObj = sheetObjects[0];
		 var formObj = document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Print": // Print
					doActionIBSheet(sheetObj, formObj, IBPRINT);
					break;
				case "btn_New": // New
					doActionIBSheet(sheetObj, formObj, IBNEWBTN);
					break;
			} // end switch
		} catch(e) {
			if (e == "[object Error]") {
				//ComShowMessage(OBJECT_ERROR);
				alert(e.discription);
			} else {
				ComShowMessage(e);
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
	 * adding first-served functions after loading screen
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//ComEndConfigSheet(sheetObjects[i]);
		}
		init_Control();
		doActionIBSheet(sheetObjects[0], document.form, IBNEWBTN);
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
					//no support[check again]CLT 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					var HeadTitle1="||B/L No. or BKG No.";
					var headCount=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",    Hidden:1,  Width:80,   Align:"Left",    SaveName:"ibflag" },
								{Type:"CheckBox",  Hidden:1,  Width:40,   Align:"Center",  SaveName:"check"  },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    SaveName:"bkg_no",    Edit:1,    EditLen:13,    AcceptKeys:"E|N",   InputCaseSensitive:1 } ];

					InitColumns(cols);
					SetEditable(1);
					SetCountPosition(0);
					SetSheetHeight(340);
				}
				break;
		}
	}


	function init_Control() {
		//axon_event.addListenerForm  ('blur', 'obj_blur',  form);
		//axon_event.addListenerFormat('focus',   'obj_focus',    form);
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);
		//axon_event.addListenerForm('keydown',         'obj_keydown', 	form);
	}


	function obj_keypress(){
		obj=event.srcElement;
		if(obj.dataformat == null) return;
		window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
			case "ym":
			case "hms":
			case "hm":
			case "jumin":
			case "saupja":
				break;
			case "int":
				ComKeyOnlyNumber(obj);
				break;
			case "float":
				ComKeyOnlyNumber(obj, ".");
				break;
			case "eng":
				ComKeyOnlyAlphabet();
				break;
			case "engup":
				var KeyCodes="32";
				ComKeyOnlyAlphabet('uppernum', KeyCodes)
				break;
			case "engdn":
				ComKeyOnlyAlphabet('lower');
				break;
		}
	}


	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBPRINT:
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
					//parameter changed[check again]CLT
					var sXml = sheetObj.GetSaveData("ESM_BKG_0418GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString());
					if(sXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(sXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(sXml));
					} else {
						var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
						if ( State == "S" ) {
							var rVesselSkd = "";
							var rVvd = "";
							var rBkgBlNo = "";
							var rBkgNos = "";
							var error_index = 0;
							rVesselSkd = ComGetEtcData(sXml,"bVesselSkd");
							rVvd = ComGetEtcData(sXml,"bVvd");
							rBkgBlNo = ComGetEtcData(sXml,"bBkgBlNo");
							rBkgNos = ComGetEtcData(sXml,"bkgNos");
							if (rVesselSkd != "") {
								ComShowCodeMessage(rVesselSkd);
							} else if (rVvd != "") {
								ComShowCodeMessage(rVvd);
							} else if (rBkgBlNo != "") {
								ComShowCodeMessage(rBkgBlNo);
								// Error idx
								if (rBkgNos.split("_").length == 2) {
									error_index=rBkgNos.split("_")[1];
									sheetObj.SelectCell(eval(error_index) + 1, "bkg_no");
								}
							} else {
								var param="?mode_type="+ComGetObjValue(formObj.mode)
									   +"&vvd_cd="+ComGetObjValue(formObj.vvd_cd)
									   +("I"==ComGetObjValue(formObj.mode) ? "&pol_cd=&pod_cd=" : "&pod_cd=&pol_cd=")+ComGetObjValue(formObj.port_cd);
								ComOpenPopup("/opuscntr/ESM_BKG_0064.do"+param, 700, 250, "", "1,0,1,1,1,1,1,1,1,1", false,false, 0, 0, 0,"print_option");
							}
						}
					}
				}
				break;

			case IBNEWBTN:
				ComClearObject(formObj.elements["mode"]);
				ComClearObject(formObj.elements["vvd_cd"]);
				ComClearObject(formObj.elements["port_cd"]);
				//formObj.reset(); //추가함
				sheetObj.RemoveAll(); //추가함
				sheetObj.RemoveEtcData(); //추가함

				// create row 50 line
				// remove title
				for (var i=1; i<=50; i++) {
					sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(i, "ibflag", "R");
				}
				sheetObj.SelectCell(sheetObj.HeaderRows(), "bkg_no");
				//sheetObj.SelectCell(1, "bkg_no");
				//sheetObj.RowHidden(0) = true;
			break;
		}
	}


	/**
	 * clicking same row of hidden sheet at checkbox in case of clicking checkbox of sheet
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		with (sheetObj) {
			switch (ColSaveName(Col)) {
				case "bkg_no":
					if (Value == "") {
						SetCellValue(Row, "check", "0");
					} else {
						SetCellValue(Row, "check", "1");
					}
				break;
			}
		}
	}


	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction){
		with(formObj){
			// vvd
			if (vvd_cd.value.trimAll().length == 0 || vvd_cd.value.trimAll().length != 9) {
				ComShowCodeMessage("BKG00115");
				vvd_cd.focus();
				return false;
			} else {
				// form_vslCd- vvd_cd(1~4)
				// form_voyNo- vvd_cd(5~8)
				// form_dirCd- vvd_cd(9)
				var vvd = vvd_cd.value.trimAll();
				form_vslCd.value = vvd.substring(0, 4);
				form_voyNo.value = vvd.substring(4, 8);
				form_dirCd.value = vvd.substring(8, 9);
				//alert("vvd : [" + vvd + "]\n\n" + "vslCd : [" + vslCd + "]\n\n" + "voyNo : [" + voyNo + "]\n\n" + "dirCd : [" + dirCd + "]");
			}
			// Port
			if (port_cd.value.trimAll().length == 0 || port_cd.value.trimAll().length != 5) {
				ComShowCodeMessage("BKG00424");
				port_cd.focus();
				return false;
			}
			var bkgNos="";
			// B/L No BKG No
			for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
				if (sheetObj.GetCellValue(i, "bkg_no") != "") {
					bkgNos += sheetObj.GetCellValue(i, "bkg_no") + "|";
				}
			} // end of for
			if (bkgNos != "") {
				bkgNos = bkgNos.substring(0, eval(bkgNos.lengthByte()) - 1);
			} else {
				ComShowCodeMessage("BKG00425");
				sheetObj.SelectCell(sheetObj.HeaderRows(), "bkg_no");
				return false;
			}
			return true;
		}
	}
