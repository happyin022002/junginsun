/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_3100.js
*@FileTitle  : Packing Instructions/Provisions (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var uploadObjects=new Array();
	var uploadCnt=0;
	var saveSheetId = "";
	var SEARCHKEY = 102;
	var COUNTRY	  = "CNT";
	var ROWMARK   = "|";
	var FIELDMARK = "=";
	
	/**
     * Dynamically load HTML Control event in page. <br>
     * Initialize IBSheet Object by calling this function from {@link #loadPage} function. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects list in turn
     **/
    function initControl() {    	
    	var formObject = document.form;
        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
	    var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Sign_Fileadd": 
					saveSheetId=sheetObjects[0].id;
					break; 	
				case "btn_Init_Fileadd": 
					saveSheetId=sheetObjects[1].id;
					break; 		
                case "btn_Sign_Filedelete": 
                	obj_filedelete(sheetObjects[0], "esig_");
                	sheetObjects[0].RemoveAll();
 					toggleButtons();
                    break;		
 				case "btn_Init_Filedelete":
 					obj_filedelete(sheetObjects[1], "init_");					 					
 					sheetObjects[1].RemoveAll();
					toggleButtons();
					break;                    
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);					
					break;
 				case "btn_close":
 					ComClosePopup();
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
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
    }    
    /**
     * register IBUpload Object created in page as uploadObjects list <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++]=uploadObj;
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {    	
        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }        
        initUpload();        
        initControl();
        
 	    var sheetObj = sheetObjects[0];
 	    var formObj = document.form;
 	    initComboSetVal(sheetObj, formObj);
 	    
 	    toggleButtons();
 	    
 	    var formObject = document.form;
 	    if(formObject.bl_esig_seq.value != '' && formObject.bl_esig_seq.value.length > 0) {
 	    	doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
 	    }
    }
    
    /**
 	 *  Get Receiving Term,Delivery Term combo data
 	 **/
 	 function initComboSetVal(sheetObj, formObj){
 		sheetObj.ShowDebugMsg(false);
 		sheetObj.SetWaitImageVisible(0);
 		ComSetObjValue(formObj.f_cmd, SEARCH02);
 		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		var comboItems = ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
		comboObjects[0].RemoveAll();
		addComboItem(comboObjects[0],comboItems);
 	 }
 	function addComboItem(comboObj, comboItems, comboType) {
     	for (var i = 0 ; i < comboItems.length ; i++) {
     		var comboItem = comboItems[i].split(FIELDMARK);
     	
     		if (comboType == "ONE-SELECT") {
     			comboObj.InsertItem(i, comboItem[1], comboItem[0]);
     		}
     		else {
     			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
     		}
     	}   		
 	}
    
    function initCombo(comboObj, comboNo) {
         switch(comboObj.options.id) {
         case "cnt_cd":
             with(comboObj) {
        	 	SetMultiSelect(0);    
        	 	SetDropHeight(160);
        		SetColAlign(0, "left");
        		SetColAlign(1, "left");  
                SetColWidth(0, "50");
                SetColWidth(1, "190"); 
                ValidChar(2,3);
                SetMaxLength(2);
             }
             break;        
         }
    }
     
    function initUpload(){
    	upload1.Initialize({
			SaveUrl:'/opuscntr/ESM_BKG_3100GS.do',
			ShowButtonArea: true,
			ExtraForm:'upLoadForm',
			AddSaveButton: function(ibup){
				
			},
			AfterSaveStatus : function(result) {
				var code = result.code;
				if( code == 0) {
					var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
					var fldNm = "esig_";
					switch(saveSheetId) {
			            case "sheet1":  
			            	var sheetObj = sheetObjects[0];
			            	fldNm = "esig_";
			            	break; 
			            case "sheet2":  
			            	var sheetObj = sheetObjects[1];
			            	fldNm = "init_";
			            	break; 
			        }
					var row = sheetObj.GetSelectRow();
					sheetObj.SetCellValue(row, fldNm + "file_sav_id", ComGetEtcData( sXml, "fileKey"));
					
					if(fldNm == "esig_"){
						document.form.img_Sign.src = 'FileDownload?key=' + ComGetEtcData( sXml, "fileKey");
						document.form.img_Sign.style.display = '';
					}else{
						document.form.img_Init.src = 'FileDownload?key=' + ComGetEtcData( sXml, "fileKey");
						document.form.img_Init.style.display = '';
					}
				} else {
					ComShowMessage(result.msg);
				}
			},			
			BeforeSaveStatus : function(result) {
                return true;
			},
			AfterAddFile : function(result) {
				var fldNm = "esig_";
				switch(saveSheetId) {
		            case "sheet1":  
		            	var sheetObj = sheetObjects[0];
		            	fldNm = "esig_";
		            	break; 
		            case "sheet2":  
		            	var sheetObj = sheetObjects[1];
		            	fldNm = "init_";
		            	break; 
		        }
				sheetObj.DataInsert(-1);
				
				var files = upload1.GetList();
			    var fileName = files[files.length-1].GetFileName();
			    var serialNo = files[files.length-1].GetSerialNo();	
			    var row = sheetObj.GetSelectRow();
			     
			    var sheet_serial = sheetObj.GetCellValue(row, fldNm+"file_sav_id");
			    ComUploadRemoveFile(upload1, sheet_serial, false);
				
				for( var i = 0; i < files.length; i++) {
					if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), fldNm + "file_nm") == files[i].GetFileName()){
						upload1.RemoveOneFile(files[i].GetSerialNo());
					}
				}
				if(fileName.length > 0) {
					sheetObj.SetCellValue(row, fldNm+"file_nm", fileName.substr(fileName.lastIndexOf("\\")+1),0);
					sheetObj.SetCellValue(row, fldNm+"file_path_rmk", fileName, 0);
				}else{
					sheetObj.RemoveAll();
				}				
				if (serialNo.length > 0 && serialNo != undefined) {
//					sheetObj.SetCellValue(row, fldNm+"file_sav_id", serialNo);
			 		toggleButtons(sheetObj);
				} else {
					sheetObj.SetCellValue(row, fldNm+"file_nm", "");
					sheetObj.SetCellValue(row, fldNm+"file_path_rmk", "");
					sheetObj.SetCellValue(row, fldNm+"file_sav_id", "");    
				}
				var formObj = document.form;
				formObj.f_cmd.value = SEARCH02;
				var sParam= FormQueryString(formObj);
				paramToForm(sParam); 	
				
				upload1.SaveStatus();
				upload1.InitData();
			},
			BeforeAddFile : function(result){
				return true;
			},
			AfterOnload : function() {
		          upload1.SetCustomAddButtonAsID('btn_Sign_Fileadd');
		          upload1.SetCustomAddButtonAsID('btn_Init_Fileadd');		          
			}
		});
    }
    
    function sheet1_OnMouseMove(){
    	var row = sheet1.MouseRow(),
        col = sheet1.MouseCol(),
        info = null;
             
        if (row > 0 &&col == 8) {
        	prow = row;
        	info = sheet1.GetCellElement(row, col, 1);
        	upload1.SetFileUploadElement(info);
        } 
    }
    
    function sheet2_OnMouseMove(){
    	var row = sheet2.MouseRow(),
        col = sheet2.MouseCol(),
        info = null;
             
        if (row > 0 &&col == 8) {
        	prow = row;
        	info = sheet2.GetCellElement(row, col, 1);
        	upload1.SetFileUploadElement(info);
        } 
    }    
    
    //ibupload-page별 변경 영역--s
    function resetUpload(){
    	//sheetObjects[0].RemoveAll();
    	ComUploadRemoveFile(upload1, "", true);
    }
    //ibupload-page별 변경 영역--e

    /**
     * 추가끝
     */
    /**
     * Handling sheet1 OnLoadFinish Event
     * param : sheetObj ==> sheet object
     * 
     */
    function sheet1_OnLoadFinish(sheetObj) {	
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
            		var HeadTitle="|File Name|Download|1|2";
            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
            		var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);
                    var cols = [ {Type:"Text",   Hidden:1, Width:80,  Align:"Center",  ColMerge:0,  SaveName:"esig_file_sav_id" },
                                 {Type:"Text",   Hidden:0, Width:50,  Align:"Left",    ColMerge:0,  SaveName:"esig_file_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1},
                                 {Type:"Text",   Hidden:1, Width:80,  Align:"Center",  ColMerge:0,  SaveName:"esig_file_path_rmk" },
                                 {Type:"Status", Hidden:1, Width:40,  Align:"Center",  ColMerge:0,  SaveName:"ibflag" }
                                 ];
		              
                    InitColumns(cols);
                    SetEditable(1);
                    SetImageList(0,"/opuscntr/img/ico_attach.gif");
                    SetWaitImageVisible(0);
                    SetRowHidden(0, 1);
                    SetDataLinkMouse("file_dn",1);
                    SetShowButtonImage(1);
                    SetAutoRowHeight(0);
                    SetCountPosition(0);
               }
               break;
            case 2:      //sheet1 init
                with(sheetObj){
            		var HeadTitle="|File Name|Download|1|2";
            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
            		var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);
                    var cols = [ 
                                {Type:"Text",   Hidden:1, Width:80,  Align:"Center",  ColMerge:0,  SaveName:"init_file_sav_id" } ,
                                 {Type:"Text",   Hidden:0, Width:50,  Align:"Left",    ColMerge:0,  SaveName:"init_file_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1},
                                 {Type:"Text",   Hidden:1, Width:80,  Align:"Center",  ColMerge:0,  SaveName:"init_file_path_rmk" },
                                 {Type:"Status", Hidden:1, Width:40,  Align:"Center",  ColMerge:0,  SaveName:"ibflag" }
                                 ];
		              
                    InitColumns(cols);
                    SetEditable(1);
                    SetImageList(0,"/opuscntr/img/ico_attach.gif");
                    SetWaitImageVisible(0);
                    SetRowHidden(0, 1);
                    SetDataLinkMouse("file_dn",1);
                    SetShowButtonImage(1);
                    SetAutoRowHeight(0);
                    SetCountPosition(0);
               }
               break; 
            case 3:
                with(sheetObj){
            		var HeadTitle = "|Country|Last Name|First Name|Active|Signature File Nm|Signature File Path|Signature File Save Id|Initials File Nm|Initials File Path|Initials File Save Id|Desc";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [
        		             {Type:"Status",   Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },      
          		             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",          	KeyField:0,   CalcLogic:"",   Format:"", 	UpdateEdit:1,   InsertEdit:0 },
                           	 {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"esig_n1st_nm",       KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"esig_lst_nm",        KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"act_flg",   			KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"esig_file_nm",   	KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"esig_file_path_rmk", KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"esig_file_sav_id",   KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"init_file_nm",       KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"init_file_path_rmk",	KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"init_file_sav_id",   KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"esig_desc",   		KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 } ];
	                   
                    InitColumns(cols);
                    SetEditable(1);
                    SetCountPosition(0);
                }
                break;               
        }
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {      	            
			case IBSEARCH:      //retrieve
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				formObj.f_cmd.value = SEARCH;
 				
 				var sXml = sheetObj.GetSearchData("ESM_BKG_3100GS.do", FormQueryString(formObj));
 				sheetObj.LoadSearchData(sXml, {Sync:1});
 				
 				var signPath = sheetObj.GetCellValue(1, "esig_file_sav_id");
 				var initPath = sheetObj.GetCellValue(1, "init_file_sav_id");
 				if(signPath != '' && signPath != undefined){
 					formObj.img_Sign.src = 'FileDownload?key=' + signPath;
 	 				formObj.img_Init.src = 'FileDownload?key=' + initPath;
 	 				formObj.img_Sign.style.display = '';
 	 				formObj.img_Init.style.display = '';
 				}
 				
 				
				break;
			case IBSAVE:        //save
				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				if(formObj.bl_esig_seq.value != '' && formObj.bl_esig_seq.value.length > 0)
 	 				formObj.f_cmd.value = MODIFY;
 				else
 					formObj.f_cmd.value = ADD; 				
 	 			checkSetValue(); 
 	 			
 	 			var sParam= FormQueryString(formObj);
                var arySheets = new Array(sheetObjects[0], sheetObjects[1]);
                var aryPrefixs = new Array("esig_file_sav_id","init_file_sav_id");
                
                var fParam=ComGetSaveString(arySheets, true);
                sParam += "&" + fParam;
                var saveXml=sheetObj.GetSaveData("ESM_BKG_3100GS.do", sParam);                
                sheetObj.LoadSaveData(saveXml);
                saveXml=ComDeleteMsg(saveXml);
			break;					
        }
    }
    /**
     * Event after retrieving Sheet
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			SetColFontUnderline("esig_file_nm",1);
			SetDataLinkMouse("esig_file_nm",1);
		}
	}
    /**
     * Event after saving Sheet
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {						
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "eSignature");    // {?msg1} was saved successfully.
        ComClosePopup();
    }

    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
 		switch(sAction) {
			case IBSAVE:
				if(formObj.esig_n1st_nm.value.length == 0) {
					ComShowCodeMessage('COM12114', 'First Name');
  					return false;
				}
				if(formObj.esig_lst_nm.value.length == 0) {
					ComShowCodeMessage('COM12114', 'Last Name');
  					return false;
				}
				if(cnt_cd.GetSelectCode() == '') {
					ComShowCodeMessage('COM12114', 'Country');
  					return false;
				}		
				
				if(sheetObjects[0].LastRow() == 0 || sheetObjects[1].LastRow() == 0) {
					ComShowCodeMessage("COM130403", "Attach File");
					return false;
				}
				break;
 		}
 		return true;
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
 	function toggleButtons(sheetObj) {
 		var formObj = document.form;
 		var sheet1 = sheetObjects[0];
 		var sheet2 = sheetObjects[1];
 		
 		try {
 			// Signature file
 			ComSetDisplay("btn_Sign_Fileadd",true);
 			ComBtnEnable("btn_Sign_Fileadd");
 			ComSetDisplay("btn_Sign_Filedelete",false);
 			ComBtnDisable("btn_Sign_Filedelete");
 			
 			formObj.img_Sign.style.display = 'none';
			formObj.img_Init.style.display = 'none';
 			
 			if(getValidRowCount(sheet1) > 0) {
				ComSetDisplay("btn_Sign_Fileadd",false);
				ComBtnDisable("btn_Sign_Fileadd");
				ComSetDisplay("btn_Sign_Filedelete",true);
				ComBtnEnable("btn_Sign_Filedelete");
				formObj.img_Sign.style.display = '';
			}
 			
 			// Initial file
 			ComSetDisplay("btn_Init_Fileadd",true);
 			ComBtnEnable("btn_Init_Fileadd");
 			ComSetDisplay("btn_Init_Filedelete",false);
 			ComBtnDisable("btn_Init_Filedelete");
 			
 			if(getValidRowCount(sheet2) > 0) {
				ComSetDisplay("btn_Init_Fileadd",false);
				ComBtnDisable("btn_Init_Fileadd");
				ComSetDisplay("btn_Init_Filedelete",true);
				ComBtnEnable("btn_Init_Filedelete");
				formObj.img_Init.style.display = '';
			}
 		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
 		} 		
 	}    
 	
 	function obj_filedelete(sheetObj, fldStr) {
 		var files = upload1.GetList();
		for( var i = 0; i < files.length; i++) {
			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), fldStr+"file_nm") == files[i].GetFileName()){
				upload1.RemoveOneFile(files[i].GetSerialNo());
			}
		} 		
 	}
 	
    // set checkbox value
    function checkSetValue(){
		var formObj = document.form;
		if (formObj.act_flg_chk.checked) {
			formObj.act_flg.value = "Y"; 
		} else {
			formObj.act_flg.value = "N";
		}
	} 	
    
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		var cnt_cd 				= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cnt_cd");
		var esig_n1st_nm 		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "esig_n1st_nm");
		var esig_lst_nm 		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "esig_lst_nm");
		var act_flg 			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "act_flg");
		var esig_file_nm 		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "esig_file_nm");
		var esig_file_path_rmk 	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "esig_file_path_rmk");
		var esig_file_sav_id	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "esig_file_sav_id");
		var init_file_nm 		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "init_file_nm");
		var init_file_path_rmk	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "init_file_path_rmk");
		var init_file_sav_id	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "init_file_sav_id");
		var esig_desc			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "esig_desc");
		
		var formObject = document.form;
		comboObjects[0].SetSelectCode(cnt_cd);
		formObject.esig_n1st_nm.value 	= esig_n1st_nm;
		formObject.esig_lst_nm.value	= esig_lst_nm;
		formObject.esig_desc.value		= esig_desc;
		
		var Row = 0;
		if(esig_file_nm != '' && esig_file_nm.length > 0) {
			Row = sheetObjects[0].DataInsert(-1);
			sheetObjects[0].SetCellValue(Row, "esig_file_nm", esig_file_nm);
			sheetObjects[0].SetCellValue(Row, "esig_file_path_rmk", esig_file_path_rmk);
			sheetObjects[0].SetCellValue(Row, "esig_file_sav_id", esig_file_sav_id);
		}

		if(init_file_nm != '' && init_file_nm.length > 0) {
			Row = sheetObjects[1].DataInsert(-1);
			sheetObjects[1].SetCellValue(Row, "init_file_nm", init_file_nm);
			sheetObjects[1].SetCellValue(Row, "init_file_path_rmk", init_file_path_rmk);
			sheetObjects[1].SetCellValue(Row, "init_file_sav_id", init_file_sav_id);
		}

		
		if(act_flg != '' && act_flg == 'Y') {
			formObject.act_flg_chk.checked = true;
		} else {
			formObject.act_flg_chk.checked = false;
		}
		
		toggleButtons();
	}    
