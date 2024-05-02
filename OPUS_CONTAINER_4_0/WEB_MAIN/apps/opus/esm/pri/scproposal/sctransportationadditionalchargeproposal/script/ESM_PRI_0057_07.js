/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_07.js
 *@FileTitle  : Amendment History Inquiry - Origin/Destination Arbitrary
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0057_07 : business script for ESM_PRI_0057_07  
     */
    function ESM_PRI_0057_07() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
	var CONFIRM_DEST_GLINE=false; // guideline copy 
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
            	case "btn_gricalc":
	            	if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
	            		ComOpenPopup("/opuscntr/ESM_PRI_0113.do?" + FormQueryString(formObject), 605, 400, "", "1,0", true);
	                }
                break;
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				break;
              } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
    }
    /**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	resizeSheet();;
    	initControl();
  	    loadSts=true;
     	parent.loadTabPage();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
    		case "sheet1":
				with(sheetObj){					
					var HeadTitle="Seq.|propNo|amdtSeq|Point|Description|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base Port|VIA|D/Call|Per|Cargo Type|Commodity|Currency|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|GRI|GRI|seq|Note|Accept Staff/Team|Accept Date||||||||||";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
					 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd" },
					 {Type:"Text",     Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm" },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd" },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd" },
					 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3 },
					 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3 },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd" },
					 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd" },
					 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg" },
					 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd" },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd" },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",     KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",       KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
					 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
					 {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_tp_cd" },
					 {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"gri_appl_amt" },
					 {Type:"Text",     Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"note_dp_seq" },
					 {Type:"Text",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"add_chg_note_ctnt" },
					 {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm" },
					 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_seq" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"via_port_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id" } ];
					   
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(240);
					SetEditable(0);
					SetWaitImageVisible(0);
					SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
					SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
					SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
					SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
					SetColProperty("gri_appl_tp_cd", {ComboText:griApplTpCdText, ComboCode:griApplTpCdValue} );
					SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
					SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
					//SetAutoRowHeight(0);
				}
    			break;
    		case "sheet2":
                with (sheetObj) {
                    // setting Host information[HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    // Merge type  [optional, Default msNone]
                    //MergeSheet = msNone;
                    // setting total editable or not [optional, Default false]
                    //Editable = true;
                    // setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    //InitRowInfo( 1, 1, 3, 100);
                    // setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    //(1, 0, 0, true);
                    //  setting function handling header
                    //InitHeadMode(false, true, true, true, false, false);
                    // setting Header row information [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle, true);
                    //data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                //InitDataProperty(0, cnt++ , dtHiddenStatus,		30,    	daCenter,  	false,	"ibflag");
               }
               break;
    	}
    }
    
    function resizeSheet() {
    	ComResizeSheet(sheetObjects[0]);
    }
    
    /**
	 * loading HTML Control event in the page <br>
	 * initializing IBSheet Object calling from {@link #loadPage} function <br>
	 **/
 	function initControl() {
 		DATE_SEPARATOR="/";
 		//Axon event handling 1. event catch
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	/**
     * calling function when occurring OnClick Event <br>
     */
	function obj_click(){
		var formObject=document.form;
		if (ComGetEvent("name") == "org_dest_tp_cd") {
     		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		}
    }
	/**
     * Handling sheet process <br>
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	     	case IBSEARCH:	//retrieve
	     		ComOpenWait(true);
	     		formObj.f_cmd.value=SEARCH01;
	     		var sXml=sheetObj.GetSearchData("ESM_PRI_0057_07GS.do", FormQueryString(formObj));
	     		sheetObj.LoadSearchData(sXml,{Sync:0} );
	     		if(ComGetEtcData(sXml, "GRI_COUNT") == "Y") {
	     			ComBtnEnable("btn_gricalc");
	     		} else {
	     			ComBtnDisable("btn_gricalc");
	     		}
	     		ComOpenWait(false);
	     		break;
			case IBSEARCH_ASYNC02: // font style setting
				formObj.f_cmd.value=SEARCH02;
				//var sXml=sheetObj.getSaveXml("ESM_PRI_0057_07GS.do", FormQueryString(formObj));
				var sXml=sheetObj.GetSearchData("ESM_PRI_0057_07GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;
			case IBSEARCH_ASYNC03: // Term
				formObj.f_cmd.value=SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02138";
				} else {
					formObj.cd.value="CD02139";
				}
				sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
			case IBSEARCH_ASYNC04: // radio button initializing
				formObj.f_cmd.value=SEARCH03;
				//var sXml=sheetObjects[1].getSaveXml("ESM_PRI_0057_07GS.do", FormQueryString(formObj));
				var sXml=sheetObjects[1].GetSearchData("ESM_PRI_0057_07GS.do", FormQueryString(formObj));
				var arrDesc=ComPriXml2Array(sXml, "org_all_cnt|dest_all_cnt");
				if (arrDesc != null && arrDesc.length > 0) {
		 			if(arrDesc[0][0] > 0) {
		 				formObj.org_dest_tp_cd[0].checked=true;
		 			} else if(arrDesc[0][1] > 0) {
		 				formObj.org_dest_tp_cd[1].checked=true;
		 			} else {
		 				formObj.org_dest_tp_cd[0].checked=true;
		 			}
				}
				break;
	    }
	}
	/**
     * calling function when occurring OnSearchEnd Event <br>
     */ 	
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
  		if (errMsg == "") {
  			var formObj=document.form;
 			setSheetDisplay(sheetObj);
 			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
 		}
 	}
    /**
     * calling function when occurring OnClick Event <br>
     */
    function sheet1_OnClick (sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        switch(colname)
        {
            case "acpt_usr_nm":
                if (Value != "") {
                	ComUserPopup(sheetObj.GetCellValue(Row,"acpt_usr_id"));
                }
                break;
        }
    }
    /**
     * calling function when occurring OnSelectCell Event <br>
     * Amend Row's Highlight color is different <br>
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {

        }
    }
    /**
     * setting sheet's attribute function <br>
     */ 
	function setSheetDisplay(sheetObj) {
		var formObj=document.form;
		var amdtSeq=formObj.amdt_seq.value;
		var lgcyIfFlg=form.lgcy_if_flg.value;
		var rCnt=sheetObj.RowCount();
		if(amdtSeq == 0) {
			return;
		}
		for(var i=1 ; i<=rCnt; i++) {
			if(sheetObj.GetCellValue(i ,"amdt_seq") != amdtSeq) {
				sheetObj.SetCellFont("FontStrike", i, "seq", i, "acpt_dt",1);
			} else if(lgcyIfFlg != "Y") {
				sheetObj.SetCellFont("FontColor", i, "seq", i, sheetObj.LastCol(),"#FF0000");// red
			}
		}
	}
 	/**
     * calling function when clicking parent's screen tab <br>
     * showing retrieved data<br>
     */ 		    	
 	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
		var formObj=document.form;
		if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd) {
			formObj.prop_no.value=sPropNo;
			formObj.amdt_seq.value=sAmdtSeq;
			formObj.svc_scp_cd.value=sSvcScpCd;
			formObj.lgcy_if_flg.value=sLgcyIfFlg;
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC04); //Radio Button Default setting
//			if(sSvcScpCd == "TAE") {
// 				formObj.org_dest_tp_cd[0].disabled = true;
// 				formObj.org_dest_tp_cd[1].checked = true;
// 			} else {
// 				formObj.org_dest_tp_cd[0].disabled = false;
// 			}
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC03); //Term
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
	/**
     * initializing parent's screen tab control <br>
     */ 		 
 	function tabClearSheet() {
		var formObj=document.form;
		formObj.prop_no.value="";
		formObj.amdt_seq.value="";
		formObj.svc_scp_cd.value="";
		sheetObjects[0].RemoveAll();
	}
	var enableFlag=true;
	/**
     * calling function from main screen <br>
     * prohibiting insert, update, delete in case or Confirmation = YES  <br>
     */
	function tabEnableSheet(flag) {
		var formObj=document.form;	
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
	 * setting TYPE RADIO button's font color <br>
     * 1) blue : ALL ACCEPT <br>
     * 2) red : AMEND <br>
     */
     function setTypeFontStyle(sXml) {
     	var arrDesc=ComPriXml2Array(sXml, "org_font_style|dest_font_style");
     	var lgcyIfFlg=form.lgcy_if_flg.value;
 		if (arrDesc != null && arrDesc.length > 0) {
 			if(arrDesc[0][0] == "blue") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color="blue";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color="black";
 				}
 			} else if(arrDesc[0][0] == "red") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color="red";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color="black";
 				}
 			} else if(arrDesc[0][0] == "bold") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd1").style.color="black";
 			} else {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="";
 				document.getElementById("org_dest_tp_cd1").style.color="black";
 			}
 			if(arrDesc[0][1] == "blue") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color="blue";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color="black";
 				}
 			} else if(arrDesc[0][1] == "red") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color="red";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color="black";
 				}
 			} else if(arrDesc[0][1] == "bold") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd2").style.color="black";
 			} else {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="";
 				document.getElementById("org_dest_tp_cd2").style.color="black";
 			}
 		}
     }
    var loadSts=false;
    /**
     * calling function from main screen <br>
     */
    function loadFinishCheck(){
         return loadSts;
    }         