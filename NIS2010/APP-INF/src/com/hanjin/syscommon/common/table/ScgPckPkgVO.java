/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckPkgVO.java
*@FileTitle : ScgPckPkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.05.29 원종규 
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

public class ScgPckPkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckPkgVO> models = new ArrayList<ScgPckPkgVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String pckMtrlTpCd = null;
	/* Column Info */
	private String pckStyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pckRefCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String subSeq = null;
	/* Column Info */
	private String grpN3rdRefNo = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String grpN2ndRefNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String grpN2ndMeasUtCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String grpN1stRefNo = null;
	/* Column Info */
	private String grpN1stQty = null;
	/* Column Info */
	private String pckRefNo = null;
	/* Column Info */
	private String imdgPckCd = null;
	/* Column Info */
	private String grpN2ndProhiFlg = null;
	/* Column Info */
	private String imdgPckDesc = null;
	/* Column Info */
	private String grpN2ndQty = null;
	/* Column Info */
	private String spclPckDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String grpN3rdMeasUtCd = null;
	/* Column Info */
	private String grpN3rdProhiFlg = null;
	/* Column Info */
	private String grpN3rdQty = null;
	/* Column Info */
	private String grpN1stMeasUtCd = null;
	/* Column Info */
	private String grpN1stProhiFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckPkgVO() {}

	public ScgPckPkgVO(String ibflag, String pagerows, String imdgPckInstrCd, String imdgPckInstrSeq, String pckStyCd, String subSeq, String pckTpCd, String imdgPckCd, String imdgPckDesc, String pckMtrlTpCd, String creDt, String creUsrId, String deltFlg, String grpN1stMeasUtCd, String grpN1stProhiFlg, String grpN1stQty, String grpN1stRefNo, String grpN2ndMeasUtCd, String grpN2ndProhiFlg, String grpN2ndQty, String grpN2ndRefNo, String grpN3rdMeasUtCd, String grpN3rdProhiFlg, String grpN3rdQty, String grpN3rdRefNo, String imdgUnNo, String spclPckDesc, String pckRefCd, String pckRefNo, String updDt, String updUsrId) {
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.pckMtrlTpCd = pckMtrlTpCd;
		this.pckStyCd = pckStyCd;
		this.pagerows = pagerows;
		this.pckRefCd = pckRefCd;
		this.ibflag = ibflag;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.subSeq = subSeq;
		this.grpN3rdRefNo = grpN3rdRefNo;
		this.pckTpCd = pckTpCd;
		this.grpN2ndRefNo = grpN2ndRefNo;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.grpN2ndMeasUtCd = grpN2ndMeasUtCd;
		this.updDt = updDt;
		this.grpN1stRefNo = grpN1stRefNo;
		this.grpN1stQty = grpN1stQty;
		this.pckRefNo = pckRefNo;
		this.imdgPckCd = imdgPckCd;
		this.grpN2ndProhiFlg = grpN2ndProhiFlg;
		this.imdgPckDesc = imdgPckDesc;
		this.grpN2ndQty = grpN2ndQty;
		this.spclPckDesc = spclPckDesc;
		this.creUsrId = creUsrId;
		this.grpN3rdMeasUtCd = grpN3rdMeasUtCd;
		this.grpN3rdProhiFlg = grpN3rdProhiFlg;
		this.grpN3rdQty = grpN3rdQty;
		this.grpN1stMeasUtCd = grpN1stMeasUtCd;
		this.grpN1stProhiFlg = grpN1stProhiFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("pck_mtrl_tp_cd", getPckMtrlTpCd());
		this.hashColumns.put("pck_sty_cd", getPckStyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pck_ref_cd", getPckRefCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("sub_seq", getSubSeq());
		this.hashColumns.put("grp_n3rd_ref_no", getGrpN3rdRefNo());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("grp_n2nd_ref_no", getGrpN2ndRefNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("grp_n2nd_meas_ut_cd", getGrpN2ndMeasUtCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("grp_n1st_ref_no", getGrpN1stRefNo());
		this.hashColumns.put("grp_n1st_qty", getGrpN1stQty());
		this.hashColumns.put("pck_ref_no", getPckRefNo());
		this.hashColumns.put("imdg_pck_cd", getImdgPckCd());
		this.hashColumns.put("grp_n2nd_prohi_flg", getGrpN2ndProhiFlg());
		this.hashColumns.put("imdg_pck_desc", getImdgPckDesc());
		this.hashColumns.put("grp_n2nd_qty", getGrpN2ndQty());
		this.hashColumns.put("spcl_pck_desc", getSpclPckDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("grp_n3rd_meas_ut_cd", getGrpN3rdMeasUtCd());
		this.hashColumns.put("grp_n3rd_prohi_flg", getGrpN3rdProhiFlg());
		this.hashColumns.put("grp_n3rd_qty", getGrpN3rdQty());
		this.hashColumns.put("grp_n1st_meas_ut_cd", getGrpN1stMeasUtCd());
		this.hashColumns.put("grp_n1st_prohi_flg", getGrpN1stProhiFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("pck_mtrl_tp_cd", "pckMtrlTpCd");
		this.hashFields.put("pck_sty_cd", "pckStyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pck_ref_cd", "pckRefCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("sub_seq", "subSeq");
		this.hashFields.put("grp_n3rd_ref_no", "grpN3rdRefNo");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("grp_n2nd_ref_no", "grpN2ndRefNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("grp_n2nd_meas_ut_cd", "grpN2ndMeasUtCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("grp_n1st_ref_no", "grpN1stRefNo");
		this.hashFields.put("grp_n1st_qty", "grpN1stQty");
		this.hashFields.put("pck_ref_no", "pckRefNo");
		this.hashFields.put("imdg_pck_cd", "imdgPckCd");
		this.hashFields.put("grp_n2nd_prohi_flg", "grpN2ndProhiFlg");
		this.hashFields.put("imdg_pck_desc", "imdgPckDesc");
		this.hashFields.put("grp_n2nd_qty", "grpN2ndQty");
		this.hashFields.put("spcl_pck_desc", "spclPckDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("grp_n3rd_meas_ut_cd", "grpN3rdMeasUtCd");
		this.hashFields.put("grp_n3rd_prohi_flg", "grpN3rdProhiFlg");
		this.hashFields.put("grp_n3rd_qty", "grpN3rdQty");
		this.hashFields.put("grp_n1st_meas_ut_cd", "grpN1stMeasUtCd");
		this.hashFields.put("grp_n1st_prohi_flg", "grpN1stProhiFlg");
		return this.hashFields;
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
	 * @return imdgPckInstrSeq
	 */
	public String getImdgPckInstrSeq() {
		return this.imdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @return pckMtrlTpCd
	 */
	public String getPckMtrlTpCd() {
		return this.pckMtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @return pckStyCd
	 */
	public String getPckStyCd() {
		return this.pckStyCd;
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
	 * @return pckRefCd
	 */
	public String getPckRefCd() {
		return this.pckRefCd;
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
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return subSeq
	 */
	public String getSubSeq() {
		return this.subSeq;
	}
	
	/**
	 * Column Info
	 * @return grpN3rdRefNo
	 */
	public String getGrpN3rdRefNo() {
		return this.grpN3rdRefNo;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return grpN2ndRefNo
	 */
	public String getGrpN2ndRefNo() {
		return this.grpN2ndRefNo;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return grpN2ndMeasUtCd
	 */
	public String getGrpN2ndMeasUtCd() {
		return this.grpN2ndMeasUtCd;
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
	 * @return grpN1stRefNo
	 */
	public String getGrpN1stRefNo() {
		return this.grpN1stRefNo;
	}
	
	/**
	 * Column Info
	 * @return grpN1stQty
	 */
	public String getGrpN1stQty() {
		return this.grpN1stQty;
	}
	
	/**
	 * Column Info
	 * @return pckRefNo
	 */
	public String getPckRefNo() {
		return this.pckRefNo;
	}
	
	/**
	 * Column Info
	 * @return imdgPckCd
	 */
	public String getImdgPckCd() {
		return this.imdgPckCd;
	}
	
	/**
	 * Column Info
	 * @return grpN2ndProhiFlg
	 */
	public String getGrpN2ndProhiFlg() {
		return this.grpN2ndProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgPckDesc
	 */
	public String getImdgPckDesc() {
		return this.imdgPckDesc;
	}
	
	/**
	 * Column Info
	 * @return grpN2ndQty
	 */
	public String getGrpN2ndQty() {
		return this.grpN2ndQty;
	}
	
	/**
	 * Column Info
	 * @return spclPckDesc
	 */
	public String getSpclPckDesc() {
		return this.spclPckDesc;
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
	 * @return grpN3rdMeasUtCd
	 */
	public String getGrpN3rdMeasUtCd() {
		return this.grpN3rdMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return grpN3rdProhiFlg
	 */
	public String getGrpN3rdProhiFlg() {
		return this.grpN3rdProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return grpN3rdQty
	 */
	public String getGrpN3rdQty() {
		return this.grpN3rdQty;
	}
	
	/**
	 * Column Info
	 * @return grpN1stMeasUtCd
	 */
	public String getGrpN1stMeasUtCd() {
		return this.grpN1stMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return grpN1stProhiFlg
	 */
	public String getGrpN1stProhiFlg() {
		return this.grpN1stProhiFlg;
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
	 * @param imdgPckInstrSeq
	 */
	public void setImdgPckInstrSeq(String imdgPckInstrSeq) {
		this.imdgPckInstrSeq = imdgPckInstrSeq;
	}
	
	/**
	 * Column Info
	 * @param pckMtrlTpCd
	 */
	public void setPckMtrlTpCd(String pckMtrlTpCd) {
		this.pckMtrlTpCd = pckMtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @param pckStyCd
	 */
	public void setPckStyCd(String pckStyCd) {
		this.pckStyCd = pckStyCd;
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
	 * @param pckRefCd
	 */
	public void setPckRefCd(String pckRefCd) {
		this.pckRefCd = pckRefCd;
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
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param subSeq
	 */
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	
	/**
	 * Column Info
	 * @param grpN3rdRefNo
	 */
	public void setGrpN3rdRefNo(String grpN3rdRefNo) {
		this.grpN3rdRefNo = grpN3rdRefNo;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param grpN2ndRefNo
	 */
	public void setGrpN2ndRefNo(String grpN2ndRefNo) {
		this.grpN2ndRefNo = grpN2ndRefNo;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param grpN2ndMeasUtCd
	 */
	public void setGrpN2ndMeasUtCd(String grpN2ndMeasUtCd) {
		this.grpN2ndMeasUtCd = grpN2ndMeasUtCd;
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
	 * @param grpN1stRefNo
	 */
	public void setGrpN1stRefNo(String grpN1stRefNo) {
		this.grpN1stRefNo = grpN1stRefNo;
	}
	
	/**
	 * Column Info
	 * @param grpN1stQty
	 */
	public void setGrpN1stQty(String grpN1stQty) {
		this.grpN1stQty = grpN1stQty;
	}
	
	/**
	 * Column Info
	 * @param pckRefNo
	 */
	public void setPckRefNo(String pckRefNo) {
		this.pckRefNo = pckRefNo;
	}
	
	/**
	 * Column Info
	 * @param imdgPckCd
	 */
	public void setImdgPckCd(String imdgPckCd) {
		this.imdgPckCd = imdgPckCd;
	}
	
	/**
	 * Column Info
	 * @param grpN2ndProhiFlg
	 */
	public void setGrpN2ndProhiFlg(String grpN2ndProhiFlg) {
		this.grpN2ndProhiFlg = grpN2ndProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgPckDesc
	 */
	public void setImdgPckDesc(String imdgPckDesc) {
		this.imdgPckDesc = imdgPckDesc;
	}
	
	/**
	 * Column Info
	 * @param grpN2ndQty
	 */
	public void setGrpN2ndQty(String grpN2ndQty) {
		this.grpN2ndQty = grpN2ndQty;
	}
	
	/**
	 * Column Info
	 * @param spclPckDesc
	 */
	public void setSpclPckDesc(String spclPckDesc) {
		this.spclPckDesc = spclPckDesc;
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
	 * @param grpN3rdMeasUtCd
	 */
	public void setGrpN3rdMeasUtCd(String grpN3rdMeasUtCd) {
		this.grpN3rdMeasUtCd = grpN3rdMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param grpN3rdProhiFlg
	 */
	public void setGrpN3rdProhiFlg(String grpN3rdProhiFlg) {
		this.grpN3rdProhiFlg = grpN3rdProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param grpN3rdQty
	 */
	public void setGrpN3rdQty(String grpN3rdQty) {
		this.grpN3rdQty = grpN3rdQty;
	}
	
	/**
	 * Column Info
	 * @param grpN1stMeasUtCd
	 */
	public void setGrpN1stMeasUtCd(String grpN1stMeasUtCd) {
		this.grpN1stMeasUtCd = grpN1stMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param grpN1stProhiFlg
	 */
	public void setGrpN1stProhiFlg(String grpN1stProhiFlg) {
		this.grpN1stProhiFlg = grpN1stProhiFlg;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setPckMtrlTpCd(JSPUtil.getParameter(request, prefix + "pck_mtrl_tp_cd", ""));
		setPckStyCd(JSPUtil.getParameter(request, prefix + "pck_sty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPckRefCd(JSPUtil.getParameter(request, prefix + "pck_ref_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setSubSeq(JSPUtil.getParameter(request, prefix + "sub_seq", ""));
		setGrpN3rdRefNo(JSPUtil.getParameter(request, prefix + "grp_n3rd_ref_no", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setGrpN2ndRefNo(JSPUtil.getParameter(request, prefix + "grp_n2nd_ref_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setGrpN2ndMeasUtCd(JSPUtil.getParameter(request, prefix + "grp_n2nd_meas_ut_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setGrpN1stRefNo(JSPUtil.getParameter(request, prefix + "grp_n1st_ref_no", ""));
		setGrpN1stQty(JSPUtil.getParameter(request, prefix + "grp_n1st_qty", ""));
		setPckRefNo(JSPUtil.getParameter(request, prefix + "pck_ref_no", ""));
		setImdgPckCd(JSPUtil.getParameter(request, prefix + "imdg_pck_cd", ""));
		setGrpN2ndProhiFlg(JSPUtil.getParameter(request, prefix + "grp_n2nd_prohi_flg", ""));
		setImdgPckDesc(JSPUtil.getParameter(request, prefix + "imdg_pck_desc", ""));
		setGrpN2ndQty(JSPUtil.getParameter(request, prefix + "grp_n2nd_qty", ""));
		setSpclPckDesc(JSPUtil.getParameter(request, prefix + "spcl_pck_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setGrpN3rdMeasUtCd(JSPUtil.getParameter(request, prefix + "grp_n3rd_meas_ut_cd", ""));
		setGrpN3rdProhiFlg(JSPUtil.getParameter(request, prefix + "grp_n3rd_prohi_flg", ""));
		setGrpN3rdQty(JSPUtil.getParameter(request, prefix + "grp_n3rd_qty", ""));
		setGrpN1stMeasUtCd(JSPUtil.getParameter(request, prefix + "grp_n1st_meas_ut_cd", ""));
		setGrpN1stProhiFlg(JSPUtil.getParameter(request, prefix + "grp_n1st_prohi_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckPkgVO[]
	 */
	public ScgPckPkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckPkgVO[]
	 */
	public ScgPckPkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckPkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] pckMtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_mtrl_tp_cd", length));
			String[] pckStyCd = (JSPUtil.getParameter(request, prefix	+ "pck_sty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pckRefCd = (JSPUtil.getParameter(request, prefix	+ "pck_ref_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] subSeq = (JSPUtil.getParameter(request, prefix	+ "sub_seq", length));
			String[] grpN3rdRefNo = (JSPUtil.getParameter(request, prefix	+ "grp_n3rd_ref_no", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] grpN2ndRefNo = (JSPUtil.getParameter(request, prefix	+ "grp_n2nd_ref_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] grpN2ndMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "grp_n2nd_meas_ut_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] grpN1stRefNo = (JSPUtil.getParameter(request, prefix	+ "grp_n1st_ref_no", length));
			String[] grpN1stQty = (JSPUtil.getParameter(request, prefix	+ "grp_n1st_qty", length));
			String[] pckRefNo = (JSPUtil.getParameter(request, prefix	+ "pck_ref_no", length));
			String[] imdgPckCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_cd", length));
			String[] grpN2ndProhiFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n2nd_prohi_flg", length));
			String[] imdgPckDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_desc", length));
			String[] grpN2ndQty = (JSPUtil.getParameter(request, prefix	+ "grp_n2nd_qty", length));
			String[] spclPckDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_pck_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] grpN3rdMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "grp_n3rd_meas_ut_cd", length));
			String[] grpN3rdProhiFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n3rd_prohi_flg", length));
			String[] grpN3rdQty = (JSPUtil.getParameter(request, prefix	+ "grp_n3rd_qty", length));
			String[] grpN1stMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "grp_n1st_meas_ut_cd", length));
			String[] grpN1stProhiFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n1st_prohi_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckPkgVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (pckMtrlTpCd[i] != null)
					model.setPckMtrlTpCd(pckMtrlTpCd[i]);
				if (pckStyCd[i] != null)
					model.setPckStyCd(pckStyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pckRefCd[i] != null)
					model.setPckRefCd(pckRefCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (subSeq[i] != null)
					model.setSubSeq(subSeq[i]);
				if (grpN3rdRefNo[i] != null)
					model.setGrpN3rdRefNo(grpN3rdRefNo[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (grpN2ndRefNo[i] != null)
					model.setGrpN2ndRefNo(grpN2ndRefNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (grpN2ndMeasUtCd[i] != null)
					model.setGrpN2ndMeasUtCd(grpN2ndMeasUtCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (grpN1stRefNo[i] != null)
					model.setGrpN1stRefNo(grpN1stRefNo[i]);
				if (grpN1stQty[i] != null)
					model.setGrpN1stQty(grpN1stQty[i]);
				if (pckRefNo[i] != null)
					model.setPckRefNo(pckRefNo[i]);
				if (imdgPckCd[i] != null)
					model.setImdgPckCd(imdgPckCd[i]);
				if (grpN2ndProhiFlg[i] != null)
					model.setGrpN2ndProhiFlg(grpN2ndProhiFlg[i]);
				if (imdgPckDesc[i] != null)
					model.setImdgPckDesc(imdgPckDesc[i]);
				if (grpN2ndQty[i] != null)
					model.setGrpN2ndQty(grpN2ndQty[i]);
				if (spclPckDesc[i] != null)
					model.setSpclPckDesc(spclPckDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (grpN3rdMeasUtCd[i] != null)
					model.setGrpN3rdMeasUtCd(grpN3rdMeasUtCd[i]);
				if (grpN3rdProhiFlg[i] != null)
					model.setGrpN3rdProhiFlg(grpN3rdProhiFlg[i]);
				if (grpN3rdQty[i] != null)
					model.setGrpN3rdQty(grpN3rdQty[i]);
				if (grpN1stMeasUtCd[i] != null)
					model.setGrpN1stMeasUtCd(grpN1stMeasUtCd[i]);
				if (grpN1stProhiFlg[i] != null)
					model.setGrpN1stProhiFlg(grpN1stProhiFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckPkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckPkgVO[]
	 */
	public ScgPckPkgVO[] getScgPckPkgVOs(){
		ScgPckPkgVO[] vos = (ScgPckPkgVO[])models.toArray(new ScgPckPkgVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckMtrlTpCd = this.pckMtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckStyCd = this.pckStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckRefCd = this.pckRefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSeq = this.subSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN3rdRefNo = this.grpN3rdRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN2ndRefNo = this.grpN2ndRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN2ndMeasUtCd = this.grpN2ndMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN1stRefNo = this.grpN1stRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN1stQty = this.grpN1stQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckRefNo = this.pckRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckCd = this.imdgPckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN2ndProhiFlg = this.grpN2ndProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckDesc = this.imdgPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN2ndQty = this.grpN2ndQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclPckDesc = this.spclPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN3rdMeasUtCd = this.grpN3rdMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN3rdProhiFlg = this.grpN3rdProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN3rdQty = this.grpN3rdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN1stMeasUtCd = this.grpN1stMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN1stProhiFlg = this.grpN1stProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
