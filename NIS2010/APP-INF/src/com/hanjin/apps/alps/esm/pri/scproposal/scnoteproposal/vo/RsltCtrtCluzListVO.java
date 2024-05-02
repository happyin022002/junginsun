/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltCtrtCluzListVO.java
*@FileTitle : RsltCtrtCluzListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.20 문동규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 문동규
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class RsltCtrtCluzListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCtrtCluzListVO> models = new ArrayList<RsltCtrtCluzListVO>();
	
	/* Column Info */
	private String ctrtCluzCtnt = null;
	/* Column Info */
	private String noteClssCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtCluzDtlSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String ctrtCluzSeq = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCtrtCluzListVO() {}

	public RsltCtrtCluzListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String glineSeq, String ctrtCluzSeq, String noteClssCd, String ctrtCluzDtlSeq, String chgCd, String ctrtCluzCtnt) {
		this.ctrtCluzCtnt = ctrtCluzCtnt;
		this.noteClssCd = noteClssCd;
		this.ibflag = ibflag;
		this.ctrtCluzDtlSeq = ctrtCluzDtlSeq;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.svcScpCd = svcScpCd;
		this.ctrtCluzSeq = ctrtCluzSeq;
		this.glineSeq = glineSeq;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_cluz_ctnt", getCtrtCluzCtnt());
		this.hashColumns.put("note_clss_cd", getNoteClssCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_cluz_dtl_seq", getCtrtCluzDtlSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("ctrt_cluz_seq", getCtrtCluzSeq());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_cluz_ctnt", "ctrtCluzCtnt");
		this.hashFields.put("note_clss_cd", "noteClssCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_cluz_dtl_seq", "ctrtCluzDtlSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("ctrt_cluz_seq", "ctrtCluzSeq");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtCluzCtnt
	 */
	public String getCtrtCluzCtnt() {
		return this.ctrtCluzCtnt;
	}
	
	/**
	 * Column Info
	 * @return noteClssCd
	 */
	public String getNoteClssCd() {
		return this.noteClssCd;
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
	 * @return ctrtCluzDtlSeq
	 */
	public String getCtrtCluzDtlSeq() {
		return this.ctrtCluzDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCluzSeq
	 */
	public String getCtrtCluzSeq() {
		return this.ctrtCluzSeq;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @param ctrtCluzCtnt
	 */
	public void setCtrtCluzCtnt(String ctrtCluzCtnt) {
		this.ctrtCluzCtnt = ctrtCluzCtnt;
	}
	
	/**
	 * Column Info
	 * @param noteClssCd
	 */
	public void setNoteClssCd(String noteClssCd) {
		this.noteClssCd = noteClssCd;
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
	 * @param ctrtCluzDtlSeq
	 */
	public void setCtrtCluzDtlSeq(String ctrtCluzDtlSeq) {
		this.ctrtCluzDtlSeq = ctrtCluzDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCluzSeq
	 */
	public void setCtrtCluzSeq(String ctrtCluzSeq) {
		this.ctrtCluzSeq = ctrtCluzSeq;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCtrtCluzCtnt(JSPUtil.getParameter(request, "ctrt_cluz_ctnt", ""));
		setNoteClssCd(JSPUtil.getParameter(request, "note_clss_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtCluzDtlSeq(JSPUtil.getParameter(request, "ctrt_cluz_dtl_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCtrtCluzSeq(JSPUtil.getParameter(request, "ctrt_cluz_seq", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return RsltCtrtCluzListVO[]
	 */
	public RsltCtrtCluzListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCtrtCluzListVO[]
	 */
	public RsltCtrtCluzListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCtrtCluzListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtCluzCtnt = (JSPUtil.getParameter(request, prefix	+ "ctrt_cluz_ctnt".trim(), length));
			String[] noteClssCd = (JSPUtil.getParameter(request, prefix	+ "note_clss_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ctrtCluzDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cluz_dtl_seq".trim(), length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq".trim(), length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] ctrtCluzSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cluz_seq".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq".trim(), length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltCtrtCluzListVO();
				if (ctrtCluzCtnt[i] != null)
					model.setCtrtCluzCtnt(ctrtCluzCtnt[i]);
				if (noteClssCd[i] != null)
					model.setNoteClssCd(noteClssCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtCluzDtlSeq[i] != null)
					model.setCtrtCluzDtlSeq(ctrtCluzDtlSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (ctrtCluzSeq[i] != null)
					model.setCtrtCluzSeq(ctrtCluzSeq[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCtrtCluzListVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return RsltCtrtCluzListVO[]
	 */
	public RsltCtrtCluzListVO[] getRsltCtrtCluzListVOs(){
		RsltCtrtCluzListVO[] vos = (RsltCtrtCluzListVO[])models.toArray(new RsltCtrtCluzListVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.ctrtCluzCtnt = this.ctrtCluzCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteClssCd = this.noteClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCluzDtlSeq = this.ctrtCluzDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCluzSeq = this.ctrtCluzSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
