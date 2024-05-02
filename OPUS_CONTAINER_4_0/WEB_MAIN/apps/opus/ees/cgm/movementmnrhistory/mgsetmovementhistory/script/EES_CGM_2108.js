/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2108.js
*@FileTitle  : Bare Mgset Movement Manual Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2016/11/22
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
 		var sheetObj=sheetObjects[0];
          /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName = ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
	            case "btn_retrieve":
					doActionIBSheet(sheetObj, formObject, IBSEARCH);
					break;
				case "btn_new":
					sheetObject1.RemoveAll();
					formObject.eq_no.value='';
					formObject.str_mvmt_dt.value=formObject.calend1.value;
					formObject.end_mvmt_dt.value=formObject.calend1.value;
					formObject.str_gubun[0].checked=true;
					from_Chk();
					formObject.eq_no.focus();
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
				case "btn_verify":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_add":
					sheetObject1.DataInsert();
				break;
				case "btn_delete":
					doActionIBSheet(sheetObject1,formObject,REMOVE);
				break;
                case "btn_loadexcel":
                 	 doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
                 	break;
	 			case "btns_Calendar2" :		// Agreement Date (To Date)
	 	    		var cal=new ComCalendarFromTo();
		            cal.select(formObject.str_mvmt_dt,  formObject.end_mvmt_dt,  'yyyy-MM-dd');
	 	    		break;
               case "btn_downexcel":
            	   if(sheetObject1.RowCount() < 1){
            			ComShowCodeMessage("COM132501");
            		}else{
            			sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
            		}
                	break;
             } // end switch
             tRoleApply();
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
          		//
              ComConfigSheet (sheetObjects[i] );
              initSheet(sheetObjects[i],i+1);
          		//
              ComEndConfigSheet(sheetObjects[i]);
          }
		var formObj=document.form;
		var sheetObj = sheetObjects[0];
		  
		// reset
		initControl(sheetObjects[0]);
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
			axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
			//axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
			//axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);
			axon_event.addListenerFormat('blur', 'obj_change' , formObj);
			
          // axon event regist
      	 doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
      	 from_Chk();
         formObj.eq_no.focus();
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
	            	 var HeadTitle="||M.G Set No.|Current Yard|Last MVMT Date|Origin Yard|Destination Yard|Movement Date|Movement Date|Status|In/Out|Used|Trucker|Reason|Container|Chassis|S/P Name|SCAC|Remark(s)|Verify Result|Created Date|Created By|Updated Date|Updated By|ATDT Status|||Input Status";
	
	            	 SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:100, DataRowMerge:1 } );
	
	            	 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	 InitHeaders(headers, info);
	
	            	 var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	            	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	              {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10, AcceptKeys:"E|N", InputCaseSensitive:1},
	            	              {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	            	              {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"chss_mvmt_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:7, AcceptKeys:"E|N", InputCaseSensitive:1},
	            	              {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:7, AcceptKeys:"E|N", InputCaseSensitive:1},
	            	              {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt_day",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt_hd",    KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"gate_io_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	            	              {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_co_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:6},
	            	              {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_rsn_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:11, AcceptKeys:"E|N", InputCaseSensitive:1},
	            	              {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"chss_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:11, AcceptKeys:"E|N", InputCaseSensitive:1},
	            	              {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"sp_name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:60,  Align:"Center",  ColMerge:0,   SaveName:"scac",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"verify",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"at_dt_status",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"sys_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mnl_inp_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	  ];
	            	  
	            	 InitColumns(cols);
	
	            	 SetEditable(1);
	            	 SetColProperty(0, "gate_io_cd", {ComboText:"GateIn|GateOut", ComboCode:"I|O"} );
	            	 SetColProperty(0, "mvmt_co_cd", {ComboText:"OWN|Others", ComboCode:"H|O"} );
	            	 SetColProperty(0, "mvmt_rsn_cd", {ComboText:"", ComboCode:""} );

	            	 //지원안함[확인요망]HANJIN: 					sheetObj.InitDataValid(0, "diff_rmk", vtEngOther, "1234567890 -!@#=~$%^&*()+\'., \" "); // only upper case, numbers
	            	//지원안함[확인요망]HANJIN: 					SetSelectionMode(smSelectionFree);
	            	 SetImageList(0,"img/btns_calendar.gif");
//	            	 SetSheetHeight(ComGetSheetHeight(sheetObj, 16));
	            	 SetWaitImageVisible(false);
	            	 resizeSheet();
            	 }


                 break;
         }
     }
     
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    	var formObj=document.form;
    	
		if(formObj.str_gubun[0].checked == true){
			for(i=1;i<=sheetObj.LastRow();i++) {
				if(sheetObj.GetCellValue(i, "mnl_inp_flg")!= 'Y'){
					if( (sheetObj.GetCellValue(i, "mvmt_sts_cd") ==  'BI')
					|| (sheetObj.GetCellValue(i, "mvmt_sts_cd") ==  'BO')){
						sheetObj.SetRowEditable(i,1);
						sheetObj.SetCellEditable(i,"del_chk",1);
						sheetObj.SetCellEditable(i,"yd_cd",0);
						sheetObj.SetCellEditable(i,"dest_yd_cd",0);
						sheetObj.SetCellEditable(i,"gate_io_cd",0);
						sheetObj.SetCellEditable(i,"vndr_abbr_nm",0);
						sheetObj.SetCellEditable(i,"mvmt_rsn_cd",0);
						sheetObj.SetCellEditable(i,"chss_no",0);
						sheetObj.SetCellEditable(i,"cntr_no",0);
						sheetObj.SetCellEditable(i,"diff_rmk",0);
		    		}else{
		    			sheetObj.SetRowEditable(i,0);
		    		}
				} else {
		    		sheetObj.SetRowEditable(i,1);
				}
			}
		} else {
		 	for(i=1;i<=sheetObj.LastRow();i++) {
				if(    sheetObj.GetCellValue(i, "del_chk") == "1"
					&& sheetObj.GetCellValue(i, "verify") != 'OK'
					&& sheetObj.GetCellValue(i, "verify") != ''){
					sheetObj.SetRowFontColor(i,"#FF0000");
				} else {
					sheetObj.SetRowFontColor(i,"#000000");
				}
				sheet1_edit(i,true);
		    }
		}
		
		ComOpenWait(false);
    }
     
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         //sheetObj.ShowDebugMsg = false;
         switch(sAction) {
				case IBSEARCH:      //retrieve
					if(!validateForm(sheetObj,formObj,sAction)) return;
			 		var params="";
			 		if(formObj.str_gubun[0].checked == true){
			 			params=FormQueryString(formObj);
						queryString="f_cmd=" + SEARCH ;
					} else {
						params=sheetObj.GetSaveString(true) + "&del_chk";
						queryString="f_cmd=" + SEARCHLIST ;
					}
					ComOpenWait(true);
	 			 	sheetObj.DoSearch("EES_CGM_2108GS.do", queryString+"&"+params);
	 			 	break;
				case IBSAVE:        //saving
					if (formObj.str_gubun[0].checked == true) {
						var params = sheetObj.GetSaveString(true);
						formObj.f_cmd.value = MODIFY01;
						queryString = "f_cmd=" + MODIFY01;
						for (i = 1; i < sheetObj.LastRow() + 1; i++) {
							if (sheetObj.GetCellValue(i, "del_chk") == "1"
								&& sheetObj.GetCellValue(i, "at_dt_status") != 'OK'
									&& sheetObj.GetRowStatus(i) != 'D') {
								sheetObj.SetCellValue(i, "del_chk", "0");
								sheetObj.SetRowStatus(i, "R");
							} else if (sheetObj.GetCellValue(i, "del_chk") == "0"
								&& sheetObj.GetRowStatus(i) != 'D') {
								sheetObj.SetRowStatus(i, "R");
							} else if (sheetObj.GetRowStatus(i) == "D") {
								sheetObj.SetRowStatus(i, "D");
							} else {
								sheetObj.SetRowStatus(i, "U");
							}
						}
					} else {
						formObj.f_cmd.value = MODIFY02;
						queryString = "f_cmd=" + MODIFY02;
						for (i = 1; i < sheetObj.LastRow() + 1; i++) {
							if (sheetObj.GetCellValue(i, "del_chk") == "1"
								&& sheetObj.GetCellValue(i, "verify") != 'OK') {
								sheetObj.SetCellValue(i, "del_chk", "0");
								sheetObj.SetRowStatus(i, "R");
							} else if (sheetObj.GetCellValue(i, "del_chk") == "0") {
								sheetObj.SetRowStatus(i, "R");
							}
							if (sheetObj.GetCellValue(i, "gate_io_cd") == "I"
								&& sheetObj.GetCellValue(i, "mvmt_rsn_cd") == "PUID") {
								ComShowCodeMessage('CGM10039');
								sheetObj.SelectCell(i, Col, true);
							} else if (sheetObj.GetCellValue(i, "gate_io_cd") == "O"
								&& sheetObj.GetCellValue(i, "mvmt_rsn_cd") == "IDRE") {
								ComShowCodeMessage('CGM10039');
								sheetObj.SelectCell(i, Col, true);
								return false;
							}
							
							if(sheetObj.GetCellValue(i, "cntr_no") != "" && sheetObj.GetCellValue(i, "chss_no") != ""){
								ComShowCodeMessage('CGM20050');
								return false;
							}
						}
						var params = sheetObj.GetSaveString(true);
					}
					if (sheetObj.DoSave("EES_CGM_2108GS.do", queryString + "&"
							+ ComGetPrefixParam("")), 'del_chk') {
					}
				break;
				case REMOVE:
					if(formObj.str_gubun[0].checked == true){
						ComRowHideDelete(sheetObj,"del_chk");
					} else {
						var sCheckedRows = sheetObj.FindCheckedRow("del_chk");
						if (sCheckedRows != "") sheetObj.RowDelete(sCheckedRows, 0);
					}
	   				break;
		       	 case IBSEARCH_ASYNC01:	// Term Code Combo retrieve
			       	formObj.f_cmd.value=SEARCH;
			       	formObj.intg_cd_id.value=COM_CD_TYPE_CD01946;		// code type setting ( AGREEMENT LEASE TERM CODE )
			        formObj.code1.value="1108";
			        var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
	 			   	var sStr=ComGetEtcData(sXml,"comboList");
	 		   		var arrStr=sStr.split("@");
		 		    var arrCode1="";
		 		    var arrCode2="";
			 		for (var i=0; i < arrStr.length;i++ ) {
			        	var arrCode=arrStr[i].split("|");
		          		if(i==0)
		          		{
		          			arrCode1=arrCode1 + arrCode[1];
		          			arrCode2=arrCode2 + arrCode[0];
		          		}else
		          		{
		          			arrCode1=arrCode1 +"|"+ arrCode[1];
		          			arrCode2=arrCode2 +"|"+ arrCode[0];
		          		}
		          	}
			 		sheetObj.SetColProperty(0, "mvmt_rsn_cd", {ComboText:arrCode1, ComboCode:arrCode2} );
			       	break;
		       	case IBSEARCH_ASYNC02:	// Term Code Combo retrieve
			       	formObj.f_cmd.value=SEARCH;
		       	    formObj.eq_knd_cd.value="G";
		       	    var sXml=sheetObj.GetSearchData("CGM_CHS_MASTERGS.do", FormQueryString(formObj));
				    // data count
				    var dataCount=ComGetTotalRows(sXml);
				    // data existing
				    if(dataCount == 0){
				    	ComShowCodeMessage('CGM10009','M.G Set No');
//				   		formObj.eq_no.focus();
				   	} else {
				   		formObj.str_mvmt_dt.focus();
				   	}
			    break;
		 	case IBLOADEXCEL:	// EXCEL UPLOAD
	 			if (sheetObj.id == "sheet1") {
	 				sheetObj.RemoveAll();
	 				sheetObj.LoadExcel();
	 			};
	 			break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	  switch(sAction) {
			case IBSEARCH:      //retrieve
				if(formObj.str_gubun[0].checked == true){
					if(formObj.eq_no.value == ''){
						ComShowCodeMessage('CGM10004','M.G Set No. ');
//						formObj.eq_no.focus();
						return false;
					}
				     var dt_str=ComReplaceStr(document.form.str_mvmt_dt.value,"-","");
		 			 var dt_end=ComReplaceStr(document.form.end_mvmt_dt.value,"-","");
			    		if(dt_str != '' && dt_end != ''){
			    			if(dt_end < dt_str){
			    				ComShowCodeMessage('COM12133','To date','From date','greater');
			    				formObj.str_mvmt_dt.value='';
			    				formObj.str_mvmt_dt.focus();
			    				return false;
			    			}
			    		} else
			    		{
			    			if(dt_str == ''){
			    				ComShowCodeMessage('CGM10004','From date. ');
			    				formObj.str_mvmt_dt.value='';
			    				formObj.str_mvmt_dt.focus();
			    				return false;
			    			} else {
			    				ComShowCodeMessage('CGM10004','to date. ');
			    				formObj.end_mvmt_dt.value='';
			    				formObj.end_mvmt_dt.focus();
			    				return false;
			    			}
			    		}
				} else {
					if(sheetObj.RowCount()== 0) {
						ComShowCodeMessage('COM130104');
						return false;
					}
					  for(i=1;i<sheetObj.LastRow()+1;i++)
	                  {
							if(sheetObj.GetCellValue(i, "del_chk") == "1"){
							if(sheetObj.GetCellValue(i, "yd_cd")=='' ){
								  ComShowCodeMessage('CGM10004','Origin Yard');
								  sheetObj.SelectCell(i, 'yd_cd', true);
								  return false;
							  }
							if(sheetObj.GetCellValue(i, "mvmt_dt_day")=='' ){
								  ComShowCodeMessage('CGM10004','Movement Date');
								  sheetObj.SelectCell(i, 'mvmt_dt_day', true);
								  return false;
							  }
							  if(  sheetObj.GetCellValue(i, "mvmt_dt_hd")==''){
								  ComShowCodeMessage('CGM10004','Movement Date');
								  sheetObj.SelectCell(i, 'mvmt_dt_hd', true);
								  return false;
							  }
								formObj.chss_mvmt_dt.value=ComReplaceStr(sheetObj.GetCellValue(i, "chss_mvmt_dt"),"-","");
							  formObj.chss_mvmt_dt.value=ComReplaceStr(formObj.chss_mvmt_dt.value,":","");
							  if(sheetObj.GetCellValue(i, "gate_io_cd")=="I" && sheetObj.GetCellValue(i, "mvmt_rsn_cd") =="PUID"){
					       		  ComShowCodeMessage('CGM10039');
					       	      sheetObj.SelectCell(i, Col, true);
							  } else if (sheetObj.GetCellValue(i, "gate_io_cd")=="O" && sheetObj.GetCellValue(i, "mvmt_rsn_cd") =="IDRE"){
				       			  ComShowCodeMessage('CGM10039');
				       			  sheetObj.SelectCell(i, Col, true);
				       			  return false;
				       		  }
						  }
	                  }
				}
	            break;
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
    	   
      	 var sheetObject1=sheetObjects[0];
      	 var formObject=document.form;

      	 if(ComGetEvent("keycode")==13){return doActionIBSheet(sheetObject1, formObject, IBSEARCH);}
      	 
      	 var obj=ComGetEvent();
      	 var sFormat = ComGetEvent("dataformat");
      	 switch(sFormat) {
      	 	case "ymd":
      	 		ComKeyOnlyNumber(obj);
      	        break;
      	    case "engup":
      	        ComKeyOnlyAlphabet('uppernum')
      	        break;
      	 }
       }

         /**
          * AXON event handling
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
        	 var formObj=document.form;
        	 var obj=ComGetEvent();
        	 switch(ComGetEvent("name")){
        	 	
        	 	case "str_mvmt_dt":
        	 	case "end_mvmt_dt":
         	        ComChkObjValid(obj);
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
    	 switch(ComGetEvent("name")){
    	   case "eq_no":
    	 		if(formObj.eq_no.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
    	 			break;
    	 		}
    	 }
    }
    /**
   * Form Date yard control
   * @return
   * @author 
   * @version4
   */
  function from_Chk(){
	  formObj=document.form;
	  var sheetObject1=sheetObjects[0];
	  var l_chk ,f_chk;
	  var l_cName;
	  if(formObj.str_gubun[0].checked == true){
		  l_chk=false;
		  f_chk=true;
		  l_cName="input1";
		  ComBtnDisable("btn_add");
		  ComBtnDisable("btn_loadexcel");
    	  ComBtnDisable("btn_verify");
    	  ComBtnEnable("btn_retrieve");
	  } else {
   		  l_chk=true;
		  f_chk=false;
		  ComBtnEnable("btn_add");
		  ComBtnEnable("btn_loadexcel");
		  ComBtnEnable("btn_verify");
		  ComBtnDisable("btn_retrieve");
		  l_cName="input2";
		  
	  }
	  formObj.eq_no.readOnly=l_chk;
      formObj.str_mvmt_dt.readOnly=l_chk;
      formObj.end_mvmt_dt.readOnly=l_chk;
      ComEnableObject(document.getElementById("btns_Calendar2"), f_chk);
      sheetObject1.RemoveAll();
//
      formObj.eq_no.className=l_cName;
      formObj.str_mvmt_dt.className=l_cName;
      formObj.end_mvmt_dt.className=l_cName;
  }
	function sheet1_OnChange(sheetObj, Row, Col){
      var formObj=document.form;
      var chk=true;
   	  switch (sheetObj.ColSaveName(Col)) {
   	  case "eq_no" :
	    formObj.f_cmd.value=SEARCH;
	   	formObj.eq_knd_cd.value="G"
	   	var sValue=sheetObj.GetCellValue(Row, Col);
	   	if(sValue!="")
	   	{
		   	if(Row > 1)
			{
				// chassis no check
				for(i=1; i<=sheetObj.LastRow(); i++){
					if(sheetObj.GetCellValue(i, "eq_no")== sValue && Row != i )
 					{
 						chk=false; break;
 					}
 				}
			}
		    if(chk == true)
			{
		    	eq_no_chkeck(sheetObj,Row,"");
			}
			else
			{
	        	ComShowCodeMessage("CGM10017"," Mgset No.");
	        	// Setting Cell value to Null
				sheetObj.SetCellValue(Row, "eq_no","",0);
				sheetObj.SetCellValue(Row, "del_chk","",0);
				sheetObj.SetCellValue(Row, "crnt_yd_cd","",0);
				sheetObj.SetCellValue(Row, "chss_mvmt_dt","",0);
				sheetObj.SetCellValue(Row, "mvmt_dt_hd","",0);
				sheetObj.SetCellValue(Row, "mvmt_sts_cd","",0);
				sheetObj.SetCellValue(Row, "verify","",0);
				sheetObj.SetRowFontColor(Row,"#000000");
				sheet1_edit(Row,false);
			}
//
	   	} else {
		   	sheetObj.SetCellValue(Row, "eq_no","",0);
			sheetObj.SetCellValue(Row, "del_chk","",0);
			sheetObj.SetCellValue(Row, "crnt_yd_cd","",0);
			sheetObj.SetCellValue(Row, "chss_mvmt_dt","",0);
			sheetObj.SetCellValue(Row, "mvmt_dt_hd","",0);
			sheetObj.SetCellValue(Row, "mvmt_sts_cd","",0);
			sheetObj.SetCellValue(Row, "verify","",0);
			sheetObj.SetRowFontColor(Row,"#000000");
	   	}
	    break;
      case "crnt_yd_cd" :
   			formObj.f_cmd.value=COMMAND01;
   			formObj.yd_cd.value=sheetObj.GetCellValue(Row, "crnt_yd_cd");
		   	if(formObj.yd_cd.value!="")
		   	{
		   		var sCheckResult=ComSearchEtcData(sheetObj, "Check_YardGS.do", FormQueryString(formObj), "checkResult");
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Current Yard');
			   		sheetObj.SetCellValue(Row, "crnt_yd_cd","");
			   		sheetObj.SelectCell(Row, Col-1, true);
			   	} else {
			   		sheetObj.SetCellValue(Row, "del_chk","1");
			   	}
		   	}
		    sheetObj.SetCellValue(Row, "verify","",0);
	 	    break;
      case "yd_cd" :
   			formObj.f_cmd.value=COMMAND01;
   			formObj.yd_cd.value=sheetObj.GetCellValue(Row, "yd_cd");
		   	if(formObj.yd_cd.value!="")
		   	{
		   		var sCheckResult=ComSearchEtcData(sheetObj, "Check_YardGS.do", FormQueryString(formObj), "checkResult");
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		sheetObj.SetCellValue(Row, "yd_cd","");
			   		sheetObj.SelectCell(Row, Col-1, true);
			   	} else {
			   		sheetObj.SetCellValue(Row, "del_chk","1");
			   	}
		   	}
		    sheetObj.SetCellValue(Row, "verify","",0);
	 	    break;
     case "dest_yd_cd" :
   			formObj.f_cmd.value=COMMAND01;
   			formObj.yd_cd.value=sheetObj.GetCellValue(Row, "dest_yd_cd");
		   	if(formObj.yd_cd.value!="")
		   	{
		   		var sCheckResult=ComSearchEtcData(sheetObj, "Check_YardGS.do", FormQueryString(formObj), "checkResult");
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		sheetObj.SetCellValue(Row, "dest_yd_cd","");
			   		sheetObj.SelectCell(Row, Col-1, true);
			   	} else {
			   		sheetObj.SetCellValue(Row, "del_chk","1");
			   	}
		   	}
		   	sheetObj.SetCellValue(Row, "verify","",0);
	 	    break;
     case "mvmt_dt_day":
  	      sheetObj.SetCellValue(Row, "verify","",0);
          break;
     case "mvmt_dt_hd":
  	      sheetObj.SetCellValue(Row, "verify","",0);
          break;
     case "vndr_abbr_nm":
 	  formObj.f_cmd.value=SEARCH;
 	  formObj.vndr_seq.value=sheetObj.GetCellValue(Row, "vndr_abbr_nm")
	   	if(formObj.vndr_seq.value !="")
	   	{
	   		var sXml=sheetObj.GetSearchXml("CGM_MDM_VENDORGS.do", FormQueryString(formObj));
		    // data count
		    var dataCount=ComGetTotalRows(sXml);
		    // data existing
		    if(dataCount > 0){
		    	sheetObj.SetCellValue(Row, "del_chk","1");
		   	} else {
		   		ComShowCodeMessage('CGM10009','Trucker');
		   		sheetObj.SetCellValue(Row, "vndr_abbr_nm","");
		   		sheetObj.SelectCell(Row, Col, true);
		   	}
	   	}
	   	sheetObj.SetCellValue(Row, "verify","",0);
	    break;
   case "gate_io_cd" :
	   if(sheetObj.GetCellValue(Row, "gate_io_cd")=="I"){
			sheetObj.SetCellValue(Row, "mvmt_sts_cd","BI");
		} else {
			sheetObj.SetCellValue(Row, "mvmt_sts_cd","BO");
		}
	   
	   if(sheetObj.GetCellValue(Row, "gate_io_cd")=="I" && sheetObj.GetCellValue(Row, "mvmt_rsn_cd") =="PUID"){
   			ComShowCodeMessage('CGM10039');
   			sheetObj.SetCellValue(Row, "mvmt_rsn_cd","CHON");
	   } else if (sheetObj.GetCellValue(Row, "gate_io_cd")=="O" && sheetObj.GetCellValue(Row, "mvmt_rsn_cd") =="IDRE"){
   			ComShowCodeMessage('CGM10039');
   			sheetObj.SetCellValue(Row, "mvmt_rsn_cd","CHON");
   		}
   		sheetObj.SetCellValue(Row, "verify","",0);
   		break;
    case "mvmt_rsn_cd" :
    	if(sheetObj.GetCellValue(Row, "gate_io_cd")=="I" && sheetObj.GetCellValue(Row, "mvmt_rsn_cd") =="PUID"){
   			ComShowCodeMessage('CGM10039');
   			sheetObj.SetCellValue(Row, "mvmt_rsn_cd","CHON");
    	} else if (sheetObj.GetCellValue(Row, "gate_io_cd")=="O" && sheetObj.GetCellValue(Row, "mvmt_rsn_cd") =="IDRE"){
   			ComShowCodeMessage('CGM10039');
   			sheetObj.SetCellValue(Row, "mvmt_rsn_cd","CHON");
   		}
   		sheetObj.SetCellValue(Row, "verify","",0);
   		break;
    case "chss_no" :
    	formObj.f_cmd.value=SEARCH;
	   	formObj.eq_knd_cd.value="Z"
	   		if(sheetObj.GetCellValue(Row, "chss_no")!="")
	   	{
	   		var sXml=sheetObj.GetSearchData("CGM_CHS_MASTERGS.do?eq_no="+sheetObj.GetCellValue(Row, "chss_no"), FormQueryString(formObj));
		    // data count
		    var dataCount=ComGetTotalRows(sXml);
		    // data existing
		    if(dataCount > 0){
		    	sheetObj.SetCellValue(Row, "del_chk","1");
		   	} else {
		   		ComShowCodeMessage('CGM10009','Chassis No');
		   		sheetObj.SetCellValue(Row, "chss_no","");
		   		sheetObj.SelectCell(Row, Col, true);
		   	}
	   	}
	   	sheetObj.SetCellValue(Row, "verify","",0);
   		break;
   		
    case "cntr_no" :
    	formObj.f_cmd.value=SEARCH;
	   	if(sheetObj.GetCellValue(Row, "cntr_no")!="")
	   	{
	   		var sXml=sheetObj.GetSearchData("CGM_MST_CONTAINERGS.do?cntr_no="+sheetObj.GetCellValue(Row, "cntr_no"), FormQueryString(formObj));
		    // data count
		    var dataCount=ComGetTotalRows(sXml);
		    // data existing
		    if(dataCount > 0){
		    	sheetObj.SetCellValue(Row, "del_chk","1");
		   	} else {
		   		ComShowCodeMessage('CGM10009','Container No');
		   		sheetObj.SetCellValue(Row, "cntr_no","");
		   		sheetObj.SelectCell(Row, Col, true);
		   	}
	   	}
	   	sheetObj.SetCellValue(Row, "verify","",0);
   		break;
 	case "diff_rmk" :
 		sheetObj.SetCellValue(Row, "del_chk","1");
 		sheetObj.SetCellValue(Row, "verify","",0);
 		break;
 	case "gate_io_cd" :
 		sheetObj.SetCellValue(Row, "del_chk","1");
 		sheetObj.SetCellValue(Row, "verify","",0);
 		break;
   	}
  }
     function sheet1_OnPopupClick(sheetObj, row, col){
   		switch (sheetObj.ColSaveName(col)) {
       		case "crnt_yd_cd" :
       			ComOpenPopup('COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
       			break
   	       	case "yd_cd" :
   	       		ComOpenPopup('COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
   	       	    break;
   	 	    case "dest_yd_cd" :
   	 	    	ComOpenPopup('COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
   	 	        break;
       	 	case "vndr_abbr_nm" :
       	 		ComOpenPopup('COM_ENS_0C1.do?pgmNo=COM_ENS_0C1' , 700, 455, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
       	 	    break;
       	 	case "mvmt_dt_day":
       	 		var cal=new ComCalendarGrid();
       	 		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
   		}
   	}
    function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
		var sheetObject=sheetObjects[0];
		if(col == 3 || col == 5 || col == 6) // ya_cd
		{
			sheetObject.SetCellValue(row, col,aryPopupData[0][3],0);
		} else if(col == 12)     // trucker
		{
			sheetObject.SetCellValue(row, col,aryPopupData[0][2],0);
		}
		sheetObject.SetCellValue(row, "del_chk","1");
		sheetObject.SetCellValue(row, "verify","");
    }

    /**
    *
    * @param ROW
    * @return
    */
   function sheet1_edit(ROW,status)
   {
	   sheetObjects[0].SetCellEditable(ROW, "yd_cd",status);
	   sheetObjects[0].SetCellEditable(ROW, "dest_yd_cd",status);
	   sheetObjects[0].SetCellEditable(ROW, "mvmt_dt_day",status);
	   sheetObjects[0].SetCellEditable(ROW, "mvmt_dt_hd",status);
	   sheetObjects[0].SetCellEditable(ROW, "gate_io_cd",status);
	   sheetObjects[0].SetCellEditable(ROW, "mvmt_co_cd",status);
	   sheetObjects[0].SetCellEditable(ROW, "vndr_abbr_nm",status);
	   sheetObjects[0].SetCellEditable(ROW, "mvmt_rsn_cd",status);
	   sheetObjects[0].SetCellEditable(ROW, "chss_no",status);
	   sheetObjects[0].SetCellEditable(ROW, "cntr_no",status);
	   sheetObjects[0].SetCellEditable(ROW, "diff_rmk",status);
   }

   function sheet1_OnSaveEnd(sheetObj, Code, errMsg) {
    	if(errMsg =='') {
    		ComShowCodeMessage('CGM00003');
    		for(i=sheetObj.LastRow(); i>0; i--){
    			if(sheetObj.GetCellValue(i, "del_chk") == "1" && sheetObj.GetCellValue(i, "verify")== 'OK'){
				  sheetObj.RowDelete(i, false);
			  }
			}
		}
    }

    
  	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
  		//if (!bResult) return ComShowMessage("Fail load excel");
 		// chassis no check
		for(var iRow=1; iRow<=sheetObj.LastRow(); iRow++){
			var sEqNo = sheetObj.GetCellValue(iRow, "eq_no");
			if (sEqNo=="") continue;
			
			var sFindRows = ComFindAll(sheetObj, "eq_no", sEqNo, iRow+1, true, true);
			if (sFindRows!=-1) {
				var arrRows = sFindRows.split("|");
	            for(idx=0;idx<arrRows.length;idx++) {
	            	var iChk = arrRows[idx];
					sheetObj.SetCellValue(iChk, "eq_no","",0);
					sheetObj.SetCellValue(iChk, "del_chk","",0);
					sheetObj.SetCellValue(iChk, "crnt_yd_cd","",0);
					sheetObj.SetCellValue(iChk, "chss_mvmt_dt","",0);
					sheetObj.SetCellValue(iChk, "mvmt_dt_hd","",0);
					sheetObj.SetCellValue(iChk, "mvmt_sts_cd","",0);
					sheetObj.SetCellValue(iChk, "verify","",0);
	             }
			}
			
        	eq_no_chkeck(sheetObj,iRow,"excel");
		}
  	}
     /**
      * eq_no check
      * @param sheetObj
      * @param Row
      * @param chk
      * @return
      */
     function eq_no_chkeck(sheetObj,Row,chk){
    	    var formObj=document.form;
	  	    formObj.f_cmd.value=SEARCH;
		   	formObj.eq_knd_cd.value="G"
		   	var sXml=sheetObj.GetSearchData("CGM_CHS_MASTERGS.do?eq_no="+sheetObj.GetCellValue(Row, "eq_no"), FormQueryString(formObj));
		    // data count
		    var dataCount=ComGetTotalRows(sXml);
		    // data existing
		    if(dataCount > 0){
		    	sheetObj.SetCellValue(Row, "del_chk","1");
		    	sheetObj.SetCellValue(Row, "crnt_yd_cd",DomXml2String(sXml,"crnt_yd_cd"));
		    	sheetObj.SetCellValue(Row, "chss_mvmt_dt",DomXml2String(sXml,"chss_mvmt_dt"));
		    	sheetObj.SetCellValue(Row, "mvmt_dt_hd","0000");
		    	if(sheetObj.GetCellValue(Row, "gate_io_cd")=="I"){
	   				sheetObj.SetCellValue(Row, "mvmt_sts_cd","BI");
	   			} else {
	   				sheetObj.SetCellValue(Row, "mvmt_sts_cd","BO");
	   			}
		    	sheet1_edit(Row,true);
		   	} else {
		   		if(chk==""){
		   			ComShowCodeMessage('CGM10009','Mgset No');
		   		}
		     	sheetObj.SetCellValue(Row, "eq_no","");
		   		sheetObj.SetCellValue(Row, "chss_no","");
		   		sheetObj.SetCellValue(Row, "cntr_no","");
		   		sheetObj.SelectCell(Row, "eq_no", true);
		     	sheetObj.SetCellValue(Row, "crnt_yd_cd","");
		    	sheetObj.SetCellValue(Row, "chss_mvmt_dt","");
		    	sheet1_edit(Row,false);
		   	}
		    sheetObj.SetCellValue(Row, "verify","",0);
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
// 	  if(formObj.trole.value != "Authenticated"){
// 		  ComBtnDisable("btn_save");
// 		  ComBtnDisable("btn_delete");
// 		  ComBtnDisable("btn_add");
// 	  }
   }
   /* developer job end */
