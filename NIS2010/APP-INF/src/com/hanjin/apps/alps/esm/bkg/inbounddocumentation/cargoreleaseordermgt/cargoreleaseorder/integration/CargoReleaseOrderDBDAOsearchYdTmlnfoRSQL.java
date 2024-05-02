/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL").append("\n"); 
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
		query.append("SELECT  NVL(NVL(MAX(BKG_FULL_RLSE_EDI_CD),MAX(CSTMS_FULL_RLSE_EDI_CD))," ).append("\n"); 
		query.append("        DECODE(@[pod_cd],'USNYC','2')) AS FULL_RLSE_EDI_CD," ).append("\n"); 
		query.append("        NVL(MAX(BKG_TERM_ID),  MAX(CSTMS_TERM_ID)) AS TERM_ID" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("         SELECT C.BL_NO AS CSTMS_BL_NO," ).append("\n"); 
		query.append("              B.FULL_RLSE_EDI_CD AS CSTMS_FULL_RLSE_EDI_CD," ).append("\n"); 
		query.append("              SUBSTR(B.EDI_RCV_ID, 1, 3) AS CSTMS_TERM_ID," ).append("\n"); 
		query.append("              '' BKG_BL_NO," ).append("\n"); 
		query.append("              '' BKG_FULL_RLSE_EDI_CD," ).append("\n"); 
		query.append("              '' BKG_TERM_ID" ).append("\n"); 
		query.append("            FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("              BKG_EDI_YD B, " ).append("\n"); 
		query.append("              BKG_CSTMS_ADV_BL C" ).append("\n"); 
		query.append("            WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("              AND A.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("              AND B.PORT_CD = C.CSTMS_PORT_CD" ).append("\n"); 
		query.append("              AND C.SLAN_CD IN (B.SLAN_CD1," ).append("\n"); 
		query.append("                  B.SLAN_CD2," ).append("\n"); 
		query.append("                  B.SLAN_CD3," ).append("\n"); 
		query.append("                  B.SLAN_CD4," ).append("\n"); 
		query.append("                  B.SLAN_CD5," ).append("\n"); 
		query.append("                  B.SLAN_CD6," ).append("\n"); 
		query.append("                  B.SLAN_CD7," ).append("\n"); 
		query.append("                  B.SLAN_CD8," ).append("\n"); 
		query.append("                  B.SLAN_CD9," ).append("\n"); 
		query.append("                  B.SLAN_CD10" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("              ''," ).append("\n"); 
		query.append("              ''," ).append("\n"); 
		query.append("              C.BL_NO AS BKG_BL_NO," ).append("\n"); 
		query.append("              B.FULL_RLSE_EDI_CD AS BKG_FULL_RLSE_EDI_CD," ).append("\n"); 
		query.append("              SUBSTR(B.EDI_RCV_ID, 1, 3) AS BKG_TERM_ID" ).append("\n"); 
		query.append("            FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("              BKG_EDI_YD B," ).append("\n"); 
		query.append("              BKG_BOOKING C" ).append("\n"); 
		query.append("            WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("              AND A.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("              AND B.YD_CD = C.POD_NOD_CD" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}