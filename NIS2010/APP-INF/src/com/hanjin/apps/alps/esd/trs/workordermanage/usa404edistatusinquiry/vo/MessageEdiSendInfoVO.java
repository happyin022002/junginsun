/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MessageEdiSendInfoVO.java
*@FileTitle : MessageEdiSendInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.vo;

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

public class MessageEdiSendInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MessageEdiSendInfoVO> models = new ArrayList<MessageEdiSendInfoVO>();
	
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String provVndrSeq = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndSeq = null;
	/* Column Info */
	private String provFaxNo = null;
	/* Column Info */
	private String shprFaxNo = null;
	/* Column Info */
	private String provEml = null;
	/* Column Info */
	private String provUsrId = null;
	/* Column Info */
	private String provCfmMzdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MessageEdiSendInfoVO() {}

	public MessageEdiSendInfoVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String sndSeq, String provVndrSeq, String provUsrId, String provFaxNo, String provEml, String shprCustNm, String shprFaxNo, String sndDt, String ofcCd, String creUsrId, String provCfmMzdCd) {
		this.shprCustNm = shprCustNm;
		this.trspSoSeq = trspSoSeq;
		this.provVndrSeq = provVndrSeq;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.sndSeq = sndSeq;
		this.provFaxNo = provFaxNo;
		this.shprFaxNo = shprFaxNo;
		this.provEml = provEml;
		this.provUsrId = provUsrId;
		this.provCfmMzdCd = provCfmMzdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("prov_vndr_seq", getProvVndrSeq());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_seq", getSndSeq());
		this.hashColumns.put("prov_fax_no", getProvFaxNo());
		this.hashColumns.put("shpr_fax_no", getShprFaxNo());
		this.hashColumns.put("prov_eml", getProvEml());
		this.hashColumns.put("prov_usr_id", getProvUsrId());
		this.hashColumns.put("prov_cfm_mzd_cd", getProvCfmMzdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("prov_vndr_seq", "provVndrSeq");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_seq", "sndSeq");
		this.hashFields.put("prov_fax_no", "provFaxNo");
		this.hashFields.put("shpr_fax_no", "shprFaxNo");
		this.hashFields.put("prov_eml", "provEml");
		this.hashFields.put("prov_usr_id", "provUsrId");
		this.hashFields.put("prov_cfm_mzd_cd", "provCfmMzdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return provVndrSeq
	 */
	public String getProvVndrSeq() {
		return this.provVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return sndSeq
	 */
	public String getSndSeq() {
		return this.sndSeq;
	}
	
	/**
	 * Column Info
	 * @return provFaxNo
	 */
	public String getProvFaxNo() {
		return this.provFaxNo;
	}
	
	/**
	 * Column Info
	 * @return shprFaxNo
	 */
	public String getShprFaxNo() {
		return this.shprFaxNo;
	}
	
	/**
	 * Column Info
	 * @return provEml
	 */
	public String getProvEml() {
		return this.provEml;
	}
	
	/**
	 * Column Info
	 * @return provUsrId
	 */
	public String getProvUsrId() {
		return this.provUsrId;
	}
	
	/**
	 * Column Info
	 * @return provCfmMzdCd
	 */
	public String getProvCfmMzdCd() {
		return this.provCfmMzdCd;
	}
	

	/**
	 * Column Info
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param provVndrSeq
	 */
	public void setProvVndrSeq(String provVndrSeq) {
		this.provVndrSeq = provVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param sndSeq
	 */
	public void setSndSeq(String sndSeq) {
		this.sndSeq = sndSeq;
	}
	
	/**
	 * Column Info
	 * @param provFaxNo
	 */
	public void setProvFaxNo(String provFaxNo) {
		this.provFaxNo = provFaxNo;
	}
	
	/**
	 * Column Info
	 * @param shprFaxNo
	 */
	public void setShprFaxNo(String shprFaxNo) {
		this.shprFaxNo = shprFaxNo;
	}
	
	/**
	 * Column Info
	 * @param provEml
	 */
	public void setProvEml(String provEml) {
		this.provEml = provEml;
	}
	
	/**
	 * Column Info
	 * @param provUsrId
	 */
	public void setProvUsrId(String provUsrId) {
		this.provUsrId = provUsrId;
	}
	
	/**
	 * Column Info
	 * @param provCfmMzdCd
	 */
	public void setProvCfmMzdCd(String provCfmMzdCd) {
		this.provCfmMzdCd = provCfmMzdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setShprCustNm(JSPUtil.getParameter(request, "shpr_cust_nm", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setProvVndrSeq(JSPUtil.getParameter(request, "prov_vndr_seq", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndSeq(JSPUtil.getParameter(request, "snd_seq", ""));
		setProvFaxNo(JSPUtil.getParameter(request, "prov_fax_no", ""));
		setShprFaxNo(JSPUtil.getParameter(request, "shpr_fax_no", ""));
		setProvEml(JSPUtil.getParameter(request, "prov_eml", ""));
		setProvUsrId(JSPUtil.getParameter(request, "prov_usr_id", ""));
		setProvCfmMzdCd(JSPUtil.getParameter(request, "prov_cfm_mzd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MessageEdiSendInfoVO[]
	 */
	public MessageEdiSendInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MessageEdiSendInfoVO[]
	 */
	public MessageEdiSendInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MessageEdiSendInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] provVndrSeq = (JSPUtil.getParameter(request, prefix	+ "prov_vndr_seq", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndSeq = (JSPUtil.getParameter(request, prefix	+ "snd_seq", length));
			String[] provFaxNo = (JSPUtil.getParameter(request, prefix	+ "prov_fax_no", length));
			String[] shprFaxNo = (JSPUtil.getParameter(request, prefix	+ "shpr_fax_no", length));
			String[] provEml = (JSPUtil.getParameter(request, prefix	+ "prov_eml", length));
			String[] provUsrId = (JSPUtil.getParameter(request, prefix	+ "prov_usr_id", length));
			String[] provCfmMzdCd = (JSPUtil.getParameter(request, prefix	+ "prov_cfm_mzd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MessageEdiSendInfoVO();
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (provVndrSeq[i] != null)
					model.setProvVndrSeq(provVndrSeq[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndSeq[i] != null)
					model.setSndSeq(sndSeq[i]);
				if (provFaxNo[i] != null)
					model.setProvFaxNo(provFaxNo[i]);
				if (shprFaxNo[i] != null)
					model.setShprFaxNo(shprFaxNo[i]);
				if (provEml[i] != null)
					model.setProvEml(provEml[i]);
				if (provUsrId[i] != null)
					model.setProvUsrId(provUsrId[i]);
				if (provCfmMzdCd[i] != null)
					model.setProvCfmMzdCd(provCfmMzdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMessageEdiSendInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MessageEdiSendInfoVO[]
	 */
	public MessageEdiSendInfoVO[] getMessageEdiSendInfoVOs(){
		MessageEdiSendInfoVO[] vos = (MessageEdiSendInfoVO[])models.toArray(new MessageEdiSendInfoVO[models.size()]);
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
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provVndrSeq = this.provVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSeq = this.sndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provFaxNo = this.provFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprFaxNo = this.shprFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provEml = this.provEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provUsrId = this.provUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provCfmMzdCd = this.provCfmMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
