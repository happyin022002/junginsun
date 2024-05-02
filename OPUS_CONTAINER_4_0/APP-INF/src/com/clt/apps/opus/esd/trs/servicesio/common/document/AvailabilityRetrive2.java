/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AvailabilityRetrive.java
*@FileTitle	: Availability
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
 * EXP_PAP_004 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_004Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class AvailabilityRetrive2 { 
	/**	(Param 객체) */

	private String userID = "";
	private String vendorCode = "";
	private	String trspWoNo =	"";			//W/O	No
	private	String eqNo = "";				//Equipment	No
	private	String bkgNo =	"";				//Booking No
	private	String blNo = "";					//Bill of Lading No

	public String getUserID() {		return userID;	}
	public String getVendorCode() {		return vendorCode;	}
	public String getTrsp_wo_no()		{		return trspWoNo;	}
	public String getEq_no()					{		return eqNo;			}
	public String getBkg_no()				{		return bkgNo;		}
	public String getBl_no()					{		return blNo;			}

	public void 	setUserID(String userID) {		this.userID = userID;	}
	public void 	setVendorCode(String vendorCode) {		this.vendorCode = vendorCode;	}
	public void	setTrsp_wo_no			(String	trsp_wo_no	) {		this.trspWoNo		= trsp_wo_no;		}
	public void	setEq_no					(String	eq_no			) {		this.eqNo				= eq_no;			}
	public void	setBkg_no					(String	bkg_no			) {		this.bkgNo			= bkg_no;			}
	public void	setBl_no					(String	bl_no				) {		this.blNo				= bl_no;				}


}
