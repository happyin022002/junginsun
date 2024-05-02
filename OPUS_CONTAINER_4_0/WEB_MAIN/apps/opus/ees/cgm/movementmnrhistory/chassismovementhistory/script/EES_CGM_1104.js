/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1104.js
*@FileTitle  : General Chassis Movement Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_1104 : business script for ees_cgm_1104
     * @cla
     */
  
   	/* developer job	*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var appendCondParam=null;
 var appendPageNo=1;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** use additional sheet var in case of more than 2 tap each sheet *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
             case "ComOpenPopupWithTarget":
             	var tmp=formObject.location.value;
             	if(tmp == "R")
             	{
             		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
             	}else if(tmp == "L")
             	{
             		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
             	}else if(tmp == "S")
             	{
             		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
             	}
       			break;
 				case "btn_retrieve":
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;
 				case "btn_new":
 					objectClear();
               	    sheetObject1.RemoveAll();
 					break;
 				case "btn_downexcel":
 					if(sheetObject1.RowCount() < 1){//no data
 		     			ComShowCodeMessage("COM132501");
 		     		}else{
 		     			sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
 		     		}
 					break;
 				case "btn_master":
 					doActionPageMove(sheetObject1,formObject,srcName);
 					break;
 				case "btn_mvmt":
 					doActionPageMove(sheetObject1,formObject,srcName);
 					break;
                case "btn_more":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCHAPPEND, appendCondParam, appendPageNo);
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
     function doActionPageMove(sheetObj, formObj, btnName){
         formObj.f_cmd.value="";
         formObj.method="POST";
         formObj.target="";
         if(formObj.eq_no.value==""){
        	 ComShowCodeMessage("CGM10012");
         } else {
        	 if (btnName == "btn_mvmt"){
//        		 formObj.action = "EES_CGM_1105.do?pgmNo=EES_CGM_1105";
//            	 formObj.submit();
 		  		var pgmNo='EES_CGM_1105';
		  		var pgmUrl='/opuscntr/EES_CGM_1105.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';
		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value+"&to_day=" +document.form.chss_mvmt_dt.value;   
		    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
             } else if (btnName == "btn_master"){
 		  		var pgmNo='EES_CGM_1003';
		  		var pgmUrl='/opuscntr/EES_CGM_1003.do';
		  		var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value ;   
		    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj=window.open(pgmUrl+"?parentPgmNo="+parentPgmNo+src,"",sFeatures);
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
      function objectClear(){
    	  var formObj=document.form;
//    	  formObj.reset();
    	  var sheetObject=sheetObjects[0];
    	  formObj.scc_cd.value="";
    	  formObj.days.value="";
    	  eq_tpsz_cd.SetSelectText('ALL', false);
    	  agmt_lstm_cd.SetSelectText('ALL', false);
//    	  formObj.aciac_div_cd.text = "ALL";
    	  formObj.Include.checked=false;
    	  formObj.location.value="S";
    	  chss_pool_cd.SetSelectText("Include Pool Chassis", false);
    	  formObj.aciac_div_cd.value="A";
    	  ComBtnDisable("btn_more");
    	  formObj.pngcnt.value ="";
    	  formObj.ttl_knt.value ="";
      }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         //
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //
             ComEndConfigSheet(sheetObjects[i]);
             comboObjects[comboCnt++]=agmt_lstm_cd;
             comboObjects[comboCnt++]=eq_tpsz_cd;
             comboObjects[comboCnt++]=chss_pool_cd;
             comboObjects[comboCnt++]=chss_mvmt_sts_cd;
             for(var k=0;k<comboObjects.length;k++){
       	        initCombo(comboObjects[k]);
      	     }  
//             for(var k=0;k<comboObjects.length;k++){
//       	        initCombo(comboObjects[k]);
//      	     }  
//          // POOl
//           	
//           	for(var k=0;k<comboObjects.length;k++){
//       	        initCombo(comboObjects[k]);
//      	    }
         }
         sheet1_OnLoadFinish(sheetObjects[0]);
     }
      /**
      * 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {//Cuong Le : not support anymore,but I don't know how to converted this function
         sheetObj.SetWaitImageVisible(0);
         formObj=document.form;
         // axon event regist
         axon_event.addListener('change', 'obj_change' , 'location');  
//         doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
//         doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
//         doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
//         doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
     	 doActionIBSheet(sheetObjects[0], document.form, IBRESET);
//         
         // axon event regist
//         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//         axon_event.addListener('change', 'obj_change' , 'scc_cd'  ); 
//         axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
////         axon_event.addListener('focusout', 'obj_focusout' , 'scc_cd'    ); 
         formObj.location.value="S";
         formObj.aciac_div_cd.value="A";
         initControl(sheetObjects[0]);   
		 sheetObj.SetWaitImageVisible(1);
    }
      /**
      * init control of form <br>
      * @param  {object} sheetObj	
      * @return 
      * @author 
      * @version
      */
     function initControl(sheetObj){
     	// Form object
     	  formObj=document.form;
         // axon event regist
         agmt_lstm_cd.SetSelectText('ALL', false);
         eq_tpsz_cd.SetSelectText('ALL', false);
         chss_pool_cd.SetSelectText("Include Pool Chassis", false);
         // button Disable
         ComBtnDisable("btn_more");
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 				var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {
	                 document.form.pagerows.value=1000;
	                 var HeadTitle="|Seq.|Chassis No.|TP/SZ|Term|Yard|Status|MVMT|Movement Date|Staying Days|Container No.|M.G.Set No.|B/L No.|Booking No.|Trucker|Trucker Description|Shipper|Shipper Description|Consignee|Consignee Description|UPDATE USER ID|";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);
	                 var cols = [ {Type:"Status",    Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
	                        {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"aciac_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chss_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"chss_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"days",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mg_set_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"booking",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"conignee1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"conignee",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"consigne",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ttl_knt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                  
	                 InitColumns(cols);
	                 //SetSheetHeight(402);
	                 SetEditable(1);
	                 resizeSheet();
					}
                 break;
         }
     }
     
     function resizeSheet(){
    	ComResizeSheet( sheetObjects[0],50 );
     }
     
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
         //sheetObj.ShowDebugMsg = false;
         switch(sAction) {
            case IBSEARCH:      //retrieve
                 if(formObj.Include.checked== true) {    
                	 formObj.np.value='Y';
                 } else {
                	 formObj.np.value='N';
                 }
                formObj.f_cmd.value=SEARCH;
  			 	appendCondParam=FormQueryString(formObj);
//  			 	prompt("FormQueryString(formObj)" , appendCondParam); return;
//  			 	 sheetObj.Redraw = false;
  			 	 if(!validateForm(sheetObj,formObj,sAction)) return;
  			 	 sheetObj.SetWaitImageVisible(0);
 			 	 ComOpenWait(true);
 			 	 var sXml=sheetObj.GetSearchData("EES_CGM_1104GS.do", appendCondParam);
 			     sheetObj.LoadSearchData(sXml,{Sync:1} );
 			 	 ComOpenWait(false);
                 for(i=1; i < sheetObj.RowCount() + 1; i++){
                	 if(sheetObj.GetCellValue(i, "aciac_div_cd") == "In-active"){
          				sheetObj.SetRowFontColor(i,"#FF0000");
          			}
          	     }
                 var ttl_knt=0;
                 var pngcnt=0;
                 if(sheetObj.RowCount()>0){
                	 ttl_knt=sheetObj.GetCellValue(1, "ttl_knt");
                	 formObj.ttl_knt.value=ComAddComma2(sheetObj.GetCellValue(1, "ttl_knt"), "#,###");
                 }
                 //formObj.pngcnt.value = "1,000";
                 formObj.eq_no.value="";
                 formObj.chss_mvmt_dt.value="";
                 appendPageNo=1;
                 pngcnt=ComReplaceStr(formObj.pngcnt.value,",","")
                 if (pngcnt < ttl_knt) {
                     appendPageNo=appendPageNo + 1;
                     ComBtnEnable("btn_more");
                 } else {
                     ComBtnDisable("btn_more");
                 }
                 break;
            case IBSEARCHAPPEND:    //Append retrieve
//	  			 	 if(!validateForm(sheetObj,formObj,sAction)) return;
		 	     sheetObj.SetWaitImageVisible(0);
	 	         ComOpenWait(true);
	 	         sheetObj.DoSearch("EES_CGM_1104GS.do",  CondParam+"&"+"&i_page=" + appendPageNo,{Append:true} );
                 for(i=1; i<sheetObj.RowCount()+1; i++){
                	 if(sheetObj.GetCellValue(i, "aciac_div_cd") == "In-active"){
          				sheetObj.SetRowFontColor(i,"#FF0000");
          			}
          	     }
                 var ttl_knt=0;
                 var pngcnt=0;
                 pngcnt=ComReplaceStr(formObj.pngcnt.value,",","")
                 ttl_knt=ComReplaceStr(formObj.ttl_knt.value,",","")
                 if (pngcnt < ttl_knt) {
                     appendPageNo=appendPageNo + 1;
                     ComBtnEnable("btn_more");
                 } else {
                     ComBtnDisable("btn_more");
                 }
                 formObj.eq_no.value="";
                 formObj.chss_mvmt_dt.value="";
                 ComOpenWait(false);
            break;
          case IBSEARCH_ASYNC02:	// Term Code Combo retrieve
	       	formObj.f_cmd.value=SEARCH;
	       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
	       	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	   		var sStr=ComGetEtcData(sXml,"comboList");    			
	   		var arrStr=sStr.split("@");
	   		// combo control, result string, Text Index, Code Index
	  			MakeComboObject2(agmt_lstm_cd, arrStr, 0, 0);
	       	break;
          case IBSEARCH_ASYNC03:	// Term Code Combo retrieve
	       	formObj.f_cmd.value=SEARCH;
	       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01940;		// code type setting ( AGREEMENT LEASE TERM CODE )
 	   		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	   		var sStr=ComGetEtcData(sXml,"comboList");    			
	   		var arrStr=sStr.split("@");
	   		// combo control, result string, Text Index, Code Index
	  			MakeComboObject2(eq_tpsz_cd, arrStr, 0, 0);
	       	break;
          case IBSEARCH_ASYNC04:	
        		formObj.f_cmd.value=SEARCH02;
        		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
        		ss=ComCgmXml2ComboString(sXml, "TOTAL");
        		var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
        		//IBSHEET GRID outer combo
        		makeCPMultiCombo(chss_pool_cd, cols, 0, 0);
         	  	break;
          case IBSEARCH_ASYNC05:	// Term Code Combo retrieve
	       	formObj.f_cmd.value=SEARCH;
	       	formObj.loc_cd.value=formObj.scc_cd.value;		//   ( location)
	       	var sXml=sheetObj.GetSearchData("cgm_Check_LocationGS.do", FormQueryString(formObj));
	   	// data count
	        var dataCount=ComGetTotalRows(sXml);
	        if(dataCount==0){
	        	ComShowCodeMessage('CGM10009','location cd');
		   		formObj.scc_cd.value="";
//		   		formObj.scc_cd.focus();
	        }
	       	break;
   	    case IBSEARCH_ASYNC08:
 	    	formObj.f_cmd.value=SEARCH17;
 	    	var location=formObj.location.value;
 	    	if(location == "R")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value="RCC";
 	    		formObj.eq_orz_cht_rcc_cd.value=formObj.scc_cd.value;
 	    	}else if(location == "L")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value="LCC";
 	    		formObj.eq_orz_cht_lcc_cd.value=formObj.scc_cd.value;
 	    	}else if(location == "S")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value="SCC";
 	    		formObj.eq_orz_cht_scc_cd.value=formObj.scc_cd.value;
 	    	}else
 	    	{
 	    		formObj.eq_orz_cht_chktype.value="";
 	    		formObj.eq_orz_cht_scc_cd.value="";
 	    	}
 	    	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
 	   		// data count
 	        var dataCount=ComGetTotalRows(sXml);
 	        if(dataCount==0){
 	        	ComShowCodeMessage('CGM10009','location cd');
 		   		formObj.scc_cd.value="";
// 		   		formObj.scc_cd.focus();
 	        }
 	  	    break;	
	   	 case IBRESET:
	 		var idx=0
	 		var sXml2=document.form2.sXml.value;
	 		var arrXml=sXml2.split("|$$|");
	 		//agmt_lstm_cd
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1=new Array();
	 		for ( var i=0; i < vArrayListData.length; i++) {
	 		    vListData=vArrayListData[i];
	 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, result string, Text Index, Code Index
		  	MakeComboObject2(agmt_lstm_cd, arrStr1, 0, 0);     
		  	agmt_lstm_cd.DeleteItem(agmt_lstm_cd.FindItem("NP",0,1));
	 		idx++;       
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1=new Array();
	 		for ( var i=0; i < vArrayListData.length; i++) {
	 		    vListData=vArrayListData[i];
	 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, result string, Text Index, Code Index
		  	MakeComboObject2(eq_tpsz_cd, arrStr1, 0, 0);     
	 		idx++;       
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1=new Array();
	 		for ( var i=0; i < vArrayListData.length; i++) {
	 		    vListData=vArrayListData[i];
	 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, result string, Text Index, Code Index
	 		makeCPMultiCombo2(chss_pool_cd, arrStr1, 1, 0);     
	 		idx++;      
	 		if ( arrXml[idx] == null ) {return;}
			var cols2=ComCgmXml2ComboString(arrXml[idx], "code1", "code1");
     	  	ComCgmMakeMultiCombo(chss_mvmt_sts_cd, cols2[0], cols2[1], 0);
     	  	idx++;
	 		idx++;      
//		  	
	 		break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             if (formObj.scc_cd.value=="") {
            	 if(formObj.Include.checked == false)
            	 {
            		 if(formObj.chss_pool_cd_text.value =='Include Pool Chassis' 
            		 || formObj.chss_pool_cd_text.value =='Exclude Pool Chassis' 
            		 || formObj.chss_pool_cd_text.value =='Only Pool Chassis'){
            			 ComShowCodeMessage('CGM10004','scc_cd');
//                		 formObj.scc_cd.focus();
                		 return false; 
            		 }
            	 }
             }
             if(formObj.scc_cd.value!="" && formObj.scc_cd.value.length !=5){
	 			ComShowCodeMessage('CGM10044','Location (5)');
// 				scc_cd.focus();
 				return false;
     		}
         }
         return true;
     }
         /** 
          * Combo Object reset  <br>
          * @param  {object} comboObj	Combo Object
          * @return 
          * @author 
          * @version
          */ 
         function initCombo(comboObj) {
          	switch(comboObj.options.id) {
       	       case "agmt_lstm_cd":
       	           var cnt=0;
       	           with(comboObj) {
       	            	Code="";
       	            	Text="";
       	            	SetDropHeight(100);
       	            	SetMultiSelect(0);
       	            	SetMaxSelect(1);
       	            	SetEnable(1);
       	            	comboObj.SetUseAutoComplete(1);
       	            }
       	            break;
//       	       case "location":
//       	           var cnt=0;
//       	           with(comboObj) {
//       	            	Code = "";
//       	            	Text = "";
//       	            	DropHeight = 100;
//       	            	MultiSelect = false;
//       	            	MaxSelect = 1;	    
//       	            	UseCode = true;
//       	            	Enable = true;
//       	            }
//       	            break;
       	    case "eq_tpsz_cd":
    	           var cnt=0;
    	           with(comboObj) {
    	            	Code="";
    	            	Text="";
    	            	SetDropHeight(100);
    	            	SetMultiSelect(0);
    	            	SetMaxSelect(1);
    	            	SetEnable(1);
    	            	comboObj.SetUseAutoComplete(1);
    	            }
    	            break;
       	 case "chss_pool_cd":
	           var cnt=0;
	           with(comboObj) {
	            	Code="";
	            	Text="";
	            	SetDropHeight(100);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetEnable(1);
	            	comboObj.SetUseAutoComplete(1);
	            }
	            break;
     	case "chss_mvmt_sts_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(150);
  	            SetMultiSelect(1);
  	            SetMaxSelect(100);
  	            SetEnable(1);
  	            SetMaxLength(20);
  	        }
  	        break;
       	    }
       	} 
         function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
         	cmbObj.RemoveAll();
         	for (var i=0; i < arrStr.length;i++ ) {
         		var arrCode=arrStr[i].split("|");
         		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
              	}
         	cmbObj.SetSelectIndex("" ,false);
         }
          function MakeComboObject2(cmbObj, arrStr, txtCol, codeCol) {
          	cmbObj.RemoveAll();
          	cmbObj.InsertItem(0,"ALL","ALL");
          	for (var i=0; i < arrStr.length;i++ ) {
          		var arrCode=arrStr[i].split("|");
          		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
          	}
          	cmbObj.SetSelectIndex("" ,false);
          }
          /** 
           * add combo(POOL COMBO)
           */ 
          function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
          	cmbObj.RemoveAll();
//          	cmbObj.InsertItem(0, "", "");
          	if(arrStr == undefined ){
          		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
      			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
      			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
          	} else {
              	var arrCode=arrStr[0].split("|");
            	var arrCode2=arrStr[1].split("|");
	          	for (var i=0; i < arrCode.length;i++ ) {
	          		var arrCode3=arrCode[i].split("|");
	          		var arrCode4=arrCode2[i].split("|");
	          		if(i==0)
	          		{
	          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
	          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
	          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
	          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
	          		}
	          		else
	          		{
	          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
	          		}
	          	}
          	}
          	cmbObj.SetSelectIndex("" ,false);
          }
            /** 
             * add combo(POOL COMBO)
             */ 
            function makeCPMultiCombo2(cmbObj, arrStr, txtCol, codeCol) {
            	cmbObj.RemoveAll();
//            	cmbObj.InsertItem(0, "", "");
            	if(arrStr == undefined ){
            		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
        			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
        			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
            	} else {
                	var arrCode=arrStr[0].split("|");
	              	var arrCode2=arrStr[1].split("|");
	//            	//ComShowMessage(arrCode2);
	              	for (var i=0; i < arrStr.length;i++ ) {
	            		var arrCode=arrStr[i].split("|");
	            		if(i==0)
	  	          		{
	  	          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
	  	          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
	  	          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
	  	          			cmbObj.InsertItem(i+3, arrCode[txtCol], arrCode[codeCol]);
	  	          		}
	  	          		else
	  	          		{
	  	          			cmbObj.InsertItem(i+3, arrCode[txtCol], arrCode[codeCol]);
	  	          		}
                	}
            	}
             }
         	/** 
            * Object Keypress event handling  <br>
            * 
            * @param  
            * @return 
            * @author 
            * @version
            */ 
           function obj_keypress(){
          	 obj=event.srcElement;
          	 if(obj.dataformat == null) return;
          	 window.defaultStatus=obj.dataformat;
          	 switch(obj.dataformat) {
          	 	case "ymd":
          	 		ComKeyOnlyNumber(obj);
          	        break;
          	    case "eng":
          	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
          	        else ComKeyOnlyAlphabet('upper');
          	        break;
          	    case "engup":
          	        if(obj.name=="scc_cd") ComKeyOnlyAlphabet('uppernum')
          	        else ComKeyOnlyAlphabet('upper');
          	        break;
          	 }
           }
    function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    	document.form.eq_no.value=sheetObj.GetCellValue(Row, "eq_no");
    	var chss_mvmt_dt=sheetObj.GetCellValue(Row, "chss_mvmt_dt");
    	chss_mvmt_dt=ComReplaceStr(chss_mvmt_dt.substring(0,10),"-")
    	document.form.chss_mvmt_dt.value=chss_mvmt_dt;
    }
                   /** 
 * Object focusout event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */  
//    function obj_change(){
//    	 var formObj = document.form;
//    	 var sheetObj = sheetObjects[0]; 
//    	 obj = event.srcElement;
//    	 switch(ComGetEvent("name")){
// 	 
//    	   case "scc_cd":
//    	 		if(formObj.scc_cd.value != ''){
//    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
//    	 			break;
//    	 		} 
//    	  
//    	 }   
//    }
        /**
      * YA_CD value check
      * @return
      */
     function obj_keyup(){
		 var formObj=document.form;
		 var sheetObj=sheetObjects[0];
		 obj=event.srcElement;
		 switch(ComGetEvent("name")){
	  	 	case "scc_cd":
		 		var crntLocCd=ComTrimAll(formObj.scc_cd.value);
		   		var arrCrntLocCd=crntLocCd.split(",");
		   		for(var i=0; i < arrCrntLocCd.length; i++){
		   		// 
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.scc_cd.value="";
		 				ComSetFocus(formObj.scc_cd);
		 				break;
		 			}else{
		    	 		//if(formObj.scc_cd.value != ''){
		    	 		if(formObj.scc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		    	 	}
		 		}
		 		break;		
		 }
	}
   /** 
     * Object change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */  
    function obj_change(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0]; 
    	 obj=event.srcElement;
    	 switch(ComGetEvent("name")){
    	   	case "location":
    	    	formObj.scc_cd.value="";
    	   		break;    	   	
    	 }   
    }		 
     /**
      * Sheet1의 OnSearchEnd event handling
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         if (ErrMsg == "") {
             with(sheetObj) {
                 var frmObj=document.form;
//                 var ttl_knt = ComAddComma(frmObj.ttl_knt.value );
                 frmObj.pngcnt.value=ComAddComma(SearchRows());
//                 frmObj.rtv_total.value = ComAddComma(TotalRows);
//                 alert(ttl_knt);
             }
         }
     }
	/* developer job end */
     function chss_mvmt_sts_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//    	 document.form.chss_mvmt_sts_cd_text.value = newCode;
     }
     
     function chss_mvmt_sts_cd_OnBlur() {
//    	 document.form.chss_mvmt_sts_cd_text.value = chss_mvmt_sts_cd.GetSelectCode();
     }
