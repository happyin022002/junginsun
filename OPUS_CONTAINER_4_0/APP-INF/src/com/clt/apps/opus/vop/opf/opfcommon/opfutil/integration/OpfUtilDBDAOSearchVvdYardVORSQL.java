/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OpfUtilDBDAOSearchVvdYardVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOSearchVvdYardVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VvdYard
	  * </pre>
	  */
	public OpfUtilDBDAOSearchVvdYardVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOSearchVvdYardVORSQL").append("\n"); 
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
		query.append("SELECT A.YD_CD AS VAL," ).append("\n"); 
		query.append("       A.YD_CD || '|' || B.YD_NM || '|' || " ).append("\n"); 
		query.append("           CASE WHEN A.SKD_CNG_STS_CD = 'S' THEN 'SKIP'" ).append("\n"); 
		query.append("                WHEN C.LOC_CD  = 'EGSCA' THEN 'CANAL'" ).append("\n"); 
		query.append("                WHEN C.LOC_CD  = 'PAPCA' THEN 'CANAL'" ).append("\n"); 
		query.append("           END  AS NAME," ).append("\n"); 
		query.append("       A.CLPT_IND_SEQ," ).append("\n"); 
		query.append("       C.LOC_CD" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("       MDM_YARD B," ).append("\n"); 
		query.append("       MDM_LOCATION C" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND A.TURN_PORT_IND_CD NOT IN ('D',  'V')" ).append("\n"); 
		query.append("   AND DECODE(A.TURN_PORT_IND_CD, 'F', DECODE(A.TURN_SKD_VOY_NO, 'N', 'N', 'F'), 'N') <> 'F'" ).append("\n"); 
		query.append("   AND A.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("   AND A.YD_CD = B.YD_CD(+)" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD = C.LOC_CD(+)" ).append("\n"); 
		query.append(" ORDER BY CLPT_SEQ " ).append("\n"); 

	}
}