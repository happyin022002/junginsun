/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneVO.java
*@FileTitle : LaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.01 장창수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo;

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
 * @author 장창수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LaneVO> models = new ArrayList<LaneVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String stlYrmon = null;
	/* Column Info */
	private String laneRmk = null;
	/* Column Info */
	private String oldTrdCd1 = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String oldTrdCd3 = null;
	/* Column Info */
	private String oldTrdCd2 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String erpSlanCd = null;
	/* Column Info */
	private String bsaSlanCd = null;	
	/* Column Info */
	private String laneSeqList = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trdCd3Seq = null;
	/* Column Info */
	private String trdCd2Seq = null;
	/* Column Info */
	private String laneSeq = null;
	/* Column Info */
	private String trdCd3 = null;
	/* Column Info */
	private String trdCd2 = null;
	/* Column Info */
	private String trdCd1Seq = null;
	/* Column Info */
	private String trdCd1 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stsFlg = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LaneVO() {}

	public LaneVO(String ibflag, String pagerows, String stlYrmon, String vslSlanCd, String erpSlanCd, String bsaSlanCd, String laneRmk, String deltFlg, String creDt, String creUsrId, String updDt, String updUsrId, String oldTrdCd1, String oldTrdCd2, String oldTrdCd3, String trdCd1, String trdCd2, String trdCd3, String trdCd1Seq, String trdCd2Seq, String trdCd3Seq, String trdCd, String laneSeq, String laneSeqList, String stsFlg) {
		this.updDt = updDt;
		this.stlYrmon = stlYrmon;
		this.laneRmk = laneRmk;
		this.oldTrdCd1 = oldTrdCd1;
		this.deltFlg = deltFlg;
		this.oldTrdCd3 = oldTrdCd3;
		this.oldTrdCd2 = oldTrdCd2;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.vslSlanCd = vslSlanCd;
		this.erpSlanCd = erpSlanCd;
		this.bsaSlanCd = bsaSlanCd;		
		this.laneSeqList = laneSeqList;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.trdCd3Seq = trdCd3Seq;
		this.trdCd2Seq = trdCd2Seq;
		this.laneSeq = laneSeq;
		this.trdCd3 = trdCd3;
		this.trdCd2 = trdCd2;
		this.trdCd1Seq = trdCd1Seq;
		this.trdCd1 = trdCd1;
		this.updUsrId = updUsrId;
		this.stsFlg = stsFlg;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("stl_yrmon", getStlYrmon());
		this.hashColumns.put("lane_rmk", getLaneRmk());
		this.hashColumns.put("old_trd_cd1", getOldTrdCd1());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("old_trd_cd3", getOldTrdCd3());
		this.hashColumns.put("old_trd_cd2", getOldTrdCd2());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("erp_slan_cd", getErpSlanCd());
		this.hashColumns.put("bsa_slan_cd", getBsaSlanCd());		
		this.hashColumns.put("lane_seq_list", getLaneSeqList());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trd_cd3_seq", getTrdCd3Seq());
		this.hashColumns.put("trd_cd2_seq", getTrdCd2Seq());
		this.hashColumns.put("lane_seq", getLaneSeq());
		this.hashColumns.put("trd_cd3", getTrdCd3());
		this.hashColumns.put("trd_cd2", getTrdCd2());
		this.hashColumns.put("trd_cd1_seq", getTrdCd1Seq());
		this.hashColumns.put("trd_cd1", getTrdCd1());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sts_flg", getStsFlg());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("stl_yrmon", "stlYrmon");
		this.hashFields.put("lane_rmk", "laneRmk");
		this.hashFields.put("old_trd_cd1", "oldTrdCd1");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("old_trd_cd3", "oldTrdCd3");
		this.hashFields.put("old_trd_cd2", "oldTrdCd2");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("erp_slan_cd", "erpSlanCd");
		this.hashFields.put("bsa_slan_cd", "bsaSlanCd");		
		this.hashFields.put("lane_seq_list", "laneSeqList");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trd_cd3_seq", "trdCd3Seq");
		this.hashFields.put("trd_cd2_seq", "trdCd2Seq");
		this.hashFields.put("lane_seq", "laneSeq");
		this.hashFields.put("trd_cd3", "trdCd3");
		this.hashFields.put("trd_cd2", "trdCd2");
		this.hashFields.put("trd_cd1_seq", "trdCd1Seq");
		this.hashFields.put("trd_cd1", "trdCd1");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sts_flg", "stsFlg");
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
	 * @return stlYrmon
	 */
	public String getStlYrmon() {
		return this.stlYrmon;
	}
	
	/**
	 * Column Info
	 * @return laneRmk
	 */
	public String getLaneRmk() {
		return this.laneRmk;
	}
	
	/**
	 * Column Info
	 * @return oldTrdCd1
	 */
	public String getOldTrdCd1() {
		return this.oldTrdCd1;
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
	 * @return oldTrdCd3
	 */
	public String getOldTrdCd3() {
		return this.oldTrdCd3;
	}
	
	/**
	 * Column Info
	 * @return oldTrdCd2
	 */
	public String getOldTrdCd2() {
		return this.oldTrdCd2;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	/**
	 * Column Info
	 * @return erpSlanCd
	 */
	public String getErpSlanCd() {
		return this.erpSlanCd;
	}
	/**
	 * Column Info
	 * @return bsaSlanCd
	 */
	public String getBsaSlanCd() {
		return this.bsaSlanCd;
	}	
	/**
	 * Column Info
	 * @return laneSeqList
	 */
	public String getLaneSeqList() {
		return this.laneSeqList;
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
	 * @return trdCd3Seq
	 */
	public String getTrdCd3Seq() {
		return this.trdCd3Seq;
	}
	
	/**
	 * Column Info
	 * @return trdCd2Seq
	 */
	public String getTrdCd2Seq() {
		return this.trdCd2Seq;
	}
	
	/**
	 * Column Info
	 * @return laneSeq
	 */
	public String getLaneSeq() {
		return this.laneSeq;
	}
	
	/**
	 * Column Info
	 * @return trdCd3
	 */
	public String getTrdCd3() {
		return this.trdCd3;
	}
	
	/**
	 * Column Info
	 * @return trdCd2
	 */
	public String getTrdCd2() {
		return this.trdCd2;
	}
	
	/**
	 * Column Info
	 * @return trdCd1Seq
	 */
	public String getTrdCd1Seq() {
		return this.trdCd1Seq;
	}
	
	/**
	 * Column Info
	 * @return trdCd1
	 */
	public String getTrdCd1() {
		return this.trdCd1;
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
	 * @return stsFlg
	 */
	public String getStsFlg() {
		return this.stsFlg;
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
	 * @param stlYrmon
	 */
	public void setStlYrmon(String stlYrmon) {
		this.stlYrmon = stlYrmon;
	}
	
	/**
	 * Column Info
	 * @param laneRmk
	 */
	public void setLaneRmk(String laneRmk) {
		this.laneRmk = laneRmk;
	}
	
	/**
	 * Column Info
	 * @param oldTrdCd1
	 */
	public void setOldTrdCd1(String oldTrdCd1) {
		this.oldTrdCd1 = oldTrdCd1;
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
	 * @param oldTrdCd3
	 */
	public void setOldTrdCd3(String oldTrdCd3) {
		this.oldTrdCd3 = oldTrdCd3;
	}
	
	/**
	 * Column Info
	 * @param oldTrdCd2
	 */
	public void setOldTrdCd2(String oldTrdCd2) {
		this.oldTrdCd2 = oldTrdCd2;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}

	/**
	 * Column Info
	 * @param erpSlanCd
	 */
	public void setErpSlanCd(String erpSlanCd) {
		this.erpSlanCd = erpSlanCd;
	}

	/**
	 * Column Info
	 * @param bsaSlanCd
	 */
	public void setBsaSlanCd(String bsaSlanCd) {
		this.bsaSlanCd = bsaSlanCd;
	}
	
	/**
	 * Column Info
	 * @param laneSeqList
	 */
	public void setLaneSeqList(String laneSeqList) {
		this.laneSeqList = laneSeqList;
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
	 * @param trdCd3Seq
	 */
	public void setTrdCd3Seq(String trdCd3Seq) {
		this.trdCd3Seq = trdCd3Seq;
	}
	
	/**
	 * Column Info
	 * @param trdCd2Seq
	 */
	public void setTrdCd2Seq(String trdCd2Seq) {
		this.trdCd2Seq = trdCd2Seq;
	}
	
	/**
	 * Column Info
	 * @param laneSeq
	 */
	public void setLaneSeq(String laneSeq) {
		this.laneSeq = laneSeq;
	}
	
	/**
	 * Column Info
	 * @param trdCd3
	 */
	public void setTrdCd3(String trdCd3) {
		this.trdCd3 = trdCd3;
	}
	
	/**
	 * Column Info
	 * @param trdCd2
	 */
	public void setTrdCd2(String trdCd2) {
		this.trdCd2 = trdCd2;
	}
	
	/**
	 * Column Info
	 * @param trdCd1Seq
	 */
	public void setTrdCd1Seq(String trdCd1Seq) {
		this.trdCd1Seq = trdCd1Seq;
	}
	
	/**
	 * Column Info
	 * @param trdCd1
	 */
	public void setTrdCd1(String trdCd1) {
		this.trdCd1 = trdCd1;
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
	 * @param stsFlg
	 */
	public void setStsFlg(String stsFlg) {
		this.stsFlg = stsFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setStlYrmon(JSPUtil.getParameter(request, "stl_yrmon", ""));
		setLaneRmk(JSPUtil.getParameter(request, "lane_rmk", ""));
		setOldTrdCd1(JSPUtil.getParameter(request, "old_trd_cd1", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setOldTrdCd3(JSPUtil.getParameter(request, "old_trd_cd3", ""));
		setOldTrdCd2(JSPUtil.getParameter(request, "old_trd_cd2", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setErpSlanCd(JSPUtil.getParameter(request, "erp_slan_cd", ""));
		setBsaSlanCd(JSPUtil.getParameter(request, "bsa_slan_cd", ""));		
		setLaneSeqList(JSPUtil.getParameter(request, "lane_seq_list", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTrdCd3Seq(JSPUtil.getParameter(request, "trd_cd3_seq", ""));
		setTrdCd2Seq(JSPUtil.getParameter(request, "trd_cd2_seq", ""));
		setLaneSeq(JSPUtil.getParameter(request, "lane_seq", ""));
		setTrdCd3(JSPUtil.getParameter(request, "trd_cd3", ""));
		setTrdCd2(JSPUtil.getParameter(request, "trd_cd2", ""));
		setTrdCd1Seq(JSPUtil.getParameter(request, "trd_cd1_seq", ""));
		setTrdCd1(JSPUtil.getParameter(request, "trd_cd1", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setStsFlg(JSPUtil.getParameter(request, "sts_flg", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LaneVO[]
	 */
	public LaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LaneVO[]
	 */
	public LaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] stlYrmon = (JSPUtil.getParameter(request, prefix	+ "stl_yrmon".trim(), length));
			String[] laneRmk = (JSPUtil.getParameter(request, prefix	+ "lane_rmk".trim(), length));
			String[] oldTrdCd1 = (JSPUtil.getParameter(request, prefix	+ "old_trd_cd1".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] oldTrdCd3 = (JSPUtil.getParameter(request, prefix	+ "old_trd_cd3".trim(), length));
			String[] oldTrdCd2 = (JSPUtil.getParameter(request, prefix	+ "old_trd_cd2".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd".trim(), length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] erpSlanCd = (JSPUtil.getParameter(request, prefix	+ "erp_slan_cd".trim(), length));
			String[] bsaSlanCd = (JSPUtil.getParameter(request, prefix	+ "bsa_slan_cd".trim(), length));
			String[] laneSeqList = (JSPUtil.getParameter(request, prefix	+ "lane_seq_list".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] trdCd3Seq = (JSPUtil.getParameter(request, prefix	+ "trd_cd3_seq".trim(), length));
			String[] trdCd2Seq = (JSPUtil.getParameter(request, prefix	+ "trd_cd2_seq".trim(), length));
			String[] laneSeq = (JSPUtil.getParameter(request, prefix	+ "lane_seq".trim(), length));
			String[] trdCd3 = (JSPUtil.getParameter(request, prefix	+ "trd_cd3".trim(), length));
			String[] trdCd2 = (JSPUtil.getParameter(request, prefix	+ "trd_cd2".trim(), length));
			String[] trdCd1Seq = (JSPUtil.getParameter(request, prefix	+ "trd_cd1_seq".trim(), length));
			String[] trdCd1 = (JSPUtil.getParameter(request, prefix	+ "trd_cd1".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] stsFlg = (JSPUtil.getParameter(request, prefix	+ "sts_flg".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new LaneVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (stlYrmon[i] != null)
					model.setStlYrmon(stlYrmon[i]);
				if (laneRmk[i] != null)
					model.setLaneRmk(laneRmk[i]);
				if (oldTrdCd1[i] != null)
					model.setOldTrdCd1(oldTrdCd1[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (oldTrdCd3[i] != null)
					model.setOldTrdCd3(oldTrdCd3[i]);
				if (oldTrdCd2[i] != null)
					model.setOldTrdCd2(oldTrdCd2[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (erpSlanCd[i] != null)
					model.setErpSlanCd(erpSlanCd[i]);
				if (bsaSlanCd[i] != null)
					model.setBsaSlanCd(bsaSlanCd[i]);
				if (laneSeqList[i] != null)
					model.setLaneSeqList(laneSeqList[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trdCd3Seq[i] != null)
					model.setTrdCd3Seq(trdCd3Seq[i]);
				if (trdCd2Seq[i] != null)
					model.setTrdCd2Seq(trdCd2Seq[i]);
				if (laneSeq[i] != null)
					model.setLaneSeq(laneSeq[i]);
				if (trdCd3[i] != null)
					model.setTrdCd3(trdCd3[i]);
				if (trdCd2[i] != null)
					model.setTrdCd2(trdCd2[i]);
				if (trdCd1Seq[i] != null)
					model.setTrdCd1Seq(trdCd1Seq[i]);
				if (trdCd1[i] != null)
					model.setTrdCd1(trdCd1[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stsFlg[i] != null)
					model.setStsFlg(stsFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LaneVO[]
	 */
	public LaneVO[] getLaneVOs(){
		LaneVO[] vos = (LaneVO[])models.toArray(new LaneVO[models.size()]);
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
		this.stlYrmon = this.stlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneRmk = this.laneRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldTrdCd1 = this.oldTrdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldTrdCd3 = this.oldTrdCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldTrdCd2 = this.oldTrdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpSlanCd = this.erpSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSlanCd = this.bsaSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneSeqList = this.laneSeqList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd3Seq = this.trdCd3Seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd2Seq = this.trdCd2Seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneSeq = this.laneSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd3 = this.trdCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd2 = this.trdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd1Seq = this.trdCd1Seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd1 = this.trdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsFlg = this.stsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
