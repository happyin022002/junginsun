/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VvdPortTariffVO.java
*@FileTitle : VvdPortTariffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class VvdPortTariffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdPortTariffVO> models = new ArrayList<VvdPortTariffVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String portSurchargeExistYn = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String portSurOrDcExistYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String portTariffUsdAmt = null;
	/* Column Info */
	private String ydTtlUsdAmt = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String portDiscountExistYn = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String portTariffAmt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VvdPortTariffVO() {}

	public VvdPortTariffVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String clptIndSeq, String clptSeq, String vpsPortCd, String portCd, String callYdIndSeq, String turnPortIndCd, String currCd, String portTariffAmt, String portTariffUsdAmt, String ydCd, String portSurchargeExistYn, String portDiscountExistYn, String portSurOrDcExistYn, String ydTtlUsdAmt) {
		this.vslCd = vslCd;
		this.portSurchargeExistYn = portSurchargeExistYn;
		this.currCd = currCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.portSurOrDcExistYn = portSurOrDcExistYn;
		this.pagerows = pagerows;
		this.turnPortIndCd = turnPortIndCd;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.portTariffUsdAmt = portTariffUsdAmt;
		this.ydCd = ydCd;
		this.vpsPortCd = vpsPortCd;
		this.clptIndSeq = clptIndSeq;
		this.portDiscountExistYn = portDiscountExistYn;
		this.callYdIndSeq = callYdIndSeq;
		this.portTariffAmt = portTariffAmt;
		this.ydTtlUsdAmt = ydTtlUsdAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());

		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("port_tariff_usd_amt", getPortTariffUsdAmt());
		this.hashColumns.put("port_tariff_amt", getPortTariffAmt());
		
		this.hashColumns.put("port_surcharge_exist_yn", getPortSurchargeExistYn());
		this.hashColumns.put("port_sur_or_dc_exist_yn", getPortSurOrDcExistYn());
		this.hashColumns.put("port_discount_exist_yn", getPortDiscountExistYn());
		
		this.hashColumns.put("yd_ttl_usd_amt", getYdTtlUsdAmt());
		
		this.hashColumns.put("pagerows", getPagerows());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("port_surcharge_exist_yn", "portSurchargeExistYn");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("port_sur_or_dc_exist_yn", "portSurOrDcExistYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_tariff_usd_amt", "portTariffUsdAmt");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("port_discount_exist_yn"			, "portDiscountExistYn"			);
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("port_tariff_amt", "portTariffAmt");
		this.hashFields.put("yd_ttl_usd_amt", "ydTtlUsdAmt");
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
	 * @return portSurchargeExistYn
	 */
	public String getPortSurchargeExistYn() {
		return this.portSurchargeExistYn;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return portSurOrDcExistYn
	 */
	public String getPortSurOrDcExistYn() {
		return this.portSurOrDcExistYn;
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
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return portTariffUsdAmt
	 */
	public String getPortTariffUsdAmt() {
		return this.portTariffUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return portDiscountExistYn
	 */
	public String getPortDiscountExistYn() {
		return this.portDiscountExistYn;
	}
	
	/**
	 * Column Info
	 * @return callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @return portTariffAmt
	 */
	public String getPortTariffAmt() {
		return this.portTariffAmt;
	}
	
	/**
	 * Column Info
	 * @return ydTtlUsdAmt
	 */
	public String getYdTtlUsdAmt() {
		return this.ydTtlUsdAmt;
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
	 * @param portSurchargeExistYn
	 */
	public void setPortSurchargeExistYn(String portSurchargeExistYn) {
		this.portSurchargeExistYn = portSurchargeExistYn;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param portSurOrDcExistYn
	 */
	public void setPortSurOrDcExistYn(String portSurOrDcExistYn) {
		this.portSurOrDcExistYn = portSurOrDcExistYn;
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
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param portTariffUsdAmt
	 */
	public void setPortTariffUsdAmt(String portTariffUsdAmt) {
		this.portTariffUsdAmt = portTariffUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param portDiscountExistYn
	 */
	public void setPortDiscountExistYn(String portDiscountExistYn) {
		this.portDiscountExistYn = portDiscountExistYn;
	}
	
	/**
	 * Column Info
	 * @param callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @param portTariffAmt
	 */
	public void setPortTariffAmt(String portTariffAmt) {
		this.portTariffAmt = portTariffAmt;
	}
	
	/**
	 * Column Info
	 * @param ydTtlUsdAmt
	 */
	public void setYdTtlUsdAmt(String ydTtlUsdAmt) {
		this.ydTtlUsdAmt = ydTtlUsdAmt;
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
		setPortSurchargeExistYn(JSPUtil.getParameter(request, prefix + "port_surcharge_exist_yn", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPortSurOrDcExistYn(JSPUtil.getParameter(request, prefix + "port_sur_or_dc_exist_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPortTariffUsdAmt(JSPUtil.getParameter(request, prefix + "port_tariff_usd_amt", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setPortDiscountExistYn(JSPUtil.getParameter(request, prefix + "port_discount_exist_yn", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
		setPortTariffAmt(JSPUtil.getParameter(request, prefix + "port_tariff_amt", ""));
		setYdTtlUsdAmt(JSPUtil.getParameter(request, prefix + "yd_ttl_usd_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdPortTariffVO[]
	 */
	public VvdPortTariffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdPortTariffVO[]
	 */
	public VvdPortTariffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdPortTariffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] portSurchargeExistYn = (JSPUtil.getParameter(request, prefix	+ "port_surcharge_exist_yn", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] portSurOrDcExistYn = (JSPUtil.getParameter(request, prefix	+ "port_sur_or_dc_exist_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] portTariffUsdAmt = (JSPUtil.getParameter(request, prefix	+ "port_tariff_usd_amt", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] portDiscountExistYn = (JSPUtil.getParameter(request, prefix	+ "port_discount_exist_yn", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] portTariffAmt = (JSPUtil.getParameter(request, prefix	+ "port_tariff_amt", length));
			String[] ydTtlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "yd_ttl_usd_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdPortTariffVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (portSurchargeExistYn[i] != null)
					model.setPortSurchargeExistYn(portSurchargeExistYn[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (portSurOrDcExistYn[i] != null)
					model.setPortSurOrDcExistYn(portSurOrDcExistYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (portTariffUsdAmt[i] != null)
					model.setPortTariffUsdAmt(portTariffUsdAmt[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (portDiscountExistYn[i] != null)
					model.setPortDiscountExistYn(portDiscountExistYn[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (portTariffAmt[i] != null)
					model.setPortTariffAmt(portTariffAmt[i]);
				if (ydTtlUsdAmt[i] != null)
					model.setYdTtlUsdAmt(ydTtlUsdAmt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdPortTariffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdPortTariffVO[]
	 */
	public VvdPortTariffVO[] getVvdPortTariffVOs(){
		VvdPortTariffVO[] vos = (VvdPortTariffVO[])models.toArray(new VvdPortTariffVO[models.size()]);
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
		this.portSurchargeExistYn = this.portSurchargeExistYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSurOrDcExistYn = this.portSurOrDcExistYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTariffUsdAmt = this.portTariffUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDiscountExistYn = this.portDiscountExistYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTariffAmt = this.portTariffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydTtlUsdAmt = this.ydTtlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
