﻿﻿﻿﻿﻿﻿/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0006.js
*@FileTitle  :  COP Detail Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
 =========================================================*/

// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
    function processButtonClick(){
    	/***** Setting variable over two sheet at tab *****/
         var sheetObj=sheetObjects[0];
         var sheetObj2=sheetObjects[1];
         var sheetObj3=sheetObjects[2];
         var sheetObj4=sheetObjects[3];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    	    if(ComGetBtnDisable(srcName)) return false;
			formObj.clickBtnNm.value=srcName;
			formObj.cntr_no.value=formObj.cntr_no_v.value;
            switch(srcName) {
        	    case "btn_retrieve":
        	       if(validateForm(null,formObj,IBSEARCH)){
        	           doActionIBSheet(sheetObj,formObj,IBSEARCH);
        	           doActionIBSheet(sheetObj2,formObj,IBSEARCH);
        	           doActionIBSheet(sheetObj3,formObj,IBSEARCH);
        	           doActionIBSheet(sheetObj4,formObj,IBSEARCH_ASYNC03);
        	       }
        	       break;
        	    case "btn_new":
    	            sheetObj.RemoveAll();
    	            formObj.reset();
    	            formObj.cntr_no.value="" ;
    	            formObj.cntr_no_v.value="";
    	            formObj.cop_mst_bkg.value="";
    	            formObj.bkg_no_tmp.options.length=0;
    	            sheetObj.RemoveAll();
    	            sheetObj2.RemoveAll();
    	            sheetObj3.RemoveAll();
    	            sheetObj4.RemoveAll();
        	        break;
        	    case "btn_copchange":

                    if(!ComIsEmpty(formObj.cop_no)) {
						if( formObj.cop_sub_sts_cd.value == "R" && formObj.cop_sts_cd.value == "F" ) {
						} else {
							if(formObj.cop_sts_cd.value == "X"){
								ComShowMessage(ComGetMsg('SCE90047')) ;
								return ;									
							} else if(ComIsEmpty( formObj.act_cd.value)) {
								ComShowMessage(ComGetMsg('SCE90012')) ;
								return ;
							} 
						}
						 
						openESD_SCE_0053(formObj);
					}else {
						ComShowMessage(ComGetMsg('COM12114', 'COP No')) ;
					}
					break;
        	    case "t1btng_save":
    	            doActionIBSheet(sheetObj,formObj,IBSAVE);
        	        break;
				case "btn_manualclose":
        	        break;
				// minestar - cop_history start
				case "btn_history":
					if(!ComIsEmpty(formObj.cop_no)) {
						openESD_SCE_0071(formObj);
					 }
					 break;
				// minestar - cop_history end
				case "btn_bkginfo":
        	        if(validateForm(null,formObj,IBSEARCH)){
                        setCopValues(formObj.bkg_no_tmp) ;
                        var paramUrl="pgmNo=ESD_SCE_0915&cop_no="+formObj.cop_no.value+"&bkg_no="+formObj.bkg_no.value;
				        var newWin= ComOpenWindow("ESD_SCE_0915.do?"+paramUrl,  "bkg_info_win",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:430px" , true);
        	        }
        	        break;
		  		case "btn_clm":
			  		goESD_SCE_0044(sheetObj) ;
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
					break;
				case "btn_manualReplan":
					doActionIBSheet(sheetObjects[3], formObj, IBSEARCH_ASYNC04);
	    			break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111')) ;
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    //function openESD009Screen(openStr){
    //	window.open (openStr, "list2", " scrollbars=no,fullscreen=no,width=1020,height=550");
    //}
    function openESD009Screen(url, copNo, boundName, iscompled, isnodchg, nodcd, isfrmchg, frmcd, bkg_no, cop_sts_cd){
    	//window.open(openStr, "list2", "scrollbars=no,fullscreen=no,width=1020,height=560");
    	newForm="<form name='form1' method='post'>" ;
    	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0009'>" ;	
    	newForm += "  <input type='hidden' name='cop_no' value='"+copNo+"'>" ;
    	newForm += "  <input type='hidden' name='bound_name'  value='"+boundName+"'>" ;
    	newForm += "  <input type='hidden' name='iscompled'  value='"+iscompled+"'>" ;
    	newForm += "  <input type='hidden' name='isnodchg'  value='"+isnodchg+"'>" ;
    	newForm += "  <input type='hidden' name='nodcd'  value='"+nodcd+"'>" ;
    	newForm += "  <input type='hidden' name='isfrmchg'  value='"+isfrmchg+"'>" ;
    	newForm += "  <input type='hidden' name='frmcd'  value='"+frmcd+"'>" ;
    	newForm += "  <input type='hidden' name='bkg_no'  value='"+bkg_no+"'>" ;
    	newForm += "  <input type='hidden' name='cop_sts_cd'  value='"+cop_sts_cd+"'>" ;
    	newForm += "</form>"
    	//document.all.new_form.innerHTML=newForm ;
    	document.body.innerHTML =newForm ;
    		//var formObj = document.form1 ;
    	var formObj=document.form1;
    	var paramUrl="pgmNo=ESD_SCE_0009&cop_no="+copNo+"&bound_name="+boundName+"&iscompled="+iscompled+"&isnodchg="+isnodchg+"&nodcd="+nodcd+
    	"&isfrmchg="+isfrmchg+"&frmcd="+frmcd+"&bkg_no="+bkg_no+"&cop_sts_cd="+cop_sts_cd;
    	
//    	var newWin  = window.open("","cop_manual_change", "width=1020,height=560," + getCenterXY(1020, 560));
    	//var newWin= ComOpenWindow("ESD_SCE_0009.do?"+paramUrl,  "Popup",  "width=916, height=730, scrollbars=no", false);
    	window.open("ESD_SCE_0009.do?"+paramUrl,  "Popup",  "width=916, height=730, scrollbars=no");
    	
//    	formObj.method = "post";
//    	formObj.action = url ;
//    	formObj.target = "cop_manual_change" ;
//    	formObj.submit() ;	
    }
    function researchScreen(){
    	/***** Setting variable over two sheet at tab *****/
         var sheetObj=sheetObjects[0];
         var sheetObj2=sheetObjects[1];
         var sheetObj3=sheetObjects[2];
         var sheetObj4=sheetObjects[3];
         /*******************************************************/
         var formObj=document.form;
    	try {
	           doActionIBSheet(sheetObj,formObj,IBSEARCH);
	           doActionIBSheet(sheetObj2,formObj,IBSEARCH);
	           doActionIBSheet(sheetObj3,formObj,IBSEARCH);
	           doActionIBSheet(sheetObj4, formObj, IBSEARCH_ASYNC03);
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111')) ;
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
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        ComSetUIItem(sheetObjects[0], document.form, "SCE", "ESD_SCE_0006");
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
        	case 1:      //IBSheet1 init
                   with(sheetObj){
					 var HeadTitle="STS|SEQ|Expt|COP DTL SEQ|Activities\nCode|Activity|VVD|Location|Planned\nDate / Time|Planned\nDate / Time|Estimated\nDate / Time|Estimated\nDate / Time|Actual\nDate / Time|Actual\nDate / Time|Actual Data\nSource|Exception NO|Exception\nType Code" ;
					 SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataGetRowMerge:1 } );
					 var info={ Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					 var headers=[ { Text:HeadTitle, Align:"Center"} ];
					 InitHeaders(headers, info);
					 var cols=[ {Type:"Status",    Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"Seq",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Image",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cop_expt_sts",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cop_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"act_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pln_date",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pln_time",             KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"estm_date",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"estm_time",            KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"act_date",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"act_time",             KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"act_rcv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cop_expt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cop_expt_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rail_rcv_coff_fm_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"act_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"expt_info",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }  ];
					 InitColumns(cols);
					 SetEditable(1);
					 SetImageList(0,"/opuscntr/img/opus/ico_b.gif");
					 SetImageList(1,"/opuscntr/img/opus/ico_g.gif");
					 SetImageList(2,"/opuscntr/img/opus/ico_r.gif");						 
					 resizeSheet(); 
                  }
                break;
            case 2:      //IBSheet3 init
                with(sheetObj){
		            var HeadTitle="Seq.|Activity Group|S/O Office|Service Provider|S/O Status|S/O No|From - To|S/O Date|User ID|S/P Contact No.|S/O Remark1|S/O Remark2|S/O Remark3|W/O No.|W/O Date" +
		                          "|Rail\nRoad|Billing EDI\nSent Time|Billing EDI\nSent Time|Bill\nACK/NCK|Bill ACK/NCK\nReceived Time|Bill ACK/NCK\nReceived Time|Bill ACK/NCK\nError Remark|Waybill\nNo|DELT USR ID|DELT Date" ;
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataGetRowMerge:1 } );
		            var info={ Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers=[ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols=[ {Type:"Seq",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cost_act_grp_nm",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"ctrl_ofc_cd",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"vndr_abbr_nm",         		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"trsp_so_sts",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"so_num",               		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"fm_to",                		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"so_dt",                		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"user_id",              		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"sp_h_no",              		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"so_rmk1",              		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"so_rmk2",              		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"so_rmk3",              		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"wo_no",                		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"wo_dt",                		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"rail_vndr_nm",         		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bil_edi_snt_dt",       		KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bil_edi_snt_dt_hms",   		KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"bil_edi_rcv_rslt_cd", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bil_edi_rcv_rslt_dt",  		KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bil_edi_rcv_rslt_dt_hms",	KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cxl_rqst_rjct_rsn",    		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no",               		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"delt_usr_id",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"delt_dt",              		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rail_flg",               	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }  ];
		            InitColumns(cols);
		            SetEditable(1);
					SetSheetHeight(310);
                }
                break;
               case 3:      //IBSheet4 init
                   with(sheetObj){
					  var HeadTitle="Activity|Movement|Location|Planned|Planned|Estimated|Estimated|Actual|Actual|Actual Source|COP||" ;
					  SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataGetRowMerge:1 } );
					  var info={ Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					  var headers=[ { Text:HeadTitle, Align:"Center"} ];
					  InitHeaders(headers, info);
					  var cols=[ {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"act_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pln_dt1",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pln_dt2",        KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"estm_dt1",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"estm_dt2",       KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"act_dt1",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"act_dt2",        KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"edi_msg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"copyn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cop_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:1,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"sort_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }  ];
					  InitColumns(cols);
					  SetEditable(0);					  
					  SetSheetHeight(310);
               }
                break;
               case 4:	  //IBSheet1 init
                  	with(sheetObj){
              			var HeadTitle0="  |By BKG INFO|RegenPC|COP NO|BKG NO|MST COP NO|PCTL NO|RESULT";
              			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );
              			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
              			var headers = [ { Text:HeadTitle0, Align:"Center"} ];
              			InitHeaders(headers, info);
              			
              			var cols = [{Type:"Status",    Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              						{Type:"CheckBox",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_info",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              						{Type:"CheckBox",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"regen_pc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mst_cop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              						{Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"pctl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rpln_rslt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
              			
              			InitColumns(cols);
              			SetVisible(0);
              			SetSheetHeight(310);
              		}
              	break;
        }
    }
    // handling process of sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        var formObj=document.form ;
        switch(sAction) {
           case IBSEARCH:      //retrieving
                if ( sheetObj.id == "t1sheet1" ){
                    formObj.f_cmd.value=SEARCHLIST01 ;
                    formObj.target="_self" ;
                    var sXml=sheetObj.GetSearchData("ESD_SCE_0006GS.do", SceFrmQryString(formObj));
            		sheetObj.LoadSearchData(sXml,{Sync:1} );
            		
                    ComEtcDataToForm(formObj,sheetObj) ; //adding ETC_DATA
        			setCopExptSts(sheetObj);                   
        			changeColor(sheetObj);
                }
                else if ( sheetObj.id == "t2sheet1" ){
                    formObj.f_cmd.value=SEARCHLIST02 ;
                    formObj.target="_self" ;
                    sheetObj.DoSearch("ESD_SCE_0006GS.do",SceFrmQryString(formObj)  );
                }
                else if ( sheetObj.id == "t3sheet1" ) {
                    formObj.f_cmd.value=SEARCHLIST03 ;
                    formObj.target="_self" ;
                    sheetObj.DoSearch("ESD_SCE_0006GS.do",SceFrmQryString(formObj)  );
                }
                else if ( sheetObj.id == "t4sheet1" ) {
                    formObj.f_cmd.value=SEARCHLIST04 ;
                    formObj.target="_self" ;
                    sheetObj.DoSearch("ESD_SCE_0006GS.do",SceFrmQryString(formObj)  );
                }
                break;
            case IBSAVE:        //saving
	              if(validateForm(sheetObj,formObj,sAction)){
	              	formObj.f_cmd.value=MODIFY ;
	                formObj.target="_self" ;
	                formObj.estm_act_dt.value=sheetObj.GetCellEditable(1, "estm_date")?"E":"A" ;
	                
	                var sParam=FormQueryString(formObj);
					var sParamSheet1=sheetObj.GetSaveString();
					sParam += "&" + sParamSheet1;
					var sXml=sheetObj.GetSaveData("ESD_SCE_0006U.do", sParam);
					sheetObj.LoadSaveData(sXml);
	              }
	              break;
           case IBDOWNEXCEL:        //download to excel
        	   if(sheetObj.RowCount() < 1) {//no data	
        			ComShowCodeMessage("COM132501");
        		} else {
        			 sheetObj.Down2Excel({ HiddenColumn:true});   
        		}	
              break;
		   case IBSEARCH_ASYNC03: // CopReplan list 조회
			    if(!ComIsEmpty(formObj.cop_no.value)) {
			    	formObj.f_cmd.value=SEARCH02;
					formObj.rpln_cop_no.value = formObj.cop_no.value;
					sheetObj.DoSearch("ESD_SCE_6000GS.do", FormQueryString(formObj));
			    }
				break;
		   case IBSEARCH_ASYNC04: // CopReplan
			   if (!ComIsEmpty(formObj.rpln_cop_no.value) && sheetObj.RowCount() > 0) {
				   if (ComShowCodeConfirm("SCE90054")) {
					   ComOpenWait(true, true);
					   formObj.f_cmd.value = MODIFY02;
					   try {
						   sheetObj.DoAllSave("ESD_SCE_6000GS.do", FormQueryString(formObj));
					   } catch(e) {
						   ComOpenWait(false);
					   } 
				   }
			   }
			   break;
        }
    }
    function contents_cp()
    {
        if (window.event)
        {
        	if(navigator.appName.indexOf("Microsoft")!=-1){
                window.event.returnValue=true;
                window.setTimeout('attach_kinref()', 25);        		
        	}
        }
    }
    function attach_kinref() 
    {
        if (window.clipboardData) // IE
        {
            // get data from clipboard
            var txt=document.form.bkg_no_tmp.options[document.form.bkg_no_tmp.selectedIndex].text;
            // set data to clibboard
            var result=window.clipboardData.setData('Text', txt);
        }
    }
    function goESD_SCE_0044(sheetObj){
	    var formObj=document.form ;
		if(formObj.cntr_no.value==""){
	  		ComShowMessage(ComGetMsg('SCE90018'));
	  		return ;
	  	}
	    var cntrNO=formObj.cntr_no.value ;
	    var tpszCd=formObj.cntr_tpsz_cd.value;
	  	newForm="<form name='form1' method='post'>" ;
		newForm += "<input type='hidden' name='cntr_no' value='"+ cntrNO+ "'>" ;
		newForm += "<input type='hidden' name='tpsz_cd' value='" + tpszCd + "'>" ;		
	    newForm += "</form>"
	    document.all.new_form.innerHTML=newForm ;
	    var formObj=document.form1 ;
	    var paramUrl="cntr_no="+cntrNO+"&tpsz_cd="+tpszCd;
	    var newWin= ComOpenWindow("ESD_SCE_0044.do?"+paramUrl,  "clm_win",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:525px" , true);
//	    var newWin  = window.open("","clm_win", "width=771,height=525," + getCenterXY(755, 500));
       // var newWin  = window.open("","clm_win", "width="+screen.width+",height=525," + getCenterXY(screen.width, 500));
//        var newWin  = window.open("","clm_win", "width="+800+",height=525," + getCenterXY(screen.width, 500));        
//	    formObj.action = "ESD_SCE_0044.do" ;
//	    formObj.target = "clm_win" ;
//	    formObj.submit() ;
		    //newWin.focus() ;
	}
	function getCenterXY(w, h){
		var height=screen.availHeight ;
		var width=screen.availWidth ;
		var leftpos=width/2 - w/2;
		var toppos=height/2 - h/2;
		if(leftpos<0) leftpos=0;
		if(toppos<0) toppos=0;
		return "left=" + leftpos + ", top=" + toppos ;
	}
    function changeColor(sheetObj){
    	var rowCnt=sheetObj.RowCount();
    	for( i=0 ; i < rowCnt ; i ++){
    		if(sheetObj.GetCellValue(i,6) != ''){
    			if( i != 0){
    				//sheetObj.RowBackColor(i) = "#C8F5FF";
    				sheetObj.SetRowBackColor(i,"#C8F5FF");
    			}
    		}
    	}
    	if(rowCnt > 0){
    		sheetObj.SelectCell(0,11);
    	}
    }
    /*
     * sheetObj.CellBackColor(i,"r_act_nm") = "#E6F0F0";
    				sheetObj.SetGetCellBackColor(i,"r_vvd","#E6F0F0");
    				sheetObj.SetGetCellBackColor(i,"r_nod_cd","#E6F0F0");
    				sheetObj.SetGetCellBackColor(i,"r_pln_date","#E6F0F0");
    				sheetObj.SetGetCellBackColor(i,"r_pln_time","#E6F0F0");
     */
     /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
   /**
    * initializing Tab
    * setting Tab items
    */
    function initTab(tabObj , tabNo) {
         var cnt=0 ;
         switch(tabNo) {
             case 1:
                with (tabObj) {
            	 	InsertItem("Transportation" , "");
                    InsertItem("  TRS S/O Info  " , "");
                    InsertItem("  Actual Information  " , "");
                    SetSelectedIndex(0);
                }
             break;
        }
    }
    /**
    * Event when clicking Tab
    * activating selected tab items
    */
    function tab1_OnChange(tabObj ,nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	sheetObj.SetSumText(0,"");
    	sheetObj.SetSumText(2,"Total Cost(USD)" );
        sheetObj.SetColFontColor("so_num","#0000FF");
			sheetObj.SetColFontUnderline("so_num",1);
    }
    /**
    * handling process for input validation
    */
    function validateForm(sheetObj,formObj,sAction){
    	var result=true ;
        switch(sAction){
            case IBSEARCH :
//              if(ComIsEmpty(formObj.cntr_no)){
//                  ComShowMessage(ComGetMsg('COM12114', 'CNTR No')) ;
//                  formObj.cntr_no.focus() ;
//                  return false ;
//              }
//              else if(!ComChkObjValid(formObj.cntr_no, 11)){
//              	ComShowMessage(ComGetMsg('SCE90026', 'CNTR No', 11)) ;
//                formObj.cntr_no.focus() ;
//              	return false ;
//              }
			  if(ComIsEmpty(formObj.cntr_no) && formObj.bkg_no_tmp.value==""){
              		ComShowMessage(ComGetMsg('COM12114', 'CNTR No')) ;
                    //formObj.cntr_no.focus() ;
                    return false;
              }
              else if(!ComIsEmpty(formObj.cntr_no) && formObj.bkg_no_tmp.value==""){
                  ComShowMessage(ComGetMsg('COM12113', 'BKG No')) ;
                  formObj.bkg_no_tmp.focus() ;
                  return false ;
              }
              return true;
              break ;
            case IBSAVE :
             	var updateRows=sheetObj.FindStatusRow("U").split(";") ;
 				var updateCnt=updateRows.length ;
				if(updateCnt==0){
					ComShowMessage(ComGetMsg('SCE90008', 'CNTR No')) ;
					result=false ;
				}
				else if(updateCnt>1){
					ComShowMessage(ComGetMsg('SCE90009', 'CNTR No')) ;
					result=false ;
				}
				
				return result ;
            	break ;
        }
    }
	function t1sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg==""){
			var formObj=document.form ;
			var message=formObj.estm_act_dt.value=="E"?"Estimate Date/Time" : "Actual Date/Time" ;
			doActionIBSheet(sheetObj, formObj, IBSEARCH) ;
			ComShowMessage(ComGetMsg('COM12156', message)) ;
		}
	}
	//S/O Link
	function t3sheet1_OnDblClick(sheetObj, row, col){
		var formObj=document.form;
		if(col == sheetObj.SaveNameCol("so_num")) {
			if(sheetObj.GetCellValue(row,'so_num') !== "") {
				formObj.f_cmd.value="" ;
				formObj.target="ESD_TRS_0019";
            	formObj.action="ESD_TRS_0019.do?parentPgmNo=111&pgmNo=ESD_TRS_0019&sowonumber="+ sheetObj.GetCellValue(row,'so_num') + "&railflg=" + sheetObj.GetCellValue(row,'rail_flg') 
				formObj.submit();
			}
		}
	}
	function t1sheet1_OnDblClick(sheetObj, row, col){
		if(col==2  && sheetObj.GetCellValue(row, col)!=-1){
    			var formObj=document.form ;
    			var copNo=formObj.cop_no.value ;
    			var cntrNo=formObj.cntr_no.value ;
    			var copExptNo=sheetObj.GetCellValue(row, "cop_expt_no") ;
    			var copExptTpCD=sheetObj.GetCellValue(row, "cop_expt_tp_cd") ;
    	        newForm="<form name='form1' method='post'>" ;
    	        newForm += "  <input type='hidden' name='cop_expt_no'    value='" + copExptNo + "'>" ;
    	        newForm += "  <input type='hidden' name='cop_expt_tp_cd' value='" + copExptTpCD + "'>" ;
    	        newForm += "  <input type='hidden' name='cop_no'		 value='" + copNo + "'>" ;
    			newForm += "  <input type='hidden' name='cntr_no'		 value='" + cntrNo + "'>" ;
    			newForm += "  <input type='hidden' name='pgmNo'		 value='ESD_SCE_0012'>" ;    			
    	        newForm += "</form>";
    	        document.all.new_form.innerHTML=newForm ;
    	        var formObj=document.form1 ;
    		    formObj.action="ESD_SCE_0012.do" ;
    		    formObj.submit() ;
    		}
	}
	function setCopExptSts(sheetObj){
		var startRow=1;
		if(sheetObj.GetTotalRows()> 0){
			for(var i=startRow; i<=sheetObj.GetTotalRows(); i++){
				if(sheetObj.GetCellValue(i, "expt_info") == '##'){
					sheetObj.SetCellValue(i, "expt_info",'');
				}
				var valArray=sheetObj.GetCellValue(i, "expt_info").split("#") ;
//conversion of function[check again]CLT  				sheetObj.SetGetCellImage(i, "cop_expt_sts",(valArray.length==3?valArray[1] ==("O")?"02":"01":""));
				sheetObj.SetRowStatus(i,"R");
			}		
		}
	}
	function t1sheet1_OnClick(sheetObj,Row, Col, Value) {
    	var formObj=document.form;
        if(Col == 12 || Col == 13){
        	//if(Col == 11 || Col == 12 || Col == 13 || Col == 14){
            if(formObj.cntr_no.value == ''){
                sheetObj.SetCellEditable(Row,Col,0);
                sheetObj.SetCellEditable(Row,Col,0);
            }
        }
    }
	function t1sheet1_OnMouseMove(sheetObj, button, shift, x, y){
		var row=sheetObj.MouseRow();
		var col=sheetObj.MouseCol();
		var value=sheetObj.GetCellValue(row, col) ;
		if(row>0 && col==2 && value!="-1"){
			sheetObj.SetMousePointer("Hand" );
		}
		else{
			sheetObj.SetMousePointer("Default" );
		}
	}
    function keyAction() {
        var formObj=document.form ;
		//if(event.keyCode == 13){
    		//alert('keyAction');
    		/*
    		if(ComIsEmpty(formObj.cntr_no)){
    		    ComShowMessage(ComGetMsg('COM12114', 'CNTR No')) ;
    		    formObj.cntr_no.focus() ;
    		    return ;
    		}
    		else if(!ComChkObjValid(formObj.cntr_no, 11)){
              	ComShowMessage(ComGetMsg('SCE90026', 'CNTR No', 11)) ;
                formObj.cntr_no.focus() ;
              	return false ;
            }
		//}            
            */
        	formObj.cntr_no.value = formObj.cntr_no_v.value; 
            if(ComChkObjValid(formObj.cntr_no, 11) && formObj.cntr_no.value.length == 11){
            	if(formObj.cntr_no.value == 'COMU0000000'){
            		alert("Invalid Container No!");
            		return;
            	}
	    		formObj.cop_no.value="" ;
	    		formObj.cntr_no.value=formObj.cntr_no_v.value.toUpperCase();
	    		formObj.target="_self" ;
	    		formObj.f_cmd.value=SEARCHLIST;
	    		formObj.action="ESD_SCE_0006.do?parentPgmNo=ESD_SCE_M001" ;
	    		formObj.submit();
            }
	}
	function setCopValues(object){
        if(object.value=="") return ;
  	    var formObj=document.form ;
  	    var values=object.value.split("|");
  	    formObj.bkg_no.value=values[0];
  	    //formObj.bkg_no_split.value = values[1];
  	    formObj.cop_no.value=values[1];
  	    formObj.cop_sts.value=values[2]; // 막혀있었음
  	   if( values[3] != undefined){
  	    formObj.cop_mst_bkg.value=values[3];}
	}
	function t1sheet1_OnSelectCell(sheetObj, oldRow, oldCol, newRow, newCol){
		var oldColName=sheetObj.ColSaveName(oldCol) ;
		var newColName=sheetObj.ColSaveName(newCol) ;
	}
    function CheckDigit(obj){
        var rtnval=cntrCheckDigit(obj);
        obj.value=rtnval;
    }
    function t1sheet1_OnSearchEnd(sheetObj) {
    	if(sheetObj.GetTotalRows()> 0){
    		sheetObj.SetEtcData("rail_rcv_coff_fm_dt",sheetObj.GetCellValue(sheetObj.GetTotalRows(), "rail_rcv_coff_fm_dt"));
    		document.form.rail_rcv_coff_fm_dt.value=sheetObj.GetCellValue(sheetObj.GetTotalRows(), "rail_rcv_coff_fm_dt");
    	}
    }
    function onEnterKey(textname) {
    	if (event.keyCode == 13) {
    		keyAction();
    	}
    }
    /**
     * calling popup of cop change
     * @param formObj
     * @return
     */
    function openESD_SCE_0053(formObj){
    	var cop_no=formObj.cop_no.value ;

    	//    	newForm="<form name='form1' method='post'>" ;
//    	newForm += "  <input type='hidden' name='cop_no'       value='" + cop_no + "'>" ;	
//    	newForm += "  <input type='hidden' name='pgmNo' value='ESD_SCE_0053'>" ;	
//    	newForm += "</form>"
//    	document.all.new_form.innerHTML=newForm ;
//    	var formObj=document.form1 ;
    	var paramUrl="pgmNo=ESD_SCE_0053&cop_no="+cop_no;
        ComOpenWindow("ESD_SCE_0053.do?"+paramUrl,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:600px;dialogHeight:200px" , true);
//    	var newWin  = window.open("","cop_change", "width=400,height=195," + getCenterXY(400, 195));
//    	formObj.action = "ESD_SCE_0053.do" ;
//    	formObj.target = "cop_change" ;
//    	formObj.submit() ;	
    } 
    /**
     * calling popup of cop history
     * @param formObj
     * @return
     */
    function openESD_SCE_0071(formObj){
    	var cop_no=formObj.cop_no.value ;

    	var paramUrl="pgmNo=ESD_SCE_0071&mainPage=false&cop_no="+cop_no;
        var newWin= ComOpenWindow("ESD_SCE_0071_POP.do?"+paramUrl,  "cop_history",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:900px;dialogHeight:530px" , true);
    }    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    } 
    
    function t1sheet1_OnChange(sheetObj, row, col, value){
    	var saveName = sheetObj.ColSaveName(col);  //cell name 
    	var totalRow = sheetObj.GetTotalRows();
    	var tempHighDate = "";
    	var maxHighDate = "";
    	var tempLowDate = "";
    	var maxLowDate = "";
    	
    	var tempHighDateTime = "";
    	var maxHighDateTime = "";
    	var tempLowDateTime = "";
    	var maxLowDateTime = "";    	
    	
    	var formObj = document.form;
    	
    	var arrData = new Array();
    	
    	/// act date
    	if (sheetObj.ColSaveName(col) == "act_date") {
    		var inputActDate = value;
    		if(value != ""){
	    		//상
	    		if (row > 1) {
	    			var x = 0;
	    			arrData = new Array();
	    			for (var i=row-1; i>0; i--) {	
	    				arrData[x] = sheetObj.GetCellValue(i,"act_date");
	    				x++;
		    			
	    			}
	    			
	    			tempHighDate = "0"; //최대값이 저장될 변수
	    			
	    			for (var i=0;  i < arrData.length ; i++) {
	    				if(arrData[i] != ""){
			    			if(tempHighDate < arrData[i]) {
			    				tempHighDate = arrData[i];
				    		}
	    				}
	    			}

	    		} else if ( row == 1 ) {
	    			maxHighDate = inputActDate ;
	    		} 
	    		
	    		if (tempHighDate != '') {
					maxHighDate = tempHighDate;
				} else {
					maxHighDate = 1
				}
//	alert("inputActDate상 "+inputActDate);
//	alert("tempHighDate상 "+tempHighDate);
	    		//error message 처리
	    		if (maxHighDate != 1 ) {
		    		if (inputActDate < maxHighDate ) {
		    			
		    			if(ComShowCodeConfirm("SCE90050")){
		    		//		doActionIBSheet(sheetObj,formObj,IBSAVE);
		    			}
		    			else{
			    			sheetObj.SetCellValue(row, col, '',0);
			    			sheetObj.SetCellValue(row, col+1, '',0);
			    			return;
		    			}
		    			
		    		}
	    		}
//	    		alert("totalRow "+totalRow+" ROW "+row);
	    		//하    		
	    		if (row < totalRow) {
	    			var x = 0;
	    			arrData = new Array();
	    			for (var i=row+1; i <= totalRow ; i++) {	
	    				arrData[x] = sheetObj.GetCellValue(i,"act_date");
	    				
	    				x++;
	    			}
	    			
	    			tempLowDate = "9999123"; //최소값이 저장될 변수
	    			
	    			for (var i=0;  i < arrData.length ; i++) {
	    				if(arrData[i] != ""){
			    			if(tempLowDate > arrData[i]) {
			    				tempLowDate = arrData[i];
				    		}
	    				}
	    			}
	    			
	    		} else if ( row == totalRow ) {
	    			maxLowDate = inputActDate ;
	    		}
	    		
	    		if (tempLowDate != '') {
	    			maxLowDate = tempLowDate;
				} else {
					maxLowDate = 1
				}

//	    		alert("inputActDate하 "+inputActDate);
//	    		alert("tempLowDate하 "+tempLowDate);
	    		//error message 처리
	    		if (maxLowDate != 1) {
	    			
		    		if (inputActDate > maxLowDate ) {
		    			
		    			if(ComShowCodeConfirm("SCE90050")){
		    			//	doActionIBSheet(sheetObj,formObj,IBSAVE);
		    			}
		    			else{
			    			sheetObj.SetCellValue(row, col, '',0);
			    			sheetObj.SetCellValue(row, col+1, '',0);
			    			return;
		    			}
		    			
		    		}
	    		}
	    		
	    		//now = new Date();
	    		//sheetObj.SetCellValue(row, col+1, ("00"+now.getHours()).slice(-2)+":"+("00"+now.getMinutes()).slice(-2),1);
    		}
    	//act_time	
    	} else if (sheetObj.ColSaveName(col) == "act_time") {
    		var inputActTime = value;
    		if(value != ""){
	    		var dateCell = row;
	    		var inputDate = sheetObj.GetCellValue(dateCell,"act_date");
	    		var inputTime = ''+inputDate+inputActTime;
	    		
	    		if (inputDate == '' ) {
	    			sheetObj.SetCellValue(row, col, '',0);
	    		} else {
	    			
	        		//상
	        		if (row > 1) {
		    			var x = 0;
		    			arrData = new Array();
		    			for (var i=row-1; i>0; i--) {	
		    				arrData[x] = sheetObj.GetCellValue(i,"act_date")+sheetObj.GetCellValue(i,"act_time").replace(":","");	
		    				x++;
			    			
		    			}
		    			
		    			tempHighDateTime = "0"; //최대값이 저장될 변수
		    			
		    			for (var i=0;  i < arrData.length ; i++) {
		    				if(arrData[i] != ""){
				    			if(tempHighDateTime < arrData[i]) {
				    				tempHighDateTime = arrData[i];
					    		}
		    				}
		    			}
	    	    		
	        		} else if ( row == 1 ) {
	        			tempHighDateTime = inputTime ;
	        		} 
	        		
	        		if (tempHighDateTime != '') {
	    				maxHighDateTime = tempHighDateTime;
	    			} else {
	    				maxHighDateTime = 1
	    			}
//		    		alert("inputTime상 "+inputTime);
//		    		alert("tempHighDateTime상 "+tempHighDateTime);
	        		//error message 처리
	        		if (maxHighDateTime != 1 ) {
	        			if (inputTime < maxHighDateTime ) {
			    		//	alert("Input date is out of scope!");
			    			if(ComShowCodeConfirm("SCE90050")){
			    				sheetObj.SetCellValue(row, col, sheetObj.GetCellValue(row,"act_time").replace(":",""),0);
			    			//	doActionIBSheet(sheetObj,formObj,IBSAVE);
			    			}
			    			else{
				    			sheetObj.SetCellValue(row, col, '',0);
				    			return;
			    			}
			    		}
	        		}
	//        		else{
	//        			sheetObj.SetCellValue(row, col, sheetObj.GetCellValue(row,"act_time").replace(":",""),0);
	//        		}
	        		//하    		
	        		if (row < totalRow) {
	        			
		    			var x = 0;
		    			arrData = new Array();
		    			for (var i=row+1; i <= totalRow ; i++) {	
		    				arrData[x] = sheetObj.GetCellValue(i,"act_date")+sheetObj.GetCellValue(i,"act_time").replace(":","");
		    				x++;
			    			
		    			}
		    			
		    			tempLowDateTime = "999912312359"; //최소값이 저장될 변수
		    			
		    			for (var i=0;  i < arrData.length ; i++) {
		    				if(arrData[i] != ""){
				    			if(tempLowDateTime > arrData[i]) {
				    				tempLowDateTime = arrData[i];
					    		}
		    				}
		    			}
		    			
	        		} else if ( row == totalRow ) {
	        			maxLowDateTime = inputTime ;
	        		}
	        		
	        		if (tempLowDateTime != '') {
	        			maxLowDateTime = tempLowDateTime;
	    			} else {
	    				maxLowDateTime = 1
	    			}
//		    		alert("inputTime하 "+inputTime);
//		    		alert("tempLowDateTime하 "+tempLowDateTime);
	        		//error message 처리
	        		if (maxLowDateTime != 1) {
	    	    		if (inputTime > maxLowDateTime ) {
	//    	    			alert("Input date is out of scope!");
	//    	    			sheetObj.SetCellValue(row, col, '',0);
	//    	    			return;
	    	    			
			    			if(ComShowCodeConfirm("SCE90050")){
			    				sheetObj.SetCellValue(row, col, sheetObj.GetCellValue(row,"act_time").replace(":",""),0);
	//		    				doActionIBSheet(sheetObj,formObj,IBSAVE);
			    			}
			    			else{
				    			sheetObj.SetCellValue(row, col, '',0);
				    			return;
			    			}
	    	    			
	    	    		}
	        		} 
	//        		else{
	//        			sheetObj.SetCellValue(row, col, sheetObj.GetCellValue(row,"act_time").replace(":",""),0);
	//        		}
	        		
		    	}
    		}
    	}
    		
    }

    /**
     * Manual Replan 처리를 위한 사전 작업.
     * @param sheetObj
     * @param Row
     * @returns
     */
    function sheet1_OnRowSearchEnd(sheetObj, Row){
    	sheetObj.SetCellValue(Row, 'bkg_info', 1, 0);
    	sheetObj.SetCellValue(Row, 'regen_pc', 1, 0);    	
    }

    /**
     * Manual Replan 후 작업.
     * @param sheetObj
     * @param errCode
     * @param errMsg
     * @returns
     */
	function sheet1_OnSaveEnd(sheetObj, errCode, errMsg){
		 ComOpenWait(false);
		if(errCode == "") {
			var formObj = document.form ;
			var rpln_rslt = sheetObj.GetCellValue(1,"rpln_rslt");
			if(rpln_rslt == "SUCCESS") {
				ComShowCodeMessage('SCE90005');
			} else {
				ComShowCodeMessage('SCE90006');
			}
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	       	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
	       	doActionIBSheet(sheetObjects[2],formObj,IBSEARCH);
			doActionIBSheet(sheetObjects[3],formObj,IBSEARCH_ASYNC03);
		}
	}
