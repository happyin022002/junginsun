/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageDBDAOSearchAccrualBatchPreConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.10.05 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchManageDBDAOSearchAccrualBatchPreConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AccrualBatchManageDBDAOSearchAccrualBatchPreConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration").append("\n"); 
		query.append("FileName : AccrualBatchManageDBDAOSearchAccrualBatchPreConditionRSQL").append("\n"); 
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
		query.append("SELECT	EXE_YRMON" ).append("\n"); 
		query.append(",AP_CLZ_FLG" ).append("\n"); 
		query.append(",DECODE(AP_CLZ_FLG,'Y','Yes','No') AP_CLZ_FLG_NM" ).append("\n"); 
		query.append(",REV_VVD_IF_FLG" ).append("\n"); 
		query.append(",DECODE(REV_VVD_IF_FLG,'Y','Yes','No') REV_VVD_IF_FLG_NM" ).append("\n"); 
		query.append(",REV_VVD_DUP_CNT" ).append("\n"); 
		query.append(",REV_VVD_IF_KNT" ).append("\n"); 
		query.append(",DECODE(REV_VVD_IF_FLG,'Y','Yes','No')||CASE WHEN NVL(REV_VVD_IF_KNT,0) < 1 THEN ''ELSE  '( '||REV_VVD_IF_KNT||' )' END REV_VVD_IF_DESC" ).append("\n"); 
		query.append(",MON_AVG_XCH_RT_IF_FLG" ).append("\n"); 
		query.append(",DECODE(MON_AVG_XCH_RT_IF_FLG,'Y','Yes','No') MON_AVG_XCH_RT_IF_FLG_NM" ).append("\n"); 
		query.append(",MON_AVG_XCH_RT_IF_KNT" ).append("\n"); 
		query.append(",DECODE(MON_AVG_XCH_RT_IF_FLG,'Y','Yes','No') ||CASE 	WHEN NVL(MON_AVG_XCH_RT_IF_KNT,0) < 1 THEN ''" ).append("\n"); 
		query.append("ELSE  '( '||MON_AVG_XCH_RT_IF_KNT||' )'" ).append("\n"); 
		query.append("END MON_AVG_XCH_RT_IF_FLG_DESC" ).append("\n"); 
		query.append(",COND_CFM_FLG" ).append("\n"); 
		query.append(",DECODE(COND_CFM_FLG,'Y','Yes','No') COND_CFM_FLG_NM" ).append("\n"); 
		query.append(",MNL_INP_FLG" ).append("\n"); 
		query.append(",DECODE(MNL_INP_FLG,'Y','Yes','No') MNL_INP_FLG_NM" ).append("\n"); 
		query.append(",ERP_IF_FLG" ).append("\n"); 
		query.append(",DECODE(ERP_IF_FLG,'Y','Yes','No') ERP_IF_FLG_NM" ).append("\n"); 
		query.append(",CASE WHEN REV_VVD_DUP_CNT > 0 THEN 'Rev. VVD duplicated'" ).append("\n"); 
		query.append("ELSE DECODE(ERP_IF_FLG,'Y','ERP I/F for Exe. Month '||EXE_YRMON||' Batch Completed',DECODE(COND_CFM_FLG,'Y','Confirmed'))" ).append("\n"); 
		query.append("END ERP_IF_FLG_DESC" ).append("\n"); 
		query.append(",ERP_IF_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 	EXE_YRMON" ).append("\n"); 
		query.append(",AP_CLZ_FLG" ).append("\n"); 
		query.append(",REV_VVD_IF_FLG" ).append("\n"); 
		query.append(",(	SELECT  COUNT(*) FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE (EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_IOC_DIV_CD)" ).append("\n"); 
		query.append("IN (SELECT	EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("FROM	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE 	ESTM_BC_DIV_CD = 'C' AND EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("GROUP BY EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("HAVING COUNT (ESTM_VVD_TP_CD) > 1 ) ) REV_VVD_DUP_CNT" ).append("\n"); 
		query.append(",REV_VVD_IF_KNT" ).append("\n"); 
		query.append(",MON_AVG_XCH_RT_IF_FLG" ).append("\n"); 
		query.append(",MON_AVG_XCH_RT_IF_KNT" ).append("\n"); 
		query.append(",COND_CFM_FLG" ).append("\n"); 
		query.append(",MNL_INP_FLG" ).append("\n"); 
		query.append(",ERP_IF_FLG" ).append("\n"); 
		query.append(",ERP_IF_DT" ).append("\n"); 
		query.append("FROM LEA_ACCL_COND_ITM" ).append("\n"); 
		query.append("WHERE EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}