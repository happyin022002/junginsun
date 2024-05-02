/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2020.js
*@FileTitle  : Lost M.G.Set Summary Report
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
     * @class ees_cgm_2020 : ees_cgm_2020 business script for
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
    var oldCntrTypeSize = "";
    var sCntrTypeSize = "";
    var oldCntrTypeSize = "";
    var sCntrTypeSize = "";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** use additional sheet var in case of more than 2 tap each sheet *****/
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
                 case "btn_retrieve":
                	 doActionIBSheet(sheetObject,formObject,IBSEARCH);
 					 break;
                 case "btn_new":
                	 objectClear();
//                	 sheetObject.RemoveAll();
                     break; 
                 case "btn_downexcel":
                	 if(sheetObject.RowCount() < 1){//no data
                			ComShowCodeMessage("COM132501");
                		}else{
                			sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
                		}
                     break;
                 case "ComOpenPopupWithScc_cd":
//                 	var tmp=formObject.combo_location.text;
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Sheet  setting 
 및 reset
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
             comboObjects[comboCnt++]=combo_location;
             for(var k=0;k<comboObjects.length;k++){
       	         initCombo(comboObjects[k]);
      	     }  
         }
         	sheet1_OnSearchEnd(sheet1,"");
//         sheet1_OnLoadFinish(sheet1);
//         obj_change();
     }
      /**
      * 
      * @param sheetObj
      * @return
      */
     function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.SetWaitImageVisible(0);
  	     formObj=document.form;
         // axon event regist
//         axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//         axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
//         axon_event.addListenerFormat('beforeactivate',	  'obj_activate',		formObj);
//         axon_event.addListener('change', 'obj_change' , 'sts_evnt_yd_cd'  ,'scc_cd'  ); 
//         axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
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
//      // Lease Term Combo Control  init value  setting.
        // doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//         doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
//         
     	 doActionIBSheet(sheetObj, formObj, IBRESET);
         formObj.combo_location_text.value='RCC';
         sheetObj.SetCellValue(0, 0,"LCC");
         Period_Chk();
         
         //  focus
//         formObj.scc_cd.focus();
     }
      function Period_Chk(){
    	  formObj=document.form;
	   	  var l_chk ,f_chk;
	   	  var l_cName,f_cName;
	   	  if(formObj.eq_aset_sts_cd[0].checked == true  ){
	   		  l_chk=true;
	   		  f_chk=false;
	   		  l_cName="input2";
	   		ComBtnDisable("btns_Calendar2");
	   	  } else {
	      	  l_chk=false;
	      	  f_chk=true;
	   		  l_cName="input1";
	   		ComBtnEnable("btns_Calendar2");
	   	  }
		  formObj.evnt_dt_str.readOnly=l_chk;
	      formObj.evnt_dt_end.readOnly=l_chk;
	      formObj.evnt_dt_str.className=l_cName;
	      formObj.evnt_dt_end.className=l_cName;
//	      ComEnableObject("btns_Calendar2","f_chk");
     }
      /**
       * AXON event handling
       */
      function obj_activate(){
          ComClearSeparator(ComGetEvent());
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
    	   case "sts_evnt_yd_cd":
    	 		if(formObj.sts_evnt_yd_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	 		} 
    	 		break;
    	 		
    	   case "scc_cd":
	   	 		if(formObj.scc_cd.value != ''){
	   	 			
	   	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
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
     function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
     	var formObj=document.form;
     	var sheetObj=sheetObjects[0];
     	
      	if (newIndex == -1) return;
        
        if(combo_location.GetText(parseInt(newIndex), 0)=="RCC") {
     		formObj.location.value = "R";
     		sheetObj.SetCellValue(0, 0,"LCC");
     	} else if(combo_location.GetText(parseInt(newIndex), 0)=="LCC") {
     		formObj.location.value = "L";
     		sheetObj.SetCellValue(0, 0, "SCC");
 	    } else if(combo_location.GetText(parseInt(newIndex), 0)=="SCC"){
 	    	formObj.location.value = "S";
 	    	sheetObj.SetCellValue(0, 0,"Yard");
 	    } else {
 	    	formObj.location.value = "Y";
 	    	sheetObj.SetCellValue(0, 0,"LCC");
 	    }
     	sheetObj.RemoveAll();
     	document.form.combo_location_text.value = combo_location.GetText(parseInt(newIndex), 0);
     	
     	
     }
     
/*     function combo_location_OnBlur() {
    	 if (combo_location.GetSelectIndex() == -1 ) return;
    	 document.form.combo_location_text.value = combo_location.GetText(parseInt(combo_location.GetSelectIndex()), 0);
     }
*/      /** 
       * Object deactivate event handling  <br>
       * @param  
       * @return 
       * @author 
       * @version
       */
      function obj_deactivate(){
     	 var formObj=document.form;
     	 obj=ComGetEvent();
     	 if(obj.name=="evnt_dt_str"  ){
     		 with(formObj){
     			 var creDtFr=ComReplaceStr(evnt_dt_str.value,"-","");
  	        }
  	        ComChkObjValid(ComGetEvent());
         }
       	if(obj.name=="evnt_dt_end"  ){
    		 with(formObj){
    			 var creDtFr=ComReplaceStr(evnt_dt_end.value,"-","");
  	        }
  	        ComChkObjValid(ComGetEvent());
        }
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
                 with (sheetObj) {
                 var HeadTitle="Lessor|Term|Total";
                 
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
                 SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);
                 var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"sts_evnt_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
	                        {Type:"AutoSum",   Hidden:0, Width:230,  Align:"Right",   ColMerge:1,   SaveName:"total",            KeyField:0,   CalcLogic:"",   Format:"" }];
                 
				  var sCount = "";
				  var x = 1;
                  var sumCount = 2;
                  var sumNmVal = "";
				  
 	              for ( var i = 0; i <= arrCntrTypeSize.length; i++) {
				 	  if (arrCntrTypeSize.length > 1) {
				 		  sCount = "eq_tpsz_cd" + x;
				 		  if(i != arrCntrTypeSize.length){
				 			  cols.push({Type:"AutoSum",   Hidden:0, Width:230,  Align:"Right",   ColMerge:1,   SaveName:sCount,              KeyField:0,   CalcLogic:"",   Format:"" });
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
//                 SetSheetHeight(500);
                 SetEditable(0);
                 ShowSubSum([{StdCol:0, SumCols:sumNmVal, Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"Sub Total"}]);
                 sheet1_OnLoadFinish(sheetObj)
                 resizeSheet();
                }
                 break;
         }
     }
     function resizeSheet(){
         ComResizeSheet(sheetObjects[sheetObjects.length-1]);
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
                 if(!validateForm(sheetObj,formObj,sAction)) return;
                 var params=FormQueryString(formObj);
 			 	 formObj.f_cmd.value=SEARCH;
 			 	 queryString="f_cmd=" + SEARCH ;
		  		 sheetObj.SetWaitImageVisible(0);
		 	     ComOpenWait(true);
//		 	     sheetObj.DoSearch("EES_CGM_2020GS.do",  queryString+"&"+params );
                 
		 	     var sXml=sheetObj.GetSearchData("EES_CGM_2020GS.do", queryString+"&"+params);
		 	   //  sheetObj.RenderSheet(0);
		 	     sheetObj.LoadSearchData(sXml,{Sync:1} );
		 	     sheetObj.RenderSheet(1);
		 	     ComOpenWait(false);
      			
                 
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
 	        case IBSEARCH_ASYNC02:	// ( combo_location)retrieve
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
		   case IBSEARCH_ASYNC03:	// Office Code  Validation check 
			   	formObj.f_cmd.value=COMMAND01;
			   	formObj.yd_cd.value=formObj.sts_evnt_yd_cd.value;
 			   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		formObj.sts_evnt_yd_cd.value="";
			   		formObj.sts_evnt_yd_cd.focus();
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
					if(formObj.eq_aset_sts_cd[0].checked != true ){
				 		if(evnt_dt_str.value == ''){
								ComShowCodeMessage('CGM10004','Period ');
//								evnt_dt_str.focus();
								return false;
							}	
				 		if(evnt_dt_end.value == ''){
								ComShowCodeMessage('CGM10004','Period ');
//								evnt_dt_end.focus();
								return false;
							}
				 		 var dt_str=ComReplaceStr(document.form.evnt_dt_str.value,"-","");
						 var dt_end=ComReplaceStr(document.form.evnt_dt_end.value,"-","");
						if(dt_str != '' && dt_end != ''){
							if(dt_end < dt_str){
								ComShowCodeMessage('COM12133','To date','From date','greater');
								evnt_dt_str.value='';
//								evnt_dt_str.focus();
								return false;
							}
						}
					}
					if(scc_cd.value!='' && scc_cd.value.length !=5){
    		 			ComShowCodeMessage('CGM10044','Location (5)');
//           				scc_cd.focus();
           				return false;
           			}
					if(sts_evnt_yd_cd.value!='' && sts_evnt_yd_cd.value.length !=7){
    		 			ComShowCodeMessage('CGM10044','Yard (7)');
//    		 			sts_evnt_yd_cd.focus();
           				return false;
           			}
			 }    
         }
         return true;
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
//        	cmbObj.InsertItem(0,"","");
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
//  	       	combo_location.SetSelectCode("LLC");
  	       	formObj.combo_location_text.value="LLC";
  	       	formObj.combo_location_text.value="";
  	       	formObj.evnt_dt_str.value="";
  	       	formObj.evnt_dt_end.value="";
  	       	formObj.scc_cd.value="";
  	       	formObj.sts_evnt_yd_cd.value="";
//  	       	ComShowMessage(formObj.eq_aset_sts_cd[0].checked);
  	       	formObj.eq_aset_sts_cd[0].checked=true;
//       	formObj.eq_spec_no.Code = "";
  	      sheetObject.RemoveAll();
       }
     	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
     	{
      		with(sheetObj)
      		{
//      			ShowSubSum([{StdCol:"sts_evnt_loc_cd", SumCols:"2|3|4", Sort:true, ShowCumulate:false, CaptionCol:0, CaptionText:"sts_evnt_loc_cd=;sheet1_agmt_lstm_cd=SubTotal"}]);
      			
      			

      			if ( LastRow() >= 2 ) {
      				SetCellValue(LastRow(), 0, "Grand Total");
      			}
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
        	 if(sheetObj.RowCount() + 1 == sheetObj.mouseRow)
        	 {
        		 //alert("ROWCNT:"+ sheetObj.RowCount()+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
        		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "group1");
        		 //alert(groupValue1);
        		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
        	 }
         }
         
        function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
     	   if(Col>1){
//     			var eqTpszCd = "";
                var colSaveName=sheetObj.ColSaveName(Col);
//                	
             	var crntYdCd=document.form.sts_evnt_yd_cd.value;
             	var eqStrDt=document.form.evnt_dt_str.value;
             	var eqEndDt=document.form.evnt_dt_end.value;
             	var scc_cd=document.form.scc_cd.value;
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
  				
            	if(sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "" && sheetObj.GetCellValue(Row, "agmt_lstm_cd")=="Sub Total"){
  					sts_evnt_loc_cd=sheetObj.GetCellValue(Row-1, "sts_evnt_loc_cd");
  					agmt_lstm_cd=sheetObj.GetCellValue(Row-1, "agmt_lstm_cd");
  				} else if (sheetObj.GetCellValue(Row, "sts_evnt_loc_cd")== "Grand Total"  ){
         		  sts_evnt_loc_cd="";
         		  agmt_lstm_cd="";
         	   } else {
         		   sts_evnt_loc_cd=sheetObj.GetCellValue(Row, "sts_evnt_loc_cd");
         		   agmt_lstm_cd=sheetObj.GetCellValue(Row, "agmt_lstm_cd");
         	   }
//         	   
         	   if(formObj.eq_aset_sts_cd[0].checked == true){
         		   eqAsetStsCd=""
         	   } else if (formObj.eq_aset_sts_cd[1].checked == true){
         		   eqAsetStsCd="LST"
         	   } else if (formObj.eq_aset_sts_cd[2].checked == true){
         		   eqAsetStsCd="FND"
         	   } 
  	           	var param="?pgmNo=EES_CGM_2084&program_id=2020";
  	           	param=param + "&s_crnt_yd_cd=" + crntYdCd;
  	           	param=param + "&sts_evnt_dt_fr=" + eqStrDt;
  	           	param=param + "&sts_evnt_dt_to=" + eqEndDt;
  	           	param=param + "&s_eq_tpsz_cd=" + eqAsetStsCd;
  	            param=param + "&s_location=" + combo_location.GetSelectCode();
  	            param=param + "&s_crnt_loc_cd=" + sts_evnt_loc_cd;
  	            param=param + "&eq_tpsz_cd=" + eq_tpsz_cd;
  	            param=param + "&s2_agmt_lstm_cd=" + agmt_lstm_cd;
  	           	param=param + "&location=" + combo_location;
  	           	param=param + "&scc_cd=" + scc_cd;
  	        	ComOpenPopup('/opuscntr/EES_CGM_2084.do' + param, 900, 460, "", "1,0", true, false);
     	   }
        }
	/* developer job end */

