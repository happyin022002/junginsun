 /*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9251.js
*@FileTitle : TES 3rd Party Billing Input Popup-Marine Terminal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
// global variable

var sheetObjects = new Array();
var sheetCnt = 0;
var doneDefN3ptyBilCSCD = false;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        /*******************************************************/
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = ComGetEvent("name");//window.event.srcElement.getAttribute("name");

            switch(srcName) {
         	    case "btn_close":
    	            //window.close();
         	    	ComClosePopup();
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * @param(sheet_obj) sheet object
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
    	var sheetObject = sheetObjects[0];
        var formObj = document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

   /**
     * setting sheet initial values and header
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    /*// setting height
                    style.height = 240;

                    // setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Kind of Merge [Option, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //Edit [Option, Default false]
                    Editable = false;

                    //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Seq|Container No.|Billing Case|Amount|3rd Party|3rd Party|Remark";

                    //Header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //Data attribute  [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtSeq		 ,     30,    daCenter,  false,   ""   );
                    InitDataProperty(0, cnt++, dtData		 ,    100,    daCenter,  false,   "cntr_no"			 ,       false,           "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++, dtData		 ,    120,    daCenter,  false,   "n3pty_bil_tp_nm"	 ,       false,           "",       dfNone,    0,     true ,       true);

                    if(tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)){
                        InitDataProperty(0, cnt++, dtData    ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfInteger,  0,     true ,       true);
                    }else{
                        InitDataProperty(0, cnt++, dtData	 ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfFloat,    2,     true ,       true);
                    }
                    InitDataProperty(0, cnt++, dtCombo		 ,     80,    daCenter,  false,   "vndr_cust_div_cd" ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtPopup		 ,    100,    daCenter,  false,   "pop_value"		 ,       false,          "",       dfNone,    0,     true ,       true);


                    InitDataProperty(0, cnt++, dtData		 ,    180,    daCenter,  false,   "if_rmk"			 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "vndr_cnt_cd"      ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "n3pty_vndr_seq"   ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "cust_cnt_cd"      ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "cust_seq"      	 ,       false,          "",       dfNone,    0,     false,       false);

                    InitComboNoMatchText(true);

					InitDataCombo (0, "vndr_cust_div_cd", combo01Text, combo01Code);*/
					
					
					
					var HeadTitle="Seq|Container No.|Billing Case|Curr.|Amount|3rd Party|3rd Party|Remark";

         	       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

         	       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
         	       var headers = [ { Text:HeadTitle, Align:"Center"} ];
         	       InitHeaders(headers, info);

         	       var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
         	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         	              {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"n3pty_bil_tp_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
         	             if (tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)) {
         	       cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
         	       }else{
         	       cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
         	       }
         	       cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_cust_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
         	       cols.push({Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pop_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
         	       cols.push({Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"if_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
         	       cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
         	       cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_vndr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
         	       cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
         	       cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
         	  
         	       InitColumns(cols);
         	       SetColProperty("vndr_cust_div_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
         	       SetEditable(0);
         	       InitComboNoMatchText(true);
         	       resizeSheet();//SetSheetHeight(240);

               }
                break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[0]); }


  // handling sheet process
    
    /**
     * @param sheetObj    sheet object
     * @param formObj     form  object
     * @param sAction     action value
     */ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction){
            case IBSEARCH:
                formObj.f_cmd.value = SEARCH01;
                var searchXml = sheetObj.GetSearchData("ESD_TES_9251GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchData(searchXml,{Append:1 , Sync:1} );
                //sheetObj.LoadSearchXml(searchXml,true);
                break;
        }
    }

  	/**
  	 * sheet object search end event
  	 * @param sheetObj   sheet object
  	 * @return
  	 */
    function sheet_OnSearchEnd(sheetObj){
    	var sheetObj = sheetObjects[0];

        for(var i=1; i<1+sheetObj.RowCount(); i++){
            if(sheetObj.GetCellValue(i,'vndr_cust_div_cd') == ''){
                sheetObj.SetCellValue(i,'vndr_cust_div_cd','C');
    	    }else if(sheetObj.GetCellValue(i,'vndr_cust_div_cd') == 'C'){
    	        sheetObj.SetCellValue(i,"pop_value",sheetObj.GEtCellValue(i,"cust_cnt_cd") + sheetObj.GetCellValue(i,"cust_seq"));
    	    }else if(sheetObj.GetCellValue(i,'vndr_cust_div_cd') == 'S'){
    	        sheetObj.SetCellValue(i,"pop_value",sheetObj.CellValue(i,"n3pty_ofc_cd"));
    	    }else if(sheetObj.GetCellValue(i,'vndr_cust_div_cd') == 'V'){
    	        sheetObj.SetCellValue(i,"pop_value",sheetObj.GetCellValue(i,"vndr_cnt_cd") + sheetObj.GetCellValue(i,"n3pty_vndr_seq"));
    	    }
        }
    }