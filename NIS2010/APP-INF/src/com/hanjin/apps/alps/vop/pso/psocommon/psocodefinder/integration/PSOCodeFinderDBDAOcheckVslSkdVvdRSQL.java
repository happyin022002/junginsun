/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PSOCodeFinderDBDAOcheckVslSkdVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.15 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSOCodeFinderDBDAOcheckVslSkdVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD가 SKD(VSK_VSL_PORT_SKD) 에 존재하는지 체크
	  * 
	  * * History
	  * * 2012.03.05 진마리아 CHM-201216583-01 Port Charge Invoice Creation 로직 변경 - 스케줄 존재 여부 점검 로직 추가 / KRPUS 스케줄에 대해 'Actual SKD 존재 체크' 로직 제외
	  * </pre>
	  */
	public PSOCodeFinderDBDAOcheckVslSkdVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration").append("\n"); 
		query.append("FileName : PSOCodeFinderDBDAOcheckVslSkdVvdRSQL").append("\n"); 
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
		query.append("SELECT MAX(FLAG) FLAG" ).append("\n"); 
		query.append("FROM   (SELECT NVL(MAX(1), 0) FLAG" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("        AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND YD_CD      = @[yd_cd]" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT NVL(MAX(1), 0) FLAG" ).append("\n"); 
		query.append("        FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append("        AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("        AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}