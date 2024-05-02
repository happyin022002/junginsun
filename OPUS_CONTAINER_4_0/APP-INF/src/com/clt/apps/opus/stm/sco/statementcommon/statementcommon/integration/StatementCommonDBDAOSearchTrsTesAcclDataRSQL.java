/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOSearchTrsTesAcclDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchTrsTesAcclDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS/TES Accrula 데이타를 조회한다.
	  * </pre>
	  */
	public StatementCommonDBDAOSearchTrsTesAcclDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchTrsTesAcclDataRSQL").append("\n"); 
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
		query.append("SELECT  EXE_YRMON" ).append("\n"); 
		query.append("    ,	SYS_SRC_ID" ).append("\n"); 
		query.append("    ,	REV_YRMON" ).append("\n"); 
		query.append("    ,	ACCT_CD" ).append("\n"); 
		query.append("    ,	ACCL_SEQ" ).append("\n"); 
		query.append("    ,	BIZ_UT_ID" ).append("\n"); 
		query.append("    ,	VSL_CD" ).append("\n"); 
		query.append("    ,	SKD_VOY_NO" ).append("\n"); 
		query.append("    ,	SKD_DIR_CD" ).append("\n"); 
		query.append("    ,	REV_DIR_CD" ).append("\n"); 
		query.append("    ,	ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("    ,	ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("    ,	ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("    ,	NOD_CD" ).append("\n"); 
		query.append("    ,	ESTM_COST_AMT" ).append("\n"); 
		query.append("    ,	ACT_COST_AMT" ).append("\n"); 
		query.append("    ,	ACCL_COST_AMT" ).append("\n"); 
		query.append("    ,	BKG_NO" ).append("\n"); 
		query.append("    ,	BKG_NO_SPLIT" ).append("\n"); 
		query.append("    ,	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,	RLANE_CD" ).append("\n"); 
		query.append("    ,	CNTR_QTY" ).append("\n"); 
		query.append("    ,	CRE_USR_ID" ).append("\n"); 
		query.append("    ,	TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append("    ,	UPD_USR_ID" ).append("\n"); 
		query.append("    ,	TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("    ,	CXL_FLG" ).append("\n"); 
		query.append("    ,	TO_CHAR(CXL_DT, 'YYYY-MM-DD HH24:MI:SS') AS CXL_DT" ).append("\n"); 
		query.append("    ,	ESTM_QTY" ).append("\n"); 
		query.append("    ,	ACT_QTY" ).append("\n"); 
		query.append("    ,	ACCL_QTY" ).append("\n"); 
		query.append("    ,	VNDR_NO" ).append("\n"); 
		query.append("    ,	ESTM_UC_AMT" ).append("\n"); 
		query.append("    ,	COA_COST_SRC_CD" ).append("\n"); 
		query.append("    ,	ACT_PLC_CD" ).append("\n"); 
		query.append("    ,	TO_CHAR(ACT_DT, 'YYYY-MM-DD HH24:MI:SS') AS ACT_DT" ).append("\n"); 
		query.append("    ,	LOCL_CURR_CD" ).append("\n"); 
		query.append("    ,	SLAN_CD" ).append("\n"); 
		query.append("    ,	WO_NO" ).append("\n"); 
		query.append("    ,	CTRL_OFC_CD" ).append("\n"); 
		query.append("    ,	ERR_FLG" ).append("\n"); 
		query.append("    ,	ERR_DESC  " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("#if (${job_nm} != '' && ${job_nm} == 'ACCLTRS')	" ).append("\n"); 
		query.append("		SAC_TRSP_ACCL_COST_IF" ).append("\n"); 
		query.append("#else   " ).append("\n"); 
		query.append("		SAC_TML_ACCL_COST_IF" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE   EXE_YRMON = REPLACE(@[accl_month],'-','')" ).append("\n"); 

	}
}