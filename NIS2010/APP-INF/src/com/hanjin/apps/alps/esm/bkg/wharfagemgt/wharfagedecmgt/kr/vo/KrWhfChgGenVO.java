/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfChgGenVO.java
*@FileTitle : KrWhfChgGenVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.14 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfChgGenVO extends WhfChgVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfChgGenVO> models = new ArrayList<KrWhfChgGenVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFeu = null;
	/* Column Info */
	private String bkgTeu = null;
	/* Column Info */
	private String rtFeu = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String rtTeu = null;
	/* Column Info */
	private String bkgHcb = null;
	/* Column Info */
	private String rtHcb = null;
	/* Column Info */
	private String blCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfChgGenVO() {}

	public KrWhfChgGenVO(String ibflag, String pagerows, String rtTeu, String rtFeu, String rtHcb, String bkgTeu, String bkgFeu, String bkgHcb, String ttlAmt, String blCnt) {
		this.ibflag = ibflag;
		this.bkgFeu = bkgFeu;
		this.bkgTeu = bkgTeu;
		this.rtFeu = rtFeu;
		this.ttlAmt = ttlAmt;
		this.rtTeu = rtTeu;
		this.bkgHcb = bkgHcb;
		this.rtHcb = rtHcb;
		this.blCnt = blCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_feu", getBkgFeu());
		this.hashColumns.put("bkg_teu", getBkgTeu());
		this.hashColumns.put("rt_feu", getRtFeu());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("rt_teu", getRtTeu());
		this.hashColumns.put("bkg_hcb", getBkgHcb());
		this.hashColumns.put("rt_hcb", getRtHcb());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_feu", "bkgFeu");
		this.hashFields.put("bkg_teu", "bkgTeu");
		this.hashFields.put("rt_feu", "rtFeu");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("rt_teu", "rtTeu");
		this.hashFields.put("bkg_hcb", "bkgHcb");
		this.hashFields.put("rt_hcb", "rtHcb");
		this.hashFields.put("bl_cnt", "blCnt");
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
	 * @return bkgFeu
	 */
	public String getBkgFeu() {
		return this.bkgFeu;
	}
	
	/**
	 * Column Info
	 * @return bkgTeu
	 */
	public String getBkgTeu() {
		return this.bkgTeu;
	}
	
	/**
	 * Column Info
	 * @return rtFeu
	 */
	public String getRtFeu() {
		return this.rtFeu;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return rtTeu
	 */
	public String getRtTeu() {
		return this.rtTeu;
	}
	
	/**
	 * Column Info
	 * @return bkgHcb
	 */
	public String getBkgHcb() {
		return this.bkgHcb;
	}
	
	/**
	 * Column Info
	 * @return rtHcb
	 */
	public String getRtHcb() {
		return this.rtHcb;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
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
	 * @param bkgFeu
	 */
	public void setBkgFeu(String bkgFeu) {
		this.bkgFeu = bkgFeu;
	}
	
	/**
	 * Column Info
	 * @param bkgTeu
	 */
	public void setBkgTeu(String bkgTeu) {
		this.bkgTeu = bkgTeu;
	}
	
	/**
	 * Column Info
	 * @param rtFeu
	 */
	public void setRtFeu(String rtFeu) {
		this.rtFeu = rtFeu;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param rtTeu
	 */
	public void setRtTeu(String rtTeu) {
		this.rtTeu = rtTeu;
	}
	
	/**
	 * Column Info
	 * @param bkgHcb
	 */
	public void setBkgHcb(String bkgHcb) {
		this.bkgHcb = bkgHcb;
	}
	
	/**
	 * Column Info
	 * @param rtHcb
	 */
	public void setRtHcb(String rtHcb) {
		this.rtHcb = rtHcb;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setBkgFeu(JSPUtil.getParameter(request, "bkg_feu", ""));
		setBkgTeu(JSPUtil.getParameter(request, "bkg_teu", ""));
		setRtFeu(JSPUtil.getParameter(request, "rt_feu", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setRtTeu(JSPUtil.getParameter(request, "rt_teu", ""));
		setBkgHcb(JSPUtil.getParameter(request, "bkg_hcb", ""));
		setRtHcb(JSPUtil.getParameter(request, "rt_hcb", ""));
		setBlCnt(JSPUtil.getParameter(request, "bl_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfChgGenVO[]
	 */
	public KrWhfChgGenVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfChgGenVO[]
	 */
	public KrWhfChgGenVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfChgGenVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFeu = (JSPUtil.getParameter(request, prefix	+ "bkg_feu", length));
			String[] bkgTeu = (JSPUtil.getParameter(request, prefix	+ "bkg_teu", length));
			String[] rtFeu = (JSPUtil.getParameter(request, prefix	+ "rt_feu", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] rtTeu = (JSPUtil.getParameter(request, prefix	+ "rt_teu", length));
			String[] bkgHcb = (JSPUtil.getParameter(request, prefix	+ "bkg_hcb", length));
			String[] rtHcb = (JSPUtil.getParameter(request, prefix	+ "rt_hcb", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfChgGenVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFeu[i] != null)
					model.setBkgFeu(bkgFeu[i]);
				if (bkgTeu[i] != null)
					model.setBkgTeu(bkgTeu[i]);
				if (rtFeu[i] != null)
					model.setRtFeu(rtFeu[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (rtTeu[i] != null)
					model.setRtTeu(rtTeu[i]);
				if (bkgHcb[i] != null)
					model.setBkgHcb(bkgHcb[i]);
				if (rtHcb[i] != null)
					model.setRtHcb(rtHcb[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfChgGenVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfChgGenVO[]
	 */
	public KrWhfChgGenVO[] getKrWhfChgGenVOs(){
		KrWhfChgGenVO[] vos = (KrWhfChgGenVO[])models.toArray(new KrWhfChgGenVO[models.size()]);
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
		this.bkgFeu = this.bkgFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeu = this.bkgTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFeu = this.rtFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTeu = this.rtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHcb = this.bkgHcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtHcb = this.rtHcb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
