/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBDRPolVO.java
*@FileTitle : SearchBDRPolVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.10 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBDRPolVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBDRPolVO> models = new ArrayList<SearchBDRPolVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cbSlanCd = null;
	/* Column Info */
	private String cbSkdDirCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String optSelBdr = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String trnkBdrDys = null;
	/* Column Info */
	private String cbPolCd = null;
	/* Column Info */
	private String optSelTime = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fdrBdrDys = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBDRPolVO() {}

	public SearchBDRPolVO(String ibflag, String pagerows, String slanCd, String skdDirCd, String polCd, String podCd, String trnkBdrDys, String fdrBdrDys, String creUsrId, String creDt, String updUsrId, String updDt, String ofcCd, String cbSlanCd, String cbSkdDirCd, String cbPolCd, String optSelBdr, String optSelTime, String vvd) {
		this.updDt = updDt;
		this.cbSlanCd = cbSlanCd;
		this.cbSkdDirCd = cbSkdDirCd;
		this.creDt = creDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.optSelBdr = optSelBdr;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.trnkBdrDys = trnkBdrDys;
		this.cbPolCd = cbPolCd;
		this.optSelTime = optSelTime;
		this.updUsrId = updUsrId;
		this.fdrBdrDys = fdrBdrDys;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cb_slan_cd", getCbSlanCd());
		this.hashColumns.put("cb_skd_dir_cd", getCbSkdDirCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("opt_sel_bdr", getOptSelBdr());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("trnk_bdr_dys", getTrnkBdrDys());
		this.hashColumns.put("cb_pol_cd", getCbPolCd());
		this.hashColumns.put("opt_sel_time", getOptSelTime());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fdr_bdr_dys", getFdrBdrDys());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cb_slan_cd", "cbSlanCd");
		this.hashFields.put("cb_skd_dir_cd", "cbSkdDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("opt_sel_bdr", "optSelBdr");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("trnk_bdr_dys", "trnkBdrDys");
		this.hashFields.put("cb_pol_cd", "cbPolCd");
		this.hashFields.put("opt_sel_time", "optSelTime");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fdr_bdr_dys", "fdrBdrDys");
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
	 * @return cbSlanCd
	 */
	public String getCbSlanCd() {
		return this.cbSlanCd;
	}
	
	/**
	 * Column Info
	 * @return cbSkdDirCd
	 */
	public String getCbSkdDirCd() {
		return this.cbSkdDirCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return optSelBdr
	 */
	public String getOptSelBdr() {
		return this.optSelBdr;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return trnkBdrDys
	 */
	public String getTrnkBdrDys() {
		return this.trnkBdrDys;
	}
	
	/**
	 * Column Info
	 * @return cbPolCd
	 */
	public String getCbPolCd() {
		return this.cbPolCd;
	}
	
	/**
	 * Column Info
	 * @return optSelTime
	 */
	public String getOptSelTime() {
		return this.optSelTime;
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
	 * @return fdrBdrDys
	 */
	public String getFdrBdrDys() {
		return this.fdrBdrDys;
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
	 * @param cbSlanCd
	 */
	public void setCbSlanCd(String cbSlanCd) {
		this.cbSlanCd = cbSlanCd;
	}
	
	/**
	 * Column Info
	 * @param cbSkdDirCd
	 */
	public void setCbSkdDirCd(String cbSkdDirCd) {
		this.cbSkdDirCd = cbSkdDirCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param optSelBdr
	 */
	public void setOptSelBdr(String optSelBdr) {
		this.optSelBdr = optSelBdr;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param trnkBdrDys
	 */
	public void setTrnkBdrDys(String trnkBdrDys) {
		this.trnkBdrDys = trnkBdrDys;
	}
	
	/**
	 * Column Info
	 * @param cbPolCd
	 */
	public void setCbPolCd(String cbPolCd) {
		this.cbPolCd = cbPolCd;
	}
	
	/**
	 * Column Info
	 * @param optSelTime
	 */
	public void setOptSelTime(String optSelTime) {
		this.optSelTime = optSelTime;
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
	 * @param fdrBdrDys
	 */
	public void setFdrBdrDys(String fdrBdrDys) {
		this.fdrBdrDys = fdrBdrDys;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCbSlanCd(JSPUtil.getParameter(request, "cb_slan_cd", ""));
		setCbSkdDirCd(JSPUtil.getParameter(request, "cb_skd_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOptSelBdr(JSPUtil.getParameter(request, "opt_sel_bdr", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setTrnkBdrDys(JSPUtil.getParameter(request, "trnk_bdr_dys", ""));
		setCbPolCd(JSPUtil.getParameter(request, "cb_pol_cd", ""));
		setOptSelTime(JSPUtil.getParameter(request, "opt_sel_time", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setFdrBdrDys(JSPUtil.getParameter(request, "fdr_bdr_dys", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBDRPolVO[]
	 */
	public SearchBDRPolVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBDRPolVO[]
	 */
	public SearchBDRPolVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBDRPolVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cbSlanCd = (JSPUtil.getParameter(request, prefix	+ "cb_slan_cd", length));
			String[] cbSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "cb_skd_dir_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] optSelBdr = (JSPUtil.getParameter(request, prefix	+ "opt_sel_bdr", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] trnkBdrDys = (JSPUtil.getParameter(request, prefix	+ "trnk_bdr_dys", length));
			String[] cbPolCd = (JSPUtil.getParameter(request, prefix	+ "cb_pol_cd", length));
			String[] optSelTime = (JSPUtil.getParameter(request, prefix	+ "opt_sel_time", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fdrBdrDys = (JSPUtil.getParameter(request, prefix	+ "fdr_bdr_dys", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBDRPolVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cbSlanCd[i] != null)
					model.setCbSlanCd(cbSlanCd[i]);
				if (cbSkdDirCd[i] != null)
					model.setCbSkdDirCd(cbSkdDirCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (optSelBdr[i] != null)
					model.setOptSelBdr(optSelBdr[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (trnkBdrDys[i] != null)
					model.setTrnkBdrDys(trnkBdrDys[i]);
				if (cbPolCd[i] != null)
					model.setCbPolCd(cbPolCd[i]);
				if (optSelTime[i] != null)
					model.setOptSelTime(optSelTime[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fdrBdrDys[i] != null)
					model.setFdrBdrDys(fdrBdrDys[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBDRPolVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBDRPolVO[]
	 */
	public SearchBDRPolVO[] getSearchBDRPolVOs(){
		SearchBDRPolVO[] vos = (SearchBDRPolVO[])models.toArray(new SearchBDRPolVO[models.size()]);
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
		this.cbSlanCd = this.cbSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbSkdDirCd = this.cbSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optSelBdr = this.optSelBdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkBdrDys = this.trnkBdrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbPolCd = this.cbPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optSelTime = this.optSelTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrBdrDys = this.fdrBdrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
