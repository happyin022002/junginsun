/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchCheckCutOffLaneOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchCheckCutOffLaneOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM에서 삭제된 Office 경우 CutOffLane에 변경된 AR Office가 등록되어있는지 Check
	  * MDM 삭제된 Office의 AR Office를 CutOffLane에서 새로 구하는 Query임
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchCheckCutOffLaneOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchCheckCutOffLaneOfficeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT NEW_AR_OFC_CD" ).append("\n"); 
		query.append("FROM   INV_CUT_OFF_LANE" ).append("\n"); 
		query.append("WHERE  OLD_AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND    IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND    SLAN_CD = 'ALL'" ).append("\n"); 
		query.append("AND    PORT_CD = 'ALL'" ).append("\n"); 
		query.append("AND    APLY_DT <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("AND    EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("               FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("               WHERE  OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("               AND    DELT_FLG = 'Y')" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}