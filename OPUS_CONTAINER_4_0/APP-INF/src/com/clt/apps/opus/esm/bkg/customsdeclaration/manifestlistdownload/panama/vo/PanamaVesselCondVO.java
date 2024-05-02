/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PanamaVesselCondVO.java
*@FileTitle : PanamaVesselCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
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
public class PanamaVesselCondVO extends VesselCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<PanamaVesselCondVO> models = new ArrayList<PanamaVesselCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vslCd = null;

	/* Column Info */
	private String slanCd = null;

	/* Column Info */
	private String skdVoyNo = null;

	/* Column Info */
	private String vpsEtaEndDt = null;

	/* Column Info */
	private String vpsEtaStartDt = null;

	/* Column Info */
	private String transSts = null;

	/* Column Info */
	private String skdDirCd = null;

	/* Column Info */
	private String rcvSts = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PanamaVesselCondVO() {}

	public PanamaVesselCondVO(String ibflag, String pagerows, String vslCd, String slanCd, String skdVoyNo, String vpsEtaEndDt, String vpsEtaStartDt, String transSts, String skdDirCd, String rcvSts) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vslCd = vslCd;
		this.slanCd = slanCd;
		this.skdVoyNo = skdVoyNo;
		this.vpsEtaEndDt = vpsEtaEndDt;
		this.vpsEtaStartDt = vpsEtaStartDt;
		this.transSts = transSts;
		this.skdDirCd = skdDirCd;
		this.rcvSts = rcvSts;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vps_eta_end_dt", getVpsEtaEndDt());
		this.hashColumns.put("vps_eta_start_dt", getVpsEtaStartDt());
		this.hashColumns.put("trans_sts", getTransSts());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("rcv_sts", getRcvSts());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vps_eta_end_dt", "vpsEtaEndDt");
		this.hashFields.put("vps_eta_start_dt", "vpsEtaStartDt");
		this.hashFields.put("trans_sts", "transSts");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("rcv_sts", "rcvSts");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * 
	 * @return String vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 *
	 * @param String slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * 
	 * @return String slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 *
	 * @param String skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * 
	 * @return String skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 *
	 * @param String vpsEtaEndDt
	 */
	public void setVpsEtaEndDt(String vpsEtaEndDt) {
		this.vpsEtaEndDt = vpsEtaEndDt;
	}
	
	/**
	 * 
	 * @return String vpsEtaEndDt
	 */
	public String getVpsEtaEndDt() {
		return this.vpsEtaEndDt;
	}
	
	/**
	 *
	 * @param String vpsEtaStartDt
	 */
	public void setVpsEtaStartDt(String vpsEtaStartDt) {
		this.vpsEtaStartDt = vpsEtaStartDt;
	}
	
	/**
	 * 
	 * @return String vpsEtaStartDt
	 */
	public String getVpsEtaStartDt() {
		return this.vpsEtaStartDt;
	}
	
	/**
	 *
	 * @param String transSts
	 */
	public void setTransSts(String transSts) {
		this.transSts = transSts;
	}
	
	/**
	 * 
	 * @return String transSts
	 */
	public String getTransSts() {
		return this.transSts;
	}
	
	/**
	 *
	 * @param String skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * 
	 * @return String skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 *
	 * @param String rcvSts
	 */
	public void setRcvSts(String rcvSts) {
		this.rcvSts = rcvSts;
	}
	
	/**
	 * 
	 * @return String rcvSts
	 */
	public String getRcvSts() {
		return this.rcvSts;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVpsEtaEndDt(JSPUtil.getParameter(request, prefix + "vps_eta_end_dt", ""));
		setVpsEtaStartDt(JSPUtil.getParameter(request, prefix + "vps_eta_start_dt", ""));
		setTransSts(JSPUtil.getParameter(request, prefix + "trans_sts", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setRcvSts(JSPUtil.getParameter(request, prefix + "rcv_sts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PanamaVesselCondVO[]
	 */
	public PanamaVesselCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PanamaVesselCondVO[]
	 */
	public PanamaVesselCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PanamaVesselCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vpsEtaEndDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_end_dt", length));
			String[] vpsEtaStartDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_start_dt", length));
			String[] transSts = (JSPUtil.getParameter(request, prefix	+ "trans_sts", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] rcvSts = (JSPUtil.getParameter(request, prefix	+ "rcv_sts", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new PanamaVesselCondVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (vslCd[i] != null) 
					model.setVslCd(vslCd[i]);
				if (slanCd[i] != null) 
					model.setSlanCd(slanCd[i]);
				if (skdVoyNo[i] != null) 
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vpsEtaEndDt[i] != null) 
					model.setVpsEtaEndDt(vpsEtaEndDt[i]);
				if (vpsEtaStartDt[i] != null) 
					model.setVpsEtaStartDt(vpsEtaStartDt[i]);
				if (transSts[i] != null) 
					model.setTransSts(transSts[i]);
				if (skdDirCd[i] != null) 
					model.setSkdDirCd(skdDirCd[i]);
				if (rcvSts[i] != null) 
					model.setRcvSts(rcvSts[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPanamaVesselCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PanamaVesselCondVO[]
	 */
	public PanamaVesselCondVO[] getPanamaVesselCondVOs(){
		PanamaVesselCondVO[] vos = (PanamaVesselCondVO[])models.toArray(new PanamaVesselCondVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaEndDt = this.vpsEtaEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaStartDt = this.vpsEtaStartDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transSts = this.transSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSts = this.rcvSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}