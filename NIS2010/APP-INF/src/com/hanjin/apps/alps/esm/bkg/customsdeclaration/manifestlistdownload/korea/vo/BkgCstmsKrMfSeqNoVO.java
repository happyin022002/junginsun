/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsKrMfSeqNoVO.java
*@FileTitle : BkgCstmsKrMfSeqNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.30 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsKrMfSeqNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsKrMfSeqNoVO> models = new ArrayList<BkgCstmsKrMfSeqNoVO>();
	
	/* Column Info */
	private String cstmsDchgLocWhCd = null;
	/* Column Info */
	private String cstmsCrrInLocWhCd = null;
	/* Column Info */
	private String updateChk = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String cstmsClrLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bdTpCd = null;
	/* Column Info */
	private String msnCfmFlg = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String mfSeqNo = null;
	/* Column Info */
	private String cstmsClrWhCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsKrMfSeqNoVO() {}

	public BkgCstmsKrMfSeqNoVO(String ibflag, String pagerows, String mrnNo, String vvd, String bkgNo, String cstmsClrTpCd, String cstmsClrWhCd, String cstmsDchgLocWhCd, String cstmsCrrInLocWhCd, String bdTpCd, String cstmsClrLocCd, String msnCfmFlg, String updateChk, String blTpCd, String mfSeqNo) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
		this.cstmsCrrInLocWhCd = cstmsCrrInLocWhCd;
		this.updateChk = updateChk;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.blTpCd = blTpCd;
		this.vvd = vvd;
		this.cstmsClrLocCd = cstmsClrLocCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.bdTpCd = bdTpCd;
		this.msnCfmFlg = msnCfmFlg;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.mfSeqNo = mfSeqNo;
		this.cstmsClrWhCd = cstmsClrWhCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_dchg_loc_wh_cd", getCstmsDchgLocWhCd());
		this.hashColumns.put("cstms_crr_in_loc_wh_cd", getCstmsCrrInLocWhCd());
		this.hashColumns.put("update_chk", getUpdateChk());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cstms_clr_loc_cd", getCstmsClrLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bd_tp_cd", getBdTpCd());
		this.hashColumns.put("msn_cfm_flg", getMsnCfmFlg());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("mf_seq_no", getMfSeqNo());
		this.hashColumns.put("cstms_clr_wh_cd", getCstmsClrWhCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_dchg_loc_wh_cd", "cstmsDchgLocWhCd");
		this.hashFields.put("cstms_crr_in_loc_wh_cd", "cstmsCrrInLocWhCd");
		this.hashFields.put("update_chk", "updateChk");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cstms_clr_loc_cd", "cstmsClrLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bd_tp_cd", "bdTpCd");
		this.hashFields.put("msn_cfm_flg", "msnCfmFlg");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("mf_seq_no", "mfSeqNo");
		this.hashFields.put("cstms_clr_wh_cd", "cstmsClrWhCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsDchgLocWhCd
	 */
	public String getCstmsDchgLocWhCd() {
		return this.cstmsDchgLocWhCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsCrrInLocWhCd
	 */
	public String getCstmsCrrInLocWhCd() {
		return this.cstmsCrrInLocWhCd;
	}
	
	/**
	 * Column Info
	 * @return updateChk
	 */
	public String getUpdateChk() {
		return this.updateChk;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrLocCd
	 */
	public String getCstmsClrLocCd() {
		return this.cstmsClrLocCd;
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
	 * @return bdTpCd
	 */
	public String getBdTpCd() {
		return this.bdTpCd;
	}
	
	/**
	 * Column Info
	 * @return msnCfmFlg
	 */
	public String getMsnCfmFlg() {
		return this.msnCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @return mfSeqNo
	 */
	public String getMfSeqNo() {
		return this.mfSeqNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrWhCd
	 */
	public String getCstmsClrWhCd() {
		return this.cstmsClrWhCd;
	}
	

	/**
	 * Column Info
	 * @param cstmsDchgLocWhCd
	 */
	public void setCstmsDchgLocWhCd(String cstmsDchgLocWhCd) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsCrrInLocWhCd
	 */
	public void setCstmsCrrInLocWhCd(String cstmsCrrInLocWhCd) {
		this.cstmsCrrInLocWhCd = cstmsCrrInLocWhCd;
	}
	
	/**
	 * Column Info
	 * @param updateChk
	 */
	public void setUpdateChk(String updateChk) {
		this.updateChk = updateChk;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrLocCd
	 */
	public void setCstmsClrLocCd(String cstmsClrLocCd) {
		this.cstmsClrLocCd = cstmsClrLocCd;
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
	 * @param bdTpCd
	 */
	public void setBdTpCd(String bdTpCd) {
		this.bdTpCd = bdTpCd;
	}
	
	/**
	 * Column Info
	 * @param msnCfmFlg
	 */
	public void setMsnCfmFlg(String msnCfmFlg) {
		this.msnCfmFlg = msnCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @param mfSeqNo
	 */
	public void setMfSeqNo(String mfSeqNo) {
		this.mfSeqNo = mfSeqNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrWhCd
	 */
	public void setCstmsClrWhCd(String cstmsClrWhCd) {
		this.cstmsClrWhCd = cstmsClrWhCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCstmsDchgLocWhCd(JSPUtil.getParameter(request, "cstms_dchg_loc_wh_cd", ""));
		setCstmsCrrInLocWhCd(JSPUtil.getParameter(request, "cstms_crr_in_loc_wh_cd", ""));
		setUpdateChk(JSPUtil.getParameter(request, "update_chk", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCstmsClrLocCd(JSPUtil.getParameter(request, "cstms_clr_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBdTpCd(JSPUtil.getParameter(request, "bd_tp_cd", ""));
		setMsnCfmFlg(JSPUtil.getParameter(request, "msn_cfm_flg", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, "cstms_clr_tp_cd", ""));
		setMfSeqNo(JSPUtil.getParameter(request, "mf_seq_no", ""));
		setCstmsClrWhCd(JSPUtil.getParameter(request, "cstms_clr_wh_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsKrMfSeqNoVO[]
	 */
	public BkgCstmsKrMfSeqNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsKrMfSeqNoVO[]
	 */
	public BkgCstmsKrMfSeqNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsKrMfSeqNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsDchgLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_loc_wh_cd", length));
			String[] cstmsCrrInLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_crr_in_loc_wh_cd", length));
			String[] updateChk = (JSPUtil.getParameter(request, prefix	+ "update_chk", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] cstmsClrLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bdTpCd = (JSPUtil.getParameter(request, prefix	+ "bd_tp_cd", length));
			String[] msnCfmFlg = (JSPUtil.getParameter(request, prefix	+ "msn_cfm_flg", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] mfSeqNo = (JSPUtil.getParameter(request, prefix	+ "mf_seq_no", length));
			String[] cstmsClrWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_wh_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsKrMfSeqNoVO();
				if (cstmsDchgLocWhCd[i] != null)
					model.setCstmsDchgLocWhCd(cstmsDchgLocWhCd[i]);
				if (cstmsCrrInLocWhCd[i] != null)
					model.setCstmsCrrInLocWhCd(cstmsCrrInLocWhCd[i]);
				if (updateChk[i] != null)
					model.setUpdateChk(updateChk[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (cstmsClrLocCd[i] != null)
					model.setCstmsClrLocCd(cstmsClrLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bdTpCd[i] != null)
					model.setBdTpCd(bdTpCd[i]);
				if (msnCfmFlg[i] != null)
					model.setMsnCfmFlg(msnCfmFlg[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (mfSeqNo[i] != null)
					model.setMfSeqNo(mfSeqNo[i]);
				if (cstmsClrWhCd[i] != null)
					model.setCstmsClrWhCd(cstmsClrWhCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsKrMfSeqNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsKrMfSeqNoVO[]
	 */
	public BkgCstmsKrMfSeqNoVO[] getBkgCstmsKrMfSeqNoVOs(){
		BkgCstmsKrMfSeqNoVO[] vos = (BkgCstmsKrMfSeqNoVO[])models.toArray(new BkgCstmsKrMfSeqNoVO[models.size()]);
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
		this.cstmsDchgLocWhCd = this.cstmsDchgLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCrrInLocWhCd = this.cstmsCrrInLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateChk = this.updateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrLocCd = this.cstmsClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdTpCd = this.bdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnCfmFlg = this.msnCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSeqNo = this.mfSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrWhCd = this.cstmsClrWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
