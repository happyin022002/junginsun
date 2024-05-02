/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaManifestListCondVO.java
*@FileTitle : ChinaManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier :
*@LastVersion : 1.0
* 2015.03.27
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 */

public class ChinaManifestListCondVO extends com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaManifestListCondVO> models = new ArrayList<ChinaManifestListCondVO>();

	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String transType = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public ChinaManifestListCondVO() {}

	public ChinaManifestListCondVO(String ibflag, String pagerows, String vvd, String vvd2, String bkgNo, String transMode, String transType, String bkgCgoTpCd, String locCd, String gubun, String usrId, String blNo) {
		this.vvd = vvd;
		this.locCd = locCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.transType = transType;
		this.transMode = transMode;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.gubun = gubun;
		this.usrId = usrId;
		this.vvd2 = vvd2;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("trans_type", getTransType());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("trans_type", "transType");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("bl_no", "blNo");
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @return transType
	 */
	public String getTransType() {
		return this.transType;
	}

	/**
	 * Column Info
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}

	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @param transType
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}

	/**
	 * Column Info
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
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
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setTransType(JSPUtil.getParameter(request, prefix + "trans_type", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaManifestListCondVO[]
	 */
	public ChinaManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaManifestListCondVO[]
	 */
	public ChinaManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaManifestListCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] transType = (JSPUtil.getParameter(request, prefix	+ "trans_type", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaManifestListCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (transType[i] != null)
					model.setTransType(transType[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaManifestListCondVO[]
	 */
	public ChinaManifestListCondVO[] getChinaManifestListCondVOs(){
		ChinaManifestListCondVO[] vos = (ChinaManifestListCondVO[])models.toArray(new ChinaManifestListCondVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transType = this.transType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
