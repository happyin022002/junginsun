/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgTerminalEdiJapanAwkCgoVO.java
*@FileTitle : BkgTerminalEdiJapanAwkCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.03.16 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgTerminalEdiJapanAwkCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgTerminalEdiJapanAwkCgoVO> models = new ArrayList<BkgTerminalEdiJapanAwkCgoVO>();
	
	/* Column Info */
	private String bkgSkdSeq = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Column Info */
	private String ovrVoidSltQty = null;
	/* Column Info */
	private String ovrLfLen = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovrRtLen = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ovrBkwdLen = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String ovrFwrdLen = null;
	/* Column Info */
	private String ovfr = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgTerminalEdiJapanAwkCgoVO() {}

	public BkgTerminalEdiJapanAwkCgoVO(String ibflag, String pagerows, String ovfr,String bkgNo, String bkgSkdSeq, String awkCgoSeq, String cntrTpszCd, String cntrVolQty, String cntrNo, String ovrHgt, String ovrLfLen, String ovrRtLen, String ovrFwrdLen, String ovrBkwdLen, String ovrVoidSltQty) {
		this.bkgSkdSeq = bkgSkdSeq;
		this.awkCgoSeq = awkCgoSeq;
		this.ovrVoidSltQty = ovrVoidSltQty;
		this.ovrLfLen = ovrLfLen;
		this.pagerows = pagerows;
		this.ovrRtLen = ovrRtLen;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.ovrHgt = ovrHgt;
		this.cntrNo = cntrNo;
		this.ovrBkwdLen = ovrBkwdLen;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrVolQty = cntrVolQty;
		this.ovrFwrdLen = ovrFwrdLen;
		this.ovfr = ovfr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_skd_seq", getBkgSkdSeq());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("ovr_void_slt_qty", getOvrVoidSltQty());
		this.hashColumns.put("ovr_lf_len", getOvrLfLen());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovr_rt_len", getOvrRtLen());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
		this.hashColumns.put("ovfr", getOvfr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_skd_seq", "bkgSkdSeq");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("ovr_void_slt_qty", "ovrVoidSltQty");
		this.hashFields.put("ovr_lf_len", "ovrLfLen");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovr_rt_len", "ovrRtLen");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
		this.hashFields.put("ovfr", "ovfr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgSkdSeq
	 */
	public String getBkgSkdSeq() {
		return this.bkgSkdSeq;
	}
	
	/**
	 * Column Info
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return ovrVoidSltQty
	 */
	public String getOvrVoidSltQty() {
		return this.ovrVoidSltQty;
	}
	
	/**
	 * Column Info
	 * @return ovrLfLen
	 */
	public String getOvrLfLen() {
		return this.ovrLfLen;
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
	 * @return ovrRtLen
	 */
	public String getOvrRtLen() {
		return this.ovrRtLen;
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
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
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
	 * @return ovrBkwdLen
	 */
	public String getOvrBkwdLen() {
		return this.ovrBkwdLen;
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
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return ovrFwrdLen
	 */
	public String getOvrFwrdLen() {
		return this.ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @return ovfr
	 */
	public String getOvfr() {
		return this.ovfr;
	}

	/**
	 * Column Info
	 * @param bkgSkdSeq
	 */
	public void setBkgSkdSeq(String bkgSkdSeq) {
		this.bkgSkdSeq = bkgSkdSeq;
	}
	
	/**
	 * Column Info
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param ovrVoidSltQty
	 */
	public void setOvrVoidSltQty(String ovrVoidSltQty) {
		this.ovrVoidSltQty = ovrVoidSltQty;
	}
	
	/**
	 * Column Info
	 * @param ovrLfLen
	 */
	public void setOvrLfLen(String ovrLfLen) {
		this.ovrLfLen = ovrLfLen;
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
	 * @param ovrRtLen
	 */
	public void setOvrRtLen(String ovrRtLen) {
		this.ovrRtLen = ovrRtLen;
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
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
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
	 * @param ovrBkwdLen
	 */
	public void setOvrBkwdLen(String ovrBkwdLen) {
		this.ovrBkwdLen = ovrBkwdLen;
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
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param ovrFwrdLen
	 */
	public void setOvrFwrdLen(String ovrFwrdLen) {
		this.ovrFwrdLen = ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @param ovrFwrdLen
	 */
	public void setOvfr(String ovfr) {
		this.ovfr = ovfr;
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
		setBkgSkdSeq(JSPUtil.getParameter(request, prefix + "bkg_skd_seq", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, prefix + "awk_cgo_seq", ""));
		setOvrVoidSltQty(JSPUtil.getParameter(request, prefix + "ovr_void_slt_qty", ""));
		setOvrLfLen(JSPUtil.getParameter(request, prefix + "ovr_lf_len", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOvrRtLen(JSPUtil.getParameter(request, prefix + "ovr_rt_len", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
		setOvfr(JSPUtil.getParameter(request, prefix + "ovfr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgTerminalEdiJapanAwkCgoVO[]
	 */
	public BkgTerminalEdiJapanAwkCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgTerminalEdiJapanAwkCgoVO[]
	 */
	public BkgTerminalEdiJapanAwkCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTerminalEdiJapanAwkCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgSkdSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_skd_seq", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] ovrVoidSltQty = (JSPUtil.getParameter(request, prefix	+ "ovr_void_slt_qty", length));
			String[] ovrLfLen = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_len", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovrRtLen = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_len", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len", length));
			String[] ovfr = (JSPUtil.getParameter(request, prefix	+ "ovfr", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgTerminalEdiJapanAwkCgoVO();
				if (bkgSkdSeq[i] != null)
					model.setBkgSkdSeq(bkgSkdSeq[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (ovrVoidSltQty[i] != null)
					model.setOvrVoidSltQty(ovrVoidSltQty[i]);
				if (ovrLfLen[i] != null)
					model.setOvrLfLen(ovrLfLen[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovrRtLen[i] != null)
					model.setOvrRtLen(ovrRtLen[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ovrBkwdLen[i] != null)
					model.setOvrBkwdLen(ovrBkwdLen[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (ovrFwrdLen[i] != null)
					model.setOvrFwrdLen(ovrFwrdLen[i]);
				if (ovfr[i] != null)
					model.setOvfr(ovfr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTerminalEdiJapanAwkCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgTerminalEdiJapanAwkCgoVO[]
	 */
	public BkgTerminalEdiJapanAwkCgoVO[] getBkgTerminalEdiJapanAwkCgoVOs(){
		BkgTerminalEdiJapanAwkCgoVO[] vos = (BkgTerminalEdiJapanAwkCgoVO[])models.toArray(new BkgTerminalEdiJapanAwkCgoVO[models.size()]);
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
		this.bkgSkdSeq = this.bkgSkdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrVoidSltQty = this.ovrVoidSltQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfLen = this.ovrLfLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrRtLen = this.ovrRtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLen = this.ovrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLen = this.ovrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovfr = this.ovfr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
