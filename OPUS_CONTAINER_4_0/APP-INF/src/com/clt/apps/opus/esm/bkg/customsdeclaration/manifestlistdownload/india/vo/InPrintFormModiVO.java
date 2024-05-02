/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InPrintFormModiVO.java
*@FileTitle : InPrintFormModiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.17 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPrintFormModiVO extends CstmsNtfyAddrVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPrintFormModiVO> models = new ArrayList<InPrintFormModiVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bodCtnt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ftrCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hdrCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String declAddr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPrintFormModiVO() {}

	public InPrintFormModiVO(String ibflag, String pagerows, String ofcCd, String hdrCtnt, String ftrCtnt, String declAddr, String bodCtnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.bodCtnt = bodCtnt;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ftrCtnt = ftrCtnt;
		this.ibflag = ibflag;
		this.hdrCtnt = hdrCtnt;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.declAddr = declAddr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bod_ctnt", getBodCtnt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ftr_ctnt", getFtrCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hdr_ctnt", getHdrCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("decl_addr", getDeclAddr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bod_ctnt", "bodCtnt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ftr_ctnt", "ftrCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hdr_ctnt", "hdrCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("decl_addr", "declAddr");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return bodCtnt
	 */
	public String getBodCtnt() {
		return this.bodCtnt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ftrCtnt
	 */
	public String getFtrCtnt() {
		return this.ftrCtnt;
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
	 * @return hdrCtnt
	 */
	public String getHdrCtnt() {
		return this.hdrCtnt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return declAddr
	 */
	public String getDeclAddr() {
		return this.declAddr;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param bodCtnt
	 */
	public void setBodCtnt(String bodCtnt) {
		this.bodCtnt = bodCtnt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param ftrCtnt
	 */
	public void setFtrCtnt(String ftrCtnt) {
		this.ftrCtnt = ftrCtnt;
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
	 * @param hdrCtnt
	 */
	public void setHdrCtnt(String hdrCtnt) {
		this.hdrCtnt = hdrCtnt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param declAddr
	 */
	public void setDeclAddr(String declAddr) {
		this.declAddr = declAddr;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBodCtnt(JSPUtil.getParameter(request, "bod_ctnt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFtrCtnt(JSPUtil.getParameter(request, "ftr_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHdrCtnt(JSPUtil.getParameter(request, "hdr_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDeclAddr(JSPUtil.getParameter(request, "decl_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPrintFormModiVO[]
	 */
	public InPrintFormModiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPrintFormModiVO[]
	 */
	public InPrintFormModiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPrintFormModiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bodCtnt = (JSPUtil.getParameter(request, prefix	+ "bod_ctnt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ftrCtnt = (JSPUtil.getParameter(request, prefix	+ "ftr_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hdrCtnt = (JSPUtil.getParameter(request, prefix	+ "hdr_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] declAddr = (JSPUtil.getParameter(request, prefix	+ "decl_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPrintFormModiVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bodCtnt[i] != null)
					model.setBodCtnt(bodCtnt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ftrCtnt[i] != null)
					model.setFtrCtnt(ftrCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hdrCtnt[i] != null)
					model.setHdrCtnt(hdrCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (declAddr[i] != null)
					model.setDeclAddr(declAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPrintFormModiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPrintFormModiVO[]
	 */
	public InPrintFormModiVO[] getInPrintFormModiVOs(){
		InPrintFormModiVO[] vos = (InPrintFormModiVO[])models.toArray(new InPrintFormModiVO[models.size()]);
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
		this.bodCtnt = this.bodCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftrCtnt = this.ftrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCtnt = this.hdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declAddr = this.declAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
