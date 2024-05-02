/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AdjustConditionVO.java
*@FileTitle : AdjustConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.10.12 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdjustConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdjustConditionVO> models = new ArrayList<AdjustConditionVO>();
	
	/* Column Info */
	private String diffOnlyYn = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String joMnuNm = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String toAcctYrmon = null;
	/* Column Info */
	private String fmAcctYrmon = null;
	/* Column Info */
	private String stlAdjIrrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AdjustConditionVO() {}

	public AdjustConditionVO(String ibflag, String pagerows, String fmAcctYrmon, String toAcctYrmon, String acctYrmon, String joCrrCd, String reDivrCd, String trdCd, String rlaneCd, String diffOnlyYn, String joStlItmCd, String joMnuNm, String loclCurrCd, String stlAdjIrrFlg) {
		this.diffOnlyYn = diffOnlyYn;
		this.loclCurrCd = loclCurrCd;
		this.joCrrCd = joCrrCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.acctYrmon = acctYrmon;
		this.joMnuNm = joMnuNm;
		this.reDivrCd = reDivrCd;
		this.toAcctYrmon = toAcctYrmon;
		this.fmAcctYrmon = fmAcctYrmon;
		this.stlAdjIrrFlg = stlAdjIrrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("diff_only_yn", getDiffOnlyYn());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("jo_mnu_nm", getJoMnuNm());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("to_acct_yrmon", getToAcctYrmon());
		this.hashColumns.put("fm_acct_yrmon", getFmAcctYrmon());
		this.hashColumns.put("stl_adj_irr_flg", getStlAdjIrrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("diff_only_yn", "diffOnlyYn");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("jo_mnu_nm", "joMnuNm");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("to_acct_yrmon", "toAcctYrmon");
		this.hashFields.put("fm_acct_yrmon", "fmAcctYrmon");
		this.hashFields.put("stl_adj_irr_flg", "stlAdjIrrFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return diffOnlyYn
	 */
	public String getDiffOnlyYn() {
		return this.diffOnlyYn;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return joMnuNm
	 */
	public String getJoMnuNm() {
		return this.joMnuNm;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return toAcctYrmon
	 */
	public String getToAcctYrmon() {
		return this.toAcctYrmon;
	}
	
	/**
	 * Column Info
	 * @return fmAcctYrmon
	 */
	public String getFmAcctYrmon() {
		return this.fmAcctYrmon;
	}
	
	/**
	 * Column Info
	 * @return stlAdjIrrFlg
	 */
	public String getStlAdjIrrFlg() {
		return this.stlAdjIrrFlg;
	}
	

	/**
	 * Column Info
	 * @param diffOnlyYn
	 */
	public void setDiffOnlyYn(String diffOnlyYn) {
		this.diffOnlyYn = diffOnlyYn;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param joMnuNm
	 */
	public void setJoMnuNm(String joMnuNm) {
		this.joMnuNm = joMnuNm;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param toAcctYrmon
	 */
	public void setToAcctYrmon(String toAcctYrmon) {
		this.toAcctYrmon = toAcctYrmon;
	}
	
	/**
	 * Column Info
	 * @param fmAcctYrmon
	 */
	public void setFmAcctYrmon(String fmAcctYrmon) {
		this.fmAcctYrmon = fmAcctYrmon;
	}
	
	/**
	 * Column Info
	 * @param stlAdjIrrFlg
	 */
	public void setStlAdjIrrFlg(String stlAdjIrrFlg) {
		this.stlAdjIrrFlg = stlAdjIrrFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDiffOnlyYn(JSPUtil.getParameter(request, "diff_only_yn", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setJoMnuNm(JSPUtil.getParameter(request, "jo_mnu_nm", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setToAcctYrmon(JSPUtil.getParameter(request, "to_acct_yrmon", ""));
		setFmAcctYrmon(JSPUtil.getParameter(request, "fm_acct_yrmon", ""));
		setStlAdjIrrFlg(JSPUtil.getParameter(request, "stl_adj_irr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdjustConditionVO[]
	 */
	public AdjustConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdjustConditionVO[]
	 */
	public AdjustConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdjustConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] diffOnlyYn = (JSPUtil.getParameter(request, prefix	+ "diff_only_yn", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] joMnuNm = (JSPUtil.getParameter(request, prefix	+ "jo_mnu_nm", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] toAcctYrmon = (JSPUtil.getParameter(request, prefix	+ "to_acct_yrmon", length));
			String[] fmAcctYrmon = (JSPUtil.getParameter(request, prefix	+ "fm_acct_yrmon", length));
			String[] stlAdjIrrFlg = (JSPUtil.getParameter(request, prefix	+ "stl_adj_irr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdjustConditionVO();
				if (diffOnlyYn[i] != null)
					model.setDiffOnlyYn(diffOnlyYn[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (joMnuNm[i] != null)
					model.setJoMnuNm(joMnuNm[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (toAcctYrmon[i] != null)
					model.setToAcctYrmon(toAcctYrmon[i]);
				if (fmAcctYrmon[i] != null)
					model.setFmAcctYrmon(fmAcctYrmon[i]);
				if (stlAdjIrrFlg[i] != null)
					model.setStlAdjIrrFlg(stlAdjIrrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdjustConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdjustConditionVO[]
	 */
	public AdjustConditionVO[] getAdjustConditionVOs(){
		AdjustConditionVO[] vos = (AdjustConditionVO[])models.toArray(new AdjustConditionVO[models.size()]);
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
		this.diffOnlyYn = this.diffOnlyYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joMnuNm = this.joMnuNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAcctYrmon = this.toAcctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAcctYrmon = this.fmAcctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAdjIrrFlg = this.stlAdjIrrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
