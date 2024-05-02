/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtCrTermOptVO.java
*@FileTitle : DmtCrTermOptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtCrTermOptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtCrTermOptVO> models = new ArrayList<DmtCrTermOptVO>();
	
	/* Column Info */
	private String crTermDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String issDtPrnFlg = null;
	/* Column Info */
	private String dfltTaxRto = null;
	/* Column Info */
	private String dueDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtCrTermOptVO() {}

	public DmtCrTermOptVO(String ibflag, String pagerows, String dueDt, String crTermDys, String issDtPrnFlg, String dfltTaxRto) {
		this.crTermDys = crTermDys;
		this.ibflag = ibflag;
		this.issDtPrnFlg = issDtPrnFlg;
		this.dfltTaxRto = dfltTaxRto;
		this.dueDt = dueDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cr_term_dys", getCrTermDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("iss_dt_prn_flg", getIssDtPrnFlg());
		this.hashColumns.put("dflt_tax_rto", getDfltTaxRto());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("iss_dt_prn_flg", "issDtPrnFlg");
		this.hashFields.put("dflt_tax_rto", "dfltTaxRto");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crTermDys
	 */
	public String getCrTermDys() {
		return this.crTermDys;
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
	 * @return issDtPrnFlg
	 */
	public String getIssDtPrnFlg() {
		return this.issDtPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return dfltTaxRto
	 */
	public String getDfltTaxRto() {
		return this.dfltTaxRto;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
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
	 * @param crTermDys
	 */
	public void setCrTermDys(String crTermDys) {
		this.crTermDys = crTermDys;
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
	 * @param issDtPrnFlg
	 */
	public void setIssDtPrnFlg(String issDtPrnFlg) {
		this.issDtPrnFlg = issDtPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param dfltTaxRto
	 */
	public void setDfltTaxRto(String dfltTaxRto) {
		this.dfltTaxRto = dfltTaxRto;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
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
		setCrTermDys(JSPUtil.getParameter(request, "cr_term_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIssDtPrnFlg(JSPUtil.getParameter(request, "iss_dt_prn_flg", ""));
		setDfltTaxRto(JSPUtil.getParameter(request, "dflt_tax_rto", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtCrTermOptVO[]
	 */
	public DmtCrTermOptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtCrTermOptVO[]
	 */
	public DmtCrTermOptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtCrTermOptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crTermDys = (JSPUtil.getParameter(request, prefix	+ "cr_term_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] issDtPrnFlg = (JSPUtil.getParameter(request, prefix	+ "iss_dt_prn_flg", length));
			String[] dfltTaxRto = (JSPUtil.getParameter(request, prefix	+ "dflt_tax_rto", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtCrTermOptVO();
				if (crTermDys[i] != null)
					model.setCrTermDys(crTermDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (issDtPrnFlg[i] != null)
					model.setIssDtPrnFlg(issDtPrnFlg[i]);
				if (dfltTaxRto[i] != null)
					model.setDfltTaxRto(dfltTaxRto[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtCrTermOptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtCrTermOptVO[]
	 */
	public DmtCrTermOptVO[] getDmtCrTermOptVOs(){
		DmtCrTermOptVO[] vos = (DmtCrTermOptVO[])models.toArray(new DmtCrTermOptVO[models.size()]);
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
		this.crTermDys = this.crTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDtPrnFlg = this.issDtPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTaxRto = this.dfltTaxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
