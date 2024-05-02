/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HandlerHistoryVO.java
*@FileTitle : HandlerHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.08 정행룡 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo;

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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HandlerHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HandlerHistoryVO> models = new ArrayList<HandlerHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String crntHdlrFlg = null;
	/* Column Info */
	private String cgoClmStsNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cgoClmHisTpCd = null;
	/* Column Info */
	private String mgrHdlrDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String tmpBar = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoClmHdlrHisSeq = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hdlrOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HandlerHistoryVO() {}

	public HandlerHistoryVO(String ibflag, String pagerows, String cgoClmNo, String cgoClmHdlrHisSeq, String cgoClmHisTpCd, String hdlrUsrId, String hdlrOfcCd, String cgoClmStsCd, String cgoClmStsNm, String effDt, String tmpBar, String expDt, String mgrHdlrDivCd, String crntHdlrFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.crntHdlrFlg = crntHdlrFlg;
		this.cgoClmStsNm = cgoClmStsNm;
		this.creDt = creDt;
		this.cgoClmHisTpCd = cgoClmHisTpCd;
		this.mgrHdlrDivCd = mgrHdlrDivCd;
		this.pagerows = pagerows;
		this.hdlrUsrId = hdlrUsrId;
		this.tmpBar = tmpBar;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cgoClmHdlrHisSeq = cgoClmHdlrHisSeq;
		this.effDt = effDt;
		this.cgoClmStsCd = cgoClmStsCd;
		this.cgoClmNo = cgoClmNo;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("crnt_hdlr_flg", getCrntHdlrFlg());
		this.hashColumns.put("cgo_clm_sts_nm", getCgoClmStsNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cgo_clm_his_tp_cd", getCgoClmHisTpCd());
		this.hashColumns.put("mgr_hdlr_div_cd", getMgrHdlrDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("tmp_bar", getTmpBar());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_clm_hdlr_his_seq", getCgoClmHdlrHisSeq());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("crnt_hdlr_flg", "crntHdlrFlg");
		this.hashFields.put("cgo_clm_sts_nm", "cgoClmStsNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cgo_clm_his_tp_cd", "cgoClmHisTpCd");
		this.hashFields.put("mgr_hdlr_div_cd", "mgrHdlrDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("tmp_bar", "tmpBar");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_clm_hdlr_his_seq", "cgoClmHdlrHisSeq");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
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
	 * @return crntHdlrFlg
	 */
	public String getCrntHdlrFlg() {
		return this.crntHdlrFlg;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStsNm
	 */
	public String getCgoClmStsNm() {
		return this.cgoClmStsNm;
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
	 * @return cgoClmHisTpCd
	 */
	public String getCgoClmHisTpCd() {
		return this.cgoClmHisTpCd;
	}
	
	/**
	 * Column Info
	 * @return mgrHdlrDivCd
	 */
	public String getMgrHdlrDivCd() {
		return this.mgrHdlrDivCd;
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
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @return tmpBar
	 */
	public String getTmpBar() {
		return this.tmpBar;
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
	 * @return cgoClmHdlrHisSeq
	 */
	public String getCgoClmHdlrHisSeq() {
		return this.cgoClmHdlrHisSeq;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStsCd
	 */
	public String getCgoClmStsCd() {
		return this.cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
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
	 * @param crntHdlrFlg
	 */
	public void setCrntHdlrFlg(String crntHdlrFlg) {
		this.crntHdlrFlg = crntHdlrFlg;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStsNm
	 */
	public void setCgoClmStsNm(String cgoClmStsNm) {
		this.cgoClmStsNm = cgoClmStsNm;
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
	 * @param cgoClmHisTpCd
	 */
	public void setCgoClmHisTpCd(String cgoClmHisTpCd) {
		this.cgoClmHisTpCd = cgoClmHisTpCd;
	}
	
	/**
	 * Column Info
	 * @param mgrHdlrDivCd
	 */
	public void setMgrHdlrDivCd(String mgrHdlrDivCd) {
		this.mgrHdlrDivCd = mgrHdlrDivCd;
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
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @param tmpBar
	 */
	public void setTmpBar(String tmpBar) {
		this.tmpBar = tmpBar;
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
	 * @param cgoClmHdlrHisSeq
	 */
	public void setCgoClmHdlrHisSeq(String cgoClmHdlrHisSeq) {
		this.cgoClmHdlrHisSeq = cgoClmHdlrHisSeq;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStsCd
	 */
	public void setCgoClmStsCd(String cgoClmStsCd) {
		this.cgoClmStsCd = cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCrntHdlrFlg(JSPUtil.getParameter(request, "crnt_hdlr_flg", ""));
		setCgoClmStsNm(JSPUtil.getParameter(request, "cgo_clm_sts_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCgoClmHisTpCd(JSPUtil.getParameter(request, "cgo_clm_his_tp_cd", ""));
		setMgrHdlrDivCd(JSPUtil.getParameter(request, "mgr_hdlr_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, "hdlr_usr_id", ""));
		setTmpBar(JSPUtil.getParameter(request, "tmp_bar", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoClmHdlrHisSeq(JSPUtil.getParameter(request, "cgo_clm_hdlr_his_seq", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, "cgo_clm_sts_cd", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, "hdlr_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HandlerHistoryVO[]
	 */
	public HandlerHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HandlerHistoryVO[]
	 */
	public HandlerHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HandlerHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] crntHdlrFlg = (JSPUtil.getParameter(request, prefix	+ "crnt_hdlr_flg", length));
			String[] cgoClmStsNm = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cgoClmHisTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_his_tp_cd", length));
			String[] mgrHdlrDivCd = (JSPUtil.getParameter(request, prefix	+ "mgr_hdlr_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] tmpBar = (JSPUtil.getParameter(request, prefix	+ "tmp_bar", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoClmHdlrHisSeq = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_hdlr_his_seq", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new HandlerHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (crntHdlrFlg[i] != null)
					model.setCrntHdlrFlg(crntHdlrFlg[i]);
				if (cgoClmStsNm[i] != null)
					model.setCgoClmStsNm(cgoClmStsNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cgoClmHisTpCd[i] != null)
					model.setCgoClmHisTpCd(cgoClmHisTpCd[i]);
				if (mgrHdlrDivCd[i] != null)
					model.setMgrHdlrDivCd(mgrHdlrDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (tmpBar[i] != null)
					model.setTmpBar(tmpBar[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoClmHdlrHisSeq[i] != null)
					model.setCgoClmHdlrHisSeq(cgoClmHdlrHisSeq[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHandlerHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HandlerHistoryVO[]
	 */
	public HandlerHistoryVO[] getHandlerHistoryVOs(){
		HandlerHistoryVO[] vos = (HandlerHistoryVO[])models.toArray(new HandlerHistoryVO[models.size()]);
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
		this.crntHdlrFlg = this.crntHdlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsNm = this.cgoClmStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmHisTpCd = this.cgoClmHisTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgrHdlrDivCd = this.mgrHdlrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpBar = this.tmpBar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmHdlrHisSeq = this.cgoClmHdlrHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
