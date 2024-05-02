/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JapanVesselArrivalDetailVO.java
*@FileTitle : JapanVesselArrivalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.19
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
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

public class JapanVesselArrivalDetailVO extends VesselArrivalDetailVO {

	private static final long serialVersionUID = 1L;

	private Collection<JapanVesselArrivalDetailVO> models = new ArrayList<JapanVesselArrivalDetailVO>();

	/* Column Info */
	private String cstmsMfCd = null;
	/* Column Info */
	private String arrYdCd = null;
	/* Column Info */
	private String etaDt1 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mfRmk = null;
	/* Column Info */
	private String lodgWgt = null;
	/* Column Info */
	private String etbDt2 = null;
	/* Column Info */
	private String etaDt2 = null;
	/* Column Info */
	private String etbDt1 = null;
	/* Column Info */
	private String inPodCdSplit = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inPodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanVesselArrivalDetailVO() {}

	public JapanVesselArrivalDetailVO(String ibflag, String pagerows, String mfRmk, String lodgWgt, String etbDt2, String etaDt2, String etbDt1, String inPodCdSplit, String cstmsMfCd, String arrYdCd, String inVvdCd, String etaDt1, String inPodCd) {
		this.cstmsMfCd = cstmsMfCd;
		this.arrYdCd = arrYdCd;
		this.etaDt1 = etaDt1;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.mfRmk = mfRmk;
		this.lodgWgt = lodgWgt;
		this.etbDt2 = etbDt2;
		this.etaDt2 = etaDt2;
		this.etbDt1 = etbDt1;
		this.inPodCdSplit = inPodCdSplit;
		this.inVvdCd = inVvdCd;
		this.inPodCd = inPodCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_mf_cd", getCstmsMfCd());
		this.hashColumns.put("arr_yd_cd", getArrYdCd());
		this.hashColumns.put("eta_dt1", getEtaDt1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mf_rmk", getMfRmk());
		this.hashColumns.put("lodg_wgt", getLodgWgt());
		this.hashColumns.put("etb_dt2", getEtbDt2());
		this.hashColumns.put("eta_dt2", getEtaDt2());
		this.hashColumns.put("etb_dt1", getEtbDt1());
		this.hashColumns.put("in_pod_cd_split", getInPodCdSplit());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_mf_cd", "cstmsMfCd");
		this.hashFields.put("arr_yd_cd", "arrYdCd");
		this.hashFields.put("eta_dt1", "etaDt1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mf_rmk", "mfRmk");
		this.hashFields.put("lodg_wgt", "lodgWgt");
		this.hashFields.put("etb_dt2", "etbDt2");
		this.hashFields.put("eta_dt2", "etaDt2");
		this.hashFields.put("etb_dt1", "etbDt1");
		this.hashFields.put("in_pod_cd_split", "inPodCdSplit");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_pod_cd", "inPodCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cstmsMfCd
	 */
	public String getCstmsMfCd() {
		return this.cstmsMfCd;
	}

	/**
	 * Column Info
	 * @return arrYdCd
	 */
	public String getArrYdCd() {
		return this.arrYdCd;
	}

	/**
	 * Column Info
	 * @return etaDt1
	 */
	public String getEtaDt1() {
		return this.etaDt1;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return mfRmk
	 */
	public String getMfRmk() {
		return this.mfRmk;
	}

	/**
	 * Column Info
	 * @return lodgWgt
	 */
	public String getLodgWgt() {
		return this.lodgWgt;
	}

	/**
	 * Column Info
	 * @return etbDt2
	 */
	public String getEtbDt2() {
		return this.etbDt2;
	}

	/**
	 * Column Info
	 * @return etaDt2
	 */
	public String getEtaDt2() {
		return this.etaDt2;
	}

	/**
	 * Column Info
	 * @return etbDt1
	 */
	public String getEtbDt1() {
		return this.etbDt1;
	}

	/**
	 * Column Info
	 * @return inPodCdSplit
	 */
	public String getInPodCdSplit() {
		return this.inPodCdSplit;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}


	/**
	 * Column Info
	 * @param cstmsMfCd
	 */
	public void setCstmsMfCd(String cstmsMfCd) {
		this.cstmsMfCd = cstmsMfCd;
	}

	/**
	 * Column Info
	 * @param arrYdCd
	 */
	public void setArrYdCd(String arrYdCd) {
		this.arrYdCd = arrYdCd;
	}

	/**
	 * Column Info
	 * @param etaDt1
	 */
	public void setEtaDt1(String etaDt1) {
		this.etaDt1 = etaDt1;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param mfRmk
	 */
	public void setMfRmk(String mfRmk) {
		this.mfRmk = mfRmk;
	}

	/**
	 * Column Info
	 * @param lodgWgt
	 */
	public void setLodgWgt(String lodgWgt) {
		this.lodgWgt = lodgWgt;
	}

	/**
	 * Column Info
	 * @param etbDt2
	 */
	public void setEtbDt2(String etbDt2) {
		this.etbDt2 = etbDt2;
	}

	/**
	 * Column Info
	 * @param etaDt2
	 */
	public void setEtaDt2(String etaDt2) {
		this.etaDt2 = etaDt2;
	}

	/**
	 * Column Info
	 * @param etbDt1
	 */
	public void setEtbDt1(String etbDt1) {
		this.etbDt1 = etbDt1;
	}

	/**
	 * Column Info
	 * @param inPodCdSplit
	 */
	public void setInPodCdSplit(String inPodCdSplit) {
		this.inPodCdSplit = inPodCdSplit;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
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
		setCstmsMfCd(JSPUtil.getParameter(request, prefix + "cstms_mf_cd", ""));
		setArrYdCd(JSPUtil.getParameter(request, prefix + "arr_yd_cd", ""));
		setEtaDt1(JSPUtil.getParameter(request, prefix + "eta_dt1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMfRmk(JSPUtil.getParameter(request, prefix + "mf_rmk", ""));
		setLodgWgt(JSPUtil.getParameter(request, prefix + "lodg_wgt", ""));
		setEtbDt2(JSPUtil.getParameter(request, prefix + "etb_dt2", ""));
		setEtaDt2(JSPUtil.getParameter(request, prefix + "eta_dt2", ""));
		setEtbDt1(JSPUtil.getParameter(request, prefix + "etb_dt1", ""));
		setInPodCdSplit(JSPUtil.getParameter(request, prefix + "in_pod_cd_split", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setInPodCd(JSPUtil.getParameter(request, prefix + "in_pod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanVesselArrivalDetailVO[]
	 */
	public JapanVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanVesselArrivalDetailVO[]
	 */
	public JapanVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanVesselArrivalDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cstmsMfCd = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_cd", length));
			String[] arrYdCd = (JSPUtil.getParameter(request, prefix	+ "arr_yd_cd", length));
			String[] etaDt1 = (JSPUtil.getParameter(request, prefix	+ "eta_dt1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mfRmk = (JSPUtil.getParameter(request, prefix	+ "mf_rmk", length));
			String[] lodgWgt = (JSPUtil.getParameter(request, prefix	+ "lodg_wgt", length));
			String[] etbDt2 = (JSPUtil.getParameter(request, prefix	+ "etb_dt2", length));
			String[] etaDt2 = (JSPUtil.getParameter(request, prefix	+ "eta_dt2", length));
			String[] etbDt1 = (JSPUtil.getParameter(request, prefix	+ "etb_dt1", length));
			String[] inPodCdSplit = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd_split", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));

			for (int i = 0; i < length; i++) {
				model = new JapanVesselArrivalDetailVO();
				if (cstmsMfCd[i] != null)
					model.setCstmsMfCd(cstmsMfCd[i]);
				if (arrYdCd[i] != null)
					model.setArrYdCd(arrYdCd[i]);
				if (etaDt1[i] != null)
					model.setEtaDt1(etaDt1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mfRmk[i] != null)
					model.setMfRmk(mfRmk[i]);
				if (lodgWgt[i] != null)
					model.setLodgWgt(lodgWgt[i]);
				if (etbDt2[i] != null)
					model.setEtbDt2(etbDt2[i]);
				if (etaDt2[i] != null)
					model.setEtaDt2(etaDt2[i]);
				if (etbDt1[i] != null)
					model.setEtbDt1(etbDt1[i]);
				if (inPodCdSplit[i] != null)
					model.setInPodCdSplit(inPodCdSplit[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanVesselArrivalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanVesselArrivalDetailVO[]
	 */
	public JapanVesselArrivalDetailVO[] getJapanVesselArrivalDetailVOs(){
		JapanVesselArrivalDetailVO[] vos = (JapanVesselArrivalDetailVO[])models.toArray(new JapanVesselArrivalDetailVO[models.size()]);
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
		this.cstmsMfCd = this.cstmsMfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrYdCd = this.arrYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt1 = this.etaDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRmk = this.mfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgWgt = this.lodgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt2 = this.etbDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt2 = this.etaDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt1 = this.etbDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCdSplit = this.inPodCdSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
