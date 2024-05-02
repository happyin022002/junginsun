/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PkupNtcSearchVO.java
*@FileTitle : PkupNtcSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.05.04 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PkupNtcSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNtcSearchVO> models = new ArrayList<PkupNtcSearchVO>();
	
	/* Column Info */
	private String contactFlag = null;
	/* Column Info */
	private String focTpCd = null;
	/* Column Info */
	private String dtMvmtE = null;
	/* Column Info */
	private String sndStsCd = null;
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String stopFlag = null;
	/* Column Info */
	private String dtTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String dtS = null;
	/* Column Info */
	private String tmMvmtS = null;
	/* Column Info */
	private String eqOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String railCoCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String dtMvmtS = null;
	/* Column Info */
	private String schTpCd = null;
	/* Column Info */
	private String ntcTpCd = null;
	/* Column Info */
	private String owFlag = null;
	/* Column Info */
	private String dtE = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String tmMvmtE = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNtcSearchVO() {}

	public PkupNtcSearchVO(String ibflag, String pagerows, String schTpCd, String dtTpCd, String dtS, String dtE, String mvmtCd, String dtMvmtS, String dtMvmtE, String tmMvmtS, String tmMvmtE, String eqOfcCd, String updUsrId, String blNo, String sndStsCd, String ntcTpCd, String focTpCd, String owFlag, String stopFlag, String contactFlag, String usrOfcCd, String railCoCd) {
		this.contactFlag = contactFlag;
		this.focTpCd = focTpCd;
		this.dtMvmtE = dtMvmtE;
		this.sndStsCd = sndStsCd;
		this.mvmtCd = mvmtCd;
		this.stopFlag = stopFlag;
		this.dtTpCd = dtTpCd;
		this.blNo = blNo;
		this.dtS = dtS;
		this.tmMvmtS = tmMvmtS;
		this.eqOfcCd = eqOfcCd;
		this.pagerows = pagerows;
		this.railCoCd = railCoCd;
		this.ibflag = ibflag;
		this.usrOfcCd = usrOfcCd;
		this.dtMvmtS = dtMvmtS;
		this.schTpCd = schTpCd;
		this.ntcTpCd = ntcTpCd;
		this.owFlag = owFlag;
		this.dtE = dtE;
		this.updUsrId = updUsrId;
		this.tmMvmtE = tmMvmtE;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("contact_flag", getContactFlag());
		this.hashColumns.put("foc_tp_cd", getFocTpCd());
		this.hashColumns.put("dt_mvmt_e", getDtMvmtE());
		this.hashColumns.put("snd_sts_cd", getSndStsCd());
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("stop_flag", getStopFlag());
		this.hashColumns.put("dt_tp_cd", getDtTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("dt_s", getDtS());
		this.hashColumns.put("tm_mvmt_s", getTmMvmtS());
		this.hashColumns.put("eq_ofc_cd", getEqOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rail_co_cd", getRailCoCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("dt_mvmt_s", getDtMvmtS());
		this.hashColumns.put("sch_tp_cd", getSchTpCd());
		this.hashColumns.put("ntc_tp_cd", getNtcTpCd());
		this.hashColumns.put("ow_flag", getOwFlag());
		this.hashColumns.put("dt_e", getDtE());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tm_mvmt_e", getTmMvmtE());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("contact_flag", "contactFlag");
		this.hashFields.put("foc_tp_cd", "focTpCd");
		this.hashFields.put("dt_mvmt_e", "dtMvmtE");
		this.hashFields.put("snd_sts_cd", "sndStsCd");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("stop_flag", "stopFlag");
		this.hashFields.put("dt_tp_cd", "dtTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("dt_s", "dtS");
		this.hashFields.put("tm_mvmt_s", "tmMvmtS");
		this.hashFields.put("eq_ofc_cd", "eqOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rail_co_cd", "railCoCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("dt_mvmt_s", "dtMvmtS");
		this.hashFields.put("sch_tp_cd", "schTpCd");
		this.hashFields.put("ntc_tp_cd", "ntcTpCd");
		this.hashFields.put("ow_flag", "owFlag");
		this.hashFields.put("dt_e", "dtE");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tm_mvmt_e", "tmMvmtE");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return contactFlag
	 */
	public String getContactFlag() {
		return this.contactFlag;
	}
	
	/**
	 * Column Info
	 * @return focTpCd
	 */
	public String getFocTpCd() {
		return this.focTpCd;
	}
	
	/**
	 * Column Info
	 * @return dtMvmtE
	 */
	public String getDtMvmtE() {
		return this.dtMvmtE;
	}
	
	/**
	 * Column Info
	 * @return sndStsCd
	 */
	public String getSndStsCd() {
		return this.sndStsCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtCd
	 */
	public String getMvmtCd() {
		return this.mvmtCd;
	}
	
	/**
	 * Column Info
	 * @return stopFlag
	 */
	public String getStopFlag() {
		return this.stopFlag;
	}
	
	/**
	 * Column Info
	 * @return dtTpCd
	 */
	public String getDtTpCd() {
		return this.dtTpCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return dtS
	 */
	public String getDtS() {
		return this.dtS;
	}
	
	/**
	 * Column Info
	 * @return tmMvmtS
	 */
	public String getTmMvmtS() {
		return this.tmMvmtS;
	}
	
	/**
	 * Column Info
	 * @return eqOfcCd
	 */
	public String getEqOfcCd() {
		return this.eqOfcCd;
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
	 * @return railCoCd
	 */
	public String getRailCoCd() {
		return this.railCoCd;
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
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dtMvmtS
	 */
	public String getDtMvmtS() {
		return this.dtMvmtS;
	}
	
	/**
	 * Column Info
	 * @return schTpCd
	 */
	public String getSchTpCd() {
		return this.schTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntcTpCd
	 */
	public String getNtcTpCd() {
		return this.ntcTpCd;
	}
	
	/**
	 * Column Info
	 * @return owFlag
	 */
	public String getOwFlag() {
		return this.owFlag;
	}
	
	/**
	 * Column Info
	 * @return dtE
	 */
	public String getDtE() {
		return this.dtE;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return tmMvmtE
	 */
	public String getTmMvmtE() {
		return this.tmMvmtE;
	}
	

	/**
	 * Column Info
	 * @param contactFlag
	 */
	public void setContactFlag(String contactFlag) {
		this.contactFlag = contactFlag;
	}
	
	/**
	 * Column Info
	 * @param focTpCd
	 */
	public void setFocTpCd(String focTpCd) {
		this.focTpCd = focTpCd;
	}
	
	/**
	 * Column Info
	 * @param dtMvmtE
	 */
	public void setDtMvmtE(String dtMvmtE) {
		this.dtMvmtE = dtMvmtE;
	}
	
	/**
	 * Column Info
	 * @param sndStsCd
	 */
	public void setSndStsCd(String sndStsCd) {
		this.sndStsCd = sndStsCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtCd
	 */
	public void setMvmtCd(String mvmtCd) {
		this.mvmtCd = mvmtCd;
	}
	
	/**
	 * Column Info
	 * @param stopFlag
	 */
	public void setStopFlag(String stopFlag) {
		this.stopFlag = stopFlag;
	}
	
	/**
	 * Column Info
	 * @param dtTpCd
	 */
	public void setDtTpCd(String dtTpCd) {
		this.dtTpCd = dtTpCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param dtS
	 */
	public void setDtS(String dtS) {
		this.dtS = dtS;
	}
	
	/**
	 * Column Info
	 * @param tmMvmtS
	 */
	public void setTmMvmtS(String tmMvmtS) {
		this.tmMvmtS = tmMvmtS;
	}
	
	/**
	 * Column Info
	 * @param eqOfcCd
	 */
	public void setEqOfcCd(String eqOfcCd) {
		this.eqOfcCd = eqOfcCd;
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
	 * @param railCoCd
	 */
	public void setRailCoCd(String railCoCd) {
		this.railCoCd = railCoCd;
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
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dtMvmtS
	 */
	public void setDtMvmtS(String dtMvmtS) {
		this.dtMvmtS = dtMvmtS;
	}
	
	/**
	 * Column Info
	 * @param schTpCd
	 */
	public void setSchTpCd(String schTpCd) {
		this.schTpCd = schTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntcTpCd
	 */
	public void setNtcTpCd(String ntcTpCd) {
		this.ntcTpCd = ntcTpCd;
	}
	
	/**
	 * Column Info
	 * @param owFlag
	 */
	public void setOwFlag(String owFlag) {
		this.owFlag = owFlag;
	}
	
	/**
	 * Column Info
	 * @param dtE
	 */
	public void setDtE(String dtE) {
		this.dtE = dtE;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param tmMvmtE
	 */
	public void setTmMvmtE(String tmMvmtE) {
		this.tmMvmtE = tmMvmtE;
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
		setContactFlag(JSPUtil.getParameter(request, prefix + "contact_flag", ""));
		setFocTpCd(JSPUtil.getParameter(request, prefix + "foc_tp_cd", ""));
		setDtMvmtE(JSPUtil.getParameter(request, prefix + "dt_mvmt_e", ""));
		setSndStsCd(JSPUtil.getParameter(request, prefix + "snd_sts_cd", ""));
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setStopFlag(JSPUtil.getParameter(request, prefix + "stop_flag", ""));
		setDtTpCd(JSPUtil.getParameter(request, prefix + "dt_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setDtS(JSPUtil.getParameter(request, prefix + "dt_s", ""));
		setTmMvmtS(JSPUtil.getParameter(request, prefix + "tm_mvmt_s", ""));
		setEqOfcCd(JSPUtil.getParameter(request, prefix + "eq_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRailCoCd(JSPUtil.getParameter(request, prefix + "rail_co_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setDtMvmtS(JSPUtil.getParameter(request, prefix + "dt_mvmt_s", ""));
		setSchTpCd(JSPUtil.getParameter(request, prefix + "sch_tp_cd", ""));
		setNtcTpCd(JSPUtil.getParameter(request, prefix + "ntc_tp_cd", ""));
		setOwFlag(JSPUtil.getParameter(request, prefix + "ow_flag", ""));
		setDtE(JSPUtil.getParameter(request, prefix + "dt_e", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTmMvmtE(JSPUtil.getParameter(request, prefix + "tm_mvmt_e", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNtcSearchVO[]
	 */
	public PkupNtcSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNtcSearchVO[]
	 */
	public PkupNtcSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNtcSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contactFlag = (JSPUtil.getParameter(request, prefix	+ "contact_flag", length));
			String[] focTpCd = (JSPUtil.getParameter(request, prefix	+ "foc_tp_cd", length));
			String[] dtMvmtE = (JSPUtil.getParameter(request, prefix	+ "dt_mvmt_e", length));
			String[] sndStsCd = (JSPUtil.getParameter(request, prefix	+ "snd_sts_cd", length));
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] stopFlag = (JSPUtil.getParameter(request, prefix	+ "stop_flag", length));
			String[] dtTpCd = (JSPUtil.getParameter(request, prefix	+ "dt_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] dtS = (JSPUtil.getParameter(request, prefix	+ "dt_s", length));
			String[] tmMvmtS = (JSPUtil.getParameter(request, prefix	+ "tm_mvmt_s", length));
			String[] eqOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] railCoCd = (JSPUtil.getParameter(request, prefix	+ "rail_co_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] dtMvmtS = (JSPUtil.getParameter(request, prefix	+ "dt_mvmt_s", length));
			String[] schTpCd = (JSPUtil.getParameter(request, prefix	+ "sch_tp_cd", length));
			String[] ntcTpCd = (JSPUtil.getParameter(request, prefix	+ "ntc_tp_cd", length));
			String[] owFlag = (JSPUtil.getParameter(request, prefix	+ "ow_flag", length));
			String[] dtE = (JSPUtil.getParameter(request, prefix	+ "dt_e", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] tmMvmtE = (JSPUtil.getParameter(request, prefix	+ "tm_mvmt_e", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNtcSearchVO();
				if (contactFlag[i] != null)
					model.setContactFlag(contactFlag[i]);
				if (focTpCd[i] != null)
					model.setFocTpCd(focTpCd[i]);
				if (dtMvmtE[i] != null)
					model.setDtMvmtE(dtMvmtE[i]);
				if (sndStsCd[i] != null)
					model.setSndStsCd(sndStsCd[i]);
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (stopFlag[i] != null)
					model.setStopFlag(stopFlag[i]);
				if (dtTpCd[i] != null)
					model.setDtTpCd(dtTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (dtS[i] != null)
					model.setDtS(dtS[i]);
				if (tmMvmtS[i] != null)
					model.setTmMvmtS(tmMvmtS[i]);
				if (eqOfcCd[i] != null)
					model.setEqOfcCd(eqOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (railCoCd[i] != null)
					model.setRailCoCd(railCoCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (dtMvmtS[i] != null)
					model.setDtMvmtS(dtMvmtS[i]);
				if (schTpCd[i] != null)
					model.setSchTpCd(schTpCd[i]);
				if (ntcTpCd[i] != null)
					model.setNtcTpCd(ntcTpCd[i]);
				if (owFlag[i] != null)
					model.setOwFlag(owFlag[i]);
				if (dtE[i] != null)
					model.setDtE(dtE[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (tmMvmtE[i] != null)
					model.setTmMvmtE(tmMvmtE[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNtcSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNtcSearchVO[]
	 */
	public PkupNtcSearchVO[] getPkupNtcSearchVOs(){
		PkupNtcSearchVO[] vos = (PkupNtcSearchVO[])models.toArray(new PkupNtcSearchVO[models.size()]);
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
		this.contactFlag = this.contactFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.focTpCd = this.focTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtMvmtE = this.dtMvmtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndStsCd = this.sndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopFlag = this.stopFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtTpCd = this.dtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtS = this.dtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmMvmtS = this.tmMvmtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOfcCd = this.eqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCoCd = this.railCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtMvmtS = this.dtMvmtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTpCd = this.schTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcTpCd = this.ntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.owFlag = this.owFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtE = this.dtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmMvmtE = this.tmMvmtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
