/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeInfoVO.java
*@FileTitle : OfficeInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.24 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo;

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
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfficeInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeInfoVO> models = new ArrayList<OfficeInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String slsOfcFlg = null;
	/* Column Info */
	private String rhqAuthFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String cmitAuthFlg = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String rqstAuthFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ticAuthFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expnNm = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ticCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfficeInfoVO() {}

	public OfficeInfoVO(String ibflag, String pagerows, String ofcCd, String loclCurrCd, String rqstUtVal, String usdLoclXchRt, String rqstAuthFlg, String rhqAuthFlg, String ticAuthFlg, String cmitAuthFlg, String slsOfcFlg, String genExpnCd, String expnNm, String ticCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.slsOfcFlg = slsOfcFlg;
		this.rhqAuthFlg = rhqAuthFlg;
		this.deltFlg = deltFlg;
		this.cmitAuthFlg = cmitAuthFlg;
		this.loclCurrCd = loclCurrCd;
		this.creDt = creDt;
		this.genExpnCd = genExpnCd;
		this.rqstAuthFlg = rqstAuthFlg;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ticAuthFlg = ticAuthFlg;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.expnNm = expnNm;
		this.usdLoclXchRt = usdLoclXchRt;
		this.rqstUtVal = rqstUtVal;
		this.updUsrId = updUsrId;
		this.ticCd = ticCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sls_ofc_flg", getSlsOfcFlg());
		this.hashColumns.put("rhq_auth_flg", getRhqAuthFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cmit_auth_flg", getCmitAuthFlg());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("rqst_auth_flg", getRqstAuthFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("tic_auth_flg", getTicAuthFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("expn_nm", getExpnNm());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tic_cd", getTicCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sls_ofc_flg", "slsOfcFlg");
		this.hashFields.put("rhq_auth_flg", "rhqAuthFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cmit_auth_flg", "cmitAuthFlg");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("rqst_auth_flg", "rqstAuthFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("tic_auth_flg", "ticAuthFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("expn_nm", "expnNm");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tic_cd", "ticCd");
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
	 * @return slsOfcFlg
	 */
	public String getSlsOfcFlg() {
		return this.slsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return rhqAuthFlg
	 */
	public String getRhqAuthFlg() {
		return this.rhqAuthFlg;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return cmitAuthFlg
	 */
	public String getCmitAuthFlg() {
		return this.cmitAuthFlg;
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
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return rqstAuthFlg
	 */
	public String getRqstAuthFlg() {
		return this.rqstAuthFlg;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ticAuthFlg
	 */
	public String getTicAuthFlg() {
		return this.ticAuthFlg;
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
	 * @return expnNm
	 */
	public String getExpnNm() {
		return this.expnNm;
	}
	
	/**
	 * Column Info
	 * @return usdLoclXchRt
	 */
	public String getUsdLoclXchRt() {
		return this.usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
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
	 * @return ticCd
	 */
	public String getTicCd() {
		return this.ticCd;
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
	 * @param slsOfcFlg
	 */
	public void setSlsOfcFlg(String slsOfcFlg) {
		this.slsOfcFlg = slsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param rhqAuthFlg
	 */
	public void setRhqAuthFlg(String rhqAuthFlg) {
		this.rhqAuthFlg = rhqAuthFlg;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param cmitAuthFlg
	 */
	public void setCmitAuthFlg(String cmitAuthFlg) {
		this.cmitAuthFlg = cmitAuthFlg;
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
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param rqstAuthFlg
	 */
	public void setRqstAuthFlg(String rqstAuthFlg) {
		this.rqstAuthFlg = rqstAuthFlg;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ticAuthFlg
	 */
	public void setTicAuthFlg(String ticAuthFlg) {
		this.ticAuthFlg = ticAuthFlg;
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
	 * @param expnNm
	 */
	public void setExpnNm(String expnNm) {
		this.expnNm = expnNm;
	}
	
	/**
	 * Column Info
	 * @param usdLoclXchRt
	 */
	public void setUsdLoclXchRt(String usdLoclXchRt) {
		this.usdLoclXchRt = usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
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
	 * @param ticCd
	 */
	public void setTicCd(String ticCd) {
		this.ticCd = ticCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSlsOfcFlg(JSPUtil.getParameter(request, "sls_ofc_flg", ""));
		setRhqAuthFlg(JSPUtil.getParameter(request, "rhq_auth_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCmitAuthFlg(JSPUtil.getParameter(request, "cmit_auth_flg", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setRqstAuthFlg(JSPUtil.getParameter(request, "rqst_auth_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setTicAuthFlg(JSPUtil.getParameter(request, "tic_auth_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setExpnNm(JSPUtil.getParameter(request, "expn_nm", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeInfoVO[]
	 */
	public OfficeInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeInfoVO[]
	 */
	public OfficeInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] slsOfcFlg = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_flg", length));
			String[] rhqAuthFlg = (JSPUtil.getParameter(request, prefix	+ "rhq_auth_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] cmitAuthFlg = (JSPUtil.getParameter(request, prefix	+ "cmit_auth_flg", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] rqstAuthFlg = (JSPUtil.getParameter(request, prefix	+ "rqst_auth_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ticAuthFlg = (JSPUtil.getParameter(request, prefix	+ "tic_auth_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expnNm = (JSPUtil.getParameter(request, prefix	+ "expn_nm", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (slsOfcFlg[i] != null)
					model.setSlsOfcFlg(slsOfcFlg[i]);
				if (rhqAuthFlg[i] != null)
					model.setRhqAuthFlg(rhqAuthFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (cmitAuthFlg[i] != null)
					model.setCmitAuthFlg(cmitAuthFlg[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (rqstAuthFlg[i] != null)
					model.setRqstAuthFlg(rqstAuthFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ticAuthFlg[i] != null)
					model.setTicAuthFlg(ticAuthFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expnNm[i] != null)
					model.setExpnNm(expnNm[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficeInfoVO[]
	 */
	public OfficeInfoVO[] getOfficeInfoVOs(){
		OfficeInfoVO[] vos = (OfficeInfoVO[])models.toArray(new OfficeInfoVO[models.size()]);
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
		this.slsOfcFlg = this.slsOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqAuthFlg = this.rhqAuthFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmitAuthFlg = this.cmitAuthFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAuthFlg = this.rqstAuthFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticAuthFlg = this.ticAuthFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnNm = this.expnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
