/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreRestrictionInputVO.java
*@FileTitle : PreRestrictionInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.10.12 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreRestrictionInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreRestrictionInputVO> models = new ArrayList<PreRestrictionInputVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String spclCgoSeq = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String spclCntrSeq = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String optClss = null;
	/* Column Info */
	private String endNum = null;
	/* Column Info */
	private String startNum = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String imdgExptQtyFlg = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/* Column Info */
	private String imdgSegrGrpNo = null;
        /* VO Info */
	private PreRestrictionInputVO innerPreRestrictionInputVO = null;
	/* VO Info */
	private PreRestrictionInputVO[] innerPreRestrictionInputVOs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreRestrictionInputVO() {}

	public PreRestrictionInputVO(String ibflag, String pagerows, String fCmd, String bkgNo, String crrCd, String polCd, String podCd, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String spclCntrSeq, String spclCgoSeq, String imdgClssCd, String imdgUnNo, String imdgUnNoSeq, String optClss, String startNum, String endNum, String imdgLmtQtyFlg, String imdgExptQtyFlg, String imdgSegrGrpNo) {
		this.vslCd = vslCd;
		this.spclCgoSeq = spclCgoSeq;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.fCmd = fCmd;
		this.skdVoyNo = skdVoyNo;
		this.spclCntrSeq = spclCntrSeq;
		this.crrCd = crrCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.slanCd = slanCd;
		this.optClss = optClss;
		this.endNum = endNum;
		this.startNum = startNum;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.imdgExptQtyFlg = imdgExptQtyFlg;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.imdgSegrGrpNo = imdgSegrGrpNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("spcl_cgo_seq", getSpclCgoSeq());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("spcl_cntr_seq", getSpclCntrSeq());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("opt_clss", getOptClss());
		this.hashColumns.put("end_num", getEndNum());
		this.hashColumns.put("start_num", getStartNum());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("imdg_segr_grp_no", getImdgSegrGrpNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("spcl_cgo_seq", "spclCgoSeq");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("spcl_cntr_seq", "spclCntrSeq");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("opt_clss", "optClss");
		this.hashFields.put("end_num", "endNum");
		this.hashFields.put("start_num", "startNum");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("imdg_segr_grp_no", "imdgSegrGrpNo");
		return this.hashFields;
	}

        /**
	 * VO Info
	 * @return innerPreRestrictionInputVO
	 */
	public PreRestrictionInputVO getInnerPreRestrictionInputVO() {
		return this.innerPreRestrictionInputVO;
	}
	
	/**
	 * VO Info
	 * @return innerPreRestrictionInputVOs
	 */
	public PreRestrictionInputVO[] getInnerPreRestrictionInputVOS() {
		return this.innerPreRestrictionInputVOs;
	}
	
	/**
	 * VO Info
	 * @param innerPreRestrictionInputVO
	 */
	public void setInnerPreRestrictionInputVO(PreRestrictionInputVO innerPreRestrictionInputVO) {
		this.innerPreRestrictionInputVO = innerPreRestrictionInputVO;
	}
	
	/**
	 * VO Info
	 * @param innerPreRestrictionInputVOs
	 */
	public void setInnerPreRestrictionInputVOS(PreRestrictionInputVO[] innerPreRestrictionInputVOs) {
		this.innerPreRestrictionInputVOs = innerPreRestrictionInputVOs;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoSeq
	 */
	public String getSpclCgoSeq() {
		return this.spclCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return spclCntrSeq
	 */
	public String getSpclCntrSeq() {
		return this.spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return optClss
	 */
	public String getOptClss() {
		return this.optClss;
	}
	
	/**
	 * Column Info
	 * @return endNum
	 */
	public String getEndNum() {
		return this.endNum;
	}
	
	/**
	 * Column Info
	 * @return startNum
	 */
	public String getStartNum() {
		return this.startNum;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return imdgExptQtyFlg
	 */
	public String getImdgExptQtyFlg() {
		return this.imdgExptQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgSegrGrpNo
	 */
	public String getImdgSegrGrpNo() {
		return this.imdgSegrGrpNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoSeq
	 */
	public void setSpclCgoSeq(String spclCgoSeq) {
		this.spclCgoSeq = spclCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param spclCntrSeq
	 */
	public void setSpclCntrSeq(String spclCntrSeq) {
		this.spclCntrSeq = spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param optClss
	 */
	public void setOptClss(String optClss) {
		this.optClss = optClss;
	}
	
	/**
	 * Column Info
	 * @param endNum
	 */
	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}
	
	/**
	 * Column Info
	 * @param startNum
	 */
	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param imdgExptQtyFlg
	 */
	public void setImdgExptQtyFlg(String imdgExptQtyFlg) {
		this.imdgExptQtyFlg = imdgExptQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgSegrGrpNo
	 */
	public void setImdgSegrGrpNo(String imdgSegrGrpNo) {
		this.imdgSegrGrpNo = imdgSegrGrpNo;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSpclCgoSeq(JSPUtil.getParameter(request, "spcl_cgo_seq", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSpclCntrSeq(JSPUtil.getParameter(request, "spcl_cntr_seq", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setOptClss(JSPUtil.getParameter(request, "opt_clss", ""));
		setEndNum(JSPUtil.getParameter(request, "end_num", ""));
		setStartNum(JSPUtil.getParameter(request, "start_num", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setImdgExptQtyFlg(JSPUtil.getParameter(request, "imdg_expt_qty_flg", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, "imdg_lmt_qty_flg", ""));
		setImdgSegrGrpNo(JSPUtil.getParameter(request, "imdg_segr_grp_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreRestrictionInputVO[]
	 */
	public PreRestrictionInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreRestrictionInputVO[]
	 */
	public PreRestrictionInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreRestrictionInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] spclCgoSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_seq", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] spclCntrSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_seq", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] optClss = (JSPUtil.getParameter(request, prefix	+ "opt_clss", length));
			String[] endNum = (JSPUtil.getParameter(request, prefix	+ "end_num", length));
			String[] startNum = (JSPUtil.getParameter(request, prefix	+ "start_num", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_flg", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] imdgSegrGrpNo = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_grp_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreRestrictionInputVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (spclCgoSeq[i] != null)
					model.setSpclCgoSeq(spclCgoSeq[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (spclCntrSeq[i] != null)
					model.setSpclCntrSeq(spclCntrSeq[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (optClss[i] != null)
					model.setOptClss(optClss[i]);
				if (endNum[i] != null)
					model.setEndNum(endNum[i]);
				if (startNum[i] != null)
					model.setStartNum(startNum[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (imdgExptQtyFlg[i] != null)
					model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if (imdgSegrGrpNo[i] != null)
					model.setImdgSegrGrpNo(imdgSegrGrpNo[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreRestrictionInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreRestrictionInputVO[]
	 */
	public PreRestrictionInputVO[] getPreRestrictionInputVOs(){
		PreRestrictionInputVO[] vos = (PreRestrictionInputVO[])models.toArray(new PreRestrictionInputVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoSeq = this.spclCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrSeq = this.spclCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optClss = this.optClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endNum = this.endNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startNum = this.startNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyFlg = this.imdgExptQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrGrpNo = this.imdgSegrGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
