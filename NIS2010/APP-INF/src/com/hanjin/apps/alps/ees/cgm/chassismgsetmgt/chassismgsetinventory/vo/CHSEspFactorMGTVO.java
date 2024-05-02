/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSEspFactorMGTVO.java
*@FileTitle : CHSEspFactorMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.27 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSEspFactorMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSEspFactorMGTVO> models = new ArrayList<CHSEspFactorMGTVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String espCalcFactor = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntr20ftAdjVal = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String cntrR5AdjVal = null;
	/* Column Info */
	private String espAdjKndCd = null;
	/* Column Info */
	private String cntr40ftAdjVal = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntr45ftAdjVal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSEspFactorMGTVO() {}

	public CHSEspFactorMGTVO(String ibflag, String pagerows, String sccCd, String espAdjKndCd, String espCalcFactor, String cntr20ftAdjVal, String cntr40ftAdjVal, String cntr45ftAdjVal, String cntrR5AdjVal, String creUsrId, String updUsrId) {
		this.creUsrId = creUsrId;
		this.espCalcFactor = espCalcFactor;
		this.ibflag = ibflag;
		this.cntr20ftAdjVal = cntr20ftAdjVal;
		this.sccCd = sccCd;
		this.cntrR5AdjVal = cntrR5AdjVal;
		this.espAdjKndCd = espAdjKndCd;
		this.cntr40ftAdjVal = cntr40ftAdjVal;
		this.updUsrId = updUsrId;
		this.cntr45ftAdjVal = cntr45ftAdjVal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("esp_calc_factor", getEspCalcFactor());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_20ft_adj_val", getCntr20ftAdjVal());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("cntr_r5_adj_val", getCntrR5AdjVal());
		this.hashColumns.put("esp_adj_knd_cd", getEspAdjKndCd());
		this.hashColumns.put("cntr_40ft_adj_val", getCntr40ftAdjVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_45ft_adj_val", getCntr45ftAdjVal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("esp_calc_factor", "espCalcFactor");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_20ft_adj_val", "cntr20ftAdjVal");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("cntr_r5_adj_val", "cntrR5AdjVal");
		this.hashFields.put("esp_adj_knd_cd", "espAdjKndCd");
		this.hashFields.put("cntr_40ft_adj_val", "cntr40ftAdjVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_45ft_adj_val", "cntr45ftAdjVal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return espCalcFactor
	 */
	public String getEspCalcFactor() {
		return this.espCalcFactor;
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
	 * @return cntr20ftAdjVal
	 */
	public String getCntr20ftAdjVal() {
		return this.cntr20ftAdjVal;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return cntrR5AdjVal
	 */
	public String getCntrR5AdjVal() {
		return this.cntrR5AdjVal;
	}
	
	/**
	 * Column Info
	 * @return espAdjKndCd
	 */
	public String getEspAdjKndCd() {
		return this.espAdjKndCd;
	}
	
	/**
	 * Column Info
	 * @return cntr40ftAdjVal
	 */
	public String getCntr40ftAdjVal() {
		return this.cntr40ftAdjVal;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntr45ftAdjVal
	 */
	public String getCntr45ftAdjVal() {
		return this.cntr45ftAdjVal;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param espCalcFactor
	 */
	public void setEspCalcFactor(String espCalcFactor) {
		this.espCalcFactor = espCalcFactor;
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
	 * @param cntr20ftAdjVal
	 */
	public void setCntr20ftAdjVal(String cntr20ftAdjVal) {
		this.cntr20ftAdjVal = cntr20ftAdjVal;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param cntrR5AdjVal
	 */
	public void setCntrR5AdjVal(String cntrR5AdjVal) {
		this.cntrR5AdjVal = cntrR5AdjVal;
	}
	
	/**
	 * Column Info
	 * @param espAdjKndCd
	 */
	public void setEspAdjKndCd(String espAdjKndCd) {
		this.espAdjKndCd = espAdjKndCd;
	}
	
	/**
	 * Column Info
	 * @param cntr40ftAdjVal
	 */
	public void setCntr40ftAdjVal(String cntr40ftAdjVal) {
		this.cntr40ftAdjVal = cntr40ftAdjVal;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntr45ftAdjVal
	 */
	public void setCntr45ftAdjVal(String cntr45ftAdjVal) {
		this.cntr45ftAdjVal = cntr45ftAdjVal;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEspCalcFactor(JSPUtil.getParameter(request, "esp_calc_factor", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntr20ftAdjVal(JSPUtil.getParameter(request, "cntr_20ft_adj_val", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setCntrR5AdjVal(JSPUtil.getParameter(request, "cntr_r5_adj_val", ""));
		setEspAdjKndCd(JSPUtil.getParameter(request, "esp_adj_knd_cd", ""));
		setCntr40ftAdjVal(JSPUtil.getParameter(request, "cntr_40ft_adj_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCntr45ftAdjVal(JSPUtil.getParameter(request, "cntr_45ft_adj_val", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSEspFactorMGTVO[]
	 */
	public CHSEspFactorMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSEspFactorMGTVO[]
	 */
	public CHSEspFactorMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSEspFactorMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] espCalcFactor = (JSPUtil.getParameter(request, prefix	+ "esp_calc_factor", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntr20ftAdjVal = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_adj_val", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] cntrR5AdjVal = (JSPUtil.getParameter(request, prefix	+ "cntr_r5_adj_val", length));
			String[] espAdjKndCd = (JSPUtil.getParameter(request, prefix	+ "esp_adj_knd_cd", length));
			String[] cntr40ftAdjVal = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_adj_val", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntr45ftAdjVal = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_adj_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSEspFactorMGTVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (espCalcFactor[i] != null)
					model.setEspCalcFactor(espCalcFactor[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntr20ftAdjVal[i] != null)
					model.setCntr20ftAdjVal(cntr20ftAdjVal[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (cntrR5AdjVal[i] != null)
					model.setCntrR5AdjVal(cntrR5AdjVal[i]);
				if (espAdjKndCd[i] != null)
					model.setEspAdjKndCd(espAdjKndCd[i]);
				if (cntr40ftAdjVal[i] != null)
					model.setCntr40ftAdjVal(cntr40ftAdjVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntr45ftAdjVal[i] != null)
					model.setCntr45ftAdjVal(cntr45ftAdjVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSEspFactorMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSEspFactorMGTVO[]
	 */
	public CHSEspFactorMGTVO[] getCHSEspFactorMGTVOs(){
		CHSEspFactorMGTVO[] vos = (CHSEspFactorMGTVO[])models.toArray(new CHSEspFactorMGTVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.espCalcFactor = this.espCalcFactor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftAdjVal = this.cntr20ftAdjVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrR5AdjVal = this.cntrR5AdjVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.espAdjKndCd = this.espAdjKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftAdjVal = this.cntr40ftAdjVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftAdjVal = this.cntr45ftAdjVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
