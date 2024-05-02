/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BundlingListVO.java
*@FileTitle : BundlingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.02  
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.07.14 김영철 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
=========================================================*/

package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo;

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

public class BundlingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BundlingListVO> models = new ArrayList<BundlingListVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String mcntrBdlGrpSeq = null;
	/* Column Info */
	private String mcntrBdlSeq = null;
	/* Column Info */
	private String bundlSts = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String mtyBdlCntrQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String ibcheck = null;
	/* Column Info */
	private String trspCrrModCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BundlingListVO() {}

	public BundlingListVO(String ibflag, String pagerows, String ibcheck, String mcntrBdlGrpSeq, String mcntrBdlSeq, String eqNo, String eqTpszCd, String bundlSts, String trspCrrModCd, String fmNodCd, String toNodCd, String trspSoOfcCtyCd, String trspSoSeq, String mtyBdlCntrQty) {
		this.toNodCd = toNodCd;
		this.trspSoSeq = trspSoSeq;
		this.mcntrBdlGrpSeq = mcntrBdlGrpSeq;
		this.mcntrBdlSeq = mcntrBdlSeq;
		this.bundlSts = bundlSts;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.fmNodCd = fmNodCd;
		this.mtyBdlCntrQty = mtyBdlCntrQty;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.ibcheck = ibcheck;
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("mcntr_bdl_grp_seq", getMcntrBdlGrpSeq());
		this.hashColumns.put("mcntr_bdl_seq", getMcntrBdlSeq());
		this.hashColumns.put("bundl_sts", getBundlSts());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("mty_bdl_cntr_qty", getMtyBdlCntrQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("ibcheck", getIbcheck());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("mcntr_bdl_grp_seq", "mcntrBdlGrpSeq");
		this.hashFields.put("mcntr_bdl_seq", "mcntrBdlSeq");
		this.hashFields.put("bundl_sts", "bundlSts");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("mty_bdl_cntr_qty", "mtyBdlCntrQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("ibcheck", "ibcheck");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return mcntrBdlGrpSeq
	 */
	public String getMcntrBdlGrpSeq() {
		return this.mcntrBdlGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return mcntrBdlSeq
	 */
	public String getMcntrBdlSeq() {
		return this.mcntrBdlSeq;
	}
	
	/**
	 * Column Info
	 * @return bundlSts
	 */
	public String getBundlSts() {
		return this.bundlSts;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return mtyBdlCntrQty
	 */
	public String getMtyBdlCntrQty() {
		return this.mtyBdlCntrQty;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return ibcheck
	 */
	public String getIbcheck() {
		return this.ibcheck;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param mcntrBdlGrpSeq
	 */
	public void setMcntrBdlGrpSeq(String mcntrBdlGrpSeq) {
		this.mcntrBdlGrpSeq = mcntrBdlGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param mcntrBdlSeq
	 */
	public void setMcntrBdlSeq(String mcntrBdlSeq) {
		this.mcntrBdlSeq = mcntrBdlSeq;
	}
	
	/**
	 * Column Info
	 * @param bundlSts
	 */
	public void setBundlSts(String bundlSts) {
		this.bundlSts = bundlSts;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param mtyBdlCntrQty
	 */
	public void setMtyBdlCntrQty(String mtyBdlCntrQty) {
		this.mtyBdlCntrQty = mtyBdlCntrQty;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param ibcheck
	 */
	public void setIbcheck(String ibcheck) {
		this.ibcheck = ibcheck;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setMcntrBdlGrpSeq(JSPUtil.getParameter(request, prefix + "mcntr_bdl_grp_seq", ""));
		setMcntrBdlSeq(JSPUtil.getParameter(request, prefix + "mcntr_bdl_seq", ""));
		setBundlSts(JSPUtil.getParameter(request, prefix + "bundl_sts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setMtyBdlCntrQty(JSPUtil.getParameter(request, prefix + "mty_bdl_cntr_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setIbcheck(JSPUtil.getParameter(request, prefix + "ibcheck", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BundlingListVO[]
	 */
	public BundlingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BundlingListVO[]
	 */
	public BundlingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BundlingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] mcntrBdlGrpSeq = (JSPUtil.getParameter(request, prefix	+ "mcntr_bdl_grp_seq", length));
			String[] mcntrBdlSeq = (JSPUtil.getParameter(request, prefix	+ "mcntr_bdl_seq", length));
			String[] bundlSts = (JSPUtil.getParameter(request, prefix	+ "bundl_sts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] mtyBdlCntrQty = (JSPUtil.getParameter(request, prefix	+ "mty_bdl_cntr_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] ibcheck = (JSPUtil.getParameter(request, prefix	+ "ibcheck", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BundlingListVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (mcntrBdlGrpSeq[i] != null)
					model.setMcntrBdlGrpSeq(mcntrBdlGrpSeq[i]);
				if (mcntrBdlSeq[i] != null)
					model.setMcntrBdlSeq(mcntrBdlSeq[i]);
				if (bundlSts[i] != null)
					model.setBundlSts(bundlSts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (mtyBdlCntrQty[i] != null)
					model.setMtyBdlCntrQty(mtyBdlCntrQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (ibcheck[i] != null)
					model.setIbcheck(ibcheck[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBundlingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BundlingListVO[]
	 */
	public BundlingListVO[] getBundlingListVOs(){
		BundlingListVO[] vos = (BundlingListVO[])models.toArray(new BundlingListVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrBdlGrpSeq = this.mcntrBdlGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrBdlSeq = this.mcntrBdlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bundlSts = this.bundlSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBdlCntrQty = this.mtyBdlCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibcheck = this.ibcheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
