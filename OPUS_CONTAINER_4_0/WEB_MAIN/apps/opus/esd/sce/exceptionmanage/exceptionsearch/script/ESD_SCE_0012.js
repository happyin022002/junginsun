/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0012.js
*@FileTitle : Exception Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE :  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


   /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined..
     * @author 
     */

    /**
     * @extends 
     * @class ESD_SCE_0012 :  business script for ESD_SCE_0012
     */
    function ESD_SCE_0012() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

    var sheetObjects = new Array();
    var sheetCnt = 0;
     

    document.onclick = processButtonClick;

    function processButtonClick(){
    	 var sheetObj = sheetObjects[0];
    	 var formObj  = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObj,formObj,IBSEARCH);
    				break;
    			case "btn_new":
    				sheetObjects[0].RemoveAll();
    				sheetObjects[1].RemoveAll();
    				sheetObjects[2].RemoveAll();
    				sheetObjects[3].RemoveAll();

//    				sheetObjects[0].reset();
//    				sheetObjects[1].reset();
//    				sheetObjects[2].reset();
//    				sheetObjects[0].reset();

    				formObj.cop_expt_no.value = "" ;

    				break;
//    			case "btn_confirm":
//    				doActionIBSheet(sheetObjects[3],formObj,IBSAVE);
//    				break;
//    			case "btn_downexcel":
//    				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
//    				break;
    			case "btn_copdetail":
    				//doActionIBSheet(sheetObj1,sheetObj2,formObj,IBINSERT);
    				if( sheetObjects[0].Rows > 2 ) goCopDetail( formObj);         //ESD_SCE_012.jsp function
    				break;
    			case "btn_send" :
    				//openESD_SCE_102(sheetObjects, formObj);
    				openESD_SCE_102_NEW(sheetObjects, formObj);
    				break;

    			case "btn_copdetail" :
    				openESD_SCE_101(sheetObj);
    				break;


    		}
    	}catch(e) {
    		if( e == "[object Error]") {
    	    alert("processButtonClick error");
    			ComShowCodeMessage('COM12111') ;
    		} else {
    	    alert("processButtonClick error2");
    			ComShowMessage(e);
    		}
    	}
    }

        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
        	var formObj = document.form ;
        	var sheetObj = sheetObjects[0];
        	
        	 
        	 
            for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            if(formObj.cop_expt_no.value.length>0 ) 	doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    function setCopValues(object){
        if(object.value=="") return ;

        var formObj = document.form ;
        var values     = object.value.split("|")

        formObj.bkg_no.value       = values[0];
        //formObj.bkg_no_split.value = values[1];
        formObj.bkg_no_split.value = "  ";
        //formObj.cop_no.value       = values[2];
        //formObj.cop_sts.value      = values[3];
    }

    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var cnt2 = 0;

    	switch(sheetNo) {
    		case 1:	  //IBSheet1 init; Exception Type[01] = Estimated Time / Delay Time
                with (sheetObj) {
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind[, Default msNone]
                    //MergeSheet = msHeaderOnly;
                    MergeSheet = msAll;

                    //Edit kind[, Default false]
                    Editable = true;

                    //setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 2, 9, 100);

                    //setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "BKG No.|B/L No.|COP No.|Container No.|Trunk VVD|POR|POL|POD|DEL|R/D Term" ;
                    var HeadTitle2 = "Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify" ;

                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtData,		110,    daCenter,  false,    "b_s2",   false,          "",       dfNone,    	0,     false,       false);   //BKG No.
//                    InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  false,    "b_s2",   false,          "",       dfNone,     	0,     false,       false);   //B/L No.
//                    InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  false,    "b_s2",   false,          "",       dfNone,        0,     false,       false);   //COP No.
//                    InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  false,    "b_c2",   false,          "",       dfNone,     	0,     false,       false);   //Container No.
//                    InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  false,    "b_c2",   false,          "",       dfNone,        0,     false,       false);   //Trunk VVD
//                    InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  false,    "b_c2",   false,          "",       dfNone,     	0,     false,       false);   //POR
//                    InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  false,    "b_n2",   false,          "",       dfNone,        0,     false,       false);   //POL
//                    InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  false,    "b_n2",   false,          "",       dfNone,     	0,     false,       false);   //POD
//                    InitDataProperty(0, cnt++ , dtData,     110,    daCenter,  false,    "b_n2",   false,          "",       dfNone,        0,     false,       false);   //DEL
//                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "b_n2",   false,          "",       dfNone,     	0,     false,       false);   //R/D Term
    //
//                    InitDataProperty(1, cnt2++ , dtData,	 110,    daCenter,  true,    "b_s2",   false,          "",       dfNone,    	0,     false,       false);   //Shipper
//                    InitDataProperty(1, cnt2++ , dtData,     110,    daCenter,  true,    "b_s2",   false,          "",       dfNone,     	0,     false,       false);   //Shipper
//                    InitDataProperty(1, cnt2++ , dtData,     110,    daCenter,  true,    "b_s2",   false,          "",       dfNone,     	0,     false,       false);   //Shipper
//                    InitDataProperty(1, cnt2++ , dtData,     110,    daCenter,  true,    "b_c2",   false,          "",       dfNone,     	0,     false,       false);   //Consignee
//                    InitDataProperty(1, cnt2++ , dtData,     110,    daCenter,  true,    "b_c2",   false,          "",       dfNone,        0,     false,       false);   //Consignee
//                    InitDataProperty(1, cnt2++ , dtData,     110,    daCenter,  true,    "b_c2",   false,          "",       dfNone,        0,     false,       false);   //Consignee
//                    InitDataProperty(1, cnt2++ , dtData,     110,    daCenter,  true,    "b_n2",   false,          "",       dfNone,        0,     false,       false);   //Notify
//                    InitDataProperty(1, cnt2++ , dtData,     110,    daCenter,  true,    "b_n2",   false,          "",       dfNone,     	0,     false,       false);   //Notify
//                    InitDataProperty(1, cnt2++ , dtData,     110,    daCenter,  true,    "b_n2",   false,          "",       dfNone,     	0,     false,       false);   //Notify
//                    InitDataProperty(1, cnt2++ , dtData,     80,    daCenter,  false,    "b_n2",   false,          "",       dfNone,     	0,     false,       false);   //Notify




                    InitDataProperty(0, cnt++ , dtData,		100,    daCenter,  false,    "b_bkg",  false,          "",       dfNone,    	0,     false,       false);   //BKG No.
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "b_bl",   false,          "",       dfNone,     	0,     false,       false);   //B/L No.
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "b_cop",  false,          "",       dfNone,        0,     false,       false);   //COP No.
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "b_cntr", false,          "",       dfNone,     	0,     false,       false);   //Container No.
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "b_tvvd", false,          "",       dfNone,        0,     false,       false);   //Trunk VVD
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "b_por",  false,          "",       dfNone,     	0,     false,       false);   //POR
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "b_pol",  false,          "",       dfNone,        0,     false,       false);   //POL
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "b_pod",  false,          "",       dfNone,     	0,     false,       false);   //POD
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "b_del",  false,          "",       dfNone,        0,     false,       false);   //DEL
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "b_term", false,          "",       dfNone,     	0,     false,       false);   //R/D Term

                    InitDataProperty(1, cnt2++ , dtData,	 100,    daCenter,  true,    "b_ship", false,          "",       dfNone,    	0,     false,       false);   //Shipper
                    InitDataProperty(1, cnt2++ , dtData,     100,    daCenter,  true,    "b_ship", false,          "",       dfNone,     	0,     false,       false);   //Shipper
                    InitDataProperty(1, cnt2++ , dtData,     100,    daCenter,  true,    "b_ship", false,          "",       dfNone,     	0,     false,       false);   //Shipper
                    InitDataProperty(1, cnt2++ , dtData,     100,    daCenter,  true,    "b_cons", false,          "",       dfNone,     	0,     false,       false);   //Consignee
                    InitDataProperty(1, cnt2++ , dtData,     100,    daCenter,  true,    "b_cons", false,          "",       dfNone,        0,     false,       false);   //Consignee
                    InitDataProperty(1, cnt2++ , dtData,     100,    daCenter,  true,    "b_cons", false,          "",       dfNone,        0,     false,       false);   //Consignee
                    InitDataProperty(1, cnt2++ , dtData,     100,    daCenter,  true,    "b_noti", false,          "",       dfNone,        0,     false,       false);   //Notify
                    InitDataProperty(1, cnt2++ , dtData,     100,    daCenter,  true,    "b_noti", false,          "",       dfNone,     	0,     false,       false);   //Notify
                    InitDataProperty(1, cnt2++ , dtData,     100,    daCenter,  true,    "b_noti", false,          "",       dfNone,     	0,     false,       false);   //Notify
                    InitDataProperty(1, cnt2++ , dtData,     80,    daCenter,   true,    "b_noti", false,          "",       dfNone,     	0,     false,       false);   //Notify

                    style.height = GetSheetHeight(6) ;
                    CountPosition = 0;
    			}
    			break;


    		case 2:	  //IBSheet1 init; Exception Type[01] = Estimated Time / Delay Time
                with (sheetObj) {
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind[, Default msNone]
                    //MergeSheet = msHeaderOnly;
                    MergeSheet = msAll;

                    //Edit kind[, Default false]
                    Editable = true;

                    //setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 2, 9, 100);

                    //setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Exception Type|Exception Type Detail|Exception Type Detail|Exception Status|Exception Reason" ;
                    var HeadTitle2 = "Occurred Date/Time|Occurred Node|Occurred Office|Tolerance\n(Day/Hour/Minute)|Resolved Date/Time" ;

                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtData,       200,    daCenter,  false,    "s_s1",           false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(0, cnt++ , dtData,       200,    daCenter,  true,     "s_s2",       false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(0, cnt++ , dtData,       200,    daCenter,  true,     "s_s2",             false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(0, cnt++ , dtData,       150,    daCenter,  false,    "s_s3",             false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  false,    "s_s4",            false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(0, cnt++ , dtHidden,     100,    daCenter,  false,    "s_s5",          false,  "",       dfNone,     0,     false,       false);
    //
//                    InitDataProperty(1, cnt2++ , dtData,       200,    daCenter,  false,    "s_s1",           false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(1, cnt2++ , dtData,       200,    daCenter,  false,    "s_s2",       false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(1, cnt2++ , dtData,       200,    daCenter,  false,    "s_s2",             false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(1, cnt2++ , dtData,       150,    daCenter,  false,    "s_s3",             false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(1, cnt2++ , dtData,       100,    daCenter,  false,    "s_s4",            false,  "",       dfNone,     0,     false,       false);
//                    InitDataProperty(1, cnt2++ , dtHidden,     100,    daCenter,  false,    "s_s5",          false,  "",       dfNone,     0,     false,       false);

                    InitDataProperty(0, cnt++ , dtData,       200,    daCenter,  false,    "s_expt_nm",   false,  "",       dfNone,     0,     false,       false);  //Exception Type
                    InitDataProperty(0, cnt++ , dtData,       200,    daCenter,  true,     "s_expt_dtl",  false,  "",       dfNone,     0,     false,       false);  //Exception Type Detail
                    InitDataProperty(0, cnt++ , dtData,       150,    daCenter,  true,     "s_expt_dtl",  false,  "",       dfNone,     0,     false,       false);  //Exception Type Detail
                    InitDataProperty(0, cnt++ , dtData,       200,    daCenter,  false,    "s_expt_sts",  false,  "",       dfNone,     0,     false,       false);  //Exception Status
                    InitDataProperty(0, cnt++ , dtData,       100,    daCenter,  false,    "s_expt_rsn",  false,  "",       dfNone,     0,     false,       false);  //Exception Reason
                    InitDataProperty(0, cnt++ , dtHidden,     0,      daCenter,  false,    "s_tp_cd_hd",  false,  "",       dfNone,     0,     false,       false);  //hidden:Exception Type Code

                    InitDataProperty(1, cnt2++ , dtData,       200,    daCenter, false,    "s_occr_dt",   false,  "",       dfNone,     0,     false,       false);  //Occurred Date/Time
                    InitDataProperty(1, cnt2++ , dtData,       200,    daCenter, false,    "s_occr_loc",  false,  "",       dfNone,     0,     false,       false);  //Occurred Location
                    InitDataProperty(1, cnt2++ , dtData,       150,    daCenter, false,    "s_occr_ofc",  false,  "",       dfNone,     0,     false,       false);  //Occurred Office
                    InitDataProperty(1, cnt2++ , dtData,       200,    daCenter, false,    "s_expt_sts",  false,  "",       dfNone,     0,     false,       false);  //Tolerance
                    InitDataProperty(1, cnt2++ , dtData,       100,    daCenter, false,    "s_rslt_dt",   false,  "",       dfNone,     0,     false,       false);  //Resolved Date/Time
                    InitDataProperty(1, cnt2++ , dtHidden,     0,      daCenter, false,    "s_tp_cd_hd",  false,  "",       dfNone,     0,     false,       false);  //hidden:Exception Type Code

                    style.height = GetSheetHeight(6) ;
                    CountPosition = 0;
    			}
    			break;

    		case 3:	  //IBSheet1 init; Exception Type[01] = Estimated Time / Delay Time
    		var tp_cd=1;
    		if(eval(document.form.s_htp_cd.value)!=null){
    			
    		     tp_cd=eval(document.form.s_htp_cd.value);
    		     tp_cd=2;
    		}
    		
      		if(tp_cd==1 || tp_cd==4){
                with (sheetObj) {
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind[, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //Edit kind[, Default false]
                    Editable = true;

                    //setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "From|From|From|From|To|To|To|To" ;
                    var HeadTitle2 = "Activity|Estimated Date/Time|Actual Date/Time|Updated Date/Time|Activity|Estimated Date/Time|Actual Date/Time|Updated Date/Time" ;

                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
           			InitHeadRow(1, HeadTitle2, true);
                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "d_act_cd1",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       130,    daCenter,  false,    "d_estm_dt1",       false,          "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       130,    daCenter,  false,    "d_act_dt1",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       130,    daCenter,  false,    "d_upd_dt1",        false,          "",       dfNone,     	0,     false,       false);
                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  false,    "d_act_cd2",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       130,    daCenter,  false,    "d_estm_dt2",       false,          "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       130,    daCenter,  false,    "d_act_dt2",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       130,    daCenter,  false,    "d_upd_dt2",        false,          "",       dfNone,     	0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,       0,    daCenter,  false,    "d_act_cd1_nm",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,       0,    daCenter,  false,    "d_act_cd2_nm",        false,          "",       dfNone,     	0,     false,       false);

                    style.height = GetSheetHeight(5) ;
                    CountPosition = 0;
    			}
    		   }else if(tp_cd==2 || tp_cd==3){
                with (sheetObj) {
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind[, Default msNone]
                    //MergeSheet = msHeaderOnly;
                    MergeSheet = msAll;

                    //Edit kind[, Default false]
                    Editable = true;

                    //setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "From|From|From|From|Loading\nLocation|Loading\nVVD|To|To|To|To" ;
                    var HeadTitle2 = "Activity|Estimated\nDate/Time|Actual\nDate/Time|Updated\nDate/Time|Loading\nLocation|Loading\nVVD|Activity|Estimated\nDate/Time|Actual\nDate/Time|Updated\nDate/Time" ;

                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
           			InitHeadRow(1, HeadTitle2, true);
                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       70,     daCenter,  false,    "d_act_cd1",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       110,    daCenter,  false,    "d_estm_dt1",       false,          "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       110,    daCenter,  false,    "d_act_dt1",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       110,    daCenter,  false,    "d_upd_dt1",        false,          "",       dfNone,     	0,     false,       false);
                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "d_ld_port",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "d_vvd",            false,          "",       dfNone,     	0,     false,       false);
                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       70,     daCenter,  false,    "d_act_cd2",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       110,    daCenter,  false,    "d_estm_dt2",       false,          "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       110,    daCenter,  false,    "d_act_dt2",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       110,    daCenter,  false,    "d_upd_dt2",        false,          "",       dfNone,     	0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,       0,    daCenter,  false,    "d_act_cd1_nm",        false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,       0,    daCenter,  false,    "d_act_cd2_nm",        false,          "",       dfNone,     	0,     false,       false);

                    style.height = GetSheetHeight(5) ;
                    CountPosition = 0;
    			}
    		   }
    			break;


    		case 4:	  //IBSheet1 init; Exception Type[01] = Estimated Time / Delay Time
                with (sheetObj) {
                    //setting width
                    SheetWidth = 290;
                    //SheetWidth = mainTable.clientWidth;

                    //setting Host information[HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind[, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //Edit kind[, Default false]
                    Editable = true;

                    //setting Row information[HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //setting Column information[COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Confirm|Confirm ID|Confirmed Date" ;

                    //setting function handling header Row[ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,    "c_cfm",      false,          "",       dfNone,       0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  false,    "c_cfm_id",   false,          "",       dfNone,     	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      110,    daCenter,    false,    "c_cfm_dt",   false,          "",       dfNone,     	0,     false,       false);
    			    //InitDataProperty(0, cnt++ , dtHidden,     30,    daCenter,   false,   "c_ibflag",   false,          "",       dfNone,   	0,     false,       false);

                    style.height = GetSheetHeight(4) ;
                    CountPosition = 0;
    			}
    			break;
    	}
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        if(sheetObj!=null){
//        	sheetObj.ShowDebugMsg = 1;
        	switch(sAction) {
        		case IBSEARCH:
    	    		if (sheetObjects[0].RowCount >= 1) 
    	    			sheetObjects[0].RemoveAll();
    	    		if (sheetObjects[1].RowCount >= 1) 
    	    			sheetObjects[1].RemoveAll();
    	    		if (sheetObjects[2].RowCount >= 1) 
    	    			sheetObjects[2].RemoveAll();    			    			
    	    		if (sheetObjects[3].RowCount >= 1) 
    	    			sheetObjects[3].RemoveAll();    			
        		/**
//        		alert("SEARCHLIST01 "+SceFrmQryString(formObj));
            				formObj.f_cmd.value   = SEARCHLIST01 ;
            				sheetObjects[0].DoSearch4Post("ESD_SCE_012GS.do", SceFrmQryString(formObj));
            				//var sXml = sheetObj.GetSearchXml("ESD_SCE_012GS.do", SceFrmQryString(formObj));
            				//FORTEST::XML찍어보기alert("["+sXml+"]");
//            				alert("2");
//        		alert("SEARCHLIST02 "+SceFrmQryString(formObj));
            				formObj.f_cmd.value   = SEARCHLIST02 ;
            				sheetObjects[1].DoSearch4Post("ESD_SCE_012GS2.do", SceFrmQryString(formObj));
            				formObj.f_cmd.value   = SEARCHLIST03 ;
            				document.form.s_htp_cd.value = sheetObjects[1].CellValue(2, "s_tp_cd_hd");
    //alert(document.form.s_htp_cd.value);
                 ComConfigSheet(sheetObjects[2]);

                initSheet(sheetObjects[2],2+1);
                ComEndConfigSheet(sheetObjects[2]);

            				//screenReload();
//            				alert(document.form.s_htp_cd.value);
        		//alert("SEARCHLIST03 "+SceFrmQryString(formObj)+" :"+document.form.s_htp_cd.value);
            				sheetObjects[2].DoSearch4Post("ESD_SCE_012GS3.do", SceFrmQryString(formObj));
//        		alert("SEARCHLIST04 "+SceFrmQryString(formObj));
            				formObj.f_cmd.value   = SEARCHLIST04 ;
            				sheetObjects[3].DoSearch4Post("ESD_SCE_012GS4.do", SceFrmQryString(formObj));
        			break;
        			* */
         			formObj.f_cmd.value = SEARCHLIST;
        			formObj.target	  = "_self" ;
        			//var sXml = sheetObj.GetSearchXml("ESD_SCE_0012GS_TTL.do", SceFrmQryString(formObj));
    				//sheetObj.LoadSearchXml(sXml);
    				//sheetObjects[0].LoadSearchXml(sheetObj.EtcData("sheet1"));
    				//sheetObjects[1].LoadSearchXml(sheetObj.EtcData("sheet2"));
    				//sheetObjects[2].LoadSearchXml(sheetObj.EtcData("sheet3"));
    				//sheetObjects[3].LoadSearchXml(sheetObj.EtcData("sheet4"));				
    				//sheetObj.RemoveEtcData();
        			
        			        			
        			//nao............sheetObj.DoSearch4Post("ESD_SCE_0012GS_TTL.do", SceFrmQryString(formObj));
        			
        			var sXml = sheetObj.GetSearchXml("ESD_SCE_0012GS_TTL.do", SceFrmQryString(formObj));
        			
        			var arrXml = sXml.split("|$$|");
        			
        			if(arrXml.length > 1) sheetObjects[0].LoadSearchXml(arrXml[0]); 
        			if(arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]); 
        			if(arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[2]); 
        			if(arrXml.length > 1) sheetObjects[3].LoadSearchXml(arrXml[3]); 
        			
        			break;
        		case IBSAVE:
        				formObj.f_cmd.value = MODIFY;
        				//sheetObjects[1].CellValue(1, "c_ibflag")='U';
        			    //alert(sheetObjects[1].CellValue(1, "c_ibflag"));
        				//alert(SceFrmQryString(formObj));
        				sheetObj.DoAllSave("ESD_SCE_0012U.do", SceFrmQryString(formObj)) ;
        				formObj.f_cmd.value   = SEARCHLIST04 ;
        				sheetObjects[3].DoSearch4Post("ESD_SCE_0012GS4.do", SceFrmQryString(formObj));
        			break ;
        	    case IBSEARCH_ASYNC01:
        				formObj.f_cmd.value = MULTI;
        				formObj.target = "_self";
        				sheetObj.doAllSave("ESD_SCE_0012U.do", SceFrmQryString(formObj)) ;
        	        break;
        	    case IBDOWNEXCEL:
                          //alert("IBDOWNEXCEL");
                          sheetObjects[0].Down2Excel(-1);
                          sheetObjects[1].Down2Excel(-1, true);
                          sheetObjects[2].Down2Excel(-1, true);
                          sheetObjects[3].Down2Excel(-1, true);
        	        break;

        	}
        }
    }

    function sheet1_OnPopupClick(sheetObj, row, col){
    }


    function sheet1_OnAfterColumnMove(sheetObj, col, newPos){
    	var newColName = sheetObj.ColSaveName(newPos) ;
    	switch (newColName) {
    		case "r_bkg_no":
    			if (col > newPos){
    				 newPos = newPos+1;
    			}

      			sheetObj.MoveColumnPos("r_bkg_no_split", newPos, false);
    			break;
    		case "r_cust_cnt_seq1":
    			if (col > newPos){
    				 newPos = newPos+1;
    			}

      			sheetObj.MoveColumnPos("r_cust_lgl_eng_nm1", newPos, false);
    			break;
    		case "r_cust_cnt_seq2":
    			if (col > newPos){
    				 newPos = newPos+1;
    			}

      			sheetObj.MoveColumnPos("r_cust_lgl_eng_nm2", newPos, false);
    			break;
    		case "r_cust_cnt_seq3":
    			if (col > newPos){
    				 newPos = newPos+1;
    			}

      			sheetObj.MoveColumnPos("r_cust_lgl_eng_nm3", newPos, false);
    			break;
    		default:
    			break;

    	}

    }

    function validateForm(sheetObj,formObj,sAction){
    	var result = true ;

    	switch (sAction) {
    		case IBSEARCH:
    			if(isEmpty(formObj.cop_cntr_no)){
    				ComShowCodeMessage('COM12114', 'CNTR No') ;
    		    	formObj.cop_cntr_no.focus() ;
    		    	result = false ;
    			}
    			break;
    		case IBINSERT:
    			if(sheetObj.RowCount==0){
    				ComShowCodeMessage('SCE90018') ;
    				result = false ;
    			}
    			else if(sheetObj.RowCount==2){
    				ComShowCodeMessage('SCE90019') ;
    				result = false ;
    			}
    			break ;
    		default:
    			break;
    	}

    	return result ;
    }

    function keyAction() {
        var formObj = document.form ;

    	//if(event.keyCode == 13){
    	if(chkLen(formObj.cop_expt_no, 14)){
    		if(isEmpty(formObj.cop_expt_no)){
    		    ComShowCodeMessage('COM12114', 'Exception No') ;
    		    formObj.cop_expt_no.focus() ;
    		    return ;
    		}

    		formObj.f_cmd.value = SEARCHLIST;
    		formObj.action      = "ESD_SCE_0012.do" ;
    		formObj.submit();
    	}
    }

    function sheet1_OnPopupClick(sheetObj, row, col){
    	openStaffPopSheet(sheetObj, row, true, col)
    }

    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
    	if(ErrMsg==""){
    		var formObj = document.form ;
    		doActionIBSheet(sheetObj,formObj, IBSEARCH) ;
    		ComShowCodeMessage('SCE90005') ;
    	}
    }

         /**
          * @param  obj   
          * @return
          */
         function bntImgEnable(obj, gb) {


          var objNm = obj.name;

          var btnStyle = eval("document."+objNm+".style");

          if (gb){
           obj.disabled = false;
           btnStyle.cursor = "hand";
           btnStyle.filter="";
          } else {
           obj.disabled = true;
           btnStyle.cursor = "none";
           btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
          }
         }

    function showtip2(current,e,text){
    //alert("document.all.shipper_name.length["+document.all.shipper_name.length+"] document.form.shipper_name.length["+document.form.shipper_name.length+"] document.form.shipper_name.length["+document.form.shipper_name.length+"]");
    //varWidth = document.all.shipper_name.length;

    //
      if (document.all&&document.readyState=="complete"){
        //document.all.tooltip2.innerHTML='<marquee style="border:1px solid  black;font-size:8pt;padding:5px">'+text+'</marquee>'
        //document.all.tooltip2.style.pixelLeft=event.clientX+document.body.scrollLeft+10
        //document.all.tooltip2.style.pixelTop=event.clientY+document.body.scrollTop+10
        //document.all.tooltip2.style.width="auto";
        //document.getElementById("tooltip2").style.width="auto";


        document.all.tooltip2.innerHTML=text;
        document.all.tooltip2.style.pixelLeft=event.clientX+10;
        document.all.tooltip2.style.pixelTop=event.clientY+10;
        document.all.tooltip2.style.visibility="visible";
        //document.form.shipper_name.value.length
    }
    /*
      else if (document.layers){
        document.tooltip2.document.nstip.document.write('<b>'+text+'</b>')
        document.tooltip2.document.nstip.document.close()
        document.tooltip2.document.nstip.left=0
        currentscroll=setInterval("scrolltip()",100)
        document.tooltip2.left=e.pageX+10
        document.tooltip2.top=e.pageY+10
        document.tooltip2.visibility="show"
    }
    */
    }
    function hidetip2(){
      if (document.all)
        document.all.tooltip2.style.visibility="hidden";
        else if (document.layers){
        clearInterval(currentscroll);
        document.tooltip2.visibility="hidden";
    }
    }

    function OnServerMsg(Msg){
        alert("OnServerMsg:"+Msg);
    }

    function openESD_SCE_101(sheetObj) {
     	var chkCnt = sheetObj.CheckedRows("r_chk") ;

    	if( chkCnt==0 ) {
    		ComShowCodeMessage('COM12113', 'COP') ;
    		return false ;
    	}

    	var chkRows = sheetObj.FindCheckedRow("r_chk") ;
    	var arrChkRows = chkRows.split("|") ;
    	var newForm = "" ;
    	newForm  = "<form name='form1' method='post'>" ;
    	newForm += "  <input type='hidden' name='cop_no'       value='" + sheetObj.CellValue(arrChkRows[0], "r_cop_no") + "'>" ;
    	newForm += "  <input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(arrChkRows[0], "r_bkg_no") + "'>" ;
    	newForm += "  <input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(arrChkRows[0], "r_bkg_no_split") + "'>" ;
    	newForm += "  <input type='hidden' name='cntr_no'      value='" + sheetObj.CellValue(arrChkRows[0], "r_cntr_no") + "'>" ;
    	newForm += "</form>"
    	document.all.new_form.innerHTML = newForm ;

    	var formObj = document.form;
    	formObj.action = "ESD_SCE_006.do";
    	formObj.submit() ;
    }
 
    	function goCopDetail( formObj){
    	
    		var cntrno = "COMU0000000";
    		var cop = sheetObjects[0].CellValue(2, "b_cop");
    		var bkg = sheetObjects[0].CellValue(2, "b_bkg");

    		var bkg_sp = bkg.substring(11,13);

    		bkg = bkg.substring(0,11);
    		var cntr = sheetObjects[0].CellValue(2, "b_cntr");

    		var newForm ="";

    		if(cop.length >0 && bkg.length >0){
    			if(cntr.value != "no" && cntr.length > 4){
    				cntrno = cntr;
    			}
    			newForm = "ESD_SCE_0006.do?cop_no=" + cop + "&bkg_no=" + bkg + "&cntr_no="+ cntrno;

//            var newForm  = "";
//    	  	newForm  = "<form name='form1' method='post'>" ;
//        	newForm += "  <input type='hidden' name='cop_no'       value='" + cop + "'>" ;
//            newForm += "  <input type='hidden' name='bkg_no'       value='" + bkg + "'>" ;
//            newForm += "  <input type='hidden' name='bkg_no_split' value='" + bkg_sp + "'>" ;
//            newForm += "  <input type='hidden' name='cntr_no'      value='" + cntr + "'>" ;
//            newForm += "</form>";
    //
//            document.all.new_form.innerHTML = newForm ;
    //
//    	    var formObj = document.form ;
    			formObj.action = newForm;

    	    	formObj.submit() ;
    	    }
        }

    function openESD_SCE_102_NEW( dataObjects, formObj) {

    	if( sheetObjects[0].Rows < 3 || dataObjects[1] < 3 || sheetObjects[3] < 3 ) {
    		alert ( "There is no Data .. Check Search Conditions");
    		return ;
    	}

    	var szBkgNo ="";
    	if (dataObjects[0].CellValue( 2, 0) != "There is no data to search" ){

    		szBkgNo = "&#39;"+dataObjects[0].CellValue( 2, 0)+"&#39;";
	 	
	
	    	var newForm = "" ;
	
	    	newForm  = "<form name='form1' method='post'>" ;
	    	newForm += "  <input type='hidden' name='send_val' value='" + formObj.cop_expt_no.value  + "'>" ;
	    	newForm += "  <input type='hidden' name='szBkgNo' value=" + szBkgNo + ">" ;		
	    	newForm += "</form>"
	
	    	document.all.new_form.innerHTML = newForm ;
	
	    	var formObj = document.form1 ;
	    	var paramUrl = "pgmNo=ESD_SCE_0102&send_val="+formObj.send_val.value+"&szBkgNo="+formObj.szBkgNo.value;
	        var newWin = window.showModalDialog("ESD_SCE_0102.do?"+paramUrl, "mailPopup", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:400px");
	//    	var newWin  = window.open("","mailPopup", "width=550,height=400");
	//    	formObj.action = "ESD_SCE_0102.do" ;
	//    	formObj.target = "mailPopup" ;
	//    	formObj.submit() ;
    	}
    }

    function openESD_SCE_102(dataObjects, formObj){

    	if( sheetObjects[0].Rows <3 || dataObjects[1] < 3 || sheetObjects[3] < 3 ) {
    		alert ( "There is no Data .. Check Search Conditions");
    		return ;
    	}

    	var szResult = "" ;


    	var bkg_no = dataObjects[0].CellValue( 2, 0);
    	var bkg_no_split ="";
    	if (bkg_no.length > 11) {
    		bkg_no_split = bkg_no.substring(11, 12);
    		bkg_no = bkg_no.substring(0, 11);

    	}

    	szResult = formObj.cop_expt_no.value + "|" + // exception no
    			bkg_no + "|" + //bkg_no
    			bkg_no_split + "|" + //bkg_no_split
    			dataObjects[0].CellValue( 2, 1) + "|" + //bl_no
    			dataObjects[0].CellValue( 2, 2) + "|" + //cop_no
    			dataObjects[0].CellValue( 2, 3) + "|" + //cntr_no
    			dataObjects[1].CellValue( 2, 0) + "|" + //exception type
    			dataObjects[1].CellValue( 2, 1) + "|" + //exception type detail
    			dataObjects[1].CellValue( 2, 3) + "|" + //exception status
    			dataObjects[1].CellValue( 2, 4) + "|" + //exception reason
    			dataObjects[0].CellValue( 3, 0) + "|" + //shipper
    			dataObjects[0].CellValue( 3, 3) + "|" + //consignee
    			dataObjects[0].CellValue( 3, 6) + "|" + //notify
    			dataObjects[0].CellValue( 2, 4) + "|" + //vvd
    			dataObjects[0].CellValue( 2, 5) + "|" + //por
    			dataObjects[0].CellValue( 2, 6) + "|" + //pol
    			dataObjects[0].CellValue( 2, 7) + "|" + //pod
    			dataObjects[0].CellValue( 2, 8) + "|" + //del
    			dataObjects[1].CellValue( 3, 0) + "|" + //occurred date/time
    			dataObjects[1].CellValue( 3, 2) + "|" + //occurred office
    			dataObjects[1].CellValue( 3, 1) + "|" + //occurred location
    			dataObjects[1].CellValue( 3, 4) + "|" + //resolved date
    											  "|" + //delay date 
    			dataObjects[2].CellValue( 2, 0) + "|" + //from activity
    			dataObjects[2].CellValue( 2, 1) + "|" + //from estimated date
    			dataObjects[2].CellValue( 2, 2) + "|" + //from actual date
    			dataObjects[2].CellValue( 2, 3) ; //from update date

    			if( formObj.s_htp_cd.value == 1) {

    				szResult = szResult + "|" + dataObjects[2].CellValue( 2, 4) + "|" + //to activity
    				dataObjects[2].CellValue( 2, 5) + "|" + //to estimated date
    				dataObjects[2].CellValue( 2, 6) + "|" + //to actual date
    				dataObjects[2].CellValue( 2, 7) ; //to update date

    			} else {
    				szResult = szResult + "|" + dataObjects[2].CellValue( 2, 6) + "|" + //to activity
    				dataObjects[2].CellValue( 2, 7) + "|" + //to estimated date
    				dataObjects[2].CellValue( 2, 8) + "|" + //to actual date
    				dataObjects[2].CellValue( 2, 9); //to update date

    			}

    			szResult = szResult + "|" +  dataObjects[3].CellValue( 1, 0) + "|" + //confirm
    			dataObjects[3].CellValue( 1, 1) + "|" + //confirm id
    			dataObjects[3].CellValue( 1, 2); //confirm date


    	var newForm = "" ;

    	newForm  = "<form name='form1' method='post'>" ;
    	newForm += "  <input type='hidden' name='send_val' value='" + szResult + "'>" ;
    	newForm += "</form>"

    	document.all.new_form.innerHTML = newForm ;

    	var formObj = document.form1 ;
    	var newWin  = window.open("","mailPopup", "width=480,height=400");
    	formObj.action = "ESD_SCE_0102.do" ;
    	formObj.target = "mailPopup" ;
    	formObj.submit() ;
    }

    function sheet3_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
    {
         if(sheetObj.MouseCol == sheetObj.SaveNameCol("d_act_cd1") || sheetObj.MouseCol == sheetObj.SaveNameCol("d_act_cd2")){


                 
//                sheetObj.MousePointer = "Default";  
                  sheetObj.MousePointer = "Hand";     

                  if(sheetObj.MouseCol == sheetObj.SaveNameCol("d_act_cd1")) sText = sheetObj.CellText(sheetObj.MouseRow,"d_act_cd1_nm");
                  else if(sheetObj.MouseCol == sheetObj.SaveNameCol("d_act_cd2")) sText = sheetObj.CellText(sheetObj.MouseRow,"d_act_cd2_nm");
               	  //sText = sheetObj.CellText(sheetObj.MouseRow,"d_act_cd1_nm");
                  
              	  sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
         }

    }

