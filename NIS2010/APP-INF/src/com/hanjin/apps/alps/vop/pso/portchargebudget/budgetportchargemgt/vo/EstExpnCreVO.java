/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EstExpnCreVO.java
*@FileTitle : EstExpnCreVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.04.06 정명훈 
* 1.0 Creation
* History
* 2010.10.04 유혁 CHM-201006127-01 Title : 운하 통항비 tariff Cost 생성 로직 변경
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstExpnCreVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstExpnCreVO> models = new ArrayList<EstExpnCreVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String tmnlCode = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String mismatched = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String txtedate = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String txtcolor = null;
	/* Column Info */
	private String txtsdate = null;
	/* Column Info */
	private String hvvd = null;	
	/* Column Info */
	private String turnSkdVoyNo = null;
	/* Column Info */
	private String turnSkdDirCd = null;
	/* Column Info */
	private String turnClptIndSeq = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String virTurnPortFlg = null;
	/* Column Info */
	private String virTurnPortIndCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstExpnCreVO() {}

	public EstExpnCreVO(String ibflag, String pagerows, String vslCd, String revYrmon, String tmnlCode, String skdVoyNo, String skdDirCd, String lane, String vvd, String txtedate, String chk, String txtcolor, String txtsdate, String hvvd, String turnPortFlg, String turnPortIndCd, String mismatched, String clptSeq, String turnSkdVoyNo, String turnSkdDirCd, String turnClptIndSeq, String clptIndSeq, String virTurnPortFlg, String virTurnPortIndCd) {
		this.vslCd = vslCd;
		this.revYrmon = revYrmon;
		this.tmnlCode = tmnlCode;
		this.skdVoyNo = skdVoyNo;
		this.mismatched = mismatched;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.lane = lane;
		this.turnPortFlg = turnPortFlg;
		this.turnPortIndCd = turnPortIndCd;
		this.vvd = vvd;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.txtedate = txtedate;
		this.chk = chk;
		this.txtcolor = txtcolor;
		this.txtsdate = txtsdate;
		this.hvvd = hvvd;
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.turnSkdDirCd = turnSkdDirCd;
		this.turnClptIndSeq = turnClptIndSeq;
		this.clptIndSeq = clptIndSeq;
		this.virTurnPortFlg = virTurnPortFlg;
		this.virTurnPortIndCd = virTurnPortIndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("tmnl_code", getTmnlCode());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("mismatched", getMismatched());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("txtedate", getTxtedate());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("txtcolor", getTxtcolor());
		this.hashColumns.put("txtsdate", getTxtsdate());
		this.hashColumns.put("hvvd", getHvvd());
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("vir_turn_port_flg", getVirTurnPortFlg());
		this.hashColumns.put("vir_turn_port_ind_cd", getVirTurnPortIndCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("tmnl_code", "tmnlCode");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("mismatched", "mismatched");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("txtedate", "txtedate");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("txtcolor", "txtcolor");
		this.hashFields.put("txtsdate", "txtsdate");
		this.hashFields.put("hvvd", "hvvd");
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("vir_turn_port_flg", "virTurnPortFlg");
		this.hashFields.put("vir_turn_port_ind_cd", "virTurnPortIndCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return tmnlCode
	 */
	public String getTmnlCode() {
		return this.tmnlCode;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return mismatched
	 */
	public String getMismatched() {
		return this.mismatched;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return turnPortFlg
	 */
	public String getTurnPortFlg() {
		return this.turnPortFlg;
	}
	
	/**
	 * Column Info
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
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
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return txtedate
	 */
	public String getTxtedate() {
		return this.txtedate;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return txtcolor
	 */
	public String getTxtcolor() {
		return this.txtcolor;
	}
	
	/**
	 * Column Info
	 * @return txtsdate
	 */
	public String getTxtsdate() {
		return this.txtsdate;
	}
	
	/**
	 * Column Info
	 * @return hvvd
	 */
	public String getHvvd() {
		return this.hvvd;
	}
	
	/**
	 * Column Info
	 * @return turnSkdVoyNo
	 */
	public String getTurnSkdVoyNo() {
		return this.turnSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
	}

	/**
	 * Column Info
	 * @return turnClptIndSeq
	 */
	public String getTurnClptIndSeq() {
		return this.turnClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return virTurnPortFlg
	 */
	public String getVirTurnPortFlg() {
		return this.virTurnPortFlg;
	}
	
	/**
	 * Column Info
	 * @return virTurnPortIndCd
	 */
	public String getVirTurnPortIndCd() {
		return this.virTurnPortIndCd;
	}

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param tmnlCode
	 */
	public void setTmnlCode(String tmnlCode) {
		this.tmnlCode = tmnlCode;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param mismatched
	 */
	public void setMismatched(String mismatched) {
		this.mismatched = mismatched;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param turnPortFlg
	 */
	public void setTurnPortFlg(String turnPortFlg) {
		this.turnPortFlg = turnPortFlg;
	}
	
	/**
	 * Column Info
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
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
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param txtedate
	 */
	public void setTxtedate(String txtedate) {
		this.txtedate = txtedate;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param txtcolor
	 */
	public void setTxtcolor(String txtcolor) {
		this.txtcolor = txtcolor;
	}
	
	/**
	 * Column Info
	 * @param txtsdate
	 */
	public void setTxtsdate(String txtsdate) {
		this.txtsdate = txtsdate;
	}
	
	/**
	 * Column Info
	 * @param hvvd
	 */
	public void setHvvd(String hvvd) {
		this.hvvd = hvvd;
	}
	
	/**
	 * Column Info
	 * @param turnSkdVoyNo
	 */
	public void setTurnSkdVoyNo(String turnSkdVoyNo) {
		this.turnSkdVoyNo = turnSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
	}

	/**
	 * Column Info
	 * @param turnClptIndSeq
	 */
	public void setTurnClptIndSeq(String turnClptIndSeq) {
		this.turnClptIndSeq = turnClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param virTurnPortFlg
	 */
	public void setVirTurnPortFlg(String virTurnPortFlg) {
		this.virTurnPortFlg = virTurnPortFlg;
	}
	
	/**
	 * Column Info
	 * @param virTurnPortIndCd
	 */
	public void setVirTurnPortIndCd(String virTurnPortIndCd) {
		this.virTurnPortIndCd = virTurnPortIndCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setTmnlCode(JSPUtil.getParameter(request, prefix + "tmnl_code", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setMismatched(JSPUtil.getParameter(request, prefix + "mismatched", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTxtedate(JSPUtil.getParameter(request, prefix + "txtedate", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setTxtcolor(JSPUtil.getParameter(request, prefix + "txtcolor", ""));
		setTxtsdate(JSPUtil.getParameter(request, prefix + "txtsdate", ""));
		setHvvd(JSPUtil.getParameter(request, prefix + "hvvd", ""));
		setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));   
		setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));  
		setTurnClptIndSeq(JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setVirTurnPortFlg(JSPUtil.getParameter(request, prefix + "vir_turn_port_flg", ""));
		setVirTurnPortIndCd(JSPUtil.getParameter(request, prefix + "vir_turn_port_ind_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstExpnCreVO[]
	 */
	public EstExpnCreVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstExpnCreVO[]
	 */
	public EstExpnCreVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstExpnCreVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] tmnlCode = (JSPUtil.getParameter(request, prefix	+ "tmnl_code", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] mismatched = (JSPUtil.getParameter(request, prefix	+ "mismatched", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] txtedate = (JSPUtil.getParameter(request, prefix	+ "txtedate", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] txtcolor = (JSPUtil.getParameter(request, prefix	+ "txtcolor", length));
			String[] txtsdate = (JSPUtil.getParameter(request, prefix	+ "txtsdate", length));
			String[] hvvd = (JSPUtil.getParameter(request, prefix	+ "hvvd", length));
			String[] turnSkdVoyNo   = (JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", length));   
			String[] turnSkdDirCd   = (JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", length));  
			String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
			String[] virTurnPortFlg = (JSPUtil.getParameter(request, prefix	+ "vir_turn_port_flg", length));
			String[] virTurnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "vir_turn_port_ind_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EstExpnCreVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (tmnlCode[i] != null)
					model.setTmnlCode(tmnlCode[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (mismatched[i] != null)
					model.setMismatched(mismatched[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (txtedate[i] != null)
					model.setTxtedate(txtedate[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (txtcolor[i] != null)
					model.setTxtcolor(txtcolor[i]);
				if (txtsdate[i] != null)
					model.setTxtsdate(txtsdate[i]);
				if (hvvd[i] != null)
					model.setHvvd(hvvd[i]);
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (turnClptIndSeq[i] != null)
					model.setTurnClptIndSeq(turnClptIndSeq[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (virTurnPortFlg[i] != null)
					model.setVirTurnPortFlg(virTurnPortFlg[i]);
				if (virTurnPortIndCd[i] != null)
					model.setVirTurnPortIndCd(virTurnPortIndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstExpnCreVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstExpnCreVO[]
	 */
	public EstExpnCreVO[] getEstExpnCreVOs(){
		EstExpnCreVO[] vos = (EstExpnCreVO[])models.toArray(new EstExpnCreVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlCode = this.tmnlCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mismatched = this.mismatched .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtedate = this.txtedate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtcolor = this.txtcolor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtsdate = this.txtsdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hvvd = this.hvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNo = this.turnSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnClptIndSeq = this.turnClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.virTurnPortFlg = this.virTurnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.virTurnPortIndCd = this.virTurnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}