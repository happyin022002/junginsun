/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FdrStlAmtVO.java
*@FileTitle : FdrStlAmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.29 장창수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo;

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
 * @author 장창수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FdrStlAmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FdrStlAmtVO> models = new ArrayList<FdrStlAmtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tongStlBatJbSeq = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String stlYrmon = null;
	/* Column Info */
	private String usgRt = null;
	/* Column Info */
	private String actBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String voyDys = null;
	/* Column Info */
	private String nrtWgt = null;
	/* Column Info */
	private String polDepDt = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String tongCalcDatTpCd = null;
	/* Column Info */
	private String ldbCapaQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String podDepDt = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String perTonRev = null;
	/* Column Info */
	private String tongTaxAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FdrStlAmtVO() {}

	public FdrStlAmtVO(String ibflag, String pagerows, String stlYrmon, String vslCd, String vvdSeq, String tongStlBatJbSeq, String tongCalcDatTpCd, String bkgNo, String slanCd, String vvd, String ldbCapaQty, String actBsaCapa, String bkgPolCd, String bkgPodCd, String polDepDt, String podDepDt, String voyDys, String nrtWgt, String usgRt, String tongTaxAmt, String perTonRev, String updDt, String updUsrId) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.tongStlBatJbSeq = tongStlBatJbSeq;
		this.bkgPolCd = bkgPolCd;
		this.stlYrmon = stlYrmon;
		this.usgRt = usgRt;
		this.actBsaCapa = actBsaCapa;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.voyDys = voyDys;
		this.nrtWgt = nrtWgt;
		this.polDepDt = polDepDt;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.tongCalcDatTpCd = tongCalcDatTpCd;
		this.ldbCapaQty = ldbCapaQty;
		this.updUsrId = updUsrId;
		this.podDepDt = podDepDt;
		this.vvdSeq = vvdSeq;
		this.perTonRev = perTonRev;
		this.tongTaxAmt = tongTaxAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("tong_stl_bat_jb_seq", getTongStlBatJbSeq());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("stl_yrmon", getStlYrmon());
		this.hashColumns.put("usg_rt", getUsgRt());
		this.hashColumns.put("act_bsa_capa", getActBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("voy_dys", getVoyDys());
		this.hashColumns.put("nrt_wgt", getNrtWgt());
		this.hashColumns.put("pol_dep_dt", getPolDepDt());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("tong_calc_dat_tp_cd", getTongCalcDatTpCd());
		this.hashColumns.put("ldb_capa_qty", getLdbCapaQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pod_dep_dt", getPodDepDt());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("per_ton_rev", getPerTonRev());
		this.hashColumns.put("tong_tax_amt", getTongTaxAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("tong_stl_bat_jb_seq", "tongStlBatJbSeq");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("stl_yrmon", "stlYrmon");
		this.hashFields.put("usg_rt", "usgRt");
		this.hashFields.put("act_bsa_capa", "actBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("voy_dys", "voyDys");
		this.hashFields.put("nrt_wgt", "nrtWgt");
		this.hashFields.put("pol_dep_dt", "polDepDt");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("tong_calc_dat_tp_cd", "tongCalcDatTpCd");
		this.hashFields.put("ldb_capa_qty", "ldbCapaQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pod_dep_dt", "podDepDt");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("per_ton_rev", "perTonRev");
		this.hashFields.put("tong_tax_amt", "tongTaxAmt");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return tongStlBatJbSeq
	 */
	public String getTongStlBatJbSeq() {
		return this.tongStlBatJbSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return stlYrmon
	 */
	public String getStlYrmon() {
		return this.stlYrmon;
	}
	
	/**
	 * Column Info
	 * @return usgRt
	 */
	public String getUsgRt() {
		return this.usgRt;
	}
	
	/**
	 * Column Info
	 * @return actBsaCapa
	 */
	public String getActBsaCapa() {
		return this.actBsaCapa;
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
	 * Column Info
	 * @return voyDys
	 */
	public String getVoyDys() {
		return this.voyDys;
	}
	
	/**
	 * Column Info
	 * @return nrtWgt
	 */
	public String getNrtWgt() {
		return this.nrtWgt;
	}
	
	/**
	 * Column Info
	 * @return polDepDt
	 */
	public String getPolDepDt() {
		return this.polDepDt;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return tongCalcDatTpCd
	 */
	public String getTongCalcDatTpCd() {
		return this.tongCalcDatTpCd;
	}
	
	/**
	 * Column Info
	 * @return ldbCapaQty
	 */
	public String getLdbCapaQty() {
		return this.ldbCapaQty;
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
	 * @return podDepDt
	 */
	public String getPodDepDt() {
		return this.podDepDt;
	}
	
	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	
	/**
	 * Column Info
	 * @return perTonRev
	 */
	public String getPerTonRev() {
		return this.perTonRev;
	}
	
	/**
	 * Column Info
	 * @return tongTaxAmt
	 */
	public String getTongTaxAmt() {
		return this.tongTaxAmt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param tongStlBatJbSeq
	 */
	public void setTongStlBatJbSeq(String tongStlBatJbSeq) {
		this.tongStlBatJbSeq = tongStlBatJbSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param stlYrmon
	 */
	public void setStlYrmon(String stlYrmon) {
		this.stlYrmon = stlYrmon;
	}
	
	/**
	 * Column Info
	 * @param usgRt
	 */
	public void setUsgRt(String usgRt) {
		this.usgRt = usgRt;
	}
	
	/**
	 * Column Info
	 * @param actBsaCapa
	 */
	public void setActBsaCapa(String actBsaCapa) {
		this.actBsaCapa = actBsaCapa;
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
	 * Column Info
	 * @param voyDys
	 */
	public void setVoyDys(String voyDys) {
		this.voyDys = voyDys;
	}
	
	/**
	 * Column Info
	 * @param nrtWgt
	 */
	public void setNrtWgt(String nrtWgt) {
		this.nrtWgt = nrtWgt;
	}
	
	/**
	 * Column Info
	 * @param polDepDt
	 */
	public void setPolDepDt(String polDepDt) {
		this.polDepDt = polDepDt;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param tongCalcDatTpCd
	 */
	public void setTongCalcDatTpCd(String tongCalcDatTpCd) {
		this.tongCalcDatTpCd = tongCalcDatTpCd;
	}
	
	/**
	 * Column Info
	 * @param ldbCapaQty
	 */
	public void setLdbCapaQty(String ldbCapaQty) {
		this.ldbCapaQty = ldbCapaQty;
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
	 * @param podDepDt
	 */
	public void setPodDepDt(String podDepDt) {
		this.podDepDt = podDepDt;
	}
	
	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param perTonRev
	 */
	public void setPerTonRev(String perTonRev) {
		this.perTonRev = perTonRev;
	}
	
	/**
	 * Column Info
	 * @param tongTaxAmt
	 */
	public void setTongTaxAmt(String tongTaxAmt) {
		this.tongTaxAmt = tongTaxAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTongStlBatJbSeq(JSPUtil.getParameter(request, "tong_stl_bat_jb_seq", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setStlYrmon(JSPUtil.getParameter(request, "stl_yrmon", ""));
		setUsgRt(JSPUtil.getParameter(request, "usg_rt", ""));
		setActBsaCapa(JSPUtil.getParameter(request, "act_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVoyDys(JSPUtil.getParameter(request, "voy_dys", ""));
		setNrtWgt(JSPUtil.getParameter(request, "nrt_wgt", ""));
		setPolDepDt(JSPUtil.getParameter(request, "pol_dep_dt", ""));
		setBkgPodCd(JSPUtil.getParameter(request, "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setTongCalcDatTpCd(JSPUtil.getParameter(request, "tong_calc_dat_tp_cd", ""));
		setLdbCapaQty(JSPUtil.getParameter(request, "ldb_capa_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPodDepDt(JSPUtil.getParameter(request, "pod_dep_dt", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setPerTonRev(JSPUtil.getParameter(request, "per_ton_rev", ""));
		setTongTaxAmt(JSPUtil.getParameter(request, "tong_tax_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FdrStlAmtVO[]
	 */
	public FdrStlAmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FdrStlAmtVO[]
	 */
	public FdrStlAmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FdrStlAmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tongStlBatJbSeq = (JSPUtil.getParameter(request, prefix	+ "tong_stl_bat_jb_seq", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] stlYrmon = (JSPUtil.getParameter(request, prefix	+ "stl_yrmon", length));
			String[] usgRt = (JSPUtil.getParameter(request, prefix	+ "usg_rt", length));
			String[] actBsaCapa = (JSPUtil.getParameter(request, prefix	+ "act_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] voyDys = (JSPUtil.getParameter(request, prefix	+ "voy_dys", length));
			String[] nrtWgt = (JSPUtil.getParameter(request, prefix	+ "nrt_wgt", length));
			String[] polDepDt = (JSPUtil.getParameter(request, prefix	+ "pol_dep_dt", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] tongCalcDatTpCd = (JSPUtil.getParameter(request, prefix	+ "tong_calc_dat_tp_cd", length));
			String[] ldbCapaQty = (JSPUtil.getParameter(request, prefix	+ "ldb_capa_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] podDepDt = (JSPUtil.getParameter(request, prefix	+ "pod_dep_dt", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] perTonRev = (JSPUtil.getParameter(request, prefix	+ "per_ton_rev", length));
			String[] tongTaxAmt = (JSPUtil.getParameter(request, prefix	+ "tong_tax_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new FdrStlAmtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tongStlBatJbSeq[i] != null)
					model.setTongStlBatJbSeq(tongStlBatJbSeq[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (stlYrmon[i] != null)
					model.setStlYrmon(stlYrmon[i]);
				if (usgRt[i] != null)
					model.setUsgRt(usgRt[i]);
				if (actBsaCapa[i] != null)
					model.setActBsaCapa(actBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (voyDys[i] != null)
					model.setVoyDys(voyDys[i]);
				if (nrtWgt[i] != null)
					model.setNrtWgt(nrtWgt[i]);
				if (polDepDt[i] != null)
					model.setPolDepDt(polDepDt[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (tongCalcDatTpCd[i] != null)
					model.setTongCalcDatTpCd(tongCalcDatTpCd[i]);
				if (ldbCapaQty[i] != null)
					model.setLdbCapaQty(ldbCapaQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (podDepDt[i] != null)
					model.setPodDepDt(podDepDt[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (perTonRev[i] != null)
					model.setPerTonRev(perTonRev[i]);
				if (tongTaxAmt[i] != null)
					model.setTongTaxAmt(tongTaxAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFdrStlAmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FdrStlAmtVO[]
	 */
	public FdrStlAmtVO[] getFdrStlAmtVOs(){
		FdrStlAmtVO[] vos = (FdrStlAmtVO[])models.toArray(new FdrStlAmtVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongStlBatJbSeq = this.tongStlBatJbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlYrmon = this.stlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usgRt = this.usgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBsaCapa = this.actBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyDys = this.voyDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtWgt = this.nrtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDepDt = this.polDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongCalcDatTpCd = this.tongCalcDatTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldbCapaQty = this.ldbCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDepDt = this.podDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTonRev = this.perTonRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongTaxAmt = this.tongTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
