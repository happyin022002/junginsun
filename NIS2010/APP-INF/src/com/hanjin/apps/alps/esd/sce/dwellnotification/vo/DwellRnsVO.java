/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellRnsVO.java
*@FileTitle : DwellRnsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.06.05 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DwellRnsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DwellRnsVO> models = new ArrayList<DwellRnsVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String dwllRsn = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dwllTmTpCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String dwllRsnTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String[] resultStrArray = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String creUsrId = null;
	/* Page Number */
	private String updUsrId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DwellRnsVO() {}

	public DwellRnsVO(String ibflag, String pagerows, String emlSndDt, String dwllTmTpCd, String cntrNo, String bkgNo, String hisSeq, String dwllRsn, String dwllRsnTpCd ,String row
			          ,String creUsrId , String updUsrId) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.emlSndDt = emlSndDt;
		this.dwllRsn = dwllRsn;
		this.cntrNo = cntrNo;
		this.dwllTmTpCd = dwllTmTpCd;
		this.hisSeq = hisSeq;
		this.dwllRsnTpCd = dwllRsnTpCd;
		this.pagerows = pagerows;
		this.row   = row;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("dwll_rsn", getDwllRsn());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dwll_tm_tp_cd", getDwllTmTpCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("dwll_rsn_tp_cd", getDwllRsnTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("dwll_rsn", "dwllRsn");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dwll_tm_tp_cd", "dwllTmTpCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("dwll_rsn_tp_cd", "dwllRsnTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("row", "row");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return dwllRsn
	 */
	public String getDwllRsn() {
		return this.dwllRsn;
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
	 * @return dwllTmTpCd
	 */
	public String getDwllTmTpCd() {
		return this.dwllTmTpCd;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return dwllRsnTpCd
	 */
	public String getDwllRsnTpCd() {
		return this.dwllRsnTpCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param dwllRsn
	 */
	public void setDwllRsn(String dwllRsn) {
		this.dwllRsn = dwllRsn;
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
	 * @param dwllTmTpCd
	 */
	public void setDwllTmTpCd(String dwllTmTpCd) {
		this.dwllTmTpCd = dwllTmTpCd;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param dwllRsnTpCd
	 */
	public void setDwllRsnTpCd(String dwllRsnTpCd) {
		this.dwllRsnTpCd = dwllRsnTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	
/**
	 * @return the resultStrArray
	 */
	public String[] getResultStrArray() {
		return resultStrArray;
	}

	/**
	 * @param resultStrArray the resultStrArray to set
	 */
	public void setResultStrArray(String[] resultStrArray) {
		this.resultStrArray = resultStrArray;
	}

	
/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	
/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setDwllRsn(JSPUtil.getParameter(request, prefix + "dwll_rsn", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDwllTmTpCd(JSPUtil.getParameter(request, prefix + "dwll_tm_tp_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setDwllRsnTpCd(JSPUtil.getParameter(request, prefix + "dwll_rsn_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRow(JSPUtil.getParameter(request, prefix + "row", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DwellRnsVO[]
	 */
	public DwellRnsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DwellRnsVO[]
	 */
	public DwellRnsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DwellRnsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] dwllRsn = (JSPUtil.getParameter(request, prefix	+ "dwll_rsn", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dwllTmTpCd = (JSPUtil.getParameter(request, prefix	+ "dwll_tm_tp_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] dwllRsnTpCd = (JSPUtil.getParameter(request, prefix	+ "dwll_rsn_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new DwellRnsVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (dwllRsn[i] != null)
					model.setDwllRsn(dwllRsn[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dwllTmTpCd[i] != null)
					model.setDwllTmTpCd(dwllTmTpCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (dwllRsnTpCd[i] != null)
					model.setDwllRsnTpCd(dwllRsnTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDwellRnsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DwellRnsVO[]
	 */
	public DwellRnsVO[] getDwellRnsVOs(){
		DwellRnsVO[] vos = (DwellRnsVO[])models.toArray(new DwellRnsVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllRsn = this.dwllRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllTmTpCd = this.dwllTmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllRsnTpCd = this.dwllRsnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
