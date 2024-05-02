/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralExpenseVO.java
*@FileTitle : GeneralExpenseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.21 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo;

import java.lang.reflect.Field;
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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GeneralExpenseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GeneralExpenseVO> models = new ArrayList<GeneralExpenseVO>();
	
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String fSweek = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ofcGrpNo = null;
	/* Column Info */
	private String genExpnAmt = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String fDur = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String otrExpnAmt = null;
	/* Column Info */
	private String genExpnRto = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GeneralExpenseVO() {}

	public GeneralExpenseVO(String ibflag, String pagerows, String costYrmon, String rhqCd, String ofcGrpNo, String ofcVwCd, String genExpnRto, String genExpnAmt, String otrExpnAmt, String creUsrId, String updUsrId, String fCostYrmon, String fSweek, String fDur) {
		this.fCostYrmon = fCostYrmon;
		this.fSweek = fSweek;
		this.rhqCd = rhqCd;
		this.ofcGrpNo = ofcGrpNo;
		this.genExpnAmt = genExpnAmt;
		this.ofcVwCd = ofcVwCd;
		this.fDur = fDur;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costYrmon = costYrmon;
		this.otrExpnAmt = otrExpnAmt;
		this.genExpnRto = genExpnRto;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("f_sweek", getFSweek());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ofc_grp_no", getOfcGrpNo());
		this.hashColumns.put("gen_expn_amt", getGenExpnAmt());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("f_dur", getFDur());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("otr_expn_amt", getOtrExpnAmt());
		this.hashColumns.put("gen_expn_rto", getGenExpnRto());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("f_sweek", "fSweek");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ofc_grp_no", "ofcGrpNo");
		this.hashFields.put("gen_expn_amt", "genExpnAmt");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("f_dur", "fDur");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("otr_expn_amt", "otrExpnAmt");
		this.hashFields.put("gen_expn_rto", "genExpnRto");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return fSweek
	 */
	public String getFSweek() {
		return this.fSweek;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return ofcGrpNo
	 */
	public String getOfcGrpNo() {
		return this.ofcGrpNo;
	}
	
	/**
	 * Column Info
	 * @return genExpnAmt
	 */
	public String getGenExpnAmt() {
		return this.genExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @return fDur
	 */
	public String getFDur() {
		return this.fDur;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return otrExpnAmt
	 */
	public String getOtrExpnAmt() {
		return this.otrExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnRto
	 */
	public String getGenExpnRto() {
		return this.genExpnRto;
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
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param fSweek
	 */
	public void setFSweek(String fSweek) {
		this.fSweek = fSweek;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param ofcGrpNo
	 */
	public void setOfcGrpNo(String ofcGrpNo) {
		this.ofcGrpNo = ofcGrpNo;
	}
	
	/**
	 * Column Info
	 * @param genExpnAmt
	 */
	public void setGenExpnAmt(String genExpnAmt) {
		this.genExpnAmt = genExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @param fDur
	 */
	public void setFDur(String fDur) {
		this.fDur = fDur;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param otrExpnAmt
	 */
	public void setOtrExpnAmt(String otrExpnAmt) {
		this.otrExpnAmt = otrExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnRto
	 */
	public void setGenExpnRto(String genExpnRto) {
		this.genExpnRto = genExpnRto;
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
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setFSweek(JSPUtil.getParameter(request, prefix + "f_sweek", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOfcGrpNo(JSPUtil.getParameter(request, prefix + "ofc_grp_no", ""));
		setGenExpnAmt(JSPUtil.getParameter(request, prefix + "gen_expn_amt", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setFDur(JSPUtil.getParameter(request, prefix + "f_dur", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setOtrExpnAmt(JSPUtil.getParameter(request, prefix + "otr_expn_amt", ""));
		setGenExpnRto(JSPUtil.getParameter(request, prefix + "gen_expn_rto", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GeneralExpenseVO[]
	 */
	public GeneralExpenseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GeneralExpenseVO[]
	 */
	public GeneralExpenseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GeneralExpenseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] fSweek = (JSPUtil.getParameter(request, prefix	+ "f_sweek", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ofcGrpNo = (JSPUtil.getParameter(request, prefix	+ "ofc_grp_no", length));
			String[] genExpnAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_amt", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] fDur = (JSPUtil.getParameter(request, prefix	+ "f_dur", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] otrExpnAmt = (JSPUtil.getParameter(request, prefix	+ "otr_expn_amt", length));
			String[] genExpnRto = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rto", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new GeneralExpenseVO();
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (fSweek[i] != null)
					model.setFSweek(fSweek[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ofcGrpNo[i] != null)
					model.setOfcGrpNo(ofcGrpNo[i]);
				if (genExpnAmt[i] != null)
					model.setGenExpnAmt(genExpnAmt[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (fDur[i] != null)
					model.setFDur(fDur[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (otrExpnAmt[i] != null)
					model.setOtrExpnAmt(otrExpnAmt[i]);
				if (genExpnRto[i] != null)
					model.setGenExpnRto(genExpnRto[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGeneralExpenseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GeneralExpenseVO[]
	 */
	public GeneralExpenseVO[] getGeneralExpenseVOs(){
		GeneralExpenseVO[] vos = (GeneralExpenseVO[])models.toArray(new GeneralExpenseVO[models.size()]);
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
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSweek = this.fSweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcGrpNo = this.ofcGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAmt = this.genExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDur = this.fDur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrExpnAmt = this.otrExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRto = this.genExpnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
