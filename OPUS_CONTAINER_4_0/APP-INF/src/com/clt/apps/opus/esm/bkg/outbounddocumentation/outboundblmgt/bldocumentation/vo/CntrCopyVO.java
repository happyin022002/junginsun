/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrCopyVO.java
*@FileTitle : CntrCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.03 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrCopyVO> models = new ArrayList<CntrCopyVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String tgtBkgNo = null;
	/* Column Info */
	private String srcBkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String originFlg = null;
	/* Column Info */
	private String srcCntrVol = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String tgtCntrVol = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrCopyVO() {}

	public CntrCopyVO(String ibflag, String pagerows, String originFlg, String cntrNo, String srcBkgNo, String srcCntrVol, String tgtBkgNo, String tgtCntrVol, String creUsrId, String updUsrId, String caFlg, String ofcCd) {
		this.creUsrId = creUsrId;
		this.tgtBkgNo = tgtBkgNo;
		this.srcBkgNo = srcBkgNo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.caFlg = caFlg;
		this.originFlg = originFlg;
		this.srcCntrVol = srcCntrVol;
		this.updUsrId = updUsrId;
		this.tgtCntrVol = tgtCntrVol;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tgt_bkg_no", getTgtBkgNo());
		this.hashColumns.put("src_bkg_no", getSrcBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("origin_flg", getOriginFlg());
		this.hashColumns.put("src_cntr_vol", getSrcCntrVol());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tgt_cntr_vol", getTgtCntrVol());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tgt_bkg_no", "tgtBkgNo");
		this.hashFields.put("src_bkg_no", "srcBkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("origin_flg", "originFlg");
		this.hashFields.put("src_cntr_vol", "srcCntrVol");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tgt_cntr_vol", "tgtCntrVol");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		return this.hashFields;
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
	 * @return tgtBkgNo
	 */
	public String getTgtBkgNo() {
		return this.tgtBkgNo;
	}
	
	/**
	 * Column Info
	 * @return srcBkgNo
	 */
	public String getSrcBkgNo() {
		return this.srcBkgNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return originFlg
	 */
	public String getOriginFlg() {
		return this.originFlg;
	}
	
	/**
	 * Column Info
	 * @return srcCntrVol
	 */
	public String getSrcCntrVol() {
		return this.srcCntrVol;
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
	 * @return tgtCntrVol
	 */
	public String getTgtCntrVol() {
		return this.tgtCntrVol;
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
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param tgtBkgNo
	 */
	public void setTgtBkgNo(String tgtBkgNo) {
		this.tgtBkgNo = tgtBkgNo;
	}
	
	/**
	 * Column Info
	 * @param srcBkgNo
	 */
	public void setSrcBkgNo(String srcBkgNo) {
		this.srcBkgNo = srcBkgNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param originFlg
	 */
	public void setOriginFlg(String originFlg) {
		this.originFlg = originFlg;
	}
	
	/**
	 * Column Info
	 * @param srcCntrVol
	 */
	public void setSrcCntrVol(String srcCntrVol) {
		this.srcCntrVol = srcCntrVol;
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
	 * @param tgtCntrVol
	 */
	public void setTgtCntrVol(String tgtCntrVol) {
		this.tgtCntrVol = tgtCntrVol;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTgtBkgNo(JSPUtil.getParameter(request, "tgt_bkg_no", ""));
		setSrcBkgNo(JSPUtil.getParameter(request, "src_bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCaFlg(JSPUtil.getParameter(request, "ca_flg", ""));
		setOriginFlg(JSPUtil.getParameter(request, "origin_flg", ""));
		setSrcCntrVol(JSPUtil.getParameter(request, "src_cntr_vol", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTgtCntrVol(JSPUtil.getParameter(request, "tgt_cntr_vol", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrCopyVO[]
	 */
	public CntrCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrCopyVO[]
	 */
	public CntrCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tgtBkgNo = (JSPUtil.getParameter(request, prefix	+ "tgt_bkg_no", length));
			String[] srcBkgNo = (JSPUtil.getParameter(request, prefix	+ "src_bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] originFlg = (JSPUtil.getParameter(request, prefix	+ "origin_flg", length));
			String[] srcCntrVol = (JSPUtil.getParameter(request, prefix	+ "src_cntr_vol", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] tgtCntrVol = (JSPUtil.getParameter(request, prefix	+ "tgt_cntr_vol", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrCopyVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (tgtBkgNo[i] != null)
					model.setTgtBkgNo(tgtBkgNo[i]);
				if (srcBkgNo[i] != null)
					model.setSrcBkgNo(srcBkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (originFlg[i] != null)
					model.setOriginFlg(originFlg[i]);
				if (srcCntrVol[i] != null)
					model.setSrcCntrVol(srcCntrVol[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (tgtCntrVol[i] != null)
					model.setTgtCntrVol(tgtCntrVol[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrCopyVO[]
	 */
	public CntrCopyVO[] getCntrCopyVOs(){
		CntrCopyVO[] vos = (CntrCopyVO[])models.toArray(new CntrCopyVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtBkgNo = this.tgtBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcBkgNo = this.srcBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originFlg = this.originFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCntrVol = this.srcCntrVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtCntrVol = this.tgtCntrVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
