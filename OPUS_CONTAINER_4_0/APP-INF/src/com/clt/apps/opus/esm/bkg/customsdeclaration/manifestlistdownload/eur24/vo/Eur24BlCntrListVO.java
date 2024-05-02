/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24BlCntrListVO.java
*@FileTitle : Eur24BlCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24BlCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlCntrListVO> models = new ArrayList<Eur24BlCntrListVO>();
	
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sealNo2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String cstmsPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24BlCntrListVO() {}

	public Eur24BlCntrListVO(String ibflag, String pagerows, String vvd, String blNo, String cstmsPortCd, String cntrNo, String fullMtyCd, String pckQty, String pckTpCd, String measQty, String measUtCd, String actWgt, String wgtUtCd, String cntrTpszCd, String cmdtDesc, String sealNo, String sealNo2) {
		this.sealNo = sealNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.actWgt = actWgt;
		this.vvd = vvd;
		this.sealNo2 = sealNo2;
		this.ibflag = ibflag;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.measQty = measQty;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.fullMtyCd = fullMtyCd;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("seal_no2", getSealNo2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("seal_no2", "sealNo2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
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
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return sealNo2
	 */
	public String getSealNo2() {
		return this.sealNo2;
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
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	

	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
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
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param sealNo2
	 */
	public void setSealNo2(String sealNo2) {
		this.sealNo2 = sealNo2;
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
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
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
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSealNo2(JSPUtil.getParameter(request, prefix + "seal_no2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlCntrListVO[]
	 */
	public Eur24BlCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlCntrListVO[]
	 */
	public Eur24BlCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sealNo2 = (JSPUtil.getParameter(request, prefix	+ "seal_no2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlCntrListVO();
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sealNo2[i] != null)
					model.setSealNo2(sealNo2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlCntrListVO[]
	 */
	public Eur24BlCntrListVO[] getEur24BlCntrListVOs(){
		Eur24BlCntrListVO[] vos = (Eur24BlCntrListVO[])models.toArray(new Eur24BlCntrListVO[models.size()]);
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
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo2 = this.sealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
