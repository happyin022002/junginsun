/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLinkCostListByPRDVO.java
*@FileTitle : SearchLinkCostListByPRDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.10.14 장영석 
* 1.0 Creation
* 2011.12.30 최윤성 [CHM-201115391-01] [MAS] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - avgLvlChk 필드 추가
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo;

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
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLinkCostListByPRDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLinkCostListByPRDVO> models = new ArrayList<SearchLinkCostListByPRDVO>();
	
	/* Column Info */
	private String treeCol = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String raAmt = null;
	/* Column Info */
	private String amt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grp = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String sgrpCostCdDesc = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String avgLvlChk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchLinkCostListByPRDVO() {}

	public SearchLinkCostListByPRDVO(String ibflag, String pagerows, String nodCd, String costActGrpSeq, String grp, String sgrpCostCdDesc, String stndCostNm, String amt, String raAmt, String wtrRcvTermCd, String wtrDeTermCd, String lvl, String treeCol, String avgLvlChk) {
		this.treeCol = treeCol;
		this.stndCostNm = stndCostNm;
		this.pagerows = pagerows;
		this.raAmt = raAmt;
		this.amt = amt;
		this.ibflag = ibflag;
		this.grp = grp;
		this.lvl = lvl;
		this.costActGrpSeq = costActGrpSeq;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.nodCd = nodCd;
		this.sgrpCostCdDesc = sgrpCostCdDesc;
		this.wtrDeTermCd = wtrDeTermCd;
		this.avgLvlChk = avgLvlChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tree_col", getTreeCol());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ra_amt", getRaAmt());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("sgrp_cost_cd_desc", getSgrpCostCdDesc());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("avg_lvl_chk", getAvgLvlChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tree_col", "treeCol");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ra_amt", "raAmt");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("sgrp_cost_cd_desc", "sgrpCostCdDesc");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("avg_lvl_chk", "avgLvlChk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return treeCol
	 */
	public String getTreeCol() {
		return this.treeCol;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
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
	 * @return raAmt
	 */
	public String getRaAmt() {
		return this.raAmt;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
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
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCdDesc
	 */
	public String getSgrpCostCdDesc() {
		return this.sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return avgLvlChk
	 */
	public String getAvgLvlChk() {
		return this.avgLvlChk;
	}
	

	/**
	 * Column Info
	 * @param treeCol
	 */
	public void setTreeCol(String treeCol) {
		this.treeCol = treeCol;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
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
	 * @param raAmt
	 */
	public void setRaAmt(String raAmt) {
		this.raAmt = raAmt;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCdDesc
	 */
	public void setSgrpCostCdDesc(String sgrpCostCdDesc) {
		this.sgrpCostCdDesc = sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param avgLvlChk
	 */
	public void setAvgLvlChk(String avgLvlChk) {
		this.avgLvlChk = avgLvlChk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTreeCol(JSPUtil.getParameter(request, "tree_col", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRaAmt(JSPUtil.getParameter(request, "ra_amt", ""));
		setAmt(JSPUtil.getParameter(request, "amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, "cost_act_grp_seq", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, "wtr_rcv_term_cd", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setSgrpCostCdDesc(JSPUtil.getParameter(request, "sgrp_cost_cd_desc", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, "wtr_de_term_cd", ""));
		setAvgLvlChk(JSPUtil.getParameter(request, "avg_lvl_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLinkCostListByPRDVO[]
	 */
	public SearchLinkCostListByPRDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLinkCostListByPRDVO[]
	 */
	public SearchLinkCostListByPRDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLinkCostListByPRDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] treeCol = (JSPUtil.getParameter(request, prefix	+ "tree_col", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] raAmt = (JSPUtil.getParameter(request, prefix	+ "ra_amt", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] sgrpCostCdDesc = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd_desc", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] avgLvlChk = (JSPUtil.getParameter(request, prefix	+ "avg_lvl_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLinkCostListByPRDVO();
				if (treeCol[i] != null)
					model.setTreeCol(treeCol[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (raAmt[i] != null)
					model.setRaAmt(raAmt[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (sgrpCostCdDesc[i] != null)
					model.setSgrpCostCdDesc(sgrpCostCdDesc[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (avgLvlChk[i] != null)
					model.setAvgLvlChk(avgLvlChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLinkCostListByPRDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLinkCostListByPRDVO[]
	 */
	public SearchLinkCostListByPRDVO[] getSearchLinkCostListByPRDVOs(){
		SearchLinkCostListByPRDVO[] vos = (SearchLinkCostListByPRDVO[])models.toArray(new SearchLinkCostListByPRDVO[models.size()]);
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
		this.treeCol = this.treeCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raAmt = this.raAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCdDesc = this.sgrpCostCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgLvlChk = this.avgLvlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
