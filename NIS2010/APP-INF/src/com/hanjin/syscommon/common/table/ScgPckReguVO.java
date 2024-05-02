/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckReguVO.java
*@FileTitle : ScgPckReguVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgPckReguVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckReguVO> models = new ArrayList<ScgPckReguVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String reguPckOrgPrxFlg = null;
	/* Column Info */
	private String reguMnDesc = null;
	/* Column Info */
	private String reguImgFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String reguPckCdFlg = null;
	/* Column Info */
	private String reguDpNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String reguPckMzdFlg = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String reguIbcFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckReguVO() {}

	public ScgPckReguVO(String ibflag, String pagerows, String reguDpNo, String imdgPckInstrCd, String imdgPckInstrSeq, String creDt, String creUsrId, String deltFlg, String reguImgFlg, String reguMnDesc, String reguPckCdFlg, String reguIbcFlg, String reguPckMzdFlg, String reguPckOrgPrxFlg, String updDt, String updUsrId) {
		this.updDt = updDt;
		this.reguPckOrgPrxFlg = reguPckOrgPrxFlg;
		this.reguMnDesc = reguMnDesc;
		this.reguImgFlg = reguImgFlg;
		this.deltFlg = deltFlg;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.creDt = creDt;
		this.reguPckCdFlg = reguPckCdFlg;
		this.reguDpNo = reguDpNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.reguPckMzdFlg = reguPckMzdFlg;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.updUsrId = updUsrId;
		this.reguIbcFlg = reguIbcFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("regu_pck_org_prx_flg", getReguPckOrgPrxFlg());
		this.hashColumns.put("regu_mn_desc", getReguMnDesc());
		this.hashColumns.put("regu_img_flg", getReguImgFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("regu_pck_cd_flg", getReguPckCdFlg());
		this.hashColumns.put("regu_dp_no", getReguDpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("regu_pck_mzd_flg", getReguPckMzdFlg());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("regu_ibc_flg", getReguIbcFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("regu_pck_org_prx_flg", "reguPckOrgPrxFlg");
		this.hashFields.put("regu_mn_desc", "reguMnDesc");
		this.hashFields.put("regu_img_flg", "reguImgFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("regu_pck_cd_flg", "reguPckCdFlg");
		this.hashFields.put("regu_dp_no", "reguDpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("regu_pck_mzd_flg", "reguPckMzdFlg");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("regu_ibc_flg", "reguIbcFlg");
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
	 * @return reguPckOrgPrxFlg
	 */
	public String getReguPckOrgPrxFlg() {
		return this.reguPckOrgPrxFlg;
	}
	
	/**
	 * Column Info
	 * @return reguMnDesc
	 */
	public String getReguMnDesc() {
		return this.reguMnDesc;
	}
	
	/**
	 * Column Info
	 * @return reguImgFlg
	 */
	public String getReguImgFlg() {
		return this.reguImgFlg;
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
	 * @return imdgPckInstrSeq
	 */
	public String getImdgPckInstrSeq() {
		return this.imdgPckInstrSeq;
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
	 * @return reguPckCdFlg
	 */
	public String getReguPckCdFlg() {
		return this.reguPckCdFlg;
	}
	
	/**
	 * Column Info
	 * @return reguDpNo
	 */
	public String getReguDpNo() {
		return this.reguDpNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return reguPckMzdFlg
	 */
	public String getReguPckMzdFlg() {
		return this.reguPckMzdFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
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
	 * @return reguIbcFlg
	 */
	public String getReguIbcFlg() {
		return this.reguIbcFlg;
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
	 * @param reguPckOrgPrxFlg
	 */
	public void setReguPckOrgPrxFlg(String reguPckOrgPrxFlg) {
		this.reguPckOrgPrxFlg = reguPckOrgPrxFlg;
	}
	
	/**
	 * Column Info
	 * @param reguMnDesc
	 */
	public void setReguMnDesc(String reguMnDesc) {
		this.reguMnDesc = reguMnDesc;
	}
	
	/**
	 * Column Info
	 * @param reguImgFlg
	 */
	public void setReguImgFlg(String reguImgFlg) {
		this.reguImgFlg = reguImgFlg;
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
	 * @param imdgPckInstrSeq
	 */
	public void setImdgPckInstrSeq(String imdgPckInstrSeq) {
		this.imdgPckInstrSeq = imdgPckInstrSeq;
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
	 * @param reguPckCdFlg
	 */
	public void setReguPckCdFlg(String reguPckCdFlg) {
		this.reguPckCdFlg = reguPckCdFlg;
	}
	
	/**
	 * Column Info
	 * @param reguDpNo
	 */
	public void setReguDpNo(String reguDpNo) {
		this.reguDpNo = reguDpNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param reguPckMzdFlg
	 */
	public void setReguPckMzdFlg(String reguPckMzdFlg) {
		this.reguPckMzdFlg = reguPckMzdFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
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
	 * @param reguIbcFlg
	 */
	public void setReguIbcFlg(String reguIbcFlg) {
		this.reguIbcFlg = reguIbcFlg;
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
		setReguPckOrgPrxFlg(JSPUtil.getParameter(request, prefix + "regu_pck_org_prx_flg", ""));
		setReguMnDesc(JSPUtil.getParameter(request, prefix + "regu_mn_desc", ""));
		setReguImgFlg(JSPUtil.getParameter(request, prefix + "regu_img_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setReguPckCdFlg(JSPUtil.getParameter(request, prefix + "regu_pck_cd_flg", ""));
		setReguDpNo(JSPUtil.getParameter(request, prefix + "regu_dp_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setReguPckMzdFlg(JSPUtil.getParameter(request, prefix + "regu_pck_mzd_flg", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setReguIbcFlg(JSPUtil.getParameter(request, prefix + "regu_ibc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckReguVO[]
	 */
	public ScgPckReguVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckReguVO[]
	 */
	public ScgPckReguVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckReguVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] reguPckOrgPrxFlg = (JSPUtil.getParameter(request, prefix	+ "regu_pck_org_prx_flg", length));
			String[] reguMnDesc = (JSPUtil.getParameter(request, prefix	+ "regu_mn_desc", length));
			String[] reguImgFlg = (JSPUtil.getParameter(request, prefix	+ "regu_img_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] reguPckCdFlg = (JSPUtil.getParameter(request, prefix	+ "regu_pck_cd_flg", length));
			String[] reguDpNo = (JSPUtil.getParameter(request, prefix	+ "regu_dp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] reguPckMzdFlg = (JSPUtil.getParameter(request, prefix	+ "regu_pck_mzd_flg", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] reguIbcFlg = (JSPUtil.getParameter(request, prefix	+ "regu_ibc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckReguVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (reguPckOrgPrxFlg[i] != null)
					model.setReguPckOrgPrxFlg(reguPckOrgPrxFlg[i]);
				if (reguMnDesc[i] != null)
					model.setReguMnDesc(reguMnDesc[i]);
				if (reguImgFlg[i] != null)
					model.setReguImgFlg(reguImgFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (reguPckCdFlg[i] != null)
					model.setReguPckCdFlg(reguPckCdFlg[i]);
				if (reguDpNo[i] != null)
					model.setReguDpNo(reguDpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (reguPckMzdFlg[i] != null)
					model.setReguPckMzdFlg(reguPckMzdFlg[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (reguIbcFlg[i] != null)
					model.setReguIbcFlg(reguIbcFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckReguVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckReguVO[]
	 */
	public ScgPckReguVO[] getScgPckReguVOs(){
		ScgPckReguVO[] vos = (ScgPckReguVO[])models.toArray(new ScgPckReguVO[models.size()]);
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
		this.reguPckOrgPrxFlg = this.reguPckOrgPrxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguMnDesc = this.reguMnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguImgFlg = this.reguImgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguPckCdFlg = this.reguPckCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguDpNo = this.reguDpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguPckMzdFlg = this.reguPckMzdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguIbcFlg = this.reguIbcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
