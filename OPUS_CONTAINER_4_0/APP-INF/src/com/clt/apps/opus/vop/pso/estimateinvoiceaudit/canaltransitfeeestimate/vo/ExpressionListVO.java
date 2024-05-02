/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpressionListVO.java
*@FileTitle : ExpressionListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.18 김진일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExpressionListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExpressionListVO> models = new ArrayList<ExpressionListVO>();
	
	/* Column Info */
	private String sysXprDesc = null;
	/* Column Info */
	private String psoChgTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dfltXprDesc = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String dfltSysXprDesc = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExpressionListVO() {}

	public ExpressionListVO(String ibflag, String pagerows, String psoChgTpCd, String dfltXprDesc, String sysXprDesc, String dfltSysXprDesc, String ydChgNo, String ydChgVerSeq) {
		this.sysXprDesc = sysXprDesc;
		this.psoChgTpCd = psoChgTpCd;
		this.ibflag = ibflag;
		this.dfltXprDesc = dfltXprDesc;
		this.ydChgVerSeq = ydChgVerSeq;
		this.dfltSysXprDesc = dfltSysXprDesc;
		this.ydChgNo = ydChgNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sys_xpr_desc", getSysXprDesc());
		this.hashColumns.put("pso_chg_tp_cd", getPsoChgTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dflt_xpr_desc", getDfltXprDesc());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("dflt_sys_xpr_desc", getDfltSysXprDesc());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sys_xpr_desc", "sysXprDesc");
		this.hashFields.put("pso_chg_tp_cd", "psoChgTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dflt_xpr_desc", "dfltXprDesc");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("dflt_sys_xpr_desc", "dfltSysXprDesc");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sysXprDesc
	 */
	public String getSysXprDesc() {
		return this.sysXprDesc;
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
	 * @return dfltXprDesc
	 */
	public String getDfltXprDesc() {
		return this.dfltXprDesc;
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
	 * @return dfltSysXprDesc
	 */
	public String getDfltSysXprDesc() {
		return this.dfltSysXprDesc;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
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
	 * @param sysXprDesc
	 */
	public void setSysXprDesc(String sysXprDesc) {
		this.sysXprDesc = sysXprDesc;
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
	 * @param dfltXprDesc
	 */
	public void setDfltXprDesc(String dfltXprDesc) {
		this.dfltXprDesc = dfltXprDesc;
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
	 * @param dfltSysXprDesc
	 */
	public void setDfltSysXprDesc(String dfltSysXprDesc) {
		this.dfltSysXprDesc = dfltSysXprDesc;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
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
		setSysXprDesc(JSPUtil.getParameter(request, "sys_xpr_desc", ""));
		setPsoChgTpCd(JSPUtil.getParameter(request, "pso_chg_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDfltXprDesc(JSPUtil.getParameter(request, "dflt_xpr_desc", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setDfltSysXprDesc(JSPUtil.getParameter(request, "dflt_sys_xpr_desc", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExpressionListVO[]
	 */
	public ExpressionListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExpressionListVO[]
	 */
	public ExpressionListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExpressionListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sysXprDesc = (JSPUtil.getParameter(request, prefix	+ "sys_xpr_desc", length));
			String[] psoChgTpCd = (JSPUtil.getParameter(request, prefix	+ "pso_chg_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dfltXprDesc = (JSPUtil.getParameter(request, prefix	+ "dflt_xpr_desc", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] dfltSysXprDesc = (JSPUtil.getParameter(request, prefix	+ "dflt_sys_xpr_desc", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExpressionListVO();
				if (sysXprDesc[i] != null)
					model.setSysXprDesc(sysXprDesc[i]);
				if (psoChgTpCd[i] != null)
					model.setPsoChgTpCd(psoChgTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dfltXprDesc[i] != null)
					model.setDfltXprDesc(dfltXprDesc[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (dfltSysXprDesc[i] != null)
					model.setDfltSysXprDesc(dfltSysXprDesc[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExpressionListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExpressionListVO[]
	 */
	public ExpressionListVO[] getExpressionListVOs(){
		ExpressionListVO[] vos = (ExpressionListVO[])models.toArray(new ExpressionListVO[models.size()]);
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
		this.sysXprDesc = this.sysXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoChgTpCd = this.psoChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltXprDesc = this.dfltXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltSysXprDesc = this.dfltSysXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
