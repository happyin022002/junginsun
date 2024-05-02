/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreRestrictionPortVO.java
*@FileTitle : PreRestrictionPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.10 김현욱 
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

public class PreRestrictionPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreRestrictionPortVO> models = new ArrayList<PreRestrictionPortVO>();
	
	/* Column Info */
	private String portType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoSeq = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String imdgCmptnAuthDesc = null;
	/* Column Info */
	private String restrictionReq = null;
	/* Column Info */
	private String spclCntrSeq = null;
	/* Column Info */
	private String portRotnSeq = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String txtDesc = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreRestrictionPortVO() {}

	public PreRestrictionPortVO(String ibflag, String pagerows, String portType, String portCd, String imdgCmptnAuthDesc, String restrictionReq, String txtDesc, String spclCntrSeq, String spclCgoSeq, String imdgUnNo, String vvdCd, String imdgUnNoSeq, String portRotnSeq) {
		this.portType = portType;
		this.ibflag = ibflag;
		this.spclCgoSeq = spclCgoSeq;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.imdgCmptnAuthDesc = imdgCmptnAuthDesc;
		this.restrictionReq = restrictionReq;
		this.spclCntrSeq = spclCntrSeq;
		this.portRotnSeq = portRotnSeq;
		this.portCd = portCd;
		this.txtDesc = txtDesc;
		this.imdgUnNo = imdgUnNo;
		this.vvdCd = vvdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_type", getPortType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_seq", getSpclCgoSeq());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("imdg_cmptn_auth_desc", getImdgCmptnAuthDesc());
		this.hashColumns.put("restriction_req", getRestictionReq());
		this.hashColumns.put("spcl_cntr_seq", getSpclCntrSeq());
		this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("txt_desc", getTxtDesc());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
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
		this.hashFields.put("spcl_cgo_seq", "spclCgoSeq");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("imdg_cmptn_auth_desc", "imdgCmptnAuthDesc");
		this.hashFields.put("restriction_req", "restrictionReq");
		
		this.hashFields.put("spcl_cntr_seq", "spclCntrSeq");
		this.hashFields.put("port_rotn_seq", "portRotnSeq");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("txt_desc", "txtDesc");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("vvd_cd", "vvdCd");
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
	 * @return spclCgoSeq
	 */
	public String getSpclCgoSeq() {
		return this.spclCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgCmptnAuthDesc
	 */
	public String getImdgCmptnAuthDesc() {
		return this.imdgCmptnAuthDesc;
	}
	/**
	 * Column Info
	 * @return restictionReq
	 */
	public String getRestictionReq() {
		return this.restrictionReq;
	}
	
	/**
	 * Column Info
	 * @return spclCntrSeq
	 */
	public String getSpclCntrSeq() {
		return this.spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return portRotnSeq
	 */
	public String getPortRotnSeq() {
		return this.portRotnSeq;
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
	 * @return txtDesc
	 */
	public String getTxtDesc() {
		return this.txtDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @param spclCgoSeq
	 */
	public void setSpclCgoSeq(String spclCgoSeq) {
		this.spclCgoSeq = spclCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgCmptnAuthDesc
	 */
	public void setImdgCmptnAuthDesc(String imdgCmptnAuthDesc) {
		this.imdgCmptnAuthDesc = imdgCmptnAuthDesc;
	}
	/**
	 * Column Info
	 * @param restrictionReq
	 */
	public void setRestrictionReq(String restrictionReq) {
		this.restrictionReq = restrictionReq;
	}
	
	/**
	 * Column Info
	 * @param spclCntrSeq
	 */
	public void setSpclCntrSeq(String spclCntrSeq) {
		this.spclCntrSeq = spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param portRotnSeq
	 */
	public void setPortRotnSeq(String portRotnSeq) {
		this.portRotnSeq = portRotnSeq;
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
	 * @param txtDesc
	 */
	public void setTxtDesc(String txtDesc) {
		this.txtDesc = txtDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
		setSpclCgoSeq(JSPUtil.getParameter(request, "spcl_cgo_seq", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setImdgCmptnAuthDesc(JSPUtil.getParameter(request, "imdg_cmptn_auth_desc", ""));
		setRestrictionReq(JSPUtil.getParameter(request, "restriction_req", ""));
		setSpclCntrSeq(JSPUtil.getParameter(request, "spcl_cntr_seq", ""));
		setPortRotnSeq(JSPUtil.getParameter(request, "port_rotn_seq", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setTxtDesc(JSPUtil.getParameter(request, "txt_desc", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreRestrictionPortVO[]
	 */
	public PreRestrictionPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreRestrictionPortVO[]
	 */
	public PreRestrictionPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreRestrictionPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portType = (JSPUtil.getParameter(request, prefix	+ "port_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_seq", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] imdgCmptnAuthDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_cmptn_auth_desc", length));
			String[] restrictionReq = (JSPUtil.getParameter(request, prefix	+ "restriction_req", length));
			String[] spclCntrSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_seq", length));
			String[] portRotnSeq = (JSPUtil.getParameter(request, prefix	+ "port_rotn_seq", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] txtDesc = (JSPUtil.getParameter(request, prefix	+ "txt_desc", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreRestrictionPortVO();
				if (portType[i] != null)
					model.setPortType(portType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoSeq[i] != null)
					model.setSpclCgoSeq(spclCgoSeq[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (imdgCmptnAuthDesc[i] != null)
					model.setImdgCmptnAuthDesc(imdgCmptnAuthDesc[i]);
				if (restrictionReq[i] != null)
					model.setRestrictionReq(restrictionReq[i]);
				if (spclCntrSeq[i] != null)
					model.setSpclCntrSeq(spclCntrSeq[i]);
				if (portRotnSeq[i] != null)
					model.setPortRotnSeq(portRotnSeq[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (txtDesc[i] != null)
					model.setTxtDesc(txtDesc[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreRestrictionPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreRestrictionPortVO[]
	 */
	public PreRestrictionPortVO[] getPreRestrictionPortVOs(){
		PreRestrictionPortVO[] vos = (PreRestrictionPortVO[])models.toArray(new PreRestrictionPortVO[models.size()]);
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
		this.spclCgoSeq = this.spclCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCmptnAuthDesc = this.imdgCmptnAuthDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.restrictionReq = this.restrictionReq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrSeq = this.spclCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRotnSeq = this.portRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtDesc = this.txtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
