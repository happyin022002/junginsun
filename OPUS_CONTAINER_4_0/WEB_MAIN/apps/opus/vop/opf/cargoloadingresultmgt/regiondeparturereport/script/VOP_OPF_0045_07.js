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
        
            case "t7sheet1":    //vop_opf_0045.js, vop_opf_0045_07.js, vop_opf_0045_Dtl.js 
                with(sheetObj){
					var HeadTitle1="|Main Trade|Main Trade|Main Trade|Main Trade|Main Trade";
					var HeadTitle2="|Operator|POL|POD|20ft Qty|40ft Qty";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t7sheet1_";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
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
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
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
	  		//SetSheetHeight(sheetHeight > 90?sheetHeight-80:90);
	  	  }    
	  }  
	/* Developer performance  end */