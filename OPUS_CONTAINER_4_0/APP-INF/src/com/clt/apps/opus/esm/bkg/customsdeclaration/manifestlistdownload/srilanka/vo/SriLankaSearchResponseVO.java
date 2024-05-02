/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaSearchResponseVO.java
*@FileTitle : SriLankaSearchResponseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.19 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SriLankaSearchResponseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaSearchResponseVO> models = new ArrayList<SriLankaSearchResponseVO>();
	
	/* Column Info */
	private String declBlQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String srCmtDesc = null;
	/* Column Info */
	private String srStsDesc = null;
	/* Column Info */
	private String rjctDt = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String vslAuthNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SriLankaSearchResponseVO() {}

	public SriLankaSearchResponseVO(String ibflag, String pagerows, String srStsCd, String rgstDt, String rjctDt, String vslAuthNo, String srStsDesc, String srCmtDesc, String declBlQty) {
		this.declBlQty = declBlQty;
		this.ibflag = ibflag;
		this.srStsCd = srStsCd;
		this.srCmtDesc = srCmtDesc;
		this.srStsDesc = srStsDesc;
		this.rjctDt = rjctDt;
		this.rgstDt = rgstDt;
		this.vslAuthNo = vslAuthNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("decl_bl_qty", getDeclBlQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("sr_cmt_desc", getSrCmtDesc());
		this.hashColumns.put("sr_sts_desc", getSrStsDesc());
		this.hashColumns.put("rjct_dt", getRjctDt());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("vsl_auth_no", getVslAuthNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("decl_bl_qty", "declBlQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("sr_cmt_desc", "srCmtDesc");
		this.hashFields.put("sr_sts_desc", "srStsDesc");
		this.hashFields.put("rjct_dt", "rjctDt");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("vsl_auth_no", "vslAuthNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return declBlQty
	 */
	public String getDeclBlQty() {
		return this.declBlQty;
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
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return srCmtDesc
	 */
	public String getSrCmtDesc() {
		return this.srCmtDesc;
	}
	
	/**
	 * Column Info
	 * @return srStsDesc
	 */
	public String getSrStsDesc() {
		return this.srStsDesc;
	}
	
	/**
	 * Column Info
	 * @return rjctDt
	 */
	public String getRjctDt() {
		return this.rjctDt;
	}
	
	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}
	
	/**
	 * Column Info
	 * @return vslAuthNo
	 */
	public String getVslAuthNo() {
		return this.vslAuthNo;
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
	 * @param declBlQty
	 */
	public void setDeclBlQty(String declBlQty) {
		this.declBlQty = declBlQty;
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
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param srCmtDesc
	 */
	public void setSrCmtDesc(String srCmtDesc) {
		this.srCmtDesc = srCmtDesc;
	}
	
	/**
	 * Column Info
	 * @param srStsDesc
	 */
	public void setSrStsDesc(String srStsDesc) {
		this.srStsDesc = srStsDesc;
	}
	
	/**
	 * Column Info
	 * @param rjctDt
	 */
	public void setRjctDt(String rjctDt) {
		this.rjctDt = rjctDt;
	}
	
	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	/**
	 * Column Info
	 * @param vslAuthNo
	 */
	public void setVslAuthNo(String vslAuthNo) {
		this.vslAuthNo = vslAuthNo;
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
		setDeclBlQty(JSPUtil.getParameter(request, "decl_bl_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSrStsCd(JSPUtil.getParameter(request, "sr_sts_cd", ""));
		setSrCmtDesc(JSPUtil.getParameter(request, "sr_cmt_desc", ""));
		setSrStsDesc(JSPUtil.getParameter(request, "sr_sts_desc", ""));
		setRjctDt(JSPUtil.getParameter(request, "rjct_dt", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
		setVslAuthNo(JSPUtil.getParameter(request, "vsl_auth_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaSearchResponseVO[]
	 */
	public SriLankaSearchResponseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaSearchResponseVO[]
	 */
	public SriLankaSearchResponseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaSearchResponseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] declBlQty = (JSPUtil.getParameter(request, prefix	+ "decl_bl_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] srCmtDesc = (JSPUtil.getParameter(request, prefix	+ "sr_cmt_desc", length));
			String[] srStsDesc = (JSPUtil.getParameter(request, prefix	+ "sr_sts_desc", length));
			String[] rjctDt = (JSPUtil.getParameter(request, prefix	+ "rjct_dt", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] vslAuthNo = (JSPUtil.getParameter(request, prefix	+ "vsl_auth_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaSearchResponseVO();
				if (declBlQty[i] != null)
					model.setDeclBlQty(declBlQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (srCmtDesc[i] != null)
					model.setSrCmtDesc(srCmtDesc[i]);
				if (srStsDesc[i] != null)
					model.setSrStsDesc(srStsDesc[i]);
				if (rjctDt[i] != null)
					model.setRjctDt(rjctDt[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (vslAuthNo[i] != null)
					model.setVslAuthNo(vslAuthNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaSearchResponseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaSearchResponseVO[]
	 */
	public SriLankaSearchResponseVO[] getSriLankaSearchResponseVOs(){
		SriLankaSearchResponseVO[] vos = (SriLankaSearchResponseVO[])models.toArray(new SriLankaSearchResponseVO[models.size()]);
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
		this.declBlQty = this.declBlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCmtDesc = this.srCmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsDesc = this.srStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctDt = this.rjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAuthNo = this.vslAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
