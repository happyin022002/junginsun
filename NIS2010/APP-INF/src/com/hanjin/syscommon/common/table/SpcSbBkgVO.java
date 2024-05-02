/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpcSbBkgVO.java
*@FileTitle : SpcSbBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.03.24 Arie 
* 1.0 Creation
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
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
 * @author Arie
 * @since J2EE 1.6
 * @see AbstractValueObject
 */


public class SpcSbBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcSbBkgVO> models = new ArrayList<SpcSbBkgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lstSbRsnTpCd = null;
	/* Column Info */
	private String lstSbDt = null;
	/* Column Info */
	private String cnddtCfmDt = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cfmRqstFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cfmRqstDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cnddtCfmFlg = null;
	/* Column Info */
	private String lstSbRsn = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String cfmRqstUsrId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpcSbBkgVO() {}

	public SpcSbBkgVO(String ibflag, String pagerows, String bkgNo, String cfmRqstFlg, String cfmRqstUsrId, String cfmRqstDt, String lstSbRsnTpCd, String lstSbRsn, String lstSbDt, String cnddtCfmFlg, String cnddtCfmDt, String cfmUsrId, String cfmDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.lstSbRsnTpCd = lstSbRsnTpCd;
		this.lstSbDt = lstSbDt;
		this.cnddtCfmDt = cnddtCfmDt;
		this.cfmDt = cfmDt;
		this.creDt = creDt;
		this.cfmRqstFlg = cfmRqstFlg;
		this.pagerows = pagerows;
		this.cfmRqstDt = cfmRqstDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cnddtCfmFlg = cnddtCfmFlg;
		this.lstSbRsn = lstSbRsn;
		this.cfmUsrId = cfmUsrId;
		this.cfmRqstUsrId = cfmRqstUsrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lst_sb_rsn_tp_cd", getLstSbRsnTpCd());
		this.hashColumns.put("lst_sb_dt", getLstSbDt());
		this.hashColumns.put("cnddt_cfm_dt", getCnddtCfmDt());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cfm_rqst_flg", getCfmRqstFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cfm_rqst_dt", getCfmRqstDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnddt_cfm_flg", getCnddtCfmFlg());
		this.hashColumns.put("lst_sb_rsn", getLstSbRsn());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("cfm_rqst_usr_id", getCfmRqstUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("lst_sb_rsn_tp_cd", "lstSbRsnTpCd");
		this.hashFields.put("lst_sb_dt", "lstSbDt");
		this.hashFields.put("cnddt_cfm_dt", "cnddtCfmDt");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cfm_rqst_flg", "cfmRqstFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cfm_rqst_dt", "cfmRqstDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnddt_cfm_flg", "cnddtCfmFlg");
		this.hashFields.put("lst_sb_rsn", "lstSbRsn");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("cfm_rqst_usr_id", "cfmRqstUsrId");
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
	 * @return lstSbRsnTpCd
	 */
	public String getLstSbRsnTpCd() {
		return this.lstSbRsnTpCd;
	}
	
	/**
	 * Column Info
	 * @return lstSbDt
	 */
	public String getLstSbDt() {
		return this.lstSbDt;
	}
	
	/**
	 * Column Info
	 * @return cnddtCfmDt
	 */
	public String getCnddtCfmDt() {
		return this.cnddtCfmDt;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
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
	 * @return cfmRqstFlg
	 */
	public String getCfmRqstFlg() {
		return this.cfmRqstFlg;
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
	 * @return cfmRqstDt
	 */
	public String getCfmRqstDt() {
		return this.cfmRqstDt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cnddtCfmFlg
	 */
	public String getCnddtCfmFlg() {
		return this.cnddtCfmFlg;
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
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return cfmRqstUsrId
	 */
	public String getCfmRqstUsrId() {
		return this.cfmRqstUsrId;
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
	 * @param lstSbRsnTpCd
	 */
	public void setLstSbRsnTpCd(String lstSbRsnTpCd) {
		this.lstSbRsnTpCd = lstSbRsnTpCd;
	}
	
	/**
	 * Column Info
	 * @param lstSbDt
	 */
	public void setLstSbDt(String lstSbDt) {
		this.lstSbDt = lstSbDt;
	}
	
	/**
	 * Column Info
	 * @param cnddtCfmDt
	 */
	public void setCnddtCfmDt(String cnddtCfmDt) {
		this.cnddtCfmDt = cnddtCfmDt;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
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
	 * @param cfmRqstFlg
	 */
	public void setCfmRqstFlg(String cfmRqstFlg) {
		this.cfmRqstFlg = cfmRqstFlg;
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
	 * @param cfmRqstDt
	 */
	public void setCfmRqstDt(String cfmRqstDt) {
		this.cfmRqstDt = cfmRqstDt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cnddtCfmFlg
	 */
	public void setCnddtCfmFlg(String cnddtCfmFlg) {
		this.cnddtCfmFlg = cnddtCfmFlg;
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
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param cfmRqstUsrId
	 */
	public void setCfmRqstUsrId(String cfmRqstUsrId) {
		this.cfmRqstUsrId = cfmRqstUsrId;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLstSbRsnTpCd(JSPUtil.getParameter(request, prefix + "lst_sb_rsn_tp_cd", ""));
		setLstSbDt(JSPUtil.getParameter(request, prefix + "lst_sb_dt", ""));
		setCnddtCfmDt(JSPUtil.getParameter(request, prefix + "cnddt_cfm_dt", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCfmRqstFlg(JSPUtil.getParameter(request, prefix + "cfm_rqst_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCfmRqstDt(JSPUtil.getParameter(request, prefix + "cfm_rqst_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCnddtCfmFlg(JSPUtil.getParameter(request, prefix + "cnddt_cfm_flg", ""));
		setLstSbRsn(JSPUtil.getParameter(request, prefix + "lst_sb_rsn", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setCfmRqstUsrId(JSPUtil.getParameter(request, prefix + "cfm_rqst_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcSbBkgVO[]
	 */
	public SpcSbBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcSbBkgVO[]
	 */
	public SpcSbBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcSbBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lstSbRsnTpCd = (JSPUtil.getParameter(request, prefix	+ "lst_sb_rsn_tp_cd", length));
			String[] lstSbDt = (JSPUtil.getParameter(request, prefix	+ "lst_sb_dt", length));
			String[] cnddtCfmDt = (JSPUtil.getParameter(request, prefix	+ "cnddt_cfm_dt", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cfmRqstFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_rqst_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cfmRqstDt = (JSPUtil.getParameter(request, prefix	+ "cfm_rqst_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cnddtCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cnddt_cfm_flg", length));
			String[] lstSbRsn = (JSPUtil.getParameter(request, prefix	+ "lst_sb_rsn", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] cfmRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_rqst_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcSbBkgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lstSbRsnTpCd[i] != null)
					model.setLstSbRsnTpCd(lstSbRsnTpCd[i]);
				if (lstSbDt[i] != null)
					model.setLstSbDt(lstSbDt[i]);
				if (cnddtCfmDt[i] != null)
					model.setCnddtCfmDt(cnddtCfmDt[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cfmRqstFlg[i] != null)
					model.setCfmRqstFlg(cfmRqstFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cfmRqstDt[i] != null)
					model.setCfmRqstDt(cfmRqstDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cnddtCfmFlg[i] != null)
					model.setCnddtCfmFlg(cnddtCfmFlg[i]);
				if (lstSbRsn[i] != null)
					model.setLstSbRsn(lstSbRsn[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (cfmRqstUsrId[i] != null)
					model.setCfmRqstUsrId(cfmRqstUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcSbBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcSbBkgVO[]
	 */
	public SpcSbBkgVO[] getSpcSbBkgVOs(){
		SpcSbBkgVO[] vos = (SpcSbBkgVO[])models.toArray(new SpcSbBkgVO[models.size()]);
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
		this.lstSbDt = this.lstSbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnddtCfmDt = this.cnddtCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRqstFlg = this.cfmRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRqstDt = this.cfmRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnddtCfmFlg = this.cnddtCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSbRsn = this.lstSbRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRqstUsrId = this.cfmRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
