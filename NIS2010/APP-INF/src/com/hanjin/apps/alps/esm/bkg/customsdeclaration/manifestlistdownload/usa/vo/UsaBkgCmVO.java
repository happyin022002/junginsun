/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaBkgCmVO.java
*@FileTitle : UsaBkgCmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.18 이수빈 
* 1.0 Creation
* 
* 2011.06.01 민정호 [CHM-201111028] AMS - Customs Data Download (D/L) 화면 validation추가
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 이수빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaBkgCmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBkgCmVO> models = new ArrayList<UsaBkgCmVO>();
	
	/* Column Info */
	private String cmdtGdsSeq = null;
	/* Column Info */
	private String hamoCmdtCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mkDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cgoDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String amsPckTpCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	private String cntrMfWgt = null;
	
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaBkgCmVO() {}

	public UsaBkgCmVO(String ibflag, String pagerows, String blNo, String cmdtCd, String cmdtDesc, String cntrNo, String cmdtGdsSeq, String mkDesc, String cgoDesc, String pckQty, String amsPckTpCd, String grsWgt, String wgtUtCd, String hamoCmdtCd, String creUsrId, String updUsrId, String cntrMfWgt) {
		this.cmdtGdsSeq = cmdtGdsSeq;
		this.hamoCmdtCd = hamoCmdtCd;
		this.blNo = blNo;
		this.mkDesc = mkDesc;
		this.pagerows = pagerows;
		this.cgoDesc = cgoDesc;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.amsPckTpCd = amsPckTpCd;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.grsWgt = grsWgt;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.cntrMfWgt = cntrMfWgt;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cmdt_gds_seq", getCmdtGdsSeq());
		this.hashColumns.put("hamo_cmdt_cd", getHamoCmdtCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cgo_desc", getCgoDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ams_pck_tp_cd", getAmsPckTpCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cmdt_gds_seq", "cmdtGdsSeq");
		this.hashFields.put("hamo_cmdt_cd", "hamoCmdtCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cgo_desc", "cgoDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ams_pck_tp_cd", "amsPckTpCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmdtGdsSeq
	 */
	public String getCmdtGdsSeq() {
		return this.cmdtGdsSeq;
	}
	
	/**
	 * Column Info
	 * @return hamoCmdtCd
	 */
	public String getHamoCmdtCd() {
		return this.hamoCmdtCd;
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
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
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
	 * @return cgoDesc
	 */
	public String getCgoDesc() {
		return this.cgoDesc;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return amsPckTpCd
	 */
	public String getAmsPckTpCd() {
		return this.amsPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	
	/**
	 * Column Info
	 * @param cmdtGdsSeq
	 */
	public void setCmdtGdsSeq(String cmdtGdsSeq) {
		this.cmdtGdsSeq = cmdtGdsSeq;
	}
	
	/**
	 * Column Info
	 * @param hamoCmdtCd
	 */
	public void setHamoCmdtCd(String hamoCmdtCd) {
		this.hamoCmdtCd = hamoCmdtCd;
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
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
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
	 * @param cgoDesc
	 */
	public void setCgoDesc(String cgoDesc) {
		this.cgoDesc = cgoDesc;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param amsPckTpCd
	 */
	public void setAmsPckTpCd(String amsPckTpCd) {
		this.amsPckTpCd = amsPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	

	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}	
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmdtGdsSeq(JSPUtil.getParameter(request, "cmdt_gds_seq", ""));
		setHamoCmdtCd(JSPUtil.getParameter(request, "hamo_cmdt_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCgoDesc(JSPUtil.getParameter(request, "cgo_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setAmsPckTpCd(JSPUtil.getParameter(request, "ams_pck_tp_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, "cntr_mf_wgt", ""));		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBkgCmVO[]
	 */
	public UsaBkgCmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBkgCmVO[]
	 */
	public UsaBkgCmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBkgCmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmdtGdsSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_gds_seq", length));
			String[] hamoCmdtCd = (JSPUtil.getParameter(request, prefix	+ "hamo_cmdt_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cgoDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] amsPckTpCd = (JSPUtil.getParameter(request, prefix	+ "ams_pck_tp_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));			
			
			
			for (int i = 0; i < length; i++) {
				model = new UsaBkgCmVO();
				if (cmdtGdsSeq[i] != null)
					model.setCmdtGdsSeq(cmdtGdsSeq[i]);
				if (hamoCmdtCd[i] != null)
					model.setHamoCmdtCd(hamoCmdtCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cgoDesc[i] != null)
					model.setCgoDesc(cgoDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (amsPckTpCd[i] != null)
					model.setAmsPckTpCd(amsPckTpCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBkgCmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBkgCmVO[]
	 */
	public UsaBkgCmVO[] getUsaBkgCmVOs(){
		UsaBkgCmVO[] vos = (UsaBkgCmVO[])models.toArray(new UsaBkgCmVO[models.size()]);
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
		this.cmdtGdsSeq = this.cmdtGdsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hamoCmdtCd = this.hamoCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc = this.cgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsPckTpCd = this.amsPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
