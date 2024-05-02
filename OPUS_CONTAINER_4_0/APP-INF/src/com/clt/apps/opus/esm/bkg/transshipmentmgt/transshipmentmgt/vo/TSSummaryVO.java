/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TSSummaryVO.java
*@FileTitle : TSSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.09 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TSSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TSSummaryVO> models = new ArrayList<TSSummaryVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String rf40 = null;
	/* Column Info */
	private String eta = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String ft40 = null;
	/* Column Info */
	private String rf20 = null;
	/* Column Info */
	private String ft20 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TSSummaryVO() {}

	public TSSummaryVO(String ibflag, String pagerows, String vvd, String podYdCd, String eta, String ft20, String ft40, String rf20, String rf40, String polYdCd) {
		this.vvd = vvd;
		this.rf40 = rf40;
		this.eta = eta;
		this.ibflag = ibflag;
		this.podYdCd = podYdCd;
		this.ft40 = ft40;
		this.rf20 = rf20;
		this.ft20 = ft20;
		this.polYdCd = polYdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rf40", getRf40());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("ft40", getFt40());
		this.hashColumns.put("rf20", getRf20());
		this.hashColumns.put("ft20", getFt20());
		this.hashColumns.put("pol_yd_cd",getPolYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rf40", "rf40");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("ft40", "ft40");
		this.hashFields.put("rf20", "rf20");
		this.hashFields.put("ft20", "ft20");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return rf40
	 */
	public String getRf40() {
		return this.rf40;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return ft40
	 */
	public String getFt40() {
		return this.ft40;
	}
	
	/**
	 * Column Info
	 * @return rf20
	 */
	public String getRf20() {
		return this.rf20;
	}
	
	/**
	 * Column Info
	 * @return ft20
	 */
	public String getFt20() {
		return this.ft20;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param rf40
	 */
	public void setRf40(String rf40) {
		this.rf40 = rf40;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param ft40
	 */
	public void setFt40(String ft40) {
		this.ft40 = ft40;
	}
	
	/**
	 * Column Info
	 * @param rf20
	 */
	public void setRf20(String rf20) {
		this.rf20 = rf20;
	}
	
	/**
	 * Column Info
	 * @param ft20
	 */
	public void setFt20(String ft20) {
		this.ft20 = ft20;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setRf40(JSPUtil.getParameter(request, "rf40", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setFt40(JSPUtil.getParameter(request, "ft40", ""));
		setRf20(JSPUtil.getParameter(request, "rf20", ""));
		setFt20(JSPUtil.getParameter(request, "ft20", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSSummaryVO[]
	 */
	public TSSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TSSummaryVO[]
	 */
	public TSSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TSSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] rf40 = (JSPUtil.getParameter(request, prefix	+ "rf40".trim(), length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd".trim(), length));
			String[] ft40 = (JSPUtil.getParameter(request, prefix	+ "ft40".trim(), length));
			String[] rf20 = (JSPUtil.getParameter(request, prefix	+ "rf20".trim(), length));
			String[] ft20 = (JSPUtil.getParameter(request, prefix	+ "ft20".trim(), length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TSSummaryVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (rf40[i] != null)
					model.setRf40(rf40[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (ft40[i] != null)
					model.setFt40(ft40[i]);
				if (rf20[i] != null)
					model.setRf20(rf20[i]);
				if (ft20[i] != null)
					model.setFt20(ft20[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTSSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TSSummaryVO[]
	 */
	public TSSummaryVO[] getTSSummaryVOs(){
		TSSummaryVO[] vos = (TSSummaryVO[])models.toArray(new TSSummaryVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40 = this.rf40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft40 = this.ft40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20 = this.rf20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft20 = this.ft20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
