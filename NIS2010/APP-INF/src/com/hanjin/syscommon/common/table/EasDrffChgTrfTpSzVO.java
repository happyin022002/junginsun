/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EasDrffChgTrfTpSzVO.java
*@FileTitle : EasDrffChgTrfTpSzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class EasDrffChgTrfTpSzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EasDrffChgTrfTpSzVO> models = new ArrayList<EasDrffChgTrfTpSzVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chrrFrtTaxVal = null;
	/* Column Info */
	private String drffChgTrfSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String drffChgTrfVerNo = null;
	/* Column Info */
	private String drffChgTrfDtlSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EasDrffChgTrfTpSzVO() {}

	public EasDrffChgTrfTpSzVO(String ibflag, String pagerows, String drffChgTrfSeq, String drffChgTrfVerNo, String drffChgTrfDtlSeq, String cntrTpszCd, String chrrFrtTaxVal, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.chrrFrtTaxVal = chrrFrtTaxVal;
		this.drffChgTrfSeq = drffChgTrfSeq;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.creDt = creDt;
		this.drffChgTrfVerNo = drffChgTrfVerNo;
		this.drffChgTrfDtlSeq = drffChgTrfDtlSeq;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chrr_frt_tax_val", getChrrFrtTaxVal());
		this.hashColumns.put("drff_chg_trf_seq", getDrffChgTrfSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("drff_chg_trf_ver_no", getDrffChgTrfVerNo());
		this.hashColumns.put("drff_chg_trf_dtl_seq", getDrffChgTrfDtlSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chrr_frt_tax_val", "chrrFrtTaxVal");
		this.hashFields.put("drff_chg_trf_seq", "drffChgTrfSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("drff_chg_trf_ver_no", "drffChgTrfVerNo");
		this.hashFields.put("drff_chg_trf_dtl_seq", "drffChgTrfDtlSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return chrrFrtTaxVal
	 */
	public String getChrrFrtTaxVal() {
		return this.chrrFrtTaxVal;
	}
	
	/**
	 * Column Info
	 * @return drffChgTrfSeq
	 */
	public String getDrffChgTrfSeq() {
		return this.drffChgTrfSeq;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return drffChgTrfVerNo
	 */
	public String getDrffChgTrfVerNo() {
		return this.drffChgTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @return drffChgTrfDtlSeq
	 */
	public String getDrffChgTrfDtlSeq() {
		return this.drffChgTrfDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param chrrFrtTaxVal
	 */
	public void setChrrFrtTaxVal(String chrrFrtTaxVal) {
		this.chrrFrtTaxVal = chrrFrtTaxVal;
	}
	
	/**
	 * Column Info
	 * @param drffChgTrfSeq
	 */
	public void setDrffChgTrfSeq(String drffChgTrfSeq) {
		this.drffChgTrfSeq = drffChgTrfSeq;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param drffChgTrfVerNo
	 */
	public void setDrffChgTrfVerNo(String drffChgTrfVerNo) {
		this.drffChgTrfVerNo = drffChgTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @param drffChgTrfDtlSeq
	 */
	public void setDrffChgTrfDtlSeq(String drffChgTrfDtlSeq) {
		this.drffChgTrfDtlSeq = drffChgTrfDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChrrFrtTaxVal(JSPUtil.getParameter(request, prefix + "chrr_frt_tax_val", ""));
		setDrffChgTrfSeq(JSPUtil.getParameter(request, prefix + "drff_chg_trf_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDrffChgTrfVerNo(JSPUtil.getParameter(request, prefix + "drff_chg_trf_ver_no", ""));
		setDrffChgTrfDtlSeq(JSPUtil.getParameter(request, prefix + "drff_chg_trf_dtl_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EasDrffChgTrfTpSzVO[]
	 */
	public EasDrffChgTrfTpSzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EasDrffChgTrfTpSzVO[]
	 */
	public EasDrffChgTrfTpSzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EasDrffChgTrfTpSzVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chrrFrtTaxVal = (JSPUtil.getParameter(request, prefix	+ "chrr_frt_tax_val", length));
			String[] drffChgTrfSeq = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] drffChgTrfVerNo = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_ver_no", length));
			String[] drffChgTrfDtlSeq = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_dtl_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EasDrffChgTrfTpSzVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chrrFrtTaxVal[i] != null)
					model.setChrrFrtTaxVal(chrrFrtTaxVal[i]);
				if (drffChgTrfSeq[i] != null)
					model.setDrffChgTrfSeq(drffChgTrfSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (drffChgTrfVerNo[i] != null)
					model.setDrffChgTrfVerNo(drffChgTrfVerNo[i]);
				if (drffChgTrfDtlSeq[i] != null)
					model.setDrffChgTrfDtlSeq(drffChgTrfDtlSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEasDrffChgTrfTpSzVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EasDrffChgTrfTpSzVO[]
	 */
	public EasDrffChgTrfTpSzVO[] getEasDrffChgTrfTpSzVOs(){
		EasDrffChgTrfTpSzVO[] vos = (EasDrffChgTrfTpSzVO[])models.toArray(new EasDrffChgTrfTpSzVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chrrFrtTaxVal = this.chrrFrtTaxVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfSeq = this.drffChgTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfVerNo = this.drffChgTrfVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfDtlSeq = this.drffChgTrfDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
