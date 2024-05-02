/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBatchJobStatusVO.java
*@FileTitle : SearchBatchJobStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.29 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBatchJobStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBatchJobStatusVO> models = new ArrayList<SearchBatchJobStatusVO>();
	
	/* Column Info */
	private String dt = null;
	/* Column Info */
	private String rp = null;
	/* Column Info */
	private String tm = null;
	/* Column Info */
	private String mp = null;
	/* Column Info */
	private String tl = null;
	/* Column Info */
	private String wk = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String rl = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String wt = null;
	/* Column Info */
	private String rd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String md = null;
	/* Column Info */
	private String mb = null;
	/* Column Info */
	private String ml = null;
	/* Column Info */
	private String wf = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBatchJobStatusVO() {}

	public SearchBatchJobStatusVO(String ibflag, String pagerows, String wk, String dt, String tp, String tl, String ts, String tm, String mp, String ml, String mb, String md, String rp, String rl, String rd, String wf, String wt) {
		this.dt = dt;
		this.rp = rp;
		this.tm = tm;
		this.mp = mp;
		this.tl = tl;
		this.wk = wk;
		this.ts = ts;
		this.rl = rl;
		this.tp = tp;
		this.wt = wt;
		this.rd = rd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.md = md;
		this.mb = mb;
		this.ml = ml;
		this.wf = wf;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dt", getDt());
		this.hashColumns.put("rp", getRp());
		this.hashColumns.put("tm", getTm());
		this.hashColumns.put("mp", getMp());
		this.hashColumns.put("tl", getTl());
		this.hashColumns.put("wk", getWk());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("rl", getRl());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("wt", getWt());
		this.hashColumns.put("rd", getRd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("md", getMd());
		this.hashColumns.put("mb", getMb());
		this.hashColumns.put("ml", getMl());
		this.hashColumns.put("wf", getWf());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dt", "dt");
		this.hashFields.put("rp", "rp");
		this.hashFields.put("tm", "tm");
		this.hashFields.put("mp", "mp");
		this.hashFields.put("tl", "tl");
		this.hashFields.put("wk", "wk");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("rl", "rl");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("wt", "wt");
		this.hashFields.put("rd", "rd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("md", "md");
		this.hashFields.put("mb", "mb");
		this.hashFields.put("ml", "ml");
		this.hashFields.put("wf", "wf");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dt
	 */
	public String getDt() {
		return this.dt;
	}
	
	/**
	 * Column Info
	 * @return rp
	 */
	public String getRp() {
		return this.rp;
	}
	
	/**
	 * Column Info
	 * @return tm
	 */
	public String getTm() {
		return this.tm;
	}
	
	/**
	 * Column Info
	 * @return mp
	 */
	public String getMp() {
		return this.mp;
	}
	
	/**
	 * Column Info
	 * @return tl
	 */
	public String getTl() {
		return this.tl;
	}
	
	/**
	 * Column Info
	 * @return wk
	 */
	public String getWk() {
		return this.wk;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return rl
	 */
	public String getRl() {
		return this.rl;
	}
	
	/**
	 * Column Info
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
	}
	
	/**
	 * Column Info
	 * @return wt
	 */
	public String getWt() {
		return this.wt;
	}
	
	/**
	 * Column Info
	 * @return rd
	 */
	public String getRd() {
		return this.rd;
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
	 * @return md
	 */
	public String getMd() {
		return this.md;
	}
	
	/**
	 * Column Info
	 * @return mb
	 */
	public String getMb() {
		return this.mb;
	}
	
	/**
	 * Column Info
	 * @return ml
	 */
	public String getMl() {
		return this.ml;
	}
	
	/**
	 * Column Info
	 * @return wf
	 */
	public String getWf() {
		return this.wf;
	}
	

	/**
	 * Column Info
	 * @param dt
	 */
	public void setDt(String dt) {
		this.dt = dt;
	}
	
	/**
	 * Column Info
	 * @param rp
	 */
	public void setRp(String rp) {
		this.rp = rp;
	}
	
	/**
	 * Column Info
	 * @param tm
	 */
	public void setTm(String tm) {
		this.tm = tm;
	}
	
	/**
	 * Column Info
	 * @param mp
	 */
	public void setMp(String mp) {
		this.mp = mp;
	}
	
	/**
	 * Column Info
	 * @param tl
	 */
	public void setTl(String tl) {
		this.tl = tl;
	}
	
	/**
	 * Column Info
	 * @param wk
	 */
	public void setWk(String wk) {
		this.wk = wk;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param rl
	 */
	public void setRl(String rl) {
		this.rl = rl;
	}
	
	/**
	 * Column Info
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}
	
	/**
	 * Column Info
	 * @param wt
	 */
	public void setWt(String wt) {
		this.wt = wt;
	}
	
	/**
	 * Column Info
	 * @param rd
	 */
	public void setRd(String rd) {
		this.rd = rd;
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
	 * @param md
	 */
	public void setMd(String md) {
		this.md = md;
	}
	
	/**
	 * Column Info
	 * @param mb
	 */
	public void setMb(String mb) {
		this.mb = mb;
	}
	
	/**
	 * Column Info
	 * @param ml
	 */
	public void setMl(String ml) {
		this.ml = ml;
	}
	
	/**
	 * Column Info
	 * @param wf
	 */
	public void setWf(String wf) {
		this.wf = wf;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDt(JSPUtil.getParameter(request, "dt", ""));
		setRp(JSPUtil.getParameter(request, "rp", ""));
		setTm(JSPUtil.getParameter(request, "tm", ""));
		setMp(JSPUtil.getParameter(request, "mp", ""));
		setTl(JSPUtil.getParameter(request, "tl", ""));
		setWk(JSPUtil.getParameter(request, "wk", ""));
		setTs(JSPUtil.getParameter(request, "ts", ""));
		setRl(JSPUtil.getParameter(request, "rl", ""));
		setTp(JSPUtil.getParameter(request, "tp", ""));
		setWt(JSPUtil.getParameter(request, "wt", ""));
		setRd(JSPUtil.getParameter(request, "rd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMd(JSPUtil.getParameter(request, "md", ""));
		setMb(JSPUtil.getParameter(request, "mb", ""));
		setMl(JSPUtil.getParameter(request, "ml", ""));
		setWf(JSPUtil.getParameter(request, "wf", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBatchJobStatusVO[]
	 */
	public SearchBatchJobStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBatchJobStatusVO[]
	 */
	public SearchBatchJobStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBatchJobStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dt = (JSPUtil.getParameter(request, prefix	+ "dt", length));
			String[] rp = (JSPUtil.getParameter(request, prefix	+ "rp", length));
			String[] tm = (JSPUtil.getParameter(request, prefix	+ "tm", length));
			String[] mp = (JSPUtil.getParameter(request, prefix	+ "mp", length));
			String[] tl = (JSPUtil.getParameter(request, prefix	+ "tl", length));
			String[] wk = (JSPUtil.getParameter(request, prefix	+ "wk", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] rl = (JSPUtil.getParameter(request, prefix	+ "rl", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] wt = (JSPUtil.getParameter(request, prefix	+ "wt", length));
			String[] rd = (JSPUtil.getParameter(request, prefix	+ "rd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] md = (JSPUtil.getParameter(request, prefix	+ "md", length));
			String[] mb = (JSPUtil.getParameter(request, prefix	+ "mb", length));
			String[] ml = (JSPUtil.getParameter(request, prefix	+ "ml", length));
			String[] wf = (JSPUtil.getParameter(request, prefix	+ "wf", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBatchJobStatusVO();
				if (dt[i] != null)
					model.setDt(dt[i]);
				if (rp[i] != null)
					model.setRp(rp[i]);
				if (tm[i] != null)
					model.setTm(tm[i]);
				if (mp[i] != null)
					model.setMp(mp[i]);
				if (tl[i] != null)
					model.setTl(tl[i]);
				if (wk[i] != null)
					model.setWk(wk[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (rl[i] != null)
					model.setRl(rl[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (wt[i] != null)
					model.setWt(wt[i]);
				if (rd[i] != null)
					model.setRd(rd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (md[i] != null)
					model.setMd(md[i]);
				if (mb[i] != null)
					model.setMb(mb[i]);
				if (ml[i] != null)
					model.setMl(ml[i]);
				if (wf[i] != null)
					model.setWf(wf[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBatchJobStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBatchJobStatusVO[]
	 */
	public SearchBatchJobStatusVO[] getSearchBatchJobStatusVOs(){
		SearchBatchJobStatusVO[] vos = (SearchBatchJobStatusVO[])models.toArray(new SearchBatchJobStatusVO[models.size()]);
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
		this.dt = this.dt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rp = this.rp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tm = this.tm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mp = this.mp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tl = this.tl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk = this.wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rl = this.rl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wt = this.wt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rd = this.rd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.md = this.md .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb = this.mb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ml = this.ml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wf = this.wf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
