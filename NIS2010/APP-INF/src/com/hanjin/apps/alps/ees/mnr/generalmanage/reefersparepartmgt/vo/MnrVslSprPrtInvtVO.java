/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MnrVslSprPrtInvtVO.java
*@FileTitle : MnrVslSprPrtInvtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrVslSprPrtInvtVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	private Collection<MnrVslSprPrtInvtVO> models = new ArrayList<MnrVslSprPrtInvtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sprPrtTpCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String sprPrtInvtSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sprUtShrCd = null;
	/* Column Info */
	private String sprUtMdlNm = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sprPrtInvtNo = null;
	/* Column Info */
	private String sprPrtCrntAmt = null;
	/* Column Info */
	private String sprPrtVndrSeq = null;
	/* Column Info */
	private String sprPrtInvtVerSeq = null;
	/* Column Info */
	private String sprPrtVerSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrVslSprPrtInvtVO() {}

	public MnrVslSprPrtInvtVO(String ibflag, String pagerows, String sprPrtInvtNo, String sprPrtInvtSeq, String sprPrtInvtVerSeq, String laneCd, String vslCd, String vslNm, String crrCd, String sprPrtTpCd, String sprPrtVndrSeq, String sprPrtVerSeq, String vndrNm, String sprUtMdlNm, String sprUtShrCd, String sprPrtCrntAmt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String ofcCd, String fromDt, String toDt) {
		this.updDt = updDt;
		this.sprPrtTpCd = sprPrtTpCd;
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.fromDt = fromDt;
		this.sprPrtInvtSeq = sprPrtInvtSeq;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.sprUtShrCd = sprUtShrCd;
		this.sprUtMdlNm = sprUtMdlNm;
		this.vslNm = vslNm;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.vndrNm = vndrNm;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.sprPrtInvtNo = sprPrtInvtNo;
		this.sprPrtCrntAmt = sprPrtCrntAmt;
		this.sprPrtVndrSeq = sprPrtVndrSeq;
		this.sprPrtInvtVerSeq = sprPrtInvtVerSeq;
		this.sprPrtVerSeq = sprPrtVerSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("spr_prt_tp_cd", getSprPrtTpCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("spr_prt_invt_seq", getSprPrtInvtSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spr_ut_shr_cd", getSprUtShrCd());
		this.hashColumns.put("spr_ut_mdl_nm", getSprUtMdlNm());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spr_prt_invt_no", getSprPrtInvtNo());
		this.hashColumns.put("spr_prt_crnt_amt", getSprPrtCrntAmt());
		this.hashColumns.put("spr_prt_vndr_seq", getSprPrtVndrSeq());
		this.hashColumns.put("spr_prt_invt_ver_seq", getSprPrtInvtVerSeq());
		this.hashColumns.put("spr_prt_ver_seq", getSprPrtVerSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("spr_prt_tp_cd", "sprPrtTpCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("spr_prt_invt_seq", "sprPrtInvtSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spr_ut_shr_cd", "sprUtShrCd");
		this.hashFields.put("spr_ut_mdl_nm", "sprUtMdlNm");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spr_prt_invt_no", "sprPrtInvtNo");
		this.hashFields.put("spr_prt_crnt_amt", "sprPrtCrntAmt");
		this.hashFields.put("spr_prt_vndr_seq", "sprPrtVndrSeq");
		this.hashFields.put("spr_prt_invt_ver_seq", "sprPrtInvtVerSeq");
		this.hashFields.put("spr_prt_ver_seq", "sprPrtVerSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return sprPrtTpCd
	 */
	public String getSprPrtTpCd() {
		return this.sprPrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return sprPrtInvtSeq
	 */
	public String getSprPrtInvtSeq() {
		return this.sprPrtInvtSeq;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return sprUtShrCd
	 */
	public String getSprUtShrCd() {
		return this.sprUtShrCd;
	}
	
	/**
	 * Column Info
	 * @return sprUtMdlNm
	 */
	public String getSprUtMdlNm() {
		return this.sprUtMdlNm;
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
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return sprPrtInvtNo
	 */
	public String getSprPrtInvtNo() {
		return this.sprPrtInvtNo;
	}
	
	/**
	 * Column Info
	 * @return sprPrtCrntAmt
	 */
	public String getSprPrtCrntAmt() {
		return this.sprPrtCrntAmt;
	}
	
	/**
	 * Column Info
	 * @return sprPrtVndrSeq
	 */
	public String getSprPrtVndrSeq() {
		return this.sprPrtVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sprPrtInvtVerSeq
	 */
	public String getSprPrtInvtVerSeq() {
		return this.sprPrtInvtVerSeq;
	}
	
	/**
	 * Column Info
	 * @return sprPrtVerSeq
	 */
	public String getSprPrtVerSeq() {
		return this.sprPrtVerSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param sprPrtTpCd
	 */
	public void setSprPrtTpCd(String sprPrtTpCd) {
		this.sprPrtTpCd = sprPrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param sprPrtInvtSeq
	 */
	public void setSprPrtInvtSeq(String sprPrtInvtSeq) {
		this.sprPrtInvtSeq = sprPrtInvtSeq;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param sprUtShrCd
	 */
	public void setSprUtShrCd(String sprUtShrCd) {
		this.sprUtShrCd = sprUtShrCd;
	}
	
	/**
	 * Column Info
	 * @param sprUtMdlNm
	 */
	public void setSprUtMdlNm(String sprUtMdlNm) {
		this.sprUtMdlNm = sprUtMdlNm;
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
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param sprPrtInvtNo
	 */
	public void setSprPrtInvtNo(String sprPrtInvtNo) {
		this.sprPrtInvtNo = sprPrtInvtNo;
	}
	
	/**
	 * Column Info
	 * @param sprPrtCrntAmt
	 */
	public void setSprPrtCrntAmt(String sprPrtCrntAmt) {
		this.sprPrtCrntAmt = sprPrtCrntAmt;
	}
	
	/**
	 * Column Info
	 * @param sprPrtVndrSeq
	 */
	public void setSprPrtVndrSeq(String sprPrtVndrSeq) {
		this.sprPrtVndrSeq = sprPrtVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sprPrtInvtVerSeq
	 */
	public void setSprPrtInvtVerSeq(String sprPrtInvtVerSeq) {
		this.sprPrtInvtVerSeq = sprPrtInvtVerSeq;
	}
	
	/**
	 * Column Info
	 * @param sprPrtVerSeq
	 */
	public void setSprPrtVerSeq(String sprPrtVerSeq) {
		this.sprPrtVerSeq = sprPrtVerSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSprPrtTpCd(JSPUtil.getParameter(request, prefix + "spr_prt_tp_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setSprPrtInvtSeq(JSPUtil.getParameter(request, prefix + "spr_prt_invt_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSprUtShrCd(JSPUtil.getParameter(request, prefix + "spr_ut_shr_cd", ""));
		setSprUtMdlNm(JSPUtil.getParameter(request, prefix + "spr_ut_mdl_nm", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSprPrtInvtNo(JSPUtil.getParameter(request, prefix + "spr_prt_invt_no", ""));
		setSprPrtCrntAmt(JSPUtil.getParameter(request, prefix + "spr_prt_crnt_amt", ""));
		setSprPrtVndrSeq(JSPUtil.getParameter(request, prefix + "spr_prt_vndr_seq", ""));
		setSprPrtInvtVerSeq(JSPUtil.getParameter(request, prefix + "spr_prt_invt_ver_seq", ""));
		setSprPrtVerSeq(JSPUtil.getParameter(request, prefix + "spr_prt_ver_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrVslSprPrtInvtVO[]
	 */
	public MnrVslSprPrtInvtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrVslSprPrtInvtVO[]
	 */
	public MnrVslSprPrtInvtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrVslSprPrtInvtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sprPrtTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_tp_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] sprPrtInvtSeq = (JSPUtil.getParameter(request, prefix	+ "spr_prt_invt_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sprUtShrCd = (JSPUtil.getParameter(request, prefix	+ "spr_ut_shr_cd", length));
			String[] sprUtMdlNm = (JSPUtil.getParameter(request, prefix	+ "spr_ut_mdl_nm", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sprPrtInvtNo = (JSPUtil.getParameter(request, prefix	+ "spr_prt_invt_no", length));
			String[] sprPrtCrntAmt = (JSPUtil.getParameter(request, prefix	+ "spr_prt_crnt_amt", length));
			String[] sprPrtVndrSeq = (JSPUtil.getParameter(request, prefix	+ "spr_prt_vndr_seq", length));
			String[] sprPrtInvtVerSeq = (JSPUtil.getParameter(request, prefix	+ "spr_prt_invt_ver_seq", length));
			String[] sprPrtVerSeq = (JSPUtil.getParameter(request, prefix	+ "spr_prt_ver_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrVslSprPrtInvtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sprPrtTpCd[i] != null)
					model.setSprPrtTpCd(sprPrtTpCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (sprPrtInvtSeq[i] != null)
					model.setSprPrtInvtSeq(sprPrtInvtSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sprUtShrCd[i] != null)
					model.setSprUtShrCd(sprUtShrCd[i]);
				if (sprUtMdlNm[i] != null)
					model.setSprUtMdlNm(sprUtMdlNm[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sprPrtInvtNo[i] != null)
					model.setSprPrtInvtNo(sprPrtInvtNo[i]);
				if (sprPrtCrntAmt[i] != null)
					model.setSprPrtCrntAmt(sprPrtCrntAmt[i]);
				if (sprPrtVndrSeq[i] != null)
					model.setSprPrtVndrSeq(sprPrtVndrSeq[i]);
				if (sprPrtInvtVerSeq[i] != null)
					model.setSprPrtInvtVerSeq(sprPrtInvtVerSeq[i]);
				if (sprPrtVerSeq[i] != null)
					model.setSprPrtVerSeq(sprPrtVerSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrVslSprPrtInvtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrVslSprPrtInvtVO[]
	 */
	public MnrVslSprPrtInvtVO[] getMnrVslSprPrtInvtVOs(){
		MnrVslSprPrtInvtVO[] vos = (MnrVslSprPrtInvtVO[])models.toArray(new MnrVslSprPrtInvtVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtTpCd = this.sprPrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtInvtSeq = this.sprPrtInvtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprUtShrCd = this.sprUtShrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprUtMdlNm = this.sprUtMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtInvtNo = this.sprPrtInvtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtCrntAmt = this.sprPrtCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtVndrSeq = this.sprPrtVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtInvtVerSeq = this.sprPrtInvtVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtVerSeq = this.sprPrtVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
