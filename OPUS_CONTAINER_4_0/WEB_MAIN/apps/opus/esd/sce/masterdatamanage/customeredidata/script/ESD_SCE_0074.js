/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0074.jsp
*@FileTitle  :  Missing List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
// Global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var isFirst1=0;
var isFirst2=0;
var pageNo=1 ;
var rowCnt=0;
//Event handler processing by button click event */      
document.onclick=processButtonClick;
//Event handler processing by button name */
    function processButtonClick(){
        var formObject=document.form;
    	var sheetObject0=sheetObjects[0];
    	var srcName=ComGetEvent("name");
    	if(ComGetBtnDisable(srcName)) return false;
    	switch(srcName) {
    	    case "btng_send":
    	       if(sheetObject0.CheckedRows("flag")>0){
    	           var chkrow=0;
    	           if(sheetObject0.CheckedRows("flag") < 100){
        	           for(var i=0 ; i < sheetObject0.CheckedRows("flag"); i++){
                    	   chkrow=sheetObject0.FindCheckedRow("flag").split('|')[i];
                    	   if(sheetObject0.GetCellValue(chkrow, "act_dt1") == '' || sheetObject0.GetCellValue(chkrow, "act_dt2") == ''){
                 	    		alert("Please, Insert Event DT");
            	    			return;
                    	   }else if(sheetObject0.GetCellValue(chkrow, "nod_cd") == ''){
                 	    		alert("Please, Insert LOC");
            	    			return;
            	    		}            
        	           }
    	               doActionIBSheet(sheetObject0,formObject,IBINSERT);
    	           } else {
//    	               showErrMessage("Over 100 rows. Please define the rows you select");
                       var retVal =  ComOpenWindow("ESD_SCE_0091.do",  "RowLimited",  "scroll:no;status:no;resizable:no;help:no;dialogWidth:550px;dialogHeight:160px" , true);
                       if(typeof retVal != "undefined"){
                           var arr_val=retVal.split(",");
                           var temp_row=arr_val[0];
                           var temp_row1=arr_val[1];
                           sheetObject0.CheckAll("flag",0 );
                           for(temp_row;temp_row <= temp_row1;temp_row++ ){
                               sheetObject0.SetCellValue(temp_row, "flag",'Y');
                           } 
                           for(var i=0 ; i < sheetObject0.CheckedRows("flag"); i++){
                	    		chkrow=sheetObject0.FindCheckedRow("flag").split('|')[i];
                	    		if(sheetObject0.GetCellValue(chkrow, "act_dt1") == '' || sheetObject0.GetCellValue(chkrow, "act_dt2")  == ''){
                     	    		alert("Please, Insert Event DT");
                	    			return;
                	    		}else if(sheetObject0.GetCellValue(chkrow, "nod_cd") == ''){
                     	    		alert("Please, Insert LOC");
                	    			return;
                	    		}
                            }
                            doActionIBSheet(sheetObject0,formObject,IBINSERT);
                       }
    	           }
    	       }else{
                    alert("Please, Check CheckBox");
                }
    	       break;
    	    case 'btn_saveas':
    	       doActionIBSheet(sheetObject0,formObject,IBDOWNEXCEL);
    	       break;   
    	    case 'btn_close':
    	      if(formObject.sendClose.value == "reload"){
    	          window.returnValue=true;  
    	      } else {
    	          window.returnValue=false;  
    	      }
    	      ComClosePopup(); 
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
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        var diffOnMiss=formObject.diff.value;
        if((diffOnMiss == "1") || (diffOnMiss == "2")){
           doActionIBSheet(sheetObject,formObject,IBSEARCH);            
        } else {
           doActionIBSheet(sheetObject,formObject,COMMAND01);         
        }
    }
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:     
                with(sheetObj){
                //(21, 5, 0, true);
             var HeaderTitle="VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT(KST)|EDI PROCESS DT(KST)|EDI PROCESS DT(LCL)|EDI PROCESS DT(LCL)|cop_no|";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeaderTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"s_vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"s_bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"s_bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"s_cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"flag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"edi_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"edi_sub_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_knt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"act_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"act_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"gmt_dt1",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"gmt_dt2",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
                 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cop_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:30 },
                 {Type:"Status",    Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 } ];
              
             InitColumns(cols);

             SetEditable(1);
//             SetSheetHeight(ComGetSheetHeight(sheetObj, 16));
             resizeSheet();
                      }


            break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieving
               formObj.f_cmd.value=SEARCH01;                
                sheetObj.DoSearch("ESD_SCE_0074GS.do", SceFrmQryString(formObj) );
               break;
            case IBINSERT:
               formObj.f_cmd.value=MULTI01; 
				sheetObj.DoSave("ESD_SCE_0074GS.do", SceFrmQryString(formObj));
               formObj.sendClose.value="reload";
               break;
            case COMMAND01:
               formObj.f_cmd.value=SEARCH02;                
                sheetObj.DoSearch("ESD_SCE_0074GS.do", SceFrmQryString(formObj) );
               break;               
            case IBDOWNEXCEL:
            	if(sheetObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            		}else{
            			 sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
            		}
                break;
            case IBSEARCHAPPEND:
               var MissATotal=formObj.diff.value;
               formObj.i_page.value=PageNo;
               if((MissATotal == "1") || (MissATotal == "2")){
                   formObj.f_cmd.value=SEARCH01;                
                    sheetObj.DoSearch("ESD_SCE_0074GS.do", SceFrmQryString(formObj)+"&"+ "iPage=" + PageNo,{Append:true} );
               } else {
                   formObj.f_cmd.value=SEARCH02;                
                    sheetObj.DoSearch("ESD_SCE_0074GS.do", SceFrmQryString(formObj)+"&"+ "iPage=" + PageNo,{Append:true} );
               }
               break;
        }
    }
     function t1sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    }
     function resizeSheet(){ // auto-sizing
    	    ComResizeSheet(sheetObjects[0]);
    }  
