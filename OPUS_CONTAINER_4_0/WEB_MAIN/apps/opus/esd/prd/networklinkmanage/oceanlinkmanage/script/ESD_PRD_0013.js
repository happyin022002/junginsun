/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0013.js
*@FileTitle  : RHQ Ocean Link Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     			OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
		//common global variable
		var sheetObjects=new Array();
		var sheetCnt=0;
		var validateData="";
		var validateLane="";
		var retValidate=0;
		document.onclick=processButtonClick;
	    function processButtonClick(){
	         var sheetObject=sheetObjects[0];
	         var formObject=document.form;
	    	try {
	    		var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
	            /****************************
	             handling enterKey
	            *****************************/
	            switch(srcName) {
	        	    case "btn_retrieve":
	    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
	        	        break;
	        	    case "btn_new":
	    	            sheetObject.RemoveAll();
	    	            formObject.reset();
	        	        break;
	                case "btn_save":
		                doActionIBSheet(sheetObject,formObject,IBSAVE);
	    	            break;
	        	    case "btn_downexcel":
	        	    	if(sheetObject.RowCount() < 1){//no data
	   	        	     ComShowCodeMessage("COM132501");
	   	        	    } else{
	   	        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	   	        	    }
	        	        break;
	        	    case "btn_loadexcel":
	    	            doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
	        	        break;
	                    case "btng_rowadd":
	    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
	        	        break;
	        	    case "btng_rowcopy":
	    	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
	        	        break;
	                case "btng_constraintLink":
	                	document.location.href="ESD_PRD_0024.do?f_cmd="+SEARCH02+"&fromNd="+sheetObject.GetCellValue(sheetObject.GetSelectRow(), "s_from" ) +"&toNd="+sheetObject.GetCellValue(sheetObject.GetSelectRow(), "s_to" )+"&link_flg=Y&pgmNo=ESD_PRD_0024&parentPgmNo=ESD_PRD_M001&main_page=true";
	        	          break;
					case "btn_port_fm":
						selectPort('POL') ;
						break;
					case "btn_port_to":
						selectPort('POD') ;
						break;
	            } // end switch
	    	}catch(e) {
	    		if( e == "[object Error]") {
	    			ComShowMessage(ComGetMsg('COM12111'));
	    		} else {
	    			ComShowMessage(e.message);
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
	        for(var i=0;i<sheetObjects.length;i++){
	            ComConfigSheet(sheetObjects[i]);
	            initSheet(sheetObjects[i],i+1);
	            ComEndConfigSheet(sheetObjects[i]);
	        }
			axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 
			axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); 
			axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); 
			axon_event.addListener('keydown', 'PrdComKeyEnter' , 'port_fm', 'port_to');
			ComSetUIItem(sheetObjects[0],document.form,'PRD','ESD_PRD_0013');
			itemControl(sheetObjects[0],document.form,'');
	    }
	    var item_vndr='N';
	    function itemControl(sheetObj,formObj,sAction) {
	    	if(undefined != formObj.skip_flag_fun_itemControl && "Y" == formObj.skip_flag_fun_itemControl.value) {
	    		item_vndr='Y';
	    		return;
	    	}
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
		              var HeadTitle="SEQ|Del.|STS|Lane|From|To|T/Time|FQC|B/D|Dir|Preferred S/P Name|Preferred S/P Name|SUN|MON|TUE|WED|THU|FRI|SAT|1|2|3|4|5|6|7" ;
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_del_check",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_lane",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_from",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E" , InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_to",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E" , InputCaseSensitive:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"s_t_time",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"s_fqc",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"s_bd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_dr",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"s_sp_bd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"Text",      Hidden:0,  Width:450,  Align:"Left",    ColMerge:0,   SaveName:"s_sp_bd_name",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_sn",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_mn",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_te",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_wb",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_tu",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_fi",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_st",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_lane",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_from",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_to",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"h_t_time",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"h_fqc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"h_bd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_dir",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"h_sp_bd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:220,  Align:"Center",  ColMerge:0,   SaveName:"h_sp_bd_name",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_sun",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_mon",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_tue",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_web",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_thu",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_fri",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_sat",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"h_chk_lane_dir_tztm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetColProperty("s_fqc", {ComboText:"1|2|3|4|5|6|7|8|9|10|11|12|13|14", ComboCode:"1|2|3|4|5|6|7|8|9|10|11|12|13|14"} );
		              SetColProperty("s_bd", {ComboText:"Both|Inbound|Outbound", ComboCode:"B|I|O"} );
		              SetColProperty("s_dr", {ComboText:dir_cdText, ComboCode:dir_cdCode} );
		              SetColProperty("h_fqc", {ComboText:"1|2|3|4|5|6|7|8|9|10|11|12|13|14", ComboCode:"1|2|3|4|5|6|7|8|9|10|11|12|13|14"} );
		              SetColProperty("h_bd", {ComboText:"Both|Inbound|Outbound", ComboCode:"B|I|O"} );
		              SetColProperty("h_dir", {ComboText:dir_cdText, ComboCode:dir_cdCode} );
                  	  SetColProperty(0 ,"s_t_time" , {AcceptKeys:"N"});
                  	  resizeSheet();
                	}
                break;
	        }
	    }

	    function resizeSheet(){
	        ComResizeSheet(sheetObjects[0]);
	    }
	    
		/**
		 * handling of Sheet process
		 * 
		 */
	  	function doActionIBSheet(sheetObj,formObj,sAction) {
	    	var uid ;
	    	var sXml ;
	    	sheetObj.ShowDebugMsg(false);
	        switch(sAction) {
	           case IBSEARCH:      
	                if(validateForm(sheetObj,formObj,sAction))
	                formObj.f_cmd.value=SEARCH;
	                sheetObj.DoSearch("ESD_PRD_0013GS.do", PrdFQString(formObj) , {Sync:2});
	                break;
	           case IBSAVE:        
	              if(!validateForm(sheetObj,formObj,sAction)){
	            	  return false;
	              }
	                formObj.f_cmd.value=MULTI;
	                sheetObj.DoSave("ESD_PRD_0013GS.do", PrdFQString(formObj));
	                break;
	           case IBINSERT:      
	               if(validateForm(sheetObj,formObj,sAction))
	                var row=sheetObj.DataInsert();
	               sheetObj.SetCellValue(row, "s_lane","FDR",0);
	                break;
	           case IBCOPYROW:        
	                var row=sheetObj.DataCopy();
	                sheetObj.SetCellValue(row, "s_lane","FDR",0);
	              break;
	           case IBDOWNEXCEL:        
	        	   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });	        	   
	              break;
	           case IBLOADEXCEL:      
	        	  sheetObj.LoadExcel();
	              var toalRow = sheetObj.RowCount("I")+1;
	              setVslLane(sheetObj , toalRow);
	              break;
	           case SEARCH08:
	              formObj.f_cmd.value=SEARCH08;
	              uid="ESD_PRD_0013";
	              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
	              retValidate=ComGetEtcData(sXml, "rowCount");
	              comData1=ComGetEtcData(sXml, "comData1");
	              comData2=ComGetEtcData(sXml, "comData2");
	              
	              break;
	           case SEARCH01:
	              formObj.f_cmd.value=SEARCH01;
	              uid="ESD_PRD_0004";
	              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
	              retValidate=ComGetEtcData(sXml, "rowCount");
	              break;
	           case SEARCH09:
	              formObj.f_cmd.value=SEARCH09;
	              uid="ESD_PRD_0013";
	              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
	              retValidate=ComGetEtcData(sXml, "rowCount");
	              validateLane=ComGetEtcData(sXml,"comData1");
	              break;           
	           case SEARCH02:
	              formObj.f_cmd.value=SEARCH02;
	              uid="ESD_PRD_0013";
	              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));
	              retValidate=ComGetEtcData(sXml, "rowCount");
	              break;                  
	        }
	    }
	  	
	  	/**
	  	 * Sheet OnLoadExcel Event
	  	 * @param sheetObj
	  	 * @param result
	  	 * @param code
	  	 * @param msg
	  	 */
	  	function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	  		if(isExceedMaxRow(msg)) return;
	  	}
	  	
	   /**
	     * handling process for input validation
	     */
	    function validateForm(sheetObj,formObj,sAction){
	        switch(sAction) {
	        case IBSAVE:
	        	var Rows = sheetObj.ColValueDupRows("s_from|s_to");
	        	var arr_rows=null;
	        	if (Rows!=null && Rows.trim()!=''){
	        		arr_rows=Rows.split(',');
	        	}
	        	for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
	                sheetObj.SetRowFontColor(arr_rows[i],"#FF0000");
	            }
	        	if (Rows!=null && Rows.trim()!=''){
	        		ComShowMessage("Duplicated Date.");
	                return false;
	            }else{
	                return true;
	            }
	            break;
	        }
	        return true;
	    }
		/**
		 * handling pop up open
		 * 
		 */
		function sheet1_OnPopupClick(sheetObj, row, col){
			var param ;
		    if ( sheetObj.ColSaveName(col) == "s_sp_bd" ) {
		    	param='?vndr_seq='+sheetObj.GetCellValue(row, col);
		           ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param,  700, 550, 'getSPBd', '1,0,1,1,1,1,1,1,1,1,1,1', true,false,row,col);          
		    }
		}
		/**
		 * in case of changing value of cell on sheet
		 * 
		 */
		function sheet1_OnChange(sheetObj, row, col, Value)
		{
		    var strNo="";
		    validateData=Value;
		    // Fill in the Zero
		    if((sheetObj.ColSaveName(col)=="s_sp_bd") && Value.length> 0) {
		    	strNo=sheetObj.GetCellValue(row, "s_sp_bd");
		    	sheetObj.SetCellValue(row, "s_sp_bd",ComLpad(strNo, 6, "0"),0);
		    }
		    // Get Value Service Provider Name
		    if ((sheetObj.ColSaveName(col)=="s_sp_bd") && Value.length > 0) {
		    	doActionIBSheet(sheetObj,document.form,SEARCH08);
	            if(retValidate < 1) {
	              	ComShowMessage(ComGetMsg("PRD90130"));
	              	
	              	sheetObj.SetCellValue(row,"s_sp_bd_name",comData2,0);
	              	sheetObj.SetCellValue(row,"s_sp_bd","",0);
	                  sheetObj.SelectCell(row,"s_sp_bd");
	              } else {
	            	  sheetObj.SetCellValue(row,"s_sp_bd_name",comData2,0);
	              }
		    }
		    // setting 'h_chk_lane_dir_tztm' value when lane, dir, tztm is changed
		    if ((sheetObj.ColSaveName(col)=="s_lane")||(sheetObj.ColSaveName(col)=="s_dr") || (sheetObj.ColSaveName(col)=="s_t_time") ) {
		    	if( sheetObj.GetCellValue(row, "s_lane") != sheetObj.GetCellValue(row, "h_lane") ||
		    			sheetObj.GetCellValue(row, "s_dr") != sheetObj.GetCellValue(row, "h_dir")   ||
		    			sheetObj.GetCellValue(row, "s_t_time") != sheetObj.GetCellValue(row, "h_t_time") ) {
		    		sheetObj.SetCellValue(row, "h_chk_lane_dir_tztm","U",0);
		        } else {
		        	sheetObj.SetCellValue(row, "h_chk_lane_dir_tztm","",0);
		        }
		    }
		    //LANE VALIDATION CHECK 
		 if ((sheetObj.ColSaveName(col) == "s_lane") && (sheetObj.GetCellProperty(row, col, dpEditLen) == 3)) {
		       validateLane="";
		       doActionIBSheet(sheetObj,document.form,SEARCH09);
		       if(validateLane != 'O' || retValidate ==0){
		    	   sheetObj.SetCellValue(row, "s_lane","",0);
		           sheetObj.SelectCell(row, "s_lane");
		       }
		    }
		       if(sheetObj.ColSaveName(col) == "s_from" ||sheetObj.ColSaveName(col) == "s_to" ){
		            validateData=Value;
		            doActionIBSheet(sheetObj,document.form, SEARCH02);
		            if(retValidate < 1) { //if row count is lesser than 1 
		                if(sheetObj.ColSaveName(col) == "s_from") {
		                	sheetObj.SetCellValue(row,"s_from","",0);
		                   sheetObj.SelectCell(row,"s_from");
		                }else if(sheetObj.ColSaveName(col) == "s_to") {
		                	sheetObj.SetCellValue(row,"s_to","",0);
		                   sheetObj.SelectCell(row,"s_to");
		                }
		            }
		        }
		}
		/**
		 * filling left side with 'ch' character
		 * 
		 */
		function lpad(newValue, len, ch){
		 var strlen=trim(newValue).length;
		 var ret="";
		 var alen=len - strlen;
		 var astr=""; 
		 for (i=0; i<alen; ++i)
		 {
		  astr=astr + ch;
		 }
		 ret=astr + trim(newValue); 
		 return ret;
		}
		/**
		 * Get Selected Data in 'Service Provider' PopUp WINDOW  
		 * 
		 */
		function getSPBd(rowArray, row, col) {
		    var sheetObj=sheetObjects[0];
			var colArray=rowArray[0];
			if (sheetObj.ColSaveName(col) == "s_sp_bd")
			{
				sheetObj.SetCellValue(row, "s_sp_bd",colArray[2],0);
				sheetObj.SetCellValue(row, "s_sp_bd_name",colArray[4],0);
			}
		}
		var portInd='';
	    /**
	    * calling COM_ENS_051
	    * 
	    */
		function selectPort(pt){
			var param='?loc_port_ind=1';
			portInd=pt;
			ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 1050, 500, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
		}
	    /**
	    * handling parameters from COM_ENS_051
	    * 
	    */
		function getCOM_ENS_051(rArray) {
			var cArray=rArray [0];
			var frm=document.form;
			if(portInd == 'POL'){
				 frm.port_fm.value=cArray[3];
			}
			if(portInd == 'POD'){
				 frm.port_to.value=cArray[3];
			}
		}
	    /**
	     * changing vslLane which is loaded data by excel file to FDR
	     * 
	     */
	 	function setVslLane(sheetObj ,total) {
	    	 var count=0;
	 		  for(var k=1 ; k <= total ; k++){
	 			  if (sheetObj.GetRowStatus(k)== "I"){
	 				  if (sheetObj.GetCellValue(k, "s_lane") != "FDR"){
	        			  count++;
	        		  }
	 				  sheetObj.SetCellValue(k, "s_lane","FDR",0);
	        	  }
	          }
	 		  if (count >0){
	 			 ComShowMessage(ComGetMsg('PRD90116')); 
	 			 return;
	 		  }
	 	}