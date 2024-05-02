/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1006.js
*@FileTitle : On-Hire Status
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/09
=========================================================*/

var sheetObjects=new Array();
    var sheetCnt=0;
    var HeadTitleCnt=0;
    var yyyyMm="";
    var comboObjects=new Array();
    var comboCnt=0 ;
    var rowInsertSeq=0; 
    var rccCdList=""; 
	var lccCdList=""; 
    // -- Cntr Tpsz  //     
    var tpszallText="D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszallCode="D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszdryText="D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode="D2|D4|D5|D7";
    var tpszrfrText="R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode="R2|R5|R9";
    var tpszotText="O2|O4|O5|S2|S4"; // OT  TYPE SIZE 
    var tpszotCode="O2|O4|O5|S2|S4";
    var tpszfrText="F2|F4|F5|A2|A4"; // FR  TYPE SIZE 
    var tpszfrCode="F2|F4|F5|A2|A4";    
    var consTpsz="D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4";
    var consTpszArr=consTpsz.split(',');
    var consTpszDry="D2,D4,D5,D7";
    var consTpszRfr="R2,R5,R9";
    var consTpszOt="O2,O4,O5,S2,S4";
    var consTpszFr="F2,F4,F5,A2,A4";
    document.onclick=processButtonClick;
    function processButtonClick(){
        var shtCnt=0;
        var sheet1=sheetObjects[shtCnt];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
			case "btn_new":
                sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObjects[0],formObject,SEARCH02);
                break;	
            case "btn_save":
                doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                break;
            case "btn_downExcel":
                ComOpenWait(true);
                if(sheetObjects[0].RowCount() < 1){//no data
        	     	ComShowCodeMessage("COM132501");
        	    }else{
        	    	sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(                sheetObjects[0]), SheetDesign:1,Merge:1 });
        	    }
                ComOpenWait(false);
                break;
			case "btn_rowadd":
 			    if(sheetObjects[0].SelectHighLight && 
 			    		(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"merge_flag").substr(0,1)=="Y"
 			    			||sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"merge_flag").substr(0,1)=="N")){
					var selRow=sheetObjects[0].GetSelectRow();
					for(var i=selRow; i<sheetObjects[0].LastRow(); i++){
						if (sheetObjects[0].GetCellValue(i, "merge_flag").substr(0,1) != "Y"
							&& sheetObjects[0].GetCellValue(i, "merge_flag").substr(0,1) != "N"
								&& sheetObjects[0].GetCellValue(i, "merge_flag").substr(0,1) != "X") {
							sheetObjects[0].SelectCell(i - 1, "onh_ord_yr");
							break;
						}						
					}
					var newRow=sheetObjects[0].DataInsert();
					rowInsertSeq++; 
					sheetObjects[0].SetCellValue(newRow,"merge_flag","N"+rowInsertSeq,0);
                    sheetObjects[0].SetCellValue(newRow,"x_merge_flag","Y",0);// RCC, LCC  merge
                    sheetObjects[0].SetCellValue(newRow,"rcc_cd",sheetObjects[0].GetCellValue(selRow,"rcc_cd"),0);
                    sheetObjects[0].SetCellValue(newRow,"lcc_cd",sheetObjects[0].GetCellValue(selRow,"lcc_cd"),0);
				}else{
					var newRow=sheetObjects[0].DataInsert(0);
					rowInsertSeq++; 
					sheetObjects[0].SetCellValue(newRow,"merge_flag","X"+rowInsertSeq,0);// Row
					sheetObjects[0].SetCellValue(newRow,"x_merge_flag","X"+rowInsertSeq,0);
					sheetObjects[0].SetRowSumable(selRow , false); 
					sheetObjects[0].SetCellEditable(newRow,"rcc_cd",1);
					sheetObjects[0].SetCellEditable(newRow,"lcc_cd",1);
				}
				break;
			case "btn_rowdel":				
 			    if (sheetObjects[0].SelectHighLight) { // When selected row
				    var selRow=sheetObjects[0].GetSelectRow();
				    if(sheetObjects[0].GetCellValue(selRow,"ibflag")=="I"){
                        // 완전 삭제
						sheetObjects[0].RowDelete(selRow, false);
						sheetObjects[0].SelectCell(selRow,"rcc_cd");
				    }else if(sheetObjects[0].GetCellValue(selRow,"merge_flag").substr(0,1)=="Y"
				    	|| sheetObjects[0].GetCellValue(selRow,"merge_flag").substr(0,1)=="X"
				    		|| sheetObjects[0].GetCellValue(selRow,"merge_flag").substr(0,1)=="N"){
                        // 히든, sts = D
						sheetObjects[0].SelectCell(selRow+1,"rcc_cd");
                        sheetObjects[0].SetCellValue(selRow,"ibflag","D");
//						sheetObjects[0].RowStatus(selRow) = "D";
						for(var j=8; j<sheetObjects[0].LastCol(); j++){ // row --> "0"
							sheetObjects[0].SetCellValue(selRow,j,0 ,0);
						}
						sheetObjects[0].SetRowSumable(selRow , false);  
						sheetObjects[0].SetRowHidden(selRow,1);
						calcSubsum(sheetObjects[0]);
                    }
				}
				break;
			case "btn_close":
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
     * initial event
     */
    function initControl() {
         //axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);                 
         //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);               //form OnBeforeDeactivate
         //axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //enter key event
         //axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);                     
         axon_event.addListenerForm('change','form_change',form);
    }    
    /**
     * IBSheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * 설  명 : IBCombo Object
     * @param {object}  combo_obj - Combo Object
     * @see 
     * @author 
     * @version 
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * body onLoad 
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );       
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        document.form.cntrTpsz.selectedIndex=1; // Dry 
        sheetObjects[0].RenderSheet(0);
        tpszChange('D'); // Dry 
        sheetObjects[0].RenderSheet(1);
        var level_cd=document.form.level_cd.value;
		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
		setSheetCombo(sheetObjects[0]); // sheet Item 
    }
    /**
     * Initialize default sheet value
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
                
              var HeadTitle1="|RCC|LCC||Year|Term|Period|STS|"
              + "Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|Order|"
              + "P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|"
              + "P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|P/Up Approval|"
              + "On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|"
              + "On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|On-Hire Result|"
              + "Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|"
              + "Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|"
              + "Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|"
              + "Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|Balance (On-Hire vs. Order)|"
              + "Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|"
              + "Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|"
              + "Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|"
              + "Balance (Approval vs. Order)|Balance (Approval vs. Order)|Balance (Approval vs. Order)|"
              + "Remark";
              var HeadTitle2="|RCC|LCC||Year|Term|Period|STS|"
              + "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|TTL|"
              + "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|TTL|"
              + "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|TTL|"
              + "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|TTL|"
              + "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|TTL|"
              + "Remark" ;
              HeadTitleCnt=ComCountHeadTitle(HeadTitle1);
              (HeadTitleCnt, 0, 0, true);
              sheetObj.FrozenCols=8;

              SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:7, Page:20, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"x_merge_flag",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"merge_flag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"onh_ord_yr",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_lstm_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lse_prd_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_d2_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_d4_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_d5_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_d7_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_r2_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_r5_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_r9_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_o2_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_s2_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_o4_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_o5_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_s4_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_f2_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_a2_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_f4_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_a4_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"order_f5_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"AutoSum",   Hidden:0, Width:46,   Align:"Right",   ColMerge:0,   SaveName:"order_ttl",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_d2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_d4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_d5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_d7_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_r2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_r5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_r9_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_o2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_s2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_o4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_o5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_s4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_f2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_a2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_f4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_a4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"appr_f5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:46,   Align:"Right",   ColMerge:0,   SaveName:"appr_ttl",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_d2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_d4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_d5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_d7_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_r2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_r5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_r9_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_o2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_s2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_o4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_o5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_s4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_f2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_a2_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_f4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_a4_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rslt_f5_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:46,   Align:"Right",   ColMerge:0,   SaveName:"rslt_ttl",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_d2_qty",  KeyField:0,   CalcLogic:"|order_d2_qty|-|rslt_d2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_d4_qty",  KeyField:0,   CalcLogic:"|order_d4_qty|-|rslt_d4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_d5_qty",  KeyField:0,   CalcLogic:"|order_d5_qty|-|rslt_d5_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_d7_qty",  KeyField:0,   CalcLogic:"|order_d7_qty|-|rslt_d7_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_r2_qty",  KeyField:0,   CalcLogic:"|order_r2_qty|-|rslt_r2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_r5_qty",  KeyField:0,   CalcLogic:"|order_r5_qty|-|rslt_r5_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_r9_qty",  KeyField:0,   CalcLogic:"|order_r9_qty|-|rslt_r9_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_o2_qty",  KeyField:0,   CalcLogic:"|order_o2_qty|-|rslt_o2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_s2_qty",  KeyField:0,   CalcLogic:"|order_s2_qty|-|rslt_s2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_o4_qty",  KeyField:0,   CalcLogic:"|order_o4_qty|-|rslt_o4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_o5_qty",  KeyField:0,   CalcLogic:"|order_o5_qty|-|rslt_o5_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_s4_qty",  KeyField:0,   CalcLogic:"|order_s4_qty|-|rslt_s4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_f2_qty",  KeyField:0,   CalcLogic:"|order_f2_qty|-|rslt_f2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_a2_qty",  KeyField:0,   CalcLogic:"|order_a2_qty|-|rslt_a2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_f4_qty",  KeyField:0,   CalcLogic:"|order_f4_qty|-|rslt_f4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_a4_qty",  KeyField:0,   CalcLogic:"|order_a4_qty|-|rslt_a4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_f5_qty",  KeyField:0,   CalcLogic:"|order_f5_qty|-|rslt_f5_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:46,   Align:"Right",   ColMerge:0,   SaveName:"rsltblnc_ttl",     KeyField:0,   CalcLogic:"|order_ttl|-|rslt_ttl|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_d2_qty",  KeyField:0,   CalcLogic:"|order_d2_qty|-|appr_d2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_d4_qty",  KeyField:0,   CalcLogic:"|order_d4_qty|-|appr_d4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_d5_qty",  KeyField:0,   CalcLogic:"|order_d5_qty|-|appr_d5_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_d7_qty",  KeyField:0,   CalcLogic:"|order_d7_qty|-|appr_d7_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_r2_qty",  KeyField:0,   CalcLogic:"|order_r2_qty|-|appr_r2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_r5_qty",  KeyField:0,   CalcLogic:"|order_r5_qty|-|appr_r5_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_r9_qty",  KeyField:0,   CalcLogic:"|order_r9_qty|-|appr_r9_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_o2_qty",  KeyField:0,   CalcLogic:"|order_o2_qty|-|appr_o2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_s2_qty",  KeyField:0,   CalcLogic:"|order_s2_qty|-|appr_s2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_o4_qty",  KeyField:0,   CalcLogic:"|order_o4_qty|-|appr_o4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_o5_qty",  KeyField:0,   CalcLogic:"|order_o5_qty|-|appr_o5_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_s4_qty",  KeyField:0,   CalcLogic:"|order_s4_qty|-|appr_s4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_f2_qty",  KeyField:0,   CalcLogic:"|order_f2_qty|-|appr_f2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_a2_qty",  KeyField:0,   CalcLogic:"|order_a2_qty|-|appr_a2_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_f4_qty",  KeyField:0,   CalcLogic:"|order_f4_qty|-|appr_f4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_a4_qty",  KeyField:0,   CalcLogic:"|order_a4_qty|-|appr_a4_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_f5_qty",  KeyField:0,   CalcLogic:"|order_f5_qty|-|appr_f5_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"apprblnc_ttl",     KeyField:0,   CalcLogic:"|order_ttl|-|appr_ttl|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"onh_ord_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:500 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetImageList(0,"img/btns_search_off.gif");
              SetImageList(1,"img/btns_search.gif");//popupicon
              SetImageList(2,"img/btns_note.gif");
              SetWaitImageVisible(0);
              SetCountPosition(0);
              SetAutoRowHeight(0);
              //no support[check again]CLT SetSortDialog(false);
              //no support[check again]CLT SetSelectDialog(false);
              //no support[check again]CLT SetExcelColDialog(false);
              InitComboNoMatchText(true);
              //no support[check again]CLT SpeedOption="NOSUM";
              SetSheetHeight(445);
              
      		var order_subsum="order_d2_qty|order_d4_qty|order_d5_qty|order_d7_qty|order_r2_qty|order_r5_qty|order_r9_qty|order_o2_qty|order_s2_qty|order_o4_qty|order_o5_qty|order_s4_qty|order_f2_qty|order_a2_qty|order_f4_qty|order_a4_qty|order_f5_qty|order_ttl";
            var appr_subsum="appr_d2_qty|appr_d4_qty|appr_d5_qty|appr_d7_qty|appr_r2_qty|appr_r5_qty|appr_r9_qty|appr_o2_qty|appr_s2_qty|appr_o4_qty|appr_o5_qty|appr_s4_qty|appr_f2_qty|appr_a2_qty|appr_f4_qty|appr_a4_qty|appr_f5_qty|appr_ttl";                   
            var rslt_subsum="rslt_d2_qty|rslt_d4_qty|rslt_d5_qty|rslt_d7_qty|rslt_r2_qty|rslt_r5_qty|rslt_r9_qty|rslt_o2_qty|rslt_s2_qty|rslt_o4_qty|rslt_o5_qty|rslt_s4_qty|rslt_f2_qty|rslt_a2_qty|rslt_f4_qty|rslt_a4_qty|rslt_f5_qty|rslt_ttl";                       
            var rsltblnc_subsum="rsltblnc_d2_qty|rsltblnc_d4_qty|rsltblnc_d5_qty|rsltblnc_d7_qty|rsltblnc_r2_qty|rsltblnc_r5_qty|rsltblnc_r9_qty|rsltblnc_o2_qty|rsltblnc_s2_qty|rsltblnc_o4_qty|rsltblnc_o5_qty|rsltblnc_s4_qty|rsltblnc_f2_qty|rsltblnc_a2_qty|rsltblnc_f4_qty|rsltblnc_a4_qty|rsltblnc_f5_qty|rsltblnc_ttl";                                    
            var apprblnc_subsum="apprblnc_d2_qty|apprblnc_d4_qty|apprblnc_d5_qty|apprblnc_d7_qty|apprblnc_r2_qty|apprblnc_r5_qty|apprblnc_r9_qty|apprblnc_o2_qty|apprblnc_s2_qty|apprblnc_o4_qty|apprblnc_o5_qty|apprblnc_s4_qty|apprblnc_f2_qty|apprblnc_a2_qty|apprblnc_f4_qty|apprblnc_a4_qty|apprblnc_f5_qty|apprblnc_ttl";                   
            var all_subsum=order_subsum+"|"+appr_subsum+"|"+rslt_subsum+"|"+rsltblnc_subsum+"|"+apprblnc_subsum;
            sheetObj.ShowSubSum([{StdCol:"rcc_cd", SumCols:all_subsum, Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"", AvgCols:""}]);
    		sheetObj.ShowSubSum([{StdCol:"lcc_cd", SumCols:all_subsum, Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"", AvgCols:""}]);
              }
            break;
        }
    }
      // Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSAVE:        
	            if (validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					var sXml=sheetObj.DoSave("EES_EQR_1006GS.do", FormQueryString(formObj), "ibflag");
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") { 
                        ComShowCodeMessage("EQR01020","Saved"); // '{?msg1} Successfully.'
                    }
					ComOpenWait(false);
				}
                break;
           case IBSEARCH:        
                if(years.GetSelectText()== ""){
					ComShowCodeMessage("EQR01102", "Year"); // 'Please select {?msg1}.'
					return false;
                }
                ComOpenWait(true); 
                sheetObjects[0].RenderSheet(0);
                formObj.f_cmd.value=SEARCH;
                var sXml=sheetObj.GetSearchData("EES_EQR_1006GS.do",FormQueryString(formObj));
                sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
                sheetObjects[0].RenderSheet(1);
                ComOpenWait(false);                
                break;
			 case SEARCH02: // RCC_CD 
			     formObj.f_cmd.value=SEARCH02;
 				 var sXml=sheetObj.GetSearchData("EES_EQR_1006GS.do" , FormQueryString(formObj)+"&loc_grp_cd=R");
				 ComXml2ComboItem(sXml, rcc_cd, "code", "name");
				 rccCdList=ComXml2ComboString(sXml,"code","name")[0];
				 rcc_cd.InsertItem(0,"ALL","ALL");
				 rcc_cd.SetSelectText('ALL');
				 break;
			case SEARCH03: // LCC_CD 
                 formObj.f_cmd.value=SEARCH02;
                 var sXml=sheetObj.GetSearchData("EES_EQR_1006GS.do" , FormQueryString(formObj)+"&loc_grp_cd=L"+"&loc_cd="+rcc_cd.GetSelectCode());
                 ComXml2ComboItem(sXml, lcc_cd, "code", "name");
				 if(ComGetTotalRows(sXml)*1>0){
				    lccCdList=ComXml2ComboString(sXml,"code","name")[0];	
				 }
				 lcc_cd.InsertItem(0,"ALL","ALL");
				 lcc_cd.SetSelectText('ALL');
				 break;	 
        }
    }
	// sheet combo option 
	function setSheetCombo(sheetObj){
		var formObj=document.form;
       // RCC
        sheetObj.SetColProperty("rcc_cd", {ComboText:"|"+rccCdList, ComboCode:"|"+rccCdList} );
        // LCC   
        sheetObj.SetColProperty("lcc_cd", {ComboText:"|"+lccCdList, ComboCode:"|"+lccCdList} );
        // Year
		var currYear=document.form.curr_year.value;
		var inserYear=currYear*1 +1;
        var inserItem=" ";            
		for(i=0; i<7; i++) {
             inserItem=inserItem + "|" + (inserYear-i) ;                            
        } 
        sheetObj.SetColProperty("onh_ord_yr", {ComboText:inserItem, ComboCode:inserItem} );
        // Term
        sheetObj.SetColProperty("eq_lstm_cd", {ComboText:"|LT|ST|OW", ComboCode:"|LT|ST|OW"} );
        // Pefiod
        sheetObj.SetColProperty("lse_prd_seq", {ComboText:"|1st|2nd|3rd|4th|5th|6th|7th|8th|9th|10th", ComboCode:"|1|2|3|4|5|6|7|8|9|10"} );
	}
	// process - sheet1 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        //no support[implemented common]CLT sheetObj.SelectHighLight=false;
		sheetObj.SetColBackColor("onh_ord_rmk","#FFFFFF");// rmk backcolor --> white
		// Col TTL 
		calcColTtl(sheetObj, "");
		// Sub Sum 
		calcSubsum(sheetObj);
		// merge Approval/Result value > Order --> red color		
		for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i,"merge_flag")=="Y"){
				for(var t=0; t<consTpszArr.length; t++){
					if(sheetObj.GetCellValue(i,"apprblnc_"+consTpszArr[t].toLowerCase()+"_qty")*1 < 0){
 						sheetObj.SetCellFontColor(i,"appr_"+consTpszArr[t].toLowerCase()+"_qty","#FF0000");
					}
					if(sheetObj.GetCellValue(i,"rsltblnc_"+consTpszArr[t].toLowerCase()+"_qty")*1 < 0){
                         sheetObj.SetCellFontColor(i,"rslt_"+consTpszArr[t].toLowerCase()+"_qty","#FF0000");
                    }	
				}
			}
		}
		sheetObj.SetRowFontColor(sheetObj.LastRow(),"#000000");//  font color --> black
        // When added row in top row that same rcc or lcc with first row.
		if(sheetObj.RowCount("R")>0){
            newRow=sheetObjects[0].DataInsert(0);
            sheetObj.SetRowHidden(newRow,1);
            sheetObj.SetCellValue(newRow,"ibflag","R",0);
		}
    }
    // Calculate column 'TTL' 
    function calcColTtl(sheetObj, row){
		var arr_tpsz=tpsztype.GetSelectText().split(","); //  TP/SZ
		if (row != "") { // sheet1_OnChange 
		     var i=row;
		     if(sheetObj.GetCellValue(i,"merge_flag")=="Y"                     //  Data Row
		    	 ||sheetObj.GetCellValue(i,"merge_flag").substr(0,1)=="N"
		    		 ||sheetObj.GetCellValue(i,"merge_flag").substr(0,1)=="X"){
		    	 var rowSts=sheetObj.GetCellValue(i,"ibflag"); // ibflag
                    var order_tmpSum=0;
                    for(var t=0; t<arr_tpsz.length; t++){
                    	order_tmpSum=order_tmpSum    + sheetObj.GetCellValue(i,"order_"+arr_tpsz[t].toLowerCase()+"_qty")*1;
                    }
                    sheetObj.SetCellValue(i,"order_ttl",order_tmpSum,0);
					sheetObj.SetCellValue(i,"ibflag",rowSts,0);
             }
		}else{	
			for(var i=0; i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
				if(sheetObj.GetCellValue(i,"merge_flag")=="Y"                  // Data Row
					||sheetObj.GetCellValue(i,"merge_flag").substr(0,1)=="N"
						||sheetObj.GetCellValue(i,"merge_flag").substr(0,1)=="X"){
					var rowSts=sheetObj.GetCellValue(i,"ibflag"); // ibflag
                    var order_tmpSum=0;
					var appr_tmpSum=0;
					var rslt_tmpSum=0;
                    for(var t=0; t<arr_tpsz.length; t++){
                    	order_tmpSum=order_tmpSum    + sheetObj.GetCellValue(i,"order_"+arr_tpsz[t].toLowerCase()+"_qty")*1;
                    	appr_tmpSum=appr_tmpSum     + sheetObj.GetCellValue(i,"appr_"+arr_tpsz[t].toLowerCase()+"_qty")*1;
                    	rslt_tmpSum=rslt_tmpSum     + sheetObj.GetCellValue(i,"rslt_"+arr_tpsz[t].toLowerCase()+"_qty")*1;
					}
					sheetObj.SetCellValue(i,"order_ttl",order_tmpSum,0);
					sheetObj.SetCellValue(i,"appr_ttl",appr_tmpSum,0);
					sheetObj.SetCellValue(i,"rslt_ttl",rslt_tmpSum,0);
					sheetObj.SetCellValue(i,"ibflag",rowSts,0);
				}
	        }
		}
	}
    // Calculate total sum and sub sum
    function calcSubsum(sheetObj){
		sheetObj.RenderSheet(0);

        var lcc_subsum_rows=sheetObj.FindSubSumRow("lcc_cd");
        var rcc_subsum_rows=sheetObj.FindSubSumRow("rcc_cd");
        var lcc_subsum_arr=lcc_subsum_rows.split("|");
        var rcc_subsum_arr=rcc_subsum_rows.split("|");
        for(var i=0; i<lcc_subsum_arr.length-1; i++){ // LCC 
        	if(sheetObj.GetCellValue(lcc_subsum_arr[i]-1,"merge_flag").substr(0,1)=="X"){ // Row Add
                sheetObj.SetRowHidden(lcc_subsum_arr[i],1);// hidden subsum row
            }else{
				sheetObj.SetCellValue(lcc_subsum_arr[i],"x_merge_flag","Y",0);// RCC, LCC  merge
	            sheetObj.SetCellValue(lcc_subsum_arr[i],"rcc_cd",sheetObj.GetCellText(lcc_subsum_arr[i]-1,"rcc_cd"),0);
	            sheetObj.SetCellValue(lcc_subsum_arr[i],"lcc_cd",sheetObj.GetCellText(lcc_subsum_arr[i]-1,"lcc_cd"),0);
	            sheetObj.SetCellValue(lcc_subsum_arr[i],4,"S.TOTAL",0);
			}
        }
        for(var i=0; i<rcc_subsum_arr.length-1; i++){ // RCC 
        	if(sheetObj.GetCellValue(rcc_subsum_arr[i]-2,"merge_flag").substr(0,1) =="X"){ // Row Add
                sheetObj.SetRowHidden(rcc_subsum_arr[i],1);// subsum row
            }else{
				sheetObj.SetCellValue(rcc_subsum_arr[i],"x_merge_flag","Y",0);// RCC, LCC  merge
                sheetObj.SetCellValue(rcc_subsum_arr[i],"rcc_cd",sheetObj.GetCellText(rcc_subsum_arr[i]-2,"rcc_cd"),0);
				sheetObj.SetCellValue(rcc_subsum_arr[i],2,"S.TOTAL",0);
			}
        }
		sheetObj.ShowSum();
		if (sheetObj.RowCount("R") > 0) {
			sheetObj.SetCellValue(sheetObj.LastRow(),1,"G.TOTAL",0);
		}
		sheetObj.RenderSheet(1);
	}   
	/**
	* when shee1 clicked
	*/
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
		var level_cd=document.form.level_cd.value;
		with (sheetObj) {
			if (GetCellValue(Row, "merge_flag").substr(0,1) == "X") {
				InitDataProperty(0, 1, dtCombo, 60, daCenter, true, "rcc_cd", true, "", dfNone, 0, false, false);
				InitDataProperty(0, 2, dtCombo, 60, daCenter, true, "lcc_cd", true, "", dfNone, 0, false, false);
			}else{
				InitDataProperty(0, 1, dtData, 60, daCenter, true, "rcc_cd", true, "", dfNone, 0, false, false);
				InitDataProperty(0, 2, dtData, 60, daCenter, true, "lcc_cd", true, "", dfNone, 0, false, false);
			}
			if(ColSaveName(Col)=="onh_ord_rmk"){
				ComShowMemoPad(sheetObj, Row, Col, false, 230, 200, 500);
			}
		}
	}
    /**
     * when sheet1 changed.
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
         calcSubsum(sheetObj);
		 var formObj=document.form;
		 with (sheetObj) {
		 	  var colName=ColSaveName(Col);
		 	  switch (colName) {
			  	case "rcc_cd":
					  if(Value == ""){
						  CellComboItem(Row,"lcc_cd", {ComboText:"", ComboCode:""} );
					  }else if(GetCellValue(Row,"merge_flag").substr(0,1)=="X"){
						   formObj.f_cmd.value=SEARCH02;
                           var sXml=sheetObj.GetSearchData("EES_EQR_1006GS.do" , FormQueryString(formObj)+"&loc_grp_cd=L"+"&loc_cd="+Value);
                           var tmpLccCdList=ComXml2ComboString(sXml,"code","name")[0];
                           CellComboItem(Row,"lcc_cd", {ComboText:"|"+tmpLccCdList, ComboCode:"|"+tmpLccCdList} );
					  }
				      break;   
				default:
				    // Col TTL 
                    calcColTtl(sheetObj, Row);	  
					break;
			  }
         }
     }
	/**
	* when shee1 clicked 
	*/
	function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y)  {
		if(Button==1) {   
			if (sheetObj.GetCellValue(sheetObj.MouseRow(), "merge_flag").substr(0, 1) == "Y" ||
					sheetObj.GetCellValue(sheetObj.MouseRow(), "merge_flag").substr(0, 1) == "N" ||
					sheetObj.GetCellValue(sheetObj.MouseRow(), "merge_flag").substr(0, 1) == "X") {
//no support[implemented common]CLT 				sheetObj.SelectHighLight=true;
			}else{
//no support[implemented common]CLT 			    sheetObj.SelectHighLight=false;
			}
		}else if(Button==2) {  
            //no support[implemented common]CLT sheetObj.SelectHighLight=false;
		}   
	}
    /**
     * Default combo setup <br>
     * @param {object}  comboObj - Combo Object
     * @param {Number}  comboNo  - Combo Number
     * @see #
     * @author 
     * @version 2009.01.01
     */
    function initCombo (comboObj, comboNo) {
        var cnt=0 ;
        switch(comboNo) {   
		    // Years
            case 1:
                with (comboObj) {               
                    SetDropHeight(12 * 20);
					var currYear=document.form.curr_year.value;
					var inserYear=currYear*1 +1;
                    SetMultiSelect(1);
                    SetMaxSelect(7);
                    SetMultiSeparator(",");
					for(i=0; i<7; i++) {
                        InsertItem(cnt++, inserYear-i+"", inserYear-i);                            
                    } 
					comboObj.SetSelectText(currYear);
                }
                break;
			// RCC_CD
            case 2:
                with (comboObj) {               
                    SetDropHeight(12 * 20);
                    SetMultiSelect(0);
                }
                break;
			// LCC_CD
            case 3:
                with (comboObj) {               
                    SetDropHeight(12 * 20);
                    SetMultiSelect(0);
                }
                break;
            // CNTR Type Size
            case 4:
                with (comboObj) {               
                    SetDropHeight(12 * 20);
                    var menuname=tpszallText.split('|'); 
                    var menucode=tpszallCode.split('|'); 
                    SetMultiSelect(1);
                    SetMaxSelect(menuname.length);
                    SetMultiSeparator(",");
                    for(i=0; i<menuname.length; i++) {
                        InsertItem(cnt++, menuname[i], menucode[i]);                            
                    } 
                }
                break;
        }
    }
    /**
     * validate input value
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(sheetObj){
            switch (sAction) {
            case IBSAVE:
                // 중복체크
                var dupRow=ColValueDup("onh_ord_yr|lcc_cd|eq_lstm_cd|lse_prd_seq");
                if(dupRow != -1) {
                    ComShowCodeMessage("EQR01015"); // 'There are duplicated row with same condition. Please update data on the pre-created row.'
                    return false;
                }
				// 수량체크
				for(var i=HeaderRows(); i<HeaderRows()+RowCount(); i++){
					if(GetCellValue(i,"ibflag")=="I" || GetCellValue(i,"ibflag")=="U"){
						var tmpSum=0;
						for(var j=0; j<consTpszArr.length; j++){
							tmpSum=tmpSum + GetCellValue(i,"order_"+consTpszArr[j].toLowerCase()+"_qty")*1;
						}
						if(tmpSum == 0){
							ComShowCodeMessage("EQR01019"); // 'Total Quantity is zero.'
							SelectCell(i,"order_"+consTpszArr[0].toLowerCase()+"_qty");
							return false;
						}
					}
				}
				break;
			case IBSEARCH:
			    if(years.GetSelectText()== ""){
					ComShowCodeMessage("EQR01102", "Year"); // 'Please select {?msg1}.'
					return false;
				}
            }
        }
        return true;
    }  
    /**
     * Change typ size <br>
     * @param {String}  key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
     * @see #
     * @author 
     * @version 2009.01.01
     */
    function tpszChange(key){
        switch (key) {
        case "":
        	tpsztype.SetSelectCode(-1);
            tpsztype.SetSelectCode(consTpsz);
            break;
        case "D":
        	tpsztype.SetSelectCode(-1);
            tpsztype.SetSelectCode(consTpszDry);
            break;
        case "R":
        	tpsztype.SetSelectCode(-1);
            tpsztype.SetSelectCode(consTpszRfr);
            break;
        case "O":
        	tpsztype.SetSelectCode(-1);
            tpsztype.SetSelectCode(consTpszOt);
            break;
        case "F":
        	tpsztype.SetSelectCode(-1);
            tpsztype.SetSelectCode(consTpszFr);
            break;
        }
    }
    /**
     * Form object's change event <br>
     * @see #
     * @author 
     * @version 2009.01.01
     */
    function form_change(){
        var srcName=ComGetEvent("name");
        switch(srcName){
            case "cntrTpsz":
            	sheetObjects[0].RenderSheet(0);
                var index=document.form.cntrTpsz.selectedIndex;
                tpszChange(document.form.cntrTpsz.options[index].value);
                sheetObjects[0].RenderSheet(1);
		        break;
			case "eq_lstm_cd":
			case "lse_prd_seq":
			    //sheetObjects[0].RemoveAll();
				//setSearchFlag(false);
			    break;
		}
    }
	function years_OnChange(){
		//sheetObjects[0].RemoveAll();
		//setSearchFlag(false);
	}
    function rcc_cd_OnChange() {
		//sheetObjects[0].RemoveAll();
        doActionIBSheet(sheetObjects[0],document.form,SEARCH03);
		//setSearchFlag(false);
    }    
	function lcc_cd_OnChange(){
        //sheetObjects[0].RemoveAll();
		//setSearchFlag(false);
    }
    function tpsztype_OnChange(){
        setGridHidden(tpsztype.GetSelectText());
		// Col TTL 
        calcColTtl(sheetObjects[0], "");
    }
    /*
     * Container Type/Size --> grid column to hidden
     * Called from OnloadPage,OnSearchEnd event
     * @param {String} tpsz_cd
     */
    function setGridHidden(tpsz_cd){
        var sheetObj=sheetObjects[0]; 
        var arr_tpsz=tpsz_cd.split(",");
        for(var i=0;i<consTpszArr.length;i++){ //full container Type/Size       
            for(var j=0;j<arr_tpsz.length;j++){ //selected container Type/Size
                if(consTpszArr[i] == arr_tpsz[j]){
                    sheetObj.SetColHidden("order_"+consTpszArr[i].toLowerCase()+"_qty",0);
					sheetObj.SetColHidden("appr_"+consTpszArr[i].toLowerCase()+"_qty",0);
					sheetObj.SetColHidden("rslt_"+consTpszArr[i].toLowerCase()+"_qty",0);
					sheetObj.SetColHidden("rsltblnc_"+consTpszArr[i].toLowerCase()+"_qty",0);
					sheetObj.SetColHidden("apprblnc_"+consTpszArr[i].toLowerCase()+"_qty",0);
                    break;
                }else if(j==arr_tpsz.length-1){ 
                    sheetObj.SetColHidden("order_"+consTpszArr[i].toLowerCase()+"_qty",1);
                    sheetObj.SetColHidden("appr_"+consTpszArr[i].toLowerCase()+"_qty",1);
                    sheetObj.SetColHidden("rslt_"+consTpszArr[i].toLowerCase()+"_qty",1);
                    sheetObj.SetColHidden("rsltblnc_"+consTpszArr[i].toLowerCase()+"_qty",1);
                    sheetObj.SetColHidden("apprblnc_"+consTpszArr[i].toLowerCase()+"_qty",1);
                }
            }       
        }  
    }    
