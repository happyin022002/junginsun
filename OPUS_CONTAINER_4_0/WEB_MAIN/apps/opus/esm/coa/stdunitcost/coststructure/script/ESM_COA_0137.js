/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_COA_0137.js
*@FileTitle  : Node/Link U/C Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
 // Grobla Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
	var comboCnt=0;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /*
     * Event handler processing by button name
     */
    	function processButtonClick(){
    		var sheetObject=sheetObjects[2];
    		var formObject=document.form;
    		try {
    			var srcName=ComGetEvent("name");
    			 if(ComGetBtnDisable(srcName)) return false;
    			switch(srcName) {
    				case "btng_rowadd":
    					doActionIBSheet(sheetObject,formObject,IBINSERT);
    					break;	
    				case "btng_rowdel":
    					doActionIBSheet(sheetObject,formObject,IBDELETE);
    					break;							
    				case "btn_reset":
    					doActionIBSheet(sheetObject,formObject,IBRESET);
                        loadPage();			
    					break;						    
    				case "btn_retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				case "btn_save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;					
        			case "btn_downexcel":
        				if(sheetObject.RowCount() < 1){//no data
        					ComShowCodeMessage("COM132501");
        				}else{
        					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        				}        				
        				break;		
        			case "btn_loadexcel":
        				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
        				break;	 
        			case "btn_creation":
        				var f_cost_type = formObject.f_table_name.value;
        				if(f_cost_type=="COA_LNK_AVG_STND_COST"){
        					f_cost_type = "trans_full";
        				}else{
        					f_cost_type = "nod_full";
        				}
        				var strUrl="ESM_COA_4011.do" + "?f_cost_yrmon="+"&f_cost_type="+f_cost_type;
    					ComOpenPopup(strUrl, '380', '260', '', '0,0', true);
        				break
    			} // end switch
    		}catch(e) {
    			if( e == "[object Error]") {
    				ComShowCodeMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e.message);
    			}
    		}
    	}
    	/**
		* initializing sheet
		* implementing onLoad event handler in body tag
		* adding first-served functions after loading screen.
    	 */
    	function loadPage() {
    		
    		for(i=0;i<sheetObjects.length;i++){
    			//Sheet configuration setting function(start)
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//Sheet configuration setting function(end)
    			if(i+1!=2)
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    		tableColumnLoad();
    		
    		sheetObjects[1].SetSelectRow(2);			//SJH.20141223.ADD : 드래그 맨위..
    	}
    	
    	function changeTableName(){
			sheetObjects[2] = sheetObjects[2].Reset();
			ComConfigSheet(sheetObjects[2]);
			initSheet(sheetObjects[2],3);
			ComEndConfigSheet(sheetObjects[2]);
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    		tableColumnLoad();	
    	}
    	/**
		* setting sheet initial values and header
		* param : sheetObj, sheetNo
		* adding case as numbers of counting sheets
    	 */
    	function initSheet(sheetObj,sheetNo) {
    		var cnt=0;
    		var f_table_name=document.form.f_table_name.value;		
    		switch(sheetNo) {
    		case 1:		//sheet1 init
    		    with(sheetObj){
    			      var HeadTitle="Condition|Condition|Condition|Condition" ;
    			      var HeadTitle2="|Column Name|Sign|Value" ;					//SJH.20150106.MOD

    			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

    			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    			      var headers = [ { Text:HeadTitle, Align:"Center"},
    			                  { Text:HeadTitle2, Align:"Center"} ];
    			      InitHeaders(headers, info);

    			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",      KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"colname",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inequality",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"value",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 ,InputCaseSensitive:1} ];
    			       
    			      InitColumns(cols);
    			      SetSheetHeight(250);
    			      SetEditable(1);//Editkind[optional,Defaultfalse]
    			      SetColProperty("inequality", {ComboText:combo01Text, ComboCode:combo01Code} );
    			      SetColProperty(0 ,"value", {AcceptKeys:"" ,InputCaseSensitive:1});
    			      SetCountPosition(0);
    			}
    			break;
    		case 2:		//sheet2 init
    			with (sheetObj) {
    		    if (location.hostname != "")
    		    	   //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    		    	   var HeadTitle="Usage Help|Usage Help|Usage Help|Usage Help|Usage Help" ;
    		    	   var HeadTitle2="Desciption|Desciption|Example|Example|Example" ;

    		    	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    		    	   var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
    		    	   var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
    		    	   InitHeaders(headers, info);
    		    	   var cols = [ {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"kind",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		    	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"desciption",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		    	             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"colName",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inEquality",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    		    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"value",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    		    	    
    		    	   InitColumns(cols);
    		    	   
    		    	   SetRangeBackColor(0, 0, 1, 4,"#555555");
    		    	   //sheetObj.SetRangeFontColor(0, 0, 1, 4,"#0064FF");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","=, >, >=, <, <=, <>");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","Data serarch with given condition");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","COST_YRMON");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","=");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","'200701'");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","LIKE");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","Data search including given characters");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","COST_YRMON");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","LIKE");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","'2007%'");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","NOT LIKE");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","Data search not including given characters");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","COST_YRMON");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","NOT LIKE");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","'2007%'");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","IN");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","Data search with designated words");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","COST_YRMON");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","IN");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","('200701', '200702')");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","FULL_MTY_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","F : Full, M : Empty");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","FULL_MTY_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","=");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","'M'");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","CNTR_TPSZ_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","Container type size");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","CNTR_TPSZ_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","=");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","'D2'");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","COST_LOC_GRP_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","N : Node, C : Location, E : ECC, R : RCC");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","COST_LOC_GRP_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","=");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","'R'");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","NOD_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","Yard code");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","NOD_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","=");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","'USRGB'");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   sheetObj.DataInsert(-1);
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "kind","COA_COST_SRC_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "desciption","COA cost source code");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "colName","COA_COST_SRC_CD");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "inEquality","=");
    		    	   sheetObj.SetCellValue(sheetObj.LastRow(), "value","'TMNDMT'");
    		    	   sheetObj.SetRangeFontColor(sheetObj.LastRow(), 4, sheetObj.LastRow(), 4,"#FF0000");
    		    	   SetSheetHeight(250);
    		    	   SetEditable(1);//Editkind[optional,Defaultfalse]
    		    	   SetCountPosition(0);
    		    	   
    		}
    			break;								
    		case 3:		//sheet3 init
    		    with(sheetObj){
	    			var cols = new Array();
	    			if(f_table_name=="COA_NOD_AVG_STND_COST"){
	    				  MergeSheet = msNone;
	    				
	    			      var HeadTitle="DEL|STS|Year/Month|F/M|Type Size|Loc. Group|Node|Trade|Act. Group|H_Cost|Cost Source|STND Cost|Curr.|USD AMT|Fixed|QTY|AMT|Cost Volume Code" ;
	
	    			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle, Align:"Center"}];
	    			      InitHeaders(headers, info);
	    			      cols = [ {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dtDelCheck",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			             {Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	    			             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon",         KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	    			             {Type:"Combo",     Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	    			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cost_loc_grp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	    			             //SJH.20150106.MOD : 대문자..
	    			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"nod_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, AcceptKeys:"E|N" , InputCaseSensitive:1 },
	    			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_act_grp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	    			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"stnd_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"coa_cost_src_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             //SJH.20150106.MOD : HIDDEN
	    			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"coa_cost_src_cd_v",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"locl_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			             {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"stnd_cost_usd_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
	    			             //SJH.20141126.MOD : YN
	    			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cost_fx_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1,   TrueValue:"Y",   FalseValue:"N" },
	    			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"nod_ttl_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
	    			             {Type:"Float",     Hidden:0,  Width:110,   Align:"Right",   ColMerge:0,   SaveName:"nod_ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_vol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
    			 
	    			      SetColProperty("full_mty_cd", {ComboText:"F|M", ComboCode:"F|M"} );
	    			      SetColProperty(0 ,"cost_vol_cd", {AcceptKeys:"E|N" ,InputCaseSensitive:1});	    			      
	    			} else {
	    			      MergeSheet=msNone;                                             //Merge kind [optional, Default msNone]
	    			      
	    			      //InitRowInfo( 1, 1, 9, 100);                                      //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			                                    //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			      //InitHeadMode(true, true, true, true, true,true);                 //setting function handling header
	    			      var HeadTitle="DEL|STS|Year/Month|Loc. Group|Link From|Link To|Type Size|F/M|Cost|Cost Source|STND Cost|Curr.|USD AMT|Fixed|QTY|AMT|Cost Volume Code|Link U/C AMT" ;
	    			      //InitHeadRow(0, HeadTitle, true);                                 //Header Title Information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	
	    			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, MergeSheet:0, Page:20, DataRowMerge:1 } );
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle, Align:"Center"}];
	    			      InitHeaders(headers, info);
	    			      cols = [];
	    			      cols.push({Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dtDelCheck",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	    			      cols.push({Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" });
	    			      cols.push({Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cost_yrmon",         KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	    			      //SJH.20150106.MOD : 위치변경
	    			      cols.push({Type:"Combo",     Hidden:0, Width:90,  Align:"Center",  ColMerge:0,   SaveName:"cost_loc_grp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 });
	    			      cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lnk_fm_nod_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, AcceptKeys:"E|N" , InputCaseSensitive:1 });
	    			      cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lnk_to_nod_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, AcceptKeys:"E|N" , InputCaseSensitive:1 });
	    			      //PCM.20150119.MOD: DELETE CO_CD
//	    			      cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"co_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 });
	    			      cols.push({Type:"Combo",     Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 });
	    			      cols.push({Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1, ComboText:"F|M", ComboCode:"F|M" });
	    			      cols.push({Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"stnd_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	    			      cols.push({Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"coa_cost_src_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	    			      //SJH.20150106.MOD : HIDDEN
	    			      cols.push({Type:"Combo",     Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"coa_cost_src_cd_v",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	    			      cols.push({Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"locl_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
	    			      cols.push({Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"stnd_cost_usd_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
	    			      //SJH.20150205.MOD
	    			      cols.push({Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cost_fx_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1,   TrueValue:"Y",   FalseValue:"N" });
	    			      cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"lnk_ttl_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 });
	    			      cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"lnk_ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 });
	    			      cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cost_vol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, AcceptKeys:"E|N" , InputCaseSensitive:1 });
	    			      cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"mty_uc_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 });
	    			  }
	    			  InitComboNoMatchText(1,"",1);
    			      InitColumns(cols);
//    			      SetSheetHeight(250);
    				  resizeSheet();
    			      SetColProperty("full_mty_cd", {ComboText:"F|M", ComboCode:"F|M"} );
    			      SetColProperty(0 ,"cost_vol_cd", {AcceptKeys:"E|N" ,InputCaseSensitive:1});
	            	}
    			break;	
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
	
	function sheet3_OnChange(sheetObj, row, col, value){
          if(sheetObj.ColSaveName(col) == "nod_ttl_qty" || sheetObj.ColSaveName(col) == "nod_ttl_amt" ){
        	  sheetObj.SetCellValue(row,"stnd_cost_usd_amt");
        	  sheetObj.GetCellValue(row, "nod_ttl_amt")/sheetObj.GetCellValue(row, "nod_ttl_qty") ;
          }
          if(sheetObj.ColSaveName(col) == "lnk_ttl_qty" || sheetObj.ColSaveName(col) == "lnk_ttl_amt" ){
			sheetObj.SetCellValue(row,"stnd_cost_usd_amt");
			sheetObj.GetCellValue(row, "lnk_ttl_amt")/sheetObj.GetCellValue(row, "lnk_ttl_qty") ;
          } 
          if(sheetObj.ColSaveName(col) == "coa_cost_src_cd"){
        	  sheetObj.SetCellValue(row,"coa_cost_src_cd_v",sheetObj.GetCellValue(row, "coa_cost_src_cd"));
        	  sheetObj.SetCellValue(row,"stnd_cost_cd",sheetObj.GetCellText(row, "coa_cost_src_cd_v"),0);
          }     
          if(sheetObj.ColSaveName(col) == "cost_loc_grp_cd"){
        	  sheetObj.SetCellValue(row,"nod_cd","",0);
        	  sheetObj.SetCellValue(row,"lnk_fm_nod_cd","",0);
        	  sheetObj.SetCellValue(row,"lnk_to_nod_cd","",0);
          }    
          if(sheetObj.ColSaveName(col) == "nod_cd" || sheetObj.ColSaveName(col) == "lnk_fm_nod_cd" || sheetObj.ColSaveName(col) == "lnk_to_nod_cd"){
        	  if(sheetObj.GetCellValue(row, "cost_loc_grp_cd") == ""){
        		  ComShowMessage(ComGetMsg("COA10026","Loc.Group first",""));
        		  sheetObj.SetCellValue(row, col,"",0);
	              sheetObj.SelectCell(row, "cost_loc_grp_cd");
        	  }
          }
          if(sheetObj.ColSaveName(col) == "nod_cd"){
			if(sheetObj.GetCellValue(row,"nod_cd") != ""){
			if(sheetObj.GetCellValue(row, "cost_loc_grp_cd") != "N"){
        			  var param="f_cmd="+SEARCH06;
					  param=param + "&f_loc_cd="+value;
					  var sXml=sheetObj.GetSearchData("ESM_COA_0137GS.do", param);
					  var arrXml=sXml.split("|$$|");
					  isValidNode(row,ComCoaGetEtcData(arrXml[0], "rtnValue"),0);
        		  }else{
        			  var param="f_cmd="+SEARCH05;
					  param=param + "&f_tml_cd="+value;
					  var sXml=sheetObj.GetSearchData("ESM_COA_0137GS.do", param);
					  var arrXml=sXml.split("|$$|");
					  isValidNode(row,ComCoaGetEtcData(arrXml[0], "rtnValue"),0);
        		  }
            }
          }
          if(sheetObj.ColSaveName(col) == "lnk_fm_nod_cd"){
        	  if(sheetObj.GetCellValue(row,"lnk_fm_nod_cd") != ""){
        		  if(sheetObj.GetCellValue(row, "cost_loc_grp_cd") != "N"){
	           	 	var param="f_cmd="+SEARCH06;
	         		param=param + "&f_loc_cd="+value;
	         		var sXml=sheetObj.GetSearchData("ESM_COA_0137GS.do", param);
					var arrXml=sXml.split("|$$|");
					isValidNode(row,ComCoaGetEtcData(arrXml[0], "rtnValue"),1);
        		  }else{
	           	 	var param="f_cmd="+SEARCH05;
	         		param=param + "&f_tml_cd="+value;
	         		var sXml=sheetObj.GetSearchData("ESM_COA_0137GS.do", param);
					var arrXml=sXml.split("|$$|");
					isValidNode(row,ComCoaGetEtcData(arrXml[0], "rtnValue"),1);
        		  }
            }
          }
          if(sheetObj.ColSaveName(col) == "lnk_to_nod_cd"){
        	  if(sheetObj.GetCellValue(row,"lnk_to_nod_cd") != ""){
        		  if(sheetObj.GetCellValue(row, "cost_loc_grp_cd") != "N"){
        			  var param="f_cmd="+SEARCH06;
	         		  param=param + "&f_loc_cd="+value;
	         		  var sXml=sheetObj.GetSearchData("ESM_COA_0137GS.do", param);
					  var arrXml=sXml.split("|$$|");
					  isValidNode(row,ComCoaGetEtcData(arrXml[0], "rtnValue"),2);
        		  }else{
        			  var param="f_cmd="+SEARCH05;
	         		  param=param + "&f_tml_cd="+value;
	         		  var sXml=sheetObj.GetSearchData("ESM_COA_0137GS.do", param);
					  var arrXml=sXml.split("|$$|");
					  isValidNode(row,ComCoaGetEtcData(arrXml[0], "rtnValue"),2);
        		  }
            }
          }
      }
    	// Table 蹂?꼍 ddlb Change Event
      function tableColumnLoad(){
    		var sheetObject=sheetObjects[0];
    		var formObject=document.form;
    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    		
      }	
      function keyEnter_rslt(){
      	var sheetObject=sheetObjects[2];
      	var formObject=document.form;
      	if (event.keyCode == 13) {
     			doActionIBSheet(sheetObject,formObject,IBSEARCH);
      	}
      } 
    	// Handling process about the sheet object
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg(false);
    		switch(sAction) {
    			case IBCLEAR:          //Inquiry
			        sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=INIT;
					var sXml=sheetObj.GetSearchData("ESM_COA_0137GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0){
						ComCoaSetIBCombo(sheetObjects[2], arrXml[0], "coa_cost_src_cd", true, 0, 0,"", "", true);
					}
					if (arrXml.length > 1){
						ComCoaSetIBCombo(sheetObjects[2], arrXml[1], "coa_cost_src_cd_v", true, 0);
					}
					if (arrXml.length > 2){
						ComCoaSetIBCombo(sheetObjects[2], arrXml[2], "locl_curr_cd", true, 0);
					}
					if (arrXml.length > 3){
						ComCoaSetIBCombo(sheetObjects[2], arrXml[3], "cost_loc_grp_cd", true, 0);
					}
					if (arrXml.length > 4){
						setIBCombo(sheetObjects[2], arrXml[4], "cntr_tpsz_cd", true, 0);
					}
//					setIBCombo(sheetObjects[2], )
					ComOpenWait(false);
					break	
    			case IBINSERT:                  // Insert
       				var sRow=sheetObj.DataInsert(-1);
       				if(formObj.f_table_name.selectedIndex == 0) {
	       				sheetObj.SetCellValue(sRow, "full_mty_cd", "F", 0);
	       				sheetObj.SetCellValue(sRow, "trd_cd","NNN",0);
	       				sheetObj.SetCellValue(sRow, "cost_act_grp_cd","NNNN",0);
       				}
       				break;	
    			case IBDELETE:                  // Insert
    				if(sheetObj.CheckedRows("dtDelCheck") > 0){
    					var iCheckRow=sheetObj.FindCheckedRow("dtDelCheck");
    					var arrRow=iCheckRow.split("|");
    					for (idx=0; idx<arrRow.length-1; idx++){
    						  sheetObj.RowDelete(arrRow[idx], false);
    					}
    				}else{
    					alert("There's no selected row(s).");
    				}
       				break;	   								
    			case IBRESET:                  // RESET
    				if (sheetObj.IsDataModified()&& ComShowCodeConfirm("COM130504")) {
    	   				//validation check
    	   				if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
    	   					return false;
    	   				}
    				}
                    //sheetObj.reset();
                    sheetObj.RemoveAll();
    				break;		    
    			case IBSEARCH:		           //Inquiry
    				if (sheetObj != sheetObjects[0]) {
	    				if (sheetObj.IsDataModified()&& ComShowCodeConfirm("COM130504")) {
	    	   				//validation check
	    	   				if(!doActionIBSheet(sheetObj,formObj,IBSAVE)) { 
	    	   					return false;
	    	   				}
	    				}
    				}
    			    if(sheetObj==sheetObjects[0]){              // terms window 
    			    	if(formObj.f_table_name.selectedIndex == 0) {
    			    		formObj.f_cmd.value=SEARCH01;	
    			    	} else {
    			    		formObj.f_cmd.value=SEARCH02;	
    			    	}
    			    	sheetObj.DoSearch("ESM_COA_0137GS.do", FormQueryString(formObj) );
    			    }
    			    else if(sheetObj==sheetObjects[2]){        // Search results window 
    			    	// Prohibit button click when a business transaction is processing 
    			    	if(!validateForm(sheetObjects[0], IBSEARCH)) return;		//20150603.MOD    
    					sheetObj.SetWaitImageVisible(0);							//20150603.MOD
    					ComOpenWait(true);
    			    	if(formObj.f_table_name.selectedIndex == 0) {
    			    		formObj.f_cmd.value=SEARCH03;	
    			    	} else {
    			    		formObj.f_cmd.value=SEARCH04;	
    			    	}
                        var params=sheetObjects[0].GetSaveString(false ,false);
                        sheetObj.DoSearch("ESM_COA_0137GS.do", params+"&"+FormQueryString(formObj) );
                        ComOpenWait(false);
    			    }
    				break;	
    			case IBSAVE:                  // save
    				// Prohibit button click when a business transaction is processing 
    				if(!validateForm(sheetObj, IBSAVE)) return;
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
        			formObj.f_cmd.value=MULTI;
        			sheetObj.DoSave("ESM_COA_0137GS.do", FormQueryString(formObj), -1, true);
        			ComOpenWait(false);
    				break;					
               case IBDOWNEXCEL:            // Excell download
    				var excelType=selectDownExcelMethod(sheetObj,2);    				
    				break;	
    				
    			case IBLOADEXCEL:                  // excell loading
            		//20150716.MOD/ADD/DEL
            		sheetObj.SetWaitImageVisible(0);
    	        	sheetObj.RemoveAll();
    	        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
    				break;											
    		}
    	}

    	function callBackExcelMethod(excelType) {	
    	    var sheetObj = sheetObjects[excelType[1]];
    	    switch (excelType[0]) {
	            case "AY":
	                sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
	                break;
	            case "AN":
			    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			    	break;
	            case "DY":
	            	sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
	            	break;
	            case "DN":
			    	sheetObj.Down2Excel({HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
			    	break;
    		}            
    	}


    	
      /**
      	* Handling process for form object input validation
      */
      function validateForm(sheetObj, sAction) {
    	  switch(sAction){
    	  case IBSEARCH :
    	      	with(sheetObj){
	        		if( sheetObj.FindText("value", "\'", 1, 2) == -1){
	        			ComShowCodeMessage('COA10002','condition');
	        			return false;
	        		}
	        	}  
    	       break;
    	  case IBSAVE : 
	      		var f_table_name=document.form.f_table_name.value;
	  	      	with(sheetObj){
		  	      	if(f_table_name=="COA_NOD_AVG_STND_COST" && sheetObj.ColValueDup("cost_yrmon|full_mty_cd|cntr_tpsz_cd|cost_loc_grp_cd|nod_cd|trd_cd|cost_act_grp_cd|coa_cost_src_cd") != -1){
		      			ComShowCodeMessage('COM131301','');
		      			return false;
		      		}else if(f_table_name=="COA_LNK_AVG_STND_COST" && sheetObj.ColValueDup("cost_yrmon|lnk_fm_nod_cd|lnk_to_nod_cd|cntr_tpsz_cd|full_mty_cd|coa_cost_src_cd|cost_loc_grp_cd") != -1){
		      			ComShowCodeMessage('COM131301','');
		      			return false;
		      		}
		      	}  
    		  break;
    	  }    
      	return true;
      }     
      function setIBCombo(sheetObj, sXml, title, iBlank, sCol,iRow, dCode, dText, bFlag){
          var showCol=0;
          if (ComGetTotalRows(sXml) == "0") return;
          if (bFlag == undefined || bFlag == ""){
              bFlag=false;
          }
          if (sCol != undefined && sCol !=""){
              showCol=sCol;
          }
          if (iBlank == undefined || iBlank == ""){
              iBlank=false;
          }
          if (iRow == undefined || iRow == ""){
          	iRow=0;
          }
          var arrData=ComXml2ComboString(sXml, "code", "name");
          if (bFlag == true && arrData != null){
              var arrCode=arrData[0].split("|");
              var arrName=arrData[1].split("|");
              var conData="";
              for(i=0; i < arrName.length;i++){
                  if(i==0){
                      arrName[i]=arrCode[i]+"\t"+arrName[i];
                  }else{
                      arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
                  }
                  conData=conData.concat(arrName[i]);
              }
              arrData[1]=conData;
          }
          if(iBlank){
              arrData[0]=" |" + arrData[0] + "|20|40|BOX";
              arrData[1]=" |" + arrData[1] + "|20|40|BOX";
          }
          if (arrData != null){
          	if (iRow == 0){
          		//sheetObj.SetColProperty(title, {ComboText:arrData[1] ,arrData[0], ComboCode:dText,dCode} );
          		sheetObj.SetColProperty(title, {ComboText:arrData[1] ,ComboCode:arrData[0]} );
          	}else{
          		sheetObj.CellComboItem(iRow,title, {ComboText:arrData[1], ComboCode:arrData[0]} );
          	}
          }
      }
      function isValidNode(sRow,result,target){
          var sheetObj=sheetObjects[2];
          if(result == "false"){        	  
        	  if(target == "0"){
	              ComShowMessage(ComGetMsg("COM12114","Node",""));
	              sheetObj.SetCellValue(sRow, "nod_cd","",0);
	              sheetObj.SelectCell(sRow, "nod_cd");
        	  }else if(target == "1"){
	              ComShowMessage(ComGetMsg("COM12114","From Node",""));
	              sheetObj.SetCellValue(sRow, "lnk_fm_nod_cd","",0);
	              sheetObj.SelectCell(sRow, "lnk_fm_nod_cd");
        	  }else if(target == "2"){
	              ComShowMessage(ComGetMsg("COM12114","To Node",""));
	              sheetObj.SetCellValue(sRow, "lnk_to_nod_cd","",0);
	              sheetObj.SelectCell(sRow, "lnk_to_nod_cd");
        	  }
          }
      }
      
      function sheet1_OnKeyDown(sheeObj, Row, Col, KeyCode, Shift) {
    	  if (KeyCode == 13) {
    		  doActionIBSheet(sheet3,document.form,IBSEARCH);
    	  }
      }

      function resizeSheet(){
     	 ComResizeSheet(sheetObjects[2]);
      }
      
      //SJH.20150106.ADD : 저장후 메시지 추가
      function sheet3_OnSaveEnd(sheetObj, ErrMsg) {
          if(ErrMsg == ""){
              // [COM130102] : Success
        	  ComShowMessage(ComGetMsg("COM130102","Data"));
          }else{
              ComShowMessage(ComGetMsg("COM132101"));
          }	
          doActionIBSheet(sheetObj,document.form,IBSEARCH);
      } 
      
      //SJH.20150507.ADD : LOADEXCEL OPTION
      function sheet3_OnLoadExcel(sheetObj, result, code, msg) {
    	  ComOpenWait(false);									//20150716.MOD
    	  if(isExceedMaxRow(msg)) return;
      }    
      
      //20150716.ADD
      function sheet3_OnLoadFileSelect(sheetObj){
          ComOpenWait(true);
      }  