/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_5004.js
*@FileTitle  : OW/ On-hire Receiving Plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
// common static variable
var sheetObjects=new Array();
var sheetCnt=0;
var IBSEARCH01=29;
var lease_term_cd="";
var lease_term_nm="";
var yd_cd="";
var yd_nm="";
var date_list_by_week="";
var headCount=0;
var save_flag=false;
var clickFlag=false;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         	var shtCnt=0;
         	var sheetObject=sheetObjects[shtCnt++];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_RowAdd":
						sheetObject.DataInsert(-1);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"loc_cd",formObject.loc_cd.value ,0);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"fcast_yrwk",ComTrimAll(formObject.fcast_yrwk.value, "-", ""),0);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"inp_yrwk",ComTrimAll(formObject.inp_yrwk.value, "-", ""),0);
						sheetObject.SetCellValue(sheetObject.GetSelectRow(),"mty_bal_otr_tp_cd",formObject.tp_cd.value ,0);
						setGtotalCaluValue();
						break;
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					case "btn_downExcel":
						
						if(sheetObjects[0].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObjects[0].Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false});
							}
						break;
					case "btn_Delete":
						if(sheetObject.FindCheckedRow("del_chk")=="") {
							ComShowCodeMessage("CIM00010");
						} else  { 
							doActionIBSheet(sheetObject,formObject,IBDELETE);
						}
						break;
					case "btn_Close":
						ComClosePopup(); 
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
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01);
        for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        //sincronizing DRY,SPCL,ALL with parent window
        
        var opener_obj=window.dialogArguments;
        
        if (!opener) opener_obj = parent;
        var viewFlag=opener_obj.chkFlag_chk();
        
        if ( viewFlag == 'DRY' ) {
        	document.form.viewFlag[0].checked=true;
        	sheetObjects[0].FrozenCol=6;
    		//setCellHidden(sheetObjects[0],false,true);
        } else if ( viewFlag == 'SPCL' ) {
        	document.form.viewFlag[1].checked=true;
        	sheetObjects[0].FrozenCol=11;
    		//setCellHidden(sheetObjects[0],true,false);
        } else if ( viewFlag == 'ALL' ) {
        	document.form.viewFlag[2].checked=true;
        	sheetObjects[0].FrozenCol=5;
    		//setCellHidden(sheetObjects[0],false,false);
        }
    }
    /**
     * calling function to EES_CIM_0032 
     */
    function callParentFnc() {
	ComClosePopup(); 
    }
    /**
     * registering initial event 
     */
    function initControl() {
     	axon_event.addListenerForm('click', 'viewFlag_click', form);
    }  
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                var HeadTitle1="Sel.|L/Term|Delivery Yard|Planned\n Delivery Date|G.TTL|D.TTL|D2|D4|D5|D7|S.TTL|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|Remark(s)||||||";
                headCount=ComCountHeadTitle(HeadTitle1);
                SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",            KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",            KeyField:1,   CalcLogic:"",   Format:"" },
                       {Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",              KeyField:1,   CalcLogic:"",   Format:"" },
                       {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fcast_dt",           KeyField:1,   CalcLogic:"",   Format:"" },
                       {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"g_total",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"d_total",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"d2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"d4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"d5_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"d7_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"s_total",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"r2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"r5_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"o2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"s2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"o4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"s4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"f2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"a2_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"f4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"a4_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"f5_fcast_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"loc_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"fcast_yrwk",         KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"inp_yrwk",           KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"cre_seq",            KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"mty_bal_otr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
                InitColumns(cols);
                SetEditable(1);
                SetColProperty("lstm_cd", {ComboText:"|OW|LT|ST|OF|SB", ComboCode:"|OW|LT|ST|OF|SB"} );
                SetColProperty("yd_cd", {ComboText:yd_cd, ComboCode:yd_cd} );
                SetColProperty("fcast_dt", {ComboText:"|"+date_list_by_week, ComboCode:"|"+date_list_by_week} );
                viewFlag_chk(sheetObj);
                SetSheetHeight(250);
                }
                break;
        }
    }
    /**
     * handling process for Sheet
     */    
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
            	sheetObj.SetWaitImageVisible(0);
            	ComOpenWait(true); 
				sheetObj.RenderSheet(0);
    			formObj.f_cmd.value=SEARCH;
    			sheetObj.RenderSheet(1);
    			sheetObj.DoSearch("EES_EQR_5004GS.do",FormQueryString(formObj) );
            	ComOpenWait(false); 
    			break;
    		case IBSEARCH01:      //retrieve
    			form.f_cmd.value=SEARCH01;
    			var sXml=sheetObj.GetSearchData("EES_EQR_5004GS.do" , FormQueryString(form));
    			lease_term_cd=ComGetEtcData(sXml,"lease_term_cd");
    			lease_term_nm=ComGetEtcData(sXml,"lease_term_nm");
    			yd_cd=ComGetEtcData(sXml,"yd_cd");
    			yd_nm=ComGetEtcData(sXml,"yd_nm");
    			date_list_by_week=ComGetEtcData(sXml,"date_list_by_week");
    			break;
			case IBSAVE:        //saving
				if(validateForm(sheetObj,formObj,sAction))
				formObj.f_cmd.value=MULTI;
				if (!ComShowCodeConfirm("COM130101")) return;
				sheetObj.DoSave("EES_EQR_5004GS.do",FormQueryString(formObj),"ibflag",false);
			break;
			case IBDELETE:		// removing
				if(sheetObj.FindCheckedRow("del_chk") != ""){
					ComRowHideDelete(sheetObj,"del_chk"); 
				}
				if(sheetObj.RowCount()> 0) {
	                for ( var j=0; j<headCount; j++ ) {
	                	if ( j !=0 && j !=1  && j !=2  && j !=3  && j !=4  && j !=10  && j !=22 && j !=23 && j !=24 && j !=25 && j !=26 && j !=27 && j !=28 ) {	                		
	        				setCaluValue(sheetObj.ColSaveName(j).substring(0,2),sheetObj);
	                	}
	                }
	                setGtotalCaluValue();
				}
                break;
			case IBINSERT:      // inserting
			break;
        }
    }
    /**
     * g_total calculation
     */    
	function setGtotalCaluValue() {
        var sumGtotal=0;
        if ( document.form.viewFlag[2].checked ) {
        	for ( var i=1; i<=sheetObjects[0].RowCount(); i++ ) {
        		if ( sheetObjects[0].GetRowStatus(i) != "D" ) {
        			sumGtotal=sumGtotal + eval(ComReplaceStr(sheetObjects[0].GetCellValue(i, "g_total"),",",""));
        		}
        	}
        	sheetObjects[0].SetCellValue(sheetObjects[0].LastRow(),"g_total",ComAddComma(sumGtotal),0);
        }
	}
    /**
     *total calculation
     */    
	function setCaluValue(tpsz,sheetObj) {
		var sumTpsz=0;
		var sumGtotal=0;
		var sumDtotal=0;
		var sumStotal=0;
		for ( var i=1; i<=sheetObj.RowCount(); i++ ) {
			if ( sheetObj.GetRowStatus(i) != "D" ) {
				if ( sheetObj.GetCellText(i, tpsz+"_fcast_qty") !="" ) {
					sumTpsz=sumTpsz + eval(ComReplaceStr(sheetObj.GetCellValue(i, tpsz+"_fcast_qty"),",",""));
				}
				if (tpsz =="g_" ) {
					sumGtotal=sumGtotal + eval(ComReplaceStr(sheetObj.GetCellValue(i, "g_total"),",",""));
				}
				if (tpsz =="d_" ) {
					sumDtotal=sumDtotal + eval(ComReplaceStr(sheetObj.GetCellValue(i, "d_total"),",",""));
				}
				if (tpsz =="s_" ) {
					sumStotal=sumStotal + eval(ComReplaceStr(sheetObj.GetCellValue(i, "s_total"),",",""));
				}
			}
		}
		var colGtotal=0;
		var colDtotal=0;
		var colStotal=0;
        for ( var j=0; j<headCount; j++ ) {
        	if ( j !=0 && j !=1  && j !=2  && j !=3  && j !=4 && j !=5 && j !=10  && j !=22 && j !=23 && j !=24 && j !=25 && j !=26 && j !=27 && j !=28 ) {
        		if ( sheetObj.GetCellText(sheetObj.GetSelectRow(), sheetObj.ColSaveName(j)) !="" ) {
	        		if ( sheetObj.ColSaveName(j).substring(0,1) == 'd' ) {
	        			colDtotal=colDtotal + eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.ColSaveName(j)),",",""));
	        		} 
	        		if ( sheetObj.ColSaveName(j).substring(0,1) != 'd' ) {
	        			colStotal=colStotal + eval(ComReplaceStr(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sheetObj.ColSaveName(j)),",",""));
	        		}
    			}
        	}
        }
		if (tpsz =="g_" ) {
			sheetObj.SetCellValue(sheetObj.LastRow(),"g_total",ComAddComma(sumGtotal),0);
		} else if (tpsz =="d_" ) {
			sheetObj.SetCellValue(sheetObj.LastRow(),"d_total",ComAddComma(sumDtotal),0);
		} else if (tpsz =="s_" ) {
			sheetObj.SetCellValue(sheetObj.LastRow(),"s_total",ComAddComma(sumStotal),0);
		} else {
			sheetObj.SetCellValue(sheetObj.LastRow(),tpsz+"_fcast_qty",ComAddComma(sumTpsz),0);
		}
        colGtotal=colDtotal+colStotal;
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"g_total",ComAddComma(colGtotal),0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"d_total",ComAddComma(colDtotal),0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"s_total",ComAddComma(colStotal),0);
	}
    /**
     * handling after edit event on sheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	selected Row
     * @param {ibsheet} col     	selected Col
     **/
    function sheet1_OnAfterEdit(sheetObj, Row, Col, KeyCode, Shift) {	
    	switch (sheetObj.ColSaveName(Col)) {
    		case "d2_fcast_qty":
    			setCaluValue("d2",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "d4_fcast_qty":
    			setCaluValue("d4",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "d5_fcast_qty":
    			setCaluValue("d5",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "d7_fcast_qty":
    			setCaluValue("d7",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "r2_fcast_qty":
    			setCaluValue("r2",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "r5_fcast_qty":
    			setCaluValue("r5",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "o2_fcast_qty":
    			setCaluValue("o2",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "s2_fcast_qty":
    			setCaluValue("s2",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "o4_fcast_qty":
    			setCaluValue("o4",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "s4_fcast_qty":
    			setCaluValue("s4",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "f2_fcast_qty":
    			setCaluValue("f2",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "a2_fcast_qty":
    			setCaluValue("a2",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "f4_fcast_qty":
    			setCaluValue("f4",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "a4_fcast_qty":
    			setCaluValue("a4",sheetObj);	   //MTY Balancecalculation
       			break;
    		case "f5_fcast_qty":
    			setCaluValue("f5",sheetObj);	   //MTY Balancecalculation
       			break;
    	} 
		setGtotalCaluValue();
    }	
    /**
     * in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event     
     */
    function viewFlag_click(sheetObj) {
		switch (event.srcElement.name) {
		case "viewFlag":
			if ( document.form.viewFlag[0].checked ) {
				sheetObjects[0].SelectCell(0, "d2_fcast_qty", true);
				sheetObjects[0].FrozenCol=6;
				setCellHidden(sheetObjects[0],false,true);
			} else if ( document.form.viewFlag[1].checked ) {
				sheetObjects[0].SelectCell(0, "r2_fcast_qty", true);
				sheetObjects[0].FrozenCol=11;
				setCellHidden(sheetObjects[0],true,false);
			} else if ( document.form.viewFlag[2].checked ) {
				sheetObjects[0].SelectCell(0, "d2_fcast_qty", true);
				sheetObjects[0].FrozenCol=5;
				setCellHidden(sheetObjects[0],false,false);
			}
			break;
		}
    }
    /**
     * in case of checking DRY,SPLC(RF, OT, FR), ALL, defining handling event     
     */
    function viewFlag_chk(sheetObj) {
		if ( document.form.viewFlag[0].checked ) {
			setCellHidden(sheetObj,false,true);
		} else if ( document.form.viewFlag[1].checked ) {
			setCellHidden(sheetObj,true,false);
		} else if ( document.form.viewFlag[2].checked ) {
			setCellHidden(sheetObj,false,false);
		}
    }
    /**
     * setting cell to hide
     */
    function setCellHidden(sheetObj,showFlag1,showFlag2) {
    	if ( showFlag1==false && showFlag2==false ) {
    		sheetObj.SetColHidden("g_total",0);
    	} else {
    		sheetObj.SetColHidden("g_total",1);
    	}
		if ( showFlag1==false && showFlag2==false ) {
			sheetObj.SetColHidden("d_total",1);
		} else {
			sheetObj.SetColHidden("d_total",showFlag1);
		}
		sheetObj.SetColHidden("d2_fcast_qty",showFlag1);
		sheetObj.SetColHidden("d4_fcast_qty",showFlag1);
		sheetObj.SetColHidden("d5_fcast_qty",showFlag1);
		sheetObj.SetColHidden("d7_fcast_qty",showFlag1);
		if ( showFlag1==false && showFlag2==false ) {
			sheetObj.SetColHidden("s_total",1);
		} else {
			sheetObj.SetColHidden("s_total",showFlag2);
		}
		sheetObj.SetColHidden("r2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("r5_fcast_qty",showFlag2);
		sheetObj.SetColHidden("o2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("s2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("o4_fcast_qty",showFlag2);
		sheetObj.SetColHidden("s4_fcast_qty",showFlag2);
		sheetObj.SetColHidden("f2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("a2_fcast_qty",showFlag2);
		sheetObj.SetColHidden("f4_fcast_qty",showFlag2);
		sheetObj.SetColHidden("a4_fcast_qty",showFlag2);
		sheetObj.SetColHidden("f5_fcast_qty",showFlag2);
    }
    /**
     * handling search end event on sheet
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		//sheetObj.SetEditableColor("#000000");
		//sheetObj.UnEditableColor="#000000";
		for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
			//sheetObj.SetRowBackColor(i,"#000000");
		}
		//sheetObj.SetRowBackColor(sheetObj.LastRow(),sheetObj.WebColor2SysColor("#D3EBED"));
		sheetObj.SetCellValue(sheetObj.LastRow(),"del_chk","",0);
		sheetObj.SetCellValue(sheetObj.LastRow(),"lstm_cd","G.Total",0);
		sheetObj.SetMergeCell(sheetObj.LastRow(), 1, 0, 3);
		sheetObj.SetSumFontBold(1);
		sheetObj.SetCellAlign(sheetObj.LastRow(),"lstm_cd","Center");
		sheetObj.RenderSheet(1);
//no support[implemented common]CLT 		sheetObj.SelectHighLight=false;
	}
    /**
     * handling save end event on sheet
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	save_flag=true;
    	if ( ErrMsg == "" ) {
			if ( save_flag ) { 
		    	var opener_obj=window.dialogArguments;
		    	 opener_obj = parent;
	    		for ( var j=5; j<=22; j++ ) {
	    			if ( sheetObjects[0].RowCount()> 0 ) {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), sheetObjects[0].GetCellValue(sheetObjects[0].LastRow(),sheetObjects[0].ColSaveName(j)));
	    			} else {
	    				opener_obj.setOwOnHireValue(sheetObjects[0].ColSaveName(j), 0);
	    			}
	            }
		    	opener_obj.popupCloseEnd();	  //calling calculation fuction on EES_CIM_0032
			} 
			ComShowCodeMessage("EQR70002");
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
     * handling click event on sheet <br>
     * changing cell background color
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
     	clickFlag=true;
    }	
    /**
     * handling change event on sheet
    */
    function sheet1_OnChange(sheetObj,Row,Col, Val) {
		switch (sheetObj.ColSaveName(Col)) {
			case "yd_cd":
				var str_yd_cd=yd_cd.split("|");
				var chkFlag=false;
				for ( var i=0; i<=str_yd_cd.length; i++) {
					if ( str_yd_cd[i] ==sheetObj.GetCellValue(Row,"yd_cd")  ) {
						chkFlag=true;
						break;
					}
				}
				if ( !chkFlag ) { 
					ComShowCodeMessage("EQR70003");
					sheetObj.SetCellValue(Row,"yd_cd","",0);
					sheetObj.SelectCell(Row, "yd_cd", true);
				}
				break;
		}
    }
