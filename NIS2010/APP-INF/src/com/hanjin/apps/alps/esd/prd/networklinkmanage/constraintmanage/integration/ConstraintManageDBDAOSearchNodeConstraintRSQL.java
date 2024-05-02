/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchNodeConstraintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOSearchNodeConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNodeConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchNodeConstraintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("point_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchNodeConstraintRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	 NOD_CD, NOD_CNST_ITM_CD, PCTL_CNST_ITM_NM, NOD_CNST_RMK, " ).append("\n"); 
		query.append("	 CNTR_TP_CD, EFF_FM_DT, EFF_TO_DT, SVC_USE_FLG, " ).append("\n"); 
		query.append("	 CRE_DT, CRE_OFC_CD, CRE_USR_ID , UPD_DT, UPD_OFC_CD, UPD_USR_ID, " ).append("\n"); 
		query.append("     NOD_CNST_SEQ , NOD_CNST_ITM_CD OLD_NOD_CNST_ITM_CD, CMDT_CD, CMDT_NM,PORT_PNT_CD, VSL_SLAN_CD, VVD," ).append("\n"); 
		query.append("     DECODE (CNST_CST_EXPT, 0, '', 'Y') AS CNST_CST_EXPT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT NOD_CD, NOD_CNST_ITM_CD, PCTL_CNST_ITM_NM, NOD_CNST_RMK, " ).append("\n"); 
		query.append(" 		CNTR_TP_CD, EFF_FM_DT, EFF_TO_DT, SVC_USE_FLG, " ).append("\n"); 
		query.append("		TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT, CRE_OFC_CD, CRE_USR_ID , NOD_CNST_SEQ, P.CMDT_CD " ).append("\n"); 
		query.append("       ,(SELECT CMDT_NM FROM MDM_COMMODITY M WHERE M.CMDT_CD  = P.CMDT_CD) CMDT_NM , NVL(PORT_PNT_CD, 'ALL') PORT_PNT_CD " ).append("\n"); 
		query.append("       , TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT, UPD_OFC_CD, UPD_USR_ID," ).append("\n"); 
		query.append("       VSL_SLAN_CD, VSL_CD || SKD_VOY_NO || SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       (SELECT COUNT (*) AS CNT " ).append("\n"); 
		query.append("          FROM PRD_NOD_CNST_EXPT U" ).append("\n"); 
		query.append("         WHERE     U.NOD_CD = P.NOD_CD" ).append("\n"); 
		query.append("               AND U.NOD_CNST_ITM_CD = P.NOD_CNST_ITM_CD" ).append("\n"); 
		query.append("               AND U.NOD_CNST_SEQ = P.NOD_CNST_SEQ" ).append("\n"); 
		query.append("               AND U.DELT_FLG = 'N') AS CNST_CST_EXPT" ).append("\n"); 
		query.append("	FROM PRD_NOD_CNST_MGMT P" ).append("\n"); 
		query.append("	WHERE DECODE(NOD_CD,'ALL',@[loc]||'%',NOD_CD) LIKE @[loc]||'%'" ).append("\n"); 
		query.append("    AND NVL(DELT_FLG, 'N') ='N'" ).append("\n"); 
		query.append("    AND NVL(CMDT_CD, '#') = NVL(TRIM(@[cmdt_cd]), NVL(CMDT_CD, '#')) " ).append("\n"); 
		query.append("    AND NVL(VSL_SLAN_CD,'#') = NVL(TRIM(@[vsl_slan_cd]), NVL(VSL_SLAN_CD,'#'))" ).append("\n"); 
		query.append("    AND NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, '#') LIKE NVL(TRIM(@[vvd]), NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD,'%'))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE PORT_PNT_CD LIKE DECODE(TRIM(@[point_code]),'ALL' , '%', NULL, '%', @[point_code])" ).append("\n"); 
		query.append("AND NVL(UPPER(CMDT_NM),'#') LIKE DECODE(TRIM(@[cmdt_nm]), NULL, '%', '%' || UPPER(TRIM(@[cmdt_nm])) || '%')" ).append("\n"); 

	}
}