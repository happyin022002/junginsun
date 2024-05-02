/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : vslSkdCtntVO.java
*@FileTitle : vslSkdCtntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.27
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.07.27 박준용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박준용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class vslSkdCtntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<vslSkdCtntVO> models = new ArrayList<vslSkdCtntVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfEtdDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vesselName = null;
	/* Column Info */
	private String delayDep = null;
	/* Column Info */
	private String delayBerth = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pfEtbDt = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public vslSkdCtntVO() {}

	public vslSkdCtntVO(String ibflag, String pagerows, String vvd, String vesselName, String pol, String lane, String vpsEtbDt, String vpsEtdDt, String pfEtbDt, String pfEtdDt, String delayBerth, String delayDep) {
		this.vvd = vvd;
		this.vpsEtbDt = vpsEtbDt;
		this.ibflag = ibflag;
		this.pfEtdDt = pfEtdDt;
		this.vpsEtdDt = vpsEtdDt;
		this.vesselName = vesselName;
		this.delayDep = delayDep;
		this.delayBerth = delayBerth;
		this.pol = pol;
		this.pfEtbDt = pfEtbDt;
		this.lane = lane;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vessel_name", getVesselName());
		this.hashColumns.put("delay_dep", getDelayDep());
		this.hashColumns.put("delay_berth", getDelayBerth());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vessel_name", "vesselName");
		this.hashFields.put("delay_dep", "delayDep");
		this.hashFields.put("delay_berth", "delayBerth");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
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
	 * @return pfEtdDt
	 */
	public String getPfEtdDt() {
		return this.pfEtdDt;
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
	 * @return vesselName
	 */
	public String getVesselName() {
		return this.vesselName;
	}
	
	/**
	 * Column Info
	 * @return delayDep
	 */
	public String getDelayDep() {
		return this.delayDep;
	}
	
	/**
	 * Column Info
	 * @return delayBerth
	 */
	public String getDelayBerth() {
		return this.delayBerth;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return pfEtbDt
	 */
	public String getPfEtbDt() {
		return this.pfEtbDt;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
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
	 * @param pfEtdDt
	 */
	public void setPfEtdDt(String pfEtdDt) {
		this.pfEtdDt = pfEtdDt;
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
	 * @param vesselName
	 */
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	
	/**
	 * Column Info
	 * @param delayDep
	 */
	public void setDelayDep(String delayDep) {
		this.delayDep = delayDep;
	}
	
	/**
	 * Column Info
	 * @param delayBerth
	 */
	public void setDelayBerth(String delayBerth) {
		this.delayBerth = delayBerth;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param pfEtbDt
	 */
	public void setPfEtbDt(String pfEtbDt) {
		this.pfEtbDt = pfEtbDt;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setVesselName(JSPUtil.getParameter(request, prefix + "vessel_name", ""));
		setDelayDep(JSPUtil.getParameter(request, prefix + "delay_dep", ""));
		setDelayBerth(JSPUtil.getParameter(request, prefix + "delay_berth", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return vslSkdCtntVO[]
	 */
	public vslSkdCtntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return vslSkdCtntVO[]
	 */
	public vslSkdCtntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		vslSkdCtntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] vesselName = (JSPUtil.getParameter(request, prefix	+ "vessel_name", length));
			String[] delayDep = (JSPUtil.getParameter(request, prefix	+ "delay_dep", length));
			String[] delayBerth = (JSPUtil.getParameter(request, prefix	+ "delay_berth", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new vslSkdCtntVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfEtdDt[i] != null)
					model.setPfEtdDt(pfEtdDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vesselName[i] != null)
					model.setVesselName(vesselName[i]);
				if (delayDep[i] != null)
					model.setDelayDep(delayDep[i]);
				if (delayBerth[i] != null)
					model.setDelayBerth(delayBerth[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pfEtbDt[i] != null)
					model.setPfEtbDt(pfEtbDt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getvslSkdCtntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return vslSkdCtntVO[]
	 */
	public vslSkdCtntVO[] getvslSkdCtntVOs(){
		vslSkdCtntVO[] vos = (vslSkdCtntVO[])models.toArray(new vslSkdCtntVO[models.size()]);
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
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselName = this.vesselName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delayDep = this.delayDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delayBerth = this.delayBerth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
