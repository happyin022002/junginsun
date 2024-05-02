/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemRsltSmryVO.java
*@FileTitle : GemRsltSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.23 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GemRsltSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemRsltSmryVO> models = new ArrayList<GemRsltSmryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rsltYrmon = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String genExpnTrnsAmt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String slpPerfAmt = null;
	/* Column Info */
	private String genExpnInitAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subGenExpnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String genExpnOvrRtoRsn = null;
	/* Column Info */
	private String ofcCoDivCd = null;
	/* Column Info */
	private String genExpnAddAmt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemRsltSmryVO() {}

	public GemRsltSmryVO(String ibflag, String pagerows, String rsltYrmon, String ofcCd, String subOfcCd, String genExpnCd, String subGenExpnCd, String ofcCoDivCd, String genExpnInitAmt, String genExpnAddAmt, String genExpnTrnsAmt, String slpPerfAmt, String genExpnOvrRtoRsn, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.rsltYrmon = rsltYrmon;
		this.creDt = creDt;
		this.subOfcCd = subOfcCd;
		this.genExpnTrnsAmt = genExpnTrnsAmt;
		this.genExpnCd = genExpnCd;
		this.slpPerfAmt = slpPerfAmt;
		this.genExpnInitAmt = genExpnInitAmt;
		this.pagerows = pagerows;
		this.subGenExpnCd = subGenExpnCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.genExpnOvrRtoRsn = genExpnOvrRtoRsn;
		this.ofcCoDivCd = ofcCoDivCd;
		this.genExpnAddAmt = genExpnAddAmt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rslt_yrmon", getRsltYrmon());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("gen_expn_trns_amt", getGenExpnTrnsAmt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("slp_perf_amt", getSlpPerfAmt());
		this.hashColumns.put("gen_expn_init_amt", getGenExpnInitAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sub_gen_expn_cd", getSubGenExpnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gen_expn_ovr_rto_rsn", getGenExpnOvrRtoRsn());
		this.hashColumns.put("ofc_co_div_cd", getOfcCoDivCd());
		this.hashColumns.put("gen_expn_add_amt", getGenExpnAddAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rslt_yrmon", "rsltYrmon");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("gen_expn_trns_amt", "genExpnTrnsAmt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("slp_perf_amt", "slpPerfAmt");
		this.hashFields.put("gen_expn_init_amt", "genExpnInitAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sub_gen_expn_cd", "subGenExpnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gen_expn_ovr_rto_rsn", "genExpnOvrRtoRsn");
		this.hashFields.put("ofc_co_div_cd", "ofcCoDivCd");
		this.hashFields.put("gen_expn_add_amt", "genExpnAddAmt");
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
	 * @return rsltYrmon
	 */
	public String getRsltYrmon() {
		return this.rsltYrmon;
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
	 * @return subOfcCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
	}
	
	/**
	 * Column Info
	 * @return genExpnTrnsAmt
	 */
	public String getGenExpnTrnsAmt() {
		return this.genExpnTrnsAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt
	 */
	public String getSlpPerfAmt() {
		return this.slpPerfAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnInitAmt
	 */
	public String getGenExpnInitAmt() {
		return this.genExpnInitAmt;
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
	 * @return subGenExpnCd
	 */
	public String getSubGenExpnCd() {
		return this.subGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return genExpnOvrRtoRsn
	 */
	public String getGenExpnOvrRtoRsn() {
		return this.genExpnOvrRtoRsn;
	}
	
	/**
	 * Column Info
	 * @return ofcCoDivCd
	 */
	public String getOfcCoDivCd() {
		return this.ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @return genExpnAddAmt
	 */
	public String getGenExpnAddAmt() {
		return this.genExpnAddAmt;
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
	 * @param rsltYrmon
	 */
	public void setRsltYrmon(String rsltYrmon) {
		this.rsltYrmon = rsltYrmon;
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
	 * @param subOfcCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.subOfcCd = subOfcCd;
	}
	
	/**
	 * Column Info
	 * @param genExpnTrnsAmt
	 */
	public void setGenExpnTrnsAmt(String genExpnTrnsAmt) {
		this.genExpnTrnsAmt = genExpnTrnsAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt
	 */
	public void setSlpPerfAmt(String slpPerfAmt) {
		this.slpPerfAmt = slpPerfAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnInitAmt
	 */
	public void setGenExpnInitAmt(String genExpnInitAmt) {
		this.genExpnInitAmt = genExpnInitAmt;
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
	 * @param subGenExpnCd
	 */
	public void setSubGenExpnCd(String subGenExpnCd) {
		this.subGenExpnCd = subGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param genExpnOvrRtoRsn
	 */
	public void setGenExpnOvrRtoRsn(String genExpnOvrRtoRsn) {
		this.genExpnOvrRtoRsn = genExpnOvrRtoRsn;
	}
	
	/**
	 * Column Info
	 * @param ofcCoDivCd
	 */
	public void setOfcCoDivCd(String ofcCoDivCd) {
		this.ofcCoDivCd = ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @param genExpnAddAmt
	 */
	public void setGenExpnAddAmt(String genExpnAddAmt) {
		this.genExpnAddAmt = genExpnAddAmt;
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
		setRsltYrmon(JSPUtil.getParameter(request, "rslt_yrmon", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSubOfcCd(JSPUtil.getParameter(request, "sub_ofc_cd", ""));
		setGenExpnTrnsAmt(JSPUtil.getParameter(request, "gen_expn_trns_amt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setSlpPerfAmt(JSPUtil.getParameter(request, "slp_perf_amt", ""));
		setGenExpnInitAmt(JSPUtil.getParameter(request, "gen_expn_init_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSubGenExpnCd(JSPUtil.getParameter(request, "sub_gen_expn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGenExpnOvrRtoRsn(JSPUtil.getParameter(request, "gen_expn_ovr_rto_rsn", ""));
		setOfcCoDivCd(JSPUtil.getParameter(request, "ofc_co_div_cd", ""));
		setGenExpnAddAmt(JSPUtil.getParameter(request, "gen_expn_add_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemRsltSmryVO[]
	 */
	public GemRsltSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemRsltSmryVO[]
	 */
	public GemRsltSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemRsltSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rsltYrmon = (JSPUtil.getParameter(request, prefix	+ "rslt_yrmon", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] genExpnTrnsAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_trns_amt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] slpPerfAmt = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt", length));
			String[] genExpnInitAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_init_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "sub_gen_expn_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] genExpnOvrRtoRsn = (JSPUtil.getParameter(request, prefix	+ "gen_expn_ovr_rto_rsn", length));
			String[] ofcCoDivCd = (JSPUtil.getParameter(request, prefix	+ "ofc_co_div_cd", length));
			String[] genExpnAddAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_add_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemRsltSmryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rsltYrmon[i] != null)
					model.setRsltYrmon(rsltYrmon[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (genExpnTrnsAmt[i] != null)
					model.setGenExpnTrnsAmt(genExpnTrnsAmt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (slpPerfAmt[i] != null)
					model.setSlpPerfAmt(slpPerfAmt[i]);
				if (genExpnInitAmt[i] != null)
					model.setGenExpnInitAmt(genExpnInitAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subGenExpnCd[i] != null)
					model.setSubGenExpnCd(subGenExpnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (genExpnOvrRtoRsn[i] != null)
					model.setGenExpnOvrRtoRsn(genExpnOvrRtoRsn[i]);
				if (ofcCoDivCd[i] != null)
					model.setOfcCoDivCd(ofcCoDivCd[i]);
				if (genExpnAddAmt[i] != null)
					model.setGenExpnAddAmt(genExpnAddAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemRsltSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemRsltSmryVO[]
	 */
	public GemRsltSmryVO[] getGemRsltSmryVOs(){
		GemRsltSmryVO[] vos = (GemRsltSmryVO[])models.toArray(new GemRsltSmryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltYrmon = this.rsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnTrnsAmt = this.genExpnTrnsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt = this.slpPerfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnInitAmt = this.genExpnInitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subGenExpnCd = this.subGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnOvrRtoRsn = this.genExpnOvrRtoRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCoDivCd = this.ofcCoDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAddAmt = this.genExpnAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
