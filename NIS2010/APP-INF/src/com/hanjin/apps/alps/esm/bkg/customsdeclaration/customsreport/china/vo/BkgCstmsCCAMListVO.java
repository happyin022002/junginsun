/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCstmsCCAMListVO.java
*@FileTitle : BkgCstmsCCAMListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BkgCstmsCCAMListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsCCAMListVO> models = new ArrayList<BkgCstmsCCAMListVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String sndCnt = null;
	/* Column Info */
	private String waitCnt = null;
	/* Column Info */
	private String acptCnt = null;
	/* Column Info */
	private String rjctCnt = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String nRcvCnt = null;
	/* Column Info */
	private String amendCnt = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String gap = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsCCAMListVO() {}

	public BkgCstmsCCAMListVO(String ibflag, String pagerows, String bkgOfcCd, String vpsEtbDt, String sndCnt, String waitCnt, String acptCnt, String rjctCnt, String sndDt, String vvd, String polCd, String slanCd, String nRcvCnt, String amendCnt, String blCnt, String rhq, String gap) {
		this.bkgOfcCd = bkgOfcCd;
		this.vpsEtbDt = vpsEtbDt;
		this.sndCnt = sndCnt;
		this.waitCnt = waitCnt;
		this.acptCnt = acptCnt;
		this.rjctCnt = rjctCnt;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.slanCd = slanCd;
		this.nRcvCnt = nRcvCnt;
		this.amendCnt = amendCnt;
		this.blCnt = blCnt;
		this.gap = gap;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("snd_cnt", getSndCnt());
		this.hashColumns.put("wait_cnt", getWaitCnt());
		this.hashColumns.put("acpt_cnt", getAcptCnt());
		this.hashColumns.put("rjct_cnt", getRjctCnt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("n_rcv_cnt", getNRcvCnt());
		this.hashColumns.put("amend_cnt", getAmendCnt());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("gap", getGap());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("snd_cnt", "sndCnt");
		this.hashFields.put("wait_cnt", "waitCnt");
		this.hashFields.put("acpt_cnt", "acptCnt");
		this.hashFields.put("rjct_cnt", "rjctCnt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("n_rcv_cnt", "nRcvCnt");
		this.hashFields.put("amend_cnt", "amendCnt");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("gap", "gap");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return sndCnt
	 */
	public String getSndCnt() {
		return this.sndCnt;
	}
	
	/**
	 * Column Info
	 * @return waitCnt
	 */
	public String getWaitCnt() {
		return this.waitCnt;
	}
	
	/**
	 * Column Info
	 * @return acptCnt
	 */
	public String getAcptCnt() {
		return this.acptCnt;
	}
	
	/**
	 * Column Info
	 * @return rjctCnt
	 */
	public String getRjctCnt() {
		return this.rjctCnt;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return nRcvCnt
	 */
	public String getNRcvCnt() {
		return this.nRcvCnt;
	}
	
	/**
	 * Column Info
	 * @return amendCnt
	 */
	public String getAmendCnt() {
		return this.amendCnt;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	
	/**
	 * Column Info
	 * @return gap
	 */
	public String getGap() {
		return this.gap;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param sndCnt
	 */
	public void setSndCnt(String sndCnt) {
		this.sndCnt = sndCnt;
	}
	
	/**
	 * Column Info
	 * @param waitCnt
	 */
	public void setWaitCnt(String waitCnt) {
		this.waitCnt = waitCnt;
	}
	
	/**
	 * Column Info
	 * @param acptCnt
	 */
	public void setAcptCnt(String acptCnt) {
		this.acptCnt = acptCnt;
	}
	
	/**
	 * Column Info
	 * @param rjctCnt
	 */
	public void setRjctCnt(String rjctCnt) {
		this.rjctCnt = rjctCnt;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param nRcvCnt
	 */
	public void setNRcvCnt(String nRcvCnt) {
		this.nRcvCnt = nRcvCnt;
	}
	
	/**
	 * Column Info
	 * @param amendCnt
	 */
	public void setAmendCnt(String amendCnt) {
		this.amendCnt = amendCnt;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
	}
	
	/**
	 * Column Info
	 * @param gap
	 */
	public void setGap(String gap) {
		this.gap = gap;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setSndCnt(JSPUtil.getParameter(request, prefix + "snd_cnt", ""));
		setWaitCnt(JSPUtil.getParameter(request, prefix + "wait_cnt", ""));
		setAcptCnt(JSPUtil.getParameter(request, prefix + "acpt_cnt", ""));
		setRjctCnt(JSPUtil.getParameter(request, prefix + "rjct_cnt", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setNRcvCnt(JSPUtil.getParameter(request, prefix + "n_rcv_cnt", ""));
		setAmendCnt(JSPUtil.getParameter(request, prefix + "amend_cnt", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setGap(JSPUtil.getParameter(request, prefix + "gap", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsCCAMListVO[]
	 */
	public BkgCstmsCCAMListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsCCAMListVO[]
	 */
	public BkgCstmsCCAMListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsCCAMListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] sndCnt = (JSPUtil.getParameter(request, prefix	+ "snd_cnt", length));
			String[] waitCnt = (JSPUtil.getParameter(request, prefix	+ "wait_cnt", length));
			String[] acptCnt = (JSPUtil.getParameter(request, prefix	+ "acpt_cnt", length));
			String[] rjctCnt = (JSPUtil.getParameter(request, prefix	+ "rjct_cnt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] nRcvCnt = (JSPUtil.getParameter(request, prefix	+ "n_rcv_cnt", length));
			String[] amendCnt = (JSPUtil.getParameter(request, prefix	+ "amend_cnt", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] gap = (JSPUtil.getParameter(request, prefix	+ "gap", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsCCAMListVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (sndCnt[i] != null)
					model.setSndCnt(sndCnt[i]);
				if (waitCnt[i] != null)
					model.setWaitCnt(waitCnt[i]);
				if (acptCnt[i] != null)
					model.setAcptCnt(acptCnt[i]);
				if (rjctCnt[i] != null)
					model.setRjctCnt(rjctCnt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (nRcvCnt[i] != null)
					model.setNRcvCnt(nRcvCnt[i]);
				if (amendCnt[i] != null)
					model.setAmendCnt(amendCnt[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (gap[i] != null)
					model.setGap(gap[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsCCAMListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsCCAMListVO[]
	 */
	public BkgCstmsCCAMListVO[] getBkgCstmsCCAMListVOs(){
		BkgCstmsCCAMListVO[] vos = (BkgCstmsCCAMListVO[])models.toArray(new BkgCstmsCCAMListVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndCnt = this.sndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitCnt = this.waitCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptCnt = this.acptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctCnt = this.rjctCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nRcvCnt = this.nRcvCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendCnt = this.amendCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gap = this.gap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
