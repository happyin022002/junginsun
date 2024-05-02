/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgImdgUnNoOrgRactVO.java
*@FileTitle : ScgImdgUnNoOrgRactVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.03 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgImdgUnNoOrgRactVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgImdgUnNoOrgRactVO> models = new ArrayList<ScgImdgUnNoOrgRactVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String imdgPckMzdCd = null;
	/* Column Info */
	private String imdgOrgRactTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String imdgEmerTemp = null;
	/* Column Info */
	private String imdgCtrlTemp = null;
	/* Column Info */
	private String imdgConcRtCtnt = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgTecNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgImdgUnNoOrgRactVO() {}

	public ScgImdgUnNoOrgRactVO(String ibflag, String pagerows, String imdgUnNo, String imdgUnNoSeq, String imdgOrgRactTpCd, String imdgTecNm, String imdgConcRtCtnt, String imdgPckMzdCd, String imdgCtrlTemp, String imdgEmerTemp, String creUsrId, String creDt, String updUsrId, String updDt, String imdgSubsRskLblCd) {
		this.updDt = updDt;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.creDt = creDt;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.imdgPckMzdCd = imdgPckMzdCd;
		this.imdgOrgRactTpCd = imdgOrgRactTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.imdgEmerTemp = imdgEmerTemp;
		this.imdgCtrlTemp = imdgCtrlTemp;
		this.imdgConcRtCtnt = imdgConcRtCtnt;
		this.imdgUnNo = imdgUnNo;
		this.imdgTecNm = imdgTecNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("imdg_pck_mzd_cd", getImdgPckMzdCd());
		this.hashColumns.put("imdg_org_ract_tp_cd", getImdgOrgRactTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("imdg_emer_temp", getImdgEmerTemp());
		this.hashColumns.put("imdg_ctrl_temp", getImdgCtrlTemp());
		this.hashColumns.put("imdg_conc_rt_ctnt", getImdgConcRtCtnt());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_tec_nm", getImdgTecNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("imdg_pck_mzd_cd", "imdgPckMzdCd");
		this.hashFields.put("imdg_org_ract_tp_cd", "imdgOrgRactTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("imdg_emer_temp", "imdgEmerTemp");
		this.hashFields.put("imdg_ctrl_temp", "imdgCtrlTemp");
		this.hashFields.put("imdg_conc_rt_ctnt", "imdgConcRtCtnt");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_tec_nm", "imdgTecNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
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
	 * @return imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return this.imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @return imdgPckMzdCd
	 */
	public String getImdgPckMzdCd() {
		return this.imdgPckMzdCd;
	}
	
	/**
	 * Column Info
	 * @return imdgOrgRactTpCd
	 */
	public String getImdgOrgRactTpCd() {
		return this.imdgOrgRactTpCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return imdgEmerTemp
	 */
	public String getImdgEmerTemp() {
		return this.imdgEmerTemp;
	}
	
	/**
	 * Column Info
	 * @return imdgCtrlTemp
	 */
	public String getImdgCtrlTemp() {
		return this.imdgCtrlTemp;
	}
	
	/**
	 * Column Info
	 * @return imdgConcRtCtnt
	 */
	public String getImdgConcRtCtnt() {
		return this.imdgConcRtCtnt;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return imdgTecNm
	 */
	public String getImdgTecNm() {
		return this.imdgTecNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
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
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @param imdgPckMzdCd
	 */
	public void setImdgPckMzdCd(String imdgPckMzdCd) {
		this.imdgPckMzdCd = imdgPckMzdCd;
	}
	
	/**
	 * Column Info
	 * @param imdgOrgRactTpCd
	 */
	public void setImdgOrgRactTpCd(String imdgOrgRactTpCd) {
		this.imdgOrgRactTpCd = imdgOrgRactTpCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param imdgEmerTemp
	 */
	public void setImdgEmerTemp(String imdgEmerTemp) {
		this.imdgEmerTemp = imdgEmerTemp;
	}
	
	/**
	 * Column Info
	 * @param imdgCtrlTemp
	 */
	public void setImdgCtrlTemp(String imdgCtrlTemp) {
		this.imdgCtrlTemp = imdgCtrlTemp;
	}
	
	/**
	 * Column Info
	 * @param imdgConcRtCtnt
	 */
	public void setImdgConcRtCtnt(String imdgConcRtCtnt) {
		this.imdgConcRtCtnt = imdgConcRtCtnt;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param imdgTecNm
	 */
	public void setImdgTecNm(String imdgTecNm) {
		this.imdgTecNm = imdgTecNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, "imdg_subs_rsk_lbl_cd", ""));
		setImdgPckMzdCd(JSPUtil.getParameter(request, "imdg_pck_mzd_cd", ""));
		setImdgOrgRactTpCd(JSPUtil.getParameter(request, "imdg_org_ract_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setImdgEmerTemp(JSPUtil.getParameter(request, "imdg_emer_temp", ""));
		setImdgCtrlTemp(JSPUtil.getParameter(request, "imdg_ctrl_temp", ""));
		setImdgConcRtCtnt(JSPUtil.getParameter(request, "imdg_conc_rt_ctnt", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setImdgTecNm(JSPUtil.getParameter(request, "imdg_tec_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgImdgUnNoOrgRactVO[]
	 */
	public ScgImdgUnNoOrgRactVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgImdgUnNoOrgRactVO[]
	 */
	public ScgImdgUnNoOrgRactVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgImdgUnNoOrgRactVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] imdgPckMzdCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_mzd_cd", length));
			String[] imdgOrgRactTpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_org_ract_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] imdgEmerTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_emer_temp", length));
			String[] imdgCtrlTemp = (JSPUtil.getParameter(request, prefix	+ "imdg_ctrl_temp", length));
			String[] imdgConcRtCtnt = (JSPUtil.getParameter(request, prefix	+ "imdg_conc_rt_ctnt", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgTecNm = (JSPUtil.getParameter(request, prefix	+ "imdg_tec_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgImdgUnNoOrgRactVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (imdgPckMzdCd[i] != null)
					model.setImdgPckMzdCd(imdgPckMzdCd[i]);
				if (imdgOrgRactTpCd[i] != null)
					model.setImdgOrgRactTpCd(imdgOrgRactTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (imdgEmerTemp[i] != null)
					model.setImdgEmerTemp(imdgEmerTemp[i]);
				if (imdgCtrlTemp[i] != null)
					model.setImdgCtrlTemp(imdgCtrlTemp[i]);
				if (imdgConcRtCtnt[i] != null)
					model.setImdgConcRtCtnt(imdgConcRtCtnt[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgTecNm[i] != null)
					model.setImdgTecNm(imdgTecNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgImdgUnNoOrgRactVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgImdgUnNoOrgRactVO[]
	 */
	public ScgImdgUnNoOrgRactVO[] getScgImdgUnNoOrgRactVOs(){
		ScgImdgUnNoOrgRactVO[] vos = (ScgImdgUnNoOrgRactVO[])models.toArray(new ScgImdgUnNoOrgRactVO[models.size()]);
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
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckMzdCd = this.imdgPckMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgOrgRactTpCd = this.imdgOrgRactTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgEmerTemp = this.imdgEmerTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCtrlTemp = this.imdgCtrlTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgConcRtCtnt = this.imdgConcRtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgTecNm = this.imdgTecNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
