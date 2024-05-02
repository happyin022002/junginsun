/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchLinkConstraintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.07 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOSearchLinkConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLinkConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchLinkConstraintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("from_nd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchLinkConstraintRSQL").append("\n"); 
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
		query.append("SELECT LNK_ORG_NOD_CD, LNK_DEST_NOD_CD, TRSP_MOD_CD, LNK_CNST_ITM_CD, PCTL_CNST_ITM_NM, LNK_CNST_RMK, SVC_USE_FLG" ).append("\n"); 
		query.append("     , CNTR_TP_CD, EFF_FM_DT, EFF_TO_DT, CRE_DT, CRE_OFC_CD, CRE_USR_ID, LNK_CNST_SEQ" ).append("\n"); 
		query.append("     , LNK_CNST_ITM_CD OLD_LNK_CNST_ITM_CD, CMDT_CD, CMDT_NM, UPD_DT, UPD_OFC_CD, UPD_USR_ID, VSL_SLAN_CD, VVD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT LNK_ORG_NOD_CD, LNK_DEST_NOD_CD, TRSP_MOD_CD, LNK_CNST_ITM_CD, PCTL_CNST_ITM_NM, LNK_CNST_RMK, SVC_USE_FLG," ).append("\n"); 
		query.append("           CNTR_TP_CD, EFF_FM_DT, EFF_TO_DT," ).append("\n"); 
		query.append("           TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT, CRE_OFC_CD, CRE_USR_ID , LNK_CNST_SEQ, P.CMDT_CD," ).append("\n"); 
		query.append("           (SELECT CMDT_NM FROM MDM_COMMODITY M WHERE M.CMDT_CD  = P.CMDT_CD) CMDT_NM," ).append("\n"); 
		query.append("           TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT, UPD_OFC_CD, UPD_USR_ID," ).append("\n"); 
		query.append("           VSL_SLAN_CD, VSL_CD || SKD_VOY_NO || SKD_DIR_CD VVD" ).append("\n"); 
		query.append("    FROM PRD_LNK_CNST_MGMT P" ).append("\n"); 
		query.append("    WHERE LNK_ORG_NOD_CD LIKE @[from_nd] ||'%'" ).append("\n"); 
		query.append("    AND LNK_DEST_NOD_CD LIKE @[to_nd] ||'%'" ).append("\n"); 
		query.append("    AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    AND NVL(CMDT_CD, '#') = NVL(TRIM(@[cmdt_cd]), NVL(CMDT_CD, '#')) " ).append("\n"); 
		query.append("    AND NVL(VSL_SLAN_CD,'#') = NVL(TRIM(@[vsl_slan_cd]), NVL(VSL_SLAN_CD,'#'))" ).append("\n"); 
		query.append("    AND NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, '#') LIKE NVL(TRIM(@[vvd]), NVL(VSL_CD || SKD_VOY_NO || SKD_DIR_CD,'%'))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(UPPER(CMDT_NM),'#') LIKE DECODE(TRIM(@[cmdt_nm]), NULL, '%', '%' || UPPER(TRIM(@[cmdt_nm])) || '%')" ).append("\n"); 

	}
}