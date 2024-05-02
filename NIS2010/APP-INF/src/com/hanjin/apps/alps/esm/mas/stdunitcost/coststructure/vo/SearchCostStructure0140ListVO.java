/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCostStructure0140ListVO.java
*@FileTitle : SearchCostStructure0140ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.10.13 전윤주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

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
 * @author 전윤주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCostStructure0140ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCostStructure0140ListVO> models = new ArrayList<SearchCostStructure0140ListVO>();
	
	/* Column Info */
	private String wtrModFlg = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wtrTermCd = null;
	/* Column Info */
	private String nxtNodThrpRto = null;
	/* Column Info */
	private String calcTermCd = null;
	/* Column Info */
	private String nxtNodTmlRto = null;
	/* Column Info */
	private String nodStvgRto = null;
	/* Column Info */
	private String nxtNodStvgRto = null;
	/* Column Info */
	private String nodTmlRto = null;
	/* Column Info */
	private String nodThrpRto = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCostStructure0140ListVO() {}

	public SearchCostStructure0140ListVO(String ibflag, String pagerows, String costActGrpCd, String calcTermCd, String wtrTermCd, String wtrModFlg, String nodStvgRto, String nodThrpRto, String nodTmlRto, String nxtNodStvgRto, String nxtNodThrpRto, String nxtNodTmlRto) {
		this.wtrModFlg = wtrModFlg;
		this.costActGrpCd = costActGrpCd;
		this.ibflag = ibflag;
		this.wtrTermCd = wtrTermCd;
		this.nxtNodThrpRto = nxtNodThrpRto;
		this.calcTermCd = calcTermCd;
		this.nxtNodTmlRto = nxtNodTmlRto;
		this.nodStvgRto = nodStvgRto;
		this.nxtNodStvgRto = nxtNodStvgRto;
		this.nodTmlRto = nodTmlRto;
		this.nodThrpRto = nodThrpRto;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wtr_mod_flg", getWtrModFlg());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wtr_term_cd", getWtrTermCd());
		this.hashColumns.put("nxt_nod_thrp_rto", getNxtNodThrpRto());
		this.hashColumns.put("calc_term_cd", getCalcTermCd());
		this.hashColumns.put("nxt_nod_tml_rto", getNxtNodTmlRto());
		this.hashColumns.put("nod_stvg_rto", getNodStvgRto());
		this.hashColumns.put("nxt_nod_stvg_rto", getNxtNodStvgRto());
		this.hashColumns.put("nod_tml_rto", getNodTmlRto());
		this.hashColumns.put("nod_thrp_rto", getNodThrpRto());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wtr_mod_flg", "wtrModFlg");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wtr_term_cd", "wtrTermCd");
		this.hashFields.put("nxt_nod_thrp_rto", "nxtNodThrpRto");
		this.hashFields.put("calc_term_cd", "calcTermCd");
		this.hashFields.put("nxt_nod_tml_rto", "nxtNodTmlRto");
		this.hashFields.put("nod_stvg_rto", "nodStvgRto");
		this.hashFields.put("nxt_nod_stvg_rto", "nxtNodStvgRto");
		this.hashFields.put("nod_tml_rto", "nodTmlRto");
		this.hashFields.put("nod_thrp_rto", "nodThrpRto");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return wtrModFlg
	 */
	public String getWtrModFlg() {
		return this.wtrModFlg;
	}
	
	/**
	 * Column Info
	 * @return costActGrpCd
	 */
	public String getCostActGrpCd() {
		return this.costActGrpCd;
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
	 * @return wtrTermCd
	 */
	public String getWtrTermCd() {
		return this.wtrTermCd;
	}
	
	/**
	 * Column Info
	 * @return nxtNodThrpRto
	 */
	public String getNxtNodThrpRto() {
		return this.nxtNodThrpRto;
	}
	
	/**
	 * Column Info
	 * @return calcTermCd
	 */
	public String getCalcTermCd() {
		return this.calcTermCd;
	}
	
	/**
	 * Column Info
	 * @return nxtNodTmlRto
	 */
	public String getNxtNodTmlRto() {
		return this.nxtNodTmlRto;
	}
	
	/**
	 * Column Info
	 * @return nodStvgRto
	 */
	public String getNodStvgRto() {
		return this.nodStvgRto;
	}
	
	/**
	 * Column Info
	 * @return nxtNodStvgRto
	 */
	public String getNxtNodStvgRto() {
		return this.nxtNodStvgRto;
	}
	
	/**
	 * Column Info
	 * @return nodTmlRto
	 */
	public String getNodTmlRto() {
		return this.nodTmlRto;
	}
	
	/**
	 * Column Info
	 * @return nodThrpRto
	 */
	public String getNodThrpRto() {
		return this.nodThrpRto;
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
	 * @param wtrModFlg
	 */
	public void setWtrModFlg(String wtrModFlg) {
		this.wtrModFlg = wtrModFlg;
	}
	
	/**
	 * Column Info
	 * @param costActGrpCd
	 */
	public void setCostActGrpCd(String costActGrpCd) {
		this.costActGrpCd = costActGrpCd;
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
	 * @param wtrTermCd
	 */
	public void setWtrTermCd(String wtrTermCd) {
		this.wtrTermCd = wtrTermCd;
	}
	
	/**
	 * Column Info
	 * @param nxtNodThrpRto
	 */
	public void setNxtNodThrpRto(String nxtNodThrpRto) {
		this.nxtNodThrpRto = nxtNodThrpRto;
	}
	
	/**
	 * Column Info
	 * @param calcTermCd
	 */
	public void setCalcTermCd(String calcTermCd) {
		this.calcTermCd = calcTermCd;
	}
	
	/**
	 * Column Info
	 * @param nxtNodTmlRto
	 */
	public void setNxtNodTmlRto(String nxtNodTmlRto) {
		this.nxtNodTmlRto = nxtNodTmlRto;
	}
	
	/**
	 * Column Info
	 * @param nodStvgRto
	 */
	public void setNodStvgRto(String nodStvgRto) {
		this.nodStvgRto = nodStvgRto;
	}
	
	/**
	 * Column Info
	 * @param nxtNodStvgRto
	 */
	public void setNxtNodStvgRto(String nxtNodStvgRto) {
		this.nxtNodStvgRto = nxtNodStvgRto;
	}
	
	/**
	 * Column Info
	 * @param nodTmlRto
	 */
	public void setNodTmlRto(String nodTmlRto) {
		this.nodTmlRto = nodTmlRto;
	}
	
	/**
	 * Column Info
	 * @param nodThrpRto
	 */
	public void setNodThrpRto(String nodThrpRto) {
		this.nodThrpRto = nodThrpRto;
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
		setWtrModFlg(JSPUtil.getParameter(request, "wtr_mod_flg", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, "cost_act_grp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWtrTermCd(JSPUtil.getParameter(request, "wtr_term_cd", ""));
		setNxtNodThrpRto(JSPUtil.getParameter(request, "nxt_nod_thrp_rto", ""));
		setCalcTermCd(JSPUtil.getParameter(request, "calc_term_cd", ""));
		setNxtNodTmlRto(JSPUtil.getParameter(request, "nxt_nod_tml_rto", ""));
		setNodStvgRto(JSPUtil.getParameter(request, "nod_stvg_rto", ""));
		setNxtNodStvgRto(JSPUtil.getParameter(request, "nxt_nod_stvg_rto", ""));
		setNodTmlRto(JSPUtil.getParameter(request, "nod_tml_rto", ""));
		setNodThrpRto(JSPUtil.getParameter(request, "nod_thrp_rto", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCostStructure0140ListVO[]
	 */
	public SearchCostStructure0140ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCostStructure0140ListVO[]
	 */
	public SearchCostStructure0140ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCostStructure0140ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] wtrModFlg = (JSPUtil.getParameter(request, prefix	+ "wtr_mod_flg", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wtrTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_term_cd", length));
			String[] nxtNodThrpRto = (JSPUtil.getParameter(request, prefix	+ "nxt_nod_thrp_rto", length));
			String[] calcTermCd = (JSPUtil.getParameter(request, prefix	+ "calc_term_cd", length));
			String[] nxtNodTmlRto = (JSPUtil.getParameter(request, prefix	+ "nxt_nod_tml_rto", length));
			String[] nodStvgRto = (JSPUtil.getParameter(request, prefix	+ "nod_stvg_rto", length));
			String[] nxtNodStvgRto = (JSPUtil.getParameter(request, prefix	+ "nxt_nod_stvg_rto", length));
			String[] nodTmlRto = (JSPUtil.getParameter(request, prefix	+ "nod_tml_rto", length));
			String[] nodThrpRto = (JSPUtil.getParameter(request, prefix	+ "nod_thrp_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCostStructure0140ListVO();
				if (wtrModFlg[i] != null)
					model.setWtrModFlg(wtrModFlg[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wtrTermCd[i] != null)
					model.setWtrTermCd(wtrTermCd[i]);
				if (nxtNodThrpRto[i] != null)
					model.setNxtNodThrpRto(nxtNodThrpRto[i]);
				if (calcTermCd[i] != null)
					model.setCalcTermCd(calcTermCd[i]);
				if (nxtNodTmlRto[i] != null)
					model.setNxtNodTmlRto(nxtNodTmlRto[i]);
				if (nodStvgRto[i] != null)
					model.setNodStvgRto(nodStvgRto[i]);
				if (nxtNodStvgRto[i] != null)
					model.setNxtNodStvgRto(nxtNodStvgRto[i]);
				if (nodTmlRto[i] != null)
					model.setNodTmlRto(nodTmlRto[i]);
				if (nodThrpRto[i] != null)
					model.setNodThrpRto(nodThrpRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCostStructure0140ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCostStructure0140ListVO[]
	 */
	public SearchCostStructure0140ListVO[] getSearchCostStructure0140ListVOs(){
		SearchCostStructure0140ListVO[] vos = (SearchCostStructure0140ListVO[])models.toArray(new SearchCostStructure0140ListVO[models.size()]);
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
		this.wtrModFlg = this.wtrModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrTermCd = this.wtrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtNodThrpRto = this.nxtNodThrpRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTermCd = this.calcTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtNodTmlRto = this.nxtNodTmlRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodStvgRto = this.nodStvgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtNodStvgRto = this.nxtNodStvgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTmlRto = this.nodTmlRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodThrpRto = this.nodThrpRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
