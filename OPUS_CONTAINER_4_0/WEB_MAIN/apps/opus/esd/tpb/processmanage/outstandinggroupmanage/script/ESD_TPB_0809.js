/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0809.js
*@FileTitle  : 3rd Party Target Selection 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0809 : business script for ESD_TPB_0809
     */
	var	trdPartyObj;
	if (!opener) 
	var	trdPartyObj=window.dialogArguments;
    if(!opener) trdPartyObj=parent;
	var s_div_cd=trdPartyObj.divCd;
	var s_trd_value=trdPartyObj.trdVal;
	/**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertItem( "Dry Index" , "");
				InsertItem( "Tanker Index" , "");
				InsertItem( "Time Charter" , "");
				InsertItem( "Bunker Price" , "");
				InsertItem( "Ship Price" , "");
				InsertItem( "FFA Index" , "");
//no support[check again]CLT 				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e.message);
		}
	}
	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	/**
  	 * Showing tab contents in case of clicking IBTab Object
  	 * ID of Grouped each tab DIV TAG defined "tabLayer"
  	 */
	function ChangeTab(tabObj,nItem){
		tabObj.SetBackColor("#FFFFFF");
//no support[check again]CLT 		tabObj.TabBackColor(nItem)="146,174,230";
		var objs=document.all.item("tabLayer");
		objs[beforetab].style.display="none";
		objs[nItem].style.display="Inline";
		//--------------- Notice --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//Not a click button in case of zIndex under 2
		objs[beforetab].style.zIndex=0;
		objs[nItem].style.zIndex=9;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	function loadPage() {
		document.form.s_vndr_cust_div_cd.onchange=s_vndr_cust_div_cd_OnChange;
		document.form.s_trd_party_val.onfocus=s_trd_party_val_OnFocus;
		//document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
		//document.form.s_trd_party_val.onblur=s_trd_party_val_OnBlur;
	}
	/* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	/* Event handler is branch processing by name of button */
	function processButtonClick(){
		try {
			var srcName=ComGetEvent("name");
			with(document.form) {
				switch(srcName) {
					case "btn_3rdParty":
						get3rdParty( document.all.s_vndr_cust_div_cd.value, false );
						break;
					case "btn_3rdParty_v":
						get3rdParty( "SP", false );
						break;
					case "btn_close":
						ComClosePopup(); 
					    break;
					case "btn_ok":
						trdPartyObj.divCd=document.all.s_vndr_cust_div_cd.value;
						trdPartyObj.trdVal=document.all.s_trd_party_val.value;
						window.returnValue=trdPartyObj;
						if(parent) {							
							var _func_name = parent.document.form.calllback;
							if(_func_name == undefined){
								_func_name = "callback0809";
							} else {
								_func_name = _func_name.value;
							}
							eval('parent.'+_func_name+'("'+trdPartyObj.divCd+'", "'+trdPartyObj.trdVal+'")');							
						}
						ComClosePopup(); 
						break;
				} // end switch
			}// end with
		}catch(e) {	
			alert(e);
		}
	}
	/* Finishing work */
