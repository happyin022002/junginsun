/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuditDataCheckListVO.java
*@FileTitle : AuditDataCheckListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.25 박명종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo;

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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AuditDataCheckListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuditDataCheckListVO> models = new ArrayList<AuditDataCheckListVO>();
	
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslDpth = null;
	/* Column Info */
	private String loaLen = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String dwtWgt = null;
	/* Column Info */
	private String crwKnt = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslWdt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String cntrPnmCapa = null;
	/* Column Info */
	private String smrDrftHgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AuditDataCheckListVO() {}

	public AuditDataCheckListVO(String ibflag, String pagerows, String vslCd, String vslEngNm, String grsRgstTongWgt, String netRgstTongWgt, String cntrVslClssCapa, String loaLen, String dwtWgt, String crwKnt, String vslRgstCntCd, String vslDpth, String cntrPnmCapa, String vslWdt, String smrDrftHgt) {
		this.netRgstTongWgt = netRgstTongWgt;
		this.vslCd = vslCd;
		this.vslDpth = vslDpth;
		this.loaLen = loaLen;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.dwtWgt = dwtWgt;
		this.crwKnt = crwKnt;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.pagerows = pagerows;
		this.vslWdt = vslWdt;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.vslRgstCntCd = vslRgstCntCd;
		this.cntrPnmCapa = cntrPnmCapa;
		this.smrDrftHgt = smrDrftHgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_dpth", getVslDpth());
		this.hashColumns.put("loa_len", getLoaLen());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("dwt_wgt", getDwtWgt());
		this.hashColumns.put("crw_knt", getCrwKnt());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_wdt", getVslWdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("cntr_pnm_capa", getCntrPnmCapa());
		this.hashColumns.put("smr_drft_hgt", getSmrDrftHgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_dpth", "vslDpth");
		this.hashFields.put("loa_len", "loaLen");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("dwt_wgt", "dwtWgt");
		this.hashFields.put("crw_knt", "crwKnt");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_wdt", "vslWdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("cntr_pnm_capa", "cntrPnmCapa");
		this.hashFields.put("smr_drft_hgt", "smrDrftHgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
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
	 * @return vslDpth
	 */
	public String getVslDpth() {
		return this.vslDpth;
	}
	
	/**
	 * Column Info
	 * @return loaLen
	 */
	public String getLoaLen() {
		return this.loaLen;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return dwtWgt
	 */
	public String getDwtWgt() {
		return this.dwtWgt;
	}
	
	/**
	 * Column Info
	 * @return crwKnt
	 */
	public String getCrwKnt() {
		return this.crwKnt;
	}
	
	/**
	 * Column Info
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
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
	 * @return vslWdt
	 */
	public String getVslWdt() {
		return this.vslWdt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPnmCapa
	 */
	public String getCntrPnmCapa() {
		return this.cntrPnmCapa;
	}
	
	/**
	 * Column Info
	 * @return smrDrftHgt
	 */
	public String getSmrDrftHgt() {
		return this.smrDrftHgt;
	}
	

	/**
	 * Column Info
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
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
	 * @param vslDpth
	 */
	public void setVslDpth(String vslDpth) {
		this.vslDpth = vslDpth;
	}
	
	/**
	 * Column Info
	 * @param loaLen
	 */
	public void setLoaLen(String loaLen) {
		this.loaLen = loaLen;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param dwtWgt
	 */
	public void setDwtWgt(String dwtWgt) {
		this.dwtWgt = dwtWgt;
	}
	
	/**
	 * Column Info
	 * @param crwKnt
	 */
	public void setCrwKnt(String crwKnt) {
		this.crwKnt = crwKnt;
	}
	
	/**
	 * Column Info
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
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
	 * @param vslWdt
	 */
	public void setVslWdt(String vslWdt) {
		this.vslWdt = vslWdt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPnmCapa
	 */
	public void setCntrPnmCapa(String cntrPnmCapa) {
		this.cntrPnmCapa = cntrPnmCapa;
	}
	
	/**
	 * Column Info
	 * @param smrDrftHgt
	 */
	public void setSmrDrftHgt(String smrDrftHgt) {
		this.smrDrftHgt = smrDrftHgt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNetRgstTongWgt(JSPUtil.getParameter(request, "net_rgst_tong_wgt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVslDpth(JSPUtil.getParameter(request, "vsl_dpth", ""));
		setLoaLen(JSPUtil.getParameter(request, "loa_len", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, "grs_rgst_tong_wgt", ""));
		setDwtWgt(JSPUtil.getParameter(request, "dwt_wgt", ""));
		setCrwKnt(JSPUtil.getParameter(request, "crw_knt", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, "cntr_vsl_clss_capa", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslWdt(JSPUtil.getParameter(request, "vsl_wdt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setCntrPnmCapa(JSPUtil.getParameter(request, "cntr_pnm_capa", ""));
		setSmrDrftHgt(JSPUtil.getParameter(request, "smr_drft_hgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuditDataCheckListVO[]
	 */
	public AuditDataCheckListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuditDataCheckListVO[]
	 */
	public AuditDataCheckListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuditDataCheckListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] vslDpth = (JSPUtil.getParameter(request, prefix	+ "vsl_dpth".trim(), length));
			String[] loaLen = (JSPUtil.getParameter(request, prefix	+ "loa_len".trim(), length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt".trim(), length));
			String[] dwtWgt = (JSPUtil.getParameter(request, prefix	+ "dwt_wgt".trim(), length));
			String[] crwKnt = (JSPUtil.getParameter(request, prefix	+ "crw_knt".trim(), length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] vslWdt = (JSPUtil.getParameter(request, prefix	+ "vsl_wdt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd".trim(), length));
			String[] cntrPnmCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_pnm_capa".trim(), length));
			String[] smrDrftHgt = (JSPUtil.getParameter(request, prefix	+ "smr_drft_hgt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AuditDataCheckListVO();
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslDpth[i] != null)
					model.setVslDpth(vslDpth[i]);
				if (loaLen[i] != null)
					model.setLoaLen(loaLen[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (dwtWgt[i] != null)
					model.setDwtWgt(dwtWgt[i]);
				if (crwKnt[i] != null)
					model.setCrwKnt(crwKnt[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslWdt[i] != null)
					model.setVslWdt(vslWdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (cntrPnmCapa[i] != null)
					model.setCntrPnmCapa(cntrPnmCapa[i]);
				if (smrDrftHgt[i] != null)
					model.setSmrDrftHgt(smrDrftHgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuditDataCheckListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuditDataCheckListVO[]
	 */
	public AuditDataCheckListVO[] getAuditDataCheckListVOs(){
		AuditDataCheckListVO[] vos = (AuditDataCheckListVO[])models.toArray(new AuditDataCheckListVO[models.size()]);
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
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDpth = this.vslDpth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loaLen = this.loaLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwtWgt = this.dwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crwKnt = this.crwKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslWdt = this.vslWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPnmCapa = this.cntrPnmCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smrDrftHgt = this.smrDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
