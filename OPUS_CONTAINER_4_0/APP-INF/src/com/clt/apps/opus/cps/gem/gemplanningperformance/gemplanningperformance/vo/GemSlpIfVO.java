/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemSlpIfVO.java
*@FileTitle : GemSlpIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.19 최정미 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GemSlpIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemSlpIfVO> models = new ArrayList<GemSlpIfVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String slpIfFlg = null;
	/* Column Info */
	private String slpAmt = null;
	/* Column Info */
	private String prprUsrId = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String slpCurrCd = null;
	/* Column Info */
	private String slpCtrCd = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String slpDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String slpVndrCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpTjNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sysCateNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemSlpIfVO() {}

	public GemSlpIfVO(String ibflag, String pagerows, String slpTjNo, String slpSeqNo, String sysCateNm, String glEffDt, String acctCd, String slpCurrCd, String slpAmt, String slpCtrCd, String slpDesc, String ofcCd, String slpVndrCd, String prprUsrId, String aproUsrId, String slpIfFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.slpIfFlg = slpIfFlg;
		this.slpAmt = slpAmt;
		this.prprUsrId = prprUsrId;
		this.glEffDt = glEffDt;
		this.creDt = creDt;
		this.slpCurrCd = slpCurrCd;
		this.slpCtrCd = slpCtrCd;
		this.slpSeqNo = slpSeqNo;
		this.slpDesc = slpDesc;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.aproUsrId = aproUsrId;
		this.slpVndrCd = slpVndrCd;
		this.acctCd = acctCd;
		this.slpTjNo = slpTjNo;
		this.updUsrId = updUsrId;
		this.sysCateNm = sysCateNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("slp_if_flg", getSlpIfFlg());
		this.hashColumns.put("slp_amt", getSlpAmt());
		this.hashColumns.put("prpr_usr_id", getPrprUsrId());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("slp_curr_cd", getSlpCurrCd());
		this.hashColumns.put("slp_ctr_cd", getSlpCtrCd());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("slp_desc", getSlpDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("slp_vndr_cd", getSlpVndrCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_tj_no", getSlpTjNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sys_cate_nm", getSysCateNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("slp_if_flg", "slpIfFlg");
		this.hashFields.put("slp_amt", "slpAmt");
		this.hashFields.put("prpr_usr_id", "prprUsrId");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("slp_curr_cd", "slpCurrCd");
		this.hashFields.put("slp_ctr_cd", "slpCtrCd");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("slp_desc", "slpDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("slp_vndr_cd", "slpVndrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_tj_no", "slpTjNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sys_cate_nm", "sysCateNm");
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
	 * @return slpIfFlg
	 */
	public String getSlpIfFlg() {
		return this.slpIfFlg;
	}
	
	/**
	 * Column Info
	 * @return slpAmt
	 */
	public String getSlpAmt() {
		return this.slpAmt;
	}
	
	/**
	 * Column Info
	 * @return prprUsrId
	 */
	public String getPrprUsrId() {
		return this.prprUsrId;
	}
	
	/**
	 * Column Info
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
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
	 * @return slpCurrCd
	 */
	public String getSlpCurrCd() {
		return this.slpCurrCd;
	}
	
	/**
	 * Column Info
	 * @return slpCtrCd
	 */
	public String getSlpCtrCd() {
		return this.slpCtrCd;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return slpDesc
	 */
	public String getSlpDesc() {
		return this.slpDesc;
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
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return slpVndrCd
	 */
	public String getSlpVndrCd() {
		return this.slpVndrCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return slpTjNo
	 */
	public String getSlpTjNo() {
		return this.slpTjNo;
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
	 * @return sysCateNm
	 */
	public String getSysCateNm() {
		return this.sysCateNm;
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
	 * @param slpIfFlg
	 */
	public void setSlpIfFlg(String slpIfFlg) {
		this.slpIfFlg = slpIfFlg;
	}
	
	/**
	 * Column Info
	 * @param slpAmt
	 */
	public void setSlpAmt(String slpAmt) {
		this.slpAmt = slpAmt;
	}
	
	/**
	 * Column Info
	 * @param prprUsrId
	 */
	public void setPrprUsrId(String prprUsrId) {
		this.prprUsrId = prprUsrId;
	}
	
	/**
	 * Column Info
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
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
	 * @param slpCurrCd
	 */
	public void setSlpCurrCd(String slpCurrCd) {
		this.slpCurrCd = slpCurrCd;
	}
	
	/**
	 * Column Info
	 * @param slpCtrCd
	 */
	public void setSlpCtrCd(String slpCtrCd) {
		this.slpCtrCd = slpCtrCd;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param slpDesc
	 */
	public void setSlpDesc(String slpDesc) {
		this.slpDesc = slpDesc;
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
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param slpVndrCd
	 */
	public void setSlpVndrCd(String slpVndrCd) {
		this.slpVndrCd = slpVndrCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param slpTjNo
	 */
	public void setSlpTjNo(String slpTjNo) {
		this.slpTjNo = slpTjNo;
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
	 * @param sysCateNm
	 */
	public void setSysCateNm(String sysCateNm) {
		this.sysCateNm = sysCateNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSlpIfFlg(JSPUtil.getParameter(request, "slp_if_flg", ""));
		setSlpAmt(JSPUtil.getParameter(request, "slp_amt", ""));
		setPrprUsrId(JSPUtil.getParameter(request, "prpr_usr_id", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSlpCurrCd(JSPUtil.getParameter(request, "slp_curr_cd", ""));
		setSlpCtrCd(JSPUtil.getParameter(request, "slp_ctr_cd", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setSlpDesc(JSPUtil.getParameter(request, "slp_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAproUsrId(JSPUtil.getParameter(request, "apro_usr_id", ""));
		setSlpVndrCd(JSPUtil.getParameter(request, "slp_vndr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setSlpTjNo(JSPUtil.getParameter(request, "slp_tj_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSysCateNm(JSPUtil.getParameter(request, "sys_cate_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemSlpIfVO[]
	 */
	public GemSlpIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemSlpIfVO[]
	 */
	public GemSlpIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemSlpIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] slpIfFlg = (JSPUtil.getParameter(request, prefix	+ "slp_if_flg", length));
			String[] slpAmt = (JSPUtil.getParameter(request, prefix	+ "slp_amt", length));
			String[] prprUsrId = (JSPUtil.getParameter(request, prefix	+ "prpr_usr_id", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] slpCurrCd = (JSPUtil.getParameter(request, prefix	+ "slp_curr_cd", length));
			String[] slpCtrCd = (JSPUtil.getParameter(request, prefix	+ "slp_ctr_cd", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] slpDesc = (JSPUtil.getParameter(request, prefix	+ "slp_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] slpVndrCd = (JSPUtil.getParameter(request, prefix	+ "slp_vndr_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpTjNo = (JSPUtil.getParameter(request, prefix	+ "slp_tj_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sysCateNm = (JSPUtil.getParameter(request, prefix	+ "sys_cate_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemSlpIfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (slpIfFlg[i] != null)
					model.setSlpIfFlg(slpIfFlg[i]);
				if (slpAmt[i] != null)
					model.setSlpAmt(slpAmt[i]);
				if (prprUsrId[i] != null)
					model.setPrprUsrId(prprUsrId[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (slpCurrCd[i] != null)
					model.setSlpCurrCd(slpCurrCd[i]);
				if (slpCtrCd[i] != null)
					model.setSlpCtrCd(slpCtrCd[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (slpDesc[i] != null)
					model.setSlpDesc(slpDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (slpVndrCd[i] != null)
					model.setSlpVndrCd(slpVndrCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpTjNo[i] != null)
					model.setSlpTjNo(slpTjNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sysCateNm[i] != null)
					model.setSysCateNm(sysCateNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemSlpIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemSlpIfVO[]
	 */
	public GemSlpIfVO[] getGemSlpIfVOs(){
		GemSlpIfVO[] vos = (GemSlpIfVO[])models.toArray(new GemSlpIfVO[models.size()]);
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
		this.slpIfFlg = this.slpIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpAmt = this.slpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prprUsrId = this.prprUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpCurrCd = this.slpCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpCtrCd = this.slpCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpDesc = this.slpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpVndrCd = this.slpVndrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTjNo = this.slpTjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCateNm = this.sysCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
