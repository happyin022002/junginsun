/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VslDepRptErrVO.java
*@FileTitle : VslDepRptErrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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

public class VslDepRptErrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslDepRptErrVO> models = new ArrayList<VslDepRptErrVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String intgCdValDesc = null;
	/* Column Info */
	private String depRptErrSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rupDt = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String depPortCd = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Column Info */
	private String depRptErrTpCd = null;
	/* Column Info */
	private String sbEngDt = null;
	/* Page Number */
	private String pagerows = null;
	
	private List<VslDepRptErrVO> 	depRptErrDelVOs 	= null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VslDepRptErrVO() {}

	public VslDepRptErrVO(String ibflag, String pagerows, String depRptErrSeq, String vvd, String depPortCd, String clptIndSeq, String depRptErrTpCd, String intgCdValDesc, String vslSlanCd, String nxtPortCd, String rupDt, String rcvDt, String rcvSeq, String sbEngDt) {
		this.vvd = vvd;
		this.intgCdValDesc = intgCdValDesc;
		this.depRptErrSeq = depRptErrSeq;
		this.ibflag = ibflag;
		this.rupDt = rupDt;
		this.rcvDt = rcvDt;
		this.clptIndSeq = clptIndSeq;
		this.depPortCd = depPortCd;
		this.rcvSeq = rcvSeq;
		this.vslSlanCd = vslSlanCd;
		this.nxtPortCd = nxtPortCd;
		this.depRptErrTpCd = depRptErrTpCd;
		this.pagerows = pagerows;
		this.sbEngDt = sbEngDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("intg_cd_val_desc", getIntgCdValDesc());
		this.hashColumns.put("dep_rpt_err_seq", getDepRptErrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rup_dt", getRupDt());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("dep_port_cd", getDepPortCd());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("dep_rpt_err_tp_cd", getDepRptErrTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sb_eng_dt", getSbEngDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("intg_cd_val_desc", "intgCdValDesc");
		this.hashFields.put("dep_rpt_err_seq", "depRptErrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rup_dt", "rupDt");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("dep_port_cd", "depPortCd");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("dep_rpt_err_tp_cd", "depRptErrTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sb_eng_dt", "sbEngDt");
		return this.hashFields;
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
	 * @return intgCdValDesc
	 */
	public String getIntgCdValDesc() {
		return this.intgCdValDesc;
	}
	
	/**
	 * Column Info
	 * @return depRptErrSeq
	 */
	public String getDepRptErrSeq() {
		return this.depRptErrSeq;
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
	 * @return rupDt
	 */
	public String getRupDt() {
		return this.rupDt;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
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
	 * @return depPortCd
	 */
	public String getDepPortCd() {
		return this.depPortCd;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
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
	 * @return nxtPortCd
	 */
	public String getNxtPortCd() {
		return this.nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @return depRptErrTpCd
	 */
	public String getDepRptErrTpCd() {
		return this.depRptErrTpCd;
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
	 * @return sbEngDt
	 */
	public String getSbEngDt() {
		return this.sbEngDt;
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
	 * @param intgCdValDesc
	 */
	public void setIntgCdValDesc(String intgCdValDesc) {
		this.intgCdValDesc = intgCdValDesc;
	}
	
	/**
	 * Column Info
	 * @param depRptErrSeq
	 */
	public void setDepRptErrSeq(String depRptErrSeq) {
		this.depRptErrSeq = depRptErrSeq;
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
	 * @param rupDt
	 */
	public void setRupDt(String rupDt) {
		this.rupDt = rupDt;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
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
	 * @param depPortCd
	 */
	public void setDepPortCd(String depPortCd) {
		this.depPortCd = depPortCd;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
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
	 * @param nxtPortCd
	 */
	public void setNxtPortCd(String nxtPortCd) {
		this.nxtPortCd = nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @param depRptErrTpCd
	 */
	public void setDepRptErrTpCd(String depRptErrTpCd) {
		this.depRptErrTpCd = depRptErrTpCd;
	}
	
	
	/**
	 * @return List<VslDepRptErrVO>
	 */
	public List<VslDepRptErrVO> getdepRptErrDelVOs() {
		return depRptErrDelVOs;
	}

	/**
	 * @param List<VslDepRptErrVO> depRptErrDelVOs
	 */
	public void setdepRptErrDelVOs(List<VslDepRptErrVO> depRptErrDelVOs) {
		this.depRptErrDelVOs = depRptErrDelVOs;
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
	 * @param sbEngDt
	 */
	public void setSbEngDt(String sbEngDt) {
		this.sbEngDt = sbEngDt;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIntgCdValDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_desc", ""));
		setDepRptErrSeq(JSPUtil.getParameter(request, prefix + "dep_rpt_err_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRupDt(JSPUtil.getParameter(request, prefix + "rup_dt", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setDepPortCd(JSPUtil.getParameter(request, prefix + "dep_port_cd", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setDepRptErrTpCd(JSPUtil.getParameter(request, prefix + "dep_rpt_err_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSbEngDt(JSPUtil.getParameter(request, prefix + "sb_eng_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslDepRptErrVO[]
	 */
	public VslDepRptErrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslDepRptErrVO[]
	 */
	public VslDepRptErrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslDepRptErrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] intgCdValDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_desc", length));
			String[] depRptErrSeq = (JSPUtil.getParameter(request, prefix	+ "dep_rpt_err_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rupDt = (JSPUtil.getParameter(request, prefix	+ "rup_dt", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] depPortCd = (JSPUtil.getParameter(request, prefix	+ "dep_port_cd", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] depRptErrTpCd = (JSPUtil.getParameter(request, prefix	+ "dep_rpt_err_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sbEngDt = (JSPUtil.getParameter(request, prefix	+ "sb_eng_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslDepRptErrVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (intgCdValDesc[i] != null)
					model.setIntgCdValDesc(intgCdValDesc[i]);
				if (depRptErrSeq[i] != null)
					model.setDepRptErrSeq(depRptErrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rupDt[i] != null)
					model.setRupDt(rupDt[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (depPortCd[i] != null)
					model.setDepPortCd(depPortCd[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (depRptErrTpCd[i] != null)
					model.setDepRptErrTpCd(depRptErrTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sbEngDt[i] != null)
					model.setSbEngDt(sbEngDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslDepRptErrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslDepRptErrVO[]
	 */
	public VslDepRptErrVO[] getVslDepRptErrVOs(){
		VslDepRptErrVO[] vos = (VslDepRptErrVO[])models.toArray(new VslDepRptErrVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDesc = this.intgCdValDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRptErrSeq = this.depRptErrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rupDt = this.rupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depPortCd = this.depPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRptErrTpCd = this.depRptErrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbEngDt = this.sbEngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
