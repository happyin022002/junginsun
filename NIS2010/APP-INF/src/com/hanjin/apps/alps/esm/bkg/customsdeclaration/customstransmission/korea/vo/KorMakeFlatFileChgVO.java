/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMakeFlatFileChgVO.java
*@FileTitle : KorMakeFlatFileChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMakeFlatFileChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorMakeFlatFileChgVO> models = new ArrayList<KorMakeFlatFileChgVO>();
	
	/* Column Info */
	private String mdata2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mdata1 = null;
	/* Column Info */
	private String mdata3 = null;
	/* Column Info */
	private String mcorrCd = null;
	/* Column Info */
	private String corrData = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorMakeFlatFileChgVO() {}

	public KorMakeFlatFileChgVO(String ibflag, String pagerows, String mcorrCd, String mdata1, String mdata2, String mdata3, String corrData) {
		this.mdata2 = mdata2;
		this.ibflag = ibflag;
		this.mdata1 = mdata1;
		this.mdata3 = mdata3;
		this.mcorrCd = mcorrCd;
		this.corrData = corrData;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mdata2", getMdata2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mdata1", getMdata1());
		this.hashColumns.put("mdata3", getMdata3());
		this.hashColumns.put("mcorr_cd", getMcorrCd());
		this.hashColumns.put("corr_data", getCorrData());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mdata2", "mdata2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mdata1", "mdata1");
		this.hashFields.put("mdata3", "mdata3");
		this.hashFields.put("mcorr_cd", "mcorrCd");
		this.hashFields.put("corr_data", "corrData");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mdata2
	 */
	public String getMdata2() {
		return this.mdata2;
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
	 * @return mdata1
	 */
	public String getMdata1() {
		return this.mdata1;
	}
	
	/**
	 * Column Info
	 * @return mdata3
	 */
	public String getMdata3() {
		return this.mdata3;
	}
	
	/**
	 * Column Info
	 * @return mcorrCd
	 */
	public String getMcorrCd() {
		return this.mcorrCd;
	}
	
	/**
	 * Column Info
	 * @return corrData
	 */
	public String getCorrData() {
		return this.corrData;
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
	 * @param mdata2
	 */
	public void setMdata2(String mdata2) {
		this.mdata2 = mdata2;
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
	 * @param mdata1
	 */
	public void setMdata1(String mdata1) {
		this.mdata1 = mdata1;
	}
	
	/**
	 * Column Info
	 * @param mdata3
	 */
	public void setMdata3(String mdata3) {
		this.mdata3 = mdata3;
	}
	
	/**
	 * Column Info
	 * @param mcorrCd
	 */
	public void setMcorrCd(String mcorrCd) {
		this.mcorrCd = mcorrCd;
	}
	
	/**
	 * Column Info
	 * @param corrData
	 */
	public void setCorrData(String corrData) {
		this.corrData = corrData;
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
		setMdata2(JSPUtil.getParameter(request, "mdata2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMdata1(JSPUtil.getParameter(request, "mdata1", ""));
		setMdata3(JSPUtil.getParameter(request, "mdata3", ""));
		setMcorrCd(JSPUtil.getParameter(request, "mcorr_cd", ""));
		setCorrData(JSPUtil.getParameter(request, "corr_data", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMakeFlatFileChgVO[]
	 */
	public KorMakeFlatFileChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorMakeFlatFileChgVO[]
	 */
	public KorMakeFlatFileChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMakeFlatFileChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mdata2 = (JSPUtil.getParameter(request, prefix	+ "mdata2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mdata1 = (JSPUtil.getParameter(request, prefix	+ "mdata1", length));
			String[] mdata3 = (JSPUtil.getParameter(request, prefix	+ "mdata3", length));
			String[] mcorrCd = (JSPUtil.getParameter(request, prefix	+ "mcorr_cd", length));
			String[] corrData = (JSPUtil.getParameter(request, prefix	+ "corr_data", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorMakeFlatFileChgVO();
				if (mdata2[i] != null)
					model.setMdata2(mdata2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mdata1[i] != null)
					model.setMdata1(mdata1[i]);
				if (mdata3[i] != null)
					model.setMdata3(mdata3[i]);
				if (mcorrCd[i] != null)
					model.setMcorrCd(mcorrCd[i]);
				if (corrData[i] != null)
					model.setCorrData(corrData[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMakeFlatFileChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMakeFlatFileChgVO[]
	 */
	public KorMakeFlatFileChgVO[] getKorMakeFlatFileChgVOs(){
		KorMakeFlatFileChgVO[] vos = (KorMakeFlatFileChgVO[])models.toArray(new KorMakeFlatFileChgVO[models.size()]);
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
		this.mdata2 = this.mdata2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdata1 = this.mdata1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdata3 = this.mdata3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcorrCd = this.mcorrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrData = this.corrData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}