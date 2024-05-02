/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderMainRetrive.java
*@FileTitle	: WorkOrderMain
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.clt.apps.opus.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_005 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_005Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */

public class WorkOrderMainRetrive { 
	
	/**	(Param 객체) */
	private	String userId = "";						//Dispatched Date
	private	String venderCd = "";					//Vender Code
	/**
	 * @return user_id을 리턴합니다.
	 */
	public String getUser_id() {
		return userId;
	}
	/**
	 * @param user_id 설정하려는 user_id입니다.
	 */
	public void setUser_id(String user_id) {
		this.userId = user_id;
	}
	/**
	 * @return vender_cd을 리턴합니다.
	 */
	public String getVender_cd() {
		return venderCd;
	}
	/**
	 * @param vender_cd 설정하려는 vender_cd입니다.
	 */
	public void setVender_cd(String vender_cd) {
		this.venderCd = vender_cd;
	}

	
}

