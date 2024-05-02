/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079_04.js
*@FileTitle  : Container Information - Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                              MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
                              Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
	var cur_usr_id='';
	var before_edit_val='';
	var scrnAuth='';
	var rcv_term_str="Y|D|S|T|I";
	var del_term_str="Y|D|S|T|O";
	var seal_knd_str="M|E";
	var seal_pty_tp_str="SH|CA|AA|CU|AB|AC|TO";
	var tpsz_chk=true;
	var isWarnMsg=false;
	var cntrs;
	var isCrdUpdate=false;
    // Event handler processing by button click event */
    document.onclick=checkLoad;
	function checkLoad(){	//'target' undefined error
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
	
	
    // Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables다. *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
         var sheetObject5=sheetObjects[4];
         /*******************************************************/
         var formObject=document.form;
        try {
        	
        	
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display="none";
        		}    	    			
    		}
			switch(srcName) {
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				case "btn_CargoDtl":
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_0890.do?func=&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0890", 800, 430, true);
				break;
				case "btn_VarianceDtl":
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_1051.do?func=&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_1051", 860, 470, true);
				break;
				case "btn_retrieve":
					// If there is changed value
					//alert("before search -> dirty_flag = " + formObject.dirty_flag.value);
					if(formObject.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00824"))){
						var rflag=doActionIBSheet(sheetObject2, formObject, IBSAVE);
						//alert("before search -> rflag = " + rflag);
//						if(rflag) doActionIBSheet(sheetObject2,formObject,IBSEARCH) ;
					}else{
						doActionIBSheet(sheetObject2,formObject,IBSEARCH) ;
					}
					setShpFlg(false);
				break;
				case "btn_t6save":
					if(ComIsBtnEnable("btn_t6save")){
						formObject.modify_fnl_cfm_flg.value='N';
						// confirm 'Save'
						//if(confirm(ComGetMsg("BKG00254"))){
							doActionIBSheet(sheetObject2, formObject, IBSAVE);
						//}
							setShpFlg(false);
					}
				break;
				case "btn_t6downexcel":
					//sheetObject2.SpeedDown2Excel(-1, true, true, '', '', false, false, '', false, "ibflag|cntr_dp_seq|sel|SEALPop|PCKPop");

					if(sheetObject2.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
 					sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
					}
				break;
				case "btn_t6print":
					 if(formObject.bkg_no.value == '' ){
						  ComShowMessage(ComGetMsg("BKG00463"));
						  formObject.bkg_no.focus();
					 }else{
						var strTitle="Container Report";
						var strToolbar="0;2;3;12;13;14;15;16;17";
						var strPath="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0919.mrd";
						var rvParam="/rp ["+ formObject.bkg_no.value +"] /riprnmargin";
						formObject.elements["com_mrdPath"     ].value=strPath;
						formObject.elements["com_mrdArguments"].value=rvParam;
						formObject.elements["com_mrdDisableToolbar"].value=strToolbar;
						formObject.elements["com_mrdTitle"    ].value=strTitle;
						formObject.elements["com_mrdBodyTitle"].value="<span style='color:red'>"+strTitle+"</span>";
						ComOpenRDPopup("width=800, height=800");
					 }
					//alert("btn_t6print --> UI_BKG-0919");
					//ComOpenWindow("ESM_BKG_0369.do", "ESM_BKG_0919", "width=640,height=480", false);
					break;
				case "btn_t6cntrconfirm":
					if(ComIsBtnEnable("btn_t6cntrconfirm") && chk_china_cntr_seal() ){
						var rflag=doActionIBSheet(sheetObject2, formObject, COMMAND01);
						if(rflag){
							changeEditableByConfirm("CFM");
						}
						setShpFlg(false);
					}
				break;
				case "btn_t6cntrrelease":
					if(!confirm(ComGetMsg("BKG00181"))){
						return false;
					}
					if(ComIsBtnEnable("btn_t6cntrrelease")){
						var rflag=doActionIBSheet(sheetObject2, formObject, MULTI02);
						if(rflag){
							changeEditableByConfirm("RLS");
						}						
						setShpFlg(false);
					}
				break;
				case "btn_t6cntrhist":
					var srow=sheetObjects[1].GetSelectRow();
                    var tmp=sheetObjects[1].GetCellValue(srow, "cntr_no");
					var cntrNo=(tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
                    var checkDigit=(tmp != null && tmp.length>10) ? tmp.substring(10) : '';
                    var typeSize=sheetObjects[1].GetCellValue(srow, "cntr_tpsz_cd");
					var url="EES_CTM_0411_POP.do?pgmNo=EES_CTM_0411&func=&cntrNo="+cntrNo+"&checkDigit="+checkDigit+"&typeSize="+typeSize+"&pop_mode=1";
					//alert(url);
					ComOpenWindowCenter(url, "EES_CTM_0411", 1020, 600, true);
//					ComOpenPopup(url,1020, 682, "", "1,0", true);
				break;
				case "btn_t6notupdated":
					//alert("btn_t6notupdated --> UI_BKG-0901");
					var url="ESM_BKG_0901.do?func=callbackNotUpdatedContainer&bkg_no=" + formObject.bkg_no.value;
					ComOpenWindowCenter(url, "ESM_BKG_0901", 625, 340, true);
				break;
				case "btn_t6gridcntrirr":
					if(ComIsBtnEnable("btn_t6gridcntrirr")){
						doActionIBSheet(sheetObject2, formObject, MODIFY01);
						setShpFlg(false);
					}
				break;
				case "btn_t6gridadd":
					if(ComIsBtnEnable("btn_t6gridadd")){
						doActionIBSheet(sheetObject2, formObject, IBINSERT);
					}
				break;
				case "btn_t6griddel":
					if(ComIsBtnEnable("btn_t6griddel")){
						doActionIBSheet(sheetObject2, formObject, IBDELETE);
					}
				break;
				case "btn_t6gridmove":
					if(ComIsBtnEnable("btn_t6gridmove")){
						if(validateForm(sheetObject2, formObject, COMMAND03)) {
							var bkg_no=formObject.bkg_no.value;
                            var cntr_no=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), "cntr_no");
                            var cntr_vol=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), "cntr_vol_qty");
							var url="ESM_BKG_0170.do?func=callbackMove&bkg_no="+bkg_no+"&cntr_no="+cntr_no+"&cntr_vol="+cntr_vol;
							//ComOpenWindow(url, "ESM_BKG_0170", "width=300,height=360", false);
							ComOpenWindowCenter(url, "ESM_BKG_0170", 450, 500, true);
						}
					}
				break;
				case "btn_t6sequp":
					if(ComIsBtnEnable("btn_t6sequp")){
						//alert(sheetObject2.HeaderRows + " <- " + sheetObject2.SelectRow);
						if(sheetObject2.RowCount()== 0 || sheetObject2.HeaderRows()== sheetObject2.GetSelectRow()) return;
						sheetObject2.DataMove(sheetObject2.GetSelectRow()-1);
						setSeq(true);
						//
						formObject.dirty_flag.value='Y';
					}
				break;
				case "btn_t6seqdown":
					if(ComIsBtnEnable("btn_t6seqdown")){				
						//alert(sheetObject2.SelectRow + " -> " + sheetObject2.LastRow);
						if(sheetObject2.RowCount()== 0 || sheetObject2.LastRow()== sheetObject2.GetSelectRow()) return;
						sheetObject2.DataMove(sheetObject2.GetSelectRow()+2);
						setSeq(true);
						//
						formObject.dirty_flag.value='Y';
					}
				break;
				case "btn_t6gridmultishp":
					if(formObject.bkg_no.value == '' ){
						ComShowMessage(ComGetMsg("BKG00463"));
						formObject.bkg_no.focus();
					}else{
						var url="ESM_BKG_0391.do?func=callbackMultiShp&bkg_no=" + formObject.bkg_no.value+"&ui_no=ESM_BKG_0079_04";
						ComOpenWindowCenter(url, "ESM_BKG_0391", 1100, 595, true);
					}
				break;
            } // end switch
        }catch(e) {
    		if( e.name == "TypeError") {
    			return false;
    		}else{
        		ComShowMessage(e.message);
    		}
		}
    }
    
    function makeHiddenSkipCol(sobj){
        var lc = sobj.LastCol();
        var rtnStr = "";
        for(var i=0;i<=lc;i++){
        	if( ! ( 1==sobj.GetColHidden(i) || sobj.GetCellProperty(0,i,"Type") == "DummyCheck" 
        		|| sobj.GetCellProperty(0,i,"Type") == "Radio"||  sobj.GetCellProperty(0,i,"Type") == "Status" 
        		||  sobj.GetCellProperty(0,i,"Type") =="DelCheck" )){
        		rtnStr += "|"+ i;
        	}
        }
        return rtnStr.substring(1);
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
			//initSheet
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
			//
			sheetObjects[i].SetWaitImageVisible(0);
        }
        initControl();
        
		//iframe creation
    	//CofigIframe();
    	//------------------------------------------------>
    	//setInquiryDisableButton event calling
   		setInquiryDisableButton();
     	//------------------------------------------------>
        // set init-data for sheets
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		}
    }
	function initControl() {
        //add listener
        axon_event.addListenerForm('keypress', 'ComKeyEnter', document.form);
        axon_event.addListenerForm('change', 'form1_change', document.form);
       // applyShortcut();
		inputEngSet();
		setShpFlg(false);
	}
	
    var inputEngSet = function(){
        $("[data-eng='on']").keyup(function(event){
    	                                 if (!((event.keyCode >=37 && event.keyCode<=40)||   // 영어
    	                                		 (event.keyCode >=48 && event.keyCode<=57) )){ // 숫자
    		                                 var inputVal = $(this).val();
    	 	                                $(this).val(inputVal.replace(/[^a-z][^0-9]/gi,'')); // 영어 숫만 외문자는 삭제
    	                                 }
                             });
       }	
    /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "t6sheet1":
                with(sheetObj){
                    var HeadTitle="BKG NO|TP/SZ|BKG Q'ty|CNTR Q'ty";
                    
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"bkg_cntr_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                    
                    InitColumns(cols);
                    
                    SetEditable(0);
                    SetCountPosition(0);
                    SetSheetHeight(105);
                }
                break;
            case "t6sheet2":
                with(sheetObj){
                    var HeadTitle="|Sel.|Seq.|Bkg No|C|Old No.|Container No.|TS|Seal No.1|Kind/Code|Kind/Code|Seal No.2|Kind/Code|Kind/Code| |Package|Package|Package|Weight|Weight|Measure|Measure|VGM|VGM|R/D Term|R/D Term|P|Vol|AS|ST|HG|DG|BB|AK|RF|RD|SOC|ORG YD|Event Date|CRD|Remark(s)|CM Flg|dcgo_cnt|";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                         {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dp_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cfm_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no_old",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"seal1_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15, AcceptKeys : "E|N|[~!@#$%^&*()--_+={}[]|\\:;<.>/?]" },
                         {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seal1_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:seal_knd_str, ComboCode:seal_knd_str },
                         {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal1_pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:seal_pty_tp_str, ComboCode:seal_pty_tp_str },
                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"seal2_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15, AcceptKeys : "E|N|[~!@#$%^&*()--_+={}[]|\\:;<.>/?]" },
                         {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seal2_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:seal_knd_str, ComboCode:seal_knd_str },
                         {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal2_pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:seal_pty_tp_str, ComboCode:seal_pty_tp_str },
                         {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"SEALPop",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"PCKPop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"meas_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"vgm_wgt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"vgm_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:rcv_term_str, ComboCode:rcv_term_str },
                         {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:del_term_str, ComboCode:del_term_str },
                         {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_prt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
                         {Type:"Float",     Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"cntr_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"adv_shtg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, ComboText:"|A|S", ComboCode:"|A|S" },
                         {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hngr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N"},
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N"},
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rd_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"soc_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  TrueValue:"Y", FalseValue:"N" },
//                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cgo_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cgo_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"####-##-## ##:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cm_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"dcgo_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cgo_rcv_dt_flg",   KeyField:0 } ];
                    
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetDataAutoTrim(0);
                    SetShowButtonImage(2);
                    SetColProperty(0 ,"pck_tp_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
                    //conversion of function[check again]CLT 					InitDataValid(0,  "seal1_no",   	vtEngOther, "1234567890~!@#$%^&*()--_+={}[]|\:;<.>/?");
                    //conversion of function[check again]CLT 					InitDataValid(0,  "seal2_no",   	vtEngOther, "1234567890~!@#$%^&*()--_+={}[]|\:;<.>/?");
                    //no support[implemented common]CLT 					SelectHighLight=false;
                    SetSheetHeight(260);
//                    updateSheetSize(sheetObj);
                }
                break;
            case "t6sheet3":
                with(sheetObj){
                    var HeadTitle="||bkg no|cntr no|Seal Seq.|Seal No|knd_cd|pty_tp|pty_nm|Print|Via|old_cntr_no||";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"DummyCheck", Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sel" },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seal_pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"seal_pty_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",    ColMerge:0,   SaveName:"seal_inp_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prn_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,  TrueValue:"Y", FalseValue:"N" },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"old_cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },                                 
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"old_cntr_seal_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"old_seal_inp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
                                 ];
                    
                    
                    
                    InitColumns(cols);
                    
                    SetCountPosition(0);
                    SetVisible(0);
                }
                break;
            case "t6sheet4":
                with(sheetObj){
                    var HeadTitle="|Cntr No.|Booking No.|Vol.|Current|Adjusted|S/O|Special CGO";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bkg_vol",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"adj_vol_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"spcl_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"so_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    
                    InitColumns(cols);
                    
                    SetEditable(0);
                    SetVisible(0);
                }
                break;
            case "t6sheet5":
                with(sheetObj){
                    var HeadTitle="TP/SZ|Category|DR|DG|RF|AK|BB|HG|SOC|R Term|R Term|R Term|R Term|R Term|D Term|D Term|D Term|D Term|D Term|Vol";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"category",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dry_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dcgo_flg",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rc_flg",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"awk_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bb_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"hngr_flg",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"soc_flg",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_y",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_d",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_s",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_t",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_i",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_y",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_d",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_s",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_t",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_o",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                    
                    InitColumns(cols);
                    SetVisible(0);
                }
                break;
        }
    }
    
    function updateSheetSize(sheetObj){
  	  if(typeof sheetObj == "undefined") {
  		  sheetObj = sheetObjects[1];
  	  }
  	  var obj = $("#" + sheetObj.id).offset();
  	  var marginDefault = 180;
  	  var marginHeight = obj.top + marginDefault;
  	  var winHeight = $(parent.window).height();
  	  var sheetHeight = winHeight - marginHeight;

  	  with(sheetObj){
  		SetSheetHeight(sheetHeight > 90?sheetHeight:90);
  	  }    
  }          
    
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
     //   sheetObj.ShowDebugMsg = 1;
        switch(sAction) {
            case IBSEARCH:
                if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true); 
				isCrdUpdate=false;
				ComBtnEnable("btn_t6save");
				ComBtnEnable("btn_t6cntrconfirm");
				ComBtnEnable("btn_t6cntrrelease");
				ComBtnEnable("btn_t6gridcntrirr");
				ComBtnEnable("btn_t6gridadd");
				ComBtnEnable("btn_t6griddel");
				ComBtnEnable("btn_t6gridmove");
				ComBtnEnable("btn_t6sequp");
				ComBtnEnable("btn_t6seqdown");
				// sheet
				sheetObjects[0].SetEditable(1);
				sheetObjects[1].SetEditable(1);
				sheetObjects[2].SetEditable(1);
				// object
				formObj.bkg_wgt_ut_cd.disabled=false;
				formObj.bkg_meas_ut_cd.disabled=false;
                formObj.f_cmd.value=SEARCH;
                //sheetObj.DoSearch("ESM_BKG_0079_04GS.do", FormQueryString(formObj));
                 var rXml=sheetObj.GetSearchData("ESM_BKG_0079_04GS.do", FormQueryString(formObj));
				if(rXml == '' || rXml.length < 7) return false;
				if(rXml.substring(1, 6) == "ERROR"){
					ComShowMessage(ComResultMessage(rXml));
				    ComOpenWait(false); 
					return false;
				}
                var arrXml=rXml.split("|$$|");
				if(arrXml.length == 4){
					// xml array
					var etcXml=arrXml[0];
					var qtyXml=arrXml[1];
					var sealXml=arrXml[2];
					var volXml=arrXml[3];
					// qty sheet
					sheetObjects[0].LoadSearchData(qtyXml,{Sync:1} );
					// seal no sheet
					//alert(sheetObjects[2].id + "\n" + sealXml);
					sheetObjects[2].LoadSearchData(sealXml,{Sync:1} );
					// container sheet
					sheetObjects[1].LoadSearchData(etcXml,{Sync:1} );
					
					// btn_t6gridmultishp button color setting
					if(ComGetObjValue(formObj.mlt_shp_flg) == "Y"){
					    ComGetObject("btn_t6gridmultishp").style.setProperty("background-color", "#dceeff", "important");
					    ComGetObject("btn_t6gridmultishp").style.setProperty("color", "blue", "important");
					}else{
					    ComGetObject("btn_t6gridmultishp").style.setProperty("background-color", "", "important");
					    ComGetObject("btn_t6gridmultishp").style.setProperty("color", "", "important");
					}
					// term qty sheet
					//alert(sheetObjects[4].id + "\n" + volXml);
					sheetObjects[4].LoadSearchData(volXml,{Sync:1} );
					if(sheetObjects[0].GetTotalRows()== 0){
						//alert("ERR_DATA, Create booking quantity first!");
    				    ComOpenWait(false); 
						return false;
					}
					
					calculateCntrQty();
//					setAllSealNo();
				}else{
				    ComOpenWait(false); 
					return false;
				}
                break;
            case IBSAVE:        //Save
            	
            	
            	
				// unit code sync.
				if(scrnAuth == 'R') return;
				var wgtCd1=formObj.bkg_wgt_ut_cd.options[formObj.bkg_wgt_ut_cd.selectedIndex].value;
				var measCd1=formObj.bkg_meas_ut_cd.options[formObj.bkg_meas_ut_cd.selectedIndex].value;
				for (rn=1; rn<=sheetObjects[1].RowCount(); rn++) {
                    if(wgtCd1 != sheetObjects[1].GetCellValue(rn, "wgt_ut_cd")){
						sheetObjects[1].SetCellValue(rn, "wgt_ut_cd",wgtCd1,0);
					}
                    if(measCd1 != sheetObjects[1].GetCellValue(rn, "meas_ut_cd")){
						sheetObjects[1].SetCellValue(rn, "meas_ut_cd",measCd1,0);
					}
				}
                if(validateForm(sheetObj,formObj,sAction)) {
				try {
					//validate damage
					formObj.f_cmd.value=SEARCH03;
					
					//UCR No. update check Flag
					var cntrCnt		= sheetObjects[1].RowCount();
					var sParam=FormQueryString(formObj);
					var sParamSheet1=sheetObjects[1].GetSaveString();
					//alert("Container :\n" + sParamSheet1);
					if (sParamSheet1 != "") {
						sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}
					//alert(sParam);
 					var rXml=sheetObj.GetSaveData("ESM_BKG_0079_04GS.do", sParam);
 					
 					var dmgFlg=ComGetEtcData(rXml,"DMG_FLG");
 					if(dmgFlg == "Y"){
 						if(!confirm(ComGetMsg("BKG08354")))	return;
 					}
					
					ComOpenWait(true); 
                    //formObj.f_cmd.value = MULTI;
					//sheetObj.DoSave("ESM_BKG_0079_04GS.do", FormQueryString(formObj));
					formObj.f_cmd.value=MULTI;
					
					//UCR No. update check Flag
					formObj.ucr_flg.value = "";
					var ucrFlg		= "N";
					var bkgQtyCnt 	= sheetObjects[0].RowCount();
					var bkgQtyVol 	= 0;
					var cntrCnt		= sheetObjects[1].RowCount();
					for(var i=1; i< bkgQtyCnt+1; i++){
						bkgQtyVol += BkgParseFloat(sheetObjects[0].GetCellValue(i, "op_cntr_qty"));
					}
					if(bkgQtyCnt==1 && bkgQtyVol==1){
						if(cntrCnt==1)	ucrFlg = "Y";
					}
					formObj.ucr_flg.value = ucrFlg;
					
					var sParam=FormQueryString(formObj);
					//alert(sheetObjects[0].id);
					//var sParamSheet0 = sheetObjects[0].GetSaveString();
					//if (sParamSheet0 != "") {
					//	sParam = sParam + "&sheet0_" + sParamSheet0.replace(/&/g, '&sheet0_');
					//}
					//
					if (!isCrdUpdate) {
						for (var i=1; i<= sheetObj.RowCount(); i++) {
							sheetObj.SetCellValue(i, "cgo_rcv_dt_flg","N",0);
						}
					}
					var sParamSheet1=sheetObjects[1].GetSaveString();
					//alert("Container :\n" + sParamSheet1);
					if (sParamSheet1 != "") {
						sParam=sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}
					//
					var sParamSheet2=sheetObjects[2].GetSaveString();
					//alert("Seal No. :\n" + sParamSheet2);
					if (sParamSheet2 != "") {
						sParam=sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
					}
					//
					var sParamSheet3=sheetObjects[3].GetSaveString();
					//alert("Volumn :\n" + sParamSheet3);
					if (sParamSheet3 != "") {
						sParam=sParam + "&sheet3_" + sParamSheet3.replace(/&/g, '&sheet3_');
					}
					//alert(sParam);
 					var rXml=sheetObj.GetSaveData("ESM_BKG_0079_04GS.do", sParam);
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
 						sheetObjects[1].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
 						sheetObjects[2].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
 						sheetObjects[3].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						// show message
						if(formObj.modify_fnl_cfm_flg.value == 'Y'){
							if(formObj.fnl_cfm_flg.value == 'Y'){
								ComShowMessage(ComGetMsg("BKG00865"));
							}else{
								ComShowMessage(ComGetMsg("BKG00864"));
							}
						}else{
							var cstms_download=ComGetEtcData(rXml, "USA_CSTMS_DOWNLOAD");
							if(cstms_download == 'true'){
								ComShowMessage(ComGetMsg("BKG00166") + '\n\n' + ComGetMsg("BKG00087"));
							}else{
								ComShowMessage(ComGetMsg("BKG00166"));
							}
						}
						// confirm data changing
						formObj.dirty_flag.value='N';
//						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					} else {
						ComShowMessage(rMsg);
						return false;
					}
				}finally{
					ComOpenWait(false);
				}
                }else{
					return false;
				}
                break;
			case COMMAND01:      // Confirmation
				if(validateForm(sheetObj,formObj,sAction)) {
					var tmp_usr_id=formObj.evnt_usr_id.value;
					var tmp_dt=formObj.evnt_dt.value;
					// comfirm
					formObj.evnt_usr_id.value=cur_usr_id;
					formObj.evnt_dt.value=getToday();
					formObj.fnl_cfm_flg.value='Y';
					formObj.modify_fnl_cfm_flg.value='Y';
					//set change flag
					formObj.dirty_flag.value='Y';
					// confirm message
					//ComShowMessage(ComGetMsg("BKG00865"));
					// calling save 
					var res=doActionIBSheet(sheetObj,formObj,IBSAVE);
					if(!res){
						// release
						formObj.evnt_usr_id.value=tmp_usr_id;
						formObj.evnt_dt.value=tmp_dt;
						formObj.fnl_cfm_flg.value='N';
						formObj.modify_fnl_cfm_flg.value='N';
					}
					return res;
				}else{
					return false;
				}
			break;
			case MULTI02:      // Cancel Confirmation
				var tmp_usr_id=formObj.evnt_usr_id.value;
				var tmp_dt=formObj.evnt_dt.value;
				// release
				formObj.evnt_usr_id.value='';
				formObj.evnt_dt.value='';
				formObj.fnl_cfm_flg.value='N';
				formObj.modify_fnl_cfm_flg.value='Y';
				//set change flag
				formObj.dirty_flag.value='Y';
                formObj.f_cmd.value=MULTI02;
				var sParam=FormQueryString(formObj);
 				var res=sheetObj.GetSaveData("ESM_BKG_0079_04GS.do", sParam);
				var State=ComGetEtcData(res,"TRANS_RESULT_KEY");
				if(State != null){
					if ( State == "S" ) {
						ComShowMessage(ComGetMsg("BKG00864"));
						formObj.fnl_cfm_flg.value='N';
						formObj.modify_fnl_cfm_flg.value='N';
						formObj.dirty_flag.value='N';
						changeEditableByConfirm("RLS");
 						sheetObj.LoadSaveData(sXml);
 						
					}else{
						fnExceptionMessage(sXml);
					}
				}
				return res;
			break;
			case COMMAND03: 
			break;
			case COMMAND04:      //booking split no retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
				//try {
				//	ComOpenWait(true); 
					sheetObj.SetWaitImageVisible(0);
					ComSetObjValue(formObj.f_cmd, COMMAND03);
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -15); 
					sheetObj.SetWaitImageVisible(1);
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;
            case IBINSERT:      // input
				var newRow=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(newRow, "bkg_no",formObj.bkg_no.value,0);
				if(formObj.rcv_term_cd.value != 'M'){
					sheetObj.SetCellValue(newRow, "rcv_term_cd",formObj.rcv_term_cd.value,0);
//					sheetObj.CellEditable(newRow, "rcv_term_cd") = false;
				}
				if(formObj.de_term_cd.value != 'M'){
					sheetObj.SetCellValue(newRow, "de_term_cd",formObj.de_term_cd.value,0);
//					sheetObj.CellEditable(newRow, "de_term_cd") = false;
				}
				sheetObj.SetCellValue(newRow, "cntr_vol_qty",1,0);
				sheetObj.SetCellValue(newRow, "wgt_ut_cd",ComGetObjValue(formObj.bkg_wgt_ut_cd),0);
				sheetObj.SetCellValue(newRow, "meas_ut_cd",ComGetObjValue(formObj.bkg_meas_ut_cd),0);
				sheetObj.SelectCell(newRow, "cntr_no");
				// Set Seq.
//				setSeq(false);
				/* calculateCntrQty */
				//calculateCntrQty();
				// confirm data changing
				formObj.dirty_flag.value='Y';
            break;
			case IBDELETE:      // delete
				//alert (" Delete .. ");
				//ComRowHideDelete(sheetObj, "sel");
				var rCntrNo='';
				var rCfrm='';
				var rCMFlag='';
				var selRows=sheetObj.FindCheckedRow("sel");
				if(selRows == ''){
					ComShowMessage(ComGetMsg("COM12189"));
					return false;
				}
				var idxArr=selRows.split("|");
				var cidx=0;
				//alert(idxArr.length + " : " + selRows);
				for(cidx=idxArr.length-1; cidx>=0;cidx--){
					if(idxArr[cidx] == '') continue;
                    rCntrNo=sheetObj.GetCellValue(idxArr[cidx], "cntr_no");
                    rCfrm=sheetObj.GetCellValue(idxArr[cidx], "cntr_cfm_flg");
                    rCMFlag=sheetObj.GetCellValue(idxArr[cidx], "cm_flg");
					if(rCfrm == 1 && !confirm(ComGetMsg("BKG00175"))){
						continue;
					}
                    if(sheetObj.GetCellValue(idxArr[cidx], "dcgo_flg")    == 1 ||
                        sheetObj.GetCellValue(idxArr[cidx], "bb_cgo_flg")  == 1 ||
                        sheetObj.GetCellValue(idxArr[cidx], "awk_cgo_flg") == 1 ||
                        sheetObj.GetCellValue(idxArr[cidx], "rc_flg")      == 1){
						//If there is Special Cargo, don't delete
						//alert(ComGetMsg("BKG00176"));
						ComShowMessage(ComGetMsg("BKG00171", rCntrNo));
						continue;
					}
					if(rCMFlag == 'Y' && !confirm(ComGetMsg("BKG00177"))){
						continue;
					}
					// delete container
					sheetObj.SetRowHidden(idxArr[cidx],1);
					sheetObj.SetRowStatus(idxArr[cidx],'D');
					sheetObj.SetCellValue(idxArr[cidx], "sel",0,0);
					// delete seal no
					ComRowDelete(sheetObjects[2], "cntr_no", rCntrNo);
				}
				/* calculateCntrQty */
				calculateCntrQty();
				// confirm data changing
				formObj.dirty_flag.value='Y';
				
			break;
			case MODIFY01:
				if (validateForm(sheetObj,formObj,sAction)) {
					sheetObj.CheckAll("sel",0,1);
					var arrRow=ComFindText(sheetObj, "cgo_rcv_dt_flg", "N");
					for (var i=1; i<=sheetObj.RowCount(); i++) {
						sheetObj.SetCellValue(i, "cgo_rcv_dt_flg","N",0);
					}
					if (arrRow) {
						for (var i=0; i<arrRow.length; i++) {
                            if (sheetObj.GetCellValue(arrRow[i], "cgo_rcv_dt")!="") {
								sheetObj.SetCellValue(arrRow[i], "sel",1,0);
								sheetObj.SetCellValue(arrRow[i], "ibflag","U",0);
								sheetObj.SetCellValue(arrRow[i], "cgo_rcv_dt_flg","Y",0);
 								sheetObj.SetCellFontColor(arrRow[i],"cgo_rcv_dt",sheetObj.GetCellFontColor(arrRow[i],"cntr_no"));
							}
						}
					}
					//Cargo Receiving Date setting
					var maxCrdDt='';
					var currCrdDt='';
 					for (var i=1; i<=sheetObj.LastRow(); i++) {
                        currCrdDt=sheetObj.GetCellValue(i, "cgo_rcv_dt");
						if (maxCrdDt == null || maxCrdDt < currCrdDt) {
							maxCrdDt=currCrdDt;
						}
					}
					if(maxCrdDt!='') {
						maxCrdDt=maxCrdDt.substring(0,4) + '-' + maxCrdDt.substring(4,6) + '-' + maxCrdDt.substring(6,8);
					}
					formObj.cgo_rcv_dt.value=maxCrdDt;
					//Button to activate the cleaning and storage
					getBtnObject("btn_t6gridcntrirr").style.color="#C0C0C0";
					ComBtnDisable("btn_t6gridcntrirr");
					formObj.dirty_flag.value='Y';
					isCrdUpdate=true;
				} else {
					return false;
				}					
			break;
        }
		return true;
    }
    /**
    * fnExceptionMessage  
    *
    * @param 
    * @return 
    */
    function fnExceptionMessage(rXml){
    	var rMsg=ComGetEtcData(rXml,"Exception")
    	var rmsg=rMsg.split("<||>");
    	if(rmsg[3] != undefined && rmsg[3].length > 0) {
    		ComShowMessage(rmsg[3]);
    	}else{
     		sheetObjects[0].LoadSaveData(rXml);
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case IBSEARCH:
				/*
				1. confirm data changing - After [BKG00824], If you select ""Yes"" ,call Save event
				2. MANDATORY ITEMS input check - BKG no(10digit), B/L no(12digit) or not, messege [BKG00445] output focus on
				3. BKG Split no check -or not ,change to a two-digit spaces
				4. Data LRetrieve
				*/
				with (formObj) {
					if(bkg_no.value == '' || bkg_no.value.length < 11){
						if(bl_no.value == '' ){
							ComShowMessage(ComGetMsg("BKG00463"));
							bkg_no.focus();
							return false;
						}
					}
				}
			break;
            case IBSAVE:
				/*
				1. confirm data changing - If the return processing changes
				2. Check store display messege
				3. confirm data changing 뭉 confirm flag check - confirm flag=false -> return
				4. BKG status check - status is "X" if a message [BKG00433] show returns after
				5. If BDR and CA check - BDR="Y", CA="N", messege [BKG00335] -> return
				6. MANDATORY ITEMS input check - If no value is MANDATORY after displaying the message processing focus
				   : BKG no, Container no, Package, R/D term, Vol : Vol > 1 or Vol <= 0  check, Package qty < 1  check
				7. QTY Grid update and variance check - variance if there are changes to red line
				*/
				if(scrnAuth == 'R') return;
				if(formObj.dirty_flag.value != 'Y'){
					//alert(formObj.dirty_flag.value);
					return false;
				}
				if(!confirm(ComGetMsg("BKG00254"))){
					return false;
				}
				if(formObj.bkg_sts_cd.value == 'X'){
					ComShowMessage(ComGetMsg("BKG00433"));
					return false;
				}
				//if(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N'){
				//	ComShowMessage(ComGetMsg("BKG00335"));
				//	return false;
				//}
				if(!tpsz_chk) {
					ComShowMessage(ComGetMsg("BKG00651", "Container TP/SZ "));
					return false;
				}
				var qtySheet=sheetObjects[0];
				var qtyCount=qtySheet.RowCount();
				for(ir=1; ir <= qtyCount; ir++){
                    if((qtySheet.GetCellValue(ir, "op_cntr_qty") - qtySheet.GetCellValue(ir, "bkg_cntr_qty")) < 0){
						qtySheet.SetRowBackColor(ir,"#C00000");
					}
				}
				var cntrSheet=sheetObjects[1];
				var cntrCount=cntrSheet.RowCount();
				for(ir=1;ir<=cntrCount;ir++){
					//alert("!!!" + cntrSheet.CellValue(ir, "cntr_no"));
                    if(cntrSheet.GetRowStatus(ir) == 'D') continue;
                    if(cntrSheet.GetCellValue(ir, "bkg_no")==""){
						ComShowMessage(ComGetMsg("BKG00888", "bkg_no"));
						//cntrSheet.SelectCell(ir, "bkg_no");
						return false;
					}
                    if(cntrSheet.GetCellValue(ir, "cntr_no")==""){
						ComShowMessage(ComGetMsg("BKG00888", "cntr_no"));
						cntrSheet.SelectCell(ir, "cntr_no");
						return false;
					}
                    if(cntrSheet.GetCellValue(ir, "pck_qty")!=""){
						// pck qty && BB_FLAG
                        if(BkgParseInt(cntrSheet.GetCellValue(ir, "pck_qty")) < 0){
							ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
							cntrSheet.SelectCell(ir, "pck_qty");
							return false;
                        }else if(BkgParseInt(cntrSheet.GetCellValue(ir, "pck_qty")) == 0 && cntrSheet.GetCellValue(ir, "bb_cgo_flg") == 0){
							ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
							cntrSheet.SelectCell(ir, "pck_qty");
							return false;
						}
						// pck tpye
                        if(cntrSheet.GetCellValue(ir, "pck_tp_cd")==""){
							ComShowMessage(ComGetMsg("BKG00888", "pck_tp_cd"));
							cntrSheet.SelectCell(ir, "pck_tp_cd");
							return false;
						}							
					}
                    var measQty = sheetObjects[1].GetCellValue(ir, "meas_qty");
        			var measUtCd = sheetObjects[1].GetCellValue(ir, "meas_ut_cd");
                	if(measUtCd=="CBM"&&measQty >= 1000){
                		ComShowMessage(ComGetMsg("BKG01187"));
        				sheetObj.SelectCell(ir, "meas_qty");
        				return false;
                	}
                    if(cntrSheet.GetCellValue(ir, "rcv_term_cd")==""){
						ComShowMessage(ComGetMsg("BKG00888", "rcv_term_cd"));
						cntrSheet.SelectCell(ir, "rcv_term_cd");
						return false;
					}
                    if(cntrSheet.GetCellValue(ir, "de_term_cd")==""){
						ComShowMessage(ComGetMsg("BKG00888", "de_term_cd"));
						cntrSheet.SelectCell(ir, "de_term_cd");
						return false;
					}
                    
                    //ComIsEmpty(cntrSheet.GetCellValue(ir, "cntr_vol_qty")) ||공백이냐 아니냐 체크 함수이나 1이라는 값이 있어도 공백이라고 리턴해 제외한다.

                    if( (cntrSheet.GetCellValue(ir, "cntr_vol_qty")=="")||BkgParseFloat(cntrSheet.GetCellValue(ir, "cntr_vol_qty")) < 0 || BkgParseFloat(cntrSheet.GetCellValue(ir, "cntr_vol_qty")) > 1){
						ComShowMessage(ComGetMsg("BKG00888", "cntr_vol_qty"));
						cntrSheet.SelectCell(ir, "cntr_vol_qty");
						return false;
					}
				}
				var var_qty=BkgParseFloat(ComTrimAll(document.getElementById("var_qty").innerText, ","));
				//var var_spc_qty  = BkgParseFloat(ComTrimAll(document.getElementById("var_spc_qty").innerText, ","));
				var var_pck_qty=BkgParseFloat(ComTrimAll(document.getElementById("var_pck_qty").innerText, ","));
				var var_act_wgt=BkgParseFloat(ComTrimAll(document.getElementById("var_act_wgt").innerText, ","));
				var var_meas_qty=BkgParseFloat(ComTrimAll(document.getElementById("var_meas_qty").innerText, ","));
				var dif_message='';
				if(var_qty<0){
					//document.getElementById("var_qty").style.backgroundColor = "red";
					//document.getElementById("var_qty").style.color = "#606060";
					//ComShowMessage(ComGetMsg("BKG00849"));
					//if(!confirm(ComGetMsg("BKG00852"))){
					//	return false;
					//}
					dif_message=(dif_message == '') ? "Container Qty" : dif_message + ", Container Qty";
				}
				if(var_pck_qty<0){
					//document.getElementById("var_pck_qty").style.backgroundColor = "red";
					//document.getElementById("var_pck_qty").style.color = "#606060";
					//ComShowMessage(ComGetMsg("BKG00849"));
					//if(!confirm(ComGetMsg("BKG00852"))){
					//	return false;
					//}
					dif_message=(dif_message == '') ? "Package Qty" : dif_message + ", Package Qty";
				}
				if(var_act_wgt<0){
					//document.getElementById("var_act_wgt").style.backgroundColor = "red";
					//document.getElementById("var_act_wgt").style.color = "#606060";
					//ComShowMessage(ComGetMsg("BKG00850"));
					//if(!confirm(ComGetMsg("BKG00852"))){
					//	return false;
					//}
					dif_message=(dif_message == '') ? "Package Qty" : dif_message + ", Package Qty";
				}
				if(var_meas_qty<0){
					//document.getElementById("var_meas_qty").style.backgroundColor = "red";
					//document.getElementById("var_meas_qty").style.color = "#606060";
					//ComShowMessage(ComGetMsg("BKG00851"));
					//if(!confirm(ComGetMsg("BKG00852"))){
					//	return false;
					//}
					dif_message=(dif_message == '') ? "Package Qty" : dif_message + ", Package Qty";
				}
				if(dif_message != '' && !confirm(ComGetMsg("BKG00852", dif_message))){
					return false;
				}
				/*
				 * Once the difference compared with Variance DTL Not Confirm.
				 * updated on 2009-11-04 by KimYoungchul
				*/
				var volSheet=sheetObjects[4];
				for(ir=volSheet.HeaderRows();ir<=volSheet.RowCount();ir++ ){
					// cntr TP/SZ
                    var tpSz=volSheet.GetCellValue(ir, "cntr_tpsz_cd");
					//alert(tpSz);
					var cntrQtyArr=getCntrQtyByType(tpSz);
					//alert(cntrQtyArr);
					for(ic=2 ;ic<=volSheet.LastCol();ic++){
                        var p1=parseFloat(volSheet.GetCellValue(ir, ic));
						var p2=parseFloat(cntrQtyArr[ic]);
						if((p1-p2) != 0) {
							ComGetObject("btn_VarianceDtl").style.setProperty("color", "red", "important"); 
							break;
						}else{
							ComGetObject("btn_VarianceDtl").style.setProperty("color", "#737373", "important");
						}
					}
				}
			break;
            case COMMAND01:
				/*
				1. BKG No check - messege BKG00463] ->return
				2. BKG Split no check or not Changed to a two-digit spaces
				3. By BKG QTY tpsz and compared to CNTR QTY if not the same either messege [BKG00179] and return
				4. Of DG application is registered in the DG flag in the container is not the case, but the DG rider,messege [BKG00180] 
				5.container of individual R / D term in the mixed term if there is ,[BKG00861] and return
				6. of container column TP / SZ Stars Vol. and booking creation of the TP / SZ Stars Vol two other cases, [BKG00854] and return
				7. BBKG's R / D term and the other R / D term, if the entered, [BKG00862] and return
				8. All C(onfrim)  check
				*/
				with (formObj) {
					if(bkg_no.value == '' || bkg_no.value.length < 11){
						if(bl_no.value == '' ){
							ComShowMessage(ComGetMsg("BKG00463"));
							bkg_no.focus();
							return false;
						}
					}
				}
				var var_qty=BkgParseFloat(ComTrimAll(document.getElementById("var_qty").innerText, ","));
				if(var_qty != 0){
					ComShowMessage(ComGetMsg("BKG00179"));
					return false;
				}
				var qtySheet=sheetObjects[0];
				var qtyCount=qtySheet.RowCount();
				var cntrSheet=sheetObjects[1];
				for(ir=1;ir<=qtyCount;ir++){
					//if(qtySheet.CellValue(ir, "cntr_tpsz_cd") == "Q2" || qtySheet.CellValue(ir, "cntr_tpsz_cd") == "Q4") continue;
                    if(formObj.flex_hgt_flg.value == 'Y' && ((qtySheet.GetCellValue(ir, "cntr_tpsz_cd") == "D4" || qtySheet.GetCellValue(ir, "cntr_tpsz_cd") == "D5"))){
						//alert(" * flex_hgt_flg : " + formObj.flex_hgt_flg.value);
						var qtyD4=ComColumnSumByCond(qtySheet, "bkg_cntr_qty", "cntr_tpsz_cd", "D4", false);
						var qtyD5=ComColumnSumByCond(qtySheet, "bkg_cntr_qty", "cntr_tpsz_cd", "D5", false);
						var cntrD4=ComColumnSumByCond(cntrSheet, "cntr_vol_qty", "cntr_tpsz_cd", "D4", false);
						var cntrD5=ComColumnSumByCond(cntrSheet, "cntr_vol_qty", "cntr_tpsz_cd", "D5", false);
						//alert("("+qtyD4+"+" +qtyD5+") - ("+cntrD4+"+"+cntrD5+") = "+((qtyD4+qtyD5) - (cntrD4+cntrD5)));
						if(((qtyD4+qtyD5) - (cntrD4+cntrD5)) != 0){
							ComShowMessage(ComGetMsg("BKG00854"));
							return false;
						}
					}else{
                        if((qtySheet.GetCellValue(ir, "op_cntr_qty") - qtySheet.GetCellValue(ir, "bkg_cntr_qty")) != 0){
							ComShowMessage(ComGetMsg("BKG00854"));
							return false;
						}
					}
				}
				var bkg_rcv_term=formObj.rcv_term_cd.value;
				var bkg_del_term=formObj.de_term_cd.value;
				var cntrCount=cntrSheet.RowCount();
				for(ir=1;ir<=cntrCount;ir++){
                    if(cntrSheet.GetCellValue(ir, "rcv_term_cd") == 'M'){
						ComShowMessage(ComGetMsg("BKG00861"));
						cntrSheet.SelectCell(ir, "rcv_term_cd");
						return false;
					}
                    if(cntrSheet.GetCellValue(ir, "de_term_cd") == 'M'){
						ComShowMessage(ComGetMsg("BKG00861"));
						cntrSheet.SelectCell(ir, "de_term_cd");
						return false;
					}
                    if(bkg_rcv_term != 'M' && cntrSheet.GetCellValue(ir, "rcv_term_cd") != bkg_rcv_term){
						ComShowMessage(ComGetMsg("BKG00862"));
						cntrSheet.SelectCell(ir, "rcv_term_cd");
						return false;
					}
                    if(bkg_del_term != 'M' && cntrSheet.GetCellValue(ir, "de_term_cd") != bkg_del_term){
						ComShowMessage(ComGetMsg("BKG00862"));
						cntrSheet.SelectCell(ir, "de_term_cd");
						return false;
					}
					//if(cntrSheet.CellValue(ir, "dcgo_flg") == 1 && BkgParseInt(cntrSheet.CellValue(ir, "dcgo_cnt")) == 0){
					//	ComShowMessage(ComGetMsg("BKG00180", cntrSheet.CellValue(ir, "cntr_no")));
					//	cntrSheet.SelectCell(ir, "cntr_no");
					//	return false;
					//}
                    if(cntrSheet.GetCellValue(ir, "cntr_no")==""){
						ComShowMessage(ComGetMsg("BKG00443"));						
						return false;
						//cntrSheet.CellValue(ir, "cntr_cfm_flg") = 0;
					}else{
						cntrSheet.SetCellValue(ir, "cntr_cfm_flg",1,0);
						//changeCntrStatus
						//changeCntrStatus(row);
					}
				}
				var volSheet=sheetObjects[4];
				for(ir=volSheet.HeaderRows();ir<=volSheet.RowCount();ir++ ){
					// cntr TP/SZ
                    var tpSz=volSheet.GetCellValue(ir, "cntr_tpsz_cd");
					//alert(tpSz);
					var cntrQtyArr=getCntrQtyByType(tpSz);
					//alert(cntrQtyArr);
					for(ic=2 ;ic<=volSheet.LastCol();ic++){
                        var p1=parseFloat(volSheet.GetCellValue(ir, ic));
						var p2=parseFloat(cntrQtyArr[ic]);
						if((p1-p2) != 0) {
							//alert(volSheet.ColSaveName(ic) +" : "+ p1 + " - " + p2 + " = " + (p1 - p2));
//							document.getElementById("btn_VarianceDtl").style.color = "red";
							ComGetObject("btn_VarianceDtl").style.setProperty("color", "red", "important"); 
							ComShowMessage(ComGetMsg("BKG08071", volSheet.ColSaveName(ic)));
							return false;
						}
					}
					ComGetObject("btn_VarianceDtl").style.setProperty("color", "#737373", "important");
				}
			break;
            case MULTI02:
				/*
				1. BKG No check  - [BKG00183] and return
				2. BKG Split no check  - or not Changed to a two-digit spaces
				3. [BKG00181] 메세지 표시
				4. CA  check  
				5. all C(onfrim) uncheck
				*/
				if(!confirm(ComGetMsg("BKG00181"))){
					return false;
				}
				var cntrSheet=sheetObjects[1];
				var cntrCount=cntrSheet.RowCount();
				for(ir=1;ir<=cntrCount;ir++){
					cntrSheet.SetCellValue(ir, "cntr_cfm_flg",0,0);
				//	//changeCntrStatus
				//	changeCntrStatus(ir);
				}
				//
				//changeEditableByConfirm('RLS');
			break;
			case COMMAND03:
				/*
				1. confirm data changing -  messege [BKG00178] 
				2. BKG status check - If status is "X", messege [BKG00433] 
				3. BDR and CA check - BDR="Y", CA="N", messege [BKG00335] and return
				*/
				with (formObj) {
					if(bkg_no.value==""){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
					if(dirty_flag.value == 'Y'){
						ComShowMessage(ComGetMsg("BKG00178"));
						return false;
					}
					if(bkg_sts_cd.value == 'X'){
						ComShowMessage(ComGetMsg("BKG00433"));
						return false;
					}
					if(bdr_flg.value == 'Y' && corr_flg.value == 'N'){
						ComShowMessage(ComGetMsg("BKG00335"));
						return false;
					}
				}
                if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_no")==""){
					ComShowMessage(ComGetMsg("BKG00753"));
					sheetObj.SelectCell(sheetObj.GetSelectRow(), "cntr_no") ;
					return false;
				}
			break;
			case COMMAND04: 
				with (formObj) {
					if(bkg_no.value==""){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;
        	case MODIFY01:
        		var idx=0;
        		var cnt1=cnt2=0;
        		cntrs=new Array();
				for (var i=sheetObj.HeaderRows(); i<=sheetObj.RowCount(); i++) {
                    if ("N"==sheetObj.GetCellValue(i,"cgo_rcv_dt_flg")) {
						cnt1++;
					}
                    if (""==sheetObj.GetCellValue(i,"cgo_rcv_dt")) {
						cnt2++;
					}
                    if (""==sheetObj.GetCellValue(i,"cgo_rcv_dt")) {
                        cntrs[idx++]=sheetObj.GetCellValue(i,"cntr_no");
					}
				}
				isWarnMsg=0<cnt1 && 0<cnt2;
        		var arrRow=ComFindText(sheetObj, "cgo_rcv_dt_flg", "N");
				if (arrRow) {
					for (var i=0; i<arrRow.length; i++) {
                        if (sheetObj.GetCellValue(arrRow[i], "cgo_rcv_dt")!="") {
                            if ("N"==sheetObj.GetCellValue(arrRow[i], "cgo_rcv_dt_flg")) {
								return true;
							}
						}
					}
				}
				return false;
        	break;
		}
        return true;
    }
    function form1_change(){
        var srcName=ComGetEvent("name");
        var srcValue=ComGetEvent("value");
        switch(srcName){
            case "bkg_wgt_ut_cd":
            case "bkg_meas_ut_cd":
				for (rn=1; rn<=sheetObjects[1].RowCount(); rn++) {
					sheetObjects[1].SetCellValue(rn, srcName.substring(4),srcValue,0);
				}
				// calculateCntrQty
				calculateCntrQty();
				// confirm data changing
				document.form.dirty_flag.value='Y';
            break;
        }
    }
	function t6sheet2_OnPopupClick(sheetObj, row, col){
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "SEALPop":
                var bkg_no=sheetObj.GetCellValue(row, "bkg_no");
                var cntr_no=sheetObj.GetCellValue(row, "cntr_no");
				if(cntr_no==''){
					ComShowMessage(ComGetMsg("BKG00443"));
					return;
				}
				var url="ESM_BKG_0697.do?bkg_no=" +bkg_no+ "&cntr_no=" + cntr_no;
				//ComOpenWindow(url, "ESM_BKG_0697", "width=300,height=280", false);이거아님
				ComOpenWindowCenter(url, "ESM_BKG_0697", 500, 450, true)
			    break;
			case "PCKPop":
				//var url = "ESM_BKG_0696.do";
				//ComOpenWindow(url, "ESM_BKG_0696", "width=400,height=389", false);
				comBkgCallPop0696("callbackPckTp", sheetObj.GetCellValue(row, "pck_tp_cd")); 
			    break;
		}		
	}
	function t6sheet2_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		with (sheetObj) {
			for (var i=HeaderRows(); i<=RowCount(); i++) {
                if ("N"==GetCellValue(i,"cgo_rcv_dt_flg")) {
     				SetCellFontColor(i,"cgo_rcv_dt","#FF0000");
				}
			}
		}
        // etc data
		ComEtcDataToForm(formObj ,sheetObj, '');
		// pkg container
		document.getElementById("wgt_ut_cd").innerText=sheetObj.GetEtcData("wgt_ut_cd");
		document.getElementById("meas_ut_cd").innerText=sheetObj.GetEtcData("meas_ut_cd");
		document.getElementById("bkg_qty").innerText=ComAddComma3(sheetObj.GetEtcData("quantity"), "#,###.00");
		//document.getElementById("bkg_spc_qty").innerText    = ComAddComma3(sheetObj.EtcData("spc_qty"), "#,###.00");
		document.getElementById("bkg_pck_qty").innerText=ComAddComma3(sheetObj.GetEtcData("pck_qty"), "#,###");
		document.getElementById("bkg_act_wgt").innerText=ComAddComma3(sheetObj.GetEtcData("act_wgt"), "#,###.000");
//		document.getElementById("bkg_meas_qty").innerText=ComAddComma3(sheetObj.GetEtcData("meas_qty"), "#,###.000");
		if(sheetObj.GetEtcData("meas_qty") == "" || sheetObj.GetEtcData("meas_qty") == null || sheetObj.GetEtcData("meas_qty") == undefined){
			document.getElementById("bkg_meas_qty").innerText="";
		}else{
			document.getElementById("bkg_meas_qty").innerText=ComAddComma3(sheetObj.GetEtcData("meas_qty"), "#,###.000");
		}
		
		// after loading of container
//		calculateCntrQty();
		// Set Seq.
		//setSeq(false);
		// after loading of seal no
		setAllSealNo();
		var cn_flg=formObj.cn_flg.value;
		//alert("* cn_flg : " + cn_flg);
		var por_cnt=formObj.por_cd.value=="" ? "NA" : formObj.por_cd.value.substring(0, 2);
		var del_cnt=formObj.del_cd.value=="" ? "NA" : formObj.del_cd.value.substring(0, 2);
		if(cn_flg == 'Y' || por_cnt=='CN' || del_cnt == 'CN'){
			sheetObj.SetColHidden("seal1_knd_cd",0);
			sheetObj.SetColHidden("seal1_pty_tp_cd",0);
			sheetObj.SetColHidden("seal2_knd_cd",0);
			sheetObj.SetColHidden("seal2_pty_tp_cd",0);
		}else{
			sheetObj.SetColHidden("seal1_knd_cd",1);
			sheetObj.SetColHidden("seal1_pty_tp_cd",1);
			sheetObj.SetColHidden("seal2_knd_cd",1);
			sheetObj.SetColHidden("seal2_pty_tp_cd",1);
			formObj.cn_flg.value='N';
		}
		//If BDR flag = "Y"-> BKG no background color to blue. If BDR flag = "N" color to white
		if(formObj.bdr_flg.value == 'Y'){
			document.getElementById("bkg_no").className="input1";
		}else{
			document.getElementById("bkg_no").className="input";
		}

		changeObjectColor(formObj.not_updated_flg.value, "Y", "btn_t6notupdated", "red", "btn2");
		// wgt_ut_cd
		var wgtCd1=formObj.bkg_wgt_ut_cd.options[formObj.bkg_wgt_ut_cd.selectedIndex].value;
		var wgtCd2=sheetObj.GetEtcData("wgt_ut_cd");
		if(wgtCd1 == null || wgtCd1 == ''){
			if(wgtCd2 == null || wgtCd2 == ''){
				formObj.bkg_wgt_ut_cd.value="KGS";
			}else{
				formObj.bkg_wgt_ut_cd.value=wgtCd2;
			}
		}
		// meas_ut_cd
		var measCd1=formObj.bkg_meas_ut_cd.options[formObj.bkg_meas_ut_cd.selectedIndex].value;
		var measCd2=sheetObj.GetEtcData("meas_ut_cd");
		if(measCd1 == null || measCd1 == ''){
			if(measCd2 == null || measCd2 == ''){
				formObj.bkg_meas_ut_cd.value="CBM";
			}else{
				formObj.bkg_meas_ut_cd.value=measCd2;
			}
		}
		// For Inquery 
		// final confirm flag
		//if(!ComIsEmpty(formObj.evnt_dt.value)){
		if(formObj.fnl_cfm_flg.value == 'Y'){
			changeEditableByConfirm('CFM');
		}else{
			formObj.fnl_cfm_flg.value='N';
			changeEditableByConfirm('RLS')
		}
		// confirm data changing
		formObj.dirty_flag.value='N';
		//alert("* scrnAuth : " + scrnAuth);
		setInquiryDisableButton();
		// ca controll
		//alert("1. " +(parent.outerFrame != undefined)+ ", 2. " + (parent.outerFrame != "undefined") + ", 3. " + (typeof(parent.outerFrame) == "object"));
		if(parent.t6frame != undefined && typeof(parent.t6frame) == "object") {
			parent.initCAControl(formObj.bkg_no.value, formObj.corr_flg.value, formObj.bdr_flg.value, formObj.ca_exist_flg.value, formObj.bl_no.value);
		}
//						if ("W"==formObj.bl_tp_cd.value) {
//							formObj.bl_no.value += "W";
//						} else if ("Y"==formObj.obl_iss_flg.value) {
//							formObj.bl_no.value += "S";
//						}
		var arrRow=ComFindText(sheetObj, "cgo_rcv_dt_flg", "N");
		var cgoRcvDtBtn=false;
		if (arrRow) {
			for (var i=0; i<arrRow.length; i++) {
                if (sheetObj.GetCellValue(arrRow[i], "cgo_rcv_dt")!="") {
                    if ("N"==sheetObj.GetCellValue(arrRow[i], "cgo_rcv_dt_flg")) {
						cgoRcvDtBtn=true;
						break;
					}
				}
			}
		}
		formObj.not_crd_flg.value=cgoRcvDtBtn ? "Y":"N";
		var isIrrBtn=false;
		if ("Y"==formObj.corr_flg.value) {
			if ("Y"==formObj.not_crd_flg.value) {
				isIrrBtn=true;
			} else {
				isIrrBtn=false;
			}
		} else {
			if ("Y"==formObj.bdr_flg.value) {
				isIrrBtn=false;
			} else {
				if ("Y"==formObj.not_crd_flg.value) {
					isIrrBtn=true;
				} else {
					isIrrBtn=false;
				}
			}
		}
		if (isIrrBtn) {
			getBtnObject("btn_t6gridcntrirr").style.color="red";
			ComBtnEnable("btn_t6gridcntrirr");
		} else {
			getBtnObject("btn_t6gridcntrirr").style.color="#C0C0C0";
			ComBtnDisable("btn_t6gridcntrirr");
		}
		for (var i=sheetObj.HeaderRows(); i<=sheetObj.RowCount(); i++) {
            if ("N"==sheetObj.GetCellValue(i,"cgo_rcv_dt_flg") || ""==sheetObj.GetCellValue(i,"cgo_rcv_dt")) {
				ComSetObjValue(document.form.cgo_rcv_dt,"");
				break;
			}
		}			
        ComOpenWait(false); 
	}
	function t6sheet2_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg == "") doActionIBSheet(sheetObj,document.form,IBSEARCH) ;
	}
	function t6sheet2_OnKeyDown(sheetObj, row, col, keyCode, shift) {
		//alert("OnKeyDown -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col));
		if( sheetObj.ColSaveName(col) =="cntr_no")
		{
			before_edit_val = sheetObj.GetCellValue(row, col);
		}
	}
	function t6sheet2_OnBeforeEdit(sheetObj, row, col, val) {
        before_edit_val=sheetObj.GetCellValue(row, col);
	}
	function saveSeal(flg, cntr_no){
		if(flg != null && flg == 'Y'){
			var cntrObj=sheetObjects[1];
			var arrRow=ComFindText(cntrObj, "cntr_no", cntr_no);
			// Insert인 경우는 유지하게 변경
			if(cntrObj.GetCellValue(arrRow,"ibflag") != "I")
				cntrObj.SetCellValue(arrRow,"ibflag","U",0);
		}
	}
	function t6sheet2_OnChange(sheetObj, row, col, val) {
		// confirm data changing
		document.form.dirty_flag.value='Y';
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
            sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col),0);
		}
		/* ColSaveName*/
	    var col_save_name=sheetObj.ColSaveName(col);
        var bkg_no=sheetObj.GetCellValue(row, "bkg_no");
        var cntr_no=sheetObj.GetCellValue(row, "cntr_no");
		/* seal1_no */
		if (col_save_name == "seal1_no") {
			var sealObj=sheetObjects[2];
			var arrRow=ComFindText(sealObj, "cntr_no", cntr_no);
			var len=arrRow.length;
			if(len == 0){
				if(val==""){
					//
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
					sealObj.SetCellValue(newRow, "cntr_seal_no",val,0);
                    sealObj.SetCellValue(newRow, "seal_knd_cd",(sheetObj.GetCellValue(row, "seal1_knd_cd") == '') ? "M" : sheetObj.GetCellValue(row, "seal1_knd_cd"),0);
                    sealObj.SetCellValue(newRow, "seal_inp_tp_cd","MAN",0);
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else {
				if(val==""){
					sealObj.SetCellValue(arrRow[0], "cntr_seal_no",'',0);
				}else{
					sealObj.SetCellValue(arrRow[0], "cntr_seal_no",val,0);
					if(val != sealObj.GetCellValue(arrRow[0], "old_cntr_seal_no")){
						sealObj.SetCellValue(arrRow[0], "seal_inp_tp_cd","MAN",0);
					}else{
						sealObj.SetCellValue(arrRow[0], "seal_inp_tp_cd",sealObj.GetCellValue(arrRow[0], "old_seal_inp_tp_cd"),0);
					}
				}
			}
			ComRowDelete(sealObj, "cntr_seal_no", '');
			//
			setAllSealNo();
		}
		/* seal1_knd_cd */
		if (col_save_name == "seal1_knd_cd") {
            if(sheetObj.GetCellValue(row, "seal1_no")==""){
				ComShowMessage(ComGetMsg("BKG00651", "Empty Column! [Seal No.1]"));
				return false;
			}
			var sealObj=sheetObjects[2];
			var arrRow=ComFindText(sealObj, "cntr_no", cntr_no);
			var len=arrRow.length;
			if(len == 0){
				if(val==""){
					// do nothing!
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
                    sealObj.SetCellValue(newRow, "cntr_seal_no",sheetObj.GetCellValue(row, "seal1_no"),0);
					sealObj.SetCellValue(newRow, "seal_knd_cd",val,0);
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else {
				if(val==""){
					sealObj.SetCellValue(arrRow[0], "seal_knd_cd",'',0);
				}else{
					sealObj.SetCellValue(arrRow[0], "seal_knd_cd",val,0);
				}
			}
		}
		/* seal1_pty_tp_cd */
		if (col_save_name == "seal1_pty_tp_cd") {
            if(sheetObj.GetCellValue(row, "seal1_no")==""){
				ComShowMessage(ComGetMsg("BKG00651", "Empty Column! [Seal No.1]"));
				return false;
			}
			var sealObj=sheetObjects[2];
			var arrRow=ComFindText(sealObj, "cntr_no", cntr_no);
			var len=arrRow.length;
			if(len == 0){
				if(val==""){
					// do nothing!
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
                    sealObj.SetCellValue(newRow, "cntr_seal_no",sheetObj.GetCellValue(row, "seal1_no"),0);
                    sealObj.SetCellValue(newRow, "seal_knd_cd",(sheetObj.GetCellValue(row, "seal1_knd_cd") == '') ? "M" : sheetObj.GetCellValue(row, "seal1_knd_cd"),0);
					sealObj.SetCellValue(newRow, "seal_pty_tp_cd",val,0);
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else {
				if(val==""){
					sealObj.SetCellValue(arrRow[0], "seal_pty_tp_cd",'',0);
				}else{
					sealObj.SetCellValue(arrRow[0], "seal_pty_tp_cd",val,0);
				}
			}
		}
		/* seal2_no */
		if (col_save_name == "seal2_no") {
			var sealObj=sheetObjects[2];
			var arrRow=ComFindText(sealObj, "cntr_no", cntr_no);
			var len=arrRow.length;
			if(len == 0){
				if(val==""){
					// do nothing!
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
					sealObj.SetCellValue(newRow, "cntr_seal_no",val,0);
                    sealObj.SetCellValue(newRow, "seal_knd_cd",(sheetObj.GetCellValue(row, "seal2_knd_cd") == '') ? "M" : sheetObj.GetCellValue(row, "seal2_knd_cd"),0);
                    sealObj.SetCellValue(newRow, "seal_inp_tp_cd","MAN",0);
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else if(len == 1){
				if(val==""){
					// do nothing!
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
					sealObj.SetCellValue(newRow, "cntr_seal_no",val,0);
                    sealObj.SetCellValue(newRow, "seal_knd_cd",(sheetObj.GetCellValue(row, "seal2_knd_cd") == '') ? "M" : sheetObj.GetCellValue(row, "seal2_knd_cd"),0);
                    if(val != sealObj.GetCellValue(newRow, "old_cntr_seal_no")){
                    	sealObj.SetCellValue(newRow, "seal_inp_tp_cd","MAN",0);
					}else{
						sealObj.SetCellValue(newRow, "seal_inp_tp_cd",sealObj.GetCellValue(newRow, "old_seal_inp_tp_cd"),0);
					}
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else {
				if(val==""){
					sealObj.SetCellValue(arrRow[1], "cntr_seal_no",'',0);
				}else{
					sealObj.SetCellValue(arrRow[1], "cntr_seal_no",val,0);
					if(val != sealObj.GetCellValue(arrRow[1], "old_cntr_seal_no")){
						sealObj.SetCellValue(arrRow[1], "seal_inp_tp_cd","MAN",0);
					}else{
						sealObj.SetCellValue(arrRow[1], "seal_inp_tp_cd",sealObj.GetCellValue(arrRow[0], "old_seal_inp_tp_cd"),0);
					}
				}
			}
			ComRowDelete(sealObj, "cntr_seal_no", '');
			//
			setAllSealNo();
		}
		/* seal2_knd_cd */
		if (col_save_name == "seal2_knd_cd") {
            if(ComIsEmpty(sheetObj.GetCellValue(row, "seal2_no"))){
				ComShowMessage(ComGetMsg("BKG00651", "Empty Column! [Seal No.2]"));
				return false;
			}
			var sealObj=sheetObjects[2];
			var arrRow=ComFindText(sealObj, "cntr_no", cntr_no);
			var len=arrRow.length;
			if(len == 0){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
                    sealObj.SetCellValue(newRow, "cntr_seal_no",sheetObj.GetCellValue(row, "seal2_no"),0);
					sealObj.SetCellValue(newRow, "seal_knd_cd",val,0);
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else if(len == 1){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
                    sealObj.SetCellValue(newRow, "cntr_seal_no",sheetObj.GetCellValue(row, "seal2_no"),0);
					sealObj.SetCellValue(newRow, "seal_knd_cd",val,0);
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else {
				if(ComIsEmpty(val)){
					sealObj.SetCellValue(arrRow[1], "seal_knd_cd",'',0);
				}else{
					sealObj.SetCellValue(arrRow[1], "seal_knd_cd",val,0);
				}
			}
		}
		/* seal2_pty_tp_cd */
		if (col_save_name == "seal2_pty_tp_cd") {
            if(ComIsEmpty(sheetObj.GetCellValue(row, "seal2_no"))){
				ComShowMessage(ComGetMsg("BKG00651", "Empty Column! [Seal No.2]"));
				return false;
			}
			var sealObj=sheetObjects[2];
			var arrRow=ComFindText(sealObj, "cntr_no", cntr_no);
			var len=arrRow.length;
			if(len == 0){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
                    sealObj.SetCellValue(newRow, "cntr_seal_no",sheetObj.GetCellValue(row, "seal2_no"),0);
                    sealObj.SetCellValue(newRow, "seal_knd_cd",(sheetObj.GetCellValue(row, "seal2_knd_cd") == '') ? "M" : sheetObj.GetCellValue(row, "seal2_knd_cd"),0);
					sealObj.SetCellValue(newRow, "seal_pty_tp_cd",val,0);
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else if(len == 1){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow=sealObj.DataInsert(-1);
					sealObj.SetCellValue(newRow, "bkg_no",bkg_no,0);
					sealObj.SetCellValue(newRow, "cntr_no",cntr_no,0);
                    sealObj.SetCellValue(newRow, "cntr_seal_no",sheetObj.GetCellValue(row, "seal2_no"),0);
                    sealObj.SetCellValue(newRow, "seal_knd_cd",(sheetObj.GetCellValue(row, "seal2_knd_cd") == '') ? "M" : sheetObj.GetCellValue(row, "seal2_knd_cd"),0);
					sealObj.SetCellValue(newRow, "seal_pty_tp_cd",val,0);
					sealObj.SetCellValue(newRow, "prn_flg",1,0);
					sealObj.SetCellValue(newRow, "old_cntr_no",cntr_no,0);
				}
			} else {
				if(ComIsEmpty(val)){
					sealObj.SetCellValue(arrRow[1], "seal_pty_tp_cd",'',0);
				}else{
					sealObj.SetCellValue(arrRow[1], "seal_pty_tp_cd",val,0);
				}
			}
		}
		/* Confirm Flag modifying */
		if(col_save_name == "cntr_cfm_flg"){
			// cntr no 가 입력되었는지 check
			if(ComIsEmpty(cntr_no)){
				ComShowMessage(ComGetMsg("BKG00169"));
				sheetObj.SelectCell(row, "cntr_no");
				return false;
			}
		}
		/* Container No modifying */
		if(col_save_name == "cntr_no"){
			//alert(col_save_name + ":\nbefore_edit_val=" + before_edit_val + ",\ncntr_no=" + cntr_no + ",\nSearchedValue="+sheetObj.CellSearchValue(row, "cntr_no"));
			// check NULL
			if(cntr_no == '') {
				return false;
			}
			
			if( cntr_no != '' && before_edit_val != cntr_no) {
				 if(ComIsEmpty(before_edit_val)){
					//alert("ComIsEmpty:" + before_edit_val);
				 }else{
					var sealObj2 = sheetObjects[2];
					var arrRow2 = ComFindText(sealObj2, "old_cntr_no", before_edit_val);
				    var len2 = arrRow2.length;
					if(len2 > 0){				
						for(i=0; i<len2; i++){
							sealObj2.SetCellValue(arrRow2[i],"cntr_no", val,0);
						}
					}	
			    }
			}
			// Special Cargo
            if(sheetObj.GetCellValue(row,  "dcgo_flg")    == 1 ||
                sheetObj.GetCellValue(row, "bb_cgo_flg")  == 1 ||
                sheetObj.GetCellValue(row, "awk_cgo_flg") == 1 ||
                sheetObj.GetCellValue(row, "rc_flg")      == 1 ){
			    ComShowMessage(ComGetMsg("BKG00171", before_edit_val));
				sheetObj.SetCellValue(row, "cntr_no",before_edit_val,0);
				sheetObj.SelectCell(row, "cntr_no") ;
				return false;
			}
			// If the number is a 8-digit and The first digit is K,change K to KSCU
			if(cntr_no.charAt(0) == 'K' && cntr_no.length==8){
				//if(confirm(ComGetMsg("BKG00172"))){
					cntr_no="KSCU" + cntr_no.substring(1);
					sheetObj.SetCellValue(row, "cntr_no",cntr_no,0);
				//}
			}
			// Duplicate CNTR No. If you have loaded messege [BKG00965] Data entered after deleting pyosihu focus
			for(ir=sheetObj.HeaderRows();ir<=sheetObj.RowCount();ir++){
                var tmpNo=sheetObj.GetCellValue(ir, "cntr_no");
				if(ir==row) continue;
				//alert(ir + ":" + cntr_no + "=" + tmpNo + "=")
				if(cntr_no.replace(/\s/gi,"") == tmpNo.replace(/\s/gi,"") && !"BREAKBULK" == tmpNo.toUpperCase()){
					ComShowMessage(ComGetMsg("BKG00965", cntr_no.replace(/\s/gi,"")));
					sheetObj.SetCellValue(row, "cntr_no",'',0);
					sheetObj.SelectCell(row, "cntr_no") ;
					return false;
				}
			}
			
			//seal_no cntr_no setting...
			for(ir=sheetObj.HeaderRows();ir<=sheetObj.RowCount();ir++){
                var tmpSealNo1=sheetObj.GetCellValue(ir, "seal1_no");
                var tmpSealNo2=sheetObj.GetCellValue(ir, "seal2_no");
                if(tmpSealNo1=="" && tmpSealNo1=="")	continue;
                
				var sealObj2 = sheetObjects[2];
                if(tmpSealNo1 != ""){
					var arrRow2 = ComFindText(sealObj2, "cntr_seal_no", tmpSealNo1);
				    var len2 = arrRow2.length;
					if(len2 > 0){				
						for(i=0; i<len2; i++){
							if(sealObj2.GetCellValue(arrRow2[i],"cntr_no")==""){
								sealObj2.SetCellValue(arrRow2[i],"cntr_no", cntr_no,0);
								sealObj2.SetCellValue(arrRow2[i],"old_cntr_no", cntr_no,0);
							}
						}
					}	
                }
                if(tmpSealNo2 != ""){
					var arrRow2 = ComFindText(sealObj2, "cntr_seal_no", tmpSealNo2);
				    var len2 = arrRow2.length;
					if(len2 > 0){				
						for(i=0; i<len2; i++){
							if(sealObj2.GetCellValue(arrRow2[i],"cntr_no")==""){
								sealObj2.SetCellValue(arrRow2[i],"cntr_no", cntr_no,0);
								sealObj2.SetCellValue(arrRow2[i],"old_cntr_no", cntr_no,0);
							}
						}
					}	
                }
			}
			
			
			// Import and various data sets cntr tpsz. If you input wrong Container No,[BKG00173]
			try{
				ComOpenWait(false);
			// make empty
			//ComMakeEmptyRow(sheetObj, row, "ibflag,cntr_dp_seq,bkg_no,cntr_cfm_flg,cntr_no,cntr_no_old,cntr_tpsz_cd,rcv_term_cd,de_term_cd,cnmv_sts_cd");
			// search container
 			var cntrXml=sheetObjects[1].GetSearchData("ESM_BKG_0079_04GS.do", "f_cmd="+SEARCH01+"&bkg_no="+bkg_no+"&cntr_no=" + cntr_no);
			// XML Parsing
			var xmlDoc = ComGetXmlDoc(cntrXml);
			var xmlRoot = xmlDoc.documentElement;
			var dataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
			var dataChildNodes=dataNode.childNodes;
            var hasCntr = false;
	          for (var i=0; i<dataChildNodes.length; i++) {
	        	  
	        	  if (dataChildNodes[i].nodeType != 1)
	    				continue;
	          	  
	        	     xName=dataChildNodes[i].attributes[0].nodeValue;
	        	  if(xName =="soc_flg"){
	        		  sheetObj.SetCellValue(row, xName,dataChildNodes[i].firstChild.nodeValue, 0);
	        	  }
				  if(xName == "cntr_tpsz_cd") {
					  sheetObj.SetCellValue(row, xName,dataChildNodes[i].firstChild.nodeValue, 0);
				  }
				  if(xName == "cnmv_sts_cd") {
					  sheetObj.SetCellValue(row, xName,dataChildNodes[i].firstChild.nodeValue, 0);
				  }
	          }
//				if(hasCntr){
//					alert(6);
//					for (var ic=0; ic<dataChildNodes.length; ic++) {
//						alert(7);
//						xName=dataChildNodes[i].attributes[0].nodeValue;
//						if(xName == "ibflag") continue;
//						alert(8);
//                      sheetObj.SetCellValue(row, xName,dataChildNodes[i].firstChild.nodeValue, 0);
//                      alert(9);
//					}
//					alert(10);
//                  cntr_no=sheetObj.GetCellValue(row, "cntr_no");
//				}else{
//					sheetObj.SetCellValue(row, "cntr_no",'',0);
//				}				  
	                
	          
//			if(dataChildNodes.length > 0){
//				var hasCntr=false;
//				for (ic=0; ic<dataChildNodes.length; ic++) {
//					var xName=dataChildNodes.item(ic).getAttribute("KEY");
//					if(xName == "cntr_no") {
//						hasCntr=true;
//						break;
//					}
//				}
//				if(hasCntr){
//					for (ic=0; ic<dataChildNodes.length; ic++) {
//						var xName=dataChildNodes.item(ic).getAttribute("KEY");
//						if(xName == "ibflag") continue;
//                        sheetObj.SetCellValue(row, xName,dataChildNodes.item(ic).text, 0);
//					}
//                    cntr_no=sheetObj.GetCellValue(row, "cntr_no");
//				}else{
//					sheetObj.SetCellValue(row, "cntr_no",'',0);
//				}
//			}
			
			
			}finally{
				ComOpenWait(false);
			}
            if(sheetObj.GetCellValue(row, "cntr_no") == '' || sheetObj.GetCellValue(row, "cntr_tpsz_cd") == ''){
            	
				ComShowMessage(ComGetMsg("BKG00173", cntr_no));
				sheetObj.SetCellValue(row, "cntr_no",'',0);
				sheetObj.SelectCell(row, "cntr_no") ;
				return false;
			}
            if(sheetObj.GetCellValue(row, "cntr_tpsz_cd").substring(0,1) == "R" && sheetObj.GetCellValue(row, "rc_flg") == 0 ) {
				sheetObj.SetCellValue(row, "rd_cgo_flg",1,0);
			}
			// Type Code check.
            var cTp=sheetObj.GetCellValue(row, "cntr_tpsz_cd");
			if((cTp == 'D4' || cTp == 'D5') && document.form.flex_hgt_flg.value == 'Y'){
				// ignore it!
			}else{
				var qTpArr=ComFindText(sheetObj, "cntr_tpsz_cd", cTp);
				if(qTpArr.length == 0){
					ComShowMessage(ComGetMsg("BKG00062", cTp));
					ComMakeEmptyRow(sheetObj, row, "ibflag,cntr_dp_seq,bkg_no,cntr_cfm_flg,cntr_no_old,seal1_no,seal1_knd_cd,seal1_pty_tp_cd,seal2_no,seal2_knd_cd,seal2_pty_tp_cd,rcv_term_cd,de_term_cd,cnmv_sts_cd");
					return false;
                }else if(sheetObj.GetCellValue(qTpArr[0], "op_cntr_qty") == '' || sheetObj.GetCellValue(qTpArr[0], "op_cntr_qty") == 0){
					ComShowMessage(ComGetMsg("BKG00062", cTp));
					ComMakeEmptyRow(sheetObj, row, "ibflag,cntr_dp_seq,bkg_no,cntr_cfm_flg,cntr_no_old,seal1_no,seal1_knd_cd,seal1_pty_tp_cd,seal2_no,seal2_knd_cd,seal2_pty_tp_cd,rcv_term_cd,de_term_cd,cnmv_sts_cd");
					return false;
				}
			}
			// seal no modifying
			if(!ComIsEmpty(before_edit_val)){
				var arr_sealno=ComFindText(sheetObjects[2], "cntr_no", before_edit_val);
				//alert(before_edit_val + " -> " + cntr_no + " : " + arr_sealno);
				for(ir=0;ir<arr_sealno.length;ir++){
					//sheetObjects[2].CellValue(arr_sealno[ir], "cntr_no") = cntr_no;
					sheetObjects[2].SetRowStatus(arr_sealno[ir],'D');
				}
			}
			//calculateCntrQty
			calculateCntrQty();
		}
		/* package */
		if(col_save_name == "pck_qty"){
			// quantity, package  recalculation
			calculateCntrQty();
		}
		/* weight */
		if(col_save_name == "cntr_wgt"){
			// quantity, package  recalculation
			calculateCntrQty();
		}
		/* Measure */
		if(col_save_name == "meas_qty"){
			var measQty = sheetObj.GetCellValue(row, "meas_qty");
			var measUtCd = document.form.bkg_meas_ut_cd.value;
            if(measUtCd=="CBM"&&measQty >= 1000){
				ComShowMessage(ComGetMsg("BKG01187"));
				sheetObj.SetCellValue(row, "meas_qty",0,0);
				sheetObj.SelectCell(row, "meas_qty");
				return false;
			}else if(measUtCd=="CBF"&&measQty >= 35000){
				ComShowMessage(ComGetMsg("BKG01186"));
				sheetObj.SetCellValue(row, "meas_qty",0,0);
				sheetObj.SelectCell(row, "meas_qty");
				return false;
			}
			// quantity, package  recalculation
			calculateCntrQty();
		}
		/* Volumn */
		if(col_save_name == "cntr_vol_qty"){
				if(document.form.fnl_cfm_flg.value == 'Y') {
                    var bkg_no=sheetObj.GetCellValue(row, "bkg_no");
                    var cntr_no=sheetObj.GetCellValue(row, "cntr_no");
					// 
					var url="ESM_BKG_1050.do?func=calbackAdjVol&bkg_no="+bkg_no+"&cntr_no="+cntr_no+"&cntr_vol="+val;
					ComOpenWindowCenter(url, "ESM_BKG_1050", 400, 440, true);
					// set focus
					//sheetObj.SelectCell(row, "cntr_vol_qty", false);				
				} else{
					// search confirm booking
                    var bkg_no=sheetObj.GetCellValue(row, "bkg_no");
                    var cntr_no=sheetObj.GetCellValue(row, "cntr_no");
					//alert(bkg_no + ":" + cntr_no);
 					var rXml=sheetObjects[1].GetSearchData("ESM_BKG_0079_04GS.do", "f_cmd="+SEARCH02+"&bkg_no="+bkg_no+"&cntr_no="+cntr_no);
					//alert(rXml);
					var rFlg=ComGetEtcData(rXml, "PTL_CFRM_FLG");
					//alert("rFlg -> " + rFlg);
					if(rFlg == 'Y'){
						// 
						var url="ESM_BKG_1050.do?func=calbackAdjVol&bkg_no="+bkg_no+"&cntr_no="+cntr_no+"&cntr_vol="+val;
						ComOpenWindowCenter(url, "ESM_BKG_1050", 400, 440, true);
						// set editable = flase 
						//sheetObj.SelectCell(row, "cntr_vol_qty", false);					
					}
				}
			//}			
			// 0 <= vol < 1
            if(sheetObj.GetCellValue(row, "cntr_vol_qty") <= 0 || sheetObj.GetCellValue(row, "cntr_vol_qty") > 1 ){
				// Not OK
				ComShowMessage(ComGetMsg("BKG08013"));
				sheetObj.SetCellValue(row, "cntr_vol_qty",before_edit_val,0);
				sheetObj.SelectCell(row, "cntr_vol_qty", false);
				return false;
			}
			// vol == 1 -> P
            if(sheetObj.GetCellValue(row, "cntr_vol_qty") == 1){
				sheetObj.SetCellValue(row, "cntr_prt_flg",0,0);
			}else{
				sheetObj.SetCellValue(row, "cntr_prt_flg",1,0);
			}
			// quantity, package  recalculation
			calculateCntrQty();
			// open window
		}
		/* adv_shtg_cd */
		if(col_save_name == "adv_shtg_cd"){
            if(ComIsEmpty(sheetObj.GetCellValue(row, "adv_shtg_cd")) || sheetObj.GetCellValue(row, "adv_shtg_cd") == 'A' || sheetObj.GetCellValue(row, "adv_shtg_cd") == 'S'){
				// OK
			}else{
				ComShowMessage(ComGetMsg("BKG00651", "AS Field!"));
				sheetObj.SetCellValue(row, "adv_shtg_cd",before_edit_val,0);
				sheetObj.SelectCell(row, "adv_shtg_cd") ;
				return false;
			}
		}
		/* Sub */
		if(col_save_name == "eq_subst_tpsz_cd"){
            if(sheetObj.GetCellValue(row, "eq_subst_tpsz_cd") == 1){
				ComShowMessage(ComGetMsg("BKG00174"));
			}
		}
	}
	function changeEditableByConfirm(cfrm){
		var formObj=document.form;
		//alert("BDR : " +(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N')+ " -> " + cfrm);
		if(scrnAuth == "R") return;
		if(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N'){
			if(cfrm == 'CFM'){
				// button
				ComBtnDisable("btn_t6save");
				ComBtnDisable("btn_t6gridadd");
				ComBtnDisable("btn_t6griddel");
				ComBtnDisable("btn_t6gridmove");
				ComBtnDisable("btn_t6sequp");
				ComBtnDisable("btn_t6seqdown");
				// sheet
				sheetObjects[0].SetEditable(0);
				sheetObjects[1].SetEditable(0);
				sheetObjects[2].SetEditable(0);
				// object
				formObj.bkg_wgt_ut_cd.disabled=true;
				formObj.bkg_meas_ut_cd.disabled=true;
			}else{
				// button
				ComBtnDisable("btn_t6gridadd");
				ComBtnDisable("btn_t6griddel");
				ComBtnDisable("btn_t6gridmove");
				// sheet
				sheetObjects[0].SetEditable(0);
				sheetObjects[1].SetEditable(0);
				sheetObjects[2].SetEditable(0);
				// object
				formObj.bkg_wgt_ut_cd.disabled=true;
				formObj.bkg_meas_ut_cd.disabled=true;
			}
		}else{
			if(cfrm == 'CFM'){
				// button
				ComBtnDisable("btn_t6gridadd");
				ComBtnDisable("btn_t6griddel");
				ComBtnDisable("btn_t6gridmove");
				ComBtnDisable("btn_t6sequp");
				ComBtnDisable("btn_t6seqdown");
				// sheet
				sheetObjects[0].SetEditable(1);
				sheetObjects[1].SetEditable(1);
				sheetObjects[2].SetEditable(1);
				// object
				formObj.bkg_wgt_ut_cd.disabled=false;
				formObj.bkg_meas_ut_cd.disabled=false;
				for(ir=1;ir<=sheetObjects[1].RowCount();ir++ ){
					sheetObjects[1].SetCellEditable(ir, "cntr_no",0);
					sheetObjects[1].SetCellEditable(ir, "rcv_term_cd",0);
					sheetObjects[1].SetCellEditable(ir, "de_term_cd",0);
					sheetObjects[1].SetCellEditable(ir, "cntr_vol_qty",0);
					sheetObjects[1].SetCellEditable(ir, "adv_shtg_cd",0);
					sheetObjects[1].SetCellEditable(ir, "hngr_flg",0);
				}
			}else{
				// button
				ComBtnEnable("btn_t6gridadd");
				ComBtnEnable("btn_t6griddel");
				ComBtnEnable("btn_t6gridmove");
				ComBtnEnable("btn_t6sequp");
				ComBtnEnable("btn_t6seqdown");
				// sheet
				sheetObjects[0].SetEditable(1);
				sheetObjects[1].SetEditable(1);
				sheetObjects[2].SetEditable(1);
				// object
				formObj.bkg_wgt_ut_cd.disabled=false;
				formObj.bkg_meas_ut_cd.disabled=false;
				for(ir=1;ir<=sheetObjects[1].RowCount();ir++ ){
					sheetObjects[1].SetCellEditable(ir, "cntr_no",1);
					sheetObjects[1].SetCellEditable(ir, "cntr_vol_qty",1);
					sheetObjects[1].SetCellEditable(ir, "adv_shtg_cd",1);
					sheetObjects[1].SetCellEditable(ir, "hngr_flg",1);
				}
			}
		}
		/* CNTR Confirm applied to the BDR, regardless of the possible
		 * 
		 */
		if(formObj.corr_flg.value == 'N'){
			if(cfrm == 'CFM'){
				ComBtnDisable("btn_t6cntrconfirm");
				ComBtnEnable("btn_t6cntrrelease");
			}else{
				ComBtnEnable("btn_t6cntrconfirm");
				ComBtnDisable("btn_t6cntrrelease");
			}
		}else{
			ComBtnDisable("btn_t6cntrconfirm");
			ComBtnDisable("btn_t6cntrrelease");
		}
	}
	function calculateCntrQty(){
		var qtyObj=sheetObjects[0];
		var cntrObj=sheetObjects[1];
		var bkg_qty=0;
		//var bkg_spc_qty   = 0;
		var bkg_pck_qty=0;
		var bkg_act_wgt=0;
		var bkg_meas_qty=0;
		var cntr_qty=0;
		//var cntr_spc_qty  = 0;
		var cntr_pck_qty=0;
		var cntr_act_wgt=0;
		var cntr_meas_qty=0;
		var var_qty=0;
		//var var_spc_qty   = 0;
		var var_pck_qty=0;
		var var_act_wgt=0;
		var var_meas_qty=0;
		//var tmp_cntr_vol  = 0;
		// quantity grid
		var qtyCount=qtyObj.RowCount();
		for(jr=1;jr<=qtyCount;jr++){
			//if(qtyObj.cellValue(jr, "cntr_tpsz_cd") != "Q2" || qtyObj.cellValue(jr, "cntr_tpsz_cd") != "Q4"){
			//	qtyObj.CellValue(jr, "bkg_cntr_qty") = qtyObj.cellValue(jr, "op_cntr_qty");
			//	tmp_cntr_vol  += BkgParseFloat(qtyObj.cellValue(jr, "op_cntr_qty"));
			//} else {
				qtyObj.SetCellValue(jr, "bkg_cntr_qty",0);
			//}
		}
		// container grid
		tpsz_chk=true; // Initialization
		for(ir=cntrObj.HeaderRows();ir<=cntrObj.RowCount();ir++ ){
            if(cntrObj.GetRowStatus(ir) != 'D'){
				// TpSz in 'container table'
				var cntrTpsz=cntrObj.GetCellValue(ir, "cntr_tpsz_cd");
                var cntrVolQty=cntrObj.GetCellValue(ir, "cntr_vol_qty");
				//alert(ir + " -> " + cntrTpsz + " = " + cntrVolQty);
				if(cntrTpsz == '') continue;
				// TpSz in 'quantity table'
				var qtyTpSzs=ComFindText(qtyObj, "cntr_tpsz_cd", cntrTpsz);
				if(document.form.flex_hgt_flg.value == "Y" && (qtyTpSzs == null || qtyTpSzs.length == 0)) {
					var flexCntrTpsz="";
					if (cntrTpsz == "D4") {
						flexCntrTpsz="D5";
					} else if(cntrTpsz == "D5"){
						flexCntrTpsz="D4";
					}
					qtyTpSzs=ComFindText(qtyObj, "cntr_tpsz_cd", flexCntrTpsz);
				}
				//alert(ir + " : " + cntrTpsz + " -> " + qtyTpSzs + " -> " + cntrVolQty);
				if(qtyTpSzs == null || qtyTpSzs.length == 0){
					ComShowMessage(ComGetMsg("BKG00651", "Container TP/SZ ('" +cntrTpsz+ "')"));
					tpsz_chk=false;
//					return false;
				}else{
					//alert(cntrTpsz + " : " + BkgParseFloat(qtyObj.cellValue(qtyTpSzs[0], "bkg_cntr_qty")) + " -> " + (BkgParseFloat(qtyObj.cellValue(qtyTpSzs[0], "bkg_cntr_qty")) + BkgParseFloat(cntrVolQty)));
//					qtyObj.SetCellValue(qtyTpSzs[0], "bkg_cntr_qty",(BkgParseFloat(qtyObj.GetCellValue(qtyTpSzs[0], "bkg_cntr_qty"))*100 + BkgParseFloat(cntrVolQty)*100)/100);
					qtyObj.SetCellValue(qtyTpSzs[0], "bkg_cntr_qty",(qtyObj.GetCellValue(qtyTpSzs[0], "bkg_cntr_qty") + BkgParseFloat(cntrVolQty) ));
					tpsz_chk=true;
//				}
					cntr_qty      += BkgParseFloat(cntrVolQty);
	                cntr_pck_qty  += BkgParseFloat(cntrObj.GetCellValue(ir, "pck_qty"));
	                cntr_act_wgt  += BkgParseFloat(cntrObj.GetCellValue(ir, "cntr_wgt"));
	                cntr_meas_qty += BkgParseFloat(cntrObj.GetCellValue(ir, "meas_qty"));
				}
			}
		}
		// Decimal rounding - Sheet
		var qtyCount=qtyObj.RowCount();
		for(jr=1;jr<=qtyCount;jr++){
			qtyObj.SetCellValue(jr, "bkg_cntr_qty",Math.round(qtyObj.GetCellValue(jr,"bkg_cntr_qty") * 100 ) / 100);
		}
		// Q2, Q4 modifying
		//cntr_qty += tmp_cntr_vol;
		var wgt1=document.getElementById("wgt_ut_cd").innerText;
		var wgt2=ComGetObjValue(document.form.bkg_wgt_ut_cd);
		//alert("wgt1=" + wgt1 + ", wgt2=" + wgt2);
		if(wgt1 == '' || wgt1 == wgt2){
			// skip
		}else{
			cntr_act_wgt=ComUnitConverter(wgt2+wgt1, cntr_act_wgt);
		}
		// Measure Units Conversion
		var meas1=document.getElementById("meas_ut_cd").innerText;
		var meas2=ComGetObjValue(document.form.bkg_meas_ut_cd);
		var measEx=1;
		//alert("meas1=" + meas1 + ", meas2=" + meas2);
		if(meas1 == '' || meas1 == meas2){
			// skip
		}else{
			cntr_meas_qty=ComUnitConverter(meas2+meas1, cntr_meas_qty);
		}
		// Decimal rounding
		cntr_qty=Math.round(cntr_qty * 100) / 100;
		cntr_pck_qty=Math.round(cntr_pck_qty);
		cntr_act_wgt=Math.round(cntr_act_wgt * 1000) / 1000;
		cntr_meas_qty=Math.round(cntr_meas_qty * 1000) / 1000;
		//
		document.getElementById("cntr_qty").innerText=ComAddComma3(String(cntr_qty), "#,###.00");
		//document.getElementById("cntr_spc_qty").innerText  = ComAddComma3(String(cntr_spc_qty), "#,###.00");
		document.getElementById("cntr_pck_qty").innerText=ComAddComma3(String(cntr_pck_qty), "#,###");
		document.getElementById("cntr_act_wgt").innerText=ComAddComma3(String(cntr_act_wgt), "#,###.000");
		document.getElementById("cntr_meas_qty").innerText=ComAddComma3(String(cntr_meas_qty), "#,###.000");
		bkg_qty=BkgParseFloat(ComTrimAll(document.getElementById("bkg_qty").innerText, ","));
		//bkg_spc_qty  = BkgParseFloat(ComTrimAll(document.getElementById("bkg_spc_qty").innerText, ","));
		bkg_pck_qty=BkgParseFloat(ComTrimAll(document.getElementById("bkg_pck_qty").innerText, ","));
		bkg_act_wgt=BkgParseFloat(ComTrimAll(document.getElementById("bkg_act_wgt").innerText, ","));
		bkg_meas_qty=BkgParseFloat(ComTrimAll(document.getElementById("bkg_meas_qty").innerText, ","));
		cntr_qty=BkgParseFloat(ComTrimAll(document.getElementById("cntr_qty").innerText, ","));
		//cntr_spc_qty  = BkgParseFloat(ComTrimAll(document.getElementById("cntr_spc_qty").innerText, ","));
		cntr_pck_qty=BkgParseFloat(ComTrimAll(document.getElementById("cntr_pck_qty").innerText, ","));
		cntr_act_wgt=BkgParseFloat(ComTrimAll(document.getElementById("cntr_act_wgt").innerText, ","));
		cntr_meas_qty=BkgParseFloat(ComTrimAll(document.getElementById("cntr_meas_qty").innerText, ","));
		var_qty=bkg_qty - cntr_qty;
		//var_spc_qty  = bkg_spc_qty - cntr_spc_qty;
		var_pck_qty=bkg_pck_qty - cntr_pck_qty;
		var_act_wgt=bkg_act_wgt - cntr_act_wgt;
		var_meas_qty=bkg_meas_qty - cntr_meas_qty;
		var_qty=Math.round(var_qty * 100) / 100;
		var_pck_qty=Math.round(var_pck_qty);
		var_act_wgt=Math.round(var_act_wgt * 1000) / 1000;
		var_meas_qty=Math.round(var_meas_qty * 1000) / 1000;		
		//alert("* var_qty      = " + bkg_qty +"-"+ cntr_qty +"="+ var_qty + "\n" +
		//      "* var_pck_qty  = " + bkg_pck_qty +"-"+ cntr_pck_qty +"="+ var_pck_qty + "\n" +
		//      "* var_act_wgt  = " + bkg_act_wgt +"-"+ cntr_act_wgt +"="+ var_act_wgt + "\n" +
		//      "* var_meas_qty = " + bkg_meas_qty +"-"+ cntr_meas_qty +"="+ var_meas_qty);
		document.getElementById("var_qty").innerText=ComAddComma3(String(var_qty), "#,###.00");
		//document.getElementById("var_spc_qty").innerText  = ComAddComma3(String(var_spc_qty), "#,###.00");
		document.getElementById("var_pck_qty").innerText=ComAddComma3(String(var_pck_qty), "#,###");
		document.getElementById("var_act_wgt").innerText=ComAddComma3(String(var_act_wgt), "#,###.000");
		document.getElementById("var_meas_qty").innerText=ComAddComma3(String(var_meas_qty), "#,###.000");
		// text color
		document.getElementById("var_qty").style.backgroundColor="#E8E7EC";
		if(var_qty != 0) document.getElementById("var_qty").style.color="red";
		else document.getElementById("var_qty").style.color="#606060";
		//document.getElementById("var_spc_qty").style.backgroundColor = "#E8E7EC";
		//if(var_spc_qty != 0) document.getElementById("var_spc_qty").style.color = "red";
		//else document.getElementById("var_spc_qty").style.color = "#606060";
		document.getElementById("var_pck_qty").style.backgroundColor="#E8E7EC";
		if(var_pck_qty != 0) document.getElementById("var_pck_qty").style.color="red";
		else document.getElementById("var_pck_qty").style.color="#606060";
		document.getElementById("var_act_wgt").style.backgroundColor="#E8E7EC";
		if(var_act_wgt != 0) document.getElementById("var_act_wgt").style.color="red";
		else document.getElementById("var_act_wgt").style.color="#606060";
		document.getElementById("var_meas_qty").style.backgroundColor="#E8E7EC";
		if(var_meas_qty != 0) document.getElementById("var_meas_qty").style.color="red";
		else document.getElementById("var_meas_qty").style.color="#606060";
		// Variance DTL button - updated on 2010-01-18
		var volSheet=sheetObjects[4];
		for(ir=volSheet.HeaderRows();ir<=volSheet.RowCount();ir++ ){
			// cntr TP/SZ
            var tpSz=volSheet.GetCellValue(ir, "cntr_tpsz_cd");
			//alert(tpSz);
			var cntrQtyArr=getCntrQtyByType(tpSz);
			//alert(cntrQtyArr);
			for(ic=2 ;ic<=volSheet.LastCol();ic++){
                var p1=parseFloat(volSheet.GetCellValue(ir, ic));
				var p2=parseFloat(cntrQtyArr[ic]);
				//alert(ir +","+ic + " : " +p1+"-" +p2+ "=" + (p1-p2));
				if((p1-p2) != 0) {
//					changeObjectColor(p1-p2, 0, "btn_VarianceDtl", "red", "btn2");
					ComGetObject("btn_VarianceDtl").style.setProperty("color", "red", "important"); 
					
					break;
				}else{
					ComGetObject("btn_VarianceDtl").style.setProperty("color", "#737373", "important");
				}
				
			}
		}
		// return
		return true;
	}

	function setAllSealNo(){
		var cntrObj=sheetObjects[1];
		var cntrCount=cntrObj.RowCount();
		for(idx=1;idx<=cntrCount;idx++){
            setSealNo(cntrObj.GetCellValue(idx, "cntr_no"));
		}
	}
	function setSealNo(cntr_no){
		if(cntr_no=="")			return;
		var toObject=sheetObjects[1];
		var fmObject=sheetObjects[2];
		// Container check the number of grid row
		var arrToRow=ComFindText(toObject, "cntr_no", cntr_no);
		if(arrToRow.length == 0){
			//alert("SetSealNo : " + arrToRow);
			return;
		}
		if(arrToRow.length > 1){
//			alert("SetSealNo : " + arrToRow);
			//return;
		}
		// SealNo  check the number of grid row
		var arrFmRow=ComFindText(fmObject, "cntr_no", cntr_no);
		if(arrFmRow.length==0){
            var stsCd=toObject.GetRowStatus(arrToRow[0]);
			toObject.SetCellValue(arrToRow[0], "seal1_no",'',0);
			toObject.SetCellValue(arrToRow[0], "seal1_knd_cd",'',0);
			toObject.SetCellValue(arrToRow[0], "seal1_pty_tp_cd",'',0);
			toObject.SetCellValue(arrToRow[0], "seal2_no",'',0);
			toObject.SetCellValue(arrToRow[0], "seal2_knd_cd",'',0);
			toObject.SetCellValue(arrToRow[0], "seal2_pty_tp_cd",'',0);
			toObject.SetRowStatus(arrToRow[0],stsCd);
		} else if(arrFmRow.length==1){
            var stsCd=toObject.GetRowStatus(arrToRow[0]);
            toObject.SetCellValue(arrToRow[0], "seal1_no",arrFmRow[0] == '' ? "" : fmObject.GetCellValue(arrFmRow[0], "cntr_seal_no"),0);
            toObject.SetCellValue(arrToRow[0], "seal1_knd_cd",arrFmRow[0] == '' ? "" : fmObject.GetCellValue(arrFmRow[0], "seal_knd_cd"),0);
            toObject.SetCellValue(arrToRow[0], "seal1_pty_tp_cd",arrFmRow[0] == '' ? "" : fmObject.GetCellValue(arrFmRow[0], "seal_pty_tp_cd"),0);
			toObject.SetCellValue(arrToRow[0], "seal2_no",'',0);
			toObject.SetCellValue(arrToRow[0], "seal2_knd_cd",'',0);
			toObject.SetCellValue(arrToRow[0], "seal2_pty_tp_cd",'',0);
			toObject.SetRowStatus(arrToRow[0],stsCd);
		} else {
            var stsCd=toObject.GetRowStatus(arrToRow[0]);
            toObject.SetCellValue(arrToRow[0], "seal1_no",arrFmRow[0] == '' ? "" : fmObject.GetCellValue(arrFmRow[0], "cntr_seal_no"),0);
            toObject.SetCellValue(arrToRow[0], "seal1_knd_cd",arrFmRow[0] == '' ? "" : fmObject.GetCellValue(arrFmRow[0], "seal_knd_cd"),0);
            toObject.SetCellValue(arrToRow[0], "seal1_pty_tp_cd",arrFmRow[0] == '' ? "" : fmObject.GetCellValue(arrFmRow[0], "seal_pty_tp_cd"),0);
            toObject.SetCellValue(arrToRow[0], "seal2_no",arrFmRow[1] == '' ? "" : fmObject.GetCellValue(arrFmRow[1], "cntr_seal_no"),0);
            toObject.SetCellValue(arrToRow[0], "seal2_knd_cd",arrFmRow[1] == '' ? "" : fmObject.GetCellValue(arrFmRow[1], "seal_knd_cd"),0);
            toObject.SetCellValue(arrToRow[0], "seal2_pty_tp_cd",arrFmRow[1] == '' ? "" : fmObject.GetCellValue(arrFmRow[1], "seal_pty_tp_cd"),0);
			toObject.SetRowStatus(arrToRow[0],stsCd);
		}
		// confirm data changing
		document.form.dirty_flag.value='Y';
	}
	// set Seq. No
	function setSeq(change_ibflag){
		var rSeq=1;
		var rCnt=sheetObjects[1].RowCount();
		for (rn=1; rn <= rCnt; rn++) {
            var rsts=sheetObjects[1].GetRowStatus(rn);
			if(rsts != 'D'){
				if(rsts == 'I'){
					sheetObjects[1].SetCellValue(rn, "cntr_dp_seq",rSeq++,0);
					sheetObjects[1].SetRowStatus(rn,"I");
				}else{
					sheetObjects[1].SetCellValue(rn, "cntr_dp_seq",rSeq++,0);
					sheetObjects[1].SetRowStatus(rn,"U");
				}
			}
		}	
	}	
	/**/
	function getCntrQtyByType(cntrTpsz){
		var sheetObj=sheetObjects[1];
		var tpSzs=null;
		var dry_cgo_flg=0;
		var dcgo_flg=0;
		var rc_flg=0;
		var awk_cgo_flg=0;
		var bb_cgo_flg=0;
		var hngr_flg=0;
		var soc_flg=0;
		var rcv_term_y=0;
		var rcv_term_d=0;
		var rcv_term_s=0;
		var rcv_term_t=0;
		var rcv_term_i=0;
		var de_term_y=0;
		var de_term_d=0;
		var de_term_s=0;
		var de_term_t=0;
		var de_term_o=0;
		var op_cntr_qty=0;
		tpSzs=ComFindText(sheetObj, "cntr_tpsz_cd", cntrTpsz);
		if(tpSzs != null && tpSzs.length > 0){
			for(idx=0;idx<tpSzs.length;idx++){
				// values
                var vol=(sheetObj.GetCellValue(tpSzs[idx], "cntr_vol_qty")=="") ? 0 : parseFloat(sheetObj.GetCellValue(tpSzs[idx], "cntr_vol_qty"));
                var rterm=sheetObj.GetCellValue(tpSzs[idx], "rcv_term_cd");
                var dterm=sheetObj.GetCellValue(tpSzs[idx], "de_term_cd");
				// special cargo
                if(sheetObj.GetCellValue(tpSzs[idx], "dcgo_flg") == 1) dcgo_flg += vol;
                if(sheetObj.GetCellValue(tpSzs[idx], "rc_flg") == 1) rc_flg += vol;
                if(sheetObj.GetCellValue(tpSzs[idx], "awk_cgo_flg") == 1) awk_cgo_flg += vol;
                if(sheetObj.GetCellValue(tpSzs[idx], "bb_cgo_flg") == 1) bb_cgo_flg += vol;
                if(sheetObj.GetCellValue(tpSzs[idx], "hngr_flg") == 1) hngr_flg += vol;
                if(sheetObj.GetCellValue(tpSzs[idx], "soc_flg") == 1) soc_flg += vol;
				// dry cargo
                if(sheetObj.GetCellValue(tpSzs[idx], "dcgo_flg") == 0 &&
                    sheetObj.GetCellValue(tpSzs[idx], "rc_flg") == 0 &&
                    sheetObj.GetCellValue(tpSzs[idx], "awk_cgo_flg") == 0 &&
                    sheetObj.GetCellValue(tpSzs[idx], "bb_cgo_flg") == 0){
					dry_cgo_flg += vol;
				}
				// receive term / delivery term
				if(rterm == 'Y') rcv_term_y  += vol;
				if(rterm == 'D') rcv_term_d  += vol;
				if(rterm == 'S') rcv_term_s  += vol;
				if(rterm == 'T') rcv_term_t  += vol;
				if(rterm == 'I') rcv_term_i  += vol;
				if(dterm == 'Y') de_term_y  += vol;
				if(dterm == 'D') de_term_d  += vol;
				if(dterm == 'S') de_term_s  += vol;
				if(dterm == 'T') de_term_t  += vol;
				if(dterm == 'O') de_term_o  += vol;
				// total volumn
				op_cntr_qty += vol;
			}
		}
		if(cntrTpsz == 'D4' && document.form.flex_hgt_flg.value == 'Y'){
			//alert("* flex_hgt_flg : " + document.form.flex_hgt_flg.value);
			tpSzs=ComFindText(sheetObj, "cntr_tpsz_cd", "D5");
			if(tpSzs != null && tpSzs.length > 0) {
				for(idx=0;idx<tpSzs.length;idx++){
					// values
                    var vol=(sheetObj.GetCellValue(tpSzs[idx], "cntr_vol_qty")=="") ? 0 : parseFloat(sheetObj.GetCellValue(tpSzs[idx], "cntr_vol_qty"));
                    var rterm=sheetObj.GetCellValue(tpSzs[idx], "rcv_term_cd");
                    var dterm=sheetObj.GetCellValue(tpSzs[idx], "de_term_cd");
					// special cargo
                    if(sheetObj.GetCellValue(tpSzs[idx], "dcgo_flg") == 1) dcgo_flg += vol;
                    if(sheetObj.GetCellValue(tpSzs[idx], "rc_flg") == 1) rc_flg += vol;
                    if(sheetObj.GetCellValue(tpSzs[idx], "awk_cgo_flg") == 1) awk_cgo_flg += vol;
                    if(sheetObj.GetCellValue(tpSzs[idx], "bb_cgo_flg") == 1) bb_cgo_flg += vol;
                    if(sheetObj.GetCellValue(tpSzs[idx], "hngr_flg") == 1) hngr_flg += vol;
                    if(sheetObj.GetCellValue(tpSzs[idx], "soc_flg") == 1) soc_flg += vol;
					// dry cargo
                    if(sheetObj.GetCellValue(tpSzs[idx], "dcgo_flg") == 0 &&
                        sheetObj.GetCellValue(tpSzs[idx], "rc_flg") == 0 &&
                        sheetObj.GetCellValue(tpSzs[idx], "awk_cgo_flg") == 0 &&
                        sheetObj.GetCellValue(tpSzs[idx], "bb_cgo_flg") == 0){
						dry_cgo_flg += vol;
					}
					// receive term / delivery term
					if(rterm == 'Y') rcv_term_y  += vol;
					if(rterm == 'D') rcv_term_d  += vol;
					if(rterm == 'S') rcv_term_s  += vol;
					if(rterm == 'T') rcv_term_t  += vol;
					if(rterm == 'I') rcv_term_i  += vol;
					if(dterm == 'Y') de_term_y  += vol;
					if(dterm == 'D') de_term_d  += vol;
					if(dterm == 'S') de_term_s  += vol;
					if(dterm == 'T') de_term_t  += vol;
					if(dterm == 'O') de_term_o  += vol;
					// total volumn
					op_cntr_qty += vol;
				}
			}
		}
		// return array
		var cntrQtyArr=new Array();
		cntrQtyArr[0]=cntrTpsz;
		cntrQtyArr[1]="Difference";
		cntrQtyArr[2]=Math.round(dry_cgo_flg * 1000) / 1000;
		cntrQtyArr[3]=Math.round(dcgo_flg * 1000) / 1000;
		cntrQtyArr[4]=Math.round(rc_flg * 1000) / 1000;
		cntrQtyArr[5]=Math.round(awk_cgo_flg * 1000) / 1000;
		cntrQtyArr[6]=Math.round(bb_cgo_flg * 1000) / 1000;
		cntrQtyArr[7]=Math.round(hngr_flg * 1000) / 1000;
		cntrQtyArr[8]=Math.round(soc_flg * 1000) / 1000;
		cntrQtyArr[9]=Math.round(rcv_term_y * 1000) / 1000;
		cntrQtyArr[10]=Math.round(rcv_term_d * 1000) / 1000;
		cntrQtyArr[11]=Math.round(rcv_term_s * 1000) / 1000;
		cntrQtyArr[12]=Math.round(rcv_term_t * 1000) / 1000;
		cntrQtyArr[13]=Math.round(rcv_term_i * 1000) / 1000;
		cntrQtyArr[14]=Math.round(de_term_y * 1000) / 1000;
		cntrQtyArr[15]=Math.round(de_term_d * 1000) / 1000;
		cntrQtyArr[16]=Math.round(de_term_s * 1000) / 1000;
		cntrQtyArr[17]=Math.round(de_term_t * 1000) / 1000;
		cntrQtyArr[18]=Math.round(de_term_o * 1000) / 1000;
		cntrQtyArr[19]=Math.round(op_cntr_qty * 1000) / 1000;
		return cntrQtyArr;
	}
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	function callbackPckTp(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "pck_tp_cd",returnVal.cd);
	}
	function calbackAdjVol(cntrNo, returnVal){
		//alert("calbackAdjVol -> returnVal = " + returnVal);
		var sheetObj=sheetObjects[3];
		var formObj=document.form;
		if(returnVal!=null && returnVal.length>0){
			// delete container
			ComRowDeleteComplete(sheetObj, "cntr_no", cntrNo);
			//
			var rcnt=returnVal==null ? 0 : returnVal.length;
			for(var ir=0;ir<rcnt;ir++){
				var rarr=returnVal[ir];
				var nrow=sheetObj.DataInsert(-1);
				//alert("" + rarr);
				for(var ic=0;ic<rarr.length;ic++){
					sheetObj.SetCellValue(nrow, ic,rarr[ic],0);
				}
				//alert(document.form.bkg_no.value +"="+ rarr[2])
				if(formObj.bkg_no.value == rarr[2]){
					var arrRow=ComFindText(sheetObjects[1], "cntr_no", rarr[1]);
					//alert(arrRow + " -> " + rarr[1] + " : " + rarr[4]);
					if(rarr[5] == 0){
						sheetObjects[1].SetCellValue(arrRow[0], "cntr_vol_qty",0,0);
						sheetObjects[1].SetCellValue(arrRow[0], "cntr_prt_flg",1,0);
						sheetObjects[1].SetRowStatus(arrRow[0],'D');
						sheetObjects[1].SetRowHidden(arrRow[0],1);
					} if(rarr[5] == 1){
						sheetObjects[1].SetCellValue(arrRow[0], "cntr_vol_qty",1,0);
						sheetObjects[1].SetCellValue(arrRow[0], "cntr_prt_flg",1,0);
					} else{
						sheetObjects[1].SetCellValue(arrRow[0], "cntr_vol_qty",rarr[5],0);
						sheetObjects[1].SetCellValue(arrRow[0], "cntr_prt_flg",(rarr[5] == '1') ? 0 : 1,0);
					}
				}
			}
		}
		// set focus
		sheetObj.SelectCell(sheetObj.GetSelectRow(), "cntr_vol_qty", false);
		//
		changeEditableByConfirm('RLS');
		// Confirm Release 상태로..
		formObj.evnt_usr_id.value='';
		formObj.evnt_dt.value='';
		formObj.fnl_cfm_flg.value='N';
		formObj.modify_fnl_cfm_flg.value='Y';
		// confirm data changing 
		formObj.dirty_flag.value='Y';
		// calculateCntrQty
		calculateCntrQty();
	}
	function callbackMove(rcopy, rvol){
		//alert(rcopy + " -> " + rvol);
		var sheetObj=sheetObjects[1];
		var formObj=document.form;
		if(rcopy == 'C'){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_cfm_flg",0,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_prt_flg",1,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_vol_qty",rvol,0);
		}else if(rcopy == 'M'){
			sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
		}
		// Confirm the status of all containers, release
		for(ir=sheetObj.HeaderRows();ir<=sheetObj.RowCount();ir++ ){
			sheetObj.SetCellValue(ir, "cntr_cfm_flg",0,0);
		}
		// calculateCntrQty
		calculateCntrQty();
		// all release..
		var cntrCount=sheetObjects[1].RowCount();
		for(ir=1;ir<=cntrCount;ir++){
			sheetObjects[1].SetCellValue(ir, "cntr_cfm_flg",0,0);
			//changeCntrStatus
			//changeCntrStatus(ir);
		}
		//
		changeEditableByConfirm('RLS');
		// Confirm Release 
		formObj.evnt_usr_id.value='';
		formObj.evnt_dt.value='';
		formObj.fnl_cfm_flg.value='N';
		formObj.modify_fnl_cfm_flg.value='Y';
		// confirm data changing 
		formObj.dirty_flag.value='Y';
		// calculateCntrQty
		calculateCntrQty();
	}	
	/* ESM_BKG_0901 : */
	function callbackNotUpdatedContainer(returnVal){
		//alert(returnVal);
		var newRow=sheetObjects[1].DataInsert(-1);
		
		sheetObjects[1].SetCellValue(newRow, "cntr_dp_seq",ComGetMaxValue(sheetObjects[1], "cntr_dp_seq")+1);
		sheetObjects[1].SetCellValue(newRow, "cntr_vol_qty",1,0);
		sheetObjects[1].SetCellValue(newRow, "bkg_no",document.form.bkg_no.value);
//		sheetObjects[1].SetCellValue(newRow, "cntr_no_old",returnVal);
//		sheetObjects[1].SetCellValue(newRow, "cntr_no",returnVal);
		//Parameter added from sub screen
		var arrRetVal=returnVal.split("|$$|");
		sheetObjects[1].SetCellValue(newRow, "cntr_no_old", arrRetVal[0]);
		sheetObjects[1].SetCellValue(newRow, "cntr_no",arrRetVal[0]);

		sheetObjects[1].SetCellValue(newRow, "org_yd_cd",arrRetVal[1]); 
		var cnmvEvntDt = 	arrRetVal[2].substring(1,5) + "-"  //YYYYMMDD HHMI -> YYYY-MM-DD HH:MI
						  + arrRetVal[2].substring(5,7) + "-" 
						  + arrRetVal[2].substring(7,9) + " " 
						  + arrRetVal[2].substring(10,12) + ":" 
						  + arrRetVal[2].substring(12,14);
		sheetObjects[1].SetCellValue(newRow, "cnmv_evnt_dt", cnmvEvntDt);

	}
	/* ESM_BKG_0391 */
	function callbackMultiShp(rArray){
		if(rArray == null)	return;
		
		var formObj = document.form;
		var pck_qty= 0;
		var pck_tp_cd="";
		var cntr_wgt=0;
		var wgt_ut_cd="";
		var meas_qty=0;
		var meas_ut_cd="";
		var cntr_seq="";
		var seal_no1="";
		var seal_no2="";
		var temp_cntr_seq="";

		var newRow=0;
		
		var maxLen=rArray[0].length;
		
		var selRows=sheetObjects[1].FindCheckedRow("sel");
		var idxArr="";
		if(selRows == ''){
			selRows = 0;
		}else{
			idxArr=selRows.split("|");
			selRows = idxArr.length;
		}
		if(selRows==1){
			for(var i=0; i<rArray[0].length;i++){
				//add
				pck_qty		+=rArray[0][i][5];
				pck_tp_cd	 =rArray[0][i][6];
				cntr_wgt 	+=rArray[0][i][9];
				wgt_ut_cd    =rArray[0][i][10];
				meas_qty	+=rArray[0][i][11];
				meas_ut_cd	 =rArray[0][i][12];
				seal_no1	 =rArray[0][i][17];
				seal_no2	 =rArray[0][i][18];
			}
			var selRowNo=idxArr;
			setCallbackMultiShpSheetData(selRowNo, pck_qty, pck_tp_cd, cntr_wgt, wgt_ut_cd, meas_qty, meas_ut_cd, seal_no1, seal_no2);
			sheetObjects[1].SetCellValue(selRowNo, "bkg_no",formObj.bkg_no.value,0);
			if(formObj.rcv_term_cd.value != 'M'){
				sheetObjects[1].SetCellValue(selRowNo, "rcv_term_cd",formObj.rcv_term_cd.value,0);
			}
			if(formObj.de_term_cd.value != 'M'){
				sheetObjects[1].SetCellValue(selRowNo, "de_term_cd",formObj.de_term_cd.value,0);
			}
			sheetObjects[1].SelectCell(selRowNo, "cntr_no");
			setShpFlg(true);
			
			var cntr_no=sheetObjects[1].GetCellValue(selRowNo, "cntr_no");
			// delete seal no
			ComRowDelete(sheetObjects[2], "cntr_no", cntr_no);
			if(seal_no1 != ""){
				setMultiShpSealNo(formObj.bkg_no.value, cntr_no, seal_no1);
			}
			if(seal_no2 != ""){
				setMultiShpSealNo(formObj.bkg_no.value, cntr_no, seal_no2);
			}
		}else{
			temp_cntr_seq="";
			var listCntrSeq="";
			var isDup = false;
			
			//// listCntrSeq (distinct CNTR_SEQ) <--- cntr_seq !! ////////////////////////////////
			if(rArray[0].length>0){
				for(var i=0; i<rArray[0].length;i++){
					isDup = false;
					if(i==0){
						listCntrSeq += rArray[0][i][2]+",";
						continue;
					}
					
					for(var j=0; j < i; j++){
						if(rArray[0][i][2] == rArray[0][j][2]){
							isDup = true;
							break;
						}
					}
					if(isDup)	continue;
					
					listCntrSeq += rArray[0][i][2]+",";
				}
			}
			listCntrSeq = listCntrSeq.substring(0,listCntrSeq.length-1)
			
			var arrCntrSeq	= listCntrSeq.split(",");
			var u_pck_tp_cd = "";
			var i_multi_ship= 0;
			
			
			if(rArray[0].length>0){
				//distinct CNTR_SEQ
				for(var i=0; i<arrCntrSeq.length;i++){
					pck_qty		= 0;
					pck_tp_cd	= "";
					cntr_wgt	= 0;
					wgt_ut_cd	= "";
					meas_qty	= 0;
					meas_ut_cd	= "";
					seal_no1	= "";
					seal_no2	= "";
					i_multi_ship= 0;
					u_pck_tp_cd	= "";

					//list multi shipment data
					for(var j=0; j<rArray[0].length;j++){
						temp_cntr_seq	= rArray[0][j][2];
						
						if(temp_cntr_seq == arrCntrSeq[i]){
							pck_qty		+=rArray[0][j][5];
							pck_tp_cd	 =rArray[0][j][6];
							cntr_wgt 	+=rArray[0][j][9];
							wgt_ut_cd    =rArray[0][j][10];
							meas_qty	+=rArray[0][j][11];
							meas_ut_cd	 =rArray[0][j][12];
							seal_no1	 =rArray[0][j][17];
							seal_no2	 =rArray[0][j][18];

							if(i_multi_ship == 0)	u_pck_tp_cd = pck_tp_cd;
							i_multi_ship++;
						}
					}
					//// distinct cntr_seq SUM ////////////////////////////////
					newRow=sheetObjects[1].DataInsert(-1);
					setCallbackMultiShpSheetData(newRow, pck_qty, u_pck_tp_cd, cntr_wgt, wgt_ut_cd, meas_qty, meas_ut_cd, seal_no1, seal_no2);
					
					sheetObjects[1].SetCellValue(newRow, "bkg_no",formObj.bkg_no.value,0);
					
					if(formObj.rcv_term_cd.value != 'M'){
						sheetObjects[1].SetCellValue(newRow, "rcv_term_cd",formObj.rcv_term_cd.value,0);
					}
					if(formObj.de_term_cd.value != 'M'){
						sheetObjects[1].SetCellValue(newRow, "de_term_cd",formObj.de_term_cd.value,0);
					}
					sheetObjects[1].SelectCell(newRow, "cntr_no");
					if(seal_no1 != ""){
						setMultiShpSealNo(formObj.bkg_no.value, "", seal_no1);
					}
					if(seal_no2 != ""){
						setMultiShpSealNo(formObj.bkg_no.value, "", seal_no2);
					}
					setShpFlg(true);
				}
			}
		}
		/* calculateCntrQty */
		calculateCntrQty();
		document.form.dirty_flag.value='Y';
	}

	function setCallbackMultiShpSheetData(row, val1, val2, val3, val4, val5, val6, val7, val8){
		// Insert인 경우는 유지하게 변경
		if(sheetObjects[1].GetCellValue(row,"ibflag") != "I")
			sheetObjects[1].SetCellValue(row,"ibflag","U",0);
		sheetObjects[1].SetCellValue(row, "pck_qty"		,val1,0);
		sheetObjects[1].SetCellValue(row, "pck_tp_cd"	,val2,0);
		sheetObjects[1].SetCellValue(row, "cntr_wgt"	,val3,0);
		sheetObjects[1].SetCellValue(row, "wgt_ut_cd"	,val4,0);
		sheetObjects[1].SetCellValue(row, "meas_qty"	,val5,0);
		sheetObjects[1].SetCellValue(row, "meas_ut_cd"	,val6,0);
		sheetObjects[1].SetCellValue(row, "seal1_no"	,val7,0);
		sheetObjects[1].SetCellValue(row, "seal2_no"	,val8,0);
	}
	
	function setMultiShpSealNo(bkg_no, cntr_no, seal_no){
		var sealNewRow=sheetObjects[2].DataInsert(-1);
		sheetObjects[2].SetCellValue(sealNewRow, "bkg_no"		,bkg_no,0);
		sheetObjects[2].SetCellValue(sealNewRow, "cntr_no"		,cntr_no,0);
		sheetObjects[2].SetCellValue(sealNewRow, "cntr_seal_no"	,seal_no,0);
		sheetObjects[2].SetCellValue(sealNewRow, "old_cntr_seal_no"	,seal_no,0);
	}
	
	/**
	 * BKG_CNTR_SHP, PRN_FLG CHECK
	 * @param flag
	 */
	function setShpFlg(flag){
		if(flag){
			document.form.shp_flg.value = "Y";
		}else{
			document.form.shp_flg.value = "N";
		}
	}
	/* whether to change the screen data check */
	function checkModify(){
		var formObj=document.form;
		if(ComGetObjValue(formObj.dirty_flag) == "Y"){
			doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
		}
	}
	function searchData(bkgNo){
		var formObj=document.form;
		ComSetObjValue(formObj.bkg_no, bkgNo);
		ComSetObjValue(formObj.dirty_flag, "N");
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	}
	function setInquiryDisableButton() {
		if(scrnAuth == 'R'){
			// button
			ComBtnDisable("btn_t6save");
			ComBtnDisable("btn_t6cntrconfirm");
			ComBtnDisable("btn_t6cntrrelease");
			ComBtnDisable("btn_t6gridadd");
			ComBtnDisable("btn_t6griddel");
			ComBtnDisable("btn_t6gridmove");
			ComBtnDisable("btn_t6sequp");
			ComBtnDisable("btn_t6seqdown");
			// sheet
			sheetObjects[0].SetEditable(0);
			sheetObjects[1].SetEditable(0);
			sheetObjects[2].SetEditable(0);
			// object
			document.form.bkg_wgt_ut_cd.disabled=true;
			document.form.bkg_meas_ut_cd.disabled=true;
			// confirm data changing
			document.form.dirty_flag.value='N';
		}
	}
	function chk_china_cntr_seal() {
		var formObj=document.form;
		var cn_flg=formObj.cn_dir_flg.value;
	    if(cn_flg == 'Y' ){
			var cntrSheet=sheetObjects[1];
			for(ir=cntrSheet.HeaderRows();ir<=cntrSheet.RowCount();ir++ ){
                if( (ComIsEmpty(cntrSheet.GetCellValue(ir, "seal1_no")) ||
                    ComIsEmpty(cntrSheet.GetCellValue(ir, "seal1_knd_cd")) ||
                    ComIsEmpty(cntrSheet.GetCellValue(ir, "seal1_pty_tp_cd"))) &&
                    ( ComIsContainsChars( cntrSheet.GetCellValue(ir, "cntr_tpsz_cd").substring(0,1),"TFAP" )==false )) {
					//BKG08188
					ComShowMessage(ComGetMsg("BKG08188"));
					cntrSheet.SelectCell(ir, "seal1_no") ;
					return false;
				}
			}
		}
		return true;
	}
