/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OrganizationVO.java
*@FileTitle : OrganizationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.03 문동규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OrganizationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OrganizationVO> models = new ArrayList<OrganizationVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String typeFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String level = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String haveChild = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OrganizationVO() {}

	public OrganizationVO(String ibflag, String pagerows, String level, String prntOfcCd, String ofcCd, String ofcEngNm, String typeFlg, String haveChild) {
		this.ofcCd = ofcCd;
		this.typeFlg = typeFlg;
		this.ibflag = ibflag;
		this.level = level;
		this.prntOfcCd = prntOfcCd;
		this.haveChild = haveChild;
		this.ofcEngNm = ofcEngNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("type_flg", getTypeFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("level", getLevel());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("have_child", getHaveChild());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("type_flg", "typeFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("level", "level");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("have_child", "haveChild");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return typeFlg
	 */
	public String getTypeFlg() {
		return this.typeFlg;
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
	 * @return level
	 */
	public String getLevel() {
		return this.level;
	}
	
	/**
	 * Column Info
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return haveChild
	 */
	public String getHaveChild() {
		return this.haveChild;
	}
	
	/**
	 * Column Info
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param typeFlg
	 */
	public void setTypeFlg(String typeFlg) {
		this.typeFlg = typeFlg;
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
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	/**
	 * Column Info
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param haveChild
	 */
	public void setHaveChild(String haveChild) {
		this.haveChild = haveChild;
	}
	
	/**
	 * Column Info
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
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
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setTypeFlg(JSPUtil.getParameter(request, "type_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLevel(JSPUtil.getParameter(request, "level", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, "prnt_ofc_cd", ""));
		setHaveChild(JSPUtil.getParameter(request, "have_child", ""));
		setOfcEngNm(JSPUtil.getParameter(request, "ofc_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OrganizationVO[]
	 */
	public OrganizationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OrganizationVO[]
	 */
	public OrganizationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OrganizationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] typeFlg = (JSPUtil.getParameter(request, prefix	+ "type_flg".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level".trim(), length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd".trim(), length));
			String[] haveChild = (JSPUtil.getParameter(request, prefix	+ "have_child".trim(), length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new OrganizationVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (typeFlg[i] != null)
					model.setTypeFlg(typeFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (haveChild[i] != null)
					model.setHaveChild(haveChild[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOrganizationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OrganizationVO[]
	 */
	public OrganizationVO[] getOrganizationVOs(){
		OrganizationVO[] vos = (OrganizationVO[])models.toArray(new OrganizationVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeFlg = this.typeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haveChild = this.haveChild .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
