/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPInquiryVO.java
*@FileTitle : COPInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.02 오현경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copsearch.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class COPInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<COPInquiryVO> models = new ArrayList<COPInquiryVO>();
	
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String copNoSlave = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String oldCopNo = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String newCopNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String bkgCreDt1 = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String bkgCreDt2 = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String bkgEventTpCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public COPInquiryVO() {}

	public COPInquiryVO(String ibflag, String pagerows, String bkgNo, String soNo, String pageNo, 
			String cntrNo, String bkgCreDt1, String copNo, String oldCopNo, String newCopNo, String copNoSlave,
             String refNo, String bkgCreDt2, String rowNum, String blNo, String cntrTpszCd, 
             String pctlNo, String bkgStsCd, String copStsCd, String usrId, String bkgEventTpCd) {
		this.soNo = soNo;
		this.bkgStsCd = bkgStsCd;
		this.copNo = copNo;
		this.copNoSlave = copNoSlave;
		this.blNo = blNo;
		this.oldCopNo = oldCopNo;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.newCopNo = newCopNo;
		this.usrId = usrId;
		this.pageNo = pageNo;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.copStsCd = copStsCd;
		this.bkgCreDt1 = bkgCreDt1;
		this.refNo = refNo;
		this.bkgCreDt2 = bkgCreDt2;
		this.rowNum = rowNum;
		this.bkgEventTpCd = bkgEventTpCd;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cop_no_slave", getCopNoSlave());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("old_cop_no", getOldCopNo());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("new_cop_no", getNewCopNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("bkg_cre_dt1", getBkgCreDt1());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("bkg_cre_dt2", getBkgCreDt2());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("bkg_event_tp_cd", getBkgEventTpCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cop_no_slave", "copNoSlave");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("old_cop_no", "oldCopNo");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("new_cop_no", "newCopNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("bkg_cre_dt1", "bkgCreDt1");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("bkg_cre_dt2", "bkgCreDt2");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("bkg_event_tp_cd", "bkgEventTpCd");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return copNoSlave
	 */
	public String getCopNoSlave() {
		return this.copNoSlave;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return oldCopNo
	 */
	public String getOldCopNo() {
		return this.oldCopNo;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return newCopNo
	 */
	public String getNewCopNo() {
		return this.newCopNo;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt1
	 */
	public String getBkgCreDt1() {
		return this.bkgCreDt1;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt2
	 */
	public String getBkgCreDt2() {
		return this.bkgCreDt2;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getBkgEventTpCd() {
		return this.bkgEventTpCd;
	}
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param copNoSlave
	 */
	public void setCopNoSlave(String copNoSlave) {
		this.copNoSlave = copNoSlave;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param oldCopNo
	 */
	public void setOldCopNo(String oldCopNo) {
		this.oldCopNo = oldCopNo;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param newCopNo
	 */
	public void setNewCopNo(String newCopNo) {
		this.newCopNo = newCopNo;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt1
	 */
	public void setBkgCreDt1(String bkgCreDt1) {
		this.bkgCreDt1 = bkgCreDt1;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt2
	 */
	public void setBkgCreDt2(String bkgCreDt2) {
		this.bkgCreDt2 = bkgCreDt2;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setBkgEventTpCd(String bkgEventTpCd) {
		this.bkgEventTpCd = bkgEventTpCd;
	}
		
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSoNo(JSPUtil.getParameter(request, "so_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setCopNoSlave(JSPUtil.getParameter(request, "cop_no_slave", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setOldCopNo(JSPUtil.getParameter(request, "old_cop_no", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setNewCopNo(JSPUtil.getParameter(request, "new_cop_no", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setBkgCreDt1(JSPUtil.getParameter(request, "bkg_cre_dt1", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setBkgCreDt2(JSPUtil.getParameter(request, "bkg_cre_dt2", ""));
		setRowNum(JSPUtil.getParameter(request, "row_num", ""));
		setRowNum(JSPUtil.getParameter(request, "bkg_event_tp_cd", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return COPInquiryVO[]
	 */
	public COPInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return COPInquiryVO[]
	 */
	public COPInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		COPInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] copNoSlave = (JSPUtil.getParameter(request, prefix	+ "cop_no_slave", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] oldCopNo = (JSPUtil.getParameter(request, prefix	+ "old_cop_no", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] newCopNo = (JSPUtil.getParameter(request, prefix	+ "new_cop_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] bkgCreDt1 = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt1", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] bkgCreDt2 = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt2", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] bkgEventTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_event_tp_cd", length));			
			
			for (int i = 0; i < length; i++) {
				model = new COPInquiryVO();
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (copNoSlave[i] != null)
					model.setCopNoSlave(copNoSlave[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (oldCopNo[i] != null)
					model.setOldCopNo(oldCopNo[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (newCopNo[i] != null)
					model.setNewCopNo(newCopNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (bkgCreDt1[i] != null)
					model.setBkgCreDt1(bkgCreDt1[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (bkgCreDt2[i] != null)
					model.setBkgCreDt2(bkgCreDt2[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (bkgEventTpCd[i] != null)
					model.setBkgEventTpCd(bkgEventTpCd[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCOPInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return COPInquiryVO[]
	 */
	public COPInquiryVO[] getCOPInquiryVOs(){
		COPInquiryVO[] vos = (COPInquiryVO[])models.toArray(new COPInquiryVO[models.size()]);
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
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNoSlave = this.copNoSlave .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCopNo = this.oldCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCopNo = this.newCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt1 = this.bkgCreDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt2 = this.bkgCreDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEventTpCd = this.bkgEventTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
