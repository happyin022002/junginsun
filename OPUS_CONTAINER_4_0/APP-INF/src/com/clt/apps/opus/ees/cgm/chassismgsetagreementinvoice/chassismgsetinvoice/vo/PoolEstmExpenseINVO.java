/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolEstmExpenseINVO.java
*@FileTitle : PoolEstmExpenseINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.12.29 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolEstmExpenseINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolEstmExpenseINVO> models = new ArrayList<PoolEstmExpenseINVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String yearMh = null;
	/* Column Info */
	private String chssPoolTpCd = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String year = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolEstmExpenseINVO() {}

	public PoolEstmExpenseINVO(String ibflag, String pagerows, String currCd, String chssPoolCd, String agmtSeq, String agmtOfcCtyCd, String chssPoolTpCd, String year, String yearMh) {
		this.ibflag = ibflag;
		this.chssPoolCd = chssPoolCd;
		this.currCd = currCd;
		this.yearMh = yearMh;
		this.chssPoolTpCd = chssPoolTpCd;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.agmtSeq = agmtSeq;
		this.year = year;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("year_mh", getYearMh());
		this.hashColumns.put("chss_pool_tp_cd", getChssPoolTpCd());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("year_mh", "yearMh");
		this.hashFields.put("chss_pool_tp_cd", "chssPoolTpCd");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("year", "year");
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return yearMh
	 */
	public String getYearMh() {
		return this.yearMh;
	}
	
	/**
	 * Column Info
	 * @return chssPoolTpCd
	 */
	public String getChssPoolTpCd() {
		return this.chssPoolTpCd;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return year
	 */
	public String getYear() {
		return this.year;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param yearMh
	 */
	public void setYearMh(String yearMh) {
		this.yearMh = yearMh;
	}
	
	/**
	 * Column Info
	 * @param chssPoolTpCd
	 */
	public void setChssPoolTpCd(String chssPoolTpCd) {
		this.chssPoolTpCd = chssPoolTpCd;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
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
		setChssPoolCd(JSPUtil.getParameter(request, prefix + "chss_pool_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setYearMh(JSPUtil.getParameter(request, prefix + "year_mh", ""));
		setChssPoolTpCd(JSPUtil.getParameter(request, prefix + "chss_pool_tp_cd", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setYear(JSPUtil.getParameter(request, prefix + "year", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolEstmExpenseINVO[]
	 */
	public PoolEstmExpenseINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolEstmExpenseINVO[]
	 */
	public PoolEstmExpenseINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolEstmExpenseINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] yearMh = (JSPUtil.getParameter(request, prefix	+ "year_mh", length));
			String[] chssPoolTpCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_tp_cd", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolEstmExpenseINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (yearMh[i] != null)
					model.setYearMh(yearMh[i]);
				if (chssPoolTpCd[i] != null)
					model.setChssPoolTpCd(chssPoolTpCd[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolEstmExpenseINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolEstmExpenseINVO[]
	 */
	public PoolEstmExpenseINVO[] getPoolEstmExpenseINVOs(){
		PoolEstmExpenseINVO[] vos = (PoolEstmExpenseINVO[])models.toArray(new PoolEstmExpenseINVO[models.size()]);
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
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearMh = this.yearMh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolTpCd = this.chssPoolTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
