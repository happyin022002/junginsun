/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerEdiDBDAOOptionsVO.java
*@FileTitle : CustomerEdiDBDAOOptionsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.04 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomerEdiDBDAOOptionsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerEdiDBDAOOptionsVO> models = new ArrayList<CustomerEdiDBDAOOptionsVO>();
	
	/* Column Info */
	private String hjTpId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String csCd = null;
	/* Column Info */
	private String csGrpId = null;
	/* Column Info */
	private String csTpId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomerEdiDBDAOOptionsVO() {}

	public CustomerEdiDBDAOOptionsVO(String ibflag, String pagerows, String csGrpId, String csTpId, String hjTpId, String scNo, String csCd) {
		this.hjTpId = hjTpId;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.csCd = csCd;
		this.csGrpId = csGrpId;
		this.csTpId = csTpId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hj_tp_id", getHjTpId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cs_cd", getCsCd());
		this.hashColumns.put("cs_grp_id", getCsGrpId());
		this.hashColumns.put("cs_tp_id", getCsTpId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hj_tp_id", "hjTpId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cs_cd", "csCd");
		this.hashFields.put("cs_grp_id", "csGrpId");
		this.hashFields.put("cs_tp_id", "csTpId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hjTpId
	 */
	public String getHjTpId() {
		return this.hjTpId;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return csCd
	 */
	public String getCsCd() {
		return this.csCd;
	}
	
	/**
	 * Column Info
	 * @return csGrpId
	 */
	public String getCsGrpId() {
		return this.csGrpId;
	}
	
	/**
	 * Column Info
	 * @return csTpId
	 */
	public String getCsTpId() {
		return this.csTpId;
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
	 * @param hjTpId
	 */
	public void setHjTpId(String hjTpId) {
		this.hjTpId = hjTpId;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param csCd
	 */
	public void setCsCd(String csCd) {
		this.csCd = csCd;
	}
	
	/**
	 * Column Info
	 * @param csGrpId
	 */
	public void setCsGrpId(String csGrpId) {
		this.csGrpId = csGrpId;
	}
	
	/**
	 * Column Info
	 * @param csTpId
	 */
	public void setCsTpId(String csTpId) {
		this.csTpId = csTpId;
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
		setHjTpId(JSPUtil.getParameter(request, "hj_tp_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCsCd(JSPUtil.getParameter(request, "cs_cd", ""));
		setCsGrpId(JSPUtil.getParameter(request, "cs_grp_id", ""));
		setCsTpId(JSPUtil.getParameter(request, "cs_tp_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerEdiDBDAOOptionsVO[]
	 */
	public CustomerEdiDBDAOOptionsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerEdiDBDAOOptionsVO[]
	 */
	public CustomerEdiDBDAOOptionsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerEdiDBDAOOptionsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hjTpId = (JSPUtil.getParameter(request, prefix	+ "hj_tp_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] csCd = (JSPUtil.getParameter(request, prefix	+ "cs_cd", length));
			String[] csGrpId = (JSPUtil.getParameter(request, prefix	+ "cs_grp_id", length));
			String[] csTpId = (JSPUtil.getParameter(request, prefix	+ "cs_tp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomerEdiDBDAOOptionsVO();
				if (hjTpId[i] != null)
					model.setHjTpId(hjTpId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (csCd[i] != null)
					model.setCsCd(csCd[i]);
				if (csGrpId[i] != null)
					model.setCsGrpId(csGrpId[i]);
				if (csTpId[i] != null)
					model.setCsTpId(csTpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerEdiDBDAOOptionsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerEdiDBDAOOptionsVO[]
	 */
	public CustomerEdiDBDAOOptionsVO[] getCustomerEdiDBDAOOptionsVOs(){
		CustomerEdiDBDAOOptionsVO[] vos = (CustomerEdiDBDAOOptionsVO[])models.toArray(new CustomerEdiDBDAOOptionsVO[models.size()]);
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
		this.hjTpId = this.hjTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csCd = this.csCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csGrpId = this.csGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csTpId = this.csTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
