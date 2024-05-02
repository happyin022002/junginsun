/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchVslClssByVskdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.23 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchVslClssByVskdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVslClssByVskd
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchVslClssByVskdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration ").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchVslClssByVskdRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT (SELECT CNTR_VSL_CLSS_CAPA FROM MDM_VSL_CNTR S1 WHERE S1.VSL_CD = T2.VSL_CD) AS VSL_CLASS" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD T1, VSK_VSL_SKD T2" ).append("\n"); 
		query.append("WHERE   T1.VSL_CD               = T2.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO           = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD           = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.VPS_ETB_DT           BETWEEN TO_DATE(@[slt_prc_wrk_yr]|| CASE WHEN @[bse_qtr_cd] = '1Q' THEN '01' WHEN @[bse_qtr_cd] = '2Q' THEN '04' WHEN @[bse_qtr_cd] = '3Q' THEN '07' ELSE '10' END, 'YYYYMM')" ).append("\n"); 
		query.append("AND     LAST_DAY(TO_DATE(@[slt_prc_wrk_yr]|| CASE WHEN @[bse_qtr_cd] = '1Q' THEN '03' WHEN @[bse_qtr_cd] = '2Q' THEN '06' WHEN @[bse_qtr_cd] = '3Q' THEN '09' ELSE '12' END, 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("AND     T2.VSL_SLAN_CD          = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND     T2.PF_SKD_TP_CD         = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}