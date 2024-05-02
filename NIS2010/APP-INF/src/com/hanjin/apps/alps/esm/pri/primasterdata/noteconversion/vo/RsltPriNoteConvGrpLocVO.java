/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RsltPriNoteConvGrpLocVO.java
*@FileTitle : RsltPriNoteConvGrpLocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.22
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.05.15 전윤주
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이승준
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class RsltPriNoteConvGrpLocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriNoteConvGrpLocVO> models = new ArrayList<RsltPriNoteConvGrpLocVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String noteConvGrpLocDesc = null;
	/* Column Info */
	private String noteConvGrpLocCd = null;
	/* Column Info */
	private String prcCtrtTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriNoteConvGrpLocVO() {}

	public RsltPriNoteConvGrpLocVO(String ibflag, String pagerows, String prcCtrtTpCd, String noteConvGrpLocCd, String noteConvGrpLocDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creDt = creDt;
		this.noteConvGrpLocDesc = noteConvGrpLocDesc;
		this.noteConvGrpLocCd = noteConvGrpLocCd;
		this.prcCtrtTpCd = prcCtrtTpCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("note_conv_grp_loc_desc", getNoteConvGrpLocDesc());
		this.hashColumns.put("note_conv_grp_loc_cd", getNoteConvGrpLocCd());
		this.hashColumns.put("prc_ctrt_tp_cd", getPrcCtrtTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("note_conv_grp_loc_desc", "noteConvGrpLocDesc");
		this.hashFields.put("note_conv_grp_loc_cd", "noteConvGrpLocCd");
		this.hashFields.put("prc_ctrt_tp_cd", "prcCtrtTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return noteConvGrpLocDesc
	 */
	public String getNoteConvGrpLocDesc() {
		return this.noteConvGrpLocDesc;
	}
	
	/**
	 * Column Info
	 * @return noteConvGrpLocCd
	 */
	public String getNoteConvGrpLocCd() {
		return this.noteConvGrpLocCd;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtTpCd
	 */
	public String getPrcCtrtTpCd() {
		return this.prcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param noteConvGrpLocDesc
	 */
	public void setNoteConvGrpLocDesc(String noteConvGrpLocDesc) {
		this.noteConvGrpLocDesc = noteConvGrpLocDesc;
	}
	
	/**
	 * Column Info
	 * @param noteConvGrpLocCd
	 */
	public void setNoteConvGrpLocCd(String noteConvGrpLocCd) {
		this.noteConvGrpLocCd = noteConvGrpLocCd;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtTpCd
	 */
	public void setPrcCtrtTpCd(String prcCtrtTpCd) {
		this.prcCtrtTpCd = prcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setNoteConvGrpLocDesc(JSPUtil.getParameter(request, "note_conv_grp_loc_desc", ""));
		setNoteConvGrpLocCd(JSPUtil.getParameter(request, "note_conv_grp_loc_cd", ""));
		setPrcCtrtTpCd(JSPUtil.getParameter(request, "prc_ctrt_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return RsltPriScgGrpLocVO[]
	 */
	public RsltPriNoteConvGrpLocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriScgGrpLocVO[]
	 */
	public RsltPriNoteConvGrpLocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriNoteConvGrpLocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] noteConvGrpLocDesc = (JSPUtil.getParameter(request, prefix	+ "note_conv_grp_loc_desc", length));
			String[] noteConvGrpLocCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_grp_loc_cd", length));
			String[] prcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriNoteConvGrpLocVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (noteConvGrpLocDesc[i] != null)
					model.setNoteConvGrpLocDesc(noteConvGrpLocDesc[i]);
				if (noteConvGrpLocCd[i] != null)
					model.setNoteConvGrpLocCd(noteConvGrpLocCd[i]);
				if (prcCtrtTpCd[i] != null)
					model.setPrcCtrtTpCd(prcCtrtTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriNoteConvGrpLocVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return RsltPriNoteConvGrpLocVO[]
	 */
	public RsltPriNoteConvGrpLocVO[] getRsltPriNoteConvGrpLocVOs(){
		RsltPriNoteConvGrpLocVO[] vos = (RsltPriNoteConvGrpLocVO[])models.toArray(new RsltPriNoteConvGrpLocVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvGrpLocDesc = this.noteConvGrpLocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvGrpLocCd = this.noteConvGrpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtTpCd = this.prcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
