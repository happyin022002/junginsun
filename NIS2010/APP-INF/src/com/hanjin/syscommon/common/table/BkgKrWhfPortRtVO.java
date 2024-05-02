/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgKrWhfPortRtVO.java
*@FileTitle : BkgKrWhfPortRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.08  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgKrWhfPortRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgKrWhfPortRtVO> models = new ArrayList<BkgKrWhfPortRtVO>();
	
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
	private String feuAmtRt = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String teuPrc = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dcRtoNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgKrWhfPortRtVO() {}

	public BkgKrWhfPortRtVO(String ibflag, String pagerows, String cntrBlkDivCd, String portCd, String ioBndCd, String dcRtoNo, String teuPrc, String feuPrc, String hcPrc, String teuAmtRt, String feuAmtRt, String hcAmtRt, String portSeq, String effFmDt, String effToDt, String updDt, String creDt, String creUsrId, String updUsrId) {
		this.updDt = updDt;
		this.teuAmtRt = teuAmtRt;
		this.hcAmtRt = hcAmtRt;
		this.creDt = creDt;
		this.feuPrc = feuPrc;
		this.ioBndCd = ioBndCd;
		this.cntrBlkDivCd = cntrBlkDivCd;
		this.pagerows = pagerows;
		this.hcPrc = hcPrc;
		this.feuAmtRt = feuAmtRt;
		this.portSeq = portSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effFmDt = effFmDt;
		this.teuPrc = teuPrc;
		this.portCd = portCd;
		this.effToDt = effToDt;
		this.updUsrId = updUsrId;
		this.dcRtoNo = dcRtoNo; 
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("teu_amt_rt", getTeuAmtRt());
		this.hashColumns.put("hc_amt_rt", getHcAmtRt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("feu_prc", getFeuPrc());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cntr_blk_div_cd", getCntrBlkDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hc_prc", getHcPrc());
		this.hashColumns.put("feu_amt_rt", getFeuAmtRt());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("teu_prc", getTeuPrc());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dc_rto_no", getDcRtoNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("teu_amt_rt", "teuAmtRt");
		this.hashFields.put("hc_amt_rt", "hcAmtRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("feu_prc", "feuPrc");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cntr_blk_div_cd", "cntrBlkDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hc_prc", "hcPrc");
		this.hashFields.put("feu_amt_rt", "feuAmtRt");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("teu_prc", "teuPrc");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dc_rto_no", "dcRtoNo");
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
		setTeuAmtRt(JSPUtil.getParameter(request, prefix + "teu_amt_rt", ""));
		setHcAmtRt(JSPUtil.getParameter(request, prefix + "hc_amt_rt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFeuPrc(JSPUtil.getParameter(request, prefix + "feu_prc", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCntrBlkDivCd(JSPUtil.getParameter(request, prefix + "cntr_blk_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHcPrc(JSPUtil.getParameter(request, prefix + "hc_prc", ""));
		setFeuAmtRt(JSPUtil.getParameter(request, prefix + "feu_amt_rt", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setTeuPrc(JSPUtil.getParameter(request, prefix + "teu_prc", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDcRtoNo(JSPUtil.getParameter(request, prefix + "dc_rto_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgKrWhfPortRtVO[]
	 */
	public BkgKrWhfPortRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgKrWhfPortRtVO[]
	 */
	public BkgKrWhfPortRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgKrWhfPortRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] teuAmtRt = (JSPUtil.getParameter(request, prefix	+ "teu_amt_rt", length));
			String[] hcAmtRt = (JSPUtil.getParameter(request, prefix	+ "hc_amt_rt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] feuPrc = (JSPUtil.getParameter(request, prefix	+ "feu_prc", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cntrBlkDivCd = (JSPUtil.getParameter(request, prefix	+ "cntr_blk_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hcPrc = (JSPUtil.getParameter(request, prefix	+ "hc_prc", length));
			String[] feuAmtRt = (JSPUtil.getParameter(request, prefix	+ "feu_amt_rt", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] teuPrc = (JSPUtil.getParameter(request, prefix	+ "teu_prc", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dcRtoNo = (JSPUtil.getParameter(request, prefix	+ "dc_rto_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgKrWhfPortRtVO();
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
				if (feuAmtRt[i] != null)
					model.setFeuAmtRt(feuAmtRt[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (teuPrc[i] != null)
					model.setTeuPrc(teuPrc[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dcRtoNo[i] != null)
					model.setDcRtoNo(dcRtoNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgKrWhfPortRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgKrWhfPortRtVO[]
	 */
	public BkgKrWhfPortRtVO[] getBkgKrWhfPortRtVOs(){
		BkgKrWhfPortRtVO[] vos = (BkgKrWhfPortRtVO[])models.toArray(new BkgKrWhfPortRtVO[models.size()]);
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
		this.teuAmtRt = this.teuAmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcAmtRt = this.hcAmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuPrc = this.feuPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBlkDivCd = this.cntrBlkDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcPrc = this.hcPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuAmtRt = this.feuAmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuPrc = this.teuPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcRtoNo = this.dcRtoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
