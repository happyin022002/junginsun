/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VslSkdXchEdiHdrVO.java
*@FileTitle : VslSkdXchEdiHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdXchEdiHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdXchEdiHdrVO> models = new ArrayList<VslSkdXchEdiHdrVO>();
	
	/* Column Info */
	private String mapgScsFlg = null;
	/* Column Info */
	private String skdCngStsCdCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslCdCtnt = null;
	/* Column Info */
	private String picCntcTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String picCntcNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String shpCallNo = null;
	/* Column Info */
	private String coCdCtnt = null;
	/* Column Info */
	private String ediFuncCdCtnt = null;
	/* Column Info */
	private String skdDirCdCtnt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ediRmk = null;
	/* Column Info */
	private String skdVoyNoCtnt = null;
	/* Column Info */
	private String arrDepIndCdCtnt = null;
	/* Column Info */
	private String picNm = null;
	/* Column Info */
	private String ediHdrMsg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String skdEdiRcvSeq = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String skdEdiRcvDt = null;
	/* Column Info */
	private String vslSlanCdCtnt = null;
	/* Column Info */
	private String ediProcRmk = null;
	/* Column Info */
	private String sndRcvKndCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VslSkdXchEdiHdrVO() {}

	public VslSkdXchEdiHdrVO(String ibflag, String pagerows, String sndRcvKndCd, String skdEdiRcvDt, String skdEdiRcvSeq, String vslCdCtnt, String skdVoyNoCtnt, String skdDirCdCtnt, String ediHdrMsg, String ediFuncCdCtnt, String coCdCtnt, String vslSlanCdCtnt, String skdCngStsCdCtnt, String arrDepIndCdCtnt, String callSgnNo, String lloydNo, String shpCallNo, String vslEngNm, String picNm, String picCntcTpCd, String picCntcNo, String ediRmk, String mapgScsFlg, String ediProcRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.mapgScsFlg = mapgScsFlg;
		this.skdCngStsCdCtnt = skdCngStsCdCtnt;
		this.creDt = creDt;
		this.vslCdCtnt = vslCdCtnt;
		this.picCntcTpCd = picCntcTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.updUsrId = updUsrId;
		this.picCntcNo = picCntcNo;
		this.updDt = updDt;
		this.shpCallNo = shpCallNo;
		this.coCdCtnt = coCdCtnt;
		this.ediFuncCdCtnt = ediFuncCdCtnt;
		this.skdDirCdCtnt = skdDirCdCtnt;
		this.callSgnNo = callSgnNo;
		this.ediRmk = ediRmk;
		this.skdVoyNoCtnt = skdVoyNoCtnt;
		this.arrDepIndCdCtnt = arrDepIndCdCtnt;
		this.picNm = picNm;
		this.ediHdrMsg = ediHdrMsg;
		this.creUsrId = creUsrId;
		this.skdEdiRcvSeq = skdEdiRcvSeq;
		this.lloydNo = lloydNo;
		this.skdEdiRcvDt = skdEdiRcvDt;
		this.vslSlanCdCtnt = vslSlanCdCtnt;
		this.ediProcRmk = ediProcRmk;
		this.sndRcvKndCd = sndRcvKndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mapg_scs_flg", getMapgScsFlg());
		this.hashColumns.put("skd_cng_sts_cd_ctnt", getSkdCngStsCdCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_cd_ctnt", getVslCdCtnt());
		this.hashColumns.put("pic_cntc_tp_cd", getPicCntcTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pic_cntc_no", getPicCntcNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("shp_call_no", getShpCallNo());
		this.hashColumns.put("co_cd_ctnt", getCoCdCtnt());
		this.hashColumns.put("edi_func_cd_ctnt", getEdiFuncCdCtnt());
		this.hashColumns.put("skd_dir_cd_ctnt", getSkdDirCdCtnt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("edi_rmk", getEdiRmk());
		this.hashColumns.put("skd_voy_no_ctnt", getSkdVoyNoCtnt());
		this.hashColumns.put("arr_dep_ind_cd_ctnt", getArrDepIndCdCtnt());
		this.hashColumns.put("pic_nm", getPicNm());
		this.hashColumns.put("edi_hdr_msg", getEdiHdrMsg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("skd_edi_rcv_seq", getSkdEdiRcvSeq());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("skd_edi_rcv_dt", getSkdEdiRcvDt());
		this.hashColumns.put("vsl_slan_cd_ctnt", getVslSlanCdCtnt());
		this.hashColumns.put("edi_proc_rmk", getEdiProcRmk());
		this.hashColumns.put("snd_rcv_knd_cd", getSndRcvKndCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mapg_scs_flg", "mapgScsFlg");
		this.hashFields.put("skd_cng_sts_cd_ctnt", "skdCngStsCdCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_cd_ctnt", "vslCdCtnt");
		this.hashFields.put("pic_cntc_tp_cd", "picCntcTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pic_cntc_no", "picCntcNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("shp_call_no", "shpCallNo");
		this.hashFields.put("co_cd_ctnt", "coCdCtnt");
		this.hashFields.put("edi_func_cd_ctnt", "ediFuncCdCtnt");
		this.hashFields.put("skd_dir_cd_ctnt", "skdDirCdCtnt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("edi_rmk", "ediRmk");
		this.hashFields.put("skd_voy_no_ctnt", "skdVoyNoCtnt");
		this.hashFields.put("arr_dep_ind_cd_ctnt", "arrDepIndCdCtnt");
		this.hashFields.put("pic_nm", "picNm");
		this.hashFields.put("edi_hdr_msg", "ediHdrMsg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("skd_edi_rcv_seq", "skdEdiRcvSeq");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("skd_edi_rcv_dt", "skdEdiRcvDt");
		this.hashFields.put("vsl_slan_cd_ctnt", "vslSlanCdCtnt");
		this.hashFields.put("edi_proc_rmk", "ediProcRmk");
		this.hashFields.put("snd_rcv_knd_cd", "sndRcvKndCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mapgScsFlg
	 */
	public String getMapgScsFlg() {
		return this.mapgScsFlg;
	}
	
	/**
	 * Column Info
	 * @return skdCngStsCdCtnt
	 */
	public String getSkdCngStsCdCtnt() {
		return this.skdCngStsCdCtnt;
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
	 * @return vslCdCtnt
	 */
	public String getVslCdCtnt() {
		return this.vslCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return picCntcTpCd
	 */
	public String getPicCntcTpCd() {
		return this.picCntcTpCd;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
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
	 * @return picCntcNo
	 */
	public String getPicCntcNo() {
		return this.picCntcNo;
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
	 * @return shpCallNo
	 */
	public String getShpCallNo() {
		return this.shpCallNo;
	}
	
	/**
	 * Column Info
	 * @return coCdCtnt
	 */
	public String getCoCdCtnt() {
		return this.coCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return ediFuncCdCtnt
	 */
	public String getEdiFuncCdCtnt() {
		return this.ediFuncCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCdCtnt
	 */
	public String getSkdDirCdCtnt() {
		return this.skdDirCdCtnt;
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
	 * @return ediRmk
	 */
	public String getEdiRmk() {
		return this.ediRmk;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNoCtnt
	 */
	public String getSkdVoyNoCtnt() {
		return this.skdVoyNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrDepIndCdCtnt
	 */
	public String getArrDepIndCdCtnt() {
		return this.arrDepIndCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return picNm
	 */
	public String getPicNm() {
		return this.picNm;
	}
	
	/**
	 * Column Info
	 * @return ediHdrMsg
	 */
	public String getEdiHdrMsg() {
		return this.ediHdrMsg;
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
	 * @return skdEdiRcvSeq
	 */
	public String getSkdEdiRcvSeq() {
		return this.skdEdiRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return skdEdiRcvDt
	 */
	public String getSkdEdiRcvDt() {
		return this.skdEdiRcvDt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCdCtnt
	 */
	public String getVslSlanCdCtnt() {
		return this.vslSlanCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return ediProcRmk
	 */
	public String getEdiProcRmk() {
		return this.ediProcRmk;
	}
	
	/**
	 * Column Info
	 * @return sndRcvKndCd
	 */
	public String getSndRcvKndCd() {
		return this.sndRcvKndCd;
	}
	

	/**
	 * Column Info
	 * @param mapgScsFlg
	 */
	public void setMapgScsFlg(String mapgScsFlg) {
		this.mapgScsFlg = mapgScsFlg;
	}
	
	/**
	 * Column Info
	 * @param skdCngStsCdCtnt
	 */
	public void setSkdCngStsCdCtnt(String skdCngStsCdCtnt) {
		this.skdCngStsCdCtnt = skdCngStsCdCtnt;
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
	 * @param vslCdCtnt
	 */
	public void setVslCdCtnt(String vslCdCtnt) {
		this.vslCdCtnt = vslCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param picCntcTpCd
	 */
	public void setPicCntcTpCd(String picCntcTpCd) {
		this.picCntcTpCd = picCntcTpCd;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
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
	 * @param picCntcNo
	 */
	public void setPicCntcNo(String picCntcNo) {
		this.picCntcNo = picCntcNo;
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
	 * @param shpCallNo
	 */
	public void setShpCallNo(String shpCallNo) {
		this.shpCallNo = shpCallNo;
	}
	
	/**
	 * Column Info
	 * @param coCdCtnt
	 */
	public void setCoCdCtnt(String coCdCtnt) {
		this.coCdCtnt = coCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param ediFuncCdCtnt
	 */
	public void setEdiFuncCdCtnt(String ediFuncCdCtnt) {
		this.ediFuncCdCtnt = ediFuncCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCdCtnt
	 */
	public void setSkdDirCdCtnt(String skdDirCdCtnt) {
		this.skdDirCdCtnt = skdDirCdCtnt;
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
	 * @param ediRmk
	 */
	public void setEdiRmk(String ediRmk) {
		this.ediRmk = ediRmk;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNoCtnt
	 */
	public void setSkdVoyNoCtnt(String skdVoyNoCtnt) {
		this.skdVoyNoCtnt = skdVoyNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrDepIndCdCtnt
	 */
	public void setArrDepIndCdCtnt(String arrDepIndCdCtnt) {
		this.arrDepIndCdCtnt = arrDepIndCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param picNm
	 */
	public void setPicNm(String picNm) {
		this.picNm = picNm;
	}
	
	/**
	 * Column Info
	 * @param ediHdrMsg
	 */
	public void setEdiHdrMsg(String ediHdrMsg) {
		this.ediHdrMsg = ediHdrMsg;
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
	 * @param skdEdiRcvSeq
	 */
	public void setSkdEdiRcvSeq(String skdEdiRcvSeq) {
		this.skdEdiRcvSeq = skdEdiRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param skdEdiRcvDt
	 */
	public void setSkdEdiRcvDt(String skdEdiRcvDt) {
		this.skdEdiRcvDt = skdEdiRcvDt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCdCtnt
	 */
	public void setVslSlanCdCtnt(String vslSlanCdCtnt) {
		this.vslSlanCdCtnt = vslSlanCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param ediProcRmk
	 */
	public void setEdiProcRmk(String ediProcRmk) {
		this.ediProcRmk = ediProcRmk;
	}
	
	/**
	 * Column Info
	 * @param sndRcvKndCd
	 */
	public void setSndRcvKndCd(String sndRcvKndCd) {
		this.sndRcvKndCd = sndRcvKndCd;
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
		setMapgScsFlg(JSPUtil.getParameter(request, prefix + "mapg_scs_flg", ""));
		setSkdCngStsCdCtnt(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslCdCtnt(JSPUtil.getParameter(request, prefix + "vsl_cd_ctnt", ""));
		setPicCntcTpCd(JSPUtil.getParameter(request, prefix + "pic_cntc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPicCntcNo(JSPUtil.getParameter(request, prefix + "pic_cntc_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setShpCallNo(JSPUtil.getParameter(request, prefix + "shp_call_no", ""));
		setCoCdCtnt(JSPUtil.getParameter(request, prefix + "co_cd_ctnt", ""));
		setEdiFuncCdCtnt(JSPUtil.getParameter(request, prefix + "edi_func_cd_ctnt", ""));
		setSkdDirCdCtnt(JSPUtil.getParameter(request, prefix + "skd_dir_cd_ctnt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setEdiRmk(JSPUtil.getParameter(request, prefix + "edi_rmk", ""));
		setSkdVoyNoCtnt(JSPUtil.getParameter(request, prefix + "skd_voy_no_ctnt", ""));
		setArrDepIndCdCtnt(JSPUtil.getParameter(request, prefix + "arr_dep_ind_cd_ctnt", ""));
		setPicNm(JSPUtil.getParameter(request, prefix + "pic_nm", ""));
		setEdiHdrMsg(JSPUtil.getParameter(request, prefix + "edi_hdr_msg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSkdEdiRcvSeq(JSPUtil.getParameter(request, prefix + "skd_edi_rcv_seq", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setSkdEdiRcvDt(JSPUtil.getParameter(request, prefix + "skd_edi_rcv_dt", ""));
		setVslSlanCdCtnt(JSPUtil.getParameter(request, prefix + "vsl_slan_cd_ctnt", ""));
		setEdiProcRmk(JSPUtil.getParameter(request, prefix + "edi_proc_rmk", ""));
		setSndRcvKndCd(JSPUtil.getParameter(request, prefix + "snd_rcv_knd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdXchEdiHdrVO[]
	 */
	public VslSkdXchEdiHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdXchEdiHdrVO[]
	 */
	public VslSkdXchEdiHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdXchEdiHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mapgScsFlg = (JSPUtil.getParameter(request, prefix	+ "mapg_scs_flg", length));
			String[] skdCngStsCdCtnt = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_ctnt", length));
			String[] picCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "pic_cntc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] picCntcNo = (JSPUtil.getParameter(request, prefix	+ "pic_cntc_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] shpCallNo = (JSPUtil.getParameter(request, prefix	+ "shp_call_no", length));
			String[] coCdCtnt = (JSPUtil.getParameter(request, prefix	+ "co_cd_ctnt", length));
			String[] ediFuncCdCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_func_cd_ctnt", length));
			String[] skdDirCdCtnt = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd_ctnt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ediRmk = (JSPUtil.getParameter(request, prefix	+ "edi_rmk", length));
			String[] skdVoyNoCtnt = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no_ctnt", length));
			String[] arrDepIndCdCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_dep_ind_cd_ctnt", length));
			String[] picNm = (JSPUtil.getParameter(request, prefix	+ "pic_nm", length));
			String[] ediHdrMsg = (JSPUtil.getParameter(request, prefix	+ "edi_hdr_msg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] skdEdiRcvSeq = (JSPUtil.getParameter(request, prefix	+ "skd_edi_rcv_seq", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] skdEdiRcvDt = (JSPUtil.getParameter(request, prefix	+ "skd_edi_rcv_dt", length));
			String[] vslSlanCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd_ctnt", length));
			String[] ediProcRmk = (JSPUtil.getParameter(request, prefix	+ "edi_proc_rmk", length));
			String[] sndRcvKndCd = (JSPUtil.getParameter(request, prefix	+ "snd_rcv_knd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdXchEdiHdrVO();
				if (mapgScsFlg[i] != null)
					model.setMapgScsFlg(mapgScsFlg[i]);
				if (skdCngStsCdCtnt[i] != null)
					model.setSkdCngStsCdCtnt(skdCngStsCdCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslCdCtnt[i] != null)
					model.setVslCdCtnt(vslCdCtnt[i]);
				if (picCntcTpCd[i] != null)
					model.setPicCntcTpCd(picCntcTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (picCntcNo[i] != null)
					model.setPicCntcNo(picCntcNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (shpCallNo[i] != null)
					model.setShpCallNo(shpCallNo[i]);
				if (coCdCtnt[i] != null)
					model.setCoCdCtnt(coCdCtnt[i]);
				if (ediFuncCdCtnt[i] != null)
					model.setEdiFuncCdCtnt(ediFuncCdCtnt[i]);
				if (skdDirCdCtnt[i] != null)
					model.setSkdDirCdCtnt(skdDirCdCtnt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ediRmk[i] != null)
					model.setEdiRmk(ediRmk[i]);
				if (skdVoyNoCtnt[i] != null)
					model.setSkdVoyNoCtnt(skdVoyNoCtnt[i]);
				if (arrDepIndCdCtnt[i] != null)
					model.setArrDepIndCdCtnt(arrDepIndCdCtnt[i]);
				if (picNm[i] != null)
					model.setPicNm(picNm[i]);
				if (ediHdrMsg[i] != null)
					model.setEdiHdrMsg(ediHdrMsg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (skdEdiRcvSeq[i] != null)
					model.setSkdEdiRcvSeq(skdEdiRcvSeq[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (skdEdiRcvDt[i] != null)
					model.setSkdEdiRcvDt(skdEdiRcvDt[i]);
				if (vslSlanCdCtnt[i] != null)
					model.setVslSlanCdCtnt(vslSlanCdCtnt[i]);
				if (ediProcRmk[i] != null)
					model.setEdiProcRmk(ediProcRmk[i]);
				if (sndRcvKndCd[i] != null)
					model.setSndRcvKndCd(sndRcvKndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdXchEdiHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdXchEdiHdrVO[]
	 */
	public VslSkdXchEdiHdrVO[] getVslSkdXchEdiHdrVOs(){
		VslSkdXchEdiHdrVO[] vos = (VslSkdXchEdiHdrVO[])models.toArray(new VslSkdXchEdiHdrVO[models.size()]);
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
		this.mapgScsFlg = this.mapgScsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCdCtnt = this.skdCngStsCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdCtnt = this.vslCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picCntcTpCd = this.picCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picCntcNo = this.picCntcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCallNo = this.shpCallNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCdCtnt = this.coCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediFuncCdCtnt = this.ediFuncCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCdCtnt = this.skdDirCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRmk = this.ediRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNoCtnt = this.skdVoyNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDepIndCdCtnt = this.arrDepIndCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picNm = this.picNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHdrMsg = this.ediHdrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdEdiRcvSeq = this.skdEdiRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdEdiRcvDt = this.skdEdiRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCdCtnt = this.vslSlanCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediProcRmk = this.ediProcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRcvKndCd = this.sndRcvKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
