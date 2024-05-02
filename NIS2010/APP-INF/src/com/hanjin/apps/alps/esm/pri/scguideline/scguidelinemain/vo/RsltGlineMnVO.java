/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltGlineMnVO.java
 *@FileTitle : RsltGlineMnVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.12
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.12 박성수 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo;

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
 * @author 박성수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltGlineMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltGlineMnVO> models = new ArrayList<RsltGlineMnVO>();

	/* Column Info */
	private String gohCnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ctrtCnt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String arbCnt = null;
	/* Column Info */
	private String locCnt = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cmdtCnt = null;
	/* Column Info */
	private String salesCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String rateCnt = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltGlineMnVO() {
	}

	public RsltGlineMnVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String effDt, String expDt,
			String cfmFlg, String cfmUsrId, String cfmOfcCd, String creUsrId, String creUsrNm, String creOfcCd,
			String creDt, String updUsrId, String updDt, String salesCnt, String locCnt, String cmdtCnt, String arbCnt,
			String rateCnt, String gohCnt, String ctrtCnt) {
		this.gohCnt = gohCnt;
		this.updDt = updDt;
		this.ctrtCnt = ctrtCnt;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.arbCnt = arbCnt;
		this.locCnt = locCnt;
		this.glineSeq = glineSeq;
		this.creUsrNm = creUsrNm;
		this.cfmFlg = cfmFlg;
		this.pagerows = pagerows;
		this.cmdtCnt = cmdtCnt;
		this.salesCnt = salesCnt;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.cfmOfcCd = cfmOfcCd;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.rateCnt = rateCnt;
		this.cfmUsrId = cfmUsrId;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("goh_cnt", getGohCnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ctrt_cnt", getCtrtCnt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("arb_cnt", getArbCnt());
		this.hashColumns.put("loc_cnt", getLocCnt());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cmdt_cnt", getCmdtCnt());
		this.hashColumns.put("sales_cnt", getSalesCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rate_cnt", getRateCnt());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("goh_cnt", "gohCnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ctrt_cnt", "ctrtCnt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("arb_cnt", "arbCnt");
		this.hashFields.put("loc_cnt", "locCnt");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cmdt_cnt", "cmdtCnt");
		this.hashFields.put("sales_cnt", "salesCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rate_cnt", "rateCnt");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return gohCnt
	 */
	public String getGohCnt() {
		return this.gohCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return ctrtCnt
	 */
	public String getCtrtCnt() {
		return this.ctrtCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return arbCnt
	 */
	public String getArbCnt() {
		return this.arbCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return locCnt
	 */
	public String getLocCnt() {
		return this.locCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}

	/**
	 * Column Info
	 * 
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return cmdtCnt
	 */
	public String getCmdtCnt() {
		return this.cmdtCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return salesCnt
	 */
	public String getSalesCnt() {
		return this.salesCnt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}

	/**
	 * Column Info
	 * 
	 * @return cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return rateCnt
	 */
	public String getRateCnt() {
		return this.rateCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param gohCnt
	 */
	public void setGohCnt(String gohCnt) {
		this.gohCnt = gohCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param ctrtCnt
	 */
	public void setCtrtCnt(String ctrtCnt) {
		this.ctrtCnt = ctrtCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param arbCnt
	 */
	public void setArbCnt(String arbCnt) {
		this.arbCnt = arbCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param locCnt
	 */
	public void setLocCnt(String locCnt) {
		this.locCnt = locCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}

	/**
	 * Column Info
	 * 
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param cmdtCnt
	 */
	public void setCmdtCnt(String cmdtCnt) {
		this.cmdtCnt = cmdtCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param salesCnt
	 */
	public void setSalesCnt(String salesCnt) {
		this.salesCnt = salesCnt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	/**
	 * Column Info
	 * 
	 * @param cfmOfcCd
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param rateCnt
	 */
	public void setRateCnt(String rateCnt) {
		this.rateCnt = rateCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGohCnt(JSPUtil.getParameter(request, "goh_cnt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCtrtCnt(JSPUtil.getParameter(request, "ctrt_cnt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setArbCnt(JSPUtil.getParameter(request, "arb_cnt", ""));
		setLocCnt(JSPUtil.getParameter(request, "loc_cnt", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setCreUsrNm(JSPUtil.getParameter(request, "cre_usr_nm", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCmdtCnt(JSPUtil.getParameter(request, "cmdt_cnt", ""));
		setSalesCnt(JSPUtil.getParameter(request, "sales_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, "cfm_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setRateCnt(JSPUtil.getParameter(request, "rate_cnt", ""));
		setCfmUsrId(JSPUtil.getParameter(request, "cfm_usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return RsltGlineMnVO[]
	 */
	public RsltGlineMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return RsltGlineMnVO[]
	 */
	public RsltGlineMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltGlineMnVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] gohCnt = (JSPUtil.getParameter(request, prefix + "goh_cnt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] ctrtCnt = (JSPUtil.getParameter(request, prefix + "ctrt_cnt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] arbCnt = (JSPUtil.getParameter(request, prefix + "arb_cnt", length));
			String[] locCnt = (JSPUtil.getParameter(request, prefix + "loc_cnt", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix + "cre_usr_nm", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix + "cfm_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] cmdtCnt = (JSPUtil.getParameter(request, prefix + "cmdt_cnt", length));
			String[] salesCnt = (JSPUtil.getParameter(request, prefix + "sales_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix + "cfm_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] rateCnt = (JSPUtil.getParameter(request, prefix + "rate_cnt", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix + "cfm_usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix + "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new RsltGlineMnVO();
				if (gohCnt[i] != null)
					model.setGohCnt(gohCnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ctrtCnt[i] != null)
					model.setCtrtCnt(ctrtCnt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (arbCnt[i] != null)
					model.setArbCnt(arbCnt[i]);
				if (locCnt[i] != null)
					model.setLocCnt(locCnt[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cmdtCnt[i] != null)
					model.setCmdtCnt(cmdtCnt[i]);
				if (salesCnt[i] != null)
					model.setSalesCnt(salesCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (rateCnt[i] != null)
					model.setRateCnt(rateCnt[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltGlineMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return RsltGlineMnVO[]
	 */
	public RsltGlineMnVO[] getRsltGlineMnVOs() {
		RsltGlineMnVO[] vos = (RsltGlineMnVO[]) models.toArray(new RsltGlineMnVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.gohCnt = this.gohCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCnt = this.ctrtCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbCnt = this.arbCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCnt = this.locCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCnt = this.cmdtCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesCnt = this.salesCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateCnt = this.rateCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
