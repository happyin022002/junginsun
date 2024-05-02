/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrsStccVO.java
*@FileTitle : TrsStccVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.26 이준근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이준근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsStccVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsStccVO> models = new ArrayList<TrsStccVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String stccCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String hzdMtrlClssCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pckGrpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String pckGrpValCd = null;
	/* Column Info */
	private String stccSeq = null;
	/* Column Info */
	private String unCmdtCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNoSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrsStccVO() {}

	public TrsStccVO(String ibflag, String pagerows, String stccCd, String stccSeq, String unCmdtCd, String hzdMtrlClssCd, String pckGrpCd, String pckGrpValCd, String prpShpNm 
			,String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String imdgUnNoSeq) {
		this.updDt = updDt;
		this.stccCd = stccCd;
		this.deltFlg = deltFlg;
		this.hzdMtrlClssCd = hzdMtrlClssCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pckGrpCd = pckGrpCd;
		this.creUsrId = creUsrId;
		this.pckGrpValCd = pckGrpValCd;
		this.stccSeq = stccSeq;
		this.unCmdtCd = unCmdtCd;
		this.prpShpNm = prpShpNm;
		this.updUsrId = updUsrId;
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("stcc_cd", getStccCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("hzd_mtrl_clss_cd", getHzdMtrlClssCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pck_grp_cd", getPckGrpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pck_grp_val_cd", getPckGrpValCd());
		this.hashColumns.put("stcc_seq", getStccSeq());
		this.hashColumns.put("un_cmdt_cd", getUnCmdtCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("stcc_cd", "stccCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("hzd_mtrl_clss_cd", "hzdMtrlClssCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pck_grp_cd", "pckGrpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pck_grp_val_cd", "pckGrpValCd");
		this.hashFields.put("stcc_seq", "stccSeq");
		this.hashFields.put("un_cmdt_cd", "unCmdtCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
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
	 * @return stccCd
	 */
	public String getStccCd() {
		return this.stccCd;
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
	 * @return hzdMtrlClssCd
	 */
	public String getHzdMtrlClssCd() {
		return this.hzdMtrlClssCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return pckGrpCd
	 */
	public String getPckGrpCd() {
		return this.pckGrpCd;
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
	 * @return pckGrpValCd
	 */
	public String getPckGrpValCd() {
		return this.pckGrpValCd;
	}
	
	/**
	 * Column Info
	 * @return stccSeq
	 */
	public String getStccSeq() {
		return this.stccSeq;
	}
	
	/**
	 * Column Info
	 * @return unCmdtCd
	 */
	public String getUnCmdtCd() {
		return this.unCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
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
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return imdgUnNoSeq;
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
	 * @param stccCd
	 */
	public void setStccCd(String stccCd) {
		this.stccCd = stccCd;
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
	 * @param hzdMtrlClssCd
	 */
	public void setHzdMtrlClssCd(String hzdMtrlClssCd) {
		this.hzdMtrlClssCd = hzdMtrlClssCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param pckGrpCd
	 */
	public void setPckGrpCd(String pckGrpCd) {
		this.pckGrpCd = pckGrpCd;
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
	 * @param pckGrpValCd
	 */
	public void setPckGrpValCd(String pckGrpValCd) {
		this.pckGrpValCd = pckGrpValCd;
	}
	
	/**
	 * Column Info
	 * @param stccSeq
	 */
	public void setStccSeq(String stccSeq) {
		this.stccSeq = stccSeq;
	}
	
	/**
	 * Column Info
	 * @param unCmdtCd
	 */
	public void setUnCmdtCd(String unCmdtCd) {
		this.unCmdtCd = unCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
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
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
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
		setStccCd(JSPUtil.getParameter(request, prefix + "stcc_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setHzdMtrlClssCd(JSPUtil.getParameter(request, prefix + "hzd_mtrl_clss_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPckGrpCd(JSPUtil.getParameter(request, prefix + "pck_grp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPckGrpValCd(JSPUtil.getParameter(request, prefix + "pck_grp_val_cd", ""));
		setStccSeq(JSPUtil.getParameter(request, prefix + "stcc_seq", ""));
		setUnCmdtCd(JSPUtil.getParameter(request, prefix + "un_cmdt_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsStccVO[]
	 */
	public TrsStccVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsStccVO[]
	 */
	public TrsStccVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsStccVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] stccCd = (JSPUtil.getParameter(request, prefix	+ "stcc_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] hzdMtrlClssCd = (JSPUtil.getParameter(request, prefix	+ "hzd_mtrl_clss_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pckGrpCd = (JSPUtil.getParameter(request, prefix	+ "pck_grp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] pckGrpValCd = (JSPUtil.getParameter(request, prefix	+ "pck_grp_val_cd", length));
			String[] stccSeq = (JSPUtil.getParameter(request, prefix	+ "stcc_seq", length));
			String[] unCmdtCd = (JSPUtil.getParameter(request, prefix	+ "un_cmdt_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsStccVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (stccCd[i] != null)
					model.setStccCd(stccCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (hzdMtrlClssCd[i] != null)
					model.setHzdMtrlClssCd(hzdMtrlClssCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pckGrpCd[i] != null)
					model.setPckGrpCd(pckGrpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pckGrpValCd[i] != null)
					model.setPckGrpValCd(pckGrpValCd[i]);
				if (stccSeq[i] != null)
					model.setStccSeq(stccSeq[i]);
				if (unCmdtCd[i] != null)
					model.setUnCmdtCd(unCmdtCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsStccVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsStccVO[]
	 */
	public TrsStccVO[] getTrsStccVOs(){
		TrsStccVO[] vos = (TrsStccVO[])models.toArray(new TrsStccVO[models.size()]);
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
		this.stccCd = this.stccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdMtrlClssCd = this.hzdMtrlClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckGrpCd = this.pckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckGrpValCd = this.pckGrpValCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stccSeq = this.stccSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unCmdtCd = this.unCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
