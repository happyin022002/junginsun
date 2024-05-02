/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgImdgCompGrpSegrListVO.java
*@FileTitle : ScgImdgCompGrpSegrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.28 이도형 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo;

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

public class ScgImdgCompGrpSegrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgImdgCompGrpSegrListVO> models = new ArrayList<ScgImdgCompGrpSegrListVO>();
	
	/* Column Info */
	private String segrCdS = null;
	/* Column Info */
	private String segrCdN = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String segrCdK = null;
	/* Column Info */
	private String segrCdJ = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String segrCdL = null;
	/* Column Info */
	private String segrCdG = null;
	/* Column Info */
	private String segrCdF = null;
	/* Column Info */
	private String segrCdH = null;
	/* Column Info */
	private String rowImdgCompGrpCd = null;
	/* Column Info */
	private String segrCdC = null;
	/* Column Info */
	private String segrCdB = null;
	/* Column Info */
	private String segrCdE = null;
	/* Column Info */
	private String segrCdD = null;
	/* Column Info */
	private String segrCdA = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgImdgCompGrpSegrListVO() {}

	public ScgImdgCompGrpSegrListVO(String ibflag, String pagerows, String rowImdgCompGrpCd, String segrCdA, String segrCdB, String segrCdC, String segrCdD, String segrCdE, String segrCdF, String segrCdG, String segrCdH, String segrCdJ, String segrCdK, String segrCdL, String segrCdN, String segrCdS) {
		this.segrCdS = segrCdS;
		this.segrCdN = segrCdN;
		this.pagerows = pagerows;
		this.segrCdK = segrCdK;
		this.segrCdJ = segrCdJ;
		this.ibflag = ibflag;
		this.segrCdL = segrCdL;
		this.segrCdG = segrCdG;
		this.segrCdF = segrCdF;
		this.segrCdH = segrCdH;
		this.rowImdgCompGrpCd = rowImdgCompGrpCd;
		this.segrCdC = segrCdC;
		this.segrCdB = segrCdB;
		this.segrCdE = segrCdE;
		this.segrCdD = segrCdD;
		this.segrCdA = segrCdA;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("segr_cd_s", getSegrCdS());
		this.hashColumns.put("segr_cd_n", getSegrCdN());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("segr_cd_k", getSegrCdK());
		this.hashColumns.put("segr_cd_j", getSegrCdJ());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("segr_cd_l", getSegrCdL());
		this.hashColumns.put("segr_cd_g", getSegrCdG());
		this.hashColumns.put("segr_cd_f", getSegrCdF());
		this.hashColumns.put("segr_cd_h", getSegrCdH());
		this.hashColumns.put("row_imdg_comp_grp_cd", getRowImdgCompGrpCd());
		this.hashColumns.put("segr_cd_c", getSegrCdC());
		this.hashColumns.put("segr_cd_b", getSegrCdB());
		this.hashColumns.put("segr_cd_e", getSegrCdE());
		this.hashColumns.put("segr_cd_d", getSegrCdD());
		this.hashColumns.put("segr_cd_a", getSegrCdA());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("segr_cd_s", "segrCdS");
		this.hashFields.put("segr_cd_n", "segrCdN");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("segr_cd_k", "segrCdK");
		this.hashFields.put("segr_cd_j", "segrCdJ");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("segr_cd_l", "segrCdL");
		this.hashFields.put("segr_cd_g", "segrCdG");
		this.hashFields.put("segr_cd_f", "segrCdF");
		this.hashFields.put("segr_cd_h", "segrCdH");
		this.hashFields.put("row_imdg_comp_grp_cd", "rowImdgCompGrpCd");
		this.hashFields.put("segr_cd_c", "segrCdC");
		this.hashFields.put("segr_cd_b", "segrCdB");
		this.hashFields.put("segr_cd_e", "segrCdE");
		this.hashFields.put("segr_cd_d", "segrCdD");
		this.hashFields.put("segr_cd_a", "segrCdA");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return segrCdS
	 */
	public String getSegrCdS() {
		return this.segrCdS;
	}
	
	/**
	 * Column Info
	 * @return segrCdN
	 */
	public String getSegrCdN() {
		return this.segrCdN;
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
	 * @return segrCdK
	 */
	public String getSegrCdK() {
		return this.segrCdK;
	}
	
	/**
	 * Column Info
	 * @return segrCdJ
	 */
	public String getSegrCdJ() {
		return this.segrCdJ;
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
	 * @return segrCdL
	 */
	public String getSegrCdL() {
		return this.segrCdL;
	}
	
	/**
	 * Column Info
	 * @return segrCdG
	 */
	public String getSegrCdG() {
		return this.segrCdG;
	}
	
	/**
	 * Column Info
	 * @return segrCdF
	 */
	public String getSegrCdF() {
		return this.segrCdF;
	}
	
	/**
	 * Column Info
	 * @return segrCdH
	 */
	public String getSegrCdH() {
		return this.segrCdH;
	}
	
	/**
	 * Column Info
	 * @return rowImdgCompGrpCd
	 */
	public String getRowImdgCompGrpCd() {
		return this.rowImdgCompGrpCd;
	}
	
	/**
	 * Column Info
	 * @return segrCdC
	 */
	public String getSegrCdC() {
		return this.segrCdC;
	}
	
	/**
	 * Column Info
	 * @return segrCdB
	 */
	public String getSegrCdB() {
		return this.segrCdB;
	}
	
	/**
	 * Column Info
	 * @return segrCdE
	 */
	public String getSegrCdE() {
		return this.segrCdE;
	}
	
	/**
	 * Column Info
	 * @return segrCdD
	 */
	public String getSegrCdD() {
		return this.segrCdD;
	}
	
	/**
	 * Column Info
	 * @return segrCdA
	 */
	public String getSegrCdA() {
		return this.segrCdA;
	}
	

	/**
	 * Column Info
	 * @param segrCdS
	 */
	public void setSegrCdS(String segrCdS) {
		this.segrCdS = segrCdS;
	}
	
	/**
	 * Column Info
	 * @param segrCdN
	 */
	public void setSegrCdN(String segrCdN) {
		this.segrCdN = segrCdN;
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
	 * @param segrCdK
	 */
	public void setSegrCdK(String segrCdK) {
		this.segrCdK = segrCdK;
	}
	
	/**
	 * Column Info
	 * @param segrCdJ
	 */
	public void setSegrCdJ(String segrCdJ) {
		this.segrCdJ = segrCdJ;
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
	 * @param segrCdL
	 */
	public void setSegrCdL(String segrCdL) {
		this.segrCdL = segrCdL;
	}
	
	/**
	 * Column Info
	 * @param segrCdG
	 */
	public void setSegrCdG(String segrCdG) {
		this.segrCdG = segrCdG;
	}
	
	/**
	 * Column Info
	 * @param segrCdF
	 */
	public void setSegrCdF(String segrCdF) {
		this.segrCdF = segrCdF;
	}
	
	/**
	 * Column Info
	 * @param segrCdH
	 */
	public void setSegrCdH(String segrCdH) {
		this.segrCdH = segrCdH;
	}
	
	/**
	 * Column Info
	 * @param rowImdgCompGrpCd
	 */
	public void setRowImdgCompGrpCd(String rowImdgCompGrpCd) {
		this.rowImdgCompGrpCd = rowImdgCompGrpCd;
	}
	
	/**
	 * Column Info
	 * @param segrCdC
	 */
	public void setSegrCdC(String segrCdC) {
		this.segrCdC = segrCdC;
	}
	
	/**
	 * Column Info
	 * @param segrCdB
	 */
	public void setSegrCdB(String segrCdB) {
		this.segrCdB = segrCdB;
	}
	
	/**
	 * Column Info
	 * @param segrCdE
	 */
	public void setSegrCdE(String segrCdE) {
		this.segrCdE = segrCdE;
	}
	
	/**
	 * Column Info
	 * @param segrCdD
	 */
	public void setSegrCdD(String segrCdD) {
		this.segrCdD = segrCdD;
	}
	
	/**
	 * Column Info
	 * @param segrCdA
	 */
	public void setSegrCdA(String segrCdA) {
		this.segrCdA = segrCdA;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSegrCdS(JSPUtil.getParameter(request, "segr_cd_s", ""));
		setSegrCdN(JSPUtil.getParameter(request, "segr_cd_n", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSegrCdK(JSPUtil.getParameter(request, "segr_cd_k", ""));
		setSegrCdJ(JSPUtil.getParameter(request, "segr_cd_j", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSegrCdL(JSPUtil.getParameter(request, "segr_cd_l", ""));
		setSegrCdG(JSPUtil.getParameter(request, "segr_cd_g", ""));
		setSegrCdF(JSPUtil.getParameter(request, "segr_cd_f", ""));
		setSegrCdH(JSPUtil.getParameter(request, "segr_cd_h", ""));
		setRowImdgCompGrpCd(JSPUtil.getParameter(request, "row_imdg_comp_grp_cd", ""));
		setSegrCdC(JSPUtil.getParameter(request, "segr_cd_c", ""));
		setSegrCdB(JSPUtil.getParameter(request, "segr_cd_b", ""));
		setSegrCdE(JSPUtil.getParameter(request, "segr_cd_e", ""));
		setSegrCdD(JSPUtil.getParameter(request, "segr_cd_d", ""));
		setSegrCdA(JSPUtil.getParameter(request, "segr_cd_a", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgImdgCompGrpSegrListVO[]
	 */
	public ScgImdgCompGrpSegrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgImdgCompGrpSegrListVO[]
	 */
	public ScgImdgCompGrpSegrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgImdgCompGrpSegrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] segrCdS = (JSPUtil.getParameter(request, prefix	+ "segr_cd_s".trim(), length));
			String[] segrCdN = (JSPUtil.getParameter(request, prefix	+ "segr_cd_n".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] segrCdK = (JSPUtil.getParameter(request, prefix	+ "segr_cd_k".trim(), length));
			String[] segrCdJ = (JSPUtil.getParameter(request, prefix	+ "segr_cd_j".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] segrCdL = (JSPUtil.getParameter(request, prefix	+ "segr_cd_l".trim(), length));
			String[] segrCdG = (JSPUtil.getParameter(request, prefix	+ "segr_cd_g".trim(), length));
			String[] segrCdF = (JSPUtil.getParameter(request, prefix	+ "segr_cd_f".trim(), length));
			String[] segrCdH = (JSPUtil.getParameter(request, prefix	+ "segr_cd_h".trim(), length));
			String[] rowImdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "row_imdg_comp_grp_cd".trim(), length));
			String[] segrCdC = (JSPUtil.getParameter(request, prefix	+ "segr_cd_c".trim(), length));
			String[] segrCdB = (JSPUtil.getParameter(request, prefix	+ "segr_cd_b".trim(), length));
			String[] segrCdE = (JSPUtil.getParameter(request, prefix	+ "segr_cd_e".trim(), length));
			String[] segrCdD = (JSPUtil.getParameter(request, prefix	+ "segr_cd_d".trim(), length));
			String[] segrCdA = (JSPUtil.getParameter(request, prefix	+ "segr_cd_a".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgImdgCompGrpSegrListVO();
				if (segrCdS[i] != null)
					model.setSegrCdS(segrCdS[i]);
				if (segrCdN[i] != null)
					model.setSegrCdN(segrCdN[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (segrCdK[i] != null)
					model.setSegrCdK(segrCdK[i]);
				if (segrCdJ[i] != null)
					model.setSegrCdJ(segrCdJ[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (segrCdL[i] != null)
					model.setSegrCdL(segrCdL[i]);
				if (segrCdG[i] != null)
					model.setSegrCdG(segrCdG[i]);
				if (segrCdF[i] != null)
					model.setSegrCdF(segrCdF[i]);
				if (segrCdH[i] != null)
					model.setSegrCdH(segrCdH[i]);
				if (rowImdgCompGrpCd[i] != null)
					model.setRowImdgCompGrpCd(rowImdgCompGrpCd[i]);
				if (segrCdC[i] != null)
					model.setSegrCdC(segrCdC[i]);
				if (segrCdB[i] != null)
					model.setSegrCdB(segrCdB[i]);
				if (segrCdE[i] != null)
					model.setSegrCdE(segrCdE[i]);
				if (segrCdD[i] != null)
					model.setSegrCdD(segrCdD[i]);
				if (segrCdA[i] != null)
					model.setSegrCdA(segrCdA[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgImdgCompGrpSegrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgImdgCompGrpSegrListVO[]
	 */
	public ScgImdgCompGrpSegrListVO[] getScgImdgCompGrpSegrListVOs(){
		ScgImdgCompGrpSegrListVO[] vos = (ScgImdgCompGrpSegrListVO[])models.toArray(new ScgImdgCompGrpSegrListVO[models.size()]);
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
		this.segrCdS = this.segrCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdN = this.segrCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdK = this.segrCdK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdJ = this.segrCdJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdL = this.segrCdL .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdG = this.segrCdG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdF = this.segrCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdH = this.segrCdH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowImdgCompGrpCd = this.rowImdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdC = this.segrCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdB = this.segrCdB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdE = this.segrCdE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdD = this.segrCdD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrCdA = this.segrCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
