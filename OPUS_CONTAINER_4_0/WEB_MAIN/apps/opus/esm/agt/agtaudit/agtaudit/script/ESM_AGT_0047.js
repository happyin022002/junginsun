/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_AGT_0047.js
*@FileTitle : VVD Exchange Rate Inquiry
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

/* Common Global Variables */
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
var mainPage;


    /**
     * tab1 onChange Event Handler
     * IBSheetConfig.js Handler Method
     */
    function tab1_OnChange(nItem){
        ChangeTab(document.all.tab1,nItem);
    }
    
    /**
     * Changing Tab Event
     */
    function ChangeTab(tabObj,nItem){
        tabObj.BackColor="#FFFFFF";
        tabObj.TabBackColor(nItem)="146,174,230";
    
        var objs = document.all.item("tabLayer");
        objs[beforetab].style.display = "none";
        objs[nItem].style.display = "Inline";
    
        objs[beforetab].style.zIndex = 0;
        objs[nItem].style.zIndex = 9;
        beforetab= nItem;
    }

    /**
     * registering IBSheet Object as list
     * calling from comSheetObject(id)
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
    	 sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * initializing sheet 
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
     */
     function loadPage(mainpage) {
    	mainPage = mainpage;
        for(i=0;i<sheetObjects.length;i++){

        //khlee-Changing Start Environment Setting Method's Name
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-Adding Last Environment Setting method
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
      	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }

    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
 
        //sheetObj.UseUtf8 = true;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // setting height
                    style.height = GetSheetHeight(10) ;
                    //Whole setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Whole Merge kind [Optional, Default msNone]
                    MergeSheet = msNone;

                    //Edit kind [Optional, Default false]
                    Editable = true;
        
                    //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);
                    
                    // setting function handling header
                    InitHeadMode(true, true, true, true, false,false)
                    
                    var HeadTitle = "Seq.|VVD|Port|Bound|Scope|Office|Charge Cur|Local Cur|Ex.Rate|Inverse Rate" ;
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
           
                    //setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);
        
                    //Data  properties    [ROW,      COL,            DATATYPE, WIDTH,   DATAALIGN, COLMERGE,     SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "seq",              false,          "",       dfNone,   	0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      120,    daCenter,  false,    "vvd_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  false,    "port_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "io_bnd_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "svc_scp_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "ar_ofc_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "chg_curr_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  false,    "locl_curr_cd",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "inv_xch_rt",        false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,    "ivs_xch_rt",    false,          "",       dfNone,     0,     false,       true);
                    
                    CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
                }
                break;
        }
    }

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;
    
    /* Event handler processing by button name */    
    function processButtonClick(){
         /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;
            
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_New":
        	    	formObject.reset();
    	            sheetObject.RemoveAll();
    	            
        	        break;
        	    
        	    case "btns_calendar1":
        	        /*var cal = new calendarPopup();
            		cal.select(formObject.frYearMon, 'frYearMon', 'yyyy-MM-dd');
        	        break;*/

        	    case "btns_calendar2":
        	        /*var cal = new calendarPopup();
            		cal.select(formObject.toYearMon, 'toYearMon', 'yyyy-MM-dd');
        	        break;*/

                case "btn_Close":
    	            self.close();
        	        break;

        	    case "btn_OK":
                    comPopupOK();
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
    
    /* handling process for Sheet */
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

          case IBSEARCH:        //Retrieve
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value = SEARCH;                
                selectVal = agtQryStr(formObj)
                sheetObj.DoSearch4Post("COM_ENS_0F1GS.do", selectVal);               
               
           break;
           case IBSEARCHAPPEND:  //  Retrieve
                formObj.f_cmd.value = SEARCHLIST;  
                sheetObj.DoSearch4Post("COM_ENS_0F1GS.do", selectVal, "iPage=" + PageNo, true);
           break;

        }
    }
    
    function sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
       doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    }  
    
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){  
            if(formObj.vvd_cd.value != "" && formObj.vvd_cd.value.length != 9) {
            	ComShowMessage("VVD must be 9 characters");
                ComSetFocus(formObj.vvd_cd);
              return false;
            }
            
            if(formObj.port_cd.value != "" && formObj.port_cd.value.length != 5) {
              ComShowMessage("PORT must be 5 characters");
              ComSetFocus(formObj.port_cd);
              return false;
            }
            
            if(formObj.svc_scp_cd.value != "" && formObj.svc_scp_cd.value.length != 3) {
              ComShowMessage("SCOPE must be 3 characters");
              ComSetFocus(formObj.svc_scp_cd);
              return false;
            }
        }
        return true;
    }
    
    /**
     * Common Method when Error occurs in Retrieve Result
     */
    function sheet_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null){
        	ComShowMessage(errMsg);
        }
    }