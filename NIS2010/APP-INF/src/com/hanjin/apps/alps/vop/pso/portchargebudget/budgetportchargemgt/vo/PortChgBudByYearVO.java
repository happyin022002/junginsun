/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortChgBudByYearVO.java
*@FileTitle : PortChgBudByYearVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.12.07 김진일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortChgBudByYearVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortChgBudByYearVO> models = new ArrayList<PortChgBudByYearVO>();
	
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslCls = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String amt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String txtedate = null;
	/* Column Info */
	private String txtsdate = null;
	/* Column Info */
	private String expnYrmon = null;
	/* Column Info */
	private String err = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortChgBudByYearVO() {}

	public PortChgBudByYearVO(String ibflag, String pagerows, String expnYrmon, String vslSlanCd, String err, String vvd, String amt, String txtsdate, String txtedate, String vslCls, String vslCd, String skdVoyNo, String skdDirCd, String rmk) {
		this.rmk = rmk;
		this.vslCd = vslCd;
		this.vslCls = vslCls;
		this.skdVoyNo = skdVoyNo;
		this.vslSlanCd = vslSlanCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.amt = amt;
		this.ibflag = ibflag;
		this.txtedate = txtedate;
		this.txtsdate = txtsdate;
		this.expnYrmon = expnYrmon;
		this.err = err;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_cls", getVslCls());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("txtedate", getTxtedate());
		this.hashColumns.put("txtsdate", getTxtsdate());
		this.hashColumns.put("expn_yrmon", getExpnYrmon());
		this.hashColumns.put("err", getErr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_cls", "vslCls");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("txtedate", "txtedate");
		this.hashFields.put("txtsdate", "txtsdate");
		this.hashFields.put("expn_yrmon", "expnYrmon");
		this.hashFields.put("err", "err");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
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
	 * @return vslCls
	 */
	public String getVslCls() {
		return this.vslCls;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
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
	 * @return txtedate
	 */
	public String getTxtedate() {
		return this.txtedate;
	}
	
	/**
	 * Column Info
	 * @return txtsdate
	 */
	public String getTxtsdate() {
		return this.txtsdate;
	}
	
	/**
	 * Column Info
	 * @return expnYrmon
	 */
	public String getExpnYrmon() {
		return this.expnYrmon;
	}
	
	/**
	 * Column Info
	 * @return err
	 */
	public String getErr() {
		return this.err;
	}
	

	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
	 * @param vslCls
	 */
	public void setVslCls(String vslCls) {
		this.vslCls = vslCls;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
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
	 * @param txtedate
	 */
	public void setTxtedate(String txtedate) {
		this.txtedate = txtedate;
	}
	
	/**
	 * Column Info
	 * @param txtsdate
	 */
	public void setTxtsdate(String txtsdate) {
		this.txtsdate = txtsdate;
	}
	
	/**
	 * Column Info
	 * @param expnYrmon
	 */
	public void setExpnYrmon(String expnYrmon) {
		this.expnYrmon = expnYrmon;
	}
	
	/**
	 * Column Info
	 * @param err
	 */
	public void setErr(String err) {
		this.err = err;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRmk(JSPUtil.getParameter(request, "rmk", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVslCls(JSPUtil.getParameter(request, "vsl_cls", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setAmt(JSPUtil.getParameter(request, "amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTxtedate(JSPUtil.getParameter(request, "txtedate", ""));
		setTxtsdate(JSPUtil.getParameter(request, "txtsdate", ""));
		setExpnYrmon(JSPUtil.getParameter(request, "expn_yrmon", ""));
		setErr(JSPUtil.getParameter(request, "err", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortChgBudByYearVO[]
	 */
	public PortChgBudByYearVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortChgBudByYearVO[]
	 */
	public PortChgBudByYearVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortChgBudByYearVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslCls = (JSPUtil.getParameter(request, prefix	+ "vsl_cls", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] txtedate = (JSPUtil.getParameter(request, prefix	+ "txtedate", length));
			String[] txtsdate = (JSPUtil.getParameter(request, prefix	+ "txtsdate", length));
			String[] expnYrmon = (JSPUtil.getParameter(request, prefix	+ "expn_yrmon", length));
			String[] err = (JSPUtil.getParameter(request, prefix	+ "err", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortChgBudByYearVO();
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslCls[i] != null)
					model.setVslCls(vslCls[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (txtedate[i] != null)
					model.setTxtedate(txtedate[i]);
				if (txtsdate[i] != null)
					model.setTxtsdate(txtsdate[i]);
				if (expnYrmon[i] != null)
					model.setExpnYrmon(expnYrmon[i]);
				if (err[i] != null)
					model.setErr(err[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortChgBudByYearVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortChgBudByYearVO[]
	 */
	public PortChgBudByYearVO[] getPortChgBudByYearVOs(){
		PortChgBudByYearVO[] vos = (PortChgBudByYearVO[])models.toArray(new PortChgBudByYearVO[models.size()]);
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
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCls = this.vslCls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtedate = this.txtedate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtsdate = this.txtsdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnYrmon = this.expnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err = this.err .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
