/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEGIdListVO.java
*@FileTitle : SearchEGIdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.24 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEGIdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEGIdListVO> models = new ArrayList<SearchEGIdListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egCtyCd = null;
	/* Column Info */
	private String egIdSeq = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String egName = null;
	/* Column Info */
	private String egPicUsrId = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String svcCateCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEGIdListVO() {}

	public SearchEGIdListVO(String ibflag, String pagerows, String egId, String egName, String egRhqCd, String egCtyCd, String svcCateCd, String egPicUsrId, String egIdSeq) {
		this.ibflag = ibflag;
		this.egCtyCd = egCtyCd;
		this.egIdSeq = egIdSeq;
		this.egRhqCd = egRhqCd;
		this.egName = egName;
		this.egPicUsrId = egPicUsrId;
		this.egId = egId;
		this.svcCateCd = svcCateCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_cty_cd", getEgCtyCd());
		this.hashColumns.put("eg_id_seq", getEgIdSeq());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("eg_name", getEgName());
		this.hashColumns.put("eg_pic_usr_id", getEgPicUsrId());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("svc_cate_cd", getSvcCateCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_cty_cd", "egCtyCd");
		this.hashFields.put("eg_id_seq", "egIdSeq");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("eg_name", "egName");
		this.hashFields.put("eg_pic_usr_id", "egPicUsrId");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("svc_cate_cd", "svcCateCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return egCtyCd
	 */
	public String getEgCtyCd() {
		return this.egCtyCd;
	}
	
	/**
	 * Column Info
	 * @return egIdSeq
	 */
	public String getEgIdSeq() {
		return this.egIdSeq;
	}
	
	/**
	 * Column Info
	 * @return egRhqCd
	 */
	public String getEgRhqCd() {
		return this.egRhqCd;
	}
	
	/**
	 * Column Info
	 * @return egName
	 */
	public String getEgName() {
		return this.egName;
	}
	
	/**
	 * Column Info
	 * @return egPicUsrId
	 */
	public String getEgPicUsrId() {
		return this.egPicUsrId;
	}
	
	/**
	 * Column Info
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
	}
	
	/**
	 * Column Info
	 * @return svcCateCd
	 */
	public String getSvcCateCd() {
		return this.svcCateCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param egCtyCd
	 */
	public void setEgCtyCd(String egCtyCd) {
		this.egCtyCd = egCtyCd;
	}
	
	/**
	 * Column Info
	 * @param egIdSeq
	 */
	public void setEgIdSeq(String egIdSeq) {
		this.egIdSeq = egIdSeq;
	}
	
	/**
	 * Column Info
	 * @param egRhqCd
	 */
	public void setEgRhqCd(String egRhqCd) {
		this.egRhqCd = egRhqCd;
	}
	
	/**
	 * Column Info
	 * @param egName
	 */
	public void setEgName(String egName) {
		this.egName = egName;
	}
	
	/**
	 * Column Info
	 * @param egPicUsrId
	 */
	public void setEgPicUsrId(String egPicUsrId) {
		this.egPicUsrId = egPicUsrId;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
	}
	
	/**
	 * Column Info
	 * @param svcCateCd
	 */
	public void setSvcCateCd(String svcCateCd) {
		this.svcCateCd = svcCateCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEgCtyCd(JSPUtil.getParameter(request, "eg_cty_cd", ""));
		setEgIdSeq(JSPUtil.getParameter(request, "eg_id_seq", ""));
		setEgRhqCd(JSPUtil.getParameter(request, "eg_rhq_cd", ""));
		setEgName(JSPUtil.getParameter(request, "eg_name", ""));
		setEgPicUsrId(JSPUtil.getParameter(request, "eg_pic_usr_id", ""));
		setEgId(JSPUtil.getParameter(request, "eg_id", ""));
		setSvcCateCd(JSPUtil.getParameter(request, "svc_cate_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEGIdListVO[]
	 */
	public SearchEGIdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEGIdListVO[]
	 */
	public SearchEGIdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEGIdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egCtyCd = (JSPUtil.getParameter(request, prefix	+ "eg_cty_cd", length));
			String[] egIdSeq = (JSPUtil.getParameter(request, prefix	+ "eg_id_seq", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] egName = (JSPUtil.getParameter(request, prefix	+ "eg_name", length));
			String[] egPicUsrId = (JSPUtil.getParameter(request, prefix	+ "eg_pic_usr_id", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] svcCateCd = (JSPUtil.getParameter(request, prefix	+ "svc_cate_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEGIdListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egCtyCd[i] != null)
					model.setEgCtyCd(egCtyCd[i]);
				if (egIdSeq[i] != null)
					model.setEgIdSeq(egIdSeq[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (egName[i] != null)
					model.setEgName(egName[i]);
				if (egPicUsrId[i] != null)
					model.setEgPicUsrId(egPicUsrId[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (svcCateCd[i] != null)
					model.setSvcCateCd(svcCateCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEGIdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEGIdListVO[]
	 */
	public SearchEGIdListVO[] getSearchEGIdListVOs(){
		SearchEGIdListVO[] vos = (SearchEGIdListVO[])models.toArray(new SearchEGIdListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egCtyCd = this.egCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egIdSeq = this.egIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egName = this.egName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egPicUsrId = this.egPicUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateCd = this.svcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
