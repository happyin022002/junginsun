/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchUSInlandCost0163ListVO.java
*@FileTitle : SearchUSInlandCost0163ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.10.28 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchUSInlandCost0163ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUSInlandCost0163ListVO> models = new ArrayList<SearchUSInlandCost0163ListVO>();
	
	/* Column Info */
	private String mScmtFlg = null;
	/* Column Info */
	private String rRmk = null;
	/* Column Info */
	private String toLoc = null;
	/* Column Info */
	private String rScfurdFlg = null;
	/* Column Info */
	private String tRmk = null;
	/* Column Info */
	private String fmLoc = null;
	/* Column Info */
	private String tAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlCost = null;
	/* Column Info */
	private String tScfutdFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rAmt = null;
	/* Column Info */
	private String mTrmtFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mAmt = null;
	/* Column Info */
	private String tTrckFlg = null;
	/* Column Info */
	private String hubLoc = null;
	/* Column Info */
	private String rTrlcrdFlg = null;
	/* Column Info */
	private String mRmk = null;
	/* Column Info */
	private String bound = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchUSInlandCost0163ListVO() {}

	public SearchUSInlandCost0163ListVO(String ibflag, String pagerows, String bound, String cntrTpszCd, String fmLoc, String hubLoc, String toLoc, String ttlCost, String rAmt, String rTrlcrdFlg, String rScfurdFlg, String tAmt, String tTrckFlg, String tScfutdFlg, String mAmt, String mTrmtFlg, String mScmtFlg, String rRmk, String tRmk, String mRmk) {
		this.mScmtFlg = mScmtFlg;
		this.rRmk = rRmk;
		this.toLoc = toLoc;
		this.rScfurdFlg = rScfurdFlg;
		this.tRmk = tRmk;
		this.fmLoc = fmLoc;
		this.tAmt = tAmt;
		this.pagerows = pagerows;
		this.ttlCost = ttlCost;
		this.tScfutdFlg = tScfutdFlg;
		this.ibflag = ibflag;
		this.rAmt = rAmt;
		this.mTrmtFlg = mTrmtFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.mAmt = mAmt;
		this.tTrckFlg = tTrckFlg;
		this.hubLoc = hubLoc;
		this.rTrlcrdFlg = rTrlcrdFlg;
		this.mRmk = mRmk;
		this.bound = bound;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("m_scmt_flg", getMScmtFlg());
		this.hashColumns.put("r_rmk", getRRmk());
		this.hashColumns.put("to_loc", getToLoc());
		this.hashColumns.put("r_scfurd_flg", getRScfurdFlg());
		this.hashColumns.put("t_rmk", getTRmk());
		this.hashColumns.put("fm_loc", getFmLoc());
		this.hashColumns.put("t_amt", getTAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_cost", getTtlCost());
		this.hashColumns.put("t_scfutd_flg", getTScfutdFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r_amt", getRAmt());
		this.hashColumns.put("m_trmt_flg", getMTrmtFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("m_amt", getMAmt());
		this.hashColumns.put("t_trck_flg", getTTrckFlg());
		this.hashColumns.put("hub_loc", getHubLoc());
		this.hashColumns.put("r_trlcrd_flg", getRTrlcrdFlg());
		this.hashColumns.put("m_rmk", getMRmk());
		this.hashColumns.put("bound", getBound());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("m_scmt_flg", "mScmtFlg");
		this.hashFields.put("r_rmk", "rRmk");
		this.hashFields.put("to_loc", "toLoc");
		this.hashFields.put("r_scfurd_flg", "rScfurdFlg");
		this.hashFields.put("t_rmk", "tRmk");
		this.hashFields.put("fm_loc", "fmLoc");
		this.hashFields.put("t_amt", "tAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_cost", "ttlCost");
		this.hashFields.put("t_scfutd_flg", "tScfutdFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r_amt", "rAmt");
		this.hashFields.put("m_trmt_flg", "mTrmtFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("m_amt", "mAmt");
		this.hashFields.put("t_trck_flg", "tTrckFlg");
		this.hashFields.put("hub_loc", "hubLoc");
		this.hashFields.put("r_trlcrd_flg", "rTrlcrdFlg");
		this.hashFields.put("m_rmk", "mRmk");
		this.hashFields.put("bound", "bound");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mScmtFlg
	 */
	public String getMScmtFlg() {
		return this.mScmtFlg;
	}
	
	/**
	 * Column Info
	 * @return rRmk
	 */
	public String getRRmk() {
		return this.rRmk;
	}
	
	/**
	 * Column Info
	 * @return toLoc
	 */
	public String getToLoc() {
		return this.toLoc;
	}
	
	/**
	 * Column Info
	 * @return rScfurdFlg
	 */
	public String getRScfurdFlg() {
		return this.rScfurdFlg;
	}
	
	/**
	 * Column Info
	 * @return tRmk
	 */
	public String getTRmk() {
		return this.tRmk;
	}
	
	/**
	 * Column Info
	 * @return fmLoc
	 */
	public String getFmLoc() {
		return this.fmLoc;
	}
	
	/**
	 * Column Info
	 * @return tAmt
	 */
	public String getTAmt() {
		return this.tAmt;
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
	 * @return ttlCost
	 */
	public String getTtlCost() {
		return this.ttlCost;
	}
	
	/**
	 * Column Info
	 * @return tScfutdFlg
	 */
	public String getTScfutdFlg() {
		return this.tScfutdFlg;
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
	 * @return rAmt
	 */
	public String getRAmt() {
		return this.rAmt;
	}
	
	/**
	 * Column Info
	 * @return mTrmtFlg
	 */
	public String getMTrmtFlg() {
		return this.mTrmtFlg;
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
	 * @return mAmt
	 */
	public String getMAmt() {
		return this.mAmt;
	}
	
	/**
	 * Column Info
	 * @return tTrckFlg
	 */
	public String getTTrckFlg() {
		return this.tTrckFlg;
	}
	
	/**
	 * Column Info
	 * @return hubLoc
	 */
	public String getHubLoc() {
		return this.hubLoc;
	}
	
	/**
	 * Column Info
	 * @return rTrlcrdFlg
	 */
	public String getRTrlcrdFlg() {
		return this.rTrlcrdFlg;
	}
	
	/**
	 * Column Info
	 * @return mRmk
	 */
	public String getMRmk() {
		return this.mRmk;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	

	/**
	 * Column Info
	 * @param mScmtFlg
	 */
	public void setMScmtFlg(String mScmtFlg) {
		this.mScmtFlg = mScmtFlg;
	}
	
	/**
	 * Column Info
	 * @param rRmk
	 */
	public void setRRmk(String rRmk) {
		this.rRmk = rRmk;
	}
	
	/**
	 * Column Info
	 * @param toLoc
	 */
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}
	
	/**
	 * Column Info
	 * @param rScfurdFlg
	 */
	public void setRScfurdFlg(String rScfurdFlg) {
		this.rScfurdFlg = rScfurdFlg;
	}
	
	/**
	 * Column Info
	 * @param tRmk
	 */
	public void setTRmk(String tRmk) {
		this.tRmk = tRmk;
	}
	
	/**
	 * Column Info
	 * @param fmLoc
	 */
	public void setFmLoc(String fmLoc) {
		this.fmLoc = fmLoc;
	}
	
	/**
	 * Column Info
	 * @param tAmt
	 */
	public void setTAmt(String tAmt) {
		this.tAmt = tAmt;
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
	 * @param ttlCost
	 */
	public void setTtlCost(String ttlCost) {
		this.ttlCost = ttlCost;
	}
	
	/**
	 * Column Info
	 * @param tScfutdFlg
	 */
	public void setTScfutdFlg(String tScfutdFlg) {
		this.tScfutdFlg = tScfutdFlg;
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
	 * @param rAmt
	 */
	public void setRAmt(String rAmt) {
		this.rAmt = rAmt;
	}
	
	/**
	 * Column Info
	 * @param mTrmtFlg
	 */
	public void setMTrmtFlg(String mTrmtFlg) {
		this.mTrmtFlg = mTrmtFlg;
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
	 * @param mAmt
	 */
	public void setMAmt(String mAmt) {
		this.mAmt = mAmt;
	}
	
	/**
	 * Column Info
	 * @param tTrckFlg
	 */
	public void setTTrckFlg(String tTrckFlg) {
		this.tTrckFlg = tTrckFlg;
	}
	
	/**
	 * Column Info
	 * @param hubLoc
	 */
	public void setHubLoc(String hubLoc) {
		this.hubLoc = hubLoc;
	}
	
	/**
	 * Column Info
	 * @param rTrlcrdFlg
	 */
	public void setRTrlcrdFlg(String rTrlcrdFlg) {
		this.rTrlcrdFlg = rTrlcrdFlg;
	}
	
	/**
	 * Column Info
	 * @param mRmk
	 */
	public void setMRmk(String mRmk) {
		this.mRmk = mRmk;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
		setMScmtFlg(JSPUtil.getParameter(request, prefix + "m_scmt_flg", ""));
		setRRmk(JSPUtil.getParameter(request, prefix + "r_rmk", ""));
		setToLoc(JSPUtil.getParameter(request, prefix + "to_loc", ""));
		setRScfurdFlg(JSPUtil.getParameter(request, prefix + "r_scfurd_flg", ""));
		setTRmk(JSPUtil.getParameter(request, prefix + "t_rmk", ""));
		setFmLoc(JSPUtil.getParameter(request, prefix + "fm_loc", ""));
		setTAmt(JSPUtil.getParameter(request, prefix + "t_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlCost(JSPUtil.getParameter(request, prefix + "ttl_cost", ""));
		setTScfutdFlg(JSPUtil.getParameter(request, prefix + "t_scfutd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRAmt(JSPUtil.getParameter(request, prefix + "r_amt", ""));
		setMTrmtFlg(JSPUtil.getParameter(request, prefix + "m_trmt_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMAmt(JSPUtil.getParameter(request, prefix + "m_amt", ""));
		setTTrckFlg(JSPUtil.getParameter(request, prefix + "t_trck_flg", ""));
		setHubLoc(JSPUtil.getParameter(request, prefix + "hub_loc", ""));
		setRTrlcrdFlg(JSPUtil.getParameter(request, prefix + "r_trlcrd_flg", ""));
		setMRmk(JSPUtil.getParameter(request, prefix + "m_rmk", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUSInlandCost0163ListVO[]
	 */
	public SearchUSInlandCost0163ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUSInlandCost0163ListVO[]
	 */
	public SearchUSInlandCost0163ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUSInlandCost0163ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mScmtFlg = (JSPUtil.getParameter(request, prefix	+ "m_scmt_flg", length));
			String[] rRmk = (JSPUtil.getParameter(request, prefix	+ "r_rmk", length));
			String[] toLoc = (JSPUtil.getParameter(request, prefix	+ "to_loc", length));
			String[] rScfurdFlg = (JSPUtil.getParameter(request, prefix	+ "r_scfurd_flg", length));
			String[] tRmk = (JSPUtil.getParameter(request, prefix	+ "t_rmk", length));
			String[] fmLoc = (JSPUtil.getParameter(request, prefix	+ "fm_loc", length));
			String[] tAmt = (JSPUtil.getParameter(request, prefix	+ "t_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlCost = (JSPUtil.getParameter(request, prefix	+ "ttl_cost", length));
			String[] tScfutdFlg = (JSPUtil.getParameter(request, prefix	+ "t_scfutd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rAmt = (JSPUtil.getParameter(request, prefix	+ "r_amt", length));
			String[] mTrmtFlg = (JSPUtil.getParameter(request, prefix	+ "m_trmt_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mAmt = (JSPUtil.getParameter(request, prefix	+ "m_amt", length));
			String[] tTrckFlg = (JSPUtil.getParameter(request, prefix	+ "t_trck_flg", length));
			String[] hubLoc = (JSPUtil.getParameter(request, prefix	+ "hub_loc", length));
			String[] rTrlcrdFlg = (JSPUtil.getParameter(request, prefix	+ "r_trlcrd_flg", length));
			String[] mRmk = (JSPUtil.getParameter(request, prefix	+ "m_rmk", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUSInlandCost0163ListVO();
				if (mScmtFlg[i] != null)
					model.setMScmtFlg(mScmtFlg[i]);
				if (rRmk[i] != null)
					model.setRRmk(rRmk[i]);
				if (toLoc[i] != null)
					model.setToLoc(toLoc[i]);
				if (rScfurdFlg[i] != null)
					model.setRScfurdFlg(rScfurdFlg[i]);
				if (tRmk[i] != null)
					model.setTRmk(tRmk[i]);
				if (fmLoc[i] != null)
					model.setFmLoc(fmLoc[i]);
				if (tAmt[i] != null)
					model.setTAmt(tAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlCost[i] != null)
					model.setTtlCost(ttlCost[i]);
				if (tScfutdFlg[i] != null)
					model.setTScfutdFlg(tScfutdFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rAmt[i] != null)
					model.setRAmt(rAmt[i]);
				if (mTrmtFlg[i] != null)
					model.setMTrmtFlg(mTrmtFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mAmt[i] != null)
					model.setMAmt(mAmt[i]);
				if (tTrckFlg[i] != null)
					model.setTTrckFlg(tTrckFlg[i]);
				if (hubLoc[i] != null)
					model.setHubLoc(hubLoc[i]);
				if (rTrlcrdFlg[i] != null)
					model.setRTrlcrdFlg(rTrlcrdFlg[i]);
				if (mRmk[i] != null)
					model.setMRmk(mRmk[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUSInlandCost0163ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUSInlandCost0163ListVO[]
	 */
	public SearchUSInlandCost0163ListVO[] getSearchUSInlandCost0163ListVOs(){
		SearchUSInlandCost0163ListVO[] vos = (SearchUSInlandCost0163ListVO[])models.toArray(new SearchUSInlandCost0163ListVO[models.size()]);
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
		this.mScmtFlg = this.mScmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rRmk = this.rRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoc = this.toLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rScfurdFlg = this.rScfurdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tRmk = this.tRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoc = this.fmLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tAmt = this.tAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCost = this.ttlCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tScfutdFlg = this.tScfutdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rAmt = this.rAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mTrmtFlg = this.mTrmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mAmt = this.mAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tTrckFlg = this.tTrckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLoc = this.hubLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTrlcrdFlg = this.rTrlcrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRmk = this.mRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
