/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortRestrictionDBDAOSearchDgRestrictionSummaryByPortClssRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOSearchDgRestrictionSummaryByPortClssRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOSearchDgRestrictionSummaryByPortClssRSQL(){
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
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOSearchDgRestrictionSummaryByPortClssRSQL").append("\n"); 
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
		query.append("        CASE WHEN B.IMDG_CLSS_CD IS NOT NULL THEN '√' END RESTRIC_REGYN," ).append("\n"); 
		query.append("        AA.IMDG_CLSS_CD, AA.IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("        (SELECT A2.IMDG_CLSS_CD_DESC FROM  SCG_IMDG_CLSS_CD A2 WHERE A2.IMDG_CLSS_CD = B.IMDG_CLSS_CD )IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("        @[port_cd] PORT_CD," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  DECODE(B.PROHI_LOD_FLG, 'Y', 'Prohibition', DECODE(A.IMDG_CMPTN_AUTH_CD, 'P', 'PERMIT', 'D', 'DECLARE', 'N', 'NOT NEED') )" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_PORT_RSTR_DTL  A" ).append("\n"); 
		query.append("        WHERE   A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("        AND     A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("        AND     A.PORT_PROHI_TP_CD  = 'L'" ).append("\n"); 
		query.append("        )   LOAD_TYPE," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  DECODE(B.PROHI_DCHG_FLG, 'Y', 'Prohibition', DECODE(A.IMDG_CMPTN_AUTH_CD, 'P', 'PERMIT', 'D', 'DECLARE', 'N', 'NOT NEED') )" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_PORT_RSTR_DTL  A" ).append("\n"); 
		query.append("        WHERE   A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("        AND     A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("        AND     A.PORT_PROHI_TP_CD  = 'D'" ).append("\n"); 
		query.append("        )   DISCHARGE," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  DECODE(B.PROHI_TS_FLG, 'Y', 'Prohibition', DECODE(A.IMDG_CMPTN_AUTH_CD, 'P', 'PERMIT', 'D', 'DECLARE', 'N', 'NOT NEED') )" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_PORT_RSTR_DTL  A" ).append("\n"); 
		query.append("        WHERE   A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("        AND     A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("        AND     A.PORT_PROHI_TP_CD  = 'T'" ).append("\n"); 
		query.append("        )   TS," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  DECODE(B.PROHI_PASS_FLG, 'Y', 'Prohibition', DECODE(A.IMDG_CMPTN_AUTH_CD, 'P', 'PERMIT', 'D', 'DECLARE', 'N', 'NOT NEED') )" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_PORT_RSTR_DTL  A" ).append("\n"); 
		query.append("        WHERE   A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("        AND     A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("        AND     A.PORT_PROHI_TP_CD  = 'P'" ).append("\n"); 
		query.append("        )   PASS," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  TXT_DESC" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_PORT_RSTR_DTL  A" ).append("\n"); 
		query.append("        WHERE   A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("        AND     A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("        AND     A.PORT_PROHI_TP_CD  = 'L'" ).append("\n"); 
		query.append("        )   LOAD_TYPE_DESC," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  TXT_DESC" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_PORT_RSTR_DTL  A" ).append("\n"); 
		query.append("        WHERE   A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("        AND     A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("        AND     A.PORT_PROHI_TP_CD  = 'D'" ).append("\n"); 
		query.append("        )   DISCHARGE_DESC," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  TXT_DESC" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_PORT_RSTR_DTL  A" ).append("\n"); 
		query.append("        WHERE   A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("        AND     A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("        AND     A.PORT_PROHI_TP_CD  = 'T'" ).append("\n"); 
		query.append("        )   TS_DESC," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  TXT_DESC" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_PORT_RSTR_DTL  A" ).append("\n"); 
		query.append("        WHERE   A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("        AND     A.IMDG_PORT_RSTR_SEQ = B.IMDG_PORT_RSTR_SEQ" ).append("\n"); 
		query.append("        AND     A.PORT_PROHI_TP_CD  = 'P'" ).append("\n"); 
		query.append("        )   PASS_DESC" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM    SCG_IMDG_PORT_RSTR B," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT    A.*" ).append("\n"); 
		query.append("        FROM    SCG_IMDG_CLSS_CD A" ).append("\n"); 
		query.append("        WHERE    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        ORDER BY A.IMDG_CLSS_CD" ).append("\n"); 
		query.append("        ) AA" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("--AND   B.PORT_CD = 'KRPUS'" ).append("\n"); 
		query.append("--AND   AA.IMDG_CLSS_CD   = B.IMDG_CLSS_CD(+)" ).append("\n"); 
		query.append("--AND   B.IMDG_UN_NO(+)   IS  NULL" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} == '')" ).append("\n"); 
		query.append("  AND   AA.IMDG_CLSS_CD   = B.IMDG_CLSS_CD(+)" ).append("\n"); 
		query.append("  AND   B.PORT_CD(+)      =  @[port_cd]" ).append("\n"); 
		query.append("  AND   B.IMDG_UN_NO(+)   IS  NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND   AA.IMDG_CLSS_CD   = B.IMDG_CLSS_CD" ).append("\n"); 
		query.append("  AND   B.PORT_CD      =  @[port_cd]" ).append("\n"); 
		query.append("  AND   B.IMDG_UN_NO   IS  NULL" ).append("\n"); 
		query.append("  AND   B.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AA.IMDG_CLSS_CD" ).append("\n"); 

	}
}