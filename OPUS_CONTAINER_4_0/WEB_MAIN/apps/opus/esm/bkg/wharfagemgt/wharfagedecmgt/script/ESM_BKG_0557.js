/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0557.js
*@FileTitle : Wharfage Declare
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
    /****************************************************************************************
  	Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var vAccmuDeclaAmt=0; //accumulate declare amount 
 // Event handler processing by button click event */
    document.onclick=processButtonClick;
 // Event handler processing by button name */
    function processButtonClick(){
		 var sheetObject1=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_retrieve":
            		obj_Init();
            		doActionIBSheet(sheetObject1,formObject,SEARCH01);
            		break;
            	case "btn_add":
            		var maxPortSeq=sheetObject1.RowCount();
            		for(var i=1; i<=sheetObject1.RowCount(); i++){
            			if( maxPortSeq == sheetObject1.GetCellValue(i,'sheet1_port_seq') ){
				    		++maxPortSeq;
            			}else if(maxPortSeq < sheetObject1.GetCellValue(i,'sheet1_port_seq')){
            				maxPortSeq=Number(sheetObject1.GetCellValue(i,'sheet1_port_seq'))+1;
				    	}
				    }
					sheetObject1.DataInsert(-1);
					sheetObject1.SetCellValue(sheetObject1.RowCount(),'sheet1_port_seq',maxPortSeq,0);
				break;
				case "btn_del":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;	
	            case "btn_decIF":
	            	formObject.cancel_flag.value="N";
	            	doActionIBSheet(sheetObjects[0],formObject,COMMAND02);
	            	doActionIBSheet(sheetObject1,formObject,SEARCH01);
	            	break;	
	            case "btn_changeNoIF":
	            	doActionIBSheet(sheetObjects[0],formObject,COMMAND03);
	            	doActionIBSheet(sheetObject1,formObject,SEARCH01);
	            	break;	
            	case "btn_save":
            		doActionIBSheet(sheetObjects[0],formObject,MULTI);
            		doActionIBSheet(sheetObject1,formObject,SEARCH01);
            		break;				
            	case "btn_send":
            		if (formObject.port_cd.value == 'KRPUS' && formObject.whf_bnd_cd.value == 'IN')
            		{
            			doActionIBSheet(sheetObjects[0],formObject,COMMAND04);
            		}
            		else
            		{
            			doActionIBSheet(sheetObjects[0],formObject,COMMAND01);            			
            		}           		
            		break;				
            	case "btn_calendar1":
	                var cal=new ComCalendar();
	                cal.select(formObject.whf_ntc_dt ,'yyyy-MM-dd');
					break;	
            	case "btn_decCancelIF":
            		formObject.cancel_flag.value="Y";
            		doActionIBSheet(sheetObjects[0],formObject,COMMAND02);            		
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
        initControl();
    }
    /**
     * registering initial event 
     */
    function initControl() {
    	var formObject=document.form;
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_Change', document.form);
    	formObject.vvd.focus();
    	// whf_bnd_cd combo selected value setting
    	if(formObject.bound.value == "I") {
    		formObject.whf_bnd_cd.value="II";
    	} else if(formObject.bound.value == "O") {
    		formObject.whf_bnd_cd.value="OO";
    	}
    }
    function searcgBySelect(){
    	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
    }
    /**
     * handling input search conditions
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	//var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcMaxLength = ComGetEvent("maxlength");
    	//var srcValue=window.event.srcElement.getAttribute("value");
    	var srcValue = ComGetEvent("value");
    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    /**
     * handling auto retrieving in case of inputed search conditions 
     */
    function condition_KeyUp(){
    	var formObject=document.form;
    	if( (    ComChkLen(formObject.vvd.value, 9) == "2" ) 
   				&& (ComChkLen(formObject.port_cd.value, 5) == "2" ) ){
    			doActionIBSheet(sheetObjects[0], formObject, SEARCH);
    	}
    }
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
            	      var HeadTitle1="||하역구분|운임톤/갯수|할인코드|할인율|할인 사유";
            	      var headCount=ComCountHeadTitle(HeadTitle1);
            	      var prefix1='sheet1_';
            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
            	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
            	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"Chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix1+"unld_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:21 },
            	             {Type:"Float",     Hidden:0,  Width:180,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"ttl_ton_qty",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
            	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"kr_whf_dc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
            	             {Type:"Combo",     Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"rate",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
            	             {Type:"Combo",     Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:prefix1+"kr_whf_dc_rsn_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"port_seq",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
            	             {Type:"Text",      Hidden:1, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
            	             {Type:"Text",      Hidden:1, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix1+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 } ];
            	      InitColumns(cols);
            	      SetEditable(1);
            	      SetWaitImageVisible(0);            	      
            	      SetSheetHeight(184);
            	      SetColProperty(prefix1+"unld_tp_cd", {ComboText:"1.일반하역|2.기계하역|3.송유관하역|4.무연탄|5.컨테이너20'이하|6.컨테이너20'|7.컨테이너30'|8.컨테이너40'|9.컨테이너45'", ComboCode:"1|2|3|4|5|6|7|8|9"} );
                  	  SetColProperty(prefix1+"kr_whf_dc_cd", {ComboText:"0|1|2|3|4|7", ComboCode:"0|1|2|3|4|7"} );
                  	  SetColProperty(prefix1+"rate", {ComboText:"0%|20%|50%|80%|100%|30%", ComboCode:"0|1|2|3|4|7"} );
                  	  SetColProperty(prefix1+"kr_whf_dc_rsn_cd", {ComboText:"1.조달물품|2.군용물품|3.수출입공컨테이너|4.연안컨테이너전용선|5.투자비보전|6.화주면제|9.기타||", ComboCode:"1|2|3|4|5|6|9|"} );
    	            }
                break;
            case "sheet2":      //sheet2 init
                with(sheetObj){
		              var HeadTitle1="|구분|면제화주|면제화주|면제화주|T/S|T/S|EMPTY|EMPTY|Other\n(IPO)|T/S Total|MTY\nTotal|면제 Total";
		              var HeadTitle2="|구분|동부제강|현대|동국|COM THRU|CUST T/S|REV.MT|REPO MT|Other\n(IPO)|T/S Total|MTY\nTotal|면제 Total";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              var prefix2='sheet2_';
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                              { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"size_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"dong_bu_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"hyun_dai_qty", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"dong_kuk_qty", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"thru_ts_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"cust_ts_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"rev_mt_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"repo_mt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"otr_qty",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"ts_total",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"mty_total",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix2+"exempt_total", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetSheetHeight(132);
                    }
                break;
        }
    }
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case SEARCH:
        		if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=SEARCH;   
					var aryPrefix=new Array("sheet1_"); 
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0557GS.do",FormQueryString(formObj) );
					if (ComGetEtcData(sXml,"mf_ref_no")){
						formObj.mf_ref_no.value=ComGetEtcData(sXml,"mf_ref_no");
						formObj.sail_dt.value=ComGetEtcData(sXml,"sail_dt"); 
					} else {
						formObj.mf_ref_no.value='';
						formObj.sail_dt.value='';
					}
        		}
        		break;
        	case SEARCH01:      
        		ComOpenWait(true);
        		if( validateForm(sheetObj,formObj,sAction) ){
        			var prefix2='sheet2_';
        			var prefix1='sheet1_';	
					formObj.f_cmd.value=SEARCH01;   
					var aryPrefix=new Array("sheet1_", "sheet2_" ); //prefix 
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0557GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0){
						sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );3
						sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
						var vNtcDt=ComGetEtcData(arrXml[0],"whf_ntc_dt");
						var vPayDt=ComGetEtcData(arrXml[0],"whf_pay_dt");
						var vWhfDeclNo='';
						if( vNtcDt != null && vPayDt != null){
							formObj.whf_ntc_dt.value=vNtcDt.substring(0,4)+"-"+ vNtcDt.substring(4,6) + "-" + vNtcDt.substring(6,8);
							formObj.whf_pay_dt.value=vPayDt.substring(0,4)+"-"+ vPayDt.substring(4,6) + "-" + vPayDt.substring(6,8);
							formObj.whf_usr_nm.value=ComGetEtcData(arrXml[0],"whf_usr_nm");
							if( "C" == ComGetEtcData(arrXml[0],"whf_cust_knd_cd") ){ 
								formObj.whf_cust_knd_cd[0].checked=true
							} else {
								formObj.whf_cust_knd_cd[1].checked=true
							}
							//TotalAmount
							formObj.whf_rt_amt.value=CommaInputWithPoint( ComGetEtcData(arrXml[0],"whf_rt_amt"), "1" );
							var vNtcAmt=ComGetEtcData(arrXml[0],"ntc_amt");
							formObj.ntc_amt.value=CommaInputWithPoint( vNtcAmt, "1" );
							vWhfDeclNo=ComGetEtcData(arrXml[0],"whf_decl_no") ;
							//Dec No
							formObj.whf_decl_no.value=vWhfDeclNo;
							vCsrNo=ComGetEtcData(arrXml[0],"csr_no") ;
							//Csr No
							formObj.csr_no.value=vCsrNo;
							//I/B T/S Amount
							formObj.ibts_amt.value=CommaInputWithPoint( ComGetEtcData(arrXml[0],"ibts_amt"), "1" );
							formObj.rduc_amt.value=CommaInputWithPoint( ComGetEtcData(arrXml[0],"rduc_amt"), "1" );
							//Commission
							formObj.comm_amt.value=CommaInputWithPoint( ComGetEtcData(arrXml[0],"comm_amt"), "1" );
							formObj.port_nm.value=ComGetEtcData(arrXml[0],"port_nm");
							formObj.whf_ntc_no_yr.value=ComGetEtcData(arrXml[0],"whf_ntc_no_yr");
							formObj.whf_ntc_no_mon.value=ComGetEtcData(arrXml[0],"whf_ntc_no_mon");
							formObj.whf_ntc_no_seq.value=ComGetEtcData(arrXml[0],"whf_ntc_no_seq");
							var vEdiMsgSndId=ComGetEtcData(arrXml[0],"edi_msg_snd_id");
							formObj.edi_msg_snd_id.value=ComGetEtcData(arrXml[0],"edi_msg_snd_id");
							formObj.cntr_20_ut_rt.value=ComGetEtcData(arrXml[0],"cntr_20_ut_rt");
							formObj.cntr_40_ut_rt.value=ComGetEtcData(arrXml[0],"cntr_40_ut_rt");
							formObj.cntr_45_ut_rt.value=ComGetEtcData(arrXml[0],"cntr_45_ut_rt");
							formObj.blk_ut_rt.value=ComGetEtcData(arrXml[0],"blk_ut_rt");
							formObj.blk_rt_rto.value=ComGetEtcData(arrXml[0],"blk_rt_rto");
							formObj.upd_usr_id.value=sheetObjects[0].GetCellValue(1, 8);
							formObj.upd_dt.value=sheetObjects[0].GetCellValue(1, 9);
						}
						/*
						 * retrieve success
						 */
						ComBtnDisable( "btn_save" );
						ComBtnDisable( "btn_send" );
						ComBtnDisable( "btn_decIF" );
						ComBtnDisable( "btn_changeNoIF" );
						if( 'IN' == formObj.whf_bnd_cd.value ){
							ComBtnEnable( "btn_save" );
							ComBtnEnable( "btn_send" );
						} else if( 'II' == formObj.whf_bnd_cd.value ){
							ComBtnEnable( "btn_save" );
							ComBtnEnable( "btn_decIF" );
						} else if( 'OO' == formObj.whf_bnd_cd.value ){
							ComBtnEnable( "btn_save" );
							ComBtnEnable( "btn_send" );
							ComBtnEnable( "btn_decIF" );
						} else {
							ComBtnDisable( "btn_decIF" );
							ComBtnEnable( "btn_save" );
							ComBtnEnable( "btn_send" );
						}
						if ( vWhfDeclNo.length == 19 ){
							ComBtnDisable( "btn_decIF" );
							ComBtnEnable( "btn_changeNoIF" );
							ComBtnEnable( "btn_decCancelIF" );
						} else {
							ComBtnDisable( "btn_decCancelIF" );
						}
						if ( vEdiMsgSndId == '2' ){
							formObj.send.options[0].selected=true ;
						} else if ( vEdiMsgSndId == '3' ){
							formObj.send.options[1].selected=true ;
						} else if ( vEdiMsgSndId == '4' ){
							formObj.send.options[2].selected=true ;
						} else {
							formObj.send.options[3].selected=true ;
						}
						if( parseInt( vNtcAmt ) < 1 )
							changeHaYoek();
					}
        		}
        		ComOpenWait(false);
        		break;
        	case COMMAND04:
        		ComOpenWait(true);
        		if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=COMMAND04;
 	    	        var sXml=sheetObj.GetSearchData("ESM_BKG_0557GS.do", FormQueryString(formObj));
				}
        		var dtCheck=ComGetEtcData(sXml, "dtCheck");
        		var etaDt=ComGetEtcData(sXml, "etaDt");
        		var frInDt=ComGetEtcData(sXml, "frInDt");
        		var emptyCheck=ComGetEtcData(sXml, "emptyCheck");
        		if (dtCheck == 'N' && emptyCheck == 'Y')
        		{
        			if(!ComShowCodeConfirm('BKG06116', frInDt, etaDt)) return false;
        			doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
        		}
        		else
        		{
        			doActionIBSheet(sheetObjects[0],document.form,COMMAND01);        			
        		}
        		ComOpenWait(false);
				break;
			case COMMAND01 :
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value=COMMAND01;
				    var sParam=ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 	    	        var SaveXml=sheetObj.GetSaveData("ESM_BKG_0557GS.do", sParam);
	    	        if( ComBkgErrMessage(sheetObj, SaveXml) ){
						ComShowCodeMessage('BKG00204');
					}else{
						ComShowCodeMessage('BKG00205');
					}
	    	        ComOpenWait(false);
				}    
				break;
			case COMMAND02 :
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value=COMMAND02;					
					var sParam=ComGetSaveString(sheetObjects);
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//					alert(sParam);
 					var SaveXml=sheetObj.GetSaveData("ESM_BKG_0557GS.do", sParam);
					if( ComBkgErrMessage(sheetObj, SaveXml) ){
						ComShowCodeMessage('BKG00204');
						doActionIBSheet(sheetObj,formObj,SEARCH01);
					}else{
						ComShowCodeMessage('BKG00205');
					}
					ComOpenWait(false);
				}    
				break;
			case COMMAND03 :
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value=COMMAND03;
					var sParam=ComGetSaveString(sheetObjects);
//					alert(formObj.whf_ntc_no_yr.value);
//					alert(formObj.whf_ntc_no_mon.value);
//					alert(formObj.whf_ntc_no_seq.value);
					sParam += "&" + "whf_ntc_no=" + 
						formObj.whf_ntc_no_yr.value + 
						formObj.whf_ntc_no_mon.value + 
						formObj.whf_ntc_no_seq.value;
					sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//					alert(sParam);
 					var SaveXml=sheetObj.GetSaveData("ESM_BKG_0557GS.do", sParam);
					sheetObj.LoadSaveData(SaveXml);
					ComOpenWait(false);
				}    
				break;	
			case MULTI:       
				if( validateForm(sheetObj,formObj,sAction) ){
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
				    for(var i=1; i<=sheetObjects[0].RowCount(); i++){
				    	if( 'R' == sheetObjects[0].GetCellValue(i,'sheet1_ibflag') ){
				    		sheetObjects[0].SetCellValue(i,'sheet1_ibflag','I',0);
				    	}
				    }
				    var sParam=ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 	    	        var SaveXml=sheetObj.GetSaveData("ESM_BKG_0557GS.do", sParam);
 	    	        sheetObj.LoadSaveData(SaveXml);
	    	        ComOpenWait(false);
				}    
    	    break;
			case IBDELETE:     
				var checked=0;
				for (var i=1 ; i <= sheetObj.RowCount()+1 ; i++){
					if( sheetObj.GetCellValue(i,1) == '1' ){
						checked=1;
						if (sheetObj.GetCellValue(i,0) != "I"){
							if( sheetObj.GetCellValue(i,1) == '1' ){
								sheetObj.SetRowHidden( i ,1);
								sheetObj.SetRowStatus( i ,"D");
							}
						}else{
							if( sheetObj.GetCellValue(i,1) == '1' ){
								sheetObj.SetRowStatus( i ,"D");
								i--;
							}
						}
					}	
				}
				if ( checked == 0 ) ComShowCodeMessage('BKG00249');
			break;
			case COMMAND05:      // Dec Cancle I/F
				ComOpenWait(true);
				formObj.f_cmd.value=COMMAND05
			break;
        }
    }
     /**
      * handling process for input validation
      */
    function validateForm(sheetObj,formObj,sAction){
    	var vvd=formObj.vvd.value;
    	var vpsPortCd=formObj.port_cd.value;
    	var ioBndCd=formObj.whf_bnd_cd.value;
    	var ntcNoYr=formObj.whf_ntc_no_yr.value;
    	var ntcNoMon=formObj.whf_ntc_no_mon.value;
    	var ntcNoSeq=formObj.whf_ntc_no_seq.value;
    	var whfUsrNm=formObj.whf_usr_nm.value;
    	var rducAmt=parseFloatWithoutComma( formObj.rduc_amt.value );
    	var commAmt=parseFloatWithoutComma( formObj.comm_amt.value );
    	var rtAmt=parseFloatWithoutComma( formObj.whf_rt_amt.value );
    	var whfNtcDt=formObj.whf_ntc_dt.value;
    	var ntcAmt=parseFloatWithoutComma( formObj.ntc_amt.value );
    	switch (sAction) {
     		case SEARCH01:
     			if( ComChkLen(vvd, 9) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'vvd');
     				formObj.vvd.focus();
     				return false;
     			}
     			if( ComChkLen(vpsPortCd, 5) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'Port');
     				formObj.port_cd.focus();
     				return false;
     			} 
     			return true;
     			break;
     		case SEARCH:
     			if ( ComChkLen(vvd, 9) != "2") {
     				ComShowCodeMessage('BKG00887', 'VVD');
     				return false;
     			}
     			if( ComChkLen(vpsPortCd, 5) != "2"  ){
     				ComShowCodeMessage('BKG00887', 'Port');
     				return false;
     			}
     			return true;
     			break;
	 		case MULTI:
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			if(ioBndCd == 'II' || ioBndCd == 'OO' || ioBndCd == 'OT'){
		 			if(rtAmt < ntcAmt){
				    	ComShowCodeMessage('BKG06121');
				    	return false;
				    }	 			
				    if(rtAmt != (ntcAmt + rducAmt)){
				    	ComShowCodeMessage('BKG06120');
				    	return false;
				    }
				    if ( (ntcAmt%10 )> 0){
				    	ComShowCodeMessage('BKG06122');
				    	return false;
				    }
	 			}		    
	 			return true;
	 			break;
	 		case COMMAND04:
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			if( '0' == formObj.send.value ){
	 				ComShowCodeMessage('BKG06048')
	 					return false;
	 			}		
	 			return true;
	 			break;
	 		case COMMAND01:
	 			if ( ComChkLen(vvd, 9) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(vpsPortCd, 5) != "2" ) {
	 				ComShowCodeMessage('BKG00715', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			if( '0' == formObj.send.value ){
	 				ComShowCodeMessage('BKG06048')
	 					return false;
	 			}		
	 			if(ioBndCd == 'II' || ioBndCd == 'OO' || ioBndCd == 'OT'){
		 			if(rtAmt < ntcAmt){
				    	ComShowCodeMessage('BKG06121');
				    	return false;
				    }
				    if(rtAmt != (ntcAmt + rducAmt)){
				    	ComShowCodeMessage('BKG06120');
				    	return false;
				    }
				    if ( (ntcAmt%10 )> 0){
				    	ComShowCodeMessage('BKG06122');
				    	return false;
				    }
	 			}
	 			return true;
	 			break;
	 		case COMMAND02:
	 			if ( ioBndCd == 'OT' || ioBndCd == 'IT' || ioBndCd == 'IN' ) {
	 				ComShowCodeMessage('BKG00715', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(vvd, 9) != "2" ) { // vvd
	 				ComShowCodeMessage('BKG00887', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(vpsPortCd, 5) != "2" ) { //port
	 				ComShowCodeMessage('BKG00887', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(ntcNoYr, 4) != "2"  ) {
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_yr.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(ntcNoMon, 2) != "2") {
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_mon.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(ntcNoSeq, 6) != "2" ) {
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_seq.focus();
	 				return false;
	 			}
	 			//checking whfNtcDt validation
//	 			alert("whfNtcDt=[" + whfNtcDt + "]");
	 			if( ! ComIsDate( whfNtcDt,'ymd') ){
	 				ComShowCodeMessage('BKG06052');
	 				formObj.whf_ntc_dt.focus();
	 				return false;
	 			}	
	 			if ( whfUsrNm.length < 1 ) { 
	 				ComShowCodeMessage('BKG00715', '담당자');
	 				formObj.whf_usr_nm.focus();
	 				return false;
	 			}
	 			if ( ntcAmt == 0 ) {
	 				ComShowCodeMessage('BKG06054');
	 				formObj.whf_usr_nm.focus();
	 				return false;
	 			}
	 			if ( Math.abs( rtAmt - ntcAmt )>50 ){
	 				ComShowCodeMessage('BKG06055');
	 				formObj.ntc_amt.focus();
	 				return false;
	 			}
	 			if ( Math.abs( (ntcAmt%10) ) > 50 ){
	 				ComShowCodeMessage('BKG06057');
	 				formObj.ntc_amt.focus();
	 				return false;
	 			}
	 			if ( rducAmt > 50 ){
	 				ComShowCodeMessage('BKG06056');
	 				formObj.ntc_amt.focus();
	 				return false;
	 			}
	 			if(ioBndCd == 'II' || ioBndCd == 'OO' || ioBndCd == 'OT'){
		 			if(rtAmt < ntcAmt){
				    	ComShowCodeMessage('BKG06121');
				    	return false;
				    }
				    if(rtAmt != (ntcAmt + rducAmt)){
				    	ComShowCodeMessage('BKG06120');
				    	return false;
				    }
				    if ( (ntcAmt%10 )> 0){
				    	ComShowCodeMessage('BKG06122');
				    	return false;
				    }
	 			}
	 			return true;
	 			break;
	 		case COMMAND03:
	 			if( ioBndCd == 'OT' || ioBndCd == 'IT' || ioBndCd == 'IN' ){
	 				ComShowCodeMessage('BKG06050');
	 				formObj.whf_bnd_cd.focus();
	 			}	
	 			if ( ComChkLen(ntcNoYr, 4) != "2"  ) { //
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_yr.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(ntcNoMon, 2) != "2") { //
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_mon.focus();
	 				return false;
	 			}
	 			else if ( ComChkLen(ntcNoSeq, 6) != "2" ) { //
	 				ComShowCodeMessage('BKG00715', '허가번호');
	 				formObj.whf_ntc_no_seq.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(vvd, 9) != "2" ) { // vvd
	 				ComShowCodeMessage('BKG00887', 'VVD');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(vpsPortCd, 5) != "2" ) { //port
	 				ComShowCodeMessage('BKG00887', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			if ( Math.abs( rtAmt - ntcAmt )>50 ){
	 				ComShowCodeMessage('BKG06055');
	 				formObj.ntc_amt.focus();
	 				return false;
	 			}
	 			if ( ComChkLen(formObj.whf_decl_no.value, 19) != "2" ) { // Dec No
	 				ComShowCodeMessage('BKG06058');
	 				return false;
	 			}
	 			if(ioBndCd == 'II' || ioBndCd == 'OO' || ioBndCd == 'OT'){
		 			if(rtAmt < ntcAmt){
				    	ComShowCodeMessage('BKG06121');
				    	return false;
				    }
				    if(rtAmt != (ntcAmt + rducAmt)){
				    	ComShowCodeMessage('BKG06120');
				    	return false;
				    }
				    if ( (ntcAmt%10 )> 0){
				    	ComShowCodeMessage('BKG06122');
				    	return false;
				    }
	 			}
	 			return true;
	 			break;
     	}
     }
    /**
     * remove comma.
     * @param targetNum
     * @return
     */
    function parseFloatWithoutComma( targetNum ){
    	return parseFloat( targetNum.split(",").join("") );
    }
    /**
     * process method when fist sheet value changed
     * 
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	if( Col == 2 || Col == 3){
    		changeHaYoek();
    	} 
    	if( Col == 4  )
    		sheetObj.SetCellValue(Row, "sheet1_rate",sheetObj.GetCellValue(Row, "sheet1_kr_whf_dc_cd"),0);
    }
    /**
     * change ntc_amt by cargo handling division change
     * 
     * @return
     */
    function changeHaYoek(){
    	var vTemp=createNtcAmt();
    	if( vTemp != 0 )
    		document.form.ntc_amt.value=CommaInputWithPoint ( String(vTemp), 3 );
    }
    /** 
     * accumulate declare amount calculate
     * @return vAccmuDeclaAmt
     */ 
    function createNtcAmt(){
    	var prefix1='sheet1_';
    	var formObj=document.form ;
    	var vBlkUtRt=parseInt( formObj.blk_ut_rt.value ); //blk_ut_rt
    	var vBlkRtRto=parseInt( formObj.blk_rt_rto.value ); //blk_rt_rto
    	var vCntr40UtRt=parseInt( formObj.cntr_40_ut_rt.value ); //cntr_40_ut_rt
    	var vCntr45UtRt=parseInt( formObj.cntr_45_ut_rt.value ); //cntr_45_ut_rt
    	var vCntr20UtRt=parseInt( formObj.cntr_20_ut_rt.value ); //cntr_20_ut_rt
    	vAccmuDeclaAmt=0;
    	for( var i=1; i<sheetObjects[0].RowCount(); i++){
    		var vUnldTpCd=sheetObjects[0].GetCellValue(i, prefix1+"unld_tp_cd");
    		var vTtlTonQty=parseInt( sheetObjects[0].GetCellValue(i, prefix1+"ttl_ton_qty") );
    		if ( (sheetObjects[0].GetCellValue(i, prefix1+"kr_whf_dc_rsn_cd").replace(" ","") == "" )
    				&& parseInt(sheetObjects[0].GetCellValue(i, prefix1+"ttl_ton_qty")) > 0 ){
    			if( "2" == vUnldTpCd )
    				vAccmuDeclaAmt=vAccmuDeclaAmt + ( (vTtlTonQty * vBlkUtRt)*vBlkRtRto );
    			else if( "8" == vUnldTpCd )
    				vAccmuDeclaAmt=vAccmuDeclaAmt + ( (vTtlTonQty * vCntr40UtRt) );
    			else if( "9" == vUnldTpCd )
    				vAccmuDeclaAmt=vAccmuDeclaAmt + ( (vTtlTonQty * vCntr45UtRt) );
    			else	
    				vAccmuDeclaAmt=vAccmuDeclaAmt + ( (vTtlTonQty * vCntr20UtRt) );
    		}
    	}
    	return vAccmuDeclaAmt;
    }
    /**
     * reduce amount and  Commission calculate method
     * @return
     */
    function changeCommition(val){
    	var formObj=document.form ;
    	//var vNtcAmt   =((formObj.ntc_amt.value).replace(".","")).split(",").join("");
    	var vNtcAmt=formObj.ntc_amt.value;
    	var vCommAmt=0;
    	//var vTotalAmt = ((formObj.whf_rt_amt.value).replace(".","")).split(",").join("");
    	var vTotalAmt=formObj.whf_rt_amt.value;
    	if( "C" == val )
    		vCommAmt=parseInt( (parseFloatWithoutComma(vNtcAmt) * 0.03)/10 ) * 10 ;
    	else
    		vCommAmt=0;
    	formObj.comm_amt.value=CommaInputWithPoint( String( vCommAmt ), 3);
    	formObj.rduc_amt.value=CommaInputWithPoint( String( parseFloatWithoutComma( vTotalAmt ) - parseFloatWithoutComma(vNtcAmt) ), 3 ) ;
    }
    /**
     * handling method when Total Amount value changed
     */
    function changeTotalAmtAndNtcAmt(){
    	PointNumberFixed( ComGetEvent("name"), window.ComGetEvent("value") );
    	if( window.event.srcElement.getAttribute("value") != '' ){
	    	if( document.form.whf_cust_knd_cd[0].checked )
	    		changeCommition( "C" );
	    	else
	    		changeCommition( "U" );
    	}
    }
    /**
     *  handling method when Permission number changed
     */
    function changePermitNum(){
    	var formObj=document.form ;
    	if( "OT" != formObj.whf_bnd_cd.value ){
	    	var vYear=formObj.whf_ntc_no_yr.value;
	    	var vMonth=formObj.whf_ntc_no_mon.value;
	    	var vSerialNum=formObj.whf_ntc_no_seq.value;
	    	var vTemp=0;
	    	if(  vYear.length == 4 && vMonth.length == 2 && vSerialNum.length >= 1){
	    		vTemp=6-parseInt(vSerialNum.length);
		    	for( var i=0; i<vTemp; i++){
		    		vSerialNum="0" + vSerialNum ; 
		    	}
	    	}	
	    	formObj.whf_ntc_no_seq.value=vSerialNum;
    	}	
    }
    /**
     * check a decimal place
     */
    function PointNumberFixed( name, value ){
   	 	var srcName=ComGetEvent("name");
    	var srcValue=window.event.srcElement.getAttribute("value");
        document.getElementById(srcName ).value=CommaInputWithPoint ( srcValue, 3 ) ;
    }
     /**
      * sheet initalize when search conditions change
      * @return
      */
     function obj_Change() {
     	var formObject=document.form;
     	var srcName=ComGetEvent("name");
     	if (srcName == "whf_bnd_cd") {
     		sheetObjects[0].RemoveAll();
     		sheetObjects[1].RemoveAll();
     		//ComResetAll();
     		formObject.whf_ntc_dt.value="";
     		formObject.whf_pay_dt.value="";
     		formObject.whf_usr_nm.value="";
     		formObject.whf_rt_amt.value="";
     		formObject.ntc_amt.value="";
     		formObject.whf_decl_no.value="";
     		formObject.ibts_amt.value="";
     		formObject.rduc_amt.value="";
     		formObject.comm_amt.value="";
     		formObject.port_nm.value="";
     		formObject.whf_ntc_no_yr.value="";
     		formObject.whf_ntc_no_mon.value="";
     		formObject.whf_ntc_no_seq.value="";
     		formObject.upd_usr_id.value="";
     		formObject.upd_dt.value="";
     	}
     }
      /**
       * form initialize
       * @return
       */
      function obj_Init() {
       	var formObject=document.form;
   		sheetObjects[0].RemoveAll();
   		sheetObjects[1].RemoveAll();
   		//ComResetAll();
   		formObject.whf_ntc_dt.value="";
   		formObject.whf_pay_dt.value="";
   		formObject.whf_usr_nm.value="";
   		formObject.whf_rt_amt.value="";
   		formObject.ntc_amt.value="";
   		formObject.whf_decl_no.value="";
   		formObject.ibts_amt.value="";
   		formObject.rduc_amt.value="";
   		formObject.comm_amt.value="";
   		formObject.port_nm.value="";
   		formObject.whf_ntc_no_yr.value="";
   		formObject.whf_ntc_no_mon.value="";
   		formObject.whf_ntc_no_seq.value="";
   		formObject.upd_usr_id.value="";
   		formObject.upd_dt.value="";
       }
