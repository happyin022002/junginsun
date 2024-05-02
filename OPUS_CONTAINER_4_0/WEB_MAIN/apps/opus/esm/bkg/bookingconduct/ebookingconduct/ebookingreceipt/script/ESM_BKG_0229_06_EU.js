/* OPUS 조회 DATA 1=Mst,2=Dtl */
var opusSheetObjects = new Array(); 
/* OPUS 수정 DATA 1=Mst,2=Dtl */
var opusMdfSheetObjects = new Array();
/* Xter 조회 DATA 1=Mst,2=Dtl */
var xterSheetObjects = new Array();
/* OPUS Select Seq */
var opusSelectSeq = 1;

/* 화면 필드 명 */
var eur_opus_seq = "eur_opus_seq";

/* OPUS &b Xter 키 설정 */
var diff_rmk = "diff_rmk";
var tro_seq = "tro_seq";
var tro_sub_seq = "tro_sub_seq";

/* OPUS 키 설정 */
var cntr_tpsz_cd = "cntr_tpsz_cd";
var dor_addr = "dor_addr";
var dor_zip_id = "dor_zip_id";
var cntc_phn_no = "cntc_phn_no";
var cntc_eml = "cntc_eml";
var dor_arr_dt = "dor_arr_dt";
var cntc_pson_nm = "cntc_pson_nm";
var addr0 = "addr0";
var addr1 = "addr1";
var addr2 = "addr2";
var addr3 = "addr3";
var dorOffDt = "dorOffDt";
var dorOffHh = "dorOffHh";
var dorOffMm = "dorOffMm";

/* xter 키 설정 */
var eur_tro_cntr_tpsz_cd = "eur_tro_cntr_tpsz_cd";
var eur_tro_dor_addr = "eur_tro_dor_addr";
var eur_tro_cntc_pson_nm = "eur_tro_cntc_pson_nm";
var eur_tro_dor_zip_id = "eur_tro_dor_zip_id";
var eur_tro_cntc_phn_no = "eur_tro_cntc_phn_no";
var eur_tro_cntc_eml = "eur_tro_cntc_eml";
var dor_rqst_dt = "dor_rqst_dt";
var addrLength = 50;

function eurView(sheetObjects, obj, opener){

	top.document.form.tabload6.value = "LOAD";
	
	/* opus Mst */
	opusSheetObjects[0] = sheetObjects[2];
	/* opus dtl */
	opusSheetObjects[1] = sheetObjects[0];
	
	opusMdfSheetObjects[0] = sheetObjects[4];
	opusMdfSheetObjects[1] = sheetObjects[5];
	
	/* Xter Mst */
	xterSheetObjects[0] = sheetObjects[3];
	/* Xter dtl */
	xterSheetObjects[1] = sheetObjects[1];
	
	var eurOpus = document.getElementById("eur_opus");
	eurOpus.style.display = '';
	
	/* Opus */
	var opusSeq = document.getElementById(eur_opus_seq);
	opusSeq.innerHTML = "";
	for (var i = 0; i < opusMdfSheetObjects[0].RowCount(); i++) {
		opusSeq.innerHTML += '<option value="' + (i+1) + '">' + (i+1) + '</option>'
	}
	if(opusMdfSheetObjects[0].RowCount() > 0){
		opusTroDtl(1, opusMdfSheetObjects[0], opusMdfSheetObjects[1]);
	}
	
	/* e - Service */
	var xterSeq = document.getElementById("eur_xter_seq");
	xterSeq.innerHTML = "";
	for (var j=0; j<xterSheetObjects[0].RowCount(); j++){
		xterSeq.innerHTML += '<option value="' + (j+1) + '">' + (j+1) + '</option>'
	}
	if(xterSheetObjects[0].RowCount() > 0){
		eServiceTroDtl(1);
	}
}

/**
 * From e- Service SEQ select box 변경 시 seq에 동일한 TRO 정보로 변경해준다. 
 * @param seqObj
 */
function xterchange_seq(seq){
	eServiceTroDtl(seq);
}

/**
 * OPUS Booking SEQ select box 변경 시 seq에 동일한 TRO 정보로 변경해준다. 
 * @param seqObj
 */
function opuschange_seq(seq){
	/* 선택된 값이 동일하지 않으면 값이 변경됐다고 생각하고 해당 값을 opusMdfSheetObjects 등록을 한다. */
	if(seq != opusSelectSeq){
		setOpusMdfSheetObject();
	}
	/* opusMdfSheetObjects null이 아니면 Data Copy to Opus 클릭한 상태이다. */
	opusTroDtl(seq, opusMdfSheetObjects[0], opusMdfSheetObjects[1]);
	opusSelectSeq = seq;
}

/**
 * 수정 내용을 저장한다.
 */
function setOpusMdfSheetObject(){
	var opusTroDtlDiv = document.getElementById("opusTroDtlDiv");
	var childList = opusTroDtlDiv.childNodes;
	/* MST 저장 */
	for (var i = 1; i <= opusMdfSheetObjects[0].RowCount(); i++) {
		if(opusSelectSeq == opusMdfSheetObjects[0].GetCellValue(i, tro_seq)){
			opusMdfSheetObjects[0].SetCellValue(i, cntr_tpsz_cd, document.getElementById("cntrTpszCd").value);
			opusMdfSheetObjects[0].SetCellValue(i, diff_rmk, document.getElementById("diffRmk").value);
		}
	}
	
	/* DTL 저장 */
	for (var j = 0; j < childList.length; j++) {
		for (var i = 1; i <= opusMdfSheetObjects[1].RowCount(); i++) {
			
			if(opusSelectSeq == opusMdfSheetObjects[1].GetCellValue(i, tro_seq) && (j+1) == opusMdfSheetObjects[1].GetCellValue(i, tro_sub_seq)){
				var dorAddr, dorRqstDt;
				var inputs = childList[j].getElementsByTagName("input");
				for (var o = 0; o < inputs.length; o++) {
					/* Postal / Zip Code */
					if(inputs[o].id == dor_zip_id) opusMdfSheetObjects[1].SetCellValue(i, dor_zip_id, inputs[o].value);
					/* Phone No.# */
					if(inputs[o].id == cntc_phn_no) opusMdfSheetObjects[1].SetCellValue(i, cntc_phn_no, inputs[o].value);
					/* E - Mail */
					if(inputs[o].id == cntc_eml) opusMdfSheetObjects[1].SetCellValue(i, cntc_eml, inputs[o].value);
					/* Contact Person */
					if(inputs[o].id == cntc_pson_nm) opusMdfSheetObjects[1].SetCellValue(i, cntc_pson_nm, inputs[o].value);
					/* Drop-Off Date */
					if(inputs[o].id == dorOffDt + (j+1)) dorRqstDt = inputs[o].value;
					/* Drop-Off Date */
					if(inputs[o].id == dorOffHh && inputs[o].value != "") dorRqstDt += " " + inputs[o].value;
					/* Drop-Off Date */
					if(inputs[o].id == dorOffMm && inputs[o].value != "") dorRqstDt += ":" + inputs[o].value;
					/* dor_addr */
					if(inputs[o].id == addr0) dorAddr = padding_right(inputs[o].value, " ", 50);
					/* dor_addr */
					if(inputs[o].id == addr1) dorAddr += padding_right(inputs[o].value, " ", 50);
					/* dor_addr */
					if(inputs[o].id == addr2) dorAddr += padding_right(inputs[o].value, " ", 50);
					/* dor_addr */
					if(inputs[o].id == addr3) dorAddr += padding_right(inputs[o].value, " ", 50);
				}
				opusMdfSheetObjects[1].SetCellValue(i, dor_addr, dorAddr);
				opusMdfSheetObjects[1].SetCellValue(i, dor_arr_dt, dorRqstDt);
			}
		}
	}
}

/**
 * Booking Data OPUS 데이타를 초기화 한다.
 */
function opusCancel(){
	var opusSeq = document.getElementById(eur_opus_seq);
	opusSeq.innerHTML = "";
	for (var i = 0; i < opusSheetObjects[0].RowCount(); i++) {
		opusSeq.innerHTML += '<option value="' + (i+1) + '">' + (i+1) + '</option>'
	}
	opusTroDtl(1, opusSheetObjects[0], opusSheetObjects[1]);
	opusMdfSheetObjects[0].LoadSearchData(xmlData[4], {Sync:1});
	opusMdfSheetObjects[1].LoadSearchData(xmlData[5], {Sync:1});
	
	var opusSeq = document.getElementById('rmkTable');
	opusSeq.style.display = "none";
}

/**
 * xtro Data -> opus Data 복사한다.
 */
function xtroCopy(){
	/* xtroSheetObj 필드명과 opusSheetObj 필드명이 동일하지 않기때문에 DATA 셋팅해준다. */
	xtroToOpusMdf();
	var opusSeq = document.getElementById(eur_opus_seq);
	opusSeq.innerHTML = "";
	for (var i = 0; i < opusMdfSheetObjects[0].RowCount(); i++) {
		opusSeq.innerHTML += '<option value="' + (i+1) + '">' + (i+1) + '</option>'
	}
	/* html 생성 */
	opuschange_seq(1);
	
	/* TRO 구주일때 Booking Sratus = '' and R/D = CY 일때  Internal Remark(s) data copy 한다. */
	var opener = window.dialogArguments;
	if (!opener) opener = parent;
	var formObj = document.form;
	var eurTroDorAddr = xterSheetObjects[1].GetCellValue(1, eur_tro_dor_addr);
	var rmk = "";
	if(eurTroDorAddr.substring(0, addrLength).trim() != ""){
		rmk += eurTroDorAddr.substring(0, addrLength).trim();
	} 
	if(eurTroDorAddr.substring(addrLength,addrLength*2).trim() != ""){
		rmk += "\n" + eurTroDorAddr.substring(addrLength,addrLength*2).trim();
	} 
	if(eurTroDorAddr.substring(addrLength*2,addrLength*3).trim() != ""){
		rmk += "\n" + eurTroDorAddr.substring(addrLength*2,addrLength*3).trim();
	} 
	if(eurTroDorAddr.substring(addrLength*3,addrLength*4).trim() != ""){
		rmk += "\n" + eurTroDorAddr.substring(addrLength*3,addrLength*4).trim();
	}
	opener.t1frame.internalRemarkCopy(rmk);
}

/**
 * xtroSheetObj 필드명과 opusSheetObj 필드명이 동일하지 않기때문에 DATA 셋팅해준다.
 */
function xtroToOpusMdf(){
	/* 데이타 삭제 */
	opusMdfSheetObjects[0].RemoveAll();
	opusMdfSheetObjects[1].RemoveAll();
	
	/* MST Type/Size */
	for (var i = 1; i <= xterSheetObjects[0].RowCount(); i++) {
		var newRow = opusMdfSheetObjects[0].DataInsert(-1);
		opusMdfSheetObjects[0].SetCellValue(newRow, tro_seq, xterSheetObjects[0].GetCellValue(i, tro_seq));
		
		opusMdfSheetObjects[0].SetCellValue(newRow, "xter_tro_seq", xterSheetObjects[0].GetCellValue(i, tro_seq));
		
		opusMdfSheetObjects[0].SetCellValue(newRow, cntr_tpsz_cd, xterSheetObjects[0].GetCellValue(i, eur_tro_cntr_tpsz_cd));
		opusMdfSheetObjects[0].SetCellValue(newRow, diff_rmk, xterSheetObjects[0].GetCellValue(i, diff_rmk));
	}
	
	/* DTL List */
	for (var i = 1; i <= xterSheetObjects[1].RowCount(); i++) {
		var newRow = opusMdfSheetObjects[1].DataInsert(-1);
		opusMdfSheetObjects[1].SetCellValue(newRow, tro_seq, xterSheetObjects[1].GetCellValue(i, tro_seq));
		opusMdfSheetObjects[1].SetCellValue(newRow, "xter_tro_seq", xterSheetObjects[1].GetCellValue(i, tro_seq));

		opusMdfSheetObjects[1].SetCellValue(newRow, tro_sub_seq, xterSheetObjects[1].GetCellValue(i, tro_sub_seq));
		opusMdfSheetObjects[1].SetCellValue(newRow, "xter_tro_sub_seq", xterSheetObjects[1].GetCellValue(i, tro_sub_seq));
		
		/* Supplier's Name, Address */
		opusMdfSheetObjects[1].SetCellValue(newRow, dor_addr, xterSheetObjects[1].GetCellValue(i, eur_tro_dor_addr));
		/* Contact Person */
		opusMdfSheetObjects[1].SetCellValue(newRow, cntc_pson_nm, xterSheetObjects[1].GetCellValue(i, eur_tro_cntc_pson_nm));
		/* Postal / Zip Code */
		opusMdfSheetObjects[1].SetCellValue(newRow, dor_zip_id, xterSheetObjects[1].GetCellValue(i, eur_tro_dor_zip_id));
		/* Phone No.# */
		opusMdfSheetObjects[1].SetCellValue(newRow, cntc_phn_no, xterSheetObjects[1].GetCellValue(i, eur_tro_cntc_phn_no));
		/* E - Mail */
		opusMdfSheetObjects[1].SetCellValue(newRow, cntc_eml, xterSheetObjects[1].GetCellValue(i, eur_tro_cntc_eml));
		/* Drop-Off Date */
		opusMdfSheetObjects[1].SetCellValue(newRow, dor_arr_dt, xterSheetObjects[1].GetCellValue(i, dor_rqst_dt));
	}
}

/**
 * Booking Data OPUS
 * 현재 SEQ data 삭제
 */
function opusSeqDelete(){
	var opusSeq = document.getElementById(eur_opus_seq);
	/* Seq length == 1 이면 삭제하지 말고 DATA 초기화 화면은 유지 */
	if(opusSeq.length == 1){
		opusMdfSheetObjects[0].RemoveAll();
		opusMdfSheetObjects[1].RemoveAll();
		/* MST DATA */
		var mstRow = opusMdfSheetObjects[0].DataInsert(-1);
		/* tro Seq */
		opusMdfSheetObjects[0].SetCellValue(mstRow, tro_seq, 1);
		/* Type/Size */
		opusMdfSheetObjects[0].SetCellValue(mstRow, cntr_tpsz_cd, '');
		/* DTL DATA */
		var dtlRow = opusMdfSheetObjects[1].DataInsert(-1);
		opusMdfSheetObjects[1].SetCellValue(dtlRow, tro_seq, 1);
		opusMdfSheetObjects[1].SetCellValue(dtlRow, tro_sub_seq, 1);
		/* html 생성 */
		opuschange_seq(1);
	}
	else{
		var selectSeq = opusSeq.value;
		/* MST Tro Seq */
		var troSeq = opusMdfSheetObjects[0].GetCellValue(selectSeq, tro_seq);
		/* MST SEQ 삭제 */
		opusMdfSheetObjects[0].RowDelete(parseInt(selectSeq));
		
		/* DTL 삭제 */
		for (var i = 1; i <= opusMdfSheetObjects[1].RowCount(); i++) {
			if(opusMdfSheetObjects[1].GetCellValue(i, tro_seq) == troSeq){
				opusMdfSheetObjects[1].RowDelete(i);
			}
		}
		
		opusSeq.innerHTML = "";
		for (var i = 0; i < opusMdfSheetObjects[0].RowCount(); i++) {
			opusSeq.innerHTML += '<option value="' + (i+1) + '">' + (i+1) + '</option>'
		}
		/* html 생성 */
		opuschange_seq(1);
	}
}

/**
 * Booking Data OPUS
 * SEQ data 추가
 */
function opusSeqAdd(){
	var opusSeq = document.getElementById(eur_opus_seq);
	var lastTroSeq = opusMdfSheetObjects[0].GetCellValue(opusMdfSheetObjects[0].RowCount(), tro_seq);
	
	/* MST DATA */
	var mstRow = opusMdfSheetObjects[0].DataInsert(-1);
	
	/* tro Seq */
	opusMdfSheetObjects[0].SetCellValue(mstRow, tro_seq, parseInt(lastTroSeq) + 1);
	/* Type/Size */
	
	/* DTL DATA */
	var dtlRow = opusMdfSheetObjects[1].DataInsert(-1);
	opusMdfSheetObjects[1].SetCellValue(dtlRow, tro_seq, parseInt(lastTroSeq) + 1);
	opusMdfSheetObjects[1].SetCellValue(dtlRow, tro_sub_seq, 1);
	
	/* html 생성 */
	opuschange_seq((opusSeq.length+1));
	opusSeq.innerHTML += '<option value="' + (opusSeq.length+1) + '" selected="selected">' + (opusSeq.length+1) + '</option>'
	
	var opusSeq = document.getElementById('rmkTable');
	opusSeq.style.display = "";
}

/**
 * OPUS TRO DTL
 * @param troSeq
 */
function opusTroDtl(troSeq, mstObj, dtlObj){
	document.form.cntrTpszCd.value = mstObj.GetCellValue(troSeq, cntr_tpsz_cd);
	document.form.diffRmk.value = mstObj.GetCellValue(troSeq, diff_rmk);
	document.getElementById('opusTroDtlDiv').innerHTML = "";
	if(opusSheetObjects[0].GetCellValue(troSeq, "request_result") != -1){
		document.getElementById("request_result").innerText = opusSheetObjects[0].GetCellValue(troSeq, "request_result");
	}else{
		document.getElementById("request_result").innerText = "";
	}
	for (var i = 1; i <= dtlObj.RowCount(); i++) {
		var mstTroSeq = mstObj.GetCellValue(troSeq, tro_seq);
		var dtlTroSeq = dtlObj.GetCellValue(i, tro_seq);
		if(mstTroSeq == dtlTroSeq){
			var eurTroDorAddr, cntcPsonNm, dorZipId, cntcPhnNo, cntcEml, dorRqstDt, troSubSeq;
			eurTroDorAddr = dtlObj.GetCellValue(i, dor_addr);
			cntcPsonNm = dtlObj.GetCellValue(i, cntc_pson_nm);
			dorZipId = dtlObj.GetCellValue(i, dor_zip_id);
			cntcPhnNo = dtlObj.GetCellValue(i, cntc_phn_no);
			cntcEml = dtlObj.GetCellValue(i, cntc_eml);
			dorRqstDt = dtlObj.GetCellValue(i, dor_arr_dt);
			troSubSeq = dtlObj.GetCellValue(i, tro_sub_seq);
			var readonly, calsses;
			readonly = '';
			calsses = 'class="input1"';
			document.getElementById('opusTroDtlDiv').innerHTML += troDtlDiv(eurTroDorAddr, cntcPsonNm, dorZipId, cntcPhnNo, cntcEml, dorRqstDt, readonly, calsses, troSubSeq);
		}
	}
}

/**
 * From e- Service DTL 
 * @param troSeq
 */
function eServiceTroDtl(troSeq){
	document.form.eur_tro_cntr_tpsz_cd.value = xterSheetObjects[0].GetCellValue(troSeq, eur_tro_cntr_tpsz_cd);
	document.form.diff_rmk.value = xterSheetObjects[0].GetCellValue(troSeq, diff_rmk);
	document.getElementById('xterTroDtlDiv').innerHTML = "";
	for (var i = 1; i <= xterSheetObjects[1].RowCount(); i++) {
		var mstTroSeq = xterSheetObjects[0].GetCellValue(troSeq, tro_seq);
		var dtlTroSeq = xterSheetObjects[1].GetCellValue(i, tro_seq);
		if(mstTroSeq == dtlTroSeq){
			var eurTroDorAddr, cntcPsonNm, dorZipId, cntcPhnNo, cntcEml, dorRqstDt, troSubSeq;
			eurTroDorAddr = xterSheetObjects[1].GetCellValue(i, eur_tro_dor_addr);
			cntcPsonNm = xterSheetObjects[1].GetCellValue(i, eur_tro_cntc_pson_nm);
			dorZipId = xterSheetObjects[1].GetCellValue(i, eur_tro_dor_zip_id);
			cntcPhnNo = xterSheetObjects[1].GetCellValue(i, eur_tro_cntc_phn_no);
			cntcEml = xterSheetObjects[1].GetCellValue(i, eur_tro_cntc_eml);
			dorRqstDt = xterSheetObjects[1].GetCellValue(i, dor_rqst_dt);
			troSubSeq = xterSheetObjects[1].GetCellValue(i, tro_sub_seq);
			
			var readonly, calsses;
			readonly = 'readonly="readonly"';
			calsses = '';
			document.getElementById('xterTroDtlDiv').innerHTML += troDtlDiv(eurTroDorAddr, cntcPsonNm, dorZipId, cntcPhnNo, cntcEml, dorRqstDt, readonly, calsses, troSubSeq);
		}
	}
}

/**
 *  OPUS DTL DATA 추가
 */
function opusSubSeqAdd(){
	var opusSeq = document.getElementById(eur_opus_seq);
	var troSeq = parseInt(opusSeq.value);
	
	var opusTroDtlDiv = document.getElementById("opusTroDtlDiv");
//	var subTroSeq = opusTroDtlDiv.childNodes.length;
	
	var dtlRow = opusMdfSheetObjects[1].DataInsert(-1);
	opusMdfSheetObjects[1].SetCellValue(dtlRow, tro_seq, troSeq);
	
	for (var i = 0; i < opusMdfSheetObjects[1].RowCount(); i++) {
		if(troSeq == opusMdfSheetObjects[1].GetCellValue(i, tro_seq)){
			var subTroSeq = opusMdfSheetObjects[1].GetCellValue(i, tro_sub_seq);
			opusMdfSheetObjects[1].SetCellValue(dtlRow, tro_sub_seq, parseInt(subTroSeq)+1);
		}
	}
	opuschange_seq(troSeq);
}

/**
 * OPUS DTL DATA 삭제
 * @param tableId
 */
function opusSubSeqDel(troSubSeq){
	var opusSeq = document.getElementById(eur_opus_seq);
	var troSeq = parseInt(opusSeq.value);
	
	var opusTroDtlDiv = document.getElementById("opusTroDtlDiv");
	var childList = opusTroDtlDiv.childNodes;
	
	/* DTL DATA 삭제 */
	for (var i = 1; i <= opusMdfSheetObjects[1].RowCount(); i++) {
		if(troSeq == opusMdfSheetObjects[1].GetCellValue(i, tro_seq)){
			if(parseInt(troSubSeq) == opusMdfSheetObjects[1].GetCellValue(i, tro_sub_seq)){
				opusMdfSheetObjects[1].RowDelete(i);
			}
		}
	}
	
	/* DATA 삭제 후 화면 리로딩 */
	if(childList.length == 1){
		var dtlRow = opusMdfSheetObjects[1].DataInsert(-1);
		opusMdfSheetObjects[1].SetCellValue(dtlRow, tro_seq, troSeq);
		opusMdfSheetObjects[1].SetCellValue(dtlRow, tro_sub_seq, 1);
		/* html 생성 */
		opuschange_seq(troSeq);
	}
	/* 2건 이상이면 DATA 삭제 후  테이블만 삭제 */
	else{
		var opusTroDtlDiv = document.getElementById('opusTroDtlDiv');
		var subDtl = document.getElementById("opus_" + troSubSeq);
		opusTroDtlDiv.removeChild(subDtl);
	}
}

/**
 * 벨리데이션 체크
 */
function validateSheet(){
	var valueCheck;
	var troSeq = 0;
	/* MST 체크 */
	for (var i = 1; i <= opusMdfSheetObjects[0].RowCount(); i++) {
		/* tro_seq */
		troSeq = opusMdfSheetObjects[0].GetCellValue(i, tro_seq);
		if(valueCheck == '' || valueCheck == -1){
			return troSeq;
		}
		/* cntr_tpsz_cd */
		valueCheck = opusMdfSheetObjects[0].GetCellValue(i, cntr_tpsz_cd);
		if(valueCheck == '' || valueCheck == -1){
			return troSeq;
		}
	}
	
	/* DTL 체크 */
	for (var i = 1; i <= opusMdfSheetObjects[1].RowCount(); i++) {
		/* tro_seq */
		troSeq = opusMdfSheetObjects[1].GetCellValue(i, tro_seq);
		if(valueCheck == '' || valueCheck == -1){
			return troSeq;
		}
		/* dor_addr */
		valueCheck = opusMdfSheetObjects[1].GetCellValue(i, dor_addr);
		if(valueCheck == '' || valueCheck == -1){
			return troSeq;
		}
		/* cntc_pson_nm */
		valueCheck = opusMdfSheetObjects[1].GetCellValue(i, cntc_pson_nm);
		if(valueCheck == '' || valueCheck == -1){
			return troSeq;
		}
		/* dor_arr_dt */
		valueCheck = opusMdfSheetObjects[1].GetCellValue(i, dor_arr_dt);
		if(valueCheck == '' || valueCheck == -1){
			return troSeq;
		}
	}
	
	return troSeq;
}

/**
 * Dtl 정보 html 생성
 * @param seqNum
 * @param sheetObject
 * @returns {String}
 */
function troDtlDiv(eurTroDorAddr, cntcPsonNm, dorZipId, cntcPhnNo, cntcEml, dorRqstDt, readonly, calsses, subSeq){
	var divHtml = "";
	var tableId = "";
	/* OPUS 화면 */
	if(readonly == ''){
		tableId = "opus_" + subSeq;
	}
	
	divHtml += '<table id="' + tableId + '" name="' + tableId + '">';
	divHtml += '<colgroup>';
	divHtml += '	<col width="85">';
	divHtml += '	<col width="200">';
	divHtml += '	<col width="100">';
	divHtml += '	<col width="80">';
	divHtml += '	<col >';
	divHtml += '</colgroup>';
	divHtml += '<tbody>';
	divHtml += '	<tr>';
	divHtml += '		<th>Supplier\'s NM</th>';
	divHtml += '		<td><input type="text" style="width:100%;" id="' + addr0 + '" name="' + addr0 + '" ' + calsses + readonly + '" value="' + eurTroDorAddr.substring(0, addrLength).trim() + '"/></td>';
	divHtml += '		<th>Contact Person</th>';
	divHtml += '		<td colspan="4"><input type="text" style="width:100%;" id="' + cntc_pson_nm + '" name="' + cntc_pson_nm + '" ' + calsses + readonly + '" value="' + cntcPsonNm + '"/></td>';
	divHtml += '	</tr>';
	divHtml += '	<tr>';
	divHtml += '		<th rowspan="3" style="vertical-align:top;line-height:29px;">Address</th>';
	divHtml += '		<td><input type="text" style="width:100%;" id="' + addr1 + '" name="' + addr1 + '" ' + calsses + readonly + '"  value="' + eurTroDorAddr.substring(addrLength,addrLength*2).trim() + '"/></td>';
	divHtml += '		<th>Postal / Zip Code</th>';
	divHtml += '		<td><input type="text" style="width:100%;" id="' + dor_zip_id + '" name="' + dor_zip_id + '" ' + readonly + '" value="' + dorZipId + '"/></td>';
	divHtml += '		<th>Phone No.#</th>';
	divHtml += '		<td><input type="text" style="width:100%;" id="' + cntc_phn_no + '" name="' + cntc_phn_no + '" ' + readonly + '" value="' + cntcPhnNo + '"/></td>';
	divHtml += '	</tr>';
	divHtml += '	<tr>';
	divHtml += '		<td><input type="text" style="width:100%;" id="' + addr2 + '" name="' + addr2 + '" ' + calsses + readonly + '" value="' + eurTroDorAddr.substring(addrLength*2,addrLength*3).trim() + '"/></td>';
	divHtml += '		<th>E - Mail</th>';
	divHtml += '		<td colspan="4"><input type="text" style="width:100%;" id="' + cntc_eml + '" name="' + cntc_eml + '" ' + readonly + '" value="' + cntcEml + '"/></td>';
	divHtml += '	</tr>';
	divHtml += '	<tr>';
	divHtml += '		<td><input type="text" style="width:100%;" id="' + addr3 + '" name="' + addr3 + '" ' + calsses + readonly + '" value="' + eurTroDorAddr.substring(addrLength*3,addrLength*4).trim() + '"/></td>';
	divHtml += '		<th>Drop-Off Date</th>';
	divHtml += '		<td colspan="3">';
	
	var fromDate = null;
	var year = "";
	var month = "";
	var day = ""; 
	var hour = "";
	var minute = "";
	var dropOffDate = "";
	if(dorRqstDt != ''){
		var temp = dorRqstDt.split(" ");
//		year = temp[0].split("-")[0];
//		month = temp[0].split("-")[1];
//		day = temp[0].split("-")[2];
		
		dropOffDate = temp[0].split("-")[0] + "-" + temp[0].split("-")[1] + "-" + temp[0].split("-")[2];
		
		hour = temp[1].split(":")[0];
		minute = temp[1].split(":")[1];
	}
	
	/* OPUS 화면 */
	if(readonly == ''){
		var dtNm = dorOffDt + subSeq;
		divHtml += '			<input type="text" style="width:70px;text-align:center" name="' + dtNm + '" id="' + dtNm + '" ' + calsses + readonly + '" value="' + dropOffDate.trim() + '" maxlength="10" dataformat="ymd" /><!--';
		divHtml += '	     --><button type="button" id="btn_dorOffDt" name="btn_dorOffDt" class="calendar ir" onclick=getCalendar("' + dtNm + '")></button><!--';
	}else{
		divHtml += '		    <input type="text" style="width:74px;text-align:center" ' + calsses + readonly + '" value="' + dropOffDate.trim() + '" maxlength="10" dataformat="ymd" /><!--';
	}
	divHtml += '			--><input type="text" style="width:20px;text-align:center;padding:0;" name="' + dorOffHh + '" id="' + dorOffHh + '" ' + calsses + readonly + '" value="' + hour.trim() + '"/>: <!--';
	divHtml += '			--><input type="text" style="width:20px;text-align:center;padding:0;" name="' + dorOffMm + '" id="' + dorOffMm + '" ' + calsses + readonly + '" value="' + minute.trim() + '"/><!--';
	/* OPUS 화면 */
	if(readonly == ''){
		divHtml += '		--><span class="specialCls"><button type="button" class="btn_etc" style="padding:0;width:32px" onclick=opusSubSeqDel("' + subSeq + '") >Del</button></span>';
	}
	divHtml += '		</td>';
	divHtml += '	</tr>';
	divHtml += '</tbody>';
	divHtml += '</table>';
	return divHtml;
}

/**
 * Drop-Off Date 달력 오픈
 */
function getCalendar(dorOffDtNm){
	var cal = new ComCalendar();
	cal.select(document.getElementById(dorOffDtNm), 'yyyy-MM-dd');
}

function padding_left(s, c, n) {
	if (! s || ! c || s.length >= n) {
		return s;
	}
	var max = (n - s.length)/c.length;
	for (var i = 0; i < max; i++) {
		s = c + s;
	}
	return s;
}
	 
// right padding s with c to a total of n chars
function padding_right(s, c, n) {
	if (! s || ! c || s.length >= n) {
		return s;
	}
	var max = (n - s.length)/c.length;
	for (var i = 0; i < max; i++) {
		s += c;
	}
	return s;
}

String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/gi, "");
}
