/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OpfUtilDBDAOSearchVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.10 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOSearchVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OpfUtilDBDAOSearchVvdPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOSearchVvdPortRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(SKD_CNG_STS_CD, 'S', NULL, VPS_PORT_CD) AS VAL," ).append("\n"); 
		query.append("DECODE(SKD_CNG_STS_CD, 'S', NULL, VPS_PORT_CD) || '|' || DECODE(SKD_CNG_STS_CD, 'S', NULL," ).append("\n"); 
		query.append("( SELECT  LOC_NM" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD       =   A.VPS_PORT_CD )) AS NAME" ).append("\n"); 
		query.append(",A.CLPT_IND_SEQ CALL_IND" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD    A" ).append("\n"); 
		query.append("WHERE  VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND    TURN_PORT_IND_CD NOT IN ('D','V')" ).append("\n"); 
		query.append("AND    DECODE(TURN_PORT_IND_CD, 'F', DECODE(TURN_SKD_VOY_NO, 'N', 'N', 'F'), 'N') <> 'F'" ).append("\n"); 
		query.append("AND    ( VPS_PORT_CD, CLPT_SEQ ) IN ( SELECT VPS_PORT_CD, MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("GROUP BY VPS_PORT_CD )" ).append("\n"); 
		query.append("ORDER BY  CLPT_SEQ" ).append("\n"); 

	}
}