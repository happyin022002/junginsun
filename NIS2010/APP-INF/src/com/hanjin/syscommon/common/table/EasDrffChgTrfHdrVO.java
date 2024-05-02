/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EasDrffChgTrfHdrVO.java
*@FileTitle : EasDrffChgTrfHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EasDrffChgTrfHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EasDrffChgTrfHdrVO> models = new ArrayList<EasDrffChgTrfHdrVO>();
	
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String drffChgTrfSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String drffChgTrfVerNo = null;
	/* Column Info */
	private String toEffDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verChk = null;
	/* Column Info */
	private String drffChgTrfDtlSeq = null;
	/* Column Info */
	private String prevFmEffDt = null;
	/* Column Info */
	private String fmEffDtChk = null;
	/* Column Info */
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EasDrffChgTrfHdrVO() {}

	public EasDrffChgTrfHdrVO(String ibflag, String pagerows, String seq, String drffChgTrfSeq, String drffChgTrfVerNo, String fmEffDt, String toEffDt, String creOfcCd, String creUsrId, String cntCd, String rfaNo, String verChk, String drffChgTrfDtlSeq, String prevFmEffDt, String fmEffDtChk) {
		this.rfaNo = rfaNo;
		this.creUsrId = creUsrId;
		this.drffChgTrfSeq = drffChgTrfSeq;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.cntCd = cntCd;
		this.seq = seq;
		this.fmEffDt = fmEffDt;
		this.drffChgTrfVerNo = drffChgTrfVerNo;
		this.toEffDt = toEffDt;
		this.pagerows = pagerows;
		this.verChk = verChk;
		this.drffChgTrfDtlSeq = drffChgTrfDtlSeq;
		this.prevFmEffDt = prevFmEffDt;
		this.fmEffDtChk = fmEffDtChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("drff_chg_trf_seq", getDrffChgTrfSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("drff_chg_trf_ver_no", getDrffChgTrfVerNo());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_chk", getVerChk());
		this.hashColumns.put("drff_chg_trf_dtl_seq", getDrffChgTrfDtlSeq());
		this.hashColumns.put("prev_fm_eff_dt", getPrevFmEffDt());
		this.hashColumns.put("fm_eff_dt_chk", getFmEffDtChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("drff_chg_trf_seq", "drffChgTrfSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("drff_chg_trf_ver_no", "drffChgTrfVerNo");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_chk", "verChk");
		this.hashFields.put("drff_chg_trf_dtl_seq", "drffChgTrfDtlSeq");
		this.hashFields.put("prev_fm_eff_dt", "prevFmEffDt");
		this.hashFields.put("fm_eff_dt_chk", "fmEffDtChk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return drffChgTrfSeq
	 */
	public String getDrffChgTrfSeq() {
		return this.drffChgTrfSeq;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return drffChgTrfVerNo
	 */
	public String getDrffChgTrfVerNo() {
		return this.drffChgTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
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
	 * @return verChk
	 */
	public String getVerChk() {
		return this.verChk;
	}
	
	/**
	 * Column Info
	 * @return drffChgTrfDtlSeq
	 */
	public String getDrffChgTrfDtlSeq() {
		return this.drffChgTrfDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return prevFmEffDt
	 */
	public String getPrevFmEffDt() {
		return this.prevFmEffDt;
	}
	
	/**
	 * Column Info
	 * @return fmEffDtChk
	 */
	public String getFmEffDtChk() {
		return this.fmEffDtChk;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param drffChgTrfSeq
	 */
	public void setDrffChgTrfSeq(String drffChgTrfSeq) {
		this.drffChgTrfSeq = drffChgTrfSeq;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param drffChgTrfVerNo
	 */
	public void setDrffChgTrfVerNo(String drffChgTrfVerNo) {
		this.drffChgTrfVerNo = drffChgTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
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
	 * @param verChk
	 */
	public void setVerChk(String verChk) {
		this.verChk = verChk;
	}
	
	/**
	 * Column Info
	 * @param drffChgTrfDtlSeq
	 */
	public void setDrffChgTrfDtlSeq(String drffChgTrfDtlSeq) {
		this.drffChgTrfDtlSeq = drffChgTrfDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param prevFmEffDt
	 */
	public void setPrevFmEffDt(String prevFmEffDt) {
		this.prevFmEffDt = prevFmEffDt;
	}
	
	/**
	 * Column Info
	 * @param fmEffDtChk
	 */
	public void setFmEffDtChk(String fmEffDtChk) {
		this.fmEffDtChk = fmEffDtChk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDrffChgTrfSeq(JSPUtil.getParameter(request, "drff_chg_trf_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFmEffDt(JSPUtil.getParameter(request, "fm_eff_dt", ""));
		setDrffChgTrfVerNo(JSPUtil.getParameter(request, "drff_chg_trf_ver_no", ""));
		setToEffDt(JSPUtil.getParameter(request, "to_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVerChk(JSPUtil.getParameter(request, "ver_chk", ""));
		setDrffChgTrfDtlSeq(JSPUtil.getParameter(request, "drff_chg_trf_dtl_seq", ""));
		setPrevFmEffDt(JSPUtil.getParameter(request, "prev_fm_eff_dt", ""));
		setFmEffDtChk(JSPUtil.getParameter(request, "fm_eff_dt_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EasDrffChgTrfHdrVO[]
	 */
	public EasDrffChgTrfHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EasDrffChgTrfHdrVO[]
	 */
	public EasDrffChgTrfHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EasDrffChgTrfHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] drffChgTrfSeq = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] drffChgTrfVerNo = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_ver_no", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verChk = (JSPUtil.getParameter(request, prefix	+ "ver_chk", length));
			String[] drffChgTrfDtlSeq = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_dtl_seq", length));
			String[] prevFmEffDt = (JSPUtil.getParameter(request, prefix	+ "prev_fm_eff_dt", length));
			String[] fmEffDtChk = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EasDrffChgTrfHdrVO();
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (drffChgTrfSeq[i] != null)
					model.setDrffChgTrfSeq(drffChgTrfSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (drffChgTrfVerNo[i] != null)
					model.setDrffChgTrfVerNo(drffChgTrfVerNo[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verChk[i] != null)
					model.setVerChk(verChk[i]);
				if (drffChgTrfDtlSeq[i] != null)
					model.setDrffChgTrfDtlSeq(drffChgTrfDtlSeq[i]);
				if (prevFmEffDt[i] != null)
					model.setPrevFmEffDt(prevFmEffDt[i]);
				if (fmEffDtChk[i] != null)
					model.setFmEffDtChk(fmEffDtChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEasDrffChgTrfHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EasDrffChgTrfHdrVO[]
	 */
	public EasDrffChgTrfHdrVO[] getEasDrffChgTrfHdrVOs(){
		EasDrffChgTrfHdrVO[] vos = (EasDrffChgTrfHdrVO[])models.toArray(new EasDrffChgTrfHdrVO[models.size()]);
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
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfSeq = this.drffChgTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfVerNo = this.drffChgTrfVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verChk = this.verChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfDtlSeq = this.drffChgTrfDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevFmEffDt = this.prevFmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDtChk = this.fmEffDtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
