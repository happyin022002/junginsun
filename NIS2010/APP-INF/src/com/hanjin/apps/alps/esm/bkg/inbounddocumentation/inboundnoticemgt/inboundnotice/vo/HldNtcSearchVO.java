/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HldNtcSearchVO.java
*@FileTitle : HldNtcSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.03.30 박미옥 
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

public class HldNtcSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HldNtcSearchVO> models = new ArrayList<HldNtcSearchVO>();
	
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dtS = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String schTpCd = null;
	/* Column Info */
	private String ntcWdYn = null;
	/* Column Info */
	private String dtE = null;
	/* Column Info */
	private String sndRsltCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HldNtcSearchVO() {}

	public HldNtcSearchVO(String ibflag, String pagerows, String schTpCd, String vvd, String dtS, String dtE, String podCd, String delCd, String sndRsltCd, String blNo, String cntrNo, String usrId, String usrOfcCd, String ofcCd, String ntcWdYn) {
		this.delCd = delCd;
		this.dtS = dtS;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.usrOfcCd = usrOfcCd;
		this.usrId = usrId;
		this.cntrNo = cntrNo;
		this.schTpCd = schTpCd;
		this.ntcWdYn = ntcWdYn;
		this.dtE = dtE;
		this.sndRsltCd = sndRsltCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dt_s", getDtS());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sch_tp_cd", getSchTpCd());
		this.hashColumns.put("ntc_wd_yn", getNtcWdYn());
		this.hashColumns.put("dt_e", getDtE());
		this.hashColumns.put("snd_rslt_cd", getSndRsltCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dt_s", "dtS");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sch_tp_cd", "schTpCd");
		this.hashFields.put("ntc_wd_yn", "ntcWdYn");
		this.hashFields.put("dt_e", "dtE");
		this.hashFields.put("snd_rslt_cd", "sndRsltCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return schTpCd
	 */
	public String getSchTpCd() {
		return this.schTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntcWdYn
	 */
	public String getNtcWdYn() {
		return this.ntcWdYn;
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
	 * @return sndRsltCd
	 */
	public String getSndRsltCd() {
		return this.sndRsltCd;
	}
	

	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param schTpCd
	 */
	public void setSchTpCd(String schTpCd) {
		this.schTpCd = schTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntcWdYn
	 */
	public void setNtcWdYn(String ntcWdYn) {
		this.ntcWdYn = ntcWdYn;
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
	 * @param sndRsltCd
	 */
	public void setSndRsltCd(String sndRsltCd) {
		this.sndRsltCd = sndRsltCd;
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
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDtS(JSPUtil.getParameter(request, prefix + "dt_s", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSchTpCd(JSPUtil.getParameter(request, prefix + "sch_tp_cd", ""));
		setNtcWdYn(JSPUtil.getParameter(request, prefix + "ntc_wd_yn", ""));
		setDtE(JSPUtil.getParameter(request, prefix + "dt_e", ""));
		setSndRsltCd(JSPUtil.getParameter(request, prefix + "snd_rslt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HldNtcSearchVO[]
	 */
	public HldNtcSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HldNtcSearchVO[]
	 */
	public HldNtcSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HldNtcSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dtS = (JSPUtil.getParameter(request, prefix	+ "dt_s", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] schTpCd = (JSPUtil.getParameter(request, prefix	+ "sch_tp_cd", length));
			String[] ntcWdYn = (JSPUtil.getParameter(request, prefix	+ "ntc_wd_yn", length));
			String[] dtE = (JSPUtil.getParameter(request, prefix	+ "dt_e", length));
			String[] sndRsltCd = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new HldNtcSearchVO();
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dtS[i] != null)
					model.setDtS(dtS[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (schTpCd[i] != null)
					model.setSchTpCd(schTpCd[i]);
				if (ntcWdYn[i] != null)
					model.setNtcWdYn(ntcWdYn[i]);
				if (dtE[i] != null)
					model.setDtE(dtE[i]);
				if (sndRsltCd[i] != null)
					model.setSndRsltCd(sndRsltCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHldNtcSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HldNtcSearchVO[]
	 */
	public HldNtcSearchVO[] getHldNtcSearchVOs(){
		HldNtcSearchVO[] vos = (HldNtcSearchVO[])models.toArray(new HldNtcSearchVO[models.size()]);
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
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtS = this.dtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTpCd = this.schTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcWdYn = this.ntcWdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtE = this.dtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltCd = this.sndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
