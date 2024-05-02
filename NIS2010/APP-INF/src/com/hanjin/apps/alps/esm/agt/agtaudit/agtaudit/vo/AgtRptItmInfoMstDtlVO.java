/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgtRptItmInfoMstDtlVO.java
*@FileTitle : AgtRptItmInfoMstDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.05 이호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo;

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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgtRptItmInfoMstDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgtRptItmInfoMstDtlVO> models = new ArrayList<AgtRptItmInfoMstDtlVO>();
	
	/* Column Info */
	private String slctItmFomDesc = null;
	/* Column Info */
	private String slctItmFomSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rptItmColNm = null;
	/* Column Info */
	private String rptItmCd = null;
	/* Column Info */
	private String rptItmDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( I:Creation,D:Delete ) */
	private String saveFlag = null;
	/* VO Data Value( N:Use This Setting At This Time Only,Y:Save This Setting As ) */
	private String saveYn = null;
	/* VO Data Value*/
	private String saveName = null;
	/* VO Data Value*/
	private String txtGroup = null;
	/* VO Data Value*/
	private String slctItmFomNum = null;
	/* VO Data Value*/
	private String rptUsrId = null;
	/* VO Data Value*/
	private String updUsrId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgtRptItmInfoMstDtlVO() {}

	public AgtRptItmInfoMstDtlVO(String ibflag, String pagerows, String slctItmFomSeq, String slctItmFomDesc, String rptItmCd, String rptItmColNm, String rptItmDesc, String creUsrId, String saveFlag, String saveYn, String saveName, String txtGroup, String slctItmFomNum, String rptUsrId, String updUsrId) {
		this.slctItmFomDesc = slctItmFomDesc;
		this.slctItmFomSeq = slctItmFomSeq;
		this.ibflag = ibflag;
		this.rptItmColNm = rptItmColNm;
		this.rptItmCd = rptItmCd;
		this.rptItmDesc = rptItmDesc;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.saveFlag = saveFlag;
		this.saveYn = saveYn;
		this.saveName = saveName;
		this.txtGroup = txtGroup;
		this.slctItmFomNum = slctItmFomNum;
		this.rptUsrId = rptUsrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("slct_itm_fom_desc", getSlctItmFomDesc());
		this.hashColumns.put("slct_itm_fom_seq", getSlctItmFomSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpt_itm_col_nm", getRptItmColNm());
		this.hashColumns.put("rpt_itm_cd", getRptItmCd());
		this.hashColumns.put("rpt_itm_desc", getRptItmDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("saveFlag", getSaveFlag());
		this.hashColumns.put("save_yn", getSaveYn());
		this.hashColumns.put("save_name", getSaveName());
		this.hashColumns.put("txtGroup", getTxtGroup());
		this.hashColumns.put("slct_itm_fom_num", getSlctItmFomNum());
		this.hashColumns.put("rpt_usr_id", getRptUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("slct_itm_fom_desc", "slctItmFomDesc");
		this.hashFields.put("slct_itm_fom_seq", "slctItmFomSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpt_itm_col_nm", "rptItmColNm");
		this.hashFields.put("rpt_itm_cd", "rptItmCd");
		this.hashFields.put("rpt_itm_desc", "rptItmDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("saveFlag", "saveFlag");
		this.hashFields.put("save_yn", "saveYn");
		this.hashFields.put("save_name", "saveName");
		this.hashFields.put("txtGroup", "txtGroup");
		this.hashFields.put("slct_itm_fom_num", "slctItmFomNum");
		this.hashFields.put("rpt_usr_id", "rptUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return slctItmFomDesc
	 */
	public String getSlctItmFomDesc() {
		return this.slctItmFomDesc;
	}
	
	/**
	 * Column Info
	 * @return slctItmFomSeq
	 */
	public String getSlctItmFomSeq() {
		return this.slctItmFomSeq;
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
	 * @return rptItmColNm
	 */
	public String getRptItmColNm() {
		return this.rptItmColNm;
	}
	
	/**
	 * Column Info
	 * @return rptItmCd
	 */
	public String getRptItmCd() {
		return this.rptItmCd;
	}
	
	/**
	 * Column Info
	 * @return rptItmDesc
	 */
	public String getRptItmDesc() {
		return this.rptItmDesc;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	public String getSaveFlag() {
    	return saveFlag;
    }
	public String getSaveYn() {
    	return saveYn;
    }

	public String getSaveName() {
    	return saveName;
    }
	
	public String getTxtGroup() {
    	return txtGroup;
    }
	
	public String getSlctItmFomNum() {
    	return slctItmFomNum;
    }

	public String getRptUsrId() {
    	return rptUsrId;
    }
	
	public String getUpdUsrId() {
    	return updUsrId;
    }

	/**
	 * Column Info
	 * @param slctItmFomDesc
	 */
	public void setSlctItmFomDesc(String slctItmFomDesc) {
		this.slctItmFomDesc = slctItmFomDesc;
	}
	
	/**
	 * Column Info
	 * @param slctItmFomSeq
	 */
	public void setSlctItmFomSeq(String slctItmFomSeq) {
		this.slctItmFomSeq = slctItmFomSeq;
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
	 * @param rptItmColNm
	 */
	public void setRptItmColNm(String rptItmColNm) {
		this.rptItmColNm = rptItmColNm;
	}
	
	/**
	 * Column Info
	 * @param rptItmCd
	 */
	public void setRptItmCd(String rptItmCd) {
		this.rptItmCd = rptItmCd;
	}
	
	/**
	 * Column Info
	 * @param rptItmDesc
	 */
	public void setRptItmDesc(String rptItmDesc) {
		this.rptItmDesc = rptItmDesc;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	public void setSaveFlag(String saveFlag) {
    	this.saveFlag = saveFlag;
    }
	
	public void setSaveYn(String saveYn) {
    	this.saveYn = saveYn;
    }
	public void setSaveName(String saveName) {
    	this.saveName = saveName;
    }

	public void setTxtGroup(String txtGroup) {
    	this.txtGroup = txtGroup;
    }
	
	public void setSlctItmFomNum(String slctItmFomNum) {
    	this.slctItmFomNum = slctItmFomNum;
    }
	
	public void setRptUsrId(String rptUsrId) {
    	this.rptUsrId = rptUsrId;
    }
	
	public void setUpdUsrId(String updUsrId) {
    	this.updUsrId = updUsrId;
    }
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSlctItmFomDesc(JSPUtil.getParameter(request, "slct_itm_fom_desc", ""));
		setSlctItmFomSeq(JSPUtil.getParameter(request, "slct_itm_fom_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRptItmColNm(JSPUtil.getParameter(request, "rpt_itm_col_nm", ""));
		setRptItmCd(JSPUtil.getParameter(request, "rpt_itm_cd", ""));
		setRptItmDesc(JSPUtil.getParameter(request, "rpt_itm_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSaveFlag(JSPUtil.getParameter(request, "saveFlag", ""));
		setSaveYn(JSPUtil.getParameter(request, "save_yn", ""));
		setSaveName(JSPUtil.getParameter(request, "save_name", ""));
		setTxtGroup(JSPUtil.getParameter(request, "txtGroup", ""));
		setSlctItmFomNum(JSPUtil.getParameter(request, "slct_itm_fom_num", ""));
		setRptUsrId(JSPUtil.getParameter(request, "rpt_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgtRptItmInfoMstDtlVO[]
	 */
	public AgtRptItmInfoMstDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgtRptItmInfoMstDtlVO[]
	 */
	public AgtRptItmInfoMstDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgtRptItmInfoMstDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slctItmFomDesc = (JSPUtil.getParameter(request, prefix	+ "slct_itm_fom_desc", length));
			String[] slctItmFomSeq = (JSPUtil.getParameter(request, prefix	+ "slct_itm_fom_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rptItmColNm = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_col_nm", length));
			String[] rptItmCd = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_cd", length));
			String[] rptItmDesc = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] saveFlag = (JSPUtil.getParameter(request, prefix	+ "saveFlag", length));
			String[] saveYn = (JSPUtil.getParameter(request, prefix	+ "save_yn", length));
			String[] saveName = (JSPUtil.getParameter(request, prefix	+ "save_name", length));
			String[] txtGroup = (JSPUtil.getParameter(request, prefix	+ "txtGroup", length));
			String[] slctItmFomNum = (JSPUtil.getParameter(request, prefix	+ "slct_itm_fom_num", length));
			String[] rptUsrId = (JSPUtil.getParameter(request, prefix	+ "rpt_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgtRptItmInfoMstDtlVO();
				if (slctItmFomDesc[i] != null)
					model.setSlctItmFomDesc(slctItmFomDesc[i]);
				if (slctItmFomSeq[i] != null)
					model.setSlctItmFomSeq(slctItmFomSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rptItmColNm[i] != null)
					model.setRptItmColNm(rptItmColNm[i]);
				if (rptItmCd[i] != null)
					model.setRptItmCd(rptItmCd[i]);
				if (rptItmDesc[i] != null)
					model.setRptItmDesc(rptItmDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (saveFlag[i] != null)
					model.setSaveFlag(saveFlag[i]);
				if (saveYn[i] != null)
					model.setSaveYn(saveYn[i]);
				if (saveName[i] != null)
					model.setSaveName(saveName[i]);
				if (txtGroup[i] != null)
					model.setTxtGroup(txtGroup[i]);
				if (slctItmFomNum[i] != null)
					model.setSlctItmFomNum(slctItmFomNum[i]);
				if (rptUsrId[i] != null)
					model.setRptUsrId(rptUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgtRptItmInfoMstDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgtRptItmInfoMstDtlVO[]
	 */
	public AgtRptItmInfoMstDtlVO[] getAgtRptItmInfoMstDtlVOs(){
		AgtRptItmInfoMstDtlVO[] vos = (AgtRptItmInfoMstDtlVO[])models.toArray(new AgtRptItmInfoMstDtlVO[models.size()]);
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
		this.slctItmFomDesc = this.slctItmFomDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slctItmFomSeq = this.slctItmFomSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmColNm = this.rptItmColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmCd = this.rptItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmDesc = this.rptItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveFlag = this.saveFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveYn = this.saveYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveName = this.saveName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtGroup = this.txtGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slctItmFomNum = this.slctItmFomNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptUsrId = this.rptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
