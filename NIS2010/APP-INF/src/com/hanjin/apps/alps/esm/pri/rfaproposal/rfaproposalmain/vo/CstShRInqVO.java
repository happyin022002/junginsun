/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CstShRInqVO.java
*@FileTitle : CstShRInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.06
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.12.06 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstShRInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstShRInqVO> models = new ArrayList<CstShRInqVO>();
	
	/* Column Info */
	private String srfaNo = null;
	/* Column Info */
	private String spropOfcCd = null;
	/* Column Info */
	private String srfaCtrtTpCd = null;
	/* Column Info */
	private String spropSrepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String seffDt = null;
	/* Column Info */
	private String spropStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ssvcScpCd = null;
	/* Column Info */
	private String spropNo = null;
	/* Column Info */
	private String inUsrOfcCd = null;
	/* Column Info */
	private String scustSeq = null;
	/* Column Info */
	private String scustCntCd = null;
	/* Column Info */
	private String retroActive = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstShRInqVO() {}

	public CstShRInqVO(String ibflag, String pagerows, String srfaNo, String spropOfcCd, String spropSrepCd, String seffDt, String spropStsCd, String ssvcScpCd, String spropNo, String inUsrOfcCd, String scustSeq, String scustCntCd, String retroActive, String srfaCtrtTpCd) {
		this.srfaNo = srfaNo;
		this.spropOfcCd = spropOfcCd;
		this.srfaCtrtTpCd = srfaCtrtTpCd;
		this.spropSrepCd = spropSrepCd;
		this.pagerows = pagerows;
		this.seffDt = seffDt;
		this.spropStsCd = spropStsCd;
		this.ibflag = ibflag;
		this.ssvcScpCd = ssvcScpCd;
		this.spropNo = spropNo;
		this.inUsrOfcCd = inUsrOfcCd;
		this.scustSeq = scustSeq;
		this.scustCntCd = scustCntCd;
		this.retroActive = retroActive;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("srfa_no", getSrfaNo());
		this.hashColumns.put("sprop_ofc_cd", getSpropOfcCd());
		this.hashColumns.put("srfa_ctrt_tp_cd", getSrfaCtrtTpCd());
		this.hashColumns.put("sprop_srep_cd", getSpropSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("seff_dt", getSeffDt());
		this.hashColumns.put("sprop_sts_cd", getSpropStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ssvc_scp_cd", getSsvcScpCd());
		this.hashColumns.put("sprop_no", getSpropNo());
		this.hashColumns.put("in_usr_ofc_cd", getInUsrOfcCd());
		this.hashColumns.put("scust_seq", getScustSeq());
		this.hashColumns.put("scust_cnt_cd", getScustCntCd());
		this.hashColumns.put("retro_active", getRetroActive());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("srfa_no", "srfaNo");
		this.hashFields.put("sprop_ofc_cd", "spropOfcCd");
		this.hashFields.put("srfa_ctrt_tp_cd", "srfaCtrtTpCd");
		this.hashFields.put("sprop_srep_cd", "spropSrepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("seff_dt", "seffDt");
		this.hashFields.put("sprop_sts_cd", "spropStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ssvc_scp_cd", "ssvcScpCd");
		this.hashFields.put("sprop_no", "spropNo");
		this.hashFields.put("in_usr_ofc_cd", "inUsrOfcCd");
		this.hashFields.put("scust_seq", "scustSeq");
		this.hashFields.put("scust_cnt_cd", "scustCntCd");
		this.hashFields.put("retro_active", "retroActive");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return srfaNo
	 */
	public String getSrfaNo() {
		return this.srfaNo;
	}
	
	/**
	 * Column Info
	 * @return spropOfcCd
	 */
	public String getSpropOfcCd() {
		return this.spropOfcCd;
	}
	
	/**
	 * Column Info
	 * @return srfaCtrtTpCd
	 */
	public String getSrfaCtrtTpCd() {
		return this.srfaCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return spropSrepCd
	 */
	public String getSpropSrepCd() {
		return this.spropSrepCd;
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
	 * @return seffDt
	 */
	public String getSeffDt() {
		return this.seffDt;
	}
	
	/**
	 * Column Info
	 * @return spropStsCd
	 */
	public String getSpropStsCd() {
		return this.spropStsCd;
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
	 * @return ssvcScpCd
	 */
	public String getSsvcScpCd() {
		return this.ssvcScpCd;
	}
	
	/**
	 * Column Info
	 * @return spropNo
	 */
	public String getSpropNo() {
		return this.spropNo;
	}
	
	/**
	 * Column Info
	 * @return inUsrOfcCd
	 */
	public String getInUsrOfcCd() {
		return this.inUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return scustSeq
	 */
	public String getScustSeq() {
		return this.scustSeq;
	}
	
	/**
	 * Column Info
	 * @return scustCntCd
	 */
	public String getScustCntCd() {
		return this.scustCntCd;
	}
	
	/**
	 * Column Info
	 * @return retroActive
	 */
	public String getRetroActive() {
		return this.retroActive;
	}
	

	/**
	 * Column Info
	 * @param srfaNo
	 */
	public void setSrfaNo(String srfaNo) {
		this.srfaNo = srfaNo;
	}
	
	/**
	 * Column Info
	 * @param spropOfcCd
	 */
	public void setSpropOfcCd(String spropOfcCd) {
		this.spropOfcCd = spropOfcCd;
	}
	
	/**
	 * Column Info
	 * @param srfaCtrtTpCd
	 */
	public void setSrfaCtrtTpCd(String srfaCtrtTpCd) {
		this.srfaCtrtTpCd = srfaCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param spropSrepCd
	 */
	public void setSpropSrepCd(String spropSrepCd) {
		this.spropSrepCd = spropSrepCd;
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
	 * @param seffDt
	 */
	public void setSeffDt(String seffDt) {
		this.seffDt = seffDt;
	}
	
	/**
	 * Column Info
	 * @param spropStsCd
	 */
	public void setSpropStsCd(String spropStsCd) {
		this.spropStsCd = spropStsCd;
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
	 * @param ssvcScpCd
	 */
	public void setSsvcScpCd(String ssvcScpCd) {
		this.ssvcScpCd = ssvcScpCd;
	}
	
	/**
	 * Column Info
	 * @param spropNo
	 */
	public void setSpropNo(String spropNo) {
		this.spropNo = spropNo;
	}
	
	/**
	 * Column Info
	 * @param inUsrOfcCd
	 */
	public void setInUsrOfcCd(String inUsrOfcCd) {
		this.inUsrOfcCd = inUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param scustSeq
	 */
	public void setScustSeq(String scustSeq) {
		this.scustSeq = scustSeq;
	}
	
	/**
	 * Column Info
	 * @param scustCntCd
	 */
	public void setScustCntCd(String scustCntCd) {
		this.scustCntCd = scustCntCd;
	}
	
	/**
	 * Column Info
	 * @param retroActive
	 */
	public void setRetroActive(String retroActive) {
		this.retroActive = retroActive;
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
		setSrfaNo(JSPUtil.getParameter(request, prefix + "srfa_no", ""));
		setSpropOfcCd(JSPUtil.getParameter(request, prefix + "sprop_ofc_cd", ""));
		setSrfaCtrtTpCd(JSPUtil.getParameter(request, prefix + "srfa_ctrt_tp_cd", ""));
		setSpropSrepCd(JSPUtil.getParameter(request, prefix + "sprop_srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSeffDt(JSPUtil.getParameter(request, prefix + "seff_dt", ""));
		setSpropStsCd(JSPUtil.getParameter(request, prefix + "sprop_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSsvcScpCd(JSPUtil.getParameter(request, prefix + "ssvc_scp_cd", ""));
		setSpropNo(JSPUtil.getParameter(request, prefix + "sprop_no", ""));
		setInUsrOfcCd(JSPUtil.getParameter(request, prefix + "in_usr_ofc_cd", ""));
		setScustSeq(JSPUtil.getParameter(request, prefix + "scust_seq", ""));
		setScustCntCd(JSPUtil.getParameter(request, prefix + "scust_cnt_cd", ""));
		setRetroActive(JSPUtil.getParameter(request, prefix + "retro_active", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstShRInqVO[]
	 */
	public CstShRInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstShRInqVO[]
	 */
	public CstShRInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstShRInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] srfaNo = (JSPUtil.getParameter(request, prefix	+ "srfa_no", length));
			String[] spropOfcCd = (JSPUtil.getParameter(request, prefix	+ "sprop_ofc_cd", length));
			String[] srfaCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "srfa_ctrt_tp_cd", length));
			String[] spropSrepCd = (JSPUtil.getParameter(request, prefix	+ "sprop_srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] seffDt = (JSPUtil.getParameter(request, prefix	+ "seff_dt", length));
			String[] spropStsCd = (JSPUtil.getParameter(request, prefix	+ "sprop_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ssvcScpCd = (JSPUtil.getParameter(request, prefix	+ "ssvc_scp_cd", length));
			String[] spropNo = (JSPUtil.getParameter(request, prefix	+ "sprop_no", length));
			String[] inUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "in_usr_ofc_cd", length));
			String[] scustSeq = (JSPUtil.getParameter(request, prefix	+ "scust_seq", length));
			String[] scustCntCd = (JSPUtil.getParameter(request, prefix	+ "scust_cnt_cd", length));
			String[] retroActive = (JSPUtil.getParameter(request, prefix	+ "retro_active", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstShRInqVO();
				if (srfaNo[i] != null)
					model.setSrfaNo(srfaNo[i]);
				if (spropOfcCd[i] != null)
					model.setSpropOfcCd(spropOfcCd[i]);
				if (srfaCtrtTpCd[i] != null)
					model.setSrfaCtrtTpCd(srfaCtrtTpCd[i]);
				if (spropSrepCd[i] != null)
					model.setSpropSrepCd(spropSrepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (seffDt[i] != null)
					model.setSeffDt(seffDt[i]);
				if (spropStsCd[i] != null)
					model.setSpropStsCd(spropStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ssvcScpCd[i] != null)
					model.setSsvcScpCd(ssvcScpCd[i]);
				if (spropNo[i] != null)
					model.setSpropNo(spropNo[i]);
				if (inUsrOfcCd[i] != null)
					model.setInUsrOfcCd(inUsrOfcCd[i]);
				if (scustSeq[i] != null)
					model.setScustSeq(scustSeq[i]);
				if (scustCntCd[i] != null)
					model.setScustCntCd(scustCntCd[i]);
				if (retroActive[i] != null)
					model.setRetroActive(retroActive[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstShRInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstShRInqVO[]
	 */
	public CstShRInqVO[] getCstShRInqVOs(){
		CstShRInqVO[] vos = (CstShRInqVO[])models.toArray(new CstShRInqVO[models.size()]);
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
		this.srfaNo = this.srfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropOfcCd = this.spropOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srfaCtrtTpCd = this.srfaCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropSrepCd = this.spropSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seffDt = this.seffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropStsCd = this.spropStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssvcScpCd = this.ssvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropNo = this.spropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUsrOfcCd = this.inUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustSeq = this.scustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustCntCd = this.scustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retroActive = this.retroActive .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
