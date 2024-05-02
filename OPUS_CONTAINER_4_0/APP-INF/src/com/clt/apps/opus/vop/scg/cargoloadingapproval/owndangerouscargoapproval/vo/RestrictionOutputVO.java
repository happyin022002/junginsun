/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RestrictionOutputVO.java
*@FileTitle : RestrictionOutputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.23 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RestrictionOutputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RestrictionOutputVO> models = new ArrayList<RestrictionOutputVO>();
	
	/* Column Info */
	private String portType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String imdgCmptnAuthCd = null;
	/* Column Info */
	private String txtDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RestrictionOutputVO() {}

	public RestrictionOutputVO(String ibflag, String pagerows, String portType, String portCd, String imdgCmptnAuthCd, String txtDesc) {
		this.portType = portType;
		this.ibflag = ibflag;
		this.portCd = portCd;
		this.imdgCmptnAuthCd = imdgCmptnAuthCd;
		this.txtDesc = txtDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_type", getPortType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("imdg_cmptn_auth_cd", getImdgCmptnAuthCd());
		this.hashColumns.put("txt_desc", getTxtDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_type", "portType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("imdg_cmptn_auth_cd", "imdgCmptnAuthCd");
		this.hashFields.put("txt_desc", "txtDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return portType
	 */
	public String getPortType() {
		return this.portType;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return imdgCmptnAuthCd
	 */
	public String getImdgCmptnAuthCd() {
		return this.imdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @return txtDesc
	 */
	public String getTxtDesc() {
		return this.txtDesc;
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
	 * @param portType
	 */
	public void setPortType(String portType) {
		this.portType = portType;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param imdgCmptnAuthCd
	 */
	public void setImdgCmptnAuthCd(String imdgCmptnAuthCd) {
		this.imdgCmptnAuthCd = imdgCmptnAuthCd;
	}
	
	/**
	 * Column Info
	 * @param txtDesc
	 */
	public void setTxtDesc(String txtDesc) {
		this.txtDesc = txtDesc;
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
		setPortType(JSPUtil.getParameter(request, "port_type", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setImdgCmptnAuthCd(JSPUtil.getParameter(request, "imdg_cmptn_auth_cd", ""));
		setTxtDesc(JSPUtil.getParameter(request, "txt_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RestrictionOutputVO[]
	 */
	public RestrictionOutputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RestrictionOutputVO[]
	 */
	public RestrictionOutputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RestrictionOutputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portType = (JSPUtil.getParameter(request, prefix	+ "port_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] imdgCmptnAuthCd = (JSPUtil.getParameter(request, prefix	+ "imdg_cmptn_auth_cd", length));
			String[] txtDesc = (JSPUtil.getParameter(request, prefix	+ "txt_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RestrictionOutputVO();
				if (portType[i] != null)
					model.setPortType(portType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (imdgCmptnAuthCd[i] != null)
					model.setImdgCmptnAuthCd(imdgCmptnAuthCd[i]);
				if (txtDesc[i] != null)
					model.setTxtDesc(txtDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRestrictionOutputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RestrictionOutputVO[]
	 */
	public RestrictionOutputVO[] getRestrictionOutputVOs(){
		RestrictionOutputVO[] vos = (RestrictionOutputVO[])models.toArray(new RestrictionOutputVO[models.size()]);
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
		this.portType = this.portType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCmptnAuthCd = this.imdgCmptnAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtDesc = this.txtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
