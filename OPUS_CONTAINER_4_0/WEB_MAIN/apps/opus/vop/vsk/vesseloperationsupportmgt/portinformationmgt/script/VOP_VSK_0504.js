/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0504.js
*@FileTitle  : Port Information Creation 
*@author     : CLT
*@version    : 1.0
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
     * @class vop_vsk_0504 : business script for vop_vsk_0504
     */
    function vop_vsk_0504() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.setComboObject=setComboObject;
    }
    
    // public variable 
    var set_day=30;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;     
    var t5sheet1Flg=true;
    var t3Dfs="";
    var tabNowCnt=0;
	var fastFlg=false;
	var rhqChangeFlg=true;
    // Event handler processing by button click event */
    document.onclick = processButtonClick;
    // Event handler processing by button name */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		var sheetObject5=sheetObjects[4]; 
		var sheetObject6=sheetObjects[5];
		var sheetObject7=sheetObjects[6];
		var sheetObject8=sheetObjects[7];         
		var sheetObject9=sheetObjects[8];
		var sheetObject10=sheetObjects[9];
        /*******************************************************/
        var formObject = document.form;
		var objs = document.all.item("tabLayer");
    	try {
			var srcName=ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_Calendar":
					if( objs[1].style.display == "inline" ){
						var cal=new ComCalendar();
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
				case "btn_Save":
					if( objs[0].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBSAVE,false);
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBSAVE,false);
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBSAVE,false);
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBSAVE,false);
					}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject5,formObject,IBSAVE,false);
 					    doActionIBSheet(sheetObject5,formObject,IBSEARCH,true);   //tab5
					}else if( objs[5].style.display == "inline" ){
						doActionIBSheet(sheetObject7,formObject,IBSAVE,false);
					}else if( objs[6].style.display == "inline" ){
						doActionIBSheet(sheetObject8,formObject,IBSAVE,false);    							
					}else{
						doActionIBSheet(sheetObject1,formObject,IBSAVE,false);
					}
					break;
				case "btn_loc_cd":	//Location popup
					if(formObject.btn_loc_cd.className == ""){
						break;
					}
					var cnt_cd="";
					var loc_cd=formObject.loc_cd.value;
			    	var sUrl="/opuscntr/VOP_VSK_0043.do";
					ComOpenPopup(sUrl, 422, 520, "getRtnVal", "0,0", true);
								
					break; 	
					
					/**		TAB 1		**/
				case "btn_t1add":
					if(validateForm(sheetObject1,formObject,IBSEARCH))
					{
						if(sheetObject1.GetComboInfo(0,"t1sheet1_yd_cd", "Text") == ""){
							ComShowCodeMessage("VSK50011");
							ComAlertFocus(formObject.loc_cd, "");
							return ;							
						}
						var inx= sheetObject1.DataInsert(-1);
						sheetObject1.SelectCell(inx, "t1sheet1_yd_cd", true);
						fastFlg=true;
					}	
					break;
				case "btn_t1insert":
					if(validateForm(sheetObject1,formObject,IBSEARCH))
					{
						if(sheetObject1.GetComboInfo(0,"t1sheet1_yd_cd", "Text") == ""){
							ComShowCodeMessage("VSK50011");
							ComAlertFocus(formObject.loc_cd, "");
							return ;							
						}						
						var inx=sheetObject1.DataInsert();
						sheetObject1.SelectCell(inx, "t1sheet1_yd_cd", true);
						fastFlg=true;
					}
					break;
				case "btn_t1del":
					ComRowHideDelete(sheetObject1,"t1sheet1_del_chk");
					break;
				case "btn_t1downexcel":
					if(sheetObject1.RowCount() < 1){//no data
					     ComShowCodeMessage("COM132501");
					    } else{
					    	//sheetObject1.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
					    	sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					    }
					break;		
					
					/**		TAB 2		**/
				case "btn_t2add":
					var inx=sheetObject2.DataInsert(-1);
					sheetObject2.SelectCell(inx, "t2sheet1_loc_cd", true);
					break;
				case "btn_t2insert":
					var inx=sheetObject2.DataInsert();
					sheetObject2.SelectCell(inx, "t2sheet1_loc_cd", true);
					break;
				case "btn_t2del":
					ComRowHideDelete(sheetObject2,"t2sheet1_del_chk");
					break;
				case "btn_t2downexcel":
					if(sheetObject2.RowCount() < 1){//no data
					     ComShowCodeMessage("COM132501");
					    } else{
					    	//sheetObject2.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
					    	sheetObject2.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject2),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					    }
					break; 
					
					/**		TAB 3		**/
				case "btn_t3add":
					if(validateForm(sheetObject3,formObject,IBSEARCH))
					{
						var inx=sheetObject3.DataInsert(-1);
						fastFlg=false;
						sheetObject3.SetCellValue(inx, "t3sheet1_fm_loc_cd",formObject.loc_cd.value);
						fastFlg=false;
						sheetObject3.SetCellValue(inx, "t3sheet1_temp_to_loc_cd",sheetObject3.GetCellValue(inx, "t3sheet1_to_loc_cd"));
		            	sheetObject3.SelectCell(inx, "t3sheet1_to_loc_cd", true);
		            	fastFlg=true;
					}
					break;
				case "btn_t3insert":
					if(validateForm(sheetObject3,formObject,IBSEARCH))
					{
						var inx=sheetObject3.DataInsert();
						fastFlg=false;
						sheetObject3.SetCellValue(inx, "t3sheet1_fm_loc_cd",formObject.loc_cd.value);
						fastFlg=false;
						sheetObject3.SetCellValue(inx, "t3sheet1_temp_to_loc_cd",sheetObject3.GetCellValue(inx, "t3sheet1_to_loc_cd"));
		            	sheetObject3.SelectCell(inx, "t3sheet1_to_loc_cd", true);
		            	fastFlg=true;
					}	
					break;
				case "btn_t3del":
					ComRowHideDelete(sheetObject3,"t3sheet1_del_chk");
					break;
				case "btn_t3downexcel":
					if(sheetObject3.RowCount() < 1){//no data
					     ComShowCodeMessage("COM132501");
					    } else{
					    	//sheetObject3.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
					    	sheetObject3.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject3),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					    }
					break;
					
					/**		TAB 4		**/
				case "btn_t4add":
					var inx=sheetObject4.DataInsert(-1);
					sheetObject4.SetCellValue(inx, "t4sheet1_temp_loc_cd",sheetObject4.GetCellValue(inx, "t4sheet1_loc_cd"));
					sheetObject4.SelectCell(inx, "t4sheet1_loc_cd", true);
					break;
				case "btn_t4insert":
					var inx=sheetObject4.DataInsert();
					sheetObject4.SetCellValue(inx, "t4sheet1_temp_loc_cd",sheetObject4.GetCellValue(inx, "t4sheet1_loc_cd"));
					sheetObject4.SelectCell(inx, "t4sheet1_loc_cd", true);
					sheetObject4.SelectCell(inx, 2, true);
					break;
				case "btn_t4del":
					ComRowHideDelete(sheetObject4,"t4sheet1_del_chk");
					break;
				case "btn_t4downexcel":
					if(sheetObject4.RowCount() < 1){//no data
					     ComShowCodeMessage("COM132501");
					    } else{
					    	//sheetObject4.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
					    	sheetObject4.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject4),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					    }
					break;
					
					/**		TAB 5		**/
				case "btn_t5add": 
					if(validateForm(sheetObject5,formObject,IBSEARCH))
					{	
						var inx=sheetObject5.DataInsert(-1);
						sheetObject5.SetCellValue(inx, "t5sheet1_loc_cd",formObject.loc_cd.value);
						sheetObject5.SelectCell(inx, "t5sheet1_loc_cd", true);
					}
					break;
				case "btn_t5insert":
					if(validateForm(sheetObject5,formObject,IBSEARCH))
					{
						var inx=sheetObject5.DataInsert();
						sheetObject5.SetCellValue(inx, "t5sheet1_loc_cd",formObject.loc_cd.value);
						sheetObject5.SelectCell(inx, "t5sheet1_loc_cd", true);
					}	
					break;
				case "btn_t5del":
					ComRowHideDelete(sheetObject5,"t5sheet1_del_chk");
					break; 
				case "btn_t5downexcel":
					if(sheetObject5.RowCount() < 1){//no data
					     ComShowCodeMessage("COM132501");
					    } else{
					    	//이후로는 버퍼링한다. 아무 동작 안함.
					    	sheetObject5.Down2ExcelBuffer(true);  
					    	// 첫번째 워크시트에 담아두기를 예약함.
					    	//sheetObject5.Down2Excel({HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1,SheetName:'Canal_sheet1'});
					    	sheetObject5.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject5),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1,SheetName:'Canal_sheet1' });
					    	// 두번째 워크시트에 담아두기를 예약함.
					    	//sheetObject6.Down2Excel({HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1,SheetName:'Canal_sheet2'}); 
					    	sheetObject6.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject6),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1,SheetName:'Canal_sheet2' });
					    	// 버퍼링된 모든 엑셀 자료를 1개의 엑셀문서에 모두 모아서 즉시 다운로드 한다.
					    	sheetObject5.Down2ExcelBuffer(false); 
					    }
				
					break;	       
				case "btn_t5tierScg" : 
					var url = '/opuscntr/VOP_VSK_0704.do';
					ComOpenPopup(url, 500, 480, "returnTierScg", '0,0', true);
					break;
					
					/**		TAB 6		**/
				case "btn_t6add":
					var inx=sheetObject7.DataInsert(-1);
					fastFlg=false;
					sheetObject7.SetCellValue(inx, "t6sheet1_trsp_mod_cd",formObject.trsp_mod_cd.value);
					fastFlg=false;
					sheetObject7.SetCellValue(inx, "t6sheet1_temp_loc_cd",sheetObject7.GetCellValue(inx, "t6sheet1_loc_cd"));
					sheetObject7.SelectCell(inx, "t6sheet1_loc_cd", true);
					fastFlg=true;
					break;
				case "btn_t6insert":
					var inx=sheetObject7.DataInsert();
					fastFlg=false;
					sheetObject7.SetCellValue(inx, "t6sheet1_trsp_mod_cd",formObject.trsp_mod_cd.value);
					fastFlg=false;
					sheetObject7.SetCellValue(inx, "t6sheet1_temp_loc_cd",sheetObject7.GetCellValue(inx, "t6sheet1_loc_cd"));
					sheetObject7.SelectCell(inx, "t6sheet1_loc_cd", true);
					fastFlg=true;
					break;
				case "btn_t6del":
					ComRowHideDelete(sheetObject7,"t6sheet1_del_chk");
					break;
				case "btn_t6downexcel":
					if(sheetObject7.RowCount() < 1){//no data
					     ComShowCodeMessage("COM132501");
					    } else{
					    	//sheetObject7.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
					    	sheetObject7.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject7),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					    }
					break;
					
					/**		TAB 7		**/
				case "btn_t7add":
					var inx=sheetObject8.DataInsert(-1);
					fastFlg=false;
					sheetObject8.SetCellValue(inx, "t7sheet1_trsp_mod_cd",formObject.trsp_mod_cd.value);
					fastFlg=false;
					sheetObject8.SetCellValue(inx, "t7sheet1_temp_loc_cd",sheetObject8.GetCellValue(inx, "t7sheet1_loc_cd"));
					sheetObject8.SelectCell(inx, "t7sheet1_loc_cd", true);
					fastFlg=true;
					break;
				case "btn_t7insert":
					var inx=sheetObject8.DataInsert();
					fastFlg=false;
					sheetObject8.SetCellValue(inx, "t7sheet1_trsp_mod_cd",formObject.trsp_mod_cd.value);
					fastFlg=false;
					sheetObject8.SetCellValue(inx, "t7sheet1_temp_loc_cd",sheetObject8.GetCellValue(inx, "t7sheet1_loc_cd"));
					sheetObject8.SelectCell(inx, "t7sheet1_loc_cd", true);
					fastFlg=true;
					break;
				case "btn_t7del":
					ComRowHideDelete(sheetObject8,"t7sheet1_del_chk");
				break;
				case "btn_t7downexcel":
					if(sheetObject8.RowCount() < 1){//no data
					     ComShowCodeMessage("COM132501");
					    } else{
					    	//sheetObject8.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
					    	sheetObject8.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject8),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					    }
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
		sheetObjects[sheetCnt++]=sheet_obj;
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
        
 	 	//IBMultiCombo initialize
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }
 	    
 	    //resizeSheet();
 	    
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
					comboObj.SetBackColor("#CCFFFD");
					InsertItem(i++,  "ALL",  "^");
					comboObj.SetSelectCode("^");
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
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "t1sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel.|TMNL Code|TMNL Name|Alongside|Depth (M)|Depth (M)|Draft (M)|Draft (M)|Air Draft (M)|Length of Turning\nBasin (M)|Berth\nLength|Pilot Maneuvering In/Out|Pilot Maneuvering In/Out|Remark(s)|||";
	              var HeadTitle2="|Sel.|TMNL Code|TMNL Name|Alongside|Channel|Berth|Anytime|Max|Air Draft (M)|Length of Turning\nBasin (M)|Berth\nLength|Distance (NM)|Time (Hr)|Remark(s)";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t1sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                     {Type:"ComboEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, InputCaseSensitive:1, AcceptKeys:"E|N"},
	                     {Type:"Text",      Hidden:0,  Width:230,   Align:"Left",    ColMerge:1,   SaveName:prefix+"yd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"alsd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"chnl_dpth",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"brth_dpth",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"at_drft_dpth",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"max_drft_dpth",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ad_len",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"turn_bsn_len",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"brth_len",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"plt_mnvr_dist",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"plt_mnvr_tm_hrs", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnvr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetSheetHeight(410);
	              InitComboNoMatchText(1,"",1);
                  SetColProperty(prefix+"alsd_cd", {ComboText:"|Mostly Starboard|Starboard Only|PORT Only|Mostly Port|BOTH", ComboCode:"|MS|OS|OP|MP|BO"} );
              }
            break;
            
            case "t2sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel.|Seq.|Port|Hol Seq.|Start Date|End Date|Holiday Description|Remark(s)||";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t2sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                     {Type:"ComboEdit", Hidden:0, Width:130,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E|N"},
	                     {Type:"Text",      Hidden:1, Width:160,  Align:"Left",    ColMerge:1,   SaveName:prefix+"hol_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"PopupEdit", Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hol_st_dt",  KeyField:1,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1},
	                     {Type:"PopupEdit", Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hol_end_dt", KeyField:1,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1},
	                     {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:prefix+"hol_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                     {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:0,   SaveName:prefix+"hol_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetSheetHeight(410);
	              InitComboNoMatchText(1,"",1);
	              SetShowButtonImage(2);
	            }
                break;
                
            case "t3sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel.|Seq.||To Port|Time Diff.(Hrs)|Distance |Distance |Shortest Distance|Shortest Distance|||";
	              var HeadTitle2="|Sel.|Seq.||To Port|Time Diff.(Hrs)|Distance|Description|Distance|Description";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t3sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"fm_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"ComboEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"to_loc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E|N"},
	                     {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",  ColMerge:1,   SaveName:prefix+"gmt_td_hrs",     KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:prefix+"stnd_dist",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"stnd_dist_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                     {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:prefix+"shrt_dist",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"shrt_dist_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_to_loc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetSheetHeight(410);
	              InitComboNoMatchText(1,"",1);
	              SetEditable(1);
                  }
                break;
                
            case "t4sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel.|Port|Document Hour|Dead Hour|Dead Hour Description|Remark(s)|||";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t4sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                     {Type:"ComboEdit", Hidden:0, Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 , InputCaseSensitive:1, AcceptKeys:"E|N"},
	                     {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",  ColMerge:0,   SaveName:prefix+"doc_hrs",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",  ColMerge:0,   SaveName:prefix+"dead_hrs",     KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dead_hr_desc", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:prefix+"doc_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
		              InitColumns(cols);
		              SetSheetHeight(410);
		              InitComboNoMatchText(1,"",1);
		              SetEditable(1);
		              
	              }
			break;
			
            case "t5sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel.|Port|Bound|Convoy or\nGroup|Limit Time without Surcharge|Limit Time with Surcharge|Limit Time with Surcharge|Limit Time with Surcharge|Remark(s)|||";
	              var HeadTitle2="|Sel.|Port|Bound|Convoy or\nGroup|Limit Time without Surcharge|L/Time|L/Time|Surcharge %|Remark(s)|||";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t5sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",    ColMerge:1,   SaveName:prefix+"svc_scp_bnd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0, Width:130,   Align:"Center",    ColMerge:1,   SaveName:prefix+"cnl_tz_seq_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"scg_expt_lmt_hrmnt", KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scg_fm_lmt_hrmnt",   KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scg_to_lmt_hrmnt",   KeyField:1,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",  ColMerge:1,   SaveName:prefix+"lmt_tm_scg_rto",     KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cnl_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetSheetHeight(320);
	              SetEditable(1);
	              SetUseDefaultTime(0);
	              SetColProperty(prefix+"svc_scp_bnd_cd", {ComboText:"|North|South", ComboCode:"|N|S"} );
	              SetColProperty(prefix+"cnl_tz_seq_cd", {ComboText:"|First|Second", ComboCode:"|1|2"} );
	              InitComboNoMatchText(1,"",1);
	              }
            break;
                
            case "t5sheet2":
                with(sheetObj){
		             var HeadTitle1="|Port / Tier|1 Tier|2 Tier|3 Tier|4 Tier|5Tier|6 Tier|7 Tier|8 Tier|9 Tier";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             var prefix="t5sheet2_";
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:125,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no1", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no2", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no3", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no4", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no5", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no6", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no7", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no8", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                 {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:prefix+"vsl_tr_no9", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
		             InitColumns(cols);
		             SetSheetHeight(100);
		             SetWaitImageVisible(0);
		             SetEditable(1);
                }
			break;
			
            case "t6sheet1":
                with(sheetObj){
	              var HeadTitle1="|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|";
	              HeadTitle1 += "Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|||";
	              var HeadTitle2="|Sel.|Port|Weight for 20 ft\n(Kgs)|Weight for 40 ft\n(Kgs)|Weight per Axial\n(Kgs)|Max \nLength(M)|Max \nWidth(M)|Max \nHeight(M)|Over \nLength(Cm)|Over \nWidth(Cm)|Over \nHeight(Cm)||Remark(s)";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t6sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                     {Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E|N"},
	                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_20ft_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_40ft_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_axl_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_len",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_wdt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_hgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_len",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_wdt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_hgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"trsp_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetSheetHeight(410);
	              SetEditable(1);
	              InitComboNoMatchText(1,"",1);
             }
            break;
            
            case "t7sheet1":
                with(sheetObj){
	              var HeadTitle1="|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|";
	              HeadTitle1 += "Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|Max Permissible Cargo Weight / Size for Rail|";
	              var HeadTitle2="|Sel.|Port|Weight for 20 ft\n(Kgs)|Weight for 40 ft\n(Kgs)|Max \nLength(M)|Max \nWidth(M)|Max \nHeight(M)|Over \nLength(Cm)|Over \nWidth(Cm)|Over \nHeight(Cm)|||Remark(s)";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t7sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                     {Type:"ComboEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E|N"},
	                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_20ft_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_40ft_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_len",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_wdt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_hgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_len",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_wdt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Float",     Hidden:0,  Width:130,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_ovr_hgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Text",      Hidden:1, Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"lmt_axl_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"trsp_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"temp_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetSheetHeight(410);
	              SetEditable(1);
	              InitComboNoMatchText(1,"",1);
	             }
            break;
            
            case "t10sheet1":    				
                with (sheetObj) {
                	SetWaitImageVisible(0);
                }
            break;
                
            case "t5sheet3":
                with(sheetObj){
	              var HeadTitle1="|loc_cd|tr_seq|tr_scg_rto";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t5sheet3_";
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:99,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tr_seq",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:99,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tr_scg_rto", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetWaitImageVisible(0);
	              SetEditable(1);
             }
          break;                    
        }
    }
    		// handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction, sQuest) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case SEARCH01:
				formObj.f_cmd.value=SEARCH01;
				var sParam=FormQueryString(formObj)
				var sXml=sheetObj.GetSearchData("VOP_VSK_0221GS.do", sParam);
				var rhqlist=ComGetEtcData(sXml, "rhqlist");
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
						if ( sheetObj.id == "t1sheet1") {	
							formObj.f_cmd.value=SEARCH;
							var arr=new Array("t1sheet1_", "");
							var sXml=sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
							var arrXml=sXml.split("|$$|");
							for(var i=0; i<arrXml.length; i++){
								ComSetColProperty(sheetObj , 2 , {Type:"Text"});
								// sheetObj.InitDataProperty(0, 2, dtData,80,	daCenter,true,"t1sheet1_yd_cd",	false,"",dfNone,	0,false,true);
								if( i == 0 )
								{	
									sheetObj.LoadSearchData(arrXml[i],{Sync:1} );
								}
								// sheetObj.InitDataProperty(0, 2, dtComboEdit,80,daCenter,true,"t1sheet1_yd_cd",false,"",dfNone,0,false,true,7);
								var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
								if(arrCombo != null){
									var vInitDataComboName="";
									var arrVal=arrCombo[0].split("|");
									var arrName=arrCombo[1].split("|");
									for(var j=0; j<arrVal.length ; j++)
									{
										if(j == 0)
									    	vInitDataComboName=vInitDataComboName + arrVal[j] +"\t"+ arrName[j];
										else
											vInitDataComboName=vInitDataComboName + "|"+arrVal[j] +"\t"+ arrName[j];
									}
									sheetObj.SetColProperty("t1sheet1_yd_cd", {ComboText:"|"+vInitDataComboName, ComboCode:"|"+arrCombo[0]} );
								}
							}
							} else if (sheetObj.id == "t2sheet1")
							{	
								formObj.f_cmd.value=SEARCH01;
								var arr=new Array("t2sheet1_", "");
								var sXml=sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
								var arrXml=sXml.split("|$$|");
								for(var i=0; i<arrXml.length; i++){ 
									var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
									if(arrCombo != null){
										sheetObj.SetColProperty("t2sheet1_loc_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
									} 
									if( i==0 ){
										sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
									}
								}    										
							} else if ( sheetObj.id == "t3sheet1")
							{
								formObj.f_cmd.value=SEARCH02;
								var arr=new Array("t3sheet1_", "");
								var sXml=sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
								var arrXml=sXml.split("|$$|");
								for(var i=0; i<arrXml.length; i++){ 
									//sheetObj.InitDataProperty(0, 4, dtData,	120,daCenter,true,"t3sheet1_to_loc_cd",	false,"",dfNone,0,false,true);
									if(i == 0)
									{	
										sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
									}
									//sheetObj.InitDataProperty(0, 4, dtComboEdit,120,daCenter,true,"t3sheet1_to_loc_cd",	false,"",dfNone,0,false,true, 5);
									sheetObj.SetColProperty("t3sheet1_to_loc_cd", {ComboText:"", ComboCode:""} );
									var arrCombo=ComVskXml2ComboString(arrXml[1], "val", "name", "df");
									if(arrCombo != null){
										sheetObj.SetColProperty("t3sheet1_to_loc_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
										t3Dfs=arrCombo[2];
									}    							
								} 
							} else if ( sheetObj.id == "t4sheet1")
							{
								formObj.f_cmd.value=SEARCH03;
								var arr=new Array("t4sheet1_", "");
								var sXml=sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
								var arrXml=sXml.split("|$$|");
								for(var i=0; i<arrXml.length; i++){ 
									// sheetObj.InitDataProperty(0,2,dtData,100,daCenter,true,	"t4sheet1_loc_cd",false,"",dfNone,0,false,true);
									if(i == 0){
										sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
									}
									// sheetObj.InitDataProperty(0, 2, dtComboEdit,100,daCenter,	true,"t4sheet1_loc_cd", false,"", dfNone,	0,false,true, 5);
									sheetObj.SetColProperty("t4sheet1_loc_cd", {ComboText:"", ComboCode:""} );
									var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
									if(arrCombo != null){
										sheetObj.SetColProperty("t4sheet1_loc_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
									}    								} 
							} else if ( sheetObj.id == "t5sheet1")
							{
								formObj.f_cmd.value=SEARCH04;
								var arr=new Array("t5sheet1_", "t5sheet2_", "t5sheet3_");
								var sXml=sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
								var arrXml=sXml.split("|$$|");
								sheetObjects[4].LoadSearchData(arrXml[0],{Sync:1} );
								sheetObjects[5].LoadSearchData(arrXml[1],{Sync:1} );
								sheetObjects[9].LoadSearchData(arrXml[2],{Sync:1} );
								if(sheetObjects[5].RowCount()> 0){
									ComBtnDisable("btn_t5tierScg");
								}else{
									ComBtnEnable("btn_t5tierScg");
								}
							} else if ( sheetObj.id == "t6sheet1")
							{
								formObj.f_cmd.value=SEARCH05;
								var arr=new Array("t6sheet1_", "");
								var sXml=sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
								var arrXml=sXml.split("|$$|");
								for(var i=0; i<arrXml.length; i++){ 
									// sheetObj.InitDataProperty(0, 2, dtData,80,daCenter,	true,"t6sheet1_loc_cd",	false,"",dfNone,0,false,true);
									if(i == 0)
									{
										sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
									}
									// sheetObj.InitDataProperty(0, 2, dtComboEdit,80,daCenter,true,"t6sheet1_loc_cd",	false,"",dfNone,0,false,true,5);
									sheetObj.SetColProperty("t6sheet1_loc_cd", {ComboText:"", ComboCode:""} );
									var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
									if(arrCombo != null){
										sheetObj.SetColProperty("t6sheet1_loc_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
									}    											
								}
							} else if ( sheetObj.id == "t7sheet1")
							{
								formObj.f_cmd.value=SEARCH06;
								var arr=new Array("t7sheet1_", "");
								var sXml=sheetObj.GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
								var arrXml=sXml.split("|$$|");
								for(var i=0; i<arrXml.length; i++){ 
									// sheetObj.InitDataProperty(0, 2, dtData,	80,daCenter,true,"t7sheet1_loc_cd",	false,"",dfNone,0,false,true);
									if(i == 0)
									{
										sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
									}
									// sheetObj.InitDataProperty(0, 2, dtComboEdit,80,	daCenter,true,"t7sheet1_loc_cd",false,"",dfNone,0,false,true, 5);
									sheetObj.SetColProperty("t7sheet1_loc_cd", {ComboText:"", ComboCode:""} );
									var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
									if(arrCombo != null){
										sheetObj.SetColProperty("t7sheet1_loc_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
									}    											
								} 
							} 
					break;
				case IBSAVE:			//Save
					if(validateForm(sheetObj,formObj,sAction))
						if ( sheetObj.id == "t1sheet1")
						{
							var idxNul=sheetObj.FindText("t1sheet1_yd_cd", " ");
							if(idxNul > 1){
								ComShowCodeMessage("VSK50010",idxNul-1, "TMNL Code");
							    sheetObj.SelectCell(idxNul, "t1sheet1_yd_cd", true);
							    return ;
							}
			            	var idxDub=sheetObj.ColValueDup("t1sheet1_yd_cd");
			            	if(idxDub > -1){
			            		ComShowCodeMessage("VSK50303","Port", idxDub-1);
			            		sheetObj.SelectCell(idxDub, "t1sheet1_yd_cd", true);
			            		return ;
			            	}
			                if (formObj.mnvr_rmk.value.length > 1000){
	                             ComShowCodeMessage( "VSK01019", "[Remark(s)]" );
	                             formObj.mnvr_rmk.focus();
	                             return false ;
	                        }
			                formObj.f_cmd.value=MULTI;
							sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_"), -1, sQuest);
						} else if (sheetObj.id == "t2sheet1")
						{
							var idxNul=sheetObj.FindText("t2sheet1_loc_cd", " ");
							if(idxNul > 1){
								ComShowCodeMessage("VSK50010",idxNul, "Port");
							    sheetObj.SelectCell(idxNul, "t2sheet1_loc_cd", true);
							    return ;
							}
							formObj.f_cmd.value=MULTI01;
							sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_"), -1, sQuest);
						} else if (sheetObj.id == "t3sheet1")
						{
							var idxNul=sheetObj.FindText("t3sheet1_to_loc_cd", " ");
							if(idxNul > 1){
								ComShowCodeMessage("VSK50010",idxNul-1, "TMNL Code");
							    sheetObj.SelectCell(idxNul, "t3sheet1_to_loc_cd", true);
							    return ;
							}
			            	var idxDub=sheetObj.ColValueDup("t3sheet1_to_loc_cd");
			            	if(idxDub > -1){
			            		ComShowCodeMessage("VSK50303","Port", idxDub-1);
			            		sheetObj.SelectCell(idxDub, "t3sheet1_to_loc_cd", true);
			            		return ;
			            	}										
							formObj.f_cmd.value=MULTI02;
							sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_"), -1, sQuest);
						} else if (sheetObj.id == "t4sheet1")
						{
							var idxNul=sheetObj.FindText("t4sheet1_loc_cd", " ");
							if(idxNul > 1){
								ComShowCodeMessage("VSK50010",idxNul, "Port");
							    sheetObj.SelectCell(idxNul, "t4sheet1_loc_cd", true);
							    return ;
							}
							// Port duplicate check									
				   			var idxDub=sheetObj.ColValueDup("t4sheet1_loc_cd");
				   			if(idxDub > -1){
				   				ComShowCodeMessage("VSK50303","Port", idxDub);
				   				sheetObj.SelectCell(idxDub, "t4sheet1_loc_cd", true);
				   				return ;
				   			}
							formObj.f_cmd.value=MULTI03;
							sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t4sheet1_"), -1, sQuest);
						} else if (sheetObj.id == "t5sheet1")
						{
							formObj.f_cmd.value=MULTI04;
							var sParam=ComGetSaveString(sheetObjects, true, true);
							if( sParam == ""){ return;}
							var rtnData = sheetObj.GetSaveData("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + sParam, true);
							sheetObj.LoadSaveData(rtnData);
						} else if (sheetObj.id == "t6sheet1")
						{
							//mandatory check
							var idxNul=sheetObj.FindText("t6sheet1_loc_cd", " ");
							if(idxNul > 1){
								ComShowCodeMessage("VSK50010",(idxNul-1), "Port");
							    sheetObj.SelectCell(idxNul, "t6sheet1_loc_cd", true);
							    return ;
							}
							// Port duplicate check								
			    			var idxDub=sheetObj.ColValueDup("t6sheet1_loc_cd");
			    			if(idxDub > -1){
			        			var idxDub2=idxDub-1;
			    				ComShowCodeMessage("VSK50303","Port", idxDub2);
			    				sheetObj.SelectCell(idxDub, "t6sheet1_loc_cd", true);
			    				return ;
			    			}	
							formObj.f_cmd.value=MULTI05;
							sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t6sheet1_"), -1, sQuest);
						} else if (sheetObj.id == "t7sheet1")
						{
							var idxNul=sheetObj.FindText("t7sheet1_loc_cd", " ");
							if(idxNul > 1){
								ComShowCodeMessage("VSK50010",(idxNul-1), "Port");
							    sheetObj.SelectCell(idxNul, "t7sheet1_loc_cd", true);
							    return ;
							}

							var idxDub=sheetObj.ColValueDup("t7sheet1_loc_cd");
			    			if(idxDub > -1){
			    				var idxDub2=idxDub-1;
			    				ComShowCodeMessage("VSK50303","Port", idxDub2);
			    				sheetObj.SelectCell(idxDub, "t7sheet1_loc_cd", true);
			    				return ;
			    			}
							formObj.f_cmd.value=MULTI06;
							sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t7sheet1_"), -1, sQuest);
						}	
					break; 
				case IBCLEAR:
						var statsCnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");    						
						if ( sheetObj.id == "t1sheet1")
						{
							if(statsCnt > 0 )
							{
								if(ComShowCodeConfirm("VSK50012")){
									formObj.loc_cd.value="";
									formObj.in_rhq.value="";
									formObj.upd_dt.value="";
									formObj.upd_usr_id.value="";            		
									sheetObj.RemoveAll();
									document.form.mnvr_rmk.value="";
								}
							}else{
									formObj.loc_cd.value="";
									formObj.in_rhq.value="";
									formObj.upd_dt.value="";
									formObj.upd_usr_id.value="";            		
									sheetObj.RemoveAll();
									document.form.mnvr_rmk.value="";
							}
						} else if (sheetObj.id == "t2sheet1")
						{
							if(statsCnt > 0 )
							{
								if(ComShowCodeConfirm("VSK50012")){
				            		formObj.loc_cd.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
								}
							} else{
				            		formObj.loc_cd.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
							}
						}else if (sheetObj.id == "t3sheet1")
						{
							if(statsCnt > 0 )
							{
								if(ComShowCodeConfirm("VSK50012")){
    								formObj.loc_cd.value="";
    								formObj.in_rhq.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
								}
							} else {
    								formObj.loc_cd.value="";
    								formObj.in_rhq.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
							}	
						} else if (sheetObj.id == "t4sheet1")
						{
							if(statsCnt > 0 )
							{
								if(ComShowCodeConfirm("VSK50012")){
    								formObj.loc_cd.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
								}
							} else {	
    								formObj.loc_cd.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
							}
						} else if (sheetObj.id == "t5sheet1")
						{
							if(statsCnt > 0 )
							{
								if(ComShowCodeConfirm("VSK50012")){
    								formObj.in_rhq.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
				            		sheetObjects[5].RemoveAll();
								}
							} else {
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
				            		sheetObjects[5].RemoveAll();
							} 
							ComBtnDisable("btn_t5tierScg");
						} else if (sheetObj.id == "t6sheet1")
						{
							if(statsCnt > 0 )
							{
								if(ComShowCodeConfirm("VSK50012")){
    								formObj.loc_cd.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";
				            		sheetObj.RemoveAll();
				            		document.form.trsp_rmk_td.value="";
								}
							} else {	
    								formObj.loc_cd.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";
				            		sheetObj.RemoveAll();
				            		document.form.trsp_rmk_td.value="";
							}	
						} else if (sheetObj.id == "t7sheet1")
						{
							if(statsCnt > 0 )
							{
								if(ComShowCodeConfirm("VSK50012")){
    								formObj.loc_cd.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
				            		document.form.trsp_rmk_rd.value="";
								}
							}else{	
    								formObj.loc_cd.value="";
				            		formObj.upd_dt.value="";
				            		formObj.upd_usr_id.value="";            		
				            		sheetObj.RemoveAll();
				            		document.form.trsp_rmk_rd.value="";
							}
						}
						formObj.cel_year.value=formObj.nowYear.value;
					break;
        }
    }
        function initControl() {
        	//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        	//axon_event.addListenerFormat('keyup', 'obj_keyup', form);
        	axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd', ''); 
        	axon_event.addListener('change', 'loc_cd_onchangeMax5', 'loc_cd', '');            //loc_cd change Event
        	axon_event.addListener('mousedown', 'obj_mousedown',  "btn_New");   
        	axon_event.addListener('blur', 'mnvr_rmk_onchange', 'mnvr_rmk', form);      //mnvr_rmk change Event
        	axon_event.addListener('blur', 'trsp_rmk_td_onchange', 'trsp_rmk_td', '');  //trsp_rmk_td change Event      	
        	axon_event.addListener('blur', 'trsp_rmk_rd_onchange', 'trsp_rmk_rd', '');  //trsp_rmk_rd change Event
        	//axon_event.addListener('keydown', 'obj_KeyEnter', 'form');
        	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        }
        /*function obj_KeyEnter(){
            var formObject=document.form;
    		var objs=document.all.item("tabLayer");
    		var sheetObject1=sheetObjects[0];
    		var sheetObject2=sheetObjects[1];
    		var sheetObject3=sheetObjects[2];
    		var sheetObject4=sheetObjects[3];
    		var sheetObject5=sheetObjects[4]; 
    		var sheetObject6=sheetObjects[5];
    		var sheetObject7=sheetObjects[6];
    		var sheetObject8=sheetObjects[7];   
    		if( event.keyCode == 13 && formObject.loc_cd.value.length == 5 ){
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
				}
        	}
        }*/
        /**
         * Event when clicking Tab
     * activating selected tab items
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++]=tab_obj;
        }
    	function setComboObject(combo_obj){
    		comboObjects[comboCnt++]=combo_obj;
    	}
        /**
         * initializing Tab
         * setting Tab items
         */
        function initTab(tabObj , tabNo) {
             switch(tabNo) {
                 case 1:
                    with (tabObj) {
                        var cnt=0 ;
						InsertItem( "Maneuvering" , "");
						InsertItem( "Terminal Non-Working" , "");
						InsertItem( "Distance" , "");
						InsertItem( "Doc.&Dead Hrs" , "");
						InsertItem( "Canal" , "");
						InsertItem( "Trucking" , "");
						InsertItem( "Railroad" , "");
                    }
                 break;
             }
            tabObj.SetSelectedIndex(0);
        }
        /**
         * Handling tab click event
         * before click, Checking Save or not for changed data
         */
        function sheet_Cud_Click(tabObj)
        {
            var formObject=document.form;
        	if(tabNowCnt > 0){
        		if( tabNowCnt < 6 ){
        			var beforCnt=tabNowCnt-1; // sheet6, sheet7 are 1 bigger than sheetObjects[]
        		}else{
        			var beforCnt=tabNowCnt;
        		}
        		var statsCnt = sheetObjects[beforCnt].RowCount("I") + sheetObjects[beforCnt].RowCount("U") + sheetObjects[beforCnt].RowCount("D");
        		if(statsCnt > 0){
        			if(ComShowCodeConfirm("VSK50009", tabObj.GetTabTitle(tabNowCnt-1))){
        				doActionIBSheet(sheetObjects[beforCnt],formObject,IBSAVE, false);
        			}else{
        				sheetObjects[beforCnt].RemoveAll();
        				//Canal Dtail Sheet Initializing
        				if(beforCnt == 0){
        					document.form.mnvr_rmk.value="";
        				}else if(beforCnt == 4){
        					sheetObjects[beforCnt+1].RemoveAll();
        				}else if(beforCnt == 5){
        					document.form.trsp_rmk_td.value="";
        				}else if(beforCnt == 6){
        					document.form.trsp_rmk_rd.value="";
        				}
        			}
        		}	
        	}	
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
        	 for(var i = 0; i< objs.length; i++){
	        	  if(i != nItem){
		        	   objs[i].style.display="none";
		        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	        	  }
        	}
        	beforetab=nItem;
            switch(nItem) {
            	case 0:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value="";
            		formObject.loc_cd.className="input1";
            		formObject.loc_cd.readOnly=false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display="none";
        			document.all.item("inputRhq").style.display="inline";
        			formObject.in_rhq.value="";
            		formObject.upd_dt.value="";
            		formObject.upd_usr_id.value="";
            		formObject.cel_year.value=formObject.nowYear.value;
            		formObject.cel_year.className="input2";
            		formObject.cel_year.readOnly=true;
            		ComEnableObject(document.all.btn_Calendar, false);            		
            		tabNowCnt=1;
            		break;
            	case 1:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value="";
            		formObject.loc_cd.className="input";
            		formObject.loc_cd.readOnly=false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display="inline";
        			document.all.item("inputRhq").style.display="none";
            		formObject.upd_dt.value="";
            		formObject.upd_usr_id.value="";
            		comboObjects[0].SetEnable(1);
            		formObject.cel_year.value=formObject.nowYear.value;
            		formObject.cel_year.className="input";
            		formObject.cel_year.readOnly=false;
            		ComEnableObject(document.all.btn_Calendar, true);            		
            		setPort_Grid_Combo(1);
            		tabNowCnt=2;
            		break;
            	case 2:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value="";
            		formObject.loc_cd.className="input1";
            		formObject.loc_cd.readOnly=false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display="none";
        			document.all.item("inputRhq").style.display="inline";
        			formObject.in_rhq.value="";
            		formObject.upd_dt.value="";
            		formObject.upd_usr_id.value="";     
            		formObject.cel_year.value=formObject.nowYear.value;
            		formObject.cel_year.className="input2";
            		formObject.cel_year.readOnly=true;
            		ComEnableObject(document.all.btn_Calendar, false);
            		tabNowCnt=3;            		
            		break;
            	case 3:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value="";
            		formObject.loc_cd.className="input";
            		formObject.loc_cd.readOnly=false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display="inline";
        			document.all.item("inputRhq").style.display="none";
            		formObject.upd_dt.value="";
            		formObject.upd_usr_id.value="";            		
            		comboObjects[0].SetEnable(1);
            		formObject.cel_year.value=formObject.nowYear.value;
            		formObject.cel_year.className="input2";
            		formObject.cel_year.readOnly=true;
            		ComEnableObject(document.all.btn_Calendar, false);
            		setPort_Doc_Combo(3);
            		tabNowCnt=4;
            		break;
            	case 4:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value="EGSCA";
            		formObject.loc_cd.className="input2";
            		formObject.loc_cd.readOnly=true;
            		initBtn_loc_cd(false);
            		formObject.btn_loc_cd.disabled=true;
        			document.all.item("comboRhq").style.display="none";
        			document.all.item("inputRhq").style.display="inline";
        			formObject.in_rhq.value="LONHQ";
            		formObject.upd_dt.value="";
            		formObject.upd_usr_id.value="";
            		formObject.cel_year.value=formObject.nowYear.value;
            		formObject.cel_year.className="input2";
            		formObject.cel_year.readOnly=true;
            		ComEnableObject(document.all.btn_Calendar, false);
            		tabNowCnt=5;
            		sheetObject5=sheetObjects[4];
            		doActionIBSheet(sheetObject5,formObject,IBSEARCH,true);
            		break;
            	case 5:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value="";
            		formObject.loc_cd.className="input";
            		formObject.loc_cd.readOnly=false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display="inline";
        			document.all.item("inputRhq").style.display="none";            		
            		formObject.upd_dt.value="";
            		formObject.upd_usr_id.value="";            		
            		comboObjects[0].SetEnable(1);
            		formObject.cel_year.value=formObject.nowYear.value;
            		formObject.cel_year.className="input2";
            		formObject.cel_year.readOnly=true;
            		ComEnableObject(document.all.btn_Calendar, false);
            		formObject.trsp_mod_cd.value="TD";
            		setPortTrsp_Grid_Combo(6);
            		tabNowCnt=6;
            		break;            		
            	case 6:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value="";
            		formObject.loc_cd.className="input";
            		formObject.loc_cd.readOnly=false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display="inline";
        			document.all.item("inputRhq").style.display="none";               		
            		formObject.upd_dt.value="";
            		formObject.upd_usr_id.value="";
            		comboObjects[0].SetEnable(1);
            		formObject.cel_year.value=formObject.nowYear.value;
            		formObject.cel_year.className="input2";
            		formObject.cel_year.readOnly=true;
            		formObject.trsp_mod_cd.value="RD";
            		ComEnableObject(document.all.btn_Calendar, false);
            		setPortTrsp_Grid_Combo(7);
            		tabNowCnt=7;
            		break;
            }
            
            //resizeSheet();
        }
        /**
         * Changing Port Code Retrieve popup button class style as clicked tab 
         * @return
         */
        function initBtn_loc_cd(Flag){
//        	if(Flag){
//        		document.all.btn_loc_cd.src='/opuscntr/img/btns_search.gif';	 
//        		document.all.btn_loc_cd.className='cursor';
//        	}else{
//        	    document.all.btn_loc_cd.src='/opuscntr/img/btns_search_off.gif';	 
//        	    document.all.btn_loc_cd.className='';
//        	}
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
            formObj.mnvr_rmk.value = VopAsciiRemove(formObj.mnvr_rmk.value);
            return true;
        }
        
        var checkyDcDFlg1=false;  //Tmml Code check flag
    	function t1sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 2){
    			if(!checkyDcDFlg1){
    				sheetObj.SelectCell(Row, "t1sheet1_yd_cd", true);
    			}
    		}
    	}
    	function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
			document.form.upd_dt.value=sheetObj.GetCellValue(NewRow, "t1sheet1_upd_dt");
			document.form.upd_usr_id.value=sheetObj.GetCellValue(NewRow, "t1sheet1_upd_usr_id");
			document.form.mnvr_rmk.value=sheetObj.GetCellValue(NewRow, "t1sheet1_mnvr_rmk");
    		if(OldCol == 2){
    			if(!checkyDcDFlg1){
    				sheetObj.SelectCell(NewRow, "t1sheet1_yd_cd", true);
    			}
    		}
    	}
    	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount()> 0){
				document.form.upd_dt.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_upd_dt");
				document.form.upd_usr_id.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_upd_usr_id");
				document.form.mnvr_rmk.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_mnvr_rmk");
    		}
    	}        
    	
    	function t1sheet1_OnChange(sheetObj, Row, Col, Value){
    		if(fastFlg){
    			if(Col == 2){
    				checkyDcDFlg1=false;
    				var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
    				var arrCode=sCode.split("|");
    				for(var i=0 ; i<arrCode.length ; i++){
    					if(arrCode[i] == Value ){
    						checkyDcDFlg1=true;
    					}
    				}
    				if(!checkyDcDFlg1){
					if(sheetObj.GetCellValue(Row, "t1sheet1_yd_cd") != "" ){
					if(sheetObj.GetCellValue(Row, "t1sheet1_yd_cd").length < 7){
    							ComShowCodeMessage("VSK50018");
					} else{
    							ComShowCodeMessage("VSK50020");
    						}
    					}
    					sheetObj.SetCellValue(Row, "t1sheet1_yd_cd","");
    					sheetObj.SelectCell(Row, "t1sheet1_yd_cd", true);
    				}
    				if(checkyDcDFlg1){
	    				var sText=sheetObj.GetComboInfo(Row, Col, "Text");
	    				var arrText=sText.split("|");
	    				var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	    				var vText=arrText[idx].split("\t");
	    				sheetObj.SetCellValue(Row, "t1sheet1_yd_nm",vText[1]);
	    				var idxDub=sheetObj.ColValueDup("t1sheet1_yd_cd");
	    				if(idxDub > -1){
	    					var idxDub2=idxDub-1;
	    					ComShowCodeMessage("VSK50303","Port", idxDub2);
	    				}else{
	    					sheetObj.SetCellValue(Row, "t1sheet1_temp_yd_cd",Value);
	    				}
    				}
    			}
    		}
    		if(Col >=5 && Col <=13) {
    			// data format check
    			checkNumberFormat(sheetObj, Row, Col, Value);
    		}
    	}    	
        var checklLocCdFlg2=false;  //Loc Code 2 check flag      
    	function t2sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 3){
    			if(!checklLocCdFlg2){
    				sheetObj.SelectCell(Row, "t2sheet1_loc_cd", true);
    			}
    		}
    	} 
    	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
			document.form.upd_dt.value=sheetObj.GetCellValue(NewRow, "t2sheet1_upd_dt");
			document.form.upd_usr_id.value=sheetObj.GetCellValue(NewRow, "t2sheet1_upd_usr_id");
    		if(OldCol == 3){
    			if(!checklLocCdFlg2){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}
    	}
    	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount()> 0){
				document.form.upd_dt.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t2sheet1_upd_dt");
				document.form.upd_usr_id.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t2sheet1_upd_usr_id");
    		}
    	}        
    	function t2sheet1_OnChange(sheetObj, Row, Col, Value){
			if(Col == 3){
				checklLocCdFlg2=false;
				var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
				var arrCode=sCode.split("|");
				for(var i=0 ; i<arrCode.length ; i++){
					if(arrCode[i] == Value ){
						checklLocCdFlg2=true;
					}
				}
				if(!checklLocCdFlg2){
					//Check length is 5 and Valid Port Code check 
					if(sheetObj.GetCellValue(Row, "t2sheet1_loc_cd") != "" ){
					if(sheetObj.GetCellValue(Row, "t2sheet1_loc_cd").length < 5){
							ComShowCodeMessage("VSK50014");
						}else{
							ComShowCodeMessage("VSK50015");
						}
					}					
					sheetObj.SetCellValue(Row, "t2sheet1_loc_cd","");
					sheetObj.SelectCell(Row, "t2sheet1_loc_cd", true);
				}
			}else if(Col==5){
				if(!ComIsDateTime(sheetObj.GetCellValue(Row, "t2sheet1_hol_st_dt"), "ymd", "hm") && sheetObj.GetCellValue(Row, "t2sheet1_hol_st_dt") != ""){
					ComShowCodeMessage("VSK50031", "YYYY-MM-DD hh:mm");
					sheetObj.SetCellValue(Row, "t2sheet1_hol_st_dt","");
					sheetObj.SelectCell(Row, "t2sheet1_hol_st_dt", true);
				}
			}else if(Col==6){
				if(!ComIsDateTime(sheetObj.GetCellValue(Row, "t2sheet1_hol_end_dt"), "ymd", "hm") && sheetObj.GetCellValue(Row, "t2sheet1_hol_end_dt") != ""){
					ComShowCodeMessage("VSK50031", "YYYY-MM-DD hh:mm");
					sheetObj.SetCellValue(Row, "t2sheet1_hol_end_dt","");
					sheetObj.SelectCell(Row, "t2sheet1_hol_end_dt", true);
				}
			}
    	} 
    	function t2sheet1_OnSaveEnd(sheetObj, ErrMsg){
    		var formObject=document.form;
    		if(sheetObj.RowCount()> 0){
    			doActionIBSheet(sheetObj,formObject,IBSEARCH,true);   //tab2
    		}
    	}     	   	
    	
    	var checklLocCdFlg3=false;  //Loc Code 3 check flag
    	function t3sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 4){
    			if(!checklLocCdFlg3){
    				sheetObj.SelectCell(Row, "t3sheet1_to_loc_cd", true);
    			}
    		}
    	}
    	function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
			document.form.upd_dt.value=sheetObj.GetCellValue(NewRow, "t3sheet1_upd_dt");
			document.form.upd_usr_id.value=sheetObj.GetCellValue(NewRow, "t3sheet1_upd_usr_id");
    		if(OldCol == 4){
    			if(!checklLocCdFlg3){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}
    	}
    	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount()> 0){
				document.form.upd_dt.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t3sheet1_upd_dt");
				document.form.upd_usr_id.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t3sheet1_upd_usr_id");
    		}
    	}    	
        function t3sheet1_OnChange(sheetObj, Row, Col, Value){
            if(fastFlg){
            	if (Col == 4)
            	{	
            		checklLocCdFlg3=false;
    				var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
    				var arrCode=sCode.split("|");
    				for(var i=0 ; i<arrCode.length ; i++){
    					if(arrCode[i] == Value ){
    						checklLocCdFlg3=true;
    					}
    				}
    				if(!checklLocCdFlg3){
						if(sheetObj.GetCellValue(Row, "t3sheet1_to_loc_cd") != "" ){
							if(sheetObj.GetCellValue(Row, "t3sheet1_to_loc_cd").length < 5){
    							ComShowCodeMessage("VSK50014");
    						}else{
    							var idxDub=sheetObj.ColValueDup("t3sheet1_to_loc_cd");
    		            		if(idxDub > -1){
    		            			ComShowCodeMessage("VSK50303","Port", idxDub-1);
    		            		}else{
    		            			ComShowCodeMessage("VSK50015");	
    		            		}
    							
    						}
    					}    					
    					sheetObj.SetCellValue(Row, "t3sheet1_to_loc_cd","",0);
    					sheetObj.SelectCell(Row, "t3sheet1_to_loc_cd", true);
    				}
    				if(checklLocCdFlg3){
	            		var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	            		if(idx > 0){
	            			var arrT3Dfs=t3Dfs.split("|");
	            			sheetObj.SetCellValue(Row, "t3sheet1_gmt_td_hrs",arrT3Dfs[idx-1],0);
	            		}else{
	            			sheetObj.SetCellValue(Row, "t3sheet1_gmt_td_hrs","",0);
	            		}
	            		var idxDub=sheetObj.ColValueDup("t3sheet1_to_loc_cd");
	            		if(idxDub > -1){
	            			ComShowCodeMessage("VSK50303","Port", idxDub-1);
	            		}else{
	       					sheetObj.SetCellValue(Row, "t3sheet1_temp_to_loc_cd",Value,0);
	            		}
    				}
            	}	
            }
    		if(Col==5||Col==6||Col==8) {
    			// data format check
    			checkNumberFormat(sheetObj, Row, Col, Value);
    		}
        }
        
        var checklLocCdFlg4=false;  //Loc Code 4 check flag
    	function t4sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 2){
    			if(!checklLocCdFlg4){
    				sheetObj.SelectCell(Row, "t4sheet1_loc_cd", true);
    			}
			}
    	} 
    	function t4sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
			document.form.upd_dt.value=sheetObj.GetCellValue(NewRow, "t4sheet1_upd_dt");
			document.form.upd_usr_id.value=sheetObj.GetCellValue(NewRow, "t4sheet1_upd_usr_id");
    		if(OldCol == 2){
    			if(!checklLocCdFlg4){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}
    	}
    	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount()> 0){
				document.form.upd_dt.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t4sheet1_upd_dt");
				document.form.upd_usr_id.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t4sheet1_upd_usr_id");
    		}
    	}    	
    	function t4sheet1_OnChange(sheetObj, Row, Col, Value){
    		if(Col == 2){
    			checklLocCdFlg4=false;
				var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
				var arrCode=sCode.split("|");
				for(var i=0 ; i<arrCode.length ; i++){
					if(arrCode[i] == Value ){
						checklLocCdFlg4=true;
					}
				}
				if(!checklLocCdFlg4){
					if(sheetObj.GetCellValue(Row, "t4sheet1_loc_cd") != "" ){
						if(sheetObj.GetCellValue(Row, "t4sheet1_loc_cd").length < 5){
							ComShowCodeMessage("VSK50014");
						}else{
							var idxDub=sheetObj.ColValueDup("t4sheet1_loc_cd");
			    			if(idxDub > -1){
			    				ComShowCodeMessage("VSK50303","Port", idxDub);
			    			}else{
			    				ComShowCodeMessage("VSK50015");	
			    			}
						}
					} 					
					sheetObj.SetCellValue(Row, "t4sheet1_loc_cd","");
					sheetObj.SelectCell(Row, "t4sheet1_loc_cd", true);
				}
				if(checklLocCdFlg4){
					var idxDub=sheetObj.ColValueDup("t4sheet1_loc_cd");
	    			if(idxDub > -1){
	    				ComShowCodeMessage("VSK50303","Port", idxDub);
	    			}else{
    					sheetObj.SetCellValue(Row, "t4sheet1_temp_loc_cd",Value);
	    			}
				}
    		} 
    		if(Col==3||Col==4) {
    			// data format check
    			checkNumberFormat(sheetObj, Row, Col, Value);
    		}
    	}
    	
    	function t5sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
			document.form.upd_dt.value=sheetObj.GetCellValue(NewRow, "t5sheet1_upd_dt");
			document.form.upd_usr_id.value=sheetObj.GetCellValue(NewRow, "t5sheet1_upd_usr_id");
    	}
    	function t5sheet1_OnChange(sheetObj, Row, Col, Value){
    		if(Col==8) {
    			// data format check
    			checkNumberFormat(sheetObj, Row, Col, Value);
    		}
    	} 
    	function t5sheet2_OnChange(sheetObj, Row, Col, Value){
    		sheetObjects[9].SetCellValue(Col-1, "t5sheet3_tr_scg_rto",Value);
    		if(Col>=2 && Col<=10) {
    			// data format check
    			checkNumberFormat(sheetObj, Row, Col, Value);
    		}
    	}    	
    	function t5sheet1_OnSaveEnd(sheetObj,ErrMsg){
    		var formObject=document.form;
    		doActionIBSheet(sheetObjects[4],formObject,IBSEARCH, true);   //tab5
    	}
        var checklLocCdFlg6=false;  //Loc Code 6 check flag
    	function t6sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 2){
    			if(!checklLocCdFlg6){
    				sheetObj.SelectCell(Row, "t6sheet1_loc_cd", true);
    			}
    		}
    	} 
        function t6sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
			document.form.upd_dt.value=sheetObj.GetCellValue(NewRow, "t6sheet1_upd_dt");
			document.form.upd_usr_id.value=sheetObj.GetCellValue(NewRow, "t6sheet1_upd_usr_id");
			document.form.trsp_rmk_td.value=sheetObj.GetCellValue(NewRow, "t6sheet1_trsp_rmk");
    		if(OldCol == 2){
    			if(!checklLocCdFlg6){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}
    	}
    	function t6sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount()> 0){
				document.form.upd_dt.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t6sheet1_upd_dt");
				document.form.upd_usr_id.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t6sheet1_upd_usr_id");
				document.form.trsp_rmk_td.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t6sheet1_trsp_rmk");
    		}
    	}   	
    	function t6sheet1_OnChange(sheetObj, Row, Col, Value){
    		if(fastFlg){
    			if(Col == 2){
    				checklLocCdFlg6=false;
    				//Valid TMML Code check
    				var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
    				var arrCode=sCode.split("|");
    				for(var i=0 ; i<arrCode.length ; i++){
    					if(arrCode[i] == Value ){
    						checklLocCdFlg6=true;
    					}
    				}
    				if(!checklLocCdFlg6){
						if(sheetObj.GetCellValue(Row, "t6sheet1_loc_cd") != "" ){
						if(sheetObj.GetCellValue(Row, "t6sheet1_loc_cd").length < 5){
    							ComShowCodeMessage("VSK50014");
    						}else{
    							ComShowCodeMessage("VSK50015");
    						}
    					}     					
    					sheetObj.SetCellValue(Row, "t6sheet1_loc_cd","");
    					sheetObj.SelectCell(Row, "t6sheet1_loc_cd", true);
    				}
    				if(checklLocCdFlg6){
		    			var idxDub=sheetObj.ColValueDup("t6sheet1_loc_cd");
		    			if(idxDub > -1){
		        			var idxDub2=idxDub-1;
		    				ComShowCodeMessage("VSK50303","Port", idxDub2);
		    			}else{
	    					sheetObj.SetCellValue(Row, "t6sheet1_temp_loc_cd",Value);
		    			}
    				}
    			}
    		}
    		if(Col>=3 && Col<=11) {
    			// data format check
    			checkNumberFormat(sheetObj, Row, Col, Value);
    		}
    	}
        var checklLocCdFlg7=false;  //Loc Code 7 check flag
    	function t7sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col==2){
    			if(!checklLocCdFlg7){
    				sheetObj.SelectCell(Row, "t7sheet1_loc_cd", true);
				}
    		}
    	} 
    	function t7sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
			document.form.upd_dt.value=sheetObj.GetCellValue(NewRow, "t7sheet1_upd_dt");
			document.form.upd_usr_id.value=sheetObj.GetCellValue(NewRow, "t7sheet1_upd_usr_id");
			document.form.trsp_rmk_rd.value=sheetObj.GetCellValue(NewRow, "t7sheet1_trsp_rmk");
    		if(OldCol == 2){
    			if(!checklLocCdFlg7){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}    		
    	}
    	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount()> 0){
				document.form.upd_dt.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t7sheet1_upd_dt");
				document.form.upd_usr_id.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t7sheet1_upd_usr_id");
				document.form.trsp_rmk_rd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t7sheet1_trsp_rmk");
    		}
    	}
    	function t7sheet1_OnChange(sheetObj, Row, Col, Value){
    		if(fastFlg){
    			if(Col == 2){
    				checklLocCdFlg7=false;
    				var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
    				var arrCode=sCode.split("|");
    				for(var i=0 ; i<arrCode.length ; i++){
    					if(arrCode[i] == Value ){
    						checklLocCdFlg7=true;
    					}
    				}
    				if(!checklLocCdFlg7){
						if(sheetObj.GetCellValue(Row, "t7sheet1_loc_cd") != "" ){
						if(sheetObj.GetCellValue(Row, "t7sheet1_loc_cd").length < 5){
    							ComShowCodeMessage("VSK50014");
    						}else{
    							ComShowCodeMessage("VSK50015");
    						}
    					}     					
    					sheetObj.SetCellValue(Row, "t7sheet1_loc_cd","");
    					sheetObj.SelectCell(Row, "t7sheet1_loc_cd", true);
    				}
    				if(checklLocCdFlg7){
		    			var idxDub=sheetObj.ColValueDup("t7sheet1_loc_cd");
		    			if(idxDub > -1){
		    				var idxDub2=idxDub-1;
		    				ComShowCodeMessage("VSK50303","Port", idxDub2);
		    			}else {
		    				sheetObj.SetCellValue(Row, "t7sheet1_temp_loc_cd",Value);
		    			}
    				}
    			}
    		}
    		if(Col >=3 && Col <=10) {
    			// data format check
    			checkNumberFormat(sheetObj, Row, Col, Value);
    		}
    	}
    	function t2sheet1_OnPopupClick(sheetObj, Row, Col)
    	{
    		with(sheetObj)
    		{
   			    var cal=new ComCalendarGrid();
    			if (sheetObj.ColSaveName(Col) == "t2sheet1_hol_st_dt") {
    			    cal.select(sheetObj, Row, Col, 'yyyyMMddHHmm');
    		    }else if (sheetObj.ColSaveName(Col) == "t2sheet1_hol_end_dt") {
       			    cal.select(sheetObj, Row, Col, 'yyyyMMddHHmm');
    		    }
    		}
    	}
    	
    	function loc_cd_onchangeMax5(){
    		var formObj=document.form;
    		if(formObj.loc_cd.value != ""){
    			if(formObj.loc_cd.value.length < 5 ){
    				ComShowCodeMessage("VSK50014");
    				ComAlertFocus(formObj.loc_cd, "");
    				return ;
    			}
    		}
    	}
    	var checkMouseFlg=false;
    	function obj_mousedown(){
    		var formObj=document.form;
    		doActionIBSheet(sheetObjects[beforetab],formObj,IBCLEAR,true);   //tab1
    	}
    	
    	function loc_cd_onchange(){
    		var formObj=document.form;
    		var objs=document.all.item("tabLayer");
			if( objs[0].style.display == "inline")
			{
	    		formObj.f_cmd.value=SEARCH07;
	    		var sXml=sheetObjects[8].GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj));
				var sVal=ComGetEtcData(sXml, "cmbVal");
				var sName=ComGetEtcData(sXml, "cmbName");
				if( sVal != "")
				{	
					//sheetObjects[0].InitDataProperty(0, 2 , dtComboEdit,	80,	 	daCenter,	true,	"t1sheet1_yd_cd",	true,		"",	dfNone,	0,	false,	true, 7);
					var vInitDataComboName="";
					var arrVal=sVal.split("|");
					var arrName=sName.split("|");
					for(var j=0; j<arrVal.length ; j++)
					{
						if(j == 0)
							vInitDataComboName=vInitDataComboName + arrVal[j] +"\t"+ arrName[j];
						else
							vInitDataComboName=vInitDataComboName + "|"+arrVal[j] +"\t"+ arrName[j];
					}
					sheetObjects[0].SetColProperty("t1sheet1_yd_cd", {ComboText:"|"+vInitDataComboName, ComboCode:"|"+sVal} );
				}
				else
				{
				}
				setRhq_Combo(0);  /* Getting RHQ Text*/
			} else if( objs[1].style.display == "inline")
			{
				setRhq_Combo(1);  /* Getting RHQ Combo */
			} else if( objs[2].style.display == "inline")
			{
				setRhq_Combo(2); /* Getting RHQ Text */
				formObj.f_cmd.value=SEARCH10;
				var sXml=sheetObjects[0].GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj));
				var sVal=ComGetEtcData(sXml, "cmbVal");
				var sName=ComGetEtcData(sXml, "cmbName");
				//Setting DF public variable
				t3Dfs=ComGetEtcData(sXml, "cmbDf");	
				if( sVal != "")
				{
					sheetObjects[2].SetColProperty("t3sheet1_to_loc_cd", {ComboText:"|"+sVal, ComboCode:"|"+sName} );
				}
			}else if( objs[3].style.display == "inline")
			{
				setRhq_Combo(3);   /* Getting RHQ combo */
				setPort_Doc_Combo(3);		
			}else if( objs[4].style.display == "inline")
			{
				setRhq_Combo(4); /* Getting RHQ Text */
			}else if( objs[5].style.display == "inline")
			{
				setRhq_Combo(5);   /* Getting RHQ combo */
			}else if( objs[6].style.display == "inline")
			{
				setRhq_Combo(6);  /* Getting RHQ combo */					
			}
    	}
    	function mnvr_rmk_onchange(){
    		if(document.form.mnvr_rmk.value.length > 1000 ){
               ComShowCodeMessage( 'VSK01019' , "[Remark(s)]" );
               formObj.mnvr_rmk.focus();
            }
    		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "t1sheet1_mnvr_rmk",document.form.mnvr_rmk.value);
    	}    	
    	function trsp_rmk_td_onchange(){
    		sheetObjects[6].SetCellValue(sheetObjects[6].GetSelectRow(), "t6sheet1_trsp_rmk",document.form.trsp_rmk_td.value);
    	}    	
    	function trsp_rmk_rd_onchange(){
    		sheetObjects[7].SetCellValue(sheetObjects[7].GetSelectRow(), "t7sheet1_trsp_rmk",document.form.trsp_rmk_rd.value);
    	}    	
        function rhq_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
        {
        	var formObj=document.form;
			var objs=document.all.item("tabLayer");
			if(objs[1].style.display == "inline")
			{
				//if(rhqChangeFlg)
				formObj.loc_cd.value="";
				rhqChangeFlg=true;
				setPort_Grid_Combo(1);
			}else if(objs[3].style.display == "inline")
			{
				//if(rhqChangeFlg)
				formObj.loc_cd.value="";
				rhqChangeFlg=true;
				setPort_Doc_Combo(3);
			}else if(objs[5].style.display == "inline")
			{
				//if(rhqChangeFlg)
				formObj.loc_cd.value="";
				rhqChangeFlg=true;
				setPortTrsp_Grid_Combo(6);
			}else if(objs[6].style.display == "inline")
			{
				formObj.loc_cd.value="";
				rhqChangeFlg=true;
				setPortTrsp_Grid_Combo(7);
			}
        }
        /* Getting RHQ combo */
    	function setRhq_Combo(tabCnt){
		    var formObj=document.form;
			formObj.f_cmd.value=SEARCH08;
			var sRhqXml=sheetObjects[8].GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj));
			var sRhqVal=ComGetEtcData(sRhqXml, "cmbVal");
			var sRhqName=ComGetEtcData(sRhqXml, "cmbName");
			if( sRhqVal != "")
			{
				var arrRhqVal=sRhqVal.split("|");
				var arrRhqName=sRhqName.split("|");
				for(var i=0; i<arrRhqVal.length ; i++)
				{
					rhqChangeFlg=false;
					if(tabCnt==1 || tabCnt==3 || tabCnt== 5 || tabCnt==6){
						comboObjects[0].SetSelectCode(arrRhqVal[0],false);
					}else{
						formObj.in_rhq.value=arrRhqVal[0];
					}
				}
				//Creating grid Combo as Rhq
				if(tabCnt == 1)
					setPort_Grid_Combo(1);
				else if(tabCnt == 3)
					setPort_Doc_Combo(3);
				else if(tabCnt == 5)
					setPortTrsp_Grid_Combo(6);
				else if(tabCnt == 6)
					setPortTrsp_Grid_Combo(7);
			}else{
				ComShowCodeMessage('VSK50015', formObj.loc_cd.value);
				ComClearObject(formObj.loc_cd);
				if(tabCnt == 0 || tabCnt == 2){
					ComClearObject(formObj.in_rhq);
				}else if(tabCnt == 1 || tabCnt == 3 || tabCnt == 5 || tabCnt == 6){
					comboObjects[0].SetSelectCode("^",false);
				}
			}
    	}
        /* Getting port Combo as RHQ*/
    	function setPort_Grid_Combo(tabCnt){
    		var formObj=document.form;
			formObj.f_cmd.value=SEARCH09;
			var sXml=sheetObjects[8].GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj));
			var sVal=ComGetEtcData(sXml, "cmbVal");
			var sName=ComGetEtcData(sXml, "cmbName");
			if( sVal != "")
			{
				if(tabCnt == 1){
					sheetObjects[1].SetColProperty("t2sheet1_loc_cd", {ComboText:"|"+sVal, ComboCode:"|"+sName} );
				}
			}    	
    	}
        /* Getting port Combo as RHQ */
    	function setPort_Doc_Combo(tabCnt){
    		var formObj=document.form;
			formObj.f_cmd.value=SEARCH12;
			var sXml=sheetObjects[0].GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj));
			var sVal=ComGetEtcData(sXml, "cmbVal");
			var sName=ComGetEtcData(sXml, "cmbName");
			if( sVal != "")
			{
				if(tabCnt == 3){
					sheetObjects[3].SetColProperty("t4sheet1_loc_cd", {ComboText:"|"+sVal, ComboCode:"|"+sName} );
				}
			}    	
    	}    	
        /* Getting RHQ combo */
    	function setPortTrsp_Grid_Combo(tabCnt){
    		var formObj=document.form;
    		formObj.f_cmd.value=SEARCH11;
    		var sXml=sheetObjects[0].GetSearchData("VOP_VSK_0504GS.do", FormQueryString(formObj));
			var sVal=ComGetEtcData(sXml, "cmbVal");
			var sName=ComGetEtcData(sXml, "cmbName");
			if( sVal != "")
			{
				if(tabCnt == 6){
					sheetObjects[6].SetColProperty("t6sheet1_loc_cd", {ComboText:"|"+sVal, ComboCode:"|"+sName} );
				}else if(tabCnt == 7){
					sheetObjects[7].SetColProperty("t7sheet1_loc_cd", {ComboText:"|"+sVal, ComboCode:"|"+sName} );
				}
			}    	
    	}
    	/**
    	 * Getting MESSAGE from sXml 
    	 * @param sXml
    	 * @return Sring MESSAGE
    	 * @author jkc
    	 */
    	function ComVskGetMessageFromXml(sXml){
    		if ( sXml == null  || sXml == "" ) return;
    		try {
//    			var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
//    			xmlDoc.loadXML(sXml);
    			var xmlDoc = ComGetXmlDoc(sXml);
    			if (xmlDoc == null) return;
    			
    			var xmlRoot=xmlDoc.documentElement;
    			if(xmlRoot == null) return;
    			var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
    			if(msgNode == null) return "";
    			return msgNode.firstChild.nodeValue;
    		} catch(err) { ComFuncErrMsg(err.message); }
    	}
    	/**
    	 *  Getting DF from sXml 
    	 */    	
    	function ComVskXml2ComboString(xmlStr, codeCol, textCol, val1) {
    		var rtnArr=new Array();
    		if (xmlStr == null || xmlStr == "") {
    			return;
    		}
    		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
    			return;
    		}
    		try {
//    			var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
//    			xmlDoc.loadXML(xmlStr);
    			var xmlDoc = ComGetXmlDoc(xmlStr);
    			if (xmlDoc == null) return;
    			var xmlRoot=xmlDoc.documentElement;
    			if (xmlRoot == null) {
    				return;
    			}
    			var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
    			if (dataNode == null || dataNode.attributes.length < 3) {
    				return;
    			}
    			var col=dataNode.getAttribute("COLORDER");
    			var colArr=col.split("|");
    			var sep=dataNode.getAttribute("COLSEPARATOR");
    			var total=dataNode.getAttribute("TOTAL");
    			var dataChildNodes=dataNode.childNodes;
    			if (dataChildNodes == null) {
    				return;
    			}
    			var colListIdx=Array();
    			for ( var i=0; i < colArr.length; i++) {
    				if (colArr[i] == codeCol) {
    					colListIdx[0]=i;
    				}
    				if (colArr[i] == textCol) {
    					colListIdx[1]=i;
    				}
    				if (colArr[i] == val1) {
    					colListIdx[2]=i;
    				}
    			}
    			var sCode="";
    			var sText="";
    			var sVal1="";
    			for ( var i=0; i < dataChildNodes.length; i++) {
    				if (dataChildNodes[i].nodeType != 1) {
    					continue;
    				}
    				var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
    				sCode += arrData[colListIdx[0]];
    				sText += arrData[colListIdx[1]];
    				sVal1 += arrData[colListIdx[2]];
    				if (i != dataChildNodes.length - 1) {
    					sCode += "|";
    					sText += "|";
    					sVal1 += "|";
    				}
    			}
    			rtnArr.push(sCode);
    			rtnArr.push(sText);
    			rtnArr.push(sVal1);
    		} catch (err) {
    			ComFuncErrMsg(err.message);
    		}
    		return rtnArr;
    	}
    	
	function returnTierScg(obj) {
		btn_Retrieve.click();
	}
	
	function resizeSheet() {
	    for (i=0; i<sheetObjects.length; i++) {
	    	if (i >= 1 && 3 >= i) {
	    		ComResizeSheet(sheetObjects[i]);
	    	} else if (i >= 4 && 5 >= i) {
	    		ComResizeSheet(sheetObjects[i], 180);
	    	} else {
	    		ComResizeSheet(sheetObjects[i], 100);
	    	}
	    }
	}
	// data format check
	function checkNumberFormat(sheetObj, Row, Col, Value) {
		var edtLen = sheetObj.GetCellProperty(Row, Col, "EditLen");
		var ckVal = Value + "";
		var num = ckVal.split(".");
		var point = sheetObj.GetCellProperty(Row, Col, "PointCount");
		if(num.length > 1) {
			ckVal = num[0] + "";
		} else {
			ckVal = num + "";
		}
		if(ckVal.length >= edtLen - point) {
			var msg = "";
			var after = "";
			for(i=edtLen-point-1;i>0;i--) {
				msg=msg+"9";
				if(i!=1 && i%3==1){
					msg=msg+",";
				} 
			}
			for(j=0;j<point;j++){
				after=after+"9";
				if(j==0) {
					after="."+after;
				}
			}
			msg = msg + after;
			//error message
			ComShowCodeMessage("COM12133","Input",msg,"smaller");
			sheetObj.SetCellValue(Row, Col, '0');
			sheetObj.SelectCell(Row, Col, true);
			return false;
		}
	}