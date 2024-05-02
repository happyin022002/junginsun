/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0045.js
*@FileTitle  : RDR Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16  
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class VOP_OPF_0045 : VOP_OPF_0045 business script for
     */
   	/* Developer performance	*/
 // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var gHeadLength=0;
    var firstFlag=true;
	var arrPreCond=new Array("", "", "", "");
	var enableButton=new Array("btn_Mail", "btn_Print");
	var bRetrive=false;    
	var marrTabTitle=new Array(	"VSL Mvmt","Add Slot","Slot/WGT Util","A K","B/B", "HC/45'","RF","DG","VSL Alloc.","Slot Rel.","Slot Swap", "Load", "IPC Over Used","Remark(s)");
    var marrTabTitleKey=new Array("VSL_Mvmt","Add_Slot","SlotWGT_Util","AK","BB", "HC45","RF","DG","VSL_Alloc","Slot_Rel","Slot_Swap", "Load", "IPC_Over_Used","Remark");
    // Event handler processing by button click event */
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source 
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }


    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo, headTitleList) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
        
            case "t3sheet1":    //vop_opf_0045.js, vop_opf_0045_07.js, vop_opf_0045_Dtl.js 
                with(sheetObj){
					var HeadTitle1="|Operator|Full|Empty|Additional\n(AK/BB)|Additional\n(HC/45')|Total Used Slot|Total Used Slot";
					var HeadTitle2="|Operator|Full|Empty|Additional\n(AK/BB)|Additional\n(HC/45')|Slot (TEU)|Weight (Ton)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t3sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:190,  Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix+"full",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix+"empty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix+"akbb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix+"hc45",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix+"total_slot", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:prefix+"total_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetHeaderRowHeight(20);
					SetRowHeight(0,20);
					SetRowHeight(1,20);
					SetSheetHeight(420);
              }
                break;
                
            case "t4sheet1":
                with(sheetObj){
					var HeadTitle1="|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo";
					var HeadTitle2="|Operator|POL|POD|CNTR No.|Type/Size|Cell No.|OF|OA|OP|OS|OH|Void (TEU)|Weight (Ton)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t4sheet1_";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"type_size", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cell_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ovf",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"oa",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"op",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"os",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"oh",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"void_teu",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"weight",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
                }
                break;
                
            case "t5sheet1":
                with(sheetObj){
					var HeadTitle1="|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo|Break Bulk Cargo";
					var HeadTitle2="|Operator|POL|POD|CNTR No.|Type/Size|Cell No.|Dimension|Dimension|Dimension|Weight|Slot|Crane|Working (fm)|Working (to)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t5sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"type_size", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cell_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dml",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dmb",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dmh",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"weight",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"slot",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crane",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fm_work",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"to_work",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
                }
                break;
                
            case "t6sheet1":
                with(sheetObj){
					var HeadTitle1="|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR|High Cubic & 45’ CNTR";
					var HeadTitle2="|Operator|20 High Cubic|20 High Cubic|20 High Cubic|20 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|45’|45’|45’|45’|45’|Ratio Type";
					var HeadTitle3="|Operator|Loaded|BSA\n(T)|Over Ratio\n(T)|Add Slot\n(T)|Loaded|BSA\n(F)|Over Ratio\n(F)|Add Slot\n(T)|Loaded|BSA\n(F)|Under Ratio\n(F)|Over Ratio\n(F)|Add Slot\n(T)|Ratio Type";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t6sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"load_20",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc20_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc20_rate",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"add_20",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"load_40",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc40_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc40_rat",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"add_40",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"load_45",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bsa_45",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:prefix+"un_rat_45",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ov_rat_45",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"add_45",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ratio_type", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
                }
                break;
                
            case "t7sheet1":
                with(sheetObj){
					var HeadTitle1="|Main Trade|Main Trade|Main Trade|Main Trade|Main Trade";
					var HeadTitle2="|Operator|POL|POD|20ft Qty|40ft Qty";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t7sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"opr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"qty_20", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"qty_40", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
                }
                break;
                
            case "t7sheet2":
                with(sheetObj){
					var HeadTitle1="|Inter Port|Inter Port|Inter Port|Inter Port|Inter Port";
					var HeadTitle2="|Operator|POL|POD|20ft Qty|40ft Qty";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t7sheet2_";
					
					SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"opr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"qty_20", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"qty_40", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
                    }
                break;
                
            case "t8sheet1":
                with(sheetObj){
					var HeadTitle1="|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo|Dangerous Cargo";
					var HeadTitle2="|Operator|POL|POD|CNTR No.|Type/Size|Cell No.|IMO|UN No.|Weight (Ton)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t8sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"opr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"type_size", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cell_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"imo",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"un_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"weight",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
                }
                break;
                
            case "t9sheet1":
                with(sheetObj){
					var HeadTitle1="|Operator|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Weight\nper TEU|BSA\nType";
					var HeadTitle2="|Operator|Basic Slot|Slot Swap|Slot Release|TTL Allocation|Basic Weight|Weight Swap|Weight Release|TTL Weight|Weight\nper TEU|BSA\nType";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var headCount2=ComCountHeadTitle(HeadTitle2);
					var prefix="t9sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"basic_slot",   KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"swap_slot",    KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"release_slot", KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tot_alloc",    KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"basic_wgt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"swap_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"release_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 },
					 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tot_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 },
					 {Type:"AutoSum",   Hidden:0,  Width:90,  Align:"Right",   ColMerge:0,   SaveName:prefix+"teu_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bsa_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetColProperty(prefix+"bsa_type", {ComboText:"Fixed|Used", ComboCode:"F|U"} );
					SetMergeCell(0, 10, 2, 1);
					SetMergeCell(0, 11, 2, 1);
					SetSheetHeight(420);
            	}
                break;
                
            case "t10sheet1":
                with(sheetObj){
					var HeadTitle1="|Slot Release|Slot Release|Slot Release|Slot Release|Slot Release|Slot Release|Slot Release";
					var HeadTitle2="|From Carrier|From Carrier|To Carrier|To Carrier|TEU|Weight (Ton)|Type";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t10sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fm_carr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fm_carr_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"to_carr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"to_carr_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:prefix+"teu",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:prefix+"weight",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 },
					 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetColProperty(prefix+"type", {ComboText:"Fixed|Used", ComboCode:"F|U"} );
					SetSheetHeight(420);
            	}
                break;
                
            case "t11sheet1":
                with(sheetObj){
					var HeadTitle1="|Slot Swap|Slot Swap|Slot Swap|Slot Swap|Slot Swap|Slot Swap|Slot Swap";
					var HeadTitle2="|Seq.|From|From|To|To|TEU|Weight (Ton)";
					var HeadTitle3="|Seq.|Carrier Code|VVD|Carrier Code|VVD|TEU|Weight (Ton)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t11sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fm_carr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fm_vsl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"to_carr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"to_vsl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"teu",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"weight",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, ApproximateType:2 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetSheetHeight(420);
                }
                break;
                
            case "t12sheet1":    // vop_opf_0045.js
            	break;
            	
            case "t13sheet1":
                with(sheetObj){
					var HeadTitle1="|Operator|From Port|To Port|BSA (+ Slot Swap)|BSA (+ Slot Swap)|Used Slot|Used Slot|Slot(TEU)|WGT(TEU)|Slot Release|Slot Release|Settlement|Settlement";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t13sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:72,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:72,   Align:"Center",  ColMerge:1,   SaveName:prefix+"from_pod",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:72,   Align:"Center",  ColMerge:1,   SaveName:prefix+"to_pod",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:72,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bsa_slot",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:72,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bsa_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:72,   Align:"Right",   ColMerge:1,   SaveName:prefix+"used_slot",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:72,   Align:"Right",   ColMerge:1,   SaveName:prefix+"used_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:172,  Align:"Right",   ColMerge:1,   SaveName:prefix+"over_slot",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:172,  Align:"Right",   ColMerge:1,   SaveName:prefix+"over_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:72,   Align:"Right",   ColMerge:1,   SaveName:prefix+"release_slot",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:72,   Align:"Right",   ColMerge:1,   SaveName:prefix+"release_wgt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:72,   Align:"Right",   ColMerge:1,   SaveName:prefix+"over_set_slot", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:72,   Align:"Center",  ColMerge:1,   SaveName:prefix+"over_set_by",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetHeaderRowHeight(20);
					SetColProperty(prefix+"over_set_by", {ComboText:"Fixed|Used", ComboCode:"F|U"} );
					SetSheetHeight(420);
            	}
                break;
                
            case "t14sheet1":   // vop_opf_0045.js
                break;
        }
    }
  
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			 SetColBackColor("t1sheet1_port","#CCFFFD");
			 
	  	      if(sheetObj.RowCount()> 0){
	  			for( var k=0; k < enableButton.length; k++){
					ComBtnEnable(enableButton[k]);
				}
	  	      }else{
	  			for( var k=0; k < enableButton.length; k++){
					ComBtnDisable(enableButton[k]);
				}
	  	      }
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		 	SetColBackColor("t2sheet1_pol","#CCFFFD");
		    SetColBackColor("t2sheet1_pod","#CCFFFD");
		    SetSumText(0, "t2sheet1_pol","Total");
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		 	 SetColBackColor("t3sheet1_opr_cd","#CCFFFD");
		 	 SetSumText(0, "t3sheet1_opr_cd","TTL");
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		   SetColBackColor("t4sheet1_opr_cd","#CCFFFD");
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		    SetColBackColor("t5sheet1_opr_cd","#CCFFFD");
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t6sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		    SetColBackColor("t6sheet1_opr_cd","#CCFFFD");
		    SetSumText(0, "t6sheet1_opr_cd","Total");
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
		    SetColBackColor("t7sheet1_opr_cd","#CCFFFD");
		    SetSumText(0, "t7sheet1_opr_cd","Total");
		    SetSumText(0, "t7sheet1_pol","Total");
		    SetSumText(0, "t7sheet1_pod","Total");
			SetRowMerge(LastRow(),1);
			
	  	      if(sheetObj.RowCount()> 0){
	  			for( var k=0; k < enableButton.length; k++){
					ComBtnEnable(enableButton[k]);
				}
	  	      }else{
	  			for( var k=0; k < enableButton.length; k++){
					ComBtnDisable(enableButton[k]);
				}
	  	      }			
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t7sheet2_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
	        SetColBackColor("t7sheet2_opr_cd","#CCFFFD");
	        SetSumText(0, "t7sheet2_opr_cd","Total");
	        SetSumText(0, "t7sheet2_pol","Total");
	        SetSumText(0, "t7sheet2_pod","Total");
			SetRowMerge(LastRow(),1);
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t8sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
	       SetColBackColor("t8sheet1_opr_cd","#CCFFFD");
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t9sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
	        SetColBackColor("t9sheet1_opr_cd","#CCFFFD");
	        SetSumText(0, "t9sheet1_opr_cd","Total");
		}
	}
	/**
	 * Event occured after retrieving by retrieve method
	 */
	function t12sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			//CellValue2(LastRow, "t12sheet1_cntr_type") = CellValue(LastRow, "t12sheet1_cntr_size");
			if(RowCount()> 1){
				SetMergeCell(LastRow()-5,1,6,2);
				SetMergeCell(LastRow()-5,3,5,1);
				
				var findIndex = 2;
				var findRow = 0;
				while(findRow != -1){
					findRow = FindText(3 , "WEIGHT" , findIndex);
					SetMergeCell(findRow,3,1,2);
					findIndex = findRow+1;
					
				}
				
			}
		}
	}   
    
	function updateSheetSize(sheetObj){
	  	  if(typeof sheetObj == "undefined") {
	  		  sheetObj = sheetObjects[0];
	  	  }    	  
	  	  var obj = $("#" + sheetObj.id).offset();
	  	  var marginDefault = 160;
	  	  var marginHeight = obj.top + marginDefault;
	  	  var winHeight = $(parent.window).height();
	  	  var sheetHeight = winHeight - marginHeight;

	  	  with(sheetObj){
	  		  ComResizeSheet(sheetObjects[0]);
	  		  ComResizeSheet(sheetObjects[1]);
	  		  ComResizeSheet(sheetObjects[2]);
	  		  ComResizeSheet(sheetObjects[3]);
	  		  ComResizeSheet(sheetObjects[4]);
	  		  ComResizeSheet(sheetObjects[5]);
	  		  ComResizeSheet(sheetObjects[6]);
	  		  ComResizeSheet(sheetObjects[7]);
	  		  ComResizeSheet(sheetObjects[8]);
	  		  ComResizeSheet(sheetObjects[9]);
	  		  ComResizeSheet(sheetObjects[10]);
	  		  ComResizeSheet(sheetObjects[11]);
	  		  ComResizeSheet(sheetObjects[12]);
	  		  ComResizeSheet(sheetObjects[13]);
	  		//SetSheetHeight(sheetHeight > 90?sheetHeight-80:90);
	  	  }    
	  }  
	/* Developer performance  end */