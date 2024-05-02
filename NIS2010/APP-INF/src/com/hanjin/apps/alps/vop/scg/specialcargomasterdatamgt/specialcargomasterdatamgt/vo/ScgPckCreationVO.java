/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckCreationVO.java
*@FileTitle : ScgPckCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

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

public class ScgPckCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckCreationVO> models = new ArrayList<ScgPckCreationVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String andOrCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String maxCtnt = null;
	/* Column Info */
	private String prmtChkCd = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String refDivNo = null;
	/* Column Info */
	private String imdgPckMzdCd = null;
	/* Column Info */
	private String reguDpNo = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String imdgPckCd = null;
	/* Column Info */
	private String pckRefCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String subSeq = null;
	/* Column Info */
	private String maxMass = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String refDesc = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckCreationVO() {}

	public ScgPckCreationVO(String ibflag, String pagerows, String updDt, String andOrCd, String reguDpNo, String imdgPckCd, String deltFlg, String imdgPckInstrSeq, String creDt, String pckTpCd, String creUsrId, String imdgPckInstrCd, String subSeq, String updUsrId, String prmtChkCd, String imdgPckMzdCd, String maxMass, String maxCtnt, String pckRefCd, String refDivNo, String refDesc) {
		this.updDt = updDt;
		this.andOrCd = andOrCd;
		this.deltFlg = deltFlg;
		this.maxCtnt = maxCtnt;
		this.prmtChkCd = prmtChkCd;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.creDt = creDt;
		this.refDivNo = refDivNo;
		this.imdgPckMzdCd = imdgPckMzdCd;
		this.reguDpNo = reguDpNo;
		this.pagerows = pagerows;
		this.imdgPckCd = imdgPckCd;
		this.pckRefCd = pckRefCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.subSeq = subSeq;
		this.maxMass = maxMass;
		this.pckTpCd = pckTpCd;
		this.refDesc = refDesc;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("and_or_cd", getAndOrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("max_ctnt", getMaxCtnt());
		this.hashColumns.put("prmt_chk_cd", getPrmtChkCd());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ref_div_no", getRefDivNo());
		this.hashColumns.put("imdg_pck_mzd_cd", getImdgPckMzdCd());
		this.hashColumns.put("regu_dp_no", getReguDpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_pck_cd", getImdgPckCd());
		this.hashColumns.put("pck_ref_cd", getPckRefCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("sub_seq", getSubSeq());
		this.hashColumns.put("max_mass", getMaxMass());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ref_desc", getRefDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("and_or_cd", "andOrCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("max_ctnt", "maxCtnt");
		this.hashFields.put("prmt_chk_cd", "prmtChkCd");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ref_div_no", "refDivNo");
		this.hashFields.put("imdg_pck_mzd_cd", "imdgPckMzdCd");
		this.hashFields.put("regu_dp_no", "reguDpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_pck_cd", "imdgPckCd");
		this.hashFields.put("pck_ref_cd", "pckRefCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("sub_seq", "subSeq");
		this.hashFields.put("max_mass", "maxMass");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ref_desc", "refDesc");
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
	 * @return andOrCd
	 */
	public String getAndOrCd() {
		return this.andOrCd;
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
	 * @return maxCtnt
	 */
	public String getMaxCtnt() {
		return this.maxCtnt;
	}
	
	/**
	 * Column Info
	 * @return prmtChkCd
	 */
	public String getPrmtChkCd() {
		return this.prmtChkCd;
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
	 * @return refDivNo
	 */
	public String getRefDivNo() {
		return this.refDivNo;
	}
	
	/**
	 * Column Info
	 * @return imdgPckMzdCd
	 */
	public String getImdgPckMzdCd() {
		return this.imdgPckMzdCd;
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
	 * Column Info
	 * @return pckRefCd
	 */
	public String getPckRefCd() {
		return this.pckRefCd;
	}
	
	/**
	 * Column Info
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
	 * @return subSeq
	 */
	public String getSubSeq() {
		return this.subSeq;
	}
	
	/**
	 * Column Info
	 * @return maxMass
	 */
	public String getMaxMass() {
		return this.maxMass;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return refDesc
	 */
	public String getRefDesc() {
		return this.refDesc;
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
	 * @param andOrCd
	 */
	public void setAndOrCd(String andOrCd) {
		this.andOrCd = andOrCd;
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
	 * @param maxCtnt
	 */
	public void setMaxCtnt(String maxCtnt) {
		this.maxCtnt = maxCtnt;
	}
	
	/**
	 * Column Info
	 * @param prmtChkCd
	 */
	public void setPrmtChkCd(String prmtChkCd) {
		this.prmtChkCd = prmtChkCd;
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
	 * @param refDivNo
	 */
	public void setRefDivNo(String refDivNo) {
		this.refDivNo = refDivNo;
	}
	
	/**
	 * Column Info
	 * @param imdgPckMzdCd
	 */
	public void setImdgPckMzdCd(String imdgPckMzdCd) {
		this.imdgPckMzdCd = imdgPckMzdCd;
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
	 * Column Info
	 * @param pckRefCd
	 */
	public void setPckRefCd(String pckRefCd) {
		this.pckRefCd = pckRefCd;
	}
	
	/**
	 * Column Info
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
	 * @param subSeq
	 */
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	
	/**
	 * Column Info
	 * @param maxMass
	 */
	public void setMaxMass(String maxMass) {
		this.maxMass = maxMass;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param refDesc
	 */
	public void setRefDesc(String refDesc) {
		this.refDesc = refDesc;
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
		setAndOrCd(JSPUtil.getParameter(request, prefix + "and_or_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setMaxCtnt(JSPUtil.getParameter(request, prefix + "max_ctnt", ""));
		setPrmtChkCd(JSPUtil.getParameter(request, prefix + "prmt_chk_cd", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRefDivNo(JSPUtil.getParameter(request, prefix + "ref_div_no", ""));
		setImdgPckMzdCd(JSPUtil.getParameter(request, prefix + "imdg_pck_mzd_cd", ""));
		setReguDpNo(JSPUtil.getParameter(request, prefix + "regu_dp_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setImdgPckCd(JSPUtil.getParameter(request, prefix + "imdg_pck_cd", ""));
		setPckRefCd(JSPUtil.getParameter(request, prefix + "pck_ref_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setSubSeq(JSPUtil.getParameter(request, prefix + "sub_seq", ""));
		setMaxMass(JSPUtil.getParameter(request, prefix + "max_mass", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setRefDesc(JSPUtil.getParameter(request, prefix + "ref_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckCreationVO[]
	 */
	public ScgPckCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckCreationVO[]
	 */
	public ScgPckCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] andOrCd = (JSPUtil.getParameter(request, prefix	+ "and_or_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] maxCtnt = (JSPUtil.getParameter(request, prefix	+ "max_ctnt", length));
			String[] prmtChkCd = (JSPUtil.getParameter(request, prefix	+ "prmt_chk_cd", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] refDivNo = (JSPUtil.getParameter(request, prefix	+ "ref_div_no", length));
			String[] imdgPckMzdCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_mzd_cd", length));
			String[] reguDpNo = (JSPUtil.getParameter(request, prefix	+ "regu_dp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgPckCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_cd", length));
			String[] pckRefCd = (JSPUtil.getParameter(request, prefix	+ "pck_ref_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] subSeq = (JSPUtil.getParameter(request, prefix	+ "sub_seq", length));
			String[] maxMass = (JSPUtil.getParameter(request, prefix	+ "max_mass", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] refDesc = (JSPUtil.getParameter(request, prefix	+ "ref_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckCreationVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (andOrCd[i] != null)
					model.setAndOrCd(andOrCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (maxCtnt[i] != null)
					model.setMaxCtnt(maxCtnt[i]);
				if (prmtChkCd[i] != null)
					model.setPrmtChkCd(prmtChkCd[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (refDivNo[i] != null)
					model.setRefDivNo(refDivNo[i]);
				if (imdgPckMzdCd[i] != null)
					model.setImdgPckMzdCd(imdgPckMzdCd[i]);
				if (reguDpNo[i] != null)
					model.setReguDpNo(reguDpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgPckCd[i] != null)
					model.setImdgPckCd(imdgPckCd[i]);
				if (pckRefCd[i] != null)
					model.setPckRefCd(pckRefCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (subSeq[i] != null)
					model.setSubSeq(subSeq[i]);
				if (maxMass[i] != null)
					model.setMaxMass(maxMass[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (refDesc[i] != null)
					model.setRefDesc(refDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckCreationVO[]
	 */
	public ScgPckCreationVO[] getScgPckCreationVOs(){
		ScgPckCreationVO[] vos = (ScgPckCreationVO[])models.toArray(new ScgPckCreationVO[models.size()]);
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
		this.andOrCd = this.andOrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCtnt = this.maxCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmtChkCd = this.prmtChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDivNo = this.refDivNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckMzdCd = this.imdgPckMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguDpNo = this.reguDpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckCd = this.imdgPckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckRefCd = this.pckRefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSeq = this.subSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxMass = this.maxMass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDesc = this.refDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
