/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInterfaceCreationVO.java
*@FileTitle : ARInterfaceCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.09.15 정휘택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInterfaceCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInterfaceCreationVO> models = new ArrayList<ARInterfaceCreationVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private InvArIfMnVO invArIfMnVO = null;	
	private InvArIfChgVO invArIfChgVO = null;
	private InvArIfCntrVO invArIfCntrVO = null;
	
	private List<InvArIfMnVO> invArIfMnVOs = null;
	private List<InvArIfChgVO> invArIfChgVOs = null;
	private List<InvArIfCntrVO> invArIfCntrVOs = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInterfaceCreationVO() {}

	public ARInterfaceCreationVO(String ibflag, String pagerows, String a) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("a", "a");
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @return the invArIfChgVO
	 */
	public InvArIfChgVO getInvArIfChgVO() {
		return invArIfChgVO;
	}

	/**
	 * @param invArIfChgVO the invArIfChgVO to set
	 */
	public void setInvArIfChgVO(InvArIfChgVO invArIfChgVO) {
		this.invArIfChgVO = invArIfChgVO;
	}

	/**
	 * @return the invArIfCntrVO
	 */
	public InvArIfCntrVO getInvArIfCntrVO() {
		return invArIfCntrVO;
	}

	/**
	 * @param invArIfCntrVO the invArIfCntrVO to set
	 */
	public void setInvArIfCntrVO(InvArIfCntrVO invArIfCntrVO) {
		this.invArIfCntrVO = invArIfCntrVO;
	}

	/**
	 * @return the invArIfMnVO
	 */
	public InvArIfMnVO getInvArIfMnVO() {
		return invArIfMnVO;
	}

	/**
	 * @param invArIfMnVO the invArIfMnVO to set
	 */
	public void setInvArIfMnVO(InvArIfMnVO invArIfMnVO) {
		this.invArIfMnVO = invArIfMnVO;
	}

	/**
	 * @return the invArIfChgVOs
	 */
	public List<InvArIfChgVO> getInvArIfChgVOs() {
		return invArIfChgVOs;
	}

	/**
	 * @param invArIfChgVOs the invArIfChgVOs to set
	 */
	public void setInvArIfChgVOs(List<InvArIfChgVO> invArIfChgVOs) {
		this.invArIfChgVOs = invArIfChgVOs;
	}

	/**
	 * @return the invArIfCntrVOs
	 */
	public List<InvArIfCntrVO> getInvArIfCntrVOs() {
		return invArIfCntrVOs;
	}

	/**
	 * @param invArIfCntrVOs the invArIfCntrVOs to set
	 */
	public void setInvArIfCntrVOs(List<InvArIfCntrVO> invArIfCntrVOs) {
		this.invArIfCntrVOs = invArIfCntrVOs;
	}

	/**
	 * @return the invArIfMnVOs
	 */
	public List<InvArIfMnVO> getInvArIfMnVOs() {
		return invArIfMnVOs;
	}

	/**
	 * @param invArIfMnVOs the invArIfMnVOs to set
	 */
	public void setInvArIfMnVOs(List<InvArIfMnVO> invArIfMnVOs) {
		this.invArIfMnVOs = invArIfMnVOs;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInterfaceCreationVO[]
	 */
	public ARInterfaceCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInterfaceCreationVO[]
	 */
	public ARInterfaceCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInterfaceCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInterfaceCreationVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInterfaceCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInterfaceCreationVO[]
	 */
	public ARInterfaceCreationVO[] getARInterfaceCreationVOs(){
		ARInterfaceCreationVO[] vos = (ARInterfaceCreationVO[])models.toArray(new ARInterfaceCreationVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
