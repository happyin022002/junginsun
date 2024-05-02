/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOSearchDgSummaryByPortUnnoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.11.09 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
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
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
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
		query.append("SELECT     CASE WHEN A.IMDG_CLSS_CD IS NOT NULL THEN '√' END restric_regyn," ).append("\n"); 
		query.append("A.IMDG_CLSS_CD," ).append("\n"); 
		query.append("(SELECT A2.IMDG_CLSS_CD_DESC FROM  SCG_IMDG_CLSS_CD A2 WHERE A2.IMDG_CLSS_CD = A.IMDG_CLSS_CD )IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("@[port_cd] PORT_CD," ).append("\n"); 
		query.append("A.IMDG_UN_NO," ).append("\n"); 
		query.append("A.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_LOD_FLG    = 'N' THEN '' ELSE A.PROHI_LOD_FLG END PROHI_LOD_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_DCHG_FLG   = 'N' THEN '' ELSE A.PROHI_DCHG_FLG END PROHI_DCHG_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_TS_FLG     = 'N' THEN '' ELSE A.PROHI_TS_FLG END PROHI_TS_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_PASS_FLG   = 'N' THEN '' ELSE A.PROHI_PASS_FLG END PROHI_PASS_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_DY_TM_OP_FLG = 'N' THEN '' ELSE A.PROHI_DY_TM_OP_FLG END PROHI_DY_TM_OP_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_DY_TM_INLND_TZ_FLG = 'N' THEN '' ELSE A.PROHI_DY_TM_INLND_TZ_FLG END PROHI_DY_TM_INLND_TZ_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_PORT_FLG = 'N' THEN '' ELSE A.PROHI_PORT_FLG END PROHI_PORT_FLG," ).append("\n"); 
		query.append("CASE WHEN A.PROHI_NGT_FLG  = 'N' THEN '' ELSE A.PROHI_NGT_FLG END PROHI_NGT_FLG" ).append("\n"); 
		query.append("FROM    SCG_IMDG_PORT_RSTR A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.PORT_CD      = @[port_cd]" ).append("\n"); 
		query.append("AND    A.IMDG_UN_NO   IS NOT NULL" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("AND    A.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY   A.IMDG_CLSS_CD, A.IMDG_UN_NO, A.IMDG_UN_NO_SEQ" ).append("\n"); 

	}
}