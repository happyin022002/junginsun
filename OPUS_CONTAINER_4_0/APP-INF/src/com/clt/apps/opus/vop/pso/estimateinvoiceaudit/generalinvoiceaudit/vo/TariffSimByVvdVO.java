/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TariffSimByVvdVO.java
*@FileTitle : TariffSimByVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.06.15 진마리아 
* 1.0 Creation
* 
* History
* 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성 
=========================================================*/

package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffSimByVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffSimByVvdVO> models = new ArrayList<TariffSimByVvdVO>();
	
	/* Column Info */
	private String tariffAmount = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String dpIoBndCd = null;
	/* Column Info */
	private String ydTtlUsdAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ibRatio = null;
	/* Column Info */
	private String obRatio = null;
	/* Column Info */
	private String expRto = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String portType = null;
	/* Column Info */
	private String result = null;
	/* Column bztpCd */
	private String srcPsoBztpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TariffSimByVvdVO() {}

	public TariffSimByVvdVO(String ibflag, String pagerows, String vvd, String expRto, String vpsPortCd, String ydCd, String ibRatio, String obRatio, String dpIoBndCd, String currCd, String tariffAmount, String vpsEtbDt, String vpsEtdDt, String ydTtlUsdAmt, String clptIndSeq, String portType, String result, String srcPsoBztpCd) {
		this.tariffAmount = tariffAmount;
		this.vpsEtbDt = vpsEtbDt;
		this.currCd = currCd;
		this.vpsEtdDt = vpsEtdDt;
		this.dpIoBndCd = dpIoBndCd;
		this.ydTtlUsdAmt = ydTtlUsdAmt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.ibRatio = ibRatio;
		this.obRatio = obRatio;
		this.expRto = expRto;
		this.clptIndSeq = clptIndSeq;
		this.portType = portType;
		this.result = result;
		this.srcPsoBztpCd = srcPsoBztpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tariff_amount", getTariffAmount());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("dp_io_bnd_cd", getDpIoBndCd());
		this.hashColumns.put("yd_ttl_usd_amt", getYdTtlUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("ib_ratio", getIbRatio());
		this.hashColumns.put("ob_ratio", getObRatio());
		this.hashColumns.put("exp_rto", getExpRto());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("port_type", getPortType());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("src_pso_bztp_cd", getSrcPsoBztpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tariff_amount", "tariffAmount");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("dp_io_bnd_cd", "dpIoBndCd");
		this.hashFields.put("yd_ttl_usd_amt", "ydTtlUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("ib_ratio", "ibRatio");
		this.hashFields.put("ob_ratio", "obRatio");
		this.hashFields.put("exp_rto", "expRto");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("port_type", "portType");
		this.hashFields.put("result", "result");
		this.hashFields.put("src_pso_bztp_cd", "srcPsoBztpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tariffAmount
	 */
	public String getTariffAmount() {
		return this.tariffAmount;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return dpIoBndCd
	 */
	public String getDpIoBndCd() {
		return this.dpIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return ydTtlUsdAmt
	 */
	public String getYdTtlUsdAmt() {
		return this.ydTtlUsdAmt;
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
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ibRatio
	 */
	public String getIbRatio() {
		return this.ibRatio;
	}
	
	/**
	 * Column Info
	 * @return obRatio
	 */
	public String getObRatio() {
		return this.obRatio;
	}
	
	/**
	 * Column Info
	 * @return expRto
	 */
	public String getExpRto() {
		return this.expRto;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return srcPsoBztpCd
	 */
	public String getSrcPsoBztpCd() {
		return this.srcPsoBztpCd;
	}
	
	/**
	 * Column Info
	 * @return portType
	 */
	public String getPortType() {
		return this.portType;
	}

	/**
	 * Column Info
	 * @param tariffAmount
	 */
	public void setTariffAmount(String tariffAmount) {
		this.tariffAmount = tariffAmount;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param dpIoBndCd
	 */
	public void setDpIoBndCd(String dpIoBndCd) {
		this.dpIoBndCd = dpIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param ydTtlUsdAmt
	 */
	public void setYdTtlUsdAmt(String ydTtlUsdAmt) {
		this.ydTtlUsdAmt = ydTtlUsdAmt;
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
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ibRatio
	 */
	public void setIbRatio(String ibRatio) {
		this.ibRatio = ibRatio;
	}
	
	/**
	 * Column Info
	 * @param obRatio
	 */
	public void setObRatio(String obRatio) {
		this.obRatio = obRatio;
	}
	
	/**
	 * Column Info
	 * @param expRto
	 */
	public void setExpRto(String expRto) {
		this.expRto = expRto;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param portType
	 */
	public void setPortType(String portType) {
		this.portType = portType;
	}
	
	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param srcPsoBztpCd
	 */
	public void setSrcPsoBztpCd(String srcPsoBztpCd) {
		this.srcPsoBztpCd = srcPsoBztpCd;
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
		setTariffAmount(JSPUtil.getParameter(request, prefix + "tariff_amount", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setDpIoBndCd(JSPUtil.getParameter(request, prefix + "dp_io_bnd_cd", ""));
		setYdTtlUsdAmt(JSPUtil.getParameter(request, prefix + "yd_ttl_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setIbRatio(JSPUtil.getParameter(request, prefix + "ib_ratio", ""));
		setObRatio(JSPUtil.getParameter(request, prefix + "ob_ratio", ""));
		setExpRto(JSPUtil.getParameter(request, prefix + "exp_rto", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setPortType(JSPUtil.getParameter(request, prefix + "port_type", ""));
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setSrcPsoBztpCd(JSPUtil.getParameter(request, prefix + "src_pso_bztp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffSimByVvdVO[]
	 */
	public TariffSimByVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffSimByVvdVO[]
	 */
	public TariffSimByVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffSimByVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tariffAmount = (JSPUtil.getParameter(request, prefix	+ "tariff_amount", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] dpIoBndCd = (JSPUtil.getParameter(request, prefix	+ "dp_io_bnd_cd", length));
			String[] ydTtlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "yd_ttl_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] ibRatio = (JSPUtil.getParameter(request, prefix	+ "ib_ratio", length));
			String[] obRatio = (JSPUtil.getParameter(request, prefix	+ "ob_ratio", length));
			String[] expRto = (JSPUtil.getParameter(request, prefix	+ "exp_rto", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] portType = (JSPUtil.getParameter(request, prefix	+ "port_type", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] srcPsoBztpCd = (JSPUtil.getParameter(request, prefix	+ "src_pso_bztp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffSimByVvdVO();
				if (tariffAmount[i] != null)
					model.setTariffAmount(tariffAmount[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (dpIoBndCd[i] != null)
					model.setDpIoBndCd(dpIoBndCd[i]);
				if (ydTtlUsdAmt[i] != null)
					model.setYdTtlUsdAmt(ydTtlUsdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ibRatio[i] != null)
					model.setIbRatio(ibRatio[i]);
				if (obRatio[i] != null)
					model.setObRatio(obRatio[i]);
				if (expRto[i] != null)
					model.setExpRto(expRto[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (portType[i] != null)
					model.setPortType(portType[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (srcPsoBztpCd[i] != null)
					model.setSrcPsoBztpCd(srcPsoBztpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffSimByVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffSimByVvdVO[]
	 */
	public TariffSimByVvdVO[] getTariffSimByVvdVOs(){
		TariffSimByVvdVO[] vos = (TariffSimByVvdVO[])models.toArray(new TariffSimByVvdVO[models.size()]);
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
		this.tariffAmount = this.tariffAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpIoBndCd = this.dpIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydTtlUsdAmt = this.ydTtlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRatio = this.ibRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obRatio = this.obRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expRto = this.expRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portType = this.portType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcPsoBztpCd = this.srcPsoBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
