/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_CTM_0413.jsp
*@FileTitle  : BKG/MVMT VL/VD Unmatch
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_CTM_0413 : business script for EES_CTM_0413 
     */
    function EES_CTM_0413() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;

 // Event handler processing by button click event  */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 		         case "btn_retrieve":
                     if (checkFormField())
                    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                	 break;
 		         case "btn_new":
  					formObject.reset();
 					sheetObjects[0].RemoveAll();
 					sheetObjects[1].RemoveAll();
 					break;
 		         case "btn_downexcel":
  		        	if(sheetObjects[0].RowCount() < 1){//no data
 		        		ComShowCodeMessage("COM132501");
 		        		}else{
 		        			sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
 		        		}
 		        	 break;
 		         case "btn_detail":
 		        	 row=sheetObjects[0].GetSelectRow();
 		        	 if (row < 1) return;
 		        	 cntr_no=sheetObjects[0].GetCellValue(row, "cntr_no");
 		        	 tpsz_cd=sheetObjects[0].GetCellValue(row, "cntr_tpsz_cd");
// 		        	 cntrNo=cntr_no.substring(0,10);
// 		        	 checkDigit=cntr_no.substring(10,11);
 		        	 sUrl="EES_CTM_0408_POP.do?p_cntrno=" + cntr_no + "&ctnr_tpsz_cd=" + tpsz_cd;
 		        	 iWidth="1020";
 		             iHeight="682";
 		             bModal=false;
					 obj=ComOpenWindowCenter(sUrl + "&pop_mode=Y", "EES_CTM_0408", iWidth, iHeight, bModal);
                     break;
 		         case "btn_downexcel2":
 		        	if(sheetObjects[1].RowCount() < 1){//no data
 		        		ComShowCodeMessage("COM132501");
 		        		}else{
 		        			sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
 		        		} 		        	 
					break;
 		         case "btn_detail2":
 		        	 row=sheetObjects[1].GetSelectRow();
 		        	 if (row < 1) return;
 		        	 cntr_no=sheetObjects[1].GetCellValue(row, "cntr_no");
 		        	 tpsz_cd=sheetObjects[1].GetCellValue(row, "cntr_tpsz_cd");
// 		        	 cntrNo=cntr_no.substring(0,10);
// 		        	 checkDigit=cntr_no.substring(10,11);
 		        	 sUrl="EES_CTM_0408_POP.do?p_cntrno=" + cntr_no + "&ctnr_tpsz_cd=" + tpsz_cd;
 		        	 iWidth="1020";
 		             iHeight="682";
 		             bModal=false;
					 obj=ComOpenWindowCenter(sUrl + "&pop_mode=Y", "EES_CTM_0408", iWidth, iHeight, bModal);
 		        	 break;
 		         case "btn_unmatch":
 		        	 //부적절한 return 수정 by 2015/06/01 황미연
 		        	//if (sheetObjects[0].LastRow()== 0) return;
 		        	//ComOpenWait(true);
 		        	var sxml=CtmMakeHiddenXml(sheetObjects[0], "1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
 		        	//ComDebug(sxml);
 		        	if (sheetObjects[0].LastRow()!= 0) sheetObjects[0].LoadSearchData(sxml,{Sync:0} );	//부적절한 unmatch 값 수정 by 2015/06/01 황미연
 		        	var sxml=CtmMakeHiddenXml(sheetObjects[1], "1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
 		        	//ComDebug(sxml);
 		        	if (sheetObjects[1].LastRow()!= 0) sheetObjects[1].LoadSearchData(sxml,{Sync:0} );	//부적절한 unmatch 값 수정 by 2015/06/01 황미연
 		             document.form.u1.className='Obj1';
 		        	 document.form.u2.className='Obj1';
		        	 document.form.m1.className='Obj2';
 		        	 document.form.m2.className='Obj2';
 		        	 document.form.l1.className='Obj2';
 		        	 document.form.l2.className='Obj2';
 		        	//ComOpenWait(false);
					break;
 		         case "btn_match":
 		        	 //부적절한 return 수정 by 2015/06/01 황미연
 		        	//if (sheetObjects[0].LastRow()== 0) return;
 		        	//ComOpenWait(true);
 		        	var sxml=CtmMakeHiddenXml(sheetObjects[0], "0", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
 		        	//ComDebug(sxml);
 		        	if (sheetObjects[0].LastRow()!= 0) sheetObjects[0].LoadSearchData(sxml,{Sync:0} );	//부적절한 match 값 수정 by 2015/06/01 황미연
 		        	var sxml=CtmMakeHiddenXml(sheetObjects[1], "0", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
 		        	//ComDebug(sxml);
 		        	if (sheetObjects[1].LastRow()!= 0) sheetObjects[1].LoadSearchData(sxml,{Sync:0} );	//부적절한 match 값 수정 by 2015/06/01 황미연
		        	 document.form.m1.className='Obj1';
 		        	 document.form.m2.className='Obj1';
 		        	 document.form.u1.className='Obj2';
 		        	 document.form.u2.className='Obj2';
 		        	 document.form.l1.className='Obj2';
 		        	 document.form.l2.className='Obj2';
 		        	//ComOpenWait(false);
					break;
 		         case "btn_total":
 		        	 //부적절한 return 수정 by 2015/06/01 황미연
 		        	//if (sheetObjects[0].LastRow()== 0) return;
  		        	sheetObjects[0].RenderSheet(0);
 		        	sheetObjects[1].RenderSheet(0);
 		        	 sheetObjects[0].SetColHidden("Seq",0);
 		        	 sheetObjects[1].SetColHidden("Seq",0);
  		        	 sheetObjects[0].SetColHidden("sno",1);
 		        	 sheetObjects[1].SetColHidden("sno",1);
  		        	var sxml=CtmMakeHiddenXml(sheetObjects[0], "-1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
 		        	//ComDebug(sxml);
  		        	if (sheetObjects[0].LastRow()!= 0) sheetObjects[0].LoadSearchData(sxml,{Sync:0} );	//부적절한 total 값 수정 by 2015/06/01 황미연
 		        	var sxml=CtmMakeHiddenXml(sheetObjects[1], "-1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
 		        	//ComDebug(sxml);
 		        	if (sheetObjects[1].LastRow()!= 0) sheetObjects[1].LoadSearchData(sxml,{Sync:0} );	//부적절한 total 값 수정 by 2015/06/01 황미연
 		        	 document.form.l1.className='Obj1';
 		        	 document.form.l2.className='Obj1';
		        	 document.form.m1.className='Obj2';
 		        	 document.form.m2.className='Obj2';
 		        	 document.form.u1.className='Obj2';
 		        	 document.form.u2.className='Obj2';
  		        	sheetObjects[0].RenderSheet(1);
 		        	sheetObjects[1].RenderSheet(1);
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
         obj=document.form.flgrslt;
         //obj.attachEvent("onclick", eval("flgslt_click"));
         axon_event.addListener( 'click' , 'flgslt_click'   , "flgrslt" );
         axon_event.addListener( 'click' , 'mv_type_click'   , "mv_type" );
         axon_event.addListener('blur', 'getEtaEtdTime', 'vls_cd');
         axon_event.addListener('blur', 'getEtaEtdTime', 'pol_cd');
         setEventProcess();
         objs=document.form.locl_type;
         for (var i=0;i<objs.length;i++){
        	 document.form.locl_type[i].disabled = true;
         }
         //objs[0].disabled=true;
         //objs[1].disabled=true;
         //objs[2].disabled=true;
         if (document.form.vls_cd.value != '')
        	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         else
        	// document.form.vls_cd.focus();
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
     }
	 /*
	  * returning XML String
	  * @param sheet_obj
	  * @param pMatch     : 
	  * @saveColName      : 
	  */
      function CtmMakeHiddenXml(sheet_obj, pMatch, saveColName)  {
          try {
              var allXml="";
              var sColSep="•";
              var sColOrder="";
              if (saveColName!=undefined && saveColName != null && saveColName!="") {
                  sColOrder=" COLORDER='" + saveColName + "' ";
              }
              allXml="<?xml version='1.0'  ?>\n"
                     + "<SHEET>\n"
              allXml += "  <DATA " + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
              var aryTRs="";
              var sheetText=sheet_obj.GetRangeText(sheet_obj.HeaderRows(),0,sheet_obj.LastRow(),sheet_obj.LastCol(),sColSep,"^");
              var aryTRs=sheetText.split("^");
              for (var i in aryTRs) {
            	  if(sheet_obj.GetCellValue(parseInt(i)+sheet_obj.HeaderRows(), "mat") == pMatch)
                	 aryTRs[i]="<TR HIDDEN=\"TRUE\"><![CDATA["+aryTRs[i]+"]]></TR>";
                 else
                	 aryTRs[i]="<TR><![CDATA["+aryTRs[i]+"]]></TR>";
              }
              allXml += aryTRs.join("\n");
              allXml += "  </DATA>\n"
                     +  "</SHEET>";
              return allXml;
          } catch(err) { ComFuncErrMsg(err.message); }
      }
    /**
     * retrieving ETA/ETD 
     */
    function getEtaEtdTime() {
     	formObj=document.form;
		if (formObj.pol_cd.value == '') return;
		if (formObj.vls_cd.value == '') return;
     	strQuery="f_cmd=" + SEARCH02 + "&p_vvd=" + formObj.vls_cd.value
		if (formObj.flgrslt[0].checked) {
			strQuery=strQuery + "&p_pol=" + formObj.pol_cd.value;
			strQuery=strQuery + "&p_pod=";
		} else {
			strQuery=strQuery + "&p_pod=" + formObj.pol_cd.value;
			strQuery=strQuery + "&p_pol=";
		}
     	rtnXml=sheetObjects[0].GetSearchData("EES_CTM_0406GS.do",  strQuery );
		rtnValue=ComGetEtcData(rtnXml, "rtnStr");
		rtnStr=rtnValue.split("|");
		if (formObj.flgrslt[0].checked)
			str=rtnStr[0];
		else
			str=rtnStr[1];
		formObj.eta_etd.value=str;
     }
    /**
     * controlling screen when clicking radio button
     */
     function mv_type_click() {
    	 ibj=document.form.mv_type;
		 obj=document.form.locl_type;
    	 if (ibj[0].checked == true){
    		 obj[0].checked=true;
			 obj[0].disabled=false;
			 obj[1].disabled=false;
			 obj[2].disabled=false;
    	 } else {
    		 obj[0].checked=true;
			 obj[0].disabled=true;
			 obj[1].disabled=true;
			 obj[2].disabled=true;
    	 }
     }
     /**
      * retrieving ETA/ETD when clicking radio button
      */
     function flgslt_click() {
    	 obj=document.form.flgrslt;
    	 for (i=0; i <=2; i++) {
    		 if (obj[i].checked == true)
    		 {
    			 val=obj[i].value;
				 objs=document.form.mv_type;
    			 if (i == 2) {
    				 objs[0].checked=true;
    				 objs[0].disabled=true;
    				 objs[1].disabled=true;
    			 } else {
    				 objs[0].disabled=false;
    				 objs[1].disabled=false;
    			 }
    			 objs=document.form.locl_type;
    			 if (i == 0) {
    				 objs[0].checked=true;
    				 objs[0].disabled=true;
    				 objs[1].disabled=true;
    				 objs[2].disabled=true;
    			 } else {
    				 objs[0].disabled=false;
    				 objs[1].disabled=false;
    				 objs[2].disabled=false;
    			 }
    		 }
    	 }
    	 getEtaEtdTime();
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
		               (10, 0, 0, true);
		               var HeadTitle1="|Seq.|Seq.|Container No.|TP/SZ|F/M|STS|Org Yard|Booking No.";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"HidSta" },
		                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                      {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sno" },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"full_fg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"org_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:93,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mat",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                
		               InitColumns(cols);
		
		               SetEditable(1);
//		               SetSheetHeight(362);
		               resizeSheet1();
                 }
                 break;
             case 2:      //sheet2 init
            	    with(sheetObj){
		               (10, 0, 0, true);
		               var HeadTitle1="|Seq.|Seq.|Container No.|T/S|F/M|STS|Org Yard|MSG";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"HidSta" },
		                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                      {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sno" },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"full_fg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"org_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mat",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                
		               InitColumns(cols);
		
		               SetEditable(1);
//		               SetSheetHeight(362);
		               resizeSheet2();
                 }
                 break;
         }
     }
     //handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         formObj=document.form;
          switch(sAction)
         {
            case IBSEARCH:     
                 if(validateForm(sheetObj,formObj,sAction)) {
            	
   	         	sheetObjects[0].WaitImageVisible=false;
   	         	sheetObjects[1].WaitImageVisible=false;   	         	
            	sheetObjects[0].RenderSheet(1);
            	sheetObjects[1].RenderSheet(1);
            	ComOpenWait(true);
            	sheetObjects[0].SetColHidden("Seq",0);
	        	sheetObjects[1].SetColHidden("Seq",0);
	        	sheetObjects[0].SetColHidden("sno",1);
	        	sheetObjects[1].SetColHidden("sno",1);
	        	
	    	   	yard1=formObj.pol_cd.value;
	            yard2=formObj.yard2.value;
	            formObj.p_yard.value=yard1 + yard2;
	        	
            	formObj.f_cmd.value=SEARCH;
       	   		sheetObj.SetDataAutoTrim(0);
       	   		xml=sheetObj.GetSearchData("EES_CTM_0413GS.do", FormQueryString(formObj));
      	   		rtnValue=xml.split("|$$|");
      	   		try {
      	   			sheetObjects[0].LoadSearchData(rtnValue[0],{Sync:1} );
      	   		} finally {
      	   			sheetObjects[1].LoadSearchData(rtnValue[1],{Sync:0} );
      	   		}

      	   	
             }
        	 sheetObjects[0].RenderSheet(1);
        	 sheetObjects[1].RenderSheet(1);
   	         ComOpenWait(false);
   	         sheetObjects[0].SetWaitImageVisible(1);
   	         sheetObjects[1].SetWaitImageVisible(1);
   	         i--;
   	         break;
         }
     }
     /**
      * handling process for input validation
      */
     function sheet2_OnSearchEnd(sheetObj, ErrMsg)
     {
    	var formObj=document.form;
    	document.form.u2.value=0;
     	document.form.u1.value=0;
     	document.form.l2.value=0;
     	document.form.l1.value=0;
	   	document.form.m1.value=0;
	   	document.form.m2.value=0;
    	data0=sheetObjects[0].GetRangeText(sheetObjects[0].HeaderRows(), 3, sheetObjects[0].LastRow(), 3); // sheet1 OnSearchEnd
        data1=sheetObjects[1].GetRangeText(sheetObjects[1].HeaderRows(), 3, sheetObjects[1].LastRow(), 3); // sheet2 OnSearchEnd
        
        var arrData0=data0.split("^");
        var countA=0;
        //var matchA = "";
        if (sheetObjects[0].GetCellValue(1,3) != -1) {
	            for(var i=0 in arrData0){
	             if(data1.indexOf(arrData0[i]) != -1){
	              countA ++;
	              sheetObjects[0].SetCellValue(Number(i) + 1, "mat","1",0);
	              //matchA += "|"+i;
	             } else
	            	sheetObjects[0].SetCellValue(Number(i) + 1, "mat","0",0);
	            }
  	   		formObj.l1.value=sheetObjects[0].LastRow();
        } else
        formObj.l1.value=0
        document.form.m1.value=countA;
        var arrData1=data1.split("^");
        var countB=0;
        //var matchB = "";
        if (sheetObjects[1].GetCellValue(1,3) != -1) {
	            for(var i=0 in arrData1){
	             if(data0.indexOf(arrData1[i]) != -1){
	              countB ++;
	              sheetObjects[1].SetCellValue(Number(i) + 1, "mat","1",0);
	              //matchB += "|"+i;
	             } else
	            	sheetObjects[1].SetCellValue(Number(i) + 1, "mat","0",0);
	            }
  	   		formObj.l2.value=sheetObjects[1].LastRow();
        } else
        	formObj.l2.value=0;
        document.form.m2.value=countB;
	   	formObj.u1.value=formObj.l1.value - countA;
	   	formObj.u2.value=formObj.l2.value - countB;
     }
     
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
         /**
          * validation
          * adding process for list in case of needing batch processing with other items 
          * defining list on the top of source
          */
         function checkValidation(formObject)
         {
        	 return true;
         }
         function resizeSheet1(){
     		ComResizeSheet(sheetObjects[0]);
     	}
         function resizeSheet2(){
     		ComResizeSheet(sheetObjects[1]);
     	}
