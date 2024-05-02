/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaSearchVesselArrivalVO.java
*@FileTitle : SriLankaSearchVesselArrivalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SriLankaSearchVesselArrivalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaSearchVesselArrivalVO> models = new ArrayList<SriLankaSearchVesselArrivalVO>();
	
	/* Column Info */
	private String vslFullname = null;
	/* Column Info */
	private String arvlTm = null;
	/* Column Info */
	private String deptPort = null;
	/* Column Info */
	private String vslflg = null;
	/* Column Info */
	private String shpAgt = null;
	/* Column Info */
	private String voyageCode = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deptDt = null;
	/* Column Info */
	private String captNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arvlDt = null;
	/* Column Info */
	private String fileName = null;
	/* Column Info */
	private String shpAgt2 = null;
	/* Column Info */
	private String arvlPort = null;
	/* Column Info */
	private String deptTm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SriLankaSearchVesselArrivalVO() {}

	public SriLankaSearchVesselArrivalVO(String ibflag, String pagerows, String vslFullname, String arvlTm, String deptPort, String vslflg, String shpAgt, String voyageCode, String deptDt, String captNm, String arvlDt, String fileName, String shpAgt2, String arvlPort, String deptTm, String ioBndCd) {
		this.vslFullname = vslFullname;
		this.arvlTm = arvlTm;
		this.deptPort = deptPort;
		this.vslflg = vslflg;
		this.shpAgt = shpAgt;
		this.voyageCode = voyageCode;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.deptDt = deptDt;
		this.captNm = captNm;
		this.ibflag = ibflag;
		this.arvlDt = arvlDt;
		this.fileName = fileName;
		this.shpAgt2 = shpAgt2;
		this.arvlPort = arvlPort;
		this.deptTm = deptTm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("arvl_tm", getArvlTm());
		this.hashColumns.put("dept_port", getDeptPort());
		this.hashColumns.put("vslflg", getVslflg());
		this.hashColumns.put("shp_agt", getShpAgt());
		this.hashColumns.put("voyage_code", getVoyageCode());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dept_dt", getDeptDt());
		this.hashColumns.put("capt_nm", getCaptNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("arvl_dt", getArvlDt());
		this.hashColumns.put("file_name", getFileName());
		this.hashColumns.put("shp_agt2", getShpAgt2());
		this.hashColumns.put("arvl_port", getArvlPort());
		this.hashColumns.put("dept_tm", getDeptTm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("arvl_tm", "arvlTm");
		this.hashFields.put("dept_port", "deptPort");
		this.hashFields.put("vslflg", "vslflg");
		this.hashFields.put("shp_agt", "shpAgt");
		this.hashFields.put("voyage_code", "voyageCode");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dept_dt", "deptDt");
		this.hashFields.put("capt_nm", "captNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("arvl_dt", "arvlDt");
		this.hashFields.put("file_name", "fileName");
		this.hashFields.put("shp_agt2", "shpAgt2");
		this.hashFields.put("arvl_port", "arvlPort");
		this.hashFields.put("dept_tm", "deptTm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
	}
	
	/**
	 * Column Info
	 * @return arvlTm
	 */
	public String getArvlTm() {
		return this.arvlTm;
	}
	
	/**
	 * Column Info
	 * @return deptPort
	 */
	public String getDeptPort() {
		return this.deptPort;
	}
	
	/**
	 * Column Info
	 * @return vslflg
	 */
	public String getVslflg() {
		return this.vslflg;
	}
	
	/**
	 * Column Info
	 * @return shpAgt
	 */
	public String getShpAgt() {
		return this.shpAgt;
	}
	
	/**
	 * Column Info
	 * @return voyageCode
	 */
	public String getVoyageCode() {
		return this.voyageCode;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return deptDt
	 */
	public String getDeptDt() {
		return this.deptDt;
	}
	
	/**
	 * Column Info
	 * @return captNm
	 */
	public String getCaptNm() {
		return this.captNm;
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
	 * @return arvlDt
	 */
	public String getArvlDt() {
		return this.arvlDt;
	}
	
	/**
	 * Column Info
	 * @return fileName
	 */
	public String getFileName() {
		return this.fileName;
	}
	
	/**
	 * Column Info
	 * @return shpAgt2
	 */
	public String getShpAgt2() {
		return this.shpAgt2;
	}
	
	/**
	 * Column Info
	 * @return arvlPort
	 */
	public String getArvlPort() {
		return this.arvlPort;
	}
	
	/**
	 * Column Info
	 * @return deptTm
	 */
	public String getDeptTm() {
		return this.deptTm;
	}
	

	/**
	 * Column Info
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
	}
	
	/**
	 * Column Info
	 * @param arvlTm
	 */
	public void setArvlTm(String arvlTm) {
		this.arvlTm = arvlTm;
	}
	
	/**
	 * Column Info
	 * @param deptPort
	 */
	public void setDeptPort(String deptPort) {
		this.deptPort = deptPort;
	}
	
	/**
	 * Column Info
	 * @param vslflg
	 */
	public void setVslflg(String vslflg) {
		this.vslflg = vslflg;
	}
	
	/**
	 * Column Info
	 * @param shpAgt
	 */
	public void setShpAgt(String shpAgt) {
		this.shpAgt = shpAgt;
	}
	
	/**
	 * Column Info
	 * @param voyageCode
	 */
	public void setVoyageCode(String voyageCode) {
		this.voyageCode = voyageCode;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param deptDt
	 */
	public void setDeptDt(String deptDt) {
		this.deptDt = deptDt;
	}
	
	/**
	 * Column Info
	 * @param captNm
	 */
	public void setCaptNm(String captNm) {
		this.captNm = captNm;
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
	 * @param arvlDt
	 */
	public void setArvlDt(String arvlDt) {
		this.arvlDt = arvlDt;
	}
	
	/**
	 * Column Info
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Column Info
	 * @param shpAgt2
	 */
	public void setShpAgt2(String shpAgt2) {
		this.shpAgt2 = shpAgt2;
	}
	
	/**
	 * Column Info
	 * @param arvlPort
	 */
	public void setArvlPort(String arvlPort) {
		this.arvlPort = arvlPort;
	}
	
	/**
	 * Column Info
	 * @param deptTm
	 */
	public void setDeptTm(String deptTm) {
		this.deptTm = deptTm;
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
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setArvlTm(JSPUtil.getParameter(request, prefix + "arvl_tm", ""));
		setDeptPort(JSPUtil.getParameter(request, prefix + "dept_port", ""));
		setVslflg(JSPUtil.getParameter(request, prefix + "vslflg", ""));
		setShpAgt(JSPUtil.getParameter(request, prefix + "shp_agt", ""));
		setVoyageCode(JSPUtil.getParameter(request, prefix + "voyage_code", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDeptDt(JSPUtil.getParameter(request, prefix + "dept_dt", ""));
		setCaptNm(JSPUtil.getParameter(request, prefix + "capt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArvlDt(JSPUtil.getParameter(request, prefix + "arvl_dt", ""));
		setFileName(JSPUtil.getParameter(request, prefix + "file_name", ""));
		setShpAgt2(JSPUtil.getParameter(request, prefix + "shp_agt2", ""));
		setArvlPort(JSPUtil.getParameter(request, prefix + "arvl_port", ""));
		setDeptTm(JSPUtil.getParameter(request, prefix + "dept_tm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaSearchVesselArrivalVO[]
	 */
	public SriLankaSearchVesselArrivalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaSearchVesselArrivalVO[]
	 */
	public SriLankaSearchVesselArrivalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaSearchVesselArrivalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] arvlTm = (JSPUtil.getParameter(request, prefix	+ "arvl_tm", length));
			String[] deptPort = (JSPUtil.getParameter(request, prefix	+ "dept_port", length));
			String[] vslflg = (JSPUtil.getParameter(request, prefix	+ "vslflg", length));
			String[] shpAgt = (JSPUtil.getParameter(request, prefix	+ "shp_agt", length));
			String[] voyageCode = (JSPUtil.getParameter(request, prefix	+ "voyage_code", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deptDt = (JSPUtil.getParameter(request, prefix	+ "dept_dt", length));
			String[] captNm = (JSPUtil.getParameter(request, prefix	+ "capt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arvlDt = (JSPUtil.getParameter(request, prefix	+ "arvl_dt", length));
			String[] fileName = (JSPUtil.getParameter(request, prefix	+ "file_name", length));
			String[] shpAgt2 = (JSPUtil.getParameter(request, prefix	+ "shp_agt2", length));
			String[] arvlPort = (JSPUtil.getParameter(request, prefix	+ "arvl_port", length));
			String[] deptTm = (JSPUtil.getParameter(request, prefix	+ "dept_tm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaSearchVesselArrivalVO();
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (arvlTm[i] != null)
					model.setArvlTm(arvlTm[i]);
				if (deptPort[i] != null)
					model.setDeptPort(deptPort[i]);
				if (vslflg[i] != null)
					model.setVslflg(vslflg[i]);
				if (shpAgt[i] != null)
					model.setShpAgt(shpAgt[i]);
				if (voyageCode[i] != null)
					model.setVoyageCode(voyageCode[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deptDt[i] != null)
					model.setDeptDt(deptDt[i]);
				if (captNm[i] != null)
					model.setCaptNm(captNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arvlDt[i] != null)
					model.setArvlDt(arvlDt[i]);
				if (fileName[i] != null)
					model.setFileName(fileName[i]);
				if (shpAgt2[i] != null)
					model.setShpAgt2(shpAgt2[i]);
				if (arvlPort[i] != null)
					model.setArvlPort(arvlPort[i]);
				if (deptTm[i] != null)
					model.setDeptTm(deptTm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaSearchVesselArrivalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaSearchVesselArrivalVO[]
	 */
	public SriLankaSearchVesselArrivalVO[] getSriLankaSearchVesselArrivalVOs(){
		SriLankaSearchVesselArrivalVO[] vos = (SriLankaSearchVesselArrivalVO[])models.toArray(new SriLankaSearchVesselArrivalVO[models.size()]);
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
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arvlTm = this.arvlTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptPort = this.deptPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslflg = this.vslflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpAgt = this.shpAgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyageCode = this.voyageCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptDt = this.deptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.captNm = this.captNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arvlDt = this.arvlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileName = this.fileName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpAgt2 = this.shpAgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arvlPort = this.arvlPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptTm = this.deptTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
