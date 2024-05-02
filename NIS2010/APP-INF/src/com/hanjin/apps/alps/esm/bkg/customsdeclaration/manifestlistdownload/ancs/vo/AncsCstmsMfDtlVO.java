/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsMfDtlVO.java
*@FileTitle : AncsCstmsMfDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.02 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsMfDtlVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsMfDtlVO> models = new ArrayList<AncsCstmsMfDtlVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String blAck = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ntfyName = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cntrAck = null;
	/* Column Info */
	private String mfDesc = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String blLastEdi = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String cntrLastEdi = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsMfDtlVO() {}

	public AncsCstmsMfDtlVO(String ibflag, String pagerows, String kind, String blNo, String blAck, String blLastEdi, String cntrNo, String cntrAck, String cntrLastEdi, String cntrTpszCd, String porCd, String polCd, String podCd, String delCd, String preRlyPortCd, String pstRlyPortCd, String bdrFlg, String pckTpCd, String pckQty, String wgtUtCd, String cntrWgt, String mfDesc, String ntfyName) {
		this.porCd = porCd;
		this.cntrWgt = cntrWgt;
		this.preRlyPortCd = preRlyPortCd;
		this.blAck = blAck;
		this.bdrFlg = bdrFlg;
		this.delCd = delCd;
		this.blNo = blNo;
		this.kind = kind;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.ntfyName = ntfyName;
		this.cntrNo = cntrNo;
		this.wgtUtCd = wgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.pckQty = pckQty;
		this.cntrAck = cntrAck;
		this.mfDesc = mfDesc;
		this.pckTpCd = pckTpCd;
		this.blLastEdi = blLastEdi;
		this.pstRlyPortCd = pstRlyPortCd;
		this.cntrLastEdi = cntrLastEdi;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("bl_ack", getBlAck());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ntfy_name", getNtfyName());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cntr_ack", getCntrAck());
		this.hashColumns.put("mf_desc", getMfDesc());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("bl_last_edi", getBlLastEdi());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("cntr_last_edi", getCntrLastEdi());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("bl_ack", "blAck");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ntfy_name", "ntfyName");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_ack", "cntrAck");
		this.hashFields.put("mf_desc", "mfDesc");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("bl_last_edi", "blLastEdi");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("cntr_last_edi", "cntrLastEdi");
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
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return blAck
	 */
	public String getBlAck() {
		return this.blAck;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyName
	 */
	public String getNtfyName() {
		return this.ntfyName;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return cntrAck
	 */
	public String getCntrAck() {
		return this.cntrAck;
	}
	
	/**
	 * Column Info
	 * @return mfDesc
	 */
	public String getMfDesc() {
		return this.mfDesc;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return blLastEdi
	 */
	public String getBlLastEdi() {
		return this.blLastEdi;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return cntrLastEdi
	 */
	public String getCntrLastEdi() {
		return this.cntrLastEdi;
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
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param blAck
	 */
	public void setBlAck(String blAck) {
		this.blAck = blAck;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyName
	 */
	public void setNtfyName(String ntfyName) {
		this.ntfyName = ntfyName;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param cntrAck
	 */
	public void setCntrAck(String cntrAck) {
		this.cntrAck = cntrAck;
	}
	
	/**
	 * Column Info
	 * @param mfDesc
	 */
	public void setMfDesc(String mfDesc) {
		this.mfDesc = mfDesc;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param blLastEdi
	 */
	public void setBlLastEdi(String blLastEdi) {
		this.blLastEdi = blLastEdi;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param cntrLastEdi
	 */
	public void setCntrLastEdi(String cntrLastEdi) {
		this.cntrLastEdi = cntrLastEdi;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setBlAck(JSPUtil.getParameter(request, "bl_ack", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setKind(JSPUtil.getParameter(request, "kind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setNtfyName(JSPUtil.getParameter(request, "ntfy_name", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setCntrAck(JSPUtil.getParameter(request, "cntr_ack", ""));
		setMfDesc(JSPUtil.getParameter(request, "mf_desc", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setBlLastEdi(JSPUtil.getParameter(request, "bl_last_edi", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setCntrLastEdi(JSPUtil.getParameter(request, "cntr_last_edi", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsMfDtlVO[]
	 */
	public AncsCstmsMfDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsMfDtlVO[]
	 */
	public AncsCstmsMfDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsMfDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt".trim(), length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd".trim(), length));
			String[] blAck = (JSPUtil.getParameter(request, prefix	+ "bl_ack".trim(), length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] ntfyName = (JSPUtil.getParameter(request, prefix	+ "ntfy_name".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty".trim(), length));
			String[] cntrAck = (JSPUtil.getParameter(request, prefix	+ "cntr_ack".trim(), length));
			String[] mfDesc = (JSPUtil.getParameter(request, prefix	+ "mf_desc".trim(), length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd".trim(), length));
			String[] blLastEdi = (JSPUtil.getParameter(request, prefix	+ "bl_last_edi".trim(), length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd".trim(), length));
			String[] cntrLastEdi = (JSPUtil.getParameter(request, prefix	+ "cntr_last_edi".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsMfDtlVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (blAck[i] != null)
					model.setBlAck(blAck[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ntfyName[i] != null)
					model.setNtfyName(ntfyName[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cntrAck[i] != null)
					model.setCntrAck(cntrAck[i]);
				if (mfDesc[i] != null)
					model.setMfDesc(mfDesc[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (blLastEdi[i] != null)
					model.setBlLastEdi(blLastEdi[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (cntrLastEdi[i] != null)
					model.setCntrLastEdi(cntrLastEdi[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsMfDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsMfDtlVO[]
	 */
	public AncsCstmsMfDtlVO[] getAncsCstmsMfDtlVOs(){
		AncsCstmsMfDtlVO[] vos = (AncsCstmsMfDtlVO[])models.toArray(new AncsCstmsMfDtlVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAck = this.blAck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyName = this.ntfyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAck = this.cntrAck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfDesc = this.mfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLastEdi = this.blLastEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLastEdi = this.cntrLastEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
