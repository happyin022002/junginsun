/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SimulationConditionVO.java
*@FileTitle : SimulationConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.25
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.01.22 정명훈 
* 1.0 Creation
*
* History
* 2012.09.25 진마리아 CHM-201220208-01 YD/ACCT별 Detail 비용을 Excel Down 기능 추가
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SimulationConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SimulationConditionVO> models = new ArrayList<SimulationConditionVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String issueDate = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String yardCd = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String acctEngNm = null;
	private boolean budget = false;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SimulationConditionVO() {}

	public SimulationConditionVO(String ibflag, String pagerows, String portCd, String yardCd, String acctCd, String costCd, String vndrSeq, String vndrLglEngNm, String vslCd, String skdVoyNo, String skdDirCd, String issueDate, String vvd, String ydChgNo, String ydChgVerSeq, String currCd, String acctEngNm) {
		this.vslCd = vslCd;
		this.currCd = currCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.skdVoyNo = skdVoyNo;
		this.issueDate = issueDate;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.yardCd = yardCd;
		this.costCd = costCd;
		this.ydChgVerSeq = ydChgVerSeq;
		this.vndrSeq = vndrSeq;
		this.acctCd = acctCd;
		this.ydChgNo = ydChgNo;
		this.portCd = portCd;
		this.acctEngNm = acctEngNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("issue_date", getIssueDate());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yard_cd", getYardCd());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("issue_date", "issueDate");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return issueDate
	 */
	public String getIssueDate() {
		return this.issueDate;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return yardCd
	 */
	public String getYardCd() {
		return this.yardCd;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
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
	 * @return acctEngNm
	 */
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	
	public boolean isBudget() {
		return this.budget;
	}
	
	public void setBudget(boolean budget){
		this.budget = budget;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param issueDate
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param yardCd
	 */
	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
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
	 * @param acctEngNm
	 */
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setIssueDate(JSPUtil.getParameter(request, prefix + "issue_date", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYardCd(JSPUtil.getParameter(request, prefix + "yard_cd", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, prefix + "yd_chg_ver_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setYdChgNo(JSPUtil.getParameter(request, prefix + "yd_chg_no", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setAcctEngNm(JSPUtil.getParameter(request, prefix + "acct_eng_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SimulationConditionVO[]
	 */
	public SimulationConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SimulationConditionVO[]
	 */
	public SimulationConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SimulationConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] issueDate = (JSPUtil.getParameter(request, prefix	+ "issue_date", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] yardCd = (JSPUtil.getParameter(request, prefix	+ "yard_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SimulationConditionVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (issueDate[i] != null)
					model.setIssueDate(issueDate[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (yardCd[i] != null)
					model.setYardCd(yardCd[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSimulationConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SimulationConditionVO[]
	 */
	public SimulationConditionVO[] getSimulationConditionVOs(){
		SimulationConditionVO[] vos = (SimulationConditionVO[])models.toArray(new SimulationConditionVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDate = this.issueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd = this.yardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
