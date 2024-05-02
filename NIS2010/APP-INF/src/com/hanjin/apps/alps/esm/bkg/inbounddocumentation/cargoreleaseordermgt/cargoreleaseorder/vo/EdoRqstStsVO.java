/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EdoRqstStsVO.java
*@FileTitle : EdoRqstStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdoRqstStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdoRqstStsVO> models = new ArrayList<EdoRqstStsVO>();
	
	/* Column Info */
	private String edoRqstSeq5jn = null;
	/* Column Info */
	private String edoRqstSeq5jm = null;
	/* Column Info */
	private String msPtyRgstNo = null;
	/* Column Info */
	private String selfEdoAckCd = null;
	/* Column Info */
	private String doIssue = null;
	/* Column Info */
	private String bondedEdoAckCd = null;
	/* Column Info */
	private String edoRqstSeq5jk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prPtyRgstNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errFlg = null;
	/* Column Info */
	private String edoRqstNo = null;
	/* Column Info */
	private String doEdoAckCd = null;
	/* Column Info */
	private String bondedTransportation = null;
	/* Column Info */
	private String selfTransportation = null;
	/* Column Info */
	private String prPtyEml = null;
	/* 컨테이너별 자가 운송 여부  */
	private String cntrSelfTrspFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdoRqstStsVO() {}

	public EdoRqstStsVO(String ibflag, String pagerows, String edoRqstNo, String edoRqstSeq5jn, String edoRqstSeq5jm, String edoRqstSeq5jk, String doIssue, String doEdoAckCd, String selfTransportation, String selfEdoAckCd, String bondedTransportation, String bondedEdoAckCd, String msPtyRgstNo, String prPtyRgstNo, String errFlg, String prPtyEml,String cntrSelfTrspFlag) {
		this.edoRqstSeq5jn = edoRqstSeq5jn;
		this.edoRqstSeq5jm = edoRqstSeq5jm;
		this.msPtyRgstNo = msPtyRgstNo;
		this.selfEdoAckCd = selfEdoAckCd;
		this.doIssue = doIssue;
		this.bondedEdoAckCd = bondedEdoAckCd;
		this.edoRqstSeq5jk = edoRqstSeq5jk;
		this.pagerows = pagerows;
		this.prPtyRgstNo = prPtyRgstNo;
		this.ibflag = ibflag;
		this.errFlg = errFlg;
		this.edoRqstNo = edoRqstNo;
		this.doEdoAckCd = doEdoAckCd;
		this.bondedTransportation = bondedTransportation;
		this.selfTransportation = selfTransportation;
		this.prPtyEml = prPtyEml;
		this.cntrSelfTrspFlag = cntrSelfTrspFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edo_rqst_seq_5jn", getEdoRqstSeq5jn());
		this.hashColumns.put("edo_rqst_seq_5jm", getEdoRqstSeq5jm());
		this.hashColumns.put("ms_pty_rgst_no", getMsPtyRgstNo());
		this.hashColumns.put("self_edo_ack_cd", getSelfEdoAckCd());
		this.hashColumns.put("do_issue", getDoIssue());
		this.hashColumns.put("bonded_edo_ack_cd", getBondedEdoAckCd());
		this.hashColumns.put("edo_rqst_seq_5jk", getEdoRqstSeq5jk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pr_pty_rgst_no", getPrPtyRgstNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_flg", getErrFlg());
		this.hashColumns.put("edo_rqst_no", getEdoRqstNo());
		this.hashColumns.put("do_edo_ack_cd", getDoEdoAckCd());
		this.hashColumns.put("bonded_transportation", getBondedTransportation());
		this.hashColumns.put("self_transportation", getSelfTransportation());
		this.hashColumns.put("pr_pty_eml", getPrPtyEml());
		this.hashColumns.put("cntr_self_trsp_flag", getCntrSelfTrspFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edo_rqst_seq_5jn", "edoRqstSeq5jn");
		this.hashFields.put("edo_rqst_seq_5jm", "edoRqstSeq5jm");
		this.hashFields.put("ms_pty_rgst_no", "msPtyRgstNo");
		this.hashFields.put("self_edo_ack_cd", "selfEdoAckCd");
		this.hashFields.put("do_issue", "doIssue");
		this.hashFields.put("bonded_edo_ack_cd", "bondedEdoAckCd");
		this.hashFields.put("edo_rqst_seq_5jk", "edoRqstSeq5jk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pr_pty_rgst_no", "prPtyRgstNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_flg", "errFlg");
		this.hashFields.put("edo_rqst_no", "edoRqstNo");
		this.hashFields.put("do_edo_ack_cd", "doEdoAckCd");
		this.hashFields.put("bonded_transportation", "bondedTransportation");
		this.hashFields.put("self_transportation", "selfTransportation");
		this.hashFields.put("pr_pty_eml", "prPtyEml");
		this.hashFields.put("cntr_self_trsp_flag", "cntrSelfTrspFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return edoRqstSeq5jn
	 */
	public String getEdoRqstSeq5jn() {
		return this.edoRqstSeq5jn;
	}
	
	/**
	 * Column Info
	 * @return edoRqstSeq5jm
	 */
	public String getEdoRqstSeq5jm() {
		return this.edoRqstSeq5jm;
	}
	
	/**
	 * Column Info
	 * @return msPtyRgstNo
	 */
	public String getMsPtyRgstNo() {
		return this.msPtyRgstNo;
	}
	
	/**
	 * Column Info
	 * @return selfEdoAckCd
	 */
	public String getSelfEdoAckCd() {
		return this.selfEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @return doIssue
	 */
	public String getDoIssue() {
		return this.doIssue;
	}
	
	/**
	 * Column Info
	 * @return bondedEdoAckCd
	 */
	public String getBondedEdoAckCd() {
		return this.bondedEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @return edoRqstSeq5jk
	 */
	public String getEdoRqstSeq5jk() {
		return this.edoRqstSeq5jk;
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
	 * @return prPtyRgstNo
	 */
	public String getPrPtyRgstNo() {
		return this.prPtyRgstNo;
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
	 * @return errFlg
	 */
	public String getErrFlg() {
		return this.errFlg;
	}
	
	/**
	 * Column Info
	 * @return edoRqstNo
	 */
	public String getEdoRqstNo() {
		return this.edoRqstNo;
	}
	
	/**
	 * Column Info
	 * @return doEdoAckCd
	 */
	public String getDoEdoAckCd() {
		return this.doEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @return bondedTransportation
	 */
	public String getBondedTransportation() {
		return this.bondedTransportation;
	}
	
	/**
	 * Column Info
	 * @return selfTransportation
	 */
	public String getSelfTransportation() {
		return this.selfTransportation;
	}
	
	/**
	 * Column Info
	 * @return prPtyEml
	 */
	public String getPrPtyEml() {
		return this.prPtyEml;
	}
	
	/**
	 * Column Info
	 * @param edoRqstSeq5jn
	 */
	public void setEdoRqstSeq5jn(String edoRqstSeq5jn) {
		this.edoRqstSeq5jn = edoRqstSeq5jn;
	}
	
	/**
	 * Column Info
	 * @param edoRqstSeq5jm
	 */
	public void setEdoRqstSeq5jm(String edoRqstSeq5jm) {
		this.edoRqstSeq5jm = edoRqstSeq5jm;
	}
	
	/**
	 * Column Info
	 * @param msPtyRgstNo
	 */
	public void setMsPtyRgstNo(String msPtyRgstNo) {
		this.msPtyRgstNo = msPtyRgstNo;
	}
	
	/**
	 * Column Info
	 * @param selfEdoAckCd
	 */
	public void setSelfEdoAckCd(String selfEdoAckCd) {
		this.selfEdoAckCd = selfEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @param doIssue
	 */
	public void setDoIssue(String doIssue) {
		this.doIssue = doIssue;
	}
	
	/**
	 * Column Info
	 * @param bondedEdoAckCd
	 */
	public void setBondedEdoAckCd(String bondedEdoAckCd) {
		this.bondedEdoAckCd = bondedEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @param edoRqstSeq5jk
	 */
	public void setEdoRqstSeq5jk(String edoRqstSeq5jk) {
		this.edoRqstSeq5jk = edoRqstSeq5jk;
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
	 * @param prPtyRgstNo
	 */
	public void setPrPtyRgstNo(String prPtyRgstNo) {
		this.prPtyRgstNo = prPtyRgstNo;
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
	 * @param errFlg
	 */
	public void setErrFlg(String errFlg) {
		this.errFlg = errFlg;
	}
	
	/**
	 * Column Info
	 * @param edoRqstNo
	 */
	public void setEdoRqstNo(String edoRqstNo) {
		this.edoRqstNo = edoRqstNo;
	}
	
	/**
	 * Column Info
	 * @param doEdoAckCd
	 */
	public void setDoEdoAckCd(String doEdoAckCd) {
		this.doEdoAckCd = doEdoAckCd;
	}
	
	/**
	 * Column Info
	 * @param bondedTransportation
	 */
	public void setBondedTransportation(String bondedTransportation) {
		this.bondedTransportation = bondedTransportation;
	}
	
	/**
	 * Column Info
	 * @param selfTransportation
	 */
	public void setSelfTransportation(String selfTransportation) {
		this.selfTransportation = selfTransportation;
	}
	
	/**
	 * Column Info
	 * @param prPtyEml
	 */
	public void setPrPtyEml(String prPtyEml) {
		this.prPtyEml = prPtyEml;
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
		setEdoRqstSeq5jn(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jn", ""));
		setEdoRqstSeq5jm(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jm", ""));
		setMsPtyRgstNo(JSPUtil.getParameter(request, prefix + "ms_pty_rgst_no", ""));
		setSelfEdoAckCd(JSPUtil.getParameter(request, prefix + "self_edo_ack_cd", ""));
		setDoIssue(JSPUtil.getParameter(request, prefix + "do_issue", ""));
		setBondedEdoAckCd(JSPUtil.getParameter(request, prefix + "bonded_edo_ack_cd", ""));
		setEdoRqstSeq5jk(JSPUtil.getParameter(request, prefix + "edo_rqst_seq_5jk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrPtyRgstNo(JSPUtil.getParameter(request, prefix + "pr_pty_rgst_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrFlg(JSPUtil.getParameter(request, prefix + "err_flg", ""));
		setEdoRqstNo(JSPUtil.getParameter(request, prefix + "edo_rqst_no", ""));
		setDoEdoAckCd(JSPUtil.getParameter(request, prefix + "do_edo_ack_cd", ""));
		setBondedTransportation(JSPUtil.getParameter(request, prefix + "bonded_transportation", ""));
		setSelfTransportation(JSPUtil.getParameter(request, prefix + "self_transportation", ""));
		setPrPtyEml(JSPUtil.getParameter(request, prefix + "pr_pty_eml", ""));
		setCntrSelfTrspFlag(JSPUtil.getParameter(request, prefix + "cntr_self_trsp_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdoRqstStsVO[]
	 */
	public EdoRqstStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdoRqstStsVO[]
	 */
	public EdoRqstStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdoRqstStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] edoRqstSeq5jn = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jn", length));
			String[] edoRqstSeq5jm = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jm", length));
			String[] msPtyRgstNo = (JSPUtil.getParameter(request, prefix	+ "ms_pty_rgst_no", length));
			String[] selfEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "self_edo_ack_cd", length));
			String[] doIssue = (JSPUtil.getParameter(request, prefix	+ "do_issue", length));
			String[] bondedEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "bonded_edo_ack_cd", length));
			String[] edoRqstSeq5jk = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_seq_5jk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prPtyRgstNo = (JSPUtil.getParameter(request, prefix	+ "pr_pty_rgst_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errFlg = (JSPUtil.getParameter(request, prefix	+ "err_flg", length));
			String[] edoRqstNo = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_no", length));
			String[] doEdoAckCd = (JSPUtil.getParameter(request, prefix	+ "do_edo_ack_cd", length));
			String[] bondedTransportation = (JSPUtil.getParameter(request, prefix	+ "bonded_transportation", length));
			String[] selfTransportation = (JSPUtil.getParameter(request, prefix	+ "self_transportation", length));
			String[] prPtyEml = (JSPUtil.getParameter(request, prefix	+ "pr_pty_eml", length));
			String[] cntrSelfTrspFlag = (JSPUtil.getParameter(request, prefix	+ "cntr_self_trsp_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdoRqstStsVO();
				if (edoRqstSeq5jn[i] != null)
					model.setEdoRqstSeq5jn(edoRqstSeq5jn[i]);
				if (edoRqstSeq5jm[i] != null)
					model.setEdoRqstSeq5jm(edoRqstSeq5jm[i]);
				if (msPtyRgstNo[i] != null)
					model.setMsPtyRgstNo(msPtyRgstNo[i]);
				if (selfEdoAckCd[i] != null)
					model.setSelfEdoAckCd(selfEdoAckCd[i]);
				if (doIssue[i] != null)
					model.setDoIssue(doIssue[i]);
				if (bondedEdoAckCd[i] != null)
					model.setBondedEdoAckCd(bondedEdoAckCd[i]);
				if (edoRqstSeq5jk[i] != null)
					model.setEdoRqstSeq5jk(edoRqstSeq5jk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prPtyRgstNo[i] != null)
					model.setPrPtyRgstNo(prPtyRgstNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errFlg[i] != null)
					model.setErrFlg(errFlg[i]);
				if (edoRqstNo[i] != null)
					model.setEdoRqstNo(edoRqstNo[i]);
				if (doEdoAckCd[i] != null)
					model.setDoEdoAckCd(doEdoAckCd[i]);
				if (bondedTransportation[i] != null)
					model.setBondedTransportation(bondedTransportation[i]);
				if (selfTransportation[i] != null)
					model.setSelfTransportation(selfTransportation[i]);
				if (prPtyEml[i] != null)
					model.setPrPtyEml(prPtyEml[i]);
				if (cntrSelfTrspFlag[i] != null)
					model.setCntrSelfTrspFlag(cntrSelfTrspFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdoRqstStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdoRqstStsVO[]
	 */
	public EdoRqstStsVO[] getEdoRqstStsVOs(){
		EdoRqstStsVO[] vos = (EdoRqstStsVO[])models.toArray(new EdoRqstStsVO[models.size()]);
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
		this.edoRqstSeq5jn = this.edoRqstSeq5jn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jm = this.edoRqstSeq5jm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msPtyRgstNo = this.msPtyRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfEdoAckCd = this.selfEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssue = this.doIssue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedEdoAckCd = this.bondedEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstSeq5jk = this.edoRqstSeq5jk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prPtyRgstNo = this.prPtyRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errFlg = this.errFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstNo = this.edoRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doEdoAckCd = this.doEdoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedTransportation = this.bondedTransportation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfTransportation = this.selfTransportation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prPtyEml = this.prPtyEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSelfTrspFlag = this.cntrSelfTrspFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getCntrSelfTrspFlag() {
		return cntrSelfTrspFlag;
	}

	public void setCntrSelfTrspFlag(String cntrSelfTrspFlag) {
		this.cntrSelfTrspFlag = cntrSelfTrspFlag;
	}
}
