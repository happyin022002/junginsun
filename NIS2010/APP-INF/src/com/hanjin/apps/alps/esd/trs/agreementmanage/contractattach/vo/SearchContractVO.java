/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchContractVO.java
*@FileTitle : SearchContractVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.09.25 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchContractVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContractVO> models = new ArrayList<SearchContractVO>();

	
	/* Column Info */
	private String agmtDocNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtDocEffFmDt = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String agmtDocDesc = null;
	/* Column Info */
	private String agmtDocEffToDt = null;
	/* Column Info */
	private String ctrtMnFlg = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchContractVO() {}

	public SearchContractVO(String ibflag, String pagerows, String trspAgmtOfcCtyCd, String trspAgmtSeq, String ctrtSeq, String ctrtMnFlg, String agmtDocNo, String agmtDocDesc, String agmtDocEffFmDt, String agmtDocEffToDt) {
		this.agmtDocNo = agmtDocNo;
		this.ibflag = ibflag;
		this.agmtDocEffFmDt = agmtDocEffFmDt;
		this.trspAgmtSeq = trspAgmtSeq;
		this.agmtDocDesc = agmtDocDesc;
		this.agmtDocEffToDt = agmtDocEffToDt;
		this.ctrtMnFlg = ctrtMnFlg;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.ctrtSeq = ctrtSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_doc_no", getAgmtDocNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_doc_eff_fm_dt", getAgmtDocEffFmDt());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("agmt_doc_desc", getAgmtDocDesc());
		this.hashColumns.put("agmt_doc_eff_to_dt", getAgmtDocEffToDt());
		this.hashColumns.put("ctrt_mn_flg", getCtrtMnFlg());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("ctrt_seq", getCtrtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_doc_no", "agmtDocNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_doc_eff_fm_dt", "agmtDocEffFmDt");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("agmt_doc_desc", "agmtDocDesc");
		this.hashFields.put("agmt_doc_eff_to_dt", "agmtDocEffToDt");
		this.hashFields.put("ctrt_mn_flg", "ctrtMnFlg");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtDocNo
	 */
	public String getAgmtDocNo() {
		return this.agmtDocNo;
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
	 * @return agmtDocEffFmDt
	 */
	public String getAgmtDocEffFmDt() {
		return this.agmtDocEffFmDt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtDocDesc
	 */
	public String getAgmtDocDesc() {
		return this.agmtDocDesc;
	}
	
	/**
	 * Column Info
	 * @return agmtDocEffToDt
	 */
	public String getAgmtDocEffToDt() {
		return this.agmtDocEffToDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtMnFlg
	 */
	public String getCtrtMnFlg() {
		return this.ctrtMnFlg;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtSeq
	 */
	public String getCtrtSeq() {
		return this.ctrtSeq;
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
	 * @param agmtDocNo
	 */
	public void setAgmtDocNo(String agmtDocNo) {
		this.agmtDocNo = agmtDocNo;
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
	 * @param agmtDocEffFmDt
	 */
	public void setAgmtDocEffFmDt(String agmtDocEffFmDt) {
		this.agmtDocEffFmDt = agmtDocEffFmDt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtDocDesc
	 */
	public void setAgmtDocDesc(String agmtDocDesc) {
		this.agmtDocDesc = agmtDocDesc;
	}
	
	/**
	 * Column Info
	 * @param agmtDocEffToDt
	 */
	public void setAgmtDocEffToDt(String agmtDocEffToDt) {
		this.agmtDocEffToDt = agmtDocEffToDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtMnFlg
	 */
	public void setCtrtMnFlg(String ctrtMnFlg) {
		this.ctrtMnFlg = ctrtMnFlg;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtSeq
	 */
	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
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
		setAgmtDocNo(JSPUtil.getParameter(request, prefix + "agmt_doc_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAgmtDocEffFmDt(JSPUtil.getParameter(request, prefix + "agmt_doc_eff_fm_dt", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
		setAgmtDocDesc(JSPUtil.getParameter(request, prefix + "agmt_doc_desc", ""));
		setAgmtDocEffToDt(JSPUtil.getParameter(request, prefix + "agmt_doc_eff_to_dt", ""));
		setCtrtMnFlg(JSPUtil.getParameter(request, prefix + "ctrt_mn_flg", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));
		setCtrtSeq(JSPUtil.getParameter(request, prefix + "ctrt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContractVO[]
	 */
	public SearchContractVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContractVO[]
	 */
	public SearchContractVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContractVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtDocNo = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtDocEffFmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_eff_fm_dt", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_seq", length));
			String[] agmtDocDesc = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_desc", length));
			String[] agmtDocEffToDt = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_eff_to_dt", length));
			String[] ctrtMnFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_mn_flg", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_ofc_cty_cd", length));
			String[] ctrtSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContractVO();
				if (agmtDocNo[i] != null)
					model.setAgmtDocNo(agmtDocNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtDocEffFmDt[i] != null)
					model.setAgmtDocEffFmDt(agmtDocEffFmDt[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (agmtDocDesc[i] != null)
					model.setAgmtDocDesc(agmtDocDesc[i]);
				if (agmtDocEffToDt[i] != null)
					model.setAgmtDocEffToDt(agmtDocEffToDt[i]);
				if (ctrtMnFlg[i] != null)
					model.setCtrtMnFlg(ctrtMnFlg[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (ctrtSeq[i] != null)
					model.setCtrtSeq(ctrtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContractVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContractVO[]
	 */
	public SearchContractVO[] getSearchContractVOs(){
		SearchContractVO[] vos = (SearchContractVO[])models.toArray(new SearchContractVO[models.size()]);
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
		this.agmtDocNo = this.agmtDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocEffFmDt = this.agmtDocEffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocDesc = this.agmtDocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocEffToDt = this.agmtDocEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtMnFlg = this.ctrtMnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq = this.ctrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
