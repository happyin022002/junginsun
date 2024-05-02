/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1019.js
*@FileTitle  : Lost Chassis Summary Report
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
                 case "btn_summary":
                	 doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                     break;
                 case "btn_new":
                	 objectClear();
                	 Period_Chk();
                	 sheetObject1.RemoveAll();
                     break; 
                 case "btn_downexcel":
                	 if(sheetObject1.RowCount() < 1){//no data
                			ComShowCodeMessage("COM132501");
            		}else{
            			sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
            		}
                     break;
                 case "btn_griddownexcel":
 					ComShowMessage("btn_griddownexcel");
                     break;
                 case "ComOpenPopupWithScc_cd":
                 	var tmp= combo_location.GetSelectText();
                 	if(tmp == "RCC")
                 	{
                 		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 480,"rcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}else if(tmp == "LCC")
                 	{
                 		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 480,"lcc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}else if(tmp == "SCC")
                 	{
                 		ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do?pgmNo=COM_ENS_051', 1000, 480,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
                 	}
           			break;
                 case "ComOpenPopupWithTargetYard":
           			ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 530, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
           			break;
                 case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var cal=new ComCalendar();
	 				cal.select(formObject.evnt_dt_str, "yyyy-MM-dd");
	 				break;
	 			 case "btns_Calendar2" :		// Agreement Date (To Date)
//	 				var cal = new ComCalendar();
//	 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
		 			if(formObj.eq_aset_sts_cd[0].checked != true ){
		 				var cal=new ComCalendarFromTo();
			            cal.select(formObject.evnt_dt_str,  formObject.evnt_dt_end,  'yyyy-MM-dd');
		 	    		break;
		 			}
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
    	var formObj=document.form;
    	
    	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);
    	
         for(i=0;i<sheetObjects.length;i++){
         		//
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         		//
             ComEndConfigSheet(sheetObjects[i]);
             comboObjects[comboCnt++]= combo_location;
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
		 axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
		 initControl(sheetObjects[0]); 
		 formObj.location.value=comboObjects[0].GetSelectCode();
		 sheetObj.SetWaitImageVisible(1);
		 
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
//      // Lease Term Combo Control setting
//         doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//         
     	 doActionIBSheet(sheetObj, formObj, IBRESET);
     	 combo_location.SetSelectIndex(0);
         Period_Chk();
         axon_event.addListenerForm('blur', 'obj_deactivate', form);   
     }
     function Period_Chk(){
    	  formObj=document.form;
	   	  var l_chk ,f_chk;
	   	  var l_cName,f_cName;
	   	  if(formObj.eq_aset_sts_cd[0].checked == true  ){
	   		  l_chk=true;
	   		  f_chk=false;
	   		  l_cName="input2";
	   	  } else {
	      	  l_chk=false;
	      	  f_chk=true;
	   		  l_cName="input1";
	   	  }
		  formObj.evnt_dt_str.readOnly=l_chk;
	      formObj.evnt_dt_end.readOnly=l_chk;
	      formObj.evnt_dt_str.className=l_cName;
	      formObj.evnt_dt_end.className=l_cName;
	      ComEnableObject(formObj.btns_Calendar2, f_chk);
	      
	      var arrCntrTypeSize = "";
			if(oldCntrTypeSize != ""){
				arrCntrTypeSize = oldCntrTypeSize.split("|");
			}
			var sumCount = 4;
            var sumNmVal = "";
			for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
				if (arrCntrTypeSize.length > 1) {
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
			
	      var sheetObj = sheetObjects[0];
	 		with(sheetObj){
		 	    ShowSubSum([{StdCol:"sts_evnt_loc_cd", SumCols:sumNmVal, Sort:true, ShowCumulate:false, CaptionCol:sheetObj.SaveNameCol('sts_evnt_loc_cd'), CaptionText:"Sub.total"},
			 	    		     {StdCol:"agreement", SumCols:sumNmVal, Sort:true, ShowCumulate:false, CaptionCol:sheetObj.SaveNameCol('agmt_lstm_cd'), CaptionText:"Total"}]);
	 		}

	      formObj.evnt_dt_str.focus();
     }
       /**
      * YA_CD value check
      * @return
      */
     function obj_deactivate(){		
		switch(ComGetEvent("name")){ 	    	
	   		case "evnt_dt_str":
	   			ComChkObjValid(ComGetEvent());		   			
	   			break;
	   		case "evnt_dt_end":
	   			ComChkObjValid(ComGetEvent());	
	   			break;
		}
	}
     function obj_keyup(){
		 var formObj=document.form;
		 var sheetObj=sheetObjects[0];
		 obj=ComGetEvent();
		 switch(ComGetEvent("name")){
		 	case "sts_evnt_yd_cd":
	    	    var sts_evnt_yd_cd;
		    	frmObj=document.form;
		    	sts_evnt_yd_cd=frmObj.sts_evnt_yd_cd.value;
		    	if (sts_evnt_yd_cd.length == 7) {
		    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
		    	}
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
     /** 
     * Object change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */  
    function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0]; 
    	
    	if(comboObj.GetSelectText() == "RCC") {
    		sheetObj.SetCellValue(0, 1, "LCC");
    	} else if(comboObj.GetSelectText()=="LCC") {
    		sheetObj.SetCellValue(0, 1, "SCC");
	    } else if(comboObj.GetSelectText()=="SCC"){
	    	sheetObj.SetCellValue(0, 1, "Yard");
	    } else {
	    	sheetObj.SetCellValue(0, 1, "LCC");
	    }
    	formObj.location.value=comboObj.GetSelectCode();
    	sheetObj.RemoveAll();
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
                 with (sheetObj) {
	                 var HeadTitle="|Location|Term|Lessor|Total";
	                 
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
	 				HeadTitle += "|";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	
	                 SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, FrozenCol:0, DataRowMerge:0 } );
	
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1, Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);

                 	 var cols = [ {Type:"Text",  Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agreement" },
			                     {Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",   Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",   Hidden:0,  Width:210,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"total",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];

	   				  var sCount = "";
					  var x = 1;
					  
	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:sCount,              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					 		  x++;
					 	  }
					  }
	 	              
	 	              cols.push({Type:"Text",   Hidden:1, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

                    var sumCount = 4;
                    var sumNmVal = "";
					for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
						if (arrCntrTypeSize.length > 1) {
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
//                 	SetSheetHeight(380);
    		 	    ShowSubSum([{StdCol:"sts_evnt_loc_cd", SumCols:sumNmVal, Sort:true, ShowCumulate:false, CaptionCol:sheetObj.SaveNameCol('sts_evnt_loc_cd'), CaptionText:"Sub.total"},
   		 	    		     {StdCol:"agreement", SumCols:sumNmVal, Sort:true, ShowCumulate:false, CaptionCol:sheetObj.SaveNameCol('agmt_lstm_cd'), CaptionText:"Total"}]);
                 	resizeSheet( );
            	 }
                 break;
         }
     }
	function resizeSheet(){
		ComResizeSheet( sheetObjects[0] );
	}
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
            case IBSEARCH:      //retrieve
 				 if(!validateForm(sheetObj,formObj,sAction)) return;
 				 ComOpenWait(true);
           		 var params=FormQueryString(formObj);
			 	 formObj.f_cmd.value=SEARCH;
			 	 queryString="f_cmd=" + SEARCH ;
			 	 formObj.location.value=comboObjects[0].GetSelectCode();
//			 	 formObj.location2.value=comboObjects[0].GetSelectCode();
			  	 sheetObj.SetWaitImageVisible(0);
		 	     ComOpenWait(true);
		 	     sheetObj.DoSearch("EES_CGM_1019GS.do",  queryString+"&"+params );
//	             for(i=1; i<sheetObj.rowCount+1; i++){
//	            	 sheetObj.CellValue(i, "agreement") = "";
//        		 }
                 break;
 			case IBSEARCH_ASYNC01:	// Term Code Combo retrieve
 			       	formObj.f_cmd.value=SEARCH;
 			       	formObj.intg_cd_id.value=COM_CD_TYPE_CD02117;		// code type setting ( AGREEMENT LEASE TERM CODE )
 			       	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
 			   		var sStr=ComGetEtcData(sXml,"comboList");    			
 			   		var arrStr=sStr.split("@");
 			   		// combo control, result string, Text Index, Code Index
 			  			MakeComboObject(combo_location, arrStr, 0, 0);
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
// 			   		formObj.scc_cd.focus();
 		        }
      	   case IBSEARCH_ASYNC03:	// Office Code  Validation check 
				   	formObj.f_cmd.value=COMMAND01;
				   	formObj.yd_cd.value=formObj.sts_evnt_yd_cd.value;
				   	if(formObj.yd_cd.value != ""){
				   		var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
					   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
					   	if(sCheckResult == COM_VALIDATION_FALSE){
					   		ComShowCodeMessage('CGM10009','Yard');
					   		formObj.sts_evnt_yd_cd.value="";
//					   		formObj.sts_evnt_yd_cd.focus();
					   	}
				   	}
				   	break;
	   	    case IBSEARCH_ASYNC08:
	   	    	formObj.f_cmd.value=SEARCH17;
	   	    	var location=combo_location.GetSelectText();
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
		 		
	    	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
	        	formObj.f_cmd.value = SEARCH21;
	    		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
				sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
				
				//getting changing column information from server
				oldCntrTypeSize = sCntrTypeSize;
				
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
					if(formObj.eq_aset_sts_cd[0].checked != true ){
						if(evnt_dt_str.value == ''){
							ComShowCodeMessage('CGM10004','Period ');
							evnt_dt_str.focus();
							return false;
						}	
				 		if(evnt_dt_end.value == ''){
								ComShowCodeMessage('CGM10004','Period ');
								evnt_dt_end.focus();
								return false;
						}
				 		 var dt_str=ComReplaceStr(document.form.evnt_dt_str.value,"-","");
						 var dt_end=ComReplaceStr(document.form.evnt_dt_end.value,"-","");
						if(dt_str != '' && dt_end != ''){
							if(dt_end < dt_str){
								ComShowCodeMessage('COM12133','To date','From date','greater');
								evnt_dt_str.value='';
								evnt_dt_str.focus();
								return false;
							}
						}
					}
					if(scc_cd.value!='' && scc_cd.value.length !=5){
    		 			ComShowCodeMessage('CGM10044','Location (5)');
           				scc_cd.focus();
           				return false;
           			}
					if(sts_evnt_yd_cd.value!='' && sts_evnt_yd_cd.value.length !=7){
    		 			ComShowCodeMessage('CGM10044','Yard (7)');
    		 			sts_evnt_yd_cd.focus();
           				return false;
           			}
			 }    
         }
         return true;
     }

     function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg)
 	{
 		ComOpenWait(false);
 		sheetObj.SetSumText(0,1,"Grand Total");
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
      	 obj=ComGetEvent();
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
//      	cmbObj.InsertItem(0,"","");
      	for (var i=0; i < arrStr.length;i++ ) {
      		var arrCode=arrStr[i].split("|");
      		cmbObj.InsertItem(i, arrCode[1], arrCode[codeCol]);
           	}
      	cmbObj.SetSelectIndex("" ,false);
    }
     /**
      *  init object 
      */
     function objectClear(){
	       	var formObj=document.form;
	       	var sheetObject=sheetObjects[0];
	       	//IBMultiCombo reset
	//       	
	       	combo_location.SetSelectCode("");
	       	combo_location.SetSelectText("");
	       	formObj.evnt_dt_str.value="";
	       	formObj.evnt_dt_end.value="";
	       	formObj.scc_cd.value="";
	       	formObj.sts_evnt_yd_cd.value="";
//	       	ComShowMessage(formObj.eq_aset_sts_cd[0].checked);
	       	formObj.eq_aset_sts_cd[0].checked=true;
//     	formObj.eq_spec_no.Code = "";
     }
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
   			var eqTpszCd="";
            var colSaveName=sheetObj.ColSaveName(Col);
           	var eqKndCd=EQ_KND_CD_CHASSIS;
           	var crntYdCd=document.form.sts_evnt_yd_cd.value;
           	var eqStrDt=document.form.evnt_dt_str.value;
           	var eqEndDt=document.form.evnt_dt_end.value;
           	var eqAsetStsCd="";
           	var location=document.form.location2.value;
           	var scc_cd=document.form.scc_cd.value;
           	var vndr_seq=sheetObj.GetCellValue(Row, "vndr_seq");
//           	var sts_evnt_log_cd = "";
           	var sts_evnt_loc_cd="";
           	var kind="";
        //   	alert(location);
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
			
        	if(sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "" && sheetObj.GetCellValue(Row, "agmt_lstm_cd")=="Total"){
					sts_evnt_loc_cd=sheetObj.GetCellValue(Row-1, "sts_evnt_loc_cd");
					vndr_seq="";
			} else if (sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "Sub.total" && sheetObj.GetCellValue(Row, "agmt_lstm_cd") == ""){
				
					sts_evnt_loc_cd=sheetObj.GetCellValue(Row-2, "sts_evnt_loc_cd");
					vndr_seq="";
			} else if (sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "Grand Total"  ){
    		   sts_evnt_loc_cd="";
    		   vndr_seq="";
       	   } else {
       		   sts_evnt_loc_cd=sheetObj.GetCellValue(Row, "sts_evnt_loc_cd");
       		   vndr_seq=sheetObj.GetCellValue(Row, "vndr_seq");
       	   }
       	   if(formObj.eq_aset_sts_cd[0].checked == true){
       		   eqAsetStsCd=""
       	   } else if (formObj.eq_aset_sts_cd[1].checked == true){
       		   eqAsetStsCd="LST"
       	   } else if (formObj.eq_aset_sts_cd[2].checked == true){
       		   eqAsetStsCd="FND"
       	   } 
       	   if(sheetObj.GetCellValue(Row, "agmt_lstm_cd")==""){
       	    	agmtLstmCd="";
       	   } else if (sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "" && sheetObj.GetCellValue(Row, "agmt_lstm_cd") == "Total"){
       		   agmtLstmCd=sheetObj.GetCellValue(Row-1, "agmt_lstm_cd");
       	   } else if (sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "Total" && sheetObj.GetCellValue(Row, "agmt_lstm_cd") == ""){
       		   agmtLstmCd=sheetObj.GetCellValue(Row-2, "agmt_lstm_cd");
       	    } else {
       	    	agmtLstmCd=sheetObj.GetCellValue(Row, "agmt_lstm_cd");
       	    }
     	   if(combo_location.GetSelectCode()=="S")
	   	   {
    		   crntYdCd=sts_evnt_loc_cd;
    		   sts_evnt_loc_cd="";
	   	   } 
     	   location = combo_location.GetSelectCode();
     	   
       	    //kind 	= document.form.kind.value;
           	var param="?pgmNo=EES_CGM_1091&program_id=1019";
	           	param=param + "&f_cmd=" + SEARCH01; 
	        	param=param + "&eq_tpsz_cd=" + eqTpszCd;           	
	           	param=param + "&eq_knd_cd=" + eqKndCd;
	           	param=param + "&crnt_yd_cd=" + crntYdCd;
	           	param=param + "&sts_evnt_dt_fr=" + eqStrDt;
	           	param=param + "&sts_evnt_dt_to=" + eqEndDt;
	           	param=param + "&eq_aset_sts_cd=" + eqAsetStsCd;
	           	param=param + "&location=" + location;
	           	param=param + "&scc_cd=" + scc_cd;
	           	param=param + "&agmt_lstm_cd=" + agmtLstmCd;
	           	param=param + "&sts_evnt_loc_cd="+sts_evnt_loc_cd.substring(0,5);
	        	param=param + "&vndr_seq="+vndr_seq;
	        	param=param + "&kind="+kind;
	        	//param=param + "sts_evnt_yd_cd="+sts_evnt_loc_cd;
          	    ComOpenPopup('/opuscntr/EES_CGM_1091.do' + param, 900, 600, "", "1,0", true, false);
   	   }
      }
	/* developer job end */