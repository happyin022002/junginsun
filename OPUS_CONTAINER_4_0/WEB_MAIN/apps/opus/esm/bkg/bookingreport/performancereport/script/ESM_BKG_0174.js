/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0174.js
*@FileTitle  : Booking Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================
*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0174 :business script for ESM_BKG_0174 
     */
   	/* developer's work*/
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var searchXml="";
    var beforeIdx=0;
    var newItemIdx=0;
    var comboCnt=0;
	var comboObjects=new Array();    
	var rdObjects=new Array();
	var rdCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
      /**
      * registering the created IBCombo Object at page as comboObjects list
      * ComComboObject is called from Constructor method  
	 	 	* param : comboObj ==>combo Object
	 	 	* 
      */
     function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            sheetObjects[i].isible=false;
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
 	    for(var k=0;k<comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }
 	    for(i=0;i<rdObjects.length;i++){
 	    	initRdConfig(rdObjects[i],i+1);
 	    }
		doActionIBSheet(sheetObjects[0],document.form,INIT);
		initControl();
    }
    
	function initRdConfig(rdObject){
		var Rdviewer = rdObject ;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);

		Rdviewer.SetBackgroundColor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.ApplyLicense("0.0.0.0"); 
		Rdviewer.style.height = 0;
	}
 	/**
   * Dynamic loading the event of  HTML Control in the page <br>
   * initializing IBSheet Object when this function is called from {@link #loadPage} <br>
   * 
   * @param {ibsheet}
   *            sheetObj IBSheet Object
   * @param {int}
   *            sheetNo sheetObjects 
   */
	  function initControl() {
	  	var formObject=document.form;
	  	  DATE_SEPARATOR="-";
	  }
     /**
 	 * setting Combo 
 	 * param : comboObj ==> combo Object , comboNo ==> sequence which is ID of comboObject tag
 	 * construct initial module of sheet, as adding case which is a number of combo  
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject=document.form;
		initComboEditable(comboObj, comboId);
 	}

 	function initComboEditable(combo, comboId){
 	 	with (combo) {
 	 		if(combo.options.id == "dlv_ctnt_cd" ){
	 	 		SetMultiSelect(0);
	 	 		SetUseAutoComplete(1);
	 	 		SetUseEdit(0);
 	 		}
 	 		else {
 	 			SetMultiSelect(1);
	 	 		SetUseEdit(0);
 	 		}
 	 	}
 	 }      
 	function dlv_ctnt_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
 	{
 		form.dlv_ctnt_cd_text.value = dlv_ctnt_cd.GetText(parseInt(newIndex), 0);
 	}
 	


     /**
	 * keyboard control at onkeypress event of HTML Control 
	 **/
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
	    			      var HeadTitle="";
	    			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	    			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    			      InitHeaders(headers, info);
	    			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	    			             {Type:"Text",      Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"rpt_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rpt_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_rpt_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bzc_cond_sql_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bzc_ord_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"temp_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	    			      InitColumns(cols);
	    			      SetEditable(1);
	    			      SetVisible(false);
			            }
                    break;
                    
    				case "sheet2":
    	                break;
    				case "sheet3":      //sheet3 init
    				    with(sheetObj){
	    			        var HeadTitle1="|B/L No|Bkg No|Revenue|Non Revenue|Expense|VVD|B/L OBRD Date|BKG OFC|RHQ of C/A OFC|Contract OFC|POR CD|POL CD|POD CD|DEL CD|C/A No|C/A Date|" + "C/A OFC|C/A Staff|C/A Reason|Exemption|Exempt Case|Kind_A|Kind_B|Kind_C|Kind_D|Kind_E|Kind_F|Kind_G|Kind_H|Kind_I|Kind_J|Kind_K|" + "SPLIT|CANCEL|CREATE|MODIFY|RATE USER|Customer Name|Remark";
	    			        var headCount=ComCountHeadTitle(HeadTitle1);
	    			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	    			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    			        InitHeaders(headers, info);
	    			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	    			             {Type:"Text",      Hidden:0,  Width:92,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rev",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"nonrev",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"exp",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_obrd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sls_rhq_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:1,   SaveName:"corr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:54,   Align:"Center",  ColMerge:1,   SaveName:"corr_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"corr_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"corr_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ca_rsn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"exemption",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_exempt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_a",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_b",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_c",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_d",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_e",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_f",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_g",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_h",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_i",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_j",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_k",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_split_modi_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cxl_modi_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	    			        InitColumns(cols);
	    			        SetEditable(1);
	    			        SetVisible(false);
	    			        updateSheetSize(sheetObj);
			            }
                    break;
            }
        }
        

        $(window).resize(function() {
        		if(this.resizeTO) {
        			clearTimeout(this.resizeTO);
        		}
        		this.resizeTO = setTimeout(function() {
        			$(this).trigger('resizeEnd');
        		}, 300);
        });

        $(window).on('resizeEnd', function() {
        	 updateSheetSize();
        });

        function updateSheetSize(sheetObj){
          if(typeof sheetObj == "undefined") {
        	for(var i = 0; i < sheetObjects.length; i++) {
        		if($("#"+sheetObjects[i].id).offset().top != 0) {
        			sheetObj = sheetObjects[i];
        			break;
        		}
        	}
          }
          var obj = $("#" + sheetObj.id).offset();
          var marginDefault = 20;
          var marginHeight = obj.top + marginDefault;
          var height = $(window).height();

          with(sheetObj){
             SetSheetHeight(height - marginHeight);
          }
        }        
        
         function setDisplayOP(){
        	 var formObj=document.form;
        	 var cnt=0;
        	 sheetObjects[1].RenderSheet(0);
             with(sheetObjects[1]){
	              var HeadTitle1="|RHQ of C/A OFC|BKG OFC|C/A OFC|Contract OFC|B/L Q'ty|C/A Q'ty|" +
	              "C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|C/A Reason|Exempt|Class|Class|" +
	              "Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind|Kind";
	              var HeadTitle2="|RHQ of C/A OFC|BKG OFC|C/A OFC|Contract OFC|B/L Q'ty|C/A Q'ty|" +
	              "M|C|G|A|R|C.Haul|M.Haul|Exempt|R|N|A|B|C|D|E|F|G|H|I|J|K";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                        { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
	              cols.push({Type:"Text",      Hidden:1, Width:92,   Align:"Center",  ColMerge:1,   SaveName:"sls_rhq_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"corr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnt_bl_ttl",   KeyField:0,   CalcLogic:"",   Format:"",     		 PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnt_ca_ttl",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_rsn_m",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_rsn_c",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_rsn_g",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_rsn_a",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_rsn_r",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnt_hlg_c",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnt_hlg_m",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnt_exempt",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_class_r",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_class_n",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_a",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_b",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_c",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_d",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_e",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_f",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_g",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_h",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_i",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_j",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	              cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnt_kind_k",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
	      
	              InitColumns(cols);
	              
	              SetEditable(1);
	              SetSheetHeight(450);

	              if (formObj.off_dis_op_1.checked == true){
	            	  SetColHidden("sls_rhq_cd",0);
	              }else{
	            	  SetColHidden("sls_rhq_cd",1);
	              }
	              if (formObj.off_dis_op_2.checked == true){
	            	  SetColHidden("bkg_ofc_cd",0);
	              }else{
	            	  SetColHidden("bkg_ofc_cd",1);
	              }
	              if (formObj.off_dis_op_3.checked == true){
	            	  SetColHidden("corr_ofc_cd",0);
	              }else{
	            	  SetColHidden("corr_ofc_cd",1);
	              }
	              if (formObj.off_dis_op_4.checked == true){
	            	  SetColHidden("ctrt_ofc_cd",0);
	              }else{
	            	  SetColHidden("ctrt_ofc_cd",1);
	              }
        	 }
             sheetObjects[1].RenderSheet(1);
         }
         
         function sheet3_OnSearchEnd(sheetObj, errMsg) {
        	 ComOpenWait(false);	
         }
         
         function sheet2_OnSearchEnd(sheetObj, errMsg) {
        	 sheetObj.SetSumText(0, 'cnt_bl_ttl', "TOTAL");
        	 doActionIBSheet(sheetObjects[2],document.form,COMMAND01);
         }
         
         function sheet3_OnDownFinish(downloadType, result) {
        	 ComOpenWait(false);
         }

         
         function processButtonClick(){
               /***** using extra sheet valuable if there are more 2 sheets *****/
     	       var sheetObject1=sheetObjects[0];
     	       var sheetObject2=sheetObjects[1];
     	       var sheetObject3=sheetObjects[2];
               /*******************************************************/
               var formObject=document.form;
              try {
         		var srcName=ComGetEvent("name");
         		if(ComGetBtnDisable(srcName)) return false;
                 switch(srcName) {
	                 case "btn_addTemp":	                	 
	                	 addTemplate();
	                 break;
	                 case "btn_new":	                	 
	                	 ComResetAll();
	                	 setSqlCondition();
	                 break;
	                 case "btn_Retrieve":	 
	                	 doActionIBSheet(sheetObjects[1],document.form,SEARCH);
	                 break;
	                 case "btn_sum_excel":
	                	 if(sheetObject2.RowCount()==0){
							ComShowCodeMessage("BKG00109");
							return;
	                	 }else{
		                	 sheetObject2.Down2Excel({
		                		DownCols: makeHiddenSkipCol(sheetObject2),
		                		Merge: 1,
		                		SheetDesign: 1,
		                		ExcelFontSize: 10,
		                		ExcelRowHeight: 18
		                	 });  
	                	 }

     		    	 break;
	                 case "btn_bl_excel":
	                	 ComOpenWait(true);	
	                	 if(sheetObject3.RowCount()==0){
	         				ComShowCodeMessage("BKG00109");
	          	     	 }else{
	          	     		 setTimeout('doExcelDown()', 500);
	          	     	 }
     		    	break;
					case "btn_rd":
						if (sheetObjects[1].RowCount()< 1) {
								ComShowCodeMessage("COM12189");
								return;
						}
						if(!ComShowCodeConfirm("BKG04023")){
								return ;
						}
						rdOpen("print");
     		    	 break;     		    
					case "btn_Print":
	             	 if(!validateForm(sheetObjects[1],document.form,SEARCH)) return;
	             	 setSqlCondition();
	             	 goPrint();
     		    	 break;
					case "btn_corr_calendar":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.corr_from_dt, formObject.corr_to_dt,'yyyy-MM-dd');
						break;
					case "btn_cre_calendar":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.cre_from_dt, formObject.cre_to_dt,'yyyy-MM-dd');
						break;
	     			 case "btn_cakind":
	     				 ComOpenPopup("ESM_BKG_0758_POP.do?pgmNo=ESM_BKG_0758", 600, 410, "", '1,0,1,1,1', true);
	 				 break;
                 } // end switch
         	} catch(e) {
         		if( e == "[object Error]") {
         			ComShowMessage(OBJECT_ERROR);
         		} else {
         			ComShowMessage(e.message);
         		}
         		ComOpenWait(false);
         	}
         }

        /**
         * BL List Down Excel
         */
         function doExcelDown(){
        	 sheetObjects[2].Down2Excel({
           		DownCols: makeHiddenSkipCol(sheetObjects[2]),
           		Merge: 1,
           		SheetDesign: 1,
           		AutoSizeColumn: 1,
           		ExcelFontSize: 10,
           		ExcelRowHeight: 18
           	});
         }
         
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            sheetObj.SetWaitImageVisible(0);
        	switch(sAction) {
				case INIT:      //INIT		
					ComClearCombo(formObj.rpt_nm);
					formObj.f_cmd.value=INIT;   
					sXml=sheetObj.GetSearchData("ESM_BKG_0174GS.do" , FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					searchXml=arrXml[0];
					ComXml2ComboItem(arrXml[1], dlv_ctnt_cd, "val", "name");
					var listSize=ComGetEtcData(searchXml,"listSize");
					if (listSize > 0){																	
						for (var i=0 ; i <= listSize  ; i++){
							if (i == 0){
								formObj.rpt_nm.options[i]=new Option("", "new");
							}else{
								formObj.rpt_nm.options[i]=new Option(ComGetEtcData(searchXml,"rptNm_" + i), "C:" + ComGetEtcData(searchXml,"rptId_" + i));
							}
						}
						formObj.reset();									
	 		        }
					setDisplayOP();
				break;
				case SEARCH:      //search	
					sheetObj.RemoveAll();
					sheetObjects[2].RemoveAll();
					if(!validateForm(sheetObj,formObj,sAction)) return;
					tabObjects[0].SetSelectedIndex("1");
					ComOpenWait(true);
					setSqlCondition();
					formObj.f_cmd.value=SEARCH;   
					sheetObj.DoSearch("ESM_BKG_0174GS.do",FormQueryString(formObj));
				break;
					case COMMAND01:
						if(!validateForm(sheetObj,formObj,sAction)) return;
						setSqlCondition();
						formObj.f_cmd.value=COMMAND01;   
						sheetObj.DoSearch("ESM_BKG_0174GS.do",FormQueryString(formObj));
				break;
            }
        }
        
        /**
         * registering IBTab Object as list
         * adding process for list in case of needing batch processing with other items
         * defining list on the top of source
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++]=tab_obj;
        }
        /**
         * setting Tab 
         * setting item of Tab
         */
        function initTab(tabObj , tabNo) {
             switch(tabNo) {
                 case 1:
                    with (tabObj) {
                        var cnt=0 ;
						InsertItem( "Search" , "");
						InsertItem( "Result" , "");
                    }
                 break;
             }
             tabObj.SetSelectedIndex(0);
        }
        /**
         * Event when clicking Tab
         * activating selected tab items
         */
        function tab1_OnChange(tabObj , nItem)
        {
        	formObject = document.form;
	       	var objs=document.all.item("tabLayer");
	       	objs[nItem].style.display="Inline";
	       	for(var i = 0; i< objs.length; i++){
		        	  if(i != nItem){
			        	   objs[i].style.display="none";
			        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		        	  }
	       	}
	       	beforetab=nItem;
        }
       /**
        * change template name
        */
        function changeNm(){
        	formObj=document.form;
        	var idx=formObj.rpt_nm.selectedIndex;
        	var rpt_id=formObj.rpt_nm.options[idx].value;
        	var rpt_nm=formObj.rpt_nm.options[idx].text;
        	if (rpt_id != "new"){
        		setCondition(ComGetEtcData(searchXml,"seq_" + formObj.rpt_nm.selectedIndex), ComGetEtcData(searchXml,"ord_" + formObj.rpt_nm.selectedIndex),formObj);        	
        	}else{
        		formObj.reset();
        		formObj.rpt_nm[idx].selected=true;	
        	}
        	setDisplayOP();
        }
        /**
         * Make Option
         */
        function makeOption(formObj){
        	var seq_ctnt=new Array();
        	for (var i=0 ; i < formObj.length ; i++){
         		if (formObj[i].type == "checkbox"){
         			if (formObj[i].checked == true){
         				seq_ctnt[i]=formObj[i].name + "=" + "Y";
         			}else{
         				seq_ctnt[i]=formObj[i].name + "=" + "N";
         			}        			
         		}else{
         			if (formObj[i].name == "add_value"){
         				seq_ctnt[i]=formObj[i].name + "=";
         			}else{
         				seq_ctnt[i]=formObj[i].name + "=" + formObj[i].value;
         			}
         		}
         	}
        	return seq_ctnt.join("|");
        }
        /**
         * handling process for input validation
         */  
        function validateForm(sheetObject1,formObject,sAction){
        	
        	if (ComGetDaysBetween(formObject.corr_from_dt,formObject.corr_to_dt) > 31){
				ComShowMessage(msgs['BKG50469']);
				return false;
			} 	
        	
        	if (ComGetDaysBetween(formObject.cre_from_dt,formObject.cre_to_dt) > 31){
				ComShowMessage(msgs['BKG50469']);
				return false;
			} 
        	
        	if (formObject.corr_from_dt.value == '' && 
        	    formObject.corr_to_dt.value == ''   &&
        	    formObject.cre_from_dt.value == ''  &&
        	    formObject.cre_to_dt.value == ''	&&
        	    formObject.vvd.value == ''){
        		ComShowCodeMessage("BKG08029");//Please Input Period
        		formObject.corr_from_dt.focus();
				return false;
        	}
        	if (formObject.off_dis_op_5.checked == true && formObject.ca_issue_off.value == ''){
        		ComShowCodeMessage("BKG00922");//Please, input Office Code!
    			formObject.ca_issue_off.focus();
				return false;
        	}
        	if (formObject.off_dis_op_6.checked == true && formObject.del.value == ''){
        		ComShowCodeMessage("BKG00290");//DEL is not available
    			formObject.del_off.focus();
				return false;
        	}
        	if (formObject.vvd.value != ''){
        		if (formObject.vvd.value.length < 9){
        			ComShowCodeMessage("BKG00780");//T.VVD is 9 Digits
        			formObject.vvd.focus();
					return false;
        		}
        	}
        	if (formObject.ca_issue_off.value != ''){
        		if (formObject.ca_issue_off.value.length < 5){
        			ComShowCodeMessage("BKG08031");//C/A Issue Office is 5 Digits
        			formObject.ca_issue_off.focus();
					return false;
        		}
        	}
        	return true;
        }                      
         /**
          *  setting the name of screen form  , and input value
          */  
        function checkFormType(sheetObj,formObj,seq_ctnt,ord_ctnt){
        	ord_ctnt="";
         	for (var i=0 ; i < formObj.length ; i++){
         		if (formObj[i].type == "checkbox"){
         			if (formObj[i].checked == true){
         				seq_ctnt[i]=formObj[i].name + "=" + "Y";
         			}else{
         				seq_ctnt[i]=formObj[i].name + "=" + "N";
         			}        			
         		}else{
         			seq_ctnt[i]=formObj[i].name + "=" + formObj[i].value;
         		}
         	}
        }
          /**
           * condition setting
           */ 
        function setCondition(seqValue, ordValue, formObj){
        	var seq_ctnt=new Array();
         	var ord_ctnt=new Array(); 
         	seq_ctnt=seqValue.split("|");
         	for (var i=0 ; i < formObj.length ; i++){
         		for (var j=0 ; j < seq_ctnt.length ; j++){
         			var tempSeq=seq_ctnt[j].split("=");
         			if (formObj[i].name == tempSeq[0]){
         				if (formObj[i].name == "dlv_ctnt_cd") {
         					dlv_ctnt_cd.SetSelectCode(tempSeq[1]);
         				} else {
			         		if (formObj[i].type == "checkbox"){
			         			if (tempSeq[1] == "Y"){
			         				formObj[i].checked=true;
			         			}else{
			         				formObj[i].checked=false;
			         			}        			
			         		}else{
			         			if (formObj[i].name != "rpt_nm"){
			         				if (tempSeq[1] != undefined){
			         					formObj[i].value=tempSeq[1];
			         				}else{
			         					formObj[i].value="";
			         				}		         				
			         			}
			         		}
         				}
		         		break;
         			}
         		}
         	}
        }
       /**
        * open Add Template
        */    
       function addTemplate(){
    	   var param=""
//     	   var pWin=ComOpenWindow("/opuscntr/ESM_BKG_0767.do" + param,"open0767", "statebar=no,width=700,height=600,left=200,top=0");
//			var url="ESM_BKG_0767.do?cntr_no="+cntr_no+"&cntr_tpsz_cd="+cntr_tpsz_cd;
//			ComOpenWindow(url, "ESM_BKG_0176", "width=450,height=300", false);
			ComOpenPopup("/opuscntr/ESM_BKG_0767.do",700, 600, "", "1,0", true);
       }
       /**
        * open Add Template End Save Event
        */
       function reSearch(){
    	   doActionIBSheet(sheetObjects[0],document.form,INIT);
    	   if (document.form.rpt_nm.length == 0){
    		   ComResetAll();
    	   }
       }
      /**
       * setting condition
       */   
      function setSqlCondition(){
    	  var formObj=document.form;
    	  var tempStr="";
    	  var tempVal="";
    	  var tempSql="";
    	  var tempDis="";
    	  var tempCnt="";
    	  if (formObj.ca_reason_m.checked == true){
    		  tempStr=" COR.CA_RSN_CD='M' ";
    		  tempVal="M";
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_reason_c.checked == true){
    			  tempStr += " OR COR.CA_RSN_CD='C' ";
    			  tempVal += ",C";
    		  }
    	  }else{
    		  if (formObj.ca_reason_c.checked == true){
    			  tempStr=" COR.CA_RSN_CD='C' ";
    			  tempVal="C"
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_reason_g.checked == true){
    			  tempStr += " OR COR.CA_RSN_CD='G' ";
    			  tempVal += ",G";
    		  }
    	  }else{
    		  if (formObj.ca_reason_g.checked == true){
    			  tempStr=" COR.CA_RSN_CD='G' ";
    			  tempVal="G";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_reason_a.checked == true){
    			  tempStr += " OR COR.CA_RSN_CD='A' ";
    			  tempVal += ",A";
    		  }
    	  }else{
    		  if (formObj.ca_reason_a.checked == true){
    			  tempStr=" COR.CA_RSN_CD='A' ";
    			  tempVal="A";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_reason_o.checked == true){
    			  tempStr += " OR COR.CA_RSN_CD='R' ";
    			  tempVal += ",R";
    		  }
    	  }else{
    		  if (formObj.ca_reason_o.checked == true){
    			  tempStr=" COR.CA_RSN_CD='R' ";
    			  tempVal="R";
    		  }
    	  }
    	  formObj.ca_reason.value=tempStr;
    	  formObj.ca_reason_val.value=tempVal;
    	  tempStr="";
    	  tempVal="";
    	  if (formObj.ca_class_1.checked == true){
    		  tempStr=" COR.RAT_FLG='Y' ";
    		  tempVal="R";
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_class_2.checked == true){
    			  tempStr += " OR COR.RAT_FLG='N' ";
    			  tempVal += ",N";
    		  }
    	  }else{
    		  if (formObj.ca_class_2.checked == true){
    			  tempStr=" COR.RAT_FLG='N' ";
    			  tempVal="N";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_class_3.checked == true){
    			  tempStr += " OR COR.EXPN_FLG='Y' ";
    			  tempVal += ",E";
    		  }
    	  }else{
    		  if (formObj.ca_class_3.checked == true){
    			  tempStr=" COR.EXPN_FLG='Y' ";
    			  tempVal="E";
    		  }
    	  }
    	  formObj.ca_class.value=tempStr; 
    	  formObj.ca_class_val.value=tempVal;
    	  tempStr="";
    	  tempVal="";    	  
    	  if (formObj.ca_kind_a.checked == true){
    		  tempStr=" COR.RT_CORR_FLG='Y' ";
    		  tempVal="A";
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_b.checked == true){
    			  tempStr += " OR COR.CHG_TERM_CORR_FLG='Y' ";
    			  tempVal += ",B";
    		  }
    	  }else{
    		  if (formObj.ca_kind_b.checked == true){
    			  tempStr=" COR.CHG_TERM_CORR_FLG='Y' ";
    			  tempVal="B";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_c.checked == true){
    			  tempStr += " OR COR.RCVDE_TERM_CORR_FLG='Y' ";
    			  tempVal += ",C";
    		  }
    	  }else{
    		  if (formObj.ca_kind_c.checked == true){
    			  tempStr=" COR.RCVDE_TERM_CORR_FLG='Y' ";
    			  tempVal="C";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_d.checked == true){
    			  tempStr += " OR COR.ROUT_CORR_FLG='Y' ";
    			  tempVal += ",D";
    		  }
    	  }else{
    		  if (formObj.ca_kind_d.checked == true){
    			  tempStr=" COR.ROUT_CORR_FLG='Y' ";
    			  tempVal="D";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_e.checked == true){
    			  tempStr += " OR COR.CUST_CORR_FLG='Y' ";
    			  tempVal += ",E";
    		  }
    	  }else{
    		  if (formObj.ca_kind_e.checked == true){
    			  tempStr=" COR.CUST_CORR_FLG='Y' ";
    			  tempVal="E";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_f.checked == true){
    			  tempStr += " OR COR.QTY_CORR_FLG='Y' ";
    			  tempVal += ",F";
    		  }
    	  }else{
    		  if (formObj.ca_kind_f.checked == true){
    			  tempStr=" COR.QTY_CORR_FLG='Y' ";
    			  tempVal="F";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_g.checked == true){
    			  tempStr += " OR COR.MEAS_QTY_CORR_FLG='Y' ";
    			  tempVal += ",G";
    		  }
    	  }else{
    		  if (formObj.ca_kind_g.checked == true){
    			  tempStr=" COR.MEAS_QTY_CORR_FLG='Y' ";
    			  tempVal="G";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_h.checked == true){
    			  tempStr += " OR COR.CMDT_CORR_FLG='Y' ";
    			  tempVal += ",H";
    		  }
    	  }else{
    		  if (formObj.ca_kind_h.checked == true){
    			  tempStr=" COR.CMDT_CORR_FLG='Y' ";
    			  tempVal="H";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_i.checked == true){
    			  tempStr += " OR COR.TRNK_VSL_CORR_FLG='Y' ";
    			  tempVal += ",I";
    		  }
    	  }else{
    		  if (formObj.ca_kind_i.checked == true){
    			  tempStr=" COR.TRNK_VSL_CORR_FLG='Y' ";
    			  tempVal="I";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_j.checked == true){
    			  tempStr += " OR COR.PRPST_VSL_CORR_FLG='Y' ";
    			  tempVal += ",J";
    		  }
    	  }else{
    		  if (formObj.ca_kind_j.checked == true){
    			  tempStr=" COR.PRPST_VSL_CORR_FLG='Y' ";
    			  tempVal="J";
    		  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.ca_kind_k.checked == true){
    			  tempStr += " OR COR.CA_OTR_RSN_CORR_FLG='Y' ";
    			  tempVal += ",K";
    		  }
    	  }else{
    		  if (formObj.ca_kind_k.checked == true){
    			  tempStr=" COR.CA_OTR_RSN_CORR_FLG='Y' ";
    			  tempVal="K";
    		  }
    	  }
    	  formObj.ca_kind.value=tempStr;
    	  formObj.ca_kind_val.value=tempVal;
    	  tempStr="";
    	  tempVal="";
    	  tempSql="";
    	  tempCnt="";
    	  if (formObj.off_dis_op_1.checked == true){
    	      tempStr += ",SLS_RHQ_CD ";
    	      tempCnt += ",CNT.SLS_RHQ_CD ";
    	      tempVal="RHQ OF C/A OFC";
    	      tempSql=",'RHQ of C/A OFC:' || SLS_RHQ_CD ";
    	  }
    	  if (tempStr != ""){
	    	  if (formObj.off_dis_op_2.checked == true){
	    		  tempStr += ",BKG_OFC_CD ";
	    		  tempCnt += ",CNT.BKG_OFC_CD ";
	    		  tempVal += ",BKG OFC";
	    		  tempSql += " || 'BKG OFC:' || BKG_OFC_CD ";
	    	  }
    	  }else{
    		  if (formObj.off_dis_op_2.checked == true){
	    		  tempStr += ",BKG_OFC_CD ";
	    		  tempCnt += ",CNT.BKG_OFC_CD ";
	    		  tempVal="BKG OFC";
	    		  tempSql=",'BKG OFC:' || BKG_OFC_CD ";
	    	  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.off_dis_op_3.checked == true){
	    		  tempStr += ",CORR_OFC_CD ";
	    		  tempCnt += ",CNT.CORR_OFC_CD ";
	    		  tempVal += ",C/A OFC";
	    		  tempSql += " || 'C/A OFC:' || CORR_OFC_CD ";
	    	  }
    	  }else{
    		  if (formObj.off_dis_op_3.checked == true){
	    		  tempStr += ",CORR_OFC_CD ";
	    		  tempCnt += ",CNT.CORR_OFC_CD ";
	    		  tempVal="C/A OFC";
	    		  tempSql=",'C/A OFC:' || CORR_OFC_CD ";
	    	  }
    	  }
    	  if (tempStr != ""){
    		  if (formObj.off_dis_op_4.checked == true){
	    		  tempStr += ",CTRT_OFC_CD ";
	    		  tempCnt += ",CNT.CTRT_OFC_CD ";
	    		  tempVal += ",Contract";
	    		  tempSql += " || 'Contract OFC:' || CTRT_OFC_CD ";
	    	  }
    	  }else{
    		  if (formObj.off_dis_op_4.checked == true){
	    		  tempStr += ",CTRT_OFC_CD ";
	    		  tempCnt += ",CNT.CTRT_OFC_CD ";
	    		  tempVal="Contract";
	    		  tempSql += ",'Contract OFC:' || CTRT_OFC_CD ";
	    	  }
    	  }  
    	  if (tempVal != ''){
    		  if (formObj.off_dis_op_5.checked == true){
	    		  tempVal += ",SUB OFC OF C/A ";
	    	  }
    	  }else{
    		  if (formObj.off_dis_op_5.checked == true){
	    		  tempVal += "SUB OFC OF C/A ";
	    	  }
    	  }
    	  if (tempVal != ''){
    		  if (formObj.off_dis_op_6.checked == true){
	    		  tempVal += ",SUB OFC OF DEL ";
	    	  }
    	  }else{
    		  if (formObj.off_dis_op_6.checked == true){
	    		  tempVal += "SUB OFC OF DEL ";
	    	  }
    	  }
    	  if (tempSql == ""){
    		  tempSql=",' '";
    	  }
    	  formObj.off_dis_op.value=tempStr;   	
    	  formObj.off_dis_op_val.value=tempVal;
    	  formObj.off_dis_op_sql.value=tempSql;
    	  formObj.off_dis_op_cnt.value=tempCnt;
    	  tempStr="";
    	  tempVal="";
    	  tempSql="";
    	  if (formObj.other_op_1.checked == true){
    		  tempStr=" AND CNT.CNT_HLG_C <> 0 ";
    		  tempVal="Include Carrier Haulage"; 
    	  }
    	  if (tempVal != ''){
    		  if (formObj.other_op_2.checked == true){
    			  tempStr += " AND CNT.CNT_HLG_M <> 0 ";
    			  tempVal += ",Include Merchant Haulage"; 
    		  }
    	  }else{
    		  if (formObj.other_op_2.checked == true){
    			  tempStr=" AND CNT.CNT_HLG_M <> 0 ";
    			  tempVal="Include Merchant Haulage";
    		  }
    	  }
    	  if (tempVal != ''){
    		  if (formObj.other_op_3.checked == true){
    			  tempStr += " AND CNT.CNT_EXEMPT <> 0 ";
    			  tempVal += ",Exempt"; 
    		  }
    	  }else{
    		  if (formObj.other_op_3.checked == true){
    			  tempStr=" AND CNT.CNT_EXEMPT <> 0 ";
    			  tempVal="Exempt";
    		  }
    	  }
    	  formObj.other_op.value=tempStr;
    	  formObj.other_op_val.value=tempVal;
    	  tempStr="";
    	  if (formObj.por.value != ''){
    		  tempStr += "POR:" + formObj.por.value;
    	  }else{
    		  tempStr += "POR:     ";
    	  }
    	  if (formObj.pol.value != ''){
    		  tempStr += ",POL:" + formObj.pol.value;
    	  }else{
    		  tempStr += ",POL:     ";
    	  } 
    	  if (formObj.pod.value != ''){
    		  tempStr += ",POD:" + formObj.pod.value;
    	  }else{
    		  tempStr += ",POD:     ";
    	  } 
    	  if (formObj.del.value != ''){
    		  tempStr += ",DEL:" + formObj.del.value;
    	  }else{
    		  tempStr += ",DEL:     ";
    	  } 
    	  formObj.route.value=tempStr;
    	  //CA ROUTE SETTING >>>>> END
      }
       /**
        * RD(Report Designer) Print
        */
        function goPrint(){		    			
        	var sheetObj=sheetObjects[1];
   	 	   	var formObj=document.form;
   	 	   	var rdPath="apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0822.mrd";
   	 	    var corr_from_dt=" CORR_FROM_DT[" + formObj.corr_from_dt.value + "] ";
   	 	    var corr_to_dt=" CORR_TO_DT[" + formObj.corr_to_dt.value + "] ";
   	 	    var bkg_from_dt=" BKG_FROM_DT[" + formObj.cre_from_dt.value + "] ";
   	 	    var bkg_to_dt=" BKG_TO_DT[" + formObj.cre_to_dt.value + "] ";
   	 	    var vvd=" VVD[" + formObj.vvd.value + "] ";
   	 	    var ca_reason=" CA_REASON[" + formObj.ca_reason_val.value + "] ";
   	 	    var ca_class=" CA_CLASS[" + formObj.ca_class_val.value + "] ";   	 	    
   	 	    var ca_kind=" CA_KIND[" + formObj.ca_kind_val.value + "] ";
   	 	    var ca_ofc=" CA_OFC[" + formObj.ca_issue_off.value + "] ";
   	 	    var bkg_ofc=" BKG_OFC[" + formObj.bkg_off.value + "] ";
   	 	    var del_ofc=" DEL_OFC[" + formObj.del_off.value + "] ";
   	 	    var ctrt_ofc=" CTRT_OFC[" + formObj.contract_off.value + "] ";
   	 	    var ca_staff=" CA_STAFF[" + formObj.ca_issue_staff.value + "] ";
   	 	    var dis_op=" DIS_OP[" + formObj.off_dis_op_val.value + "] ";
   	 	    var route=" ROUTE[" + formObj.route.value + "] ";
   	 	    var other_op=" OTHER_OP[" + formObj.other_op_val.value + "] ";
   	 	    var dis_op_sql=" DIS_OP_SQL[" + formObj.off_dis_op_sql.value + "] ";
   	 	    var dis_col=" DIS_COL[" + formObj.off_dis_op.value + "] ";
   	 	    var cnt_col=" CNT_COL[" + formObj.off_dis_op_cnt.value + "] ";
   	 	    var cnt_where=" CNT_WHERE[" + formObj.other_op.value + "] ";   	 	       	 	 
   	 	    var dis_where=" DIS_WHERE[";
   	 	    if (formObj.corr_from_dt.value != ''){
   	 	    	dis_where += " AND COR.CORR_DT BETWEEN TO_DATE('" + formObj.corr_from_dt.value + "' || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + formObj.corr_to_dt.value + "' || '23:59:59','YYYY-MM-DD HH24:MI:SS') ";    	 	    
   	 	    }
   	 	    if (formObj.cre_from_dt.value != ''){
	 	    	dis_where += " AND BKG.BKG_CRE_DT BETWEEN TO_DATE('" + formObj.cre_from_dt.value + "' || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + formObj.cre_to_dt.value + "' || '23:59:59','YYYY-MM-DD HH24:MI:SS') "; 	 	    	
	 	    }
   	 	    if (formObj.vvd.value != ''){
   	 	    	dis_where += " AND BKG.VSL_CD='" + formObj.vvd.value.substring(0,4) + "' ";
   	 	    	dis_where += " AND BKG.SKD_VOY_NO='" + formObj.vvd.value.substring(4,8) + "' ";
   	 	    	dis_where += " AND BKG.SKD_DIR_CD='" + formObj.vvd.value.substring(8) + "' ";
   	 	    }
   	 	    //CA REASON
   	 	    if (formObj.ca_reason.value != ''){
   	 	    	dis_where += " AND (" + formObj.ca_reason.value + ") \n";
   	 	    }
   	 	    //CA CLASS
   	 	    if (formObj.ca_class.value != ''){
   	 	    	dis_where += " AND (" + formObj.ca_class.value + ")  ";
   	 	    }
   	 	    //CA KIND
   	 	    if (formObj.ca_kind.value != ''){
   	 	    	dis_where += " AND (" + formObj.ca_kind.value + ")  ";
   	 	    }
   	 	    if (formObj.ca_issue_off.value != ''){
   	 	    	dis_where += " AND COR.CORR_OFC_CD='" + formObj.ca_issue_off.value + "'  ";
   	 	    }
   	 	    if (formObj.bkg_off.value != ''){
   	 	    	dis_where += " AND BKG.BKG_OFC_CD='" + formObj.bkg_off.value + "'  ";
   	 	    }
   	 	    if (formObj.del_off.value != ''){
   	 	    	dis_where += " AND BKG.IB_SLS_OFC_CD='" + formObj.del_off.value + "'  ";
   	 	    }
   	 	    if (formObj.contract_off.value != ''){
   	 	    	dis_where += " AND BKG.CTRT_OFC_CD='" + formObj.contract_off.value + "'  ";
   	 	    }
   	 	    if (formObj.ca_issue_staff.value != ''){
   	 	    	dis_where += " AND COR.CRE_USR_ID='" + formObj.ca_issue_staff.value + "'  ";
   	 	    }
   	 	    if (formObj.off_dis_op_5.checked == true){
   	 	    	dis_where += "  AND COR.CORR_OFC_CD IN (SELECT OFC_N8TH_LVL_CD  ";
   	 	        dis_where += "                            FROM DMT_OFC_LVL_V    ";
   	 	        dis_where += "                           WHERE '" + formObj.ca_issue_off.value + "' IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD,  ";
   	 	        dis_where += "                                                                          OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)  ";
   	 	    }
   	 	    if (formObj.off_dis_op_6.checked == true){
   	 	    	dis_where += " AND BKG.DEL_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE SLS_OFC_CD='" + formObj.del_off.value + "')  ";
   	 	    }
   	 	    if (formObj.por.value != ''){
   	 	    	dis_where += " AND BKG.POR_CD='" + formObj.por.value + "'  ";
   	 	    }
   	 	    if (formObj.pol.value != ''){
	 	    	dis_where += " AND BKG.POL_CD='" + formObj.pol.value + "'  ";
	 	    }
   	 	    if (formObj.pod.value != ''){
	 	    	dis_where += " AND BKG.POD_CD='" + formObj.pod.value + "'  ";
	 	    }
   	 	    if (formObj.del.value != ''){
	 	    	dis_where += " AND BKG.DEL_CD='" + formObj.del.value + "'  ";
	 	    }
   	 	    dis_where += "] ";   	 	       	 	    
   	 	    var cnt_where=" CNT_WHERE[" + formObj.other_op.value + "]  ";
   	 	    var where_tp=" WHERE_TP[";
   	 	    if (formObj.corr_from_dt.value != ''){
   	 	    	where_tp += " WHERE BKG.BKG_NO=COR.BKG_NO ";
	   	 	    where_tp += "   AND COR.CORR_NO <> '0000000001' ";
	   	 	    where_tp += "   AND COR.CORR_NO <> 'TMP0000001' ";
	   	 	    where_tp += "   AND COR.CORR_CXL_FLG='N' ";
	   	 	    where_tp += "   AND COR.CA_RSN_CD NOT IN ('F','E') ";
   	 	    }else{
   	 	    	where_tp += " WHERE BKG.BKG_NO=COR.BKG_NO(+) ";
   	 	    	where_tp += "   AND COR.CORR_NO(+) <> '0000000001' ";
   	 	    	where_tp += "   AND COR.CORR_NO(+) <> 'TMP0000001' ";
   	 	    	where_tp += "   AND COR.CORR_CXL_FLG(+)='N' ";
   	 	    	where_tp += "   AND COR.CA_RSN_CD(+) NOT IN ('F','E') ";
   	 	    	where_tp += "   AND BKG.BKG_STS_CD IN ('F','W','A') ";
   	 	    }
   	 	    formObj.com_mrdTitle.value="C/A Summary";
   	 	    formObj.com_mrdBodyTitle.value="C/A Summary";
   	 	   	formObj.com_mrdPath.value=rdPath;
   	 	   	formObj.com_mrdArguments.value="/rv " + corr_from_dt + corr_to_dt + bkg_from_dt + bkg_to_dt + vvd + ca_reason + ca_class + ca_kind + ca_ofc + bkg_ofc + del_ofc + ctrt_ofc + ca_staff + dis_op + route + other_op + dis_op_sql + dis_col + cnt_col + dis_where + cnt_where + where_tp;
   	 	   	ComOpenRDPopup();
        }
	  
        /**
         * 
         * @param viewType
         * @returns {Array}
         */
        function getRdData(viewType){
		  var rdData = [];
		  var sheetObj = sheetObjects[2];
		  var rdUrl = "apps/opus/esm/bkg/bookingcorrection/bdrcorrection/report/";
		  var rdFile = "ESM_BKG_0182.mrd";
		  var rdParams = [];
		  with (sheetObj) {
			  for (var i = HeaderRows(); i < HeaderRows() + RowCount(); i++) {
				  if(GetCellValue(i, "corr_no") != ""){
					  var rdParam = "/rp ['" + GetCellValue(i, "bkg_no") + "'] ['" + GetCellValue(i, "corr_no") + "']";
					  rdParams.push({'rdParam' : rdParam, 'rdUrl' : rdUrl, 'rdFile' : rdFile});
				  }
			  }
		  }
		  rdData.push(rdParams);
		  return rdData;
	  }