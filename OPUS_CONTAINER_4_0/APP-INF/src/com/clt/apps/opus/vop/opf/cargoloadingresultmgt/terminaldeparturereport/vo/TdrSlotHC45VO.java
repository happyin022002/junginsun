/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TdrSlotHC45VO.java
*@FileTitle : TdrSlotHC45VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.23 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TdrSlotHC45VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TdrSlotHC45VO> models = new ArrayList<TdrSlotHC45VO>();
	
	/* Column Info */
	private String hcBsa40 = null;
	/* Column Info */
	private String hcOr45 = null;
	/* Column Info */
	private String hcUr45 = null;
	/* Column Info */
	private String hcLd45 = null;
	/* Column Info */
	private String ratioType = null;
	/* Column Info */
	private String hcOr40 = null;
	/* Column Info */
	private String hcBsa45 = null;
	/* Column Info */
	private String hcBsa20 = null;
	/* Column Info */
	private String hcLd20 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hcAdd40 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hcAdd45 = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String hcLd40 = null;
	/* Column Info */
	private String hcAdd20 = null;
	/* Column Info */
	private String hcOr20 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TdrSlotHC45VO() {}

	public TdrSlotHC45VO(String ibflag, String pagerows, String oprCd, String hcLd20, String hcBsa20, String hcOr20, String hcAdd20, String hcLd40, String hcBsa40, String hcOr40, String hcAdd40, String hcLd45, String hcBsa45, String hcUr45, String hcOr45, String hcAdd45, String ratioType) {
		this.hcBsa40 = hcBsa40;
		this.hcOr45 = hcOr45;
		this.hcUr45 = hcUr45;
		this.hcLd45 = hcLd45;
		this.ratioType = ratioType;
		this.hcOr40 = hcOr40;
		this.hcBsa45 = hcBsa45;
		this.hcBsa20 = hcBsa20;
		this.hcLd20 = hcLd20;
		this.pagerows = pagerows;
		this.hcAdd40 = hcAdd40;
		this.ibflag = ibflag;
		this.hcAdd45 = hcAdd45;
		this.oprCd = oprCd;
		this.hcLd40 = hcLd40;
		this.hcAdd20 = hcAdd20;
		this.hcOr20 = hcOr20;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hc_bsa_40", getHcBsa40());
		this.hashColumns.put("hc_or_45", getHcOr45());
		this.hashColumns.put("hc_ur_45", getHcUr45());
		this.hashColumns.put("hc_ld_45", getHcLd45());
		this.hashColumns.put("ratio_type", getRatioType());
		this.hashColumns.put("hc_or_40", getHcOr40());
		this.hashColumns.put("hc_bsa_45", getHcBsa45());
		this.hashColumns.put("hc_bsa_20", getHcBsa20());
		this.hashColumns.put("hc_ld_20", getHcLd20());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hc_add_40", getHcAdd40());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hc_add_45", getHcAdd45());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("hc_ld_40", getHcLd40());
		this.hashColumns.put("hc_add_20", getHcAdd20());
		this.hashColumns.put("hc_or_20", getHcOr20());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hc_bsa_40", "hcBsa40");
		this.hashFields.put("hc_or_45", "hcOr45");
		this.hashFields.put("hc_ur_45", "hcUr45");
		this.hashFields.put("hc_ld_45", "hcLd45");
		this.hashFields.put("ratio_type", "ratioType");
		this.hashFields.put("hc_or_40", "hcOr40");
		this.hashFields.put("hc_bsa_45", "hcBsa45");
		this.hashFields.put("hc_bsa_20", "hcBsa20");
		this.hashFields.put("hc_ld_20", "hcLd20");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hc_add_40", "hcAdd40");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hc_add_45", "hcAdd45");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("hc_ld_40", "hcLd40");
		this.hashFields.put("hc_add_20", "hcAdd20");
		this.hashFields.put("hc_or_20", "hcOr20");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hcBsa40
	 */
	public String getHcBsa40() {
		return this.hcBsa40;
	}
	
	/**
	 * Column Info
	 * @return hcOr45
	 */
	public String getHcOr45() {
		return this.hcOr45;
	}
	
	/**
	 * Column Info
	 * @return hcUr45
	 */
	public String getHcUr45() {
		return this.hcUr45;
	}
	
	/**
	 * Column Info
	 * @return hcLd45
	 */
	public String getHcLd45() {
		return this.hcLd45;
	}
	
	/**
	 * Column Info
	 * @return ratioType
	 */
	public String getRatioType() {
		return this.ratioType;
	}
	
	/**
	 * Column Info
	 * @return hcOr40
	 */
	public String getHcOr40() {
		return this.hcOr40;
	}
	
	/**
	 * Column Info
	 * @return hcBsa45
	 */
	public String getHcBsa45() {
		return this.hcBsa45;
	}
	
	/**
	 * Column Info
	 * @return hcBsa20
	 */
	public String getHcBsa20() {
		return this.hcBsa20;
	}
	
	/**
	 * Column Info
	 * @return hcLd20
	 */
	public String getHcLd20() {
		return this.hcLd20;
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
	 * @return hcAdd40
	 */
	public String getHcAdd40() {
		return this.hcAdd40;
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
	 * @return hcAdd45
	 */
	public String getHcAdd45() {
		return this.hcAdd45;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return hcLd40
	 */
	public String getHcLd40() {
		return this.hcLd40;
	}
	
	/**
	 * Column Info
	 * @return hcAdd20
	 */
	public String getHcAdd20() {
		return this.hcAdd20;
	}
	
	/**
	 * Column Info
	 * @return hcOr20
	 */
	public String getHcOr20() {
		return this.hcOr20;
	}
	

	/**
	 * Column Info
	 * @param hcBsa40
	 */
	public void setHcBsa40(String hcBsa40) {
		this.hcBsa40 = hcBsa40;
	}
	
	/**
	 * Column Info
	 * @param hcOr45
	 */
	public void setHcOr45(String hcOr45) {
		this.hcOr45 = hcOr45;
	}
	
	/**
	 * Column Info
	 * @param hcUr45
	 */
	public void setHcUr45(String hcUr45) {
		this.hcUr45 = hcUr45;
	}
	
	/**
	 * Column Info
	 * @param hcLd45
	 */
	public void setHcLd45(String hcLd45) {
		this.hcLd45 = hcLd45;
	}
	
	/**
	 * Column Info
	 * @param ratioType
	 */
	public void setRatioType(String ratioType) {
		this.ratioType = ratioType;
	}
	
	/**
	 * Column Info
	 * @param hcOr40
	 */
	public void setHcOr40(String hcOr40) {
		this.hcOr40 = hcOr40;
	}
	
	/**
	 * Column Info
	 * @param hcBsa45
	 */
	public void setHcBsa45(String hcBsa45) {
		this.hcBsa45 = hcBsa45;
	}
	
	/**
	 * Column Info
	 * @param hcBsa20
	 */
	public void setHcBsa20(String hcBsa20) {
		this.hcBsa20 = hcBsa20;
	}
	
	/**
	 * Column Info
	 * @param hcLd20
	 */
	public void setHcLd20(String hcLd20) {
		this.hcLd20 = hcLd20;
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
	 * @param hcAdd40
	 */
	public void setHcAdd40(String hcAdd40) {
		this.hcAdd40 = hcAdd40;
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
	 * @param hcAdd45
	 */
	public void setHcAdd45(String hcAdd45) {
		this.hcAdd45 = hcAdd45;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param hcLd40
	 */
	public void setHcLd40(String hcLd40) {
		this.hcLd40 = hcLd40;
	}
	
	/**
	 * Column Info
	 * @param hcAdd20
	 */
	public void setHcAdd20(String hcAdd20) {
		this.hcAdd20 = hcAdd20;
	}
	
	/**
	 * Column Info
	 * @param hcOr20
	 */
	public void setHcOr20(String hcOr20) {
		this.hcOr20 = hcOr20;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHcBsa40(JSPUtil.getParameter(request, "hc_bsa_40", ""));
		setHcOr45(JSPUtil.getParameter(request, "hc_or_45", ""));
		setHcUr45(JSPUtil.getParameter(request, "hc_ur_45", ""));
		setHcLd45(JSPUtil.getParameter(request, "hc_ld_45", ""));
		setRatioType(JSPUtil.getParameter(request, "ratio_type", ""));
		setHcOr40(JSPUtil.getParameter(request, "hc_or_40", ""));
		setHcBsa45(JSPUtil.getParameter(request, "hc_bsa_45", ""));
		setHcBsa20(JSPUtil.getParameter(request, "hc_bsa_20", ""));
		setHcLd20(JSPUtil.getParameter(request, "hc_ld_20", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHcAdd40(JSPUtil.getParameter(request, "hc_add_40", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHcAdd45(JSPUtil.getParameter(request, "hc_add_45", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setHcLd40(JSPUtil.getParameter(request, "hc_ld_40", ""));
		setHcAdd20(JSPUtil.getParameter(request, "hc_add_20", ""));
		setHcOr20(JSPUtil.getParameter(request, "hc_or_20", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrSlotHC45VO[]
	 */
	public TdrSlotHC45VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrSlotHC45VO[]
	 */
	public TdrSlotHC45VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TdrSlotHC45VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hcBsa40 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_40", length));
			String[] hcOr45 = (JSPUtil.getParameter(request, prefix	+ "hc_or_45", length));
			String[] hcUr45 = (JSPUtil.getParameter(request, prefix	+ "hc_ur_45", length));
			String[] hcLd45 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_45", length));
			String[] ratioType = (JSPUtil.getParameter(request, prefix	+ "ratio_type", length));
			String[] hcOr40 = (JSPUtil.getParameter(request, prefix	+ "hc_or_40", length));
			String[] hcBsa45 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_45", length));
			String[] hcBsa20 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_20", length));
			String[] hcLd20 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_20", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hcAdd40 = (JSPUtil.getParameter(request, prefix	+ "hc_add_40", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hcAdd45 = (JSPUtil.getParameter(request, prefix	+ "hc_add_45", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] hcLd40 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_40", length));
			String[] hcAdd20 = (JSPUtil.getParameter(request, prefix	+ "hc_add_20", length));
			String[] hcOr20 = (JSPUtil.getParameter(request, prefix	+ "hc_or_20", length));
			
			for (int i = 0; i < length; i++) {
				model = new TdrSlotHC45VO();
				if (hcBsa40[i] != null)
					model.setHcBsa40(hcBsa40[i]);
				if (hcOr45[i] != null)
					model.setHcOr45(hcOr45[i]);
				if (hcUr45[i] != null)
					model.setHcUr45(hcUr45[i]);
				if (hcLd45[i] != null)
					model.setHcLd45(hcLd45[i]);
				if (ratioType[i] != null)
					model.setRatioType(ratioType[i]);
				if (hcOr40[i] != null)
					model.setHcOr40(hcOr40[i]);
				if (hcBsa45[i] != null)
					model.setHcBsa45(hcBsa45[i]);
				if (hcBsa20[i] != null)
					model.setHcBsa20(hcBsa20[i]);
				if (hcLd20[i] != null)
					model.setHcLd20(hcLd20[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hcAdd40[i] != null)
					model.setHcAdd40(hcAdd40[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hcAdd45[i] != null)
					model.setHcAdd45(hcAdd45[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (hcLd40[i] != null)
					model.setHcLd40(hcLd40[i]);
				if (hcAdd20[i] != null)
					model.setHcAdd20(hcAdd20[i]);
				if (hcOr20[i] != null)
					model.setHcOr20(hcOr20[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTdrSlotHC45VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TdrSlotHC45VO[]
	 */
	public TdrSlotHC45VO[] getTdrSlotHC45VOs(){
		TdrSlotHC45VO[] vos = (TdrSlotHC45VO[])models.toArray(new TdrSlotHC45VO[models.size()]);
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
		this.hcBsa40 = this.hcBsa40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcOr45 = this.hcOr45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcUr45 = this.hcUr45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd45 = this.hcLd45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratioType = this.ratioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcOr40 = this.hcOr40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa45 = this.hcBsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa20 = this.hcBsa20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd20 = this.hcLd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcAdd40 = this.hcAdd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcAdd45 = this.hcAdd45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd40 = this.hcLd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcAdd20 = this.hcAdd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcOr20 = this.hcOr20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
