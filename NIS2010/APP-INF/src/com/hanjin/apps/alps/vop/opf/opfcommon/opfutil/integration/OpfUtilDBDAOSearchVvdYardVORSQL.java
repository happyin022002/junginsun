/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OpfUtilDBDAOSearchVvdYardVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2010.04.06 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
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
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration").append("\n"); 
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
		query.append("SELECT  DECODE(SKD_CNG_STS_CD, 'S', NULL, YD_CD) AS VAL," ).append("\n"); 
		query.append("DECODE(SKD_CNG_STS_CD, 'S', NULL, YD_CD) || '|' || DECODE(SKD_CNG_STS_CD, 'S', NULL," ).append("\n"); 
		query.append("(   SELECT  YD_NM" ).append("\n"); 
		query.append("FROM    MDM_YARD" ).append("\n"); 
		query.append("WHERE   YD_CD       =   A.YD_CD" ).append("\n"); 
		query.append(")) AS NAME" ).append("\n"); 
		query.append(",CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD    A" ).append("\n"); 
		query.append("WHERE  VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    TURN_PORT_IND_CD NOT IN ('D','V')" ).append("\n"); 
		query.append("AND    DECODE(TURN_PORT_IND_CD, 'F', DECODE(TURN_SKD_VOY_NO, 'N', 'N', 'F'), 'N') <> 'F'" ).append("\n"); 
		query.append("ORDER BY  CLPT_SEQ" ).append("\n"); 

	}
}