/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsCntrVO.java
*@FileTitle : AncsCstmsCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.05 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsCntrVO extends BlDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsCntrVO> models = new ArrayList<AncsCstmsCntrVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String orgRcvTermCd = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String anrMsgStsCd = null;
	/* Column Info */
	private String destDeTermCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String cntrLastEdi = null;
	
	private String cntrLastEdi2 = null;
	
	private String vvd = null;

	private String blAck = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsCntrVO() {}

	public AncsCstmsCntrVO(String ibflag, String pagerows, String cntrNo, String anrMsgStsCd, String orgRcvTermCd, 
			String destDeTermCd, String cntrLastEdi, String cntrTpszCd, String pckQty, String pckTpCd, String cntrWgt, 
			String wgtUtCd, String bkgNo, String bkgNoSplit, String vvd, String cntrLastEdi2, String blAck) {
		this.cntrWgt = cntrWgt;
		this.orgRcvTermCd = orgRcvTermCd;
		this.bkgNoSplit = bkgNoSplit;
		this.anrMsgStsCd = anrMsgStsCd;
		this.destDeTermCd = destDeTermCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.cntrLastEdi = cntrLastEdi;
		this.cntrLastEdi2 = cntrLastEdi2;
		this.vvd = vvd;
		this.blAck = blAck;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("org_rcv_term_cd", getOrgRcvTermCd());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("anr_msg_sts_cd", getAnrMsgStsCd());
		this.hashColumns.put("dest_de_term_cd", getDestDeTermCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cntr_last_edi", getCntrLastEdi());
		this.hashColumns.put("cntr_last_edi2", getCntrLastEdi2());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bl_ack", getBlAck());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("org_rcv_term_cd", "orgRcvTermCd");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("anr_msg_sts_cd", "anrMsgStsCd");
		this.hashFields.put("dest_de_term_cd", "destDeTermCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cntr_last_edi", "cntrLastEdi");
		this.hashFields.put("cntr_last_edi2", "cntrLastEdi2");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bl_ack", "blAck");
		return this.hashFields;
	}
	
	
	
	public String getCntrLastEdi2() {
		return cntrLastEdi2;
	}

	public void setCntrLastEdi2(String cntrLastEdi2) {
		this.cntrLastEdi2 = cntrLastEdi2;
	}

	public String getBlAck() {
		return blAck;
	}

	public void setBlAck(String blAck) {
		this.blAck = blAck;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @return orgRcvTermCd
	 */
	public String getOrgRcvTermCd() {
		return this.orgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return anrMsgStsCd
	 */
	public String getAnrMsgStsCd() {
		return this.anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @return destDeTermCd
	 */
	public String getDestDeTermCd() {
		return this.destDeTermCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
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
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param orgRcvTermCd
	 */
	public void setOrgRcvTermCd(String orgRcvTermCd) {
		this.orgRcvTermCd = orgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param anrMsgStsCd
	 */
	public void setAnrMsgStsCd(String anrMsgStsCd) {
		this.anrMsgStsCd = anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @param destDeTermCd
	 */
	public void setDestDeTermCd(String destDeTermCd) {
		this.destDeTermCd = destDeTermCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
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
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setOrgRcvTermCd(JSPUtil.getParameter(request, "org_rcv_term_cd", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setAnrMsgStsCd(JSPUtil.getParameter(request, "anr_msg_sts_cd", ""));
		setDestDeTermCd(JSPUtil.getParameter(request, "dest_de_term_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setCntrLastEdi(JSPUtil.getParameter(request, "cntr_last_edi", ""));
		setCntrLastEdi2(JSPUtil.getParameter(request, "cntr_last_edi2", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBlAck(JSPUtil.getParameter(request, "bl_ack", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsCntrVO[]
	 */
	public AncsCstmsCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsCntrVO[]
	 */
	public AncsCstmsCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt".trim(), length));
			String[] orgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "org_rcv_term_cd".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));
			String[] anrMsgStsCd = (JSPUtil.getParameter(request, prefix	+ "anr_msg_sts_cd".trim(), length));
			String[] destDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dest_de_term_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd".trim(), length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty".trim(), length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd".trim(), length));
			String[] cntrLastEdi = (JSPUtil.getParameter(request, prefix	+ "cntr_last_edi".trim(), length));
			String[] cntrLastEdi2 = (JSPUtil.getParameter(request, prefix	+ "cntr_last_edi2".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] blAck = (JSPUtil.getParameter(request, prefix	+ "bl_ack".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsCntrVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (orgRcvTermCd[i] != null)
					model.setOrgRcvTermCd(orgRcvTermCd[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (anrMsgStsCd[i] != null)
					model.setAnrMsgStsCd(anrMsgStsCd[i]);
				if (destDeTermCd[i] != null)
					model.setDestDeTermCd(destDeTermCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (cntrLastEdi[i] != null)
					model.setCntrLastEdi(cntrLastEdi[i]);
				if (cntrLastEdi2[i] != null)
					model.setCntrLastEdi2(cntrLastEdi2[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (blAck[i] != null)
					model.setBlAck(blAck[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsCntrVO[]
	 */
	public AncsCstmsCntrVO[] getAncsCstmsCntrVOs(){
		AncsCstmsCntrVO[] vos = (AncsCstmsCntrVO[])models.toArray(new AncsCstmsCntrVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvTermCd = this.orgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrMsgStsCd = this.anrMsgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destDeTermCd = this.destDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLastEdi = this.cntrLastEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLastEdi2 = this.cntrLastEdi2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAck = this.blAck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
