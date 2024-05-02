/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESD_TRS_0076.js
*@FileTitle  : USA Last City for T&E Cargo
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/*------------------From here the common JavaScript function is defined.     ------------------*/
//Common global variable
var curTab=1;
var beforetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
//Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;
//Button to process certain filename, separated on a quarterly event handler to handle */
	function processButtonClick(){
		 var sheetObject=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_new":
					formObject.reset();
					sheetObject.RemoveAll();
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_save":
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
			} // end switch
		}catch(e) {
    		if( e == "[object Error]") {
                errMsg=ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}
	
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		var formObject=document.form;
		doActionIBSheet(sheetObj,formObject,IBSEARCH);
	}
	
	/*
	 * handling of Sheet 
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:      
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_TRS_0076GS.do", TrsFrmQryString(formObj) );
				break;
			case IBSAVE:        
				formObj.f_cmd.value=MULTI;
				//var savexml=sheetObj.DoSave("ESD_TRS_0076GS.do", TrsFrmQryString(formObj),-1,false);
				var savexml=sheetObj.DoSave("ESD_TRS_0076GS.do", {Param:TrsFrmQryString(formObj), Sync:1} );
				//doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;  
			case IBINSERT:	  
				  //The default setting after creation
				  var Row=sheetObj.DataInsert(-1);
				  var ofc_cd = document.form.userOfcCd.value;
				  sheetObj.SetCellValue(Row, 6,document.form.userid1.value.toUpperCase(),0);
//				  sheetObj.SetCellValue(Row, 7,"TAREA",0);
				  sheetObj.SetCellValue(Row, 7,ofc_cd,0);
				  sheetObj.SelectCell(Row, "org_loc_cd");
				  //capitalized value of the value of hidden settings
				  document.form.userid1.value=document.form.userid1.value.toUpperCase();
				  document.form.userid2.value=document.form.userid1.value.toUpperCase();
				break;
			 case IBCOPYROW:       
				sheetObj.DataCopy();
				break;
		}
	}
	/**
	 * Register as an array IBSheet Object
	 * setSheetObject
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * loadPage
	 * After loading in your browser should display the ability to add pre-processing
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		var formObject=document.form;
		var sheetObject=sheetObjects[0];
		doActionIBSheet(sheetObject,formObject,IBSEARCH);		
	}
	 /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //t1sheet1 init
			    with(sheetObj){
		      var formObject=document.form;
		      var HeadTitle="Del.|STS|Seq.|Origin Location|Destination Location|Last USA City|Created User ID|Created Office";

		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delCheck" },
		             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"org_loc_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"dest_loc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"lst_loc_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);

		       SetEditable(1);
		       SetColHidden(1,true);
//		       SetSheetHeight(467);
		       resizeSheet();
		       SetColProperty(0 ,3 , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		       SetColProperty(0 ,4 , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		       SetColProperty(0 ,5 , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      }


				break;
		}
	}
	/**
	 * When clicked, a pop-up event SHEET1
	 */
	function sheet1_OnPopupClick(sheetObj, row, col)
	{
			var formObject=document.form;
			var cmdt_cd_val="";   
			var rep_cmdt_cd_val=""; 
			var cmdt_desc_val="";   
			var classId="getCOM_ENS_051_1";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";
			formObject.hid_row.value=row;   //putting a value to the value hidden row
			formObject.hid_col.value=col;   //putting the value of col value hidden
			//alert(sheetObj.ColSaveName(col));
			
			if ( sheetObj.ColSaveName(col) == "org_loc_cd" ) {
				var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
				ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 772, 500, 'getCOM_ENS_051_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
			}else if ( sheetObj.ColSaveName(col) == "dest_loc_cd" ){
				var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
				ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 772, 500, 'getCOM_ENS_051_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
			}else if ( sheetObj.ColSaveName(col) == "lst_loc_cd" ){
				var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
				ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 772, 500, 'getCOM_ENS_051_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
			}else{
			}
	}
	/**
	 * popSearchPiCommCodeGrid Process handling
	 */
	function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
		var myUrl=getPopupURL(POPUP_PI_COMM);
		var myOption=getPopupOption(POPUP_PI_COMM);
		var url;
if(myWin!=null)  ComClosePopup(); 
		url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
		myWin=window.open(url, "piCommCodePop", myOption);
		myWin.focus();
	}
	/**
	 * Screen form validation process for processing the input values
	 */
	function validateForm(sheetObj,formObj,sAction){
		sheetObj.ShowDebugMsg(false);
		with(formObj){
			switch(sAction) {
			   case IBSEARCH:     
					break;
				case IBSAVE:      
					break;  
				case IBINSERT:	  
					break;
			}
		}
		return true;
	}
	/**
	 * Screen form validation process for processing the input values
	 * Units of the current screen to the correct use is temporarily SHEET11 notateum convert it to a temporary
	 */
	function sheet11_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var formObject=document.form;
		var col_val=OldCol;
		if(col_val==3 || col_val==4 || col_val==5  )
		{
			var x1=sheetObj.GetCellValue(OldRow,OldCol);
			var inputStr=delSpace(x1);
			for (var i=0; i < inputStr.length; i++)
			{
				//if(repeat =="Y"){
				 var oneChar=inputStr.charAt(i)
				 if (oneChar != "")
				 {
					   if ( (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) ){
						   continue;
					   }else {
						   var errMessage=ComGetMsg('COM12127','entered data','','');  
							ComShowMessage(errMessage);
							sheetObj.SelectCell(OldRow, OldCol, true, sheetObj.GetCellValue(OldRow, OldCol));
						   break;
						}
				 }else{
					 break;
				 }
			}
		}
	}
	/**
	 * Screen form validation process for processing the input values
	 */
	function sheet1_OnChange(sheetObj, row , col , val){
		var formObject=document.form;
		var inputStr=delSpace(val);
		var colName=sheetObj.ColSaveName(col);
		for (var i=0; i < inputStr.length; i++)
		{
			 var oneChar=inputStr.charAt(i)
			 if (oneChar != "")
			 {
				   if ( (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" ) ){
					   continue;
				   }else {
					   sheetObj.SetFocusEditMode(-1);
					   sheetObj.FocusStyle=fsHeavy;
					   var errMessage=ComGetMsg('COM12127','entered data','','');  
						ComShowMessage(errMessage);
					   sheetObj.SetCellValue(row,col,"");
					   sheetObj.SelectCell(row,col);
					   break;
					}
			 }else{
				 break;
			 }
		}
		//In a row to prevent entering duplicate the results.
		
		// 2015.04.20 CHAN WOO PARK
		// Del checkbox 클릭이 아닐 경우에만 checkKey 로직 작동
		if (colName != "delCheck") {
			if(!checkKey(sheetObj, row, col)){
			}else{
				switch(colName){
					case 'org_loc_cd':
						var org_loc_cd_check = sheetObj.GetCellValue(row, "org_loc_cd");
						if(org_loc_cd_check !=""){
							formObject.f_cmd.value=SEARCH01;
							var queryString="col=sc_no&row="+row+"&searchStr="+val+"&"+TrsFrmQryString(formObject);
							var sXml = sheetObj.GetSearchData("ESD_TRS_0076_01GS.do",queryString );  
							var cntCd=ComGetEtcData(sXml,"CNT_CD");
							if(!checkLocal(cntCd, row, col)) return;
						}
						break;
					case 'dest_loc_cd':
						var dest_loc_cd_check = sheetObj.GetCellValue(row, "dest_loc_cd");
						if(dest_loc_cd_check !=""){
							formObject.f_cmd.value=SEARCH01;
							var queryString="col=sc_no&row="+row+"&searchStr="+val+"&"+TrsFrmQryString(formObject);
							var sXml = sheetObj.GetSearchData("ESD_TRS_0076_01GS.do",queryString );  
							var cntCd=ComGetEtcData(sXml,"CNT_CD");
							if(!checkLocal(cntCd, row, col)) return;
						}
						break;
					case 'lst_loc_cd':
						var lst_loc_cd_check = sheetObj.GetCellValue(row, "lst_loc_cd");
						if(lst_loc_cd_check !=""){
							formObject.f_cmd.value=SEARCH01;
							var queryString="col=sc_no&row="+row+"&searchStr="+val+"&"+TrsFrmQryString(formObject);
							var sXml = sheetObj.GetSearchData("ESD_TRS_0076_01GS.do",queryString );  
							var cntCd=ComGetEtcData(sXml,"CNT_CD");
							if(!checkLocal(cntCd, row, col)) return;
						}
						break;
				}
			}
		} 
	}
	/**
	 * S / C Number presence of input Check
	 *
	 */
	function checkLocal(value, row, col)
	{
		var formObject=document.form;
		if( value == 0)
		{
			var errMessage=ComGetMsg('COM12114','Local code!','','');
			ComShowMessage(errMessage);
			sheetObjects[0].SetCellValue(row, col, "");
			sheetObjects[0].SelectCell(row, col);
			return false;
		}else{
			sheetObjects[0].SelectCell(row, col+1);
			return true;
		}
	}
	/**
	 * S / C Number presence of input Check
	 *
	 */
	function checkKey(sheetObj, row, col)
	{
		var formObject=document.form;
		var x1=sheetObj.GetCellValue(row, 'org_loc_cd');
		var x2=sheetObj.GetCellValue(row, 'dest_loc_cd');
		var x3=sheetObj.GetCellValue(row, 'lst_loc_cd');
		if( (x1.length >0 && x2.length >0 ) || (x1.length >0 && x3.length >0 ) || (x2.length >0 && x3.length >0 ) ){
			if( x1 == x2 ){
				var errMessage=ComGetMsg('COM12114','Location data!','','');  
				ComShowMessage(errMessage);				
				sheetObj.SelectCell(row, 'dest_loc_cd');
				sheetObj.SetCellValue(row,'dest_loc_cd',"", 0);
				return false;	
			}
			// 2015.06.11	CHAN WOO PARK
			// US AMS : B/L Inquiry에서 L.USA 칼럼 사용 중 충돌로 validation 제거
			/*
			else if( x1 == x3 ){
				var errMessage=ComGetMsg('COM12114','Location data!','','');  
				ComShowMessage(errMessage);				
				sheetObj.SelectCell(row, 'lst_loc_cd');
				sheetObj.SetCellValue(row,'lst_loc_cd',"", 0);
				return false;	
			}
			*/
			else if( x2 == x3 ){
				var errMessage=ComGetMsg('COM12114','Location data!','','');  
				ComShowMessage(errMessage);				
				sheetObj.SelectCell(row, 'lst_loc_cd');
				sheetObj.SetCellValue(row,'lst_loc_cd',"", 0);
				return false;	
			}else{
				return true;
			}
		}else{
			return true;
		}
	}
	/**
	 * Check whether the pure English
	 */
	function isAlpha(obj,gubun,s1)
	{
	  var formObject=document.form;		
	  var inputStr=delSpace(obj);
	  for (var i=0; i < inputStr.length; i++)
	  {
		 var oneChar=inputStr.charAt(i)
		 if (oneChar != "")
		 {
		   if ( (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) ){
		   }else {
			   sheetObjects[0].SetFocusEditMode(-1);
			   sheetObjects[0].SetCellFontUnderline(gubun,3,1);
			   sheetObjects[0].FocusStyle=fsSolid;
			   sheetObjects[0].SelectCell(gubun, s1)
			   return false;
			   break;
			 }
		 }else{
			 break;
		 }
	   }
	}
	/**
	 * Remove spaces from a string
	 */
	function delSpace(str)
	{
		var trimstr=str;
		for (var i=0; i< str.length;i++)
		{
			trimstr=trimstr.replace(' ' ,'');
		}
		return trimstr;
	}
	/**
	 * Initialize the set IB Tab Object
	 * Tab ID is tab1, tab2, ...
	 * setupPage() function in the loadPage() is called before calling this function.
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
InsertItem( "Dry Index" , "");
InsertItem( "Tanker Index" , "");
InsertItem( "Time Charter" , "");
InsertItem( "Bunker Price" , "");
InsertItem( "Ship Price" , "");
InsertItem( "FFA Index" , "");
			}
		}catch(e){
			ComShowMessage(e);
		}
	}
	/**
	 * tab1_OnChange
	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	/**
	 * IB Tab Object when clicked, shows the contents of that tab
	 * Tab grouping by the ID of a DIV TAG to be the same for both "tabLayer" shall be determined by
	 */
	function ChangeTab(tabObj,nItem){
		tabObj.SetBackColor("#FFFFFF");
		var objs=document.all.item("tabLayer");
		objs[beforetab].style.display="none";
		objs[nItem].style.display="Inline";
		//--------------- This is important --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw modified: zIndex less than -2 Not when you're a click button
		objs[beforetab].style.zIndex=0;
		objs[nItem].style.zIndex=9;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	/**
	 * Click the radio button at the hidden value, contrary to delete the status change and add value.
	 */
	function change_val(){
		var formObject=document.form;
		var sheetObject = sheetObjects[0];
		var change=document.form.stsval.value;
		//Cleared when the radio button (sheet)
		  sheetObject.RemoveAll();
		//Changes at the top of the header title
		if(change=="Y"){
			document.form.stsval.value="N";
			sheetObject.SetCellValue(0, 0,"Liv.",0);
			//formObject.btng_rowadd.disabled = true;
			formObject.btng_rowadd.style.visibility="hidden";  //visible
		}else{
			document.form.stsval.value="Y";
			sheetObject.SetCellValue(0, 0,"Del.",0);
			formObject.btng_rowadd.style.visibility="visible";  //hidden
		}
		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	
	
	/**
	 * Location: In the single-selection pop-up hangyeongwoo.
	 */
	function getCOM_ENS_051_1(rowArray) {
		var formObject=document.form;
		//Multi-select in the pop-up and made ​​ready to take over in the set-ateum!	
		if(rowArray.length > 0) {
			var colArray=rowArray[0];
			var row_val=formObject.hid_row.value;   //putting a value to the value hidden row
			var col_val=formObject.hid_col.value;   //putting the value of col value hidden
			var in_val=colArray[3];
			sheetObjects[0].SetCellValue(row_val, col_val, in_val, 0);
			// 2015.04.20 CHAN WOO PARK
			// Popup을 통한 입력 시에도 checkKey 로직을 수행토록 수정
			checkKey(sheetObjects[0], row_val, col_val);
		}
	}

	//UI 표준화관련 하단 여백 설정
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}