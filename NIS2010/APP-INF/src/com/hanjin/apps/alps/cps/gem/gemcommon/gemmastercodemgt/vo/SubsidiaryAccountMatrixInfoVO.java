/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SubsidiaryAccountMatrixInfoVO.java
*@FileTitle : SubsidiaryAccountMatrixInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SubsidiaryAccountMatrixInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SubsidiaryAccountMatrixInfoVO> models = new ArrayList<SubsidiaryAccountMatrixInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String subsAcctKrnNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String subsAcctEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String subsAcctCd = null;
	/* Column Info */
	private String subsAcctEngDesc = null;
	/* Column Info */
	private String subsAcctKrnDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ticCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SubsidiaryAccountMatrixInfoVO() {}

	public SubsidiaryAccountMatrixInfoVO(String ibflag, String pagerows, String ofcCd, String subsAcctCd, String subsAcctKrnNm, String subsAcctEngNm, String subsAcctKrnDesc, String subsAcctEngDesc, String genExpnCd, String ticCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.subsAcctKrnNm = subsAcctKrnNm;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.genExpnCd = genExpnCd;
		this.subsAcctEngNm = subsAcctEngNm;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.subsAcctCd = subsAcctCd;
		this.subsAcctEngDesc = subsAcctEngDesc;
		this.subsAcctKrnDesc = subsAcctKrnDesc;
		this.updUsrId = updUsrId;
		this.ticCd = ticCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("subs_acct_krn_nm", getSubsAcctKrnNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("subs_acct_eng_nm", getSubsAcctEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("subs_acct_cd", getSubsAcctCd());
		this.hashColumns.put("subs_acct_eng_desc", getSubsAcctEngDesc());
		this.hashColumns.put("subs_acct_krn_desc", getSubsAcctKrnDesc());
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
		this.hashFields.put("subs_acct_krn_nm", "subsAcctKrnNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("subs_acct_eng_nm", "subsAcctEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("subs_acct_cd", "subsAcctCd");
		this.hashFields.put("subs_acct_eng_desc", "subsAcctEngDesc");
		this.hashFields.put("subs_acct_krn_desc", "subsAcctKrnDesc");
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
	 * @return subsAcctKrnNm
	 */
	public String getSubsAcctKrnNm() {
		return this.subsAcctKrnNm;
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
	 * @return subsAcctEngNm
	 */
	public String getSubsAcctEngNm() {
		return this.subsAcctEngNm;
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
	 * @return subsAcctCd
	 */
	public String getSubsAcctCd() {
		return this.subsAcctCd;
	}
	
	/**
	 * Column Info
	 * @return subsAcctEngDesc
	 */
	public String getSubsAcctEngDesc() {
		return this.subsAcctEngDesc;
	}
	
	/**
	 * Column Info
	 * @return subsAcctKrnDesc
	 */
	public String getSubsAcctKrnDesc() {
		return this.subsAcctKrnDesc;
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
	 * @param subsAcctKrnNm
	 */
	public void setSubsAcctKrnNm(String subsAcctKrnNm) {
		this.subsAcctKrnNm = subsAcctKrnNm;
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
	 * @param subsAcctEngNm
	 */
	public void setSubsAcctEngNm(String subsAcctEngNm) {
		this.subsAcctEngNm = subsAcctEngNm;
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
	 * @param subsAcctCd
	 */
	public void setSubsAcctCd(String subsAcctCd) {
		this.subsAcctCd = subsAcctCd;
	}
	
	/**
	 * Column Info
	 * @param subsAcctEngDesc
	 */
	public void setSubsAcctEngDesc(String subsAcctEngDesc) {
		this.subsAcctEngDesc = subsAcctEngDesc;
	}
	
	/**
	 * Column Info
	 * @param subsAcctKrnDesc
	 */
	public void setSubsAcctKrnDesc(String subsAcctKrnDesc) {
		this.subsAcctKrnDesc = subsAcctKrnDesc;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSubsAcctKrnNm(JSPUtil.getParameter(request, prefix + "subs_acct_krn_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, prefix + "gen_expn_cd", ""));
		setSubsAcctEngNm(JSPUtil.getParameter(request, prefix + "subs_acct_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSubsAcctCd(JSPUtil.getParameter(request, prefix + "subs_acct_cd", ""));
		setSubsAcctEngDesc(JSPUtil.getParameter(request, prefix + "subs_acct_eng_desc", ""));
		setSubsAcctKrnDesc(JSPUtil.getParameter(request, prefix + "subs_acct_krn_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTicCd(JSPUtil.getParameter(request, prefix + "tic_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SubsidiaryAccountMatrixInfoVO[]
	 */
	public SubsidiaryAccountMatrixInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SubsidiaryAccountMatrixInfoVO[]
	 */
	public SubsidiaryAccountMatrixInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SubsidiaryAccountMatrixInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] subsAcctKrnNm = (JSPUtil.getParameter(request, prefix	+ "subs_acct_krn_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] subsAcctEngNm = (JSPUtil.getParameter(request, prefix	+ "subs_acct_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] subsAcctCd = (JSPUtil.getParameter(request, prefix	+ "subs_acct_cd", length));
			String[] subsAcctEngDesc = (JSPUtil.getParameter(request, prefix	+ "subs_acct_eng_desc", length));
			String[] subsAcctKrnDesc = (JSPUtil.getParameter(request, prefix	+ "subs_acct_krn_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SubsidiaryAccountMatrixInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (subsAcctKrnNm[i] != null)
					model.setSubsAcctKrnNm(subsAcctKrnNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (subsAcctEngNm[i] != null)
					model.setSubsAcctEngNm(subsAcctEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (subsAcctCd[i] != null)
					model.setSubsAcctCd(subsAcctCd[i]);
				if (subsAcctEngDesc[i] != null)
					model.setSubsAcctEngDesc(subsAcctEngDesc[i]);
				if (subsAcctKrnDesc[i] != null)
					model.setSubsAcctKrnDesc(subsAcctKrnDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSubsidiaryAccountMatrixInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SubsidiaryAccountMatrixInfoVO[]
	 */
	public SubsidiaryAccountMatrixInfoVO[] getSubsidiaryAccountMatrixInfoVOs(){
		SubsidiaryAccountMatrixInfoVO[] vos = (SubsidiaryAccountMatrixInfoVO[])models.toArray(new SubsidiaryAccountMatrixInfoVO[models.size()]);
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
		this.subsAcctKrnNm = this.subsAcctKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsAcctEngNm = this.subsAcctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsAcctCd = this.subsAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsAcctEngDesc = this.subsAcctEngDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsAcctKrnDesc = this.subsAcctKrnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
