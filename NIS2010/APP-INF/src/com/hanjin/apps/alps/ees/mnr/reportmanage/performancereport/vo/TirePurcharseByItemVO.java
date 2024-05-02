/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TirePurcharseByItemVO.java
*@FileTitle : TirePurcharseByItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.05 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TirePurcharseByItemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TirePurcharseByItemVO> models = new ArrayList<TirePurcharseByItemVO>();
	
	/* Column Info */
	private String brandNm = null;
	/* Column Info */
	private String type = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String supCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String cd01 = null;
	/* Column Info */
	private String cd02 = null;
	/* Column Info */
	private String cd03 = null;
	/* Column Info */
	private String cd04 = null;
	/* Column Info */
	private String cd10 = null;
	/* Column Info */
	private String cd05 = null;
	/* Column Info */
	private String cd06 = null;
	/* Column Info */
	private String cd07 = null;
	/* Column Info */
	private String cd08 = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String cd09 = null;
	/* Column Info */
	private String ofc = null;
	/* Column Info */
	private String supNm = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TirePurcharseByItemVO() {}

	public TirePurcharseByItemVO(String ibflag, String pagerows, String title, String rhq, String ofc, String supCd, String supNm, String brandNm, String cur, String type, String cd01, String cd02, String cd03, String cd04, String cd05, String cd06, String cd07, String cd08, String cd09, String cd10) {
		this.brandNm = brandNm;
		this.type = type;
		this.pagerows = pagerows;
		this.supCd = supCd;
		this.ibflag = ibflag;
		this.title = title;
		this.cd01 = cd01;
		this.cd02 = cd02;
		this.cd03 = cd03;
		this.cd04 = cd04;
		this.cd10 = cd10;
		this.cd05 = cd05;
		this.cd06 = cd06;
		this.cd07 = cd07;
		this.cd08 = cd08;
		this.cur = cur;
		this.cd09 = cd09;
		this.ofc = ofc;
		this.supNm = supNm;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("brand_nm", getBrandNm());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sup_cd", getSupCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("cd01", getCd01());
		this.hashColumns.put("cd02", getCd02());
		this.hashColumns.put("cd03", getCd03());
		this.hashColumns.put("cd04", getCd04());
		this.hashColumns.put("cd10", getCd10());
		this.hashColumns.put("cd05", getCd05());
		this.hashColumns.put("cd06", getCd06());
		this.hashColumns.put("cd07", getCd07());
		this.hashColumns.put("cd08", getCd08());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("cd09", getCd09());
		this.hashColumns.put("ofc", getOfc());
		this.hashColumns.put("sup_nm", getSupNm());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("brand_nm", "brandNm");
		this.hashFields.put("type", "type");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sup_cd", "supCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("title", "title");
		this.hashFields.put("cd01", "cd01");
		this.hashFields.put("cd02", "cd02");
		this.hashFields.put("cd03", "cd03");
		this.hashFields.put("cd04", "cd04");
		this.hashFields.put("cd10", "cd10");
		this.hashFields.put("cd05", "cd05");
		this.hashFields.put("cd06", "cd06");
		this.hashFields.put("cd07", "cd07");
		this.hashFields.put("cd08", "cd08");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("cd09", "cd09");
		this.hashFields.put("ofc", "ofc");
		this.hashFields.put("sup_nm", "supNm");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return brandNm
	 */
	public String getBrandNm() {
		return this.brandNm;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
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
	 * @return supCd
	 */
	public String getSupCd() {
		return this.supCd;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return cd01
	 */
	public String getCd01() {
		return this.cd01;
	}
	
	/**
	 * Column Info
	 * @return cd02
	 */
	public String getCd02() {
		return this.cd02;
	}
	
	/**
	 * Column Info
	 * @return cd03
	 */
	public String getCd03() {
		return this.cd03;
	}
	
	/**
	 * Column Info
	 * @return cd04
	 */
	public String getCd04() {
		return this.cd04;
	}
	
	/**
	 * Column Info
	 * @return cd10
	 */
	public String getCd10() {
		return this.cd10;
	}
	
	/**
	 * Column Info
	 * @return cd05
	 */
	public String getCd05() {
		return this.cd05;
	}
	
	/**
	 * Column Info
	 * @return cd06
	 */
	public String getCd06() {
		return this.cd06;
	}
	
	/**
	 * Column Info
	 * @return cd07
	 */
	public String getCd07() {
		return this.cd07;
	}
	
	/**
	 * Column Info
	 * @return cd08
	 */
	public String getCd08() {
		return this.cd08;
	}
	
	/**
	 * Column Info
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}
	
	/**
	 * Column Info
	 * @return cd09
	 */
	public String getCd09() {
		return this.cd09;
	}
	
	/**
	 * Column Info
	 * @return ofc
	 */
	public String getOfc() {
		return this.ofc;
	}
	
	/**
	 * Column Info
	 * @return supNm
	 */
	public String getSupNm() {
		return this.supNm;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param brandNm
	 */
	public void setBrandNm(String brandNm) {
		this.brandNm = brandNm;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @param supCd
	 */
	public void setSupCd(String supCd) {
		this.supCd = supCd;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param cd01
	 */
	public void setCd01(String cd01) {
		this.cd01 = cd01;
	}
	
	/**
	 * Column Info
	 * @param cd02
	 */
	public void setCd02(String cd02) {
		this.cd02 = cd02;
	}
	
	/**
	 * Column Info
	 * @param cd03
	 */
	public void setCd03(String cd03) {
		this.cd03 = cd03;
	}
	
	/**
	 * Column Info
	 * @param cd04
	 */
	public void setCd04(String cd04) {
		this.cd04 = cd04;
	}
	
	/**
	 * Column Info
	 * @param cd10
	 */
	public void setCd10(String cd10) {
		this.cd10 = cd10;
	}
	
	/**
	 * Column Info
	 * @param cd05
	 */
	public void setCd05(String cd05) {
		this.cd05 = cd05;
	}
	
	/**
	 * Column Info
	 * @param cd06
	 */
	public void setCd06(String cd06) {
		this.cd06 = cd06;
	}
	
	/**
	 * Column Info
	 * @param cd07
	 */
	public void setCd07(String cd07) {
		this.cd07 = cd07;
	}
	
	/**
	 * Column Info
	 * @param cd08
	 */
	public void setCd08(String cd08) {
		this.cd08 = cd08;
	}
	
	/**
	 * Column Info
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}
	
	/**
	 * Column Info
	 * @param cd09
	 */
	public void setCd09(String cd09) {
		this.cd09 = cd09;
	}
	
	/**
	 * Column Info
	 * @param ofc
	 */
	public void setOfc(String ofc) {
		this.ofc = ofc;
	}
	
	/**
	 * Column Info
	 * @param supNm
	 */
	public void setSupNm(String supNm) {
		this.supNm = supNm;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBrandNm(JSPUtil.getParameter(request, "brand_nm", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSupCd(JSPUtil.getParameter(request, "sup_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setCd01(JSPUtil.getParameter(request, "cd01", ""));
		setCd02(JSPUtil.getParameter(request, "cd02", ""));
		setCd03(JSPUtil.getParameter(request, "cd03", ""));
		setCd04(JSPUtil.getParameter(request, "cd04", ""));
		setCd10(JSPUtil.getParameter(request, "cd10", ""));
		setCd05(JSPUtil.getParameter(request, "cd05", ""));
		setCd06(JSPUtil.getParameter(request, "cd06", ""));
		setCd07(JSPUtil.getParameter(request, "cd07", ""));
		setCd08(JSPUtil.getParameter(request, "cd08", ""));
		setCur(JSPUtil.getParameter(request, "cur", ""));
		setCd09(JSPUtil.getParameter(request, "cd09", ""));
		setOfc(JSPUtil.getParameter(request, "ofc", ""));
		setSupNm(JSPUtil.getParameter(request, "sup_nm", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TirePurcharseByItemVO[]
	 */
	public TirePurcharseByItemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TirePurcharseByItemVO[]
	 */
	public TirePurcharseByItemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TirePurcharseByItemVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] brandNm = (JSPUtil.getParameter(request, prefix	+ "brand_nm", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] supCd = (JSPUtil.getParameter(request, prefix	+ "sup_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] cd01 = (JSPUtil.getParameter(request, prefix	+ "cd01", length));
			String[] cd02 = (JSPUtil.getParameter(request, prefix	+ "cd02", length));
			String[] cd03 = (JSPUtil.getParameter(request, prefix	+ "cd03", length));
			String[] cd04 = (JSPUtil.getParameter(request, prefix	+ "cd04", length));
			String[] cd10 = (JSPUtil.getParameter(request, prefix	+ "cd10", length));
			String[] cd05 = (JSPUtil.getParameter(request, prefix	+ "cd05", length));
			String[] cd06 = (JSPUtil.getParameter(request, prefix	+ "cd06", length));
			String[] cd07 = (JSPUtil.getParameter(request, prefix	+ "cd07", length));
			String[] cd08 = (JSPUtil.getParameter(request, prefix	+ "cd08", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] cd09 = (JSPUtil.getParameter(request, prefix	+ "cd09", length));
			String[] ofc = (JSPUtil.getParameter(request, prefix	+ "ofc", length));
			String[] supNm = (JSPUtil.getParameter(request, prefix	+ "sup_nm", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new TirePurcharseByItemVO();
				if (brandNm[i] != null)
					model.setBrandNm(brandNm[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (supCd[i] != null)
					model.setSupCd(supCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (cd01[i] != null)
					model.setCd01(cd01[i]);
				if (cd02[i] != null)
					model.setCd02(cd02[i]);
				if (cd03[i] != null)
					model.setCd03(cd03[i]);
				if (cd04[i] != null)
					model.setCd04(cd04[i]);
				if (cd10[i] != null)
					model.setCd10(cd10[i]);
				if (cd05[i] != null)
					model.setCd05(cd05[i]);
				if (cd06[i] != null)
					model.setCd06(cd06[i]);
				if (cd07[i] != null)
					model.setCd07(cd07[i]);
				if (cd08[i] != null)
					model.setCd08(cd08[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (cd09[i] != null)
					model.setCd09(cd09[i]);
				if (ofc[i] != null)
					model.setOfc(ofc[i]);
				if (supNm[i] != null)
					model.setSupNm(supNm[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTirePurcharseByItemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TirePurcharseByItemVO[]
	 */
	public TirePurcharseByItemVO[] getTirePurcharseByItemVOs(){
		TirePurcharseByItemVO[] vos = (TirePurcharseByItemVO[])models.toArray(new TirePurcharseByItemVO[models.size()]);
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
		this.brandNm = this.brandNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supCd = this.supCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd01 = this.cd01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd02 = this.cd02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd03 = this.cd03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd04 = this.cd04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd10 = this.cd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd05 = this.cd05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd06 = this.cd06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd07 = this.cd07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd08 = this.cd08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd09 = this.cd09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofc = this.ofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supNm = this.supNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
