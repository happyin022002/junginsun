/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInterfaceCreationVO.java
*@FileTitle : ARInterfaceCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.07 최도순 
* 1.0 Creation
=========================================================*/

package  com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInterfaceCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInterfaceCreationVO> models = new ArrayList<ARInterfaceCreationVO>();
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArIfChgVO invArIfChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArIfChgVO> invArIfChgVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArIfCntrVO invArIfCntrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArIfCntrVO> invArIfCntrVOs;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArIfMnVO invArIfMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArIfMnVO> invArIfMnVOs;	
	
	/* Column Info */
	private String bkgCorrDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String manDivInd = null;
	/* Column Info */
	private String bkgDiv = null;
	/* Column Info */
	private String userId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInterfaceCreationVO() {}

	public ARInterfaceCreationVO(String ibflag, String pagerows, String bkgNo, String bkgCorrNo, String bkgCorrDt, String vvdCd, String manDivInd, String bkgDiv, String userId) {
		this.bkgCorrDt = bkgCorrDt;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.bkgCorrNo = bkgCorrNo;
		this.manDivInd = manDivInd;
		this.bkgDiv = bkgDiv;
		this.userId = userId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_corr_dt", getBkgCorrDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("man_div_ind", getManDivInd());
		this.hashColumns.put("bkg_div", getBkgDiv());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_corr_dt", "bkgCorrDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("man_div_ind", "manDivInd");
		this.hashFields.put("bkg_div", "bkgDiv");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the bkgDiv
	 */
	public String getBkgDiv() {
		return bkgDiv;
	}

	/**
	 * @param bkgDiv the bkgDiv to set
	 */
	public void setBkgDiv(String bkgDiv) {
		this.bkgDiv = bkgDiv;
	}

	/**
	 * Column Info
	 * @return bkgCorrDt
	 */
	public String getBkgCorrDt() {
		return this.bkgCorrDt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrNo
	 */
	public String getBkgCorrNo() {
		return this.bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @return manDivInd
	 */
	public String getManDivInd() {
		return this.manDivInd;
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
	 * @param bkgCorrDt
	 */
	public void setBkgCorrDt(String bkgCorrDt) {
		this.bkgCorrDt = bkgCorrDt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrNo
	 */
	public void setBkgCorrNo(String bkgCorrNo) {
		this.bkgCorrNo = bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @param manDivInd
	 */
	public void setManDivInd(String manDivInd) {
		this.manDivInd = manDivInd;
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
		setBkgCorrDt(JSPUtil.getParameter(request, "bkg_corr_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, "bkg_corr_no", ""));
		setManDivInd(JSPUtil.getParameter(request, "man_div_ind", ""));
		setBkgDiv(JSPUtil.getParameter(request, "bkg_div", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
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
			String[] bkgCorrDt = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] manDivInd = (JSPUtil.getParameter(request, prefix	+ "man_div_ind", length));
			String[] bkgDiv = (JSPUtil.getParameter(request, prefix	+ "bkg_div", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInterfaceCreationVO();
				if (bkgCorrDt[i] != null)
					model.setBkgCorrDt(bkgCorrDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (manDivInd[i] != null)
					model.setManDivInd(manDivInd[i]);
				if (bkgDiv[i] != null)
					model.setBkgDiv(bkgDiv[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bkgCorrDt = this.bkgCorrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manDivInd = this.manDivInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDiv = this.bkgDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
