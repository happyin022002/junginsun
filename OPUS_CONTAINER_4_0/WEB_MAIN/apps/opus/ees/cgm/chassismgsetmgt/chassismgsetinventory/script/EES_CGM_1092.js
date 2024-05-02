/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1092.jsp
*@FileTitle  :  Chassis Inventory by Staying Days
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
     * @class EES_CGM_1092 : EES_CGM_1092 business script for
     */

   	/* developer job	*/
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
/**
 * Event handler processing by button name <br>
 * @param
 * @return 
 * @author 
 * @version
 */ 
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
        		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
        			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
        		}
////        		formObject.crnt_loc_cd.focus();     		
                break;
            case "btn_new":
            	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
            	//initControl();
            	loadPage();
                break;
            case "btn_downexcel":
            	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                break;
            case "btn_env_setting":
            	formObject.action="EES_CGM_1094.do";
            	formObject.pgmNo.value="EES_CGM_1094";
            	formObject.parentPgmNo.value="EES_CGM_M001";
            	formObject.submit();
                break;
            case "btns_crnt_loc_cd":	// Location Popup
                //var tmp=formObject.combo_location_text.value;
            	if(formObject.combo_location_text.value == "RCC"){
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);
            	} else if(formObject.combo_location_text.value == "LCC") {
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
            	} else if(formObject.combo_location_text.value == "SCC") {
            		//ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
            		ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
            		//ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
            	}
            	break;
            case "btns_crnt_yd_cd":		// Yard
            	//ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
            	ComOpenPopup('/opuscntr/COM_ENS_061.do', 800, 555, "callBackYard", "0,1,1,1,1,1,1", true, false);
            	break;
            case "btns_vndr":
            	ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 545, "callBackVendor", "0,1,1,1,1,1", true, false);
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
 * registering IBSheet Object as list <br>
 * @param  {object} sheet_obj	
 * @return 
 * @author 
 * @version
  */
 function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
 }
 /**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * @param  
 * @return 
 * @author 
 * @version
  */
 function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
     		//
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
     		//
         ComEndConfigSheet(sheetObjects[i]);
    }
    sheet1_OnLoadFinish(sheet1);
 }
/**
 * sheet setting and init in case of load finish <br>
 * @param  
 * @return 
 * @author 
 * @version
 */     
function sheet1_OnLoadFinish(sheetObj) {
    sheetObj.SetWaitImageVisible(0);
//    axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener('change', 'obj_change' , 'crnt_loc_cd');  
  	axon_event.addListener('change', 'obj_change' , 'crnt_yd_cd');  
  	axon_event.addListener('change', 'obj_change', 'vndr_seq');
  	axon_event.addListener('Onchange', 'aciac_div_cd_change', 'aciac_div_cd');    
  	axon_event.addListenerForm('keyup', 'obj_keyup', form);    
  	
 	// Multi Combo reset
 	comboObjects[comboCnt++]=combo_location;
 	comboObjects[comboCnt++]=aciac_div_cd;
 	comboObjects[comboCnt++]=chss_pool_cd;
 	comboObjects[comboCnt++]=group1;
 	comboObjects[comboCnt++]=eq_tpsz_cd;
	comboObjects[comboCnt++]=agmt_lstm_cd;
	comboObjects[comboCnt++]=chss_mvmt_sts_cd;
 	comboObjects[comboCnt++]=atch_bare;
 	comboObjects[comboCnt++]=dmg_snd;
  	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k]);
       
    }  
  	// Active St. MultiCombo value reset
  	var arrActive=new Array();
  	arrActive[0]="A|Active";
  	arrActive[1]="I|In-active";
  	makeComboObject(aciac_div_cd, arrActive, 1, 0, 0);
  	//Group MultiCombo value reset
  	var arrGroup=new Array();
  	arrGroup[0]="1|Type/Size";
  	arrGroup[1]="2|LCC[Loc]";
  	arrGroup[2]="3|Office";
  	arrGroup[3]="4|SCC[Loc]";
  	arrGroup[4]="5|Yard";
  	arrGroup[5]="6|Lease term";
  	arrGroup[6]="7|Lessor";
  	arrGroup[7]="8|Mvmt Status";
  	makeComboObject(group1, arrGroup, 1, 0, 1);
  	// Attach/Bare value reset
  	var arrActive=new Array();
  	arrActive[0]="ATTACHED|Attached";
  	arrActive[1]="BARE|Bare";
  	makeComboObject(atch_bare, arrActive, 1, 0, 1);
  	// Damage/Sound value reset
  	var arrActive=new Array();
  	arrActive[0]="DAMAGE|Damage";
  	arrActive[1]="SOUND|Sound";
  	makeComboObject(dmg_snd, arrActive, 1, 0, 1);
	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	initControl();	
    aciac_div_cd_change();
    sheetObj.SetCellValue(0,"group1",group1.GetSelectText());
  	sheetObj.SetCellValue(1,"group1",group1.GetSelectText());
    sheetObj.SetWaitImageVisible(1);
}
  /**
   * init control of form <br>
   * @param  
   * @return 
   * @author 
   * @version
   */
 function initControl(){
  	 var formObj=document.form;
  	 var sheetObj=sheetObjects[0];
  	 // Form Object reset
  	 with(formObj){
  		 crnt_loc_cd.value="";
  		 crnt_yd_cd.value="";
  		 staying_days.value="";
  		 vndr_seq.value="";
  		 include_np.checked=false;
  		 include_status_lst.checked=false;
  		 include_out_gated.checked=false; 
  	 }
  	 // MultiCombo reset
  	 for(var i=0; i<comboObjects.length; i++){
  		 comboObjects[i].SetSelectText("",false);
  	 }
  	 // Sheet Object reset
  	 sheetObj.RemoveAll();
  	 sheetObj.SetColHidden("group1",1);
	 // init value setting
  	 comboObjects[1].SetSelectIndex(0);
	 comboObjects[2].SetSelectIndex(0);
	 formObj.staying_days.value="0";
	 comboObjects[3].SetSelectIndex(1);//
	 //comboObjects[4].Index = 2;		// 
	 //comboObjects[5].Index = 2;		// 
	 //location popup선택 event handling.
	 //comboObjects[0].Index2 = 0;	// 
  	 comboObjects[0].SetSelectIndex(0);//  // RCC DEFAULT
////  	formObj.crnt_loc_cd.focus();
 }
	function resizeSheet(){
		ComResizeSheet( sheetObjects[0] );
	}
   /**
  * setting sheet initial values and header <br>
  * adding case as numbers of counting sheets <br>
  * @param  {object} sheetObj		 Sheet Object
  * @param  {int} sheetNo
  * @return 
  * @author 
  * @version
	*/
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
	 var sheetID=sheetObj.id;
     switch(sheetID) {
         case "sheet1":
             with(sheetObj){
             
        	 var HeadTitle1="|Seq.|Type/Size |Total|0 or Over |0 or Over |Today-15|Today-15|16-30|16-30|31-50|31-50|51-100|51-100|101-180|101-180|181 or Over|181 or Over";
        	 var HeadTitle2="|Seq.|Type/Size |Total|0 or Over|13Oct08 or over|13Oct08 or over|13Oct08-28Sep08|13Oct08-28Sep08|27Sep08-13Sep08|27Sep08-13Sep08|12Sep08-24Aug08|12Sep08-24Aug08|23Aug08-05Jul08|23Aug08-05Jul08|04Jul08-16Apr08|04Jul08-16Apr08|15Apr08 or over|15Apr08 or over";
        	 var headCount=ComCountHeadTitle(HeadTitle1);

        	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	 var headers = [ { Text:HeadTitle1, Align:"Center"},
        	                 { Text:HeadTitle2, Align:"Center"} ];
        	 InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
              {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"group1",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"chss_mvmt_dt_tot",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"AutoSum",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_0_or_over",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"Text",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_0_or_over_rate",  KeyField:0,   CalcLogic:"",   Format:"", PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"AutoSum",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_today_15",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"Text",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_today_15_rate",   KeyField:0,   CalcLogic:"",   Format:"", PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"AutoSum",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_16_30",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"Text",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_16_30_rate",      KeyField:0,   CalcLogic:"",   Format:"", PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"AutoSum",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_31_50",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"Text",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_31_50_rate",      KeyField:0,   CalcLogic:"",   Format:"", PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"AutoSum",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_51_100",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"Text",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_51_100_rate",     KeyField:0,   CalcLogic:"",   Format:"", PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"AutoSum",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_101_180",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"Text",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_101_180_rate",    KeyField:0,   CalcLogic:"",   Format:"", PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"AutoSum",   Hidden:0, Width:58,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_181_over",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
              {Type:"Text",   Hidden:0, Width:73,   Align:"Right",   ColMerge:0,   SaveName:"chss_mvmt_dt_181_over_rate",   KeyField:0,   CalcLogic:"",   Format:"", PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
           
          	InitColumns(cols);
//          	SetSheetHeight(390);
          	SetEditable(1);
          	SetEditableColorDiff(0);
          	resizeSheet();
                   }


             break;
         case "sheet2": // t1sheet1 init
             with(sheetObj){
			       var HeadTitle="|n1st_inq_fm_dys|n1st_inq_to_dys|n2nd_inq_fm_dys|n2nd_inq_to_dys|n3rd_inq_fm_dys|n3rd_inq_to_dys|n4th_inq_fm_dys|n4th_inq_to_dys|n5th_inq_fm_dys|n5th_inq_to_dys";
			       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			       var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			       var headers = [ { Text:HeadTitle, Align:"Center"} ];
			       InitHeaders(headers, info);
			       var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n1st_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n2nd_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3rd_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3rd_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n4th_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n4th_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n5th_inq_fm_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n5th_inq_to_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			        
			       InitColumns(cols);
			       SetEditable(1);
			       SetSheetHeight(80);
                 }
         	break;                 
     }
 }
/**
 * handling process for Sheet <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type
 * @return 
 * @author 
 * @version
 */
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
       case IBSEARCH:      //retrieve
        // Form Object value setting
    	formObj.f_cmd.value=SEARCH;
 		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
 		if(formObj.include_np.checked){
 			formObj.include_np.value="Y";
 		} else {
 			formObj.include_np.value="";
 		}
 		if(formObj.include_status_lst.checked){
 			formObj.include_status_lst.value="Y";
 		} else {
 			formObj.include_status_lst.value="";
 		}
 		if(formObj.include_out_gated.checked){
 			formObj.include_out_gated.value="Y";
 		} else {
 			formObj.include_out_gated.value="";
 		}
 		
 		if(!ComIsEmpty(combo_location.GetSelectCode())) {
 			formObj.location.value = combo_location.GetSelectCode();
 		}
 		
 		/* 
 		//attached / bare
    	if(formObj.rdo_atch_bare[0].checked)
    	{
    		formObj.atch_bare.value=formObj.rdo_atch_bare[0].value;
    	}else
    	{
    		formObj.atch_bare.value=formObj.rdo_atch_bare[1].value;
    	}
    	//damage / sound
    	if(formObj.rdo_dmg_snd[0].checked)
    	{
    		formObj.dmg_snd.value=formObj.rdo_dmg_snd[0].value;
    	}else
    	{
    		formObj.dmg_snd.value=formObj.rdo_dmg_snd[1].value;
    	}
    	*/
 		// retrieve
 		if(validateForm(sheetObj,formObj,sAction))
 		{
	 		sheetObj.SetWaitImageVisible(0);
	 		ComOpenWait(true);
  			var sXml=sheetObj.GetSearchData("EES_CGM_1092GS.do" , FormQueryString(formObj));
 			var strStayingDays=formObj.staying_days.value + " or Over";
 			sheetObj.SetCellValue(0,4,strStayingDays);
 			sheetObj.SetCellValue(0,5,strStayingDays);
 			sheetObj.SetCellValue(1,4,strStayingDays);
 			sheetObj.SetCellValue(1,5,strStayingDays);
 			sheetObj.LoadSearchData(sXml,{Sync:0} );
	 		ComOpenWait(false);
 		}
        break;
       case IBSEARCH_ASYNC01:	// Location Combo retrieve
   		formObj.f_cmd.value=SEARCH;
   		formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting (Location)
    		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
   		var sStr=ComGetEtcData(sXml,"comboList");    			
   		var arrStr=sStr.split("@");
   		// combo control, result string, Text Index, Code Index
   		makeComboObject(combo_location, arrStr, 1, 1, 0);
   		break;
       case IBSEARCH_ASYNC02:	// Yard  Validation check 
	   	formObj.f_cmd.value=COMMAND01;
	   	formObj.yd_cd.value=formObj.crnt_yd_cd.value;
 	   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
	   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
	   	if(sCheckResult == COM_VALIDATION_FALSE){
	   		ComShowCodeMessage('CGM10009','Yard');
	   		formObj.crnt_yd_cd.value="";
////	   		formObj.crnt_yd_cd.focus();
	   	}
	   	break;       		
       case IBSEARCH_ASYNC03:	// CP Combo retrieve
		formObj.f_cmd.value=SEARCH02;
        	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
       	ss=ComCgmXml2ComboString(sXml, "TOTAL");
       	var cols=ComCgmXml2ComboString(sXml, "code1", "desc1");
       	//IBSHEET GRID outer combo
       	makeCPMultiCombo(chss_pool_cd, cols, 0, 0);
       	break;
    	case IBSEARCH_ASYNC04:	// Type Size Combo retrieve
    		formObj.f_cmd.value=SEARCH04;
    		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
 			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"comboList");
			var arrStr=sStr.split("@");
	  		makeComboObject(eq_tpsz_cd, arrStr, 0, 0, 0);
	  		//comboObjects[6].DeleteItem(1);
	       	break;  
    	case IBSEARCH_ASYNC05:	// Term Code Combo retrieve
	       	formObj.f_cmd.value=SEARCH;
	       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
 	   		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	   		var sStr=ComGetEtcData(sXml,"comboList");    			
	   		var arrStr=sStr.split("@");
	  		makeComboObject(agmt_lstm_cd, arrStr, 0, 0, 0);
 	  		comboObjects[5].DeleteItem(0);
	       	break;
    	case IBSEARCH_ASYNC06:	// Movement Status Combo retrieve
        	formObj.f_cmd.value=SEARCH13;
 			var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
			var cols=ComCgmXml2ComboString(sXml, "code1", "code1");
     	  	ComCgmMakeMultiCombo(chss_mvmt_sts_cd, cols[0], cols[1], 0);
     	  	break;
    	case IBSEARCH_ASYNC07:
    		sheetObj.RemoveAll();
    		formObj.f_cmd.value=SEARCH01;
  			var sXml=sheetObj.GetSearchData("EES_CGM_1092GS.do" , FormQueryString(formObj));
 			sheetObj.LoadSearchData(sXml,{Sync:1} );
 			break;
    	case IBSEARCH_ASYNC08:
	       	//formObj.f_cmd.value = SEARCH;
	       	//formObj.loc_cd.value = formObj.crnt_loc_cd.value;		//   ( location)
	   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
	    	formObj.f_cmd.value=SEARCH17;
	    	var location=document.form.combo_location_text.value;
	    	if(location == "RCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="RCC";
	    		formObj.eq_orz_cht_rcc_cd.value=formObj.crnt_loc_cd.value;
	    	}else if(location == "LCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="LCC";
	    		formObj.eq_orz_cht_lcc_cd.value=formObj.crnt_loc_cd.value;
	    	}else if(location == "SCC")
	    	{
	    		formObj.eq_orz_cht_chktype.value="SCC";
	    		formObj.eq_orz_cht_scc_cd.value=formObj.crnt_loc_cd.value;
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
		   		formObj.crnt_loc_cd.value="";
		   		formObj.crnt_loc_cd.focus(); 
	        }
	        
	   		break;
    	case IBDOWNEXCEL:        //down excel
    		if(sheetObj.RowCount() < 1){//no data
    			ComShowCodeMessage("COM132501");
    		}else{
    			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
    		}
            break;
    	case IBRESET:
    	  	var idx=0
    		var sXml2=document.form2.sXml.value;
    		var arrXml=sXml2.split("|$$|");
    		//Location
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr1=new Array();
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
    		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
    		}
    		// combo control, result string, Text Index, Code Index
	  		makeComboObject(combo_location, arrStr1, 1, 1, 0);       
    		idx++;        		
	  		//Co-Op Pool
    		if ( arrXml[idx] == null ) {return;}
    		var cols1=ComCgmXml2ComboString(arrXml[idx], "code1", "desc1");
    		//IBSHEET GRID outer combo
    		makeCPMultiCombo(chss_pool_cd, cols1, 0, 0);
    		idx++;
    		//Type/Size
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr2=new Array();
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
    		    arrStr2[i]=vListData["code1"] + "|" + vListData["desc1"];
    		}
    		makeComboObject(eq_tpsz_cd, arrStr2, 0, 0, 0);
	  		idx++;
    		//Lease Term
    		if ( arrXml[idx] == null ) {return;}
    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	    var arrStr3=new Array();
    		for ( var i=0; i < vArrayListData.length; i++) {
    		    vListData=vArrayListData[i];
    		    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
    		}
	  		makeComboObject(agmt_lstm_cd, arrStr3, 0, 0, 0);
 	  		comboObjects[5].DeleteItem(comboObjects[5].FindItem("NP", 0, 1));
	  		idx++;
	  		//MVMT Status
    		if ( arrXml[idx] == null ) {return;}
			var cols2=ComCgmXml2ComboString(arrXml[idx], "code1", "code1");
     	  	ComCgmMakeMultiCombo(chss_mvmt_sts_cd, cols2[0], cols2[1], 0);
     	  	idx++;
     	  	//LongstayEnv header value setting
    		sheetObjects[1].RemoveAll();
    		if ( arrXml[idx] == null ) {return;}
 			sheetObjects[1].LoadSearchData(arrXml[idx],{Sync:1} );
 			idx++;
    		break;            
     }
 }
/**
 * handling process for input validation <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation check error, true => validation check succes
 * @author 
 * @version
 */ 
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
			case IBSEARCH:
				if(crnt_loc_cd.value == ''){
					ComShowCodeMessage('CGM10004','Location');
////					crnt_loc_cd.focus();
					return false;
				} else {
					if(crnt_loc_cd.value.length != 5) 
					{
						ComShowCodeMessage('CGM10044','Location(5)');
////						crnt_loc_cd.focus();
						return false;
    				}else
    				{
					return true;
    				}
    			}
				break;
		}
		return true;
	}
}
/**
 * call back function. <br>
 * @param  {Array} aryPopupData	mandatory	 Array Object
 * @param  {Int} row				mandatoryselectedRow
 * @param  {Int} col				mandatoryselectedColumn
 * @param  {Int} sheetIdx			mandatory Sheet Index
 * @return 
 * @author 
 * @version
 */   
function callBackLocation(aryPopupData, row, col, sheetIdx){
    var formObj=document.form;
    var location=formObj.combo_location_text.value;
    var crntLocCd="";
    var i=0;
    for(i=0; i < aryPopupData.length; i++){
    	if(location == 'RCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][11];
    	} else if(location == 'LCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][10];
    	} else if(location == 'SCC'){
    		crntLocCd=crntLocCd + aryPopupData[i][8];
    	}
    	if(i < aryPopupData.length - 1){
    		crntLocCd=crntLocCd + ",";
     	}
    }
    formObj.crnt_loc_cd.value=crntLocCd;
}	 
/**
 * call back function. <br>
 * @param  {Array} aryPopupData	mandatory	 Array Object
 * @param  {Int} row				mandatoryselectedRow
 * @param  {Int} col				mandatoryselectedColumn
 * @param  {Int} sheetIdx			mandatory Sheet Index
 * @return 
 * @author 
 * @version
 */   
function callBackYard(aryPopupData, row, col, sheetIdx){
    var formObj=document.form;
    var crntYdCd="";
    var i=0;
    for(i=0; i < aryPopupData.length; i++){
    	crntYdCd=crntYdCd + aryPopupData[i][3];
    	if(i < aryPopupData.length - 1){
    		crntYdCd=crntYdCd + ",";
     	}
    }
    formObj.crnt_yd_cd.value=crntYdCd;
}
function callBackVendor(aryPopupData, row, col, sheetIdx){
   	var formObj=document.form;
    var vndrSeq="";
    var i=0;
    for(i=0; i < aryPopupData.length; i++){
    	vndrSeq=vndrSeq + aryPopupData[i][2];
    	if(i < aryPopupData.length - 1){
    		vndrSeq=vndrSeq + ",";
    	}
    }
    formObj.vndr_seq.value=vndrSeq;
}	
 /**
  * call back function. <br>
  * Total display 
  * @param  {Object} sheetObj		mandatory	 SheetObj
  * @param  {Int} row				mandatoryselectedRow
  * @return 
  * @author 
  * @version
  */ 
 function sheet1_OnChangeSum(sheetObj, Row)
 {
	with(sheetObj)
 	{
  		SetSumText(0, "Seq","");
  		SetSumText(0, "group1","Total/%");
 		//SumText(0, "TPSZ") = "Grand Total";
 		SetCellAlign(Row, "group1","Center");
 	}
 }
/**
 * Sheet1  OnSearchEnd event handling <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {string} ErrMsg		 String
 * @return 
 * @version
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
	with(sheetObj)
	{
		if(RowCount()!=0)
		{
			var sum1 = 0.00;
			var sum2 = 0.00;
			var sum3 = 0.00;
			var sum4 = 0.00;
			var sum5 = 0.00;
			var sum6 = 0.00;
			var sum7 = 0.00;
			
			var rowCnt1 = 0;
			var rowCnt2 = 0;
			var rowCnt3 = 0;
			var rowCnt4 = 0;
			var rowCnt5 = 0;
			var rowCnt6 = 0;
			var rowCnt7 = 0;
			
			for(var i = HeaderRows(); i < RowCount() + HeaderRows(); i++){
				sum1 = sum1 + parseFloat(GetCellValue(i,"chss_mvmt_dt_0_or_over_rate"));
				sum2 = sum2 + parseFloat(GetCellValue(i,"chss_mvmt_dt_today_15_rate"));
				sum3 = sum3 + parseFloat(GetCellValue(i,"chss_mvmt_dt_16_30_rate"));
				sum4 = sum4 + parseFloat(GetCellValue(i,"chss_mvmt_dt_31_50_rate"));
				sum5 = sum5 + parseFloat(GetCellValue(i,"chss_mvmt_dt_51_100_rate"));
				sum6 = sum6 + parseFloat(GetCellValue(i,"chss_mvmt_dt_101_180_rate"));
				sum7 = sum7 + parseFloat(GetCellValue(i,"chss_mvmt_dt_181_over_rate"));
				
				if(GetCellValue(i,"chss_mvmt_dt_0_or_over_rate") != "0.00"){
					rowCnt1++;
				}
				if(GetCellValue(i,"chss_mvmt_dt_today_15_rate") != "0.00"){
					rowCnt2++;
				}
				if(GetCellValue(i,"chss_mvmt_dt_16_30_rate") != "0.00"){
					rowCnt3++;
				}
				if(GetCellValue(i,"chss_mvmt_dt_31_50_rate") != "0.00"){
					rowCnt4++;
				}
				if(GetCellValue(i,"chss_mvmt_dt_51_100_rate") != "0.00"){
					rowCnt5++;
				}
				if(GetCellValue(i,"chss_mvmt_dt_101_180_rate") != "0.00"){
					rowCnt6++;
				}
				if(GetCellValue(i,"chss_mvmt_dt_181_over_rate") != "0.00"){
					rowCnt7++;
				}
				
				SetCellValue(i, "chss_mvmt_dt_0_or_over_rate",GetCellValue(i,"chss_mvmt_dt_0_or_over_rate") + "%" );
				SetCellValue(i, "chss_mvmt_dt_today_15_rate",GetCellValue(i,"chss_mvmt_dt_today_15_rate") + "%" );
				SetCellValue(i, "chss_mvmt_dt_16_30_rate",GetCellValue(i,"chss_mvmt_dt_16_30_rate") + "%" );
				SetCellValue(i, "chss_mvmt_dt_31_50_rate",GetCellValue(i,"chss_mvmt_dt_31_50_rate") + "%" );
				SetCellValue(i, "chss_mvmt_dt_51_100_rate",GetCellValue(i,"chss_mvmt_dt_51_100_rate") + "%" );
				SetCellValue(i, "chss_mvmt_dt_101_180_rate",GetCellValue(i,"chss_mvmt_dt_101_180_rate") + "%" );
	  			SetCellValue(i, "chss_mvmt_dt_181_over_rate",GetCellValue(i,"chss_mvmt_dt_181_over_rate") + "%" );
	  			
			}
			
			if(rowCnt1 != 0){
				SetSumValue("chss_mvmt_dt_0_or_over_rate", CgmMakeRound(sum1/rowCnt1, 2) + "%");
			}else{
				SetSumValue("chss_mvmt_dt_0_or_over_rate", "0.00%");
			}
			
			if(rowCnt2 != 0){
				SetSumValue("chss_mvmt_dt_today_15_rate", CgmMakeRound(sum2/rowCnt2, 2) + "%");
			}else{
				SetSumValue("chss_mvmt_dt_today_15_rate", "0.00%");
			}
			
			if(rowCnt3 != 0){
				SetSumValue("chss_mvmt_dt_16_30_rate", CgmMakeRound(sum3/rowCnt3, 2) + "%");
			}else{
				SetSumValue("chss_mvmt_dt_16_30_rate", "0.00%");
			}
			
			if(rowCnt4 != 0){
				SetSumValue("chss_mvmt_dt_31_50_rate", CgmMakeRound(sum4/rowCnt4, 2) + "%");
			}else{
				SetSumValue("chss_mvmt_dt_31_50_rate", "0.00%");
			}
			
			if(rowCnt5 != 0){
				SetSumValue("chss_mvmt_dt_51_100_rate", CgmMakeRound(sum5/rowCnt5, 2) + "%");
			}else{
				SetSumValue("chss_mvmt_dt_51_100_rate", "0.00%");
			}
			
			if(rowCnt6 != 0){
				SetSumValue("chss_mvmt_dt_101_180_rate", CgmMakeRound(sum6/rowCnt6, 2) + "%");
			}else{
				SetSumValue("chss_mvmt_dt_101_180_rate", "0.00%");
			}
			
			if(rowCnt7 != 0){
				SetSumValue("chss_mvmt_dt_181_over_rate", CgmMakeRound(sum7/rowCnt7, 2) + "%");
			}else{
				SetSumValue("chss_mvmt_dt_181_over_rate", "0.00%");
			}
//  			
//  			SetSumValue("chss_mvmt_dt_today_15_rate",CgmMakeRound(sum2/RowCount(), 2) + "%" );
//  			SetSumValue("chss_mvmt_dt_16_30_rate",CgmMakeRound(sum3/RowCount(), 2) + "%" );
//  			SetSumValue("chss_mvmt_dt_31_50_rate",CgmMakeRound(sum4/RowCount(), 2) + "%" );
//  			SetSumValue("chss_mvmt_dt_51_100_rate",CgmMakeRound(sum5/RowCount(), 2) + "%" );
//  			SetSumValue("chss_mvmt_dt_101_180_rate",CgmMakeRound(sum6/RowCount(), 2) + "%" );
//  			SetSumValue("chss_mvmt_dt_181_over_rate",CgmMakeRound(sum7/RowCount(), 2) + "%" );
		}
		else
		{
			SetSumValue("chss_mvmt_dt_0_or_over_rate","0%");
			SetSumValue("chss_mvmt_dt_today_15_rate","0%");
			SetSumValue("chss_mvmt_dt_16_30_rate","0%");
 			SetSumValue("chss_mvmt_dt_31_50_rate","0%");
 			SetSumValue("chss_mvmt_dt_51_100_rate","0%");
 			SetSumValue("chss_mvmt_dt_101_180_rate","0%");
 			SetSumValue("chss_mvmt_dt_181_over_rate","0%");
		}
		
		SetSumText(0, "Seq","");
		SetSumText(0, "group1","Total/%");
		SetCellAlign(0, "group1","Center");
	}
}
 /**
  * Sheet2 OnSearchEnd event handling <br>
  * @param  {object} sheetObj		 Sheet Object
  * @param  {string} ErrMsg		 String
  * @return 
  * @version 
  */ 
 function sheet2_OnSearchEnd(sheetObj, ErrMsg)
 {
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];    	
    var formObj=document.form;
 	with(sheetObj)
 	{
 		//var HeadTitle1 = "|Seq.|Type/Size|Total|0 or Over|0 or Over|Today-15|Today-15|16-30|16-30|31-50|31-50|51-100|51-100|101-180|101-180|181 or Over|181 or Over";
        //var HeadTitle2 = "|Seq.|Type/Size|Total|13Oct08 or over|13Oct08 or over|13Oct08-28Sep08|13Oct08-28Sep08|27Sep08-13Sep08|27Sep08-13Sep08|12Sep08-24Aug08|12Sep08-24Aug08|23Aug08-05Jul08|23Aug08-05Jul08|04Jul08-16Apr08|04Jul08-16Apr08|15Apr08 or over|15Apr08 or over";
 		if(RowCount()=='0')
 		{
 			DataInsert(-1);
 			SetCellValue(1,"n1st_inq_fm_dys","0");
 			SetCellValue(1,"n1st_inq_to_dys","15");
 			SetCellValue(1,"n2nd_inq_fm_dys","16");
 			SetCellValue(1,"n2nd_inq_to_dys","30");
 			SetCellValue(1,"n3rd_inq_fm_dys","31");
 			SetCellValue(1,"n3rd_inq_to_dys","50");
 			SetCellValue(1,"n4th_inq_fm_dys","51");
 			SetCellValue(1,"n4th_inq_to_dys","100");
 			SetCellValue(1,"n5th_inq_fm_dys","101");
 			SetCellValue(1,"n5th_inq_to_dys","180");
 			SetRowStatus(1,"R");
 		}
 		// header 0
		//sheetObject1.cellValue2(0,4) = "0 or Over";
 		//sheetObject1.cellValue2(0,5) = "0 or Over";
 		sheetObject1.SetCellValue(0,6,GetCellValue(1,"n1st_inq_fm_dys") + "-" + GetCellValue(1,"n1st_inq_to_dys"));
 		sheetObject1.SetCellValue(0,7,GetCellValue(1,"n1st_inq_fm_dys") + "-" + GetCellValue(1,"n1st_inq_to_dys"));
 		sheetObject1.SetCellValue(0,8,GetCellValue(1,"n2nd_inq_fm_dys") + "-" + GetCellValue(1,"n2nd_inq_to_dys"));
 		sheetObject1.SetCellValue(0,9,GetCellValue(1,"n2nd_inq_fm_dys") + "-" + GetCellValue(1,"n2nd_inq_to_dys"));
 		sheetObject1.SetCellValue(0,10,GetCellValue(1,"n3rd_inq_fm_dys") + "-" + GetCellValue(1,"n3rd_inq_to_dys"));
 		sheetObject1.SetCellValue(0,11,GetCellValue(1,"n3rd_inq_fm_dys") + "-" + GetCellValue(1,"n3rd_inq_to_dys"));
 		sheetObject1.SetCellValue(0,12,GetCellValue(1,"n4th_inq_fm_dys") + "-" + GetCellValue(1,"n4th_inq_to_dys"));
 		sheetObject1.SetCellValue(0,13,GetCellValue(1,"n4th_inq_fm_dys") + "-" + GetCellValue(1,"n4th_inq_to_dys"));
 		sheetObject1.SetCellValue(0,14,GetCellValue(1,"n5th_inq_fm_dys") + "-" + GetCellValue(1,"n5th_inq_to_dys"));
 		sheetObject1.SetCellValue(0,15,GetCellValue(1,"n5th_inq_fm_dys") + "-" + GetCellValue(1,"n5th_inq_to_dys"));
 		var tStr=parseInt(GetCellValue(1,"n5th_inq_to_dys"))+1;
 		sheetObject1.SetCellValue(0,16,tStr + " or Over");
 		sheetObject1.SetCellValue(0,17,tStr + " or Over");
     		// header 1
    	var sysDate=new Date();
    	var year=sysDate.getFullYear();
    	var month=sysDate.getMonth()+1;
    	var date=sysDate.getDate();
    	var today=ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0") + "-" + ComLpad(date, 2, "0");
    	var monthNames=new Array();
    	monthNames[0]="Jan";
    	monthNames[1]="Feb";
    	monthNames[2]="Mar";
    	monthNames[3]="Apr";
    	monthNames[4]="May";
    	monthNames[5]="Jun";
    	monthNames[6]="Jul";
    	monthNames[7]="Aug";
    	monthNames[8]="Sep";
    	monthNames[9]="Oct";
    	monthNames[10]="Nov";
    	monthNames[11]="Dec";
    	var tmp_1=new Date();
    	var tmp_2=new Date();
    	var tmp_3=new Date();
    	var tmp_4=new Date();
    	var tmp_5=new Date();
    	var tmp_6=new Date();
    	var tmp_7=new Date();
    	var tmp_8=new Date();
    	var tmp_9=new Date();
    	var tmp_10=new Date();
    	var tmp_11=new Date();
    	var tmp2;
    	tmp_1.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n1st_inq_fm_dys")) )
        year=tmp_1.getFullYear();
        month=tmp_1.getMonth();
        date=tmp_1.getDate();
        tmp2=new String(year);
        var d_n1st_inq_to_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        tmp_2.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n1st_inq_to_dys")) )
        year=tmp_2.getFullYear();
        month=tmp_2.getMonth();
        date=tmp_2.getDate();
        tmp2=new String(year);
        var d_n1st_inq_fm_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        var tmp_2=new Date();
        tmp_3.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n2nd_inq_fm_dys")) )
        year=tmp_3.getFullYear();
        month=tmp_3.getMonth();
        date=tmp_3.getDate();
        tmp2=new String(year);
        var d_n2nd_inq_to_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        tmp_4.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n2nd_inq_to_dys")) )
        year=tmp_4.getFullYear();
        month=tmp_4.getMonth();
        date=tmp_4.getDate();
        tmp2=new String(year);
        var d_n2nd_inq_fm_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        tmp_5.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n3rd_inq_fm_dys")) )
        year=tmp_5.getFullYear();
        month=tmp_5.getMonth();
        date=tmp_5.getDate();
        tmp2=new String(year);
        var d_n3rd_inq_to_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        tmp_6.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n3rd_inq_to_dys")) )
        year=tmp_6.getFullYear();
        month=tmp_6.getMonth();
        date=tmp_6.getDate();
        tmp2=new String(year);
        var d_n3rd_inq_fm_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        tmp_7.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n4th_inq_fm_dys")) )
        year=tmp_7.getFullYear();
        month=tmp_7.getMonth();
        date=tmp_7.getDate();
        tmp2=new String(year);
        var d_n4th_inq_to_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        tmp_8.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n4th_inq_to_dys")) )
        year=tmp_8.getFullYear();
        month=tmp_8.getMonth();
        date=tmp_8.getDate();
        tmp2=new String(year);
        var d_n4th_inq_fm_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        tmp_9.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n5th_inq_fm_dys")) )
        year=tmp_9.getFullYear();
        month=tmp_9.getMonth();
        date=tmp_9.getDate();
        tmp2=new String(year);
        var d_n5th_inq_to_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
        tmp_10.setDate(sysDate.getDate()- parseInt(GetCellValue(1,"n5th_inq_to_dys")) )
        year=tmp_10.getFullYear();
        month=tmp_10.getMonth();
        date=tmp_10.getDate();
        tmp2=new String(year);
        var d_n5th_inq_fm_dys=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
		sheetObject1.SetCellValue(1,4,"0 or Over");
 		sheetObject1.SetCellValue(1,5,"0 or Over");
 		sheetObject1.SetCellValue(1,6,d_n1st_inq_fm_dys + "-" + d_n1st_inq_to_dys);
 		sheetObject1.SetCellValue(1,7,d_n1st_inq_fm_dys + "-" + d_n1st_inq_to_dys);
 		sheetObject1.SetCellValue(1,8,d_n2nd_inq_fm_dys + "-" + d_n2nd_inq_to_dys);
 		sheetObject1.SetCellValue(1,9,d_n2nd_inq_fm_dys + "-" + d_n2nd_inq_to_dys);
 		sheetObject1.SetCellValue(1,10,d_n3rd_inq_fm_dys + "-" + d_n3rd_inq_to_dys);
 		sheetObject1.SetCellValue(1,11,d_n3rd_inq_fm_dys + "-" + d_n3rd_inq_to_dys);
 		sheetObject1.SetCellValue(1,12,d_n4th_inq_fm_dys + "-" + d_n4th_inq_to_dys);
 		sheetObject1.SetCellValue(1,13,d_n4th_inq_fm_dys + "-" + d_n4th_inq_to_dys);
 		sheetObject1.SetCellValue(1,14,d_n5th_inq_fm_dys + "-" + d_n5th_inq_to_dys);
 		sheetObject1.SetCellValue(1,15,d_n5th_inq_fm_dys + "-" + d_n5th_inq_to_dys);
 		tmp_11.setDate(sysDate.getDate() - parseInt(GetCellValue(1,"n5th_inq_to_dys")) - 1 )
        year=tmp_11.getFullYear();
        month=tmp_11.getMonth();
        date=tmp_11.getDate();
        tmp2=new String(year);
        var tStr2=ComLpad(date, 2, "0") +monthNames[month]+ tmp2.substring(2,4) ;
 		sheetObject1.SetCellValue(1,16,tStr2 + " or Over");
 		sheetObject1.SetCellValue(1,17,tStr2 + " or Over");
 		//폼에 inserting
 		document.form.n1st_inq_fm_dys.value=GetCellValue(1,"n1st_inq_fm_dys"); 
 		document.form.n1st_inq_to_dys.value=GetCellValue(1,"n1st_inq_to_dys");
 		document.form.n2nd_inq_fm_dys.value=GetCellValue(1,"n2nd_inq_fm_dys"); 
 		document.form.n2nd_inq_to_dys.value=GetCellValue(1,"n2nd_inq_to_dys"); 
 		document.form.n3rd_inq_fm_dys.value=GetCellValue(1,"n3rd_inq_fm_dys"); 
 		document.form.n3rd_inq_to_dys.value=GetCellValue(1,"n3rd_inq_to_dys");
 		document.form.n4th_inq_fm_dys.value=GetCellValue(1,"n4th_inq_fm_dys");
 		document.form.n4th_inq_to_dys.value=GetCellValue(1,"n4th_inq_to_dys");
 		document.form.n5th_inq_fm_dys.value=GetCellValue(1,"n5th_inq_fm_dys"); 
 		document.form.n5th_inq_to_dys.value=GetCellValue(1,"n5th_inq_to_dys");
 	}
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
  	 if(sheetObj.rowcount + 2 == sheetObj.mouseRow)
  	 {
  		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
  		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "group1");
  		 //alert(groupValue1);
  		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
  	 }
   }
  function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
  	var eqKndCd=EQ_KND_CD_CHASSIS;
  	var location=comboObjects[0].GetSelectCode();
  	
  	var crntLocCd=document.form.crnt_loc_cd.value;
  	var crntYdCd=document.form.crnt_yd_cd.value;
  	var aciacDivCd=comboObjects[1].GetSelectCode();
  	var chssPoolCd=comboObjects[2].GetSelectCode();
  	var includeNp="";
  	if(document.form.include_np.checked){
  		includeNp="Y";
  	}
  	var include_status_lst="";
	if(document.form.include_status_lst.checked){
		include_status_lst="Y";
	}
	var include_out_gated="";
	if(document.form.include_out_gated.checked){
		include_out_gated="Y";
	}
  	var stayingDays=document.form.staying_days.value;
  	var group1=comboObjects[3].GetSelectCode();
  	var groupValue1=sheetObj.GetCellValue(Row, "group1");
  	var s_group1="";
  	var s_group1_val="";
  	var s2_group1="";
  	var s2_group1_val="";
  	var s3_gtotal="";
  	if(groupValue1.substring(0,9) == "Sub Total")
  	{
  	}else if(groupValue1 == "Total/%"){
  		s3_gtotal="GTOTAL";
  	}else{
  		s2_group1="";
  		s2_group1_val="";
  	}
  	var agmtLstmCd=comboObjects[5].GetSelectText();
  	var vndrSeq=document.form.vndr_seq.value;
  	var chssMvmtStsCd=comboObjects[6].GetSelectText();
  	var eqTpszCd=comboObjects[4].GetSelectText();
  	var colSaveName=sheetObj.ColSaveName(Col);
 	var inqFmDys='';
 	var inqToDys='';
 	if(parseInt(Col) == 3) // total
 	{
 	}else if(parseInt(Col) == 4 || parseInt(Col) == 5) // 0 or over
 	{
 		s_group1="TotalColumn";
 		s_group1_val="";
 	}else if(parseInt(Col) == 6 || parseInt(Col) == 7) // 0 - 15
 	{
 		inqFmDys=document.form.n1st_inq_fm_dys.value;
 		inqToDys=document.form.n1st_inq_to_dys.value;
 	}else if(parseInt(Col) == 8 || parseInt(Col) == 9) // 16 - 30
 	{
 		inqFmDys=document.form.n2nd_inq_fm_dys.value;
 		inqToDys=document.form.n2nd_inq_to_dys.value;
 	}else if(parseInt(Col) == 10 || parseInt(Col) == 11) // 31 - 50
 	{
 		inqFmDys=document.form.n3rd_inq_fm_dys.value;
 		inqToDys=document.form.n3rd_inq_to_dys.value;
 	}else if(parseInt(Col) == 12 || parseInt(Col) == 13) // 51 - 100
 	{
 		inqFmDys=document.form.n4th_inq_fm_dys.value;
 		inqToDys=document.form.n4th_inq_to_dys.value;
 	}else if(parseInt(Col) == 14 || parseInt(Col) == 15) // 101 - 180
 	{
 		inqFmDys=document.form.n5th_inq_fm_dys.value;
 		inqToDys=document.form.n5th_inq_to_dys.value;
 	}else if(parseInt(Col) == 16 || parseInt(Col) == 17) // 181 or Over
 	{
 		inqFmDys=parseInt(document.form.n5th_inq_to_dys.value)+1;
 		inqToDys=''   		
 	}
	//attached / bare
 	var sAtchBare=atch_bare.GetSelectCode();
	/* 
	var atch_bare="";
	if(document.form.rdo_atch_bare[0].checked)
	{
		atch_bare=document.form.rdo_atch_bare[0].value;
	}else
	{
		atch_bare=document.form.rdo_atch_bare[1].value;
	}*/
	//damage / sound
	var sDmgSnd=dmg_snd.GetSelectCode();
	/* 
	var dmg_snd="";
	if(document.form.rdo_dmg_snd[0].checked)
	{
		dmg_snd=document.form.rdo_dmg_snd[0].value;
	}else
	{
		dmg_snd=document.form.rdo_dmg_snd[1].value;
	}*/
  	var param="?program_id=1092";
  	param=param + "&inq_fm_dys=" + inqFmDys;
  	param=param + "&inq_to_dys=" + inqToDys;       	
  	param=param + "&eq_knd_cd=" + eqKndCd;
  	param=param + "&location=" + location;
  	param=param + "&crnt_loc_cd=" + crntLocCd;
  	param=param + "&crnt_yd_cd=" + crntYdCd;
  	param=param + "&aciac_div_cd=" + aciacDivCd;
  	param=param + "&chss_pool_cd=" + chssPoolCd;
  	param=param + "&include_np=" + includeNp;
  	param=param + "&include_status_lst=" + include_status_lst;
  	param=param + "&include_out_gated=" + include_out_gated;
  	param=param + "&staying_days=" + stayingDays;
  	param=param + "&eq_tpsz_cd=" + eqTpszCd;
  	param=param + "&group1=" + group1;
  	param=param + "&group_value1=" + groupValue1;
  	param=param + "&agmt_lstm_cd=" + agmtLstmCd;
  	param=param + "&vndr_seq=" + vndrSeq;
  	param=param + "&chss_mvmt_sts_cd=" + chssMvmtStsCd;
  	param=param + "&s_group1=" + s_group1;
  	param=param + "&s_group1_val=" + s_group1_val;
  	param=param + "&s2_group1=" + s2_group1;
  	param=param + "&s2_group1_val=" + s2_group1_val;
  	param=param + "&s3_gtotal=" + s3_gtotal;
  	param=param + "&atch_bare=" + sAtchBare;
  	param=param + "&dmg_snd=" + sDmgSnd;
  	//var seq = sheetObj.cellValue(Row, "Seq");
  	if(Col >= 3) // && seq != '')
  	{
    	ComOpenPopup('/opuscntr/EES_CGM_1091.do' + param, 900, 550, "", "1,0", true, false);
    }else
    {
    	ComShowCodeMessage('CGM10016');
    }
  }      
/**
 * Location Multi-Combo OnChange event handling <br>
 * @param  {object} ComboObj	mandatory	 Sheet Object
 * @param  {int} 	Index_Code	mandatory
 * @param  {string} Text		mandatory
 * @return 
 * @version
 */ 
function combo_location_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){
	document.form.crnt_loc_cd.value="";
  	/*arrGroup[1]="2|LCC[Loc]";
  	arrGroup[2]="3|Office";
  	arrGroup[3]="4|SCC[Loc]";
  	arrGroup[4]="5|Yard";
  	*/
	if(newcode == "RCC")
	{
		group1.SetSelectCode("2");//LCC
	}else if(newcode == "LCC")
	{
		group1.SetSelectCode("4");//SCC
	}else if(newcode == "SCC")	
	{
		group1.SetSelectCode("5");//Yard
	}
//	document.form.combo_location_text.value = newcode;
}

function combo_location_OnBlur() {
//	document.form.combo_location_text.value = combo_location.GetSelectCode();
}
//function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.combo_location_text.value = combo_location.GetText(parseInt(combo_location.GetSelectIndex()), 0);
//}
function chss_pool_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.chss_pool_cd_text.value = chss_pool_cd.GetText(parseInt(chss_pool_cd.GetSelectIndex(newIndex)), 0);
}

function aciac_div_cd_OnBlur() {
//	document.form.aciac_div_cd_text.value = aciac_div_cd.GetText(parseInt(aciac_div_cd.GetSelectIndex()), 0);
}

function combo_location_OnBlur() {
// document.form.chss_pool_cd_text.value = chss_pool_cd.GetText(parseInt(chss_pool_cd.GetSelectIndex()), 0);
}



function aciac_div_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.aciac_div_cd_text.value = aciac_div_cd.GetText(parseInt(aciac_div_cd.GetSelectIndex()), 0);
	var formObj=document.form;
	  if(aciac_div_cd.GetSelectText()!= "Active")
	  {
		  form.include_status_lst.disabled=false;
	  }
	  else
	  {
		  form.include_status_lst.checked=false;
		  form.include_status_lst.disabled=true;
	  }
}

function group1_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.group1_text.value = group1.GetText(parseInt(group1.GetSelectIndex()), 0);
}
function eq_tpsz_cd_OnBlur() {
//	document.form.eq_tpsz_cd_text.value = eq_tpsz_cd.GetSelectCode();
}
function eq_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.eq_tpsz_cd_text.value = newCode;
}

function agmt_lstm_cd_OnBlur() {
//	document.form.agmt_lstm_cd_text.value = agmt_lstm_cd.GetSelectCode();
}
function agmt_lstm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.agmt_lstm_cd_text.value = newCode;
}

function chss_mvmt_sts_cd_OnBlur() {
//	document.form.chss_mvmt_sts_cd_text.value  = chss_mvmt_sts_cd.GetSelectCode();
}
function chss_mvmt_sts_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.chss_mvmt_sts_cd_text.value = newCode;
}

function atch_bare_OnBlur() {
//	document.form.atch_bare_text.value = atch_bare.GetSelectCode();
}
function atch_bare_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.atch_bare_text.value = newCode;
}

function dmg_snd_OnBlur() {
//	document.form.dmg_snd_text.value = dmg_snd.GetSelectCode();
}
function dmg_snd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//	document.form.dmg_snd_text.value = newCode;
}
/**
 * Group1 Multi-Combo OnChange event handling <br>
 * @param  {object} ComboObj	mandatory	 Sheet Object
 * @param  {int} 	Index_Code	mandatory
 * @param  {string} Text		mandatory
 * @return 
 * @version
 */ 
function group1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
	//Group MultiCombo value reset
  	var arrGroup=new Array();
	var sheetObj=sheetObjects[0];
  	// Sheet Object title value setting
  	sheetObj.RemoveAll();
  	sheetObj.SetCellValue(0,"group1",comboObj.GetSelectText());
  	sheetObj.SetCellValue(1,"group1",comboObj.GetSelectText());
  	if(sheetObj.GetCellValue(0,"group1") == ""){
  		sheetObj.SetColHidden("group1",1);
  	} else {
  		sheetObj.SetColHidden("group1",0);
  	}
  	
//  	document.form.group1_text.value = group1.GetText(parseInt(newIndex), 0);
}
 /** 
  * Object activate event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version 
  */
 function obj_activate(){
   	ComClearSeparator(ComGetEvent());
 } 
 /** 
  * Object deactivate event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version 
  */
 function obj_deactivate(){
	//ComChkObjValid(ComGetEvent());
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
   	obj=ComGetEvent();
   	if(obj.dataformat == null) return;
   	window.defaultStatus=obj.dataformat;
   	switch(obj.dataformat) {
   	 	case "ym": case "ymd":
   	 		ComKeyOnlyNumber(obj);
   	 		break;
   	 	case "int":
   	 		if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
   	 		else ComKeyOnlyNumber(obj);
   	        break;
   	 	case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;    
   	    case "eng":
  	    	if(obj.name=="vndr_seq") 
  	    		ComKeyOnlyNumber(obj,",");
  	    	else 
  	    		ComKeyOnlyAlphabet();
   	        break;
   	    case "engup":
  	        if(obj.name=="crnt_loc_cd") ComKeyOnlyAlphabet('upper');//ComKeyOnlyAlphabet('uppernum');
  	        else if(obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
   	        else ComKeyOnlyAlphabet('upper');
   	        break;
   	    case "engdn":
   	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
   	        else ComKeyOnlyAlphabet('lower');
   	        break;
   	}
 } 
 /** 
  * aciac_div_cd change event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version
  */
  function aciac_div_cd_change(){
	  var formObj=document.form;
	  if(aciac_div_cd.GetSelectText()!= "Active")
	  {
		  form.include_status_lst.disabled=false;
	  }
	  else
	  {
		  form.include_status_lst.checked=false;
		  form.include_status_lst.disabled=true;
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
 	 obj=ComGetEvent();
 	 switch(ComGetEvent("name")){
 	   	case "vndr_seq":
 	   		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
 	   		var arrVndrSeq=vndrSeq.split(",");
 	   		for(var i=0; i < arrVndrSeq.length; i++){
 	   		// 
 	 			if(arrVndrSeq[i] == ''){
 	 				ComShowCodeMessage('CGM10009','Lessor');
 	 				formObj.vndr_seq.value="";
     	 				ComSetFocus(formObj.vndr_seq);
     	 				break;
     	 			}
     	   		}
     	   		break;
     	 }   
     }
   /** 
 * Object obj_focusout event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */  
function obj_focusout(){
	 var formObj=document.form;
	 var sheetObj=sheetObjects[0];
	 obj=ComGetEvent();
	 switch(ComGetEvent("name")){
	 	case "crnt_yd_cd":
	 		break;
	 }
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
    	case "aciac_div_cd":
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
  	            SetSelectIndex(0);
  	        }
  	        break;
    	case "group1":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(170);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  	            SetEnable(1);
  	            comboObj.SetUseAutoComplete(1);
  	        }
  	        break;    
    	case "eq_tpsz_cd":
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
    	case "atch_bare":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(170);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  	            SetEnable(1);
  	        }  	        
  	        break;    
    	case "dmg_snd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(170);
  	            SetMultiSelect(0);
  	            SetMaxSelect(1);
  	            SetEnable(1);
  	        }  	        
  	        break;     	    
 	}
 }       
 function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
 	cmbObj.RemoveAll();
 	if(opt == 0) {
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
         }
 	} else if(opt == 1){
 		cmbObj.InsertItem(0,"","");
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
         }
 	}
 	cmbObj.SetSelectIndex("" ,false);
 }   
 function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
    	cmbObj.RemoveAll();
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
   function enterFire() {
	   var formObj=document.form;
	   var sheetObj=sheetObjects[0];
	   if(event.keyCode == 13)
	   {
		   if(validateForm(sheetObj,formObj,IBSEARCH))
		   {
			   ComKeyEnter('search');
		   }
	   }
   }    
/**
 * value check logic
 * @author  
 */
function obj_keyup(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 obj=ComGetEvent();
    	 switch(ComGetEvent("name")){
	 	 	case "crnt_loc_cd":
		 		var crntLocCd=ComTrimAll(formObj.crnt_loc_cd.value);
		   		var arrCrntLocCd=crntLocCd.split(",");
		   		for(var i=0; i < arrCrntLocCd.length; i++){
		   		// 
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.crnt_loc_cd.value="";
		 				ComSetFocus(crnt_loc_cd);
		 				break;
		 			}else
		 			{
		    	 		//if(formObj.crnt_loc_cd.value != ''){
		    	 		if(formObj.crnt_loc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		 			}
		   		}
		 		break; 
	 	   	case "crnt_yd_cd":
		   		var crntYdCd=ComTrimAll(formObj.crnt_yd_cd.value);
		   		if( formObj.crnt_yd_cd.value.search(',') > 0 || (formObj.crnt_yd_cd.value == ''))
		   		{
		   			break;
		   		}
		   		var arrCrntYdCd=crntYdCd.split(",");
		   		for(var i=0; i < arrCrntYdCd.length; i++){
		   			// 
		 			if(arrCrntYdCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Yard');
		 				formObj.crnt_yd_cd.value="";
		 				ComSetFocus(formObj.crnt_yd_cd);
		 				break;
		 			}
		   		}
		 		//if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value != ''){
		 		if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7){
		 			//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	 	 		} 
	 	 		break;
    	 }
}   
	/* developer job end */


