/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0512.js
*@FileTitle  : Lane Information Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
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
	var marrTabTitle=new Array("Lane Group", "Status", "PIC", "Bunkering Port");
	var marrPicTpCd=new Array("I", "J", "S");
	var marrPicTpNm=new Array("Own Vessel Operator", "Partners Vessel Operator", "Special Cargo Authorization Part");
	var mCheckValue=false;
	var mEditRow=0;
	var mEditSheet=0;
	var mPrefix="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;

	// Event handler processing by button name
	function processButtonClick() {
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4]; 
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];         
		var sheetObject8 = sheetObjects[7];         
		var sheetObject9 = sheetObjects[8];         
		var sheetObject10 = sheetObjects[9];         
		var sheetObject11 = sheetObjects[10];         
		var sheetObject12 = sheetObjects[11];

		var formObject = document.form;
		var objs = document.all.item("tabLayer");

		try {
			var srcName = ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;  
			if (ComGetBtnDisable(srcName)) return false;

			switch (srcName) {
			case "btn_Retrieve" :
				doActionIBSheet(beforetab, formObject, IBSEARCH);
				break;
			case "btn_Save" :
				doActionIBSheet(beforetab, formObject, IBSAVE);
				break;
			case "btn_New" :
				var statsCnt = 0;
				var changeSheet="";

				if (beforetab == 0) {
					t1sheet1.RemoveAll();
					t1sheet2.RemoveAll();
					t1sheet3.RemoveAll();
					t1sheet4.RemoveAll();
				} else if (beforetab == 1) {
					formObject.slan_cd.value = "";
					t2sheet1.RemoveAll();
					t2sheet2.RemoveAll();
					t2sheet3.RemoveAll();
				} else if (beforetab == 2) {
					formObject.slan_cd.value = "";
					t3sheet1.RemoveAll();
					t3sheet2.RemoveAll();
					t3sheet3.RemoveAll();
					t3sheet4.RemoveAll();
				} else if (beforetab == 3) {
					formObject.slan_cd.value = "";
					t4sheet1.RemoveAll();
				}
				break;
			case "ComOpenPopupWithTarget" :
				if (objs[0].style.display != "inline") {
					var v_display="0,0";
					var laneCd=document.form.slan_cd.value;
					ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 500, 470, "getReturn0202", v_display, true);
				}
				break;
			case "btn_DownExcel" :
				if(beforetab == 1){
//					var data = [];
//					data.push(sheetObjects[4].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:1, AutoSizeColumn: 1, SheetName:"Service Status"}));
//					data.push(sheetObjects[5].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:1, AutoSizeColumn: 1, SheetName:"Deployed Vessel Status"}));
//					data.push(sheetObjects[6].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:true,TreeLevel:false,SheetDesign:1,AutoSizeColumn: 1, SheetName:"Service Including Vessel"}));
//					
//					Grids["g_down2ExcelBuffer"] = data.join("\x03");
//					
//					sheetObjects[6].Down2ExcelBuffer(false);
					
					 sheetObjects[4].Down2ExcelBuffer(true); 
					 sheetObjects[4].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:1, AutoSizeColumn: 1, SheetName:"Service Status"}); 
					 sheetObjects[5].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:1, AutoSizeColumn: 1, SheetName:"Deployed Vessel Status"}); 
					 sheetObjects[6].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:1,TreeLevel:false,SheetDesign:1,AutoSizeColumn: 1, SheetName:"Service Including Vessel"}); 
					 sheetObjects[4].Down2ExcelBuffer(false); 
					//jointSheet2ExcelStatus();
				}else if(beforetab == 2){
					jointSheet2Excel();
				}else if(beforetab == 3){
					t4sheet1.Down2Excel({HiddenColumn:1, Merge:true,TreeLevel:false,SheetDesign:1});
				}

				break;																	
			case "btn_t2insert1":
				var Row=sheetObject5.DataInsert();
				sheetObject5.SetCellValue(Row, "t2sheet1_slan_cd",formObject.slan_cd.value);
				sheetObject5.SetCellValue(Row, "t2sheet1_lane_pic_tp_cd",marrPicTpCd[0]);
				sheetObject5.SelectCell(Row, "t2sheet1_usr_nm", true);
				break; 
			case "btn_t2add1":
				var Row=sheetObject5.DataInsert(-1);
				sheetObject5.SetCellValue(Row, "t2sheet1_slan_cd",formObject.slan_cd.value);
				sheetObject5.SetCellValue(Row, "t2sheet1_lane_pic_tp_cd",marrPicTpCd[0]);
				sheetObject5.SelectCell(Row, "t2sheet1_usr_nm", true);
				break;	
			case "btn_t2del1":
				ComRowHideDelete(sheetObject1,"t2sheet1_del_chk");
				break;
			//Joint Operation Lane
			case "btn_t2insert2":
				var Row=sheetObject6.DataInsert();
				sheetObject6.SetCellValue(Row, "t2sheet2_slan_cd",formObject.slan_cd.value);
				sheetObject6.SetCellValue(Row, "t2sheet2_lane_pic_tp_cd",marrPicTpCd[1]);
				sheetObject6.SelectCell(Row, "t2sheet2_usr_nm", true);
				break; 
			case "btn_t2add2":
				var Row=sheetObject6.DataInsert(-1);
				sheetObject6.SetCellValue(Row, "t2sheet2_slan_cd",formObject.slan_cd.value);
				sheetObject6.SetCellValue(Row, "t2sheet2_lane_pic_tp_cd",marrPicTpCd[1]);
				sheetObject6.SelectCell(Row, "t2sheet2_usr_nm", true);
				break;	
			case "btn_t2del2":
				ComRowHideDelete(sheetObject6,"t2sheet2_del_chk");
				break;
			//Special Cargo Authorization Part
			case "btn_t2insert3":
				var Row=sheetObject7.DataInsert();
				sheetObject7.SetCellValue(Row, "t2sheet3_slan_cd",formObject.slan_cd.value);
				sheetObject7.SetCellValue(Row, "t2sheet3_lane_pic_tp_cd",marrPicTpCd[2]);
				sheetObject7.SelectCell(Row, "t2sheet3_usr_nm", true);
				break; 
			case "btn_t2add3":
				var Row=sheetObject7.DataInsert(-1);
				sheetObject7.SetCellValue(Row, "t2sheet3_slan_cd",formObject.slan_cd.value);
				sheetObject7.SetCellValue(Row, "t2sheet3_lane_pic_tp_cd",marrPicTpCd[2]);
				sheetObject7.SelectCell(Row, "t2sheet3_usr_nm", true);
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
			} // end switch
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
		axon_event.addListenerForm  ('blur', 'obj_deactivate',	form);
        axon_event.addListenerFormat('focus', 'obj_activate',		form);
//      axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
//		axon_event.addListener('keypress', 'slan_cd_onkeypress', 'slan_cd', '');
//    	axon_event.addListener('keyup', 'slan_cd_onkeyup', 'slan_cd', '');
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
//    	switch(ComGetEvent().dataformat){
//			case "int":
//		        ComKeyOnlyNumber(ComGetEvent());
//				break;
//			case "float":
//		        ComKeyOnlyNumber(ComGetEvent(), ".");
//				break;
//			default:
//		        ComKeyOnlyNumber(ComGetEvent());
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
		      var HeadTitle1="|No|Lane Code|Lane Name|vskd_flet_grp_cd|upd_usr_id|upd_usr_id";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="t1sheet" + sheetNo + "_";
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hidStatus" },
				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_slan_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"vskd_flet_grp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetSheetHeight(260);
            }
		} else if(sheetNo > 7 && sheetNo < 12){
		    with(sheetObj){
		      var HeadTitle1="|RSO|Name|Lane Code|Lane Code|VSL OPR|Vessel Code| Job Disc.|E-mail Address|E-mail Address|Tel.|Cell Phone|Fax|Remark(s)|lane_pic_tp_cd|lane_pic_tp_seq|upd_usr_id|upd_usr_id";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="";
		      if(sheetNo < 11)
		    	  prefix="t3sheet" + (parseInt(sheetNo) - 7) + "_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var vslOprCdHidden = 1;
		      if (sheetNo == 9) {
		          vslOprCdHidden = 0;
		      }
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Text", Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rgn_shp_opr_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"usr_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"lane_mng_usr_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:vslOprCdHidden,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_opr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, InputCaseSensitive:1, AcceptKeys:"E|N" },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pic_vsl_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"jb_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pic_eml",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"lane_pic_usr_eml",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pic_phn_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:1,   SaveName:prefix+"mphn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:1,   SaveName:prefix+"fax_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"lane_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane_pic_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane_pic_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      InitColumns(cols);
		      SetEditable((sheetNo==11?1:0));
		      SetSheetHeight(170);
		      }
		} else if(sheetObj.id == "t4sheet1"){
			with (sheetObj) {
				SetColProperty(prefix + "vsl_slan_cd", {ComboText:"" + document.form.laneCd.value, ComboCode: "" + document.form.laneCd.value});
				arrPort = document.form.bunkerPort.value.split("|");
				var HeadTitle1 = "|Bunkering Ports|Bunkering Ports" + document.form.bunkerPort.value + "|Total";
				var headCount = ComCountHeadTitle(HeadTitle1);
				var prefix = "t4sheet1_";
				SetConfig({SearchMode:2, MergeSheet:8, Page:20, FrozenCol:3, DataRowMerge:0});
				var info = {Sort:1, ColMove:1, HeaderCheck:0, ColResize:1};
				var headers = [{Text:HeadTitle1, Align:"Center"}];
				InitHeaders(headers, info);
				var cols = [
					{Type:"Status",	Hidden:1,	Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix + "ibflag" },
					{Type:"Text",	Hidden:0,	Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix + "vsl_slan_nm",   KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",	Hidden:0,	Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix + "vsl_slan_cd",   KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
				];
				for (var arrIdx=1;  arrIdx<arrPort.length; arrIdx++) {
					var colNm = prefix + "rfuel_rto";
					if (arrIdx < 10)
						colNm = colNm + "_0" + arrIdx;
					else
						colNm = colNm + "_" + arrIdx;
						cols.push({Type:"Int",       Hidden:0,  Width:53,   Align:"Center",  ColMerge:0,   SaveName:colNm, KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
				}
				cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rfuel_rto_tot", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(420);
			}
		} else if(sheetObj.id == "t2sheet1"){
			with (sheetObj) {
				var HeadTitle1="|Service Status (Latest 90 days based on ETB)|Service Status (Latest 90 days based on ETB)|Service Status (Latest 90 days based on ETB)";
//				var HeadTitle2="|Type|VSL Count|VSL SVC Lane";
				var HeadTitle2="|Type|Lane Count|Lane with "+OPC003+" operating vessel";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="t2sheet1_";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
				                { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hidStatus" },
				             {Type:"Text",      Hidden:0, Width:250,  Align:"Left" ,   ColMerge:1,   SaveName:prefix+"type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",  ColMerge:1,   SaveName:prefix+"count",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",  ColMerge:1,   SaveName:prefix+"vsl_svc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(240);
				}
		} else if(sheetObj.id == "t2sheet2"){
		    with(sheetObj){
			      var HeadTitle1="|Deployed Vessel Status (Latest 90 days based on ETB)|Deployed Vessel Status (Latest 90 days based on ETB)";
			      var HeadTitle2="|Operator|VSL Count";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      var prefix="t2sheet2_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hidStatus" },
			             {Type:"Text",      Hidden:0,  Width:135,  Align:"Center",  ColMerge:1,   SaveName:prefix+"opr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"count",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetSheetHeight(240);
	            }
		} else if(sheetObj.id == "t2sheet3" || sheetObj.id == "sheet2"){
			with (sheetObj) {
				var prefix="t2sheet3_";
				if(sheetObj.id == "t2sheet3"){
					var HeadTitle1="|SVC Lane|SVC Lane|Fleet Information|Fleet Information|Fleet Information|Fleet Information|Fleet Information|Fleet Information|Fleet Information|SVC Start Date|Port Rotation|Duration|Remark(s)";
//					var HeadTitle2="|SVC Lane|SVC Lane|VSL Name|OPR|Size|VSL|VSL|OTH|TTL|SVC Start Date|Port Rotation|Duration|Remark(s)";
					var HeadTitle2="|SVC Lane|SVC Lane|VSL Name|OPR|Size|"+OPC003+"-VSL|"+OPC003+"-VSL|OTH|TTL|SVC Start Date|Port Rotation|Duration|Remark(s)";
					var HeadTitle3="|SVC Lane|SVC Lane|VSL Name|OPR|Size|OWN|CHTR|OTH|TTL|SVC Start Date|Port Rotation|Duration|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},
					                { Text:HeadTitle2, Align:"Center"},
					                { Text:HeadTitle3, Align:"Center"} ];
					InitHeaders(headers, info);
					// InitColumns(cols);
				} else {
					prefix="sheet2_";
					var HeadTitle1="|SVC Lane|SVC Lane|VSL Name|OPT|Size|OWN|CHTR|OTH|TTL|SVC Opening Date|Port Rotation|Fre.|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
				}
				
				SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
//				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hidStatus" },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"grp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"svc_lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"vsl_class",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"own",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cht",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"oth",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ttl",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"svc_open_dt", KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:235,  Align:"Left",    ColMerge:1,   SaveName:prefix+"port_rot",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fre",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"remark",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(270);
			}
		}
	}	//End function
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "vskd_flet_grp_cd":    //R/D Term-post
				var i=0;
				with(comboObj) {
					style.width=250;
					ComVskXml2ComboItem(sXml, comboObjects[0], "val", "desc");
					comboObjects[0].InsertItem(0, "ALL", "%");
					comboObjects[0].SetSelectCode("%");
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
		//Activating Fleet Type
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
	}

    function doActionIBSheet(tabIdx, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH : // Retrieve
        	if (validateForm(formObj,sAction)) {
				if (tabIdx == 0) {
					var arrPrefix = new Array("t1sheet1_", "t1sheet2_", "t1sheet3_", "t1sheet4_");
					formObj.f_cmd.value = SEARCH01;
					var sXml = sheetObjects[0].GetSearchData("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 3) {
						for(var cnt=0; cnt<arrXml.length; cnt++) {
							sheetObjects[cnt].SetWaitImageVisible(0);
							sheetObjects[cnt].LoadSearchData(arrXml[cnt], {Sync:1});	
						}
					}
				} else if (tabIdx == 1) {
					formObj.f_cmd.value = SEARCH01;
					var arrPrefix = new Array("t2sheet1_", "t2sheet2_", "t2sheet3_");
					var sXml = sheetObjects[4].GetSearchData("VOP_VSK_0512GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 2) {
						for (var cnt=4; cnt<arrXml.length + 4; cnt++) {
							sheetObjects[cnt].SetWaitImageVisible(0);
							sheetObjects[cnt].LoadSearchData(arrXml[cnt-4], {Sync:1});
						}
						sheetObjects[sheetObjects.length - 1].LoadSearchData(ComReplaceStr(arrXml[2], {Sync:0} ));
					}
				} else if (tabIdx == 2) {
					formObj.f_cmd.value = SEARCH02;
					sheetObjects[7].SetWaitImageVisible(1);
					var arrPrefix = new Array("t3sheet1_", "t3sheet2_", "t3sheet3_");
					var sXml = sheetObjects[7].GetSearchData("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 2) {
						for (var cnt=7; cnt<arrXml.length + 7; cnt++) {
							sheetObjects[cnt].LoadSearchData(arrXml[cnt-7], {Sync:1});
							sheetObjects[cnt].SetWaitImageVisible(0);
						}
					}
				} else if (tabIdx == 3) {
					with (sheetObjects[11]) {
						formObj.f_cmd.value = SEARCH03;
						SetWaitImageVisible(1);
						var arrPrefix = new Array("t4sheet1_");
						var sXml = GetSearchData("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
						var arrXml = sXml.split("|$$|");
						LoadSearchData(arrXml[0],{Sync:1});
						SetWaitImageVisible(0);
						SetCellFont("FontBold", HeaderRows(), "t3sheet1_vsl_slan_nm", RowCount(), "t3sheet1_vsl_slan_nm", 1);
					}
				}
			}
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
	function t3sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t3sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t3sheet1_upd_usr_id");
	}

	function t3sheet2_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t3sheet2_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t3sheet2_upd_usr_id");
	}

	function t3sheet3_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t3sheet3_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t3sheet3_upd_usr_id");
	}

	function t2sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t2sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd")
			mCheckValue=true;
	}
    function t2sheet2_OnChange(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "t2sheet2_slan_cd" && mCheckValue){
			if (sheetObj.GetCellValue(Row, "t2sheet2_slan_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "Lane");
				sheetObj.SelectCell(Row, "t2sheet2_slan_cd", true);
			} else{
				document.form.f_cmd.value=SEARCH03;
				mEditRow=Row;
				mEditSheet=5;
				mPrefix="t2sheet2_";
				sheetObjects[9].DoSearch("VOP_VSK_UTILGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_") + "&vsl_slan_cd=" + sheetObj.CellValue(Row, "t2sheet2_slan_cd") );
			}
		}
	}
	function t2sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t2sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd")
			mCheckValue=true;
	}
	
    function t2sheet3_OnChange(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "t2sheet3_slan_cd" && mCheckValue){
			if(sheetObj.GetCellValue(Row, "t2sheet3_slan_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "Lane");
				sheetObj.SelectCell(Row, "t2sheet3_slan_cd", true);
			} else{
				document.form.f_cmd.value=SEARCH03;
				mEditRow=Row;
				mEditSheet=6;
				mPrefix="t2sheet3_";
				sheetObjects[9].DoSearch("VOP_VSK_UTILGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_") + "&vsl_slan_cd=" + sheetObj.CellValue(Row, "t2sheet3_slan_cd") );
			}
		}
	}
	function t2sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t2sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd")
			mCheckValue=true;
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
					CellBackColor(Row, SaveNameCol(prefix + "rfuel_rto_tot"))=UnEditableColor;
				else if(totRfuel < 100)
					SetCellBackColor(Row, SaveNameCol(prefix + "rfuel_rto_tot"),"#FF7D7D");
				else
					SetCellBackColor(Row, SaveNameCol(prefix + "rfuel_rto_tot"),"#7D7DFF");
				SetCellValue(Row, prefix + "rfuel_rto_tot",totRfuel);
			}
		} else if(sheetObj.ColSaveName(Col) == prefix + "vsl_slan_cd"){
			// Port duplicate check
			var idxDub=sheetObj.ColValueDup(prefix + "vsl_slan_cd");
			if(idxDub > -1){
				ComShowCodeMessage("VSK50303", "Lane", idxDub-1);
				sheetObj.SelectCell(Row, Col);
				return ;
			}
		}
	}
	function t2sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet1_slan_cd"){
			mEditSheet=4;
			ComOpenPopup('/opuscntr/COM_ENS_081.do', 830, 560, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}
	}
	function t2sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet2_slan_cd"){
			mEditSheet=5;
			ComOpenPopup('/opuscntr/COM_ENS_081.do', 830, 560, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}
	}
	function t2sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet3_slan_cd"){
			mEditSheet=6;
			ComOpenPopup('/opuscntr/COM_ENS_081.do', 830, 560, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}
	}
	function setLaneInfoOperation(aryPopupData, Row, Col, sheetIdx){
		mCheckValue=false;
		sheetObjects[mEditSheet].SetCellValue(Row,Col,aryPopupData[0][3],0);
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
		document.form.f_cmd.value=SEARCH03;
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
		sheetObjects[7].SetWaitImageVisible(1);
		for(var cnt=0; cnt < marrPicTpNm.length; cnt++){
			with(sheetObjects[cnt + 7]){
				if(RowCount()> 0){
					var insRow=sheetObjects[10].DataInsert(-1);
					sheetObjects[10].SetCellValue(insRow, "usr_nm","  " + marrPicTpNm[cnt]);
					sheetObjects[10].SetMergeCell(insRow, sheetObjects[10].SaveNameCol("rgn_shp_opr_cd"), 1, sheetObjects[10].LastCol()- 3);
					for(var idxRow=HeaderRows(); idxRow <= RowCount(); idxRow++){
						var insRow=sheetObjects[10].DataInsert(-1);
						for(var idxCol=1; idxCol <= LastCol(); idxCol++){
							sheetObjects[10].SetCellValue(insRow, idxCol,GetCellValue(idxRow, idxCol));
						}
					}
				}
			}
		}
		if(sheetObjects[10].RowCount()> 0){
			//sheetObjects[10].Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false});
			sheetObjects[10].Down2Excel({KeyFieldMark:0,HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
			sheetObjects[10].RemoveAll();
		} 
		sheetObjects[7].SetWaitImageVisible(0);
	}
	function jointSheet2ExcelStatus(){
		sheetObjects[4].SetWaitImageVisible(1);
		var isStatStart=2;
		var ivStatStart=6;
		var sheetObj=sheetObjects[sheetObjects.length - 1];
		var endRow=sheetObjects[4].RowCount()> sheetObjects[5].RowCount()? sheetObjects[4].RowCount(): sheetObjects[5].RowCount();
		for(var cnt=0; cnt <= endRow + 4; cnt++){
			sheetObj.DataInsert(0);
		}
		//Service Status
		for(var idxRow=0; idxRow <= sheetObjects[4].LastRow(); idxRow++){
			for(var idxCol=1; idxCol <= sheetObjects[4].LastCol(); idxCol++){
				sheetObj.SetCellValue(idxRow + 1, idxCol + isStatStart,sheetObjects[4].GetCellValue(idxRow, idxCol));
			}
		}
		//Deployed Vessel Status
		for(var idxRow=0; idxRow <= sheetObjects[5].LastRow(); idxRow++){
			for(var idxCol=1; idxCol <= sheetObjects[5].LastCol(); idxCol++){
				sheetObj.SetCellValue(idxRow + 1, idxCol + ivStatStart,sheetObjects[5].GetCellValue(idxRow, idxCol));
			}
		}
		//Vessel SVC - Service including vessel
		if(sheetObjects[6].RowCount() > 0) {
            for(var idxHedCol=1; idxHedCol < sheetObjects[6].LastCol(); idxHedCol++){
                sheetObj.SetCellValue(endRow + 5, idxHedCol,sheetObjects[6].GetCellValue(2, idxHedCol));
            }
		}
		//1.1 Service Status Header
		sheetObj.SetMergeCell(1, isStatStart + 1, 1, 3);
		cellHeaderChange(sheetObj, 1, isStatStart + 1);
		for(var cnt=1; cnt < 4; cnt++){
			cellHeaderChange(sheetObj, 2, isStatStart + cnt);
		}
		//1.2 Service Total
		//Coloring Total page
		for(var idxRow=2; idxRow < endRow + 5; idxRow++){
			if(sheetObj.GetCellValue(idxRow, isStatStart + 1) == "TOTAL"){
				for(var cnt=1; cnt < 4; cnt++){
					cellTotalChange(sheetObj, idxRow, isStatStart + cnt);
				}
				break;
			}
		}
		//2.1 Service Status Header
		sheetObj.SetMergeCell(1, ivStatStart + 1, 1, 2);
		cellHeaderChange(sheetObj, 1, ivStatStart + 1);
		for(var cnt=1; cnt < 3; cnt++){
			cellHeaderChange(sheetObj, 2, ivStatStart + cnt);
		}
		//2.2 Service Total
		//Coloring Total page
		for(var idxRow=2; idxRow < endRow + 5; idxRow++){
			if(sheetObj.GetCellValue(idxRow, ivStatStart + 1) == "TOTAL"){
				for(var cnt=1; cnt < 3; cnt++){
					cellTotalChange(sheetObj, idxRow, ivStatStart + cnt);
				}
				break;
			}
		}
		//3.1 Vessel SVC - Service including vessel coloring
		//3.1.1 SVC Lane
		var headStartRow=endRow + 5;
		sheetObj.SetMergeCell(headStartRow, 1, 1, 2);
		cellHeaderChange(sheetObj, headStartRow, 1);
		for(var cnt=3; cnt <= sheetObj.LastCol(); cnt++){
			cellHeaderChange(sheetObj, headStartRow, cnt);
		}
		sheetObj.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false});
		
	}
	function cellHeaderChange(sheetObj, headerRow, headerCol){
		sheetObj.SetCellAlign(headerRow, headerCol,"Center");
		sheetObj.SetCellFont("FontBold",  headerRow, headerCol,1);
		sheetObj.SetCellBackColor(headerRow, headerCol,sheetObj.GetHeaderBackColor());
		// sheetObj.SetCellFontColor(headerRow, headerCol,sheetObj.HeadFontColor);
	}
	
	function cellTotalChange(sheetObj, totRow, totCol){
		sheetObj.SetCellValue(totRow, 1, "TOTAL");
		sheetObj.SetCellAlign(totRow, totCol,"Center");
		sheetObj.SetCellFont("FontBold",  totRow, totCol,1);
		sheetObj.SetCellBackColor(totRow, totCol,sheetObj.GetSubSumBackColor());
	}
	
	function clearFormNData(){
		for(var cnt=0; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
	}
	function moveFocus(nItem){
		switch(nItem){
			case 0:
				ComAlertFocus(document.form.vskd_flet_grp_cd, "");
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
	
	function getReturn0202(rtnVal){

		var formObj=document.form;
		var rVal = rtnVal[0];
		if (rVal.length > 0) {			
			formObj.slan_cd.value =rVal[1];
		}		
	}