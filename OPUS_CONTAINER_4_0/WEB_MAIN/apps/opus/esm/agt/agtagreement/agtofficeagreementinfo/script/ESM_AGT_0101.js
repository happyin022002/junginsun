/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0101.js
*@FileTitle : CNTR Type Size List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
				OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/




	/**
	 * @extends 
	 * @class ESM_AGT_0101 : ESM_AGT_0101 business script for.
	 */
	function ESM_AGT_0101() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
 // Common Global Variables


	var sheetObjects = new Array();
	var sheetCnt = 0;

	var IBDETAILSEARCH	 = 20; //corrct

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;

	/* Event handler processing by button name */
		function processButtonClick(){
			 /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
			 var sheetObject = sheetObjects[0];
			 //var sheetObject1 = sheetObjects[1];
			 //var sheetObject2 = sheetObjects[2];

			 /*******************************************************/
			 var formObject = document.form;

			try {
				var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBDETAILSEARCH);
						break;

					case "btn_ok":
//						if(sheetObject.CheckedRows("checkbox") < 1){
//							ComShowMessage(ComGetMsg('AGT00085','Detail TP/SZ CheckBox.'));
//							return false;
//						}
						  
						  comPopupOK();
						  
					  break;

					case "btn_close":
						  window.close();
					  break;

				} // end switch
			}catch(e) {
				if( e == "[object Error]") {
					ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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

			   sheetObjects[sheetCnt++] = sheet_obj;


			}

		/**
		 * initializing sheet
		 * implementing onLoad event handler in body tag
		 * adding first-served functions after loading screen
		 */
		function loadPage() {

				for(i=0;i<sheetObjects.length;i++){

					//khlee-Changing Start Environment Setting Method's Name
						ComConfigSheet(sheetObjects[i]);

						initSheet(sheetObjects[i],i+1);
					//khlee-Adding Last Environment Setting method
						ComEndConfigSheet(sheetObjects[i]);
					}
			//ESM_AGT_003 parameters  Retrieve
			var formObject = document.form;
		  	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		}

	   /**
		 * setting sheet initial values and header
		 * param : sheetObj, sheetNo
		 * adding case as numbers of counting sheets
		 */
		function initSheet(sheetObj,sheetNo) {

			var cnt = 0;

			switch(sheetNo) {

				case 1:	  //sheet1 init
					with (sheetObj) {
						// setting height
						style.height = GetSheetHeight(10) ;
						//Whole setting width
						SheetWidth = mainTable.clientWidth;

						//setting Host information[mandatory][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//Whole Merge kind [Optional, Default msNone]
						MergeSheet = msHeaderOnly;

					   //Edit kind [Optional, Default false]
						if(document.form.pageType.value != "Inquiry"){
							Editable = true;
						}else{
							Editable = false;
						}

						//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 0, 1, 9, 100);

						//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(5, 0 , 0, true);

						// setting function handling header						
						if(document.form.pageType.value != "Inquiry"){
							InitHeadMode(true, true, true, true, false,false) ;
						}else{
							InitHeadMode(true, true, false, true, false,false) ;
						}

						var HeadTitle = "STS|No|CHK|Type|Description";

						//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);

						//Data  properties	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ ,dtHiddenStatus,30,	daCenter,  false,	"",	 false,		  "",	   dfNone,   		0,	 false,	  true);
						InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,   false,	"",	 false,		  "",	   dfNone,		  0,	 true,	   true);
						InitDataProperty(0, cnt++ , dtCheckBox,   40,	daCenter,   false,	"checkbox",	 false,		  "",	   dfNone,		  0,	 true,	   true);
						InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,   false,	"cntr_tp_cd",	 false,		  "",	   dfNone,		  0,	 false,	   false);
						InitDataProperty(0, cnt++ , dtData,	   50,	daLeft,   false,	"cntr_tp_desc",	 false,		  "",	   dfNone,		  0,	 false,	   false);

						CountPosition = 0 ;

				   }
					break;

			}
		}

	  // handling process for Sheet
		function doActionIBSheet(sheetObj,formObj,sAction) {
//			sheetObj.ShowDebugMsg = false;

			switch(sAction) {

			   case IBSEARCH:	  //Retrieve
					if(!validateForm(sheetObj,formObj,sAction)) return false;
					
			
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ESM_AGT_0101GS.do", agtQryStr(formObj));
	 				var arrXml = sXml.split("|$$|");
	 				if(arrXml.length>0)sheetObjects[0].LoadSearchXml(arrXml[0]);
	 				//if(arrXml.length>1)sheetObjects[1].LoadSearchXml(arrXml[1]);
	 				//if(arrXml.length>2)sheetObjects[2].LoadSearchXml(arrXml[2]);
					break;
				
			}
		}

	   /**
		 * handling process for input validation
		 */
		function validateForm(sheetObj,formObj,sAction){
			var sheetObject = sheetObjects[0];
			//var sheetObject1 = sheetObjects[1];
			//var sheetObject2 = sheetObjects[2];
			switch(sAction) {

//				case IBDETAILSEARCH:
//					if(sheetObject.CheckedRows("check") < 1 &&  sheetObject1.CheckedRows("check") < 1){
//						ComShowMessage(ComGetMsg('AGT00085','Rep. Type OR Rep. Size CheckBox'));
//						return false;
//					}
//					break;
			}

			return true;
		}

function chkdArgs(sheetObj,chkCol,valCol,isNum)
{
	var rtn = '';
	with(sheetObj)
	{
		for (var i = 1; i <= LastRow; i ++)
		{
			if ("1" == CellValue(i, chkCol))
				rtn += (''!=rtn?',':'')+(isNum?'':'\'')+CellValue(i, valCol)+(isNum?'':'\'');
		}
	}
	return rtn;
}
