/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BsaSpcCtrlSwapVO.java
*@FileTitle : BsaSpcCtrlSwapVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.09.03 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaSpcCtrlSwapVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaSpcCtrlSwapVO> models = new ArrayList<BsaSpcCtrlSwapVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bsaFmCrrCd = null;
	/* Column Info */
	private String crrSwapCapa = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bsaToCrrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsaOpJbCd = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bsaSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaSpcCtrlSwapVO() {}

	public BsaSpcCtrlSwapVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String dirCd, String vopCd, String vslCapa, String bsaSeq, String bsaOpCd, String bsaOpJbCd, String bsaFmCrrCd, String bsaToCrrCd, String crrSwapCapa, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.bsaFmCrrCd = bsaFmCrrCd;
		this.crrSwapCapa = crrSwapCapa;
		this.creDt = creDt;
		this.vopCd = vopCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.bsaToCrrCd = bsaToCrrCd;
		this.pagerows = pagerows;
		this.vslCapa = vslCapa;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bsaOpJbCd = bsaOpJbCd;
		this.bsaOpCd = bsaOpCd;
		this.dirCd = dirCd;
		this.bsaSeq = bsaSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bsa_fm_crr_cd", getBsaFmCrrCd());
		this.hashColumns.put("crr_swap_capa", getCrrSwapCapa());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bsa_to_crr_cd", getBsaToCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa_op_jb_cd", getBsaOpJbCd());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bsa_seq", getBsaSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bsa_fm_crr_cd", "bsaFmCrrCd");
		this.hashFields.put("crr_swap_capa", "crrSwapCapa");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bsa_to_crr_cd", "bsaToCrrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa_op_jb_cd", "bsaOpJbCd");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bsa_seq", "bsaSeq");
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
	 * @return bsaFmCrrCd
	 */
	public String getBsaFmCrrCd() {
		return this.bsaFmCrrCd;
	}
	
	/**
	 * Column Info
	 * @return crrSwapCapa
	 */
	public String getCrrSwapCapa() {
		return this.crrSwapCapa;
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
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
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
	 * @return bsaToCrrCd
	 */
	public String getBsaToCrrCd() {
		return this.bsaToCrrCd;
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
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return bsaOpJbCd
	 */
	public String getBsaOpJbCd() {
		return this.bsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
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
	 * @return bsaSeq
	 */
	public String getBsaSeq() {
		return this.bsaSeq;
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
	 * @param bsaFmCrrCd
	 */
	public void setBsaFmCrrCd(String bsaFmCrrCd) {
		this.bsaFmCrrCd = bsaFmCrrCd;
	}
	
	/**
	 * Column Info
	 * @param crrSwapCapa
	 */
	public void setCrrSwapCapa(String crrSwapCapa) {
		this.crrSwapCapa = crrSwapCapa;
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
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
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
	 * @param bsaToCrrCd
	 */
	public void setBsaToCrrCd(String bsaToCrrCd) {
		this.bsaToCrrCd = bsaToCrrCd;
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
	 * @param vslCapa
	 */
	public void setVslCapa(String vslCapa) {
		this.vslCapa = vslCapa;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param bsaOpJbCd
	 */
	public void setBsaOpJbCd(String bsaOpJbCd) {
		this.bsaOpJbCd = bsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
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
	 * @param bsaSeq
	 */
	public void setBsaSeq(String bsaSeq) {
		this.bsaSeq = bsaSeq;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBsaFmCrrCd(JSPUtil.getParameter(request, "bsa_fm_crr_cd", ""));
		setCrrSwapCapa(JSPUtil.getParameter(request, "crr_swap_capa", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setBsaToCrrCd(JSPUtil.getParameter(request, "bsa_to_crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslCapa(JSPUtil.getParameter(request, "vsl_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBsaOpJbCd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		setBsaOpCd(JSPUtil.getParameter(request, "bsa_op_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setBsaSeq(JSPUtil.getParameter(request, "bsa_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaSpcCtrlSwapVO[]
	 */
	public BsaSpcCtrlSwapVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaSpcCtrlSwapVO[]
	 */
	public BsaSpcCtrlSwapVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaSpcCtrlSwapVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bsaFmCrrCd = (JSPUtil.getParameter(request, prefix	+ "bsa_fm_crr_cd", length));
			String[] crrSwapCapa = (JSPUtil.getParameter(request, prefix	+ "crr_swap_capa", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bsaToCrrCd = (JSPUtil.getParameter(request, prefix	+ "bsa_to_crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsaOpJbCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_jb_cd", length));
			String[] bsaOpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bsaSeq = (JSPUtil.getParameter(request, prefix	+ "bsa_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaSpcCtrlSwapVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bsaFmCrrCd[i] != null)
					model.setBsaFmCrrCd(bsaFmCrrCd[i]);
				if (crrSwapCapa[i] != null)
					model.setCrrSwapCapa(crrSwapCapa[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bsaToCrrCd[i] != null)
					model.setBsaToCrrCd(bsaToCrrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsaOpJbCd[i] != null)
					model.setBsaOpJbCd(bsaOpJbCd[i]);
				if (bsaOpCd[i] != null)
					model.setBsaOpCd(bsaOpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bsaSeq[i] != null)
					model.setBsaSeq(bsaSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaSpcCtrlSwapVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaSpcCtrlSwapVO[]
	 */
	public BsaSpcCtrlSwapVO[] getBsaSpcCtrlSwapVOs(){
		BsaSpcCtrlSwapVO[] vos = (BsaSpcCtrlSwapVO[])models.toArray(new BsaSpcCtrlSwapVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaFmCrrCd = this.bsaFmCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrSwapCapa = this.crrSwapCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaToCrrCd = this.bsaToCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpJbCd = this.bsaOpJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSeq = this.bsaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
