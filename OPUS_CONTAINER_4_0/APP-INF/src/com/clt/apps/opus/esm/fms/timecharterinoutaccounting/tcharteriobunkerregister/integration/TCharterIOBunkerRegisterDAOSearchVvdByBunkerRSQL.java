/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOSearchVvdByBunkerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOSearchVvdByBunkerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOSearchVvdByBunkerRSQL
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOSearchVvdByBunkerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOSearchVvdByBunkerRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("  FROM (SELECT VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD VVD" ).append("\n"); 
		query.append("             , @[flet_ctrt_tp_cd]" ).append("\n"); 
		query.append("             , DECODE(M.REP_TRD_CD,'COM','Y','N') AS COM_VVD_FLG" ).append("\n"); 
		query.append("             , DECODE(@[flet_ctrt_tp_cd], 'TI',DECODE(M.REP_TRD_CD,'COM','1','0'), DECODE(M.REP_TRD_CD,'COM','0','1')) AS ORD" ).append("\n"); 
		query.append("          FROM FMS_VVD V" ).append("\n"); 
		query.append("             , MDM_REV_LANE M" ).append("\n"); 
		query.append("         WHERE V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND REPLACE(@[bunker_dt],'-') BETWEEN V.VST_DT AND V.VED_DT" ).append("\n"); 
		query.append("           AND V.RLANE_CD = M.RLANE_CD " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${flet_ctrt_tp_cd} != '' && ${flet_ctrt_tp_cd} == 'TO') " ).append("\n"); 
		query.append("   AND A.COM_VVD_FLG = 'Y' /*TO : 대선은 공통선박 만 조회*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.ORD" ).append("\n"); 

	}
}