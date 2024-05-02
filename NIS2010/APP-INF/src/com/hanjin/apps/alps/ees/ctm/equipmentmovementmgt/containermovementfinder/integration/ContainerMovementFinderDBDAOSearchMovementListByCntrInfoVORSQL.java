/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchMovementListByCntrInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchMovementListByCntrInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0409 : 조회 쿼리   
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchMovementListByCntrInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchMovementListByCntrInfoVORSQL").append("\n"); 
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
		query.append("SELECT C2.CNTR_NO," ).append("\n"); 
		query.append("  C2.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  C2.MVMT_STS_CD," ).append("\n"); 
		query.append("  TO_CHAR (C2.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("  C2.ORG_YD_CD," ).append("\n"); 
		query.append("  (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = C2.ORG_YD_CD) AS ORG_YD_NM," ).append("\n"); 
		query.append("  C2.DEST_YD_CD," ).append("\n"); 
		query.append("  (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = C2.DEST_YD_CD) AS DEST_YD_NM," ).append("\n"); 
		query.append("  C2.CNTR_SEAL_NO," ).append("\n"); 
		query.append("  C2.CHSS_NO," ).append("\n"); 
		query.append("  C2.MGST_NO," ).append("\n"); 
		query.append("  TO_CHAR (C2.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT," ).append("\n"); 
		query.append("  TO_CHAR (C2.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("  SUBSTR (RESULT, 9, 2)" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT C2," ).append("\n"); 
		query.append("  (SELECT CNTR_NO," ).append("\n"); 
		query.append("     MAX(KEYY) RESULT" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("      SELECT C.CNTR_NO," ).append("\n"); 
		query.append("        CNMV_YR," ).append("\n"); 
		query.append("        CNMV_SEQ," ).append("\n"); 
		query.append("        CNMV_SPLIT_NO," ).append("\n"); 
		query.append("        C.CNMV_YR || LPAD(C.CNMV_SEQ, 4, 0 ) || C.CNMV_SPLIT_NO KEYY" ).append("\n"); 
		query.append("      FROM CTM_MOVEMENT C," ).append("\n"); 
		query.append("        (SELECT B.CNTR_NO" ).append("\n"); 
		query.append("         FROM BKG_CONTAINER B" ).append("\n"); 
		query.append("         WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("      WHERE C.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("     ) AA" ).append("\n"); 
		query.append("   GROUP BY CNTR_NO" ).append("\n"); 
		query.append("  ) C1" ).append("\n"); 
		query.append(" WHERE C1.CNTR_NO = C2.CNTR_NO" ).append("\n"); 
		query.append("   AND C2.CNMV_YR = SUBSTR(RESULT, 1, 4)" ).append("\n"); 
		query.append("   AND C2.CNMV_SEQ = SUBSTR(RESULT, 5, 4)" ).append("\n"); 
		query.append("   AND C2.CNMV_SPLIT_NO = SUBSTR(RESULT, 9, 2)" ).append("\n"); 

	}
}