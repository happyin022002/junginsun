/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HandlerHistoryVO.java
*@FileTitle : HandlerHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.20 정행룡 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo;

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
	private String creDt = null;
	/* Column Info */
	private String dwClmStsNm = null;
	/* Column Info */
	private String mgrHdlrDivCd = null;
	/* Column Info */
	private String dwClmHisSeq = null;
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
	private String effDt = null;
	/* Column Info */
	private String dwClmStsCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String dwClmNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HandlerHistoryVO() {}

	public HandlerHistoryVO(String ibflag, String pagerows, String dwClmNo, String dwClmHisSeq, String hdlrUsrId, String hdlrOfcCd, String dwClmStsCd, String dwClmStsNm, String effDt, String tmpBar, String expDt, String mgrHdlrDivCd, String crntHdlrFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.crntHdlrFlg = crntHdlrFlg;
		this.creDt = creDt;
		this.dwClmStsNm = dwClmStsNm;
		this.mgrHdlrDivCd = mgrHdlrDivCd;
		this.dwClmHisSeq = dwClmHisSeq;
		this.pagerows = pagerows;
		this.hdlrUsrId = hdlrUsrId;
		this.tmpBar = tmpBar;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.dwClmStsCd = dwClmStsCd;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.hdlrOfcCd = hdlrOfcCd;
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("crnt_hdlr_flg", getCrntHdlrFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dw_clm_sts_nm", getDwClmStsNm());
		this.hashColumns.put("mgr_hdlr_div_cd", getMgrHdlrDivCd());
		this.hashColumns.put("dw_clm_his_seq", getDwClmHisSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("tmp_bar", getTmpBar());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("dw_clm_sts_cd", getDwClmStsCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("crnt_hdlr_flg", "crntHdlrFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dw_clm_sts_nm", "dwClmStsNm");
		this.hashFields.put("mgr_hdlr_div_cd", "mgrHdlrDivCd");
		this.hashFields.put("dw_clm_his_seq", "dwClmHisSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("tmp_bar", "tmpBar");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("dw_clm_sts_cd", "dwClmStsCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("dw_clm_no", "dwClmNo");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return dwClmStsNm
	 */
	public String getDwClmStsNm() {
		return this.dwClmStsNm;
	}
	
	/**
	 * Column Info
	 * @return mgrHdlrDivCd
	 */
	public String getMgrHdlrDivCd() {
		return this.mgrHdlrDivCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmHisSeq
	 */
	public String getDwClmHisSeq() {
		return this.dwClmHisSeq;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return dwClmStsCd
	 */
	public String getDwClmStsCd() {
		return this.dwClmStsCd;
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
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param dwClmStsNm
	 */
	public void setDwClmStsNm(String dwClmStsNm) {
		this.dwClmStsNm = dwClmStsNm;
	}
	
	/**
	 * Column Info
	 * @param mgrHdlrDivCd
	 */
	public void setMgrHdlrDivCd(String mgrHdlrDivCd) {
		this.mgrHdlrDivCd = mgrHdlrDivCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmHisSeq
	 */
	public void setDwClmHisSeq(String dwClmHisSeq) {
		this.dwClmHisSeq = dwClmHisSeq;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param dwClmStsCd
	 */
	public void setDwClmStsCd(String dwClmStsCd) {
		this.dwClmStsCd = dwClmStsCd;
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
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
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
		setCrntHdlrFlg(JSPUtil.getParameter(request, prefix + "crnt_hdlr_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDwClmStsNm(JSPUtil.getParameter(request, prefix + "dw_clm_sts_nm", ""));
		setMgrHdlrDivCd(JSPUtil.getParameter(request, prefix + "mgr_hdlr_div_cd", ""));
		setDwClmHisSeq(JSPUtil.getParameter(request, prefix + "dw_clm_his_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setTmpBar(JSPUtil.getParameter(request, prefix + "tmp_bar", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setDwClmStsCd(JSPUtil.getParameter(request, prefix + "dw_clm_sts_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setDwClmNo(JSPUtil.getParameter(request, prefix + "dw_clm_no", ""));
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
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dwClmStsNm = (JSPUtil.getParameter(request, prefix	+ "dw_clm_sts_nm", length));
			String[] mgrHdlrDivCd = (JSPUtil.getParameter(request, prefix	+ "mgr_hdlr_div_cd", length));
			String[] dwClmHisSeq = (JSPUtil.getParameter(request, prefix	+ "dw_clm_his_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] tmpBar = (JSPUtil.getParameter(request, prefix	+ "tmp_bar", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] dwClmStsCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_sts_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new HandlerHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (crntHdlrFlg[i] != null)
					model.setCrntHdlrFlg(crntHdlrFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dwClmStsNm[i] != null)
					model.setDwClmStsNm(dwClmStsNm[i]);
				if (mgrHdlrDivCd[i] != null)
					model.setMgrHdlrDivCd(mgrHdlrDivCd[i]);
				if (dwClmHisSeq[i] != null)
					model.setDwClmHisSeq(dwClmHisSeq[i]);
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
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (dwClmStsCd[i] != null)
					model.setDwClmStsCd(dwClmStsCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmStsNm = this.dwClmStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgrHdlrDivCd = this.mgrHdlrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmHisSeq = this.dwClmHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpBar = this.tmpBar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmStsCd = this.dwClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
