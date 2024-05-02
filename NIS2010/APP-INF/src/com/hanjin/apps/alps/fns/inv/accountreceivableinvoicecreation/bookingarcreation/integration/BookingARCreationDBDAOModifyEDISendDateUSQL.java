/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyEDISendDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
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

public class BookingARCreationDBDAOModifyEDISendDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VLCSC의 EDI 다운로드 받은 해당 데이터에 대해서 INV_AR_MN의 EDI_SND_DT에 입력된 EDI DATE를 update 한다.
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyEDISendDateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyEDISendDateUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN" ).append("\n"); 
		query.append("SET EDI_SND_DT = TO_DATE(@[update_dt]||' 000000','YYYYMMDD HH24MISS')" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("  AND AR_IF_NO IN (" ).append("\n"); 
		query.append("    SELECT A.AR_IF_NO" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      INV_AR_ISS_DTL C," ).append("\n"); 
		query.append("      INV_AR_ISS D" ).append("\n"); 
		query.append("    WHERE D.ISS_DT BETWEEN TO_CHAR(TO_DATE(@[iss_dt],'YYYYMMDD') - 6,'YYYYMMDD') AND @[iss_dt] " ).append("\n"); 
		query.append("      AND D.ISS_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE AR_OFC_CD = @[ar_ofc_cd] )" ).append("\n"); 
		query.append("      AND D.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("      AND C.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND A.EDI_SND_DT IS NULL )" ).append("\n"); 

	}
}