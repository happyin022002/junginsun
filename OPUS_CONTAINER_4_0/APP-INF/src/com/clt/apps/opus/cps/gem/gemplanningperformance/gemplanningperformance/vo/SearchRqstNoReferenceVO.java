/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchRqstNoReferenceVO.java
*@FileTitle : SearchRqstNoReferenceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.09.08 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRqstNoReferenceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRqstNoReferenceVO> models = new ArrayList<SearchRqstNoReferenceVO>();
	
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String authFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String prgId = null;
	/* Column Info */
	private String genExpnRqstTpCd = null;
	/* Column Info */
	private String updUserId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRqstNoReferenceVO() {}

	public SearchRqstNoReferenceVO(String ibflag, String pagerows, String authFlg, String plnYrmon, String rqstOfcCd, String updUserId, String genExpnRqstTpCd, String prgId) {
		this.plnYrmon = plnYrmon;
		this.authFlg = authFlg;
		this.ibflag = ibflag;
		this.rqstOfcCd = rqstOfcCd;
		this.prgId = prgId;
		this.genExpnRqstTpCd = genExpnRqstTpCd;
		this.updUserId = updUserId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("prg_id", getPrgId());
		this.hashColumns.put("gen_expn_rqst_tp_cd", getGenExpnRqstTpCd());
		this.hashColumns.put("upd_user_id", getUpdUserId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("prg_id", "prgId");
		this.hashFields.put("gen_expn_rqst_tp_cd", "genExpnRqstTpCd");
		this.hashFields.put("upd_user_id", "updUserId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return plnYrmon
	 */
	public String getPlnYrmon() {
		return this.plnYrmon;
	}
	
	/**
	 * Column Info
	 * @return authFlg
	 */
	public String getAuthFlg() {
		return this.authFlg;
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
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return prgId
	 */
	public String getPrgId() {
		return this.prgId;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstTpCd
	 */
	public String getGenExpnRqstTpCd() {
		return this.genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @return updUserId
	 */
	public String getUpdUserId() {
		return this.updUserId;
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
	 * @param plnYrmon
	 */
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	
	/**
	 * Column Info
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
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
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param prgId
	 */
	public void setPrgId(String prgId) {
		this.prgId = prgId;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstTpCd
	 */
	public void setGenExpnRqstTpCd(String genExpnRqstTpCd) {
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUserId
	 */
	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
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
		setPlnYrmon(JSPUtil.getParameter(request, "pln_yrmon", ""));
		setAuthFlg(JSPUtil.getParameter(request, "auth_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setPrgId(JSPUtil.getParameter(request, "prg_id", ""));
		setGenExpnRqstTpCd(JSPUtil.getParameter(request, "gen_expn_rqst_tp_cd", ""));
		setUpdUserId(JSPUtil.getParameter(request, "upd_user_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRqstNoReferenceVO[]
	 */
	public SearchRqstNoReferenceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRqstNoReferenceVO[]
	 */
	public SearchRqstNoReferenceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRqstNoReferenceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon", length));
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] prgId = (JSPUtil.getParameter(request, prefix	+ "prg_id", length));
			String[] genExpnRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_tp_cd", length));
			String[] updUserId = (JSPUtil.getParameter(request, prefix	+ "upd_user_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRqstNoReferenceVO();
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (prgId[i] != null)
					model.setPrgId(prgId[i]);
				if (genExpnRqstTpCd[i] != null)
					model.setGenExpnRqstTpCd(genExpnRqstTpCd[i]);
				if (updUserId[i] != null)
					model.setUpdUserId(updUserId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRqstNoReferenceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRqstNoReferenceVO[]
	 */
	public SearchRqstNoReferenceVO[] getSearchRqstNoReferenceVOs(){
		SearchRqstNoReferenceVO[] vos = (SearchRqstNoReferenceVO[])models.toArray(new SearchRqstNoReferenceVO[models.size()]);
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
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prgId = this.prgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstTpCd = this.genExpnRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUserId = this.updUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
