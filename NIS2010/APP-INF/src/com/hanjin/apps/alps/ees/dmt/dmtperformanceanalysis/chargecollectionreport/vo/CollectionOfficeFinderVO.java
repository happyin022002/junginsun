/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CollectionOfficeFinderVO.java
*@FileTitle : CollectionOfficeFinderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.13 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CollectionOfficeFinderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CollectionOfficeFinderVO> models = new ArrayList<CollectionOfficeFinderVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmtoffsub = null;
	/* Column Info */
	private String collectib = null;
	/* Column Info */
	private String yardlocat = null;
	/* Column Info */
	private String demdetoff = null;
	/* Column Info */
	private String yarddelyn = null;
	/* Column Info */
	private String yardnodee = null;
	/* Column Info */
	private String countrycd = null;
	/* Column Info */
	private String collectob = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CollectionOfficeFinderVO() {}

	public CollectionOfficeFinderVO(String ibflag, String pagerows, String demdetoff, String dmtoffsub, String collectib, String collectob, String countrycd, String yardlocat, String yardnodee, String yarddelyn) {
		this.ibflag = ibflag;
		this.dmtoffsub = dmtoffsub;
		this.collectib = collectib;
		this.yardlocat = yardlocat;
		this.demdetoff = demdetoff;
		this.yarddelyn = yarddelyn;
		this.yardnodee = yardnodee;
		this.countrycd = countrycd;
		this.collectob = collectob;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmtoffsub", getDmtoffsub());
		this.hashColumns.put("collectib", getCollectib());
		this.hashColumns.put("yardlocat", getYardlocat());
		this.hashColumns.put("demdetoff", getDemdetoff());
		this.hashColumns.put("yarddelyn", getYarddelyn());
		this.hashColumns.put("yardnodee", getYardnodee());
		this.hashColumns.put("countrycd", getCountrycd());
		this.hashColumns.put("collectob", getCollectob());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmtoffsub", "dmtoffsub");
		this.hashFields.put("collectib", "collectib");
		this.hashFields.put("yardlocat", "yardlocat");
		this.hashFields.put("demdetoff", "demdetoff");
		this.hashFields.put("yarddelyn", "yarddelyn");
		this.hashFields.put("yardnodee", "yardnodee");
		this.hashFields.put("countrycd", "countrycd");
		this.hashFields.put("collectob", "collectob");
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
	 * @return dmtoffsub
	 */
	public String getDmtoffsub() {
		return this.dmtoffsub;
	}
	
	/**
	 * Column Info
	 * @return collectib
	 */
	public String getCollectib() {
		return this.collectib;
	}
	
	/**
	 * Column Info
	 * @return yardlocat
	 */
	public String getYardlocat() {
		return this.yardlocat;
	}
	
	/**
	 * Column Info
	 * @return demdetoff
	 */
	public String getDemdetoff() {
		return this.demdetoff;
	}
	
	/**
	 * Column Info
	 * @return yarddelyn
	 */
	public String getYarddelyn() {
		return this.yarddelyn;
	}
	
	/**
	 * Column Info
	 * @return yardnodee
	 */
	public String getYardnodee() {
		return this.yardnodee;
	}
	
	/**
	 * Column Info
	 * @return countrycd
	 */
	public String getCountrycd() {
		return this.countrycd;
	}
	
	/**
	 * Column Info
	 * @return collectob
	 */
	public String getCollectob() {
		return this.collectob;
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
	 * @param dmtoffsub
	 */
	public void setDmtoffsub(String dmtoffsub) {
		this.dmtoffsub = dmtoffsub;
	}
	
	/**
	 * Column Info
	 * @param collectib
	 */
	public void setCollectib(String collectib) {
		this.collectib = collectib;
	}
	
	/**
	 * Column Info
	 * @param yardlocat
	 */
	public void setYardlocat(String yardlocat) {
		this.yardlocat = yardlocat;
	}
	
	/**
	 * Column Info
	 * @param demdetoff
	 */
	public void setDemdetoff(String demdetoff) {
		this.demdetoff = demdetoff;
	}
	
	/**
	 * Column Info
	 * @param yarddelyn
	 */
	public void setYarddelyn(String yarddelyn) {
		this.yarddelyn = yarddelyn;
	}
	
	/**
	 * Column Info
	 * @param yardnodee
	 */
	public void setYardnodee(String yardnodee) {
		this.yardnodee = yardnodee;
	}
	
	/**
	 * Column Info
	 * @param countrycd
	 */
	public void setCountrycd(String countrycd) {
		this.countrycd = countrycd;
	}
	
	/**
	 * Column Info
	 * @param collectob
	 */
	public void setCollectob(String collectob) {
		this.collectob = collectob;
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
		setDmtoffsub(JSPUtil.getParameter(request, "dmtoffsub", ""));
		setCollectib(JSPUtil.getParameter(request, "collectib", ""));
		setYardlocat(JSPUtil.getParameter(request, "yardlocat", ""));
		setDemdetoff(JSPUtil.getParameter(request, "demdetoff", ""));
		setYarddelyn(JSPUtil.getParameter(request, "yarddelyn", ""));
		setYardnodee(JSPUtil.getParameter(request, "yardnodee", ""));
		setCountrycd(JSPUtil.getParameter(request, "countrycd", ""));
		setCollectob(JSPUtil.getParameter(request, "collectob", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CollectionOfficeFinderVO[]
	 */
	public CollectionOfficeFinderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CollectionOfficeFinderVO[]
	 */
	public CollectionOfficeFinderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CollectionOfficeFinderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmtoffsub = (JSPUtil.getParameter(request, prefix	+ "dmtoffsub", length));
			String[] collectib = (JSPUtil.getParameter(request, prefix	+ "collectib", length));
			String[] yardlocat = (JSPUtil.getParameter(request, prefix	+ "yardlocat", length));
			String[] demdetoff = (JSPUtil.getParameter(request, prefix	+ "demdetoff", length));
			String[] yarddelyn = (JSPUtil.getParameter(request, prefix	+ "yarddelyn", length));
			String[] yardnodee = (JSPUtil.getParameter(request, prefix	+ "yardnodee", length));
			String[] countrycd = (JSPUtil.getParameter(request, prefix	+ "countrycd", length));
			String[] collectob = (JSPUtil.getParameter(request, prefix	+ "collectob", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CollectionOfficeFinderVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmtoffsub[i] != null)
					model.setDmtoffsub(dmtoffsub[i]);
				if (collectib[i] != null)
					model.setCollectib(collectib[i]);
				if (yardlocat[i] != null)
					model.setYardlocat(yardlocat[i]);
				if (demdetoff[i] != null)
					model.setDemdetoff(demdetoff[i]);
				if (yarddelyn[i] != null)
					model.setYarddelyn(yarddelyn[i]);
				if (yardnodee[i] != null)
					model.setYardnodee(yardnodee[i]);
				if (countrycd[i] != null)
					model.setCountrycd(countrycd[i]);
				if (collectob[i] != null)
					model.setCollectob(collectob[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCollectionOfficeFinderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CollectionOfficeFinderVO[]
	 */
	public CollectionOfficeFinderVO[] getCollectionOfficeFinderVOs(){
		CollectionOfficeFinderVO[] vos = (CollectionOfficeFinderVO[])models.toArray(new CollectionOfficeFinderVO[models.size()]);
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
		this.dmtoffsub = this.dmtoffsub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collectib = this.collectib .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardlocat = this.yardlocat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demdetoff = this.demdetoff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yarddelyn = this.yarddelyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardnodee = this.yardnodee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countrycd = this.countrycd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collectob = this.collectob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
