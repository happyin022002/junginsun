/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvArIssSndVO.java
*@FileTitle : InvArIssSndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class InvArIssSndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArIssSndVO> models = new ArrayList<InvArIssSndVO>();
	
	/* Column Info */
	private String ackSvrCd = null;
	/* Column Info */
	private String invIssSndTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String invSndNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String invSndCustNo = null;
	/* Column Info */
	private String invSndDt = null;
	/* Column Info */
	private String eurEmlSndRsltCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArIssSndVO() {}

	public InvArIssSndVO(String ibflag, String pagerows, String invNo, String invSeq, String sndSeq, String invIssSndTpCd, String invSndCustNo, String invSndDt, String invSndNo, String creUsrId, String creDt, String updUsrId, String updDt, String eurEmlSndRsltCd, String ackSvrCd, String errDesc, String sndDt) {
		this.ackSvrCd = ackSvrCd;
		this.invIssSndTpCd = invIssSndTpCd;
		this.updDt = updDt;
		this.creDt = creDt;
		this.invSeq = invSeq;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.invSndNo = invSndNo;
		this.ibflag = ibflag;
		this.sndSeq = sndSeq;
		this.creUsrId = creUsrId;
		this.errDesc = errDesc;
		this.invSndCustNo = invSndCustNo;
		this.invSndDt = invSndDt;
		this.eurEmlSndRsltCd = eurEmlSndRsltCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ack_svr_cd", getAckSvrCd());
		this.hashColumns.put("inv_iss_snd_tp_cd", getInvIssSndTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("inv_snd_no", getInvSndNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_seq", getSndSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("inv_snd_cust_no", getInvSndCustNo());
		this.hashColumns.put("inv_snd_dt", getInvSndDt());
		this.hashColumns.put("eur_eml_snd_rslt_cd", getEurEmlSndRsltCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ack_svr_cd", "ackSvrCd");
		this.hashFields.put("inv_iss_snd_tp_cd", "invIssSndTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_snd_no", "invSndNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_seq", "sndSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("inv_snd_cust_no", "invSndCustNo");
		this.hashFields.put("inv_snd_dt", "invSndDt");
		this.hashFields.put("eur_eml_snd_rslt_cd", "eurEmlSndRsltCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ackSvrCd
	 */
	public String getAckSvrCd() {
		return this.ackSvrCd;
	}
	
	/**
	 * Column Info
	 * @return invIssSndTpCd
	 */
	public String getInvIssSndTpCd() {
		return this.invIssSndTpCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return invSndNo
	 */
	public String getInvSndNo() {
		return this.invSndNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return invSndCustNo
	 */
	public String getInvSndCustNo() {
		return this.invSndCustNo;
	}
	
	/**
	 * Column Info
	 * @return invSndDt
	 */
	public String getInvSndDt() {
		return this.invSndDt;
	}
	
	/**
	 * Column Info
	 * @return eurEmlSndRsltCd
	 */
	public String getEurEmlSndRsltCd() {
		return this.eurEmlSndRsltCd;
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
	 * @param ackSvrCd
	 */
	public void setAckSvrCd(String ackSvrCd) {
		this.ackSvrCd = ackSvrCd;
	}
	
	/**
	 * Column Info
	 * @param invIssSndTpCd
	 */
	public void setInvIssSndTpCd(String invIssSndTpCd) {
		this.invIssSndTpCd = invIssSndTpCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param invSndNo
	 */
	public void setInvSndNo(String invSndNo) {
		this.invSndNo = invSndNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	/**
	 * Column Info
	 * @param invSndCustNo
	 */
	public void setInvSndCustNo(String invSndCustNo) {
		this.invSndCustNo = invSndCustNo;
	}
	
	/**
	 * Column Info
	 * @param invSndDt
	 */
	public void setInvSndDt(String invSndDt) {
		this.invSndDt = invSndDt;
	}
	
	/**
	 * Column Info
	 * @param eurEmlSndRsltCd
	 */
	public void setEurEmlSndRsltCd(String eurEmlSndRsltCd) {
		this.eurEmlSndRsltCd = eurEmlSndRsltCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setAckSvrCd(JSPUtil.getParameter(request, prefix + "ack_svr_cd", ""));
		setInvIssSndTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_snd_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setInvSndNo(JSPUtil.getParameter(request, prefix + "inv_snd_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSndSeq(JSPUtil.getParameter(request, prefix + "snd_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setErrDesc(JSPUtil.getParameter(request, prefix + "err_desc", ""));
		setInvSndCustNo(JSPUtil.getParameter(request, prefix + "inv_snd_cust_no", ""));
		setInvSndDt(JSPUtil.getParameter(request, prefix + "inv_snd_dt", ""));
		setEurEmlSndRsltCd(JSPUtil.getParameter(request, prefix + "eur_eml_snd_rslt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArIssSndVO[]
	 */
	public InvArIssSndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArIssSndVO[]
	 */
	public InvArIssSndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArIssSndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ackSvrCd = (JSPUtil.getParameter(request, prefix	+ "ack_svr_cd", length));
			String[] invIssSndTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_snd_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] invSndNo = (JSPUtil.getParameter(request, prefix	+ "inv_snd_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndSeq = (JSPUtil.getParameter(request, prefix	+ "snd_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] invSndCustNo = (JSPUtil.getParameter(request, prefix	+ "inv_snd_cust_no", length));
			String[] invSndDt = (JSPUtil.getParameter(request, prefix	+ "inv_snd_dt", length));
			String[] eurEmlSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "eur_eml_snd_rslt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArIssSndVO();
				if (ackSvrCd[i] != null)
					model.setAckSvrCd(ackSvrCd[i]);
				if (invIssSndTpCd[i] != null)
					model.setInvIssSndTpCd(invIssSndTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (invSndNo[i] != null)
					model.setInvSndNo(invSndNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndSeq[i] != null)
					model.setSndSeq(sndSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (invSndCustNo[i] != null)
					model.setInvSndCustNo(invSndCustNo[i]);
				if (invSndDt[i] != null)
					model.setInvSndDt(invSndDt[i]);
				if (eurEmlSndRsltCd[i] != null)
					model.setEurEmlSndRsltCd(eurEmlSndRsltCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArIssSndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArIssSndVO[]
	 */
	public InvArIssSndVO[] getInvArIssSndVOs(){
		InvArIssSndVO[] vos = (InvArIssSndVO[])models.toArray(new InvArIssSndVO[models.size()]);
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
		this.ackSvrCd = this.ackSvrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssSndTpCd = this.invIssSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSndNo = this.invSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSeq = this.sndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSndCustNo = this.invSndCustNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSndDt = this.invSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurEmlSndRsltCd = this.eurEmlSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
