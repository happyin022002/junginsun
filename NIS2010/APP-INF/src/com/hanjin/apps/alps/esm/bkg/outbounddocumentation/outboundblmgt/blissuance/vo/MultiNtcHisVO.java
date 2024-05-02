/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultiNtcHisVO.java
*@FileTitle : MultiNtcHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.11.06 이일민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MultiNtcHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MultiNtcHisVO> models = new ArrayList<MultiNtcHisVO>();
	
	/* Column Info */
	private String sndDate = null;
	/* Column Info */
	private String ntcKndCd = null;
	/* Column Info */
	private String frtAllFlg = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String frtChgFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frtPpdFlg = null;
	/* Column Info */
	private String ntcViaCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String faxEml = null;
	/* Column Info */
	private String frtArrFlg = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String sndResult = null;
	/* Column Info */
	private String sndReason = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MultiNtcHisVO() {}

	public MultiNtcHisVO(String ibflag, String pagerows, String bkgNo, String blNo, String hisSeq, String ntcKndCd, String ntcViaCd, String faxEml, String sndResult, String sndDate, String sndReason, String sndUsrId, String sndOfcCd, String frtAllFlg, String frtCltFlg, String frtPpdFlg, String frtChgFlg, String frtArrFlg) {
		this.sndDate = sndDate;
		this.ntcKndCd = ntcKndCd;
		this.frtAllFlg = frtAllFlg;
		this.sndOfcCd = sndOfcCd;
		this.blNo = blNo;
		this.frtChgFlg = frtChgFlg;
		this.pagerows = pagerows;
		this.frtPpdFlg = frtPpdFlg;
		this.ntcViaCd = ntcViaCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.sndUsrId = sndUsrId;
		this.frtCltFlg = frtCltFlg;
		this.faxEml = faxEml;
		this.frtArrFlg = frtArrFlg;
		this.hisSeq = hisSeq;
		this.sndResult = sndResult;
		this.sndReason = sndReason;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("snd_date", getSndDate());
		this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
		this.hashColumns.put("frt_all_flg", getFrtAllFlg());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("frt_chg_flg", getFrtChgFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frt_ppd_flg", getFrtPpdFlg());
		this.hashColumns.put("ntc_via_cd", getNtcViaCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("fax_eml", getFaxEml());
		this.hashColumns.put("frt_arr_flg", getFrtArrFlg());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("snd_result", getSndResult());
		this.hashColumns.put("snd_reason", getSndReason());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("snd_date", "sndDate");
		this.hashFields.put("ntc_knd_cd", "ntcKndCd");
		this.hashFields.put("frt_all_flg", "frtAllFlg");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("frt_chg_flg", "frtChgFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frt_ppd_flg", "frtPpdFlg");
		this.hashFields.put("ntc_via_cd", "ntcViaCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("fax_eml", "faxEml");
		this.hashFields.put("frt_arr_flg", "frtArrFlg");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("snd_result", "sndResult");
		this.hashFields.put("snd_reason", "sndReason");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sndDate
	 */
	public String getSndDate() {
		return this.sndDate;
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
	 * @return frtAllFlg
	 */
	public String getFrtAllFlg() {
		return this.frtAllFlg;
	}
	
	/**
	 * Column Info
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
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
	 * @return frtChgFlg
	 */
	public String getFrtChgFlg() {
		return this.frtChgFlg;
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
	 * @return frtPpdFlg
	 */
	public String getFrtPpdFlg() {
		return this.frtPpdFlg;
	}
	
	/**
	 * Column Info
	 * @return ntcViaCd
	 */
	public String getNtcViaCd() {
		return this.ntcViaCd;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return faxEml
	 */
	public String getFaxEml() {
		return this.faxEml;
	}
	
	/**
	 * Column Info
	 * @return frtArrFlg
	 */
	public String getFrtArrFlg() {
		return this.frtArrFlg;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return sndResult
	 */
	public String getSndResult() {
		return this.sndResult;
	}
	
	/**
	 * Column Info
	 * @return sndReason
	 */
	public String getSndReason() {
		return this.sndReason;
	}
	

	/**
	 * Column Info
	 * @param sndDate
	 */
	public void setSndDate(String sndDate) {
		this.sndDate = sndDate;
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
	 * @param frtAllFlg
	 */
	public void setFrtAllFlg(String frtAllFlg) {
		this.frtAllFlg = frtAllFlg;
	}
	
	/**
	 * Column Info
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
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
	 * @param frtChgFlg
	 */
	public void setFrtChgFlg(String frtChgFlg) {
		this.frtChgFlg = frtChgFlg;
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
	 * @param frtPpdFlg
	 */
	public void setFrtPpdFlg(String frtPpdFlg) {
		this.frtPpdFlg = frtPpdFlg;
	}
	
	/**
	 * Column Info
	 * @param ntcViaCd
	 */
	public void setNtcViaCd(String ntcViaCd) {
		this.ntcViaCd = ntcViaCd;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param faxEml
	 */
	public void setFaxEml(String faxEml) {
		this.faxEml = faxEml;
	}
	
	/**
	 * Column Info
	 * @param frtArrFlg
	 */
	public void setFrtArrFlg(String frtArrFlg) {
		this.frtArrFlg = frtArrFlg;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param sndResult
	 */
	public void setSndResult(String sndResult) {
		this.sndResult = sndResult;
	}
	
	/**
	 * Column Info
	 * @param sndReason
	 */
	public void setSndReason(String sndReason) {
		this.sndReason = sndReason;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSndDate(JSPUtil.getParameter(request, "snd_date", ""));
		setNtcKndCd(JSPUtil.getParameter(request, "ntc_knd_cd", ""));
		setFrtAllFlg(JSPUtil.getParameter(request, "frt_all_flg", ""));
		setSndOfcCd(JSPUtil.getParameter(request, "snd_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setFrtChgFlg(JSPUtil.getParameter(request, "frt_chg_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFrtPpdFlg(JSPUtil.getParameter(request, "frt_ppd_flg", ""));
		setNtcViaCd(JSPUtil.getParameter(request, "ntc_via_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, "frt_clt_flg", ""));
		setFaxEml(JSPUtil.getParameter(request, "fax_eml", ""));
		setFrtArrFlg(JSPUtil.getParameter(request, "frt_arr_flg", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setSndResult(JSPUtil.getParameter(request, "snd_result", ""));
		setSndReason(JSPUtil.getParameter(request, "snd_reason", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MultiNtcHisVO[]
	 */
	public MultiNtcHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MultiNtcHisVO[]
	 */
	public MultiNtcHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MultiNtcHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sndDate = (JSPUtil.getParameter(request, prefix	+ "snd_date", length));
			String[] ntcKndCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd", length));
			String[] frtAllFlg = (JSPUtil.getParameter(request, prefix	+ "frt_all_flg", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] frtChgFlg = (JSPUtil.getParameter(request, prefix	+ "frt_chg_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frtPpdFlg = (JSPUtil.getParameter(request, prefix	+ "frt_ppd_flg", length));
			String[] ntcViaCd = (JSPUtil.getParameter(request, prefix	+ "ntc_via_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] faxEml = (JSPUtil.getParameter(request, prefix	+ "fax_eml", length));
			String[] frtArrFlg = (JSPUtil.getParameter(request, prefix	+ "frt_arr_flg", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] sndResult = (JSPUtil.getParameter(request, prefix	+ "snd_result", length));
			String[] sndReason = (JSPUtil.getParameter(request, prefix	+ "snd_reason", length));
			
			for (int i = 0; i < length; i++) {
				model = new MultiNtcHisVO();
				if (sndDate[i] != null)
					model.setSndDate(sndDate[i]);
				if (ntcKndCd[i] != null)
					model.setNtcKndCd(ntcKndCd[i]);
				if (frtAllFlg[i] != null)
					model.setFrtAllFlg(frtAllFlg[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (frtChgFlg[i] != null)
					model.setFrtChgFlg(frtChgFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frtPpdFlg[i] != null)
					model.setFrtPpdFlg(frtPpdFlg[i]);
				if (ntcViaCd[i] != null)
					model.setNtcViaCd(ntcViaCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (faxEml[i] != null)
					model.setFaxEml(faxEml[i]);
				if (frtArrFlg[i] != null)
					model.setFrtArrFlg(frtArrFlg[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (sndResult[i] != null)
					model.setSndResult(sndResult[i]);
				if (sndReason[i] != null)
					model.setSndReason(sndReason[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMultiNtcHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MultiNtcHisVO[]
	 */
	public MultiNtcHisVO[] getMultiNtcHisVOs(){
		MultiNtcHisVO[] vos = (MultiNtcHisVO[])models.toArray(new MultiNtcHisVO[models.size()]);
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
		this.sndDate = this.sndDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCd = this.ntcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtAllFlg = this.frtAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChgFlg = this.frtChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtPpdFlg = this.frtPpdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcViaCd = this.ntcViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEml = this.faxEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtArrFlg = this.frtArrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndResult = this.sndResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndReason = this.sndReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
