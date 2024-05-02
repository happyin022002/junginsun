/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0007.js
*@FileTitle : Expense Report by Exe.Month
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_LEA_0007 : business script for ESD_LEA_0007 
     */
    function ESD_LEA_0007() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

 // The common global variables

    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    /* Event handler processing by button name */
        function processButtonClick(){
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];

             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
            	        sheetObject.RemoveAll();
            	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	            break;

            	    case "btng_downexcel":
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
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
         * Registering IBSheet Object as list
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source
         */
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;


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
             var sheetObject = sheetObjects[0];
             var formObject = document.form;
             sheetObject.RemoveAll();
//             doActionIBSheet(sheetObject,formObject,IBSEARCH);

        }

       /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets 
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;

            switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        //Setting width
                        SheetWidth = mainTable.clientWidth;
                        
                     // Setting height
    					style.height = 400;

                        //Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //Kind of merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //Edit kind [Optional, Default false]
                        Editable = true;

                        //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(14, 2, 0, true);

                       // Setting function handling header
                        InitHeadMode(false, false, true, true, false,false)

                        var HeadTitle  = "STS|Rev.\nMonth|Exe.\nMonth|Cost Type|sub_cost_tp_cd|Cost Type Ⅱ|Estimated\nCost|Actual Cost|Actual Cost|Accrual\nCost|Confirmed\nCost|Cost Diff||" ;
                        var HeadTitle1 = "STS|Rev.\nMonth|Exe.\nMonth|Cost Type|sub_cost_tp_cd|Cost Type Ⅱ|Estimated\nCost|Cost|Ratio(%)|Accrual\nCost|Confirmed\nCost|Cost Diff||" ;

                        //The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++,  dtHiddenStatus ,    	 30,    daCenter,  true,    "ibflag");
						InitDataProperty(0, cnt++ , dtHidden ,       70,    daCenter,  true ,    "rev_yrmon"          ,        false,          "",       dfDateYm ,   	0,     false,        false); 
						InitDataProperty(0, cnt++ , dtData   ,       80,    daCenter,  true ,    "exe_yrmon"          ,        false,          "",       dfDateYm ,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtImageText,     90,    daCenter,  true ,    "mn_cost_tp_cd"      ,        false,          "",       dfNone   ,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  true ,    "sub_cost_tp_cd"     ,        false,          "",       dfNone   ,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtData   ,      250,    daCenter,  true ,    "sub_cost_tp_nm"     ,        false,          "",       dfNone   ,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  true ,    "estm_cost_amt"      ,        false,          "",       dfFloat,   2,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  false,    "pst_act_cost_amt"   ,        false,          "",       dfFloat,   2,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtData   ,       90,    daRight ,  false,    "act_cost_ratio"     ,        false,          "",       dfNullFloatOrg,   1,     false,        false);       
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  true ,    "accl_cost_amt"      ,        false,          "",       dfFloat,   2,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  true ,    "confirmed_cost_amt" ,        false,          "",       dfFloat,   2,     false,        false);           
						InitDataProperty(0, cnt++ , dtAutoSum,       90,    daRight ,  true ,    "diff_cost_amt"      ,        false,          "",       dfFloat,   2,     false,        false); 
						InitDataProperty(0, cnt++ , dtHidden ,       60,    daCenter,  false,    "mnl_inp_flg"        ,        false,          "",       dfNone   ,   	0,     false,        false);                                              
						InitDataProperty(0, cnt++ , dtHidden ,      150,    daCenter,  false,    "erp_if_flg"         ,        false,          "",       dfNone   ,   	0,     false,        false);                                              

					ImageList(0) = "/opuscntr/img/button/btng_minus.gif";
					ImageList(1) = "/opuscntr/img/button/btng_plus.gif";
					CellImage(0, "mn_cost_tp_cd") = 0;
                        RangeBackColor(1, 6, 1, 8) = RgbColor(222, 251, 248);   // ENIS
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                       // style.height = GetSheetHeight(13) ;
                   }
                    break;
                case 2:      //IBSheet1 init
                    with (sheetObj) {
                        //Setting width
                        SheetWidth = mainTable.clientWidth;

                        //Setting the Host information[Required][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //Kind of merge [Optional, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //Edit kind [Optional, Default false]
                        Editable = true;

                        //Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(3, 0, 0, true);

                        // Setting function handling header
                        InitHeadMode(true, true, true, true, false,false)

                        var HeadTitle   = "Rev.\nYear-Month|Exe.Year-Month|Exe.Year-Month";
                        var HeadTitle1  = "Rev.\nYear-Month|From|To";

                        //The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, true);
                        InitHeadRow(1, HeadTitle1, true);

                        //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    										InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "rev_yrmon"				,        false,          "",       dfDateYm 	,   	0,     true ,        true  ); 																															
    										InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "exe_yrmon_from"  ,        false,          "",       dfDateYm  	,   	0,     true ,        true  );                                                              
    										InitDataProperty(0, cnt++ , dtData  ,       65,    daCenter,  true ,    "exe_yrmon_to"    ,        false,          "",       dfDateYm  	,   	0,     true ,        true  );                                                              
                                                               
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                         style.height = GetSheetHeight(13) ;
                   }
                     break;

            }
        }

      // Handling the process about the sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //Retrieving
                   //if(validateForm(sheetObj,formObj,sAction))
    					    	formObj.f_cmd.value = SEARCH;
    							  //var searchXml = sheetObj.GetSearchXml("ESD_LEA_0007GS.do", FormQueryString(formObj));
    							  
    							  var searchXml = sheetObj.GetSearchXml("ESD_LEA_0007GS.do", leaFormQueryString(formObj));
    							  
    						    //ComShowMessage(searchXml);
    						    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
                    break;
                    
    					case IBDOWNEXCEL:        // excel down
    		
    						sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "",true);
    						break;

            }
        }

       /**
         * handling process after ending sheet1 retrieve
         */
    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
//    		 sheetObj.SubSumBackColor = sheetObj.RgbColor(255,153,255);
    	   sheetObj.ShowSubSum( "exe_yrmon"   , "6|7|8|9|10|11", -1, false, false , 1 ,"1=%s;2=Monthly Total");
    	   sheetObj.SumText(0,0) = "";
    	   sheetObj.SumText(0,1) = "Grand Total" ;
    	//   sheetObj.SumBackColor  	= sheetObj.RgbColor(153,153,255);
    		 sheetObj.SumFontBold 		= true;

          var subSumRows = sheetObj.FindSubSumRow("exe_yrmon");
          var arrRow = subSumRows.split("|");
      		for (var i=0; i<arrRow.length-1; i++){ 
      			if(sheetObj.CellValue(arrRow[i],"estm_cost_amt") == 0){
      				sheetObj.CellValue(arrRow[i],"act_cost_ratio") = 0;
      			}else{
      				sheetObj.CellValue(arrRow[i],"act_cost_ratio") = sheetObj.CellValue(arrRow[i],"pst_act_cost_amt")/ sheetObj.CellValue(arrRow[i],"estm_cost_amt")*100;
      			 }
      		}

      		if(sheetObj.SumValue(0,"estm_cost_amt") == 0)
    				sheetObj.SumValue(0,"act_cost_ratio") = 0;
    			else
    				sheetObj.SumValue(0,"act_cost_ratio") = sheetObj.SumValue(0,"pst_act_cost_amt")/ sheetObj.SumValue(0,"estm_cost_amt")*100;

    	}
       /**
         * Calling this method when occurring MouseDown event in sheet1.
         */
    	function sheet1_OnMouseDown(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
    	{ 
    	   if((sheetObj.MouseRow  == 1 || sheetObj.MouseRow  == 0) && sheetObj.MouseCol == 3){
    				if(sheetObj.CellImage(0, "mn_cost_tp_cd") == 0){
        			sheetObj.CellImage(0, "mn_cost_tp_cd") = 1;
        			document.form.frm_retrieveDiv.value = 1;
        			doActionIBSheet(sheetObj,document.form,IBSEARCH);
        		}else{
        			sheetObj.CellImage(0, "mn_cost_tp_cd") = 0;
        			document.form.frm_retrieveDiv.value = 0;
        			doActionIBSheet(sheetObj,document.form,IBSEARCH);
        		}
    	  
    	   }
    	}

       /**
         * Handling the process for the input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(iPage)) {
    //
//                    return false;
//                }
            }

            return true;
        }

       /**
         * Handling the retrieving process when pressed Enter key Event
         */
    		function lea_enterRetrieve(){
          var sheetObject = sheetObjects[0];
          var formObject = document.form;
    			/*
    				if(sheetObject.CellImage(0, "mn_cost_tp_cd") == 0){
        			sheetObject.CellImage(0, "mn_cost_tp_cd") = 1;
        			formObject.frm_retrieveDiv.value = 1;
        			doActionIBSheet(sheetObject,formObject,IBSEARCH);
        		}else{
        		*/
        			sheetObject.CellImage(0, "mn_cost_tp_cd") = 0;
        			formObject.frm_retrieveDiv.value = 0;
        			doActionIBSheet(sheetObject,formObject,IBSEARCH);
        		//}
    			  
    		}
       /**
         * Copying the form data to sheet one
         */
    		function lea_form2sheet(formObj,sheetObj){
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row , "rev_yrmon" 			) = formObj.frm_rev_yrmon		 .value;
    			sheetObj.CellValue(Row , "exe_yrmon_from" ) = formObj.frm_exe_yrmon_from.value;
    			sheetObj.CellValue(Row , "exe_yrmon_to"   ) = formObj.frm_exe_yrmon_to  .value;
    		}

    	/*
    	 * Setting Cost Type check to Cookie
    	*/
    	function lea_setCookieAcclType(){
//    			setCookie("form_lea_cost_type_m",(document.form.f_cost_type_m.checked == true ?"1":"0"));
//    			setCookie("form_lea_cost_type_f",(document.form.f_cost_type_f.checked == true ?"1":"0"));
         document.form.f_cost_type_m.value = (document.form.f_cost_type_m.checked == true ?"1":"0");
         document.form.f_cost_type_f.value = (document.form.f_cost_type_f.checked == true ?"1":"0");

    	}
    	
    	/*
    	 * Setting the value of frm_rev_yrmon_to
    	*/
    	function lea_setRevToYymm(obj1,obj2){
    		if (event.keyCode == 13){
    			lea_com_setRevToYymm(obj1,obj2)
    		}
    	}

