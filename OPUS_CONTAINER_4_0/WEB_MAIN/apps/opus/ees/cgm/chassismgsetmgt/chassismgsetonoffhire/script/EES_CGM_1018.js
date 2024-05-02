/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1018
*@FileTitle  : Found Chassis Auto Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_1018 : ees_cgm_1018 business script for
     */
    function ees_cgm_1018() {
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
                 case "btn_new":
                	 formObject.reset();
                	 form.combo_location_text.value="";
               		 sheetObject1.RemoveAll();
                     break; 
                 case "btn_save":
                	 doActionIBSheet(sheetObject1,formObject,IBSAVE);
                     break;
                 case "btn_retrieve":
                	 doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                     break;                   
                 case "ComOpenPopupWithTarget":
                 	var tmp=form.combo_location_text.value;
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
                 case "btn_del":
                	 doActionIBSheet(sheetObject1,formObject,REMOVE);
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
      * Sheet setting and reset
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
             comboObjects[comboCnt++]=combo_location;
           	 for(var k=0;k<comboObjects.length;k++){
       	        initCombo(comboObjects[k]);
      	     }  
           //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
           	sheet1_OnLoadFinish(sheet1)
         }
     }
      /**
       * 
       * @param sheetObj
       * @return
       */
 function sheet1_OnLoadFinish(sheetObj) {
          sheetObj.SetWaitImageVisible(0);
          formObj=document.form;
 //         axon_event.addListenerFormat('beforeactivate',	  'obj_activate',		formObj);
//          axon_event.addListener('change', 'obj_change' , 'scc_cd'  ); 
          axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
          initControl(sheetObjects[0]); 
          sheetObj.SetWaitImageVisible(1);
     }
      /**
       * AXON event handling
       */
      function obj_activate(){
          ComClearSeparator(ComGetEvent());
      }
      /**
       * init control of form <br>
       * @param  {object} sheetObj	
       * @return 
       * @author 
       * @version 2009.05.20
       */
      function initControl(sheetObj){
      	// Form object
      	  formObj=document.form;
          // axon event regist
//      	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
        axon_event.addListener(  'scc_cd'   ); 
//          doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObjects[0], document.form, IBRESET);
//          formObj.agmt_lstm_cd.text ='ALL';
        combo_location.SetSelectIndex(0);
//          //  focus
//          combo_location.focus();
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
         switch(sheetNo) {
             case 1:      //sheet1 init
                 with(sheetObj){
	             var HeadTitle="||Chassis No.|TP/SZ|Term|Lessor|MVMT|Status|Found Yard|Found Date|Lost/TLL Created Date|Lost/TLL Created By|";
	
	             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chss_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_aset_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmts_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		              {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sys_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              
	             InitColumns(cols);
	             SetEditable(1);
	             SetColProperty(0, "mvmts_dt", {Format:"####-##-## ##:##"} );
	             SetImageList(0,"img/btns_calendar.gif");
	             SetShowButtonImage(1);
//	             SetSheetHeight(470);
	             resizeSheet();
             }
             break;
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         formObj.location.value= combo_location.GetSelectCode();
         switch(sAction) {
           case IBSEARCH:      //retrieve
	 	          if(validateForm(sheetObj,formObj,sAction)){
	 	        	 formObj.f_cmd.value=SEARCH;
		             var params=FormQueryString(formObj);
			  		 sheetObj.SetWaitImageVisible(0);
			 	     ComOpenWait(true);
 		             sheetObj.DoSearch("EES_CGM_1018GS.do",  params );
		             ComOpenWait(false);
	 	          }
                 break;
           /* 
           case IBSEARCH_ASYNC01:	// Term Code Combo retrieve
		       	formObj.f_cmd.value=SEARCH;
		       	formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting ( AGREEMENT LEASE TERM CODE )
 		   		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
		   		var sStr=ComGetEtcData(sXml,"comboList");    	
//		   		alert(sStr);
		   		var arrStr=sStr.split("@");
		   		// combo control, result string, Text Index, Code Index
	  			MakeComboObject(formObj.location, arrStr, 0, 0);
	  			break;
	  	   */
 			case IBSAVE:        //saving
//           	if(validateForm(sheetObj,formObj,sAction))
	 			for(i=1; i<sheetObj.rowCount+1; i++){
	 				if(sheetObj.GetCellValue(i, "del_chk") != "1"){
						sheetObj.SetRowStatus(i,"R");
					}
	 				if(sheetObj.GetCellValue(i, "del_chk") == "1" &&  sheetObj.GetCellValue(i, "mvmts_dt") == ""){
						sheetObj.SetRowStatus(i,"R");
						ComShowCodeMessage('CGM10004','Found date');
						sheetObj.SetCellValue(i, "del_chk","0");
						return ;
					}
                    if(sheetObj.GetCellValue(i, "del_chk") == "1"  ){
                        var dt3=ComReplaceStr(ComReplaceStr(ComReplaceStr(sheetObj.GetCellValue(i, "sts_evnt_dt"),"-","")," ",""),":","");
                        var dt2=sheetObj.GetCellValue(i, "mvmts_dt");
						if(dt2 < dt3){
			      			 ComShowCodeMessage("CGM10055");
			      			 sheetObj.SelectCell(i, "mvmts_dt");
				           	 return ;
			    	    } 
					}
				}
	 			formObj.f_cmd.value=MODIFY01;
				queryString="f_cmd=" + MODIFY01 ;
				var params=sheetObj.GetSaveString(true);
				sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
				if(sheetObj.DoSave("EES_CGM_1018GS.do",queryString + "&" + ComGetPrefixParam("")),'del_chk')
				{
					//cancle
//					for(i=1; i<sheetObj.rowCount+1; i++){
//						if(sheetObj.CellValue(i, "del_chk") == "1"){
//							sheetObj.RowStatus(i) = "R";
//						}
//					}
				}  
				ComOpenWait(false);
                break;
            case REMOVE: 	
           		formObj.f_cmd.value=MODIFY02;
				queryString="f_cmd=" + MODIFY02 ;
				for(i=1; i<sheetObj.rowCount+1; i++){
					if(sheetObj.GetCellValue(i, "del_chk") == "1"){
						sheetObj.SetRowStatus(i,"D");
					}
				}
				var params=sheetObj.GetSaveString(true);
				if(sheetObj.DoSave("EES_CGM_1018GS.do",queryString + "&" + ComGetPrefixParam("")),'del_chk')
				{
					//cancle 
					for(i=1; i<sheetObj.rowCount+1; i++){
						if(sheetObj.GetCellValue(i, "del_chk") == "1"){
							sheetObj.SetRowStatus(i,"R");
						}
					}
				}  
				 break;
				 
	       	  case IBSEARCH_ASYNC02:	// ( location)retrieve
		       	formObj.f_cmd.value=SEARCH;
		       	formObj.loc_cd.value=formObj.scc_cd.value;		//   ( location)
 		   		var sXml=sheetObj.GetSearchData("cgm_Check_LocationGS.do", FormQueryString(formObj));
 		   		// data count
		        var dataCount=ComGetTotalRows(sXml);
		        if(dataCount==0){
		        	ComShowCodeMessage('CGM10009','location cd');
			   		formObj.scc_cd.value="";
			   		formObj.scc_cd.focus();
		        }
		        break;
		    
	       	case IBSEARCH_ASYNC08:
	        	formObj.f_cmd.value=SEARCH17;
	        	var location=form.combo_location_text.value;
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
		 		if ( arrXml[idx] == null ) {return;}
		 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
		 	    var arrStr1=new Array();
		 		for ( var i=0; i < vArrayListData.length; i++) {
		 		    vListData=vArrayListData[i];
		 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
		 		}
		 		// combo control, result string, Text Index, Code Index
			  	MakeComboObject(combo_location, arrStr1, 0, 0);
		 		idx++;       
		 		break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
     		 switch(sAction) {
     		 	case IBSEARCH:
     		 		combo_location.value=form.combo_location_text.value;
     		 		if(location.value == ''){
        				ComShowCodeMessage('CGM10004','location ');
        				location.focus();
        				return false;
        			}
     		 		if(scc_cd.value == ''){
        				ComShowCodeMessage('CGM10004','scc_cd');
        				scc_cd.focus();
        				return false;
        			}
     		 		if(scc_cd.value.length !=5){
    		 			ComShowCodeMessage('CGM10044','Location (5)');
           				scc_cd.focus();
           				return false;
           			}
            		break;
     		 }      
     	 }
          return true;
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
       	            	SetDropHeight(100);
       	            	SetMultiSelect(0);
       	            	SetMaxSelect(1);
       	            	SetEnable(1);
       	            }
       	            break;
       	    }
       	} 
         function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
         	cmbObj.RemoveAll();
           	for (var i=0; i < arrStr.length;i++ ) {
           		var arrCode=arrStr[i].split("|");
           		cmbObj.InsertItem(i, arrCode[1].toString(), arrCode[codeCol].toString());
            }
           	cmbObj.SetSelectIndex("" ,false);
         }
          function obj_keypress(){
         	 obj=event.srcElement;
         	 if(obj.dataformat == null) return;
         	 window.defaultStatus=obj.dataformat;
         	 switch(obj.dataformat) {
         	    case "engup":
         	        if(obj.name=="scc_cd") ComKeyOnlyAlphabet('uppernum')
         	        else ComKeyOnlyAlphabet('upper');
         	        break;
         	 }
          }
        // retrieve after saving
   	    function sheet1_OnSaveEnd(sheetObj, errMsg) {
   	    	if(errMsg =='') {   
   	    		ComShowCodeMessage('CGM00003');
   	        	set_serch();
   			}
   	    }    
        // retrieve  
        function set_serch()
        {
       	   var sheetObject1=sheetObjects[0];
           var formObject=document.form;
       	   doActionIBSheet(sheetObject1, formObject, IBSEARCH);
        }
        function sheet1_OnPopupClick(sheetObj, row, col){
        	switch (sheetObj.ColSaveName(col)) {
        	case "mvmts_dt" :
        		if (sheetObj.ColSaveName(col) != "mvmts_dt"){
        			return;
        		}
        		var cal=new ComCalendarGrid("myCal");
        		cal.setEndFunction("processEndCal");    
        		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
        		break;
        	case "sts_evnt_yd_cd" :
        		ComOpenPopup('/opuscntr/COM_ENS_061.do' , 800, 475, 'setPrntUsrRoleCd','0,1,1,1,1,1,1', true, false, row, col, 0);
        		break;
        	}
        }
         function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
    			var sheetObject=sheetObjects[0];
    			sheetObject.SetCellValue(row, "sts_evnt_yd_cd",aryPopupData[0][3]);
     	 }
         function processEndCal(){
        	 var sheetObj=sheetObjects[0];
        	 if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "mvmts_dt") > document.form.form_day.value){
     	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "mvmts_dt","");
     	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "del_chk","");
     	    	sheetObj.focus();
     	    	sheetObj.SelectCell(sheetObj.GetSelectRow(),sheetObj.GetSelectCol()-1, false);
				ComShowCodeMessage("CGM10058");
     	    } else {
     	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "del_chk","1");
     	    }
         }
     	function sheet1_OnChange(sheetObj, Row, Col){
           var formObj=document.form;
           var chk=true;
           switch (sheetObj.ColSaveName(Col)) {
              case "mvmts_dt" :
//            	  alert(document.form.form_day.value.substring(0, 8));
//            	  alert(sheetObj.CellValue(Row, "mvmts_dt").substring(0, 8));
            	  if(sheetObj.GetCellValue(Row, "mvmts_dt").substring(0, 8) >  document.form.form_day.value.substring(0, 8) ){
            	    	sheetObj.SetCellValue(Row, "mvmts_dt","",0);
            	    	sheetObj.SetCellValue(Row, "del_chk","");
//            	    	sheetObj.focus();
            	    	//sheetObj.SelectCell(Row,Col-1, false);
            	    	ComShowCodeMessage("CGM10058");
            	    } else {
            	    	sheetObj.SetCellValue(Row, "del_chk","1");
            	    }
    		 	    break;
    	      case "sts_evnt_yd_cd" :
    	   			formObj.f_cmd.value=COMMAND01;
    	   			formObj.yd_cd.value=sheetObj.GetCellValue(Row, "sts_evnt_yd_cd");
    			   	if(formObj.yd_cd.value!="")
    			   	{
     			   		var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
    				   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
    				   	if(sCheckResult == COM_VALIDATION_FALSE){
    				   		ComShowCodeMessage('CGM10009','Yard');
    				   		sheetObj.SetCellValue(Row, "sts_evnt_yd_cd","",0);
    				   		sheetObj.SelectCell(Row, Col-1, true);
//    				   	    sheetObj.CellValue(Row, "ibflag") = "";
//    				   		formObj.sts_evnt_yd_cd.focus();
    				   	} else {
    				   		sheetObj.SetCellValue(Row, "del_chk","1");
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
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0]; 
    	 obj = ComGetEvent();
    	 switch(ComGetEvent("name")){
	 		case "scc_cd":
    	 		if(formObj.scc_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
    	 		}
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
    	 obj=ComGetEvent("name");
    	 switch(obj){
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
  function sheet1_OnDblClick(sheetObj, Row, Col){
	  if(Col==2 && sheetObj.GetCellValue(Row, "eq_no")!=""){
       	var param="?pgmNo=EES_CGM_1105&popup=yes";
       	var sts_evnt_dt=sheetObj.GetCellValue(Row, "sts_evnt_dt");
       	sts_evnt_dt=ComReplaceStr(sts_evnt_dt.substring(0,10),"-");
       	param=param + "&eq_no=" + sheetObj.GetCellValue(Row, "eq_no") +"&to_day="+sts_evnt_dt;
    	ComOpenPopup('/opuscntr/EES_CGM_1105_POP.do' + param, 1000, 600, "", "1,0", true, false);
	   }
  }
	/* developer job end */
  
	function combo_location_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode)
	{
		if(combo_location.GetText(parseInt(combo_location.GetSelectIndex()), 0) != undefined){
			form.combo_location_text.value = comboObj.GetText(parseInt(combo_location.GetSelectIndex()), 0);
		}
	}
	function combo_location_OnBlur() {
		if(combo_location.GetText(parseInt(combo_location.GetSelectIndex()), 0) != undefined){
			document.form.combo_location_text.value = combo_location.GetText(parseInt(combo_location.GetSelectIndex()), 0);
		}
	}
	function combo_location_OnSelect() {
		if(combo_location.GetText(parseInt(combo_location.GetSelectIndex()), 0) != undefined){
			document.form.combo_location_text.value = combo_location.GetText(parseInt(combo_location.GetSelectIndex()), 0);
		}
	}
