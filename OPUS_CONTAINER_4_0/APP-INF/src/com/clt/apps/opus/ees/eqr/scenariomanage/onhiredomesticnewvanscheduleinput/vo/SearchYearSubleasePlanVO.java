/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchYearSubleasePlanVO.java
*@FileTitle : SearchYearSubleasePlanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.10 정은호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchYearSubleasePlanVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchYearSubleasePlanVO> models = new ArrayList<SearchYearSubleasePlanVO>();
	
	/* Column Info */
	private String s109CntrVolQty = null;
	/* Column Info */
	private String totsum = null;
	/* Column Info */
	private String s105CntrVolQty = null;
	/* Column Info */
	private String s110CntrVolQty = null;
	/* Column Info */
	private String s107CntrVolQty = null;
	/* Column Info */
	private String s102CntrVolQty = null;
	/* Column Info */
	private String s111CntrVolQty = null;
	/* Column Info */
	private String s103CntrVolQty = null;
	/* Column Info */
	private String s104CntrVolQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s108CntrVolQty = null;
	/* Column Info */
	private String s106CntrVolQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String s101CntrVolQty = null;
	/* Column Info */
	private String s112CntrVolQty = null;
	/* Column Info */
	private String rccCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchYearSubleasePlanVO() {}

	public SearchYearSubleasePlanVO(String ibflag, String pagerows, String rccCd, String totsum, String s101CntrVolQty, String s102CntrVolQty, String s103CntrVolQty, String s104CntrVolQty, String s105CntrVolQty, String s106CntrVolQty, String s107CntrVolQty, String s108CntrVolQty, String s109CntrVolQty, String s110CntrVolQty, String s111CntrVolQty, String s112CntrVolQty) {
		this.s109CntrVolQty = s109CntrVolQty;
		this.totsum = totsum;
		this.s105CntrVolQty = s105CntrVolQty;
		this.s110CntrVolQty = s110CntrVolQty;
		this.s107CntrVolQty = s107CntrVolQty;
		this.s102CntrVolQty = s102CntrVolQty;
		this.s111CntrVolQty = s111CntrVolQty;
		this.s103CntrVolQty = s103CntrVolQty;
		this.s104CntrVolQty = s104CntrVolQty;
		this.pagerows = pagerows;
		this.s108CntrVolQty = s108CntrVolQty;
		this.s106CntrVolQty = s106CntrVolQty;
		this.ibflag = ibflag;
		this.s101CntrVolQty = s101CntrVolQty;
		this.s112CntrVolQty = s112CntrVolQty;
		this.rccCd = rccCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s1_09_cntr_vol_qty", getS109CntrVolQty());
		this.hashColumns.put("totsum", getTotsum());
		this.hashColumns.put("s1_05_cntr_vol_qty", getS105CntrVolQty());
		this.hashColumns.put("s1_10_cntr_vol_qty", getS110CntrVolQty());
		this.hashColumns.put("s1_07_cntr_vol_qty", getS107CntrVolQty());
		this.hashColumns.put("s1_02_cntr_vol_qty", getS102CntrVolQty());
		this.hashColumns.put("s1_11_cntr_vol_qty", getS111CntrVolQty());
		this.hashColumns.put("s1_03_cntr_vol_qty", getS103CntrVolQty());
		this.hashColumns.put("s1_04_cntr_vol_qty", getS104CntrVolQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s1_08_cntr_vol_qty", getS108CntrVolQty());
		this.hashColumns.put("s1_06_cntr_vol_qty", getS106CntrVolQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s1_01_cntr_vol_qty", getS101CntrVolQty());
		this.hashColumns.put("s1_12_cntr_vol_qty", getS112CntrVolQty());
		this.hashColumns.put("rcc_cd", getRccCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s1_09_cntr_vol_qty", "s109CntrVolQty");
		this.hashFields.put("totsum", "totsum");
		this.hashFields.put("s1_05_cntr_vol_qty", "s105CntrVolQty");
		this.hashFields.put("s1_10_cntr_vol_qty", "s110CntrVolQty");
		this.hashFields.put("s1_07_cntr_vol_qty", "s107CntrVolQty");
		this.hashFields.put("s1_02_cntr_vol_qty", "s102CntrVolQty");
		this.hashFields.put("s1_11_cntr_vol_qty", "s111CntrVolQty");
		this.hashFields.put("s1_03_cntr_vol_qty", "s103CntrVolQty");
		this.hashFields.put("s1_04_cntr_vol_qty", "s104CntrVolQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s1_08_cntr_vol_qty", "s108CntrVolQty");
		this.hashFields.put("s1_06_cntr_vol_qty", "s106CntrVolQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s1_01_cntr_vol_qty", "s101CntrVolQty");
		this.hashFields.put("s1_12_cntr_vol_qty", "s112CntrVolQty");
		this.hashFields.put("rcc_cd", "rccCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return s19CntrVolQty
	 */
	public String getS109CntrVolQty() {
		return this.s109CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return totsum
	 */
	public String getTotsum() {
		return this.totsum;
	}
	
	/**
	 * Column Info
	 * @return s15CntrVolQty
	 */
	public String getS105CntrVolQty() {
		return this.s105CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s110CntrVolQty
	 */
	public String getS110CntrVolQty() {
		return this.s110CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s17CntrVolQty
	 */
	public String getS107CntrVolQty() {
		return this.s107CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s12CntrVolQty
	 */
	public String getS102CntrVolQty() {
		return this.s102CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s111CntrVolQty
	 */
	public String getS111CntrVolQty() {
		return this.s111CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s13CntrVolQty
	 */
	public String getS103CntrVolQty() {
		return this.s103CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s14CntrVolQty
	 */
	public String getS104CntrVolQty() {
		return this.s104CntrVolQty;
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
	 * @return s18CntrVolQty
	 */
	public String getS108CntrVolQty() {
		return this.s108CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s16CntrVolQty
	 */
	public String getS106CntrVolQty() {
		return this.s106CntrVolQty;
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
	 * @return s11CntrVolQty
	 */
	public String getS101CntrVolQty() {
		return this.s101CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return s112CntrVolQty
	 */
	public String getS112CntrVolQty() {
		return this.s112CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return intgCdValCtnt
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	

	/**
	 * Column Info
	 * @param s19CntrVolQty
	 */
	public void setS109CntrVolQty(String s109CntrVolQty) {
		this.s109CntrVolQty = s109CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param totsum
	 */
	public void setTotsum(String totsum) {
		this.totsum = totsum;
	}
	
	/**
	 * Column Info
	 * @param s15CntrVolQty
	 */
	public void setS105CntrVolQty(String s105CntrVolQty) {
		this.s105CntrVolQty = s105CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s110CntrVolQty
	 */
	public void setS110CntrVolQty(String s110CntrVolQty) {
		this.s110CntrVolQty = s110CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s17CntrVolQty
	 */
	public void setS107CntrVolQty(String s107CntrVolQty) {
		this.s107CntrVolQty = s107CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s12CntrVolQty
	 */
	public void setS102CntrVolQty(String s102CntrVolQty) {
		this.s102CntrVolQty = s102CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s111CntrVolQty
	 */
	public void setS111CntrVolQty(String s111CntrVolQty) {
		this.s111CntrVolQty = s111CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s13CntrVolQty
	 */
	public void setS103CntrVolQty(String s103CntrVolQty) {
		this.s103CntrVolQty = s103CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s14CntrVolQty
	 */
	public void setS104CntrVolQty(String s104CntrVolQty) {
		this.s104CntrVolQty = s104CntrVolQty;
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
	 * @param s18CntrVolQty
	 */
	public void setS108CntrVolQty(String s108CntrVolQty) {
		this.s108CntrVolQty = s108CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s16CntrVolQty
	 */
	public void setS106CntrVolQty(String s106CntrVolQty) {
		this.s106CntrVolQty = s106CntrVolQty;
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
	 * @param s11CntrVolQty
	 */
	public void setS101CntrVolQty(String s101CntrVolQty) {
		this.s101CntrVolQty = s101CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param s112CntrVolQty
	 */
	public void setS112CntrVolQty(String s112CntrVolQty) {
		this.s112CntrVolQty = s112CntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param intgCdValCtnt
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setS109CntrVolQty(JSPUtil.getParameter(request, "s1_09_cntr_vol_qty", ""));
		setTotsum(JSPUtil.getParameter(request, "totsum", ""));
		setS105CntrVolQty(JSPUtil.getParameter(request, "s1_05_cntr_vol_qty", ""));
		setS110CntrVolQty(JSPUtil.getParameter(request, "s1_10_cntr_vol_qty", ""));
		setS107CntrVolQty(JSPUtil.getParameter(request, "s1_07_cntr_vol_qty", ""));
		setS102CntrVolQty(JSPUtil.getParameter(request, "s1_02_cntr_vol_qty", ""));
		setS111CntrVolQty(JSPUtil.getParameter(request, "s1_11_cntr_vol_qty", ""));
		setS103CntrVolQty(JSPUtil.getParameter(request, "s1_03_cntr_vol_qty", ""));
		setS104CntrVolQty(JSPUtil.getParameter(request, "s1_04_cntr_vol_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setS108CntrVolQty(JSPUtil.getParameter(request, "s1_08_cntr_vol_qty", ""));
		setS106CntrVolQty(JSPUtil.getParameter(request, "s1_06_cntr_vol_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setS101CntrVolQty(JSPUtil.getParameter(request, "s1_01_cntr_vol_qty", ""));
		setS112CntrVolQty(JSPUtil.getParameter(request, "s1_12_cntr_vol_qty", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYearSubleasePlanVO[]
	 */
	public SearchYearSubleasePlanVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYearSubleasePlanVO[]
	 */
	public SearchYearSubleasePlanVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchYearSubleasePlanVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s109CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_09_cntr_vol_qty", length));
			String[] totsum = (JSPUtil.getParameter(request, prefix	+ "totsum", length));
			String[] s105CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_05_cntr_vol_qty", length));
			String[] s110CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_10_cntr_vol_qty", length));
			String[] s107CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_07_cntr_vol_qty", length));
			String[] s102CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_02_cntr_vol_qty", length));
			String[] s111CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_11_cntr_vol_qty", length));
			String[] s103CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_03_cntr_vol_qty", length));
			String[] s104CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_04_cntr_vol_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s108CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_08_cntr_vol_qty", length));
			String[] s106CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_06_cntr_vol_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s101CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_01_cntr_vol_qty", length));
			String[] s112CntrVolQty = (JSPUtil.getParameter(request, prefix	+ "s1_12_cntr_vol_qty", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchYearSubleasePlanVO();
				if (s109CntrVolQty[i] != null)
					model.setS109CntrVolQty(s109CntrVolQty[i]);
				if (totsum[i] != null)
					model.setTotsum(totsum[i]);
				if (s105CntrVolQty[i] != null)
					model.setS105CntrVolQty(s105CntrVolQty[i]);
				if (s110CntrVolQty[i] != null)
					model.setS110CntrVolQty(s110CntrVolQty[i]);
				if (s107CntrVolQty[i] != null)
					model.setS107CntrVolQty(s107CntrVolQty[i]);
				if (s102CntrVolQty[i] != null)
					model.setS102CntrVolQty(s102CntrVolQty[i]);
				if (s111CntrVolQty[i] != null)
					model.setS111CntrVolQty(s111CntrVolQty[i]);
				if (s103CntrVolQty[i] != null)
					model.setS103CntrVolQty(s103CntrVolQty[i]);
				if (s104CntrVolQty[i] != null)
					model.setS104CntrVolQty(s104CntrVolQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s108CntrVolQty[i] != null)
					model.setS108CntrVolQty(s108CntrVolQty[i]);
				if (s106CntrVolQty[i] != null)
					model.setS106CntrVolQty(s106CntrVolQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (s101CntrVolQty[i] != null)
					model.setS101CntrVolQty(s101CntrVolQty[i]);
				if (s112CntrVolQty[i] != null)
					model.setS112CntrVolQty(s112CntrVolQty[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchYearSubleasePlanVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYearSubleasePlanVO[]
	 */
	public SearchYearSubleasePlanVO[] getSearchYearSubleasePlanVOs(){
		SearchYearSubleasePlanVO[] vos = (SearchYearSubleasePlanVO[])models.toArray(new SearchYearSubleasePlanVO[models.size()]);
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
		this.s109CntrVolQty = this.s109CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totsum = this.totsum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s105CntrVolQty = this.s105CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s110CntrVolQty = this.s110CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s107CntrVolQty = this.s107CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s102CntrVolQty = this.s102CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s111CntrVolQty = this.s111CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s103CntrVolQty = this.s103CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s104CntrVolQty = this.s104CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s108CntrVolQty = this.s108CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s106CntrVolQty = this.s106CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s101CntrVolQty = this.s101CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s112CntrVolQty = this.s112CntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
