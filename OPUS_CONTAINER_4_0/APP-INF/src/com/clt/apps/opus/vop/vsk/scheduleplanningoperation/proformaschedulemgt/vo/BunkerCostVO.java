/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BunkerCostVO.java
*@FileTitle : BunkerCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.20 서창열 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

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
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BunkerCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BunkerCostVO> models = new ArrayList<BunkerCostVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bunkerCoat2 = null;
	/* Column Info */
	private String bunkerCoat3 = null;
	/* Column Info */
	private String bunkerCoat1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlAvg = null;
	/* Column Info */
	private String vslCsl1 = null;
	/* Column Info */
	private String vslCsl2 = null;
	/* Column Info */
	private String vslCsl3 = null;
	/* Column Info */
	private String leftHeader = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BunkerCostVO() {}

	public BunkerCostVO(String ibflag, String pagerows, String bunkerCoat1, String bunkerCoat2, String bunkerCoat3, String ttlAvg, String vslCsl1, String vslCsl2, String vslCsl3, String leftHeader) {
		this.ibflag = ibflag;
		this.bunkerCoat2 = bunkerCoat2;
		this.bunkerCoat3 = bunkerCoat3;
		this.bunkerCoat1 = bunkerCoat1;
		this.pagerows = pagerows;
		this.ttlAvg = ttlAvg;
		this.vslCsl1 = vslCsl1;
		this.vslCsl2 = vslCsl2;
		this.vslCsl3 = vslCsl3;
		this.leftHeader = leftHeader;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bunker_coat2", getBunkerCoat2());
		this.hashColumns.put("bunker_coat3", getBunkerCoat3());
		this.hashColumns.put("bunker_coat1", getBunkerCoat1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_avg", getTtlAvg());
		this.hashColumns.put("vsl_csl1", getVslCsl1());
		this.hashColumns.put("vsl_csl2", getVslCsl2());
		this.hashColumns.put("vsl_csl3", getVslCsl3());
		this.hashColumns.put("left_header", getLeftHeader());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bunker_coat2", "bunkerCoat2");
		this.hashFields.put("bunker_coat3", "bunkerCoat3");
		this.hashFields.put("bunker_coat1", "bunkerCoat1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_avg", "ttlAvg");
		this.hashFields.put("vsl_csl1", "vslCsl1");
		this.hashFields.put("vsl_csl2", "vslCsl2");
		this.hashFields.put("vsl_csl3", "vslCsl3");
		this.hashFields.put("left_header", "leftHeader");
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
	 * @return bunkerCoat2
	 */
	public String getBunkerCoat2() {
		return this.bunkerCoat2;
	}
	
	/**
	 * Column Info
	 * @return bunkerCoat3
	 */
	public String getBunkerCoat3() {
		return this.bunkerCoat3;
	}
	
	/**
	 * Column Info
	 * @return bunkerCoat1
	 */
	public String getBunkerCoat1() {
		return this.bunkerCoat1;
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
	 * @return n1stVslClssCd
	 */
	public String getTtlAvg() {
		return this.ttlAvg;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getVslCsl1() {
		return this.vslCsl1;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getVslCsl2() {
		return this.vslCsl2;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getVslCsl3() {
		return this.vslCsl3;
	}
	
	/**
	 * Column Info
	 * @return leftHeader
	 */
	public String getLeftHeader() {
		return this.leftHeader;
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
	 * @param bunkerCoat2
	 */
	public void setBunkerCoat2(String bunkerCoat2) {
		this.bunkerCoat2 = bunkerCoat2;
	}
	
	/**
	 * Column Info
	 * @param bunkerCoat3
	 */
	public void setBunkerCoat3(String bunkerCoat3) {
		this.bunkerCoat3 = bunkerCoat3;
	}
	
	/**
	 * Column Info
	 * @param bunkerCoat1
	 */
	public void setBunkerCoat1(String bunkerCoat1) {
		this.bunkerCoat1 = bunkerCoat1;
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
	 * @param n1stVslClssCd
	 */
	public void setTtlAvg(String ttlAvg) {
		this.ttlAvg = ttlAvg;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setVslCsl1(String vslCsl1) {
		this.vslCsl1 = vslCsl1;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setVslCsl2(String vslCsl2) {
		this.vslCsl2 = vslCsl2;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setVslCsl3(String vslCsl3) {
		this.vslCsl3 = vslCsl3;
	}
	
	/**
	 * Column Info
	 * @param leftHeader
	 */
	public void setLeftHeader(String leftHeader) {
		this.leftHeader = leftHeader;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBunkerCoat2(JSPUtil.getParameter(request, "bunker_coat2", ""));
		setBunkerCoat3(JSPUtil.getParameter(request, "bunker_coat3", ""));
		setBunkerCoat1(JSPUtil.getParameter(request, "bunker_coat1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTtlAvg(JSPUtil.getParameter(request, "ttl_avg", ""));
		setVslCsl1(JSPUtil.getParameter(request, "vsl_csl1", ""));
		setVslCsl2(JSPUtil.getParameter(request, "vsl_csl2", ""));
		setVslCsl3(JSPUtil.getParameter(request, "vsl_csl3", ""));
		setLeftHeader(JSPUtil.getParameter(request, "left_header", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BunkerCostVO[]
	 */
	public BunkerCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BunkerCostVO[]
	 */
	public BunkerCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BunkerCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bunkerCoat2 = (JSPUtil.getParameter(request, prefix	+ "bunker_coat2", length));
			String[] bunkerCoat3 = (JSPUtil.getParameter(request, prefix	+ "bunker_coat3", length));
			String[] bunkerCoat1 = (JSPUtil.getParameter(request, prefix	+ "bunker_coat1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlAvg = (JSPUtil.getParameter(request, prefix	+ "ttl_avg", length));
			String[] vslCsl1 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl1", length));
			String[] vslCsl2 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl2", length));
			String[] vslCsl3 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl3", length));
			String[] leftHeader = (JSPUtil.getParameter(request, prefix	+ "left_header", length));
			
			for (int i = 0; i < length; i++) {
				model = new BunkerCostVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bunkerCoat2[i] != null)
					model.setBunkerCoat2(bunkerCoat2[i]);
				if (bunkerCoat3[i] != null)
					model.setBunkerCoat3(bunkerCoat3[i]);
				if (bunkerCoat1[i] != null)
					model.setBunkerCoat1(bunkerCoat1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlAvg[i] != null)
					model.setTtlAvg(ttlAvg[i]);
				if (vslCsl1[i] != null)
					model.setVslCsl1(vslCsl1[i]);
				if (vslCsl2[i] != null)
					model.setVslCsl2(vslCsl2[i]);
				if (vslCsl3[i] != null)
					model.setVslCsl3(vslCsl3[i]);
				if (leftHeader[i] != null)
					model.setLeftHeader(leftHeader[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBunkerCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BunkerCostVO[]
	 */
	public BunkerCostVO[] getBunkerCostVOs(){
		BunkerCostVO[] vos = (BunkerCostVO[])models.toArray(new BunkerCostVO[models.size()]);
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
		this.bunkerCoat2 = this.bunkerCoat2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerCoat3 = this.bunkerCoat3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerCoat1 = this.bunkerCoat1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAvg  = this.ttlAvg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl1  = this.vslCsl1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl2  = this.vslCsl2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl3  = this.vslCsl3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leftHeader  = this.leftHeader.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
