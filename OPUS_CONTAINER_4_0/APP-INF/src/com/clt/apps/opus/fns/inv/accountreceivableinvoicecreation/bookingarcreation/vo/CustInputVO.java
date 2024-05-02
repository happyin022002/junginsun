/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustInputVO.java
*@FileTitle : CustInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.23 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustInputVO> models = new ArrayList<CustInputVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String arCtrlOfcCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String autoMnlDivCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subAgnFlg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String n3rdFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chnAgnCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustInputVO() {}

	public CustInputVO(String ibflag, String pagerows, String subAgnFlg, String vvd, String n3rdFlg, String blSrcNo, String ofcCd, String bkgNo, String portCd, String arCtrlOfcCd, String ioBndCd, String arOfcCd, String autoMnlDivCd, String chnAgnCd, String custCntCd, String custSeq,String bkgSeq, String polCd, String podCd, String delCd, String porCd) {
		this.blSrcNo = blSrcNo;
		this.arCtrlOfcCd = arCtrlOfcCd;
		this.custSeq = custSeq;
		this.ioBndCd = ioBndCd;
		this.autoMnlDivCd = autoMnlDivCd;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.subAgnFlg = subAgnFlg;
		this.vvd = vvd;
		this.n3rdFlg = n3rdFlg;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.chnAgnCd = chnAgnCd;
		this.portCd = portCd;
		this.custCntCd = custCntCd;
		this.bkgSeq = bkgSeq;
		this.polCd = polCd;
		this.podCd = podCd;
		this.porCd = porCd;
		this.delCd = delCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("ar_ctrl_ofc_cd", getArCtrlOfcCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("auto_mnl_div_cd", getAutoMnlDivCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sub_agn_flg", getSubAgnFlg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("n3rd_flg", getN3rdFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("por_cd", getPorCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("ar_ctrl_ofc_cd", "arCtrlOfcCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("auto_mnl_div_cd", "autoMnlDivCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sub_agn_flg", "subAgnFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("n3rd_flg", "n3rdFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		
		return this.hashFields;
	}
	
	
	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the porCd
	 */
	public String getPorCd() {
		return porCd;
	}

	/**
	 * @param porCd the porCd to set
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * @return the delCd
	 */
	public String getDelCd() {
		return delCd;
	}

	/**
	 * @param delCd the delCd to set
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * @return the bkgSeq
	 */
	public String getBkgSeq() {
		return bkgSeq;
	}

	/**
	 * @param bkgSeq the bkgSeq to set
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
	}

	/**
	 * Column Info
	 * @return arCtrlOfcCd
	 */
	public String getArCtrlOfcCd() {
		return this.arCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return autoMnlDivCd
	 */
	public String getAutoMnlDivCd() {
		return this.autoMnlDivCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return subAgnFlg
	 */
	public String getSubAgnFlg() {
		return this.subAgnFlg;
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
	 * @return n3rdFlg
	 */
	public String getN3rdFlg() {
		return this.n3rdFlg;
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
	 * @return chnAgnCd
	 */
	public String getChnAgnCd() {
		return this.chnAgnCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param arCtrlOfcCd
	 */
	public void setArCtrlOfcCd(String arCtrlOfcCd) {
		this.arCtrlOfcCd = arCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param autoMnlDivCd
	 */
	public void setAutoMnlDivCd(String autoMnlDivCd) {
		this.autoMnlDivCd = autoMnlDivCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param subAgnFlg
	 */
	public void setSubAgnFlg(String subAgnFlg) {
		this.subAgnFlg = subAgnFlg;
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
	 * @param n3rdFlg
	 */
	public void setN3rdFlg(String n3rdFlg) {
		this.n3rdFlg = n3rdFlg;
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
	 * @param chnAgnCd
	 */
	public void setChnAgnCd(String chnAgnCd) {
		this.chnAgnCd = chnAgnCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setArCtrlOfcCd(JSPUtil.getParameter(request, "ar_ctrl_ofc_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setAutoMnlDivCd(JSPUtil.getParameter(request, "auto_mnl_div_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSubAgnFlg(JSPUtil.getParameter(request, "sub_agn_flg", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setN3rdFlg(JSPUtil.getParameter(request, "n3rd_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setChnAgnCd(JSPUtil.getParameter(request, "chn_agn_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setBkgSeq(JSPUtil.getParameter(request, "bkg_seq", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustInputVO[]
	 */
	public CustInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustInputVO[]
	 */
	public CustInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] arCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctrl_ofc_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] autoMnlDivCd = (JSPUtil.getParameter(request, prefix	+ "auto_mnl_div_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subAgnFlg = (JSPUtil.getParameter(request, prefix	+ "sub_agn_flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] n3rdFlg = (JSPUtil.getParameter(request, prefix	+ "n3rd_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chnAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_agn_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustInputVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (arCtrlOfcCd[i] != null)
					model.setArCtrlOfcCd(arCtrlOfcCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (autoMnlDivCd[i] != null)
					model.setAutoMnlDivCd(autoMnlDivCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subAgnFlg[i] != null)
					model.setSubAgnFlg(subAgnFlg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (n3rdFlg[i] != null)
					model.setN3rdFlg(n3rdFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chnAgnCd[i] != null)
					model.setChnAgnCd(chnAgnCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustInputVO[]
	 */
	public CustInputVO[] getCustInputVOs(){
		CustInputVO[] vos = (CustInputVO[])models.toArray(new CustInputVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrlOfcCd = this.arCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoMnlDivCd = this.autoMnlDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAgnFlg = this.subAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdFlg = this.n3rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd = this.chnAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
