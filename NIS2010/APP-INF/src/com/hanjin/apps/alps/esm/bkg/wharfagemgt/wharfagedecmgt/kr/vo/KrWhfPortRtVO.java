/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KrWhfPortRtVO.java
*@FileTitle : KrWhfPortRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
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

public class KrWhfPortRtVO extends WhfPortRtVO { 

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfPortRtVO> models = new ArrayList<KrWhfPortRtVO>();
	
	/* Column Info */
	private String cntr40UtRt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String teuAmtRt = null;
	/* Column Info */
	private String hcAmtRt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String feuPrc = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cntrBlkDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hcPrc = null;
	/* Column Info */
	private String blkRtRto = null;
	/* Column Info */
	private String feuAmtRt = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntr45UtRt = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String teuPrc = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String blkUtRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dcRtoNo = null;
	/* Column Info */
	private String cntr20UtRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfPortRtVO() {}

	public KrWhfPortRtVO(String ibflag, String pagerows, String cntr40UtRt, String updDt, String teuAmtRt, String hcAmtRt, String creDt, String feuPrc, String ioBndCd, String cntrBlkDivCd, String hcPrc, String blkRtRto, String feuAmtRt, String creUsrId, String cntr45UtRt, String teuPrc, String portCd, String blkUtRt, String cntr20UtRt, String dcRtoNo, String updUsrId, String portSeq, String effFmDt, String effToDt) {
		this.cntr40UtRt = cntr40UtRt;
		this.updDt = updDt;
		this.teuAmtRt = teuAmtRt;
		this.hcAmtRt = hcAmtRt;
		this.creDt = creDt;
		this.feuPrc = feuPrc;
		this.ioBndCd = ioBndCd;
		this.cntrBlkDivCd = cntrBlkDivCd;
		this.pagerows = pagerows;
		this.hcPrc = hcPrc;
		this.blkRtRto = blkRtRto;
		this.feuAmtRt = feuAmtRt;
		this.portSeq = portSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cntr45UtRt = cntr45UtRt;
		this.effFmDt = effFmDt;
		this.teuPrc = teuPrc;
		this.portCd = portCd;
		this.effToDt = effToDt;
		this.blkUtRt = blkUtRt;
		this.updUsrId = updUsrId;
		this.dcRtoNo = dcRtoNo;
		this.cntr20UtRt = cntr20UtRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_40_ut_rt", getCntr40UtRt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("teu_amt_rt", getTeuAmtRt());
		this.hashColumns.put("hc_amt_rt", getHcAmtRt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("feu_prc", getFeuPrc());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cntr_blk_div_cd", getCntrBlkDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hc_prc", getHcPrc());
		this.hashColumns.put("blk_rt_rto", getBlkRtRto());
		this.hashColumns.put("feu_amt_rt", getFeuAmtRt());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_45_ut_rt", getCntr45UtRt());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("teu_prc", getTeuPrc());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("blk_ut_rt", getBlkUtRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dc_rto_no", getDcRtoNo());
		this.hashColumns.put("cntr_20_ut_rt", getCntr20UtRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_40_ut_rt", "cntr40UtRt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("teu_amt_rt", "teuAmtRt");
		this.hashFields.put("hc_amt_rt", "hcAmtRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("feu_prc", "feuPrc");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cntr_blk_div_cd", "cntrBlkDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hc_prc", "hcPrc");
		this.hashFields.put("blk_rt_rto", "blkRtRto");
		this.hashFields.put("feu_amt_rt", "feuAmtRt");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_45_ut_rt", "cntr45UtRt");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("teu_prc", "teuPrc");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("blk_ut_rt", "blkUtRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dc_rto_no", "dcRtoNo");
		this.hashFields.put("cntr_20_ut_rt", "cntr20UtRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntr40UtRt
	 */
	public String getCntr40UtRt() {
		return this.cntr40UtRt;
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
	 * @return teuAmtRt
	 */
	public String getTeuAmtRt() {
		return this.teuAmtRt;
	}
	
	/**
	 * Column Info
	 * @return hcAmtRt
	 */
	public String getHcAmtRt() {
		return this.hcAmtRt;
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
	 * @return feuPrc
	 */
	public String getFeuPrc() {
		return this.feuPrc;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return cntrBlkDivCd
	 */
	public String getCntrBlkDivCd() {
		return this.cntrBlkDivCd;
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
	 * @return hcPrc
	 */
	public String getHcPrc() {
		return this.hcPrc;
	}
	
	/**
	 * Column Info
	 * @return blkRtRto
	 */
	public String getBlkRtRto() {
		return this.blkRtRto;
	}
	
	/**
	 * Column Info
	 * @return feuAmtRt
	 */
	public String getFeuAmtRt() {
		return this.feuAmtRt;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
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
	 * @return cntr45UtRt
	 */
	public String getCntr45UtRt() {
		return this.cntr45UtRt;
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
	 * @return teuPrc
	 */
	public String getTeuPrc() {
		return this.teuPrc;
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
	 * @return blkUtRt
	 */
	public String getBlkUtRt() {
		return this.blkUtRt;
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
	 * @return dcRtoNo
	 */
	public String getDcRtoNo() {
		return this.dcRtoNo;
	}
	
	/**
	 * Column Info
	 * @return cntr20UtRt
	 */
	public String getCntr20UtRt() {
		return this.cntr20UtRt;
	}
	

	/**
	 * Column Info
	 * @param cntr40UtRt
	 */
	public void setCntr40UtRt(String cntr40UtRt) {
		this.cntr40UtRt = cntr40UtRt;
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
	 * @param teuAmtRt
	 */
	public void setTeuAmtRt(String teuAmtRt) {
		this.teuAmtRt = teuAmtRt;
	}
	
	/**
	 * Column Info
	 * @param hcAmtRt
	 */
	public void setHcAmtRt(String hcAmtRt) {
		this.hcAmtRt = hcAmtRt;
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
	 * @param feuPrc
	 */
	public void setFeuPrc(String feuPrc) {
		this.feuPrc = feuPrc;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param cntrBlkDivCd
	 */
	public void setCntrBlkDivCd(String cntrBlkDivCd) {
		this.cntrBlkDivCd = cntrBlkDivCd;
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
	 * @param hcPrc
	 */
	public void setHcPrc(String hcPrc) {
		this.hcPrc = hcPrc;
	}
	
	/**
	 * Column Info
	 * @param blkRtRto
	 */
	public void setBlkRtRto(String blkRtRto) {
		this.blkRtRto = blkRtRto;
	}
	
	/**
	 * Column Info
	 * @param feuAmtRt
	 */
	public void setFeuAmtRt(String feuAmtRt) {
		this.feuAmtRt = feuAmtRt;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
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
	 * @param cntr45UtRt
	 */
	public void setCntr45UtRt(String cntr45UtRt) {
		this.cntr45UtRt = cntr45UtRt;
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
	 * @param teuPrc
	 */
	public void setTeuPrc(String teuPrc) {
		this.teuPrc = teuPrc;
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
	 * @param blkUtRt
	 */
	public void setBlkUtRt(String blkUtRt) {
		this.blkUtRt = blkUtRt;
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
	 * @param dcRtoNo
	 */
	public void setDcRtoNo(String dcRtoNo) {
		this.dcRtoNo = dcRtoNo;
	}
	
	/**
	 * Column Info
	 * @param cntr20UtRt
	 */
	public void setCntr20UtRt(String cntr20UtRt) {
		this.cntr20UtRt = cntr20UtRt;
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
		setCntr40UtRt(JSPUtil.getParameter(request, prefix + "cntr_40_ut_rt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTeuAmtRt(JSPUtil.getParameter(request, prefix + "teu_amt_rt", ""));
		setHcAmtRt(JSPUtil.getParameter(request, prefix + "hc_amt_rt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFeuPrc(JSPUtil.getParameter(request, prefix + "feu_prc", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCntrBlkDivCd(JSPUtil.getParameter(request, prefix + "cntr_blk_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHcPrc(JSPUtil.getParameter(request, prefix + "hc_prc", ""));
		setBlkRtRto(JSPUtil.getParameter(request, prefix + "blk_rt_rto", ""));
		setFeuAmtRt(JSPUtil.getParameter(request, prefix + "feu_amt_rt", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntr45UtRt(JSPUtil.getParameter(request, prefix + "cntr_45_ut_rt", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setTeuPrc(JSPUtil.getParameter(request, prefix + "teu_prc", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setBlkUtRt(JSPUtil.getParameter(request, prefix + "blk_ut_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDcRtoNo(JSPUtil.getParameter(request, prefix + "dc_rto_no", ""));
		setCntr20UtRt(JSPUtil.getParameter(request, prefix + "cntr_20_ut_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfPortRtVO[]
	 */
	public KrWhfPortRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfPortRtVO[]
	 */
	public KrWhfPortRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfPortRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntr40UtRt = (JSPUtil.getParameter(request, prefix	+ "cntr_40_ut_rt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] teuAmtRt = (JSPUtil.getParameter(request, prefix	+ "teu_amt_rt", length));
			String[] hcAmtRt = (JSPUtil.getParameter(request, prefix	+ "hc_amt_rt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] feuPrc = (JSPUtil.getParameter(request, prefix	+ "feu_prc", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cntrBlkDivCd = (JSPUtil.getParameter(request, prefix	+ "cntr_blk_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hcPrc = (JSPUtil.getParameter(request, prefix	+ "hc_prc", length));
			String[] blkRtRto = (JSPUtil.getParameter(request, prefix	+ "blk_rt_rto", length));
			String[] feuAmtRt = (JSPUtil.getParameter(request, prefix	+ "feu_amt_rt", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntr45UtRt = (JSPUtil.getParameter(request, prefix	+ "cntr_45_ut_rt", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] teuPrc = (JSPUtil.getParameter(request, prefix	+ "teu_prc", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] blkUtRt = (JSPUtil.getParameter(request, prefix	+ "blk_ut_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dcRtoNo = (JSPUtil.getParameter(request, prefix	+ "dc_rto_no", length));
			String[] cntr20UtRt = (JSPUtil.getParameter(request, prefix	+ "cntr_20_ut_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfPortRtVO();
				if (cntr40UtRt[i] != null)
					model.setCntr40UtRt(cntr40UtRt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (teuAmtRt[i] != null)
					model.setTeuAmtRt(teuAmtRt[i]);
				if (hcAmtRt[i] != null)
					model.setHcAmtRt(hcAmtRt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (feuPrc[i] != null)
					model.setFeuPrc(feuPrc[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cntrBlkDivCd[i] != null)
					model.setCntrBlkDivCd(cntrBlkDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hcPrc[i] != null)
					model.setHcPrc(hcPrc[i]);
				if (blkRtRto[i] != null)
					model.setBlkRtRto(blkRtRto[i]);
				if (feuAmtRt[i] != null)
					model.setFeuAmtRt(feuAmtRt[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntr45UtRt[i] != null)
					model.setCntr45UtRt(cntr45UtRt[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (teuPrc[i] != null)
					model.setTeuPrc(teuPrc[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (blkUtRt[i] != null)
					model.setBlkUtRt(blkUtRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dcRtoNo[i] != null)
					model.setDcRtoNo(dcRtoNo[i]);
				if (cntr20UtRt[i] != null)
					model.setCntr20UtRt(cntr20UtRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfPortRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfPortRtVO[]
	 */
	public KrWhfPortRtVO[] getKrWhfPortRtVOs(){
		KrWhfPortRtVO[] vos = (KrWhfPortRtVO[])models.toArray(new KrWhfPortRtVO[models.size()]);
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
		this.cntr40UtRt = this.cntr40UtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuAmtRt = this.teuAmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcAmtRt = this.hcAmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuPrc = this.feuPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBlkDivCd = this.cntrBlkDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcPrc = this.hcPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkRtRto = this.blkRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuAmtRt = this.feuAmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45UtRt = this.cntr45UtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuPrc = this.teuPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkUtRt = this.blkUtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRtoNo = this.dcRtoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20UtRt = this.cntr20UtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
