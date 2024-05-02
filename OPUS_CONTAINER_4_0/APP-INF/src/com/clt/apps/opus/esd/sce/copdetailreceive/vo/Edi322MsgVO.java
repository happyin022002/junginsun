/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi322MsgVO.java
*@FileTitle : Edi322MsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copdetailreceive.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi322MsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi322MsgVO> models = new ArrayList<Edi322MsgVO>();
	
	/* Column Info */
	private String spclHndlCd = null;
	/* Column Info */
	private String bkgEdi322No = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String lloydVslNo = null;
	/* Column Info */
	private String rcvrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chssEdi322No = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String pkupEdi322No = null;
	/* Column Info */
	private String sndrId = null;
	/* Column Info */
	private String railDestN1stEtaDt = null;
	/* Column Info */
	private String blEdi322No = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String evntSteCd = null;
	/* Column Info */
	private String psnCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String evntCtyNm = null;
	/* Column Info */
	private String edi322StsCd = null;
	/* Column Info */
	private String eqDescCd = null;
	/* Column Info */
	private String vslVoyDirNo = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String evntCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi322MsgVO() {}

	public Edi322MsgVO(String ibflag, String pagerows, String evntDt, String eqNo, String edi322StsCd, String sndrId, String rcvrId, String evntYdCd, String evntCtyNm, String evntSteCd, String evntCntCd, String eqDescCd, String eqStsCd, String chssEdi322No, String vslCd, String lloydVslNo, String vslNm, String vslVoyDirNo, String spclHndlCd, String blEdi322No, String bkgEdi322No, String creDt, String psnCd, String pkupEdi322No, String errMsg, String railDestN1stEtaDt) {
		this.spclHndlCd = spclHndlCd;
		this.bkgEdi322No = bkgEdi322No;
		this.vslCd = vslCd;
		this.lloydVslNo = lloydVslNo;
		this.rcvrId = rcvrId;
		this.creDt = creDt;
		this.chssEdi322No = chssEdi322No;
		this.pagerows = pagerows;
		this.eqStsCd = eqStsCd;
		this.ibflag = ibflag;
		this.evntYdCd = evntYdCd;
		this.eqNo = eqNo;
		this.pkupEdi322No = pkupEdi322No;
		this.sndrId = sndrId;
		this.railDestN1stEtaDt = railDestN1stEtaDt;
		this.blEdi322No = blEdi322No;
		this.evntDt = evntDt;
		this.evntSteCd = evntSteCd;
		this.psnCd = psnCd;
		this.vslNm = vslNm;
		this.evntCtyNm = evntCtyNm;
		this.edi322StsCd = edi322StsCd;
		this.eqDescCd = eqDescCd;
		this.vslVoyDirNo = vslVoyDirNo;
		this.errMsg = errMsg;
		this.evntCntCd = evntCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spcl_hndl_cd", getSpclHndlCd());
		this.hashColumns.put("bkg_edi_322_no", getBkgEdi322No());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("lloyd_vsl_no", getLloydVslNo());
		this.hashColumns.put("rcvr_id", getRcvrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chss_edi_322_no", getChssEdi322No());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_sts_cd", getEqStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("pkup_edi_322_no", getPkupEdi322No());
		this.hashColumns.put("sndr_id", getSndrId());
		this.hashColumns.put("rail_dest_n1st_eta_dt", getRailDestN1stEtaDt());
		this.hashColumns.put("bl_edi_322_no", getBlEdi322No());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("evnt_ste_cd", getEvntSteCd());
		this.hashColumns.put("psn_cd", getPsnCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("evnt_cty_nm", getEvntCtyNm());
		this.hashColumns.put("edi_322_sts_cd", getEdi322StsCd());
		this.hashColumns.put("eq_desc_cd", getEqDescCd());
		this.hashColumns.put("vsl_voy_dir_no", getVslVoyDirNo());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("evnt_cnt_cd", getEvntCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spcl_hndl_cd", "spclHndlCd");
		this.hashFields.put("bkg_edi_322_no", "bkgEdi322No");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("lloyd_vsl_no", "lloydVslNo");
		this.hashFields.put("rcvr_id", "rcvrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chss_edi_322_no", "chssEdi322No");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_sts_cd", "eqStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("pkup_edi_322_no", "pkupEdi322No");
		this.hashFields.put("sndr_id", "sndrId");
		this.hashFields.put("rail_dest_n1st_eta_dt", "railDestN1stEtaDt");
		this.hashFields.put("bl_edi_322_no", "blEdi322No");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("evnt_ste_cd", "evntSteCd");
		this.hashFields.put("psn_cd", "psnCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("evnt_cty_nm", "evntCtyNm");
		this.hashFields.put("edi_322_sts_cd", "edi322StsCd");
		this.hashFields.put("eq_desc_cd", "eqDescCd");
		this.hashFields.put("vsl_voy_dir_no", "vslVoyDirNo");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("evnt_cnt_cd", "evntCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return spclHndlCd
	 */
	public String getSpclHndlCd() {
		return this.spclHndlCd;
	}
	
	/**
	 * Column Info
	 * @return bkgEdi322No
	 */
	public String getBkgEdi322No() {
		return this.bkgEdi322No;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return lloydVslNo
	 */
	public String getLloydVslNo() {
		return this.lloydVslNo;
	}
	
	/**
	 * Column Info
	 * @return rcvrId
	 */
	public String getRcvrId() {
		return this.rcvrId;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return chssEdi322No
	 */
	public String getChssEdi322No() {
		return this.chssEdi322No;
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
	 * @return eqStsCd
	 */
	public String getEqStsCd() {
		return this.eqStsCd;
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
	 * @return evntYdCd
	 */
	public String getEvntYdCd() {
		return this.evntYdCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return pkupEdi322No
	 */
	public String getPkupEdi322No() {
		return this.pkupEdi322No;
	}
	
	/**
	 * Column Info
	 * @return sndrId
	 */
	public String getSndrId() {
		return this.sndrId;
	}
	
	/**
	 * Column Info
	 * @return railDestN1stEtaDt
	 */
	public String getRailDestN1stEtaDt() {
		return this.railDestN1stEtaDt;
	}
	
	/**
	 * Column Info
	 * @return blEdi322No
	 */
	public String getBlEdi322No() {
		return this.blEdi322No;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return evntSteCd
	 */
	public String getEvntSteCd() {
		return this.evntSteCd;
	}
	
	/**
	 * Column Info
	 * @return psnCd
	 */
	public String getPsnCd() {
		return this.psnCd;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return evntCtyNm
	 */
	public String getEvntCtyNm() {
		return this.evntCtyNm;
	}
	
	/**
	 * Column Info
	 * @return edi322StsCd
	 */
	public String getEdi322StsCd() {
		return this.edi322StsCd;
	}
	
	/**
	 * Column Info
	 * @return eqDescCd
	 */
	public String getEqDescCd() {
		return this.eqDescCd;
	}
	
	/**
	 * Column Info
	 * @return vslVoyDirNo
	 */
	public String getVslVoyDirNo() {
		return this.vslVoyDirNo;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return evntCntCd
	 */
	public String getEvntCntCd() {
		return this.evntCntCd;
	}
	

	/**
	 * Column Info
	 * @param spclHndlCd
	 */
	public void setSpclHndlCd(String spclHndlCd) {
		this.spclHndlCd = spclHndlCd;
	}
	
	/**
	 * Column Info
	 * @param bkgEdi322No
	 */
	public void setBkgEdi322No(String bkgEdi322No) {
		this.bkgEdi322No = bkgEdi322No;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param lloydVslNo
	 */
	public void setLloydVslNo(String lloydVslNo) {
		this.lloydVslNo = lloydVslNo;
	}
	
	/**
	 * Column Info
	 * @param rcvrId
	 */
	public void setRcvrId(String rcvrId) {
		this.rcvrId = rcvrId;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param chssEdi322No
	 */
	public void setChssEdi322No(String chssEdi322No) {
		this.chssEdi322No = chssEdi322No;
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
	 * @param eqStsCd
	 */
	public void setEqStsCd(String eqStsCd) {
		this.eqStsCd = eqStsCd;
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
	 * @param evntYdCd
	 */
	public void setEvntYdCd(String evntYdCd) {
		this.evntYdCd = evntYdCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param pkupEdi322No
	 */
	public void setPkupEdi322No(String pkupEdi322No) {
		this.pkupEdi322No = pkupEdi322No;
	}
	
	/**
	 * Column Info
	 * @param sndrId
	 */
	public void setSndrId(String sndrId) {
		this.sndrId = sndrId;
	}
	
	/**
	 * Column Info
	 * @param railDestN1stEtaDt
	 */
	public void setRailDestN1stEtaDt(String railDestN1stEtaDt) {
		this.railDestN1stEtaDt = railDestN1stEtaDt;
	}
	
	/**
	 * Column Info
	 * @param blEdi322No
	 */
	public void setBlEdi322No(String blEdi322No) {
		this.blEdi322No = blEdi322No;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param evntSteCd
	 */
	public void setEvntSteCd(String evntSteCd) {
		this.evntSteCd = evntSteCd;
	}
	
	/**
	 * Column Info
	 * @param psnCd
	 */
	public void setPsnCd(String psnCd) {
		this.psnCd = psnCd;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param evntCtyNm
	 */
	public void setEvntCtyNm(String evntCtyNm) {
		this.evntCtyNm = evntCtyNm;
	}
	
	/**
	 * Column Info
	 * @param edi322StsCd
	 */
	public void setEdi322StsCd(String edi322StsCd) {
		this.edi322StsCd = edi322StsCd;
	}
	
	/**
	 * Column Info
	 * @param eqDescCd
	 */
	public void setEqDescCd(String eqDescCd) {
		this.eqDescCd = eqDescCd;
	}
	
	/**
	 * Column Info
	 * @param vslVoyDirNo
	 */
	public void setVslVoyDirNo(String vslVoyDirNo) {
		this.vslVoyDirNo = vslVoyDirNo;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param evntCntCd
	 */
	public void setEvntCntCd(String evntCntCd) {
		this.evntCntCd = evntCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSpclHndlCd(JSPUtil.getParameter(request, "spcl_hndl_cd", ""));
		setBkgEdi322No(JSPUtil.getParameter(request, "bkg_edi_322_no", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setLloydVslNo(JSPUtil.getParameter(request, "lloyd_vsl_no", ""));
		setRcvrId(JSPUtil.getParameter(request, "rcvr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setChssEdi322No(JSPUtil.getParameter(request, "chss_edi_322_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqStsCd(JSPUtil.getParameter(request, "eq_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEvntYdCd(JSPUtil.getParameter(request, "evnt_yd_cd", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setPkupEdi322No(JSPUtil.getParameter(request, "pkup_edi_322_no", ""));
		setSndrId(JSPUtil.getParameter(request, "sndr_id", ""));
		setRailDestN1stEtaDt(JSPUtil.getParameter(request, "rail_dest_n1st_eta_dt", ""));
		setBlEdi322No(JSPUtil.getParameter(request, "bl_edi_322_no", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setEvntSteCd(JSPUtil.getParameter(request, "evnt_ste_cd", ""));
		setPsnCd(JSPUtil.getParameter(request, "psn_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEvntCtyNm(JSPUtil.getParameter(request, "evnt_cty_nm", ""));
		setEdi322StsCd(JSPUtil.getParameter(request, "edi_322_sts_cd", ""));
		setEqDescCd(JSPUtil.getParameter(request, "eq_desc_cd", ""));
		setVslVoyDirNo(JSPUtil.getParameter(request, "vsl_voy_dir_no", ""));
		setErrMsg(JSPUtil.getParameter(request, "err_msg", ""));
		setEvntCntCd(JSPUtil.getParameter(request, "evnt_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi322MsgVO[]
	 */
	public Edi322MsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi322MsgVO[]
	 */
	public Edi322MsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi322MsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spclHndlCd = (JSPUtil.getParameter(request, prefix	+ "spcl_hndl_cd", length));
			String[] bkgEdi322No = (JSPUtil.getParameter(request, prefix	+ "bkg_edi_322_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] lloydVslNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_vsl_no", length));
			String[] rcvrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chssEdi322No = (JSPUtil.getParameter(request, prefix	+ "chss_edi_322_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] pkupEdi322No = (JSPUtil.getParameter(request, prefix	+ "pkup_edi_322_no", length));
			String[] sndrId = (JSPUtil.getParameter(request, prefix	+ "sndr_id", length));
			String[] railDestN1stEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_dest_n1st_eta_dt", length));
			String[] blEdi322No = (JSPUtil.getParameter(request, prefix	+ "bl_edi_322_no", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] evntSteCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ste_cd", length));
			String[] psnCd = (JSPUtil.getParameter(request, prefix	+ "psn_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] evntCtyNm = (JSPUtil.getParameter(request, prefix	+ "evnt_cty_nm", length));
			String[] edi322StsCd = (JSPUtil.getParameter(request, prefix	+ "edi_322_sts_cd", length));
			String[] eqDescCd = (JSPUtil.getParameter(request, prefix	+ "eq_desc_cd", length));
			String[] vslVoyDirNo = (JSPUtil.getParameter(request, prefix	+ "vsl_voy_dir_no", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] evntCntCd = (JSPUtil.getParameter(request, prefix	+ "evnt_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi322MsgVO();
				if (spclHndlCd[i] != null)
					model.setSpclHndlCd(spclHndlCd[i]);
				if (bkgEdi322No[i] != null)
					model.setBkgEdi322No(bkgEdi322No[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (lloydVslNo[i] != null)
					model.setLloydVslNo(lloydVslNo[i]);
				if (rcvrId[i] != null)
					model.setRcvrId(rcvrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chssEdi322No[i] != null)
					model.setChssEdi322No(chssEdi322No[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqStsCd[i] != null)
					model.setEqStsCd(eqStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (pkupEdi322No[i] != null)
					model.setPkupEdi322No(pkupEdi322No[i]);
				if (sndrId[i] != null)
					model.setSndrId(sndrId[i]);
				if (railDestN1stEtaDt[i] != null)
					model.setRailDestN1stEtaDt(railDestN1stEtaDt[i]);
				if (blEdi322No[i] != null)
					model.setBlEdi322No(blEdi322No[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (evntSteCd[i] != null)
					model.setEvntSteCd(evntSteCd[i]);
				if (psnCd[i] != null)
					model.setPsnCd(psnCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (evntCtyNm[i] != null)
					model.setEvntCtyNm(evntCtyNm[i]);
				if (edi322StsCd[i] != null)
					model.setEdi322StsCd(edi322StsCd[i]);
				if (eqDescCd[i] != null)
					model.setEqDescCd(eqDescCd[i]);
				if (vslVoyDirNo[i] != null)
					model.setVslVoyDirNo(vslVoyDirNo[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (evntCntCd[i] != null)
					model.setEvntCntCd(evntCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi322MsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi322MsgVO[]
	 */
	public Edi322MsgVO[] getEdi322MsgVOs(){
		Edi322MsgVO[] vos = (Edi322MsgVO[])models.toArray(new Edi322MsgVO[models.size()]);
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
		this.spclHndlCd = this.spclHndlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEdi322No = this.bkgEdi322No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydVslNo = this.lloydVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrId = this.rcvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssEdi322No = this.chssEdi322No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqStsCd = this.eqStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupEdi322No = this.pkupEdi322No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrId = this.sndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDestN1stEtaDt = this.railDestN1stEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blEdi322No = this.blEdi322No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntSteCd = this.evntSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psnCd = this.psnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntCtyNm = this.evntCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi322StsCd = this.edi322StsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDescCd = this.eqDescCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVoyDirNo = this.vslVoyDirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntCntCd = this.evntCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
