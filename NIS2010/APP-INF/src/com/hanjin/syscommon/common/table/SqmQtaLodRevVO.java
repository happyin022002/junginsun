/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SqmQtaLodRevVO.java
*@FileTitle : SqmQtaLodRevVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.06.23 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SqmQtaLodRevVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SqmQtaLodRevVO> models = new ArrayList<SqmQtaLodRevVO>();
	
	/* Column Info */
	private String rlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ldfRto = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String qtaStepCd = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String qtaVerNo = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String paCmUcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SqmQtaLodRevVO() {}

	public SqmQtaLodRevVO(String ibflag, String pagerows, String bseTpCd, String bseYr, String bseQtrCd, String ofcVwCd, String qtaStepCd, String qtaVerNo, String trdCd, String rlaneCd, String vslCd, String skdVoyNo, String skdDirCd, String convDirCd, String dirCd, String subTrdCd, String fnlBsaCapa, String ldfRto, String grsRpbRev, String paCmUcAmt, String raCmUcAmt, String creUsrId, String creDt, String updUsrId, String updDt, String lodQty) {
		this.rlaneCd = rlaneCd;
		this.ibflag = ibflag;
		this.bseTpCd = bseTpCd;
		this.raCmUcAmt = raCmUcAmt;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.fnlBsaCapa = fnlBsaCapa;
		this.skdVoyNo = skdVoyNo;
		this.ldfRto = ldfRto;
		this.lodQty = lodQty;
		this.vslCd = vslCd;
		this.qtaStepCd = qtaStepCd;
		this.grsRpbRev = grsRpbRev;
		this.convDirCd = convDirCd;
		this.creDt = creDt;
		this.qtaVerNo = qtaVerNo;
		this.trdCd = trdCd;
		this.ofcVwCd = ofcVwCd;
		this.bseYr = bseYr;
		this.subTrdCd = subTrdCd;
		this.bseQtrCd = bseQtrCd;
		this.dirCd = dirCd;
		this.updDt = updDt;
		this.paCmUcAmt = paCmUcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ldf_rto", getLdfRto());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("qta_step_cd", getQtaStepCd());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("qta_ver_no", getQtaVerNo());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pa_cm_uc_amt", getPaCmUcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ldf_rto", "ldfRto");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("qta_step_cd", "qtaStepCd");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("qta_ver_no", "qtaVerNo");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pa_cm_uc_amt", "paCmUcAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
	}
	
	/**
	 * Column Info
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ldfRto
	 */
	public String getLdfRto() {
		return this.ldfRto;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
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
	 * @return qtaStepCd
	 */
	public String getQtaStepCd() {
		return this.qtaStepCd;
	}
	
	/**
	 * Column Info
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
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
	 * @return qtaVerNo
	 */
	public String getQtaVerNo() {
		return this.qtaVerNo;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return paCmUcAmt
	 */
	public String getPaCmUcAmt() {
		return this.paCmUcAmt;
	}
	

	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
	}
	
	/**
	 * Column Info
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ldfRto
	 */
	public void setLdfRto(String ldfRto) {
		this.ldfRto = ldfRto;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
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
	 * @param qtaStepCd
	 */
	public void setQtaStepCd(String qtaStepCd) {
		this.qtaStepCd = qtaStepCd;
	}
	
	/**
	 * Column Info
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
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
	 * @param qtaVerNo
	 */
	public void setQtaVerNo(String qtaVerNo) {
		this.qtaVerNo = qtaVerNo;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param paCmUcAmt
	 */
	public void setPaCmUcAmt(String paCmUcAmt) {
		this.paCmUcAmt = paCmUcAmt;
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
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, prefix + "ra_cm_uc_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setLdfRto(JSPUtil.getParameter(request, prefix + "ldf_rto", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setQtaStepCd(JSPUtil.getParameter(request, prefix + "qta_step_cd", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, prefix + "grs_rpb_rev", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setQtaVerNo(JSPUtil.getParameter(request, prefix + "qta_ver_no", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPaCmUcAmt(JSPUtil.getParameter(request, prefix + "pa_cm_uc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SqmQtaLodRevVO[]
	 */
	public SqmQtaLodRevVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SqmQtaLodRevVO[]
	 */
	public SqmQtaLodRevVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SqmQtaLodRevVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ldfRto = (JSPUtil.getParameter(request, prefix	+ "ldf_rto", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] qtaStepCd = (JSPUtil.getParameter(request, prefix	+ "qta_step_cd", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] qtaVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_ver_no", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] paCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "pa_cm_uc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SqmQtaLodRevVO();
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ldfRto[i] != null)
					model.setLdfRto(ldfRto[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (qtaStepCd[i] != null)
					model.setQtaStepCd(qtaStepCd[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (qtaVerNo[i] != null)
					model.setQtaVerNo(qtaVerNo[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (paCmUcAmt[i] != null)
					model.setPaCmUcAmt(paCmUcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSqmQtaLodRevVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SqmQtaLodRevVO[]
	 */
	public SqmQtaLodRevVO[] getSqmQtaLodRevVOs(){
		SqmQtaLodRevVO[] vos = (SqmQtaLodRevVO[])models.toArray(new SqmQtaLodRevVO[models.size()]);
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
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldfRto = this.ldfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaStepCd = this.qtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaVerNo = this.qtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmUcAmt = this.paCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
