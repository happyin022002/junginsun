/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SegrGrpVO.java
*@FileTitle : SegrGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SegrGrpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SegrGrpVO> models = new ArrayList<SegrGrpVO>();
	
	/* Column Info */
	private String imdgSegrGrpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgSegrGrpNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SegrGrpVO() {}

	public SegrGrpVO(String ibflag, String pagerows, String imdgSegrGrpNo, String imdgSegrGrpNm) {
		this.imdgSegrGrpNm = imdgSegrGrpNm;
		this.ibflag = ibflag;
		this.imdgSegrGrpNo = imdgSegrGrpNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imdg_segr_grp_nm", getImdgSegrGrpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_segr_grp_no", getImdgSegrGrpNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imdg_segr_grp_nm", "imdgSegrGrpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_segr_grp_no", "imdgSegrGrpNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imdgSegrGrpNm
	 */
	public String getImdgSegrGrpNm() {
		return this.imdgSegrGrpNm;
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
	 * @return imdgSegrGrpNo
	 */
	public String getImdgSegrGrpNo() {
		return this.imdgSegrGrpNo;
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
	 * @param imdgSegrGrpNm
	 */
	public void setImdgSegrGrpNm(String imdgSegrGrpNm) {
		this.imdgSegrGrpNm = imdgSegrGrpNm;
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
	 * @param imdgSegrGrpNo
	 */
	public void setImdgSegrGrpNo(String imdgSegrGrpNo) {
		this.imdgSegrGrpNo = imdgSegrGrpNo;
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
		setImdgSegrGrpNm(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SegrGrpVO[]
	 */
	public SegrGrpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SegrGrpVO[]
	 */
	public SegrGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SegrGrpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imdgSegrGrpNm = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_grp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgSegrGrpNo = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_grp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SegrGrpVO();
				if (imdgSegrGrpNm[i] != null)
					model.setImdgSegrGrpNm(imdgSegrGrpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgSegrGrpNo[i] != null)
					model.setImdgSegrGrpNo(imdgSegrGrpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSegrGrpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SegrGrpVO[]
	 */
	public SegrGrpVO[] getSegrGrpVOs(){
		SegrGrpVO[] vos = (SegrGrpVO[])models.toArray(new SegrGrpVO[models.size()]);
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
		this.imdgSegrGrpNm = this.imdgSegrGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrGrpNo = this.imdgSegrGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
