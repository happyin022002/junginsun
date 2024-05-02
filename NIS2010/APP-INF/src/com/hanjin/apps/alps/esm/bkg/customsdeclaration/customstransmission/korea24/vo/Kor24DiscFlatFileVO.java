/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileTitle : <Kor24DiscFlatFileVO.java
*@FileTitle : Kor24DiscFlatFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.12 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Kor24DiscFlatFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24DiscFlatFileVO> models = new ArrayList<Kor24DiscFlatFileVO>();

	/* Column Info */
	private String cstmsDschCd = null;
	/* Column Info */
	private String blData = null;
	/* Column Info */
	private String loclCstmsCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String loclCstmsPrtCd = null;
	/* Column Info */
	private String cntrData = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String cBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24DiscFlatFileVO() {}

	public Kor24DiscFlatFileVO(String ibflag, String pagerows, String mrnNo, String cstmsDschCd, String loclCstmsCd, String loclCstmsPrtCd, String bkgNo, String cBlNo, String vvd, String portCd, String ioBndCd, String inType, String podCd, String polCd, String blData, String cstmsDeclTpCd, String cntrData, String userId) {
		this.cstmsDschCd = cstmsDschCd;
		this.blData = blData;
		this.loclCstmsCd = loclCstmsCd;
		this.ioBndCd = ioBndCd;
		this.mrnNo = mrnNo;
		this.loclCstmsPrtCd = loclCstmsPrtCd;
		this.cntrData = cntrData;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.inType = inType;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.userId = userId;
		this.portCd = portCd;
		this.cBlNo = cBlNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_dsch_cd", getCstmsDschCd());
		this.hashColumns.put("bl_data", getBlData());
		this.hashColumns.put("locl_cstms_cd", getLoclCstmsCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("locl_cstms_prt_cd", getLoclCstmsPrtCd());
		this.hashColumns.put("cntr_data", getCntrData());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("c_bl_no", getCBlNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_dsch_cd", "cstmsDschCd");
		this.hashFields.put("bl_data", "blData");
		this.hashFields.put("locl_cstms_cd", "loclCstmsCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("locl_cstms_prt_cd", "loclCstmsPrtCd");
		this.hashFields.put("cntr_data", "cntrData");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("c_bl_no", "cBlNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cstmsDschCd
	 */
	public String getCstmsDschCd() {
		return this.cstmsDschCd;
	}

	/**
	 * Column Info
	 * @return blData
	 */
	public String getBlData() {
		return this.blData;
	}

	/**
	 * Column Info
	 * @return loclCstmsCd
	 */
	public String getLoclCstmsCd() {
		return this.loclCstmsCd;
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
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}

	/**
	 * Column Info
	 * @return loclCstmsPrtCd
	 */
	public String getLoclCstmsPrtCd() {
		return this.loclCstmsPrtCd;
	}

	/**
	 * Column Info
	 * @return cntrData
	 */
	public String getCntrData() {
		return this.cntrData;
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
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
	}

	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}

	/**
	 * Column Info
	 * @return cBlNo
	 */
	public String getCBlNo() {
		return this.cBlNo;
	}


	/**
	 * Column Info
	 * @param cstmsDschCd
	 */
	public void setCstmsDschCd(String cstmsDschCd) {
		this.cstmsDschCd = cstmsDschCd;
	}

	/**
	 * Column Info
	 * @param blData
	 */
	public void setBlData(String blData) {
		this.blData = blData;
	}

	/**
	 * Column Info
	 * @param loclCstmsCd
	 */
	public void setLoclCstmsCd(String loclCstmsCd) {
		this.loclCstmsCd = loclCstmsCd;
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
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	/**
	 * Column Info
	 * @param loclCstmsPrtCd
	 */
	public void setLoclCstmsPrtCd(String loclCstmsPrtCd) {
		this.loclCstmsPrtCd = loclCstmsPrtCd;
	}

	/**
	 * Column Info
	 * @param cntrData
	 */
	public void setCntrData(String cntrData) {
		this.cntrData = cntrData;
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
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
	}

	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param cBlNo
	 */
	public void setCBlNo(String cBlNo) {
		this.cBlNo = cBlNo;
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
		setCstmsDschCd(JSPUtil.getParameter(request, prefix + "cstms_dsch_cd", ""));
		setBlData(JSPUtil.getParameter(request, prefix + "bl_data", ""));
		setLoclCstmsCd(JSPUtil.getParameter(request, prefix + "locl_cstms_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setLoclCstmsPrtCd(JSPUtil.getParameter(request, prefix + "locl_cstms_prt_cd", ""));
		setCntrData(JSPUtil.getParameter(request, prefix + "cntr_data", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setInType(JSPUtil.getParameter(request, prefix + "in_type", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setCBlNo(JSPUtil.getParameter(request, prefix + "c_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24DiscFlatFileVO[]
	 */
	public Kor24DiscFlatFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24DiscFlatFileVO[]
	 */
	public Kor24DiscFlatFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24DiscFlatFileVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cstmsDschCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dsch_cd", length));
			String[] blData = (JSPUtil.getParameter(request, prefix	+ "bl_data", length));
			String[] loclCstmsCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] loclCstmsPrtCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_prt_cd", length));
			String[] cntrData = (JSPUtil.getParameter(request, prefix	+ "cntr_data", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24DiscFlatFileVO();
				if (cstmsDschCd[i] != null)
					model.setCstmsDschCd(cstmsDschCd[i]);
				if (blData[i] != null)
					model.setBlData(blData[i]);
				if (loclCstmsCd[i] != null)
					model.setLoclCstmsCd(loclCstmsCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (loclCstmsPrtCd[i] != null)
					model.setLoclCstmsPrtCd(loclCstmsPrtCd[i]);
				if (cntrData[i] != null)
					model.setCntrData(cntrData[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24DiscFlatFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24DiscFlatFileVO[]
	 */
	public Kor24DiscFlatFileVO[] getKor24DiscFlatFileVOs(){
		Kor24DiscFlatFileVO[] vos = (Kor24DiscFlatFileVO[])models.toArray(new Kor24DiscFlatFileVO[models.size()]);
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
		this.cstmsDschCd = this.cstmsDschCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blData = this.blData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsCd = this.loclCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsPrtCd = this.loclCstmsPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrData = this.cntrData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
