/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqPriceOptionVO.java
*@FileTitle : EqPriceOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.01 이호선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqPriceOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqPriceOptionVO> models = new ArrayList<EqPriceOptionVO>();
	
	/* Column Info */
	private String bseYrmon = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String bseYrmon0 = null;
	/* Column Info */
	private String bseYrmon1 = null;
	/* Page Number */
	private String mlocCd = null;
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqPriceOptionVO() {}

	public EqPriceOptionVO(String ibflag, String pagerows, String cntrTpszCd, String eqKndCd, String bseYrmon, String bseYrmon0, String bseYrmon1, String locCd, String mlocCd) {
		this.bseYrmon = bseYrmon;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.eqKndCd = eqKndCd;
		this.bseYrmon0 = bseYrmon0;
		this.bseYrmon1 = bseYrmon1;
		this.mlocCd = mlocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("bse_yrmon0", getBseYrmon0());
		this.hashColumns.put("bse_yrmon1", getBseYrmon1());
		this.hashColumns.put("mloc_cd", getMlocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("bse_yrmon0", "bseYrmon0");
		this.hashFields.put("bse_yrmon1", "bseYrmon1");
		this.hashFields.put("mloc_cd", "mlocCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return this.bseYrmon;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getMlocCd() {
		return this.mlocCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return bseYrmon0
	 */
	public String getBseYrmon0() {
		return this.bseYrmon0;
	}
	
	/**
	 * Column Info
	 * @return bseYrmon1
	 */
	public String getBseYrmon1() {
		return this.bseYrmon1;
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
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * Column Info
	 * @param locCd
	 */
	public void setMlocCd(String mlocCd) {
		this.mlocCd = mlocCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param bseYrmon0
	 */
	public void setBseYrmon0(String bseYrmon0) {
		this.bseYrmon0 = bseYrmon0;
	}
	
	/**
	 * Column Info
	 * @param bseYrmon1
	 */
	public void setBseYrmon1(String bseYrmon1) {
		this.bseYrmon1 = bseYrmon1;
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
		setBseYrmon(JSPUtil.getParameter(request, "bse_yrmon", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setBseYrmon0(JSPUtil.getParameter(request, "bse_yrmon0", ""));
		setBseYrmon1(JSPUtil.getParameter(request, "bse_yrmon1", ""));
		setMlocCd(JSPUtil.getParameter(request, "mloc_cd", ""));		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqPriceOptionVO[]
	 */
	public EqPriceOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqPriceOptionVO[]
	 */
	public EqPriceOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqPriceOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] bseYrmon0 = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon0", length));
			String[] bseYrmon1 = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon1", length));
			String[] mlocCd = (JSPUtil.getParameter(request, prefix	+ "mloc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqPriceOptionVO();
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (bseYrmon0[i] != null)
					model.setBseYrmon0(bseYrmon0[i]);
				if (bseYrmon1[i] != null)
					model.setBseYrmon1(bseYrmon1[i]);
				if (mlocCd[i] != null)
					model.setMlocCd(mlocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqPriceOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqPriceOptionVO[]
	 */
	public EqPriceOptionVO[] getEqPriceOptionVOs(){
		EqPriceOptionVO[] vos = (EqPriceOptionVO[])models.toArray(new EqPriceOptionVO[models.size()]);
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
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon0 = this.bseYrmon0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon1 = this.bseYrmon1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlocCd = this.mlocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
