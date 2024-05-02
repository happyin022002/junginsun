/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0035.js
*@FileTitle  : Budget Expense Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
 	// public variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isShift=false;
    var arrChk=[0, 0, false];	//for clicking only 1 row of sheet1
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    
    // Event handler processing by button name
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_DownExcel":
            		if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					}                		
            		break;
	            case "btns_search":
	            	openLaneCode();
	            	break;
	            case "btns_calendar_s":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
	    	        cal.select(form.txtsdate, "yyyy-MM");
	            	break;
	            case "btns_calendar_e":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
	            	cal.select(form.txtedate, "yyyy-MM");
	            	break;
	            case "btn_vvd_search":
					var vsl_cd=formObject.vsl_cd.value;
	            	var sUrl="";
	            	if(vsl_cd == ""){
	            		sUrl="/opuscntr/VOP_VSK_0219.do";
	            		ComOpenPopup(sUrl, 500, 480, "getVslCdData", "0,0", true);
	            	}else{
	            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
	            		ComOpenPopup(sUrl, 340, 400, "getVvdData", "0,0", true);
	            	}
	            	break;
	            case "btn_retrieve":
	            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	            	break;
	            case "btn_new":
	            	clearSearchCondition();
	            	break;
	            case "btn_creation":
	            	if(arrChk[2] == false){	//Checked Row is null
	            		ComShowCodeMessage("PSO00039");
	            		return;
	            	}
	            	if(!ComShowCodeConfirm("PSO00041", "create")){
	            		return;
	            	}
	            	doActionIBSheet(sheetObject1,formObject,IBSAVE);
	            	break;
	            case "btn_detail":
	            	if(sheetObjects[0].RowCount() > 0){
	            		var selRow=sheetObject1.GetSelectRow();
	            		var prefix="sheet1_";
	            		var turl="/opuscntr/VOP_PSO_0213.do?sdt="+formObject.txtsdate.value
		        	              	+"&edt="+formObject.txtedate.value
									+"&vslCd="+sheetObject1.GetCellValue(selRow, prefix+"vsl_cd")
									+"&skdVoyNo="+sheetObject1.GetCellValue(selRow, prefix+"skd_voy_no")
									+"&skdDirCd="+sheetObject1.GetCellValue(selRow, prefix+"skd_dir_cd")
									+"&revYrmon="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), prefix+"expn_yrmon")
									+"&psoBztpCd=1"
		        	              ;
	            		ComOpenPopup( turl , 1020, 550, '', 'none', true, true);
	            	}else{
	            		ComShowCodeMessage("COM132701");
	            	}
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
    
    
    /**
     * Setting data about VVD
     * @param obj
     * @return
     */
    function getVslCdData(obj){
    	if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value=rtnDatas[1];
				}
			}
    	}
    }
    
	function getVvdData(obj){
    	if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value=rtnDatas[2];
					document.form.skd_dir_cd.value=rtnDatas[3];
				}
			}
    	}
    }
	
    /**
     * Clearing conditions
     * @return
     */
    function clearSearchCondition(){
    	var formObj=document.form;
    	formObj.reset();
    	setToday(document.form.txtsdate, "ym");//current year
      	setToday(document.form.txtedate, "ym");//current year
      	//grid remove 
      	sheetObjects[0].RemoveAll();
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
        for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        initControl();
    }
    
    /**
     * registering initial event
     * @return
     */
    function initControl(){
    	axon_event.addListener ('keydown', 'obj_keydown', 'form');
      	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
       	axon_event.addListenerForm('keyup', 'obj_keyup', form);
       	axon_event.addListenerFormat('blur',  	'obj_blur',  	form);
      	setToday(document.form.txtsdate, "ym");//current year
      	setToday(document.form.txtedate, "ym");//current year
 	}
    function obj_keydown(){
       	isShift=event.shiftKey ? true : false;
       	ComKeyEnter();
    }
    
    /**
    * Handling onBlur event
    * @return
    */
    function obj_blur(){
   	  var formObj=document.form;
	   	 obj=ComGetEvent();    	
	   	 with(formObj){
	   		if(obj.name=="txtsdate" || obj.name=="txtedate"){
	   			var creDtFr=ComReplaceStr(txtsdate.value,"-","");
	   			var creDtTo=ComReplaceStr(txtedate.value,"-","");
	   			switch(ComGetEvent("name")) {
	   				case "txtsdate":	// Agreement From Date
	   					if(creDtFr != '' && creDtTo != ''){
		    				if(creDtFr > creDtTo){
		    					ComShowCodeMessage('COM12133','To date','From date','greater');
		    					txtsdate.value='';
		    					document.form.txtsdate.focus();
		    					return false;
		    				}
		    			}
		    	        break;
		    		case "txtedate":	// Agreement To Date
		    			if(creDtFr != '' && creDtTo != ''){
		    				if(creDtFr > creDtTo){
		    					ComShowCodeMessage('COM12133','To date','From date','greater');
		    					txtedate.value='';
		    					txtedate.focus();
		    					return false;
		    				}
		    			}
		    	       	break;	
	   			}
	   			ComChkObjValid(event.srcElement);
	   		}
	   	}
	       return true;	
}
    
    /**
     * Handling key press event
     * @return
     */
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
	            ComKeyOnlyNumber(obj);
	            break;
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet(); break;
	        case "engup":
	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum');
	            else if(obj.name=="vsl_slan_cd" || obj.name=="vsl_cd") ComKeyOnlyAlphabet('uppernum');
	            else if(obj.name=="vndr_lgl_eng_nm") toUpper();
	            else ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
	            else ComKeyOnlyAlphabet('lower');
	            break;
	    }
    }
    
    /**
      * Handling key up event
      * @return
      */
    function obj_keyup() {
  		var eleObj=event.srcElement;
  		var formObj=document.form;
 		if (!event.keyCode) return true;
		if(event.keyCode ==9 || isShift ){
			return true;
		}
  		switch (eleObj.name) {
//	  		case "txtsdate":
//	  			if (eleObj.value.length == 6) {
//	  				formObj.txtedate.focus();
//	  			}
//	  			break;
//	  		case "txtedate":
//	  			if (eleObj.value.length == 6) {
//	  				formObj.vsl_slan_cd.focus();
//	  			}
//	  			break;
	  		case "vsl_slan_cd":
	  			if (eleObj.value.length == 3) {
	  				formObj.vsl_cd.focus();
	  			}
	  			break;
	  		case "vsl_cd":
	  			if (eleObj.value.length == 4) {
	  				formObj.skd_voy_no.focus();
	  			}
	  			break;
	  		case "skd_voy_no":
	  			if (eleObj.value.length == 4) {
	  				formObj.skd_dir_cd.focus();
	  			}
	  			break;
	  		default:
	  			break;
  		}
  	}
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
    	var sheetid=sheetObj.id;
        switch(sheetid) {
    		case "sheet1":
    		    with(sheetObj){
    				var HeadTitle1="|Seq.|REV.Month|LANE|ERR|CHK|VVD|Vessel Class|Amount|Remark|vslCd|skdVoyNo|skdDirCd";
    				var headCount=ComCountHeadTitle(HeadTitle1);
    				var prefix="sheet1_";

    				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dataseq" },
    				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"expn_yrmon",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"err",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 , TrueValue:"Y", FalseValue:"N"},
    				             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 , TrueValue:"Y", FalseValue:"N"},
    				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cls",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    	       
    				InitColumns(cols);

    				SetEditable(1);
    				//SetSheetHeight(440);
    				resizeSheet(sheetObj);
    			}
    		    break;
        }
    }
    
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
          case IBSEARCH:      //Retrieving
           	if(validateForm(sheetObj,formObj,sAction)){
				if ( sheetObj.id == "sheet1"){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("VOP_PSO_0035GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
				}					
           	}
			break;
		 case IBSAVE:        //Save
			 if(validateForm(sheetObj,formObj,sAction)){
				 ComOpenWait(true);
				 formObj.f_cmd.value=MULTI;
				 var SaveStr=ComGetSaveString(new Array(sheetObj)); // array
				 if(SaveStr.length <= 0 ) return;
				 var aryPrefix=new Array("sheet1_");	//prefix String array
				 var sXml=sheetObj.GetSaveData("VOP_PSO_0035GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				 ComOpenWait(false);
				 sheetObj.LoadSaveData(sXml);
			 }
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
    
	/*
	 * for clicking only 1 row of sheet1
	 */            
	function sheet1_OnBeforeCheck(sheetObj, Row, Col){
		var formObj=document.form;
		var prefix="sheet1_";
		sheetObj.ShowDebugMsg(false);
		switch (sheetObj.ColSaveName(Col)) {
			case prefix + "chk" :
				var valChk=sheetObj.GetCellValue(Row, Col);
				arrChk[1]=arrChk[0];	
				arrChk[0]=Row;	
				if(arrChk[1] != 0 && arrChk[0] != arrChk[1]){
					sheetObj.SetCellValue(arrChk[1], Col,0);//previous
				}
				arrChk[2]=valChk == true ? false : true;	//checked 
			break;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var bgColor="#FFFFFF";
		sheetObj.SetColBackColor(1,bgColor);
		sheetObj.SetColBackColor(2,bgColor);
		sheetObj.SetColBackColor(3,bgColor);
		sheetObj.SetColBackColor(4,bgColor);
		sheetObj.SetColBackColor(6,bgColor);
		sheetObj.SetColBackColor(7,bgColor);
		sheetObj.SetColBackColor(8,bgColor);
		sheetObj.SetColBackColor(9,bgColor);
		ComOpenWait(false);
	}
	
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	    ComOpenWait(false);
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);//After Creation Button Click, reRetrieving
	}
	
	function resizeSheet(){
		for (var i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	