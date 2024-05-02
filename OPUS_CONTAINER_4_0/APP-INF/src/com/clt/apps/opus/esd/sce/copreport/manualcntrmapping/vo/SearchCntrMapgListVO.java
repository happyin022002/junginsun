/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCntrMapgListVO.java
*@FileTitle : SearchCntrMapgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.19 오현경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.vo;

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

public class SearchCntrMapgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCntrMapgListVO> models = new ArrayList<SearchCntrMapgListVO>();
	

	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrDeTermCd = null;
	/* Column Info */
	private String cntrRcvTermCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String dist = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCntrMapgListVO() {}

	public SearchCntrMapgListVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String cntrTpszCd, String bkgCreDt, String cntrVolQty, String cntrRcvTermCd, String cntrDeTermCd, String dist) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrDeTermCd = cntrDeTermCd;
		this.cntrRcvTermCd = cntrRcvTermCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.bkgCreDt = bkgCreDt;
		this.cntrVolQty = cntrVolQty;
		this.dist = dist;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_de_term_cd", getCntrDeTermCd());
		this.hashColumns.put("cntr_rcv_term_cd", getCntrRcvTermCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("dist", getDist());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_de_term_cd", "cntrDeTermCd");
		this.hashFields.put("cntr_rcv_term_cd", "cntrRcvTermCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("dist", "dist");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return cntrDeTermCd
	 */
	public String getCntrDeTermCd() {
		return this.cntrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return cntrRcvTermCd
	 */
	public String getCntrRcvTermCd() {
		return this.cntrRcvTermCd;
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
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
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
	 * @return dist
	 */
	public String getDist() {
		return this.dist;
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
	 * @param cntrDeTermCd
	 */
	public void setCntrDeTermCd(String cntrDeTermCd) {
		this.cntrDeTermCd = cntrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param cntrRcvTermCd
	 */
	public void setCntrRcvTermCd(String cntrRcvTermCd) {
		this.cntrRcvTermCd = cntrRcvTermCd;
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
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
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
	 * @param dist
	 */
	public void setDist(String dist) {
		this.dist = dist;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrDeTermCd(JSPUtil.getParameter(request, "cntr_de_term_cd", ""));
		setCntrRcvTermCd(JSPUtil.getParameter(request, "cntr_rcv_term_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setBkgCreDt(JSPUtil.getParameter(request, "bkg_cre_dt", ""));
		setCntrVolQty(JSPUtil.getParameter(request, "cntr_vol_qty", ""));
		setDist(JSPUtil.getParameter(request, "dist", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCntrMapgListVO[]
	 */
	public SearchCntrMapgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCntrMapgListVO[]
	 */
	public SearchCntrMapgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCntrMapgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "cntr_de_term_cd", length));
			String[] cntrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rcv_term_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] dist = (JSPUtil.getParameter(request, prefix	+ "dist", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCntrMapgListVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrDeTermCd[i] != null)
					model.setCntrDeTermCd(cntrDeTermCd[i]);
				if (cntrRcvTermCd[i] != null)
					model.setCntrRcvTermCd(cntrRcvTermCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (dist[i] != null)
					model.setDist(dist[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCntrMapgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCntrMapgListVO[]
	 */
	public SearchCntrMapgListVO[] getSearchCntrMapgListVOs(){
		SearchCntrMapgListVO[] vos = (SearchCntrMapgListVO[])models.toArray(new SearchCntrMapgListVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDeTermCd = this.cntrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRcvTermCd = this.cntrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dist = this.dist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
