/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfDecChkListCondVO.java
*@FileTitle : KrWhfDecChkListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.27 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkListCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfDecChkListCondVO extends WhfDecChkListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecChkListCondVO> models = new ArrayList<KrWhfDecChkListCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eDate = null;
	/* Column Info */
	private String ixport = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String sDate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecChkListCondVO() {}

	public KrWhfDecChkListCondVO(String ibflag, String pagerows, String sDate, String eDate, String vvd, String portCd, String vslSlanCd, String ixport) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.eDate = eDate;
		this.ixport = ixport;
		this.portCd = portCd;
		this.vslSlanCd = vslSlanCd;
		this.sDate = sDate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("e_date", getEDate());
		this.hashColumns.put("ixport", getIxport());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("s_date", getSDate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("e_date", "eDate");
		this.hashFields.put("ixport", "ixport");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("s_date", "sDate");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return eDate
	 */
	public String getEDate() {
		return this.eDate;
	}
	
	/**
	 * Column Info
	 * @return ixport
	 */
	public String getIxport() {
		return this.ixport;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return sDate
	 */
	public String getSDate() {
		return this.sDate;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param eDate
	 */
	public void setEDate(String eDate) {
		this.eDate = eDate;
	}
	
	/**
	 * Column Info
	 * @param ixport
	 */
	public void setIxport(String ixport) {
		this.ixport = ixport;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param sDate
	 */
	public void setSDate(String sDate) {
		this.sDate = sDate;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEDate(JSPUtil.getParameter(request, "e_date", ""));
		setIxport(JSPUtil.getParameter(request, "ixport", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setSDate(JSPUtil.getParameter(request, "s_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecChkListCondVO[]
	 */
	public KrWhfDecChkListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecChkListCondVO[]
	 */
	public KrWhfDecChkListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecChkListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eDate = (JSPUtil.getParameter(request, prefix	+ "e_date", length));
			String[] ixport = (JSPUtil.getParameter(request, prefix	+ "ixport", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] sDate = (JSPUtil.getParameter(request, prefix	+ "s_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecChkListCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eDate[i] != null)
					model.setEDate(eDate[i]);
				if (ixport[i] != null)
					model.setIxport(ixport[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (sDate[i] != null)
					model.setSDate(sDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecChkListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecChkListCondVO[]
	 */
	public KrWhfDecChkListCondVO[] getKrWhfDecChkListCondVOs(){
		KrWhfDecChkListCondVO[] vos = (KrWhfDecChkListCondVO[])models.toArray(new KrWhfDecChkListCondVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eDate = this.eDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ixport = this.ixport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDate = this.sDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
