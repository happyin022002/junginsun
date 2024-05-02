/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SPE_0009.jsp
*@FileTitle  : EvaluationGroupTargetManage
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
     * @extends 
     * @class ESD_SPE_0009 : business script for ESD_SPE_0009 
     */
    function ESD_SPE_0009() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.setComboObject=setComboObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.validateForm=validateForm;
    }
/* The common global variables */
//var calPop = new calendarPopupGrid();
var curTab=1;
var beforetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
	/**
	 * Initializing IBTab object
	 * Calling this function before calling loadPage() function in setupPage()
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
//no support[check again]CLT 				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e.message);
		}
	}
	/**
 	 * Calling this function when occurring onchange event in tab1
 	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	/**
  	 * Showing the content of the clicked tab when clicking IBTab object.
  	 */
	function ChangeTab(tabObj,nItem){
		tabObj.SetBackColor("#FFFFFF");
//no support[check again]CLT 		tabObj.TabBackColor(nItem)="146,174,230";
		var objs=document.all.item("tabLayer");
		objs[beforetab].style.display="none";
		objs[nItem].style.display="Inline";
		objs[beforetab].style.zIndex=0;
		objs[nItem].style.zIndex=9;
		beforetab=nItem;
	}
	/**
	 * Registering IBSheet Object as list
	 * Adding process for list in case of needing batch processing with other items
	 * Defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet 
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
//		initControl(); 
	}
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
		              var HeadTitle=" ||||RHQ|Branch||Terminal||S/P Name|Prior Year|Prior Year|Target||Portion (%)|Remark|" ;
		              var HeadTitle1=" ||||RHQ|Branch||Terminal||S/P Name|Performance|Target |Target||Portion (%)|Remark|" ;
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"},
		                          { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"eg_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"eg_id_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"reg_group",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"yd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"per",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"target",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"kpi_tgt_rto",      KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"kpi_ut_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"kpi_wgt_rto",      KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"eng_vndr_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ev_yr",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetRangeBackColor(1,10, 1,12,"#555555");
		              SetSheetHeight(260 );
		              SetEditEnterBehavior("down");
	              }
                break;
        }
    }
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_retrieve":        	    	       	    	
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
        	    case "btn_apply":
        	        break;
        	    case "btng_delete":
					doActionIBSheet(sheetObject,formObject,IBDELETE);
					break;
				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_sp":
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 450, 'getVendor', '1,0,1,1,1,1,1,1');
					break;
				case "btn_yard":
					ComOpenPopup('/opuscntr/COM_ENS_061.do?classId=COM_ENS_061', 770, 480, 'getYard', '1,0,1,1,1,1,1,1');
					break;					
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
  // Handling the process about the sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //retrieving
                if(validateForm(sheetObj,formObj,sAction)){                	
                 	if(!validateForm(sheetObj,formObj,sAction)) return;
               		formObj.f_cmd.value=SEARCH;
               		var param=speFormString(formObj,'f_cmd,yd_cd,vndr_seq,vndr_abbr_nm,ev_yr');
               		sheetObj.DoSearch("ESD_SPE_0009GS.do", param );
                }
                break;
			case IBSAVE:		//saving                
				formObj.f_cmd.value=MULTI;
				var param=speFormString(formObj,'f_cmd');
				sheetObj.DoSave("ESD_SPE_0009GS.do", param);
				break; 
			case IBDELETE:	   	//Delete
				for(i=0; i<=sheetObj.RowCount()+1;i++){
					if(sheetObj.GetCellValue(i,0)== "1"){
						sheetObj.SetRowHidden(i,1);
					}
				}
				break;		
			case IBSEARCHAPPEND:		//retrieving VNDR name
				 formObj.f_cmd.value=SEARCH01;
			 	 var param=speFormString(formObj,'f_cmd,vndr_seq,vndr_abbr_nm');
			 	 var sXml=sheetObj.GetSearchData("ESD_SPE_0009GS.do", param);
	  		 	 if(sXml==""){
	  		 		formObj.vndr_seq.value=""; 
	  		 		formObj.vndr_abbr_nm.value="";
	  		 		formObj.yd_cd.value="";
	  		 	 } else {
	  		 		 formObj.vndr_seq.value=ComXmlString(sXml, "vndr_seq"); 
			      	 formObj.vndr_abbr_nm.value=ComXmlString(sXml, "vndr_abbr_nm");	
			      	 formObj.yd_cd.value=ComXmlString(sXml, "yd_cd");
	  		 	 }
				break;  	
        }
    }
   /**
     * Handling the process for the input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction){
        		case IBSEARCH: 
        			if((formObj.yd_cd.value == null || formObj.yd_cd.value == "")
        				||(formObj.vndr_seq.value == null || formObj.vndr_seq.value == "")){
        				ComShowCodeMessage('COM12113','All the conditions of retrieval','','');        				 
        				return false;
        			}
        		break;
        	}        	
        }
        return true;
    }
	/**
	 * Calling this function after finishing to retrieve sheet<br>
	 * Showing the error message when the error message exists
	 */
	function sheet1_OnSearchEnd(sheet1,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
	}
	function sheet1_OnChange(sheet1,row,col){
		if (sheet1.ColSaveName(col) == "kpi_tgt_rto" ){
			var target=sheet1.GetCellValue(row,col);
			if(target > 999.99){
				ComShowCodeMessage('COM12133','The value of target','999.99','less');	
				sheet1.SetCellValue(row,col,0,0);
			}
		}
		if (sheet1.ColSaveName(col) == "kpi_wgt_rto" ){
			var portion=sheet1.GetCellValue(row,col);
			if(portion > 100){
				ComShowCodeMessage('COM12133','The value of portion','100','less');	
				sheet1.SetCellValue(row,col,0,0);
			}
		}
	}
	/**
	 * Calling this function in case of closing the popup
	 *
	 */
	function getVendor(rArray){
		var cArray=rArray[0];
		document.all.vndr_seq.value=cArray[2];
		document.all.vndr_abbr_nm.value=cArray[4];
	}
	/* Getting the yard value from the popup
	 */
	function getYard(rowArray) {
		var colArray=rowArray[0];
		document.all.yd_cd.value=colArray[3];
		document.all.yd_nm.value=colArray[4];
	}
	/**
	 * Setting Vndr_abbr_nm
	 */
	function spe_setVndr_abbr_nm(obj){
        var formObj=document.form;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCHAPPEND);
	 }
	// Handling the process of Axon event
   	function initControl() {
   		var formObj=document.form;
 		axon_event.addListenerFormat('keydown',	'obj_keydown',	form); 
 		axon_event.addListener('keydown',	'ComKeyEnter',	    'form');
 		axon_event.addListenerFormat('keyup',	'obj_keyup',	form);
 		axon_event.addListenerFormat('keypress','obj_keypress',	form);  
   	}       
   		/**
	 	 * Handling the keydown event
	 	 */
		function obj_keydown() {
			var obj=event.srcElement;
			var vKeyCode=event.keyCode;
			var formObj=document.form;
			if (obj.name == "vndr_seq") {
		  		if ( vKeyCode == 9 || vKeyCode == 13) {
		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCHAPPEND);
		  		}
			} 
		}
	  	function obj_keyup() {
	 		var obj=event.srcElement;
	 		var vKeyCode=event.keyCode;
	 		var formObj=document.form;
	 		switch(ComGetEvent("name")) {
	 			case "vndr_seq": 
			  		if (formObj.vndr_seq.value.length == 6) {
			  			if (vKeyCode != 8 && vKeyCode != 46 && vKeyCode != 32 && 
			  				vKeyCode != 37 && vKeyCode != 38 && vKeyCode != 39 && vKeyCode != 40 && vKeyCode != 229){
			  			   doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
			  			}
			  		}
			  		break;
	 		}
	 	}  	 
	 	function obj_keypress(){
		    obj=event.srcElement;
		    if(obj.dataformat == null) return;
		    window.defaultStatus=obj.dataformat;
		    switch(obj.dataformat) {
		        case "engup":
		            if(obj.name=="vndr_seq") ComKeyOnlyAlphabet('uppernum');
		            break;
		    }        
		}
