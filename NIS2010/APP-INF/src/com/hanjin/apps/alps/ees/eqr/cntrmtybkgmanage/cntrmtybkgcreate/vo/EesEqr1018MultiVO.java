/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1018MultiVO.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.07.30 신용찬
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 신용찬
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr1018MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<EesEqr1018MultiVO> models = new ArrayList<EesEqr1018MultiVO>();
	

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	
	/* Column Info */
	private String trspModCd 		= null;
	private String vslLaneCd 		= null;
	private String vslCd 			= null;
	private String skdVoyNo 		= null;
	private String skdDirCd 		= null;
    private String bkgExeSeq		=null;

	private String fmYdCd 			= null;
	private String fmEtdDt 			= null;
	private String polClptIndSeq 	= null;	
	private String toYdCd 			= null;
	private String toEtbDt 			= null;
	private String podClptIndSeq 	= null;		

	private String repoPlnFbRsnCd 	= null;
	private String eqRepoPurpCd 	= null;
	private String repoPlnFbRmk 	= null;
	
	private String vpsPort 			= null;
	private String mtyBkgNo 		= null;	
	private String mtyBkgFlag 		= null;  // BKG 생성여부 표시 (T/F)
	private String mtyRobFlg        = null;  // ROB BKG 생성 여부(Y/N)

	private String cntrNo 			= null;
	private String cntrTpszCd 		= null;
	private String mvmtStsCd 		= null;
	
	private String creUsrId 		= null;
	private String creDt 			= null;
	private String updUsrId 		= null;
	private String updDt 			= null;

	/* input Param */
	/*
	 * type size 순서대로 해당 value를 담기위한 변수
	 */
	private List<String> tpszList 	= null;
	private List<String> volList 	= null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());

		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bkg_exe_seq", getBkgExeSeq());
		
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());		
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("to_etb_dt", getToEtbDt());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());		

		this.hashColumns.put("repo_pln_fb_rsn_cd", getRepoPlnFbRsnCd());
		this.hashColumns.put("eq_repo_purp_cd", getEqRepoPurpCd());
		this.hashColumns.put("repo_pln_fb_rmk", getRepoPlnFbRmk());

		this.hashColumns.put("vps_port", getVpsPort());
		this.hashColumns.put("mty_bkg_no", getMtyBkgNo());

		this.hashColumns.put("mty_bkg_flag", getMtyBkgFlag());
		this.hashColumns.put("mty_rob_flg", getMtyRobFlg());
		
		this.hashColumns.put("cntr_no",      getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mvmt_sts_cd",  getMvmtStsCd());
		
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");

		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bkg_exe_seq", "bkgExeSeq");
		
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");		
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("to_etb_dt", "toEtbDt");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");		

		this.hashFields.put("repo_pln_fb_rsn_cd", 	"repoPlnFbRsnCd");
		this.hashFields.put("eq_repo_purp_cd", 		"eqRepoPurpCd");	
		this.hashFields.put("repo_pln_fb_rmk", 		"repoPlnFbRmk");

		this.hashFields.put("vps_port", 	"vpsPort");
		this.hashFields.put("mty_bkg_no", 	"mtyBkgNo");
		this.hashFields.put("mty_bkg_flag", "mtyBkgFlag");
		this.hashFields.put("mty_rob_flg",  "mtyRobFlg");
		
		this.hashFields.put("cntr_no",      "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mvmt_sts_cd",  "mvmtStsCd");
		
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

	public String getVslLaneCd() {
		return vslLaneCd;
	}

	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
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
	
	public String getBkgExeSeq() {
		return bkgExeSeq;
	}

	public void setBkgExeSeq(String bkgExeSeq) {
		this.bkgExeSeq = bkgExeSeq;
	}	

	public String getFmYdCd() {
		return fmYdCd;
	}

	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}

	public String getToYdCd() {
		return toYdCd;
	}

	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
	}

	public String getFmEtdDt() {
		return fmEtdDt;
	}

	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
	}
	
	public String getPolClptIndSeq() {
		return polClptIndSeq;
	}

	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}	

	public String getToEtbDt() {
		return toEtbDt;
	}

	public void setToEtbDt(String toEtbDt) {
		this.toEtbDt = toEtbDt;
	}
	
	public String getPodClptIndSeq() {
		return podClptIndSeq;
	}

	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}	

	public String getRepoPlnFbRsnCd() {
		return repoPlnFbRsnCd;
	}

	public void setRepoPlnFbRsnCd(String repoPlnFbRsnCd) {
		this.repoPlnFbRsnCd = repoPlnFbRsnCd;
	}

	public String getEqRepoPurpCd() {
		return eqRepoPurpCd;
	}

	public void setEqRepoPurpCd(String eqRepoPurpCd) {
		this.eqRepoPurpCd = eqRepoPurpCd;
	}

	public String getTrspModCd() {
		return trspModCd;
	}

	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getRepoPlnFbRmk() {
		return repoPlnFbRmk;
	}

	public void setRepoPlnFbRmk(String repoPlnFbRmk) {
		this.repoPlnFbRmk = repoPlnFbRmk;
	}
	
	public String getVpsPort() {
		return vpsPort;
	}

	public void setVpsPort(String vpsPort) {
		this.vpsPort = vpsPort;
	}	

	public String getMtyBkgNo() {
		return mtyBkgNo;
	}

	public void setMtyBkgNo(String mtyBkgNo) {
		this.mtyBkgNo = mtyBkgNo;
	}		
	
	public String getMtyBkgFlag() {
		return mtyBkgFlag;
	}

	public void setMtyBkgFlag(String mtyBkgFlag) {
		this.mtyBkgFlag = mtyBkgFlag;
	}	
	
	public String getMtyRobFlg() {
		return mtyRobFlg;
	}

	public void setMtyRobFlg(String mtyRobFlg) {
		this.mtyRobFlg = mtyRobFlg;
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
	
	public List<String> getTpszList() {
		return tpszList;
	}

	public void setTpszList(List<String> tpszList) {
		this.tpszList = tpszList;
	}
	
	public List<String> getVolList() {
		return volList;
	}

	public void setVolList(List<String> volList) {
		this.volList = volList;
	}


	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrVslLodgDchgExePlnVO[]
	 */
	public EesEqr1018MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1018MultiVO model = null;	
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String tpsztype = JSPUtil.getParameter(request, "tpszall".trim(), ""); // tpsz all value
	    	String[] tpszArr = tpsztype.split(","); 
	    	
			String[] ibflag			= (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows		= (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			String[] trspModCd		= (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));			
			String[] vslLaneCd		= (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] vvd			= (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgExeSeq		= (JSPUtil.getParameter(request, prefix	+ "bkg_exe_seq", length));	
			
			String[] fmYdCd			= (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] toYdCd			= (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] polClptIndSeq	= (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));			
			String[] fmEtdDt		= (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] toEtbDt		= (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] podClptIndSeq	= (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));				

			String[] eqRepoPurpCd	= (JSPUtil.getParameter(request, prefix	+ "eq_repo_purp_cd", length));
			String[] repoPlnFbRsnCd = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rsn_cd", length));
			String[] repoPlnFbRmk	= (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rmk", length));
						
			String[] vpsPort    	= (JSPUtil.getParameter(request, prefix	+ "vps_port", 		length));
			String[] mtyBkgNo    	= (JSPUtil.getParameter(request, prefix	+ "mty_bkg_no", 	length));
			String[] mtyBkgFlag  	= (JSPUtil.getParameter(request, prefix	+ "mty_bkg_flag", 	length));
			String[] mtyRobFlg  	= (JSPUtil.getParameter(request, prefix	+ "mty_rob_flg", 	length));
			
			String[] cntrNo    		= (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd    	= (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mvmtStsCd    	= (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			
			List<String[]> volListArr = new ArrayList<String[]>();

			for(int i=0; i<tpszArr.length; i++) {
				String[] volArr = (JSPUtil.getParameter(request, prefix	+ "qty_"+tpszArr[i], length));				
				volListArr.add(volArr);

			}
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1018MultiVO();
				
				List<String> tpszList = new ArrayList<String>();
				List<String> volList = new ArrayList<String>();

				for(int t=0; t<tpszArr.length; t++) {
					String[] volArr  = (String[])volListArr.get(t);	
					
					tpszList.add(tpszArr[t]);
					if(volArr[i] != null)
						volList.add(volArr[i]);
				}
				
				model.setTpszList(tpszList);
				model.setVolList(volList);

				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);				

				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);				
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				
				// VVD 분리
				if (vvd[i] != null && vvd[i].length() >= 9){
					model.setVslCd(vvd[i].substring(0,4));
					model.setSkdVoyNo(vvd[i].substring(4,8));
					model.setSkdDirCd(vvd[i].substring(8,9));
				}
				
				if (bkgExeSeq[i] != null)
					model.setBkgExeSeq(bkgExeSeq[i]);				

				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);				
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (toEtbDt[i] != null)
					model.setToEtbDt(toEtbDt[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);					

				if (repoPlnFbRsnCd[i] != null)
					model.setRepoPlnFbRsnCd(repoPlnFbRsnCd[i]);
				if (eqRepoPurpCd[i] != null)
					model.setEqRepoPurpCd(eqRepoPurpCd[i]);
				if (repoPlnFbRmk[i] != null)
					model.setRepoPlnFbRmk(repoPlnFbRmk[i]);

				if (vpsPort[i] != null)
					model.setVpsPort(vpsPort[i]);

				if (mtyBkgNo[i] != null)
					model.setMtyBkgNo(mtyBkgNo[i]);
				if (mtyBkgFlag[i] != null)
					model.setMtyBkgFlag(mtyBkgFlag[i]);
				if (mtyRobFlg[i] != null)
					model.setMtyRobFlg(mtyRobFlg[i]);				
				
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);

				
				models.add(model);
			}
			
		} catch (Exception e) {
			return null;
		}
		
		return getEesEqr1018MultiVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return EesEqr0080MultiVO[]
	 */
	public EesEqr1018MultiVO[] getEesEqr1018MultiVOs(){
		EesEqr1018MultiVO[] vos = (EesEqr1018MultiVO[])models.toArray(new EesEqr1018MultiVO[models.size()]);
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
		this.ibflag 		= this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows 		= this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.trspModCd 		= this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd 		= this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd 			= this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo 		= this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd 		= this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgExeSeq 		= this.bkgExeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.fmYdCd			= this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt 		= this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq 	= this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd 		= this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDt 		= this.toEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq 	= this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.repoPlnFbRsnCd = this.repoPlnFbRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoPurpCd 	= this.eqRepoPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRmk 	= this.repoPlnFbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.vpsPort    	= this.vpsPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.mtyBkgNo   	= this.mtyBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgFlag 	= this.mtyBkgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRobFlg  	= this.mtyRobFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.cntrNo 		= this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd 	= this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd 		= this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
