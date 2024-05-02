/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DblEdiInVO.java
*@FileTitle : DblEdiInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.30 김영출 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DblEdiInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DblEdiInVO> models = new ArrayList<DblEdiInVO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String descChk = null;
	/* Column Info */
	private String blDt = null;
	/* Column Info */
	private String ediReceiveIdOld = null;
	/* Column Info */
	private String slctFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediSender = null;
	/* Column Info */
	private String emlSendDt = null;
	/* Column Info */
	private String rank = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pkgChk = null;
	/* Column Info */
	private String refCode = null;
	/* Column Info */
	private String blOfc = null;
	/* Column Info */
	private String groupEdiId = null;
	/* Column Info */
	private String autoManualFlg = null;
	/* Column Info */
	private String ntcKndNm = null;
	/* Column Info */
	private String cntrCheck = null;
	/* Column Info */
	private String ediReceiveId = null;
	/* Column Info */
	private String blIsuChk = null;
	/* Column Info */
	private String finalEta = null;
	/* Column Info */
	private String ibSeq = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String groupEdiCust = null;
	/* Column Info */
	private String funcCode = null;
	/* Column Info */
	private String groupNm = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String tmpCnt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeChk = null;
	/* Column Info */
	private String blPkgWord = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String ibNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DblEdiInVO() {}

	public DblEdiInVO(String ibflag, String pagerows, String bkgNo, String slctFlg, String ntcKndNm, String rank, String refCode, String ediReceiveIdOld, String ediReceiveId, String ediSender, String emlSendDt, String groupEdiCust, String groupEdiId, String groupNm, String result, String cneeChk, String pkgChk, String descChk, String cntrCheck, String blNo, String blDt, String blOfc, String blIsuChk, String blTpCd, String blPkgWord, String ibNo, String ibSeq, String autoManualFlg, String preRlyPortCd, String pstRlyPortCd, String finalEta, String funcCode, String tmpCnt) {
		this.result = result;
		this.descChk = descChk;
		this.blDt = blDt;
		this.ediReceiveIdOld = ediReceiveIdOld;
		this.slctFlg = slctFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ediSender = ediSender;
		this.emlSendDt = emlSendDt;
		this.rank = rank;
		this.ibflag = ibflag;
		this.pkgChk = pkgChk;
		this.refCode = refCode;
		this.blOfc = blOfc;
		this.groupEdiId = groupEdiId;
		this.autoManualFlg = autoManualFlg;
		this.ntcKndNm = ntcKndNm;
		this.cntrCheck = cntrCheck;
		this.ediReceiveId = ediReceiveId;
		this.blIsuChk = blIsuChk;
		this.finalEta = finalEta;
		this.ibSeq = ibSeq;
		this.preRlyPortCd = preRlyPortCd;
		this.groupEdiCust = groupEdiCust;
		this.funcCode = funcCode;
		this.groupNm = groupNm;
		this.blTpCd = blTpCd;
		this.tmpCnt = tmpCnt;
		this.bkgNo = bkgNo;
		this.cneeChk = cneeChk;
		this.blPkgWord = blPkgWord;
		this.pstRlyPortCd = pstRlyPortCd;
		this.ibNo = ibNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("desc_chk", getDescChk());
		this.hashColumns.put("bl_dt", getBlDt());
		this.hashColumns.put("edi_receive_id_old", getEdiReceiveIdOld());
		this.hashColumns.put("slct_flg", getSlctFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_sender", getEdiSender());
		this.hashColumns.put("eml_send_dt", getEmlSendDt());
		this.hashColumns.put("rank", getRank());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pkg_chk", getPkgChk());
		this.hashColumns.put("ref_code", getRefCode());
		this.hashColumns.put("bl_ofc", getBlOfc());
		this.hashColumns.put("group_edi_id", getGroupEdiId());
		this.hashColumns.put("auto_manual_flg", getAutoManualFlg());
		this.hashColumns.put("ntc_knd_nm", getNtcKndNm());
		this.hashColumns.put("cntr_check", getCntrCheck());
		this.hashColumns.put("edi_receive_id", getEdiReceiveId());
		this.hashColumns.put("bl_isu_chk", getBlIsuChk());
		this.hashColumns.put("final_eta", getFinalEta());
		this.hashColumns.put("ib_seq", getIbSeq());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("group_edi_cust", getGroupEdiCust());
		this.hashColumns.put("func_code", getFuncCode());
		this.hashColumns.put("group_nm", getGroupNm());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("tmp_cnt", getTmpCnt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_chk", getCneeChk());
		this.hashColumns.put("bl_pkg_word", getBlPkgWord());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("ib_no", getIbNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("desc_chk", "descChk");
		this.hashFields.put("bl_dt", "blDt");
		this.hashFields.put("edi_receive_id_old", "ediReceiveIdOld");
		this.hashFields.put("slct_flg", "slctFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_sender", "ediSender");
		this.hashFields.put("eml_send_dt", "emlSendDt");
		this.hashFields.put("rank", "rank");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pkg_chk", "pkgChk");
		this.hashFields.put("ref_code", "refCode");
		this.hashFields.put("bl_ofc", "blOfc");
		this.hashFields.put("group_edi_id", "groupEdiId");
		this.hashFields.put("auto_manual_flg", "autoManualFlg");
		this.hashFields.put("ntc_knd_nm", "ntcKndNm");
		this.hashFields.put("cntr_check", "cntrCheck");
		this.hashFields.put("edi_receive_id", "ediReceiveId");
		this.hashFields.put("bl_isu_chk", "blIsuChk");
		this.hashFields.put("final_eta", "finalEta");
		this.hashFields.put("ib_seq", "ibSeq");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("group_edi_cust", "groupEdiCust");
		this.hashFields.put("func_code", "funcCode");
		this.hashFields.put("group_nm", "groupNm");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("tmp_cnt", "tmpCnt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_chk", "cneeChk");
		this.hashFields.put("bl_pkg_word", "blPkgWord");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("ib_no", "ibNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return descChk
	 */
	public String getDescChk() {
		return this.descChk;
	}
	
	/**
	 * Column Info
	 * @return blDt
	 */
	public String getBlDt() {
		return this.blDt;
	}
	
	/**
	 * Column Info
	 * @return ediReceiveIdOld
	 */
	public String getEdiReceiveIdOld() {
		return this.ediReceiveIdOld;
	}
	
	/**
	 * Column Info
	 * @return slctFlg
	 */
	public String getSlctFlg() {
		return this.slctFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ediSender
	 */
	public String getEdiSender() {
		return this.ediSender;
	}
	
	/**
	 * Column Info
	 * @return emlSendDt
	 */
	public String getEmlSendDt() {
		return this.emlSendDt;
	}
	
	/**
	 * Column Info
	 * @return rank
	 */
	public String getRank() {
		return this.rank;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return pkgChk
	 */
	public String getPkgChk() {
		return this.pkgChk;
	}
	
	/**
	 * Column Info
	 * @return refCode
	 */
	public String getRefCode() {
		return this.refCode;
	}
	
	/**
	 * Column Info
	 * @return blOfc
	 */
	public String getBlOfc() {
		return this.blOfc;
	}
	
	/**
	 * Column Info
	 * @return groupEdiId
	 */
	public String getGroupEdiId() {
		return this.groupEdiId;
	}
	
	/**
	 * Column Info
	 * @return autoManualFlg
	 */
	public String getAutoManualFlg() {
		return this.autoManualFlg;
	}
	
	/**
	 * Column Info
	 * @return ntcKndNm
	 */
	public String getNtcKndNm() {
		return this.ntcKndNm;
	}
	
	/**
	 * Column Info
	 * @return cntrCheck
	 */
	public String getCntrCheck() {
		return this.cntrCheck;
	}
	
	/**
	 * Column Info
	 * @return ediReceiveId
	 */
	public String getEdiReceiveId() {
		return this.ediReceiveId;
	}
	
	/**
	 * Column Info
	 * @return blIsuChk
	 */
	public String getBlIsuChk() {
		return this.blIsuChk;
	}
	
	/**
	 * Column Info
	 * @return finalEta
	 */
	public String getFinalEta() {
		return this.finalEta;
	}
	
	/**
	 * Column Info
	 * @return ibSeq
	 */
	public String getIbSeq() {
		return this.ibSeq;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return groupEdiCust
	 */
	public String getGroupEdiCust() {
		return this.groupEdiCust;
	}
	
	/**
	 * Column Info
	 * @return funcCode
	 */
	public String getFuncCode() {
		return this.funcCode;
	}
	
	/**
	 * Column Info
	 * @return groupNm
	 */
	public String getGroupNm() {
		return this.groupNm;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return tmpCnt
	 */
	public String getTmpCnt() {
		return this.tmpCnt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cneeChk
	 */
	public String getCneeChk() {
		return this.cneeChk;
	}
	
	/**
	 * Column Info
	 * @return blPkgWord
	 */
	public String getBlPkgWord() {
		return this.blPkgWord;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return ibNo
	 */
	public String getIbNo() {
		return this.ibNo;
	}
	

	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param descChk
	 */
	public void setDescChk(String descChk) {
		this.descChk = descChk;
	}
	
	/**
	 * Column Info
	 * @param blDt
	 */
	public void setBlDt(String blDt) {
		this.blDt = blDt;
	}
	
	/**
	 * Column Info
	 * @param ediReceiveIdOld
	 */
	public void setEdiReceiveIdOld(String ediReceiveIdOld) {
		this.ediReceiveIdOld = ediReceiveIdOld;
	}
	
	/**
	 * Column Info
	 * @param slctFlg
	 */
	public void setSlctFlg(String slctFlg) {
		this.slctFlg = slctFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ediSender
	 */
	public void setEdiSender(String ediSender) {
		this.ediSender = ediSender;
	}
	
	/**
	 * Column Info
	 * @param emlSendDt
	 */
	public void setEmlSendDt(String emlSendDt) {
		this.emlSendDt = emlSendDt;
	}
	
	/**
	 * Column Info
	 * @param rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param pkgChk
	 */
	public void setPkgChk(String pkgChk) {
		this.pkgChk = pkgChk;
	}
	
	/**
	 * Column Info
	 * @param refCode
	 */
	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}
	
	/**
	 * Column Info
	 * @param blOfc
	 */
	public void setBlOfc(String blOfc) {
		this.blOfc = blOfc;
	}
	
	/**
	 * Column Info
	 * @param groupEdiId
	 */
	public void setGroupEdiId(String groupEdiId) {
		this.groupEdiId = groupEdiId;
	}
	
	/**
	 * Column Info
	 * @param autoManualFlg
	 */
	public void setAutoManualFlg(String autoManualFlg) {
		this.autoManualFlg = autoManualFlg;
	}
	
	/**
	 * Column Info
	 * @param ntcKndNm
	 */
	public void setNtcKndNm(String ntcKndNm) {
		this.ntcKndNm = ntcKndNm;
	}
	
	/**
	 * Column Info
	 * @param cntrCheck
	 */
	public void setCntrCheck(String cntrCheck) {
		this.cntrCheck = cntrCheck;
	}
	
	/**
	 * Column Info
	 * @param ediReceiveId
	 */
	public void setEdiReceiveId(String ediReceiveId) {
		this.ediReceiveId = ediReceiveId;
	}
	
	/**
	 * Column Info
	 * @param blIsuChk
	 */
	public void setBlIsuChk(String blIsuChk) {
		this.blIsuChk = blIsuChk;
	}
	
	/**
	 * Column Info
	 * @param finalEta
	 */
	public void setFinalEta(String finalEta) {
		this.finalEta = finalEta;
	}
	
	/**
	 * Column Info
	 * @param ibSeq
	 */
	public void setIbSeq(String ibSeq) {
		this.ibSeq = ibSeq;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param groupEdiCust
	 */
	public void setGroupEdiCust(String groupEdiCust) {
		this.groupEdiCust = groupEdiCust;
	}
	
	/**
	 * Column Info
	 * @param funcCode
	 */
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	
	/**
	 * Column Info
	 * @param groupNm
	 */
	public void setGroupNm(String groupNm) {
		this.groupNm = groupNm;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param tmpCnt
	 */
	public void setTmpCnt(String tmpCnt) {
		this.tmpCnt = tmpCnt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cneeChk
	 */
	public void setCneeChk(String cneeChk) {
		this.cneeChk = cneeChk;
	}
	
	/**
	 * Column Info
	 * @param blPkgWord
	 */
	public void setBlPkgWord(String blPkgWord) {
		this.blPkgWord = blPkgWord;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param ibNo
	 */
	public void setIbNo(String ibNo) {
		this.ibNo = ibNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setResult(JSPUtil.getParameter(request, "result", ""));
		setDescChk(JSPUtil.getParameter(request, "desc_chk", ""));
		setBlDt(JSPUtil.getParameter(request, "bl_dt", ""));
		setEdiReceiveIdOld(JSPUtil.getParameter(request, "edi_receive_id_old", ""));
		setSlctFlg(JSPUtil.getParameter(request, "slct_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEdiSender(JSPUtil.getParameter(request, "edi_sender", ""));
		setEmlSendDt(JSPUtil.getParameter(request, "eml_send_dt", ""));
		setRank(JSPUtil.getParameter(request, "rank", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPkgChk(JSPUtil.getParameter(request, "pkg_chk", ""));
		setRefCode(JSPUtil.getParameter(request, "ref_code", ""));
		setBlOfc(JSPUtil.getParameter(request, "bl_ofc", ""));
		setGroupEdiId(JSPUtil.getParameter(request, "group_edi_id", ""));
		setAutoManualFlg(JSPUtil.getParameter(request, "auto_manual_flg", ""));
		setNtcKndNm(JSPUtil.getParameter(request, "ntc_knd_nm", ""));
		setCntrCheck(JSPUtil.getParameter(request, "cntr_check", ""));
		setEdiReceiveId(JSPUtil.getParameter(request, "edi_receive_id", ""));
		setBlIsuChk(JSPUtil.getParameter(request, "bl_isu_chk", ""));
		setFinalEta(JSPUtil.getParameter(request, "final_eta", ""));
		setIbSeq(JSPUtil.getParameter(request, "ib_seq", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setGroupEdiCust(JSPUtil.getParameter(request, "group_edi_cust", ""));
		setFuncCode(JSPUtil.getParameter(request, "func_code", ""));
		setGroupNm(JSPUtil.getParameter(request, "group_nm", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setTmpCnt(JSPUtil.getParameter(request, "tmp_cnt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCneeChk(JSPUtil.getParameter(request, "cnee_chk", ""));
		setBlPkgWord(JSPUtil.getParameter(request, "bl_pkg_word", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setIbNo(JSPUtil.getParameter(request, "ib_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DblEdiInVO[]
	 */
	public DblEdiInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DblEdiInVO[]
	 */
	public DblEdiInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DblEdiInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] descChk = (JSPUtil.getParameter(request, prefix	+ "desc_chk", length));
			String[] blDt = (JSPUtil.getParameter(request, prefix	+ "bl_dt", length));
			String[] ediReceiveIdOld = (JSPUtil.getParameter(request, prefix	+ "edi_receive_id_old", length));
			String[] slctFlg = (JSPUtil.getParameter(request, prefix	+ "slct_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediSender = (JSPUtil.getParameter(request, prefix	+ "edi_sender", length));
			String[] emlSendDt = (JSPUtil.getParameter(request, prefix	+ "eml_send_dt", length));
			String[] rank = (JSPUtil.getParameter(request, prefix	+ "rank", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pkgChk = (JSPUtil.getParameter(request, prefix	+ "pkg_chk", length));
			String[] refCode = (JSPUtil.getParameter(request, prefix	+ "ref_code", length));
			String[] blOfc = (JSPUtil.getParameter(request, prefix	+ "bl_ofc", length));
			String[] groupEdiId = (JSPUtil.getParameter(request, prefix	+ "group_edi_id", length));
			String[] autoManualFlg = (JSPUtil.getParameter(request, prefix	+ "auto_manual_flg", length));
			String[] ntcKndNm = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_nm", length));
			String[] cntrCheck = (JSPUtil.getParameter(request, prefix	+ "cntr_check", length));
			String[] ediReceiveId = (JSPUtil.getParameter(request, prefix	+ "edi_receive_id", length));
			String[] blIsuChk = (JSPUtil.getParameter(request, prefix	+ "bl_isu_chk", length));
			String[] finalEta = (JSPUtil.getParameter(request, prefix	+ "final_eta", length));
			String[] ibSeq = (JSPUtil.getParameter(request, prefix	+ "ib_seq", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] groupEdiCust = (JSPUtil.getParameter(request, prefix	+ "group_edi_cust", length));
			String[] funcCode = (JSPUtil.getParameter(request, prefix	+ "func_code", length));
			String[] groupNm = (JSPUtil.getParameter(request, prefix	+ "group_nm", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] tmpCnt = (JSPUtil.getParameter(request, prefix	+ "tmp_cnt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeChk = (JSPUtil.getParameter(request, prefix	+ "cnee_chk", length));
			String[] blPkgWord = (JSPUtil.getParameter(request, prefix	+ "bl_pkg_word", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] ibNo = (JSPUtil.getParameter(request, prefix	+ "ib_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DblEdiInVO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (descChk[i] != null)
					model.setDescChk(descChk[i]);
				if (blDt[i] != null)
					model.setBlDt(blDt[i]);
				if (ediReceiveIdOld[i] != null)
					model.setEdiReceiveIdOld(ediReceiveIdOld[i]);
				if (slctFlg[i] != null)
					model.setSlctFlg(slctFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediSender[i] != null)
					model.setEdiSender(ediSender[i]);
				if (emlSendDt[i] != null)
					model.setEmlSendDt(emlSendDt[i]);
				if (rank[i] != null)
					model.setRank(rank[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pkgChk[i] != null)
					model.setPkgChk(pkgChk[i]);
				if (refCode[i] != null)
					model.setRefCode(refCode[i]);
				if (blOfc[i] != null)
					model.setBlOfc(blOfc[i]);
				if (groupEdiId[i] != null)
					model.setGroupEdiId(groupEdiId[i]);
				if (autoManualFlg[i] != null)
					model.setAutoManualFlg(autoManualFlg[i]);
				if (ntcKndNm[i] != null)
					model.setNtcKndNm(ntcKndNm[i]);
				if (cntrCheck[i] != null)
					model.setCntrCheck(cntrCheck[i]);
				if (ediReceiveId[i] != null)
					model.setEdiReceiveId(ediReceiveId[i]);
				if (blIsuChk[i] != null)
					model.setBlIsuChk(blIsuChk[i]);
				if (finalEta[i] != null)
					model.setFinalEta(finalEta[i]);
				if (ibSeq[i] != null)
					model.setIbSeq(ibSeq[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (groupEdiCust[i] != null)
					model.setGroupEdiCust(groupEdiCust[i]);
				if (funcCode[i] != null)
					model.setFuncCode(funcCode[i]);
				if (groupNm[i] != null)
					model.setGroupNm(groupNm[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (tmpCnt[i] != null)
					model.setTmpCnt(tmpCnt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeChk[i] != null)
					model.setCneeChk(cneeChk[i]);
				if (blPkgWord[i] != null)
					model.setBlPkgWord(blPkgWord[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (ibNo[i] != null)
					model.setIbNo(ibNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDblEdiInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DblEdiInVO[]
	 */
	public DblEdiInVO[] getDblEdiInVOs(){
		DblEdiInVO[] vos = (DblEdiInVO[])models.toArray(new DblEdiInVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descChk = this.descChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDt = this.blDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediReceiveIdOld = this.ediReceiveIdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slctFlg = this.slctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSender = this.ediSender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSendDt = this.emlSendDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rank = this.rank .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgChk = this.pkgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refCode = this.refCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOfc = this.blOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupEdiId = this.groupEdiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoManualFlg = this.autoManualFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndNm = this.ntcKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCheck = this.cntrCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediReceiveId = this.ediReceiveId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIsuChk = this.blIsuChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalEta = this.finalEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSeq = this.ibSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupEdiCust = this.groupEdiCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCode = this.funcCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupNm = this.groupNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpCnt = this.tmpCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeChk = this.cneeChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPkgWord = this.blPkgWord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibNo = this.ibNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
