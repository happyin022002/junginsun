/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConstraintManageDBDAOAddNodeConstraintHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.05 박만건
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

public class ConstraintManageDBDAOAddNodeConstraintHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POD Node History 정보를 생성한다.
	  * </pre>
	  */
	public ConstraintManageDBDAOAddNodeConstraintHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_nod_cnst_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cnst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOAddNodeConstraintHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_NOD_CNST_MGMT_HIS" ).append("\n"); 
		query.append("     ( NOD_CD" ).append("\n"); 
		query.append("     , NOD_CNST_ITM_CD" ).append("\n"); 
		query.append("     , NOD_CNST_SEQ" ).append("\n"); 
		query.append("     , HIS_CRE_DT" ).append("\n"); 
		query.append("     , PCTL_CNST_ITM_NM" ).append("\n"); 
		query.append("     , NOD_CNST_RMK" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , CNTR_TP_CD" ).append("\n"); 
		query.append("     , EFF_FM_DT" ).append("\n"); 
		query.append("     , EFF_TO_DT" ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append("     , UPD_OFC_CD" ).append("\n"); 
		query.append("     , SVC_USE_FLG" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , PORT_PNT_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , VSL_SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT NOD_CD" ).append("\n"); 
		query.append("     , NOD_CNST_ITM_CD" ).append("\n"); 
		query.append("     , NOD_CNST_SEQ" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , PCTL_CNST_ITM_NM" ).append("\n"); 
		query.append("     , NOD_CNST_RMK" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , CNTR_TP_CD" ).append("\n"); 
		query.append("     , EFF_FM_DT" ).append("\n"); 
		query.append("     , EFF_TO_DT" ).append("\n"); 
		query.append("     , CRE_OFC_CD" ).append("\n"); 
		query.append("     , UPD_OFC_CD" ).append("\n"); 
		query.append("     , SVC_USE_FLG" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , PORT_PNT_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , VSL_SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("  FROM PRD_NOD_CNST_MGMT" ).append("\n"); 
		query.append(" WHERE NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("   AND NOD_CNST_ITM_CD = @[old_nod_cnst_itm_cd]" ).append("\n"); 
		query.append("   AND NOD_CNST_SEQ = TO_NUMBER(@[nod_cnst_seq])" ).append("\n"); 

	}
}