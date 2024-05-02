/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EdoSearchVO.java
*@FileTitle : EdoSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdoSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdoSearchVO> models = new ArrayList<EdoSearchVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String edoAckCd = null;
	/* Column Info */
	private String edoRctLocCd = null;
	/* Column Info */
	private String edoTpCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String edoRqstDtE = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String edoRqstDtS = null;
	/* Column Info */
	private String cnNm = null;
	/* Column Info */
	private String doNoSplit = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdoSearchVO() {}

	public EdoSearchVO(String ibflag, String pagerows, String edoRqstDtS, String edoRqstDtE, String hndlOfcCd, String edoRctLocCd, String podCd, String edoTpCd, String blNo, String vslNm, String deltFlg, String edoAckCd, String cnNm, String doNo, String doNoSplit) {
		this.deltFlg = deltFlg;
		this.edoAckCd = edoAckCd;
		this.edoRctLocCd = edoRctLocCd;
		this.edoTpCd = edoTpCd;
		this.vslNm = vslNm;
		this.edoRqstDtE = edoRqstDtE;
		this.blNo = blNo;
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
		this.doNo = doNo;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.edoRqstDtS = edoRqstDtS;
		this.cnNm = cnNm;
		this.doNoSplit = doNoSplit;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("edo_ack_cd", getEdoAckCd());
		this.hashColumns.put("edo_rct_loc_cd", getEdoRctLocCd());
		this.hashColumns.put("edo_tp_cd", getEdoTpCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("edo_rqst_dt_e", getEdoRqstDtE());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edo_rqst_dt_s", getEdoRqstDtS());
		this.hashColumns.put("cn_nm", getCnNm());
		this.hashColumns.put("do_no_split", getDoNoSplit());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("edo_ack_cd", "edoAckCd");
		this.hashFields.put("edo_rct_loc_cd", "edoRctLocCd");
		this.hashFields.put("edo_tp_cd", "edoTpCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("edo_rqst_dt_e", "edoRqstDtE");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edo_rqst_dt_s", "edoRqstDtS");
		this.hashFields.put("cn_nm", "cnNm");
		this.hashFields.put("do_no_split", "doNoSplit");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return edoAckCd
	 */
	public String getEdoAckCd() {
		return this.edoAckCd;
	}
	
	/**
	 * Column Info
	 * @return edoRctLocCd
	 */
	public String getEdoRctLocCd() {
		return this.edoRctLocCd;
	}
	
	/**
	 * Column Info
	 * @return edoTpCd
	 */
	public String getEdoTpCd() {
		return this.edoTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return edoRqstDtE
	 */
	public String getEdoRqstDtE() {
		return this.edoRqstDtE;
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
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
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
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
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
	 * @return edoRqstDtS
	 */
	public String getEdoRqstDtS() {
		return this.edoRqstDtS;
	}
	
	/**
	 * Column Info
	 * @return cnNm
	 */
	public String getCnNm() {
		return this.cnNm;
	}
	
	/**
	 * Column Info
	 * @return doNoSplit
	 */
	public String getDoNoSplit() {
		return this.doNoSplit;
	}

	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param edoAckCd
	 */
	public void setEdoAckCd(String edoAckCd) {
		this.edoAckCd = edoAckCd;
	}
	
	/**
	 * Column Info
	 * @param edoRctLocCd
	 */
	public void setEdoRctLocCd(String edoRctLocCd) {
		this.edoRctLocCd = edoRctLocCd;
	}
	
	/**
	 * Column Info
	 * @param edoTpCd
	 */
	public void setEdoTpCd(String edoTpCd) {
		this.edoTpCd = edoTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param edoRqstDtE
	 */
	public void setEdoRqstDtE(String edoRqstDtE) {
		this.edoRqstDtE = edoRqstDtE;
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
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
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
	 * @param edoRqstDtS
	 */
	public void setEdoRqstDtS(String edoRqstDtS) {
		this.edoRqstDtS = edoRqstDtS;
	}
	
	/**
	 * Column Info
	 * @param cnNm
	 */
	public void setCnNm(String cnNm) {
		this.cnNm = cnNm;
	}

	/**
	 * Column Info
	 * @param doNoSplit
	 */
	public void setDoNoSplit(String doNoSplit) {
		this.doNoSplit = doNoSplit;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setEdoAckCd(JSPUtil.getParameter(request, "edo_ack_cd", ""));
		setEdoRctLocCd(JSPUtil.getParameter(request, "edo_rct_loc_cd", ""));
		setEdoTpCd(JSPUtil.getParameter(request, "edo_tp_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEdoRqstDtE(JSPUtil.getParameter(request, "edo_rqst_dt_e", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdoRqstDtS(JSPUtil.getParameter(request, "edo_rqst_dt_s", ""));
		setCnNm(JSPUtil.getParameter(request, "cn_nm", ""));
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdoSearchVO[]
	 */
	public EdoSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdoSearchVO[]
	 */
	public EdoSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdoSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] edoAckCd = (JSPUtil.getParameter(request, prefix	+ "edo_ack_cd", length));
			String[] edoRctLocCd = (JSPUtil.getParameter(request, prefix	+ "edo_rct_loc_cd", length));
			String[] edoTpCd = (JSPUtil.getParameter(request, prefix	+ "edo_tp_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] edoRqstDtE = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_dt_e", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] edoRqstDtS = (JSPUtil.getParameter(request, prefix	+ "edo_rqst_dt_s", length));
			String[] cnNm = (JSPUtil.getParameter(request, prefix	+ "cn_nm", length));
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdoSearchVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (edoAckCd[i] != null)
					model.setEdoAckCd(edoAckCd[i]);
				if (edoRctLocCd[i] != null)
					model.setEdoRctLocCd(edoRctLocCd[i]);
				if (edoTpCd[i] != null)
					model.setEdoTpCd(edoTpCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (edoRqstDtE[i] != null)
					model.setEdoRqstDtE(edoRqstDtE[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (edoRqstDtS[i] != null)
					model.setEdoRqstDtS(edoRqstDtS[i]);
				if (cnNm[i] != null)
					model.setCnNm(cnNm[i]);
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdoSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdoSearchVO[]
	 */
	public EdoSearchVO[] getEdoSearchVOs(){
		EdoSearchVO[] vos = (EdoSearchVO[])models.toArray(new EdoSearchVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoAckCd = this.edoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRctLocCd = this.edoRctLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoTpCd = this.edoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstDtE = this.edoRqstDtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoRqstDtS = this.edoRqstDtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnNm = this.cnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNoSplit = this.doNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
