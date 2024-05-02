var sheetObjects = new Array();
var sheetCnt = 0;
var focusField = "" ;
var comboObjects = new Array();
var comboCnt = 0;
var aryCol = new Array();
var allFlag = false;

document.onclick = processButtonClick;


function processButtonClick(){

	 var sheetObj = sheetObjects[0];
	 var sheetObj2 = sheetObjects[1];
	 /*******************************************************/
	 var formObj = document.form;
	 
	 try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {

			case "btn_retrieve":
				if ( ComIsEmpty(formObj.fm_dt) )
				{
					ComShowCodeMessage("you must enter ETA Date.");
					formObj.fm_dt.focus();
					return ;
				}
				
				if ( ComIsEmpty(formObj.to_dt) )
				{
					ComShowCodeMessage("you must enter ETA Date.");
					formObj.to_dt.focus();
					return ;
				}
				
				if(ComGetDaysBetween(formObj.fm_dt , formObj.to_dt) < 0) {
					ComShowCodeMessage("TRS90118");
					formObj.fm_dt.focus();
					return false;
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && !ComIsEmpty(formObj.s_pol_pod) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 30 ) {
					ComShowMessage("Possible inquiry period is limited to 30 days.");
					return false;
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && ComIsEmpty(formObj.s_pol_pod) && ComIsEmpty(formObj.s_neweq_office) && ComIsEmpty(formObj.s_vvd) && !ComIsEmpty(formObj.s_eq_office) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 21) {
					ComShowMessage("Possible inquiry period is limited to 21 Days.");
					return false;
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && ComIsEmpty(formObj.s_pol_pod) && !ComIsEmpty(formObj.s_neweq_office) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 30 ) {
					ComShowMessage("Possible inquiry period is limited to 30 days.");
					return false;
				
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && ComIsEmpty(formObj.s_pol_pod) && !ComIsEmpty(formObj.s_vvd) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 14 ) {
					ComShowMessage("Possible inquiry period is limited to 14 days.");
					return false;
				}

				doActionIBSheet(sheetObj,formObj,IBSEARCH,'RTV');
				sheet1_OnSearchEnd(sheetObj,'');
				break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
				doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
				break;

	  		case "btn_clm":
		  		goESD_SCE_0044(sheetObj) ;
				break;

	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
			
	  		case "btn_downonly":	

				doActionIBSheet(sheetObj,formObj,IBSEARCH,'XLS') ;
				break;

	  		case "btn_downcsv":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				break;

			case "btn_calendar":

					cal = new ComCalendarFromTo();
	  				cal.displayType = "date";
					cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
				break ;

			case "btns_multiinput" :
				    openESD_SCE_0048();
				break ;
			case "btns_vender": //Service Provider
				rep_OnPopupClick();
				break;
			case "btn_send": 
		
			 doActionIBSheet(sheetObj,formObj,MODIFY);
		
			 break;
	  } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111") ;
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object

 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;

}
/**
 * Combo Object를 배열로 등록
 */    
function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
}
/**
 * Sheet 
 * body  onLoad 
 * 
 */
function loadPage() {
	
	for(i=0;i<sheetObjects.length;i++){

			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);

			ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var i=0;i<comboObjects.length;i++) {
        initCombo(comboObjects[i], comboObjects[i].id);
    }


		doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
		doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
		doActionIBSheet(sheetObjects[1],document.form,SEARCH07);
		
		if(sheetObjects[1].rowCount > 0)
			colHidnSetting();
		
	}

/**
 * 콤보 Text, Value셋팅
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다
 */
function initCombo(comboObj, comboId) {
    var frmObj = document.form;
    with (comboObj) {
        switch (comboId) {
            case "s_mvmt_cd":
                MultiSelect = true;
                DropHeight = 160;
                var rtnValues = "BI$$BO$$BR$$CD$$CE$$CI$$CM$$CO$$CP$$CT$$CX$$EN$$IC$$ID$$MT$$OC$$OP$$TN$$TS$$VD$$VL$$XX$$";

                parseMultiCombo(comboObj,"$$"+ rtnValues,"All$$"+ rtnValues);
                Text = "All";
                break;
        }
    }
}

function s_mvmt_cd_OnChange(comboObj, Index_Code, Text){
//다른 Code가 Check되어 있는 상태에서 All을 Check 할 경우 다른 Code를 uncheck 하고
//All이 Check되어 있는 상태에서 다른 Code를 check 할 경우 All을 Uncheck한다.	
	if(allFlag && comboObj.Index.length>1){
		comboObj.CheckIndex(0) = false;
	}else if(!allFlag && comboObj.Index.substring(0,1) == '0' && comboObj.Index.length>1){
		for(var i=1;comboObj.GetCount()>i; i++){
			comboObj.CheckIndex(i) = false;
		}
	}
	
	if(comboObj.Index != -1){
		if(comboObj.Index.substring(0,1) == '0'){
			allFlag =  true;
		}else{
			allFlag =  false;
		}
	}else{
		allFlag =  false;
	}
}



function parseMultiCombo(ComboObj, CodeString, TextString) {
    var ComboCodeList = CodeString.split("$$");
    var ComboTextList = TextString.split("$$");
    ComboObj.RemoveAll();
    for (var w=0; w<ComboCodeList.length-1; w++) {
        ComboObj.InsertItem(w, ComboTextList[w], ComboCodeList[w]);
    }

}


function openerHidden(){
	
	doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
	doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
	doActionIBSheet(sheetObjects[1],document.form,SEARCH07);
	
	if(sheetObjects[1].rowCount > 0)
		colHidnSetting();

}

   /**
 * 
 * param : sheetObj ==> , sheetNo ==> 
 *  case? 
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {
			
				//SheetWidth = mainTable.clientWidth;
				//AutoSizeMode = true;
				//SheetWidth = 7000;
                   
				//Host[][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Merge [ Default msNone]
				MergeSheet = msHeaderOnly;

				//Edit  [, Default false]
				Editable = true;

				//[][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 16, document.form.row_size.value);

				//[][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				//InitColumnInfo(95, 3, 0, true); // CHK 주석
				InitColumnInfo(84, 6, 0, true); // CHK 주석
				//FrozenCols = 4;

				// 
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "CHK|SEQ|BKG|Container|324 EDI Status|324 EDI\nSend Date/Time|B/L No.|Unmatch List|BKG|BKG|BKG|TY/SZ|MVMT|MVMT Yard|MVMT DT|Master|VVD|Lane|ETA|SPE|Rail DEST|Rail ETA|CSTMS\nCLR LOC|CSTMS CLR\n LOC Name|EQ Office|Term|Add|S/P|S/P|Rail|Rail|Rail|Truck(Shuttle)|Truck(Shuttle)|Truck(Shuttle)|Truck(Additional)|Truck(Additional)|Truck(Additional)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|COP Status|From|Guide|P/UP Node|AVL Date|Free Date|F|O|C|CM|P/UP NO.|P/UP Office|P/UP End|S/C|S/C|CNEE|CNEE|CNEE|SHPR|SHPR|SHPR|NTFY|NTFY|NTFY|Filer|IT NO.|IT Date|PO NO.|Seal NO.|Weight|CLM|CLM|CLM|CLM|Train No|Flat Car No|Remark";
				var HeadTitle2 = "CHK|SEQ|BKG|Container|324 EDI Status|324 EDI\nSend Date/Time|B/L No.|Unmatch List|POD|DEL|DEL Location Name|TY/SZ|MVMT|MVMT Yard|MVMT DT|Master|VVD|Lane|ETA|SPE|Rail DEST|Rail ETA|CSTMS\nCLR LOC|CSTMS CLR\n LOC Name|EQ Office|Term|Add|Code|Name|Plan|S/O|W/O|Plan|S/O|W/O|Plan|S/O|W/O|Plan|S/O|W/O|DR_ISS DATE|DR_FM|DR_TO|DR_S/P|DR_S/P Name|COP Status|From|Guide|P/UP Node|AVL Date|Free Date|F|O|C|CM|P/UP NO.|P/UP Office|P/UP End|S/C NO.|S/C Customer Name|CNEE Code|CNEE Name|CNEE Address|SHPR Code|SHPR Name|SHPR Address|NTFY Code|NTFY Name|NTFY Address|Filer|IT NO.|IT Date|PO NO.|Seal NO.|Weight|CLM Status|CLM Location|CLM ST|CLM Date|Train No|Flat Car No|Remark";
				// 컬럼 추가 시 ESD_SCE_0057.js 화면에서 defaultVal, colDesc, colDesc2 수정 필요 - for Customized Report Form;
				
				
				//?????[??][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//?????	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,  50,    daCenter,  true,    "chk",        false,          "",       dfNone,   	0,     true,       true); //CHK
				InitDataProperty(0, cnt++ , dtSeq,		30,	daLeft,  true,	"",	 false,		  "",	   dfNone,   	0,	 false,	   false);         //SEQ
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"bkg_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //BKG
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"cntr_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //Container
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"edi_snd_tp_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //B/L No
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"edi_snd_dt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //B/L No
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"bl_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //B/L No
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"unmatch_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //NIS-COP Unmatch
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"bkg_pod_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //BKG-POD
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"bkg_del_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //BKG-DEL
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"del_loc_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //BKG-DEL
				//InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"cop_pod_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //COP-POD
				//InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"cop_del_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //COP-DEL
			//	InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"cntr_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //Container
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"tpsz",	 false,		  "",	   dfNone,	 	0,	 false,	   false);      //TY/SZ				
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"mvmt_sts",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //MVMT
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	"mvmt_yd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //ST_NODE
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"mvmt_dt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //ST_DATE
		    	InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"dup_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //DUP FLAG
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"vvd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //VVD
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"lane",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //LANE
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"eta",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //ETA
				InitDataProperty(0, cnt++ , dtData,	   40,	daCenter,  true,	"spe",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //SPE
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"rail_dest",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //RAIL DEST
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"rail_eta",	 false,		  "",	   dfNone,	 	0,	 false,	   false);		// Rail ETA
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	"cstms_loc_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //CSTMS CLR LOC
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"cstms_loc_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //CSTMS CLR LOC Name
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	"eq_ctrl_ofc_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //EQ Office
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"term",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TERM
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"add_trsp",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //ADD
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"vndr_seq",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //VNDR_SEQ
				InitDataProperty(0, cnt++ , dtData,	   180,	daCenter,  true,	"vndr_name",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //VNDR_NAME
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"rl_so_pln_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //Rail PLAN
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"rl_so_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //Rail RAIL1 SO
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"rl_wo_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //RAIL RAIL1 WO
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"ts_so_pln_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TS PLAN
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"ts_so_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TS RAIL1 SO
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"ts_wo_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TS RAIL1 WO
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"tc_so_pln_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TC PLAN
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"tc_so_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TC RAIL1 SO
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"tc_wo_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TC RAIL1 WO
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"dr_so_pln_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TRUCK(DOOR) PLAN
				InitDataProperty(0, cnt++ , dtData,	  50,	daCenter,  true,	"dr_so_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TRUCK(DOOR) SO
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"dr_wo_flg",	 false,		  "",	   dfNone,	 	0,	 false,	   false);       //TRUCK(DOOR) WO
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"dr_wo_dt",	 false,		  "",	   dfDateYmd,	 	0,	 false,	   false);       //TRUCK(DOOR) WO
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"dr_fm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //DR_FM
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"dr_to",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //DR_TO
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"dr_sp",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //DR_S/R//71
                InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"dr_sp_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //DR_S/R Name
           		InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"cop_sts_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //COP Status
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"frm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //FROM
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"guide",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //GUIDE
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"pkup_yd_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //P/UP NODE
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"pkup_aval_dt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //AVL DATE
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"pkup_free_dt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //FREE DATE
				InitDataProperty(0, cnt++ , dtData,	   20,	daCenter,  true,	"f",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //F
				InitDataProperty(0, cnt++ , dtData,	   20,	daCenter,  true,	"o",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //O
				InitDataProperty(0, cnt++ , dtData,	   20,	daCenter,  true,	"c",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //C
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"dspo_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //CM
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"pkup_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //P/UP NO.
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"pkup_ofc_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //P/UP OFFICE
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"pkup_end",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //P/UP END
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"sc_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //S/C NO.
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"sc_cust_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //S/C Customer Name
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"cnee_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //CNEE Code
				InitDataProperty(0, cnt++ , dtData,	   200,	daCenter,  true,	"cnee_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //CNEE Name
				InitDataProperty(0, cnt++ , dtData,	   300,	daCenter,  true,	"cnee_addr",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //CNEE ADDRESS
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"shpr_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //SHPR Code
				InitDataProperty(0, cnt++ , dtData,	   200,	daCenter,  true,	"shpr_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //SHPR Name
				InitDataProperty(0, cnt++ , dtData,	   300,	daCenter,  true,	"shpr_addr",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //SHPR ADDRESS
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"ntfy_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //NTFY Code
				InitDataProperty(0, cnt++ , dtData,	   200,	daCenter,  true,	"ntfy_nm",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //NTFY Name
				InitDataProperty(0, cnt++ , dtData,	   300,	daCenter,  true,	"ntfy_addr",	 false,		  "",	   dfNone,	 	0,	 false,	   false);        //NTFY ADDRESS
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"filer",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //FILER
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"it_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //IT NO.
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"it_date",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //IT DATE
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"po_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //PO NO.
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	"seal_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //SEAL NO.
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"cntr_wgt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);	      //WEIGHT
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"clm_crnt_sts",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //Rail1 CLM STATE
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"clm_loc",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //Rail1 CLM LOCATION
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"clm_state",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //Rail1 ST
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"clm_dt",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //Rail1 CLM DATE
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"trn_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //TRN_NO
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"fcar_no",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //FCAR_NO
				InitDataProperty(0, cnt++ , dtData,	   280,	daCenter,  true,	"bkg_cntr_rmk",	 false,		  "",	   dfNone,	 	0,	 false,	   false);         //REMARK
				InitDataProperty(0, cnt++ , dtHiddenStatus, 25,    daCenter,  false,  "ibflg",  	  false,          "",       dfNone,   		0,     false,      false, 30);

// end !!
				style.height = GetSheetHeight(16) ;
			}
			AllowEvent4CheckAll = true;
			break;
				
		case 2: // sheet2 init
    		with (sheetObj) {
    			// 높이 설정
    			style.height = GetSheetHeight(10) ;

    			// 전체 너비 설정
    			SheetWidth = mainTable.clientWidth;

    			// Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "")
    				InitHostInfo(location.hostname, location.port, page_path);

    			// 전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msNone;

    			// 전체Edit 허용 여부 [선택, Default false]
    			Editable = true;

    			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 1, 5, 100);

    			var HeadTitle = "Sel.|Seq.|Selected Items|test";
    			var headCount = ComCountHeadTitle(HeadTitle);

    			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false, false);

    			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle, true);

    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, false, "chk2");
    			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
    			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "coldesc2", false, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "coldesc3", false, "", dfNone, 0, false, false);

    		}
    		break;

		}
	}

  // Sheet
function doActionIBSheet(sheetObj,formObj,sAction, loc) {

	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
	   case IBROWSEARCH:
	        if(validateForm(sheetObj,formObj,sAction)){
    				formObj.f_cmd.value = SEARCH01 ;
    		  		sheetObj.DoSearch4Post("ESD_SCE_0056GS.do", SceFrmQryString(formObj));
                   //sheetObj.CellFontColor(1,2) = sheetObj.RgbColor(255, 0 0);
                   formObj.totcnt.value = 0;
                   if(sheetObj.EtcData("totcnt")>0){
                      //var rat = round(sheetObj.RowCount*100/sheetObj.EtcData("totcnt"));
                      //formObj.totcnt.value = " " + sheetObj.Rows + " / " + sheetObj.TotalRows;
                      formObj.totcnt.value = " " + sheetObj.EtcData("totcnt");
                   }
	            }

			break;

	   case IBSEARCH:	  //기본 조회시
		   var newForm = "" ;
	        if(validateForm(sheetObj,formObj,sAction)){	        	
	        	if(loc == "RTV" ) {
    				formObj.f_cmd.value = SEARCHLIST ;
    				formObj.target	  = "_self" ;
    				sheetObj.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOSUM";
    				sheetObj.DoSearch4Fx("ESD_SCE_0056GS.do", SceFrmQryString(formObj));
    		  	//sheetObj.DoSearch4Post("ESD_SCE_0056GS.do", SceFrmQryString(formObj));
	        	} else if (loc == "XLS") {
	        		        		
//	    			ComOpenWait(true);
	    		    formObj.f_cmd.value = SEARCH03;
	    		    formObj.target = "_blank" 
	    			formObj.action = "ESD_SCE_0205.do";
	    		    formObj.submit();
//	    		    ComOpenWait(false);
	    		    
	        		
	        	}
	        }
      
			break;
	    case MODIFY:	  //EDI 324 Send
	  
	    	if(validateForm(sheetObj,formObj,sAction)){
	    		formObj.f_cmd.value = MODIFY;
	    		sheetObj.DoSave("ESD_SCE_0056GS.do", SceFrmQryString(formObj),"chk");
	    		doActionIBSheet(sheetObj,formObj,IBSEARCH,'RTV');
				sheet1_OnSearchEnd(sheetObj,'');
	    	}
	         
	        break;
	        
	    case COMMAND01:     //SUB TRADE CODE SEARCH
           		
           		formObj.f_cmd.value = SEARCH02;   
      		
           		var searchXml = sheetObj.GetSearchXml("ESD_SCE_0056GS.do", FormQueryString(formObj));
           		comboObjects[1].RemoveAll(); 
           		//Trade code
				ComSceXml2ComboItem(searchXml, formObj.s_pol_pod, "cop_pod_cd", "cop_pod_cd");							
				
				comboObjects[1].InsertItem(0, "ALL", "ALL");
				comboObjects[1].DropHeight= 300;
				comboObjects[1].MultiSelect = true;
				comboObjects[1].MultiSeparator=",";
				comboObjects[1].UseEdit = false;
				
				comboObjects[1].index2 = 0;
				
				s_pol_pod_gen();
				
           break;
        case COMMAND02:   
           		
           		formObj.f_cmd.value = SEARCH04;   
      		
           		var searchXml = sheetObj.GetSearchXml("ESD_SCE_0056GS.do", FormQueryString(formObj));
           		comboObjects[0].RemoveAll(); 
           		
				ComSceXml2ComboItem(searchXml, formObj.s_neweq_office, "eq_ctrl_ofc_cd", "eq_ctrl_ofc_cd");							
				
				comboObjects[0].InsertItem(0, "ALL", "ALL");
				comboObjects[0].DropHeight= 300;
				comboObjects[0].MultiSelect = true;
				comboObjects[0].MultiSeparator=",";
				comboObjects[0].UseEdit = false;
				
				comboObjects[0].index2 = 0;		
				
				s_neweq_office_gen();		
				
           break;
		case IBDOWNEXCEL:		// excel down
			sheetObj.SpeedDown2Excel(-1);
			break;
			
		case IBSEARCH_ASYNC01:      // csv down
		    //모든 컬럼 내려받기
			
			var aryCol2 = sheetObjects[0].SaveNameCol(sheetObjects[1].CellValue(1,'coldesc3'));
			for(i=2; i<aryCol.length; i++){
				aryCol2 += "|" + sheetObjects[0].SaveNameCol(sheetObjects[1].CellValue(i,'coldesc3'));
			}			
			sheetObj.Down2Text("US Inland Operation Report", ",", aryCol2, "", "","",true,true,true);
		     break;
		     
		case SEARCH07:      // user가 customizing 한 리포트 항목들을 호출
			formObj.f_cmd.value = SEARCH07;
			sheetObj.DoSearch4Post("ESD_SCE_0057GS.do", SceFrmQryString(formObj));
			
			colSetting();
						
			break;
			
		   }
	
		}

function sheet1_OnSaveEnd(sheeObj,ErrMsg){

}
  
  
/**
 * ?? ????? ?? ????? ???? ??
 */
function validateForm(sheetObj,formObj,sAction){
	var result = true ;
	
	switch (sAction) {
		case IBSEARCH:

			// 필수입력 체크
			if(!chkEssItems(formObj)){
            		result = false ;

			}
			// 날짜형식 체크
			else if(!ComIsEmpty(formObj.fm_dt)&&!ComIsEmpty(formObj.to_dt)){
				if(!ComIsDate(formObj.fm_dt)){
			        ComShowCodeMessage("SCE90003","Date") ;
			        formObj.fm_dt.focus() ;
			        result = false ;
			    }
			    else if(!ComIsDate(formObj.to_dt)){
			        ComShowCodeMessage("SCE90003","Date") ;
			        formObj.to_dt.focus() ;
			        result = false ;
			    }
				if((ComParseInt(ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value)) > 30) ){
                    ComShowMessage("The period of Date is limited to 31 days.");    //[CHM-201220786] 날짜 조회범위 변경 7 -> 10
                    result = false;
				}
			}
			break;
		case MODIFY:
			var totalRow = sheetObj.RowCount +2;
			var chkCount = 0;
			    for( i = 0 ; i < totalRow ; i++){
			    	 if (sheetObj.CellValue(i, "chk") == "1"){
			      		 if (sheetObj.CellValue(i ,"vndr_seq") != "119993"){
			    			 chkCount++;
			    		 }
			    	 }
			    }
		      if (chkCount > 0 ) {
			    	ComShowMessage("324 EDI only can be available to BNSF(S/P : 119993).");
			    	result = false;
			    }
			break;
		default:
			break;
	}



	return result ;
}

function chkEssItems(formObj){
	var result = true ;
	if(ComIsEmpty(formObj.fm_dt)){
	   if(!ComIsEmpty(formObj.s_vvd)&&!ComIsEmpty(formObj.s_pol_pod)){

	   }else{
    		ComShowCodeMessage("TES24016") ;
    		formObj.fm_dt.focus() ;
    		result = false ;
	   }
	}
	else if(ComIsEmpty(formObj.to_dt)&&(ComIsEmpty(formObj.s_vvd)||ComIsEmpty(formObj.s_pol_pod))){
	   if(!ComIsEmpty(formObj.s_vvd)&&!ComIsEmpty(formObj.s_pol_pod)){

	   }else{
    		ComShowCodeMessage("TES24016") ;
    		formObj.to_dt.focus() ;
    		result = false ;
	   }
	}

	return result  ;
}



function chkDateKind(formObj){
	var result = true ;
	if(!ComIsEmpty(formObj.date_kind)){
		if(!ComIsDate(formObj.fm_dt)){
			ComShowCodeMessage("SCE90003","Date") ;
			formObj.fm_dt.focus() ;
			result = false ;
		}
		else if(!ComIsDate(formObj.to_dt)){
			ComShowCodeMessage("SCE90003","Date") ;
			formObj.to_dt.focus() ;
			result = false ;
		}
	}

	return result ;
}

function chgDateKind(val){
	var formObj = document.form ;
	if(val==""){
		formObj.fm_dt.value    = "" ;
		formObj.to_dt.value    = "" ;
		formObj.fm_dt.readOnly = true ;
		formObj.to_dt.readOnly = true ;
	}
	else{
		formObj.fm_dt.readOnly = false ;
		formObj.to_dt.readOnly = false ;
	}
}

//function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
//	var formObj = document.form ;
//	selectVal = SceFrmQryString(formObj);
//	//alert("selectVal:"+selectVal+" PageNo:"+PageNo);
//	sheetObj.DoSearch4Post("ESD_SCE_0056GS.do", selectVal, "cur_page=" + PageNo, true);
//}

function goESD_SCE_0044(sheetObj){
		var row = sheetObj.SelectRow  ;
		if(row < 0){
			ComShowCodeMessage("SCE90018");
  		return ;
  	}
		var cntrNO      = sheetObj.CellValue(row, "cntr_no") ;
    var tpszCd      = sheetObj.CellValue(row, "tpsz") ;
//		alert(cntrNO + "   " + tpszCd);
  	newForm  = "<form name='form1' method='post'>" ;
		newForm += "  <input type='hidden' name='cntr_no' value='" + cntrNO + "'>" ;
		newForm += "  <input type='hidden' name='tpsz_cd' value='" + tpszCd + "'>" ;
    newForm += "</form>";
		
    
    
    document.all.new_form.innerHTML = newForm ;

    var formObj = document.form1 ;
    var paramUrl = "cntr_no="+cntrNO+"&tpsz_cd="+tpszCd;
    var newWin = window.showModalDialog("ESD_SCE_0044.do?"+paramUrl, "clm_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:525px");
		//var newWin  = window.open("","clm_win", "width=771,height=525," + getCenterXY(755, 500));
//    var newWin  = window.open("","clm_win", "width=800,height=525," + getCenterXY(screen.width, 500));
//    //var newWin  = window.open("ESD_SCE_0044.do?cntr_no="+cntrNO+"&tpsz_cd="+tpszCd,"'clm_win', width=800,height=525," +getCenterXY(screen.width, 500));
//    formObj.action = "ESD_SCE_0044.do" ;
//    formObj.target = "clm_win" ;
//    formObj.submit() ;

	    //newWin.focus() ;

}

function getCenterXY(w, h){

	var height = screen.availHeight ;
	var width = screen.availWidth ;

	var leftpos = width/2 - w/2;
	var toppos = height/2 - h/2;
	if(leftpos<0) leftpos=0;
	if(toppos<0) toppos=0;

	return "left=" + leftpos + ", top=" + toppos ;
}

function openColumnList(){
	var formObject = document.form;
	//var edi_grp_cd = toUpperCase(formObject.cs_grp_id.value);
	//window.open ("ESD_SCE_0057.do?edi_grp_cd=" + edi_grp_cd , "list", "scrollbars=no,fullscreen=no,width=765,height=450");

//	window.open ("ESD_SCE_0057.do" , "list", "scrollbars=no,fullscreen=no,width=800,height=360");
	var newWin = window.showModalDialog("ESD_SCE_0057.do", window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:360px");

}


/** 
 * unmatch flag='Y' fontcolor=red
*/
function sheet1_OnSearchEnd(sheetObj,ErrMsg)
  {
      var rowCount  = sheetObj.RowCount;
		var routFlag = '';

		for(i=0+parseInt(sheetObj.HeaderRows);i<rowCount+parseInt(sheetObj.HeaderRows);i++){
			routFlag = sheetObj.CellValue(i, "unmatch_flg");
			if(routFlag=='Y' ){
//				sheetObj.RangeBackColor(i, 1, i, 68)  = sheetObj.RgbColor(255,0, 0);
				sheetObj.RowBackColor(i)  = sheetObj.RgbColor(255, 0, 0);
				for(var j=1; j<68; j++) // sheet의 cell 전체갯수에 대한 ibsheet 상수가 있는지(?)
					sheetObj.CellFont("FontSize", i, j) = 9;
			} 
		}
		
		sheetObj.CheckAll2("chk") = 1; 
  }

 /** 
  * unmatch flag='Y' fontcolor=red
 */
 function sheet1_OnChange(sheetObj , Row, Col, Val){
 
	   if(sheetObj.ColSaveName(Col) == "chk"){
		   
		   if (sheetObj.CellValue(Row, "chk") == "1"){
			   sheetObj.RowStatus(Row) ='U';
		   }else {
			   sheetObj.RowStatus(Row) ='';
		   }
	   }
 		
   }


 function do_railroad(obj) {
		if( obj == "R" ) {
			document.form.combo_svc_provider.style.visibility = "visible";
			document.form.trsp_so_vndr_no.style.visibility = "visible";
			document.form.btns_vender.style.visibility = "visible";
			document.form.sel_railroad.style.visibility = "hidden";	
			document.all.item("SV")[0].style.display = "inline";
			document.all.item("SV")[1].style.display = "none"			
		} else {
			document.form.combo_svc_provider.style.visibility = "hidden";
			document.form.trsp_so_vndr_no.style.visibility = "hidden";
			document.form.btns_vender.style.visibility = "hidden";
			document.form.sel_railroad.style.visibility = "visible";
			document.all.item("SV")[0].style.display = "none";
			document.all.item("SV")[1].style.display = "inline"		
		}
	}

 /**
  * rep_commodity팝업호출
  */
 function rep_OnPopupClick() {
 	var formObject = document.form;
 	var cmdt_cd_val ="";   //향후 사용가능 예정변수
 	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
 	var cmdt_desc_val ="";   //향후 사용가능 예정변수
 	var classId ="getCOM_ENS_rep";
 	var xx1="";  //CONTI
 	var xx2="";  //SUB CONTI
 	var xx3="";  //COUNTRY
 	var xx4="";  //STATE
 	var xx5="";  //CONTROL OFFIC
 	var xx6="";  //LOC CODE
 	var xx7="";  //LOC NAME
 	var xx8="";
 	var xx9="";

 	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
 	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
// 	ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 772, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
 }

 /**
  * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
  */
 function getCOM_ENS_rep(rowArray) {
 	var formObj = document.form;
 	for(var i=0; i<rowArray.length; i++) {
 		var colArray = rowArray[0];
 		var colArray2 = colArray[2];
 		var colArray3 = colArray[3];
 		var colArray4 = colArray[4];

 		formObj.combo_svc_provider.value =colArray2;
 		formObj.trsp_so_vndr_no.value = colArray4;
 	}
 }
 
// BKG_NO, BL_NO, CNTR_NO 입력 받는 메소드(POP UP 에서 호출한다.)
    function openAddPaste(dist){
    	var formObject = document.form;
    	var s_neweq_office = formObject.s_neweq_office.value;
    	
//    	var bkg_no = formObject.bkg_no_.value;
//    	var bl_no = formObject.bl_no_.value;
//    	var vvd = formObject.vvd.value;
    //	window.open ("ESD_SCE_0064.do?dist="+dist+"&cntr_no="+cntr_no, "list", "scrollbars=no,resizable=yes,fullscreen=no,width=400,height=380");
    	if (dist == 's_neweq_office' | dist == 's_rail_dest'){
    		var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
        }else {
        	var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
        }
//    	else if(dist == 'bkg_no_') {
//    		var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist+"&dest_no="+bkg_no, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
//        }else if(dist == 'bl_no_' ){
//    		var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist+"&dest_no="+bl_no, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
//        }else if(dist == 'vvd'){
//    		var newWin = window.showModalDialog("ESD_SCE_0064.do?dist="+dist+"&dest_no="+vvd, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
//        }
    	
    }
    
function addValueNo(dist, multi_value){
    	var multis = multi_value.split('\n');
     	multi_value = '';
    	for(var i = 0 ; i < multis.length ; i++){
    		if(multis[i] != ''){
    			//cntr_no에서 호출하는 경우와 bl_no에서 호출하는경우를 분기를 함
    			if (dist == 'cntr_no_'){
    				if(i == 0){
    					multi_value = CheckDigitSplit1(multis[i]);
    				}else{
    						multi_value = multi_value + ',' + CheckDigitSplit1(multis[i]);
    				}
    			}else{
    				if(i == 0){
    					multi_value = multis[i];
    				}else{
    					multi_value = multi_value + ',' + multis[i];
    				}
    			}
	   		}
    	}
    	if(multi_value != ''){
//    		if(document.getElementById(dist).value != ''){
//    			document.getElementById(dist).value = document.getElementById(dist).value + ',' + multi_value;
//    		}else{
                if (dist == 'cntr_no_'){
    			document.getElementById(dist).value = multi_value;
    			document.getElementById("cntr_no_nonbit").value = multi_value;
    			document.getElementById("cntr_no_split").value = "";
                }else {
                document.getElementById(dist).value = multi_value;	
                }
    			
//    		}
    	}
    	
}
 
//Service Provider
 function  vender_blur(){

 	var formObj = document.form;
 	var lvobj = formObj.combo_svc_provider.value;
 	var error_val = "";

 	if(lvobj !=""){
 		for (var i = 0; i < lvobj.length; i++) {
 			var oneChar = lvobj.charAt(i);
 			if (oneChar != "") {
 				if (  (oneChar >= "0" && oneChar <= "9" )  ){
 				}else {
 					error_val ="Y";
 					break;
 				}
 			}
 		}
 		if(error_val !="Y" ) {
 			//vender value값을 가져온다(SHEET1)
 			formObj.f_cmd.value = SEARCH05;
 			sheetObjects[0].DoSearch4Post("ESD_SCE_0056GS.do", SceFrmQryString(formObj));

 			//1개의 파라미터의 값을 조회후 가져온다.
 			var x1 = sheetObjects[0].EtcData('VNDR_NM');
 		
 			if(x1 !="" || x1 !="undefined") {
 				formObj.trsp_so_vndr_no.value =x1;
 			} else {
 				errMsg = ComGetMsg("TRS90076");
 				ComShowMessage(errMsg);
 				formObj.combo_svc_provider.focus();
 				formObj.trsp_so_vndr_no.value ="";
 			}
 		} else {
 			errMsg = ComGetMsg("TRS90076");
 			ComShowMessage(errMsg);
 			formObj.combo_svc_provider.focus();
 			formObj.trsp_so_vndr_no.value ="";
 		}
 	} else {
 		formObj.trsp_so_vndr_no.value ="";
 	}
 }
 
	 
	function changeCostDiv(val){
		var formObj = document.form ;
	 
		doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
	}
	/**
	* 화면 폼입력값에 Null Check
	*/
	function isNull(itemValue){
	   if(itemValue==null || itemValue=="" || itemValue=="undefined"){
	   	return true;
	   }
	   else{
	   	return false;
	   }
	}
	
	function s_pol_pod_OnCheckClick(comboObj, index, code) {
		if( code == "ALL" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = true;
				s_pol_pod_gen();
			} else{
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = true;
				s_pol_pod_gen();
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function s_neweq_office_OnCheckClick(comboObj, index, code) {
		if( code == "ALL" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = true;
				s_neweq_office_gen();
			} else{
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = true;
				s_neweq_office_gen();
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function s_neweq_office_gen(){
	
		comboObjects[0].UseCode = false;
		
		var cmbCnt = comboObjects[0].GetCount();
		var tmpEqOfc = "";
		var eqOfc = "";
		
		for( i = 1 ; i < cmbCnt ; i++){
			tmpEqOfc = comboObjects[0].GetText(i,0);
			
			if( i == cmbCnt - 1){
				eqOfc = eqOfc + tmpEqOfc;
			}else{
				
				eqOfc = eqOfc + tmpEqOfc + ",";
			}
			
		}
		comboObjects[0].UseCode = true;
		document.form.eqmt_ofc.value = eqOfc;
	}
	
	function s_pol_pod_gen(){
	
		comboObjects[1].UseCode = false;
		
		var cmbCnt = comboObjects[1].GetCount();
		var tmpPortCd = "";
		var portCd = "";
		
		for( i = 1 ; i < cmbCnt ; i++){
			tmpPortCd = comboObjects[1].GetText(i,0);			
			if( i == cmbCnt - 1){
				portCd = portCd + tmpPortCd;
			}else{			
				portCd = portCd + tmpPortCd + ",";
			}		
		}
		comboObjects[1].UseCode = true;
		document.form.port_cd.value = portCd;
	}
	
	/**
     * user별로 등록된 컬럼값 호출
     */
	function colSetting(){
		for(i=1; i<=sheetObjects[1].RowCount; i++)
			aryCol[i] = sheetObjects[1].CellValue(i, "coldesc2");			
	}
	/**
     * sheet에 customized된 항목만 display
     */
	function colHidnSetting(){
		for(var k = 2; k <sheetObjects[0].LastCol ; k++)
			sheetObjects[0].ColHidden(k)= true;

		for(var j = 1; j <aryCol.length; j++)
			sheetObjects[0].ColHidden(sheetObjects[1].CellValue(j, "coldesc3")) = false;
		
	}
