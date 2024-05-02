/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorIbManifestVO.java
*@FileTitle : KorIbManifestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.01 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorIbManifestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorIbManifestVO> models = new ArrayList<KorIbManifestVO>();

	/* Column Info */
	private String cstmsDchgLocWhCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String transChk = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bdTpCd = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String cstmsClrWhCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorIbManifestVO() {}

	public KorIbManifestVO(String ibflag, String pagerows, String blNo, String cstmsClrTpCd, String cstmsDchgLocWhCd, String cstmsClrWhCd, String bdTpCd, String transChk, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String mrnNo) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.transChk = transChk;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bdTpCd = bdTpCd;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.portCd = portCd;
		this.cstmsClrWhCd = cstmsClrWhCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_dchg_loc_wh_cd", getCstmsDchgLocWhCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("trans_chk", getTransChk());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bd_tp_cd", getBdTpCd());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("cstms_clr_wh_cd", getCstmsClrWhCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_dchg_loc_wh_cd", "cstmsDchgLocWhCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("trans_chk", "transChk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bd_tp_cd", "bdTpCd");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("port_cd", "portCd");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}

	/**
	 * Column Info
	 * @return transChk
	 */
	public String getTransChk() {
		return this.transChk;
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
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}

	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bdTpCd
	 */
	public String getBdTpCd() {
		return this.bdTpCd;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * Column Info
	 * @param transChk
	 */
	public void setTransChk(String transChk) {
		this.transChk = transChk;
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
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bdTpCd
	 */
	public void setBdTpCd(String bdTpCd) {
		this.bdTpCd = bdTpCd;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setTransChk(JSPUtil.getParameter(request, "trans_chk", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBdTpCd(JSPUtil.getParameter(request, "bd_tp_cd", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, "cstms_clr_tp_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setCstmsClrWhCd(JSPUtil.getParameter(request, "cstms_clr_wh_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorIbManifestVO[]
	 */
	public KorIbManifestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorIbManifestVO[]
	 */
	public KorIbManifestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorIbManifestVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cstmsDchgLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_loc_wh_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] transChk = (JSPUtil.getParameter(request, prefix	+ "trans_chk", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bdTpCd = (JSPUtil.getParameter(request, prefix	+ "bd_tp_cd", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] cstmsClrWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_wh_cd", length));

			for (int i = 0; i < length; i++) {
				model = new KorIbManifestVO();
				if (cstmsDchgLocWhCd[i] != null)
					model.setCstmsDchgLocWhCd(cstmsDchgLocWhCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (transChk[i] != null)
					model.setTransChk(transChk[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bdTpCd[i] != null)
					model.setBdTpCd(bdTpCd[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (cstmsClrWhCd[i] != null)
					model.setCstmsClrWhCd(cstmsClrWhCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorIbManifestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorIbManifestVO[]
	 */
	public KorIbManifestVO[] getKorIbManifestVOs(){
		KorIbManifestVO[] vos = (KorIbManifestVO[])models.toArray(new KorIbManifestVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transChk = this.transChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdTpCd = this.bdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrWhCd = this.cstmsClrWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
