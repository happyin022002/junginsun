/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpcSlotSwapByVvdListVO.java
*@FileTitle : SearchSpcSlotSwapByVvdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.09 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpcSlotSwapByVvdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpcSlotSwapByVvdListVO> models = new ArrayList<SearchSpcSlotSwapByVvdListVO>();
	
	/* Column Info */
	private String sltSwapVvdCd = null;
	/* Column Info */
	private String sltSwapTeuCapa = null;
	/* Column Info */
	private String sltSwapWgt = null;
	/* Column Info */
	private String purWgt = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String slsWgt = null;
	/* Column Info */
	private String purTeuCapa = null;
	/* Column Info */
	private String sltSwapRlaneCd = null;
	/* Column Info */
	private String sltPrcCapa = null;
	/* Column Info */
	private String coBfrSubCapa = null;
	/* Column Info */
	private String slsTeuCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpcSlotSwapByVvdListVO() {}

	public SearchSpcSlotSwapByVvdListVO(String ibflag, String pagerows,  String crrCd, String slsTeuCapa, String slsWgt, String purTeuCapa, String purWgt, String sltSwapRlaneCd, String sltSwapVvdCd, String sltSwapTeuCapa, String sltSwapWgt, String sltPrcCapa, String coBfrSubCapa) {
		this.sltSwapVvdCd = sltSwapVvdCd;
		this.sltSwapTeuCapa = sltSwapTeuCapa;
		this.sltSwapWgt = sltSwapWgt;
		this.purWgt = purWgt;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.slsWgt = slsWgt;
		this.purTeuCapa = purTeuCapa;
		this.sltSwapRlaneCd = sltSwapRlaneCd;
		this.sltPrcCapa = sltPrcCapa;
		this.coBfrSubCapa = coBfrSubCapa;
		this.slsTeuCapa = slsTeuCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("slt_swap_vvd_cd", getSltSwapVvdCd());
		this.hashColumns.put("slt_swap_teu_capa", getSltSwapTeuCapa());
		this.hashColumns.put("slt_swap_wgt", getSltSwapWgt());
		this.hashColumns.put("pur_wgt", getPurWgt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sls_wgt", getSlsWgt());
		this.hashColumns.put("pur_teu_capa", getPurTeuCapa());
		this.hashColumns.put("slt_swap_rlane_cd", getSltSwapRlaneCd());
		this.hashColumns.put("slt_prc_capa", getSltPrcCapa());
		this.hashColumns.put("co_bfr_sub_capa", getCoBfrSubCapa());
		this.hashColumns.put("sls_teu_capa", getSlsTeuCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("slt_swap_vvd_cd", "sltSwapVvdCd");
		this.hashFields.put("slt_swap_teu_capa", "sltSwapTeuCapa");
		this.hashFields.put("slt_swap_wgt", "sltSwapWgt");
		this.hashFields.put("pur_wgt", "purWgt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sls_wgt", "slsWgt");
		this.hashFields.put("pur_teu_capa", "purTeuCapa");
		this.hashFields.put("slt_swap_rlane_cd", "sltSwapRlaneCd");
		this.hashFields.put("slt_prc_capa", "sltPrcCapa");
		this.hashFields.put("co_bfr_sub_capa", "coBfrSubCapa");
		this.hashFields.put("sls_teu_capa", "slsTeuCapa");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sltSwapVvdCd
	 */
	public String getSltSwapVvdCd() {
		return this.sltSwapVvdCd;
	}
	
	/**
	 * Column Info
	 * @return sltSwapTeuCapa
	 */
	public String getSltSwapTeuCapa() {
		return this.sltSwapTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return sltSwapWgt
	 */
	public String getSltSwapWgt() {
		return this.sltSwapWgt;
	}
	
	/**
	 * Column Info
	 * @return purWgt
	 */
	public String getPurWgt() {
		return this.purWgt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return slsWgt
	 */
	public String getSlsWgt() {
		return this.slsWgt;
	}
	
	/**
	 * Column Info
	 * @return purTeuCapa
	 */
	public String getPurTeuCapa() {
		return this.purTeuCapa;
	}
	
	/**
	 * Column Info
	 * @return sltSwapRlaneCd
	 */
	public String getSltSwapRlaneCd() {
		return this.sltSwapRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return sltPrcCapa
	 */
	public String getSltPrcCapa() {
		return this.sltPrcCapa;
	}
	
	/**
	 * Column Info
	 * @return coBfrSubCapa
	 */
	public String getCoBfrSubCapa() {
		return this.coBfrSubCapa;
	}
	
	/**
	 * Column Info
	 * @return slsTeuCapa
	 */
	public String getSlsTeuCapa() {
		return this.slsTeuCapa;
	}
	

	/**
	 * Column Info
	 * @param sltSwapVvdCd
	 */
	public void setSltSwapVvdCd(String sltSwapVvdCd) {
		this.sltSwapVvdCd = sltSwapVvdCd;
	}
	
	/**
	 * Column Info
	 * @param sltSwapTeuCapa
	 */
	public void setSltSwapTeuCapa(String sltSwapTeuCapa) {
		this.sltSwapTeuCapa = sltSwapTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param sltSwapWgt
	 */
	public void setSltSwapWgt(String sltSwapWgt) {
		this.sltSwapWgt = sltSwapWgt;
	}
	
	/**
	 * Column Info
	 * @param purWgt
	 */
	public void setPurWgt(String purWgt) {
		this.purWgt = purWgt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param slsWgt
	 */
	public void setSlsWgt(String slsWgt) {
		this.slsWgt = slsWgt;
	}
	
	/**
	 * Column Info
	 * @param purTeuCapa
	 */
	public void setPurTeuCapa(String purTeuCapa) {
		this.purTeuCapa = purTeuCapa;
	}
	
	/**
	 * Column Info
	 * @param sltSwapRlaneCd
	 */
	public void setSltSwapRlaneCd(String sltSwapRlaneCd) {
		this.sltSwapRlaneCd = sltSwapRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param sltPrcCapa
	 */
	public void setSltPrcCapa(String sltPrcCapa) {
		this.sltPrcCapa = sltPrcCapa;
	}
	
	/**
	 * Column Info
	 * @param coBfrSubCapa
	 */
	public void setCoBfrSubCapa(String coBfrSubCapa) {
		this.coBfrSubCapa = coBfrSubCapa;
	}
	
	/**
	 * Column Info
	 * @param slsTeuCapa
	 */
	public void setSlsTeuCapa(String slsTeuCapa) {
		this.slsTeuCapa = slsTeuCapa;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSltSwapVvdCd(JSPUtil.getParameter(request, "slt_swap_vvd_cd", ""));
		setSltSwapTeuCapa(JSPUtil.getParameter(request, "slt_swap_teu_capa", ""));
		setSltSwapWgt(JSPUtil.getParameter(request, "slt_swap_wgt", ""));
		setPurWgt(JSPUtil.getParameter(request, "pur_wgt", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlsWgt(JSPUtil.getParameter(request, "sls_wgt", ""));
		setPurTeuCapa(JSPUtil.getParameter(request, "pur_teu_capa", ""));
		setSltSwapRlaneCd(JSPUtil.getParameter(request, "slt_swap_rlane_cd", ""));
		setSltPrcCapa(JSPUtil.getParameter(request, "slt_prc_capa", ""));
		setCoBfrSubCapa(JSPUtil.getParameter(request, "co_bfr_sub_capa", ""));
		setSlsTeuCapa(JSPUtil.getParameter(request, "sls_teu_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpcSlotSwapByVvdListVO[]
	 */
	public SearchSpcSlotSwapByVvdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpcSlotSwapByVvdListVO[]
	 */
	public SearchSpcSlotSwapByVvdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpcSlotSwapByVvdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sltSwapVvdCd = (JSPUtil.getParameter(request, prefix	+ "slt_swap_vvd_cd", length));
			String[] sltSwapTeuCapa = (JSPUtil.getParameter(request, prefix	+ "slt_swap_teu_capa", length));
			String[] sltSwapWgt = (JSPUtil.getParameter(request, prefix	+ "slt_swap_wgt", length));
			String[] purWgt = (JSPUtil.getParameter(request, prefix	+ "pur_wgt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slsWgt = (JSPUtil.getParameter(request, prefix	+ "sls_wgt", length));
			String[] purTeuCapa = (JSPUtil.getParameter(request, prefix	+ "pur_teu_capa", length));
			String[] sltSwapRlaneCd = (JSPUtil.getParameter(request, prefix	+ "slt_swap_rlane_cd", length));
			String[] sltPrcCapa = (JSPUtil.getParameter(request, prefix	+ "slt_prc_capa", length));
			String[] coBfrSubCapa = (JSPUtil.getParameter(request, prefix	+ "co_bfr_sub_capa", length));
			String[] slsTeuCapa = (JSPUtil.getParameter(request, prefix	+ "sls_teu_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpcSlotSwapByVvdListVO();
				if (sltSwapVvdCd[i] != null)
					model.setSltSwapVvdCd(sltSwapVvdCd[i]);
				if (sltSwapTeuCapa[i] != null)
					model.setSltSwapTeuCapa(sltSwapTeuCapa[i]);
				if (sltSwapWgt[i] != null)
					model.setSltSwapWgt(sltSwapWgt[i]);
				if (purWgt[i] != null)
					model.setPurWgt(purWgt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slsWgt[i] != null)
					model.setSlsWgt(slsWgt[i]);
				if (purTeuCapa[i] != null)
					model.setPurTeuCapa(purTeuCapa[i]);
				if (sltSwapRlaneCd[i] != null)
					model.setSltSwapRlaneCd(sltSwapRlaneCd[i]);
				if (sltPrcCapa[i] != null)
					model.setSltPrcCapa(sltPrcCapa[i]);
				if (coBfrSubCapa[i] != null)
					model.setCoBfrSubCapa(coBfrSubCapa[i]);
				if (slsTeuCapa[i] != null)
					model.setSlsTeuCapa(slsTeuCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpcSlotSwapByVvdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpcSlotSwapByVvdListVO[]
	 */
	public SearchSpcSlotSwapByVvdListVO[] getSearchSpcSlotSwapByVvdListVOs(){
		SearchSpcSlotSwapByVvdListVO[] vos = (SearchSpcSlotSwapByVvdListVO[])models.toArray(new SearchSpcSlotSwapByVvdListVO[models.size()]);
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
		this.sltSwapVvdCd = this.sltSwapVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltSwapTeuCapa = this.sltSwapTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltSwapWgt = this.sltSwapWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purWgt = this.purWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsWgt = this.slsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purTeuCapa = this.purTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltSwapRlaneCd = this.sltSwapRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltPrcCapa = this.sltPrcCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coBfrSubCapa = this.coBfrSubCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsTeuCapa = this.slsTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
