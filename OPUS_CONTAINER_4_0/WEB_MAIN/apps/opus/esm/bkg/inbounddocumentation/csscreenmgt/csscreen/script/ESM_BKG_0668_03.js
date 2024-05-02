/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_01.js
*@FileTitle  : In-bound C/S Screen US
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var t1beforetab=1;
    var t3beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var t3sheet1_num=0;
    var t3sheet1_1_num=1;
    var t3sheet1_2_num=2;
    var t3sheet1_3_num=3;
    var comboFlg=null;
    var cntrQtySum=0;
    var chgFlag=null;
    var frt_term_cd=null;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /***** using extra sheet valuable if there are more 2 sheets *****/
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
	                case "btn_Cop":
	                	if (sheetObjects[t3sheet1_num].RowCount()== 0) return;
	                	cntr_no=sheetObjects[t3sheet1_num].GetCellValue(sheetObjects[t3sheet1_num].GetSelectRow(), "t3sheet1_cntr_no");
	                	param="?pgmNo=ESD_SCE_0001&cntr_no="+cntr_no;
	                	ComOpenWindow("/opuscntr/ESD_SCE_0001_POP.do"+param, "myWin", "scroll:yes;status:no;help:no;dialogWidth:1024px;dialogHeight:500px;dialogLeft:0;dialogTop:0", false);	                	
	                	break;
	                case "btn_Movement":
	                	if (sheetObjects[t3sheet1_num].RowCount()== 0) return;
	                	cntr_no=sheetObjects[t3sheet1_num].GetCellValue(sheetObjects[t3sheet1_num].GetSelectRow(), "t3sheet1_cntr_no").substring(0,10);
	                	var check=sheetObjects[t3sheet1_num].GetCellValue(sheetObjects[t3sheet1_num].GetSelectRow(), "t3sheet1_cntr_no").substring(10);
	                	var tpsz_cd=sheetObjects[t3sheet1_num].GetCellValue(sheetObjects[t3sheet1_num].GetSelectRow(), "t3sheet1_tpsz_cd");
	                	var fromDate="";
	                	var toDate=ComGetNowInfo();
	                	/*if (sheetObjects[t3sheet1_2_num].RowCount()> 0) {
	                		fromDate=ComGetMaskedValue(sheetObjects[t3sheet1_2_num].Cellvalue(sheetObjects[t3sheet1_2_num].RowCount(), "t3sheet1_2_event_dt").substring(0,8), "ymd");
	                	} else {
	                		fromDate=toDate;
	                	}*/
	                	param="?p_cntrno=" + cntr_no + "&" + "check_digit=" + check + "&" + "ctnr_tpsz_cd=" + tpsz_cd + "&pgmNo=EES_CTM_0408&pop_mode=1";
	                	ComOpenWindow("/opuscntr/EES_CTM_0408_POP.do"+param, "EES_CTM_0408", "scroll:yes;status:no;help:no;dialogWidth:1024px;dialogHeight:500px;dialogLeft:0;dialogTop:0", false);
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
            	if (sheetObjects[i].id == "t3sheet1_3") {
                    initSheet(sheetObjects[i],i+1);            		
            	} else {
                	ComConfigSheet (sheetObjects[i] );
                    initSheet(sheetObjects[i],i+1);
                    ComEndConfigSheet(sheetObjects[i]);
            	}
            }
            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
			if (document.form.bkg_no.value != "") {
				fnSearch();
			}
        }
         /**
          * setting sheet initial values and header
          * @param sheetObj
          * @param sheetNo
          * @return
          */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
    				case "t3sheet1":      //t3sheet1 init
   				      with(sheetObj){
	    		         var HeadTitle="|Seq.|Container No.|Size|Last Event(VVD)|Date|Place(Node Code)|ACT NM";
	    		         var headCount=ComCountHeadTitle(HeadTitle);
	    		         var prefix="t3sheet1_";
	
	    		         SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		         var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		         InitHeaders(headers, info);
	
	    		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",    Wrap:1 },
	    		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",       Wrap:1 },
	    		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	    		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	    		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:prefix+"lst_event", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	    		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"event_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	    		             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:prefix+"nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
	    		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	    		          
	    		         InitColumns(cols);
	
	    		         SetEditable(1);
	    		         SetCountPosition(0);
	    		         SetSheetHeight(85,1);
    				}
                    	break;
    				case "t3sheet1_1":      //t3sheet1_1 init
    				    with(sheetObj){
	    			      var HeadTitle="|Seq|Status|Date|Origin|Destination|Carrier|Train/Truck|Flat Car|Container No.";
	    			      var headCount=ComCountHeadTitle(HeadTitle);
	    			      var prefix="t3sheet1_1_";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    			      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	    			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	    			             {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:prefix+"mvmt_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mvmt_evnt_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:0,   SaveName:prefix+"org_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dest_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clm_crr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"trn_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"fcar_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
	    			       
	    			      InitColumns(cols);
	
	    			      SetEditable(1);
	    			      SetCountPosition(0);
	    			      SetSheetHeight(265);
    				}
	                    break;
    				case "t3sheet1_2":      //t3sheet1_2 init
    					with(sheetObj){
	    		         var HeadTitle="||Event Date|Activity|Location|VVD|Seal No.|MSG|B/L No.|Update Date|Container No.|Focus Flg";
	    		         var headCount=ComCountHeadTitle(HeadTitle);
	    		         var prefix="t3sheet1_2_";
	
	    		         SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    		         var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    		         InitHeaders(headers, info);
	
	    		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	    		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:prefix+"event_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:0,   SaveName:prefix+"act_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"msg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fcus_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    		          
	    		         InitColumns(cols);
	
	    		         SetEditable(1);
	    			      SetColProperty(prefix+"event_dt", {Format:"YmdHm"} );
	    			      SetColProperty(prefix+"upd_dt", {Format:"YmdHm"} );
	    		         SetEllipsis(1);
	    		         SetCountPosition(0);
	    		         SetSheetHeight(252);
    				}
                      	break;
    				case "t3sheet1_3":      //t3sheet1_3 init
    				    with(sheetObj){
	    			      var HeadTitle="||Event Date|Activity|Location|VVD|Seal No.|MSG|B/L No.|Update Date|Container No.|Focus Flg";
	    			      var headCount=ComCountHeadTitle(HeadTitle);
	    			      var prefix="t3sheet1_3_";
	
	    			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	    			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	
	    			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"event_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:190,  Align:"Center",  ColMerge:0,   SaveName:prefix+"act_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"msg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"fcus_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	    			       
	    			      InitColumns(cols);
	
	    			      SetEditable(1);
	    			      SetColProperty(prefix+"event_dt", {Format:"YmdHm"} );
	    			      SetColProperty(prefix+"upd_dt", {Format:"YmdHm"} );
	    			      //SetVisible(0);
    				}
    					break;
            }
        }
        /**
         * handling sheet process
         * @param sheetObj
         * @param formObj
         * @param sAction
         * @return void
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            switch(sAction) {
               case IBSEARCH:      //retrieve
                	ComOpenWait(true);
           			sheetObjects[t3sheet1_num].SetWaitImageVisible(0);
           			formObj.f_cmd.value=SEARCH;
           			var aryPrefix=new Array("t3sheet1_", "t3sheet1_1_", "t3sheet1_3_"); //prefix array of strings
                     var sXml=sheetObj.GetSearchData("ESM_BKG_0668_03GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

	         		var arrXml=sXml.split("|$$|");
         			//sheetObjects[t3sheet1_num].RenderSheet(0);
         			sheetObjects[t3sheet1_num].SetWaitImageVisible(0);
         			sheetObjects[t3sheet1_num].LoadSearchData(arrXml[0],{Sync:1} );
         			//sheetObjects[t3sheet1_num].RenderSheet(1);
         			//sheetObjects[t3sheet1_1_num].RenderSheet(0);
         			sheetObjects[t3sheet1_1_num].SetWaitImageVisible(0);
         			sheetObjects[t3sheet1_1_num].LoadSearchData(arrXml[1],{Sync:1} );
         			//sheetObjects[t3sheet1_1_num].RenderSheet(1);
         			//sheetObjects[t3sheet1_3_num].RenderSheet(0);
         			sheetObjects[t3sheet1_3_num].SetWaitImageVisible(0);
         			sheetObjects[t3sheet1_3_num].LoadSearchData(arrXml[2],{Sync:1} );
         			//sheetObjects[t3sheet1_3_num].RenderSheet(1);
	         		//sheetObjects[t3sheet1_num].SetWaitImageVisible(1);
	         		ComOpenWait(false);
                    break;
    			case COMMAND04:
					formObj.f_cmd.value=SEARCH04;
            	 	document.form.xmlData.value=null;
 		        	sheetObj.DoSearch("ESM_BKG_0668_03GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_1_") );
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
         * Tab option
         * setting tab list
         */
        function initTab(tabObj , tabNo) {
        	 switch(tabNo) {
                 case 1:
                   	 with (tabObj) {
						InsertItem( "CLM" , "");
						InsertItem( "General" , "");
						SetSelectedIndex(0);
                    }
                 break;
             }
        }
        /**
         * event in case of clicking tab
         * activating selected tab
         *  tab ine the B/L Info
         */
        function t3tab1_OnChange(tabObj , nItem)
        {
            var objs=document.all.item("t3tabLayer");
    	    	objs[nItem].style.display="Inline";
    	    	objs[t3beforetab].style.display="none";
    	    	objs[t3beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	    	t3beforetab=nItem;
        }
        /** 
         * isFloat(str) : Check numeric value
         */ 
         function isFloat(fVal) {
         	var temp=0;
         	var sVal=null;
         	var sIdx=fVal.toString().indexOf(".");
         	if (sIdx > 0) {
 	        	var sTemp=fVal.toString();
         		sVal=sTemp.substring(parseInt(sIdx) + 1);
 	        	if (parseInt(sVal) > 0 ) {
 	        		return true;
 	        	} else {
 	        		return false;
 	        	}
         	} else {
         		return false;
         	}
         }
       /**
        * displaying at t3sheet1_2 as information corresponding to the first row of the Container as reading t3sheet1_3 in case of value of t3sheet1_3
        */
       function t3sheet1_3_OnSearchEnd(sheetObj, Code ,ErrMsg){
           var cntrNo=null;
           var emptyXml="<SHEET>	<DATA  TOTAL='0'> </DATA> </SHEET>";
           if (ErrMsg == "") {
           	if(sheetObj.RowCount()> 0){
           		cntrNo=sheetObjects[t3sheet1_num].GetCellValue(1, "t3sheet1_cntr_no");
          	 		if (sheetObjects[t3sheet1_3_num].RowCount()> 0) {
          	 			copyMovementDetail(cntrNo);
          	 		} else {
          	 			sheetObjects[t3sheet1_2_num].LoadSearchData(emptyXml,{Sync:1} );
          	 		}
               } else {
//               	sheetObjects[t3sheet1_2_num].RemoveAll();
            	   sheetObjects[t3sheet1_2_num].LoadSearchData(emptyXml,{Sync:1} );
               }
           }
       }
        /**
         * displaying at t3sheet1_2 as information corresponding to the first row of the Container as reading t3sheet1_2 in case of value of t3sheet1_3 
         */
        function t3sheet1_OnDblClick(sheetObj, row, col){
       	    if (sheetObj.RowCount()> 0) {
       	    	var cntrNo=sheetObj.GetCellValue(row, "t3sheet1_cntr_no");
	       		copyMovementDetail(cntrNo);
	       		document.form.h_mov_cntr_no.value=cntrNo;
	       		sheetObjects[t3sheet1_1_num].RemoveAll();
    			doActionIBSheet(sheetObjects[t3sheet1_1_num],document.form,COMMAND04);
       	    }
        }
       function copyMovementDetail(cntrNo) {
			sheetObjects[t3sheet1_2_num].RemoveAll();
			var prefix7="t3sheet1_2_";
			var prefix8="t3sheet1_3_";
			var fcusRow=0;
			var row7=0;
			for(i=0;i<sheetObjects[t3sheet1_3_num].RowCount();i++){
				if (sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "cntr_no") == cntrNo) {
			   		row7=sheetObjects[t3sheet1_2_num].DataInsert(-1);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "sts_nm",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "sts_nm"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "event_dt",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "event_dt"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "act_nm",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "act_nm"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "loc_cd",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "loc_cd"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "vvd",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "vvd"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "seal_no",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "seal_no"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "msg",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "msg"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "bl_no",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "bl_no"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "upd_dt",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "upd_dt"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "cntr_no",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "cntr_no"),0);
			   		sheetObjects[t3sheet1_2_num].SetCellValue(row7,prefix7+ "fcus_flg",sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "fcus_flg"),0);
			   		if (sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "fcus_flg") == "Y") {
	                	fcusRow=row7;
	                }
			   		if (sheetObjects[t3sheet1_3_num].GetCellValue(i+1,prefix8+ "sts_nm") != "Actual") {
	                    sheetObjects[t3sheet1_2_num].SetRowBackColor(row7,"#66CC00");
	                }
			   	}
		   }
           sheetObjects[t3sheet1_2_num].SetSelectRow(fcusRow);
       }
       
     /**
     * deactivating button of screen
     */
    function buttonColorSet(btn_name, color){
    	var curFlag=null;
	   	if (color == 'red' || color == 'black') {
	   		curFlag="hand";
	   	} else {
	   		curFlag="default";
	   	}
    	var obj = document.getElementById(btn_name);
    	obj.style.color=color;
    	obj.style.cursor=curFlag;
       	 
       	 if (btn_name == "btn_split") {
       		 document.form.h_split.value=color;
       	 }
    }
   /**
    *  t3sheet1_OnSearchEnd event handler
    */
    function t3sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
    	if (ErrMsg != "") {
			fnMovementClear();
        }
    	if (sheetObj.RowCount()> 0) {
        	buttonColorSet("btn_Cop", 'red');
        	buttonColorSet("btn_Movement", 'red');
      	} else {
        	buttonColorSet("btn_Cop", 'gray');
        	buttonColorSet("btn_Movement", 'gray');
        }	        	
    }
    function fnMovementClear() {
    	sheetObjects[t3sheet1_num].RemoveAll();
    	sheetObjects[t3sheet1_1_num].RemoveAll();
    	sheetObjects[t3sheet1_2_num].RemoveAll();
    	sheetObjects[t3sheet1_3_num].RemoveAll();
    }
    // retrieve Processing modules are managed in an integrated way.
    function fnSearch() {
   		doActionIBSheet(sheetObjects[t3sheet1_num],document.form,IBSEARCH);        						
    }
    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
    		document.form.bkg_no.value=bkg_no;
    		fnSearch();
        }     	
    }    
