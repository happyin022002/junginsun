/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : XterInnerPackageVO.java
*@FileTitle : XterInnerPackageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterInnerPackageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterInnerPackageVO> models = new ArrayList<XterInnerPackageVO>();
	
	/* Column Info */
	private String mkSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlPckTpNm = null;
	/* Column Info */
	private String mkSubSeq = null;
	/* Column Info */
	private String ttlPckDesc = null;
	/* Column Info */
	private String ttlPckQty = null;
	/* Column Info */
	private String ttlPckLvl = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterInnerPackageVO() {}

	public XterInnerPackageVO(String ibflag, String pagerows, String mkSeq, String mkSubSeq, String ttlPckQty, String ttlPckTpNm, String ttlPckLvl, String ttlPckDesc) {
		this.mkSeq = mkSeq;
		this.ibflag = ibflag;
		this.ttlPckTpNm = ttlPckTpNm;
		this.mkSubSeq = mkSubSeq;
		this.ttlPckDesc = ttlPckDesc;
		this.ttlPckQty = ttlPckQty;
		this.ttlPckLvl = ttlPckLvl;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mk_seq", getMkSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_pck_tp_nm", getTtlPckTpNm());
		this.hashColumns.put("mk_sub_seq", getMkSubSeq());
		this.hashColumns.put("ttl_pck_desc", getTtlPckDesc());
		this.hashColumns.put("ttl_pck_qty", getTtlPckQty());
		this.hashColumns.put("ttl_pck_lvl", getTtlPckLvl());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mk_seq", "mkSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_pck_tp_nm", "ttlPckTpNm");
		this.hashFields.put("mk_sub_seq", "mkSubSeq");
		this.hashFields.put("ttl_pck_desc", "ttlPckDesc");
		this.hashFields.put("ttl_pck_qty", "ttlPckQty");
		this.hashFields.put("ttl_pck_lvl", "ttlPckLvl");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mkSeq
	 */
	public String getMkSeq() {
		return this.mkSeq;
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
	 * @return ttlPckTpNm
	 */
	public String getTtlPckTpNm() {
		return this.ttlPckTpNm;
	}
	
	/**
	 * Column Info
	 * @return mkSubSeq
	 */
	public String getMkSubSeq() {
		return this.mkSubSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlPckDesc
	 */
	public String getTtlPckDesc() {
		return this.ttlPckDesc;
	}
	
	/**
	 * Column Info
	 * @return ttlPckQty
	 */
	public String getTtlPckQty() {
		return this.ttlPckQty;
	}
	
	/**
	 * Column Info
	 * @return ttlPckLvl
	 */
	public String getTtlPckLvl() {
		return this.ttlPckLvl;
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
	 * @param mkSeq
	 */
	public void setMkSeq(String mkSeq) {
		this.mkSeq = mkSeq;
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
	 * @param ttlPckTpNm
	 */
	public void setTtlPckTpNm(String ttlPckTpNm) {
		this.ttlPckTpNm = ttlPckTpNm;
	}
	
	/**
	 * Column Info
	 * @param mkSubSeq
	 */
	public void setMkSubSeq(String mkSubSeq) {
		this.mkSubSeq = mkSubSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlPckDesc
	 */
	public void setTtlPckDesc(String ttlPckDesc) {
		this.ttlPckDesc = ttlPckDesc;
	}
	
	/**
	 * Column Info
	 * @param ttlPckQty
	 */
	public void setTtlPckQty(String ttlPckQty) {
		this.ttlPckQty = ttlPckQty;
	}
	
	/**
	 * Column Info
	 * @param ttlPckLvl
	 */
	public void setTtlPckLvl(String ttlPckLvl) {
		this.ttlPckLvl = ttlPckLvl;
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
		setMkSeq(JSPUtil.getParameter(request, prefix + "mk_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTtlPckTpNm(JSPUtil.getParameter(request, prefix + "ttl_pck_tp_nm", ""));
		setMkSubSeq(JSPUtil.getParameter(request, prefix + "mk_sub_seq", ""));
		setTtlPckDesc(JSPUtil.getParameter(request, prefix + "ttl_pck_desc", ""));
		setTtlPckQty(JSPUtil.getParameter(request, prefix + "ttl_pck_qty", ""));
		setTtlPckLvl(JSPUtil.getParameter(request, prefix + "ttl_pck_lvl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterInnerPackageVO[]
	 */
	public XterInnerPackageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterInnerPackageVO[]
	 */
	public XterInnerPackageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterInnerPackageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mkSeq = (JSPUtil.getParameter(request, prefix	+ "mk_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlPckTpNm = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_tp_nm", length));
			String[] mkSubSeq = (JSPUtil.getParameter(request, prefix	+ "mk_sub_seq", length));
			String[] ttlPckDesc = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_desc", length));
			String[] ttlPckQty = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_qty", length));
			String[] ttlPckLvl = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_lvl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterInnerPackageVO();
				if (mkSeq[i] != null)
					model.setMkSeq(mkSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlPckTpNm[i] != null)
					model.setTtlPckTpNm(ttlPckTpNm[i]);
				if (mkSubSeq[i] != null)
					model.setMkSubSeq(mkSubSeq[i]);
				if (ttlPckDesc[i] != null)
					model.setTtlPckDesc(ttlPckDesc[i]);
				if (ttlPckQty[i] != null)
					model.setTtlPckQty(ttlPckQty[i]);
				if (ttlPckLvl[i] != null)
					model.setTtlPckLvl(ttlPckLvl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterInnerPackageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterInnerPackageVO[]
	 */
	public XterInnerPackageVO[] getXterInnerPackageVOs(){
		XterInnerPackageVO[] vos = (XterInnerPackageVO[])models.toArray(new XterInnerPackageVO[models.size()]);
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
		this.mkSeq = this.mkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckTpNm = this.ttlPckTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkSubSeq = this.mkSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckDesc = this.ttlPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckQty = this.ttlPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckLvl = this.ttlPckLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
