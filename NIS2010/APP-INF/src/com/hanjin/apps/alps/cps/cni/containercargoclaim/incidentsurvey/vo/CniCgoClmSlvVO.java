/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniCgoClmSlvVO.java
*@FileTitle : CniCgoClmSlvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.10.22 양정란 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniCgoClmSlvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniCgoClmSlvVO> models = new ArrayList<CniCgoClmSlvVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String slvUsdAmt = null;
	/* Column Info */
	private String slvLoclCurrCd = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String refSlvNo = null;
	/* Column Info */
	private String slvDesc = null;
	/* Column Info */
	private String slvLoclAmt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String slvXchRt = null;
	/* Column Info */
	private String slvDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniCgoClmSlvVO() {}

	public CniCgoClmSlvVO(String ibflag, String pagerows, String cgoClmNo, String clmPtyNo, String refSlvNo, String slvDt, String slvUsdAmt, String slvLoclAmt, String slvLoclCurrCd, String slvXchRt, String slvDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.slvUsdAmt = slvUsdAmt;
		this.slvLoclCurrCd = slvLoclCurrCd;
		this.clmPtyNo = clmPtyNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.refSlvNo = refSlvNo;
		this.slvDesc = slvDesc;
		this.slvLoclAmt = slvLoclAmt;
		this.cgoClmNo = cgoClmNo;
		this.slvXchRt = slvXchRt;
		this.slvDt = slvDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("slv_usd_amt", getSlvUsdAmt());
		this.hashColumns.put("slv_locl_curr_cd", getSlvLoclCurrCd());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ref_slv_no", getRefSlvNo());
		this.hashColumns.put("slv_desc", getSlvDesc());
		this.hashColumns.put("slv_locl_amt", getSlvLoclAmt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("slv_xch_rt", getSlvXchRt());
		this.hashColumns.put("slv_dt", getSlvDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("slv_usd_amt", "slvUsdAmt");
		this.hashFields.put("slv_locl_curr_cd", "slvLoclCurrCd");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ref_slv_no", "refSlvNo");
		this.hashFields.put("slv_desc", "slvDesc");
		this.hashFields.put("slv_locl_amt", "slvLoclAmt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("slv_xch_rt", "slvXchRt");
		this.hashFields.put("slv_dt", "slvDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return slvUsdAmt
	 */
	public String getSlvUsdAmt() {
		return this.slvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return slvLoclCurrCd
	 */
	public String getSlvLoclCurrCd() {
		return this.slvLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return clmPtyNo
	 */
	public String getClmPtyNo() {
		return this.clmPtyNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return refSlvNo
	 */
	public String getRefSlvNo() {
		return this.refSlvNo;
	}
	
	/**
	 * Column Info
	 * @return slvDesc
	 */
	public String getSlvDesc() {
		return this.slvDesc;
	}
	
	/**
	 * Column Info
	 * @return slvLoclAmt
	 */
	public String getSlvLoclAmt() {
		return this.slvLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return slvXchRt
	 */
	public String getSlvXchRt() {
		return this.slvXchRt;
	}
	
	/**
	 * Column Info
	 * @return slvDt
	 */
	public String getSlvDt() {
		return this.slvDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param slvUsdAmt
	 */
	public void setSlvUsdAmt(String slvUsdAmt) {
		this.slvUsdAmt = slvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param slvLoclCurrCd
	 */
	public void setSlvLoclCurrCd(String slvLoclCurrCd) {
		this.slvLoclCurrCd = slvLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param clmPtyNo
	 */
	public void setClmPtyNo(String clmPtyNo) {
		this.clmPtyNo = clmPtyNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param refSlvNo
	 */
	public void setRefSlvNo(String refSlvNo) {
		this.refSlvNo = refSlvNo;
	}
	
	/**
	 * Column Info
	 * @param slvDesc
	 */
	public void setSlvDesc(String slvDesc) {
		this.slvDesc = slvDesc;
	}
	
	/**
	 * Column Info
	 * @param slvLoclAmt
	 */
	public void setSlvLoclAmt(String slvLoclAmt) {
		this.slvLoclAmt = slvLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param slvXchRt
	 */
	public void setSlvXchRt(String slvXchRt) {
		this.slvXchRt = slvXchRt;
	}
	
	/**
	 * Column Info
	 * @param slvDt
	 */
	public void setSlvDt(String slvDt) {
		this.slvDt = slvDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSlvUsdAmt(JSPUtil.getParameter(request, "slv_usd_amt", ""));
		setSlvLoclCurrCd(JSPUtil.getParameter(request, "slv_locl_curr_cd", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRefSlvNo(JSPUtil.getParameter(request, "ref_slv_no", ""));
		setSlvDesc(JSPUtil.getParameter(request, "slv_desc", ""));
		setSlvLoclAmt(JSPUtil.getParameter(request, "slv_locl_amt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setSlvXchRt(JSPUtil.getParameter(request, "slv_xch_rt", ""));
		setSlvDt(JSPUtil.getParameter(request, "slv_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniCgoClmSlvVO[]
	 */
	public CniCgoClmSlvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniCgoClmSlvVO[]
	 */
	public CniCgoClmSlvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniCgoClmSlvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] slvUsdAmt = (JSPUtil.getParameter(request, prefix	+ "slv_usd_amt", length));
			String[] slvLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "slv_locl_curr_cd", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] refSlvNo = (JSPUtil.getParameter(request, prefix	+ "ref_slv_no", length));
			String[] slvDesc = (JSPUtil.getParameter(request, prefix	+ "slv_desc", length));
			String[] slvLoclAmt = (JSPUtil.getParameter(request, prefix	+ "slv_locl_amt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] slvXchRt = (JSPUtil.getParameter(request, prefix	+ "slv_xch_rt", length));
			String[] slvDt = (JSPUtil.getParameter(request, prefix	+ "slv_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniCgoClmSlvVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (slvUsdAmt[i] != null)
					model.setSlvUsdAmt(slvUsdAmt[i]);
				if (slvLoclCurrCd[i] != null)
					model.setSlvLoclCurrCd(slvLoclCurrCd[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (refSlvNo[i] != null)
					model.setRefSlvNo(refSlvNo[i]);
				if (slvDesc[i] != null)
					model.setSlvDesc(slvDesc[i]);
				if (slvLoclAmt[i] != null)
					model.setSlvLoclAmt(slvLoclAmt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (slvXchRt[i] != null)
					model.setSlvXchRt(slvXchRt[i]);
				if (slvDt[i] != null)
					model.setSlvDt(slvDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniCgoClmSlvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniCgoClmSlvVO[]
	 */
	public CniCgoClmSlvVO[] getCniCgoClmSlvVOs(){
		CniCgoClmSlvVO[] vos = (CniCgoClmSlvVO[])models.toArray(new CniCgoClmSlvVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvUsdAmt = this.slvUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvLoclCurrCd = this.slvLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSlvNo = this.refSlvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvDesc = this.slvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvLoclAmt = this.slvLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvXchRt = this.slvXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvDt = this.slvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
