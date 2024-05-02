/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PkupNtcSentHisSchVO.java
*@FileTitle : PkupNtcSentHisSchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class PkupNtcSentHisSchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNtcSentHisSchVO> models = new ArrayList<PkupNtcSentHisSchVO>();
	
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String pkupNtcTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String schTp = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String bkgNtcSndRsltCd = null;
	/* Column Info */
	private String sndDtTo = null;
	/* Column Info */
	private String sndDtFm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNtcSentHisSchVO() {}

	public PkupNtcSentHisSchVO(String ibflag, String pagerows, String schTp, String sndDtFm, String sndDtTo, String blNo, String cntrNo, String bkgNtcSndRsltCd, String pkupNtcTpCd, String sndUsrId, String ofcCd, String excelFlg, String pageNo, String mvmtCd, String usrOfcCd) {
		this.mvmtCd = mvmtCd;
		this.pkupNtcTpCd = pkupNtcTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.schTp = schTp;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.sndUsrId = sndUsrId;
		this.usrOfcCd = usrOfcCd;
		this.excelFlg = excelFlg;
		this.cntrNo = cntrNo;
		this.pageNo = pageNo;
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
		this.sndDtTo = sndDtTo;
		this.sndDtFm = sndDtFm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("pkup_ntc_tp_cd", getPkupNtcTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sch_tp", getSchTp());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("bkg_ntc_snd_rslt_cd", getBkgNtcSndRsltCd());
		this.hashColumns.put("snd_dt_to", getSndDtTo());
		this.hashColumns.put("snd_dt_fm", getSndDtFm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("pkup_ntc_tp_cd", "pkupNtcTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sch_tp", "schTp");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("bkg_ntc_snd_rslt_cd", "bkgNtcSndRsltCd");
		this.hashFields.put("snd_dt_to", "sndDtTo");
		this.hashFields.put("snd_dt_fm", "sndDtFm");
		return this.hashFields;
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
	 * @return pkupNtcTpCd
	 */
	public String getPkupNtcTpCd() {
		return this.pkupNtcTpCd;
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
	 * @return schTp
	 */
	public String getSchTp() {
		return this.schTp;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
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
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNtcSndRsltCd
	 */
	public String getBkgNtcSndRsltCd() {
		return this.bkgNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return sndDtTo
	 */
	public String getSndDtTo() {
		return this.sndDtTo;
	}
	
	/**
	 * Column Info
	 * @return sndDtFm
	 */
	public String getSndDtFm() {
		return this.sndDtFm;
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
	 * @param pkupNtcTpCd
	 */
	public void setPkupNtcTpCd(String pkupNtcTpCd) {
		this.pkupNtcTpCd = pkupNtcTpCd;
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
	 * @param schTp
	 */
	public void setSchTp(String schTp) {
		this.schTp = schTp;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
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
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNtcSndRsltCd
	 */
	public void setBkgNtcSndRsltCd(String bkgNtcSndRsltCd) {
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param sndDtTo
	 */
	public void setSndDtTo(String sndDtTo) {
		this.sndDtTo = sndDtTo;
	}
	
	/**
	 * Column Info
	 * @param sndDtFm
	 */
	public void setSndDtFm(String sndDtFm) {
		this.sndDtFm = sndDtFm;
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
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setPkupNtcTpCd(JSPUtil.getParameter(request, prefix + "pkup_ntc_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSchTp(JSPUtil.getParameter(request, prefix + "sch_tp", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setBkgNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "bkg_ntc_snd_rslt_cd", ""));
		setSndDtTo(JSPUtil.getParameter(request, prefix + "snd_dt_to", ""));
		setSndDtFm(JSPUtil.getParameter(request, prefix + "snd_dt_fm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNtcSentHisSchVO[]
	 */
	public PkupNtcSentHisSchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNtcSentHisSchVO[]
	 */
	public PkupNtcSentHisSchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNtcSentHisSchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] pkupNtcTpCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] schTp = (JSPUtil.getParameter(request, prefix	+ "sch_tp", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] bkgNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_cd", length));
			String[] sndDtTo = (JSPUtil.getParameter(request, prefix	+ "snd_dt_to", length));
			String[] sndDtFm = (JSPUtil.getParameter(request, prefix	+ "snd_dt_fm", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNtcSentHisSchVO();
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (pkupNtcTpCd[i] != null)
					model.setPkupNtcTpCd(pkupNtcTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (schTp[i] != null)
					model.setSchTp(schTp[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (bkgNtcSndRsltCd[i] != null)
					model.setBkgNtcSndRsltCd(bkgNtcSndRsltCd[i]);
				if (sndDtTo[i] != null)
					model.setSndDtTo(sndDtTo[i]);
				if (sndDtFm[i] != null)
					model.setSndDtFm(sndDtFm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNtcSentHisSchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNtcSentHisSchVO[]
	 */
	public PkupNtcSentHisSchVO[] getPkupNtcSentHisSchVOs(){
		PkupNtcSentHisSchVO[] vos = (PkupNtcSentHisSchVO[])models.toArray(new PkupNtcSentHisSchVO[models.size()]);
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
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcTpCd = this.pkupNtcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTp = this.schTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtcSndRsltCd = this.bkgNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtTo = this.sndDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtFm = this.sndDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
