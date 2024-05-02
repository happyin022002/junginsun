/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaBlCondVO.java
*@FileTitle : UsaBlCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.12.08 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaBlCondVO extends BlCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBlCondVO> models = new ArrayList<UsaBlCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String startNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String endNo = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String dspoCd = null;
	/* Column Info */
	private String tabNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaBlCondVO() {}

	public UsaBlCondVO(String ibflag, String pagerows, String startNo, String endNo, String pageNo, String cntCd, String dspoCd, String tabNo, String blNo, String vvd) {
		this.vvd = vvd;
		this.startNo = startNo;
		this.ibflag = ibflag;
		this.endNo = endNo;
		this.pageNo = pageNo;
		this.cntCd = cntCd;
		this.dspoCd = dspoCd;
		this.tabNo = tabNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("start_no", getStartNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("end_no", getEndNo());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("dspo_cd", getDspoCd());
		this.hashColumns.put("tab_no", getTabNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("start_no", "startNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("end_no", "endNo");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("dspo_cd", "dspoCd");
		this.hashFields.put("tab_no", "tabNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return startNo
	 */
	public String getStartNo() {
		return this.startNo;
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
	 * @return endNo
	 */
	public String getEndNo() {
		return this.endNo;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return dspoCd
	 */
	public String getDspoCd() {
		return this.dspoCd;
	}
	
	/**
	 * Column Info
	 * @return tabNo
	 */
	public String getTabNo() {
		return this.tabNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param startNo
	 */
	public void setStartNo(String startNo) {
		this.startNo = startNo;
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
	 * @param endNo
	 */
	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param dspoCd
	 */
	public void setDspoCd(String dspoCd) {
		this.dspoCd = dspoCd;
	}
	
	/**
	 * Column Info
	 * @param tabNo
	 */
	public void setTabNo(String tabNo) {
		this.tabNo = tabNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setStartNo(JSPUtil.getParameter(request, "start_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEndNo(JSPUtil.getParameter(request, "end_no", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setDspoCd(JSPUtil.getParameter(request, "dspo_cd", ""));
		setTabNo(JSPUtil.getParameter(request, "tab_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBlCondVO[]
	 */
	public UsaBlCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBlCondVO[]
	 */
	public UsaBlCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBlCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] startNo = (JSPUtil.getParameter(request, prefix	+ "start_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] endNo = (JSPUtil.getParameter(request, prefix	+ "end_no", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] dspoCd = (JSPUtil.getParameter(request, prefix	+ "dspo_cd", length));
			String[] tabNo = (JSPUtil.getParameter(request, prefix	+ "tab_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaBlCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (startNo[i] != null)
					model.setStartNo(startNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (endNo[i] != null)
					model.setEndNo(endNo[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (dspoCd[i] != null)
					model.setDspoCd(dspoCd[i]);
				if (tabNo[i] != null)
					model.setTabNo(tabNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBlCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBlCondVO[]
	 */
	public UsaBlCondVO[] getUsaBlCondVOs(){
		UsaBlCondVO[] vos = (UsaBlCondVO[])models.toArray(new UsaBlCondVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startNo = this.startNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endNo = this.endNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspoCd = this.dspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabNo = this.tabNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
