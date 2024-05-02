/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArbitraryExcelDupCheckVO.java
*@FileTitle : ArbitraryExcelDupCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.24
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.12.24 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArbitraryExcelDupCheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArbitraryExcelDupCheckVO> models = new ArrayList<ArbitraryExcelDupCheckVO>();
	
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String bsePortDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String viaPortDefCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String minCgoWgt = null;
	/* Column Info */
	private String addChgNoteCtnt = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String maxCgoWgt = null;
	/* Column Info */
	private String prcCmdtDefCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ArbitraryExcelDupCheckVO() {}

	public ArbitraryExcelDupCheckVO(String ibflag, String pagerows, String routPntLocDefCd, String prcTrspModCd, String rcvDeTermCd, String minCgoWgt, String maxCgoWgt, String bsePortDefCd, String viaPortDefCd, String dirCallFlg, String ratUtCd, String prcCgoTpCd, String prcCmdtDefCd, String currCd, String addChgNoteCtnt) {
		this.dirCallFlg = dirCallFlg;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.ratUtCd = ratUtCd;
		this.bsePortDefCd = bsePortDefCd;
		this.pagerows = pagerows;
		this.viaPortDefCd = viaPortDefCd;
		this.ibflag = ibflag;
		this.minCgoWgt = minCgoWgt;
		this.addChgNoteCtnt = addChgNoteCtnt;
		this.prcTrspModCd = prcTrspModCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.maxCgoWgt = maxCgoWgt;
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("via_port_def_cd", getViaPortDefCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("add_chg_note_ctnt", getAddChgNoteCtnt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("via_port_def_cd", "viaPortDefCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("add_chg_note_ctnt", "addChgNoteCtnt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dirCallFlg
	 */
	public String getDirCallFlg() {
		return this.dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return bsePortDefCd
	 */
	public String getBsePortDefCd() {
		return this.bsePortDefCd;
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
	 * @return viaPortDefCd
	 */
	public String getViaPortDefCd() {
		return this.viaPortDefCd;
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
	 * @return minCgoWgt
	 */
	public String getMinCgoWgt() {
		return this.minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return addChgNoteCtnt
	 */
	public String getAddChgNoteCtnt() {
		return this.addChgNoteCtnt;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return maxCgoWgt
	 */
	public String getMaxCgoWgt() {
		return this.maxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	

	/**
	 * Column Info
	 * @param dirCallFlg
	 */
	public void setDirCallFlg(String dirCallFlg) {
		this.dirCallFlg = dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param bsePortDefCd
	 */
	public void setBsePortDefCd(String bsePortDefCd) {
		this.bsePortDefCd = bsePortDefCd;
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
	 * @param viaPortDefCd
	 */
	public void setViaPortDefCd(String viaPortDefCd) {
		this.viaPortDefCd = viaPortDefCd;
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
	 * @param minCgoWgt
	 */
	public void setMinCgoWgt(String minCgoWgt) {
		this.minCgoWgt = minCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param addChgNoteCtnt
	 */
	public void setAddChgNoteCtnt(String addChgNoteCtnt) {
		this.addChgNoteCtnt = addChgNoteCtnt;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param maxCgoWgt
	 */
	public void setMaxCgoWgt(String maxCgoWgt) {
		this.maxCgoWgt = maxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
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
		setDirCallFlg(JSPUtil.getParameter(request, prefix + "dir_call_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setBsePortDefCd(JSPUtil.getParameter(request, prefix + "bse_port_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setViaPortDefCd(JSPUtil.getParameter(request, prefix + "via_port_def_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMinCgoWgt(JSPUtil.getParameter(request, prefix + "min_cgo_wgt", ""));
		setAddChgNoteCtnt(JSPUtil.getParameter(request, prefix + "add_chg_note_ctnt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request, prefix + "max_cgo_wgt", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArbitraryExcelDupCheckVO[]
	 */
	public ArbitraryExcelDupCheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArbitraryExcelDupCheckVO[]
	 */
	public ArbitraryExcelDupCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArbitraryExcelDupCheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] viaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "via_port_def_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] minCgoWgt = (JSPUtil.getParameter(request, prefix	+ "min_cgo_wgt", length));
			String[] addChgNoteCtnt = (JSPUtil.getParameter(request, prefix	+ "add_chg_note_ctnt", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] maxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "max_cgo_wgt", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArbitraryExcelDupCheckVO();
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (bsePortDefCd[i] != null)
					model.setBsePortDefCd(bsePortDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (viaPortDefCd[i] != null)
					model.setViaPortDefCd(viaPortDefCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (minCgoWgt[i] != null)
					model.setMinCgoWgt(minCgoWgt[i]);
				if (addChgNoteCtnt[i] != null)
					model.setAddChgNoteCtnt(addChgNoteCtnt[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (maxCgoWgt[i] != null)
					model.setMaxCgoWgt(maxCgoWgt[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArbitraryExcelDupCheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArbitraryExcelDupCheckVO[]
	 */
	public ArbitraryExcelDupCheckVO[] getArbitraryExcelDupCheckVOs(){
		ArbitraryExcelDupCheckVO[] vos = (ArbitraryExcelDupCheckVO[])models.toArray(new ArbitraryExcelDupCheckVO[models.size()]);
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
		this.dirCallFlg = this.dirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd = this.bsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaPortDefCd = this.viaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt = this.minCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgNoteCtnt = this.addChgNoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt = this.maxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
