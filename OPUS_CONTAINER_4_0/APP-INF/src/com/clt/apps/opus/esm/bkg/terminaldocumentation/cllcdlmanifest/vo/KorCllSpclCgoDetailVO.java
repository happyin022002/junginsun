/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorCllSpclCgoDetailVO.java
*@FileTitle : KorCllSpclCgoDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.08
*@LastModifier :
*@LastVersion : 1.0
* 2011.12.08
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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

public class KorCllSpclCgoDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCllSpclCgoDetailVO> models = new ArrayList<KorCllSpclCgoDetailVO>();

	/* Column Info */
	private String cs2 = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String lq = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String stow = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String unno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String aPol = null;
	/* Column Info */
	private String classCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String bkgNo2 = null;
	/* Column Info */
	private String aPod = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String wgtUnit = null;
	/* Column Info */
	private String mp = null;
	/* Column Info */
	private String cgoType = null;
	/* Column Info */
	private String vent = null;
	/* Column Info */
	private String mtyBkgCd = null;
	/* Column Info */
	private String sg = null;
	/* Column Info */
	private String cs = null;
	/* Column Info */
	private String voId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String temp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCllSpclCgoDetailVO() {}

	public KorCllSpclCgoDetailVO(String ibflag, String pagerows, String seq, String cgoType, String bkgNo, String bkgNo2, String ts, String aPol, String aPod, String pol, String pod, String cs, String cs2, String cntrNo, String tp, String wgt, String wgtUnit, String classCd, String unno, String temp, String vent, String remark, String mp, String sg, String lq, String voId, String stow, String mtyBkgCd, String clptSeq, String blckStwgCd) {
		this.cs2 = cs2;
		this.ts = ts;
		this.remark = remark;
		this.lq = lq;
		this.tp = tp;
		this.stow = stow;
		this.blckStwgCd = blckStwgCd;
		this.pagerows = pagerows;
		this.clptSeq = clptSeq;
		this.unno = unno;
		this.ibflag = ibflag;
		this.wgt = wgt;
		this.aPol = aPol;
		this.classCd = classCd;
		this.pol = pol;
		this.bkgNo2 = bkgNo2;
		this.aPod = aPod;
		this.pod = pod;
		this.wgtUnit = wgtUnit;
		this.mp = mp;
		this.cgoType = cgoType;
		this.vent = vent;
		this.mtyBkgCd = mtyBkgCd;
		this.sg = sg;
		this.cs = cs;
		this.voId = voId;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.seq = seq;
		this.temp = temp;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cs2", getCs2());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("lq", getLq());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("stow", getStow());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("unno", getUnno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("a_pol", getAPol());
		this.hashColumns.put("class_cd", getClassCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("bkg_no2", getBkgNo2());
		this.hashColumns.put("a_pod", getAPod());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("wgt_unit", getWgtUnit());
		this.hashColumns.put("mp", getMp());
		this.hashColumns.put("cgo_type", getCgoType());
		this.hashColumns.put("vent", getVent());
		this.hashColumns.put("mty_bkg_cd", getMtyBkgCd());
		this.hashColumns.put("sg", getSg());
		this.hashColumns.put("cs", getCs());
		this.hashColumns.put("vo_id", getVoId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("temp", getTemp());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cs2", "cs2");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("lq", "lq");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("stow", "stow");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("unno", "unno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("a_pol", "aPol");
		this.hashFields.put("class_cd", "classCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("bkg_no2", "bkgNo2");
		this.hashFields.put("a_pod", "aPod");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("wgt_unit", "wgtUnit");
		this.hashFields.put("mp", "mp");
		this.hashFields.put("cgo_type", "cgoType");
		this.hashFields.put("vent", "vent");
		this.hashFields.put("mty_bkg_cd", "mtyBkgCd");
		this.hashFields.put("sg", "sg");
		this.hashFields.put("cs", "cs");
		this.hashFields.put("vo_id", "voId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("temp", "temp");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cs2
	 */
	public String getCs2() {
		return this.cs2;
	}

	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}

	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * Column Info
	 * @return lq
	 */
	public String getLq() {
		return this.lq;
	}

	/**
	 * Column Info
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
	}

	/**
	 * Column Info
	 * @return stow
	 */
	public String getStow() {
		return this.stow;
	}

	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
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
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}

	/**
	 * Column Info
	 * @return unno
	 */
	public String getUnno() {
		return this.unno;
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
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}

	/**
	 * Column Info
	 * @return aPol
	 */
	public String getAPol() {
		return this.aPol;
	}

	/**
	 * Column Info
	 * @return classCd
	 */
	public String getClassCd() {
		return this.classCd;
	}

	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}

	/**
	 * Column Info
	 * @return bkgNo2
	 */
	public String getBkgNo2() {
		return this.bkgNo2;
	}

	/**
	 * Column Info
	 * @return aPod
	 */
	public String getAPod() {
		return this.aPod;
	}

	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}

	/**
	 * Column Info
	 * @return wgtUnit
	 */
	public String getWgtUnit() {
		return this.wgtUnit;
	}

	/**
	 * Column Info
	 * @return mp
	 */
	public String getMp() {
		return this.mp;
	}

	/**
	 * Column Info
	 * @return cgoType
	 */
	public String getCgoType() {
		return this.cgoType;
	}

	/**
	 * Column Info
	 * @return vent
	 */
	public String getVent() {
		return this.vent;
	}

	/**
	 * Column Info
	 * @return mtyBkgCd
	 */
	public String getMtyBkgCd() {
		return this.mtyBkgCd;
	}

	/**
	 * Column Info
	 * @return sg
	 */
	public String getSg() {
		return this.sg;
	}

	/**
	 * Column Info
	 * @return cs
	 */
	public String getCs() {
		return this.cs;
	}

	/**
	 * Column Info
	 * @return voId
	 */
	public String getVoId() {
		return this.voId;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}

	/**
	 * Column Info
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
	}


	/**
	 * Column Info
	 * @param cs2
	 */
	public void setCs2(String cs2) {
		this.cs2 = cs2;
	}

	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}

	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Column Info
	 * @param lq
	 */
	public void setLq(String lq) {
		this.lq = lq;
	}

	/**
	 * Column Info
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}

	/**
	 * Column Info
	 * @param stow
	 */
	public void setStow(String stow) {
		this.stow = stow;
	}

	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
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
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}

	/**
	 * Column Info
	 * @param unno
	 */
	public void setUnno(String unno) {
		this.unno = unno;
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
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}

	/**
	 * Column Info
	 * @param aPol
	 */
	public void setAPol(String aPol) {
		this.aPol = aPol;
	}

	/**
	 * Column Info
	 * @param classCd
	 */
	public void setClassCd(String classCd) {
		this.classCd = classCd;
	}

	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * Column Info
	 * @param bkgNo2
	 */
	public void setBkgNo2(String bkgNo2) {
		this.bkgNo2 = bkgNo2;
	}

	/**
	 * Column Info
	 * @param aPod
	 */
	public void setAPod(String aPod) {
		this.aPod = aPod;
	}

	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * Column Info
	 * @param wgtUnit
	 */
	public void setWgtUnit(String wgtUnit) {
		this.wgtUnit = wgtUnit;
	}

	/**
	 * Column Info
	 * @param mp
	 */
	public void setMp(String mp) {
		this.mp = mp;
	}

	/**
	 * Column Info
	 * @param cgoType
	 */
	public void setCgoType(String cgoType) {
		this.cgoType = cgoType;
	}

	/**
	 * Column Info
	 * @param vent
	 */
	public void setVent(String vent) {
		this.vent = vent;
	}

	/**
	 * Column Info
	 * @param mtyBkgCd
	 */
	public void setMtyBkgCd(String mtyBkgCd) {
		this.mtyBkgCd = mtyBkgCd;
	}

	/**
	 * Column Info
	 * @param sg
	 */
	public void setSg(String sg) {
		this.sg = sg;
	}

	/**
	 * Column Info
	 * @param cs
	 */
	public void setCs(String cs) {
		this.cs = cs;
	}

	/**
	 * Column Info
	 * @param voId
	 */
	public void setVoId(String voId) {
		this.voId = voId;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * Column Info
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
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
		setCs2(JSPUtil.getParameter(request, prefix + "cs2", ""));
		setTs(JSPUtil.getParameter(request, prefix + "ts", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setLq(JSPUtil.getParameter(request, prefix + "lq", ""));
		setTp(JSPUtil.getParameter(request, prefix + "tp", ""));
		setStow(JSPUtil.getParameter(request, prefix + "stow", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setUnno(JSPUtil.getParameter(request, prefix + "unno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setAPol(JSPUtil.getParameter(request, prefix + "a_pol", ""));
		setClassCd(JSPUtil.getParameter(request, prefix + "class_cd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setBkgNo2(JSPUtil.getParameter(request, prefix + "bkg_no2", ""));
		setAPod(JSPUtil.getParameter(request, prefix + "a_pod", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setWgtUnit(JSPUtil.getParameter(request, prefix + "wgt_unit", ""));
		setMp(JSPUtil.getParameter(request, prefix + "mp", ""));
		setCgoType(JSPUtil.getParameter(request, prefix + "cgo_type", ""));
		setVent(JSPUtil.getParameter(request, prefix + "vent", ""));
		setMtyBkgCd(JSPUtil.getParameter(request, prefix + "mty_bkg_cd", ""));
		setSg(JSPUtil.getParameter(request, prefix + "sg", ""));
		setCs(JSPUtil.getParameter(request, prefix + "cs", ""));
		setVoId(JSPUtil.getParameter(request, prefix + "vo_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setTemp(JSPUtil.getParameter(request, prefix + "temp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllSpclCgoDetailVO[]
	 */
	public KorCllSpclCgoDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCllSpclCgoDetailVO[]
	 */
	public KorCllSpclCgoDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllSpclCgoDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cs2 = (JSPUtil.getParameter(request, prefix	+ "cs2", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] lq = (JSPUtil.getParameter(request, prefix	+ "lq", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] stow = (JSPUtil.getParameter(request, prefix	+ "stow", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] unno = (JSPUtil.getParameter(request, prefix	+ "unno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] aPol = (JSPUtil.getParameter(request, prefix	+ "a_pol", length));
			String[] classCd = (JSPUtil.getParameter(request, prefix	+ "class_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] bkgNo2 = (JSPUtil.getParameter(request, prefix	+ "bkg_no2", length));
			String[] aPod = (JSPUtil.getParameter(request, prefix	+ "a_pod", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] wgtUnit = (JSPUtil.getParameter(request, prefix	+ "wgt_unit", length));
			String[] mp = (JSPUtil.getParameter(request, prefix	+ "mp", length));
			String[] cgoType = (JSPUtil.getParameter(request, prefix	+ "cgo_type", length));
			String[] vent = (JSPUtil.getParameter(request, prefix	+ "vent", length));
			String[] mtyBkgCd = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_cd", length));
			String[] sg = (JSPUtil.getParameter(request, prefix	+ "sg", length));
			String[] cs = (JSPUtil.getParameter(request, prefix	+ "cs", length));
			String[] voId = (JSPUtil.getParameter(request, prefix	+ "vo_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));

			for (int i = 0; i < length; i++) {
				model = new KorCllSpclCgoDetailVO();
				if (cs2[i] != null)
					model.setCs2(cs2[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (lq[i] != null)
					model.setLq(lq[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (stow[i] != null)
					model.setStow(stow[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (unno[i] != null)
					model.setUnno(unno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (aPol[i] != null)
					model.setAPol(aPol[i]);
				if (classCd[i] != null)
					model.setClassCd(classCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (bkgNo2[i] != null)
					model.setBkgNo2(bkgNo2[i]);
				if (aPod[i] != null)
					model.setAPod(aPod[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (wgtUnit[i] != null)
					model.setWgtUnit(wgtUnit[i]);
				if (mp[i] != null)
					model.setMp(mp[i]);
				if (cgoType[i] != null)
					model.setCgoType(cgoType[i]);
				if (vent[i] != null)
					model.setVent(vent[i]);
				if (mtyBkgCd[i] != null)
					model.setMtyBkgCd(mtyBkgCd[i]);
				if (sg[i] != null)
					model.setSg(sg[i]);
				if (cs[i] != null)
					model.setCs(cs[i]);
				if (voId[i] != null)
					model.setVoId(voId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllSpclCgoDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllSpclCgoDetailVO[]
	 */
	public KorCllSpclCgoDetailVO[] getKorCllSpclCgoDetailVOs(){
		KorCllSpclCgoDetailVO[] vos = (KorCllSpclCgoDetailVO[])models.toArray(new KorCllSpclCgoDetailVO[models.size()]);
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
		this.cs2 = this.cs2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lq = this.lq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stow = this.stow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unno = this.unno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPol = this.aPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.classCd = this.classCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo2 = this.bkgNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPod = this.aPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUnit = this.wgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mp = this.mp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoType = this.cgoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vent = this.vent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgCd = this.mtyBkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sg = this.sg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cs = this.cs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voId = this.voId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
