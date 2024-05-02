/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurTroDtlVO.java
*@FileTitle : EurTroDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.07.20 이남경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurTroDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurTroDtlVO> models = new ArrayList<EurTroDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String troSubSeq = null;
	/* Column Info */
	private String lodRefNo = null;
	/* Column Info */
	private String dorPstNo = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String dorLocCd = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String arrDtHhmi = null;
	/* Column Info */
	private String cntcEml = null;
	/* Column Info */
	private String dorAddrTpCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cntcPhnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dorAddr1 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dorAddr3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dorAddr2 = null;
	/* Column Info */
	private String dorAddr4 = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurTroDtlVO() {}

	public EurTroDtlVO(String ibflag, String pagerows, String bkgNo, String ioBndCd, String troSeq, String troSubSeq, String dorAddrTpCd, String dorLocCd, String znCd, String lodRefNo, String dorPstNo, String dorAddr1, String dorAddr2, String dorAddr3, String dorAddr4, String arrDt, String arrDtHhmi, String cntcPsonNm, String cntcPhnNo, String cntcEml, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.troSubSeq = troSubSeq;
		this.lodRefNo = lodRefNo;
		this.dorPstNo = dorPstNo;
		this.troSeq = troSeq;
		this.arrDt = arrDt;
		this.dorLocCd = dorLocCd;
		this.znCd = znCd;
		this.creDt = creDt;
		this.arrDtHhmi = arrDtHhmi;
		this.cntcEml = cntcEml;
		this.dorAddrTpCd = dorAddrTpCd;
		this.ioBndCd = ioBndCd;
		this.cntcPhnNo = cntcPhnNo;
		this.pagerows = pagerows;
		this.dorAddr1 = dorAddr1;
		this.creUsrId = creUsrId;
		this.dorAddr3 = dorAddr3;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.dorAddr2 = dorAddr2;
		this.dorAddr4 = dorAddr4;
		this.cntcPsonNm = cntcPsonNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());
		this.hashColumns.put("lod_ref_no", getLodRefNo());
		this.hashColumns.put("dor_pst_no", getDorPstNo());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("dor_loc_cd", getDorLocCd());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("arr_dt_hhmi", getArrDtHhmi());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("dor_addr_tp_cd", getDorAddrTpCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cntc_phn_no", getCntcPhnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dor_addr_1", getDorAddr1());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dor_addr_3", getDorAddr3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dor_addr_2", getDorAddr2());
		this.hashColumns.put("dor_addr_4", getDorAddr4());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("lod_ref_no", "lodRefNo");
		this.hashFields.put("dor_pst_no", "dorPstNo");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("dor_loc_cd", "dorLocCd");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("arr_dt_hhmi", "arrDtHhmi");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("dor_addr_tp_cd", "dorAddrTpCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cntc_phn_no", "cntcPhnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dor_addr_1", "dorAddr1");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dor_addr_3", "dorAddr3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dor_addr_2", "dorAddr2");
		this.hashFields.put("dor_addr_4", "dorAddr4");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
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
	 * @return troSubSeq
	 */
	public String getTroSubSeq() {
		return this.troSubSeq;
	}
	
	/**
	 * Column Info
	 * @return lodRefNo
	 */
	public String getLodRefNo() {
		return this.lodRefNo;
	}
	
	/**
	 * Column Info
	 * @return dorPstNo
	 */
	public String getDorPstNo() {
		return this.dorPstNo;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return dorLocCd
	 */
	public String getDorLocCd() {
		return this.dorLocCd;
	}
	
	/**
	 * Column Info
	 * @return znCd
	 */
	public String getZnCd() {
		return this.znCd;
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
	 * @return arrDtHhmi
	 */
	public String getArrDtHhmi() {
		return this.arrDtHhmi;
	}
	
	/**
	 * Column Info
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
	}
	
	/**
	 * Column Info
	 * @return dorAddrTpCd
	 */
	public String getDorAddrTpCd() {
		return this.dorAddrTpCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return cntcPhnNo
	 */
	public String getCntcPhnNo() {
		return this.cntcPhnNo;
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
	 * @return dorAddr1
	 */
	public String getDorAddr1() {
		return this.dorAddr1;
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
	 * @return dorAddr3
	 */
	public String getDorAddr3() {
		return this.dorAddr3;
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
	 * @return dorAddr2
	 */
	public String getDorAddr2() {
		return this.dorAddr2;
	}
	
	/**
	 * Column Info
	 * @return dorAddr4
	 */
	public String getDorAddr4() {
		return this.dorAddr4;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
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
	 * @param troSubSeq
	 */
	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
	}
	
	/**
	 * Column Info
	 * @param lodRefNo
	 */
	public void setLodRefNo(String lodRefNo) {
		this.lodRefNo = lodRefNo;
	}
	
	/**
	 * Column Info
	 * @param dorPstNo
	 */
	public void setDorPstNo(String dorPstNo) {
		this.dorPstNo = dorPstNo;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param dorLocCd
	 */
	public void setDorLocCd(String dorLocCd) {
		this.dorLocCd = dorLocCd;
	}
	
	/**
	 * Column Info
	 * @param znCd
	 */
	public void setZnCd(String znCd) {
		this.znCd = znCd;
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
	 * @param arrDtHhmi
	 */
	public void setArrDtHhmi(String arrDtHhmi) {
		this.arrDtHhmi = arrDtHhmi;
	}
	
	/**
	 * Column Info
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
	}
	
	/**
	 * Column Info
	 * @param dorAddrTpCd
	 */
	public void setDorAddrTpCd(String dorAddrTpCd) {
		this.dorAddrTpCd = dorAddrTpCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param cntcPhnNo
	 */
	public void setCntcPhnNo(String cntcPhnNo) {
		this.cntcPhnNo = cntcPhnNo;
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
	 * @param dorAddr1
	 */
	public void setDorAddr1(String dorAddr1) {
		this.dorAddr1 = dorAddr1;
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
	 * @param dorAddr3
	 */
	public void setDorAddr3(String dorAddr3) {
		this.dorAddr3 = dorAddr3;
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
	 * @param dorAddr2
	 */
	public void setDorAddr2(String dorAddr2) {
		this.dorAddr2 = dorAddr2;
	}
	
	/**
	 * Column Info
	 * @param dorAddr4
	 */
	public void setDorAddr4(String dorAddr4) {
		this.dorAddr4 = dorAddr4;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
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
		setTroSubSeq(JSPUtil.getParameter(request, "tro_sub_seq", ""));
		setLodRefNo(JSPUtil.getParameter(request, "lod_ref_no", ""));
		setDorPstNo(JSPUtil.getParameter(request, "dor_pst_no", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setArrDt(JSPUtil.getParameter(request, "arr_dt", ""));
		setDorLocCd(JSPUtil.getParameter(request, "dor_loc_cd", ""));
		setZnCd(JSPUtil.getParameter(request, "zn_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setArrDtHhmi(JSPUtil.getParameter(request, "arr_dt_hhmi", ""));
		setCntcEml(JSPUtil.getParameter(request, "cntc_eml", ""));
		setDorAddrTpCd(JSPUtil.getParameter(request, "dor_addr_tp_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCntcPhnNo(JSPUtil.getParameter(request, "cntc_phn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDorAddr1(JSPUtil.getParameter(request, "dor_addr_1", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDorAddr3(JSPUtil.getParameter(request, "dor_addr_3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDorAddr2(JSPUtil.getParameter(request, "dor_addr_2", ""));
		setDorAddr4(JSPUtil.getParameter(request, "dor_addr_4", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurTroDtlVO[]
	 */
	public EurTroDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurTroDtlVO[]
	 */
	public EurTroDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurTroDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix	+ "tro_sub_seq", length));
			String[] lodRefNo = (JSPUtil.getParameter(request, prefix	+ "lod_ref_no", length));
			String[] dorPstNo = (JSPUtil.getParameter(request, prefix	+ "dor_pst_no", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] dorLocCd = (JSPUtil.getParameter(request, prefix	+ "dor_loc_cd", length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] arrDtHhmi = (JSPUtil.getParameter(request, prefix	+ "arr_dt_hhmi", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] dorAddrTpCd = (JSPUtil.getParameter(request, prefix	+ "dor_addr_tp_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_phn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dorAddr1 = (JSPUtil.getParameter(request, prefix	+ "dor_addr_1", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dorAddr3 = (JSPUtil.getParameter(request, prefix	+ "dor_addr_3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dorAddr2 = (JSPUtil.getParameter(request, prefix	+ "dor_addr_2", length));
			String[] dorAddr4 = (JSPUtil.getParameter(request, prefix	+ "dor_addr_4", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurTroDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);
				if (lodRefNo[i] != null)
					model.setLodRefNo(lodRefNo[i]);
				if (dorPstNo[i] != null)
					model.setDorPstNo(dorPstNo[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (dorLocCd[i] != null)
					model.setDorLocCd(dorLocCd[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (arrDtHhmi[i] != null)
					model.setArrDtHhmi(arrDtHhmi[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (dorAddrTpCd[i] != null)
					model.setDorAddrTpCd(dorAddrTpCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cntcPhnNo[i] != null)
					model.setCntcPhnNo(cntcPhnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dorAddr1[i] != null)
					model.setDorAddr1(dorAddr1[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dorAddr3[i] != null)
					model.setDorAddr3(dorAddr3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dorAddr2[i] != null)
					model.setDorAddr2(dorAddr2[i]);
				if (dorAddr4[i] != null)
					model.setDorAddr4(dorAddr4[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurTroDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurTroDtlVO[]
	 */
	public EurTroDtlVO[] getEurTroDtlVOs(){
		EurTroDtlVO[] vos = (EurTroDtlVO[])models.toArray(new EurTroDtlVO[models.size()]);
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
		this.troSubSeq = this.troSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodRefNo = this.lodRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstNo = this.dorPstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocCd = this.dorLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDtHhmi = this.arrDtHhmi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorAddrTpCd = this.dorAddrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPhnNo = this.cntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorAddr1 = this.dorAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorAddr3 = this.dorAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorAddr2 = this.dorAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorAddr4 = this.dorAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
