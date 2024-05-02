/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageVO.java
*@FileTitle : BkgCopManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.15 김인수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCopManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCopManageVO> models = new ArrayList<BkgCopManageVO>();
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String troSubSeq = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String fmCopNo = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String troBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String tgtBkgNos = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String flgPartial = null;
	/* Column Info */
	private String toCopNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String copBndCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String toBkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fmBkgNo = null;
	/* Column Info */
	private String cntrTpszCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCopManageVO() {}

	public BkgCopManageVO(String ibflag, String pagerows, String copBndCd, String pctlNo, String bkgNo, String cntrNo, String vslCd, String skdVoyNo, String skdDirCd, String copNo, String fmCopNo, String toCopNo, String fmBkgNo, String toBkgNo, String troSeq, String troSubSeq, String troBndCd, String contiCd, String flgPartial, String cntrTpszCd, String fmDt, String toDt, String tgtBkgNos) {
		this.contiCd = contiCd;
		this.vslCd = vslCd;
		this.troSubSeq = troSubSeq;
		this.fmDt = fmDt;
		this.troSeq = troSeq;
		this.fmCopNo = fmCopNo;
		this.copNo = copNo;
		this.skdVoyNo = skdVoyNo;
		this.troBndCd = troBndCd;
		this.skdDirCd = skdDirCd;
		this.tgtBkgNos = tgtBkgNos;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.toDt = toDt;
		this.flgPartial = flgPartial;
		this.toCopNo = toCopNo;
		this.ibflag = ibflag;
		this.copBndCd = copBndCd;
		this.bkgNo = bkgNo;
		this.toBkgNo = toBkgNo;
		this.cntrNo = cntrNo;
		this.fmBkgNo = fmBkgNo;
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("fm_cop_no", getFmCopNo());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("tro_bnd_cd", getTroBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("tgt_bkg_nos", getTgtBkgNos());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("flg_partial", getFlgPartial());
		this.hashColumns.put("to_cop_no", getToCopNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cop_bnd_cd", getCopBndCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("to_bkg_no", getToBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fm_bkg_no", getFmBkgNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("fm_cop_no", "fmCopNo");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("tro_bnd_cd", "troBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("tgt_bkg_nos", "tgtBkgNos");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("flg_partial", "flgPartial");
		this.hashFields.put("to_cop_no", "toCopNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cop_bnd_cd", "copBndCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("to_bkg_no", "toBkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fm_bkg_no", "fmBkgNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
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
	 * @return troSubSeq
	 */
	public String getTroSubSeq() {
		return this.troSubSeq;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return fmCopNo
	 */
	public String getFmCopNo() {
		return this.fmCopNo;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return troBndCd
	 */
	public String getTroBndCd() {
		return this.troBndCd;
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
	 * @return tgtBkgNos
	 */
	public String getTgtBkgNos() {
		return this.tgtBkgNos;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return flgPartial
	 */
	public String getFlgPartial() {
		return this.flgPartial;
	}
	
	/**
	 * Column Info
	 * @return toCopNo
	 */
	public String getToCopNo() {
		return this.toCopNo;
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
	 * @return copBndCd
	 */
	public String getCopBndCd() {
		return this.copBndCd;
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
	 * @return toBkgNo
	 */
	public String getToBkgNo() {
		return this.toBkgNo;
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
	 * @return fmBkgNo
	 */
	public String getFmBkgNo() {
		return this.fmBkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	

	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
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
	 * @param troSubSeq
	 */
	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param fmCopNo
	 */
	public void setFmCopNo(String fmCopNo) {
		this.fmCopNo = fmCopNo;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param troBndCd
	 */
	public void setTroBndCd(String troBndCd) {
		this.troBndCd = troBndCd;
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
	 * @param tgtBkgNos
	 */
	public void setTgtBkgNos(String tgtBkgNos) {
		this.tgtBkgNos = tgtBkgNos;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param flgPartial
	 */
	public void setFlgPartial(String flgPartial) {
		this.flgPartial = flgPartial;
	}
	
	/**
	 * Column Info
	 * @param toCopNo
	 */
	public void setToCopNo(String toCopNo) {
		this.toCopNo = toCopNo;
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
	 * @param copBndCd
	 */
	public void setCopBndCd(String copBndCd) {
		this.copBndCd = copBndCd;
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
	 * @param toBkgNo
	 */
	public void setToBkgNo(String toBkgNo) {
		this.toBkgNo = toBkgNo;
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
	 * @param fmBkgNo
	 */
	public void setFmBkgNo(String fmBkgNo) {
		this.fmBkgNo = fmBkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTroSubSeq(JSPUtil.getParameter(request, prefix + "tro_sub_seq", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setFmCopNo(JSPUtil.getParameter(request, prefix + "fm_cop_no", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTroBndCd(JSPUtil.getParameter(request, prefix + "tro_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setTgtBkgNos(JSPUtil.getParameter(request, prefix + "tgt_bkg_nos", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setFlgPartial(JSPUtil.getParameter(request, prefix + "flg_partial", ""));
		setToCopNo(JSPUtil.getParameter(request, prefix + "to_cop_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCopBndCd(JSPUtil.getParameter(request, prefix + "cop_bnd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setToBkgNo(JSPUtil.getParameter(request, prefix + "to_bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFmBkgNo(JSPUtil.getParameter(request, prefix + "fm_bkg_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCopManageVO[]
	 */
	public BkgCopManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCopManageVO[]
	 */
	public BkgCopManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCopManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix	+ "tro_sub_seq", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] fmCopNo = (JSPUtil.getParameter(request, prefix	+ "fm_cop_no", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] troBndCd = (JSPUtil.getParameter(request, prefix	+ "tro_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] tgtBkgNos = (JSPUtil.getParameter(request, prefix	+ "tgt_bkg_nos", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] flgPartial = (JSPUtil.getParameter(request, prefix	+ "flg_partial", length));
			String[] toCopNo = (JSPUtil.getParameter(request, prefix	+ "to_cop_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] copBndCd = (JSPUtil.getParameter(request, prefix	+ "cop_bnd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] toBkgNo = (JSPUtil.getParameter(request, prefix	+ "to_bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fmBkgNo = (JSPUtil.getParameter(request, prefix	+ "fm_bkg_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCopManageVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (fmCopNo[i] != null)
					model.setFmCopNo(fmCopNo[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (troBndCd[i] != null)
					model.setTroBndCd(troBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (tgtBkgNos[i] != null)
					model.setTgtBkgNos(tgtBkgNos[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (flgPartial[i] != null)
					model.setFlgPartial(flgPartial[i]);
				if (toCopNo[i] != null)
					model.setToCopNo(toCopNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (copBndCd[i] != null)
					model.setCopBndCd(copBndCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (toBkgNo[i] != null)
					model.setToBkgNo(toBkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fmBkgNo[i] != null)
					model.setFmBkgNo(fmBkgNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCopManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCopManageVO[]
	 */
	public BkgCopManageVO[] getBkgCopManageVOs(){
		BkgCopManageVO[] vos = (BkgCopManageVO[])models.toArray(new BkgCopManageVO[models.size()]);
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
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq = this.troSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCopNo = this.fmCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troBndCd = this.troBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtBkgNos = this.tgtBkgNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgPartial = this.flgPartial .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCopNo = this.toCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copBndCd = this.copBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toBkgNo = this.toBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmBkgNo = this.fmBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
