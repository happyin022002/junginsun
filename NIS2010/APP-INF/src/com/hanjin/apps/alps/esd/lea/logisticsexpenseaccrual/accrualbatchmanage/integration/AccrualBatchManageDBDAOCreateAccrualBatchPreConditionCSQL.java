/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageDBDAOCreateAccrualBatchPreConditionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.10.27 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchManageDBDAOCreateAccrualBatchPreConditionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AccrualBatchManageDBDAOCreateAccrualBatchPreConditionCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration").append("\n"); 
		query.append("FileName : AccrualBatchManageDBDAOCreateAccrualBatchPreConditionCSQL").append("\n"); 
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
		query.append("MERGE INTO LEA_ACCL_COND_ITM A" ).append("\n"); 
		query.append("USING ( SELECT COUNT(*)  ACCL_COND_ITM_CNT" ).append("\n"); 
		query.append("FROM LEA_ACCL_COND_ITM" ).append("\n"); 
		query.append("WHERE EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-')) B" ).append("\n"); 
		query.append("ON (B.ACCL_COND_ITM_CNT >= 1 )" ).append("\n"); 
		query.append("WHEN  MATCHED THEN" ).append("\n"); 
		query.append("UPDATE 	SET" ).append("\n"); 
		query.append("-- A/P 실적마감 여부" ).append("\n"); 
		query.append("AP_CLZ_FLG 	=	(SELECT DECODE(CLZ_STS_CD, 'C', 'Y', 'N')" ).append("\n"); 
		query.append("FROM   AP_PERIOD" ).append("\n"); 
		query.append("WHERE  SYS_DIV_CD = 15" ).append("\n"); 
		query.append("AND    EFF_YRMON = REPLACE(@[frm_exe_yrmon],'-'))" ).append("\n"); 
		query.append("-- 수입대상항차 INTEFACE 여부" ).append("\n"); 
		query.append(", REV_VVD_IF_FLG	=	(SELECT DECODE(DUP_CNT,0,DECODE(VVD_CNT,1,'Y','N'),'N')" ).append("\n"); 
		query.append("FROM (	SELECT  COUNT(*) DUP_CNT" ).append("\n"); 
		query.append("FROM	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE (EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_IOC_DIV_CD)" ).append("\n"); 
		query.append("IN	(SELECT	EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("FROM	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE	ESTM_BC_DIV_CD = 'C'" ).append("\n"); 
		query.append("AND		EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("GROUP BY EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD,ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("HAVING COUNT (ESTM_VVD_TP_CD) > 1 ) ) A," ).append("\n"); 
		query.append("(	SELECT SIGN(COUNT(*)) VVD_CNT" ).append("\n"); 
		query.append("FROM   GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE  EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-') )B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- 수입대상항차 INTEFACE 갯수" ).append("\n"); 
		query.append(", REV_VVD_IF_KNT 	=   (SELECT	COUNT(*)" ).append("\n"); 
		query.append("FROM	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE	EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-'))" ).append("\n"); 
		query.append("-- 월평균 환율 INTEFACE 여부" ).append("\n"); 
		query.append(", MON_AVG_XCH_RT_IF_FLG	=	(SELECT DECODE(SIGN(COUNT(*)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("FROM	GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE	ACCT_XCH_RT_LVL = 3 --(1: 경리환율, 3: 월평균환율)" ).append("\n"); 
		query.append("AND		ACCT_XCH_RT_YRMON = REPLACE(@[frm_exe_yrmon],'-'))" ).append("\n"); 
		query.append("-- 월평균 환율 INTEFACE 갯수" ).append("\n"); 
		query.append(", MON_AVG_XCH_RT_IF_KNT	=	(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM	GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE	ACCT_XCH_RT_LVL = 3 --(1: 경리환율, 3: 월평균환율)" ).append("\n"); 
		query.append("AND		ACCT_XCH_RT_YRMON = REPLACE(@[frm_exe_yrmon],'-'))" ).append("\n"); 
		query.append(", CRE_OFC_CD               = @[cre_ofc_cd]" ).append("\n"); 
		query.append(", UPD_USR_ID               = @[cre_usr_id]" ).append("\n"); 
		query.append(", UPD_DT                   = SYSDATE" ).append("\n"); 
		query.append("WHERE	EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("EXE_YRMON" ).append("\n"); 
		query.append(", AP_CLZ_FLG" ).append("\n"); 
		query.append(", REV_VVD_IF_FLG" ).append("\n"); 
		query.append(", REV_VVD_IF_KNT" ).append("\n"); 
		query.append(", MON_AVG_XCH_RT_IF_FLG" ).append("\n"); 
		query.append(", MON_AVG_XCH_RT_IF_KNT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("REPLACE(@[frm_exe_yrmon],'-')," ).append("\n"); 
		query.append("-- A/P 실적마감 여부" ).append("\n"); 
		query.append("(SELECT DECODE(CLZ_STS_CD, 'C', 'Y', 'N')" ).append("\n"); 
		query.append("FROM   AP_PERIOD" ).append("\n"); 
		query.append("WHERE  SYS_DIV_CD = 15" ).append("\n"); 
		query.append("AND    EFF_YRMON = REPLACE(@[frm_exe_yrmon],'-'))," ).append("\n"); 
		query.append("-- 수입대상항차 INTEFACE 여부" ).append("\n"); 
		query.append("(SELECT DECODE(DUP_CNT,0,DECODE(VVD_CNT,1,'Y','N'),'N')" ).append("\n"); 
		query.append("FROM (	SELECT  COUNT(*) DUP_CNT" ).append("\n"); 
		query.append("FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE (EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_IOC_DIV_CD)" ).append("\n"); 
		query.append("IN ( 	SELECT	EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("FROM 	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE 	ESTM_BC_DIV_CD = 'C'" ).append("\n"); 
		query.append("AND		EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("GROUP BY EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("HAVING COUNT (ESTM_VVD_TP_CD) > 1 ) )A," ).append("\n"); 
		query.append("(	SELECT SIGN(COUNT(*)) VVD_CNT" ).append("\n"); 
		query.append("FROM	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE	EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-'))B" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("-- 수입대상항차 INTEFACE 갯수" ).append("\n"); 
		query.append("(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("WHERE  EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-'))," ).append("\n"); 
		query.append("-- 월평균 환율 INTEFACE 여부" ).append("\n"); 
		query.append("(SELECT	DECODE(SIGN(COUNT(*)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("FROM	GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE	ACCT_XCH_RT_LVL = 3 --(1: 경리환율, 3: 월평균환율)" ).append("\n"); 
		query.append("AND		ACCT_XCH_RT_YRMON = REPLACE(@[frm_exe_yrmon],'-'))," ).append("\n"); 
		query.append("-- 월평균 환율 INTEFACE 갯수" ).append("\n"); 
		query.append("(SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM	GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE	ACCT_XCH_RT_LVL = 3 --(1: 경리환율, 3: 월평균환율)" ).append("\n"); 
		query.append("AND		ACCT_XCH_RT_YRMON = REPLACE(@[frm_exe_yrmon],'-'))," ).append("\n"); 
		query.append("@[cre_ofc_cd]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}