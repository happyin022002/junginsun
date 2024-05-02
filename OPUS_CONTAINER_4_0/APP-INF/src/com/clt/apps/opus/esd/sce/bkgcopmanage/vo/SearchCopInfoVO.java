/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCopInfoVO.java
*@FileTitle : SearchCopInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.08.19 김인수 
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

public class SearchCopInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCopInfoVO> models = new ArrayList<SearchCopInfoVO>();
	
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String polNodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String mstCopNo = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCopInfoVO() {}

	public SearchCopInfoVO(String ibflag, String pagerows, String copNo, String bkgNo, String cntrNo, String cntrTpszCd, String cnmvYr, String copStsCd, String pctlNo, String mstCopNo, String trnkVslCd, String trnkSkdVoyNo, String trnkSkdDirCd, String porNodCd, String polNodCd, String podNodCd, String delNodCd) {
		this.porNodCd = porNodCd;
		this.copNo = copNo;
		this.polNodCd = polNodCd;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.mstCopNo = mstCopNo;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.podNodCd = podNodCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.copStsCd = copStsCd;
		this.trnkVslCd = trnkVslCd;
		this.delNodCd = delNodCd;
		this.cnmvYr = cnmvYr;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("mst_cop_no", getMstCopNo());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("mst_cop_no", "mstCopNo");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		return this.hashFields;
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return mstCopNo
	 */
	public String getMstCopNo() {
		return this.mstCopNo;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdDirCd
	 */
	public String getTrnkSkdDirCd() {
		return this.trnkSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return trnkVslCd
	 */
	public String getTrnkVslCd() {
		return this.trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdVoyNo
	 */
	public String getTrnkSkdVoyNo() {
		return this.trnkSkdVoyNo;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param mstCopNo
	 */
	public void setMstCopNo(String mstCopNo) {
		this.mstCopNo = mstCopNo;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdDirCd
	 */
	public void setTrnkSkdDirCd(String trnkSkdDirCd) {
		this.trnkSkdDirCd = trnkSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param trnkVslCd
	 */
	public void setTrnkVslCd(String trnkVslCd) {
		this.trnkVslCd = trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdVoyNo
	 */
	public void setTrnkSkdVoyNo(String trnkSkdVoyNo) {
		this.trnkSkdVoyNo = trnkSkdVoyNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setPolNodCd(JSPUtil.getParameter(request, "pol_nod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setMstCopNo(JSPUtil.getParameter(request, "mst_cop_no", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, "trnk_skd_dir_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, "trnk_vsl_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, "trnk_skd_voy_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCopInfoVO[]
	 */
	public SearchCopInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCopInfoVO[]
	 */
	public SearchCopInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCopInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] mstCopNo = (JSPUtil.getParameter(request, prefix	+ "mst_cop_no", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCopInfoVO();
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (mstCopNo[i] != null)
					model.setMstCopNo(mstCopNo[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCopInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCopInfoVO[]
	 */
	public SearchCopInfoVO[] getSearchCopInfoVOs(){
		SearchCopInfoVO[] vos = (SearchCopInfoVO[])models.toArray(new SearchCopInfoVO[models.size()]);
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
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCopNo = this.mstCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
