/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0506.js
*@FileTitle  : Port Information Creation
*@author     : CLT
*@since      : 2014/05/15
=========================================================
*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class vop_vsk_0506 : business script for vop_vsk_0506
     */
   
    
    // public variable
    var set_day = 30;
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;     
    var t5sheet1Flg = true;
    var t3Dfs = "";
    var tabNowCnt = 0;
	var fastFlg = false;
	var rhqChangeFlg = true;
	
    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
	function processButtonClick(){

		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4]; 
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];
		var sheetObject8 = sheetObjects[7];         

        /*******************************************************/
        var formObject = document.form;
		var objs = document.all.item("tabLayer");
    	try {
			var srcName = window.event.srcElement.getAttribute("name");
			if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_Calendar":
					if( objs[1].style.display == "inline" ){
						var cal = new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.cel_year, 'yyyy');
					}
					break;
				
				case "btn_Retrieve":
					if( objs[0].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH,true);   //tab1
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBSEARCH,true);   //tab2
					}else if( objs[2].style.display == "inline" ){
						//ComShowCodeMessage('VSK50016');
						doActionIBSheet(sheetObject3,formObject,IBSEARCH,true);   //tab3
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBSEARCH,true);   //tab4
    				}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject5,formObject,IBSEARCH,true);   //tab5
					}else if( objs[5].style.display == "inline" ){
						doActionIBSheet(sheetObject7,formObject,IBSEARCH,true);   //tab6    							
					}else if( objs[6].style.display == "inline" ){
						doActionIBSheet(sheetObject8,formObject,IBSEARCH,true);   //tab7    							
					}else{
						doActionIBSheet(sheetObject1,formObject,IBSEARCH,true);   //tab1
					}
					break;

				case "btn_New":
					if( objs[0].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBCLEAR,true);   //tab1
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBCLEAR,true);   //tab2
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBCLEAR,true);   //tab3
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBCLEAR,true);   //tab4
    				}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject5,formObject,IBCLEAR,true);   //tab5
					}else if( objs[5].style.display == "inline" ){
						doActionIBSheet(sheetObject7,formObject,IBCLEAR,true);   //tab6    							
					}else if( objs[6].style.display == "inline" ){
						doActionIBSheet(sheetObject8,formObject,IBCLEAR,true);   //tab7    							
					}else{
						doActionIBSheet(sheetObject1,formObject,IBCLEAR,true);   //tab1
					}
					break;

				case "btn_loc_cd":	//Location popup
					if(formObject.btn_loc_cd.className == ""){
						break;
					}					
					var cnt_cd = "";
					var loc_cd = formObject.loc_cd.value;
			    	var sUrl = "/opuscntr/VOP_VSK_0043.do";
			    	ComOpenPopup(sUrl, 422, 520, "getRtnVal", "0,0", true);
					
					break; 											
    							
					/**		TAB 1		**/
				case "btn_t1downexcel" :
					if (sheetObject1.RowCount() < 1) { // no data
						ComShowCodeMessage("COM132501");
					} else {
						//sheetObject1.Down2Excel({HiddenColumn:1, Merge:true, TreeLevel:false});
						sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
					break;								
					/**		TAB 2		**/
				case "btn_t2downexcel" :
					if (sheetObject2.RowCount() < 1) { // no data
						ComShowCodeMessage("COM132501");
					} else {
						//sheetObject2.Down2Excel({HiddenColumn:-1});
						sheetObject2.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject2),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
					break; 
					/**		TAB 3		**/
				case "btn_t3downexcel" :
					if (sheetObject3.RowCount() < 1) { // no data
						ComShowCodeMessage("COM132501");
					} else {
						//sheetObject3.Down2Excel({HiddenColumn:-1});
						sheetObject3.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject3),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
					break;
					/**		TAB 4		**/
				case "btn_t4downexcel" :
					if (sheetObject4.RowCount() < 1) { // no data
						ComShowCodeMessage("COM132501");
					} else {
						//sheetObject4.Down2Excel({HiddenColumn:-1});
						sheetObject4.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject4),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
					break;
					/**		TAB 5		**/
				case "btn_t5downexcel" :
					if (sheetObject5.RowCount() < 1) { // no data
						ComShowCodeMessage("COM132501");
					} else {
						//sheetObject5.Down2Excel({HiddenColumn:1, Merge:true, TreeLevel:false});
						sheetObject5.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject5),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
					break;
					/**		TAB 5-2		**/
				case "btn_t5downexcel2" :
					if (sheetObject6.RowCount() < 1) { // no data
						ComShowCodeMessage("COM132501");
					} else {
		 				//sheetObject6.Down2Excel({HiddenColumn:1, Merge:true, TreeLevel:false});
		 				sheetObject6.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject6),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
					break;
					/**		TAB 6		**/
				case "btn_t6downexcel" :
					if (sheetObject7.RowCount() < 1) { // no data
						ComShowCodeMessage("COM132501");
					} else {
						//sheetObject7.Down2Excel({HiddenColumn:1, Merge:true, TreeLevel:false});
						sheetObject7.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject7),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
					break;
					/**		TAB 7		**/
				case "btn_t7downexcel" :
					if (sheetObject8.RowCount() < 1) {//no data
						ComShowCodeMessage("COM132501");
					} else {
						//sheetObject8.Down2Excel({HiddenColumn:1, Merge:true, TreeLevel:false});
						sheetObject8.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject8),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
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

	function getRtnVal(rVal){
		
		if(rVal){
			document.form.loc_cd.value=rVal;
			loc_cd_onchange();
		}	
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

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        for(i=0;i<sheetObjects.length;i++){
           // doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        
 	 	//IBMultiCombo initialize
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }
 	   doActionIBSheet(sheetObjects[0],document.form,SEARCH01);

       initControl();
    }

	/**
	 * setting combo initial values and header
	 * param : comboObj, comboNo
	 * adding case as numbers of counting combos 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.options.id) {
			case "rhq":
				with(comboObj) {
					comboObj.SetDropHeight(125);
					SetBackColor("#CCFFFD");
//					InsertItem(i++,  "ALL",  "^");
//					comboObj.SetSelectCode("^");
					
					//SetColWidth(0, 90);
					//SetDropHeight(125);
					InsertItem(i++, "ALL", "^");
					SetSelectCode("^");
	        	}
				break;
	        
		}
	}        

  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "t1sheet1":
                with(sheetObj){
	            	  SetColProperty(prefix+"alsd_cd", {ComboText:"|MostlyStarboard|StarboardOnly|PORTOnly|MostlyPort|BOTH", ComboCode:"|MS|OS|OP|MP|BO"} );
	        	      var HeadTitle1="|TMNL Code|TMNL Name|Alongside|Depth (M)|Depth (M)|Draft (M)|Draft (M)|Air Draft (M)|Length of Turning\nBasin (M)|Berth\nLength|Pilot Maneuvering In/Out|Pilot Maneuvering In/Out|Remark(s)|||";
	        	      var HeadTitle2="|TMNL Code|TMNL Name|Alongside|Channel|Berth|Anytime|Max|Air Draft (M)|Length of Turning\nBasin (M)|Berth\nLength|Distance (NM)|Time (Hr)|Remark(s)";
	        	      var headCount=ComCountHeadTitle(HeadTitle1);
	        	      var prefix="t1sheet1_";
	        	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	        	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	        	                      { Text:HeadTitle2, Align:"Center"} ];
	        	      InitHeaders(headers, info);
	        	      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0,  Width:230,   Align:"Left",    ColMerge:1,   SaveName:prefix+"yd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	        	             {Type:"Text",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"alsd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"chnl_dpth",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"brth_dpth",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"at_drft_dpth",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"max_drft_dpth",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ad_len",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"turn_bsn_len",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"brth_len",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"plt_mnvr_dist",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"plt_mnvr_tm_hrs", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnvr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	        	             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	        	      InitColumns(cols);
	        	      SetSheetHeight(410);
	        	      SetEditable(0);
        	      }
				break;

            case "t2sheet1":
            	with(sheetObj){
	            	var HeadTitle1="|Seq.|Port|Hol Seq|Start Date|End Date|Holiday Description|Remark(s)||";
	            	var headCount=ComCountHeadTitle(HeadTitle1);
	            	var prefix="t2sheet1_";
	            	var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers=[ { Text:HeadTitle1, Align:"Center"} ];
	            	InitHeaders(headers, info);
	            	var cols=[ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				            	{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
				            	{Type:"Text",     Hidden:0, Width:130,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				            	{Type:"Text",      Hidden:1, Width:160,  Align:"Left",    ColMerge:1,   SaveName:prefix+"hol_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hol_st_dt",  KeyField:1,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hol_end_dt", KeyField:1,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:prefix+"hol_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:prefix+"hol_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
				            	{Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				            	{Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            	InitColumns(cols);
	            	SetColProperty(prefix+"hol_st_dt", {Format:"####-##-####:##"} );
	            	SetColProperty(prefix+"hol_end_dt", {Format:"####-##-####:##"} );
	            	SetShowButtonImage(2);
            		SetSheetHeight(410);
	            	SetEditable(0);
            	}
	        break;

            case "t3sheet1":
                with(sheetObj){
	              var HeadTitle1="|Seq.||To Port|Time Diff.(Hrs)|Distance |Distance |Shortest Distance|Shortest Distance|||";
	              var HeadTitle2="|Seq.||To Port|Time Diff.(Hrs)|Distance|Description|Distance|Description";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t3sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",    ColMerge:1,   SaveName:prefix+"fm_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:1,   SaveName:prefix+"to_loc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",  ColMerge:1,   SaveName:prefix+"gmt_td_hrs",     KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:prefix+"stnd_dist",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"stnd_dist_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:prefix+"shrt_dist",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"shrt_dist_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_to_loc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetSheetHeight(410);
	              SetEditable(0);
                 }
			break;

            case "t4sheet1":
                with(sheetObj){
		             var HeadTitle1="||Port|Document Hour|Dead Hour|Dead Hour Description|Remark(s)||";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             var prefix="t4sheet1_";
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                 {Type:"Text",      Hidden:1, Width:170,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",  ColMerge:0,   SaveName:prefix+"doc_hrs",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",  ColMerge:0,   SaveName:prefix+"dead_hrs",     KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dead_hr_desc", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		                 {Type:"Text",      Hidden:0,  Width:150,   Align:"Left",    ColMerge:0,   SaveName:prefix+"doc_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
		                 {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             InitColumns(cols);
		             SetSheetHeight(410);
		             SetEditable(0);
               }
			break;

            case "t5sheet1":
                with(sheetObj){
        	         var HeadTitle1="|Port|Bound|Convoy or\nGroup|Limit Time without Surcharge|Limit Time with Surcharge|Limit Time with Surcharge|Limit Time with Surcharge|Remark(s)|||";
        	         var HeadTitle2="|Port|Bound|Convoy or\nGroup|Limit Time without Surcharge|L/Time|L/Time|Surcharge %|Remark(s)|||";
        	         var headCount=ComCountHeadTitle(HeadTitle1);
        	         var prefix="t5sheet1_";
        	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
        	         var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
        	         var headers = [ { Text:HeadTitle1, Align:"Center"},
        	                         { Text:HeadTitle2, Align:"Center"} ];
        	         InitHeaders(headers, info);
        	         var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
        	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Combo", 		Hidden:0, Width:100,   Align:"Center",    ColMerge:1,   SaveName:prefix+"svc_scp_bnd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Combo", 		Hidden:0, Width:130,   Align:"Center",    ColMerge:1,   SaveName:prefix+"cnl_tz_seq_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"scg_expt_lmt_hrmnt", KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scg_fm_lmt_hrmnt",   KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scg_to_lmt_hrmnt",   KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",  ColMerge:1,   SaveName:prefix+"lmt_tm_scg_rto",     KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cnl_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
        	         InitColumns(cols);
        	         SetEditable(0);
        	         SetSheetHeight(320);
        	         SetColProperty(prefix+"svc_scp_bnd_cd", {ComboText:"|North|South", ComboCode:"|N|S"} );
                     SetColProperty(prefix+"cnl_tz_seq_cd", {ComboText:"|First|Second", ComboCode:"|1|2"} );
        	     }
			break;

            case "t5sheet2":
                with(sheetObj){
		             var HeadTitle1="|Port / Tier|1 Tier|2 Tier|3 Tier|4 Tier|5Tier|6 Tier|7 Tier|8 Tier|9 Tier";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             var prefix="t5sheet2_";
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		             var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:125,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no1", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no2", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no3", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no4", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no5", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no6", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no7", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no8", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no9", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		             InitColumns(cols);
		             SetSheetHeight(100);
		             SetEditable(0);
                }
            break;

            case "t6sheet1":
                with(sheetObj){
		              var HeadTitle1="|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|";
		              HeadTitle1 += "Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|||";
		              var HeadTitle2="|Port|Weight for 20 ft\n(Kgs)|Weight for 40 ft\n(Kgs)|Weight per Axial\n(Kgs)|Max \nLength(M)|Max \nWidth(M)|Max \nHeight(M)|Over \nLength(Cm)|Over \nWidth(Cm)|Over \nHeight(Cm)||Remark(s)";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              var prefix="t6sheet1_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                              { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_20ft_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_40ft_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_axl_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_len",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_wdt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_hgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_len",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_wdt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:125,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_hgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"trsp_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetSheetHeight(410);
		              SetEditable(0);
                }
            break;

            case "t7sheet1":
                with(sheetObj){
		              var HeadTitle1="|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|";
		              HeadTitle1 += "Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|";
		              var HeadTitle2="|Port|Weight for 20 ft\n(Kgs)|Weight for 40 ft\n(Kgs)|Max \nLength(M)|Max \nWidth(M)|Max \nHeight(M)|Over \nLength(Cm)|Over \nWidth(Cm)|Over \nHeight(Cm)|||Remark(s)";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              var prefix="t7sheet1_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_20ft_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_40ft_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_len",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_wdt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_hgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_len",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_wdt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:130,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_hgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_axl_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"trsp_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetSheetHeight(410);
		              SetEditable(0);
                    }
                break;
                
            case "t10sheet1":    				
                with (sheetObj) {
                	WaitImageVisible = false;
                }
            break;
        }
    }

    		// handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction, sQuest) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case SEARCH01:
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj)
				var sXml = sheetObj.GetSearchData("VOP_VSK_0221GS.do", sParam);
				var rhqlist = ComGetEtcData(sXml, "rhqlist");
				if(rhqlist){
					var comboObj=comboObjects[0];
					var rhqs=rhqlist.split(":");
					for(var i=0; i<rhqs.length; i++){
						comboObj.InsertItem(-1, rhqs[i], rhqs[i]);
					}
				}
			break;
				
			case IBSEARCH:		//Retrieve
				if(validateForm(sheetObj,formObj,sAction))
					if ( sheetObj.id == "t1sheet1")
					{	
						formObj.f_cmd.value = SEARCH;
						var arr = new Array("t1sheet1_", "");
						var sXml = sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
						var arrXml = sXml.split("|$$|");
						for(var i = 0; i<arrXml.length; i++){
							if( i == 0 )
							{	
								sheetObj.LoadSearchData(arrXml[i], {Sync:1}); 
							}
						}
					} else if (sheetObj.id == "t2sheet1")
					{	
						formObj.f_cmd.value=SEARCH01;
						var arr=new Array("t2sheet1_", "");
						var sXml=sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
						var arrXml=sXml.split("|$$|");
						for(var i=0; i<arrXml.length; i++){ 
							if( i==0 ){
								sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
							}
						} 
					} else if ( sheetObj.id == "t3sheet1")
					{
						formObj.f_cmd.value = SEARCH02;
						var arr = new Array("t3sheet1_", "");
						var sXml = sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
						var arrXml = sXml.split("|$$|");
						for(var i = 0; i<arrXml.length; i++){ 
							if(i == 0){	
								sheetObj.LoadSearchData(arrXml[0], {Sync:1}); 
							}
						} 
					} else if ( sheetObj.id == "t4sheet1")
					{
						formObj.f_cmd.value = SEARCH03;
						var arr = new Array("t4sheet1_", "");
						var sXml = sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
						var arrXml = sXml.split("|$$|");
						for(var i = 0; i<arrXml.length; i++){ 
							if(i == 0){
								sheetObj.LoadSearchData(arrXml[0], {Sync:1}); 
							}
						} 
					} else if ( sheetObj.id == "t5sheet1")
					{
						formObj.f_cmd.value = SEARCH04;
						var arr = new Array("t5sheet1_", "t5sheet2_", "");
						var sXml = sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
						var arrXml = sXml.split("|$$|");
						sheetObjects[4].LoadSearchData(arrXml[0], {Sync:1});
						sheetObjects[5].LoadSearchData(arrXml[1], {Sync:1});
						
					} else if ( sheetObj.id == "t6sheet1")
					{
						formObj.f_cmd.value = SEARCH05;
						var arr = new Array("t6sheet1_", "");
						var sXml = sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
						var arrXml = sXml.split("|$$|");
						for(var i = 0; i<arrXml.length; i++){ 
							if(i == 0)
							{
								sheetObj.LoadSearchData(arrXml[0], {Sync:1}); 
							}
						}
					} else if ( sheetObj.id == "t7sheet1")
					{
						formObj.f_cmd.value = SEARCH06;
						var arr = new Array("t7sheet1_", "");
						var sXml = sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
						var arrXml = sXml.split("|$$|");

						for(var i = 0; i<arrXml.length; i++){ 
							if(i == 0)
							{
								sheetObj.LoadSearchData(arrXml[0], {Sync:1}); 
							}
						} 
					} 
			break;
			
			case IBCLEAR:
				if ( sheetObj.id == "t1sheet1")
				{
					formObj.loc_cd.value = "";
					formObj.in_rhq.value = "";
					formObj.upd_dt.value = "";
					formObj.upd_usr_id.value = "";            		
					sheetObj.RemoveAll();
					document.form.mnvr_rmk.value = "";
				} else if (sheetObj.id == "t2sheet1")
				{
            		formObj.loc_cd.value = "";
            		formObj.upd_dt.value = "";
            		formObj.upd_usr_id.value = "";            		
            		sheetObj.RemoveAll();
					//}
				} else if (sheetObj.id == "t3sheet1")
				{
					formObj.loc_cd.value = "";
					formObj.in_rhq.value = "";
            		formObj.upd_dt.value = "";
            		formObj.upd_usr_id.value = "";            		
            		sheetObj.RemoveAll();
					//}
				} else if (sheetObj.id == "t4sheet1")
				{
					formObj.loc_cd.value = "";
            		formObj.upd_dt.value = "";
            		formObj.upd_usr_id.value = "";            		
            		sheetObj.RemoveAll();
				} else if (sheetObj.id == "t5sheet1")
				{
            		formObj.upd_dt.value = "";
            		formObj.upd_usr_id.value = "";            		
            		sheetObj.RemoveAll();
            		sheetObjects[5].RemoveAll();
				} else if (sheetObj.id == "t6sheet1")
				{
					formObj.loc_cd.value = "";
            		formObj.upd_dt.value = "";
            		formObj.upd_usr_id.value = "";
            		sheetObj.RemoveAll();
            		document.form.trsp_rmk_td.value = "";
				} else if (sheetObj.id == "t7sheet1")
				{
					formObj.loc_cd.value = "";
            		formObj.upd_dt.value = "";
            		formObj.upd_usr_id.value = "";            		
            		sheetObj.RemoveAll();
            		document.form.trsp_rmk_rd.value = "";
				}
				formObj.cel_year.value = formObj.nowYear.value;
			break;
        
        }
    }

    function initControl() {
    	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	//axon_event.addListenerFormat('keyup', 'obj_keyup', form);
    	axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd', '');            //loc_cd change Event
    	axon_event.addListener('change', 'loc_cd_onchangeMax5', 'loc_cd', '');            //loc_cd change Event
    	axon_event.addListener('mousedown', 'obj_mousedown',  "btn_New");  
    	axon_event.addListener('change', 'mnvr_rmk_onchange', 'mnvr_rmk');      //mnvr_rmk change Event
    	axon_event.addListener('change', 'trsp_rmk_td_onchange', 'trsp_rmk_td');  //trsp_rmk_td change Event      	
    	axon_event.addListener('change', 'trsp_rmk_rd_onchange', 'trsp_rmk_rd');  //trsp_rmk_rd change Event
    	
    	
    	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }

    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertItem("Maneuvering" , "" );
                    InsertItem("Terminal Non-Working" , "" );
                    InsertItem("Distance" , "" );
                    InsertItem("Doc.&Dead Hrs" , "" );
                    InsertItem("Canal" , "" );
                    InsertItem("Trucking" , "" );
                    InsertItem("Railroad" , "" );
                }
             break;
         }
         tabObj.SetSelectedIndex(0);
    }
    /**
     * Handling tab click event
     * Activating clicked tab
     */
    function tab1_OnChange(tabObj , nItem)
    {
    	 formObject = document.form;
	   	 var objs=document.all.item("tabLayer");
	   	 objs[nItem].style.display="Inline";
	   	 for(var i = 0; i<objs.length; i++){
	       	  if(i != nItem){
	        	   objs[i].style.display="none";
	        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       	  }
	   	 }
        switch(nItem) {
    	case 0:
    		formObject.loc_cd.value = "";
    		formObject.loc_cd.className = "input1";
    		formObject.loc_cd.readOnly = false;
    		initBtn_loc_cd(true);
			document.all.item("comboRhq").style.display = "none";
			document.all.item("inputRhq").style.display = "inline";
			formObject.in_rhq.value = "";
    		formObject.upd_dt.value = "";
    		formObject.upd_usr_id.value = "";  
    		formObject.cel_year.className = "input2";
    		formObject.cel_year.readOnly = true;
    		ComEnableObject(document.all.btn_Calendar, false);
    		tabNowCnt = 1;
    	break;
    	
    	case 1:
    		formObject.loc_cd.value = "";
    		formObject.loc_cd.className = "input";
    		formObject.loc_cd.readOnly = false;
    		initBtn_loc_cd(true);
			document.all.item("comboRhq").style.display = "inline";
			document.all.item("inputRhq").style.display = "none";
    		formObject.upd_dt.value = "";
    		formObject.upd_usr_id.value = "";
    		comboObjects[0].SetEnable(1);
    		formObject.cel_year.className = "input";
    		formObject.cel_year.readOnly = false;
    		ComEnableObject(document.all.btn_Calendar, true);
    		tabNowCnt = 2;
    	break;
    	
    	case 2:
    		formObject.loc_cd.value = "";
    		formObject.loc_cd.className = "input1";
    		formObject.loc_cd.readOnly = false;
    		initBtn_loc_cd(true);
			document.all.item("comboRhq").style.display = "none";
			document.all.item("inputRhq").style.display = "inline";
			formObject.in_rhq.value = "";
    		formObject.upd_dt.value = "";
    		formObject.upd_usr_id.value = "";            		
    		formObject.cel_year.className = "input2";
    		formObject.cel_year.readOnly = true;
    		ComEnableObject(document.all.btn_Calendar, false);
    		tabNowCnt = 3;            		
    	break;
    	
    	case 3:
    		formObject.loc_cd.value = "";
    		formObject.loc_cd.className = "input";
    		formObject.loc_cd.readOnly = false;
    		initBtn_loc_cd(true);
			document.all.item("comboRhq").style.display = "inline";
			document.all.item("inputRhq").style.display = "none";
    		formObject.upd_dt.value = "";
    		formObject.upd_usr_id.value = "";            		
    		comboObjects[0].SetEnable(1);
    		formObject.cel_year.className = "input2";
    		formObject.cel_year.readOnly = true;
    		ComEnableObject(document.all.btn_Calendar, false);
    		tabNowCnt = 4;
    	break;
    	
    	case 4:
    		formObject.loc_cd.value = "EGSCA";
    		formObject.loc_cd.className = "input2";
    		formObject.loc_cd.readOnly = true;
    		initBtn_loc_cd(false);
			document.all.item("comboRhq").style.display = "none";
			document.all.item("inputRhq").style.display = "inline";
			formObject.in_rhq.value = "LONHQ";
    		formObject.upd_dt.value = "";
    		formObject.upd_usr_id.value = "";
    		formObject.cel_year.className = "input2";
    		formObject.cel_year.readOnly = true;
    		ComEnableObject(document.all.btn_Calendar, false);
    		tabNowCnt = 5;
    	break;
    	
    	case 5:
    		formObject.loc_cd.value = "";
    		formObject.loc_cd.className = "input";
    		formObject.loc_cd.readOnly = false;
    		initBtn_loc_cd(true);
			document.all.item("comboRhq").style.display = "inline";
			document.all.item("inputRhq").style.display = "none";            		
    		formObject.upd_dt.value = "";
    		formObject.upd_usr_id.value = "";            		
    		comboObjects[0].Enable = true;
    		formObject.cel_year.className = "input2";
    		formObject.cel_year.readOnly = true;
    		ComEnableObject(document.all.btn_Calendar, false);
    		formObject.trsp_mod_cd.value = "TD";
    		tabNowCnt = 6;
    	break;    
    	
    	case 6:
    		formObject.loc_cd.value = "";
    		formObject.loc_cd.className = "input";
    		formObject.loc_cd.readOnly = false;
    		initBtn_loc_cd(true);
			document.all.item("comboRhq").style.display = "inline";
			document.all.item("inputRhq").style.display = "none";               		
    		formObject.upd_dt.value = "";
    		formObject.upd_usr_id.value = "";
    		comboObjects[0].Enable = true;
    		formObject.cel_year.className = "input2";
    		formObject.cel_year.readOnly = true;
    		ComEnableObject(document.all.btn_Calendar, false);
    		formObject.trsp_mod_cd.value = "RD";
    		tabNowCnt = 7;
    	break;
        }
    }

    /**
     * Changing Port Code Retrieve popup button class style as clicked tab 
     * @return
     */
    function initBtn_loc_cd(Flag){
//    	if(Flag){
//    		document.all.btn_loc_cd.removeAttribute="disabled"
//    	} else{
//    	    document.all.btn_loc_cd.disabled='true';
//    	}
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	if (sheetObj.id == "t1sheet1")
        	{
				if(ComIsEmpty(formObj.loc_cd.value))
				{
					ComShowCodeMessage('VSK50008');
					ComAlertFocus(formObj.loc_cd, "");
					return false;
				}	
        	} else if (sheetObj.id == "t3sheet1")
        	{
				if(ComIsEmpty(formObj.loc_cd.value))
				{
					ComShowCodeMessage('VSK50008');
					ComAlertFocus(formObj.loc_cd, "");
					return false;
				}
        	} else if (sheetObj.id == "t5sheet1")
        	{
				if(ComIsEmpty(formObj.loc_cd.value))
				{
					ComShowCodeMessage('VSK50008');
					ComAlertFocus(formObj.loc_cd, "");
					return false;
				}	
        	}
        }
      return true;
    }
    
	function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value = sheetObj.GetCellValue(NewRow, "t1sheet1_upd_dt");
		document.form.upd_usr_id.value = sheetObj.GetCellValue(NewRow, "t1sheet1_upd_usr_id");
		document.form.mnvr_rmk.value = sheetObj.GetCellValue(NewRow, "t1sheet1_mnvr_rmk");
	}
	
	
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()> 0){
			document.form.upd_dt.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_upd_dt");
			document.form.upd_usr_id.value = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_upd_usr_id");
			document.form.mnvr_rmk.value = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_mnvr_rmk");
		}
	}        

   	// Port duplicate check and in case TMNL Code Clicked, Setting TMNL Name
	function t1sheet1_OnChange(sheetObj, Row, Col, Value){
		if(fastFlg){
			if(Col == 1){
				var sText = sheetObj.GetComboInfo(Row, Col, "Text");
				var arrText = sText.split("|");
				var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
				var vText = arrText[idx].split("\t");
				sheetObj.GetCellValue(Row, "t1sheet1_yd_nm") = vText[1];
				var idxDub = sheetObj.ColValueDup("t1sheet1_yd_cd");
				if(idxDub > -1){
					var idxDub2 =idxDub-1;
					ComShowCodeMessage("VSK50303","Port", idxDub2);
				}
			}
		}
	}    	
	
	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value = sheetObj.GetCellValue(NewRow, "t2sheet1_upd_dt");
		document.form.upd_usr_id.value = sheetObj.GetCellValue(NewRow, "t2sheet1_upd_usr_id");
	}
	
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
    		document.form.upd_dt.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t2sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t2sheet1_upd_usr_id");
		}
	}        
	
	function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value = sheetObj.GetCellValue(NewRow, "t3sheet1_upd_dt");
		document.form.upd_usr_id.value = sheetObj.GetCellValue(NewRow, "t3sheet1_upd_usr_id");
	}

	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
    		document.form.upd_dt.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t3sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t3sheet1_upd_usr_id");
		}
	}    	

    function t3sheet1_OnChange(sheetObj, Row, Col, Value){
    	if(Col == 3){
    		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
    		if(idx > 0){
    			var arrT3Dfs = t3Dfs.split("|");
    			sheetObj.GetCellValue(Row, "t3sheet1_gmt_td_hrs") = arrT3Dfs[idx-1];
    		}else{
    			sheetObj.GetCellValue(Row, "t3sheet1_gmt_td_hrs") = "";
    		}
    	}
        if(fastFlg){
        	// Port duplicate check
        	var idxDub = sheetObj.ColValueDup("t3sheet1_to_loc_cd");
        	if(idxDub > -1){
        		ComShowCodeMessage("VSK50303","Port", idxDub-1);
        	}
        }
    }    	
	
	function t4sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value = sheetObj.GetCellValue(NewRow, "t4sheet1_upd_dt");
		document.form.upd_usr_id.value = sheetObj.GetCellValue(NewRow, "t4sheet1_upd_usr_id");
	}
	
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
    		document.form.upd_dt.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t4sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t4sheet1_upd_usr_id");
		}
	}    	
	
	// Port duplicate check
	function t4sheet1_OnChange(sheetObj, Row, Col, Value){
		var idxDub = sheetObj.ColValueDup("t4sheet1_loc_cd");
		if(idxDub > -1){
			ComShowCodeMessage("VSK50303","Port", idxDub);
		}
	}
	
	function t5sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value = sheetObj.GetCellValue(NewRow, "t5sheet1_upd_dt");
		document.form.upd_usr_id.value = sheetObj.GetCellValue(NewRow, "t5sheet1_upd_usr_id");
	}
	
	function t5sheet1_OnSaveEnd(sheetObj,ErrMsg){
		var formObject = document.form;
		doActionIBSheet(sheetObjects[4],formObject,IBSEARCH, true);   //tab5
	}
	
    function t6sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value = sheetObj.GetCellValue(NewRow, "t6sheet1_upd_dt");
		document.form.upd_usr_id.value = sheetObj.GetCellValue(NewRow, "t6sheet1_upd_usr_id");
		document.form.trsp_rmk_td.value = sheetObj.GetCellValue(NewRow, "t6sheet1_trsp_rmk");
	}

	function t6sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
    		document.form.upd_dt.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t6sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t6sheet1_upd_usr_id");
    		document.form.trsp_rmk_td.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t6sheet1_trsp_rmk");
		}
	}   	
	    
	function t6sheet1_OnChange(sheetObj, Row, Col, Value){
		if(fastFlg){
			var idxDub = sheetObj.ColValueDup("t6sheet1_loc_cd");
			if(idxDub > -1){
    			var idxDub2 =idxDub-1;
				ComShowCodeMessage("VSK50303","Port", idxDub2);
			}
		}
	}
	
	function t7sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value = sheetObj.GetCellValue(NewRow, "t7sheet1_upd_dt");
		document.form.upd_usr_id.value = sheetObj.GetCellValue(NewRow, "t7sheet1_upd_usr_id");
		document.form.trsp_rmk_rd.value = sheetObj.GetCellValue(NewRow, "t7sheet1_trsp_rmk");
	}

	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
    		document.form.upd_dt.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t7sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t7sheet1_upd_usr_id");
    		document.form.trsp_rmk_rd.value = sheetObj.GetCellValue(sheetObj.SelectRow, "t7sheet1_trsp_rmk");
		}
	}
	 
	function t7sheet1_OnChange(sheetObj, Row, Col, Value){
		if(fastFlg){
			var idxDub = sheetObj.ColValueDup("t7sheet1_loc_cd");
			if(idxDub > -1){
				var idxDub2 = idxDub-1;
				ComShowCodeMessage("VSK50303","Port", idxDub2);
			}
		}
	}
	
	function t2sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		with(sheetObj)
		{
		    var cal = new ComCalendarGrid();
			if (sheetObj.ColSaveName(Col) == "t2sheet1_hol_st_dt") {
			    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd HH:mm');
		    }else if (sheetObj.ColSaveName(Col) == "t2sheet1_hol_end_dt") {
   			    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd HH:mm');
		    }
		}
	}

	function loc_cd_onchangeMax5(){
		var formObj = document.form;
		if(formObj.loc_cd.value != ""){
			if(formObj.loc_cd.value.length < 5 ){
				ComShowCodeMessage("VSK50014");
				ComAlertFocus(formObj.loc_cd, "");
				return ;
			}
		}
	}
	
	var checkMouseFlg = false;
	function obj_mousedown(){
		var formObj = document.form;
		doActionIBSheet(sheetObjects[beforetab],formObj,IBCLEAR,true);   //tab1
	}
	
	function loc_cd_onchange(){
		var formObj = document.form;
		var objs = document.all.item("tabLayer");
		if( objs[0].style.display == "inline")
		{
			setRhq_Combo(0);  /* Getting RHQ Text */
		} else if( objs[1].style.display == "inline")
		{
			setRhq_Combo(1);  /* Getting RHQ Combo */
			//ComAlertFocus(formObj.upd_dt, "");
		} else if( objs[2].style.display == "inline")
		{
			setRhq_Combo(2); /* Getting RHQ Text */				
		} else if( objs[3].style.display == "inline")
		{
			setRhq_Combo(3);   /* Getting RHQ Combo */
		} else if( objs[4].style.display == "inline")
		{
			setRhq_Combo(4); /* Getting RHQ Text */				
		} else if( objs[5].style.display == "inline")
		{
			setRhq_Combo(5);   /* Getting RHQ Combo */
		} else if( objs[6].style.display == "inline")
		{
			setRhq_Combo(6);  /* Getting RHQ Combo */				
		}
	}
	
	function mnvr_rmk_onchange(){
		sheetObjects[0].GetCellValue(sheetObjects[0].SelectRow , "t1sheet1_mnvr_rmk") = document.form.mnvr_rmk.value;
	}    	

	function trsp_rmk_td_onchange(){
		sheetObjects[6].GetCellValue(sheetObjects[6].SelectRow , "t6sheet1_trsp_rmk") = document.form.trsp_rmk_td.value;
	}    	

	function trsp_rmk_rd_onchange(){
		sheetObjects[7].GetCellValue(sheetObjects[7].SelectRow , "t7sheet1_trsp_rmk") = document.form.trsp_rmk_rd.value;
	}    	
	
    function rhq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
    {
    	var formObj = document.form;
		var objs = document.all.item("tabLayer");
		
		if(objs[1].style.display == "inline")
		{
			formObj.loc_cd.value = "";
		}else if(objs[3].style.display == "inline")
		{
			formObj.loc_cd.value = "";
		}else if(objs[5].style.display == "inline")
		{
			formObj.loc_cd.value = "";
		}else if(objs[6].style.display == "inline")
		{
			formObj.loc_cd.value = "";
		}
    }
    
    /* Getting RHQ Combo */
	function setRhq_Combo(tabCnt){
	    var formObj = document.form;
		formObj.f_cmd.value = SEARCH08;
		var sRhqXml = sheetObjects[8].GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj));
		var sRhqVal = ComGetEtcData(sRhqXml, "cmbVal");
		var sRhqName = ComGetEtcData(sRhqXml, "cmbName");
		if( sRhqVal != "")
		{
			var arrRhqVal = sRhqVal.split("|");
			var arrRhqName = sRhqName.split("|");
			for(var i=0; i<arrRhqVal.length ; i++)
			{
				rhqChangeFlg = false;
				if(tabCnt==1 || tabCnt==3 || tabCnt== 5 || tabCnt==6){
					rhq.SetSelectCode(arrRhqVal[0]);
				}else{
					formObj.in_rhq.value = arrRhqVal[0];
				}					
			}
		} else{
			ComShowCodeMessage('VSK50015', formObj.loc_cd.value);
			ComClearObject(formObj.loc_cd);
			
			if(tabCnt == 0 || tabCnt == 2){
				ComClearObject(formObj.in_rhq);
			}else if(tabCnt == 1 || tabCnt == 3 || tabCnt == 5 || tabCnt == 6){
//				comboObjects[0].Code2 = "^";
				rhq.SetSelectCode("%");
			} 
		}
	}
    	
        /** 
         * Handling key press event
         */ 
//        function obj_keypress(){
//         	obj = event.srcElement;
//         	if(obj.dataformat == null) return;
//         	 	
//         	window.defaultStatus = obj.dataformat;
//         	 
//         	switch(obj.dataformat) {
//         	    case "engup":
//         	        //if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum');
//         	        ComKeyOnlyAlphabet('upper');
//         	        break;
//         	    case "engdn":
//         	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
//         	        else ComKeyOnlyAlphabet('lower');
//         	        break;
//                case "ymd":
//                	ComKeyOnlyNumber(event.srcElement);
//                    break;
//         	}
//        } 
        
        /** 
         * Handling key up event
         */ 
//        function obj_keyup(){
//         	obj = event.srcElement;
//         	if(obj.dataformat == null) return;
//         	 	
//         	window.defaultStatus = obj.dataformat;
//         	 
//         	switch(obj.dataformat) {
//         	    case "engup":
//         	        if(document.form.loc_cd.value.length == 5 ){
//         	        	loc_cd_onchange();
//         	        }
//         	        break;
//         	    case "engdn":
//         	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
//         	        else ComKeyOnlyAlphabet('lower');
//         	        break;
//         	}
//        }         
