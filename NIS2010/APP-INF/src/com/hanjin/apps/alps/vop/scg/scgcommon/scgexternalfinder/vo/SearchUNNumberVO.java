/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchUNNumberVO.java
*@FileTitle : SearchUNNumberVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.20 이도형 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.vo;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchUNNumberVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUNNumberVO> models = new ArrayList<SearchUNNumberVO>();
	
	/* Column Info */
	private String updDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgUnNoSeqMin = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String imdgUnNoSeqCnt = null;
	/* Column Info */
	private String imdgUnNoSeqMax = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchUNNumberVO() {}

	public SearchUNNumberVO(String ibflag, String pagerows, String imdgUnNo, String imdgUnNoSeq, String imdgUnNoSeqMax, String imdgUnNoSeqMin, String imdgUnNoSeqCnt, String updDt) {
		this.updDt = updDt;
		this.ibflag = ibflag;
		this.imdgUnNoSeqMin = imdgUnNoSeqMin;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.imdgUnNoSeqCnt = imdgUnNoSeqCnt;
		this.imdgUnNoSeqMax = imdgUnNoSeqMax;
		this.imdgUnNo = imdgUnNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_un_no_seq_min", getImdgUnNoSeqMin());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("imdg_un_no_seq_cnt", getImdgUnNoSeqCnt());
		this.hashColumns.put("imdg_un_no_seq_max", getImdgUnNoSeqMax());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_un_no_seq_min", "imdgUnNoSeqMin");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("imdg_un_no_seq_cnt", "imdgUnNoSeqCnt");
		this.hashFields.put("imdg_un_no_seq_max", "imdgUnNoSeqMax");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeqMin
	 */
	public String getImdgUnNoSeqMin() {
		return this.imdgUnNoSeqMin;
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
	 * @return imdgUnNoSeqCnt
	 */
	public String getImdgUnNoSeqCnt() {
		return this.imdgUnNoSeqCnt;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeqMax
	 */
	public String getImdgUnNoSeqMax() {
		return this.imdgUnNoSeqMax;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeqMin
	 */
	public void setImdgUnNoSeqMin(String imdgUnNoSeqMin) {
		this.imdgUnNoSeqMin = imdgUnNoSeqMin;
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
	 * @param imdgUnNoSeqCnt
	 */
	public void setImdgUnNoSeqCnt(String imdgUnNoSeqCnt) {
		this.imdgUnNoSeqCnt = imdgUnNoSeqCnt;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeqMax
	 */
	public void setImdgUnNoSeqMax(String imdgUnNoSeqMax) {
		this.imdgUnNoSeqMax = imdgUnNoSeqMax;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setImdgUnNoSeqMin(JSPUtil.getParameter(request, "imdg_un_no_seq_min", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setImdgUnNoSeqCnt(JSPUtil.getParameter(request, "imdg_un_no_seq_cnt", ""));
		setImdgUnNoSeqMax(JSPUtil.getParameter(request, "imdg_un_no_seq_max", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUNNumberVO[]
	 */
	public SearchUNNumberVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUNNumberVO[]
	 */
	public SearchUNNumberVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUNNumberVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] imdgUnNoSeqMin = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq_min".trim(), length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq".trim(), length));
			String[] imdgUnNoSeqCnt = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq_cnt".trim(), length));
			String[] imdgUnNoSeqMax = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq_max".trim(), length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUNNumberVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgUnNoSeqMin[i] != null)
					model.setImdgUnNoSeqMin(imdgUnNoSeqMin[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (imdgUnNoSeqCnt[i] != null)
					model.setImdgUnNoSeqCnt(imdgUnNoSeqCnt[i]);
				if (imdgUnNoSeqMax[i] != null)
					model.setImdgUnNoSeqMax(imdgUnNoSeqMax[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUNNumberVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUNNumberVO[]
	 */
	public SearchUNNumberVO[] getSearchUNNumberVOs(){
		SearchUNNumberVO[] vos = (SearchUNNumberVO[])models.toArray(new SearchUNNumberVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeqMin = this.imdgUnNoSeqMin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeqCnt = this.imdgUnNoSeqCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeqMax = this.imdgUnNoSeqMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
