/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolCoChssUseHisMGTVO.java
*@FileTitle : PoolCoChssUseHisMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.02.17 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolCoChssUseHisMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolCoChssUseHisMGTVO> models = new ArrayList<PoolCoChssUseHisMGTVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntrOwnrCoCd = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String yyyyMm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String onhLocNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String saveChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrOwnrCoNm = null;
	/* Column Info */
	private String chssOwnrCoCd = null;
	/* Column Info */
	private String poolChssUsdDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String offhLocNm = null;
	/* Column Info */
	private String offhDt = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolCoChssUseHisMGTVO() {}

	public PoolCoChssUseHisMGTVO(String ibflag, String pagerows, String updDt, String cntrOwnrCoCd, String chssPoolCd, String chssNo, String creDt, String onhDt, String onhLocNm, String saveChk, String creUsrId, String cntrOwnrCoNm, String chssOwnrCoCd, String poolChssUsdDys, String cntrNo, String offhLocNm, String fileSeq, String offhDt, String updUsrId, String yyyyMm) {
		this.updDt = updDt;
		this.cntrOwnrCoCd = cntrOwnrCoCd;
		this.chssPoolCd = chssPoolCd;
		this.chssNo = chssNo;
		this.yyyyMm = yyyyMm;
		this.creDt = creDt;
		this.onhDt = onhDt;
		this.onhLocNm = onhLocNm;
		this.pagerows = pagerows;
		this.saveChk = saveChk;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrOwnrCoNm = cntrOwnrCoNm;
		this.chssOwnrCoCd = chssOwnrCoCd;
		this.poolChssUsdDys = poolChssUsdDys;
		this.cntrNo = cntrNo;
		this.offhLocNm = offhLocNm;
		this.offhDt = offhDt;
		this.fileSeq = fileSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntr_ownr_co_cd", getCntrOwnrCoCd());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("yyyy_mm", getYyyyMm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("onh_loc_nm", getOnhLocNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("save_chk", getSaveChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_ownr_co_nm", getCntrOwnrCoNm());
		this.hashColumns.put("chss_ownr_co_cd", getChssOwnrCoCd());
		this.hashColumns.put("pool_chss_usd_dys", getPoolChssUsdDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("offh_loc_nm", getOffhLocNm());
		this.hashColumns.put("offh_dt", getOffhDt());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_ownr_co_cd", "cntrOwnrCoCd");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("yyyy_mm", "yyyyMm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("onh_loc_nm", "onhLocNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("save_chk", "saveChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_ownr_co_nm", "cntrOwnrCoNm");
		this.hashFields.put("chss_ownr_co_cd", "chssOwnrCoCd");
		this.hashFields.put("pool_chss_usd_dys", "poolChssUsdDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("offh_loc_nm", "offhLocNm");
		this.hashFields.put("offh_dt", "offhDt");
		this.hashFields.put("file_seq", "fileSeq");
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
	 * @return cntrOwnrCoCd
	 */
	public String getCntrOwnrCoCd() {
		return this.cntrOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return yyyyMm
	 */
	public String getYyyyMm() {
		return this.yyyyMm;
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
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return onhLocNm
	 */
	public String getOnhLocNm() {
		return this.onhLocNm;
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
	 * @return saveChk
	 */
	public String getSaveChk() {
		return this.saveChk;
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
	 * @return cntrOwnrCoNm
	 */
	public String getCntrOwnrCoNm() {
		return this.cntrOwnrCoNm;
	}
	
	/**
	 * Column Info
	 * @return chssOwnrCoCd
	 */
	public String getChssOwnrCoCd() {
		return this.chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @return poolChssUsdDys
	 */
	public String getPoolChssUsdDys() {
		return this.poolChssUsdDys;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return offhLocNm
	 */
	public String getOffhLocNm() {
		return this.offhLocNm;
	}
	
	/**
	 * Column Info
	 * @return offhDt
	 */
	public String getOffhDt() {
		return this.offhDt;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
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
	 * @param cntrOwnrCoCd
	 */
	public void setCntrOwnrCoCd(String cntrOwnrCoCd) {
		this.cntrOwnrCoCd = cntrOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param yyyyMm
	 */
	public void setYyyyMm(String yyyyMm) {
		this.yyyyMm = yyyyMm;
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
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param onhLocNm
	 */
	public void setOnhLocNm(String onhLocNm) {
		this.onhLocNm = onhLocNm;
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
	 * @param saveChk
	 */
	public void setSaveChk(String saveChk) {
		this.saveChk = saveChk;
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
	 * @param cntrOwnrCoNm
	 */
	public void setCntrOwnrCoNm(String cntrOwnrCoNm) {
		this.cntrOwnrCoNm = cntrOwnrCoNm;
	}
	
	/**
	 * Column Info
	 * @param chssOwnrCoCd
	 */
	public void setChssOwnrCoCd(String chssOwnrCoCd) {
		this.chssOwnrCoCd = chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @param poolChssUsdDys
	 */
	public void setPoolChssUsdDys(String poolChssUsdDys) {
		this.poolChssUsdDys = poolChssUsdDys;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param offhLocNm
	 */
	public void setOffhLocNm(String offhLocNm) {
		this.offhLocNm = offhLocNm;
	}
	
	/**
	 * Column Info
	 * @param offhDt
	 */
	public void setOffhDt(String offhDt) {
		this.offhDt = offhDt;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
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
		setCntrOwnrCoCd(JSPUtil.getParameter(request, prefix + "cntr_ownr_co_cd", ""));
		setChssPoolCd(JSPUtil.getParameter(request, prefix + "chss_pool_cd", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setYyyyMm(JSPUtil.getParameter(request, prefix + "yyyy_mm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setOnhLocNm(JSPUtil.getParameter(request, prefix + "onh_loc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSaveChk(JSPUtil.getParameter(request, prefix + "save_chk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrOwnrCoNm(JSPUtil.getParameter(request, prefix + "cntr_ownr_co_nm", ""));
		setChssOwnrCoCd(JSPUtil.getParameter(request, prefix + "chss_ownr_co_cd", ""));
		setPoolChssUsdDys(JSPUtil.getParameter(request, prefix + "pool_chss_usd_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setOffhLocNm(JSPUtil.getParameter(request, prefix + "offh_loc_nm", ""));
		setOffhDt(JSPUtil.getParameter(request, prefix + "offh_dt", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolCoChssUseHisMGTVO[]
	 */
	public PoolCoChssUseHisMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolCoChssUseHisMGTVO[]
	 */
	public PoolCoChssUseHisMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolCoChssUseHisMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntrOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_ownr_co_cd", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] yyyyMm = (JSPUtil.getParameter(request, prefix	+ "yyyy_mm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] onhLocNm = (JSPUtil.getParameter(request, prefix	+ "onh_loc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] saveChk = (JSPUtil.getParameter(request, prefix	+ "save_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrOwnrCoNm = (JSPUtil.getParameter(request, prefix	+ "cntr_ownr_co_nm", length));
			String[] chssOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "chss_ownr_co_cd", length));
			String[] poolChssUsdDys = (JSPUtil.getParameter(request, prefix	+ "pool_chss_usd_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] offhLocNm = (JSPUtil.getParameter(request, prefix	+ "offh_loc_nm", length));
			String[] offhDt = (JSPUtil.getParameter(request, prefix	+ "offh_dt", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolCoChssUseHisMGTVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntrOwnrCoCd[i] != null)
					model.setCntrOwnrCoCd(cntrOwnrCoCd[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (yyyyMm[i] != null)
					model.setYyyyMm(yyyyMm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (onhLocNm[i] != null)
					model.setOnhLocNm(onhLocNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (saveChk[i] != null)
					model.setSaveChk(saveChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrOwnrCoNm[i] != null)
					model.setCntrOwnrCoNm(cntrOwnrCoNm[i]);
				if (chssOwnrCoCd[i] != null)
					model.setChssOwnrCoCd(chssOwnrCoCd[i]);
				if (poolChssUsdDys[i] != null)
					model.setPoolChssUsdDys(poolChssUsdDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (offhLocNm[i] != null)
					model.setOffhLocNm(offhLocNm[i]);
				if (offhDt[i] != null)
					model.setOffhDt(offhDt[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolCoChssUseHisMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolCoChssUseHisMGTVO[]
	 */
	public PoolCoChssUseHisMGTVO[] getPoolCoChssUseHisMGTVOs(){
		PoolCoChssUseHisMGTVO[] vos = (PoolCoChssUseHisMGTVO[])models.toArray(new PoolCoChssUseHisMGTVO[models.size()]);
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
		this.cntrOwnrCoCd = this.cntrOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyMm = this.yyyyMm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhLocNm = this.onhLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveChk = this.saveChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOwnrCoNm = this.cntrOwnrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssOwnrCoCd = this.chssOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolChssUsdDys = this.poolChssUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhLocNm = this.offhLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDt = this.offhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
