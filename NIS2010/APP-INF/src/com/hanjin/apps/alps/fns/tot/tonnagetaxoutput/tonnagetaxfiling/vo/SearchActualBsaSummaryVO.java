/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchActualBsaSummaryVO.java
*@FileTitle : SearchActualBsaSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2010.12.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class SearchActualBsaSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActualBsaSummaryVO> models = new ArrayList<SearchActualBsaSummaryVO>();
	
	/* Column Info */
	private String fmVvdStlDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String usgRt = null;
	/* Column Info */
	private String toVvdStlDt = null;
	/* Column Info */
	private String fmPortCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String actBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String voyDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nrtWgt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String nrtTongTaxAmt = null;
	/* Column Info */
	private String ldbCapaQty = null;
	/* Column Info */
	private String toPortCd = null;
	/* Column Info */
	private String tongTaxAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActualBsaSummaryVO() {}

	public SearchActualBsaSummaryVO(String ibflag, String pagerows, String trdCd, String slanCd, String vslCd, String vslEngNm, String vvd, String nrtWgt, String ldbCapaQty, String bsaCapa, String actBsaCapa, String usgRt, String fmPortCd, String toPortCd, String fmVvdStlDt, String toVvdStlDt, String voyDys, String nrtTongTaxAmt, String tongTaxAmt) {
		this.fmVvdStlDt = fmVvdStlDt;
		this.vslCd = vslCd;
		this.usgRt = usgRt;
		this.toVvdStlDt = toVvdStlDt;
		this.fmPortCd = fmPortCd;
		this.trdCd = trdCd;
		this.actBsaCapa = actBsaCapa;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.bsaCapa = bsaCapa;
		this.voyDys = voyDys;
		this.ibflag = ibflag;
		this.nrtWgt = nrtWgt;
		this.slanCd = slanCd;
		this.vslEngNm = vslEngNm;
		this.nrtTongTaxAmt = nrtTongTaxAmt;
		this.ldbCapaQty = ldbCapaQty;
		this.toPortCd = toPortCd;
		this.tongTaxAmt = tongTaxAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_vvd_stl_dt", getFmVvdStlDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("usg_rt", getUsgRt());
		this.hashColumns.put("to_vvd_stl_dt", getToVvdStlDt());
		this.hashColumns.put("fm_port_cd", getFmPortCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("act_bsa_capa", getActBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("voy_dys", getVoyDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nrt_wgt", getNrtWgt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("nrt_tong_tax_amt", getNrtTongTaxAmt());
		this.hashColumns.put("ldb_capa_qty", getLdbCapaQty());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("tong_tax_amt", getTongTaxAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_vvd_stl_dt", "fmVvdStlDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("usg_rt", "usgRt");
		this.hashFields.put("to_vvd_stl_dt", "toVvdStlDt");
		this.hashFields.put("fm_port_cd", "fmPortCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("act_bsa_capa", "actBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("voy_dys", "voyDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nrt_wgt", "nrtWgt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("nrt_tong_tax_amt", "nrtTongTaxAmt");
		this.hashFields.put("ldb_capa_qty", "ldbCapaQty");
		this.hashFields.put("to_port_cd", "toPortCd");
		this.hashFields.put("tong_tax_amt", "tongTaxAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmVvdStlDt
	 */
	public String getFmVvdStlDt() {
		return this.fmVvdStlDt;
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
	 * @return usgRt
	 */
	public String getUsgRt() {
		return this.usgRt;
	}
	
	/**
	 * Column Info
	 * @return toVvdStlDt
	 */
	public String getToVvdStlDt() {
		return this.toVvdStlDt;
	}
	
	/**
	 * Column Info
	 * @return fmPortCd
	 */
	public String getFmPortCd() {
		return this.fmPortCd;
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
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
	}
	
	/**
	 * Column Info
	 * @return voyDys
	 */
	public String getVoyDys() {
		return this.voyDys;
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
	 * @return nrtWgt
	 */
	public String getNrtWgt() {
		return this.nrtWgt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return nrtTongTaxAmt
	 */
	public String getNrtTongTaxAmt() {
		return this.nrtTongTaxAmt;
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
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return this.toPortCd;
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
	 * @param fmVvdStlDt
	 */
	public void setFmVvdStlDt(String fmVvdStlDt) {
		this.fmVvdStlDt = fmVvdStlDt;
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
	 * @param usgRt
	 */
	public void setUsgRt(String usgRt) {
		this.usgRt = usgRt;
	}
	
	/**
	 * Column Info
	 * @param toVvdStlDt
	 */
	public void setToVvdStlDt(String toVvdStlDt) {
		this.toVvdStlDt = toVvdStlDt;
	}
	
	/**
	 * Column Info
	 * @param fmPortCd
	 */
	public void setFmPortCd(String fmPortCd) {
		this.fmPortCd = fmPortCd;
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
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
	}
	
	/**
	 * Column Info
	 * @param voyDys
	 */
	public void setVoyDys(String voyDys) {
		this.voyDys = voyDys;
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
	 * @param nrtWgt
	 */
	public void setNrtWgt(String nrtWgt) {
		this.nrtWgt = nrtWgt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param nrtTongTaxAmt
	 */
	public void setNrtTongTaxAmt(String nrtTongTaxAmt) {
		this.nrtTongTaxAmt = nrtTongTaxAmt;
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
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setFmVvdStlDt(JSPUtil.getParameter(request, prefix + "fm_vvd_stl_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setUsgRt(JSPUtil.getParameter(request, prefix + "usg_rt", ""));
		setToVvdStlDt(JSPUtil.getParameter(request, prefix + "to_vvd_stl_dt", ""));
		setFmPortCd(JSPUtil.getParameter(request, prefix + "fm_port_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setActBsaCapa(JSPUtil.getParameter(request, prefix + "act_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBsaCapa(JSPUtil.getParameter(request, prefix + "bsa_capa", ""));
		setVoyDys(JSPUtil.getParameter(request, prefix + "voy_dys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNrtWgt(JSPUtil.getParameter(request, prefix + "nrt_wgt", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setNrtTongTaxAmt(JSPUtil.getParameter(request, prefix + "nrt_tong_tax_amt", ""));
		setLdbCapaQty(JSPUtil.getParameter(request, prefix + "ldb_capa_qty", ""));
		setToPortCd(JSPUtil.getParameter(request, prefix + "to_port_cd", ""));
		setTongTaxAmt(JSPUtil.getParameter(request, prefix + "tong_tax_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActualBsaSummaryVO[]
	 */
	public SearchActualBsaSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActualBsaSummaryVO[]
	 */
	public SearchActualBsaSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActualBsaSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmVvdStlDt = (JSPUtil.getParameter(request, prefix	+ "fm_vvd_stl_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] usgRt = (JSPUtil.getParameter(request, prefix	+ "usg_rt", length));
			String[] toVvdStlDt = (JSPUtil.getParameter(request, prefix	+ "to_vvd_stl_dt", length));
			String[] fmPortCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] actBsaCapa = (JSPUtil.getParameter(request, prefix	+ "act_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] voyDys = (JSPUtil.getParameter(request, prefix	+ "voy_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nrtWgt = (JSPUtil.getParameter(request, prefix	+ "nrt_wgt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] nrtTongTaxAmt = (JSPUtil.getParameter(request, prefix	+ "nrt_tong_tax_amt", length));
			String[] ldbCapaQty = (JSPUtil.getParameter(request, prefix	+ "ldb_capa_qty", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			String[] tongTaxAmt = (JSPUtil.getParameter(request, prefix	+ "tong_tax_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActualBsaSummaryVO();
				if (fmVvdStlDt[i] != null)
					model.setFmVvdStlDt(fmVvdStlDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (usgRt[i] != null)
					model.setUsgRt(usgRt[i]);
				if (toVvdStlDt[i] != null)
					model.setToVvdStlDt(toVvdStlDt[i]);
				if (fmPortCd[i] != null)
					model.setFmPortCd(fmPortCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (actBsaCapa[i] != null)
					model.setActBsaCapa(actBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (voyDys[i] != null)
					model.setVoyDys(voyDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nrtWgt[i] != null)
					model.setNrtWgt(nrtWgt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (nrtTongTaxAmt[i] != null)
					model.setNrtTongTaxAmt(nrtTongTaxAmt[i]);
				if (ldbCapaQty[i] != null)
					model.setLdbCapaQty(ldbCapaQty[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);
				if (tongTaxAmt[i] != null)
					model.setTongTaxAmt(tongTaxAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActualBsaSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActualBsaSummaryVO[]
	 */
	public SearchActualBsaSummaryVO[] getSearchActualBsaSummaryVOs(){
		SearchActualBsaSummaryVO[] vos = (SearchActualBsaSummaryVO[])models.toArray(new SearchActualBsaSummaryVO[models.size()]);
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
		this.fmVvdStlDt = this.fmVvdStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usgRt = this.usgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVvdStlDt = this.toVvdStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCd = this.fmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBsaCapa = this.actBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyDys = this.voyDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtWgt = this.nrtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtTongTaxAmt = this.nrtTongTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldbCapaQty = this.ldbCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongTaxAmt = this.tongTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
