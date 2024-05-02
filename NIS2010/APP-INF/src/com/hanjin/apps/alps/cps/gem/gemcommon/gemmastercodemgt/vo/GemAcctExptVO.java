/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemAcctExptVO.java
*@FileTitle : GemAcctExptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.04 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 진윤오
 * @since J2EE 1.5
 */

public class GemAcctExptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemAcctExptVO> models = new ArrayList<GemAcctExptVO>();
	
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String acctCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String sprtYrmon = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sprtGenExpnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemAcctExptVO() {}

	public GemAcctExptVO(String ibflag, String pagerows, String ofcCd, String genExpnCd, String acctCd, String sprtGenExpnCd, String sprtYrmon, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updUsrId = updUsrId;
		this.acctCd = acctCd;
		this.ibflag = ibflag;
		this.updDt = updDt;
		this.creDt = creDt;
		this.deltFlg = deltFlg;
		this.sprtYrmon = sprtYrmon;
		this.genExpnCd = genExpnCd;
		this.creUsrId = creUsrId;
		this.sprtGenExpnCd = sprtGenExpnCd;
		this.ofcCd = ofcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("sprt_yrmon", getSprtYrmon());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sprt_gen_expn_cd", getSprtGenExpnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("sprt_yrmon", "sprtYrmon");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sprt_gen_expn_cd", "sprtGenExpnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getSprtYrmon() {
		return this.sprtYrmon;
	}
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getSprtGenExpnCd() {
		return this.sprtGenExpnCd;
	}
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setSprtYrmon(String sprtYrmon) {
		this.sprtYrmon = sprtYrmon;
		//this.sprtYrmon=true;
	}
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
		//this.genExpnCd=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setSprtGenExpnCd(String sprtGenExpnCd) {
		this.sprtGenExpnCd = sprtGenExpnCd;
		//this.sprtGenExpnCd=true;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
		//this.ofcCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSprtYrmon(JSPUtil.getParameter(request, "sprt_yrmon", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSprtGenExpnCd(JSPUtil.getParameter(request, "sprt_gen_expn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public GemAcctExptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public GemAcctExptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemAcctExptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] sprtYrmon = (JSPUtil.getParameter(request, prefix	+ "sprt_yrmon".trim(), length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] sprtGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "sprt_gen_expn_cd".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new GemAcctExptVO();
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (sprtYrmon[i] != null)
					model.setSprtYrmon(sprtYrmon[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sprtGenExpnCd[i] != null)
					model.setSprtGenExpnCd(sprtGenExpnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getGemAcctExptVOs();
	}

	public GemAcctExptVO[] getGemAcctExptVOs(){
		GemAcctExptVO[] vos = (GemAcctExptVO[])models.toArray(new GemAcctExptVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtYrmon = this.sprtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGenExpnCd = this.sprtGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
