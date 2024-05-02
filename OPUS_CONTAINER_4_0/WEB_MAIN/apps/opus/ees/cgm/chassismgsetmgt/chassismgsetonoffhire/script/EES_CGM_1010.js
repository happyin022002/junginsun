/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1010.jsp
*@FileTitle  : On & Off-Hire Status Summary Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
 var comboCnt2=0;
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
          var formObject=document.form;
//          var var_agmt_lstm_cd=agmt_lstm_cd.GetSelectText();
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
//                	 ComShowMessage(formObject.str_gubun[0].checked);
//                	 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                	 if(formObject.str_gubun[0].checked){
                		 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                	 }
                	 else if (formObject.str_gubun[1].checked)
                	 {
                		 doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                	 }
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
     					ComOpenPopupWithTarget('/opuscntr/EES_CGM_1011.do?pgmNo=EES_CGM_1011', 775, 800, "", "0,1,1,1,1,1,1", true);
                	 }
                	 else if (formObject.str_gubun[1].checked)
                	 {
       					if( sheetObjects[1].rowcount==0 ) {
     						errMsg='No data found.';
     						ComShowMessage(msgs["CGM10012"]);
     						return;
     					}
     					formObject.f_cmd.value=IBSEARCH03;
     					ComOpenPopupWithTarget('/opuscntr/EES_CGM_1013.do?pgmNo=EES_CGM_1013', 775, 800, "", "0,1,1,1,1,1,1", true);
                	 }
					break;
                 case "ComOpenPopupWithTargetYard":
         			//ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
         			ComOpenPopup("/opuscntr/EES_LSE_0101.do", 800, 550, "setPopData_AvailYard", '1,0', true, false);//, Row, Col, 0);
          			
          			break;
                 case "ComOpenPopupWithTargetLocation":
                	var tmp=formObject.combo_location_text.value;
                	if(tmp == "RCC")
                	{
                		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                	}else if(tmp == "LCC")
                	{
                		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                	}else if(tmp == "SCC")
                	{
                		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 460,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                	}
          			break;
                 case "ComOpenPopupWithTargetKind":
           			if(formObject.kind.value=="L"){
           				ComOpenPopup('/opuscntr/COM_ENS_0C1.do?pgmNo=COM_ENS_051', 700, 455, "setProgramNo", "0,1,1,1,1,1", true, false);
           			}
           			else
           			{
           				ComOpenPopup('/opuscntr/EES_CGM_1117.do?pgmNo=EES_CGM_1117', 820, 420, "setProgramNo", "0,1,1,1,1,1", true, false);
           			}
           			break;
                 case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal=new ComCalendar();
	 				cal.select(formObject.evnt_dt_str, "yyyy-MM-dd");
	 				break;
	 			case "btns_Calendar2" :		// Agreement Date (To Date)
//	 				var cal = new ComCalendar();
		 			var cal=new ComCalendarFromTo();
		            cal.select(form.evnt_dt_str,  form.evnt_dt_end,  'yyyy-MM-dd');
//	 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
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
    		title_chk();
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
      * Sheet setting and reset
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
	    var formObj=document.form;
	    	
	    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);

	    for(i=0;i<sheetObjects.length;i++){
         		//
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         		//
             ComEndConfigSheet(sheetObjects[i]);
         } 
          // IBMultiCombo reset
         	comboObjects[comboCnt++]=agmt_lstm_cd;
         	comboObjects[comboCnt++]=combo_location;
          	for(var k=0;k<comboObjects.length;k++){
      	        initCombo(comboObjects[k]);
     	    }  
//          	comboObjects2[comboCnt2++] = document.location;
//          	for(var k=0;k<comboObjects2.length;k++){
//      	        initCombo(comboObjects2[k]);
//     	    }  
           //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
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
          initControl(sheetObjects[0]);  
          sheetObj.SetWaitImageVisible(1);
          // axon event 
//          axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
     //     axon_event.addListenerFormat('beforeactivate',   'obj_activate',	formObj);
          //axon_event.addListener('change', 'obj_change' , 'scc_cd', 'sts_evnt_yd_cd','eq_aset_sts_cd','kind'   ); 
          axon_event.addListener('change', 'obj_change' , 'eq_aset_sts_cd','kind'   );
          axon_event.addListener('blur',    'obj_blur',	'evnt_dt_str','evnt_dt_end');
          axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
          
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
          // axon event 
       // Lease Term Combo Contro
//          doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//          doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
      	  doActionIBSheet(sheetObjects[0], document.form, IBRESET);
          //formObj.agmt_lstm_cd.text ='ALL';
      	  
//      	  formObj.combo_location_text.value='RCC';
      	  combo_location.SetSelectCode('R');
          //  focus
//          formObj.evnt_dt_str.focus();
      }
	function resizeSheet(){
		ComResizeSheet( sheetObjects[0] );
	}
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var tmp="";
         switch(sheetNo) {
             case 1:      //sheet1 init  
                 with(sheetObj){
		             if(document.form.kind.value == "L"){
		            	 tmp="Lessor";
		             }else{
		            	 tmp="Agreement No. ";
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
		
		             SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agreement" },
		              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"total",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		             
		             
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
		
		             SetEditable(0);
//		             SetSheetHeight(420);
		             ShowSubSum([{StdCol:1, SumCols:sumNmVal, Sort:0, ShowCumulate:0, CaptionCol:3, CaptionText:"SubTotal"}]);
		             resizeSheet( sheetObj );
             	}


                 break;
             case 2:      //sheet2 init
		         with(sheetObj){
		              if(document.form.kind.value == "L"){
		            	  tmp="Lessor";
		              }else{
		            	  tmp="Agreement No. ";
		              }
		              if(document.form.eq_aset_sts_cd.value == "LSO"){
		            	  tmp2="Off-hire";
		              }else{
		            	  tmp2="On-hire";
		              }
		              var HeadTitle="No.|Chassis No.|"+tmp+"|Type/Size|Term|"+tmp2+"|LCC|SCC|Yard|Event Date|System Date";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"No",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"scc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"evnt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetSheetHeight(390);
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
		       	formObj.f_cmd.value=SEARCH;
		    	 var params=FormQueryString(formObj);
				 formObj.f_cmd.value=SEARCH;
//				 queryString = "f_cmd=" + SEARCH ;
				 if(formObj.str_gubun[0].checked)
				 {
					 sheetObj.SetWaitImageVisible(0);
			 	     ComOpenWait(true);
 		             sheetObj.DoSearch("EES_CGM_1010GS.do",  params );
		// 	                 sheetObj.SumText(1,"")= "";
		//	 	             
		// 	                 sheetObj.SumText(0,3) = "Grand Total";
		// 	                 sheetObj.SumText(0,"sts_evnt_loc_cd")        = "";
		// 	                 sheetObj.SumText(0,"Month")="Grand Total";
		             ComOpenWait(false);
				 }
				 else
				 {
 		             sheetObj.DoSearch("EES_CGM_1010GS.do",  params );
				 }
		      }
		         break;
		   case IBSEARCH_ASYNC01:	// Term Code Combo retrieve
		       	formObj.f_cmd.value=SEARCH;
		       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		//code type setting ( AGREEMENT LEASE TERM CODE )
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
//			   		formObj.sts_evnt_yd_cd.focus();
			   	}
			   	break;
		  case IBSEARCH_ASYNC04:	// Term Code Combo retrieve
		       	formObj.f_cmd.value=SEARCH;
		       	formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting ( AGREEMENT LEASE TERM CODE )
 		   		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		   		var sStr=ComGetEtcData(sXml,"comboList");    			
		   		var arrStr=sStr.split("@");
		   		// combo control, result string, Text Index, Code Index
		  			MakeComboObject2(comboObjects[0], arrStr, 0, 0);
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
//				   		formObj.scc_cd.focus();
				    }
					break;
        	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
	        	formObj.f_cmd.value = SEARCH21;
        		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
				sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
				
				//getting changing column information from server
				oldCntrTypeSize = sCntrTypeSize;
				
				break;
 		   case IBSEARCH_ASYNC08:
		    	formObj.f_cmd.value=SEARCH17;
//		    	var location=formObj.location.text;
		    	var location = combo_location.GetSelectText();
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
			   		formObj.scc_cd.focus();
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
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
		 	case IBSEARCH:
//		 		formObj.combo_location_text.value = combo_location.GetSelectText();
		 		if(formObj.evnt_dt_str.value == ''){
    				ComShowCodeMessage('CGM10004','Period ');
    				ComSetFocus(formObj.evnt_dt_str);
    				return false;
    			}	
		 		if(formObj.evnt_dt_end.value == ''){
    				ComShowCodeMessage('CGM10004','Period ');
    				ComSetFocus(formObj.evnt_dt_end);
    				return false;
    			}
		 		 var dt_str=ComReplaceStr(document.form.evnt_dt_str.value,"-","");
 			 var dt_end=ComReplaceStr(document.form.evnt_dt_end.value,"-","");
	    		if(dt_str != '' && dt_end != ''){
	    			if(dt_end < dt_str){
	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    				formObj.evnt_dt_str.value='';
	    				return false;
	    			}
	    		}
		 		if(combo_location.GetSelectCode() == ''){
    				ComShowCodeMessage('CGM10004','location ');
    				return false;
    			}
		 		if(formObj.scc_cd.value == ''){
    				ComShowCodeMessage('CGM10004','scc_cd');
    				return false;
    			}
		 		if(formObj.scc_cd.value.length !=5){
		 			ComShowCodeMessage('CGM10044','Location (5)');
    				return false;
    			}
		 		if(formObj.sts_evnt_yd_cd.value!= '' && formObj.sts_evnt_yd_cd.value.length !=7){
		 			ComShowCodeMessage('CGM10044','Yard(7)');
    				return false;
    			}
    			break;
		 }   
         return true;
     }
//
// 	function sheet1_OnChangeSum(sheetObj, Row )
// 	{
// 		with(sheetObj)
// 		{
// 			SumText(0,"Office") = "";
// 			SumText(0,"Lessor") = "Grand Total";
// 			CellAlign(LastRow, "Lessor") = daCenter;
// 		}
// 	} 
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
// 			ShowSubSum(1, "4|5|6|7|8|9|10|11|12|13|14",-1, true, false, 0, "vndr_seq=Sub Total");
            SetSumText(0, 1, "Grand Total");
//            SetSumBackColor("#F6CEF5");
 		}	
 	}
// 	
   function obj_keypress(){
  	 obj=ComGetEvent();
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
    function obj_deactivate(){
   	 var formObj=document.form;
   	 obj=formObj;
   	 if(obj.name=="evnt_dt_str"  ){
   		 with(formObj){
   			 var creDtFr=ComReplaceStr(formObj.evnt_dt_str.value,"-","");
	        }
	        ComChkObjValid(formObj());
       }
     	if(obj.name=="evnt_dt_end"  ){
  		 with(formObj){
  			 var creDtFr=ComReplaceStr(formObj.evnt_dt_end.value,"-","");
	        }
	        ComChkObjValid(ComGetEvent());
      }
    }
    function obj_change(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0]; 
    	 var sheetObj2=sheetObjects[1]; 
    	 obj=ComGetEvent();
    	 switch(ComGetEvent("name")){
    	   case "kind":
    		    formObj.vndr_seq.value='';
    		    Grid_Remove();
    		    if(formObj.kind.value=="L") {
    		    	sheetObj.SetCellValue(0, 3, "Lessor");
    		    	sheetObj2.SetCellValue(0, 2, "Lessor");
    		    } else {
    		    	sheetObj.SetCellValue(0, 3, "Agreement No.");
    		    	sheetObj2.SetCellValue(0, 2, "Agreement No.");
    		    }
    	 		break;    	 	
    	   case "eq_aset_sts_cd":
	   		    if(formObj.eq_aset_sts_cd.value=="LSO") {
			    	sheetObj2.SetCellValue(0, 5, "Off-hire");
			    } else {
			    	sheetObj2.SetCellValue(0, 5, "On-hire");
			    }
	    	    Grid_Remove();
		 		break;    	
    	   case "sts_evnt_yd_cd":
    	 		if(formObj.sts_evnt_yd_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	 		}
    	 		break;
//	 		case "scc_cd":
//    	 		if(formObj.scc_cd.value != ''){
//    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
//    	 		}
    	 		break;
    	 }   
    }
    /**
      * YA_CD value check
      * @return
      */
     function obj_keyup(){
	    	 var formObj=document.form;
	    	 var sheetObj=sheetObjects[0];
	    	 var sts_evnt_yd_cd;
	    	 obj=ComGetEvent();
	    	 switch(ComGetEvent("name")){
	    	 	case "sts_evnt_yd_cd":
		    	    var sts_evnt_yd_cd;
	    	    	frmObj=document.form;
	    	    	//alert("sss");
	    	    	sts_evnt_yd_cd=frmObj.sts_evnt_yd_cd.value;
	    	    	if (sts_evnt_yd_cd.length == 7) {
	    	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	    	}
	    	    	title_chk();
	    	    	break;
	     	 	case "scc_cd":
	    	 		var crntLocCd=ComTrimAll(formObj.scc_cd.value);
	    	   		var arrCrntLocCd=crntLocCd.split(",");
	    	   		for(var i=0; i < arrCrntLocCd.length; i++){
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
//	  		ComShowMessage("1");
	  	 }
	  	 else if (formObj.str_gubun[1].checked)
	  	 {
	  		sheetObj2.RemoveAll();
//	  		ComShowMessage("2");
	  	 }   	
     }
     /** 
      * location  change event handling  <br>
      * @param  
      * @return 
      * @author 
      * @version 
      */    
     function combo_location_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod)
     {
    	 if (NewIdx == -1) return;
    	   var sheetObj=sheetObjects[0];  
	   	   if(combo_location.GetSelectCode()=="S")
	   	   {
	           sheetObj.SetCellValue(0, 1, "Yard");
	   	   } else {
	   		   sheetObj.SetCellValue(0, 1, "Location");
	   	   }
    	  Grid_Remove();
    	  document.form.combo_location_text.value = combo_location.GetText(parseInt(combo_location.GetSelectIndex()), 0);
    	  document.form.location.value = combo_location.GetSelectCode();
     }
     function combo_location_OnBlur(comboObj) {
    	 if (comboObj.GetSelectIndex() == -1) return;
     	document.form.combo_location_text.value = comboObj.GetText(comboObj.GetSelectCode(), 0);
     }
     /** 
     * agmt_lstm_cd_OnChange  change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */    
     function agmt_lstm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
     {
    	 if (newIndex == -1) return;
    	 document.form.agmt_lstm_cd_text.value = newCode;
    	 Grid_Remove();
     }
     
     function agmt_lstm_cd_OnBlur(comboObj) {
    	 document.form.agmt_lstm_cd_text.value = comboObj.GetSelectCode();
     }
     
     function agmt_lstm_cd_OnCheckClick(comboObj, index, text, code) {
    	 
     }
     function setProgramNo(aryPopupData, row, col, sheetIdx){
    	 var formObj=document.form;
     	 var vndrSeq="";
     	 var vndrNm="";
     	 var i=0;
//     	 ComShowMessage('setProgramNo'+aryPopupData.length);
     	 for(i=0; i < aryPopupData.length; i++){
     		 vndrSeq=vndrSeq + aryPopupData[i][2];
     		/* if(aryPopupData.length == 1){
     			 vndrNm=vndrNm + aryPopupData[i][4];
     		 }*/
     		 if(i < aryPopupData.length - 1){
     			 vndrSeq=vndrSeq + ",";
     		 }
//     		ComShowMessage('vndrSeq=='+vndrSeq);
     	 }
     	  formObj.vndr_seq.value=vndrSeq;
     }
      /** 
       * Combo Object reset  <br>
       * @param  {object} comboObj	 Combo Object
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
      function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
      	//cmbObj.RemoveAll();
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
       	//cmbObj.RemoveAll();
//       	cmbObj.InsertItem(0,"","");
    	   for (var i=0; i < arrStr.length;i++ ) {
    		   var arrCode=arrStr[i].split("|");
    		   cmbObj.InsertItem(i, arrCode[1].toString(), arrCode[0].toString());
    	   }
       }
       /**
        *  init object 
        */
       function objectClear(){
	       	var formObj=document.form;
	       	var sheetObject=sheetObjects[0];
	       	var sheetObject1=sheetObjects[1];
	       	//IBMultiCombo reset
	//       	
	       	combo_location.SetSelectCode("");
	       	agmt_lstm_cd.SetSelectCode("");
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
//       	formObj.eq_spec_no.Code = "";
			//formObj.agmt_lstm_cd.text ='ALL'; //
//	       	formObj.combo_location_text.value='RCC';
	       	combo_location.SetSelectCode('R');
//       	formObj.vndr_seq.Code = "";
//
//       	formObj.eq_tpsz_cd.Code = "UMG";
//       	sheetObject1.RowStatus(1)="I";
//       	sheetObject1.CellValue(1, "eq_knd_cd") = "G";
//       	sheetObject1.CellValue(1, "mgst_vltg_capa") = "220";
//       	formObj.mgst_vltg_capa[0].checked = true;
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
   		    		sheetObj.SetCellValue(0, 3, "Lessor");
   		    		sheetObj2.SetCellValue(0, 2, "Lessor");
	   		    } else {
	   		    	sheetObj.SetCellValue(0, 3, "Agreement No.");
	   		    	sheetObj2.SetCellValue(0, 2, "Agreement No.");
	   		    }
    	   }
    	   else
    	   {
    		   objs[0].style.display="none";
	           objs[1].style.display="Inline";
	           sheetObj2.RemoveAll();
	           if(formObj.kind.value=="L") {
   		    		sheetObj.SetCellValue(0, 3, "Lessor");
   		    		sheetObj2.SetCellValue(0, 2, "Lessor");
	   		   } else {
	   		    	sheetObj.SetCellValue(0, 3, "Agreement No.");
	   		    	sheetObj2.SetCellValue(0, 2, "Agreement No.");
	   		   }
    	   }
       }
       function title_chk(){
    	   var sheetObj=sheetObjects[0]; 
    	   if(formObj.sts_evnt_yd_cd.value != ""){
    		   sheetObj.SetCellValue(0, 1, "Yard");
    	   } else {
    		   sheetObj.SetCellValue(0, 1, "Location");
    	   }
       }
       /**
        * AXON event handling
        */
       function obj_activate(){
           ComClearSeparator(ComGetEvent());
       }
         function sheet1_OnMouseDown(Button, Shift, X, Y) {
        	 var sheetObj=sheetObjects[0];
        	 var formObj=document.form;
        	 if(sheetObj.RowCount() + 1 == sheetObj.mouseRow)
        	 {
        		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol());
        	 }
         }
       function sheet1_OnDblClick(sheetObj, Row, Col){
    	   if(Col>3 && Col<=14){
    			var eqTpszCd="";
               	var colSaveName=sheetObj.ColSaveName(Col);
            	var eqKndCd=EQ_KND_CD_CHASSIS;
            	var crntYdCd=document.form.sts_evnt_yd_cd.value;
            	var eqStrDt=document.form.evnt_dt_str.value;
            	var eqEndDt=document.form.evnt_dt_end.value;
            	var eqAsetStsCd=document.form.eq_aset_sts_cd.value;
            	var location=comboObjects[1].GetSelectCode();
            	var scc_cd=document.form.scc_cd.value;
            	var agmtLstmCd="";
            	var sAgmtLstmCd=agmt_lstm_cd.GetSelectText();
            	var vndr_seq="";
//            	var sts_evnt_log_cd = "";
            	var sts_evnt_loc_cd="";
            	var kind="";
		    	var k = 1;
				oldCntrTypeSize = sCntrTypeSize;
				var arrCntrTypeSize = oldCntrTypeSize.split("|");

				for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					if (arrCntrTypeSize.length > 1) {
						var gubun = "eq_tpsz_cd" + k;
						if(colSaveName == gubun){
							eqTpszCd = arrCntrTypeSize[i];
							break;
						}
						k++;
					}
				}
				
				if(colSaveName == 'total')	eqTpszCd="";
				
				if( sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "" || sheetObj.GetCellValue(Row, "vndr_seq") == "Sub Total"){
        		   if(crntYdCd ==""){
        			   sts_evnt_loc_cd=sheetObj.GetCellValue(Row-1, "sts_evnt_loc_cd");
        		   } else {
        			   sts_evnt_loc_cd="";
        		   }
        		   vndr_seq=document.form.vndr_seq.value;
				} else if (sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "Grand Total" && sheetObj.GetCellValue(Row, "vndr_seq") == ""){
        		   sts_evnt_loc_cd="";
        		   vndr_seq=document.form.vndr_seq.value;
        	   } else {
        		   if(crntYdCd ==""){
        			   sts_evnt_loc_cd=sheetObj.GetCellValue(Row, "sts_evnt_loc_cd");
        		   } else {
        			   sts_evnt_loc_cd="";
        		   }
        		   vndr_seq=sheetObj.GetCellValue(Row, "vndr_seq");
        	   }
				agmtLstmCd=sheetObj.GetCellValue(Row, "agmt_lstm_cd");
				agmtLstmCd=sheetObj.GetCellValue(Row, "agmt_lstm_cd");
        	   /* old version.
				if(sheetObj.GetCellValue(Row, "agmt_lstm_cd")==""){
        	    	agmtLstmCd=agmt_lstm_cd.GetSelectCode();
        	    } else {
				agmtLstmCd=sheetObj.GetCellValue(Row, "agmt_lstm_cd");
        	    }
        	   */
        	   if(combo_location.GetSelectCode()=="S")
    	   	   {
        		   crntYdCd=sts_evnt_loc_cd;
        		   sts_evnt_loc_cd="";
    	   	   } 
        	    kind=document.form.kind.value;
	           	var param="?pgmNo=EES_CGM_1091&program_id=1010";
	           	param=param + "&f_cmd=" + SEARCH01; 
	        	param=param + "&eq_tpsz_cd=" + eqTpszCd;           	
	           	param=param + "&eq_knd_cd=" + eqKndCd;
	           	param=param + "&crnt_yd_cd=" + crntYdCd;
	           	param=param + "&sts_evnt_dt_fr=" + eqStrDt;
	           	param=param + "&sts_evnt_dt_to=" + eqEndDt;
	           	param=param + "&eq_aset_sts_cd=" + eqAsetStsCd;
	           	param=param + "&location=" + combo_location;
	           	param=param + "&scc_cd=" + scc_cd;
	           	param=param + "&agmt_lstm_cd=" + agmtLstmCd;
	           	param=param + "&s_agmt_lstm_cd=" + sAgmtLstmCd; 
	           	param=param + "&sts_evnt_loc_cd="+sts_evnt_loc_cd;
	        	param=param + "&vndr_seq="+vndr_seq;
	        	param=param + "&kind="+kind;
	        	ComOpenPopup('/opuscntr/EES_CGM_1091.do' + param, 900, 600, "", "1,0", true, false);
    	   }
       }
    function obj_focusout(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0]; 
    	 obj=ComGetEvent();
    	 switch(ComGetEvent("name")){
    	   case "scc_cd":
    	 		if(formObj.scc_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
    	 			break;
    	 		} 
    	 }   
    }
    
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