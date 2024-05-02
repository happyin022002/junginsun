/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   esm_bkg_0953.js
*@FileTitle  : O/B & T/S Loading Report by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
    /**
     * @fileoverview 
     * @author 
     * @extends 
     * @class esm_bkg_0953  - task script definition for screen
     */
    function esm_bkg_0953() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.sheet1_OnClick=sheet1_OnClick;
    	this.sheet1_OnKeyUp=sheet1_OnKeyUp;
    	this.setComboObject=setComboObject;
    }
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
 // public variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var rowsPerPage=50;
 var prefix="";//IBSheet devision
 var grp_cd="";//public variables   
 var queueMap=new Array();
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
 	var comboObjects=new Array();
	//registering IBCombo Object as list
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	} 	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
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
			  //MultiComboinitialization 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
		    initControl();
		    //sheetObjects[0].DoSearch("apps/opus/esm/bkg/bookingreport/statusreport/jsp/UI_BKG_0953_DATA.html");
		    //For multi-combo when immediately retrieve IBSheet broken screen was not drawn correctly to avoid this delay gives 0.1 seconds
		 		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		    //form.p_vvd.focus();
     }
/**
	 	 * Combo setting
	 	 * param : comboObj, comboNo 
	 	 * If the case dasuil combo combo by adding the number of seats shall be composed initialization module
	 	 */ 
	 	function initCombo(comboObj, comboId) {
	 	    var formObject=document.form
 				initComboEditable(comboObj, comboId)
	 	}
 	 //combo multi select 
 	 function initComboEditable(combo, comboId){
	 	 	with (combo) {
	 	 		if(comboId == "order_by" ){
		 	 		SetMultiSelect(1);
		 	 		SetUseAutoComplete(1);
		 	 		SetUseEdit(0);
		 	 		SetDropHeight(150);
	 	 		}
	 	 		else{
	 	 			SetDropHeight(150);
		 	 		SetMultiSelect(0);
		 	 		SetUseEdit(0);
	 	 		}
	 	 	}
 	 }
    function initControl() {
    	var formObject=document.form;
        //axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- in case of keyboard input
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- focus in     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key        
    }        
 /*********************** KEY EVENT START ********************/ 	 
	  /**
     * Control onBlur in HTML Control 
     **/
    function bkg_deactivate() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "dura_from_dt":
	    		ComAddSeparator(ComGetEvent());
					break;
	    	case "dura_to_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
				default:
					break;
	    }
    }        
	/**
	 * Validation check in onFocus event<br>
	 **/
	function bkg_activate(){
		//Validation check
		switch(ComGetEvent("name")){	
	    	case "dura_from_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
	    	case "dura_to_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}  
/*********************** KEY EVENT END ********************/
// Event handler processing by button click event */
 		document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
          var sheetObject1=sheetObjects[0];
          var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
		 				case "btn_Retrieve":
			 				if(order_by.GetSelectCode()== ""){
			 					order_by.SetSelectCode("POL_CD");
			 				}
		 				  var arrSort=order_by.GetSelectCode().split(",");
		 				  var arrTitle=order_by.GetSelectText().split(",");
		 				  var orderbyTitleSql="";
							var cnt=0;
							for(var i=0; i < arrSort.length; i++){
									if(i==0){
										orderbyTitleSql="'"+arrTitle[i]+":'||"+arrSort[i];
									}else{
										orderbyTitleSql += "'"+arrTitle[i]+":'||"+arrSort[i];
									}
									if(arrSort.length > 1 && i < arrSort.length-1){
										orderbyTitleSql += "||'     '||";
									}			
							}
							form.order_by_title.value=orderbyTitleSql;
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
						case "btn_New":
		 					initAll(formObject);
		 					sheetObject1.RemoveAll();				//20150603.ADD
		 					break;		 					
						case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					if(sheetObject1.RowCount() < 1){
								ComShowCodeMessage("COM132501");
							}else{
								sheetObject1.Down2Excel({HiddenColumn:1,Merge:true,TreeLevel:false, SheetDesign:1, AutoSizeColumn:1});
							}
		 					break;
		 				case "btn_period_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.dura_from_dt, formObject.dura_to_dt,'yyyy-MM-dd');
		 					break;
						case "btn_shipper_pop":
	 						ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 450, 'setShipper', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"shipper_pop");
							break;		 				
						case "btn_0083LocPop":
							ComOpenPopup("ESM_BKG_0083.do", 830, 450, "callBack0083","1,0,1,1,1", true);
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
	function initAll(formObj){
			formObj.reset();
	} 
	/*
		 * Shipper retrieve result setting callback method
		 * */
		function setShipper(val){
				var c_cd=val[0][3];
				form.shipper_cd.value=c_cd;
//				var c_name = val[0][4];
//				form.cust_cnt_cd.value=c_cd.substring(0,2);
//				form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
//				form.cust_nm.value=c_name;
		} 
    /**
     * Save from Customer Inquiry popup <br>
     */
    function callBack0083(locTp, tab ,rArray){    	
    	var formObj=document.form;
    	if(rArray != null){
    		
    		if(tab==1){
    			formObj.location_cd.value=rArray[0][2];
    		}else{
	    		formObj.location_cd.value=rArray[0][4].substring(0,5);
	    		formObj.location_yd_cd.value=rArray[0][4].substring(5,7);
    		}
    	}
    } 
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg(false);
         	switch(sAction) {
			 	case IBSEARCH:      //retrieve
	 				//sheetObj.DoSearch("apps/opus/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0953_DATA.html"); 
	 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 				formObj.f_cmd.value=SEARCH;
					sheetObj.RemoveAll();
					//sheetObj.RenderSheet(0);
					//sheetObj.SetWaitImageVisible(1);
					sheetObj.WaitImageVisible=true;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0953_1GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					//sheetObj.SetWaitImageVisible(1);
					sheetObj.WaitImageVisible=false;
					sheetObj.RenderSheet(1);
					if(ComGetEtcData(sXml, "total_40t") == undefined){
						form.total_40t.value="";
						form.total_20t.value="";
						break;
					}
					form.total_40t.value=ComGetEtcData(sXml, "total_40t");
					form.total_20t.value=ComGetEtcData(sXml, "total_20t");
					break;
				case SEARCH01:      // List by Queueretrieve
					//if(!validateForm(sheetObj,formObj,sAction)) return;
					formObj.f_cmd.value=SEARCH01;
					//sheetObj.SetWaitImageVisible(0);
					sheetObj.WaitImageVisible=false;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0953GS.do", FormQueryString(formObj));
					ComXml2ComboItem(sXml, order_by, "val", "desc");
//							list_by_Queue_xml = sXml;
					break;								
				case IBDOWNEXCEL: 
					//sheetObj.Down2Excel();
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
//						 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					}
				break;			
			    }
     }
     /*
      * After you retrieve the corresponding paging processing to handle as many variables
      * The default is number of sheets, headers
      */ 
      var pagedMaxCnt=2; 
			/**
       * After retrieve,  event handling
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }
			/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
     }	   
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	    		if ( ComIsNull(formObj.location_cd)) {
     					ComShowCodeMessage('BKG00626','Location');
     					formObj.location_cd.focus();
     					return false;	
	    		}else if ( ComIsNull(formObj.dura_from_dt) ||  ComIsNull(formObj.dura_to_dt)) {
	     					ComShowCodeMessage('BKG00626','Duration');
	     					if(ComIsNull(formObj.period_from_dt))formObj.dura_from_dt.focus();
	     					else if(ComIsNull(formObj.period_to_dt))formObj.dura_to_dt.focus();
	     					return false;
					}else if ( ComIsNull(formObj.location_cd)) {
	     					ComShowCodeMessage('BKG00626','Location');
	     					formObj.location_cd.focus();
	     					return false;	
					}
	  			break;
    	 }
         return true;
     }
    function isNullEtcData(xmlStr){
    	var rtn=false;
    	var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);
        var xmlRoot=xmlDoc.documentElement;
        if(xmlRoot == null) return true;
        var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;
        var etcNodes=etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn=true;
        return rtn;
    }
 /**
      * setting sheet initial values and header
      * 
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
  	   		case "sheet1":
  	   			with(sheetObj){
        	   var HeadTitle1="Seq.|BKG No.|Shipper Code|POL|POD|In-VVD|Out-VVD|FEU|TEU";
        	   var HeadTitle2="Seq.|B/L No.|Shipper Name|In-Lane|Out-Lane|In-TMNL|Out-TMNL|In-Zone|Out-Zone";
        	   var headCount=ComCountHeadTitle(HeadTitle1);
        	   (headCount, 0, 0, true);

        	   SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

        	   var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
        	   var headers = [ { Text:HeadTitle1, Align:"Center"},
        	                 { Text:HeadTitle2, Align:"Center"} ];
        	   InitHeaders(headers, info);

        	   var cols = [ {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
	        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0, Width:420,  Align:"Center",  ColMerge:0,   SaveName:"shipper_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"in_vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"out_vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"feu",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"teu",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
	        	             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:420,  Align:"Center",  ColMerge:0,   SaveName:"shipper_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"in_lane",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"out_lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"in_tmnl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"out_tmnl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"in_zone",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"out_zone",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
        	    
        	   InitColumns(cols);

        	   SetEditable(0);
        	   //SetGetCountPosition()(0);
        	   cnt=0;
        	   SetSheetHeight(440);
        	}
 			break;
         }
     }
