/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GlineMnCpVO.java
*@FileTitle : GlineMnCpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.23 김재연 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김재연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GlineMnCpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GlineMnCpVO> models = new ArrayList<GlineMnCpVO>();
	
	/* Column Info */
	private String trgtGlineSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String destArb = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String trgtEffDt = null;
	/* Column Info */
	private String orgArb = null;
	/* Column Info */
	private String glineSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String goh = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String trgtExpDt = null;
	/* Column Info */
	private String locGrp = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cmdtGrp = null;
	/* Column Info */
	private String trgtSvcScpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GlineMnCpVO() {}

	public GlineMnCpVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String locGrp, String cmdtGrp, String orgArb, String destArb, String rate, String goh, String trgtSvcScpCd, String trgtGlineSeq, String trgtEffDt, String trgtExpDt, String creUsrId, String updUsrId, String orgDestTpCd) {
		this.trgtGlineSeq = trgtGlineSeq;
		this.svcScpCd = svcScpCd;
		this.destArb = destArb;
		this.orgDestTpCd = orgDestTpCd;
		this.trgtEffDt = trgtEffDt;
		this.orgArb = orgArb;
		this.glineSeq = glineSeq;
		this.pagerows = pagerows;
		this.goh = goh;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.rate = rate;
		this.trgtExpDt = trgtExpDt;
		this.locGrp = locGrp;
		this.updUsrId = updUsrId;
		this.cmdtGrp = cmdtGrp;
		this.trgtSvcScpCd = trgtSvcScpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trgt_gline_seq", getTrgtGlineSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dest_arb", getDestArb());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("trgt_eff_dt", getTrgtEffDt());
		this.hashColumns.put("org_arb", getOrgArb());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("goh", getGoh());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("trgt_exp_dt", getTrgtExpDt());
		this.hashColumns.put("loc_grp", getLocGrp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cmdt_grp", getCmdtGrp());
		this.hashColumns.put("trgt_svc_scp_cd", getTrgtSvcScpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trgt_gline_seq", "trgtGlineSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dest_arb", "destArb");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("trgt_eff_dt", "trgtEffDt");
		this.hashFields.put("org_arb", "orgArb");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("goh", "goh");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("trgt_exp_dt", "trgtExpDt");
		this.hashFields.put("loc_grp", "locGrp");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cmdt_grp", "cmdtGrp");
		this.hashFields.put("trgt_svc_scp_cd", "trgtSvcScpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trgtGlineSeq
	 */
	public String getTrgtGlineSeq() {
		return this.trgtGlineSeq;
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
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return trgtEffDt
	 */
	public String getTrgtEffDt() {
		return this.trgtEffDt;
	}
	
	/**
	 * Column Info
	 * @return orgArb
	 */
	public String getOrgArb() {
		return this.orgArb;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return trgtExpDt
	 */
	public String getTrgtExpDt() {
		return this.trgtExpDt;
	}
	
	/**
	 * Column Info
	 * @return locGrp
	 */
	public String getLocGrp() {
		return this.locGrp;
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
	 * @return cmdtGrp
	 */
	public String getCmdtGrp() {
		return this.cmdtGrp;
	}
	
	/**
	 * Column Info
	 * @return trgtSvcScpCd
	 */
	public String getTrgtSvcScpCd() {
		return this.trgtSvcScpCd;
	}
	

	/**
	 * Column Info
	 * @param trgtGlineSeq
	 */
	public void setTrgtGlineSeq(String trgtGlineSeq) {
		this.trgtGlineSeq = trgtGlineSeq;
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
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param trgtEffDt
	 */
	public void setTrgtEffDt(String trgtEffDt) {
		this.trgtEffDt = trgtEffDt;
	}
	
	/**
	 * Column Info
	 * @param orgArb
	 */
	public void setOrgArb(String orgArb) {
		this.orgArb = orgArb;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param trgtExpDt
	 */
	public void setTrgtExpDt(String trgtExpDt) {
		this.trgtExpDt = trgtExpDt;
	}
	
	/**
	 * Column Info
	 * @param locGrp
	 */
	public void setLocGrp(String locGrp) {
		this.locGrp = locGrp;
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
	 * @param cmdtGrp
	 */
	public void setCmdtGrp(String cmdtGrp) {
		this.cmdtGrp = cmdtGrp;
	}
	
	/**
	 * Column Info
	 * @param trgtSvcScpCd
	 */
	public void setTrgtSvcScpCd(String trgtSvcScpCd) {
		this.trgtSvcScpCd = trgtSvcScpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrgtGlineSeq(JSPUtil.getParameter(request, "trgt_gline_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setDestArb(JSPUtil.getParameter(request, "dest_arb", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setTrgtEffDt(JSPUtil.getParameter(request, "trgt_eff_dt", ""));
		setOrgArb(JSPUtil.getParameter(request, "org_arb", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGoh(JSPUtil.getParameter(request, "goh", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRate(JSPUtil.getParameter(request, "rate", ""));
		setTrgtExpDt(JSPUtil.getParameter(request, "trgt_exp_dt", ""));
		setLocGrp(JSPUtil.getParameter(request, "loc_grp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCmdtGrp(JSPUtil.getParameter(request, "cmdt_grp", ""));
		setTrgtSvcScpCd(JSPUtil.getParameter(request, "trgt_svc_scp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GlineMnCpVO[]
	 */
	public GlineMnCpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GlineMnCpVO[]
	 */
	public GlineMnCpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GlineMnCpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trgtGlineSeq = (JSPUtil.getParameter(request, prefix	+ "trgt_gline_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] destArb = (JSPUtil.getParameter(request, prefix	+ "dest_arb", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] trgtEffDt = (JSPUtil.getParameter(request, prefix	+ "trgt_eff_dt", length));
			String[] orgArb = (JSPUtil.getParameter(request, prefix	+ "org_arb", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] goh = (JSPUtil.getParameter(request, prefix	+ "goh", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] trgtExpDt = (JSPUtil.getParameter(request, prefix	+ "trgt_exp_dt", length));
			String[] locGrp = (JSPUtil.getParameter(request, prefix	+ "loc_grp", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cmdtGrp = (JSPUtil.getParameter(request, prefix	+ "cmdt_grp", length));
			String[] trgtSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "trgt_svc_scp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GlineMnCpVO();
				if (trgtGlineSeq[i] != null)
					model.setTrgtGlineSeq(trgtGlineSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (destArb[i] != null)
					model.setDestArb(destArb[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (trgtEffDt[i] != null)
					model.setTrgtEffDt(trgtEffDt[i]);
				if (orgArb[i] != null)
					model.setOrgArb(orgArb[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (goh[i] != null)
					model.setGoh(goh[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (trgtExpDt[i] != null)
					model.setTrgtExpDt(trgtExpDt[i]);
				if (locGrp[i] != null)
					model.setLocGrp(locGrp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cmdtGrp[i] != null)
					model.setCmdtGrp(cmdtGrp[i]);
				if (trgtSvcScpCd[i] != null)
					model.setTrgtSvcScpCd(trgtSvcScpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGlineMnCpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GlineMnCpVO[]
	 */
	public GlineMnCpVO[] getGlineMnCpVOs(){
		GlineMnCpVO[] vos = (GlineMnCpVO[])models.toArray(new GlineMnCpVO[models.size()]);
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
		this.trgtGlineSeq = this.trgtGlineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destArb = this.destArb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trgtEffDt = this.trgtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgArb = this.orgArb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goh = this.goh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trgtExpDt = this.trgtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrp = this.locGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtGrp = this.cmdtGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trgtSvcScpCd = this.trgtSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
