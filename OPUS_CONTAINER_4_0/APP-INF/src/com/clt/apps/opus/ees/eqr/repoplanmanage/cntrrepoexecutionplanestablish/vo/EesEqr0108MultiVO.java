/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0108MultiVO.java
*@FileTitle : EesEqr0108MultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.01 정은호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0108MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0108MultiVO> models = new ArrayList<EesEqr0108MultiVO>();
	
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String ydCd1 = null;
	/* Column Info */
	private String ydCd2 = null;
	/* Column Info */
	private String ydCd3 = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String dt1 = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String dt2 = null;
	/* Column Info */
	private String dt3 = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ecc1 = null;
	/* Column Info */
	private String ecc2 = null;
	/* Column Info */
	private String ecc3 = null;
	/* Column Info */
	private String tpszno = null;
	/* Column Info */
	private String repoPlnFbRsnCd = null;
	/* Column Info */
	private String repoPlnFbRmk = null;
	/* Column Info */
	private String eqRepoPurpCd = null;
	/* Column Info */
	private String trspMode = null;
	
	/* input Param */
	/*
	 * type size 순서대로 해당 value를 담기위한 변수
	 */
	private List<String> volList = null;
	private List<String> amtList = null;
	private List<String> unitcostList = null;
	private List<String> fromcostList = null;
	private List<String> tocostList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0108MultiVO() {}

	public EesEqr0108MultiVO(String ibflag, String pagerows, String plnYrwk, String coCd, String ydCd1, String ydCd2, String ydCd3, String dt1, String dt2, String dt3, String eqRepoPurpCd, String vvd, String repoPlnFbRsnCd, String repoPlnFbRmk, String ecc1, String ecc2, String ecc3, String trspMode, String lane, String cntrno, String tpszno, String plnSeq) {
		this.coCd = coCd;
		this.ydCd1 = ydCd1;
		this.ydCd2 = ydCd2;
		this.ydCd3 = ydCd3;
		this.cntrno = cntrno;
		this.dt1 = dt1;
		this.plnSeq = plnSeq;
		this.plnYrwk = plnYrwk;
		this.dt2 = dt2;
		this.dt3 = dt3;
		this.lane = lane;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.ecc1 = ecc1;
		this.ecc2 = ecc2;
		this.ecc3 = ecc3;
		this.tpszno = tpszno;
		this.repoPlnFbRsnCd = repoPlnFbRsnCd;
		this.repoPlnFbRmk = repoPlnFbRmk;
		this.eqRepoPurpCd = eqRepoPurpCd;
		this.trspMode = trspMode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("yd_cd1", getYdCd1());
		this.hashColumns.put("yd_cd2", getYdCd2());
		this.hashColumns.put("yd_cd3", getYdCd3());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("dt1", getDt1());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("dt2", getDt2());
		this.hashColumns.put("dt3", getDt3());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ecc1", getEcc1());
		this.hashColumns.put("ecc2", getEcc2());
		this.hashColumns.put("ecc3", getEcc3());
		this.hashColumns.put("tpszno", getTpszno());
		this.hashColumns.put("repo_pln_fb_rsn_cd", getRepoPlnFbRsnCd());
		this.hashColumns.put("repo_pln_fb_rmk", getRepoPlnFbRmk());
		this.hashColumns.put("eq_repo_purp_cd", getEqRepoPurpCd());
		this.hashColumns.put("trsp_mode", getTrspMode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("yd_cd1", "ydCd1");
		this.hashFields.put("yd_cd2", "ydCd2");
		this.hashFields.put("yd_cd3", "ydCd3");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("dt1", "dt1");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("dt2", "dt2");
		this.hashFields.put("dt3", "dt3");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ecc1", "ecc1");
		this.hashFields.put("ecc2", "ecc2");
		this.hashFields.put("ecc3", "ecc3");
		this.hashFields.put("tpszno", "tpszno");
		this.hashFields.put("repo_pln_fb_rsn_cd", "repoPlnFbRsnCd");
		this.hashFields.put("repo_pln_fb_rmk", "repoPlnFbRmk");
		this.hashFields.put("eq_repo_purp_cd", "eqRepoPurpCd");
		this.hashFields.put("trsp_mode", "trspMode");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd1
	 */
	public String getYdCd1() {
		return this.ydCd1;
	}
	
	/**
	 * Column Info
	 * @return ydCd2
	 */
	public String getYdCd2() {
		return this.ydCd2;
	}
	
	/**
	 * Column Info
	 * @return ydCd3
	 */
	public String getYdCd3() {
		return this.ydCd3;
	}
	
	/**
	 * Column Info
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
	}
	
	/**
	 * Column Info
	 * @return dt1
	 */
	public String getDt1() {
		return this.dt1;
	}
	
	/**
	 * Column Info
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return dt2
	 */
	public String getDt2() {
		return this.dt2;
	}
	
	/**
	 * Column Info
	 * @return dt3
	 */
	public String getDt3() {
		return this.dt3;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return ecc1
	 */
	public String getEcc1() {
		return this.ecc1;
	}
	
	/**
	 * Column Info
	 * @return ecc2
	 */
	public String getEcc2() {
		return this.ecc2;
	}
	
	/**
	 * Column Info
	 * @return ecc3
	 */
	public String getEcc3() {
		return this.ecc3;
	}
	
	/**
	 * Column Info
	 * @return tpszno
	 */
	public String getTpszno() {
		return this.tpszno;
	}
	
	/**
	 * Column Info
	 * @return repoPlnFbRsnCd
	 */
	public String getRepoPlnFbRsnCd() {
		return this.repoPlnFbRsnCd;
	}
	
	/**
	 * Column Info
	 * @return repoPlnFbRmk
	 */
	public String getRepoPlnFbRmk() {
		return this.repoPlnFbRmk;
	}
	
	/**
	 * Column Info
	 * @return eqRepoPurpCd
	 */
	public String getEqRepoPurpCd() {
		return this.eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @return trspMode
	 */
	public String getTrspMode() {
		return this.trspMode;
	}
	

	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd1
	 */
	public void setYdCd1(String ydCd1) {
		this.ydCd1 = ydCd1;
	}
	
	/**
	 * Column Info
	 * @param ydCd2
	 */
	public void setYdCd2(String ydCd2) {
		this.ydCd2 = ydCd2;
	}
	
	/**
	 * Column Info
	 * @param ydCd3
	 */
	public void setYdCd3(String ydCd3) {
		this.ydCd3 = ydCd3;
	}
	
	/**
	 * Column Info
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}
	
	/**
	 * Column Info
	 * @param dt1
	 */
	public void setDt1(String dt1) {
		this.dt1 = dt1;
	}
	
	/**
	 * Column Info
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param dt2
	 */
	public void setDt2(String dt2) {
		this.dt2 = dt2;
	}
	
	/**
	 * Column Info
	 * @param dt3
	 */
	public void setDt3(String dt3) {
		this.dt3 = dt3;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param ecc1
	 */
	public void setEcc1(String ecc1) {
		this.ecc1 = ecc1;
	}
	
	/**
	 * Column Info
	 * @param ecc2
	 */
	public void setEcc2(String ecc2) {
		this.ecc2 = ecc2;
	}
	
	/**
	 * Column Info
	 * @param ecc3
	 */
	public void setEcc3(String ecc3) {
		this.ecc3 = ecc3;
	}
	
	/**
	 * Column Info
	 * @param tpszno
	 */
	public void setTpszno(String tpszno) {
		this.tpszno = tpszno;
	}
	
	/**
	 * Column Info
	 * @param repoPlnFbRsnCd
	 */
	public void setRepoPlnFbRsnCd(String repoPlnFbRsnCd) {
		this.repoPlnFbRsnCd = repoPlnFbRsnCd;
	}
	
	/**
	 * Column Info
	 * @param repoPlnFbRmk
	 */
	public void setRepoPlnFbRmk(String repoPlnFbRmk) {
		this.repoPlnFbRmk = repoPlnFbRmk;
	}
	
	/**
	 * Column Info
	 * @param eqRepoPurpCd
	 */
	public void setEqRepoPurpCd(String eqRepoPurpCd) {
		this.eqRepoPurpCd = eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @param trspMode
	 */
	public void setTrspMode(String trspMode) {
		this.trspMode = trspMode;
	}
	
	public List<String> getVolList() {
		return volList;
	}

	public void setVolList(List<String> volList) {
		this.volList = volList;
	}


	public List<String> getUnitcostList() {
		return unitcostList;
	}

	public void setUnitcostList(List<String> unitcostList) {
		this.unitcostList = unitcostList;
	}

	public List<String> getFromcostList() {
		return fromcostList;
	}

	public void setFromcostList(List<String> fromcostList) {
		this.fromcostList = fromcostList;
	}

	public List<String> getTocostList() {
		return tocostList;
	}

	public void setTocostList(List<String> tocostList) {
		this.tocostList = tocostList;
	}

	public List<String> getAmtList() {
		return amtList;
	}

	public void setAmtList(List<String> amtList) {
		this.amtList = amtList;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setYdCd1(JSPUtil.getParameter(request, "yd_cd1", ""));
		setYdCd2(JSPUtil.getParameter(request, "yd_cd2", ""));
		setYdCd3(JSPUtil.getParameter(request, "yd_cd3", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setDt1(JSPUtil.getParameter(request, "dt1", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setDt2(JSPUtil.getParameter(request, "dt2", ""));
		setDt3(JSPUtil.getParameter(request, "dt3", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEcc1(JSPUtil.getParameter(request, "ecc1", ""));
		setEcc2(JSPUtil.getParameter(request, "ecc2", ""));
		setEcc3(JSPUtil.getParameter(request, "ecc3", ""));
		setTpszno(JSPUtil.getParameter(request, "tpszno", ""));
		setRepoPlnFbRsnCd(JSPUtil.getParameter(request, "repo_pln_fb_rsn_cd", ""));
		setRepoPlnFbRmk(JSPUtil.getParameter(request, "repo_pln_fb_rmk", ""));
		setEqRepoPurpCd(JSPUtil.getParameter(request, "eq_repo_purp_cd", ""));
		setTrspMode(JSPUtil.getParameter(request, "trsp_mode", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0108MultiVO[]
	 */
	public EesEqr0108MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0108MultiVO[]
	 */
	public EesEqr0108MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0108MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String tpsztype = JSPUtil.getParameter(request, "tpsz".trim(), ""); // tpsz value
	    	String[] tpszArr = tpsztype.split(","); 
	    	
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] ydCd1 = (JSPUtil.getParameter(request, prefix	+ "yd1", length));
			String[] ydCd2 = (JSPUtil.getParameter(request, prefix	+ "yd2", length));
			String[] ydCd3 = (JSPUtil.getParameter(request, prefix	+ "yd3", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "t1_cntrno", length));
			String[] dt1 = (JSPUtil.getParameter(request, prefix	+ "dt1", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] dt2 = (JSPUtil.getParameter(request, prefix	+ "dt2", length));
			String[] dt3 = (JSPUtil.getParameter(request, prefix	+ "dt3", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ecc1 = (JSPUtil.getParameter(request, prefix	+ "ecc1", length));
			String[] ecc2 = (JSPUtil.getParameter(request, prefix	+ "ecc2", length));
			String[] ecc3 = (JSPUtil.getParameter(request, prefix	+ "ecc3", length));
			String[] tpszno = (JSPUtil.getParameter(request, prefix	+ "t1_tpszno", length));
			String[] repoPlnFbRsnCd = (JSPUtil.getParameter(request, prefix	+ "reason", length));
			String[] repoPlnFbRmk = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rmk", length));
			String[] eqRepoPurpCd = (JSPUtil.getParameter(request, prefix	+ "eq_repo_purp_cd", length));
			String[] trspMode = (JSPUtil.getParameter(request, prefix	+ "trsp_mode", length));
			
			List<String[]> volListArr = new ArrayList<String[]>();
			List<String[]> amtListArr = new ArrayList<String[]>();
			List<String[]> unitcostListArr = new ArrayList<String[]>();
			List<String[]> fromcostListArr = new ArrayList<String[]>();
			List<String[]> tocostListArr = new ArrayList<String[]>();
			for(int i=0; i<tpszArr.length; i++) {
				String[] volArr = (JSPUtil.getParameter(request, prefix	+ "vol"+tpszArr[i], length));
				String[] amtArr = (JSPUtil.getParameter(request, prefix	+ "cost"+tpszArr[i], length));
				String[] unitcostArr = (JSPUtil.getParameter(request, prefix	+ "unitcost"+tpszArr[i], length));
				String[] fromcostArr = (JSPUtil.getParameter(request, prefix	+ "fromcost"+tpszArr[i], length));
				String[] tocostArr = (JSPUtil.getParameter(request, prefix	+ "tocost"+tpszArr[i], length));
				
				volListArr.add(volArr);
				amtListArr.add(amtArr);
				unitcostListArr.add(unitcostArr);
				fromcostListArr.add(fromcostArr);
				tocostListArr.add(tocostArr);
			}
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0108MultiVO();
				
				List<String> volList = new ArrayList<String>();
				List<String> amtList = new ArrayList<String>();
				List<String> unitcostList = new ArrayList<String>();
				List<String> fromcostList = new ArrayList<String>();
				List<String> tocostList = new ArrayList<String>();
				for(int t=0; t<tpszArr.length; t++) {
					String[] volArr  = (String[])volListArr.get(t);
					String[] amtArr = (String[])amtListArr.get(t);
					String[] unitcostArr = (String[])unitcostListArr.get(t);
					String[] fromcostArr = (String[])fromcostListArr.get(t);
					String[] tocostArr = (String[])tocostListArr.get(t); 
					if(volArr[i] != null)
						volList.add(volArr[i]);
					if(amtArr[i] != null)
						amtList.add(amtArr[i]);
					if(unitcostArr[i] != null)
						unitcostList.add(unitcostArr[i]);
					if(fromcostArr[i] != null)
						fromcostList.add(fromcostArr[i]);
					if(tocostArr[i] != null)
						tocostList.add(tocostArr[i]);
				}
				model.setVolList(volList);
				model.setAmtList(amtList);
				model.setUnitcostList(unitcostList);
				model.setFromcostList(fromcostList);
				model.setTocostList(tocostList);
				
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (ydCd1[i] != null)
					model.setYdCd1(ydCd1[i]);
				if (ydCd2[i] != null)
					model.setYdCd2(ydCd2[i]);
				if (ydCd3[i] != null)
					model.setYdCd3(ydCd3[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (dt1[i] != null)
					model.setDt1(dt1[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (dt2[i] != null)
					model.setDt2(dt2[i]);
				if (dt3[i] != null)
					model.setDt3(dt3[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ecc1[i] != null)
					model.setEcc1(ecc1[i]);
				if (ecc2[i] != null)
					model.setEcc2(ecc2[i]);
				if (ecc3[i] != null)
					model.setEcc3(ecc3[i]);
				if (tpszno[i] != null)
					model.setTpszno(tpszno[i]);
				if (repoPlnFbRsnCd[i] != null)
					model.setRepoPlnFbRsnCd(repoPlnFbRsnCd[i]);
				if (repoPlnFbRmk[i] != null)
					model.setRepoPlnFbRmk(repoPlnFbRmk[i]);
				if (eqRepoPurpCd[i] != null)
					model.setEqRepoPurpCd(eqRepoPurpCd[i]);
				if (trspMode[i] != null)
					model.setTrspMode(trspMode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0108MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0108MultiVO[]
	 */
	public EesEqr0108MultiVO[] getEesEqr0108MultiVOs(){
		EesEqr0108MultiVO[] vos = (EesEqr0108MultiVO[])models.toArray(new EesEqr0108MultiVO[models.size()]);
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
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd1 = this.ydCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd2 = this.ydCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd3 = this.ydCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dt1 = this.dt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dt2 = this.dt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dt3 = this.dt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecc1 = this.ecc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecc2 = this.ecc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecc3 = this.ecc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszno = this.tpszno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRsnCd = this.repoPlnFbRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRmk = this.repoPlnFbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoPurpCd = this.eqRepoPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMode = this.trspMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
