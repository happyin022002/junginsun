/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOMonEstmCsmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.06.13 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MIJIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOMonEstmCsmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search a monthly estimation consumption.
	  * </pre>
	  */
	public EstimationDBDAOMonEstmCsmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration").append("\n"); 
		query.append("FileName : EstimationDBDAOMonEstmCsmVORSQL").append("\n"); 
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
		query.append("/**" ).append("\n"); 
		query.append("SELECT '' EXE_YRMON" ).append("\n"); 
		query.append("     , '' REV_YRMON" ).append("\n"); 
		query.append("     , '' RLANE_CD" ).append("\n"); 
		query.append("     , '' VSL_CD" ).append("\n"); 
		query.append("     , '' SKD_VOY_NO" ).append("\n"); 
		query.append("     , '' SKD_DIR_CD" ).append("\n"); 
		query.append("     , '' REV_DIR_CD" ).append("\n"); 
		query.append("     , '' ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("     , '' CSM_OIL_TP_CD" ).append("\n"); 
		query.append("     , '' PRE_ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("     , '' CRR_CD" ).append("\n"); 
		query.append("     , '' TO_FLG" ).append("\n"); 
		query.append("     , '' ERR_FLG" ).append("\n"); 
		query.append("     , '' ITM_ERR_CD" ).append("\n"); 
		query.append("     , '' CNTR_DZN_CAPA" ).append("\n"); 
		query.append("     , '' TRND_LINE_SEQ" ).append("\n"); 
		query.append("     , '' TRND_LINE_NO" ).append("\n"); 
		query.append("     , '' ACT_ST_PORT_CD" ).append("\n"); 
		query.append("     , '' ACT_ST_DT" ).append("\n"); 
		query.append("     , '' ACT_END_PORT_CD" ).append("\n"); 
		query.append("     , '' ACT_END_DT" ).append("\n"); 
		query.append("     , '' ESTM_SEQ_NO" ).append("\n"); 
		query.append("     , '' TMP_ST_PORT_CD" ).append("\n"); 
		query.append("     , '' TMP_ST_DT" ).append("\n"); 
		query.append("     , '' TMP_END_PORT_CD" ).append("\n"); 
		query.append("     , '' TMP_END_DT" ).append("\n"); 
		query.append("     , '' MON_BGN_INVT_WGT" ).append("\n"); 
		query.append("     , '' PRE_VVD_INVT_WGT" ).append("\n"); 
		query.append("     , '' PO_RCV_WGT" ).append("\n"); 
		query.append("     , '' BOD_WGT" ).append("\n"); 
		query.append("     , '' BOR_WGT" ).append("\n"); 
		query.append("     , '' VOY_SEA_DYS" ).append("\n"); 
		query.append("     , '' VOY_PORT_DYS" ).append("\n"); 
		query.append("     , '' ESTM_SEA_DYS" ).append("\n"); 
		query.append("     , '' ESTM_PORT_DYS" ).append("\n"); 
		query.append("     , '' VOY_END_RMN_WGT" ).append("\n"); 
		query.append("     , '' VOY_END_CSM_WGT" ).append("\n"); 
		query.append("     , '' MON_END_RMN_WGT" ).append("\n"); 
		query.append("     , '' MON_END_CSM_WGT" ).append("\n"); 
		query.append("     , '' ESTM_MON_CSM_WGT" ).append("\n"); 
		query.append("     , '' CRE_USR_ID" ).append("\n"); 
		query.append("     , '' CRE_DT" ).append("\n"); 
		query.append("     , '' UPD_USR_ID" ).append("\n"); 
		query.append("     , '' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("**/" ).append("\n"); 
		query.append("SELECT EXE_YRMON" ).append("\n"); 
		query.append("     , REV_YRMON" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , REV_DIR_CD" ).append("\n"); 
		query.append("     , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("     , CSM_OIL_TP_CD" ).append("\n"); 
		query.append("     , PRE_ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("     , CRR_CD" ).append("\n"); 
		query.append("     , TO_FLG" ).append("\n"); 
		query.append("     , ERR_FLG" ).append("\n"); 
		query.append("     , ITM_ERR_CD" ).append("\n"); 
		query.append("     , CNTR_DZN_CAPA" ).append("\n"); 
		query.append("     , TRND_LINE_SEQ" ).append("\n"); 
		query.append("     , TRND_LINE_NO" ).append("\n"); 
		query.append("     , ACT_ST_PORT_CD" ).append("\n"); 
		query.append("     , ACT_ST_DT" ).append("\n"); 
		query.append("     , ACT_END_PORT_CD" ).append("\n"); 
		query.append("     , ACT_END_DT" ).append("\n"); 
		query.append("     , ESTM_SEQ_NO" ).append("\n"); 
		query.append("     , TMP_ST_PORT_CD" ).append("\n"); 
		query.append("     , TMP_ST_DT" ).append("\n"); 
		query.append("     , TMP_END_PORT_CD" ).append("\n"); 
		query.append("     , TMP_END_DT" ).append("\n"); 
		query.append("     , MON_BGN_INVT_WGT" ).append("\n"); 
		query.append("     , PRE_VVD_INVT_WGT" ).append("\n"); 
		query.append("     , PO_RCV_WGT" ).append("\n"); 
		query.append("     , BOD_WGT" ).append("\n"); 
		query.append("     , BOR_WGT" ).append("\n"); 
		query.append("     , VOY_SEA_DYS" ).append("\n"); 
		query.append("     , VOY_PORT_DYS" ).append("\n"); 
		query.append("     , ESTM_SEA_DYS" ).append("\n"); 
		query.append("     , ESTM_PORT_DYS" ).append("\n"); 
		query.append("     , VOY_END_RMN_WGT" ).append("\n"); 
		query.append("     , VOY_END_CSM_WGT" ).append("\n"); 
		query.append("     , MON_END_RMN_WGT" ).append("\n"); 
		query.append("     , MON_END_CSM_WGT" ).append("\n"); 
		query.append("     , ESTM_MON_CSM_WGT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("FROM FCM_ESTM_MON_CSM" ).append("\n"); 
		query.append("WHERE EXE_YRMON = REPLACE(@[exe_yrmon], '-', '')" ).append("\n"); 
		query.append("ORDER BY REV_YRMON, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_VVD_TP_CD, CSM_OIL_TP_CD" ).append("\n"); 

	}
}