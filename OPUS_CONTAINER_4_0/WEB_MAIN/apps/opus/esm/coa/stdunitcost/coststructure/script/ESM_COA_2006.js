/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_coa_2006.js
*@FileTitle  : USA Service Mode
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var strOfcCd="";
    //combo
    var comboObjects=new Array();
    var comboCnt=0;
     // Event handler processing by button click event */
    document.onclick=processButtonClick;
     // Event handler processing by button name */
        function processButtonClick(){
       	 var sheetObject1=sheetObjects[0];
       	 var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName)
                {
   				case "btn_add":
   					doActionIBSheet(sheetObject1,formObject,IBINSERT);
   				break; 
//   				case "btn_delete":
//   					if(sheetObject1.FindCheckedRow("Sel")=="")
//   					{
//   						ComShowCodeMessage("COA10028");
//   					}
//   					else if(ComShowCodeConfirm("COA10028")) 
//   					{ 
//   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
//   					}
//   				break;
   				case "btn_retrieve":
//   					sheetObject1.SetWaitImageVisible(0);
   					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
//   					sheetObject1.SetWaitImageVisible(1);
   				break;														
   				case "btn_save":
   					doActionIBSheet(sheetObject1,formObject,IBSAVE);
   				break;														
   				case "btn_downexcel":
   					//sheetObject1.Down2Excel(true);
   					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
   				break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COA00011",srcName+" Button Fail.");
        		} else {
        			ComShowCodeMessage("COA00011",e);
        		}
        	}
        }
        /**
         * registering IBSheet Object as list
         * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
         */
        function setSheetObject(sheet_obj)
        {
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() 
        {
            for(i=0;i<sheetObjects.length;i++)
            {
            	ComConfigSheet (sheetObjects[i] );
            	initSheet(sheetObjects[i],i+1);
            	ComEndConfigSheet(sheetObjects[i]);
            }
      		loadingMode=true;
            
            // multi-combo
            //---------------------------------------------
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            loadingMode=false;
//            axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//        	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
//        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        	//axon_event.addListenerForm('change', 'obj_change', document.form); // change
        	//axon_event.addListenerForm('click', 'obj_click', document.form); // click
        	sheet1_OnLoadFinish(sheet1);
        }
        function sheet1_OnLoadFinish(sheetObj){
            sheetObj.SetWaitImageVisible(0);
            //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            sheetObj.SetWaitImageVisible(1);
     	}
     	/**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) 
        {
            var cnt=0;
            switch(sheetNo) 
            {
                case 1:      //sheet1 init
                    with(sheetObj){
//		                 (5, 0, 0, true);
		                 var HeadTitle="Del.|STS|Origin Region|Destination Region|Service Mode";
		
		                 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                 InitHeaders(headers, info);
		
		                 var cols = [ {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg" },
		                     {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Combo",     Hidden:0, Width:300,  Align:"Center",  ColMerge:0,   SaveName:"org_rgn_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Combo",     Hidden:0, Width:300,  Align:"Center",  ColMerge:0,   SaveName:"dest_rgn_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"svc_mod_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 } ];
		                  
		                 InitColumns(cols);
		                 SetEditable(1);
//		                 SetSheetHeight(440);
						 resizeSheet();
                          }
                    break;
            }
        }
    	/**
         * setting multi combo
         */
         function initCombo(comboObj, comboId) {
        	 with (comboObj) {
 				SetMultiSelect(0);
 				SetUseAutoComplete(1);
 				ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
 				SetDropHeight(190);
 				GetColWidth=50;
 				//comboObj.InsertItem(0, 'All' ,''); 
        	 }
         }	
        /**
         * sheet event
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
			var selrow=sheetObj.GetSelectRow();
            switch(sAction) 
            {
			//combo
            case IBCLEAR:          //retrieve
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sParam=coaFormQueryString(formObj, 'f_svc_mod_cd');  // f_serviceModeCombo	 				  				
 				var sXml=sheetObj.GetSearchData("ESM_COA_2006GS.do", sParam);
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					ComXml2ComboItem(arrXml[0], f_org_rgn_cd, "code", "name");
					ComCoaSetIBCombo(sheetObj, arrXml[0], "org_rgn_cd", true, 0);
				}
				if (arrXml.length > 1) {
					ComXml2ComboItem(arrXml[1], f_dest_rgn_cd, "code", "name");
					ComCoaSetIBCombo(sheetObj, arrXml[1], "dest_rgn_cd", true, 0);
				}
				if (arrXml.length > 2) {
					ComXml2ComboItem(arrXml[2], f_svc_mod_cd, "code", "name");
					ComCoaSetIBCombo(sheetObj, arrXml[2], "svc_mod_cd", true, 0);
				}
				setOriginRegionCombo(sXml);
				setDestinationRegionCombo(sXml);
				setServiceModeCombo(sXml);
				ComOpenWait(false);
			break;
			case IBINSERT:
    				if ( selrow > 0 )
    				{
//    					sheetObj.DataInsert(selrow);
    					sheetObj.DataInsert();
//    					sheetObj.SelectCell(selrow+1, 3, true);				//SJH.20150105.MOD
    				}
    				else
    				{
    					sheetObj.DataInsert(-1);
    				}
   			break;
   			case IBSEARCH:
				if(sheetObj.id == "sheet1") {
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);			
		            setTimeout( function () {		
						formObj.f_cmd.value=SEARCH;
		 				var xml="";
	 	 				xml=sheetObj.GetSearchData("ESM_COA_2006GS.do", FormQueryString(formObj));
		 				sheetObj.LoadSearchData(xml,{Sync:0} );
		 				ComOpenWait(false);
		            }, 100);
				}
   			break;
   			case IBSAVE:
   				if(validateForm(sheetObj,formObj,IBSAVE)){
   					if(sheetObj.id == "sheet1") 
   					{
   						var sel_code=sheetObj.GetCellValue(selrow,"svc_mod_cd");
   						var cur_code="";
   						sheetObj.SetWaitImageVisible(0);
   						ComOpenWait(true);	   						
   						formObj.f_cmd.value=MULTI;
   						sheetObj.DoSave("ESM_COA_2006GS.do", FormQueryString(formObj));		//SJH.20150105.MOD
   						ComOpenWait(false);
   					}
   				}
   			break;
			case IBDOWNEXCEL:	//excel download
				var excelType=selectDownExcelMethod(sheetObj, 0);
			break;
			case IBDELETE:
   		 		ComRowHideDelete(sheetObj, "Sel");
   		 	    //retrieving in case of successful saving
//				doActionIBSheet(sheetObj,document.form,IBSEARCH);
   	   		 	sheetObj.SetSelectRow(selrow);
   		 		break;
   		 	case SEARCH09:
				if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "MST", strOfcCd) ) {
					div_ofc1.style.display="none";
					div_ofc2.style.display="none";
				}else{
					div_ofc1.style.display="";
					div_ofc2.style.display="";
				}
			break;
            }
        }
        
        function callBackExcelMethod(excelType) {	
            var sheetObj = sheetObjects[excelType[1]];
            switch (excelType[0]) {
	            case "AY":
	                sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	                break;
	            case "AN":
			    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			    	break;
	            case "DY":
	            	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	            	break;
	            case "DN":
			    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
			    	break;
        	}            
        }

    	
     	//combo
         function setComboObject(combo_obj) {  
    		comboObjects[comboCnt++]=combo_obj;  
    	}
    	function setOriginRegionCombo(sXml){
    		var combObj=f_org_rgn_cd;  // f_serviceModeCombo
    		combObj.InsertItem(0, "All", "");
    		
    		if(sXml.indexOf("|$$|") >= 0) {
    			combObj.SetSelectText("All");
    			return;
    		}
    		
    		var arrData=ComXml2ComboString(sXml, "code", "name");
    		if (arrData != null){
                var arrCode=arrData[0].split("|");
                var arrName=arrData[1].split("|");
                for(i=0; i < arrName.length;i++){
        			combObj.InsertItem(i+1, arrName[i], arrCode[i]);        
                }
            }
            combObj.SetSelectText("All");
    	}
    	function setDestinationRegionCombo(sXml){
    		var combObj=f_dest_rgn_cd;  // f_serviceModeCombo
    		combObj.InsertItem(0, "All", "");
    		if(sXml.indexOf("|$$|") >= 0) {
    			combObj.SetSelectText("All");
    			return;
    		}
    		
    		var arrData=ComXml2ComboString(sXml, "code", "name");    		
    		if (arrData != null){
                var arrCode=arrData[0].split("|");
                var arrName=arrData[1].split("|");
                for(i=0; i < arrName.length;i++){
        			combObj.InsertItem(i+1, arrName[i], arrCode[i]);        
                }
            }
            combObj.SetSelectText("All");
    	}
    	function setServiceModeCombo(sXml){
    		var combObj=f_svc_mod_cd;  // f_serviceModeCombo
    		combObj.InsertItem(0, "All", "");
    		if(sXml.indexOf("|$$|") >= 0) {
    			combObj.SetSelectText("All");
    			return;
    		}
    		var arrData=ComXml2ComboString(sXml, "code", "name");
    		if (arrData != null){
                var arrCode=arrData[0].split("|");
                var arrName=arrData[1].split("|");
                for(i=0; i < arrName.length;i++){
        			combObj.InsertItem(i+1, arrName[i], arrCode[i]);        
                }
            }
            combObj.SetSelectText("All");
    	}
    	/**
    	* input validation
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		switch(sAction){		
    		case IBSAVE:	
    			var dr=sheetObj.ColValueDup("org_rgn_cd|dest_rgn_cd");
    			if(dr>0){				
    				ComShowCodeMessage('COM12115', 'Origin Region, Destination Region Group');
    				sheetObj.SelectCell(dr,"dest_rgn_cd");
    				return false;
    			}
    			break;
    		}
    		return true;
    	}
        function sheet1_OnChange(sheetObj, row, col, value)
        {
        }

        function resizeSheet(){
       	 ComResizeSheet(sheetObjects[0]);
        }
        
        //SJH.20150105.ADD : 저장후 메시지 추가 나중 SC로 교체!!!
        function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
            if(ErrMsg == ""){
                // [COM130102] : Success
            	ComShowMessage(ComGetMsg("COM130102","Data"));
            }else{
                ComShowMessage(ComGetMsg("COM132101"));
            }	
			//retrieving in case of successful saving
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            for(var i=1; i<=sheetObj.RowCount(); i++)
            {
            	cur_code=sheetObj.GetCellValue(i,"svc_mod_cd");
            	if(sel_code == cur_code)
            	{
            		sheetObj.SelectCell(i, 3, true);
            		ComOpenWait(false);
            		return;
            	}
            }		// End for
        }