/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_3514.js
 *@FileTitle  : Inland Rates Creation &amp; Amendment
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_3514 : business script for  ESM_PRI_3514
     */
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var LOC_MAX_SEQ=0;  //Setting after retrieving Location Information MAX SEQ value
    var MAX_UPD_DT="";  //lastest update data
    //seperating saving message
    var supressConfirm=false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
                case "btn_new":
                    doActionIBSheet(sheetObject1,formObject,IBCREATE);
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
                    break;
                case "btn_amend":
                    doActionIBSheet(sheetObject1,formObject,MODIFY01);
                    break;
                case "btn_save":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;
                case "btn_delete":
                    doActionIBSheet(sheetObject1,formObject,REMOVE01);
                    break;
                case "btn_request":
                    doActionIBSheet(sheetObject1,formObject,MODIFY02);
                    break;
                case "btn_approve":
                    doActionIBSheet(sheetObject1,formObject,MODIFY03);
                    break;
                case "btn_publish":
                    doActionIBSheet(sheetObject1,formObject,MODIFY04);                  
                    break;
                case "btn_cancel":
                    doActionIBSheet(sheetObject1,formObject,REMOVE02);
                    break;
                case "btn_fileadd":
                    doActionIBSheet(sheetObject2,formObject,MODIFY05);
                    break;
                case "btn_filedelete":
                    doActionIBSheet(sheetObject2,formObject,REMOVE03);
                    break;
                case "btn_filesave":
                    doActionIBSheet(sheetObject2,formObject,MODIFY06);
                    break;
                case "btn_rowadd":
                    doActionIBSheet(sheetObject3,formObject,IBINSERT);
                    break;
                case "btn_rowdelete":
                    doActionIBSheet(sheetObject3,formObject,IBDELETE);
                    break;
                case "btn_rowamend":
                    doActionIBSheet(sheetObject3,formObject,MODIFY07);
                    break;
                case "btn_amendcancel":
                    doActionIBSheet(sheetObject3,formObject,MODIFY08);
                    break;
                case "btns_calendar1":  
                    var cal=new ComCalendar();
                    cal.select(formObject.eff_dt, 'yyyy-MM-dd');
                    break;
                case "btns_calendar2":      
                    var cal=new ComCalendar();
                    cal.select(formObject.exp_dt, 'yyyy-MM-dd');
                    break;
                case "btn_downexcel":
                	doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);                  
                    break;
                case "btn_loadexcel":
                    doActionIBSheet(sheetObject3,formObject,IBLOADEXCEL);
                    break; 
                case "btn_rowsearch":
                    doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC05);
                    break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
  /**
    * registering IBSheet Object as list <br>
    * adding process for list in case of needing batch processing with other items <br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj Mandatory IBSheet Object
    * @return N/A
    * @author 
    * @version 2010.10.13
    */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
  /**
    * registering IBCombo Object as list<br>
    * adding process for list in case of needing batch processing with other items <br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(comboObj);
    * </pre>
    * @param {ibcombo} combo_obj Mandatory IBCombo Object
    * @return N/A
    * @author 
    * @version 2010.10.13
    */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }

   /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return N/A
    * @author 
    * @version 2010.10.13
    */
    function loadPage() {
        var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
            //sheetObjects[i].XmlHttpVer = 2;
        }
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        
        initUpload();
        
        //uploadObjects[0].AutoConfirm="UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
        initControl();
        toggleButtons();
        //Setting Tariff Code Combo
        ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd'));
        ComPriTextCode2ComboItem(aproOfcCdComboValue, aproOfcCdComboText, getComboObject(comboObjects, 'apro_ofc_cd')); 
        ComPriTextCode2ComboItem(trfInlndAmdtTCdComboValue, trfInlndAmdtTCdComboText, getComboObject(comboObjects, 'trf_inlnd_amdt_tp_cd'));    
        if (formObj.trf_inlnd_seq.value != "") {      
            var trfPfxCd=formObj.trf_pfx_cd.value;
            var trfNo=formObj.trf_no.value;
            var trfInlndSeq=formObj.trf_inlnd_seq.value;
            var trfCd=trfPfxCd + "-" + trfNo;           
            comboObjects[0].SetSelectCode(trfCd);
            tariff_cd_OnBlur(comboObjects[0]);
            comboObjects[1].SetSelectCode(trfInlndSeq);
        }else{
            doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
        }
    }
    
    function initUpload(){
    	upload1.Initialize({
			SaveUrl:'/opuscntr/ESM_PRI_3514GS.do',
			ShowButtonArea: true,
			ShowInfoArea: true,
			ExtraForm:'upLoadForm',
			AddSaveButton: function(ibup){
				
			},
            AfterSaveStatus : function(result) {
		          code = result.code;
		          sXml = result.xmlData;
		          if( code == 0) {
		               var formObj=document.form;
		                  if(formObj.f_cmd.value == MULTI01){
		                      if (pSheetObj.GetRowStatus(pSheetObj.HeaderRows()) == "I") {
		                          var comboObj=comboObjects[1];
		                          var inlandName=comboObj.GetSelectText();
		                          doActionIBSheet(pSheetObj, formObj, IBSEARCH);
		                          var code=comboObj.FindItem(inlandName, 0);
		                          if (code == null || code == "" || code == "X") {
		                              comboObj.SetSelectIndex(-1);
		                          } else {
		                              comboObj.SetSelectCode(code);//onChange event
		                          }
		                          //////////////////////////////////
		                      } else if(pSheetObj.GetRowStatus(pSheetObj.HeaderRows()) == "U") {
		                          var comboObj=comboObjects[1];
		                          var sCode=pSheetObj.GetCellValue(pSheetObj.HeaderRows(), "trf_inlnd_seq");
		                          //Setting combo without retrieving screen when modifying Inland Rates Name
		                          if(comboObj.GetSelectText()!= comboObj.GetText(sCode, 0)) {
		                              comboObj.SetText(sCode, 0, comboObj.GetSelectText());
		                          }
		                          doActionIBSheet(pSheetObj, formObj, IBSEARCH_ASYNC02);
		                      }
		                      sheetObjects[2].LoadSaveData(sXml, {Sync:1});
		                      sXml=ComDeleteMsg(sXml);
		                      sheetObjects[0].LoadSaveData(sXml, {Sync:1});
		                      //latest update date
		                      MAX_UPD_DT=ComGetEtcData(sXml,"MAX_UPD_DT");
		                      toggleButtons();
		                  } else {
		
		                      doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);                                        
		                      //5. Loading XML to IBSHeet
		                      pSheetObj.LoadSaveData(sXml);   
		                  }
		                  
		                  
		          }else {
		              ComShowMessage(result.msg);
		          }
		    },
			BeforeSaveStatus : function(result) {
//				 var files = result.files;
			   var files = upload1.GetList();     
               var fileName= files[files.length-1].GetFileName();
               var prefix="";
               var formObj=document.form;
               
               if(formObj.f_cmd.value == MULTI01){
                   var sParam=FormQueryString(formObj);
                   var sParamSheet1=sheetObjects[0].GetSaveString(true);
                   if (sParamSheet1 != "") {
                       sParam=sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                   }
                   var sParamSheet2=sheetObjects[2].GetSaveString();
                   if (sParamSheet2 != "") {
                       sParam=sParam + "&" + ComPriSetPrifix(sParamSheet2, "sheet3_");
                   }
               } else {
                    var sParam="f_cmd=" + MULTI02;
                       //3.2.making QueryString from IBSheet
                       var sParamSheet=sheetObjects[1].GetSaveString();
                       if (sParamSheet != "") {
                           sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                       }
                   
               }
               paramToForm(sParam);
               return true;
			},
			AfterAddFile : function(result) {
				
				var Row=sheetObjects[1].DataInsert(-1);
//                sheetObj.SelectCell(Row, "atch_file_nm",true);
                
				 var files = upload1.GetList();
			     var fileName=files[files.length-1].GetFileName();
			     var serialNo = files[files.length-1].GetSerialNo();
			   //  var row = sheet2.GetSelectRow();
							
					for( var i = 0; i < files.length; i++) {
						//console.log(sheet2.GetCellValue(sheet2.GetSelectRow(), "atch_file_nm") + ">>" + files[i].GetSerialNo());
						if(sheet2.GetCellValue(sheet1.GetSelectRow(), "atch_file_nm") == files[i].GetFileName()){
							upload1.RemoveOneFile(files[i].GetSerialNo());
						}
					}	
                
					sheet2.SetCellValue(Row, "file_path_url", fileName, 0);
					sheet2.SetCellValue(Row, "atch_file_nm", fileName.substr(fileName.lastIndexOf("\\")+1),0);
					sheet1.SetCellValue(sheetObjects[0].HeaderRows(), "atch_file_nm", fileName, 0);
					
					sheet2.SetCellValue(Row, "trf_pfx_cd",sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "trf_pfx_cd"),0);
                    sheet2.SetCellValue(Row, "trf_no",sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "trf_no"),0);
                    sheet2.SetCellValue(Row, "trf_inlnd_seq",sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "trf_inlnd_seq"),0);
                    sheet2.SetCellValue(Row, "amdt_seq",sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "amdt_seq"),0);
                    
                    toggleButtons();

			},
			BeforeAddFile : function(result){
				//if(sheet2.GetSelectRow() == -1) return false;
				return true;
			},
			AfterOnload : function() {
		          upload1.SetCustomAddButtonAsID('btn_fileadd');
			}
		});
    }
    
    
    
    
//    function initUpload(){
//        upload1.Initialize({
//            SaveUrl:'/opuscntr/ESM_PRI_3514GS.do'
//            ,Files:[]
//            ,BeforeAddFile : function(result){
//                var files = result.files;
//                var fileName= files[files.length-1].GetFileName();
//                
//                var sRow=pSheetObj.RowStatus(pRow);
//                if(sRow == "I"){
//                    pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
//                    sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(), "atch_file_nm",fileName,0);
//                    return true;
//                }
//                return false;
//            }
//            ,BeforeSaveStatus : function(result){ 
//                var files = result.files;
//                var fileName= files[files.length-1].GetFileName();
//                var prefix="";
//                var formObj=document.form;
//                
//                if(formObj.f_cmd.value == MULTI01){
//                    var sParam=FormQueryString(formObj);
//                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
//                    if (sParamSheet1 != "") {
//                        sParam=sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
//                    }
//                    var sParamSheet2=sheetObjects[2].GetSaveString();
//                    if (sParamSheet2 != "") {
//                        sParam=sParam + "&" + ComPriSetPrifix(sParamSheet2, "sheet3_");
//                    }
//                } else {
//                     var sParam="f_cmd=" + MULTI02;
//                        //3.2.making QueryString from IBSheet
//                        var sParamSheet=sheetObj.GetSaveString();
//                        if (sParamSheet != "") {
//                            sParam += "&" + ComPriSetPrifix(sParamSheet, "");
//                        }
//                    
//                }
//                paramToForm(sParam);
//                return true;
//            }
//            ,AfterSaveStatus : function(result) {
//                code = result.code;
//                sXml = result.xmlData;
//                if( code == 0) {
//                     var formObj=document.form;
//                        if(formObj.f_cmd.value == MULTI01){
//                            if (pSheetObj.GetRowStatus(pSheetObj.HeaderRows()) == "I") {
//                                var comboObj=comboObjects[1];
//                                var inlandName=comboObj.GetSelectText();
//                                doActionIBSheet(pSheetObj, formObj, IBSEARCH);
//                                var code=comboObj.FindItem(inlandName, 0);
//                                if (code == null || code == "" || code == "X") {
//                                    comboObj.SetSelectIndex(-1);
//                                } else {
//                                    comboObj.SetSelectCode(code);//onChange event
//                                }
//                                //////////////////////////////////
//                            } else if(pSheetObj.GetRowStatus(pSheetObj.HeaderRows()) == "U") {
//                                var comboObj=comboObjects[1];
//                                var sCode=pSheetObj.GetCellValue(pSheetObj.HeaderRows(), "trf_inlnd_seq");
//                                //Setting combo without retrieving screen when modifying Inland Rates Name
//                                if(comboObj.GetSelectText()!= comboObj.GetText(sCode, 0)) {
//                                    comboObj.SetText(sCode, 0, comboObj.GetSelectText());
//                                }
//                                doActionIBSheet(pSheetObj, formObj, IBSEARCH_ASYNC02);
//                            }
//                            sheetObjects[2].LoadSaveData(sXml);
//                            sXml=ComDeleteMsg(sXml);
//                            sheetObjects[0].LoadSaveData(sXml);
//                            //latest update date
//                            MAX_UPD_DT=ComGetEtcData(sXml,"MAX_UPD_DT");
//                            toggleButtons();
//                        } else {
//
//                            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);                                        
//                            //5. Loading XML to IBSHeet
//                            pSheetObj.LoadSaveData(sXml);   
//                        }
//                        
//                        
//                }else {
//                    ComShowMessage(result.msg);
//                }
//            }
//            ,AfterAddFile:function(result){
//            }
//        });
//    }
    
    function sheet2_OnMouseMove(sheetObj) {
//          var row     = sheetObj.MouseRow(),
//            col     = sheetObj.MouseCol(),
//            info    = null;
//
//            if(row == 1 && (col == 1 || col == 2)) {
//                sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "atch_file_nm"));
//            }
//            
//            
//            if (row > 0 &&sheetObj.ColSaveName(col) == "atch_file_nm") {
//               
//                info = sheetObj.GetCellElement(row, col, 1);
//                
//                pSheetObj = sheetObj;
//                pRow = row;
//                pCol = col;
//
//                upload1.SetFileUploadElement(info);
//            } 
//            toggleButtons();
      }

    
    
    /**
     * Loading HTML control's event on page dynamically<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2010.10.13
     */         
     function initControl() {          
         axon_event.addListenerForm('beforeactivate', 'obj_onActivate', document.form);
         axon_event.addListenerForm('blur', 'obj_onDeactivate', document.form);
         axon_event.addListenerForm ('click', 'obj_onClick', document.form);
         //axon_event.addListenerFormat ('keypress', 'obj_onKeypress', document.form);      
         //axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);  
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
     * @version 2010.10.13
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":  //hidden
                with(sheetObj){
                    var HeadTitle="Flag|TRF_PFX_CD|TRF_NO|TRF_INLND_SEQ|AMDT_SEQ|TRF_INLND_NM|EFF_DT|EXP_DT|RQST_OFC_CD|APRO_OFC_CD|TRF_INLND_STS_CD" +
                     "|TRF_INLND_STS_NM|ATCH_FILE_ID|ATCH_FILE_NM|AMDT_TP|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT|PUB_DT|BEF_PUB_DT|APRO_FLG";
                    var headCount=ComCountHeadTitle(HeadTitle);
                    SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );
                    
                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_pfx_cd" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_no" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_seq" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_nm" },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rqst_ofc_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_sts_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_sts_nm" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"atch_file_id" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"atch_file_nm" },
                     {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_amdt_tp_cd" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id" },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt" },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pub_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bef_pub_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"apro_flg" } ];
                       
                    InitColumns(cols);
                    
                    SetWaitImageVisible(0);
//                    SetAutoRowHeight(0);
//                    SetSheetHeight(100);
                }
                break;
            case "sheet2":  //upload
                with(sheetObj){
                    var HeadTitle="|File Name|Download|1|2|3|4|5|6";
                    var headCount=ComCountHeadTitle(HeadTitle);
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
                    
                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"atch_file_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1},
//                     {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"file_dn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_path_url" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"atch_file_id" },
                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trf_pfx_cd" },
                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trf_no" },
                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_seq" },
                     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" } ];
                       
                    InitColumns(cols);
                    SetEditable(1);
                    SetImageList(0,"/opuscntr/img/ico_attach.gif");
                    SetWaitImageVisible(0);
                    SetRowHidden(0, 1);
                    SetDataLinkMouse("file_dn",1);
                    SetShowButtonImage(1);
//                    SetAutoRowHeight(0);
                    SetCountPosition(0);
                    SetDataRowHeight(28);
                    //SetVisible(0);
                   // SetSheetHeight(100);
                }
                break;
            case "sheet3":  //location information
                with(sheetObj){
                    var HeadTitle1="Flag| | | | | | | | | | | | | " +
                      "|One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Source|Note" +
                      "|1|2|3|4|5|6|7|8|9|10|11|12";
                    var HeadTitle2="Flag|Sel.|Seq.|Loc. Code|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN <=|Weight\nMAX >=|Weight\nUnit|Type|Currency" +
                      "|Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Source|Note" +
                      "|1|2|3|4|5|6|7|8|9|10|11|12";
                    var headCount=ComCountHeadTitle(HeadTitle1);
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    
                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_bse_loc_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_bse_loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_bse_loc_zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys: "N"},
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_via_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"prc_inlnd_rt_trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_min_lmt_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_lmt_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_lmt_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_bx_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_40ft_hc_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_bx_rt_amt",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_20ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_40ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_40ft_hc_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_45ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trf_pfx_cd" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trf_inlnd_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"amdt_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trf_inlnd_rt_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"upd_usr_id" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"input_flg" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"color_flg" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"row_properties" }
                     ];
                       
                    InitColumns(cols);
                    resizeSheet(); //SetSheetHeight(290);
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetColProperty("inlnd_rt_term_cd", {ComboText:inlndRtTermCdComboText, ComboCode:inlndRtTermCdComboValue} );
                    SetColProperty("prc_inlnd_rt_trsp_mod_cd", {ComboText:prcRrspModCdComboText, ComboCode:prcRrspModCdComboValue} );
                    SetColProperty("inlnd_rt_lmt_wgt_ut_cd", {ComboText:inlndRtLmtWgtUtCdComboText, ComboCode:inlndRtLmtWgtUtCdComboValue} );
                    SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdComboText, ComboCode:prcCgoTpCdComboValue} );
                    SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
                    SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
                    SetShowButtonImage(2);// show popup if editable
                    //SetAutoRowHeight(0);
                }
                break;
            case "sheet4":  //download
                with(sheetObj){
                    var HeadTitle1="Flag| | | | | | | | | | | | | " +
                      "|One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Source|Note" +
                      "|1|2|3|4|5|6|7|8|9|10|11|12";
                    var HeadTitle2="Flag|Sel.|Seq.|Loc. Code|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN <=|Weight\nMAX >=|Weight\nUnit|Type|Currency" +
                      "|Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Source|Note" +
                      "|1|2|3|4|5|6|7|8|9|10|11|12";
                    var headCount=ComCountHeadTitle(HeadTitle1);
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    
                    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_bse_loc_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_bse_loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_bse_loc_zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_via_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"prc_inlnd_rt_trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_min_lmt_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_lmt_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_lmt_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_bx_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_40ft_hc_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_bx_rt_amt",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_20ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_40ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_40ft_hc_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_45ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trf_pfx_cd" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trf_inlnd_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"amdt_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"trf_inlnd_rt_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"upd_usr_id" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"input_flg" },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"color_flg" } ];
                       
                    InitColumns(cols);
                    
                    SetWaitImageVisible(0);
                    SetColProperty("inlnd_rt_term_cd", {ComboText:inlndRtTermCdComboText, ComboCode:inlndRtTermCdComboValue} );
                    SetColProperty("prc_inlnd_rt_trsp_mod_cd", {ComboText:prcRrspModCdComboText, ComboCode:prcRrspModCdComboValue} );
                    SetColProperty("inlnd_rt_lmt_wgt_ut_cd", {ComboText:inlndRtLmtWgtUtCdComboText, ComboCode:inlndRtLmtWgtUtCdComboValue} );
                    SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdComboText, ComboCode:prcCgoTpCdComboValue} );
                    SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
                    SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
                    SetShowButtonImage(2);
                    SetVisible(0);
                }
                break;
        }
    }
    
    function resizeSheet(){
	    ComResizeSheet(sheetObjects[2],50);
	}
    
   /**
    * Initializing IBCOMBO<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj Mandatory IBMultiCombo Object
    * @param {int} comboNo Mandatory IBMultiCombo's Sequence
    * @return N/A
    * @author 
    * @version 2010.10.13
    */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "tariff_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetMaxLength(8);
                    SetUseAutoComplete(1);
                    ValidChar(2,3);
                }
                break;
            case "inlnd_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetMaxLength(50);
                    SetUseAutoComplete(1);
                    SetUseEdit(1);
                }
                break;   
            case "trf_inlnd_amdt_tp_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetMaxLength(1);
                    SetUseAutoComplete(1);
                }
                break;        
            case "apro_ofc_cd":
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetMaxLength(5);
                    SetUseAutoComplete(1);
                }
                break;        
        }
    }
  /**
   * Handling Sheet's process <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj Mandatory IBSheet Object
   * @param {form} formObj Mandatory html form object
   * @param {int} sAction Mandatory ,Process flag constant variable
   * @return N/A
   * @author 
   * @version 2010.10.13
   */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            sheetObj.ShowDebugMsg(false);
            switch (sAction) {
                case IBSEARCH: 
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);
                    sheetObjects[2].CheckAll("chk",0);
                    //sheetObjects[2].headCheck(1, 1)=false;
                    formObj.search_view_yn.checked=false;
                    formObj.f_cmd.value=SEARCH01;
                    var sXml=sheetObj.GetSearchData("ESM_PRI_3514GS.do", FormQueryString(formObj));
                    if(sXml != "") {
                        ComPriXml2ComboItem(sXml, inlnd_cd, "trf_inlnd_seq", "trf_inlnd_nm", true);
                    }
                    break;
                case IBSEARCH_ASYNC01: 
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);
                    sheetObjects[2].CheckAll("chk",0);
                    //sheetObjects[2].headCheck(1, 1)=false;
                    formObj.search_view_yn.checked=false;
                    formObj.f_cmd.value=SEARCH02;
                    var sParam=FormQueryString(formObj) + "&etc2="+formObj.ofc_cd.value;    
                    var sXml=sheetObj.GetSearchData("ESM_PRI_3514GS.do", sParam);
                    var arrXml=sXml.split("|$$|");
                    sheetObj.RenderSheet(0);
                    if (arrXml.length > 0) {
                        sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
                        arrXml[0]=ComDeleteMsg(arrXml[0]);
                        sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
                    }
                    LOC_MAX_SEQ=parseInt(ComGetEtcData(arrXml[0],"LOC_MAX_SEQ"),10);    
                    MAX_UPD_DT=ComGetEtcData(arrXml[0],"MAX_UPD_DT");
                    sheetObj.RenderSheet(1);
                    //Attach file 
                    searchSheetAttachedFile(arrXml[0]);
                    toggleButtons();
                    ComOpenWait(false);
                    //form control
                    //it should call ComOpenWait(false) when making comboObjects enable
                    controlFormEnable(sheetObj);                                        
                    break;
                case IBSEARCH_ASYNC02: // retrieving main
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);
                    formObj.f_cmd.value=SEARCH02;                   
                    var sParam=FormQueryString(formObj) + "&etc1=ONLY_MAIN";                                        
                    var sXml=sheetObj.GetSearchData("ESM_PRI_3514GS.do", sParam);
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    ComOpenWait(false);
                    //Attach file 
                    searchSheetAttachedFile(sXml);
                    toggleButtons();
                    //form control
                    //it should call ComOpenWait(false) when making comboObjects enable
                    controlFormEnable(sheetObj);                    
                    break;
                case IBSEARCH_ASYNC04: // Detail 
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);
                    var sheetM=sheetObjects[0];
                    var sheetD=sheetObjects[2];
                    var seqMain=sheetM.GetCellValue(sheetM.HeaderRows(), "amdt_seq");
                    var stsMain=sheetM.GetCellValue(sheetM.HeaderRows(), "trf_inlnd_sts_cd");
                    var ofcMain=sheetM.GetCellValue(sheetM.HeaderRows(), "rqst_ofc_cd");
                    sheetD.CheckAll("chk",0);
                    //sheetD.headCheck(1, 1)=false;
                    formObj.search_view_yn.checked=false;
                    formObj.f_cmd.value=SEARCH02;                   
                    var sParam=FormQueryString(formObj) + "&etc1=ONLY_DETAIL&etc2="+formObj.ofc_cd.value;
                    var sXml=sheetD.GetSearchData("ESM_PRI_3514GS.do", sParam);
                    LOC_MAX_SEQ=parseInt(ComGetEtcData(sXml,"LOC_MAX_SEQ"),10); 
                    MAX_UPD_DT=ComGetEtcData(sXml,"MAX_UPD_DT");                        
                    sheetD.LoadSearchData(sXml,{Sync:1} );
                    toggleButtons();
                    break;
                case IBSEARCH_ASYNC07: // View Amend Delete
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);      
                    sheetObj.CheckAll("chk",0);
                    //sheetObj.headCheck(1, 1)=false;
                    formObj.f_cmd.value=SEARCH02;                   
                    var sParam=FormQueryString(formObj) + "&etc1=CHECK_VIEW&etc2="+formObj.ofc_cd.value;
                    var sXml=sheetObj.GetSearchData("ESM_PRI_3514GS.do", sParam);
                    LOC_MAX_SEQ=parseInt(ComGetEtcData(sXml,"LOC_MAX_SEQ"),10); 
                    MAX_UPD_DT=ComGetEtcData(sXml,"MAX_UPD_DT");                        
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    toggleButtons();
                    break;
                case IBSEARCH_ASYNC06: // MAX SEQ
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);
                    formObj.f_cmd.value=SEARCH05;
                    //var sParam = FormQueryString(formObj);     
                    var sParam="f_cmd="+SEARCH05;                   
                    var sParamSheet=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet != "") {
                        sParam=sParam + "&" + sParamSheet;
                    }
                    var sXml=sheetObj.GetSearchData("ESM_PRI_3514GS.do", sParam);
                    var maxSeq=parseInt(ComGetEtcData(sXml,"MAX_SEQ"),10) + 1;
                    return maxSeq;
                    break;
                case IBCREATE: // New                   3
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    //resetting all oject
                    ComResetAll();
                    //resetObjectValue("0");
                    sheetObj.DataInsert();
                    sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_sts_cd","I",0);
                    sheetObj.SetCellValue(sheetObj.HeaderRows(),"amdt_seq","0",0);
                    sheetObj.SetCellValue(sheetObj.HeaderRows(),"rqst_ofc_cd",formObj.ofc_cd.value,0);
                    sheetObj.SetRowStatus(1,"I"); //
                    //sheet3 title reset
                    initLocationSheetColumn();  
                    sheetObjects[2].CheckAll("chk",0);
                    //sheetObjects[2].headCheck(1, 1)=false;
                    //initializing latest update date
                    MAX_UPD_DT="";
                    toggleButtons();
                    tariff_cd.Focus();
                    break;
                case IBSAVE: // Save
                    ComOpenWait(true);
                    sheetObjects[2].CheckAll("chk",0);
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    if (!supressConfirm && !ComPriConfirmSave()) {
                        return false;
                    }
                    var trfInlndSeq=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_inlnd_seq");
                    if(trfInlndSeq == "") {
                        var maxSeq=doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC06);
                        if(maxSeq < 0) {
                            return false;
                        }
                        ComOpenWait(true);
                        sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_seq",maxSeq,0);
                        formObj.trf_inlnd_seq.value=maxSeq;
                        for (var i=sheetObjects[2].HeaderRows(); sheetObjects[2].RowCount()> 0 && i <= sheetObjects[2].LastRow(); i++) {
                            sheetObjects[2].SetCellValue(i, "trf_inlnd_seq",maxSeq,0);
                        }
                    }
                    //adding file into IBUpload
                    formObj.f_cmd.value=MULTI01;
                    var sParam=FormQueryString(formObj);
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam=sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2=sheetObjects[2].GetSaveString();
                    if (sParamSheet2 != "") {
                        sParam=sParam + "&" + ComPriSetPrifix(sParamSheet2, "sheet3_");
                    }
                    var sXml="";
                    //Transfering request to server and getting response
                    var fileList = upload1.GetList();
                    var status = sheetObj.GetRowStatus(sheetObj.HeaderRows())
                    if(fileList.length > 0) {
                        upload1.SaveStatus();
                        upload1.InitData();
                        ComPriSaveCompleted();

                    } else {
                        var sXml = sheetObj.GetSaveData("ESM_PRI_3514GS.do", sParam );
                        //the success message is included in sXml
                        sheetObj.LoadSaveData(sXml, true);
                    }
                    
                    

                    
                    if ( status == "I") {
                        var comboObj=comboObjects[1];
                        var inlandName=comboObj.GetSelectText();

                        doActionIBSheet(sheetObj, formObj, IBSEARCH);
                        var code=comboObj.FindItem(inlandName, 0, false);
                        if (code == null || code == "" || code == "X") {
                            comboObj.SetSelectIndex(-1);
                        } else {
                            comboObj.SetSelectCode(code, true);//onChange event
                        }
                        //////////////////////////////////
                    } else if( status == "U" ){ //sheetObj.GetRowStatus(sheetObj.HeaderRows()) == "U") {
                        var comboObj=comboObjects[1];
                        var sCode=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_inlnd_seq");
                        //Setting combo without retrieving screen when modifying Inland Rates Name
                        if(comboObj.GetSelectText()!= comboObj.GetText(sCode, 0)) {
                            comboObj.SetText(sCode, 0, comboObj.GetSelectText());
                        }
                        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
                    }  else if( status == "R" ){
                    	//after saving, the sheet status is not initailized, so the below is needed
                    	//when it is removed, as soon as saving newly, if the new row is modified, it will be still new row
                    	//it makes the result of the dup-error
                    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
                    }
                                       
                    sXml=ComDeleteMsg(sXml);
                    if(sheetObj != sheetObjects[0]){
                    	sheetObjects[0].LoadSaveData(sXml);
                    }
                    

                    //latest update date
                    MAX_UPD_DT=ComGetEtcData(sXml,"MAX_UPD_DT");
//                    toggleButtons();
//                    return true;
                    break;
                case REMOVE01: // Delete
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    if (!ComShowCodeConfirm("PRI00002")) {
                        return false;
                    }
                    ComOpenWait(true);
                    formObj.f_cmd.value=REMOVE01;
                    var files = upload1.GetList();
                	var row = sheet1.GetSelectRow();
                					
                	    for( var i = 0; i < files.length; i++) {
                	    	if(sheet2.GetCellValue(sheet1.GetSelectRow(), "atch_file_nm") == files[i].GetFileName()){
            	                upload1.RemoveOneFile(files[i].GetSerialNo());
            	            }
                	    }
                    var sParam=FormQueryString(formObj);
                    var sParamSheet=sheetObj.GetSaveString(true);
                    if (sParamSheet != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                    }
                    var sXml=sheetObj.GetSaveData("ESM_PRI_3514GS.do", sParam);
                    sheetObj.LoadSaveData(sXml);
                    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
                        return false;
                    }                   
                    ///////////////////////////////////////////
                    //reseting all except tariff Code
                    var comboObj=comboObjects[0];
                    //var trfNm = formObj.trf_nm.value
                    var comboCode=comboObj.GetSelectCode();
                    //var comboText = comboCode+"|"+trfNm;
                    //reset
                    doActionIBSheet(sheetObj, formObj, IBCREATE);
                    comboObj.SetSelectCode(comboCode,false);
                    //tariff_cd_OnChange(comboObj, comboCode, comboText);
                    tariff_cd_OnBlur(comboObj);
                    inlnd_cd.Focus();
                    ///////////////////////////////////////////
                    break;
                case MODIFY01: // Amend
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    var sUrl="/opuscntr/ESM_PRI_3521.do";
                    ComOpenPopup(sUrl, 450, 280, 'callbackAmend','1,0', true);
                    
                    break;
                case MODIFY02: // Request
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    //Requesting after saving in case of modification
                    if (sheetObj.IsDataModified()|| sheetObjects[2].IsDataModified()) {
                        var rslt=false;                     
                        if (ComShowCodeConfirm("PRI00006")) {
                            supressConfirm=true;
                            rslt=doActionIBSheet(sheetObj,document.form,IBSAVE);
                            supressConfirm=false;
                        }
                        if (!rslt) {
                            return false;
                        }
                    }
                    if (!ComShowCodeConfirm("PRI06001")) {
                        return false;
                    }
                    ComOpenWait(true);                  
                    //sheetObj.CellValue2(sheetObj.SelectRow, "trf_inlnd_sts_cd") = "Q";
                    var sParam="f_cmd=" + MODIFY02;
                    var sParamSheet=sheetObj.GetSaveString(true);
                    if (sParamSheet != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                    }
                    var sXml=sheetObj.GetSaveData("ESM_PRI_3514GS.do", sParam);
                    sheetObj.LoadSaveData(sXml);
                    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
                        return false;
                    }
                    doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);                   
                    break;
                case MODIFY03: // Approve
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    if (!ComShowCodeConfirm("PRI06002")) {
                        return false;
                    }
                    ComOpenWait(true);                  
                    //sheetObj.CellValue2(sheetObj.SelectRow, "trf_inlnd_sts_cd") = "A";
                    var sParam="f_cmd=" + MODIFY03;
                    var sParamSheet=sheetObj.GetSaveString(true);
                    if (sParamSheet != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                    }
                    var sXml=sheetObj.GetSaveData("ESM_PRI_3514GS.do", sParam);
                    sheetObj.LoadSaveData(sXml);
                    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
                        return false;
                    }
                    doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);                   
                    break;              
                case REMOVE02: // Cancel
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    if (!ComShowCodeConfirm("PRI00015")) {
                        return false;
                    }
                    ComOpenWait(true);      
                    var stsCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_sts_cd");
                    /*
                    if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_sts_cd") == "Q") {
                        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_sts_cd","I",0);
                    } else if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_sts_cd") == "A") {
                        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_sts_cd","Q",0);
                    } else if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_sts_cd") == "I") { //Amend cancel
                        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_sts_cd","X",0);
                    }
                    */
                    var sParam="f_cmd=" + REMOVE02;
                    var sParamSheet=sheetObj.GetSaveString(true);
                    if (sParamSheet != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                    }
                    var sXml=sheetObj.GetSaveData("ESM_PRI_3514GS.do", sParam);
                    sheetObj.LoadSaveData(sXml);
                    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
                        return false;
                    }
                    if(stsCd == "A") {
                        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
                    } else {
                        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
                    }
                    break;  
                case IBDOWNEXCEL:
                    if(!validateForm(sheetObj,formObj,sAction)) {
                        return false;
                    }
                    ComOpenWait(true);
                    formObj.f_cmd.value=SEARCH03;
                    var sXml=sheetObj.GetSearchData("ESM_PRI_3514GS.do", FormQueryString(formObj));
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    //sheetObj.Down2Excel({ DownCols:"2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25", HiddenColumn:-1, Merge:true, /*AutoSizeColumn : 1, ExcelFontSize : 10, ExcelRowHeight : "18", Merge: 1, SheetDesign: 1,*/ KeyFieldMark:false});
                    //sheetObj.Down2Excel(-1);
                    break;
                case IBLOADEXCEL:
                    if(!validateForm(sheetObj,formObj,sAction)) {
                        return false;
                    }
                    var sheetM=sheetObjects[0];    
                    formObj.trf_cd_nm.value = sheetObj.GetCellText(0, 1);
                    var sUrl="/opuscntr/ESM_PRI_3522.do?";
                    sUrl += "trf_pfx_cd=" + sheetM.GetCellValue(sheetM.HeaderRows(), "trf_pfx_cd");
                    sUrl += "&trf_no=" + sheetM.GetCellValue(sheetM.HeaderRows(), "trf_no");
                    sUrl += "&trf_inlnd_seq=" + sheetM.GetCellValue(sheetM.HeaderRows(), "trf_inlnd_seq");
                    sUrl += "&amdt_seq=" + sheetM.GetCellValue(sheetM.HeaderRows(), "amdt_seq");
                    sUrl += "&upd_dt=" + sheetM.GetCellValue(sheetM.HeaderRows(), "upd_dt");
                    sUrl += "&etc2=" + MAX_UPD_DT;
                    ComOpenPopup(sUrl, 1000, 600, "callbackLoadExcel", "0,1", true);
                    
                    break;
                case MODIFY04: // Publish
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    var sUrl="ESM_PRI_3517.do";
                    ComOpenPopup(sUrl, 600, 290, "publish_returnVal", "0,1", true);
                      
                    break;      
                case MODIFY05: // adding file
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    var Row=sheetObj.DataInsert(-1);
                    sheetObj.SetCellValue(Row, "trf_pfx_cd",sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "trf_pfx_cd"),0);
                    sheetObj.SetCellValue(Row, "trf_no",sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "trf_no"),0);
                    sheetObj.SetCellValue(Row, "trf_inlnd_seq",sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "trf_inlnd_seq"),0);
                    sheetObj.SetCellValue(Row, "amdt_seq",sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "amdt_seq"),0);
                    sheetObj.SelectCell(Row, "atch_file_nm",true);
                    break;
                case REMOVE03: // deleting file
                    
                    var sheetMain=sheetObjects[0];
                    if(sheetMain.GetCellValue(sheetMain.HeaderRows(),"atch_file_id") == "") {
                        sheetObj.RemoveAll();
                        toggleButtons();
                    } else { 
                    	//sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ibflag", "D", true);
                    	//2015.03.06 ADD DELETE LOGIC
                    	if(sheetObj.RowCount() > 0) {
                    		for(var i = 1; i <= sheetObj.RowCount(); i++) {
                    			sheetObj.SetCellValue(i, "ibflag", "D", true);
                    		}
                    		var fileList = upload1.GetList();
                            if(fileList.length > 0) {
                            	for(var i = 0; i < fileList.length; i++) {
                            		upload1.RemoveOneFile(fileList[i].GetSerialNo());	
                        		}
                            }
                    		
                    	}
                    	//2015.03.06 chage location(because validation check above delete flag)
                    	if (!validateForm(sheetObj,document.form,sAction)) {
                            return false;
                        }
                    	
                        //sheetObj.SetRowHidden(sheetObj.GetSelectRow(), true);
//                        sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"D");
//                        if(sheetObj.GetRowStatus(sheetObj.GetSelectRow())== "D") {
                            var returnVal=doActionIBSheet(sheetObj, document.form, MODIFY06);
                            if(!returnVal) {
                            	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ibflag", "R", true);
                                sheetObj.SetRowHidden(sheetObj.GetSelectRow(), false);
//                                sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"R");
                            }
//                        }
                    }
                    break;
                case MODIFY06: // FILE save
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }                   
                    if (!ComPriConfirmSave()) {
                        return false;
                    }
                    formObj.f_cmd.value=MULTI02;                    

                    var sParam="f_cmd=" + MULTI02;
                    //3.2.making QueryString from IBSheet
                    var sParamSheet=sheetObj.GetSaveString();
                    if (sParamSheet != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                    }
                    ComOpenWait(true);
                    //4. //Transfering request to server and getting response
                    
                    var fileList = upload1.GetList();
                    if(fileList.length > 0) {
                        upload1.SaveStatus();
                    } else {
                        var sXml = sheetObj.GetSearchData("ESM_PRI_3514GS.do", sParam);
                        sheetObj.LoadSaveData(sXml , true);
                        //sheetObj.LoadSeachData(sXml , {Sync:1});
                    }
                       
                    return true;
                    break;  
                case IBINSERT: // Row Add
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    var sheetMain=sheetObjects[0];
                    var trf_pfx_cd=sheetMain.GetCellValue(sheetMain.HeaderRows(), "trf_pfx_cd");
                    var trf_no=sheetMain.GetCellValue(sheetMain.HeaderRows(), "trf_no");
                    var trf_inlnd_seq=sheetMain.GetCellValue(sheetMain.HeaderRows(), "trf_inlnd_seq");
                    var amdt_seq=sheetMain.GetCellValue(sheetMain.HeaderRows(), "amdt_seq");
                    var max_seq=parseInt(ComPriGetMaxExceptDelete(sheetObj, "trf_inlnd_rt_seq"));
                    var idx=sheetObj.DataInsert();
                    sheetObj.SetCellValue(idx, "trf_pfx_cd",trf_pfx_cd,0);
                    sheetObj.SetCellValue(idx, "trf_no",trf_no,0);
                    sheetObj.SetCellValue(idx, "trf_inlnd_seq",trf_inlnd_seq,0);
                    sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
                    sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
                    sheetObj.SetCellValue(idx, "trf_inlnd_rt_seq",(max_seq > LOC_MAX_SEQ)? max_seq + 1 : LOC_MAX_SEQ + 1,0);
                    sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
                    sheetObj.SelectCell(idx, "inlnd_rt_bse_loc_cd");
                    toggleButtons();                    
                    if(sheetObj.GetCellValue(idx, "amdt_seq") > 0) {
                        sheetObj.SetRowFontColor(idx,"#FF0000");
                    }
                    break;
                case IBDELETE: // Delete
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    var amdtSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq");
                    var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
                    if(chkArr.length == 0){
                        sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
                    }   
                    chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
                    var sRow=0;
                    for(var j=0;j < chkArr.length;j++){                     
                        if(sheetObj.GetCellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")== amdtSeq
                                && sheetObj.GetCellValue(Number(chkArr[j])+sRow, "src_info_cd") == "AM"){
                            ComShowCodeMessage("PRI00313");
                            sheetObj.SelectCell(Number(chkArr[j])+sRow, "seq");
                            return false;
                        }
                    }
                    for(var j=0;j < chkArr.length;j++){
                        if(sheetObj.GetCellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")!= amdtSeq){
                            setSheetAmendRow(sheetObj,formObj,Number(chkArr[j])+sRow, "AD");                            
                            sRow++;                             
                        }
                        if(sheetObj.GetCellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")== amdtSeq
                                && sheetObj.GetCellValue(Number(chkArr[j])+sRow, "src_info_cd") == "AM"){
                            sheetObj.SetCellValue(Number(chkArr[j])+sRow, "src_info_cd","AD",0);
                            sheetObj.SetCellValue(Number(chkArr[j])+sRow, "chk",0,0);
                        } else if (sheetObj.GetCellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")== amdtSeq
                                && sheetObj.GetCellValue(Number(chkArr[j])+sRow, "src_info_cd") == "AD"){
                            sheetObj.SetCellValue(Number(chkArr[j])+sRow, "chk",0,0);
                        }
                    }
                    deleteRowCheck(sheetObj, "chk");
                    toggleButtons();
                    break;
                case MODIFY07: // Row Amend
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }
                    var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
                    if(chkArr.length > 0){
                        if(chkArr.length > 1){                  
                            ComShowCodeMessage("PRI00310");
                        }else{          
                            setSheetAmendRow(sheetObj,formObj,chkArr[0], "AM");
                        }
                    }else{ 
                        setSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(), "AM");
                    }
                    sheetObj.SelectCell(sheetObj.GetSelectRow(), "inlnd_rt_bse_loc_cd");
                    toggleButtons();
                    break;  
                case MODIFY08: // Amend Cancel
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }   
                    var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
                    if(chkArr.length > 0){
                        if(chkArr.length > 1){                  
                            ComShowCodeMessage("PRI00310");
                        }else{
                            setSheetAmendRow(sheetObj,formObj,chkArr[0], "");
                        }
                    }else{ 
                        setSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(), "");
                    }
                    toggleButtons();
                    break;
                case IBSEARCH_ASYNC05:
                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }                   
                    //ComOpenWait(true);
                    var Row=sheetObj.FindText("inlnd_rt_bse_loc_nm", formObj.search_row.value, 0, 0, false);
                    if(Row > -1) {
                        sheetObj.SelectCell(Row, 2);
                    } else {
                        ComShowCodeMessage("PRI00018");
                    }
                    break;                  
            }
        } catch(e){
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
             ComOpenWait(false);
        }
    }
    
    function callbackAmend(rtnVal) {
    	 if (rtnVal) {
    		 var sheetObj=sheetObjects[0];
              doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01);
    	 }
    }
    
    function publish_returnVal(rtnVal) {
    	 if (rtnVal) {
    		 var sheetObj=sheetObjects[0];
    		 doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC02);
         }                
    }
    
    function callbackLoadExcel(rtnVal) {
    	if (rtnVal != null){
    		 var sheetObj=sheetObjects[0];
            doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC04);
        }
    }

    /**
     * Calling function in case of OnClick event <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
//	function sheet2_OnPopupClick(sheetObj,Row,Col){
// 		var fileName=sheetObj.OpenFileDialog("Open File");
//		if(fileName.indexOf("\\") !=-1) {
//			sheetObj.SetCellValue(Row, "file_path_url",fileName,0);
//			sheetObj.SetCellValue(Row, Col,fileName.substr(fileName.lastIndexOf("\\")+1),0);
//			sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(), "atch_file_nm",fileName,0);
//		} else {	
//			sheetObj.RemoveAll();
//		}
//		toggleButtons();
//	}

    
    /**
     * Downloading a file<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row         sheetObj's Selected Row
     * @param {ibsheet} Col         sheetObj's Selected Col
     * @param {String}  Value     file name
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function sheet2_OnClick(sheetObj,Row,Col,Value){
        if(sheetObj.ColSaveName(Col)!="file_dn" || sheetObj.GetRowStatus(Row)=="I") return;
        if(sheetObj.GetCellText(Row, "atch_file_id") == "") return;
        location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "atch_file_id");
        return;
    }
    /**
     * Downloading a file<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row         sheetObj's Selected Row
     * @param {ibsheet} Col         sheetObj's Selected Col
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function sheet2_OnDblClick(sheetObj,Row,Col){
        if (sheetObj.ColSaveName(Col)!= "atch_file_nm" || sheetObj.GetRowStatus(Row)=="I") return;
        if(sheetObj.GetCellText(Row, "atch_file_id") == "") return;
        location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "atch_file_id");
        return;
    }
    

    
    /**
     * Calling function in case of OnSaveEnd event <br>
     * showing message in case of succesful saving<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2010.11.01
     */         
    function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {      
        if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
//            toggleButtons();
			var sheetObject1=sheetObjects[0];
	    	var formObject=document.form;
	    	doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
        }
    }
    function sheet3_OnSearchEnd(sheetObj, ErrMsg)  {      
    	for (var i=sheetObj.HeaderRows(); i<=sheetObj.RowCount()+sheetObj.HeaderRows()-1; i++){
    		//console.log(sheetObj.GetCellValue(i, "row_properties"))
    		//console.log(sheetObj.GetCellValue(i, "row_properties").indexOf("FontStrike"));
    		if (sheetObj.GetCellValue(i, "row_properties").indexOf("FontStrike") > 0) {
    			sheetObj.SetCellFont("FontStrike", i, 0, i, sheetObj.LastCol(),1);
    		}
    	}
    }
    
    
    function sheet4_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {  
    	sheetObj.Down2Excel({ DownCols:"2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25", HiddenColumn:-1, Merge:true, /*AutoSizeColumn : 1, ExcelFontSize : 10, ExcelRowHeight : "18", Merge: 1, SheetDesign: 1,*/ KeyFieldMark:false});
    }
    
    function SheetObject(sheet, row, col, rtnVal){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 		this.rtnVal = rtnVal;
 	}
 	var _tmp_sheetObject;
    
     /**
     * Calling funciton in case of OnClick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index
     * @param {str} Value Mandatory 
     * @return N/A
     * @author 
     * @version 2010.11.05
     */
    function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
        var colname=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colname)
        {               
            case "inlnd_rt_bse_loc_cd":
                var sUrl="/opuscntr/ESM_PRI_4026.do?"
                    //sUrl += "f_cmd="+ SEARCH01;
                    sUrl += "location_cmd=L";
                ComOpenPopup(sUrl, 700, 310, 'callback4026','1,0', true);
                _tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
                break;
            case "inlnd_rt_via_loc_cd": 
                var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
                    //sUrl += "&f_cmd="+ SEARCH01;
                    sUrl += "&location_cmd=L";
                    ComOpenPopup(sUrl, 700, 310, 'callback4026_2','1,0', true);
                _tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
                break;          
        }
    }
    
    function callback4026(rtnVal){
    	if (rtnVal != null){
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "inlnd_rt_bse_loc_cd",rtnVal.cd,0);
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "inlnd_rt_bse_loc_nm",rtnVal.nm,0);
//    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "inlnd_rt_bse_loc_zip_cd",rtnVal.zip_cd,0);
        }
 	}
    
    function callback4026_2(rtnVal){
    	if (rtnVal != null){    		
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "inlnd_rt_via_loc_cd",rtnVal.cd,0);
        }
 	}
    
    /**
     * Calling Function in case of OnChange event  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2010.11.05
     */  
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colName)
        {
            case "inlnd_rt_bse_loc_cd":
                if (Value.length > 1){
                    var sParam="f_cmd=" + SEARCH01;
                        sParam += "&loc_cd=" + Value;
                        var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", sParam);
                    var arrData=ComPriXml2Array(sXml, "loc_cd|loc_nm|zip_cd");
                    if (arrData != null && arrData.length > 0){                     
                        sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_cd",arrData[0][0],0);
                        sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_nm",arrData[0][1],0);
                        sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_zip_cd",arrData[0][2],0);
                    }else{
                        sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_cd","",0);
                        sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_nm","",0);
                        sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_zip_cd","",0);
                        sheetObj.SelectCell(Row, "inlnd_rt_bse_loc_cd");
                    }                   
                }else{   
                    sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_cd","",0);
                    sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_nm","",0);
                    sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_zip_cd","",0);
                    sheetObj.SelectCell(Row, "inlnd_rt_bse_loc_cd");
                }
                break;
            case "inlnd_rt_via_loc_cd":             
                if (Value.length > 1){
                    var sParam="f_cmd=" + SEARCH01;
                        sParam += "&loc_cd=" + Value;
                        var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", sParam);
                    var arrData=ComPriXml2Array(sXml, "loc_cd|loc_nm|zip_cd");
                    if (arrData != null && arrData.length > 0){
                        sheetObj.SetCellValue(Row, "inlnd_rt_via_loc_cd",arrData[0][0],0);
                    }else{
                        sheetObj.SetCellValue(Row, "inlnd_rt_via_loc_cd","",0);
                        sheetObj.SelectCell(Row, "inlnd_rt_via_loc_cd");
                    }                   
                }else{   
                    sheetObj.SetCellValue(Row, "inlnd_rt_via_loc_cd","",0);
                    sheetObj.SelectCell(Row, "inlnd_rt_via_loc_cd");
                }
                break;  
        }
    }
    /**
     * Function to change Sheet Cell Editable  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {string} flag Mandatory Flag value
     * @return N/A
     * @author 
     * @version 2010.10.13
     */ 
    function inputSheetEditable(sheetObj, Row, flag) {
         sheetObj.SetCellEditable(Row,"inlnd_rt_bse_loc_cd",flag);
         sheetObj.SetCellEditable(Row,"inlnd_rt_bse_loc_zip_cd",flag);
         sheetObj.SetCellEditable(Row,"inlnd_rt_term_cd",flag);
         sheetObj.SetCellEditable(Row,"inlnd_rt_via_loc_cd",flag);
         sheetObj.SetCellEditable(Row,"prc_inlnd_rt_trsp_mod_cd",flag);
         sheetObj.SetCellEditable(Row,"inlnd_rt_lmt_wgt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_rt_min_lmt_wgt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_rt_lmt_wgt_ut_cd",flag);
         sheetObj.SetCellEditable(Row,"prc_cgo_tp_cd",flag);
         sheetObj.SetCellEditable(Row,"curr_cd",flag);
         sheetObj.SetCellEditable(Row,"inlnd_bx_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_20ft_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_40ft_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_40ft_hc_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_45ft_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_one_wy_bx_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_one_wy_20ft_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_one_wy_40ft_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_one_wy_40ft_hc_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_one_wy_45ft_rt_amt",flag);
         sheetObj.SetCellEditable(Row,"inlnd_rt_rmk",flag);
    }
    /**
     * Calling function in case of OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, previous Selected Cell's Row Index
     * @param {int} OldCol Mandatory, previous Selected Cell's Column Index
     * @param {int} NewRow Mandatory, current Selected Cell's Row Index
     * @param {int} NewCol Mandatory, current Selected Cell's Column Index
     * @return N/A
     * @author 
     * @version 2011.11.08
     */         
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            toggleButtons();
        }
    }

    /**
     * Controling buttons by authority whenever selecting a row <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML tag Object
     * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
     * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
     * @return N/A
     * @author 
     * @version 2010.10.13
     */ 
    function setAuthButtonControl(sheetObj, NewRow, NewCol)  {
        var formObj=document.form;
        var ofcCd=formObj.strofc_cd.value;
        //Amend Cancel
        if(ofcCd != sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")) {
            ComBtnDisable("btn_amendcancel");
        }
        //Request 
        if(ofcCd != sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")) {
            ComBtnDisable("btn_request");
        }
        //Approve 
        if(ofcCd != sheetObj.GetCellValue(NewRow, "apro_ofc_cd")) {
            ComBtnDisable("btn_approve");
        }
        //Cancel
        if(ofcCd != sheetObj.GetCellValue(NewRow, "rqst_ofc_cd") && ofcCd != sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")) {
            ComBtnDisable("btn_cancel");
        }   
    }
     /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process flag constant variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : invalid
     * @author 
     * @version 2010.10.13
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBCREATE: // New
            break;
        case IBSEARCH: 
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }           
            break;
        case IBSEARCH_ASYNC01:
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }           
            break;
        case IBSEARCH_ASYNC03:
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }           
            break;
        case IBSEARCH_ASYNC04:
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }           
            break;
        case IBSAVE:    
            if (comboObjects[0].GetSelectCode()== "") {
                return false;
            }
            if (sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "I" && comboObjects[1].GetSelectText()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            } else if (sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "U" && comboObjects[1].GetSelectText()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }
            if (!sheetObjects[0].IsDataModified()&& !sheetObjects[2].IsDataModified()) {
                ComShowCodeMessage("PRI00301");
                return false;
            }
            /*          
            if ((sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "")
                    || (sheetObjects[2].IsDataModified()&& sheetObjects[2].GetSaveString() == "")){
                return false;
            }
            */
            if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt") == "") {
                ComShowCodeMessage("PRI00316", "Effective Date");
                formObj.eff_dt.focus();
                return false;
            }
            if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "apro_ofc_cd") == "") {
                ComShowCodeMessage("PRI00316", "Approval Office");
                apro_ofc_cd.Focus();
                return false;
            }
            //checking date
            if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt") != "") {
                if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt") >= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt")) {
                    ComShowCodeMessage("PRI00345");
                    formObj.exp_dt.focus();
                    return false;
                }
            }
            /*
            if (sheetObjects[2].IsDataModified()) {
                var dupRow=ComPriAmendDupRows(sheetObjects[2], "inlnd_rt_bse_loc_cd|inlnd_rt_bse_loc_zip_cd|inlnd_rt_term_cd"
                        +"|inlnd_rt_via_loc_cd|prc_inlnd_rt_trsp_mod_cd|inlnd_rt_min_lmt_wgt|inlnd_rt_lmt_wgt|inlnd_rt_lmt_wgt_ut_cd"
                        +"|prc_cgo_tp_cd|amdt_seq", formObj.amdt_seq.value);
                if (dupRow >= 0) {
                    sheetObjects[2].SetCellValue(dupRow, "chk","1",0);
                    sheetObjects[2].SelectCell(dupRow, "seq");
                    ComShowCodeMessage("PRI00302");
                    return false;
                }
            }
           */
            var sheetLoc=sheetObjects[2];
            //parameter->I|U, result->1;3;4;5;6;
            var sRow=sheetLoc.FindStatusRow("I|U");
            //creating a result to array
            var arrRow=sRow.split(";");            
            for (var idx=0; idx<arrRow.length; idx++) { 
                if (sheetLoc.GetCellValue(arrRow[idx], "inlnd_rt_bse_loc_cd") == "") {
                    ComShowCodeMessage("PRI00316", "Loc. Code");
                    sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_bse_loc_cd");
                    return false;
                }
                /*
                if (sheetLoc.GetCellValue(arrRow[idx], "inlnd_rt_via_loc_cd") == "") {
                    ComShowCodeMessage("PRI00316", "Via");
                    sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_via_loc_cd");
                    return false;
                }
                */
                if (sheetLoc.GetCellValue(arrRow[idx], "curr_cd") == "") {
                    ComShowCodeMessage("PRI00316", "Currency");
                    sheetLoc.SelectCell(arrRow[idx], "curr_cd");
                    return false;
                }
                /*
                if(sheetLoc.GetCellValue(arrRow[idx], "inlnd_bx_rt_amt") == "" && sheetLoc.GetCellValue(arrRow[idx], "inlnd_20ft_rt_amt") == ""
                && sheetLoc.GetCellValue(arrRow[idx], "inlnd_40ft_rt_amt") == "" && sheetLoc.GetCellValue(arrRow[idx], "inlnd_40ft_hc_rt_amt") == ""
                && sheetLoc.GetCellValue(arrRow[idx], "inlnd_45ft_rt_amt") == "" && sheetLoc.GetCellValue(arrRow[idx], "inlnd_one_wy_bx_rt_amt") == ""
                && sheetLoc.GetCellValue(arrRow[idx], "inlnd_one_wy_20ft_rt_amt") == "" && sheetLoc.GetCellValue(arrRow[idx], "inlnd_one_wy_40ft_rt_amt") == ""
                && sheetLoc.GetCellValue(arrRow[idx], "inlnd_one_wy_40ft_hc_rt_amt") == "" && sheetLoc.GetCellValue(arrRow[idx], "inlnd_one_wy_45ft_rt_amt") == "") {
                    ComShowCodeMessage("PRI00308", "input","rate");
                    sheetLoc.SelectCell(arrRow[idx], "inlnd_one_wy_bx_rt_amt");
                    return false;
                }
                */
                var tMin=sheetLoc.GetCellValue(arrRow[idx], "inlnd_rt_min_lmt_wgt");
                var tMax=sheetLoc.GetCellValue(arrRow[idx], "inlnd_rt_lmt_wgt");
                var tUnit=sheetLoc.GetCellValue(arrRow[idx], "inlnd_rt_lmt_wgt_ut_cd");
                // Need to input unit when inputting weight 
                if((tMax != "" || tMin != "") && tUnit == ""){
                    ComShowCodeMessage("PRI00308", "input","weight unit");
                    sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_lmt_wgt_ut_cd");
                    return false;
                }
                //Need to input weight when inputting unit
                if(tUnit != "" && (tMax == "" && tMin == "")){
                    ComShowCodeMessage("PRI00308", "input","weight");
                    sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_lmt_wgt");
                    return false;
                }
                //  min > max impossible
                if(tMax != "" && tMin != "" && tUnit != ""){
                    if(Number(tMin) > Number(tMax)) {
                        ComShowCodeMessage("PRI08008");
                        sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_lmt_wgt");
                        return false;
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////
            // update date 
            if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;
        case MODIFY01: // Amend
            if (comboObjects[0].GetSelectCode()== "") {
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }   
            break;
        case MODIFY02: // Request
            if (comboObjects[0].GetSelectCode()== "") {
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }
            if(formObj.exp_dt.value != "") {
                if(ComGetUnMaskedValue(formObj.eff_dt, "ymd") > ComGetUnMaskedValue(formObj.exp_dt, "ymd")) {
                    ComShowCodeMessage("PRI00346");
                    return false;
                }
            }
            /*
            if (sheetObjects[0].IsDataModified()) {
                ComShowCodeMessage("PRI01057");
                return false;
            }
            */              
            /////////////////////////////////////////////////////////////////////
            // update date 
            if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
                return false;
            }
            /////////////////////////////////////////////////////////////////////            
            break;
        case MODIFY03: // Approve 
            if (comboObjects[0].GetSelectCode()== "") {
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            // update date 
            if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;
        case IBINSERT: // Row Add
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            } 
            break;
        case IBDELETE: // Row Delete
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            if(getValidRowCount(sheetObj) < 1) {
                return false;
            }
            //selected rows < 100
            if(sheetObj.CheckedRows("chk") > 100) {
                ComShowCodeMessage("PRI00333","Over 100 rows");
                return false;
            }
            break;
        case REMOVE01: // Remove
            if (comboObjects[0].GetSelectCode()== "") {
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            // update date 
            if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;
        case REMOVE02: // Cancel
            if (comboObjects[0].GetSelectCode()== "") {
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            // update date 
            if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;
        case IBDOWNEXCEL: // Cancel
            if (comboObjects[0].GetSelectCode()== "") {
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }
            break;
        case IBLOADEXCEL:
            if (comboObjects[0].GetSelectCode()== "") {
                return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }   
            break;
        case MODIFY05: // adding a file
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00308","select", "Tariff Code");
                tariff_cd.Focus();
                return false;
            }
            if (getValidRowCount(sheetObj) == 1) {
                return false;
            }
            break;
        case REMOVE03: // deleting a file
        	//if (getValidRowCount(sheetObj) == 0) {
        	//2015.03.06 modify ( getValidRowCount = rowcount - deleterowcount ==> wrong logic)
        	if (sheetObj.RowCount("D") == 0) {
                return false;
            }
            break;
        case MODIFY06: // Upload Save
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage("PRI00316", "Inland Rates Name");
                inlnd_cd.Focus();
                return false;
            }
            if (!sheetObj.IsDataModified()) {
                ComShowCodeMessage("PRI00301");
                return false;
            }
            if(sheetObj.GetCellValue(sheetObj.HeaderRows(), "ibflag") != "D" && sheetObj.GetCellValue(sheetObj.HeaderRows(), "atch_file_id") != "" ) {
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            // update date
            if( checkChangingUpdateDate(sheetObjects[0], "CHECK1") ){
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;
        }
        return true;
    }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
        var formObj=document.form;
        if(sheetObj.RowCount()> 0) {
            formObj.amdt_seq.value=sheetObj.GetCellValue(1, "amdt_seq");
            formObj.trf_inlnd_sts_nm.value=sheetObj.GetCellValue(1, "trf_inlnd_sts_nm");
            formObj.cre_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "cre_dt"), "ymd");
            formObj.eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "eff_dt"), "ymd");
            formObj.exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "exp_dt"), "ymd");
            formObj.pub_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1, "pub_dt"), "ymd");
            formObj.rqst_ofc_cd.value=sheetObj.GetCellValue(1, "rqst_ofc_cd");
            formObj.cre_usr_id.value=sheetObj.GetCellValue(1, "cre_usr_id");
            comboObjects[3].SetSelectCode(sheetObj.GetCellValue(1, "apro_ofc_cd"),false);
            comboObjects[2].SetSelectCode(sheetObj.GetCellValue(1, "trf_inlnd_amdt_tp_cd"),false);
            initLocationSheetColumn(); 
        }
    }   
    /**
     * Initializing Sheet's title<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @return N/A
     * @author 
     * @version 2010.11.13
     */
    function initLocationSheetColumn() {
        var formObj=document.form;
        var sheetM=sheetObjects[0];
        var sheetD=sheetObjects[2];
        var sheetExcel=sheetObjects[3];
        var colName="";
        if(comboObjects[1].GetSelectCode() != "") {
            colName=comboObjects[0].GetSelectCode()+ " " + formObj.trf_nm.value + " - " + sheetM.GetCellValue(1, "trf_inlnd_nm");
        }
        sheetD.SetCellText(0, 1 ,colName);
        sheetD.SetCellText(0, 2 ,colName);
        sheetD.SetCellText(0, 3 ,colName);
        sheetD.SetCellText(0, 4 ,colName);
        sheetD.SetCellText(0, 5 ,colName);
        sheetD.SetCellText(0, 6 ,colName);
        sheetD.SetCellText(0, 7 ,colName);
        sheetD.SetCellText(0, 8 ,colName);
        sheetD.SetCellText(0, 9 ,colName);
        sheetD.SetCellText(0, 10 ,colName);
        sheetD.SetCellText(0, 11 ,colName);
        sheetD.SetCellText(0, 13 ,colName);
        sheetD.SetCellText(0, 12 ,colName); // 마지막 컬럼값이 필수 이기 때문에 마지막 row merge한 값에도 필수 표시가 붙는다. 이를 방지하기 위해 순서변경
        
        sheetExcel.SetCellText(0, 1 ,colName);
        sheetExcel.SetCellText(0, 2 ,colName);
        sheetExcel.SetCellText(0, 3 ,colName);
        sheetExcel.SetCellText(0, 4 ,colName);
        sheetExcel.SetCellText(0, 5 ,colName);
        sheetExcel.SetCellText(0, 6 ,colName);
        sheetExcel.SetCellText(0, 7 ,colName);
        sheetExcel.SetCellText(0, 8 ,colName);
        sheetExcel.SetCellText(0, 9 ,colName);
        sheetExcel.SetCellText(0, 10 ,colName);
        sheetExcel.SetCellText(0, 11 ,colName);
        sheetExcel.SetCellText(0, 12 ,colName);
        sheetExcel.SetCellText(0, 13 ,colName);
    }
    /**
     * Modifying form object enable/disable<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2010.11.13
     */
    function controlFormEnable(sheetObj) {
        var formObj=document.form;
        var comboObj=comboObjects[3];
        var comboObj2=comboObjects[2];
        var stsCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_inlnd_sts_cd");
        var amdtSeq=sheetObj.GetCellValue(sheetObj.HeaderRows(), "amdt_seq");
        var ofcCd=formObj.ofc_cd.value;
        var rqstOfcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "rqst_ofc_cd");
        if(stsCd == "I" && ofcCd == rqstOfcCd) {
            if(amdtSeq > 0) {
                formObj.eff_dt.readOnly=true;
                formObj.eff_dt.className="input2";
            } else {
                formObj.eff_dt.readOnly=false;
                formObj.eff_dt.className="input1";
            }
            formObj.exp_dt.readOnly=false;
            formObj.exp_dt.className="input";
            comboObj.SetEnable(1);
            comboObj2.SetEnable(1);
        } else {            
            //ComEnableObject(formObj.eff_dt, false);
            //ComEnableObject(formObj.exp_dt, false);
            formObj.eff_dt.readOnly=true;
            formObj.exp_dt.readOnly=true;
            formObj.eff_dt.className="input2";
            formObj.exp_dt.className="input2";
            comboObj.SetEnable(0);
            comboObj2.SetEnable(0);
        }
    }
    /**
     * Makeing all buttons on screen Enable/Disable <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {string} mode Mandatory ,user mode or authority
     * @author 
     * @version 2010.10.13
     */
    function toggleButtons() {
        var formObj=document.form;
        var sheet1=sheetObjects[0];
        var sheet2=sheetObjects[1];
        var sheet3=sheetObjects[2];
        var combo2=comboObjects[1];
        var ofcCd=formObj.ofc_cd.value;
        var sts=sheet1.GetCellValue(sheet1.HeaderRows(), "trf_inlnd_sts_cd");
        var fileId=sheet1.GetCellValue(sheet1.HeaderRows(), "atch_file_id");
        var amdtNo=sheet1.GetCellValue(sheet1.HeaderRows(), "amdt_seq");
        var seq=sheet1.GetCellValue(sheet1.HeaderRows(), "trf_inlnd_seq");
        var rqstOfcCd=sheet1.GetCellValue(sheet1.HeaderRows(), "rqst_ofc_cd");
        var aproOfcCd=sheet1.GetCellValue(sheet1.HeaderRows(), "apro_ofc_cd");
        var amdtSeq=sheet3.GetCellValue(sheet3.GetSelectRow(), "amdt_seq");
        var n1stSeq=sheet3.GetCellValue(sheet3.GetSelectRow(), "n1st_cmnc_amdt_seq");
        var srcInfoCd=sheet3.GetCellValue(sheet3.GetSelectRow(), "src_info_cd");
        try {
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_new");
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_amend");
            ComBtnDisable("btn_delete");
            ComBtnDisable("btn_request");
            ComBtnDisable("btn_approve");
            ComBtnDisable("btn_publish");
            ComBtnDisable("btn_cancel");
            btnImgEnable("btns_calendar1", true);
            btnImgEnable("btns_calendar2", true);
            ComSetDisplay("btn_fileadd",true);
            ComBtnDisable("btn_fileadd");
            ComSetDisplay("btn_filedelete",false);
            ComBtnDisable("btn_filedelete");
            ComBtnDisable("btn_rowadd");
            ComBtnDisable("btn_rowdelete");
            ComBtnDisable("btn_rowamend");
            ComBtnDisable("btn_amendcancel");
            ComBtnDisable("btn_loadexcel");
            if(getValidRowCount(sheet2) > 0) {
                ComSetDisplay("btn_fileadd",false);
                ComSetDisplay("btn_filedelete",true);                       
            }                
            if(sheet3.RowCount()> 0) {
                ComBtnEnable("btn_downexcel");
            } else {
                ComBtnDisable("btn_downexcel");
            }
            //checkbox control
            if(Number(amdtNo) == 0) {
                formObj.search_view_yn.disabled=true;
            } else {
                formObj.search_view_yn.disabled=false;
            }
            switch (sts) {
            case "I":
                if(ofcCd == rqstOfcCd) {            
                    ComBtnEnable("btn_save");
                } else if(ofcCd != rqstOfcCd) {
                    btnImgEnable("btns_calendar1", false);
                    btnImgEnable("btns_calendar2", false);
                    return;
                }
                if(seq != "") {
                    if(amdtNo == 0) {
                        ComBtnEnable("btn_delete");
                    } else {
                        btnImgEnable("btns_calendar1", false);
                        ComBtnEnable("btn_cancel");
                    }
                    ComBtnEnable("btn_request");
                    if(fileId != "" || getValidRowCount(sheet2) > 0) {
                        ComBtnEnable("btn_filedelete");
                    } else {
                        ComBtnEnable("btn_fileadd");
                    }
                    if(!formObj.search_view_yn.checked && (amdtNo == 0 || amdtSeq == amdtNo)) {
                        ComBtnEnable("btn_rowadd");
                        ComBtnEnable("btn_rowdelete");
                    }
                    if(amdtSeq != n1stSeq && amdtNo == amdtSeq && (srcInfoCd == "AM" || srcInfoCd == "NW")) {
                        ComBtnEnable("btn_rowamend");
                    } else if(amdtSeq == n1stSeq && amdtNo == amdtSeq && srcInfoCd == "AM") {
                        ComBtnEnable("btn_amendcancel");
                        ComBtnDisable("btn_rowdelete");
                    } else if(amdtSeq == n1stSeq && amdtNo == amdtSeq && srcInfoCd == "AD") {
                        ComBtnEnable("btn_amendcancel");
                        ComBtnDisable("btn_rowdelete");
                    }
                    ComBtnEnable("btn_loadexcel");
                } else {
                    ComBtnEnable("btn_rowadd");
                    ComBtnEnable("btn_rowdelete");
                    ComBtnEnable("btn_fileadd");
                }
                break;
            case "Q":
                if(ofcCd == rqstOfcCd) {  
                    ComBtnEnable("btn_cancel"); 
                }
                if(sheet1.GetCellValue(sheet1.HeaderRows(), "apro_flg") == "Y") {
                    ComBtnEnable("btn_approve"); 
                    ComBtnEnable("btn_cancel");
                }
                /*              
                if(ofcCd == aproOfcCd) {            
                    ComBtnEnable("btn_approve"); 
                    ComBtnEnable("btn_cancel");
                }
                */
                btnImgEnable("btns_calendar1", false);
                btnImgEnable("btns_calendar2", false);
                break;              
            case "A":
                ComBtnEnable("btn_publish");
                if(sheet1.GetCellValue(sheet1.HeaderRows(), "apro_flg") == "Y") {
                    ComBtnEnable("btn_cancel");
                }
                /*
                if(ofcCd == aproOfcCd) {  
                    ComBtnEnable("btn_cancel"); 
                }   
                */
                btnImgEnable("btns_calendar1", false);
                btnImgEnable("btns_calendar2", false);
                break;
            case "F":
                ComBtnEnable("btn_amend");
                btnImgEnable("btns_calendar1", false);
                btnImgEnable("btns_calendar2", false);
                break;
            default:
                break;
            }
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * Calling Function in case of OnChange event  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @param {int} code Mandatory 
     * @param {int} text Mandatory 
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function tariff_cd_OnChange(comboObj, oldindex, oldtext , oldcode , newindex , text , code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
        if (arrText != null ) {             
            resetObjectValue("1");
            sheetObj.DataInsert();
            sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_sts_cd","I",0);
            sheetObj.SetCellValue(sheetObj.HeaderRows(),"amdt_seq","0",0);
            sheetObj.SetCellValue(sheetObj.HeaderRows(),"rqst_ofc_cd",formObj.ofc_cd.value,0);
            MAX_UPD_DT="";
            formObj.trf_nm.value=comboObj.GetText(code, 1);             
            var arr=code.split("-");                
            formObj.trf_pfx_cd.value=arr[0];
            formObj.trf_no.value=arr[1];
            sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_pfx_cd",arr[0],0);
            sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_no",arr[1],0);
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
            controlFormEnable(sheetObj);
            toggleButtons();
        }
    }
    /**
     * Calling function in case of OnClear event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function tariff_cd_OnClear(comboObj) {
        var formObj=document.form;
        formObj.trf_nm.value="";        
//        comboObj.SetSelectIndex(-1);
    }
    /**
     * Calling function in case of OnBlur event.<br>
     * <br><b>Example :</b>
     * <pre>
     *    tariff_cd_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2010.10.13
     */     
    function tariff_cd_OnBlur(comboObj) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
        if (code != null && code != "" && code != "-1") {
            var arr=code.split("-");                
            formObj.trf_pfx_cd.value=arr[0];
            formObj.trf_no.value=arr[1];
            sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_pfx_cd",arr[0],0);
            sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_no",arr[1],0);
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.trf_nm.value) {
                formObj.trf_nm.value=comboObj.GetText(code, 1);
                doActionIBSheet(sheetObj, document.form, IBSEARCH);                 
            }
        }
    }
    /**
     * Calling Function in case of OnChange event  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @param {int} code Mandatory
     * @param {int} text Mandatory
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function inlnd_cd_OnChange(comboObj, oldindex, oldtext , oldcode , newindex , text , code) {
    	
    	var formObj=document.form;
        var sheetObj=sheetObjects[0];
        
        var comboText=comboObj.GetSelectText();
        if (comboText == null || comboText == "" || comboText == undefined) {
			return false;
		}
        
        if(code != "") { //select
        	formObj.trf_inlnd_seq.value=comboObj.GetSelectCode();
        	sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_seq", comboObj.GetSelectCode(), 0);
        	doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01);  
        	
        } else { //manual
        	var nIdx = comboObj.FindItem(comboText, 0, true);
        	if( nIdx == -1) {
				comboObj.InsertItem(comboObj.GetItemCount(), comboText, "");
				comboObj.SetSelectIndex(comboObj.GetItemCount() - 1, false);
				
				resetObjectValue("2");
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_nm", text, 0);
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_sts_cd","I",0);
				
			} else {
				comboObj.SetSelectIndex(nIdx, false);
			}
        	controlFormEnable(sheetObj);
            toggleButtons();
        	
        }
        
    }
    /**
     * Calling Function in case of OnClear event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function inlnd_cd_OnClear(comboObj) {
        var formObj=document.form;      
        //comboObj.SetSelectIndex(-1);
    }
    /**
     * Calling Function in case of OnBlur event.<br>
     * <br><b>Example :</b>
     * <pre>
     *    inlnd_cd_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2010.10.13
     */     
//    function inlnd_cd_OnBlur(comboObj) {
//        var formObj=document.form;
//        var sheetObj=sheetObjects[0];
//        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
//        if (code != null && code != "" && code != "-1") {
//            formObj.trf_inlnd_seq.value=comboObj.GetSelectCode();
//            sheetObj.SetCellValue(sheetObj.HeaderRows(), "trf_inlnd_seq",comboObj.GetSelectCode(),0);
//        }
//        if(code == -1 && comboObj.GetSelectText()!= "") {
//            sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(), "trf_inlnd_nm",comboObj.GetSelectText(),0);
//        }
//    }
    /**
     * Calling Function in case of OnChange event  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @param {int} code Mandatory
     * @param {int} text Mandatory
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function apro_ofc_cd_OnChange(comboObj, oldindex , oldtext , oldcode , newindex , text , code) {
        var formObj=document.form;
        if (text != null) {             
            sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(), "apro_ofc_cd", code, 0);
        }
    }
    /**
     * Calling function in case of OnClear event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function apro_ofc_cd_OnClear(comboObj) {
        var formObj=document.form;      
        //comboObj.SetSelectIndex(-1);
    }
    /**
     * Calling function in case of OnBlur event.<br>
     * <br><b>Example :</b>
     * <pre>
     *    apro_ofc_cd_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2010.10.13
     */     
    function apro_ofc_cd_OnBlur(comboObj) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != null && code != "" && code != "-1") {
            //doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
    }
    /**
     * Calling Function in case of OnChange event  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @param {int} code Mandatory 
     * @param {int} text Mandatory 
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function trf_inlnd_amdt_tp_cd_OnChange(comboObj, oldindex, oldtext , oldcode,  newindex, text , code) {
    	var formObj=document.form;
        if (text != null) {             
            sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(), "trf_inlnd_amdt_tp_cd", code, 0);
        }
    }
    /**
     * Calling function in case of OnClear event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function trf_inlnd_amdt_tp_cd_OnClear(comboObj) {
        var formObj=document.form;      
        //comboObj.SetSelectIndex(-1);
    }
    /**
     * Calling function in case of OnBlur event.<br>
     * <br><b>Example :</b>
     * <pre>
     *    trf_inlnd_amdt_tp_cd_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2010.10.13
     */     
    function trf_inlnd_amdt_tp_cd_OnBlur(comboObj) {
        var formObj=document.form;
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != null && code != "" && code != -1) {
            //doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
    }
    /**
     * Setting values to attached file's sheet in case of existing attached file when retrieving main<br>
     * <br><b>Example :</b>
     * <pre>
     *    searchSheetAttachedFile(sXml);
     * </pre>
     * @param   {String} sXml Mandatory xml Sheet data
     * @return N/A
     * @author 
     * @version 2010.11.29
     */     
    function searchSheetAttachedFile(sXml) {
        var sheetMain=sheetObjects[0];
        var sheetFile=sheetObjects[1];
        //Attach file 
        if(sheetMain.GetCellValue(sheetMain.HeaderRows(), "atch_file_id") != "") {
            ComPriXml2Sheet(sheetFile, sXml);
            sheetFile.SetCellValue(1, "file_dn", 0, 0);
        } else {
            sheetFile.RemoveAll();
            upload1.ClearItems()
        }   
    }
   /**
    * Before amending,requesting after retrieving an agreement number on screen, checking if other user modify same data with same agreement no<BR>
    * <br><b>Example :</b>
    * <pre>
    *     (sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} sheetObj sheet object with update date,key
    * @param {String} checkTpCd it could be different from table to to be checked update date
    *  
    * @return boolean , true : existing modification, false: no modified data
    * @author 
    * @version 2010.12.20
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
        var returnValue=false;
        /////////////////////////////////////////////////////////////////////
       switch(checkTpCd){
       case "CHECK1" :
            var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
                + "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                + "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                + "&key3="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                + "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_seq")
                + "&upd_dt="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "upd_dt");
            var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
            if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
                sheetObj.LoadSearchData(cXml,{Sync:1} );
                ComOpenWait(false); //->waiting->End
                returnValue=true;
            }
            //Retrieving detail information in case of no modification of main
            if(!returnValue && sheetObjects[2].IsDataModified()) {
                checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND_RT&page_name=Inland Rates Location"
                    + "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                    + "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                    + "&key3="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                    + "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_seq")
                    + "&upd_dt="+ MAX_UPD_DT;
                var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
                if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
                    sheetObj.LoadSearchData(cXml,{Sync:1} );
                    ComOpenWait(false); //->waiting->End
                    returnValue=true;
                }
            }
            break;
       case "CHECK2" : //amend
           var amdt_seq=parseInt(sheetObj.GetCellValue(1, "amdt_seq"));
            //Checking whether next SEQ is already created
            amdt_seq++;
            var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
                + "&key1="+sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_pfx_cd")
                + "&key2="+sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_no")
                + "&key3="+amdt_seq
                + "&key4="+sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_inlnd_seq")
                + "&upd_dt="+sheetObj.GetCellValue(sheetObj.HeaderRows(), "upd_dt");
            var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
            if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
                sheetObj.LoadSearchData(cXml,{Sync:1} );
                ComOpenWait(false); //->waiting->End
                returnValue=true;
            }
            break;
       }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
    /**
     * Handling OnKeyPress event. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_onKeypress()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2010.10.13
     */
    function obj_onKeypress() {
       switch (ComGetEvent("dataformat")) {  
            case "engup":
                if (event.srcElement.name == "rule_no") {
                    ComKeyOnlyAlphabet('uppernum',"45");
                }    
                break;
           case "int":
               ComKeyOnlyNumber(ComGetEvent());
               break;
           case "float":
               ComKeyOnlyNumber(ComGetEvent(), ".");
               break;
           case "ymd":
            ComKeyOnlyNumber(ComGetEvent(), "-");
               break;
           default:
       }
   }  
   /**
    * Handling OnKeyDown event <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2010.10.13
    */  
    function obj_onKeydown(){
        var eleName=ComGetEvent("name");
        if (eleName == "search_row"){
            var keyValue=null;
            if(event == undefined || event == null) {
                keyValue=13;
            }else{
                keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            }
            if (keyValue == 13){
                doActionIBSheet(sheetObjects[2],document.form, IBSEARCH_ASYNC05);
            }
        }
    }
   /**
    * Handling onClick event <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param N/A
    * @return N/A
    * @author 
    * @version 2010.10.13
    */  
    function obj_onClick(){
        var eleName=ComGetEvent("name");
        if (eleName == "search_view_yn"){
            if(sheetObjects[2].IsDataModified()) {
                ComShowCodeMessage("PRI01057");
                return false;
            }
            doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC07);
        }
    }
  /**
   * Handling OnBeforeActivate event <br>
   * <br><b>Example :</b>
   * <pre>
   *     obj_activate()
   * </pre>
   * @param N/A
   * @return N/A
   * @author 
   * @version 2010.10.13
   */   
   function obj_onActivate() {
       var formObj=document.form;
       var srcName=ComGetEvent("name");
       ComClearSeparator (ComGetEvent());
   }
  /**
   * Handling Onbeforedeactivate event<br>
   * <br><b>Example :</b>
   * <pre>
   *     obj_onDeactivate()
   * </pre>
   * @param N/A
   * @return N/A
   * @author 
   * @version 2010.10.13
   */   
   function obj_onDeactivate() {
       var eleName=ComGetEvent("name");
       switch(eleName){          
           case "eff_dt":
               changeSheetData( sheetObjects[0], ComGetEvent() );
               ComChkObjValid(ComGetEvent());   
               break;
           case "exp_dt":
               changeSheetData( sheetObjects[0], ComGetEvent() );
               ComChkObjValid(ComGetEvent());   
               break;
           case "cre_dt":
               changeSheetData( sheetObjects[0], ComGetEvent() );
               ComChkObjValid(ComGetEvent());   
               break;
           case "pub_dt":
               changeSheetData( sheetObjects[0], ComGetEvent() );
               ComChkObjValid(ComGetEvent());   
               break;
       }
   }  
   /**
    * Applying modified value to hidden sheet when modifying Html Object's value<br>
    * Saving values by using hidden<br>
    * <br><b>Example :</b>
    * <pre>
    *   changeSheetData( sheetObj, colNm );
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {string} colNm Mandatory Html Object의 name
    * @return N/A
    * @author 
    * @version 2010.11.01
    */  
    function changeSheetData( sheetObj, object ){
    	
    	var formObj = document.form;
        var eleValue="";
        if(object.type=="text"){
            switch(object.name){
                case "eff_dt":
                    eleValue=ComGetUnMaskedValue(document.form.eff_dt.value,"ymd");                     
                    break;
                case "exp_dt":
                    eleValue=ComGetUnMaskedValue(document.form.exp_dt.value,"ymd");
                    break;
                default:
                    eleValue=object.value;    
                    break;                  
            }           
            sheetObj.SetCellValue(sheetObj.HeaderRows(), object.name, eleValue,0);
        }else{
            sheetObj.SetCellValue(sheetObj.HeaderRows(), object.name, object.value, 0);
        }
    }
    /**
     * Handling reset in case of Tariff Code OnChange event<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {string} flagInfo Mandatory 0:all reset, 1:all reset except tariff code
     * @return N/A
     * @author 
     * @version 2010.10.13
     */     
    function resetObjectValue(flagInfo) {
        var formObj=document.form;
        var sheetObj1=sheetObjects[0];
        var sheetObj2=sheetObjects[1];
        var sheetObj3=sheetObjects[2];
        formObj.amdt_seq.value="";
        formObj.trf_inlnd_sts_nm.value="";
        formObj.eff_dt.value="";
        formObj.exp_dt.value="";
        formObj.cre_dt.value="";
        formObj.pub_dt.value="";
        formObj.rqst_ofc_cd.value=formObj.ofc_cd.value;
        formObj.cre_usr_id.value=formObj.usr_id.value;
        formObj.search_row.value="";
//        if(flagInfo == "0") {
//            comboObjects[0].SetSelectIndex(-1);
//            formObj.trf_nm.value="";
//        }
        if(flagInfo == "1") {
        	comboObjects[1].SetSelectIndex(-1);
        }
        comboObjects[2].SetSelectIndex(-1);
        comboObjects[3].SetSelectIndex(-1);
        if(flagInfo == "1") {
        	sheetObjects[0].RemoveAll();
        } else if(flagInfo == "2") {
        	sheetObj1.SetCellValue(sheetObj1.HeaderRows(), "ibflag","I",0);
        	sheetObj1.SetCellValue(sheetObj1.HeaderRows(), "trf_inlnd_seq", "", 0);
        	sheetObj1.SetCellValue(sheetObj1.HeaderRows(), "amdt_seq", 0, 0);
        	sheetObj1.SetCellValue(sheetObj1.HeaderRows(), "eff_dt", "", 0);
        	sheetObj1.SetCellValue(sheetObj1.HeaderRows(), "exp_dt", "", 0);
			sheetObj1.SetCellValue(sheetObj1.HeaderRows(), "trf_inlnd_sts_nm", "", 0);
        }
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        initLocationSheetColumn();
    }
    /**
     * Getting Sheet Data as XML format<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {int} sheetObj sheetObject
     * @author 
     * @version 2010.10.13
     */
    function getSheetXml() { 
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var sXml="";
        var sCol="";
        var sValue="";
        sCol="trf_pfx_cd|trf_no|trf_inlnd_seq|amdt_seq";
        sValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
            + "|" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
            + "|" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_seq")
            + "|" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq");
        sXml=ComPriSheet2Xml(sheetObj, null, sCol, sValue);
        return sXml;
    }
    /**
     * Amending targeting row<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} Row Mandatory,  Selected Cell's Row Index
     * @param {string} srcInfo Selection, M : Update Amend, D : Delete Amend
     * @param {string} excelFlg Selection, excel upload: 'Y'
     * @return N/A
     * @author 
     * @version 2010.11.08
     */         
    function setSheetAmendRow(sheetObj, formObj, Row, srcInfo){
        var amdt_seq=formObj.amdt_seq.value;
        sheetObj.SetCellValue(Row,"chk",0);
        //Amend Cancel
        if(srcInfo==""){
            var bf_row=Row-1;
            //new row
            sheetObj.RowDelete(Row, false);
            //existing row
            sheetObj.SetRowEditable(bf_row,1);
            inputSheetEditable(sheetObj, bf_row, false);
            sheetObj.SetRowStatus(bf_row,"U");
            sheetObj.SelectCell(bf_row, "chk");
            sheetObj.SetCellValue(bf_row,"amdt_seq",amdt_seq,0);
            sheetObj.SetCellFont("FontStrike", bf_row, 1, bf_row, sheetObj.LastCol(),0);
        }else{
            if(sheetObj.GetCellValue(Row, "n1st_cmnc_amdt_seq")!= amdt_seq){
                // defining row to set based row of DataCopy/ Insert 
                sheetObj.SetSelectRow(Row);
                var idx=sheetObj.DataCopy();     // new row
                var idx2=idx-1;                  // old row
                // new row
                sheetObj.SetCellValue(idx, "src_info_cd",srcInfo,0);
                sheetObj.SetCellValue(idx,"n1st_cmnc_amdt_seq",amdt_seq,0);
                //sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol())= "#FF0000";
                sheetObj.SetRowFontColor(idx,"#FF0000");
                sheetObj.SetRowStatus(idx,"U");
                if(srcInfo=="AM") {
                    sheetObj.SetRowEditable(idx,1);
                    inputSheetEditable(sheetObj, idx, true);
                } else if(srcInfo=="AD") {
                    sheetObj.SetRowEditable(idx,1);
                    inputSheetEditable(sheetObj, idx, false);               
                } 
                //old row
                sheetObj.SetCellValue(idx2,"amdt_seq",amdt_seq-1,0);
                sheetObj.SetCellFont("FontStrike", idx2, 1, idx2, sheetObj.LastCol(),1);
                sheetObj.SetRowStatus(idx2,"R");// Making it not to save as old row's status change to "R"
                sheetObj.SetRowEditable(idx2,0);
            } 
            /*
            else {
                if(srcInfo=="AD"){                  
                    sheetObj.SetRowStatus(Row,"D");
                    sheetObj.SetRowHidden(Row,1);
                }
            }
            */
        }
    }
   /**
    * Activating/Deactivating image button<br>
    * <br><b>Example :</b>
    * <pre>
    *    btnImgEnable(obj, gb);
    * </pre>
    * @param  {form} obj Mandatory Html Object
    * @param  {bool} gb  Mandatory true : Activating false : deactivating
    * @return N/A
    * @author 
    * @version 2010.11.08
    */ 
    function btnImgEnable(obj, gb) {
//      if(obj.constructor == String){
//          obj=document.getElementsByName(obj)[0];        
//      }
//      var btnStyle=obj.style;
        if (gb){
            //obj.SetEnable(1);
            ComBtnEnable(obj);
            //btnStyle.cursor="hand";
            //btnStyle.filter="";
            //obj.disabled=false;
        } else {
            //obj.SetEnable(0);
            ComBtnDisable(obj);
            //btnStyle.cursor="auto";
            //btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
            //obj.disabled=true;
        }
    }
    /**
     * Return XML data from GetSearchXML function as array format <br>
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;);
     * var arrData = ComPriXml2Array(xmlStr, &quot;user_id|user_nm|status&quot;);
     *
     * </pre>
     *
     * @param {string} xmlStr Mandatory, XML String from IBSheet
     * @param {string} colList Mandatory, Column Name to be extracted from XML String. It's connected by "|" delimiter
     * @return array   [retrieved row count X column count] size's string array.
     * @author 
     * @version 2010.11.08
     */
    function ComPriXml2ComboItemList(xmlStr, cmbObj, codeCol, textCol, bClear) {
        if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
            return;
        }
        if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
            return;
        }
        try {
            if (bClear != false) {
                cmbObj.RemoveAll();
            }
            var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.loadXML(xmlStr);
            var xmlRoot=xmlDoc.documentElement;
            if (xmlRoot == null) {
                return;
            }
            var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);           
            if (dataNode == null || dataNode.attributes.length < 2) {
                return;
            }
            var col=dataNode.getAttribute("COLORDER");
            var colArr=col.split("|");
            var sep=dataNode.getAttribute("COLSEPARATOR");
            var total=dataNode.getAttribute("TOTAL");
            var dataChildNodes=dataNode.childNodes;
            if (dataChildNodes == null) {
                return;
            }
            var colListIdx=Array();
            var arrText=textCol.split("|");
            for (var i=0; i < colArr.length; i++) {
                if (colArr[i] == codeCol) {
                    colListIdx[0]=i;
                }
                for (var j=0; j < arrText.length; j++) {
                    if (colArr[i] == arrText[j]) {
                        colListIdx[j+1]=i;
                    }
                }
            }
            for (var i=0; i < dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) {
                    continue;
                }
                var arrData=null;
                if (sep == null || sep == "") {
                    arrData=new Array();
                    var trChildNodes=dataChildNodes[i].childNodes;
                    for (var j=0; j < trChildNodes.length; j++) {
                        if (trChildNodes[j].nodeType != 1) {
                            continue;
                        }
                        arrData.push(trChildNodes[j].firstChild.nodeValue);
                    }
                } else {
                    arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
                }
                var item="";
                for (var j=1; j < colListIdx.length; j++) {
                    item += arrData[colListIdx[j]];
                    if (j < colListIdx.length - 1) {
                        item += "|";
                    }
                }
                cmbObj.InsertItem(-1, item, arrData[colListIdx[0]]);
            }
        } catch (err) {
            ComFuncErrMsg(err.message);
        }
    }
    /**
     * Checking a duplication regarding amend
     * Checking except rows with previous Amend Sequence or Amend Delete(AD)
     * Return -1 in case of duplicated row, row's index in case of no duplicated row(over 0)<br>
     * <br><b>Example :</b>
     * <pre>
     *     var dupRow = ComPriAmendDupRows(sheetObj, "prc_cmdt_tp_cd|prc_cmdt_def_cd", formObj.amdt_seq.value);
     *     if (dupRow >= 0) {
     *         sheetObj.SelectRow = dupRow;
     *         ComShowCodeMessage("PRI00302");
     *         return false;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj    Mandatory,IBSheet Object
     * @param {string}  sCol        Mandatory, base column when checking a duplication.using "|" delimiter
     * @param {string}  amdtSeq     Mandatory, current amend sequence.(document.form.amdt_seq.value)
     * @return int <br>
     *         -1   : in case of no duplicated row
     *         over 0 : row index of duplicated row
     * @author 
     * @version 2010.12.20
     */
    function ComPriAmendDupRows(sheetObj, sCol, amdtSeq) {
        try {
            if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
                return;
            }
            if (sCol == undefined || sCol == null || sCol == "") {
                return;
            }
            var dupRow = sheetObj.ColValueDupRows(sCol, false, true);
            if (dupRow == null || dupRow == "") {
                return -1;
            }
            //all duplicated row
            var rowArr=dupRow.replace("|", ",").split(",");
            //Excluding Amend Delete data
            for(var i=0; i<rowArr.length; i++) {
                if(sheetObj.GetCellValue(rowArr[i], "amdt_seq") != amdtSeq
                        || sheetObj.GetCellValue(rowArr[i], "src_info_cd") == "AD") {
                    rowArr.splice(i, 1);
                }
            }
            var dupValue="";
            var tmpValue="";
            for(var i=0; i<rowArr.length; i++) {
                dupValue=sheetObj.GetCellValue(rowArr[i], "inlnd_rt_bse_loc_cd")
                    + sheetObj.GetCellValue(rowArr[i], "inlnd_rt_bse_loc_zip_cd")
                    + sheetObj.GetCellValue(rowArr[i], "inlnd_rt_term_cd")
                    + sheetObj.GetCellValue(rowArr[i], "inlnd_rt_via_loc_cd")
                    + sheetObj.GetCellValue(rowArr[i], "prc_inlnd_rt_trsp_mod_cd")
                    + sheetObj.GetCellValue(rowArr[i], "inlnd_rt_min_lmt_wgt")
                    + sheetObj.GetCellValue(rowArr[i], "inlnd_rt_lmt_wgt")
                    + sheetObj.GetCellValue(rowArr[i], "inlnd_rt_lmt_wgt_ut_cd")
                    + sheetObj.GetCellValue(rowArr[i], "prc_cgo_tp_cd");
                for(var j=0; j<rowArr.length; j++) {
                    tmpValue=sheetObj.GetCellValue(rowArr[j], "inlnd_rt_bse_loc_cd")
                        + sheetObj.GetCellValue(rowArr[j], "inlnd_rt_bse_loc_zip_cd")
                        + sheetObj.GetCellValue(rowArr[j], "inlnd_rt_term_cd")
                        + sheetObj.GetCellValue(rowArr[j], "inlnd_rt_via_loc_cd")
                        + sheetObj.GetCellValue(rowArr[j], "prc_inlnd_rt_trsp_mod_cd")
                        + sheetObj.GetCellValue(rowArr[j], "inlnd_rt_min_lmt_wgt")
                        + sheetObj.GetCellValue(rowArr[j], "inlnd_rt_lmt_wgt")
                        + sheetObj.GetCellValue(rowArr[j], "inlnd_rt_lmt_wgt_ut_cd")
                        + sheetObj.GetCellValue(rowArr[j], "prc_cgo_tp_cd");
                    if(i != j) {
                        if(dupValue == tmpValue) {
                            return rowArr[j];
                        }
                    }
                }
            }
            return -1;
        } catch(err) { ComFuncErrMsg(err.message); }
    }