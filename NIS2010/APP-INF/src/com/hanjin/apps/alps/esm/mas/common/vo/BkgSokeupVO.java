/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgSokeupVO.java
*@FileTitle : BkgSokeupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.common.vo;

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

public class BkgSokeupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgSokeupVO> models = new ArrayList<BkgSokeupVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String masBatSeq = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String masBatRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String masBatDt = null;
	/* Column Info */
	private String fToDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fFmDate = null;
	/* Column Info */
	private String fStatus = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String finishTime = null;
	/* Column Info */
	private String masBatCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgSokeupVO() {}

	public BkgSokeupVO(String ibflag, String pagerows, String bkgNo, String masBatSeq, String masBatRmk, String creUsrId, String creDt, String updUsrId, String updDt, String masBatCd, String masBatDt, String fFmDate, String fToDate, String fStatus, String maxSeq, String status, String finishTime) {
		this.updDt = updDt;
		this.masBatSeq = masBatSeq;
		this.status = status;
		this.creDt = creDt;
		this.masBatRmk = masBatRmk;
		this.pagerows = pagerows;
		this.masBatDt = masBatDt;
		this.fToDate = fToDate;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.fFmDate = fFmDate;
		this.fStatus = fStatus;
		this.maxSeq = maxSeq;
		this.finishTime = finishTime;
		this.masBatCd = masBatCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mas_bat_seq", getMasBatSeq());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mas_bat_rmk", getMasBatRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mas_bat_dt", getMasBatDt());
		this.hashColumns.put("f_to_date", getFToDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("f_fm_date", getFFmDate());
		this.hashColumns.put("f_status", getFStatus());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("finish_time", getFinishTime());
		this.hashColumns.put("mas_bat_cd", getMasBatCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mas_bat_seq", "masBatSeq");
		this.hashFields.put("status", "status");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mas_bat_rmk", "masBatRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mas_bat_dt", "masBatDt");
		this.hashFields.put("f_to_date", "fToDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("f_fm_date", "fFmDate");
		this.hashFields.put("f_status", "fStatus");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("finish_time", "finishTime");
		this.hashFields.put("mas_bat_cd", "masBatCd");
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
	 * @return masBatSeq
	 */
	public String getMasBatSeq() {
		return this.masBatSeq;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
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
	 * @return masBatRmk
	 */
	public String getMasBatRmk() {
		return this.masBatRmk;
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
	 * @return masBatDt
	 */
	public String getMasBatDt() {
		return this.masBatDt;
	}
	
	/**
	 * Column Info
	 * @return fToDate
	 */
	public String getFToDate() {
		return this.fToDate;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return fFmDate
	 */
	public String getFFmDate() {
		return this.fFmDate;
	}
	
	/**
	 * Column Info
	 * @return fStatus
	 */
	public String getFStatus() {
		return this.fStatus;
	}
	
	/**
	 * Column Info
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
	}
	
	/**
	 * Column Info
	 * @return finishTime
	 */
	public String getFinishTime() {
		return this.finishTime;
	}
	
	/**
	 * Column Info
	 * @return masBatCd
	 */
	public String getMasBatCd() {
		return this.masBatCd;
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
	 * @param masBatSeq
	 */
	public void setMasBatSeq(String masBatSeq) {
		this.masBatSeq = masBatSeq;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @param masBatRmk
	 */
	public void setMasBatRmk(String masBatRmk) {
		this.masBatRmk = masBatRmk;
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
	 * @param masBatDt
	 */
	public void setMasBatDt(String masBatDt) {
		this.masBatDt = masBatDt;
	}
	
	/**
	 * Column Info
	 * @param fToDate
	 */
	public void setFToDate(String fToDate) {
		this.fToDate = fToDate;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param fFmDate
	 */
	public void setFFmDate(String fFmDate) {
		this.fFmDate = fFmDate;
	}
	
	/**
	 * Column Info
	 * @param fStatus
	 */
	public void setFStatus(String fStatus) {
		this.fStatus = fStatus;
	}
	
	/**
	 * Column Info
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	
	/**
	 * Column Info
	 * @param finishTime
	 */
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	
	/**
	 * Column Info
	 * @param masBatCd
	 */
	public void setMasBatCd(String masBatCd) {
		this.masBatCd = masBatCd;
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
		setMasBatSeq(JSPUtil.getParameter(request, prefix + "mas_bat_seq", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMasBatRmk(JSPUtil.getParameter(request, prefix + "mas_bat_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMasBatDt(JSPUtil.getParameter(request, prefix + "mas_bat_dt", ""));
		setFToDate(JSPUtil.getParameter(request, prefix + "f_to_date", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFFmDate(JSPUtil.getParameter(request, prefix + "f_fm_date", ""));
		setFStatus(JSPUtil.getParameter(request, prefix + "f_status", ""));
		setMaxSeq(JSPUtil.getParameter(request, prefix + "max_seq", ""));
		setFinishTime(JSPUtil.getParameter(request, prefix + "finish_time", ""));
		setMasBatCd(JSPUtil.getParameter(request, prefix + "mas_bat_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgSokeupVO[]
	 */
	public BkgSokeupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgSokeupVO[]
	 */
	public BkgSokeupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgSokeupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] masBatSeq = (JSPUtil.getParameter(request, prefix	+ "mas_bat_seq", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] masBatRmk = (JSPUtil.getParameter(request, prefix	+ "mas_bat_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] masBatDt = (JSPUtil.getParameter(request, prefix	+ "mas_bat_dt", length));
			String[] fToDate = (JSPUtil.getParameter(request, prefix	+ "f_to_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fFmDate = (JSPUtil.getParameter(request, prefix	+ "f_fm_date", length));
			String[] fStatus = (JSPUtil.getParameter(request, prefix	+ "f_status", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] finishTime = (JSPUtil.getParameter(request, prefix	+ "finish_time", length));
			String[] masBatCd = (JSPUtil.getParameter(request, prefix	+ "mas_bat_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgSokeupVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (masBatSeq[i] != null)
					model.setMasBatSeq(masBatSeq[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (masBatRmk[i] != null)
					model.setMasBatRmk(masBatRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (masBatDt[i] != null)
					model.setMasBatDt(masBatDt[i]);
				if (fToDate[i] != null)
					model.setFToDate(fToDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fFmDate[i] != null)
					model.setFFmDate(fFmDate[i]);
				if (fStatus[i] != null)
					model.setFStatus(fStatus[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (finishTime[i] != null)
					model.setFinishTime(finishTime[i]);
				if (masBatCd[i] != null)
					model.setMasBatCd(masBatCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgSokeupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgSokeupVO[]
	 */
	public BkgSokeupVO[] getBkgSokeupVOs(){
		BkgSokeupVO[] vos = (BkgSokeupVO[])models.toArray(new BkgSokeupVO[models.size()]);
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
		this.masBatSeq = this.masBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatRmk = this.masBatRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatDt = this.masBatDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToDate = this.fToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmDate = this.fFmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStatus = this.fStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq = this.maxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finishTime = this.finishTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masBatCd = this.masBatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
