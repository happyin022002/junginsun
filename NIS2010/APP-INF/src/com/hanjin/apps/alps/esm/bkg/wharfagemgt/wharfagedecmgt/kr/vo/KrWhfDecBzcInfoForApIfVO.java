/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfDecBzcInfoForApIfVO.java
*@FileTitle : KrWhfDecBzcInfoForApIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.23 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfDecBzcInfoForApIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecBzcInfoForApIfVO> models = new ArrayList<KrWhfDecBzcInfoForApIfVO>();
	
	/* Column Info */
	private String vndrTermNm = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String glDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dtrbAttrCtnt3 = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String attrCateNm = null;
	/* Column Info */
	private String dtrbCoaAcctCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecBzcInfoForApIfVO() {}

	public KrWhfDecBzcInfoForApIfVO(String ibflag, String pagerows, String glDt, String vndrNo, String vndrTermNm, String apCtrCd, String dtrbCoaAcctCd, String attrCateNm, String dtrbAttrCtnt3) {
		this.vndrTermNm = vndrTermNm;
		this.vndrNo = vndrNo;
		this.glDt = glDt;
		this.ibflag = ibflag;
		this.dtrbAttrCtnt3 = dtrbAttrCtnt3;
		this.apCtrCd = apCtrCd;
		this.attrCateNm = attrCateNm;
		this.dtrbCoaAcctCd = dtrbCoaAcctCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dtrb_attr_ctnt3", getDtrbAttrCtnt3());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());
		this.hashColumns.put("dtrb_coa_acct_cd", getDtrbCoaAcctCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dtrb_attr_ctnt3", "dtrbAttrCtnt3");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("dtrb_coa_acct_cd", "dtrbCoaAcctCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrTermNm
	 */
	public String getVndrTermNm() {
		return this.vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return dtrbAttrCtnt3
	 */
	public String getDtrbAttrCtnt3() {
		return this.dtrbAttrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
	}
	
	/**
	 * Column Info
	 * @return attrCateNm
	 */
	public String getAttrCateNm() {
		return this.attrCateNm;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaAcctCd
	 */
	public String getDtrbCoaAcctCd() {
		return this.dtrbCoaAcctCd;
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
	 * @param vndrTermNm
	 */
	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param dtrbAttrCtnt3
	 */
	public void setDtrbAttrCtnt3(String dtrbAttrCtnt3) {
		this.dtrbAttrCtnt3 = dtrbAttrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
	}
	
	/**
	 * Column Info
	 * @param attrCateNm
	 */
	public void setAttrCateNm(String attrCateNm) {
		this.attrCateNm = attrCateNm;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaAcctCd
	 */
	public void setDtrbCoaAcctCd(String dtrbCoaAcctCd) {
		this.dtrbCoaAcctCd = dtrbCoaAcctCd;
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
		setVndrTermNm(JSPUtil.getParameter(request, "vndr_term_nm", ""));
		setVndrNo(JSPUtil.getParameter(request, "vndr_no", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDtrbAttrCtnt3(JSPUtil.getParameter(request, "dtrb_attr_ctnt3", ""));
		setApCtrCd(JSPUtil.getParameter(request, "ap_ctr_cd", ""));
		setAttrCateNm(JSPUtil.getParameter(request, "attr_cate_nm", ""));
		setDtrbCoaAcctCd(JSPUtil.getParameter(request, "dtrb_coa_acct_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecBzcInfoForApIfVO[]
	 */
	public KrWhfDecBzcInfoForApIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecBzcInfoForApIfVO[]
	 */
	public KrWhfDecBzcInfoForApIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecBzcInfoForApIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrTermNm = (JSPUtil.getParameter(request, prefix	+ "vndr_term_nm", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dtrbAttrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "dtrb_attr_ctnt3", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] attrCateNm = (JSPUtil.getParameter(request, prefix	+ "attr_cate_nm", length));
			String[] dtrbCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_acct_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecBzcInfoForApIfVO();
				if (vndrTermNm[i] != null)
					model.setVndrTermNm(vndrTermNm[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dtrbAttrCtnt3[i] != null)
					model.setDtrbAttrCtnt3(dtrbAttrCtnt3[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (attrCateNm[i] != null)
					model.setAttrCateNm(attrCateNm[i]);
				if (dtrbCoaAcctCd[i] != null)
					model.setDtrbCoaAcctCd(dtrbCoaAcctCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecBzcInfoForApIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecBzcInfoForApIfVO[]
	 */
	public KrWhfDecBzcInfoForApIfVO[] getKrWhfDecBzcInfoForApIfVOs(){
		KrWhfDecBzcInfoForApIfVO[] vos = (KrWhfDecBzcInfoForApIfVO[])models.toArray(new KrWhfDecBzcInfoForApIfVO[models.size()]);
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
		this.vndrTermNm = this.vndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbAttrCtnt3 = this.dtrbAttrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm = this.attrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaAcctCd = this.dtrbCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
