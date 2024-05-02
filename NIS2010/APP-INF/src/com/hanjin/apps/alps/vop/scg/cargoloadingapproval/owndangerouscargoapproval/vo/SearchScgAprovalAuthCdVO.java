/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchScgAprovalAuthCdVO.java
*@FileTitle : searchScgAprovalAuthCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.10.16 이도형 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchScgAprovalAuthCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchScgAprovalAuthCdVO> models = new ArrayList<SearchScgAprovalAuthCdVO>();
	
	/* Column Info */
	private String cgoSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoAuthCd = null;
	/* Column Info */
	private String updFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchScgAprovalAuthCdVO() {}

	public SearchScgAprovalAuthCdVO(String ibflag, String pagerows, String bkgNo, String cgoSeq, String spclCgoAuthCd, String updFlg) {
		this.cgoSeq = cgoSeq;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.spclCgoAuthCd = spclCgoAuthCd;
		this.updFlg = updFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_seq", getCgoSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_auth_cd", getSpclCgoAuthCd());
		this.hashColumns.put("upd_flg", getUpdFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_seq", "cgoSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_auth_cd", "spclCgoAuthCd");
		this.hashFields.put("upd_flg", "updFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoSeq
	 */
	public String getCgoSeq() {
		return this.cgoSeq;
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
	 * @return spclCgoAuthCd
	 */
	public String getSpclCgoAuthCd() {
		return this.spclCgoAuthCd;
	}
	
	/**
	 * Column Info
	 * @return updFlg
	 */
	public String getUpdFlg() {
		return this.updFlg;
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
	 * @param cgoSeq
	 */
	public void setCgoSeq(String cgoSeq) {
		this.cgoSeq = cgoSeq;
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
	 * @param spclCgoAuthCd
	 */
	public void setSpclCgoAuthCd(String spclCgoAuthCd) {
		this.spclCgoAuthCd = spclCgoAuthCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthCd
	 */
	public void setUpdFlg(String updFlg) {
		this.updFlg = updFlg;
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
		setCgoSeq(JSPUtil.getParameter(request, "cgo_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSpclCgoAuthCd(JSPUtil.getParameter(request, "spcl_cgo_auth_cd", ""));
		setUpdFlg(JSPUtil.getParameter(request, "upd_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchScgAprovalAuthCdVO[]
	 */
	public SearchScgAprovalAuthCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchScgAprovalAuthCdVO[]
	 */
	public SearchScgAprovalAuthCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchScgAprovalAuthCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoSeq = (JSPUtil.getParameter(request, prefix	+ "cgo_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoAuthCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_cd", length));
			String[] updFlg = (JSPUtil.getParameter(request, prefix	+ "upd_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchScgAprovalAuthCdVO();
				if (cgoSeq[i] != null)
					model.setCgoSeq(cgoSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoAuthCd[i] != null)
					model.setSpclCgoAuthCd(spclCgoAuthCd[i]);
				if (updFlg[i] != null)
					model.setUpdFlg(updFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchScgAprovalAuthCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchScgAprovalAuthCdVO[]
	 */
	public SearchScgAprovalAuthCdVO[] getsearchScgAprovalAuthCdVOs(){
		SearchScgAprovalAuthCdVO[] vos = (SearchScgAprovalAuthCdVO[])models.toArray(new SearchScgAprovalAuthCdVO[models.size()]);
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
		this.cgoSeq = this.cgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthCd = this.spclCgoAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updFlg = this.updFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
