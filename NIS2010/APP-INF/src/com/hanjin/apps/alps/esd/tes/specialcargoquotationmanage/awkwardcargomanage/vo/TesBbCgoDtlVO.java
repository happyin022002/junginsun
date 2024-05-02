/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesBbCgoDtlVO.java
*@FileTitle : TesBbCgoDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.27
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.27 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesBbCgoDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesBbCgoDtlVO> models = new ArrayList<TesBbCgoDtlVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String dtlInvAmt = null;
	/* Column Info */
	private String dtlLgsCostCd = null;
	/* Column Info */
	private String tmlSoSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String tmlSoDtlSeq = null;
	/* Column Info */
	private String tmlSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dtlBbCgoRmk = null;
	/* Column Info */
	private String atbDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesBbCgoDtlVO() {}

	public TesBbCgoDtlVO(String dtlBbCgoRmk, String ibflag, String pagerows, String dtlLgsCostCd, String dtlInvAmt, String bkgNo, String vvd, String ioBndCd, String ydCd, String tmlSoOfcCtyCd, String tmlSoSeq, String tmlSoDtlSeq, String atbDt)  {
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.dtlInvAmt = dtlInvAmt;
		this.dtlLgsCostCd = dtlLgsCostCd;
		this.tmlSoSeq = tmlSoSeq;
		this.ioBndCd = ioBndCd;
		this.tmlSoDtlSeq = tmlSoDtlSeq;
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
		this.pagerows = pagerows;
		this.dtlBbCgoRmk = dtlBbCgoRmk;
		this.atbDt = atbDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("dtl_inv_amt", getDtlInvAmt());
		this.hashColumns.put("dtl_lgs_cost_cd", getDtlLgsCostCd());
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("tml_so_dtl_seq", getTmlSoDtlSeq());
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dtl_bb_cgo_rmk", getDtlBbCgoRmk());
		this.hashColumns.put("atb_dt", getAtbDt());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("dtl_inv_amt", "dtlInvAmt");
		this.hashFields.put("dtl_lgs_cost_cd", "dtlLgsCostCd");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("tml_so_dtl_seq", "tmlSoDtlSeq");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dtl_bb_cgo_rmk", "dtlBbCgoRmk");
		this.hashFields.put("atb_dt", "atbDt");

		return this.hashFields;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return dtlInvAmt
	 */
	public String getDtlInvAmt() {
		return this.dtlInvAmt;
	}
	
	/**
	 * Column Info
	 * @return dtlLgsCostCd
	 */
	public String getDtlLgsCostCd() {
		return this.dtlLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return tmlSoSeq
	 */
	public String getTmlSoSeq() {
		return this.tmlSoSeq;
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
	 * @return tmlSoDtlSeq
	 */
	public String getTmlSoDtlSeq() {
		return this.tmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlSoOfcCtyCd
	 */
	public String getTmlSoOfcCtyCd() {
		return this.tmlSoOfcCtyCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return dtlBbCgoRmk
	 */
	public String getDtlBbCgoRmk() {
		return this.dtlBbCgoRmk;
	}
	
	/**
	 * Column Info
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param dtlInvAmt
	 */
	public void setDtlInvAmt(String dtlInvAmt) {
		this.dtlInvAmt = dtlInvAmt;
	}
	
	/**
	 * Column Info
	 * @param dtlLgsCostCd
	 */
	public void setDtlLgsCostCd(String dtlLgsCostCd) {
		this.dtlLgsCostCd = dtlLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param tmlSoSeq
	 */
	public void setTmlSoSeq(String tmlSoSeq) {
		this.tmlSoSeq = tmlSoSeq;
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
	 * @param tmlSoDtlSeq
	 */
	public void setTmlSoDtlSeq(String tmlSoDtlSeq) {
		this.tmlSoDtlSeq = tmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlSoOfcCtyCd
	 */
	public void setTmlSoOfcCtyCd(String tmlSoOfcCtyCd) {
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
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
	 * @param dtlBbCgoRmk
	 */
	public void setDtlBbCgoRmk(String dtlBbCgoRmk) {
		this.dtlBbCgoRmk = dtlBbCgoRmk;
	}
	
	/**
	 * Column Info
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setDtlInvAmt(JSPUtil.getParameter(request, prefix + "dtl_inv_amt", ""));
		setDtlLgsCostCd(JSPUtil.getParameter(request, prefix + "dtl_lgs_cost_cd", ""));
		setTmlSoSeq(JSPUtil.getParameter(request, prefix + "tml_so_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setTmlSoDtlSeq(JSPUtil.getParameter(request, prefix + "tml_so_dtl_seq", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDtlBbCgoRmk(JSPUtil.getParameter(request, prefix + "dtl_bb_cgo_rmk", ""));
		setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesBbCgoDtlVO[]
	 */
	public TesBbCgoDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesBbCgoDtlVO[]
	 */
	public TesBbCgoDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesBbCgoDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] dtlInvAmt = (JSPUtil.getParameter(request, prefix	+ "dtl_inv_amt", length));
			String[] dtlLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "dtl_lgs_cost_cd", length));
			String[] tmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] tmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_dtl_seq", length));
			String[] tmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dtlBbCgoRmk = (JSPUtil.getParameter(request, prefix	+ "dtl_bb_cgo_rmk", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));

			
			for (int i = 0; i < length; i++) {
				model = new TesBbCgoDtlVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (dtlInvAmt[i] != null)
					model.setDtlInvAmt(dtlInvAmt[i]);
				if (dtlLgsCostCd[i] != null)
					model.setDtlLgsCostCd(dtlLgsCostCd[i]);
				if (tmlSoSeq[i] != null)
					model.setTmlSoSeq(tmlSoSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (tmlSoDtlSeq[i] != null)
					model.setTmlSoDtlSeq(tmlSoDtlSeq[i]);
				if (tmlSoOfcCtyCd[i] != null)
					model.setTmlSoOfcCtyCd(tmlSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dtlBbCgoRmk[i] != null)
					model.setDtlBbCgoRmk(dtlBbCgoRmk[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesBbCgoDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesBbCgoDtlVO[]
	 */
	public TesBbCgoDtlVO[] getTesBbCgoDtlVOs(){
		TesBbCgoDtlVO[] vos = (TesBbCgoDtlVO[])models.toArray(new TesBbCgoDtlVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlInvAmt = this.dtlInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlLgsCostCd = this.dtlLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq = this.tmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoDtlSeq = this.tmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd = this.tmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlBbCgoRmk = this.dtlBbCgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
