/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActRsltRVO.java
*@FileTitle : ActRsltRVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.08 함대성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActRsltRVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActRsltRVO> models = new ArrayList<ActRsltRVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rvvd = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String acclAmt = null;
	/* Column Info */
	private String actAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Column Info */
	private String estmVvdTpCdCnt = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActRsltRVO() {}

	public ActRsltRVO(String ibflag, String pagerows, String item, String exeYrmon, String revYrmon, String rlaneCd, String rvvd, String estmAmt, String actAmt, String acclAmt, String estmVvdTpCd, String estmVvdTpCdCnt) {
		this.ibflag = ibflag;
		this.rvvd = rvvd;
		this.exeYrmon = exeYrmon;
		this.revYrmon = revYrmon;
		this.item = item;
		this.estmAmt = estmAmt;
		this.rlaneCd = rlaneCd;
		this.acclAmt = acclAmt;
		this.actAmt = actAmt;
		this.pagerows = pagerows;
		this.estmVvdTpCd = estmVvdTpCd;
		this.estmVvdTpCdCnt = estmVvdTpCdCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rvvd", getRvvd());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("accl_amt", getAcclAmt());
		this.hashColumns.put("act_amt", getActAmt());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("estm_vvd_tp_cd_cnt", getEstmVvdTpCdCnt());
		this.hashColumns.put("pagerows", getPagerows());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rvvd", "rvvd");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("item", "item");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("accl_amt", "acclAmt");
		this.hashFields.put("act_amt", "actAmt");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("estm_vvd_tp_cd_cnt", "estmVvdTpCdCnt");
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
	 * @return rvvd
	 */
	public String getRvvd() {
		return this.rvvd;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
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
	 * @return acclAmt
	 */
	public String getAcclAmt() {
		return this.acclAmt;
	}
	
	/**
	 * Column Info
	 * @return actAmt
	 */
	public String getActAmt() {
		return this.actAmt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * @return the revYrmon
	 */
	public String getRevYrmon() {
		return revYrmon;
	}

	/**
	 * @param revYrmon the revYrmon to set
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
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
	 * @param rvvd
	 */
	public void setRvvd(String rvvd) {
		this.rvvd = rvvd;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
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
	 * @param acclAmt
	 */
	public void setAcclAmt(String acclAmt) {
		this.acclAmt = acclAmt;
	}
	
	/**
	 * Column Info
	 * @param actAmt
	 */
	public void setActAmt(String actAmt) {
		this.actAmt = actAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @return the estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return estmVvdTpCd;
	}

	/**
	 * @param estmVvdTpCd the estmVvdTpCd to set
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
	}

	/**
	 * @return the estmVvdTpCdCnt
	 */
	public String getEstmVvdTpCdCnt() {
		return estmVvdTpCdCnt;
	}

	/**
	 * @param estmVvdTpCdCnt the estmVvdTpCdCnt to set
	 */
	public void setEstmVvdTpCdCnt(String estmVvdTpCdCnt) {
		this.estmVvdTpCdCnt = estmVvdTpCdCnt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRvvd(JSPUtil.getParameter(request, "rvvd", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setEstmAmt(JSPUtil.getParameter(request, "estm_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setAcclAmt(JSPUtil.getParameter(request, "accl_amt", ""));
		setActAmt(JSPUtil.getParameter(request, "act_amt", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, "estm_vvd_tp_cd", ""));
		setEstmVvdTpCdCnt(JSPUtil.getParameter(request, "estm_vvd_tp_cd_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActRsltRVO[]
	 */
	public ActRsltRVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActRsltRVO[]
	 */
	public ActRsltRVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActRsltRVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
   
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rvvd = (JSPUtil.getParameter(request, prefix	+ "rvvd".trim(), length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon".trim(), length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon".trim(), length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item".trim(), length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt".trim(), length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd".trim(), length));
			String[] acclAmt = (JSPUtil.getParameter(request, prefix	+ "accl_amt".trim(), length));
			String[] actAmt = (JSPUtil.getParameter(request, prefix	+ "act_amt".trim(), length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd".trim(), length));
			String[] estmVvdTpCdCnt = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd_cnt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ActRsltRVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rvvd[i] != null)
					model.setRvvd(rvvd[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (revYrmon[i] != null)
					model.setExeYrmon(revYrmon[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (acclAmt[i] != null)
					model.setAcclAmt(acclAmt[i]);
				if (actAmt[i] != null)
					model.setActAmt(actAmt[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (estmVvdTpCdCnt[i] != null)
					model.setEstmVvdTpCdCnt(estmVvdTpCdCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActRsltRVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActRsltRVO[]
	 */
	public ActRsltRVO[] getActRsltRVOs(){
		ActRsltRVO[] vos = (ActRsltRVO[])models.toArray(new ActRsltRVO[models.size()]);
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
		this.rvvd = this.rvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAmt = this.acclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAmt = this.actAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCdCnt = this.estmVvdTpCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
