/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesBbCgoCostVO.java
*@FileTitle : TesBbCgoCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.20
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.20 이혜민 
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

public class TesBbCgoCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesBbCgoCostVO> models = new ArrayList<TesBbCgoCostVO>();
	
	/* Column Info */
	private String chkYdUseYn = null;
	/* Column Info */
	private String bbCgoTpSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String chkDelYn = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String bbCgoRmk = null;
	/* Column Info */
	private String bbCgoDesc = null;
	/* Column Info */
	private String tmlSoSeq = null;
	/* Column Info */
	private String tmlSoDtlSeq = null;
	/* Column Info */
	private String tmlSoOfcCtyCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ioBndCd = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesBbCgoCostVO() {}

	public TesBbCgoCostVO(String ioBndCd, String vvd, String ibflag, String pagerows, String bbCgoTpSeq, String lgsCostCd, String bbCgoDesc, String invAmt, String bbCgoRmk, String chkYdUseYn, String chkDelYn, String bkgNo, String ydCd, String tmlSoOfcCtyCd, String tmlSoSeq, String tmlSoDtlSeq) {
		this.chkYdUseYn = chkYdUseYn;
		this.bbCgoTpSeq = bbCgoTpSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.ydCd = ydCd;
		this.chkDelYn = chkDelYn;
		this.lgsCostCd = lgsCostCd;
		this.invAmt = invAmt;
		this.bbCgoRmk = bbCgoRmk;
		this.bbCgoDesc = bbCgoDesc;
		this.tmlSoSeq = tmlSoSeq;
		this.tmlSoDtlSeq = tmlSoDtlSeq;
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
		this.vvd = vvd;
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chk_yd_use_yn", getChkYdUseYn());
		this.hashColumns.put("bb_cgo_tp_seq", getBbCgoTpSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("chk_del_yn", getChkDelYn());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("bb_cgo_rmk", getBbCgoRmk());
		this.hashColumns.put("bb_cgo_desc", getBbCgoDesc());
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());
		this.hashColumns.put("tml_so_dtl_seq", getTmlSoDtlSeq());
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chk_yd_use_yn", "chkYdUseYn");
		this.hashFields.put("bb_cgo_tp_seq", "bbCgoTpSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("chk_del_yn", "chkDelYn");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("bb_cgo_rmk", "bbCgoRmk");
		this.hashFields.put("bb_cgo_desc", "bbCgoDesc");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("tml_so_dtl_seq", "tmlSoDtlSeq");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chkYdUseYn
	 */
	public String getChkYdUseYn() {
		return this.chkYdUseYn;
	}
	
	/**
	 * Column Info
	 * @return bbCgoTpSeq
	 */
	public String getBbCgoTpSeq() {
		return this.bbCgoTpSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return chkDelYn
	 */
	public String getChkDelYn() {
		return this.chkDelYn;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return bbCgoRmk
	 */
	public String getBbCgoRmk() {
		return this.bbCgoRmk;
	}
	
	/**
	 * Column Info
	 * @return bbCgoDesc
	 */
	public String getBbCgoDesc() {
		return this.bbCgoDesc;
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
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @param chkYdUseYn
	 */
	public void setChkYdUseYn(String chkYdUseYn) {
		this.chkYdUseYn = chkYdUseYn;
	}
	
	/**
	 * Column Info
	 * @param bbCgoTpSeq
	 */
	public void setBbCgoTpSeq(String bbCgoTpSeq) {
		this.bbCgoTpSeq = bbCgoTpSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param chkDelYn
	 */
	public void setChkDelYn(String chkDelYn) {
		this.chkDelYn = chkDelYn;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param bbCgoRmk
	 */
	public void setBbCgoRmk(String bbCgoRmk) {
		this.bbCgoRmk = bbCgoRmk;
	}
	
	/**
	 * Column Info
	 * @param bbCgoDesc
	 */
	public void setBbCgoDesc(String bbCgoDesc) {
		this.bbCgoDesc = bbCgoDesc;
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
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
		setChkYdUseYn(JSPUtil.getParameter(request, prefix + "chk_yd_use_yn", ""));
		setBbCgoTpSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_tp_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setChkDelYn(JSPUtil.getParameter(request, prefix + "chk_del_yn", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setBbCgoRmk(JSPUtil.getParameter(request, prefix + "bb_cgo_rmk", ""));
		setBbCgoDesc(JSPUtil.getParameter(request, prefix + "bb_cgo_desc", ""));
		setTmlSoSeq(JSPUtil.getParameter(request, prefix + "tml_so_seq", ""));
		setTmlSoDtlSeq(JSPUtil.getParameter(request, prefix + "tml_so_dtl_seq", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_so_ofc_cty_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesBbCgoCostVO[]
	 */
	public TesBbCgoCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesBbCgoCostVO[]
	 */
	public TesBbCgoCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesBbCgoCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chkYdUseYn = (JSPUtil.getParameter(request, prefix	+ "chk_yd_use_yn", length));
			String[] bbCgoTpSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_tp_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] chkDelYn = (JSPUtil.getParameter(request, prefix	+ "chk_del_yn", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] bbCgoRmk = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_rmk", length));
			String[] bbCgoDesc = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_desc", length));
			String[] tmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_seq", length));
			String[] tmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_dtl_seq", length));
			String[] tmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_so_ofc_cty_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));

			for (int i = 0; i < length; i++) {
				model = new TesBbCgoCostVO();
				if (chkYdUseYn[i] != null)
					model.setChkYdUseYn(chkYdUseYn[i]);
				if (bbCgoTpSeq[i] != null)
					model.setBbCgoTpSeq(bbCgoTpSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (chkDelYn[i] != null)
					model.setChkDelYn(chkDelYn[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (bbCgoRmk[i] != null)
					model.setBbCgoRmk(bbCgoRmk[i]);
				if (bbCgoDesc[i] != null)
					model.setBbCgoDesc(bbCgoDesc[i]);
				if (tmlSoSeq[i] != null)
					model.setTmlSoSeq(tmlSoSeq[i]);
				if (tmlSoDtlSeq[i] != null)
					model.setTmlSoDtlSeq(tmlSoDtlSeq[i]);
				if (tmlSoOfcCtyCd[i] != null)
					model.setTmlSoOfcCtyCd(tmlSoOfcCtyCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesBbCgoCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesBbCgoCostVO[]
	 */
	public TesBbCgoCostVO[] getTesBbCgoCostVOs(){
		TesBbCgoCostVO[] vos = (TesBbCgoCostVO[])models.toArray(new TesBbCgoCostVO[models.size()]);
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
		this.chkYdUseYn = this.chkYdUseYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoTpSeq = this.bbCgoTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDelYn = this.chkDelYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoRmk = this.bbCgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoDesc = this.bbCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq = this.tmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoDtlSeq = this.tmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd = this.tmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
