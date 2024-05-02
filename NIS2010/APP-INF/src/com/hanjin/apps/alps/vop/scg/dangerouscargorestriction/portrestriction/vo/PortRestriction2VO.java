/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortRestriction2VO.java
*@FileTitle : PortRestriction2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortRestriction2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortRestriction2VO> models = new ArrayList<PortRestriction2VO>();
	
	/* Column Info */
	private String loadType = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String dischargeDesc = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pass = null;
	/* Column Info */
	private String loadTypeDesc = null;
	/* Column Info */
	private String tsDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String restricRegyn = null;
	/* Column Info */
	private String passDesc = null;
	/* Column Info */
	private String imdgClssCdDesc = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String discharge = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String imdgUnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortRestriction2VO() {}

	public PortRestriction2VO(String ibflag, String pagerows, String restricRegyn, String imdgClssCd, String imdgClssCdDesc, String portCd, String imdgUnNo, String imdgUnNoSeq, String loadType, String discharge, String ts, String pass, String loadTypeDesc, String dischargeDesc, String tsDesc, String passDesc) {
		this.loadType = loadType;
		this.ts = ts;
		this.dischargeDesc = dischargeDesc;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.pagerows = pagerows;
		this.pass = pass;
		this.loadTypeDesc = loadTypeDesc;
		this.tsDesc = tsDesc;
		this.ibflag = ibflag;
		this.restricRegyn = restricRegyn;
		this.passDesc = passDesc;
		this.imdgClssCdDesc = imdgClssCdDesc;
		this.portCd = portCd;
		this.discharge = discharge;
		this.imdgClssCd = imdgClssCd;
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("load_type", getLoadType());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("discharge_desc", getDischargeDesc());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pass", getPass());
		this.hashColumns.put("load_type_desc", getLoadTypeDesc());
		this.hashColumns.put("ts_desc", getTsDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("restric_regyn", getRestricRegyn());
		this.hashColumns.put("pass_desc", getPassDesc());
		this.hashColumns.put("imdg_clss_cd_desc", getImdgClssCdDesc());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("discharge", getDischarge());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("load_type", "loadType");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("discharge_desc", "dischargeDesc");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pass", "pass");
		this.hashFields.put("load_type_desc", "loadTypeDesc");
		this.hashFields.put("ts_desc", "tsDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("restric_regyn", "restricRegyn");
		this.hashFields.put("pass_desc", "passDesc");
		this.hashFields.put("imdg_clss_cd_desc", "imdgClssCdDesc");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("discharge", "discharge");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return loadType
	 */
	public String getLoadType() {
		return this.loadType;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return dischargeDesc
	 */
	public String getDischargeDesc() {
		return this.dischargeDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
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
	 * @return pass
	 */
	public String getPass() {
		return this.pass;
	}
	
	/**
	 * Column Info
	 * @return loadTypeDesc
	 */
	public String getLoadTypeDesc() {
		return this.loadTypeDesc;
	}
	
	/**
	 * Column Info
	 * @return tsDesc
	 */
	public String getTsDesc() {
		return this.tsDesc;
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
	 * @return restricRegyn
	 */
	public String getRestricRegyn() {
		return this.restricRegyn;
	}
	
	/**
	 * Column Info
	 * @return passDesc
	 */
	public String getPassDesc() {
		return this.passDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCdDesc
	 */
	public String getImdgClssCdDesc() {
		return this.imdgClssCdDesc;
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
	 * @return discharge
	 */
	public String getDischarge() {
		return this.discharge;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
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
	 * @param loadType
	 */
	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param dischargeDesc
	 */
	public void setDischargeDesc(String dischargeDesc) {
		this.dischargeDesc = dischargeDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Column Info
	 * @param loadTypeDesc
	 */
	public void setLoadTypeDesc(String loadTypeDesc) {
		this.loadTypeDesc = loadTypeDesc;
	}
	
	/**
	 * Column Info
	 * @param tsDesc
	 */
	public void setTsDesc(String tsDesc) {
		this.tsDesc = tsDesc;
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
	 * @param restricRegyn
	 */
	public void setRestricRegyn(String restricRegyn) {
		this.restricRegyn = restricRegyn;
	}
	
	/**
	 * Column Info
	 * @param passDesc
	 */
	public void setPassDesc(String passDesc) {
		this.passDesc = passDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCdDesc
	 */
	public void setImdgClssCdDesc(String imdgClssCdDesc) {
		this.imdgClssCdDesc = imdgClssCdDesc;
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
	 * @param discharge
	 */
	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setLoadType(JSPUtil.getParameter(request, prefix + "load_type", ""));
		setTs(JSPUtil.getParameter(request, prefix + "ts", ""));
		setDischargeDesc(JSPUtil.getParameter(request, prefix + "discharge_desc", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPass(JSPUtil.getParameter(request, prefix + "pass", ""));
		setLoadTypeDesc(JSPUtil.getParameter(request, prefix + "load_type_desc", ""));
		setTsDesc(JSPUtil.getParameter(request, prefix + "ts_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRestricRegyn(JSPUtil.getParameter(request, prefix + "restric_regyn", ""));
		setPassDesc(JSPUtil.getParameter(request, prefix + "pass_desc", ""));
		setImdgClssCdDesc(JSPUtil.getParameter(request, prefix + "imdg_clss_cd_desc", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setDischarge(JSPUtil.getParameter(request, prefix + "discharge", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortRestriction2VO[]
	 */
	public PortRestriction2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortRestriction2VO[]
	 */
	public PortRestriction2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortRestriction2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] loadType = (JSPUtil.getParameter(request, prefix	+ "load_type", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] dischargeDesc = (JSPUtil.getParameter(request, prefix	+ "discharge_desc", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pass = (JSPUtil.getParameter(request, prefix	+ "pass", length));
			String[] loadTypeDesc = (JSPUtil.getParameter(request, prefix	+ "load_type_desc", length));
			String[] tsDesc = (JSPUtil.getParameter(request, prefix	+ "ts_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] restricRegyn = (JSPUtil.getParameter(request, prefix	+ "restric_regyn", length));
			String[] passDesc = (JSPUtil.getParameter(request, prefix	+ "pass_desc", length));
			String[] imdgClssCdDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd_desc", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] discharge = (JSPUtil.getParameter(request, prefix	+ "discharge", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortRestriction2VO();
				if (loadType[i] != null)
					model.setLoadType(loadType[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (dischargeDesc[i] != null)
					model.setDischargeDesc(dischargeDesc[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pass[i] != null)
					model.setPass(pass[i]);
				if (loadTypeDesc[i] != null)
					model.setLoadTypeDesc(loadTypeDesc[i]);
				if (tsDesc[i] != null)
					model.setTsDesc(tsDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (restricRegyn[i] != null)
					model.setRestricRegyn(restricRegyn[i]);
				if (passDesc[i] != null)
					model.setPassDesc(passDesc[i]);
				if (imdgClssCdDesc[i] != null)
					model.setImdgClssCdDesc(imdgClssCdDesc[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (discharge[i] != null)
					model.setDischarge(discharge[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortRestriction2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortRestriction2VO[]
	 */
	public PortRestriction2VO[] getPortRestriction2VOs(){
		PortRestriction2VO[] vos = (PortRestriction2VO[])models.toArray(new PortRestriction2VO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.loadType = this.loadType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dischargeDesc = this.dischargeDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pass = this.pass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadTypeDesc = this.loadTypeDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsDesc = this.tsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.restricRegyn = this.restricRegyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passDesc = this.passDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCdDesc = this.imdgClssCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discharge = this.discharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
