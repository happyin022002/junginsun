/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0108.js
*@FileTitle  : retrieving CNTR repo execution plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
    // common static variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var subSum="totalvol|totalcost";
    var oldValue=null;   
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
    	var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
                 case "btn_new":
                     formObject.reset();
                     sheetObject.RemoveAll();
                     break;
                 case "btn_retrieve":
     	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
         	        break;
                 case "btn_downexcel":
                     doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                     break;
                 case "btn_save":
                     doActionIBSheet(sheetObject,formObject,IBSAVE);
                     break;
                 case "btn_saveas":
         	        //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
         	        break;
                 case "btn_print":
                 	if(sheetObjects[0].RowCount('') > 0) { 
                 		sheetObjects[0].DoPrint();
                 	}else{
                   		ComShowCodeMessage("EQR90095");
                 	}
               		break;
                 case "btng_rowadd":
                     doActionIBSheet(sheetObject,formObject,IBINSERT);
                     break;
                 case "btng_rowcopy":
                     doActionIBSheet(sheetObject,formObject,IBCOPYROW);
                     break;
                 case "btng_sort":
                     ComShowMessage("btng_sort");
                     break;
                 case "btng_sendtoso":
                     ComShowMessage("btng_sendtoso");
                     break;
                 case "btng_repobkg":
                     ComShowMessage("btng_repobkg");
                     break;
                 case "btn_close":
                	 ComClosePopup(); 
                     break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			//ComShowMessage(OBJECT_ERROR);
     			ComShowCodeMessage("EQR90004");
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
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i]);
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
        var formObject=document.form;
        var opener = window.dialogArguments;
        if (!opener) opener=window.opener;
        if (!opener) opener = parent;
 		//var opener=window.dialogArguments;
 		formObject.cntrno_all.value=opener.document.form.cntrno_all.value;        
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
            	       var VolSum="";
            	       var CostSum="";
            	       var consTpszArr=null;
            	       if((consTpsz!='' && consTpsz!=null)) consTpszArr=consTpsz.split(',');
            	       var HeadTitle0="Del.|STS|Week|Co.|Lane|VVD|From|From|Through|Through|To|To|Purpose|CNTR No.|Remarks|";
            	       var HeadTitle1="Del.|STS|Week|Co.|Lane|VVD|LOC|ETD|LOC|ETD|LOC|ETB(VVD)/ETA|Purpose|CNTR No.|Remarks|";
            	       for(i=0; i<consTpszArr.length; i++) {
	            	       if(i!=consTpszArr.length-1) {
	            	    	   VolSum=VolSum  + "|vol"  + consTpszArr[i]+"|+";
	            	    	   CostSum=CostSum + "|cost" + consTpszArr[i]+"|+";
	            	       }else {
	            	    	   VolSum=VolSum  + "|vol"  + consTpszArr[i]+"|";
	            	    	   CostSum=CostSum + "|cost" + consTpszArr[i]+"|";
	            	       }
	            	       subSum=subSum  + "|vol"+consTpszArr[i]+"|cost"+consTpszArr[i];
            	       }
            	       HeadTitle0=HeadTitle0 + "Total Vol|";
            	       HeadTitle1=HeadTitle1 + "Total Vol|";
            	       for(i=0; i<consTpszArr.length; i++) {
            	    	   HeadTitle0=HeadTitle0 + "Vol.|";
            	    	   HeadTitle1=HeadTitle1 + consTpszArr[i]+"|";
            	       }
            	       var columnCount=18 + eval(consTpszArr.length*1) + eval(consTpszArr.length*3) + 5;  // 4 : hidden value
            	       var tab=document.form.tab.value;
            	       var pastplan=document.form.pastplan.value;

            	       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	       var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
            	       var headers = [ { Text:HeadTitle0, Align:"Center"},
            	                   { Text:HeadTitle1, Align:"Center"} ];
            	       InitHeaders(headers, info);

            	       var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
            	              {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Combo",     Hidden:0, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"co_cd",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:9},
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lane",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"vvd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 } ];
            	             if(tab=="1") {   // FROM VESSEL
            	       if(pastplan=="Y") {  // past plan
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd1",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"dt1",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd2",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"dt2",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd3",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"dt3",                     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
            	       }else {  // current plan
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd1",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"dt1",                     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd2",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"dt2",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd3",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"dt3",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:8});
            	       }
            	       }else {   // FROM INLAND
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd1",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"dt1",                     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd2",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"dt2",                     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	            	       cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"yd3",                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
	            	       cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"dt3",                     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,   EditLen:8});
            	       }
	            	       cols.push({Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"eq_repo_purp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 });
	            	       cols.push({Type:"Image",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntrimage",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9});
	            	       cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"repo_pln_fb_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 });
	            	       cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"totalvol",                KeyField:0,   CalcLogic:VolSum,Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 });
            	       for(var i=0; i<consTpszArr.length ; i++) {
            	    	   	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"vol"+consTpszArr[i],      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
            	       }
	            	       cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"pln_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	            	       cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"ecc1",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	            	       cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"ecc2",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	            	       cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"ecc3",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	            	       cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trsp_mode",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	            	       cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"t1_cntrno",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	            	       cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"t1_tpszno",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
            	       for(var i=0; i<consTpszArr.length; i++) {
            	    	   cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"unitcost"+consTpszArr[i], KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 });
            	    	   cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fromcost"+consTpszArr[i], KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 });
            	    	   cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"tocost"+consTpszArr[i],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 });
            	       }
            	       if(tab=="1") {  // FROM VESSEL
            	    	   if(pastplan=="Y") {  // past plan
            	    		   sheetObj.SetColProperty("dt1", {Format:"YmdHms"} );
            	       }else {
	            	    	   sheetObj.SetColProperty("dt2", {Format:"YmdHms"} );
		            	       for(var i=5; i<48; i++) {
		            	    	   SetCellBackColor(1,i,GetCellBackColor(1,4));
		            	       }            	  
		            	       
            	       		}
            	       }
            	       InitColumns(cols);            	   	
            	       SetEditable(1);
            	       SetImageList(0,"/opuscntr/img/button/btns_cntrinput.gif");
            	       SetImageList(1,"/opuscntr/img/button/btns_cntrinput_c.gif");
            	       SetCellBackColor(1,4,"#555555");
            	       SetCellBackColor(1,i,GetCellBackColor(1,4));
            	       sheetObj.SetColProperty("dt2", {Format:"YmdHms"} );
            	       sheetObj.SetColProperty("dt3", {Format:"YmdHms"} );            	       
            	       sheetObj.SetShowButtonImage(3);// in case of editable, showin combo & pop-up image
            	       SetRangeBackColor(1, 0,1, 40,"#555555");
            	       SetSheetHeight(ComGetSheetHeight(sheetObj,10));
            	       }

                 break;
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
                if(validateForm(sheetObj,formObj,sAction))
                 break;
             case IBSAVE:        //saving
 				if(validateForm(sheetObj,formObj,sAction)) {
 					//ComShowMessage("save fire ");
              		formObj.f_cmd.value=ADD;
              		sheetObj.DoSave("EES_EQR_0108GS.do", eqrFormQryStr(formObj));
              		//ComShowMessage("save end ");
 				}
                 break;
            case IBINSERT:
                 var Row=sheetObj.DataInsert();
                 var tab=formObj.tab.value;
                 var pastplan=formObj.pastplan.value;
                 var trspmode=formObj.trspmode.value;
 				var consTpszArr=null;
 				if((consTpsz!='' && consTpsz!=null)) consTpszArr=consTpsz.split(',');
 				// setting default
                sheetObj.SetCellValue(Row, 'pln_yrwk',formObj.week.value);// WEEK
                sheetObj.SetCellValue(Row, 'pln_seq',formObj.pln_seq.value);// PLN_SEQ
                 if(tab=="1") {    // FROM VESSEL
                     if(pastplan=="Y") {  // past plan            	
                         sheetObj.SetCellValue(Row, 'yd1',formObj.fromecc.value,0);// FROM ECC
                         sheetObj.SetCellValue(Row, 'yd2',formObj.toecc.value,0);// TO ECC
                         sheetObj.SetCellValue(Row, 'yd3',formObj.toecc.value,0);// TO ECC
                         sheetObj.SetCellValue(Row, 'ecc1',formObj.fromecc.value,0);// FROM ECC
                         sheetObj.SetCellValue(Row, 'ecc2',formObj.toecc.value,0);// TO ECC
                         sheetObj.SetCellValue(Row, 'ecc3',formObj.toecc.value,0);// TO ECC
                         sheetObj.SetCellValue(Row, 'dt1',formObj.etd.value,0);// FROM ECC
                         sheetObj.SetCellValue(Row, 'dt2',formObj.eta.value,0);// FROM ECC
                         //sheetObj.CellValue2(Row, 'dt3')   		  	  = formObj.fromecc.value;  // FROM ECC  
 						// ------ FM LOC YARD retreive [START] -----------
             			var f_cmd=SEARCH01;                    
             			var vsl=formObj.vvd_cd.value;
             			var from_ecc=formObj.fromecc.value;
             			sheetObj.DoRowSearch("EES_LOCYARDINITIAL_COMMON.do" ,"row="+Row+"&colname=yd1&vsl="+vsl+"&ecc="+from_ecc+"&item=V&f_cmd="+f_cmd, false);
                         // ------ FM LOC YARD retreive  [END] -----------
 						// ------ TO LOC YARD retreive [START] -----------
             			var f_cmd=SEARCH01;                    
             			var vsl=formObj.vvd_cd.value;
             			var to_ecc=formObj.toecc.value;
             			sheetObj.DoRowSearch("EES_LOCYARDINITIAL_COMMON.do" ,"row="+Row+"&colname=yd2&vsl="+vsl+"&ecc="+to_ecc+"&item=V&f_cmd="+f_cmd);
 						// ------ TO LOC YARD retreive  [END] -----------
                     }else {  // normal plan
                         sheetObj.SetCellValue(Row, 'yd1',formObj.fromecc.value,0);// FROM ECC
                         sheetObj.SetCellValue(Row, 'yd2',formObj.fromecc.value,0);// FROM ECC
                         sheetObj.SetCellValue(Row, 'yd3',formObj.toecc.value,0);// TO ECC
                         sheetObj.SetCellValue(Row, 'ecc1',formObj.fromecc.value,0);// FROM ECC
                         sheetObj.SetCellValue(Row, 'ecc2',formObj.fromecc.value,0);// FROM ECC
                         sheetObj.SetCellValue(Row, 'ecc3',formObj.toecc.value,0);// TO ECC
                         //sheetObj.CellValue2(Row, 'dt1')   		  	  = formObj.etd.value;  // FROM ECC               	
                         sheetObj.SetCellValue(Row, 'dt2',formObj.etd.value,0);// FROM ECC
                         sheetObj.SetCellValue(Row, 'dt3',formObj.eta.value,0);// TO   ECC
                         // ------  FROM LOC YARD retreive [START] -----------
             		    var f_cmd=SEARCHLIST05;      // INLAND+WATER 
             		    sheetObj.DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+formObj.fromecc.value+"&colname=yd1&f_cmd="+f_cmd); 
             		    sheetObj.SetCellValue(Row, "yd1","",0);
 						// ------  THROUGH LOC YARD retreive [START] -----------
             			var f_cmd=SEARCH01;                    
             			var vsl=formObj.vvd_cd.value;
             			var from_ecc=formObj.fromecc.value;
             			sheetObj.DoRowSearch("EES_LOCYARDINITIAL_COMMON.do" ,"row="+Row+"&colname=yd2&vsl="+vsl+"&ecc="+from_ecc+"&item=V&f_cmd="+f_cmd, false); 
                         // ------ THROUGH LOC YARD retreive  [END] -----------
 						// ------ TO LOC YARD retreive [START] -----------
             			var f_cmd=SEARCH01;                    
             			var vsl=formObj.vvd_cd.value;
             			var to_ecc=formObj.toecc.value;
             			sheetObj.DoRowSearch("EES_LOCYARDINITIAL_COMMON.do" ,"row="+Row+"&colname=yd3&vsl="+vsl+"&ecc="+to_ecc+"&item=V&f_cmd="+f_cmd); 
 						// ------ TO LOC YARD retreive  [END] -----------                                     	                                                
                     }
                 }else {  //FROM INLAND                
                     sheetObj.SetCellValue(Row, 'yd1',formObj.fromecc.value,0);// FROM ECC
                     sheetObj.SetCellValue(Row, 'yd2',formObj.fromecc.value,0);// FROM ECC
                     sheetObj.SetCellValue(Row, 'yd3',formObj.toecc.value,0);// TO ECC
                     sheetObj.SetCellValue(Row, 'ecc1',formObj.fromecc.value,0);// FROM ECC
                     sheetObj.SetCellValue(Row, 'ecc2',formObj.fromecc.value,0);// FROM ECC
                     sheetObj.SetCellValue(Row, 'ecc3',formObj.toecc.value,0);// TO ECC
                     if(trspmode=="W") { // WATER MODE
                    	 sheetObj.SetCellEditable(Row, 'lane',0);// water 모드에서 lane modifying disable
                        // ------ YD3 retreive 
                    	var f_cmd=SEARCHLIST05; 
                    	sheetObj.DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+formObj.fromecc.value+"&colname=yd1&f_cmd="+f_cmd); 
                   		sheetObj.SetCellValue(Row, "yd1","",0);
                   		// ------ YD2 retreive [START] -----------
                        var f_cmd=SEARCH01;
 					    var vsl=formObj.vvd_cd.value;
 					    var from_ecc=formObj.fromecc.value;
 					   sheetObj.DoRowSearch("EES_LOCYARDINITIAL_COMMON.do" ,"row="+Row+"&colname=yd2&vsl="+vsl+"&ecc="+from_ecc+"&item=W&f_cmd="+f_cmd, false);
						// ------ YD2  retreive  [END] -----------
						// ------ YD3 retreive [START] -----------
 					    var f_cmd=SEARCH01;
 					    var vsl=formObj.vvd_cd.value;
 					    var to_ecc=formObj.toecc.value;				    
 					   sheetObj.DoRowSearch("EES_LOCYARDINITIAL_COMMON.do" ,"row="+Row+"&colname=yd3&vsl="+vsl+"&ecc="+to_ecc+"&item=W&f_cmd="+f_cmd);
						// ------ YD3 retreive retreive  [END] -----------
                     }else { // TRUCK & RAIL MODE
                         sheetObj.SetCellEditable(Row, 'vvd',0);// truck,rail 모드에서 vvd modifying disable
                         sheetObj.SetCellEditable(Row, 'lane',0);// truck,rail 모드에서 lane modifying disable
                         // ------  FROM LOC YARD retreive [START] -----------
                  		var f_cmd=SEARCHLIST05;      // INLAND+WATER         
                  		sheetObj.DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+formObj.fromecc.value+"&colname=yd1&f_cmd="+f_cmd);        
                  		sheetObj.DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+formObj.fromecc.value+"&colname=yd2&f_cmd="+f_cmd);        
                  		sheetObj.DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+formObj.toecc.value+"&colname=yd3&f_cmd="+f_cmd);
                  		sheetObj.SetCellValue(Row, "yd1","",0);
                  		sheetObj.SetCellValue(Row, "yd2","",0);
                  		sheetObj.SetCellValue(Row, "yd3","",0);
                     }                       
                 }    
                 sheetObj.SetCellValue(Row, 'trsp_mode',formObj.trspmode.value,0);// TRSP MODE
 				 sheetObj.SetCellValue(Row, 'vvd',formObj.vvd_cd.value,0);// VVD
 				 sheetObj.SetCellValue(Row, 'lane',formObj.lane_cd.value,0);// LANE
                 sheetObj.SetCellValue(Row, 'eq_repo_purp_cd',"",0);// Purpose resetting
                 sheetObj.SetCellValue(Row, "reason","",0);// Reason resetting
 				 sheetObj.SetCellEditable(Row, 'repo_pln_fb_rmk',0);// Reason Remark modifying disable
 				 sheetObj.SetCellValue(Row, "cntrimage","1",0);// cntr image initializing
 	            var unitcostArr=formObj.unit_cost.value.split(",");
 	            var fromcostArr=formObj.from_cost.value.split(",");
 	            var tocostArr=formObj.to_cost.value.split(",");
                 for(var i=0; i<consTpszArr.length; i++) { 
                     sheetObj.SetCellValue(Row, "unitcost"+consTpszArr[i],unitcostArr[i],0);
                     sheetObj.SetCellValue(Row, "fromcost"+consTpszArr[i],fromcostArr[i],0);
                     sheetObj.SetCellValue(Row, "tocost"+consTpszArr[i],tocostArr[i],0);
                 }    
 				// sub sum, total 
                 sheetObj.HideSubSum("pln_yrwk");
                 sheetObj.SetSumText( 0,1,"");
                 sheetObj.SetSumText( 0,"pln_yrwk","Grand TTL");
                 //sheetObj.ShowSubSum( "pln_yrwk", "totalvol|totalcost|v1|v2|v3|v4|v5|v6|v7|v8|v9|v10|c1|c2|c3|c4|c5|c6|c7|c8|c9|c10", -1, true, false , 1 ,"0=;1=;2=Sub TTL");                
                 sheetObj.ShowSubSum([{StdCol:"pln_yrwk", SumCols:subSum, Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"0=;1=;2=SubTTL"}]);
                 break;
             case IBDOWNEXCEL:
            	 if(sheetObj.RowCount() < 1){//no data
            			ComShowCodeMessage("COM132501");
        		}else{
        			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
        		}
            	 
                 break;
             case IBCOPYROW:
				if (sheetObj.RowCount()== 0) {
					ComShowCodeMessage("EQR90187");
					return false;
				}
				//sheetObj.DataCopy();
				var Row=sheetObj.DataCopy();
				// setting default
				sheetObj.SetCellValue(Row, 'eq_repo_purp_cd',"",0);// Purpose resetting
				sheetObj.SetCellValue(Row, "reason","",0);// Reason resetting
				sheetObj.SetCellEditable(Row, 'repo_pln_fb_rmk',0);// Reason Remark modifying disable
				sheetObj.SetCellValue(Row, "cntrimage","1",0);// cntr image initializing
				// sub sum, total 
				sheetObj.HideSubSum("pln_yrwk");
				sheetObj.SetSumText( 0,1,"");
				sheetObj.SetSumText( 0,"pln_yrwk","Grand TTL");
				sheetObj.ShowSubSum([{StdCol:"pln_yrwk", SumCols:subSum, Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"0=;1=;2=SubTTL"}]);
				break;
         }
     }
 	// calcuating sub total after retrieve
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		ComEtcDataToForm(document.form, sheetObj);  
     }
     function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
 		if(sheetObj.ColSaveName(NewCol).substring(0,3) == "vol") {
 			oldValue=sheetObj.GetCellValue(NewRow, NewCol);
 		    //alert("oldValue : " +oldValue);
 		}
     }
 	// ONCLICK EVENT
     function sheet1_OnClick(sheetObj, Row, Col, Val) {
     	if(sheetObj.ColSaveName(Col) == "cntrimage") {  // cntr input image cell
     	    var name=sheetObj.Cellvalue(Row,Col);   	    
     	    document.form.cntrno.value=sheetObj.GetCellValue(Row,"t1_cntrno");
       		var sRow=sheetObj.FindStatusRow("I|U");
       		var arRow=sRow.split(";");
 			var cntr_all="";
    			if(sRow!="" && sRow!=null) {
       					for(var i=0; i<arRow.length-1; i++) {
       						if(sheetObj.GetCellValue(arRow[i], "t1_cntrno")!="" && arRow[i]!=Row
       								&& sheetObj.GetCellValue(Row, "pln_yrwk")== sheetObj.GetCellValue(arRow[i], "pln_yrwk")
       								&& sheetObj.GetCellValue(Row, "trsp_mode")== sheetObj.GetCellValue(arRow[i], "trsp_mode")
       								&& sheetObj.GetCellValue(Row, "ecc3")== sheetObj.GetCellValue(arRow[i], "ecc3")
       								&& sheetObj.GetCellValue(Row, "ecc1")== sheetObj.GetCellValue(arRow[i], "ecc1") ) {
       							cntr_all=cntr_all + sheetObj.GetCellValue(arRow[i], "t1_cntrno")+",";
       						} 
       					}      					      				 	
       				}
      		document.form.cntrno_all.value=document.form.cntrno_all.value + cntr_all;  
       		oldValue=0;
   			var url="EES_EQR_0094.do"
   					+ "?f_cmd=-1"   // DEFAULT 
   					+ "&repoplan_id="+document.form.repo_pln_id.value
   		            + "&ref_id="
   		            + "&targetSheet=1"
   		            + "&targetRow="+Row
   		            + "&view=false" 		                
   		            + "&fm_ecc="+sheetObj.GetCellValue(Row, "ecc1")
   		            + "&to_ecc="+sheetObj.GetCellValue(Row, "ecc3")
   		            + "&pln_yrwk="+sheetObj.GetCellValue(Row, "pln_yrwk")
   		            + "&trsp_mode="+sheetObj.GetCellValue(Row, "trsp_mode")
   		            ;                       
   			var styleInfo="dialogLeft:0px; dialogTop:0px; dialogWidth:800px; dialogHeight:570px; scroll:no; status:no";
   			var modal     =  ComOpenWindow(url,  self,  styleInfo , true);
     	}		 				
     }        
     function sheet1_OnDblClick(sheetObj, Row, Col) {
     	var colName=sheetObj.ColSaveName(Col);
     	var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
     	if((colName == "yd1" || colName == "yd2" || colName == "yd3") && sheetObj.GetCellEditable(Row, colName) && idx!=-1) {
     		sheetObj.GetCellValue="";
     	}
     }        
     function sheet1_OnChange(sheetObj, Row, Col, Val) {
     	var colName=sheetObj.ColSaveName(Col);
     	if(colName=="vvd") {      	    
     		var searchword=sheetObj.GetCellValue(Row, colName);
     		var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
     		var vvd_length=searchword.length;
			if(idx == -1) {  
			    if(searchword!="") {
         		    if(vvd_length < 9) {
         			   // Please enter ' + msg1 + ' digits long data.  
           			   ComShowCodeMessage("EQR90078","9");
           			   sheetObj.SetCellValue(Row,"lane","");
           			   sheetObj.SetCellValue(Row,"yd2","");
           			   sheetObj.SetCellValue(Row,"yd3","");
           			   sheetObj.SetCellEditable(Row,"dt2",1);
           			   sheetObj.SetCellEditable(Row,"dt3",1);
          			   sheetObj.SetCellValue(Row,"vvd","");
           			   sheetObj.SelectCell(Row,"vvd");
         		   }else {
                 	   var f_cmd=SEARCH05;                 
          			   sheetObj.SetCellValue(Row, "lane","",0);
         			   var division="etd";   
         			   var repoplnid=document.form.repo_pln_id.value;
         			   var plnyrwk=sheetObj.GetCellValue(Row, "pln_yrwk");
         			   var ecccd=sheetObj.GetCellValue(Row, "ecc2");
         			   var scnr_id=document.form.scnrId.value;
          		       document.form.target="059iframe_vvdexist";
          		       document.form.action="EES_VVDEXIST_IFRAME.do?row="+Row
          		                                      +"&vvd="+searchword
      	    	                                      +"&colname="+colName
         		                                      +"&colname1=lane&f_cmd="+f_cmd
      	    	                                      +"&division="+division
      	      	                                      +"&repoplnid="+repoplnid
      	      	                                      +"&ecccd="+ecccd
      	      	                                      +"&plnyrwk="+plnyrwk
      	      	                                      +"&scnr_id="+scnr_id
      		                                           ;
      	      	       var result=document.form.submit(); 
					    // ------ FM LOC YARD retreive [START] -----------
					    var f_cmd=SEARCH01;
					    var vsl=sheetObj.GetCellValue(Row,"vvd");
					    var from_ecc=document.form.fromecc.value;
					    sheetObj.InitCellProperty(Row, "yd2",{ Type:"Data"} );
 		            	sheetObj.SetCellValue(Row, "yd2","",0);
 		            	 sheetObj.DoRowSearch("EES_LOCYARDINITIAL_COMMON.do" ,"row="+Row+"&colname=yd2&vsl="+vsl+"&ecc="+from_ecc+"&item=W&f_cmd="+f_cmd, false);
						    // ------ FM LOC YARD retreive  [END] -----------
						    // ------ TO LOC YARD retreive [START] -----------
					    var f_cmd=SEARCH01;
					    var vsl=sheetObj.GetCellValue(Row,"vvd");
					    var to_ecc=document.form.toecc.value;
					    sheetObj.InitCellProperty(Row, "yd3",{ Type:"Data"} );
 		            	sheetObj.SetCellValue(Row, "yd3","",0);
 		            	sheetObj.DoRowSearch("EES_LOCYARDINITIAL_COMMON.do" ,"row="+Row+"&colname=yd3&vsl="+vsl+"&ecc="+to_ecc+"&item=W&f_cmd="+f_cmd);
						   // ------ TO LOC YARD retreive  [END] -----------
     		      	}
			    }
			}
     	}	
     	if(colName=="yd1" || colName=="yd2" || colName=="yd3") {  // LOC YARD COMBO BOX  
             var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
             var searchword=sheetObj.GetCellValue(Row, colName);
    			if(idx == -1 && searchword != "") {       			
     			var basic_ecc="";
     			if(colName=="yd1") 		basic_ecc=sheetObj.GetCellValue(Row, "ecc1");
     			else if(colName=="yd2") basic_ecc=sheetObj.GetCellValue(Row, "ecc2");
     			else if(colName=="yd3") basic_ecc=sheetObj.GetCellValue(Row, "ecc3");
     			if(searchword.length == 7) { 
             		var f_cmd=SEARCH02;             
             		sheetObj.InitCellProperty(Row, colName,{ Type:"Data"} );
     			    sheetObj.SetCellValue(Row, colName,"",0);
     			    var str=sheetObj.GetSearchData("EES_LOCYARDEXIST_COMMON.do" ,"row="+Row+"&locyard="+searchword+"&ecc="+basic_ecc+"&colname="+colName+"&f_cmd="+f_cmd);
     			    sheetObj.LoadSearchData(str,{Sync:1} );
     			}else if(searchword.length >= 5 && searchword.substr(0,5)==basic_ecc) {  
             		var f_cmd=SEARCHLIST05;      // INLAND+WATER 
             		sheetObj.DoRowSearch("EES_LOCYARD_COMMON.do" ,"row="+Row+"&searchword="+searchword+"&colname="+colName+"&f_cmd="+f_cmd);
             		sheetObj.SetCellValue(Row, colName,"",0);
             	}else {
            		ComShowCodeMessage("EQR90171", basic_ecc);            	    
             		sheetObj.SetCellValue(Row, colName,"",0);
             	}	            		    				
     		}
     	}    		   
         // ------------- ETD, ETA modifying(PLAN, EXECUTE ROW ) ------------------------------------------------        		        			
 		if(sheetObj.ColSaveName(Col)=="dt1" || sheetObj.ColSaveName(Col)=="dt2" || sheetObj.ColSaveName(Col)=="dt3") {
 		    //ComShowMessage(1);
 			var dt1=sheetObj.GetCellValue(Row, "dt1");
 			var dt2=sheetObj.GetCellValue(Row, "dt2");
 			var dt3=sheetObj.GetCellValue(Row, "dt3");
 		    var frdate=document.form.week_fromdate.value;
 		    var todate=document.form.week_todate.value;
 		    var maxdate=document.form.week_maxdate.value;
 		    //ComShowMessage("BEFORE --- dt1 : " + dt1+ ", dt2 : " +dt2+ ", dt3 : "+dt3);
 		    dt1=replaceAll(dt1, "-", "").substring(0,8);
 		    dt2=replaceAll(dt2, "-", "").substring(0,8);
 		    dt3=replaceAll(dt3, "-", "").substring(0,8);
 		    //ComShowMessage("AFTER  --- dt1 : " + dt1+ ", dt2 : " +dt2+ ", dt3 : "+dt3);
 		    var searchword=sheetObj.GetCellValue(Row, "dt2");
 		    var fryard=sheetObj.GetCellValue(Row, "yd2");
 		    var toyard=sheetObj.GetCellValue(Row, "yd3");
 		    if(document.form.tab.value=="2" && sheetObj.ColSaveName(Col)=="dt2") {
 		        if(dt2 < frdate || dt2 > todate) {		            
 		    	    ComShowCodeMessage("EQR90141", "ETD", frdate, todate);
 		    	    sheetObj.SetCellValue(Row, "dt2","",0);
 		    	    sheetObj.SelectCell(Row, "dt2");
 		    	    return false;
 			    }else {
 				    if(fryard.length==7 && toyard.length==7 && searchword != "") { 
 				    	if(sheetObj.GetCellValue(Row, "vvd").length >= 9) {
             	    	    var f_cmd=SEARCH05;                 
                 	   	    //sheetObj.InitCellProperty(row, colName, dtData);
     		       	        //sheetObj.CellValue2(Row, "t2_fm_eta_dt") = "";
     		                var division="eta";   
     	      		        var repoplnid=document.form.repo_pln_id.value;
     	      		        var plnyrwk=sheetObj.GetCellValue(Row, "pln_yrwk");
     	      		        var ecccd=sheetObj.GetCellValue(Row, "ecc3");
      	     	            document.form.target="059iframe_vvdexist";
      	     	            document.form.action="EES_VVDEXIST_IFRAME.do?row="+Row
      	     	            +"&vvd="+sheetObj.GetCellValue(Row, "vvd")
      		                                         +"&colname=dt3&colname1=lane&f_cmd="+f_cmd
      		                                         +"&division="+division
      		                                         +"&repoplnid="+repoplnid
      		                                         +"&ecccd="+ecccd
      		                                         +"&plnyrwk="+sheetObj.GetCellValue(Row, "dt2")
      		                                         ;
          		            var result=document.form.submit(); 					    
 	     				}else {
     	     			    sheetObj.SetCellValue(Row, "dt3","",0);// eta initializing
 		     				var f_cmd=SEARCHLIST18;
 		     				sheetObj.DoRowSearch("EES_SEARCH_ETA.do" ,"row="+Row+"&searchword="+searchword+"&fryard="+fryard+"&toyard="+toyard+"&item=W&colname=dt3&f_cmd="+f_cmd);  
 		     			}
 	     			}
 	     		}			        
 		    }
 		    // INLAND, TO DATE
 		    if(document.form.tab.value=="2" && sheetObj.ColSaveName(Col)=="dt3") {
 		        if(dt3 < frdate || dt3 > maxdate) {		            
 		    	    ComShowCodeMessage("EQR90141", "ETA", frdate, maxdate);
 		    	    sheetObj.SetCellValue(Row, "dt3","",0);
 		    	    sheetObj.SelectCell(Row, "dt3");
 		    	    return false;
 			    }		        
 		    }		    
 			if(dt1.length==8 && dt2.length==8) {
 				if(eval(dt1) > eval(dt2)) {
 					ComShowCodeMessage("EQR90077");
 					sheetObj.SetCellValue(Row, Col,"",0);
 				}
 			}
 			if(dt2.length==8 && dt3.length==8) {
 				if(eval(dt2) > eval(dt3)) {
 					ComShowCodeMessage("EQR90077");
 					sheetObj.SetCellValue(Row, Col,"",0);
 				}	
 			}															
 		}
         //  Reason optional ----------------------------------
         if (sheetObj.ColSaveName(Col) == "reason"){
             otherCombo(sheetObj, Row, Col );
         }
 		//  CNTR NO optional ----------------------------------
 		if(sheetObj.ColSaveName(Col) == "t1_tpszno") {
 			var tpszConArr=Val.split(",");
 			var vol=0;
 			for(var i=0; i<consTpszArr.length; i++) {  
 				for(var j=0; j<tpszConArr.length; j++) {  
 					if(consTpszArr[i]==tpszConArr[j]) vol++;
 				}
 				if(vol > sheetObj.GetCellValue(Row, "vol"+consTpszArr[i])) {
 					oldValue=sheetObj.GetCellValue(Row, "vol"+consTpszArr[i]); // vol onchange,  oldvalue saving
 					sheetObj.SetCellValue(Row, "vol"+consTpszArr[i],vol);// onchange event
 				}
 				vol=0;
 			}			
 			sheetObj.SetCellValue(Row, "cntrimage","0",0);
 		}	    
 		// ------- in case of vol modified ----------------------------------------------------------
 		if(sheetObj.ColSaveName(Col).substring(0,3) == "vol") {
 			var limitFlag=false;
 			var cntrVol=0;
 			var tpszName=sheetObj.ColSaveName(Col).substring(3,5);
 			if(sheetObj.GetCellValue(Row, "t1_cntrno") != "") {
 				var tpszConArr=sheetObj.GetCellValue(Row, "t1_tpszno").split(",");
 				for(var j=0; j<tpszConArr.length; j++) {  
 					if(tpszName==tpszConArr[j]) cntrVol++;
 				}								
 				if(eval(Val) < eval(cntrVol)) {
 					limitFlag=true;   
 				}
 			}
 			if(limitFlag) {
                 ComShowCodeMessage("EQR90048", tpszName, cntrVol);
 				sheetObj.SetCellValue(Row,Col,oldValue,0);//  rollback
 			}else {
 			    oldValue=Val;	
 			    // fomula : amt = vol * unit cost
 			    sheetObj.SetCellValue(Row, "cost"+tpszName,eval(Val) * eval(sheetObj.GetCellValue(Row, "unitcost"+tpszName)),0);
 			}
 		}	    									
 		//  WEEK modifying ----------------------------------------------------------------
 		var weekInput="";		
 		if(sheetObj.ColSaveName(Col) == "pln_yrwk") {
 			weekInput=sheetObj.GetCellValue(Row, Col); // input data week
 	  		//1) checking from is week
 			if(weekInput.length < 6) {
 				//ComShowMessage("please input week data format ! ");
                ComShowCodeMessage("EQR90056");
 				sheetObj.SetCellValue(Row, Col,"",0);
 				//return false;
 			}else {
 				if(weekInput.substring(4,6) < 01 || weekInput.substring(4,6) > 53) {
 					//ComShowMessage("please input week data format ! ");
                 	ComShowCodeMessage("EQR90056");
 					sheetObj.SetCellValue(Row, Col,"",0);
 					//return false;				
 				}
 			} 
 		}
     }
    /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj) {
             var sRow=sheetObj.FindStatusRow("I");
             var arrRow=sRow.split(";");
             var ecc1=null;
             var ecc2=null;
             var ecc3=null;
 			//ComShowMessage(arrRow[0]);
   			for(idx=0; idx<arrRow.length-1; idx++) { 
   				//ComShowMessage("ECC1 : "+sheetObj.CellValue(arrRow[idx], "ecc1")+", ECC2 : " +sheetObj.CellValue(arrRow[idx], "ecc2")+ ", ECC3 : " +sheetObj.CellValue(arrRow[idx], "ecc3"));
   				ecc1=sheetObj.GetCellValue(arrRow[idx], "ecc1");
   				ecc2=sheetObj.GetCellValue(arrRow[idx], "ecc2");
   				ecc3=sheetObj.GetCellValue(arrRow[idx], "ecc3");
 				if(ecc1=="" || ecc2=="" || ecc3=="") {
 					ComShowCodeMessage("EQR90129", (arrRow[idx]-1));
 					return false;
   				}else {  					
   					if(ecc1==ecc2 && ecc2==ecc3) {
   						ComShowCodeMessage("EQR90130", (arrRow[idx]-1));
   						return false;
   					}else if(ecc1!=ecc2 && ecc2!=ecc3) {
   						ComShowCodeMessage("EQR90131", (arrRow[idx]-1));
   						return false;
   					}		  					
   				}  				
   			}		
   			for(idx=0; idx<arrRow.length-1; idx++) {       			
   				if(sheetObj.GetCellValue(arrRow[idx], "totalvol")=="0"
       			) {
     				ComShowCodeMessage("EQR90128", eval(arrRow[idx])-1);
       				return false;
       			} 
   			}
   			return true;
         }
     }
 	function settingValue(cntrno, tpszno, targetSheet, targetRow) {
 		if(targetSheet==1) {
 			sheetObjects[0].SetCellValue(targetRow, "t1_cntrno",cntrno);
 			sheetObjects[0].SetCellValue(targetRow, "t1_tpszno",tpszno);
 		}
 	}	
     //Reason  Reason Remark
     function otherCombo(sheet, Row, Col ) {
         var sText=sheet.GetCellText(Row,Col);
         var sValue=sheet.GetCellValue(Row,Col);
         if (sText == 'Others'){
             sheet.SetCellValue(Row,Col+1,'',0);
             sheet.SetCellEditable(Row, Col+1,1);
             sheet.SelectCell(Row, Col+1, true);
         }
         else{
             sheet.SetCellValue(Row,Col+1,"",0);
             sheet.SetCellEditable(Row, Col+1,0);
         }
     }	
     // messageing after saving
     function sheet1_OnSaveEnd(sheetObj, errMsg) {
         if(errMsg=='') {   	
     		ComShowCodeMessage("EQR90106");
 		}
     }    		   
     function copyLogicControl(sheetObj, row, col) {
         var colName=sheetObj.ColSaveName(col);
         sheetObj.SetCellValue(row, colName,"",0);
     }    
 	function checkVvdExist_iframe(division, row, vvd_col, slan_col, vvd_code, slan_code, vsl_dt, vvd_check) {
         if(division=="etd") {
 	        if(vvd_check=="FALSE") {  
 	            //ComShowMessage("Please input Eexecution data for VVD in T.VVD/D.VVD screen !");
 	            ComShowCodeMessage("EQR90173");
 	            sheetObjects[0].SetCellValue(row, vvd_col,'');// vvd cell valuemodifying
 	            sheetObjects[0].SetCellValue(row, slan_col,'');// lane cell valuemodifying
 	            sheetObjects[0].SelectCell(row, vvd_col);
      	        sheetObjects[0].SetCellEditable(row, "dt2",1);
 	        }else {     
 	            if(vvd_code=="" || vvd_code==null) {
 	                //ComShowMessage("Please input accurate vvd code.");
 	                ComShowCodeMessage("EQR90001", "accurate vvd code");
 	                sheetObjects[0].SetCellValue(row, vvd_col,'');// vvd cell valuemodifying
 	                sheetObjects[0].SetCellValue(row, slan_col,'');// lane cell valuemodifying
 	                sheetObjects[0].SelectCell(row, vvd_col);
      	            sheetObjects[0].SetCellEditable(row, "dt2",1);
       	        }else {
       	            sheetObjects[0].SetCellValue(row, vvd_col,vvd_code);// vvd cell valuemodifying
        	        sheetObjects[0].SetCellValue(row, slan_col,slan_code);// lane cell valuemodifying
     	            if(vsl_dt=="null" || vsl_dt=="") {
       	                sheetObjects[0].SetCellValue(row, "dt2","");
      	                sheetObjects[0].SetCellEditable(row, "dt2",1);
       	            }else {
        	            sheetObjects[0].SetCellEditable(row, "dt2",0);
       	                sheetObjects[0].SetCellValue(row, "dt2",vsl_dt);
        	            }    
       	        } 
 	        }    
         }else { // eta retreive
 	        if(vsl_dt=="" || vsl_dt=="null") {
 	            sheetObjects[0].SelectCell(row, "dt3");
 	            sheetObjects[0].SetCellEditable(row, "dt3",1);
 	        }else {
 	            sheetObjects[0].SetCellEditable(row, "dt3",0);
 	            sheetObjects[0].SetCellValue(row, "dt3",vsl_dt);// to_eta_dt modifying
 	        }        
         }
 	    document.form.target="";
 	}  	    	    
