/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrXptLicNoVO.java
*@FileTitle : KrXptLicNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.24 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrXptLicNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrXptLicNoVO> models = new ArrayList<KrXptLicNoVO>();
	
	/* Column Info */
	private String pckTpCd2 = null;
	/* Column Info */
	private String cgoDivdFlg2 = null;
	/* Column Info */
	private String pckQty2 = null;
	/* Column Info */
	private String divdSeq2 = null;
	/* Column Info */
	private String samPckTpCd2 = null;
	/* Column Info */
	private String xterTrspStsCd = null;
	/* Column Info */
	private String mfWgt2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String samPckId2 = null;
	/* Column Info */
	private String samPckQty2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String divdWgt2 = null;
	/* Column Info */
	private String wgtUtCd2 = null;
	/* Column Info */
	private String xptLicNo2 = null;
	/* Column Info */
	private String divdWgtUtCd2 = null;
	/* Column Info */
	private String xptLicNoFileDt2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrXptLicNoVO() {}

	public KrXptLicNoVO(String ibflag, String pagerows, String xptLicNo2, String pckQty2, String pckTpCd2, String mfWgt2, String wgtUtCd2, String cgoDivdFlg2, String divdSeq2, String samPckId2, String samPckQty2, String samPckTpCd2, String divdWgt2, String divdWgtUtCd2, String xptLicNoFileDt2, String xterTrspStsCd) {
		this.pckTpCd2 = pckTpCd2;
		this.cgoDivdFlg2 = cgoDivdFlg2;
		this.pckQty2 = pckQty2;
		this.divdSeq2 = divdSeq2;
		this.samPckTpCd2 = samPckTpCd2;
		this.xterTrspStsCd = xterTrspStsCd;
		this.mfWgt2 = mfWgt2;
		this.pagerows = pagerows;
		this.samPckId2 = samPckId2;
		this.samPckQty2 = samPckQty2;
		this.ibflag = ibflag;
		this.divdWgt2 = divdWgt2;
		this.wgtUtCd2 = wgtUtCd2;
		this.xptLicNo2 = xptLicNo2;
		this.divdWgtUtCd2 = divdWgtUtCd2;
		this.xptLicNoFileDt2 = xptLicNoFileDt2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pck_tp_cd2", getPckTpCd2());
		this.hashColumns.put("cgo_divd_flg2", getCgoDivdFlg2());
		this.hashColumns.put("pck_qty2", getPckQty2());
		this.hashColumns.put("divd_seq2", getDivdSeq2());
		this.hashColumns.put("sam_pck_tp_cd2", getSamPckTpCd2());
		this.hashColumns.put("xter_trsp_sts_cd", getXterTrspStsCd());
		this.hashColumns.put("mf_wgt2", getMfWgt2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sam_pck_id2", getSamPckId2());
		this.hashColumns.put("sam_pck_qty2", getSamPckQty2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("divd_wgt2", getDivdWgt2());
		this.hashColumns.put("wgt_ut_cd2", getWgtUtCd2());
		this.hashColumns.put("xpt_lic_no2", getXptLicNo2());
		this.hashColumns.put("divd_wgt_ut_cd2", getDivdWgtUtCd2());
		this.hashColumns.put("xpt_lic_no_file_dt2", getXptLicNoFileDt2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pck_tp_cd2", "pckTpCd2");
		this.hashFields.put("cgo_divd_flg2", "cgoDivdFlg2");
		this.hashFields.put("pck_qty2", "pckQty2");
		this.hashFields.put("divd_seq2", "divdSeq2");
		this.hashFields.put("sam_pck_tp_cd2", "samPckTpCd2");
		this.hashFields.put("xter_trsp_sts_cd", "xterTrspStsCd");
		this.hashFields.put("mf_wgt2", "mfWgt2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sam_pck_id2", "samPckId2");
		this.hashFields.put("sam_pck_qty2", "samPckQty2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("divd_wgt2", "divdWgt2");
		this.hashFields.put("wgt_ut_cd2", "wgtUtCd2");
		this.hashFields.put("xpt_lic_no2", "xptLicNo2");
		this.hashFields.put("divd_wgt_ut_cd2", "divdWgtUtCd2");
		this.hashFields.put("xpt_lic_no_file_dt2", "xptLicNoFileDt2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd2
	 */
	public String getPckTpCd2() {
		return this.pckTpCd2;
	}
	
	/**
	 * Column Info
	 * @return cgoDivdFlg2
	 */
	public String getCgoDivdFlg2() {
		return this.cgoDivdFlg2;
	}
	
	/**
	 * Column Info
	 * @return pckQty2
	 */
	public String getPckQty2() {
		return this.pckQty2;
	}
	
	/**
	 * Column Info
	 * @return divdSeq2
	 */
	public String getDivdSeq2() {
		return this.divdSeq2;
	}
	
	/**
	 * Column Info
	 * @return samPckTpCd2
	 */
	public String getSamPckTpCd2() {
		return this.samPckTpCd2;
	}
	
	/**
	 * Column Info
	 * @return xterTrspStsCd
	 */
	public String getXterTrspStsCd() {
		return this.xterTrspStsCd;
	}
	
	/**
	 * Column Info
	 * @return mfWgt2
	 */
	public String getMfWgt2() {
		return this.mfWgt2;
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
	 * @return samPckId2
	 */
	public String getSamPckId2() {
		return this.samPckId2;
	}
	
	/**
	 * Column Info
	 * @return samPckQty2
	 */
	public String getSamPckQty2() {
		return this.samPckQty2;
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
	 * @return divdWgt2
	 */
	public String getDivdWgt2() {
		return this.divdWgt2;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd2
	 */
	public String getWgtUtCd2() {
		return this.wgtUtCd2;
	}
	
	/**
	 * Column Info
	 * @return xptLicNo2
	 */
	public String getXptLicNo2() {
		return this.xptLicNo2;
	}
	
	/**
	 * Column Info
	 * @return divdWgtUtCd2
	 */
	public String getDivdWgtUtCd2() {
		return this.divdWgtUtCd2;
	}
	
	/**
	 * Column Info
	 * @return xptLicNoFileDt2
	 */
	public String getXptLicNoFileDt2() {
		return this.xptLicNoFileDt2;
	}
	

	/**
	 * Column Info
	 * @param pckTpCd2
	 */
	public void setPckTpCd2(String pckTpCd2) {
		this.pckTpCd2 = pckTpCd2;
	}
	
	/**
	 * Column Info
	 * @param cgoDivdFlg2
	 */
	public void setCgoDivdFlg2(String cgoDivdFlg2) {
		this.cgoDivdFlg2 = cgoDivdFlg2;
	}
	
	/**
	 * Column Info
	 * @param pckQty2
	 */
	public void setPckQty2(String pckQty2) {
		this.pckQty2 = pckQty2;
	}
	
	/**
	 * Column Info
	 * @param divdSeq2
	 */
	public void setDivdSeq2(String divdSeq2) {
		this.divdSeq2 = divdSeq2;
	}
	
	/**
	 * Column Info
	 * @param samPckTpCd2
	 */
	public void setSamPckTpCd2(String samPckTpCd2) {
		this.samPckTpCd2 = samPckTpCd2;
	}
	
	/**
	 * Column Info
	 * @param xterTrspStsCd
	 */
	public void setXterTrspStsCd(String xterTrspStsCd) {
		this.xterTrspStsCd = xterTrspStsCd;
	}
	
	/**
	 * Column Info
	 * @param mfWgt2
	 */
	public void setMfWgt2(String mfWgt2) {
		this.mfWgt2 = mfWgt2;
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
	 * @param samPckId2
	 */
	public void setSamPckId2(String samPckId2) {
		this.samPckId2 = samPckId2;
	}
	
	/**
	 * Column Info
	 * @param samPckQty2
	 */
	public void setSamPckQty2(String samPckQty2) {
		this.samPckQty2 = samPckQty2;
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
	 * @param divdWgt2
	 */
	public void setDivdWgt2(String divdWgt2) {
		this.divdWgt2 = divdWgt2;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd2
	 */
	public void setWgtUtCd2(String wgtUtCd2) {
		this.wgtUtCd2 = wgtUtCd2;
	}
	
	/**
	 * Column Info
	 * @param xptLicNo2
	 */
	public void setXptLicNo2(String xptLicNo2) {
		this.xptLicNo2 = xptLicNo2;
	}
	
	/**
	 * Column Info
	 * @param divdWgtUtCd2
	 */
	public void setDivdWgtUtCd2(String divdWgtUtCd2) {
		this.divdWgtUtCd2 = divdWgtUtCd2;
	}
	
	/**
	 * Column Info
	 * @param xptLicNoFileDt2
	 */
	public void setXptLicNoFileDt2(String xptLicNoFileDt2) {
		this.xptLicNoFileDt2 = xptLicNoFileDt2;
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
		setPckTpCd2(JSPUtil.getParameter(request, prefix + "pck_tp_cd2", ""));
		setCgoDivdFlg2(JSPUtil.getParameter(request, prefix + "cgo_divd_flg2", ""));
		setPckQty2(JSPUtil.getParameter(request, prefix + "pck_qty2", ""));
		setDivdSeq2(JSPUtil.getParameter(request, prefix + "divd_seq2", ""));
		setSamPckTpCd2(JSPUtil.getParameter(request, prefix + "sam_pck_tp_cd2", ""));
		setXterTrspStsCd(JSPUtil.getParameter(request, prefix + "xter_trsp_sts_cd", ""));
		setMfWgt2(JSPUtil.getParameter(request, prefix + "mf_wgt2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSamPckId2(JSPUtil.getParameter(request, prefix + "sam_pck_id2", ""));
		setSamPckQty2(JSPUtil.getParameter(request, prefix + "sam_pck_qty2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDivdWgt2(JSPUtil.getParameter(request, prefix + "divd_wgt2", ""));
		setWgtUtCd2(JSPUtil.getParameter(request, prefix + "wgt_ut_cd2", ""));
		setXptLicNo2(JSPUtil.getParameter(request, prefix + "xpt_lic_no2", ""));
		setDivdWgtUtCd2(JSPUtil.getParameter(request, prefix + "divd_wgt_ut_cd2", ""));
		setXptLicNoFileDt2(JSPUtil.getParameter(request, prefix + "xpt_lic_no_file_dt2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrXptLicNoVO[]
	 */
	public KrXptLicNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrXptLicNoVO[]
	 */
	public KrXptLicNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrXptLicNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pckTpCd2 = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd2", length));
			String[] cgoDivdFlg2 = (JSPUtil.getParameter(request, prefix	+ "cgo_divd_flg2", length));
			String[] pckQty2 = (JSPUtil.getParameter(request, prefix	+ "pck_qty2", length));
			String[] divdSeq2 = (JSPUtil.getParameter(request, prefix	+ "divd_seq2", length));
			String[] samPckTpCd2 = (JSPUtil.getParameter(request, prefix	+ "sam_pck_tp_cd2", length));
			String[] xterTrspStsCd = (JSPUtil.getParameter(request, prefix	+ "xter_trsp_sts_cd", length));
			String[] mfWgt2 = (JSPUtil.getParameter(request, prefix	+ "mf_wgt2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] samPckId2 = (JSPUtil.getParameter(request, prefix	+ "sam_pck_id2", length));
			String[] samPckQty2 = (JSPUtil.getParameter(request, prefix	+ "sam_pck_qty2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] divdWgt2 = (JSPUtil.getParameter(request, prefix	+ "divd_wgt2", length));
			String[] wgtUtCd2 = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd2", length));
			String[] xptLicNo2 = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no2", length));
			String[] divdWgtUtCd2 = (JSPUtil.getParameter(request, prefix	+ "divd_wgt_ut_cd2", length));
			String[] xptLicNoFileDt2 = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no_file_dt2", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrXptLicNoVO();
				if (pckTpCd2[i] != null)
					model.setPckTpCd2(pckTpCd2[i]);
				if (cgoDivdFlg2[i] != null)
					model.setCgoDivdFlg2(cgoDivdFlg2[i]);
				if (pckQty2[i] != null)
					model.setPckQty2(pckQty2[i]);
				if (divdSeq2[i] != null)
					model.setDivdSeq2(divdSeq2[i]);
				if (samPckTpCd2[i] != null)
					model.setSamPckTpCd2(samPckTpCd2[i]);
				if (xterTrspStsCd[i] != null)
					model.setXterTrspStsCd(xterTrspStsCd[i]);
				if (mfWgt2[i] != null)
					model.setMfWgt2(mfWgt2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (samPckId2[i] != null)
					model.setSamPckId2(samPckId2[i]);
				if (samPckQty2[i] != null)
					model.setSamPckQty2(samPckQty2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (divdWgt2[i] != null)
					model.setDivdWgt2(divdWgt2[i]);
				if (wgtUtCd2[i] != null)
					model.setWgtUtCd2(wgtUtCd2[i]);
				if (xptLicNo2[i] != null)
					model.setXptLicNo2(xptLicNo2[i]);
				if (divdWgtUtCd2[i] != null)
					model.setDivdWgtUtCd2(divdWgtUtCd2[i]);
				if (xptLicNoFileDt2[i] != null)
					model.setXptLicNoFileDt2(xptLicNoFileDt2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrXptLicNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrXptLicNoVO[]
	 */
	public KrXptLicNoVO[] getKrXptLicNoVOs(){
		KrXptLicNoVO[] vos = (KrXptLicNoVO[])models.toArray(new KrXptLicNoVO[models.size()]);
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
		this.pckTpCd2 = this.pckTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDivdFlg2 = this.cgoDivdFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty2 = this.pckQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdSeq2 = this.divdSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckTpCd2 = this.samPckTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterTrspStsCd = this.xterTrspStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfWgt2 = this.mfWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckId2 = this.samPckId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.samPckQty2 = this.samPckQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgt2 = this.divdWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd2 = this.wgtUtCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo2 = this.xptLicNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgtUtCd2 = this.divdWgtUtCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNoFileDt2 = this.xptLicNoFileDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
