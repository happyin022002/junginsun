/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PriRcvDeTermMapgVO.java
*@FileTitle : PriRcvDeTermMapgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.23 문동선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriRcvDeTermMapgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriRcvDeTermMapgVO> models = new ArrayList<PriRcvDeTermMapgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String repSvcScpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String bkgRcvDeTermCd = null;
	/* Column Info */
	private String prcCtrtTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ctrtRcvDeTermCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriRcvDeTermMapgVO() {}

	public PriRcvDeTermMapgVO(String ibflag, String pagerows, String prcCtrtTpCd, String repSvcScpCd, String orgDestTpCd, String bkgRcvDeTermCd, String ctrtRcvDeTermCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.repSvcScpCd = repSvcScpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creDt = creDt;
		this.orgDestTpCd = orgDestTpCd;
		this.bkgRcvDeTermCd = bkgRcvDeTermCd;
		this.prcCtrtTpCd = prcCtrtTpCd;
		this.updUsrId = updUsrId;
		this.ctrtRcvDeTermCd = ctrtRcvDeTermCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rep_svc_scp_cd", getRepSvcScpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("bkg_rcv_de_term_cd", getBkgRcvDeTermCd());
		this.hashColumns.put("prc_ctrt_tp_cd", getPrcCtrtTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ctrt_rcv_de_term_cd", getCtrtRcvDeTermCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rep_svc_scp_cd", "repSvcScpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("bkg_rcv_de_term_cd", "bkgRcvDeTermCd");
		this.hashFields.put("prc_ctrt_tp_cd", "prcCtrtTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ctrt_rcv_de_term_cd", "ctrtRcvDeTermCd");
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
	 * @return repSvcScpCd
	 */
	public String getRepSvcScpCd() {
		return this.repSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvDeTermCd
	 */
	public String getBkgRcvDeTermCd() {
		return this.bkgRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtTpCd
	 */
	public String getPrcCtrtTpCd() {
		return this.prcCtrtTpCd;
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
	 * @return ctrtRcvDeTermCd
	 */
	public String getCtrtRcvDeTermCd() {
		return this.ctrtRcvDeTermCd;
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
	 * @param repSvcScpCd
	 */
	public void setRepSvcScpCd(String repSvcScpCd) {
		this.repSvcScpCd = repSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvDeTermCd
	 */
	public void setBkgRcvDeTermCd(String bkgRcvDeTermCd) {
		this.bkgRcvDeTermCd = bkgRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtTpCd
	 */
	public void setPrcCtrtTpCd(String prcCtrtTpCd) {
		this.prcCtrtTpCd = prcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ctrtRcvDeTermCd
	 */
	public void setCtrtRcvDeTermCd(String ctrtRcvDeTermCd) {
		this.ctrtRcvDeTermCd = ctrtRcvDeTermCd;
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
		setRepSvcScpCd(JSPUtil.getParameter(request, prefix + "rep_svc_scp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setBkgRcvDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_de_term_cd", ""));
		setPrcCtrtTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCtrtRcvDeTermCd(JSPUtil.getParameter(request, prefix + "ctrt_rcv_de_term_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriRcvDeTermMapgVO[]
	 */
	public PriRcvDeTermMapgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriRcvDeTermMapgVO[]
	 */
	public PriRcvDeTermMapgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriRcvDeTermMapgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] repSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "rep_svc_scp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] bkgRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_de_term_cd", length));
			String[] prcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ctrtRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_rcv_de_term_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriRcvDeTermMapgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (repSvcScpCd[i] != null)
					model.setRepSvcScpCd(repSvcScpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (bkgRcvDeTermCd[i] != null)
					model.setBkgRcvDeTermCd(bkgRcvDeTermCd[i]);
				if (prcCtrtTpCd[i] != null)
					model.setPrcCtrtTpCd(prcCtrtTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ctrtRcvDeTermCd[i] != null)
					model.setCtrtRcvDeTermCd(ctrtRcvDeTermCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriRcvDeTermMapgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriRcvDeTermMapgVO[]
	 */
	public PriRcvDeTermMapgVO[] getPriRcvDeTermMapgVOs(){
		PriRcvDeTermMapgVO[] vos = (PriRcvDeTermMapgVO[])models.toArray(new PriRcvDeTermMapgVO[models.size()]);
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
		this.repSvcScpCd = this.repSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvDeTermCd = this.bkgRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtTpCd = this.prcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRcvDeTermCd = this.ctrtRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
