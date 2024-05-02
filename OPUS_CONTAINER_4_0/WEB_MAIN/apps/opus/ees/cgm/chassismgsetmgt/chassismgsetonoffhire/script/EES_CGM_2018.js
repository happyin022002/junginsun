/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2018.js
*@FileTitle  : M.G.Set Status Inquiry/Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
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
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /***** use additional sheet var in case of more than 2 tap each sheet *****/
             var sheetObject1=sheetObjects[0];
             var sheetObject2=sheetObjects[1];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
                    case "btn_retrieve":
                   	 	doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                        break;
                    case "btn_new":
	                   	 sheetObject1.RemoveAll();
	                   	 sheetObject2.RemoveAll();
     				 	 formObject.reset();
                        break; 
                    case "btn_del":
                   	 	doActionIBSheet(sheetObject2,formObject,REMOVE);
//                   	 doActionIBSheet(sheetObject2, formObject, IBSEARCH);				
                        break;
                    case "btn_save2":
                   	 	doActionIBSheet(sheetObject1,formObject,IBSAVE);
                        break;
                } // end switch
                tRoleApply();
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
         * Sheet setting and reset
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
        	var sheetObject1=sheetObjects[0];
            var sheetObject2=sheetObjects[1];
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            formObj=document.form;
   			initControl(sheetObjects[0]); 
       	 	if(formObj.eq_no.value != '')
       	 		doActionIBSheet(sheetObject2, formObj, IBSEARCH);
       	 	tRoleApply();
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
//             formObj.eq_no.focus();
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
                   
                    var HeadTitle="|Status|Event Date|Office|Yard|Agreement No|Ref. No.|Lessor||";
                    var headCount=ComCountHeadTitle(HeadTitle);

                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_aset_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agreeement",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"eq_sts_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                     
	                    InitColumns(cols);
	                    SetSheetHeight(230);
	                    SetEditable(1);
	                    SetWaitImageVisible(0);
	                    SetImageList(0,"img/btns_calendar.gif");
	                    SetColProperty("sts_evnt_dt" , {AcceptKeys:"N|[-: ]"});
	                    SetColProperty("sts_evnt_yd_cd" , {AcceptKeys:"N|E", InputCaseSensitive:1});
	                    SetColProperty("agreeement" ,  {AcceptKeys:"N|E", InputCaseSensitive:1});
	                    
	                    SetShowButtonImage(1);
	                    SetSelectionMode(smSelectionFree);
    				 }
                    break;
                case "sheet2":
                    with (sheetObj) {
                    var HeadTitle="||Seq|Status|Event Date|System Date|Office|Yard|Agreement No|Agmt Ver.|Ref. No.| Lessor|Lessor Name|User ID|||||||";
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                           {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_aset_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agreeement",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:280,  Align:"Center",  ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aciac_div_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_sts_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"aciac_div_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"term_cng_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chk_val",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                    InitColumns(cols);
	                    SetEditable(1);
	                    resizeSheet();
   				}
                    break;
            }
        }

        function resizeSheet(){
            ComResizeSheet(sheetObjects[1]);
        }
        
      // handling process for Sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            var sheetObject1=sheetObjects[0];
            var sheetObject2=sheetObjects[1];
            switch(sAction) {
              case IBSEARCH:      //retrieve
                    sheetObject1.RemoveAll();
                    sheetObject2.RemoveAll();
   	             	var params=FormQueryString(formObj);
    			 	queryString="f_cmd=" + SEARCH ;
    			 	if(!validateForm(sheetObj,formObj,sAction)) return;
			 	    ComOpenWait(true);
			 	    var sXml=sheetObj.GetSearchData("EES_CGM_2018GS.do", queryString+"&"+params);
     				sheetObj.LoadSearchData(sXml,{Sync:1} );
                     
    			 	 if(sheetObj.LastRow() >= 0)
                     {
                    	 formObj.aciac_div_nm.value=sheetObj.GetCellValue(sheetObj.LastRow(), "aciac_div_nm") ;
                    	 formObj.eq_tpsz_cd.value=sheetObj.GetCellValue(sheetObj.LastRow(), "eq_tpsz_cd") ;
                    	 formObj.agmt_lstm_cd.value=sheetObj.GetCellValue(sheetObj.LastRow(), "agmt_lstm_cd") ;
                    	 formObj.eq_sts_seq.value=sheetObj.GetCellValue(sheetObj.LastRow(), "eq_sts_seq") ;
                     } else {
                   	     ComShowCodeMessage("CGM10004", "Chassis No");
                     }
                    break;
              case REMOVE:
           	   var sts_seq="";
           	   var chk_val="";
           	   for(i=1; i<sheetObj.RowCount()+1; i++){
   					if(sheetObj.GetCellValue(i,'del_chk')=="1")
   					{
   						sts_seq=sheetObj.GetCellValue(i,'eq_sts_seq') ;
   						chk_val=sheetObj.GetCellValue(i,'chk_val') ;
   						sheetObj.SetRowStatus(i,"D");
   					} else {
   						sheetObj.SetRowStatus(i,"R");
   					}
   	  		   }
           	   if( sts_seq ==formObj.eq_sts_seq.value )
   				{
//   					 ComRowHideDelete(sheetObj,"del_chk");
   				}
	           	else
				{
					ComShowCodeMessage("CGM10064");
					return false;
				}
	           	if(chk_val == "Y"){
	     	    	ComShowCodeMessage('CGM20034');
						return false;
	     	    }
	    	   var params=sheetObj.GetSaveString(true);
				  formObj.f_cmd.value=MULTI02;
				  queryString="f_cmd=" + MULTI02 ;
				  if(sheetObj.DoSave("EES_CGM_2018GS.do",queryString + "&" + ComGetPrefixParam(""))){
	    		  }  
	//          ComRowHideDelete(sheetObj,"del_chk");
//			    doActionIBSheet(sheetObject2, formObject, IBSEARCH);
           	   break;
    		   case IBSAVE:        //saving
    		      if(!validateForm(sheetObj,formObj,sAction)) return;
	    		  var params=sheetObj.GetSaveString(true);
	   			  formObj.f_cmd.value=MULTI01;
	   			  queryString="f_cmd=" + MULTI01 ;
	   			  sheetObj.SetWaitImageVisible(0);
		 	      ComOpenWait(true);
	    		  sheetObj.DoSave("EES_CGM_2018GS.do",queryString + "&" + ComGetPrefixParam(""));
	    		  ComOpenWait(false);
               break;
            }
        }
        function set_serch()
        {
       	   var sheetObject1=sheetObjects[0];
            var sheetObject2=sheetObjects[1];
            /*******************************************************/
            var formObject=document.form;
       	   doActionIBSheet(sheetObject2, formObject, IBSEARCH);
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	 with(formObj){
        		 switch(sAction) {
        		 	case IBSAVE:
        		 		for(i=1; i<sheetObj.RowCount()+1; i++){
//        	   	        	ComShowMessage(Row);
        					if(sheetObj.GetCellValue(i,'sts_evnt_dt')== "")
        					{
        						ComShowCodeMessage("CGM10004", "Event Date");
        						sheetObj.SelectCell(i, 2, true);
        						return false;
        					}
        					if(sheetObj.GetCellValue(i,'sts_evnt_yd_cd')== "")
        					{
        						ComShowCodeMessage("CGM10004", "Yard");
        						sheetObj.SelectCell(i, 4, true);
        						return false;
        					}
        					if(sheetObj.GetCellValue(i,'agreeement')== "")
        					{
        						ComShowCodeMessage("CGM10004", "Agreement No");
        						sheetObj.SelectCell(i, 5, true);
        						return false;
        					}
        	  		   }
               			break;
        		 	case IBSEARCH:
                	   if( formObj.eq_no.value == '' )
        				{
                		   ComShowCodeMessage("CGM10004", "M.G.Set No");
//                		   formObj.eq_no.focus();
                		   return false;
        				}
               			break;
        		 }      
        	 }
        	 return true;
        }
         function sheet1_OnPopupClick(sheetObj, row, col){
       		switch (sheetObj.ColSaveName(col)) {
       	       	case "sts_evnt_dt" :
       	         	sheetObj.SelectCell(row, "eq_aset_sts_cd", true);
       			    if (sheetObj.ColSaveName(col) != "sts_evnt_dt") return;//chss_rgst_exp_dt
       			    var cal=new ComCalendarGrid("myCal");
       			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
       			    break;
       	       	case "sts_evnt_yd_cd" :
       	       		//chungpa 20100415 new yard popup start
         			//ComOpenPopup('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true);
         			ComOpenPopup("/opuscntr/EES_LSE_0101.do", 800, 650, "setPopData_AvailYard", '1,0', true, false, row, col, 0);
         			//chungpa 20100415 new yard popup end       	       		
       			    break;
       	    	case "agreeement" :
       	    		ComOpenPopup('/opuscntr/EES_CGM_2022.do?pgmNo=EES_CGM_2022', 820, 435, "setProgramNo", "1,0,1,1,1,1", true, false);
       			break;   
       		}
       	}
          function setPopData_AvailYard(aryPopupData, Row, Col, sheetIdx) {
          	if(aryPopupData.length > 0) {
     			with(sheetObjects[sheetIdx]) {
     				SetCellValue(Row, Col,aryPopupData[0][3],0);//Yard
     			}
     		}
          }
         function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
   			var sheetObject=sheetObjects[0];
//   			ComShowMessage(row);
//   			ComShowMessage(col);
//   			ComShowMessage(sheetIdx);
   			sheetObject.SetCellValue(1, "sts_evnt_yd_cd",aryPopupData[0][3]);
//   			sheetObject.CellValue(row,col)= aryPopupData[0][4];
    	 }
         function setProgramNo(aryPopupData, row, col, sheetIdx){
       	  var sheetObject=sheetObjects[0];
         	 var vndrSeq="";
         	 var i=0;
//         	 ComShowMessage('setProgramNo'+aryPopupData.length);
         	 for(i=0; i < aryPopupData.length; i++){
         		 vndrSeq=vndrSeq + aryPopupData[i][2];
         		/* if(aryPopupData.length == 1){
         			 vndrNm=vndrNm + aryPopupData[i][4];
         		 }*/
         		 if(i < aryPopupData.length - 1){
         			 vndrSeq=vndrSeq + ",";
         		 }
//         		ComShowMessage('vndrSeq=='+vndrSeq);
         	 }
         	  sheetObject.SetCellValue(1, "agreeement",vndrSeq);
//         	  ComShowMessage(vndrSeq);
         }
         function sheet1_OnChange(sheetObj,Row,Col,sValue){
       	  var formObj=document.form;
       	  switch (sheetObj.ColSaveName(Col)) {
   	       	case "sts_evnt_yd_cd" :
   	   			formObj.f_cmd.value=COMMAND01;
   	   			formObj.yd_cd.value=sheetObj.GetCellValue(1, "sts_evnt_yd_cd");
   			   	if(formObj.yd_cd.value!="")
   			   	{
    			   		var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
   				   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
   				   	if(sCheckResult == COM_VALIDATION_FALSE){
   				   		ComShowCodeMessage('CGM10009','Yard');
   				   		sheetObj.SetCellValue(1, "sts_evnt_yd_cd","");
   				   		sheetObj.SelectCell(Row, Col-1, true);
//   				   		formObj.sts_evnt_yd_cd.focus();
   				   	} else {
   				   		sheetObj.SetRowStatus(1,"U");
   				   	} 
   			   	}
   			    break;
	       	case "sts_evnt_dt" :
	       		  var sheetObj2=sheetObjects[1];
	       		  var evnt_dt=sheetObj2.GetCellValue(sheetObj2.RowCount()-1, "sts_evnt_dt").substring(0,10);
	       		  var evnt_hs=sheetObj2.GetCellValue(sheetObj2.RowCount()-1, "sts_evnt_dt").substring(11,16);
	       		  var evntDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sts_evnt_dt").substring(0,8);
		     	  evnt_dt=ComReplaceStr(evnt_dt,"-","")+ComReplaceStr(evnt_hs,":","");
		     	  evntDt=ComReplaceStr(evntDt,"-","")
		     	  if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sts_evnt_dt") < evnt_dt){
			   	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sts_evnt_dt","",0);
//			 	    	sheetObj.focus();
			 	    	ComShowCodeMessage("CGM10060",sheetObj2.GetCellValue(sheetObj2.RowCount()-1, "sts_evnt_dt"));
			 	    	sheetObj.SelectCell(sheetObj.GetSelectRow(),sheetObj.GetSelectCol(), false);
			 	    	return false;
		  	      }  
		          if(document.form.form_day.value < evntDt){
		        	    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sts_evnt_dt","",0);
//			 	    	sheetObj.focus();
			 	    	ComShowCodeMessage("CGM10059");
			 	    	sheetObj.SelectCell(sheetObj.GetSelectRow(),sheetObj.GetSelectCol(), false);
			 	    	return false;
		          }
				  break;
   	       	case "agreeement" :
   	   			formObj.f_cmd.value=COMMAND01;
   	   			formObj.agmt_ofc_cty_cd.value=sheetObj.GetCellValue(1, "agreeement");
   			   	var agmtOfcCytCd=formObj.agmt_ofc_cty_cd.value;
   			   	if(agmtOfcCytCd !="" )
   			   	{
   			   		if(ComIsNumber(agmtOfcCytCd.substr(3,agmtOfcCytCd.length))){
    			   			var sXml=sheetObj.GetSearchData("EES_CGM_AGREEMENTGS.do", FormQueryString(formObj));
   					   	var sCheckResult=ComGetEtcData(sXml,"checkResult"); 
   					   	if(sCheckResult == COM_VALIDATION_FALSE){
   					   		ComShowCodeMessage('CGM10009','agreeement');
   					   		sheetObj.SetCellValue(1, "agreeement","");
   					   		sheetObj.SelectCell(Row, Col-1, true);
//   					   		formObj.sts_evnt_yd_cd.focus();
   					   	}
   					   	else
   					   	{
   					   		sheetObj.SetCellValue(Row, "agreeement",sCheckResult);
   					   	}
   			   		} else
   			   		{
   			   			ComShowCodeMessage('CGM10009','agreeement');
   				   		sheetObj.SetCellValue(1, "agreeement","");
   				   		sheetObj.SelectCell(Row, Col-1, true);
   			   		}
   			   	}
   			    break;
   		}
//   	   		ComShowMessage(Col);
//   	   		if(Col==4){
//   	   			formObj.f_cmd.value = COMMAND01;
//   			   	formObj.yd_cd.value =sheetObj.CellValue(1, "sts_evnt_yd_cd");
//   			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
//   			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
//   			   	
//   			   	if(sCheckResult == COM_VALIDATION_FALSE){
//   			   		ComShowCodeMessage('CGM10009','Yard');
//   			   		sheetObj.CellValue(1, "sts_evnt_yd_cd") = "";
////   			   		formObj.sts_evnt_yd_cd.focus();
//   			   	}
//   	   		}
      	  }
    	/*   function sheet2_OnDblClick(sheetObj, Row, Col) {
    	         try{
    	        	var sheetObject1=sheetObjects[0];
//     	            ComShowMessage("sheet2_OnDblClick  Row==========="+Row);
     	            var strSaveNames="eq_aset_sts_cd|sts_evnt_dt|sts_evnt_ofc_cd|sts_evnt_yd_cd|agreeement|agmt_ref_no|vndr_seq";  //test....
     	            sheetObj.cellValue(Row,'del_chk')="1";
     	            var sXml=ComMakeSearchXml(sheetObj   , false,"del_chk", strSaveNames, false);  //all column : move 
//     	          var sXml = ComMakeSearchXml(form.sheet1, false, "hiddencheck","CntrNo|TySz|Matl|Puc|PUCredit|MinOHDays|FreeDays|DIIFree|OldNew", true)
//     	           ComShowMessage(sXml);
                   sheetObjects[0].RemoveAll();
     	            sheetObjects[0].LoadSearchData(sXml,{Append:1 , Sync:1} );
     	            sheetObj.cellValue(Row,'del_chk')="0";
//     	          sheetObject1.Copy2SheetCol(sheetObj,"eq_aset_sts_cd|sts_evnt_dt","1|2",-1,-1,1);
//     	         sheetObj.Copy2SheetCol(sheetObject1,"eq_aset_sts_cd","1",-1,-1,1);
     	         }catch(e){}
    	   }
   */
     	   function sheet2_OnClick(sheetObj, Row, Col) {
     	   try{
     	        	var sheetObject1=sheetObjects[0];
//      	            ComShowMessage("sheet2_OnDblClick  Row==========="+Row);
      	            var strSaveNames="eq_aset_sts_cd|sts_evnt_dt|sts_evnt_ofc_cd|sts_evnt_yd_cd|agreeement|agmt_ref_no|vndr_seq|eq_no|eq_sts_seq";  //test....
      	            var strStatus="";
      	            var termCngSeq="";
      	            var termChk=0;
      	            var chkVal="N";
   	   	         	for(i=1; i<sheetObj.RowCount()+1; i++){
   					if(i==Row)
   					{
   						 sheetObj.SetCellValue(Row,'del_chk',"1");
   					}
   					else
   					{
   						sheetObj.SetCellValue(i,'del_chk',"0");
   					}
   	  			 }
   	   	         sheetObj.SetCellValue(Row,'del_chk',"1");
   	   	         termCngSeq=sheetObj.GetCellValue(Row,'term_cng_seq');
   	   	       if(termCngSeq != '')
   	   	       {
	   	   	    	for(i=1; i<sheetObj.RowCount()+1; i++){
	   					if(sheetObj.GetCellValue(i,'term_cng_seq')== termCngSeq && Row != i)
	   					{
	   						sheetObj.SetCellValue(i,'del_chk',"1");
	   						termChk=i;
	   					}
	   	 		   }
	   	   	    	var sXml=ComMakeSearchXml(sheetObj   , false,"del_chk", strSaveNames, false);  //all column : move 
	   	    	   sheetObjects[0].RemoveAll();
	      	       sheetObjects[0].LoadSearchData(sXml,{Append:1 , Sync:1} );
	      	       sheetObj.SetCellValue(termChk,'del_chk',"0");
   	   	       }
   	   	       else
   	   	       {
   	   	    	   var sXml=ComMakeSearchXml(sheetObj   , false,"del_chk", strSaveNames, false);  //all column : move 
   	   	    	   sheetObjects[0].RemoveAll();
   	      	       sheetObjects[0].LoadSearchData(sXml,{Append:1 , Sync:1} );
   	   	       }
   	   	       for(i=1; i<sheetObj.RowCount()+1; i++){
   					if(sheetObj.GetCellValue(i,'del_chk')=="1")
   					{
   						sts_seq=sheetObj.GetCellValue(i,'eq_sts_seq') ;
   						strStatus=sheetObj.GetCellValue(i,'eq_aset_sts_cd') ;
   						chkVal=sheetObj.GetCellValue(i,'chk_val') ;
   					}
   	 		   }
   	   	       if( sts_seq ==formObj.eq_sts_seq.value ){
   	   	    	   sheet1_edit(strStatus,chkVal);
   			   } 
      	         }catch(e){}
     	   }
     	   function sheet1_edit(strStatus,chkVal)
	   	   {
     	    	if(chkVal == "N"){
     	    		if(strStatus=='LSO' || strStatus=='SBO'  || strStatus=='SBI'  || strStatus=='MUI'  || strStatus=='LST'  || strStatus=='FND')
         		    {
    	   		      	sheetObjects[0].SetCellEditable(1, "sts_evnt_dt",1);
    	   		      	sheetObjects[0].SetCellEditable(1, "sts_evnt_yd_cd",1);
    	   		      	sheetObjects[0].SetColProperty(0,"sts_evnt_dt", {Format:"####-##-## ##:##", EditLen:16} );
    	   	   		}
    	     		if(strStatus=='LSO' || strStatus=='SBO'  )
    	   		    {
    	     				//sheetObjects[0].CellEditable(1, "agreeement")      = true;
    	     				sheetObjects[0].SetCellEditable(1, "agreeement",0);
    	   	   		}
     	    	}
	   	   }
   
  /**
   * function(ex:btn_save) role(trole) apply  <br>
   * @param  
   * @return 
   * @author 
   * @version
   */     
   function tRoleApply() {
// 	  var formObj=document.form;
// 	  if(formObj.trole.value == "Authenticated")
// 	  {
// 	  }else
// 	  {
// 		  ComBtnDisable("btn_del");
// 		  ComBtnDisable("btn_save2");
// 	  }
   }   
   // retrieve after saving
	function sheet1_OnSaveEnd(sheetObj, code, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
	    	set_serch();
		}
	}    	
	// deleting, retrieve
	function sheet2_OnSaveEnd(sheetObj2, code, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
	    	set_serch();
		}
	}
	/* developer job end */
  function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
 	ComOpenWait(false);
  }
  
  function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
   	ComOpenWait(false);
  }