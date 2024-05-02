/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchContractCreationUserVO.java
*@FileTitle : SearchContractCreationUserVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.20
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.20 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.agreementnotice.vo;

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
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchContractCreationUserVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContractCreationUserVO> models = new ArrayList<SearchContractCreationUserVO>();
	
	/* Column Info */
	private String agmtEffDt = null;
	/* Column Info */
	private String ctrtUpdDt = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtUpdUsrId = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String agmtExpDt = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String agmtMapgNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchContractCreationUserVO() {}

	public SearchContractCreationUserVO(String ibflag, String pagerows, String sysCd, String agmtNo, String ctrtUpdUsrId, String ofcCd, String ctrtUpdDt, String useFlg, String agmtEffDt, String agmtExpDt, String ofcTpCd, String ctrtOfcCd, String agmtMapgNo) {
		this.agmtEffDt = agmtEffDt;
		this.ctrtUpdDt = ctrtUpdDt;
		this.useFlg = useFlg;
		this.agmtNo = agmtNo;
		this.ofcTpCd = ofcTpCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.ctrtUpdUsrId = ctrtUpdUsrId;
		this.ctrtOfcCd = ctrtOfcCd;
		this.agmtExpDt = agmtExpDt;
		this.sysCd = sysCd;
		this.agmtMapgNo = agmtMapgNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_eff_dt", getAgmtEffDt());
		this.hashColumns.put("ctrt_upd_dt", getCtrtUpdDt());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_upd_usr_id", getCtrtUpdUsrId());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("agmt_mapg_no", getAgmtMapgNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_eff_dt", "agmtEffDt");
		this.hashFields.put("ctrt_upd_dt", "ctrtUpdDt");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_upd_usr_id", "ctrtUpdUsrId");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("agmt_mapg_no", "agmtMapgNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtEffDt
	 */
	public String getAgmtEffDt() {
		return this.agmtEffDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtUpdDt
	 */
	public String getCtrtUpdDt() {
		return this.ctrtUpdDt;
	}
	
	/**
	 * Column Info
	 * @return useFlg
	 */
	public String getUseFlg() {
		return this.useFlg;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
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
	 * @return ctrtUpdUsrId
	 */
	public String getCtrtUpdUsrId() {
		return this.ctrtUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtExpDt
	 */
	public String getAgmtExpDt() {
		return this.agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @return sysCd
	 */
	public String getSysCd() {
		return this.sysCd;
	}
	
	/**
	 * Column Info
	 * @return agmtMapgNo
	 */
	public String getAgmtMapgNo() {
		return this.agmtMapgNo;
	}
	

	/**
	 * Column Info
	 * @param agmtEffDt
	 */
	public void setAgmtEffDt(String agmtEffDt) {
		this.agmtEffDt = agmtEffDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtUpdDt
	 */
	public void setCtrtUpdDt(String ctrtUpdDt) {
		this.ctrtUpdDt = ctrtUpdDt;
	}
	
	/**
	 * Column Info
	 * @param useFlg
	 */
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
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
	 * @param ctrtUpdUsrId
	 */
	public void setCtrtUpdUsrId(String ctrtUpdUsrId) {
		this.ctrtUpdUsrId = ctrtUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtExpDt
	 */
	public void setAgmtExpDt(String agmtExpDt) {
		this.agmtExpDt = agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @param sysCd
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}
	
	/**
	 * Column Info
	 * @param agmtMapgNo
	 */
	public void setAgmtMapgNo(String agmtMapgNo) {
		this.agmtMapgNo = agmtMapgNo;
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
		setAgmtEffDt(JSPUtil.getParameter(request, prefix + "agmt_eff_dt", ""));
		setCtrtUpdDt(JSPUtil.getParameter(request, prefix + "ctrt_upd_dt", ""));
		setUseFlg(JSPUtil.getParameter(request, prefix + "use_flg", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtUpdUsrId(JSPUtil.getParameter(request, prefix + "ctrt_upd_usr_id", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setAgmtExpDt(JSPUtil.getParameter(request, prefix + "agmt_exp_dt", ""));
		setSysCd(JSPUtil.getParameter(request, prefix + "sys_cd", ""));
		setAgmtMapgNo(JSPUtil.getParameter(request, prefix + "agmt_mapg_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContractCreationUserVO[]
	 */
	public SearchContractCreationUserVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContractCreationUserVO[]
	 */
	public SearchContractCreationUserVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContractCreationUserVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtEffDt = (JSPUtil.getParameter(request, prefix	+ "agmt_eff_dt", length));
			String[] ctrtUpdDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_upd_dt", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "ctrt_upd_usr_id", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] agmtExpDt = (JSPUtil.getParameter(request, prefix	+ "agmt_exp_dt", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] agmtMapgNo = (JSPUtil.getParameter(request, prefix	+ "agmt_mapg_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContractCreationUserVO();
				if (agmtEffDt[i] != null)
					model.setAgmtEffDt(agmtEffDt[i]);
				if (ctrtUpdDt[i] != null)
					model.setCtrtUpdDt(ctrtUpdDt[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtUpdUsrId[i] != null)
					model.setCtrtUpdUsrId(ctrtUpdUsrId[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (agmtExpDt[i] != null)
					model.setAgmtExpDt(agmtExpDt[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (agmtMapgNo[i] != null)
					model.setAgmtMapgNo(agmtMapgNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContractCreationUserVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContractCreationUserVO[]
	 */
	public SearchContractCreationUserVO[] getSearchContractCreationUserVOs(){
		SearchContractCreationUserVO[] vos = (SearchContractCreationUserVO[])models.toArray(new SearchContractCreationUserVO[models.size()]);
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
		this.agmtEffDt = this.agmtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtUpdDt = this.ctrtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtUpdUsrId = this.ctrtUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt = this.agmtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtMapgNo = this.agmtMapgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
