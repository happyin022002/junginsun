/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PfSkdBerthWdoVO.java
*@FileTitle : PfSkdBerthWdoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.06.03 서창열 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PfSkdBerthWdoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PfSkdBerthWdoVO> models = new ArrayList<PfSkdBerthWdoVO>();
	
	/* Column Info */
	private String lwed = null;
	/* Column Info */
	private String rfri = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String bEtbDy = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String rtue = null;
	/* Column Info */
	private String ltue = null;
	/* Column Info */
	private String rmon = null;
	/* Column Info */
	private String portRotnSeq = null;
	/* Column Info */
	private String rsun = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String rsat = null;
	/* Column Info */
	private String rwed = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bEtdDy = null;
	/* Column Info */
	private String rthu = null;
	/* Column Info */
	private String lmon = null;
	/* Column Info */
	private String lsun = null;
	/* Column Info */
	private String nflg = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String lfri = null;
	/* Column Info */
	private String lthu = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String lsat = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PfSkdBerthWdoVO() {}

	public PfSkdBerthWdoVO(String ibflag, String pagerows, String portCd, String ydCd, String ydNm, String portRotnSeq, String vslSlanCd, String skdDirCd, String nflg, String lsun, String rsun, String lmon, String rmon, String ltue, String rtue, String lwed, String rwed, String lthu, String rthu, String lfri, String rfri, String lsat, String rsat, String chk, String bEtbDy, String bEtdDy, String pfSvcTpCd) {
		this.lwed = lwed;
		this.rfri = rfri;
		this.vslSlanCd = vslSlanCd;
		this.bEtbDy = bEtbDy;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pfSvcTpCd = pfSvcTpCd;
		this.rtue = rtue;
		this.ltue = ltue;
		this.rmon = rmon;
		this.portRotnSeq = portRotnSeq;
		this.rsun = rsun;
		this.portCd = portCd;
		this.rsat = rsat;
		this.rwed = rwed;
		this.skdDirCd = skdDirCd;
		this.bEtdDy = bEtdDy;
		this.rthu = rthu;
		this.lmon = lmon;
		this.lsun = lsun;
		this.nflg = nflg;
		this.chk = chk;
		this.ydCd = ydCd;
		this.lfri = lfri;
		this.lthu = lthu;
		this.ydNm = ydNm;
		this.lsat = lsat;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lwed", getLwed());
		this.hashColumns.put("rfri", getRfri());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("b_etb_dy", getBEtbDy());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("rtue", getRtue());
		this.hashColumns.put("ltue", getLtue());
		this.hashColumns.put("rmon", getRmon());
		this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
		this.hashColumns.put("rsun", getRsun());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("rsat", getRsat());
		this.hashColumns.put("rwed", getRwed());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("b_etd_dy", getBEtdDy());
		this.hashColumns.put("rthu", getRthu());
		this.hashColumns.put("lmon", getLmon());
		this.hashColumns.put("lsun", getLsun());
		this.hashColumns.put("nflg", getNflg());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("lfri", getLfri());
		this.hashColumns.put("lthu", getLthu());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("lsat", getLsat());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lwed", "lwed");
		this.hashFields.put("rfri", "rfri");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("b_etb_dy", "bEtbDy");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("rtue", "rtue");
		this.hashFields.put("ltue", "ltue");
		this.hashFields.put("rmon", "rmon");
		this.hashFields.put("port_rotn_seq", "portRotnSeq");
		this.hashFields.put("rsun", "rsun");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("rsat", "rsat");
		this.hashFields.put("rwed", "rwed");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("b_etd_dy", "bEtdDy");
		this.hashFields.put("rthu", "rthu");
		this.hashFields.put("lmon", "lmon");
		this.hashFields.put("lsun", "lsun");
		this.hashFields.put("nflg", "nflg");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("lfri", "lfri");
		this.hashFields.put("lthu", "lthu");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("lsat", "lsat");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lwed
	 */
	public String getLwed() {
		return this.lwed;
	}
	
	/**
	 * Column Info
	 * @return rfri
	 */
	public String getRfri() {
		return this.rfri;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return bEtbDy
	 */
	public String getBEtbDy() {
		return this.bEtbDy;
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
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtue
	 */
	public String getRtue() {
		return this.rtue;
	}
	
	/**
	 * Column Info
	 * @return ltue
	 */
	public String getLtue() {
		return this.ltue;
	}
	
	/**
	 * Column Info
	 * @return rmon
	 */
	public String getRmon() {
		return this.rmon;
	}
	
	/**
	 * Column Info
	 * @return portRotnSeq
	 */
	public String getPortRotnSeq() {
		return this.portRotnSeq;
	}
	
	/**
	 * Column Info
	 * @return rsun
	 */
	public String getRsun() {
		return this.rsun;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return rsat
	 */
	public String getRsat() {
		return this.rsat;
	}
	
	/**
	 * Column Info
	 * @return rwed
	 */
	public String getRwed() {
		return this.rwed;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return bEtdDy
	 */
	public String getBEtdDy() {
		return this.bEtdDy;
	}
	
	/**
	 * Column Info
	 * @return rthu
	 */
	public String getRthu() {
		return this.rthu;
	}
	
	/**
	 * Column Info
	 * @return lmon
	 */
	public String getLmon() {
		return this.lmon;
	}
	
	/**
	 * Column Info
	 * @return lsun
	 */
	public String getLsun() {
		return this.lsun;
	}
	
	/**
	 * Column Info
	 * @return nflg
	 */
	public String getNflg() {
		return this.nflg;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return lfri
	 */
	public String getLfri() {
		return this.lfri;
	}
	
	/**
	 * Column Info
	 * @return lthu
	 */
	public String getLthu() {
		return this.lthu;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return lsat
	 */
	public String getLsat() {
		return this.lsat;
	}
	

	/**
	 * Column Info
	 * @param lwed
	 */
	public void setLwed(String lwed) {
		this.lwed = lwed;
	}
	
	/**
	 * Column Info
	 * @param rfri
	 */
	public void setRfri(String rfri) {
		this.rfri = rfri;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param bEtbDy
	 */
	public void setBEtbDy(String bEtbDy) {
		this.bEtbDy = bEtbDy;
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
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtue
	 */
	public void setRtue(String rtue) {
		this.rtue = rtue;
	}
	
	/**
	 * Column Info
	 * @param ltue
	 */
	public void setLtue(String ltue) {
		this.ltue = ltue;
	}
	
	/**
	 * Column Info
	 * @param rmon
	 */
	public void setRmon(String rmon) {
		this.rmon = rmon;
	}
	
	/**
	 * Column Info
	 * @param portRotnSeq
	 */
	public void setPortRotnSeq(String portRotnSeq) {
		this.portRotnSeq = portRotnSeq;
	}
	
	/**
	 * Column Info
	 * @param rsun
	 */
	public void setRsun(String rsun) {
		this.rsun = rsun;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param rsat
	 */
	public void setRsat(String rsat) {
		this.rsat = rsat;
	}
	
	/**
	 * Column Info
	 * @param rwed
	 */
	public void setRwed(String rwed) {
		this.rwed = rwed;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param bEtdDy
	 */
	public void setBEtdDy(String bEtdDy) {
		this.bEtdDy = bEtdDy;
	}
	
	/**
	 * Column Info
	 * @param rthu
	 */
	public void setRthu(String rthu) {
		this.rthu = rthu;
	}
	
	/**
	 * Column Info
	 * @param lmon
	 */
	public void setLmon(String lmon) {
		this.lmon = lmon;
	}
	
	/**
	 * Column Info
	 * @param lsun
	 */
	public void setLsun(String lsun) {
		this.lsun = lsun;
	}
	
	/**
	 * Column Info
	 * @param nflg
	 */
	public void setNflg(String nflg) {
		this.nflg = nflg;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param lfri
	 */
	public void setLfri(String lfri) {
		this.lfri = lfri;
	}
	
	/**
	 * Column Info
	 * @param lthu
	 */
	public void setLthu(String lthu) {
		this.lthu = lthu;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param lsat
	 */
	public void setLsat(String lsat) {
		this.lsat = lsat;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLwed(JSPUtil.getParameter(request, "lwed", ""));
		setRfri(JSPUtil.getParameter(request, "rfri", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setBEtbDy(JSPUtil.getParameter(request, "b_etb_dy", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setRtue(JSPUtil.getParameter(request, "rtue", ""));
		setLtue(JSPUtil.getParameter(request, "ltue", ""));
		setRmon(JSPUtil.getParameter(request, "rmon", ""));
		setPortRotnSeq(JSPUtil.getParameter(request, "port_rotn_seq", ""));
		setRsun(JSPUtil.getParameter(request, "rsun", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setRsat(JSPUtil.getParameter(request, "rsat", ""));
		setRwed(JSPUtil.getParameter(request, "rwed", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setBEtdDy(JSPUtil.getParameter(request, "b_etd_dy", ""));
		setRthu(JSPUtil.getParameter(request, "rthu", ""));
		setLmon(JSPUtil.getParameter(request, "lmon", ""));
		setLsun(JSPUtil.getParameter(request, "lsun", ""));
		setNflg(JSPUtil.getParameter(request, "nflg", ""));
		setChk(JSPUtil.getParameter(request, "chk", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setLfri(JSPUtil.getParameter(request, "lfri", ""));
		setLthu(JSPUtil.getParameter(request, "lthu", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setLsat(JSPUtil.getParameter(request, "lsat", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PfSkdBerthWdoVO[]
	 */
	public PfSkdBerthWdoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PfSkdBerthWdoVO[]
	 */
	public PfSkdBerthWdoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PfSkdBerthWdoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lwed = (JSPUtil.getParameter(request, prefix	+ "lwed".trim(), length));
			String[] rfri = (JSPUtil.getParameter(request, prefix	+ "rfri".trim(), length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] bEtbDy = (JSPUtil.getParameter(request, prefix	+ "b_etb_dy".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd".trim(), length));
			String[] rtue = (JSPUtil.getParameter(request, prefix	+ "rtue".trim(), length));
			String[] ltue = (JSPUtil.getParameter(request, prefix	+ "ltue".trim(), length));
			String[] rmon = (JSPUtil.getParameter(request, prefix	+ "rmon".trim(), length));
			String[] portRotnSeq = (JSPUtil.getParameter(request, prefix	+ "port_rotn_seq".trim(), length));
			String[] rsun = (JSPUtil.getParameter(request, prefix	+ "rsun".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] rsat = (JSPUtil.getParameter(request, prefix	+ "rsat".trim(), length));
			String[] rwed = (JSPUtil.getParameter(request, prefix	+ "rwed".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] bEtdDy = (JSPUtil.getParameter(request, prefix	+ "b_etd_dy".trim(), length));
			String[] rthu = (JSPUtil.getParameter(request, prefix	+ "rthu".trim(), length));
			String[] lmon = (JSPUtil.getParameter(request, prefix	+ "lmon".trim(), length));
			String[] lsun = (JSPUtil.getParameter(request, prefix	+ "lsun".trim(), length));
			String[] nflg = (JSPUtil.getParameter(request, prefix	+ "nflg".trim(), length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] lfri = (JSPUtil.getParameter(request, prefix	+ "lfri".trim(), length));
			String[] lthu = (JSPUtil.getParameter(request, prefix	+ "lthu".trim(), length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm".trim(), length));
			String[] lsat = (JSPUtil.getParameter(request, prefix	+ "lsat".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PfSkdBerthWdoVO();
				if (lwed[i] != null)
					model.setLwed(lwed[i]);
				if (rfri[i] != null)
					model.setRfri(rfri[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (bEtbDy[i] != null)
					model.setBEtbDy(bEtbDy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (rtue[i] != null)
					model.setRtue(rtue[i]);
				if (ltue[i] != null)
					model.setLtue(ltue[i]);
				if (rmon[i] != null)
					model.setRmon(rmon[i]);
				if (portRotnSeq[i] != null)
					model.setPortRotnSeq(portRotnSeq[i]);
				if (rsun[i] != null)
					model.setRsun(rsun[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (rsat[i] != null)
					model.setRsat(rsat[i]);
				if (rwed[i] != null)
					model.setRwed(rwed[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bEtdDy[i] != null)
					model.setBEtdDy(bEtdDy[i]);
				if (rthu[i] != null)
					model.setRthu(rthu[i]);
				if (lmon[i] != null)
					model.setLmon(lmon[i]);
				if (lsun[i] != null)
					model.setLsun(lsun[i]);
				if (nflg[i] != null)
					model.setNflg(nflg[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (lfri[i] != null)
					model.setLfri(lfri[i]);
				if (lthu[i] != null)
					model.setLthu(lthu[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (lsat[i] != null)
					model.setLsat(lsat[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPfSkdBerthWdoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PfSkdBerthWdoVO[]
	 */
	public PfSkdBerthWdoVO[] getPfSkdBerthWdoVOs(){
		PfSkdBerthWdoVO[] vos = (PfSkdBerthWdoVO[])models.toArray(new PfSkdBerthWdoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.lwed = this.lwed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfri = this.rfri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bEtbDy = this.bEtbDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtue = this.rtue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltue = this.ltue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmon = this.rmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRotnSeq = this.portRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsun = this.rsun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsat = this.rsat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rwed = this.rwed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bEtdDy = this.bEtdDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rthu = this.rthu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmon = this.lmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsun = this.lsun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nflg = this.nflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfri = this.lfri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lthu = this.lthu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsat = this.lsat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
