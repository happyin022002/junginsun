/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanSearchBlChargeVO.java
*@FileTitle : TaiwanSearchBlChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.27 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaiwanSearchBlChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaiwanSearchBlChargeVO> models = new ArrayList<TaiwanSearchBlChargeVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String tariff = null;
	/* Column Info */
	private String pertype = null;
	/* Column Info */
	private String fctype = null;
	/* Column Info */
	private String cct = null;
	/* Column Info */
	private String ppd = null;
	/* Column Info */
	private String revenueton = null;
	/* Column Info */
	private String currencycode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaiwanSearchBlChargeVO() {}

	public TaiwanSearchBlChargeVO(String ibflag, String pagerows, String fctype, String rate, String revenueton, String ppd, String cct, String currencycode, String tariff, String pertype) {
		this.ibflag = ibflag;
		this.rate = rate;
		this.tariff = tariff;
		this.pertype = pertype;
		this.fctype = fctype;
		this.cct = cct;
		this.ppd = ppd;
		this.revenueton = revenueton;
		this.currencycode = currencycode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("pertype", getPertype());
		this.hashColumns.put("fctype", getFctype());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("ppd", getPpd());
		this.hashColumns.put("revenueton", getRevenueton());
		this.hashColumns.put("currencycode", getCurrencycode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("pertype", "pertype");
		this.hashFields.put("fctype", "fctype");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("ppd", "ppd");
		this.hashFields.put("revenueton", "revenueton");
		this.hashFields.put("currencycode", "currencycode");
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return tariff
	 */
	public String getTariff() {
		return this.tariff;
	}
	
	/**
	 * Column Info
	 * @return pertype
	 */
	public String getPertype() {
		return this.pertype;
	}
	
	/**
	 * Column Info
	 * @return fctype
	 */
	public String getFctype() {
		return this.fctype;
	}
	
	/**
	 * Column Info
	 * @return cct
	 */
	public String getCct() {
		return this.cct;
	}
	
	/**
	 * Column Info
	 * @return ppd
	 */
	public String getPpd() {
		return this.ppd;
	}
	
	/**
	 * Column Info
	 * @return revenueton
	 */
	public String getRevenueton() {
		return this.revenueton;
	}
	
	/**
	 * Column Info
	 * @return currencycode
	 */
	public String getCurrencycode() {
		return this.currencycode;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param tariff
	 */
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	
	/**
	 * Column Info
	 * @param pertype
	 */
	public void setPertype(String pertype) {
		this.pertype = pertype;
	}
	
	/**
	 * Column Info
	 * @param fctype
	 */
	public void setFctype(String fctype) {
		this.fctype = fctype;
	}
	
	/**
	 * Column Info
	 * @param cct
	 */
	public void setCct(String cct) {
		this.cct = cct;
	}
	
	/**
	 * Column Info
	 * @param ppd
	 */
	public void setPpd(String ppd) {
		this.ppd = ppd;
	}
	
	/**
	 * Column Info
	 * @param revenueton
	 */
	public void setRevenueton(String revenueton) {
		this.revenueton = revenueton;
	}
	
	/**
	 * Column Info
	 * @param currencycode
	 */
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
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
		setRate(JSPUtil.getParameter(request, "rate", ""));
		setTariff(JSPUtil.getParameter(request, "tariff", ""));
		setPertype(JSPUtil.getParameter(request, "pertype", ""));
		setFctype(JSPUtil.getParameter(request, "fctype", ""));
		setCct(JSPUtil.getParameter(request, "cct", ""));
		setPpd(JSPUtil.getParameter(request, "ppd", ""));
		setRevenueton(JSPUtil.getParameter(request, "revenueton", ""));
		setCurrencycode(JSPUtil.getParameter(request, "currencycode", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaiwanSearchBlChargeVO[]
	 */
	public TaiwanSearchBlChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaiwanSearchBlChargeVO[]
	 */
	public TaiwanSearchBlChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaiwanSearchBlChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] pertype = (JSPUtil.getParameter(request, prefix	+ "pertype", length));
			String[] fctype = (JSPUtil.getParameter(request, prefix	+ "fctype", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] ppd = (JSPUtil.getParameter(request, prefix	+ "ppd", length));
			String[] revenueton = (JSPUtil.getParameter(request, prefix	+ "revenueton", length));
			String[] currencycode = (JSPUtil.getParameter(request, prefix	+ "currencycode", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaiwanSearchBlChargeVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (tariff[i] != null)
					model.setTariff(tariff[i]);
				if (pertype[i] != null)
					model.setPertype(pertype[i]);
				if (fctype[i] != null)
					model.setFctype(fctype[i]);
				if (cct[i] != null)
					model.setCct(cct[i]);
				if (ppd[i] != null)
					model.setPpd(ppd[i]);
				if (revenueton[i] != null)
					model.setRevenueton(revenueton[i]);
				if (currencycode[i] != null)
					model.setCurrencycode(currencycode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaiwanSearchBlChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaiwanSearchBlChargeVO[]
	 */
	public TaiwanSearchBlChargeVO[] getTaiwanSearchBlChargeVOs(){
		TaiwanSearchBlChargeVO[] vos = (TaiwanSearchBlChargeVO[])models.toArray(new TaiwanSearchBlChargeVO[models.size()]);
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
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pertype = this.pertype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctype = this.fctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppd = this.ppd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenueton = this.revenueton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currencycode = this.currencycode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
