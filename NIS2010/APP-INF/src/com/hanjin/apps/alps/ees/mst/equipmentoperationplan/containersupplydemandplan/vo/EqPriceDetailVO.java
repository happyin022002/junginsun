/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EqPriceDetailVO.java
*@FileTitle : EqPriceDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.20 이호선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqPriceDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqPriceDetailVO> models = new ArrayList<EqPriceDetailVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String stl3 = null;
	/* Column Info */
	private String delflg = null;
	/* Column Info */
	private String purPrc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String insflg = null;
	/* Column Info */
	private String purUtPrc = null;
	/* Column Info */
	private String stl2 = null;
	/* Column Info */
	private String stl1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String eqQty = null;
	/* Column Info */
	private String updflg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String codeNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String drygAmt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrAbbrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqPriceDetailVO() {}

	public EqPriceDetailVO(String ibflag, String pagerows, String updDt, String delflg, String stl3, String currCd, String purPrc, String insflg, String creDt, String purUtPrc, String eqKndCd, String stl2, String stl1, String drygAmt, String eqTpszCd, String bseYrmon, String locCd, String creUsrId, String eqQty, String vndrSeq, String updflg, String vndrAbbrNm, String updUsrId, String code, String codeNm, String diffRmk) {
		this.currCd = currCd;
		this.stl3 = stl3;
		this.delflg = delflg;
		this.purPrc = purPrc;
		this.creDt = creDt;
		this.insflg = insflg;
		this.purUtPrc = purUtPrc;
		this.stl2 = stl2;
		this.stl1 = stl1;
		this.pagerows = pagerows;
		this.bseYrmon = bseYrmon;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.eqQty = eqQty;
		this.updflg = updflg;
		this.updUsrId = updUsrId;
		this.codeNm = codeNm;
		this.updDt = updDt;
		this.eqKndCd = eqKndCd;
		this.code = code;
		this.drygAmt = drygAmt;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.vndrSeq = vndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("stl3", getStl3());
		this.hashColumns.put("delflg", getDelflg());
		this.hashColumns.put("pur_prc", getPurPrc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("insflg", getInsflg());
		this.hashColumns.put("pur_ut_prc", getPurUtPrc());
		this.hashColumns.put("stl2", getStl2());
		this.hashColumns.put("stl1", getStl1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eq_qty", getEqQty());
		this.hashColumns.put("updflg", getUpdflg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("code_nm", getCodeNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("dryg_amt", getDrygAmt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("stl3", "stl3");
		this.hashFields.put("delflg", "delflg");
		this.hashFields.put("pur_prc", "purPrc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("insflg", "insflg");
		this.hashFields.put("pur_ut_prc", "purUtPrc");
		this.hashFields.put("stl2", "stl2");
		this.hashFields.put("stl1", "stl1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eq_qty", "eqQty");
		this.hashFields.put("updflg", "updflg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("code_nm", "codeNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("code", "code");
		this.hashFields.put("dryg_amt", "drygAmt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		return this.hashFields;
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
	 * @return stl3
	 */
	public String getStl3() {
		return this.stl3;
	}
	
	/**
	 * Column Info
	 * @return delflg
	 */
	public String getDelflg() {
		return this.delflg;
	}
	
	/**
	 * Column Info
	 * @return purPrc
	 */
	public String getPurPrc() {
		return this.purPrc;
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
	 * @return insflg
	 */
	public String getInsflg() {
		return this.insflg;
	}
	
	/**
	 * Column Info
	 * @return purUtPrc
	 */
	public String getPurUtPrc() {
		return this.purUtPrc;
	}
	
	/**
	 * Column Info
	 * @return stl2
	 */
	public String getStl2() {
		return this.stl2;
	}
	
	/**
	 * Column Info
	 * @return stl1
	 */
	public String getStl1() {
		return this.stl1;
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
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return this.bseYrmon;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return eqQty
	 */
	public String getEqQty() {
		return this.eqQty;
	}
	
	/**
	 * Column Info
	 * @return updflg
	 */
	public String getUpdflg() {
		return this.updflg;
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
	 * @return codeNm
	 */
	public String getCodeNm() {
		return this.codeNm;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return drygAmt
	 */
	public String getDrygAmt() {
		return this.drygAmt;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
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
	 * @param stl3
	 */
	public void setStl3(String stl3) {
		this.stl3 = stl3;
	}
	
	/**
	 * Column Info
	 * @param delflg
	 */
	public void setDelflg(String delflg) {
		this.delflg = delflg;
	}
	
	/**
	 * Column Info
	 * @param purPrc
	 */
	public void setPurPrc(String purPrc) {
		this.purPrc = purPrc;
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
	 * @param insflg
	 */
	public void setInsflg(String insflg) {
		this.insflg = insflg;
	}
	
	/**
	 * Column Info
	 * @param purUtPrc
	 */
	public void setPurUtPrc(String purUtPrc) {
		this.purUtPrc = purUtPrc;
	}
	
	/**
	 * Column Info
	 * @param stl2
	 */
	public void setStl2(String stl2) {
		this.stl2 = stl2;
	}
	
	/**
	 * Column Info
	 * @param stl1
	 */
	public void setStl1(String stl1) {
		this.stl1 = stl1;
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
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param eqQty
	 */
	public void setEqQty(String eqQty) {
		this.eqQty = eqQty;
	}
	
	/**
	 * Column Info
	 * @param updflg
	 */
	public void setUpdflg(String updflg) {
		this.updflg = updflg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param codeNm
	 */
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param drygAmt
	 */
	public void setDrygAmt(String drygAmt) {
		this.drygAmt = drygAmt;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setStl3(JSPUtil.getParameter(request, prefix + "stl3", ""));
		setDelflg(JSPUtil.getParameter(request, prefix + "delflg", ""));
		setPurPrc(JSPUtil.getParameter(request, prefix + "pur_prc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInsflg(JSPUtil.getParameter(request, prefix + "insflg", ""));
		setPurUtPrc(JSPUtil.getParameter(request, prefix + "pur_ut_prc", ""));
		setStl2(JSPUtil.getParameter(request, prefix + "stl2", ""));
		setStl1(JSPUtil.getParameter(request, prefix + "stl1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseYrmon(JSPUtil.getParameter(request, prefix + "bse_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEqQty(JSPUtil.getParameter(request, prefix + "eq_qty", ""));
		setUpdflg(JSPUtil.getParameter(request, prefix + "updflg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCodeNm(JSPUtil.getParameter(request, prefix + "code_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setDrygAmt(JSPUtil.getParameter(request, prefix + "dryg_amt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqPriceDetailVO[]
	 */
	public EqPriceDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqPriceDetailVO[]
	 */
	public EqPriceDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqPriceDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] stl3 = (JSPUtil.getParameter(request, prefix	+ "stl3", length));
			String[] delflg = (JSPUtil.getParameter(request, prefix	+ "delflg", length));
			String[] purPrc = (JSPUtil.getParameter(request, prefix	+ "pur_prc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] insflg = (JSPUtil.getParameter(request, prefix	+ "insflg", length));
			String[] purUtPrc = (JSPUtil.getParameter(request, prefix	+ "pur_ut_prc", length));
			String[] stl2 = (JSPUtil.getParameter(request, prefix	+ "stl2", length));
			String[] stl1 = (JSPUtil.getParameter(request, prefix	+ "stl1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] eqQty = (JSPUtil.getParameter(request, prefix	+ "eq_qty", length));
			String[] updflg = (JSPUtil.getParameter(request, prefix	+ "updflg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] codeNm = (JSPUtil.getParameter(request, prefix	+ "code_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] drygAmt = (JSPUtil.getParameter(request, prefix	+ "dryg_amt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqPriceDetailVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (stl3[i] != null)
					model.setStl3(stl3[i]);
				if (delflg[i] != null)
					model.setDelflg(delflg[i]);
				if (purPrc[i] != null)
					model.setPurPrc(purPrc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (insflg[i] != null)
					model.setInsflg(insflg[i]);
				if (purUtPrc[i] != null)
					model.setPurUtPrc(purUtPrc[i]);
				if (stl2[i] != null)
					model.setStl2(stl2[i]);
				if (stl1[i] != null)
					model.setStl1(stl1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (eqQty[i] != null)
					model.setEqQty(eqQty[i]);
				if (updflg[i] != null)
					model.setUpdflg(updflg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (codeNm[i] != null)
					model.setCodeNm(codeNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (drygAmt[i] != null)
					model.setDrygAmt(drygAmt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqPriceDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqPriceDetailVO[]
	 */
	public EqPriceDetailVO[] getEqPriceDetailVOs(){
		EqPriceDetailVO[] vos = (EqPriceDetailVO[])models.toArray(new EqPriceDetailVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stl3 = this.stl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delflg = this.delflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purPrc = this.purPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insflg = this.insflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purUtPrc = this.purUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stl2 = this.stl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stl1 = this.stl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqQty = this.eqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updflg = this.updflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeNm = this.codeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drygAmt = this.drygAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
