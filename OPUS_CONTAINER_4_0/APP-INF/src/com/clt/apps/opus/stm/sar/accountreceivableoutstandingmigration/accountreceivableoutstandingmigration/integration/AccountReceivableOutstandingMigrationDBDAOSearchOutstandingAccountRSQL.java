/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingMigrationDBDAOSearchOutstandingAccountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingMigrationDBDAOSearchOutstandingAccountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search account matrix sequence and account code for outstanding
	  * </pre>
	  */
	public AccountReceivableOutstandingMigrationDBDAOSearchOutstandingAccountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingMigrationDBDAOSearchOutstandingAccountRSQL").append("\n"); 
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
		query.append("SELECT  ACCT_MTX_SEQ" ).append("\n"); 
		query.append("      , AR_ACCT_CD" ).append("\n"); 
		query.append("      , CLR_ACCT_CD" ).append("\n"); 
		query.append("      , REV_ACCT_DIV_CD" ).append("\n"); 
		query.append("FROM    OPUSADM_TMP.SAR_ACCT_MTX" ).append("\n"); 
		query.append("WHERE ACCT_MTX_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL((SELECT  ACCT_MTX_SEQ" ).append("\n"); 
		query.append("FROM    OPUSADM_TMP.SAR_ACCT_MTX" ).append("\n"); 
		query.append("WHERE   ACCT_CTNT1 = @[acct_ctnt1]" ).append("\n"); 
		query.append("#if (${acct_ctnt1} == 'REC')" ).append("\n"); 
		query.append("  AND   ACCT_CTNT2 = @[acct_ctnt2]" ).append("\n"); 
		query.append("  AND   ACCT_TP_CD = @[acct_tp_cd]" ).append("\n"); 
		query.append("#elseif (${acct_ctnt1} == 'REV')" ).append("\n"); 
		query.append("  AND   ACCT_CTNT2 = (SELECT  ATTR_CTNT1" ).append("\n"); 
		query.append("                      FROM    SCO_LU_DTL" ).append("\n"); 
		query.append("                      WHERE   LU_TP_CD = 'OTS SRC CD'" ).append("\n"); 
		query.append("                      AND     LU_CD = @[acct_ctnt2]" ).append("\n"); 
		query.append("                      AND     ENBL_FLG = 'Y')" ).append("\n"); 
		query.append("  AND   ACCT_CTNT3 = @[acct_ctnt3]" ).append("\n"); 
		query.append("  AND   ACCT_CTNT4 = @[acct_ctnt4]" ).append("\n"); 
		query.append("  AND   ACCT_TP_CD = @[acct_tp_cd] AND REV_ACCT_DIV_CD <> 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     @[gl_dt] BETWEEN NVL(ACCT_ST_DT, @[gl_dt]) AND NVL(ACCT_END_DT, @[gl_dt])" ).append("\n"); 
		query.append("AND     DELT_FLG = 'N')," ).append("\n"); 
		query.append("(SELECT  ACCT_MTX_SEQ" ).append("\n"); 
		query.append("FROM    OPUSADM_TMP.SAR_ACCT_MTX" ).append("\n"); 
		query.append("WHERE   ACCT_CTNT1 = @[acct_ctnt1]" ).append("\n"); 
		query.append("#if (${acct_ctnt1} == 'REC')" ).append("\n"); 
		query.append("  AND   ACCT_CTNT2 = @[acct_ctnt2]" ).append("\n"); 
		query.append("  AND   ACCT_TP_CD = @[acct_tp_cd]" ).append("\n"); 
		query.append("#elseif (${acct_ctnt1} == 'REV')" ).append("\n"); 
		query.append("  AND   ACCT_CTNT2 = (SELECT  ATTR_CTNT1" ).append("\n"); 
		query.append("                      FROM    SCO_LU_DTL" ).append("\n"); 
		query.append("                      WHERE   LU_TP_CD = 'OTS SRC CD'" ).append("\n"); 
		query.append("                      AND     LU_CD = @[acct_ctnt2]" ).append("\n"); 
		query.append("                      AND     ENBL_FLG = 'Y')" ).append("\n"); 
		query.append("  AND   ACCT_CTNT3 = @[acct_ctnt3]" ).append("\n"); 
		query.append("  AND   ACCT_CTNT4 = @[acct_ctnt4]" ).append("\n"); 
		query.append("  AND   REV_ACCT_DIV_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     @[gl_dt] BETWEEN NVL(ACCT_ST_DT, @[gl_dt]) AND NVL(ACCT_END_DT, @[gl_dt])" ).append("\n"); 
		query.append("AND     DELT_FLG = 'N'))" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}