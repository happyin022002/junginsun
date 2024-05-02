/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0061.js
*@FileTitle  : Manifest Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
    /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     */
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry business script.
     */
 // global variable
	 var tabObjects=new Array();
	 var tabCnt=0 ;
	 var beforetab=1;
	 var checkAll=1;
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var vIsCheck=0;
 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
 		         var sheetObject1=sheetObjects[0];
 		         var sheetObject2=sheetObjects[1]; 
 		         var sheetObject3=sheetObjects[2];		         
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {  
             				case "btn_save":
             					doActionIBSheet(sheetObjects[2],document.form,COMMAND03);
             				break;
 							case "btn_retrieve":
 								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 							break;
 							case "btn_downexcel":
 								if(sheetObject3.RowCount() < 1){
 									ComShowCodeMessage("COM132501");
 								}else{
// 									sheetObject3.Down2Excel({ HiddenColumn:-1});
 									sheetObject3.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject3), SheetDesign:1,Merge:1,DownSum:1,KeyFieldMark:0});
 									
 								}
 							break;							
 							case "btn_add": 	 
 								doActionIBSheet(sheetObjects[2],document.form,COMMAND01); 								
 							break;							
 							case "btn_del":
 								doActionIBSheet(sheetObjects[2],document.form,IBDELETE); 			
 							break;							
 							case "btn_trans":
 								doActionIBSheet(sheetObjects[2],document.form,IBSAVE); 		
 							break;	
 							case "btn_close":
 								ComClosePopup(); 		
 							break;	
 							case "btn_view":
 								doActionIBSheet(sheetObjects[2], formObject, COMMAND05);
 							break;
 							case "btn_reject":
 								if(document.getElementById("btn_reject").innerText == "Reject Select")
 								{
 									document.getElementById("btn_reject").innerHTML="Reject DeSelect";
 									sheetRejectCheck(sheetObjects[2],"R");
 								}
 								else
 								{
 									sheetRejectCheck(sheetObjects[2],"A");						 
 	 								document.getElementById("btn_reject").innerHTML="Reject Select";
 								}
 							break;	
 							case "btn_confirm":
 								doActionIBSheet(sheetObjects[2],document.form,COMMAND02);
 							break;													
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
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
        var formObject=document.form;
        if(formObject.cn_no.value != "" || formObject.vvd_no.value != "")
        {
        	if(formObject.vvd_no.value.length > 0)
        	{
        		formObject.vsl_cd.value=formObject.vvd_no.value.substring(0,4);
        		formObject.skd_voy_no.value=formObject.vvd_no.value.substring(4,8);
        		formObject.skd_dir_cd.value=formObject.vvd_no.value.substring(8);
        		formObject.frm_vvd_number.value=formObject.vvd_no.value;
        	}
        	formObject.frm_crn_number.value=formObject.cn_no.value;
        	var sheetObject1=sheetObjects[0];
        	doActionIBSheet(sheetObject1,document.form,IBSEARCH);	
        	formObject.frm_vvd_number.focus();
        }
        axon_event.addListenerForm  ('change', 'obj_change', form); 
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
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
		               var HeadTitle1="|Seq.|POL|POL ATD|POD|BDR|BDR DATE|Sub B/L TTL\n(Excl. Non-BDR)|Sub B/L TTL\n(Incl. Non-BDR)";
		
		               SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trnk_bdr_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"trnk_auto_bdr_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:180,  Align:"Right",   ColMerge:1,   SaveName:"excl_count",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:180,  Align:"Right",   ColMerge:1,   SaveName:"incl_count",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               SetCountPosition(0);
		               SetSheetHeight(115);
		               }
                 break;
             case 2:      //sheet2 init
            	    with(sheetObj){
                
              
	               var HeadTitle1="|TTL |B/L Count";
	
	               SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ttl",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	                      {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bl_count",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0} ];
	                
	               InitColumns(cols);
	               SetCountPosition(0);
	               SetSheetHeight(115);
	               
               }
             break;                  
             case 3:      //sheet3 init
                 with(sheetObj){
//	              var HeadTitle1="||Sel.|Seq.|Kind|B/L No.|CUS|Container|F/M|POR|POL|POD|DEL|PRD|POST|Package|Package|WGT|WGT|BDR|Description|Notify Address|Send Result|Sent by|Sent Date|Response Result|Response Date|CFM IND|CFM STF|CFM Date||||||||||";
	              var HeadTitle1="||Sel.|Seq.|Kind|B/L No.|CUS|Container|F/M|POR|POL|POD|DEL|PRD|POST|Package|Package|WGT|WGT|BDR|Description|Notify Address|Send Result|Sent by|Sent Date|Response Result|Response Date|CFM IND|CFM STF|CFM Date||||||||||";
	              SetConfig( { SearchMode:2,FrozenCols:4, MergeSheet:7, Page:20, DataRowMerge:0 } );	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                  {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
	                  {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"kind",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"t1_doc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Center", ColMerge:1,   SaveName:"pol_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:5 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Center", ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pre_rly_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pst_rly_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_mf_wgt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cntr_mf_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_addr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mf_snd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rtm_re_msg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"re_msg_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dat_cfm_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_dat_cfm_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no_split",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mt_flag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"user_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"frm_crn_number",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bigo_kind",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dif_char",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	               
	              InitColumns(cols);	             
	              SetEditable(1);
	              FrozenCols=4;
	              SetColProperty("kind", {ComboText:"|Cancel|Replace|Original", ComboCode:"|1|5|9"} );
	              SetColProperty("t1_doc_cd", {ComboText:"|T1|TS", ComboCode:"0|D|T"} );
	              SetColProperty("rtm_re_msg_sts_cd", {ComboText:"Accept|Reject", ComboCode:"A|R"} );
	              
	              SetCountPosition(0);
	              SetSheetHeight(335);
	             
              }
              break; 
         }
     }
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         		case COMMAND03:     // save
         			if(!validateForm(sheetObj,formObj,sAction)) {
 				 		return false;
 				 	}
         			formObj.f_cmd.value=MULTI02;
 					sheetObj.SetWaitImageVisible(0);
 					var sParam="";					 
					sParam=ComSetPrifix(sheetObjects[2].GetSaveString(), "sheet3_");
					if(sParam == "") {
						ComShowCodeMessage('BKG00743');
 						return false;
					}
					var sheet3RowCnt=sheetObjects[2].RowCount();
    				var podCdChangeCnt=0;
    				ComOpenWait(true);
			    	for (var i=1; i <= sheet3RowCnt; i++) {
			    		if(sheetObjects[2].GetCellValue(i, "del_chk") == 1){
			    			sheetObjects[2].SetCellValue(i, "del_chk",0);
			    		}
			    		if(sheetObjects[2].GetCellValue(i, "pol_cd") != sheetObjects[2].CellSearchValue(i, "pol_cd")) {
			    			podCdChangeCnt++;
			    		} else {
			    			sheetObjects[2].SetRowStatus(i,"");
			    		}
			    	}
			    	if(podCdChangeCnt == 0) {
			    		ComShowCodeMessage('BKG00743');
			    		ComOpenWait(false);
 						return false;
			    	} 
					sParam += "&" + FormQueryString(formObj);
    				sheetObj.SetWaitImageVisible(0);
    				var sXml=sheetObjects[2].GetSaveData("ESM_BKG_0061GS.do", sParam);
    				sheetObjects[2].LoadSaveData(sXml);
					ComOpenWait(false);
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         		break;
 				case IBSEARCH:      //Retrieve
 				 	if(!validateForm(sheetObj,formObj,sAction)) {
 				 		return false;
 				 	}  	         
 					formObj.f_cmd.value=SEARCH;
 					sheetObj.SetWaitImageVisible(0);
 					sheetObjects[1].SetWaitImageVisible(0);
 					sheetObjects[2].SetWaitImageVisible(0);
 					ComOpenWait(true);
 					if(formObj.cargoType.checked == true)
 						formObj.mt_flag.value="P";
 					else formObj.mt_flag.value="F";
 					formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
 					formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
 					formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);	
// 					if(sheetObjects[2].RowCount()> 0)
// 					{
// 						initSheet(sheetObjects[2],3);
// 						initSheet(sheetObjects[1],2);
// 					}
 					sXml=sheetObj.GetSearchData("ESM_BKG_0061GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
			   	  	if (arrXml.length > 0) {			   	  		 
			   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			   	  	}
			   	  	if (arrXml.length > 1) {
			   	  		sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			   	  	} 
			   	  	if (arrXml.length > 2) {
			   	  		sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			   	  	}			   	  	
			   	    ComEtcDataToForm(formObj, sheetObj);
			   	    sheetObjects[1].DataInsert(-1);
					var aa=sheetObjects[1].GetCellValue(1, 2);
					var bb=sheetObjects[1].GetCellValue(2, 2);
			   	    sheetObjects[1].SetCellValue(3, 1,"Differ",0);
			   	    sheetObjects[1].SetCellValue(3, 2,aa - bb,0);
			   		ComOpenWait(false);
 				break;
 				case COMMAND01: //row add
 					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					} 
 				    var  bkg_no="";
 					sheetObj.SetWaitImageVisible(0);
 					ComOpenWait(true);
 					if (sheetObjects[2].RowCount()>0)
 						{
 							bkg_no=sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "bkg_no");
 						}
 					else
 						{
 							bkg_no=sheetObjects[2].GetCellValue(0, "bkg_no");
 						}
					var sUrl="/opuscntr/ESM_BKG_1017.do?pgmNo=ESM_BKG_1017&bkg_no="+bkg_no+"&frm_crn_number="+formObj.frm_crn_number.value;
					ComOpenWindowCenter(sUrl, "ESM_BKG_1017", 300,200, true);
					formObj.f_cmd.value=SEARCH;
 					if(formObj.cargoType.checked == true)
 						formObj.mt_flag.value="P";
 					else formObj.mt_flag.value="F";
 					formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
 					formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
 					formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);	
 					if(sheetObjects[2].RowCount()> 0)
 					{
 						initSheet(sheetObjects[2],3);
 						initSheet(sheetObjects[1],2);
 					}
 					sXml=sheetObj.GetSearchData("ESM_BKG_0061GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
			   	  	if (arrXml.length > 0) {			   	  		 
			   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
			   	  	}
			   	  	if (arrXml.length > 1) {
			   	  		sheetObjects[1].LoadSearchData(arrXml[1],{Sync:0} );
			   	  	} 
			   	  	if (arrXml.length > 2) {
			   	  		sheetObjects[2].LoadSearchData(arrXml[2],{Sync:0} );
			   	  	}			   	  	
			   	    ComEtcDataToForm(formObj, sheetObj);
			   	    sheetObjects[1].DataInsert(-1);
					var aa=sheetObjects[1].GetCellValue(1, 2);
					var bb=sheetObjects[1].GetCellValue(2, 2);
			   	    sheetObjects[1].SetCellValue(3, 1,"Differ",0);
			   	    sheetObjects[1].SetCellValue(3, 2,aa - bb,0);
			   	    ComOpenWait(false);
 				break;	
 				case COMMAND02: //CONFIRM ALL
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
					sheetObj.SetWaitImageVisible(0);
 					ComOpenWait(true); 
 				    if(ComShowCodeConfirm("BKG00614")){ // "Do you want confirm it?"  				    	 
 				    	formObj.f_cmd.value=MULTI; 	
 				    	for (var i=1; i <= sheetObjects[2].RowCount(); i++) {
 				    		if(sheetObjects[2].GetCellValue(i, "del_chk") == 1)
 				    		{
 				    			sheetObjects[2].SetCellValue(i, "ibflag","U",0);
 	 							sheetObjects[2].SetCellValue(i, "user_id",formObj.user_id.value,0);
 	 							sheetObjects[2].SetCellValue(i, "mt_flag",sheetObjects[2].GetCellValue(i, "bkg_cgo_tp_cd"),0);
 				    		} 							 
 						} 				    	 				    	 
 				    	sheetObjects[2].DoSave("ESM_BKG_0061GS.do", FormQueryString(formObj));
 				    }
 				   formObj.f_cmd.value=SEARCH;
					if(formObj.cargoType.checked == true)
						formObj.mt_flag.value="P";
					else formObj.mt_flag.value="F";
					formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
					formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
					formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);	
//					if(sheetObjects[2].RowCount()> 0)
//					{
//						initSheet(sheetObjects[2],3);
//						initSheet(sheetObjects[1],2);
//					}
					sXml=sheetObj.GetSearchData("ESM_BKG_0061GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
			   	  	if (arrXml.length > 0) {			   	  		 
			   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
			   	  	}
			   	  	if (arrXml.length > 1) {
			   	  		sheetObjects[1].LoadSearchData(arrXml[1],{Sync:0} );
			   	  	} 
			   	  	if (arrXml.length > 2) {
			   	  		sheetObjects[2].LoadSearchData(arrXml[2],{Sync:0} );
			   	  	}			   	  	
			   	    ComEtcDataToForm(formObj, sheetObj);
			   	    sheetObjects[1].DataInsert(-1);
					var aa=sheetObjects[1].GetCellValue(1, 2);
					var bb=sheetObjects[1].GetCellValue(2, 2);
			   	    sheetObjects[1].SetCellValue(3, 1,"Differ",0);
			   	    sheetObjects[1].SetCellValue(3, 2,aa - bb,0);
			   	    ComOpenWait(false); 
				break;	
 				case IBSAVE:        // transmission
 					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					} 	
 				    vIsCheck=0;
				    for(i=1; i<=sheetObjects[2].RowCount(); i++) {
				    	if( i==1)
				    	{
								bl_no=sheetObj.GetCellValue(i, "bl_no");
								if(sheetObj.GetCellValue(i, "del_chk") == 1)
				    			vIsCheck++;
				    	}
				    	if(bl_no != sheetObj.GetCellValue(i, "bl_no"))
				    	{
				    		if(sheetObj.GetCellValue(i, "del_chk") == 1)
				    			vIsCheck++;
				    			bl_no=sheetObj.GetCellValue(i, "bl_no");
				    	}				    		    
				    }
				    //if (vIsCheck > 1) {
 					//	ComShowCodeMessage('BKG00733');	
 					//	return;
 					//}
 					if (vIsCheck == 0) {
 						ComShowCodeMessage('BKG00249');	
 						return;
 					}
 					var vIsCheck2=true;
 					for(i=1; i<=sheetObjects[2].RowCount(); i++) {
 						if(sheetObj.GetCellValue(i, "del_chk") == 1&& sheetObj.GetCellValue(i, "dat_cfm_flg") == "N" )
 						{
 							vIsCheck2=false;
 						}
 					}
 					if (vIsCheck2 == false) {
 						ComShowCodeMessage('BKG00620');	
 						return;
 					} 					
 					formObj.f_cmd.value=MULTI01;
 					for (var i=1; i <= sheetObjects[2].RowCount(); i++)
 					{
 						if(sheetObjects[2].GetCellValue(i, "del_chk") == 1)
 						{	
						   sheetObjects[2].SetCellValue(i, "ibflag","I",0);
						   sheetObjects[2].SetCellValue(i,"vsl_cd",formObj.vsl_cd.value,0);
						   sheetObjects[2].SetCellValue(i,"skd_voy_no",formObj.skd_voy_no.value,0);
						   sheetObjects[2].SetCellValue(i,"skd_dir_cd",formObj.skd_dir_cd.value,0);
						   sheetObjects[2].SetCellValue(i,"dif_char","@@",0);
 						}
					}
					var sParam="";					 
					var sParamSheet2=sheetObjects[2].GetSaveString();
					if (sParamSheet2 != "") {
						sParam += "&" + ComSetPrifix(sParamSheet2, "sheet3_");
					}					 
					sParam += "&" + FormQueryString(formObj);
    				sheetObj.SetWaitImageVisible(0);
    				ComOpenWait(true,true);
    				var sXml=sheetObjects[2].GetSaveData("ESM_BKG_0061GS.do", sParam);
					var key=ComGetEtcData(sXml, "KEY");
					ComOpenWait(true);
					intervalId=setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
 				break;
 				case COMMAND05:      //  bl view
 					/*var bl_no=0; 	
 				    vIsCheck=0;
 				    for(i=1; i<=sheetObjects[2].RowCount(); i++) {
 				    	if( i==1)
 				    	{
							bl_no=sheetObj.GetCellValue(i, "bl_no");
							if(sheetObj.GetCellValue(i, "del_chk") == 1)
 				    			vIsCheck++;
 				    	}
						if(bl_no != sheetObj.GetCellValue(i, "bl_no"))
 				    	{
						if(sheetObj.GetCellValue(i, "del_chk") == 1)
 				    			vIsCheck++;
						bl_no=sheetObj.GetCellValue(i, "bl_no");
 				    	}
 				    }
 					if (vIsCheck > 1) {
 						ComShowCodeMessage('BKG06059');	
 						return;
 					}
 					if (vIsCheck == 0) {
 						ComShowCodeMessage('BKG00249');	
 						return;
 					}
 					for(i=1; i<=sheetObjects[2].RowCount(); i++) {
					if(sheetObj.GetCellValue(i, "del_chk") == 1)
					bl_no=sheetObj.GetCellValue(i, "bl_no");
 					}
 				    var frm_bl_no=bl_no;
 				    */			     
 					var sUrl=("/opuscntr/ESM_BKG_0442_POP.do?pgmNo=ESM_BKG_0442&crn_no="+formObj.frm_crn_number.value+"&frm_bl_no="+sheetObjects[2].GetCellValue(sheetObj.GetSelectRow(), "bl_no")+"&pop_up=Y");
 					ComOpenWindowCenter(sUrl, "ESM_BKG_0442", 1100, 680, false);
 				break;
 				case IBDELETE:      // delete
 					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					} 
 					sheetObj.SetWaitImageVisible(0);
 					ComOpenWait(true);
 				 	if(ComShowCodeConfirm("BKG00592")){   
 				 		formObj.f_cmd.value=REMOVE; 
 				 		for (var i=1; i <= sheetObjects[2].RowCount(); i++) {
 				 			if(sheetObj.GetCellValue(i, "del_chk") == 1)
 				 			{
 							  sheetObjects[2].SetCellValue(i, "ibflag","D",0);
 							  sheetObjects[2].SetCellValue(i, "user_id",formObj.user_id.value,0);
 							  if(formObj.cargoType.checked == true)
 								sheetObjects[2].SetCellValue(i, "mt_flag","P",0);
 							  else sheetObjects[2].SetCellValue(i, "mt_flag","F",0);
 				 			} 				 			
 						} 			
 				 		var sParam="";
						var sParamSheet2=sheetObjects[2].GetSaveString();
						if (sParamSheet2 != "") {
							sParam += "&" + ComSetPrifix(sParamSheet2, "sheet3_");
						}
						//if (sParam == "") return;
						sParam += "&" + FormQueryString(formObj);
						var sXml=sheetObj.GetSaveData("ESM_BKG_0061GS.do", sParam);
						sheetObjects[2].LoadSaveData(sXml);
 				    	//sheetObjects[2].DoSave("ESM_BKG_0061GS.do", FormQueryString(formObj));
 				    	formObj.f_cmd.value=SEARCH;
 	 					if(formObj.cargoType.checked == true)
 	 						formObj.mt_flag.value="P";
 	 					else formObj.mt_flag.value="F";
 	 					formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
 	 					formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
 	 					formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);	
 	 					sXml=sheetObj.GetSearchData("ESM_BKG_0061GS.do", FormQueryString(formObj));
 						var arrXml=sXml.split("|$$|");
 				   	  	if (arrXml.length > 0) {			   	  		 
 				   	  	    sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
 				   	  	}
 				   	  	if (arrXml.length > 1) {
 				   	  		sheetObjects[1].LoadSearchData(arrXml[1],{Sync:0} );
 				   	  	} 
 				   	  	if (arrXml.length > 2) {
 				   	  		sheetObjects[2].LoadSearchData(arrXml[2],{Sync:0} );
 				   	  	}			   	  	
 				   	    ComEtcDataToForm(formObj, sheetObj);
 				   	    sheetObjects[1].DataInsert(-1);
						var aa=sheetObjects[1].GetCellValue(1, 2);
						var bb=sheetObjects[1].GetCellValue(2, 2);
 				   	    sheetObjects[1].SetCellValue(3, 1,"Differ",0);
 				   	    sheetObjects[1].SetCellValue(3, 2,aa - bb,0);
 				 	}
 				 	ComOpenWait(false);
 				break;
         }
     }
     /**
      * BackEndJob result retrieve.
      */
     function doActionValidationResult(sheetObj, sKey) {
//    	 sheetObjects[2].SetWaitImageVisble(0);
    	 var sXml=sheetObj.GetSearchData("ESM_BKG_0061GS.do?f_cmd=" + SEARCH03
     			+ "&key=" + sKey);
     	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
     	// if error occur, WaitImage End
     	if (!ComBkgErrMessage(sheetObj, sXml)) {
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		return;
     	}
     	if (sJbStsFlg == "SUCCESS") {
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		// show Success Msg 
     		ComShowCodeMessage('BKG00204');
     		//ComShowMessage(ComResultMessage(sXml));
     		// sheet1, sheet2 Re-Retrieve
     		var selRow=sheetObjects[0].GetSelectRow();
				doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
				//doActionIBSheet(sheetObjects[0],document.form, SEARCH02, selRow);	
     		return;
     	} else if (sJbStsFlg == "FAIL") {
     		//Error
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		// show Error Msg 
     		ComShowMessage(ComResultMessage(sXml));
     	}
     }     
     function  sheetRejectCheck(sheetObj,gubun)
     {    	      	  
    	 if(sheetObj.RowCount()> 0 && gubun == "R")
    	 {
    		 for(i=1;i<sheetObj.RowCount()+1;i++){
    			 if(sheetObj.GetCellValue(i,"rtm_re_msg_sts_cd") == gubun)
    			     sheetObj.SetCellValue(i, "del_chk",1,0);
    		 }
    	 }
    	 if(sheetObj.RowCount()> 0 && gubun == "A")
    	 {
    		 for(i=1;i<sheetObj.RowCount()+1;i++){
    			 if(sheetObj.GetCellValue(i, "del_chk") == 1)
    			     sheetObj.SetCellValue(i, "del_chk",0,0);
    		 }
    	 }
     }
     /**
      * Get BL_NO info
      */
     function sheet3_OnClick(sheetObj, row, col) {
    	 var formObject=document.form;
//    	 formObject.bl_no.value=sheetObj.GetCellValue(row, "bl_no").substring(0,12); // Toyota B/L
    	 if(sheetObj.GetCellValue(row, "bl_no").length==13){
    		 formObject.bl_no.value=sheetObj.GetCellValue(row, "bl_no").substring(0,12); // Toyota B/L
    	 }else if(sheetObj.GetCellValue(row, "bl_no").length==11){
    		 formObject.bl_no.value=sheetObj.GetCellValue(row, "bl_no").substring(0,10); // Toyota B/L
    	 }else{
    		 formObject.bl_no.value=sheetObj.GetCellValue(row, "bl_no"); // Toyota B/L
    	 }
    	 formObject.bkg_no.value=sheetObj.GetCellValue(row, "bkg_no");
    	 if(formObject.cargoType.checked == true)
    		 formObject.mt_flag.value="P";
		 else formObject.mt_flag.value="F";
    	 //sheetObj.CellValue2(row, "ibflag") = "I";
    	 var rowCnt=sheetObj.RowCount();
		 var check=sheetObj.GetCellValue(row,"del_chk");
		 var keyBlNo=sheetObj.GetCellValue(row,"bl_no");
    	 var colSaveName=sheetObj.ColSaveName(col);
    	 if(colSaveName == "kind") return;
    		for(i=1; i<=rowCnt+1; i++) {
    			if(colSaveName != "del_chk") {
    	    		if(check == 0) {
    	    			//if(i == row)
    	    			//   continue;
    	    			if(keyBlNo == sheetObj.GetCellValue(i, "bl_no")) {
    	    				sheetObj.SetCellValue(i, "del_chk",1);
    	    			}    	    			     	    			     	    			    	    	
    	    		} else if(check == 1) {
    	    			//if(i == row)
    	    			// continue;
    	    			if(keyBlNo == sheetObj.GetCellValue(i, "bl_no")) {
    	    				sheetObj.SetCellValue(i, "del_chk",0);
    	    			}    	    			 
    	    		} 
    			} else {
    	    		if(check == 0) {
    	    			if(i == row)
    	    			   continue;
    	    			if(keyBlNo == sheetObj.GetCellValue(i, "bl_no")) {
    	    				sheetObj.SetCellValue(i, "del_chk",1);
    	    			}    	    			     	    			     	    			    	    	
    	    		} else if(check == 1) {
    	    			if(i == row)
    	    			 continue;
    	    			if(keyBlNo == sheetObj.GetCellValue(i, "bl_no")) {
    	    				sheetObj.SetCellValue(i, "del_chk",0);
    	    			}    	    			 
    	    		}    				
    			}
    		} // end for(i)
     }
     /**
      *  
      */
     function sheet3_OnChange(sheetObj, row, col, value) {
		var kind=sheetObj.GetCellValue(row, "kind");
		var bl_no=sheetObj.GetCellValue(row, "bl_no");
    	 var status=true;
    	 if(kind == "9")
    	 {
			if(sheetObj.GetCellValue(row, "dat_cfm_flg") == "N" &&
			sheetObj.GetCellValue(row, "rtm_re_msg_sts_cd") == "") // 12345
    		 {	
    			 ComShowCodeMessage('BKG00620');
				 sheetObj.SetCellValue(row, "kind",sheetObj.GetCellValue(row, "bigo_kind"));
				 kind=sheetObj.GetCellValue(row, "bigo_kind");
    			 status=false;
    		 }
			if(sheetObj.GetCellValue(row, "dat_cfm_flg") == "Y" &&
			(sheetObj.GetCellValue(row, "bigo_kind") == "5" ||
			sheetObj.GetCellValue(row, "bigo_kind") == "1"))
    		 {
    			 ComShowCodeMessage('BKG00621');
				 sheetObj.SetCellValue(row, "kind",sheetObj.GetCellValue(row, "bigo_kind"));
				 kind=sheetObj.GetCellValue(row, "bigo_kind");
    			 status=false;
    		 }
    	 } 
    	 if(kind == "5")
    	 {
			if(sheetObj.GetCellValue(row, "dat_cfm_flg") == "N" &&
			sheetObj.GetCellValue(row, "rtm_re_msg_sts_cd") == "")
    		 {
    			ComShowCodeMessage('BKG00620');
				sheetObj.SetCellValue(row, "kind",sheetObj.GetCellValue(row, "bigo_kind"),0);
				kind=sheetObj.GetCellValue(row, "bigo_kind");
				status=false;
    		 }
			if(sheetObj.GetCellValue(row, "dat_cfm_flg") == "Y" &&
			sheetObj.GetCellValue(row, "rtm_re_msg_sts_cd") != "A" ||
			(sheetObj.GetCellValue(row, "bigo_kind") != "5" &&
			sheetObj.GetCellValue(row, "bigo_kind") != "9")
    			)
    		 {
    			 ComShowCodeMessage('BKG00622');
				 sheetObj.SetCellValue(row, "kind",sheetObj.GetCellValue(row, "bigo_kind"));
				 kind=sheetObj.GetCellValue(row, "bigo_kind");
    			 status=false;
    		 }
    	 } 
    	 if(kind == "1")
    	 {
		if(sheetObj.GetCellValue(row, "dat_cfm_flg") == "N" &&
		sheetObj.GetCellValue(row, "rtm_re_msg_sts_cd") == "")
    		 {
    			 ComShowCodeMessage('BKG00620');
			sheetObj.SetCellValue(row, "kind",sheetObj.GetCellValue(row, "bigo_kind"),0);
			kind=sheetObj.GetCellValue(row, "bigo_kind");
    			 status=false;
    		 } 
			if(sheetObj.GetCellValue(row, "dat_cfm_flg") == "Y" &&
			sheetObj.GetCellValue(row, "rtm_re_msg_sts_cd") != "A" ||
			(sheetObj.GetCellValue(row, "bigo_kind") != "5" &&
			sheetObj.GetCellValue(row, "bigo_kind") != "9")
			    			)
    		 {
    			 ComShowCodeMessage('BKG00623');
			sheetObj.SetCellValue(row, "kind",sheetObj.GetCellValue(row, "bigo_kind"),0);
			kind=sheetObj.GetCellValue(row, "bigo_kind");
    			 status=false;
    		 }
    	 }
		 if ( status == true ) 
		 {
			 for ( var i=1 ; i<=sheetObj.RowCount()+1 ; i++ )
			 {
				 if ( sheetObj.GetCellValue(row, "seq") == sheetObj.GetCellValue(i, "seq") )
				 {
					 sheetObj.SetCellValue(i, "kind",kind);
				 }
			 }
		 }
     }
      /**
       * Enter event
       * @return
       */
      function obj_ComKeyEnter() {
       	var formObject=document.form;
       	var srcName=ComGetEvent("name");
       	if(srcName != "") {         		 
       		ComKeyEnter();
       	}         	         
      }
       /**
        * when enter retrieve creteria, handling
        */
//       function obj_KeyUp() {
//   		var formObject=document.form;
//   		var srcName=ComGetEvent("name");
//   		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//   		var srcValue=window.event.srcElement.getAttribute("value");
//   		if (  ( srcName == "frm_crn_number" || 
//   				srcName == "frm_vvd_number" || 
//   				srcName == "pol_cd")         				 
//   			&& ComChkLen(srcValue, srcMaxLength) == "2") 
//   		{
//   			ComSetNextFocus();
//   		}
//   	}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
    	case COMMAND03: // save
    			return true;
    		break;
  		case IBSEARCH: // Retrieve
  			if (formObj.frm_vvd_number.value.length == 0 || formObj.frm_crn_number.value.length == 0) {
  				ComShowCodeMessage('BKG00591');
  				formObj.frm_crn_number.focus(); // Please Input Option - [CRN and VVD]
  				return false;
  			}
  			return true;
  			break;
  		case COMMAND01: // ADD
			if (formObj.frm_crn_number.value.length == 0) {
				ComShowCodeMessage('BKG00607');
				formObj.frm_crn_number.focus();
				return false;
			}
		return true;
			break;
  		case COMMAND02: // confirm all
  			var vIsCheck=false;
			for(var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "del_chk") == 1) {
					vIsCheck=true;
					break;
				}
			}
			if (!vIsCheck) {
				ComShowCodeMessage('BKG00567');
				return false;
			}
  			if (formObj.frm_crn_number.value.length == 0) {
  				ComShowCodeMessage('BKG00607');
  				formObj.frm_crn_number.focus();
  				return false;
  			}
  		return true;
		break;
  		case IBDELETE: // 
  			var vIsCheck=false;
			for(var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "del_chk") == 1) {
					vIsCheck=true;
					break;
				}
			}
			if (!vIsCheck) {
				ComShowCodeMessage('BKG00567');
				return false;
			}
		return true;
  		case IBSAVE: // save
	  		var vIsCheck=false;
			for(var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "del_chk") == 1) {
					vIsCheck=true;
					break;
				}
			}
			if (!vIsCheck) {
				ComShowCodeMessage('BKG00567');
				return false;
			}
			
			if (!ComShowCodeConfirm("BKG06200", "")){
				return false;
			}
			
	  		return true;
	  	break;
  		}	
     }
	function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
		//alert("a");
		if (ErrMsg == "") {
			if (document.form.f_cmd.value == IBSAVE) {
				ComShowCodeMessage('BKG00204');
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			} 
		} else {
			//ComShowCodeMessage('BKG00391');
		}
	}