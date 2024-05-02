/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TSRouteVO.java
*@FileTitle : TSRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.06.05 김병규
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TSRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TSRouteVO> models = new ArrayList<TSRouteVO>();

	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslCdSeq = null;
	/* Column Info */
	private String etd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String etaTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String etdTime = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TSRouteVO() {}

	public TSRouteVO(String ibflag, String pagerows, String vslCdSeq, String polCd, String polYdCd, String podCd, String podYdCd, String vvd, String slanCd, String etd, String etdTime, String eta, String etaTime) {
		this.eta = eta;
		this.vslCdSeq = vslCdSeq;
		this.etd = etd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.etaTime = etaTime;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.slanCd = slanCd;
		this.polYdCd = polYdCd;
		this.podYdCd = podYdCd;
		this.etdTime = etdTime;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_cd_seq", getVslCdSeq());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("eta_time", getEtaTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("etd_time", getEtdTime());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_cd_seq", "vslCdSeq");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("eta_time", "etaTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("etd_time", "etdTime");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}

	/**
	 * Column Info
	 * @return vslCdSeq
	 */
	public String getVslCdSeq() {
		return this.vslCdSeq;
	}

	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return etaTime
	 */
	public String getEtaTime() {
		return this.etaTime;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}

	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}

	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
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
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}

	/**
	 * Column Info
	 * @param vslCdSeq
	 */
	public void setVslCdSeq(String vslCdSeq) {
		this.vslCdSeq = vslCdSeq;
	}

	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param etaTime
	 */
	public void setEtaTime(String etaTime) {
		this.etaTime = etaTime;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}

	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setVslCdSeq(JSPUtil.getParameter(request, "vsl_cd_seq", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setEtaTime(JSPUtil.getParameter(request, "eta_time", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setEtdTime(JSPUtil.getParameter(request, "etd_time", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSRouteVO[]
	 */
	public TSRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TSRouteVO[]
	 */
	public TSRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TSRouteVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta".trim(), length));
			String[] vslCdSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_seq".trim(), length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] etaTime = (JSPUtil.getParameter(request, prefix	+ "eta_time".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd".trim(), length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd".trim(), length));
			String[] etdTime = (JSPUtil.getParameter(request, prefix	+ "etd_time".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new TSRouteVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslCdSeq[i] != null)
					model.setVslCdSeq(vslCdSeq[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (etaTime[i] != null)
					model.setEtaTime(etaTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (etdTime[i] != null)
					model.setEtdTime(etdTime[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTSRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TSRouteVO[]
	 */
	public TSRouteVO[] getTSRouteVOs(){
		TSRouteVO[] vos = (TSRouteVO[])models.toArray(new TSRouteVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdSeq = this.vslCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaTime = this.etaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTime = this.etdTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
