/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustomerGroupIfVO.java
*@FileTitle : CustomerGroupIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo;

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
public class CustomerGroupIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerGroupIfVO> models = new ArrayList<CustomerGroupIfVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String custGrpCd = null;

	/* Column Info */
	private String custGrpNm = null;

	/* Column Info */
	private String ofcCd = null;

	/* Column Info */
	private String mstOfcId = null;

	/* Column Info */
	private String srepCd = null;

	/* Column Info */
	private String valBseSegmClssCd = null;

	/* Column Info */
	private String ndsBseSegmClssCd1 = null;

	/* Column Info */
	private String ndsBseSegmClssCd2 = null;

	/* Column Info */
	private String ndsBseSegmClssCd3 = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/* Column Info */
	private String deltFlg = null;

	/* Column Info */
	private String newKeyAcctFlg = null;

	/* Column Info */
	private String rgnAcctFlg = null;

	/* Column Info */
	private String rhqCd = null;

	/* Column Info */
	private String ofcTeamCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomerGroupIfVO() {}

	public CustomerGroupIfVO(String ibflag, String pagerows, String custGrpCd, String custGrpNm, String ofcCd, String mstOfcId, String srepCd, String valBseSegmClssCd, String ndsBseSegmClssCd1, String ndsBseSegmClssCd2, String ndsBseSegmClssCd3, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String newKeyAcctFlg, String rgnAcctFlg, String rhqCd, String ofcTeamCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.custGrpCd = custGrpCd;
		this.custGrpNm = custGrpNm;
		this.ofcCd = ofcCd;
		this.mstOfcId = mstOfcId;
		this.srepCd = srepCd;
		this.valBseSegmClssCd = valBseSegmClssCd;
		this.ndsBseSegmClssCd1 = ndsBseSegmClssCd1;
		this.ndsBseSegmClssCd2 = ndsBseSegmClssCd2;
		this.ndsBseSegmClssCd3 = ndsBseSegmClssCd3;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.newKeyAcctFlg = newKeyAcctFlg;
		this.rgnAcctFlg = rgnAcctFlg;
		this.rhqCd = rhqCd;
		this.ofcTeamCd = ofcTeamCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_grp_cd", getCustGrpCd());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mst_ofc_id", getMstOfcId());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("val_bse_segm_clss_cd", getValBseSegmClssCd());
		this.hashColumns.put("nds_bse_segm_clss_cd1", getNdsBseSegmClssCd1());
		this.hashColumns.put("nds_bse_segm_clss_cd2", getNdsBseSegmClssCd2());
		this.hashColumns.put("nds_bse_segm_clss_cd3", getNdsBseSegmClssCd3());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("new_key_acct_flg", getNewKeyAcctFlg());
		this.hashColumns.put("rgn_acct_flg", getRgnAcctFlg());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ofc_team_cd", getOfcTeamCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_grp_cd", "custGrpCd");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mst_ofc_id", "mstOfcId");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("val_bse_segm_clss_cd", "valBseSegmClssCd");
		this.hashFields.put("nds_bse_segm_clss_cd1", "ndsBseSegmClssCd1");
		this.hashFields.put("nds_bse_segm_clss_cd2", "ndsBseSegmClssCd2");
		this.hashFields.put("nds_bse_segm_clss_cd3", "ndsBseSegmClssCd3");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("new_key_acct_flg", "newKeyAcctFlg");
		this.hashFields.put("rgn_acct_flg", "rgnAcctFlg");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ofc_team_cd", "ofcTeamCd");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String custGrpCd
	 */
	public void setCustGrpCd(String custGrpCd) {
		this.custGrpCd = custGrpCd;
	}
	
	/**
	 * 
	 * @return String custGrpCd
	 */
	public String getCustGrpCd() {
		return this.custGrpCd;
	}
	
	/**
	 *
	 * @param String custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * 
	 * @return String custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 *
	 * @param String ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 
	 * @return String ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 *
	 * @param String mstOfcId
	 */
	public void setMstOfcId(String mstOfcId) {
		this.mstOfcId = mstOfcId;
	}
	
	/**
	 * 
	 * @return String mstOfcId
	 */
	public String getMstOfcId() {
		return this.mstOfcId;
	}
	
	/**
	 *
	 * @param String srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * 
	 * @return String srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 *
	 * @param String valBseSegmClssCd
	 */
	public void setValBseSegmClssCd(String valBseSegmClssCd) {
		this.valBseSegmClssCd = valBseSegmClssCd;
	}
	
	/**
	 * 
	 * @return String valBseSegmClssCd
	 */
	public String getValBseSegmClssCd() {
		return this.valBseSegmClssCd;
	}
	
	/**
	 *
	 * @param String ndsBseSegmClssCd1
	 */
	public void setNdsBseSegmClssCd1(String ndsBseSegmClssCd1) {
		this.ndsBseSegmClssCd1 = ndsBseSegmClssCd1;
	}
	
	/**
	 * 
	 * @return String ndsBseSegmClssCd1
	 */
	public String getNdsBseSegmClssCd1() {
		return this.ndsBseSegmClssCd1;
	}
	
	/**
	 *
	 * @param String ndsBseSegmClssCd2
	 */
	public void setNdsBseSegmClssCd2(String ndsBseSegmClssCd2) {
		this.ndsBseSegmClssCd2 = ndsBseSegmClssCd2;
	}
	
	/**
	 * 
	 * @return String ndsBseSegmClssCd2
	 */
	public String getNdsBseSegmClssCd2() {
		return this.ndsBseSegmClssCd2;
	}
	
	/**
	 *
	 * @param String ndsBseSegmClssCd3
	 */
	public void setNdsBseSegmClssCd3(String ndsBseSegmClssCd3) {
		this.ndsBseSegmClssCd3 = ndsBseSegmClssCd3;
	}
	
	/**
	 * 
	 * @return String ndsBseSegmClssCd3
	 */
	public String getNdsBseSegmClssCd3() {
		return this.ndsBseSegmClssCd3;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 *
	 * @param String deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 
	 * @return String deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 *
	 * @param String newKeyAcctFlg
	 */
	public void setNewKeyAcctFlg(String newKeyAcctFlg) {
		this.newKeyAcctFlg = newKeyAcctFlg;
	}
	
	/**
	 * 
	 * @return String newKeyAcctFlg
	 */
	public String getNewKeyAcctFlg() {
		return this.newKeyAcctFlg;
	}
	
	/**
	 *
	 * @param String rgnAcctFlg
	 */
	public void setRgnAcctFlg(String rgnAcctFlg) {
		this.rgnAcctFlg = rgnAcctFlg;
	}
	
	/**
	 * 
	 * @return String rgnAcctFlg
	 */
	public String getRgnAcctFlg() {
		return this.rgnAcctFlg;
	}
	
	/**
	 *
	 * @param String rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * 
	 * @return String rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 *
	 * @param String ofcTeamCd
	 */
	public void setOfcTeamCd(String ofcTeamCd) {
		this.ofcTeamCd = ofcTeamCd;
	}
	
	/**
	 * 
	 * @return String ofcTeamCd
	 */
	public String getOfcTeamCd() {
		return this.ofcTeamCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustGrpCd(JSPUtil.getParameter(request, prefix + "cust_grp_cd", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setMstOfcId(JSPUtil.getParameter(request, prefix + "mst_ofc_id", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setValBseSegmClssCd(JSPUtil.getParameter(request, prefix + "val_bse_segm_clss_cd", ""));
		setNdsBseSegmClssCd1(JSPUtil.getParameter(request, prefix + "nds_bse_segm_clss_cd1", ""));
		setNdsBseSegmClssCd2(JSPUtil.getParameter(request, prefix + "nds_bse_segm_clss_cd2", ""));
		setNdsBseSegmClssCd3(JSPUtil.getParameter(request, prefix + "nds_bse_segm_clss_cd3", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setNewKeyAcctFlg(JSPUtil.getParameter(request, prefix + "new_key_acct_flg", ""));
		setRgnAcctFlg(JSPUtil.getParameter(request, prefix + "rgn_acct_flg", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOfcTeamCd(JSPUtil.getParameter(request, prefix + "ofc_team_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerGroupIfVO[]
	 */
	public CustomerGroupIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerGroupIfVO[]
	 */
	public CustomerGroupIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerGroupIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custGrpCd = (JSPUtil.getParameter(request, prefix	+ "cust_grp_cd", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mstOfcId = (JSPUtil.getParameter(request, prefix	+ "mst_ofc_id", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] valBseSegmClssCd = (JSPUtil.getParameter(request, prefix	+ "val_bse_segm_clss_cd", length));
			String[] ndsBseSegmClssCd1 = (JSPUtil.getParameter(request, prefix	+ "nds_bse_segm_clss_cd1", length));
			String[] ndsBseSegmClssCd2 = (JSPUtil.getParameter(request, prefix	+ "nds_bse_segm_clss_cd2", length));
			String[] ndsBseSegmClssCd3 = (JSPUtil.getParameter(request, prefix	+ "nds_bse_segm_clss_cd3", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] newKeyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "new_key_acct_flg", length));
			String[] rgnAcctFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_acct_flg", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ofcTeamCd = (JSPUtil.getParameter(request, prefix	+ "ofc_team_cd", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new CustomerGroupIfVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (custGrpCd[i] != null) 
					model.setCustGrpCd(custGrpCd[i]);
				if (custGrpNm[i] != null) 
					model.setCustGrpNm(custGrpNm[i]);
				if (ofcCd[i] != null) 
					model.setOfcCd(ofcCd[i]);
				if (mstOfcId[i] != null) 
					model.setMstOfcId(mstOfcId[i]);
				if (srepCd[i] != null) 
					model.setSrepCd(srepCd[i]);
				if (valBseSegmClssCd[i] != null) 
					model.setValBseSegmClssCd(valBseSegmClssCd[i]);
				if (ndsBseSegmClssCd1[i] != null) 
					model.setNdsBseSegmClssCd1(ndsBseSegmClssCd1[i]);
				if (ndsBseSegmClssCd2[i] != null) 
					model.setNdsBseSegmClssCd2(ndsBseSegmClssCd2[i]);
				if (ndsBseSegmClssCd3[i] != null) 
					model.setNdsBseSegmClssCd3(ndsBseSegmClssCd3[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null) 
					model.setDeltFlg(deltFlg[i]);
				if (newKeyAcctFlg[i] != null) 
					model.setNewKeyAcctFlg(newKeyAcctFlg[i]);
				if (rgnAcctFlg[i] != null) 
					model.setRgnAcctFlg(rgnAcctFlg[i]);
				if (rhqCd[i] != null) 
					model.setRhqCd(rhqCd[i]);
				if (ofcTeamCd[i] != null) 
					model.setOfcTeamCd(ofcTeamCd[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerGroupIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerGroupIfVO[]
	 */
	public CustomerGroupIfVO[] getCustomerGroupIfVOs(){
		CustomerGroupIfVO[] vos = (CustomerGroupIfVO[])models.toArray(new CustomerGroupIfVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpCd = this.custGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstOfcId = this.mstOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valBseSegmClssCd = this.valBseSegmClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndsBseSegmClssCd1 = this.ndsBseSegmClssCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndsBseSegmClssCd2 = this.ndsBseSegmClssCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndsBseSegmClssCd3 = this.ndsBseSegmClssCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newKeyAcctFlg = this.newKeyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnAcctFlg = this.rgnAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTeamCd = this.ofcTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}