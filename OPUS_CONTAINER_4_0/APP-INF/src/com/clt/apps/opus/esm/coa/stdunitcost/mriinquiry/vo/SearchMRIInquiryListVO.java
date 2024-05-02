/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMRIInquiryListVO.java
*@FileTitle : SearchMRIInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.10.15 장영석 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMRIInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMRIInquiryListVO> models = new ArrayList<SearchMRIInquiryListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etcUtRevAmt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String trdTtlQty = null;
	/* Column Info */
	private String trdTtlAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * SearchMRIInquiryListVO 생성자
	 */
	public SearchMRIInquiryListVO() {}

	/**
	 * SearchMRIInquiryListVO 생성자
	 * @param ibflag
	 * @param pagerows
	 */
	public SearchMRIInquiryListVO(String ibflag, String pagerows, String revYrmon, String trdCd, String dirCd, String rlaneCd, String trdTtlAmt, String trdTtlQty, String etcUtRevAmt) {
		this.ibflag = ibflag;
		this.etcUtRevAmt = etcUtRevAmt;
		this.revYrmon = revYrmon;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.dirCd = dirCd;
		this.trdTtlQty = trdTtlQty;
		this.trdTtlAmt = trdTtlAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etc_ut_rev_amt", getEtcUtRevAmt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("trd_ttl_qty", getTrdTtlQty());
		this.hashColumns.put("trd_ttl_amt", getTrdTtlAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etc_ut_rev_amt", "etcUtRevAmt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("trd_ttl_qty", "trdTtlQty");
		this.hashFields.put("trd_ttl_amt", "trdTtlAmt");
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
	 * @return etcUtRevAmt
	 */
	public String getEtcUtRevAmt() {
		return this.etcUtRevAmt;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return trdTtlQty
	 */
	public String getTrdTtlQty() {
		return this.trdTtlQty;
	}
	
	/**
	 * Column Info
	 * @return trdTtlAmt
	 */
	public String getTrdTtlAmt() {
		return this.trdTtlAmt;
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
	 * @param etcUtRevAmt
	 */
	public void setEtcUtRevAmt(String etcUtRevAmt) {
		this.etcUtRevAmt = etcUtRevAmt;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param trdTtlQty
	 */
	public void setTrdTtlQty(String trdTtlQty) {
		this.trdTtlQty = trdTtlQty;
	}
	
	/**
	 * Column Info
	 * @param trdTtlAmt
	 */
	public void setTrdTtlAmt(String trdTtlAmt) {
		this.trdTtlAmt = trdTtlAmt;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtcUtRevAmt(JSPUtil.getParameter(request, "etc_ut_rev_amt", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setTrdTtlQty(JSPUtil.getParameter(request, "trd_ttl_qty", ""));
		setTrdTtlAmt(JSPUtil.getParameter(request, "trd_ttl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMRIInquiryListVO[]
	 */
	public SearchMRIInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMRIInquiryListVO[]
	 */
	public SearchMRIInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMRIInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etcUtRevAmt = (JSPUtil.getParameter(request, prefix	+ "etc_ut_rev_amt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] trdTtlQty = (JSPUtil.getParameter(request, prefix	+ "trd_ttl_qty", length));
			String[] trdTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trd_ttl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMRIInquiryListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etcUtRevAmt[i] != null)
					model.setEtcUtRevAmt(etcUtRevAmt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (trdTtlQty[i] != null)
					model.setTrdTtlQty(trdTtlQty[i]);
				if (trdTtlAmt[i] != null)
					model.setTrdTtlAmt(trdTtlAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMRIInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMRIInquiryListVO[]
	 */
	public SearchMRIInquiryListVO[] getSearchMRIInquiryListVOs(){
		SearchMRIInquiryListVO[] vos = (SearchMRIInquiryListVO[])models.toArray(new SearchMRIInquiryListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcUtRevAmt = this.etcUtRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdTtlQty = this.trdTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdTtlAmt = this.trdTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
