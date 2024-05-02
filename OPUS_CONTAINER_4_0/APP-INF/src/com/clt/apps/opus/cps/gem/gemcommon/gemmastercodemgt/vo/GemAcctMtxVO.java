/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemAcctMtxVO.java
*@FileTitle : GemAcctMtxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.04.30  
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
 * @author 
 * @since J2EE 1.5
 */

public class GemAcctMtxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemAcctMtxVO> models = new ArrayList<GemAcctMtxVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String krnNm = null;
	/* Column Info */
	private String engDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String engNm = null;
	/* Column Info */
	private String krnDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemAcctMtxVO() {}

	public GemAcctMtxVO(String ibflag, String pagerows, String acctCd, String krnNm, String engNm, String krnDesc, String engDesc, String genExpnCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.krnNm = krnNm;
		this.engDesc = engDesc;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.creDt = creDt;
		this.genExpnCd = genExpnCd;
		this.deltFlg = deltFlg;
		this.creUsrId = creUsrId;
		this.engNm = engNm;
		this.krnDesc = krnDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("krn_nm", getKrnNm());
		this.hashColumns.put("eng_desc", getEngDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eng_nm", getEngNm());
		this.hashColumns.put("krn_desc", getKrnDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("krn_nm", "krnNm");
		this.hashFields.put("eng_desc", "engDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eng_nm", "engNm");
		this.hashFields.put("krn_desc", "krnDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getKrnNm() {
		return this.krnNm;
	}
	public String getEngDesc() {
		return this.engDesc;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getEngNm() {
		return this.engNm;
	}
	public String getKrnDesc() {
		return this.krnDesc;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setKrnNm(String krnNm) {
		this.krnNm = krnNm;
		//this.krnNm=true;
	}
	public void setEngDesc(String engDesc) {
		this.engDesc = engDesc;
		//this.engDesc=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
		//this.genExpnCd=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setEngNm(String engNm) {
		this.engNm = engNm;
		//this.engNm=true;
	}
	public void setKrnDesc(String krnDesc) {
		this.krnDesc = krnDesc;
		//this.krnDesc=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setKrnNm(JSPUtil.getParameter(request, "krn_nm", ""));
		setEngDesc(JSPUtil.getParameter(request, "eng_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEngNm(JSPUtil.getParameter(request, "eng_nm", ""));
		setKrnDesc(JSPUtil.getParameter(request, "krn_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public GemAcctMtxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public GemAcctMtxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemAcctMtxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] krnNm = (JSPUtil.getParameter(request, prefix	+ "krn_nm".trim(), length));
			String[] engDesc = (JSPUtil.getParameter(request, prefix	+ "eng_desc".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] engNm = (JSPUtil.getParameter(request, prefix	+ "eng_nm".trim(), length));
			String[] krnDesc = (JSPUtil.getParameter(request, prefix	+ "krn_desc".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new GemAcctMtxVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (krnNm[i] != null)
					model.setKrnNm(krnNm[i]);
				if (engDesc[i] != null)
					model.setEngDesc(engDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (engNm[i] != null)
					model.setEngNm(engNm[i]);
				if (krnDesc[i] != null)
					model.setKrnDesc(krnDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getGemAcctMtxVOs();
	}

	public GemAcctMtxVO[] getGemAcctMtxVOs(){
		GemAcctMtxVO[] vos = (GemAcctMtxVO[])models.toArray(new GemAcctMtxVO[models.size()]);
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
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krnNm = this.krnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engDesc = this.engDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engNm = this.engNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krnDesc = this.krnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
