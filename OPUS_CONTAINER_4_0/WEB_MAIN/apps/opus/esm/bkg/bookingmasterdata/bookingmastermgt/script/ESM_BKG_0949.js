/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0949.js
*@FileTitle  : Documentation Cut-Off Time Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/ 

	// Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
	var prefix="sheet1_";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /* */
             var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
    				switch(srcName) {
    					case "btn2_RowAdd":
    							alert(srcName);
    					break;
    					case "btn2_Delete":
    							alert(srcName);
    					break;
    					case "btn1_Retrieve":
    							alert(srcName);
    					break;
    					case "btn1_Save":
    							alert(srcName);
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
         * adding first-served functions after loading screen.
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
            }	
         
    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
    		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    		//document.form.yd_cd.focus(); 
    		initControl();
        }
      function initControl() {
    	  //alert("test");
      	//var formObject=document.form;
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); 
        //axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); 
        // axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); 
        //Enter key 
      }
     /**
	 * HTML Control : onkeypressEvent
	 **/
//     function obj_keypress(){
//		switch(event.srcElement.dataformat){
//	    	case "int":
//		        ComKeyOnlyNumber(event.srcElement);
//		        break;
//	        case "float":
//	            ComKeyOnlyNumber(event.srcElement, ".");
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet();
//	            break;
//	        case "engdn":
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        default:
//	            ComKeyOnlyNumber(event.srcElement);
//	    }
//	}
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    		var sheetId=sheetObj.id;
    		  with(sheetObj){
    			    switch(sheetId) {
    			   case "sheet1":
    			 
    			   var HeadTitle1="|CHK|Seq|POL|Destination Country|Lane|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|Documentation Cut-off Time|DELT|User ID|Office|Update Date";
    			   var HeadTitle2="|CHK|Seq|POL|Destination Country|Lane|ETA|ETB|ETD|DAY|Time|Time|DAY|DAY|Excluding Friday|Excluding Saturday|Excluding Sunday|Excluding Holiday|DELT|User ID|Office|Update Date";
    			   (21, 0, 0, true);

    			   SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );

    			   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1, FrozenCol:6 };
    			   var headers = [ { Text:HeadTitle1, Align:"Center"},
    			                 { Text:HeadTitle2, Align:"Center"} ];
    			   InitHeaders(headers, info);

    			   var cols = [ 
    			             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del" },
    			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, AcceptKeys:"E|N", InputCaseSensitive:1},
    			             {Type:"Combo",     Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dest_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eta",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"day",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"itval_hrs",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hour",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Combo",     Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:prefix+"doc_clz_dy_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"doc_clz_dy_hrs", KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    			             {Type:"CheckBox",  Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xcld_fri_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"CheckBox",  Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xcld_sat_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"CheckBox",  Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xcld_sun_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"CheckBox",  Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"hol_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    			             {Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"doc_clz_tp_cd" },
    			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"xcld_fri_flg" },
    			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"xcld_sat_flg" },
    			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"xcld_sun_flg" },
    			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"xcld_hol_flg" },
    			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"usr_nm" } ];
    			    
		    			   InitColumns(cols);
		    			   SetWaitImageVisible(0);
		    			   SetEditable(1);
		    			   SetSheetHeight(422);
		    			   SetRangeBackColor(1,5,1,17,"#555555");
		    			   SetColProperty(prefix+"delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
    			    }
    		
            }
        }
      // Event handler processing by button name */
         function processButtonClick(){
              /* */
              var sheetObject=sheetObjects[0];
              /*******************************************************/
              var formObject=document.form;
         	try {
         		var srcName=ComGetEvent("name");
     				switch(srcName) {
     					case "btn2_RowAdd":
//     						sheetObject.DataInsert(-1);
     						var newRow=setDataInsert(sheetObject, 1);
     						sheetObject.SetCellValue(sheetObject.GetSelectRow(), prefix + "hour","Hour",0);
     						sheetObject.SetCellValue(sheetObject.GetSelectRow(), prefix + "itval_hrs"," ",0);
     						sheetObject.SetCellValue(sheetObject.GetSelectRow(), prefix + "doc_clz_dy_cd"," ",0);
     						sheetObject.SelectCell(sheetObject.GetSelectRow(), prefix + "yd_cd", true, '');
     					break;
     					case "btn2_Delete":
     						doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
     					break;
     					case "btn_Retrieve":
     						if(sheetObjects[0].IsDataModified()){
     							var rflag=doActionIBSheet(sheetObjects[0],document.form, IBSAVE);
     						}else{
     							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);  
     						}
    					break;
     					case "btn1_Save":
     						doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
      // handling process for Sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            switch(sAction) {
              	case IBSEARCH:      //retrieve
              		if(!validateForm(sheetObj,formObj,sAction)) return;
 					ComOpenWait(true);
		            formObj.f_cmd.value=SEARCH;   
		            sheetObj.DoSearch("ESM_BKG_0949GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
		            break;
		 		case IBSAVE:        //Save
		 			if(!validateForm(sheetObj,formObj,sAction)) return;
			 		formObj.f_cmd.value=MULTI;	
			 		var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
	                sheetObj.DoSave("ESM_BKG_0949GS.do", sParam);
					break;
				case SEARCH01:      //retrieve(service lane code)
					formObj.f_cmd.value=SEARCH01;   
					var searchXml=sheetObj.GetSearchData("ESM_BKG_0949GS.do" ,FormQueryString(formObj));
					var slanCd=ComGetEtcData(searchXml,"slanCd");
					var slanVa=ComGetEtcData(searchXml,"slanVa");
					var cntNm=ComGetEtcData(searchXml,"cntNm");
					var cntCd=ComGetEtcData(searchXml,"cntCd");
					sheetObj.SetColProperty("sheet1_vsl_slan_cd", {ComboText:slanCd, ComboCode:slanVa}); //ALL *
					sheetObj.SetColProperty("sheet1_dest_cnt_cd", {ComboText:cntNm, ComboCode:cntCd} );
					var temp=slanVa.split("|");
					for (var i=1 ; i < temp.length ; i++){
						ComAddComboItem(formObj.vsl_slan_cd, temp[i], temp[i]);//ALL
					}
					break;
		            // Day Type code
	            case IBSEARCH_ASYNC02:
					var prefix="sheet1_";
	            	formObj.f_cmd.value=SEARCH03;
	            	var sXml=sheetObj.GetSearchData("ESM_BKG_0949GS.do", FormQueryString(formObj));
	                var arrData=ComXml2ComboString(sXml, "val", "name");
	                if (arrData != null && arrData.length == 2) {
					    sheetObj.SetColProperty(prefix+"doc_clz_dy_cd", {ComboText:arrData[1], ComboCode:arrData[0]} );
	                }
	                break;
				case IBDELETE:      // Delete	 					
					ComRowHideDelete(sheetObj, "sheet1_del");
					break;
            }
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	switch(sAction) {
        		case IBSEARCH:      //retrieve
        			/*if (formObj.yd_cd.value == ''){
        				ComShowCodeMessage("BKG00137");//POL/POD is not available
        				formObj.yd_cd.focus();        				
        				return false;
        			}*/
        			break;
        		case IBSAVE:        //Save
        			for(var i=2 ; i < sheetObj.RowCount()+2  ; i++){
        				if (sheetObj.GetRowStatus(i) == 'I' || sheetObj.GetRowStatus(i) == 'U'){
        					if (sheetObj.GetCellValue(i, prefix + "yd_cd") == ''){
        						ComShowCodeMessage("BKG00137");//POL is not available
        						sheetObj.SelectCell(i, "POL", true, '');
        						return false;
        					}
        					var ydCd = sheetObj.GetCellValue(i, prefix + "yd_cd");
        					var destCntCd = sheetObj.GetCellValue(i, prefix + "dest_cnt_cd");
        					var vslSlanCd = sheetObj.GetCellValue(i, prefix + "vsl_slan_cd");
        					for(var j=2 ; j < sheetObj.RowCount()+2 ; j++){
        						if(j==i) continue;
        						if(ydCd == sheetObj.GetCellValue(j, prefix + "yd_cd") &&
        							destCntCd == sheetObj.GetCellValue(j, prefix + "dest_cnt_cd") &&
        							vslSlanCd == sheetObj.GetCellValue(j, prefix + "vsl_slan_cd")){
        							if(destCntCd == "*"){
        								destCntCd = "ALL";
        							}
        							if(vslSlanCd == "*"){
        								vslSlanCd = "ALL";
        							}
        							ComShowCodeMessage("BKG08250", "POL : "+ydCd+" , Destination Country : "+destCntCd+" , Lane : "+vslSlanCd);
        							return false;
        						}
        					}
        					var eta = sheetObj.GetCellValue(i, prefix + "eta");
        					var etb = sheetObj.GetCellValue(i, prefix + "etb");
        					var etd = sheetObj.GetCellValue(i, prefix + "etd");
        					var day = sheetObj.GetCellValue(i, prefix + "day");
        					if (eta == '1'){
        						sheetObj.SetCellValue(i, prefix + "doc_clz_tp_cd",'A',0);
        					}else if (etb == '1'){
        						sheetObj.SetCellValue(i, prefix + "doc_clz_tp_cd",'B',0);
        					}else if (etd == '1'){
        						sheetObj.SetCellValue(i, prefix + "doc_clz_tp_cd",'D',0);
        					}else if (day == '1'){
        						sheetObj.SetCellValue(i, prefix + "doc_clz_tp_cd",'Y',0);
        					}
//        					if (sheetObj.GetCellValue(i, prefix + "eta") == '1'){
//        						sheetObj.SetCellValue(i, prefix + "doc_clz_tp_cd",'A',0);
//        					}else if (sheetObj.GetCellValue(i, prefix + "etb") == '1'){
//        						sheetObj.SetCellValue(i, prefix + "doc_clz_tp_cd",'B',0);
//        					}else if (sheetObj.GetCellValue(i, prefix + "etd") == '1'){
//        						sheetObj.SetCellValue(i, prefix + "doc_clz_tp_cd",'D',0);
//        					}else if (sheetObj.GetCellValue(i, prefix + "day") == '1'){
//        						sheetObj.SetCellValue(i, prefix + "doc_clz_tp_cd",'Y',0);
//        					}
        					if (sheetObj.GetCellValue(i, prefix + "hol_chk") == '1'){
        						sheetObj.SetCellValue(i, prefix + "xcld_hol_flg",'Y',0);
        					}else{
        						sheetObj.SetCellValue(i, prefix + "xcld_hol_flg",'N',0);
        					}
        					
        					//BP #10744 Excluding FRI SAT SUN check logic 
        					if (sheetObj.GetCellValue(i, prefix + "xcld_fri_chk") == '1'){
        						sheetObj.SetCellValue(i, prefix + "xcld_fri_flg",'Y',0);
        					}else{
        						sheetObj.SetCellValue(i, prefix + "xcld_fri_flg",'N',0);
        					}
        					
        					if (sheetObj.GetCellValue(i, prefix + "xcld_sat_chk") == '1'){
        						sheetObj.SetCellValue(i, prefix + "xcld_sat_flg",'Y',0);
        					}else{
        						sheetObj.SetCellValue(i, prefix + "xcld_sat_flg",'N',0);
        					}
        					
        					if (sheetObj.GetCellValue(i, prefix + "xcld_sun_chk") == '1'){
        						sheetObj.SetCellValue(i, prefix + "xcld_sun_flg",'Y',0);
        					}else{
        						sheetObj.SetCellValue(i, prefix + "xcld_sun_flg",'N',0);
        					}
        					
        					if(eta == "0" && etb == "0" &&  etd == "0" && day == "0"){
        						ComShowCodeMessage("BKG08251");
        						return false;
        					}
        				}
        			}
        			break;
        	}
            return true;
        }
         /**
          * ETA,ETB,ETD,DAY : Radio buttons
          */
        function sheet1_OnClick(sheetObj,Row, Col, Value){
        	// ETA, ETB, ETD, DAY : Radio buttons
    		if (sheetObj.ColSaveName(Col) == ( prefix + "eta")){
    			if (sheetObj.GetCellValue(Row, (prefix + "eta")) == 1){
    				sheetObj.SetCellValue(Row, (prefix + "etb"),0,0);
    				sheetObj.SetCellValue(Row, (prefix + "etd"),0,0);
    				sheetObj.SetCellValue(Row, (prefix + "day"),0,0);
    			}
    			sheetObj.SetCellValue(Row, prefix + "doc_clz_dy_cd","",0);
    			sheetObj.SetCellValue(Row, prefix + "doc_clz_dy_hrs","",0);
    		}else if (sheetObj.ColSaveName(Col) == ( prefix + "etb")){
    			if (sheetObj.GetCellValue(Row, (prefix + "etb")) == 1){
    				sheetObj.SetCellValue(Row, (prefix + "eta"),0,0);
    				sheetObj.SetCellValue(Row, (prefix + "etd"),0,0);
    				sheetObj.SetCellValue(Row, (prefix + "day"),0,0);
    			}
    			sheetObj.SetCellValue(Row, prefix + "doc_clz_dy_cd","",0);
    			sheetObj.SetCellValue(Row, prefix + "doc_clz_dy_hrs","",0);
    		}else if (sheetObj.ColSaveName(Col) == ( prefix + "etd")){
    			if (sheetObj.GetCellValue(Row, (prefix + "etd")) == 1){
    				sheetObj.SetCellValue(Row, (prefix + "eta"),0,0);
    				sheetObj.SetCellValue(Row, (prefix + "etb"),0,0);
    				sheetObj.SetCellValue(Row, (prefix + "day"),0,0);
    			}
    			sheetObj.SetCellValue(Row, prefix + "doc_clz_dy_cd","",0);
    			sheetObj.SetCellValue(Row, prefix + "doc_clz_dy_hrs","",0);
    		}else if (sheetObj.ColSaveName(Col) == ( prefix + "day")){
    			if (sheetObj.GetCellValue(Row, (prefix + "day")) == 1){
    				sheetObj.SetCellValue(Row, (prefix + "eta"),0,0);
    				sheetObj.SetCellValue(Row, (prefix + "etb"),0,0);
    				sheetObj.SetCellValue(Row, (prefix + "etd"),0,0);
    				sheetObj.SetCellEditable(Row, prefix + "hour",false);
    				sheetObj.SetCellEditable(Row, prefix + "itval_hrs",false);
    				
    			}
    			sheetObj.SetCellValue(Row, prefix + "itval_hrs","",0);
    			sheetObj.SetCellValue(Row, prefix + "doc_clz_dy_hrs","17:00",0);
    		}
    		keyFieldEnable (sheetObj,Row, Col, Value);
    	    sheetObj.SetEditableColorDiff(1);
        }
          /**
           * DO NOT save if POL and Destination are same
           */
         function sheet1_OnAfterEdit(sheetObj,Row, Col, Value){
        	var formObj=document.form;
        	if (Col == '3' || Col == '4'){
        		var polCd=sheetObj.GetCellValue(Row, 3);
        		var cntCd=sheetObj.GetCellValue(Row, 4);
        		if (polCd == ''){
        			ComShowCodeMessage("BKG00137");//POL/POD is not available
        			sheetObj.SelectCell(Row, 3, true, '');
        			return;
        		}
        		if (Col == '3'){
        			formObj.pol.value=sheetObj.GetCellValue(Row,Col);
        			formObj.f_cmd.value=SEARCH02;   					  
        			var searchXml=sheetObj.GetSearchData("ESM_BKG_0949GS.do" ,FormQueryString(formObj));
        			var check=ComGetEtcData(searchXml,"check");
        			if (check == 'N'){
        				ComShowCodeMessage("BKG00164");//POL is NOT Registered
        				sheetObj.SelectCell(Row, Col, true, '');
        				return;
        			}
        		}        		        		
        		if (polCd.substring(0,2) == cntCd){
        			ComShowCodeMessage("BKG00053");//POL and POD are the same. Check booking route again.
        			sheetObj.SetCellValue(Row, 4,"*",0);
        			return;
        		}
        	}
        }
    /**
   	 * Mouse Movement Event
   	 * @param Button
   	 * @param Shift
   	 * @param X
   	 * @param Y
   	 * @return
   	 */
   	function sheet1_OnMouseMove(Button, Shift, X, Y) {
   		//window.status = "OnMouseMove Row=" + Row + ", Col=" + Col + ", Text=" + sText;
   		Row=sheetObjects[0].MouseRow();
   		Col=sheetObjects[0].MouseCol();
        var colSaveName=sheetObjects[0].ColSaveName(Col);
   		if(colSaveName == "sheet1_upd_usr_id") {
   			sText=sheetObjects[0].GetCellValue(Row,16);
   		} else {
   			sText="";
   		}
   		sheetObjects[0].MouseToolTipText=sText;
   	}
    /**
   	 * Activating the item by the value of ETA, ETB, ETD, DAY
   	 * if ETA, ETB, ETD item checked, Time Field activating 
   	 * if DAY 			item checked, Day Field activating
   	 * @param sheetObj
   	 * @param Row
   	 * @param Col
   	 * @param Value
   	 * @return
   	 */
   	function keyFieldEnable (sheetObj,Row, Col, Value) {
		// Activating the item by the value of ETA, ETB, ETD, DAY
   		if (sheetObj.ColSaveName(Col) == ( prefix + "day")) {
			if (sheetObj.GetCellValue(Row, (prefix + "day")) == 1 ){
        	    sheetObj.SetCellEditable(Row, prefix + "itval_hrs",false);
        	    sheetObj.SetCellEditable(Row, prefix + "hour",false);
				sheetObj.SetCellEditable(Row, prefix + "doc_clz_dy_cd",true);
				sheetObj.SetCellEditable(Row, prefix + "doc_clz_dy_hrs",true);
			}
		}else if (sheetObj.ColSaveName(Col) == ( prefix + "eta") || sheetObj.ColSaveName(Col) == ( prefix + "etb") || sheetObj.ColSaveName(Col) == ( prefix + "etd")){
			if (sheetObj.GetCellValue(Row, (prefix + "eta")) == 1 || sheetObj.GetCellValue(Row, (prefix + "etb")) == 1 || sheetObj.GetCellValue(Row, (prefix + "etd")) == 1){
				sheetObj.SetCellEditable(Row, prefix + "doc_clz_dy_cd",false);
				sheetObj.SetCellEditable(Row, prefix + "doc_clz_dy_hrs",false);
        	    sheetObj.SetCellEditable(Row, prefix + "itval_hrs",true);
        	    sheetObj.SetCellEditable(Row, prefix + "hour",true);
			}
		}
//		if (sheetObj.ColSaveName(Col) == ( prefix + "eta") || sheetObj.ColSaveName(Col) == ( prefix + "etb") || sheetObj.ColSaveName(Col) == ( prefix + "etd")){
//			alert(sheetObj.GetCellValue(Row, (prefix + "eta")));
//			alert(sheetObj.GetCellValue(Row, (prefix + "etb")));
//			if (sheetObj.GetCellValue(Row, (prefix + "eta")) == 0 || sheetObj.GetCellValue(Row, (prefix + "etb")) == 0 || sheetObj.GetCellValue(Row, (prefix + "etd")) == 0){
//				alert("E");
//				sheetObj.SetCellEditable(Row, prefix + "doc_clz_dy_cd",false);
//				sheetObj.SetCellEditable(Row, prefix + "doc_clz_dy_hrs",false);
//        	    sheetObj.SetCellEditable(Row, prefix + "itval_hrs",true);
//        	    sheetObj.SetCellEditable(Row, prefix + "hour",true);
//			}
//		} else if (sheetObj.ColSaveName(Col) == ( prefix + "day")) {
//			alert("00");
//			alert(sheetObj.GetCellValue(Row, (prefix + "day")));
//			if (sheetObj.GetCellValue(Row, (prefix + "day")) == 0 ){
//				alert("D");
//        	    sheetObj.SetCellEditable(Row, prefix + "itval_hrs",false);
//        	    sheetObj.SetCellEditable(Row, prefix + "hour",false);
//				sheetObj.SetCellEditable(Row, prefix + "doc_clz_dy_cd",true);
//				sheetObj.SetCellEditable(Row, prefix + "doc_clz_dy_hrs",true);
//			}
//		}
   	}

   	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }
   	
   	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
   		doActionIBSheet(sheetObj,document.form,IBSEARCH);
   		ComOpenWait(false);
   	}
   	/**
	  * setDataInsert 호calling .<br>
	  * DELT FLG를 'N'로setting 
	  * @param sheetObj, sNo
	  */
	function setDataInsert(sheetObj, sNo) {
		var formObj=document.form;
		switch (sNo) {
		case 1:
			var prefix="sheet1_";
			var nRow=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(nRow, prefix + "delt_flg",'N');
			break;
		}
		return nRow;
	}