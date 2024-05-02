/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScgCntcPntVO.java
*@FileTitle : ScgCntcPntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgCntcPntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgCntcPntVO> models = new ArrayList<ScgCntcPntVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String transmitTarget = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String cntcPsonEmlCtnt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String spclCgoCateCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntcPsonPhnNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslOprNm = null;
	/* Column Info */
	private String cntcPsonFaxNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntcCateSeq = null;
	/* Column Info */
	private String cntcCateCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScgCntcPntVO() {}

	public ScgCntcPntVO(String ibflag, String pagerows, String rgnShpOprCd, String crrCd, String slanCd, String spclCgoCateCd, String vslOprNm, String cntcPsonEmlCtnt, String cntcPsonPhnNo, String cntcPsonFaxNo, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String cntcCateCd, String cntcCateSeq, String effFmDt, String effToDt, String portCd, String skdDirCd, String transmitTarget) {
		this.updDt = updDt;
		this.transmitTarget = transmitTarget;
		this.rgnShpOprCd = rgnShpOprCd;
		this.cntcPsonEmlCtnt = cntcPsonEmlCtnt;
		this.deltFlg = deltFlg;
		this.spclCgoCateCd = spclCgoCateCd;
		this.creDt = creDt;
		this.cntcPsonPhnNo = cntcPsonPhnNo;
		this.skdDirCd = skdDirCd;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.vslOprNm = vslOprNm;
		this.cntcPsonFaxNo = cntcPsonFaxNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntcCateSeq = cntcCateSeq;
		this.cntcCateCd = cntcCateCd;
		this.slanCd = slanCd;
		this.effFmDt = effFmDt;
		this.portCd = portCd;
		this.effToDt = effToDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("transmit_target", getTransmitTarget());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("cntc_pson_eml_ctnt", getCntcPsonEmlCtnt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_opr_nm", getVslOprNm());
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntc_cate_seq", getCntcCateSeq());
		this.hashColumns.put("cntc_cate_cd", getCntcCateCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("transmit_target", "transmitTarget");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("cntc_pson_eml_ctnt", "cntcPsonEmlCtnt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_opr_nm", "vslOprNm");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntc_cate_seq", "cntcCateSeq");
		this.hashFields.put("cntc_cate_cd", "cntcCateCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("eff_to_dt", "effToDt");
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
	 * @return transmitTarget
	 */
	public String getTransmitTarget() {
		return this.transmitTarget;
	}
	
	/**
	 * Column Info
	 * @return rgnShpOprCd
	 */
	public String getRgnShpOprCd() {
		return this.rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonEmlCtnt
	 */
	public String getCntcPsonEmlCtnt() {
		return this.cntcPsonEmlCtnt;
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
	 * @return spclCgoCateCd
	 */
	public String getSpclCgoCateCd() {
		return this.spclCgoCateCd;
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
	 * @return cntcPsonPhnNo
	 */
	public String getCntcPsonPhnNo() {
		return this.cntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return vslOprNm
	 */
	public String getVslOprNm() {
		return this.vslOprNm;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonFaxNo
	 */
	public String getCntcPsonFaxNo() {
		return this.cntcPsonFaxNo;
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
	 * @return cntcCateSeq
	 */
	public String getCntcCateSeq() {
		return this.cntcCateSeq;
	}
	
	/**
	 * Column Info
	 * @return cntcCateCd
	 */
	public String getCntcCateCd() {
		return this.cntcCateCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
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
	 * @param transmitTarget
	 */
	public void setTransmitTarget(String transmitTarget) {
		this.transmitTarget = transmitTarget;
	}
	
	/**
	 * Column Info
	 * @param rgnShpOprCd
	 */
	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonEmlCtnt
	 */
	public void setCntcPsonEmlCtnt(String cntcPsonEmlCtnt) {
		this.cntcPsonEmlCtnt = cntcPsonEmlCtnt;
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
	 * @param spclCgoCateCd
	 */
	public void setSpclCgoCateCd(String spclCgoCateCd) {
		this.spclCgoCateCd = spclCgoCateCd;
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
	 * @param cntcPsonPhnNo
	 */
	public void setCntcPsonPhnNo(String cntcPsonPhnNo) {
		this.cntcPsonPhnNo = cntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param vslOprNm
	 */
	public void setVslOprNm(String vslOprNm) {
		this.vslOprNm = vslOprNm;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonFaxNo
	 */
	public void setCntcPsonFaxNo(String cntcPsonFaxNo) {
		this.cntcPsonFaxNo = cntcPsonFaxNo;
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
	 * @param cntcCateSeq
	 */
	public void setCntcCateSeq(String cntcCateSeq) {
		this.cntcCateSeq = cntcCateSeq;
	}
	
	/**
	 * Column Info
	 * @param cntcCateCd
	 */
	public void setCntcCateCd(String cntcCateCd) {
		this.cntcCateCd = cntcCateCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTransmitTarget(JSPUtil.getParameter(request, prefix + "transmit_target", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
		setCntcPsonEmlCtnt(JSPUtil.getParameter(request, prefix + "cntc_pson_eml_ctnt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslOprNm(JSPUtil.getParameter(request, prefix + "vsl_opr_nm", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntcCateSeq(JSPUtil.getParameter(request, prefix + "cntc_cate_seq", ""));
		setCntcCateCd(JSPUtil.getParameter(request, prefix + "cntc_cate_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgCntcPntVO[]
	 */
	public ScgCntcPntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgCntcPntVO[]
	 */
	public ScgCntcPntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgCntcPntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] transmitTarget = (JSPUtil.getParameter(request, prefix	+ "transmit_target", length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] cntcPsonEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_eml_ctnt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cate_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_phn_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslOprNm = (JSPUtil.getParameter(request, prefix	+ "vsl_opr_nm", length));
			String[] cntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_fax_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntcCateSeq = (JSPUtil.getParameter(request, prefix	+ "cntc_cate_seq", length));
			String[] cntcCateCd = (JSPUtil.getParameter(request, prefix	+ "cntc_cate_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgCntcPntVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (transmitTarget[i] != null)
					model.setTransmitTarget(transmitTarget[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (cntcPsonEmlCtnt[i] != null)
					model.setCntcPsonEmlCtnt(cntcPsonEmlCtnt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (spclCgoCateCd[i] != null)
					model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntcPsonPhnNo[i] != null)
					model.setCntcPsonPhnNo(cntcPsonPhnNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslOprNm[i] != null)
					model.setVslOprNm(vslOprNm[i]);
				if (cntcPsonFaxNo[i] != null)
					model.setCntcPsonFaxNo(cntcPsonFaxNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntcCateSeq[i] != null)
					model.setCntcCateSeq(cntcCateSeq[i]);
				if (cntcCateCd[i] != null)
					model.setCntcCateCd(cntcCateCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgCntcPntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgCntcPntVO[]
	 */
	public ScgCntcPntVO[] getScgCntcPntVOs(){
		ScgCntcPntVO[] vos = (ScgCntcPntVO[])models.toArray(new ScgCntcPntVO[models.size()]);
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
		this.transmitTarget = this.transmitTarget .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonEmlCtnt = this.cntcPsonEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd = this.spclCgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo = this.cntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOprNm = this.vslOprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo = this.cntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcCateSeq = this.cntcCateSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcCateCd = this.cntcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
