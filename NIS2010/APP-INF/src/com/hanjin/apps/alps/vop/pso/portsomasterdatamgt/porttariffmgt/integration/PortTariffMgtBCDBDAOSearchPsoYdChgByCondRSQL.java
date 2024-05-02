/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchPsoYdChgByCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchPsoYdChgByCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchPsoYdChgByCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchPsoYdChgByCondRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CHG_NO" ).append("\n"); 
		query.append("      ,A.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("      ,A.YD_CD" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.CPLS_FLG" ).append("\n"); 
		query.append("      ,A.LST_FLG " ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,B.VNDR_LGL_ENG_NM  VNDR_NM" ).append("\n"); 
		query.append("	  ,'' PORT_CD" ).append("\n"); 
		query.append("      ,'' YARD_CD" ).append("\n"); 
		query.append("      ,'' FROM_DATE" ).append("\n"); 
		query.append("      ,'' TO_DATE" ).append("\n"); 
		query.append("      ,C.ACCT_CD      ACCT_CD" ).append("\n"); 
		query.append("      ,A.LGS_COST_CD  COST_CD" ).append("\n"); 
		query.append("      ,( SELECT MAX(YD_CHG_VER_SEQ) " ).append("\n"); 
		query.append("           FROM PSO_YD_CHG X " ).append("\n"); 
		query.append("          WHERE X.YD_CHG_NO = A.YD_CHG_NO ) AS YD_CHG_MAX_SEQ" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG   A" ).append("\n"); 
		query.append("      ,MDM_VENDOR   B " ).append("\n"); 
		query.append("      ,TES_LGS_COST C" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Period" ).append("\n"); 
		query.append("AND    A.EFF_DT <= TO_DATE(NVL(REPLACE(@[to_dt],   '-', ''), '99991231'), 'YYYYMMDD')    -- to_dt  가 없을 경우, '99991231'" ).append("\n"); 
		query.append("AND    A.EXP_DT >= TO_DATE(NVL(REPLACE(@[from_dt], '-', ''), '10000101'), 'YYYYMMDD')    -- from_dt가 없을 경우, '10000101'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Port" ).append("\n"); 
		query.append("#if(${yard_cd} != '')" ).append("\n"); 
		query.append("AND    A.YD_CD IN (#foreach($key IN ${arr_yard_cd}) " ).append("\n"); 
		query.append("       		           #if($velocityCount < $arr_yard_cd.size())" ).append("\n"); 
		query.append("  		                   @[port_cd] || '$key'," ).append("\n"); 
		query.append("		               #else" ).append("\n"); 
		query.append("		                   @[port_cd] || '$key'" ).append("\n"); 
		query.append("		               #end" ).append("\n"); 
		query.append("	               #end)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if(${port_cd} != '')" ).append("\n"); 
		query.append("AND    A.YD_CD LIKE @[port_cd] || '__'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Account" ).append("\n"); 
		query.append("#if(${cost_cd} != '')" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if(${acct_cd} != '')" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD IN (SELECT X.LGS_COST_CD                         " ).append("\n"); 
		query.append("                         FROM   TES_LGS_COST X" ).append("\n"); 
		query.append("                               ,MDM_ACCOUNT  Y " ).append("\n"); 
		query.append("                         WHERE  1=1" ).append("\n"); 
		query.append("                         AND    X.ACCT_CD = Y.ACCT_CD" ).append("\n"); 
		query.append("                         AND    X.LGS_COST_SUBJ_CD IN ('PT', 'CN')" ).append("\n"); 
		query.append("                         AND    X.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("                         AND    Y.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD = C.LGS_COST_CD" ).append("\n"); 
		query.append("ORDER  BY A.YD_CD" ).append("\n"); 
		query.append("         ,C.ACCT_CD" ).append("\n"); 
		query.append("         ,A.LGS_COST_CD" ).append("\n"); 
		query.append("         ,A.YD_CHG_VER_SEQ" ).append("\n"); 

	}
}