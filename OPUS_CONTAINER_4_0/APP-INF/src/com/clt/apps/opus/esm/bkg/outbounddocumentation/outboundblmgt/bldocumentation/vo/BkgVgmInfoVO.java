/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgVgmInfoVO.java
*@FileTitle : BkgVgmInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BkgVgmInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgVgmInfoVO> models = new ArrayList<BkgVgmInfoVO>();
	
	/* Column Info */
	private String esigCoNm = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String custEmlSndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custEmlFlg = null;
	/* Column Info */
	private String vgmClzFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String vgmCreLoclDt = null;
	/* Column Info */
	private String payldWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vgmWgtUpdDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vgmCutOffDt = null;
	/* Column Info */
	private String vgmSeq = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String vgmCreGdt = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String actTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTareWgt = null;
	/* Column Info */
	private String xterVgmRqstCd = null;
	/* Column Info */
	private String vgmWgtUpdUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgVgmInfoVO() {}

	public BkgVgmInfoVO(String ibflag, String pagerows, String vgmWgt, String vgmWgtUtCd, String vgmClzFlg, String vgmWgtUpdDt, String vgmWgtUpdUsrId, String bkgNo, String cntrNo, String usrId, String vgmSeq, String actTpCd, String xterVgmRqstCd, String wgtUtCd, String cntrTareWgt, String esigCoNm, String vgmCutOffDt, String custEml, String custEmlFlg, String custEmlSndDt, String vgmCreGdt, String vgmCreLoclDt, String creUsrId, String creDt, String updUsrId, String updDt, String payldWgt, String ifFlg) {
		this.esigCoNm = esigCoNm;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.creDt = creDt;
		this.vgmWgt = vgmWgt;
		this.custEmlSndDt = custEmlSndDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.custEmlFlg = custEmlFlg;
		this.vgmClzFlg = vgmClzFlg;
		this.usrId = usrId;
		this.wgtUtCd = wgtUtCd;
		this.vgmCreLoclDt = vgmCreLoclDt;
		this.payldWgt = payldWgt;
		this.updUsrId = updUsrId;
		this.vgmWgtUpdDt = vgmWgtUpdDt;
		this.updDt = updDt;
		this.vgmCutOffDt = vgmCutOffDt;
		this.vgmSeq = vgmSeq;
		this.ifFlg = ifFlg;
		this.vgmCreGdt = vgmCreGdt;
		this.custEml = custEml;
		this.actTpCd = actTpCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.cntrTareWgt = cntrTareWgt;
		this.xterVgmRqstCd = xterVgmRqstCd;
		this.vgmWgtUpdUsrId = vgmWgtUpdUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("esig_co_nm", getEsigCoNm());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("cust_eml_snd_dt", getCustEmlSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_eml_flg", getCustEmlFlg());
		this.hashColumns.put("vgm_clz_flg", getVgmClzFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("vgm_cre_locl_dt", getVgmCreLoclDt());
		this.hashColumns.put("payld_wgt", getPayldWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vgm_wgt_upd_dt", getVgmWgtUpdDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vgm_cut_off_dt", getVgmCutOffDt());
		this.hashColumns.put("vgm_seq", getVgmSeq());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("vgm_cre_gdt", getVgmCreGdt());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("act_tp_cd", getActTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tare_wgt", getCntrTareWgt());
		this.hashColumns.put("xter_vgm_rqst_cd", getXterVgmRqstCd());
		this.hashColumns.put("vgm_wgt_upd_usr_id", getVgmWgtUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("esig_co_nm", "esigCoNm");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("cust_eml_snd_dt", "custEmlSndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_eml_flg", "custEmlFlg");
		this.hashFields.put("vgm_clz_flg", "vgmClzFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("vgm_cre_locl_dt", "vgmCreLoclDt");
		this.hashFields.put("payld_wgt", "payldWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vgm_wgt_upd_dt", "vgmWgtUpdDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vgm_cut_off_dt", "vgmCutOffDt");
		this.hashFields.put("vgm_seq", "vgmSeq");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("vgm_cre_gdt", "vgmCreGdt");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("act_tp_cd", "actTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tare_wgt", "cntrTareWgt");
		this.hashFields.put("xter_vgm_rqst_cd", "xterVgmRqstCd");
		this.hashFields.put("vgm_wgt_upd_usr_id", "vgmWgtUpdUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return esigCoNm
	 */
	public String getEsigCoNm() {
		return this.esigCoNm;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
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
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return custEmlSndDt
	 */
	public String getCustEmlSndDt() {
		return this.custEmlSndDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return custEmlFlg
	 */
	public String getCustEmlFlg() {
		return this.custEmlFlg;
	}
	
	/**
	 * Column Info
	 * @return vgmClzFlg
	 */
	public String getVgmClzFlg() {
		return this.vgmClzFlg;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return vgmCreLoclDt
	 */
	public String getVgmCreLoclDt() {
		return this.vgmCreLoclDt;
	}
	
	/**
	 * Column Info
	 * @return payldWgt
	 */
	public String getPayldWgt() {
		return this.payldWgt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUpdDt
	 */
	public String getVgmWgtUpdDt() {
		return this.vgmWgtUpdDt;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return vgmCutOffDt
	 */
	public String getVgmCutOffDt() {
		return this.vgmCutOffDt;
	}
	
	/**
	 * Column Info
	 * @return vgmSeq
	 */
	public String getVgmSeq() {
		return this.vgmSeq;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return vgmCreGdt
	 */
	public String getVgmCreGdt() {
		return this.vgmCreGdt;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 * Column Info
	 * @return actTpCd
	 */
	public String getActTpCd() {
		return this.actTpCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTareWgt
	 */
	public String getCntrTareWgt() {
		return this.cntrTareWgt;
	}
	
	/**
	 * Column Info
	 * @return xterVgmRqstCd
	 */
	public String getXterVgmRqstCd() {
		return this.xterVgmRqstCd;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUpdUsrId
	 */
	public String getVgmWgtUpdUsrId() {
		return this.vgmWgtUpdUsrId;
	}
	

	/**
	 * Column Info
	 * @param esigCoNm
	 */
	public void setEsigCoNm(String esigCoNm) {
		this.esigCoNm = esigCoNm;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
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
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param custEmlSndDt
	 */
	public void setCustEmlSndDt(String custEmlSndDt) {
		this.custEmlSndDt = custEmlSndDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param custEmlFlg
	 */
	public void setCustEmlFlg(String custEmlFlg) {
		this.custEmlFlg = custEmlFlg;
	}
	
	/**
	 * Column Info
	 * @param vgmClzFlg
	 */
	public void setVgmClzFlg(String vgmClzFlg) {
		this.vgmClzFlg = vgmClzFlg;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param vgmCreLoclDt
	 */
	public void setVgmCreLoclDt(String vgmCreLoclDt) {
		this.vgmCreLoclDt = vgmCreLoclDt;
	}
	
	/**
	 * Column Info
	 * @param payldWgt
	 */
	public void setPayldWgt(String payldWgt) {
		this.payldWgt = payldWgt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUpdDt
	 */
	public void setVgmWgtUpdDt(String vgmWgtUpdDt) {
		this.vgmWgtUpdDt = vgmWgtUpdDt;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param vgmCutOffDt
	 */
	public void setVgmCutOffDt(String vgmCutOffDt) {
		this.vgmCutOffDt = vgmCutOffDt;
	}
	
	/**
	 * Column Info
	 * @param vgmSeq
	 */
	public void setVgmSeq(String vgmSeq) {
		this.vgmSeq = vgmSeq;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param vgmCreGdt
	 */
	public void setVgmCreGdt(String vgmCreGdt) {
		this.vgmCreGdt = vgmCreGdt;
	}
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * Column Info
	 * @param actTpCd
	 */
	public void setActTpCd(String actTpCd) {
		this.actTpCd = actTpCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTareWgt
	 */
	public void setCntrTareWgt(String cntrTareWgt) {
		this.cntrTareWgt = cntrTareWgt;
	}
	
	/**
	 * Column Info
	 * @param xterVgmRqstCd
	 */
	public void setXterVgmRqstCd(String xterVgmRqstCd) {
		this.xterVgmRqstCd = xterVgmRqstCd;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUpdUsrId
	 */
	public void setVgmWgtUpdUsrId(String vgmWgtUpdUsrId) {
		this.vgmWgtUpdUsrId = vgmWgtUpdUsrId;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setEsigCoNm(JSPUtil.getParameter(request, prefix + "esig_co_nm", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setCustEmlSndDt(JSPUtil.getParameter(request, prefix + "cust_eml_snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustEmlFlg(JSPUtil.getParameter(request, prefix + "cust_eml_flg", ""));
		setVgmClzFlg(JSPUtil.getParameter(request, prefix + "vgm_clz_flg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setVgmCreLoclDt(JSPUtil.getParameter(request, prefix + "vgm_cre_locl_dt", ""));
		setPayldWgt(JSPUtil.getParameter(request, prefix + "payld_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVgmWgtUpdDt(JSPUtil.getParameter(request, prefix + "vgm_wgt_upd_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVgmCutOffDt(JSPUtil.getParameter(request, prefix + "vgm_cut_off_dt", ""));
		setVgmSeq(JSPUtil.getParameter(request, prefix + "vgm_seq", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setVgmCreGdt(JSPUtil.getParameter(request, prefix + "vgm_cre_gdt", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setActTpCd(JSPUtil.getParameter(request, prefix + "act_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTareWgt(JSPUtil.getParameter(request, prefix + "cntr_tare_wgt", ""));
		setXterVgmRqstCd(JSPUtil.getParameter(request, prefix + "xter_vgm_rqst_cd", ""));
		setVgmWgtUpdUsrId(JSPUtil.getParameter(request, prefix + "vgm_wgt_upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgVgmInfoVO[]
	 */
	public BkgVgmInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgVgmInfoVO[]
	 */
	public BkgVgmInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgVgmInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] esigCoNm = (JSPUtil.getParameter(request, prefix	+ "esig_co_nm", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] custEmlSndDt = (JSPUtil.getParameter(request, prefix	+ "cust_eml_snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custEmlFlg = (JSPUtil.getParameter(request, prefix	+ "cust_eml_flg", length));
			String[] vgmClzFlg = (JSPUtil.getParameter(request, prefix	+ "vgm_clz_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] vgmCreLoclDt = (JSPUtil.getParameter(request, prefix	+ "vgm_cre_locl_dt", length));
			String[] payldWgt = (JSPUtil.getParameter(request, prefix	+ "payld_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vgmWgtUpdDt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_upd_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vgmCutOffDt = (JSPUtil.getParameter(request, prefix	+ "vgm_cut_off_dt", length));
			String[] vgmSeq = (JSPUtil.getParameter(request, prefix	+ "vgm_seq", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] vgmCreGdt = (JSPUtil.getParameter(request, prefix	+ "vgm_cre_gdt", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] actTpCd = (JSPUtil.getParameter(request, prefix	+ "act_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTareWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_tare_wgt", length));
			String[] xterVgmRqstCd = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_rqst_cd", length));
			String[] vgmWgtUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgVgmInfoVO();
				if (esigCoNm[i] != null)
					model.setEsigCoNm(esigCoNm[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (custEmlSndDt[i] != null)
					model.setCustEmlSndDt(custEmlSndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custEmlFlg[i] != null)
					model.setCustEmlFlg(custEmlFlg[i]);
				if (vgmClzFlg[i] != null)
					model.setVgmClzFlg(vgmClzFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (vgmCreLoclDt[i] != null)
					model.setVgmCreLoclDt(vgmCreLoclDt[i]);
				if (payldWgt[i] != null)
					model.setPayldWgt(payldWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vgmWgtUpdDt[i] != null)
					model.setVgmWgtUpdDt(vgmWgtUpdDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vgmCutOffDt[i] != null)
					model.setVgmCutOffDt(vgmCutOffDt[i]);
				if (vgmSeq[i] != null)
					model.setVgmSeq(vgmSeq[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (vgmCreGdt[i] != null)
					model.setVgmCreGdt(vgmCreGdt[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (actTpCd[i] != null)
					model.setActTpCd(actTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTareWgt[i] != null)
					model.setCntrTareWgt(cntrTareWgt[i]);
				if (xterVgmRqstCd[i] != null)
					model.setXterVgmRqstCd(xterVgmRqstCd[i]);
				if (vgmWgtUpdUsrId[i] != null)
					model.setVgmWgtUpdUsrId(vgmWgtUpdUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgVgmInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgVgmInfoVO[]
	 */
	public BkgVgmInfoVO[] getBkgVgmInfoVOs(){
		BkgVgmInfoVO[] vos = (BkgVgmInfoVO[])models.toArray(new BkgVgmInfoVO[models.size()]);
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
		this.esigCoNm = this.esigCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEmlSndDt = this.custEmlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEmlFlg = this.custEmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzFlg = this.vgmClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCreLoclDt = this.vgmCreLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payldWgt = this.payldWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUpdDt = this.vgmWgtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCutOffDt = this.vgmCutOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSeq = this.vgmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCreGdt = this.vgmCreGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTpCd = this.actTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTareWgt = this.cntrTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmRqstCd = this.xterVgmRqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUpdUsrId = this.vgmWgtUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
