/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0001.js
*@FileTitle  : Agreement Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19 
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /** 
     * @extends FMS
     * @class AgreementCreation : Agreement Creation definition of biz script for creation screen
     */

    // common global variables 
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;

    var dftDateYmd = "Ymd";
    var dftUserFormatYmdhhmi = "####-##-## ##:##";
    
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	 var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
         var sheetObject5=sheetObjects[4];
         var sheetObject6=sheetObjects[5];
         var sheetObject7=sheetObjects[6];
		 var sheetObject8=sheetObjects[7];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_creation":
            		sheetObject5.SetRowStatus(1,"I");
            		doActionIBSheet(sheetObject2,formObject,IBINSERT);
                    break;
				case "btn_retrive":
					if(!initConfirm()) return;
					doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					break;
				case "btn_new":
					if(!initConfirm()) return;
					//formObject.flet_olay_comm_rt_amt.value="2.5";
					clearAll();
					break;
				case "btn_save":
					sheetObject5.SetRowStatus(1,"U");
					doActionIBSheet(sheetObject5,formObject,IBSAVE);
					break;
				case "btn_delete":
					doActionIBSheet(sheetObject5,formObject,IBDELETE);
					break;
                case "btn_add":
                    sheet_DataInsert(sheetObject2,'hir_');
                    break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject2, "hir_DelChk")) {
						rowRemove(sheetObject2, "hir_");
					}
                    break;
				case "btn_t2Add":
					sheet_DataInsert(sheetObject3,'otr_');
                    break;
				case "btn_t2Ins":
                    sheetObject3.DataInsert();
                    break;
				case "btn_t2Del":
					if(checkBoxCheckYn(sheetObject3, "otr_DelChk")) {
						rowRemove(sheetObject3, "otr_");
					}
                    break;
				case "btn_t3Add":
					sheet_DataInsert(sheetObject4,'pay_');
                    break;
				case "btn_t3Ins":
                    sheetObject4.DataInsert();
                    break;
				case "btn_t3Del":
					if(checkBoxCheckYn(sheetObject4, "pay_DelChk")) {
						rowRemove(sheetObject4, "pay_");
					}
                    break;
				case "btn_t5Add":					
					sheet_DataInsert(sheetObject6,'cpf_');
                    break;
				case "btn_t5Ins":
					sheet_DataInsert(sheetObject6,'cpf_','Ins');
                    break;
				case "btn_t5E-mail":					
            		ComOpenPopup("ESM_FMS_0084.do", 460, 370, "setEmail", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0084");            		
					break;
				case "btn_t5Download":
					break;
				case "btn_t5FiletoEmail":
					break;
				case "btn_t5Open":
					break;
				case "btn_t5Delete":
					if(checkBoxCheckYn(sheetObject6, "cpf_DelChk")) {
						rowRemove(sheetObject6, "cpf_");
					}
					break;
				case "btn_t6Add":
					sheet_DataInsert(sheetObject7,'cef_');
                    break;
				case "btn_t6Ins":
					sheet_DataInsert(sheetObject7,'cef_','Ins');
                    break;
				case "btn_t6E-mail":					
            		ComOpenPopup("ESM_FMS_0084.do", 460, 370, "setEmail", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0084");					
					break;
				case "btn_t6Download":
					break;
				case "btn_t6Open":
					break;
				case "btn_t6Delete":
					if(checkBoxCheckYn(sheetObject7, "cef_DelChk")) {
						rowRemove(sheetObject7, "cef_");
					}
					break;
				case "btn_t7Add":
					if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						 return;
					}
					sheet_DataInsert(sheetObject8,'vsl_');
                    break;
				case "btn_t7Ins":
                    sheetObject8.DataInsert();
                    break;
				case "btn_t7Del":
					if(checkBoxCheckYn(sheetObject8, "vsl_DelChk")) {
						rowRemove(sheetObject8, "vsl_");
					}
                    break;		
				case "cp_da":
	                    var cal=new ComCalendar();
	                    cal.select(form.cp_dt, 'yyyy-MM-dd');
	                    break;
				case "ef_dt":
					var cal=new ComCalendar();
					cal.select(form.ori_eff_dt, 'yyyy-MM-dd');
				 break;
				case "vsl_bld_da": 
					var cal=new ComCalendar();
					cal.select(form.vsl_bld_dt, 'yyyy-MM-dd');
				 break;
				case "btn_vslpop" :
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0022");
				break;
				case "contract_no":
					 if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01138'));
						 return;
					 }
					 ComOpenPopupWithTarget("ESM_FMS_0023.do?ctrtFlag=Y&vsl_cd=" + formObject.vsl_cd.value, 520, 415, "flet_ctrt_no:flet_ctrt_no", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0023");
					 break;
				case "ex_dt":
					var cal=new ComCalendar();
					cal.select(form.ori_exp_dt, 'yyyy-MM-dd');	
					break;
				case "owner_code":
					if(comboObjects[0].GetSelectCode()== "TO") {
						ComOpenPopup("ESM_FMS_0070.do?condFlag=CP&agmtFlag=C", 620, 433, "setCustomrCode", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0070");
					} else {
						ComOpenPopup("ESM_FMS_0070.do?condFlag=VP&agmtFlag=C", 620, 433, "setVendorCode", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0070");
					}
					break;
				case "flag_code": 
					ComOpenPopup("COM_ENS_0M1.do", 720, 470, "setFlagCode", "1,0,1,1,1,1", true, false, 0, 0, 0, "COM_ENS_0M1");
					break;
				case "img_bod_port_cd": 
					ComOpenPopup("COM_ENS_051.do", 780, 550, "setBodPortCd", "1,0,1,1,1,1", true, false, 0, 0, 0, "COM_ENS_051");
					break;
				case "img_bor_port_cd": 
					ComOpenPopup("COM_ENS_051.do", 780, 550, "setBorPortCd", "1,0,1,1,1,1", true, false, 0, 0, 0, "COM_ENS_051");
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
     * Registering IBMultiCombo Object generated on Page to comboObject Array <br>
     * comboObjects Array is defined on the top of source. This function is called automatically when IBMultiCombo Object is generated by {@link CoObject#ComComboObject} <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){          
       comboObjects[comboCnt++]=combo_obj;
    }

    /**
     * initializing sheet 
     * implementing onLoad event handler in body tag 
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        
        initUpload();
        initControl();
        
        t1sheet1_OnLoadFinish(sheetObjects[1]);
    }
    
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/ESM_FMS_0001GS.do'
 			,Files:[]
	 		,BeforeAddFile : function(result){
			 	return true;
			}
			,BeforeSaveStatus : function(result){ 
			 	return true;
			}
			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			ComUploadRemoveFile(upload1, "", true);
	      			
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			var formObj = document.form;
	      			var arrXml=sXml.split("|$$|");
	      			if (arrXml.length > 0) sheetObjects[1].LoadSaveData(convert2ibsheet7(arrXml[0]));
	      			if (arrXml.length > 1) sheetObjects[2].LoadSaveData(convert2ibsheet7(arrXml[1]));
	      			if (arrXml.length > 2) sheetObjects[3].LoadSaveData(convert2ibsheet7(arrXml[2]));
	      			if (arrXml.length > 3) sheetObjects[4].LoadSaveData(convert2ibsheet7(arrXml[3]));
	      			if (arrXml.length > 4) sheetObjects[5].LoadSaveData(convert2ibsheet7(arrXml[4]));
	      			if (arrXml.length > 5) sheetObjects[6].LoadSaveData(convert2ibsheet7(arrXml[5]));
	      			if (arrXml.length > 6) sheetObjects[7].LoadSaveData(convert2ibsheet7(arrXml[6]));
	      			if (arrXml.length > 7) sheetObjects[0].LoadSearchData(convert2ibsheet7(arrXml[7]));
	      			
	      			if(comboObjects[1].GetSelectCode()== "ACT") {
						flet_ctrt_fact_cd.SetEnable(0);
						setOwnerCodeReadOnly();
					}
	      			ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);
	      			ComOpenWait(false);
				   
	      			if(insertFlag){
					   if(typeof pSheetObj.GetEtcData("fletCtrtNo") != "undefined") {
						   //Handling after saving (Setting other information into TextBox by XML)
						   formObj.flet_ctrt_no.value=pSheetObj.GetEtcData("fletCtrtNo");
						   document.all.btn_creation.style.display="none";
						   document.all.btn_save.style.display="";
						   document.all.btn_delete.style.display="";
						   document.all.btn_creation2.style.display="none";
						   document.all.btn_save2.style.display="";
						   document.all.btn_delete2.style.display="";
		               }
	      			}
	      		}else {
					ComShowMessage(result.msg);
				}
			}
	 		,AfterAddFile:function(result){	 				 			
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
			    var serialNo = files[files.length-1].GetSerialNo();
 				var prefix="";
 				
 				if(pSheetObj.id == "t5sheet1") {
 					prefix="cpf_"
 						
 					var sheet_serial = pSheetObj.GetCellValue(pRow, prefix+"file_sav_id");
 				    ComUploadRemoveFile(upload1, sheet_serial, false); 								
 				    pSheetObj.SetCellValue(pRow, prefix+"file_sav_id",serialNo,0); //현재 full local url 은 지원되지않음.
 					
 					sheetObjects[5].SetCellValue(pRow, prefix+"file_path",fileName,0);
 					sheetObjects[5].SetCellValue(pRow, prefix+"file_nm",fileName,0);
 						
 				} else if(pSheetObj.id == "t6sheet1") {
 					prefix="cef_"
 						
 	 				var sheet_serial = pSheetObj.GetCellValue(pRow, prefix+"file_sav_id");
 				    ComUploadRemoveFile(upload1, sheet_serial, false); 								
 				    pSheetObj.SetCellValue(pRow, prefix+"file_sav_id",serialNo,0); //현재 full local url 은 지원되지않음.
 					
 					sheetObjects[6].SetCellValue(pRow, prefix+"file_path",fileName,0);
 					sheetObjects[6].SetCellValue(pRow, prefix+"file_nm",fileName,0); 						
 				}
			}
 		});
 	}
    
	/**
     * Event occurred when mouse pointer is moving <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	Selected Button of sheetObj
     * @param {ibsheet} Shift     	Selected Shift of sheetObj
     * @param {int} 	X     		X Coordinate Value
     * @param {int} 	Y     		Y Coordinate Value
     **/
	function t5sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		var row     = sheetObj.MouseRow(),
        col     = sheetObj.MouseCol(),
        info    = null;
        if (row > 0 &&sheetObj.ColSaveName(col) == "cpf_file_nm") {
            info = sheetObj.GetCellElement(row, col, 1);
    		pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
            upload1.SetFileUploadElement(info);
        } 
		changeGetMousePointer(sheetObj,"cpf_");
	}
	/**
     * Event occurred when mouse pointer is moving <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	Selected Button of sheetObj
     * @param {ibsheet} Shift     	Selected Shift of sheetObj
     * @param {int} 	X     		X Coordinate Value
     * @param {int} 	Y     		Y Coordinate Value
     **/
	function t6sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		var row     = sheetObj.MouseRow(),
	    col     = sheetObj.MouseCol(),
	    info    = null;
	    if (row > 0 &&sheetObj.ColSaveName(col) == "cef_file_nm") {
	        info = sheetObj.GetCellElement(row, col, 1);
	        pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
	        upload1.SetFileUploadElement(info);
	    } 
		changeGetMousePointer(sheetObj,"cef_");
	}
	
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
     */
	function t1sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObjects[3], document.form, IBROWSEARCH, "ComCd");
    	CoFmsGetCombo('FORM', document.form, sheetObj, 'CD02532', 'flet_gmt_lmt_cd', 'flet_gmt_lmt_nm');
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        	case "sheet1":      //sheet1 init
        	    with(sheetObj){
					var prefix="oli_";  
					var HeadTitle="Item Name|From Date|To Date|Cur|Amount";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Text",      Hidden:0,  Width:134,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",       KeyField:0,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",       KeyField:0,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"otr_expn_amt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(0);
					FitColWidth("32|13|13|8|34");
                    }
                break;
            case "t1sheet1":      //t1sheet1 init
                with(sheetObj){
					var prefix="hir_";
					var HeadTitle="|Sel|Seq|From Date|To Date|Cur 1|Daily Hire|Cur 2|Daily Hire|Ori From Date|Ori To Date ";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
					 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
					 {Type:"Text",      Hidden:0,  Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hir_curr_n1st_cd", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",     Hidden:0,  Width:134,  Align:"Right",   ColMerge:0,   SaveName:prefix+"hir_rt_n1st_amt",  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
					 {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hir_curr_n2nd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",     Hidden:0,  Width:134,  Align:"Right",   ColMerge:0,   SaveName:prefix+"hir_rt_n2nd_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
					 {Type:"Text",      Hidden:1, Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(1);
					//UI개선(201408 민정호)
					SetColProperty(0, prefix+"eff_dt", {Format:dftUserFormatYmdhhmi, AcceptKeys:"N"} );
					SetColProperty(0, prefix+"exp_dt", {Format:dftUserFormatYmdhhmi, AcceptKeys:"N"} );
					SetColProperty(0, prefix+"ori_eff_dt", {Format:dftUserFormatYmdhhmi, AcceptKeys:"N"} );
					SetColProperty(0, prefix+"ori_exp_dt", {Format:dftUserFormatYmdhhmi, AcceptKeys:"N"} );					
					SetColProperty(0, prefix+"hir_curr_n1st_cd", {AcceptKeys:"E" , InputCaseSensitive:1} );
					SetColProperty(0, prefix+"hir_curr_n2nd_cd", {AcceptKeys:"E" , InputCaseSensitive:1} );					
					
              }
                break;
			case "t2sheet1":      //t2sheet1 init
			    with(sheetObj){
					var prefix="otr_";
					var HeadTitle="|Sel|Seq|Item Name|Account Code|From Date|To Date|Cur|Amount|Acct Itm Seq|Ori Account Code|Ori From Date|Ori To Date|Ori Acct Itm Seq";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
					 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
					 {Type:"Popup",     Hidden:0, Width:252,  Align:"Left",    ColMerge:0,   SaveName:prefix+"acct_itm_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",           KeyField:1,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",           KeyField:1,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:62,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",     Hidden:0,  Width:99,   Align:"Right",   ColMerge:0,   SaveName:prefix+"otr_expn_amt",     KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
					 {Type:"Text",      Hidden:1, Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"acct_itm_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_acct_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_eff_dt",       KeyField:0,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:161,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_exp_dt",       KeyField:0,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:134,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_acct_itm_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(1);
					SetDataLinkMouse(prefix + "acct_itm_nm",1);
					SetShowButtonImage(1);					
					SetColProperty(prefix+"curr_cd", {AcceptKeys:"E" , InputCaseSensitive:1} );					
		      }
                break;
			case "t3sheet1":      //t3sheet1 init
			    with(sheetObj){
					var prefix="pay_";
					var HeadTitle="|Sel|Seq|Payment Term|From Date|To Date|Ori_From Date|Ori_To Date ";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
					 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
					 {Type:"Combo",     Hidden:0, Width:419,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ctrt_pay_term_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:223,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:223,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:187,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(1);
					//UI개선(201408 민정호)
					SetColProperty(prefix+"eff_dt", {Format:dftUserFormatYmdhhmi, AcceptKeys:"N"} );
					SetColProperty(prefix+"exp_dt", {Format:dftUserFormatYmdhhmi, AcceptKeys:"N"} );
					SetColProperty(prefix+"ori_eff_dt", {Format:dftUserFormatYmdhhmi, AcceptKeys:"N"} );
					SetColProperty(prefix+"ori_exp_dt", {Format:dftUserFormatYmdhhmi, AcceptKeys:"N"} );
		      }
                break;
			case "t4sheet1":      //t4sheet1 init
			    with(sheetObj){
					var HeadTitle="|Period ( + - Option)|Redelivery Range|Redelivery Notice ";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:317,  Align:"Left",    ColMerge:0,   SaveName:"chtr_prd_opt_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
					 {Type:"Text",      Hidden:0,  Width:367,  Align:"Left",    ColMerge:0,   SaveName:"rde_rng_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
					 {Type:"Text",      Hidden:0,  Width:277,  Align:"Left",    ColMerge:0,   SaveName:"rde_ntc_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(1);
					SetShowButtonImage(1);
		      }
                break;
			case "t5sheet1":      //t5sheet1 init
                with (sheetObj) {
					var prefix="cpf_";
					var HeadTitle="|Sel|CP File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id ";
					
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
					  {Type:"Popup",     Hidden:0, Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
					  {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",          KeyField:0,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",          KeyField:0,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Combo",     Hidden:0, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Image",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					 
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(1);
					SetImageList(0,"/opuscntr/img/ico_attach.gif");
					SetColHidden(prefix + "flet_file_tp_cd",1);
					SetColProperty(prefix+"flet_file_tp_cd", {ComboText:"CP", ComboCode:"CP"} );
					SetShowButtonImage(1);
			    }
                break;
			case "t6sheet1":      //t6sheet1 init
			    with(sheetObj){
					var prefix="cef_";
					var HeadTitle="|Sel|Certi File Upload|From|To|Contents|File Path|File Chtr Tp Cd|File Seq|File Download|File Sav Id ";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
					 {Type:"Popup",     Hidden:0, Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
					 {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",          KeyField:0,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",          KeyField:0,   CalcLogic:"",   Format:dftDateYmd,         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_sav_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(1);
					SetImageList(0,"/opuscntr/img/ico_attach.gif");
					SetColHidden(prefix + "flet_file_tp_cd",1);
					SetColProperty(prefix+"flet_file_tp_cd", {ComboText:"CF", ComboCode:"CF"} );
					SetShowButtonImage(1);
		      }
                break;   
			case "t7sheet1":      //t7sheet1 init
			    with(sheetObj){
					var prefix="vsl_";
					var HeadTitle="|Sel|Vessel Code|Vessel Name|Accounting|Report|Ori Vessel Code|Ori Vessel Name";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"DelChk" },
					 {Type:"Popup",     Hidden:0, Width:320,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"use_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, DefaultValue:"1" },
					 {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"flet_rpt_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, DefaultValue:"1"  },
					 {Type:"Text",      Hidden:1, Width:400,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_vsl_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:400,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_vsl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(120);
					SetEditable(1);
					SetDataLinkMouse(prefix + "vsl_cd",1);
					SetShowButtonImage(1);
		      }
                break; 
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    var insertFlag = false;
    function doActionIBSheet(sheetObj,formObj,sAction,gubun,row) {
    	insertFlag =false;
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBSEARCH:      
	        	var arrSheet=new Array();
	        	if(formObj.vsl_cd.value == "") {
	        		ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01138'));
		    		return;
	        	} else if(formObj.flet_ctrt_no.value == "") {
	        		ComAlertFocus(formObj.flet_ctrt_no, ComGetMsg('FMS01052'));
		    		return;
	        	}
	        	formObj.contract_no.style.cursor="default";
   				//document.images["contract_no"].name="no_contract_no";
   				flet_ctrt_tp_cd.SetEnable(0);
	        	formObj.f_cmd.value=SEARCH;
	        	var aryPrefix=new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");
	        	//var arrSheets = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4]);   			
	        	var sXml=sheetObj.GetSearchData("ESM_FMS_0001GS.do" , FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
				if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
				if (arrXml.length > 2) sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
				if (arrXml.length > 3) sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
				if (arrXml.length > 4) sheetObjects[5].LoadSearchData(arrXml[4],{Sync:1} );
				if (arrXml.length > 5) sheetObjects[6].LoadSearchData(arrXml[5],{Sync:1} );
				if (arrXml.length > 6) sheetObjects[7].LoadSearchData(arrXml[6],{Sync:1} );
				if (arrXml.length > 7) sheetObjects[0].LoadSearchData(arrXml[7],{Sync:1} );
				//*********** Getting data from CONTRACT Table(START) ***************//
				if(typeof sheetObjects[1].GetEtcData("fletCtrtNo") != "undefined") {
					tabObjects[0].SetSelectedIndex(0);
					document.all.btn_creation.style.display="none";
		        	document.all.btn_save.style.display="";
		        	document.all.btn_delete.style.display="";
		        	document.all.btn_creation2.style.display="none";
		        	document.all.btn_save2.style.display="";
		        	document.all.btn_delete2.style.display="";
				}
				//ComEtcDataToForm2(form,sheetObj,sPrefix,bValueClear)
				ComEtcDataToForm2(formObj,sheetObjects[1],"",true);
				//UI개선(201408 민정호)
/*				
				<SHEET>
				<DATA  TOTAL='0'>
				</DATA>
				<ETC-DATA>
				<ETC KEY='ctrtPayTermCd'><![CDATA[A|B|C|]]></ETC>
				<ETC KEY='fletCtrtFactNm'><![CDATA[Actual|Pseudo|]]></ETC>
				<ETC KEY='fletCtrtFactCd'><![CDATA[ACT|PSE|]]></ETC>
				<ETC KEY='fletCtrtTpCd'><![CDATA[TI|TO|OW|]]></ETC>
				<ETC KEY='ctrtPayTermNm'><![CDATA[Semi Month|15 days|Month|]]></ETC>
				<ETC KEY='fletCtrtTpNm'><![CDATA[T/C In|T/C Out|Ownership|]]></ETC>
				<ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC>
				<ETC KEY='Exception'><![CDATA[]]></ETC>
				</ETC-DATA>
				</SHEET>
*/				
/*				if(ComGetEtcData(arrXml[0],"fletCtrtTpCd") == 'TI'){
					flet_ctrt_tp_cd.SetSelectText("T/C In",false);					
				}else if(ComGetEtcData(arrXml[0],"fletCtrtTpCd") == 'TO'){
					flet_ctrt_tp_cd.SetSelectText("T/C Out",false);					
				}else if(ComGetEtcData(arrXml[0],"fletCtrtTpCd") == 'OW'){
					flet_ctrt_tp_cd.SetSelectText("Ownership",false);					
				}					
				
				if(ComGetEtcData(arrXml[0],"fletCtrtFactCd") == 'ACT'){
					flet_ctrt_fact_cd.SetSelectText("Actual",false);					
				}else if(ComGetEtcData(arrXml[0],"fletCtrtFactCd") == 'PSE'){
					flet_ctrt_fact_cd.SetSelectText("Pseudo",false);					
				}*/									
				//----------------------------------------------------------------------------------------------
								
				//alert("one=" + ComEtcDataToForm2(formObj,sheetObjects[1],"",true));
				if(typeof sheetObjects[1].GetEtcData("declFlg") != "undefined") {
					if(sheetObjects[1].GetEtcData("declFlg") == "Y") {
						formObj.decl_flg.checked=true;
					} else {
						formObj.decl_flg.checked=false;
					}
				}
				if(sheetObjects[1].GetEtcData("fletCtrtTpCd") == "TO") {
					if(typeof sheetObjects[1].GetEtcData("custSeq") != "undefined") {
						formObj.cust_seq.value=sheetObjects[1].GetEtcData("custSeq");
						formObj.cust_cnt_cd.readOnly=false;
					}
				} else {
					if(typeof sheetObjects[1].GetEtcData("vndrSeq") != "undefined") {
						formObj.cust_seq.value=sheetObjects[1].GetEtcData("vndrSeq");
						formObj.cust_cnt_cd.readOnly=true;
						formObj.cust_cnt_cd.value="";
					}
				}
				if(comboObjects[1].GetSelectCode()== "ACT") {
					flet_ctrt_fact_cd.SetEnable(0);
					setOwnerCodeReadOnly();
				}
				//*********** Getting data from Hire Table(START) ******************//
				//ComEtcDataToForm2(form,sheetObj,sPrefix,bValueClear)
				ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);
				//*********** Getting data from Hire Table(END) ******************//
				/*
				if(ComFmsCheckCurrencyYn(formObj.oa_rsv_curr_cd.value)) {
					formObj.oa_rsv_amt.dataformat="int";
				} else {
					formObj.oa_rsv_amt.dataformat="float";
				}
				*/
	           break;
		   case IBINSERT:
			   insertFlag =true;
			   if(!validateForm(sheetObj,formObj,sAction))  return true;
		       formObj.contract_no.style.cursor="default";
		       //document.images["contract_no"].name="no_contract_no";
		       flet_ctrt_tp_cd.SetEnable(0);
			   formObj.f_cmd.value=MODIFY;
			   formObj.ibflag.value="I";

			   var paramFile1 = setFileUpload(sheetObjects[5], "cpf_");
			   var paramFile2 = setFileUpload(sheetObjects[6], "cef_"); 
			   			  
			   var fileList = upload1.GetList();
			   if(fileList.length > 0) {
				    //2.Binding IBSheet Data in QueryString
					var arrSheets1 = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4], sheetObjects[7]);
					var arrSheets2 = new Array(sheetObjects[5], sheetObjects[6]);
					var aryPrefix2 = new Array("cpf_file_sav_id","cef_file_sav_id");
					var sParam1 = ComGetFileSaveString(arrSheets2, upload1, aryPrefix2);
					if (sParam1 == "") return;
					var sParam2 = ComGetSaveString(arrSheets1);
					if (sParam2 == "") return;
					var sParam = sParam1  + "&" +  sParam2;
	
					//3.Binding Form Data in QueryString				
					var aryPrefix = new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");				
					//sParam += "&" + FormQueryStringOrg(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					sParam += "&" + paramFile1 + "&" + paramFile2;

					console.log("insert.................sParam = "+sParam);					
			 		paramToForm(sParam);			 		
					upload1.SaveStatus();
			   } else{
				   var arrSheets=new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4], sheetObjects[5], sheetObjects[6], sheetObjects[7]);
				   var sParam=ComGetSaveString(arrSheets);
				   //if (sParam == "") return;
				   var aryPrefix=new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");
				   sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
				   //ComOpenWait(true);
				   sXml=sheetObj.GetSaveData("ESM_FMS_0001GS.do", sParam);
					
				   var arrXml=sXml.split("|$$|");
				   if (arrXml.length > 0) sheetObjects[1].LoadSaveData(arrXml[0]);
				   if (arrXml.length > 1) sheetObjects[2].LoadSaveData(arrXml[1]);
				   if (arrXml.length > 2) sheetObjects[3].LoadSaveData(arrXml[2]);
				   if (arrXml.length > 3) sheetObjects[4].LoadSaveData(arrXml[3]);
				   if (arrXml.length > 4) sheetObjects[5].LoadSaveData(arrXml[4]);
				   if (arrXml.length > 5) sheetObjects[6].LoadSaveData(arrXml[5]);
				   if (arrXml.length > 6) sheetObjects[7].LoadSaveData(arrXml[6]);
				   if (arrXml.length > 7) sheetObjects[0].LoadSearchData(arrXml[7],{Sync:1} );
				   if(comboObjects[1].GetSelectCode()== "ACT") {
						flet_ctrt_fact_cd.SetEnable(0);
						setOwnerCodeReadOnly();
					}
				   ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);
				   //ComOpenWait(false);
				   if(typeof sheetObj.GetEtcData("fletCtrtNo") != "undefined") {
					   //Handling after saving (Setting other information into TextBox by XML)
					   formObj.flet_ctrt_no.value=sheetObj.GetEtcData("fletCtrtNo");
					   document.all.btn_creation.style.display="none";
					   document.all.btn_save.style.display="";
					   document.all.btn_delete.style.display="";
					   document.all.btn_creation2.style.display="none";
					   document.all.btn_save2.style.display="";
					   document.all.btn_delete2.style.display="";
	               }
			   }
			  
				break;
			case IBSAVE:      
				if(!validateForm(sheetObj,formObj,sAction))  return true;
				formObj.f_cmd.value=MULTI;
				formObj.ibflag.value="U";

				var paramFile1 = setFileUpload(sheetObjects[5], "cpf_");
				var paramFile2 = setFileUpload(sheetObjects[6], "cef_"); 
								
				var fileList = upload1.GetList();
				if(fileList.length > 0) {
					
				    //2.Binding IBSheet Data in QueryString
					var arrSheets1 = new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4], sheetObjects[7]);
					var arrSheets2 = new Array(sheetObjects[5],sheetObjects[6]);
					var aryPrefix2 = new Array("cpf_file_sav_id","cef_file_sav_id");
					var sParam1 = ComGetFileSaveString(arrSheets2, upload1, aryPrefix2);
					if (sParam1 == "") return;
					var sParam2 = ComGetSaveString(arrSheets1);
					if (sParam2 == "") return;
					var sParam = sParam1 + "&" +  sParam2;
	
					//3.Binding Form Data in QueryString				
					var aryPrefix = new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");				
					//sParam += "&" + FormQueryStringOrg(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					sParam += "&" + paramFile1 + "&" + paramFile2;

					console.log("save ......... sParam = "+sParam);					
			 		paramToForm(sParam);			 		
					upload1.SaveStatus();

				} else {
					var arrSheets=new Array(sheetObjects[1], sheetObjects[2], sheetObjects[3], sheetObjects[4], sheetObjects[5], sheetObjects[6], sheetObjects[7]);
					var sParam=ComGetSaveString(arrSheets);
					if (sParam == "") return;
					//3.Binding Form Data in QueryString
					var aryPrefix=new Array("hir_", "otr_", "pay_", "", "cpf_", "cef_", "vsl_", "oli_");
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					
					ComOpenWait(true);
					//4. Sending request to server, and get response
					var sXml=sheetObj.GetSaveData("ESM_FMS_0001GS.do", sParam);
					
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[1].LoadSaveData(arrXml[0]);
					if (arrXml.length > 1) sheetObjects[2].LoadSaveData(arrXml[1]);
					if (arrXml.length > 2) sheetObjects[3].LoadSaveData(arrXml[2]);
					if (arrXml.length > 3) sheetObjects[4].LoadSaveData(arrXml[3]);
					if (arrXml.length > 4) sheetObjects[5].LoadSaveData(arrXml[4]);
					if (arrXml.length > 5) sheetObjects[6].LoadSaveData(arrXml[5]);
					if (arrXml.length > 6) sheetObjects[7].LoadSaveData(arrXml[6]);
					if (arrXml.length > 7) sheetObjects[0].LoadSearchData(arrXml[7],{Sync:1} );
					
					if(comboObjects[1].GetSelectCode()== "ACT") {
						flet_ctrt_fact_cd.SetEnable(0);
						setOwnerCodeReadOnly();
					}
					ComEtcDataToForm2(formObj,sheetObjects[1],"hir_",true);
					ComOpenWait(false);
									
				}
			    break;
			case IBDELETE:      
				if(!delConfirm()) return;
				if(!validateForm(sheetObj,formObj,sAction))  return true;
				 formObj.f_cmd.value=REMOVE;
				 formObj.ibflag.value="D";
				 var sFormParam=FormQueryString(formObj);
				 var sParam=sFormParam;
				 ComOpenWait(true);
				 var sXml=sheetObj.GetSaveData("ESM_FMS_0001GS.do", sParam);
				 ComOpenWait(false);
				 sheetObj.LoadSaveData(sXml);
				 clearAll();
                break;
			case IBROWSEARCH:     
				if(gubun == "ComCd") {
					sheetObj.SetWaitImageVisible(0);
					formObj.f_cmd.value=SEARCH04;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			var fletCtrtTpCd=ComGetEtcData(sXml, "fletCtrtTpCd");
		   			var fletCtrtTpNm=ComGetEtcData(sXml, "fletCtrtTpNm");
		   			var fletCtrtFactCd=ComGetEtcData(sXml, "fletCtrtFactCd");
		   			var fletCtrtFactNm=ComGetEtcData(sXml, "fletCtrtFactNm");
		   			var ctrtPayTermCd=ComGetEtcData(sXml, "ctrtPayTermCd");
		   			var ctrtPayTermNm=ComGetEtcData(sXml, "ctrtPayTermNm");
		   			if(typeof ctrtPayTermCd != "undefined" && ctrtPayTermCd != "") {
	    				var comboCode=ctrtPayTermCd;
	    				var comboText=ctrtPayTermNm;
	    				setPayTermMakeCombo(sheetObj, comboText, comboCode);
	    			}
		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "") {
	    				var comboCode=fletCtrtTpCd;
	    				var comboText=fletCtrtTpNm;
	    				setDataCombo(comboObjects[0], comboText, comboCode);
	    			}
		   			if(typeof fletCtrtFactCd != "undefined" && fletCtrtFactCd != "") {
	    				var comboCode=fletCtrtFactCd;
	    				var comboText=fletCtrtFactNm;
	    				setDataCombo(comboObjects[1], comboText, comboCode);
	    			}
		   			sheetObj.SetWaitImageVisible(1);
				} else if(gubun == "Owner") {
					sheetObj.SetWaitImageVisible(0);
					if(comboObjects[0].GetSelectCode()== "TO") {
			            if(formObj.cust_cnt_cd.value == "") {
			            	ComAlertFocus(formObj.cust_cnt_cd, ComGetMsg('FMS01053'));
				    		return;
			            }
					} else if(comboObjects[0].GetSelectCode()== "OW") {
						//formObj.cust_seq.value="6251";
						formObj.vndr_seq.value=formObj.cust_seq.value;
			        } else {
			        	formObj.vndr_seq.value=formObj.cust_seq.value;
			        }
					if(formObj.cust_seq.value == "") {
						formObj.vndr_seq.value="";
						formObj.vndr_lgl_eng_nm.value="";
						formObj.ownr_nm.value="";
		            	//ComAlertFocus(formObj.cust_seq, ComGetMsg('FMS01054'));
			    		return;
		        	}
		        	formObj.f_cmd.value=SEARCH03;
		        	var sXml=sheetObj.GetSearchData("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			var ownrNm=ComGetEtcData(sXml, "ownrNm");
		   			var lglEngNm=ComGetEtcData(sXml, "lglEngNm");
					if(typeof ownrNm != "undefined" && ownrNm != "" ) {
						formObj.ownr_nm.value=ownrNm;
					} else {
						formObj.cust_seq.value="";
						formObj.ownr_nm.value="";
						formObj.vndr_lgl_eng_nm.value="";
						ComAlertFocus(formObj.cust_seq, ComGetMsg('FMS01055'));
						return;
					}
					if(typeof lglEngNm != "undefined" && lglEngNm != "") {
						formObj.vndr_lgl_eng_nm.value=lglEngNm;
					}
					sheetObj.SetWaitImageVisible(1);
				} else if(gubun == "Vessel") {
					sheetObj.SetWaitImageVisible(0);
			    	if(formObj.vsl_cd.value == "") {
			    		formObj.vsl_eng_nm.value="";
			    		return;
			    	}
			    	formObj.f_cmd.value=SEARCH01;
			    	var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
		   				formObj.vsl_cd.readOnly=true;
		   				formObj.btn_vslpop.style.cursor="default";
		   				//document.images["btn_vslpop"].name="no_btn_vslpop";
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
						return;
					}
		   			sheetObj.SetWaitImageVisible(1);
				} else if(gubun == "Flag") {
					sheetObj.SetWaitImageVisible(0);
					if(row == "0") {
						if(formObj.cust_cnt_cd.value == "") {
							formObj.cust_seq.value="";
							formObj.vndr_lgl_eng_nm.value="";
							formObj.ownr_nm.value="";
							return;
						}
						formObj.cnt_cd.value=formObj.cust_cnt_cd.value;
					} else {
						if(formObj.vsl_cnt_cd.value == "") {
							formObj.cnt_nm.value="";
							return;
						}
						formObj.cnt_cd.value=formObj.vsl_cnt_cd.value;
					}
					formObj.f_cmd.value=SEARCH02;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslCntNm=ComGetEtcData(sXml, "vslCntNm");
		   			if(row == "0") {
		   				if(typeof vslCntNm == "undefined" || vslCntNm == "" ) {
		   					formObj.cust_cnt_cd.value="";
		   					formObj.cust_seq.readOnly=true;
							ComAlertFocus(formObj.cust_cnt_cd, ComGetMsg('FMS01057'));
							return;
		   				} else {
		   					formObj.cust_seq.readOnly=false;
		   					ComSetFocus(formObj.cust_seq);
		   				}
		   			} else {
			   			if(typeof vslCntNm != "undefined" && vslCntNm != "" ) {
			   				formObj.cnt_nm.value=vslCntNm;
						} else {
							formObj.vsl_cnt_cd.value="";
							formObj.cnt_nm.value="";
							ComAlertFocus(formObj.vsl_cnt_cd, ComGetMsg('FMS01057'));
							return;
						}
		   			}
		   			sheetObj.SetWaitImageVisible(1);
				} else if(gubun == "Bod" || gubun == "Bor") {
					if(gubun == "Bod") {
						if(formObj.bod_port_cd.value == "") return;
						formObj.curr_port_cd.value=formObj.bod_port_cd.value;
					} else {
						if(formObj.bor_port_cd.value == "") return;
						formObj.curr_port_cd.value=formObj.bor_port_cd.value;
					}
					formObj.f_cmd.value=SEARCH03;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		   			var locCd=ComGetEtcData(sXml, "locCd");
		   			if(typeof locCd == "undefined" || locCd == "") {
		   				if(gubun == "Bod") {
			   				formObj.bod_port_cd.value="";
			   				ComAlertFocus(formObj.bod_port_cd, ComGetMsg('FMS01233'));
		   				} else {
		   					formObj.bor_port_cd.value="";
			   				ComAlertFocus(formObj.bor_port_cd, ComGetMsg('FMS01233'));
		   				}
	    			}
				} else {
					sheetObj.SetWaitImageVisible(0);
					formObj.f_cmd.value=SEARCH01;
					if(gubun == "OaRsvCurrCd") {
						if(formObj.oa_rsv_curr_cd.value == "") return;
						formObj.curr_cd.value=formObj.oa_rsv_curr_cd.value;
					}
					var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do" , FormQueryString(formObj));
		   			var currCd=ComGetEtcData(sXml, "currCd");
		   			if(typeof currCd == "undefined" || currCd == "") {
		   				if(gubun == "OaRsvCurrCd") {
		   					formObj.oa_rsv_curr_cd.value="";
		   					ComAlertFocus(formObj.oa_rsv_curr_cd, ComGetMsg('FMS01058'));
		   				} else {
		   					ComShowMessage(ComGetMsg('FMS01058'));
			   				if(gubun == "hirCurrN1stCd") {
			   					var prefix="hir_";
			   					var hirCurrN1stCdCol=sheetObj.SaveNameCol(prefix + "hir_curr_n1st_cd");
			   					sheetObj.SetCellValue(row,hirCurrN1stCdCol,"",0);
			   					sheetObj.SelectCell(row,hirCurrN1stCdCol);
			   				} else if(gubun == "hirCurrN2ndCd") {
			   					var prefix="hir_";
			   					var hirCurrN2ndCdCol=sheetObj.SaveNameCol(prefix + "hir_curr_n2nd_cd");
			   					sheetObj.SetCellValue(row,hirCurrN2ndCdCol,"",0);
			   					sheetObj.SelectCell(row,hirCurrN2ndCdCol);
			   				} else {
			   					var prefix="otr_";
			   					var currCdCol=sheetObj.SaveNameCol(prefix + "curr_cd");
			   					sheetObj.SetCellValue(row,currCdCol,"",0);
			   					sheetObj.SelectCell(row,currCdCol);
			   				}
		   				}
	    			} else {
	    				if(gubun == "OaRsvCurrCd") {
	    					/*
	    					if(ComFmsCheckCurrencyYn(formObj.oa_rsv_curr_cd.value)) {
	    						form.oa_rsv_amt.dataformat="int";
	    					} else {
	    						form.oa_rsv_amt.dataformat="float";
	    					}
	    					*/
	    				} else {
		    				if(gubun == "hirCurrN1stCd") {
			   					var prefix="hir_";
			   					var currCd=sheetObj.GetCellValue(row, prefix + "hir_curr_n1st_cd");
			   					//parameter changed[check again]CLT InitCellProperty(sheetObj, row,{ Type:"6",Align:"hir_rt_n1st_amt",Format:"2"} );
			   				} else if(gubun == "hirCurrN2ndCd") {
			   					var prefix="hir_";
			   					var currCd=sheetObj.GetCellValue(row, prefix + "hir_curr_n2nd_cd");
		   						//parameter changed[check again]CLT InitCellProperty(sheetObj, row,{ Type:"8",Align:"hir_rt_n2nd_amt",Format:"2"} );
			   				} else {
			   					var prefix="otr_";
			   					var currCd=sheetObj.GetCellValue(row, prefix + "curr_cd");
		   						//parameter changed[check again]CLT InitCellProperty(sheetObj, row,{ Type:"8",Align:"otr_expn_amt",Format:"2"} );
			   				}
	    				}
	    			}
		   			sheetObj.SetWaitImageVisible(1);
				}
	   			break;
        }
    }
    /**
     * Registering IBTab Object to Array
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Basic Tab Setting
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Hire" , "");
					InsertItem( "Other Exp" , "");
					InsertItem( "Payment Term" , "");
					InsertItem( "Redelivery" , "");
					InsertItem( "CP File up" , "");
					InsertItem( "Certi File up" , "");
					InsertItem( "Original Vessel Code" , "");
                }
                sheetObjects[4].DataInsert();
             break;
         }
    }
    /**
     *  Event when click Tab
     * Activiating elements of selected tab
     */
    function tab1_OnChange(tabObj , nItem) {
//        var objs=document.all.item("tabLayer");
//    	objs[nItem].style.display="Inline";
//    	objs[beforetab].style.display="none";
//    	//--------------- Important --------------------------//
//    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
//    	//------------------------------------------------------//
//    	beforetab=nItem;
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	for(var i = 0; i<objs.length; i++){
    		if(i != nItem){
    			objs[i].style.display="none";
    			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    		}
    	}
    	beforetab=nItem;
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL )
     **/
    function validateForm(sheetObj,formObj,sAction) {
        if(comboObjects[1].GetSelectCode()!= "PSE") {
            if (!ComChkValid(formObj)) return false;
	        if(comboObjects[0].GetSelectCode()== "TO") {
	            if(formObj.cust_cnt_cd.value == "") {
	            	ComAlertFocus(formObj.cust_cnt_cd, ComGetMsg('FMS01053'));
		    		return;
	            }
	        } else {
	        	formObj.vndr_seq.value=formObj.cust_seq.value;
	        }
        } else {
        	if(formObj.vsl_cd.value == "") {
        		ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01138'));
	    		return;
        	} 
        	/*
        	else if(formObj.vsl_cnt_cd.value == "") {
        		ComAlertFocus(formObj.vsl_cnt_cd, ComGetMsg('FMS01089'));
	    		return;
        	}
        	*/
        }
        if(   formObj.ori_eff_dt.value != "" 
           && formObj.from_time.value != "") {
        	formObj.eff_dt.value=formObj.ori_eff_dt.value.trimAll("-") + formObj.from_time.value.trimAll(":");
        }
        if(   formObj.ori_exp_dt.value != "" 
            && formObj.to_time.value != "") {
         	formObj.exp_dt.value=formObj.ori_exp_dt.value.trimAll("-") + formObj.to_time.value.trimAll(":");
        }  
        if(formObj.oa_rsv_curr_cd.value != "") {
        	if(formObj.oa_rsv_amt.value == "") {
        		ComAlertFocus(formObj.oa_rsv_amt, ComGetMsg('FMS01083'));
        		return;
        	} else {
        		if(parseInt(formObj.oa_rsv_amt.value) < 1) {
        			ComAlertFocus(formObj.oa_rsv_amt, ComGetMsg('FMS01163'));
        			return;
        		}
        	}
        } else if(formObj.oa_rsv_amt.value != "") {
        	if(formObj.oa_rsv_curr_cd.value == "") {
        		ComAlertFocus(formObj.oa_rsv_curr_cd, ComGetMsg('FMS01084'));
        		return;
        	} 
        }
    	//Time Check
    	if (formObj.eff_dt.value > formObj.exp_dt.value) {
    		ComAlertFocus(formObj.exp_dt, ComGetMsg('FMS01059'));
    		return;
    	}
    	//Checking Amounts(Address Comm./Outlay Comm./Brokerage)
    	if(formObj.acmm_rt_amt.value != "") {
    		if(formObj.acmm_rt_amt.value == "0") {
    			formObj.acmm_rt_amt.value="";
    			ComAlertFocus(formObj.acmm_rt_amt, ComGetMsg('FMS00013', 'Address Comm.'));
        		return;
    		}
    	}
    	if(formObj.flet_olay_comm_rt_amt.value != "") {
    		if(formObj.flet_olay_comm_rt_amt.value == "0") {
    			formObj.flet_olay_comm_rt_amt.value="";
    			ComAlertFocus(formObj.flet_olay_comm_rt_amt, ComGetMsg('FMS00013', 'Outlay Comm.'));
        		return;
    		}
    	}
    	if(formObj.flet_brog_rt_amt.value != "") {
    		if(formObj.flet_brog_rt_amt.value == "0") {
    			formObj.flet_brog_rt_amt.value="";
    			ComAlertFocus(formObj.flet_brog_rt_amt, ComGetMsg('FMS00013', 'Brokerage'));
        		return;
    		}
    	}
    	//Checking Effectiveness FromDate and ToDate between Hire Tab and PayTerm Tab (period)
    	var sheetObj1=sheetObjects[1];
    	var sheetObj2=sheetObjects[2];
    	var sheetObj3=sheetObjects[3];
    	var firstRow1=getFirstRow(sheetObj1);
    	var firstRow3=getFirstRow(sheetObj3);
    	var lastRow1=getLastRow(sheetObj1);
    	var lastRow3=getLastRow(sheetObj3);
    	//Row Count of Hire Tab
    	var RowCount1=0;
    	//Row Count of Other Exp Tab
    	var RowCount2=0;
    	//Row Count of Payment Term Tab
    	var RowCount3=0;
    	//Row Count of Hire Tab
    	for(var ir=1; ir<=sheetObj1.LastRow(); ir++) {
			if(sheetObj1.GetRowHidden(ir)==false) {
				RowCount1=1;
				break;
			}
		}
    	//Row Count of Other Exp Tab
    	for(var ir=1; ir<=sheetObj2.LastRow(); ir++) {
			if(sheetObj2.GetRowHidden(ir)==false) {
				RowCount2=1;
				break;
			}
		}
    	//Row Count of Payment Term Tab
    	for(var ir=1; ir<=sheetObj3.LastRow(); ir++) {
			if(sheetObj3.GetRowHidden(ir)==false) {
				RowCount3=1;
				break;
			}
		}
    	//if(sheetObj3.RowCount >0 && rowCount3 == 1) {
    	if(RowCount3 > 0) {
	    	//Checking period between Hire Tab and Payment Term Tab
    		if(RowCount1 >0 && sheetObj1.GetCellValue(firstRow1, "hir_eff_dt")!="" && sheetObj1.GetCellValue(lastRow1, "hir_exp_dt")!=""){
    			if (sheetObj3.GetCellValue(firstRow3, "pay_eff_dt") > sheetObj1.GetCellValue(firstRow1, "hir_eff_dt")) {
	    			ComShowMessage(ComGetMsg('FMS01060'));
	    			tabObjects[0].SetSelectedIndex(2);
	    			sheetObj3.SelectCell(firstRow3, "pay_eff_dt");
	    			return;
    			} else if (sheetObj3.GetCellValue(lastRow3, "pay_exp_dt") < sheetObj1.GetCellValue(lastRow1, "hir_exp_dt")) {
	    			ComShowMessage(ComGetMsg('FMS01061'));
	    			tabObjects[0].SetSelectedIndex(2);
	    			sheetObj3.SelectCell(lastRow3, "pay_exp_dt");
	    			return;
	    		}
	    	}
	    	//Checking Effectiveness FromDate and ToDate between OTHER EXP Tab and PayTerm Tab (period) 
	    	if(RowCount2 > 0 && RowCount3 > 0) {
		    	var sheetObj2=sheetObjects[2];
		    	var firstRow2=getFirstRow(sheetObj2);
		    	var lastRow2=getLastRow(sheetObj2);
		    	var leastValue2=getLeastValue(sheetObj2);
		    	var greatestValue2=getGreatestValue(sheetObj2);
		    	//Checking period between OTHER EXP Tab and Payment Term Tab
		    	if(RowCount2 >0 && sheetObj2.GetCellValue(firstRow2, "otr_eff_dt")!="" && sheetObj2.GetCellValue(lastRow2, "otr_exp_dt")!=""){
		    		if (sheetObj3.GetCellValue(firstRow3, "pay_eff_dt").substr(0,8) > leastValue2) {
		    			//ComShowMessage("Payment Term탭의 FromDate는 Other Exp탭  첫행의 FromDate보다 작거나 같아야 한다.");
		    			ComShowMessage(ComGetMsg('FMS01062'));
		    			tabObjects[0].SetSelectedIndex(2);
		    			sheetObj3.SelectCell(firstRow3, "pay_eff_dt");
		    			return;
		    		} else if (sheetObj3.GetCellValue(lastRow3, "pay_exp_dt").substr(0,8) < greatestValue2) {
		    			//ComShowMessage("Payment Term탭의 ToDate는  Other Exp탭  마지막행의 ToDate보다 크거나 같아야 한다.");
		    			ComShowMessage(ComGetMsg('FMS01063'));
		    			tabObjects[0].SetSelectedIndex(2);
		    			sheetObj3.SelectCell(lastRow3, "pay_exp_dt");
		    			return;
		    		}
		    	}
	    	}
	    	//Checking date by Payment Term of Payment
	    	for(var ir=1,idx=0; ir<=sheetObj3.LastRow(); ir++) {
				var ctrtPayTermCd=sheetObj3.GetCellValue(ir, "pay_ctrt_pay_term_cd");
				var effDt=sheetObj3.GetCellValue(ir, "pay_eff_dt");
				var expDt=sheetObj3.GetCellValue(ir, "pay_exp_dt");
	    		if(ctrtPayTermCd == "A") {
	    			if((effDt.substring(6,8) != "01" && effDt.substring(6,8) != "16") || effDt.substring(8,12) != "0000") {
	    				ComShowMessage(ComGetMsg('FMS01086'));
	    				sheetObj3.SelectCell(ir, "pay_eff_dt");
	    				return false;
    					break;
	    			} else if((expDt.substring(6,8) != "01" && expDt.substring(6,8) != "16") || expDt.substring(8,12) != "0000") {
	    				ComShowMessage(ComGetMsg('FMS01087'));
	    				sheetObj3.SelectCell(ir, "pay_exp_dt");
	    				return false;
    					break;
	    			}
	    		} else if(ctrtPayTermCd == "C") {
	    			if(effDt.substring(6,12) != expDt.substring(6,12)) {
	    				ComShowMessage(ComGetMsg('FMS01088'));
	    				sheetObj3.SelectCell(ir, "pay_exp_dt");
	    				return false;
    					break;
	    			} else if(parseInt(effDt.substring(6,8)) > 28) {
	    				ComShowMessage(ComGetMsg('FMS01096'));
	    				sheetObj3.SelectCell(ir, "pay_eff_dt");
	    				return false;
    					break;
	    			}
	    		}
	    	}
    	}
    	/*
    	var RowCount()1=0;
    	for(var ir=1; ir<=sheetObj1.LastRow(); ir++) {
			if(sheetObj1.GetRowHidden(ir)==false) {
				RowCount()1=1;
				break;
			}
		}
		*/
    	//Checking CURR2 of HIRE Tab
        if(RowCount1 >0) {
    		var prefix="hir_";
    		for(var ir=1,idx=0; ir<=sheetObj1.LastRow(); ir++) {
    			if(sheetObj1.GetCellValue(ir,prefix + "hir_curr_n2nd_cd") != "" || sheetObj1.GetCellValue(ir,prefix + "hir_rt_n2nd_amt") != "") {
    				if(sheetObj1.GetCellValue(ir,prefix + "hir_curr_n2nd_cd") != "") {
    					if(sheetObj1.GetCellValue(ir,prefix + "hir_rt_n2nd_amt") == "" || sheetObj1.GetCellValue(ir,prefix + "hir_rt_n2nd_amt") < 1) {
	    					ComShowMessage(ComGetMsg('FMS01163'));
	    					sheetObj1.SelectCell(ir, prefix + "hir_rt_n2nd_amt");
	    					return false;
	    					break;
	    				}
    				} else if(sheetObj1.GetCellValue(ir,prefix + "hir_rt_n2nd_amt") != "" && sheetObj1.GetCellValue(ir,prefix + "hir_rt_n2nd_amt") > 0) {
    					if(sheetObj1.GetCellValue(ir,prefix + "hir_curr_n2nd_cd") == "") {
	    					ComShowMessage(ComGetMsg('FMS01077'));
	    					sheetObj1.SelectCell(ir, prefix + "hir_curr_n2nd_cd");
	    					return false;
	    					break;
	    				}
    				} else if(sheetObj1.GetCellValue(ir,prefix + "hir_curr_n2nd_cd") == "" && sheetObj1.GetCellValue(ir,prefix + "hir_rt_n2nd_amt") == 0) {
	    				ComShowMessage(ComGetMsg('FMS01163'));
						sheetObj1.SelectCell(ir, prefix + "hir_rt_n2nd_amt");
						return false;
						break;
	    			}
    			}
    		}
    	}
        return true;
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="-";
        //Axon Event Handling1. Event Catch
        axon_event.addListener  ('click', 'declaration_click', 'decl_flg');    			//Whether Check declaration
        //axon_event.addListener  ('keypress', 'eng_keypress', 'cust_cnt_cd', 'vsl_cnt_cd', 'oa_rsv_curr_cd', 'bod_port_cd', 'bor_port_cd');
       // axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); //- Input only Upper case English or Numeric when inserting Veesel Code
        axon_event.addListener  ('change', 'cust_seq_change', 'cust_seq');				//Getting Name information after inserting Owner Code
        axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');					//Getting Name information after inserting Vessel Code
        axon_event.addListener  ('change', 'cust_cnt_cd_change', 'cust_cnt_cd');		//Getting Name information after inserting Owner Code(Flag Code)
        axon_event.addListener  ('change', 'vsl_cnt_cd_change', 'vsl_cnt_cd');			//Getting Name information after inserting Flag Code
        axon_event.addListener  ('change', 'bod_port_cd_change', 'bod_port_cd');		//Checking Code after inserting Del/Redel
        axon_event.addListener  ('change', 'bor_port_cd_change', 'bor_port_cd');		//Checking Code after inserting Del/Redel
        axon_event.addListener  ('change', 'oa_rsv_curr_cd_change', 'oa_rsv_curr_cd');	//Checking Currency after inserting Reservation of O/A
        axon_event.addListener  ('change', 'flet_ctrt_no_change', 'flet_ctrt_no');		//Checking Currency after inserting Reservation of O/A
        //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
        //axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form Code Handling to OnBeforeDeactivate Event of All Controls having dataformat attribute
        //axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form Code Handling to onkeypress Event of All Controls having dataformat attribute
        //doActionIBSheet(sheetObjects[3], document.form, IBROWSEARCH, "ComCd");
    }
    //Axon Event Handling2. Event Handling Function --- start

    /**
     * Getting Name relevant to the CustSeq when CustSeq is changed <br>
     **/
    function cust_seq_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Owner');
    }
    /**
     * Getting Name relevant to the VslCd when VslCd is changed <br>
     **/
    function vsl_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
    }
    /**
     * Checking whether information relevant to code when CustCntCd is changed <br>
     **/
    function cust_cnt_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Flag','0');
    }
    /**
     * Getting Name relevant to the VslCntCd when VslCntCd is changed <br>
     **/
    function vsl_cnt_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Flag');
    }
    /**
     * Getting Code relevant to the Del / Redel when Del / Redel is changed <br>
     **/
    function bod_port_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Bod');
    }
    /**
     * Getting Code relevant to the Del / Redel when Del / Redel is changed <br>
     **/
    function bor_port_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Bor');
    }
    /**
     * Checking Code value when inserting Currency Code <br>
     **/
    function oa_rsv_curr_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'OaRsvCurrCd');
    }
    /**
     * Deactivating Button when insert Contract No <br>
     **/
    function flet_ctrt_no_change() {
    	document.all.btn_creation.style.display="none";
    	document.all.btn_creation2.style.display="none";
    }
    //Axon Event Handling2. Event Handling Function --- end
    /**
     * Setting value when CheckBox is selected <br>
     **/
    function declaration_click() {
    	if(form.decl_flg.checked) {
    		form.decl_flg.value='Y';
    	} else {
    		form.decl_flg.value='N';
    	}
    }
    /**
     * Setting value when Owner Code is changed <br>
     **/
	function setOwnerCode(val) {
		if(val == "TO") {
			form.cust_cnt_cd.readOnly=false;
		} else {
			form.cust_cnt_cd.readOnly=true;
			form.cust_cnt_cd.value="";
		}
		form.cust_seq.value="";
		form.vndr_lgl_eng_nm.value="";
		form.ownr_nm.value="";
	}
	/**
     * Event is Occured when selected Item is changed<br>
     * When selected Item is selected again, Event doesn't happen 
     * @param {ibsheet} idx_cd    	Index_Code
     * @param {ibsheet} text     	Text
     **/
	function flet_ctrt_tp_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
		if(NewTxt == "TO") {
			form.cust_cnt_cd.readOnly=false;
			form.cust_seq.readOnly=true;
			form.owner_code.style.cursor="hand";
			//document.images["owner_code"].name="owner_code";
			form.flet_olay_comm_rt_amt.value="";
		} else if(NewTxt == "OW") {
			form.cust_cnt_cd.readOnly=true;
			form.cust_seq.readOnly=true;
			form.cust_cnt_cd.value="";
			form.owner_code.style.cursor="default";
			//document.images["owner_code"].name="no_owner_code";
			form.flet_olay_comm_rt_amt.value="";
			doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Owner');
			return;
		} else {
			form.cust_cnt_cd.readOnly=true;
			form.cust_seq.readOnly=false;
			form.cust_cnt_cd.value="";
			form.owner_code.style.cursor="hand";
			//document.images["owner_code"].name="owner_code";
			//form.flet_olay_comm_rt_amt.value="2.5";
		}
		form.cust_seq.value="";
		form.vndr_lgl_eng_nm.value="";
		form.ownr_nm.value="";
	}
	/**
     * Event is Occured when selected Item is changed<br>
     * When selected Item is selected again, Event doesn't happen 
     * @param {ibsheet} idx_cd    	Index_Code
     * @param {ibsheet} text     	Text
     **/
	function flet_ctrt_fact_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
		if(NewCod == "ACT") {
			form.cust_cnt_cd.className="input1";
	    	form.cust_seq.className="input1";
			form.decl_flg.disabled=false;
		} else {
			form.cust_cnt_cd.className="input";
	    	form.cust_seq.className="input";
			form.decl_flg.checked=false;
			form.decl_flg.disabled=true;
			form.decl_flg.value='N';
		}
	}
    /**
	 * Inserting Del/Re Port<br>
	 * @param {arry} aryPopupData
	 */
	function setBodPortCd(aryPopupData){
		form.bod_port_cd.value=aryPopupData[0][3];
	}
	/**
	 * Inserting Del/Re Port<br>
	 * @param {arry} aryPopupData
	 */
	function setBorPortCd(aryPopupData){
		form.bor_port_cd.value=aryPopupData[0][3];
	}
	/**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t1sheet1_OnChange(sheetObj,row,col,value) {
		/*dateTimeOnChange(sheetObj,row,col,value,"hir_");
		currencyOnChange(sheetObj,row,col,value,"hir_");
		currency2OnChange(sheetObj,row,col,value,"hir_");*/
	}
	
	function t1sheet1_OnAfterEdit(sheetObj,row, col) {
		var value = sheetObj.GetCellValue(row, col);
		dateTimeOnChange(sheetObj,row,col,value,"hir_");
		currencyOnChange(sheetObj,row,col,value,"hir_");
		currency2OnChange(sheetObj,row,col,value,"hir_");
	}
	
	/**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t2sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"otr_");
		currencyOnChange(sheetObj,row,col,value,"otr_");
	}
	/**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t3sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"pay_");
	}
    /**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t5sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"cpf_");
	}
	/**
     * Event occurred when value of cell is changed <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t6sheet1_OnChange(sheetObj,row,col,value) {
		dateTimeOnChange(sheetObj,row,col,value,"cef_");
	}
	/**
     * Checking Duplication of VslCd <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t7sheet1_OnChange(sheetObj,row,col,value) {
		var prefix="vsl_";
        var colAlias=sheetObj.ColSaveName(col);
        //In case Vessel Code is changed OR delete check
        if (colAlias==(prefix + "vsl_cd")) {
            var vslCdCol=sheetObj.SaveNameCol(prefix + "vsl_cd");
            var oriVslCdCol=sheetObj.SaveNameCol(prefix + "ori_vsl_cd");
            //var vslEngNmCol = sheetObj.SaveNameCol(prefix + "vsl_eng_nm");
            //Checking Duplication of Vessel Code 
            for(var ir=1,idx=0; ir<=sheetObj.LastRow(); ir++) {
            	var vslCdValue=sheetObj.GetCellText(ir,vslCdCol);
                if (ir == row) {
                    if (sheetObj.FindText(vslCdCol, vslCdValue) != ir || sheetObj.FindText(vslCdCol, vslCdValue, ir+1) > ir) {
                    	ComShowMessage(ComGetMsg('FMS01064', vslCdValue));
                    	if(sheetObj.GetRowStatus(row) == "I") {
                        	sheetObj.SetCellValue(row,vslCdCol,"",0);
	                        sheetObj.SetCellValue(row,prefix + "vsl_eng_nm","",0);
                        } else {
                        	sheetObj.SetCellValue(row,vslCdCol,sheetObj.GetCellValue(row,oriVslCdCol),0);
                        	sheetObj.SetCellValue(row,prefix + "vsl_eng_nm",sheetObj.GetCellValue(row,prefix + "ori_vsl_eng_nm"),0);
                        }
                        //sheetObj.CellValue2(row,vslEngNmCol) = "";
                        sheetObj.SelectCell(row,vslCdCol);
                        //sheetObj.SelectCell(row,vslCdCol,false);
                        return;
                    }
                }
            }
        }
	}
	/**
     * Handling Date Effectiveness Verification Process about input Value of IBSheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     * @param {String}  prefix   	Variable Separator
     * @see #sheet_chekPeriod
     **/
	function dateTimeOnChange(sheetObj,row,col,value,prefix) {
		if (sheetObj.GetCellProperty(row,col,"Format")!= dftDateYmd && sheetObj.GetCellProperty(row,col,"Format") != dftUserFormatYmdhhmi) return;

		if (value=="") return;
		
		var sText=sheetObj.GetCellText(row,col);
		if(prefix == "otr_" || prefix == "cpf_" || prefix == "cef_") {
			if (!ComIsDate(sText)) {
				ComShowMessage(ComGetMsg('FMS01065', sheetObj.GetCellText(0,col)));
				//ComShowMessage(sheetObj.CellText(0,col) + " is not valid date-time. Please enter a correct date-time. \n\n Format : YYYY-MM-DD");
				sheetObj.SelectCell(row,col,true);
				return;
			}
		} else {//ymdhms ComIsDateTime2
			if (!ComIsDateTime2(sText, "ymdhm")) {
			//if (!ComIsDateTime(sText, "", "hm")) {
				ComShowMessage(ComGetMsg('FMS01066', sheetObj.GetCellText(0,col)));
				//ComShowMessage(sheetObj.CellText(0,col) + " is not valid date-time. Please enter a correct date-time. \n\n Format : YYYY-MM-DD HH:MM");
				sheetObj.SelectCell(row,col,true);
				return;
			}
		}
		// Period Check
		if (sheetObj.GetCellText(row,prefix + "eff_dt")!="" && sheetObj.GetCellText(row,prefix + "exp_dt")!=""){
			if(!sheet_chekPeriod(sheetObj,row,col,prefix)){		
				if(sheetObj.ColSaveName(col)==prefix + "eff_dt") {
					sText=sheetObj.GetCellText(row,col+1);
					sheetObj.SelectCell(row,col+1,true);
				} else {
					//sheetObj.SelectCell(row,col,true,sText);
					//sheetObj.SetCellValue(row,col,"", 0);
					sheetObj.SelectCell(row,col,true);
				}
				return;
			}
		}else{
			return;
		}
		//Setting ToDate of current Row to FromDate of next Row
		if(row < sheetObj.LastRow()){
			if(prefix == "otr_") {
				setNextOtrEffDt(sheetObj, row, prefix);
			} else {
				sheetObj.SetCellValue(row+1,prefix + "eff_dt",sheetObj.GetCellValue(row,prefix + "exp_dt"));
			}
		}
		//Setting Original Value of FromDate and ToDate of the Row in "Insert" state
		if (sheetObj.GetRowStatus(row)=="I"){
			sheetObj.SetCellValue(row,prefix + "ori_exp_dt",sheetObj.GetCellValue(row,prefix + "exp_dt"));
			sheetObj.SetCellValue(row,prefix + "ori_eff_dt",sheetObj.GetCellValue(row,prefix + "eff_dt"));
		}
	}
	/**
     * Setting Current Input Value of IBSheet(ToDate) to FromDate of next Row automatically <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {String}  prefix   	Variable Separator
     **/
	function setNextOtrEffDt(sheetObj, row, prefix) {
		var currAcctItmNm;
		var currExpDt;
		if (sheetObj.RowCount()> 1) {
			currAcctItmNm=sheetObj.GetCellValue(row,prefix + "acct_itm_nm");
			currExpDt=sheetObj.GetCellValue(row,prefix + "exp_dt");
			//for(var ir=row+1; ir<=sheetObj.LastRow(); ir++) {
			for(var ir=row+1; ir <= sheetObj.LastRow(); ir++) {
				if(sheetObj.GetRowHidden(ir)==false) {
					if(currAcctItmNm == sheetObj.GetCellValue(ir,prefix + "acct_itm_nm")) {
						var nextEffDt=ComGetDateAdd(sheetObj.GetCellValue(row,prefix + "exp_dt"), "D", 1, "");
						sheetObj.SetCellValue(ir,prefix + "eff_dt",nextEffDt);
						break;
					}
				}
			}
		}
	}
	/**
     * Event called to check Validation just before Saving by Saving Function <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t1sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix="hir_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail(1);
		} else if((sheetObj.ColSaveName(col)==prefix + "hir_rt_n1st_amt") && sheetObj.GetCellValue(row,prefix + "hir_rt_n1st_amt") < 1) {
			ComShowMessage(ComGetMsg('FMS01163'));
			sheetObj.ValidateFail(1);
		}
	}
	function t1sheet1_OnEditValidation(sheetObj,Row, Col, Value) { 
		var prefix="hir_";
		switch (sheetObj.ColSaveName(Col)) {
			case prefix + "hir_rt_n1st_amt":
			case prefix + "hir_rt_n2nd_amt":				
				if(!f_SetCipherLess(Value, 11, 2)){
					sheetObj.ValidateFail(2); 
				}
				break;
		}
	}	
	
	function f_SetCipherLess(val, integerPlace, decimalPlace){
		val = val+"";
		if(val.indexOf(".")<0) val=val+".";
		
		var arrVal=val.split(".");
		if(arrVal.length == 1){
			if(arrVal[0].length > integerPlace){
				ComShowCodeMessage("FMS20013", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
				return false;
			}
		} else if(arrVal.length == 2){
			if(arrVal[0].length > integerPlace){
				ComShowCodeMessage("FMS20013", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
				return false;
			}
			if(arrVal[1].length > decimalPlace){
				ComShowCodeMessage("FMS20013", "[The Part Of The Decimal]", "[Less Than or Equal To " + decimalPlace + "-Digit]");
				return false;
			}
		}	
		return true;
	}
	
	/**
     * Event called to check Validation just before Saving by Saving Function <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t2sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix="otr_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail(1);
		} else if((sheetObj.ColSaveName(col)==prefix + "otr_expn_amt") && sheetObj.GetCellValue(row,prefix + "otr_expn_amt") < 1) {
			ComShowMessage(ComGetMsg('FMS01163'));
			sheetObj.ValidateFail(1);
		}
	}
	function t2sheet1_OnEditValidation(sheetObj,Row, Col, Value) { 
		var prefix="otr_";
		switch (sheetObj.ColSaveName(Col)) {
			case prefix + "otr_expn_amt":
				if(!f_SetCipherLess(Value, 11, 2)){
					sheetObj.ValidateFail(2); 
				}
				break;
		}
	}
	/**
     * Event called to check Validation just before Saving by Saving Function <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
	function t3sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix="pay_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail(1);
		}
	}
    /**
     * Event called to check Validation just before Saving by Saving Function <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
    /*
	function t5sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix="cpf_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail(true);
		}
	}
	*/
	/**
     * Event called to check Validation just before Saving by Saving Function <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  value    	Inserted value of sheetObj
     **/
    /*
	function t6sheet1_OnValidation(sheetObj,row,col,value) {
		var prefix="cef_";
		if ((sheetObj.ColSaveName(col)==prefix + "exp_dt") && !sheet_chekPeriod(sheetObj,row,col,prefix)){
			sheetObj.ValidateFail(true);
		}
	}
	*/
	/**
     * Comparing Input Value(ToDate ~ FromDate) of current Grid Row of IBSheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String}  prefix   	Variable Separator
     * @return {boolean} bool
     **/
	function sheet_chekPeriod(sheetObj,row,col,prefix){
		//var prefix = "hir_";
		var fromDate=sheetObj.GetCellValue(row,prefix + "eff_dt");
		var toDate=sheetObj.GetCellValue(row,prefix + "exp_dt");
		if (fromDate=="" && toDate=="") return;
		if (fromDate > toDate){
			ComShowMessage(ComGetMsg('FMS01067'));
			//ComShowMessage("'To Date' must be greater than or equal to 'From Date'.");
			//sheetObj.SelectCell(row,col);
			return false;
		}
		return true;
	}
	/**
     * Adding Row for each Tab of IBSheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	Variable Separator
     * @param {String} 	flag   		Row Add/Row Ins's Separator
     * @return none
     **/
	function sheet_DataInsert(sheetObj,prefix,flag){
		//var prefix = "hir_";
		var row=sheetObj.GetSelectRow();
		var col=sheetObj.GetSelectCol();
		if (sheetObj.RowCount()> 0){
			if(prefix == "vsl_") {
				if (sheetObj.GetCellValue(row,prefix + "vsl_cd")==""){
					ComShowMessage(ComGetMsg('FMS01068'));
					//ComShowMessage("Please must enter 'Vessel Code'");
					sheetObj.SelectCell(row,prefix + "vsl_cd");
					return;
				}
			} else if(prefix == "cpf_" || prefix == "cef_") {
				if (sheetObj.GetCellValue(row,prefix + "file_nm")==""){
					if(prefix == "cpf_") {
						ComShowMessage(ComGetMsg('FMS01069'));
					} else {
						ComShowMessage(ComGetMsg('FMS01070'));
					}
					sheetObj.SelectCell(row,prefix + "file_nm");
					return;
				}
			} else {
				if (sheetObj.GetCellValue(row,prefix + "eff_dt")==""){
					ComShowMessage(ComGetMsg('FMS01071'));
					//ComShowMessage("Please must enter 'From Date'");
					sheetObj.SelectCell(row,prefix + "eff_dt");
					return;
				}else if (sheetObj.GetCellValue(row,prefix + "exp_dt")==""){
					ComShowMessage(ComGetMsg('FMS01072'));
					//ComShowMessage("Please must enter 'To Date'");
					sheetObj.SelectCell(row,prefix + "exp_dt");
					return;
				}else if (!sheet_chekPeriod(sheetObj,row,col,prefix)){
					return;
				}

				//UI 개선(201408 민정호)
//				if(prefix == "cpf_"){
					//Checking Other Exp Tab(Account Code)
					if (sheetObj.GetCellValue(row,prefix + "acct_cd")==""){
						ComShowMessage(ComGetMsg('FMS01073'));
						//ComShowMessage("Please must enter 'Account Code'");
						sheetObj.SelectCell(row,prefix + "acct_cd");
						return;
					}
//				}
			}
		}
		
		//Checking Row Ins Button
		if(typeof flag != "undefined" && flag != "") {
			if(prefix == "cpf_" || prefix == "cef_") {
				row=sheetObj.DataInsert();
			} 
		} else {
			// Add Row
	    	row=sheetObj.DataInsert(-1);
	    	/*
			if(prefix == "cpf_" || prefix == "cef_") {
				sheetObj.SetCellImage(row,prefix + "file_download",0);
			}*/
			if (row<=sheetObj.HeaderRows()) return;
		}				
		if(!(prefix == "otr_" || prefix == "cpf_" || prefix == "cef_")) {
			sheetObj.SetCellValue(row,prefix + "eff_dt",sheetObj.GetCellValue(row-1,prefix + "exp_dt"));			
			sheetObj.SetCellEditable(row,prefix + "eff_dt",0);
		}
	}
	/**
     * Inserting From Date value automatically to each Grid of IBSheet <br>
     * @param {ibsheet} row     Selected Row of sheetObj
     * @param {String} 	prefix  Variable Separator
     * @return {boolean} bool
     **/
	function setOtrEffDt(row, prefix) {
		var sheetObj=sheetObjects[2];
		var currAcctItmNm;
		var exist=false;
		if(sheetObj.RowCount()> 1) {
			currAcctItmNm=sheetObj.GetCellValue(row,prefix + "acct_itm_nm");
			for(var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++) {
				if(sheetObj.GetRowHidden(ir)==false && row != ir) {
					if(currAcctItmNm == sheetObj.GetCellValue(ir,prefix + "acct_itm_nm")) {
						exist=true;
					}
				}
			}
			if(exist) {
				var maxExpDt=getOtrGreatestValue(sheetObj, row, currAcctItmNm);
				maxExpDt=ComGetDateAdd(maxExpDt, "D", 1, "");
				sheetObj.SetCellValue(row,prefix + "eff_dt",maxExpDt);
				sheetObj.SetCellEditable(row,prefix + "eff_dt",0);
			}
		}
	}
	/**
     * Deciding whether insert From Date to each Grid of IBSheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	Variable Separator
     * @return none
     * @see #setFirstOtrEffDtCellEditable
     **/
	function setOtrEffDtGetCellEditable(sheetObj, prefix) {
		if (sheetObj.RowCount()> 1) {
			setFirstOtrEffDtGetCellEditable(sheetObj, prefix);
		}
	}
	/**
     * Initializing Screen <br>
     * @return none
     * @see #ComResetAll
     **/
	function clearAll() {
		ComResetAll();
		tabObjects[0].SetSelectedIndex(0);
		document.all.btn_creation.style.display="";
    	document.all.btn_save.style.display="none";
    	document.all.btn_delete.style.display="none";
    	document.all.btn_creation2.style.display="";
    	document.all.btn_save2.style.display="none";
    	document.all.btn_delete2.style.display="none";
    	comboObjects[0].SetSelectCode("TI");
		comboObjects[1].SetSelectCode("ACT");
		form.cust_seq.readOnly=false;
		form.vsl_cd.readOnly=false;
		form.btn_vslpop.style.cursor="hand";
		//document.images["btn_vslpop"].name="btn_vslpop";
		form.contract_no.style.cursor="hand";
	    //document.images["contract_no"].name="contract_no";
	    flet_ctrt_tp_cd.SetEnable(1);
	    flet_ctrt_fact_cd.SetEnable(1);
	    sheetObjects[1].CheckAll("hir_DelChk",0);
	    sheetObjects[2].CheckAll("otr_DelChk",0);
	    sheetObjects[3].CheckAll("pay_DelChk",0);
	    sheetObjects[5].CheckAll("cpf_DelChk",0);
		sheetObjects[6].CheckAll("cef_DelChk",0);
		//sheetObjects[7].CheckAll("vsl_DelChk") = 0;
		//form.oa_rsv_amt.dataformat = "float";
	}
	/**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix="oli_";
		//control as width ratio
		sheetObj.FitColWidth("32|13|13|8|34");
		//Setting 2 column's Font color to 1 column's Font color
		//no support[check again]CLT 		sheetObj.SetColFontColor(0,sheetObj.WebColor("#532FC3"));
		//parameter changed[check again]CLT InitCellProperty(sheetObj, prefix,{ Type:"curr_cd",Align:"otr_expn_amt"} );
	}
	/**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix="hir_";
		setFromDateEdit(sheetObj, prefix);
		
		//UI개선(201408 민정호)
		for(var i=1; i<=sheetObj.LastRow(); i++) {
			sheetObj.SetCellValue(i,"hir_eff_dt", sheetObj.GetCellValue(i,"hir_eff_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"hir_exp_dt", sheetObj.GetCellValue(i,"hir_exp_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"hir_ori_eff_dt", sheetObj.GetCellValue(i,"hir_ori_eff_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"hir_ori_exp_dt", sheetObj.GetCellValue(i,"hir_ori_exp_dt").substr(0,12),0);			
		}		
		//parameter changed[check again]CLT InitCellProperty(sheetObj, prefix );
		/*
		for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
			if(   sheetObj.GetCellValue(ir, prefix + "hir_curr_n1st_cd") == "KRW"
			|| sheetObj.GetCellValue(ir, prefix + "hir_curr_n1st_cd") == "JPY") {
			//parameter changed[check again]CLT 				sheetObj.InitCellProperty(ir, 6,{ Type:"Null",Align:"Right",Format:"dfNullInteger"} );
			}
			if(   sheetObj.GetCellValue(ir, prefix + "hir_curr_n2nd_cd") == "KRW"
			|| sheetObj.GetCellValue(ir, prefix + "hir_curr_n2nd_cd") == "JPY") {
			//parameter changed[check again]CLT 				sheetObj.InitCellProperty(ir, 8,{ Type:"Null",Align:"Right",Format:"dfNullInteger"} );
			}
		}
		*/
	}
	/**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var prefix="otr_";
		setFromDateEdit(sheetObj, prefix);
		//parameter changed[check again]CLT InitCellProperty(sheetObj, prefix,{ Type:"curr_cd",Align:"otr_expn_amt"} );
	}
	/**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setFromDateEdit(sheetObj,"pay_");
		
		//UI개선(201408 민정호)
		for(var i=1; i<=sheetObj.LastRow(); i++) {
			sheetObj.SetCellValue(i,"pay_eff_dt", sheetObj.GetCellValue(i,"pay_eff_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"pay_exp_dt", sheetObj.GetCellValue(i,"pay_exp_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"pay_ori_eff_dt", sheetObj.GetCellValue(i,"pay_ori_eff_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"pay_ori_exp_dt", sheetObj.GetCellValue(i,"pay_ori_exp_dt").substr(0,12),0);			
		}		
	}
    /**
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
 	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 	}
	/**
     * Event occured after saving by DoSave <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var prefix="hir_";
		setFromDateEdit(sheetObj, prefix);
		setInitCellProperty(sheetObj, prefix);
		
		//UI개선(201408 민정호)
		for(var i=1; i<=sheetObj.LastRow(); i++) {
			sheetObj.SetCellValue(i,"hir_eff_dt", sheetObj.GetCellValue(i,"hir_eff_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"hir_exp_dt", sheetObj.GetCellValue(i,"hir_exp_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"hir_ori_eff_dt", sheetObj.GetCellValue(i,"hir_ori_eff_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"hir_ori_exp_dt", sheetObj.GetCellValue(i,"hir_ori_exp_dt").substr(0,12),0);			
		}			
	}
	/**
     * Event occured after saving by DoSave <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t2sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var prefix="otr_";
		setFromDateEdit(sheetObj, prefix);
		//setOriData(sheetObj,ErrMsg,"otr_");
		//parameter changed[check again]CLT InitCellProperty(sheetObj, prefix,{ Type:"curr_cd",Align:"otr_expn_amt"} );
	}
	/**
     * Event occured after saving by DoSave <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t3sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		setFromDateEdit(sheetObj,"pay_");
		//setOriData(sheetObj,ErrMsg,"pay_");
		
		//UI개선(201408 민정호)
		for(var i=1; i<=sheetObj.LastRow(); i++) {
			sheetObj.SetCellValue(i,"pay_eff_dt", sheetObj.GetCellValue(i,"pay_eff_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"pay_exp_dt", sheetObj.GetCellValue(i,"pay_exp_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"pay_ori_eff_dt", sheetObj.GetCellValue(i,"pay_ori_eff_dt").substr(0,12),0);
			sheetObj.SetCellValue(i,"pay_ori_exp_dt", sheetObj.GetCellValue(i,"pay_ori_exp_dt").substr(0,12),0);			
		}			
	}
	/**
     * Event occured after saving by DoSave <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
	function t7sheet1_OnSaveEnd(sheetObj,ErrMsg) {
		//setOriData(sheetObj,ErrMsg,"vsl_");
	}
	/**
     * Event occurred when Cell value is changed(whether inserting From Date) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	Variable Separator
     * @see #setOtrEffDtCellEditable
     **/
	function setFromDateEdit(sheetObj, prefix) {
		if (sheetObj.SearchRows()<=0) return;
		if(prefix == "otr_") {
			setOtrEffDtGetCellEditable(sheetObj, prefix);
			//sheetObj.CellEditable(sheetObj.HeaderRows,prefix+"eff_dt")=true;
		} else {
			sheetObj.SetCellEditable(sheetObj.HeaderRows(),prefix+"eff_dt",1);
		}
	}
	/**
     * After Saving, Setting Original value in case Status="R" <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     * @param {String} 	prefix    	Variable Separator
     * @see #setOtrEffDtCellEditable
     **/
	function setOriData(sheetObj, ErrMsg, prefix){
		if (ErrMsg!="") return;
		switch(prefix){
			case "hir_":
			case "pay_":
				for (var ir=1; ir<=sheetObj.LastRow(); ir++){
					if (sheetObj.GetRowStatus(ir)!= "R") continue;
					sheetObj.SetCellValue(ir,prefix + "ori_eff_dt",sheetObj.GetCellValue(ir,prefix + "eff_dt"),0);
					sheetObj.SetCellValue(ir,prefix + "ori_exp_dt",sheetObj.GetCellValue(ir,prefix + "exp_dt"),0);
					sheetObj.SetRowStatus(ir,"R");
				}
				break;
			case "otr_":
				for (var ir=1; ir<=sheetObj.LastRow(); ir++){
					if (sheetObj.GetRowStatus(ir)!= "R") continue;
					sheetObj.SetCellValue(ir,prefix + "ori_acct_cd",sheetObj.GetCellValue(ir,prefix + "acct_cd"),0);
					sheetObj.SetCellValue(ir,prefix + "ori_eff_dt",sheetObj.GetCellValue(ir,prefix + "eff_dt"),0);
					sheetObj.SetCellValue(ir,prefix + "ori_exp_dt",sheetObj.GetCellValue(ir,prefix + "exp_dt"),0);
					sheetObj.SetCellValue(ir,prefix + "ori_acct_itm_seq",sheetObj.GetCellValue(ir,prefix + "acct_itm_seq"),0);
					sheetObj.SetRowStatus(ir,"R");
				}
				break;
			case "vsl_":
				for (var ir=1; ir<=sheetObj.LastRow(); ir++){
					if (sheetObj.GetRowStatus(ir)!= "R") continue;
					sheetObj.SetCellValue(ir,prefix + "ori_vsl_cd",sheetObj.GetCellValue(ir,prefix + "vsl_cd"),0);
					sheetObj.SetCellValue(ir,prefix + "ori_vsl_eng_nm",sheetObj.GetCellValue(ir,prefix + "vsl_eng_nm"),0);
					sheetObj.SetRowStatus(ir,"R");
				}
				break
		}
	}
    /**
     * Calling PopUp(Item Name) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @see #setProgramNo
     **/
	function t2sheet1_OnPopupClick(sheetObj,Row,Col){
		if(sheetObj.GetRowStatus(Row) == "I") {
			ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OT", 550, 450, "setProgramNo", "1,0,1,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0076");
		} else {
			//ComShowMessage("Item Name은 변경할 수 없습니다");
			return;
		}
	}
	
	/**
     * Calling Popup (Vessel Code) <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     **/
	function t7sheet1_OnPopupClick(sheetObj,Row,Col){
		ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setGridVslCd", "1,0,1,1,1", true, false, Row, Col, 0, "ESM_FMS_0022");
	}
	/**
     * Download File <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	File Name
     **/
	function t5sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix="cpf_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}
	/**
     * Download File <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	File Name
     **/
	function t6sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix="cef_";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_sav_id") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_sav_id");
		return;
	}

	/**
     * Event occurred when mouse pointer is moving <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	Selected Button of sheetObj
     * @param {ibsheet} Shift     	Selected Shift of sheetObj
     * @param {int} 	X     		X Coordinate Value
     * @param {int} 	Y     		Y Coordinate Value
     **/
	function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		changeGetMousePointer(sheetObj,"otr_");
	}
	/**
     * Changing shape of mouse pointer <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	Variable Separator
     **/
	function changeGetMousePointer(sheetObj, prefix){
		var Row=sheetObj.MouseRow();
		var Col=sheetObj.MouseCol();
		if (Row<sheetObj.HeaderRows()|| Col<0) return;
		var saveName=sheetObj.ColSaveName(Col);
		if(prefix == "otr_") {
			if (saveName!=prefix+"acct_itm_nm") return;
			var status=sheetObj.GetRowStatus(Row);
			if (saveName==prefix+"acct_itm_nm") {
				sheetObj.SetMousePointer((status=="I")?"Hand":"Default");
			}
		} else {
			if (saveName!=prefix+"file_nm" && saveName!=prefix+"file_download") return;
			var status=sheetObj.GetRowStatus(Row);
			if (saveName==prefix+"file_nm") {
				sheetObj.SetMousePointer((status=="I")?"Hand":"Default");
			} else if (saveName==prefix+"file_download") {
				sheetObj.SetMousePointer((status=="I")?"Default":"Hand");
			}
		}
	}
	/**
	 * Inserting programNo<br>
	 * @param {arry} aryPopupData
	 */
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		//UI수정(201408 민정호)
		var prefix="hir_";
		
		sheetObjects[2].SetCellValue(row,col,aryPopupData[0][2],0);
	    sheetObjects[2].SetCellValue(row,"otr_acct_cd",aryPopupData[0][3],0);
	    sheetObjects[2].SetCellValue(row,"otr_acct_itm_seq",aryPopupData[0][4],0);
	    setOtrEffDt(row,"otr_");
	}
	/**
	 * Inserting Vessel Code <br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Getting Name information after inserting Vessel Code
		form.vsl_cd.readOnly=true;
		form.btn_vslpop.style.cursor="default";
		//document.images["btn_vslpop"].name="no_btn_vslpop";
	}
	/**
	 * Inserting Vessel Code (Setting in Grid)<br>
	 * @param {arry} aryPopupData
	 */
	function setGridVslCd(aryPopupData, row, col, sheetIdx){
//	    sheetObjects[7].Cellvalue2(row,"vsl_vsl_eng_nm")=aryPopupData[0][3];
//	    sheetObjects[7].Cellvalue(row,"vsl_vsl_cd")=aryPopupData[0][2];
	    sheetObjects[7].SetCellValue(row,"vsl_vsl_eng_nm",aryPopupData[0][3],0);
	    sheetObjects[7].SetCellValue(row,"vsl_vsl_cd",aryPopupData[0][2],0);
	    if(aryPopupData[0][2] == form.vsl_cd.value) {
	    	ComShowMessage(ComGetMsg('FMS01064', aryPopupData[0][2]));
	    	sheetObjects[7].SelectCell(row,"vsl_vsl_cd");
	    	sheetObjects[7].SetCellValue(row,"vsl_vsl_cd","",0);
	    	sheetObjects[7].SetCellValue(row,"vsl_vsl_eng_nm","",0);
	    } else {
	    	if(sheetObjects[7].GetRowStatus(row)== "I") {
	    		
//		    	sheetObjects[7].Cellvalue2(row,"vsl_ori_vsl_cd")=aryPopupData[0][2];
//		    	sheetObjects[7].Cellvalue2(row,"vsl_ori_vsl_eng_nm")=aryPopupData[0][3];
		    	sheetObjects[7].SetCellValue(row,"vsl_ori_vsl_cd",aryPopupData[0][2],0);
		    	sheetObjects[7].SetCellValue(row,"vsl_ori_vsl_eng_nm",aryPopupData[0][3],0);
		    }
	    }
	}
	/**
     * Getting FileSaveId of attached File supposed to be sent by Email <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	Variable Separator
     * @return {String} fileKey     Attached File FileSaveId 
     **/
	function checkAttachFile(sheetObj, prefix) {
		var fileKey="";
		var sRow=sheetObj.FindCheckedRow(prefix + "DelChk");
		if (sRow == "") {
			ComShowMessage(ComGetMsg('COM12189'));
			//ComShowMessage(ComGetMsg('FMS01153'));
			return fileKey;
		} else {
			var arrRow=sRow.split("|");
			//UI개선(201408 민정호)
//			for (var idx=arrRow.length-2; idx>=0; idx--) {
			for (var idx=arrRow.length-1; idx>=0; idx--) {			
				var row=arrRow[idx];
				if(sheetObj.GetCellValue(row,prefix + "file_sav_id") == "") {
					ComShowMessage(ComGetMsg('FMS01148', row));
					//ComShowMessage("파일이 저장되지 않았습니다\n\n[저장되지않은 ROW : "+row+"]");
					return "";
					break;
				}
				fileKey += sheetObj.GetCellValue(row,prefix + "file_sav_id")+ "<" + sheetObj.GetCellValue(row,prefix + "file_nm") + ";";
			}
		}
		fileKey=fileKey.substring(0,fileKey.length-1);
		return fileKey;
	}
	/**
     * Handling Date Effectiveness Verification Process about input Value of IBSheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String} 	value    	Inserted value of sheetObj
     * @param {String} 	prefix   	Variable Separator
     * @see #ComRowHideDelete
     **/
	function rowRemove(sheetObj, prefix) {
		ComRowHideDelete(sheetObj, prefix + "DelChk");
		/*
    	var sRow=sheetObj.FindCheckedRow(prefix + "DelChk");
		if (sRow == "") return;
		//Row to Array
		var arrRow=sRow.split("|"); //result : "1|3|5|"
		for (var idx=arrRow.length-2; idx>=0; idx--){
			var row=arrRow[idx];
			sheetObj.SetRowHidden(row,1);
			sheetObj.SetRowStatus(row,"D");
		}
		*/
	}
    /**
     * Getting First unhidden Row in IBSheet Grid input values <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {row} 	row			row number
     * @see #sheet_chekPeriod
     **/
	function getFirstRow(sheetObj){
		for (var ir=sheetObj.HeaderRows(); ir<sheetObj.LastRow(); ir++){
			if (sheetObj.GetRowHidden(ir)==false){
				return ir;
			}
		}
		return -1;
	}
    /**
     * Getting Last unhidden Row in IBSheet Grid input values <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {row} 	row 		row number
     **/
	function getLastRow(sheetObj){
		for (var ir=sheetObj.LastRow(); ir>=sheetObj.HeaderRows(); ir--){
			if (sheetObj.GetRowHidden(ir)==false){
				return ir;
			}
		}
		return -1;
	}
	/**
     * Getting Smallest unhidden value in IBSheet Grid input values <br>
     * @param {ibsheet} 	sheetObj    IBSheet Object
     * @return {arrEffDt} 	arrEffDt	earliest From Date
     **/
	function getLeastValue(sheetObj){
		var arrEffDt=new Array();
		var i=0;
		for (var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++){
			if (sheetObj.GetRowHidden(ir)==false){
				arrEffDt[i++]=sheetObj.GetCellText(ir,"otr_eff_dt");
			}
		}
		for(var j=0; j<arrEffDt.length; j++) {
			for(var k=j; k<arrEffDt.length; k++) {
				if(arrEffDt[j]>arrEffDt[k]) {
					var tmp=arrEffDt[j];
					arrEffDt[j]=arrEffDt[k];
					arrEffDt[k]=tmp;
				}
			}
		}
		return arrEffDt[0].trimAll("-");
	}
	/**
     * Getting Biggest unhidden value in IBSheet Grid input values <br>
     * @param {ibsheet} 	sheetObj    IBSheet Object
     * @return {arrExpDt} 	arrExpDt	Latest To Date
     **/
	function getGreatestValue(sheetObj){
		var arrExpDt=new Array();
		var i=0;
		for (var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++){
			if (sheetObj.GetRowHidden(ir)==false){
				arrExpDt[i++]=sheetObj.GetCellText(ir,"otr_exp_dt");
			}
		}
		for(var j=0; j<arrExpDt.length; j++) {
			for(var k=j; k<arrExpDt.length; k++) {
				if(arrExpDt[j]<arrExpDt[k]) {
					var tmp=arrExpDt[j];
					arrExpDt[j]=arrExpDt[k];
					arrExpDt[k]=tmp;
				}
			}
		}
		return arrExpDt[0].trimAll("-");
	}
	/**
     * Getting the most recent date corresponding to current Item Name (Biggest unhidden value(other Exp tab)) <br>
     * @param {ibsheet} 	sheetObj    	IBSheet Object
     * @param {ibsheet} 	row     		Selected Row of sheetObj
     * @param {String} 		currAcctItmNm   current Item Name
     * @return {arrExpDt} 	arrExpDt		Biggest value of the Item Name
     **/
	function getOtrGreatestValue(sheetObj, row, currAcctItmNm){
		var arrExpDt=new Array();
		var i=0;
		for (var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++){
			if (   sheetObj.GetRowHidden(ir)==false
				&& row != ir
				&& currAcctItmNm == sheetObj.GetCellValue(ir,"otr_acct_itm_nm")){
				arrExpDt[i++]=sheetObj.GetCellText(ir,"otr_exp_dt");
			}
		}
		for(var j=0; j<arrExpDt.length; j++) {
			for(var k=j; k<arrExpDt.length; k++) {
				if(arrExpDt[j]<arrExpDt[k]) {
					var tmp=arrExpDt[j];
					arrExpDt[j]=arrExpDt[k];
					arrExpDt[k]=tmp;
				}
			}
		}
		return arrExpDt[0].trimAll("-");
	}
	/**
     * Getting the earliest date corresponding to current Item Name (smallest unhidden value(other Exp tab)) <br>
     * @param {sheetObj}    sheetObj 			Object
     * @param {String} 		prefix   			Variable Separator
     * @returns String,  	preOtrAcctItmNm 	Item Name smalliest row<br>
     **/
	function setFirstOtrEffDtGetCellEditable(sheetObj, prefix){
		var preOtrAcctItmNm;
		var currOtrAcctItmNm;
		for(var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++){
			currOtrAcctItmNm=sheetObj.GetCellValue(ir,"otr_acct_itm_nm");
			if(preOtrAcctItmNm != currOtrAcctItmNm) {
				sheetObj.SetCellEditable(ir,prefix + "eff_dt",1);
			}
			preOtrAcctItmNm=sheetObj.GetCellValue(ir,"otr_acct_itm_nm");
		}
	}

	/**
     * Delete date confirm<br>
     * @return {boolean} okYn 
     **/
	function delConfirm() {
		if(comboObjects[1].GetSelectCode()== "ACT") {
			ComShowMessage(ComGetMsg('FMS01082'));
			return;
		}
		var okYn=ComShowConfirm(ComGetMsg('FMS00012',ComGetMsg('FMS01090')));
		return okYn;
	}
	/**
     * Deciding whether Currency Code value is existing in IBSheet input values <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String} 	value    	Inserted value of sheetObj
     * @param {String} 	prefix   	Variable Separator
     * @return none
     * @see #setCurrCd
     **/
    function currencyOnChange(sheetObj,row,col,value,prefix) {
    	if(sheetObj.ColSaveName(col)==(prefix + "hir_curr_n1st_cd")) {
    		var hirCurrN1stCdCol=sheetObj.SaveNameCol(prefix + "hir_curr_n1st_cd");
    		var hirCurrN1stCdValue=sheetObj.GetCellValue(row,hirCurrN1stCdCol);
    		if(hirCurrN1stCdValue == "") return;
    		if(hirCurrN1stCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.SetCellValue(row,hirCurrN1stCdCol,"",0);
				sheetObj.SelectCell(row,hirCurrN1stCdCol);
				return;
    		}
    		form.curr_cd.value=hirCurrN1stCdValue;
			setCurrCd(row, "hirCurrN1stCd");
    	} else if (sheetObj.ColSaveName(col)==(prefix + "hir_curr_n2nd_cd")) {
            var hirCurrN2ndCdCol=sheetObj.SaveNameCol(prefix + "hir_curr_n2nd_cd");
            var hirCurrN2ndCdValue=sheetObj.GetCellValue(row,hirCurrN2ndCdCol);
            if(hirCurrN2ndCdValue == "") return;
            if(hirCurrN2ndCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.SetCellValue(row,hirCurrN2ndCdCol,"",0);
				sheetObj.SelectCell(row,hirCurrN2ndCdCol);
				return;
    		}
    		form.curr_cd.value=hirCurrN2ndCdValue;
			setCurrCd(row, "hirCurrN2ndCd");
    	} else if (sheetObj.ColSaveName(col)==(prefix + "curr_cd")) {
            var currCdCol=sheetObj.SaveNameCol(prefix + "curr_cd");
            var currCdValue=sheetObj.GetCellValue(row,currCdCol);
            if(currCdValue == "") return;
            if(currCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.SetCellValue(row,currCdCol,"",0);
				sheetObj.SelectCell(row,currCdCol);
				return;
    		}
    		form.curr_cd.value=currCdValue;
			setCurrCd(row, "currCd");
    	}
	}
    /**
     * Deciding whether Currency2 and Daily Hire Values are inserted correctly in IBSheet input values  <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String} 	value    	Inserted value of sheetObj
     * @param {String} 	prefix   	Variable Separator
     * @return none
     * @see #setCurrCd
     **/
    function currency2OnChange(sheetObj,row,col,value,prefix) {
    	if (sheetObj.ColSaveName(col)==(prefix + "hir_rt_n2nd_amt")) {
    		var hirCurrN2ndCdCol=sheetObj.SaveNameCol(prefix + "hir_curr_n2nd_cd");
    		var hirCurrN2ndCdValue=sheetObj.GetCellValue(row,hirCurrN2ndCdCol);
            var hirRtN2ndAmtCol=sheetObj.SaveNameCol(prefix + "hir_rt_n2nd_amt");
            var hirRtN2ndAmtValue=sheetObj.GetCellValue(row,hirRtN2ndAmtCol);
            if(hirRtN2ndAmtValue == "") {
            	return;
            } else {
            	if(sheetObj.GetCellValue(row,prefix + "hir_rt_n2nd_amt") < 1) {
            		ComShowMessage(ComGetMsg('FMS01163'));
        			sheetObj.ValidateFail(1);
            	} else {
            		if(hirCurrN2ndCdValue == "") {
            			sheetObj.ValidateFail(1);
            		}
            	}
            }
    	}
	}
    /**
     * Getting Currency Code information <br>
     * @param {ibsheet} row     	Selected Row of sheetObj
     **/
    function setCurrCd(row, gubun) {
    	if(gubun == "currCd") {
    		doActionIBSheet(sheetObjects[2], document.form, IBROWSEARCH, gubun, row);
    	} else {
    		doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, gubun, row);
    	}
    }
    /**
     * Checking inserted Code value is existing in DB  <br>
     * @param {string}	currencyValue    Changed Value of currencyValue Cell
     * @returns {bool}  <br>
     *          true  : Code Existing<br>
     *          false : Code not Existing<br>
     **/
    function currency_code_check(currencyValue) {
    	var existCnt=0;
    	for(var i=0; i<form.currency_cd.length; i++) {
    		if(form.currency_cd[i].value == currencyValue) {
    			existCnt++;
    			break;
    		}
        }
    	if(existCnt == 0)
    		return false;
    	else
    		return true;	
    }
    /**
     * Checking implemetation when Event is occurred <br>
     * @return {boolean} okYn   Clicking confirm Button? okYn:true else okYn:false
     **/
    function initConfirm() {
    	var okYn=true;
    	//if(sheetObjects[0].RowCount > 0 && rowChangeYn()) {
    	if(   sheetObjects[1].IsDataModified()
    	   || sheetObjects[2].IsDataModified()
    	   || sheetObjects[3].IsDataModified()
    	   || (sheetObjects[4].IsDataModified()&& sheetObjects[4].RowCount()> 1)
    	   || sheetObjects[5].IsDataModified()
    	   || sheetObjects[6].IsDataModified()
    	   || sheetObjects[7].IsDataModified()) {
    		var okYn=confirm(ComGetMsg('FMS00002'));
    	}
    	return okYn;
    }
    /**
	 * Inserting Customer Code<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setCustomrCode(aryPopupData, Row, Col, sheetIdx){
		form.cust_cnt_cd.value=aryPopupData[0][4];
		form.cust_seq.value=aryPopupData[0][5];
		cust_seq_change();
	}
    /**
	 * Inserting Owner Name <br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setVendorCode(aryPopupData, Row, Col, sheetIdx){
		form.cust_seq.value=aryPopupData[0][5];
		cust_seq_change();
	}
	/**
	 * Inserting Flag Name <br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setFlagCode(aryPopupData, Row, Col, sheetIdx) {
		form.vsl_cnt_cd.value=aryPopupData[0][3];
		form.cnt_nm.value=aryPopupData[0][4];
	}
    /**
     * Making Uom Combo Box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Name corresponding to Code of Type 
     * @param {String}  comboCode   Code Value of Type
     **/
    function setPayTermMakeCombo(sheetObj, comboText, comboCode) {
    	if(comboText != "" ) {
    		var typeText=comboText.substring(0,comboText.length-1);
    		var typeCode=comboCode.substring(0,comboCode.length-1);
        	sheetObj.SetColProperty("pay_ctrt_pay_term_cd", {ComboText:typeText, ComboCode:typeCode} );
    	}
    }
    /**
     * Setting Contract Type/Contract Fact Combo<br>
     * @param {ibsheet} comboObj    IBSheet Object
     * @param {String} 	comboText   combo Name 
     * @param {String} 	comboCode   combo Value 
     * @return none
     **/
	function setDataCombo(comboObj, comboText, comboCode) {
        switch(comboObj.options.id) {
            case "flet_ctrt_tp_cd":
            	if(comboText != "" ) {
	            	var comboTextList=comboText.split("|");
	            	var comboCodeList=comboCode.split("|");
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i].toString());
	            	}
	            	comboObj.SetSelectCode(comboCodeList[0]);
	            	comboObj.SetBackColor("#CCFFFD");
            	}
                break;
            case "flet_ctrt_fact_cd":
            	if(comboText != "" ) {
	            	var comboTextList=comboText.split("|");
	            	var comboCodeList=comboCode.split("|");
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i].toString());
	            	}
	            	comboObj.SetSelectCode(comboCodeList[0]);
	            	comboObj.SetBackColor("#CCFFFD");
            	}
                break;
        } 
    }

	/**
     * Prevent Modifying in case Contract Fact Value is PSE <br>
     * @return none
     **/
    function setOwnerCodeReadOnly() {
    	form.cust_cnt_cd.readOnly=true;
    	form.cust_seq.readOnly=true;
    	form.owner_code.style.cursor="default";
    	//document.images["owner_code"].name="no_owner_code";
    	form.cust_cnt_cd.className="input2";
    	form.cust_seq.className="input2";
    }
    /**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  prefix     	variable separator
     * @param {string}  curSaveName currency saveName
     * @param {string}  amtSaveName amt saveName
     **/
    function setInitCellProperty(sheetObj, prefix, curSaveName, amtSaveName, col) {
    	if(curSaveName == null || curSaveName == "") {
	    	for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
	    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "hir_curr_n1st_cd"))) {
	    			var info = {Type: "Int", Align: "Right", Format:"NullInteger"};
	    			sheetObj.InitCellProperty(ir, 6, info);
				}
	    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + "hir_curr_n2nd_cd"))) {
	    			var info = {Type: "Int", Align: "Right", Format:"NullInteger"};
	    			sheetObj.InitCellProperty(ir, 8, info);
				}
			}
    	} else {
    		for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
    			if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, prefix + curSaveName))) {
					if(col == null || col == "") {
		    			var info = {Type: "Int", Align: "Right", Format:"NullInteger"};
		    			sheetObj.InitCellProperty(ir, 8, info);
					} else {
		    			var info = {Type: "Int", Align: "Right", Format:"NullInteger"};
		    			sheetObj.InitCellProperty(ir, col, info);
					}
				}
			}
    	}
    }
	/**
     * Error Handling of t2sheet1 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg   	Error Message 
     * @return none
     **/
	function imsi_t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.ShowSubSum([{StdCol:"a", SumCols:"a", Sort:true, ShowCumulate:false, CaptionCol:3, CaptionText:"0=;1=;2=;"}]);
		var sRow=sheetObj.FindSubSumRow("a");
		var arrRow=sRow.split("|");
		for(idx=0; idx < arrRow.length-1 ; idx++) {
			if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="AA" ) {
				sheetObj.SetCellValue(arrRow[idx],"d","▶ Discrepancy by Detail Date",0);
			} else if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="BB" ) {
				sheetObj.SetCellValue(arrRow[idx],"d","▶ Duplicate",0);
			} else if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="CC" ) {
				sheetObj.SetCellValue(arrRow[idx],"d","▶ OPS List Only",0);
			} else if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="DD" ) {
				sheetObj.SetCellValue(arrRow[idx],"d","▶ Invoice Only",0);
			} else if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="EE" ) {
				sheetObj.SetCellValue(arrRow[idx],"d","▶ Double Bill",0);
			}
		}
	}
	/**
     * Error Handling of t3sheet1  <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg   	Error Message 
     * @return none
     **/
	function imsi_t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.ShowSubSum([{StdCol:"a", SumCols:"a", Sort:true, ShowCumulate:false, CaptionCol:3, CaptionText:"0=;1=;2=;"}]);
		var sRow=sheetObj.FindSubSumRow("a");
		var arrRow=sRow.split("|");
		for(idx=0; idx < arrRow.length-1 ; idx++) {
			if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="A" ) {
				sheetObj.SetCellValue(arrRow[idx],"d","▶ Auto Calculated Cost",0);
			} else if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="M" ) {
				sheetObj.SetCellValue(arrRow[idx],"d","▶ Manual Input Cost",0);
			}
		}
	}
	
	
	/**
     * Adding selected Files to upload into IBSheet by IBUpload <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	Variable Separator
     **/
	function setFileUpload(sheetObj, prefix){		
		//Finding Row in "Insert" Transaction State
		var sRow = sheetObj.FindStatusRow("I");			
		var arrRow = sRow.split(";");
		var cnt = 0;
			
		for (var idx=0; idx<=arrRow.length; idx++){ 
			var row = arrRow[idx];
			
			if(row > 0){
				var sFile = sheetObj.GetCellValue(row,prefix + "file_path");	
				if (sFile=="" || sFile==-1){
					ComShowMessage(ComGetMsg('FMS01075'));				
				}else{								
					cnt++;
				}
			}				
		}	
		var param = prefix + "file_cnt=" + cnt;
		return param;
	}
		
	function setEmail(aryPopupData){
        var sheetObject6=sheetObjects[5];
        var sheetObject7=sheetObjects[6];
        var formObject=document.form;
        
		var fileKey = "";
		var vsl_eng_nm = "";
		var subject = "";
		var fileNm = "";
		
		if(tabObjects[0].GetSelectedIndex() == 4){
			//btn_t5E-mail
			fileKey=checkAttachFile(sheetObject6, 'cpf_');
			if(fileKey == "") return;
			vsl_eng_nm=formObject.vsl_eng_nm.value;
			subject="Charter Party ("+vsl_eng_nm+")";			
		}else{
			//btn_t6E-mail
			fileKey=checkAttachFile(sheetObject7, 'cef_');
			if(fileKey == "") return;
			vsl_eng_nm=formObject.vsl_eng_nm.value;
			subject="Certificate ("+vsl_eng_nm+")";			
		}
	
		
		formObject.com_recipient.value="";
    	var com_recipient="";
    	var idx=0;
    	var chkCnt=aryPopupData.length;
        for(var i=0; i<aryPopupData.length; i++) {
        	idx++;
 		    var emailData=aryPopupData[i];
 		    if(chkCnt == 1) {
 		    	com_recipient=emailData.cntc_pson_eml;
 		    } else {
 		    	if(chkCnt == idx) {
 		    		com_recipient += emailData.cntc_pson_eml;
 		    	} else {
 		    		com_recipient += emailData.cntc_pson_eml+";";
 		    	}
 		    }
    	}
        formObject.com_recipient.value=com_recipient;       						
        formObject.com_subject.value = subject;
        formObject.com_fileKey.value = fileKey;
        	        
        ComSendMail();		
	}
	