/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPSummaryVO.java
*@FileTitle : COPSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.08.07 신한성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.popup.vo;

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
 * @author 신한성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class COPSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<COPSummaryVO> models = new ArrayList<COPSummaryVO>();
	
	/* Column Info */
	private String rdterm = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String exptInfo = null;
	/* Column Info */
	private String bkgno = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String blno = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String estmDate = null;
	/* Column Info */
	private String actDate = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public COPSummaryVO() {}

	public COPSummaryVO(String ibflag, String pagerows, String bkgno, String blno, String rdterm, String cntrNo, String copNo, String tvvd, String por, String pol, String pod, String del, String copDtlSeq, String actCd, String actNm, String vvd, String nodCd, String estmDate, String actDate, String actRcvTpCd, String exptInfo) {
		this.rdterm = rdterm;
		this.actCd = actCd;
		this.exptInfo = exptInfo;
		this.bkgno = bkgno;
		this.actRcvTpCd = actRcvTpCd;
		this.blno = blno;
		this.copNo = copNo;
		this.por = por;
		this.tvvd = tvvd;
		this.copDtlSeq = copDtlSeq;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.actNm = actNm;
		this.pol = pol;
		this.estmDate = estmDate;
		this.actDate = actDate;
		this.nodCd = nodCd;
		this.del = del;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rdterm", getRdterm());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("expt_info", getExptInfo());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("blno", getBlno());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("estm_date", getEstmDate());
		this.hashColumns.put("act_date", getActDate());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rdterm", "rdterm");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("expt_info", "exptInfo");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("blno", "blno");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("por", "por");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("estm_date", "estmDate");
		this.hashFields.put("act_date", "actDate");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rdterm
	 */
	public String getRdterm() {
		return this.rdterm;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return exptInfo
	 */
	public String getExptInfo() {
		return this.exptInfo;
	}
	
	/**
	 * Column Info
	 * @return bkgno
	 */
	public String getBkgno() {
		return this.bkgno;
	}
	
	/**
	 * Column Info
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return blno
	 */
	public String getBlno() {
		return this.blno;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return estmDate
	 */
	public String getEstmDate() {
		return this.estmDate;
	}
	
	/**
	 * Column Info
	 * @return actDate
	 */
	public String getActDate() {
		return this.actDate;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param rdterm
	 */
	public void setRdterm(String rdterm) {
		this.rdterm = rdterm;
	}
	
	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param exptInfo
	 */
	public void setExptInfo(String exptInfo) {
		this.exptInfo = exptInfo;
	}
	
	/**
	 * Column Info
	 * @param bkgno
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}
	
	/**
	 * Column Info
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param blno
	 */
	public void setBlno(String blno) {
		this.blno = blno;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param estmDate
	 */
	public void setEstmDate(String estmDate) {
		this.estmDate = estmDate;
	}
	
	/**
	 * Column Info
	 * @param actDate
	 */
	public void setActDate(String actDate) {
		this.actDate = actDate;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRdterm(JSPUtil.getParameter(request, "rdterm", ""));
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setExptInfo(JSPUtil.getParameter(request, "expt_info", ""));
		setBkgno(JSPUtil.getParameter(request, "bkgno", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, "act_rcv_tp_cd", ""));
		setBlno(JSPUtil.getParameter(request, "blno", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setTvvd(JSPUtil.getParameter(request, "tvvd", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setActNm(JSPUtil.getParameter(request, "act_nm", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setEstmDate(JSPUtil.getParameter(request, "estm_date", ""));
		setActDate(JSPUtil.getParameter(request, "act_date", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return COPSummaryVO[]
	 */
	public COPSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return COPSummaryVO[]
	 */
	public COPSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		COPSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rdterm = (JSPUtil.getParameter(request, prefix	+ "rdterm", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] exptInfo = (JSPUtil.getParameter(request, prefix	+ "expt_info", length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] blno = (JSPUtil.getParameter(request, prefix	+ "blno", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] estmDate = (JSPUtil.getParameter(request, prefix	+ "estm_date", length));
			String[] actDate = (JSPUtil.getParameter(request, prefix	+ "act_date", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new COPSummaryVO();
				if (rdterm[i] != null)
					model.setRdterm(rdterm[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (exptInfo[i] != null)
					model.setExptInfo(exptInfo[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (blno[i] != null)
					model.setBlno(blno[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (estmDate[i] != null)
					model.setEstmDate(estmDate[i]);
				if (actDate[i] != null)
					model.setActDate(actDate[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCOPSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return COPSummaryVO[]
	 */
	public COPSummaryVO[] getCOPSummaryVOs(){
		COPSummaryVO[] vos = (COPSummaryVO[])models.toArray(new COPSummaryVO[models.size()]);
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
		this.rdterm = this.rdterm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptInfo = this.exptInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blno = this.blno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDate = this.estmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDate = this.actDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
