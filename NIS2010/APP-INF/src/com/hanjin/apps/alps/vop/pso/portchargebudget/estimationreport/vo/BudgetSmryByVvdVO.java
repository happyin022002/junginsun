/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BudgetSmryByVvdVO.java
*@FileTitle : BudgetSmryByVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.03
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2013.06.03 서관영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo;

import java.lang.reflect.Field;
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
 * @author 서관영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BudgetSmryByVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BudgetSmryByVvdVO> models = new ArrayList<BudgetSmryByVvdVO>();
	
	/* Column Info */
	private String totalCharge = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String canalFee = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String portCharge = null;
	/* Column Info */
	private String scnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String canalCnt = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String startDt = null;
	/* Column Info */
	private String portCnt = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Column Info */
	private String scnDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BudgetSmryByVvdVO() {}

	public BudgetSmryByVvdVO(String ibflag, String pagerows, String revYrmon, String rlaneCd, String vvd, String portCharge, String canalFee, String scnDt, String scnCd, String startDt, String endDt, String vvdCnt, String portCnt, String canalCnt, String totalCharge) {
		this.totalCharge = totalCharge;
		this.revYrmon = revYrmon;
		this.endDt = endDt;
		this.canalFee = canalFee;
		this.rlaneCd = rlaneCd;
		this.portCharge = portCharge;
		this.scnCd = scnCd;
		this.pagerows = pagerows;
		this.canalCnt = canalCnt;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.startDt = startDt;
		this.portCnt = portCnt;
		this.vvdCnt = vvdCnt;
		this.scnDt = scnDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total_charge", getTotalCharge());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("canal_fee", getCanalFee());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("port_charge", getPortCharge());
		this.hashColumns.put("scn_cd", getScnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("canal_cnt", getCanalCnt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("start_dt", getStartDt());
		this.hashColumns.put("port_cnt", getPortCnt());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("scn_dt", getScnDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total_charge", "totalCharge");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("canal_fee", "canalFee");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("port_charge", "portCharge");
		this.hashFields.put("scn_cd", "scnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("canal_cnt", "canalCnt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("start_dt", "startDt");
		this.hashFields.put("port_cnt", "portCnt");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("scn_dt", "scnDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totalCharge
	 */
	public String getTotalCharge() {
		return this.totalCharge;
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
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return canalFee
	 */
	public String getCanalFee() {
		return this.canalFee;
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
	 * @return portCharge
	 */
	public String getPortCharge() {
		return this.portCharge;
	}
	
	/**
	 * Column Info
	 * @return scnCd
	 */
	public String getScnCd() {
		return this.scnCd;
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
	 * @return canalCnt
	 */
	public String getCanalCnt() {
		return this.canalCnt;
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
	 * @return startDt
	 */
	public String getStartDt() {
		return this.startDt;
	}
	
	/**
	 * Column Info
	 * @return portCnt
	 */
	public String getPortCnt() {
		return this.portCnt;
	}
	
	/**
	 * Column Info
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
	}
	
	/**
	 * Column Info
	 * @return scnDt
	 */
	public String getScnDt() {
		return this.scnDt;
	}
	

	/**
	 * Column Info
	 * @param totalCharge
	 */
	public void setTotalCharge(String totalCharge) {
		this.totalCharge = totalCharge;
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
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param canalFee
	 */
	public void setCanalFee(String canalFee) {
		this.canalFee = canalFee;
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
	 * @param portCharge
	 */
	public void setPortCharge(String portCharge) {
		this.portCharge = portCharge;
	}
	
	/**
	 * Column Info
	 * @param scnCd
	 */
	public void setScnCd(String scnCd) {
		this.scnCd = scnCd;
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
	 * @param canalCnt
	 */
	public void setCanalCnt(String canalCnt) {
		this.canalCnt = canalCnt;
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
	 * @param startDt
	 */
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	
	/**
	 * Column Info
	 * @param portCnt
	 */
	public void setPortCnt(String portCnt) {
		this.portCnt = portCnt;
	}
	
	/**
	 * Column Info
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
	}
	
	/**
	 * Column Info
	 * @param scnDt
	 */
	public void setScnDt(String scnDt) {
		this.scnDt = scnDt;
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
		setTotalCharge(JSPUtil.getParameter(request, prefix + "total_charge", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
		setCanalFee(JSPUtil.getParameter(request, prefix + "canal_fee", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPortCharge(JSPUtil.getParameter(request, prefix + "port_charge", ""));
		setScnCd(JSPUtil.getParameter(request, prefix + "scn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCanalCnt(JSPUtil.getParameter(request, prefix + "canal_cnt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStartDt(JSPUtil.getParameter(request, prefix + "start_dt", ""));
		setPortCnt(JSPUtil.getParameter(request, prefix + "port_cnt", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setScnDt(JSPUtil.getParameter(request, prefix + "scn_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BudgetSmryByVvdVO[]
	 */
	public BudgetSmryByVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BudgetSmryByVvdVO[]
	 */
	public BudgetSmryByVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BudgetSmryByVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totalCharge = (JSPUtil.getParameter(request, prefix	+ "total_charge", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] canalFee = (JSPUtil.getParameter(request, prefix	+ "canal_fee", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] portCharge = (JSPUtil.getParameter(request, prefix	+ "port_charge", length));
			String[] scnCd = (JSPUtil.getParameter(request, prefix	+ "scn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] canalCnt = (JSPUtil.getParameter(request, prefix	+ "canal_cnt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] startDt = (JSPUtil.getParameter(request, prefix	+ "start_dt", length));
			String[] portCnt = (JSPUtil.getParameter(request, prefix	+ "port_cnt", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] scnDt = (JSPUtil.getParameter(request, prefix	+ "scn_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BudgetSmryByVvdVO();
				if (totalCharge[i] != null)
					model.setTotalCharge(totalCharge[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (canalFee[i] != null)
					model.setCanalFee(canalFee[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (portCharge[i] != null)
					model.setPortCharge(portCharge[i]);
				if (scnCd[i] != null)
					model.setScnCd(scnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (canalCnt[i] != null)
					model.setCanalCnt(canalCnt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (startDt[i] != null)
					model.setStartDt(startDt[i]);
				if (portCnt[i] != null)
					model.setPortCnt(portCnt[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (scnDt[i] != null)
					model.setScnDt(scnDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBudgetSmryByVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BudgetSmryByVvdVO[]
	 */
	public BudgetSmryByVvdVO[] getBudgetSmryByVvdVOs(){
		BudgetSmryByVvdVO[] vos = (BudgetSmryByVvdVO[])models.toArray(new BudgetSmryByVvdVO[models.size()]);
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
		this.totalCharge = this.totalCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.canalFee = this.canalFee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCharge = this.portCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnCd = this.scnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.canalCnt = this.canalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDt = this.startDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCnt = this.portCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnDt = this.scnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
