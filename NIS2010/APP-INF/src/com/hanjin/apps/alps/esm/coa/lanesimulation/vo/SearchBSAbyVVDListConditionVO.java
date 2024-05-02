/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBSAbyVVDListConditionVO.java
*@FileTitle : SearchBSAbyVVDListConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.08.20 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBSAbyVVDListConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBSAbyVVDListConditionVO> models = new ArrayList<SearchBSAbyVVDListConditionVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String fToWk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vsl = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String iCnt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rLaneCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rVsl = null;
	/* Column Info */
	private String fYear = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBSAbyVVDListConditionVO() {}

	public SearchBSAbyVVDListConditionVO(String ibflag, String pagerows, String fYear, String fFmWk, String fToWk, String trdCd, String dirCd, String iocCd, String iCnt, String vsl, String rVsl, String rLaneCd) {
		this.iocCd = iocCd;
		this.fToWk = fToWk;
		this.ibflag = ibflag;
		this.vsl = vsl;
		this.fFmWk = fFmWk;
		this.iCnt = iCnt;
		this.trdCd = trdCd;
		this.rLaneCd = rLaneCd;
		this.dirCd = dirCd;
		this.rVsl = rVsl;
		this.fYear = fYear;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl", getVsl());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("i_cnt", getICnt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRLaneCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("r_vsl", getRVsl());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl", "vsl");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("i_cnt", "iCnt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rLaneCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("r_vsl", "rVsl");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	public String getRLaneCd() {
		return rLaneCd;
	}

	public void setRLaneCd(String laneCd) {
		rLaneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return fToWk
	 */
	public String getFToWk() {
		return this.fToWk;
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
	 * @return vsl
	 */
	public String getVsl() {
		return this.vsl;
	}
	
	/**
	 * Column Info
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
	}
	
	/**
	 * Column Info
	 * @return iCnt
	 */
	public String getICnt() {
		return this.iCnt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return rVsl
	 */
	public String getRVsl() {
		return this.rVsl;
	}
	
	/**
	 * Column Info
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param fToWk
	 */
	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
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
	 * @param vsl
	 */
	public void setVsl(String vsl) {
		this.vsl = vsl;
	}
	
	/**
	 * Column Info
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}
	
	/**
	 * Column Info
	 * @param iCnt
	 */
	public void setICnt(String iCnt) {
		this.iCnt = iCnt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param rVsl
	 */
	public void setRVsl(String rVsl) {
		this.rVsl = rVsl;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
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
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setFToWk(JSPUtil.getParameter(request, "f_to_wk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVsl(JSPUtil.getParameter(request, "vsl", ""));
		setFFmWk(JSPUtil.getParameter(request, "f_fm_wk", ""));
		setICnt(JSPUtil.getParameter(request, "i_cnt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRLaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRVsl(JSPUtil.getParameter(request, "r_vsl", ""));
		setFYear(JSPUtil.getParameter(request, "f_year", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBSAbyVVDListConditionVO[]
	 */
	public SearchBSAbyVVDListConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBSAbyVVDListConditionVO[]
	 */
	public SearchBSAbyVVDListConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBSAbyVVDListConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vsl = (JSPUtil.getParameter(request, prefix	+ "vsl", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] iCnt = (JSPUtil.getParameter(request, prefix	+ "i_cnt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rLaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rVsl = (JSPUtil.getParameter(request, prefix	+ "r_vsl", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBSAbyVVDListConditionVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vsl[i] != null)
					model.setVsl(vsl[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (iCnt[i] != null)
					model.setICnt(iCnt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rLaneCd[i] != null)
					model.setRLaneCd(rLaneCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rVsl[i] != null)
					model.setRVsl(rVsl[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBSAbyVVDListConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBSAbyVVDListConditionVO[]
	 */
	public SearchBSAbyVVDListConditionVO[] getSearchBSAbyVVDListConditionVOs(){
		SearchBSAbyVVDListConditionVO[] vos = (SearchBSAbyVVDListConditionVO[])models.toArray(new SearchBSAbyVVDListConditionVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsl = this.vsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iCnt = this.iCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rLaneCd = this.rLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rVsl = this.rVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	//추가
	private DBRowSet rowSet = null;
	/* DB RowSet 객체  */
	private DBRowSet[] rowSetArray = null;	
	
	/* DB List 객체  */
	List<SearchSimConditionVO> list = null;	
	
	/** DBRowSet Getter */
	public DBRowSet getRowSet() {
		return rowSet;
	}
	/** DBRowSet Setter */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/** DBRowSet Array Getter */
	public DBRowSet[] getRowSetArray() {
		return rowSetArray;
	}
	/** DBRowSet Array Setter */
	public void setRowSetArray(DBRowSet[] rowSetArray) {
		this.rowSetArray = rowSetArray;
	}		
	//////////////////////
}
