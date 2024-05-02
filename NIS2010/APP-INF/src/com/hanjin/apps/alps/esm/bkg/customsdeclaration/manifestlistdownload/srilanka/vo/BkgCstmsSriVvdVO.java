/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCstmsSriVvdVO.java
*@FileTitle : BkgCstmsSriVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo;

import java.lang.reflect.Field;
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

public class BkgCstmsSriVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsSriVvdVO> models = new ArrayList<BkgCstmsSriVvdVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslRgstNo = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String cstmsVvdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String loclShpAgnNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String etaTime = null;
	/* Column Info */
	private String msgRefNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcPrePortCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String shpAgnNm = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String capNm = null;
	/* Column Info */
	private String etdTime = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsSriVvdVO() {}

	public BkgCstmsSriVvdVO(String ibflag, String pagerows, String vslCd, String vslRgstNo, String etaDt, String cstmsVvdCd, String skdVoyNo, String vslNm, String etdDt, String loclShpAgnNm, String skdDirCd, String etaTime, String msgRefNo, String svcPrePortCd, String userId, String shpAgnNm, String portCd, String vslCntCd, String capNm, String etdTime, String ioBndCd) {
		this.vslCd = vslCd;
		this.vslRgstNo = vslRgstNo;
		this.etaDt = etaDt;
		this.cstmsVvdCd = cstmsVvdCd;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.ioBndCd = ioBndCd;
		this.loclShpAgnNm = loclShpAgnNm;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.etaTime = etaTime;
		this.msgRefNo = msgRefNo;
		this.ibflag = ibflag;
		this.svcPrePortCd = svcPrePortCd;
		this.userId = userId;
		this.shpAgnNm = shpAgnNm;
		this.portCd = portCd;
		this.vslCntCd = vslCntCd;
		this.capNm = capNm;
		this.etdTime = etdTime;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_rgst_no", getVslRgstNo());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("cstms_vvd_cd", getCstmsVvdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("locl_shp_agn_nm", getLoclShpAgnNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eta_time", getEtaTime());
		this.hashColumns.put("msg_ref_no", getMsgRefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_pre_port_cd", getSvcPrePortCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("shp_agn_nm", getShpAgnNm());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("cap_nm", getCapNm());
		this.hashColumns.put("etd_time", getEtdTime());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_rgst_no", "vslRgstNo");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("cstms_vvd_cd", "cstmsVvdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("locl_shp_agn_nm", "loclShpAgnNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eta_time", "etaTime");
		this.hashFields.put("msg_ref_no", "msgRefNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_pre_port_cd", "svcPrePortCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("shp_agn_nm", "shpAgnNm");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("cap_nm", "capNm");
		this.hashFields.put("etd_time", "etdTime");
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
	 * @return vslRgstNo
	 */
	public String getVslRgstNo() {
		return this.vslRgstNo;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsVvdCd
	 */
	public String getCstmsVvdCd() {
		return this.cstmsVvdCd;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return loclShpAgnNm
	 */
	public String getLoclShpAgnNm() {
		return this.loclShpAgnNm;
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
	 * @return etaTime
	 */
	public String getEtaTime() {
		return this.etaTime;
	}
	
	/**
	 * Column Info
	 * @return msgRefNo
	 */
	public String getMsgRefNo() {
		return this.msgRefNo;
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
	 * @return svcPrePortCd
	 */
	public String getSvcPrePortCd() {
		return this.svcPrePortCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return shpAgnNm
	 */
	public String getShpAgnNm() {
		return this.shpAgnNm;
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
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return capNm
	 */
	public String getCapNm() {
		return this.capNm;
	}
	
	/**
	 * Column Info
	 * @return etdTime
	 */
	public String getEtdTime() {
		return this.etdTime;
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
	 * @param vslRgstNo
	 */
	public void setVslRgstNo(String vslRgstNo) {
		this.vslRgstNo = vslRgstNo;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsVvdCd
	 */
	public void setCstmsVvdCd(String cstmsVvdCd) {
		this.cstmsVvdCd = cstmsVvdCd;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param loclShpAgnNm
	 */
	public void setLoclShpAgnNm(String loclShpAgnNm) {
		this.loclShpAgnNm = loclShpAgnNm;
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
	 * @param etaTime
	 */
	public void setEtaTime(String etaTime) {
		this.etaTime = etaTime;
	}
	
	/**
	 * Column Info
	 * @param msgRefNo
	 */
	public void setMsgRefNo(String msgRefNo) {
		this.msgRefNo = msgRefNo;
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
	 * @param svcPrePortCd
	 */
	public void setSvcPrePortCd(String svcPrePortCd) {
		this.svcPrePortCd = svcPrePortCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param shpAgnNm
	 */
	public void setShpAgnNm(String shpAgnNm) {
		this.shpAgnNm = shpAgnNm;
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
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param capNm
	 */
	public void setCapNm(String capNm) {
		this.capNm = capNm;
	}
	
	/**
	 * Column Info
	 * @param etdTime
	 */
	public void setEtdTime(String etdTime) {
		this.etdTime = etdTime;
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
		setVslRgstNo(JSPUtil.getParameter(request, prefix + "vsl_rgst_no", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setCstmsVvdCd(JSPUtil.getParameter(request, prefix + "cstms_vvd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setLoclShpAgnNm(JSPUtil.getParameter(request, prefix + "locl_shp_agn_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEtaTime(JSPUtil.getParameter(request, prefix + "eta_time", ""));
		setMsgRefNo(JSPUtil.getParameter(request, prefix + "msg_ref_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSvcPrePortCd(JSPUtil.getParameter(request, prefix + "svc_pre_port_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setShpAgnNm(JSPUtil.getParameter(request, prefix + "shp_agn_nm", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
		setCapNm(JSPUtil.getParameter(request, prefix + "cap_nm", ""));
		setEtdTime(JSPUtil.getParameter(request, prefix + "etd_time", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsSriVvdVO[]
	 */
	public BkgCstmsSriVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsSriVvdVO[]
	 */
	public BkgCstmsSriVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsSriVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslRgstNo = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_no", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] cstmsVvdCd = (JSPUtil.getParameter(request, prefix	+ "cstms_vvd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] loclShpAgnNm = (JSPUtil.getParameter(request, prefix	+ "locl_shp_agn_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] etaTime = (JSPUtil.getParameter(request, prefix	+ "eta_time", length));
			String[] msgRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_ref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcPrePortCd = (JSPUtil.getParameter(request, prefix	+ "svc_pre_port_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] shpAgnNm = (JSPUtil.getParameter(request, prefix	+ "shp_agn_nm", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm", length));
			String[] etdTime = (JSPUtil.getParameter(request, prefix	+ "etd_time", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsSriVvdVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslRgstNo[i] != null)
					model.setVslRgstNo(vslRgstNo[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (cstmsVvdCd[i] != null)
					model.setCstmsVvdCd(cstmsVvdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (loclShpAgnNm[i] != null)
					model.setLoclShpAgnNm(loclShpAgnNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (etaTime[i] != null)
					model.setEtaTime(etaTime[i]);
				if (msgRefNo[i] != null)
					model.setMsgRefNo(msgRefNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcPrePortCd[i] != null)
					model.setSvcPrePortCd(svcPrePortCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (shpAgnNm[i] != null)
					model.setShpAgnNm(shpAgnNm[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (capNm[i] != null)
					model.setCapNm(capNm[i]);
				if (etdTime[i] != null)
					model.setEtdTime(etdTime[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsSriVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsSriVvdVO[]
	 */
	public BkgCstmsSriVvdVO[] getBkgCstmsSriVvdVOs(){
		BkgCstmsSriVvdVO[] vos = (BkgCstmsSriVvdVO[])models.toArray(new BkgCstmsSriVvdVO[models.size()]);
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
		this.vslRgstNo = this.vslRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsVvdCd = this.cstmsVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclShpAgnNm = this.loclShpAgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaTime = this.etaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRefNo = this.msgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcPrePortCd = this.svcPrePortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpAgnNm = this.shpAgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTime = this.etdTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
