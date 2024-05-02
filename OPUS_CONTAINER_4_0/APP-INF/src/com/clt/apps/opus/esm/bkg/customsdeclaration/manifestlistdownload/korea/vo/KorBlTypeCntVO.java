/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorBlTypeCntVO.java
*@FileTitle : KorBlTypeCntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.06 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBlTypeCntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorBlTypeCntVO> models = new ArrayList<KorBlTypeCntVO>();

	/* Column Info */
	private String mrnPort = null;
	/* Column Info */
	private String blTpConsole = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String blTpSimple = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blTpEmpty = null;
	/* Column Info */
	private String mrnNbr = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorBlTypeCntVO() {}

	public KorBlTypeCntVO(String ibflag, String pagerows, String blTpSimple, String blTpConsole, String blTpEmpty, String vslCd, String skdVoyNo, String skdDirCd, String mrnNbr, String mrnPort) {
		this.mrnPort = mrnPort;
		this.blTpConsole = blTpConsole;
		this.vslCd = vslCd;
		this.blTpSimple = blTpSimple;
		this.ibflag = ibflag;
		this.blTpEmpty = blTpEmpty;
		this.mrnNbr = mrnNbr;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mrn_port", getMrnPort());
		this.hashColumns.put("bl_tp_console", getBlTpConsole());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bl_tp_simple", getBlTpSimple());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_tp_empty", getBlTpEmpty());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mrn_port", "mrnPort");
		this.hashFields.put("bl_tp_console", "blTpConsole");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bl_tp_simple", "blTpSimple");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_tp_empty", "blTpEmpty");
		this.hashFields.put("mrn_nbr", "mrnNbr");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return mrnPort
	 */
	public String getMrnPort() {
		return this.mrnPort;
	}

	/**
	 * Column Info
	 * @return blTpConsole
	 */
	public String getBlTpConsole() {
		return this.blTpConsole;
	}

	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * @return blTpSimple
	 */
	public String getBlTpSimple() {
		return this.blTpSimple;
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
	 * @return blTpEmpty
	 */
	public String getBlTpEmpty() {
		return this.blTpEmpty;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @param mrnPort
	 */
	public void setMrnPort(String mrnPort) {
		this.mrnPort = mrnPort;
	}

	/**
	 * Column Info
	 * @param blTpConsole
	 */
	public void setBlTpConsole(String blTpConsole) {
		this.blTpConsole = blTpConsole;
	}

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * @param blTpSimple
	 */
	public void setBlTpSimple(String blTpSimple) {
		this.blTpSimple = blTpSimple;
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
	 * @param blTpEmpty
	 */
	public void setBlTpEmpty(String blTpEmpty) {
		this.blTpEmpty = blTpEmpty;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMrnPort(JSPUtil.getParameter(request, "mrn_port", ""));
		setBlTpConsole(JSPUtil.getParameter(request, "bl_tp_console", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBlTpSimple(JSPUtil.getParameter(request, "bl_tp_simple", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBlTpEmpty(JSPUtil.getParameter(request, "bl_tp_empty", ""));
		setMrnNbr(JSPUtil.getParameter(request, "mrn_nbr", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBlTypeCntVO[]
	 */
	public KorBlTypeCntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorBlTypeCntVO[]
	 */
	public KorBlTypeCntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBlTypeCntVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] mrnPort = (JSPUtil.getParameter(request, prefix	+ "mrn_port", length));
			String[] blTpConsole = (JSPUtil.getParameter(request, prefix	+ "bl_tp_console", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blTpSimple = (JSPUtil.getParameter(request, prefix	+ "bl_tp_simple", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blTpEmpty = (JSPUtil.getParameter(request, prefix	+ "bl_tp_empty", length));
			String[] mrnNbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorBlTypeCntVO();
				if (mrnPort[i] != null)
					model.setMrnPort(mrnPort[i]);
				if (blTpConsole[i] != null)
					model.setBlTpConsole(blTpConsole[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blTpSimple[i] != null)
					model.setBlTpSimple(blTpSimple[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blTpEmpty[i] != null)
					model.setBlTpEmpty(blTpEmpty[i]);
				if (mrnNbr[i] != null)
					model.setMrnNbr(mrnNbr[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBlTypeCntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBlTypeCntVO[]
	 */
	public KorBlTypeCntVO[] getKorBlTypeCntVOs(){
		KorBlTypeCntVO[] vos = (KorBlTypeCntVO[])models.toArray(new KorBlTypeCntVO[models.size()]);
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
		this.mrnPort = this.mrnPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpConsole = this.blTpConsole .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpSimple = this.blTpSimple .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpEmpty = this.blTpEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNbr = this.mrnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
