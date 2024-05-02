/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffCodeVO.java
*@FileTitle : TariffCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.07.08 박명종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffCodeVO> models = new ArrayList<TariffCodeVO>();
	
	/* Column Info */
	private String psoChgTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgXprSeq = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String fomlNo = null;
	/* Column Info */
	private String chgXprNo = null;
	/* Column Info */
	private String ydChgXprNo = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String condNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TariffCodeVO() {}

	public TariffCodeVO(String ibflag, String pagerows, String ydChgNo, String ydChgVerSeq, String psoChgTpCd, String ydChgXprNo, String chgXprNo, String chgXprSeq, String condNo, String fomlNo) {
		this.psoChgTpCd = psoChgTpCd;
		this.ibflag = ibflag;
		this.chgXprSeq = chgXprSeq;
		this.ydChgVerSeq = ydChgVerSeq;
		this.fomlNo = fomlNo;
		this.chgXprNo = chgXprNo;
		this.ydChgXprNo = ydChgXprNo;
		this.ydChgNo = ydChgNo;
		this.condNo = condNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pso_chg_tp_cd", getPsoChgTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_xpr_seq", getChgXprSeq());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("foml_no", getFomlNo());
		this.hashColumns.put("chg_xpr_no", getChgXprNo());
		this.hashColumns.put("yd_chg_xpr_no", getYdChgXprNo());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("cond_no", getCondNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pso_chg_tp_cd", "psoChgTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_xpr_seq", "chgXprSeq");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("foml_no", "fomlNo");
		this.hashFields.put("chg_xpr_no", "chgXprNo");
		this.hashFields.put("yd_chg_xpr_no", "ydChgXprNo");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("cond_no", "condNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return psoChgTpCd
	 */
	public String getPsoChgTpCd() {
		return this.psoChgTpCd;
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
	 * @return chgXprSeq
	 */
	public String getChgXprSeq() {
		return this.chgXprSeq;
	}
	
	/**
	 * Column Info
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @return fomlNo
	 */
	public String getFomlNo() {
		return this.fomlNo;
	}
	
	/**
	 * Column Info
	 * @return chgXprNo
	 */
	public String getChgXprNo() {
		return this.chgXprNo;
	}
	
	/**
	 * Column Info
	 * @return ydChgXprNo
	 */
	public String getYdChgXprNo() {
		return this.ydChgXprNo;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}
	
	/**
	 * Column Info
	 * @return condNo
	 */
	public String getCondNo() {
		return this.condNo;
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
	 * @param psoChgTpCd
	 */
	public void setPsoChgTpCd(String psoChgTpCd) {
		this.psoChgTpCd = psoChgTpCd;
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
	 * @param chgXprSeq
	 */
	public void setChgXprSeq(String chgXprSeq) {
		this.chgXprSeq = chgXprSeq;
	}
	
	/**
	 * Column Info
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @param fomlNo
	 */
	public void setFomlNo(String fomlNo) {
		this.fomlNo = fomlNo;
	}
	
	/**
	 * Column Info
	 * @param chgXprNo
	 */
	public void setChgXprNo(String chgXprNo) {
		this.chgXprNo = chgXprNo;
	}
	
	/**
	 * Column Info
	 * @param ydChgXprNo
	 */
	public void setYdChgXprNo(String ydChgXprNo) {
		this.ydChgXprNo = ydChgXprNo;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}
	
	/**
	 * Column Info
	 * @param condNo
	 */
	public void setCondNo(String condNo) {
		this.condNo = condNo;
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
		setPsoChgTpCd(JSPUtil.getParameter(request, "pso_chg_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChgXprSeq(JSPUtil.getParameter(request, "chg_xpr_seq", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setFomlNo(JSPUtil.getParameter(request, "foml_no", ""));
		setChgXprNo(JSPUtil.getParameter(request, "chg_xpr_no", ""));
		setYdChgXprNo(JSPUtil.getParameter(request, "yd_chg_xpr_no", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setCondNo(JSPUtil.getParameter(request, "cond_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffCodeVO[]
	 */
	public TariffCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffCodeVO[]
	 */
	public TariffCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] psoChgTpCd = (JSPUtil.getParameter(request, prefix	+ "pso_chg_tp_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] chgXprSeq = (JSPUtil.getParameter(request, prefix	+ "chg_xpr_seq".trim(), length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq".trim(), length));
			String[] fomlNo = (JSPUtil.getParameter(request, prefix	+ "foml_no".trim(), length));
			String[] chgXprNo = (JSPUtil.getParameter(request, prefix	+ "chg_xpr_no".trim(), length));
			String[] ydChgXprNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_xpr_no".trim(), length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no".trim(), length));
			String[] condNo = (JSPUtil.getParameter(request, prefix	+ "cond_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffCodeVO();
				if (psoChgTpCd[i] != null)
					model.setPsoChgTpCd(psoChgTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgXprSeq[i] != null)
					model.setChgXprSeq(chgXprSeq[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (fomlNo[i] != null)
					model.setFomlNo(fomlNo[i]);
				if (chgXprNo[i] != null)
					model.setChgXprNo(chgXprNo[i]);
				if (ydChgXprNo[i] != null)
					model.setYdChgXprNo(ydChgXprNo[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (condNo[i] != null)
					model.setCondNo(condNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffCodeVO[]
	 */
	public TariffCodeVO[] getTariffCodeVOs(){
		TariffCodeVO[] vos = (TariffCodeVO[])models.toArray(new TariffCodeVO[models.size()]);
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
		this.psoChgTpCd = this.psoChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgXprSeq = this.chgXprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlNo = this.fomlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgXprNo = this.chgXprNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgXprNo = this.ydChgXprNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNo = this.condNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
