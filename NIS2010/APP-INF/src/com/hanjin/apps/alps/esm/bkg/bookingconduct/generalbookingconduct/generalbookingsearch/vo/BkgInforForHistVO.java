/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgInforForHistVO.java
*@FileTitle : BkgInforForHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.12 이남경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgInforForHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgInforForHistVO> models = new ArrayList<BkgInforForHistVO>();
	
	/* Column Info */
	private String trnkPol = null;
	/* Column Info */
	private String n1stPol = null;
	/* Column Info */
	private String n1stEtd = null;
	/* Column Info */
	private String trnkEtb = null;
	/* Column Info */
	private String trnkEtd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String portClosing = null;
	/* Column Info */
	private String bdrDt = null;
	/* Column Info */
	private String n1stVvd = null;
	/* Column Info */
	private String n1stEtb = null;
	/* Column Info */
	private String trnkVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgInforForHistVO() {}

	public BkgInforForHistVO(String ibflag, String pagerows, String bkgNo, String blNo, String portClosing, String bdrDt, String n1stVvd, String n1stPol, String n1stEtb, String n1stEtd, String trnkVvd, String trnkPol, String trnkEtb, String trnkEtd) {
		this.trnkPol = trnkPol;
		this.n1stPol = n1stPol;
		this.n1stEtd = n1stEtd;
		this.trnkEtb = trnkEtb;
		this.trnkEtd = trnkEtd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.portClosing = portClosing;
		this.bdrDt = bdrDt;
		this.n1stVvd = n1stVvd;
		this.n1stEtb = n1stEtb;
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trnk_pol", getTrnkPol());
		this.hashColumns.put("n1st_pol", getN1stPol());
		this.hashColumns.put("n1st_etd", getN1stEtd());
		this.hashColumns.put("trnk_etb", getTrnkEtb());
		this.hashColumns.put("trnk_etd", getTrnkEtd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("port_closing", getPortClosing());
		this.hashColumns.put("bdr_dt", getBdrDt());
		this.hashColumns.put("n1st_vvd", getN1stVvd());
		this.hashColumns.put("n1st_etb", getN1stEtb());
		this.hashColumns.put("trnk_vvd", getTrnkVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trnk_pol", "trnkPol");
		this.hashFields.put("n1st_pol", "n1stPol");
		this.hashFields.put("n1st_etd", "n1stEtd");
		this.hashFields.put("trnk_etb", "trnkEtb");
		this.hashFields.put("trnk_etd", "trnkEtd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("port_closing", "portClosing");
		this.hashFields.put("bdr_dt", "bdrDt");
		this.hashFields.put("n1st_vvd", "n1stVvd");
		this.hashFields.put("n1st_etb", "n1stEtb");
		this.hashFields.put("trnk_vvd", "trnkVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trnkPol
	 */
	public String getTrnkPol() {
		return this.trnkPol;
	}
	
	/**
	 * Column Info
	 * @return n1stPol
	 */
	public String getN1stPol() {
		return this.n1stPol;
	}
	
	/**
	 * Column Info
	 * @return n1stEtd
	 */
	public String getN1stEtd() {
		return this.n1stEtd;
	}
	
	/**
	 * Column Info
	 * @return trnkEtb
	 */
	public String getTrnkEtb() {
		return this.trnkEtb;
	}
	
	/**
	 * Column Info
	 * @return trnkEtd
	 */
	public String getTrnkEtd() {
		return this.trnkEtd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return portClosing
	 */
	public String getPortClosing() {
		return this.portClosing;
	}
	
	/**
	 * Column Info
	 * @return bdrDt
	 */
	public String getBdrDt() {
		return this.bdrDt;
	}
	
	/**
	 * Column Info
	 * @return n1stVvd
	 */
	public String getN1stVvd() {
		return this.n1stVvd;
	}
	
	/**
	 * Column Info
	 * @return n1stEtb
	 */
	public String getN1stEtb() {
		return this.n1stEtb;
	}
	
	/**
	 * Column Info
	 * @return trnkVvd
	 */
	public String getTrnkVvd() {
		return this.trnkVvd;
	}
	

	/**
	 * Column Info
	 * @param trnkPol
	 */
	public void setTrnkPol(String trnkPol) {
		this.trnkPol = trnkPol;
	}
	
	/**
	 * Column Info
	 * @param n1stPol
	 */
	public void setN1stPol(String n1stPol) {
		this.n1stPol = n1stPol;
	}
	
	/**
	 * Column Info
	 * @param n1stEtd
	 */
	public void setN1stEtd(String n1stEtd) {
		this.n1stEtd = n1stEtd;
	}
	
	/**
	 * Column Info
	 * @param trnkEtb
	 */
	public void setTrnkEtb(String trnkEtb) {
		this.trnkEtb = trnkEtb;
	}
	
	/**
	 * Column Info
	 * @param trnkEtd
	 */
	public void setTrnkEtd(String trnkEtd) {
		this.trnkEtd = trnkEtd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param portClosing
	 */
	public void setPortClosing(String portClosing) {
		this.portClosing = portClosing;
	}
	
	/**
	 * Column Info
	 * @param bdrDt
	 */
	public void setBdrDt(String bdrDt) {
		this.bdrDt = bdrDt;
	}
	
	/**
	 * Column Info
	 * @param n1stVvd
	 */
	public void setN1stVvd(String n1stVvd) {
		this.n1stVvd = n1stVvd;
	}
	
	/**
	 * Column Info
	 * @param n1stEtb
	 */
	public void setN1stEtb(String n1stEtb) {
		this.n1stEtb = n1stEtb;
	}
	
	/**
	 * Column Info
	 * @param trnkVvd
	 */
	public void setTrnkVvd(String trnkVvd) {
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrnkPol(JSPUtil.getParameter(request, "trnk_pol", ""));
		setN1stPol(JSPUtil.getParameter(request, "n1st_pol", ""));
		setN1stEtd(JSPUtil.getParameter(request, "n1st_etd", ""));
		setTrnkEtb(JSPUtil.getParameter(request, "trnk_etb", ""));
		setTrnkEtd(JSPUtil.getParameter(request, "trnk_etd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPortClosing(JSPUtil.getParameter(request, "port_closing", ""));
		setBdrDt(JSPUtil.getParameter(request, "bdr_dt", ""));
		setN1stVvd(JSPUtil.getParameter(request, "n1st_vvd", ""));
		setN1stEtb(JSPUtil.getParameter(request, "n1st_etb", ""));
		setTrnkVvd(JSPUtil.getParameter(request, "trnk_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgInforForHistVO[]
	 */
	public BkgInforForHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgInforForHistVO[]
	 */
	public BkgInforForHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgInforForHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trnkPol = (JSPUtil.getParameter(request, prefix	+ "trnk_pol", length));
			String[] n1stPol = (JSPUtil.getParameter(request, prefix	+ "n1st_pol", length));
			String[] n1stEtd = (JSPUtil.getParameter(request, prefix	+ "n1st_etd", length));
			String[] trnkEtb = (JSPUtil.getParameter(request, prefix	+ "trnk_etb", length));
			String[] trnkEtd = (JSPUtil.getParameter(request, prefix	+ "trnk_etd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] portClosing = (JSPUtil.getParameter(request, prefix	+ "port_closing", length));
			String[] bdrDt = (JSPUtil.getParameter(request, prefix	+ "bdr_dt", length));
			String[] n1stVvd = (JSPUtil.getParameter(request, prefix	+ "n1st_vvd", length));
			String[] n1stEtb = (JSPUtil.getParameter(request, prefix	+ "n1st_etb", length));
			String[] trnkVvd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgInforForHistVO();
				if (trnkPol[i] != null)
					model.setTrnkPol(trnkPol[i]);
				if (n1stPol[i] != null)
					model.setN1stPol(n1stPol[i]);
				if (n1stEtd[i] != null)
					model.setN1stEtd(n1stEtd[i]);
				if (trnkEtb[i] != null)
					model.setTrnkEtb(trnkEtb[i]);
				if (trnkEtd[i] != null)
					model.setTrnkEtd(trnkEtd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (portClosing[i] != null)
					model.setPortClosing(portClosing[i]);
				if (bdrDt[i] != null)
					model.setBdrDt(bdrDt[i]);
				if (n1stVvd[i] != null)
					model.setN1stVvd(n1stVvd[i]);
				if (n1stEtb[i] != null)
					model.setN1stEtb(n1stEtb[i]);
				if (trnkVvd[i] != null)
					model.setTrnkVvd(trnkVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgInforForHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgInforForHistVO[]
	 */
	public BkgInforForHistVO[] getBkgInforForHistVOs(){
		BkgInforForHistVO[] vos = (BkgInforForHistVO[])models.toArray(new BkgInforForHistVO[models.size()]);
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
		this.trnkPol = this.trnkPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPol = this.n1stPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stEtd = this.n1stEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkEtb = this.trnkEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkEtd = this.trnkEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portClosing = this.portClosing .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDt = this.bdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVvd = this.n1stVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stEtb = this.n1stEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvd = this.trnkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
