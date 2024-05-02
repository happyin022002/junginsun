/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WkEstmBackDataVO.java
*@FileTitle : WkEstmBackDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.23
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.23 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WkEstmBackDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WkEstmBackDataVO> models = new ArrayList<WkEstmBackDataVO>();
	
	/* Column Info */
	private String seaHrs = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String nxtGmt = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String nxtEtaDt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gmt = null;
	/* Column Info */
	private String trndLineSeq = null;
	/* Column Info */
	private String portHrs = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String vvdSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public WkEstmBackDataVO() {}

	public WkEstmBackDataVO(String ibflag, String pagerows, String vvdSeq, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String clptSeq, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String gmt, String mnvrInHrs, String mnvrOutHrs, String seaBufHrs, String portHrs, String portSeq, String nxtPortCd, String nxtEtaDt, String nxtGmt, String seaHrs, String trndLineSeq) {
		this.seaHrs = seaHrs;
		this.mnvrOutHrs = mnvrOutHrs;
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.vpsEtdDt = vpsEtdDt;
		this.nxtGmt = nxtGmt;
		this.seaBufHrs = seaBufHrs;
		this.skdVoyNo = skdVoyNo;
		this.nxtEtaDt = nxtEtaDt;
		this.vpsEtaDt = vpsEtaDt;
		this.nxtPortCd = nxtPortCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.mnvrInHrs = mnvrInHrs;
		this.portSeq = portSeq;
		this.vpsPortCd = vpsPortCd;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.gmt = gmt;
		this.trndLineSeq = trndLineSeq;
		this.portHrs = portHrs;
		this.clptIndSeq = clptIndSeq;
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sea_hrs", getSeaHrs());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("nxt_gmt", getNxtGmt());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("nxt_eta_dt", getNxtEtaDt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gmt", getGmt());
		this.hashColumns.put("trnd_line_seq", getTrndLineSeq());
		this.hashColumns.put("port_hrs", getPortHrs());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sea_hrs", "seaHrs");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("nxt_gmt", "nxtGmt");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("nxt_eta_dt", "nxtEtaDt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gmt", "gmt");
		this.hashFields.put("trnd_line_seq", "trndLineSeq");
		this.hashFields.put("port_hrs", "portHrs");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("vvd_seq", "vvdSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return seaHrs
	 */
	public String getSeaHrs() {
		return this.seaHrs;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutHrs
	 */
	public String getMnvrOutHrs() {
		return this.mnvrOutHrs;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return nxtGmt
	 */
	public String getNxtGmt() {
		return this.nxtGmt;
	}
	
	/**
	 * Column Info
	 * @return seaBufHrs
	 */
	public String getSeaBufHrs() {
		return this.seaBufHrs;
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
	 * @return nxtEtaDt
	 */
	public String getNxtEtaDt() {
		return this.nxtEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return mnvrInHrs
	 */
	public String getMnvrInHrs() {
		return this.mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
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
	 * @return gmt
	 */
	public String getGmt() {
		return this.gmt;
	}
	
	/**
	 * Column Info
	 * @return trndLineSeq
	 */
	public String getTrndLineSeq() {
		return this.trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @return portHrs
	 */
	public String getPortHrs() {
		return this.portHrs;
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
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	

	/**
	 * Column Info
	 * @param seaHrs
	 */
	public void setSeaHrs(String seaHrs) {
		this.seaHrs = seaHrs;
	}
	
	/**
	 * Column Info
	 * @param mnvrOutHrs
	 */
	public void setMnvrOutHrs(String mnvrOutHrs) {
		this.mnvrOutHrs = mnvrOutHrs;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param nxtGmt
	 */
	public void setNxtGmt(String nxtGmt) {
		this.nxtGmt = nxtGmt;
	}
	
	/**
	 * Column Info
	 * @param seaBufHrs
	 */
	public void setSeaBufHrs(String seaBufHrs) {
		this.seaBufHrs = seaBufHrs;
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
	 * @param nxtEtaDt
	 */
	public void setNxtEtaDt(String nxtEtaDt) {
		this.nxtEtaDt = nxtEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param mnvrInHrs
	 */
	public void setMnvrInHrs(String mnvrInHrs) {
		this.mnvrInHrs = mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
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
	 * @param gmt
	 */
	public void setGmt(String gmt) {
		this.gmt = gmt;
	}
	
	/**
	 * Column Info
	 * @param trndLineSeq
	 */
	public void setTrndLineSeq(String trndLineSeq) {
		this.trndLineSeq = trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @param portHrs
	 */
	public void setPortHrs(String portHrs) {
		this.portHrs = portHrs;
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
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
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
		setSeaHrs(JSPUtil.getParameter(request, prefix + "sea_hrs", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, prefix + "mnvr_out_hrs", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setNxtGmt(JSPUtil.getParameter(request, prefix + "nxt_gmt", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, prefix + "sea_buf_hrs", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setNxtEtaDt(JSPUtil.getParameter(request, prefix + "nxt_eta_dt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, prefix + "mnvr_in_hrs", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGmt(JSPUtil.getParameter(request, prefix + "gmt", ""));
		setTrndLineSeq(JSPUtil.getParameter(request, prefix + "trnd_line_seq", ""));
		setPortHrs(JSPUtil.getParameter(request, prefix + "port_hrs", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setVvdSeq(JSPUtil.getParameter(request, prefix + "vvd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WkEstmBackDataVO[]
	 */
	public WkEstmBackDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WkEstmBackDataVO[]
	 */
	public WkEstmBackDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WkEstmBackDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] seaHrs = (JSPUtil.getParameter(request, prefix	+ "sea_hrs", length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] nxtGmt = (JSPUtil.getParameter(request, prefix	+ "nxt_gmt", length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] nxtEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_eta_dt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gmt = (JSPUtil.getParameter(request, prefix	+ "gmt", length));
			String[] trndLineSeq = (JSPUtil.getParameter(request, prefix	+ "trnd_line_seq", length));
			String[] portHrs = (JSPUtil.getParameter(request, prefix	+ "port_hrs", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new WkEstmBackDataVO();
				if (seaHrs[i] != null)
					model.setSeaHrs(seaHrs[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (nxtGmt[i] != null)
					model.setNxtGmt(nxtGmt[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (nxtEtaDt[i] != null)
					model.setNxtEtaDt(nxtEtaDt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gmt[i] != null)
					model.setGmt(gmt[i]);
				if (trndLineSeq[i] != null)
					model.setTrndLineSeq(trndLineSeq[i]);
				if (portHrs[i] != null)
					model.setPortHrs(portHrs[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWkEstmBackDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WkEstmBackDataVO[]
	 */
	public WkEstmBackDataVO[] getWkEstmBackDataVOs(){
		WkEstmBackDataVO[] vos = (WkEstmBackDataVO[])models.toArray(new WkEstmBackDataVO[models.size()]);
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
		this.seaHrs = this.seaHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtGmt = this.nxtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtEtaDt = this.nxtEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmt = this.gmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineSeq = this.trndLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portHrs = this.portHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
