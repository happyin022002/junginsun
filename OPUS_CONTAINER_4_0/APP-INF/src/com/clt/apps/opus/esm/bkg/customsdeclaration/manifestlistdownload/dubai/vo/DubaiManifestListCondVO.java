/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiManifestListCondVO.java
*@FileTitle : DubaiManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.26 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DubaiManifestListCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<DubaiManifestListCondVO> models = new ArrayList<DubaiManifestListCondVO>();
	
	/* Column Info */
	private String cgoType = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String instlNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dataType = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cgoCode = null;
	/* Column Info */
	private String rotnNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DubaiManifestListCondVO() {}

	public DubaiManifestListCondVO(String ibflag, String pagerows, String dataType, String vvd, String polCd, String podCd, String cgoType, String cgoCode, String blNo, String etaDt, String rotnNo, String instlNo, String updUsrId, String mrnNo) {
		this.cgoType = cgoType;
		this.etaDt = etaDt;
		this.instlNo = instlNo;
		this.mrnNo = mrnNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.dataType = dataType;
		this.polCd = polCd;
		this.cgoCode = cgoCode;
		this.rotnNo = rotnNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_type", getCgoType());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("instl_no", getInstlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("data_type", getDataType());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cgo_code", getCgoCode());
		this.hashColumns.put("rotn_no", getRotnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_type", "cgoType");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("instl_no", "instlNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("data_type", "dataType");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cgo_code", "cgoCode");
		this.hashFields.put("rotn_no", "rotnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoType
	 */
	public String getCgoType() {
		return this.cgoType;
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
	 * @return instlNo
	 */
	public String getInstlNo() {
		return this.instlNo;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return dataType
	 */
	public String getDataType() {
		return this.dataType;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return cgoCode
	 */
	public String getCgoCode() {
		return this.cgoCode;
	}
	
	/**
	 * Column Info
	 * @return rotnNo
	 */
	public String getRotnNo() {
		return this.rotnNo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param cgoType
	 */
	public void setCgoType(String cgoType) {
		this.cgoType = cgoType;
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
	 * @param instlNo
	 */
	public void setInstlNo(String instlNo) {
		this.instlNo = instlNo;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param dataType
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param cgoCode
	 */
	public void setCgoCode(String cgoCode) {
		this.cgoCode = cgoCode;
	}
	
	/**
	 * Column Info
	 * @param rotnNo
	 */
	public void setRotnNo(String rotnNo) {
		this.rotnNo = rotnNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setCgoType(JSPUtil.getParameter(request, prefix + "cgo_type", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setInstlNo(JSPUtil.getParameter(request, prefix + "instl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDataType(JSPUtil.getParameter(request, prefix + "data_type", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCgoCode(JSPUtil.getParameter(request, prefix + "cgo_code", ""));
		setRotnNo(JSPUtil.getParameter(request, prefix + "rotn_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DubaiManifestListCondVO[]
	 */
	public DubaiManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DubaiManifestListCondVO[]
	 */
	public DubaiManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DubaiManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoType = (JSPUtil.getParameter(request, prefix	+ "cgo_type", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] instlNo = (JSPUtil.getParameter(request, prefix	+ "instl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dataType = (JSPUtil.getParameter(request, prefix	+ "data_type", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cgoCode = (JSPUtil.getParameter(request, prefix	+ "cgo_code", length));
			String[] rotnNo = (JSPUtil.getParameter(request, prefix	+ "rotn_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new DubaiManifestListCondVO();
				if (cgoType[i] != null)
					model.setCgoType(cgoType[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (instlNo[i] != null)
					model.setInstlNo(instlNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dataType[i] != null)
					model.setDataType(dataType[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cgoCode[i] != null)
					model.setCgoCode(cgoCode[i]);
				if (rotnNo[i] != null)
					model.setRotnNo(rotnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDubaiManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DubaiManifestListCondVO[]
	 */
	public DubaiManifestListCondVO[] getDubaiManifestListCondVOs(){
		DubaiManifestListCondVO[] vos = (DubaiManifestListCondVO[])models.toArray(new DubaiManifestListCondVO[models.size()]);
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
		this.cgoType = this.cgoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instlNo = this.instlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataType = this.dataType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCode = this.cgoCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rotnNo = this.rotnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
