/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MissingTDRCondVO.java
*@FileTitle : MissingTDRCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.01.04 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MissingTDRCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MissingTDRCondVO> models = new ArrayList<MissingTDRCondVO>();
	
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String exTprFlg = null;
	/* Column Info */
	private String svcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String tdrFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MissingTDRCondVO() {}

	public MissingTDRCondVO(String ibflag, String pagerows, String frDt, String toDt, String rhqOfcCd, String portCd, String slanCd, String crrCd, String tdrFlg, String svcTpCd, String exTprFlg, String vslCd, String skdVoyNo, String skdDirCd) {
		this.rhqOfcCd = rhqOfcCd;
		this.toDt = toDt;
		this.exTprFlg = exTprFlg;
		this.svcTpCd = svcTpCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.portCd = portCd;
		this.frDt = frDt;
		this.crrCd = crrCd;
		this.tdrFlg = tdrFlg;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ex_tpr_flg", getExTprFlg());
		this.hashColumns.put("svc_tp_cd", getSvcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("tdr_flg", getTdrFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ex_tpr_flg", "exTprFlg");
		this.hashFields.put("svc_tp_cd", "svcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("tdr_flg", "tdrFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return exTprFlg
	 */
	public String getExTprFlg() {
		return this.exTprFlg;
	}
	
	/**
	 * Column Info
	 * @return svcTpCd
	 */
	public String getSvcTpCd() {
		return this.svcTpCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return portCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return tdrFlg
	 */
	public String getTdrFlg() {
		return this.tdrFlg;
	}

	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param exTprFlg
	 */
	public void setExTprFlg(String exTprFlg) {
		this.exTprFlg = exTprFlg;
	}
	
	/**
	 * Column Info
	 * @param svcTpCd
	 */
	public void setSvcTpCd(String svcTpCd) {
		this.svcTpCd = svcTpCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param portCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param tdrFlg
	 */
	public void setTdrFlg(String tdrFlg) {
		this.tdrFlg = tdrFlg;
	}

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setExTprFlg(JSPUtil.getParameter(request, prefix + "ex_tpr_flg", ""));
		setSvcTpCd(JSPUtil.getParameter(request, prefix + "svc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setFrDt(JSPUtil.getParameter(request, prefix + "fr_dt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setTdrFlg(JSPUtil.getParameter(request, prefix + "tdr_flg", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MissingTDRCondVO[]
	 */
	public MissingTDRCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MissingTDRCondVO[]
	 */
	public MissingTDRCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MissingTDRCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] exTprFlg = (JSPUtil.getParameter(request, prefix	+ "ex_tpr_flg", length));
			String[] svcTpCd = (JSPUtil.getParameter(request, prefix	+ "svc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] tdrFlg = (JSPUtil.getParameter(request, prefix	+ "tdr_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MissingTDRCondVO();
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (exTprFlg[i] != null)
					model.setExTprFlg(exTprFlg[i]);
				if (svcTpCd[i] != null)
					model.setSvcTpCd(svcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (tdrFlg[i] != null)
					model.setTdrFlg(tdrFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMissingTDRCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MissingTDRCondVO[]
	 */
	public MissingTDRCondVO[] getMissingTDRCondVOs(){
		MissingTDRCondVO[] vos = (MissingTDRCondVO[])models.toArray(new MissingTDRCondVO[models.size()]);
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
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exTprFlg = this.exTprFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTpCd = this.svcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tdrFlg = this.tdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
