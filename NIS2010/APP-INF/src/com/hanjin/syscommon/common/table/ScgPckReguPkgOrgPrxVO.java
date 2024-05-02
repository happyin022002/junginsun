/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckReguPkgOrgPrxVO.java
*@FileTitle : ScgPckReguPkgOrgPrxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규 
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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgPckReguPkgOrgPrxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckReguPkgOrgPrxVO> models = new ArrayList<ScgPckReguPkgOrgPrxVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String reguDpNo = null;
	/* Column Info */
	private String orgPrxDesc = null;
	/* Column Info */
	private String maxCapaQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgPckCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String imdgEmerTemp = null;
	/* Column Info */
	private String subSeq = null;
	/* Column Info */
	private String imdgCtrlTemp = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckReguPkgOrgPrxVO() {}

	public ScgPckReguPkgOrgPrxVO(String ibflag, String pagerows, String reguDpNo, String imdgPckInstrCd, String imdgPckInstrSeq, String subSeq, String creDt, String creUsrId, String deltFlg, String imdgCtrlTemp, String imdgEmerTemp, String imdgPckCd, String imdgUnNo, String maxCapaQty, String orgPrxDesc, String updDt, String updUsrId) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.creDt = creDt;
		this.reguDpNo = reguDpNo;
		this.orgPrxDesc = orgPrxDesc;
		this.maxCapaQty = maxCapaQty;
		this.pagerows = pagerows;
		this.imdgPckCd = imdgPckCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.imdgEmerTemp = imdgEmerTemp;
		this.subSeq = subSeq;
		this.imdgCtrlTemp = imdgCtrlTemp;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("regu_dp_no", getReguDpNo());
		this.hashColumns.put("org_prx_desc", getOrgPrxDesc());
		this.hashColumns.put("max_capa_qty", getMaxCapaQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_pck_cd", getImdgPckCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("imdg_emer_temp", getImdgEmerTemp());
		this.hashColumns.put("sub_seq", getSubSeq());
		this.hashColumns.put("imdg_ctrl_temp", getImdgCtrlTemp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("regu_dp_no", "reguDpNo");
		this.hashFields.put("org_prx_desc", "orgPrxDesc");
		this.hashFields.put("max_capa_qty", "maxCapaQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_pck_cd", "imdgPckCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("imdg_emer_temp", "imdgEmerTemp");
		this.hashFields.put("sub_seq", "subSeq");
		this.hashFields.put("imdg_ctrl_temp", "imdgCtrlTemp");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgPckInstrSeq
	 */
	public String getImdgPckInstrSeq() {
		return this.imdgPckInstrSeq;
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
	 * @return reguDpNo
	 */
	public String getReguDpNo() {
		return this.reguDpNo;
	}
	
	/**
	 * Column Info
	 * @return orgPrxDesc
	 */
	public String getOrgPrxDesc() {
		return this.orgPrxDesc;
	}
	
	/**
	 * Column Info
	 * @return maxCapaQty
	 */
	public String getMaxCapaQty() {
		return this.maxCapaQty;
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
	 * @return imdgPckCd
	 */
	public String getImdgPckCd() {
		return this.imdgPckCd;
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
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return imdgEmerTemp
	 */
	public String getImdgEmerTemp() {
		return this.imdgEmerTemp;
	}
	
	/**
	 * Column Info
	 * @return subSeq
	 */
	public String getSubSeq() {
		return this.subSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgCtrlTemp
	 */
	public String getImdgCtrlTemp() {
		return this.imdgCtrlTemp;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgPckInstrSeq
	 */
	public void setImdgPckInstrSeq(String imdgPckInstrSeq) {
		this.imdgPckInstrSeq = imdgPckInstrSeq;
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
	 * @param reguDpNo
	 */
	public void setReguDpNo(String reguDpNo) {
		this.reguDpNo = reguDpNo;
	}
	
	/**
	 * Column Info
	 * @param orgPrxDesc
	 */
	public void setOrgPrxDesc(String orgPrxDesc) {
		this.orgPrxDesc = orgPrxDesc;
	}
	
	/**
	 * Column Info
	 * @param maxCapaQty
	 */
	public void setMaxCapaQty(String maxCapaQty) {
		this.maxCapaQty = maxCapaQty;
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
	 * @param imdgPckCd
	 */
	public void setImdgPckCd(String imdgPckCd) {
		this.imdgPckCd = imdgPckCd;
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
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param imdgEmerTemp
	 */
	public void setImdgEmerTemp(String imdgEmerTemp) {
		this.imdgEmerTemp = imdgEmerTemp;
	}
	
	/**
	 * Column Info
	 * @param subSeq
	 */
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgCtrlTemp
	 */
	public void setImdgCtrlTemp(String imdgCtrlTemp) {
		this.imdgCtrlTemp = imdgCtrlTemp;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setReguDpNo(JSPUtil.getParameter(request, prefix + "regu_dp_no", ""));
		setOrgPrxDesc(JSPUtil.getParameter(request, prefix + "org_prx_desc", ""));
		setMaxCapaQty(JSPUtil.getParameter(request, prefix + "max_capa_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setImdgPckCd(JSPUtil.getParameter(request, prefix + "imdg_pck_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setImdgEmerTemp(JSPUtil.getParameter(request, prefix + "imdg_emer_temp", ""));
		setSubSeq(JSPUtil.getParameter(request, prefix + "sub_seq", ""));
		setImdgCtrlTemp(JSPUtil.getParameter(request, prefix + "imdg_ctrl_temp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckReguPkgOrgPrxVO[]
	 */
	public ScgPckReguPkgOrgPrxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckReguPkgOrgPrxVO[]
	 */
	public ScgPckReguPkgOrgPrxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckReguPkgOrgPrxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] reguDpNo = (JSPUtil.getParameter(request, prefix	+ "regu_dp_no", length));
			String[] orgPrxDesc = (JSPUtil.getParameter(request, prefix	+ "org_prx_desc", length));
			String[] maxCapaQty = (JSPUtil.getParameter(request, prefix	+ "max_capa_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgPckCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] imdgEmerTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_emer_temp", length));
			String[] subSeq = (JSPUtil.getParameter(request, prefix	+ "sub_seq", length));
			String[] imdgCtrlTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_ctrl_temp", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckReguPkgOrgPrxVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (reguDpNo[i] != null)
					model.setReguDpNo(reguDpNo[i]);
				if (orgPrxDesc[i] != null)
					model.setOrgPrxDesc(orgPrxDesc[i]);
				if (maxCapaQty[i] != null)
					model.setMaxCapaQty(maxCapaQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgPckCd[i] != null)
					model.setImdgPckCd(imdgPckCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (imdgEmerTemp[i] != null)
					model.setImdgEmerTemp(imdgEmerTemp[i]);
				if (subSeq[i] != null)
					model.setSubSeq(subSeq[i]);
				if (imdgCtrlTemp[i] != null)
					model.setImdgCtrlTemp(imdgCtrlTemp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckReguPkgOrgPrxVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckReguPkgOrgPrxVO[]
	 */
	public ScgPckReguPkgOrgPrxVO[] getScgPckReguPkgOrgPrxVOs(){
		ScgPckReguPkgOrgPrxVO[] vos = (ScgPckReguPkgOrgPrxVO[])models.toArray(new ScgPckReguPkgOrgPrxVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguDpNo = this.reguDpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrxDesc = this.orgPrxDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCapaQty = this.maxCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckCd = this.imdgPckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgEmerTemp = this.imdgEmerTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSeq = this.subSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCtrlTemp = this.imdgCtrlTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
