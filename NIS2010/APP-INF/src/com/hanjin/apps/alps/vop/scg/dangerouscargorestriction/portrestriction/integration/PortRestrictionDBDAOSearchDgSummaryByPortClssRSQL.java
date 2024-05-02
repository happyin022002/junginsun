/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOSearchDgSummaryByPortClssRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.12.22 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOSearchDgSummaryByPortClssRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOSearchDgSummaryByPortClssRSQL(){
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
		query.append("FileName : PortRestrictionDBDAOSearchDgSummaryByPortClssRSQL").append("\n"); 
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
		query.append("SELECT    CASE WHEN A.IMDG_CLSS_CD IS NOT NULL THEN '√' END restric_regyn," ).append("\n"); 
		query.append("AA.IMDG_CLSS_CD, AA.IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("@[port_cd] PORT_CD," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_LOD_FLG    = 'N' THEN '' ELSE A.PROHI_LOD_FLG END PROHI_LOD_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_DCHG_FLG   = 'N' THEN '' ELSE A.PROHI_DCHG_FLG END PROHI_DCHG_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_TS_FLG     = 'N' THEN '' ELSE A.PROHI_TS_FLG END PROHI_TS_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_PASS_FLG = 'N' THEN '' ELSE A.PROHI_PASS_FLG END PROHI_PASS_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_DY_TM_OP_FLG = 'N' THEN '' ELSE A.PROHI_DY_TM_OP_FLG END PROHI_DY_TM_OP_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_DY_TM_INLND_TZ_FLG = 'N' THEN '' ELSE A.PROHI_DY_TM_INLND_TZ_FLG END PROHI_DY_TM_INLND_TZ_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_PORT_FLG = 'N' THEN '' ELSE A.PROHI_PORT_FLG END PROHI_PORT_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_NGT_FLG = 'N' THEN '' ELSE A.PROHI_NGT_FLG END PROHI_NGT_FLG" ).append("\n"); 
		query.append(",(SELECT 'Y' FROM SCG_IMDG_PORT_RSTR  S1" ).append("\n"); 
		query.append("WHERE S1.PORT_CD = A.PORT_CD AND S1.IMDG_CLSS_CD=A.IMDG_CLSS_CD  AND ROWNUM=1 AND S1.IMDG_UN_NO   IS NOT NULL" ).append("\n"); 
		query.append("AND INSTR(S1.PROHI_LOD_FLG||S1.PROHI_DCHG_FLG||S1.PROHI_TS_FLG||S1.PROHI_PASS_FLG||" ).append("\n"); 
		query.append("S1.PROHI_DY_TM_OP_FLG||S1.PROHI_DY_TM_INLND_TZ_FLG||S1.PROHI_PORT_FLG||S1.PROHI_NGT_FLG, 'Y') > 0" ).append("\n"); 
		query.append(") UNNO_EXIST_YN" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT    A.*" ).append("\n"); 
		query.append("FROM    SCG_IMDG_CLSS_CD A" ).append("\n"); 
		query.append("WHERE    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.IMDG_CLSS_CD" ).append("\n"); 
		query.append(") AA, SCG_IMDG_PORT_RSTR A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} == '')" ).append("\n"); 
		query.append("AA.IMDG_CLSS_CD   = A.IMDG_CLSS_CD(+)" ).append("\n"); 
		query.append("AND    A.PORT_CD(+)      =  @[port_cd]" ).append("\n"); 
		query.append("AND    A.IMDG_UN_NO(+)   IS  NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AA.IMDG_CLSS_CD   = A.IMDG_CLSS_CD" ).append("\n"); 
		query.append("AND    A.PORT_CD      =  @[port_cd]" ).append("\n"); 
		query.append("AND    A.IMDG_UN_NO   IS  NULL" ).append("\n"); 
		query.append("AND    A.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AA.IMDG_CLSS_CD" ).append("\n"); 

	}
}