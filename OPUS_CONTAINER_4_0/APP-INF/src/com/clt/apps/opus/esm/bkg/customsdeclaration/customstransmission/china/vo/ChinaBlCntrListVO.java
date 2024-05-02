/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaBlCntrListVO.java
*@FileTitle : ChinaBlCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.11
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaBlCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaBlCntrListVO> models = new ArrayList<ChinaBlCntrListVO>();

	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String cntrMeasQty = null;
	/* Column Info */
	private String ovrDimRtLen = null;
	/* Column Info */
	private String sealKndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sealPtyNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovrDimRearLen = null;
	/* Column Info */
	private String ovrHgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrDimFntLen = null;
	/* Column Info */
	private String sealPtyTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String ovrDimLfLen = null;
	/* Column Info */
	private String chnMfSndIndCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaBlCntrListVO() {}

	public ChinaBlCntrListVO(String ibflag, String pagerows, String blNo, String chnMfSndIndCd, String cntrNo, String cntrTpszCd, String fullMtyCd, String sealNo, String sealKndCd, String sealPtyTpCd, String sealPtyNm, String pckQty, String pckTpCd, String cntrWgt, String wgtUtCd, String cntrMeasQty, String measUtCd, String ovrDimFntLen, String ovrDimRearLen, String ovrHgt, String ovrDimLfLen, String ovrDimRtLen) {
		this.sealNo = sealNo;
		this.cntrWgt = cntrWgt;
		this.cntrMeasQty = cntrMeasQty;
		this.ovrDimRtLen = ovrDimRtLen;
		this.sealKndCd = sealKndCd;
		this.blNo = blNo;
		this.sealPtyNm = sealPtyNm;
		this.pagerows = pagerows;
		this.ovrDimRearLen = ovrDimRearLen;
		this.ovrHgt = ovrHgt;
		this.ibflag = ibflag;
		this.ovrDimFntLen = ovrDimFntLen;
		this.sealPtyTpCd = sealPtyTpCd;
		this.cntrNo = cntrNo;
		this.wgtUtCd = wgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.pckQty = pckQty;
		this.fullMtyCd = fullMtyCd;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.ovrDimLfLen = ovrDimLfLen;
		this.chnMfSndIndCd = chnMfSndIndCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("cntr_meas_qty", getCntrMeasQty());
		this.hashColumns.put("ovr_dim_rt_len", getOvrDimRtLen());
		this.hashColumns.put("seal_knd_cd", getSealKndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("seal_pty_nm", getSealPtyNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovr_dim_rear_len", getOvrDimRearLen());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_dim_fnt_len", getOvrDimFntLen());
		this.hashColumns.put("seal_pty_tp_cd", getSealPtyTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ovr_dim_lf_len", getOvrDimLfLen());
		this.hashColumns.put("chn_mf_snd_ind_cd", getChnMfSndIndCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cntr_meas_qty", "cntrMeasQty");
		this.hashFields.put("ovr_dim_rt_len", "ovrDimRtLen");
		this.hashFields.put("seal_knd_cd", "sealKndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("seal_pty_nm", "sealPtyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovr_dim_rear_len", "ovrDimRearLen");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_dim_fnt_len", "ovrDimFntLen");
		this.hashFields.put("seal_pty_tp_cd", "sealPtyTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ovr_dim_lf_len", "ovrDimLfLen");
		this.hashFields.put("chn_mf_snd_ind_cd", "chnMfSndIndCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}

	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}

	/**
	 * Column Info
	 * @return cntrMeasQty
	 */
	public String getCntrMeasQty() {
		return this.cntrMeasQty;
	}

	/**
	 * Column Info
	 * @return ovrDimRtLen
	 */
	public String getOvrDimRtLen() {
		return this.ovrDimRtLen;
	}

	/**
	 * Column Info
	 * @return sealKndCd
	 */
	public String getSealKndCd() {
		return this.sealKndCd;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return sealPtyNm
	 */
	public String getSealPtyNm() {
		return this.sealPtyNm;
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
	 * @return ovrDimRearLen
	 */
	public String getOvrDimRearLen() {
		return this.ovrDimRearLen;
	}

	/**
	 * Column Info
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
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
	 * @return ovrDimFntLen
	 */
	public String getOvrDimFntLen() {
		return this.ovrDimFntLen;
	}

	/**
	 * Column Info
	 * @return sealPtyTpCd
	 */
	public String getSealPtyTpCd() {
		return this.sealPtyTpCd;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}

	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}

	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}

	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}

	/**
	 * Column Info
	 * @return ovrDimLfLen
	 */
	public String getOvrDimLfLen() {
		return this.ovrDimLfLen;
	}

	/**
	 * Column Info
	 * @return chnMfSndIndCd
	 */
	public String getChnMfSndIndCd() {
		return this.chnMfSndIndCd;
	}


	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	/**
	 * Column Info
	 * @param cntrMeasQty
	 */
	public void setCntrMeasQty(String cntrMeasQty) {
		this.cntrMeasQty = cntrMeasQty;
	}

	/**
	 * Column Info
	 * @param ovrDimRtLen
	 */
	public void setOvrDimRtLen(String ovrDimRtLen) {
		this.ovrDimRtLen = ovrDimRtLen;
	}

	/**
	 * Column Info
	 * @param sealKndCd
	 */
	public void setSealKndCd(String sealKndCd) {
		this.sealKndCd = sealKndCd;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param sealPtyNm
	 */
	public void setSealPtyNm(String sealPtyNm) {
		this.sealPtyNm = sealPtyNm;
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
	 * @param ovrDimRearLen
	 */
	public void setOvrDimRearLen(String ovrDimRearLen) {
		this.ovrDimRearLen = ovrDimRearLen;
	}

	/**
	 * Column Info
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
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
	 * @param ovrDimFntLen
	 */
	public void setOvrDimFntLen(String ovrDimFntLen) {
		this.ovrDimFntLen = ovrDimFntLen;
	}

	/**
	 * Column Info
	 * @param sealPtyTpCd
	 */
	public void setSealPtyTpCd(String sealPtyTpCd) {
		this.sealPtyTpCd = sealPtyTpCd;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}

	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}

	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}

	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	/**
	 * Column Info
	 * @param ovrDimLfLen
	 */
	public void setOvrDimLfLen(String ovrDimLfLen) {
		this.ovrDimLfLen = ovrDimLfLen;
	}

	/**
	 * Column Info
	 * @param chnMfSndIndCd
	 */
	public void setChnMfSndIndCd(String chnMfSndIndCd) {
		this.chnMfSndIndCd = chnMfSndIndCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSealNo(JSPUtil.getParameter(request, "seal_no", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setCntrMeasQty(JSPUtil.getParameter(request, "cntr_meas_qty", ""));
		setOvrDimRtLen(JSPUtil.getParameter(request, "ovr_dim_rt_len", ""));
		setSealKndCd(JSPUtil.getParameter(request, "seal_knd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSealPtyNm(JSPUtil.getParameter(request, "seal_pty_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOvrDimRearLen(JSPUtil.getParameter(request, "ovr_dim_rear_len", ""));
		setOvrHgt(JSPUtil.getParameter(request, "ovr_hgt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOvrDimFntLen(JSPUtil.getParameter(request, "ovr_dim_fnt_len", ""));
		setSealPtyTpCd(JSPUtil.getParameter(request, "seal_pty_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setOvrDimLfLen(JSPUtil.getParameter(request, "ovr_dim_lf_len", ""));
		setChnMfSndIndCd(JSPUtil.getParameter(request, "chn_mf_snd_ind_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaBlCntrListVO[]
	 */
	public ChinaBlCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaBlCntrListVO[]
	 */
	public ChinaBlCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaBlCntrListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] cntrMeasQty = (JSPUtil.getParameter(request, prefix	+ "cntr_meas_qty", length));
			String[] ovrDimRtLen = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_rt_len", length));
			String[] sealKndCd = (JSPUtil.getParameter(request, prefix	+ "seal_knd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sealPtyNm = (JSPUtil.getParameter(request, prefix	+ "seal_pty_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovrDimRearLen = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_rear_len", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrDimFntLen = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_fnt_len", length));
			String[] sealPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "seal_pty_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] ovrDimLfLen = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_lf_len", length));
			String[] chnMfSndIndCd = (JSPUtil.getParameter(request, prefix	+ "chn_mf_snd_ind_cd", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaBlCntrListVO();
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (cntrMeasQty[i] != null)
					model.setCntrMeasQty(cntrMeasQty[i]);
				if (ovrDimRtLen[i] != null)
					model.setOvrDimRtLen(ovrDimRtLen[i]);
				if (sealKndCd[i] != null)
					model.setSealKndCd(sealKndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sealPtyNm[i] != null)
					model.setSealPtyNm(sealPtyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovrDimRearLen[i] != null)
					model.setOvrDimRearLen(ovrDimRearLen[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrDimFntLen[i] != null)
					model.setOvrDimFntLen(ovrDimFntLen[i]);
				if (sealPtyTpCd[i] != null)
					model.setSealPtyTpCd(sealPtyTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (ovrDimLfLen[i] != null)
					model.setOvrDimLfLen(ovrDimLfLen[i]);
				if (chnMfSndIndCd[i] != null)
					model.setChnMfSndIndCd(chnMfSndIndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaBlCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaBlCntrListVO[]
	 */
	public ChinaBlCntrListVO[] getChinaBlCntrListVOs(){
		ChinaBlCntrListVO[] vos = (ChinaBlCntrListVO[])models.toArray(new ChinaBlCntrListVO[models.size()]);
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
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeasQty = this.cntrMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimRtLen = this.ovrDimRtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealKndCd = this.sealKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealPtyNm = this.sealPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimRearLen = this.ovrDimRearLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimFntLen = this.ovrDimFntLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealPtyTpCd = this.sealPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimLfLen = this.ovrDimLfLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnMfSndIndCd = this.chnMfSndIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
