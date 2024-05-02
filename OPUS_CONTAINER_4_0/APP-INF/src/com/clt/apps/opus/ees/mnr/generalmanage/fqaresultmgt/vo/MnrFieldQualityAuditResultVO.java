package com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 성덕경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MnrFieldQualityAuditResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrFieldQualityAuditResultVO> models = new ArrayList<MnrFieldQualityAuditResultVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pntNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fldAudRmk = null;
	/* Column Info */
	private String fldAudDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String evDesc = null;
	/* Column Info */
	private String pntCalcFlg = null;
	/* Column Info */
	private String maxPntNo = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String fldAudDtlSeq = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrFieldQualityAuditResultVO() {}
	/**
	 * Table Column name 으로 맴버변수 선언한다.
	 * @return HashMap
	 */
	public MnrFieldQualityAuditResultVO(String ibflag, String pagerows, String vndrSeq, String ofcCd, String fldAudDt, String evDesc, String maxPntNo, String pntNo, String pntCalcFlg, String fldAudRmk, String fileSeq, String creUsrId, String creDt, String updUsrId, String updDt, String ydCd, String fldAudDtlSeq) {
		this.updDt = updDt;
		this.pntNo = pntNo;
		this.creDt = creDt;
		this.fldAudRmk = fldAudRmk;
		this.fldAudDt = fldAudDt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.evDesc = evDesc;
		this.pntCalcFlg = pntCalcFlg;
		this.maxPntNo = maxPntNo;
		this.fileSeq = fileSeq;
		this.updUsrId = updUsrId;
		this.ydCd = ydCd;
		this.fldAudDtlSeq = fldAudDtlSeq;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pnt_no", getPntNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fld_aud_rmk", getFldAudRmk());
		this.hashColumns.put("fld_aud_dt", getFldAudDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ev_desc", getEvDesc());
		this.hashColumns.put("pnt_calc_flg", getPntCalcFlg());
		this.hashColumns.put("max_pnt_no", getMaxPntNo());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("fld_aud_dtl_seq", getFldAudDtlSeq());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pnt_no", "pntNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fld_aud_rmk", "fldAudRmk");
		this.hashFields.put("fld_aud_dt", "fldAudDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ev_desc", "evDesc");
		this.hashFields.put("pnt_calc_flg", "pntCalcFlg");
		this.hashFields.put("max_pnt_no", "maxPntNo");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("fld_aud_dtl_seq", "fldAudDtlSeq");
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
	 * @return pntNo
	 */
	public String getPntNo() {
		return this.pntNo;
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
	 * @return fldAudRmk
	 */
	public String getFldAudRmk() {
		return this.fldAudRmk;
	}
	
	/**
	 * Column Info
	 * @return fldAudDt
	 */
	public String getFldAudDt() {
		return this.fldAudDt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Status
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return evDesc
	 */
	public String getEvDesc() {
		return this.evDesc;
	}
	
	/**
	 * Column Info
	 * @return pntCalcFlg
	 */
	public String getPntCalcFlg() {
		return this.pntCalcFlg;
	}
	
	/**
	 * Column Info
	 * @return maxPntNo
	 */
	public String getMaxPntNo() {
		return this.maxPntNo;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	/**
	 * Column Info
	 * @return fldAudDtlSeq
	 */
	public String getFldAudDtlSeq() {
		return this.fldAudDtlSeq;
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
	 * @param pntNo
	 */
	public void setPntNo(String pntNo) {
		this.pntNo = pntNo;
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
	 * @param fldAudRmk
	 */
	public void setFldAudRmk(String fldAudRmk) {
		this.fldAudRmk = fldAudRmk;
	}
	
	/**
	 * Column Info
	 * @param fldAudDt
	 */
	public void setFldAudDt(String fldAudDt) {
		this.fldAudDt = fldAudDt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Status
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param evDesc
	 */
	public void setEvDesc(String evDesc) {
		this.evDesc = evDesc;
	}
	
	/**
	 * Column Info
	 * @param pntCalcFlg
	 */
	public void setPntCalcFlg(String pntCalcFlg) {
		this.pntCalcFlg = pntCalcFlg;
	}
	
	/**
	 * Column Info
	 * @param maxPntNo
	 */
	public void setMaxPntNo(String maxPntNo) {
		this.maxPntNo = maxPntNo;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	/**
	 * Column Info
	 * @param fldAudDtlSeq
	 */
	public void setFldAudDtlSeq(String fldAudDtlSeq) {
		this.fldAudDtlSeq = fldAudDtlSeq;
	}
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPntNo(JSPUtil.getParameter(request, "pnt_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFldAudRmk(JSPUtil.getParameter(request, "fld_aud_rmk", ""));
		setFldAudDt(JSPUtil.getParameter(request, "fld_aud_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setEvDesc(JSPUtil.getParameter(request, "ev_desc", ""));
		setPntCalcFlg(JSPUtil.getParameter(request, "pnt_calc_flg", ""));
		setMaxPntNo(JSPUtil.getParameter(request, "max_pnt_no", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setFldAudDtlSeq(JSPUtil.getParameter(request, "fld_aud_dtl_seq", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return MnrFldQltyAudRsltVO[]
	 */
	public MnrFieldQualityAuditResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrFldQltyAudRsltVO[]
	 */
	public MnrFieldQualityAuditResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrFieldQualityAuditResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] pntNo = (JSPUtil.getParameter(request, prefix	+ "pnt_no".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] fldAudRmk = (JSPUtil.getParameter(request, prefix	+ "fld_aud_rmk".trim(), length));
			String[] fldAudDt = (JSPUtil.getParameter(request, prefix	+ "fld_aud_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] evDesc = (JSPUtil.getParameter(request, prefix	+ "ev_desc".trim(), length));
			String[] pntCalcFlg = (JSPUtil.getParameter(request, prefix	+ "pnt_calc_flg".trim(), length));
			String[] maxPntNo = (JSPUtil.getParameter(request, prefix	+ "max_pnt_no".trim(), length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] fldAudDtlSeq = (JSPUtil.getParameter(request, prefix	+ "fld_aud_dtl_seq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrFieldQualityAuditResultVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pntNo[i] != null)
					model.setPntNo(pntNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fldAudRmk[i] != null)
					model.setFldAudRmk(fldAudRmk[i]);
				if (fldAudDt[i] != null)
					model.setFldAudDt(fldAudDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (evDesc[i] != null)
					model.setEvDesc(evDesc[i]);
				if (pntCalcFlg[i] != null)
					model.setPntCalcFlg(pntCalcFlg[i]);
				if (maxPntNo[i] != null)
					model.setMaxPntNo(maxPntNo[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (fldAudDtlSeq[i] != null)
					model.setFldAudDtlSeq(fldAudDtlSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrFieldQualityAuditResultVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return MnrFldQltyAudRsltVO[]
	 */
	public MnrFieldQualityAuditResultVO[] getMnrFieldQualityAuditResultVOs(){
		MnrFieldQualityAuditResultVO[] vos = (MnrFieldQualityAuditResultVO[])models.toArray(new MnrFieldQualityAuditResultVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntNo = this.pntNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldAudRmk = this.fldAudRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldAudDt = this.fldAudDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evDesc = this.evDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntCalcFlg = this.pntCalcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxPntNo = this.maxPntNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldAudDtlSeq = this.fldAudDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
