/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchRDRCreNextPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOSearchRDRCreNextPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchRDRCreNextPortListRSQL(){
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOSearchRDRCreNextPortListRSQL").append("\n"); 
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
		query.append("SELECT (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("        FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("        WHERE  VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("        AND    SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    CLPT_SEQ = (SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                WHERE  VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("                AND    SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND    SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND    CLPT_SEQ > P.CLPT_SEQ" ).append("\n"); 
		query.append("                AND    NVL(SKD_CNG_STS_CD, '-') != 'S'" ).append("\n"); 
		query.append("                AND    VPS_PORT_CD NOT IN ('PAPCA', 'EGSCA') ) ) AS NEXT_PORT," ).append("\n"); 
		query.append("       (SELECT TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("        FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("        WHERE  VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("        AND    SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    CLPT_SEQ = (SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                WHERE  VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("                AND    SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND    SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND    CLPT_SEQ > P.CLPT_SEQ" ).append("\n"); 
		query.append("                AND    NVL(SKD_CNG_STS_CD, '-') != 'S'" ).append("\n"); 
		query.append("                AND    VPS_PORT_CD NOT IN ('PAPCA', 'EGSCA') ) ) AS ETA ," ).append("\n"); 
		query.append("       ''ETA_CANAL ," ).append("\n"); 
		query.append("       ''NEXT_CANAL" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD P," ).append("\n"); 
		query.append("       VSK_ACT_PORT_SKD A" ).append("\n"); 
		query.append("WHERE  P.VSL_CD       =	@[vsl_cd]" ).append("\n"); 
		query.append("AND	   P.SKD_VOY_NO   =	@[voy_no]" ).append("\n"); 
		query.append("AND	   P.SKD_DIR_CD   =	@[dir_cd]" ).append("\n"); 
		query.append("AND	   P.VPS_PORT_CD  =	@[port_cd]" ).append("\n"); 
		query.append("AND    P.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND    P.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    P.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    P.VPS_PORT_CD = A.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    P.CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 

	}
}