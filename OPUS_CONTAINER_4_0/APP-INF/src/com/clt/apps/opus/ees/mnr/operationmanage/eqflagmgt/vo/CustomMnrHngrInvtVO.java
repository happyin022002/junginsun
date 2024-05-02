/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrHngrInvtVO.java
*@FileTitle : CustomMnrHngrInvtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.28 함형석
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrHngrInvtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CustomMnrHngrInvtVO> models = new ArrayList<CustomMnrHngrInvtVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invtRmk = null;
	/* Column Info */
	private String hngrInvtLstVerFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rcvrQty = null;
	/* Column Info */
	private String actInvtQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String purQty = null;
	/* Column Info */
	private String csmQty = null;
	/* Column Info */
	private String invtQty = null;
	/* Column Info */
	private String hngrInvtVerNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public CustomMnrHngrInvtVO() {}

	public CustomMnrHngrInvtVO(String ibflag, String pagerows, String ofcCd, String hngrInvtVerNo, String hngrInvtLstVerFlg, String invtQty, String purQty, String csmQty, String rcvrQty, String actInvtQty, String invtRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.invtRmk = invtRmk;
		this.hngrInvtLstVerFlg = hngrInvtLstVerFlg;
		this.creDt = creDt;
		this.rcvrQty = rcvrQty;
		this.actInvtQty = actInvtQty;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.purQty = purQty;
		this.csmQty = csmQty;
		this.invtQty = invtQty;
		this.hngrInvtVerNo = hngrInvtVerNo;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("invt_rmk", getInvtRmk());
		this.hashColumns.put("hngr_invt_lst_ver_flg", getHngrInvtLstVerFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rcvr_qty", getRcvrQty());
		this.hashColumns.put("act_invt_qty", getActInvtQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pur_qty", getPurQty());
		this.hashColumns.put("csm_qty", getCsmQty());
		this.hashColumns.put("invt_qty", getInvtQty());
		this.hashColumns.put("hngr_invt_ver_no", getHngrInvtVerNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("invt_rmk", "invtRmk");
		this.hashFields.put("hngr_invt_lst_ver_flg", "hngrInvtLstVerFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rcvr_qty", "rcvrQty");
		this.hashFields.put("act_invt_qty", "actInvtQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pur_qty", "purQty");
		this.hashFields.put("csm_qty", "csmQty");
		this.hashFields.put("invt_qty", "invtQty");
		this.hashFields.put("hngr_invt_ver_no", "hngrInvtVerNo");
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
	 * @return invtRmk
	 */
	public String getInvtRmk() {
		return this.invtRmk;
	}

	/**
	 * Column Info
	 * @return hngrInvtLstVerFlg
	 */
	public String getHngrInvtLstVerFlg() {
		return this.hngrInvtLstVerFlg;
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
	 * @return rcvrQty
	 */
	public String getRcvrQty() {
		return this.rcvrQty;
	}

	/**
	 * Column Info
	 * @return actInvtQty
	 */
	public String getActInvtQty() {
		return this.actInvtQty;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return purQty
	 */
	public String getPurQty() {
		return this.purQty;
	}

	/**
	 * Column Info
	 * @return csmQty
	 */
	public String getCsmQty() {
		return this.csmQty;
	}

	/**
	 * Column Info
	 * @return invtQty
	 */
	public String getInvtQty() {
		return this.invtQty;
	}

	/**
	 * Column Info
	 * @return hngrInvtVerNo
	 */
	public String getHngrInvtVerNo() {
		return this.hngrInvtVerNo;
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
	 * @param invtRmk
	 */
	public void setInvtRmk(String invtRmk) {
		this.invtRmk = invtRmk;
	}

	/**
	 * Column Info
	 * @param hngrInvtLstVerFlg
	 */
	public void setHngrInvtLstVerFlg(String hngrInvtLstVerFlg) {
		this.hngrInvtLstVerFlg = hngrInvtLstVerFlg;
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
	 * @param rcvrQty
	 */
	public void setRcvrQty(String rcvrQty) {
		this.rcvrQty = rcvrQty;
	}

	/**
	 * Column Info
	 * @param actInvtQty
	 */
	public void setActInvtQty(String actInvtQty) {
		this.actInvtQty = actInvtQty;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param purQty
	 */
	public void setPurQty(String purQty) {
		this.purQty = purQty;
	}

	/**
	 * Column Info
	 * @param csmQty
	 */
	public void setCsmQty(String csmQty) {
		this.csmQty = csmQty;
	}

	/**
	 * Column Info
	 * @param invtQty
	 */
	public void setInvtQty(String invtQty) {
		this.invtQty = invtQty;
	}

	/**
	 * Column Info
	 * @param hngrInvtVerNo
	 */
	public void setHngrInvtVerNo(String hngrInvtVerNo) {
		this.hngrInvtVerNo = hngrInvtVerNo;
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
		setInvtRmk(JSPUtil.getParameter(request, "invt_rmk", ""));
		setHngrInvtLstVerFlg(JSPUtil.getParameter(request, "hngr_invt_lst_ver_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRcvrQty(JSPUtil.getParameter(request, "rcvr_qty", ""));
		setActInvtQty(JSPUtil.getParameter(request, "act_invt_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPurQty(JSPUtil.getParameter(request, "pur_qty", ""));
		setCsmQty(JSPUtil.getParameter(request, "csm_qty", ""));
		setInvtQty(JSPUtil.getParameter(request, "invt_qty", ""));
		setHngrInvtVerNo(JSPUtil.getParameter(request, "hngr_invt_ver_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrHngrInvtVO[]
	 */
	public CustomMnrHngrInvtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomMnrHngrInvtVO[]
	 */
	public CustomMnrHngrInvtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrHngrInvtVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invtRmk = (JSPUtil.getParameter(request, prefix	+ "invt_rmk", length));
			String[] hngrInvtLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_invt_lst_ver_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rcvrQty = (JSPUtil.getParameter(request, prefix	+ "rcvr_qty", length));
			String[] actInvtQty = (JSPUtil.getParameter(request, prefix	+ "act_invt_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] purQty = (JSPUtil.getParameter(request, prefix	+ "pur_qty", length));
			String[] csmQty = (JSPUtil.getParameter(request, prefix	+ "csm_qty", length));
			String[] invtQty = (JSPUtil.getParameter(request, prefix	+ "invt_qty", length));
			String[] hngrInvtVerNo = (JSPUtil.getParameter(request, prefix	+ "hngr_invt_ver_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new CustomMnrHngrInvtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invtRmk[i] != null)
					model.setInvtRmk(invtRmk[i]);
				if (hngrInvtLstVerFlg[i] != null)
					model.setHngrInvtLstVerFlg(hngrInvtLstVerFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rcvrQty[i] != null)
					model.setRcvrQty(rcvrQty[i]);
				if (actInvtQty[i] != null)
					model.setActInvtQty(actInvtQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (purQty[i] != null)
					model.setPurQty(purQty[i]);
				if (csmQty[i] != null)
					model.setCsmQty(csmQty[i]);
				if (invtQty[i] != null)
					model.setInvtQty(invtQty[i]);
				if (hngrInvtVerNo[i] != null)
					model.setHngrInvtVerNo(hngrInvtVerNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrHngrInvtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrHngrInvtVO[]
	 */
	public CustomMnrHngrInvtVO[] getCustomMnrHngrInvtVOs(){
		CustomMnrHngrInvtVO[] vos = (CustomMnrHngrInvtVO[])models.toArray(new CustomMnrHngrInvtVO[models.size()]);
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
		this.invtRmk = this.invtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrInvtLstVerFlg = this.hngrInvtLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrQty = this.rcvrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvtQty = this.actInvtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purQty = this.purQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmQty = this.csmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invtQty = this.invtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrInvtVerNo = this.hngrInvtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
