/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgNoCaNoVO.java
*@FileTitle : BkgNoCaNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.11.18 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgNoCaNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgNoCaNoVO> models = new ArrayList<BkgNoCaNoVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String invArIfCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String arIfErrRsn = null;
	/* Column Info */
	private String ppdOfc = null;
	/* Column Info */
	private String cctOfc = null;
	/* Column Info */
	private String trnkVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgNoCaNoVO() {}

	public BkgNoCaNoVO(String ibflag, String pagerows, String ppdOfc, String cctOfc, String trnkVvd, String blSrcNo, String srcIfDt, String polCd, String podCd, String bkgNo, String bkgSeq, String invArIfCd, String arIfErrRsn) {
		this.blSrcNo = blSrcNo;
		this.srcIfDt = srcIfDt;
		this.invArIfCd = invArIfCd;
		this.pagerows = pagerows;
		this.bkgSeq = bkgSeq;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.arIfErrRsn = arIfErrRsn;
		this.ppdOfc = ppdOfc;
		this.cctOfc = cctOfc;
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("inv_ar_if_cd", getInvArIfCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ar_if_err_rsn", getArIfErrRsn());
		this.hashColumns.put("ppd_ofc", getPpdOfc());
		this.hashColumns.put("cct_ofc", getCctOfc());
		this.hashColumns.put("trnk_vvd", getTrnkVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("inv_ar_if_cd", "invArIfCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ar_if_err_rsn", "arIfErrRsn");
		this.hashFields.put("ppd_ofc", "ppdOfc");
		this.hashFields.put("cct_ofc", "cctOfc");
		this.hashFields.put("trnk_vvd", "trnkVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return srcIfDt
	 */
	public String getSrcIfDt() {
		return this.srcIfDt;
	}
	
	/**
	 * Column Info
	 * @return invArIfCd
	 */
	public String getInvArIfCd() {
		return this.invArIfCd;
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
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return arIfErrRsn
	 */
	public String getArIfErrRsn() {
		return this.arIfErrRsn;
	}
	
	/**
	 * Column Info
	 * @return ppdOfc
	 */
	public String getPpdOfc() {
		return this.ppdOfc;
	}
	
	/**
	 * Column Info
	 * @return cctOfc
	 */
	public String getCctOfc() {
		return this.cctOfc;
	}
	
	/**
	 * Column Info
	 * @return trnkVvd
	 */
	public String getTrnkVvd() {
		return this.trnkVvd;
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
	 * @param srcIfDt
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}
	
	/**
	 * Column Info
	 * @param invArIfCd
	 */
	public void setInvArIfCd(String invArIfCd) {
		this.invArIfCd = invArIfCd;
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
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param arIfErrRsn
	 */
	public void setArIfErrRsn(String arIfErrRsn) {
		this.arIfErrRsn = arIfErrRsn;
	}
	
	/**
	 * Column Info
	 * @param ppdOfc
	 */
	public void setPpdOfc(String ppdOfc) {
		this.ppdOfc = ppdOfc;
	}
	
	/**
	 * Column Info
	 * @param cctOfc
	 */
	public void setCctOfc(String cctOfc) {
		this.cctOfc = cctOfc;
	}
	
	/**
	 * Column Info
	 * @param trnkVvd
	 */
	public void setTrnkVvd(String trnkVvd) {
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setSrcIfDt(JSPUtil.getParameter(request, "src_if_dt", ""));
		setInvArIfCd(JSPUtil.getParameter(request, "inv_ar_if_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgSeq(JSPUtil.getParameter(request, "bkg_seq", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setArIfErrRsn(JSPUtil.getParameter(request, "ar_if_err_rsn", ""));
		setPpdOfc(JSPUtil.getParameter(request, "ppd_ofc", ""));
		setCctOfc(JSPUtil.getParameter(request, "cct_ofc", ""));
		setTrnkVvd(JSPUtil.getParameter(request, "trnk_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgNoCaNoVO[]
	 */
	public BkgNoCaNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgNoCaNoVO[]
	 */
	public BkgNoCaNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgNoCaNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] invArIfCd = (JSPUtil.getParameter(request, prefix	+ "inv_ar_if_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] arIfErrRsn = (JSPUtil.getParameter(request, prefix	+ "ar_if_err_rsn", length));
			String[] ppdOfc = (JSPUtil.getParameter(request, prefix	+ "ppd_ofc", length));
			String[] cctOfc = (JSPUtil.getParameter(request, prefix	+ "cct_ofc", length));
			String[] trnkVvd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgNoCaNoVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (invArIfCd[i] != null)
					model.setInvArIfCd(invArIfCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (arIfErrRsn[i] != null)
					model.setArIfErrRsn(arIfErrRsn[i]);
				if (ppdOfc[i] != null)
					model.setPpdOfc(ppdOfc[i]);
				if (cctOfc[i] != null)
					model.setCctOfc(cctOfc[i]);
				if (trnkVvd[i] != null)
					model.setTrnkVvd(trnkVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgNoCaNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgNoCaNoVO[]
	 */
	public BkgNoCaNoVO[] getBkgNoCaNoVOs(){
		BkgNoCaNoVO[] vos = (BkgNoCaNoVO[])models.toArray(new BkgNoCaNoVO[models.size()]);
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
		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invArIfCd = this.invArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfErrRsn = this.arIfErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOfc = this.ppdOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOfc = this.cctOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvd = this.trnkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
