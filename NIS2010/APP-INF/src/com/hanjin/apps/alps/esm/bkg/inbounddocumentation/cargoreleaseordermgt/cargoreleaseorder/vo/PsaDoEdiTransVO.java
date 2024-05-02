/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDoEdiTransVO.java
*@FileTitle : KorDoEdiTransVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.18
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.10.18 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이인영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaDoEdiTransVO extends AbstractValueObject {

	/**
     *
     */
    private static final long serialVersionUID = -4635333925544986133L;
	
	private Collection<PsaDoEdiTransVO> models = new ArrayList<PsaDoEdiTransVO>();

	private SignOnUserAccount acount = null;

	/* Column Info */
	private String selfTrnsFlg = null;
	/* Column Info */
	private String rlseSeq = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String ediSndRsltCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String discLocCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String eventTp = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaDoEdiTransVO() {}

	public PsaDoEdiTransVO(String ibflag, String pagerows, String discLocCd, String bkgNo, String eventTp, String selfTrnsFlg, String rlseSeq, String creUsrId, String updUsrId, String ediId, String ediSndRsltCd, String usrId, String ofcCd) {
		this.selfTrnsFlg = selfTrnsFlg;
		this.rlseSeq = rlseSeq;
		this.ediId = ediId;
		this.ediSndRsltCd = ediSndRsltCd;
		this.pagerows = pagerows;
		this.discLocCd = discLocCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.usrId = usrId;
		this.eventTp = eventTp;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("self_trns_flg", getSelfTrnsFlg());
		this.hashColumns.put("rlse_seq", getRlseSeq());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("edi_snd_rslt_cd", getEdiSndRsltCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("disc_loc_cd", getDiscLocCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("event_tp", getEventTp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("self_trns_flg", "selfTrnsFlg");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("edi_snd_rslt_cd", "ediSndRsltCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("disc_loc_cd", "discLocCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("event_tp", "eventTp");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return selfTrnsFlg
	 */
	public String getSelfTrnsFlg() {
		return this.selfTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return rlseSeq
	 */
	public String getRlseSeq() {
		return this.rlseSeq;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return ediSndRsltCd
	 */
	public String getEdiSndRsltCd() {
		return this.ediSndRsltCd;
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
	 * @return discLocCd
	 */
	public String getDiscLocCd() {
		return this.discLocCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return eventTp
	 */
	public String getEventTp() {
		return this.eventTp;
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
	 * @param selfTrnsFlg
	 */
	public void setSelfTrnsFlg(String selfTrnsFlg) {
		this.selfTrnsFlg = selfTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param rlseSeq
	 */
	public void setRlseSeq(String rlseSeq) {
		this.rlseSeq = rlseSeq;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param ediSndRsltCd
	 */
	public void setEdiSndRsltCd(String ediSndRsltCd) {
		this.ediSndRsltCd = ediSndRsltCd;
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
	 * @param discLocCd
	 */
	public void setDiscLocCd(String discLocCd) {
		this.discLocCd = discLocCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param eventTp
	 */
	public void setEventTp(String eventTp) {
		this.eventTp = eventTp;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSelfTrnsFlg(JSPUtil.getParameter(request, "self_trns_flg", ""));
		setRlseSeq(JSPUtil.getParameter(request, "rlse_seq", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setEdiSndRsltCd(JSPUtil.getParameter(request, "edi_snd_rslt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDiscLocCd(JSPUtil.getParameter(request, "disc_loc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setEventTp(JSPUtil.getParameter(request, "event_tp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaDoEdiTransVO[]
	 */
	public PsaDoEdiTransVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaDoEdiTransVO[]
	 */
	public PsaDoEdiTransVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaDoEdiTransVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] selfTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "self_trns_flg", length));
			String[] rlseSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_seq", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] ediSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_rslt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] discLocCd = (JSPUtil.getParameter(request, prefix	+ "disc_loc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] eventTp = (JSPUtil.getParameter(request, prefix	+ "event_tp", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaDoEdiTransVO();
				if (selfTrnsFlg[i] != null)
					model.setSelfTrnsFlg(selfTrnsFlg[i]);
				if (rlseSeq[i] != null)
					model.setRlseSeq(rlseSeq[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (ediSndRsltCd[i] != null)
					model.setEdiSndRsltCd(ediSndRsltCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (discLocCd[i] != null)
					model.setDiscLocCd(discLocCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (eventTp[i] != null)
					model.setEventTp(eventTp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaDoEdiTransVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaDoEdiTransVO[]
	 */
	public PsaDoEdiTransVO[] getPsaDoEdiTransVOs(){
		PsaDoEdiTransVO[] vos = (PsaDoEdiTransVO[])models.toArray(new PsaDoEdiTransVO[models.size()]);
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
		this.selfTrnsFlg = this.selfTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseSeq = this.rlseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndRsltCd = this.ediSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discLocCd = this.discLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventTp = this.eventTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the acount
	 */
	public SignOnUserAccount getAcount() {
		return acount;
	}

	/**
	 * @param acount the acount to set
	 */
	public void setAcount(SignOnUserAccount acount) {
		this.acount = acount;
	}
}
