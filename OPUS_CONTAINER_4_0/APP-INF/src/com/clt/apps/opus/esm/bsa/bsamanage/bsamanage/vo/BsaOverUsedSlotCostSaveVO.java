/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BSAManageOverUsedSlotCostSaveVO.java
*@FileTitle : BSAManageOverUsedSlotCostSaveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.19 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaOverUsedSlotCostSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaOverUsedSlotCostSaveVO> models = new ArrayList<BsaOverUsedSlotCostSaveVO>();
	
	/* Column Info */
	private String chtrUcAmt = null;
	/* Column Info */
	private String fmPortCd = null;
	/* Column Info */
	private String ovrUsdSltPrcSeq = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bsaSltPrcToDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grp = null;
	/* Column Info */
	private String addChtrUcAmt = null;
	/* Column Info */
	private String bzcChtrUcAmt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bsaSltPrcFmDt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String toPortCd = null;
	/* Column Info */
	private String bsaOpJbCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String arrUcAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaOverUsedSlotCostSaveVO() {}

	public BsaOverUsedSlotCostSaveVO(
			String ibflag, String pagerows, String grp, String seq, String trdCd, 
			String rlaneCd, String dirCd, String vvdCd, String bsaSltPrcFmDt, 
			String bsaSltPrcToDt, String fmPortCd, String toPortCd, String ovrUsdSltPrcSeq, 
			String bzcChtrUcAmt, String chtrUcAmt, String addChtrUcAmt,
			String bsaOpJbCd, String crrCd, String arrUcAmt,String creUsrId,String updUsrId) {
		this.chtrUcAmt = chtrUcAmt;
		this.fmPortCd = fmPortCd;
		this.ovrUsdSltPrcSeq = ovrUsdSltPrcSeq;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.bsaSltPrcToDt = bsaSltPrcToDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.grp = grp;
		this.addChtrUcAmt = addChtrUcAmt;
		this.bzcChtrUcAmt = bzcChtrUcAmt;
		this.vvdCd = vvdCd;
		this.bsaSltPrcFmDt = bsaSltPrcFmDt;
		this.seq = seq;
		this.dirCd = dirCd;
		this.toPortCd = toPortCd;
		this.bsaOpJbCd=bsaOpJbCd;
		this.crrCd=crrCd;
		this.arrUcAmt=arrUcAmt;
		this.creUsrId=creUsrId;
		this.updUsrId=updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chtr_uc_amt", getChtrUcAmt());
		this.hashColumns.put("fm_port_cd", getFmPortCd());
		this.hashColumns.put("ovr_usd_slt_prc_seq", getOvrUsdSltPrcSeq());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bsa_slt_prc_to_dt", getBsaSltPrcToDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("add_chtr_uc_amt", getAddChtrUcAmt());
		this.hashColumns.put("bzc_chtr_uc_amt", getBzcChtrUcAmt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bsa_slt_prc_fm_dt", getBsaSltPrcFmDt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("bsa_op_jb_cd", getBsaOpJbCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("arruc_amt", getArrUcAmt());
		this.hashColumns.put("cre_usr_id",getCreUsrId());
		this.hashColumns.put("upd_usr_id",getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chtr_uc_amt", "chtrUcAmt");
		this.hashFields.put("fm_port_cd", "fmPortCd");
		this.hashFields.put("ovr_usd_slt_prc_seq", "ovrUsdSltPrcSeq");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bsa_slt_prc_to_dt", "bsaSltPrcToDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("add_chtr_uc_amt", "addChtrUcAmt");
		this.hashFields.put("bzc_chtr_uc_amt", "bzcChtrUcAmt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bsa_slt_prc_fm_dt", "bsaSltPrcFmDt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("to_port_cd", "toPortCd");
		this.hashFields.put("bsa_op_jb_cd", "bsaOpJbCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("arruc_amt", "arrUcAmt");
		this.hashFields.put("cre_usr_id","creUsrId");
		this.hashFields.put("upd_usr_id","updUsrId");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chtrUcAmt
	 */
	public String getChtrUcAmt() {
		return this.chtrUcAmt;
	}
	
	/**
	 * Column Info
	 * @return fmPortCd
	 */
	public String getFmPortCd() {
		return this.fmPortCd;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdSltPrcSeq
	 */
	public String getOvrUsdSltPrcSeq() {
		return this.ovrUsdSltPrcSeq;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrcToDt
	 */
	public String getBsaSltPrcToDt() {
		return this.bsaSltPrcToDt;
	}
	
	/**
	 * Page Number
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
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
	}
	
	/**
	 * Column Info
	 * @return addChtrUcAmt
	 */
	public String getAddChtrUcAmt() {
		return this.addChtrUcAmt;
	}
	
	/**
	 * Column Info
	 * @return bzcChtrUcAmt
	 */
	public String getBzcChtrUcAmt() {
		return this.bzcChtrUcAmt;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrcFmDt
	 */
	public String getBsaSltPrcFmDt() {
		return this.bsaSltPrcFmDt;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return this.toPortCd;
	}
	

	/**
	 * Column Info
	 * @param chtrUcAmt
	 */
	public void setChtrUcAmt(String chtrUcAmt) {
		this.chtrUcAmt = chtrUcAmt;
	}
	
	/**
	 * Column Info
	 * @param fmPortCd
	 */
	public void setFmPortCd(String fmPortCd) {
		this.fmPortCd = fmPortCd;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdSltPrcSeq
	 */
	public void setOvrUsdSltPrcSeq(String ovrUsdSltPrcSeq) {
		this.ovrUsdSltPrcSeq = ovrUsdSltPrcSeq;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrcToDt
	 */
	public void setBsaSltPrcToDt(String bsaSltPrcToDt) {
		this.bsaSltPrcToDt = bsaSltPrcToDt;
	}
	
	/**
	 * Page Number
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
	}
	
	/**
	 * Column Info
	 * @param addChtrUcAmt
	 */
	public void setAddChtrUcAmt(String addChtrUcAmt) {
		this.addChtrUcAmt = addChtrUcAmt;
	}
	
	/**
	 * Column Info
	 * @param bzcChtrUcAmt
	 */
	public void setBzcChtrUcAmt(String bzcChtrUcAmt) {
		this.bzcChtrUcAmt = bzcChtrUcAmt;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrcFmDt
	 */
	public void setBsaSltPrcFmDt(String bsaSltPrcFmDt) {
		this.bsaSltPrcFmDt = bsaSltPrcFmDt;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
	}
	
	
	
	public String getBsaOpJbCd() {
		return bsaOpJbCd;
	}

	public void setBsaOpJbCd(String bsaOpJbCd) {
		this.bsaOpJbCd = bsaOpJbCd;
	}

	public String getCrrCd() {
		return crrCd;
	}

	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	

	public String getArrUcAmt() {
		return arrUcAmt;
	}

	public void setArrUcAmt(String arrUcAmt) {
		this.arrUcAmt = arrUcAmt;
	}
	
	

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChtrUcAmt(JSPUtil.getParameter(request, "chtr_uc_amt", ""));
		setFmPortCd(JSPUtil.getParameter(request, "fm_port_cd", ""));
		setOvrUsdSltPrcSeq(JSPUtil.getParameter(request, "ovr_usd_slt_prc_seq", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setBsaSltPrcToDt(JSPUtil.getParameter(request, "bsa_slt_prc_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setAddChtrUcAmt(JSPUtil.getParameter(request, "add_chtr_uc_amt", ""));
		setBzcChtrUcAmt(JSPUtil.getParameter(request, "bzc_chtr_uc_amt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setBsaSltPrcFmDt(JSPUtil.getParameter(request, "bsa_slt_prc_fm_dt", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setToPortCd(JSPUtil.getParameter(request, "to_port_cd", ""));
		setBsaOpJbCd(JSPUtil.getParameter(request, "bsa_op_jb_cd",""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd",""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOverUsedSlotCostListVO[]
	 */
	public BsaOverUsedSlotCostSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOverUsedSlotCostListVO[]
	 */
	public BsaOverUsedSlotCostSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaOverUsedSlotCostSaveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
		String[] arrcrr_cd =null;
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
  		setBsaOpJbCd(JSPUtil.getParameter(request, "bsa_op_jb_cd",""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd",""));
		
		if (getBsaOpJbCd().length()>0) { 
			bsaOpJbCd = getBsaOpJbCd(); 
		}
		if (getCrrCd().length()>0){ 
			crrCd = getCrrCd(); 
		}
		
		arrcrr_cd = crrCd.split("[|]");		
		
		try {
			String[] chtrUcAmt = (JSPUtil.getParameter(request, prefix	+ "chtr_uc_amt", length));
			String[] fmPortCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_cd", length));
			String[] ovrUsdSltPrcSeq = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_slt_prc_seq", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bsaSltPrcToDt = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] addChtrUcAmt = (JSPUtil.getParameter(request, prefix	+ "add_chtr_uc_amt", length));
			String[] bzcChtrUcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_chtr_uc_amt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bsaSltPrcFmDt = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc_fm_dt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaOverUsedSlotCostSaveVO();
				String uc_amt_tmp="";
				
				if (chtrUcAmt[i] != null)				model.setChtrUcAmt(chtrUcAmt[i]);
				if (fmPortCd[i] != null)				model.setFmPortCd(fmPortCd[i]);
				if (ovrUsdSltPrcSeq[i] != null)			model.setOvrUsdSltPrcSeq(ovrUsdSltPrcSeq[i]);
				if (trdCd[i] != null)					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)					model.setRlaneCd(rlaneCd[i]);
				if (bsaSltPrcToDt[i] != null)			model.setBsaSltPrcToDt(bsaSltPrcToDt[i]);
				if (pagerows[i] != null)				model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)					model.setIbflag(ibflag[i]);
				if (grp[i] != null)						model.setGrp(grp[i]);
				if (addChtrUcAmt[i] != null)			model.setAddChtrUcAmt(addChtrUcAmt[i]);
				if (bzcChtrUcAmt[i] != null)			model.setBzcChtrUcAmt(bzcChtrUcAmt[i]);
				if (vvdCd[i] != null)					model.setVvdCd(vvdCd[i]);
				if (bsaSltPrcFmDt[i] != null)			model.setBsaSltPrcFmDt(bsaSltPrcFmDt[i]);
				if (seq[i] != null)						model.setSeq(seq[i]);
				if (dirCd[i] != null)					model.setDirCd(dirCd[i]);
				if (toPortCd[i] != null)				model.setToPortCd(toPortCd[i]);
				for (int j = 0; j < arrcrr_cd.length; j++) {
					 String[] uc_amt 		= (JSPUtil.getParameter(request, "uc_amt"+ j, length));
					 uc_amt_tmp 	= 	uc_amt_tmp + "|" + uc_amt[i];
					 
					}
				if (uc_amt_tmp !=null) 					model.setArrUcAmt(uc_amt_tmp);
				if (bsaOpJbCd !=null)					model.setBsaOpJbCd(bsaOpJbCd);
				if (crrCd !=null)						model.setCrrCd(crrCd);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOverUsedSlotCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOverUsedSlotCostListVO[]
	 */
	public BsaOverUsedSlotCostSaveVO[] getSearchOverUsedSlotCostListVOs(){
		BsaOverUsedSlotCostSaveVO[] vos = (BsaOverUsedSlotCostSaveVO[])models.toArray(new BsaOverUsedSlotCostSaveVO[models.size()]);
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
		this.chtrUcAmt = this.chtrUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCd = this.fmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdSltPrcSeq = this.ovrUsdSltPrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrcToDt = this.bsaSltPrcToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChtrUcAmt = this.addChtrUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcChtrUcAmt = this.bzcChtrUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrcFmDt = this.bsaSltPrcFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
