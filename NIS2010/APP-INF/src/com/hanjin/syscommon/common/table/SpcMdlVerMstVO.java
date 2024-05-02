/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpcMdlVerMstVO.java
*@FileTitle : SpcMdlVerMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.02.27 진마리아 
* 1.0 Creation
* 2013.02.27 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcMdlVerMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcMdlVerMstVO> models = new ArrayList<SpcMdlVerMstVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String verEndYrwk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String perfEndYrwk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String perfStYrwk = null;
	/* Column Info */
	private String verStYrwk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String costYrwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcMdlVerMstVO() {}

	public SpcMdlVerMstVO(String ibflag, String pagerows, String costYrwk, String verSeq, String cfmFlg, String verStYrwk, String verEndYrwk, String perfStYrwk, String perfEndYrwk, String creUsrId, String creDt, String updUsrId, String updDt, String trdCd) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.cfmFlg = cfmFlg;
		this.verEndYrwk = verEndYrwk;
		this.pagerows = pagerows;
		this.verSeq = verSeq;
		this.ibflag = ibflag;
		this.perfEndYrwk = perfEndYrwk;
		this.creUsrId = creUsrId;
		this.perfStYrwk = perfStYrwk;
		this.verStYrwk = verStYrwk;
		this.updUsrId = updUsrId;
		this.costYrwk = costYrwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("ver_end_yrwk", getVerEndYrwk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("perf_end_yrwk", getPerfEndYrwk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("perf_st_yrwk", getPerfStYrwk());
		this.hashColumns.put("ver_st_yrwk", getVerStYrwk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("ver_end_yrwk", "verEndYrwk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("perf_end_yrwk", "perfEndYrwk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("perf_st_yrwk", "perfStYrwk");
		this.hashFields.put("ver_st_yrwk", "verStYrwk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cost_yrwk", "costYrwk");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return verEndYrwk
	 */
	public String getVerEndYrwk() {
		return this.verEndYrwk;
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
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
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
	 * @return perfEndYrwk
	 */
	public String getPerfEndYrwk() {
		return this.perfEndYrwk;
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
	 * @return perfStYrwk
	 */
	public String getPerfStYrwk() {
		return this.perfStYrwk;
	}
	
	/**
	 * Column Info
	 * @return verStYrwk
	 */
	public String getVerStYrwk() {
		return this.verStYrwk;
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
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param verEndYrwk
	 */
	public void setVerEndYrwk(String verEndYrwk) {
		this.verEndYrwk = verEndYrwk;
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
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
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
	 * @param perfEndYrwk
	 */
	public void setPerfEndYrwk(String perfEndYrwk) {
		this.perfEndYrwk = perfEndYrwk;
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
	 * @param perfStYrwk
	 */
	public void setPerfStYrwk(String perfStYrwk) {
		this.perfStYrwk = perfStYrwk;
	}
	
	/**
	 * Column Info
	 * @param verStYrwk
	 */
	public void setVerStYrwk(String verStYrwk) {
		this.verStYrwk = verStYrwk;
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
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
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
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setVerEndYrwk(JSPUtil.getParameter(request, prefix + "ver_end_yrwk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPerfEndYrwk(JSPUtil.getParameter(request, prefix + "perf_end_yrwk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPerfStYrwk(JSPUtil.getParameter(request, prefix + "perf_st_yrwk", ""));
		setVerStYrwk(JSPUtil.getParameter(request, prefix + "ver_st_yrwk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcMdlVerMstVO[]
	 */
	public SpcMdlVerMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcMdlVerMstVO[]
	 */
	public SpcMdlVerMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcMdlVerMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] verEndYrwk = (JSPUtil.getParameter(request, prefix	+ "ver_end_yrwk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] perfEndYrwk = (JSPUtil.getParameter(request, prefix	+ "perf_end_yrwk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] perfStYrwk = (JSPUtil.getParameter(request, prefix	+ "perf_st_yrwk", length));
			String[] verStYrwk = (JSPUtil.getParameter(request, prefix	+ "ver_st_yrwk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcMdlVerMstVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (verEndYrwk[i] != null)
					model.setVerEndYrwk(verEndYrwk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (perfEndYrwk[i] != null)
					model.setPerfEndYrwk(perfEndYrwk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (perfStYrwk[i] != null)
					model.setPerfStYrwk(perfStYrwk[i]);
				if (verStYrwk[i] != null)
					model.setVerStYrwk(verStYrwk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcMdlVerMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcMdlVerMstVO[]
	 */
	public SpcMdlVerMstVO[] getSpcMdlVerMstVOs(){
		SpcMdlVerMstVO[] vos = (SpcMdlVerMstVO[])models.toArray(new SpcMdlVerMstVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verEndYrwk = this.verEndYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfEndYrwk = this.perfEndYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfStYrwk = this.perfStYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verStYrwk = this.verStYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
