/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSimPort1VO.java
*@FileTitle : SearchSimPort1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.14 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.lanesimulation.vo;

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
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimPort1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimPort1VO> models = new ArrayList<SearchSimPort1VO>();
	
	/* Column Info */
	private String toCnt = null;
	/* Column Info */
	private String fmCnt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String num = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimPort1VO() {}

	public SearchSimPort1VO(String ibflag, String pagerows, String slanCd, String sectNo, String trdCd, String rlaneCd, String skdDirCd, String tmlCd, String seq, String turnPortIndCd, String fmCnt, String toCnt, String num) {
		this.toCnt = toCnt;
		this.fmCnt = fmCnt;
		this.trdCd = trdCd;
		this.sectNo = sectNo;
		this.rlaneCd = rlaneCd;
		this.tmlCd = tmlCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.turnPortIndCd = turnPortIndCd;
		this.ibflag = ibflag;
		this.num = num;
		this.slanCd = slanCd;
		this.seq = seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_cnt", getToCnt());
		this.hashColumns.put("fm_cnt", getFmCnt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("num", getNum());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_cnt", "toCnt");
		this.hashFields.put("fm_cnt", "fmCnt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("num", "num");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toCnt
	 */
	public String getToCnt() {
		return this.toCnt;
	}
	
	/**
	 * Column Info
	 * @return fmCnt
	 */
	public String getFmCnt() {
		return this.fmCnt;
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
	 * @return sectNo
	 */
	public String getSectNo() {
		return this.sectNo;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
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
	 * @return num
	 */
	public String getNum() {
		return this.num;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	

	/**
	 * Column Info
	 * @param toCnt
	 */
	public void setToCnt(String toCnt) {
		this.toCnt = toCnt;
	}
	
	/**
	 * Column Info
	 * @param fmCnt
	 */
	public void setFmCnt(String fmCnt) {
		this.fmCnt = fmCnt;
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
	 * @param sectNo
	 */
	public void setSectNo(String sectNo) {
		this.sectNo = sectNo;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
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
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToCnt(JSPUtil.getParameter(request, "to_cnt", ""));
		setFmCnt(JSPUtil.getParameter(request, "fm_cnt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSectNo(JSPUtil.getParameter(request, "sect_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNum(JSPUtil.getParameter(request, "num", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimPort1VO[]
	 */
	public SearchSimPort1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimPort1VO[]
	 */
	public SearchSimPort1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimPort1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toCnt = (JSPUtil.getParameter(request, prefix	+ "to_cnt", length));
			String[] fmCnt = (JSPUtil.getParameter(request, prefix	+ "fm_cnt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] num = (JSPUtil.getParameter(request, prefix	+ "num", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimPort1VO();
				if (toCnt[i] != null)
					model.setToCnt(toCnt[i]);
				if (fmCnt[i] != null)
					model.setFmCnt(fmCnt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (num[i] != null)
					model.setNum(num[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimPort1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimPort1VO[]
	 */
	public SearchSimPort1VO[] getSearchSimPort1VOs(){
		SearchSimPort1VO[] vos = (SearchSimPort1VO[])models.toArray(new SearchSimPort1VO[models.size()]);
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
		this.toCnt = this.toCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCnt = this.fmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.num = this.num .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
