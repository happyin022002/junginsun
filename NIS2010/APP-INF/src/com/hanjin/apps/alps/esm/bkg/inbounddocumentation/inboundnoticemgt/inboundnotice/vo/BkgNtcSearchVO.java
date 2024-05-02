/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgNtcSearchVO.java
*@FileTitle : BkgNtcSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2010.04.01 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.lang.reflect.Field;
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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgNtcSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgNtcSearchVO> models = new ArrayList<BkgNtcSearchVO>();
	
	/* Column Info */
	private String custRefNo = null;
	/* Column Info */
	private String ntcKndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String schTp = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String tsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String bkgNtcSndRsltCd = null;
	/* Column Info */
	private String sndDtTo = null;
	/* Column Info */
	private String sndDtFm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgNtcSearchVO() {}

	public BkgNtcSearchVO(String ibflag, String pagerows, String vvd, String podCd, String blNo, String schTp, String ofcCd, String sndDtFm, String sndDtTo, String custRefNo, String ntcKndCd, String bkgNtcSndRsltCd, String sndUsrId, String tsFlg, String excelFlg, String pageNo) {
		this.custRefNo = custRefNo;
		this.ntcKndCd = ntcKndCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.schTp = schTp;
		this.ofcCd = ofcCd;
		this.tsFlg = tsFlg;
		this.ibflag = ibflag;
		this.sndUsrId = sndUsrId;
		this.excelFlg = excelFlg;
		this.pageNo = pageNo;
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
		this.sndDtTo = sndDtTo;
		this.sndDtFm = sndDtFm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_ref_no", getCustRefNo());
		this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sch_tp", getSchTp());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("bkg_ntc_snd_rslt_cd", getBkgNtcSndRsltCd());
		this.hashColumns.put("snd_dt_to", getSndDtTo());
		this.hashColumns.put("snd_dt_fm", getSndDtFm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_ref_no", "custRefNo");
		this.hashFields.put("ntc_knd_cd", "ntcKndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sch_tp", "schTp");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("bkg_ntc_snd_rslt_cd", "bkgNtcSndRsltCd");
		this.hashFields.put("snd_dt_to", "sndDtTo");
		this.hashFields.put("snd_dt_fm", "sndDtFm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custRefNo
	 */
	public String getCustRefNo() {
		return this.custRefNo;
	}
	
	/**
	 * Column Info
	 * @return ntcKndCd
	 */
	public String getNtcKndCd() {
		return this.ntcKndCd;
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
	 * Column Info
	 * @return schTp
	 */
	public String getSchTp() {
		return this.schTp;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNtcSndRsltCd
	 */
	public String getBkgNtcSndRsltCd() {
		return this.bkgNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return sndDtTo
	 */
	public String getSndDtTo() {
		return this.sndDtTo;
	}
	
	/**
	 * Column Info
	 * @return sndDtFm
	 */
	public String getSndDtFm() {
		return this.sndDtFm;
	}
	

	/**
	 * Column Info
	 * @param custRefNo
	 */
	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}
	
	/**
	 * Column Info
	 * @param ntcKndCd
	 */
	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
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
	 * Column Info
	 * @param schTp
	 */
	public void setSchTp(String schTp) {
		this.schTp = schTp;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNtcSndRsltCd
	 */
	public void setBkgNtcSndRsltCd(String bkgNtcSndRsltCd) {
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param sndDtTo
	 */
	public void setSndDtTo(String sndDtTo) {
		this.sndDtTo = sndDtTo;
	}
	
	/**
	 * Column Info
	 * @param sndDtFm
	 */
	public void setSndDtFm(String sndDtFm) {
		this.sndDtFm = sndDtFm;
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
		setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
		setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSchTp(JSPUtil.getParameter(request, prefix + "sch_tp", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setBkgNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "bkg_ntc_snd_rslt_cd", ""));
		setSndDtTo(JSPUtil.getParameter(request, prefix + "snd_dt_to", ""));
		setSndDtFm(JSPUtil.getParameter(request, prefix + "snd_dt_fm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgNtcSearchVO[]
	 */
	public BkgNtcSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgNtcSearchVO[]
	 */
	public BkgNtcSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgNtcSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no", length));
			String[] ntcKndCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] schTp = (JSPUtil.getParameter(request, prefix	+ "sch_tp", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] bkgNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_cd", length));
			String[] sndDtTo = (JSPUtil.getParameter(request, prefix	+ "snd_dt_to", length));
			String[] sndDtFm = (JSPUtil.getParameter(request, prefix	+ "snd_dt_fm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgNtcSearchVO();
				if (custRefNo[i] != null)
					model.setCustRefNo(custRefNo[i]);
				if (ntcKndCd[i] != null)
					model.setNtcKndCd(ntcKndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (schTp[i] != null)
					model.setSchTp(schTp[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (bkgNtcSndRsltCd[i] != null)
					model.setBkgNtcSndRsltCd(bkgNtcSndRsltCd[i]);
				if (sndDtTo[i] != null)
					model.setSndDtTo(sndDtTo[i]);
				if (sndDtFm[i] != null)
					model.setSndDtFm(sndDtFm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgNtcSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgNtcSearchVO[]
	 */
	public BkgNtcSearchVO[] getBkgNtcSearchVOs(){
		BkgNtcSearchVO[] vos = (BkgNtcSearchVO[])models.toArray(new BkgNtcSearchVO[models.size()]);
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
		this.custRefNo = this.custRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCd = this.ntcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTp = this.schTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtcSndRsltCd = this.bkgNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtTo = this.sndDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtFm = this.sndDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
