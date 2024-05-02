/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpMnSCCpVO.java
*@FileTitle : RsltPriSpMnSCCpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.04 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpMnSCCpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpMnSCCpVO> models = new ArrayList<RsltPriSpMnSCCpVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ihc = null;
	/* Column Info */
	private String scp = null;
	/* Column Info */
	private String splNote = null;
	/* Column Info */
	private String grpCmdt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String destArb = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String org = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grpLoc = null;
	/* Column Info */
	private String goh = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dest = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String ldAgent = null;
	/* Column Info */
	private String stndNote = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String oriArb = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpMnSCCpVO() {}

	public RsltPriSpMnSCCpVO(String ibflag, String pagerows, String svcScpCd, String scp, String org, String dest, String grpLoc, String grpCmdt, String oriArb, String destArb, String rate, String stndNote, String splNote, String ldAgent, String ihc, String goh, String propNo, String amdtSeq, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ihc = ihc;
		this.scp = scp;
		this.splNote = splNote;
		this.grpCmdt = grpCmdt;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.destArb = destArb;
		this.creDt = creDt;
		this.org = org;
		this.pagerows = pagerows;
		this.grpLoc = grpLoc;
		this.goh = goh;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.dest = dest;
		this.rate = rate;
		this.ldAgent = ldAgent;
		this.stndNote = stndNote;
		this.propNo = propNo;
		this.oriArb = oriArb;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ihc", getIhc());
		this.hashColumns.put("scp", getScp());
		this.hashColumns.put("spl_note", getSplNote());
		this.hashColumns.put("grp_cmdt", getGrpCmdt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dest_arb", getDestArb());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org", getOrg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grp_loc", getGrpLoc());
		this.hashColumns.put("goh", getGoh());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest", getDest());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("ld_agent", getLdAgent());
		this.hashColumns.put("stnd_note", getStndNote());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("ori_arb", getOriArb());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ihc", "ihc");
		this.hashFields.put("scp", "scp");
		this.hashFields.put("spl_note", "splNote");
		this.hashFields.put("grp_cmdt", "grpCmdt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dest_arb", "destArb");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org", "org");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grp_loc", "grpLoc");
		this.hashFields.put("goh", "goh");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest", "dest");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("ld_agent", "ldAgent");
		this.hashFields.put("stnd_note", "stndNote");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("ori_arb", "oriArb");
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
	 * @return ihc
	 */
	public String getIhc() {
		return this.ihc;
	}
	
	/**
	 * Column Info
	 * @return scp
	 */
	public String getScp() {
		return this.scp;
	}
	
	/**
	 * Column Info
	 * @return splNote
	 */
	public String getSplNote() {
		return this.splNote;
	}
	
	/**
	 * Column Info
	 * @return grpCmdt
	 */
	public String getGrpCmdt() {
		return this.grpCmdt;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return destArb
	 */
	public String getDestArb() {
		return this.destArb;
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
	 * @return org
	 */
	public String getOrg() {
		return this.org;
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
	 * @return grpLoc
	 */
	public String getGrpLoc() {
		return this.grpLoc;
	}
	
	/**
	 * Column Info
	 * @return goh
	 */
	public String getGoh() {
		return this.goh;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return dest
	 */
	public String getDest() {
		return this.dest;
	}
	
	/**
	 * Column Info
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return ldAgent
	 */
	public String getLdAgent() {
		return this.ldAgent;
	}
	
	/**
	 * Column Info
	 * @return stndNote
	 */
	public String getStndNote() {
		return this.stndNote;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return oriArb
	 */
	public String getOriArb() {
		return this.oriArb;
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
	 * @param ihc
	 */
	public void setIhc(String ihc) {
		this.ihc = ihc;
	}
	
	/**
	 * Column Info
	 * @param scp
	 */
	public void setScp(String scp) {
		this.scp = scp;
	}
	
	/**
	 * Column Info
	 * @param splNote
	 */
	public void setSplNote(String splNote) {
		this.splNote = splNote;
	}
	
	/**
	 * Column Info
	 * @param grpCmdt
	 */
	public void setGrpCmdt(String grpCmdt) {
		this.grpCmdt = grpCmdt;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param destArb
	 */
	public void setDestArb(String destArb) {
		this.destArb = destArb;
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
	 * @param org
	 */
	public void setOrg(String org) {
		this.org = org;
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
	 * @param grpLoc
	 */
	public void setGrpLoc(String grpLoc) {
		this.grpLoc = grpLoc;
	}
	
	/**
	 * Column Info
	 * @param goh
	 */
	public void setGoh(String goh) {
		this.goh = goh;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param dest
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	/**
	 * Column Info
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param ldAgent
	 */
	public void setLdAgent(String ldAgent) {
		this.ldAgent = ldAgent;
	}
	
	/**
	 * Column Info
	 * @param stndNote
	 */
	public void setStndNote(String stndNote) {
		this.stndNote = stndNote;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param oriArb
	 */
	public void setOriArb(String oriArb) {
		this.oriArb = oriArb;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIhc(JSPUtil.getParameter(request, "ihc", ""));
		setScp(JSPUtil.getParameter(request, "scp", ""));
		setSplNote(JSPUtil.getParameter(request, "spl_note", ""));
		setGrpCmdt(JSPUtil.getParameter(request, "grp_cmdt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setDestArb(JSPUtil.getParameter(request, "dest_arb", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOrg(JSPUtil.getParameter(request, "org", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGrpLoc(JSPUtil.getParameter(request, "grp_loc", ""));
		setGoh(JSPUtil.getParameter(request, "goh", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDest(JSPUtil.getParameter(request, "dest", ""));
		setRate(JSPUtil.getParameter(request, "rate", ""));
		setLdAgent(JSPUtil.getParameter(request, "ld_agent", ""));
		setStndNote(JSPUtil.getParameter(request, "stnd_note", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setOriArb(JSPUtil.getParameter(request, "ori_arb", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpMnSCCpVO[]
	 */
	public RsltPriSpMnSCCpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpMnSCCpVO[]
	 */
	public RsltPriSpMnSCCpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpMnSCCpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] ihc = (JSPUtil.getParameter(request, prefix	+ "ihc".trim(), length));
			String[] scp = (JSPUtil.getParameter(request, prefix	+ "scp".trim(), length));
			String[] splNote = (JSPUtil.getParameter(request, prefix	+ "spl_note".trim(), length));
			String[] grpCmdt = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt".trim(), length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] destArb = (JSPUtil.getParameter(request, prefix	+ "dest_arb".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] org = (JSPUtil.getParameter(request, prefix	+ "org".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] grpLoc = (JSPUtil.getParameter(request, prefix	+ "grp_loc".trim(), length));
			String[] goh = (JSPUtil.getParameter(request, prefix	+ "goh".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] dest = (JSPUtil.getParameter(request, prefix	+ "dest".trim(), length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate".trim(), length));
			String[] ldAgent = (JSPUtil.getParameter(request, prefix	+ "ld_agent".trim(), length));
			String[] stndNote = (JSPUtil.getParameter(request, prefix	+ "stnd_note".trim(), length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no".trim(), length));
			String[] oriArb = (JSPUtil.getParameter(request, prefix	+ "ori_arb".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpMnSCCpVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ihc[i] != null)
					model.setIhc(ihc[i]);
				if (scp[i] != null)
					model.setScp(scp[i]);
				if (splNote[i] != null)
					model.setSplNote(splNote[i]);
				if (grpCmdt[i] != null)
					model.setGrpCmdt(grpCmdt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (destArb[i] != null)
					model.setDestArb(destArb[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (org[i] != null)
					model.setOrg(org[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grpLoc[i] != null)
					model.setGrpLoc(grpLoc[i]);
				if (goh[i] != null)
					model.setGoh(goh[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dest[i] != null)
					model.setDest(dest[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (ldAgent[i] != null)
					model.setLdAgent(ldAgent[i]);
				if (stndNote[i] != null)
					model.setStndNote(stndNote[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (oriArb[i] != null)
					model.setOriArb(oriArb[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpMnSCCpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpMnSCCpVO[]
	 */
	public RsltPriSpMnSCCpVO[] getRsltPriSpMnSCCpVOs(){
		RsltPriSpMnSCCpVO[] vos = (RsltPriSpMnSCCpVO[])models.toArray(new RsltPriSpMnSCCpVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihc = this.ihc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scp = this.scp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splNote = this.splNote .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdt = this.grpCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destArb = this.destArb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.org = this.org .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLoc = this.grpLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goh = this.goh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dest = this.dest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldAgent = this.ldAgent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndNote = this.stndNote .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriArb = this.oriArb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
