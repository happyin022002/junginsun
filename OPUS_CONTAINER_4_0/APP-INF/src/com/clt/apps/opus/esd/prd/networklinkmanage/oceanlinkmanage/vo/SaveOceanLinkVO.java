/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SaveOceanLinkVO.java
*@FileTitle : SaveOceanLinkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.09.15 김귀진 
* 1.0 Creation
=========================================================*/
/*
 * 2010.10.22 진마리아 CHM-201006410-01 HQ Link Management Logic 변경 요청(lnk_rmk 추가)
 */

package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SaveOceanLinkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaveOceanLinkVO> models = new ArrayList<SaveOceanLinkVO>();
	
	/* Column Info */
	private String fmtTztmHrs = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String podetb = null;
	/* Column Info */
	private String poletb = null;
	/* Column Info */
	private String dircd = null;
	/* Column Info */
	private String poletd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rseq = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String podprot = null;
	/* Column Info */
	private String ocnLnkMnlFlg = null;
	/* Column Info */
	private String podetd = null;
	/* Column Info */
	private String lanecd = null;
	/* Column Info */
	private String polprot = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lnkRmk = null;
	/* Column Info */
	private String lnkSeq = null;
	/* Column Info */
	private String chk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SaveOceanLinkVO() {}

	public SaveOceanLinkVO(String ibflag, String pagerows, String creOfcCd, String creUsrId, String updUsrId, String rseq, String lanecd, String dircd, String polprot, String poletb, String poletd, String podprot, String podetb, String podetd, String fmtTztmHrs, String remark, String ocnLnkMnlFlg, String lnkRmk, String lnkSeq, String chk) {
		this.fmtTztmHrs = fmtTztmHrs;
		this.remark = remark;
		this.podetb = podetb;
		this.poletb = poletb;
		this.dircd = dircd;
		this.poletd = poletd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rseq = rseq;
		this.creOfcCd = creOfcCd;
		this.podprot = podprot;
		this.ocnLnkMnlFlg = ocnLnkMnlFlg;
		this.podetd = podetd;
		this.lanecd = lanecd;
		this.polprot = polprot;
		this.updUsrId = updUsrId;
		this.lnkRmk = lnkRmk;
		this.lnkSeq = lnkSeq;
		this.chk = chk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fmt_tztm_hrs", getFmtTztmHrs());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("podetb", getPodetb());
		this.hashColumns.put("poletb", getPoletb());
		this.hashColumns.put("dircd", getDircd());
		this.hashColumns.put("poletd", getPoletd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rseq", getRseq());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("podprot", getPodprot());
		this.hashColumns.put("ocn_lnk_mnl_flg", getOcnLnkMnlFlg());
		this.hashColumns.put("podetd", getPodetd());
		this.hashColumns.put("lanecd", getLanecd());
		this.hashColumns.put("polprot", getPolprot());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lnk_rmk", getLnkRmk());
		this.hashColumns.put("lnk_seq", getLnkSeq());
		this.hashColumns.put("chk", getChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fmt_tztm_hrs", "fmtTztmHrs");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("podetb", "podetb");
		this.hashFields.put("poletb", "poletb");
		this.hashFields.put("dircd", "dircd");
		this.hashFields.put("poletd", "poletd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rseq", "rseq");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("podprot", "podprot");
		this.hashFields.put("ocn_lnk_mnl_flg", "ocnLnkMnlFlg");
		this.hashFields.put("podetd", "podetd");
		this.hashFields.put("lanecd", "lanecd");
		this.hashFields.put("polprot", "polprot");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lnk_rmk", "lnkRmk");
		this.hashFields.put("lnk_seq", "lnkSeq");
		this.hashFields.put("chk", "chk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs
	 */
	public String getFmtTztmHrs() {
		return this.fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return podetb
	 */
	public String getPodetb() {
		return this.podetb;
	}
	
	/**
	 * Column Info
	 * @return poletb
	 */
	public String getPoletb() {
		return this.poletb;
	}
	
	/**
	 * Column Info
	 * @return dircd
	 */
	public String getDircd() {
		return this.dircd;
	}
	
	/**
	 * Column Info
	 * @return poletd
	 */
	public String getPoletd() {
		return this.poletd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return rseq
	 */
	public String getRseq() {
		return this.rseq;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return podprot
	 */
	public String getPodprot() {
		return this.podprot;
	}
	
	/**
	 * Column Info
	 * @return ocnLnkMnlFlg
	 */
	public String getOcnLnkMnlFlg() {
		return this.ocnLnkMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return podetd
	 */
	public String getPodetd() {
		return this.podetd;
	}
	
	/**
	 * Column Info
	 * @return lanecd
	 */
	public String getLanecd() {
		return this.lanecd;
	}
	
	/**
	 * Column Info
	 * @return polprot
	 */
	public String getPolprot() {
		return this.polprot;
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
	 * @return lnkRmk
	 */
	public String getLnkRmk() {
		return this.lnkRmk;
	}
	
	/**
	 * Column Info
	 * @return lnkSeq
	 */
	public String getLnkSeq() {
		return this.lnkSeq;
	}

	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}

	/**
	 * Column Info
	 * @param fmtTztmHrs
	 */
	public void setFmtTztmHrs(String fmtTztmHrs) {
		this.fmtTztmHrs = fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param podetb
	 */
	public void setPodetb(String podetb) {
		this.podetb = podetb;
	}
	
	/**
	 * Column Info
	 * @param poletb
	 */
	public void setPoletb(String poletb) {
		this.poletb = poletb;
	}
	
	/**
	 * Column Info
	 * @param dircd
	 */
	public void setDircd(String dircd) {
		this.dircd = dircd;
	}
	
	/**
	 * Column Info
	 * @param poletd
	 */
	public void setPoletd(String poletd) {
		this.poletd = poletd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param rseq
	 */
	public void setRseq(String rseq) {
		this.rseq = rseq;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param podprot
	 */
	public void setPodprot(String podprot) {
		this.podprot = podprot;
	}
	
	/**
	 * Column Info
	 * @param ocnLnkMnlFlg
	 */
	public void setOcnLnkMnlFlg(String ocnLnkMnlFlg) {
		this.ocnLnkMnlFlg = ocnLnkMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param podetd
	 */
	public void setPodetd(String podetd) {
		this.podetd = podetd;
	}
	
	/**
	 * Column Info
	 * @param lanecd
	 */
	public void setLanecd(String lanecd) {
		this.lanecd = lanecd;
	}
	
	/**
	 * Column Info
	 * @param polprot
	 */
	public void setPolprot(String polprot) {
		this.polprot = polprot;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param lnkRmk
	 */
	public void setLnkRmk(String lnkRmk) {
		this.lnkRmk = lnkRmk;
	}
	
	/**
	 * Column Info
	 * @param lnkRmk
	 */
	public void setLnkSeq(String lnkSeq) {
		this.lnkSeq = lnkSeq;
	}

	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmtTztmHrs(JSPUtil.getParameter(request, "fmt_tztm_hrs", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setPodetb(JSPUtil.getParameter(request, "podetb", ""));
		setPoletb(JSPUtil.getParameter(request, "poletb", ""));
		setDircd(JSPUtil.getParameter(request, "dircd", ""));
		setPoletd(JSPUtil.getParameter(request, "poletd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRseq(JSPUtil.getParameter(request, "rseq", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setPodprot(JSPUtil.getParameter(request, "podprot", ""));
		setOcnLnkMnlFlg(JSPUtil.getParameter(request, "ocn_lnk_mnl_flg", ""));
		setPodetd(JSPUtil.getParameter(request, "podetd", ""));
		setLanecd(JSPUtil.getParameter(request, "lanecd", ""));
		setPolprot(JSPUtil.getParameter(request, "polprot", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "lnk_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "lnk_seq", ""));
		setChk(JSPUtil.getParameter(request, "chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaveOceanLinkVO[]
	 */
	public SaveOceanLinkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaveOceanLinkVO[]
	 */
	public SaveOceanLinkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaveOceanLinkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmtTztmHrs = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] podetb = (JSPUtil.getParameter(request, prefix	+ "podetb", length));
			String[] poletb = (JSPUtil.getParameter(request, prefix	+ "poletb", length));
			String[] dircd = (JSPUtil.getParameter(request, prefix	+ "dircd", length));
			String[] poletd = (JSPUtil.getParameter(request, prefix	+ "poletd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rseq = (JSPUtil.getParameter(request, prefix	+ "rseq", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] podprot = (JSPUtil.getParameter(request, prefix	+ "podprot", length));
			String[] ocnLnkMnlFlg = (JSPUtil.getParameter(request, prefix	+ "ocn_lnk_mnl_flg", length));
			String[] podetd = (JSPUtil.getParameter(request, prefix	+ "podetd", length));
			String[] lanecd = (JSPUtil.getParameter(request, prefix	+ "lanecd", length));
			String[] polprot = (JSPUtil.getParameter(request, prefix	+ "polprot", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lnkRmk = (JSPUtil.getParameter(request, prefix	+ "lnk_rmk", length));
			String[] lnkSeq = (JSPUtil.getParameter(request, prefix	+ "lnk_seq", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaveOceanLinkVO();
				if (fmtTztmHrs[i] != null)
					model.setFmtTztmHrs(fmtTztmHrs[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (podetb[i] != null)
					model.setPodetb(podetb[i]);
				if (poletb[i] != null)
					model.setPoletb(poletb[i]);
				if (dircd[i] != null)
					model.setDircd(dircd[i]);
				if (poletd[i] != null)
					model.setPoletd(poletd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rseq[i] != null)
					model.setRseq(rseq[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (podprot[i] != null)
					model.setPodprot(podprot[i]);
				if (ocnLnkMnlFlg[i] != null)
					model.setOcnLnkMnlFlg(ocnLnkMnlFlg[i]);
				if (podetd[i] != null)
					model.setPodetd(podetd[i]);
				if (lanecd[i] != null)
					model.setLanecd(lanecd[i]);
				if (polprot[i] != null)
					model.setPolprot(polprot[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lnkRmk[i] != null)
					model.setLnkRmk(lnkRmk[i]);
				if (lnkSeq[i] != null)
					model.setLnkSeq(lnkSeq[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaveOceanLinkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaveOceanLinkVO[]
	 */
	public SaveOceanLinkVO[] getSaveOceanLinkVOs(){
		SaveOceanLinkVO[] vos = (SaveOceanLinkVO[])models.toArray(new SaveOceanLinkVO[models.size()]);
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
		this.fmtTztmHrs = this.fmtTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetb = this.podetb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletb = this.poletb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dircd = this.dircd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletd = this.poletd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rseq = this.rseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podprot = this.podprot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnLnkMnlFlg = this.ocnLnkMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetd = this.podetd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lanecd = this.lanecd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polprot = this.polprot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkRmk = this.lnkRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkSeq = this.lnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
