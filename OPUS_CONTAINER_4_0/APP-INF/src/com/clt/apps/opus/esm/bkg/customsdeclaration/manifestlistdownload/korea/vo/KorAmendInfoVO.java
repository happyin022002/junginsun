/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorAmendInfoVO.java
*@FileTitle : KorAmendInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.17 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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

public class KorAmendInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorAmendInfoVO> models = new ArrayList<KorAmendInfoVO>();

	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String transChk = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorAmendInfoVO() {}

	public KorAmendInfoVO(String ibflag, String pagerows, String smtAmdNo, String bkgNo, String transChk, String blNo, String portCd, String cstmsDeclTpCd, String vvd, String inType) {
		this.vvd = vvd;
		this.smtAmdNo = smtAmdNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.transChk = transChk;
		this.portCd = portCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.inType = inType;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("trans_chk", getTransChk());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("trans_chk", "transChk");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * @return the inType
	 */
	public String getInType() {
		return inType;
	}

	/**
	 * @param inType the inType to set
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @return smtAmdNo
	 */
	public String getSmtAmdNo() {
		return this.smtAmdNo;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param smtAmdNo
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSmtAmdNo(JSPUtil.getParameter(request, "smt_amd_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setTransChk(JSPUtil.getParameter(request, "trans_chk", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setInType(JSPUtil.getParameter(request, "in_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorAmendInfoVO[]
	 */
	public KorAmendInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorAmendInfoVO[]
	 */
	public KorAmendInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorAmendInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] transChk = (JSPUtil.getParameter(request, prefix	+ "trans_chk", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorAmendInfoVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (transChk[i] != null)
					model.setTransChk(transChk[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorAmendInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorAmendInfoVO[]
	 */
	public KorAmendInfoVO[] getKorAmendInfoVOs(){
		KorAmendInfoVO[] vos = (KorAmendInfoVO[])models.toArray(new KorAmendInfoVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transChk = this.transChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
