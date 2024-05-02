/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2012.jsp
*@FileTitle  : On & Off-Hire Status Summary Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_2012 : ees_cgm_2012 business script for
     */
    function ees_cgm_2012() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* developer job	*/
 // common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var comboObjects2=new Array();

var oldCntrTypeSize = "";
var sCntrTypeSize = "";

 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 var IBSEARCH02=30;
 var IBSEARCH03=31;
 // Event handler processing by button name */
 function processButtonClick(){
     /***** use additional sheet var in case of more than 2 tap each sheet *****/
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     /*******************************************************/
     var formObject=document.form;
//     var var_agmt_lstm_cd = agmt_lstm_cd.GetSelectText();
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_new":
            	 objectClear();
            	 if(formObject.str_gubun[0].checked){
            		 sheetObject1.RemoveAll();
            	 }
            	 else if (formObject.str_gubun[1].checked)
            	 {
            		 sheetObject2.RemoveAll();
            	 }
                break; 
            case "btn_retrieve":
//						
//           	 ComShowMessage(formObject.str_gubun[0].checked);
//           	 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
           	 if(formObject.str_gubun[0].checked){
           		 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
           	 }
           	 else if (formObject.str_gubun[1].checked)
           	 {
           		 doActionIBSheet(sheetObject2, formObject, IBSEARCH);
           	 }
//           	 
                break;
            case "btn_downexcel":
           	 if(formObject.str_gubun[0].checked){
           		if(sheetObject1.RowCount() < 1){//no data
           			ComShowCodeMessage("COM132501");
           		}else{
           			sheetObject1.Down2Excel();
           		}
           	 }
           	 else if (formObject.str_gubun[1].checked)
           	 {
           		if(sheetObject2.RowCount() < 1){//no data
           			ComShowCodeMessage("COM132501");
           		}else{
           			sheetObject2.Down2Excel();
           		}
           	 }
                break;                   
            case "btn_print":
	           	 if(formObject.str_gubun[0].checked){
						if( sheetObjects[0].rowcount==0 ) {
							errMsg='No data found.';
							ComShowMessage(msgs["CGM10012"]);
							return;
						}
						formObject.f_cmd.value=IBSEARCH02;
						formObject.head_eq_tpsz_cd.value = sCntrTypeSize;
						ComOpenPopupWithTarget('/opuscntr/EES_CGM_2202.do?pgmNo=EES_CGM_2202', 775, 600, "", "0,1,1,1,1,1,1", true);
		                
	         	 }
	         	 else if (formObject.str_gubun[1].checked)
	         	 {
						if( sheetObjects[1].rowcount==0 ) {
							errMsg='No data found.';
							ComShowMessage(msgs["CGM10012"]);
							return;
						}
						formObject.f_cmd.value=IBSEARCH03;
						ComOpenPopupWithTarget('/opuscntr/EES_CGM_2203.do?pgmNo=EES_CGM_2203', 775, 600, "", "0,1,1,1,1,1,1", true);
	         	 }
                break;
            case "ComOpenPopupWithTargetYard":
     			ComOpenPopup("/opuscntr/EES_LSE_0101.do", 800, 650, "setPopData_AvailYard", '1,0', true, false);//, Row, Col, 0);
     			break;
            case "ComOpenPopupWithTarget2":
            	var tmp=formObject.combo_location_text.value;
            	if(tmp == "RCC")
            	{
            		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 600,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
            	}else if(tmp == "LCC")
            	{
            		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 600,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
            	}else if(tmp == "SCC")
            	{
            		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 600,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
            	}
     			break;
            case "ComOpenPopupWithTargetKind":
       			if(formObject.kind.value=="L"){
       				ComOpenPopup('/opuscntr/COM_ENS_0C1.do?pgmNo=COM_ENS_0C1', 700, 555, "setProgramNo", "0,1,1,1,1,1", true, false);
//       			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0C1.do', 1000, 600, "vndr_seq:kind_txt", "1,0,1,1,1,1,1", true);
       			}
       			else
       			{
       				ComOpenPopup('/opuscntr/EES_CGM_2022.do?pgmNo=EES_CGM_2022', 820, 400, "setProgramNo", "0,1,1,1,1,1", true, false);
       			}
      			break;
            case "btns_Calendar1" :		// Agreement Date (From Date)
				var cal=new ComCalendar();
				cal.select(formObject.evnt_dt_str, "yyyy-MM-dd");
				break;
			case "btns_Calendar2" :		// Agreement Date (To Date)
				var cal=new ComCalendarFromTo();
	    		cal.select(formObject.evnt_dt_str,  formObject.evnt_dt_end,  'yyyy-MM-dd');
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
  * New Yard Code Pop-up Return Value handling<br>
  * chungpa 20100415 new yard popup
  */
 function setPopData_AvailYard(aryPopupData, Row, Col, sheetIdx) {
 	var formObj=document.form;
 	if(aryPopupData.length > 0) {
 		formObj.sts_evnt_yd_cd.value=aryPopupData[0][4]; //Yard
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
		var formObj=document.form;
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);
    		
    	  for(i=0;i<sheetObjects.length;i++){
    		  ComConfigSheet (sheetObjects[i] );
    		  initSheet(sheetObjects[i],i+1);
    		  ComEndConfigSheet(sheetObjects[i]);
    		  comboObjects[comboCnt++]=agmt_lstm_cd;
    		  for(var k=0;k<comboObjects.length;k++){
    			  initCombo(comboObjects[k]);
    		  }  
          }
    	  sheet1_OnLoadFinish(sheet1);
     }
      /**
      * 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.SetWaitImageVisible(0);
         formObj=document.form;
  //       axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
  //       axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);
         axon_event.addListener      ('blur',			  'obj_blur',	'evnt_dt_str','evnt_dt_end');
         axon_event.addListener('change', 'obj_change' , 'eq_aset_sts_cd','kind'   ); 
         initControl(sheetObjects[0]);   
		 sheetObj.SetWaitImageVisible(1);
		 sheet1_OnSearchEnd(sheetObj,"");
    }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //t1sheet1 init
            	    with(sheetObj){
		               var tmp
		               if(document.form.kind.value == "L"){
		            	   tmp="Lessor";
		               }else{
		            	   tmp=" AGMT No. ";
		               }
		               var HeadTitle="|Location|Term|"+tmp+"|Total";
			             
		               //making data as list for changing column
						 oldCntrTypeSize = sCntrTypeSize;
						 var arrCntrTypeSize = "";
						 if(oldCntrTypeSize != ""){
							arrCntrTypeSize = oldCntrTypeSize.split("|");
						 }
						
						 //handling header title by changing column
						 if (sCntrTypeSize != "") {
							HeadTitle += "|" + oldCntrTypeSize;
						 }
		               
		               
		               var headCount=ComCountHeadTitle(HeadTitle);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agreement" },
		                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:"total",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		               
						  var sCount = "";
						  var x = 1;
		                  var sumCount = 4;
	                      var sumNmVal = "";
						  
	 	 	              for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
						 	  if (arrCntrTypeSize.length > 1) {
						 		  sCount = "eq_tpsz_cd" + x;
						 		  if(i != arrCntrTypeSize.length){
					 			  	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:sCount,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
						 		  
					 			  	x++;
						 	  	  }
						 	  
						 		  if(i == arrCntrTypeSize.length - 1){
								  	sumNmVal += "|"+sumCount;
								  }else if(i == 0){
								  	sumNmVal += sumCount;
								  }else{
								    sumNmVal += "|"+sumCount;
								  }
								  sumCount++;

						 	  }
						  }
	 	 	              
	 	               InitColumns(cols);
		               SetEditable(1);
		           //    FitColWidth("15|15|15|20|20|20");
		               SetSheetHeight(500);
		               
		               ShowSubSum([{StdCol:1, SumCols:sumNmVal, Sort:false, ShowCumulate:false, CaptionCol:3, CaptionText:"Sub Total"}]);
                     }
                 break;
             case 2:      //t1sheet1 init
            	 with(sheetObj){
		               if(document.form.kind.value == "L"){
		            	   tmp="Lessor";
		               }else{
		            	   tmp="Agreement No. ";
		               }
		               var HeadTitle="|Seq|M.G.Set No.|"+tmp+"|Type|Term|On-hire|LCC|SCC|Yard|Event Date|System Date";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Sta" },
		                      {Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Seq",             KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"scc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"evnt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               InitColumns(cols);
		               SetEditable(1);
		               SetSheetHeight(500);
             	}
             break;
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
            if(validateForm(sheetObj,formObj,sAction)){
            	queryString="f_cmd=" + SEARCH ;
             	formObj.f_cmd.value=SEARCH;
             	
             	var locFlag = combo_location.GetSelectCode();

             	if (locFlag == "R" || locFlag == "") {
             		formObj.location.value = "R";
             	} else if (locFlag == "L") {
             		formObj.location.value = "L";
             	} else if (locFlag == "S") {
             		formObj.location.value = "S";
             	}
             	
	        	 var params=FormQueryString(formObj);
				 if(formObj.str_gubun[0].checked)
				 {
					 sheetObj.SetWaitImageVisible(0);
				 	 ComOpenWait(true);
				 	 	sheetObj.DoSearch("EES_CGM_2012GS.do",  params );
//	                 sheetObj.SumText(1,"")= "";
//	 	             
				 	 	sheetObj.SetSumText(0,3,"Grand Total");
				 	 	sheetObj.SetSumText(0,"sts_evnt_loc_cd","");
//	                 sheetObj.SumText(0,"Month")="Grand Total";
	                 ComOpenWait(false);
				 }
				 else
				 {
					 sheetObj.SetWaitImageVisible(0);
				 	 ComOpenWait(true);
				 	 sheetObj.DoSearch("EES_CGM_2012GS.do",  params );
	                 ComOpenWait(false);
				 }
	          }
                 break;
            case IBSEARCH_ASYNC01:	// Term Code Combo retrieve
		       	formObj.f_cmd.value=SEARCH;
		       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
		       	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		   		var sStr=ComGetEtcData(sXml,"comboList");    			
		   		var arrStr=sStr.split("@");
		   		// combo control, result string, Text Index, Code Index
		  			MakeComboObject(agmt_lstm_cd, arrStr, 0, 0);
		       	break;
	       case IBSEARCH_ASYNC02:	// Office Code  Validation check 
			   /*	formObj.f_cmd.value=COMMAND01;
			   	formObj.ofc_cd.value=formObj.scc_cd.value;
				var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj));
			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Office');
			   		formObj.sts_evnt_ofc_cd.value="";
//			   		formObj.sts_evnt_ofc_cd.focus();
			   	}
			   	*/
			   	break;
	 	   case IBSEARCH_ASYNC03:	// Office Code  Validation check
			   	formObj.f_cmd.value=COMMAND01;
			   	formObj.yd_cd.value=formObj.sts_evnt_yd_cd.value;
			   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.sts_evnt_yd_cd.value="";
			   		// chungpa 20100414 keyup->focusout start
//			   		//formObj.sts_evnt_yd_cd.focus();
   			   	    // chungpa 20100414 keyup->focusout end
			   	}
			   	break;
	 	  case IBSEARCH_ASYNC04:	// Term Code Combo retrieve
		       	formObj.f_cmd.value=SEARCH;
		       	formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting ( AGREEMENT LEASE TERM CODE )
		       	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		   		var sStr=ComGetEtcData(sXml,"comboList");    			
		   		var arrStr=sStr.split("@");
		   		// combo control, result string, Text Index, Code Index
		  			MakeComboObject2(combo_location, arrStr, 0, 0);
		       	break;
     	  case IBSEARCH_ASYNC05:	// ( location)retrieve
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
	       	
      	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
        	formObj.f_cmd.value = SEARCH21;
    		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
			var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
			sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
			
			//getting changing column information from server
			oldCntrTypeSize = sCntrTypeSize;
			
			break;
	       	
 	    case IBSEARCH_ASYNC08:
 	    	formObj.f_cmd.value=SEARCH17;
 	    	var location=formObj.combo_location_text.value;
 	    	if(location == "RCC")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value="RCC";
 	    		formObj.eq_orz_cht_rcc_cd.value=formObj.scc_cd.value;
 	    	}else if(location == "LCC")
 	    	{
 	    		formObj.eq_orz_cht_chktype.value="LCC";
 	    		formObj.eq_orz_cht_lcc_cd.value=formObj.scc_cd.value;
 	    	}else if(location == "SCC")
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
		  	MakeComboObject(agmt_lstm_cd, arrStr1, 0, 0);
	 		idx++;       
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1=new Array();
	 		for ( var i=0; i < vArrayListData.length; i++) {
	 		    vListData=vArrayListData[i];
	 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, result string, Text Index, Code Index
		  	MakeComboObject2(combo_location, arrStr1, 0, 0);
	 		idx++;       
//		  	
	 		break;
         }
     }
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
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                 }
              break;
          }
     }
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	//-----------------------------------------//
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab=nItem;
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
     		 switch(sAction) {
     		 	case IBSEARCH:
//     		 		ComShowMessage(location.text);
     		 		combo_location.value=document.form.combo_location_text.value;
//     		 		 
     		 		if(evnt_dt_str.value == ''){
            				ComShowCodeMessage('CGM10004','Period ');
//            				evnt_dt_str.focus();
            				return false;
            			}	
     		 		if(evnt_dt_end.value == ''){
            				ComShowCodeMessage('CGM10004','Period ');
//            				evnt_dt_end.focus();
            				return false;
            			}
     		 		 var dt_str=ComReplaceStr(document.form.evnt_dt_str.value,"-","");
         			 var dt_end=ComReplaceStr(document.form.evnt_dt_end.value,"-","");
     	    		if(dt_str != '' && dt_end != ''){
     	    			if(dt_end < dt_str){
     	    				ComShowCodeMessage('COM12133','To date','From date','greater');
     	    				evnt_dt_str.value='';
//     	    				evnt_dt_str.focus();
     	    				return false;
     	    			}
     	    		}
     		 		if(combo_location.value == ''){
            				ComShowCodeMessage('CGM10004','location ');
//            				location.focus();
            				return false;
            			}
     		 		if(scc_cd.value == ''){
            				ComShowCodeMessage('CGM10004','scc_cd');
//            				scc_cd.focus();
            				return false;
            			}
    		 		if(scc_cd.value.length !=5){
    		 			ComShowCodeMessage('CGM10044','Location (5)');
//           				scc_cd.focus();
           				return false;
           			}
    		 		if(sts_evnt_yd_cd.value!= '' && sts_evnt_yd_cd.value.length !=7){
    		 			ComShowCodeMessage('CGM10044','Yard(7)');
//           				scc_cd.focus();
           				return false;
           			}
            			break;
     		 }      
     	 }
          return true;
     }
     /** 
      * Object deactivate event handling  <br>
      * @param  
      * @return 
      * @author 
      * @version
      */
      function domFunFocusDel(a)
      {
      	var formObj=document.form;
        	 obj=event.srcElement;
        	if(obj.name=="evnt_dt_str"  ){
        		document.form.evnt_dt_str.value=ComReplaceStr(document.form.evnt_dt_str.value,"-","");
            }
          if(obj.name=="evnt_dt_end"  ){
          		document.form.evnt_dt_end.value=ComReplaceStr(document.form.evnt_dt_end.value,"-","");
           }
         //ComShowMessage("domFunFocusDel");
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
		   	  	            SetDropHeight(180);
		   	  	            SetMultiSelect(1);
		   	  	            SetMaxSelect(100);
		   	  	            SetEnable(1);
			   	            SetMaxLength(20);
		   	  	       }
	   	    	   /*
	   	           var cnt=0;
	   	           with(comboObj) {
	   	            	Code="";
	   	            	Text="";
	   	            	SetDropHeight(100);
	   	            	SetMultiSelect(0);
	   	            	SetMaxSelect(1);
	   	            	SetEnable(1);
	   	            	comboObj.SetUseAutoComplete(1);
	   	           }*/
    	            break;
    	       case "combo_location":
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
    	    }
    	} 
    /**
     * init control of form <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version
     */
    function initControl(sheetObj){
    	formObj=document.form;
    	doActionIBSheet(sheetObj, formObj, IBRESET);
     	document.form.combo_location_text.value='RCC';
    }
     /** 
      * Object Keypress event handling  <br>
      * 
      * @param  
      * @return 
      * @author 
      * @version
      */ 
//     function obj_keypress(){
//    	 obj=event.srcElement;
//    	 if(obj.dataformat == null) return;
//    	 window.defaultStatus=obj.dataformat;
//    	 switch(obj.dataformat) {
//    	 	case "ymd":
//    	 		ComKeyOnlyNumber(obj);
//    	        break;
//    	    case "eng":
//    	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
//    	        else ComKeyOnlyAlphabet('upper');
//    	        break;
//    	    case "engup":
//    	        if(obj.name=="scc_cd") ComKeyOnlyAlphabet('uppernum')
//    	        else ComKeyOnlyAlphabet('upper');
//    	        break;
//    	 }
//     }
      /** 
       * Object deactivate event handling  <br>
       * @param  
       * @return 
       * @author 
       * @version
       */
      function obj_deactivate(){
     	 var formObj=document.form;
     	 obj=event.srcElement;
     	 if(obj.name=="evnt_dt_str"  ){
     		 with(formObj){
     			 var creDtFr=ComReplaceStr(evnt_dt_str.value,"-","");
  	        }
  	        ComChkObjValid(event.srcElement);
         }
       	if(obj.name=="evnt_dt_end"  ){
    		 with(formObj){
    			 var creDtFr=ComReplaceStr(evnt_dt_end.value,"-","");
  	        }
  	        ComChkObjValid(event.srcElement);
        }
      }
       function setProgramNo(aryPopupData, row, col, sheetIdx){
      	 var formObj=document.form;
       	 var vndrSeq="";
       	 var vndrNm="";
       	 var i=0;
//           	 ComShowMessage('setProgramNo'+aryPopupData.length);
       	 for(i=0; i < aryPopupData.length; i++){
       		 vndrSeq=vndrSeq + aryPopupData[i][2];
       		/* if(aryPopupData.length == 1){
       			 vndrNm=vndrNm + aryPopupData[i][4];
       		 }*/
       		 if(i < aryPopupData.length - 1){
       			 vndrSeq=vndrSeq + ",";
       		 }
//           		ComShowMessage('vndrSeq=='+vndrSeq);
       	 }
       	  formObj.vndr_seq.value=vndrSeq;
       }
        function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
        	cmbObj.RemoveAll();
          	for (var i=0; i < arrStr.length;i++ ) {
          		var arrCode=arrStr[i].split("|");
          		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
          	}
          	/*
          	cmbObj.InsertItem(0,"ALL","");
          	for (var i=0; i < arrStr.length;i++ ) {
          		var arrCode=arrStr[i].split("|");
          		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
          	}
          	cmbObj.SetSelectIndex("" ,false);
          	*/
        }
         function MakeComboObject2(cmbObj, arrStr, txtCol, codeCol) {
         	cmbObj.RemoveAll();
//         	cmbObj.InsertItem(0,"","");
         	for (var i=0; i < arrStr.length;i++ ) {
         		var arrCode=arrStr[i].split("|");
         		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
              	}
//         	cmbObj.Index2 = "" ;
         }
         
         function objectClear(){
         	var formObj=document.form;
         	var sheetObject=sheetObjects[0];
         	var sheetObject1=sheetObjects[1];
         	
	       	if(formObj.str_gubun[0].checked== true)
	       	{
	       		formObj.reset();
	       		formObj.str_gubun[0].checked=true;
	       	}
	       	else
	       	{
	       		formObj.reset();
	       		formObj.str_gubun[1].checked=true;
	       	}
	       	
	      //IBMultiCombo reset
         	combo_location.SetSelectCode("R");
	       	agmt_lstm_cd.SetSelectCode("");
	       	
			//formObj.agmt_lstm_cd.text ='ALL'; 
//             	formObj.eq_spec_no.Code = "";
//             	formObj.vndr_seq.Code = "";
//
//             	formObj.eq_tpsz_cd.Code = "UMG";
//             	sheetObject1.RowStatus(1)="I";
//             	sheetObject1.CellValue(1, "eq_knd_cd") = "G";
//             	sheetObject1.CellValue(1, "mgst_vltg_capa") = "220";
//             	formObj.mgst_vltg_capa[0].checked = true;
         }
         
       	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
     	{
       			
     		with(sheetObj)
     		{
     			
//     			ShowSubSum([{StdCol:1, SumCols:"4|5|6", Sort:false, ShowCumulate:false, CaptionCol:3, CaptionText:"Sub Total"}]);
     			
//     			ShowSubSum(1, "4|5|6|7|8|9|10|11|12|13|14",-1, true, false, 0, "vndr_seq=Sub Total");
     		}	
     	}
       	function chk(a)
        {
     	   var objs=document.all.item("tabLayer");
     	   var sheetObj=sheetObjects[0];  
     	   var sheetObj2=sheetObjects[1];   
     	   if(a=="1")
     	   {
     		   objs[1].style.display="none";
 	           objs[0].style.display="Inline";
 	           sheetObj.RemoveAll();
 	            if(formObj.kind.value=="L") {
					sheetObj.GetCellValue(0, 3, "Lessor");
					sheetObj2.GetCellValue(0, 3, "Lessor");
	   		    } else {
					sheetObj.GetCellValue(0, 3, "Agreement No.");
					sheetObj2.GetCellValue(0, 3, "Agreement No.");
	   		    }
     	   }
     	   else
     	   {
     		   objs[0].style.display="none";
 	           objs[1].style.display="Inline";
 	           sheetObj2.RemoveAll();
 	           if(formObj.kind.value=="L") {
					sheetObj.GetCellValue(0, 3, "Lessor");
					sheetObj2.GetCellValue(0, 3, "Lessor");
	   		   } else {
					sheetObj.GetCellValue(0, 3, "Agreement No.");
					sheetObj2.GetCellValue(0, 3, "Agreement No.");
	   		   }
     	   }
        }
       	/** 
         * location change event handling  <br>
         * @param  
         * @return 
         * @author 
         * @version
         */    
//        function combo_location_OnChange()
//        {
//       	  Grid_Remove();
//        }
        /** 
        * agmt_lstm_cd_OnChange change event handling  <br>
        * @param  
        * @return 
        * @author 
        * @version
        */    
//        function agmt_lstm_cd_OnChange()
//        {
//       	 Grid_Remove();
//        }
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
        	 var sheetObj2=sheetObjects[1];
        	 obj= ComGetEvent();
        	 switch(ComGetEvent("name")){
        	   case "kind":
        		    formObj.vndr_seq.value='';
        		    Grid_Remove();
        		    if(formObj.kind.value=="L") {
						sheetObj.SetCellValue(0, 3, "Lessor");
						sheetObj2.SetCellValue(0, 3, "Lessor");
        		    } else {
						sheetObj.SetCellValue(0, 3, "Agreement No.");
						sheetObj2.SetCellValue(0, 3, "Agreement No.");
        		    }
        	 		break;    	 	
//        	   case "eq_aset_sts_cd":
//    	    	    Grid_Remove();
//    		 		break;    	
        	 }   
        }
      /**
      * YA_CD value check
      * @return
      */
     function obj_keyup(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 obj=event.srcElement;
    	 switch(ComGetEvent("name")){
    	 	case "sts_evnt_yd_cd":
    		    ComKeyEnter('lengthnextfocus');    	 
    		    /*
	    	    var sts_evnt_yd_cd;
    	    	sts_evnt_yd_cd=formObj.sts_evnt_yd_cd.value;
    	    	if (sts_evnt_yd_cd.length == 7) {
    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	    	}*/
    	    	break;
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
         function  Grid_Remove()
         {
        	 var formObj=document.form;
        	 var sheetObj=sheetObjects[0];  
      	     var sheetObj2=sheetObjects[1];
    	  	 if(formObj.str_gubun[0].checked){
    	  		 sheetObj.RemoveAll();
    	  	 }
    	  	 else if (formObj.str_gubun[1].checked)
    	  	 {
    	  		sheetObj2.RemoveAll();
    	  	 }   	
         }
         /**
          * AXON event handling
          */
         function obj_activate(){
             ComClearSeparator(event.srcElement);
         }
       	/**
       	 * detailpage double double click -> Equipment No M.G.Set Master Inquiry page show <br>
       	 * 
       	 * @author 
       	 * @version 
       	 */   
        function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH)
        {
        	var formObject=document.form;
           	if(formObject.str_gubun[0].checked){
           	}
           	else if (formObject.str_gubun[1].checked)
           	{
           	   	if(Row >= 1)
            	{
           	   		if(sheetObj.GetCellValue(Row, "eq_no") == null || sheetObj.GetCellValue(Row, "eq_no") == "")
        			{
        				return;
        			}
           	   		var eqNo=sheetObj.GetCellValue(Row, "eq_no");
        			var param="?pgmNo=EES_CGM_1003&eq_no=" + eqNo;
        			var seq=sheetObj.GetCellValue(Row, "Seq");
        			if(seq != ''){
        				// ComOpenPopup('/opuscntr/EES_CGM_1003.do' + param, 1100, 500, "", "1,0", true, false);
        		  		var pgmNo='EES_CGM_2006';
        		  		var pgmUrl='/opuscntr/EES_CGM_2006.do';
        		  		var parentPgmNo=pgmNo.substring(0, 8)+'M019';   
        		    	var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
        		    	var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
        		    	var winObj=window.open("opusMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
        			}
            	}
           	}
        }
         function  Grid_Remove()
         {
        	 var formObj=document.form;
        	 var sheetObj=sheetObjects[0];  
      	     var sheetObj2=sheetObjects[1];
    	  	 if(formObj.str_gubun[0].checked){
    	  		 sheetObj.RemoveAll();
//    	  		ComShowMessage("1");
    	  	 }
    	  	 else if (formObj.str_gubun[1].checked)
    	  	 {
    	  		sheetObj2.RemoveAll();
//    	  		ComShowMessage("2");
    	  	 }   	
         }
         /** 
          * location change event handling  <br>
          * @param  
          * @return 
          * @author 
          * @version
          */    
         function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
         {
        	   var sheetObj=sheetObjects[0];  
    	   	   if(combo_location.GetSelectCode()=="S")
    	   	   {
    	   		   sheetObj.SetCellValue(0, 1, "Yard");
    	   	   } else {
    	   		   sheetObj.SetCellValue(0, 1, "Location");
    	   	   }
        	  Grid_Remove();
         }
         
         
         /** 
         * agmt_lstm_cd_OnChange change event handling  <br>
         * @param  
         * @return 
         * @author 
         * @version
         */    
         function agmt_lstm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) 
         {
        	 document.form.agmt_lstm_cd_text.value = newCode;
        	 Grid_Remove();
         }
         
         function agmt_lstm_cd_OnBlur() {
        	 document.form.agmt_lstm_cd_text.value = agmt_lstm_cd.GetSelectCode();
         }
         /**
          * Sheet1 OnMouseDown event handling <br>
          * @param  {Integer} Button	mandatory Integer
          * @param  {integer} Shift	mandatory Integer
          * @param  {Integer} X	mandatory Integer
          * @param  {integer} Y	mandatory Integer
          * @return 
          * @author 
          * @version
          */ 
          function sheet1_OnMouseDown (Button, Shift, X, Y){
         	 var sheetObj=sheetObjects[0];
         	 var formObj=document.form;
         	 if(sheetObj.rowcount + 1 == sheetObj.mouseRow)
         	 {
         		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
         		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "group1");
         		 //alert(groupValue1);
         		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
         	 }
          }
         function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
       	   if(Col>3 ){
//      			var eqTpszCd = "";
                 var colSaveName=sheetObj.ColSaveName(Col);
//                 	
              	var crntYdCd=document.form.sts_evnt_yd_cd.value;
              	var eqStrDt=document.form.evnt_dt_str.value;
              	var eqEndDt=document.form.evnt_dt_end.value;
              	var scc_cd=document.form.scc_cd.value;
              	var eqAsetStsCd=document.form.eq_aset_sts_cd.value;
//              	var sAgmtLstmCd=document.agmt_lstm_cd.Text;
              	var sAgmtLstmCd=ComGetObjValue(comboObjects[1]);
              	
              	var sAgmtLstmCd="";
              	var eq_tpsz_cd="";
              	var agmt_lstm_cd="";
              	var sts_evnt_loc_cd="";

            	var k = 1;
            	oldCntrTypeSize = sCntrTypeSize;
            	var arrCntrTypeSize = oldCntrTypeSize.split("|");

            	for ( var i = 0; i < arrCntrTypeSize.length; i++) {
            		if (arrCntrTypeSize.length > 1) {
            			var gubun = "eq_tpsz_cd" + k;
            			if(colSaveName == gubun){
            				eq_tpsz_cd = arrCntrTypeSize[i];
            				break;
            			}
            			k++;
            		}
            	}

   				if(colSaveName == 'total')	eq_tpsz_cd="";
   				
   				if( sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "" || sheetObj.GetCellValue(Row, "vndr_seq") == "Sub Total"){
         		   if(crntYdCd ==""){
         			   sts_evnt_loc_cd=sheetObj.GetCellValue(Row-1, "sts_evnt_loc_cd");
         		   } else {
         			   sts_evnt_loc_cd="";
         		   }
         		   vndr_seq="";
   				} else if (sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "Grand Total" && sheetObj.GetCellValue(Row, "vndr_seq") == ""){
         		   sts_evnt_loc_cd="";
         		   vndr_seq=sheetObj.GetCellValue(Row, "sts_evnt_loc_cd");
         	   } else {
         		   if(crntYdCd ==""){
         			   sts_evnt_loc_cd=sheetObj.GetCellValue(Row, "sts_evnt_loc_cd");
         		   } else {
         			   sts_evnt_loc_cd="";
         		   }
         		   vndr_seq=sheetObj.GetCellValue(Row, "vndr_seq")
         	   }
   				agmtLstmCd=sheetObj.GetCellValue(Row, "agmt_lstm_cd");
//         	   if(sheetObj.CellValue(Row, "agmt_lstm_cd")==""){
//         	    	agmtLstmCd	    = document.form.agmt_lstm_cd.Code;
//         	    } else {
//         	    	agmtLstmCd	    = sheetObj.CellValue(Row, "agmt_lstm_cd");
//         	    }
//         	   if(document.form.location.Code=="S")
//     	   	   {
//         		   crntYdCd = sts_evnt_loc_cd;
//         		   sts_evnt_loc_cd = "";
//     	   	   } 
         	  kind=document.form.kind.value;
   	           	var param="?pgmNo=EES_CGM_2084&program_id=2012";
   	           	param=param + "&s_crnt_yd_cd=" + crntYdCd;
   	           	param=param + "&sts_evnt_dt_fr=" + eqStrDt;
   	           	param=param + "&sts_evnt_dt_to=" + eqEndDt;
   	     	    param=param + "&s1_inq_to_dys=" + eqAsetStsCd;
   	            param=param + "&s_location=" + combo_location.GetSelectCode();
   	            param=param + "&s_crnt_loc_cd=" + sts_evnt_loc_cd;
   	     	    param=param + "&s_vndr_seq=" + vndr_seq;
   	            param=param + "&eq_tpsz_cd=" + eq_tpsz_cd;
   	            param=param + "&s_agmt_lstm_cd=" + sAgmtLstmCd; 
   	            param=param + "&s2_agmt_lstm_cd=" + agmtLstmCd;
   	            param=param + "&s2_loc_cd=" + scc_cd;
   	            param=param + "&s2_group1="+kind;
   	            
   	        	ComOpenPopup('/opuscntr/EES_CGM_2084.do' + param, 900, 460, "", "1,0", true, false);
      	   }
         }
         
         // work javascript OnFocusOut event handling
         function obj_focusout() {
         	switch(event.srcElement.name){ 
	    	 	case "sts_evnt_yd_cd":
		  	 		var formObj=document.form;
		  	 		var sheetObj=sheetObjects[0];
		    	    var sts_evnt_yd_cd;
		    	    sts_evnt_yd_cd=formObj.sts_evnt_yd_cd.value;
	    	    	if (sts_evnt_yd_cd.length == 7) {
	    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	    	}
	    	    	break;		  		    	    		  
         	}
         }   
         
         // Date is masked 
         function obj_blur() {
       		var formObj=document.form;
          	switch(event.srcElement.name){ 
          		case "evnt_dt_str":
          			formObj.evnt_dt_str.value =  ComGetMaskedValue(formObj.evnt_dt_str.value, "ymd"); 
 	    	    	break;		  		    	    		  
          		case "evnt_dt_end":
          			formObj.evnt_dt_end.value =  ComGetMaskedValue(formObj.evnt_dt_end.value, "ymd"); 
 	    	    	break;		  		    	    		  
          	}
          }   

         
         
	/* developer job end */