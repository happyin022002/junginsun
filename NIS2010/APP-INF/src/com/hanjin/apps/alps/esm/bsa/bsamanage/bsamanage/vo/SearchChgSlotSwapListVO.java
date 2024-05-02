/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchChgSlotSwapListVO.java
*@FileTitle : SearchChgSlotSwapListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.19 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchChgSlotSwapListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchChgSlotSwapListVO> models = new ArrayList<SearchChgSlotSwapListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crrSwapCapa = null;
	/* Column Info */
	private String bsaFmCrrCd = null;
	/* Column Info */
	private String bsaToCrrCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchChgSlotSwapListVO() {}

	public SearchChgSlotSwapListVO(String ibflag, String pagerows, String bsaFmCrrCd, String crrSwapCapa, String bsaToCrrCd) {
		this.ibflag = ibflag;
		this.crrSwapCapa = crrSwapCapa;
		this.bsaFmCrrCd = bsaFmCrrCd;
		this.bsaToCrrCd = bsaToCrrCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crr_swap_capa", getCrrSwapCapa());
		this.hashColumns.put("bsa_fm_crr_cd", getBsaFmCrrCd());
		this.hashColumns.put("bsa_to_crr_cd", getBsaToCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crr_swap_capa", "crrSwapCapa");
		this.hashFields.put("bsa_fm_crr_cd", "bsaFmCrrCd");
		this.hashFields.put("bsa_to_crr_cd", "bsaToCrrCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return crrSwapCapa
	 */
	public String getCrrSwapCapa() {
		return this.crrSwapCapa;
	}
	
	/**
	 * Column Info
	 * @return bsaFmCrrCd
	 */
	public String getBsaFmCrrCd() {
		return this.bsaFmCrrCd;
	}
	
	/**
	 * Column Info
	 * @return bsaToCrrCd
	 */
	public String getBsaToCrrCd() {
		return this.bsaToCrrCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param crrSwapCapa
	 */
	public void setCrrSwapCapa(String crrSwapCapa) {
		this.crrSwapCapa = crrSwapCapa;
	}
	
	/**
	 * Column Info
	 * @param bsaFmCrrCd
	 */
	public void setBsaFmCrrCd(String bsaFmCrrCd) {
		this.bsaFmCrrCd = bsaFmCrrCd;
	}
	
	/**
	 * Column Info
	 * @param bsaToCrrCd
	 */
	public void setBsaToCrrCd(String bsaToCrrCd) {
		this.bsaToCrrCd = bsaToCrrCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrrSwapCapa(JSPUtil.getParameter(request, "crr_swap_capa", ""));
		setBsaFmCrrCd(JSPUtil.getParameter(request, "bsa_fm_crr_cd", ""));
		setBsaToCrrCd(JSPUtil.getParameter(request, "bsa_to_crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchChgSlotSwapListVO[]
	 */
	public SearchChgSlotSwapListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchChgSlotSwapListVO[]
	 */
	public SearchChgSlotSwapListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchChgSlotSwapListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crrSwapCapa = (JSPUtil.getParameter(request, prefix	+ "crr_swap_capa", length));
			String[] bsaFmCrrCd = (JSPUtil.getParameter(request, prefix	+ "bsa_fm_crr_cd", length));
			String[] bsaToCrrCd = (JSPUtil.getParameter(request, prefix	+ "bsa_to_crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchChgSlotSwapListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crrSwapCapa[i] != null)
					model.setCrrSwapCapa(crrSwapCapa[i]);
				if (bsaFmCrrCd[i] != null)
					model.setBsaFmCrrCd(bsaFmCrrCd[i]);
				if (bsaToCrrCd[i] != null)
					model.setBsaToCrrCd(bsaToCrrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchChgSlotSwapListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchChgSlotSwapListVO[]
	 */
	public SearchChgSlotSwapListVO[] getSearchChgSlotSwapListVOs(){
		SearchChgSlotSwapListVO[] vos = (SearchChgSlotSwapListVO[])models.toArray(new SearchChgSlotSwapListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrSwapCapa = this.crrSwapCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaFmCrrCd = this.bsaFmCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaToCrrCd = this.bsaToCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
