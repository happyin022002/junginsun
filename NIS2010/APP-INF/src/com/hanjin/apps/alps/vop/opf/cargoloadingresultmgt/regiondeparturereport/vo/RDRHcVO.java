/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRHcVO.java
*@FileTitle : RDRHcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.08.05 이선영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRHcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRHcVO> models = new ArrayList<RDRHcVO>();
	
	/* Column Info */
	private String hc40Qty = null;
	/* Column Info */
	private String ratioType = null;
	/* Column Info */
	private String ovRat45 = null;
	/* Column Info */
	private String hc40Rat = null;
	/* Column Info */
	private String add45 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String unRat45 = null;
	/* Column Info */
	private String add40 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String bsa45 = null;
	/* Column Info */
	private String add20 = null;
	/* Column Info */
	private String load20 = null;
	/* Column Info */
	private String hc20Rate = null;
	/* Column Info */
	private String load40 = null;
	/* Column Info */
	private String hc20Qty = null;
	/* Column Info */
	private String load45 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRHcVO() {}

	public RDRHcVO(String ibflag, String pagerows, String oprCd, String load20, String hc20Qty, String hc20Rate, String add20, String load40, String hc40Qty, String hc40Rat, String add40, String load45, String bsa45, String unRat45, String ovRat45, String add45, String ratioType) {
		this.hc40Qty = hc40Qty;
		this.ratioType = ratioType;
		this.ovRat45 = ovRat45;
		this.hc40Rat = hc40Rat;
		this.add45 = add45;
		this.pagerows = pagerows;
		this.unRat45 = unRat45;
		this.add40 = add40;
		this.ibflag = ibflag;
		this.oprCd = oprCd;
		this.bsa45 = bsa45;
		this.add20 = add20;
		this.load20 = load20;
		this.hc20Rate = hc20Rate;
		this.load40 = load40;
		this.hc20Qty = hc20Qty;
		this.load45 = load45;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hc40_qty", getHc40Qty());
		this.hashColumns.put("ratio_type", getRatioType());
		this.hashColumns.put("ov_rat_45", getOvRat45());
		this.hashColumns.put("hc40_rat", getHc40Rat());
		this.hashColumns.put("add_45", getAdd45());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("un_rat_45", getUnRat45());
		this.hashColumns.put("add_40", getAdd40());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("bsa_45", getBsa45());
		this.hashColumns.put("add_20", getAdd20());
		this.hashColumns.put("load_20", getLoad20());
		this.hashColumns.put("hc20_rate", getHc20Rate());
		this.hashColumns.put("load_40", getLoad40());
		this.hashColumns.put("hc20_qty", getHc20Qty());
		this.hashColumns.put("load_45", getLoad45());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hc40_qty", "hc40Qty");
		this.hashFields.put("ratio_type", "ratioType");
		this.hashFields.put("ov_rat_45", "ovRat45");
		this.hashFields.put("hc40_rat", "hc40Rat");
		this.hashFields.put("add_45", "add45");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("un_rat_45", "unRat45");
		this.hashFields.put("add_40", "add40");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("bsa_45", "bsa45");
		this.hashFields.put("add_20", "add20");
		this.hashFields.put("load_20", "load20");
		this.hashFields.put("hc20_rate", "hc20Rate");
		this.hashFields.put("load_40", "load40");
		this.hashFields.put("hc20_qty", "hc20Qty");
		this.hashFields.put("load_45", "load45");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hc40Qty
	 */
	public String getHc40Qty() {
		return this.hc40Qty;
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
	 * @return ovRat45
	 */
	public String getOvRat45() {
		return this.ovRat45;
	}
	
	/**
	 * Column Info
	 * @return hc40Rat
	 */
	public String getHc40Rat() {
		return this.hc40Rat;
	}
	
	/**
	 * Column Info
	 * @return add45
	 */
	public String getAdd45() {
		return this.add45;
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
	 * @return unRat45
	 */
	public String getUnRat45() {
		return this.unRat45;
	}
	
	/**
	 * Column Info
	 * @return add40
	 */
	public String getAdd40() {
		return this.add40;
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
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return bsa45
	 */
	public String getBsa45() {
		return this.bsa45;
	}
	
	/**
	 * Column Info
	 * @return add20
	 */
	public String getAdd20() {
		return this.add20;
	}
	
	/**
	 * Column Info
	 * @return load20
	 */
	public String getLoad20() {
		return this.load20;
	}
	
	/**
	 * Column Info
	 * @return hc20Rate
	 */
	public String getHc20Rate() {
		return this.hc20Rate;
	}
	
	/**
	 * Column Info
	 * @return load40
	 */
	public String getLoad40() {
		return this.load40;
	}
	
	/**
	 * Column Info
	 * @return hc20Qty
	 */
	public String getHc20Qty() {
		return this.hc20Qty;
	}
	
	/**
	 * Column Info
	 * @return load45
	 */
	public String getLoad45() {
		return this.load45;
	}
	

	/**
	 * Column Info
	 * @param hc40Qty
	 */
	public void setHc40Qty(String hc40Qty) {
		this.hc40Qty = hc40Qty;
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
	 * @param ovRat45
	 */
	public void setOvRat45(String ovRat45) {
		this.ovRat45 = ovRat45;
	}
	
	/**
	 * Column Info
	 * @param hc40Rat
	 */
	public void setHc40Rat(String hc40Rat) {
		this.hc40Rat = hc40Rat;
	}
	
	/**
	 * Column Info
	 * @param add45
	 */
	public void setAdd45(String add45) {
		this.add45 = add45;
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
	 * @param unRat45
	 */
	public void setUnRat45(String unRat45) {
		this.unRat45 = unRat45;
	}
	
	/**
	 * Column Info
	 * @param add40
	 */
	public void setAdd40(String add40) {
		this.add40 = add40;
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
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param bsa45
	 */
	public void setBsa45(String bsa45) {
		this.bsa45 = bsa45;
	}
	
	/**
	 * Column Info
	 * @param add20
	 */
	public void setAdd20(String add20) {
		this.add20 = add20;
	}
	
	/**
	 * Column Info
	 * @param load20
	 */
	public void setLoad20(String load20) {
		this.load20 = load20;
	}
	
	/**
	 * Column Info
	 * @param hc20Rate
	 */
	public void setHc20Rate(String hc20Rate) {
		this.hc20Rate = hc20Rate;
	}
	
	/**
	 * Column Info
	 * @param load40
	 */
	public void setLoad40(String load40) {
		this.load40 = load40;
	}
	
	/**
	 * Column Info
	 * @param hc20Qty
	 */
	public void setHc20Qty(String hc20Qty) {
		this.hc20Qty = hc20Qty;
	}
	
	/**
	 * Column Info
	 * @param load45
	 */
	public void setLoad45(String load45) {
		this.load45 = load45;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHc40Qty(JSPUtil.getParameter(request, "hc40_qty", ""));
		setRatioType(JSPUtil.getParameter(request, "ratio_type", ""));
		setOvRat45(JSPUtil.getParameter(request, "ov_rat_45", ""));
		setHc40Rat(JSPUtil.getParameter(request, "hc40_rat", ""));
		setAdd45(JSPUtil.getParameter(request, "add_45", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUnRat45(JSPUtil.getParameter(request, "un_rat_45", ""));
		setAdd40(JSPUtil.getParameter(request, "add_40", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setBsa45(JSPUtil.getParameter(request, "bsa_45", ""));
		setAdd20(JSPUtil.getParameter(request, "add_20", ""));
		setLoad20(JSPUtil.getParameter(request, "load_20", ""));
		setHc20Rate(JSPUtil.getParameter(request, "hc20_rate", ""));
		setLoad40(JSPUtil.getParameter(request, "load_40", ""));
		setHc20Qty(JSPUtil.getParameter(request, "hc20_qty", ""));
		setLoad45(JSPUtil.getParameter(request, "load_45", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRHcVO[]
	 */
	public RDRHcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRHcVO[]
	 */
	public RDRHcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRHcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hc40Qty = (JSPUtil.getParameter(request, prefix	+ "hc40_qty", length));
			String[] ratioType = (JSPUtil.getParameter(request, prefix	+ "ratio_type", length));
			String[] ovRat45 = (JSPUtil.getParameter(request, prefix	+ "ov_rat_45", length));
			String[] hc40Rat = (JSPUtil.getParameter(request, prefix	+ "hc40_rat", length));
			String[] add45 = (JSPUtil.getParameter(request, prefix	+ "add_45", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] unRat45 = (JSPUtil.getParameter(request, prefix	+ "un_rat_45", length));
			String[] add40 = (JSPUtil.getParameter(request, prefix	+ "add_40", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] bsa45 = (JSPUtil.getParameter(request, prefix	+ "bsa_45", length));
			String[] add20 = (JSPUtil.getParameter(request, prefix	+ "add_20", length));
			String[] load20 = (JSPUtil.getParameter(request, prefix	+ "load_20", length));
			String[] hc20Rate = (JSPUtil.getParameter(request, prefix	+ "hc20_rate", length));
			String[] load40 = (JSPUtil.getParameter(request, prefix	+ "load_40", length));
			String[] hc20Qty = (JSPUtil.getParameter(request, prefix	+ "hc20_qty", length));
			String[] load45 = (JSPUtil.getParameter(request, prefix	+ "load_45", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRHcVO();
				if (hc40Qty[i] != null)
					model.setHc40Qty(hc40Qty[i]);
				if (ratioType[i] != null)
					model.setRatioType(ratioType[i]);
				if (ovRat45[i] != null)
					model.setOvRat45(ovRat45[i]);
				if (hc40Rat[i] != null)
					model.setHc40Rat(hc40Rat[i]);
				if (add45[i] != null)
					model.setAdd45(add45[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (unRat45[i] != null)
					model.setUnRat45(unRat45[i]);
				if (add40[i] != null)
					model.setAdd40(add40[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (bsa45[i] != null)
					model.setBsa45(bsa45[i]);
				if (add20[i] != null)
					model.setAdd20(add20[i]);
				if (load20[i] != null)
					model.setLoad20(load20[i]);
				if (hc20Rate[i] != null)
					model.setHc20Rate(hc20Rate[i]);
				if (load40[i] != null)
					model.setLoad40(load40[i]);
				if (hc20Qty[i] != null)
					model.setHc20Qty(hc20Qty[i]);
				if (load45[i] != null)
					model.setLoad45(load45[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRHcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRHcVO[]
	 */
	public RDRHcVO[] getRDRHcVOs(){
		RDRHcVO[] vos = (RDRHcVO[])models.toArray(new RDRHcVO[models.size()]);
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
		this.hc40Qty = this.hc40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratioType = this.ratioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovRat45 = this.ovRat45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc40Rat = this.hc40Rat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add45 = this.add45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unRat45 = this.unRat45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add40 = this.add40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa45 = this.bsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.add20 = this.add20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load20 = this.load20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc20Rate = this.hc20Rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load40 = this.load40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc20Qty = this.hc20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load45 = this.load45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
