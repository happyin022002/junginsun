/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0008.js
*@FileTitle  : Budget Creation 
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
    var headerRowHeight = 30;//Head Row Height    
    // Event handler processing by button click event
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
     * adding first-served functions after loading screen.
     */
    function loadPage(){
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	initControl();
    	
    	var formObj=document.form;
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);	//Check Running Batch
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
					var HeadTitle1="|Seq|Scenario|Target VVD|Rev Lane|Rev Month|CAPA|Budget\nCreation ID|Budget\nCreation Date";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="sheet1_";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scnr_no",    KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rlane_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mon",        KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"capa",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
					InitColumns(cols);

					SetEditable(0);
//					SetCountPosition(2);
		            SetShowButtonImage(1);
		            SetHeaderRowHeight(headerRowHeight);
			        //SetSheetHeight(440);
		            resizeSheet(sheetObj);
				}
			    break;
		  	case "sheet2":
		  	    with(sheetObj){
		  			var HeadTitle1="|Seq|Scenario|Currency|USD Rate";
		  			var headCount=ComCountHeadTitle(HeadTitle1);
		  			var prefix="sheet2_";

		  			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		  			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		  			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		  			InitHeaders(headers, info);

		  			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		  			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
		  			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scnr_no",      KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		  			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_curr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		  			             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix+"usd_xch_rt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		  			InitColumns(cols);

		  			SetEditable(0);
//		  			SetCountPosition(2);
		            SetShowButtonImage(1);
		            SetHeaderRowHeight(headerRowHeight);
		            //SetSheetHeight(440);
		            resizeSheet(sheetObj);
		  		}
		  	    break;				
    	}
    }
    
    /**
     * registering initial event 
     */
    function initControl(){
    	 axon_event.addListener ('keydown', 'obj_keydown', 'form');
     	axon_event.addListenerFormat('blur',  	'obj_blur',  	form);
    	setToday(document.form.year, "y");//current year
    	document.form.txtsDate.value=document.form.year.value +"-01"; 
    	document.form.txteDate.value=document.form.year.value +"-12"; 
    }
    
    function obj_keydown(){
       	isShift=event.shiftKey ? true : false;
    }
    
    /**
     * Handling onblur event
     * @return
     */
    function obj_blur(){
    	var formObj=document.form;
		obj=event.srcElement;      	
	   	with(formObj){
	   		if(obj.name=="txtsDate" || obj.name=="txteDate"){
	   			var creDtFr=ComReplaceStr(txtsDate.value,"-","");
	   			var creDtTo=ComReplaceStr(txteDate.value,"-","");
	   			switch(ComGetEvent("name")) {
	   				case "txtsDate":	// Agreement From Date
	   					if(creDtFr != '' && creDtTo != ''){
		    				if(creDtFr > creDtTo){
		    					ComShowCodeMessage('COM12133','To date','From date','greater');
		    					txtsDate.value='';
		    					document.form.txtsDate.focus();
		    					return false;
		    				}
		    			}
		    	        break;
		    		case "txteDate":	// Agreement To Date
		    			if(creDtFr != '' && creDtTo != ''){
		    				if(creDtFr > creDtTo){
		    					ComShowCodeMessage('COM12133','To date','From date','greater');
		    					txteDate.value='';
		    					txteDate.focus();
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
    
    
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
            switch(srcName) {
	            case "btns_calendar_s":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
	    	        cal.select(form.txtsDate, "yyyy-MM");
	            	break;
	            case "btns_calendar_e":
	            	var cal=new ComCalendar();
	            	cal.setDisplayType('month');
	            	cal.select(form.txteDate, "yyyy-MM");
	            	break;
            	case "btn_creation":
    				if(!ComShowCodeConfirm("PSO00041", "create")){
    					return;
    				}
            		ComOpenWait(true);
            		doActionIBSheet(sheetObject1,formObject,IBCREATE);
            		ComOpenWait(false);
		    		break;
            	case "btn_retrieve":
            		ComOpenWait(true);
            		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            		ComOpenWait(false);                		
            		break;		    			
		        case "btn_down_excel":
					if(sheetObjects[0].RowCount()== 0 && sheetObjects[1].RowCount()== 0){
						ComShowCodeMessage("COM132501");
						return;
					}
					var paramObj=new Object();
					paramObj.title="Budget Creation"
					 	 			 + "\\n(Month : " + formObject.txtsDate.value + " ~ " + formObject.txteDate.value + ")";
					var url="";

					sheetObjects[0].Down2ExcelBuffer(true);
					if(sheetObjects[0].RowCount() > 0){//no data
						sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1  , FileName:'downexcel',SheetName:'sheet1' });
					}
					if(sheetObjects[1].RowCount() > 0){//no data
						sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1  , FileName:'downexcel',SheetName:'sheet2' });
					}
					sheetObjects[0].Down2ExcelBuffer(false);
					break;
		        case "btn_upload_excel":
		        	sheetObjects[0].LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false});
		            break;
		        case "btn_upload_excel2":            	
		        	sheetObjects[1].LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false});
		        	break;
		        case "btn_save":
		        	doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
     *  handling sheet process
     */ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        	case IBCREATE://Creation Button Click
        		if ( sheetObj.id == "sheet1"){
        			ComOpenWait(true);
					formObj.f_cmd.value=ADD;
					var sXml=sheetObj.GetSearchData("VOP_PSO_0008GS.do", FormQueryString(formObj));
					sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
					ComOpenWait(false);
					var statusCode=ComGetEtcData(sXml, "BatchStatus" );
					switch(statusCode){
						case "4"://Completion
							ComShowCodeMessage("COM12116", "Budget Creation  Excution");
							break;
						case "5"://
							ComShowCodeMessage("COM12151", "Budget Creation  Excution");
							break;
						case "6"://Processing
							formObj.status.value="Processing";
							ComShowCodeMessage("PSO00038", "Budget Creation");
							break;
						default: break;							
					}
        		}
             	break;
        	case IBSEARCH:      //Retrieving
				if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "sheet1"){
						var aryPrefix=new Array("sheet1_", "sheet2_");
						formObj.f_cmd.value=SEARCH;
		                sheetObjects[0].SetWaitImageVisible(0);
		                var sXml=sheetObj.GetSearchData("VOP_PSO_0008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
 			            var arrXml=sXml.split("|$$|");
 			            var isRunning=ComGetEtcData(arrXml[0], "IS_RUNNING");
 			            formObj.status.value=isRunning == "true" ? "Processing" : "";
 			            sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
 			            sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
 					}
				}
 				break;
        	case IBSEARCH_ASYNC01:      //OPEN (Check Running Batch)
        		var aryPrefix=new Array("sheet1_");
         		formObj.f_cmd.value=COMMAND02;
         		sheetObjects[0].SetWaitImageVisible(0);
         		var sXml=sheetObj.GetSearchData("VOP_PSO_0008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
         		var isRunning=ComGetEtcData(sXml, "IS_RUNNING");
         		formObj.status.value=isRunning == "true" ? "Processing" : "";
//         		sheetObjects[0].LoadSearchData(sXml);
	            break;
        	case IBSAVE:
        		if(validateForm(sheetObj,formObj,sAction)){
        			ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					var SaveStr=ComGetSaveString(new Array(sheetObj)); // array
					var aryPrefix=new Array("sheet1_");	//prefix string array
					var sXml=sheetObj.GetSaveData("VOP_PSO_0008GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					ComOpenWait(false);
					sheetObj.LoadSaveData(sXml);
	             	break;
	             }
        }
    }
	
    /**
     * handling process for input validation
     */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction){
 	        	case IBSAVE:
 	        		if(sheetObj.RowCount()==0){
 	        			return false;
 			        }
 			        var cnt=0;
 			        for(var i=0; i<sheetObj.RowCount(); i++){
 			        	if(sheetObj.GetRowStatus(i) == "I"){
 			        			cnt++;
 			        	}
 			        }
		        	if(cnt==0){
		        		return false;
		        	}
		        	if(!ComShowConfirm("Do you want to overwrite?")){
		        		return false;
		        	}
		        	break;
			}	
		}
        return true;
	}

	function ComJooGetPgmTitle(sheetObj, paramObj){
        var doc=document.all;
        var pageUrl="FNS_JOO_EXCEL.do?";
        var sTitle="";
        var sTalign="center,left,right";
        var sAlign="";
        var sCols="";
        var iCols=0;
        var sOrientation="";
        var sColumnwidth="";
        var sDatarowheight="";
        if(paramObj.title == undefined ){
            sTitle=doc.title.innerHTML.replace("&nbsp;","");
            sTitle=sTitle.replace("&amp;"," ");
        }else{
            sTitle=paramObj.title;
        }
        if(paramObj.align == undefined ){
            sAlign="center"; 
        }else if(sTalign.indexOf(paramObj.align) == -1 ){
            sAlign="left";
        }else{
            sAlign=paramObj.align;
        }
        if(paramObj.cols == undefined ){
            for(var i=0; i<= sheetObj.LastCol(); i++){
            	if ( sheetObj.GetCellProperty(0, i, dpDataType)!= dtHidden
            	    && sheetObj.GetCellProperty(0, i, dpDataType)!= dtHiddenStatus
                    ) {
                    iCols++;
            	}
            }
        }else{
            iCols=eval(paramObj.cols);
        }
        if(paramObj.orientation == undefined ){
            sOrientation="Landscape";
        }else{
            sOrientation=paramObj.orientation;
        }
        if(paramObj.columnwidth == undefined ){
            sColumnwidth="";
        }else{
            sColumnwidth=paramObj.columnwidth;
        }
        if(paramObj.datarowheight == undefined ){
            sDatarowheight="";
        }else{
            sDatarowheight=paramObj.datarowheight;
        }        
        var sUrl=pageUrl+"title="+sTitle+"&align="+sAlign+"&cols="+iCols+"&columnwidth="+sColumnwidth+"&datarowheight="+sDatarowheight;
        return sUrl;
	}

	function resizeSheet(){
	    for (var i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}