/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0753.js
*@FileTitle  : VVD Selection Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0753 : business script for esm_bkg_0753
     */
  
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
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
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            initControl();
            document.form.vps_etb_dt.value=getCalculatedDate(0,-1,0,"-");
    		document.form.vps_etd_dt.value=getCalculatedDate(0,0,0,"-");
    		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
         /**
          * registering initial event 
          */
          function initControl() {
            	var formObject=document.form;
                axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
                axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
//                axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
                axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//Enter key 처리
//                axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
            }
     /**
	 * handling key event
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
    				var sheetID=sheetObj.id;
    				switch(sheetID) {
    					case "sheet1":
							with (sheetObj) {
	    						var HeadTitle1="|Sel.|LANE|VVD|ETA|ETD";
	    						var headCount=ComCountHeadTitle(HeadTitle1);
	
	    						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	    						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    						var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    						InitHeaders(headers, info);
	
	    						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	    						             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
	    						             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	    						             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	    						             {Type:"Date",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    						             {Type:"Date",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    						 
	    						InitColumns(cols);
	    						SetSheetHeight(180);
	    						SetEditable(1);
    						}
    						break;
    					case "sheet2":
							with (sheetObj) {
	    						var HeadTitle1="|Sel.|VVD|LANE";
	    						var headCount=ComCountHeadTitle(HeadTitle1);
	    						var prefix="sheet2_";
	
	    						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	    						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    						var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    						InitHeaders(headers, info);
	
	    						var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	    						             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Chk" },
	    						             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	    						             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	    						             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd" },
	    						             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no" },
	    						             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd" } ];
	    						 
	    						InitColumns(cols);
	    						SetSheetHeight(180);
	    						SetEditable(1);
	    						SetColProperty(0, 2, {AcceptKeys:"E|N" , InputCaseSensitive:1});	
	    						SetColProperty(0, 3, {AcceptKeys:"E" , InputCaseSensitive:1});	
    						}
    						break;						
    			}
    	}
      // Event handler processing by button name */
         function processButtonClick(){
     		         var sheetObject1=sheetObjects[0];
         		     var sheetObject2=sheetObjects[1];
              var formObject=document.form;
         	try {
         		var srcName=ComGetEvent("name");
     			switch(srcName) {
	     			case "btn_rowAdd":
	     				sheetObjects[1].DataInsert(-1);
	 				break;
     				case "btn_add":
     					addDelRow("add");
     				break;
     				case "btn_del":
     					addDelRow("delete");
     				break;
     				case "btns_up":
     					rowUpDown(sheetObject2, "UP");
     					break;
     				case "btns_down":
     					rowUpDown(sheetObject2, "DOWN");
     					break;
     				case "btn_loadexcel":
      					sheetObject2.LoadExcel();
     				break;	
     				case "btn_Retrieve":
     					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     				break;
     				case "btn_ok":
     					doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
     				break;											
     				case "btn_close":
     					ComClosePopup(); 
     				break;
     				case "btn_calendar":
     					var cal=new ComCalendarFromTo();
     	                cal.select(formObject.vps_etb_dt, formObject.vps_etd_dt, 'yyyy-MM-dd');
     				break;
     				case "btn_edate":
     					var cal=new ComCalendar();
     					cal.select(formObject.vps_etd_dt, 'yyyy-MM-dd');
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
      // handling sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
    					case IBSEARCH: 
    						if(!validateForm(sheetObj,formObj,sAction)) return;
    						for(var i=0 ; i < formObj.check_op.length ; i++){
    							if (formObj.check_op[i].checked == true){
    								formObj.vps_eta_dt.value=formObj.check_op[i].value;
    							}
    						}
    						formObj.f_cmd.value=SEARCH;  
    						sheetObj.SetWaitImageVisible(0);
    				        ComOpenWait(true);
     						sheetObj.DoSearch("ESM_BKG_0753GS.do",FormQueryString(formObj) );
    					break;
    					case IBSAVE:    
    						//if(!validateForm(sheetObj,formObj,sAction)) return;
    						if (sheetObj.RowCount()< 1) {
    							alert("Select Item");
    							return;
    						}
    						for (var i=1 ; i < sheetObj.RowCount()+1 ; i++){
    							if (sheetObj.GetCellValue(i,2) == ''){
    								alert("You must input VVD");   								
    								sheetObj.SelectCell(i, 2, true, ' ');
    								return;
    							}else{
    								var idx=sheetObj.GetCellValue(i,2);
    								if (idx.length != 9){
    									alert("VVD must be 9 characters");   									
    									sheetObj.SelectCell(i, 2, true, ' ');
    									return;
    								}
    							} 
    							if (sheetObj.GetCellValue(i,3) == ''){
    								alert("You must input Lanx");   								
    								sheetObj.SelectCell(i, 3, true, ' ');
    								return;
    							}else{
    								var idx=sheetObj.GetCellValue(i,3);
    								if (idx.length != 3){
    									alert("VVD must be 3 characters");    									
    									sheetObj.SelectCell(i, 3, true, ' ');
    									return;
    								}
    							}  	
    							var vvdValue=sheetObj.GetCellValue(i,2);
    							sheetObj.SetCellValue(i,4,vvdValue.substring(0,4),0);
    							sheetObj.SetCellValue(i,5,vvdValue.substring(4,8),0);
    							sheetObj.SetCellValue(i,6,vvdValue.substring(8),0);
    						}
    						formObj.f_cmd.value=MULTI;
    						var sParam=ComGetSaveString(sheetObjects);
    						sheetObj.SetWaitImageVisible(0);
    				        ComOpenWait(true);
    	                    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
     	        	        var SaveXml=sheetObj.GetSaveData("ESM_BKG_0753GS.do", sParam);
    	        	        if (SaveXml.indexOf("OK") > -1){
    	        	        	returnValue();
    	        	        	ComClosePopup(); 
    	        	        }else{
    	        	        	alert("Invalid VVD Value");
    	        	        	return;
    	        	        }
    					break;
    					case COMMAND01:      //VVD Check
    						/*
	    					if (formObj.vps_port_cd.value == ''){
	    						alert("You must input port");
	    						formObj.vps_port_cd.focus();
	    						return false;
	    					}else{
	    						if (formObj.vps_port_cd.value.length < 5){
	    							alert("Port must be 5 characters");
	    							formObj.vps_port_cd.focus();
	    							return false;
	    						}  
	    					}
    						*/
    						var vvdValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(),2);
    						var Row=sheetObj.GetSelectRow();
	    					if (vvdValue < 9){
	     						alert("VVD must be 9 characters");
	     						sheetObj.SelectCell(Row,2);
	     						return;
	     					}else{
	     						formObj.vsl_cd.value=vvdValue.substring(0,4);
	     						formObj.skd_voy_no.value=vvdValue.substring(4,8);
	     						formObj.skd_dir_cd.value=vvdValue.substring(8);
	     					}   
	            			document.form.f_cmd.value=SEARCH01;   
	            			sheetObj.SetWaitImageVisible(0);
	        		        ComOpenWait(true);
 	         		        var sXml=sheetObj.GetSearchData("ESM_BKG_0753GS.do" , FormQueryString(document.form));
	         		        if (ComGetEtcData(sXml,"check") == "Y"){
	         		        	sheetObj.SetCellValue(Row,3,ComGetEtcData(sXml,"lane"),0);
	         		        }else{
	         		        	alert("Wrong VVD CD");
	         		        	sheetObj.SelectCell(Row, 2);
	         		        	sheetObj.SetCellValue(Row,3,'',0);
	         		        }
	         		        formObj.vsl_cd.value='';
    						formObj.skd_voy_no.value='';
    						formObj.skd_dir_cd.value='';
    					break;
            }
                ComOpenWait(false);
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	 	if (formObj.vps_port_cd.value == ''){
					alert("You must input port");
					formObj.vps_port_cd.focus();
					return false;
				}else{
					if (formObj.vps_port_cd.value.length < 5){
						alert("Port must be 5 characters");
						formObj.vps_port_cd.focus();
						return false;
					}  
				}
       if (formObj.vvd.value == ''){
//        	 	
//					if (formObj.vps_etb_dt.value == ''){
//						
//						alert("You must input period");
//						formObj.vps_etb_dt.focus();
//						return false;
//					}
//					
//					if (formObj.vps_etd_dt.value == ''){
//						
//						alert("You must input period");
//						formObj.vps_etd_dt.focus();
//						return false;
//					}
					formObj.vsl_cd.value='';
					formObj.skd_voy_no.value='';
					formObj.skd_dir_cd.value='';
        	 	}else{
        	 		if (formObj.vvd.value.length < 9){
									alert("VVD must be 9 characters");
									formObj.vvd.focus();
									return;
								}else{
									formObj.vsl_cd.value=formObj.vvd.value.substring(0,4);
									formObj.skd_voy_no.value=formObj.vvd.value.substring(4,8);
									formObj.skd_dir_cd.value=formObj.vvd.value.substring(8);
							}   
        	 }
				if (formObj.slan_cd.value != ''){
					if (formObj.slan_cd.value.length < 3){
						alert("Lane must be 3 characters");
						formObj.slan_cd.focus();
						return false;
					}    								
				}
				/*
				if (formObj.vvd.value != ''){
					if (formObj.vvd.value.length < 9){
						alert("VVD must be 9 characters");
						formObj.vvd.focus();
						return;
					}else{
						formObj.vsl_cd.value=formObj.vvd.value.substring(0,4);
						formObj.skd_voy_cd.value=formObj.vvd.value.substring(4,8);
						formObj.skd_dir_cd.value=formObj.vvd.value.substring(8);
					}   							
				}else{
					formObj.vsl_cd.value='';
					formObj.skd_voy_cd.value='';
					formObj.skd_dir_cd.value='';
				}
				*/
            return true;
        }
      /**
       * row add/delete
       */    
       function addDelRow(type){
    	   if (type == "add"){
    		   var tmp="";
    		   for (var i=1 ; i < sheetObjects[0].RowCount()+1 ; i++){
    			   if (sheetObjects[0].GetCellValue(i,1) == '1'){
    				   var chkValue=true;
    				   for (var j=1 ; j < sheetObjects[1].RowCount()+1 ; j++){
    					   if (sheetObjects[0].GetCellValue(i,3) == sheetObjects[1].GetCellValue(j,2)){
    						   tmp += "\n"+sheetObjects[0].GetCellValue(i,3);
    						   chkValue=false;
    						   break;
    					   }
    				   }
    				   if (chkValue){
	    				   var row=sheetObjects[1].DataInsert(-1);
	    				   sheetObjects[1].SetCellValue(row,2,sheetObjects[0].GetCellValue(i,3),0);
	    				   sheetObjects[1].SetCellValue(row,3,sheetObjects[0].GetCellValue(i,2),0);
    				   }
    				   if (50 <= sheetObjects[1].RowCount()) {
    					   alert(sheetObjects[1].RowCount());
    					   ComShowCodeMessage("BKG02006","","VVD input max 50!");
    					   break;
    				   }
    			   }
    		   }
    		   if (""!=tmp) {
    			   alert("exist same data\n"+tmp);
    		   }
    	   } else {
    		   var idx=sheetObjects[1].RowCount();
    		   for (var i=1 ; i < idx+1 ; i++){
    			   for (var j=1 ; j < sheetObjects[1].RowCount()+1 ; j++){
    				   if (sheetObjects[1].GetCellValue(j,1) == '1'){
	    				   sheetObjects[1].RowDelete(j,false);
	    			   }
    			   }
    	       }    			   
    	   }
       }
       /**
        * row UP/DOWN
        */
        function rowUpDown(sheetObj, type){
     	   Row=sheetObj.GetSelectRow();
     	   if (sheetObj.RowCount()> 0){
     		   if (type == 'UP'){
     			   if (Row > 1){
						tempUPCheck=sheetObj.GetCellValue(Row-1,1);
						tempUPItem=sheetObj.GetCellValue(Row-1,2);
						tempUPLane=sheetObj.GetCellValue(Row-1,3);
						tempNowCheck=sheetObj.GetCellValue(Row,1);
						tempNowItem=sheetObj.GetCellValue(Row,2);
						tempNowLane=sheetObj.GetCellValue(Row,3);
     				   sheetObj.SetCellValue(Row-1,1,tempNowCheck);
     				   sheetObj.SetCellValue(Row-1,2,tempNowItem);
     				   sheetObj.SetCellValue(Row-1,3,tempNowLane);
     				   sheetObj.SetCellValue(Row,1,tempUPCheck);
     				   sheetObj.SetCellValue(Row,2,tempUPItem);
     				   sheetObj.SetCellValue(Row,3,tempUPLane);
     				   sheetObj.SelectCell(Row-1, 1);
     			   }
     		   }else{
     			   if (Row < sheetObj.RowCount()){
						tempDWCheck=sheetObj.GetCellValue(Row+1,1);
						tempDWItem=sheetObj.GetCellValue(Row+1,2);
						tempDWLane=sheetObj.GetCellValue(Row+1,3);
						tempNowCheck=sheetObj.GetCellValue(Row,1);
						tempNowItem=sheetObj.GetCellValue(Row,2);
						tempNowLane=sheetObj.GetCellValue(Row,3);
     				   sheetObj.SetCellValue(Row+1,1,tempNowCheck);
     				   sheetObj.SetCellValue(Row+1,2,tempNowItem);
     				   sheetObj.SetCellValue(Row+1,3,tempNowLane);
     				   sheetObj.SetCellValue(Row,1,tempDWCheck);
     				   sheetObj.SetCellValue(Row,2,tempDWItem);
     				   sheetObj.SetCellValue(Row,3,tempDWLane);
     				   sheetObj.SelectCell(Row+1, 1);
     			   }
     		   }
     	   }
        }
        /**
         * handling after cell change  >>> VVD check
         */ 
        function sheet2_OnChange(sheetObj, Row, Col) {
        	if (Col == 2){
        		doActionIBSheet(sheetObjects[1],document.form,COMMAND01);
        	}
        }
        function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
        	if(isExceedMaxRow(msg))return;
	     	if(50+1 <= sheetObj.RowCount()) {
				ComShowCodeMessage("BKG02006","","VVD input max 50!");
				sheetObj.RemoveAll();
//no support[check again]CLT 				sheetObj.Rows=50+1;
			}
        }
         /**
          * Popup Return Value
          */
         function returnValue(){
        	 var sheet2=sheetObjects[1];
        	 var reValue="";
        	 for (var i=1 ; i <= sheet2.LastRow(); i++){
        		 if (i != 1){
        			 reValue += ",";
        		 }
        		 reValue += sheet2.GetCellValue(i, "sheet2_vvd");
        	 }
        	 window.opener.setVvds(reValue);
         }
         /**
          * date calculate
          */
         function getCalculatedDate(iYear,iMonth,iDay,seperator)
         {
         	var gdCurDate=new Date();
         	gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
         	gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
         	gdCurDate.setDate(gdCurDate.getDate() + iDay);
         	var giYear=gdCurDate.getFullYear();
         	var giMonth=gdCurDate.getMonth()+1;
         	var giDay=gdCurDate.getDate();
         	giMonth="0" + giMonth;
         	giMonth=giMonth.substring(giMonth.length-2,giMonth.length);
         	giDay="0" + giDay;
         	giDay=giDay.substring(giDay.length-2,giDay.length);
         	return giYear + seperator + giMonth + seperator + giDay;	
         }
