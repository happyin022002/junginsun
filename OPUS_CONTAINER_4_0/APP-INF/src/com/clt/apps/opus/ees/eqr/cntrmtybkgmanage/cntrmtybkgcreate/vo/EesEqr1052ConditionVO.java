/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1052ConditionVO.java
*@FileTitle : EesEqr1052ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr1052ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1052ConditionVO> models = new ArrayList<EesEqr1052ConditionVO>();
	
	/* Column Info */
	private String targetrow = null;
	/* Column Info */
	private String vvd = null;	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* MULTI, SINGLE SPLIT 구분 */
	private String flag = null;	
	/* ROB 체크 여부 구분 */
	private String flagRob = null;	
	/* ROB 체크 여부 구분(split 에서 사용) */
	private String openFlagRob = null;
	/* ROB SPLIT VVD */
	private String vvdRob  = null;		
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String excelCntrNo = null;
	/* Column Info */
	private String bkgPod = null;
	/* Page Number */
	private String pagerows = null;
	
	private String tmpSeq  = null;
	private String vlBkgNo = null;
	private String vdBkgNo = null;
	private String vslCd  = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;
	
	private String podYdCd = null;
	private String toEtbDt = null;
	private String podClptIndSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1052ConditionVO() {}
	
	public EesEqr1052ConditionVO(String ibflag, String flag, String pagerows, String targetrow, String vvd, String bkgNo, String coCd, String bkgPod, String excelCntrNo, String tmpSeq, 
			String podYdCd, String toEtbDt, String vlBkgNo, String vdBkgNo, String vslCd, String skdVoyNo, String skdDirCd, String podClptIndSeq, String flagRob, String openFlagRob, String vvdRob) {
		this.targetrow 	= targetrow;
		this.vvd 	= vvd;		
		this.bkgNo 		= bkgNo;
		this.ibflag 	= ibflag;
		this.flag       = flag;
		this.coCd 		= coCd;
		this.excelCntrNo= excelCntrNo;
		this.bkgPod 	= bkgPod;
		this.pagerows 	= pagerows;

		this.tmpSeq  	= tmpSeq;
		this.podYdCd 	= podYdCd;
		this.toEtbDt 	= toEtbDt;
		this.podClptIndSeq=podClptIndSeq;
		this.vlBkgNo    = vlBkgNo;
		this.vdBkgNo    = vdBkgNo;
		this.vslCd      = vslCd;
		this.skdVoyNo   = skdVoyNo;
		this.skdDirCd   = skdDirCd;		
		
		this.flagRob    = flagRob;
		this.openFlagRob= openFlagRob;
		this.vvdRob     = vvdRob;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("targetrow", getTargetrow());
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("excel_cntr_no", getExcelCntrNo());
		this.hashColumns.put("bkg_pod", getBkgPod());
		this.hashColumns.put("pagerows", getPagerows());
		
		this.hashColumns.put("tmp_seq",   getTmpSeq());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("to_etb_dt", getToEtbDt());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		
		this.hashColumns.put("vl_bkg_no",  getVlBkgNo());	
		this.hashColumns.put("vd_bkg_no",  getVdBkgNo());	
		this.hashColumns.put("vsl_cd",     getVslCd());	
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());	
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());	

		this.hashColumns.put("flag_rob", getFlagRob());	
		this.hashColumns.put("open_flag_rob", getOpenFlagRob());			
		this.hashColumns.put("vvd_rob", getVvdRob());	
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("targetrow", "targetrow");
		this.hashFields.put("vvd", "vvd");		
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flag", "flag");		
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("excel_cntr_no", "excelCntrNo");
		this.hashFields.put("bkg_pod", "bkgPod");
		this.hashFields.put("pagerows", "pagerows");
		
		this.hashFields.put("tmp_seq",   "tmpSeq");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("to_etb_dt", "toEtbDt");	
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");	

		this.hashFields.put("vl_bkg_no",  "vlBkgNo");	
		this.hashFields.put("vd_bkg_no",  "vdBkgNo");	
		this.hashFields.put("vsl_cd",     "vslCd");	
		this.hashFields.put("skd_voy_no", "skdVoyNo");	
		this.hashFields.put("skd_dir_cd", "skdDirCd");

		this.hashFields.put("flag_rob", "flagRob");
		this.hashFields.put("open_flag_rob", "openFlagRob");		
		this.hashFields.put("vvd_rob", "vvdRob");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return targetrow
	 */
	public String getTargetrow() {
		return this.targetrow;
	}

	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * MULTI, SINGLE SPLIT 구분자
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}	
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return excelCntrNo
	 */
	public String getExcelCntrNo() {
		return this.excelCntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgPod
	 */
	public String getBkgPod() {
		return this.bkgPod;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getToEtbDt() {
		return this.toEtbDt;
	}	
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}		

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getVlBkgNo() {
		return this.vlBkgNo;
	}	
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getVdBkgNo() {
		return this.vdBkgNo;
	}	
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getVslCd() {
		return this.vslCd;
	}	
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}	
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}	
	
	/**
	 * Column Info
	 * @param targetrow
	 */
	public void setTargetrow(String targetrow) {
		this.targetrow = targetrow;
	}

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * Multi, Single Split 구분자
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param excelCntrNo
	 */
	public void setExcelCntrNo(String excelCntrNo) {
		this.excelCntrNo = excelCntrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgPod
	 */
	public void setBkgPod(String bkgPod) {
		this.bkgPod = bkgPod;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setToEtbDt(String toEtbDt) {
		this.toEtbDt = toEtbDt;
	}		
		
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}	
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setVlBkgNo(String vlBkgNo) {
		this.vlBkgNo = vlBkgNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setVdBkgNo(String vdBkgNo) {
		this.vdBkgNo = vdBkgNo;
	}	
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}	
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}	
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}		
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTargetrow(JSPUtil.getParameter(request, "targetRow", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));		
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));		
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setExcelCntrNo(JSPUtil.getParameter(request, "excel_cntr_no", ""));
		setBkgPod(JSPUtil.getParameter(request, "bkg_pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));

		setTmpSeq(JSPUtil.getParameter(request,  "tmp_seq", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setToEtbDt(JSPUtil.getParameter(request,  "to_etb_dt", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request,  "pod_clpt_ind_seq", ""));
		
		setVlBkgNo(JSPUtil.getParameter(request,   "vl_bkg_no", ""));
		setVdBkgNo(JSPUtil.getParameter(request,   "vd_bkg_no", ""));
		setVslCd(JSPUtil.getParameter(request,     "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,  "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request,  "skd_dir_cd", ""));
		
		setFlagRob(JSPUtil.getParameter(request,  "flag_rob", ""));
		setOpenFlagRob(JSPUtil.getParameter(request,  "open_flag_rob", ""));
		setVvdRob(JSPUtil.getParameter(request,  "vvd_rob", ""));
	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1052ConditionVO[]
	 */
	public EesEqr1052ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1052ConditionVO[]
	 */
	public EesEqr1052ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1052ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] targetrow = (JSPUtil.getParameter(request, prefix	+ "targetrow", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));			
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] excelCntrNo = (JSPUtil.getParameter(request, prefix	+ "excel_cntr_no", length));
			String[] bkgPod = (JSPUtil.getParameter(request, prefix	+ "bkg_pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] toEtbDt = (JSPUtil.getParameter(request, prefix	+ "to_etb_dt", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));			
			
			String[] vlBkgNo = (JSPUtil.getParameter(request, prefix	+ "vl_bkg_no", length));
			String[] vdBkgNo = (JSPUtil.getParameter(request, prefix	+ "vd_bkg_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			
			String[] flagRob = (JSPUtil.getParameter(request, prefix	+ "flag_rob", length));
			String[] openFlagRob = (JSPUtil.getParameter(request, prefix	+ "open_flag_rob", length));			
			String[] vvdRob  = (JSPUtil.getParameter(request, prefix	+ "vvd_rob", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1052ConditionVO();
				if (targetrow[i] != null)
					model.setTargetrow(targetrow[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);				
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);				
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (excelCntrNo[i] != null)
					model.setExcelCntrNo(excelCntrNo[i]);
				if (bkgPod[i] != null)
					model.setBkgPod(bkgPod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (toEtbDt[i] != null)
					model.setToEtbDt(toEtbDt[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				
				if (vlBkgNo[i] != null)
					model.setVlBkgNo(vlBkgNo[i]);
				if (vdBkgNo[i] != null)
					model.setVdBkgNo(vdBkgNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (flagRob[i] != null)
					model.setFlagRob(flagRob[i]);
				if (openFlagRob[i] != null)
					model.setOpenFlagRob(openFlagRob[i]);				
				if (vvdRob[i] != null)
					model.setVvdRob(vvdRob[i]);				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1052ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1052ConditionVO[]
	 */
	public EesEqr1052ConditionVO[] getEesEqr1052ConditionVOs(){
		EesEqr1052ConditionVO[] vos = (EesEqr1052ConditionVO[])models.toArray(new EesEqr1052ConditionVO[models.size()]);
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
		this.targetrow 		= this.targetrow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd 			= this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo 			= this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag 		= this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag 			= this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd 			= this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelCntrNo 	= this.excelCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPod 		= this.bkgPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows 		= this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.tmpSeq 		= this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd 		= this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDt 		= this.toEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq 	= this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.flagRob 		= this.flagRob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.openFlagRob 	= this.openFlagRob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRob 		= this.vvdRob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		
	}

	public String getFlagRob() {
		return flagRob;
	}

	public void setFlagRob(String flagRob) {
		this.flagRob = flagRob;
	}
	
	public String getOpenFlagRob() {
		return openFlagRob;
	}

	public void setOpenFlagRob(String openFlagRob) {
		this.openFlagRob = openFlagRob;
	}	

	public String getVvdRob() {
		return vvdRob;
	}

	public void setVvdRob(String vvdRob) {
		this.vvdRob = vvdRob;
	}
}
