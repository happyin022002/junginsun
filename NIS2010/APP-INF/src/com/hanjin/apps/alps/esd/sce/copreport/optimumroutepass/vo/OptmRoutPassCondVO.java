/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OptmRoutPassCondVO.java
*@FileTitle : OptmRoutPassCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.04.28 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OptmRoutPassCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OptmRoutPassCondVO> models = new ArrayList<OptmRoutPassCondVO>();
	
	/* Column Info */
	private String exlFlg = null;
	/* Column Info */
	private String selSoNo = null;
	/* Column Info */
	private String bndCd = null;
	/* Column Info */
	private String inclSubOfcFlg = null;
	/* Column Info */
	private String dscrRsnCd = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String woCreOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doorNode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String fromNode = null;
	/* Column Info */
	private String selOpTp = null;
	/* Column Info */
	private String inputOffice = null;
	/* Column Info */
	private String optmRoutPassFlg = null;
	/* Column Info */
	private String selDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OptmRoutPassCondVO() {}

	public OptmRoutPassCondVO(String ibflag, String pagerows, String fromDate, String toDate, String bndCd, String trspModCd, String inputOffice, String inclSubOfcFlg, String optmRoutPassFlg, String dscrRsnCd, String exlFlg, String woCreOfcCd, String selOpTp, String selDate, String fromNode, String doorNode, String selSoNo) {
		this.exlFlg = exlFlg;
		this.selSoNo = selSoNo;
		this.bndCd = bndCd;
		this.inclSubOfcFlg = inclSubOfcFlg;
		this.dscrRsnCd = dscrRsnCd;
		this.toDate = toDate;
		this.trspModCd = trspModCd;
		this.woCreOfcCd = woCreOfcCd;
		this.pagerows = pagerows;
		this.doorNode = doorNode;
		this.ibflag = ibflag;
		this.fromDate = fromDate;
		this.fromNode = fromNode;
		this.selOpTp = selOpTp;
		this.inputOffice = inputOffice;
		this.optmRoutPassFlg = optmRoutPassFlg;
		this.selDate = selDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("exl_flg", getExlFlg());
		this.hashColumns.put("sel_so_no", getSelSoNo());
		this.hashColumns.put("bnd_cd", getBndCd());
		this.hashColumns.put("incl_sub_ofc_flg", getInclSubOfcFlg());
		this.hashColumns.put("dscr_rsn_cd", getDscrRsnCd());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("wo_cre_ofc_cd", getWoCreOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("door_node", getDoorNode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("from_node", getFromNode());
		this.hashColumns.put("sel_op_tp", getSelOpTp());
		this.hashColumns.put("input_office", getInputOffice());
		this.hashColumns.put("optm_rout_pass_flg", getOptmRoutPassFlg());
		this.hashColumns.put("sel_date", getSelDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("exl_flg", "exlFlg");
		this.hashFields.put("sel_so_no", "selSoNo");
		this.hashFields.put("bnd_cd", "bndCd");
		this.hashFields.put("incl_sub_ofc_flg", "inclSubOfcFlg");
		this.hashFields.put("dscr_rsn_cd", "dscrRsnCd");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("wo_cre_ofc_cd", "woCreOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("door_node", "doorNode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("from_node", "fromNode");
		this.hashFields.put("sel_op_tp", "selOpTp");
		this.hashFields.put("input_office", "inputOffice");
		this.hashFields.put("optm_rout_pass_flg", "optmRoutPassFlg");
		this.hashFields.put("sel_date", "selDate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return exlFlg
	 */
	public String getExlFlg() {
		return this.exlFlg;
	}
	
	/**
	 * Column Info
	 * @return selSoNo
	 */
	public String getSelSoNo() {
		return this.selSoNo;
	}
	
	/**
	 * Column Info
	 * @return bndCd
	 */
	public String getBndCd() {
		return this.bndCd;
	}
	
	/**
	 * Column Info
	 * @return inclSubOfcFlg
	 */
	public String getInclSubOfcFlg() {
		return this.inclSubOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return dscrRsnCd
	 */
	public String getDscrRsnCd() {
		return this.dscrRsnCd;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return woCreOfcCd
	 */
	public String getWoCreOfcCd() {
		return this.woCreOfcCd;
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
	 * @return doorNode
	 */
	public String getDoorNode() {
		return this.doorNode;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return fromNode
	 */
	public String getFromNode() {
		return this.fromNode;
	}
	
	/**
	 * Column Info
	 * @return selOpTp
	 */
	public String getSelOpTp() {
		return this.selOpTp;
	}
	
	/**
	 * Column Info
	 * @return inputOffice
	 */
	public String getInputOffice() {
		return this.inputOffice;
	}
	
	/**
	 * Column Info
	 * @return optmRoutPassFlg
	 */
	public String getOptmRoutPassFlg() {
		return this.optmRoutPassFlg;
	}
	
	/**
	 * Column Info
	 * @return selDate
	 */
	public String getSelDate() {
		return this.selDate;
	}
	

	/**
	 * Column Info
	 * @param exlFlg
	 */
	public void setExlFlg(String exlFlg) {
		this.exlFlg = exlFlg;
	}
	
	/**
	 * Column Info
	 * @param selSoNo
	 */
	public void setSelSoNo(String selSoNo) {
		this.selSoNo = selSoNo;
	}
	
	/**
	 * Column Info
	 * @param bndCd
	 */
	public void setBndCd(String bndCd) {
		this.bndCd = bndCd;
	}
	
	/**
	 * Column Info
	 * @param inclSubOfcFlg
	 */
	public void setInclSubOfcFlg(String inclSubOfcFlg) {
		this.inclSubOfcFlg = inclSubOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param dscrRsnCd
	 */
	public void setDscrRsnCd(String dscrRsnCd) {
		this.dscrRsnCd = dscrRsnCd;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param woCreOfcCd
	 */
	public void setWoCreOfcCd(String woCreOfcCd) {
		this.woCreOfcCd = woCreOfcCd;
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
	 * @param doorNode
	 */
	public void setDoorNode(String doorNode) {
		this.doorNode = doorNode;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param fromNode
	 */
	public void setFromNode(String fromNode) {
		this.fromNode = fromNode;
	}
	
	/**
	 * Column Info
	 * @param selOpTp
	 */
	public void setSelOpTp(String selOpTp) {
		this.selOpTp = selOpTp;
	}
	
	/**
	 * Column Info
	 * @param inputOffice
	 */
	public void setInputOffice(String inputOffice) {
		this.inputOffice = inputOffice;
	}
	
	/**
	 * Column Info
	 * @param optmRoutPassFlg
	 */
	public void setOptmRoutPassFlg(String optmRoutPassFlg) {
		this.optmRoutPassFlg = optmRoutPassFlg;
	}
	
	/**
	 * Column Info
	 * @param selDate
	 */
	public void setSelDate(String selDate) {
		this.selDate = selDate;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setExlFlg(JSPUtil.getParameter(request, prefix + "exl_flg", ""));
		setSelSoNo(JSPUtil.getParameter(request, prefix + "sel_so_no", ""));
		setBndCd(JSPUtil.getParameter(request, prefix + "bnd_cd", ""));
		setInclSubOfcFlg(JSPUtil.getParameter(request, prefix + "incl_sub_ofc_flg", ""));
		setDscrRsnCd(JSPUtil.getParameter(request, prefix + "dscr_rsn_cd", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setWoCreOfcCd(JSPUtil.getParameter(request, prefix + "wo_cre_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDoorNode(JSPUtil.getParameter(request, prefix + "door_node", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setFromNode(JSPUtil.getParameter(request, prefix + "from_node", ""));
		setSelOpTp(JSPUtil.getParameter(request, prefix + "sel_op_tp", ""));
		setInputOffice(JSPUtil.getParameter(request, prefix + "input_office", ""));
		setOptmRoutPassFlg(JSPUtil.getParameter(request, prefix + "optm_rout_pass_flg", ""));
		setSelDate(JSPUtil.getParameter(request, prefix + "sel_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OptmRoutPassCondVO[]
	 */
	public OptmRoutPassCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OptmRoutPassCondVO[]
	 */
	public OptmRoutPassCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OptmRoutPassCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] exlFlg = (JSPUtil.getParameter(request, prefix	+ "exl_flg", length));
			String[] selSoNo = (JSPUtil.getParameter(request, prefix	+ "sel_so_no", length));
			String[] bndCd = (JSPUtil.getParameter(request, prefix	+ "bnd_cd", length));
			String[] inclSubOfcFlg = (JSPUtil.getParameter(request, prefix	+ "incl_sub_ofc_flg", length));
			String[] dscrRsnCd = (JSPUtil.getParameter(request, prefix	+ "dscr_rsn_cd", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] woCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_cre_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doorNode = (JSPUtil.getParameter(request, prefix	+ "door_node", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] fromNode = (JSPUtil.getParameter(request, prefix	+ "from_node", length));
			String[] selOpTp = (JSPUtil.getParameter(request, prefix	+ "sel_op_tp", length));
			String[] inputOffice = (JSPUtil.getParameter(request, prefix	+ "input_office", length));
			String[] optmRoutPassFlg = (JSPUtil.getParameter(request, prefix	+ "optm_rout_pass_flg", length));
			String[] selDate = (JSPUtil.getParameter(request, prefix	+ "sel_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new OptmRoutPassCondVO();
				if (exlFlg[i] != null)
					model.setExlFlg(exlFlg[i]);
				if (selSoNo[i] != null)
					model.setSelSoNo(selSoNo[i]);
				if (bndCd[i] != null)
					model.setBndCd(bndCd[i]);
				if (inclSubOfcFlg[i] != null)
					model.setInclSubOfcFlg(inclSubOfcFlg[i]);
				if (dscrRsnCd[i] != null)
					model.setDscrRsnCd(dscrRsnCd[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (woCreOfcCd[i] != null)
					model.setWoCreOfcCd(woCreOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doorNode[i] != null)
					model.setDoorNode(doorNode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (fromNode[i] != null)
					model.setFromNode(fromNode[i]);
				if (selOpTp[i] != null)
					model.setSelOpTp(selOpTp[i]);
				if (inputOffice[i] != null)
					model.setInputOffice(inputOffice[i]);
				if (optmRoutPassFlg[i] != null)
					model.setOptmRoutPassFlg(optmRoutPassFlg[i]);
				if (selDate[i] != null)
					model.setSelDate(selDate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOptmRoutPassCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OptmRoutPassCondVO[]
	 */
	public OptmRoutPassCondVO[] getOptmRoutPassCondVOs(){
		OptmRoutPassCondVO[] vos = (OptmRoutPassCondVO[])models.toArray(new OptmRoutPassCondVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.exlFlg = this.exlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSoNo = this.selSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndCd = this.bndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclSubOfcFlg = this.inclSubOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrRsnCd = this.dscrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCreOfcCd = this.woCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doorNode = this.doorNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromNode = this.fromNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selOpTp = this.selOpTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputOffice = this.inputOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmRoutPassFlg = this.optmRoutPassFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selDate = this.selDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
