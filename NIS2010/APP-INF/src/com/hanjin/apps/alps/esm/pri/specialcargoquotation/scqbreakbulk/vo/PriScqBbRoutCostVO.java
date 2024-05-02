/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PriScqBbRoutCostVO.java
*@FileTitle : PriScqBbRoutCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.23 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo;

import java.lang.reflect.Field;
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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriScqBbRoutCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScqBbRoutCostVO> models = new ArrayList<PriScqBbRoutCostVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String routRmk = null;
	/* Column Info */
	private String loclCurrAmt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String routTpCd = null;
	/* Column Info */
	private String routCostSeq = null;
	/* Column Info */
	private String scqVerNo = null;
	/* Column Info */
	private String routSeqVerNo = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String bbCgoTpSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String scqRqstNo = null;
	/* Column Info */
	private String bbCgoDesc = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriScqBbRoutCostVO() {}

	public PriScqBbRoutCostVO(String ibflag, String pagerows, String scqRqstNo, String scqVerNo, String routSeq, String routSeqVerNo, String routCostSeq, String bbCgoTpSeq, String costAmt, String creUsrId, String creDt, String updUsrId, String updDt, String routTpCd, String routRmk, String cfmFlg, String bbCgoDesc, String loclCurrCd, String loclCurrAmt, String exRate) {
		this.updDt = updDt;
		this.routRmk = routRmk;
		this.loclCurrAmt = loclCurrAmt;
		this.loclCurrCd = loclCurrCd;
		this.creDt = creDt;
		this.routTpCd = routTpCd;
		this.routCostSeq = routCostSeq;
		this.scqVerNo = scqVerNo;
		this.routSeqVerNo = routSeqVerNo;
		this.cfmFlg = cfmFlg;
		this.bbCgoTpSeq = bbCgoTpSeq;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costAmt = costAmt;
		this.exRate = exRate;
		this.scqRqstNo = scqRqstNo;
		this.bbCgoDesc = bbCgoDesc;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rout_rmk", getRoutRmk());
		this.hashColumns.put("locl_curr_amt", getLoclCurrAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rout_tp_cd", getRoutTpCd());
		this.hashColumns.put("rout_cost_seq", getRoutCostSeq());
		this.hashColumns.put("scq_ver_no", getScqVerNo());
		this.hashColumns.put("rout_seq_ver_no", getRoutSeqVerNo());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("bb_cgo_tp_seq", getBbCgoTpSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("scq_rqst_no", getScqRqstNo());
		this.hashColumns.put("bb_cgo_desc", getBbCgoDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rout_rmk", "routRmk");
		this.hashFields.put("locl_curr_amt", "loclCurrAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rout_tp_cd", "routTpCd");
		this.hashFields.put("rout_cost_seq", "routCostSeq");
		this.hashFields.put("scq_ver_no", "scqVerNo");
		this.hashFields.put("rout_seq_ver_no", "routSeqVerNo");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("bb_cgo_tp_seq", "bbCgoTpSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("scq_rqst_no", "scqRqstNo");
		this.hashFields.put("bb_cgo_desc", "bbCgoDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return routRmk
	 */
	public String getRoutRmk() {
		return this.routRmk;
	}
	
	/**
	 * Column Info
	 * @return loclCurrAmt
	 */
	public String getLoclCurrAmt() {
		return this.loclCurrAmt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return routTpCd
	 */
	public String getRoutTpCd() {
		return this.routTpCd;
	}
	
	/**
	 * Column Info
	 * @return routCostSeq
	 */
	public String getRoutCostSeq() {
		return this.routCostSeq;
	}
	
	/**
	 * Column Info
	 * @return scqVerNo
	 */
	public String getScqVerNo() {
		return this.scqVerNo;
	}
	
	/**
	 * Column Info
	 * @return routSeqVerNo
	 */
	public String getRoutSeqVerNo() {
		return this.routSeqVerNo;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return bbCgoTpSeq
	 */
	public String getBbCgoTpSeq() {
		return this.bbCgoTpSeq;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}
	
	/**
	 * Column Info
	 * @return exRate
	 */
	public String getExRate() {
		return this.exRate;
	}
	
	/**
	 * Column Info
	 * @return scqRqstNo
	 */
	public String getScqRqstNo() {
		return this.scqRqstNo;
	}
	
	/**
	 * Column Info
	 * @return bbCgoDesc
	 */
	public String getBbCgoDesc() {
		return this.bbCgoDesc;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param routRmk
	 */
	public void setRoutRmk(String routRmk) {
		this.routRmk = routRmk;
	}
	
	/**
	 * Column Info
	 * @param loclCurrAmt
	 */
	public void setLoclCurrAmt(String loclCurrAmt) {
		this.loclCurrAmt = loclCurrAmt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param routTpCd
	 */
	public void setRoutTpCd(String routTpCd) {
		this.routTpCd = routTpCd;
	}
	
	/**
	 * Column Info
	 * @param routCostSeq
	 */
	public void setRoutCostSeq(String routCostSeq) {
		this.routCostSeq = routCostSeq;
	}
	
	/**
	 * Column Info
	 * @param scqVerNo
	 */
	public void setScqVerNo(String scqVerNo) {
		this.scqVerNo = scqVerNo;
	}
	
	/**
	 * Column Info
	 * @param routSeqVerNo
	 */
	public void setRoutSeqVerNo(String routSeqVerNo) {
		this.routSeqVerNo = routSeqVerNo;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param bbCgoTpSeq
	 */
	public void setBbCgoTpSeq(String bbCgoTpSeq) {
		this.bbCgoTpSeq = bbCgoTpSeq;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}
	
	/**
	 * Column Info
	 * @param exRate
	 */
	public void setExRate(String exRate) {
		this.exRate = exRate;
	}
	
	/**
	 * Column Info
	 * @param scqRqstNo
	 */
	public void setScqRqstNo(String scqRqstNo) {
		this.scqRqstNo = scqRqstNo;
	}
	
	/**
	 * Column Info
	 * @param bbCgoDesc
	 */
	public void setBbCgoDesc(String bbCgoDesc) {
		this.bbCgoDesc = bbCgoDesc;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRoutRmk(JSPUtil.getParameter(request, prefix + "rout_rmk", ""));
		setLoclCurrAmt(JSPUtil.getParameter(request, prefix + "locl_curr_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRoutTpCd(JSPUtil.getParameter(request, prefix + "rout_tp_cd", ""));
		setRoutCostSeq(JSPUtil.getParameter(request, prefix + "rout_cost_seq", ""));
		setScqVerNo(JSPUtil.getParameter(request, prefix + "scq_ver_no", ""));
		setRoutSeqVerNo(JSPUtil.getParameter(request, prefix + "rout_seq_ver_no", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setBbCgoTpSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_tp_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setExRate(JSPUtil.getParameter(request, prefix + "ex_rate", ""));
		setScqRqstNo(JSPUtil.getParameter(request, prefix + "scq_rqst_no", ""));
		setBbCgoDesc(JSPUtil.getParameter(request, prefix + "bb_cgo_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScqBbRoutCostVO[]
	 */
	public PriScqBbRoutCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScqBbRoutCostVO[]
	 */
	public PriScqBbRoutCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScqBbRoutCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] routRmk = (JSPUtil.getParameter(request, prefix	+ "rout_rmk", length));
			String[] loclCurrAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] routTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_tp_cd", length));
			String[] routCostSeq = (JSPUtil.getParameter(request, prefix	+ "rout_cost_seq", length));
			String[] scqVerNo = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no", length));
			String[] routSeqVerNo = (JSPUtil.getParameter(request, prefix	+ "rout_seq_ver_no", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] bbCgoTpSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_tp_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate", length));
			String[] scqRqstNo = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no", length));
			String[] bbCgoDesc = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScqBbRoutCostVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (routRmk[i] != null)
					model.setRoutRmk(routRmk[i]);
				if (loclCurrAmt[i] != null)
					model.setLoclCurrAmt(loclCurrAmt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (routTpCd[i] != null)
					model.setRoutTpCd(routTpCd[i]);
				if (routCostSeq[i] != null)
					model.setRoutCostSeq(routCostSeq[i]);
				if (scqVerNo[i] != null)
					model.setScqVerNo(scqVerNo[i]);
				if (routSeqVerNo[i] != null)
					model.setRoutSeqVerNo(routSeqVerNo[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (bbCgoTpSeq[i] != null)
					model.setBbCgoTpSeq(bbCgoTpSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (scqRqstNo[i] != null)
					model.setScqRqstNo(scqRqstNo[i]);
				if (bbCgoDesc[i] != null)
					model.setBbCgoDesc(bbCgoDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScqBbRoutCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScqBbRoutCostVO[]
	 */
	public PriScqBbRoutCostVO[] getPriScqBbRoutCostVOs(){
		PriScqBbRoutCostVO[] vos = (PriScqBbRoutCostVO[])models.toArray(new PriScqBbRoutCostVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routRmk = this.routRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrAmt = this.loclCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routTpCd = this.routTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCostSeq = this.routCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNo = this.scqVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeqVerNo = this.routSeqVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoTpSeq = this.bbCgoTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNo = this.scqRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoDesc = this.bbCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
