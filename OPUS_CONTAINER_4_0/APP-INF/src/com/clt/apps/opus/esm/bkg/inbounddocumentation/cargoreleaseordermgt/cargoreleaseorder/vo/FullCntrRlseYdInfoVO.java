/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FullCntrRlseYdInfoVO.java
*@FileTitle : FullCntrRlseYdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
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

public class FullCntrRlseYdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullCntrRlseYdInfoVO> models = new ArrayList<FullCntrRlseYdInfoVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ydEml = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FullCntrRlseYdInfoVO() {}

	public FullCntrRlseYdInfoVO(String ibflag, String pagerows, String faxNo, String ydNm, String ydEml, String phnNo) {
		this.phnNo = phnNo;
		this.ibflag = ibflag;
		this.ydNm = ydNm;
		this.faxNo = faxNo;
		this.ydEml = ydEml;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("yd_eml", getYdEml());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("yd_eml", "ydEml");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
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
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return ydEml
	 */
	public String getYdEml() {
		return this.ydEml;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
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
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param ydEml
	 */
	public void setYdEml(String ydEml) {
		this.ydEml = ydEml;
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
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setYdEml(JSPUtil.getParameter(request, prefix + "yd_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FullCntrRlseYdInfoVO[]
	 */
	public FullCntrRlseYdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FullCntrRlseYdInfoVO[]
	 */
	public FullCntrRlseYdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FullCntrRlseYdInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ydEml = (JSPUtil.getParameter(request, prefix	+ "yd_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FullCntrRlseYdInfoVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ydEml[i] != null)
					model.setYdEml(ydEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFullCntrRlseYdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FullCntrRlseYdInfoVO[]
	 */
	public FullCntrRlseYdInfoVO[] getFullCntrRlseYdInfoVOs(){
		FullCntrRlseYdInfoVO[] vos = (FullCntrRlseYdInfoVO[])models.toArray(new FullCntrRlseYdInfoVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydEml = this.ydEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
