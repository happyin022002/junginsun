/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCntrRepoExecutionPlanEstablishVO.java
*@FileTitle : SearchCntrRepoExecutionPlanEstablishVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.19 정은호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCntrRepoExecutionPlanEstablishVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCntrRepoExecutionPlanEstablishVO> models = new ArrayList<SearchCntrRepoExecutionPlanEstablishVO>();
	
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String vslBsaSpc = null;
	/* Column Info */
	private String vslFullSpc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslRsdlSpc = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String scnrIdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcastYrwk = null;
	/* Column Info */
	private String ttlRsdlSpc = null;
	/* Column Info */
	private String vslSpc = null;
	/* Column Info */
	private String vslDeadSpc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCntrRepoExecutionPlanEstablishVO() {}

	public SearchCntrRepoExecutionPlanEstablishVO(String ibflag, String pagerows, String fcastYrwk, String eccCd, String vslLaneCd, String vvd, String vslBsaSpc, String vslFullSpc, String vslDeadSpc, String vslRsdlSpc, String vslSpc, String ttlRsdlSpc, String scnrIdCd) {
		this.eccCd = eccCd;
		this.vslBsaSpc = vslBsaSpc;
		this.vslFullSpc = vslFullSpc;
		this.pagerows = pagerows;
		this.vslRsdlSpc = vslRsdlSpc;
		this.vslLaneCd = vslLaneCd;
		this.vvd = vvd;
		this.scnrIdCd = scnrIdCd;
		this.ibflag = ibflag;
		this.fcastYrwk = fcastYrwk;
		this.ttlRsdlSpc = ttlRsdlSpc;
		this.vslSpc = vslSpc;
		this.vslDeadSpc = vslDeadSpc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("vsl_bsa_spc", getVslBsaSpc());
		this.hashColumns.put("vsl_full_spc", getVslFullSpc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_rsdl_spc", getVslRsdlSpc());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("scnr_id_cd", getScnrIdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		this.hashColumns.put("ttl_rsdl_spc", getTtlRsdlSpc());
		this.hashColumns.put("vsl_spc", getVslSpc());
		this.hashColumns.put("vsl_dead_spc", getVslDeadSpc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("vsl_bsa_spc", "vslBsaSpc");
		this.hashFields.put("vsl_full_spc", "vslFullSpc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_rsdl_spc", "vslRsdlSpc");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("scnr_id_cd", "scnrIdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_yrwk", "fcastYrwk");
		this.hashFields.put("ttl_rsdl_spc", "ttlRsdlSpc");
		this.hashFields.put("vsl_spc", "vslSpc");
		this.hashFields.put("vsl_dead_spc", "vslDeadSpc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return vslBsaSpc
	 */
	public String getVslBsaSpc() {
		return this.vslBsaSpc;
	}
	
	/**
	 * Column Info
	 * @return vslFullSpc
	 */
	public String getVslFullSpc() {
		return this.vslFullSpc;
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
	 * @return vslRsdlSpc
	 */
	public String getVslRsdlSpc() {
		return this.vslRsdlSpc;
	}
	
	/**
	 * Column Info
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
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
	 * @return scnrIdCd
	 */
	public String getScnrIdCd() {
		return this.scnrIdCd;
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
	 * @return fcastYrwk
	 */
	public String getFcastYrwk() {
		return this.fcastYrwk;
	}
	
	/**
	 * Column Info
	 * @return ttlRsdlSpc
	 */
	public String getTtlRsdlSpc() {
		return this.ttlRsdlSpc;
	}
	
	/**
	 * Column Info
	 * @return vslSpc
	 */
	public String getVslSpc() {
		return this.vslSpc;
	}
	
	/**
	 * Column Info
	 * @return vslDeadSpc
	 */
	public String getVslDeadSpc() {
		return this.vslDeadSpc;
	}
	

	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param vslBsaSpc
	 */
	public void setVslBsaSpc(String vslBsaSpc) {
		this.vslBsaSpc = vslBsaSpc;
	}
	
	/**
	 * Column Info
	 * @param vslFullSpc
	 */
	public void setVslFullSpc(String vslFullSpc) {
		this.vslFullSpc = vslFullSpc;
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
	 * @param vslRsdlSpc
	 */
	public void setVslRsdlSpc(String vslRsdlSpc) {
		this.vslRsdlSpc = vslRsdlSpc;
	}
	
	/**
	 * Column Info
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
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
	 * @param scnrIdCd
	 */
	public void setScnrIdCd(String scnrIdCd) {
		this.scnrIdCd = scnrIdCd;
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
	 * @param fcastYrwk
	 */
	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
	}
	
	/**
	 * Column Info
	 * @param ttlRsdlSpc
	 */
	public void setTtlRsdlSpc(String ttlRsdlSpc) {
		this.ttlRsdlSpc = ttlRsdlSpc;
	}
	
	/**
	 * Column Info
	 * @param vslSpc
	 */
	public void setVslSpc(String vslSpc) {
		this.vslSpc = vslSpc;
	}
	
	/**
	 * Column Info
	 * @param vslDeadSpc
	 */
	public void setVslDeadSpc(String vslDeadSpc) {
		this.vslDeadSpc = vslDeadSpc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setVslBsaSpc(JSPUtil.getParameter(request, "vsl_bsa_spc", ""));
		setVslFullSpc(JSPUtil.getParameter(request, "vsl_full_spc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslRsdlSpc(JSPUtil.getParameter(request, "vsl_rsdl_spc", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setScnrIdCd(JSPUtil.getParameter(request, "scnr_id_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFcastYrwk(JSPUtil.getParameter(request, "fcast_yrwk", ""));
		setTtlRsdlSpc(JSPUtil.getParameter(request, "ttl_rsdl_spc", ""));
		setVslSpc(JSPUtil.getParameter(request, "vsl_spc", ""));
		setVslDeadSpc(JSPUtil.getParameter(request, "vsl_dead_spc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCntrRepoExecutionPlanEstablishVO[]
	 */
	public SearchCntrRepoExecutionPlanEstablishVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCntrRepoExecutionPlanEstablishVO[]
	 */
	public SearchCntrRepoExecutionPlanEstablishVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCntrRepoExecutionPlanEstablishVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] vslBsaSpc = (JSPUtil.getParameter(request, prefix	+ "vsl_bsa_spc", length));
			String[] vslFullSpc = (JSPUtil.getParameter(request, prefix	+ "vsl_full_spc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslRsdlSpc = (JSPUtil.getParameter(request, prefix	+ "vsl_rsdl_spc", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] scnrIdCd = (JSPUtil.getParameter(request, prefix	+ "scnr_id_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			String[] ttlRsdlSpc = (JSPUtil.getParameter(request, prefix	+ "ttl_rsdl_spc", length));
			String[] vslSpc = (JSPUtil.getParameter(request, prefix	+ "vsl_spc", length));
			String[] vslDeadSpc = (JSPUtil.getParameter(request, prefix	+ "vsl_dead_spc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCntrRepoExecutionPlanEstablishVO();
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (vslBsaSpc[i] != null)
					model.setVslBsaSpc(vslBsaSpc[i]);
				if (vslFullSpc[i] != null)
					model.setVslFullSpc(vslFullSpc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslRsdlSpc[i] != null)
					model.setVslRsdlSpc(vslRsdlSpc[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (scnrIdCd[i] != null)
					model.setScnrIdCd(scnrIdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcastYrwk[i] != null)
					model.setFcastYrwk(fcastYrwk[i]);
				if (ttlRsdlSpc[i] != null)
					model.setTtlRsdlSpc(ttlRsdlSpc[i]);
				if (vslSpc[i] != null)
					model.setVslSpc(vslSpc[i]);
				if (vslDeadSpc[i] != null)
					model.setVslDeadSpc(vslDeadSpc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCntrRepoExecutionPlanEstablishVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCntrRepoExecutionPlanEstablishVO[]
	 */
	public SearchCntrRepoExecutionPlanEstablishVO[] getSearchCntrRepoExecutionPlanEstablishVOs(){
		SearchCntrRepoExecutionPlanEstablishVO[] vos = (SearchCntrRepoExecutionPlanEstablishVO[])models.toArray(new SearchCntrRepoExecutionPlanEstablishVO[models.size()]);
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
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBsaSpc = this.vslBsaSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullSpc = this.vslFullSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRsdlSpc = this.vslRsdlSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrIdCd = this.scnrIdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk = this.fcastYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRsdlSpc = this.ttlRsdlSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSpc = this.vslSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeadSpc = this.vslDeadSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
