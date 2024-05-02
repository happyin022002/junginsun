/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPUpdateInfoVO.java
*@FileTitle : COPUpdateInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.11.27 오현경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copupdate.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class COPUpdateInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<COPUpdateInfoVO> models = new ArrayList<COPUpdateInfoVO>();
	
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String stndEdiStsCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String estmTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String estmActDt = null;
	/* Column Info */
	private String prcFlg = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String estmDate = null;
	/* Column Info */
	private String actTime = null;
	/* Column Info */
	private String actDate = null;
	/* Column Info */
	private String nodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public COPUpdateInfoVO() {}

	public COPUpdateInfoVO(String ibflag, String pagerows, String estmActDt, String estmDate, String estmTime, String actDate, String actTime, String copNo, String copDtlSeq, String nodCd, String actStsCd, String vslCd, String skdVoyNo, String skdDirCd, String stndEdiStsCd, String actDt, String cntrNo, String bkgNo, String userId, String prcFlg, String actCd) {
		this.actCd = actCd;
		this.vslCd = vslCd;
		this.copNo = copNo;
		this.stndEdiStsCd = stndEdiStsCd;
		this.skdVoyNo = skdVoyNo;
		this.copDtlSeq = copDtlSeq;
		this.skdDirCd = skdDirCd;
		this.estmTime = estmTime;
		this.pagerows = pagerows;
		this.actStsCd = actStsCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.estmActDt = estmActDt;
		this.prcFlg = prcFlg;
		this.actDt = actDt;
		this.cntrNo = cntrNo;
		this.userId = userId;
		this.estmDate = estmDate;
		this.actTime = actTime;
		this.actDate = actDate;
		this.nodCd = nodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("stnd_edi_sts_cd", getStndEdiStsCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("estm_time", getEstmTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_sts_cd", getActStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("estm_act_dt", getEstmActDt());
		this.hashColumns.put("prc_flg", getPrcFlg());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("estm_date", getEstmDate());
		this.hashColumns.put("act_time", getActTime());
		this.hashColumns.put("act_date", getActDate());
		this.hashColumns.put("nod_cd", getNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("stnd_edi_sts_cd", "stndEdiStsCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("estm_time", "estmTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_sts_cd", "actStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("estm_act_dt", "estmActDt");
		this.hashFields.put("prc_flg", "prcFlg");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("estm_date", "estmDate");
		this.hashFields.put("act_time", "actTime");
		this.hashFields.put("act_date", "actDate");
		this.hashFields.put("nod_cd", "nodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return stndEdiStsCd
	 */
	public String getStndEdiStsCd() {
		return this.stndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return estmTime
	 */
	public String getEstmTime() {
		return this.estmTime;
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
	 * @return actStsCd
	 */
	public String getActStsCd() {
		return this.actStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return estmActDt
	 */
	public String getEstmActDt() {
		return this.estmActDt;
	}
	
	/**
	 * Column Info
	 * @return prcFlg
	 */
	public String getPrcFlg() {
		return this.prcFlg;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return estmDate
	 */
	public String getEstmDate() {
		return this.estmDate;
	}
	
	/**
	 * Column Info
	 * @return actTime
	 */
	public String getActTime() {
		return this.actTime;
	}
	
	/**
	 * Column Info
	 * @return actDate
	 */
	public String getActDate() {
		return this.actDate;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	

	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param stndEdiStsCd
	 */
	public void setStndEdiStsCd(String stndEdiStsCd) {
		this.stndEdiStsCd = stndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param estmTime
	 */
	public void setEstmTime(String estmTime) {
		this.estmTime = estmTime;
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
	 * @param actStsCd
	 */
	public void setActStsCd(String actStsCd) {
		this.actStsCd = actStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param estmActDt
	 */
	public void setEstmActDt(String estmActDt) {
		this.estmActDt = estmActDt;
	}
	
	/**
	 * Column Info
	 * @param prcFlg
	 */
	public void setPrcFlg(String prcFlg) {
		this.prcFlg = prcFlg;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param estmDate
	 */
	public void setEstmDate(String estmDate) {
		this.estmDate = estmDate;
	}
	
	/**
	 * Column Info
	 * @param actTime
	 */
	public void setActTime(String actTime) {
		this.actTime = actTime;
	}
	
	/**
	 * Column Info
	 * @param actDate
	 */
	public void setActDate(String actDate) {
		this.actDate = actDate;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setStndEdiStsCd(JSPUtil.getParameter(request, "stnd_edi_sts_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setEstmTime(JSPUtil.getParameter(request, "estm_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActStsCd(JSPUtil.getParameter(request, "act_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEstmActDt(JSPUtil.getParameter(request, "estm_act_dt", ""));
		setPrcFlg(JSPUtil.getParameter(request, "prc_flg", ""));
		setActDt(JSPUtil.getParameter(request, "act_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setEstmDate(JSPUtil.getParameter(request, "estm_date", ""));
		setActTime(JSPUtil.getParameter(request, "act_time", ""));
		setActDate(JSPUtil.getParameter(request, "act_date", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return COPUpdateInfoVO[]
	 */
	public COPUpdateInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return COPUpdateInfoVO[]
	 */
	public COPUpdateInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		COPUpdateInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] stndEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "stnd_edi_sts_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] estmTime = (JSPUtil.getParameter(request, prefix	+ "estm_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actStsCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] estmActDt = (JSPUtil.getParameter(request, prefix	+ "estm_act_dt", length));
			String[] prcFlg = (JSPUtil.getParameter(request, prefix	+ "prc_flg", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] estmDate = (JSPUtil.getParameter(request, prefix	+ "estm_date", length));
			String[] actTime = (JSPUtil.getParameter(request, prefix	+ "act_time", length));
			String[] actDate = (JSPUtil.getParameter(request, prefix	+ "act_date", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new COPUpdateInfoVO();
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (stndEdiStsCd[i] != null)
					model.setStndEdiStsCd(stndEdiStsCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (estmTime[i] != null)
					model.setEstmTime(estmTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actStsCd[i] != null)
					model.setActStsCd(actStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (estmActDt[i] != null)
					model.setEstmActDt(estmActDt[i]);
				if (prcFlg[i] != null)
					model.setPrcFlg(prcFlg[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (estmDate[i] != null)
					model.setEstmDate(estmDate[i]);
				if (actTime[i] != null)
					model.setActTime(actTime[i]);
				if (actDate[i] != null)
					model.setActDate(actDate[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCOPUpdateInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return COPUpdateInfoVO[]
	 */
	public COPUpdateInfoVO[] getCOPUpdateInfoVOs(){
		COPUpdateInfoVO[] vos = (COPUpdateInfoVO[])models.toArray(new COPUpdateInfoVO[models.size()]);
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
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndEdiStsCd = this.stndEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTime = this.estmTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsCd = this.actStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmActDt = this.estmActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcFlg = this.prcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDate = this.estmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTime = this.actTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDate = this.actDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
