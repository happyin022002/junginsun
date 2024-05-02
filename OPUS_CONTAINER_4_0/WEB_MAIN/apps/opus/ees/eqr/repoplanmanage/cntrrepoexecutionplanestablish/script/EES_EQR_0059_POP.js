/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0059_POP
*@FileTitle  :  Create
*@author     : CLT
*@version    : 1.0
*@since      : 2015/09/07
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
//var tpszValue = "D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4";
var tpszValue = "";
var localopener=window.dialogArguments;
if (!localopener) localopener=window.opener;  //이 코드 추가할것
if (!localopener) localopener=parent; //이 코드 추가할것

consTpszArr  = null;
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
	 /***** Adding additional sheet variables to use more than one sheet per a tab *****/
	var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_select":
				var hRow=sheetObjects[0].HeaderRows();
				var checkYN ="N";
				for (var row=hRow; row <= sheetObjects[0].RowCount()+1; row++) {
					if(sheetObjects[0].GetCellValue(row,"ibcheck") == 1){
						checkYN = "Y";
						break;
					}					
				}    
				
				if(checkYN == "Y") {
					comPopupOK_Preset(sheetObjects[1],formObject);
				}else{
					ComShowCodeMessage("EQR90063");
					return false;
				}
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}



/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}


/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	tpszValue = form.tpsz_value.value;
	
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}	
	
	
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}


/**
      * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
	var formObj=document.form;
}


/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
            var HeadTitle0="Sel|Priority|ORG.LOC|Node|DEST.LOC|Node|ROUTE||ETD|ETA|Purpose|CNTR No.|Total Vol|" ;
            var HeadTitle1="Sel|Priority|ORG.LOC|Node|DEST.LOC|Node|ROUTE||ETD|ETA|Purpose|CNTR No.|Total Vol|" ;
            consTpszArr = tpszValue.split(',');
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Vol.|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}
			
			for ( var i = 1; i <= 7; i++) {
				HeadTitle0 = HeadTitle0 + "|";
				HeadTitle1 = HeadTitle1 + "|";
			}
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"}  ];
            
                       
            InitHeaders(headers, info);
            var cols = [ {Type:"Radio", Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
            {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prio_seq",                 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_loc",                  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_loc_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc",                 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc_type",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",      Hidden:0,  Width:420,   Align:"Left",  ColMerge:0,   SaveName:"route",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",  ColMerge:0,   SaveName:"past_repo_pln_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, DefaultValue:"Y"},
            {Type:"Text",		Hidden:0,	Width:80,	Align:"Center", ColMerge:0,	SaveName:"fm_etd_dt",					KeyField:0,	 CalcLogic:"",	Format:"",			  PointCount:0,	UpdateEdit:0,	InsertEdit:1,	EditLen : 7},
            {Type:"Text",		Hidden:0,	Width:80,	Align:"Center", ColMerge:0,	SaveName:"to_eta_dt",					KeyField:0,	 CalcLogic:"",	Format:"",			  PointCount:0,	UpdateEdit:0,	InsertEdit:1,	EditLen : 7},
            {Type:"Combo",	Hidden:0,	Width:90,	Align:"Center",	ColMerge:1,		SaveName:"eq_repo_purp_cd",		KeyField:0,	 CalcLogic:"",	Format:"",			  PointCount:0,	UpdateEdit:1,	InsertEdit:1,	EditLen : 15}, 
            {Type:"Image",	Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,		SaveName:"cntrimage",					KeyField:0,	 CalcLogic:"",	Format:"",			  PointCount:0,	UpdateEdit:1,	InsertEdit:1,	EditLen : 9},
            {Type:"Int",		Hidden:0,	Width:70,	Align:"Right",	ColMerge : 1,SaveName : "totalvol",KeyField : 0,CalcLogic : "",Format : "Integer",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 11} ];
			
            for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({Type : "Int",Hidden : 0,Width : 60,Align : "Right",ColMerge : 0,SaveName : "vol" + consTpszArr[i],KeyField : 0,CalcLogic : "",Format : "Integer",PointCount : 0,UpdateEdit : 1,InsertEdit : 1,EditLen : 6});
			}
			
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n1st_nod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n2nd_nod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n3rd_nod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n4th_nod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n5th_nod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n6th_nod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n7th_nod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n1st_trsp_mod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n2nd_trsp_mod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n3rd_trsp_mod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n4th_trsp_mod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n5th_trsp_mod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n6th_trsp_mod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "n7th_trsp_mod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 7});
			
			cols.push({Type : "Text",Hidden : 1,Width : 60,Align : "Right",ColMerge : 0,SaveName : "cntrno",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0});
			cols.push({Type : "Text",Hidden : 1,Width : 40,Align : "Left",ColMerge : 0,SaveName : "cntrdel",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 1,InsertEdit : 1});
			cols.push({Type : "Text",Hidden : 1,Width : 40,Align : "Left",ColMerge : 0,SaveName : "tpszno",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 1,InsertEdit : 1});
			
			InitColumns(cols);

			SetEditable(1);
			SetImageList(0, "/opuscntr/img/button/btns_cntrinput.gif");
			SetImageList(1, "/opuscntr/img/button/btns_cntrinput_c.gif");
			
            resizeSheet();
            //SetEditable(1);
            SetColProperty("eq_repo_purp_cd", {ComboText : purposeText,ComboCode : purposeCode});
            //SetColProperty("cntr_image", {Image : "/opuscntr/img/button/btns_cntrinput.gif"});
           // SetImageList(0, "/opuscntr/img/button/btns_cntrinput.gif");// data0,CNTRNOexists
			//SetImageList(1, "/opuscntr/img/button/btns_cntrinput_c.gif");// data1,CNTRNOdoesn'texists
			//SetEditable(1);
			SetShowButtonImage(3);// in case of editable, showin combo &
		   }
			break;
			
		case 2:      //sheet1 init
			with (sheetObj) {
            var HeadTitle0="Sel|Priority|ORG.LOC|DEST.LOC|ETD|ETA|Purpose|CNTR No.|Total Vol|" ;
            var HeadTitle1="Sel|Priority|ORG.LOC|DEST.LOC|ETD|ETA|Purpose|CNTR No.|Total Vol|" ;
            consTpszArr = tpszValue.split(',');
			for (i = 0; i < consTpszArr.length; i++) {
				HeadTitle0 = HeadTitle0 + "Vol.|";
				HeadTitle1 = HeadTitle1 + consTpszArr[i] + "|";
			}
			HeadTitle0 = HeadTitle0 + "||";
			HeadTitle1 = HeadTitle1 + "||"; 
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"}  ]; 
            
            InitHeaders(headers, info);
            var cols = [ {Type:"CheckBox", Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
            {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prio_seq",                 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fm_yd_cd",                  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_yd_cd",                 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            {Type:"Text",		Hidden:0,	Width:80,	Align:"Center", ColMerge:0,	SaveName:"fm_etd_dt",					KeyField:0,	 CalcLogic:"",	Format:"",			  PointCount:0,	UpdateEdit:0,	InsertEdit:1,	EditLen : 7},
            {Type:"Text",		Hidden:0,	Width:80,	Align:"Center", ColMerge:0,	SaveName:"to_etd_dt",					KeyField:0,	 CalcLogic:"",	Format:"",			  PointCount:0,	UpdateEdit:0,	InsertEdit:1,	EditLen : 7},
            {Type:"Combo",	Hidden:0,	Width:90,	Align:"Center",	ColMerge:1,		SaveName:"eq_repo_purp_cd",		KeyField:0,	 CalcLogic:"",	Format:"",			  PointCount:0,	UpdateEdit:1,	InsertEdit:1,	EditLen : 15}, 
            {Type:"Image",	Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,		SaveName:"cntrimage",					KeyField:0,	 CalcLogic:"",	Format:"",			  PointCount:0,	UpdateEdit:1,	InsertEdit:0,	EditLen : 9},
            {Type : "Int",Hidden : 0,Width : 70,Align : "Right",ColMerge : 1,SaveName : "totalvol",KeyField : 0,CalcLogic : "",Format : "Integer",PointCount : 0,UpdateEdit : 0,InsertEdit : 0,EditLen : 11} ];
			for ( var i = 0; i < consTpszArr.length; i++) {
				cols.push({Type : "Int",Hidden : 0,Width : 60,Align : "Right",ColMerge : 0,SaveName : "vol" + consTpszArr[i],KeyField : 0,CalcLogic : "",Format : "Integer",PointCount : 0,UpdateEdit : 1,InsertEdit : 1,EditLen : 6});
			}
			
			cols.push({Type : "Text",Hidden : 0,Width : 60,Align : "Right",ColMerge : 0,SaveName : "past_repo_pln_flg",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0, DefaultValue:"Y"});
			cols.push({Type : "Text",Hidden : 0,Width : 60,Align : "Right",ColMerge : 0,SaveName : "trsp_mod_cd",KeyField : 0,CalcLogic : "",Format : "",PointCount : 0,UpdateEdit : 0,InsertEdit : 0});
			
			
            InitColumns(cols);
            SetSheetHeight(200);
            SetColProperty("eq_repo_purp_cd", {ComboText : purposeText,ComboCode : purposeCode});
            SetEditable(1);
            SetVisible(0);
		   }
			break;
	}
}


//calcuating sub total after retrieve
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObject=document.form;
	var fm_etd_dt = formObject.fm_etd_dt.value;
	var to_eta_dt = formObject.to_eta_dt.value;
	
	var hRow=sheetObjects[0].HeaderRows();
	for (var row=hRow; row <= sheetObjects[0].RowCount()+1; row++) {
		
		sheetObj.SetCellValue(row, "cntrimage", "1", 0);// cntr
		sheetObj.SetCellValue(row, "fm_etd_dt", fm_etd_dt, 0);// 	
		sheetObj.SetCellValue(row, "to_eta_dt", to_eta_dt, 0);// 	
	}    
	ComOpenWait(false);
}



/**
 * handling click event on sheet1.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col, Value){
	var formObject=document.form;
	if (sheetObj.ColSaveName(Col) == "ibcheck") {
		if(sheetObj.GetCellValue(Row,Col) == "1") {
			sheetObjects[1].RemoveAll();
			var row_Insert = "";
			consTpszArr = tpszValue.split(',');
			var strTrspModCd = "";
			var strTrspModNm = "";
			for(var i=1; i<=7; i++) {
				if(sheetObj.GetCellValue(Row,29 + i) != "" && sheetObj.GetCellValue(Row,30 + i) != "") {
					row_Insert = sheetObjects[1].DataInsert();
					
					sheetObjects[1].SetCellValue(row_Insert,"prio_seq", sheetObj.GetCellValue(Row,"prio_seq"));
					sheetObjects[1].SetCellValue(row_Insert,"eq_repo_purp_cd", sheetObj.GetCellValue(Row,"eq_repo_purp_cd"));
					sheetObjects[1].SetCellValue(row_Insert,"totalvol", sheetObj.GetCellValue(Row,"totalvol"));
					
					for ( var j = 0; j < consTpszArr.length; j++) {
						sheetObjects[1].SetCellValue(row_Insert,"vol" + consTpszArr[j], sheetObj.GetCellValue(Row,"vol" + consTpszArr[j]));
					}
					
					sheetObjects[1].SetCellValue(row_Insert,"fm_yd_cd", sheetObj.GetCellValue(Row,29 + i));
					sheetObjects[1].SetCellValue(row_Insert,"to_yd_cd", sheetObj.GetCellValue(Row,30 + i));
					
					strTrspModNm = sheetObj.GetCellValue(Row,36 + i);
					
					if(strTrspModNm.substr(0,1) == "R") {
						strTrspModCd = "R";
					}else if(strTrspModNm.substr(0,1) == "T"){
						strTrspModCd = "T";
					}else{
						strTrspModCd = "W";
					}
					
					sheetObjects[1].SetCellValue(row_Insert,"trsp_mod_cd", strTrspModCd);
					
					sheetObjects[1].SetCellValue(row_Insert,"ibcheck", "1");
				}
			}
		}else{
			sheetObjects[1].RemoveAll();
		}
	}
	
	// CNTR NO POPUP이동
	if (sheetObj.ColSaveName(Col) == "cntrimage") { // cntr input image cell
		var name = sheetObj.GetCellValue(Row, Col);
		// hidden value setting
		var view = false;
			
		document.form.cntrno.value = sheetObj.GetCellValue(Row, "cntrno");
		
		var cntr_all = "";
		// for(var i=0; i<arRow.length-1; i++) {
		//for(var i=1; i<=7; i++) {
			//if (sheetObj.GetCellValue(Row, "cntrno").length > 5){
				//cntr_all = cntr_all+ sheetObj.GetCellValue(Row, "cntrno");
			//}
		//}
		
		cntr_all = cntr_all+ sheetObj.GetCellValue(Row, "cntrno");
		cntr_all = cntr_all.substr(0,cntr_all.length-1);
		document.form.cntrno_all.value = cntr_all;
		oldValue = 0; // oldvalue initializing
		var url = "EES_EQR_0094.do" + "?f_cmd=-1" // DEFAULT
				+ "&repoplan_id="
				+ "&targetSheet=1" + "&targetRow=" + Row ;
				
		ComOpenWindowCenter(url, "EES_EQR_0094", 800, 570, true);
	}
}


function settingValue(cntrno, tpszno, targetSheet, targetRow) {
	 if (targetSheet == 1) {
		if (cntrno == "" && tpszno == "") {
			sheetObjects[0].SetCellValue(targetRow, "cntrdel", "Y", 0);
			cntrno = "xxx";
			tpszno = "xxx";
		} else {
			sheetObjects[0].SetCellValue(targetRow, "cntrdel", "", 0);
		}
		
		consTpszArr = tpszValue.split(",");
		var arrTpszNo = tpszno.split(",");
		
		for ( var j = 0; j < consTpszArr.length; j++) {
			sheetObjects[0].SetCellValue(targetRow,"vol" + consTpszArr[j], "0");
		}
		
		for ( var j = 0; j < consTpszArr.length; j++) {
			var tpCnt = 0;
			for(var i=0; i < arrTpszNo.length; i++) {
				
				if(consTpszArr[j] == arrTpszNo[i]) {
					tpCnt = tpCnt + 1;
				}
			}				
			sheetObjects[0].SetCellValue(targetRow,"vol" + consTpszArr[j], tpCnt);
		}
		
		sheetObjects[0].SetCellValue(targetRow, "cntrno", cntrno);
		sheetObjects[0].SetCellValue(targetRow, "tpszno", tpszno);

	} 
}

/**
 * handling click event on sheet1.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObject=document.form;
	if (sheetObj.ColSaveName(Col).substring(0, 3) == "vol") {
		consTpszArr = tpszValue.split(',');
		var allVolTotal = 0;
		for ( var j = 0; j < consTpszArr.length; j++) {
			allVolTotal = allVolTotal + Number(sheetObj.GetCellValue(Row, "vol" +consTpszArr[j]));
		}
		sheetObj.SetCellValue(Row, "totalvol", allVolTotal);// onchange
	}
	
	sheet1_Change(sheetObj, Row, Col, Value);
	
}



/**
 * handling click event on sheet1.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_Change(sheetObj, Row, Col, Value){
	var formObject=document.form;
	if (sheetObj.GetCellValue(Row,"ibcheck") == "1") {
		sheetObjects[1].RemoveAll();
		var row_Insert = "";
		consTpszArr = tpszValue.split(',');
		for(var i=1; i<=7; i++) {
			
			if(sheetObj.GetCellValue(Row,29 + i) != "" && sheetObj.GetCellValue(Row,30 + i) != "") {
				row_Insert = sheetObjects[1].DataInsert();
				
				sheetObjects[1].SetCellValue(row_Insert,"prio_seq", sheetObj.GetCellValue(Row,"prio_seq"));
				sheetObjects[1].SetCellValue(row_Insert,"eq_repo_purp_cd", sheetObj.GetCellValue(Row,"eq_repo_purp_cd"));
				sheetObjects[1].SetCellValue(row_Insert,"totalvol", sheetObj.GetCellValue(Row,"totalvol"));
				
				for ( var j = 0; j < consTpszArr.length; j++) {
					sheetObjects[1].SetCellValue(row_Insert,"vol" + consTpszArr[j], sheetObj.GetCellValue(Row,"vol" + consTpszArr[j]));
				}
				
				strTrspModNm = sheetObj.GetCellValue(Row,36 + i);
				
				if(strTrspModNm.substr(0,1) == "R") {
					strTrspModCd = "R";
				}else if(strTrspModNm.substr(0,1) == "T"){
					strTrspModCd = "T";
				}else{
					strTrspModCd = "W";
				}
				
				sheetObjects[1].SetCellValue(row_Insert,"trsp_mod_cd", strTrspModCd);
				
				sheetObjects[1].SetCellValue(row_Insert,"fm_yd_cd", sheetObj.GetCellValue(Row,29 + i));
				sheetObjects[1].SetCellValue(row_Insert,"to_yd_cd", sheetObj.GetCellValue(Row,30 + i));
				sheetObjects[1].SetCellValue(row_Insert,"ibcheck", "1");
			}
		}
	}else{
		sheetObjects[1].RemoveAll();
	}
}


function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(validateForm(sheetObj,formObj,sAction))	
			ComOpenWait(true);					
			formObj.f_cmd.value=SEARCHLIST02;
			var xml="";					
 			xml=sheetObj.GetSearchData("EES_EQR_0059GS5.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(xml,{Sync:1} );			
			break;
	}
}


/**
    * Validating inputted values of form
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	}
	return true;
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}


/**
 * setting return value to parent form.
 */
function comPopupOK_Preset(sheetObj,formObject) {
	var formObj=document.form;	
	var hRow=sheetObjects[1].HeaderRows();	
	var selRow = ""; 
	var row= ""; 
	var rowNum = 1;
	var planNum = 0;
	var consTpszArr = tpszValue.split(',');
	
	selRow = sheetObjects[0].GetSelectRow();
	for (var row=hRow; row <= sheetObjects[1].RowCount() + 1; row++) {
		if(sheetObjects[1].GetCellValue(row,"ibcheck") == 1){
			opener_selRow = localopener.sheetObjects[1].GetSelectRow(); // selected ROW
			//opener_row = localopener.sheetObjects[1].DataInsert(opener_selRow+1);
			if(row==hRow) {
				planNum = opener_selRow;
			}
			
			opener_row = Number(opener_selRow) +1 ;
			
			localopener.getPopUp(opener_row, planNum);
			
			localopener.sheetObjects[1].SetCellValue(opener_row,"t2_past_repo_pln_flg", sheetObjects[1].GetCellValue(row, "past_repo_pln_flg"));
			localopener.sheetObjects[1].SetCellValue(opener_row,"t2_fm_yd_cd", sheetObjects[1].GetCellValue(row, "fm_yd_cd"));			
			localopener.sheetObjects[1].SetCellValue(opener_row,"t2_to_yd_cd", sheetObjects[1].GetCellValue(row, "to_yd_cd"));
			localopener.sheetObjects[1].SetCellValue(opener_row,"t2_eq_repo_purp_cd", sheetObjects[1].GetCellValue(row, "eq_repo_purp_cd"));
						
			var cntrno = sheetObjects[0].GetCellValue(selRow, "cntrno")
			var tpszno = sheetObjects[0].GetCellValue(selRow, "tpszno")
			
			if(cntrno != "" && tpszno != "") {
				localopener.settingValue(cntrno, tpszno, "2", opener_row);
			}
			
			for ( var i = 0; i < consTpszArr.length; i++) {
				localopener.sheetObjects[1].SetCellValue(opener_row, "t2_vol" + consTpszArr[i], sheetObjects[1].GetCellValue(row, "vol" + consTpszArr[i]));
			}
			
			localopener.sheetObjects[1].SetCellValue(opener_row,"t2_totalvol", sheetObjects[1].GetCellValue(row, "totalvol"));
			
			localopener.sheetObjects[1].SetCellValue(opener_row,"t2_trsp_mod_cd", sheetObjects[1].GetCellValue(row, "trsp_mod_cd"));
			
			rowNum = Number(rowNum) +1;
		}					
	}    
	
	ComClosePopup(); 
}   
