/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HoldInfoVO.java
*@FileTitle : HoldInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.01.13 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HoldInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HoldInfoVO> models = new ArrayList<HoldInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String last = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String hldCd = null;
	/* Column Info */
	private String hldDt = null;
	/* Column Info */
	private String remvCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HoldInfoVO() {}

	public HoldInfoVO(String ibflag, String pagerows, String hldCd, String hldDt, String rnum, String remvCd, String last) {
		this.ibflag = ibflag;
		this.last = last;
		this.rnum = rnum;
		this.hldCd = hldCd;
		this.hldDt = hldDt;
		this.remvCd = remvCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("last", getLast());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("hld_cd", getHldCd());
		this.hashColumns.put("hld_dt", getHldDt());
		this.hashColumns.put("remv_cd", getRemvCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("last", "last");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("hld_cd", "hldCd");
		this.hashFields.put("hld_dt", "hldDt");
		this.hashFields.put("remv_cd", "remvCd");
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
	 * @return last
	 */
	public String getLast() {
		return this.last;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return hldCd
	 */
	public String getHldCd() {
		return this.hldCd;
	}
	
	/**
	 * Column Info
	 * @return hldDt
	 */
	public String getHldDt() {
		return this.hldDt;
	}
	
	/**
	 * Column Info
	 * @return remvCd
	 */
	public String getRemvCd() {
		return this.remvCd;
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
	 * @param last
	 */
	public void setLast(String last) {
		this.last = last;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param hldCd
	 */
	public void setHldCd(String hldCd) {
		this.hldCd = hldCd;
	}
	
	/**
	 * Column Info
	 * @param hldDt
	 */
	public void setHldDt(String hldDt) {
		this.hldDt = hldDt;
	}
	
	/**
	 * Column Info
	 * @param remvCd
	 */
	public void setRemvCd(String remvCd) {
		this.remvCd = remvCd;
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
		setLast(JSPUtil.getParameter(request, prefix + "last", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setHldCd(JSPUtil.getParameter(request, prefix + "hld_cd", ""));
		setHldDt(JSPUtil.getParameter(request, prefix + "hld_dt", ""));
		setRemvCd(JSPUtil.getParameter(request, prefix + "remv_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HoldInfoVO[]
	 */
	public HoldInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HoldInfoVO[]
	 */
	public HoldInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HoldInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] last = (JSPUtil.getParameter(request, prefix	+ "last", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] hldCd = (JSPUtil.getParameter(request, prefix	+ "hld_cd", length));
			String[] hldDt = (JSPUtil.getParameter(request, prefix	+ "hld_dt", length));
			String[] remvCd = (JSPUtil.getParameter(request, prefix	+ "remv_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new HoldInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (last[i] != null)
					model.setLast(last[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (hldCd[i] != null)
					model.setHldCd(hldCd[i]);
				if (hldDt[i] != null)
					model.setHldDt(hldDt[i]);
				if (remvCd[i] != null)
					model.setRemvCd(remvCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHoldInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HoldInfoVO[]
	 */
	public HoldInfoVO[] getHoldInfoVOs(){
		HoldInfoVO[] vos = (HoldInfoVO[])models.toArray(new HoldInfoVO[models.size()]);
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
		this.last = this.last .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldCd = this.hldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldDt = this.hldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remvCd = this.remvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
