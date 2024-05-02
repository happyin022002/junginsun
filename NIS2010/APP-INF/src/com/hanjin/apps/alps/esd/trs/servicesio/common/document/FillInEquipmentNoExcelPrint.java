/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FillInEquipmentNoRetrive.java
*@FileTitle	: FillInEquipmentNo
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.hanjin.apps.alps.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_003 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_003Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class FillInEquipmentNoExcelPrint { 
	
	/**	(Param 객체) */
	private String eqNo = "";
	//private	String trsp_so_no =	 "";		
	
	public String getEq_no() 			{	return eqNo;	}
	//public String getTrsp_so_no()	{	return trsp_so_no;		}

	public void setEq_no				(String eq_no				) 	{		this.eqNo = eq_no;	}
	//public void setTrsp_so_no	(String	trsp_so_no	) 	{		this.trsp_so_no		= trsp_so_no;		}
	
}


