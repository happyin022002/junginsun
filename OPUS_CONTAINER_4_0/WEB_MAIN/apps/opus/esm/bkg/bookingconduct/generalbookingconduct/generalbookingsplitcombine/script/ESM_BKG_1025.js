/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1025.js
*@FileTitle : Booking split_TRO/O Split
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
     * @class esm_bkg_1025 :business script for esm_bkg_1025
     */
    function esm_bkg_1025() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	


var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1="sheet1_";
var strSheetTitle=" |TRO Seq.|Sub. Seq.|TP/SZ|Haulage|Door"; 
var chkCntrValidate="";
// Event handler processing by button click event  */
document.onclick = processButtonClick;

// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1 = sheetObjects[0];

         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				 
				case "btn_ok":
					callParentTroSplitFunc(sheetObjects[0],prefix1+"tro_seq",prefix1+"tro_sub_seq",ComGetObjValue(formObject.bkg_no),ComGetObjValue(formObject.bkgsplitno),ComGetObjValue(formObject.splitReason),strSheetTitle);
					break;
				case "btn_close":
					window.close();
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
		if(ComGetObjValue(document.form.splitReason)=="C" && ComGetObjValue(document.form.bkg_no).length==12){
			strSheetTitle=" |TRO Seq.|Sub. Seq.|TP/SZ|Haulage|Door|"+ComGetObjValue(document.form.bkg_no).substring(10,12);
		}else{
			strSheetTitle=" |TRO Seq.|Sub. Seq.|TP/SZ|Haulage|Door|"+ComGetObjValue(document.form.orgSplit);
		}
		
		strSheetTitle=SheetSetHeader(ComGetObjValue(document.form.splitReason),ComParseInt(document.form.lastSplitNo),ComGetObjValue(document.form.splitCnt),strSheetTitle);
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }	
		sheetObjects[0].ExtendLastCol = false;
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//sheetObjects[0].CheckAll(prefix1+ComGetObjValue(document.form.orgSplit))=1;
	 
		//if(ComParseInt(document.form.splitCnt.value)>0){
		//	setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"tro_seq");
		//	chkCntrValidate= CheckCntrSplit(document.form.validateSplitNo.value);
		//}
		 
    }

	/*
	* handling remove blinking of Sheet
	*/
	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.WaitImageVisible = false;  
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
		sheetObj.WaitImageVisible = true;   
	} 


  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {

            case "sheet1":
                with (sheetObj) {

                    // setting height
                    style.height = 102;
                    
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind [selection, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //Edit kind [selection, Default false]
                    Editable = true;

                    //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					//var HeadTitle1 = "|TRO Seq.|Sub. Seq.|TP/SZ|Haulage|Door||A1|B1";
					var HeadTitle1 = strSheetTitle;
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 8, 0, true);

                    // setting function handling header
                    InitHeadMode(true, false, false, false, false,false)

                    //setting header row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                   
                    //data property    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"tro_seq",			false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"tro_sub_seq",		false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix1+"cntr_tpsz_cd",		false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"hualage",			false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"door",				false,		"",		dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	false,		prefix1+ComGetObjValue(document.form.orgSplit),				false,		"",      dfNone,	0,		true,	true);
					
					SheetSetInitCol(sheetObj,ComGetObjValue(document.form.splitReason),ComGetObjValue(document.form.splitCnt),ComParseInt(document.form.lastSplitNo),cnt,prefix1); 
					CountPosition = 0;
				}
				break;
        }
    }

  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = new Array("sheet1_");
        switch(sAction) {

			case IBSEARCH:  
				formObj.f_cmd.value = SEARCH; 
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1025GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.Redraw = false; 
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.Redraw = true;  
				break;
			
        }
    }

    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

	function callParentTroSplitFunc(sheetObj,prefix,key,bkgno,bkgsplitno,splitReason,strSheetTitle) { 
		var rArray = null; //rowdata array
		var idx=0;
		var ichk=0;
		var tmpbkgno="";
		rArray = new Array();
		for(var iRow=0;iRow<sheetObj.Rows;iRow++){
			ichk=0;
			for(var iCol=0;iCol<sheetObj.LastCol+1;iCol++){
				if(typeof(sheetObj.CellValue(iRow,iCol).length) =="undefined"){
					var str = sheetObj.ColSaveName(iCol).split("_");
					if (splitReason=="C"){
					 if(ichk==0){							
						ichk++;
						//tmpbkgno=bkgno;
						var strTmp = strSheetTitle.split("|");
						str=["",strTmp[iCol]];
						 tmpbkgno=bkgsplitno.substring(0,10)+str[1];
					 }else{
						tmpbkgno=bkgsplitno.substring(0,10)+str[1];
					 }
					}else{
						tmpbkgno=bkgsplitno.substring(0,10)+str[1];
					}

					 if(sheetObj.CellValue(iRow,iCol)==1){
						 rArray[idx]= sheetObj.CellValue(iRow,prefix)+":"+sheetObj.CellValue(iRow,key)+":"+str[1]+":"+tmpbkgno;
					 }else{
						 rArray[idx]= sheetObj.CellValue(iRow,prefix)+":"+sheetObj.CellValue(iRow,key)+"::"+tmpbkgno;
					 }
					 idx++;
				 }
			}
		}
		
		//  get  opener from window Object in case of modal window
		if(!opener)
			opener = window.dialogArguments; 
		try {
				opener.getSplitTro(rArray);
				window.close();
		}
		catch(e) {
		 	ComShowCodeMessage("COM12111");
		}
	} 

	