/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MonEstmRawDataVO.java
*@FileTitle : MonEstmRawDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.08
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.04.08 조정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo;

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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MonEstmRawDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<MonEstmRawDataVO> models = new ArrayList<MonEstmRawDataVO>();

	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String acclPortAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String actPortAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String actAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String acclCanalAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCanalAmt = null;
	/* Column Info */
	private String acclAmt = null;
	/* Column Info */
	private String estmPortAmt = null;
	/* Column Info */
	private String estmCanalAmt = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String cntrDznCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public MonEstmRawDataVO() {}

	public MonEstmRawDataVO(String ibflag, String pagerows, String revYrmon, String rlaneCd, String vslCd, String skdVoyNo, String skdDirCd, String estmAmt, String actAmt, String acclAmt, String estmPortAmt, String estmCanalAmt, String actPortAmt, String actCanalAmt, String acclPortAmt, String acclCanalAmt, String locCd, String acctCd, String cntrDznCapa) {
		this.vslCd = vslCd;
		this.revYrmon = revYrmon;
		this.acclPortAmt = acclPortAmt;
		this.skdVoyNo = skdVoyNo;
		this.estmAmt = estmAmt;
		this.actPortAmt = actPortAmt;
		this.rlaneCd = rlaneCd;
		this.actAmt = actAmt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.acclCanalAmt = acclCanalAmt;
		this.ibflag = ibflag;
		this.actCanalAmt = actCanalAmt;
		this.acclAmt = acclAmt;
		this.estmPortAmt = estmPortAmt;
		this.estmCanalAmt = estmCanalAmt;
		this.locCd = locCd;
		this.acctCd = acctCd;
		this.cntrDznCapa = cntrDznCapa;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("accl_port_amt", getAcclPortAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("act_port_amt", getActPortAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("act_amt", getActAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("accl_canal_amt", getAcclCanalAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_canal_amt", getActCanalAmt());
		this.hashColumns.put("accl_amt", getAcclAmt());
		this.hashColumns.put("estm_port_amt", getEstmPortAmt());
		this.hashColumns.put("estm_canal_amt", getEstmCanalAmt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("accl_port_amt", "acclPortAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("act_port_amt", "actPortAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("act_amt", "actAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("accl_canal_amt", "acclCanalAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_canal_amt", "actCanalAmt");
		this.hashFields.put("accl_amt", "acclAmt");
		this.hashFields.put("estm_port_amt", "estmPortAmt");
		this.hashFields.put("estm_canal_amt", "estmCanalAmt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		return this.hashFields;
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
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}

	/**
	 * Column Info
	 * @return acclPortAmt
	 */
	public String getAcclPortAmt() {
		return this.acclPortAmt;
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
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
	}

	/**
	 * Column Info
	 * @return actPortAmt
	 */
	public String getActPortAmt() {
		return this.actPortAmt;
	}

	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}

	/**
	 * Column Info
	 * @return actAmt
	 */
	public String getActAmt() {
		return this.actAmt;
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
	 * @return acclCanalAmt
	 */
	public String getAcclCanalAmt() {
		return this.acclCanalAmt;
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
	 * @return actCanalAmt
	 */
	public String getActCanalAmt() {
		return this.actCanalAmt;
	}

	/**
	 * Column Info
	 * @return acclAmt
	 */
	public String getAcclAmt() {
		return this.acclAmt;
	}

	/**
	 * Column Info
	 * @return estmPortAmt
	 */
	public String getEstmPortAmt() {
		return this.estmPortAmt;
	}
	
	/**
	 * Column Info
	 * @return estmCanalAmt
	 */
	public String getEstmCanalAmt() {
		return this.estmCanalAmt;
	}

	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}

	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
	}

	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	

	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param acclPortAmt
	 */
	public void setAcclPortAmt(String acclPortAmt) {
		this.acclPortAmt = acclPortAmt;
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
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
	}
	
	/**
	 * Column Info
	 * @param actPortAmt
	 */
	public void setActPortAmt(String actPortAmt) {
		this.actPortAmt = actPortAmt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param actAmt
	 */
	public void setActAmt(String actAmt) {
		this.actAmt = actAmt;
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
	 * @param acclCanalAmt
	 */
	public void setAcclCanalAmt(String acclCanalAmt) {
		this.acclCanalAmt = acclCanalAmt;
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
	 * @param actCanalAmt
	 */
	public void setActCanalAmt(String actCanalAmt) {
		this.actCanalAmt = actCanalAmt;
	}
	
	/**
	 * Column Info
	 * @param acclAmt
	 */
	public void setAcclAmt(String acclAmt) {
		this.acclAmt = acclAmt;
	}
	
	/**
	 * Column Info
	 * @param estmPortAmt
	 */
	public void setEstmPortAmt(String estmPortAmt) {
		this.estmPortAmt = estmPortAmt;
	}
	
	/**
	 * Column Info
	 * @param estmCanalAmt
	 */
	public void setEstmCanalAmt(String estmCanalAmt) {
		this.estmCanalAmt = estmCanalAmt;
	}

	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setAcclPortAmt(JSPUtil.getParameter(request, prefix + "accl_port_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setActPortAmt(JSPUtil.getParameter(request, prefix + "act_port_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setActAmt(JSPUtil.getParameter(request, prefix + "act_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAcclCanalAmt(JSPUtil.getParameter(request, prefix + "accl_canal_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActCanalAmt(JSPUtil.getParameter(request, prefix + "act_canal_amt", ""));
		setAcclAmt(JSPUtil.getParameter(request, prefix + "accl_amt", ""));
		setEstmPortAmt(JSPUtil.getParameter(request, prefix + "estm_port_amt", ""));
		setEstmCanalAmt(JSPUtil.getParameter(request, prefix + "estm_canal_amt", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonEstmRawDataVO[]
	 */
	public MonEstmRawDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonEstmRawDataVO[]
	 */
	public MonEstmRawDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonEstmRawDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] acclPortAmt = (JSPUtil.getParameter(request, prefix	+ "accl_port_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] actPortAmt = (JSPUtil.getParameter(request, prefix	+ "act_port_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] actAmt = (JSPUtil.getParameter(request, prefix	+ "act_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] acclCanalAmt = (JSPUtil.getParameter(request, prefix	+ "accl_canal_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCanalAmt = (JSPUtil.getParameter(request, prefix	+ "act_canal_amt", length));
			String[] acclAmt = (JSPUtil.getParameter(request, prefix	+ "accl_amt", length));
			String[] estmPortAmt = (JSPUtil.getParameter(request, prefix	+ "estm_port_amt", length));
			String[] estmCanalAmt = (JSPUtil.getParameter(request, prefix	+ "estm_canal_amt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", length));

			for (int i = 0; i < length; i++) {
				model = new MonEstmRawDataVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (acclPortAmt[i] != null)
					model.setAcclPortAmt(acclPortAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (actPortAmt[i] != null)
					model.setActPortAmt(actPortAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (actAmt[i] != null)
					model.setActAmt(actAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (acclCanalAmt[i] != null)
					model.setAcclCanalAmt(acclCanalAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCanalAmt[i] != null)
					model.setActCanalAmt(actCanalAmt[i]);
				if (acclAmt[i] != null)
					model.setAcclAmt(acclAmt[i]);
				if (estmPortAmt[i] != null)
					model.setEstmPortAmt(estmPortAmt[i]);
				if (estmCanalAmt[i] != null)
					model.setEstmCanalAmt(estmCanalAmt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (cntrDznCapa[i] != null) {
					model.setCntrDznCapa(cntrDznCapa[i]);
				}
				models.add(model);
			}
		} catch (Exception e) {
			return null;
		}
		return getMonEstmRawDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonEstmRawDataVO[]
	 */
	public MonEstmRawDataVO[] getMonEstmRawDataVOs(){
		MonEstmRawDataVO[] vos = (MonEstmRawDataVO[])models.toArray(new MonEstmRawDataVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclPortAmt = this.acclPortAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPortAmt = this.actPortAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAmt = this.actAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCanalAmt = this.acclCanalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCanalAmt = this.actCanalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAmt = this.acclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmPortAmt = this.estmPortAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCanalAmt = this.estmCanalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
