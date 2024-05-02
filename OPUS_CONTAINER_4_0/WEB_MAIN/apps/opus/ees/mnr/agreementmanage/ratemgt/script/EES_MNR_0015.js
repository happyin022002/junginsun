/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0015.js
*@FileTitle  : M&R Agreement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0015 : EES_MNR_0015 - Defining a script used by screen
     */
	/* Developer's task	*/
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var tempSheetObjects=new Array();
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// The variable of status by Retrieve
	var nowRetriveSt=false;
	var retPossible=false;
	var checkEstList="";
	//Unapproved estimate list
	var notApprovalEstList="";
	//Variable for handling tab menu
	var uTab=new Array();
	var gTab=new Array();
	var zTab=new Array();
	//LB type header array
	var lbHeader=new Array();
	//TS type array
	var uTpSz=new Array();
	var gTpSz=new Array();
	var zTpSz=new Array();
	//The default version information
	var defVerCode="1";
	//Setting combo the default value
	var defagmtOfcCdCode="";
	var defeqKndCdCode="";
	var loadIbclear=false;
	var tempEqKndCd="U";
	var priTrfNo="";
	var formObj=document.form;

	//Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
		 var sheetObject5=sheetObjects[4];
		 var sheetObject6=sheetObjects[5];
         var sheetObject7=sheetObjects[6];
		 var sheetObject8=sheetObjects[7];
		/*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
					if(retPossible){
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
					break;
				case "btn_new":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;
				case "btn_versionup":
				  	if(!nowRetriveSt){
						ComShowCodeMessage("MNR00182");
						break;
					}
					//Retrieving unapproved estimate
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
					//notApprovalEstList
					if(notApprovalEstList != 'XX'){
						ComShowCodeMessage("MNR00343",notApprovalEstList);
						return false;
					}
					doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
					break;
				case "btn_save":
					//sheetObjects[1].focus();
					doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
					break;
				case "btn_del":
					if(formObject.isversionup.value == "Y"){
						agmt_ver_no.SetEnable(1);
						var delVerNo=agmt_ver_no.GetSelectCode();
						agmt_ver_no.DeleteItem(delVerNo);
						defVerCode=parseInt(delVerNo,10) - 1;
						agmt_ver_no.SetSelectCode(defVerCode,false);
						MnrWaitControl(false);
						formObject.isversionup.value="N";
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					} else {
						if(!nowRetriveSt){
							ComShowCodeMessage("MNR00047");
							break;
						}
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCHAPPEND);
					}
					break;
				case "btn_add":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;
				case "btn_s1del":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					break;
				case "btn_t1apply":
					doActionIBSheet(sheetObjects[2],document.form,IBCOPYROW);
					break;
				case "btn_t1add":
					doActionIBSheet(sheetObjects[2],document.form,IBINSERT);
					break;
				case "btn_t1del":
					doActionIBSheet(sheetObjects[2],document.form,IBDELETE);
					break;
				case "btn_t2apply":
					doActionIBSheet(sheetObjects[3],document.form,IBCOPYROW);
					break;
				case "btn_t2add":
					doActionIBSheet(sheetObjects[3],document.form,IBINSERT);
					break;
				case "btn_t2del":
					doActionIBSheet(sheetObjects[3],document.form,IBDELETE);
					break;
				case "btn_t3apply":
					doActionIBSheet(sheetObjects[4],document.form,IBCOPYROW);
					break;
				case "btn_t3add":
					doActionIBSheet(sheetObjects[4],document.form,IBINSERT);
					break;
				case "btn_t3del":
					doActionIBSheet(sheetObjects[4],document.form,IBDELETE);
					break;
				case "btn_t4apply":
					doActionIBSheet(sheetObjects[5],document.form,IBCOPYROW);
					break;
				case "btn_t4add":
					doActionIBSheet(sheetObjects[5],document.form,IBINSERT);
					break;
				case "btn_t4del":
					doActionIBSheet(sheetObjects[5],document.form,IBDELETE);
					break;
				case "btn_t5apply":
					doActionIBSheet(sheetObjects[6],document.form,IBCOPYROW);
					break;
				case "btn_t5add":
					doActionIBSheet(sheetObjects[6],document.form,IBINSERT);
					break;
				case "btn_t5del":
					doActionIBSheet(sheetObjects[6],document.form,IBDELETE);
					break;
				case "btn_t6apply":
					doActionIBSheet(sheetObjects[7],document.form,IBCOPYROW);
					break;
				case "btn_t6add":
					doActionIBSheet(sheetObjects[7],document.form,IBINSERT);
					break;
				case "btn_t6del":
					doActionIBSheet(sheetObjects[7],document.form,IBDELETE);
					break;
				case "btn_t7apply":
					doActionIBSheet(sheetObjects[8],document.form,IBCOPYROW);
					break;
				case "btn_t7add":
					doActionIBSheet(sheetObjects[8],document.form,IBINSERT);
					break;
				case "btn_t7del":
					doActionIBSheet(sheetObjects[8],document.form,IBDELETE);
					break;
				case "btn_t8apply":
					doActionIBSheet(sheetObjects[9],document.form,IBCOPYROW);
					break;
				case "btn_t8add":
					doActionIBSheet(sheetObjects[9],document.form,IBINSERT);
					break;
				case "btn_t8del":
					doActionIBSheet(sheetObjects[9],document.form,IBDELETE);
					break;
				case "btn_t9add":
					doActionIBSheet(sheetObjects[10],document.form,IBINSERT);
					break;
				case "btn_t9del":
					doActionIBSheet(sheetObjects[10],document.form,IBDELETE);
					break;
				case "btn_t10add":
					doActionIBSheet(sheetObjects[11],document.form,IBINSERT);
					break;
				case "btn_t10del":
					doActionIBSheet(sheetObjects[11],document.form,IBDELETE);
					break;
				case "btn_t11add":
					doActionIBSheet(sheetObjects[12],document.form,IBINSERT);
					break;
				case "btn_t11del":
					doActionIBSheet(sheetObjects[12],document.form,IBDELETE);
					break;
				case "btn_t12add":
					doActionIBSheet(sheetObjects[13],document.form,IBINSERT);
					break;
				case "btn_t12del":
					doActionIBSheet(sheetObjects[13],document.form,IBDELETE);
					break;
				case "btn_t13add":
					doActionIBSheet(sheetObjects[14],document.form,IBINSERT);
					break;
				case "btn_t13del":
					doActionIBSheet(sheetObjects[14],document.form,IBDELETE);
					break;
				case "btn_t14add":
					doActionIBSheet(sheetObjects[15],document.form,IBINSERT);
					break;
				case "btn_t14del":
					doActionIBSheet(sheetObjects[15],document.form,IBDELETE);
					break;
				case "btn_t15add":
					doActionIBSheet(sheetObjects[16],document.form,IBINSERT);
					break;
				case "btn_t15del":
					doActionIBSheet(sheetObjects[16],document.form,IBDELETE);
					break;
				case "btn_t16add":
					doActionIBSheet(sheetObjects[17],document.form,IBINSERT);
					break;
				case "btn_t16del":
					doActionIBSheet(sheetObjects[17],document.form,IBDELETE);
					break;
				case "btn_t17add":
					doActionIBSheet(sheetObjects[18],document.form,IBINSERT);
					break;
				case "btn_t17del":
					doActionIBSheet(sheetObjects[18],document.form,IBDELETE);
					break;
				case "btn_t18add":
					doActionIBSheet(sheetObjects[19],document.form,IBINSERT);
					break;
				case "btn_t18del":
					doActionIBSheet(sheetObjects[19],document.form,IBDELETE);
					break;
				case "btn_t19add":
					doActionIBSheet(sheetObjects[20],document.form,IBINSERT);
					break;
				case "btn_t19del":
					doActionIBSheet(sheetObjects[20],document.form,IBDELETE);
					break;
				case "btn_t20add":
					doActionIBSheet(sheetObjects[21],document.form,IBINSERT);
					break;
				case "btn_t20del":
					doActionIBSheet(sheetObjects[21],document.form,IBDELETE);
					break;
				case "btn_vndr":
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC03);
					setComboEnable(true);
					break;
				case "btn_calendar":
					var cal=new ComCalendarFromTo();
						cal.select(form.eff_dt,  form.exp_dt,  'yyyy-MM-dd');
					break;
				case "btn_calendar1":
                    var cal=new ComCalendar();
	                cal.select(formObject.agmt_dt, 'yyyy-MM-dd');
	                break;
				case "btn_agmt_no":
					if(!formObject.agmt_no.readOnly){
						ComOpenPopup('/opuscntr/EES_MNR_0016.do', 920, 540, 'setEES_MNR_0016', "0,1,1,1,1,1", true);
					}
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       tempSheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * Assigning array of IBTab object
     * Array defined at the top of the source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		var formObj=document.form;
		MnrWaitControl(true);
		initControl();
		setPageInit();
		initSheet(sheetObjects[0],"sheet1",'','');
		ComConfigSheet(sheetObjects[1]);
		initSheet(sheetObjects[1],"sheet2",'','');
		ComEndConfigSheet(sheetObjects[1]);
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k + 1);
        }
        //formObj.agmt_type_tpsz.value=ComGetAryJoin(uTpSz, "|");
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

    }
	function setPageInit(){
		for(var i=0;i < tempSheetObjects.length ;i++){
			if(tempSheetObjects[i].id == "sheet1"){
				sheetObjects[0]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "sheet2"){
				sheetObjects[1]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t1sheet1"){
				sheetObjects[2]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t2sheet1"){
				sheetObjects[3]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t3sheet1"){
				sheetObjects[4]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t4sheet1"){
				sheetObjects[5]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t5sheet1"){
				sheetObjects[6]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t6sheet1"){
				sheetObjects[7]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t7sheet1"){
				sheetObjects[8]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t8sheet1"){
				sheetObjects[9]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t9sheet1"){
				sheetObjects[10]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t10sheet1"){
				sheetObjects[11]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t11sheet1"){
				sheetObjects[12]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t12sheet1"){
				sheetObjects[13]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t13sheet1"){
				sheetObjects[14]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t14sheet1"){
				sheetObjects[15]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t15sheet1"){
				sheetObjects[16]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t16sheet1"){
				sheetObjects[17]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t17sheet1"){
				sheetObjects[18]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t18sheet1"){
				sheetObjects[19]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t19sheet1"){
				sheetObjects[20]=tempSheetObjects[i];
			} else if(tempSheetObjects[i].id == "t20sheet1"){
				sheetObjects[21]=tempSheetObjects[i];
			}
		}
		doActionIBSheet(sheetObjects[0],document.form,IBRESET);
	}
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    //var cnt  = 0 ;
	    var formObject=document.form
	    switch(comboNo) {
			   case 1:
		           with (comboObj) {
				   	   SetTitle("Ver|Creation Date");
				   	   SetColAlign(0, "left");
				   	   SetColAlign(1, "left");
				   	   SetColWidth(0, "50");
				   	   SetColWidth(1, "170");
					   SetDropHeight(160);
					   SetTitleVisible(true);
			       }
	           break;
			   case 2:
		           with (comboObj) {
				   	   SetTitle("Code|Desc");
				   	   SetColAlign(0, "left");
				   	   SetColAlign(1, "left");
				   	   SetColWidth(0, "50");
				   	   SetColWidth(1, "170");
					   SetDropHeight(160);
					   SetTitleVisible(true);
			       }
	           break;
			   case 4:
		           with (comboObj) {
				   	      SetTitle("Tariff No|Tariff Type|Service Provider|EQ Type|Status|Eff.From|Unit|Currency");
				   	      SetColAlign(0, "left");
				   	      SetColAlign(1, "left");
				   	      SetColAlign(2, "left");
				   	      SetColAlign(3, "left");
				   	      SetColAlign(4, "left");
				   	      SetColAlign(5, "center");
				   	      SetColAlign(6, "left");
				   	      SetColAlign(7, "left");
				   	      SetColWidth(0, "140");
				   	      SetColWidth(1, "80");
				   	      SetColWidth(2, "180");
				   	      SetColWidth(3, "80");
				   	      SetColWidth(4, "100");
				   	      SetColWidth(5, "80");
				   	      SetColWidth(6, "80");
				   	      SetColWidth(7, "80");
			   			  SetDropHeight(160);
			   			  SetTitleVisible(true);
			       }
	           break;
			   default :
		           with (comboObj) {
				       //SetColAlign("left");
					   //DropHeight = 160;
			       }
	           break;
	     }
	}
    /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetType,eq_type,display_type) {
        var cnt=0;
        switch(sheetType) {
			case "sheet1":
                with(sheetObj){
					SetVisible(false);
        		}
            case "sheet2":      //t1sheet1 init
                with(sheetObj){

		              //(23, 0, 0, true);
		              var HeadTitle1="|Sel|Cost CTRL\nOffice|Transmission\nMode|EDI ID|WEB ID|Tel No|Fax No|E-mail|Remark";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_check",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"aply_ofc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"trsm_mod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"edi_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sp_ptal_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"phn_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"fax_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_eml",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ctrl_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_grp_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pay_term_dys",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mnr_prnr_locl_lang_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              WaitImageVisible = false;
		              SetShowButtonImage(2);
		              SetSelectionMode(smSelectionRow);
		              SetSheetHeight(230);
		              SetColProperty(0 ,"aply_ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		              SetColProperty(0 ,"edi_id" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		              SetColProperty(0 ,"sp_ptal_id" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:0});
              }
                break;
            case "LB":      //lb
                with(sheetObj){
		              //(9, 0, 0, true);
		              var HeadTitle="|Sel|Seq.|Detail Type|Rate Type|Yard Code|UDU|Amount";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Combo",     Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"cost_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cost_dtl_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:7 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usr_def_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:500 },
		                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"agmt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:17 },
		                     {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             
		              InitColumns(cols);
		              SetEditable(1);
		              SetSelectionMode(smSelectionFree);
		              SetSheetHeight(222);
		              SetColProperty(0 ,"yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		              
		              var sCondition=new Array (
		            		  new Array("MnrGenCd",eq_type + "G" + display_type+ "_AGMT", "CUSTOM5"),
		            		  new Array("MnrGenCd","MRDRRC"+ "_AGMT", "COMMON")
		              )
		              var comboList=MnrComSearchCombo(sheetObj,sCondition);
		              var sheetComboText="";
		              var sheetComboCode="";
		              var sheetComboDefault="";
		              var comboSaveNames=new Array();
		              comboSaveNames[0]="cost_cd";
		              comboSaveNames[1]="cost_dtl_cd";
		              for(var i=0; i < comboList.length;i++){
		            	  if(comboList[i] != null){
		            		  sheetComboText="";
		            		  sheetComboCode="";
		            		  sheetComboCodeText="";
		            		  sheetComboDefault="";
		            		  for(var j=0; j < comboList[i].length;j++){
		            			  var tempText=comboList[i][j].split("|");
		            			  sheetComboText +=  tempText[1] + "|";
		            			  sheetComboCode +=  tempText[0] + "|";
		            			  sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
		            			  if(j ==0){
		            				  sheetComboDefault=tempText[0];
		            			  }
		            		  }
		            		  sheetComboText=MnrDelLastDelim(sheetComboText);
		            		  sheetComboCode=MnrDelLastDelim(sheetComboCode);
		            		  SetColProperty(0,comboSaveNames[i], {ComboText:sheetComboText, ComboCode:sheetComboCode} );
		            	  }
		              }
              }
                break;
			case "TS":      //ts
				with (sheetObj) {

			        var disPlayTpSz=new Array();
			        var HeadTitleTemp="";
			        if(eq_type == 'U'){
			        	disPlayTpSz=uTpSz;
			        } else if(eq_type == 'G'){
			        	disPlayTpSz=gTpSz;
			        } else if(eq_type == 'Z'){
			        	disPlayTpSz=zTpSz;
			        }
			        //(10, 0, 0, true);
			        var HeadTitle="|Sel|Seq.|Detail Type|TP/SZ|Yard Code|UDU|Amount";
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			               {Type:"Combo",     Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"cost_dtl_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mnr_rt_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:7 },
		                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usr_def_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:500 },
			               {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"agmt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:17 },
			               {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			       
			        InitColumns(cols);
			        SetEditable(1);
			        SetShowButtonImage(2);
			        SetSelectionMode(smSelectionFree);
			        SetSheetHeight(192);
			        SetColProperty(0 ,"yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			        
			        var sCondition=new Array (
		  			        new Array("MnrGenCd",eq_type + "G" + display_type+ "_AGMT", "CUSTOM4")
		  			        )
  			        var comboList=MnrComSearchCombo(sheetObj,sCondition);
		  			var lbComboText="";
		  			var lbComboCode="";
		  			var lbComboDefault="";
			        if(comboList[0] != null){
			        	for(var j=0; j < comboList[0].length;j++){
			        		var tempText=comboList[0][j].split("|");
			        		lbComboText +=  tempText[1] + "|";
			        		lbComboCode +=  tempText[0] + "|";
			        		
			        		if(j == 0){
			        			lbComboDefault=tempText[0];
			        		}
			        	}
			        }
			        lbComboText = MnrDelLastDelim(lbComboText);
			    	lbComboCode = MnrDelLastDelim(lbComboCode);
			        SetColProperty(0,"cost_dtl_cd", {ComboText:lbComboText, ComboCode:lbComboCode} );
			        
			        var eqTpSzCd = "";
			        if(eq_knd_cd.GetSelectCode()=="U"){
			        	for(var i = 0; i < uTpSz.length; i++){
			        		eqTpSzCd += uTpSz[i] + "|";
			        	}
			        	
			        	eqTpSzCd = MnrDelLastDelim(eqTpSzCd);
			        }else if(eq_knd_cd.GetSelectCode()=="Z"){
			        	for(var i = 0; i < zTpSz.length; i++){
			        		eqTpSzCd += zTpSz[i] + "|";
			        	}
			        	
			        	eqTpSzCd = MnrDelLastDelim(eqTpSzCd);
			        }else{
			        	for(var i = 0; i < gTpSz.length; i++){
			        		eqTpSzCd += gTpSz[i] + "|";
			        	}
			        	
			        	eqTpSzCd = MnrDelLastDelim(eqTpSzCd);
			        }
			        
			        SetColProperty(0,"mnr_rt_tp_cd", {ComboText:eqTpSzCd, ComboCode:eqTpSzCd} );
				}
                break;
			case "QT":      //qt
			    with(sheetObj){

			      //(10, 0, 0, true);
			      var HeadTitle1="|Sel|Seq.|Detail Type|Q'ty|Yard Code|UDU|Amount";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Combo",     Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"cost_dtl_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rpr_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:7 },
	                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"usr_def_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:500 },
			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"agmt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:17 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		         
			      InitColumns(cols);
			      SetEditable(1);
			      SetSelectionMode(smSelectionFree);
			      SetSheetHeight(192);
			      SetColProperty(0 ,"yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      
			      var sCondition=new Array (
			            	new Array("MnrGenCd",eq_type + "G" + display_type+ "_AGMT", "CUSTOM4")
			          	)
			      var comboList=MnrComSearchCombo(sheetObj,sCondition);
			      var lbComboText="";
			      var lbComboCode="";
			      var lbComboDefault="";
				  if(comboList[0] != null){
					  for(var j=0; j < comboList[0].length;j++){
						  var tempText=comboList[0][j].split("|");
				    	  lbComboText +=  tempText[1] + "|";
				    	  lbComboCode +=  tempText[0] + "|";
				    	  
				    	  if(j == 0){
				    		  lbComboDefault=tempText[0];
				    	  }
					  }
				   }
				   lbComboText = MnrDelLastDelim(lbComboText);
		    	   lbComboCode = MnrDelLastDelim(lbComboCode);
				   SetColProperty(0,"cost_dtl_cd", {ComboText:lbComboText, ComboCode:lbComboCode} );
			}
            break;
        }
    }
    
    function loadAgmtHdrData(formObj, arrXml){
    	ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
		//vndr
		ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
		ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
		//version no
		agmt_ver_no.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ver_no"),false);
		//currency
		curr_cd.SetSelectCode(ComGetEtcData(arrXml[0], "curr_cd"));
		//agmt_ofc_cd
		agmt_ofc_cd.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ofc_cd"));
		//eff dt
		ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
		ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
		//pay_term_dys
		ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
		//agmt sign dt
		ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
		//agmt_ref_no
		ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
		//EQ_TYPE
		eq_knd_cd.SetEnable(0);
		eq_knd_cd.SetSelectCode(ComGetEtcData(arrXml[0], "eq_knd_cd"));
		//Tariff No
		setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
		
		ComSetObjValue(formObj.old_agmt_no, ComGetEtcData(arrXml[0], "old_agmt_no"));
		
		ComSetObjValue(formObj.cre_usr_id, ComGetEtcData(arrXml[0], "cre_usr_id"));
		ComSetObjValue(formObj.cre_dt, ComGetEtcData(arrXml[0], "cre_dt"));
		ComSetObjValue(formObj.upd_usr_id, ComGetEtcData(arrXml[0], "upd_usr_id"));
		ComSetObjValue(formObj.upd_dt, ComGetEtcData(arrXml[0], "upd_dt"));
    }
    
	//Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieving
              if(validateForm(sheetObj,formObj,sAction)){
			  		for(i=0;i < sheetObjects.length;i++){
			        	sheetObjects[i].RemoveAll();
		         	}
          			formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if(arrXml[0] != null){
//						//agmt_no
//						ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
//						//vndr
//						ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
//						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
//						//version no
//						agmt_ver_no.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ver_no"),false);
//						//currency
//						curr_cd.SetSelectCode(ComGetEtcData(arrXml[0], "curr_cd"));
//						//agmt_ofc_cd
//						agmt_ofc_cd.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ofc_cd"));
//						//eff dt
//						ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
//						ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
//						//pay_term_dys
//						ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
//						//agmt sign dt
//						ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
//						//agmt_ref_no
//						ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
//						//EQ_TYPE
//						eq_knd_cd.SetEnable(0);
//						eq_knd_cd.SetSelectCode(ComGetEtcData(arrXml[0], "eq_knd_cd"));
//						//Tariff No
//						setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
//						
//						ComSetObjValue(formObj.old_agmt_no, ComGetEtcData(arrXml[0], "old_agmt_no"));
//						
//						ComSetObjValue(formObj.cre_usr_id, ComGetEtcData(arrXml[0], "cre_usr_id"));
//						ComSetObjValue(formObj.cre_dt, ComGetEtcData(arrXml[0], "cre_dt"));
//						ComSetObjValue(formObj.upd_usr_id, ComGetEtcData(arrXml[0], "upd_usr_id"));
//						ComSetObjValue(formObj.upd_dt, ComGetEtcData(arrXml[0], "upd_dt"));
						loadAgmtHdrData(formObj, arrXml);
					}
					//Setting sheet for data
					for(var i=1; i < arrXml.length + 1; i++){
						sheetObjects[i].LoadSearchData(arrXml[i-1],{Sync:0} );
					}
					//State of retrieve
					nowRetriveSt=true;
					//isVersionUp
					formObj.isversionup.value="N";
					MnrFormSetReadOnly(formObj,true,"agmt_no");
			  }
              break;
			case IBSAVE:        //Saving
	               if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value=MULTI;
						var sheet2Param="";
						var sheetTparams="";
						var disPlayTypes="";
						var priFixStr="";
						
						for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++){
							sheetObjects[1].SetCellValue(i,"mnr_prnr_seq",formObj.vndr_seq.value,0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_lgl_eng_nm",formObj.vndr_nm.value,0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_locl_lang_nm",formObj.vndr_nm.value,0);
							sheetObjects[1].SetCellValue(i,"pay_term_dys",formObj.pay_term_dys.value,0);
							sheetObjects[1].SetCellValue(i,"eff_dt",formObj.eff_dt.value,0);
							sheetObjects[1].SetCellValue(i,"exp_dt",formObj.exp_dt.value,0);
						}
						
						var tempSheet2Param=sheetObjects[1].GetSaveString(true);
						if(tempSheet2Param == "" && sheetObjects[1].IsDataModified()){
							return;
						} else if(tempSheet2Param != ""){
							sheet2Param=ComSetPrifix(tempSheet2Param,"sheet2");
							disPlayTypes=disPlayTypes + "sheet2|";
							priFixStr=priFixStr + sheetObjects[1].id + "|";
						}
						for(var i=2 ; i < sheetObjects.length ; i++){
							var tempParamStr=sheetObjects[i].GetSaveString(true);
							if(tempParamStr == "" && sheetObjects[i].IsDataModified()){
								return;
							} else if(tempParamStr != ""){
								priFixStr=priFixStr + sheetObjects[i].id + "|";
								sheetTparams=sheetTparams + ComSetPrifix(tempParamStr,sheetObjects[i].id) + "&";
								var tabIndex=parseInt(sheetObjects[i].id.substr(1,1),10) - 1;
								if(eq_knd_cd.GetSelectCode()== 'U'){
									disPlayTypes=disPlayTypes + uTab[tabIndex][0] + "|";
								} else if (eq_knd_cd.GetSelectCode()== 'G'){
									disPlayTypes=disPlayTypes + gTab[tabIndex][0] + "|";
								} else if (eq_knd_cd.GetSelectCode()== 'Z'){
									disPlayTypes=disPlayTypes + zTab[tabIndex][0] + "|";
								}
							}
						}
						formObj.agmt_display_type.value=MnrDelLastDelim(disPlayTypes);
						formObj.agmt_prifix.value=MnrDelLastDelim(priFixStr);
						sheetTparams=MnrDelLastDelim(sheetTparams);
						var sParam=FormQueryString(formObj);
						if(sheet2Param != ""){
							sParam=sParam + "&" + sheet2Param;
						}
						if(sheetTparams != ""){
							sParam=sParam + "&" + sheetTparams;
						}
						
						var sXml=sheetObjects[0].GetSaveData("EES_MNR_0015GS.do",sParam);
						var arrXml=sXml.split("|$$|");
						//In order to occur event   0 -> delete 1 -> save
						sheetObjects[1].LoadSaveData(arrXml[0]);
						var errMsgChk = true;
						for(i=0; i<arrXml.length; i++){
							if(MnrComGetErrMsg(arrXml[i]) != null){
								errMsgChk = false;
							}
						}
						if(errMsgChk){
							//State of retrieve
							nowRetriveSt=true;
							MnrFormSetReadOnly(formObj,true,"agmt_no");
							if(arrXml[0] != null){
								ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
								formObj.agmt_ofc_cty_cd.value=formObj.agmt_no.value.substring(0,3);
								formObj.agmt_seq.value=parseInt(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length),10);
								var sCondition=new Array (
								 	new Array("MnrAgmtHdr",formObj.agmt_no.value,formObj.local_ofc_cd.value)
								)
								var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
								agmt_ver_no.RemoveAll();
								if(comboList[0] != null){
							 		for(var j=0; j < comboList[0].length;j++){
										var tempText=comboList[0][j].split("|");
										agmt_ver_no.InsertItem(j, comboList[0][j] ,tempText[0]);
									}
									agmt_ver_no.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ver_no"),false);
									defVerCode=ComGetEtcData(arrXml[0], "agmt_ver_no");
								}
								//vndr
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
								//currency
								curr_cd.SetSelectCode(ComGetEtcData(arrXml[0], "curr_cd"));
								//agmt_ofc_cd
								agmt_ofc_cd.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ofc_cd"));
								//eff dt
								ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
								ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
								//pay_term_dys
								ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
								//agmt sign dt
								ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
								//agmt_ref_no
								ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
								//EQ_TYPE
								eq_knd_cd.SetEnable(0);
								eq_knd_cd.SetSelectCode(ComGetEtcData(arrXml[0], "eq_knd_cd"));
								//Tariff No
								setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
								
								ComSetObjValue(formObj.old_agmt_no, ComGetEtcData(arrXml[0], "old_agmt_no"));
							}
							//Setting sheet for data
							for(var i=1; i < arrXml.length + 2; i++){
								sheetObjects[i].LoadSearchData(arrXml[i-1],{Sync:0} );
							}
							formObj.isversionup.value="N";
							MnrFormSetReadOnly(formObj,false,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
							for(var i=0; i < sheetObjects.length; i++){
								sheetObjects[i].SetEditable(1);
							}
							agmt_ver_no.SetEnable(1);
							curr_cd.SetEnable(1);
							agmt_ofc_cd.SetEnable(1);
							eq_knd_cd.SetEnable(0);
							MnrWaitControl(false);
						}
				   }
	            break;
			case IBCREATE:      //Version()up
	               if(validateForm(sheetObj,formObj,sAction)){
						agmt_ver_no.SetEnable(1);
				   		setComboEnable(true);
						var newVersion=parseInt(defVerCode,10) + 1;
						agmt_ver_no.InsertItem(0, newVersion+ '|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),newVersion);
//						agmt_ver_no.SetSelectCode("2",false);
						agmt_ver_no.SetSelectIndex("0", false);
						defVerCode=newVersion;
						ComBtnEnable("btn_save");
						ComBtnEnable("btn_del");
						ComBtnDisable("btn_retrieve");
						ComBtnDisable("btn_versionup");
						formObj.isversionup.value="Y";
						MnrFormSetReadOnly(formObj,false,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
						MnrFormSetReadOnly(formObj,true,"agmt_no");
						agmt_ver_no.SetEnable(0);
						curr_cd.SetEnable(1);
						agmt_ofc_cd.SetEnable(1);
						eq_knd_cd.SetEnable(0);
						nowRetriveSt=false;
				   }
	            break;
			case IBSEARCHAPPEND:        //Delete
	              if(validateForm(sheetObj,formObj,sAction)){
						var tempAgmtNo=formObj.agmt_no.value;
						var tempAgmtOfc=formObj.agmt_ofc_cty_cd.value;
						var tempAgmtSeq=formObj.agmt_seq.value;
						//Deleting
				  		formObj.f_cmd.value=REMOVE;
						var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(sXml);
						var sCondition=new Array (
							new Array("MnrAgmtHdr",tempAgmtNo,formObj.local_ofc_cd.value)
						)
						var comboList=MnrComSearchCombo(sheetObj,sCondition);
						agmt_ver_no.RemoveAll();
						if(comboList[0] != null){
					 		for(var j=0; j < comboList[0].length;j++){
								var tempText=comboList[0][j].split("|");
								agmt_ver_no.InsertItem(j, comboList[0][j] ,tempText[0]);
								if(j == 0){
									defVerCode=tempText[0];
								}
							}
							agmt_ver_no.SetSelectCode(defVerCode,false);
							formObj.agmt_no.value=tempAgmtNo;
							formObj.agmt_ofc_cty_cd.value=tempAgmtOfc;
							formObj.agmt_seq.value=tempAgmtSeq;
							for(i=0;i<sheetObjects.length;i++){
					        	sheetObjects[i].RemoveAll();
				         	}
		          			formObj.f_cmd.value=SEARCH;
							var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", FormQueryString(formObj));
							var arrXml=sXml.split("|$$|");
							if(arrXml[0] != null){
//								//agmt_no
//								ComSetObjValue(formObj.agmt_no, ComGetEtcData(arrXml[0], "agmt_no"));
//								//vndr
//								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
//								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
//								//version no
//								agmt_ver_no.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ver_no"));
//								//currency
//								curr_cd.SetSelectCode(ComGetEtcData(arrXml[0], "curr_cd"));
//								//agmt_ofc_cd
//								agmt_ofc_cd.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ofc_cd"));
//								//eff dt
//								ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
//								ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
//								//pay_term_dys
//								ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
//								//agmt sign dt
//								ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
//								//agmt_ref_no
//								ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
//								//EQ_TYPE
//								eq_knd_cd.SetEnable(0);
//								eq_knd_cd.SetSelectCode(ComGetEtcData(arrXml[0], "eq_knd_cd"));
//								formObj.agmt_rmk.value=ComGetEtcData(arrXml[0], "agmt_rmk");
//								//Tariff No
//								setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
//								
//								ComSetObjValue(formObj.old_agmt_no, ComGetEtcData(arrXml[0], "old_agmt_no"));
								loadAgmtHdrData(formObj, arrXml);
							}
							//Setting sheet for data
							for(var i=1; i < arrXml.length + 1; i++){
								sheetObjects[i].LoadSearchData(arrXml[i-1],{Sync:0} );
							}
							//State of retrieve
							nowRetriveSt=true;
							formObj.isversionup.value="N";
							MnrFormSetReadOnly(formObj,true,"agmt_no");
						} else {
							MnrWaitControl(true);
							retPossible=false;
							nowRetriveSt=false;
							//Initializing sheet
							for(i=0;i < sheetObjects.length;i++){
								sheetObjects[i].RemoveAll();
								sheetObjects[i].SetEditable(1);
					        }
							//Initializing combo
							for(var i=0; i < comboObjects.length;i++){
								comboObjects[i].RemoveAll();
								comboObjects[i].SetEnable(1);
							}
							formObj.isversionup.value="N";
							//Reinstating readonly field
							MnrFormSetReadOnly(formObj,false,"agmt_no|vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
							//Tariff combo
							trf_no.SetEnable(0);
							priTrfNo="";
							//Initializing form element
							formObj.vndr_seq.value="";
							formObj.vndr_nm.value="";
							formObj.pay_term_dys.value="";
							formObj.agmt_ref_no.value="";
							formObj.agmt_rmk.value="";
							//AGREEMENT NO
							formObj.agmt_no.value="NEW";
							//agmt_ver_no
							agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
							defVerCode='1';
							agmt_ver_no.SetSelectCode(defVerCode,false);
							//Retrieving combo data
							var sCondition=new Array (
							 	new Array("MdmCurrency","","COMMON"), 		//CURRENCY
								new Array("MnrOfcGenInfo","","AGMT"),	//AGMT_OFC_CD
								new Array("MnrGenCd",formObj.ctrl_ofc_cd.value,"CUSTOM9"),
								new Array("MnrGenCd","CD00016", "COMMON")
							)
							var comboList=MnrComSearchCombo(sheetObj,sCondition);
							//1  Setting currency
							if(comboList[0] != null){
								for(var j=0; j < comboList[0].length;j++){
									var tempText=comboList[0][j].split("|");
									curr_cd.InsertItem(j ,comboList[0][j] ,tempText[0]);
								}
							}
						    curr_cd.SetSelectCode("-1");
							//AGMT_OFC_CD Setting  Agreement Office
							if(comboList[1] != null){
								for(var j=0; j < comboList[1].length;j++){
									var tempText=comboList[1][j].split("|");
									agmt_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
									if(j == 0){
										defagmtOfcCdCode=tempText[0];
									}
								}
							}
							agmt_ofc_cd.SetSelectCode(defagmtOfcCdCode);
							//EQ_KND_CD Setting EQ_TYPE
							if(comboList[2] != null){
								for(var j=0; j < comboList[2].length;j++){
									var tempText=comboList[2][j].split("|");
									eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){
										defeqKndCdCode=tempText[0];
									}
								}
							}
							eq_knd_cd.SetSelectCode(defeqKndCdCode);
							//TRSM_MOD_CD
							var sheetComboText="";
							var sheetComboCode="";
							var sheetComboDefault="";
							if(comboList[3] != null){
								for(var j=0; j < comboList[3].length;j++){
									var tempText=comboList[3][j].split("|");
									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									if(j == 0){
										sheetComboDefault=tempText[0];
									}
								}
							}
							sheetComboText=MnrDelLastDelim(sheetComboText);
					        sheetComboCode=MnrDelLastDelim(sheetComboCode);
							sheetObjects[1].InitDataCombo (0, "trsm_mod_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
							var Row=sheetObjects[1].DataInsert(-1);
							sheetObjects[1].SetCellValue(Row,"agmt_ofc_tp_cd","COST",0);
							sheetObjects[1].SetCellValue(Row,"aply_ofc_cd",agmt_ofc_cd.GetSelectCode(),0);
							sheetObjects[1].SetCellValue(Row,"ctrl_ofc_cd",agmt_ofc_cd.GetSelectCode(),0);
							sheetObjects[1].SetCellValue(Row,"mnr_grp_tp_cd","RPR",0);
							sheetObjects[1].SetCellValue(Row,"mnr_prnr_tp_cd","S",0);
							sheetObjects[1].SetCellValue(Row,"mnr_prnr_knd_cd","C",0);
							sheetObjects[1].SetCellValue(Row,"mnr_prnr_sts_cd","C",0);
							//AGMT Setting sign date
							formObj.agmt_dt.value=ComGetNowInfo("ymd");
							MnrWaitControl(false);
						}
				  }
                break;
			case IBINSERT:      // Inserting sheet 1
					if(sheetObj.id == "sheet2"){
						if(formObj.vndr_seq.value == ""){
							ComShowCodeMessage("MNR00271");
							return;
						}
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row,"agmt_ofc_tp_cd","COST",0);
						sheetObj.SetCellValue(Row,"mnr_grp_tp_cd","RPR",0);
						sheetObj.SetCellValue(Row,"mnr_prnr_tp_cd","S",0);
						sheetObj.SetCellValue(Row,"mnr_prnr_knd_cd","C",0);
						sheetObj.SetCellValue(Row,"mnr_prnr_sts_cd","C",0);
						sheetObj.SetCellValue(Row,"mnr_prnr_seq",formObj.vndr_seq.value,0);
						sheetObj.SetCellValue(Row,"mnr_prnr_lgl_eng_nm",formObj.vndr_nm.value,0);
						sheetObj.SetCellValue(Row,"mnr_prnr_locl_lang_nm",formObj.vndr_nm.value,0);
						sheetObj.SetCellValue(Row,"pay_term_dys",formObj.pay_term_dys.value,0);
						sheetObj.SetCellValue(Row,"eff_dt",formObj.eff_dt.value,0);
						sheetObj.SetCellValue(Row,"exp_dt",formObj.exp_dt.value,0);
					}
					if(sheetObj.id != "sheet1" && sheetObj.id != "sheet2"){
						var tabIndex=parseInt(sheetObj.id.substr(1,1),10) - 1;
						//QT~~xx~~Z~~6~~OT~~MRZSOT~~Other
						if(eq_knd_cd.GetSelectCode()== 'U'){
							var Row=sheetObj.DataInsert(-1);
							sheetObj.SetCellValue(Row,"agmt_ofc_cty_cd",formObj.agmt_ofc_cty_cd.value,0);
							sheetObj.SetCellValue(Row,"agmt_seq",formObj.agmt_seq.value,0);
							sheetObj.SetCellValue(Row,"agmt_ver_no",agmt_ver_no.GetSelectCode(),0);
							if(uTab[tabIndex][0] == 'QT' || uTab[tabIndex][0] == 'TS'){
								sheetObj.SetCellValue(Row,"cost_cd",uTab[tabIndex][5],0);
							}
						} else if (eq_knd_cd.GetSelectCode()== 'G'){
							var Row=sheetObj.DataInsert(-1);
							sheetObj.SetCellValue(Row,"agmt_ofc_cty_cd",formObj.agmt_ofc_cty_cd.value,0);
							sheetObj.SetCellValue(Row,"agmt_seq",formObj.agmt_seq.value,0);
							sheetObj.SetCellValue(Row,"agmt_ver_no",agmt_ver_no.GetSelectCode(),0);
							if(gTab[tabIndex][0] == 'QT' || gTab[tabIndex][0] == 'TS'){
								sheetObj.SetCellValue(Row,"cost_cd",gTab[tabIndex][5],0);
							}
						} else if (eq_knd_cd.GetSelectCode()== 'Z'){
							var Row=sheetObj.DataInsert(-1);
							sheetObj.SetCellValue(Row,"agmt_ofc_cty_cd",formObj.agmt_ofc_cty_cd.value,0);
							sheetObj.SetCellValue(Row,"agmt_seq",formObj.agmt_seq.value,0);
							sheetObj.SetCellValue(Row,"agmt_ver_no",agmt_ver_no.GetSelectCode(),0);
							if(zTab[tabIndex][0] == 'QT' || zTab[tabIndex][0] == 'TS'){
								sheetObj.SetCellValue(Row,"cost_cd",zTab[tabIndex][5],0);
							}
						}
					}
                break;
			case IBDELETE:      //Deleting
					if(sheetObj.FindCheckedRow("del_check") == ""){
						ComShowCodeMessage("MNR00038","DELETE");
						return false;             	   
					}
					MnrRowDelete(sheetObj, "del_check");
					break;
                break;
			case IBRESET:      //Retrieving menu structure
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", FormQueryString(formObj));
				//0 mnr_ord_tp_cd|1 ibflag|2 eq_type|3 dp_seq|4 tab_title|5 pagerows
				var arrResult=MnrXmlToArray(sXml);
				var uCnt=0;
				var gCnt=0;
				var zCnt=0;
				if(arrResult != null){
					for(var i=0; i < arrResult.length;i++){
						if(arrResult[i][2] == "U"){
							uTab[uCnt++]=arrResult[i];
						}
						if(arrResult[i][2] == "Z"){
							zTab[zCnt++]=arrResult[i];
						}
						if(arrResult[i][2] == "G"){
							gTab[gCnt++]=arrResult[i];
						}
					}
				}
				var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
				if(arrXml != null){
	 			    for(var i=0; i < arrXml.length; i++){
						if(i == 0){
							uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 1){
							zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						} else if(i == 2){
							gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
						}
				    }
				}
				break;
			case IBCLEAR:      //Initializing
				MnrWaitControl(true);
				loadIbclear=true;
				retPossible=false;
				nowRetriveSt=false;
				//Initializing sheet
				for(i=0;i < sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
					sheetObjects[i].SetEditable(1);
		        }
				//Initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].RemoveAll();
					comboObjects[i].SetEnable(1);
				}
				formObj.isversionup.value="N";
				//Reinstating readonly field
				MnrFormSetReadOnly(formObj,false,"agmt_no|vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
				//Tariff combo
				trf_no.SetEnable(0);
				priTrfNo="";
				formObj.vndr_seq.value="";
				formObj.vndr_nm.value="";
				formObj.pay_term_dys.value="";
				formObj.agmt_ref_no.value="";
				formObj.agmt_rmk.value="";
				//AGREEMENT NO
				formObj.agmt_no.value="NEW";
				//agmt_ver_no
				agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
				defVerCode='1';
				agmt_ver_no.SetSelectCode(defVerCode,false);
				//Retrieving combo data
				var sCondition=new Array (
				 	new Array("MdmCurrency","","COMMON"), 		//CURRENCY
					new Array("MnrOfcGenInfo","","AGMT"),	//AGMT_OFC_CD
					new Array("MnrGenCd",formObj.ctrl_ofc_cd.value,"CUSTOM9"),
					new Array("MnrGenCd","CD00016", "COMMON")
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//1  Setting currency
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						curr_cd.InsertItem(j ,comboList[0][j] ,tempText[0]);
					}
				}
			    curr_cd.SetSelectCode("-1");
				//AGMT_OFC_CD Setting Agreement Office
				if(comboList[1] != null){
					for(var j=0; j < comboList[1].length;j++){
						var tempText=comboList[1][j].split("|");
						agmt_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
						if(j == 0){
							defagmtOfcCdCode=tempText[0];
						}
					}
				}
				agmt_ofc_cd.SetSelectCode(defagmtOfcCdCode);
				//EQ_KND_CD Setting EQ_TYPE
				if(comboList[2] != null){
					for(var j=0; j < comboList[2].length;j++){
						var tempText=comboList[2][j].split("|");
						eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
						if(j == 0){
							defeqKndCdCode=tempText[0];
						}
					}
				}
				eq_knd_cd.SetSelectCode(defeqKndCdCode);
				//TRSM_MOD_CD
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault="";
				if(comboList[3] != null){
					for(var j=0; j < comboList[3].length;j++){
						var tempText=comboList[3][j].split("|");
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						if(j == 0){
							sheetComboDefault=tempText[0];
						}
					}
				}
				sheetComboText=MnrDelLastDelim(sheetComboText);
		        sheetComboCode=MnrDelLastDelim(sheetComboCode);
				sheetObjects[1].InitDataCombo (0, "trsm_mod_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
				var Row=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(Row,"agmt_ofc_tp_cd","COST",0);
				sheetObjects[1].SetCellValue(Row,"aply_ofc_cd",agmt_ofc_cd.GetSelectCode(),0);
				sheetObjects[1].SetCellValue(Row,"ctrl_ofc_cd",agmt_ofc_cd.GetSelectCode(),0);
				sheetObjects[1].SetCellValue(Row,"mnr_grp_tp_cd","RPR",0);
				sheetObjects[1].SetCellValue(Row,"mnr_prnr_tp_cd","S",0);
				sheetObjects[1].SetCellValue(Row,"mnr_prnr_knd_cd","C",0);
				sheetObjects[1].SetCellValue(Row,"mnr_prnr_sts_cd","C",0);
				//AGMT Setting sign date
				formObj.agmt_dt.value=ComGetNowInfo("ymd");
				formObj.eff_dt.value="";
				formObj.exp_dt.value="";
				formObj.agmt_ofc_cty_cd.value = "";
				formObj.agmt_seq.value = "";
				formObj.cre_usr_id.value = "";
				formObj.cre_dt.value = "";
				formObj.upd_usr_id.value = "";
				formObj.upd_dt.value = "";
				loadIbclear=false;
				MnrWaitControl(false);
                break;
			case IBSEARCH_ASYNC01:	//Retrieving(sevice provider No. At inserting)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					//Service Provider Detail Information
					var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
					if(ComGetEtcData(sXml, "vndr_seq") != null){
						//Setting vendor name
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
						//Setting Curr
						curr_cd.SetSelectCode(ComGetEtcData(sXml, "pay_curr_cd"));
						//Setting PAY TERM
						var tempPayTerm=ComGetEtcData(sXml, "gen_pay_term_cd");
						if(tempPayTerm != ""){
							if("O60" == tempPayTerm || "O45" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"0");
							} else if ("IN" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"5");
							} else if ("OUT" == tempPayTerm){
								ComSetObjValue(formObj.pay_term_dys,"60");
							} else {
								ComSetObjValue(formObj.pay_term_dys,tempPayTerm);
							}
						}
						trf_no.SetEnable(1);
						for(var i=1; i <= sheetObjects[1].LastRow();i++){
							sheetObjects[1].SetCellValue(i,"mnr_prnr_seq",ComGetEtcData(sXml, "vndr_seq"),0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_lgl_eng_nm",ComGetObjValue(formObj.vndr_nm),0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_locl_lang_nm",ComGetObjValue(formObj.vndr_nm),0);
							sheetObjects[1].SetCellValue(i,"pay_term_dys",ComGetObjValue(formObj.pay_term_dys),0);
						}
					} else {
						ComShowCodeMessage("MNR00005", "Service Provider");
						ComSetObjValue(formObj.vndr_nm, "");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
						ComSetObjValue(formObj.pay_term_dys,"0");
						curr_cd.SetSelectCode("");
						trf_no.SetEnable(0);
						for(var i=1; i <= sheetObjects[1].LastRow();i++){
							sheetObjects[1].SetCellValue(i,"mnr_prnr_seq","",0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_lgl_eng_nm","",0);
							sheetObjects[1].SetCellValue(i,"mnr_prnr_locl_lang_nm","",0);
							sheetObjects[1].SetCellValue(i,"pay_term_dys","",0);
						}
					}
				}
				break;
				case IBSEARCH_ASYNC02:	//Retrieving(agreement no at inserting)
					var sCondition=new Array (
						new Array("MnrAgmtHdr",formObj.agmt_no.value,formObj.local_ofc_cd.value)
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					agmt_ver_no.RemoveAll();
					if(comboList[0] != null){
				 		for(var j=0; j < comboList[0].length;j++){
							var tempText=comboList[0][j].split("|");
							agmt_ver_no.InsertItem(j, comboList[0][j] ,tempText[0]);
							if(j == 0){
								defVerCode=tempText[0];
							}
						}
						agmt_ver_no.SetSelectCode(defVerCode,false);
						//********************** IBSEARCH START  **********************//
						if(validateForm(sheetObj,formObj,IBSEARCH)){
							for(i=0;i<sheetObjects.length;i++){
				            	sheetObjects[i].RemoveAll();
				         	}
		          			formObj.f_cmd.value=SEARCH;
							var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do", FormQueryString(formObj));
							var arrXml=sXml.split("|$$|");
							if(arrXml[0] != null){
								//vndr
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(arrXml[0], "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(arrXml[0], "vndr_nm"));
								//version no
								agmt_ver_no.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ver_no"),false);
								//currency
								curr_cd.SetSelectCode(ComGetEtcData(arrXml[0], "curr_cd"),false);
								//agmt_ofc_cd
								agmt_ofc_cd.SetSelectCode(ComGetEtcData(arrXml[0], "agmt_ofc_cd"),false);
								//eff dt
								ComSetObjValue(formObj.eff_dt, ComGetEtcData(arrXml[0], "eff_dt"));
								ComSetObjValue(formObj.exp_dt, ComGetEtcData(arrXml[0], "exp_dt"));
								//pay_term_dys
								ComSetObjValue(formObj.pay_term_dys, ComGetEtcData(arrXml[0], "pay_term_dys"));
								//agmt sign dt
								ComSetObjValue(formObj.agmt_dt, ComGetEtcData(arrXml[0], "agmt_dt"));
								//agmt_ref_no
								ComSetObjValue(formObj.agmt_ref_no, ComGetEtcData(arrXml[0], "agmt_ref_no"));
								//EQ_TYPE
								eq_knd_cd.SetEnable(0);
								eq_knd_cd.SetSelectCode(ComGetEtcData(arrXml[0], "eq_knd_cd"));
								formObj.agmt_rmk.value=ComGetEtcData(arrXml[0], "agmt_rmk");
								//Tariff No
								setTrfCombo(ComGetEtcData(arrXml[0], "trf_no"));
								ComSetObjValue(formObj.old_agmt_no, ComGetEtcData(arrXml[0], "old_agmt_no"));
								
								ComSetObjValue(formObj.cre_usr_id, ComGetEtcData(arrXml[0], "cre_usr_id"));
								ComSetObjValue(formObj.cre_dt, ComGetEtcData(arrXml[0], "cre_dt"));
								ComSetObjValue(formObj.upd_usr_id, ComGetEtcData(arrXml[0], "upd_usr_id"));
								ComSetObjValue(formObj.upd_dt, ComGetEtcData(arrXml[0], "upd_dt"));
//								loadAgmtHdrData(formObj, arrXml);
							}
							//Setting sheet for data
							for(var i=1; i < arrXml.length + 1; i++){
								sheetObjects[i].LoadSearchData(arrXml[i-1],{Sync:0} );
							}
							//State of retrieve
							nowRetriveSt=true;
							//
							formObj.isversionup.value="N";
							MnrFormSetReadOnly(formObj,true,"agmt_no");
						}
						//********************** IBSEARCH END  **********************//
					} else {
						//Setting agmt_ver_no
						agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
						agmt_ver_no.SetSelectCode('1',false);
						defVerCode='1';
						ComShowCodeMessage("MNR00165","data");
						ComSetObjValue(formObj.agmt_no, "");
						ComSetFocus(formObj.agmt_no);
						return false;
					}
					retPossible=true;
				break;
			case IBSEARCH_ASYNC03:      //Retrieving tariff combo
				if(formObj.vndr_seq.value != ""){
					trf_no.RemoveAll();
					var ofcCd=formObj.local_ofc_cd.value;
					var mnrTrfKndCd="LCL";
					var creDtFr=ComGetDateAdd(ComGetNowInfo("ymd"), "y", -1);
					var creDtTo=ComGetNowInfo('ymd');
					var eqKndCd=eq_knd_cd.GetSelectCode();
					var mnrTrfStsCd="HA";
					var vndrSeq=formObj.vndr_seq.value;
					var f_query="";
					f_query += 'f_cmd' + '=' + SEARCH03	+ '&';
					f_query += 'ibflag=X&';
					f_query += 'ofc_cd' + '=' + ofcCd + "&";
					f_query += 'mnr_trf_knd_cd' + '=' + mnrTrfKndCd + "&";
					f_query += 'cre_dt_fr' + '=' + creDtFr + "&";
					f_query += 'cre_dt_to' + '=' + creDtTo + "&";
					f_query += 'eq_knd_cd' + '=' + eqKndCd + "&";
					f_query += 'mnr_trf_sts_cd' + '=' + mnrTrfStsCd + "&";
					f_query += 'vndr_seq' + '=' + vndrSeq;
					var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do",f_query);
					//0 mnr_trf_sts_nm|1 vndr_seq|2 vndr_nm|3 agmt_no|4 rqst_ofc_cd|5 pagerows|6 eff_dt|7 curr_cd|8 ibflag|9 cre_dt|10 mnr_meas_ut_cd|11 mnr_trf_knd_nm|12 upd_usr_id|13 apro_ofc_cd|14 cre_usr_id|15 mnr_trf_sts_dt|16 mnr_trf_knd_cd|17 sts_ref_no|18 mnr_trf_rmk|19 trf_no|20 cre_usr_nm|21 eq_knd_nm|22 mnr_inp_tp_cd|23 mnr_trf_sts_cd|24 eq_knd_cd|25 mnr_meas_ut_nm|26 upd_dt|27 pre_trf_no
					var arrResult=MnrXmlToArray(sXml);
					var defSelTrfNo="";
					trf_no.InsertItem(0," "," ");
					if(arrResult != null){
						for(var i=0; i < arrResult.length;i ++){
							if(i == 0){
								defSelTrfNo=arrResult[i][19];
							}
							var tempComboText=arrResult[i][19] + "|" + arrResult[i][11] + "|" + arrResult[i][2] + "|" + arrResult[i][21] + "|" + arrResult[i][0] + "|" + arrResult[i][6] + "|" + arrResult[i][25] + "|" + arrResult[i][7];
							trf_no.InsertItem(i + 1, tempComboText ,arrResult[i][19]);
						}
					}
					trf_no.SetSelectCode(defSelTrfNo);
				}
				break;
			case IBSEARCH_ASYNC04:
				 	var agmtOfcCtyCd=formObj.agmt_ofc_cty_cd.value;
				 	var agmtSeq=formObj.agmt_seq.value;
				 	var agmtVerNo=agmt_ver_no.GetSelectCode();
					var f_query="";
					f_query += 'f_cmd' + '=' + SEARCH04	+ '&';
					f_query += 'ibflag=X&';
					f_query += 'agmt_ofc_cty_cd' + '=' + agmtOfcCtyCd + "&";
					f_query += 'agmt_seq' + '=' + agmtSeq + "&";
					f_query += 'agmt_ver_no' + '=' + agmtVerNo;
					var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do",f_query);
					var searchResult=ComGetEtcData(sXml, "EST_LIST");
					if(searchResult != null && searchResult != ''){
						checkEstList=searchResult;
					} else {
						checkEstList="XX";
					}
				break;
			case IBSEARCH_ASYNC05:      //Checking existing unapproved estimate before saving up version
				 	var agmtOfcCtyCd=formObj.agmt_ofc_cty_cd.value;
				 	var agmtSeq=formObj.agmt_seq.value;
				 	var agmtVerNo=agmt_ver_no.GetSelectCode();
					var f_query="";
					f_query += 'f_cmd' + '=' + SEARCH05	+ '&';
					f_query += 'ibflag=X&';
					f_query += 'agmt_ofc_cty_cd' + '=' + agmtOfcCtyCd + "&";
					f_query += 'agmt_seq' + '=' + agmtSeq + "&";
					f_query += 'agmt_ver_no' + '=' + agmtVerNo;
					var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do",f_query);
					var searchResult=ComGetEtcData(sXml, "EST_LIST");
					if(searchResult != null && searchResult != ''){
						notApprovalEstList=searchResult;
					} else {
						notApprovalEstList="XX";
					}
					
				break;
				
			case IBSEARCH_ASYNC06:      //Checking existing unapproved estimate before saving up version
				formObj.f_cmd.value=SEARCH06;
				var sXml=sheetObj.GetSearchData("EES_MNR_0015GS.do",FormQueryString(formObj));
				var searchResult=ComGetEtcData(sXml, "agmt_no");
				if(searchResult != null && searchResult != ''){
					ComShowCodeMessage("MNR00383", searchResult);
					return false;
				}
				return true;
				
			break;
        }
    }
    
    /**
     * Tab Setting default
     * Setting tab's item
     */
    function initTab(tabObj ,disPlayArray ) {
		 with(tabObj){
		 	 RemoveAll();
			 var cnt=0 ;
			 for(var j=0; j < disPlayArray.length;j++){
				 InsertItem( disPlayArray[j][6] , "");
				 $("#sheet_title"+(j+1)).html(disPlayArray[j][8]);
		   	 }
		 }
		 tabObj.SetSelectedIndex(0);
    }
 	/**
	 * function of receiving COM_ENS_071 screen data
	 */
	function getCOM_ENS_071(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
		  	sheetObjects[1].SetCellValue(row,col,aryPopupData[0][3]);
		 }
    }
    /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
	    	objs[nItem].style.display="Inline";
	    	objs[beforetab].style.display="none";
	    	//--------------- Important logic --------------------------//
	    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	    	//------------------------------------------------------//
	    	beforetab=nItem;
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        	switch(sAction) {
				case IBSAVE:
					//Checking mandatory input data
					ComSetFocus(formObj.agmt_no);
					//Transmission Mode from E,F,M,W
					for(i=1;i <= sheetObjects[1].LastRow();i++){
						if(sheetObjects[1].GetCellValue(i,"trsm_mod_cd") == "E"){
							if(sheetObjects[1].GetCellValue(i,"edi_id") == ""){
								ComShowCodeMessage("MNR00003", "EDI ID");
								sheetObjects[1].SelectCell(i, "edi_id", true);
								return false;
							}
						} else if(sheetObjects[1].GetCellValue(i,"trsm_mod_cd") == "F"){
							if(sheetObjects[1].GetCellValue(i,"fax_no") == ""){
								ComShowCodeMessage("MNR00003", "FAX_NO");
								sheetObjects[1].SelectCell(i, "fax_no", true);
								return false;
							}
						} else if(sheetObjects[1].GetCellValue(i,"trsm_mod_cd") == "M"){
							if(sheetObjects[1].GetCellValue(i,"mnr_prnr_eml") == ""){
								ComShowCodeMessage("MNR00003", "E-MAIL");
								sheetObjects[1].SelectCell(i, "mnr_prnr_eml", true);
								return false;
							}
						} else if(sheetObjects[1].GetCellValue(i,"trsm_mod_cd") == "W"){
							if(sheetObjects[1].GetCellValue(i,"sp_ptal_id") == ""){
								ComShowCodeMessage("MNR00003", "WEB ID");
								sheetObjects[1].SelectCell(i, "sp_ptal_id", true);
								return false;
							}
						}
					}
					var checkSheetDataCnt=false;
					for(i=2;i < sheetObjects.length;i++){
		            	if(sheetObjects[i].RowCount()> 0){
							checkSheetDataCnt=true;
						}
		         	}
					if(!checkSheetDataCnt){
						ComShowCodeMessage("MNR00195");
						return false;
					}
					if(curr_cd.GetSelectCode()== ""){
						ComShowCodeMessage("MNR00172","Currency ");
						curr_cd.focus();
						return false;
					}
					if(sheetObjects[1].LastRow()<= 0 ){
						ComShowCodeMessage("MNR00187");
						return false;
					}
					if(sheetObjects[1].IsDataModified()){
						var Row=sheetObjects[1].ColValueDup("aply_ofc_cd");
						if(Row > 0){
							ComShowCodeMessage("MNR00006", "Cost CTRL Office Sheet of " + Row + " row ");
							sheetObjects[1].SelectCell(Row, "aply_ofc_cd", true);
							return false;
						}
					}
					var targetTab=new Array();
					if(eq_knd_cd.GetSelectCode()== 'U'){
						targetTab=uTab;
					} else if (eq_knd_cd.GetSelectCode()== 'G'){
						targetTab=gTab;
					} else if (eq_knd_cd.GetSelectCode()== 'Z'){
						targetTab=zTab;
					}
					var sheetBugMod=0;
					var checkCol="";
					for (var i=2; i < targetTab.length + 2; i++){
						if(sheetObjects[i].IsDataModified()){
							if(sheetObjects[i].HeaderRows()> 1){
								sheetBugMod=1 - sheetObjects[i].HeaderRows();
							} else {
								sheetBugMod=0;
							}
							if(targetTab[i - 2][0] == "LB"){
								checkCol="cost_cd|cost_dtl_cd|yd_cd|usr_def_rmk";
							} else if(targetTab[i - 2][0] == "QT"){
								checkCol="cost_dtl_cd|yd_cd|usr_def_rmk";
							} else if(targetTab[i - 2][0] == "TS"){
								checkCol="cost_dtl_cd|mnr_rt_tp_cd|yd_cd|usr_def_rmk";
							}
							var Row=sheetObjects[i].ColValueDup(checkCol);
							if(Row > 0){
								ComShowCodeMessage("MNR00006", targetTab[i - 2][6] + " tab of " + (Row + sheetBugMod) + " row ");
								tabObjects[0].SetSelectedIndex(i - 2);
								sheetObjects[i].SelectCell(Row, "mnr_rt_tp_cd", true);
								return false;
							}
						}
						
						for(var j = sheetObjects[i].HeaderRows(); j <= sheetObjects[i].LastRow(); j++){
							if(sheetObjects[i].GetCellValue(j, "yd_cd") == ""){
								ComShowCodeMessage("MNR00003", "Yard Code");
								tabObjects[0].SetSelectedIndex(i - 2);
								sheetObjects[i].SelectCell(j, "yd_cd");
								return false;
							}
						}
					}
					//Checking mandatory input data
					if (!ComChkValid(formObj)) return false;
					// 2013-08-27 Recovery PQC test defects by J.H Han
					if(ComGetDaysBetween(formObj.eff_dt.value, formObj.exp_dt.value) < 0){
						ComShowCodeMessage("MNR00366");
						ComClearSeparator(formObj.eff_dt);
						ComSetFocus(formObj.eff_dt);
						return;
					}
//					for(var i=2 ; i < sheetObjects.length ; i++){
//						for(var j = sheetObjects[i].HeaderRows(); j <= sheetObjects[i].LastRow(); j++){
//							if(sheetObjects[i].GetCellValue(j, "yd_cd") == ""){
//								ComShowCodeMessage("MNR00003", "Yard Code");
//								tabObjects[0].SetSelectedIndex(i - 2);
//								sheetObjects[i].SelectCell(j, "yd_cd");
//								return false;
//							}
//						}
//					}
					if(doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC06)){
						if(trf_no.GetSelectCode()== ""){
							if (!ComShowCodeConfirm("MNR00202")){return false;}
						} else {
							if (!ComShowCodeConfirm("MNR00183")){return false;}
						}
					}else{
						return false;
					}
					return true;
					break;
				case IBCREATE:
					if( formObj.agmt_no.value == "" || formObj.agmt_no.value == "NEW") {
						ComShowCodeMessage("MNR00172","Agreement No For Version()Up ");
        				ComSetFocus(formObj.agmt_no);
        				return false;
        			} else if ( agmt_ver_no.GetSelectCode()== "") {
        				ComShowCodeMessage("MNR00172","Version()()No For VersionUp ");
        				agmt_ver_no.focus();
        				return false;
        			} else {
						formObj.agmt_ofc_cty_cd.value=formObj.agmt_no.value.substring(0,3);
						formObj.agmt_seq.value=parseInt(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length),10);
						return true;
					}
					break;
				//IBSEARCHAPPEND => Deleting (Lack of variables)
				case IBSEARCHAPPEND:
					if( formObj.agmt_no.value == "" || formObj.agmt_no.value == "NEW") {
        				ComShowCodeMessage("MNR00047");
        				ComSetFocus(formObj.agmt_no);
        				return false;
        			} else if ( agmt_ver_no.GetSelectCode()== "") {
        				ComShowCodeMessage("MNR00047");
        				agmt_ver_no.focus();
        				return false;
        			} else {
						formObj.agmt_ofc_cty_cd.value=formObj.agmt_no.value.substring(0,3);
						formObj.agmt_seq.value=parseInt(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length),10);
						if(checkEstList != 'XX'){
							ComShowCodeMessage("MNR00342",checkEstList);
							return false;
						} else {
							if(!ComShowCodeConfirm("MNR00046")){return false;}
						}
						return true;
					}
					break;
				case IBSEARCH:
        			if( formObj.agmt_no.value == ""  || formObj.agmt_no.value == "NEW") {
        				ComShowCodeMessage("MNR00172","Agreement No For Search ");
        				ComSetFocus(formObj.agmt_no);
        				return false;
        			} else if ( agmt_ver_no.GetSelectCode() == ""  ) {
        				ComShowCodeMessage("MNR00172","Version()No For Search ");
        				agmt_ver_no.focus();
        				return false;
        			} else {
						formObj.agmt_ofc_cty_cd.value=formObj.agmt_no.value.substring(0,3);
						formObj.agmt_seq.value=parseInt(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length),10);
						return true;
					}
        			break;
				case IBSEARCH_ASYNC01:
        			if( ComGetObjText(formObj.vndr_seq) == "" ) {
        				ComShowCodeMessage("MNR00172","Service Provider Seq ");
        				ComSetFocus(formObj.vndr_seq);
        				return false;
        			}
        			break;
			}
		
        return true;
    }
	function setComboEnable(changeValue){
		var formObj=document.form;
    	for(var i=1; i < comboObjects.length;i++){
			comboObjects[i].SetEnable(changeValue);
		}
		if(changeValue == true){
			if(formObj.vndr_seq.value == ""){
				trf_no.SetEnable(0);
			} else {
				trf_no.SetEnable(1);
			}
		}
		if(nowRetriveSt == true){
			eq_knd_cd.SetEnable(0);
		} else {
			eq_knd_cd.SetEnable(1);
		}
	}
	/**
	 * Setting and retrieving
	 */
	function setTrfCombo(trfNo){
		var formObj=document.form;
		if(formObj.vndr_seq.value == ""){
			trf_no.SetEnable(0);
			trf_no.RemoveAll();
			trf_no.SetSelectCode("",false);
		} else {
			trf_no.SetEnable(1);
			if(agmt_ver_no.GetSelectCode()== defVerCode){
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
				trf_no.SetSelectCode(trfNo,false);
			} else {
				trf_no.RemoveAll();
				trf_no.InsertItem(0,trfNo,trfNo);
				trf_no.SetSelectCode(trfNo,false);
			}
		}
		if(agmt_ver_no.GetSelectCode()== defVerCode){
			trf_no.SetEnable(1);
		} else {
			trf_no.SetEnable(0);
		}
	}
	function trf_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		var selCurrCd=ComTrim(comboObj.GetText(parseInt(newIndex), 7));
		var priCurrCd=ComTrim(curr_cd.GetSelectCode());
		if(newIndex != ""){
			var formObj=document.form;
			if(selCurrCd != priCurrCd) {
				var usrOk=ComShowCodeConfirm("MNR00203",selCurrCd);
				if(usrOk){
					curr_cd.SetSelectCode(selCurrCd,false);
					ComSetFocus(formObj.agmt_ref_no);
				} else {
					trf_no.SetSelectCode(priTrfNo,false);
					ComSetFocus(formObj.agmt_ref_no);
				}
			}
		}
		priTrfNo=trf_no.GetSelectCode();
	}
	function agmt_ver_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		if(comboObj.GetSelectCode()== defVerCode){
			if(!loadIbclear){
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_del");
				ComBtnEnable("btn_versionup");
				ComBtnEnable("btn_add");
				ComBtnEnable("btn_s1del");
				ComBtnEnable("btn_calendar");
				ComBtnEnable("btn_calendar1");
				for(var i = 0; i < tabObjects[0].GetCount(); i++){
					ComBtnEnable("btn_t"+(i+1)+"add");
					ComBtnEnable("btn_t"+(i+1)+"del");
				}
			}
			MnrFormSetReadOnly(formObj,false,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
			setComboEnable(true);
			for(var i=1; i < sheetObjects.length; i++){
				sheetObjects[i].SetEditable(1);
			}
		} else {
			if(!loadIbclear){
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_del");
				ComBtnDisable("btn_versionup");
				ComBtnDisable("btn_add");
				ComBtnDisable("btn_s1del");
				ComBtnDisable("btn_calendar");
				ComBtnDisable("btn_calendar1");
				
			}
			MnrFormSetReadOnly(formObj,true,"vndr_seq|eff_dt|exp_dt|pay_term_dys|agmt_dt|agmt_ref_no|agmt_rmk");
			setComboEnable(false);
			for(var i=1; i < sheetObjects.length; i++){
				sheetObjects[i].SetEditable(0);
			}
		}
		if(formObj.agmt_no.value != "NEW" && formObj.agmt_no.value != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	//Event handling of changed EQ_TYPE Combo
	function eq_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		if(formObj.agmt_no.value == "NEW"){
			var cnt=0;
			for (var i=2; i < sheetObjects.length; i++){
				cnt += sheetObjects[i].RowCount();
			}
			if(cnt > 0) {
				if(!ComShowCodeConfirm("MNR00192")) {
					eq_knd_cd.SetSelectCode(tempEqKndCd,false);
					return;
				}
			}
		}
        var objs=document.all.item("tabLayer");
		tempEqKndCd=comboObj.GetSelectCode();
		//mnr_ord_tp_cd|ibflag|eq_type|dp_seq|tab_type|cost_cd|tab_title|pagerows
		//QT~~I~~Z~~6~~OT~~MRZSOT~~Other
		objs[beforetab].style.display="none";
		ComOpenWait(true,true);
		if(comboObj.GetSelectCode()== 'U'){
			for(var i=0; i < uTab.length ; i++){
				sheetObjects[i + 2] = sheetObjects[i + 2].Reset();
//				sheetObjects[i + 2].Render(1);
				ComConfigSheet(sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],uTab[i][0],comboObj.GetSelectCode(),uTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],uTab);
			formObj.agmt_type_tpsz.value=ComGetAryJoin(uTpSz, "|");
		} else if (comboObj.GetSelectCode()== 'G'){
			for(var i=0; i < gTab.length ; i++){
				sheetObjects[i + 2] = sheetObjects[i + 2].Reset();
//				sheetObjects[i + 2].Render(1);
				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],gTab[i][0],comboObj.GetSelectCode(),gTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],gTab);
			formObj.agmt_type_tpsz.value=ComGetAryJoin(gTpSz, "|");
		} else if (comboObj.GetSelectCode()== 'Z'){
			for(var i=0; i < zTab.length ; i++){
				sheetObjects[i + 2] = sheetObjects[i + 2].Reset();
//				sheetObjects[i + 2].Render(1);
				ComConfigSheet (sheetObjects[i + 2]);
				initSheet(sheetObjects[i + 2],zTab[i][0],comboObj.GetSelectCode(),zTab[i][4]);
				ComEndConfigSheet(sheetObjects[i + 2]);
			}
			initTab(tabObjects[0],zTab);
			formObj.agmt_type_tpsz.value=ComGetAryJoin(zTpSz, "|");
		}
		sheetObjects[2].RemoveAll();
//		var sCode=sheetObjects[2].GetComboInfo(0,"cost_cd", "Code");
//		var arrCode=sCode.split("|");
//		for(var i=0;i < arrCode.length;i++){
//			var Row=sheetObjects[2].DataInsert(-1);
//			sheetObjects[2].SetCellEditable(Row,"cost_cd",0);
//			sheetObjects[2].SetCellValue(Row,"cost_cd",arrCode[i],0);
//		}
		ComOpenWait(false,true);
		objs[beforetab].style.display="inline";
		if(eq_knd_cd.GetEnable()== true){
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
		}
	}
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
          ComShowCodeMessage("MNR00020",ErrMsg);
      	} else {
          ComShowCodeMessage("MNR00048",ErrMsg);
		}
	}
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
          ComShowCodeMessage("MNR00023",ErrMsg);
      	} else {
          ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	//Validating office code
	function sheet2_OnChange(sheetObj,Row, Col, Value)	{
		var retArray=null;
		if (sheetObj.ColSaveName(Col) == "aply_ofc_cd"){
			doCheckOffice(sheetObj,Row,Col);
		}
	}
	function doCheckOffice(sheetObj,Row,Col){
		var checkOffice=sheetObj.GetCellValue(Row ,Col);
	    retArray=MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",checkOffice);
			sheetObj.SetCellValue(Row ,Col,"",0);
			sheetObj.SelectCell(Row ,Col);
		} else {
			sheetObj.SetCellValue(Row ,"ctrl_ofc_cd",sheetObj.GetCellValue(Row ,Col));
			return;
		}
	}
	function t1sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=0;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1');
    }
	function t2sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=1;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	function t3sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=2;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	function t4sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=3;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	function t5sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=4;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	function t6sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=5;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	function t7sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=6;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	function t8sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t9sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t10sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t11sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t12sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t13sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t14sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t15sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t16sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t17sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t18sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t19sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	
	function t20sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) != "mnr_rt_tp_cd") return;
		tabIndex=7;
		var disPlayTpSz=new Array();
		var disPlayTab=new Array();
		if(eq_knd_cd.GetSelectCode()== 'U'){
			disPlayTpSz=uTpSz;
			disPlayTab=uTab;
		} else if(eq_knd_cd.GetSelectCode()== 'G'){
			disPlayTpSz=gTpSz;
			disPlayTab=gTab;
		} else if(eq_knd_cd.GetSelectCode()== 'Z'){
			disPlayTpSz=zTpSz;
			disPlayTab=zTab;
		}
		var prefixValue=sheetObj.GetCellValue(Row,"cost_dtl_cd");
		var checkedList="";
//		for(var x=1 ; x <= sheetObj.RowCount();x++){
//			if(prefixValue == sheetObj.GetCellValue(x,"cost_dtl_cd")){
//				checkedList=checkedList + (sheetObj.GetCellValue(x,"mnr_rt_tp_cd") + "|");
//			}
//		}
		checkedList=MnrDelLastDelim(checkedList);
		var param="?prefix=" + prefixValue + "&checked=" + checkedList + "&sheet_id=" + (tabIndex + 2) + "&temp_value1=" + disPlayTab[tabIndex][5] + "&returntitle=TP/SZ SELECT POPUP&presetData=" + ComGetAryJoin(disPlayTpSz, "|");
		ComOpenPopup('EES_MNR_PRESETMULTI.do' + param, 400, 413, 'getMnr_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	function t1sheet1_OnChange(sheetObj,Row, Col, Value)	{
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	function t2sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	function t3sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	function t4sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	function t5sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	function t6sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	function t7sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	function t8sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t9sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t10sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t11sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t12sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t13sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t14sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t15sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t16sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t17sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t18sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t19sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function t20sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "mnr_rt_tp_cd"){
			var disPlayTpSz=new Array();
			if(eq_knd_cd.GetSelectCode()== 'U'){
				disPlayTpSz=uTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'G'){
				disPlayTpSz=gTpSz;
			} else if(eq_knd_cd.GetSelectCode()== 'Z'){
				disPlayTpSz=zTpSz;
			}
			var checkResult=false;
			for(var i=0; i < disPlayTpSz.length ; i++){
				if(disPlayTpSz[i] == Value){
					checkResult=true;
				}
			}
			if(!checkResult){
				ComShowCodeMessage("MNR00165",Value);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col, true);
			}
		}
		
		if(sheetObj.ColSaveName(Col) == "yd_cd"){
			if(Value.length == 7){
				var checkYard=sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value.length == 5){
				var checkLoc =sheetObj.GetCellValue(Row ,Col);
			    retArray=MnrGeneralCodeCheck(sheetObj,"MLOC",checkLoc);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkLoc,"Location");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}else if(Value == "ALL"){
				return;
			}else{
				ComShowCodeMessage("MNR00384");
				sheetObj.SetCellValue(Row ,Col,"",0);
				sheetObj.SelectCell(Row ,Col);
			}
			
		}
	}
	
	function sheet2_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "aply_ofc_cd") return;
		var param="?row=" + row + "&col=" + col;
		ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 520, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1', true);
    }
	/**
	 * function of receiving EES_MNR_0016 screen data
	 */
	function setEES_MNR_0016(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][6] != null && aryPopupData[0][6] != "") {
    	 	formObj.agmt_no.value=aryPopupData[0][6];
		 }
		 doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
	}
	function getMnr_psMulti(aryPopupData,sheet_id,temp_value1){
		//temp value : 0 -> cost_dtl_cd,1 -> cost_cd
		var tempVals=temp_value1.split("|");
		var formObj=document.form;
		var targetSheet=sheetObjects[sheet_id];
		var startpoint=targetSheet.RowCount();
		for(var i=startpoint; i >= 1 ; i--){
			if(targetSheet.GetCellValue(i,"mnr_rt_tp_cd")	== ""){
				targetSheet.RowDelete(i, false);
			}
		}
		for(var j=0; j < aryPopupData.length ; j++){
//			var isHaveTpSz=false;
//			for(var i=1;i <= targetSheet.RowCount();i++){
//				if(targetSheet.GetCellValue(i,"cost_dtl_cd") == tempVals[0] && targetSheet.GetCellValue(i,"mnr_rt_tp_cd") == aryPopupData[j]){
//					isHaveTpSz=true;
//				}
//			}
//			if(!isHaveTpSz){
				var Row=targetSheet.DataInsert(-1);
				targetSheet.SetCellValue(Row,"agmt_ofc_cty_cd",formObj.agmt_ofc_cty_cd.value,0);
				targetSheet.SetCellValue(Row,"agmt_seq",formObj.agmt_seq.value,0);
				targetSheet.SetCellValue(Row,"agmt_ver_no",agmt_ver_no.GetSelectCode(),0);
				targetSheet.SetCellValue(Row,"mnr_rt_tp_cd",aryPopupData[j],0);
				targetSheet.SetCellValue(Row,"cost_cd",tempVals[1],0);
				targetSheet.SetCellValue(Row,"cost_dtl_cd",tempVals[0],0);
//			}
		}
		if(targetSheet.RowCount()> 1){
			targetSheet.SelectCell(1, "agmt_rt_amt", false);
		}
	}
	
	/**
	 * (Service Provider) Pop-up Return Value<br>
	 * @param {arry} returnedValues Pop-up Screen Return value array
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 * @param Sheet Array index
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=ComLpad(aryPopupData[0][2],6,"0");
			formObj.vndr_nm.value=aryPopupData[0][4];
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
			
		}
	}
	function initControl() {
	    //Axon event handling 1. Catching event
		var formObject=document.form;
//	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
//	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject,	'agmt_no');
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
		axon_event.addListenerFormat('change',	 'obj_change',	formObject);
	}
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
//	    ComChkObjValid(event.srcElement);
		var obj=ComGetEvent();
		var formObj=document.form;
//		var sheetObj = sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
				case "eff_dt":
					ComAddSeparator(obj, "ymd");
    				break;
				case "exp_dt":
					ComAddSeparator(obj, "ymd");
    				break;
			}
		}
	} 
	function obj_activate(){
		var obj=ComGetEvent();
		if(obj.name != "agmt_no"){
			ComClearSeparator(ComGetEvent());
		} else {
			obj.style.imeMode="disabled" ;
		}
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
					formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value,6,"0");
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC03);
//					trf_no.SetEnable(1);
				   	break;
	    		case "agmt_no":
					formObj.agmt_no.value=formObj.agmt_no.value.substring(0,3) + ComLpad(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length), 6, "0");
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
				case "pay_term_dys":
					//Ctrl Office Updating information
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"pay_term_dys",ComGetObjValue(formObj.pay_term_dys),0);
					}
					break;
				case "eff_dt":
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"eff_dt",ComGetObjValue(formObj.eff_dt),0);
					}
					break;
				case "exp_dt":
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"exp_dt",ComGetObjValue(formObj.exp_dt),0);
					}
					break;
				// 2013-08-30 Recovery PQC test defects by J.H Han		
				case "eff_dt":
	    			if(ComGetDaysBetween(formObj.eff_dt.value, formObj.exp_dt.value) < 0){
	    				ComShowCodeMessage("MNR00366");
	    				ComClearSeparator(formObj.eff_dt);
	    				ComSetFocus(formObj.eff_dt);
	    			}
	    			break;
	    		case "exp_dt":
	    			if(ComGetDaysBetween(formObj.eff_dt.value, formObj.exp_dt.value) < 0){
	    				ComShowCodeMessage("MNR00366");
	    				ComClearSeparator(formObj.exp_dt);
	    				ComSetFocus(formObj.exp_dt);
	    			}
	    			break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		formObj.vndr_nm.value="";
					trf_no.RemoveAll();
					trf_no.SetSelectCode("");
					trf_no.SetEnable(0);
					//Ctrl Office Updating information
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"mnr_prnr_seq","",0);
						sheetObjects[1].SetCellValue(i,"mnr_prnr_lgl_eng_nm","",0);
						sheetObjects[1].SetCellValue(i,"mnr_prnr_locl_lang_nm","",0);
						sheetObjects[1].SetCellValue(i,"pay_term_dys","",0);
					}
				   	break;
	    		case "agmt_no":
	        		//Setting agmt_ver_no
					agmt_ver_no.RemoveAll();
					agmt_ver_no.InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
					defVerCode='1';
					agmt_ver_no.SetSelectCode(defVerCode);
				   	break;
				case "pay_term_dys" :
					//Ctrl Office Updating information
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"pay_term_dys","",0);
					}
					break;
				case "eff_dt":
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"eff_dt","",0);
					}
					break;
				case "exp_dt":
					for(var i=1; i <= sheetObjects[1].LastRow();i++){
						sheetObjects[1].SetCellValue(i,"exp_dt","",0);
					}
					break;
			}
		}
	}
	
	/* End of developer's task */
