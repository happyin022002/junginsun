/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCustAvcNtcFaxSndVO.java
*@FileTitle : BkgCustAvcNtcFaxSndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 이인영
*@LastVersion : 1.0
* 2011.07.12 이인영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.vo.ReportDesignerExportVO;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이인영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCustAvcNtcFaxSndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrNm = null;
	/* Column Info */
	private String  vvd= null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String subTitle = null;
	/* Column Info */
	private String ofcCd = null;

	public BkgCustAvcNtcFaxSndVO() {}
	
	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getCntrNm() {
		return cntrNm;
	}

	public void setCntrNm(String cntrNm) {
		this.cntrNm = cntrNm;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBkgCustTpCd() {
		return bkgCustTpCd;
	}

	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
