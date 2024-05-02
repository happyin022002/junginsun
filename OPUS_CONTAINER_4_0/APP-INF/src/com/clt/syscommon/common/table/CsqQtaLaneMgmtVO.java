/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CsqQtaLaneMgmtVO.java
*@FileTitle : CsqQtaLaneMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.10  
* 1.0 Creation
=========================================================*/

package com.clt.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CsqQtaLaneMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CsqQtaLaneMgmtVO> models = new ArrayList<CsqQtaLaneMgmtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String csqActFlg = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String iasSctrFlg = null;
	/* Column Info */
	private String laneDirCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String bseTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CsqQtaLaneMgmtVO() {}

	public CsqQtaLaneMgmtVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String subTrdCd, String laneDirCd, String csqActFlg, String creUsrId, String creDt, String updUsrId, String updDt, String iasSctrFlg, String bseYr, String bseQtrCd, String bseTpCd) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.csqActFlg = csqActFlg;
		this.rlaneCd = rlaneCd;
		this.iasSctrFlg = iasSctrFlg;
		this.laneDirCd = laneDirCd;
		this.updUsrId = updUsrId;
		this.subTrdCd = subTrdCd;
		this.pagerows = pagerows;
		this.bseYr = bseYr;
		this.bseQtrCd = bseQtrCd;
		this.bseTpCd = bseTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("csq_act_flg", getCsqActFlg());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ias_sctr_flg", getIasSctrFlg());
		this.hashColumns.put("lane_dir_cd", getLaneDirCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("csq_act_flg", "csqActFlg");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ias_sctr_flg", "iasSctrFlg");
		this.hashFields.put("lane_dir_cd", "laneDirCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
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
	 * @return csqActFlg
	 */
	public String getCsqActFlg() {
		return this.csqActFlg;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return iasSctrFlg
	 */
	public String getIasSctrFlg() {
		return this.iasSctrFlg;
	}
	
	/**
	 * Column Info
	 * @return laneDirCd
	 */
	public String getLaneDirCd() {
		return this.laneDirCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
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
	 * @param csqActFlg
	 */
	public void setCsqActFlg(String csqActFlg) {
		this.csqActFlg = csqActFlg;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param iasSctrFlg
	 */
	public void setIasSctrFlg(String iasSctrFlg) {
		this.iasSctrFlg = iasSctrFlg;
	}
	
	/**
	 * Column Info
	 * @param laneDirCd
	 */
	public void setLaneDirCd(String laneDirCd) {
		this.laneDirCd = laneDirCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param fBseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setCsqActFlg(JSPUtil.getParameter(request, prefix + "csq_act_flg", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIasSctrFlg(JSPUtil.getParameter(request, prefix + "ias_sctr_flg", ""));
		setLaneDirCd(JSPUtil.getParameter(request, prefix + "lane_dir_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CsqQtaLaneMgmtVO[]
	 */
	public CsqQtaLaneMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CsqQtaLaneMgmtVO[]
	 */
	public CsqQtaLaneMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CsqQtaLaneMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] csqActFlg = (JSPUtil.getParameter(request, prefix	+ "csq_act_flg", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] iasSctrFlg = (JSPUtil.getParameter(request, prefix	+ "ias_sctr_flg", length));
			String[] laneDirCd = (JSPUtil.getParameter(request, prefix	+ "lane_dir_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CsqQtaLaneMgmtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (csqActFlg[i] != null)
					model.setCsqActFlg(csqActFlg[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (iasSctrFlg[i] != null)
					model.setIasSctrFlg(iasSctrFlg[i]);
				if (laneDirCd[i] != null)
					model.setLaneDirCd(laneDirCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCsqQtaLaneMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CsqQtaLaneMgmtVO[]
	 */
	public CsqQtaLaneMgmtVO[] getCsqQtaLaneMgmtVOs(){
		CsqQtaLaneMgmtVO[] vos = (CsqQtaLaneMgmtVO[])models.toArray(new CsqQtaLaneMgmtVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csqActFlg = this.csqActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasSctrFlg = this.iasSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneDirCd = this.laneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
