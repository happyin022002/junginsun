/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchCopVO.java
*@FileTitle : SearchCopVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.09.30 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.bkgcopmanage.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCopVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCopVO> models = new ArrayList<SearchCopVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String mstBkgNo = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String planDt = null;
	/* Column Info */
	private String mstCopOrd = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actStsCd = null;
	/* Column Info */
	private String mstCopNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String cntrOrd = null;
	/* Column Info */
	private String mstFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCopVO() {}

	public SearchCopVO(String ibflag, String pagerows, String copNo, String bkgNo, String actStsCd, String planDt, String vslCd, String skdVoyNo, String skdDirCd, String clptIndSeq, String mtyPkupYdCd, String porNodCd, String fullRtnYdCd, String cntrNo, String mstCopNo, String mstFlg, String mstCopOrd, String mstBkgNo, String cntrOrd) {
		this.vslCd = vslCd;
		this.porNodCd = porNodCd;
		this.mstBkgNo = mstBkgNo;
		this.copNo = copNo;
		this.skdVoyNo = skdVoyNo;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.planDt = planDt;
		this.mstCopOrd = mstCopOrd;
		this.fullRtnYdCd = fullRtnYdCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.actStsCd = actStsCd;
		this.mstCopNo = mstCopNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.clptIndSeq = clptIndSeq;
		this.cntrOrd = cntrOrd;
		this.mstFlg = mstFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("mst_bkg_no", getMstBkgNo());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("plan_dt", getPlanDt());
		this.hashColumns.put("mst_cop_ord", getMstCopOrd());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_sts_cd", getActStsCd());
		this.hashColumns.put("mst_cop_no", getMstCopNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("cntr_ord", getCntrOrd());
		this.hashColumns.put("mst_flg", getMstFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("mst_bkg_no", "mstBkgNo");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("plan_dt", "planDt");
		this.hashFields.put("mst_cop_ord", "mstCopOrd");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_sts_cd", "actStsCd");
		this.hashFields.put("mst_cop_no", "mstCopNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("cntr_ord", "cntrOrd");
		this.hashFields.put("mst_flg", "mstFlg");
		return this.hashFields;
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
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return mstBkgNo
	 */
	public String getMstBkgNo() {
		return this.mstBkgNo;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return planDt
	 */
	public String getPlanDt() {
		return this.planDt;
	}
	
	/**
	 * Column Info
	 * @return mstCopOrd
	 */
	public String getMstCopOrd() {
		return this.mstCopOrd;
	}
	
	/**
	 * Column Info
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return mstCopNo
	 */
	public String getMstCopNo() {
		return this.mstCopNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrOrd
	 */
	public String getCntrOrd() {
		return this.cntrOrd;
	}
	
	/**
	 * Column Info
	 * @return mstFlg
	 */
	public String getMstFlg() {
		return this.mstFlg;
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
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param mstBkgNo
	 */
	public void setMstBkgNo(String mstBkgNo) {
		this.mstBkgNo = mstBkgNo;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param planDt
	 */
	public void setPlanDt(String planDt) {
		this.planDt = planDt;
	}
	
	/**
	 * Column Info
	 * @param mstCopOrd
	 */
	public void setMstCopOrd(String mstCopOrd) {
		this.mstCopOrd = mstCopOrd;
	}
	
	/**
	 * Column Info
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param mstCopNo
	 */
	public void setMstCopNo(String mstCopNo) {
		this.mstCopNo = mstCopNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrOrd
	 */
	public void setCntrOrd(String cntrOrd) {
		this.cntrOrd = cntrOrd;
	}
	
	/**
	 * Column Info
	 * @param mstFlg
	 */
	public void setMstFlg(String mstFlg) {
		this.mstFlg = mstFlg;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setMstBkgNo(JSPUtil.getParameter(request, prefix + "mst_bkg_no", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
		setPlanDt(JSPUtil.getParameter(request, prefix + "plan_dt", ""));
		setMstCopOrd(JSPUtil.getParameter(request, prefix + "mst_cop_ord", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setActStsCd(JSPUtil.getParameter(request, prefix + "act_sts_cd", ""));
		setMstCopNo(JSPUtil.getParameter(request, prefix + "mst_cop_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setCntrOrd(JSPUtil.getParameter(request, prefix + "cntr_ord", ""));
		setMstFlg(JSPUtil.getParameter(request, prefix + "mst_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCopVO[]
	 */
	public SearchCopVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCopVO[]
	 */
	public SearchCopVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCopVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] mstBkgNo = (JSPUtil.getParameter(request, prefix	+ "mst_bkg_no", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] planDt = (JSPUtil.getParameter(request, prefix	+ "plan_dt", length));
			String[] mstCopOrd = (JSPUtil.getParameter(request, prefix	+ "mst_cop_ord", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actStsCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_cd", length));
			String[] mstCopNo = (JSPUtil.getParameter(request, prefix	+ "mst_cop_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] cntrOrd = (JSPUtil.getParameter(request, prefix	+ "cntr_ord", length));
			String[] mstFlg = (JSPUtil.getParameter(request, prefix	+ "mst_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCopVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (mstBkgNo[i] != null)
					model.setMstBkgNo(mstBkgNo[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (planDt[i] != null)
					model.setPlanDt(planDt[i]);
				if (mstCopOrd[i] != null)
					model.setMstCopOrd(mstCopOrd[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actStsCd[i] != null)
					model.setActStsCd(actStsCd[i]);
				if (mstCopNo[i] != null)
					model.setMstCopNo(mstCopNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (cntrOrd[i] != null)
					model.setCntrOrd(cntrOrd[i]);
				if (mstFlg[i] != null)
					model.setMstFlg(mstFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCopVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCopVO[]
	 */
	public SearchCopVO[] getSearchCopVOs(){
		SearchCopVO[] vos = (SearchCopVO[])models.toArray(new SearchCopVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBkgNo = this.mstBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planDt = this.planDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCopOrd = this.mstCopOrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsCd = this.actStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCopNo = this.mstCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOrd = this.cntrOrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstFlg = this.mstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
