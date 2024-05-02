/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriAmdCmpbOpbViewAllVO.java
*@FileTitle : RsltPriAmdCmpbOpbViewAllVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.13 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriAmdCmpbOpbViewAllVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriAmdCmpbOpbViewAllVO> models = new ArrayList<RsltPriAmdCmpbOpbViewAllVO>();
	
	/* Column Info */
	private String prsPfitCmpbAmt = null;
	/* Column Info */
	private String prsRespbOpbAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String prsRespbCmpbAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriAmdCmpbOpbViewAllVO() {}

	public RsltPriAmdCmpbOpbViewAllVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String cgoTpCd, String ratUtCd, String prsRespbCmpbAmt, String prsPfitCmpbAmt, String prsRespbOpbAmt) {
		this.prsPfitCmpbAmt = prsPfitCmpbAmt;
		this.prsRespbOpbAmt = prsRespbOpbAmt;
		this.ibflag = ibflag;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.svcScpCd = svcScpCd;
		this.cgoTpCd = cgoTpCd;
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
		this.ratUtCd = ratUtCd;
		this.routSeq = routSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prs_pfit_cmpb_amt", getPrsPfitCmpbAmt());
		this.hashColumns.put("prs_respb_opb_amt", getPrsRespbOpbAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("prs_respb_cmpb_amt", getPrsRespbCmpbAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prs_pfit_cmpb_amt", "prsPfitCmpbAmt");
		this.hashFields.put("prs_respb_opb_amt", "prsRespbOpbAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("prs_respb_cmpb_amt", "prsRespbCmpbAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prsPfitCmpbAmt
	 */
	public String getPrsPfitCmpbAmt() {
		return this.prsPfitCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return prsRespbOpbAmt
	 */
	public String getPrsRespbOpbAmt() {
		return this.prsRespbOpbAmt;
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
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return prsRespbCmpbAmt
	 */
	public String getPrsRespbCmpbAmt() {
		return this.prsRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @param prsPfitCmpbAmt
	 */
	public void setPrsPfitCmpbAmt(String prsPfitCmpbAmt) {
		this.prsPfitCmpbAmt = prsPfitCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param prsRespbOpbAmt
	 */
	public void setPrsRespbOpbAmt(String prsRespbOpbAmt) {
		this.prsRespbOpbAmt = prsRespbOpbAmt;
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
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param prsRespbCmpbAmt
	 */
	public void setPrsRespbCmpbAmt(String prsRespbCmpbAmt) {
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
		setPrsPfitCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_pfit_cmpb_amt", ""));
		setPrsRespbOpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opb_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setPrsRespbCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cmpb_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriAmdCmpbOpbViewAllVO[]
	 */
	public RsltPriAmdCmpbOpbViewAllVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriAmdCmpbOpbViewAllVO[]
	 */
	public RsltPriAmdCmpbOpbViewAllVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriAmdCmpbOpbViewAllVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prsPfitCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pfit_cmpb_amt", length));
			String[] prsRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opb_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] prsRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cmpb_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriAmdCmpbOpbViewAllVO();
				if (prsPfitCmpbAmt[i] != null)
					model.setPrsPfitCmpbAmt(prsPfitCmpbAmt[i]);
				if (prsRespbOpbAmt[i] != null)
					model.setPrsRespbOpbAmt(prsRespbOpbAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (prsRespbCmpbAmt[i] != null)
					model.setPrsRespbCmpbAmt(prsRespbCmpbAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriAmdCmpbOpbViewAllVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriAmdCmpbOpbViewAllVO[]
	 */
	public RsltPriAmdCmpbOpbViewAllVO[] getRsltPriAmdCmpbOpbViewAllVOs(){
		RsltPriAmdCmpbOpbViewAllVO[] vos = (RsltPriAmdCmpbOpbViewAllVO[])models.toArray(new RsltPriAmdCmpbOpbViewAllVO[models.size()]);
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
		this.prsPfitCmpbAmt = this.prsPfitCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpbAmt = this.prsRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmpbAmt = this.prsRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
