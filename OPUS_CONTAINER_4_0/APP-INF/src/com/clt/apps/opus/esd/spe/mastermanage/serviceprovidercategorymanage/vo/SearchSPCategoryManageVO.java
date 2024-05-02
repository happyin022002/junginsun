/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSPCategoryManageVO.java
*@FileTitle : SearchSPCategoryManageVO
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

public class SearchSPCategoryManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSPCategoryManageVO> models = new ArrayList<SearchSPCategoryManageVO>();
	
	/* Column Info */
	private String svcCateRailFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String regGroup = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcCateEqFlg = null;
	/* Column Info */
	private String svcCateWtrFlg = null;
	/* Column Info */
	private String svcCateTrspFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String svcCateTmlFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String svcCateCyFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSPCategoryManageVO() {}

	public SearchSPCategoryManageVO(String ibflag, String pagerows, String vndrSeq, String vndrAbbrNm, String regGroup, String ofcCd, String svcCateTrspFlg, String svcCateRailFlg, String svcCateCyFlg, String svcCateTmlFlg, String svcCateWtrFlg, String svcCateEqFlg) {
		this.svcCateRailFlg = svcCateRailFlg;
		this.ofcCd = ofcCd;
		this.regGroup = regGroup;
		this.ibflag = ibflag;
		this.svcCateEqFlg = svcCateEqFlg;
		this.svcCateWtrFlg = svcCateWtrFlg;
		this.svcCateTrspFlg = svcCateTrspFlg;
		this.vndrSeq = vndrSeq;
		this.svcCateTmlFlg = svcCateTmlFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.svcCateCyFlg = svcCateCyFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_cate_rail_flg", getSvcCateRailFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("reg_group", getRegGroup());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_cate_eq_flg", getSvcCateEqFlg());
		this.hashColumns.put("svc_cate_wtr_flg", getSvcCateWtrFlg());
		this.hashColumns.put("svc_cate_trsp_flg", getSvcCateTrspFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("svc_cate_tml_flg", getSvcCateTmlFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("svc_cate_cy_flg", getSvcCateCyFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_cate_rail_flg", "svcCateRailFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("reg_group", "regGroup");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_cate_eq_flg", "svcCateEqFlg");
		this.hashFields.put("svc_cate_wtr_flg", "svcCateWtrFlg");
		this.hashFields.put("svc_cate_trsp_flg", "svcCateTrspFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("svc_cate_tml_flg", "svcCateTmlFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("svc_cate_cy_flg", "svcCateCyFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svcCateRailFlg
	 */
	public String getSvcCateRailFlg() {
		return this.svcCateRailFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return regGroup
	 */
	public String getRegGroup() {
		return this.regGroup;
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
	 * @return svcCateEqFlg
	 */
	public String getSvcCateEqFlg() {
		return this.svcCateEqFlg;
	}
	
	/**
	 * Column Info
	 * @return svcCateWtrFlg
	 */
	public String getSvcCateWtrFlg() {
		return this.svcCateWtrFlg;
	}
	
	/**
	 * Column Info
	 * @return svcCateTrspFlg
	 */
	public String getSvcCateTrspFlg() {
		return this.svcCateTrspFlg;
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
	 * @return svcCateTmlFlg
	 */
	public String getSvcCateTmlFlg() {
		return this.svcCateTmlFlg;
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
	 * @return svcCateCyFlg
	 */
	public String getSvcCateCyFlg() {
		return this.svcCateCyFlg;
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
	 * @param svcCateRailFlg
	 */
	public void setSvcCateRailFlg(String svcCateRailFlg) {
		this.svcCateRailFlg = svcCateRailFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param regGroup
	 */
	public void setRegGroup(String regGroup) {
		this.regGroup = regGroup;
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
	 * @param svcCateEqFlg
	 */
	public void setSvcCateEqFlg(String svcCateEqFlg) {
		this.svcCateEqFlg = svcCateEqFlg;
	}
	
	/**
	 * Column Info
	 * @param svcCateWtrFlg
	 */
	public void setSvcCateWtrFlg(String svcCateWtrFlg) {
		this.svcCateWtrFlg = svcCateWtrFlg;
	}
	
	/**
	 * Column Info
	 * @param svcCateTrspFlg
	 */
	public void setSvcCateTrspFlg(String svcCateTrspFlg) {
		this.svcCateTrspFlg = svcCateTrspFlg;
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
	 * @param svcCateTmlFlg
	 */
	public void setSvcCateTmlFlg(String svcCateTmlFlg) {
		this.svcCateTmlFlg = svcCateTmlFlg;
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
	 * @param svcCateCyFlg
	 */
	public void setSvcCateCyFlg(String svcCateCyFlg) {
		this.svcCateCyFlg = svcCateCyFlg;
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
		setSvcCateRailFlg(JSPUtil.getParameter(request, "svc_cate_rail_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRegGroup(JSPUtil.getParameter(request, "reg_group", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSvcCateEqFlg(JSPUtil.getParameter(request, "svc_cate_eq_flg", ""));
		setSvcCateWtrFlg(JSPUtil.getParameter(request, "svc_cate_wtr_flg", ""));
		setSvcCateTrspFlg(JSPUtil.getParameter(request, "svc_cate_trsp_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setSvcCateTmlFlg(JSPUtil.getParameter(request, "svc_cate_tml_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setSvcCateCyFlg(JSPUtil.getParameter(request, "svc_cate_cy_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSPCategoryManageVO[]
	 */
	public SearchSPCategoryManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSPCategoryManageVO[]
	 */
	public SearchSPCategoryManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSPCategoryManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcCateRailFlg = (JSPUtil.getParameter(request, prefix	+ "svc_cate_rail_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] regGroup = (JSPUtil.getParameter(request, prefix	+ "reg_group", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcCateEqFlg = (JSPUtil.getParameter(request, prefix	+ "svc_cate_eq_flg", length));
			String[] svcCateWtrFlg = (JSPUtil.getParameter(request, prefix	+ "svc_cate_wtr_flg", length));
			String[] svcCateTrspFlg = (JSPUtil.getParameter(request, prefix	+ "svc_cate_trsp_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] svcCateTmlFlg = (JSPUtil.getParameter(request, prefix	+ "svc_cate_tml_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] svcCateCyFlg = (JSPUtil.getParameter(request, prefix	+ "svc_cate_cy_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSPCategoryManageVO();
				if (svcCateRailFlg[i] != null)
					model.setSvcCateRailFlg(svcCateRailFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (regGroup[i] != null)
					model.setRegGroup(regGroup[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcCateEqFlg[i] != null)
					model.setSvcCateEqFlg(svcCateEqFlg[i]);
				if (svcCateWtrFlg[i] != null)
					model.setSvcCateWtrFlg(svcCateWtrFlg[i]);
				if (svcCateTrspFlg[i] != null)
					model.setSvcCateTrspFlg(svcCateTrspFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (svcCateTmlFlg[i] != null)
					model.setSvcCateTmlFlg(svcCateTmlFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (svcCateCyFlg[i] != null)
					model.setSvcCateCyFlg(svcCateCyFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSPCategoryManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSPCategoryManageVO[]
	 */
	public SearchSPCategoryManageVO[] getSearchSPCategoryManageVOs(){
		SearchSPCategoryManageVO[] vos = (SearchSPCategoryManageVO[])models.toArray(new SearchSPCategoryManageVO[models.size()]);
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
		this.svcCateRailFlg = this.svcCateRailFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regGroup = this.regGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateEqFlg = this.svcCateEqFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateWtrFlg = this.svcCateWtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateTrspFlg = this.svcCateTrspFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateTmlFlg = this.svcCateTmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateCyFlg = this.svcCateCyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
