/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7002.js
*@FileTitle  : DEM/DET Office Inquiry by Yard
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    /* Developer's task   */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
    //  business global variables
    var COUNTRY="CNT";
    var LOCATION="LOC";
    var YARD="YD";
    var ROWMARK="|";
    var FIELDMARK="=";
    var ORIGIN="Origin";
    var DESTINATION="Destination";
	//멀티콤보 이벤트 처리를 위한 전역변수
	var selComboIndex, selComboCode;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event handler processing by button name */
    function processButtonClick(){
        /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
    	var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;

                case "btn_new":
                	doActionNew();
                break;
                
                case "btn_downExcel":
                	if (sheetObject1.RowCount() < 1) {//no data
						ComShowCodeMessage("COM132501");
					}
                	else {
						sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
					}
                break;
            } // end switch
        }
        catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } 
            else {
                ComShowMessage(e.message);
            }
        }
    }
    
    function doActionNew() {
    	var formObj = document.form;
    	
    	// 조회조건 초기화
    	formObj.chk_sub_ofc.checked = false;				// Incl. Sub Office
    	formObj.collectib.selectedIndex = 0;				// Collection I/B
    	formObj.collectob.selectedIndex = 0;				// Collection O/B
    	ComSetObjValue(formObj.yd_cd1 , 		"");		// Yard
    	formObj.yarddelyn.selectedIndex = 1;				// Yard Status
    	
    	// DEM/DET Office
    	comboObjects[0].RemoveAll();
    	doActionIBCombo(sheetObjects[0],formObj,comboObjects[0],SEARCHLIST02);
    	// Country
    	comboObjects[1].RemoveAll();
    	doActionIBCombo(sheetObjects[0],formObj,comboObjects[1],SEARCH02);          	

    	// 조회결과 초기화    	
    	sheetObjects[0].RemoveAll();
    }
    
    /**
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    //Page generated in the comboObjects IBCombo Object Properties in an array
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
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
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
        initControl();
    }
    
    // Event-handling function declarations
    function initControl() {
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');

    }
    
    /*
     * Multiple selected DEM / DET Office of the Sub-mucin (Sub Office) lookup
     */
    function doInclSubOfc() {
          var formObj=document.form;
          if (formObj.chk_sub_ofc.checked) { // Sub Office 포함
              if (ComIsEmpty(comboObjects[0].GetSelectCode())) {
                  ComShowCodeMessage('COM12113', "DEM/DET Office");
                  formObj.chk_sub_ofc.checked=false;
                  return;
              }
              formObj.ofc_cd.value=ComGetObjValue(comboObjects[0]);
              formObj.tmp_ofc_cd.value=ComGetObjValue(comboObjects[0]);
              doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], IBSEARCH_ASYNC03);
          } else {
              ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);
          }
    }
    
    /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
                var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
            		var HeadTitle1="Seq.|DMT OFC|I/B|O/B|YD Code|Yard Name|Del.|Character|Marine|CY|CFS|Rail|Barge|Pseudo|CTRL OFC";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",        KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dmtofc",     KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ib",         KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ob",         KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ydcode",     KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"yardname",   KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"del",        KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"character",  KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"marine",     KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cy",         KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cfs",        KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rail",       KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"barge",      KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pseudo",     KeyField:0,   CalcLogic:"",   Format:"" },
            		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ctrlofc",    KeyField:0,   CalcLogic:"",   Format:"" } ];
               
            		InitColumns(cols);

            		SetEditable(0);
            		SetSheetHeight(485);
            	}
                break;
        }
    }
    
    // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      
        		if(!validateForm(sheetObj,formObj,sAction)) return;
                formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
                sheetObj.DoSearch("EES_DMT_7002GS.do", FormQueryString(formObj) );
                break;
        }
    }
    
    /**
     * Combo basic setting
     * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
     * If the case dasuil combo combo by adding the number of seats will initialize the module configuration
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj=document.form;
        switch(comboObj.options.id) {  
            case "office": 
                with (comboObj) {
                    SetUseAutoComplete(1);
                    SetColAlign(0, "left");
                    SetDropHeight(160);
                    SetColBackColor(0,"white");
                    SetColBackColor(1,"white"); 
                    ValidChar(2);
                    SetMaxLength(5);
                }
                doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
            break;
            case "combo3":
                with (comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "300");
                    SetDropHeight(160);
                    ValidChar(2);
                    SetMaxLength(2);
                    SetColBackColor(0,"white");
                    SetColBackColor(1,"white");
                }
                doActionIBCombo(sheetObjects[0],formObj,comboObj,SEARCH02);
                break;
            case "combo5":
                with (comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "50");
                    SetDropHeight(160);
                    ValidChar(2, 1);
                    SetMaxLength(2);
                }
                comboObj.InsertItem(0, "", "");
                break;
        }
    }
    
    // IBCombo data retrieval and setting
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
         sheetObj.ShowDebugMsg(false);
         sheetObj.SetWaitImageVisible(0);
         formObj.f_cmd.value=formCmd;
         ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
         switch(formCmd) {
            case COMMAND06: // RHQ
                with (comboObj) { 
                    RemoveAll();
                    SetMultiSelect(0);
                    SetColWidth(0, "45");
                    ValidChar(2);
                }
                
                var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                var data=ComGetEtcData(sXml, "common_cd");
                if (data != undefined && data != '') {
                    var comboItems=data.split("|");
                    comboObj.InsertItem(0, "All", "All");
                    for (var i=0 ; i < comboItems.length ; i++) {
                        comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);     
                    }
                }
            break;
            
            case SEARCHLIST02: // Office
                with (comboObj) { 
                    RemoveAll();
                    SetMultiSelect(1);
                    SetColWidth(0, "95");
                    ValidChar(2, 2);
                }
                
                var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                var data=ComGetEtcData(sXml, "OFC_CD");
                if (data != undefined && data != '') {
					var usrOfcCd=ComGetObjValue(formObj.h_user_office);
 					var idx=0;
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx=1;
 					}
 		    	    var comboItems=data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
	    	  		comboObj.SetSelectCode(usrOfcCd, false);
				}
            break;
            
            case COMMAND01: // Incl. Sub Office
//parameter changed[check again]CLT
            	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
            	var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
		 		if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd=ComGetObjValue(formObj.h_user_office);
					if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds=usrOfcCd + ',' + subOfcCds;
					comboObj.SetSelectCode(subOfcCds, false);
		 		}
		 	break;
		 	
            case SEARCH14:
//parameter changed[check again]CLT
            	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
            	comboObjects[2].SetSelectCode("-1");
            	comboObjects[2].RemoveAll();
            	var comboDatas=ComGetEtcData(sXml, YARD);
                if (comboDatas == undefined ||comboDatas == "") {
                }else{
                    var comboItems=comboDatas.split(ROWMARK);
                    addComboItem1(comboObjects[2],comboItems);    
                    setComboItem(comboObjects[2],comboItems);
                }
            break;
            
			case SEARCH02:
//parameter changed[check again]CLT
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                var comboDatas=ComGetEtcData(sXml, COUNTRY);
                if (comboDatas != undefined ||comboDatas != "") {
                    var comboItems=comboDatas.split(ROWMARK);
                    addComboItem(comboObjects[1],comboItems); //COUNTRY
                }else{
                    ComShowCodeMessage("DMT06001");
                    clearObjectValue(sObj);
                }
            break;
            
            case IBSEARCH_ASYNC03:      
                formObj.f_cmd.value=COMMAND01;
//parameter changed[check again]CLT
                var sXml2=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                var subOfcCds=ComGetEtcData(sXml2, "OFC_CD");
		 		if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd=ComGetObjValue(formObj.h_user_office);
					if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds=usrOfcCd + ',' + subOfcCds;
					comboObj.SetSelectCode(subOfcCds, false);
		 		}
		 	break;
        }
         sheetObj.SetWaitImageVisible(1);
    }
    
    function office_OnCheckClick(comboObj, index, code) {
        var formObj=document.form;
        if (formObj.chk_sub_ofc.checked) {
   			if(comboObj.GetItemCheck(index)) {
   				comboObj.SetItemCheck(index, 0, false);
   			}
   			else {
   				comboObj.SetItemCheck(index, 1, false);
   			}
   			ComShowCodeMessage('DMT00107');
   		}
    }
    
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	} 	

    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            formObj.demdetoff.value=ComGetObjValue(formObj.office);
            formObj.countrycd.value=ComGetObjValue(formObj.combo3);
            formObj.yardnodee.value=ComGetObjValue(formObj.combo5);
            formObj.yardlocat.value=ComGetObjValue(formObj.yd_cd1);
        }
        return true;
    }
    
    // That occurs when you move your mouse over the Event Sheet
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        with(sheetObj) {
  			Row = MouseRow();
  			Col = MouseCol();        	
            var colName=ColSaveName(MouseCol());
            var msg="";
            switch(colName) {
                case "dmtofc":
                    msg="DEM/DET Office";
                break;
                
                case "ib":
                    msg="I/B Collection";
                break;
                
                case "ob":
                    msg="O/B Collection";
                break;
                
                case "del":
                    msg="Yard Delete Flag";
                break;
                
                case "marine":
                    msg="Marine Terminal";
                break;
                
                case "rail":
                    msg="Rail Ramp";
                break;
                
                case "barge":
                    msg="Barge Ramp";
                break;
            }
            
            if (msg != "") {
            	SetToolTipText(Row, Col, msg);
            }
        }
    }
    
    /*
     * LOCATION yd_cd1 lookup field that corresponds to the function to retrieve information YARD
     */     
    function checkYard1(obj) {
        if(isAlpha()) {
            checkYard1_sub2(obj);
        }
    }
    
    /*
     * yd_cd list should look up when entering yd_cd1.
     */
    function checkYard1_sub2(obj) {
        var formObj=document.form;
        if (ComTrim(ComGetObjValue(obj)).length == 5) {
            var yardCd1=ComTrim(ComGetObjValue(obj));
            if (yardCd1.length > 0) {
                doActionIBCombo(sheetObjects[0],formObj,comboObjects[1],SEARCH14);
            }
        }
    }
    
    function combo3_OnBlur(){
    }
    
    /**
     * Data in the field adds a combo.
     */ 
    function addComboItem(comboObj, comboItems) {
        for (var i=0 ; i < comboItems.length ; i++) {
            var comboItem=comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);        
        }           
    }
    
    /**
     * Select the first item in the combo makes the field.
     */ 
    function setComboItem(comboObj,comboItems) {
        var checkedItem=comboItems[0].split(FIELDMARK);
        comboObj.SetSelectText(checkedItem[0]);
    }
    
    /**
     * Data in the field adds a combo.
     */ 
    function addComboItem1(comboObj, comboItems) {
        for (var i=0 ; i < comboItems.length ; i++) {
            var comboItem=comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[1], comboItem[0]);     
        }           
    }
    /* Developer's task end */
