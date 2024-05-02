/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanalTzFeeSumRptVO.java
*@FileTitle : CanalTzFeeSumRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2012.02.22 Park Yeon-Jin 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo;

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
 * @author Park Yeon-Jin
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzFeeSumRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeSumRptVO> models = new ArrayList<CanalTzFeeSumRptVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String advPyRevMon = null;
	/* Column Info */
	private String payTo = null;
	/* Column Info */
	private String rslt = null;
	/* Column Info */
	private String pyDueDt = null;
	/* Column Info */
	private String invSts = null;
	/* Column Info */
	private String invRevMon = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String advPySts = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msa = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String eseq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String iseq = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String invoiceSts = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String revyrmon = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String trnsDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzFeeSumRptVO() {}

	public CanalTzFeeSumRptVO(String ibflag, String pagerows, String payTo, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String vslNm, String trnsDt, String pyDueDt, String advPySts, String advPyRevMon, String invoiceSts, String invSts, String invRevMon, String msa, String rslt, String eseq, String iseq, String ydCd, String revyrmon, String portCd, String vndrSeq, String lane, String vndrCntCd) {
		this.vslCd = vslCd;
		this.vndrCntCd = vndrCntCd;
		this.advPyRevMon = advPyRevMon;
		this.payTo = payTo;
		this.rslt = rslt;
		this.pyDueDt = pyDueDt;
		this.invSts = invSts;
		this.invRevMon = invRevMon;
		this.pagerows = pagerows;
		this.lane = lane;
		this.advPySts = advPySts;
		this.ibflag = ibflag;
		this.msa = msa;
		this.portCd = portCd;
		this.eseq = eseq;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.skdDirCd = skdDirCd;
		this.iseq = iseq;
		this.vvd = vvd;
		this.invoiceSts = invoiceSts;
		this.ydCd = ydCd;
		this.revyrmon = revyrmon;
		this.vndrSeq = vndrSeq;
		this.trnsDt = trnsDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("adv_py_rev_mon", getAdvPyRevMon());
		this.hashColumns.put("pay_to", getPayTo());
		this.hashColumns.put("rslt", getRslt());
		this.hashColumns.put("py_due_dt", getPyDueDt());
		this.hashColumns.put("inv_sts", getInvSts());
		this.hashColumns.put("inv_rev_mon", getInvRevMon());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("adv_py_sts", getAdvPySts());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msa", getMsa());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("eseq", getEseq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("iseq", getIseq());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("invoice_sts", getInvoiceSts());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("revyrmon", getRevyrmon());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("trns_dt", getTrnsDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("adv_py_rev_mon", "advPyRevMon");
		this.hashFields.put("pay_to", "payTo");
		this.hashFields.put("rslt", "rslt");
		this.hashFields.put("py_due_dt", "pyDueDt");
		this.hashFields.put("inv_sts", "invSts");
		this.hashFields.put("inv_rev_mon", "invRevMon");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("adv_py_sts", "advPySts");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msa", "msa");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("eseq", "eseq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("iseq", "iseq");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("invoice_sts", "invoiceSts");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("revyrmon", "revyrmon");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("trns_dt", "trnsDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return advPyRevMon
	 */
	public String getAdvPyRevMon() {
		return this.advPyRevMon;
	}
	
	/**
	 * Column Info
	 * @return payTo
	 */
	public String getPayTo() {
		return this.payTo;
	}
	
	/**
	 * Column Info
	 * @return rslt
	 */
	public String getRslt() {
		return this.rslt;
	}
	
	/**
	 * Column Info
	 * @return pyDueDt
	 */
	public String getPyDueDt() {
		return this.pyDueDt;
	}
	
	/**
	 * Column Info
	 * @return invSts
	 */
	public String getInvSts() {
		return this.invSts;
	}
	
	/**
	 * Column Info
	 * @return invRevMon
	 */
	public String getInvRevMon() {
		return this.invRevMon;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return advPySts
	 */
	public String getAdvPySts() {
		return this.advPySts;
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
	 * @return msa
	 */
	public String getMsa() {
		return this.msa;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return eseq
	 */
	public String getEseq() {
		return this.eseq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return iseq
	 */
	public String getIseq() {
		return this.iseq;
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
	 * @return invoiceSts
	 */
	public String getInvoiceSts() {
		return this.invoiceSts;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return revyrmon
	 */
	public String getRevyrmon() {
		return this.revyrmon;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return trnsDt
	 */
	public String getTrnsDt() {
		return this.trnsDt;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param advPyRevMon
	 */
	public void setAdvPyRevMon(String advPyRevMon) {
		this.advPyRevMon = advPyRevMon;
	}
	
	/**
	 * Column Info
	 * @param payTo
	 */
	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}
	
	/**
	 * Column Info
	 * @param rslt
	 */
	public void setRslt(String rslt) {
		this.rslt = rslt;
	}
	
	/**
	 * Column Info
	 * @param pyDueDt
	 */
	public void setPyDueDt(String pyDueDt) {
		this.pyDueDt = pyDueDt;
	}
	
	/**
	 * Column Info
	 * @param invSts
	 */
	public void setInvSts(String invSts) {
		this.invSts = invSts;
	}
	
	/**
	 * Column Info
	 * @param invRevMon
	 */
	public void setInvRevMon(String invRevMon) {
		this.invRevMon = invRevMon;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param advPySts
	 */
	public void setAdvPySts(String advPySts) {
		this.advPySts = advPySts;
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
	 * @param msa
	 */
	public void setMsa(String msa) {
		this.msa = msa;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param eseq
	 */
	public void setEseq(String eseq) {
		this.eseq = eseq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param iseq
	 */
	public void setIseq(String iseq) {
		this.iseq = iseq;
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
	 * @param invoiceSts
	 */
	public void setInvoiceSts(String invoiceSts) {
		this.invoiceSts = invoiceSts;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param revyrmon
	 */
	public void setRevyrmon(String revyrmon) {
		this.revyrmon = revyrmon;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param trnsDt
	 */
	public void setTrnsDt(String trnsDt) {
		this.trnsDt = trnsDt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setAdvPyRevMon(JSPUtil.getParameter(request, prefix + "adv_py_rev_mon", ""));
		setPayTo(JSPUtil.getParameter(request, prefix + "pay_to", ""));
		setRslt(JSPUtil.getParameter(request, prefix + "rslt", ""));
		setPyDueDt(JSPUtil.getParameter(request, prefix + "py_due_dt", ""));
		setInvSts(JSPUtil.getParameter(request, prefix + "inv_sts", ""));
		setInvRevMon(JSPUtil.getParameter(request, prefix + "inv_rev_mon", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setAdvPySts(JSPUtil.getParameter(request, prefix + "adv_py_sts", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMsa(JSPUtil.getParameter(request, prefix + "msa", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setEseq(JSPUtil.getParameter(request, prefix + "eseq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setIseq(JSPUtil.getParameter(request, prefix + "iseq", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setInvoiceSts(JSPUtil.getParameter(request, prefix + "invoice_sts", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setRevyrmon(JSPUtil.getParameter(request, prefix + "revyrmon", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTrnsDt(JSPUtil.getParameter(request, prefix + "trns_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeSumRptVO[]
	 */
	public CanalTzFeeSumRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeSumRptVO[]
	 */
	public CanalTzFeeSumRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeSumRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] advPyRevMon = (JSPUtil.getParameter(request, prefix	+ "adv_py_rev_mon", length));
			String[] payTo = (JSPUtil.getParameter(request, prefix	+ "pay_to", length));
			String[] rslt = (JSPUtil.getParameter(request, prefix	+ "rslt", length));
			String[] pyDueDt = (JSPUtil.getParameter(request, prefix	+ "py_due_dt", length));
			String[] invSts = (JSPUtil.getParameter(request, prefix	+ "inv_sts", length));
			String[] invRevMon = (JSPUtil.getParameter(request, prefix	+ "inv_rev_mon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] advPySts = (JSPUtil.getParameter(request, prefix	+ "adv_py_sts", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msa = (JSPUtil.getParameter(request, prefix	+ "msa", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] eseq = (JSPUtil.getParameter(request, prefix	+ "eseq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] iseq = (JSPUtil.getParameter(request, prefix	+ "iseq", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] invoiceSts = (JSPUtil.getParameter(request, prefix	+ "invoice_sts", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] revyrmon = (JSPUtil.getParameter(request, prefix	+ "revyrmon", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] trnsDt = (JSPUtil.getParameter(request, prefix	+ "trns_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeSumRptVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (advPyRevMon[i] != null)
					model.setAdvPyRevMon(advPyRevMon[i]);
				if (payTo[i] != null)
					model.setPayTo(payTo[i]);
				if (rslt[i] != null)
					model.setRslt(rslt[i]);
				if (pyDueDt[i] != null)
					model.setPyDueDt(pyDueDt[i]);
				if (invSts[i] != null)
					model.setInvSts(invSts[i]);
				if (invRevMon[i] != null)
					model.setInvRevMon(invRevMon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (advPySts[i] != null)
					model.setAdvPySts(advPySts[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msa[i] != null)
					model.setMsa(msa[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (eseq[i] != null)
					model.setEseq(eseq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (iseq[i] != null)
					model.setIseq(iseq[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (invoiceSts[i] != null)
					model.setInvoiceSts(invoiceSts[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (revyrmon[i] != null)
					model.setRevyrmon(revyrmon[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (trnsDt[i] != null)
					model.setTrnsDt(trnsDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeSumRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeSumRptVO[]
	 */
	public CanalTzFeeSumRptVO[] getCanalTzFeeSumRptVOs(){
		CanalTzFeeSumRptVO[] vos = (CanalTzFeeSumRptVO[])models.toArray(new CanalTzFeeSumRptVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advPyRevMon = this.advPyRevMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTo = this.payTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rslt = this.rslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pyDueDt = this.pyDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSts = this.invSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRevMon = this.invRevMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advPySts = this.advPySts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msa = this.msa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eseq = this.eseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iseq = this.iseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceSts = this.invoiceSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revyrmon = this.revyrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsDt = this.trnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
