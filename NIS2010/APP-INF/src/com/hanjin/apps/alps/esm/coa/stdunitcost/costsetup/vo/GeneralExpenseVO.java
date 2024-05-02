/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralExpenseVO.java
*@FileTitle : GeneralExpenseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.09.27 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GeneralExpenseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GeneralExpenseVO> models = new ArrayList<GeneralExpenseVO>();
	
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String genExpnAmt = null;
	/* Column Info */
	private String ofcGrpNo = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String otrExpnAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String genExpnRto = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GeneralExpenseVO() {}

	public GeneralExpenseVO(String ibflag, String pagerows, String costYrmon, String rhqCd, String ofcGrpNo, String ofcVwCd, String genExpnRto, String genExpnAmt, String otrExpnAmt, String creUsrId, String updUsrId, String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.genExpnAmt = genExpnAmt;
		this.ofcGrpNo = ofcGrpNo;
		this.rhqCd = rhqCd;
		this.ofcVwCd = ofcVwCd;
		this.otrExpnAmt = otrExpnAmt;
		this.updUsrId = updUsrId;
		this.genExpnRto = genExpnRto;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("gen_expn_amt", getGenExpnAmt());
		this.hashColumns.put("ofc_grp_no", getOfcGrpNo());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("otr_expn_amt", getOtrExpnAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gen_expn_rto", getGenExpnRto());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("gen_expn_amt", "genExpnAmt");
		this.hashFields.put("ofc_grp_no", "ofcGrpNo");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("otr_expn_amt", "otrExpnAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gen_expn_rto", "genExpnRto");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return ofcGrpNo
	 */
	public String getOfcGrpNo() {
		return this.ofcGrpNo;
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
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return genExpnRto
	 */
	public String getGenExpnRto() {
		return this.genExpnRto;
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
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param ofcGrpNo
	 */
	public void setOfcGrpNo(String ofcGrpNo) {
		this.ofcGrpNo = ofcGrpNo;
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
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param genExpnRto
	 */
	public void setGenExpnRto(String genExpnRto) {
		this.genExpnRto = genExpnRto;
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
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setGenExpnAmt(JSPUtil.getParameter(request, prefix + "gen_expn_amt", ""));
		setOfcGrpNo(JSPUtil.getParameter(request, prefix + "ofc_grp_no", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setOtrExpnAmt(JSPUtil.getParameter(request, prefix + "otr_expn_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setGenExpnRto(JSPUtil.getParameter(request, prefix + "gen_expn_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
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
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] genExpnAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_amt", length));
			String[] ofcGrpNo = (JSPUtil.getParameter(request, prefix	+ "ofc_grp_no", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] otrExpnAmt = (JSPUtil.getParameter(request, prefix	+ "otr_expn_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] genExpnRto = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GeneralExpenseVO();
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (genExpnAmt[i] != null)
					model.setGenExpnAmt(genExpnAmt[i]);
				if (ofcGrpNo[i] != null)
					model.setOfcGrpNo(ofcGrpNo[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (otrExpnAmt[i] != null)
					model.setOtrExpnAmt(otrExpnAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (genExpnRto[i] != null)
					model.setGenExpnRto(genExpnRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAmt = this.genExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcGrpNo = this.ofcGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrExpnAmt = this.otrExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRto = this.genExpnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
