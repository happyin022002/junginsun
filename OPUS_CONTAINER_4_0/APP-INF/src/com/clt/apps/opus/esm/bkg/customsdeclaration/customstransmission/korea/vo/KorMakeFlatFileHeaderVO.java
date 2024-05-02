/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMakeFlatFileHeaderVO.java
*@FileTitle : KorMakeFlatFileHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMakeFlatFileHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorMakeFlatFileHeaderVO> models = new ArrayList<KorMakeFlatFileHeaderVO>();

	/* Column Info */
	private String vndrScac = null;
	/* Column Info */
	private String flatData = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imCustoms = null;
	/* Column Info */
	private String mrnNbr = null;
	/* Column Info */
	private String locCustoms = null;
	/* Column Info */
	private String kvDiscCo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorMakeFlatFileHeaderVO() {}

	public KorMakeFlatFileHeaderVO(String ibflag, String pagerows, String mrnNbr, String vndrScac, String kvDiscCo, String imCustoms, String locCustoms, String flatData) {
		this.vndrScac = vndrScac;
		this.flatData = flatData;
		this.ibflag = ibflag;
		this.imCustoms = imCustoms;
		this.mrnNbr = mrnNbr;
		this.locCustoms = locCustoms;
		this.kvDiscCo = kvDiscCo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_scac", getVndrScac());
		this.hashColumns.put("flat_data", getFlatData());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("im_customs", getImCustoms());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("loc_customs", getLocCustoms());
		this.hashColumns.put("kv_disc_co", getKvDiscCo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_scac", "vndrScac");
		this.hashFields.put("flat_data", "flatData");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("im_customs", "imCustoms");
		this.hashFields.put("mrn_nbr", "mrnNbr");
		this.hashFields.put("loc_customs", "locCustoms");
		this.hashFields.put("kv_disc_co", "kvDiscCo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return vndrScac
	 */
	public String getVndrScac() {
		return this.vndrScac;
	}

	/**
	 * Column Info
	 * @return flatData
	 */
	public String getFlatData() {
		return this.flatData;
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
	 * @return imCustoms
	 */
	public String getImCustoms() {
		return this.imCustoms;
	}

	/**
	 * Column Info
	 * @return mrnNbr
	 */
	public String getMrnNbr() {
		return this.mrnNbr;
	}

	/**
	 * Column Info
	 * @return locCustoms
	 */
	public String getLocCustoms() {
		return this.locCustoms;
	}

	/**
	 * Column Info
	 * @return kvDiscCo
	 */
	public String getKvDiscCo() {
		return this.kvDiscCo;
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
	 * @param vndrScac
	 */
	public void setVndrScac(String vndrScac) {
		this.vndrScac = vndrScac;
	}

	/**
	 * Column Info
	 * @param flatData
	 */
	public void setFlatData(String flatData) {
		this.flatData = flatData;
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
	 * @param imCustoms
	 */
	public void setImCustoms(String imCustoms) {
		this.imCustoms = imCustoms;
	}

	/**
	 * Column Info
	 * @param mrnNbr
	 */
	public void setMrnNbr(String mrnNbr) {
		this.mrnNbr = mrnNbr;
	}

	/**
	 * Column Info
	 * @param locCustoms
	 */
	public void setLocCustoms(String locCustoms) {
		this.locCustoms = locCustoms;
	}

	/**
	 * Column Info
	 * @param kvDiscCo
	 */
	public void setKvDiscCo(String kvDiscCo) {
		this.kvDiscCo = kvDiscCo;
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
		setVndrScac(JSPUtil.getParameter(request, "vndr_scac", ""));
		setFlatData(JSPUtil.getParameter(request, "flat_data", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setImCustoms(JSPUtil.getParameter(request, "im_customs", ""));
		setMrnNbr(JSPUtil.getParameter(request, "mrn_nbr", ""));
		setLocCustoms(JSPUtil.getParameter(request, "loc_customs", ""));
		setKvDiscCo(JSPUtil.getParameter(request, "kv_disc_co", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMakeFlatFileHeaderVO[]
	 */
	public KorMakeFlatFileHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorMakeFlatFileHeaderVO[]
	 */
	public KorMakeFlatFileHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMakeFlatFileHeaderVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vndrScac = (JSPUtil.getParameter(request, prefix	+ "vndr_scac", length));
			String[] flatData = (JSPUtil.getParameter(request, prefix	+ "flat_data", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imCustoms = (JSPUtil.getParameter(request, prefix	+ "im_customs", length));
			String[] mrnNbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr", length));
			String[] locCustoms = (JSPUtil.getParameter(request, prefix	+ "loc_customs", length));
			String[] kvDiscCo = (JSPUtil.getParameter(request, prefix	+ "kv_disc_co", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorMakeFlatFileHeaderVO();
				if (vndrScac[i] != null)
					model.setVndrScac(vndrScac[i]);
				if (flatData[i] != null)
					model.setFlatData(flatData[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imCustoms[i] != null)
					model.setImCustoms(imCustoms[i]);
				if (mrnNbr[i] != null)
					model.setMrnNbr(mrnNbr[i]);
				if (locCustoms[i] != null)
					model.setLocCustoms(locCustoms[i]);
				if (kvDiscCo[i] != null)
					model.setKvDiscCo(kvDiscCo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMakeFlatFileHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMakeFlatFileHeaderVO[]
	 */
	public KorMakeFlatFileHeaderVO[] getKorMakeFlatFileHeaderVOs(){
		KorMakeFlatFileHeaderVO[] vos = (KorMakeFlatFileHeaderVO[])models.toArray(new KorMakeFlatFileHeaderVO[models.size()]);
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
		this.vndrScac = this.vndrScac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatData = this.flatData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imCustoms = this.imCustoms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNbr = this.mrnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCustoms = this.locCustoms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvDiscCo = this.kvDiscCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
