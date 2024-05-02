/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0011.js
*@FileTitle : CSR Creation for Rev.VVD Change
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
     * @class ESD_LEA_0011 : business script for ESD_LEA_0011
     */
    function ESD_LEA_0011() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

    /* The common global variables */
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  var ipageNo =1 ;


  	/**
  	 * Initializing IBTab object
  	 * Calling this function before calling loadPage() function in setupPage()
  	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
  				InsertTab(0, "Dry Index" , 23 );
  				InsertTab(1, "Tanker Index" , 23); 
  				InsertTab(2, "Time Charter" , 23 );
  				InsertTab(3, "Bunker Price" , 23 );
  				InsertTab(4, "Ship Price" , 23); 
  				InsertTab(5, "FFA Index" , 23 );
  				TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e);
  		}
  	}
  	
  	/**
  	 * Calling this function when occurring onchange event in tab1
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	
  	/**
  	 * Showing the content of the clicked tab when clicking IBTab object.
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.BackColor="#FFFFFF";
  		tabObj.TabBackColor(nItem)="146,174,230";
  	
  		var objs = document.all.item("tabLayer");
  		objs[beforetab].style.display = "none";
  		objs[nItem].style.display = "Inline";
  	
  		//--------------- Most important in this function --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//Not to be able to click the button if zIndex is under -2.
  		objs[beforetab].style.zIndex = 0;
  		objs[nItem].style.zIndex = 9;
  		//------------------------------------------------------//
  		beforetab= nItem;
  	}

  	/**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
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
  		 var sheetObj = sheetObjects[0];
           var formObj = document.form;

          for(i=0;i<sheetObjects.length;i++){
          
              ComConfigSheet(sheetObjects[i]);

              initSheet(sheetObjects[i],i+1);
              ComEndConfigSheet(sheetObjects[i]);            
          }
  	}

   /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		var cnt = 0;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					style.height = GetSheetHeight(13) ;
  					//setting width
  					SheetWidth = mainTable.clientWidth;
  		
  					//Setting the Host information[Required][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//Kind of merge [Optional, Default msNone]
  					MergeSheet = msHeaderOnly;
  		
  					//Edit kind [Optional, Default false]
  					Editable = true;
  		
  					//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 9, 50);
  					
  					//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(23, 3, 0, true);
  		
  					// Setting function handling header
                      InitHeadMode(true, true, false, true, false,false);

                      var HeadTitle  = "Seq|SEL|SEL|CSR No.|Source|BKG #|Rev.VVD(old)|Rev.VVD(old)|Rev.Month|Rev.Month|New\nCSR Creation|I/F Status|I/F Status|New CSR No.|||||||||" ;
                      var HeadTitle1 = "Seq|SEL|SEL|CSR No.|Source|BKG #|Old|New|Old|New|New\nCSR Creation|ERP|LEA|New CSR No.|||||||||" ;
                      
                      //Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle, true);
                      InitHeadRow(1, HeadTitle1, true);
                      
  					//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0,	cnt++,		   dtDataSeq,	30,	daRight,    true);
  					InitDataProperty(0,	cnt++,		  dtCheckBox,	30,	daCenter,	true,     "",        			false,       "",     dfNone,     	 0,    true,      true);
  					InitDataProperty(0,	cnt++,	  dtHiddenStatus,	40,	daCenter,	false,	  "ibflg",   			false,       "",     dfNone,         0,    true,      true);
  					InitDataProperty(0,	cnt++,			  dtData,  130,	daCenter,	true,	  "csr_no",	   			false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,			  dtData,	60,	daCenter,	true,	  "inv_sys_id",	   		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,   		  dtData, 100,daCenter,	true,	  "bkg_no",	  			false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,   		  dtData,	80,	daCenter,	true,	  "old_vvd_cd",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,			  dtData,	80,	daCenter,	true,	  "new_vvd_cd",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,			  dtData,	60,	daCenter,	true,	  "old_rev_yrmon",		false,		 "",	 dfDateYmd,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,   		  dtData,	60,	daCenter,	true,	  "new_rev_yrmon",		false,		 "",	 dfDateYmd,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,   		  dtData,	90,	daCenter,	true,	  "modi_csr_cre_flg",	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);					
  					InitDataProperty(0,	cnt++,   		  dtData,	30,	daCenter,	true,	  "erp_if_flg",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);					
  					InitDataProperty(0,	cnt++,   		  dtData,	30,	daCenter,	true,	  "lea_if_flg",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);					
  					InitDataProperty(0,	cnt++,   		  dtData,  130,	daCenter,	true,	  "modi_csr_no",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);					
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "exe_yrmon",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);						
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "old_vsl_cd",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "old_skd_voy_no",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "old_skd_dir_cd",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "old_rev_dir_cd",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "new_vsl_cd",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "new_skd_voy_no",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "new_skd_dir_cd",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "new_rev_dir_cd",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					
  					style.height = 260 ;
  					
  					CountFormat = "[BOTTOMDATA / TOTALROWS]"
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
                      InitRowInfo( 1, 1, 9, 100);

                      //Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(3, 0, 0, true);

                      //Setting function handling header
                      InitHeadMode(true, true, true, true, false,false)

                      var HeadTitle  = "Exe.Month|CSR No.|BKG No.|";

                      //Setting the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle, true);

                      //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                      InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "exe_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "csr_no"         ,        false,          "",       dfNone,     	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "bkg_no"           ,        false,          "",       dfNone ,     	0,     false,       false);
                     
                      
                      style.height = GetSheetHeight(13) ;
                 }
                  break;
               
  		}
  	}

  	/* Event handler processing by button click event */
  	document.onclick = processButtonClick;
  	
  	/* Event handler processing by button name */
  	function processButtonClick(){
  		 var sheetObject = sheetObjects[0];
  		 var sheetObject1 = sheetObjects[1];

  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "btn_retrieve":
  					sheetObject.RemoveAll();
  					doActionIBSheet(sheetObject,formObject,IBSEARCH,false,1);
  						break;
  				case "btng_newcsrcreation":
  					doActionIBSheet(sheetObject,formObject,IBBATCH);
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
	 * Handling the process about the sheet
	 */ 
  	function doActionIBSheet(sheetObj,formObj,sAction,isAppend,PageNo) {
  	var formObject = document.form;
  	
  	var sheetObj = sheetObjects[0];
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  		   case IBSEARCH:	  //Retrieving
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				if(PageNo != null){
                      formObject.iPage.value= PageNo;
                  }
  				formObject.f_cmd.value = SEARCH;
				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0011GS.do", FormQueryString(formObject));

				if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
  				break;
  			case IBSAVE:		//Saving
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("com.clt.apps.prototype.prototype1Search.do", FormQueryString(formObj));
  				break;
  			case IBINSERT:	  //Inserting
  				var Row = sheetObj.DataInsert();
  				break;
  			case IBCLEAR:	   //Clearing
  				sheetObj.RemoveAll();
  				break;
  			case IBBATCH: 
  				var sRow = sheetObj.FindCheckedRow(1);
  				var arrRow = sRow.split("|");
  				
    				for (idx=0; idx<arrRow.length-1; idx++){ 
    					formObj.f_cmd.value = MULTI01;
    					formObj.Row.value = arrRow[idx];
    					var sXml = sheetObj.GetSearchXml("ESD_LEA_0011GS.do", sheetObj.RowSaveStr(arrRow[idx])+"&Row="+arrRow[idx]+"&"+FormQueryString(formObj));
    					sheetObj.LoadSearchXml(sXml,true, arrRow[idx], true);
    				}
    			break;
  		}
  	}
  	
  	/**
     * handling process for input validation
     */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){

  		}
  		
  		return true;
  	}
  	
  	/**
  	 * calling this function when the scroll bar is the bottom of the sheet list.
  	 */
  	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows){
          var formObj = document.form ;
          formObj.f_cmd.value = SEARCH;
          doActionIBSheet(sheetObjects[0], FormQueryString(formObj), IBSEARCH, true, PageNo);
      }
      
   
  	/**
      * Handling the retrieving process when pressing the enter key.
      */
  	function lea_enterRetrieve(){
      	var sheetObject = sheetObjects[0];
          var formObject = document.form;
  		sheetObject.RemoveAll();
   		doActionIBSheet(sheetObject,formObject,IBSEARCH,false,1);
  	}
  	
  	/**
      * Handling retrieving Page Loading Event process
      */
  	function lea_load_page(){
  		var sheetObject = sheetObjects[curTab-1];
  		var formObject = document.form;
  		doActionIBSheet(sheetObject,formObject,IBSEARCH,false,1);
  	}
  		
  	/**
     * Copying the form data to sheet
     */
  	function lea_form2sheet(formObj,sheetObj){
  		sheetObj.RemoveAll();
  		var Row = sheetObj.DataInsert();
  		
  		sheetObj.CellValue2(Row , "exe_yrmon" ) = formObj.frm_exe_yrmon.value;
  		sheetObj.CellValue2(Row , "csr_no" ) = formObj.frm_csr_no.value;
  		sheetObj.CellValue2(Row , "bkg_no"   ) = formObj.frm_bkg_no.value;

  		}
  		
  	/**
      * Handling not to checking CSR if it is new.
      */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  	var sheetObj = sheetObjects[0];
  		if(errMsg!=null){
  			ComShowMessage(errMsg);
  		}
  		var formObject = document.form;
  		var row = formObject.Row.value;
  		
  		sheetObj.CheckAll(1) = 0;
  		var e = window.event;
  		
  		if(e != null){
  			var src_em = window.event.srcElement;
  			if(src_em != null){
  				var srcName = window.event.srcElement.getAttribute("name");
  			}
  			
  		}
  			for(i=0; i<=sheetObj.RowCount; i++){
  				var modi_csr_cre_flg = sheetObj.CellValue(i,'modi_csr_cre_flg');
  				var erp_if_flg = sheetObj.CellValue(i,'erp_if_flg');
  				var lea_if_flg = sheetObj.CellValue(i,'lea_if_flg');
  				if(modi_csr_cre_flg == "Y" && erp_if_flg == "Y" && lea_if_flg =="Y"){					
  					sheetObj.RowEditable(i)=false;
  					if(e != null && srcName == "btng_newcsrcreation" && i==row){
  						sheetObj.RowBackColor(i)=sheetObj.RgbColor(189,228,245);
  					}
  				}
  			}
  	}
  	
  		
  	/**
      * Opening the retrieving CSR page when double-clicking New CSR No or CSR No column.(TRS, TES only)
      */		
  	function sheet1_OnDblClick(sheet1, row, col){
  		if(col==3 || col==13){ //CSR No, New CSR No Column
  			var csr_no = sheet1.cellValue(row, col);
  			var inv_sys_id = sheet1.cellValue(row, 4); //TRS, TES
  		
  			if (inv_sys_id == "TRS") {
  				window.showModalDialog("ESD_TRS_0960.do?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:800px; help:no; status:no; resizable:yes;");
  			} else if (inv_sys_id == "TES"){
     			window.showModalDialog("ESD_TES_0101.screen?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:800px; help:no; status:no; resizable:yes;");
  			}
  		}
  	}

