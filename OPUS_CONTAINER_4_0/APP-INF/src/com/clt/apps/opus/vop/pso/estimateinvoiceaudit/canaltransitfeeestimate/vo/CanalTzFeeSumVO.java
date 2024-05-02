/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTzFeeSumVO.java
*@FileTitle : CanalTzFeeSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.21 김진일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzFeeSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeSumVO> models = new ArrayList<CanalTzFeeSumVO>();
	
	/* Column Info */
	private String advPyRevMon = null;
	/* Column Info */
	private String rslt = null;
	/* Column Info */
	private String payTo = null;
	/* Column Info */
	private String callSeq = null;
	/* Column Info */
	private String pyDueDt = null;
	/* Column Info */
	private String invSts = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String invRevMon = null;
	/* Column Info */
	private String iseq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String advPySts = null;
	/* Column Info */
	private String revyrmon = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String invoiceSts = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String msa = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String eseq = null;
	/* Column Info */
	private String trnsDt = null;

	/* Column Info */
	private String invStsTxt = null;
	/* Column Info */
	private String advPyStsTxt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzFeeSumVO() {}

	public CanalTzFeeSumVO(String ibflag, String pagerows, String payTo, String lane, String vvd, String trnsDt, String pyDueDt, String advPySts, String advPyRevMon, String invoiceSts, String invSts, String invRevMon, String msa, String rslt, String eseq, String iseq, String ydCd, String callSeq, String revyrmon, String portCd, String vndrSeq, String vslSlanCd, String invStsTxt, String advPyStsTxt) {
		this.advPyRevMon = advPyRevMon;
		this.rslt = rslt;
		this.payTo = payTo;
		this.callSeq = callSeq;
		this.pyDueDt = pyDueDt;
		this.invSts = invSts;
		this.vslSlanCd = vslSlanCd;
		this.invRevMon = invRevMon;
		this.iseq = iseq;
		this.pagerows = pagerows;
		this.lane = lane;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.advPySts = advPySts;
		this.revyrmon = revyrmon;
		this.ydCd = ydCd;
		this.invoiceSts = invoiceSts;
		this.vndrSeq = vndrSeq;
		this.msa = msa;
		this.portCd = portCd;
		this.eseq = eseq;
		this.trnsDt = trnsDt;
		this.invStsTxt = invStsTxt;
		this.advPyStsTxt = advPyStsTxt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("adv_py_rev_mon", getAdvPyRevMon());
		this.hashColumns.put("rslt", getRslt());
		this.hashColumns.put("pay_to", getPayTo());
		this.hashColumns.put("call_seq", getCallSeq());
		this.hashColumns.put("py_due_dt", getPyDueDt());
		this.hashColumns.put("inv_sts", getInvSts());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("inv_rev_mon", getInvRevMon());
		this.hashColumns.put("iseq", getIseq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("adv_py_sts", getAdvPySts());
		this.hashColumns.put("revyrmon", getRevyrmon());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("invoice_sts", getInvoiceSts());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("msa", getMsa());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("eseq", getEseq());
		this.hashColumns.put("trns_dt", getTrnsDt());
		this.hashColumns.put("inv_sts_txt", getInvStsTxt());
		this.hashColumns.put("adv_py_sts_txt", getAdvPyStsTxt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("adv_py_rev_mon", "advPyRevMon");
		this.hashFields.put("rslt", "rslt");
		this.hashFields.put("pay_to", "payTo");
		this.hashFields.put("call_seq", "callSeq");
		this.hashFields.put("py_due_dt", "pyDueDt");
		this.hashFields.put("inv_sts", "invSts");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("inv_rev_mon", "invRevMon");
		this.hashFields.put("iseq", "iseq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("adv_py_sts", "advPySts");
		this.hashFields.put("revyrmon", "revyrmon");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("invoice_sts", "invoiceSts");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("msa", "msa");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("eseq", "eseq");
		this.hashFields.put("trns_dt", "trnsDt");
		this.hashFields.put("inv_sts_txt", "invStsTxt");
		this.hashFields.put("adv_py_sts_txt", "advPyStsTxt");
		return this.hashFields;
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
	 * @return rslt
	 */
	public String getRslt() {
		return this.rslt;
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
	 * @return callSeq
	 */
	public String getCallSeq() {
		return this.callSeq;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return invRevMon
	 */
	public String getInvRevMon() {
		return this.invRevMon;
	}
	
	/**
	 * Column Info
	 * @return iseq
	 */
	public String getIseq() {
		return this.iseq;
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
	 * @return advPySts
	 */
	public String getAdvPySts() {
		return this.advPySts;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return trnsDt
	 */
	public String getTrnsDt() {
		return this.trnsDt;
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
	 * @param rslt
	 */
	public void setRslt(String rslt) {
		this.rslt = rslt;
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
	 * @param callSeq
	 */
	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param invRevMon
	 */
	public void setInvRevMon(String invRevMon) {
		this.invRevMon = invRevMon;
	}
	
	/**
	 * Column Info
	 * @param iseq
	 */
	public void setIseq(String iseq) {
		this.iseq = iseq;
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
	 * @param advPySts
	 */
	public void setAdvPySts(String advPySts) {
		this.advPySts = advPySts;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param trnsDt
	 */
	public void setTrnsDt(String trnsDt) {
		this.trnsDt = trnsDt;
	}
	
	public String getInvStsTxt() {
		return invStsTxt;
	}

	public void setInvStsTxt(String invStsTxt) {
		this.invStsTxt = invStsTxt;
	}

	public String getAdvPyStsTxt() {
		return advPyStsTxt;
	}

	public void setAdvPyStsTxt(String advPyStsTxt) {
		this.advPyStsTxt = advPyStsTxt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAdvPyRevMon(JSPUtil.getParameter(request, "adv_py_rev_mon", ""));
		setRslt(JSPUtil.getParameter(request, "rslt", ""));
		setPayTo(JSPUtil.getParameter(request, "pay_to", ""));
		setCallSeq(JSPUtil.getParameter(request, "call_seq", ""));
		setPyDueDt(JSPUtil.getParameter(request, "py_due_dt", ""));
		setInvSts(JSPUtil.getParameter(request, "inv_sts", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setInvRevMon(JSPUtil.getParameter(request, "inv_rev_mon", ""));
		setIseq(JSPUtil.getParameter(request, "iseq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAdvPySts(JSPUtil.getParameter(request, "adv_py_sts", ""));
		setRevyrmon(JSPUtil.getParameter(request, "revyrmon", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setInvoiceSts(JSPUtil.getParameter(request, "invoice_sts", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setMsa(JSPUtil.getParameter(request, "msa", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setEseq(JSPUtil.getParameter(request, "eseq", ""));
		setTrnsDt(JSPUtil.getParameter(request, "trns_dt", ""));
		setInvStsTxt(JSPUtil.getParameter(request, "inv_sts_txt", ""));
		setAdvPyStsTxt(JSPUtil.getParameter(request, "adv_py_sts_txt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeSumVO[]
	 */
	public CanalTzFeeSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeSumVO[]
	 */
	public CanalTzFeeSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] advPyRevMon = (JSPUtil.getParameter(request, prefix	+ "adv_py_rev_mon", length));
			String[] rslt = (JSPUtil.getParameter(request, prefix	+ "rslt", length));
			String[] payTo = (JSPUtil.getParameter(request, prefix	+ "pay_to", length));
			String[] callSeq = (JSPUtil.getParameter(request, prefix	+ "call_seq", length));
			String[] pyDueDt = (JSPUtil.getParameter(request, prefix	+ "py_due_dt", length));
			String[] invSts = (JSPUtil.getParameter(request, prefix	+ "inv_sts", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] invRevMon = (JSPUtil.getParameter(request, prefix	+ "inv_rev_mon", length));
			String[] iseq = (JSPUtil.getParameter(request, prefix	+ "iseq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] advPySts = (JSPUtil.getParameter(request, prefix	+ "adv_py_sts", length));
			String[] revyrmon = (JSPUtil.getParameter(request, prefix	+ "revyrmon", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] invoiceSts = (JSPUtil.getParameter(request, prefix	+ "invoice_sts", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] msa = (JSPUtil.getParameter(request, prefix	+ "msa", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] eseq = (JSPUtil.getParameter(request, prefix	+ "eseq", length));
			String[] trnsDt = (JSPUtil.getParameter(request, prefix	+ "trns_dt", length));
			String[] invStsTxt = (JSPUtil.getParameter(request, prefix	+ "inv_sts_txt", length));
			String[] advPyStsTxt = (JSPUtil.getParameter(request, prefix	+ "adv_py_sts_txt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeSumVO();
				if (advPyRevMon[i] != null)
					model.setAdvPyRevMon(advPyRevMon[i]);
				if (rslt[i] != null)
					model.setRslt(rslt[i]);
				if (payTo[i] != null)
					model.setPayTo(payTo[i]);
				if (callSeq[i] != null)
					model.setCallSeq(callSeq[i]);
				if (pyDueDt[i] != null)
					model.setPyDueDt(pyDueDt[i]);
				if (invSts[i] != null)
					model.setInvSts(invSts[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (invRevMon[i] != null)
					model.setInvRevMon(invRevMon[i]);
				if (iseq[i] != null)
					model.setIseq(iseq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (advPySts[i] != null)
					model.setAdvPySts(advPySts[i]);
				if (revyrmon[i] != null)
					model.setRevyrmon(revyrmon[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (invoiceSts[i] != null)
					model.setInvoiceSts(invoiceSts[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (msa[i] != null)
					model.setMsa(msa[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (eseq[i] != null)
					model.setEseq(eseq[i]);
				if (trnsDt[i] != null)
					model.setTrnsDt(trnsDt[i]);
				if (invStsTxt[i] != null)
					model.setInvStsTxt(invStsTxt[i]);
				if (advPyStsTxt[i] != null)
					model.setAdvPyStsTxt(advPyStsTxt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeSumVO[]
	 */
	public CanalTzFeeSumVO[] getCanalTzFeeSumVOs(){
		CanalTzFeeSumVO[] vos = (CanalTzFeeSumVO[])models.toArray(new CanalTzFeeSumVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.advPyRevMon = this.advPyRevMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rslt = this.rslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTo = this.payTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSeq = this.callSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pyDueDt = this.pyDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSts = this.invSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRevMon = this.invRevMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iseq = this.iseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advPySts = this.advPySts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revyrmon = this.revyrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceSts = this.invoiceSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msa = this.msa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eseq = this.eseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsDt = this.trnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsTxt = this.invStsTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advPyStsTxt = this.advPyStsTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
