/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PreRestrictionSpclProviVO.java
*@FileTitle : PreRestrictionSpclProviVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.21
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.21 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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

public class PreRestrictionSpclProviVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreRestrictionSpclProviVO> models = new ArrayList<PreRestrictionSpclProviVO>();
	
	/* Column Info */
	private String grpN1stUseFlg = null;
	/* Column Info */
	private String grpN2ndUseFlg = null;
	/* Column Info */
	private String grpN3rdUseFlg = null;
	/* Column Info */
	private String ruleAplyTpCd = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String prmtChkCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String intmdImdgPckCd1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String spclPckProviCd = null;
	/* Column Info */
	private String subSeq = null;
	/* Column Info */
	private String spclPckProviDivCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String inImdgPckCd1 = null;
	/* Column Info */
	private String outImdgPckCd1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreRestrictionSpclProviVO() {}

	public PreRestrictionSpclProviVO(String ibflag, String pagerows, String grpN1stUseFlg, String grpN2ndUseFlg, String grpN3rdUseFlg, String imdgPckInstrCd, String imdgPckInstrSeq, String intmdImdgPckCd1, String inImdgPckCd1, String outImdgPckCd1, String prmtChkCd, String ruleAplyTpCd, String spclPckProviCd, String spclPckProviDivCd, String subSeq, String imdgUnNo) {
		this.grpN1stUseFlg = grpN1stUseFlg;
		this.grpN2ndUseFlg = grpN2ndUseFlg;
		this.grpN3rdUseFlg = grpN3rdUseFlg;
		this.ruleAplyTpCd = ruleAplyTpCd;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.prmtChkCd = prmtChkCd;
		this.pagerows = pagerows;
		this.intmdImdgPckCd1 = intmdImdgPckCd1;
		this.ibflag = ibflag;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.spclPckProviCd = spclPckProviCd;
		this.subSeq = subSeq;
		this.spclPckProviDivCd = spclPckProviDivCd;
		this.imdgUnNo = imdgUnNo;
		this.inImdgPckCd1 = inImdgPckCd1;
		this.outImdgPckCd1 = outImdgPckCd1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp_n1st_use_flg", getGrpN1stUseFlg());
		this.hashColumns.put("grp_n2nd_use_flg", getGrpN2ndUseFlg());
		this.hashColumns.put("grp_n3rd_use_flg", getGrpN3rdUseFlg());
		this.hashColumns.put("rule_aply_tp_cd", getRuleAplyTpCd());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("prmt_chk_cd", getPrmtChkCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("intmd_imdg_pck_cd1", getIntmdImdgPckCd1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("spcl_pck_provi_cd", getSpclPckProviCd());
		this.hashColumns.put("sub_seq", getSubSeq());
		this.hashColumns.put("spcl_pck_provi_div_cd", getSpclPckProviDivCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("in_imdg_pck_cd1", getInImdgPckCd1());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp_n1st_use_flg", "grpN1stUseFlg");
		this.hashFields.put("grp_n2nd_use_flg", "grpN2ndUseFlg");
		this.hashFields.put("grp_n3rd_use_flg", "grpN3rdUseFlg");
		this.hashFields.put("rule_aply_tp_cd", "ruleAplyTpCd");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("prmt_chk_cd", "prmtChkCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("intmd_imdg_pck_cd1", "intmdImdgPckCd1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("spcl_pck_provi_cd", "spclPckProviCd");
		this.hashFields.put("sub_seq", "subSeq");
		this.hashFields.put("spcl_pck_provi_div_cd", "spclPckProviDivCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("in_imdg_pck_cd1", "inImdgPckCd1");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grpN1stUseFlg
	 */
	public String getGrpN1stUseFlg() {
		return this.grpN1stUseFlg;
	}
	
	/**
	 * Column Info
	 * @return grpN2ndUseFlg
	 */
	public String getGrpN2ndUseFlg() {
		return this.grpN2ndUseFlg;
	}
	
	/**
	 * Column Info
	 * @return grpN3rdUseFlg
	 */
	public String getGrpN3rdUseFlg() {
		return this.grpN3rdUseFlg;
	}
	
	/**
	 * Column Info
	 * @return ruleAplyTpCd
	 */
	public String getRuleAplyTpCd() {
		return this.ruleAplyTpCd;
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
	 * @return prmtChkCd
	 */
	public String getPrmtChkCd() {
		return this.prmtChkCd;
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
	 * @return intmdImdgPckCd1
	 */
	public String getIntmdImdgPckCd1() {
		return this.intmdImdgPckCd1;
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
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return spclPckProviCd
	 */
	public String getSpclPckProviCd() {
		return this.spclPckProviCd;
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
	 * @return spclPckProviDivCd
	 */
	public String getSpclPckProviDivCd() {
		return this.spclPckProviDivCd;
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
	 * @return inImdgPckCd1
	 */
	public String getInImdgPckCd1() {
		return this.inImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckCd1
	 */
	public String getOutImdgPckCd1() {
		return this.outImdgPckCd1;
	}
	

	/**
	 * Column Info
	 * @param grpN1stUseFlg
	 */
	public void setGrpN1stUseFlg(String grpN1stUseFlg) {
		this.grpN1stUseFlg = grpN1stUseFlg;
	}
	
	/**
	 * Column Info
	 * @param grpN2ndUseFlg
	 */
	public void setGrpN2ndUseFlg(String grpN2ndUseFlg) {
		this.grpN2ndUseFlg = grpN2ndUseFlg;
	}
	
	/**
	 * Column Info
	 * @param grpN3rdUseFlg
	 */
	public void setGrpN3rdUseFlg(String grpN3rdUseFlg) {
		this.grpN3rdUseFlg = grpN3rdUseFlg;
	}
	
	/**
	 * Column Info
	 * @param ruleAplyTpCd
	 */
	public void setRuleAplyTpCd(String ruleAplyTpCd) {
		this.ruleAplyTpCd = ruleAplyTpCd;
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
	 * @param prmtChkCd
	 */
	public void setPrmtChkCd(String prmtChkCd) {
		this.prmtChkCd = prmtChkCd;
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
	 * @param intmdImdgPckCd1
	 */
	public void setIntmdImdgPckCd1(String intmdImdgPckCd1) {
		this.intmdImdgPckCd1 = intmdImdgPckCd1;
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
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param spclPckProviCd
	 */
	public void setSpclPckProviCd(String spclPckProviCd) {
		this.spclPckProviCd = spclPckProviCd;
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
	 * @param spclPckProviDivCd
	 */
	public void setSpclPckProviDivCd(String spclPckProviDivCd) {
		this.spclPckProviDivCd = spclPckProviDivCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param inImdgPckCd1
	 */
	public void setInImdgPckCd1(String inImdgPckCd1) {
		this.inImdgPckCd1 = inImdgPckCd1;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckCd1
	 */
	public void setOutImdgPckCd1(String outImdgPckCd1) {
		this.outImdgPckCd1 = outImdgPckCd1;
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
		setGrpN1stUseFlg(JSPUtil.getParameter(request, prefix + "grp_n1st_use_flg", ""));
		setGrpN2ndUseFlg(JSPUtil.getParameter(request, prefix + "grp_n2nd_use_flg", ""));
		setGrpN3rdUseFlg(JSPUtil.getParameter(request, prefix + "grp_n3rd_use_flg", ""));
		setRuleAplyTpCd(JSPUtil.getParameter(request, prefix + "rule_aply_tp_cd", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setPrmtChkCd(JSPUtil.getParameter(request, prefix + "prmt_chk_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIntmdImdgPckCd1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_cd1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setSpclPckProviCd(JSPUtil.getParameter(request, prefix + "spcl_pck_provi_cd", ""));
		setSubSeq(JSPUtil.getParameter(request, prefix + "sub_seq", ""));
		setSpclPckProviDivCd(JSPUtil.getParameter(request, prefix + "spcl_pck_provi_div_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setInImdgPckCd1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd1", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreRestrictionSpclProviVO[]
	 */
	public PreRestrictionSpclProviVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreRestrictionSpclProviVO[]
	 */
	public PreRestrictionSpclProviVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreRestrictionSpclProviVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grpN1stUseFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n1st_use_flg", length));
			String[] grpN2ndUseFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n2nd_use_flg", length));
			String[] grpN3rdUseFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n3rd_use_flg", length));
			String[] ruleAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "rule_aply_tp_cd", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] prmtChkCd = (JSPUtil.getParameter(request, prefix	+ "prmt_chk_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] intmdImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "intmd_imdg_pck_cd1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] spclPckProviCd = (JSPUtil.getParameter(request, prefix	+ "spcl_pck_provi_cd", length));
			String[] subSeq = (JSPUtil.getParameter(request, prefix	+ "sub_seq", length));
			String[] spclPckProviDivCd = (JSPUtil.getParameter(request, prefix	+ "spcl_pck_provi_div_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] inImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "in_imdg_pck_cd1", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreRestrictionSpclProviVO();
				if (grpN1stUseFlg[i] != null)
					model.setGrpN1stUseFlg(grpN1stUseFlg[i]);
				if (grpN2ndUseFlg[i] != null)
					model.setGrpN2ndUseFlg(grpN2ndUseFlg[i]);
				if (grpN3rdUseFlg[i] != null)
					model.setGrpN3rdUseFlg(grpN3rdUseFlg[i]);
				if (ruleAplyTpCd[i] != null)
					model.setRuleAplyTpCd(ruleAplyTpCd[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (prmtChkCd[i] != null)
					model.setPrmtChkCd(prmtChkCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (intmdImdgPckCd1[i] != null)
					model.setIntmdImdgPckCd1(intmdImdgPckCd1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (spclPckProviCd[i] != null)
					model.setSpclPckProviCd(spclPckProviCd[i]);
				if (subSeq[i] != null)
					model.setSubSeq(subSeq[i]);
				if (spclPckProviDivCd[i] != null)
					model.setSpclPckProviDivCd(spclPckProviDivCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (inImdgPckCd1[i] != null)
					model.setInImdgPckCd1(inImdgPckCd1[i]);
				if (outImdgPckCd1[i] != null)
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreRestrictionSpclProviVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreRestrictionSpclProviVO[]
	 */
	public PreRestrictionSpclProviVO[] getPreRestrictionSpclProviVOs(){
		PreRestrictionSpclProviVO[] vos = (PreRestrictionSpclProviVO[])models.toArray(new PreRestrictionSpclProviVO[models.size()]);
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
		this.grpN1stUseFlg = this.grpN1stUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN2ndUseFlg = this.grpN2ndUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN3rdUseFlg = this.grpN3rdUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruleAplyTpCd = this.ruleAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmtChkCd = this.prmtChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intmdImdgPckCd1 = this.intmdImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclPckProviCd = this.spclPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSeq = this.subSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclPckProviDivCd = this.spclPckProviDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inImdgPckCd1 = this.inImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
