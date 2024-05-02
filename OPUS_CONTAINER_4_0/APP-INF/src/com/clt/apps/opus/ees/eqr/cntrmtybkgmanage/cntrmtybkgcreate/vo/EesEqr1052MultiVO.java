/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1052MultiVO.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

public class EesEqr1052MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<EesEqr1052MultiVO> models = new ArrayList<EesEqr1052MultiVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
    
	private String seq 			= null;
	private String vlBkgNo 		= null;
	private String cntrNo 		= null;
	private String cntrTpszCd 	= null;
	private String mvmtStsCd    = null;
    private String polYd		= null;
	private String clptSeq 		= null;
	private String podYdCd  	= null;
	private String toEtbDt  	= null;

	private String vrfyStatus   = null; // vrfy_status
	private String polYdCd      = null; // pol_yd_cd
	private String vpsEtdDt     = null; // vps_etd_dt
	private String vslCd        = null;
	private String skdVoyNo     = null;
	private String skdDirCd     = null;
		
	private String creUsrId 	= null;
	private String creDt 		= null;
	private String updUsrId 	= null;
	private String updDt 		= null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("ibflag",   	getIbflag());
		this.hashColumns.put("pagerows", 	getPagerows());

		this.hashColumns.put("seq", 		getSeq());
		this.hashColumns.put("vl_bkg_no", 	getVlBkgNo());	
		this.hashColumns.put("cntr_no", 	getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd",getCntrTpszCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());		
		
		this.hashColumns.put("pol_yd", 		getPolYd());		
		this.hashColumns.put("clpt_seq", 	getClptSeq());
		this.hashColumns.put("pod_yd_cd", 	getPodYdCd());
		this.hashColumns.put("to_etb_dt", 	getToEtbDt());	
		
		this.hashColumns.put("vrfy_status",	getVrfyStatus());	
		this.hashColumns.put("pol_yd_cd", 	getPolYdCd());	
		this.hashColumns.put("vps_etd_dt", 	getVpsEtdDt());		

		this.hashColumns.put("vsl_cd", 		getVslCd());	
		this.hashColumns.put("skd_voy_no", 	getSkdVoyNo());	
		this.hashColumns.put("skd_dir_cd", 	getSkdDirCd());	
		
		this.hashColumns.put("cre_usr_id", 	getCreUsrId());
		this.hashColumns.put("cre_dt", 		getCreDt());
		this.hashColumns.put("upd_usr_id", 	getUpdUsrId());
		this.hashColumns.put("upd_dt", 		getUpdDt());
		
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");

		this.hashFields.put("seq", "seq");
		this.hashFields.put("vl_bkg_no", "vlBkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		
		this.hashFields.put("pol_yd", "polYd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("pod_yd_cd", "podYdCd");		
		this.hashFields.put("to_etb_dt", "toEtbDt");

		this.hashFields.put("vrfy_status", 	"vrfyStatus");
		this.hashFields.put("pol_yd_cd", 	"polYdCd");
		this.hashFields.put("vps_etd_dt", 	"vpsEtdDt");
		
		this.hashFields.put("vsl_cd", 		"vslCd");	
		this.hashFields.put("skd_voy_no", 	"skdVoyNo");	
		this.hashFields.put("skd_dir_cd", 	"skdDirCd");
		
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		
		return this.hashFields;
	}
	
	public String getIbflag() {
		return ibflag;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public String getPagerows() {
		return pagerows;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getVlBkgNo() {
		return vlBkgNo;
	}

	public void setVlBkgNo(String vlBkgNo) {
		this.vlBkgNo = vlBkgNo;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}		

	public String getMvmtStsCd() {
		return mvmtStsCd;
	}

	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}	
	
	public String getPolYd() {
		return polYd;
	}

	public void setPolYd(String polYd) {
		this.polYd = polYd;
	}	

	public String getClptSeq() {
		return clptSeq;
	}

	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}

	public String getPodYdCd() {
		return podYdCd;
	}

	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}

	public String getToEtbDt() {
		return toEtbDt;
	}

	public void setToEtbDt(String toEtbDt) {
		this.toEtbDt = toEtbDt;
	}
	
	public String getVrfyStatus() {
		return vrfyStatus;
	}

	public void setVrfyStatus(String vrfyStatus) {
		this.vrfyStatus = vrfyStatus;
	}
	
	public String getPolYdCd() {
		return polYdCd;
	}

	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	public String getVpsEtdDt() {
		return vpsEtdDt;
	}

	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrVslLodgDchgExePlnVO[]
	 */
	public EesEqr1052MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1052MultiVO model = null;	
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag			= (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows		= (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			String[] seq			= (JSPUtil.getParameter(request, prefix	+ "seq", length));			
			String[] vlBkgNo		= (JSPUtil.getParameter(request, prefix	+ "vl_bkg_no", length));
			String[] cntrNo			= (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd		= (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));	
			String[] mvmtStsCd		= (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));	
			
			String[] polYd			= (JSPUtil.getParameter(request, prefix	+ "pol_yd", length));
			String[] clptSeq		= (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] podYdCd		= (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] toEtbDt		= (JSPUtil.getParameter(request, prefix	+ "to_etb_dt", length));

			String[] vrfyStatus			= (JSPUtil.getParameter(request, prefix	+ "vrfy_status", length));
			String[] polYdCd		= (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] vpsEtdDt		= (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			
			String[] vslCd  		= (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo		= (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd		= (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1052MultiVO();				

				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);				

				if (seq[i] != null)
					model.setSeq(seq[i]);				
				if (vlBkgNo[i] != null)
					model.setVlBkgNo(vlBkgNo[i]);				
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);				
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);				
				
				if (polYd[i] != null)
					model.setPolYd(polYd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (toEtbDt[i] != null)
					model.setToEtbDt(toEtbDt[i]);		

				if (vrfyStatus[i] != null)
					model.setVrfyStatus(vrfyStatus[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				
				models.add(model);
			}
			
		} catch (Exception e) {
			return null;
		}
		
		return getEesEqr1052MultiVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return EesEqr0080MultiVO[]
	 */
	public EesEqr1052MultiVO[] getEesEqr1052MultiVOs(){
		EesEqr1052MultiVO[] vos = (EesEqr1052MultiVO[])models.toArray(new EesEqr1052MultiVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlBkgNo = this.vlBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.polYd = this.polYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDt = this.toEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.vrfyStatus = this.vrfyStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd 	= this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt 	= this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.vslCd    = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		

	}
}
