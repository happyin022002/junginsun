/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolMnrHistoryINVO.java
*@FileTitle : PoolMnrHistoryINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.13 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolMnrHistoryINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolMnrHistoryINVO> models = new ArrayList<PoolMnrHistoryINVO>();
	
	/* Column Info */
	private String mvmtDtFr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sort = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String mvmtDtTo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolMnrHistoryINVO() {}

	public PoolMnrHistoryINVO(String ibflag, String pagerows, String chssPoolCd, String mvmtDtTo, String mvmtDtFr, String sort) {
		this.mvmtDtFr = mvmtDtFr;
		this.ibflag = ibflag;
		this.sort = sort;
		this.chssPoolCd = chssPoolCd;
		this.mvmtDtTo = mvmtDtTo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mvmt_dt_fr", getMvmtDtFr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sort", getSort());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("mvmt_dt_to", getMvmtDtTo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mvmt_dt_fr", "mvmtDtFr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sort", "sort");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("mvmt_dt_to", "mvmtDtTo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mvmtDtFr
	 */
	public String getMvmtDtFr() {
		return this.mvmtDtFr;
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
	 * @return sort
	 */
	public String getSort() {
		return this.sort;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtDtTo
	 */
	public String getMvmtDtTo() {
		return this.mvmtDtTo;
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
	 * @param mvmtDtFr
	 */
	public void setMvmtDtFr(String mvmtDtFr) {
		this.mvmtDtFr = mvmtDtFr;
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
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtDtTo
	 */
	public void setMvmtDtTo(String mvmtDtTo) {
		this.mvmtDtTo = mvmtDtTo;
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
		setMvmtDtFr(JSPUtil.getParameter(request, "mvmt_dt_fr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSort(JSPUtil.getParameter(request, "sort", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setMvmtDtTo(JSPUtil.getParameter(request, "mvmt_dt_to", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolMnrHistoryINVO[]
	 */
	public PoolMnrHistoryINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolMnrHistoryINVO[]
	 */
	public PoolMnrHistoryINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolMnrHistoryINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mvmtDtFr = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt_fr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sort = (JSPUtil.getParameter(request, prefix	+ "sort", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] mvmtDtTo = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolMnrHistoryINVO();
				if (mvmtDtFr[i] != null)
					model.setMvmtDtFr(mvmtDtFr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sort[i] != null)
					model.setSort(sort[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (mvmtDtTo[i] != null)
					model.setMvmtDtTo(mvmtDtTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolMnrHistoryINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolMnrHistoryINVO[]
	 */
	public PoolMnrHistoryINVO[] getPoolMnrHistoryINVOs(){
		PoolMnrHistoryINVO[] vos = (PoolMnrHistoryINVO[])models.toArray(new PoolMnrHistoryINVO[models.size()]);
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
		this.mvmtDtFr = this.mvmtDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sort = this.sort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDtTo = this.mvmtDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
