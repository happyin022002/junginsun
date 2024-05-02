/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortRestrictionDBDAOSearchDgSummaryByPortUnnoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOSearchDgSummaryByPortUnnoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOSearchDgSummaryByPortUnnoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOSearchDgSummaryByPortUnnoRSQL").append("\n"); 
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
		query.append("SELECT       XX.RESTRIC_REGYN" ).append("\n"); 
		query.append("          ,  NVL(XX.IMDG_AMDT_NO,'CFR')  AS IMDG_AMDT_NO" ).append("\n"); 
		query.append("          ,  XX.IMDG_CLSS_CD " ).append("\n"); 
		query.append("          ,  XX.IMDG_CLSS_CD_DESC " ).append("\n"); 
		query.append("          ,  XX.PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,  XX.EFF_FM_DT" ).append("\n"); 
		query.append("          ,  XX.IMDG_UN_NO" ).append("\n"); 
		query.append("          ,  XX.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          ,  XX.PROHI_LOD_FLG" ).append("\n"); 
		query.append("          ,  XX.PROHI_DCHG_FLG           " ).append("\n"); 
		query.append("          ,  XX.PROHI_TS_FLG" ).append("\n"); 
		query.append("          ,  XX.PROHI_PASS_FLG" ).append("\n"); 
		query.append("          ,  XX.PROHI_DY_TM_OP_FLG           " ).append("\n"); 
		query.append("          ,  XX.PROHI_DY_TM_INLND_TZ_FLG           " ).append("\n"); 
		query.append("          ,  XX.PROHI_PORT_FLG           " ).append("\n"); 
		query.append("          ,  XX.PROHI_NGT_FLG" ).append("\n"); 
		query.append("FROM       (" ).append("\n"); 
		query.append("           ------------------------------------------------------" ).append("\n"); 
		query.append("SELECT     CASE WHEN A.IMDG_CLSS_CD IS NOT NULL THEN '√' END restric_regyn," ).append("\n"); 
		query.append("           A.IMDG_CLSS_CD, " ).append("\n"); 
		query.append("           (SELECT A2.IMDG_CLSS_CD_DESC FROM  SCG_IMDG_CLSS_CD A2 WHERE A2.IMDG_CLSS_CD = A.IMDG_CLSS_CD )IMDG_CLSS_CD_DESC, " ).append("\n"); 
		query.append("           @[port_cd] PORT_CD," ).append("\n"); 
		query.append("           (SELECT IMDG_AMDT_NO " ).append("\n"); 
		query.append("            FROM SCG_IMDG_UN_NO " ).append("\n"); 
		query.append("            WHERE IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("              AND IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ) " ).append("\n"); 
		query.append("           IMDG_AMDT_NO," ).append("\n"); 
		query.append("           A.IMDG_UN_NO," ).append("\n"); 
		query.append("           A.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("           CASE WHEN A.PROHI_LOD_FLG    = 'N' THEN '' ELSE A.PROHI_LOD_FLG END PROHI_LOD_FLG," ).append("\n"); 
		query.append("           CASE WHEN A.PROHI_DCHG_FLG   = 'N' THEN '' ELSE A.PROHI_DCHG_FLG END PROHI_DCHG_FLG,           " ).append("\n"); 
		query.append("           CASE WHEN A.PROHI_TS_FLG     = 'N' THEN '' ELSE A.PROHI_TS_FLG END PROHI_TS_FLG," ).append("\n"); 
		query.append("           CASE WHEN A.PROHI_PASS_FLG   = 'N' THEN '' ELSE A.PROHI_PASS_FLG END PROHI_PASS_FLG," ).append("\n"); 
		query.append("           CASE WHEN A.PROHI_DY_TM_OP_FLG = 'N' THEN '' ELSE A.PROHI_DY_TM_OP_FLG END PROHI_DY_TM_OP_FLG,           " ).append("\n"); 
		query.append("           CASE WHEN A.PROHI_DY_TM_INLND_TZ_FLG = 'N' THEN '' ELSE A.PROHI_DY_TM_INLND_TZ_FLG END PROHI_DY_TM_INLND_TZ_FLG,           " ).append("\n"); 
		query.append("           CASE WHEN A.PROHI_PORT_FLG = 'N' THEN '' ELSE A.PROHI_PORT_FLG END PROHI_PORT_FLG,           " ).append("\n"); 
		query.append("           CASE WHEN A.PROHI_NGT_FLG  = 'N' THEN '' ELSE A.PROHI_NGT_FLG END PROHI_NGT_FLG," ).append("\n"); 
		query.append("           (SELECT EFF_FM_DT " ).append("\n"); 
		query.append("            FROM SCG_IMDG_AMDT_MST M, SCG_IMDG_UN_NO U" ).append("\n"); 
		query.append("            WHERE U.IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("              AND U.IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("              AND M.IMDG_AMDT_NO = U.IMDG_AMDT_NO) " ).append("\n"); 
		query.append("           EFF_FM_DT" ).append("\n"); 
		query.append("   FROM    	SCG_IMDG_PORT_RSTR	A " ).append("\n"); 
		query.append("		,	SCG_IMDG_UN_NO 		UN" ).append("\n"); 
		query.append("  WHERE		1 = 1" ).append("\n"); 
		query.append("	AND		UN.IMDG_UN_NO  		= A.IMDG_UN_NO		(+)" ).append("\n"); 
		query.append("	AND		UN.IMDG_UN_NO_SEQ	= A.IMDG_UN_NO_SEQ	(+)" ).append("\n"); 
		query.append("	AND		A.PORT_CD   		= @[port_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --:2015-12-22:--AND    	A.IMDG_UN_NO   		IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --:2015-12-22:--AND    	A.IMDG_UN_NO 		= [imdg_un_no]" ).append("\n"); 
		query.append("    AND    	UN.IMDG_UN_NO 		= @[imdg_un_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ------------------------------------------------------" ).append("\n"); 
		query.append("           ) XX" ).append("\n"); 
		query.append("WHERE		1 = 1" ).append("\n"); 
		query.append("AND			(EXISTS				(SELECT	''" ).append("\n"); 
		query.append("								 FROM	SCG_IMDG_AMDT_MST	YY" ).append("\n"); 
		query.append("								 WHERE	YY.IMDG_AMDT_NO		= XX.IMDG_AMDT_NO" ).append("\n"); 
		query.append("								 AND	YY.ACT_FLG			= 'Y'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("			 OR					 XX.IMDG_AMDT_NO IS NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY   XX.IMDG_AMDT_NO   	DESC" ).append("\n"); 
		query.append("      	,  XX.IMDG_CLSS_CD   	ASC" ).append("\n"); 
		query.append("      	,  XX.EFF_FM_DT      	DESC" ).append("\n"); 
		query.append("      	,  XX.IMDG_UN_NO     	ASC" ).append("\n"); 
		query.append("      	,  XX.IMDG_UN_NO_SEQ 	ASC" ).append("\n"); 

	}
}