/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModifyMdmCustRepVO.java
*@FileTitle : ModifyMdmCustRepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 이유목
*@LastVersion : 1.0
* 2015.05.15 이유목
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.common.mdmSync.jms.vo;

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
 * @author 김준호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ModifyMdmCustRepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModifyMdmCustRepVO> models = new ArrayList<ModifyMdmCustRepVO>();
	
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String autoInvFlg = null;
	/* Column Info */
	private String hjsCustSvcPicTpCd = null;
	/* Column Info */
	private String hjsRefNo = null;
	/* Column Info */
	private String custRefNoFlg = null;
	/* Column Info */
	private String loclChgFlg = null;
	/* Column Info */
	private String hjsRefEml = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String autoInvEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModifyMdmCustRepVO() {}

	public ModifyMdmCustRepVO(String custCntCd, String custSeq, String ofcCd, String ioBndCd, String autoInvFlg, String hjsCustSvcPicTpCd, String hjsRefNo, String custRefNoFlg, String loclChgFlg, String hjsRefEml, String deltFlg, String eaiEvntDt, String eaiIfId, String creUsrId, String creDt, String updUsrId, String updDt, String autoInvEml, String ibflag, String pagerows ) {
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.ofcCd = ofcCd;
		this.ioBndCd = ioBndCd;
		this.autoInvFlg = autoInvFlg;
		this.hjsCustSvcPicTpCd = hjsCustSvcPicTpCd;
		this.hjsRefNo = hjsRefNo;
		this.custRefNoFlg = custRefNoFlg;
		this.loclChgFlg = loclChgFlg;
		this.hjsRefEml = hjsRefEml;
		this.deltFlg = deltFlg;
		this.eaiEvntDt = eaiEvntDt;
		this.eaiIfId = eaiIfId;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.autoInvEml = autoInvEml;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("auto_inv_flg", getAutoInvFlg());
		this.hashColumns.put("hjs_cust_svc_pic_tp_cd", getHjsCustSvcPicTpCd());
		this.hashColumns.put("hjs_ref_no", getHjsRefNo());
		this.hashColumns.put("cust_ref_no_flg", getCustRefNoFlg());
		this.hashColumns.put("locl_chg_flg", getLoclChgFlg());
		this.hashColumns.put("hjs_ref_eml", getHjsRefEml());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("auto_inv_eml", getAutoInvEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("auto_inv_flg", "autoInvFlg");
		this.hashFields.put("hjs_cust_svc_pic_tp_cd", "hjsCustSvcPicTpCd");
		this.hashFields.put("hjs_ref_no", "hjsRefNo");
		this.hashFields.put("cust_ref_no_flg", "custRefNoFlg");
		this.hashFields.put("locl_chg_flg", "loclChgFlg");
		this.hashFields.put("hjs_ref_eml", "hjsRefEml");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("auto_inv_eml", "autoInvEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return autoInvFlg
	 */
	public String getAutoInvFlg() {
		return this.autoInvFlg;
	}
	
	/**
	 * Column Info
	 * @return hjsCustSvcPicTpCd
	 */
	public String getHjsCustSvcPicTpCd() {
		return this.hjsCustSvcPicTpCd;
	}
	
	/**
	 * Column Info
	 * @return hjsRefNo
	 */
	public String getHjsRefNo() {
		return this.hjsRefNo;
	}
	
	/**
	 * Column Info
	 * @return custRefNoFlg
	 */
	public String getCustRefNoFlg() {
		return this.custRefNoFlg;
	}
	
	/**
	 * Column Info
	 * @return loclChgFlg
	 */
	public String getLoclChgFlg() {
		return this.loclChgFlg;
	}
	
	/**
	 * Column Info
	 * @return hjsRefEml
	 */
	public String getHjsRefEml() {
		return this.hjsRefEml;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return autoInvEml
	 */
	public String getAutoInvEml() {
		return this.autoInvEml;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param autoInvFlg
	 */
	public void setAutoInvFlg(String autoInvFlg) {
		this.autoInvFlg = autoInvFlg;
	}
	
	/**
	 * Column Info
	 * @param hjsCustSvcPicTpCd
	 */
	public void setHjsCustSvcPicTpCd(String hjsCustSvcPicTpCd) {
		this.hjsCustSvcPicTpCd = hjsCustSvcPicTpCd;
	}
	
	/**
	 * Column Info
	 * @param hjsRefNo
	 */
	public void setHjsRefNo(String hjsRefNo) {
		this.hjsRefNo = hjsRefNo;
	}
	
	/**
	 * Column Info
	 * @param custRefNoFlg
	 */
	public void setCustRefNoFlg(String custRefNoFlg) {
		this.custRefNoFlg = custRefNoFlg;
	}
	
	/**
	 * Column Info
	 * @param loclChgFlg
	 */
	public void setLoclChgFlg(String loclChgFlg) {
		this.loclChgFlg = loclChgFlg;
	}
	
	/**
	 * Column Info
	 * @param hjsRefEml
	 */
	public void setHjsRefEml(String hjsRefEml) {
		this.hjsRefEml = hjsRefEml;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param autoInvEml
	 */
	public void setAutoInvEml(String autoInvEml) {
		this.autoInvEml = autoInvEml;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setAutoInvFlg(JSPUtil.getParameter(request, prefix + "auto_inv_flg", ""));
		setHjsCustSvcPicTpCd(JSPUtil.getParameter(request, prefix + "hjs_cust_svc_pic_tp_cd", ""));
		setHjsRefNo(JSPUtil.getParameter(request, prefix + "hjs_ref_no", ""));
		setCustRefNoFlg(JSPUtil.getParameter(request, prefix + "cust_ref_no_flg", ""));
		setLoclChgFlg(JSPUtil.getParameter(request, prefix + "locl_chg_flg", ""));
		setHjsRefEml(JSPUtil.getParameter(request, prefix + "hjs_ref_eml", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAutoInvEml(JSPUtil.getParameter(request, prefix + "auto_inv_eml", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ModifyMdmCustRepVO[]
	 */
	public ModifyMdmCustRepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ModifyMdmCustRepVO[]
	 */
	public ModifyMdmCustRepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModifyMdmCustRepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] autoInvFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_flg", length));
			String[] hjsCustSvcPicTpCd = (JSPUtil.getParameter(request, prefix	+ "hjs_cust_svc_pic_tp_cd", length));
			String[] hjsRefNo = (JSPUtil.getParameter(request, prefix	+ "hjs_ref_no", length));
			String[] custRefNoFlg = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no_flg", length));
			String[] loclChgFlg = (JSPUtil.getParameter(request, prefix	+ "locl_chg_flg", length));
			String[] hjsRefEml = (JSPUtil.getParameter(request, prefix	+ "hjs_ref_eml", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] autoInvEml = (JSPUtil.getParameter(request, prefix	+ "auto_inv_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ModifyMdmCustRepVO();
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (autoInvFlg[i] != null)
					model.setAutoInvFlg(autoInvFlg[i]);
				if (hjsCustSvcPicTpCd[i] != null)
					model.setHjsCustSvcPicTpCd(hjsCustSvcPicTpCd[i]);
				if (hjsRefNo[i] != null)
					model.setHjsRefNo(hjsRefNo[i]);
				if (custRefNoFlg[i] != null)
					model.setCustRefNoFlg(custRefNoFlg[i]);
				if (loclChgFlg[i] != null)
					model.setLoclChgFlg(loclChgFlg[i]);
				if (hjsRefEml[i] != null)
					model.setHjsRefEml(hjsRefEml[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (autoInvEml[i] != null)
					model.setAutoInvEml(autoInvEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getModifyMdmCustRepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ModifyMdmCustRepVO[]
	 */
	public ModifyMdmCustRepVO[] getModifyMdmCustRepVOs(){
		ModifyMdmCustRepVO[] vos = (ModifyMdmCustRepVO[])models.toArray(new ModifyMdmCustRepVO[models.size()]);
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
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvFlg = this.autoInvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsCustSvcPicTpCd = this.hjsCustSvcPicTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsRefNo = this.hjsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNoFlg = this.custRefNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclChgFlg = this.loclChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsRefEml = this.hjsRefEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvEml = this.autoInvEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
