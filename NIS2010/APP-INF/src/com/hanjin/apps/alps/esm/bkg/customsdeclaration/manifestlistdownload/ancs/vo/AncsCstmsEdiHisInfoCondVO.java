/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsEdiHisInfoCondVO.java
*@FileTitle : AncsCstmsEdiHisInfoCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.29 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsEdiHisInfoCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsEdiHisInfoCondVO> models = new ArrayList<AncsCstmsEdiHisInfoCondVO>();
	
	/* Column Info */
	private String refSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgTpCd = null;
	/* Column Info */
	private String anrDeclNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsEdiHisInfoCondVO() {}

	public AncsCstmsEdiHisInfoCondVO(String ibflag, String pagerows, String msgTpCd, String anrDeclNo, String refSeq) {
		this.refSeq = refSeq;
		this.ibflag = ibflag;
		this.msgTpCd = msgTpCd;
		this.anrDeclNo = anrDeclNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_tp_cd", getMsgTpCd());
		this.hashColumns.put("anr_decl_no", getAnrDeclNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_tp_cd", "msgTpCd");
		this.hashFields.put("anr_decl_no", "anrDeclNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
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
	 * @return msgTpCd
	 */
	public String getMsgTpCd() {
		return this.msgTpCd;
	}
	
	/**
	 * Column Info
	 * @return anrDeclNo
	 */
	public String getAnrDeclNo() {
		return this.anrDeclNo;
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
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
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
	 * @param msgTpCd
	 */
	public void setMsgTpCd(String msgTpCd) {
		this.msgTpCd = msgTpCd;
	}
	
	/**
	 * Column Info
	 * @param anrDeclNo
	 */
	public void setAnrDeclNo(String anrDeclNo) {
		this.anrDeclNo = anrDeclNo;
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
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMsgTpCd(JSPUtil.getParameter(request, "msg_tp_cd", ""));
		setAnrDeclNo(JSPUtil.getParameter(request, "anr_decl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsEdiHisInfoCondVO[]
	 */
	public AncsCstmsEdiHisInfoCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsEdiHisInfoCondVO[]
	 */
	public AncsCstmsEdiHisInfoCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsEdiHisInfoCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgTpCd = (JSPUtil.getParameter(request, prefix	+ "msg_tp_cd", length));
			String[] anrDeclNo = (JSPUtil.getParameter(request, prefix	+ "anr_decl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsEdiHisInfoCondVO();
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgTpCd[i] != null)
					model.setMsgTpCd(msgTpCd[i]);
				if (anrDeclNo[i] != null)
					model.setAnrDeclNo(anrDeclNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsEdiHisInfoCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsEdiHisInfoCondVO[]
	 */
	public AncsCstmsEdiHisInfoCondVO[] getAncsCstmsEdiHisInfoCondVOs(){
		AncsCstmsEdiHisInfoCondVO[] vos = (AncsCstmsEdiHisInfoCondVO[])models.toArray(new AncsCstmsEdiHisInfoCondVO[models.size()]);
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
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTpCd = this.msgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrDeclNo = this.anrDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
