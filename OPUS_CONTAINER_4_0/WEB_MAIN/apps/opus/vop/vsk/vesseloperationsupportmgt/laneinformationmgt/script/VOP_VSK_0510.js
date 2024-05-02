/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0510.js
*@FileTitle  : Lane Information Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class vop_vsk_0510 : business script for vop_vsk_0510
 */
 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var marrPrefix=new Array("t1sheet1_", "t2sheet1_", "t3sheet1_");
	var marrTabTitle=new Array("Lane Group", "PIC", "Bunkering Port");
	var marrPicTpCd=new Array("I", "J", "S");
	var marrPicTpNm=new Array("Independence Operation Lane", "Joint Operation Lane", "Special Cargo Authorization Part");
	var mCheckValue=false;
	var mEditRow=0;
	var mEditSheet=0;
	var mPrefix="";
	var mPreSearCond="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
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
         var formObject=document.form;
         var objs=document.all.item("tabLayer");
    	 try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;  
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
						case "btn_Retrieve":
								doActionIBSheet(beforetab, formObject, IBSEARCH);
								break;
						case "btn_Save":
								doActionIBSheet(beforetab, formObject, IBSAVE);
								break;
						case "btn_New" :
							var statsCnt = 0;
							var changeSheet = "";
							for (var cnt=4; cnt<9; cnt++) {
								if (cnt != 7) {
									var changeSheetCnt = sheetObjects[cnt].RowCount("I") + sheetObjects[cnt].RowCount("U") + sheetObjects[cnt].RowCount("D");
									if (changeSheetCnt > 0) {
										var title = (cnt < 8 ? marrPicTpNm[cnt - 4] : "Bunkering Port");
										statsCnt += changeSheetCnt;
										changeSheet += changeSheet == "" ? title : ", " + title;
									}
								}
							}
							if (statsCnt > 0) {
								if (ComShowCodeConfirm("VSK50012")) {
									clearFormNData();
									moveFocus(beforetab);
								}
							}
							break;
						case "ComOpenPopupWithTarget":
							if( objs[0].style.display != "inline" ){
								ComOpenPopupWithTarget('/opuscntr/COM_ENS_081.do', 830, 460, "col1:slan_cd", "0,0,1,1,1,1,1", true);
							}
							break;
						case "btn_DownExcel":
								if (beforetab == 1){
									jointSheet2Excel();
								} else{ 
									if(sheetObject9.RowCount() < 1){//no data
										ComShowCodeMessage("COM132501");
					        	    } else{
					        	    	//sheetObject9.Down2Excel({ HiddenColumn:1,KeyFieldMark:0,Merge:true,TreeLevel:false});  
					        	    	sheetObject9.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject9),KeyFieldMark:0,HiddenColumn:1,Merge:true,TreeLevel:false});
					        	    }
								}
								break;					
						case "btn_t1DLGroup":
//								ComOpenPopup('/opuscntr/VOP_VSK_0702.do?', 1000, 680, "", "0,0", true);
								ComOpenPopup("/opuscntr/VOP_VSK_0702.do?", 1000, 680, "LaneGroupSetting", "0,0,1,1,1,1", false, false);
								break;																		
						case "btn_t2insert1":
								var Row=sheetObject5.DataInsert();
								sheetObject5.SetCellValue(Row, "t2sheet1_slan_cd",formObject.slan_cd.value);
								sheetObject5.SetCellValue(Row, "t2sheet1_lane_pic_tp_cd",marrPicTpCd[0]);
								sheetObject5.SelectCell(Row, "t2sheet1_rgn_shp_opr_cd", true);
								break; 
						case "btn_t2add1":
								var Row=sheetObject5.DataInsert(-1);
								sheetObject5.SetCellValue(Row, "t2sheet1_slan_cd",formObject.slan_cd.value);
								sheetObject5.SetCellValue(Row, "t2sheet1_lane_pic_tp_cd",marrPicTpCd[0]);
								sheetObject5.SelectCell(Row, "t2sheet1_rgn_shp_opr_cd", true);
								break;	
						case "btn_t2del1":
								ComRowHideDelete(sheetObject5,"t2sheet1_del_chk");
								break;
						case "btn_t2insert2":
								var Row=sheetObject6.DataInsert();
								sheetObject6.SetCellValue(Row, "t2sheet2_slan_cd",formObject.slan_cd.value);
								sheetObject6.SetCellValue(Row, "t2sheet2_lane_pic_tp_cd",marrPicTpCd[1]);
								sheetObject6.SelectCell(Row, "t2sheet2_rgn_shp_opr_cd", true);
								break; 
						case "btn_t2add2":
								var Row=sheetObject6.DataInsert(-1);
								sheetObject6.SetCellValue(Row, "t2sheet2_slan_cd",formObject.slan_cd.value);
								sheetObject6.SetCellValue(Row, "t2sheet2_lane_pic_tp_cd",marrPicTpCd[1]);
								sheetObject6.SelectCell(Row, "t2sheet2_rgn_shp_opr_cd", true);
								break;	
						case "btn_t2del2":
								ComRowHideDelete(sheetObject6,"t2sheet2_del_chk");
								break;
						case "btn_t2insert3":
								var Row=sheetObject7.DataInsert();
								sheetObject7.SetCellValue(Row, "t2sheet3_slan_cd",formObject.slan_cd.value);
								sheetObject7.SetCellValue(Row, "t2sheet3_lane_pic_tp_cd",marrPicTpCd[2]);
								sheetObject7.SelectCell(Row, "t2sheet3_rgn_shp_opr_cd", true);
								break; 
						case "btn_t2add3":
								var Row=sheetObject7.DataInsert(-1);
								sheetObject7.SetCellValue(Row, "t2sheet3_slan_cd",formObject.slan_cd.value);
								sheetObject7.SetCellValue(Row, "t2sheet3_lane_pic_tp_cd",marrPicTpCd[2]);
								sheetObject7.SelectCell(Row, "t2sheet3_rgn_shp_opr_cd", true);
								break;	
						case "btn_t2del3":
								ComRowHideDelete(sheetObject7,"t2sheet3_del_chk");
								break;
						case "btn_t3add":
								var Row=sheetObject9.DataInsert(-1);
								sheetObject9.SetCellValue(Row, "t3sheet1_vsl_slan_nm","Lane");
								sheetObject9.SelectCell(Row, "t3sheet1_vsl_slan_cd", true);
								break;
						case "btn_t3insert":
								var Row=sheetObject9.DataInsert();
								sheetObject9.SetCellValue(Row, "t3sheet1_vsl_slan_nm","Lane");
								sheetObject9.SelectCell(Row, "t3sheet1_vsl_slan_cd", true);
								break;
						case "btn_t3del":
								ComRowHideDelete(sheetObject9, "t3sheet1_del_chk");
								break;		
				}		
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
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
     * Event when clicking Tab
     * activating selected tab items
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		for(k=0; k < tabObjects.length; k++){
            initTab(tabObjects[k],k+1);
        }
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();
		initComboData();
    }
	function initComboData(){
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH04;
		var sXml=sheetObjects[0].GetSearchData("VOP_VSK_0510GS.do", FormQueryString(formObj));
		var arrCombo=ComXml2ComboString(sXml, "val", "name");
		t2sheet1.SetColProperty("t2sheet1_rgn_shp_opr_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
		t2sheet2.SetColProperty("t2sheet2_rgn_shp_opr_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
		t2sheet3.SetColProperty("t2sheet3_rgn_shp_opr_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
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
					for(; cnt < marrTabTitle.length; cnt++){
						InsertItem( marrTabTitle[cnt], "");
					}
			}
            break;
        }
        tabObj.SetSelectedIndex(0);
    }
    /**
    * registering initial event 
    */
    function initControl() {
		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form);
        axon_event.addListenerFormat('focus',			'obj_activate',		form);
        // axon_event.addListenerFormat('keypress',        'obj_keypress', 	form);
		// axon_event.addListener('keypress', 'slan_cd_onkeypress', 'slan_cd', '');
    	// axon_event.addListener('keyup', 'slan_cd_onkeyup', 'slan_cd', '');
    }
    /**
     * Remove mask separator on onFocus Event<br>
     **/
    function obj_activate(){
        ComClearSeparator(ComGetEvent());
    }
    /**
     * Setting mask separator on onFocus Event, Check validation
     **/
	function obj_deactivate(){
		ComChkObjValid(ComGetEvent());
	}
    /**
     * Handling key press event
     **/
//    function obj_keypress(){
//    	switch(event.srcElement.dataformat){
//			case "int":
//		        ComKeyOnlyNumber(event.srcElement);
//				break;
//			case "float":
//		        ComKeyOnlyNumber(event.srcElement, ".");
//				break;
//			default:
//		        ComKeyOnlyNumber(event.srcElement);
//    	}
//    }
    function dateFormat(n, digits) {
    	var zero='';
    	n=n.toString();
    	if (n.length < digits) {
    		for (i=0; i < digits - n.length; i++)
    	    zero += '0';
    	}
    	return zero + n;
    }
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		if(sheetNo < 5){
		    with(sheetObj){
		      var HeadTitle1="|No.|Lane Code|Lane Name|vskd_flet_grp_cd|upd_usr_id|upd_usr_id";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="t1sheet" + sheetNo + "_";
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hidStatus" },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_slan_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"vskd_flet_grp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetSheetHeight(220);
		    }
		} else if(sheetNo > 4 && sheetNo < 9){
		      with(sheetObj){
		         var HeadTitle1="|Sel.|RSO|Name|Lane Code|Lane Code|VSL OPR|Vessel Code| Job Disc.|E-mail Address|E-mail Address|Tel.|Cell Phone|Fax|Remark(s)|lane_pic_tp_cd|lane_pic_tp_seq|upd_usr_id|upd_usr_id";
		         var headCount=ComCountHeadTitle(HeadTitle1);
		         var prefix="";
		         if(sheetNo < 8)
		        	 prefix="t2sheet" + (parseInt(sheetNo) - 4) + "_";
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var vslOprCdHidden = 1;
		         if (sheetNo == 6) {
		        	 vslOprCdHidden = 0;
		         }
		         var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		 		             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		 		             {Type:"Combo",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rgn_shp_opr_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		 		             //{Type:"Text", Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rgn_shp_opr_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"usr_nm",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		 		             {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, InputCaseSensitive:1, AcceptKeys:"E|N"},
		 		             {Type:"Text",      Hidden:1,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_slan_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		 	    {Type:"PopupEdit", Hidden:vslOprCdHidden,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_opr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, InputCaseSensitive:1, AcceptKeys:"E|N" },
		 		             {Type:"Text",      Hidden:1,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pic_vsl_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		 		             {Type:"Text",      Hidden:1,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"jb_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
		 		             {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pic_eml",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		 		             {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lane_pic_usr_eml", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		 		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pic_phn_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		 		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mphn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		 		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fax_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lane_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
		 		             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane_pic_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane_pic_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		    
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(150);
		      }
		} else if(sheetNo == 9){
		    with(sheetObj){
		      arrPort=document.form.bunkerPort.value.split("|");
		      var HeadTitle1="|Bunkering Ports|Bunkering Ports|Bunkering Ports" + document.form.bunkerPort.value + "|Total";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="t3sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:8, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
			             {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 } ];
              for (var arrIdx=1;  arrIdx < arrPort.length; arrIdx++){
            	  var colNm=prefix + "rfuel_rto";
            	  if(arrIdx < 10)
            		  colNm=colNm + "_0" + arrIdx;
            	  else
            		  colNm=colNm + "_" + arrIdx;
            	  cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:colNm,                  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
		      }
		      cols.push({Type:"Int", Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rfuel_rto_tot", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
		      InitColumns(cols);
		      SetEditable(1);
		      SetColProperty(prefix+"vsl_slan_cd", {ComboText:""+document.form.laneNm.value, ComboCode:""+document.form.laneCd.value} );
		      SetSheetHeight(362);
		      }


		} else {
		    with(sheetObj){
		      var HeadTitle1="|Value|Name";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"val" },
			             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"name" } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(120);
		    }
		}
	}	//End function
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "vskd_flet_grp_cd":    //R/D Term-post
				var i=0;
				with(comboObj) {
					ComVskXml2ComboItem(sXml, comboObjects[0], "val", "desc");
					comboObj.InsertItem(0, "ALL", "%");
					SetDropHeight(200);
					SetMaxSelect(1);
					Code="%";
				}
				break;
		}
	}
    /**
     * Handling tab click event
     * Activating clicked tab
     */
    function tabLane_OnChange(tabObj , nItem){
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
		if(beforetab == 0){
			//document.form.slan_cd.disabled = true;
			ComEnableObject(document.all.slan_cd, false);
			ComClearObject(document.form.slan_cd);
			ComEnableObject(document.all.ComOpenPopupWithTarget, false);
			document.form.slan_cd.className="input2";
			document.all.item("divExcell").style.display="none";
		}else{
			//document.form.slan_cd.disabled = false;
			ComEnableObject(document.all.slan_cd, true);
			ComEnableObject(document.all.ComOpenPopupWithTarget, true);
			document.form.slan_cd.className="input";
			document.all.item("divExcell").style.display="inline";
		}
		moveFocus(beforetab);
		if(beforetab == 2){
			doActionIBSheet(beforetab, document.form, IBSEARCH);
		}
	}
    function doActionIBSheet(tabIdx, formObj, sAction) {
    	switch(sAction) {
			case IBSEARCH:		//Retrieve
				if(validateForm(formObj,sAction)){
					if (tabIdx != 0){
						if(mPreSearCond != formObj.slan_cd.value){
							clearSheet();
						}
					}
					if ( tabIdx == 0){
						var arrPrefix=new Array("t1sheet1_", "t1sheet2_", "t1sheet3_", "t1sheet4_");
						formObj.f_cmd.value=SEARCH01;
						var sXml=sheetObjects[0].GetSearchData("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
						var arrXml=sXml.split("|$$|");
						if(arrXml.length > 3){
							for(var cnt=0; cnt < arrXml.length; cnt++){
								sheetObjects[cnt].RenderSheet(0);
								sheetObjects[cnt].SetWaitImageVisible(0);
								sheetObjects[cnt].LoadSearchData(arrXml[cnt],{Sync:0} );
								sheetObjects[cnt].RenderSheet(1);
							}
						}
					} else if(tabIdx == 1){
						formObj.f_cmd.value=SEARCH02;
						sheetObjects[4].SetWaitImageVisible(1);
						var arrPrefix=new Array("t2sheet1_", "t2sheet2_", "t2sheet3_");
						var sXml=sheetObjects[0].GetSearchData("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
						var arrXml=sXml.split("|$$|");
						if(arrXml.length > 2){
							for(var cnt=4; cnt < arrXml.length + 4; cnt++){
								sheetObjects[cnt].RenderSheet(0);
								sheetObjects[cnt].LoadSearchData(arrXml[cnt-4],{Sync:0} );
								sheetObjects[cnt].RenderSheet(1);
								sheetObjects[cnt].SetWaitImageVisible(0);
							}
						}
						mPreSearCond=formObj.slan_cd.value;
					} else if(tabIdx == 2){
						with(sheetObjects[8]){
							formObj.f_cmd.value=SEARCH03;
							SetWaitImageVisible(1);
							var arrPrefix=new Array("t3sheet1_");
							var sXml=GetSearchData("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
							var arrXml=sXml.split("|$$|");
							RenderSheet(0);
							LoadSearchData(arrXml[0],{Sync:0} );
							RenderSheet(1);
							SetWaitImageVisible(0);
//							SetColBackColor("t3sheet1_vsl_slan_nm",GetHeaderBackColor());
							// SetColFontColor("t3sheet1_vsl_slan_nm",HeadFontColor);
							SetCellFont("FontBold", HeaderRows(), "t3sheet1_vsl_slan_nm", RowCount(), "t3sheet1_vsl_slan_nm",1);
						}
						mPreSearCond=formObj.slan_cd.value;
					}
				}
				break;
				
			case IBSAVE:
				formObj.f_cmd.value=MULTI;
				var sParam=ComGetSaveString(sheetObjects);
				if (sParam == "") return;
				if(sParam.indexOf("t3sheet1_") > -1 && (sheetObjects[8].RowCount("I") > 0 || sheetObjects[8].RowCount("U") > 0)){
					for(var idxRow=sheetObjects[8].HeaderRows(); idxRow <= sheetObjects[8].RowCount(); idxRow++){
						//if RowStatus is C or U, 100 check
						if((sheetObjects[8].GetRowStatus(idxRow) == "I" || sheetObjects[8].GetRowStatus(idxRow) == "U") && sheetObjects[8].GetCellValue(idxRow, "t3sheet1_rfuel_rto_tot") != 100){
							ComShowCodeMessage("VSK50024");
							return;
						}
					}
				}
				sParam +=  "&" + FormQueryString(formObj);
				var sXml=sheetObjects[4].GetSaveData("VOP_VSK_0510GS.do", sParam);
				var arrXml=OpfDeleteData(sXml);
				if(arrXml[1] != null){
					sheetObjects[7].RenderSheet(0);
					sheetObjects[7].SetWaitImageVisible(0);
					sheetObjects[7].LoadSearchData(arrXml[1],{Sync:0} );
					sheetObjects[7].RenderSheet(1);
					var arrPrefix=new Array("t2sheet1_", "t2sheet2_", "t2sheet3_");
					for(var cnt=0; cnt < 3; cnt++){
						with(sheetObjects[cnt + 4]){
							if(RowCount("I") > 0){
								for(var editRow=HeaderRows(); editRow <= RowCount(); editRow++){
									if(GetRowStatus(editRow) == "I"){
										var checkValue=GetCellValue(editRow, arrPrefix[cnt] + "usr_nm");
										var checkValue2=GetCellValue(editRow, arrPrefix[cnt] + "lane_pic_tp_cd");
										var checkValue3=GetCellValue(editRow, arrPrefix[cnt] + "slan_cd");
										for(var checkRow=sheetObjects[7].HeaderRows(); checkRow <= sheetObjects[7].RowCount(); checkRow++){
											if(checkValue == sheetObjects[7].GetCellValue(checkRow, "usr_nm") &&
												checkValue2 == sheetObjects[7].GetCellValue(checkRow, "lane_pic_tp_cd") &&
												checkValue3 == sheetObjects[7].GetCellValue(checkRow, "slan_cd")){
												SetCellValue(editRow, arrPrefix[cnt] + "lane_pic_seq",sheetObjects[7].GetCellValue(checkRow, "lane_pic_seq"));
												break;
											}
										}
									}
								}
							}
						} 
					}
					sheetObjects[7].RemoveAll();
				}
				sheetObjects[4].LoadSaveData(arrXml[0]);
				//Showing message, and after that delete message
				arrXml[0]=ComDeleteMsg(arrXml[0]);
				sheetObjects[5].LoadSaveData(arrXml[0]);
				sheetObjects[6].LoadSaveData(arrXml[0]);
				sheetObjects[8].LoadSaveData(arrXml[0]);
				break;
		}
	}
	function t1sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t1sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t1sheet1_upd_usr_id");
	}
	function t1sheet2_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t1sheet2_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t1sheet2_upd_usr_id");
	}
	function t1sheet3_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t1sheet3_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t1sheet3_upd_usr_id");
	}
	function t1sheet4_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t1sheet4_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t1sheet4_upd_usr_id");
	}
	function t2sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t2sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t2sheet1_upd_usr_id");
	}
	function t2sheet2_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t2sheet2_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t2sheet2_upd_usr_id");
	}
	function t2sheet3_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t2sheet3_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t2sheet3_upd_usr_id");
	}
	function t2sheet1_OnChange(sheetObj, Row, Col, Value)  {
		if(sheetObj.ColSaveName(Col) == "t2sheet1_slan_cd" && mCheckValue && Value.length >= 1){
			if(sheetObj.GetCellValue(Row, "t2sheet1_slan_cd").length < 3) {
 				ComShowCodeMessage("VSK50010", Row, "Lane");
				sheetObj.SetCellValue(Row, Col,"");
			} else{
				mEditRow=Row;
				mEditSheet=4;
				mPrefix="t2sheet1_";
				document.form.f_cmd.value=SEARCH03;
				var sXml=sheetObjects[9].GetSearchData("VOP_VSK_VOSIGS.do", FormQueryString(document.form)  + "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, "t2sheet1_slan_cd"));
				var arrCombo=ComXml2ComboString(sXml, "vsl_slan_cd", "ofc_cd");
				if(arrCombo == null){
					ComShowCodeMessage('COM12114', 'Lane');
					sheetObj.SetCellValue(Row, Col,"");
				}
			}
		}else if(sheetObj.ColSaveName(Col) == "t2sheet1_vsl_opr_cd" && mCheckValue  && Value.length >= 1){
     		if (sheetObj.GetCellValue(Row, "t2sheet1_vsl_opr_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "VSL OPR");
				sheetObj.SetCellValue(Row, Col,"");
			} else{
				document.form.f_cmd.value=SEARCH;
				mEditRow=Row;
				mEditSheet=4;
				mPrefix="t2sheet1_";
				var sXml=sheetObjects[9].GetSearchData("VOP_VSK_0252GS.do", FormQueryString(document.form)  + "&grd_nm=CD0XXXX&code=" + sheetObj.GetCellValue(Row, "t2sheet1_vsl_opr_cd"));
				var totCnt=ComGetTotalRows(sXml);
				if(totCnt == "0"){
					ComShowCodeMessage('COM12114', 'VSL OPR');
					sheetObj.SetCellValue(Row, Col,"");
				}
			}
		}
	}
	
	function t2sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t2sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "vsl_opr_cd"){
			mCheckValue=true;
		}
    }
	
	function t2sheet2_OnChange(sheetObj, Row, Col, Value) {
     	if(sheetObj.ColSaveName(Col) == "t2sheet2_slan_cd" && mCheckValue  && Value.length >= 1){
     		if (sheetObj.GetCellValue(Row, "t2sheet2_slan_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "Lane");
				sheetObj.SetCellValue(Row, Col,"");
			} else{
				document.form.f_cmd.value=SEARCH03;
				mEditRow=Row;
				mEditSheet=5;
				mPrefix="t2sheet2_";
				document.form.f_cmd.value=SEARCH03;
				var sXml=sheetObjects[9].GetSearchData("VOP_VSK_VOSIGS.do", FormQueryString(document.form)  + "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, "t2sheet2_slan_cd"));
				var arrCombo=ComXml2ComboString(sXml, "vsl_slan_cd", "ofc_cd");
				if(arrCombo == null){
					ComShowCodeMessage('COM12114', 'Lane');
					sheetObj.SetCellValue(Row, Col,"");
				}
			}
		}else if(sheetObj.ColSaveName(Col) == "t2sheet2_vsl_opr_cd" && mCheckValue  && Value.length >= 1){
     		if (sheetObj.GetCellValue(Row, "t2sheet2_vsl_opr_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "VSL OPR");
				sheetObj.SetCellValue(Row, Col,"");
			} else{
				if(ConstantMgr.getCompanyCode() == Value){
					ComShowCodeMessage('VSK55012');
					sheetObj.SetCellValue(Row, Col, "", 0);
					return;
				}
				document.form.f_cmd.value=SEARCH;
				mEditRow=Row;
				mEditSheet=5;
				mPrefix="t2sheet1_";
				var sXml=sheetObjects[9].GetSearchData("VOP_VSK_0252GS.do", FormQueryString(document.form)  + "&grd_nm=CD0XXXX&code=" + sheetObj.GetCellValue(Row, "t2sheet2_vsl_opr_cd"));
				var totCnt=ComGetTotalRows(sXml);
				if(totCnt == "0"){
					ComShowCodeMessage('COM12114', 'VSL OPR');
					sheetObj.SetCellValue(Row, Col,"");
				}
			}
		}
    }
	
	function t2sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t2sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "vsl_opr_cd"){
			mCheckValue=true;
		}
	}
	
	function t2sheet3_OnChange(sheetObj, Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "t2sheet3_slan_cd" && mCheckValue && Value.length >= 1 ){
			if (sheetObj.GetCellValue(Row, "t2sheet3_slan_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "Lane");
				sheetObj.SetCellValue(Row, Col,"");
			} else{
				document.form.f_cmd.value=SEARCH03;
				mEditRow=Row;
				mEditSheet=6;
				mPrefix="t2sheet3_";
				document.form.f_cmd.value=SEARCH03;
				var sXml=sheetObjects[9].GetSearchData("VOP_VSK_VOSIGS.do", FormQueryString(document.form)  + "&vsl_slan_cd=" + sheetObj.GetCellValue(Row, "t2sheet3_slan_cd"));
				var arrCombo=ComXml2ComboString(sXml, "vsl_slan_cd", "ofc_cd");
				if(arrCombo == null){
					ComShowCodeMessage('COM12114', 'Lane');
					sheetObj.SetCellValue(Row, Col,"");
				}
			}
		}else if(sheetObj.ColSaveName(Col) == "t2sheet3_vsl_opr_cd" && mCheckValue  && Value.length >= 1){
     		if (sheetObj.GetCellValue(Row, "t2sheet3_vsl_opr_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "VSL OPR");
				sheetObj.SetCellValue(Row, Col,"");
			} else{
				document.form.f_cmd.value=SEARCH;
				mEditRow=Row;
				mEditSheet=6;
				mPrefix="t2sheet1_";
				var sXml=sheetObjects[9].GetSearchData("VOP_VSK_0252GS.do", FormQueryString(document.form)  + "&grd_nm=CD0XXXX&code=" + sheetObj.GetCellValue(Row, "t2sheet3_vsl_opr_cd"));
				var totCnt=ComGetTotalRows(sXml);
				if(totCnt == "0"){
					ComShowCodeMessage('COM12114', 'VSL OPR');
					sheetObj.SetCellValue(Row, Col,"");
				}
			}
		}
	}
	function t2sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t2sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "vsl_opr_cd")
			mCheckValue=true;
	}
	var checkyDcDFlg1=false;  //Tmml Code check flag
	function t3sheet1_OnClick(sheetObj, Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "t4sheet1_vsl_slan_cd"){
			if(!checkyDcDFlg1){
				sheetObj.SelectCell(Row, "t4sheet1_vsl_slan_cd", true);
			}
		}
	}
	function t3sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix="t3sheet1_";
		if(Col > sheetObj.SaveNameCol(prefix + "vsl_slan_cd")){
			with(sheetObj){
				//
				var totRfuel=0;
				for(var idxCol=parseInt(SaveNameCol(prefix + "vsl_slan_cd")) + 1;
						idxCol < SaveNameCol(prefix + "rfuel_rto_tot"); ++idxCol){
					if(GetCellValue(Row, idxCol) != "")
						totRfuel += parseInt(GetCellValue(Row, idxCol));
				}
				if(totRfuel == 100)
					{
					
					}
				else if(totRfuel < 100)
					SetCellBackColor(Row, SaveNameCol(prefix + "rfuel_rto_tot"),"#FF7D7D");
				else
					SetCellBackColor(Row, SaveNameCol(prefix + "rfuel_rto_tot"),"#7D7DFF");
				SetCellValue(Row, prefix + "rfuel_rto_tot",totRfuel);
			}
		} else if(sheetObj.ColSaveName(Col) == prefix + "vsl_slan_cd"){
			var idxDub=sheetObj.ColValueDup(prefix + "vsl_slan_cd");
			if (idxDub > -1){
//				ComShowCodeMessage("VSK50303", "Lane", idxDub-1);
				ComShowCodeMessage("VSK50303", sheetObj.GetCellValue(idxDub, prefix + "vsl_slan_cd"), idxDub);
				doActionIBSheet(2, document.form, IBSEARCH);
				return ;
			}
			checkyDcDFlg1=false;
			var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
			var arrCode=sCode.split("|");
			for(var i=0 ; i<arrCode.length ; i++){
				if(arrCode[i] == Value ){
					checkyDcDFlg1=true;
				}
			}
			//if Valid TMNL Code is not exist, focus on TMNL Code
			if (!checkyDcDFlg1){
				if(sheetObj.GetCellValue(Row, prefix + "vsl_slan_cd") != "" ){
					if(sheetObj.GetCellValue(Row, prefix + "vsl_slan_cd").length < 3){
						ComShowCodeMessage("VSK50027");
					}else{
						ComShowCodeMessage("VSK50028");
					}
				}
				sheetObj.SetCellValue(Row, prefix + "vsl_slan_cd","");
				sheetObj.SelectCell(Row, prefix + "vsl_slan_cd", true);
			}
		}
	}
	function t3sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t3sheet1_vsl_slan_cd"){
			if(!checkyDcDFlg1){
				sheetObj.SetCellValue(NewRow, "t3sheet1_vsl_slan_cd", true);
			}
		}
	}
	function t2sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet1_slan_cd"){
			mEditSheet=4;
			ComOpenPopup('/opuscntr/COM_ENS_081.do', 830, 460, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}else if(sheetObj.ColSaveName(Col) == "t2sheet1_vsl_opr_cd"){
			mEditSheet=4;
			var sUrl="/opuscntr/VOP_VSK_0252.do?code_type=CD0XXXX";
			ComOpenPopup(sUrl, 550, 406, "setVslOprCd", "0,1", true);
		}
	}
	function t2sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet2_slan_cd"){
			mEditSheet=5;
			ComOpenPopup('/opuscntr/COM_ENS_081.do', 830, 460, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}else if(sheetObj.ColSaveName(Col) == "t2sheet2_vsl_opr_cd"){
			mEditSheet=5;
			var sUrl="/opuscntr/VOP_VSK_0252.do?code_type=CD0XXXX";
			ComOpenPopup(sUrl, 550, 406, "setVslOprCd", "0,1", true);
		}
	}
	function t2sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet3_slan_cd"){
			mEditSheet=6;
			ComOpenPopup('/opuscntr/COM_ENS_081.do', 830, 460, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}else if(sheetObj.ColSaveName(Col) == "t2sheet3_vsl_opr_cd"){
			mEditSheet=6;
			var sUrl="/opuscntr/VOP_VSK_0252.do?code_type=CD0XXXX";
			ComOpenPopup(sUrl, 550, 406, "setVslOprCd", "0,1", true);
		}
	}
	function setLaneInfoOperation(aryPopupData, Row, Col, sheetIdx){
		mCheckValue=false;
		sheetObjects[mEditSheet].SetCellValue(Row,Col,aryPopupData[0][3],0);
	}
	function setVslOprCd(aryPopupData){
		mCheckValue=true;
		sheetObjects[mEditSheet].SetCellValue(sheetObjects[mEditSheet].GetSelectRow(),sheetObjects[mEditSheet].GetSelectCol(),aryPopupData,1);	
	}	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()< 1){
			if(mEditRow > 0){
				ComShowCodeMessage('COM12114','Lane');
				sheetObjects[mEditSheet].SelectCell(sheetObjects[mEditSheet].GetSelectRow(), mPrefix +  "slan_cd");
			}else{
				ComShowCodeMessage('COM12114','Lane');
				ComAlertFocus(document.form.slan_cd, "");
			}
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(formObj,sAction){
        return true;
    }
	function OpfDeleteData(sXml){
		var arrXmlData=new Array("", "");
		if(sXml.indexOf("<DATA") > -1) {
			var start=sXml.indexOf('<DATA');
			var end=sXml.indexOf('</DATA>');
			arrXmlData[0]=sXml.substring(0,start) + sXml.substring(end + 8);
			arrXmlData[1]="<SHEET>" + sXml.substring(start, end + 7) + "</SHEET>";
		}else{
			arrXmlData[0]=sXml;
			arrXmlData[1]=null;
		}
		return arrXmlData;
	}
	function slan_cd_onkeypress(){
		ComKeyOnlyAlphabet('uppernum');
		if((document.form.slan_cd.value == "" || document.form.slan_cd.value.length == 3) && event.keyCode == 13){
			doActionIBSheet(beforetab, document.form, IBSEARCH);
		}
	}
	function slan_cd_onkeyup(){
		if(document.form.slan_cd.value.length == 3){
			document.form.f_cmd.value=SEARCH03;
			mEditRow=0;
			var sXml=sheetObjects[9].GetSearchData("VOP_VSK_VOSIGS.do", FormQueryString(document.form)  + "&vsl_slan_cd=" + document.form.slan_cd.value);
			var arrCombo=ComXml2ComboString(sXml, "vsl_slan_cd", "ofc_cd");
			if(arrCombo == null){
				ComShowCodeMessage('COM12114', 'Lane');
				document.form.slan_cd.value="";
				document.form.slan_cd.focus();
			}
		}
	}
	function jointSheet2Excel(){
		sheetObjects[4].SetWaitImageVisible(1);
		
		sheetObjects[4].Down2ExcelBuffer(true)
		sheetObjects[4].Down2Excel({ DownCols: makeHiddenSkipCol(sheetObjects[4]),KeyFieldMark:0,HiddenColumn:1, SheetDesign:1, Merge:1, SheetName:'Own Vessel Operator'});
		sheetObjects[5].Down2Excel({ DownCols: makeHiddenSkipCol(sheetObjects[5]),KeyFieldMark:0,HiddenColumn:1, SheetDesign:1, Merge:1, SheetName:'Partners Vessel Operator'});
		sheetObjects[6].Down2Excel({ DownCols: makeHiddenSkipCol(sheetObjects[6]),KeyFieldMark:0,HiddenColumn:1, SheetDesign:1, Merge:1, SheetName:'Special Cargo Authorization Part'});
		sheetObjects[4].Down2ExcelBuffer(false)
		
		sheetObjects[4].SetWaitImageVisible(0);
	}
	function clearFormNData(){
		for(var cnt=0; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
		document.form.slan_cd.value="";
		document.form.upd_dt_view.value="";
		document.form.upd_id_view.value="";
	}
	function clearSheet(){
		for(var cnt=4; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
		document.form.upd_dt_view.value="";
		document.form.upd_id_view.value="";
	}
	function moveFocus(nItem){
		switch(nItem){
			case 0:
				//ComAlertFocus(document.form.vskd_flet_grp_cd, "");
				ComAlertFocus(document.form.slan_cd, "");
				break;
			case 1:
				ComAlertFocus(document.form.slan_cd, "");
				//document.form.por_rhq.Code = "%";
				break;
			case 2:
				ComAlertFocus(document.form.slan_cd, "");
				//document.form.por_rhq.Code = "%";
				break;
		}
	}