/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InVesselArrivalDetailVO.java
*@FileTitle : InVesselArrivalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.19 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InVesselArrivalDetailVO extends VesselArrivalDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<InVesselArrivalDetailVO> models = new ArrayList<InVesselArrivalDetailVO>();
	
	/* Column Info */
	private String idaAgnId = null;
	/* Column Info */
	private String arrDt2 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String idaCfsId = null;
	/* Column Info */
	private String idaLineNo = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crrAgnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslDeclDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ibAreaCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String idaDeclVslNo = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String idaYrNo = null;
	/* Column Info */
	private String idaVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String trnsOprId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String idaMrnLineOprCd = null;
	/* Column Info */
	private String ibdNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InVesselArrivalDetailVO() {}

	public InVesselArrivalDetailVO(String ibflag, String pagerows, String vvdCd, String vslCd, String skdVoyNo, String skdDirCd, String podCd, String idaDeclVslNo, String vslDeclDt, String vslNm, String callSgnNo, String idaLineNo, String idaAgnId, String cntCd, String portCd, String arrDt, String arrDt2, String ibdNo, String crrAgnCd, String idaMrnLineOprCd, String idaCfsId, String ibAreaCd, String bdAreaCd, String idaVoyNo, String idaYrNo, String trnsOprId, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.idaAgnId = idaAgnId;
		this.arrDt2 = arrDt2;
		this.vslCd = vslCd;
		this.idaCfsId = idaCfsId;
		this.idaLineNo = idaLineNo;
		this.arrDt = arrDt;
		this.creDt = creDt;
		this.crrAgnCd = crrAgnCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.cntCd = cntCd;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.vslDeclDt = vslDeclDt;
		this.callSgnNo = callSgnNo;
		this.ibAreaCd = ibAreaCd;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.idaDeclVslNo = idaDeclVslNo;
		this.bdAreaCd = bdAreaCd;
		this.idaYrNo = idaYrNo;
		this.idaVoyNo = idaVoyNo;
		this.skdDirCd = skdDirCd;
		this.trnsOprId = trnsOprId;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.idaMrnLineOprCd = idaMrnLineOprCd;
		this.ibdNo = ibdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ida_agn_id", getIdaAgnId());
		this.hashColumns.put("arr_dt2", getArrDt2());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ida_cfs_id", getIdaCfsId());
		this.hashColumns.put("ida_line_no", getIdaLineNo());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crr_agn_cd", getCrrAgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_decl_dt", getVslDeclDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("ib_area_cd", getIbAreaCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("ida_decl_vsl_no", getIdaDeclVslNo());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("ida_yr_no", getIdaYrNo());
		this.hashColumns.put("ida_voy_no", getIdaVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("trns_opr_id", getTrnsOprId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ida_mrn_line_opr_cd", getIdaMrnLineOprCd());
		this.hashColumns.put("ibd_no", getIbdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ida_agn_id", "idaAgnId");
		this.hashFields.put("arr_dt2", "arrDt2");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ida_cfs_id", "idaCfsId");
		this.hashFields.put("ida_line_no", "idaLineNo");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crr_agn_cd", "crrAgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_decl_dt", "vslDeclDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ib_area_cd", "ibAreaCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("ida_decl_vsl_no", "idaDeclVslNo");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("ida_yr_no", "idaYrNo");
		this.hashFields.put("ida_voy_no", "idaVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("trns_opr_id", "trnsOprId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ida_mrn_line_opr_cd", "idaMrnLineOprCd");
		this.hashFields.put("ibd_no", "ibdNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idaAgnId
	 */
	public String getIdaAgnId() {
		return this.idaAgnId;
	}
	
	/**
	 * Column Info
	 * @return arrDt2
	 */
	public String getArrDt2() {
		return this.arrDt2;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return idaCfsId
	 */
	public String getIdaCfsId() {
		return this.idaCfsId;
	}
	
	/**
	 * Column Info
	 * @return idaLineNo
	 */
	public String getIdaLineNo() {
		return this.idaLineNo;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
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
	 * @return crrAgnCd
	 */
	public String getCrrAgnCd() {
		return this.crrAgnCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return vslDeclDt
	 */
	public String getVslDeclDt() {
		return this.vslDeclDt;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return ibAreaCd
	 */
	public String getIbAreaCd() {
		return this.ibAreaCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return idaDeclVslNo
	 */
	public String getIdaDeclVslNo() {
		return this.idaDeclVslNo;
	}
	
	/**
	 * Column Info
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @return idaYrNo
	 */
	public String getIdaYrNo() {
		return this.idaYrNo;
	}
	
	/**
	 * Column Info
	 * @return idaVoyNo
	 */
	public String getIdaVoyNo() {
		return this.idaVoyNo;
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
	 * @return trnsOprId
	 */
	public String getTrnsOprId() {
		return this.trnsOprId;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return idaMrnLineOprCd
	 */
	public String getIdaMrnLineOprCd() {
		return this.idaMrnLineOprCd;
	}
	
	/**
	 * Column Info
	 * @return ibdNo
	 */
	public String getIbdNo() {
		return this.ibdNo;
	}
	

	/**
	 * Column Info
	 * @param idaAgnId
	 */
	public void setIdaAgnId(String idaAgnId) {
		this.idaAgnId = idaAgnId;
	}
	
	/**
	 * Column Info
	 * @param arrDt2
	 */
	public void setArrDt2(String arrDt2) {
		this.arrDt2 = arrDt2;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param idaCfsId
	 */
	public void setIdaCfsId(String idaCfsId) {
		this.idaCfsId = idaCfsId;
	}
	
	/**
	 * Column Info
	 * @param idaLineNo
	 */
	public void setIdaLineNo(String idaLineNo) {
		this.idaLineNo = idaLineNo;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
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
	 * @param crrAgnCd
	 */
	public void setCrrAgnCd(String crrAgnCd) {
		this.crrAgnCd = crrAgnCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param vslDeclDt
	 */
	public void setVslDeclDt(String vslDeclDt) {
		this.vslDeclDt = vslDeclDt;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param ibAreaCd
	 */
	public void setIbAreaCd(String ibAreaCd) {
		this.ibAreaCd = ibAreaCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param idaDeclVslNo
	 */
	public void setIdaDeclVslNo(String idaDeclVslNo) {
		this.idaDeclVslNo = idaDeclVslNo;
	}
	
	/**
	 * Column Info
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @param idaYrNo
	 */
	public void setIdaYrNo(String idaYrNo) {
		this.idaYrNo = idaYrNo;
	}
	
	/**
	 * Column Info
	 * @param idaVoyNo
	 */
	public void setIdaVoyNo(String idaVoyNo) {
		this.idaVoyNo = idaVoyNo;
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
	 * @param trnsOprId
	 */
	public void setTrnsOprId(String trnsOprId) {
		this.trnsOprId = trnsOprId;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param idaMrnLineOprCd
	 */
	public void setIdaMrnLineOprCd(String idaMrnLineOprCd) {
		this.idaMrnLineOprCd = idaMrnLineOprCd;
	}
	
	/**
	 * Column Info
	 * @param ibdNo
	 */
	public void setIbdNo(String ibdNo) {
		this.ibdNo = ibdNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIdaAgnId(JSPUtil.getParameter(request, "ida_agn_id", ""));
		setArrDt2(JSPUtil.getParameter(request, "arr_dt2", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIdaCfsId(JSPUtil.getParameter(request, "ida_cfs_id", ""));
		setIdaLineNo(JSPUtil.getParameter(request, "ida_line_no", ""));
		setArrDt(JSPUtil.getParameter(request, "arr_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCrrAgnCd(JSPUtil.getParameter(request, "crr_agn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVslDeclDt(JSPUtil.getParameter(request, "vsl_decl_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setIbAreaCd(JSPUtil.getParameter(request, "ib_area_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setIdaDeclVslNo(JSPUtil.getParameter(request, "ida_decl_vsl_no", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setIdaYrNo(JSPUtil.getParameter(request, "ida_yr_no", ""));
		setIdaVoyNo(JSPUtil.getParameter(request, "ida_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setTrnsOprId(JSPUtil.getParameter(request, "trns_opr_id", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIdaMrnLineOprCd(JSPUtil.getParameter(request, "ida_mrn_line_opr_cd", ""));
		setIbdNo(JSPUtil.getParameter(request, "ibd_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InVesselArrivalDetailVO[]
	 */
	public InVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InVesselArrivalDetailVO[]
	 */
	public InVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InVesselArrivalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idaAgnId = (JSPUtil.getParameter(request, prefix	+ "ida_agn_id", length));
			String[] arrDt2 = (JSPUtil.getParameter(request, prefix	+ "arr_dt2", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] idaCfsId = (JSPUtil.getParameter(request, prefix	+ "ida_cfs_id", length));
			String[] idaLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_line_no", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crrAgnCd = (JSPUtil.getParameter(request, prefix	+ "crr_agn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslDeclDt = (JSPUtil.getParameter(request, prefix	+ "vsl_decl_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ibAreaCd = (JSPUtil.getParameter(request, prefix	+ "ib_area_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] idaDeclVslNo = (JSPUtil.getParameter(request, prefix	+ "ida_decl_vsl_no", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] idaYrNo = (JSPUtil.getParameter(request, prefix	+ "ida_yr_no", length));
			String[] idaVoyNo = (JSPUtil.getParameter(request, prefix	+ "ida_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] trnsOprId = (JSPUtil.getParameter(request, prefix	+ "trns_opr_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] idaMrnLineOprCd = (JSPUtil.getParameter(request, prefix	+ "ida_mrn_line_opr_cd", length));
			String[] ibdNo = (JSPUtil.getParameter(request, prefix	+ "ibd_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new InVesselArrivalDetailVO();
				if (idaAgnId[i] != null)
					model.setIdaAgnId(idaAgnId[i]);
				if (arrDt2[i] != null)
					model.setArrDt2(arrDt2[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (idaCfsId[i] != null)
					model.setIdaCfsId(idaCfsId[i]);
				if (idaLineNo[i] != null)
					model.setIdaLineNo(idaLineNo[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crrAgnCd[i] != null)
					model.setCrrAgnCd(crrAgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslDeclDt[i] != null)
					model.setVslDeclDt(vslDeclDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ibAreaCd[i] != null)
					model.setIbAreaCd(ibAreaCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (idaDeclVslNo[i] != null)
					model.setIdaDeclVslNo(idaDeclVslNo[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (idaYrNo[i] != null)
					model.setIdaYrNo(idaYrNo[i]);
				if (idaVoyNo[i] != null)
					model.setIdaVoyNo(idaVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (trnsOprId[i] != null)
					model.setTrnsOprId(trnsOprId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (idaMrnLineOprCd[i] != null)
					model.setIdaMrnLineOprCd(idaMrnLineOprCd[i]);
				if (ibdNo[i] != null)
					model.setIbdNo(ibdNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInVesselArrivalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InVesselArrivalDetailVO[]
	 */
	public InVesselArrivalDetailVO[] getInVesselArrivalDetailVOs(){
		InVesselArrivalDetailVO[] vos = (InVesselArrivalDetailVO[])models.toArray(new InVesselArrivalDetailVO[models.size()]);
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
		this.idaAgnId = this.idaAgnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt2 = this.arrDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCfsId = this.idaCfsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaLineNo = this.idaLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAgnCd = this.crrAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeclDt = this.vslDeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibAreaCd = this.ibAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDeclVslNo = this.idaDeclVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaYrNo = this.idaYrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaVoyNo = this.idaVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsOprId = this.trnsOprId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaMrnLineOprCd = this.idaMrnLineOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdNo = this.ibdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
