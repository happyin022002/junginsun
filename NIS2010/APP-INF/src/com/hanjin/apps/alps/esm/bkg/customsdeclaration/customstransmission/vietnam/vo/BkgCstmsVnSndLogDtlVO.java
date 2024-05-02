package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo;

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

public class BkgCstmsVnSndLogDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsVnSndLogDtlVO> models = new ArrayList<BkgCstmsVnSndLogDtlVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String logDtlSeq = null;
	/* Column Info */
	private String mfSndSeq = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String vnMfSndIndCd = null;
	/* Column Info */
	private String ediSndMsg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsVnSndLogDtlVO() {}

	public BkgCstmsVnSndLogDtlVO(String ibflag, String pagerows, String vnMfSndIndCd, String fltFileRefNo, String mfSndSeq, String logDtlSeq, String ediSndMsg, String usrId) {
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.logDtlSeq = logDtlSeq;
		this.mfSndSeq = mfSndSeq;
		this.fltFileRefNo = fltFileRefNo;
		this.vnMfSndIndCd = vnMfSndIndCd;
		this.ediSndMsg = ediSndMsg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("log_dtl_seq", getLogDtlSeq());
		this.hashColumns.put("mf_snd_seq", getMfSndSeq());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("vn_mf_snd_ind_cd", getVnMfSndIndCd());
		this.hashColumns.put("edi_snd_msg", getEdiSndMsg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("log_dtl_seq", "logDtlSeq");
		this.hashFields.put("mf_snd_seq", "mfSndSeq");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("vn_mf_snd_ind_cd", "vnMfSndIndCd");
		this.hashFields.put("edi_snd_msg", "ediSndMsg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return logDtlSeq
	 */
	public String getLogDtlSeq() {
		return this.logDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return mfSndSeq
	 */
	public String getMfSndSeq() {
		return this.mfSndSeq;
	}
	
	/**
	 * Column Info
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @return vnMfSndIndCd
	 */
	public String getVnMfSndIndCd() {
		return this.vnMfSndIndCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndMsg
	 */
	public String getEdiSndMsg() {
		return this.ediSndMsg;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param logDtlSeq
	 */
	public void setLogDtlSeq(String logDtlSeq) {
		this.logDtlSeq = logDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param mfSndSeq
	 */
	public void setMfSndSeq(String mfSndSeq) {
		this.mfSndSeq = mfSndSeq;
	}
	
	/**
	 * Column Info
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @param vnMfSndIndCd
	 */
	public void setVnMfSndIndCd(String vnMfSndIndCd) {
		this.vnMfSndIndCd = vnMfSndIndCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndMsg
	 */
	public void setEdiSndMsg(String ediSndMsg) {
		this.ediSndMsg = ediSndMsg;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setLogDtlSeq(JSPUtil.getParameter(request, prefix + "log_dtl_seq", ""));
		setMfSndSeq(JSPUtil.getParameter(request, prefix + "mf_snd_seq", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
		setVnMfSndIndCd(JSPUtil.getParameter(request, prefix + "vn_mf_snd_ind_cd", ""));
		setEdiSndMsg(JSPUtil.getParameter(request, prefix + "edi_snd_msg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsVnSndLogDtlVO[]
	 */
	public BkgCstmsVnSndLogDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsVnSndLogDtlVO[]
	 */
	public BkgCstmsVnSndLogDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsVnSndLogDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] logDtlSeq = (JSPUtil.getParameter(request, prefix	+ "log_dtl_seq", length));
			String[] mfSndSeq = (JSPUtil.getParameter(request, prefix	+ "mf_snd_seq", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] vnMfSndIndCd = (JSPUtil.getParameter(request, prefix	+ "vn_mf_snd_ind_cd", length));
			String[] ediSndMsg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_msg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsVnSndLogDtlVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (logDtlSeq[i] != null)
					model.setLogDtlSeq(logDtlSeq[i]);
				if (mfSndSeq[i] != null)
					model.setMfSndSeq(mfSndSeq[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (vnMfSndIndCd[i] != null)
					model.setVnMfSndIndCd(vnMfSndIndCd[i]);
				if (ediSndMsg[i] != null)
					model.setEdiSndMsg(ediSndMsg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsVnSndLogDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsVnSndLogDtlVO[]
	 */
	public BkgCstmsVnSndLogDtlVO[] getBkgCstmsVnSndLogDtlVOs(){
		BkgCstmsVnSndLogDtlVO[] vos = (BkgCstmsVnSndLogDtlVO[])models.toArray(new BkgCstmsVnSndLogDtlVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logDtlSeq = this.logDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndSeq = this.mfSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnMfSndIndCd = this.vnMfSndIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndMsg = this.ediSndMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
