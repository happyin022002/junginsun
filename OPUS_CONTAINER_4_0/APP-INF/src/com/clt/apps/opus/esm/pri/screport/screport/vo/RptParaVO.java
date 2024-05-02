/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RptParaVO.java
*@FileTitle : RptParaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.05 변영주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RptParaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RptParaVO> models = new ArrayList<RptParaVO>();
	
	/* Column Info */
	private String cdTp = null;
	/* Column Info */
	private String cd1 = null;
	/* Column Info */
	private String cd2 = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RptParaVO() {}

	public RptParaVO(String cdTp,String cd1,String cd2,String effDt,String expDt) {
		this.cdTp = cdTp;
		this.cd1 = cd1;
		this.cd2 = cd2;
		this.effDt = effDt;
		this.expDt = expDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cd_tp", getCdTp());
		this.hashColumns.put("cd1", getCd1());
		this.hashColumns.put("cd2", getCd2());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cd_tp", "cd_tp");
		this.hashFields.put("cd1", "cd1");
		this.hashFields.put("cd2", "cd2");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cdTp
	 */
	public String getCdTp() {
		return this.cdTp;
	}
	
	/**
	 * Column Info
	 * @return cd1
	 */
	public String getCd1() {
		return this.cd1;
	}
	
	/**
	 * Column Info
	 * @return cd2
	 */
	public String getCd2() {
		return this.cd2;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	


	/**
	 * Column Info
	 * @param cdTp
	 */
	public void setCdTp(String cdTp) {
		this.cdTp = cdTp;
	}
	
	/**
	 * Column Info
	 * @param cd1
	 */
	public void setCd1(String cd1) {
		this.cd1 = cd1;
	}
	
	/**
	 * Column Info
	 * @param cd2
	 */
	public void setCd2(String cd2) {
		this.cd2 = cd2;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCdTp(JSPUtil.getParameter(request, "cd_tp", ""));
		setCd1(JSPUtil.getParameter(request, "cd1", ""));
		setCd2(JSPUtil.getParameter(request, "cd2", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstPriSpcd1CpVO[]
	 */
	public RptParaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RptParaVO[]
	 */
	public RptParaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RptParaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cdTp = (JSPUtil.getParameter(request, prefix	+ "cd_tp".trim(), length));
			String[] cd1 = (JSPUtil.getParameter(request, prefix	+ "cd1".trim(), length));
			String[] cd2 = (JSPUtil.getParameter(request, prefix	+ "cd2".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new RptParaVO();
				if (cdTp[i] != null)
					model.setCdTp(cdTp[i]);
				if (cd1[i] != null)
					model.setCd1(cd1[i]);
				if (cd2[i] != null)
					model.setCd2(cd2[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRptParaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RptParaVO[]
	 */
	public RptParaVO[] getRptParaVOs(){
		RptParaVO[] vos = (RptParaVO[])models.toArray(new RptParaVO[models.size()]);
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
		this.cdTp = this.cdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd1 = this.cd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd2 = this.cd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
