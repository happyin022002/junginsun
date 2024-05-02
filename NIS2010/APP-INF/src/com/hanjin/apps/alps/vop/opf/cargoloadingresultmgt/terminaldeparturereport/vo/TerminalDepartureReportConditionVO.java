/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportConditionVO.java
*@FileTitle : TerminalDepartureReportConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.27
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.01.27 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TerminalDepartureReportConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TerminalDepartureReportConditionVO> models = new ArrayList<TerminalDepartureReportConditionVO>();
	
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String targetPorts = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String groupBy = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String manuInTime = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String optionCd = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String mishandlechk = null;
	/* Column Info */
	private String carrCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String targetLanes = null;
	/* Column Info */
	private String tmlProdRptRsnCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String avgGang = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TerminalDepartureReportConditionVO() {}

	public TerminalDepartureReportConditionVO(String ibflag, String pagerows, String locCd, String ydCd, String slanCd, String fromDate, String toDate, String oprCd, String optionCd, String rhq, String vslCd, String manuInTime, String dirCd, String carrCd, String tmlProdRptRsnCd, String groupBy, String voyNo, String mishandlechk, String targetPorts, String targetLanes, String clptIndSeq, String pageNo, String avgGang) {
		this.voyNo = voyNo;
		this.vslCd = vslCd;
		this.toDate = toDate;
		this.targetPorts = targetPorts;
		this.pagerows = pagerows;
		this.groupBy = groupBy;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.manuInTime = manuInTime;
		this.slanCd = slanCd;
		this.fromDate = fromDate;
		this.ydCd = ydCd;
		this.oprCd = oprCd;
		this.optionCd = optionCd;
		this.pageNo = pageNo;
		this.clptIndSeq = clptIndSeq;
		this.mishandlechk = mishandlechk;
		this.carrCd = carrCd;
		this.dirCd = dirCd;
		this.targetLanes = targetLanes;
		this.tmlProdRptRsnCd = tmlProdRptRsnCd;
		this.rhq = rhq;
		this.avgGang = avgGang;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("target_ports", getTargetPorts());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("group_by", getGroupBy());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("manu_in_time", getManuInTime());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("option_cd", getOptionCd());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("mishandlechk", getMishandlechk());
		this.hashColumns.put("carr_cd", getCarrCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("target_lanes", getTargetLanes());
		this.hashColumns.put("tml_prod_rpt_rsn_cd", getTmlProdRptRsnCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("avg_gang", getAvgGang());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("target_ports", "targetPorts");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("group_by", "groupBy");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("manu_in_time", "manuInTime");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("option_cd", "optionCd");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("mishandlechk", "mishandlechk");
		this.hashFields.put("carr_cd", "carrCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("target_lanes", "targetLanes");
		this.hashFields.put("tml_prod_rpt_rsn_cd", "tmlProdRptRsnCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("avg_gang", "avgGang");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
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
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return targetPorts
	 */
	public String getTargetPorts() {
		return this.targetPorts;
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
	 * @return groupBy
	 */
	public String getGroupBy() {
		return this.groupBy;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return manuInTime
	 */
	public String getManuInTime() {
		return this.manuInTime;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
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
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return optionCd
	 */
	public String getOptionCd() {
		return this.optionCd;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return mishandlechk
	 */
	public String getMishandlechk() {
		return this.mishandlechk;
	}
	
	/**
	 * Column Info
	 * @return carrCd
	 */
	public String getCarrCd() {
		return this.carrCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return targetLanes
	 */
	public String getTargetLanes() {
		return this.targetLanes;
	}
	
	/**
	 * Column Info
	 * @return tmlProdRptRsnCd
	 */
	public String getTmlProdRptRsnCd() {
		return this.tmlProdRptRsnCd;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return avgCrane
	 */
	public String getAvgGang() {
		return this.avgGang;
	}
	

	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
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
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param targetPorts
	 */
	public void setTargetPorts(String targetPorts) {
		this.targetPorts = targetPorts;
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
	 * @param groupBy
	 */
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param manuInTime
	 */
	public void setManuInTime(String manuInTime) {
		this.manuInTime = manuInTime;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
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
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param optionCd
	 */
	public void setOptionCd(String optionCd) {
		this.optionCd = optionCd;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param mishandlechk
	 */
	public void setMishandlechk(String mishandlechk) {
		this.mishandlechk = mishandlechk;
	}
	
	/**
	 * Column Info
	 * @param carrCd
	 */
	public void setCarrCd(String carrCd) {
		this.carrCd = carrCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param targetLanes
	 */
	public void setTargetLanes(String targetLanes) {
		this.targetLanes = targetLanes;
	}
	
	/**
	 * Column Info
	 * @param tmlProdRptRsnCd
	 */
	public void setTmlProdRptRsnCd(String tmlProdRptRsnCd) {
		this.tmlProdRptRsnCd = tmlProdRptRsnCd;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param avgCrane
	 */
	public void setAvgGang(String avgGang) {
		this.avgGang = avgGang;
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
		setVoyNo(JSPUtil.getParameter(request, prefix + "voy_no", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setTargetPorts(JSPUtil.getParameter(request, prefix + "target_ports", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGroupBy(JSPUtil.getParameter(request, prefix + "group_by", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setManuInTime(JSPUtil.getParameter(request, prefix + "manu_in_time", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setOptionCd(JSPUtil.getParameter(request, prefix + "option_cd", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setMishandlechk(JSPUtil.getParameter(request, prefix + "mishandlechk", ""));
		setCarrCd(JSPUtil.getParameter(request, prefix + "carr_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setTargetLanes(JSPUtil.getParameter(request, prefix + "target_lanes", ""));
		setTmlProdRptRsnCd(JSPUtil.getParameter(request, prefix + "tml_prod_rpt_rsn_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setAvgGang(JSPUtil.getParameter(request, prefix + "avg_gang", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TerminalDepartureReportConditionVO[]
	 */
	public TerminalDepartureReportConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TerminalDepartureReportConditionVO[]
	 */
	public TerminalDepartureReportConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TerminalDepartureReportConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] targetPorts = (JSPUtil.getParameter(request, prefix	+ "target_ports", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] groupBy = (JSPUtil.getParameter(request, prefix	+ "group_by", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] manuInTime = (JSPUtil.getParameter(request, prefix	+ "manu_in_time", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] optionCd = (JSPUtil.getParameter(request, prefix	+ "option_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] mishandlechk = (JSPUtil.getParameter(request, prefix	+ "mishandlechk", length));
			String[] carrCd = (JSPUtil.getParameter(request, prefix	+ "carr_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] targetLanes = (JSPUtil.getParameter(request, prefix	+ "target_lanes", length));
			String[] tmlProdRptRsnCd = (JSPUtil.getParameter(request, prefix	+ "tml_prod_rpt_rsn_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] avgGang = (JSPUtil.getParameter(request, prefix	+ "avg_gang", length));
			
			for (int i = 0; i < length; i++) {
				model = new TerminalDepartureReportConditionVO();
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (targetPorts[i] != null)
					model.setTargetPorts(targetPorts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (groupBy[i] != null)
					model.setGroupBy(groupBy[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (manuInTime[i] != null)
					model.setManuInTime(manuInTime[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (optionCd[i] != null)
					model.setOptionCd(optionCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (mishandlechk[i] != null)
					model.setMishandlechk(mishandlechk[i]);
				if (carrCd[i] != null)
					model.setCarrCd(carrCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (targetLanes[i] != null)
					model.setTargetLanes(targetLanes[i]);
				if (tmlProdRptRsnCd[i] != null)
					model.setTmlProdRptRsnCd(tmlProdRptRsnCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (avgGang[i] != null)
					model.setAvgGang(avgGang[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTerminalDepartureReportConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TerminalDepartureReportConditionVO[]
	 */
	public TerminalDepartureReportConditionVO[] getTerminalDepartureReportConditionVOs(){
		TerminalDepartureReportConditionVO[] vos = (TerminalDepartureReportConditionVO[])models.toArray(new TerminalDepartureReportConditionVO[models.size()]);
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
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetPorts = this.targetPorts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupBy = this.groupBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuInTime = this.manuInTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optionCd = this.optionCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mishandlechk = this.mishandlechk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrCd = this.carrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetLanes = this.targetLanes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdRptRsnCd = this.tmlProdRptRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgGang = this.avgGang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
