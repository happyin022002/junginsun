/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurTroChangeVO.java
*@FileTitle : EurTroChangeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.06.29 Maeda Atsushi 
* 1.0 Creation
=========================================================*/
 
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Maeda Atsushi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurTroChangeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurTroChangeVO> models = new ArrayList<EurTroChangeVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrRtnYdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrPkupYdCd = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String bkgTrspMzdCd = null;
	/* Column Info */
	private String hlgTpCd = null;
	/* Column Info */
	private String cntrRtnDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EurTroChangeVO() {}

	public EurTroChangeVO(String ibflag, String pagerows, String bkgNo, String troSeq, String cntrPkupYdCd, String cntrRtnYdCd, String cntrRtnDt, String hlgTpCd, String cntrNo, String bkgTrspMzdCd, String znCd) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrRtnYdCd = cntrRtnYdCd;
		this.cntrNo = cntrNo;
		this.cntrPkupYdCd = cntrPkupYdCd;
		this.troSeq = troSeq;
		this.znCd = znCd;
		this.bkgTrspMzdCd = bkgTrspMzdCd;
		this.hlgTpCd = hlgTpCd;
		this.cntrRtnDt = cntrRtnDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_pkup_yd_cd", getCntrPkupYdCd());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("bkg_trsp_mzd_cd", getBkgTrspMzdCd());
		this.hashColumns.put("hlg_tp_cd", getHlgTpCd());
		this.hashColumns.put("cntr_rtn_dt", getCntrRtnDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_pkup_yd_cd", "cntrPkupYdCd");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("bkg_trsp_mzd_cd", "bkgTrspMzdCd");
		this.hashFields.put("hlg_tp_cd", "hlgTpCd");
		this.hashFields.put("cntr_rtn_dt", "cntrRtnDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return cntrRtnYdCd
	 */
	public String getCntrRtnYdCd() {
		return this.cntrRtnYdCd;
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
	 * @return cntrPkupYdCd
	 */
	public String getCntrPkupYdCd() {
		return this.cntrPkupYdCd;
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
	 * @return znCd
	 */
	public String getZnCd() {
		return this.znCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTrspMzdCd
	 */
	public String getBkgTrspMzdCd() {
		return this.bkgTrspMzdCd;
	}
	
	/**
	 * Column Info
	 * @return hlgTpCd
	 */
	public String getHlgTpCd() {
		return this.hlgTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnDt
	 */
	public String getCntrRtnDt() {
		return this.cntrRtnDt;
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
	 * @param cntrRtnYdCd
	 */
	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
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
	 * @param cntrPkupYdCd
	 */
	public void setCntrPkupYdCd(String cntrPkupYdCd) {
		this.cntrPkupYdCd = cntrPkupYdCd;
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
	 * @param znCd
	 */
	public void setZnCd(String znCd) {
		this.znCd = znCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTrspMzdCd
	 */
	public void setBkgTrspMzdCd(String bkgTrspMzdCd) {
		this.bkgTrspMzdCd = bkgTrspMzdCd;
	}
	
	/**
	 * Column Info
	 * @param hlgTpCd
	 */
	public void setHlgTpCd(String hlgTpCd) {
		this.hlgTpCd = hlgTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnDt
	 */
	public void setCntrRtnDt(String cntrRtnDt) {
		this.cntrRtnDt = cntrRtnDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrPkupYdCd(JSPUtil.getParameter(request, prefix + "cntr_pkup_yd_cd", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setZnCd(JSPUtil.getParameter(request, prefix + "zn_cd", ""));
		setBkgTrspMzdCd(JSPUtil.getParameter(request, prefix + "bkg_trsp_mzd_cd", ""));
		setHlgTpCd(JSPUtil.getParameter(request, prefix + "hlg_tp_cd", ""));
		setCntrRtnDt(JSPUtil.getParameter(request, prefix + "cntr_rtn_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurTroChangeVO[]
	 */
	public EurTroChangeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurTroChangeVO[]
	 */
	public EurTroChangeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurTroChangeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_yd_cd", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd", length));
			String[] bkgTrspMzdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_trsp_mzd_cd", length));
			String[] hlgTpCd = (JSPUtil.getParameter(request, prefix	+ "hlg_tp_cd", length));
			String[] cntrRtnDt = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurTroChangeVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrRtnYdCd[i] != null)
					model.setCntrRtnYdCd(cntrRtnYdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrPkupYdCd[i] != null)
					model.setCntrPkupYdCd(cntrPkupYdCd[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (bkgTrspMzdCd[i] != null)
					model.setBkgTrspMzdCd(bkgTrspMzdCd[i]);
				if (hlgTpCd[i] != null)
					model.setHlgTpCd(hlgTpCd[i]);
				if (cntrRtnDt[i] != null)
					model.setCntrRtnDt(cntrRtnDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurTroChangeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurTroChangeVO[]
	 */
	public EurTroChangeVO[] getEurTroChangeVOs(){
		EurTroChangeVO[] vos = (EurTroChangeVO[])models.toArray(new EurTroChangeVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd = this.cntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupYdCd = this.cntrPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspMzdCd = this.bkgTrspMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgTpCd = this.hlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDt = this.cntrRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
