/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VndrCntcPntIfVO.java
*@FileTitle : VndrCntcPntIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.vo;

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
public class VndrCntcPntIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VndrCntcPntIfVO> models = new ArrayList<VndrCntcPntIfVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vndrCntcPntIfSeq = null;

	/* Column Info */
	private String vndrSeq = null;

	/* Column Info */
	private String vndrCntcPntSeq = null;

	/* Column Info */
	private String intlPhnNo = null;

	/* Column Info */
	private String phnNo = null;

	/* Column Info */
	private String intlFaxNo = null;

	/* Column Info */
	private String faxNo = null;

	/* Column Info */
	private String cntcDivCd = null;

	/* Column Info */
	private String vndrEml = null;

	/* Column Info */
	private String prmryChkFlg = null;

	/* Column Info */
	private String deltFlg = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/* Column Info */
	private String r3InsfId = null;

	/* Column Info */
	private String r3InsfPrsId = null;

	/* Column Info */
	private String r3InsfDttm = null;

	/* Column Info */
	private String r3InsfCnqeVal = null;

	/* Column Info */
	private String r3InsfDvCd = null;

	/* Column Info */
	private String r3InsfCnqeCont = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VndrCntcPntIfVO() {}

	public VndrCntcPntIfVO(String ibflag, String pagerows, String vndrCntcPntIfSeq, String vndrSeq, String vndrCntcPntSeq, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String cntcDivCd, String vndrEml, String prmryChkFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String r3InsfId, String r3InsfPrsId, String r3InsfDttm, String r3InsfCnqeVal, String r3InsfDvCd, String r3InsfCnqeCont) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vndrCntcPntIfSeq = vndrCntcPntIfSeq;
		this.vndrSeq = vndrSeq;
		this.vndrCntcPntSeq = vndrCntcPntSeq;
		this.intlPhnNo = intlPhnNo;
		this.phnNo = phnNo;
		this.intlFaxNo = intlFaxNo;
		this.faxNo = faxNo;
		this.cntcDivCd = cntcDivCd;
		this.vndrEml = vndrEml;
		this.prmryChkFlg = prmryChkFlg;
		this.deltFlg = deltFlg;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.r3InsfId = r3InsfId;
		this.r3InsfPrsId = r3InsfPrsId;
		this.r3InsfDttm = r3InsfDttm;
		this.r3InsfCnqeVal = r3InsfCnqeVal;
		this.r3InsfDvCd = r3InsfDvCd;
		this.r3InsfCnqeCont = r3InsfCnqeCont;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_cntc_pnt_if_seq", getVndrCntcPntIfSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_cntc_pnt_seq", getVndrCntcPntSeq());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cntc_div_cd", getCntcDivCd());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("r3_insf_id", getR3InsfId());
		this.hashColumns.put("r3_insf_prs_id", getR3InsfPrsId());
		this.hashColumns.put("r3_insf_dttm", getR3InsfDttm());
		this.hashColumns.put("r3_insf_cnqe_val", getR3InsfCnqeVal());
		this.hashColumns.put("r3_insf_dv_cd", getR3InsfDvCd());
		this.hashColumns.put("r3_insf_cnqe_cont", getR3InsfCnqeCont());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_cntc_pnt_if_seq", "vndrCntcPntIfSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cntc_div_cd", "cntcDivCd");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("r3_insf_id", "r3InsfId");
		this.hashFields.put("r3_insf_prs_id", "r3InsfPrsId");
		this.hashFields.put("r3_insf_dttm", "r3InsfDttm");
		this.hashFields.put("r3_insf_cnqe_val", "r3InsfCnqeVal");
		this.hashFields.put("r3_insf_dv_cd", "r3InsfDvCd");
		this.hashFields.put("r3_insf_cnqe_cont", "r3InsfCnqeCont");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String vndrCntcPntIfSeq
	 */
	public void setVndrCntcPntIfSeq(String vndrCntcPntIfSeq) {
		this.vndrCntcPntIfSeq = vndrCntcPntIfSeq;
	}
	
	/**
	 * 
	 * @return String vndrCntcPntIfSeq
	 */
	public String getVndrCntcPntIfSeq() {
		return this.vndrCntcPntIfSeq;
	}
	
	/**
	 *
	 * @param String vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * 
	 * @return String vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 *
	 * @param String vndrCntcPntSeq
	 */
	public void setVndrCntcPntSeq(String vndrCntcPntSeq) {
		this.vndrCntcPntSeq = vndrCntcPntSeq;
	}
	
	/**
	 * 
	 * @return String vndrCntcPntSeq
	 */
	public String getVndrCntcPntSeq() {
		return this.vndrCntcPntSeq;
	}
	
	/**
	 *
	 * @param String intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * 
	 * @return String intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	
	/**
	 *
	 * @param String phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * 
	 * @return String phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 *
	 * @param String intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}
	
	/**
	 * 
	 * @return String intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
	}
	
	/**
	 *
	 * @param String faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * 
	 * @return String faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 *
	 * @param String cntcDivCd
	 */
	public void setCntcDivCd(String cntcDivCd) {
		this.cntcDivCd = cntcDivCd;
	}
	
	/**
	 * 
	 * @return String cntcDivCd
	 */
	public String getCntcDivCd() {
		return this.cntcDivCd;
	}
	
	/**
	 *
	 * @param String vndrEml
	 */
	public void setVndrEml(String vndrEml) {
		this.vndrEml = vndrEml;
	}
	
	/**
	 * 
	 * @return String vndrEml
	 */
	public String getVndrEml() {
		return this.vndrEml;
	}
	
	/**
	 *
	 * @param String prmryChkFlg
	 */
	public void setPrmryChkFlg(String prmryChkFlg) {
		this.prmryChkFlg = prmryChkFlg;
	}
	
	/**
	 * 
	 * @return String prmryChkFlg
	 */
	public String getPrmryChkFlg() {
		return this.prmryChkFlg;
	}
	
	/**
	 *
	 * @param String deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 
	 * @return String deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 *
	 * @param String r3InsfId
	 */
	public void setR3InsfId(String r3InsfId) {
		this.r3InsfId = r3InsfId;
	}
	
	/**
	 * 
	 * @return String r3InsfId
	 */
	public String getR3InsfId() {
		return this.r3InsfId;
	}
	
	/**
	 *
	 * @param String r3InsfPrsId
	 */
	public void setR3InsfPrsId(String r3InsfPrsId) {
		this.r3InsfPrsId = r3InsfPrsId;
	}
	
	/**
	 * 
	 * @return String r3InsfPrsId
	 */
	public String getR3InsfPrsId() {
		return this.r3InsfPrsId;
	}
	
	/**
	 *
	 * @param String r3InsfDttm
	 */
	public void setR3InsfDttm(String r3InsfDttm) {
		this.r3InsfDttm = r3InsfDttm;
	}
	
	/**
	 * 
	 * @return String r3InsfDttm
	 */
	public String getR3InsfDttm() {
		return this.r3InsfDttm;
	}
	
	/**
	 *
	 * @param String r3InsfCnqeVal
	 */
	public void setR3InsfCnqeVal(String r3InsfCnqeVal) {
		this.r3InsfCnqeVal = r3InsfCnqeVal;
	}
	
	/**
	 * 
	 * @return String r3InsfCnqeVal
	 */
	public String getR3InsfCnqeVal() {
		return this.r3InsfCnqeVal;
	}
	
	/**
	 *
	 * @param String r3InsfDvCd
	 */
	public void setR3InsfDvCd(String r3InsfDvCd) {
		this.r3InsfDvCd = r3InsfDvCd;
	}
	
	/**
	 * 
	 * @return String r3InsfDvCd
	 */
	public String getR3InsfDvCd() {
		return this.r3InsfDvCd;
	}
	
	/**
	 *
	 * @param String r3InsfCnqeCont
	 */
	public void setR3InsfCnqeCont(String r3InsfCnqeCont) {
		this.r3InsfCnqeCont = r3InsfCnqeCont;
	}
	
	/**
	 * 
	 * @return String r3InsfCnqeCont
	 */
	public String getR3InsfCnqeCont() {
		return this.r3InsfCnqeCont;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrCntcPntIfSeq(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_if_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrCntcPntSeq(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setCntcDivCd(JSPUtil.getParameter(request, prefix + "cntc_div_cd", ""));
		setVndrEml(JSPUtil.getParameter(request, prefix + "vndr_eml", ""));
		setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setR3InsfId(JSPUtil.getParameter(request, prefix + "r3insf_id", ""));
		setR3InsfPrsId(JSPUtil.getParameter(request, prefix + "r3insf_prs_id", ""));
		setR3InsfDttm(JSPUtil.getParameter(request, prefix + "r3insf_dttm", ""));
		setR3InsfCnqeVal(JSPUtil.getParameter(request, prefix + "r3insf_cnqe_val", ""));
		setR3InsfDvCd(JSPUtil.getParameter(request, prefix + "r3insf_dv_cd", ""));
		setR3InsfCnqeCont(JSPUtil.getParameter(request, prefix + "r3insf_cnqe_cont", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VndrCntcPntIfVO[]
	 */
	public VndrCntcPntIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VndrCntcPntIfVO[]
	 */
	public VndrCntcPntIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VndrCntcPntIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrCntcPntIfSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_if_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_seq", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] cntcDivCd = (JSPUtil.getParameter(request, prefix	+ "cntc_div_cd", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix	+ "prmry_chk_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] r3InsfId = (JSPUtil.getParameter(request, prefix	+ "r3insf_id", length));
			String[] r3InsfPrsId = (JSPUtil.getParameter(request, prefix	+ "r3insf_prs_id", length));
			String[] r3InsfDttm = (JSPUtil.getParameter(request, prefix	+ "r3insf_dttm", length));
			String[] r3InsfCnqeVal = (JSPUtil.getParameter(request, prefix	+ "r3insf_cnqe_val", length));
			String[] r3InsfDvCd = (JSPUtil.getParameter(request, prefix	+ "r3insf_dv_cd", length));
			String[] r3InsfCnqeCont = (JSPUtil.getParameter(request, prefix	+ "r3insf_cnqe_cont", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new VndrCntcPntIfVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (vndrCntcPntIfSeq[i] != null) 
					model.setVndrCntcPntIfSeq(vndrCntcPntIfSeq[i]);
				if (vndrSeq[i] != null) 
					model.setVndrSeq(vndrSeq[i]);
				if (vndrCntcPntSeq[i] != null) 
					model.setVndrCntcPntSeq(vndrCntcPntSeq[i]);
				if (intlPhnNo[i] != null) 
					model.setIntlPhnNo(intlPhnNo[i]);
				if (phnNo[i] != null) 
					model.setPhnNo(phnNo[i]);
				if (intlFaxNo[i] != null) 
					model.setIntlFaxNo(intlFaxNo[i]);
				if (faxNo[i] != null) 
					model.setFaxNo(faxNo[i]);
				if (cntcDivCd[i] != null) 
					model.setCntcDivCd(cntcDivCd[i]);
				if (vndrEml[i] != null) 
					model.setVndrEml(vndrEml[i]);
				if (prmryChkFlg[i] != null) 
					model.setPrmryChkFlg(prmryChkFlg[i]);
				if (deltFlg[i] != null) 
					model.setDeltFlg(deltFlg[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				if (r3InsfId[i] != null) 
					model.setR3InsfId(r3InsfId[i]);
				if (r3InsfPrsId[i] != null) 
					model.setR3InsfPrsId(r3InsfPrsId[i]);
				if (r3InsfDttm[i] != null) 
					model.setR3InsfDttm(r3InsfDttm[i]);
				if (r3InsfCnqeVal[i] != null) 
					model.setR3InsfCnqeVal(r3InsfCnqeVal[i]);
				if (r3InsfDvCd[i] != null) 
					model.setR3InsfDvCd(r3InsfDvCd[i]);
				if (r3InsfCnqeCont[i] != null) 
					model.setR3InsfCnqeCont(r3InsfCnqeCont[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVndrCntcPntIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VndrCntcPntIfVO[]
	 */
	public VndrCntcPntIfVO[] getVndrCntcPntIfVOs(){
		VndrCntcPntIfVO[] vos = (VndrCntcPntIfVO[])models.toArray(new VndrCntcPntIfVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntIfSeq = this.vndrCntcPntIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntSeq = this.vndrCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcDivCd = this.cntcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml = this.vndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmryChkFlg = this.prmryChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfId = this.r3InsfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfPrsId = this.r3InsfPrsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfDttm = this.r3InsfDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfCnqeVal = this.r3InsfCnqeVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfDvCd = this.r3InsfDvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfCnqeCont = this.r3InsfCnqeCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}