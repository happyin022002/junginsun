/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgXterBbCgoVO.java
*@FileTitle : BkgXterBbCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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

public class BkgXterBbCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgXterBbCgoVO> models = new ArrayList<BkgXterBbCgoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String dimWdt = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	private String grsWgtUtCd = null;
	/* Column Info */
	private String bbCgoSeq = null;
	/* Column Info */
	private String dimHgt = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String grsWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String cgoDchgSdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgXterBbCgoVO() {}

	public BkgXterBbCgoVO(String ibflag, String pagerows, String bbCgoSeq, String pckQty, String pckTpCd, String grsWgt, String grsWgtUtCd, String dimLen, String dimWdt, String dimHgt, String diffRmk, String cgoDchgSdCd) {
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.dimWdt = dimWdt;
		this.dimLen = dimLen;
		this.grsWgtUtCd = grsWgtUtCd;
		this.bbCgoSeq = bbCgoSeq;
		this.dimHgt = dimHgt;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.grsWgt = grsWgt;
		this.pagerows = pagerows;
		this.cgoDchgSdCd = cgoDchgSdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("dim_wdt", getDimWdt());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("grs_wgt_ut_cd", getGrsWgtUtCd());
		this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
		this.hashColumns.put("dim_hgt", getDimHgt());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cgo_dchg_sd_cd", getCgoDchgSdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("dim_wdt", "dimWdt");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("grs_wgt_ut_cd", "grsWgtUtCd");
		this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
		this.hashFields.put("dim_hgt", "dimHgt");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cgo_dchg_sd_cd", "cgoDchgSdCd");
		return this.hashFields;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return dimWdt
	 */
	public String getDimWdt() {
		return this.dimWdt;
	}
	
	/**
	 * Column Info
	 * @return dimLen
	 */
	public String getDimLen() {
		return this.dimLen;
	}
	
	/**
	 * Column Info
	 * @return grsWgtUtCd
	 */
	public String getGrsWgtUtCd() {
		return this.grsWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return bbCgoSeq
	 */
	public String getBbCgoSeq() {
		return this.bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return dimHgt
	 */
	public String getDimHgt() {
		return this.dimHgt;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param dimWdt
	 */
	public void setDimWdt(String dimWdt) {
		this.dimWdt = dimWdt;
	}
	
	/**
	 * Column Info
	 * @param dimLen
	 */
	public void setDimLen(String dimLen) {
		this.dimLen = dimLen;
	}
	
	/**
	 * Column Info
	 * @param grsWgtUtCd
	 */
	public void setGrsWgtUtCd(String grsWgtUtCd) {
		this.grsWgtUtCd = grsWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param bbCgoSeq
	 */
	public void setBbCgoSeq(String bbCgoSeq) {
		this.bbCgoSeq = bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param dimHgt
	 */
	public void setDimHgt(String dimHgt) {
		this.dimHgt = dimHgt;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getCgoDchgSdCd() {
		return cgoDchgSdCd;
	}

	public void setCgoDchgSdCd(String cgoDchgSdCd) {
		this.cgoDchgSdCd = cgoDchgSdCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setDimWdt(JSPUtil.getParameter(request, prefix + "dim_wdt", ""));
		setDimLen(JSPUtil.getParameter(request, prefix + "dim_len", ""));
		setGrsWgtUtCd(JSPUtil.getParameter(request, prefix + "grs_wgt_ut_cd", ""));
		setBbCgoSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_seq", ""));
		setDimHgt(JSPUtil.getParameter(request, prefix + "dim_hgt", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCgoDchgSdCd(JSPUtil.getParameter(request, prefix + "cgo_dchg_sd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterBbCgoVO[]
	 */
	public BkgXterBbCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterBbCgoVO[]
	 */
	public BkgXterBbCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgXterBbCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] dimWdt = (JSPUtil.getParameter(request, prefix	+ "dim_wdt", length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix	+ "dim_len", length));
			String[] grsWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_ut_cd", length));
			String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_seq", length));
			String[] dimHgt = (JSPUtil.getParameter(request, prefix	+ "dim_hgt", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cgoDchgSdCd = (JSPUtil.getParameter(request, prefix	+ "cgo_dchg_sd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgXterBbCgoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (dimWdt[i] != null)
					model.setDimWdt(dimWdt[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (grsWgtUtCd[i] != null)
					model.setGrsWgtUtCd(grsWgtUtCd[i]);
				if (bbCgoSeq[i] != null)
					model.setBbCgoSeq(bbCgoSeq[i]);
				if (dimHgt[i] != null)
					model.setDimHgt(dimHgt[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cgoDchgSdCd[i] != null)
					model.setCgoDchgSdCd(cgoDchgSdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgXterBbCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgXterBbCgoVO[]
	 */
	public BkgXterBbCgoVO[] getBkgXterBbCgoVOs(){
		BkgXterBbCgoVO[] vos = (BkgXterBbCgoVO[])models.toArray(new BkgXterBbCgoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimWdt = this.dimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtUtCd = this.grsWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoSeq = this.bbCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimHgt = this.dimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDchgSdCd = this.cgoDchgSdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
