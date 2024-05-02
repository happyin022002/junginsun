/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOceanLinkRHQVO.java
*@FileTitle : SearchOceanLinkRHQVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.16 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOceanLinkRHQVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOceanLinkRHQVO> models = new ArrayList<SearchOceanLinkRHQVO>();
	
	/* Column Info */
	private String friStFlg = null;
	/* Column Info */
	private String vndrnm = null;
	/* Column Info */
	private String tueStFlg = null;
	/* Column Info */
	private String sunStFlg = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String orgyard = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lnkRmk = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String satStFlg = null;
	/* Column Info */
	private String pctlIoBndCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String portTo = null;
	/* Column Info */
	private String destyard = null;
	/* Column Info */
	private String wedStFlg = null;
	/* Column Info */
	private String portFm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String thuStFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String toloc = null;
	/* Column Info */
	private String monStFlg = null;
	/* Column Info */
	private String fromloc = null;
	/* Column Info */
	private String fdrFreqKnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOceanLinkRHQVO() {}

	public SearchOceanLinkRHQVO(String ibflag, String pagerows, String vslSlanCd, String fromloc, String orgyard, String toloc, String destyard, String tztmHrs, String fdrFreqKnt, String pctlIoBndCd, String skdDirCd, String vndrSeq, String vndrnm, String lnkRmk, String sunStFlg, String monStFlg, String tueStFlg, String wedStFlg, String thuStFlg, String friStFlg, String satStFlg, String portFm, String portTo, String creUsrId, String updUsrId, String creOfcCd) {
		this.friStFlg = friStFlg;
		this.vndrnm = vndrnm;
		this.tueStFlg = tueStFlg;
		this.sunStFlg = sunStFlg;
		this.vslSlanCd = vslSlanCd;
		this.tztmHrs = tztmHrs;
		this.orgyard = orgyard;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.lnkRmk = lnkRmk;
		this.creOfcCd = creOfcCd;
		this.satStFlg = satStFlg;
		this.pctlIoBndCd = pctlIoBndCd;
		this.updUsrId = updUsrId;
		this.portTo = portTo;
		this.destyard = destyard;
		this.wedStFlg = wedStFlg;
		this.portFm = portFm;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.thuStFlg = thuStFlg;
		this.vndrSeq = vndrSeq;
		this.toloc = toloc;
		this.monStFlg = monStFlg;
		this.fromloc = fromloc;
		this.fdrFreqKnt = fdrFreqKnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fri_st_flg", getFriStFlg());
		this.hashColumns.put("vndrnm", getVndrnm());
		this.hashColumns.put("tue_st_flg", getTueStFlg());
		this.hashColumns.put("sun_st_flg", getSunStFlg());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("orgyard", getOrgyard());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lnk_rmk", getLnkRmk());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("sat_st_flg", getSatStFlg());
		this.hashColumns.put("pctl_io_bnd_cd", getPctlIoBndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("port_to", getPortTo());
		this.hashColumns.put("destyard", getDestyard());
		this.hashColumns.put("wed_st_flg", getWedStFlg());
		this.hashColumns.put("port_fm", getPortFm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("thu_st_flg", getThuStFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("toloc", getToloc());
		this.hashColumns.put("mon_st_flg", getMonStFlg());
		this.hashColumns.put("fromloc", getFromloc());
		this.hashColumns.put("fdr_freq_knt", getFdrFreqKnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fri_st_flg", "friStFlg");
		this.hashFields.put("vndrnm", "vndrnm");
		this.hashFields.put("tue_st_flg", "tueStFlg");
		this.hashFields.put("sun_st_flg", "sunStFlg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("orgyard", "orgyard");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lnk_rmk", "lnkRmk");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("sat_st_flg", "satStFlg");
		this.hashFields.put("pctl_io_bnd_cd", "pctlIoBndCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("port_to", "portTo");
		this.hashFields.put("destyard", "destyard");
		this.hashFields.put("wed_st_flg", "wedStFlg");
		this.hashFields.put("port_fm", "portFm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("thu_st_flg", "thuStFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("toloc", "toloc");
		this.hashFields.put("mon_st_flg", "monStFlg");
		this.hashFields.put("fromloc", "fromloc");
		this.hashFields.put("fdr_freq_knt", "fdrFreqKnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return friStFlg
	 */
	public String getFriStFlg() {
		return this.friStFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrnm
	 */
	public String getVndrnm() {
		return this.vndrnm;
	}
	
	/**
	 * Column Info
	 * @return tueStFlg
	 */
	public String getTueStFlg() {
		return this.tueStFlg;
	}
	
	/**
	 * Column Info
	 * @return sunStFlg
	 */
	public String getSunStFlg() {
		return this.sunStFlg;
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
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}
	
	/**
	 * Column Info
	 * @return orgyard
	 */
	public String getOrgyard() {
		return this.orgyard;
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
	 * @return lnkRmk
	 */
	public String getLnkRmk() {
		return this.lnkRmk;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return satStFlg
	 */
	public String getSatStFlg() {
		return this.satStFlg;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndCd
	 */
	public String getPctlIoBndCd() {
		return this.pctlIoBndCd;
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
	 * @return portTo
	 */
	public String getPortTo() {
		return this.portTo;
	}
	
	/**
	 * Column Info
	 * @return destyard
	 */
	public String getDestyard() {
		return this.destyard;
	}
	
	/**
	 * Column Info
	 * @return wedStFlg
	 */
	public String getWedStFlg() {
		return this.wedStFlg;
	}
	
	/**
	 * Column Info
	 * @return portFm
	 */
	public String getPortFm() {
		return this.portFm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return thuStFlg
	 */
	public String getThuStFlg() {
		return this.thuStFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return toloc
	 */
	public String getToloc() {
		return this.toloc;
	}
	
	/**
	 * Column Info
	 * @return monStFlg
	 */
	public String getMonStFlg() {
		return this.monStFlg;
	}
	
	/**
	 * Column Info
	 * @return fromloc
	 */
	public String getFromloc() {
		return this.fromloc;
	}
	
	/**
	 * Column Info
	 * @return fdrFreqKnt
	 */
	public String getFdrFreqKnt() {
		return this.fdrFreqKnt;
	}
	

	/**
	 * Column Info
	 * @param friStFlg
	 */
	public void setFriStFlg(String friStFlg) {
		this.friStFlg = friStFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrnm
	 */
	public void setVndrnm(String vndrnm) {
		this.vndrnm = vndrnm;
	}
	
	/**
	 * Column Info
	 * @param tueStFlg
	 */
	public void setTueStFlg(String tueStFlg) {
		this.tueStFlg = tueStFlg;
	}
	
	/**
	 * Column Info
	 * @param sunStFlg
	 */
	public void setSunStFlg(String sunStFlg) {
		this.sunStFlg = sunStFlg;
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
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}
	
	/**
	 * Column Info
	 * @param orgyard
	 */
	public void setOrgyard(String orgyard) {
		this.orgyard = orgyard;
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
	 * @param lnkRmk
	 */
	public void setLnkRmk(String lnkRmk) {
		this.lnkRmk = lnkRmk;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param satStFlg
	 */
	public void setSatStFlg(String satStFlg) {
		this.satStFlg = satStFlg;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndCd
	 */
	public void setPctlIoBndCd(String pctlIoBndCd) {
		this.pctlIoBndCd = pctlIoBndCd;
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
	 * @param portTo
	 */
	public void setPortTo(String portTo) {
		this.portTo = portTo;
	}
	
	/**
	 * Column Info
	 * @param destyard
	 */
	public void setDestyard(String destyard) {
		this.destyard = destyard;
	}
	
	/**
	 * Column Info
	 * @param wedStFlg
	 */
	public void setWedStFlg(String wedStFlg) {
		this.wedStFlg = wedStFlg;
	}
	
	/**
	 * Column Info
	 * @param portFm
	 */
	public void setPortFm(String portFm) {
		this.portFm = portFm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param thuStFlg
	 */
	public void setThuStFlg(String thuStFlg) {
		this.thuStFlg = thuStFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param toloc
	 */
	public void setToloc(String toloc) {
		this.toloc = toloc;
	}
	
	/**
	 * Column Info
	 * @param monStFlg
	 */
	public void setMonStFlg(String monStFlg) {
		this.monStFlg = monStFlg;
	}
	
	/**
	 * Column Info
	 * @param fromloc
	 */
	public void setFromloc(String fromloc) {
		this.fromloc = fromloc;
	}
	
	/**
	 * Column Info
	 * @param fdrFreqKnt
	 */
	public void setFdrFreqKnt(String fdrFreqKnt) {
		this.fdrFreqKnt = fdrFreqKnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFriStFlg(JSPUtil.getParameter(request, "fri_st_flg", ""));
		setVndrnm(JSPUtil.getParameter(request, "vndrnm", ""));
		setTueStFlg(JSPUtil.getParameter(request, "tue_st_flg", ""));
		setSunStFlg(JSPUtil.getParameter(request, "sun_st_flg", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setOrgyard(JSPUtil.getParameter(request, "orgyard", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLnkRmk(JSPUtil.getParameter(request, "lnk_rmk", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setSatStFlg(JSPUtil.getParameter(request, "sat_st_flg", ""));
		setPctlIoBndCd(JSPUtil.getParameter(request, "pctl_io_bnd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPortTo(JSPUtil.getParameter(request, "port_to", ""));
		setDestyard(JSPUtil.getParameter(request, "destyard", ""));
		setWedStFlg(JSPUtil.getParameter(request, "wed_st_flg", ""));
		setPortFm(JSPUtil.getParameter(request, "port_fm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setThuStFlg(JSPUtil.getParameter(request, "thu_st_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setToloc(JSPUtil.getParameter(request, "toloc", ""));
		setMonStFlg(JSPUtil.getParameter(request, "mon_st_flg", ""));
		setFromloc(JSPUtil.getParameter(request, "fromloc", ""));
		setFdrFreqKnt(JSPUtil.getParameter(request, "fdr_freq_knt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOceanLinkRHQVO[]
	 */
	public SearchOceanLinkRHQVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOceanLinkRHQVO[]
	 */
	public SearchOceanLinkRHQVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOceanLinkRHQVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] friStFlg = (JSPUtil.getParameter(request, prefix	+ "fri_st_flg", length));
			String[] vndrnm = (JSPUtil.getParameter(request, prefix	+ "vndrnm", length));
			String[] tueStFlg = (JSPUtil.getParameter(request, prefix	+ "tue_st_flg", length));
			String[] sunStFlg = (JSPUtil.getParameter(request, prefix	+ "sun_st_flg", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] orgyard = (JSPUtil.getParameter(request, prefix	+ "orgyard", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lnkRmk = (JSPUtil.getParameter(request, prefix	+ "lnk_rmk", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] satStFlg = (JSPUtil.getParameter(request, prefix	+ "sat_st_flg", length));
			String[] pctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] portTo = (JSPUtil.getParameter(request, prefix	+ "port_to", length));
			String[] destyard = (JSPUtil.getParameter(request, prefix	+ "destyard", length));
			String[] wedStFlg = (JSPUtil.getParameter(request, prefix	+ "wed_st_flg", length));
			String[] portFm = (JSPUtil.getParameter(request, prefix	+ "port_fm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] thuStFlg = (JSPUtil.getParameter(request, prefix	+ "thu_st_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] toloc = (JSPUtil.getParameter(request, prefix	+ "toloc", length));
			String[] monStFlg = (JSPUtil.getParameter(request, prefix	+ "mon_st_flg", length));
			String[] fromloc = (JSPUtil.getParameter(request, prefix	+ "fromloc", length));
			String[] fdrFreqKnt = (JSPUtil.getParameter(request, prefix	+ "fdr_freq_knt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOceanLinkRHQVO();
				if (friStFlg[i] != null)
					model.setFriStFlg(friStFlg[i]);
				if (vndrnm[i] != null)
					model.setVndrnm(vndrnm[i]);
				if (tueStFlg[i] != null)
					model.setTueStFlg(tueStFlg[i]);
				if (sunStFlg[i] != null)
					model.setSunStFlg(sunStFlg[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (orgyard[i] != null)
					model.setOrgyard(orgyard[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lnkRmk[i] != null)
					model.setLnkRmk(lnkRmk[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (satStFlg[i] != null)
					model.setSatStFlg(satStFlg[i]);
				if (pctlIoBndCd[i] != null)
					model.setPctlIoBndCd(pctlIoBndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (portTo[i] != null)
					model.setPortTo(portTo[i]);
				if (destyard[i] != null)
					model.setDestyard(destyard[i]);
				if (wedStFlg[i] != null)
					model.setWedStFlg(wedStFlg[i]);
				if (portFm[i] != null)
					model.setPortFm(portFm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (thuStFlg[i] != null)
					model.setThuStFlg(thuStFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (toloc[i] != null)
					model.setToloc(toloc[i]);
				if (monStFlg[i] != null)
					model.setMonStFlg(monStFlg[i]);
				if (fromloc[i] != null)
					model.setFromloc(fromloc[i]);
				if (fdrFreqKnt[i] != null)
					model.setFdrFreqKnt(fdrFreqKnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOceanLinkRHQVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOceanLinkRHQVO[]
	 */
	public SearchOceanLinkRHQVO[] getSearchOceanLinkRHQVOs(){
		SearchOceanLinkRHQVO[] vos = (SearchOceanLinkRHQVO[])models.toArray(new SearchOceanLinkRHQVO[models.size()]);
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
		this.friStFlg = this.friStFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrnm = this.vndrnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tueStFlg = this.tueStFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sunStFlg = this.sunStFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgyard = this.orgyard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkRmk = this.lnkRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.satStFlg = this.satStFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndCd = this.pctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTo = this.portTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destyard = this.destyard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wedStFlg = this.wedStFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portFm = this.portFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thuStFlg = this.thuStFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toloc = this.toloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monStFlg = this.monStFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromloc = this.fromloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrFreqKnt = this.fdrFreqKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
