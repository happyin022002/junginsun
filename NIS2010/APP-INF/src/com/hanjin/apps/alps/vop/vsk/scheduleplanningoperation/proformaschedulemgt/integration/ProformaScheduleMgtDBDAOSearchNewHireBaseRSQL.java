/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchNewHireBaseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2010.01.13 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchNewHireBaseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNewHireBase
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchNewHireBaseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchNewHireBaseRSQL").append("\n"); 
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
		query.append("SELECT  '' AS VSL_OWNR_FLG, TO_NUMBER(NVL(@[n1st_vsl_clss_cd],'0')) AS VSL_CSL1, TO_NUMBER(NVL(@[n2nd_vsl_clss_cd],'0')) AS VSL_CSL2,  TO_NUMBER(NVL(@[n3rd_vsl_clss_cd],'0')) AS VSL_CSL3 FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append(", NVL( ROUND(AVG(DECODE(T2.CNTR_VSL_CLSS_CAPA, @[n1st_vsl_clss_cd], T1.DHIR_AMT / T2.CNTR_VSL_CLSS_CAPA)), 1), 0 ) AS DAILY_HIRE_BY_CLASS01" ).append("\n"); 
		query.append(", NVL( ROUND(AVG(DECODE(T2.CNTR_VSL_CLSS_CAPA, @[n2nd_vsl_clss_cd], T1.DHIR_AMT / T2.CNTR_VSL_CLSS_CAPA)), 1), 0 ) AS DAILY_HIRE_BY_CLASS02" ).append("\n"); 
		query.append(", NVL( ROUND(AVG(DECODE(T2.CNTR_VSL_CLSS_CAPA, @[n3rd_vsl_clss_cd], T1.DHIR_AMT / T2.CNTR_VSL_CLSS_CAPA)), 1), 0 ) AS DAILY_HIRE_BY_CLASS03" ).append("\n"); 
		query.append("FROM    VSK_DLY_HIR T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("WHERE   1   = 1" ).append("\n"); 
		query.append("AND     T1.VSL_CD   = T2.VSL_CD" ).append("\n"); 
		query.append("AND     PLN_YR      = @[slt_prc_wrk_yr]" ).append("\n"); 
		query.append("AND     T2.CNTR_VSL_CLSS_CAPA IN (@[n1st_vsl_clss_cd], @[n2nd_vsl_clss_cd], @[n3rd_vsl_clss_cd])" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'N',0,0,0 FROM DUAL" ).append("\n"); 

	}
}