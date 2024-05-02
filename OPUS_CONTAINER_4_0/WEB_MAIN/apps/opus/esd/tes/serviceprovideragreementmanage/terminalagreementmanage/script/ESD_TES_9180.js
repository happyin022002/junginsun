/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9180.js
*@FileTitle  : Thrp Cost List & data Insert	
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
// global variable
var comboObjects=new Array();
var comboCnt=0 ; 
var sheetObjects=new Array();
var sheetCnt=0;
var costCd = "";
/** Event handler processing by button click event */
document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name 
	 */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         /*******************************************************/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
         	    case "btn_retrieve":         	    
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);    	             
        	        break;
         	    case "btn_new":
    	            sheetObject.RemoveAll();
        	        break;
         	    case "btn_save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;
         	    case "btn_ok":
    	            ComShowMessage("btn_ok button click");
        	        break;
         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21025');
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list.<br>
     * adding process for list in case of needing batch processing with other items.<br>
     * defining list on the top of source.<br>
     * 
     * @param {sheet_obj}  	sheet_obj	Sheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet.<br>
     * implementing onLoad event handler in body tag.<br>
     * adding first-served functions after loading screen..<br>
     */
    function loadPage() {
    	var opener=window.dialogArguments;
    	if (!opener) opener=window.opener;
    	if(!opener)opener=parent;
    	for(i=0; i < sheetObjects.length; i++) {
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	if(opener.document.form.lgs_cost_cd.value == "") {
    		document.form.lgs_cost_cd.value="TPNDFL";  
    	}else{
    		document.form.lgs_cost_cd.value=opener.document.form.lgs_cost_cd.value;
    	}
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);		
//    	var lccvalue = sheetObj.GetEtcData("lgsCostCDText");
//    	for(var p=0; p < comboObjects.length; p++) {
//    		initCombo(comboObjects[p], p+1, lccvalue);            
//    	}
    }
   /**
     * setting sheet initial values and header.<br>
     * param : sheetObj ==> , sheetNo ==>  .<br>
     * adding case as numbers of counting sheets.<br>
     * @param{sheetObj}		sheetObj	Sheet Object
     * @param{sheetNo}		sheetNo		 
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
		               var HeadTitle="Cost Code|Short Description|Select";
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"thrp_lgs_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:360,  Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_full_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"selCheck",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Status",    Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               resizeSheet();//SetSheetHeight(300);
                     }
                break;
             case 2:      //sheet1 init
            	    with(sheetObj){
		               var HeadTitle="Cost Code";
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];		                
		               InitColumns(cols);
		               SetEditable(1);
		               SetVisible(false);
                     }
                break;                
    	}
    }
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
	/**
	 *  handling sheet process.<br>
	 * 
	 * @param {sheetObj}	sheetObj	Sheet Object
	 * @param {formObj}		formObj		Form Object
	 * @param {sAction}		sAction		Action Command
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //Retrieve
    			formObj.f_cmd.value=SEARCH;
    			var queryString = tesFrmQryStr(formObj);
     			sheetObj.DoSearch("ESD_TES_9180GS.do", queryString);
    			break;
    		case IBSAVE:      //Save
    			try{
    				document.form.loop_value.value	= sheetObjects[0].RowCount("U");												
    				formObj.f_cmd.value=ADD; 						
    				var SaveStr=sheetObjects[0].GetSaveString(true);
     				var sXml=sheetObjects[0].GetSaveData("ESD_TES_9180GS.do", tesFrmQryStr(formObj)+'&'+ SaveStr);
     				sheetObjects[0].LoadSaveData(sXml,true);
     				ComClosePopup(); 
    			}
    			catch (e){
    				ComShowCodeMessage ("TES50103", e.number, e.description); //"code:" + e.number +",설명:" + e.description);   	
    			} 	
    			break;
    	}
    }
	/**
	 * @deprecated
	 * @param {ip_sht_obj}		ip_sht_obj		input sheet object
	 * @param {opr_sht_nm_str}	opr_sht_nm_str	opr_sht_nm_str
	 */
	function setDtaCurrSht2OprSht(ip_sht_obj, opr_sht_nm_str) {
		var sheetObject=ip_sht_obj;
		//var opener_sheet_obj = eval('opener.document.'+opr_sht_nm_str);  //COIN
		var opener=window.dialogArguments;
		if (!opener) opener=window.opener;
		if(!opener) opener=parent;
		var opener_sheet_obj=opener.sheetObjects[6];  //COIN
		opener_sheet_obj.RemoveAll();
 		for (i=1; i < sheetObject.Rows; i++)
		{
			if(sheetObject.GetCellValue(i,4) == "1") {
				var iRow=opener_sheet_obj.DataInsert(-1);
				for(j=0; j <= sheetObject.LastCol(); j++)
				{
					if (sheetObject.ColSaveName(j) != "")
					{   					
						for(k=0; k<=opener_sheet_obj.LastCol(); k++)
						{
							if (opener_sheet_obj.ColSaveName(k) == sheetObject.ColSaveName(j))
							{
								opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(k),sheetObject.GetCellValue(i, sheetObject.ColSaveName(j)) ,0);
							}
						}
					}
				}
			}	
		}
	}
    /**
     * t1sheet1 Sheet search end event <br>
     * 
     * @param{sheetObj}		sheetObj	Sheet Object
     * @param{errMsg}		errMsg		Error Message
     */
	function t1sheet1_OnSearchEnd(sheetObj,errMsg){
		if(errMsg != null && errMsg != ""){
			ComShowMessage(errMsg);
		}
		
		var lccvalue = sheetObj.GetEtcData("lgsCostCDText");
    	for(var p=0; p < comboObjects.length; p++) {
    		initCombo(comboObjects[p], p+1, lccvalue);            
    	}
    	
    	var costCd = $("#lgs_cost_cd").val();
    	comboObjects[0].SetSelectCode(costCd, false);
    	
		var opener_obj=window.dialogArguments;
		if (!opener_obj) opener_obj=window.opener;
		if(!opener_obj) opener_obj=parent;
		
		var thrpvalue=sheetObjects[0].GetEtcData("thrpCostCDText");
		var thrpArray=thrpvalue.split("|");      
		for( k=0; k < sheetObjects[0].RowCount("R")+2;k++){
			for( j=0; j <thrpArray.length;j++){				
				if(sheetObjects[0].GetCellValue(k+1, 0) == thrpArray[j]) {
					sheetObjects[0].SetCellValue(k+1, 2,"1");
					sheetObjects[0].SetCellValue(k+1, 3,"U");
					opener_obj.document.form.thrpFlg.value="Y";							
				}	
			}	
		}		        
	} 
	/**
	 * t1sheet1 Sheet save end event <br>
	 * 
	 * @param{sheetObj}		sheetObj	Sheet Object
	 * @param{errMsg}		errMsg		Error Message
	 */
	function t1sheet1_OnSaveEnd(sheetObj, errMsg){      	
		if(errMsg != null){
			ComShowMessage(errMsg);
		}        
		var opener_obj=window.dialogArguments;
		if (!opener_obj) opener_obj=window.opener;
		if(!opener_obj) opener_obj=parent;
		ComShowCodeMessage('TES10093');
		opener_obj.document.form.thrpFlg.value="Y";      
	}     
	/**
	 * Combo Box <br>
	 * 
	 * @param{comboObj}		comboObj	ComboBox Object
	 * @param{comboNo}		comboNo		ComboBox No
	 * @param{lccvalue}		lccvalue	lccvalue
	 */
	function initCombo (comboObj, comboNo,lccvalue) {
		var cnt=0 ;
		var lccArray=lccvalue.split("|");				
		var valueArray;        
		switch(comboNo) {
			case 1:             
				comboObj.RemoveAll();
				with (comboObj) { 	               	
					SetColAlign(0, "left");
					for(i=0 ;i<lccArray.length;i++){
						valueArray=lccArray[i].split("--");  
						if(valueArray[0] == ""){
							break;
						}              
						InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]);    
//						comboObj.SetSelectCode("TPNDFL");
					}					    	
				}
				break;                                                                       
		}
	}
	/**
	 * ComboBox Object <br>
	 * adding process for list in case of needing batch processing with other items. <br>
	 * defining list on the top of source. <br>
	 * 
	 * @param {combo_obj}  	combo_obj	ComboBox Object
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	} 
	/**
	 * LGS Cost Code change event<br>
	 * 
	 * @param {comObj}  	comObj		ComboBox Object
	 * @param {index}  		index		index
	 * @param {text}  		text		text
	 */
	function lgs_cost_cd_c_OnChange(comObj,index,text){  
		document.form.lgs_cost_cd.value=comObj.GetSelectCode();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
	} 
