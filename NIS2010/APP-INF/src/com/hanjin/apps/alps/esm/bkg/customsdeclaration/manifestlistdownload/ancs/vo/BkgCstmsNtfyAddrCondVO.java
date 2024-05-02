/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsNtfyAddrCondVO.java
*@FileTitle : AncsCstmsNtfyAddrCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.15 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
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

public class BkgCstmsNtfyAddrCondVO extends CstmsNtfyAddrCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsNtfyAddrCondVO> models = new ArrayList<BkgCstmsNtfyAddrCondVO>();
	
	/* Column Info */
	private String keyAddr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String addrSeq = null;
	/* Page Number */
	private String pagerows = null;

	private String updOfcCd = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsNtfyAddrCondVO() {}

	public BkgCstmsNtfyAddrCondVO(String ibflag, String pagerows, String addrSeq, String keyAddr, String updOfcCd) {
		this.keyAddr = keyAddr;
		this.ibflag = ibflag;
		this.addrSeq = addrSeq;
		this.pagerows = pagerows;
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("key_addr", getKeyAddr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("addr_seq", getAddrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("key_addr", "keyAddr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("addr_seq", "addrSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		return this.hashFields;
	}
	
	
	
	public String getUpdOfcCd() {
		return updOfcCd;
	}

	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}

	/**
	 * Column Info
	 * @return keyAddr
	 */
	public String getKeyAddr() {
		return this.keyAddr;
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
	 * @return addrSeq
	 */
	public String getAddrSeq() {
		return this.addrSeq;
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
	 * @param keyAddr
	 */
	public void setKeyAddr(String keyAddr) {
		this.keyAddr = keyAddr;
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
	 * @param addrSeq
	 */
	public void setAddrSeq(String addrSeq) {
		this.addrSeq = addrSeq;
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
		setKeyAddr(JSPUtil.getParameter(request, "key_addr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAddrSeq(JSPUtil.getParameter(request, "addr_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsNtfyAddrCondVO[]
	 */
	public BkgCstmsNtfyAddrCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsNtfyAddrCondVO[]
	 */
	public BkgCstmsNtfyAddrCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsNtfyAddrCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] keyAddr = (JSPUtil.getParameter(request, prefix	+ "key_addr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] addrSeq = (JSPUtil.getParameter(request, prefix	+ "addr_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsNtfyAddrCondVO();
				if (keyAddr[i] != null)
					model.setKeyAddr(keyAddr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (addrSeq[i] != null)
					model.setAddrSeq(addrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsNtfyAddrCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsNtfyAddrCondVO[]
	 */
	public BkgCstmsNtfyAddrCondVO[] getAncsCstmsNtfyAddrCondVOs(){
		BkgCstmsNtfyAddrCondVO[] vos = (BkgCstmsNtfyAddrCondVO[])models.toArray(new BkgCstmsNtfyAddrCondVO[models.size()]);
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
		this.keyAddr = this.keyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrSeq = this.addrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
