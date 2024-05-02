/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0052.js
*@FileTitle : MRN & Return yard Setup
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @extends
 * @class esm_bkg_0052 : business script for esm_bkg_0052
 */
function esm_bkg_0052() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
    this.obj_keypress           = obj_keypress;
}

/* developer job	*/
// common global variables

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event
document.onclick = processButtonClick;

// Event handler processing by button name
 function processButtonClick(){
      var sheetObject = sheetObjects[0];
	  var sheetObject1 = sheetObjects[1];
      var formObject = document.form;

 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

							case "btn_Retrieve":
								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
							break;

							case "btn_new":
								sheetObject.RemoveAll();
							break;

							case "btn_down_excel":
								sheetObjects[0].Down2Excel(true,false,true);
							break;

							case "btn_upload_excel":
								sheetObjects[0].LoadExcel(-1,1,"",-1,-1,"",false);
							break;

							case "btn_save":
								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);

							break;

							case "btn_close":
								if(sheetObjects[0].IsDataModified){
									if(confirm(ComGetMsg("BKG00168"))){
										window.close();
									}
								}
								window.close();
							break;



         } // end switch
 }

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
 function setSheetObject(sheet_obj){

    sheetObjects[sheetCnt++] = sheet_obj;

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


     var formObj = document.form;
     formObj.vvd.value = strVvd;

	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 }


/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;

     switch(sheetNo) {
         case 1:      //sheet1 init
             with (sheetObj) {

                 //setting height
                 style.height = 260;
                 //setting width
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //setting Host information[compulsory][HostIp, Port, PagePath]
                 MergeSheet = msPrevColumnMerge;

                //Merge kind [optional, Default msNone]
                 Editable = true;

                 //Edit kind [optional, Default false]
                 InitRowInfo(1, 1, 15, 100);

                 //setting Column information[compulsory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(8, 0, 0, true);

                 // setting function handling header
                 InitHeadMode(false, true, false, true, false,false)

                 var HeadTitle1 = "ibflag|Seq.|BL NO|BKG NO|Container No.|MRN|RTN YD|Reference";

                 //header row info[compulsory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 var prefix = "sheet1_";
                 //data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    0,      daCenter,    false,      prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,			40,	  	daCenter,		false,		prefix + "Seq",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,	  	daCenter,		false,		prefix + "bl_no",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			80,	  	daCenter,		false,		prefix + "bkg_no",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		prefix + "cntr_no",		false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,		daCenter,		false,		prefix + "vsl_mrn_no",			false,			"",      dfNone,			0,		true,		true,19);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		false,		prefix + "mty_rtn_yd_cd",		false,			"",      dfNone,			0,		true,		true,7);
				InitDataProperty(0, cnt++ , dtData,			260,	daLeft,			false,		prefix + "rtn_ref_no",		false,			"",      dfNone,			0,		true,		true, 25);

				InitDataValid(0, prefix + "mty_rtn_yd_cd", vtEngUpOther, "1234567890");
				WaitImageVisible = false;

            }
             break;
		case 2:      //sheet2 init
             with (sheetObj) {

                 //setting height
                 style.height = 260;
                 //setting width
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //setting Host information[compulsory][HostIp, Port, PagePath]
                 MergeSheet = msPrevColumnMerge;

                //Merge kind [optional, Default msNone]
                 Editable = true;

                 //Edit kind [optional, Default false]
                 InitRowInfo(1, 1, 15, 100);

                 //setting Column information[compulsory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(8, 0, 0, true);

                 // setting function handling header
                 InitHeadMode(false, true, false, true, false,false)

                 var HeadTitle1 = "ibflag|Seq.|BL NO|BKG NO|Container No.|MRN|RTN YD|Reference";

                 //header row info[compulsory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 var prefix = "sheet2_";
                 //data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,    0,      daCenter,    false,      prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,			40,	  	daCenter,		false,		prefix + "Seq",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,	  	daCenter,		false,		prefix + "bl_no",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			80,	  	daCenter,		false,		prefix + "bkg_no",			false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		prefix + "cntr_no",		false,			"",      dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix + "vsl_mrn_no",			false,			"",      dfNone,			0,		true,		true,19);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		false,		prefix + "mty_rtn_yd_cd",		false,			"",      dfNone,			0,		true,		true,7);
				InitDataProperty(0, cnt++ , dtData,			260,	daLeft,			false,		prefix + "rtn_ref_no",		false,			"",      dfNone,			0,		true,		true, 100);

				InitDataValid(0, prefix + "mty_rtn_yd_cd", vtEngUpOther, "1234567890");

				WaitImageVisible = false;

            }
             break;

     }
 }

 // handling of Sheet process
 function doActionIBSheet(sheetObj,formObj,sAction) {
     switch(sAction) {

					case IBSEARCH:      // Retrieve
						//doActionIBSheet_Search(sheetObj,formObj,sAction);
						if(sheetObj.id == "sheet1"){
							//alert(FormQueryString(formObj));
							formObj.f_cmd.value = SEARCH01;

							if(formObj.vvd.value.length != 0  && formObj.vvd.value.length != 6 && formObj.vvd.value.length != 9){
								ComShowCodeMessage("BKG00007");
								formObj.vvd.focus();
								return;
							}
							ComOpenWait(true);
							sheetObj.DoSearch("ESM_BKG_0052GS.do"
												,FormQueryString(formObj)
														+ "&"
														+ ComGetPrefixParam("sheet1_")
												);
						}
					break;

					case IBSAVE:        // save
						if(validateForm(sheetObj,formObj,sAction))
							fncSave();
					break;


     }
 }



 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
     }

     return true;
 }

 /**
  * Dynamically load HTML Control event in page. <br>
  **/
function initControl() {
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}



function sheet1_OnSaveEnd(sheetObj, errMsg){
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}


function fncSave(){
	var formObject = document.form;
	var sheetObj = sheetObjects[0];
	var prefix = "sheet1_";

	for(var i=1;i<sheetObj.RowCount;i++){
		if(     sheetObj.CellValue(i,prefix + "vsl_mrn_no").length != 0
			&&	  (sheetObj.CellValue(i,prefix + "vsl_mrn_no").length < 7
			||    sheetObj.CellValue(i,prefix + "vsl_mrn_no").length > 18)   ){
			ComShowCodeMessage("BKG40105","MRN");
			sheetObj.SelectCell(i,prefix + "vsl_mrn_no") ;
			return;
		}
		if(    sheetObj.CellValue(i,prefix + "mty_rtn_yd_cd").length != 0
			&& sheetObj.CellValue(i,prefix + "mty_rtn_yd_cd").length != 7 ){
			//ComShowCodeMessage("BKG01078");
			ComShowCodeMessage("BKG40106","7");
			sheetObj.SelectCell(i,prefix + "mty_rtn_yd_cd") ;
			return;
		}
		if(        sheetObj.CellValue(i,prefix + "rtn_ref_no").length > 100 ){
			ComShowCodeMessage("BKG40106","REF NO","100");
			sheetObj.SelectCell(i,prefix + "rtn_ref_no") ;
			return;
		}
	}


	formObject.f_cmd.value = MULTI01;

	var param = "&vvd="+formObject.vvd.value;

	sheetObj.DoSave("ESM_BKG_0052GS.do", FormQueryString(formObject) + param + "&" + ComGetPrefixParam("sheet1_"));
}


/**
 * event of after excel load
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadExcel(sheetObj){
	var sheetOrg;
	var sheetNew;
	var cnt = 0;
	var lineNumber = 0;
	var colName = 0;

	sheetOrg = sheetObj;
	sheetNew = sheetObjects[1];
	sheetOrg.DataAutoTrim = true;
	sheetNew.DataAutoTrim = true;

	for(var i=1;i <= sheetOrg.RowCount+1;i++){
		if(sheetOrg.CellValue(i,"sheet1_"+"bl_no") == ""){
			sheetOrg.RowDelete(i,false);
		}
	}



	if(sheetOrg.RowCount != sheetNew.RowCount){
		ComShowCodeMessage("BKG43041");
		return;
	}
	ComBtnDisable("btn_save");
	for(var i=2;i <= sheetOrg.RowCount;i++){
		if(fncDiff( sheetOrg.CellValue(i,"sheet1_"+"bl_no"),sheetNew.CellValue(i,"sheet2_"+"bl_no") )){
			colName = "bl_no";
			lineNumber = i;
			cnt++;
		}
		if(fncDiff( sheetOrg.CellValue(i,"sheet1_"+"cntr_no"),sheetNew.CellValue(i,"sheet2_"+"cntr_no") )){
			colName = "cntr_no";
			lineNumber = i;
			cnt++;
		}

		sheetOrg.CellValue(i,"sheet1_"+"bl_no") = sheetNew.CellValue(i,"sheet2_"+"bl_no");
		sheetOrg.CellValue(i,"sheet1_"+"cntr_no") = sheetNew.CellValue(i,"sheet2_"+"cntr_no");

	}

	if(cnt > 0){
		ComShowCodeMessage("BKG43042");
	}else{
		ComBtnEnable("btn_save");
	}
}

/**
 * diff str
 * @param orgStr
 * @param newStr
 * @return
 */
function fncDiff(orgStr,newStr){
	orgStr = orgStr.replace(eval("/\\r\\n/gi"), " ").trim();
	newStr = newStr.replace(eval("/\\r\\n/gi"), " ").trim();

	if(orgStr != newStr){
		return true;
	}else{
		return false;
	}
}
/**
 * t4sheet1 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    with(sheetObj)
    {

    	if(rowcount < 1){
    		ComBtnDisable("btn_save");
    	}else{
    		ComBtnEnable("btn_save");
    	}

    	var xmlStr = IBS_GetDataSearchXml(sheetObj);
    	sheetObjects[1].LoadSearchXml(xmlStr,false);

		ComOpenWait(false);

    }
}
