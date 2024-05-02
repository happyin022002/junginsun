/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_SPC_0115.js
 *@FileTitle : Constraint Mastertable
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.23
 *@LastModifier :
 *@LastVersion : 1.0
 * 2015.01.23 Seung-Man KIM
 * 1.0 Creation
 * Trunk Type�� NYCRA�뿉�꽌留� �궗�슜�븯�룄濡� 蹂�寃�
 * sheet�닚�꽌 蹂�寃�(SHARC/SINRS 留� �븵�쑝濡�)
* 2015.07.06 [CHM-201536749]Mastertable Import湲곕뒫 �삤瑜� �닔�젙 CR�뿉 諛섏쁺(Revenue Management System 異붽� 蹂댁셿 媛쒕컻 �슂泥� �꽑諛섏쁺)    
* 2015.12.28CHM-201539312 : [Develop] Mastertable 移쇰읆 異붽� �슂泥�
* 2017.07.19 [CSR #1477] Threshold (BOX) 컬럼 추가
=========================================================*/
/****************************************************************************************
 �씠踰ㅽ듃 援щ텇 肄붾뱶: [珥덇린�솕]INIT=0; [�엯�젰]ADD=1; [議고쉶]SEARCH=2; [由ъ뒪�듃議고쉶]SEARCHLIST=3;
 [�닔�젙]MODIFY=4; [�궘�젣]REMOVE=5; [由ъ뒪�듃�궘�젣]REMOVELIST=6 [�떎以묒쿂由�]MULTI=7
 湲고� �뿬遺꾩쓽 臾몄옄�긽�닔  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------�떎�쓬 肄붾뱶�뒗 JSDoc�쓣 �옒 留뚮뱾湲� �쐞�빐�꽌 異붽��맂 肄붾뱶�엫 ------------------*/
/**
 * @fileoverview �뾽臾댁뿉�꽌 怨듯넻�쑝濡� �궗�슜�븯�뒗 �옄諛붿뒪�겕由쏀듃�뙆�씪濡� �떖�젰 愿��젴 �븿�닔媛� �젙�쓽�릺�뼱 �엳�떎.
 * @author �븳吏꾪빐�슫
 */
/**
 * @extends
 * @class ESM_SPC_0115 : ESM_SPC_0115 �깮�꽦�쓣 �쐞�븳 �솕硫댁뿉�꽌 �궗�슜�븯�뒗 �뾽臾� �뒪�겕由쏀듃瑜� �젙�쓽�븳�떎.
 */
function ESM_SPC_0115() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}
/* 媛쒕컻�옄 �옉�뾽	*/
// 怨듯넻�쟾�뿭蹂��닔
var sheetObjects = new Array();
var sheetCnt = 0;
var comObjects = new Array();
var comboCnt = 0;
var reportFormPopupCallCnt = 0;
//tab
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 0;
//理쒖큹 Allocation Type瑜� 遺덈윭�삩 �썑 ���옣 �븷 蹂��닔
var typeListXml = new Array();
var groupCmdtListXml = new Array();
//Delete�떆 Validation�쓣 �쐞�븳 HeadCount 蹂��닔�� SelRow蹂��닔
var delSelRow = "";
var delHeadCount = "";
var delStat = "";
// 媛곹꺆�뿉 �떆�듃 �닔�젙 flag
var tabShtFlag = new Array();
// 踰꾪듉�겢由��씠踰ㅽ듃瑜� 諛쏆븘 泥섎━�븯�뒗 �씠踰ㅽ듃�빖�뱾�윭 �젙�쓽 */
document.onclick = processButtonClick;
// 踰꾪듉 �꽕�엫�쑝濡� 援щ텇�븯�뿬 �봽濡쒖꽭�뒪瑜� 遺꾧린泥섎━�븯�뒗 �씠踰ㅽ듃�빖�뱾�윭 */
function processButtonClick() {
	/***** �꺆�떦 �떆�듃媛� 2媛� �씠�긽�씤 寃쎌슦�뿏 異붽� �떆�듃蹂��닔 吏��젙�븯�뿬 �궗�슜�븳 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
			//tab 愿��젴 異붽�
			for ( var i = 0; i < tab_retrives.length; i++) {
				tab_retrives[i] = false;
			}
			//ComOpenWait(true);		
			if (tabShtFlag[beforetab] == 'Y' && formObject.screenName.value == 'ESM_SPC_0115' && confirm(getMsg("SPC10254"))) {
				doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
			} else {
				doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
			}
				
			break;
		case "btn_save":
			for ( var i = 0; i < tab_retrives.length; i++) {
				tab_retrives[i] = false;
			}
			doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
			break;
		case "btn_rowadd":
			for ( var i = 0; i < tab_retrives.length; i++) {
				tab_retrives[i] = false;
			}
			doActionIBSheet(sheetObjects[beforetab], formObject, IBINSERT);
			break;
		case "btn_rowdel":
			for ( var i = 0; i < tab_retrives.length; i++) {
				tab_retrives[i] = false;
			}
			if (sheetObjects[beforetab].LastRow == "1") {
				//�븘臾닿쾬�룄 �뾾�뒗 �긽�깭�뿉�꽌 �궘�젣瑜� �떆�룄�븷 寃쎌슦 ���긽�씠 �뾾�쓬�쓣 �븣由곕떎.
				ComShowMessage(getMsg("SPC13055"));
			} else if (!validateForm(sheetObjects[beforetab], formObject, IBDELETE) && delStat == "0") {
				//insert留� �븯怨� 諛붾줈吏��슱 寃쎌슦 寃쎄퀬�뾾�씠 吏��슫�떎.
				sheetObjects[beforetab].RowDelete(delSelRow, false);
			} else if (!validateForm(sheetObjects[beforetab], formObject, IBDELETE) && delStat == "1") {
				//�듅�젙 Raw瑜� 異붽��썑 �젙蹂대�� �엯�젰�븯怨� ���옣�븯吏� �븡怨� 吏��슱寃쎌슦 Confirm�쓣 �븳�떎..
				sheetObjects[beforetab].RowDelete(delSelRow, true);
			} else if (validateForm(sheetObjects[beforetab], formObject, IBDELETE)) {
				//�씪諛섏쟻�쑝濡� data瑜� 吏��슱寃쎌슦 蹂�寃쎌궗�빆�씠 �엳�쓣 寃쎌슦 蹂�寃쎌궗�빆�뿉 ���븳 ���옣�뿬遺�瑜� 臾쇱뼱蹂닿퀬 �궘�젣�뿬遺�瑜� 臾쇱뼱蹂몃떎.
				if (confirm(getMsg("SPC10535"))) {
					doActionIBSheet(sheetObjects[beforetab], formObject, IBDELETE);
				}
			}
			break;
		case "btn_copy":
			for ( var i = 0; i < tab_retrives.length; i++) {
				tab_retrives[i] = false;
			}
			doActionIBSheet(sheetObjects[beforetab], formObject, IBCOPYROW);
			break;
		case "btn_excel":
			for ( var i = 0; i < tab_retrives.length; i++) {
				tab_retrives[i] = false;
			}
			sheetObjects[beforetab].SpeedDown2Excel(-1);
			break;
		case "btn_import":
			var popup = ComOpenWindow2('ESM_SPC_0117.do', '', 'width=900, height=600px, menubar=0, status=1, scrollbars=0, resizable=1');
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
		ComOpenWait(false);			
	}
}
/**
 * IBSheet Object瑜� 諛곗뿴濡� �벑濡� <br>
 * �뼢�썑 �떎瑜� �빆紐⑸뱾�쓣 �씪愿꾩쿂由ы븷 �븘�슂媛� �엳�쓣 �븣 諛곗뿴濡� �떞�뒗 �봽濡쒖꽭�뒪瑜� 異붽��븷 �닔 �엳�떎 <br>
 * 諛곗뿴�� �냼�뒪 �긽�떒�뿉 �젙�쓽 <br>
 * @param {ibsheet} sheet_obj �븘�닔 IBSheet Object
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * 肄ㅻ낫 珥덇린�꽕�젙媛�
 * @param {ibsheet} sheet_obj �븘�닔 IBSheet Object
 * @param {form} formObj �븘�닔 html form object
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function initComboSetVal(sheetObj, formObj) {
	formObj.f_cmd.value = SEARCH01;
	var sXml = sheetObj.GetSearchXml("ESM_SPC_0115GS.do", FormQueryString(formObj));
	var arrXml = sXml.split("|$$|");
	//Row Add瑜� �쐞�븯�뿬 typeListXml[0]�뿉 議고쉶 寃곌낵瑜� ���옣�빐 �몦�떎.
	typeListXml[0] = arrXml[0];
	ComXml2ComboItem(arrXml[0], formObj.bkg_aloc_tp_cd, "cd", "nm");
	formObj.bkg_aloc_tp_cd.InsertItem(0, "ALL", "ALL");
	formObj.bkg_aloc_tp_cd.Index = 0;
	formObj.bkg_aloc_tp_cd.DropHeight = 150;
	formObj.bkg_aloc_tp_cd.UseAutoComplete = true;
	formObj.f_cmd.value = SEARCH04;
	var sXml2 = sheetObj.GetSearchXml("ESM_SPC_0115GS.do", FormQueryString(formObj));
	var arrXml2 = sXml2.split("|$$|");
	//groupCmdtListXml[0] = arrXml2[0];
	ComSetIBCombo(sheetObjects[3],arrXml2[0], "scg_grp_cmdt_seq", true, 0, "", "", true);
	
	//ComSetIBCombo(sheetObjects[1],typeListXml[0],"bkg_aloc_tp_cd",true,0);//SHARC
	//ComSetIBCombo(sheetObjects[2],typeListXml[0],"bkg_aloc_tp_cd",true,0);//SINRS
	//ComSetIBCombo(sheetObjects[3],typeListXml[0],"bkg_aloc_tp_cd",true,0);//NYCRA
	//ComSetIBCombo(sheetObjects[4],typeListXml[0],"bkg_aloc_tp_cd",true,0);//HAMRU
	
}
/**
 * IBSheet Object瑜� 諛곗뿴濡� �벑濡�
 * �뼢�썑 �떎瑜� �빆紐⑸뱾�쓣 �씪愿꾩쿂由ы븷 �븘�슂媛� �엳�쓣 �븣 諛곗뿴濡� �떞�뒗 �봽濡쒖꽭�뒪瑜� 異붽��븷 �닔 �엳�떎
 * 諛곗뿴�� �냼�뒪 �긽�떒�뿉 �젙�쓽
 */
function setComboObject(combo_obj) {
	comObjects[comboCnt++] = combo_obj;
}
/**
 * Sheet 湲곕낯 �꽕�젙 諛� 珥덇린�솕 <br>
 * body �깭洹몄쓽 onLoad �씠踰ㅽ듃�빖�뱾�윭 援ы쁽 <br>
 * �솕硫댁쓣 釉뚮씪�슦���뿉�꽌 濡쒕뵫�븳 �썑�뿉 �꽑泥섎━�빐�빞 �븯�뒗 湲곕뒫�쓣 異붽��븳�떎. <br>
 * <br><b>Example :</b>
 * <pre>
 *     loadPage();
 * </pre>
 * @return �뾾�쓬
 * @author Seung-Man KIM 
 * @version 2015.01.23
 */
function loadPage() {
	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		//			initSheet(sheetObjects[i],i+1);
		tab_retrives = new Array(sheetObjects.length);
		if (i > 0) {
			tdisp = tabLayer[i - 1].style.display;
			tabLayer[i - 1].style.display = "block";
		}
		initSheet(sheetObjects[i], i + 1);
		if (i > 0) {
			tabLayer[i - 1].style.display = tdisp;
		}
		ComEndConfigSheet(sheetObjects[i]);
	}
	document.form.tab_rhq_cd.value = 'SHARC/SINRS';
	for ( var k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	SpcSearchOptionTrade("trade", true, true);
	SpcSearchOptionSubTrade("subtrade", true, true);
	SpcSearchOptionLane("lane");
	SpcSearchOptionBound("bound", false, true, false);
	initComboSetVal(sheetObjects[3], document.form);
	//議고쉶�떆 IBShhet�쓽 肄ㅻ낫�뿉 肄붾뱶媛믪씠 �븘�땶 Name�쑝濡� 蹂댁씠湲� �쐞�빐 肄ㅻ낫瑜쇱꽕�젙�븳�떎
	// add listener
	axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form'); //�뿏�꽣�궎 議고쉶 �씠踰ㅽ듃泥섎━
}
/**
 * IBTab Object瑜� 諛곗뿴濡� �벑濡�
 * �뼢�썑 �떎瑜� �빆紐⑸뱾�쓣 �씪愿꾩쿂由ы븷 �븘�슂媛� �엳�쓣 �븣 諛곗뿴濡� �떞�뒗 �봽濡쒖꽭�뒪瑜� 異붽��븷 �닔 �엳�떎
 * 諛곗뿴�� �냼�뒪 �긽�떒�뿉 �젙�쓽
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}
/**
 * Tab 湲곕낯 �꽕�젙
 * �꺆�쓽 �빆紐⑹쓣 �꽕�젙�븳�떎.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "SHARC/SINRS", -1);
			InsertTab(cnt++, "SHARC ", -1);
			InsertTab(cnt++, "SINRS ", -1);
			InsertTab(cnt++, "NYCRA ", -1);
			InsertTab(cnt++, "HAMRU", -1);
		}
		break;
	}
}
/**
 * Tab �겢由��떆 �씠踰ㅽ듃 愿��젴
 * �꽑�깮�븳 �꺆�쓽 �슂�냼媛� �솢�꽦�솕 �맂�떎.
 */
function tab1_OnChange(tabObj, nItem) {
	var formObject = document.form;
	var objs = document.all.item("tabLayer");
	for ( var i = 0; i < objs.length; i++) {
		objs[i].style.display = "none";
	}
	objs[nItem].style.display = "Inline";
	beforetab = nItem;
	//媛� �꺆 �꽑�깮�떆 rhq_cd �떞湲�
	if (nItem == "0") {
		document.form.tab_rhq_cd.value = 'SHARC/SINRS';
	} else if (nItem == "1") {
		document.form.tab_rhq_cd.value = 'SHARC';
	} else if (nItem == "2") {
		document.form.tab_rhq_cd.value = 'SINRS';
	} else if (nItem == "3") {
		document.form.tab_rhq_cd.value = 'NYCRA';
	} else if (nItem == "4") {
		document.form.tab_rhq_cd.value = 'HAMRU';
	}
}
/**
 * �떆�듃 珥덇린�꽕�젙媛�, �뿤�뜑 �젙�쓽 <br>
 * �떆�듃媛� �떎�닔�씪 寃쎌슦 �떆�듃 �닔留뚰겮 case瑜� 異붽��븯�뿬 �떆�듃 珥덇린�솕紐⑤뱢�쓣 援ъ꽦�븳�떎 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @param {int} sheetNo �븘�닔 IBSheet Object �깭洹몄쓽 �븘�씠�뵒�뿉 遺숈씤 �씪�젴踰덊샇
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 SHARC/SIWA
		with (sheetObj) {
			// �넂�씠 �꽕�젙
			style.height = 410;
			//�쟾泥� �꼫鍮� �꽕�젙
			SheetWidth = mainTable.clientWidth;
			//Host�젙蹂� �꽕�젙[�븘�닔][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//�쟾泥퀾erge 醫낅쪟 [�꽑�깮, Default msNone]
			MergeSheet = msHeaderOnly + msPrevColumnMerge;
			//�쟾泥퀲dit �뿀�슜 �뿬遺� [�꽑�깮, Default false]
			
			Editable = true;
			//�뻾�젙蹂댁꽕�젙[�븘�닔][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 2, 2, 100);
			// �빐�뜑�뿉�꽌 泥섎━�븷 �닔 �엳�뒗 媛곸쥌 湲곕뒫�쓣 �꽕�젙�븳�떎
			InitHeadMode(true, true, false, true, false, false);
			var HeadTitle1 = "|Seq|RHQ|TYPE|Sub Trade|T.LANE|HAUL\nBOUND|BD|Trunk|Trunk|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POL/NODE|POL/NODE|POL/NODE|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|POD/NODE|POD/NODE|POD/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE|US Mode|VVD|CNTR\nTYPE|DG/RD|L.OFC|S/C No.|S/C Nm|RFA No.|RFA Nm|BCO/NVO|RFA\nType|G.Cust ID|G.Cust Nm|C. Cust Code|Cust Nm|Actual\nCustomer|BKG\nShipper Code|Shipper Nm||Charge\nOFT||CMPB|CMPB|Weight|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|Group COMMODITY|Group COMMODITY|COMMODITY|COMMODITY|Stowage|Apply WK|Apply WK|SVC|Control Type|REMARK|ALOC APLY\nFM DT|ALOC APLY\nTO DT|UseYN|Update User|Update Date|ALOC_SEQ|SHARC_SEQ|SINRS_SEQ|Cmpb only";
			var HeadTitle2 = "|Seq|RHQ|TYPE|Sub Trade|T.LANE|HAUL\nBOUND|BD|POL|POD|Country|LOC|NODE\n(LOC+00)|SCC|Country|LOC|NODE\n(LOC+00)|T/S port|LANE|BD|POL\n Country|POL|POL NODE\n(LOC+00)|POD\n Country|POD|POD NODE\n(LOC+00)|Country|LOC|NODE\n(LOC+00)|Country|LOC|NODE\n(LOC+00)|SCC|US Mode|VVD|CNTR\nTYPE|DG/RD|L.OFC|S/C No.|S/C Nm|RFA No.|RFA Nm|BCO/NVO|RFA\nType|G.Cust ID|G.Cust Nm|C. Cust Code|Cust Nm|Actual\nCustomer|BKG\nShipper Code|Shipper Nm||Charge\nOFT||Amount\n(USD)|Per Ton|Per TEU|oldteu|TEU|oldBox|BOX|oldwgt|WGT|oldteu|TEU|oldBox|BOX|oldwgt|WGT|CODE|NAME|CODE|NAME|Stowage|From|To|SVC|Control Type|REMARK|ALOC APLY\nFM DT|ALOC APLY\nTO DT|UseYN|Update User|Update Date|ALOC_SEQ|SHARC_SEQ|SINRS_SEQ|Cmpb only";
			var headCount = ComCountHeadTitle(HeadTitle2);
			delHeadCount = headCount;
			//而щ읆�젙蹂댁꽕�젙[�븘�닔][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			//�빐�뜑�뻾�젙蹂�[�븘�닔][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			FrozenCols = 8;
			var cnt2 = 0;
			//�뜲�씠�꽣�냽�꽦    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 20, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "seq", true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "sls_rhq_cd", false, "", dfNone, 0, false, false, 12); //異붽�
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true, "bkg_aloc_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "sub_trd_cd", false, "", dfNone, 0, true, true, 2); //異붽�
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trnk_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "hul_bnd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trnk_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "trunk_pol_cd", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "trunk_pod_cd", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_por_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "por_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "por_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_por_scc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_pol_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pol_nod_cd", false, "", dfNone, 0, true, true, 7);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "n1st_ts_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "n1st_ts_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "n1st_ts_pol_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "n1st_ts_pol_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_pol_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "n1st_ts_pod_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "n1st_ts_pod_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_pod_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_pod_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "pod_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pod_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_del_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "del_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "del_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_del_scc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "usa_bkg_mod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vvd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "dg_rd", false, "", dfNone, 0, true, true, 3); //異붽�
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "ob_sls_ofc_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sc_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "sc_nm", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rfa_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "rfa_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "acct_tp", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "rfa_ctrt_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cust_grp_id", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cust_grp_nm", false, "", dfNone, 0, false, true, 20);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "ctrt_cust_cnt_cd", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "ctrt_cust_cnt_nm", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtPopup, 90, daCenter, true, "agmt_act_cnt_cd", false, "", dfNone, 0, true, true, 450);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cust_cnt_cd", false, "", dfNone, 0, true, true, 8);//異붽�
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "cust_cnt_nm", false, "", dfNone, 0, true, true, 8);//異붽�
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "old_oft_chg_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "oft_chg_amt", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_cmpb_amt", false, "", dfNullFloat, 0, false, false, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "cmpb_amt", false, "", dfNullFloat, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "cmpb_per_wgt", false, "", dfNone, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "wgt_per_teu", false, "", dfNone, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_aloc_lod_qty", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "aloc_lod_qty", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_op_cntr_qty", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_asgn_ttl_wgt", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "asgn_ttl_wgt", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_aloc_lod_qty_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "aloc_lod_qty_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_op_cntr_qty_rto", false, "", dfNullFloat, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 60, daRight, true, "op_cntr_qty_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_asgn_wgt_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "asgn_wgt_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "scg_grp_cmdt_seq", false, "", dfNone, 0, true, true, 6);//�닲源� dtCombo
			InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "scg_grp_cmdt_desc", false, "", dfNone, 0, false, false, 300);//�닲源�
//			InitDataProperty(0, cnt++, dtPopup, 90, daCenter, true, "cmdt_cd", false, "", dfNone, 0, true, true, 450);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cmdt_cd", false, "", dfNone, 0, true, true, 6);			
			InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false, false, 300);
			
			//2017.06.29 로켓배송 Stowage 추가 (송민석)
	         InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "stwg_cd", false, "", dfNone, 0, true, true, 5);

			
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "aply_fm_yrwk", false, "", dfUserFormat, 0, true, true, 6, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "aply_to_yrwk", false, "", dfUserFormat, 0, true, true, 6, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "aloc_svc_cd", false, "", dfNone, 0, true, true, 1);//�닲源�
			InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "bkg_ctrl_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "bkg_aloc_rmk", false, "", dfNone, 0, true, true, 4000);
			InitDataProperty(0, cnt++, dtPopupEdit, 90, daCenter, true, "aloc_aply_fm_dt", false, "", dfDateYmd, 0, true, true, 30);
			InitDataProperty(0, cnt++, dtPopupEdit, 90, daCenter, true, "aloc_aply_to_dt", false, "", dfDateYmd, 0, true, true, 30);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, true, "aloc_use_flg", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false); //�닲源�
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "upd_dt", false, "", dfNone, 0, false, false); //�닲源�
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "bkg_aloc_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "shaas_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "sinwa_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "cmpb_ony_flg", false, "", dfNone, 0, true, true);//�닲源�
			InitDataCombo(0, "aloc_svc_cd", "Auto|Manual", "A|M");
			InitDataCombo(0, "bkg_ctrl_tp_cd", "Standby|Attention", "S|A");
			InitDataCombo(0, "aloc_use_flg", "YES|NO", "Y|N");
			InitDataCombo(0, "dg_rd", " |DG|RD", " |dg|rd");
			InitDataCombo(0, "bkg_aloc_tp_cd", " |Free|Trunk|T/S|Customer|EQ|Commodity|Almighty", " |F|T|S|C|E|M|A");
			InitDataCombo(0, "usa_bkg_mod_cd", " |IPI|Local|Others", " |IPI|LOCAL|OTH");
			InitUserFormat(0, "aply_fm_yrwk", "####-##", "-");
			InitUserFormat(0, "aply_to_yrwk", "####-##", "-");
			InitDataCombo(0, "hul_bnd_cd", " |HH|BH", " |HH|BH");
			InitDataCombo(0, "acct_tp", " |BCO|NVO", " |B|N");
			InitDataCombo(0, "rfa_ctrt_tp_cd", " |Contract|SPOT", " |C|S");
			
			InitDataValid(0, "oft_chg_amt", vtNumericOnly);
			InitDataValid(0, "cmpb_per_wgt", vtNumericOnly); 
			InitDataValid(0, "wgt_per_teu", vtNumericOnly); 
			InitDataValid(0, "cmdt_cd", vtNumericOnly);
			var cnt2 = 0;
			//�뜲�씠�꽣�냽�꽦    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(1, cnt2++, dtHiddenStatus, 20, daCenter, true, "ibflag");
			InitDataProperty(1, cnt2++, dtSeq, 50, daCenter, true, "seq", true, "", dfNone, 0, false, true);
			InitDataProperty(1, cnt2++, dtData, 50, daCenter, true, "sls_rhq_cd", false, "", dfNone, 0, false, false, 12); //異붽�
			InitDataProperty(1, cnt2++, dtCombo, 80, daCenter, true, "bkg_aloc_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(1, cnt2++, dtData, 70, daCenter, true, "sub_trd_cd", false, "", dfNone, 0, true, true, 2); //異붽�
			InitDataProperty(1, cnt2++, dtData, 50, daCenter, true, "trnk_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(1, cnt2++, dtCombo, 50, daCenter, true, "hul_bnd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(1, cnt2++, dtData, 50, daCenter, true, "trnk_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(1, cnt2++, dtPopup, 100, daCenter, true, "trunk_pol_cd", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(1, cnt2++, dtPopup, 100, daCenter, true, "trunk_pod_cd", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(1, cnt2++, dtPopup, 55, daCenter, true, "bkg_por_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtPopup, 55, daCenter, true, "por_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtData, 70, daCenter, true, "por_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(1, cnt2++, dtData, 70, daCenter, true, "bkg_por_scc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtPopup, 55, daCenter, true, "bkg_pol_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtPopup, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtData, 70, daCenter, true, "pol_nod_cd", false, "", dfNone, 0, true, true, 7);

			InitDataProperty(1, cnt2++, dtPopup, 100, daCenter, true, "ts_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			InitDataProperty(1, cnt2++, dtData, 55, daCenter, true, "n1st_ts_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(1, cnt2++, dtData, 55, daCenter, true, "n1st_ts_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(1, cnt2++, dtPopup, 60, daCenter, true, "n1st_ts_pol_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(1, cnt2++, dtPopup, 100, daCenter, true, "n1st_ts_pol_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(1, cnt2++, dtPopup, 100, daCenter, true, "ts_pol_nod_cd", false, "", dfNone, 0, true, true, 200);			
			
			InitDataProperty(1, cnt2++, dtPopup, 60, daCenter, true, "n1st_ts_pod_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(1, cnt2++, dtPopup, 100, daCenter, true, "n1st_ts_pod_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(1, cnt2++, dtPopup, 100, daCenter, true, "ts_pod_nod_cd", false, "", dfNone, 0, true, true, 200);
						
			InitDataProperty(1, cnt2++, dtPopup, 55, daCenter, true, "bkg_pod_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtPopup, 60, daCenter, true, "pod_cd", false, "", dfNone, 0, true, true, 5);			
			InitDataProperty(1, cnt2++, dtData, 70, daCenter, true, "pod_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(1, cnt2++, dtPopup, 55, daCenter, true, "bkg_del_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtPopup, 60, daCenter, true, "del_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtData, 70, daCenter, true, "del_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(1, cnt2++, dtData, 70, daCenter, true, "bkg_del_scc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(1, cnt2++, dtCombo, 60, daCenter, true, "usa_bkg_mod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(1, cnt2++, dtData, 80, daCenter, true, "vvd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(1, cnt2++, dtPopup, 60, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(1, cnt2++, dtCombo, 60, daCenter, true, "dg_rd", false, "", dfNone, 0, true, true, 3); //異붽�
			InitDataProperty(1, cnt2++, dtData, 55, daCenter, true, "ob_sls_ofc_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(1, cnt2++, dtData, 80, daCenter, true, "sc_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(1, cnt2++, dtData, 80, daLeft, true, "sc_nm", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(1, cnt2++, dtData, 80, daCenter, true, "rfa_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(1, cnt2++, dtData, 100, daLeft, true, "rfa_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(1, cnt2++, dtCombo, 55, daCenter, true, "acct_tp", false, "", dfNone, 0, false, true);
			InitDataProperty(1, cnt2++, dtCombo, 60, daCenter, true, "rfa_ctrt_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(1, cnt2++, dtData, 90, daCenter, true, "cust_grp_id", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(1, cnt2++, dtData, 90, daLeft, true, "cust_grp_nm", false, "", dfNone, 0, false, true, 20);
			InitDataProperty(1, cnt2++, dtData, 90, daCenter, true, "ctrt_cust_cnt_cd", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(1, cnt2++, dtData, 90, daLeft, true, "ctrt_cust_cnt_nm", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(1, cnt2++, dtPopup, 90, daCenter, true, "agmt_act_cnt_cd", false, "", dfNone, 0, true, true, 450);
			InitDataProperty(1, cnt2++, dtData, 90, daCenter, true, "cust_cnt_cd", false, "", dfNone, 0, true, true, 8);//異붽�
			InitDataProperty(1, cnt2++, dtData, 90, daLeft, true, "cust_cnt_nm", false, "", dfNone, 0, true, true, 8);//異붽�
			InitDataProperty(1, cnt2++, dtHidden, 60, daCenter, true, "old_oft_chg_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(1, cnt2++, dtData, 60, daCenter, true, "oft_chg_amt", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(1, cnt2++, dtHidden, 60, daRight, true, "old_cmpb_amt", false, "", dfNullFloat, 0, false, false, 6);//異붽�
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "cmpb_amt", false, "", dfNullFloat, 0, true, true, 6);//異붽�
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "cmpb_per_wgt", false, "", dfNone, 0, true, true, 6);//異붽�
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "wgt_per_teu", false, "", dfNone, 0, true, true, 6);//異붽�
			InitDataProperty(1, cnt2++, dtHidden, 60, daRight, true, "old_aloc_lod_qty", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "aloc_lod_qty", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(1, cnt2++, dtHidden, 60, daRight, true, "old_op_cntr_qty", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(1, cnt2++, dtHidden, 60, daRight, true, "old_asgn_ttl_wgt", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "asgn_ttl_wgt", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(1, cnt2++, dtHidden, 60, daRight, true, "old_aloc_lod_qty_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "aloc_lod_qty_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(1, cnt2++, dtHidden, 60, daRight, true, "old_op_cntr_qty_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "op_cntr_qty_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(1, cnt2++, dtHidden, 60, daRight, true, "old_asgn_wgt_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(1, cnt2++, dtData, 60, daRight, true, "asgn_wgt_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(1, cnt2++, dtHidden, 60, daCenter, true, "scg_grp_cmdt_seq", false, "", dfNone, 0, true, true, 6);//�닲源� dtCombo
			InitDataProperty(1, cnt2++, dtHidden, 100, daLeft, true, "scg_grp_cmdt_desc", false, "", dfNone, 0, false, false, 300);//�닲源�
			//InitDataProperty(1, cnt2++, dtPopup, 90, daCenter, true, "cmdt_cd", false, "", dfNone, 0, true, true, 450);
			InitDataProperty(1, cnt2++, dtData, 60, daCenter, true, "cmdt_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(1, cnt2++, dtData, 120, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false, false, 300);

	         //2017.06.29 로켓배송 Stowage 추가 (송민석)
            InitDataProperty(1, cnt2++, dtPopup, 100, daCenter, true, "stwg_cd", false, "", dfNone, 0, true, true, 5);

			
			InitDataProperty(1, cnt2++, dtData, 60, daCenter, true, "aply_fm_yrwk", false, "", dfUserFormat, 0, true, true, 6, true);
			InitDataProperty(1, cnt2++, dtData, 60, daCenter, true, "aply_to_yrwk", false, "", dfUserFormat, 0, true, true, 6, true);
			InitDataProperty(1, cnt2++, dtHidden, 60, daCenter, true, "aloc_svc_cd", false, "", dfNone, 0, true, true, 1);//�닲源�
			InitDataProperty(1, cnt2++, dtCombo, 100, daCenter, true, "bkg_ctrl_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(1, cnt2++, dtData, 150, daLeft, true, "bkg_aloc_rmk", false, "", dfNone, 0, true, true, 4000);
			InitDataProperty(1, cnt2++, dtPopupEdit, 90, daCenter, true, "aloc_aply_fm_dt", false, "", dfDateYmd, 0, true, true, 30);
			InitDataProperty(1, cnt2++, dtPopupEdit, 90, daCenter, true, "aloc_aply_to_dt", false, "", dfDateYmd, 0, true, true, 30);
			InitDataProperty(1, cnt2++, dtCombo, 40, daCenter, true, "aloc_use_flg", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(1, cnt2++, dtData, 80, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false); //�닲源�
			InitDataProperty(1, cnt2++, dtData, 100, daCenter, true, "upd_dt", false, "", dfNone, 0, false, false); //�닲源�
			InitDataProperty(1, cnt2++, dtHidden, 30, daCenter, true, "bkg_aloc_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(1, cnt2++, dtHidden, 30, daCenter, true, "shaas_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(1, cnt2++, dtHidden, 30, daCenter, true, "sinwa_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(1, cnt2++, dtHidden, 30, daCenter, true, "cmpb_ony_flg", false, "", dfNone, 0, true, true);//�닲源�
			InitDataCombo(1, "aloc_svc_cd", "Auto|Manual", "A|M");
			InitDataCombo(1, "bkg_ctrl_tp_cd", "Standby|Attention", "S|A");
			InitDataCombo(1, "aloc_use_flg", "YES|NO", "Y|N");
			InitDataCombo(1, "dg_rd", " |DG|RD", " |dg|rd");
			InitDataCombo(1, "bkg_aloc_tp_cd", " |Free|Trunk|T/S|Customer|EQ|Commodity|Almighty", " |F|T|S|C|E|M|A");
			InitDataCombo(1, "usa_bkg_mod_cd", " |IPI|Local|Others", " |IPI|LOCAL|OTH");
			InitUserFormat(1, "aply_fm_yrwk", "####-##", "-");
			InitUserFormat(1, "aply_to_yrwk", "####-##", "-");
			InitDataCombo(1, "hul_bnd_cd", " |HH|BH", " |HH|BH");
			InitDataCombo(1, "acct_tp", " |BCO|NVO", " |B|N");
			InitDataCombo(1, "rfa_ctrt_tp_cd", " |Contract|SPOT", " |C|S");
			InitDataValid(1, "oft_chg_amt", vtNumericOnly); 
			InitDataValid(1, "cmpb_per_wgt", vtNumericOnly); 
			InitDataValid(1, "wgt_per_teu", vtNumericOnly); 
			InitDataValid(1, "cmdt_cd", vtNumericOnly);
			ColHidden("aloc_aply_fm_dt") = true;
			ColHidden("aloc_aply_to_dt") = true;
		}
		break;
	case "sheet2":
	case "sheet3":
	case "sheet5":
		with (sheetObj) {
			// �넂�씠 �꽕�젙
			style.height = 410;
			//�쟾泥� �꼫鍮� �꽕�젙
			SheetWidth = mainTable.clientWidth;
			//Host�젙蹂� �꽕�젙[�븘�닔][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//�쟾泥퀾erge 醫낅쪟 [�꽑�깮, Default msNone]
			MergeSheet = msHeaderOnly;
			//�쟾泥퀲dit �뿀�슜 �뿬遺� [�꽑�깮, Default false]
			Editable = true;
			//�뻾�젙蹂댁꽕�젙[�븘�닔][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 100);
			// �빐�뜑�뿉�꽌 泥섎━�븷 �닔 �엳�뒗 媛곸쥌 湲곕뒫�쓣 �꽕�젙�븳�떎
			InitHeadMode(true, true, false, true, false, false);
			var HeadTitle1 = "|Seq|RHQ|TYPE|Sub Trade|T.LANE|HAUL\nBOUND|BD|Trunk|Trunk|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POL/NODE|POL/NODE|POL/NODE|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|POD/NODE|POD/NODE|POD/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE|US Mode|VVD|CNTR\nTYPE|DG/RD|L.OFC|S/C No.|S/C Nm|RFA No.|RFA Nm|BCO/NVO|RFA\nType|G.Cust ID|G.Cust Nm|C. Cust Code|Cust Nm|Actual\nCustomer|BKG\nShipper Code|Shipper Nm||Charge\nOFT||CMPB|CMPB|Weight|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|Group COMMODITY|Group COMMODITY|COMMODITY|COMMODITY|Stowage|Apply WK|Apply WK|SVC|Control Type|REMARK|ALOC APLY\nFM DT|ALOC APLY\nTO DT|UseYN|Update User|Update Date|ALOC_SEQ|SHARC_SEQ|SINRS_SEQ|Cmpb only";
			var HeadTitle2 = "|Seq|RHQ|TYPE|Sub Trade|T.LANE|HAUL\nBOUND|BD|POL|POD|Country|LOC|NODE\n(LOC+00)|SCC|Country|LOC|NODE\n(LOC+00)|T/S Port|LANE|BD|POL\n Country|POL|POL NODE\n(LOC+00)|POD\n Country|POD|POD NODE\n(LOC+00)|Country|LOC|NODE\n(LOC+00)|Country|LOC|NODE\n(LOC+00)|SCC|US Mode|VVD|CNTR\nTYPE|DG/RD|L.OFC|S/C No.|S/C Nm|RFA No.|RFA Nm|BCO/NVO|RFA\nType|G.Cust ID|G.Cust Nm|C. Cust Code|Cust Nm|Actual\nCustomer|BKG\nShipper Code|Shipper Nm||Charge\nOFT||Amount\n(USD)|Per Ton|Per TEU|oldteu|TEU|oldBox|BOX|oldwgt|WGT|oldteu|TEU|oldBox|BOX|oldwgt|WGT|CODE|NAME|CODE|NAME|Stowage|From|To|SVC|Control Type|REMARK|ALOC APLY\nFM DT|ALOC APLY\nTO DT|UseYN|Update User|Update Date|ALOC_SEQ|SHARC_SEQ|SINRS_SE|Cmpb only";
			var headCount = ComCountHeadTitle(HeadTitle2);
			delHeadCount = headCount;
			//而щ읆�젙蹂댁꽕�젙[�븘�닔][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			//�빐�뜑�뻾�젙蹂�[�븘�닔][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			FrozenCols = 8;
			//�뜲�씠�꽣�냽�꽦    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 20, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "seq", true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "sls_rhq_cd", false, "", dfNone, 0, false, false, 5); //異붽�
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true, "bkg_aloc_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "sub_trd_cd", false, "", dfNone, 0, true, true, 2); //異붽�
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trnk_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "hul_bnd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trnk_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "trunk_pol_cd", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "trunk_pod_cd", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_por_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "por_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "por_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_por_scc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_pol_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pol_nod_cd", false, "", dfNone, 0, true, true, 7);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "n1st_ts_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "n1st_ts_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "n1st_ts_pol_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "n1st_ts_pol_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_pol_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "n1st_ts_pod_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "n1st_ts_pod_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_pod_nod_cd", false, "", dfNone, 0, true, true, 200);			
			
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_pod_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "pod_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pod_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_del_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "del_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "del_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_del_scc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "usa_bkg_mod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vvd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "dg_rd", false, "", dfNone, 0, true, true, 3); //異붽�
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "ob_sls_ofc_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sc_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "sc_nm", false, "", dfNone, 0, false, true, 20);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rfa_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "rfa_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "acct_tp", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "rfa_ctrt_tp_cd", false, "", dfNone, 0 , false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cust_grp_id", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "cust_grp_nm", false, "", dfNone, 0, false, true, 20);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "ctrt_cust_cnt_cd", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "ctrt_cust_cnt_nm", false, "", dfNone, 0, false, true, 8);
			InitDataProperty(0, cnt++, dtPopup, 90, daCenter, true, "agmt_act_cnt_cd", false, "", dfNone, 0, true, true, 450);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cust_cnt_cd", false, "", dfNone, 0, true, true, 8);//異붽�
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "cust_cnt_nm", false, "", dfNone, 0, false, true, 8);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "old_oft_chg_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "oft_chg_amt", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_cmpb_amt", false, "", dfNullFloat, 0, false, false, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "cmpb_amt", false, "", dfNullFloat, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "cmpb_per_wgt", false, "", dfNone, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "wgt_per_teu", false, "", dfNone, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_aloc_lod_qty", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "aloc_lod_qty", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_op_cntr_qty", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_asgn_ttl_wgt", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "asgn_ttl_wgt", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_aloc_lod_qty_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "aloc_lod_qty_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_op_cntr_qty_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "op_cntr_qty_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_asgn_wgt_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "asgn_wgt_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "scg_grp_cmdt_seq", false, "", dfNone, 0, true, true, 6);//�닲源� dtCombo 
			InitDataProperty(0, cnt++, dtHidden, 100, daLeft, true, "scg_grp_cmdt_desc", false, "", dfNone, 0, false, false, 300);//�닲源�
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cmdt_cd", false, "", dfNone, 0, true, true, 6);
			//InitDataProperty(0, cnt++, dtPopup, 90, daCenter, true, "cmdt_cd", false, "", dfNone, 0, true, true, 450);
			InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false, false, 300);
	         //2017.06.29 로켓배송 Stowage 추가 (송민석)
            InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "stwg_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "aply_fm_yrwk", false, "", dfUserFormat, 0, true, true, 6, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "aply_to_yrwk", false, "", dfUserFormat, 0, true, true, 6, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "aloc_svc_cd", false, "", dfNone, 0, true, true, 1);//�닲源�
			InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "bkg_ctrl_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "bkg_aloc_rmk", false, "", dfNone, 0, true, true, 4000);
			InitDataProperty(0, cnt++, dtPopupEdit, 90, daCenter, true, "aloc_aply_fm_dt", false, "", dfDateYmd, 0, true, true, 30);
			InitDataProperty(0, cnt++, dtPopupEdit, 90, daCenter, true, "aloc_aply_to_dt", false, "", dfDateYmd, 0, true, true, 30);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, true, "aloc_use_flg", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false); //�닲源�
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "upd_dt", false, "", dfNone, 0, false, false); //�닲源�
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "bkg_aloc_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "shaas_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "sinwa_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "cmpb_ony_flg", false, "", dfNone, 0, true, true);//�닲源�
			InitDataCombo(0, "bkg_aloc_tp_cd", " |Trunk|T/S|Customer|EQ|Commodity|Free|Almighty", " |T|S|C|E|M|F|A");
			InitDataValid(0, "cmdt_cd", vtNumericOnly);
			InitDataCombo(0, "aloc_svc_cd", "Auto|Manual", "A|M");
			InitDataCombo(0, "bkg_ctrl_tp_cd", "Standby|Attention", "S|A");
			InitDataCombo(0, "aloc_use_flg", "YES|NO", "Y|N");
			InitDataCombo(0, "dg_rd", " |DG|RD", " |dg|rd");
			InitDataCombo(0, "usa_bkg_mod_cd", " |IPI|Local|Others", " |IPI|LOCAL|OTH");
			InitUserFormat(0, "aply_fm_yrwk", "####-##", "-");
			InitUserFormat(0, "aply_to_yrwk", "####-##", "-");
			InitDataCombo(0, "hul_bnd_cd", " |HH|BH", " |HH|BH");
			InitDataCombo(0, "acct_tp", " |BCO|NVO", " |B|N");
			InitDataCombo(0, "rfa_ctrt_tp_cd", " |Contract|SPOT", " |C|S");
			ColHidden("aloc_aply_fm_dt") = true;
			ColHidden("aloc_aply_to_dt") = true;
			InitDataValid(0, "oft_chg_amt", vtNumericOnly);
			InitDataValid(0, "cmpb_per_wgt", vtNumericOnly); 
			InitDataValid(0, "wgt_per_teu", vtNumericOnly); 
		}
		break;
	case "sheet4": //sheet4 NYCRA
		with (sheetObj) {
			// �넂�씠 �꽕�젙
			style.height = 410;
			//�쟾泥� �꼫鍮� �꽕�젙
			SheetWidth = mainTable.clientWidth;
			//Host�젙蹂� �꽕�젙[�븘�닔][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//�쟾泥퀾erge 醫낅쪟 [�꽑�깮, Default msNone]
			MergeSheet = msHeaderOnly;
			//�쟾泥퀲dit �뿀�슜 �뿬遺� [�꽑�깮, Default false]
			Editable = true;
			//�뻾�젙蹂댁꽕�젙[�븘�닔][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 100);
			// �빐�뜑�뿉�꽌 泥섎━�븷 �닔 �엳�뒗 媛곸쥌 湲곕뒫�쓣 �꽕�젙�븳�떎
			InitHeadMode(true, true, false, true, false, false);
			var HeadTitle1 = "|Seq|TYPE|Sub Trade|T.LANE|HAUL\nBOUND|BD|Trunk|Trunk|VVD|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POL/NODE|POL/NODE|POL/NODE|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|POD/NODE|POD/NODE|POD/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE|CNTR\nTYPE|RHQ|DG/RD|L.OFC|S/C No.|S/C Nm|RFA No.|RFA Nm|BCO/NVO|RFA\nType|G.Cust ID|G.Cust Nm|C. Cust Code|Cust Nm|Actual\nCustomer|BKG\nShipper Code|Shipper Nm||Charge\nOFT||CMPB|CMPB|Weight|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|ALLOCATION|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|%THRESHOLD|Group COMMODITY|Group COMMODITY|COMMODITY|COMMODITY|Stowage|Apply WK|Apply WK|SVC|Control Type|REMARK|ALOC APLY FM DT|ALOC APLY TO DT|UseYN|Update User|Update Date|ALLOC_SEQ|SHARC_SEQ|SINRS_SEQ|Cmpb only";
			var HeadTitle2 = "|Seq|TYPE|Sub Trade|T.LANE|HAUL\nBOUND|BD|POL|POD|VVD|Country|LOC|NODE\n(LOC+00)|SCC|Country|LOC|NODE\n(LOC+00)|T/S Port|LANE|BD|POL\n Country|POL|POL NODE\n(LOC+00)|POD\n Country|POD|POD NODE\n(LOC+00)|Country|LOC|NODE\n(LOC+00)|Country|LOC|NODE\n(LOC+00)|SCC|CNTR\nTYPE|RHQ|DG/RD|L.OFC|S/C No.|S/C Nm|RFA No.|RFA Nm|BCO/NVO|RFA\nType|G.Cust ID|G.Cust Nm|C. Cust Code|Cust Nm|Actual\nCustomer|BKG\nShipper Code|Shipper Nm||Charge\nOFT||Amount\n(USD)|Per Ton|Per TEU|oldteu|TEU|oldBox|BOX|oldwgt|WGT|oldteu|TEU|oldBox|BOX|oldwgt|WGT|CODE|NAME|CODE|NAME|Stowage|From|To|SVC|Control Type|REMARK|ALOC APLY FM DT|ALOC APLY TO DT|UseYN|Update User|Update Date|ALLOC_SEQ|SHARC_SEQ|SINRS_SEQ|Cmpb only";
			var headCount = ComCountHeadTitle(HeadTitle2);
			delHeadCount = headCount;
			//而щ읆�젙蹂댁꽕�젙[�븘�닔][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			//�빐�뜑�뻾�젙蹂�[�븘�닔][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			FrozenCols = 7;
			//�뜲�씠�꽣�냽�꽦    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 20, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "seq", true, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true, "bkg_aloc_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "sub_trd_cd", false, "", dfNone, 0, true, true, 2); //異붽�
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trnk_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "hul_bnd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trnk_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "trunk_pol_cd", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "trunk_pod_cd", false, "", dfNone, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "vvd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_por_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "por_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "por_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_por_scc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_pol_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pol_nod_cd", false, "", dfNone, 0, true, true, 7);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "n1st_ts_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "n1st_ts_dir_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "n1st_ts_pol_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "n1st_ts_pol_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_pol_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "n1st_ts_pod_cnt_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "n1st_ts_pod_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "ts_pod_nod_cd", false, "", dfNone, 0, true, true, 200);
			
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_pod_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "pod_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pod_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtPopup, 55, daCenter, true, "bkg_del_cnt_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "del_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "del_nod_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_del_scc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtPopup, 60, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "sls_rhq_cd", false, "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "dg_rd", false, "", dfNone, 0, true, true, 3); //異붽�
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "ob_sls_ofc_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sc_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "sc_nm", false, "", dfNone, 0, false, true, 20);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rfa_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "rfa_nm", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "acct_tp", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "rfa_ctrt_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cust_grp_id", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "cust_grp_nm", false, "", dfNone, 0, false, true, 20);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "ctrt_cust_cnt_cd", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "ctrt_cust_cnt_nm", false, "", dfNone, 0, false, true, 8);
			InitDataProperty(0, cnt++, dtPopup, 90, daCenter, true, "agmt_act_cnt_cd", false, "", dfNone, 0, true, true, 450);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "cust_cnt_cd", false, "", dfNone, 0, true, true, 8);//異붽�
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "cust_cnt_nm", false, "", dfNone, 0, false, true, 8);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "old_oft_chg_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "oft_chg_amt", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtHidden, 90, daRight, true, "old_cmpb_amt", false, "", dfNullFloat, 0, false, false, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "cmpb_amt", false, "", dfNullFloat, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "cmpb_per_wgt", false, "", dfNone, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "wgt_per_teu", false, "", dfNone, 0, true, true, 6);//異붽�
			InitDataProperty(0, cnt++, dtHidden, 90, daRight, true, "old_aloc_lod_qty", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "aloc_lod_qty", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_op_cntr_qty", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 90, daRight, true, "old_asgn_ttl_wgt", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "asgn_ttl_wgt", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 90, daRight, true, "old_aloc_lod_qty_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daRight, true, "aloc_lod_qty_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_op_cntr_qty_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "op_cntr_qty_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, true, "old_asgn_wgt_rto", false, "", dfNullFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "asgn_wgt_rto", false, "", dfNullFloat, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "scg_grp_cmdt_seq", false, "", dfNone, 0, true, true, 6);//�닲源� dtCombo
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "scg_grp_cmdt_desc", false, "", dfNone, 0, false, false, 300);//�닲源�
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cmdt_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false, false, 300);
			
	         //2017.06.29 로켓배송 Stowage 추가 (송민석)
            InitDataProperty(0, cnt++, dtPopup, 100, daCenter, true, "stwg_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "aply_fm_yrwk", false, "", dfUserFormat, 0, true, true, 6, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "aply_to_yrwk", false, "", dfUserFormat, 0, true, true, 6, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "aloc_svc_cd", false, "", dfNone, 0, true, true, 1);//�떆�듃3留� 蹂댁뿬以�
			InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "bkg_ctrl_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "bkg_aloc_rmk", false, "", dfNone, 0, true, true, 4000);
			InitDataProperty(0, cnt++, dtPopupEdit, 80, daCenter, true, "aloc_aply_fm_dt", false, "", dfDateYmd, 0, true, true, 30);
			InitDataProperty(0, cnt++, dtPopupEdit, 80, daCenter, true, "aloc_aply_to_dt", false, "", dfDateYmd, 0, true, true, 30);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, true, "aloc_use_flg", false, "", dfNone, 0, true, true, 1);//異붽�
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "upd_usr_id", false, "", dfNone, 0, false, false); //�닲源�
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "upd_dt", false, "", dfNone, 0, false, false); //�닲源�
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "bkg_aloc_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "shaas_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "sinwa_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "cmpb_ony_flg", false, "", dfNone, 0, true, true);//�닲源�
			InitDataValid(0, "cmdt_cd", vtNumericOnly);
			InitDataValid(0, "oft_chg_amt", vtNumericOnly);
			InitDataValid(0, "cmpb_per_wgt", vtNumericOnly); 
			InitDataValid(0, "wgt_per_teu", vtNumericOnly); 
			InitDataCombo(0, "aloc_svc_cd", "Auto|Manual", "A|M");
			InitDataCombo(0, "bkg_ctrl_tp_cd", "Standby|Attention", "S|A");
			InitDataCombo(0, "aloc_use_flg", "YES|NO", "Y|N");
			InitDataCombo(0, "dg_rd", " |DG|RD", " |dg|rd");
			InitDataCombo(0, "bkg_aloc_tp_cd", " |Trunk|T/S|Customer|EQ|Commodity|Free|Almighty", " |T|S|C|E|M|F|A");
			InitUserFormat(0, "aply_fm_yrwk", "####-##", "-");
			InitUserFormat(0, "aply_to_yrwk", "####-##", "-");
			InitDataCombo(0, "hul_bnd_cd", " |HH|BH", " |HH|BH");
			InitDataCombo(0, "acct_tp", " |BCO|NVO", " |B|N");
			InitDataCombo(0, "rfa_ctrt_tp_cd", " |Contract|SPOT", " |C|S");
			//ColHidden("bkg_ctrl_tp_cd") = true; //control Type hidden
			//ColHidden("dg_rd") = true;
			ColHidden("agmt_act_cnt_cd") = true;
			ColHidden("aloc_aply_fm_dt") = true;
			ColHidden("aloc_aply_to_dt") = true;
			ColHidden("oft_chg_amt") = true;
			ColHidden("hul_bnd_cd") = true;
			EditableColorDiff = true;
		}
		break;
	}
}
/**
 * Sheet愿��젴 �봽濡쒖꽭�뒪 泥섎━ <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @param {form} formObj �븘�닔 html form object
 * @param {int} sAction �븘�닔 �봽濡쒖꽭�뒪 �뵆�옒洹� �긽�닔
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: //議고쉶
		formObj.f_cmd.value = SEARCH;
		ComOpenWait(true);
		sheetObj.WaitImageVisible = false;    
		sheetObj.DoSearch("ESM_SPC_0115GS.do", FormQueryString(formObj));
		// �뜲�씠�꽣 蹂�寃� �뿬遺� 泥댄겕
		tabShtFlag[beforetab] = 'N';

		break;
	case IBSAVE: //���옣
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			//cmpb_ony_flg �꽭�똿�쓣 �쐞�븳 泥댄겕
			setCmpbOnyFlg(sheetObj);
			sheetObj.DoSave("ESM_SPC_0115GS.do", FormQueryString(formObj));
		} else {
			return false;
		}
		break;
	case IBINSERT: //Row 異붽�
		var newRow = sheetObj.DataInsert(-1);
		var rhq = document.form.tab_rhq_cd.value;
		if (rhq == 'SHARC/SINRS') {
			sheetObj.CellValue(newRow, "sls_rhq_cd") = 'SHARC';
			sheetObj.CellValue(newRow + 1, "sls_rhq_cd") = 'SINRS';
		} else {
			sheetObj.CellValue(newRow, "sls_rhq_cd") = rhq;
		}
		break;
	case IBDELETE: //�궘�젣
		formObj.f_cmd.value = REMOVE;
		var sParam = FormQueryString(formObj) + "&bkg_aloc_seq=" + sheetObj.CellValue(sheetObj.SelectRow, "bkg_aloc_seq");
		sParam += "&shaas_seq=" + sheetObj.CellValue(sheetObj.SelectRow, "shaas_seq") + "&sinwa_seq=" + sheetObj.CellValue(sheetObj.SelectRow, "sinwa_seq");
		var sXml = sheetObj.GetSaveXml("ESM_SPC_0115GS.do", sParam);
		var rMsg = ComResultMessage(sXml);
		if (rMsg == '') {
			sheetObj.LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
			// show message
			ComShowMessage(getMsg("SPC10593"));
		} else {
			ComShowMessage(rMsg);
			return false;
		}
		break;
	case IBCOPYROW: // Row Copy
		var oldIdx = sheetObj.SelectRow;
		var newIdx = sheetObj.DataCopy();
		sheetObj.CellValue2(newIdx, "bkg_aloc_seq") = 0;
		break;
	case SEARCH03: //Commodity Name 議고쉶
		var sParam = "f_cmd=" + SEARCH03 + "&cmdt_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "cmdt_cd");
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0115GS.do", sParam);
		sheetObj.CellValue2(sheetObj.SelectRow, "cmdt_nm") = ComGetEtcData(sXml, "cmdt_nm");
		break;
	case SEARCH05: //Commodity Name 議고쉶
		var sParam = "f_cmd=" + SEARCH05 + "&cmdt_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "scg_grp_cmdt_seq");
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0115GS.do", sParam);
		sheetObj.CellValue2(sheetObj.SelectRow, "scg_grp_cmdt_desc") = ComGetEtcData(sXml, "scg_grp_cmdt_desc");
		break;
	}
}
/*
 *  trade蹂�寃쎌떆
 */
function trade_OnChange(comObj, value, text) {
	comObjects[2].Index2 = 0;
	comObjects[3].Index2 = 0;
	SpcSearchOptionSubTrade("subtrade", true, true, "", "", value); // 0207 SHKIM
	SpcSearchOptionLane("lane", true, false, '', value, '', true); // 0207 SHKIM
}
/*
 * sub_trade蹂�寃쎌떆
 */
function subtrade_OnChange(comObj, value, text) {
	SpcSearchOptionLane("lane", true, false, '', document.form.trade.Code, value, true); // 0207 SHKIM
	if (value == "")
		return;
	var arrTrade = text.split("|");
	if (arrTrade.length > 1) {
		comObjects[1].Code2 = arrTrade[0];
	} else {
		comObjects[1].Code2 = comObj.GetText(value, 0);
	}
	//lane value change
	comObjects[3].Index2 = 0;
}
/*
 * lane蹂�寃쎌떆
 */
function lane_OnChange(comObj, value, text) {
	var repTrade = comObj.GetText(value, 0);
	var subTrade = comObj.GetText(value, 1);
	if (value != "") {
		comObjects[1].Code2 = repTrade;
		comObjects[2].Code2 = subTrade;
	} else {
		comObjects[1].Code2 = "";
		comObjects[2].Code2 = "";
	}
}
/**
 * �솕硫� �뤌�엯�젰媛믪뿉 ���븳 �쑀�슚�꽦寃�利� �봽濡쒖꽭�뒪 泥섎━ <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @param {form} formObj �븘�닔 html form object
 * @param {int} sAction �븘�닔 �봽濡쒖꽭�뒪 �뵆�옒洹� �긽�닔
 * @returns bool <br>
 *          true  : �뤌�엯�젰媛믪씠 �쑀�슚�븷 寃쎌슦<br>
 *          false : �뤌�엯�젰媛믪씠 �쑀�슚�븯吏� �븡�쓣 寃쎌슦
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function validateForm(sheetObj, formObj, sAction) {
	var tabNo = formObj.tab_rhq_cd.value;
	switch (sAction) {
	case IBSAVE:
		if (sheetObj.GetSaveString() == "") {
			ComShowMessage(getMsg("SPC10737"));
			return false;
		}
		with (sheetObj) {
			if (tabShtFlag[beforetab] == 'Y') {
				for (i = HeaderRows; i <= LastRow; i++) {
					if (CellValue(i, "ibflag") == "I" || CellValue(i, "ibflag") == "U") {
						if (tabNo == "NYCRA") {
							if (CellValue(i, "aloc_svc_cd") == "") {
								ComShowMessage(getMsg("SPC10887", "SVC"));
								SelectCell(i, "aloc_svc_cd");
								return false;
							}
						}
						if (CellValue(i, "bkg_aloc_tp_cd") == "") {
							ComShowMessage(getMsg("SPC10887", "TYPE"));
							SelectCell(i, "bkg_aloc_tp_cd");
							return false;
						} else if (CellValue(i, "bkg_aloc_tp_cd") == "T") {
							if (CellValue(i, "trnk_slan_cd") == "") {
								ComShowMessage(getMsg("SPC10887", "T.LANE"));
								SelectCell(i, "trnk_slan_cd");
								return false;
							}
							if (CellValue(i, "aloc_lod_qty_rto") == "") {
								ComShowMessage(getMsg("SPC10887", "THERSHOLD"));
								SelectCell(i, "aloc_lod_qty_rto");
								return false;
							}
						} else if (CellValue(i, "bkg_aloc_tp_cd") == "S") {
							if (CellValue(i, "n1st_ts_slan_cd") == "") {
								ComShowMessage(getMsg("SPC10887", "T/S Lane"));
								SelectCell(i, "n1st_ts_slan_cd");
								return false;
							}
							if(CellValue(i, "aloc_lod_qty") == "" && CellValue(i, "asgn_ttl_wgt") == ""){
			    				ComShowMessage(getMsg("SPC10887","Allocation TEU or WGT"));
			    				if(CellValue(i, "aloc_lod_qty") == "") SelectCell(i,"aloc_lod_qty");
			    				else SelectCell(i,"asgn_ttl_wgt");
			    				return false;
			    			}
						} else if (CellValue(i, "bkg_aloc_tp_cd") == "E") {
							if (CellValue(i, "cntr_tpsz_cd") == "") {
								ComShowMessage(getMsg("SPC10887", "CNTR TYPE"));
								SelectCell(i, "cntr_tpsz_cd");
								return false;
							}
						} else if (CellValue(i, "bkg_aloc_tp_cd") == "M") {
							if (CellValue(i, "cmdt_cd") == "" && CellValue(i, "scg_grp_cmdt_seq") == "") {
								ComShowMessage(getMsg("SPC10887", "COMMODITY CODE"));
								SelectCell(i, "cmdt_cd");
								return false;
							}
						} else if (CellValue(i, "bkg_aloc_tp_cd") == "C") {
							if (CellValue(i, "sc_no") == "" && CellValue(i, "rfa_no") == "" && CellValue(i, "ctrt_cust_cnt_cd") == "" && CellValue(i, "cust_cnt_cd") == "" && CellValue(i, "cust_grp_id") == "") {
								ComShowMessage(getMsg("SPC10887", "S/C No or RFA No or Contract Code or BKG Shipper Code or Cust Group ID"));
								SelectCell(i, "sc_no");
								return false;
							}
						} else if (CellValue(i, "bkg_aloc_tp_cd") == "F") { //sub_trd_cd//trnk_dir_cd
							//vvd check, HJXX VVD(Dummy�씤寃쎌슦�뒗 �떎瑜멸굅 泥댄겕 �븞�븿)
							if (CellValue(i, "vvd").substring(0, 4) == "HJXX" || CellValue(i, "vvd").substring(0, 4) == "HJYY" || CellValue(i, "vvd").substring(0, 4) == "HJZZ") {
								return true;
							} else {
								if (CellValue(i, "sub_trd_cd") == "") {
									ComShowMessage(getMsg("SPC10887", "Sub Trade"));
									SelectCell(i, "sub_trd_cd");
									return false;
								} else if (CellValue(i, "trnk_dir_cd") == "" && CellValue(i, "hul_bnd_cd") == "") {
									ComShowMessage(getMsg("SPC10887", "BD or HAUL BOUND"));
									SelectCell(i, "hul_bnd_cd");
									return false;
								}
							}
						}
						
					    if (CellValue(i, "bkg_aloc_tp_cd") != "A") {
							if (CellValue(i, "bkg_ctrl_tp_cd") == "") {
								ComShowMessage(getMsg("SPC10887", "BKG CNTRL TYPE"));
								SelectCell(i, "bkg_ctrl_tp_cd");
								return false;
							}
					    }
						//�쓬�닔�젣�빟 
						if(CellValue(i, "aloc_lod_qty")< 0||CellValue(i, "op_cntr_qty")< 0||CellValue(i, "asgn_ttl_wgt")< 0||CellValue(i, "aloc_lod_qty_rto")< 0||CellValue(i, "asgn_wgt_rto")< 0){

							ComShowMessage(getMsg("SPC10993", "Minus Number format!")); 
							if(CellValue(i, "aloc_lod_qty")< 0)SelectCell(i, "aloc_lod_qty");
							if(CellValue(i, "op_cntr_qty")< 0)SelectCell(i, "op_cntr_qty");
							if(CellValue(i, "asgn_ttl_wgt")< 0)SelectCell(i, "asgn_ttl_wgt");
							if(CellValue(i, "aloc_lod_qty_rto")< 0)SelectCell(i, "aloc_lod_qty_rto");
							if(CellValue(i, "asgn_wgt_rto")< 0)SelectCell(i, "asgn_wgt_rto");
							return;
						}
					}
				}
			}
		}
		break;
	case IBDELETE:
		delStat = "";
		delSelRow = sheetObj.SelectRow;
		//�꽑�깮�븳 �뻾�씠 Insert�븳 寃쎌슦�씠硫� Data 媛� �뾾�쓣 寃쎌슦 諛붾줈 吏��슫�떎.
		if (sheetObj.CellValue(delSelRow, "bkg_aloc_seq") == "") {
			var rowData = "";
			for ( var i = 3; i <= delHeadCount - 1; i++) {
				if (sheetObj.CellValue(delSelRow, i) != "" && sheetObj.ColSaveName(i) != "aloc_svc_cd") {
					rowData = "N";
				}
			}
			if (rowData == "") {
				//吏��슦怨좎옄 �븯�뒗 �뻾�뿉 Data媛� �뾾�뒗 寃쎌슦 諛붾줈 吏��슫�떎.
				delStat = "0";
				return false;
			} else {
				//吏��슦怨좎옄 �븯�뒗 �뻾�뿉 Data媛� �엳�쓬�뿉�룄 吏��슦硫� �궘�젣 �뿬遺� �븣由쇱갹�쓣 �쓣��.
				delStat = "1";
				return false;
			}
		}
		//Detele ���긽 濡쒖슦�쇅�뿉 蹂��룞�궗�빆�씠 �뾾�떎硫� tabShtFlag[beforetab]瑜� N�쑝濡� 蹂�寃쎌떆�궓�떎.
		tabShtFlag[beforetab] = 'N';
		for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
			if (i != delSelRow) {
				if (sheetObj.CellValue(i, "ibflag") == "I" || sheetObj.CellValue(i, "ibflag") == "U") {
					if (sheetObj.CellValue(i, "bkg_aloc_tp_cd") == "") {
						tabShtFlag[beforetab] = 'N';
					} else {
						tabShtFlag[beforetab] = 'Y';
					}
				}
			}
		}
		break;
	}
	return true;
}
/**
 * Event 泥섎━ <br>
 * </pre>
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function form1_keypress() {
	if (event.srcElement.type == "text" && event.keyCode == 13) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	switch (event.srcElement.dataformat) {
	case "engupnum":
		ComKeyOnlyAlphabet("uppernum");
		break;
	}
}
/**
 * bkg_aloc_tp_cd�뿉 �뵲�씪 SVC �뿴�쓽 媛믪쓣 �옄�룞�쑝濡� 湲곗엯�븳�떎. <br>
 * <br><b>Example :</b>
 * <pre>
 *     svcType(sheetObject[0])
 * </pre>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function svcType(sheetObj) {
	if (sheetObj.CellValue(sheetObj.SelectRow, "bkg_aloc_tp_cd") == "T") {
		sheetObj.CellValue2(sheetObj.SelectRow, "aloc_svc_cd") = "A";
	} else {
		sheetObj.CellValue2(sheetObj.SelectRow, "aloc_svc_cd") = "M";
	}
}
/**
 * bkg_aloc_tp_cd 蹂꾨줈 ���쓽 �솢�꽦�솕 �뿬遺�瑜� �꽕�젙�븳�떎. <br>
 * <br><b>Example :</b>
 * <pre>
 *     sheetEnable(sheetObject[0])
 * </pre>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function sheetEnable(sheetObj) {
	
	sheetObj.ReDraw = false;
	with (sheetObj) {
		var bkg_aloc_tp_cd, ibflag ;
		for ( var i = 2; i <= LastRow; i++) {
			bkg_aloc_tp_cd = CellValue(i, "bkg_aloc_tp_cd");
			ibflag = CellValue(i, "ibflag");
			if (bkg_aloc_tp_cd == "T") {
				setCellEditableT(sheetObj,i);
			}else if (bkg_aloc_tp_cd == "S") {
				setCellEditableS(sheetObj,i);
			}else if (bkg_aloc_tp_cd == "E") {
				setCellEditableE(sheetObj,i);
			}else if (bkg_aloc_tp_cd == "C") {
				setCellEditableC(sheetObj,i);
			}else if (bkg_aloc_tp_cd == "M") {
				setCellEditableM(sheetObj,i);
			}else if (bkg_aloc_tp_cd == "F") {
				setCellEditableF(sheetObj,i);
			}else if (bkg_aloc_tp_cd == "A") {
				setCellEditableA(sheetObj,i);
			}
			
			//�빆�긽 false
			CellEditable(i, "sc_nm") = false;
			CellEditable(i, "rfa_nm") = false;
			CellEditable(i, "ctrt_cust_cnt_nm") = false;
			CellEditable(i, "cust_cnt_nm") = false;
			CellEditable(i, "cust_grp_nm") = false;
			CellEditable(i, "cmdt_nm") = false;
			CellEditable(i, "bkg_aloc_tp_cd") = false;
			CellEditable(i, "sls_rhq_cd") = false;
			CellEditable(i, "upd_usr_id") = false;
			CellEditable(i, "upd_dt") = false;
			CellValue2(i, "ibflag")=ibflag;
		}
	}
	sheetObj.ReDraw = true;
}

//T	Trunk
function setCellEditableT(sheetObj,i){
	with (sheetObj) {
	       //stowage code
        CellEditable(i, "stwg_cd") = false;CellValue2(i, "stwg_cd") = "";       


		CellEditable(i, "trnk_slan_cd") = true;
		CellEditable(i, "trnk_dir_cd") = true;
		CellEditable(i, "trunk_pol_cd") = true;
		CellEditable(i, "trunk_pod_cd") = true;
		CellEditable(i, "aloc_lod_qty_rto") = true;
		CellEditable(i, "bkg_ctrl_tp_cd") = true;//CellValue2(i, "bkg_ctrl_tp_cd") = "S";
		CellEditable(i, "agmt_act_cnt_cd") = true;
		CellEditable(i, "oft_chg_amt") = true;
		CellEditable(i, "aloc_aply_fm_dt") = true;
		CellEditable(i, "aloc_aply_to_dt") = true;
		CellEditable(i, "aloc_use_flg") = true;
		CellEditable(i, "aloc_svc_cd") = true;
		CellEditable(i, "asgn_wgt_rto") = true;
		CellEditable(i, "sub_trd_cd") = true;
		CellEditable(i, "hul_bnd_cd") = true;
		CellEditable(i, "bkg_por_cnt_cd") = false;CellValue2(i, "bkg_por_cnt_cd") = "";
		CellEditable(i, "por_cd") = false;CellValue2(i, "por_cd") = "";
		CellEditable(i, "por_nod_cd") = false;CellValue2(i, "por_nod_cd") = "";
		CellEditable(i, "bkg_por_scc_cd") = false;CellValue2(i, "bkg_por_scc_cd") = "";
		CellEditable(i, "bkg_pol_cnt_cd") = false;CellValue2(i, "bkg_pol_cnt_cd") = "";
		CellEditable(i, "pol_cd") = false;CellValue2(i, "pol_cd") = "";
		CellEditable(i, "pol_nod_cd") = false;CellValue2(i, "pol_nod_cd") = "";		
		CellEditable(i, "n1st_ts_slan_cd") = false;CellValue2(i, "n1st_ts_slan_cd") = "";
		CellEditable(i, "n1st_ts_dir_cd") = false;CellValue2(i, "n1st_ts_dir_cd") = "";
		CellEditable(i, "n1st_ts_pol_cnt_cd") = false;CellValue2(i, "n1st_ts_pol_cnt_cd") = "";
		CellEditable(i, "n1st_ts_pol_cd") = false;CellValue2(i, "n1st_ts_pol_cd") = "";	
		CellEditable(i, "n1st_ts_pod_cnt_cd") = false;CellValue2(i, "n1st_ts_pod_cnt_cd") = "";
		CellEditable(i, "n1st_ts_pod_cd") = false;CellValue2(i, "n1st_ts_pod_cd") = "";	
		CellEditable(i, "bkg_pod_cnt_cd") = false;CellValue2(i, "bkg_pod_cnt_cd") = "";
		CellEditable(i, "pod_cd") = false;CellValue2(i, "pod_cd") = "";
		CellEditable(i, "pod_nod_cd") = false;CellValue2(i, "pod_nod_cd") = "";
		CellEditable(i, "bkg_del_cnt_cd") = false;CellValue2(i, "bkg_del_cnt_cd") = "";
		CellEditable(i, "del_cd") = false;CellValue2(i, "del_cd") = "";
		CellEditable(i, "del_nod_cd") = false;CellValue2(i, "del_nod_cd") = "";
		CellEditable(i, "bkg_del_scc_cd") = false;CellValue2(i, "bkg_del_scc_cd") = "";
		CellEditable(i, "usa_bkg_mod_cd") = false;CellValue2(i, "usa_bkg_mod_cd") = "";		
		CellEditable(i, "cntr_tpsz_cd") = false;CellValue2(i, "cntr_tpsz_cd") = "";
		CellEditable(i, "dg_rd") = false;CellValue2(i, "dg_rd") = "";
		CellEditable(i, "ob_sls_ofc_cd") = false;CellValue2(i, "ob_sls_ofc_cd") = "";
		CellEditable(i, "sc_no") = false;CellValue2(i, "sc_no") = "";
		CellEditable(i, "sc_nm") = false;
		CellEditable(i, "rfa_no") = false;CellValue2(i, "rfa_no") = "";
		CellEditable(i, "rfa_nm") = false;
		CellEditable(i, "acct_tp") = true;
		CellEditable(i, "cust_grp_id") = false;CellValue2(i, "cust_grp_id") = "";
		CellEditable(i, "rfa_ctrt_tp_cd") = false;CellValue2(i, "rfa_ctrt_tp_cd") = "";
		CellEditable(i, "ctrt_cust_cnt_cd") = false;CellValue2(i, "ctrt_cust_cnt_cd") = "";
		CellEditable(i, "ctrt_cust_cnt_nm") = false;
		CellEditable(i, "cust_cnt_cd") = false;CellValue2(i, "cust_cnt_cd") = "";
		CellEditable(i, "cust_cnt_nm") = false;CellEditable(i, "cust_grp_nm") = false;
		CellEditable(i, "cmpb_amt") = true;
		CellEditable(i, "cmdt_cd") = false;CellValue2(i, "cmdt_cd") = "";
		CellEditable(i, "cmdt_nm") = false;
		CellEditable(i, "aply_fm_yrwk") = true;
		CellEditable(i, "aply_to_yrwk") = true;

		CellEditable(i, "ts_nod_cd") = false;CellValue2(i, "ts_nod_cd") = "";	
		CellEditable(i, "ts_pol_nod_cd") = false;CellValue2(i, "ts_pol_nod_cd") = "";	
		CellEditable(i, "ts_pod_nod_cd") = false;CellValue2(i, "ts_pod_nod_cd") = "";
		
		//NYCRA
		if (sheetObj.id == 'sheet4') {
			CellEditable(i, "vvd") = true;
			CellEditable(i, "aloc_lod_qty") = false;CellValue2(i, "aloc_lod_qty") = "";
			CellEditable(i, "asgn_ttl_wgt") = false;CellValue2(i, "asgn_ttl_wgt") = "";
			CellEditable(i, "bkg_aloc_rmk") = false;CellValue2(i, "bkg_aloc_rmk") = "";
			CellEditable(i, "op_cntr_qty") = false;CellValue2(i, "op_cntr_qty") = "";
			
		}else{
			CellEditable(i, "vvd") = false;CellValue2(i, "vvd") = "";
			CellEditable(i, "aloc_lod_qty") = true;
			CellEditable(i, "asgn_ttl_wgt") = true;
			CellEditable(i, "bkg_aloc_rmk") = true;
			CellEditable(i, "op_cntr_qty") = true;
		}
	}
}
//S	T/S
function setCellEditableS(sheetObj,i){
	with (sheetObj) {
        //stowage code
        CellEditable(i, "stwg_cd") = false;CellValue2(i, "stwg_cd") = "";       
  
		CellEditable(i, "trnk_slan_cd") = true;
		CellEditable(i, "trnk_dir_cd") = true;
		CellEditable(i, "por_cd") = true;
		CellEditable(i, "por_nod_cd") = true;
		CellEditable(i, "bkg_por_scc_cd") = true;
		CellEditable(i, "pol_cd") = true;
		CellEditable(i, "pol_nod_cd") = true;
		CellEditable(i, "pod_cd") = true;
		CellEditable(i, "pod_nod_cd") = true;
		CellEditable(i, "del_cd") = true;
		CellEditable(i, "del_nod_cd") = true;
		CellEditable(i, "bkg_del_scc_cd") = true;
		CellEditable(i, "ob_sls_ofc_cd") = true;
		CellEditable(i, "aloc_lod_qty") = true;
		CellEditable(i, "aloc_lod_qty_rto") = true;
		CellEditable(i, "sub_trd_cd") = true;
		CellEditable(i, "agmt_act_cnt_cd") = true;
		CellEditable(i, "oft_chg_amt") = true;
		CellEditable(i, "aloc_aply_fm_dt") = true;
		CellEditable(i, "aloc_aply_to_dt") = true;
		CellEditable(i, "aloc_use_flg") = true;
		CellEditable(i, "n1st_ts_slan_cd") = true;
		CellEditable(i, "n1st_ts_dir_cd") = true;
		CellEditable(i, "n1st_ts_pol_cd") = true;
		CellEditable(i, "n1st_ts_pod_cd") = true;
		CellEditable(i, "n1st_ts_pod_cnt_cd") = true;
		CellEditable(i, "n1st_ts_pol_cnt_cd") = true;
		CellEditable(i, "bkg_aloc_rmk") = true;
		CellEditable(i, "bkg_por_cnt_cd") = true;
		CellEditable(i, "bkg_pol_cnt_cd") = true;
		CellEditable(i, "bkg_pod_cnt_cd") = true;
		CellEditable(i, "bkg_del_cnt_cd") = true;
		CellEditable(i, "bkg_ctrl_tp_cd") = true;//CellValue2(i, "bkg_ctrl_tp_cd") = "S";
		CellEditable(i, "asgn_ttl_wgt") = true;
		CellEditable(i, "asgn_wgt_rto") = true;
		CellEditable(i, "hul_bnd_cd") = true;
		CellEditable(i, "trunk_pol_cd") = false;CellValue2(i, "trunk_pol_cd") = "";
		CellEditable(i, "trunk_pod_cd") = false;CellValue2(i, "trunk_pod_cd") = "";
		CellEditable(i, "usa_bkg_mod_cd") = true;
		CellEditable(i, "cntr_tpsz_cd") = false;CellValue2(i, "cntr_tpsz_cd") = "";
		CellEditable(i, "dg_rd") = false;CellValue2(i, "dg_rd") = "";
		CellEditable(i, "sc_no") = false;CellValue2(i, "sc_no") = "";
		CellEditable(i, "sc_nm") = false;
		CellEditable(i, "rfa_no") = false;CellValue2(i, "rfa_no") = "";
		CellEditable(i, "rfa_nm") = false;
		CellEditable(i, "acct_tp") = true;
		CellEditable(i, "scg_grp_cmdt_seq") = false;CellValue2(i, "scg_grp_cmdt_seq") = "";
		CellEditable(i, "cust_grp_id") = false;CellValue2(i, "cust_grp_id") = "";
		CellEditable(i, "rfa_ctrt_tp_cd") = false;CellValue2(i, "rfa_ctrt_tp_cd") = "";
		CellEditable(i, "ctrt_cust_cnt_cd") = false;CellValue2(i, "ctrt_cust_cnt_cd") = "";
		CellEditable(i, "ctrt_cust_cnt_nm") = false;
		CellEditable(i, "cust_cnt_cd") = false;CellValue2(i, "cust_cnt_cd") = "";
		CellEditable(i, "cust_cnt_nm") = false;CellEditable(i, "cust_grp_nm") = false;
		CellEditable(i, "cmpb_amt") = true;
		CellEditable(i, "cmdt_cd") = false;CellValue2(i, "cmdt_cd") = "";
		CellEditable(i, "cmdt_nm") = false;
		CellEditable(i, "aply_fm_yrwk") = true;
		CellEditable(i, "aply_to_yrwk") = true;
		CellEditable(i, "op_cntr_qty") = true;

		CellEditable(i, "ts_nod_cd") = true;
		CellEditable(i, "ts_pol_nod_cd") = true;
		CellEditable(i, "ts_pod_nod_cd") = true;
		//NYCRA
		if (sheetObj.id == 'sheet4') {
			CellEditable(i, "vvd") = true;
		}else{
			CellEditable(i, "vvd") = false;CellValue2(i, "vvd") = "";
		}
	}
}
//E	EQ
function setCellEditableE(sheetObj,i){
	with (sheetObj) {
        //stowage code
        CellEditable(i, "stwg_cd") = false;CellValue2(i, "stwg_cd") = "";       
  
		CellEditable(i, "trnk_slan_cd") = true;
		CellEditable(i, "trnk_dir_cd") = true;
		CellEditable(i, "por_cd") = true;
		CellEditable(i, "por_nod_cd") = true;
		CellEditable(i, "bkg_por_scc_cd") = true;
		CellEditable(i, "pol_cd") = true;
		CellEditable(i, "pol_nod_cd") = true;
		CellEditable(i, "pod_cd") = true;
		CellEditable(i, "pod_nod_cd") = true;
		CellEditable(i, "del_cd") = true;
		CellEditable(i, "del_nod_cd") = true;
		CellEditable(i, "bkg_del_scc_cd") = true;
		CellEditable(i, "cntr_tpsz_cd") = true;
		CellEditable(i, "ob_sls_ofc_cd") = true;
		CellEditable(i, "bkg_ctrl_tp_cd") = true;//CellValue2(i, "bkg_ctrl_tp_cd") = "S";
		CellEditable(i, "dg_rd") = true;
		CellEditable(i, "agmt_act_cnt_cd") = true;
		CellEditable(i, "oft_chg_amt") = true;
		CellEditable(i, "aloc_aply_fm_dt") = true;
		CellEditable(i, "aloc_aply_to_dt") = true;
		CellEditable(i, "aloc_use_flg") = true;
		CellEditable(i, "bkg_aloc_rmk") = true;
		CellEditable(i, "bkg_por_cnt_cd") = true;
		CellEditable(i, "bkg_pol_cnt_cd") = true;
		CellEditable(i, "bkg_pod_cnt_cd") = true;
		CellEditable(i, "bkg_del_cnt_cd") = true;
		CellEditable(i, "asgn_wgt_rto") = true;
		CellEditable(i, "scg_grp_cmdt_seq") = false;CellValue2(i, "scg_grp_cmdt_seq") = "";
		CellEditable(i, "sub_trd_cd") = true;
		CellEditable(i, "hul_bnd_cd") = true;
		CellEditable(i, "trunk_pol_cd") = false;CellValue2(i, "trunk_pol_cd") = "";
		CellEditable(i, "trunk_pod_cd") = false;CellValue2(i, "trunk_pod_cd") = "";
		CellEditable(i, "n1st_ts_dir_cd") = false;CellValue2(i, "n1st_ts_dir_cd") = "";
		CellEditable(i, "n1st_ts_pol_cnt_cd") = false;CellValue2(i, "n1st_ts_pol_cnt_cd") = "";
		CellEditable(i, "n1st_ts_pol_cd") = false;CellValue2(i, "n1st_ts_pol_cd") = "";
		CellEditable(i, "n1st_ts_pod_cnt_cd") = false;CellValue2(i, "n1st_ts_pod_cnt_cd") = "";
		CellEditable(i, "n1st_ts_pod_cd") = false;CellValue2(i, "n1st_ts_pod_cd") = "";
		CellEditable(i, "usa_bkg_mod_cd") = true;
		CellEditable(i, "sc_no") = false;CellValue2(i, "sc_no") = "";
		CellEditable(i, "sc_nm") = false;
		CellEditable(i, "rfa_no") = false;CellValue2(i, "rfa_no") = "";
		CellEditable(i, "rfa_nm") = false;
		CellEditable(i, "acct_tp") = true;
		CellEditable(i, "cust_grp_id") = false;CellValue2(i, "cust_grp_id") = "";
		CellEditable(i, "rfa_ctrt_tp_cd") = false;CellValue2(i, "rfa_ctrt_tp_cd") = "";
		CellEditable(i, "ctrt_cust_cnt_cd") = false;CellValue2(i, "ctrt_cust_cnt_cd") = "";
		CellEditable(i, "ctrt_cust_cnt_nm") = false;
		CellEditable(i, "cust_cnt_cd") = false;CellValue2(i, "cust_cnt_cd") = "";
		CellEditable(i, "cust_cnt_nm") = false;CellEditable(i, "cust_grp_nm") = false;
		CellEditable(i, "cmpb_amt") = true;
		CellEditable(i, "cmdt_cd") = false;CellValue2(i, "cmdt_cd") = "";
		CellEditable(i, "cmdt_nm") = false;
		CellEditable(i, "aply_fm_yrwk") = true;
		CellEditable(i, "aply_to_yrwk") = true;

		CellEditable(i, "ts_nod_cd") = false;CellValue2(i, "ts_nod_cd") = "";	
		CellEditable(i, "ts_pol_nod_cd") = false;CellValue2(i, "ts_pol_nod_cd") = "";	
		CellEditable(i, "ts_pod_nod_cd") = false;CellValue2(i, "ts_pod_nod_cd") = "";

		//NYCRA
		if (sheetObj.id ==  'sheet4') {
			CellEditable(i, "n1st_ts_slan_cd") = true;
			CellEditable(i, "aloc_svc_cd") = true;
			CellEditable(i, "aloc_lod_qty") = true;
			CellEditable(i, "asgn_ttl_wgt") = true;
			CellEditable(i, "aloc_lod_qty_rto") = false;CellValue2(i, "aloc_lod_qty_rto") = "";
			CellEditable(i, "asgn_wgt_rto") = false;CellValue2(i, "asgn_wgt_rto") = "";
			CellEditable(i, "op_cntr_qty") = false;CellValue2(i, "op_cntr_qty") = "";
			CellEditable(i, "vvd") = true;
		}else{
			CellEditable(i, "n1st_ts_slan_cd") = false;CellValue2(i, "n1st_ts_slan_cd") = "";
			CellEditable(i, "aloc_svc_cd") = false;
			CellEditable(i, "aloc_lod_qty") = true;
			CellEditable(i, "asgn_ttl_wgt") = true;
			CellEditable(i, "aloc_lod_qty_rto") = true;
			CellEditable(i, "asgn_wgt_rto") = true;
			CellEditable(i, "op_cntr_qty") = true;
			CellEditable(i, "vvd") = false;CellValue2(i, "vvd") = "";
		}
	}
}
//C	Customer
function setCellEditableC(sheetObj,i){
	with (sheetObj) {
        //stowage code
        CellEditable(i, "stwg_cd") = false;CellValue2(i, "stwg_cd") = "";       
   
		CellEditable(i, "trnk_slan_cd") = true;
		CellEditable(i, "trnk_dir_cd") = true;
		CellEditable(i, "por_cd") = true;
		CellEditable(i, "por_nod_cd") = true;
		CellEditable(i, "bkg_por_scc_cd") = true;
		CellEditable(i, "pol_cd") = true;
		CellEditable(i, "pol_nod_cd") = true;
		CellEditable(i, "pod_cd") = true;
		CellEditable(i, "pod_nod_cd") = true;
		CellEditable(i, "del_cd") = true;
		CellEditable(i, "del_nod_cd") = true;
		CellEditable(i, "bkg_del_scc_cd") = true;
		CellEditable(i, "cntr_tpsz_cd") = true;
		CellEditable(i, "ob_sls_ofc_cd") = true;
		CellEditable(i, "sc_no") = true;
		CellEditable(i, "rfa_no") = true;
		CellEditable(i, "cust_grp_id") = true;
		CellEditable(i, "rfa_ctrt_tp_cd") = true;
		CellEditable(i, "ctrt_cust_cnt_cd") = true;
		CellEditable(i, "cust_cnt_cd") = true;
		CellEditable(i, "cmpb_amt") = true;
		CellEditable(i, "bkg_ctrl_tp_cd") = true;//CellValue2(i, "bkg_ctrl_tp_cd") = "S";
		CellEditable(i, "sub_trd_cd") = true;
		CellEditable(i, "agmt_act_cnt_cd") = true;
		CellEditable(i, "oft_chg_amt") = true;
		CellEditable(i, "aloc_aply_fm_dt") = true;
		CellEditable(i, "aloc_aply_to_dt") = true;
		CellEditable(i, "aloc_use_flg") = true;
		CellEditable(i, "bkg_por_cnt_cd") = true;
		CellEditable(i, "bkg_pol_cnt_cd") = true;
		CellEditable(i, "bkg_pod_cnt_cd") = true;
		CellEditable(i, "bkg_del_cnt_cd") = true;
		CellEditable(i, "aloc_svc_cd") = true;
		CellEditable(i, "bkg_aloc_rmk") = true;	
		CellEditable(i, "asgn_wgt_rto") = true;
		CellEditable(i, "hul_bnd_cd") = true;
		CellEditable(i, "usa_bkg_mod_cd") = true;
		CellEditable(i, "trunk_pol_cd") = false;CellValue2(i, "trunk_pol_cd") = "";
		CellEditable(i, "trunk_pod_cd") = false;CellValue2(i, "trunk_pod_cd") = "";	
		CellEditable(i, "n1st_ts_dir_cd") = false;CellValue2(i, "n1st_ts_dir_cd") = "";
		CellEditable(i, "n1st_ts_pol_cnt_cd") = false;CellValue2(i, "n1st_ts_pol_cnt_cd") = "";
		CellEditable(i, "n1st_ts_pol_cd") = false;CellValue2(i, "n1st_ts_pol_cd") = "";
		CellEditable(i, "n1st_ts_pod_cnt_cd") = false;CellValue2(i, "n1st_ts_pod_cnt_cd") = "";
		CellEditable(i, "n1st_ts_pod_cd") = false;CellValue2(i, "n1st_ts_pod_cd") = "";
		CellEditable(i, "dg_rd") = false;CellValue2(i, "dg_rd") = "";
		CellEditable(i, "sc_nm") = false;
		CellEditable(i, "rfa_nm") = false;
		CellEditable(i, "acct_tp") = true;
		CellEditable(i, "ctrt_cust_cnt_nm") = false;
		CellEditable(i, "cust_cnt_nm") = false;CellEditable(i, "cust_grp_nm") = false;
		CellEditable(i, "cmdt_nm") = false;
		CellEditable(i, "aply_fm_yrwk") = true;
		CellEditable(i, "aply_to_yrwk") = true;

		CellEditable(i, "ts_nod_cd") = false;CellValue2(i, "ts_nod_cd") = "";	
		CellEditable(i, "ts_pol_nod_cd") = false;CellValue2(i, "ts_pol_nod_cd") = "";	
		CellEditable(i, "ts_pod_nod_cd") = false;CellValue2(i, "ts_pod_nod_cd") = "";

		//NYCRA
		if (sheetObj.id == 'sheet4') {
			CellEditable(i, "n1st_ts_slan_cd") = true;
			CellEditable(i, "cmdt_cd") = true;
			CellEditable(i, "scg_grp_cmdt_seq") = true;
			CellEditable(i, "aloc_lod_qty") = false;CellValue2(i, "aloc_lod_qty") = "";
			CellEditable(i, "asgn_ttl_wgt") = false;CellValue2(i, "asgn_ttl_wgt") = "";
			CellEditable(i, "aloc_lod_qty_rto") = false;CellValue2(i, "aloc_lod_qty_rto") = "";
			CellEditable(i, "asgn_wgt_rto") = false;CellValue2(i, "asgn_wgt_rto") = "";
			CellEditable(i, "op_cntr_qty") = false;CellValue2(i, "op_cntr_qty") = "";
			CellEditable(i, "vvd") = true;
		}else{
			CellEditable(i, "n1st_ts_slan_cd") = false;CellValue2(i, "n1st_ts_slan_cd") = "";
			CellEditable(i, "cmdt_cd") = false;CellValue2(i, "cmdt_cd") = "";
			CellEditable(i, "scg_grp_cmdt_seq") = false;CellValue2(i, "scg_grp_cmdt_seq") = "";
			CellEditable(i, "aloc_lod_qty") = true;
			CellEditable(i, "asgn_ttl_wgt") = true;
			CellEditable(i, "aloc_lod_qty_rto") = true;
			CellEditable(i, "asgn_wgt_rto") = true;
			CellEditable(i, "op_cntr_qty") = true;
			CellEditable(i, "vvd") = false;CellValue2(i, "vvd") = "";
		}
	}
}
//M	Commodity
function setCellEditableM(sheetObj,i){
	with (sheetObj) {
        //stowage code
        CellEditable(i, "stwg_cd") = false;CellValue2(i, "stwg_cd") = "";       

		CellEditable(i, "trnk_slan_cd") = true;
		CellEditable(i, "trnk_dir_cd") = true;
		CellEditable(i, "por_cd") = true;
		CellEditable(i, "por_nod_cd") = true;
		CellEditable(i, "bkg_por_scc_cd") = true;
		CellEditable(i, "pol_cd") = true;
		CellEditable(i, "pol_nod_cd") = true;
		CellEditable(i, "pod_cd") = true;
		CellEditable(i, "pod_nod_cd") = true;
		CellEditable(i, "del_cd") = true;
		CellEditable(i, "del_nod_cd") = true;
		CellEditable(i, "bkg_del_scc_cd") = true;
		CellEditable(i, "cntr_tpsz_cd") = true;
		CellEditable(i, "ob_sls_ofc_cd") = true;
		CellEditable(i, "cmdt_cd") = true;
		CellEditable(i, "scg_grp_cmdt_seq") = true;
		CellEditable(i, "bkg_ctrl_tp_cd") = true;//CellValue2(i, "bkg_ctrl_tp_cd") = "S";
		CellEditable(i, "agmt_act_cnt_cd") = true;
		CellEditable(i, "oft_chg_amt") = true;
		CellEditable(i, "aloc_aply_fm_dt") = true;
		CellEditable(i, "aloc_aply_to_dt") = true;
		CellEditable(i, "aloc_use_flg") = true;
		CellEditable(i, "bkg_aloc_rmk") = true;
		CellEditable(i, "bkg_por_cnt_cd") = true;
		CellEditable(i, "bkg_pol_cnt_cd") = true;
		CellEditable(i, "bkg_pod_cnt_cd") = true;
		CellEditable(i, "bkg_del_cnt_cd") = true;
		CellEditable(i, "asgn_wgt_rto") = true;
		CellEditable(i, "sub_trd_cd") = true;
		CellEditable(i, "hul_bnd_cd") = true;
		CellEditable(i, "trunk_pol_cd") = false;CellValue2(i, "trunk_pol_cd") = "";
		CellEditable(i, "trunk_pod_cd") = false;CellValue2(i, "trunk_pod_cd") = "";		
		CellEditable(i, "n1st_ts_dir_cd") = false;CellValue2(i, "n1st_ts_dir_cd") = "";
		CellEditable(i, "n1st_ts_pol_cnt_cd") = false;CellValue2(i, "n1st_ts_pol_cnt_cd") = "";
		CellEditable(i, "n1st_ts_pol_cd") = false;CellValue2(i, "n1st_ts_pol_cd") = "";
		CellEditable(i, "n1st_ts_pod_cnt_cd") = false;CellValue2(i, "n1st_ts_pod_cnt_cd") = "";
		CellEditable(i, "n1st_ts_pod_cd") = false;CellValue2(i, "n1st_ts_pod_cd") = "";
		CellEditable(i, "usa_bkg_mod_cd") = true;
		CellEditable(i, "dg_rd") = false;CellValue2(i, "dg_rd") = "";
		CellEditable(i, "sc_nm") = false;
		CellEditable(i, "rfa_nm") = false;
		CellEditable(i, "acct_tp") = true;
		CellEditable(i, "cust_grp_id") = false;CellValue2(i, "cust_grp_id") = "";
		CellEditable(i, "rfa_ctrt_tp_cd") = false;CellValue2(i, "rfa_ctrt_tp_cd") = "";
		CellEditable(i, "ctrt_cust_cnt_cd") = false;CellValue2(i, "ctrt_cust_cnt_cd") = "";
		CellEditable(i, "ctrt_cust_cnt_nm") = false;
		CellEditable(i, "cust_cnt_cd") = false;CellValue2(i, "cust_cnt_cd") = "";
		CellEditable(i, "cust_cnt_nm") = false;CellEditable(i, "cust_grp_nm") = false;
		CellEditable(i, "cmpb_amt") = true;
		CellEditable(i, "cmdt_nm") = false;
		CellEditable(i, "aply_fm_yrwk") = true;
		CellEditable(i, "aply_to_yrwk") = true;

		CellEditable(i, "ts_nod_cd") = false;CellValue2(i, "ts_nod_cd") = "";	
		CellEditable(i, "ts_pol_nod_cd") = false;CellValue2(i, "ts_pol_nod_cd") = "";	
		CellEditable(i, "ts_pod_nod_cd") = false;CellValue2(i, "ts_pod_nod_cd") = "";

		//NYCRA
		if (sheetObj.id == 'sheet4') {
			CellEditable(i, "n1st_ts_slan_cd") = true;
			CellEditable(i, "aloc_svc_cd") = true;
			CellEditable(i, "sc_no") = false;CellValue2(i, "sc_no") = "";
			CellEditable(i, "rfa_no") = false;CellValue2(i, "rfa_no") = "";
			CellEditable(i, "aloc_lod_qty") = false;CellValue2(i, "aloc_lod_qty") = "";
			CellEditable(i, "asgn_ttl_wgt") = false;CellValue2(i, "asgn_ttl_wgt") = "";
			CellEditable(i, "aloc_lod_qty_rto") = false;CellValue2(i, "aloc_lod_qty_rto") = "";
			CellEditable(i, "asgn_wgt_rto") = false;CellValue2(i, "asgn_wgt_rto") = "";
			CellEditable(i, "op_cntr_qty") = false;CellValue2(i, "op_cntr_qty") = "";
			CellEditable(i, "vvd") = true;
		}else{
			CellEditable(i, "n1st_ts_slan_cd") = false;CellValue2(i, "n1st_ts_slan_cd") = "";
			CellEditable(i, "aloc_svc_cd") = false;
			CellEditable(i, "sc_no") = true;
			CellEditable(i, "rfa_no") = true;
			CellEditable(i, "aloc_lod_qty") = true;
			CellEditable(i, "asgn_ttl_wgt") = true;
			CellEditable(i, "aloc_lod_qty_rto") = true;
			CellEditable(i, "asgn_wgt_rto") = true;
			CellEditable(i, "op_cntr_qty") = true;
			CellEditable(i, "vvd") = false;CellValue2(i, "vvd") = "";
		}
	}

}
//F	Feee
function setCellEditableF(sheetObj,i){
	with (sheetObj) {
	    //stowage code
	    CellEditable(i, "stwg_cd") = true;

		CellEditable(i, "bkg_aloc_tp_cd") = true;
		CellEditable(i, "sub_trd_cd") = true;
		CellEditable(i, "trnk_slan_cd") = true;
		CellEditable(i, "hul_bnd_cd") = true;
		CellEditable(i, "trnk_dir_cd") = true;
		CellEditable(i, "trunk_pol_cd") = true;
		CellEditable(i, "trunk_pod_cd") = true;
		CellEditable(i, "bkg_por_cnt_cd") = true;
		CellEditable(i, "por_cd") = true;
		CellEditable(i, "por_nod_cd") = true;
		CellEditable(i, "bkg_por_scc_cd") = true;
		CellEditable(i, "bkg_pol_cnt_cd") = true;
		CellEditable(i, "pol_cd") = true;
		CellEditable(i, "pol_nod_cd") = true;
		CellEditable(i, "n1st_ts_slan_cd") = true;
		CellEditable(i, "n1st_ts_dir_cd") = true;
		CellEditable(i, "n1st_ts_pol_cnt_cd") = true;
		CellEditable(i, "n1st_ts_pol_cd") = true;
		CellEditable(i, "n1st_ts_pod_cnt_cd") = true;
		CellEditable(i, "n1st_ts_pod_cd") = true;
		CellEditable(i, "bkg_pod_cnt_cd") = true;
		CellEditable(i, "pod_cd") = true;
		CellEditable(i, "pod_nod_cd") = true;
		CellEditable(i, "bkg_del_cnt_cd") = true;
		CellEditable(i, "del_cd") = true;
		CellEditable(i, "del_nod_cd") = true;
		CellEditable(i, "bkg_del_scc_cd") = true;
		CellEditable(i, "usa_bkg_mod_cd") = true;
		CellEditable(i, "vvd") = true;
		CellEditable(i, "cntr_tpsz_cd") = true;
		CellEditable(i, "dg_rd") = true;
		CellEditable(i, "ob_sls_ofc_cd") = true;
		CellEditable(i, "sc_no") = true;
		CellEditable(i, "sc_nm") = false;
		CellEditable(i, "rfa_no") = true;
		CellEditable(i, "rfa_nm") = false;
		CellEditable(i, "acct_tp") = true;
		CellEditable(i, "ctrt_cust_cnt_cd") = true;CellEditable(i, "cust_grp_id") = true;
		CellEditable(i, "rfa_ctrt_tp_cd") = true;
		CellEditable(i, "ctrt_cust_cnt_nm") = false;
		CellEditable(i, "agmt_act_cnt_cd") = true;
		CellEditable(i, "cust_cnt_cd") = true;
		CellEditable(i, "cust_cnt_nm") = false;CellEditable(i, "cust_grp_nm") = false;
		CellEditable(i, "oft_chg_amt") = true;
		CellEditable(i, "cmpb_amt") = true;
		CellEditable(i, "aloc_lod_qty") = true;
		CellEditable(i, "asgn_ttl_wgt") = true;
		CellEditable(i, "aloc_lod_qty_rto") = true;
		CellEditable(i, "asgn_wgt_rto") = true;
		CellEditable(i, "cmdt_cd") = true;
		CellEditable(i, "cmdt_nm") = false;
		CellEditable(i, "aply_fm_yrwk") = true;
		CellEditable(i, "aply_to_yrwk") = true;
		CellEditable(i, "bkg_ctrl_tp_cd") = true;//CellValue2(i, "bkg_ctrl_tp_cd") = "S";
		CellEditable(i, "bkg_aloc_rmk") = true;
		CellEditable(i, "aloc_aply_fm_dt") = true;
		CellEditable(i, "aloc_aply_to_dt") = true;
		CellEditable(i, "aloc_use_flg") = true;
		CellEditable(i, "op_cntr_qty") = true;

		CellEditable(i, "ts_nod_cd") = true;
		CellEditable(i, "ts_pol_nod_cd") = true;
		CellEditable(i, "ts_pod_nod_cd") = true;
	}
}
//A	Almighty
function setCellEditableA(sheetObj,i){
	with (sheetObj) {
        //stowage code
        //CellEditable(i, "stwg_cd") = false;CellValue2(i, "stwg_cd") = "";	 
	    CellEditable(i, "stwg_cd") = true;
		CellEditable(i, "bkg_aloc_tp_cd") = true;
		CellEditable(i, "sub_trd_cd") = true;
		CellEditable(i, "trnk_slan_cd") = true;
		CellEditable(i, "hul_bnd_cd") = true;
		CellEditable(i, "trnk_dir_cd") = true;
		CellEditable(i, "trunk_pol_cd") = true;
		CellEditable(i, "trunk_pod_cd") = true;
		CellEditable(i, "bkg_por_cnt_cd") = true;
		CellEditable(i, "por_cd") = true;
		CellEditable(i, "por_nod_cd") = true;
		CellEditable(i, "bkg_por_scc_cd") = true;
		CellEditable(i, "bkg_pol_cnt_cd") = true;
		CellEditable(i, "pol_cd") = true;
		CellEditable(i, "pol_nod_cd") = true;
		CellEditable(i, "n1st_ts_slan_cd") = true;
		CellEditable(i, "n1st_ts_dir_cd") = true;
		CellEditable(i, "n1st_ts_pol_cnt_cd") = true;
		CellEditable(i, "n1st_ts_pol_cd") = true;
		CellEditable(i, "n1st_ts_pod_cnt_cd") = true;
		CellEditable(i, "n1st_ts_pod_cd") = true;
		CellEditable(i, "bkg_pod_cnt_cd") = true;
		CellEditable(i, "pod_cd") = true;
		CellEditable(i, "pod_nod_cd") = true;
		CellEditable(i, "bkg_del_cnt_cd") = true;
		CellEditable(i, "del_cd") = true;
		CellEditable(i, "del_nod_cd") = true;
		CellEditable(i, "bkg_del_scc_cd") = true;
		CellEditable(i, "usa_bkg_mod_cd") = true;
		CellEditable(i, "vvd") = true;
		CellEditable(i, "cntr_tpsz_cd") = true;
		CellEditable(i, "dg_rd") = true;
		CellEditable(i, "ob_sls_ofc_cd") = true;
		CellEditable(i, "sc_no") = true;
		CellEditable(i, "sc_nm") = false;
		CellEditable(i, "rfa_no") = true;
		CellEditable(i, "rfa_nm") = false;
		CellEditable(i, "acct_tp") = true;
		CellEditable(i, "ctrt_cust_cnt_cd") = true; CellEditable(i, "cust_grp_id") = true;
		CellEditable(i, "rfa_ctrt_tp_cd") = true;
		CellEditable(i, "ctrt_cust_cnt_nm") = false;
		CellEditable(i, "agmt_act_cnt_cd") = true;
		CellEditable(i, "cust_cnt_cd") = true;
		CellEditable(i, "cust_cnt_nm") = false;CellEditable(i, "cust_grp_nm") = false;
		CellEditable(i, "oft_chg_amt") = true;
		CellEditable(i, "cmpb_amt") = true;
		CellEditable(i, "op_cntr_qty") = true;
		CellEditable(i, "aloc_lod_qty") = true;
		CellEditable(i, "asgn_ttl_wgt") = true;
		CellEditable(i, "aloc_lod_qty_rto") = false;CellValue2(i, "aloc_lod_qty_rto") = "";
		CellEditable(i, "asgn_wgt_rto") = false;CellValue2(i, "asgn_wgt_rto") = "";
		CellEditable(i, "cmdt_cd") = true;
		CellEditable(i, "cmdt_nm") = false;
		CellEditable(i, "aply_fm_yrwk") = true;
		CellEditable(i, "aply_to_yrwk") = true;
		CellEditable(i, "bkg_ctrl_tp_cd") = false;CellValue2(i, "bkg_ctrl_tp_cd") = "";//A紐⑤뱶�뿉�꽌�뒗  bkg_aloc_tp_cd 鍮꾪솢�꽦�솕 
		CellEditable(i, "bkg_aloc_rmk") = true;
		CellEditable(i, "aloc_aply_fm_dt") = true;
		CellEditable(i, "aloc_aply_to_dt") = true;
		CellEditable(i, "aloc_use_flg") = true;

		CellEditable(i, "ts_nod_cd") = true;
		CellEditable(i, "ts_pol_nod_cd") = true;
		CellEditable(i, "ts_pod_nod_cd") = true;
	}
}
/**
 * �솕硫� �떆�듃媛믪쓽 蹂��솕�뿉 �뵲�씪 �닔�뻾�맆 �룞�옉�쓣 �젙�쓽�븳�떎.<br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @returns �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function sheet_OnChange(sheetObj, row, col, val) {
	var formObj = document.form;
	var val_type = "";
	var val_value = "";
	var today = ComGetNowInfo('ymd');
	var tabCd = formObj.tab_rhq_cd.value;
	// �뜲�씠�꽣 蹂�寃� �뿬遺� 泥댄겕
	tabShtFlag[beforetab] = 'Y';
	/* ColSaveName */
	var col_save_name = sheetObj.ColSaveName(col);
	var data_type = sheetObj.ReadDataProperty(row, col, 0);
	/* ��臾몄옄 */
	if (col_save_name == "aloc_aply_fm_dt" || col_save_name == "aloc_aply_to_dt") {
		//			var submitDate=  (sheetObj.CellValue(row, col));
		var fdt = sheetObj.CellValue(row, "aloc_aply_fm_dt").replace(/-/g, '');
		var tdt = sheetObj.CellValue(row, "aloc_aply_to_dt").replace(/-/g, '');
		if (parseInt(fdt) > parseInt(tdt)) {
			ComShowCodeMessage('COM12133', 'To date', 'From date', 'greater');//
			sheetObj.CellValue(row, col) = "";
			sheetObj.SelectCell(row, col);
		}
	}
	if (data_type == dtData) {
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
	}
	//bkg_aloc_tp_cd蹂�寃쎌떆 SVC媛믨낵 ���쓽 �솢�꽦�솕�뿬遺�瑜� 寃곗젙�븳�떎
	if (col_save_name == "bkg_aloc_tp_cd") {		
		sheet_OnSelectCell(sheetObj, row);
		if (sheetObj.CellValue(row, "sls_rhq_cd") == 'NYCRA') { 
			svcType(sheetObj);	
		}
	} else if (col_save_name == "trnk_slan_cd" || col_save_name == "n1st_ts_slan_cd") {
		//trnk_slan_cd, trnk_dir_cd, trnk_dir_cd 蹂�寃쎌떆 媛믪쓽 �쟻�젙�꽦�쓣 Validation�븳�떎.
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "LANE";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "sub_trd_cd") {//異붽� �뀒�뒪�듃
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "SUB_TRADE";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "trnk_dir_cd" || col_save_name == "n1st_ts_dir_cd") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "BOUND";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "cmdt_cd") { //NYCRA瑜� �젣�쇅�븯怨� �굹癒몄� RHQ�쓽 寃쎌슦�뒗 Multi�엯�젰 泥섎━
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "COMMODITY";
			val_value = sheetObj.CellValue(row, "cmdt_cd");
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			} else {
				doActionIBSheet(sheetObj, formObj, SEARCH03);
			}
		} else {
			sheetObj.CellValue2(row, "cmdt_nm") = "";
		}
	} else if (col_save_name == "scg_grp_cmdt_seq") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "GRP_COMMODITY";
			val_value = sheetObj.CellValue(row, "scg_grp_cmdt_seq");
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			} else {
				doActionIBSheet(sheetObj, formObj, SEARCH05);
			}
		} else {
			sheetObj.CellValue2(row, "scg_grp_cmdt_desc") = "";
		}
	} else if (col_save_name == "ob_sls_ofc_cd" /*|| col_save_name == "sls_rhq_cd"*/) {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			formObj.ofc_cd.value = sheetObj.CellValue(row, col);
			formObj.ofc_ty.value = 1;
			formObj.f_cmd.value = SEARCH10;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESM_SPC_0115GS.do", sParam);
			if (ComGetEtcData(sXml, "check") == "N") {
				ComShowMessage(getMsg("SPC11107"));//�궗�슜媛��뒫�븳 Office Code媛� �븘�떃�땲�떎.
				sheetObj.SelectCell(row, col, true, '');
			}
		}
	} else if (col_save_name == "vvd") {
		var vvd = sheetObj.CellValue(row, col_save_name);
		if (vvd != "") {

			formObj.f_cmd.value = SEARCH11;
			formObj.vvd_sig.value = sheetObj.CellValue(row, col);

			if (vvd.substring(0, 4) == 'SMXX' || vvd.substring(0, 4) == 'SMYY' || vvd.substring(0, 4) == 'SMZZ') {
				if (sheetObj.CellValue(row, col).length != 4 && sheetObj.CellValue(row, col).length != 9) {
					ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.
					sheetObj.SelectCell(row, col, true, '');
					return false;
				}
				
			} else {	
				if (sheetObj.CellValue(row, col).length != 9) {
					ComShowMessage(getMsg("SPC10145"));//Please! Check your VVD.
					sheetObj.SelectCell(row, col, true, '');
					return false;
				}
				//Dummy媛� �븘�땶寃쎌슦留� 泥댄겕
				var searchXml = sheetObj.GetSearchXml("ESM_SPC_0115GS.do", FormQueryString(formObj));
				if (ComGetEtcData(searchXml, "lane") == "none") {
					ComShowMessage(getMsg("SPC10163"));//VVD is NOT Registered
					sheetObj.SelectCell(row, col, true, '');
					return false;
				}
			}
			
		}
	} else if (col_save_name == "cust_grp_id") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "CUST_GRP_ID";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "ctrt_cust_cnt_cd") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "CUSTOMER_GRP";
			val_value = sheetObj.CellValue(row, col_save_name);
			var val_value2 = sheetObj.CellValue(row, "cust_grp_id");
			if (!searchValidationData(sheetObj, val_type, val_value, val_value2)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}		
	} else if (col_save_name == "cust_cnt_cd") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "CUSTOMER";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "agmt_act_cnt_cd") {
				//not multi
	} else if (col_save_name == "cntr_tpsz_cd") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "CNTR TPSZ";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (sheetObj.CellValue(row, col_save_name) == "ALL" && sheetObj.CellValue(row, "bkg_aloc_tp_cd") != "E") {
				ComShowMessage(getMsg('SPC10993', val_type + " : " + val_value));
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "sc_no") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "SC NO";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "rfa_no") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "RFA NO";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name.indexOf("pol_cd") > -1 || col_save_name.indexOf("pod_cd") > -1 || col_save_name.indexOf("por_cd") > -1 || col_save_name.indexOf("del_cd") > -1) {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "Location";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name.indexOf("cnt_cd") > -1) {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "CNT";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "bkg_por_scc_cd" || col_save_name == "bkg_del_scc_cd") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "SCC";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
				sheetObj.SelectCell(row, col);
			}
		}
	} else if (col_save_name == "por_nod_cd" || col_save_name == "pol_nod_cd" || col_save_name == "pod_nod_cd" || col_save_name == "del_nod_cd") {
		if (sheetObj.CellValue(row, col_save_name) != "") {
			val_type = "NODE";
			val_value = sheetObj.CellValue(row, col_save_name);
			if (!searchValidationData(sheetObj, val_type, val_value)) {
				sheetObj.CellValue2(row, col_save_name) = "";
			}
		}
	}
	//sheet1�쓽 寃쎌슦 Data蹂�寃쎌떆, seq媛� 媛숈� row�쓽 媛� 蹂�寃�
	if (sheetObj.id == 'sheet1') {
		if (col_save_name != 'sls_rhq_cd') {
			var rid = 0;
			if (sheetObj.CellValue(row, "sls_rhq_cd") == 'SHARC') {
				rid = row + 1;
				sheetObj.CellValue2(rid, col) = sheetObj.CellValue(row, col);
				if (col_save_name == "bkg_aloc_tp_cd")
					sheet_OnSelectCell(sheetObj, rid);
				sheetObj.SelectCell(row, col);
			} else if (sheetObj.CellValue(row, "sls_rhq_cd") == 'SINRS') {
				rid = row - 1;
				sheetObj.CellValue2(rid, col) = sheetObj.CellValue(row, col);
				if (col_save_name == "bkg_aloc_tp_cd")
					sheet_OnSelectCell(sheetObj, rid);
				sheetObj.SelectCell(row, col);
			}
		}
	}
}
/**
 * �솕硫� �떆�듃媛믪쓽 蹂��솕�뿉 �뵲�씪 �닔�뻾�맆 �룞�옉�쓣 �젙�쓽�븳�떎.<br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @returns �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function sheet1_OnChange(sheetObj, row, col, val) {
	sheet_OnChange(sheetObj, row, col, val);
}
function sheet2_OnChange(sheetObj, row, col, val) {
	sheet_OnChange(sheetObj, row, col, val);
}
function sheet3_OnChange(sheetObj, row, col, val) {
	sheet_OnChange(sheetObj, row, col, val);
}
function sheet4_OnChange(sheetObj, row, col, val) {
	sheet_OnChange(sheetObj, row, col, val);
}
function sheet5_OnChange(sheetObj, row, col, val) {
	sheet_OnChange(sheetObj, row, col, val);
}
/**
 * ���옣�떆 �떆�듃�쓽 媛믪뿉 �뵲瑜� Validation�쓣 �떎�떆�븳�떎.<br>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @param {String} lane_cd
 * @param {String} dir_cd
 * @param {String} cmdt_cd
 * @returns bool <br>
 *          true  : �뤌�엯�젰媛믪씠 �쑀�슚�븷 寃쎌슦<br>
 *          false : �뤌�엯�젰媛믪씠 �쑀�슚�븯吏� �븡�쓣 寃쎌슦
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function searchValidationData(sheetObj, val_type, val_value, val_value2) {
	var formObj = document.form;
	var sParam = "";
	formObj.f_cmd.value = SEARCH02;
	sParam = "f_cmd=102&" + "&val_type=" + val_type + "&val_value=" + val_value+ "&val_value2=" + val_value2;
	var sXml = sheetObjects[0].GetSearchXml("ESM_SPC_0115GS.do", sParam);	
	var val_cnt = ComGetEtcData(sXml, "val_cnt");
	if (val_cnt > 0 || val_value == "") {
		return true;
	}
	ComShowMessage(getMsg('SPC10993', val_type + " : " + val_value));
	return false;
}
/**
 * IBSheet ���옣 �븿�닔瑜� �씠�슜�븯�뿬 ���옣�씠 �셿猷뚮릺怨� 諛쒖깮�븯�뒗 Event<br>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @param {String} ErrMsg ���옣 �썑 硫붿떆吏�
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function sheet_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	if (ErrMsg == "") {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		tabShtFlag[beforetab] = 'N';
	}
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	sheet_OnSaveEnd(sheetObj, ErrMsg);
}
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	sheet_OnSaveEnd(sheetObj, ErrMsg);
}
function sheet3_OnSaveEnd(sheetObj, ErrMsg) {
	sheet_OnSaveEnd(sheetObj, ErrMsg);
}
function sheet4_OnSaveEnd(sheetObj, ErrMsg) {
	sheet_OnSaveEnd(sheetObj, ErrMsg);
}
function sheet5_OnSaveEnd(sheetObj, ErrMsg) {
	sheet_OnSaveEnd(sheetObj, ErrMsg);
}
/**
 * IBSheet ���옣 �븿�닔瑜� �씠�슜�븯�뿬 議고쉶媛� �셿猷뚮릺怨� 諛쒖깮�븯�뒗 Event<br>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @param {String} ErrMsg ���옣 �썑 硫붿떆吏�
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function sheet_OnSearchEnd(sheetObj, ErrMsg) {

	sheetEnable(sheetObj);
	ComOpenWait(false);			
}
/**
 * IBSheet ���옣 �븿�닔瑜� �씠�슜�븯�뿬 議고쉶媛� �셿猷뚮릺怨� 諛쒖깮�븯�뒗 Event<br>
 * @param {ibsheet} sheetObj �븘�닔 IBSheet Object
 * @param {String} ErrMsg ���옣 �썑 硫붿떆吏�
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheet_OnSearchEnd(sheetObj, ErrMsg)
}
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	sheet_OnSearchEnd(sheetObj, ErrMsg)
}
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	sheet_OnSearchEnd(sheetObj, ErrMsg)
}
function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
	sheet_OnSearchEnd(sheetObj, ErrMsg)
}
function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
	sheet_OnSearchEnd(sheetObj, ErrMsg)
}
/**
 * IBSheet �꽑�깮 Cell 蹂�寃� Event<br>
 * @return �뾾�쓬
 * @author Seung-Man KIM
 * @version 2015.01.23
 */
function sheet_OnSelectCell(sheetObj, i) {
	with (sheetObj) {
	
			// i �씤寃쎌슦 
			if (CellValue(i, "ibflag") == "I") {
				CellEditable(i, "bkg_aloc_tp_cd") = true;
				var	bkg_aloc_tp_cd = CellValue(i, "bkg_aloc_tp_cd");
				if (bkg_aloc_tp_cd == "T") {
					setCellEditableT(sheetObj,i);
				}else if (bkg_aloc_tp_cd == "S") {
					setCellEditableS(sheetObj,i);
				}else if (bkg_aloc_tp_cd == "E") {
					setCellEditableE(sheetObj,i);
				}else if (bkg_aloc_tp_cd == "C") {
					setCellEditableC(sheetObj,i);
				}else if (bkg_aloc_tp_cd == "M") {
					setCellEditableM(sheetObj,i);
				}else if (bkg_aloc_tp_cd == "F") {
					setCellEditableF(sheetObj,i);
				}else if (bkg_aloc_tp_cd == "A") {
					setCellEditableA(sheetObj,i);
				}
				//�빆�긽 false
				CellEditable(i, "sls_rhq_cd") = false;
				CellEditable(i, "upd_usr_id") = false;
				CellEditable(i, "upd_dt") = false;				
			} else {
				CellEditable(i, "bkg_aloc_tp_cd") = false;
			}
	}
}

function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, row, col) {
	sheet_OnSelectCell(sheetObj, row);
}
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, row, col) {
	sheet_OnSelectCell(sheetObj, row);
}
function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, row, col) {
	sheet_OnSelectCell(sheetObj, row);
}
function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, row, col) {
	sheet_OnSelectCell(sheetObj, row);
}
function sheet5_OnSelectCell(sheetObj, OldRow, OldCol, row, col) {
	sheet_OnSelectCell(sheetObj, row);
}
/**
 * �떆�듃瑜� �겢由��뻽�쓣 �븣 泥섎━
 */
function sheet_OnClick(sheetObj, row, col) {
	var colSaveName = sheetObj.ColSaveName(col);
	switch (colSaveName) {
	case "bkg_aloc_rmk":
		/* 湲� 臾몄옄�뿴 MemoPad 泥섎━*/
		if (sheetObj.CellValue(row, "bkg_aloc_tp_cd") != 'T') {
			sheetObj.CellEditable(row, col) = false;
			ComShowMemoPad(sheetObj, row, col, false, 250, 100);
			sheetObj.CellEditable(row, col) = true;
		}
		break;
	}
}
/**
 * �떆�듃瑜� �겢由��뻽�쓣 �븣 泥섎━
 */
function sheet1_OnClick(sheetObj, row, col) {
	sheet_OnClick(sheetObj, row, col)
}
/**
 * �떆�듃瑜� �겢由��뻽�쓣 �븣 泥섎━
 */
function sheet2_OnClick(sheetObj, row, col) {
	sheet_OnClick(sheetObj, row, col)
}
/**
 * �떆�듃瑜� �겢由��뻽�쓣 �븣 泥섎━
 */
function sheet3_OnClick(sheetObj, row, col) {
	sheet_OnClick(sheetObj, row, col)
}
/**
 * �떆�듃瑜� �겢由��뻽�쓣 �븣 泥섎━
 */
function sheet4_OnClick(sheetObj, row, col) {
	sheet_OnClick(sheetObj, row, col);
}
function sheet5_OnClick(sheetObj, row, col) {
	sheet_OnClick(sheetObj, row, col);
}
/**
 * sheet1�뿉�꽌 �씠誘몄�踰꾪듉�쓣 �겢由��븳 寃쎌슦 瑜� 泥섎━�븳�떎.
 * gubun A�씤寃쎌슦 C1T0W 媛� �븘�땶寃쎌슦
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet_OnPopupClick(sheetObj, row, col, y) {
	var colSaveName = sheetObj.ColSaveName(col);
	var tabNo = y;
	if (colSaveName == 'agmt_act_cnt_cd') {
		var sc = sheetObj.CellValue(row, "sc_no");
		var rfa = sheetObj.CellValue(row, "rfa_no");
		if (sc == '' && rfa == '') {
			ComShowMessage(getMsg("SPC90301", " for Actual Customer."));
			sheetObj.SelectCell(i, "sc_no");
		} else {
			var url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073" + "&sc_no=" + sc + "&rfa_no=" + rfa + "&type=" + "B" + "&actAcctCmdt=" + sheetObj.CellValue(row, "agmt_act_cnt_cd");
			ComOpenPopup(url, 800, 420, "callBackPopupActCust", "0,1,1,1,1,1", false, false, row, col, y);
		}
	} else if (colSaveName.indexOf("pol_cd") > -1 || colSaveName.indexOf("pod_cd") > -1 || colSaveName.indexOf("por_cd") > -1 || colSaveName.indexOf("del_cd") > -1 || colSaveName.indexOf("cnt_cd") > -1 || colSaveName.indexOf("cntr_tpsz_cd") > -1 ) {
		var loCdTp = ''; 
		var urlPopUp = '/hanjin/ESM_SPC_0121.do'; 
		if (colSaveName.indexOf("trunk_") > -1) {
			loCdTp = 'T';
		} else //location search
		if (colSaveName.indexOf("pol_cd") > -1 || colSaveName.indexOf("pod_cd") > -1 || colSaveName.indexOf("por_cd") > -1 || colSaveName.indexOf("del_cd") > -1) {
			loCdTp = 'L';
		} else //country search
		if (colSaveName.indexOf("cnt_cd") > -1) {
			loCdTp = 'C';
		} else //cntr_tpsz_cd search
			if (colSaveName.indexOf("cntr_tpsz_cd") > -1) {
				loCdTp = 'S';
				urlPopUp = '/hanjin/ESM_SPC_0124.do';
		}
		var param = "";
		param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row, "trnk_slan_cd");
		param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row, "trnk_dir_cd");
		param = param + "&loc_cd_tp=" + loCdTp;
		param = param + "&loc_multi_cd=" + sheetObj.CellValue(row, colSaveName);
		param = param + "&org_sheet=" + "0";
		param = param + "&org_row=" + row;
		param = param + "&org_ui_id=" + "ESM_SPC_0115";
		param = param + "&tabNo=" + tabNo;
		param = param + "&targetColume=" + colSaveName;
		ComOpenPopup(urlPopUp + param, 340, 420, '', '1,0,1,1,1,1,1,1', true);
	} else if (colSaveName == 'aloc_aply_fm_dt') {
		var cal = new ComCalendarGrid();
		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
	} else if (colSaveName == 'aloc_aply_to_dt') {
		var cal = new ComCalendarGrid();
		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
	} else if (colSaveName == 'cmdt_cd') {
		var sc = sheetObj.CellValue(row, "sc_no");
		var rfa = sheetObj.CellValue(row, "rfa_no");
		if (sc == '' && rfa == '') {
			ComShowMessage(getMsg("SPC90301", " for Commodity."));
			sheetObj.SelectCell(i, "sc_no");
		} else {
			var url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0115" + "&sc_no=" + sc + "&rfa_no=" + rfa + "&type=" + "C" + "&actAcctCmdt=" + sheetObj.CellValue(row, "cmdt_cd");
			ComOpenPopup(url, 800, 420, "callBackPopupCmdt", "0,1,1,1,1,1", false, false, row, col, y);
		}
		
		
	}  else if (colSaveName.indexOf("ts_nod_cd") > -1 || colSaveName.indexOf("ts_pol_nod_cd") > -1 || colSaveName.indexOf("ts_pod_nod_cd") > -1 ) {
		var loCdTp = ''; 
		var urlPopUp = '/hanjin/ESM_SPC_0121.do'; 
		if (colSaveName.indexOf("ts_nod_cd") > -1) {
			loCdTp = 'LN';
		} else {
			loCdTp = 'N';
		}

		var param = "";
		param = param + "?loc_cd_tp=" + loCdTp;
		param = param + "&loc_multi_cd=" + sheetObj.CellValue(row, colSaveName);
		param = param + "&org_sheet=" + "0";
		param = param + "&org_row=" + row;
		param = param + "&org_ui_id=" + "ESM_SPC_0115";
		param = param + "&tabNo=" + tabNo;
		param = param + "&targetColume=" + colSaveName;
		ComOpenPopup(urlPopUp + param, 340, 420, '', '1,0,1,1,1,1,1,1', true);
	}else if (colSaveName == 'stwg_cd') {
        ComOpenPopup("ESM_SPC_S001.do?pgmNo=ESM_SPC_S001&sheetNo="+y+"&tabNo=" + tabNo+"&rowNo="+row+"&bkg_aloc_seq=" + sheetObj.CellValue(row, "bkg_aloc_seq") , 
                420, 470, "callBackS001","1,0,1,1,1", true);
	}
}
/**
 *   Stowage Request 팝업에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBackS001(rArray);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 송민석
 * @version 2017.06.29
 */
function callBackS001(stwgCd,sheet_no,tab_no,row_no){      
     var formObj = document.form;
 
    sheetObjects[sheet_no].CellValue2(row_no,"stwg_cd") = stwgCd;
    
    if (tab_no == "0") {
        if (sheetObjects[sheet_no].CellValue(row_no, "sls_rhq_cd") == 'SHARC') {
            rid = Number(row_no) + 1;
            sheetObjects[sheet_no].CellValue2(rid, "stwg_cd") = stwgCd;
        } else if (sheetObjects[sheet_no].CellValue(row_no, "sls_rhq_cd") == 'SINRS') {
            rid = Number(row_no) - 1;
            sheetObjects[sheet_no].CellValue2(rid, "stwg_cd") = stwgCd;
        }
    }
 
  
}    

/**
 * sheet1�뿉�꽌 �씠誘몄�踰꾪듉�쓣 �겢由��븳 寃쎌슦 瑜� 泥섎━�븳�떎.
 * gubun A�씤寃쎌슦 C1T0W 媛� �븘�땶寃쎌슦
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	sheet_OnPopupClick(sheetObj, row, col, 0);
}
/**
 * sheet1�뿉�꽌 �씠誘몄�踰꾪듉�쓣 �겢由��븳 寃쎌슦 瑜� 泥섎━�븳�떎.
 * gubun A�씤寃쎌슦 C1T0W 媛� �븘�땶寃쎌슦
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnPopupClick(sheetObj, row, col) {
	sheet_OnPopupClick(sheetObj, row, col, 1);
}
/**
 * sheet1�뿉�꽌 �씠誘몄�踰꾪듉�쓣 �겢由��븳 寃쎌슦 瑜� 泥섎━�븳�떎.
 * gubun A�씤寃쎌슦 C1T0W 媛� �븘�땶寃쎌슦
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet3_OnPopupClick(sheetObj, row, col) {
	sheet_OnPopupClick(sheetObj, row, col, 2);
}
/**
 * sheet1�뿉�꽌 �씠誘몄�踰꾪듉�쓣 �겢由��븳 寃쎌슦 瑜� 泥섎━�븳�떎.
 * gubun A�씤寃쎌슦 C1T0W 媛� �븘�땶寃쎌슦
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet4_OnPopupClick(sheetObj, row, col) {
	sheet_OnPopupClick(sheetObj, row, col, 3);
}
function sheet5_OnPopupClick(sheetObj, row, col) {
	sheet_OnPopupClick(sheetObj, row, col, 4);
}
/**
 * IBSheet�쓽 肄ㅻ낫 而щ읆�뿉 �뜲�씠�꽣瑜� setting�븳�떎. <br>
 * <b>Example :</b>
 * <pre>
 * setIBCombo(sheetObj,sXml,"rcv_de_term_cd",false,1);
 * </pre>
 *
 * @param {string} sheetObj �븘�닔
 * @param {string} sXml �븘�닔, Combo�뿉 梨꾩슱 �뜲�씠�꽣(IBSheet瑜� �넻�빐 諛쏆븘�삩 xml 臾몄옄�뿴.)
 * @param {string} title �븘�닔, Combo field紐�(IBSheet SaveName).
 * @param {string} iBlank �꽑�깮, Combo�쓽 泥ル쾲吏몃줈�슦瑜� 釉붾옲�겕濡� �꽕�젙
 * @param {string} sCol �꽑�깮, 硫��떚肄ㅻ낫�씪寃쎌슦 肄ㅻ낫瑜� �꽑�깮�븯硫� 肄ㅻ낫�뿉 蹂댁뿬吏� �닚�꽌�꽕�젙(0:肄붾뱶 or 1:description)
 * @param {string} dCode �꽑�깮, �떊洹� "�엯�젰" �긽�깭�씪 �븣 湲곕낯�쑝濡� �꽑�깮�릺�뼱�빞 �븷 Item�뿉 ���븳 Code媛�
 * @param {string} dText �꽑�깮, �떊洹� "�엯�젰" �긽�깭�씪 �븣 湲곕낯�쑝濡� �꽑�깮�릺�뼱�빞 �븷 Item�뿉 ���븳 Text媛�
 * @param {string} dispCol �꽑�깮, 肄ㅻ낫�뿉�꽌 �솕硫댁뿉 蹂댁뿬二쇰뒗 肄붾뱶媛믪쓽 移쇰읆 val,desc 以� val媛믪씪 �븣 �꽑�깮媛��뒫.
 * (肄붾뱶|�뵒�뒪�겕由쎌뀡 �삎�깭媛� �븘�땺 寃쎌슦�뒗 0�쑝濡� �꽕�젙�빐�빞�븿)
 * @return
 * @author Seung-Man KIM
 * @version 2015.02.20
 */
function setIBCombo(sheetObj, sXml, title, iBlank, sCol, dCode, dText, dispCol) {
	var showCol = 0;
	var bFlag = false;
	if (sCol != undefined && sCol != "") {
		showCol = sCol;
	}
	if (iBlank != undefined && iBlank != "") {
		bFlag = iBlank;
	}
	if (dispCol == undefined || dispCol == "") {
		dispCol = "desc";
	}
	//       var arrData = ComBkgXml2ComboString(sXml, "val", dispCol);
	var arrData = SpcXml2ComboItem(sXml, "val", dispCol);
	if (bFlag == true) {
		arrData[1] = " \t |" + arrData[1];
		arrData[0] = " |" + arrData[0];
	}
	sheetObj.InitDataCombo(0, title, arrData[1], arrData[0], dText, dCode, showCol);
}

/**
 * 寃곌낵 XML濡� 遺��꽣 MESSAGE瑜� 異붿텧�븯�뒗 �븿�닔.
 *
 * @param 寃곌낵XML <br>
 * @returns String <br>
 * @author Seung-Man KIM
 */
function ComResultMessage(xmlStr) {
	if (xmlStr == null || xmlStr == '')
		return '';
	var xValue = '';
	try {
		/* XML Parsing */
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.async = "false";
		xmlDoc.loadXML(xmlStr);
		/* get message */
		var el_messages = xmlDoc.documentElement.getElementsByTagName("MESSAGE");
		if (el_messages != null && el_messages.length > 0) {
			xValue = el_messages.item(0).text;
		} else {
			xValue = '';
		}
	} catch (err) {
		xValue = err.message;
	}
	return xValue;
}
function initCell(sheetObj, row) {
	with (sheetObj) {
		for ( var i = 1; i < LastCol; i++) {
			if (CellValue(i, "bkg_aloc_tp_cd" != "F")) {
				CellEditable(row, i) = false;
			}
		}
	}
}
/* 
 *Actual Customer popup�솕硫댁쓽 肄쒕갚�븿�닔
 */
function callBackPopupActCust(rowArray, Row, Col, ShtIdx) {
	if (Row > 0) {
		var sheetObj = sheetObjects[ShtIdx];
		var addCd = "";
		for ( var idx = 0; idx < rowArray.length; idx++) {
			addCd = addCd + rowArray[idx][3];
			if (idx != rowArray.length - 1)
				addCd = addCd + ",";
		}
		sheetObj.CellValue(Row, "agmt_act_cnt_cd") = addCd;
	} else if (Row == 0) {
		sheetObj.CellValue(Row, "agmt_act_cnt_cd") = "";
	}
}
/*
 * Commodity popup�솕硫댁쓽 肄쒕갚�븿�닔
 */
function callBackPopupCmdt(rowArray, Row, Col, ShtIdx) {
	if (Row > 0) {
		var sheetObj = sheetObjects[ShtIdx];
		var addCd = "";
		var addVal = "";
		for ( var idx = 0; idx < rowArray.length; idx++) {
			addCd = addCd + rowArray[idx][3];
			addVal = addVal + rowArray[idx][6];
			if (idx != rowArray.length - 1) {
				addCd = addCd + ",";
				addVal = addVal + ",";
			}
		}
		sheetObj.CellValue(Row, "cmdt_cd") = addCd;
		sheetObj.CellValue(Row, "cmdt_nm") = addVal;
	} else if (Row == 0) {
		sheetObj.CellValue(Row, "cmdt_cd") = '';
		sheetObj.CellValue(Row, "cmdt_nm") = '';
	}
}
/*
 * cmpb_ony_flg �꽭�똿
 */
function setCmpbOnyFlg(sheetObj) {
	with (sheetObj) {
		var sRow = FindStatusRow("I|U");
		var arrRow = sRow.split(";");
		for ( var idx = 0; idx < arrRow.length - 1; idx++) {
			if (CellValue(arrRow[idx], "cmpb_amt") != '') {//cmpb
				var colName = "";
				CellValue2(arrRow[idx], "cmpb_ony_flg") = 'Y';
				//Trunk POL/POD遺��꽣 aply_fm_yrwk�쟾源뚯�
				for ( var j = 8; j < LastCol ; j++) {
					colName = ColSaveName(j);
					if(colName == "aply_fm_yrwk" ) break;
					//Hidden而щ읆�씠 �븘�땲怨�
					if (CellValue(arrRow[idx], "cmpb_ony_flg") != 'N' && colName != "cmpb_amt" && CellValue(arrRow[idx], j) != '' && !ColHidden(j)) {
						CellValue2(arrRow[idx], "cmpb_ony_flg") = 'N';
					}
				}
			}//cmpb
		}//for
	}//with
}
/* 媛쒕컻�옄 �옉�뾽  �걹 */
