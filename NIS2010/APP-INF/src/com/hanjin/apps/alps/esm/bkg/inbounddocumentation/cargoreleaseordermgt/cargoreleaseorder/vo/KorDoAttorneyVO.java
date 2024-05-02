/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgKorDoAttorneyVO.java
*@FileTitle : BkgKorDoAttorneyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.15 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 임진영
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class KorDoAttorneyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorDoAttorneyVO> models = new ArrayList<KorDoAttorneyVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String rgstOfcCd = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String rgstUsrId = null;
	/* Column Info */
	private String childRecord = null;
	/* Column Info */
	private String attyBizNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String attyCustNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntcNo2 = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String cntcNo1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorDoAttorneyVO() {}

	public KorDoAttorneyVO(String ibflag, String pagerows, String attyBizNo, String attyCustNm, String cntcNo1, String cntcNo2, String diffRmk, String rgstOfcCd, String rgstDt, String rgstUsrId, String updOfcCd, String updDt, String updUsrId, String updUsrNm, String creUsrId, String creDt, String childRecord) {
		this.ibflag = ibflag;
		this.rgstOfcCd = rgstOfcCd;
		this.rgstDt = rgstDt;
		this.rgstUsrId = rgstUsrId;
		this.childRecord = childRecord;
		this.attyBizNo = attyBizNo;
		this.diffRmk = diffRmk;
		this.updUsrId = updUsrId;
		this.attyCustNm = attyCustNm;
		this.updDt = updDt;
		this.creDt = creDt;
		this.cntcNo2 = cntcNo2;
		this.updOfcCd = updOfcCd;
		this.creUsrId = creUsrId;
		this.updUsrNm = updUsrNm;
		this.cntcNo1 = cntcNo1;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rgst_ofc_cd", getRgstOfcCd());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("rgst_usr_id", getRgstUsrId());
		this.hashColumns.put("child_record", getChildRecord());
		this.hashColumns.put("atty_biz_no", getAttyBizNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("atty_cust_nm", getAttyCustNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntc_no2", getCntcNo2());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("cntc_no1", getCntcNo1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rgst_ofc_cd", "rgstOfcCd");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("rgst_usr_id", "rgstUsrId");
		this.hashFields.put("child_record", "childRecord");
		this.hashFields.put("atty_biz_no", "attyBizNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("atty_cust_nm", "attyCustNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntc_no2", "cntcNo2");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("cntc_no1", "cntcNo1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return rgstOfcCd
	 */
	public String getRgstOfcCd() {
		return this.rgstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}
	
	/**
	 * Column Info
	 * @return rgstUsrId
	 */
	public String getRgstUsrId() {
		return this.rgstUsrId;
	}
	
	/**
	 * Column Info
	 * @return childRecord
	 */
	public String getChildRecord() {
		return this.childRecord;
	}
	
	/**
	 * Column Info
	 * @return attyBizNo
	 */
	public String getAttyBizNo() {
		return this.attyBizNo;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return attyCustNm
	 */
	public String getAttyCustNm() {
		return this.attyCustNm;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return cntcNo2
	 */
	public String getCntcNo2() {
		return this.cntcNo2;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return cntcNo1
	 */
	public String getCntcNo1() {
		return this.cntcNo1;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param rgstOfcCd
	 */
	public void setRgstOfcCd(String rgstOfcCd) {
		this.rgstOfcCd = rgstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	/**
	 * Column Info
	 * @param rgstUsrId
	 */
	public void setRgstUsrId(String rgstUsrId) {
		this.rgstUsrId = rgstUsrId;
	}
	
	/**
	 * Column Info
	 * @param childRecord
	 */
	public void setChildRecord(String childRecord) {
		this.childRecord = childRecord;
	}
	
	/**
	 * Column Info
	 * @param attyBizNo
	 */
	public void setAttyBizNo(String attyBizNo) {
		this.attyBizNo = attyBizNo;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param attyCustNm
	 */
	public void setAttyCustNm(String attyCustNm) {
		this.attyCustNm = attyCustNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param cntcNo2
	 */
	public void setCntcNo2(String cntcNo2) {
		this.cntcNo2 = cntcNo2;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param cntcNo1
	 */
	public void setCntcNo1(String cntcNo1) {
		this.cntcNo1 = cntcNo1;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRgstOfcCd(JSPUtil.getParameter(request, "rgst_ofc_cd", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
		setRgstUsrId(JSPUtil.getParameter(request, "rgst_usr_id", ""));
		setChildRecord(JSPUtil.getParameter(request, "child_record", ""));
		setAttyBizNo(JSPUtil.getParameter(request, "atty_biz_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAttyCustNm(JSPUtil.getParameter(request, "atty_cust_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntcNo2(JSPUtil.getParameter(request, "cntc_no2", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setCntcNo1(JSPUtil.getParameter(request, "cntc_no1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return BkgKorDoAttorneyVO[]
	 */
	public KorDoAttorneyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgKorDoAttorneyVO[]
	 */
	public KorDoAttorneyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDoAttorneyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rgstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgst_ofc_cd".trim(), length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt".trim(), length));
			String[] rgstUsrId = (JSPUtil.getParameter(request, prefix	+ "rgst_usr_id".trim(), length));
			String[] childRecord = (JSPUtil.getParameter(request, prefix	+ "child_record".trim(), length));
			String[] attyBizNo = (JSPUtil.getParameter(request, prefix	+ "atty_biz_no".trim(), length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] attyCustNm = (JSPUtil.getParameter(request, prefix	+ "atty_cust_nm".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] cntcNo2 = (JSPUtil.getParameter(request, prefix	+ "cntc_no2".trim(), length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm".trim(), length));
			String[] cntcNo1 = (JSPUtil.getParameter(request, prefix	+ "cntc_no1".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new KorDoAttorneyVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rgstOfcCd[i] != null)
					model.setRgstOfcCd(rgstOfcCd[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (rgstUsrId[i] != null)
					model.setRgstUsrId(rgstUsrId[i]);
				if (childRecord[i] != null)
					model.setChildRecord(childRecord[i]);
				if (attyBizNo[i] != null)
					model.setAttyBizNo(attyBizNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (attyCustNm[i] != null)
					model.setAttyCustNm(attyCustNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntcNo2[i] != null)
					model.setCntcNo2(cntcNo2[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (cntcNo1[i] != null)
					model.setCntcNo1(cntcNo1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgKorDoAttorneyVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return BkgKorDoAttorneyVO[]
	 */
	public KorDoAttorneyVO[] getBkgKorDoAttorneyVOs(){
		KorDoAttorneyVO[] vos = (KorDoAttorneyVO[])models.toArray(new KorDoAttorneyVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstOfcCd = this.rgstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstUsrId = this.rgstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.childRecord = this.childRecord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attyBizNo = this.attyBizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attyCustNm = this.attyCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcNo2 = this.cntcNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcNo1 = this.cntcNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
