/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVVDVO.java
*@FileTitle : SearchVVDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.08 장석현 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVVDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVVDVO> models = new ArrayList<SearchVVDVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslOprTpCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslOprTpNm = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obCssmVoyNo = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVVDVO() {}

	public SearchVVDVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vslEngNm, String vslSlanCd, String vslSlanNm, String vslOprTpCd, String vslOprTpNm, String obCssmVoyNo) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.vslSlanNm = vslSlanNm;
		this.vslEngNm = vslEngNm;
		this.vslOprTpCd = vslOprTpCd;
		this.skdVoyNo = skdVoyNo;
		this.vslOprTpNm = vslOprTpNm;
		this.vslSlanCd = vslSlanCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.obCssmVoyNo = obCssmVoyNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_opr_tp_cd", getVslOprTpCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_opr_tp_nm", getVslOprTpNm());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_opr_tp_cd", "vslOprTpCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_opr_tp_nm", "vslOprTpNm");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslOprTpCd
	 */
	public String getVslOprTpCd() {
		return this.vslOprTpCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslOprTpNm
	 */
	public String getVslOprTpNm() {
		return this.vslOprTpNm;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return obCssmVoyNo
	 */
	public String getObCssmVoyNo() {
		return this.obCssmVoyNo;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslOprTpCd
	 */
	public void setVslOprTpCd(String vslOprTpCd) {
		this.vslOprTpCd = vslOprTpCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslOprTpNm
	 */
	public void setVslOprTpNm(String vslOprTpNm) {
		this.vslOprTpNm = vslOprTpNm;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param obCssmVoyNo
	 */
	public void setObCssmVoyNo(String obCssmVoyNo) {
		this.obCssmVoyNo = obCssmVoyNo;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslOprTpCd(JSPUtil.getParameter(request, "vsl_opr_tp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslOprTpNm(JSPUtil.getParameter(request, "vsl_opr_tp_nm", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObCssmVoyNo(JSPUtil.getParameter(request, "ob_cssm_voy_no", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVVDVO[]
	 */
	public SearchVVDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVVDVO[]
	 */
	public SearchVVDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVVDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslOprTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_opr_tp_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslOprTpNm = (JSPUtil.getParameter(request, prefix	+ "vsl_opr_tp_nm", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ob_cssm_voy_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVVDVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslOprTpCd[i] != null)
					model.setVslOprTpCd(vslOprTpCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslOprTpNm[i] != null)
					model.setVslOprTpNm(vslOprTpNm[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obCssmVoyNo[i] != null)
					model.setObCssmVoyNo(obCssmVoyNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVVDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVVDVO[]
	 */
	public SearchVVDVO[] getSearchVVDVOs(){
		SearchVVDVO[] vos = (SearchVVDVO[])models.toArray(new SearchVVDVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOprTpCd = this.vslOprTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOprTpNm = this.vslOprTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCssmVoyNo = this.obCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
