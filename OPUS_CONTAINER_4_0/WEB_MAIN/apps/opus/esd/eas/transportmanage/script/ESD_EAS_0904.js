/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_EAS_0904GS.jsp
*@FileTitle : Route UnMatch List Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/

	function ESD_EAS_0904() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.initTab                = initTab;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	}	
	

	/* Global variables */
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;
	

	/**
	 * registering IBSheet Object as list
	 * comSheetObject(id)
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

/**
 * initializing Sheetobjects
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */

function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
	    
		ComConfigSheet(sheetObjects[i]);
       initSheet(sheetObjects[i],i+1);
        
       ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

}


/* Event handler processing by button name */
function processButtonClick(){

//	 var sheetObj = docObjects[0];
//	 var formObj  = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_close":
			    window.returnValue = null;
			    window.close();
			break;
		}
	}catch(e){
		if( e == "[object Error]") {
			showErrMessage(getMsg('COM12111')) ;
		} else {
			ComShowMessage(e);
		}
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      
			formObj.f_cmd.value = SEARCHLIST01;
			sheetObj.DoSearch4Post("ESD_EAS_0904GS.do", EasFrmQryString(formObj));
		break;
	}
}


/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {
				
				style.height = GetSheetHeight(13);
				
				SheetWidth = mainTable.clientWidth;

				
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				
				MergeSheet = msHeaderOnly;

				
				Editable = false;

				//setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 2, 1, 10);

				//setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(27, 0, 0, true);

				// setting function handling header
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = " Seq.|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail"
				+"|BKG Detail|BKG Detail|BKG Detail|S/O(per CNTR)|AR Inv(per BKG)|CCT Ofc.|Ex.Rate|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type" ;

				var HeadTitle1 = " Seq.|Booking No.|B/L No.|POR|POL|POD|DEL|S/C No.|RFA No.|Cntr No.|Bnd|Term|TRO Ofc.|TRO Loc."
				+"|TRO Q'ty|TRO Amt|Exp Inv.(P)|Rev.(R)\n(BKG)|CCT Ofc.|Ex.Rate|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type" ;
				
				//Header Row info [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				HeadRowHeight = 12;
				
				//Data Attribute	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	 40,	daCenter,  true,	"seq",				false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,		 85,	daCenter,  false,	"bkg_no",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     85,	daCenter,  false,	"bl_no",       false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"por_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"pol_cd",      false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,  false,	"pod_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"del_cd",      false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  false,	"sc_no",      	false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     80,	daCenter,  false,	"rfa_no",     	false,		  "",	   dfNone,   	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtHidden,	 70,	daCenter,  false,	"cntr_qty",   	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  false,	"cntr_no",   	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"bnd",         false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"term",        false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"tro_ofc",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_loc",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_qty",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,	true,	"tro_amt",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 90,	daRight,    true,	"exp_inv",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 100,	daRight,    true,	"ar_rev",      false,		  "",	   dfNone,   	0,	 		false,	   false);
//				InitDataProperty(0, cnt++ , dtData,		 60,	daRight,    true,	"rev_exp",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,   true,	"cct_ofc",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daRight,    true,	"ex_rate",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"tro_id",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"so_ofc",     	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"so_id",       false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"rating_ofc",  false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"rating_id",   false,		  "",	   dfNone,    0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"sts",         false,		  "",	   dfNone,   	0,	 		false,	   false); 
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"trm_type",    false,		  "",	   dfNone,   	0,	 		false,	   false);
				
				//style.height = GetSheetHeight(10) ;
				//DataLinkMouse = true;
				
				HeadRowHeight = 20 ;
		   }
			break;

	}
}

function sheet_OnSearchEnd(sheetObj,errMsg){
	if(errMsg!=null){
		showErrMessage(errMsg);
	}
}

