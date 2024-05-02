/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MvmtListFromSppVO.java
*@FileTitle : MvmtListFromSppVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.10.06 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MvmtListFromSppVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MvmtListFromSppVO> models = new ArrayList<MvmtListFromSppVO>();
	
	/* Column Info */
	private String cnmsCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String inpYdCd = null;
	/* Column Info */
	private String cnmvDtTm = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String cnmvUnm = null;
	/* Column Info */
	private String usrs89 = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntCdR = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String usrs88 = null;
	/* Column Info */
	private String cnmvUsid = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String usrs10 = null;
	/* Column Info */
	private String skdVoyageNo = null;
	/* Column Info */
	private String dstYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MvmtListFromSppVO() {}

	public MvmtListFromSppVO(String ibflag, String pagerows, String svrId, String cntCdR, String cnmsCd, String orgYdCd, String inpYdCd, String cnmvDtTm, String cnmvUnm, String cnmvUsid, String cntrNo, String bkgNo, String bkgNoSplit, String blNo, String vslCd, String skdVoyageNo, String skdDirCd, String polLoc, String podLoc, String usrs10, String dstYdCd, String usrs88, String usrs89, String cnmvRmk) {
		this.cnmsCd = cnmsCd;
		this.vslCd = vslCd;
		this.inpYdCd = inpYdCd;
		this.cnmvDtTm = cnmvDtTm;
		this.polLoc = polLoc;
		this.bkgNoSplit = bkgNoSplit;
		this.cnmvUnm = cnmvUnm;
		this.usrs89 = usrs89;
		this.podLoc = podLoc;
		this.orgYdCd = orgYdCd;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntCdR = cntCdR;
		this.cnmvRmk = cnmvRmk;
		this.usrs88 = usrs88;
		this.cnmvUsid = cnmvUsid;
		this.cntrNo = cntrNo;
		this.usrs10 = usrs10;
		this.skdVoyageNo = skdVoyageNo;
		this.dstYdCd = dstYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnms_cd", getCnmsCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("inp_yd_cd", getInpYdCd());
		this.hashColumns.put("cnmv_dt_tm", getCnmvDtTm());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("cnmv_unm", getCnmvUnm());
		this.hashColumns.put("usrs89", getUsrs89());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnt_cd_r", getCntCdR());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("usrs88", getUsrs88());
		this.hashColumns.put("cnmv_usid", getCnmvUsid());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("usrs10", getUsrs10());
		this.hashColumns.put("skd_voyage_no", getSkdVoyageNo());
		this.hashColumns.put("dst_yd_cd", getDstYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnms_cd", "cnmsCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("inp_yd_cd", "inpYdCd");
		this.hashFields.put("cnmv_dt_tm", "cnmvDtTm");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("cnmv_unm", "cnmvUnm");
		this.hashFields.put("usrs89", "usrs89");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnt_cd_r", "cntCdR");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("usrs88", "usrs88");
		this.hashFields.put("cnmv_usid", "cnmvUsid");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("usrs10", "usrs10");
		this.hashFields.put("skd_voyage_no", "skdVoyageNo");
		this.hashFields.put("dst_yd_cd", "dstYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnmsCd
	 */
	public String getCnmsCd() {
		return this.cnmsCd;
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
	 * @return inpYdCd
	 */
	public String getInpYdCd() {
		return this.inpYdCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvDtTm
	 */
	public String getCnmvDtTm() {
		return this.cnmvDtTm;
	}
	
	/**
	 * Column Info
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return cnmvUnm
	 */
	public String getCnmvUnm() {
		return this.cnmvUnm;
	}
	
	/**
	 * Column Info
	 * @return usrs89
	 */
	public String getUsrs89() {
		return this.usrs89;
	}
	
	/**
	 * Column Info
	 * @return podLoc
	 */
	public String getPodLoc() {
		return this.podLoc;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return cntCdR
	 */
	public String getCntCdR() {
		return this.cntCdR;
	}
	
	/**
	 * Column Info
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @return usrs88
	 */
	public String getUsrs88() {
		return this.usrs88;
	}
	
	/**
	 * Column Info
	 * @return cnmvUsid
	 */
	public String getCnmvUsid() {
		return this.cnmvUsid;
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
	 * @return usrs10
	 */
	public String getUsrs10() {
		return this.usrs10;
	}
	
	/**
	 * Column Info
	 * @return skdVoyageNo
	 */
	public String getSkdVoyageNo() {
		return this.skdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @return dstYdCd
	 */
	public String getDstYdCd() {
		return this.dstYdCd;
	}
	

	/**
	 * Column Info
	 * @param cnmsCd
	 */
	public void setCnmsCd(String cnmsCd) {
		this.cnmsCd = cnmsCd;
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
	 * @param inpYdCd
	 */
	public void setInpYdCd(String inpYdCd) {
		this.inpYdCd = inpYdCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvDtTm
	 */
	public void setCnmvDtTm(String cnmvDtTm) {
		this.cnmvDtTm = cnmvDtTm;
	}
	
	/**
	 * Column Info
	 * @param polLoc
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param cnmvUnm
	 */
	public void setCnmvUnm(String cnmvUnm) {
		this.cnmvUnm = cnmvUnm;
	}
	
	/**
	 * Column Info
	 * @param usrs89
	 */
	public void setUsrs89(String usrs89) {
		this.usrs89 = usrs89;
	}
	
	/**
	 * Column Info
	 * @param podLoc
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param cntCdR
	 */
	public void setCntCdR(String cntCdR) {
		this.cntCdR = cntCdR;
	}
	
	/**
	 * Column Info
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @param usrs88
	 */
	public void setUsrs88(String usrs88) {
		this.usrs88 = usrs88;
	}
	
	/**
	 * Column Info
	 * @param cnmvUsid
	 */
	public void setCnmvUsid(String cnmvUsid) {
		this.cnmvUsid = cnmvUsid;
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
	 * @param usrs10
	 */
	public void setUsrs10(String usrs10) {
		this.usrs10 = usrs10;
	}
	
	/**
	 * Column Info
	 * @param skdVoyageNo
	 */
	public void setSkdVoyageNo(String skdVoyageNo) {
		this.skdVoyageNo = skdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @param dstYdCd
	 */
	public void setDstYdCd(String dstYdCd) {
		this.dstYdCd = dstYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCnmsCd(JSPUtil.getParameter(request, "cnms_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setInpYdCd(JSPUtil.getParameter(request, "inp_yd_cd", ""));
		setCnmvDtTm(JSPUtil.getParameter(request, "cnmv_dt_tm", ""));
		setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setCnmvUnm(JSPUtil.getParameter(request, "cnmv_unm", ""));
		setUsrs89(JSPUtil.getParameter(request, "usrs89", ""));
		setPodLoc(JSPUtil.getParameter(request, "pod_loc", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntCdR(JSPUtil.getParameter(request, "cnt_cd_r", ""));
		setCnmvRmk(JSPUtil.getParameter(request, "cnmv_rmk", ""));
		setUsrs88(JSPUtil.getParameter(request, "usrs88", ""));
		setCnmvUsid(JSPUtil.getParameter(request, "cnmv_usid", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setUsrs10(JSPUtil.getParameter(request, "usrs10", ""));
		setSkdVoyageNo(JSPUtil.getParameter(request, "skd_voyage_no", ""));
		setDstYdCd(JSPUtil.getParameter(request, "dst_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MvmtListFromSppVO[]
	 */
	public MvmtListFromSppVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MvmtListFromSppVO[]
	 */
	public MvmtListFromSppVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MvmtListFromSppVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnmsCd = (JSPUtil.getParameter(request, prefix	+ "cnms_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] inpYdCd = (JSPUtil.getParameter(request, prefix	+ "inp_yd_cd", length));
			String[] cnmvDtTm = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt_tm", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] cnmvUnm = (JSPUtil.getParameter(request, prefix	+ "cnmv_unm", length));
			String[] usrs89 = (JSPUtil.getParameter(request, prefix	+ "usrs89", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntCdR = (JSPUtil.getParameter(request, prefix	+ "cnt_cd_r", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] usrs88 = (JSPUtil.getParameter(request, prefix	+ "usrs88", length));
			String[] cnmvUsid = (JSPUtil.getParameter(request, prefix	+ "cnmv_usid", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] usrs10 = (JSPUtil.getParameter(request, prefix	+ "usrs10", length));
			String[] skdVoyageNo = (JSPUtil.getParameter(request, prefix	+ "skd_voyage_no", length));
			String[] dstYdCd = (JSPUtil.getParameter(request, prefix	+ "dst_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MvmtListFromSppVO();
				if (cnmsCd[i] != null)
					model.setCnmsCd(cnmsCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (inpYdCd[i] != null)
					model.setInpYdCd(inpYdCd[i]);
				if (cnmvDtTm[i] != null)
					model.setCnmvDtTm(cnmvDtTm[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (cnmvUnm[i] != null)
					model.setCnmvUnm(cnmvUnm[i]);
				if (usrs89[i] != null)
					model.setUsrs89(usrs89[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntCdR[i] != null)
					model.setCntCdR(cntCdR[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (usrs88[i] != null)
					model.setUsrs88(usrs88[i]);
				if (cnmvUsid[i] != null)
					model.setCnmvUsid(cnmvUsid[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (usrs10[i] != null)
					model.setUsrs10(usrs10[i]);
				if (skdVoyageNo[i] != null)
					model.setSkdVoyageNo(skdVoyageNo[i]);
				if (dstYdCd[i] != null)
					model.setDstYdCd(dstYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMvmtListFromSppVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MvmtListFromSppVO[]
	 */
	public MvmtListFromSppVO[] getMvmtListFromSppVOs(){
		MvmtListFromSppVO[] vos = (MvmtListFromSppVO[])models.toArray(new MvmtListFromSppVO[models.size()]);
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
		this.cnmsCd = this.cnmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYdCd = this.inpYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDtTm = this.cnmvDtTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvUnm = this.cnmvUnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrs89 = this.usrs89 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCdR = this.cntCdR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrs88 = this.usrs88 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvUsid = this.cnmvUsid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrs10 = this.usrs10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyageNo = this.skdVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstYdCd = this.dstYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
