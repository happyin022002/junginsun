/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailRetrive.java
*@FileTitle	: WorkOrderDetail
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.clt.apps.opus.esd.trs.servicesio.common.document;

//import java.util.ArrayList;

/**
 * EXP_PAP_002 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_002Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailExcelUploadRetrive { 
	
	
	private String eqNo = "";

	/**
	 * @return eq_no을 리턴합니다.
	 */
	public String getEq_no() {
		return eqNo;
	}

	/**
	 * @param eq_no 설정하려는 eq_no입니다.
	 */
	public void setEq_no(String eq_no) {
		this.eqNo = eq_no;
	}


	

}
