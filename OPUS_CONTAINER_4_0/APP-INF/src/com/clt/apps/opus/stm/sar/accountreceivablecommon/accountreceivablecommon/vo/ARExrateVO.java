/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARExrateVO.java
*@FileTitle : ARExrateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

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

public class ARExrateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARExrateVO> models = new ArrayList<ARExrateVO>();
	
	/* Column Info */
	private String xchRtDt = null;
	/* Column Info */
	private String xchRtTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String invCustSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String lclCurrCd = null;
	/* Column Info */
	private String rvsFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ARExrateVO() {}

	public ARExrateVO(String ibflag, String pagerows, String xchRtDt, String vslCd, String invCustSeq, String svcScpCd, String skdVoyNo, String ioBndCd, String arOfcCd, String skdDirCd, String podCd, String chgCurrCd, String polCd, String invCustCntCd, String lclCurrCd, String rvsFlg, String xchRtTpCd) {
		this.xchRtDt = xchRtDt;
		this.xchRtTpCd = xchRtTpCd;
		this.vslCd = vslCd;
		this.invCustSeq = invCustSeq;
		this.svcScpCd = svcScpCd;
		this.skdVoyNo = skdVoyNo;
		this.ioBndCd = ioBndCd;
		this.arOfcCd = arOfcCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.chgCurrCd = chgCurrCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.invCustCntCd = invCustCntCd;
		this.lclCurrCd = lclCurrCd;
		this.rvsFlg = rvsFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("lcl_curr_cd", getLclCurrCd());
		this.hashColumns.put("rvs_flg", getRvsFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("lcl_curr_cd", "lclCurrCd");
		this.hashFields.put("rvs_flg", "rvsFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xchRtDt
	 */
	public String getXchRtDt() {
		return this.xchRtDt;
	}
	
	/**
	 * Column Info
	 * @return xchRtTpCd
	 */
	public String getXchRtTpCd() {
		return this.xchRtTpCd;
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
	 * @return invCustSeq
	 */
	public String getInvCustSeq() {
		return this.invCustSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return invCustCntCd
	 */
	public String getInvCustCntCd() {
		return this.invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return lclCurrCd
	 */
	public String getLclCurrCd() {
		return this.lclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rvsFlg
	 */
	public String getRvsFlg() {
		return this.rvsFlg;
	}
	

	/**
	 * Column Info
	 * @param xchRtDt
	 */
	public void setXchRtDt(String xchRtDt) {
		this.xchRtDt = xchRtDt;
	}
	
	/**
	 * Column Info
	 * @param xchRtTpCd
	 */
	public void setXchRtTpCd(String xchRtTpCd) {
		this.xchRtTpCd = xchRtTpCd;
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
	 * @param invCustSeq
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param invCustCntCd
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param lclCurrCd
	 */
	public void setLclCurrCd(String lclCurrCd) {
		this.lclCurrCd = lclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rvsFlg
	 */
	public void setRvsFlg(String rvsFlg) {
		this.rvsFlg = rvsFlg;
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
		setXchRtDt(JSPUtil.getParameter(request, prefix + "xch_rt_dt", ""));
		setXchRtTpCd(JSPUtil.getParameter(request, prefix + "xch_rt_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request, prefix + "inv_cust_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setChgCurrCd(JSPUtil.getParameter(request, prefix + "chg_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, prefix + "inv_cust_cnt_cd", ""));
		setLclCurrCd(JSPUtil.getParameter(request, prefix + "lcl_curr_cd", ""));
		setRvsFlg(JSPUtil.getParameter(request, prefix + "rvs_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARExrateVO[]
	 */
	public ARExrateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARExrateVO[]
	 */
	public ARExrateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARExrateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xchRtDt = (JSPUtil.getParameter(request, prefix	+ "xch_rt_dt", length));
			String[] xchRtTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] lclCurrCd = (JSPUtil.getParameter(request, prefix	+ "lcl_curr_cd", length));
			String[] rvsFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARExrateVO();
				if (xchRtDt[i] != null)
					model.setXchRtDt(xchRtDt[i]);
				if (xchRtTpCd[i] != null)
					model.setXchRtTpCd(xchRtTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (lclCurrCd[i] != null)
					model.setLclCurrCd(lclCurrCd[i]);
				if (rvsFlg[i] != null)
					model.setRvsFlg(rvsFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARExrateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARExrateVO[]
	 */
	public ARExrateVO[] getARExrateVOs(){
		ARExrateVO[] vos = (ARExrateVO[])models.toArray(new ARExrateVO[models.size()]);
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
		this.xchRtDt = this.xchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd = this.xchRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurrCd = this.lclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg = this.rvsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
