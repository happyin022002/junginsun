/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NvoccFileNoVO.java
*@FileTitle : NvoccFileNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.08.11 김영출 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NvoccFileNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NvoccFileNoVO> models = new ArrayList<NvoccFileNoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String idaIecNo = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntrMfNo = null;
	/* Column Info */
	private String orgCntrMfNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String hblMfTpCd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String hblSeq = null;
	/* Column Info */
	private String cndFlg = null;
	/* Column Info */
	private String cndCstmsFileCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NvoccFileNoVO() {}

	public NvoccFileNoVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String bkgStsCd, String bdrFlg, String caFlg, String cndFlg, String porCd, String polCd, String podCd, String delCd, String usaCstmsFileCd, String cndCstmsFileCd, String hblSeq, String hblNo, String cntrMfNo, String orgCntrMfNo, String idaIecNo, String hblMfTpCd) {
		this.porCd = porCd;
		this.idaIecNo = idaIecNo;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.delCd = delCd;
		this.cntrMfNo = cntrMfNo;
		this.orgCntrMfNo = orgCntrMfNo;
		this.blNo = blNo;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.pagerows = pagerows;
		this.blTpCd = blTpCd;
		this.hblMfTpCd = hblMfTpCd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.caFlg = caFlg;
		this.hblNo = hblNo;
		this.hblSeq = hblSeq;
		this.cndFlg = cndFlg;
		this.cndCstmsFileCd = cndCstmsFileCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ida_iec_no", getIdaIecNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_mf_no", getCntrMfNo());
		this.hashColumns.put("org_cntr_mf_no", getOrgCntrMfNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("hbl_mf_tp_cd", getHblMfTpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("hbl_seq", getHblSeq());
		this.hashColumns.put("cnd_flg", getCndFlg());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ida_iec_no", "idaIecNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_mf_no", "cntrMfNo");
		this.hashFields.put("org_cntr_mf_no", "orgCntrMfNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("hbl_mf_tp_cd", "hblMfTpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("hbl_seq", "hblSeq");
		this.hashFields.put("cnd_flg", "cndFlg");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return idaIecNo
	 */
	public String getIdaIecNo() {
		return this.idaIecNo;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMfNo
	 */
	public String getCntrMfNo() {
		return this.cntrMfNo;
	}
	
	/**
	 * Column Info
	 * @return orgCntrMfNo
	 */
	public String getOrgCntrMfNo() {
		return this.orgCntrMfNo;
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
	 * @return usaCstmsFileCd
	 */
	public String getUsaCstmsFileCd() {
		return this.usaCstmsFileCd;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return hblMfTpCd
	 */
	public String getHblMfTpCd() {
		return this.hblMfTpCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return hblSeq
	 */
	public String getHblSeq() {
		return this.hblSeq;
	}
	
	/**
	 * Column Info
	 * @return cndFlg
	 */
	public String getCndFlg() {
		return this.cndFlg;
	}
	
	/**
	 * Column Info
	 * @return cndCstmsFileCd
	 */
	public String getCndCstmsFileCd() {
		return this.cndCstmsFileCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param idaIecNo
	 */
	public void setIdaIecNo(String idaIecNo) {
		this.idaIecNo = idaIecNo;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMfNo
	 */
	public void setCntrMfNo(String cntrMfNo) {
		this.cntrMfNo = cntrMfNo;
	}
	
	/**
	 * Column Info
	 * @param orgCntrMfNo
	 */
	public void setOrgCntrMfNo(String orgCntrMfNo) {
		this.orgCntrMfNo = orgCntrMfNo;
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
	 * @param usaCstmsFileCd
	 */
	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param hblMfTpCd
	 */
	public void setHblMfTpCd(String hblMfTpCd) {
		this.hblMfTpCd = hblMfTpCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param hblSeq
	 */
	public void setHblSeq(String hblSeq) {
		this.hblSeq = hblSeq;
	}
	
	/**
	 * Column Info
	 * @param cndFlg
	 */
	public void setCndFlg(String cndFlg) {
		this.cndFlg = cndFlg;
	}
	
	/**
	 * Column Info
	 * @param cndCstmsFileCd
	 */
	public void setCndCstmsFileCd(String cndCstmsFileCd) {
		this.cndCstmsFileCd = cndCstmsFileCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setIdaIecNo(JSPUtil.getParameter(request, "ida_iec_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCntrMfNo(JSPUtil.getParameter(request, "cntr_mf_no", ""));
		setOrgCntrMfNo(JSPUtil.getParameter(request, "org_cntr_mf_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, "usa_cstms_file_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setHblMfTpCd(JSPUtil.getParameter(request, "hbl_mf_tp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCaFlg(JSPUtil.getParameter(request, "ca_flg", ""));
		setHblNo(JSPUtil.getParameter(request, "hbl_no", ""));
		setHblSeq(JSPUtil.getParameter(request, "hbl_seq", ""));
		setCndFlg(JSPUtil.getParameter(request, "cnd_flg", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, "cnd_cstms_file_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NvoccFileNoVO[]
	 */
	public NvoccFileNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NvoccFileNoVO[]
	 */
	public NvoccFileNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NvoccFileNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] idaIecNo = (JSPUtil.getParameter(request, prefix	+ "ida_iec_no", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrMfNo = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_no", length));
			String[] orgCntrMfNo = (JSPUtil.getParameter(request, prefix	+ "org_cntr_mf_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] hblMfTpCd = (JSPUtil.getParameter(request, prefix	+ "hbl_mf_tp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] hblSeq = (JSPUtil.getParameter(request, prefix	+ "hbl_seq", length));
			String[] cndFlg = (JSPUtil.getParameter(request, prefix	+ "cnd_flg", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NvoccFileNoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (idaIecNo[i] != null)
					model.setIdaIecNo(idaIecNo[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrMfNo[i] != null)
					model.setCntrMfNo(cntrMfNo[i]);
				if (orgCntrMfNo[i] != null)
					model.setOrgCntrMfNo(orgCntrMfNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (hblMfTpCd[i] != null)
					model.setHblMfTpCd(hblMfTpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (hblSeq[i] != null)
					model.setHblSeq(hblSeq[i]);
				if (cndFlg[i] != null)
					model.setCndFlg(cndFlg[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNvoccFileNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NvoccFileNoVO[]
	 */
	public NvoccFileNoVO[] getNvoccFileNoVOs(){
		NvoccFileNoVO[] vos = (NvoccFileNoVO[])models.toArray(new NvoccFileNoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIecNo = this.idaIecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNo = this.cntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntrMfNo = this.orgCntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblMfTpCd = this.hblMfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblSeq = this.hblSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndFlg = this.cndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
