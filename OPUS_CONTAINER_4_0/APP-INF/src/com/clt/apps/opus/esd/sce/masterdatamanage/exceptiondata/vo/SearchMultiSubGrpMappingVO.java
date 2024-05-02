/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMultiSubGrpMappingVO.java
*@FileTitle : SearchMultiSubGrpMappingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.26 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMultiSubGrpMappingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMultiSubGrpMappingVO> models = new ArrayList<SearchMultiSubGrpMappingVO>();
	
	/* Column Info */
	private String rFmAct = null;
	/* Column Info */
	private String rExptTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rSubseqGrp = null;
	/* Column Info */
	private String rAct = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String copExptSubscCsSeq = null;
	/* Column Info */
	private String rNotiPrty = null;
	/* Column Info */
	private String rIbflag = null;
	/* Column Info */
	private String rToAct = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMultiSubGrpMappingVO() {}

	public SearchMultiSubGrpMappingVO(String ibflag, String pagerows, String rToAct, String rFmAct, String rSubseqGrp, String rNotiPrty, String usrId, String rAct, String copExptSubscCsSeq, String rExptTp, String rIbflag) {
		this.rFmAct = rFmAct;
		this.rExptTp = rExptTp;
		this.ibflag = ibflag;
		this.rSubseqGrp = rSubseqGrp;
		this.rAct = rAct;
		this.usrId = usrId;
		this.copExptSubscCsSeq = copExptSubscCsSeq;
		this.rNotiPrty = rNotiPrty;
		this.rIbflag = rIbflag;
		this.rToAct = rToAct;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r_fm_act", getRFmAct());
		this.hashColumns.put("r_expt_tp", getRExptTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r_subseq_grp", getRSubseqGrp());
		this.hashColumns.put("r_act", getRAct());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cop_expt_subsc_cs_seq", getCopExptSubscCsSeq());
		this.hashColumns.put("r_noti_prty", getRNotiPrty());
		this.hashColumns.put("r_ibflag", getRIbflag());
		this.hashColumns.put("r_to_act", getRToAct());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r_fm_act", "rFmAct");
		this.hashFields.put("r_expt_tp", "rExptTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r_subseq_grp", "rSubseqGrp");
		this.hashFields.put("r_act", "rAct");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cop_expt_subsc_cs_seq", "copExptSubscCsSeq");
		this.hashFields.put("r_noti_prty", "rNotiPrty");
		this.hashFields.put("r_ibflag", "rIbflag");
		this.hashFields.put("r_to_act", "rToAct");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rFmAct
	 */
	public String getRFmAct() {
		return this.rFmAct;
	}
	
	/**
	 * Column Info
	 * @return rExptTp
	 */
	public String getRExptTp() {
		return this.rExptTp;
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
	 * @return rSubseqGrp
	 */
	public String getRSubseqGrp() {
		return this.rSubseqGrp;
	}
	
	/**
	 * Column Info
	 * @return rAct
	 */
	public String getRAct() {
		return this.rAct;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return copExptSubscCsSeq
	 */
	public String getCopExptSubscCsSeq() {
		return this.copExptSubscCsSeq;
	}
	
	/**
	 * Column Info
	 * @return rNotiPrty
	 */
	public String getRNotiPrty() {
		return this.rNotiPrty;
	}
	
	/**
	 * Column Info
	 * @return rIbflag
	 */
	public String getRIbflag() {
		return this.rIbflag;
	}
	
	/**
	 * Column Info
	 * @return rToAct
	 */
	public String getRToAct() {
		return this.rToAct;
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
	 * @param rFmAct
	 */
	public void setRFmAct(String rFmAct) {
		this.rFmAct = rFmAct;
	}
	
	/**
	 * Column Info
	 * @param rExptTp
	 */
	public void setRExptTp(String rExptTp) {
		this.rExptTp = rExptTp;
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
	 * @param rSubseqGrp
	 */
	public void setRSubseqGrp(String rSubseqGrp) {
		this.rSubseqGrp = rSubseqGrp;
	}
	
	/**
	 * Column Info
	 * @param rAct
	 */
	public void setRAct(String rAct) {
		this.rAct = rAct;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param copExptSubscCsSeq
	 */
	public void setCopExptSubscCsSeq(String copExptSubscCsSeq) {
		this.copExptSubscCsSeq = copExptSubscCsSeq;
	}
	
	/**
	 * Column Info
	 * @param rNotiPrty
	 */
	public void setRNotiPrty(String rNotiPrty) {
		this.rNotiPrty = rNotiPrty;
	}
	
	/**
	 * Column Info
	 * @param rIbflag
	 */
	public void setRIbflag(String rIbflag) {
		this.rIbflag = rIbflag;
	}
	
	/**
	 * Column Info
	 * @param rToAct
	 */
	public void setRToAct(String rToAct) {
		this.rToAct = rToAct;
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
		setRFmAct(JSPUtil.getParameter(request, "r_fm_act", ""));
		setRExptTp(JSPUtil.getParameter(request, "r_expt_tp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRSubseqGrp(JSPUtil.getParameter(request, "r_subseq_grp", ""));
		setRAct(JSPUtil.getParameter(request, "r_act", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCopExptSubscCsSeq(JSPUtil.getParameter(request, "cop_expt_subsc_cs_seq", ""));
		setRNotiPrty(JSPUtil.getParameter(request, "r_noti_prty", ""));
		setRIbflag(JSPUtil.getParameter(request, "r_ibflag", ""));
		setRToAct(JSPUtil.getParameter(request, "r_to_act", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMultiSubGrpMappingVO[]
	 */
	public SearchMultiSubGrpMappingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMultiSubGrpMappingVO[]
	 */
	public SearchMultiSubGrpMappingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMultiSubGrpMappingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "r_ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "r_ibflag").length;
  
		try {
			String[] rFmAct = (JSPUtil.getParameter(request, prefix	+ "r_fm_act", length));
			String[] rExptTp = (JSPUtil.getParameter(request, prefix	+ "r_expt_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rSubseqGrp = (JSPUtil.getParameter(request, prefix	+ "r_subseq_grp", length));
			String[] rAct = (JSPUtil.getParameter(request, prefix	+ "r_act", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] copExptSubscCsSeq = (JSPUtil.getParameter(request, prefix	+ "cop_expt_subsc_cs_seq", length));
			String[] rNotiPrty = (JSPUtil.getParameter(request, prefix	+ "r_noti_prty", length));
			String[] rIbflag = (JSPUtil.getParameter(request, prefix	+ "r_ibflag", length));
			String[] rToAct = (JSPUtil.getParameter(request, prefix	+ "r_to_act", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMultiSubGrpMappingVO();
				if (rFmAct[i] != null)
					model.setRFmAct(rFmAct[i]);
				if (rExptTp[i] != null)
					model.setRExptTp(rExptTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rSubseqGrp[i] != null)
					model.setRSubseqGrp(rSubseqGrp[i]);
				if (rAct[i] != null)
					model.setRAct(rAct[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (copExptSubscCsSeq[i] != null)
					model.setCopExptSubscCsSeq(copExptSubscCsSeq[i]);
				if (rNotiPrty[i] != null)
					model.setRNotiPrty(rNotiPrty[i]);
				if (rIbflag[i] != null)
					model.setRIbflag(rIbflag[i]);
				if (rToAct[i] != null)
					model.setRToAct(rToAct[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMultiSubGrpMappingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMultiSubGrpMappingVO[]
	 */
	public SearchMultiSubGrpMappingVO[] getSearchMultiSubGrpMappingVOs(){
		SearchMultiSubGrpMappingVO[] vos = (SearchMultiSubGrpMappingVO[])models.toArray(new SearchMultiSubGrpMappingVO[models.size()]);
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
		this.rFmAct = this.rFmAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rExptTp = this.rExptTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rSubseqGrp = this.rSubseqGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rAct = this.rAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptSubscCsSeq = this.copExptSubscCsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rNotiPrty = this.rNotiPrty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rIbflag = this.rIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rToAct = this.rToAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
