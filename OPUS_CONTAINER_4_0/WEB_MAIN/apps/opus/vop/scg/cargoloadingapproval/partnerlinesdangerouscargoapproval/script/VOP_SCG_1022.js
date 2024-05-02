/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_1022.js
*@FileTitle  : Dangerous CGO Application Details for Partner Lines
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/17
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_1022 : business script for vop_scg_1022
     */
//------------------------------------------------------------------------------//
/* common variables */    
//------------------------------------------------------------------------------//
    // common global variables
    var comboObjects	= new Array();
	var comboCnt		= 0;
    var sheetObjects	= new Array();
    var sheetCnt		= 0;
    var uploadObjects	= new Array();
	var uploadCnt		= 0;
	var orgSheetObj		= null;
	var orgFormObj		= null;
	var closeYn			= false;
	var newYn			= false; 
	var isView			= true;
	var noPolCd 		= "";
	var noPodCd 		= "";
	//2016-02-01  전역 변수 추가 
	var polRsoCd 		= new Array();
	var polScontiCd        = new Array();
	var rsoDelFlg		   = new Array();
	var newpolScontiCd     = "";
	var maxlength          = "";
	//2016-02-01  전역 변수 추가 
	var arrAutoReqItem 	= new Array(24);
	var rjtCode 		= "Y"; //RJT Code 최초 빈값 셋팅여부확인
	var openerObj=window.dialogArguments;
	if(!openerObj) var openerObj= parent;
	
    /**
     * autoRequestItem Structure
     */
    function autoReqItem(){
    	var name 		= "";
    	var value 		= "";
   }
    
    /**
     * autoRequestItem의 초기DB값을 설정한다.(load)
     */
    function setAutoRequestItem(arg) {
    	
    	////alert('arg >> [ '+arg+' ] <<' );
    	
    	if(arg == 'key') {
	    	for(var i=0;i<arrAutoReqItem.length;i++) {
	    		arrAutoReqItem[i] = new autoReqItem(); 
	    	}
	    	// initial
	    	arrAutoReqItem[0].name 	= 'imdg_clss_cd';
	    	arrAutoReqItem[1].name 	= 'imdg_un_no';
	    	arrAutoReqItem[2].name 	= 'imdg_un_no_seq';
	    	arrAutoReqItem[3].name 	= 'prp_shp_nm';
	    	arrAutoReqItem[4].name 	= 'hzd_desc';
	    	arrAutoReqItem[5].name 	= 'grs_wgt';
	    	arrAutoReqItem[6].name 	= 'net_wgt';
	    	arrAutoReqItem[7].name 	= 'imdg_pck_grp_cd';
	    	arrAutoReqItem[8].name 	= 'psa_no';
	    	arrAutoReqItem[9].name 	= 'flsh_pnt_cdo_temp';
	    	arrAutoReqItem[10].name = 'ems_no';
	    	arrAutoReqItem[11].name = 'mrn_polut_flg';
	    	arrAutoReqItem[12].name = 'emer_cntc_phn_no';
	    	arrAutoReqItem[13].name = 'emer_cntc_pson_nm';
	    	arrAutoReqItem[14].name = 'certi_no';
	    	arrAutoReqItem[15].name = 'net_explo_wgt';
	    	arrAutoReqItem[16].name = 'out_n1st_imdg_pck_qty';
	    	arrAutoReqItem[17].name = 'out_n1st_imdg_pck_cd';
	    	arrAutoReqItem[18].name = 'out_n2nd_imdg_pck_qty';
	    	arrAutoReqItem[19].name = 'out_n2nd_imdg_pck_cd';
	    	arrAutoReqItem[20].name = 'intmd_n1st_imdg_pck_qty';
	    	arrAutoReqItem[21].name = 'intmd_n1st_imdg_pck_cd';
	    	arrAutoReqItem[22].name = 'intmd_n2nd_imdg_pck_qty';
	    	arrAutoReqItem[23].name = 'intmd_n2nd_imdg_pck_cd';
    	} else {
	    	// value setting
	    	for(var i=0;i<arrAutoReqItem.length;i++) {
	    		arrAutoReqItem[i].value = ComGetObjValue(eval("form."+arrAutoReqItem[i].name)); 
	    	}
    	}
    }
//------------------------------------------------------------------------------//
/* common variables -- initalizing process */    
    // event Catch Listener
    function initControl() {
         // Axon event handling1. event catch
		 axon_event.addListenerForm		('keypress'	, 'obj_keypress', form);
//			axon_event.addListenerForm('blur', 'obj_blur', form);
         axon_event.addListenerFormat 	('focus'	, 'obj_focus'	, form);
         axon_event.addListenerFormat 	('blur'		, 'obj_focusout', form);
         axon_event.addListenerForm   	('keyup'	, 'obj_keyup'	, form);
         axon_event.addListenerForm   	('change'	, 'obj_change'	, form);
         axon_event.addListener			('keydown'	, 'ComKeyEnter'	, 'form');
//         axon_event.addListener       ('keydown',  'obj_keydown',   'form');
    } 
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * register IBCombo Object created in page as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     */
    function setComboObject(combo_obj) {
         comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
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
 		loadPage(false);  // ::TW Load Page flag
 	}
 	
    function loadPage(isReload) {
    	
    	if(preConds.src_tp_cd == "EDI" && closeYn ==  true){
    		$(".pop_close").attr("onClick", "parent.searchList();ComClosePopup()");	
    	}
    	
    	//alert('loadPage ['+isReload+']');
    	setAutoRequestItem('key');
    	
	    if(!isReload) {
	    	
	    	// 1.display 구성
	       //::TW 처음에 Load Page
	    	if(preConds.pId != "VOP_SCG_0022") { // scg 작성 화면이 아닌 경우
	    		document.all.popLayer.style.display = ""; // Approval layer show
	    		btnDisableProc(); // application 관려 button disabled
	    		
	    		if(preConds.pId != "VOP_SCG_5001") { // Approval 화면이 아닌 경우
	    			document.form.auth_sts_cd.disabled = true; // Approval status 변경 불가
	    		}else{
		            // auth_sts_cd의  option을 삭제
		           	document.form.auth_sts_cd.remove(0);//Save
		           	document.form.auth_sts_cd.remove(0);//Request Cancel

	    			document.form.auth_sts_cd.disabled = false; 
	    		}
	    		
	    	} else {
	    		isView = false;
	    		//::TW 작성화면인지 Inquiry 용인지 구분 flag
	    	}
	    	
	    	// 2.Initializing IBSHEET
	    	for(i=0;i<sheetObjects.length;i++) {
	        	ComConfigSheet		(sheetObjects[i]);
	            initSheet			(sheetObjects[i],i+1);
	            ComEndConfigSheet	(sheetObjects[i]);
	        } 
	
	    	if(preConds.pId != "VOP_SCG_0022") { // Approval 화면이 아닌 경우
	    		sheetObjects[0].SetColHidden("del_chk",1);
	    		sheetObjects[0].SetColWidth	("cntr_ref_no","130");
			}else{
				if(preConds.src_tp_cd == "EDI"){
					sheetObjects[0].SetColHidden("del_chk",1);
					sheetObjects[0].SetColWidth	("cntr_ref_no","130");
					ComBtnDisable("btn1_Attach_File");
					
					ComBtnDisable("btn2_Add");
					ComBtnDisable("btn2_Delete");
					ComBtnDisable("btn2_Copy");
				}else{
					sheetObjects[0].SetColHidden("del_chk",0);
				}
			}
	    	
	        // 3.Initializing IBMultiCombo
	  	    for(var k=0; k < comboObjects.length; k++){
	  	        initCombo(comboObjects[k], k + 1);
	  	    }
	        
	        // 4.Initializing Upload Sheet
	  	    // UPLOAD configuration
	        for(var i=0;i<uploadObjects.length;i++){
			    //1. basic configuration
	        	initUpload();
			    //ComConfigUpload(uploadObjects[i], "/opuscntr/VOP_OPF_1053GS.do");
			    ComConfigUpload(uploadObjects[i], "/opuscntr/VOP_SCG_1022GS.do");
			}
	        
	        // 5.Add Event to Object
	        initControl();
	
	        // 6.Add Combo Data
	        // TP/SZ (Combo)
		 	searchTPSZList(sheetObjects[0]);
			// POL,POD (Combo)
		 	setPreCondition(sheetObjects[1]);
		 	// Segregation Group (Combo)
		 	setSegregation(sheetObjects[1]);
		    // Reject Code(Combo)
		 	setRejectCode(sheetObjects[1]);
	
		 	// 7.retrieve
		 	if(preConds.spcl_cgo_rqst_seq != '') {
		 		// :: TW 신규가 아닐 때 불러온다.
		 		// sheetObjects[0] : container
		 		// sheetObjects[1],[2] : IBSEARCH
		 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		 		
		 	} else { // 확인필요
		 		var openerXml = parent.getAppDetlObj();
		 		//var openerXml=window.dialogArguments.getAppDetlObj(); 
		 		if(openerXml != null) {
			 		sheetObjects[1].LoadSearchData(openerXml,{Append:1 , Sync:1} );
		 		} else {
		 			resetUI(sheetObjects[1], document.form, "init");
		 		}
		 	}
	        window.name="partnerDG";
	        // Update화면에서는 approval 상태를 상단에 표시한다.
	        
	        initApvl			();
	     // 승인상태에 따른 처리 
	     // btn3_Row_Delete button
	
	      //다른 곳에서도 호출 ex- copy /add 경우의 수에 따라 활성화 비활성화 처리 봐야된다. 
	        ctrlRowDeleteBtn	();
	        
	        if(!isView) {
	//        	initApvl();
	        	displayEDI		();
	        	//EDI는 작성화면에서 disable 처리가 필요하므로 나머지 하단 버튼은 disable 처리 
	        } else { // Approval, View의 경우에는 object를 readonly로 변경한다.
	        	objDisabled		();
	        }
	        
	        // package qty button
	        checkPkgQty			();
	        // class1Only Process
	        class1Only			();
	        setAutoRequestItem	('value'); //::TW auto리퀘스트를 위해 값을 담아두는것 
	        
	    } else { //::TW reload, insert에서 update 로 바꿔준다. 
	    		
    		// 변경obj만 재설정
    		var formObj 							= document.form;
			ComSetObjValue(formObj.ibflag, "U");
			ComSetObjValue(formObj.org_cgo_opr_cd, ComGetObjValue(formObj.cgo_opr_cd)	);
			ComSetObjValue(formObj.org_bkg_ref_no, ComGetObjValue(formObj.bkg_ref_no)	);
			ComSetObjValue(formObj.org_vsl_cd,     ComGetObjValue(formObj.vsl_cd)		);
			ComSetObjValue(formObj.org_skd_voy_no, ComGetObjValue(formObj.skd_voy_no)	);
			ComSetObjValue(formObj.org_skd_dir_cd, ComGetObjValue(formObj.skd_dir_cd)	);
			ComSetObjValue(formObj.org_crr_cd,     ComGetObjValue(formObj.crr_cd)		);
			ComSetObjValue(formObj.org_slan_cd,    ComGetObjValue(formObj.slan_cd)		);
			
			setEnableUI(document.form, document.form.cgo_opr_cd, document.form.skd_dir_cd, 'readonly');
			
			document.getElementById("btn_Carrier").style.visibility		= "hidden";
			document.getElementById("btn_VVDpop").style.visibility		= "hidden";
			
			var sheetObj 		= sheetObjects[1];
			for(var nextIdx=sheetObj.HeaderRows(); nextIdx<=sheetObj.LastRow(); nextIdx++) {
	 			var rowStatus	= sheetObj.GetRowStatus(nextIdx);
	 			if(rowStatus != 'D') {
	 				sheetObj.SetCellValue(nextIdx, "org_dcgo_ref_no", sheetObj.GetCellValue(nextIdx, "dcgo_ref_no"), false);
	 				sheetObj.SetRowStatus(nextIdx, "U");
	 			}
	 		}
			
    		initApvl			(); //::TW 변경내역이 존재하므로 다시 체크.
    		
    		/** Adding : by TOP **/
    		setAutoRequestItem	('value');
    	}
    }
    
    /*
     * Segregation Group Search
     */
    function setSegregation(sheetObj) {
    	var sXml=sheetObj.GetSearchData("VOP_SCG_0001GS.do", "f_cmd="+SEARCH01);
		var arrXml=sXml.split("|$$|");
     	ComXml2ComboItem(arrXml[1], imdg_segr_grp_no, "imdg_segr_grp_no", "imdg_segr_grp_no|imdg_segr_grp_nm");
    }
    
    /*
     * Reject Code Search
     */
    function setRejectCode(sheetObj) {
    	var sXml=sheetObj.GetSearchData("VOP_SCG_0031GS.do", "f_cmd="+SEARCH+"&spcl_cgo_cate_cd=DG");
		ComXml2ComboItem(sXml, spcl_cgo_auth_rjct_cd, "spcl_cgo_lod_rjct_rsn_cd", "spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
	}

    /**
     * btn3_Row_Delete버튼의 disable처리
     */
    function ctrlRowDeleteBtn() {
    	var value = ComGetObjValue(document.form.cntr_cgo_seq_sum);
    	var auth = ComGetObjValue(document.form.auth_sts_cd);
        if(value == '1' || value == '' || isView || auth == 'P') {
        	ComBtnDisable("btn3_Row_Delete");
    	} else {
    		ComBtnEnable("btn3_Row_Delete");
    	}
    }

    /*
     * Approval Status에 따라 display를 변경(spcl_cgo_auth_cd)
     */
    function initApvl() {
    	if(!isView) {
	    	var auth_cd = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "auth_sts_cd");
	//		var auth_cd = document.form.auth_sts_cd.value;
			document.form.spcl_cgo_auth_cd.value = auth_cd;
			if (auth_cd == 'N') {
				document.form.spcl_cgo_auth_cd.style.color="red";
			} else {
				document.form.spcl_cgo_auth_cd.style.color="black";
				if(auth_cd != 'R') {
					ComBtnDisable("btn3_Request_Cancel");
				} else {
					ComBtnEnable("btn3_Request_Cancel");
				}
			}
			if(document.form.spcl_cgo_auth_cd.value == 'P') { //Pending
	    		objDisabled();
	    		btnDisableProc();
	    	}
			// approval status display
			//::TW 작성화면인 경우 
			if(!isView) {
				if(auth_cd == 'Y') {
					document.getElementById("approved").setAttribute("style", "color:blue!important");
					document.getElementById("approved").innerHTML="Approved";
				} else if(auth_cd == 'N') {
					document.getElementById("approved").setAttribute("style", "color:red!important");
					document.getElementById("approved").innerHTML="Rejected";
				} else if(auth_cd == 'R') {
					document.getElementById("approved").setAttribute("style", "color:blue!important");
					document.getElementById("approved").innerHTML="Requested";
				} else if(auth_cd == 'P') {
					document.getElementById("approved").setAttribute("style", "color:black!important");
					document.getElementById("approved").innerHTML="Pending";
				} else if(auth_cd == 'C') {
					document.getElementById("approved").setAttribute("style", "color:black!important");
					document.getElementById("approved").innerHTML="Canceled";
				} else {
					document.getElementById("approved").innerHTML="";
				}
			}
			
    	}
    }
    
    /*
     * checkPkgQty : PKG Q'ty/Type Button Font Color setting
     */
    
  //::TW PkgQty 를 빨간색으로 하냐 파란색으로 하냐, 속의 데이터 확인 후.
    function checkPkgQty() {
    	var sheetObj = sheetObjects[1];
    	var outN1stQty;
		var outN1stCd ;
		var isEmpty = false;
//		for(var nextIdx=sheetObj.HeaderRows(); nextIdx<=sheetObj.LastRow(); nextIdx++) {
	    var idx = sheetObj.GetSelectRow();
		var rowStatus=sheetObj.GetRowStatus(sheetObj);
		if(rowStatus != 'D') {
			outN1stQty = sheetObj.GetCellValue(idx, "out_n1st_imdg_pck_qty");
			outN1stCd  = sheetObj.GetCellValue(idx, "out_n1st_imdg_pck_cd");
			if (outN1stQty == undefined || outN1stQty.length == 0 || outN1stCd == undefined || outN1stCd.length == 0) {
				isEmpty = true;
//					break;
			} 
		}
// 		}
		if(isEmpty) {
			document.getElementById("btn2_Package_Qty_Type").style.fontWeight="bold";
			ComGetObject("btn2_Package_Qty_Type").style.setProperty("color", BTN_RED, "important");
		} else {
			document.getElementById("btn2_Package_Qty_Type").style.fontWeight="bold";
			ComGetObject("btn2_Package_Qty_Type").style.setProperty("color", BTN_BLUE, "important");
		}
    }
    
    /*
     * updateRefNo : dg ref no ,bkg ref no의 변경여부를 체크
     */
    function updateRefNo(savename) {
    	var sheetObj = sheetObjects[1];
    	var curRefNo;
    	var orgRefNo;
    	var changed = false;
    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), savename, eval("form."+savename+".value"), 0);
		for(var nextIdx=sheetObj.HeaderRows(); nextIdx<=sheetObj.LastRow(); nextIdx++) {
 			var rowStatus=sheetObj.GetRowStatus(nextIdx);
 			if(rowStatus != 'D') {
 				curRefNo = sheetObj.GetCellValue(nextIdx, savename);
 				orgRefNo = sheetObj.GetCellValue(nextIdx, "org_"+savename);
				if (curRefNo != '' && orgRefNo != curRefNo) {
					changed = true;
					break;
				} 
 			}
 		}
		return changed;
    }
    
    /*
     * IBSHEET COMBO INIT
     * pol_cd, pod_cd,   spcl_cgo_seq,  imdg_lmt_qty_flg
     * dcgo_sts_cd,      mrn_polut_flg, imdg_expt_qty_flg
     * imdg_segr_grp_no, rsd_flg,       spcl_cgo_auth_rjct_cd
     */
    function initCombo(comboObj, comboNo) {
    	switch(comboNo) {
     		case 1://"pol_cd":  
	  			with(comboObj) {
	  				SetEnable(1);
	  				SetMultiSelect(0);
	  				SetBackColor("#CCFFFD");
	  				SetColWidth(0, "60");
	  				SetColWidth(1, "60");
	  				SetMultiSeparator("|");
	  			}
	  			break;  
     		case 2://"pod_cd":  
	  			with(comboObj) {
	  				SetEnable(1);
	  				SetMultiSelect(0);
	  				SetBackColor("#CCFFFD");
	  				SetColWidth(0, "60");
	  				SetColWidth(1, "60");
	  				SetMultiSeparator("|");
	  			}
	  			break;  
 	  		case 3://"spcl_cgo_seq":  
 	  			with(comboObj) {
 	  				SetEnable(1);
 	  				SetMultiSelect(0);
 	  				SetBackColor("#CCFFFD");
 //no support[check again]CLT 	  				LineColor="#FFFFFF"; 
// 	  				SetColAlign(0, "right");
// 	  				SetColAlign(1, "center");
// 	  				SetColAlign(2, "right");
// 	  				SetColWidth(0, "50");
// 	  				SetColWidth(1, "20");
// 	  				SetColWidth(2, "");
 //no support[check again]CLT 	  				ShowCol=2;
 	  				Index="";
 	  			}
 	  			break;  
 	  		case 4: //"imdg_lmt_qty_flg":  	  			
 	  			with(comboObj) {
 	  				InsertItem(0, "Y", "Y"); 
 	 	  			InsertItem(1, "N", "N"); 
 	  				SetEnable(1);
 	  				SetMultiSelect(0);
 	  				SetBackColor("#CCFFFD");
 	  				Code2="N";
 	  			} 	  			
 	  			break; 
 	  		case 5://"dcgo_sts_cd":   	  			 
 	  			with(comboObj) {
 	  				SetColWidth(0, "62");
 	  				SetDropHeight(19*6);
 	  				InsertItem(0, "",       ""); 
 	 	  			InsertItem(1, "GAS", 	"G"); 
 	 	  			InsertItem(2, "PASTE",  "P"); 
 	 	  			InsertItem(3, "LIQUID", "L"); 
 	 	  			InsertItem(4, "SOLID",  "S");
 	  				SetEnable(1);
 	  				SetMultiSelect(0);
 	  				Index="";
 	  			}
 	  			break; 	  			
 	  		case 6: //"mrn_polut_flg":   	  			
 	  			with(comboObj) {
 	  				InsertItem(0, "Y", "Y"); 
 	 	  			InsertItem(1, "N", "N"); 
 	  				SetEnable(1);
 	  				SetMultiSelect(0);
 	  				Code2="N";
 	  			} 	  			
 	  			break; 	  			
 	  		case 7: //"imdg_expt_qty_flg":  	  			
 	  			with(comboObj) {
 	  				InsertItem(0, "Y", "Y"); 
 	 	  			InsertItem(1, "N", "N"); 
 	  				SetEnable(1);
 	  				SetMultiSelect(0);
 	  				SetBackColor("#CCFFFD");
 	  				Code2="N";
 	  			} 	  			
 	  			break;
 	  		case 8: //"imdg_segr_grp_no":  	  			
 	  			with(comboObj) {
 	  				SetEnable(1);
 	  				SetMultiSelect(0);
	  				SetColWidth(0, "50");
	  				SetColWidth(1, "250");
	  				SetMultiSeparator("|");
 	  			} 	  			
 	  			break;
 	  		case 9: //"rsd_flg": 
 	  			with(comboObj) {
 	  				InsertItem(0, "Y", "Y"); 
 	 	  			InsertItem(1, "N", "N"); 
 	  				SetEnable(1);
 	  				SetMultiSelect(0);
 	  				Code2="N";
 	  			}
 	  			break;
 	  	}
    }
    
    // Upload Control Start! ============================================================//
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:"/opuscntr/VOP_SCG_1022GS.do",Files:[],
 			AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			ComUploadRemoveFile(upload1, "", true);
	      			
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			var formObj  = document.form;
                    var sheetObj = sheetObjects[2];
                    
                    ComOpenWait(false);
                    
                    if (sXml.length > 0) sheetObj.LoadSaveData(sXml);
                    //2016-01-07 START File Attach 시 Request Sequence setting.
                    
     			   	var rslt		= ComGetEtcData(sXml, "rslt");
    				var resultMap	= ComGetEtcData(sXml, "resultMap");
    				
    				if(resultMap != null && resultMap != ""){
    					var arrMap		= resultMap.split(",");
    			    	ComSetObjValue(formObj.spcl_cgo_rqst_seq, arrMap[0]); //채번된 spclCgoRqstSeq
     			    	ComSetObjValue(formObj.prnr_cgo_rqst_seq, arrMap[1]); //채번된 prnrCgoRqstSeq						
    				}
//       		    	if (sXml.length > 0) sheetObj.LoadSaveData(sXml);
       		    	if(formObj.requestChk.value == "R") {
       		    		ComShowCodeMessage("SCG50052");
       		    		//doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
       		    	}else if(formObj.requestChk.value == "C") {
       		    		ComShowCodeMessage("SCG50053");
       		    		//doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
       		    	}else {
       		    		ComShowCodeMessage("SCG50043");
       		    	}
       		    	//2016-01-07 END
	      		}else {
					ComShowMessage(result.msg);
					ComOpenWait(false);
				}
	      		
	      		//2016-01-11 START File Attach 이후 전체 재조회
	      		win_close("", false);
      			var formObj  = document.form;
                var sheetObj = sheetObjects[2];
                doActionIBSheet(sheetObj, formObj, IBSEARCH);
               //2016-01-11 END
 			},
	 		AfterDelFile:function(result){
	 		},
	 		AfterAddFile:function(result){
	 			var files    = upload1.GetList();		//result.files;
	 			var fileName = files[files.length-1].GetFileName();
			    var serialNo = files[files.length-1].GetSerialNo();
			    var sheetObj = sheetObjects[2];		
			    var row      = sheetObj.GetSelectRow();

			    var sheet_serial = sheetObj.GetCellValue(row, "serial_no");
			    if (sheet_serial!="") {
			    	ComUploadRemoveFile(upload1, sheet_serial, false);
			    }

 				with(sheetObj) {
 					SetCellValue(row, "serial_no",serialNo,0);//set file path
 					SetCellValue(row, "file_set_yn","Y",0);//set whether select localfile or not
 					SetCellValue(row, "file_nm",fileName,0);//set file name
 					SetCellFontUnderline(row, "file_nm", 0);//remove download link
 				}
			}
 		});
 	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
                with (sheetObj) {
				    var HeadTitle1="|CNTR\nSeq.|Del|Container No.|EDI\nTP/SZ|TP/SZ";
				    var headCount=ComCountHeadTitle(HeadTitle1);
	
				    SetConfig( { SearchMode:0, MergeSheet:5, DataRowMerge:1 } );
	
				    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				    InitHeaders(headers, info);
	
				    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"Text",      Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq",      KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },	//@@EditLen:-1 -> EditLen:2
				                 {Type:"CheckBox",  Hidden:0, Width:28,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
				                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ref_no",        KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"unmap_cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
				                 {Type:"ComboEdit", Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 }];
				     
				    InitColumns(cols);
				    SetSheetHeight(400);
				    SetEditable(1);
				    SetVisible(true);
				    
//				    SetColProperty("cntr_ref_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				    SetColProperty("cntr_ref_no" ,  {AcceptKeys:"E|N|[-_/]" , InputCaseSensitive:1}); // 영어,숫자,기호(-,_,/)
				    SetColProperty("cntr_tpsz_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				}
                break;
                
			case "sheet2":      //sheet2 init
            	with (sheetObj) {
				    var HeadTitle1="|CntrSeq|CgoSeq|Container No.|TPSZ" +
				    "|out_n1st_imdg_pck_qty|out_n1st_imdg_pck_cd|out_n1st_imdg_pck_desc|out_n2nd_imdg_pck_qty|out_n2nd_imdg_pck_cd|out_n2nd_imdg_pck_desc" +
				    "|in_n1st_imdg_pck_qty|in_n1st_imdg_pck_cd|in_n1st_imdg_pck_desc|in_n2nd_imdg_pck_qty|in_n2nd_imdg_pck_cd|in_n2nd_imdg_pck_desc" +
				    "|intmd_n1st_imdg_pck_qty|intmd_n1st_imdg_pck_cd|intmd_n1st_imdg_pck_desc|intmd_n2nd_imdg_pck_qty|intmd_n2nd_imdg_pck_cd|intmd_n2nd_imdg_pck_desc" +
				    "|max_in_pck_qty|max_in_pck_tp_cd|hcdg_pck_rstr_desc|hcdg_intmd_bc_rstr_desc|hcdg_tnk_rstr_desc|imdg_lmt_qty|imdg_lmt_qty_desc|imdg_lmt_qty_meas_ut_cd|imdg_expt_qty_cd|imdg_expt_qty_desc|imdg_spcl_provi_no" +
				    "|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|imdg_segr_grp_no|cfr_flg|grs_wgt|wgt_ut_cd|net_wgt" +
				    "|prp_shp_nm|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|hcdg_flg|rsd_flg|imdg_subs_rsk_lbl_rmk" +
				    "|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_expt_qty_flg" +
				    "|emer_cntc_phn_no|emer_cntc_pson_nm|certi_no" +
				    "|ems_no|ctrl_temp_ctnt|emer_rspn_gid_no|emer_rspn_gid_chr_no|emer_temp_ctnt" +
				    "|cnee_dtl_desc|net_explo_wgt|imdg_amdt_no|diff_rmk|auth_dt|auth_sts_cd|org_auth_sts_cd|spcl_cgo_auth_rjct_cd|spcl_cgo_auth_rmk|apro_ref_no|cgo_rqst_dt|dcgo_ref_no|org_dcgo_ref_no" +
				    "|Segregation Groups|Segregation Groups|Segregation Groups|Segregation Groups|cre_dt|auth_usr_id|dcgo_seq||";
				    
				    var headCount=ComCountHeadTitle(HeadTitle1);
	
				    SetConfig( { SearchMode:0, MergeSheet:5, DataRowMerge:1 } );
	
				    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				    InitHeaders(headers, info);
	
				    var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					              {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cntr_seq" },
					              {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_seq" },
					              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n1st_imdg_pck_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n1st_imdg_pck_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n1st_imdg_pck_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n2nd_imdg_pck_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n2nd_imdg_pck_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n2nd_imdg_pck_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n1st_imdg_pck_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n1st_imdg_pck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n1st_imdg_pck_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n2nd_imdg_pck_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n2nd_imdg_pck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n2nd_imdg_pck_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n1st_imdg_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n1st_imdg_pck_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n1st_imdg_pck_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n2nd_imdg_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n2nd_imdg_pck_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n2nd_imdg_pck_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"max_in_pck_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"max_in_pck_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_pck_rstr_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_intmd_bc_rstr_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_tnk_rstr_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_spcl_provi_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"net_wgt",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rsd_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_sts_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mrn_polut_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_pson_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"certi_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ems_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_temp_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_chr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_temp_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_dtl_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_explo_wgt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_amdt_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"auth_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"auth_sts_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_auth_sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_rjct_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"apro_ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_rqst_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:12 },
				                  {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_dcgo_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc4",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"auth_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    
				    			  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_rqst_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    			  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prnr_cgo_rqst_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    			  {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"edi_unmap_dtl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				    			  {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"unmap_cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
				    			  ];
				    
				    InitColumns(cols);
				    SetEditable(1);
				    SetSheetHeight(300);
				    SetVisible(false);
            	}
            	break;
            	
			case "sheet3":      // sheet3 init
	            with (sheetObj) {
				    var HeadTitle="|Seq.||File Name||ID|Date|||||||";
	
				    SetConfig( { SearchMode:0, DataRowMerge:0 } );
	
				    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
				    var headers = [ { Text:HeadTitle, Align:"Center"} ];
				    InitHeaders(headers, info);
	
				    var cols = [ {Type:"Status",   Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				              {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"No" },
				              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_set_yn",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"PopupEdit", Hidden:0, Width:245,  Align:"Center",  ColMerge:0,   SaveName:"file_nm",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_sav_id",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				              {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				              {Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_irr_file_seq" },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ref_no" },
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_rqst_seq" },
				              
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prnr_cgo_rqst_seq" },
				              
				              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_rqst_atch_file_seq" },
				              {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"serial_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				    InitColumns(cols);

				    SetEditable(1);
				    SetDataLinkMouse("file_nm", true);
				    SetShowButtonImage(2);
				    //SetSheetHeight(ComGetSheetHeight(sheetObj, 6));
				    SetSheetHeight(200);
				    SetVisible(false);
			   }
			   break;
			   
			case "sheet4":      //sheet4 init
            	with (sheetObj) {
				    var HeadTitle1="|CntrSeq|CgoSeq|Container No.|TPSZ" +
				    "|out_n1st_imdg_pck_qty|out_n1st_imdg_pck_cd|out_n1st_imdg_pck_desc|out_n2nd_imdg_pck_qty|out_n2nd_imdg_pck_cd|out_n2nd_imdg_pck_desc" +
				    "|in_n1st_imdg_pck_qty|in_n1st_imdg_pck_cd|in_n1st_imdg_pck_desc|in_n2nd_imdg_pck_qty|in_n2nd_imdg_pck_cd|in_n2nd_imdg_pck_desc" +
				    "|intmd_n1st_imdg_pck_qty|intmd_n1st_imdg_pck_cd|intmd_n1st_imdg_pck_desc|intmd_n2nd_imdg_pck_qty|intmd_n2nd_imdg_pck_cd|intmd_n2nd_imdg_pck_desc" +
				    "|max_in_pck_qty|max_in_pck_tp_cd|hcdg_pck_rstr_desc|hcdg_intmd_bc_rstr_desc|hcdg_tnk_rstr_desc|imdg_lmt_qty|imdg_lmt_qty_desc|imdg_lmt_qty_meas_ut_cd|imdg_expt_qty_cd|imdg_expt_qty_desc|imdg_spcl_provi_no" +
				    "|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|imdg_segr_grp_no|cfr_flg|grs_wgt|wgt_ut_cd|net_wgt" +
				    "|prp_shp_nm|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|hcdg_flg|rsd_flg|imdg_subs_rsk_lbl_rmk" +
				    "|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_expt_qty_flg" +
				    "|emer_cntc_phn_no|emer_cntc_pson_nm|certi_no" +
				    "|ems_no|ctrl_temp_ctnt|emer_rspn_gid_no|emer_rspn_gid_chr_no|emer_temp_ctnt" +
				    "|cnee_dtl_desc|net_explo_wgt|imdg_amdt_no|diff_rmk|auth_dt|auth_sts_cd|org_auth_sts_cd|spcl_cgo_auth_rjct_cd|spcl_cgo_auth_rmk|apro_ref_no|cgo_rqst_dt|dcgo_ref_no|org_dcgo_ref_no" +
				    "|Segregation Groups|Segregation Groups|Segregation Groups|Segregation Groups|cre_dt|auth_usr_id|dcgo_seq";
				    var headCount=ComCountHeadTitle(HeadTitle1);
	
				    SetConfig( { SearchMode:0, MergeSheet:5, DataRowMerge:1 } );
	
				    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				    InitHeaders(headers, info);
	
				    var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					              {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cntr_seq" },
					              {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_seq" },
					              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n1st_imdg_pck_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n1st_imdg_pck_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n1st_imdg_pck_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n2nd_imdg_pck_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n2nd_imdg_pck_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"out_n2nd_imdg_pck_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n1st_imdg_pck_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n1st_imdg_pck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n1st_imdg_pck_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n2nd_imdg_pck_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n2nd_imdg_pck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"in_n2nd_imdg_pck_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n1st_imdg_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n1st_imdg_pck_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n1st_imdg_pck_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n2nd_imdg_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n2nd_imdg_pck_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"intmd_n2nd_imdg_pck_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"max_in_pck_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"max_in_pck_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_pck_rstr_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_intmd_bc_rstr_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"hcdg_tnk_rstr_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_lmt_qty_meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              					              
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_spcl_provi_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"net_wgt",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rsd_flg",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n1st_imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n2nd_imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3rd_imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n4th_imdg_subs_rsk_lbl_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_sts_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mrn_polut_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_pson_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"certi_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ems_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_temp_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_chr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_temp_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_dtl_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_explo_wgt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_amdt_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"auth_dt",                    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"auth_sts_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_auth_sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_rjct_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_auth_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"apro_ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_rqst_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:12 },
				                  {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_dcgo_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc4",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"auth_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"edi_unmap_dtl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"unmap_cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
				                  ];
				    InitColumns(cols);
	
				    SetEditable(1);
				    SetSheetHeight(300);
				    SetVisible(false);
            	}
            	break;			   
	
        }
    } 
    /**
     * Initializing screen - Cargo
     * param : startObj ==> start object, endObj ==> end object, type ==> 1(only form object), 2(only IB Combo object), 3(all)
     */
    function clearObjAll(startObj, endObj, type) {
         try {
        	 var elems=document.form.elements;
        	 var startYn=false;
        	 for(var i=0; i < elems.length; i++) {
                 var elem=elems[i];
                 if(startObj == null || startObj.name == elem.name) startYn=true;
                 if(startYn) {
	                 if ((elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA') && (type == 1 || type == 3)) {
	                	 if(elem.name != '') {
	                		 if(elem.tagName == 'SELECT') {
	                			 elem.selectedIndex=0;
	                		 } else if(elem.tagName == 'TEXTAREA') {
	                			 elem.value="";
	                		 } else {
	                			 ComClearObject(elem);
	                		 }
	                	 }
	                 } else if (elem.tagName == 'OBJECT' && (type == 2 || type == 3)) {
	                	 var sObjId=elem.classid;
	                	 switch(sObjId){
		                     case CLSID_IBMCOMBO: //only IBMultiCombo
		                     	elem.SetSelectCode("-1",false);
		                        break;
		                 }
	                 }
                 }
                 if(endObj != null && endObj.name == elem.name) break;
        	 }
         } catch(err) { ComFuncErrMsg(err.message); }
         return;
    }
    /**
     * Initializing screen - All
     * param : sheetObj ==> sheet object, formObj ==> form object, what
     */
    function resetUI(sheetObj, formObj, what) {
    	var rgn_shp_opr_cd=ComGetObjValue(formObj.rgn_shp_opr_cd);
    	sheetObj.LoadSearchData("<SHEET><DATA TOTAL='0'></DATA></SHEET>",{Sync:1} );
//    	btnEnabled("init", false);
		if(what == 'new') {
	    	ComResetAll();
			comboObjects[0].RemoveAll();
			comboObjects[1].RemoveAll();
			comboObjects[2].RemoveAll();
			setEnableUI(document.form, document.form.cgo_opr_cd, pod_cd, 'enable');
    		document.getElementById("btn_Carrier").style.visibility="";
    		document.getElementById("btn_VVDpop").style.visibility="";
    		//Attach File button color change
    		chgBtnAttachFile(0);
    		resetForUnNo(formObj);
			ComSetObjValue(formObj.rgn_shp_opr_cd, rgn_shp_opr_cd);
			ComSetFocus(formObj.cgo_opr_cd);
		} else if(what == 'init') {
			sheetObjects[0].RemoveAll();

		}
		clearObjAll(spcl_cgo_seq, document.form.apro_ref_no, 3);
		setCgoSeq(sheetObjects[0], sheetObj);
		setEnableUI(document.form, spcl_cgo_seq, document.form.apro_ref_no, "disable");
		btnEnabled("add", true)
    }
    /**
     * Initializing screen - Information of UN No.
     * param : formObj ==> form object
     */
    function resetForUnNo(formObj) {
    	
    	ComSetObjValue(formObj.imdg_un_no_seq, 		    "");
    	ComSetObjValue(formObj.imdg_clss_cd, 		    "");
    	ComSetObjValue(formObj.imdg_comp_grp_cd, 	    "");
    	ComSetObjValue(formObj.prp_shp_nm, 			    "");
    	ComSetObjValue(formObj.hzd_desc, 			    "");
    	ComSetObjValue(formObj.imdg_pck_grp_cd, 	    "");
    	ComSetObjValue(formObj.psa_no, 				    "");
    	ComSetObjValue(formObj.hcdg_pck_rstr_desc, 		"");
    	ComSetObjValue(formObj.hcdg_intmd_bc_rstr_desc, "");
    	ComSetObjValue(formObj.hcdg_tnk_rstr_desc, 		"");
    	ComSetObjValue(formObj.imdg_lmt_qty, 		    "");
    	ComSetObjValue(formObj.imdg_lmt_qty_desc, 	    "");
    	ComSetObjValue(formObj.imdg_expt_qty_cd, 		"");
    	ComSetObjValue(formObj.imdg_expt_qty_desc, 		"");
    	ComSetObjValue(formObj.ems_no, 		            "");
    	ComSetObjValue(formObj.ctrl_temp_ctnt, 		    "");
    	ComSetObjValue(formObj.emer_rspn_gid_no, 		"");
    	ComSetObjValue(formObj.emer_rspn_gid_chr_no,    "");
    	ComSetObjValue(formObj.emer_temp_ctnt, 		    "");
    	ComSetObjValue(formObj.imdg_lmt_qty_meas_ut_cd, "");
    	ComSetObjValue(formObj.hcdg_flg,                "");
    	ComSetObjValue(formObj.imdg_subs_rsk_lbl_rmk,   "");
    	var formItems=new Array();
		formItems[0]="n1st";
		formItems[1]="n2nd";
		formItems[2]="n3rd";
		formItems[3]="n4th";
    	for(var i=0; i<4; i++) {		
			ComSetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd"), "");
		}
    	//Initializing Cargo Status value
    	dcgo_sts_cd.SetSelectCode("",false);
    	//Initializing Marin Pollutant value
    	mrn_polut_flg.SetSelectCode("N",false);
    	//Initializing Limited Q'ty value
    	imdg_lmt_qty_flg.SetSelectCode("N",false);
    	//Initializing Excepted Q'ty value
    	imdg_expt_qty_flg.SetSelectCode("N",false);
    	//Initializing HCDG/Remark(s) Button color
    	chgBtnHcdgRemarks('', '');
    	//Initializing Technical Name box
    	var itemObj=document.getElementById("hzd_desc"); 	
    	chgTecNmBox('', itemObj);
    	ComSetObjValue(formObj.imdg_spcl_provi_no, "");
    	//Initializing Flash Point value
    	ComSetObjValue(formObj.flsh_pnt_cdo_temp, "");	
    	//Flash Point status change decision
    	fixFlshPointForm(formObj); 
    	//Initializing Pre-Checking Report result
    	setPreChkRslt("N");
    }
//------------------------------------------------------------------------------//
/* Initializing process -- form event action */    
//------------------------------------------------------------------------------//     
    // Event handler processing by button name */
    function processButtonClick() {
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var sheetObj3=sheetObjects[2];
		var comboObj1=comboObjects[2];
		var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false; 
            switch(srcName) {
            	case "btn1_Retrieve":
            		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
            		break;
            
				case "btn2_Add":	
					if(sheetObj1.RowCount()== 0 || sheetObj1.GetSelectRow()== -1 || validateForm(sheetObj1,formObj,sheetObj1.GetSelectRow(),IBSEARCH_ASYNC03)) {	//Container info compulsory check
			    		if(sheetObj2.RowCount()== 0 || sheetObj2.GetSelectRow()== -1 || validateForm(sheetObj2,formObj,-1,IBSEARCH_ASYNC01)) {	//Cargo info compulsory check
							addCntrRow(sheetObj1);
							addCgoRow(sheetObj1, sheetObj2);
							checkPkgQty();
			    		}
					}
					break;		
				case "btn2_Delete":			
					delCntrRow(sheetObj1, sheetObj2);
					break;
				case "btn2_Copy":
					//onPopupClick(sheetObj1, formObj, srcName, "CopyCntr");
					copyCntr('1', 1, null);
					checkPkgQty();
					break;
				case "btn2_UN_Information":
					onPopupClick(sheetObj1, formObj, srcName, "UnInformation");
					break;				
				case "btn2_Restrictions":
					onPopupClick(sheetObj1, formObj, srcName, "Restrictions");
					break;
				case "btn2_Pre_Checking_Report":
					onPopupClick(sheetObj2, formObj, srcName, "PreChecking");
					break;
				case "btn_Un_No":	
					onPopupClick(sheetObj1, formObj, srcName, "btn_Un_No");
					break;
				case "btn2_Package_Qty_Type":
					onPopupClick(sheetObj2, formObj, srcName, "DgPkgQtyType");
					break;
				case "btn2_HCDG":
					//alert(srcName);
					break;
				case "btn2_Remark(s)":
					//alert(srcName);
					break;
				case "btn2_Other_Emergency_Information":
					onPopupClick(sheetObj2, formObj, srcName, "OtherEmerInfo");
					break;
				case "btn3_Remark":					
					onPopupClick(sheetObj2, formObj, srcName, "Remark");
					break;
				case "btn3_Row_Add":					
		    		if(validateForm(sheetObj2,formObj,-1,IBSEARCH_ASYNC01)) {	//Cargo info compulsory check  
		    			addCgoRow(sheetObj1, sheetObj2);
		    			checkPkgQty();
		    		}
		    		ctrlRowDeleteBtn();
					break;
				case "btn3_Row_Copy":
					if(validateForm(sheetObj2,formObj,-1,IBSEARCH_ASYNC01)) {	//Cargo info compulsory check  
						copyCargo(sheetObj1, sheetObj2, sheetObj2.GetSelectRow());
						checkPkgQty();
					}
					ctrlRowDeleteBtn();
					break;
				case "btn3_Row_Delete":
					delCgoRow(sheetObj2, sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "spcl_cntr_seq"), comboObj1.GetSelectCode());
					checkPkgQty();
					ctrlRowDeleteBtn();
					break;
//				case "btn_calendar":
//					var cal=new ComCalendar();
//		            cal.select(formObj.auth_dt, "yyyy-MM-dd"); 
//					break;
				case "btn1_Retrieve":
					doActionIBSheet(sheetObj2, formObj, IBSEARCH);
					break;
				case "btn1_New":
					resetUI(sheetObj1, formObj, "new");
					orgSheetObj=null;
					newYn=true;
					break;
				case "btn1_Attach_File":
					showUploadLayer(srcName);
            		break;
				case "btn1_Save":
					formObj.requestChk.value = "";
					doActionIBSheet(sheetObj2, formObj, IBBATCH);
					break;
				case "btn1_Request":
					formObj.requestChk.value = "R";
					doActionIBSheet(sheetObj2, formObj, IBBATCH);
					break;
				case "btn3_Request_Cancel":
					if(ComShowCodeConfirm("SCG50049", " cancel")) {
					    formObj.requestChk.value = "C";
					    doActionIBSheet(sheetObj2, formObj, IBBATCH);
					}
					break;
				case "btn1_Mail":
					onPopupClick(sheetObj2, formObj, srcName, "Mail");
					break;
				case "btn1_Close": case "btn1_OK":
					win_close(srcName, true);
					//ComClosePopup(closeYn); 
					break;
				//Pop-Up
				case "btn_Carrier":
	 				onPopupClick(sheetObj1, formObj, srcName, "Carrier");
	 				break;
				case "btn_VVDpop":
	 				onPopupClick(sheetObj1, formObj, srcName, "VVD");
	 				break;
				case "btn_fileAdd":
					fileAdd(sheetObj3, srcName);
	 				break;
				case "btn_fileDel":
					fileDel(sheetObj3, srcName);
	 				break;
				case "btn_fileClose":
					hideUploadLayer(sheetObj3);
	 				break;
    			case "btn_approval":
    				var param  = "f_cmd"+SEARCH;
    				    param += "&scg_flg=DG";
    				    param += "&bkg_no=" + formObj.bkg_ref_no.value;
    				    param += "&vsl_cd=" + formObj.vsl_cd.value;
    				    param += "&skd_voy_no=" + formObj.skd_voy_no.value;
    				    param += "&skd_dir_cd=" + formObj.skd_dir_cd.value;
    				if (document.getElementById("bkg_ref_no").value != "") {
    					ComOpenPopup("VOP_SCG_5822.do?"+param, 1000, 490, "", '0,0', true);
    				}
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
    // Handling business javascript OnFocus event
    function obj_focus() {
//    	switch(ComGetEvent("name")){ 
//	    	case "auth_dt":
//				ComClearSeparator (ComGetEvent());
//				ComSetFocus("auth_dt");
//				break;
//    	} 
    }
    
	function obj_keypress() {
		switch (event.srcElement.name) {
		case "grs_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "net_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "rada_amt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "net_explo_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "flsh_pnt_cdo_temp":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		case "imdg_un_no":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
		}
	}
    // Handling business javascript OnFocusOut event
    function obj_focusout() {
    	var sheetObj=sheetObjects[1];
    	with(ComGetEvent()) {
	    	switch(name) { 
		    	case "cgo_opr_cd":	
		    		searchCarrierCheck(ComGetEvent());	//Carrier Check
		        	break;
		    	case "skd_dir_cd":	
		    		searchVVDCheck();					//VVD Check
		        	break;	
		    	case "imdg_un_no":	
		    		searchUNNoCheck(ComGetEvent());		//UN No. Check
		        	break;
		    	case "grs_wgt":	case "net_wgt":	
		    		if(sheetObj.GetSelectRow() > 0){	//@@
		    			if(eval("document.form."+ComGetEvent("name")).value.length == 0){	//@@값이 없어지는 현상이 나서 일단 값이 있다면 변동 없도록 처리하였음
		    				ComSetObjValue(eval("document.form."+ComGetEvent("name")), sheetObj.GetCellText(sheetObj.GetSelectRow(), ComGetEvent("name")));
		    			}
			    		//상호 배제
			    		if(document.activeElement.id != 'grs_wgt' && document.activeElement.id != 'net_wgt') {
//			    			chkGrossNetWeight(ComGetEvent()); 
			    			chkGrossNetWeight(ComGetEvent("name"));
			    		}
		    		}
		        	break;
		    	case "wgt_ut_cd":
		    		ComSetObjValue(document.form.wgt_ut_cd2, event.srcElement.value);
		        	break;
		    	case "wgt_ut_cd2":	
		    		ComSetObjValue(document.form.wgt_ut_cd, event.srcElement.value);
		        	break;
//		    	case "auth_dt":
//		    		ComAddSeparator(ComGetEvent());
//		    		break;
		    	case "flsh_pnt_cdo_temp":	 
		    		if(ComChkObjValid(ComGetEvent())) {
		    			chkFlshPoint(ComGetEvent());
		    		}
		    		break;
		    	case "n1st_imdg_subs_rsk_lbl_cd":
		    		searchSubLabelCheck(ComGetEvent());
		    		break;
		    	case "n2nd_imdg_subs_rsk_lbl_cd":
		    		searchSubLabelCheck(ComGetEvent());
		    		break;
		    	case "n3rd_imdg_subs_rsk_lbl_cd":
		    		searchSubLabelCheck(ComGetEvent());
		    		break;
		    	case "n4th_imdg_subs_rsk_lbl_cd":
		    		searchSubLabelCheck(ComGetEvent());
		    		break;		    		
	    	}
    	}
    }
    // 업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	    	case "cgo_opr_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	    	case "bkg_no":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	    	case "vsl_cd":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	        	    	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;	   
	    	        case "imdg_un_no":	
	    	        	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "wgt_ut_cd": case "wgt_ut_cd2":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "emer_cntc_phn_no": case "emer_cntc_pson_nm": case "certi_no":
	    	        	ComKeyOnlyAlphabet('num','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|58|59|60|61|62|63|64|91|92|93|94|95|96|123|124|125|126');
	    	        	break;
	    	        case "apro_ref_no":
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
    	    	}
    	    	break;
    	    case "float":
	            ComKeyOnlyNumber(event.srcElement, "-.");
	            break;
    	    case "int":
	            ComKeyOnlyNumber(event.srcElement, "-");
	            break;
    	    default:
    	    	//ComKeyOnlyAlphabet("num");
    	    	break;     
    	}
    } 
	
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {  
    	var sheetObj = sheetObjects[1];
    	with(event.srcElement) {
	    	switch(name) { 
	    		case "grs_wgt":	case "net_wgt":	
	    			var wgtVal  = ComGetObjValue(eval("document.form."+name));
	        		var wgtVals = wgtVal.split("."); 
	        		if(wgtVals.length > 1 && wgtVals[1].length > 3) {
	        			wgtVal = wgtVal.substring(0,wgtVal.length-1);
	        			ComSetObjValue(eval("document.form."+name), wgtVal);
	        		}
//        			if(wgtVals[0].length > 15) {
//        				wgtVal = wgtVals[0].substring(0,wgtVals[0].length-1);
//        				if(wgtVals.length > 1) wgtVal = wgtVal + "." + wgtVals[1];
//        				ComSetObjValue(eval("document.form."+name), wgtVal);
//        			}
//        			var objMaxLength = ComReplaceStr(wgtVal.replace('.',''),',','').length;
//        			if(objMaxLength == 18) {
//        				if(name == 'grs_wgt') ComSetNextFocus(document.form.net_wgt);
//        				else ComSetNextFocus(document.form.prp_shp_nm);
//        			}
//	    			sheetObj.GetCellValue(sheetObj.GetSelectRow(), name) = ComGetObjValue(eval("document.form."+name));	    			
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), name, ComGetObjValue(eval("document.form."+name)) );	  
		        	break;
		        default:
		        	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
		        
		        	break;
	    	}
    	}
    }
    // Handling business javascript OnChange event
    function obj_change() {
    	var sheetObj=sheetObjects[1];
    	with(ComGetEvent()) {
	    	switch(name){
		    	case "vsl_cd": case "skd_voy_no":	
		    		var vsl_cd=ComGetObjValue(document.form.skd_voy_no);
		    		var skd_dir_cd=ComGetObjValue(document.form.skd_dir_cd);
	    			if(name == "vsl_cd") {
	    				ComSetObjValue(document.form.skd_voy_no, "");
		    			ComSetObjValue(document.form.skd_dir_cd, "");
	    			} else if(name == "skd_voy_no") {
	    				ComSetObjValue(document.form.skd_dir_cd, "");
	    			}
	    			comboObjects[0].RemoveAll();
	    			comboObjects[1].RemoveAll();
		        	break;	
		    	case "n1st_imdg_subs_rsk_lbl_cd": case "n2nd_imdg_subs_rsk_lbl_cd":	case "n3rd_imdg_subs_rsk_lbl_cd":	case "n4th_imdg_subs_rsk_lbl_cd":		
		    		if(ComChkObjValid(ComGetEvent())) {	//Float, Int Check
		    			fixFlshPointForm(document.form);	//Flash Point status change decision
		    		}
		        	break;
		    	case "bkg_ref_no":
		    		//2016-02-01 Sub Continent 가 MC/MS(중미/남미)일 경우에만 30자리 허용
		    		maxlength = document.form.bkg_ref_no.value.length;
		    		if(newpolScontiCd!=""){
			    		if(newpolScontiCd !="MC" && newpolScontiCd !="MS" && maxlength>12){
			    			ComShowCodeMessage('SCG50058');
			    			document.form.bkg_ref_no.value = "";
			    			maxlength = "";
			    		}
		    		}
		    		setPreChkRslt("N");
		    		break;
		    		case "vsl_cd": case "skd_voy_no": case "skd_dir_cd":
		    		//Initializing Pre-Checking Report result
		    		setPreChkRslt("N");
		    		break;
		    	case "auth_sts_cd":
		    		if(value == 'Y') {
		    			var psn_no=ComGetObjValue(document.form.psa_no);
		    			var flsh_temp=ComGetObjValue(document.form.flsh_pnt_cdo_temp);
		    			if(psn_no == '1' && flsh_temp != '' && parseInt(flsh_temp) < -25) {
		    				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC02);
		    			}
		    		}
//		    		setAuthStat(sheetObj, sheetObj.GetSelectRow(), value);
		    		break;
		    	case "imdg_un_no":	
		    		ComSetObjValue(document.form.imdg_un_no_seq, "");
		    		searchUNNoCheck(ComGetEvent());		//UN No. Check
		        	break;
		        
		        //2016-03-14
		    	case "diff_rmk":
		    		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "diff_rmk", $("#diff_rmk").val(), 0);
		    		break;
	    	}
    	}
    } 
    
    function auth_sts_cd_OnChange(){
 		var objVal		= $("#auth_sts_cd").val();
 		var formObj	= document.form;
 		var index 	= 9;

 		if(objVal == "A"){
 			
 			for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++){
 				sheetObjects[1].SetCellValue(i, "auth_sts_cd", "Y", 1);
    			setAuthStat				(sheetObj, i);
    			
    			comboObjects[index].SetSelectIndex(-1, true);
       			comboObjects[index].SetEnable(0);
			}
 			document.getElementById("spcl_cgo_auth_rmk").className	= "input"; 
 			//formObj.spcl_cgo_auth_rmk.value	= sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk");
 			formObj.spcl_cgo_auth_rmk.value="";
 			formObj.spcl_cgo_auth_rmk.disabled	= false;
 			
 		}else if(objVal == "N"){
 			if(rjtCode == "N") {	//최초 빈값을 셋팅한다 
 				comboObjects[index].DeleteItem(0);
 				rjtCode = "Y";
 			}
 			//comboObjects[index].SetSelectIndex(-1, false);
   		    comboObjects[index].SetEnable(1);
	    	comboObjects[index].SetBackColor("#CCFFFD");
	    	
	    	document.getElementById("spcl_cgo_auth_rmk").className	= "input";
	    	//formObj.spcl_cgo_auth_rmk.value	= sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk");
	    	formObj.spcl_cgo_auth_rmk.value="";
	    	formObj.spcl_cgo_auth_rmk.disabled	= false;
 		}else if(objVal == "P"){
 			if(rjtCode == "N"){	//최초 빈값을 셋팅한다 
 				//comboObjects[1].DeleteItem(0);
 				rjtCode = "Y";
 			}
 			comboObjects[index].SetSelectIndex(-1, false);
   		    comboObjects[index].SetEnable(0);
	    	document.getElementById("spcl_cgo_auth_rmk").className	= "input";
	    	//formObj.spcl_cgo_auth_rmk.value	= sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk");
	    	formObj.spcl_cgo_auth_rmk.value="";
	    	formObj.spcl_cgo_auth_rmk.disabled	= false;
 		}else{
 			if(rjtCode == "Y") {	//최초 빈값을 셋팅한다 
 				comboObjects[index].InsertItem(0, "", "");
 				rjtCode = "N";
 			}
   			comboObjects[index].SetSelectIndex(-1, true);
   			comboObjects[index].SetEnable(0);
   			if(objVal == "Y"){
   				document.getElementById("spcl_cgo_auth_rmk").className	= "input";
   				//formObj.spcl_cgo_auth_rmk.value	= sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk");
   				formObj.spcl_cgo_auth_rmk.value="";
   				formObj.spcl_cgo_auth_rmk.disabled	= false;	
   			}else{
   				//formObj.spcl_cgo_auth_rmk.value	= sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk");
   				formObj.spcl_cgo_auth_rmk.value="";
   				formObj.spcl_cgo_auth_rmk.disabled	= true;
   			}
   			
 		}
		
// 		if(isView){
//			document.getElementById("spcl_cgo_auth_rmk").className	= "input";
//			formObj.spcl_cgo_auth_rmk.disabled	= false;	
//			comboObjects[index].SetEnable(0);
// 		}
 		
 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "auth_sts_cd"			, objVal, 0);
 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", $("#spcl_cgo_auth_rjct_cd").val(), 0);
 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
     }
    
    
    function spcl_cgo_auth_rjct_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	
  		var formObj	= document.form;
  		if (newCode == "AAA") {
  			
 			document.getElementById("spcl_cgo_auth_rmk").className	= "input1";
 			//formObj.spcl_cgo_auth_rmk.value							= '';
 			formObj.spcl_cgo_auth_rmk.disabled						= false;
 			//ComSetNextFocus(document.formObj.spcl_cgo_auth_rmk);
 			
 			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", newCode	, 0);
 			
		}else{
			
 			document.getElementById("spcl_cgo_auth_rmk").className	= "input";
 			var rmk = comboObj.GetText(newCode, 1);
 			if(rmk != undefined) {
 				if(rmk == ""){
 					rmk = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk");
 				}
 			    formObj.spcl_cgo_auth_rmk.value						= rmk;
 			} else {
 				formObj.spcl_cgo_auth_rmk.value						= '';
 			}

 	 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", newCode	, 0);
 	 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, rmk		, 0); 	 		
 			formObj.spcl_cgo_auth_rmk.disabled						= true;
		}
  		
 		if(isView){
			document.getElementById("spcl_cgo_auth_rmk").className	= "input";
			formObj.spcl_cgo_auth_rmk.disabled	= false;	
 		}
		
     }
    
    
    function spcl_cgo_auth_rmk_OnChange() {	
    	
  		//if (sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd") == "AAA"){
  			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, document.form.spcl_cgo_auth_rmk.value, 0);
		//}
		
     }
    
    
    /**
     * Setting color according to approval code and reject code combo activation
     */
    function setAuthStat(sheetObj, row, auth)
    {
    	with(sheetObj)
    	{   
     		SetCellFont("FontBold", row, "auth_sts_cd",1);
			switch(auth)
			{
//				case "R": case "S":
//					SetCellFontColor(row, "auth_sts_cd","#FF862B");
//					SetCellEditable(row, "spcl_cgo_auth_rjct_cd",0);
//					break;
//				case "Y":
//					SetCellFontColor(row, "auth_sts_cd","#4D964B");
//					SetCellText(row, "spcl_cgo_auth_rjct_cd" ,"");
//					SetCellEditable(row, "spcl_cgo_auth_rjct_cd",0);
//					break;
				case "N":
					SetCellFontColor(row, "auth_sts_cd","#FF0000");
					SetCellEditable(row, "spcl_cgo_auth_rjct_cd",1);
					break;
				case "P":
					SetCellFontColor(row, "auth_sts_cd","#2663E0");
					SetCellEditable(row, "spcl_cgo_auth_rjct_cd",1);
					break;
			}
    		var rjctCd=GetCellText(row, "spcl_cgo_auth_rjct_cd");
			switch(rjctCd)
			{
				default:
					SetCellFontColor(row, "spcl_cgo_auth_rjct_cd","#FF0000");
					break;
			}
    	}
    }
    // Handling business javascript OnKeyUp event
    function obj_keyup() {  
    	var sheetObj = sheetObjects[1];
    	with(event.srcElement) {
	    	switch(name) { 
	    		case "grs_wgt":	case "net_wgt":	
	    			var wgtVal  = ComGetObjValue(eval("document.form."+name));
	        		var wgtVals = wgtVal.split("."); 
	        		if(wgtVals.length > 1 && wgtVals[1].length > 3) {
	        			wgtVal = wgtVal.substring(0,wgtVal.length-1);
	        			ComSetObjValue(eval("document.form."+name), wgtVal);
	        		}
//        			if(wgtVals[0].length > 15) {
//        				wgtVal = wgtVals[0].substring(0,wgtVals[0].length-1);
//        				if(wgtVals.length > 1) wgtVal = wgtVal + "." + wgtVals[1];
//        				ComSetObjValue(eval("document.form."+name), wgtVal);
//        			}
//        			var objMaxLength = ComReplaceStr(wgtVal.replace('.',''),',','').length;
//        			if(objMaxLength == 18) {
//        				if(name == 'grs_wgt') ComSetNextFocus(document.form.net_wgt);
//        				else ComSetNextFocus(document.form.prp_shp_nm);
//        			}
//	    			sheetObj.GetCellValue(sheetObj.GetSelectRow(), name) = ComGetObjValue(eval("document.form."+name));	    
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), name, ComGetObjValue(eval("document.form."+name)) );	 

		        	break;
		        default:
		        	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
		        
		        	break;
	    	}
    	}
    }
    // move focus - recieved prameter HTML tag (Object)'s next HTML tag (Object)
    function obj_nextfocus(obj) {
    	var objMaxLength=obj.getAttribute("maxlength");
    	var objValue=obj.getAttribute("value");
    	if (ComChkLen(objValue, objMaxLength) == 2) {    		
    		if(obj.name == 'vsl_cd') {
    			ComSetObjValue(document.form.skd_voy_no, "");
    			ComSetObjValue(document.form.skd_dir_cd, "");
			} else if(obj.name == 'skd_voy_no') {
				ComSetObjValue(document.form.skd_dir_cd, "");
			}
    		if(obj.name == 'skd_dir_cd' || obj.name == 'cgo_opr_cd') {
    			obj.blur();
    		} else {
    			ComSetNextFocus(obj);
    		}
    	}
    }
    // Handling business javascript OnKeyDown event
//    function obj_keydown() {
//    	if(event.keyCode == 13) {
//    		switch(event.srcElement.name) {
//    	    	case "rgn_shp_opr_cd": case "cgo_opr_cd": case "bkg_ref_no": case "vsl_cd": case "skd_voy_no": case "skd_dir_cd": case "pol_cd": case "pod_cd":
//    	    		var obj=document.getElementById("btn1_Retrieve");
//    	    		obj.fireEvent("onclick");
//    	    		break;
//    		}
//    	}
//    } 
    
    
    // parent window renewal about closing event
    function win_close(btnName, isClose) {
    	
    	if(preConds.pop_mode != 'view' && preConds.pId != "VOP_SCG_5001") {
    		if(!isClose) {
    			if(preConds.src_tp_cd != "EDI"){
    				parent.searchList();
    			}
    		}
    	} else if (preConds.pop_mode != 'view' && preConds.pId == "VOP_SCG_5001") { 
    		
    		if(btnName == "btn1_OK") {
//	    		var arrValues = new Array();
//	    		arrValues[0] = $("#auth_dt").val();
//	    		arrValues[1] = $("#auth_sts_cd").val();
//	    		arrValues[2] = $("#spcl_cgo_auth_rjct_cd").val();
//	    		arrValues[3] = $("#spcl_cgo_auth_rmk").val();
//	    		
//	    		arrValues[4] = $("#cgo_opr_cd").val();
//	    		arrValues[5] = $("#bkg_ref_no").val();
//	    		arrValues[6] = $("#vsl_cd").val();
//	    		arrValues[7] = $("#skd_voy_no").val();
//	    		arrValues[8] = $("#skd_dir_cd").val();
//	    		
//	    			
//	    		parent.setApproval(arrValues, sheetObjects[1]);

		    	 var oSheetObj = openerObj.sheetObjects[0];
		    	 var sheetCgo = sheetObjects[1]
		    	 var crr_cd             = "";
		    	 var bkg_ref_no         = "";
		    	 var spcl_cgo_rqst_seq  = "";
		    	 var spcl_cntr_seq      = "";
		    	 var spcl_cgo_seq       = "";
		    	 var prnr_cgo_rqst_seq  = "";
				 var chkFind = false;
				 var findStr            = ""; 
				 var oFindStr           = "";
				 
	    		for (var iRow=sheetCgo.HeaderRows(); iRow <= sheetCgo.LastRow(); iRow++) {
			    	 crr_cd             = document.form.crr_cd.value;
			    	 bkg_ref_no         = document.form.bkg_ref_no.value;
			    	 spcl_cgo_rqst_seq  = sheetCgo.GetCellValue(iRow, "spcl_cgo_rqst_seq");
			    	 spcl_cntr_seq      = sheetCgo.GetCellValue(iRow, "spcl_cntr_seq");
			    	 spcl_cgo_seq       = sheetCgo.GetCellValue(iRow, "spcl_cgo_seq");
			    	 prnr_cgo_rqst_seq  = sheetCgo.GetCellValue(iRow, "prnr_cgo_rqst_seq");
					 chkFind = false;
					 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.LastRow(); i++){
						 findStr = crr_cd + bkg_ref_no + spcl_cgo_rqst_seq + spcl_cntr_seq + spcl_cgo_seq + prnr_cgo_rqst_seq;
						 oFindStr = oSheetObj.GetCellValue(i, "t1sheet1_crr_cd") + 
						            oSheetObj.GetCellValue(i, "t1sheet1_bkg_ref_no") + 
						            oSheetObj.GetCellValue(i, "t1sheet1_spcl_cgo_rqst_seq") +
						            oSheetObj.GetCellValue(i, "t1sheet1_spcl_cntr_seq") +
						            oSheetObj.GetCellValue(i, "t1sheet1_spcl_cgo_seq") +
						            oSheetObj.GetCellValue(i, "t1sheet1_prnr_cgo_rqst_seq");
						 
						 if(findStr == oFindStr){
							 if(sheetCgo.GetCellValue(iRow, "auth_sts_cd")=="A")
								{
								 oSheetObj.SetCellValue(i, "t1sheet1_auth_sts_cd", "Y");
								}else{
								oSheetObj.SetCellValue(i, "t1sheet1_auth_sts_cd", sheetCgo.GetCellValue(iRow, "auth_sts_cd"),  0);	
							  }
							 oSheetObj.SetCellValue(i, "t1sheet1_spcl_cgo_auth_rjct_cd", sheetCgo.GetCellValue(iRow, "spcl_cgo_auth_rjct_cd"), 0);
							 oSheetObj.SetCellValue(i, "t1sheet1_spcl_cgo_auth_rmk", sheetCgo.GetCellValue(iRow, "spcl_cgo_auth_rmk"), 0);
							 parent.setAuthStat(oSheetObj, i, sheetCgo.GetCellValue(iRow, "spcl_cgo_auth_rmk"))
							 
							 //2016-03-11 
							 oSheetObj.SetCellValue(i, "t1sheet1_diff_rmk", sheetCgo.GetCellValue(iRow, "diff_rmk"), 0);
							 
							 
							 chkFind = true;
							 break;
						 }
					 }
					 if(chkFind == false){
						 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
							 findStr = crr_cd + bkg_ref_no + spcl_cgo_rqst_seq + spcl_cntr_seq + spcl_cgo_seq + prnr_cgo_rqst_seq;
							 oFindStr = oSheetObj.GetCellValue(i, "t1sheet1_crr_cd") + 
							            oSheetObj.GetCellValue(i, "t1sheet1_bkg_ref_no") + 
							            oSheetObj.GetCellValue(i, "t1sheet1_spcl_cgo_rqst_seq") +
							            oSheetObj.GetCellValue(i, "t1sheet1_spcl_cntr_seq") +
							            oSheetObj.GetCellValue(i, "t1sheet1_spcl_cgo_seq") +
							            oSheetObj.GetCellValue(i, "t1sheet1_prnr_cgo_rqst_seq"); 
							 if(findStr == oFindStr){
								 if(sheetCgo.GetCellValue(iRow, "auth_sts_cd")=="A")
									{
									 oSheetObj.SetCellValue(i, "t1sheet1_auth_sts_cd", "Y");
									}else{
									oSheetObj.SetCellValue(i, "t1sheet1_auth_sts_cd", sheetCgo.GetCellValue(iRow, "auth_sts_cd"),  0);	
								  }
								 oSheetObj.SetCellValue(i, "t1sheet1_spcl_cgo_auth_rjct_cd", sheetCgo.GetCellValue(iRow, "spcl_cgo_auth_rjct_cd"), 0);
								 oSheetObj.SetCellValue(i, "t1sheet1_spcl_cgo_auth_rmk", sheetCgo.GetCellValue(iRow, "spcl_cgo_auth_rmk"), 0);
								 parent.setAuthStat(oSheetObj, i, sheetCgo.GetCellValue(iRow, "spcl_cgo_auth_rmk"));
								 
								 //2016-03-11 
							     oSheetObj.SetCellValue(i, "t1sheet1_diff_rmk", sheetCgo.GetCellValue(iRow, "diff_rmk"), 0);
								 break;
							 }
						 }
					 }
					 
    			}
	    		
    		}
    	}
    	
    	if(isClose) {
    		if(preConds.src_tp_cd == "EDI" && closeYn ==  true){
    			parent.searchList();
    		}
    		ComClosePopup();	
    	}
    }
    
//------------------------------------------------------------------------------//
/* form event action -- sheet event action */    
//------------------------------------------------------------------------------//
	/**
     * Handling Sheet1 OnLoadFinish Event
     * param : sheetObj ==> sheet object
     * 
     */
//no support[check again]CLT 	function sheet1_OnLoadFinish(sheetObj) {	
	 	//Initializing Combo
	 	//searchTPSZList(sheetObj);	//Moved to LoadPage, because of ComOpenWait function collison
//	}
	/**
     * Handling Sheet2 OnLoadFinish Event
     * param : sheetObj ==> sheet object
     * 
     */
//no support[check again]CLT 	function sheet2_OnLoadFinish(sheetObj) {//Moved to LoadPage, because of ComOpenWait function collison
	 	//setPreCondition(sheetObj);
//	 	if(preConds.spcl_cgo_rqst_seq != '') {
//	 		doActionIBSheet(sheetObj, document.form, IBSEARCH);
//	 	} else {
//	 		var openerXml = window.dialogArguments.getAppDetlObj();
//	 		if(openerXml != null) {
//		 		sheetObj.LoadSearchXml(openerXml, true);
//	 		} else {
//	 			resetUI(sheetObj, document.form, "init");
//	 		}
//	 	}
//	}
    /**
     * Handling imdg_lmt_qty_flg MultiCombo OnLoadFinish Event
     * param : comboObj ==> combo object
     * 
     */
 //no support[check again]CLT 	function imdg_lmt_qty_flg_OnLoadFinish(comboObj) {	
    	 //initCombo(comboObj, comboObj.no);	//Moved to LoadPage, because of ComOpenWait function collison
// 	}
 	/**
     * Handling imdg_expt_qty_flg MultiCombo OnLoadFinish Event
     * param : comboObj ==> combo object
     * 
     */
 //no support[check again]CLT 	function imdg_expt_qty_flg_OnLoadFinish(comboObj) {	
    	 //initCombo(comboObj, comboObj.no);	//Moved to LoadPage, because of ComOpenWait function collison
// 	}
    /**
     * Handling mrn_polut_flg MultiCombo OnLoadFinish Event
     * param : comboObj ==> combo object
      * 
     */
  //no support[check again]CLT 	function mrn_polut_flg_OnLoadFinish(comboObj) {
     	 //initCombo(comboObj, comboObj.no);	//Moved to LoadPage, because of ComOpenWait function collison
//  	}
	/**
     * Handling Sheet2 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet2_OnSearchEnd(sheetCgo, ErrMsg) {
    	
    	 if(!closeYn) {
	    	 var sheetCntr=sheetObjects[0]; // container info
	    	 sheetCntr.RemoveAll();
	    	 
	    	 var preFix="";
	    	 if(preConds.pId == "VOP_SCG_5001") {
	    		 preFix = "t1sheet1_";
	    	 }else if(preConds.pId == "VOP_SCG_0022") {
	    		 preFix = "t1sheet1_";
	    	 }else{
	    		 preFix = "";
	    	 }
	    	 var oSheetObj=openerObj.sheetObjects[0];
	    	 var crr_cd             = "";
	    	 var bkg_ref_no         = "";
	    	 var spcl_cgo_rqst_seq  = "";
	    	 var spcl_cntr_seq      = "";
	    	 var spcl_cgo_seq       = "";
	    	 var prnr_cgo_rqst_seq  = "";
			 var chkFind = false;
			 var findStr            = ""; 
			 var oFindStr           = "";
	    	 // cargo info
	    	 with (sheetCgo) {
	    		if(RowCount()!= 0) {
	    			var cntrSeq, nextCntrSeq, authStsCd;
	    			var yCt=0, nCt=0, rCt=0;
	    			for (var iRow=HeaderRows(); iRow <= LastRow(); iRow++) {
	    				cntrSeq=GetCellValue(iRow, "spcl_cntr_seq");
	    				authStsCd=GetCellValue(iRow, "auth_sts_cd");
	    				if(cntrSeq != nextCntrSeq) {
	    					sheetCntr.DataInsert(-1,0);
	    					sheetCntr.SetCellValue(sheetCntr.GetSelectRow(), "spcl_cntr_seq",cntrSeq,0);
	    					sheetCntr.SetCellValue(sheetCntr.GetSelectRow(), "cntr_ref_no",GetCellValue(iRow, "cntr_ref_no"),0);
	    					if(GetCellValue(iRow, "edi_unmap_dtl_cd") != ""){
	    						sheetCntr.SetCellBackColor(sheetCntr.GetSelectRow(), "cntr_ref_no", "#FFD8D8")
	    					}
	    					if(GetCellValue(iRow, "edi_unmap_dtl_cd") == "101"){
	    						sheetCntr.SetCellValue(sheetCntr.GetSelectRow(), "unmap_cntr_tpsz_cd",GetCellValue(iRow, "unmap_cntr_tpsz_cd"),0);
	    					}
	    					sheetCntr.SetCellValue(sheetCntr.GetSelectRow(), "cntr_tpsz_cd",GetCellValue(iRow, "cntr_tpsz_cd"),0);
	    					findFirstRowCgo(sheetCntr, sheetCntr.GetSelectRow(), sheetCgo);
	    				}
	    				nextCntrSeq=cntrSeq;
	    				if(authStsCd == 'Y') yCt++;
	    				else if(authStsCd == 'N') nCt++;
	    				else if(authStsCd == 'R') rCt++;
	    				sheetCgo.SetCellValue(iRow, "org_auth_sts_cd",authStsCd,0);
	    				
	    				//if(preConds.pId == "VOP_SCG_5001"){
	    					crr_cd             = document.form.crr_cd.value;
					    	 bkg_ref_no         = document.form.bkg_ref_no.value;
					    	 spcl_cgo_rqst_seq  = sheetCgo.GetCellValue(iRow, "spcl_cgo_rqst_seq");
					    	 spcl_cntr_seq      = sheetCgo.GetCellValue(iRow, "spcl_cntr_seq");
					    	 spcl_cgo_seq       = sheetCgo.GetCellValue(iRow, "spcl_cgo_seq");
					    	 prnr_cgo_rqst_seq  = sheetCgo.GetCellValue(iRow, "prnr_cgo_rqst_seq");
							 chkFind = false;
							 
							 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.LastRow(); i++){
								 findStr = crr_cd + bkg_ref_no + spcl_cgo_rqst_seq + spcl_cntr_seq + spcl_cgo_seq + prnr_cgo_rqst_seq;
								 oFindStr = oSheetObj.GetCellValue(i, preFix+"crr_cd") + 
								            oSheetObj.GetCellValue(i, preFix+"bkg_ref_no") + 
								            oSheetObj.GetCellValue(i, preFix+"spcl_cgo_rqst_seq") +
								            oSheetObj.GetCellValue(i, preFix+"spcl_cntr_seq") +
								            oSheetObj.GetCellValue(i, preFix+"spcl_cgo_seq") +
								            oSheetObj.GetCellValue(i, preFix+"prnr_cgo_rqst_seq");
								 if(findStr == oFindStr){
									 sheetCgo.SetCellValue(iRow, "auth_sts_cd",     oSheetObj.GetCellValue(i, preFix+"auth_sts_cd"), 0);
									 sheetCgo.SetCellValue(iRow, "org_auth_sts_cd", oSheetObj.GetCellValue(i, preFix+"auth_sts_cd"), 0);
									 sheetCgo.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
									 sheetCgo.SetCellValue(iRow, "spcl_cgo_auth_rmk", oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
									 
									 //2016-03-11 
									 sheetCgo.SetCellValue(iRow, "diff_rmk", oSheetObj.GetCellValue(i, preFix+"diff_rmk"), 0);
									 
									 
									 chkFind = true;
									 break;
								 }
							 }
							 if(chkFind == false){
								 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
									 findStr = crr_cd + bkg_ref_no + spcl_cgo_rqst_seq + spcl_cntr_seq + spcl_cgo_seq + prnr_cgo_rqst_seq;
									 oFindStr = oSheetObj.GetCellValue(i, preFix+"crr_cd") + 
									            oSheetObj.GetCellValue(i, preFix+"bkg_ref_no") + 
									            oSheetObj.GetCellValue(i, preFix+"spcl_cgo_rqst_seq") +
									            oSheetObj.GetCellValue(i, preFix+"spcl_cntr_seq") +
									            oSheetObj.GetCellValue(i, preFix+"spcl_cgo_seq") +
									            oSheetObj.GetCellValue(i, preFix+"prnr_cgo_rqst_seq"); 
									 if(findStr == oFindStr){
										 sheetCgo.SetCellValue(iRow, "auth_sts_cd",     oSheetObj.GetCellValue(i, preFix+"auth_sts_cd"), 0);
										 sheetCgo.SetCellValue(iRow, "org_auth_sts_cd", oSheetObj.GetCellValue(i, preFix+"auth_sts_cd"), 0);
										 sheetCgo.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
										 sheetCgo.SetCellValue(iRow, "spcl_cgo_auth_rmk", oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
										 
										 //2016-03-11 
										 sheetCgo.SetCellValue(iRow, "diff_rmk", oSheetObj.GetCellValue(i, preFix+"diff_rmk"), 0);
										 
										 break;
									 }
								 }
							 }
	    				//}

	    			}
	    			//sheetCntr.SelectCell(1, "cntr_ref_no");
	    			//sheetCgo.SelectCell(1, "cntr_ref_no");
	    			//insert item control according to verification status
	    			var noEditFlg=true;
					for ( var cRow=sheetCntr.HeaderRows(); cRow <= sheetCntr.LastRow(); cRow++) {
						var fstRow=sheetCgo.FindText("spcl_cntr_seq", sheetCntr.GetCellValue(cRow, "spcl_cntr_seq"), 0, -1, true);
						noEditFlg=true;
						for(var cntrCt=fstRow; cntrCt<=sheetCgo.LastRow(); cntrCt++) {
							if(sheetCgo.GetCellValue(cntrCt, "spcl_cntr_seq") != sheetCntr.GetCellValue(cRow, "spcl_cntr_seq")) break;
							if(sheetCgo.GetCellValue(cntrCt, "org_auth_sts_cd") != 'P') noEditFlg=false;
						}
						if(noEditFlg) {
							sheetCntr.SetCellEditable(cRow, "cntr_ref_no",0);
							sheetCntr.SetCellEditable(cRow, "cntr_tpsz_cd",0);
						}
					}
//					모든 cargo의 상태를 체크할 필요가 없다.
//	    			if(rCt == 0) {  
	    				btnEnabled("view", false);
	    				if(preConds.pop_mode != 'view') preConds.pop_mode="noedit";
//	    			} 
//	    			if((yCt+nCt) > 0) {
//	    				setEnableUI(document.form, comboObjects[0], comboObjects[1], "disable");
//	    			}else{
//	    				btnEnabled("view", false);
//	    				if(preConds.pop_mode != 'view') preConds.pop_mode="noedit";
//	    			}
	    			//pre load Cargo optional
	    			if(preConds.spcl_cntr_seq != '') {
	    				sheetCntr.SelectCell(sheetCntr.FindText("spcl_cntr_seq",preConds.spcl_cntr_seq),"cntr_ref_no");
	    				comboObjects[2].SetSelectCode(preConds.spcl_cgo_seq, false);
	    				//spcl_cgo_seq.SetSelectCode(preConds.spcl_cgo_seq, false);
	    				spcl_cgo_seq_OnChange(spcl_cgo_seq, null, null, null, null, null, preConds.spcl_cgo_seq);
	    				preConds.spcl_cntr_seq='';
	    				preConds.spcl_cgo_seq='';
	    			}
	    		} else {
	    			sheetCntr.LoadSearchData("<SHEET><DATA TOTAL='0'></DATA></SHEET>",{Sync:1} );
	    			clearObjAll(spcl_cgo_seq, document.form.apro_ref_no, 3);
	    			setCgoSeq(sheetCntr, sheetCgo);
	    			setEnableUI(document.form, spcl_cgo_seq, document.form.apro_ref_no, "disable");
//	    			btnEnabled("init", false);
	    		}
	    	 }
	    	 
	    	 //maintain original info before editing
	    	 orgSheetObj	= IBS_GetDataSearchXml(sheetCgo);
	    	 setOrgFormInfo	(document.form);
	    	 
	    	 //:2015-12-29:Move to sheet4_OnSearchEnd://changeValue();
	    	 
    	 } else {
    		 if(window.dialogArguments!=undefined)
    		 window.dialogArguments.setResultPop(orgFormObj, sheetCgo);
    	 }
    }
    
    /**
     * Handling Sheet3 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> error message
     * 
     */
  	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {	
  		changeValue('sheet4_OnSearchEnd');		//:2015-12-29:from to sheet2_OnSearchEnd://
  	}
    

    function changeValue(fromEvent) {
    	
    	/** sheet4_OnSearchEnd : sheet1_OnSelectCell : spcl_cgo_seq_OnChange **/
    	//alert(fromEvent);
    	
		if(preConds.pId == "VOP_SCG_5001"){
			
			var curRowIdx = sheetObjects[1].GetSelectRow();
			//alert('fromEvent ['+fromEvent+']  curRowIdx ['+curRowIdx+']');
			
			//==============================================================================================//
			
			// 변경check 항목에 해당하는 cell의 value를 비교하여, 변경되었을 경우, font색상을 red로 변경한다.
			for(var i=0;i<arrAutoReqItem.length;i++) {
				var isMatchedDcgoSeq	= "NOT_MATCHED";
				
				////for(var cur=rowIdx; cur<=sheetObjects[1].RowCount(); cur++){
				////for(var cur=rowIdx; cur<=rowIdx; cur++){
							
					for(var pre=1; pre<=sheetObjects[3].RowCount(); pre++){
					
						if(sheetObjects[1].GetCellValue(curRowIdx, "dcgo_seq") == sheetObjects[3].GetCellValue(pre, "dcgo_seq")){
							
							isMatchedDcgoSeq	= "MATCHED";
							
							//if(i==0)	alert('pre ['+pre+'] VS curRowIdx ['+curRowIdx+']');
	
						    var before 	= sheetObjects[3].GetCellValue(pre		, arrAutoReqItem[i].name);
						    var current = sheetObjects[1].GetCellValue(curRowIdx, arrAutoReqItem[i].name);
						    
						    //alert('pre ['+pre+'] VS curRowIdx ['+curRowIdx+'] >>> i ['+i+'] <<<   before ['+sheetObjects[3].GetCellValue(pre, arrAutoReqItem[i].name)+'] --- current ['+sheetObjects[1].GetCellValue(curRowIdx, arrAutoReqItem[i].name)+']');
						    
						    if(before == -1) break;
						    
						    //if(before != current)	alert('pre ['+pre+'] VS curRowIdx ['+curRowIdx+'] >>> before ['+sheetObjects[3].GetCellValue(pre, arrAutoReqItem[i].name)+'] --- current ['+sheetObjects[1].GetCellValue(curRowIdx, arrAutoReqItem[i].name)+']');
							
						    
//						    var current = sheetObjects[1].GetCellValue(rowIdx, arrAutoReqItem[i].name);
//						    var before 	= sheetObjects[3].GetCellValue(rowIdx, arrAutoReqItem[i].name);
						    
						    //if(rowIdx == "1")	alert('before ['+before+'] VS current ['+current+'] rowIdx << '+rowIdx+' >> item << '+arrAutoReqItem[i].name+' >>');
						    
						    if(before != current){
						    	document.getElementById(arrAutoReqItem[i].name).style.color	= "red";
						    }else{
						    	document.getElementById(arrAutoReqItem[i].name).style.color	= "black";
						    }
	
	
							
						}		//END OF IF//
						
					}
					
				////}	

				//alert('cur ['+cur+'] VS pre ['+pre+'] isMatchedDcgoSeq ['+isMatchedDcgoSeq+']');
				if(isMatchedDcgoSeq == "NOT_MATCHED" && sheetObjects[3].RowCount() == 0){
					for(var i=0;i<arrAutoReqItem.length;i++) {
						document.getElementById(arrAutoReqItem[i].name).style.color	= "black";
					}
				}else if(isMatchedDcgoSeq == "NOT_MATCHED" && sheetObjects[3].RowCount() > 0){
					for(var i=0;i<arrAutoReqItem.length;i++) {
						document.getElementById(arrAutoReqItem[i].name).style.color	= "blue";
					}
					
				}
				
			}
			//==============================================================================================//			
			
		}
    }
    
    
    /**
     * Handling Sheet3 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> error message
     * 
     */
  	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {	
  	 	with(sheetObj) {
  	 		for(var rowIdx=HeaderRows(); rowIdx<=LastRow(); rowIdx++) {
  	 			SetCellValue(rowIdx, "spcl_cgo_irr_file_seq",GetCellValue(rowIdx, "spcl_cgo_rqst_atch_file_seq"),0);
  	 		}
  	 		//button color change
  	 		chgBtnAttachFile(RowCount());
  	 	}
  	}
	/**
     * Handling Sheet1 Cell Select Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected Row ==> NewRow, selected Col ==> NewCol
     * note  : Restrect event when rolling back because of validation. (see - callBack)
     */
    var callBack=true;	
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	if(callBack && NewRow != OldRow) {
    		//before setting Container info, below function is needless
    		if(sheetObj.GetCellValue(NewRow, "spcl_cntr_seq") != '') {
	    		var requiredChk=false;
	    		//Container info compulsory check
	    		if(sheetObj.GetRowStatus(OldRow) != '' && OldRow != 0 && !validateForm(sheetObj,document.form,OldRow,IBSEARCH_ASYNC03)) {
	    			requiredChk=true;	    			
	    		}
	    		//Cargo info compulsory check   - exception)screen Reset
	    		if(!requiredChk) {
	    			if(sheetObj.RowCount()!= 0 && !validateForm(sheetObj,document.form,-1,IBSEARCH_ASYNC01)) {
		    			requiredChk=true;
		    		}
	    		}
	    		if(requiredChk) {	    			
	    			callBack=false;
	    			sheetObj.SelectCell(OldRow, "spcl_cntr_seq");
	    			callBack=true;
	    			return;
	    		}
	    		//Delete, Copy button activate
//	    		btnEnabled('init', true);
	    		var sheetCgo=sheetObjects[1];
	    		var isCgoSeq=findMaxCgoRow(sheetCgo, sheetObj.GetCellValue(NewRow, "spcl_cntr_seq"));
	    		if(isCgoSeq == 0) {
	    			clearObjAll(spcl_cgo_seq, document.form.apro_ref_no, 3);
	    			setEnableUI(document.form, spcl_cgo_seq, document.form.apro_ref_no, "disable");
	    			sheetCgo.SelectCell(1, "spcl_cgo_seq");
	    		} else {
	    			var isDisabled=document.form.cntr_cgo_seq_sum.disabled;
	    			if(isDisabled) {
	    				
	    				setEnableUI(document.form, spcl_cgo_seq, document.form.apro_ref_no, "enable");    			
	    			} else {
	    				if(preConds.pId == "VOP_SCG_0022"){
	    					setFormToSheetAll(sheetCgo, sheetCgo.GetSelectRow(), document.form.imdg_clss_cd, document.form.spcl_cgo_auth_rmk);	
	    				}
	    			}
	    			clearObjAll(spcl_cgo_seq, document.form.apro_ref_no, 3);
	    			findFirstRowCgo(sheetObj, NewRow, sheetCgo);
	    		}
    		}
    		// :: 2015-11-26 CNTR Seq 변경 시 
    		class1Only();
    		displayEDI();
    		
    		changeValue('sheet1_OnSelectCell');
    	}
	}
    /**
     * Handling Sheet2 Cell Select Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==>before selecting Col, selected Row ==> NewRow, selected Col ==> NewCol
     * 
     */
    var cgoSelBlk=false;
    function sheet2_OnSelectCell(sheetCgo, OldRow, OldCol, NewRow, NewCol) {
    	if(!cgoSelBlk) {
	    	 with (sheetCgo) {
	    		 var status=GetRowStatus(NewRow);
		    	 if(RowCount()!= 0 && status != 'D') {
			    	 //setEnableUI(document.form, spcl_cgo_seq, document.form.diff_rmk, "enable");
			    	 setCgoSeq(sheetObjects[0], sheetCgo);
			    	 //setSheetToFormAll(sheetCgo, NewRow, spcl_cgo_seq, document.form.spcl_cgo_auth_rmk);//spcl_cgo_auth_rmk
		    		 setSheetToFormAll(sheetCgo, NewRow, document.form.cntr_cgo_seq_sum, document.form.spcl_cgo_auth_rmk);//spcl_cgo_auth_rmk
			    	 fileAttachCnt(sheetObjects[2]);
			    	 // 5001의 경우, parent에서 넘어온 값으로 재설정
			    	 // :: 2015-11-26 Cargo Seq.변동시 Class Only 1
			    	 class1Only();
			    	 selectApvl(sheetCgo, NewRow);
		    		 auth_sts_cd_OnChange(sheetCgo, NewRow);
			    	 if(preConds.src_tp_cd == 'EDI') {
			    		 setUnmappedItem(sheetCgo, NewRow);
			    	 }
		    	 }
	    	 }
    	 }
	}
    
    function selectApvl(sheetObj, NewRow) {
    	
    	// APVL의 경우, 화면으로 부터 auth_sts_cd, spcl_cgo_auth_rjct_cd를 받는다.(IF)
        if(preConds.pId == "VOP_SCG_5001") {
        	var authStsCd = sheetObj.GetCellValue(NewRow, "auth_sts_cd");//preConds.auth_sts_cd;
        	if(authStsCd != "") {
        		if(authStsCd.substring(0, 1) == 'S') {
        			authStsCd = authStsCd.substring(0, 2); //SR
        		} else {
        			authStsCd = authStsCd.substring(0, 1);
        		}
        	}
        	
        	document.form.auth_sts_cd.value = authStsCd;
	       	//sheetObj.SetCellValue(NewRow, "auth_sts_cd",authStsCd,0);
	       	if(document.form.auth_sts_cd.value == 'N') {
	       		comboObjects[9].SetEnable(true); //spcl_cgo_auth_rjct_cd
		       	//comboObjects[9].SetSelectCode(preConds.spcl_cgo_auth_rjct_cd,true);
	       		//spcl_cgo_auth_rjct_cd_OnChange(comboObjects[9], '', '', '', '', '', preConds.spcl_cgo_auth_rjct_cd);
//	       		if(preConds.spcl_cgo_auth_rmk != undefined) {
//	       			document.form.spcl_cgo_auth_rmk.value=preConds.spcl_cgo_auth_rmk;
//	       		}
	       	}
	       	comboObjects[9].SetSelectCode(sheetObj.GetCellValue(NewRow, "spcl_cgo_auth_rjct_cd"),false);
       		spcl_cgo_auth_rjct_cd_OnChange(comboObjects[9], '', '', '', '', '', sheetObj.GetCellValue(NewRow, "spcl_cgo_auth_rjct_cd"));
        }
    }
    
//    /**
//     * Handling Sheet1 OnKeyUp Event
//     * param : sheetObj ==> sheet object, before selecting Row ==> Row, selected Col ==> Col
//     * 
//     */
//    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
//  		with(sheetObj) { 
//  			if(ColSaveName(Col) == "cntr_ref_no") {
//  				var sheetObj2=sheetObjects[1];
//  				var cntrSeq;
//  				for(var i=sheetObj2.HeaderRows(); i<=sheetObj2.LastRow(); i++) {
//  					cntrSeq=sheetObj2.GetCellValue(i, "spcl_cntr_seq");
//  					if(cntrSeq == GetCellValue(Row, "spcl_cntr_seq")) {
//  						sheetObj2.SetCellValue(i, ColSaveName(Col),GetEditText().toUpperCase(),0);
//  				}
//  	    	}
//   		}
//    } 
    
    
    /**
     * Handling Sheet1 Combo Change Event 
     * param : sheetObj ==> sheet object, edited Row ==> Row, edited Col ==> Col, Value ==> Grid Cell Value
     * 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	 with(sheetObj) { 
    		var sheetCgo=sheetObjects[1];
	    	if(ColSaveName(Col) == "cntr_tpsz_cd") {
  				var cntrSeq;
  				for(var i=sheetCgo.HeaderRows(); i<=sheetCgo.LastRow(); i++) {
  					cntrSeq=sheetCgo.GetCellValue(i, "spcl_cntr_seq");
  					if(cntrSeq == GetCellValue(Row, "spcl_cntr_seq")) sheetCgo.SetCellValue(i, ColSaveName(Col),GetCellValue(Row, Col),0);
  				}
	    	} else if(ColSaveName(Col) == "diff_rmk") {
	    		ComSetObjValue(document.form.diff_rmk, sheetCgo.GetCellValue(Row, Col));
	    	} else if(ColSaveName(Col) == "cntr_ref_no") {
  				var cntrSeq;
  				for(var i=sheetCgo.HeaderRows(); i<=sheetCgo.LastRow(); i++) {
  					cntrSeq=sheetCgo.GetCellValue(i, "spcl_cntr_seq");
  					if(cntrSeq == GetCellValue(Row, "spcl_cntr_seq")) sheetCgo.SetCellValue(i, ColSaveName(Col),GetCellValue(Row, Col),0);
  				}
	    	}
    	 }
	}
    /**
     * Handling Sheet2 Cell Change Event
     * param : sheetObj ==> sheet object, edited Row ==> Row, edited Col ==> Col, Value ==> Grid Cell Value
     * 
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
     	 with(sheetObj) { 
 	    	if(ColSaveName(Col) == "diff_rmk") {
 	    		ComSetObjValue(document.form.diff_rmk, sheetObjects[1].GetCellValue(Row, Col));
 	    	}
     	 }
 	}
    /**
     * Handling POL Combo Change Event
     * param : comboObj ==> combo object, edited Code ==> Code, edited Text ==> Text
     * 
     */

    function pol_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode, formObj) {
    	
    	var arrPolCd = noPolCd.split(',');
    	if(arrPolCd != '') {
	    	for(var i=0;i<arrPolCd.length-1;i++) {
	    		var value = arrPolCd[i].split('.');
	    		if(value[0] == newCode) {
	    			ComShowCodeMessage('SCG50004', newCode + " [" + value[1] + "]");
	    			eval("pol_cd").SetSelectCode("", false);
	    			return false;
	    		}
	    	}
    	}
    	//2016-02-01 RSO, SubContinet Unmapping 처리
    	var rsoCd=preConds.rgn_shp_opr_cd; // 0022 에서 선택한 RSO 
    	newpolScontiCd = polScontiCd[newIndex] //새로 선택하는 POL에 대한 Sub Continent 
    	//polRsoCd[newIndex] : POL 이 속한 RSO 
    	//polScontiCd[newIndex] : POL이 속한 Sub Continent
    	if(rsoCd !=polRsoCd[newIndex]){
    		if(preConds.src_tp_cd == 'EDI') {
    			if(rsoCd == ""){
    				document.form.rgn_shp_opr_cd.value = polRsoCd[newIndex];	
    			}
    		}else{
        		ComShowCodeMessage('SCG50057', rsoCd, newText);
        		eval("pol_cd").SetSelectCode("", false);
        		eval("pod_cd").SetSelectCode("", false);
        		return false;    			
    		}
    	}
    	//2016-02-03 RSO에서 Port 가 지워지는 경우, 먼저 RSO 등록하라는 msg.
    	if(rsoDelFlg[newIndex]=="Y"){
    		ComShowCodeMessage('SCG50059', newText);
    		eval("pol_cd").SetSelectCode("", false);
    		eval("pod_cd").SetSelectCode("", false);
    		return false;
    	}
    	
    	//2016-02-01 BKG_REF_NO 먼저 입력하고 나서 POL 변경 시 SubContinet별 BKG_REF_NO 체크

    	if(newpolScontiCd !="MC" && newpolScontiCd != "MS" && maxlength > 12){
			ComShowCodeMessage('SCG50058');
			document.form.bkg_ref_no.value = "";
			maxlength = "";
    	}
    	searchETADt(newCode);	//ETA Dt retrieve
 		doActionIBCombo(sheetObjects[1], comboObjects[1], 2, newCode);	//POD retrieve
 		//Initializing Pre-Checking Report result
		setPreChkRslt("N");
    }
    /**
     * Handling POD Combo Change Event
     * param : comboObj ==> combo object, edited Code ==> Code, edited Text ==> Text
     * 
     */
    function pod_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode, formObj) {
    	//Initializing Pre-Checking Report result
    	var arrPodCd = noPodCd.split(',');
    	if(arrPodCd != '') {
	    	for(var i=0;i<arrPodCd.length-1;i++) {
	    		var value = arrPodCd[i].split('.');
	    		if(value[0] == newCode) {
	    			ComShowCodeMessage('SCG50004', newCode + " [" + value[1] + "]");
	    			eval("pod_cd").SetSelectCode("", false);
	    			return false;
	    		}
	    	}
    	}
		setPreChkRslt("N");
    }
    /**
     * Handling Cargo Seq. Combo OnChange Event
     * param : comboObj ==> combo object, edited Code ==> Code, edited Text ==> Text
     * 
     */
    function spcl_cgo_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {  
    	//alert('comboObj ['+comboObj+'] oldIndex ['+oldIndex+'] oldText ['+oldText+'] oldCode ['+oldCode+'] newIndex ['+newIndex+'] newText ['+newText+'] newCode ['+newCode+'] VS. preCgoSeq ['+preCgoSeq+']');
    	
    	////:2015-12-28:by TOP:////if(newCode != preCgoSeq) {
    		
	    	if(oldIndex == null || validateForm(sheetObjects[1],document.form,-1,IBSEARCH_ASYNC01)) {	//Cargo info compulsory check
		    	var sheetObj1	= sheetObjects[0];
		    	var sheetObj2	= sheetObjects[1];
		    	
		    	if(preConds.pId == "VOP_SCG_0022"){
		    		setFormToSheetAll(sheetObj2, sheetObj2.GetSelectRow(), document.form.dcgo_ref_no, document.form.spcl_cgo_auth_rjct_cd);	
		    	}
		    	var selCntrSeq	= sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "spcl_cntr_seq");
		    	var fstRow		= sheetObj2.FindText	("spcl_cntr_seq", selCntrSeq, 0, -1, true);
		    	var cntrSeq, cgoSeq;
		    	
				for(var startIdx=fstRow; startIdx<=sheetObj2.LastRow(); startIdx++) {
					cntrSeq	= sheetObj2.GetCellValue(startIdx, "spcl_cntr_seq");
					cgoSeq	= sheetObj2.GetCellValue(startIdx, "spcl_cgo_seq");
					if(selCntrSeq == cntrSeq && newCode == cgoSeq) {
						sheetObj2.SelectCell(startIdx, "spcl_cntr_seq");
					}
				}
				preCgoSeq	= newCode;
				
	    	} else {
	    		comboObj.SetSelectCode(oldCode, false);
	    	}
	    	fileAttachCnt	(sheetObjects[2]);
	    	initApvl		();
	    	checkPkgQty		();
	    	displayEDI		();
	    	
	    ////:2015-12-28:by TOP:////}
    	
    	changeValue			('spcl_cgo_seq_OnChange');
    }
    /**
     * Handling Cargo Seq. Combo OnFocus Event
     * param : comboObj ==> combo object
     * 
     */
    var preCgoSeq;
    function spcl_cgo_seq_OnFocus(comboObj) {
    	preCgoSeq	= comboObj.GetSelectCode();
    }
    /**
     * Handling Limited Q'ty Combo OnChange Event
     * param : comboObj ==> combo object, edited Code ==> Code, edited Text ==> Text
     * 
     */
    function imdg_lmt_qty_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {  
    	var formObj=document.form;
    	var sheetObj=sheetObjects[1];
    	var imdg_un_no=ComGetObjValue(formObj.imdg_un_no);
    	var imdg_un_no_seq=ComGetObjValue(formObj.imdg_un_no_seq);
    	if(imdg_un_no.length > 0 && newCode == 'Y') {
    		var sXml=searchUnNoInfo(sheetObj, imdg_un_no, imdg_un_no_seq);
    		var sArr1=ComScgXml2Array(sXml, "imdg_lmt_qty");
    		var sArr2=ComScgXml2Array(sXml, "imdg_lmt_qty_desc");
			if(sArr1 != null) {
				var imdg_lmt_qty=sArr1[0];
				var imdg_lmt_qty_desc=sArr2[0];
				if((imdg_lmt_qty == '0' || imdg_lmt_qty == '') && imdg_lmt_qty_desc == '') {
					ComShowCodeMessage('SCG50016');	//'This UN No. is not permitted as Limited Quantity.'				
					imdg_lmt_qty_flg.SetSelectCode('N',false);
					return;
				}
			}
//			var max_in_pck_qty = ComGetObjValue(formObj.max_in_pck_qty);
//			if(max_in_pck_qty == '' || max_in_pck_qty == '0') {
//				ComShowCodeMessage('SCG10072');	//'This UN No. is not permitted as Limited Quantity.'				
//				document.all.imdg_lmt_qty_flg.Code2 = 'N';
//				
//				return;
//			}
    	} else if(imdg_un_no.length == 0) {
    		ComShowCodeMessage('SCG50007', 'UN No.');	//'Please input {?msg1}.'
    		ComSetFocus(formObj.imdg_un_no);
    		var selCode=imdg_lmt_qty_flg.GetSelectCode();
    		if(selCode == 'Y')imdg_lmt_qty_flg.SetSelectCode('N',false);
    		else imdg_lmt_qty_flg.SetSelectCode('Y',false);
    		return;
    	}
    	return;
    }
    /**
     * Handling Excepted Q'ty Combo OnChange Event
     * param : comboObj ==> combo object, edited Code ==> Code, edited Text ==> Text
     * 
     */
    function imdg_expt_qty_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {  
     	var formObj=document.form;
     	var sheetObj=sheetObjects[1];
     	var imdg_un_no=ComGetObjValue(formObj.imdg_un_no);
     	var imdg_un_no_seq=ComGetObjValue(formObj.imdg_un_no_seq);
     	if(imdg_un_no.length > 0 && newCode == 'Y') {
     		var sXml=searchUnNoInfo(sheetObj, imdg_un_no, imdg_un_no_seq);
     		var sArr1=ComScgXml2Array(sXml, "imdg_expt_qty_cd");
     		var sArr2=ComScgXml2Array(sXml, "imdg_expt_qty_desc");
 			if(sArr1 != null) {
 				var imdg_expt_qty_cd=sArr1[0];
 				var imdg_expt_qty_desc=sArr2[0];
 				if((imdg_expt_qty_cd == 'E0' || imdg_expt_qty_cd == '') && imdg_expt_qty_desc == '') {
 				//if(imdg_expt_qty_cd == 'E0' || imdg_expt_qty_cd == '') {
 					ComShowCodeMessage('SCG50019');	//'This UN No. is not permitted as Excepted Quantity.'
 					imdg_expt_qty_flg.SetSelectCode('N',false);
 					return;
 				}
 			}
// 			var max_in_pck_qty = ComGetObjValue(formObj.max_in_pck_qty);
//			if(max_in_pck_qty == '' || max_in_pck_qty == '0') {
//				ComShowCodeMessage('SCG50019');	//'This UN No. is not permitted as Excepted Quantity.'	
//				document.all.imdg_expt_qty_flg.Code2 = 'N';
//				
//				return;
//			}
     	} else if(imdg_un_no.length == 0) {
     		ComShowCodeMessage('SCG50007', 'UN No.');	//'Please input {?msg1}.'
     		ComSetFocus(formObj.imdg_un_no);
     		var selCode=imdg_expt_qty_flg.GetSelectCode();
     		if(selCode == 'Y') imdg_expt_qty_flg.SetSelectCode('N',false);
     		else imdg_expt_qty_flg.SetSelectCode('Y',false);
     		return;
     	}
     	return;
    }
    /**
     * Handling Marine Pollutant Combo OnChange Event
     * param : comboObj ==> combo object, edited Code ==> Code, edited Text ==> Text
     * 
     */
    function mrn_polut_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {  
    	var formObj=document.form;
      	var sheetObj=sheetObjects[1];
      	var imdg_un_no=ComGetObjValue(formObj.imdg_un_no);
      	var imdg_un_no_seq=ComGetObjValue(formObj.imdg_un_no_seq);
      	if(imdg_un_no.length > 0 && newCode == 'N') {
      		var sXml=searchUnNoInfo(sheetObj, imdg_un_no, imdg_un_no_seq);
      		var sArr=ComScgXml2Array(sXml, "imdg_mrn_polut_cd");
  			if(sArr != null) {
  				var imdg_mrn_polut_cd=sArr[0];
  				if(imdg_mrn_polut_cd == 'P') {
  					ComShowCodeMessage('SCG50026');	//'This UN No. is identified as marine pollutants.'
  					mrn_polut_flg.SetSelectCode('Y',false);
  					return;
  				}
  			}
  			var itemObj=document.getElementById("hzd_desc"); 	
        	chgTecNmBox(formObj.imdg_spcl_provi_no.value, itemObj, newCode);
      	} else if(imdg_un_no.length > 0 && newCode == 'Y') {
      		var itemObj=document.getElementById("hzd_desc"); 	
        	chgTecNmBox(formObj.imdg_spcl_provi_no.value, itemObj, newCode);
      	} else if(imdg_un_no.length == 0) {
      		ComShowCodeMessage('SCG50007', 'UN No.');	//'Please input {?msg1}.'
      		ComSetFocus(formObj.imdg_un_no);
      		var selCode=mrn_polut_flg.GetSelectCode();
      		if(selCode == 'Y') mrn_polut_flg.SetSelectCode('N',false);
      		else mrn_polut_flg.SetSelectCode('Y',false);
      		return;
      	}
    }
//------------------------------------------------------------------------------//
/* Sheet event action - general function */    
//------------------------------------------------------------------------------//
	/**
     * Add Container
     */   
	function addCntrRow(sheetObj) {		
		with(sheetObj) {			
			var maxSeq=0;
			if(RowCount()> 0) {
				var cntrSeq;
				for(var idx=HeaderRows(); idx<=LastRow(); idx++) {
					cntrSeq=sheetObj.GetCellValue(idx, "spcl_cntr_seq");
					if(parseInt(cntrSeq) > maxSeq) maxSeq=parseInt(cntrSeq);
				}
			}
			DataInsert(-1,0);
			SetCellValue(GetSelectRow(), "spcl_cntr_seq",maxSeq + 1,0);
		}
//		btnEnabled("init", true);
	}
	/**
     * Add Cargo
     */   
	function addCgoRow(sheetObj1, sheetObj2) {	
		if(sheetObj1.GetSelectRow()> 0) {
			if(sheetObj2.RowCount()> 0) {
				setFormToSheetAll(sheetObj2, sheetObj2.GetSelectRow(), document.form.dcgo_ref_no, document.form.auth_sts_cd);
			} else {
				sheetObj2.RemoveAll();
			}
			sheetObj2.DataInsert(-1,0);
			sheetObj2.SelectCell(sheetObj2.GetSelectRow(), "spcl_cntr_seq");
			var cntrSeq=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "spcl_cntr_seq");
			var cntrRefNo=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "cntr_ref_no");
			var cntrTpszCd=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "cntr_tpsz_cd");
			var cgoSeq=findMaxCgoRow(sheetObj2, cntrSeq) + 1;
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "spcl_cntr_seq",cntrSeq,0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "spcl_cgo_seq",cgoSeq,0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "cntr_ref_no",cntrRefNo,0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "cntr_tpsz_cd",cntrTpszCd,0);
			//basic value
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "imdg_lmt_qty_flg","N",0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "mrn_polut_flg","N",0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "imdg_expt_qty_flg","N",0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "auth_dt",ComGetNowInfo("ymd", "-"),0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "auth_sts_cd","",0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "cgo_rqst_dt",ComGetNowInfo("ymd", "-"),0);
			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "wgt_ut_cd","KGS",0);
			sheetObj2.SelectCell(sheetObj2.GetSelectRow(), "spcl_cgo_seq");
			//DG Package Q'ty & Type
//			var formObj = document.form;
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "out_n1st_imdg_pck_qty"   , ComGetObjValue(formObj.out_n1st_imdg_pck_qty   ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "out_n1st_imdg_pck_cd"    , ComGetObjValue(formObj.out_n1st_imdg_pck_cd    ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "out_n1st_imdg_pck_desc"  , ComGetObjValue(formObj.out_n1st_imdg_pck_desc  ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "out_n2nd_imdg_pck_qty"   , ComGetObjValue(formObj.out_n2nd_imdg_pck_qty   ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "out_n2nd_imdg_pck_cd"    , ComGetObjValue(formObj.out_n2nd_imdg_pck_cd    ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "out_n2nd_imdg_pck_desc"  , ComGetObjValue(formObj.out_n2nd_imdg_pck_desc  ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "intmd_n1st_imdg_pck_qty" , ComGetObjValue(formObj.intmd_n1st_imdg_pck_qty ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "intmd_n1st_imdg_pck_cd"  , ComGetObjValue(formObj.intmd_n1st_imdg_pck_cd  ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "intmd_n1st_imdg_pck_desc", ComGetObjValue(formObj.intmd_n1st_imdg_pck_desc),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "intmd_n2nd_imdg_pck_qty" , ComGetObjValue(formObj.intmd_n2nd_imdg_pck_qty ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "intmd_n2nd_imdg_pck_cd"  , ComGetObjValue(formObj.intmd_n2nd_imdg_pck_cd  ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "intmd_n2nd_imdg_pck_desc", ComGetObjValue(formObj.intmd_n2nd_imdg_pck_desc),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "in_n1st_imdg_pck_qty"    , ComGetObjValue(formObj.in_n1st_imdg_pck_qty    ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "in_n1st_imdg_pck_cd"     , ComGetObjValue(formObj.in_n1st_imdg_pck_cd     ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "in_n1st_imdg_pck_desc"   , ComGetObjValue(formObj.in_n1st_imdg_pck_desc   ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "in_n2nd_imdg_pck_qty"    , ComGetObjValue(formObj.in_n2nd_imdg_pck_qty    ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "in_n2nd_imdg_pck_cd"     , ComGetObjValue(formObj.in_n2nd_imdg_pck_cd     ),0);
//			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), "in_n2nd_imdg_pck_desc"   , ComGetObjValue(formObj.in_n2nd_imdg_pck_desc   ),0);
			var isCgoSeq=findMaxCgoRow(sheetObj2, cntrSeq);
			if(isCgoSeq == 1) {
				setEnableUI(document.form, spcl_cgo_seq, document.form.apro_ref_no, "enable");
			}
//			btnEnabled("init", true);
			//Initializing Pre-Checking Report result
			setPreChkRslt("N");
			
//			if(document.form.attach_file_cnt.value < 0) {	//2014-12-08
//				document.form.attach_file_cnt.value = 0;
//			}

			document.getElementById("approved").innerHTML="";
			
	 	    var uLayer=document.all.item("uploadLayer");
	 	    
	 	    //기존 레이어 닫기
	 	    if (showedLayer != -1){
	 	    	hideUploadLayer();
	 	    }
	 	    
	 	    
	 	   fileAttachCnt(sheetObjects[2]);

		} else {
			ComShowCodeMessage('SCG50007','CNTR Seq.');	//'Please input {?msg1}.'
		}
		return;
	}
	/**
     * Find Cargo Sequence
     */
	function findMaxCgoRow(sheetObj, searchVal) {
		var fstRow=sheetObj.FindText("spcl_cntr_seq", searchVal, 0, -1, true);
		if(fstRow == -1) {
			return 0;
		} else {
			var maxSeq=0, cgoSeq=0;
			var cntrSeq;
			for(var startIdx=fstRow; startIdx<=sheetObj.LastRow(); startIdx++) {
				cntrSeq=sheetObj.GetCellValue(startIdx, "spcl_cntr_seq");
				cgoSeq=parseInt(sheetObj.GetCellValue(startIdx, "spcl_cgo_seq"));
				if(sheetObj.GetRowStatus(startIdx) != 'D' && searchVal == cntrSeq && cgoSeq > maxSeq) maxSeq=cgoSeq;
			}
			return maxSeq;
		}
	}
	
    /**
     * Delete Container
     */
 	function delCntrRow(sheetObj1, sheetObj2) {
 		
 		////if(sheetObj1.RowCount() > 1) {

 		for(var row=sheetObj1.RowCount(); row>=1; row--){
			
			//alert('row ['+row+']');
			//alert('ticked ? ['+sheetObj1.GetCellValue(row, "del_chk")+']');
			
			if(sheetObj1.GetCellValue(row, "del_chk") == "1"){

 				//alert('RowCount ['+sheetObj1.RowCount()+']');
 				
 				if(sheetObj1.RowCount() == 1){
 					ComShowCodeMessage("SCG50056");		//[At least one container must be remained]//
 					sheetObj1.SetCellValue	(row, "del_chk", "0", 0);
 	 	 	 		
 					//alert('1');
 			 		sheetObj1.SelectCell	(row, "spcl_cntr_seq");
 			 		sheetObj2.SelectCell	(row, "spcl_cntr_seq");
 			 		sheetObj2.SelectCell	(row, "spcl_cgo_seq"); 
 			 		//alert('3');
 			 		
 					return;
 				}
				
 	 	 		delCgoRow					(sheetObj2, sheetObj1.GetCellValue(row, "spcl_cntr_seq"), -1);
 	 	 		//sheetObj1.SetCellValue	(row, "cntr_tpsz_cd", "D2", 0);
 	 	 		//sheetObj1.RowDelete		(sheetObj1.GetSelectRow(), false);
 	 	 		
 	 	 		//alert('111 ['+111+']');
 	 	 		//ComRowHideDelete		(sheetObj1, "del_chk");

 	 	 		//sheetObj1.RowDelete		(row , 0);
 	 	 		
 	 	 		sheetObj1.SelectCell		(row-1, "spcl_cntr_seq");
 	 	 		sheetObj2.SelectCell		(row-1, "spcl_cntr_seq");
 	 	 		sheetObj2.SelectCell		(row-1, "spcl_cgo_seq"); 
 	 	 		
 	 	 		//sheetObj1.SetRowStatus	(row, "D"); 	// 3.트랜잭션 상태 "삭제"로 만들기
 	 	 		sheetObj1.RowDelete			(row , false);		
 	 	 		
 	 	 		//ComRowHideDelete			(sheetObj1, "del_chk");

 	 	 		clearObjAll					(spcl_cgo_seq, document.form.apro_ref_no, 3);
 	 	 		
 	 	 		//alert('222 ['+222+']');
 	 	 		setCgoSeq					(sheetObj1, sheetObj2);
				
 	 	 		
 	 	 		//alert('333 ['+333+']');
				
			}
			
		}
		
 		//alert('xxx');
 		sheetObj1.SelectCell	(1, "spcl_cntr_seq");
 		sheetObj2.SelectCell	(1, "spcl_cntr_seq");
 		sheetObj2.SelectCell	(1, "spcl_cgo_seq");  			
 			
 			
// 	 		delCgoRow				(sheetObj2, sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "spcl_cntr_seq"), -1);
// 	 		sheetObj1.SetCellValue	(sheetObj1.GetSelectRow(), "cntr_tpsz_cd", "D2", 0);
// 	 		sheetObj1.RowDelete		(sheetObj1.GetSelectRow(), false);
// 	 		//2015-12-24//ComRowHideDelete		(sheetObj1, "del_chk");
//
// 	 		clearObjAll				(spcl_cgo_seq, document.form.apro_ref_no, 3);
// 	 		setCgoSeq				(sheetObj1, sheetObj2);
// 			//setEnableUI(document.form, spcl_cgo_seq, document.form.apro_ref_no, "disable");
// 			//btnEnabled("init", false);
// 			sheetObj1.SelectCell	(1, "spcl_cntr_seq");
// 			sheetObj2.SelectCell	(1, "spcl_cgo_seq");
//
// 			if(sheetObj1.RowCount() == 0) {
// 				btnEnabled("add", true);	
// 			}
 	 		
 		////}
 	 		
 	}
 	
	/**
     * Delete Cargo
     */
	function delCgoRow(sheetObj, delCntrSeq, delCgoSeq) {	
		
		var fstRow	= sheetObj.FindText("spcl_cntr_seq", delCntrSeq, 0, -1, true);
		
		if(fstRow != -1) {
			
			var cntrSeq, cgoSeq;
			var matchSeqs	= "";
			for(var searchIdx=fstRow; searchIdx<=sheetObj.LastRow(); searchIdx++) {
				cntrSeq	= sheetObj.GetCellValue	(searchIdx, "spcl_cntr_seq");
				cgoSeq	= sheetObj.GetCellValue	(searchIdx, "spcl_cgo_seq");
				if(delCntrSeq == cntrSeq && (delCgoSeq == -1 || delCgoSeq == cgoSeq)) matchSeqs += searchIdx+"|";
			}
			
			var matchSeq	= matchSeqs.split("|");
			for (var delIdx=matchSeq.length-2; delIdx>=0; delIdx--){
				sheetObj.SetRowStatus(matchSeq[delIdx],"D");
				
				//alert(matchSeq[delIdx]);
				//alert(delIdx);
				//alert('GetRowStatus ['+sheetObj.GetRowStatus(matchSeq[delIdx])+']');
				
			}
			
			//Initializing Pre-Checking Report result
			setPreChkRslt		("N");
			sheetObj.SelectCell	(1, "spcl_cgo_seq");
			var isCgoSeq	= findMaxCgoRow(sheetObj, delCntrSeq);
			
			if(isCgoSeq == 0) {	
				clearObjAll(spcl_cgo_seq, document.form.apro_ref_no, 3);
				setEnableUI(document.form, spcl_cgo_seq, document.form.apro_ref_no, "disable");
				if(delCgoSeq != -1) {
					//if(ComShowCodeConfirm('SCG50002', 'data')) {	//'Do you want to delete {?msg1}?'
						delCntrRow(sheetObjects[0], sheetObj);
					//}
				}
			} else {
				sheetObj.SelectCell(nextCgoRow(sheetObj, delCntrSeq, delCgoSeq), "spcl_cgo_seq");
			}
		}
	}
    /**
     * Find next moving cago sequence
     */
 	function nextCgoRow(sheetObj, delCntrSeq, delCgoSeq) {	 		
 		var cntrSeq, cgoSeq, rowStatus;
 		var nextRow=0;
 		for(var nextIdx=sheetObj.HeaderRows(); nextIdx<=sheetObj.LastRow(); nextIdx++) {
 			cntrSeq=sheetObj.GetCellValue(nextIdx, "spcl_cntr_seq");
 			cgoSeq=sheetObj.GetCellValue(nextIdx, "spcl_cgo_seq");
 			rowStatus=sheetObj.GetRowStatus(nextIdx);
 			if(rowStatus != 'D' && delCntrSeq == cntrSeq) {
 				nextRow=nextIdx;
 			}
 		}
 		return nextRow;
 	}
    /**
     * Sheet Cago --> Form Cago
     * param : startObj ==> start object, endObj ==> end object
     */
    function setSheetToFormAll(sheetObj, row, startObj, endObj) {  
         try {
         	 var elems=document.form.elements;
         	 var startYn=false;
         	 var authStsCd=sheetObj.GetCellValue(row, "org_auth_sts_cd");
         	 for(var i=0; i < elems.length; i++) {
         		 var elem=elems[i];
         		 var objNm=elem.name;
//                 if(elem.getAttribute("ibcb-delegate") == "true"){	//@ibcb-delegate attribute 로 input타입으로 되있는것을 combo로 인식될 수 있도록 처리를 유도한다
//               		 startObj = elem;	 
//                   	 
//                	 ////console.log("startObj >"+startObj+", elem >"+elem+", elem.id >"+elem.id);
//                	 //alert("startObj >"+startObj+", elem >"+elem+", elem.id >"+elem.id);
//                	 ////console.log("elem.id >"+elem.id+", elem >"+elem);
//                	 //alert("elem.id >"+elem.id+", elem >"+elem);
//                 }
                 if(startObj == null || startObj.name == objNm) startYn=true;
                 
                 ////console.log("startObj.name >"+startObj.name+", objNm >"+objNm+", startYn >"+startYn);
                 //alert("startObj.name >"+startObj.name+", objNm >"+objNm+", startYn >"+startYn);

                 if(startYn) {
	                 if ((elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA') && objNm != null && objNm != '' && elem.getAttribute("ibcb-delegate") != "true") {	//@@ibcb-delegate attribute 로 input타입으로 되있는것을 combo로 인식될 수 있도록 처리를 유도한다	                	 
	                	 if(elem.name == 'wgt_ut_cd2') objNm="wgt_ut_cd";
	                	 var sheetVal=sheetObj.GetCellText(row, objNm);
	                	 if(sheetVal != null) {
	                		 if(elem.tagName == 'SELECT') {
	                			 for (var idx=0; idx < elem.length; idx++) {
	                                 if (elem[idx].value == sheetVal) {
	                                	 if (preConds.pId != "VOP_SCG_5001") { 
	                                		 elem[idx].selected=true;
		                                     break;	 
	                                	 }
	                                 }
	                             }
	                		 } else {
	                			 if(elem.id != 'pod_cd_text' && elem.id != 'cntr_cgo_seq_sum'){	//@@ sheet에 없는 컬럼이 셋팅되면서 문제발생 
	                				 if(objNm == 'cfr_flg') {
	                					 if(sheetVal=="Y")
	                						 elem.checked = true;
	                					 else
	                						 elem.checked = false;
	                				 } else {
	                					 elem.value=sheetVal;
		                			 }
		                			 //In case of UN No. applying SP274, set Technical Name as compulsory item
		                			 if(objNm == 'hzd_desc') {
		                				 var imdgSpclProviNo=sheetObj.GetCellValue(row, "imdg_spcl_provi_no");
		                				 var mrnPolutFlg=sheetObj.GetCellValue(row, "mrn_polut_flg");
		                				 chgTecNmBox(imdgSpclProviNo, elem, mrnPolutFlg);
		                			 }
		                			 if(objNm == 'n4th_imdg_subs_rsk_lbl_cd') {
		                				 fixFlshPointForm(document.form); //Flash Point status change decision
		                			 }
		                			 
	                			 }
	                		 }
	                	 }
	                	 if(	elem.name == 'grs_wgt' || elem.name == 'net_wgt') ComAddSeparator(elem);
	                 } else if (elem.getAttribute("ibcb-delegate") == "true") {	//elem.tagName == 'OBJECT' || 
	                	 //console.log(" > "+sheetObj.GetCellValue(row, objNm));
	                	 //alert(" > "+sheetObj.GetCellValue(row, objNm));
	                	 if(elem.id != 'pol_cd' && elem.id != 'pod_cd'){
	                		 eval(elem.id).SetSelectCode(sheetObj.GetCellValue(row, objNm),false);
	                	 }
//	                	 var sObjId=elem.classid;
//	                 	 switch(sObjId){
//	 	                 	case CLSID_IBMCOMBO: //only IBMultiCombo
//	 	                 		elem.SetSelectCode(sheetObj.GetCellValue(row, objNm),false);
//	 	                        break;
//	 	                 }
	                  }
                 }
                 // last
                 if(endObj.name == objNm) {
    				 var hcdg_flg=sheetObj.GetCellText(row, "hcdg_flg"); 
    				 var imdg_subs_rsk_lbl_rmk=sheetObj.GetCellText(row, "imdg_subs_rsk_lbl_rmk");
    				 //HCDG,Remark(s) Button color change
    				 chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk);
    			 }
                 if(endObj != null && endObj.name == objNm) break;
         	 }
//         	 if(authStsCd == 'Y' || authStsCd == 'N') {
//         		 setEnableUI(document.form, document.form.imdg_clss_cd, document.form.diff_rmk, "readonly");
//         	 }
         } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * Form Cago --> Sheet Cago
     * param : sheetObj ==> sheet object, row ==> selected Row, startObj ==> start object, endObj ==> end object
     * see : 1. Cargo Seq. Combo change , CNTR Seq. Row change , Cargo Row Add , 
     */
    function setFormToSheetAll(sheetObj, row, startObj, endObj) {
    	try {
    		var elems=document.form.elements;
          	var startYn=false;
          	for(var i=0; i < elems.length; i++) {
          		var elem=elems[i];
                if(startObj == undefined || startObj == null || startObj.name == elem.name) startYn=true;
                if(startYn && row > 0) {
	                if (elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA') {
	                	if(elem.tagName == 'SELECT') {
	                		if (preConds.pId != "VOP_SCG_5001") { 
	                			sheetObj.SetCellValue(row, elem.name,elem[elem.selectedIndex].value,0);	
	                		}
	                	} else {
	                		if(elem.name == 'cfr_flg') {
	                			if(elem.checked) {
	                				sheetObj.SetCellValue(row, elem.name,elem.value,0);
	                			} else {
	                				sheetObj.SetCellValue(row, elem.name,"",0);
	                			}
	                		} else{
	                			sheetObj.SetCellValue(row, elem.name,elem.value,0);
	                		}
	                		

	                	}
	                } else if (elem.tagName == 'OBJECT') {
	                 	var sObjId=elem.classid;
	                  	switch(sObjId){
	  	                	case CLSID_IBMCOMBO: //only IBMultiCombo
	  	                 		sheetObj.SetCellValue(row, elem.name,elem.GetSelectCode(),0);
	  	                        break;
	  	                }
	                 }
                }
                if(endObj != null && endObj.name == elem.name) break;
          	}
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * Cago Sequence composition
     * param : sheetObj1 ==> sheet object, sheetObj2 ==> sheet object
     */
    function setCgoSeq(sheetObj1, sheetObj2) {    
    	var cgoCombo=comboObjects[2];
    	var itemCdIdx=0;
    	var itemNmIdx=0;
    	var aproCt=0;
    	var totalCt=0;
    	cgoCombo.RemoveAll();
    	var comboItemsCd=new Array();
    	var comboItemsNm=new Array();
    	if(sheetObj1.GetSelectRow()!= 0) {
    		var selCntrSeq=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "spcl_cntr_seq");
	    	var fstRow=sheetObj2.FindText("spcl_cntr_seq", selCntrSeq, 0, -1, true);
			if(fstRow != -1) {
				var cntrSeq, cgoSeq, authStsCd, rowStatus;
				for(var startIdx=fstRow, i=0; startIdx<=sheetObj2.LastRow(); startIdx++) {
					cntrSeq=sheetObj2.GetCellValue(startIdx, "spcl_cntr_seq");
					cgoSeq=sheetObj2.GetCellValue(startIdx, "spcl_cgo_seq");
					authStsCd=sheetObj2.GetCellValue(startIdx, "auth_sts_cd");
					rowStatus=sheetObj2.GetRowStatus(startIdx);
					if(rowStatus != 'D' && selCntrSeq == cntrSeq) {
						comboItemsCd[itemCdIdx++]=cgoSeq;
						comboItemsNm[itemNmIdx++]=cgoSeq;// + " - " + authStsCd;
						totalCt++;
						if(authStsCd == 'Y' || authStsCd == 'N') aproCt++;
					}
				}
			}
    	}
    	setComboProperty(cgoCombo, comboItemsCd.length+1, "50|20|");
    	for(itemCdIdx=0; itemCdIdx<comboItemsCd.length; itemCdIdx++) {
    		cgoCombo.InsertItem(itemCdIdx, comboItemsNm[itemCdIdx]+"| |"+comboItemsCd[itemCdIdx], comboItemsCd[itemCdIdx]);
    	}
    	ComSetObjValue(document.form.cntr_cgo_seq_sum, totalCt);
		return i;
    }
    /**
     * Disable/Enable Cago UI
     * param : formObj ==> form object, startObj ==> start object, endObj ==> end object, type
     */
    function setEnableUI(formObj, startObj, endObj, type) {    	
          try {
          	 var elems=document.form.elements;
          	 var startYn=false;
          	 for(var i=0; i < elems.length; i++) {
          		 var elem=elems[i];
                  if(startObj == undefined || startObj == null || startObj.name == elem.name) startYn=true;
                  if(startYn) {
 	                 if (elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA') {
 	                	 if(type == 'disable' || type == 'readonly') {
 	                		 if(elem.tagName == 'TEXTAREA') {
 	                			 elem.setAttribute("readOnly", "true");
 	                		 } else {
 	                			elem.setAttribute("disabled", "true");
 	                		 }
 	                	 } else if(type == 'enable') {
 	                		 if(elem.tagName == 'TEXTAREA') {
 	                			 elem.removeAttribute("readOnly");
	                		 } else {
	                			 elem.removeAttribute("disabled");
	                		 }
 	                	 }
 	                 } else if (elem.getAttribute("ibcb-delegate") == "true") {   //(elem.tagName == 'OBJECT') 
 	                	 var sObjId=elem.classid;
 	                 	 switch(sObjId){
 	 	                 	case CLSID_IBMCOMBO: //only IBMultiCombo
 	 	                 		if(type == 'disable' || type == 'readonly') {
 	 	                 			elem.SetEnable(0);
 	 	                 		}else if(type == 'enable') {
 	 	                 			elem.SetEnable(1);
 	 	                 		}
 	 	                        break;
 	 	                 }
 	                  }
                  }
                  if(endObj != null && endObj.name == elem.name) break;
          	 }
//          	 if(type == 'disable' || type == 'readonly') {
//          		document.getElementById("btn_calendar").style.visibility="hidden";
//          		document.getElementById("btn_Un_No").style.visibility="hidden";
//          	 } else if(type == 'enable') {
//          		document.getElementById("btn_calendar").style.visibility="";
//          		document.getElementById("btn_Un_No").style.visibility="";
//          	 }
          	 if(endObj.name == 'apro_ref_no') {
	          	 var btnObjs=document.getElementsByTagName("td");
	          	 var btnName;
	          	 startYn=false;
	          	 for(var i=0; i < btnObjs.length; i++) {
	         		 var btnObj=btnObjs[i];
	         		 btnName=btnObj.name;
	         		 if (btnObj.className == 'btn2' || btnObj.className == 'btn2_1') {
	         			 if(btnName == 'btn2_UN_Information' || btnName == 'no_btn2_UN_Information') startYn=true;
	         			 if(startYn) {
	         				 if(btnName != 'btn3_Row_Add' && btnName != 'no_btn3_Row_Add') {
	         					 if(btnName.indexOf("no_") != -1) {
	         						btnName=ComTrimAll(btnName, "no_");
	         					 }
			         			 if(type == 'disable') {
			         				 ComBtnDisable(btnName);
			         				 if(btnName == 'btn2_Pre_Checking_Report' || btnName == 'no_btn2_Pre_Checking_Report') btnObj.style.color='#c0c0c0';
			         			 } else if(type == 'enable') {
			                		 if(preConds.pop_mode == 'view' || preConds.pop_mode == 'noedit') {
			                			 if(btnName != 'btn3_Row_Copy' && btnName != 'no_btn3_Row_Copy' && btnName != 'btn3_Row_Delete' && btnName != 'no_btn3_Row_Delete') {
			                				 ComBtnEnable(btnName);
			                			 }
			                		 } else {
			                			 ComBtnEnable(btnName);
			                		 }
			                		 if(btnName == 'btn2_Pre_Checking_Report' || btnName == 'no_btn2_Pre_Checking_Report') btnObj.style.color='#737373';
			                	 }
	         				 }
	         			 }
	         		 }
	         		 if(btnName == 'btn3_Row_Delete' || btnName == 'no_btn3_Row_Delete') break;
	          	 }
          	 }          	
          } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * Set Precondition
     * param : sheetObj ==> sheet object
     */
    function setPreCondition(sheetObj) {
    	var elems=document.form.elements;
    	var preCondEle;
    	for(var i=0; i < elems.length; i++) {
      		var elem=elems[i];
      		preCondEle=eval("preConds."+elem.name);
           	if(preCondEle != null) elem.value=preCondEle;
            	
            if(elem.getAttribute("ibcb-delegate") == "true"){	//@ibcb-delegate attribute 로 input타입으로 되있는것을 combo로 인식될 수 있도록 처리를 유도한다
              	  eval(elem.id).SetSelectCode(preCondEle);
            }
                
      		if(elem.name == 'skd_dir_cd') {
      			if(elem.value != '') doActionIBCombo(sheetObj, comboObjects[0], 1, '');	//retrieve POL
      		} else if(elem.name == 'pol_cd') {
      			if(preCondEle != '') doActionIBCombo(sheetObj, comboObjects[1], 2, pol_cd.GetSelectCode());	//pol_cd.GetSelectCode() // retrieve POD
      		} else if(elem.name == 'pod_cd') break;
      	}
    	if(preConds.spcl_cgo_rqst_seq != '') {
    		ComSetObjValue(document.form.ibflag, "U");
    		setEnableUI(document.form, document.form.cgo_opr_cd, document.form.skd_dir_cd, 'readonly');
    		document.getElementById("btn_Carrier").style.visibility="hidden";
    		document.getElementById("btn_VVDpop").style.visibility="hidden";
    	}
    	return true;
    }
    /**
     * Find first row of cago related with container
     * param : sheetObj1 ==> sheet object, sheet1Row ==> selected Row, sheetObj2 ==> sheet object
     */
    function findFirstRowCgo(sheetObj1, sheet1Row, sheetObj2) {
    	var cntrSeq=sheetObj1.GetCellValue(sheet1Row, "spcl_cntr_seq");
    	var fstRow=sheetObj2.FindText("spcl_cntr_seq", cntrSeq, 0, -1, false);
    	for(var findIdx=fstRow; findIdx<=sheetObj2.LastRow(); findIdx++) {
    		if(sheetObj2.GetRowStatus(findIdx) != 'D') {
    			fstRow=findIdx;
    			break;
    		}
    	}
		if(fstRow != -1) sheetObj2.SelectCell(fstRow, "spcl_cgo_seq");
    }
    /**
     * Button deactivate/activate
     * param : what ==> whether to deactivate/activate
     */
    function btnEnabled(what, how) {
//    	if(how) {
//    		if(preConds.pop_mode != 'view' || preConds.pop_mode == 'noedit') {
//	    		ComBtnEnable("btn1_Save");
//	    		ComBtnEnable("btn2_Add");
//	    		ComBtnEnable("btn2_Delete");
//	    		ComBtnEnable("btn2_Copy");
//	    		ComBtnEnable("btn3_Row_Add");
//	    		ComBtnEnable("btn3_Row_Copy");
//	    		ComBtnEnable("btn3_Row_Delete");
//	    		
//	    		btn2Add();
//	    		
	    		if(what == "add"){
	    			var sheetObj1=sheetObjects[0];
	    			var sheetObj2=sheetObjects[1];
	    			var formObj=document.form;

					if(sheetObj1.RowCount()== 0 || sheetObj1.GetSelectRow()== -1 || validateForm(sheetObj1,formObj,sheetObj1.GetSelectRow(),IBSEARCH_ASYNC03)) {	//Container info compulsory check
			    		if(sheetObj2.RowCount()== 0 || sheetObj2.GetSelectRow()== -1 || validateForm(sheetObj2,formObj,-1,IBSEARCH_ASYNC01)) {	//Cargo info compulsory check
							addCntrRow(sheetObj1);
							addCgoRow(sheetObj1, sheetObj2);
			    		}
					}
	    		}
//    		}else if(preConds.pop_mode != 'view' || preConds.pop_mode == 'noedit') {
//    			ComBtnEnable("btn1_Save");
//    		}
//    	} else {
//    		if(what == 'view' || preConds.pop_mode == 'noedit') {
//    			ComBtnDisable("btn1_New");
//    			ComBtnDisable("btn1_Save");
//    			ComBtnDisable("btn2_Add");
//    		}
//    		
//	    	ComBtnDisable("btn2_Delete");
//	    	ComBtnDisable("btn2_Copy");
//	    	ComBtnDisable("btn3_Row_Add");
//	    	ComBtnDisable("btn3_Row_Copy");
//	    	ComBtnDisable("btn3_Row_Delete");
//	    	
//	    	btn2Delete();    			
//    	}
    }
    
    function btn2Add(){
    	ComBtnEnable("btn2_UN_Information");
    	ComBtnEnable("btn2_Restrictions");
    	ComBtnEnable("btn2_Pre_Checking_Report");
    	ComBtnEnable("btn2_Package_Qty_Type");
    	ComBtnEnable("btn2_Other_Emergency_Information");
    	
        for(var k=0; k < comboObjects.length; k++){
  	        comboObjects[k].SetEnable(true);
  	    }
        
    }
    function btn2Delete(){
    	ComBtnDisable("btn2_UN_Information");
    	ComBtnDisable("btn2_Restrictions");
    	ComBtnDisable("btn2_Pre_Checking_Report");
    	ComBtnDisable("btn2_Package_Qty_Type");
    	ComBtnDisable("btn2_Other_Emergency_Information");
    	
    	for(var k=0; k < comboObjects.length; k++){
  	        comboObjects[k].SetEnable(false);
  	    }
    }
    
    /**
     * Fix the drop-height of combo 
     */
    function setComboProperty(obj, rlstCt, width) {
    	if(rlstCt <= 10) {
    		obj.SetDropHeight(19*rlstCt);
    		obj.SetColWidth(0, "width");
   		} else {
   			obj.SetDropHeight(19*10);
   		}
    }
    /**
 	 * Copy Cargo
 	 */
 	function copyCargo(sheetObj1, sheetObj2, row) {
 		addCgoRow(sheetObj1, sheetObj2);
 		for(var cgoIdx=sheetObj2.SaveNameCol("cntr_tpsz_cd")+1; cgoIdx<=sheetObj2.SaveNameCol("diff_rmk"); cgoIdx++) {
 			sheetObj2.SetCellValue(sheetObj2.GetSelectRow(), cgoIdx,sheetObj2.GetCellValue(row, cgoIdx),0);
 		}
 		sheetObj2.SelectCell(sheetObj2.GetSelectRow(), "spcl_cntr_seq");
 	}
 	/**
  	 * Copy Form's information for Booking
  	 */
  	function setOrgFormInfo(formObj) {
  		orgFormObj=new Array();
  		orgFormObj[0]=ComGetObjValue(formObj.ibflag);
  		orgFormObj[1]=ComGetObjValue(formObj.spcl_cgo_rqst_seq);
	   	orgFormObj[2]=ComGetObjValue(formObj.vsl_cd);
	   	orgFormObj[3]=ComGetObjValue(formObj.skd_voy_no);
	   	orgFormObj[4]=ComGetObjValue(formObj.skd_dir_cd);
	   	orgFormObj[5]=ComGetObjValue(formObj.slan_cd);
	   	orgFormObj[6]=ComGetObjValue(formObj.bkg_ref_no);
	   	orgFormObj[7]=ComGetObjValue(formObj.cgo_opr_cd);
	   	orgFormObj[8]=ComGetObjValue(pol_cd);
	   	orgFormObj[9]=ComGetObjValue(formObj.eta_dt);
	   	orgFormObj[10]=ComGetObjValue(pod_cd);
	   	orgFormObj[11]=ComGetObjValue(formObj.crr_cd); 

	   	orgFormObj[12]=ComGetObjValue(formObj.prnr_cgo_rqst_seq);
  	}
//------------------------------------------------------------------------------//
/* general functions -- popup action and return functions */    
//------------------------------------------------------------------------------//    
    /**
     * Pop-Up Action
     */
    function onPopupClick(sheetObj, formObj, srcName, srcType){
    	var imdg_un_no=ComGetObjValue(formObj.imdg_un_no);
    	if (srcType == "Carrier") {
    		ComOpenPopup('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 650, 500, "setCallBackCarrier", "0,0,1,1,1", true);
   	 	} else if (srcType == "VVD") {		
			var vsl_cd=ComGetObjValue(document.form.vsl_cd);
        	var sUrl="";
        	if(vsl_cd == ""){
        		sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
        		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
        	}else{
        		sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
        		ComOpenPopup(sUrl, 305, 420, "setCallBackVVD", "0,0", true);
        	}
   	 	} else if(srcType == "btn_Un_No" || srcType == "UnNo") {
   	 		if(preConds.pId == "VOP_SCG_0022"){
   			 var sParam="imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
			 sParam += "&imdg_clss_cd="+ComGetObjValue(formObj.imdg_clss_cd);
//			 sParam += "&prp_shp_nm="+ComGetObjValue(formObj.prp_shp_nm);
			 sParam += "&prp_shp_nm=";
			 sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_ref_no);
			 sParam += "&imdg_amdt_no="+ComGetObjValue(formObj.imdg_amdt_no);
			 sParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
			 sParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
			 sParam += "&pop_type=PR"
				 
			 ComOpenPopup("ESM_BKG_0204.do?"+sParam, 913, 440, "setCallBackUnNo2", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");	//getCOM_UNNO_POPUP / setCallBackUnNo
   	 		}else{
   			 var sParam="imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
			 sParam += "&imdg_clss_cd="+ComGetObjValue(formObj.imdg_clss_cd);
//			 sParam += "&prp_shp_nm="+ComGetObjValue(formObj.prp_shp_nm);
			 sParam += "&prp_shp_nm=";
			 sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_ref_no);
			 sParam += "&imdg_amdt_no="+ComGetObjValue(formObj.imdg_amdt_no);
			 sParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
			 sParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
			 sParam += "&pop_type=PA" ;
			 ComOpenPopup("ESM_BKG_0204.do?"+sParam, 913, 440, "setCallBackUnNo2", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");	//getCOM_UNNO_POPUP / setCallBackUnNo	
			 
   	 			
   	 		}

   	 		
   	 		//Reset items related to Un No.
//   	 		resetForUnNo(formObj);
			//var paramStr = "";
			//if(imdg_un_no.length == 4 && !isNaN(imdg_un_no)) {
			//	paramStr = "&imdg_un_no="+imdg_un_no;
			//}
	    	//var sUrl = "/opuscntr/VOP_SCG_0002Pop.do?pop_yn=Y"+paramStr;
			//ComOpenPopup(sUrl, 1000, 648, "setCallBackUnNo", "0,0,1,1,1,1,1,1,1,1", true);
//			ComOpenPopup("ESM_BKG_0204.do?f_cmd=&"+FormQueryString(formObj), 913, 440, "setCallBackUnNo2", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
   	 	} else if(srcType == "Restrictions") {
   	 		if(imdg_un_no == '') ComAlertFocus(formObj.imdg_un_no, "'" + formObj.imdg_un_no.getAttribute("caption") + "' " + Msg_Required);
   	 		else {
   	 			/*var sParam=Array();
   	 			sParam[0]="imdg_un_no="     + ComGetObjValue(formObj.imdg_un_no);
   	 			sParam[1]="imdg_un_no_seq=" + ComGetObjValue(formObj.imdg_un_no_seq);
   	 			sParam[2]="imdg_clss_cd="   + ComGetObjValue(formObj.imdg_clss_cd);
   	 			sParam[3]="pol_cd="         + ComGetObjValue(pol_cd);
   	 			sParam[4]="pod_cd="         + ComGetObjValue(pod_cd);
   	 			sParam[5]="slan_cd="        + ComGetObjValue(formObj.slan_cd);
   	 			sParam[6]="bkg_no=";
   	 			sParam[7]="bkg_ref_no="     + ComGetObjValue(formObj.bkg_ref_no);
   	 			sParam[8]="vsl_cd="         + ComGetObjValue(formObj.vsl_cd);
   	 			sParam[9]="skd_voy_no="     + ComGetObjValue(formObj.skd_voy_no);   
   	 			sParam[10]="skd_dir_cd="     + ComGetObjValue(formObj.skd_dir_cd); 
   	 			ComOpenWindowCenter("VOP_SCG_0021.do?"+sParam.join("&"), "winRestrictions", "1150", "660", true);*/
   	 			var sParam  = "imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
   	 			sParam += "&imdg_un_no_seq="+ComGetObjValue(formObj.imdg_un_no_seq);
   	 			sParam += "&imdg_clss_cd="+ComGetObjValue(formObj.imdg_clss_cd);
   	 			sParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
   	 			sParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
   	 			sParam += "&slan_cd="+ComGetObjValue(formObj.slan_cd);
   	 			sParam += "&bkg_no=";
   	 			sParam += "&bkg_ref_no="+ComGetObjValue(formObj.bkg_ref_no);
   	 			sParam += "&vsl_cd="+ComGetObjValue(formObj.vsl_cd);
   	 			sParam += "&skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
   	 			sParam += "&skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
   	 			ComOpenPopup("VOP_SCG_0021.do?"+sParam, 1150, 660, "VOP_SCG_0021", "0,0,1,1,1,1,1", false);
   	 		}
   	 	} else if(srcType == "PreChecking") {
   	 		onPreChkPopup(sheetObj, formObj, "R",  "940", "990");
   	 	} else if(srcType == "UnInformation") {
   	 		if(imdg_un_no == '') ComAlertFocus(formObj.imdg_un_no, "'" + formObj.imdg_un_no.getAttribute("caption") + "' " + Msg_Required);
	 		else ComOpenPopup("VOP_SCG_0001Pop.do?pgmNo=VOP_SCG_0001&pop_mode=Y&"+FormQueryString(formObj), 1060, 650, "getWinUnInformation", "0,0,1,1,1,1,1", false);
	 	} else if(srcType == "Mail") {
	 		if(ComGetObjValue(formObj.ibflag) == 'I') {
	  			//ComShowCodeMessage("SCG50018");	//'Please use after Retrieve.'
	  			return;
	  		} else {  		  	
			  	var crr_cd=ComGetObjValue(formObj.cgo_opr_cd);
			  	var bkg_ref_no=ComGetObjValue(formObj.bkg_ref_no);
			  	var spcl_cgo_rqst_seq=ComGetObjValue(formObj.spcl_cgo_rqst_seq);
			  	var prnr_cgo_rqst_seq=ComGetObjValue(formObj.prnr_cgo_rqst_seq);
			  	var rgn_shp_opr_cd=ComGetObjValue(formObj.rgn_shp_opr_cd);
			  	
			  	var vsl_cd=ComGetObjValue(formObj.vsl_cd);
			  	var skd_voy_no=ComGetObjValue(formObj.skd_voy_no);
			   	var skd_dir_cd=ComGetObjValue(formObj.skd_dir_cd);
			  	var pol_cd=ComGetObjValue(formObj.pol_cd);
			  	var pod_cd=ComGetObjValue(formObj.pod_cd);
			  	
			  	var scg_flg="DG";
			  	var send_type="P0";
			  	mailObj.crr_cd=crr_cd;
			  	mailObj.bkg_ref_no=bkg_ref_no;
			  	mailObj.spcl_cgo_rqst_seq=spcl_cgo_rqst_seq;
			  	mailObj.prnr_cgo_rqst_seq=prnr_cgo_rqst_seq;
			  	mailObj.rgn_shp_opr_cd=rgn_shp_opr_cd;
			  	
			  	mailObj.vsl_cd = vsl_cd;
			  	mailObj.skd_voy_no = skd_voy_no;
			  	mailObj.skd_dir_cd = skd_dir_cd;
			  	mailObj.pol_cd = pol_cd;
			  	mailObj.pod_cd = pod_cd;
			  	
			  	mailObj.scg_flg=scg_flg;
			  	mailObj.send_type=send_type;
			  	mailObj.user_id=user_id;
//			  	ComScgSendMail(sheetObj, formObj, mailObj);
			  	ComScgSendMail(sheetObj, formObj, mailObj, true, "VOP_SCG_1022GS.do", "authPending()");
	  		}
	 	} else if(srcType == "Remark") {
	 		ComOpenWindowCenter("VOP_SCG_0757.do", "remark", "500", "320", true);
	 	} else if(srcType == "OtherEmerInfo") {
	 		
	 		if(preConds.pId == "VOP_SCG_0022"){
		 		//ComOpenWindowCenter("VOP_SCG_0770.do", "otherEmerInfo", "505", "195", true);
		 		var sParam="";
		 		sParam += "imdg_emer_no="+ComGetObjValue(formObj.ems_no);
				sParam += "&emer_rspn_gid_no="+ComGetObjValue(formObj.emer_rspn_gid_no);
				sParam += "&emer_rspn_gid_chr_no="+ComGetObjValue(formObj.emer_rspn_gid_chr_no);
				sParam += "&ctrl_temp_ctnt="+ComGetObjValue(formObj.ctrl_temp_ctnt);
				sParam += "&emer_temp_ctnt="+ComGetObjValue(formObj.emer_temp_ctnt);
				
				//2016-01-25 pop_type, Partner의 경우, ERAP, ERAP Contact No, EARAP Approval Ref. Disable.
				sParam += "&pop_type=PR" ;
				
//				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("ESM_BKG_0770.do?"+sParam, 500, 220, "getCOM_EMER_NO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
							"ESM_BKG_0770"); 
//				}		
	 		}else{
		 		//ComOpenWindowCenter("VOP_SCG_0770.do", "otherEmerInfo", "505", "195", true);
		 		var sParam="";
		 		sParam += "imdg_emer_no="+ComGetObjValue(formObj.ems_no);
				sParam += "&emer_rspn_gid_no="+ComGetObjValue(formObj.emer_rspn_gid_no);
				sParam += "&emer_rspn_gid_chr_no="+ComGetObjValue(formObj.emer_rspn_gid_chr_no);
				sParam += "&ctrl_temp_ctnt="+ComGetObjValue(formObj.ctrl_temp_ctnt);
				sParam += "&emer_temp_ctnt="+ComGetObjValue(formObj.emer_temp_ctnt);
				
				//2016-01-25 pop_type, Partner의 경우, ERAP, ERAP Contact No, EARAP Approval Ref. Disable.
				sParam += "&pop_type=PA" ;
				
//				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
					ComOpenPopup("ESM_BKG_0770.do?"+sParam, 500, 220, "getCOM_EMER_NO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
							"ESM_BKG_0770"); 
//				}	
	 		}

	 		//ComOpenPopup("ESM_BKG_0770.do?"+sParam, 500, 220, "setOtherEmergencyInformation2", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0770");
	 	} else if(srcType == "DgPkgQtyType") {
//	 		//ComOpenWindowCenter("VOP_SCG_0206.do", "dgPkgQtyType", "710", "520", true);
	 		var nRow   = sheetObj.GetSelectRow();
	 		var sParam = "";
	 		sParam += "in_imdg_pck_cd1="    + sheetObj.GetCellValue(nRow, "in_n1st_imdg_pck_cd");     // ComGetObjValue(formObj.in_n1st_imdg_pck_cd);
			sParam += "&in_imdg_pck_cd2="   + sheetObj.GetCellValue(nRow, "in_n2nd_imdg_pck_cd");     // ComGetObjValue(formObj.in_n2nd_imdg_pck_cd);
			sParam += "&intmd_imdg_pck_cd1="+ sheetObj.GetCellValue(nRow, "intmd_n1st_imdg_pck_cd");  // ComGetObjValue(formObj.intmd_n1st_imdg_pck_cd);
			sParam += "&intmd_imdg_pck_cd2="+ sheetObj.GetCellValue(nRow, "intmd_n2nd_imdg_pck_cd");  // ComGetObjValue(formObj.intmd_n2nd_imdg_pck_cd);
			sParam += "&out_imdg_pck_cd1="  + sheetObj.GetCellValue(nRow, "out_n1st_imdg_pck_cd");  // ComGetObjValue(formObj.out_n1st_imdg_pck_cd);
			sParam += "&out_imdg_pck_cd2="  + sheetObj.GetCellValue(nRow, "out_n2nd_imdg_pck_cd");  //ComGetObjValue(formObj.out_n2nd_imdg_pck_cd);
			sParam += "&in_imdg_pck_desc1=" + sheetObj.GetCellValue(nRow, "in_n1st_imdg_pck_desc");  //ComGetObjValue(formObj.in_n1st_imdg_pck_desc);
			sParam += "&in_imdg_pck_desc2=" + sheetObj.GetCellValue(nRow, "in_n2nd_imdg_pck_desc");  //ComGetObjValue(formObj.in_n2nd_imdg_pck_desc);
			sParam += "&intmd_imdg_pck_desc1=" + sheetObj.GetCellValue(nRow, "intmd_n1st_imdg_pck_desc");  //ComGetObjValue(formObj.intmd_n1st_imdg_pck_desc);
			sParam += "&intmd_imdg_pck_desc2=" + sheetObj.GetCellValue(nRow, "intmd_n2nd_imdg_pck_desc");  //ComGetObjValue(formObj.intmd_n2nd_imdg_pck_desc);
			sParam += "&out_imdg_pck_desc1="   + sheetObj.GetCellValue(nRow, "out_n1st_imdg_pck_desc");  //ComGetObjValue(formObj.out_n1st_imdg_pck_desc);
			sParam += "&out_imdg_pck_desc2="   + sheetObj.GetCellValue(nRow, "out_n2nd_imdg_pck_desc");  //ComGetObjValue(formObj.out_n2nd_imdg_pck_desc);
			sParam += "&in_imdg_pck_qty1="     + sheetObj.GetCellValue(nRow, "in_n1st_imdg_pck_qty");  //ComGetObjValue(formObj.in_n1st_imdg_pck_qty);
			sParam += "&in_imdg_pck_qty2="     + sheetObj.GetCellValue(nRow, "in_n2nd_imdg_pck_qty");  //ComGetObjValue(formObj.in_n2nd_imdg_pck_qty);
			sParam += "&intmd_imdg_pck_qty1="  + sheetObj.GetCellValue(nRow, "intmd_n1st_imdg_pck_qty");  //ComGetObjValue(formObj.intmd_n1st_imdg_pck_qty);
			sParam += "&intmd_imdg_pck_qty2="  + sheetObj.GetCellValue(nRow, "intmd_n2nd_imdg_pck_qty");  //ComGetObjValue(formObj.intmd_n2nd_imdg_pck_qty);
			sParam += "&out_imdg_pck_qty1="    + sheetObj.GetCellValue(nRow, "out_n1st_imdg_pck_qty");   //ComGetObjValue(formObj.out_n1st_imdg_pck_qty);
			sParam += "&out_imdg_pck_qty2="    + sheetObj.GetCellValue(nRow, "out_n2nd_imdg_pck_qty");  //ComGetObjValue(formObj.out_n2nd_imdg_pck_qty);
			sParam += "&hcdg_intmd_bc_rstr_desc=" + sheetObj.GetCellValue(nRow, "hcdg_intmd_bc_rstr_desc");  //ComGetObjValue(formObj.hcdg_intmd_bc_rstr_desc);
			sParam += "&hcdg_pck_rstr_desc="      + sheetObj.GetCellValue(nRow, "hcdg_pck_rstr_desc");  //ComGetObjValue(formObj.hcdg_pck_rstr_desc);
			sParam += "&hcdg_tnk_rstr_desc="      + sheetObj.GetCellValue(nRow, "hcdg_tnk_rstr_desc");  //ComGetObjValue(formObj.hcdg_tnk_rstr_desc);
			
		
			//var imdg_lmt_qty_meas_ut_cd=ComGetObjValue(formObj.imdg_lmt_qty_meas_ut_cd);
			//if(imdg_lmt_qty_meas_ut_cd == 'mlg') imdg_lmt_qty_meas_ut_cd="ml or g";
	   		//else if(imdg_lmt_qty_meas_ut_cd == 'lkg') imdg_lmt_qty_meas_ut_cd="l or kg";
			//var ltd_qty=document.getElementById("imdg_lmt_qty").value;
			//sParam += "&ltd_qty="+sheetObj.GetCellValue(nRow, "imdg_lmt_qty");
			//+" "+imdg_lmt_qty_meas_ut_cd;
			//sParam += "&ltd_qty="+ltd_qty;

			//2016-09-28 Lmited/Excepted Qty & Description 
	   		sParam += "&ltd_qty="+sheetObj.GetCellValue(nRow,"imdg_lmt_qty" ); //bkg에서 CONCAT으로 받음
	   		sParam += "&imdg_lmt_qty_desc=" +sheetObj.GetCellValue(nRow, "imdg_lmt_qty_desc");
	   		sParam += "&imdg_expt_qty_cd="+sheetObj.GetCellValue(nRow, "imdg_expt_qty_cd");
			sParam += "&imdg_expt_qty_desc=" +sheetObj.GetCellValue(nRow, "imdg_expt_qty_desc");

			//2016-09-28 Lmited/Excepted Qty & Description
			
			ComOpenPopup("ESM_BKG_0206.do?"+sParam, 710, 600, "" , '1,0,1,1,1,1,1', true, false, nRow, 0, 0, "ESM_BKG_0206");
//			ComOpenPopup("ESM_BKG_0206.do?"+sParam, 710, 600, "getCOM_PKG_QTY_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,"ESM_BKG_0206");
//			ComOpenPopup("ESM_BKG_0206.do?in_imdg_pck_cd1=" + in_imdg_pck_cd1 + "&in_imdg_pck_cd2=" + in_imdg_pck_cd2 + "&intmd_imdg_pck_cd1=" + intmd_imdg_pck_cd1 + "&intmd_imdg_pck_cd2=" + intmd_imdg_pck_cd2 + "&out_imdg_pck_cd1=" + out_imdg_pck_cd1 + "&out_imdg_pck_cd2=" + out_imdg_pck_cd2 + "&in_imdg_pck_desc1=" + in_imdg_pck_desc1 + "&in_imdg_pck_desc2=" + in_imdg_pck_desc2
//					+ "&intmd_imdg_pck_desc1=" + intmd_imdg_pck_desc1 + "&intmd_imdg_pck_desc2=" + intmd_imdg_pck_desc2 + "&out_imdg_pck_desc1=" + out_imdg_pck_desc1 + "&out_imdg_pck_desc2=" + out_imdg_pck_desc2 + "&in_imdg_pck_qty1=" + in_imdg_pck_qty1 + "&in_imdg_pck_qty2=" + in_imdg_pck_qty2 + "&intmd_imdg_pck_qty1=" + intmd_imdg_pck_qty1 + "&intmd_imdg_pck_qty2=" + intmd_imdg_pck_qty2
//					+ "&out_imdg_pck_qty1=" + out_imdg_pck_qty1 + "&out_imdg_pck_qty2=" + out_imdg_pck_qty2 + "&hcdg_intmd_bc_rstr_desc=" + hcdg_intmd_bc_rstr_desc + "&hcdg_pck_rstr_desc=" + hcdg_pck_rstr_desc + "&hcdg_tnk_rstr_desc=" + hcdg_tnk_rstr_desc + "&ltd_qty=" + ltd_qty + "&imdg_expt_qty_cd=" + imdg_expt_qty_cd, 710, 600, "getCOM_PKG_QTY_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
//					"ESM_BKG_0206");
	 		
	 	} else if(srcType == "CopyCntr") {
	 		ComOpenWindowCenter("VOP_SCG_0735.do", "copyCntr", "422", "522", true);
	 	}
    }
    
    function authPending() {
    	if(preConds.pId == "VOP_SCG_5001") {
		   	var formObj=document.form;
		   	ComSetObjValue(formObj.auth_sts_cd,'P');
    	}
    }
    
    function getWinUnInformation() {
    	
    }
     
 	function getCOM_PKG_QTY_POPUP(rowArray) {
 		setDgPkgQtyType2(rowArray);
	}
    
   	/**
	 * DG Package Q'ty & Type Setter
	 */
	function setDgPkgQtyType2(aryPopupData) {
		//2016-02-11
  		if(isView) {
  			return;
  		}
		var formObj  = document.form;
		var sheetObj = sheetObjects[1];
		var Row      = sheetObj.GetSelectRow();
		sheetObj.SetCellValue(Row, "out_n1st_imdg_pck_qty"   ,aryPopupData[0][7] ,0);
		sheetObj.SetCellValue(Row, "out_n1st_imdg_pck_cd"    ,aryPopupData[0][8] ,0);
		sheetObj.SetCellValue(Row, "out_n1st_imdg_pck_desc"  ,aryPopupData[0][9] ,0);
		sheetObj.SetCellValue(Row, "out_n2nd_imdg_pck_qty"   ,aryPopupData[0][10],0);
		sheetObj.SetCellValue(Row, "out_n2nd_imdg_pck_cd"    ,aryPopupData[0][11],0);
		sheetObj.SetCellValue(Row, "out_n2nd_imdg_pck_desc"  ,aryPopupData[0][12],0);
		sheetObj.SetCellValue(Row, "intmd_n1st_imdg_pck_qty" ,aryPopupData[0][13],0);
		sheetObj.SetCellValue(Row, "intmd_n1st_imdg_pck_cd"  ,aryPopupData[0][14],0);
		sheetObj.SetCellValue(Row, "intmd_n1st_imdg_pck_desc",aryPopupData[0][15],0);
		sheetObj.SetCellValue(Row, "intmd_n2nd_imdg_pck_qty" ,aryPopupData[0][16],0);
		sheetObj.SetCellValue(Row, "intmd_n2nd_imdg_pck_cd"  ,aryPopupData[0][17],0);
		sheetObj.SetCellValue(Row, "intmd_n2nd_imdg_pck_desc",aryPopupData[0][18],0);		
		sheetObj.SetCellValue(Row, "in_n1st_imdg_pck_qty"    ,aryPopupData[0][19],0);
		sheetObj.SetCellValue(Row, "in_n1st_imdg_pck_cd"     ,aryPopupData[0][20],0);
		sheetObj.SetCellValue(Row, "in_n1st_imdg_pck_desc"   ,aryPopupData[0][21],0);
		sheetObj.SetCellValue(Row, "in_n2nd_imdg_pck_qty"    ,aryPopupData[0][22],0);
		sheetObj.SetCellValue(Row, "in_n2nd_imdg_pck_cd"     ,aryPopupData[0][23],0);
		sheetObj.SetCellValue(Row, "in_n2nd_imdg_pck_desc"   ,aryPopupData[0][24],0);
		
		
		sheetObj.SetCellValue(Row, "imdg_lmt_qty",aryPopupData[0][28],0);
		sheetObj.SetCellValue(Row, "imdg_lmt_qty_desc",aryPopupData[0][29],0);
		sheetObj.SetCellValue(Row, "imdg_expt_qty_cd",aryPopupData[0][30],0);
		sheetObj.SetCellValue(Row, "imdg_expt_qty_desc",aryPopupData[0][31],0);
		
		
		ComSetObjValue(formObj.out_n1st_imdg_pck_qty,      aryPopupData[0][7] );
		ComSetObjValue(formObj.out_n1st_imdg_pck_cd,       aryPopupData[0][8] );
		ComSetObjValue(formObj.out_n1st_imdg_pck_desc,     aryPopupData[0][9] );
		ComSetObjValue(formObj.out_n2nd_imdg_pck_qty,      aryPopupData[0][10]);
		ComSetObjValue(formObj.out_n2nd_imdg_pck_cd,       aryPopupData[0][11]);
		ComSetObjValue(formObj.out_n2nd_imdg_pck_desc,     aryPopupData[0][12]);
		ComSetObjValue(formObj.intmd_n1st_imdg_pck_qty,    aryPopupData[0][13]);
		ComSetObjValue(formObj.intmd_n1st_imdg_pck_cd,     aryPopupData[0][14]);
		ComSetObjValue(formObj.intmd_n1st_imdg_pck_desc,   aryPopupData[0][15]);
		ComSetObjValue(formObj.intmd_n2nd_imdg_pck_qty,    aryPopupData[0][16]);
		ComSetObjValue(formObj.intmd_n2nd_imdg_pck_cd,     aryPopupData[0][17]);
		ComSetObjValue(formObj.intmd_n2nd_imdg_pck_desc,   aryPopupData[0][18]);
		ComSetObjValue(formObj.in_n1st_imdg_pck_qty,       aryPopupData[0][19]);
		ComSetObjValue(formObj.in_n1st_imdg_pck_cd,        aryPopupData[0][20]);
		ComSetObjValue(formObj.in_n1st_imdg_pck_desc,      aryPopupData[0][21]);
		ComSetObjValue(formObj.in_n2nd_imdg_pck_qty,       aryPopupData[0][22]);
		ComSetObjValue(formObj.in_n2nd_imdg_pck_cd,        aryPopupData[0][23]);
		ComSetObjValue(formObj.in_n2nd_imdg_pck_desc,      aryPopupData[0][24]);
		
		ComSetObjValue(formObj.imdg_lmt_qty,aryPopupData[0][28]);
		ComSetObjValue(formObj.imdg_lmt_qty_desc,aryPopupData[0][29]);
		ComSetObjValue(formObj.imdg_expt_qty_cd,aryPopupData[0][30]);
		ComSetObjValue(formObj.imdg_expt_qty_desc,aryPopupData[0][31]);

		checkPkgQty();
		//2016-02-11
		
	}	
 	
    /**
     * Pre-Checking Pop-Up
     */
    function onPreChkPopup(sheetObj, formObj, popType,  width, height) {
    	//Form values --> Sheet
		setFormToSheetAll(sheetObj, sheetObj.GetSelectRow(), formObj.imdg_clss_cd, formObj.auth_sts_cd);
    	formObj.f_cmd.value=SEARCH;
    	ComOpenPopup("VOP_SCG_0069.do?pop_type="+popType+"&"+FormQueryString(formObj), 940, 990, "getWinPreChecking", "1,0", false);    	
    }
    
    function getWinPreChecking(returnVal) {
    	
    }
    /**
     * Making parameter of Pre-Checking
     */
    function makePreChkParam() {
    	var sheetObj2=sheetObjects[1];		
		var formObj=document.form;
		var sParam="";
		for(var i=sheetObj2.HeaderRows(); i<=sheetObj2.LastRow(); i++) {
			if(sheetObj2.GetRowStatus(i) != 'D') {
				for(var j=0; j<=sheetObj2.LastCol(); j++) {
					sParam += sheetObj2.ColSaveName(j)+"="+sheetObj2.GetCellValue(i, j)+"&";
				}
			}
		}
		sParam += "rgn_shp_opr_cd="+ComGetObjValue(formObj.rgn_shp_opr_cd);
		sParam += "&cgo_opr_cd="+ComGetObjValue(formObj.cgo_opr_cd);
		sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_ref_no);
		sParam += "&vsl_cd="+ComGetObjValue(formObj.vsl_cd);
		sParam += "&skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
		sParam += "&skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
		sParam += "&crr_cd="+ComGetObjValue(formObj.crr_cd);
		sParam += "&slan_cd="+ComGetObjValue(formObj.slan_cd);
		sParam += "&pol_cd="+ComGetObjValue(pol_cd);
		sParam += "&pod_cd="+ComGetObjValue(pod_cd);
		sParam += "&imdg_segr_grp_no=" + imdg_segr_grp_no.GetSelectCode();
		sParam += "&imdg_un_no=" + ComGetObjValue(formObj.imdg_un_no);
		return sParam;
    }
    /**
   	 * Setting data from BKG Company Help (Pop-Up).<br>
   	 * @param {arry} rtnObjs
   	 */
   	function setCallBackCarrier(rtnObjs) {
   		if(rtnObjs){
 			var rtnDatas=rtnObjs[0];
 			if(rtnDatas){
 				if(rtnDatas.length > 0){
 					ComSetObjValue(document.form.cgo_opr_cd, rtnDatas[3]);
 					ComSetFocus(document.form.bkg_no);
 				}
 			}
     	}
   	} 
    /**
   	 * Setting data from VSL/VVD Code Help (Pop-Up).<br>
   	 * @param {arry} rtnObjs
   	 */
   	function setCallBackVSL(rtnObjs) {
   		if(rtnObjs){
 			var rtnDatas=rtnObjs[0];
 			if(rtnDatas){
 				if(rtnDatas.length > 0){
 					ComSetObjValue(document.form.vsl_cd, rtnDatas[1]);
 					ComSetObjValue(document.form.crr_cd, rtnDatas[3]);
 					ComSetFocus(document.form.skd_voy_no);
 				}
 			}
     	}
   	} 
    /**
   	 * Setting data from (Sheet)VVD Code Help (Pop-Up).<br>
   	 * @param {arry} obj
   	 */
   	function setCallBackVVD(obj) {
   		if(obj){
 			var rtnDatas=obj[0];
 			if(rtnDatas){
 				if(rtnDatas.length > 0){
 					ComSetObjValue(document.form.skd_voy_no, rtnDatas[2]);
 					ComSetObjValue(document.form.skd_dir_cd, rtnDatas[3]);
 					searchVVDCheck();	//retrieve Lane
 					doActionIBCombo(sheetObjects[1], comboObjects[0], 1, '');	// retrieve POL
 				}
 			}
     	}
   	}
//   	/**
// 	 * Dropping UN Number popup selected item - SCG
// 	 */
// 	function setCallBackUnNo(aryPopupData) {
// 		var formObj=document.form;
// 		ComSetObjValue(formObj.imdg_un_no, 			aryPopupData[0][2]);
// 		ComSetObjValue(formObj.imdg_un_no_seq, 		aryPopupData[0][3]);
// 		ComSetObjValue(formObj.imdg_clss_cd, 		aryPopupData[0][4]);
// 		ComSetObjValue(formObj.imdg_comp_grp_cd, 	aryPopupData[0][5]);
// 		ComSetObjValue(formObj.prp_shp_nm, 			aryPopupData[0][6]);
// 		ComSetObjValue(formObj.hzd_desc, 			aryPopupData[0][7]);
// 		ComSetObjValue(formObj.imdg_pck_grp_cd, 	aryPopupData[0][9]);
// 		ComSetObjValue(formObj.psa_no, 				aryPopupData[0][14]);
// 		ComSetObjValue(formObj.hcdg_pck_rstr_desc, 		aryPopupData[0][17]);
// 		ComSetObjValue(formObj.hcdg_intmd_bc_rstr_desc, aryPopupData[0][18]);
// 		ComSetObjValue(formObj.hcdg_tnk_rstr_desc, 		aryPopupData[0][19]);
// 		ComSetObjValue(formObj.imdg_lmt_qty, 		    aryPopupData[0][11]);
// 		ComSetObjValue(formObj.imdg_expt_qty_cd, 		aryPopupData[0][12]);
// 		ComSetObjValue(formObj.ems_no, 		            aryPopupData[0][20]);
// 		ComSetObjValue(formObj.ctrl_temp_ctnt, 		    aryPopupData[0][21]);
// 		ComSetObjValue(formObj.emer_rspn_gid_no, 		aryPopupData[0][22]);
// 		ComSetObjValue(formObj.emer_rspn_gid_chr_no,    aryPopupData[0][23]);
// 		ComSetObjValue(formObj.emer_temp_ctnt, 		    aryPopupData[0][24]);
// 		ComSetObjValue(formObj.imdg_lmt_qty_meas_ut_cd, aryPopupData[0][25]);
// 		ComSetObjValue(formObj.hcdg_flg,                aryPopupData[0][14]);
// 		ComSetObjValue(formObj.imdg_subs_rsk_lbl_rmk,   aryPopupData[0][13]);
// 		var imdg_subs_rsk_lbl_cd=aryPopupData[0][8];
// 		if(imdg_subs_rsk_lbl_cd != null) {
// 			imdg_subs_rsk_lbl_cd=imdg_subs_rsk_lbl_cd.split("|");
// 			var formItems=new Array();
// 			formItems[0]="n1st";
// 			formItems[1]="n2nd";
// 			formItems[2]="n3rd";
// 			formItems[3]="n4th";
// 			var subsRsk="";
//	 		for(var i=0; i<4; i++) {
//	 			if(i < imdg_subs_rsk_lbl_cd.length) subsRsk=imdg_subs_rsk_lbl_cd[i];
//	 			else subsRsk="";
//	 			ComSetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd"), subsRsk);
//	 		}
// 		}
// 		//Setting Marin Pollutant value
// 		var imdg_mrn_polut_cd=aryPopupData[0][26]=='P'?'Y':'N';
// 		mrn_polut_flg.SetSelectCode(imdg_mrn_polut_cd,false);
// 		var hcdg_flg=ComGetObjValue(formObj.hcdg_flg);
// 		var imdg_subs_rsk_lbl_rmk=ComGetObjValue(formObj.imdg_subs_rsk_lbl_rmk);
// 		//HCDG/Remark(s) Button color change
// 		chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk);
// 		//In case of UN No. applying SP274, set Technical Name as compulsory item.
// 		var imdg_spcl_provi_no=aryPopupData[0][16]; 		
// 		var proviNos; 		
// 		var itemObj=document.getElementById("hzd_desc"); 		
// 		var imdgSpclProviNo=""; 	
// 		if(imdg_spcl_provi_no.length > 0) {
// 			proviNos=imdg_spcl_provi_no.split("|");
// 			if(proviNos.length > 0) {
//		 		for(var pIdx=0; pIdx<proviNos.length; pIdx++) {
//		 			if(proviNos[pIdx] == '274') imdgSpclProviNo=proviNos[pIdx];
//		 		}
// 			}
// 		}  		
// 		chgTecNmBox(imdgSpclProviNo, itemObj);
// 		ComSetObjValue(formObj.imdg_spcl_provi_no, imdgSpclProviNo);
// 		//Initialize Flash Point input value
// 		ComSetObjValue(formObj.flsh_pnt_cdo_temp, "");	
// 		//Flash Point status change decision
// 		fixFlshPointForm(formObj); 
// 		//Initializing Pre-Checking Report result
//		setPreChkRslt("N");
//		
//   		var cfr_flg = document.getElementById("cfr_flg").value;
//   		if(cfr_flg == "Y"){
//			document.getElementById("cfr_flg").checked=true;
//		}else{ // F
//			document.getElementById("cfr_flg").checked=false;
//		}
// 	}
 	/**
  	 * Dropping UN Number popup selected item - BKG
  	 */
  	function setCallBackUnNo2(aryPopupData) {
  		if(isView) {
  			return;
  		}
  		var formObj=document.form;
  		var sheetObj2=sheetObjects[1];
  		var Row      = sheetObj2.GetSelectRow();
  		
  		if(preConds.src_tp_cd == "EDI"){
  			
  			if(ComGetObjValue(formObj.imdg_un_no) == "")       ComSetObjValue(formObj.imdg_un_no, 			aryPopupData[0][2]);
  			if(ComGetObjValue(formObj.imdg_un_no_seq) == "")   ComSetObjValue(formObj.imdg_un_no_seq, 		aryPopupData[0][3]);
  			if(ComGetObjValue(formObj.imdg_clss_cd) == "")     ComSetObjValue(formObj.imdg_clss_cd, 		aryPopupData[0][4]);
  			if(ComGetObjValue(formObj.imdg_amdt_no) == "")     ComSetObjValue(formObj.imdg_amdt_no, 		aryPopupData[0][36]);
  			if(ComGetObjValue(formObj.imdg_comp_grp_cd) == "") ComSetObjValue(formObj.imdg_comp_grp_cd, 	aryPopupData[0][5]);
  			ComSetObjValue(formObj.prp_shp_nm, 			aryPopupData[0][7]);
  			if(ComGetObjValue(formObj.hzd_desc) == "")         ComSetObjValue(formObj.hzd_desc, 			aryPopupData[0][9]);
  	  		var imdg_pck_grp_cd=aryPopupData[0][6];
  	  		if(imdg_pck_grp_cd == '1') imdg_pck_grp_cd="I";
  	  		else if(imdg_pck_grp_cd == '2') imdg_pck_grp_cd="II";
  	  		else if(imdg_pck_grp_cd == '3') imdg_pck_grp_cd="III";
  	  		if(ComGetObjValue(formObj.imdg_pck_grp_cd) == "")         ComSetObjValue(formObj.imdg_pck_grp_cd, 	imdg_pck_grp_cd);
  	  		if(ComGetObjValue(formObj.psa_no) == "")                  ComSetObjValue(formObj.psa_no, 				aryPopupData[0][15]);
  	  		if(ComGetObjValue(formObj.hcdg_pck_rstr_desc) == "")      ComSetObjValue(formObj.hcdg_pck_rstr_desc, 		aryPopupData[0][29]);
  	  		if(ComGetObjValue(formObj.hcdg_intmd_bc_rstr_desc) == "") ComSetObjValue(formObj.hcdg_intmd_bc_rstr_desc, aryPopupData[0][30]);
  	  		if(ComGetObjValue(formObj.hcdg_tnk_rstr_desc) == "")      ComSetObjValue(formObj.hcdg_tnk_rstr_desc, 		aryPopupData[0][31]);
			//2016-09-28 Lmited/Excepted Qty & Description
  	  		if(ComGetObjValue(formObj.imdg_lmt_qty) == "")            ComSetObjValue(formObj.imdg_lmt_qty, 		    aryPopupData[0][20]);
  	  		if(ComGetObjValue(formObj.imdg_lmt_qty_desc) == "")            ComSetObjValue(formObj.imdg_lmt_qty_desc, 		    aryPopupData[0][21]);
  	  		if(ComGetObjValue(formObj.imdg_expt_qty_cd) == "")        ComSetObjValue(formObj.imdg_expt_qty_cd, 		aryPopupData[0][22]);
  	  		if(ComGetObjValue(formObj.imdg_expt_qty_desc) == "")            ComSetObjValue(formObj.imdg_expt_qty_desc, 		    aryPopupData[0][23]);  	  		
  	  		if(ComGetObjValue(formObj.ems_no) == "")                  ComSetObjValue(formObj.ems_no, 		            aryPopupData[0][17]);
  	  		if(ComGetObjValue(formObj.ctrl_temp_ctnt) == "")          ComSetObjValue(formObj.ctrl_temp_ctnt, 		    aryPopupData[0][32]);
  	  		if(ComGetObjValue(formObj.emer_rspn_gid_no) == "")        ComSetObjValue(formObj.emer_rspn_gid_no, 		aryPopupData[0][18]);
  	  		if(ComGetObjValue(formObj.emer_rspn_gid_chr_no) == "")    ComSetObjValue(formObj.emer_rspn_gid_chr_no,    aryPopupData[0][19]);
  	  		if(ComGetObjValue(formObj.emer_temp_ctnt) == "")          ComSetObjValue(formObj.emer_temp_ctnt, 		    aryPopupData[0][33]);
  	  		if(ComGetObjValue(formObj.imdg_lmt_qty_meas_ut_cd) == "") ComSetObjValue(formObj.imdg_lmt_qty_meas_ut_cd, aryPopupData[0][34]);
  	  		if(ComGetObjValue(formObj.hcdg_flg) == "")                ComSetObjValue(formObj.hcdg_flg,                aryPopupData[0][24]);
  	 		//ComSetObjValue(formObj.imdg_subs_rsk_lbl_rmk,   aryPopupData[0][8]);
  	 		var prp_shp_nm=aryPopupData[0][7];
  	 		if(prp_shp_nm.indexOf("N.O.S.") >= 0) {
  	 			if(imdg_segr_grp_no.GetSelectCode() == "") imdg_segr_grp_no.SetSelectCode("0", false);
  	 		}
  	  		var imdg_subs_rsk_lbl_cd=aryPopupData[0][10]+"|"+aryPopupData[0][11]+"|"+aryPopupData[0][12]+"|"+aryPopupData[0][13];
  	  		if(imdg_subs_rsk_lbl_cd != null) {
  	  			imdg_subs_rsk_lbl_cd=imdg_subs_rsk_lbl_cd.split("|");
  	  			var formItems=new Array();
  	  			formItems[0]="n1st";
  	  			formItems[1]="n2nd";
  	  			formItems[2]="n3rd";
  	  			formItems[3]="n4th";
  	  			var subsRsk="";
  	 	 		for(var i=0; i<4; i++) {
  	 	 			if(i < imdg_subs_rsk_lbl_cd.length) subsRsk=imdg_subs_rsk_lbl_cd[i];
  	 	 			else subsRsk="";
  	 	 			if(ComGetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd")) == "") ComSetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd"), subsRsk);
  	 	 		}
  	  		}
  	  		//Setting Marin Pollutant value
  	 		var imdg_mrn_polut_cd=aryPopupData[0][16]=='P'?'Y':'N';
  	 		mrn_polut_flg.SetSelectCode(imdg_mrn_polut_cd,false);
  	 		var hcdg_flg=ComGetObjValue(formObj.hcdg_flg);
  	 		var imdg_subs_rsk_lbl_rmk=ComGetObjValue(formObj.imdg_subs_rsk_lbl_rmk);
  	 		//HCDG/Remark(s) Button color change
  	 		chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk);
  	  		//In case of UN No. applying SP274, set Technical Name as compulsory item.
  	  		var imdg_spcl_provi_no=aryPopupData[0][26]; 		
  	  		var proviNos; 		
  	  		var itemObj=document.getElementById("hzd_desc"); 		
  	  		var imdgSpclProviNo=""; 	
  	  		if(imdg_spcl_provi_no.length > 0) {
  	  			proviNos=imdg_spcl_provi_no.split("|");
  	  			if(proviNos.length > 0) {
  	 		 		for(var pIdx=0; pIdx<proviNos.length; pIdx++) {
  	 		 			if(proviNos[pIdx] == '274' || proviNos[pIdx] == '318') imdgSpclProviNo=proviNos[pIdx];
  	 		 		}
  	  			}
  	  		}
  	  		chgTecNmBox(imdgSpclProviNo, itemObj, sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "mrn_polut_flg"));
  	  		//chgTecNmBox(imdgSpclProviNo, itemObj);
  	  		if(ComGetObjValue(formObj.imdg_spcl_provi_no) == "") ComSetObjValue(formObj.imdg_spcl_provi_no, imdgSpclProviNo);
  	  		//Initializing Flash Point value
  	 		//ComSetObjValue(formObj.flsh_pnt_cdo_temp, "");	
  	 		if(ComGetObjValue(formObj.flsh_pnt_cdo_temp) == "") ComSetObjValue(formObj.flsh_pnt_cdo_temp, aryPopupData[0][14]);
  	  		//Flash Point status change decision
  	  		fixFlshPointForm(formObj);
  	  		//Initializing Pre-Checking Report result
  	 		setPreChkRslt("N");
  	   		var imdg_un_no_seq = document.getElementById("imdg_un_no_seq").value;
  			var cfr_flg = aryPopupData[0][37];
//  			if(imdg_un_no_seq >= 490){
  	   		if(cfr_flg == "Y"){
  				document.getElementById("cfr_flg").checked=true;
  			}else{
  				document.getElementById("cfr_flg").checked=false;
  			}
  		}else{
  			ComSetObjValue(formObj.imdg_un_no, 			aryPopupData[0][2]);
  	  		ComSetObjValue(formObj.imdg_un_no_seq, 		aryPopupData[0][3]);
  	  		ComSetObjValue(formObj.imdg_clss_cd, 		aryPopupData[0][4]);
  	  		ComSetObjValue(formObj.imdg_amdt_no, 		aryPopupData[0][36]);
  	  		ComSetObjValue(formObj.imdg_comp_grp_cd, 	aryPopupData[0][5]);
  	  		ComSetObjValue(formObj.prp_shp_nm, 			aryPopupData[0][7]);
  	  		ComSetObjValue(formObj.hzd_desc, 			aryPopupData[0][9]);
  	  		var imdg_pck_grp_cd=aryPopupData[0][6];
  	  		if(imdg_pck_grp_cd == '1') imdg_pck_grp_cd="I";
  	  		else if(imdg_pck_grp_cd == '2') imdg_pck_grp_cd="II";
  	  		else if(imdg_pck_grp_cd == '3') imdg_pck_grp_cd="III";
  	  		ComSetObjValue(formObj.imdg_pck_grp_cd, 	imdg_pck_grp_cd);
  	  		ComSetObjValue(formObj.psa_no, 				aryPopupData[0][15]);
  	  		ComSetObjValue(formObj.hcdg_pck_rstr_desc, 		aryPopupData[0][29]);
  	  		ComSetObjValue(formObj.hcdg_intmd_bc_rstr_desc, aryPopupData[0][30]);
  	  		ComSetObjValue(formObj.hcdg_tnk_rstr_desc, 		aryPopupData[0][31]);
			//2016-09-28 Lmited/Excepted Qty & Description  	  		 	  		
  	  		ComSetObjValue(formObj.imdg_lmt_qty, 		    aryPopupData[0][20]);
  	    	ComSetObjValue(formObj.imdg_lmt_qty_desc, 	    aryPopupData[0][21]);
  	  		ComSetObjValue(formObj.imdg_expt_qty_cd, 		aryPopupData[0][22]);
  	  	    ComSetObjValue(formObj.imdg_expt_qty_desc, 		aryPopupData[0][23]); 
  	  	    
  	  	    sheetObj2.SetCellValue(Row, "imdg_lmt_qty",aryPopupData[0][20],0);
  	  	    sheetObj2.SetCellValue(Row, "imdg_lmt_qty_desc",aryPopupData[0][21],0);
  	  	    sheetObj2.SetCellValue(Row, "imdg_expt_qty_cd",aryPopupData[0][22],0);
  	  		sheetObj2.SetCellValue(Row, "imdg_expt_qty_desc",aryPopupData[0][23],0);
  	  	    
//  	  		//2016-05-18 Limited qty, Excepted qty 수정
//  			if (aryPopupData[0][20] == "" || aryPopupData[0][20] == "0") {
//  				//document.form.imdg_lmt_qty_flg.value="N";
//  	  		    imdg_lmt_qty_flg.SetSelectCode('N',false);
//  			}
//  			if (aryPopupData[0][21] == "" ||aryPopupData[0][21] == "E0") {
//  				imdg_expt_qty_flg.SetSelectCode('N',false);
//  				//ComSetObjValue(formObj.imdg_lmt_qty_flg, ,"N",0);
//  				
//  			}else{
//  				//document.form.imdg_expt_qty_flg.value="Y";
//  				imdg_expt_qty_flg.SetSelectCode('Y',false);
//  	  			}
//  	  		//2016-05-18
  			
  	  		ComSetObjValue(formObj.ems_no, 		            aryPopupData[0][17]);
  	  		ComSetObjValue(formObj.ctrl_temp_ctnt, 		    aryPopupData[0][32]);
  	  		ComSetObjValue(formObj.emer_rspn_gid_no, 		aryPopupData[0][18]);
  	  		ComSetObjValue(formObj.emer_rspn_gid_chr_no,    aryPopupData[0][19]);
  	  		ComSetObjValue(formObj.emer_temp_ctnt, 		    aryPopupData[0][33]);
  	  		ComSetObjValue(formObj.imdg_lmt_qty_meas_ut_cd, aryPopupData[0][34]);
  	  		ComSetObjValue(formObj.hcdg_flg,                aryPopupData[0][24]);
  	 		//ComSetObjValue(formObj.imdg_subs_rsk_lbl_rmk,   aryPopupData[0][8]);
  	 		var prp_shp_nm=aryPopupData[0][7];
  	 		if(prp_shp_nm.indexOf("N.O.S.") >= 0) {
  	 			imdg_segr_grp_no.SetSelectCode("0", false);
  	 		}
  	  		var imdg_subs_rsk_lbl_cd=aryPopupData[0][10]+"|"+aryPopupData[0][11]+"|"+aryPopupData[0][12]+"|"+aryPopupData[0][13];
  	  		if(imdg_subs_rsk_lbl_cd != null) {
  	  			imdg_subs_rsk_lbl_cd=imdg_subs_rsk_lbl_cd.split("|");
  	  			var formItems=new Array();
  	  			formItems[0]="n1st";
  	  			formItems[1]="n2nd";
  	  			formItems[2]="n3rd";
  	  			formItems[3]="n4th";
  	  			var subsRsk="";
  	 	 		for(var i=0; i<4; i++) {
  	 	 			if(i < imdg_subs_rsk_lbl_cd.length) subsRsk=imdg_subs_rsk_lbl_cd[i];
  	 	 			else subsRsk="";
  	 	 			ComSetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd"), subsRsk);
  	 	 		}
  	  		}
  	  		//Setting Marin Pollutant value
  	 		var imdg_mrn_polut_cd=aryPopupData[0][16]=='P'?'Y':'N';
  	 		mrn_polut_flg.SetSelectCode(imdg_mrn_polut_cd,false);
  	 		var hcdg_flg=ComGetObjValue(formObj.hcdg_flg);
  	 		var imdg_subs_rsk_lbl_rmk=ComGetObjValue(formObj.imdg_subs_rsk_lbl_rmk);
  	 		//HCDG/Remark(s) Button color change
  	 		chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk);
  	  		//In case of UN No. applying SP274, set Technical Name as compulsory item.
  	  		var imdg_spcl_provi_no=aryPopupData[0][26]; 		
  	  		var proviNos; 		
  	  		var itemObj=document.getElementById("hzd_desc"); 		
  	  		var imdgSpclProviNo=""; 	
  	  		if(imdg_spcl_provi_no.length > 0) {
  	  			proviNos=imdg_spcl_provi_no.split("|");
  	  			if(proviNos.length > 0) {
  	 		 		for(var pIdx=0; pIdx<proviNos.length; pIdx++) {
  	 		 			if(proviNos[pIdx] == '274' || proviNos[pIdx] == '318') imdgSpclProviNo=proviNos[pIdx];
  	 		 		}
  	  			}
  	  		}
  	  		
  	  		chgTecNmBox(imdgSpclProviNo, itemObj, imdg_mrn_polut_cd);
  	  		ComSetObjValue(formObj.imdg_spcl_provi_no, imdgSpclProviNo);
  	  		//Initializing Flash Point value
  	 		ComSetObjValue(formObj.flsh_pnt_cdo_temp, "");	
  	  		//Flash Point status change decision
  	  		fixFlshPointForm(formObj); 
  	  		//Initializing Pre-Checking Report result
  	 		setPreChkRslt("N");
  	 		
  	   		var imdg_un_no_seq = document.getElementById("imdg_un_no_seq").value;
  			var cfr_flg = aryPopupData[0][37];
//  			if(imdg_un_no_seq >= 490){
  	   		if(cfr_flg == "Y"){
  				document.getElementById("cfr_flg").checked=true;
  			}else{
  				document.getElementById("cfr_flg").checked=false;
  			}
  		}
  		
		// class가 1일 경우, 필수 항목 추가
		var arrImdgClssCd = ComGetObjValue(formObj.imdg_clss_cd).split('.');
		if(arrImdgClssCd.length == 2 && arrImdgClssCd[0] == '1') {
  	  		document.querySelector("#cnee_dtl_desc").setAttribute('class', 'input1');
  	  		document.querySelector("#net_explo_wgt").setAttribute('class', 'input1');
  	  		document.querySelector("#cnee_dtl_desc").setAttribute('required', 'true');
  	  		document.querySelector("#net_explo_wgt").setAttribute('required', 'true');
		} else {
			document.querySelector("#cnee_dtl_desc").setAttribute('class', 'input');
			document.querySelector("#net_explo_wgt").setAttribute('class', 'input');
			document.querySelector("#cnee_dtl_desc").removeAttribute('required');
	    	document.querySelector("#net_explo_wgt").removeAttribute('required');
		}
		class1Only();
		checkImdgUnNoSeq();
  	}
 	
  	/*
  	 * class 1일경우, 필수 항목을 추가한다.
  	 */
  	function class1Only() {
  		var formObj = document.form;
		var arrImdgClssCd = ComGetObjValue(formObj.imdg_clss_cd).split('.');
		if(arrImdgClssCd.length == 2 && arrImdgClssCd[0] == '1') {
  	  		document.querySelector("#cnee_dtl_desc").setAttribute('class', 'input1');
  	  		document.querySelector("#net_explo_wgt").setAttribute('class', 'input1');
  	  		document.querySelector("#cnee_dtl_desc").setAttribute('required', 'true');
  	  		document.querySelector("#net_explo_wgt").setAttribute('required', 'true');
		} else {
			document.querySelector("#cnee_dtl_desc").setAttribute('class', 'input');
			document.querySelector("#net_explo_wgt").setAttribute('class', 'input');
			document.querySelector("#cnee_dtl_desc").removeAttribute('required');
	    	document.querySelector("#net_explo_wgt").removeAttribute('required');
	    	ComSetObjValue(formObj.cnee_dtl_desc, "");
	    	ComSetObjValue(formObj.net_explo_wgt, "");
		}
  	}
  	
 	/**
 	 * Retrieve Hidden IBSheet information for upload.
 	 */
 	function getFileUpload() {
 		var sheetObj=sheetObjects[2];
 		if(sheetObj.RowCount()== 0) return null;
 		return sheetObj; 
 	}
 	/**
  	 * Remark Setter
  	 */
  	function setRemark(value) {
  		ComSetObjValue(document.form.diff_rmk, value);
  	}
  	/**
   	 * Remark Getter
   	 */
   	function getRemark() {
   		return ComGetObjValue(document.form.diff_rmk);
   	}
   	/**
  	 * Other_Emergency_Information Setter
  	 */
  	function setOtherEmergencyInformation(formObj) {
  		ComSetObjValue(document.form.ems_no,               ComGetObjValue(formObj.ems_no));
  		ComSetObjValue(document.form.ctrl_temp_ctnt,       ComGetObjValue(formObj.ctrl_temp_ctnt));
  		ComSetObjValue(document.form.emer_rspn_gid_no,     ComGetObjValue(formObj.emer_rspn_gid_no));
  		ComSetObjValue(document.form.emer_rspn_gid_chr_no, ComGetObjValue(formObj.emer_rspn_gid_chr_no));
  		ComSetObjValue(document.form.emer_temp_ctnt,       ComGetObjValue(formObj.emer_temp_ctnt));
  	}
  	/**
   	 * Other_Emergency_Information Setter
   	 */
   	function getCOM_EMER_NO_POPUP(aryPopupData) {
   		ComSetObjValue(document.form.ems_no,               aryPopupData[0][5]);
   		ComSetObjValue(document.form.ctrl_temp_ctnt,       aryPopupData[0][6]);
   		ComSetObjValue(document.form.emer_rspn_gid_no,     aryPopupData[0][7]);
   		ComSetObjValue(document.form.emer_rspn_gid_chr_no, aryPopupData[0][8]);
   		ComSetObjValue(document.form.emer_temp_ctnt,       aryPopupData[0][9]);
   		
   		//2016-01-25
   		//ComSetObjValue(document.form.erap_no,       aryPopupData[0][9]);
   		//ComSetObjValue(document.form.erap_cntc_no,       aryPopupData[0][10]);
   		//ComSetObjValue(document.form.erap_apro_ref_no,       aryPopupData[0][11]);
  	
   	}
   	
//	function getCOM_EMER_NO_POPUP(rowArray) {
//		var formObject=document.form;
//		var colArray=rowArray[0];
//		//var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
//		//var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
//		if (document.getElementById("ems_no").value != colArray[5]) {
//			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
//		}
//		document.getElementById("ems_no").value=colArray[5];
//		document.getElementById("ctrl_temp_ctnt").value=colArray[6];
//		document.getElementById("emer_rspn_gid_no").value=colArray[7];
//		document.getElementById("emer_rspn_gid_chr_no").value=colArray[8];
//		ocument.getElementById("emer_temp_ctnt").value=colArray[9];
//		
//		document.getElementById("erap_no").value=colArray[9];
//		document.getElementById("erap_cntc_no").value=colArray[10];
//		document.getElementById("erap_apro_ref_no").value=colArray[11];
//		
//		sheetObjects[3].SetCellValue(row, "ems_no",colArray[4]);
//		sheetObjects[3].SetCellValue(row, "ctrl_temp_ctnt",colArray[5]);
//		sheetObjects[3].SetCellValue(row, "emer_rspn_gid_no",colArray[6]);
//		sheetObjects[3].SetCellValue(row, "emer_rspn_gid_chr_no",colArray[7]);
//		sheetObjects[3].SetCellValue(row, "emer_temp_ctnt",colArray[8]);
//		
//		sheetObjects[3].SetCellValue(row, "erap_no",colArray[9]);
//		sheetObjects[3].SetCellValue(row, "erap_cntc_no",colArray[10]);
//		sheetObjects[3].SetCellValue(row, "erap_apro_ref_no",colArray[11]);
//		
//	}
   	
  	/**
   	 * Other_Emergency_Information Getter
   	 */
   	function getOtherEmergencyInformation() {
   		return document.form;
   	}
   	/**
   	 * DG Package Q'ty & Type Setter
   	 */
   	function setDgPkgQtyType(formObj) {
   		ComSetObjValue(document.form.out_n1st_imdg_pck_qty,      ComGetObjValue(formObj.out_imdg_pck_qty1));
   		ComSetObjValue(document.form.out_n1st_imdg_pck_cd,       ComGetObjValue(formObj.out_imdg_pck_cd1));
   		ComSetObjValue(document.form.out_n1st_imdg_pck_desc,     ComGetObjValue(formObj.out_imdg_pck_desc1));
   		ComSetObjValue(document.form.out_n2nd_imdg_pck_qty,      ComGetObjValue(formObj.out_imdg_pck_qty2));
   		ComSetObjValue(document.form.out_n2nd_imdg_pck_cd,       ComGetObjValue(formObj.out_imdg_pck_cd2));
   		ComSetObjValue(document.form.out_n2nd_imdg_pck_desc,     ComGetObjValue(formObj.out_imdg_pck_desc2));
   		ComSetObjValue(document.form.in_n1st_imdg_pck_qty,       ComGetObjValue(formObj.in_imdg_pck_qty1));
   		ComSetObjValue(document.form.in_n1st_imdg_pck_cd,        ComGetObjValue(formObj.in_imdg_pck_cd1));
   		ComSetObjValue(document.form.in_n1st_imdg_pck_desc,      ComGetObjValue(formObj.in_imdg_pck_desc1));
   		ComSetObjValue(document.form.in_n2nd_imdg_pck_qty,       ComGetObjValue(formObj.in_imdg_pck_qty2));
   		ComSetObjValue(document.form.in_n2nd_imdg_pck_cd,        ComGetObjValue(formObj.in_imdg_pck_cd2));
   		ComSetObjValue(document.form.in_n2nd_imdg_pck_desc,      ComGetObjValue(formObj.in_imdg_pck_desc2));
   		ComSetObjValue(document.form.max_in_pck_qty,             ComGetObjValue(formObj.max_in_pck_qty));
   		ComSetObjValue(document.form.max_in_pck_tp_cd,           ComGetObjValue(formObj.max_in_pck_tp_cd));
   		var max_in_pck_qty=ComGetObjValue(formObj.max_in_pck_qty);
		if(max_in_pck_qty == '' || max_in_pck_qty == '0') {		
			imdg_lmt_qty_flg.SetSelectCode('N',false);
			imdg_expt_qty_flg.SetSelectCode('N',false);
		}
   	}

   	/**
   	 * DG Package Q'ty & Type Getter
   	 */
   	function getDgPkgQtyType() {
   		return document.form;
   	}
   	/**
	 * DG application copy's Container Getter
	 */
	function getCntrList() {
		return sheetObjects[0];
	}
	/**
	 * Copy Container
	 */
	function copyCntr(option, ct, sheetObj) {
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var selCntrSeq=sheetObj1.GetCellValue(sheetObj1.GetSelectRow(), "spcl_cntr_seq");
		var selCntrRow=sheetObj1.GetSelectRow();
		var selCgoRow=sheetObj2.GetSelectRow();
		if(validateForm(sheetObj2,document.form,-1,IBSEARCH_ASYNC01)) {	//Cargo info compulsory check
			if(option == '1' || option == '2') {
				for(var copyCt=0; copyCt<ct; copyCt++) {
					with(sheetObj1) {
						var selRow=FindText("spcl_cntr_seq", selCntrSeq, 0, -1, true);
						if(selRow != -1) {
							addCntrRow(sheetObj1);
							for(var cntrIdx=SaveNameCol("cntr_tpsz_cd"); cntrIdx<=SaveNameCol("cntr_tpsz_cd"); cntrIdx++) {
								SetCellValue(GetSelectRow(), cntrIdx,GetCellValue(selRow, cntrIdx),0);
							}
						}
					}
					with(sheetObj2) {
						if(option == '1') {
							var fstRow=FindText("spcl_cntr_seq", selCntrSeq, 0, -1, true);
							if(fstRow != -1) {
								var cgoCntrSeq;
								for(var cgoRowIdx=fstRow; cgoRowIdx<=LastRow(); cgoRowIdx++) {
									cgoCntrSeq=GetCellValue(cgoRowIdx, "spcl_cntr_seq");
									if(cgoCntrSeq == selCntrSeq && GetRowStatus(cgoRowIdx) != 'D') {
										addCgoRow(sheetObj1, sheetObj2);
										for(var cgoIdx=SaveNameCol("cntr_tpsz_cd"); cgoIdx<=SaveNameCol("diff_rmk"); cgoIdx++) {
											SetCellValue(GetSelectRow(), cgoIdx,GetCellValue(cgoRowIdx, cgoIdx),0);
										}
										SelectCell(GetSelectRow(), "spcl_cntr_seq");
									}
								}
							}
						} else if(option == '2') {
							if(selCgoRow >= HeaderRows()) {
								addCgoRow(sheetObj1, sheetObj2);
								for(var cgoIdx=SaveNameCol("cntr_tpsz_cd"); cgoIdx<=SaveNameCol("diff_rmk"); cgoIdx++) {
									SetCellValue(GetSelectRow(), cgoIdx,GetCellValue(selCgoRow, cgoIdx),0);
								}
								SelectCell(GetSelectRow(), "spcl_cntr_seq");
							}
						}
					}
				}
			} else if(option == '3') {
				with(sheetObj) {
					for(var rowIdx=HeaderRows(); rowIdx<=LastRow(); rowIdx++) {
						if(GetCellValue(rowIdx, "copyChk") == "1") {
							var chkRow=sheetObj1.FindText("spcl_cntr_seq", GetCellValue(rowIdx, "seq"), 0, -1, true);
		    				sheetObj1.SelectCell(chkRow, "spcl_cntr_seq");
		    				for (var copyIdx=0; copyIdx<GetCellValue(rowIdx,"copyCnt"); copyIdx++) {
		    					copyCargo(sheetObj1, sheetObj2, selCgoRow);
		    				}
		    			}
					}
				}
			}
		}
	}
	/**
	 * Pre-Checking result Setter - Y:pass after cheking , N:before checking , P:prohibited after checking
	 */
	function setPreChkRslt(rslt) {
		ComSetObjValue(document.form.pre_chk_flg, rslt);
		var btnObj=document.getElementById('btn2_Pre_Checking_Report');
		if(rslt == 'P') {
			btnObj.style.color="red";
 		} else if(rslt == 'Y') {
 			btnObj.style.color="blue";
 		} else {
 			btnObj.style.color="#737373";
 		}
	}
	//Control progress of Pre-Checking pop-up
	isIE=document.all;
	isNN=!document.all && document.getElementById;
	isN4=document.layers;
	isHot=false;
	function nextPosInit(e){
		topDog=isIE ? "BODY" : "HTML";
		whichDog=isIE ? document.all.popWindow : document.getElementById("popWindow");
		hotDog=isIE ? event.srcElement : e.target;
		while(hotDog.id != null && hotDog.id != "popWindow" && hotDog.tagName != topDog) {
			hotDog=isIE ? hotDog.parentElement : hotDog.parentNode;
		}
		if (hotDog.id == "popWindow") {
			offsetx=isIE ? event.clientX : e.clientX;
			offsety=isIE ? event.clientY : e.clientY;
			nowX=parseInt(whichDog.style.left);
			nowY=parseInt(whichDog.style.top);
			nextPosEnabled=true;
			document.onmousemove=nextPos;
		}
	}
	function nextPos(e) {
		if (!nextPosEnabled) return;
		whichDog.style.left=isIE ? nowX + event.clientX - offsetx : nowX + e.clientX - offsetx;
		whichDog.style.top=isIE ? nowY + event.clientY - offsety : nowY + e.clientY - offsety;
		return false;
	}
	document.onmousedown=nextPosInit;
	document.onmouseup=Function("nextPosEnabled=false");
	/**
	 * Progress Pop-Up of Pre-checking for IMDG Regulation
	 */
	function showProgressPop(sheetObj, formObj) {
		var layerWidth  = 350;
		var layerHeight = 200;
		var pX=(document.body.clientWidth  - layerWidth )/2 + document.body.scrollLeft;
		var pY=(document.body.clientHeight - layerHeight )/2 + document.body.scrollTop + 100;
		//Form values --> Sheet
		setFormToSheetAll(sheetObj, sheetObj.GetSelectRow(), formObj.imdg_clss_cd, formObj.auth_sts_cd);
		ComOpenWait(false);
		formObj.f_cmd.value=SEARCH;
		var layerUrl="VOP_SCG_0069.do?pop_type=B2&"+FormQueryString(formObj);
		var contents="";
		contents=contents + "<div id=\"popWindow\" style=\"left:"+pX+"px; top:"+pY+"px; width:"+layerWidth+"px;height:"+layerHeight+"px;position:absolute;cursor:move ; border:0px solid #9999c1; z-index:1;overflow: no; visibility:visible\">";
		contents=contents + "<table class=\"popup\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
		contents=contents + "	<tr>";
		contents=contents + "		<td height=\"15\">";
		contents=contents + "			<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">";
		contents=contents + "				<tr>";
		contents=contents + "					<td class=\"title\" align=\"absmiddle\" valign=\"bottom\">Under Pre-Checking ...</td>";
		contents=contents + "				</tr>";
		contents=contents + "			</table>";
		contents=contents + "		</td>";
		contents=contents + "	</tr>";
		contents=contents + "	<tr>";
		contents=contents + "		<td>";
		contents=contents + "			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
		contents=contents + "				<tr>";
		contents=contents + "					<td><img name=\"progressBar\" src=\"/opuscntr/img/waiting.gif\" width=\"249\" height=\"76\" border=\"0\" align=\"absmiddle\"></td>";
		contents=contents + "				</tr>";
		contents=contents + "			</table>";
		contents=contents + "		</td>";
		contents=contents + "	</tr>";
		contents=contents + "	<tr>";
		contents=contents + "		<td>";
		contents=contents + "			<iframe id=\"preCheckFrm\" src=\""+layerUrl+"\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"0\" height=\"0\"></iframe>";
		contents=contents + "		</td>";
		contents=contents + "	</tr>";
		contents=contents + "</table>";
		contents=contents + "</div>";
		progressPop.innerHTML=contents;
		window.document.body.style.cursor="wait";
		
		/*
		window.document.body.style.cursor="wait";
		setFormToSheetAll(sheetObj, sheetObj.GetSelectRow(), formObj.imdg_clss_cd, formObj.apro_ref_no);
//		ComOpenWait(false);
		formObj.f_cmd.value=SEARCH;
		var layerUrl="VOP_SCG_0069.do?pop_type=B2&"+FormQueryString(formObj);
		document.getElementById("preCheckFrm").src = layerUrl;//document.formObj[layerUrl].value;
//		ComOpenWait(true);
		window.document.body.style.cursor="default";
		 */
	}

	/**
	 * Close Pop-Up of Pre-checking
	 */
	function closeProgressPop() {
		document.all('popWindow').style.visibility='hidden';
		window.document.body.style.cursor="default";
		ComOpenWait(true);
		doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
	} 
//------------------------------------------------------------------------------//
/* Popup action and return functions -- general retrieve */    
//------------------------------------------------------------------------------//   	 

    /**
     * Sub Label Validation
     */
    function searchSubLabelCheck(obj) {
		var formObj = document.form; 
		var sheetObj=sheetObjects[0];
      	var sParam=Array();
  	  	sParam[0]="imdg_clss_cd="+obj.value;
  	  	sParam[1]="f_cmd="+SEARCH;
  	  	
		formObj.f_cmd.value=SEARCH;
		var sXml=sheetObj.GetSearchData("VOP_SCG_0037GS.do", sParam.join("&"));
		var cnt = ComGetTotalRows(sXml);
		if(cnt == 0){
			ComShowCodeMessage('SCG50010', 'Sub Label');
			ComSetObjValue(obj, ""); 	 		    
 	 		ComSetFocus(obj);
		}
		
    }
    
	/**
     * Carrier Validation
     */
    function searchCarrierCheck(obj) {
      	var formObj=document.form;
      	var sheetObj=sheetObjects[0];
      	var sParam=Array();
  	  	sParam[0]="crr_cd="+obj.value;
  	  	sParam[1]="f_cmd="+SEARCH01;
  	  	if(sParam.join("").length > 16) {
  	  		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
  	    	var crrData=ComScgXml2Array(sXml, "crr_cd");
  		   	if(crrData == null) {
  			    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
  			    ComSetObjValue(obj, ""); 	 		    
 	 		    ComSetFocus(obj);
  		   	} else {
  	  	  		ComSetFocus(formObj.bkg_ref_no);
  	  	  	} 
  	  	}
    }
    
    /**
     * VVD Validation
     */
    function searchVVDCheck() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var sParam=Array();
	  	sParam[0]="vsl_cd="+ComGetObjValue(formObj.vsl_cd);
	  	sParam[1]="skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
	  	sParam[2]="skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
	  	sParam[3]="f_cmd="+SEARCH05;
	  	if(sParam.join("").length > 38) {
	  		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
	    	var crr_cd=ComScgXml2Array(sXml, "vsl_opr_tp_cd"); 
	    	var vsl_slan_cd=ComScgXml2Array(sXml, "vsl_slan_cd");
	    	
	 	   	if(crr_cd == null) {
	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	 		    ComSetObjValue(formObj.skd_dir_cd, "");
	 		    ComSetObjValue(formObj.skd_voy_no, "");
	 		    ComSetObjValue(formObj.vsl_cd, "");
	 		    ComSetObjValue(formObj.crr_cd, "");
	 		    ComSetObjValue(formObj.slan_cd, "");
	 		    ComSetFocus(formObj.vsl_cd);
	 	   	} else {
	 	   		ComSetObjValue(formObj.crr_cd, crr_cd);
	 	   		ComSetObjValue(formObj.slan_cd, vsl_slan_cd);
	 	   		doActionIBCombo(sheetObjects[1], comboObjects[0], 1, '');	//POL retrieve
	 	   		comboObjects[1].RemoveAll();	//initialize POD
	 	   	}
	  	}
    }
    /**
     * retrieve TP/SZ Combo list
     */
    function searchTPSZList(sheetObj) {       	
    	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", "f_cmd="+SEARCH06);
 		var arrCombo=ComXml2ComboString(sXml, "cntr_tpsz_cd", "cntr_tpsz_cd");
		if(arrCombo != null && arrCombo.length > 0) 
			sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
		
		
    }
    
    /**
     * UN No. Validation(Segregation Groups Change)
     */
    function searchUNNoCheck(obj) {
    	var formObj=document.form;
    	var sheetObj1=sheetObjects[0];
    	var sheetObj2=sheetObjects[1];
    	if(document.form.imdg_un_no_seq.value == '') {
	 		// Segregation Groups Clear
			for(var i=1 ; i < 5 ; i++ ) {
				sheetObj2.SetCellValue(sheetObj2.LastRow(),"hcdg_tnk_rstr_desc"+i, "");
				ComSetObjValue(eval("document.form.hcdg_tnk_rstr_desc"+i), "");
			}
	     	if(obj.value == '') {
	     		return;
	     	}
	      	formObj.f_cmd.value=SEARCH01;
	      	var param=FormQueryString(formObj) ;
	      	var sXml=sheetObj1.GetSearchData("SCG_COM_INTERNALGS.do", param);
	     	var sTotal=ComScgGetTotalValue(sXml);
	     	if( sTotal == "0"){
	     		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	     		ComSetObjValue(obj, ""); 
	     		ComSetObjValue(document.form.imdg_un_no_seq, "");
	     		ComSetObjValue(document.form.imdg_clss_cd, "");
	     		ComSetObjValue(document.form.imdg_comp_grp_cd, "");
	     	    // Segregation Groups Clear
				for(var i=1 ; i < 5 ; i++ ) {
					sheetObj2.SetCellValue(sheetObj2.LastRow(),"hcdg_tnk_rstr_desc"+i, "");
					ComSetObjValue(eval("document.form.hcdg_tnk_rstr_desc"+i), "");
				}
	 		    ComSetFocus(obj);
	        } else {
	    			// Segregation Groups setting
	    			document.form.f_cmd=SEARCH01;
	    			var sXml=sheetObj.GetSearchData("VOP_SCG_0015GS.do", FormQueryString(formObj));
	    			var segrGrpDtlList=ComGetEtcData(sXml,"segrGrpDtlList");
	    			var arrSegrGrpDtl=segrGrpDtlList.split('|');
	    	  		//ComXml2ComboItem(arrXml[1], comboObjects[0], "imdg_segr_grp_no", "imdg_segr_grp_nm");
	    	  		for(var i=1 ; i <= arrSegrGrpDtl.length ; i++ ) {
	    				sheetObj2.SetCellValue(sheetObj2.LastRow(),"hcdg_tnk_rstr_desc"+i, arrSegrGrpDtl[i-1]);
	    				ComSetObjValue(eval("document.form.hcdg_tnk_rstr_desc"+i), arrSegrGrpDtl[i-1]);
	    			}
	        	onPopupClick(sheetObj1, formObj, "UnNo", "UnNo");
	 	   	}
    	}
    }
    /**
     * UN No. Information retrieve
     */
    function searchUnNoInfo(sheetObj, imdg_un_no, imdg_un_no_seq) {
    	sheetObj.SetWaitImageVisible(0);
    	var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", "f_cmd="+SEARCH05+"&imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq);
		sheetObj.SetWaitImageVisible(1);
		return sXml;
    }
    /**
     * ETA retrieve
     */
    function searchETADt(pol_cd) {       	
     	var sParam=Array();
     	sParam[0]="vsl_cd="+ComGetObjValue(document.form.vsl_cd);
 	  	sParam[1]="skd_voy_no="+ComGetObjValue(document.form.skd_voy_no);
 	  	sParam[2]="skd_dir_cd="+ComGetObjValue(document.form.skd_dir_cd);
 	  	sParam[3]="loc_cd="+pol_cd.substring(0,5);
 	  	//sParam[3]="loc_cd="+pol_cd;
 	  	sParam[4]="f_cmd="+SEARCH10;
 	  	var sXml=sheetObjects[1].GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
 		 		
 		var etaDt  = ComScgXml2Array(sXml, "vps_eta_dt");
    	var etaVal = "";
    	for (var etaRow = 0; etaRow < etaDt.length; etaRow++) {
    		etaVal = etaDt[etaRow];
    		if (etaVal == undefined) continue;
    		
    		for (var valRow = 0; valRow < etaVal.length; valRow++) {
	    		if (ComIsDateTime(etaVal[valRow], "", "hm")) {
	    			etaVal = etaDt[etaRow];
	    			break;
	    		}
    		}
    	}
 		ComSetObjValue(document.form.eta_dt, etaVal);
    }
//------------------------------------------------------------------------------//
/* general retrieve -- IB retrieve */    
//------------------------------------------------------------------------------//    
    // Combo related process handling
    function doActionIBCombo(sheetObj, comboObj, comboNo, polCd) {
    	var formObj=document.form;
//     	sheetObj.ShowDebugMsg(false);
        switch(comboNo) {
 	  		case 1:
 	  			var sParam=Array();
 	  		  	sParam[0]="vsl_cd="+ComGetObjValue(document.form.vsl_cd);
 	  		  	sParam[1]="skd_voy_no="+ComGetObjValue(document.form.skd_voy_no);
 	  		  	sParam[2]="skd_dir_cd="+ComGetObjValue(document.form.skd_dir_cd);
 	  		  	sParam[3]="f_cmd="+SEARCH10;
 	  		  	var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
 	  			comboObj.RemoveAll();
 	  			var arrCombo=ComXml2ComboString(sXml, "loc_cd", "loc_nm");
 	  	    	if(arrCombo != null && arrCombo.length > 0) {
 	  	    		var loc_cds=ComScgXml2Array(sXml, "loc_cd");
 	  	    		var clptIndSeqs=ComScgXml2Array(sXml, "clpt_ind_seq");
 	  	    		var turnPortIndCds=ComScgXml2Array(sXml, "turn_port_ind_cd");
 	  	    		var skdCngStsCd=ComScgXml2Array(sXml, "skd_cng_sts_cd");
 	  	    		var vtAddCallFlg=ComScgXml2Array(sXml, "vt_add_call_flg"); 
 	  	    		//2016-02-01 Port 조회시, Sub Continent, RSO 값 불러오기 
 	  	    		var scontiCd=ComScgXml2Array(sXml, "sconti_cd");
 	  	    		var rgnShpOprCd = ComScgXml2Array(sXml, "rgn_shp_opr_cd");
 	  	    		var deltFlg = ComScgXml2Array(sXml, "delt_flg");
 	  	    		
 	  	    		//Set Combo Drop Size
 	  	    		setComboProperty(pol_cd, loc_cds.length, "120");
 	  	    		var newPolIdx=0;
 	  	    		for(var arrIdx=0; arrIdx<loc_cds.length; arrIdx++) {
 	  	    			if(loc_cds[arrIdx] != null && loc_cds[arrIdx] != '' && vtAddCallFlg[arrIdx] != 'Y') {
 	  		    			if(turnPortIndCds[arrIdx] != 'D' && turnPortIndCds[arrIdx] != 'V' && turnPortIndCds[arrIdx] != 'F') { 	  		    				
 	  		    				comboObj.InsertItem(newPolIdx
 	  		    						  		    						
 	  		    						, loc_cds[arrIdx]+"|"+ portInfo(arrIdx, skdCngStsCd[arrIdx], loc_cds[arrIdx], 'pol_cd', clptIndSeqs[arrIdx] )
 	  		    						, loc_cds[arrIdx]+""+clptIndSeqs[arrIdx]
  	  		    						);
 	  		    						//2016-02-01 Sub Continent, RSO 값 전역 변수에 Mapping 
 	  		    						polRsoCd[newPolIdx] = rgnShpOprCd[arrIdx]; 
 	  		    						polScontiCd[newPolIdx] =scontiCd[arrIdx];
 	  		    						rsoDelFlg[newPolIdx] = deltFlg[arrIdx];
 	  		    						newPolIdx++;
// 	  		    						, loc_cds[arrIdx]);
 	  		    			}
 	  	    			}
 	  	    		}
 	  	    		ComSetFocus(pol_cd);
 	  	    	} else {
 	  	    		comboObjects[1].RemoveAll();
 	  	    	}
 	  			break; 
 	  		case 2:  
 	  			var sParam=Array();
 	  		  	sParam[0]="vsl_cd="+ComGetObjValue(document.form.vsl_cd);
 	  		  	sParam[1]="skd_voy_no="+ComGetObjValue(document.form.skd_voy_no);
 	  		  	sParam[2]="skd_dir_cd="+ComGetObjValue(document.form.skd_dir_cd);
 	  		  	sParam[3]="f_cmd="+SEARCH10;
 	  			var sXml="";
 	  			if(polCd != '') {
 	  				sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
 	  			}
 	  			comboObj.RemoveAll();
 	  			var arrCombo=ComXml2ComboString(sXml, "loc_cd", "loc_nm");
 	  	    	if(arrCombo != null && arrCombo.length > 0 && polCd != '') {
 	  	    		var loc_cds=ComScgXml2Array(sXml, "loc_cd");
 	  	    		var clptIndSeqs=ComScgXml2Array(sXml, "clpt_ind_seq");
 	  	    		var clptSeqs=ComScgXml2Array(sXml, "clpt_seq");
 	  	    		var skdCngStsCd=ComScgXml2Array(sXml, "skd_cng_sts_cd");
 	  	    		//Set Combo Drop Size
 	  	    		setComboProperty(pod_cd, loc_cds.length, "120");
 	  	    		var polClptSeq="0";
 	  	     		var newPodIdx=0;
 	  	     		for(var arrIdx1=0; arrIdx1<loc_cds.length; arrIdx1++) {
 	  	     			if(loc_cds[arrIdx1]+""+clptIndSeqs[arrIdx1] == polCd) polClptSeq=clptSeqs[arrIdx1];
// 	  	     		if(loc_cds[arrIdx1] == polCd) polClptSeq=clptSeqs[arrIdx1];
 	  	     		}
 	  	    		var newPodIdx=0;
 	  	    		for(var arrIdx2=0; arrIdx2<loc_cds.length; arrIdx2++) {
 	  	    			if(loc_cds[arrIdx2] != null && loc_cds[arrIdx2] != '') {
 	  	    				if(parseInt(clptSeqs[arrIdx2]) > parseInt(polClptSeq)) {
 	  	    					comboObj.InsertItem(newPodIdx++
 	  	    							, loc_cds[arrIdx2]+"|"+portInfo(arrIdx2, skdCngStsCd[arrIdx2], loc_cds[arrIdx2], 'pod_cd', clptIndSeqs[arrIdx2])
 	  	    					        , loc_cds[arrIdx2]+""+clptIndSeqs[arrIdx2]);
// 	  	    							, loc_cds[arrIdx2]);
 	  		    			}
 	  	    			}
 	  	    		}
 	  	    		ComSetFocus(pod_cd);
 	  	    	}
 	  			break; 
        }
        return true;
    }
    
    // skip port인 경우 | SKIP, 운하(EGSCA, PAPCA)인 경우 | CANAL
    function portInfo(index, status, value, kind, seq) {
    	var desc = "";
    	// clear
		if(index == 0) {
			if(kind == 'pol_cd') {
				noPolCd = "";
			}
			if(kind == 'pod_cd') {
				noPodCd = "";
			}
		}
    	if(status == 'S') {
			desc = "SKIP";
		}
		if(value == 'EGSCA' || value == 'PAPCA') {
			desc = "CANAL";
		}
		if(desc != '') {
			if(kind == 'pol_cd') {
				noPolCd = noPolCd + value + seq + "." + desc + "," ;

			}
			if(kind == 'pod_cd') {
				noPodCd = noPodCd + value + seq + "." + desc + "," ;
			}
		}
		return desc;
    }
    
	// Sheet related process handling
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	
        sheetObj.ShowDebugMsg(false);
        
        switch(sAction) {
			case IBSEARCH: 
				
			case SEARCH01:      //retrieve
				
				if(sAction == SEARCH01) {
					loadPage(true);
					return;
				}
				
				// VOP_SCG_0022, parnet로 부터 IF의 정합성이 맞지 않을 경우, 처리 중단
				if((preConds.pId == "VOP_SCG_0022") && (!validateForm(sheetObj,formObj,-1,IBSEARCH))) {
					return;
				} else {
					//Initialize register Sequence except modifying existing BKG.
					if(sAction == IBSEARCH && ComGetObjValue(formObj.ibflag) == 'I') {
						ComSetObjValue(formObj.spcl_cgo_rqst_seq, "");
					}
					//Initialize Pre-Checking Report result
					setPreChkRslt("N");
				}
				
				//alert(FormQueryString(formObj));
				
				formObj.f_cmd.value		= SEARCH;
				var sXml				= sheetObj.GetSearchData("VOP_SCG_1022GS.do", FormQueryString(formObj));
	 			var arrXml				= sXml.split("|$$|");
	 			
	 			//alert('arrXml[0]  ['+arrXml[0]+']');
	 			
	 			ComOpenWait	(false, true);	//cannot use because of Button collision
	 			var spcl_cgo_rqst_seq	= ComGetEtcData(arrXml[0],"spcl_cgo_rqst_seq");
	 			var prnr_cgo_rqst_seq	= ComGetEtcData(arrXml[0],"prnr_cgo_rqst_seq");
	 			var edi_unmap_dtl_cd	= ComGetEtcData(arrXml[0],"edi_unmap_dtl_cd");
	 			var unmap_pol_cd	    = ComGetEtcData(arrXml[0],"unmap_pol_cd");
	 			var unmap_pod_cd	    = ComGetEtcData(arrXml[0],"unmap_pod_cd");
	 			// 신규가 아닌 경우
	 			if(spcl_cgo_rqst_seq != '' && spcl_cgo_rqst_seq != 'null') {
	 				ComSetObjValue(formObj.spcl_cgo_rqst_seq, spcl_cgo_rqst_seq					);
	 				ComSetObjValue(formObj.prnr_cgo_rqst_seq, prnr_cgo_rqst_seq					);
	 				ComSetObjValue(formObj.edi_unmap_dtl_cd , edi_unmap_dtl_cd					);
	 				if(preConds.src_tp_cd == 'EDI') {
	 					ComSetObjValue(formObj.unmap_pol_cd     , unmap_pol_cd		    			);
	 					ComSetObjValue(formObj.unmap_pod_cd     , unmap_pod_cd	    				);
	 				}
	 				ComSetObjValue(formObj.ibflag			, "U"								);
	 				ComSetObjValue(formObj.org_cgo_opr_cd	, ComGetObjValue(formObj.cgo_opr_cd));
	 				ComSetObjValue(formObj.org_bkg_ref_no	, ComGetObjValue(formObj.bkg_ref_no));
	 				ComSetObjValue(formObj.org_vsl_cd		, ComGetObjValue(formObj.vsl_cd)	);
	 				ComSetObjValue(formObj.org_skd_voy_no	, ComGetObjValue(formObj.skd_voy_no));
	 				ComSetObjValue(formObj.org_skd_dir_cd	, ComGetObjValue(formObj.skd_dir_cd));
	 				ComSetObjValue(formObj.org_crr_cd		, ComGetObjValue(formObj.crr_cd)	);
	 				ComSetObjValue(formObj.org_slan_cd		, ComGetObjValue(formObj.slan_cd)	);
	 				
	 				setEnableUI(document.form, document.form.cgo_opr_cd, document.form.skd_dir_cd, 'readonly');
	 				document.getElementById("btn_Carrier").style.visibility		= "hidden";
	 				document.getElementById("btn_VVDpop").style.visibility		= "hidden";
	 			} else {
	 				ComSetObjValue(formObj.spcl_cgo_rqst_seq, "");
	 				
	 				ComSetObjValue(formObj.ibflag, "I");
	 			} 	
	 			
	 			//Pre-Checking result
	 			ComSetObjValue(formObj.pre_chk_flg, "N");
	 			
	 			//Load Data
	 			for(var i=0; i < arrXml.length; i++){
	 				sheetObjects[i+1].SetWaitImageVisible(0);
	 				
	 				if(preConds.pId == "VOP_SCG_0022") {
	 					sheetObjects[i+1].LoadSearchData(arrXml[i],{Sync:1});
	 				} else {
	 					sheetObjects[i+1].LoadSearchData(arrXml[i],{Sync:1});
	 				}
	 				sheetObjects[i+1].SetWaitImageVisible(1);
				}
	 			
	 			if(arrXml.length < 2) {
	 				uploadObj.Files="";
	 				sheetObjects[2].removeAll();
	 			} else {	 				
	 				var file_cnt = sheetObjects[2].LastRow();
	 				formObj.attach_file_cnt.value = (file_cnt > 0) ? file_cnt : 0;
	 			}
	 			
	 			//see [sheet2_OnSearchEnd]
	 			ComOpenWait(false);
	 			//to prevent window scroll because of Waitting image
	 			document.body.scroll="no";
	 			
	 			setFileLink("2");
	 			//btnEnabled("view", true);	//@@
	 			
	 			// Update Itmes
	 			if(preConds.pId == "VOP_SCG_5001"){
	 				
		 			formObj.f_cmd.value	= SEARCH03;
					var sUpdItemXml		= sheetObjects[3].GetSearchData("VOP_SCG_1022GS.do", FormQueryString(formObj));
					sheetObjects[3].LoadSearchData(sUpdItemXml);
	 			}
	 			
				//:2015-12-28://sheetObjects[3].LoadSearchData(sXml,{Sync:1});
            	break;
            	
            	
			case IBBATCH:	//Checking for validation
				
				if(!validateForm(sheetObj,formObj,-1,IBSEARCH)			) return;									//Booking info check
				if(!validateForm(sheetObj,formObj,-1,IBSEARCH_ASYNC02)	) return;									//Container,Cargo existing check
			    if(!validateForm(sheetObjects[0],formObj,sheetObjects[0].GetSelectRow(),IBSEARCH_ASYNC03)) return;	//Container info check
				if(!validateForm(sheetObj,formObj,-1,IBSEARCH_ASYNC01)	) return;									//Cargo info check	
				if(!validateForm(sheetObj,formObj,-1,IBSAVE)			) return;									//Cargo info check	
				
				for(var nextIdx=sheetObj.HeaderRows(); nextIdx<=sheetObj.LastRow(); nextIdx++){
		 			var rowStatus	= sheetObj.GetRowStatus(nextIdx);
		 			var outN1stQty	;
					var outN1stCd 	;
					var imdgUnNoSeq ;
					var cntrSeq		;
					var cargoSeq	;
					
		 			if(rowStatus != 'D') {
		 				outN1stQty	= sheetObj.GetCellValue(nextIdx, "out_n1st_imdg_pck_qty");
		 				outN1stCd 	= sheetObj.GetCellValue(nextIdx, "out_n1st_imdg_pck_cd");
		 				cntrSeq  	= sheetObj.GetCellValue(nextIdx, "spcl_cntr_seq");
		 				cargoSeq 	= sheetObj.GetCellValue(nextIdx, "spcl_cgo_seq");
		 				
						if (outN1stQty == undefined || outN1stQty.length == 0 || outN1stCd == undefined || outN1stCd.length == 0) {
							var msg 	= "CNTR:"+cntrSeq+", CARGO:"+cargoSeq+" [Package Q'ty & Type]"; 
							ComShowMessage("'" + msg + "' " + Msg_Required);
							return;
						}
						if(sheetObj.GetSelectRow() == nextIdx) {
							imdgUnNoSeq	= ComGetObjValue(formObj.imdg_un_no_seq);
						} else {
							imdgUnNoSeq	= sheetObj.GetCellValue(nextIdx, "imdg_un_no_seq");
						}
						if(imdgUnNoSeq == undefined || imdgUnNoSeq.length == 0) {
							var msg 	= "CNTR:"+cntrSeq+", CARGO:"+cargoSeq+" [Un No./Seq.]"; 
							ComShowMessage("'" + msg + "' " + Msg_Required);
							return;
						}
		 			}
		 		}
				
				formObj.f_cmd.value	= SEARCH;
				var returnVal		= ComGetObjValue(document.form.pre_chk_flg);	/** Pre-Checkin for IMDG Regulation **/
				returnVal 			= "Y";  										/** No need to pre-checking for partner dangerous cargo booking **/
				
				if(returnVal == "N") {
					//returnVal = onPreChkPopup(sheetObj, formObj, "B", "255", "105");
					showProgressPop(sheetObj, formObj);
				} else {
					doActionIBSheet(sheetObj, formObj, IBSAVE);
				}
				
				break;
				
				
			case IBSAVE: //save
				
				var preChkConfirmYn	= true;
				var rowPosition		= sheetObj.GetSelectRow();
				formObj.f_cmd.value	= MULTI;
				//Form values --> Sheet
				var authStsCd 		= sheetObj.GetCellValue(sheetObj.GetSelectRow(),"auth_sts_cd");
				// Auto Request체크
				var isAuto 			= false;
				
//				if(authStsCd == 'Y' || authStsCd == 'R' || preConds.src_tp_cd == 'EDI') {
				if(authStsCd == 'Y' || authStsCd == 'R') {
//					if(checkAutoRequestItem() || preConds.src_tp_cd == 'EDI') {
					if(checkAutoRequestItem()) {
						if(ComShowCodeConfirm('SCG50001', '& Request')) {
							formObj.requestChk.value = "R";
							isAuto = true;
						} else {
							return false;
						}
					}
				}
     		   	
     		    var msgCode = "";
     		    var msg		= "";
     		    
     		    if(formObj.requestChk.value == "R") {
     		    	if(authStsCd == 'R') {
     		    		//'Do you want to Request Again?'
     		    		msgCode = "SCG50050";
     		    		msg = ComGetObjValue(document.form.bkg_ref_no);
     		    	} else {
	     		    	//'Do you want to Request?'
	     		    	msgCode = "SCG50049";
	     		    	msg = "";
     		    	}
     		    } else {
     		    	//'Do you want to save Data?'
     		    	msgCode = "SCG50001";
     		    	msg= "data";
     		    }
     		    // isAuto가 true인 경우는 이미 확인 메세지 표시
     		    if(!isAuto && preChkConfirmYn && (formObj.requestChk.value != "C") && (!ComShowCodeConfirm(msgCode, msg))) { 
        			ComOpenWait(false);
        			return false;
        		}
     		    
				if(authStsCd == '') { //Request history가 없는 경우
					formObj.auth_sts_cd.value = formObj.requestChk.value;
				} else { //Request history가 있는 경우
					if(formObj.requestChk.value == "R") { // request
						formObj.auth_sts_cd.value = "R";
					} else if(formObj.requestChk.value == "C") { // request cancel
						formObj.auth_sts_cd.value = "C";
					} else {
						formObj.auth_sts_cd.value = authStsCd; // Save의 경우, 이전 request status를 유지한다.
					}
				}
				
				setFormToSheetAll(sheetObj, sheetObj.GetSelectRow(), formObj.dcgo_ref_no, formObj.auth_sts_cd);
				
				if(ComGetObjValue(formObj.ibflag) == 'U') {
					//Rollback BKG Info's edit invalid items.
					ComSetObjValue(formObj.bkg_ref_no, ComGetObjValue(formObj.org_bkg_ref_no));
	 				ComSetObjValue(formObj.vsl_cd,     ComGetObjValue(formObj.org_vsl_cd));
	 				ComSetObjValue(formObj.skd_voy_no, ComGetObjValue(formObj.org_skd_voy_no));
	 				ComSetObjValue(formObj.skd_dir_cd, ComGetObjValue(formObj.org_skd_dir_cd));
	 				ComSetObjValue(formObj.crr_cd,     ComGetObjValue(formObj.org_crr_cd));
	 				ComSetObjValue(formObj.slan_cd,    ComGetObjValue(formObj.org_slan_cd));
				}
				
				//When creating Cargo info save query, because of automatic focus move, to maintain original focus, add  condition clause
				if(rowPosition == -1) cgoSelBlk=true;
				//When changing BKG Company, all Cargo info must be changed.
				var org_cgo_opr_cd=ComGetObjValue(formObj.org_cgo_opr_cd);
				var cgo_opr_cd=ComGetObjValue(formObj.cgo_opr_cd);
				if(org_cgo_opr_cd != '' && org_cgo_opr_cd != cgo_opr_cd) {
					for(var upIdx=sheetObj.HeaderRows(); upIdx<=sheetObj.LastRow(); upIdx++) {
						sheetObj.SetRowStatus(upIdx,"U");
					}
				}
				
				// rowStatus를 변경한다.
        		ctrlRowStatus(sheetObj);
				var sParam		= ComGetSaveString(sheetObj, true, false, -1);
				if(cgoSelBlk) {
					sheetObj.SelectCell(1, "spcl_cgo_seq");
					cgoSelBlk	= false;
				}
     		   	//add conversion to use file popup screen commonly
     		    var fileParam	= ComGetSaveString(sheetObjects[2], true, false, -1);
     		   	//Connect Booking Key to Cago info
     		   	var bkgKeyParam	= "&crr_cd="+ComGetObjValue(formObj.crr_cd);
     		   	bkgKeyParam 	+= "&bkg_ref_no="+ComGetObjValue(formObj.bkg_ref_no);
     		    bkgKeyParam 	+= "&prnr_cgo_rqst_seq="+ComGetObjValue(formObj.prnr_cgo_rqst_seq);
     		   	bkgKeyParam 	+= "&spcl_cgo_rqst_seq="+ComGetObjValue(formObj.spcl_cgo_rqst_seq);
     		    bkgKeyParam 	+= "&cgo_opr_cd="+ComGetObjValue(formObj.cgo_opr_cd);
     		    bkgKeyParam 	+= "&vsl_cd="+ComGetObjValue(formObj.vsl_cd);
     		    bkgKeyParam 	+= "&skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
     		    bkgKeyParam 	+= "&skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
     		    bkgKeyParam 	+= "&slan_cd=";
     		    bkgKeyParam 	+= "&pol_cd="+ComGetObjValue(pol_cd);
     		    bkgKeyParam 	+= "&pod_cd="+ComGetObjValue(pod_cd);
//     		    bkgKeyParam += "&dcgo_ref_no="+ComGetObjValue(formObj.dcgo_ref_no);
     		    sParam			= ComReplaceStr(sParam, "&spcl_cntr_seq", bkgKeyParam+"&spcl_cntr_seq");
     		    
     		    //alert('bkgKeyParam ['+bkgKeyParam+']');
     		    
     		    var formParam	= FormQueryString(formObj);
     		    
     		    //alert('formParam ['+formParam+']');
     		    
     		    sParam			= ComScgSetPrifix(sParam, "cago_");  
     		    sParam 			+= "&"+ComScgSetPrifix(fileParam, "file_");  
     		    
     		   	var paramPrefix	= new Array("", "cago_", "file_");
     		   	sParam 			+= "&" + formParam + "&" + ComGetPrefixParam(paramPrefix);
     		    sParam 			+= "&mode=" +  ComGetObjValue(formObj.requestChk);
     		    sParam 			+= "&src_tp_cd="+preConds.src_tp_cd;
     		   	ComOpenWait(true, true);

     		   	//1.Retrieve IBUpload
         	    //alert('upload1.GetList().length ['+upload1.GetList().length+']');
     		   	
     		   	//2016-01-06 START if, else 절 주석 해제 
     		   	if (upload1.GetList().length == 0) {
	    		//1. in case of not existing file to upload => change only DB Info
     		   	sXml	= sheetObj.GetSaveData("VOP_SCG_1022GS.do", sParam);
    			    
 			   	var rslt		= ComGetEtcData(sXml, "rslt");
				var resultMap	= ComGetEtcData(sXml, "resultMap");
				
				if(resultMap != null && resultMap != ""){
					var arrMap		= resultMap.split(",");
			    	ComSetObjValue(formObj.spcl_cgo_rqst_seq, arrMap[0]); //채번된 spclCgoRqstSeq
 			    	ComSetObjValue(formObj.prnr_cgo_rqst_seq, arrMap[1]); //채번된 prnrCgoRqstSeq						
				}
 			    //2016-01-06 END
				
       		    if(rslt == '0') {
       		    	ComShowMessage(ComScgGetMessageFromXml(sXml));
       		    } else {
//	       		    	if (sXml.length > 0) sheetObj.LoadSaveData(sXml);
       		    	if(formObj.requestChk.value == "R") {
       		    		ComShowCodeMessage("SCG50052");
       		    	} else if(formObj.requestChk.value == "C") {
       		    		ComShowCodeMessage("SCG50053");
       		    	} else {
//	       		    	if (sXml.length > 0) sheetObj.LoadSaveData(sXml);
       		    		ComShowCodeMessage("SCG50043");
       		    	}
       		    }
       		    if(preConds.src_tp_cd == "EDI"){
       		    	loadPage(false);
       		    }else{
       		    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
       		    }

       		    ComOpenWait(false);
       		   	//to prevent window scroll because of Waitting image
  	 			document.body.scroll	= "no";
  	 			win_close("", false);	
	  	 		//:2015-12-29:by TOP://
  	 			} else {
                   //1. in case of existing file to upload => change DB Info and upload file.
  	 				var aryPrefixs 	= new Array("sheet3_serial_no");
  	 				var fParam 		= ComGetFileSaveString(sheetObjects[2], upload1, aryPrefixs,true);
  	 				sParam 			+= "&" + fParam;
  	 				paramToForm		(sParam);
  	 				upload1.SaveStatus();
  	 				
  	 			}
		    	closeYn = true;
     		    
		    	// parent list reload
		    	//2016-02-15 START 0022 조회 EDI일때도 close 불필요
//     		    if(preConds.src_tp_cd == 'EDI') {
//     		    	win_close("", true);
//     		    } 
     		   //2016-01-11 END 0022 조회
//     		    else {
//     		    win_close("", false);
//
//     		    }
     		    
				break;
				
				
			case IBSEARCH_ASYNC02:      // MPA1 Validation
				var sParam	= Array();
		     	sParam[0]	= "vsl_cd="		+ComGetObjValue(formObj.vsl_cd);
		 	  	sParam[1]	= "skd_voy_no="	+ComGetObjValue(formObj.skd_voy_no);
		 	  	sParam[2]	= "skd_dir_cd="	+ComGetObjValue(formObj.skd_dir_cd);
		 	  	sParam[3]	= "pod_cd="		+ComGetObjValue(pod_cd);
		 	  	sParam[4]	= "f_cmd="		+SEARCH01;
		 	  	var sXml	= sheetObj.GetSearchData("VOP_SCG_1022GS.do", sParam.join("&"));
		 		//MAP1 Validation
		 		chkMpa1		(sheetObj, formObj, sXml);
				break;
        }
    }
    
    /**
     * control rowStatus
     * 1.복수의 sheet중 하나라도 update -> update
     * 2.복수의 sheet중 하나라도 insert -> insert
     * 3.delete는 제외한다.
     */
    function ctrlRowStatus(sheetObj) {
    	var isInsert = false;
    	// Save, Request시 기본적으로 모든 sheet는 update
    	for(var upIdx=sheetObj.HeaderRows(); upIdx<=sheetObj.LastRow(); upIdx++) {
			if(sheetObj.GetRowStatus(upIdx) == "R") {
				sheetObj.SetRowStatus(upIdx,"U");
				sheetObj.SetCellValue(upIdx, "Ibflag", "U", 0);
			}
//			if(sheetObj.GetRowStatus(upIdx) == "I") {
//				isInsert = true;
//			}
		}
    	// insert sheet가 있을 경우, delete가 아닌 sheet는 전부 삭제한다.
//    	if(isInsert) {
//	    	for(var upIdx=sheetObj.HeaderRows(); upIdx<=sheetObj.LastRow(); upIdx++) {
//				if(sheetObj.GetRowStatus(upIdx) != "D") {
//					sheetObj.SetRowStatus(upIdx,"I");
//					sheetObj.SetCellValue(upIdx, "Ibflag", "I", 0);
//				}
//			}
//    	}

    }
    
    /**
     * 해당 item이 변경되었는지 체크한다.
     */
    function checkAutoRequestItem() {
    	
    	////alert('arrAutoReqItem.length ['+arrAutoReqItem.length+']');
    	
    	// 해당 item이 변경되었으면 autoRequest
    	for(var i=0;i<arrAutoReqItem.length;i++) {
    		
    		////alert('i >>> ['+i+'] <<< ----- item name ['+arrAutoReqItem[i].name+'] left item ==>> ['+ComGetObjValue(eval("form."+arrAutoReqItem[i].name))+'] VS ['+arrAutoReqItem[i].value+"] <<== right item");
    		
    		// 해당 item의 object value(입력값)와 arrAutoReqItem의 value(기존값)가 다르면 변경
    		if(		ComGetObjValue(eval("form."+arrAutoReqItem[i].name)) 	!= arrAutoReqItem[i].value 
    			&&	arrAutoReqItem[i].value 								!= undefined
    			&&	ComGetObjValue(eval("form."+arrAutoReqItem[i].name)) 	!= undefined )
    		{
    			////alert("To be Requested... Automatically");
    			//--2015-12-24--by TOP--return true;
    			return true;
    		}
    	}
    	return false;
    }

//------------------------------------------------------------------------------//
/* IB retrieve - verification process */    
//------------------------------------------------------------------------------// 	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, row, sAction) {
    	if(!isView) { // Insert, Update의 경우만 체크
          with(formObj){
        	switch(sAction) {	
        		case IBSEARCH:	// Booking compulsory item check
        			if(!ComChkObjValid(formObj.cgo_opr_cd)) return false;
        			if(!ComChkObjValid(formObj.bkg_ref_no)) return false;
        			if(!ComChkObjValid(formObj.vsl_cd)) 	return false;
            		if(!ComChkObjValid(formObj.skd_voy_no)) return false;
            		if(!ComChkObjValid(formObj.skd_dir_cd)) return false;
            		//Check requirement of POL
    		    	if(ComGetObjValue(pol_cd) == '') {
    		    		if(preConds.src_tp_cd == 'EDI') {
    		    		}else{
        		    		ComAlertFocus(pol_cd, "'POL' " +Msg_Required);    		    		
        		    		return;
    		    			
    		    		}
    		    	}
    		    	//Check requirement of POD
    		    	if(ComGetObjValue(pod_cd) == '') {
    		    		if(preConds.src_tp_cd == 'EDI') {
    		    		}else{
        		    		ComAlertFocus(pod_cd, "'POD' " +Msg_Required);
        		    		//2016-02-15 EDI Unmapped - POL 누락 시, 정상 조회 처리
        		    		//return;
    		    		}
    		    	}
        			break;
        			
        		case IBSEARCH_ASYNC01:	//Cargo compulsory item check
        			try {
        	         	 var elems=document.form.elements;
        	         	 var startYn=false;
        	         	 for(var i=0; i < elems.length; i++) {
        	         		 var elem=elems[i];
        	         		 var objNm=elem.name; 
        	                 if('spcl_cgo_seq' == objNm) {
        	                	 if(comboObjects[2].GetSelectIndex()== -1) return true;
        	                	 startYn=true;        	                 
        	                 }
        	                 if(startYn) {     
        	                	 
        		                 if (elem.tagName == 'INPUT' && objNm != null && objNm != '') {	                	 
        		                	 if(elem.getAttribute("required") != null) {
        		                		 if (ComTrim(ComGetObjValue(elem)) == "") {
        		                			 if(objNm == 'hzd_desc') {
        		                				 ComShowCodeMessage('SCG50012');	//'For the purpose of documentation and package marking the Proper Shipping Name shall be supplemented with the technical name for this UN No.'
        		                			 } else {
        		                				 ComShowMessage("'" + elem.getAttribute("caption") + "' " + Msg_Required);
        		                			 }
        		                			 if(objNm == 'out_n1st_imdg_pck_qty') {
        		                				 document.all.btn2_Package_Qty_Type.fireEvent('onclick');
        		                			 } else if(objNm == 'imdg_un_no_seq') {
//    		                					 document.all.btn_Un_No.fireEvent('onclick');
        		                				 onPopupClick(sheetObjects[0], document.form, 'btn_Un_No', 'btn_Un_No');
        		                			 } else {
        		                				 elem.focus();
        		                			 }
        		                			 return false;
        		                		 }
        		                		 if(objNm == 'prp_shp_nm') {
        		                			 var orAndPos=ComGetObjValue(elem).indexOf(" or ");
        		                			 if(orAndPos == -1) orAndPos=ComGetObjValue(elem).indexOf(" and ");
        		                			 if(orAndPos != -1) {
        		                				 var nextStr=ComGetObjValue(elem).substring(orAndPos,ComGetObjValue(elem).length);
        		                				 var nextStrs=nextStr.split(" ");
    		                					 nextStr="";
    		                					 for(var chkIdx=2; chkIdx<nextStrs.length; chkIdx++) {
    		                						 if(ComTrim(nextStrs[chkIdx]) != '') {
    		                							 nextStr=nextStrs[chkIdx];
    		                							 break;
    		                						 }
    		                					 }
        		                				 if(nextStr != '' && nextStr == nextStr) {
	        		                				 ComShowCodeMessage('SCG50020');	//'When conjunction such as "and" or "or" are in the Proper Shipping Name or when segments of the name are punctuated by commas, you have to select the most appropriate one.'
	        		                				 elem.focus();
	        		                				 return false;
        		                				 }
        		                			 }
        		                		 }
        		                		 if(objNm == 'grs_wgt' || objNm == 'net_wgt') {
        		                			 if(!chkGrossNetWeight(elem)) return false;
        		                		 }
        		                		 
        		                	 }
        		                 } else if (elem.tagName == 'OBJECT') {
        		                	 var sObjId=elem.classid;
        		                 	 switch(sObjId){
        		 	                 	case CLSID_IBMCOMBO: //only IBMultiCombo
        		 	                 		if(elem.className == 'mult_combo1') {
        		 	                 			if (elem.GetSelectCode()== "") {
        		 	                 				ComShowMessage(elem.id + Msg_Required);
        		 	                 				elem.focus();
        		 	                 				return false;
        		 	                 			}
        		 	                 		}
        		 	                 		break;
        		 	                 }
        		                  }
        	                 }
        	                 if('net_explo_wgt' == objNm) break;
        	         	 }
        	         } catch(err) { ComFuncErrMsg(err.message); }
        			break;
        			
        		case IBSEARCH_ASYNC02:	//Container,Cargo register check 			
    				var cntrCt=sheetObjects[0].RowCount();
    				var cgoCt  = sheetObj.RowCount("R") + sheetObj.RowCount("I") + sheetObj.RowCount("U");
    				if(cntrCt > 0) {
    					if(cgoCt > 0) {
    						return true;
    						
    					} else {
    						ComShowCodeMessage('SCG50007','Cargo Seq');	//'Please input {?msg1}.'
    						return false;
    					}
    				} else {
    					ComShowCodeMessage('SCG50007','CNTR Seq');	//'Please input {?msg1}'
    					return false;
    				}
        			break;
        			
        		case IBSEARCH_ASYNC03:	//Container compulsory item check	
					var cntr_tpsz_cd=sheetObj.GetCellText(row, "cntr_tpsz_cd");
					if(ComTrim(cntr_tpsz_cd) == '') {
						ComShowMessage("'TP/SZ' " + Msg_Required);
						//sheetObj.SelectCell(row, "cntr_tpsz_cd");
						return false;
					}
					var cntr_ref_no=sheetObj.GetCellText(row, "cntr_ref_no");
					if(cntr_ref_no != '') { //필수는 아님
						for(var nextIdx=sheetObj.HeaderRows(); nextIdx<=sheetObj.LastRow(); nextIdx++) {
				 			var rowStatus = sheetObj.GetRowStatus(nextIdx);
				 			if(rowStatus != 'D' && nextIdx != row) {
				 				if(cntr_ref_no == sheetObj.GetCellText(nextIdx, "cntr_ref_no")) {
				 					ComShowCodeMessage("COM12115", "CNTR No.");
				 					return false;
				 				}
				 			}
				 		}
					}
					// cargo info >> cntr no. copy
					var spcl_cntr_seq=sheetObj.GetCellText(row, "spcl_cntr_seq");
					var sheetObj1=sheetObjects[1];
					for(var nextIdx=sheetObj1.HeaderRows(); nextIdx<=sheetObj1.LastRow(); nextIdx++) {
			 			var rowStatus = sheetObj1.GetRowStatus(nextIdx);
			 			if(rowStatus != 'D') {
			 				if(spcl_cntr_seq == sheetObj1.GetCellText(nextIdx, "spcl_cntr_seq")) {
			 					sheetObj1.SetCellValue(nextIdx, "cntr_ref_no", cntr_ref_no);
			 					break;
			 				}
			 			}
			 		}
	    			break;
	    			
        		case IBSAVE: 
        			// DG Ref No.Duplication Check
        			//insert, update(dcgo_ref_no가 변경되었을 경우)
        			if(ComGetObjValue(formObj.ibflag) == 'I' || ComGetObjValue(formObj.ibflag) == 'U') {
        				document.form.f_cmd.value=SEARCH02;
        				var sXml=sheetObj.GetSearchData("VOP_SCG_1022GS.do", FormQueryString(formObj) + "&spcl_cgo_cate_cd=DG");
        				if(ComGetObjValue(formObj.ibflag) == 'I' 
//        					|| (ComGetObjValue(formObj.bkg_ref_no) != '' 
//        						&& ComGetObjValue(formObj.bkg_ref_no) != ComGetObjValue(formObj.org_bkg_ref_no)
//        						)
        				) {
	        				if(ComGetEtcData(sXml, "Bkg") != "0") {
	        					ComShowCodeMessage("COM12115", "BKG Ref No");
//	        				기존 데이타 삭제후 다시 만들 때
	        					return false;
	        				}
        				}
        				if(ComGetObjValue(formObj.ibflag) == 'I' 
        					|| updateRefNo("dcgo_ref_no")) {
        					
	        				if(ComGetEtcData(sXml, "Dcgo") != "0") {
	        					ComShowCodeMessage("COM12115", "DG Ref No");
	        					return false;
	        				}
        				}
        			}
        			
        			if(preConds.src_tp_cd == 'EDI' && formObj.requestChk.value == "R") {
        				var sheetObj1	= sheetObjects[0];
        				var errMsg = "";
        				for(var i=sheetObj1.HeaderRows(); i<=sheetObj1.LastRow(); i++) {
							if(sheetObj1.GetCellValue(i, "unmap_cntr_tpsz_cd") == sheetObj1.GetCellValue(i, "cntr_tpsz_cd")){
								errMsg = "TP/SZ (" + sheetObj1.GetCellValue(i, "cntr_tpsz_cd") + ")"
								ComShowCodeMessage('SCG50010', errMsg );
								return false;
							}
        				}
        			}
        			
    				if(comboObjects[0].GetSelectText()== '') {
       		    		ComAlertFocus(pol_cd, "'POL' " +Msg_Required);    		    		
       		    		return false;
    		    	}

    				if(comboObjects[1].GetSelectText() == '') {
       		    		ComAlertFocus(pod_cd, "'POD' " +Msg_Required);    		    		
       		    		return false;
    		    	}
        			
        			break;
        	}
          }
    	}
		return true;
	}
    /**
     * Gross/Net Weight value check
     */
    function chkGrossNetWeight(obj) { 
    	var sheetObj=sheetObjects[1];
    	if(parseFloat(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "grs_wgt")) < parseFloat(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "net_wgt"))) {
			ComAlertFocus(obj, "Net weight should be less than gross weight.");
			//obj.select();
			ComSetFocus(eval("document.form."+obj));
			return false;
		}
    	return true;
    }
    /**
     * Flash Point value check
     */
    function chkFlshPoint(obj) {
    	var formObj=document.form;
    	with(obj) {
    		if(value != '') {
    			if(ComGetObjValue(formObj.imdg_un_no) == '') {
    				ComShowCodeMessage('SCG50007', 'UN No.');	//'Please input {?msg1}.'
    				ComSetObjValue(obj, "");
    				ComSetFocus(formObj.imdg_un_no);
    			} 
    /**
     * 2015-03-26, Tae Woong Kim
     * NYK Enhancement (Redmine# : 39123)	
     * Delete Flash Point Value Check logic  (Becuase of Client's requset)
     */   	
    			//2016-07-20
    			else {
    				//show message in case main risk is Class 3
    				if(ComGetObjValue(formObj.imdg_clss_cd) == '3' && ComGetObjValue(formObj.n1st_imdg_subs_rsk_lbl_cd) == '' && ComGetObjValue(formObj.n2nd_imdg_subs_rsk_lbl_cd) == '' && ComGetObjValue(formObj.n3rd_imdg_subs_rsk_lbl_cd) == '' && ComGetObjValue(formObj.n4th_imdg_subs_rsk_lbl_cd) == '') {
	    				if(ComGetObjValue(formObj.imdg_pck_grp_cd) == 'III') {
	    					if(parseInt(ComGetObjValue(obj)) < 23 || parseInt(ComGetObjValue(obj)) > 60) {
	    						ComShowCodeMessage('SCG50023');	//'Flashpoint is expected to be in the range of 23°C (include 23°C) to 60°c(include 60°C) for packing group III.'
	    					}
	    				}else if(ComGetObjValue(formObj.imdg_pck_grp_cd) == 'I' || ComGetObjValue(formObj.imdg_pck_grp_cd) == 'II') {
	    					if(parseInt(ComGetObjValue(obj)) >= 23) {
	    						ComShowCodeMessage('SCG50024');	//'Flashpoint is expected to be below 23°C for packing group I or II.'
	    					}
	    				}
    				}

       			}    				
    		}     
    	}
    }
    /**
     * Flash Point status change decision(main risk Class 3(inflammable liquid)or (Subsidiary risk) Class 3(inflammable liquid), Flashpoint input column should be compulsory item.)
     */
    function fixFlshPointForm(formObj) {
    	var rslt=false;
    	var flshpointObj=document.getElementById("flsh_pnt_cdo_temp"); 	
       
    	/**
         * 2015-03-26, Tae Woong Kim
         * NYK Enhancement (Redmine# : 39123)	
         * Delete Flash Point Value Check logic  (Becuase of Client's requset)
         * 2016-07-20, Tae Woong Kim
         * CSR #13131 - Make flashpoints mandatory for IMO Class 3 only
         * Class 3, Sub Label 3, UN3225, UN3257
         */   
   	
 		if(ComGetObjValue(formObj.imdg_clss_cd) == '3' || ComGetObjValue(formObj.n1st_imdg_subs_rsk_lbl_cd) == '3' || ComGetObjValue(formObj.n2nd_imdg_subs_rsk_lbl_cd) == '3' || ComGetObjValue(formObj.n3rd_imdg_subs_rsk_lbl_cd) == '3' || ComGetObjValue(formObj.n4th_imdg_subs_rsk_lbl_cd) == '3'
 		   || ComGetObjValue(formObj.imdg_un_no) =='3255' || ComGetObjValue(formObj.imdg_un_no) =='3257')
 		 {	
 			flshpointObj.removeAttribute("disabled");
 			flshpointObj.setAttribute("required", "true");
 			flshpointObj.className="input1";
// 		}else if(ComGetObjValue(formObj.imdg_clss_cd) != '' && ComGetObjValue(formObj.imdg_clss_cd) != '3') {
 		 }else{
 			ComSetObjValue(flshpointObj, "");
 			flshpointObj.removeAttribute("required");
 			flshpointObj.setAttribute("disabled", "true");
 			flshpointObj.className="input2";
 		} 
// 		else {
// 			flshpointObj.removeAttribute("required");
// 			flshpointObj.removeAttribute("disabled");
// 			flshpointObj.className="input";
// 			rslt=true;
// 		}
 		
//    	return rslt;
    }
    /**
     * In case of UN No. applying SP274, set Technical Name as compulsory item.
     */
    function chgTecNmBox(imdgSpclProviNo, obj, mrnPolutFlg) {
      	if(imdgSpclProviNo == '274' || imdgSpclProviNo == '318' ) {
    		obj.setAttribute("required", "true");
    		obj.className="input1";
		} else if(mrnPolutFlg == 'Y') {
    		obj.setAttribute("required", "true");
    		obj.className="input1";
		} else {
			obj.removeAttribute("required");
			obj.className="input";
		}
    }
    /**
     * HCDG/Remark(s) Button color change
     */
    function chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk) {
    	//HCDG Button color change
//		if(hcdg_flg == 'Y')
//			document.getElementById('btn2_HCDG').style.color="red";
//		else document.getElementById("btn2_HCDG").style.color="#737373";
//    	alert('hcdg_flg>'+hcdg_flg);
		if(hcdg_flg == 'Y'){
			document.getElementById("hcdg_flag").value="HCDG";
    	}else{
    		document.getElementById("hcdg_flag").value="";
    	}
		
		//Remark(s) Button color change
		if(hcdg_flg != null && ComTrim(imdg_subs_rsk_lbl_rmk) != '') {
 			//document.getElementById('btn2_Sub_Remark').style.color = "red";
 		} else {
 			//document.getElementById("btn2_Sub_Remark").style.color = "#737373";
 		}
    }
    /**
     * Attach File Button color change
     */
    function chgBtnAttachFile(val) {
    	if(val != 0) {
 			document.getElementById('btn1_Attach_File').style.color="red";
 		} else {
 			document.getElementById("btn1_Attach_File").style.color="black";
 		}
    }
    /**
     * MPA1 check
     */
    function chkMpa1(sheetObj, formObj, sXml) {
    	var rslt=ComGetEtcData(sXml, "rslt");
 		//MAP1 Validation
 		if(rslt != '-1') {
 			//'This DG Cargo is listed in First Schedule of Singapore. You need to check the total approved cargo net weight on the class for the max quantity of First Schedule DG which may remain on board at a Singapore berth.\nSo far, total {?msg1}kg have been approved on the Class {?msg2}. You are going to approve net weight {?msg3}kg additionally. Do you confirm?'
 			if (ComShowCodeConfirm('SCG50022', 
				 "BKG:"+ComGetObjValue(formObj.bkg_ref_no)+
				 ", VVD:"+ComGetObjValue(formObj.vsl_cd)+ComGetObjValue(formObj.skd_voy_no)+ComGetObjValue(formObj.skd_dir_cd)+
				 ", Class:"+ComGetObjValue(formObj.imdg_clss_cd),   
				 rslt)) {
 			}else{
 				document.all.auth_sts_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "auth_sts_cd");
 			}
 		}
    }     
    
    /** 
     * Initializing screen - Cargo
     * param : startObj ==> start object, endObj ==> end object, type ==> 1(only form object), 2(only IB Combo object), 3(all)
     */
    function objDisabled() {
		var elems   = document.form.elements;
		// text, textarea
		for(var i = 0; i < elems.length; i++) {
			var elem = elems[i];
			if (elem.tagName == 'INPUT') {        			             		
				elem.disabled = true;
			}
			if(elem.tagName == 'TEXTAREA') {
				if(preConds.pId != "VOP_SCG_5001"){
					elem.setAttribute("readOnly", "true");
				}
			}
			if (elem.getAttribute("ibcb-delegate") == 'true') {
				elem.disabled = true;
			}
		}
		// ibsheet-combo
		for(var k=0; k < comboObjects.length; k++) {
			// Cargo Seq.제외
			if(k!=2) {
				comboObjects[k].SetEnable(false);
			}
		}
		//2016-02-04 VOP_SCG_5001 에서 팝업 호출 시, N, AAA 일때 Enable처리 
		if(preConds.pId == "VOP_SCG_5001"){
			var parentAuthStsCd = ComGetObjValue(document.form.auth_sts_cd);
			var parentRjtCd = ComGetObjValue(document.form.spcl_cgo_auth_rjct_cd);
			if("N" == parentAuthStsCd){
				if("AAA"==parentRjtCd){
		 			document.getElementById("spcl_cgo_auth_rmk").className="input1";
		 			//document.form.spcl_cgo_auth_rmk='';
		 			document.form.spcl_cgo_auth_rmk.disabled=false;
		 			comboObjects[9].SetEnable(true);
				}	
				comboObjects[9].SetEnable(true);
			}
			
			if("Y" == parentAuthStsCd || "P" == parentAuthStsCd){
				document.form.spcl_cgo_auth_rmk.disabled=false;
			}

		}
		
		// CNTR Seq.
//		sheetObjects[0].SetEnable(false);
		// select OK, edit No
		sheetObjects[0].SetColEditable("cntr_tpsz_cd", 0);
		sheetObjects[0].SetColEditable("cntr_ref_no", 0);
//         try {
//        	 
//        	 for(var k=0; k < comboObjects.length; k++) {
//         	 	comboObjects[k].SetEnable(false);
//         	 }
//         	 
//         	 for(var k=0; k < sheetObjects.length; k++) {
//         		 sheetObjects[k].SetEnable(false);
//          	 }
//         	 
//        	 var elems   = document.form.elements;	 
//        	 for(var i = 0; i < elems.length; i++) {
//        		 var elem = elems[i];
//        		 
//	    	 if (elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA' || elem.tagName == 'BUTTON' || elem.tagName == 'COMBO') {        			 
//		    	 if (elem.name != '' && !(elem.name == "auth_sts_cd" || elem.name == "auth_dt" || elem.name == "apro_ref_no" || elem.name == "btn_calendar")) {                		
//            		elem.disabled = true;
//            	 } else {
//           		 elem.disabled = false;
//           	 }
//	    	 }
//        	 ComBtnEnable("btn1_Close");
//         } catch(err) { ComFuncErrMsg(err.message); } 
         return;
    }
    
    var showedLayer = -1;
    function showUploadLayer(btnName) {
 	    var uLayer=document.all.item("uploadLayer");
 	   
 	    //기존 레이어 닫기
 	    if (showedLayer != -1){
 	    	hideUploadLayer();
 	    }

 	    //새로 레이어 열기
 	 	var btnObj = ComGetObject(btnName);
 	   
		showedLayer = 1;
		var iTop    = AnchorPosition_getPageOffsetTop(btnObj)  - 260;
		var iLeft   = AnchorPosition_getPageOffsetLeft(btnObj) - 300;
		var iWidth  = 450;
		
		// 넓이초과
		if (iLeft + iWidth > document.body.clientWidth) {
			iLeft = document.body.clientWidth - iWidth;
			if (iLeft < 0) iLeft = 0;
		}
		
		uLayer.style.top        = iTop + "px";
		uLayer.style.left       = iLeft + "px";
		uLayer.style.height     = "250px";
		uLayer.style.visibility = "visible";
		sheetObjects[2].SetVisible(true);
    }

    function hideUploadLayer(sheetObj) {
 	    if (showedLayer == -1)  return;
 	    fileAttachCnt(sheetObj);
 	    var uLayer=document.all.item("uploadLayer");
    	uLayer.style.visibility="hidden";
    	uLayer.style.height    ="0px";
    	sheetObjects[2].SetVisible(false); 
    	showedLayer = -1;
    }
    
    function fileAttachCnt(sheetObj) {
    	if (sheetObj != undefined || sheetObj != null) {   		
 		    var file_cnt=0;
 			for (var rowIdx=1; rowIdx<=sheetObj.LastRow(); rowIdx++){
 				if (sheetObj.GetCellValue(rowIdx, "file_nm") != "" && !sheetObj.GetRowHidden(rowIdx)) {
 					file_cnt++;
 				}
 			}
	   		document.form.attach_file_cnt.value = (file_cnt > 0) ? file_cnt : 0 ;
	   	}
    }
    
    function fileAdd(sheetObj, btnName) {
    	
    	var frmObj  = document.form;
    	var fileSeq = 1;
    	if (sheetObj.RowCount() > 0) {
    		var iLast = sheetObj.LastRow();
    		if (sheetObj.GetRowStatus(iLast)=="I" && sheetObj.GetCellText(iLast, "file_nm")=="") return;
    	    //fileSeq = ComParseInt(sheetObj.GetCellValue(iLast, prefix+"stv_dmg_atch_file_seq"))+1;
    	}
    	
    	var row = sheetObj.DataInsert(-1);
    	sheetObj.SetCellValue(row, "file_set_yn",""             , 0);
		sheetObj.SetCellValue(row, "file_nm"    ,""             , 0);
		sheetObj.SetCellValue(row, "file_sav_id",""             , 0);
		sheetObj.SetCellValue(row, "cre_usr_id"                 , preConds.userId,0);
		sheetObj.SetCellValue(row, "cre_dt"                     , ComGetNowInfo("ymd"),0);
		sheetObj.SetCellValue(row, "spcl_cgo_irr_file_seq"      , "",0);
		sheetObj.SetCellValue(row, "crr_cd"                     , ComGetObjValue(document.form.crr_cd), 0);
		sheetObj.SetCellValue(row, "bkg_ref_no"                 , ComGetObjValue(document.form.bkg_ref_no),0);
		sheetObj.SetCellValue(row, "spcl_cgo_rqst_seq"          , ComGetObjValue(document.form.spcl_cgo_rqst_seq),0);
		sheetObj.SetCellValue(row, "prnr_cgo_rqst_seq"          , ComGetObjValue(document.form.prnr_cgo_rqst_seq),0);
		sheetObj.SetCellValue(row, "spcl_cgo_rqst_atch_file_seq", sheetObj.GetCellValue(row, "spcl_cgo_irr_file_seq"),0);
		
		//sheetObj.FitColWidth();
    }
    
    function sheet3_OnMouseMove(sheetObj) {
    	
    	var row = sheetObj.MouseRow();
    	var col = sheetObj.MouseCol();
        
        if (row <= 0 || sheetObj.ColSaveName(col) != "file_nm") return;
        
    	var info = sheetObj.GetCellElement(row, col, 1);
    	upload1.SetFileUploadElement(info);
    }
    
    function fileDel(sheetObj, btnName) {
    	
		var row =sheetObj.GetSelectRow();
		
		if (row<0) return;

	    //ibsheet에 이미 업로드된 파일이 있으면 해당 serial의 파일을 삭제한다.
		var sheet_serial = sheetObj.GetCellValue(row, "serial_no");
	    if (sheet_serial!="") {
	    	ComUploadRemoveFile(upload1, sheet_serial, false);
	    }

	    sheetObj.SetRowHidden(row,true);
    	sheetObj.SetRowStatus(row,"D");
    }
    
    function setFileLink(sheetNo){
		var sheetObj = sheetObjects[sheetNo];
		var col      = sheetObj.SaveNameCol("file_nm");
		ComSetRangeFont(sheetObj, "FontUnderline", true, sheetObj.HeaderRows(), col, sheetObj.LastRow(), col);
	}
    
    function sheet3_OnDblClick(sheetObj,Row,Col,Value){
		fileDownload(sheetObj, Row,Col, Value);
	}
    
    function fileDownload(sheetObj, Row,Col, Value){
		
        if (Row <= 0 	|| sheetObj.ColSaveName(Col) != "file_nm") return;
        if (Value == "" || sheetObj.GetRowStatus(Row) == "I") return;

        parent.location.href = "/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "file_sav_id");
        return;
    }
    
    
    function btnEnableProc(){
    	ComBtnEnable("btn1_New");
    	ComBtnEnable("btn1_Save");
    	
    	ComBtnEnable("btn_Carrier");
    	ComBtnEnable("btn_VVDpop");
    	ComBtnEnable("btn_Un_No");
    	
    	ComBtnEnable("btn2_Add");
    	ComBtnEnable("btn2_Delete");
    	ComBtnEnable("btn2_Copy");
    	
    	ComBtnEnable("btn3_Row_Add");
    	ComBtnEnable("btn3_Row_Copy");
    	ComBtnEnable("btn3_Row_Delete");
    	
    	ComBtnEnable("btn_fileAdd");
    	ComBtnEnable("btn_fileDel");
    }
	
    /*
     * button 비활성화 처리
     */
    function btnDisableProc(){
    	ComBtnDisable("btn1_New");
    	ComBtnDisable("btn1_Save");
    	ComBtnDisable("btn1_Request");
    	
    	ComBtnDisable("btn_Carrier");
    	ComBtnDisable("btn_VVDpop");
//    	ComBtnDisable("btn_Un_No");
    	
    	ComBtnDisable("btn2_Add");
    	ComBtnDisable("btn2_Delete");
    	ComBtnDisable("btn2_Copy");
    	
    	ComBtnDisable("btn3_Row_Add");
    	ComBtnDisable("btn3_Row_Copy");
    	ComBtnDisable("btn3_Row_Delete");
    	ComBtnDisable("btn3_Request_Cancel");
    	
    	ComBtnDisable("btn_fileAdd");
    	ComBtnDisable("btn_fileDel");
    }
    
    function checkImdgUnNoSeq() {
    	// EDI, imdg_un_no_seq가 없는 경우, border color를 지정한다.
    	if(preConds.src_tp_cd == 'EDI') {
    		if(ComGetObjValue(document.form.imdg_un_no_seq) == "") {
    			document.getElementById("imdg_un_no_seq").style.borderColor = "#F361DC";
    		} else {
    			document.getElementById("imdg_un_no_seq").style.borderColor = "";
    		}
    	}
    }
    
    function displayEDI() {
    	if(preConds.src_tp_cd == 'EDI') {
    		//checkImdgUnNoSeq();
        	ComBtnDisable("btn3_Row_Add");
        	ComBtnDisable("btn3_Row_Copy");
        	ComBtnDisable("btn3_Row_Delete");
        	ComBtnDisable("btn3_Request_Cancel");
    	}
    }
    
    function setUnmappedItem(sheetObj, row){
    	resetUnmappedItem();
    	var ediUnmapDtlCd = sheetObj.GetCellValue(row, "edi_unmap_dtl_cd");
    	ediUnmapDtlCd += "," + ComGetObjValue(document.form.edi_unmap_dtl_cd);
    	var ediUnmapDtlCdArr = ediUnmapDtlCd.split(",");
    	for(var i=0; i < ediUnmapDtlCdArr.length; i++){
    		if(ComTrimAll(ediUnmapDtlCdArr[i]) != "") {
			    if(ediUnmapDtlCdArr[i] == "011"){ //RSO
			    	document.getElementById("rgn_shp_opr_cd").removeAttribute("readOnly");
			    	document.getElementById("rgn_shp_opr_cd").style.borderColor = "#F361DC";
			    }else if(ediUnmapDtlCdArr[i] == "012"){//POL
			    	comboObjects[0].SetOutLineColor("#F361DC");
			    	$("#unmap_pol_cd").show();
			    	document.getElementById("unmap_pol_cd").style.borderColor = "#F361DC";
    			}else if(ediUnmapDtlCdArr[i] == "013"){//POD
    				comboObjects[1].SetOutLineColor("#F361DC");
    				$("#unmap_pod_cd").show();
    				document.getElementById("unmap_pod_cd").style.borderColor = "#F361DC";
    			}else if(ediUnmapDtlCdArr[i] == "021"){//LID
    				// TODO
    			}else if(ediUnmapDtlCdArr[i] == "022"){//DID
    				// TODO
    			}else if(ediUnmapDtlCdArr[i] == "101"){//CSZ
    		    	var spclccntrSeq  = sheetObj.GetCellValue(row, "spcl_cntr_seq")
    		    	sheetObjects[0].SetCellFontBold(spclccntrSeq, "cntr_tpsz_cd", 1)
    		    	sheetObjects[0].SetCellFontColor(spclccntrSeq, "cntr_tpsz_cd", "#F361DC")
    		    	sheetObjects[0].SetColHidden("unmap_cntr_tpsz_cd",0);
    				sheetObjects[0].SetColWidth	("cntr_ref_no","100");
    			}else if(ediUnmapDtlCdArr[i] == "201"){//PSN
    				document.getElementById("imdg_un_no_seq").style.borderColor = "#F361DC";
    			}else if(ediUnmapDtlCdArr[i] == "202"){//No tec name
    				document.getElementById("hzd_desc").style.borderColor = "#F361DC";
    			}
    		}
    	}
    }
    
    function resetUnmappedItem(){
    	document.getElementById("rgn_shp_opr_cd").setAttribute("readOnly", "true");
    	document.getElementById("rgn_shp_opr_cd").style.borderColor = "#B8D6F6";
    	
    	comboObjects[0].SetOutLineColor("#B8D6F6");
    	comboObjects[1].SetOutLineColor("#B8D6F6");
    	$("#unmap_pol_cd").hide();
    	$("#unmap_pod_cd").hide();
    	
    	document.getElementById("imdg_un_no_seq").style.borderColor = "#B8D6F6";
    	document.getElementById("hzd_desc").style.borderColor = "#B8D6F6";
    }


    