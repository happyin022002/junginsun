/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemXchRtVO.java
*@FileTitle : GemXchRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.04.29 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 진윤오
 * @since J2EE 1.5
 */

public class GemXchRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemXchRtVO> models = new ArrayList<GemXchRtVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String usdKrwXchRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String loclKrwXchRt = null;
	/* Column Info */
	private String genExpnXchRtDivCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String acctXchRtYrmon = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemXchRtVO() {}

	public GemXchRtVO(String ibflag, String pagerows, String acctXchRtYrmon, String genExpnXchRtDivCd, String currCd, String usdLoclXchRt, String loclKrwXchRt, String usdKrwXchRt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ibflag = ibflag;
		this.usdKrwXchRt = usdKrwXchRt;
		this.updUsrId = updUsrId;
		this.loclKrwXchRt = loclKrwXchRt;
		this.genExpnXchRtDivCd = genExpnXchRtDivCd;
		this.updDt = updDt;
		this.usdLoclXchRt = usdLoclXchRt;
		this.creDt = creDt;
		this.deltFlg = deltFlg;
		this.currCd = currCd;
		this.creUsrId = creUsrId;
		this.acctXchRtYrmon = acctXchRtYrmon;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usd_krw_xch_rt", getUsdKrwXchRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("locl_krw_xch_rt", getLoclKrwXchRt());
		this.hashColumns.put("gen_expn_xch_rt_div_cd", getGenExpnXchRtDivCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("acct_xch_rt_yrmon", getAcctXchRtYrmon());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usd_krw_xch_rt", "usdKrwXchRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("locl_krw_xch_rt", "loclKrwXchRt");
		this.hashFields.put("gen_expn_xch_rt_div_cd", "genExpnXchRtDivCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("acct_xch_rt_yrmon", "acctXchRtYrmon");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getUsdKrwXchRt() {
		return this.usdKrwXchRt;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getLoclKrwXchRt() {
		return this.loclKrwXchRt;
	}
	public String getGenExpnXchRtDivCd() {
		return this.genExpnXchRtDivCd;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getUsdLoclXchRt() {
		return this.usdLoclXchRt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getCurrCd() {
		return this.currCd;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getAcctXchRtYrmon() {
		return this.acctXchRtYrmon;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setUsdKrwXchRt(String usdKrwXchRt) {
		this.usdKrwXchRt = usdKrwXchRt;
		//this.usdKrwXchRt=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setLoclKrwXchRt(String loclKrwXchRt) {
		this.loclKrwXchRt = loclKrwXchRt;
		//this.loclKrwXchRt=true;
	}
	public void setGenExpnXchRtDivCd(String genExpnXchRtDivCd) {
		this.genExpnXchRtDivCd = genExpnXchRtDivCd;
		//this.genExpnXchRtDivCd=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setUsdLoclXchRt(String usdLoclXchRt) {
		this.usdLoclXchRt = usdLoclXchRt;
		//this.usdLoclXchRt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setAcctXchRtYrmon(String acctXchRtYrmon) {
		this.acctXchRtYrmon = acctXchRtYrmon;
		//this.acctXchRtYrmon=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsdKrwXchRt(JSPUtil.getParameter(request, "usd_krw_xch_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setLoclKrwXchRt(JSPUtil.getParameter(request, "locl_krw_xch_rt", ""));
		setGenExpnXchRtDivCd(JSPUtil.getParameter(request, "gen_expn_xch_rt_div_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAcctXchRtYrmon(JSPUtil.getParameter(request, "acct_xch_rt_yrmon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public GemXchRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public GemXchRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemXchRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] usdKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_krw_xch_rt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] loclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_krw_xch_rt".trim(), length));
			String[] genExpnXchRtDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_xch_rt_div_cd".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] acctXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_yrmon".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new GemXchRtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usdKrwXchRt[i] != null)
					model.setUsdKrwXchRt(usdKrwXchRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (loclKrwXchRt[i] != null)
					model.setLoclKrwXchRt(loclKrwXchRt[i]);
				if (genExpnXchRtDivCd[i] != null)
					model.setGenExpnXchRtDivCd(genExpnXchRtDivCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (acctXchRtYrmon[i] != null)
					model.setAcctXchRtYrmon(acctXchRtYrmon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getGemXchRtVOs();
	}

	public GemXchRtVO[] getGemXchRtVOs(){
		GemXchRtVO[] vos = (GemXchRtVO[])models.toArray(new GemXchRtVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdKrwXchRt = this.usdKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclKrwXchRt = this.loclKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnXchRtDivCd = this.genExpnXchRtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtYrmon = this.acctXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
