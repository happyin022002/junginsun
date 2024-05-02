/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCodCostListVO.java
*@FileTitle : BkgCodCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2010.04.27 김종옥 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCodCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCodCostListVO> models = new ArrayList<BkgCodCostListVO>();
	
	/* Column Info */
	private String position = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String cntrCgoTpCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntr = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String codRhndPortCd = null;
	/* Column Info */
	private String codRqstSeq = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String costCdRqstSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCodCostListVO() {}

	public BkgCodCostListVO(String ibflag, String pagerows, String bkgNo, String codRqstSeq, String chgCd, String currCd, String chgUtAmt, String ratUtCd, String ratAsQty, String chgAmt, String cgoCateCd, String costCdRqstSeq, String cntrCgoTpCd, String codRhndPortCd, String vvd, String cntr, String port, String position) {
		this.position = position;
		this.port = port;
		this.chgUtAmt = chgUtAmt;
		this.currCd = currCd;
		this.ratUtCd = ratUtCd;
		this.cntrCgoTpCd = cntrCgoTpCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.cntr = cntr;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.codRhndPortCd = codRhndPortCd;
		this.codRqstSeq = codRqstSeq;
		this.cgoCateCd = cgoCateCd;
		this.chgAmt = chgAmt;
		this.ratAsQty = ratAsQty;
		this.costCdRqstSeq = costCdRqstSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("position", getPosition());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("cntr_cgo_tp_cd", getCntrCgoTpCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr", getCntr());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cod_rhnd_port_cd", getCodRhndPortCd());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("cost_cd_rqst_seq", getCostCdRqstSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("position", "position");
		this.hashFields.put("port", "port");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("cntr_cgo_tp_cd", "cntrCgoTpCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr", "cntr");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cod_rhnd_port_cd", "codRhndPortCd");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("cost_cd_rqst_seq", "costCdRqstSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return position
	 */
	public String getPosition() {
		return this.position;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
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
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoTpCd
	 */
	public String getCntrCgoTpCd() {
		return this.cntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return cntr
	 */
	public String getCntr() {
		return this.cntr;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return codRhndPortCd
	 */
	public String getCodRhndPortCd() {
		return this.codRhndPortCd;
	}
	
	/**
	 * Column Info
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return costCdRqstSeq
	 */
	public String getCostCdRqstSeq() {
		return this.costCdRqstSeq;
	}
	

	/**
	 * Column Info
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
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
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoTpCd
	 */
	public void setCntrCgoTpCd(String cntrCgoTpCd) {
		this.cntrCgoTpCd = cntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param cntr
	 */
	public void setCntr(String cntr) {
		this.cntr = cntr;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param codRhndPortCd
	 */
	public void setCodRhndPortCd(String codRhndPortCd) {
		this.codRhndPortCd = codRhndPortCd;
	}
	
	/**
	 * Column Info
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param costCdRqstSeq
	 */
	public void setCostCdRqstSeq(String costCdRqstSeq) {
		this.costCdRqstSeq = costCdRqstSeq;
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
		setPosition(JSPUtil.getParameter(request, prefix + "position", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setCntrCgoTpCd(JSPUtil.getParameter(request, prefix + "cntr_cgo_tp_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntr(JSPUtil.getParameter(request, prefix + "cntr", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCodRhndPortCd(JSPUtil.getParameter(request, prefix + "cod_rhnd_port_cd", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, prefix + "cod_rqst_seq", ""));
		setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setCostCdRqstSeq(JSPUtil.getParameter(request, prefix + "cost_cd_rqst_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCodCostListVO[]
	 */
	public BkgCodCostListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCodCostListVO[]
	 */
	public BkgCodCostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCodCostListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] position = (JSPUtil.getParameter(request, prefix	+ "position", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] cntrCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_tp_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntr = (JSPUtil.getParameter(request, prefix	+ "cntr", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] codRhndPortCd = (JSPUtil.getParameter(request, prefix	+ "cod_rhnd_port_cd", length));
			String[] codRqstSeq = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_seq", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] costCdRqstSeq = (JSPUtil.getParameter(request, prefix	+ "cost_cd_rqst_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCodCostListVO();
				if (position[i] != null)
					model.setPosition(position[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (cntrCgoTpCd[i] != null)
					model.setCntrCgoTpCd(cntrCgoTpCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntr[i] != null)
					model.setCntr(cntr[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (codRhndPortCd[i] != null)
					model.setCodRhndPortCd(codRhndPortCd[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (costCdRqstSeq[i] != null)
					model.setCostCdRqstSeq(costCdRqstSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCodCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCodCostListVO[]
	 */
	public BkgCodCostListVO[] getBkgCodCostListVOs(){
		BkgCodCostListVO[] vos = (BkgCodCostListVO[])models.toArray(new BkgCodCostListVO[models.size()]);
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
		this.position = this.position .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoTpCd = this.cntrCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr = this.cntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRhndPortCd = this.codRhndPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdRqstSeq = this.costCdRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
