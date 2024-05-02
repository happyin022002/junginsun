/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchSCExceptionListByPropNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchSCExceptionListByPropNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchSCExceptionListByPropNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchSCExceptionListByPropNoDataRSQL").append("\n"); 
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
		query.append("SELECT  SC_HIST.SC_NO" ).append("\n"); 
		query.append("    ,   SC_HIST.PROP_NO" ).append("\n"); 
		query.append("    ,   SC_HIST.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("    ,   SC_HIST.CHSS_EXPT_VER_STS_DESC" ).append("\n"); 
		query.append("    ,   SC_HIST.REQ_OFC_CD" ).append("\n"); 
		query.append("    ,   REQ_USER.USR_NM AS REQ_USR_NM" ).append("\n"); 
		query.append("    ,   SC_HIST.REQ_DT" ).append("\n"); 
		query.append("    ,   SC_HIST.ACCT_OFC_CD" ).append("\n"); 
		query.append("    ,   ACCT_USER.USR_NM AS ACCT_USR_NM" ).append("\n"); 
		query.append("    ,   SC_HIST.ACCT_DT" ).append("\n"); 
		query.append("	,	SC_HIST.LIVE_DT" ).append("\n"); 
		query.append("	,	SC_HIST.DEL_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("        SELECT  SP_HDR.SC_NO" ).append("\n"); 
		query.append("            ,   SP_HDR.PROP_NO" ).append("\n"); 
		query.append("            ,   LPAD(SC_VER.SC_EXPT_VER_SEQ, 3, '0') SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("            ,   CD_DTL.INTG_CD_VAL_DP_DESC CHSS_EXPT_VER_STS_DESC" ).append("\n"); 
		query.append("            ,   (" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_DESC(CGM_SC_EXPT_VER_PROG XPKCGM_SC_EXPT_VER_PROG) */ PROG_OFC_CD " ).append("\n"); 
		query.append("                    FROM    CGM_SC_EXPT_VER_PROG " ).append("\n"); 
		query.append("                    WHERE   PROP_NO 			 = SP_HDR.PROP_NO " ).append("\n"); 
		query.append("                        AND SC_EXPT_VER_SEQ 	 = SC_VER.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                        AND CHSS_EXPT_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("                        AND ROWNUM 				 = 1" ).append("\n"); 
		query.append("                ) REQ_OFC_CD   " ).append("\n"); 
		query.append("            ,   (" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_DESC(CGM_SC_EXPT_VER_PROG XPKCGM_SC_EXPT_VER_PROG) */ PROG_USR_ID" ).append("\n"); 
		query.append("                    FROM    CGM_SC_EXPT_VER_PROG" ).append("\n"); 
		query.append("                    WHERE   PROP_NO 			 = SP_HDR.PROP_NO " ).append("\n"); 
		query.append("                        AND SC_EXPT_VER_SEQ 	 = SC_VER.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                        AND CHSS_EXPT_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("                        AND ROWNUM 				 = 1" ).append("\n"); 
		query.append("                ) REQ_USR_ID" ).append("\n"); 
		query.append("            ,   (" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_DESC(CGM_SC_EXPT_VER_PROG XPKCGM_SC_EXPT_VER_PROG) */ TO_CHAR(PROG_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                    FROM    CGM_SC_EXPT_VER_PROG " ).append("\n"); 
		query.append("                    WHERE   PROP_NO 			 = SP_HDR.PROP_NO " ).append("\n"); 
		query.append("                        AND SC_EXPT_VER_SEQ 	 = SC_VER.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                        AND CHSS_EXPT_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("                        AND ROWNUM 				 = 1" ).append("\n"); 
		query.append("                ) REQ_DT" ).append("\n"); 
		query.append("            ,   (" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_ASC(CGM_SC_EXPT_VER_PROG XPKCGM_SC_EXPT_VER_PROG) */ PROG_OFC_CD " ).append("\n"); 
		query.append("                    FROM    CGM_SC_EXPT_VER_PROG " ).append("\n"); 
		query.append("                    WHERE   PROP_NO 			 = SP_HDR.PROP_NO " ).append("\n"); 
		query.append("                        AND SC_EXPT_VER_SEQ 	 = SC_VER.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                        AND CHSS_EXPT_VER_STS_CD IN ('A', 'L')" ).append("\n"); 
		query.append("                        AND ROWNUM 				 = 1" ).append("\n"); 
		query.append("                ) ACCT_OFC_CD   " ).append("\n"); 
		query.append("            ,   (" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_ASC(CGM_SC_EXPT_VER_PROG XPKCGM_SC_EXPT_VER_PROG) */ PROG_USR_ID" ).append("\n"); 
		query.append("                    FROM    CGM_SC_EXPT_VER_PROG" ).append("\n"); 
		query.append("                    WHERE   PROP_NO 			 = SP_HDR.PROP_NO " ).append("\n"); 
		query.append("                        AND SC_EXPT_VER_SEQ 	 = SC_VER.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                        AND CHSS_EXPT_VER_STS_CD IN ('A', 'L')" ).append("\n"); 
		query.append("                        AND ROWNUM 				 = 1" ).append("\n"); 
		query.append("                ) ACCT_USR_ID" ).append("\n"); 
		query.append("            ,   (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_ASC(CGM_SC_EXPT_VER_PROG XPKCGM_SC_EXPT_VER_PROG) */ TO_CHAR(PROG_DT, 'YYYY-MM-DD') AS PROG_DT" ).append("\n"); 
		query.append("                    FROM    CGM_SC_EXPT_VER_PROG " ).append("\n"); 
		query.append("                    WHERE   PROP_NO 			 = SP_HDR.PROP_NO " ).append("\n"); 
		query.append("                        AND SC_EXPT_VER_SEQ 	 = SC_VER.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                        AND CHSS_EXPT_VER_STS_CD IN ('A', 'L')" ).append("\n"); 
		query.append("						AND	ROWNUM 				 = 1                " ).append("\n"); 
		query.append("                ) ACCT_DT" ).append("\n"); 
		query.append("            ,   (" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_DESC(CGM_SC_EXPT_VER_PROG XPKCGM_SC_EXPT_VER_PROG) */ TO_CHAR(PROG_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                    FROM    CGM_SC_EXPT_VER_PROG " ).append("\n"); 
		query.append("                    WHERE   PROP_NO 			 = SP_HDR.PROP_NO " ).append("\n"); 
		query.append("                        AND SC_EXPT_VER_SEQ 	 = SC_VER.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                        AND CHSS_EXPT_VER_STS_CD = 'L'" ).append("\n"); 
		query.append("                        AND ROWNUM 				 = 1                   " ).append("\n"); 
		query.append("                ) LIVE_DT" ).append("\n"); 
		query.append("            ,   (" ).append("\n"); 
		query.append("                    SELECT  /*+ INDEX_DESC(CGM_SC_EXPT_VER_PROG XPKCGM_SC_EXPT_VER_PROG) */ TO_CHAR(PROG_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                    FROM    CGM_SC_EXPT_VER_PROG " ).append("\n"); 
		query.append("                    WHERE   PROP_NO 			 = SP_HDR.PROP_NO " ).append("\n"); 
		query.append("                        AND SC_EXPT_VER_SEQ 	 = SC_VER.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                        AND CHSS_EXPT_VER_STS_CD = 'D'" ).append("\n"); 
		query.append("                        AND ROWNUM 				 = 1                   " ).append("\n"); 
		query.append("                ) DEL_DT                 " ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append("            ,   CGM_SC_EXPT_VER SC_VER" ).append("\n"); 
		query.append("            ,   COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE   SP_HDR.PROP_NO 				= @[prop_no]" ).append("\n"); 
		query.append("            AND SP_HDR.PROP_NO 				= SC_VER.PROP_NO" ).append("\n"); 
		query.append("			AND SC_VER.CHSS_EXPT_VER_STS_CD <> 'T'" ).append("\n"); 
		query.append("            AND SC_VER.CHSS_EXPT_VER_STS_CD = CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("            AND CD_DTL.INTG_CD_ID 			= 'CD03260'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	)	SC_HIST" ).append("\n"); 
		query.append("	,	COM_USER REQ_USER" ).append("\n"); 
		query.append("    ,	COM_USER ACCT_USER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   SC_HIST.REQ_USR_ID 	= REQ_USER.USR_ID(+)" ).append("\n"); 
		query.append("    AND SC_HIST.ACCT_USR_ID = ACCT_USER.USR_ID(+)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("ORDER BY SC_NO ASC, SC_EXPT_VER_SEQ DESC" ).append("\n"); 

	}
}