/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSplRgstNoVO.java
*@FileTitle : SearchSplRgstNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.20 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSplRgstNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSplRgstNoVO> models = new ArrayList<SearchSplRgstNoVO>();
	
	/* Column Info */
	private String bzctNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loclLangAddr = null;
	/* Column Info */
	private String ceoNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String vndrLoclLangNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSplRgstNoVO() {}

	public SearchSplRgstNoVO(String ibflag, String pagerows, String vndrLoclLangNm, String ceoNm, String bzctNm, String bztpNm, String loclLangAddr, String vndrSeq) {
		this.bzctNm = bzctNm;
		this.ibflag = ibflag;
		this.loclLangAddr = loclLangAddr;
		this.ceoNm = ceoNm;
		this.vndrSeq = vndrSeq;
		this.bztpNm = bztpNm;
		this.vndrLoclLangNm = vndrLoclLangNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("locl_lang_addr", getLoclLangAddr());
		this.hashColumns.put("ceo_nm", getCeoNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("vndr_locl_lang_nm", getVndrLoclLangNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("locl_lang_addr", "loclLangAddr");
		this.hashFields.put("ceo_nm", "ceoNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("vndr_locl_lang_nm", "vndrLoclLangNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
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
	 * @return loclLangAddr
	 */
	public String getLoclLangAddr() {
		return this.loclLangAddr;
	}
	
	/**
	 * Column Info
	 * @return ceoNm
	 */
	public String getCeoNm() {
		return this.ceoNm;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return bztpNm
	 */
	public String getBztpNm() {
		return this.bztpNm;
	}
	
	/**
	 * Column Info
	 * @return vndrLoclLangNm
	 */
	public String getVndrLoclLangNm() {
		return this.vndrLoclLangNm;
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
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
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
	 * @param loclLangAddr
	 */
	public void setLoclLangAddr(String loclLangAddr) {
		this.loclLangAddr = loclLangAddr;
	}
	
	/**
	 * Column Info
	 * @param ceoNm
	 */
	public void setCeoNm(String ceoNm) {
		this.ceoNm = ceoNm;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param bztpNm
	 */
	public void setBztpNm(String bztpNm) {
		this.bztpNm = bztpNm;
	}
	
	/**
	 * Column Info
	 * @param vndrLoclLangNm
	 */
	public void setVndrLoclLangNm(String vndrLoclLangNm) {
		this.vndrLoclLangNm = vndrLoclLangNm;
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
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLoclLangAddr(JSPUtil.getParameter(request, "locl_lang_addr", ""));
		setCeoNm(JSPUtil.getParameter(request, "ceo_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setBztpNm(JSPUtil.getParameter(request, "bztp_nm", ""));
		setVndrLoclLangNm(JSPUtil.getParameter(request, "vndr_locl_lang_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSplRgstNoVO[]
	 */
	public SearchSplRgstNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSplRgstNoVO[]
	 */
	public SearchSplRgstNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSplRgstNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loclLangAddr = (JSPUtil.getParameter(request, prefix	+ "locl_lang_addr", length));
			String[] ceoNm = (JSPUtil.getParameter(request, prefix	+ "ceo_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] vndrLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "vndr_locl_lang_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSplRgstNoVO();
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loclLangAddr[i] != null)
					model.setLoclLangAddr(loclLangAddr[i]);
				if (ceoNm[i] != null)
					model.setCeoNm(ceoNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (vndrLoclLangNm[i] != null)
					model.setVndrLoclLangNm(vndrLoclLangNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSplRgstNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSplRgstNoVO[]
	 */
	public SearchSplRgstNoVO[] getSearchSplRgstNoVOs(){
		SearchSplRgstNoVO[] vos = (SearchSplRgstNoVO[])models.toArray(new SearchSplRgstNoVO[models.size()]);
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
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclLangAddr = this.loclLangAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceoNm = this.ceoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLoclLangNm = this.vndrLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
