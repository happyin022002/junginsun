/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaVslRgstVO.java
*@FileTitle : ChinaVslRgstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.07.01 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaVslRgstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaVslRgstVO> models = new ArrayList<ChinaVslRgstVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String obSkdVoyNo = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String searchDiv = null;
	/* Column Info */
	private String ibSkdVoyNo = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String mfRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String obSkdDirNm = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String ibSkdDirNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChinaVslRgstVO() {}

	public ChinaVslRgstVO(String ibflag, String pagerows, String searchDiv, String portCd, String dateFm, String dateTo, String vvd, String slanCd, String crrCd, String vslEngNm, String lloydNo, String vslCd, String ibSkdVoyNo, String ibSkdDirNm, String obSkdVoyNo, String obSkdDirNm, String etaDt, String etbDt, String etdDt, String mfRmk, String usrId) {
		this.dateFm = dateFm;
		this.vslCd = vslCd;
		this.obSkdVoyNo = obSkdVoyNo;
		this.etaDt = etaDt;
		this.dateTo = dateTo;
		this.searchDiv = searchDiv;
		this.ibSkdVoyNo = ibSkdVoyNo;
		this.etdDt = etdDt;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.mfRmk = mfRmk;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.lloydNo = lloydNo;
		this.vslEngNm = vslEngNm;
		this.usrId = usrId;
		this.obSkdDirNm = obSkdDirNm;
		this.etbDt = etbDt;
		this.portCd = portCd;
		this.ibSkdDirNm = ibSkdDirNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ob_skd_voy_no", getObSkdVoyNo());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("search_div", getSearchDiv());
		this.hashColumns.put("ib_skd_voy_no", getIbSkdVoyNo());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("mf_rmk", getMfRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ob_skd_dir_nm", getObSkdDirNm());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("ib_skd_dir_nm", getIbSkdDirNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ob_skd_voy_no", "obSkdVoyNo");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("search_div", "searchDiv");
		this.hashFields.put("ib_skd_voy_no", "ibSkdVoyNo");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("mf_rmk", "mfRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ob_skd_dir_nm", "obSkdDirNm");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("ib_skd_dir_nm", "ibSkdDirNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
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
	 * @return obSkdVoyNo
	 */
	public String getObSkdVoyNo() {
		return this.obSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return searchDiv
	 */
	public String getSearchDiv() {
		return this.searchDiv;
	}
	
	/**
	 * Column Info
	 * @return ibSkdVoyNo
	 */
	public String getIbSkdVoyNo() {
		return this.ibSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return mfRmk
	 */
	public String getMfRmk() {
		return this.mfRmk;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return obSkdDirNm
	 */
	public String getObSkdDirNm() {
		return this.obSkdDirNm;
	}
	
	/**
	 * Column Info
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
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
	 * @return ibSkdDirNm
	 */
	public String getIbSkdDirNm() {
		return this.ibSkdDirNm;
	}
	

	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
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
	 * @param obSkdVoyNo
	 */
	public void setObSkdVoyNo(String obSkdVoyNo) {
		this.obSkdVoyNo = obSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param searchDiv
	 */
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}
	
	/**
	 * Column Info
	 * @param ibSkdVoyNo
	 */
	public void setIbSkdVoyNo(String ibSkdVoyNo) {
		this.ibSkdVoyNo = ibSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param mfRmk
	 */
	public void setMfRmk(String mfRmk) {
		this.mfRmk = mfRmk;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param obSkdDirNm
	 */
	public void setObSkdDirNm(String obSkdDirNm) {
		this.obSkdDirNm = obSkdDirNm;
	}
	
	/**
	 * Column Info
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
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
	 * @param ibSkdDirNm
	 */
	public void setIbSkdDirNm(String ibSkdDirNm) {
		this.ibSkdDirNm = ibSkdDirNm;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setObSkdVoyNo(JSPUtil.getParameter(request, prefix + "ob_skd_voy_no", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setSearchDiv(JSPUtil.getParameter(request, prefix + "search_div", ""));
		setIbSkdVoyNo(JSPUtil.getParameter(request, prefix + "ib_skd_voy_no", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setMfRmk(JSPUtil.getParameter(request, prefix + "mf_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setObSkdDirNm(JSPUtil.getParameter(request, prefix + "ob_skd_dir_nm", ""));
		setEtbDt(JSPUtil.getParameter(request, prefix + "etb_dt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setIbSkdDirNm(JSPUtil.getParameter(request, prefix + "ib_skd_dir_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaVslRgstVO[]
	 */
	public ChinaVslRgstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaVslRgstVO[]
	 */
	public ChinaVslRgstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaVslRgstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] obSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ob_skd_voy_no", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] searchDiv = (JSPUtil.getParameter(request, prefix	+ "search_div", length));
			String[] ibSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_skd_voy_no", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] mfRmk = (JSPUtil.getParameter(request, prefix	+ "mf_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] obSkdDirNm = (JSPUtil.getParameter(request, prefix	+ "ob_skd_dir_nm", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] ibSkdDirNm = (JSPUtil.getParameter(request, prefix	+ "ib_skd_dir_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaVslRgstVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (obSkdVoyNo[i] != null)
					model.setObSkdVoyNo(obSkdVoyNo[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (searchDiv[i] != null)
					model.setSearchDiv(searchDiv[i]);
				if (ibSkdVoyNo[i] != null)
					model.setIbSkdVoyNo(ibSkdVoyNo[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (mfRmk[i] != null)
					model.setMfRmk(mfRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (obSkdDirNm[i] != null)
					model.setObSkdDirNm(obSkdDirNm[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ibSkdDirNm[i] != null)
					model.setIbSkdDirNm(ibSkdDirNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaVslRgstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaVslRgstVO[]
	 */
	public ChinaVslRgstVO[] getChinaVslRgstVOs(){
		ChinaVslRgstVO[] vos = (ChinaVslRgstVO[])models.toArray(new ChinaVslRgstVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSkdVoyNo = this.obSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDiv = this.searchDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSkdVoyNo = this.ibSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRmk = this.mfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSkdDirNm = this.obSkdDirNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSkdDirNm = this.ibSkdDirNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
