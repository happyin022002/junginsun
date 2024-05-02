/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpcSbBkgDtlVO.java
*@FileTitle : SpcSbBkgDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.10  
* 1.0 Creation
* 
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
public class SpcSbBkgDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcSbBkgDtlVO> models = new ArrayList<SpcSbBkgDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lstSbRsnTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String lstSbSubRsnCd = null;
	/* Column Info */
	private String lstSbRsn = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpcSbBkgDtlVO() {}

	public SpcSbBkgDtlVO(String ibflag, String pagerows, String bkgNo, String lstSbRsnTpCd, String lstSbSubRsnCd, String alocSvcCd, String lstSbRsn, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.lstSbRsnTpCd = lstSbRsnTpCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.alocSvcCd = alocSvcCd;
		this.creDt = creDt;
		this.lstSbSubRsnCd = lstSbSubRsnCd;
		this.lstSbRsn = lstSbRsn;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lst_sb_rsn_tp_cd", getLstSbRsnTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lst_sb_sub_rsn_cd", getLstSbSubRsnCd());
		this.hashColumns.put("lst_sb_rsn", getLstSbRsn());
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
		this.hashFields.put("lst_sb_rsn_tp_cd", "lstSbRsnTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lst_sb_sub_rsn_cd", "lstSbSubRsnCd");
		this.hashFields.put("lst_sb_rsn", "lstSbRsn");
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
	 * @return lstSbRsnTpCd
	 */
	public String getLstSbRsnTpCd() {
		return this.lstSbRsnTpCd;
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
	 * @return alocSvcCd
	 */
	public String getAlocSvcCd() {
		return this.alocSvcCd;
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
	 * @return lstSbSubRsnCd
	 */
	public String getLstSbSubRsnCd() {
		return this.lstSbSubRsnCd;
	}
	
	/**
	 * Column Info
	 * @return lstSbRsn
	 */
	public String getLstSbRsn() {
		return this.lstSbRsn;
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
	 * @param lstSbRsnTpCd
	 */
	public void setLstSbRsnTpCd(String lstSbRsnTpCd) {
		this.lstSbRsnTpCd = lstSbRsnTpCd;
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
	 * @param alocSvcCd
	 */
	public void setAlocSvcCd(String alocSvcCd) {
		this.alocSvcCd = alocSvcCd;
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
	 * @param lstSbSubRsnCd
	 */
	public void setLstSbSubRsnCd(String lstSbSubRsnCd) {
		this.lstSbSubRsnCd = lstSbSubRsnCd;
	}
	
	/**
	 * Column Info
	 * @param lstSbRsn
	 */
	public void setLstSbRsn(String lstSbRsn) {
		this.lstSbRsn = lstSbRsn;
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
		setLstSbRsnTpCd(JSPUtil.getParameter(request, prefix + "lst_sb_rsn_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLstSbSubRsnCd(JSPUtil.getParameter(request, prefix + "lst_sb_sub_rsn_cd", ""));
		setLstSbRsn(JSPUtil.getParameter(request, prefix + "lst_sb_rsn", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcSbBkgDtlVO[]
	 */
	public SpcSbBkgDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcSbBkgDtlVO[]
	 */
	public SpcSbBkgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcSbBkgDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lstSbRsnTpCd = (JSPUtil.getParameter(request, prefix	+ "lst_sb_rsn_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] lstSbSubRsnCd = (JSPUtil.getParameter(request, prefix	+ "lst_sb_sub_rsn_cd", length));
			String[] lstSbRsn = (JSPUtil.getParameter(request, prefix	+ "lst_sb_rsn", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcSbBkgDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lstSbRsnTpCd[i] != null)
					model.setLstSbRsnTpCd(lstSbRsnTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (lstSbSubRsnCd[i] != null)
					model.setLstSbSubRsnCd(lstSbSubRsnCd[i]);
				if (lstSbRsn[i] != null)
					model.setLstSbRsn(lstSbRsn[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcSbBkgDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcSbBkgDtlVO[]
	 */
	public SpcSbBkgDtlVO[] getSpcSbBkgDtlVOs(){
		SpcSbBkgDtlVO[] vos = (SpcSbBkgDtlVO[])models.toArray(new SpcSbBkgDtlVO[models.size()]);
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
		this.lstSbRsnTpCd = this.lstSbRsnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSbSubRsnCd = this.lstSbSubRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSbRsn = this.lstSbRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
