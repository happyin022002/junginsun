/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSPCategoryManageConditionVO.java
*@FileTitle : SearchSPCategoryManageConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.30 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSPCategoryManageConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSPCategoryManageConditionVO> models = new ArrayList<SearchSPCategoryManageConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egCtyCd = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String chkUnique = null;
	/* Column Info */
	private String mapped = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSPCategoryManageConditionVO() {}

	public SearchSPCategoryManageConditionVO(String ibflag, String pagerows, String egCtyCd, String vndrSeq, String egRhqCd, String vndrAbbrNm, String mapped, String chkUnique) {
		this.ibflag = ibflag;
		this.egCtyCd = egCtyCd;
		this.egRhqCd = egRhqCd;
		this.vndrSeq = vndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.chkUnique = chkUnique;
		this.mapped = mapped;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_cty_cd", getEgCtyCd());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("chk_unique", getChkUnique());
		this.hashColumns.put("mapped", getMapped());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_cty_cd", "egCtyCd");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("chk_unique", "chkUnique");
		this.hashFields.put("mapped", "mapped");
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
	 * @return egCtyCd
	 */
	public String getEgCtyCd() {
		return this.egCtyCd;
	}
	
	/**
	 * Column Info
	 * @return egRhqCd
	 */
	public String getEgRhqCd() {
		return this.egRhqCd;
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
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return chkUnique
	 */
	public String getChkUnique() {
		return this.chkUnique;
	}
	
	/**
	 * Column Info
	 * @return mapped
	 */
	public String getMapped() {
		return this.mapped;
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
	 * @param egCtyCd
	 */
	public void setEgCtyCd(String egCtyCd) {
		this.egCtyCd = egCtyCd;
	}
	
	/**
	 * Column Info
	 * @param egRhqCd
	 */
	public void setEgRhqCd(String egRhqCd) {
		this.egRhqCd = egRhqCd;
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
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param chkUnique
	 */
	public void setChkUnique(String chkUnique) {
		this.chkUnique = chkUnique;
	}
	
	/**
	 * Column Info
	 * @param mapped
	 */
	public void setMapped(String mapped) {
		this.mapped = mapped;
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
		setEgCtyCd(JSPUtil.getParameter(request, "eg_cty_cd", ""));
		setEgRhqCd(JSPUtil.getParameter(request, "eg_rhq_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setChkUnique(JSPUtil.getParameter(request, "chk_unique", ""));
		setMapped(JSPUtil.getParameter(request, "mapped", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSPCategoryManageConditionVO[]
	 */
	public SearchSPCategoryManageConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSPCategoryManageConditionVO[]
	 */
	public SearchSPCategoryManageConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSPCategoryManageConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egCtyCd = (JSPUtil.getParameter(request, prefix	+ "eg_cty_cd", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] chkUnique = (JSPUtil.getParameter(request, prefix	+ "chk_unique", length));
			String[] mapped = (JSPUtil.getParameter(request, prefix	+ "mapped", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSPCategoryManageConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egCtyCd[i] != null)
					model.setEgCtyCd(egCtyCd[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (chkUnique[i] != null)
					model.setChkUnique(chkUnique[i]);
				if (mapped[i] != null)
					model.setMapped(mapped[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSPCategoryManageConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSPCategoryManageConditionVO[]
	 */
	public SearchSPCategoryManageConditionVO[] getSearchSPCategoryManageConditionVOs(){
		SearchSPCategoryManageConditionVO[] vos = (SearchSPCategoryManageConditionVO[])models.toArray(new SearchSPCategoryManageConditionVO[models.size()]);
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
		this.egCtyCd = this.egCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkUnique = this.chkUnique .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapped = this.mapped .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
