/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestVslSkdInfoVO.java
*@FileTitle : CLLCDLManifestVslSkdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier :
*@LastVersion : 1.0
* 2009.11.26
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestVslSkdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CLLCDLManifestVslSkdInfoVO> models = new ArrayList<CLLCDLManifestVslSkdInfoVO>();

	/* Column Info */
	private String vvdCd2 = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vvdCd3 = null;
	/* Column Info */
	private String unLocCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String cssmVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CLLCDLManifestVslSkdInfoVO() {}

	public CLLCDLManifestVslSkdInfoVO(String ibflag, String pagerows, String vvdCd, String vvdCd2, String vvdCd3, String unLocCd, String vpsEtaDt, String vpsEtdDt, String vpsEtbDt, String cssmVvd) {
		this.vvdCd2 = vvdCd2;
		this.vpsEtbDt = vpsEtbDt;
		this.ibflag = ibflag;
		this.vpsEtdDt = vpsEtdDt;
		this.vvdCd3 = vvdCd3;
		this.unLocCd = unLocCd;
		this.vvdCd = vvdCd;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.cssmVvd = cssmVvd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd_cd2", getVvdCd2());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vvd_cd3", getVvdCd3());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cssm_vvd", getCssmVvd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd_cd2", "vvdCd2");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vvd_cd3", "vvdCd3");
		this.hashFields.put("un_loc_cd", "unLocCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cssm_vvd", "cssmVvd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return vvdCd2
	 */
	public String getVvdCd2() {
		return this.vvdCd2;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}

	/**
	 * Column Info
	 * @return vvdCd3
	 */
	public String getVvdCd3() {
		return this.vvdCd3;
	}

	/**
	 * Column Info
	 * @return unLocCd
	 */
	public String getUnLocCd() {
		return this.unLocCd;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return cssmVvd
	 */
	public String getCssmVvd() {
		return this.cssmVvd;
	}


	/**
	 * Column Info
	 * @param vvdCd2
	 */
	public void setVvdCd2(String vvdCd2) {
		this.vvdCd2 = vvdCd2;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}

	/**
	 * Column Info
	 * @param vvdCd3
	 */
	public void setVvdCd3(String vvdCd3) {
		this.vvdCd3 = vvdCd3;
	}

	/**
	 * Column Info
	 * @param unLocCd
	 */
	public void setUnLocCd(String unLocCd) {
		this.unLocCd = unLocCd;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param cssmVvd
	 */
	public void setCssmVvd(String cssmVvd) {
		this.cssmVvd = cssmVvd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvdCd2(JSPUtil.getParameter(request, "vvd_cd2", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setVvdCd3(JSPUtil.getParameter(request, "vvd_cd3", ""));
		setUnLocCd(JSPUtil.getParameter(request, "un_loc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCssmVvd(JSPUtil.getParameter(request, "cssm_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestVslSkdInfoVO[]
	 */
	public CLLCDLManifestVslSkdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestVslSkdInfoVO[]
	 */
	public CLLCDLManifestVslSkdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestVslSkdInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vvdCd2 = (JSPUtil.getParameter(request, prefix	+ "vvd_cd2", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] vvdCd3 = (JSPUtil.getParameter(request, prefix	+ "vvd_cd3", length));
			String[] unLocCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cssmVvd = (JSPUtil.getParameter(request, prefix	+ "cssm_vvd", length));

			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestVslSkdInfoVO();
				if (vvdCd2[i] != null)
					model.setVvdCd2(vvdCd2[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vvdCd3[i] != null)
					model.setVvdCd3(vvdCd3[i]);
				if (unLocCd[i] != null)
					model.setUnLocCd(unLocCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cssmVvd[i] != null)
					model.setCssmVvd(cssmVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestVslSkdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestVslSkdInfoVO[]
	 */
	public CLLCDLManifestVslSkdInfoVO[] getCLLCDLManifestVslSkdInfoVOs(){
		CLLCDLManifestVslSkdInfoVO[] vos = (CLLCDLManifestVslSkdInfoVO[])models.toArray(new CLLCDLManifestVslSkdInfoVO[models.size()]);
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
		this.vvdCd2 = this.vvdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd3 = this.vvdCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd = this.unLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cssmVvd = this.cssmVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
